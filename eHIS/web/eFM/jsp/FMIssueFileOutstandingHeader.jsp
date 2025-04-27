<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMIssueFiles.js'></script>
	<script language="javascript" src="../../eCommon/js/rowcolor.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<%
	Connection con				= ConnectionManager.getConnection(request);
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	
	String Title				= "";
	String Firreqon				= "";
	String Firreqno				= "";
	String Firreqfacilityid		= "";
	String Firreqfacilityname	= "";
	String Firreqfslocncode		= "";
	String Firreqfslocndesc		= "";
	String Firreqfslocnidentity	= "";
	String Firreqlocnismrlocnyn	= "";
	String Firreqby				= "";
	String Firreqbyname			= "";
	String Firnarrationcode		= "";
	String Firnarrationdesc		= "";
	String classValue			= "";
	String facility_id			= "";
	String resLocnIdentities	= "";
	String Locations			= "";
	String no_of_days			= "";
	String fac_id				= "";
	String no_of_recs			= "";
	String issueLocn			= "";
	String s_file_no			= "";
	String s_file_type			= "";
	String s_volume_no			= "";
	String file_type_yn			= "";
	String reqfslocnidendesc	= "";
	String Reqfslocnid			= "";

	StringBuffer SelectSqlBuffer = null;
	SelectSqlBuffer				 = new StringBuffer();	
	
	int reccount	= 0;
	int i			= 1;
	int rowid		= 1;
