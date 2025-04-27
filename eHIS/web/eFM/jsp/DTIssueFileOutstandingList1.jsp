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
	<script language="javascript" src="../../eCommon/js/rowcolor.js" ></script>
	<script src='../../eFM/js/FMIssueFiles.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
	function OnSelect(locations,s_file_no,no_of_days,facid,noofrecs,resLocnIdentities,strLocn, s_file_type, s_volume_no)
	{
		parent.frames[2].location.href = "../../eFM/jsp/DTIssueFileOutstandingHeader.jsp?Locations="+locations+"&s_file_no="+s_file_no+"&no_of_days="+no_of_days+"&facid="+facid+"&noofrecs="+noofrecs+"&resLocnIdentities="+resLocnIdentities+"&issueLocn="+strLocn+"&s_file_type="+s_file_type+"&s_volume_no="+s_volume_no;
		parent.frames[3].location.href = "../../eCommon/html/blank.html";
		parent.frames[4].location.href = "../../eCommon/html/blank.html";
	}
</script>

<body OnMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name='IssueFilesOutstandingList1_form' id='IssueFilesOutstandingList1_form'>
  	<table id='tb1' border="1" cellpadding="0" cellspacing="0" width='100%'>
	<th><font size='1'><fmt:message key="eFM.FromLoggedInFacility.label" bundle="${fm_labels}"/></font></th>
