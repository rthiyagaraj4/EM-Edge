<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eFM/js/FMIssueFiles.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/rowcolor.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<script>
	function OnSelection(reqon,reqno,reqfacilityid,reqfacilityname,reqfslocncode,reqfslocndesc,reqfslocnidentity,reqlocnismrlocnyn,reqby,reqbyname,narrationcode,narrationdesc,s_file_no,no_of_days,no_of_recs,resLocnIdentities,issueLocn, s_file_type, s_volume_no)
	{
		parent.frames[3].location.href = "../../eFM/jsp/DTIssueFileOutstandingDetail.jsp?ReqOn="+reqon+"&Reqno="+reqno+"&Reqfacilityid="+reqfacilityid+"&Reqfacilityname="+escape(reqfacilityname)+"&Reqfslocncode="+reqfslocncode+"&Reqfslocndesc="+escape(reqfslocndesc)+"&Reqfslocnidentity="+reqfslocnidentity+"&Reqlocnismrlocnyn="+reqlocnismrlocnyn+"&Reqby="+reqby+"&Reqbyname="+escape(reqbyname)+"&Narrationcode="+narrationcode+"&Narrationdesc="+escape(narrationdesc)+"&s_file_no="+s_file_no+"&NoOfdays="+no_of_days+"&NoOfRecs="+no_of_recs+"&resLocnIdentities="+escape(resLocnIdentities)+"&issueLocn="+issueLocn+"&s_file_type="+s_file_type+"&s_volume_no="+s_volume_no;
		parent.frames[4].location.href = "../../eFM/jsp/DTIssueFileOutstandingButton.jsp?resLocnIdentities="+resLocnIdentities;

	}
</script>
<%
	String Title = "";
	String Firreqon= "";
	String Firreqno= "";
	String Firreqfacilityid= "";
	String Firreqfacilityname= "";
	String Firreqfslocncode= "";
	String Firreqfslocndesc= "";
	String Firreqfslocnidentity= "";
	String Firreqlocnismrlocnyn= "";
	String Firreqby= "";
	String Firreqbyname= "";
	String Firnarrationcode= "";
	String Firnarrationdesc= "";
%>
<body OnMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name='IssueOutstandingHeader' id='IssueOutstandingHeader'>
  	<table border="1" cellpadding="0" cellspacing="0" width='100%'>
	<tr><td id='rowtitle' class='label'><b><%=Title%></b></td><tr>
	</table>
	<table id='tb1' border="1" cellpadding="0" cellspacing="0" width='100%'>
	<tr><th><fmt:message key="Common.RequestedOn.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="eFM.NoofDocs.label" bundle="${fm_labels}"/></th>
	<th><fmt:message key="eFM.RequestedFrom.label" bundle="${fm_labels}"/></th>
	<th><fmt:message key="Common.RequestedBy.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.RequestNo.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="eFM.ReasonForBorrowing.label" bundle="${fm_labels}"/></th></tr>
