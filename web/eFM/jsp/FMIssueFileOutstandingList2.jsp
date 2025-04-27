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
	<script language='javascript' src='../../eCommon/js/rowcolor.js'></script>
	<script language='javascript' src='../../eFM/js/FMIssueFiles.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
	function OnSelect(locations,s_file_no,no_of_days,facid,strLocn, s_file_type, s_volume_no,file_type_yn)
	{
		parent.frames[2].location.href = "../../eFM/jsp/FMIssueFileOutstandingHeader.jsp?Locations="+locations+"&s_file_no="+s_file_no+"&no_of_days="+no_of_days+"&facid="+facid+"&issueLocn="+strLocn+"&s_file_type="+s_file_type+"&s_volume_no="+s_volume_no+"&file_type_yn="+file_type_yn;
		parent.frames[3].location.href = "../../eCommon/html/blank.html";
		parent.frames[4].location.href = "../../eCommon/html/blank.html";
	}
</script>
<body OnMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
	<form name='IssueFilesOutstandingList2_form' id='IssueFilesOutstandingList2_form'>
  		<table id='tb1' border="1" cellpadding="0" cellspacing="0" width='100%'>
			<th><font size='1'><fmt:message key="eFM.FromOtherFacilities.label" bundle="${fm_labels}"/></font></th>