<%
		Connection conn = ConnectionManager.getConnection(request);
		String facility_id = (String) session.getValue("facility_id");
		String user_id = (String) session.getValue("login_user");
		String userSecurity = request.getParameter("userSecurity");
		String resLocnIdentities = request.getParameter("resLocnIdentities");
		String strLocn = request.getParameter("strLocn");
		String s_file_no			= request.getParameter("s_file_no");
		String s_fs_locn_code		= request.getParameter("s_fs_locn_code");
		String s_fs_narration		= request.getParameter("s_fs_narration");
		String s_request_date		= request.getParameter("s_request_date");
		String s_request_by_id		= request.getParameter("s_request_by_id");
		String s_fs_locn_identity	= request.getParameter("s_fs_locn_identity");

		String s_file_type			= request.getParameter("s_file_type");
		String s_volume_no			= request.getParameter("s_volume_no");
		String access_all			= request.getParameter("access_all")==null?"":request.getParameter("access_all");

		s_file_type	=	((s_file_type==null) || (s_file_type.equals("null"))) ? "" : s_file_type;
		s_volume_no	=	((s_volume_no==null) || (s_volume_no.equals("null"))) ? "" : s_volume_no;


		if(strLocn == null || strLocn.equals("null"))
			strLocn = "SelectAll";

		PreparedStatement pstmt	= null;
		ResultSet rs1=null;			

		StringBuffer SelectSqlBuffer = null;
		SelectSqlBuffer			  = new StringBuffer();
		int ReqnoList1 = 0;
		int ReqnoList2 = 0;
		int indentity_cnt	=	0;		
		String identity		=	"";
		String identity_temp=	"";		
			
		String locations = "";
		String locnname = "";		
		String fac_id = "";
		String no_of_days = "";

		String firstLocn = "";
		String firstFacid = "";		

		int i=1;
		int rowid=1;

	try {
		if(userSecurity.equals("Y")) {
		

			if (access_all.equals("*ALL")) {
				SelectSqlBuffer.append("SELECT B.REQ_FACILITY_ID, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, DECODE (b.req_fs_locn_identity, 'N', 'Nursing Unit', 'C', 'Clinic', 'D', 'Department', 'T', 'Practitioner','E','Procedure Unit','Y','Daycare Unit') identity, COUNT (a.file_no) cnt, SUM (COUNT (a.file_no)) OVER (PARTITION BY b.req_fs_locn_identity) indentity_cnt FROM FM_REQ_DTL A, FM_REQ_HDR_VW B WHERE A.REQ_TO_FACILITY_ID = '"+facility_id+"' AND A.REQ_TO_FS_LOCN_CODE = '"+strLocn+"' AND A.ISS_YN = 'N' AND A.REQ_NO = B.REQ_NO AND B.REQ_FACILITY_ID = A.REQ_TO_FACILITY_ID AND B.ISS_COMPLETED_YN = 'N' AND A.CANCEL_YN = 'N' and A.DOC_FOLDER_ID is not null ");
			}
			else {
				SelectSqlBuffer.append("SELECT B.REQ_FACILITY_ID, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, DECODE (b.req_fs_locn_identity, 'N', 'Nursing Unit', 'C', 'Clinic', 'D', 'Department', 'T', 'Practitioner','E','Procedure Unit','Y','Daycare Unit') identity, COUNT (a.file_no) cnt, SUM (COUNT (a.file_no)) OVER (PARTITION BY b.req_fs_locn_identity) indentity_cnt FROM FM_REQ_DTL A, FM_REQ_HDR_VW B, FM_USER_ACCESS_RIGHTS C WHERE A.REQ_TO_FACILITY_ID = '"+facility_id+"' AND A.REQ_TO_FS_LOCN_CODE = '"+strLocn+"' AND A.ISS_YN = 'N' AND A.REQ_NO = B.REQ_NO AND B.REQ_FACILITY_ID = A.REQ_TO_FACILITY_ID AND B.ISS_COMPLETED_YN = 'N' AND C.FACILITY_ID = A.REQ_TO_FACILITY_ID AND C.APPL_USER_ID = '"+user_id+"' AND C.FS_LOCN_CODE = A.REQ_TO_FS_LOCN_CODE AND C.ISS_YN = 'Y' AND A.CANCEL_YN = 'N' and A.DOC_FOLDER_ID is not null ");
			}
		}
		else {
				SelectSqlBuffer.append("SELECT B.REQ_FACILITY_ID, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, DECODE (b.req_fs_locn_identity, 'N', 'Nursing Unit', 'C', 'Clinic', 'D', 'Department', 'T', 'Practitioner','E','Procedure Unit','Y','Daycare Unit') identity, COUNT (a.file_no) cnt, SUM (COUNT (a.file_no)) OVER (PARTITION BY b.req_fs_locn_identity) indentity_cnt FROM FM_REQ_DTL A, FM_REQ_HDR_VW B WHERE A.REQ_TO_FACILITY_ID = '"+facility_id+"' AND A.REQ_TO_FS_LOCN_CODE = '"+strLocn+"' AND A.ISS_YN = 'N' AND A.REQ_NO = B.REQ_NO AND B.REQ_FACILITY_ID = A.REQ_TO_FACILITY_ID AND B.ISS_COMPLETED_YN = 'N' AND A.CANCEL_YN = 'N' and A.DOC_FOLDER_ID is not null");
		}

		if (!(facility_id.equals("null") || facility_id.equals("") ))
			SelectSqlBuffer.append("AND B.REQ_FACILITY_ID='"+facility_id+"' ");

		if (!(s_file_no.equals("null") || s_file_no.equals("") ))
			SelectSqlBuffer.append("AND A.FILE_NO = '"+s_file_no+"' ");
		
		if ((!s_file_type.equals("")) && (!s_file_type.equals("null")))
			SelectSqlBuffer.append("AND A.DOC_TYPE_CODE = '"+s_file_type+"' ");

		if ((!s_volume_no.equals("")) && (!s_volume_no.equals("null")))
			SelectSqlBuffer.append("AND A.VOLUME_NO = '"+s_volume_no+"' ");

		if (!(s_fs_locn_code.equals("null") || s_fs_locn_code.equals("") ))
			SelectSqlBuffer.append("AND B.REQ_FS_LOCN_CODE = '"+s_fs_locn_code+"' ");

		if (!(s_request_by_id.equals("null") || s_request_by_id.equals("") ))
			SelectSqlBuffer.append("AND B.REQ_BY = '"+s_request_by_id+"' ");

		if (!(s_fs_narration.equals("null") || s_fs_narration.equals("") ))
			SelectSqlBuffer.append("AND B.NARRATION_CODE = '"+s_fs_narration+"' ");

		if (!(s_fs_locn_identity.equals("null") || s_fs_locn_identity.equals("") ))
			SelectSqlBuffer.append("AND B.REQ_FS_LOCN_IDENTITY = '"+s_fs_locn_identity+"' ");

		if (!(s_request_date.equals("null") || s_request_date.equals("") ))
			SelectSqlBuffer.append("AND TO_DATE(TO_CHAR(TRUNC(B.ADDED_DATE),'dd/mm/yyyy'),'dd/mm/yyyy') = TO_DATE('"+s_request_date+"','dd/mm/yyyy') ");

		SelectSqlBuffer.append("Group by B.REQ_FACILITY_ID, b.req_fs_locn_identity, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, A.REQ_TO_FS_LOCN_CODE ");
		
		i = 1;
	
		pstmt	= conn.prepareStatement(SelectSqlBuffer.toString());
		rs1		= pstmt.executeQuery();
		if(rs1 != null) {
			while ( rs1.next() ) {				

				fac_id		= rs1.getString("REQ_FACILITY_ID");
				locations	= rs1.getString("REQ_FS_LOCN_CODE");
				locnname	= rs1.getString("FS_LOCN_SHORT_DESC");
				no_of_days	= rs1.getString("NO_OF_DAYS_TO_RETURN");
				ReqnoList1  = rs1.getInt("CNT");
				identity	 = rs1.getString("identity");
				indentity_cnt = rs1.getInt("indentity_cnt");

				if(no_of_days == null || no_of_days.equals("null"))
					no_of_days = "";

				if(i == 1)
				{
					firstLocn = rs1.getString("REQ_FS_LOCN_CODE");
					firstFacid = rs1.getString("REQ_FACILITY_ID");
					ReqnoList2 = rs1.getInt("CNT");
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
				out.println("&nbsp;&nbsp;<a name='"+rowid+"' onClick='changeRowColor(this,1)' href=\"javascript:OnSelect('"+locations+"','"+s_file_no+"','"+no_of_days+"','"+fac_id+"','"+ReqnoList1+"','"+resLocnIdentities+"','"+strLocn+"','"+s_file_type+"', '"+s_volume_no+"')\">");
				out.println(locnname+"</a> ("+ReqnoList1+")</font></td></tr>");
				i++;
				rowid++;
				identity_temp = identity;
				}
			}
		}
	if(rs1	 !=null)	rs1.close();
	if(pstmt !=null)	pstmt.close();	
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
<input type='hidden' name='noofrecs' id='noofrecs' value='<%=rowid%>'>
</form>
<SCRIPT>
	parent.frames[1].location.href = "../../eFM/jsp/DTIssueFileOutstandingList2.jsp?userSecurity=<%=userSecurity%>&access_all=<%=access_all%>&resLocnIdentities=<%=resLocnIdentities%>&strLocn=<%=strLocn%>&s_file_no=<%=s_file_no%>&s_fs_locn_code=<%=s_fs_locn_code%>&s_fs_narration=<%=s_fs_narration%>&s_request_date=<%=s_request_date%>&s_request_by_id=<%=s_request_by_id%>&s_file_type=<%=s_file_type%>&s_volume_no=<%=s_volume_no%>";
	OnSelect('<%=firstLocn%>','<%=s_file_no%>','<%=no_of_days%>','<%=firstFacid%>','<%=ReqnoList2%>','<%=resLocnIdentities%>','<%=strLocn%>', '<%=s_file_type%>', '<%=s_volume_no%>') ;
	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
</SCRIPT>
</BODY>
</HTML>