<%
		Connection conn = ConnectionManager.getConnection(request);
		String facility_id = (String) session.getValue("facility_id");
		String resLocnIdentities = request.getParameter("resLocnIdentities");
		String Locations = request.getParameter("Locations");
		String no_of_days = request.getParameter("no_of_days");
		String fac_id = request.getParameter("facid");
		String no_of_recs = request.getParameter("noofrecs");
		String issueLocn = request.getParameter("issueLocn");
		String s_file_no = request.getParameter("s_file_no");
		
		String s_file_type	= request.getParameter("s_file_type");
		String s_volume_no	= request.getParameter("s_volume_no");

		s_file_type	=	((s_file_type==null) || (s_file_type.equals("null"))) ? "" : s_file_type;
		s_volume_no	=	((s_volume_no==null) || (s_volume_no.equals("null"))) ? "" : s_volume_no;

		PreparedStatement pstmt		= null;
		ResultSet rs=null;			
		String classValue = "";

		StringBuffer SelectSqlBuffer = null;
		SelectSqlBuffer				 = new StringBuffer();

		int reccount = 0;
		int i=1;
		int rowid=1;
	try
	{

		SelectSqlBuffer.append("Select to_char(A.ADDED_DATE,'DD/MM/YYYY HH24:MI') REQ_ON, A.REQ_NO, A.REQ_FACILITY_ID, A.REQ_FACILITY_NAME, A.REQ_FS_LOCN_CODE, A.REQ_FS_LOCN_DESC, A.REQ_BY, A.REQ_BY_NAME, A.NARRATION_CODE, A.NARRATION_DESC, DECODE(B.LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') IDENTITY, B.LOCN_IDENTITY, B.MR_LOCN_YN, Count(C.FILE_NO) CNT, A.REQUESTING_FROM_DESC from FM_REQ_HDR_VW A, FM_STORAGE_LOCN B, FM_REQ_DTL C WHERE A.REQ_FACILITY_ID = '"+fac_id+"' AND A.REQ_FS_LOCN_CODE = '"+Locations+"' AND A.ISS_COMPLETED_YN = 'N' AND A.REQ_NO = C.REQ_NO AND C.REQ_TO_FACILITY_ID = '"+facility_id+"' AND  C.REQ_TO_FS_LOCN_CODE = '"+issueLocn+"' AND C.ISS_YN = 'N' AND A.REQ_FACILITY_ID = B.FACILITY_ID AND A.REQ_FS_LOCN_CODE = B.FS_LOCN_CODE AND C.CANCEL_YN='N' AND C.DOC_TYPE_CODE is not null ");
		
		if (!(s_file_no.equals("null") || s_file_no.equals("") ))
		SelectSqlBuffer.append("AND C.FILE_NO = '"+s_file_no+"' ");
		
		if ((!s_file_type.equals("")) && (!s_file_type.equals("null")))
		SelectSqlBuffer.append("AND C.DOC_TYPE_CODE = '"+s_file_type+"' ");

		if ((!s_volume_no.equals("")) && (!s_volume_no.equals("null")))
		SelectSqlBuffer.append("AND C.VOLUME_NO = '"+s_volume_no+"' ");
	
		SelectSqlBuffer.append("GROUP BY A.ADDED_DATE, A.REQ_NO, A.REQ_FACILITY_ID, A.REQ_FACILITY_NAME, A.REQ_FS_LOCN_CODE, A.REQ_FS_LOCN_DESC, A.REQ_BY, A.REQ_BY_NAME, A.NARRATION_CODE, A.NARRATION_DESC, B.LOCN_IDENTITY, B.MR_LOCN_YN, A.REQUESTING_FROM_DESC ORDER BY A.ADDED_DATE DESC");
	
		pstmt = conn.prepareStatement(SelectSqlBuffer.toString());
		rs = pstmt.executeQuery();
		if(rs != null)
		{
			while ( rs.next() )
			{
				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;

					if(i == 1)
					{
						Firreqon= rs.getString("REQ_ON");
						Firreqno= rs.getString("REQ_NO");
						Firreqfacilityid= rs.getString("REQ_FACILITY_ID");
						Firreqfacilityname= rs.getString("REQ_FACILITY_NAME");
						Firreqfslocncode= rs.getString("REQ_FS_LOCN_CODE");
						Firreqfslocndesc= rs.getString("REQ_FS_LOCN_DESC");
						Firreqfslocnidentity = rs.getString("LOCN_IDENTITY");
						Firreqlocnismrlocnyn = rs.getString("MR_LOCN_YN");
						Firreqby= rs.getString("REQ_BY");
						Firreqbyname= rs.getString("REQ_BY_NAME");
						Firnarrationcode= rs.getString("NARRATION_CODE");
						Firnarrationdesc= rs.getString("NARRATION_DESC");
					}

					String reqon = rs.getString("REQ_ON");
					String reqno = rs.getString("REQ_NO");
					String reqfacilityid = rs.getString("REQ_FACILITY_ID");
					String reqfacilityname = rs.getString("REQ_FACILITY_NAME");
					String reqfslocncode = rs.getString("REQ_FS_LOCN_CODE");
					String reqfslocndesc = rs.getString("REQ_FS_LOCN_DESC");
					String reqfslocnidentity = rs.getString("LOCN_IDENTITY");
					String reqfslocnidendesc = rs.getString("REQUESTING_FROM_DESC");
					String reqlocnismrlocnyn = rs.getString("MR_LOCN_YN");
					String reqby = rs.getString("REQ_BY");
					String reqbyname = rs.getString("REQ_BY_NAME");
					String narrationcode = rs.getString("NARRATION_CODE");
					String narrationdesc = rs.getString("NARRATION_DESC");
					reccount = rs.getInt("CNT");
					if (narrationdesc==null) narrationdesc="&nbsp;";
					if (reqfslocndesc==null) reqfslocndesc="";
					if ((reqfslocnidendesc==null) || (reqfslocnidendesc.equals("null"))) reqfslocnidendesc="&nbsp;";
					if (reqbyname==null) reqbyname="";
					if (reqfacilityname==null) reqfacilityname="";


//					Title = "Request of Document(s) From : "+reqfacilityname+" - "+reqfslocndesc+" ("+reqfslocnidendesc+")";
					Title = com.ehis.util.BundleMessage.getBundleMessage( pageContext,"eFM.RequestofDocumentsFrom.label","fm_labels")+reqfacilityname+" - "+reqfslocndesc+" ("+reqfslocnidendesc+")";


					if(reccount > 0)
					{
					out.println("<tr><td class='"+classValue+"'><font size='1'>");
					out.println("<a name='"+rowid+"' onClick='changeRowColor(this,6)'	href='javascript:OnSelection(\""+reqon+"\",\""+reqno+"\",\""+reqfacilityid+"\",\""+java.net.URLEncoder.encode(reqfacilityname)+"\", \""+reqfslocncode+"\",\""+java.net.URLEncoder.encode(reqfslocndesc)+"\",\""+reqfslocnidentity+"\",\""+reqlocnismrlocnyn+"\",\""+java.net.URLEncoder.encode(reqby)+"\",\""+java.net.URLEncoder.encode(reqbyname)+"\",\""+narrationcode+"\",\""+java.net.URLEncoder.encode(narrationdesc)+"\",\""+s_file_no+"\",\""+no_of_days+"\",\""+no_of_recs+"\",\""+resLocnIdentities+"\",\""+issueLocn+"\",\""+s_file_type+"\", \""+s_volume_no+"\")'>");
					out.println(reqon);
					out.println("</a></font></td><td  class='"+classValue+"'><font size='1'>");
					out.println(reccount);
					out.println("</font></td><td class='"+classValue+"'><font size='1'>");
					out.println(reqfslocnidendesc);
					out.println("</font></td><td class='"+classValue+"'><font size='1'>");
					out.println(reqbyname);
					out.println("</font></td><td class='"+classValue+"'><font size='1'>");
					out.println(reqno);
					out.println("</font></td><td class='"+classValue+"'><font size='1'>");

					if(narrationdesc == null || narrationdesc.equals("null"))
						narrationdesc = "&nbsp;";

					out.println(narrationdesc);
					out.println("</font></td></tr>");
					i++;
					rowid++;
					}
			}
		}
	if(rs!=null)	rs.close();	
	if(pstmt!=null) pstmt.close();
	
	}
	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}
%>
</table>
<!-- <script> document.getElementById("admchartlength").colSpan='<%=Title%>'; </script> -->
<!-- <script> document.getElementById("rowtitle").innerText='<%=Title%>'; </script> -->
<script> document.getElementById("rowtitle").innerHTML="<b><%=Title%></b>"; </script>
<script> OnSelection("<%=Firreqon%>","<%=Firreqno%>","<%=Firreqfacilityid%>","<%=Firreqfacilityname%>","<%=Firreqfslocncode%>","<%=Firreqfslocndesc%>","<%=Firreqfslocnidentity%>","<%=Firreqlocnismrlocnyn%>","<%=Firreqby%>","<%=Firreqbyname%>","<%=Firnarrationcode%>","<%=Firnarrationdesc%>","<%=s_file_no%>","<%=no_of_days%>","<%=no_of_recs%>","<%=resLocnIdentities%>","<%=issueLocn%>", "<%=s_file_type%>", "<%=s_volume_no%>") </script>
</form>
</body>
</html>

