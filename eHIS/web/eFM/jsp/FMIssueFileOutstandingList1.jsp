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
	<script language='javascript' src='../../eCommon/js/rowcolor.js' ></script>
	<script language='javascript' src='../../eFM/js/FMIssueFiles.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body OnMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name='IssueFilesOutstandingList1_form' id='IssueFilesOutstandingList1_form'>
  	<table id='tb1' border="1" cellpadding="0" cellspacing="0" width='100%'>
		<th><font size='1'><fmt:message key="eFM.FromLoggedInFacility.label" bundle="${fm_labels}"/></font></th>
	<%
	Connection con			= ConnectionManager.getConnection(request);
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;

	String facility_id	= (String) session.getValue("facility_id");
	String user_id		= (String) session.getValue("login_user");

	String userSecurity			= checkForNull(request.getParameter("userSecurity"));
	String resLocnIdentities	= checkForNull(request.getParameter("resLocnIdentities"));
	String strLocn				= checkForNull(request.getParameter("strLocn"));
	String s_file_no			= checkForNull(request.getParameter("s_file_no"));
	String s_fs_locn_code		= checkForNull(request.getParameter("s_fs_locn_code"));
	String s_fs_narration		= checkForNull(request.getParameter("s_fs_narration"));
	String s_request_date		= checkForNull(request.getParameter("s_request_date"));
	String s_request_by_id		= checkForNull(request.getParameter("s_request_by_id"));
	String s_fs_locn_identity	= checkForNull(request.getParameter("s_fs_locn_identity"));
	String s_file_type			= checkForNull(request.getParameter("s_file_type"));
	String s_volume_no			= checkForNull(request.getParameter("s_volume_no"));
	String file_type_yn			= checkForNull(request.getParameter("file_type_yn"));
	String access_all			= request.getParameter("access_all")==null?"":request.getParameter("access_all");
	
	String isSearchApplYN			= checkForNull(request.getParameter("isSearchApplYN"),"Y");

		
	s_file_type	=	((s_file_type==null) || (s_file_type.equals("null"))) ? "" : s_file_type;
	s_volume_no	=	((s_volume_no==null) || (s_volume_no.equals("null"))) ? "" : s_volume_no;
	
	if(strLocn == null || strLocn.equals("null")) strLocn = "SelectAll";
	
	String identity			= "";
	String identity_temp	= "";		
	String locations		= "";
	String locnname			= "";		
	String fac_id			= "";
	String no_of_days		= "";
	String firstLocn		= "";
	String firstFacid		= "";	

	StringBuffer SelectSqlBufffer = null;
	SelectSqlBufffer			  = new StringBuffer();

	int ReqnoList1		= 0;
	int ReqnoList2		= 0;
	int indentity_cnt	= 0;		
	int i				= 1;
	int rowid			= 1;

	try 
	{
	//access_all="";
	
		if(userSecurity.equals("Y")) 
		{

			if(access_all.equals("*ALL")) 
			{
				SelectSqlBufffer.append("SELECT B.REQ_FACILITY_ID, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, DECODE (b.req_fs_locn_identity, 'N', 'Nursing Unit', 'C', 'Clinic', 'D', 'Department', 'T', 'Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') identity, COUNT (a.file_no) cnt, SUM (COUNT (a.file_no)) OVER (PARTITION BY b.req_fs_locn_identity) indentity_cnt FROM FM_REQ_DTL A, FM_REQ_HDR_VW B, FM_CURR_LOCN C WHERE A.REQ_TO_FACILITY_ID = '"+facility_id+"' AND A.REQ_TO_FS_LOCN_CODE = '"+strLocn+"' AND A.ISS_YN = 'N' AND A.REQ_NO = B.REQ_NO AND A.FILE_NO = C.FILE_NO AND A.VOLUME_NO = C.VOLUME_NO AND B.REQ_FACILITY_ID = A.REQ_TO_FACILITY_ID AND B.ISS_COMPLETED_YN = 'N' AND B.REQ_FS_LOCN_CODE != C.CURR_FS_LOCN_CODE AND A.DOC_TYPE_CODE is null AND A.CANCEL_YN = 'N'");
			}
			else 
			{
				SelectSqlBufffer.append("SELECT B.REQ_FACILITY_ID, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, DECODE (b.req_fs_locn_identity, 'N', 'Nursing Unit', 'C', 'Clinic', 'D', 'Department', 'T', 'Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') identity, COUNT (a.file_no) cnt, SUM (COUNT (a.file_no)) OVER (PARTITION BY b.req_fs_locn_identity) indentity_cnt FROM FM_REQ_DTL A, FM_REQ_HDR_VW B, FM_USER_ACCESS_RIGHTS C, FM_CURR_LOCN D WHERE A.REQ_TO_FACILITY_ID = '"+facility_id+"' AND A.REQ_TO_FS_LOCN_CODE = '"+strLocn+"' AND A.ISS_YN = 'N' AND A.REQ_NO = B.REQ_NO AND A.FILE_NO = D.FILE_NO AND A.VOLUME_NO = D.VOLUME_NO AND A.REQ_NO = B.REQ_NO AND B.REQ_FACILITY_ID = A.REQ_TO_FACILITY_ID AND B.ISS_COMPLETED_YN = 'N' AND C.FACILITY_ID = A.REQ_TO_FACILITY_ID AND C.APPL_USER_ID = '"+user_id+"' AND C.FS_LOCN_CODE = A.REQ_TO_FS_LOCN_CODE AND C.ISS_YN = 'Y' AND B.REQ_FS_LOCN_CODE != D.CURR_FS_LOCN_CODE AND A.DOC_TYPE_CODE is null AND A.CANCEL_YN = 'N' ");
			}
		}
		else 
		{
			SelectSqlBufffer.append("SELECT B.REQ_FACILITY_ID, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, DECODE (b.req_fs_locn_identity, 'N', 'Nursing Unit', 'C', 'Clinic', 'D', 'Department', 'T', 'Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') identity, COUNT (a.file_no) cnt, SUM (COUNT (a.file_no)) OVER (PARTITION BY b.req_fs_locn_identity) indentity_cnt FROM FM_REQ_DTL A, FM_REQ_HDR_VW B, FM_CURR_LOCN C WHERE A.REQ_TO_FACILITY_ID = '"+facility_id+"' AND A.REQ_TO_FS_LOCN_CODE = '"+strLocn+"' AND A.ISS_YN = 'N' AND A.REQ_NO = B.REQ_NO AND B.REQ_FACILITY_ID = A.REQ_TO_FACILITY_ID AND B.ISS_COMPLETED_YN = 'N' AND A.REQ_NO = B.REQ_NO AND A.FILE_NO = C.FILE_NO AND A.VOLUME_NO = C.VOLUME_NO AND A.DOC_TYPE_CODE is null AND A.CANCEL_YN = 'N' AND B.REQ_FS_LOCN_CODE != C.CURR_FS_LOCN_CODE ");
		}

		if (!(facility_id.equals("null") || facility_id.equals("")))
			SelectSqlBufffer.append("AND B.REQ_FACILITY_ID='"+facility_id+"' ");

		if (!(s_file_no.equals("null") || s_file_no.equals("")))
			SelectSqlBufffer.append("AND A.FILE_NO = '"+s_file_no+"' ");

		if ((!s_volume_no.equals("")) && (!s_volume_no.equals("null")))
			SelectSqlBufffer.append("AND A.VOLUME_NO = "+s_volume_no+" ");

		if (!(s_fs_locn_code.equals("null") || s_fs_locn_code.equals("")))
			SelectSqlBufffer.append("AND B.REQ_FS_LOCN_CODE = '"+s_fs_locn_code+"' ");

		if (!(s_request_by_id.equals("null") || s_request_by_id.equals("")))
			SelectSqlBufffer.append("AND B.REQ_BY = '"+s_request_by_id+"' ");

		if (!(s_fs_narration.equals("null") || s_fs_narration.equals("")))
			SelectSqlBufffer.append("AND B.NARRATION_CODE = '"+s_fs_narration+"' ");

		if (!(s_fs_locn_identity.equals("null") || s_fs_locn_identity.equals("")))
			SelectSqlBufffer.append("AND B.REQ_FS_LOCN_IDENTITY = '"+s_fs_locn_identity+"' ");

		if (!(s_request_date.equals("null") || s_request_date.equals("")))
			SelectSqlBufffer.append("AND TO_DATE(TO_CHAR(TRUNC(B.ADDED_DATE),'dd/mm/yyyy'),'dd/mm/yyyy') = TO_DATE('"+s_request_date+"','dd/mm/yyyy') ");

		SelectSqlBufffer.append("Group by B.REQ_FACILITY_ID, b.req_fs_locn_identity, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, A.REQ_TO_FS_LOCN_CODE ");

		i = 1;
		pstmt	= con.prepareStatement(SelectSqlBufffer.toString());
		rs		= pstmt.executeQuery();
		
		while(rs != null && rs.next())
		{
			fac_id			= rs.getString("REQ_FACILITY_ID");
			locations		= rs.getString("REQ_FS_LOCN_CODE");
			locnname		= rs.getString("FS_LOCN_SHORT_DESC");
			no_of_days		= rs.getString("NO_OF_DAYS_TO_RETURN");
			ReqnoList1		= rs.getInt("CNT");
			identity		= rs.getString("identity");
			indentity_cnt	= rs.getInt("indentity_cnt");

			if(no_of_days == null || no_of_days.equals("null")) no_of_days = "";

			if(i == 1)
			{
				firstLocn  = rs.getString("REQ_FS_LOCN_CODE");
				firstFacid = rs.getString("REQ_FACILITY_ID");
				ReqnoList2 = rs.getInt("CNT");
			}
			
			if(ReqnoList1 > 0)
			{
				if (!identity_temp.equals(identity))
				{
					rowid++;
					
					out.println("<tr><td class=QRYEVEN><font size='1'><b>");
					out.println(identity+" ("+indentity_cnt+")</b></font></td></tr>");
				}				
				out.println("<tr><td class=QRYEVEN><font size='1'>");
				out.println("&nbsp;&nbsp;<a name='"+rowid+"' onClick='changeRowColor(this,1)' href=\"javascript:OnSelect('"+locations+"','"+s_file_no+"','"+no_of_days+"','"+fac_id+"','"+ReqnoList1+"','"+resLocnIdentities+"','"+strLocn+"','"+s_file_type+"', '"+s_volume_no+"','"+file_type_yn+"')\">");
				out.println(locnname+"</a> ("+ReqnoList1+")</font></td></tr>");
				
				i++;
				rowid++;
				identity_temp = identity;
			}
		}
		if((SelectSqlBufffer != null) && (SelectSqlBufffer.length() > 0))
		{
			SelectSqlBufffer.delete(0,SelectSqlBufffer.length());
		}
	if(rs	 !=null)	rs.close();
	if(pstmt !=null)	pstmt.close();
	}catch(Exception e){out.println("Exception e :"+e);}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
%>
	</table>
	<input type='hidden' name='noofrecs' id='noofrecs' value='<%=rowid%>'>
</form>
 <SCRIPT>
	parent.frames[1].location.href = "../../eFM/jsp/FMIssueFileOutstandingList2.jsp?userSecurity=<%=userSecurity%>&access_all=<%=access_all%>&file_type_yn=<%=file_type_yn%>&resLocnIdentities=<%=resLocnIdentities%>&strLocn=<%=strLocn%>&s_file_no=<%=s_file_no%>&s_fs_locn_code=<%=s_fs_locn_code%>&s_fs_narration=<%=s_fs_narration%>&s_request_date=<%=s_request_date%>&s_request_by_id=<%=s_request_by_id%>&s_file_type=<%=s_file_type%>&s_volume_no=<%=s_volume_no%>";
	OnSelect('<%=firstLocn%>','<%=s_file_no%>','<%=no_of_days%>','<%=firstFacid%>','<%=ReqnoList2%>','<%=resLocnIdentities%>','<%=strLocn%>', '<%=s_file_type%>', '<%=s_volume_no%>', '<%=file_type_yn%>') ;
	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
</SCRIPT>
</BODY>
</HTML>
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