<%
		Connection con				= ConnectionManager.getConnection(request);
		PreparedStatement pstmt		= null;
		ResultSet rs				= null;

		String facility_id		= (String) session.getValue("facility_id");
		String user_id			= (String) session.getValue("login_user");

		String userSecurity		= request.getParameter("userSecurity");
		String strLocn			= request.getParameter("strLocn");
		String s_file_no		= request.getParameter("s_file_no");
		String s_fs_locn_code	= request.getParameter("s_fs_locn_code");
		String s_fs_narration	= request.getParameter("s_fs_narration");
		String s_request_date	= request.getParameter("s_request_date");
		String s_request_by_id	= request.getParameter("s_request_by_id");
		String s_file_type		= request.getParameter("s_file_type");
		String s_volume_no		= request.getParameter("s_volume_no");
		String file_type_yn		= request.getParameter("file_type_yn");
		String access_all  = request.getParameter("access_all")==null?"":request.getParameter("access_all");

		s_file_type	=	((s_file_type==null) || (s_file_type.equals("null"))) ? "" : s_file_type;
		s_file_type	=	((s_volume_no==null) || (s_volume_no.equals("null"))) ? "" : s_volume_no;

		String facname		= "";
		String locations	= "";
		String locnname		= "";		
		String no_of_days	= "";
		String prevfacility = "";
		String fac_id		= "";		
		
		StringBuffer SelectSqlBuffer = null;
		SelectSqlBuffer				 = new StringBuffer();

		int i			= 1;
		int rowid		= 2;
		int ReqnoList2	= 0;

		try 
		{
			if(userSecurity.equals("Y")) 
			{				

				if(access_all.equals("*ALL")) 
				{
					SelectSqlBuffer.append("SELECT B.REQ_FACILITY_ID, B.REQ_FACILITY_NAME, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, COUNT(A.FILE_NO) CNT FROM FM_REQ_DTL A, FM_REQ_HDR_VW B, FM_CURR_LOCN C WHERE	A.REQ_TO_FACILITY_ID = '"+facility_id+"' AND A.REQ_TO_FS_LOCN_CODE = '"+strLocn+"' AND A.ISS_YN = 'N' AND A.REQ_NO = B.REQ_NO AND A.FILE_NO = C.FILE_NO AND A.VOLUME_NO = C.VOLUME_NO AND B.REQ_FACILITY_ID != A.REQ_TO_FACILITY_ID AND B.ISS_COMPLETED_YN = 'N' AND A.DOC_TYPE_CODE is null AND A.CANCEL_YN = 'N' AND B.REQ_FS_LOCN_CODE != C.CURR_FS_LOCN_CODE ");
				}
				else 
				{
					SelectSqlBuffer.append("SELECT B.REQ_FACILITY_ID, B.REQ_FACILITY_NAME, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, COUNT(A.FILE_NO) CNT FROM FM_REQ_DTL A, FM_REQ_HDR_VW B, FM_USER_ACCESS_RIGHTS C, FM_CURR_LOCN D WHERE A.REQ_TO_FACILITY_ID = '"+facility_id+"' AND A.REQ_TO_FS_LOCN_CODE = '"+strLocn+"' AND A.ISS_YN = 'N' AND A.REQ_NO = B.REQ_NO AND B.REQ_FACILITY_ID != A.REQ_TO_FACILITY_ID AND B.ISS_COMPLETED_YN = 'N' AND C.FACILITY_ID = A.REQ_TO_FACILITY_ID AND A.FILE_NO = D.FILE_NO AND A.VOLUME_NO = D.VOLUME_NO AND C.APPL_USER_ID = '"+user_id+"' AND C.FS_LOCN_CODE = A.REQ_TO_FS_LOCN_CODE AND C.ISS_ACROSS_FACILITIES_YN = 'Y' AND A.DOC_TYPE_CODE is null AND A.CANCEL_YN = 'N' AND B.REQ_FS_LOCN_CODE != D.CURR_FS_LOCN_CODE ");
				}
			}
			else 
			{
				SelectSqlBuffer.append("SELECT B.REQ_FACILITY_ID, B.REQ_FACILITY_NAME, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, COUNT(A.FILE_NO) CNT FROM FM_REQ_DTL A, FM_REQ_HDR_VW B, FM_CURR_LOCN C WHERE	A.REQ_TO_FACILITY_ID = '"+facility_id+"' AND A.REQ_TO_FS_LOCN_CODE = '"+strLocn+"' AND A.ISS_YN = 'N' AND A.REQ_NO = B.REQ_NO AND A.FILE_NO = C.FILE_NO AND A.VOLUME_NO = C.VOLUME_NO AND B.REQ_FACILITY_ID != A.REQ_TO_FACILITY_ID AND B.ISS_COMPLETED_YN = 'N' AND A.DOC_TYPE_CODE is null AND A.CANCEL_YN = 'N' AND B.REQ_FS_LOCN_CODE != C.CURR_FS_LOCN_CODE ");
			}

			if(!(s_file_no.equals("null") || s_file_no.equals("")))
			{
				SelectSqlBuffer.append("AND A.FILE_NO = '"+s_file_no+"' ");
			}
			if(!(s_volume_no.equals("null") || s_volume_no.equals("")))
			{
				SelectSqlBuffer.append("AND A.VOLUME_NO = '"+s_volume_no+"' ");
			}
			if(!(s_fs_locn_code.equals("null") || s_fs_locn_code.equals("")))
			{
				SelectSqlBuffer.append("AND B.REQ_FS_LOCN_CODE = '"+s_fs_locn_code+"' ");
			}
			if(!(s_request_by_id.equals("null") || s_request_by_id.equals("")))
			{
				SelectSqlBuffer.append("AND B.REQ_BY = '"+s_request_by_id+"' ");
			}
			if(!(s_fs_narration.equals("null") || s_fs_narration.equals("")))
			{
				SelectSqlBuffer.append("AND B.NARRATION_CODE = '"+s_fs_narration+"' ");
			}
			if(!(s_request_date.equals("null") || s_request_date.equals("")))
			{
				SelectSqlBuffer.append("AND TO_DATE(TO_CHAR(TRUNC(B.ADDED_DATE),'dd/mm/yyyy'),'dd/mm/yyyy') = TO_DATE('"+s_request_date+"','dd/mm/yyyy') ");
			}

			SelectSqlBuffer.append("GROUP BY B.REQ_FACILITY_ID, B.REQ_FACILITY_NAME, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, A.REQ_TO_FS_LOCN_CODE ");

			pstmt = con.prepareStatement(SelectSqlBuffer.toString());
			rs    = pstmt.executeQuery();

			i = 1;
			while(rs != null && rs.next())
			{
				fac_id		= rs.getString("REQ_FACILITY_ID");
				facname		= rs.getString("REQ_FACILITY_NAME");
				locations	= rs.getString("REQ_FS_LOCN_CODE");
				locnname	= rs.getString("FS_LOCN_SHORT_DESC");
				no_of_days	= rs.getString("NO_OF_DAYS_TO_RETURN");
				ReqnoList2  = rs.getInt("CNT");

				if(no_of_days == null || no_of_days.equals("null")) no_of_days = "";

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
					out.println("<a name='"+rowid+"' onClick='changeRowColor(this,1)' href=\"javascript:OnSelect('"+locations+"','"+s_file_no+"','"+no_of_days+"','"+fac_id+"','"+strLocn+"', '"+s_file_type+"', '"+s_volume_no+"', '"+file_type_yn+"')\">");
					out.println(locnname+"</a> ("+ReqnoList2+")</font></td></tr>");
					i++;
					rowid++;
				}
			}
		if(rs	 !=null)	rs.close();
		if(pstmt !=null)	pstmt.close();
		}
		catch(Exception e)
		{
			out.println("Exception e :"+e);
		}
		finally
		{			
			ConnectionManager.returnConnection(con,request);
		}
	%>
	</table>
</form>
<script>
	if(parent.frames[0].document.forms[0].noofrecs.value == 1)
		OnSelect('<%=locations%>','<%=s_file_no%>','<%=no_of_days%>','<%=fac_id%>','<%=strLocn%>', '<%=s_file_type%>', '<%=s_volume_no%>', '<%=file_type_yn%>');
</script>
</body>
</html>