%>
<body OnMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
	<form name='IssueOutstandingHeader' id='IssueOutstandingHeader'>
		<table border="1" cellpadding="0" cellspacing="0" width='100%'>
			<tr><td id='rowtitle' class='label'><b><%=Title%></b></td><tr>
			</table>
			<table id='tb1' border="1" cellpadding="0" cellspacing="0" width='100%'>
			<tr><th><fmt:message key="Common.RequestedOn.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eFM.NoofFiles.label" bundle="${fm_labels}"/></th>
			<th><fmt:message key="eFM.RequestedFrom.label" bundle="${fm_labels}"/></th>
			<th><fmt:message key="Common.RequestedBy.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.RequestNo.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eFM.ReasonForBorrowing.label" bundle="${fm_labels}"/></th></tr>
	<%
	try
	{
		facility_id			= (String) session.getValue("facility_id");
		String userSecurity			= checkForNull(request.getParameter("userSecurity"));
		String strLocn				= checkForNull(request.getParameter("strLocn"));

		
		String access_all			= request.getParameter("access_all")==null?"":request.getParameter("access_all");

		resLocnIdentities	= request.getParameter("resLocnIdentities");
		Locations			= request.getParameter("Locations");
		no_of_days			= request.getParameter("no_of_days");
		fac_id				= request.getParameter("facid");
		no_of_recs			= request.getParameter("noofrecs");
		issueLocn			= request.getParameter("issueLocn");
		s_file_no			= request.getParameter("s_file_no");
		s_file_type			= request.getParameter("s_file_type");
		s_volume_no			= request.getParameter("s_volume_no");
		file_type_yn		= request.getParameter("file_type_yn");
		
		s_file_type	= ((s_file_type == null) || (s_file_type.equals("null"))) ? "" : s_file_type;
		s_volume_no	= ((s_volume_no == null) || (s_volume_no.equals("null"))) ? "" : s_volume_no;

	
		SelectSqlBuffer.append("Select to_char(A.ADDED_DATE,'DD/MM/YYYY HH24:MI') REQ_ON, A.REQ_NO, A.REQ_FACILITY_ID, A.REQ_FACILITY_NAME, A.REQ_FS_LOCN_CODE, A.REQ_FS_LOCN_DESC, A.REQ_BY, A.REQ_BY_NAME, A.NARRATION_CODE, A.NARRATION_DESC, DECODE(A.req_FS_LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') IDENTITY, A.req_fs_LOCN_IDENTITY LOCN_IDENTITY, A.MR_LOCN_YN, Count(C.FILE_NO) CNT, A.REQUESTING_FROM_DESC, A.REQUESTING_FROM,C.FILE_NO,C.VOLUME_NO from FM_REQ_HDR_VW A, FM_REQ_DTL C, FM_CURR_LOCN D WHERE A.REQ_FACILITY_ID = ? AND A.REQ_FS_LOCN_CODE = ? AND A.ISS_COMPLETED_YN = 'N' AND A.REQ_NO = C.REQ_NO AND C.FILE_NO = D.FILE_NO AND C.VOLUME_NO = D.VOLUME_NO AND C.REQ_TO_FACILITY_ID = ? AND  C.REQ_TO_FS_LOCN_CODE = ? AND C.ISS_YN = 'N' AND C.DOC_TYPE_CODE is null  AND C.CANCEL_YN='N' AND A.REQ_FS_LOCN_CODE != D.CURR_FS_LOCN_CODE ");
		
		if(!(s_file_no.equals("null") || s_file_no.equals("")))
			SelectSqlBuffer.append("AND C.FILE_NO = '"+s_file_no+"' ");
		
		if((!s_volume_no.equals("")) && (!s_volume_no.equals("null")))
			SelectSqlBuffer.append("AND C.VOLUME_NO = '"+s_volume_no+"' ");
	
		SelectSqlBuffer.append("GROUP BY A.ADDED_DATE, A.REQ_NO, A.REQ_FACILITY_ID, A.REQ_FACILITY_NAME, A.REQ_FS_LOCN_CODE, A.REQ_FS_LOCN_DESC, A.REQ_BY, A.REQ_BY_NAME, A.NARRATION_CODE, A.NARRATION_DESC, A.req_fs_LOCN_IDENTITY, A.MR_LOCN_YN, A.REQUESTING_FROM_DESC,A.REQUESTING_FROM,C.FILE_NO,C.VOLUME_NO ORDER BY A.ADDED_DATE DESC");
		
		pstmt = con.prepareStatement(SelectSqlBuffer.toString());
		
		pstmt.setString(1,fac_id);
		pstmt.setString(2,Locations);
		pstmt.setString(3,facility_id);
		pstmt.setString(4,issueLocn);
		
		rs = pstmt.executeQuery();

		while(rs != null && rs.next())
		{
			if(i % 2 == 0) classValue = "QRYEVEN" ;
			else classValue = "QRYODD" ;

				if(i == 1)
				{
					Firreqon				= rs.getString("REQ_ON");
					Firreqno				= rs.getString("REQ_NO");
					Firreqfacilityid		= rs.getString("REQ_FACILITY_ID");
					Firreqfacilityname		= rs.getString("REQ_FACILITY_NAME");
					Firreqfslocncode		= rs.getString("REQ_FS_LOCN_CODE");
					Firreqfslocndesc		= rs.getString("REQ_FS_LOCN_DESC");
					Firreqfslocnidentity	= rs.getString("LOCN_IDENTITY");
					Firreqlocnismrlocnyn	= rs.getString("MR_LOCN_YN");
					Firreqby				= rs.getString("REQ_BY");
					Firreqbyname			= rs.getString("REQ_BY_NAME");
					Firnarrationcode		= rs.getString("NARRATION_CODE");
					Firnarrationdesc		= rs.getString("NARRATION_DESC");
					Reqfslocnid				= rs.getString("REQUESTING_FROM");
					
				}

				String reqon				= rs.getString("REQ_ON");
				String reqno				= rs.getString("REQ_NO");
				String reqfacilityid		= rs.getString("REQ_FACILITY_ID");
				String reqfacilityname		= rs.getString("REQ_FACILITY_NAME");
				String reqfslocncode		= rs.getString("REQ_FS_LOCN_CODE");
				String reqfslocndesc		= rs.getString("REQ_FS_LOCN_DESC");
				String reqfslocnidentity	= rs.getString("LOCN_IDENTITY");
				reqfslocnidendesc	= rs.getString("REQUESTING_FROM_DESC");	
				String reqlocnismrlocnyn	= rs.getString("MR_LOCN_YN");
				String reqby				= rs.getString("REQ_BY");
				String reqbyname			= rs.getString("REQ_BY_NAME");
				String narrationcode		= rs.getString("NARRATION_CODE");
				String narrationdesc		= rs.getString("NARRATION_DESC");
				String Reqlocnid			= rs.getString("REQUESTING_FROM");
				reccount					= rs.getInt("CNT");
				s_file_no					= rs.getString("FILE_NO"); 

				if(narrationdesc == null) narrationdesc = "&nbsp;";
				if(reqfslocndesc == null) reqfslocndesc = "";
				if((reqfslocnidendesc == null) || (reqfslocnidendesc.equals("null"))) 						reqfslocnidendesc = "&nbsp;";
				if(reqbyname == null) reqbyname = "";
				if(reqfacilityname == null) reqfacilityname = "";
				if(Reqfslocnid == null) Reqfslocnid = "";
				if(Reqlocnid == null) Reqlocnid = "";

				Title = "Request of File(s) From : "+reqfacilityname+" - "+reqfslocndesc+" ("+reqfslocnidendesc+")";

				if(reccount > 0)
				{
					out.println("<tr><td class='"+classValue+"'><font size='1'>");
					out.println("<a name='"+rowid+"' onClick='changeRowColor(this,6)'	href='javascript:submitAllDetails1(\""+userSecurity+"\",\""+access_all+"\",\""+resLocnIdentities+"\",\""+strLocn+"\",\""+reqon+"\",\""+reqno+"\",\""+reqfacilityid+"\",\""+java.net.URLEncoder.encode(reqfacilityname)+"\", \""+reqfslocncode+"\",\""+java.net.URLEncoder.encode(reqfslocndesc)+"\",\""+reqfslocnidentity+"\",\""+reqlocnismrlocnyn+"\",\""+java.net.URLEncoder.encode(reqby)+"\",\""+java.net.URLEncoder.encode(reqbyname)+"\",\""+narrationcode+"\",\""+java.net.URLEncoder.encode(narrationdesc)+"\",\""+s_file_no+"\",\""+no_of_days+"\",\""+no_of_recs+"\",\""+resLocnIdentities+"\",\""+issueLocn+"\",\""+s_file_type+"\", \""+s_volume_no+"\", \""+file_type_yn+"\",\""+Reqlocnid+"\")'>");
					out.println(reqon);
					out.println("</a></font></td><td align='right' class='"+classValue+"'><font size='1'>");
					out.println(reccount);
					out.println("</font></td><td class='"+classValue+"'><font size='1'>");
					out.println(reqfslocnidendesc);
					out.println("</font></td><td class='"+classValue+"'><font size='1'>");
					out.println(reqbyname);
					out.println("</font></td><td class='"+classValue+"'><font size='1'>");
					out.println(reqno);
					out.println("</font></td><td class='"+classValue+"'><font size='1'>");

					if(narrationdesc == null || narrationdesc.equals("null")) narrationdesc = "&nbsp;";
					out.println(narrationdesc);
					out.println("</font></td></tr>");

					i++;
					rowid++;
				}
			}

			if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
			{
				SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
			}
		if(rs!=null)	rs.close();
		if(pstmt!=null) pstmt.close();
		}catch(Exception e){out.println(e);}
		finally
		{			
			ConnectionManager.returnConnection(con,request);
		}
	%>
	</table>
	
	<script> 
		document.getElementById("rowtitle").innerHTML="<b><%=Title%></b>"; </script>
	<!--  <script> submitAllDetails1("<%=Firreqon%>","<%=Firreqno%>","<%=Firreqfacilityid%>","<%=Firreqfacilityname%>","<%=Firreqfslocncode%>","<%=Firreqfslocndesc%>","<%=Firreqfslocnidentity%>","<%=Firreqlocnismrlocnyn%>","<%=Firreqby%>","<%=Firreqbyname%>","<%=Firnarrationcode%>","<%=Firnarrationdesc%>","<%=s_file_no%>","<%=no_of_days%>","<%=no_of_recs%>","<%=resLocnIdentities%>","<%=issueLocn%>", "<%=s_file_type%>", "<%=s_volume_no%>", "<%=file_type_yn%>", "<%=Reqfslocnid%>") </script>
	
	-->
	</form>
</body>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

