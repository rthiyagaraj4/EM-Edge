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
	function OnSelect(locations,s_file_no,no_of_days,facid,strLocn, s_file_type, s_volume_no)
	{
		parent.frames[2].location.href = "../../eFM/jsp/DTIssueFileOutstandingHeader.jsp?Locations="+locations+"&s_file_no="+s_file_no+"&no_of_days="+no_of_days+"&facid="+facid+"&issueLocn="+strLocn+"&s_file_type="+s_file_type+"&s_volume_no="+s_volume_no;
		parent.frames[3].location.href = "../../eCommon/html/blank.html";
		parent.frames[4].location.href = "../../eCommon/html/blank.html";
	}
</script>

<body OnMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name='IssueFilesOutstandingList2_form' id='IssueFilesOutstandingList2_form'>
  	<table id='tb1' border="1" cellpadding="0" cellspacing="0" width='100%'>
	<th><font size='1'><fmt:message key="eFM.FromOtherFacilities.label" bundle="${fm_labels}"/></font></th>
<%
		Connection conn = ConnectionManager.getConnection(request);
		String facility_id = (String) session.getValue("facility_id");
		String user_id = (String) session.getValue("login_user");
		String userSecurity = request.getParameter("userSecurity");
		String strLocn = request.getParameter("strLocn");
		String s_file_no			= request.getParameter("s_file_no");
		String s_fs_locn_code		= request.getParameter("s_fs_locn_code");
		String s_fs_narration		= request.getParameter("s_fs_narration");
		String s_request_date		= request.getParameter("s_request_date");
		String s_request_by_id		= request.getParameter("s_request_by_id");
		String s_file_type			= request.getParameter("s_file_type");
		String s_volume_no			= request.getParameter("s_volume_no");
		String access_all  = request.getParameter("access_all")==null?"":request.getParameter("access_all");
		s_file_type	=	((s_file_type==null) || (s_file_type.equals("null"))) ? "" : s_file_type;
		s_file_type	=	((s_volume_no==null) || (s_volume_no.equals("null"))) ? "" : s_volume_no;


		PreparedStatement pstmt		= null;
		ResultSet rs1=null;			

		int ReqnoList2 = 0;
		
		String facname = "";
		String locations = "";
		String locnname = "";		
		String no_of_days = "";
		String prevfacility = "";
		String fac_id = "";			

		StringBuffer SelectSqlBuffer = null;
		SelectSqlBuffer				 = new StringBuffer();

		int i=1;
		int rowid=2;

		try {
			if(userSecurity.equals("Y")) {
				

				if (access_all.equals("*ALL")) {
					SelectSqlBuffer.append("SELECT B.REQ_FACILITY_ID, B.REQ_FACILITY_NAME, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, COUNT(A.FILE_NO) CNT FROM FM_REQ_DTL A, FM_REQ_HDR_VW B WHERE	A.REQ_TO_FACILITY_ID = '"+facility_id+"' AND A.REQ_TO_FS_LOCN_CODE = '"+strLocn+"' AND A.ISS_YN = 'N' AND A.REQ_NO = B.REQ_NO AND B.REQ_FACILITY_ID != A.REQ_TO_FACILITY_ID AND B.ISS_COMPLETED_YN = 'N' AND A.CANCEL_YN = 'N' ");
				}
				else {
					SelectSqlBuffer.append("SELECT B.REQ_FACILITY_ID, B.REQ_FACILITY_NAME, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, COUNT(A.FILE_NO) CNT FROM FM_REQ_DTL A, FM_REQ_HDR_VW B, FM_USER_ACCESS_RIGHTS C WHERE A.REQ_TO_FACILITY_ID = '"+facility_id+"' AND A.REQ_TO_FS_LOCN_CODE = '"+strLocn+"' AND A.ISS_YN = 'N' AND A.REQ_NO = B.REQ_NO AND B.REQ_FACILITY_ID != A.REQ_TO_FACILITY_ID AND B.ISS_COMPLETED_YN = 'N' AND C.FACILITY_ID = A.REQ_TO_FACILITY_ID AND C.APPL_USER_ID = '"+user_id+"' AND C.FS_LOCN_CODE = A.REQ_TO_FS_LOCN_CODE AND C.ISS_ACROSS_FACILITIES_YN = 'Y' AND A.CANCEL_YN = 'N' ");
				}
			}
			else {
				SelectSqlBuffer.append("SELECT B.REQ_FACILITY_ID, B.REQ_FACILITY_NAME, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, COUNT(A.FILE_NO) CNT FROM FM_REQ_DTL A, FM_REQ_HDR_VW B WHERE	A.REQ_TO_FACILITY_ID = '"+facility_id+"' AND A.REQ_TO_FS_LOCN_CODE = '"+strLocn+"' AND A.ISS_YN = 'N' AND A.REQ_NO = B.REQ_NO AND B.REQ_FACILITY_ID != A.REQ_TO_FACILITY_ID AND B.ISS_COMPLETED_YN = 'N' AND A.CANCEL_YN = 'N' ");
			}

			if (!(s_file_no.equals("null") || s_file_no.equals("") ))
				SelectSqlBuffer.append("AND A.FILE_NO = '"+s_file_no+"' ");

			if (!(s_file_type.equals("null") || s_file_type.equals("") ))
				SelectSqlBuffer.append("AND A.FILE_TYPE_CODE = '"+s_file_type+"' ");

			if (!(s_volume_no.equals("null") || s_volume_no.equals("") ))
				SelectSqlBuffer.append("AND A.VOLUME_NO = '"+s_volume_no+"' ");

			if (!(s_fs_locn_code.equals("null") || s_fs_locn_code.equals("") ))
				SelectSqlBuffer.append("AND B.REQ_FS_LOCN_CODE = '"+s_fs_locn_code+"' ");

			if (!(s_request_by_id.equals("null") || s_request_by_id.equals("") ))
				SelectSqlBuffer.append("AND B.REQ_BY = '"+s_request_by_id+"' ");

			if (!(s_fs_narration.equals("null") || s_fs_narration.equals("") ))
				SelectSqlBuffer.append("AND B.NARRATION_CODE = '"+s_fs_narration+"' ");

			if (!(s_request_date.equals("null") || s_request_date.equals("") ))
				SelectSqlBuffer.append("AND TO_DATE(TO_CHAR(TRUNC(B.ADDED_DATE),'dd/mm/yyyy'),'dd/mm/yyyy') = TO_DATE('"+s_request_date+"','dd/mm/yyyy') ");


			SelectSqlBuffer.append("GROUP BY B.REQ_FACILITY_ID, B.REQ_FACILITY_NAME, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, A.REQ_TO_FS_LOCN_CODE ");

		pstmt = conn.prepareStatement(SelectSqlBuffer.toString());
		rs1    = pstmt.executeQuery();

		i=1;
		
		if(rs1 != null)
		{
			while ( rs1.next() )
			{				

				fac_id		= rs1.getString("REQ_FACILITY_ID");
				facname		= rs1.getString("REQ_FACILITY_NAME");
				locations	= rs1.getString("REQ_FS_LOCN_CODE");
				locnname	= rs1.getString("FS_LOCN_SHORT_DESC");
				no_of_days	= rs1.getString("NO_OF_DAYS_TO_RETURN");
				ReqnoList2  = rs1.getInt("CNT");

				if(no_of_days == null || no_of_days.equals("null"))
					no_of_days = "";

				if(i == 1)
				{
					out.println("<tr><td class=QRYODD><b><font size='1'>");
					out.println(facname+"</b></font></td></tr>");
					prevfacility = facname;
				}

				if(!(prevfacility.equals(facname)))
				{
					out.println("<tr><td class=QRYODD><b><font size='1'>");
					out.println(facname+"</b></font></td></tr>");
					prevfacility = facname;
					rowid++;
				}

				if(ReqnoList2 > 0)
				{
					out.println("<tr><td class=QRYEVEN><font size='1'>&nbsp;&nbsp;&nbsp;&nbsp;");
					out.println("<a name='"+rowid+"' onClick='changeRowColor(this,1)' href=\"javascript:OnSelect('"+locations+"','"+s_file_no+"','"+no_of_days+"','"+fac_id+"','"+strLocn+"', '"+s_file_type+"', '"+s_volume_no+"')\">");
					out.println(locnname+"</a> ("+ReqnoList2+")</font></td></tr>");
					i++;
					rowid++;
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
</form>
<script>
	if(parent.frames[0].document.forms[0].noofrecs.value == 1)
		OnSelect('<%=locations%>','<%=s_file_no%>','<%=no_of_days%>','<%=fac_id%>','<%=strLocn%>', '<%=s_file_type%>', '<%=s_volume_no%>');
</script>
</body>
</html>

