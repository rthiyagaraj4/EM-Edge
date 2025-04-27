<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
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
	<script language='javascript' src='../../eFM/js/FMConfirmReceiptFiles.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	
		Connection con				= ConnectionManager.getConnection(request);
		ResultSet rs				= null;
		java.sql.Statement stmt		= null;
		PreparedStatement pstmt		= null;
		
		String maintain_doc_or_file = "";
		
		String facility_id	= (String) session.getValue("facility_id");
		String user_id		= (String) session.getValue("login_user");
	
		String sql							= "";
		String sql1							= "";
		String userSecurity					= "";
		String Auto_rec_ward				= "";
		String Auto_rec_clinic				= "";
		String Auto_rec_pract				= "";
		String Auto_rec_dept				= "";
		String Auto_rec_external			= "";
		String auto_rec_procedure_yn		= "";
		String auto_rec_daycare_yn			= "";
		String DFLT_ARCHIVE_FS_LOCN_CODE	= "";
		String DFLT_LOST_FS_LOCN_CODE		= "";

		int rec_cnt = 0;
		String userVal="";
		
		try
		{
			String url		= "../../eCommon/jsp/commonToolbar.jsp?";
			String params	= request.getQueryString() ;
			String source	= url + params;

			stmt = con.createStatement();

			rs = stmt.executeQuery("SELECT maintain_doc_or_file FROM mp_param");
			if(rs != null && rs.next())
			{
				maintain_doc_or_file = rs.getString("maintain_doc_or_file");
			} if(rs != null) rs.close();
		
			if(maintain_doc_or_file == null || maintain_doc_or_file.equals("null"))
				maintain_doc_or_file = "";

			sql = "Select AUTO_REC_WARD_YN, AUTO_REC_CLINIC_YN, AUTO_REC_PRACT_YN, AUTO_REC_DEPT_YN, AUTO_REC_EXTERNAL_YN,USER_SECURITY_YN,auto_rec_procedure_yn,auto_rec_daycare_yn,DFLT_ARCHIVE_FS_LOCN_CODE,DFLT_LOST_FS_LOCN_CODE from FM_PARAMETER where FACILITY_ID = ? ";
				   
			pstmt	= con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			rs		= pstmt.executeQuery();

			if(rs != null && rs.next())
			{
				 Auto_rec_ward				=  checkForNull(rs.getString(1));
				 Auto_rec_clinic			=  checkForNull(rs.getString(2));
				 Auto_rec_pract				=  checkForNull(rs.getString(3));
				 Auto_rec_dept				=  checkForNull(rs.getString(4));
				 Auto_rec_external			=  checkForNull(rs.getString(5));
				 userSecurity				=  checkForNull(rs.getString(6));
				 auto_rec_procedure_yn		=  checkForNull(rs.getString(7));
				 auto_rec_daycare_yn		=  checkForNull(rs.getString(8));
				 DFLT_ARCHIVE_FS_LOCN_CODE	=  checkForNull(rs.getString(9));
				 DFLT_LOST_FS_LOCN_CODE		=  checkForNull(rs.getString(10));
				 
			} if(rs != null) rs.close(); if(pstmt != null) pstmt.close();

			if(Auto_rec_ward.equals("Y") && Auto_rec_clinic.equals("Y") && Auto_rec_pract.equals("Y") && Auto_rec_dept.equals("Y") && Auto_rec_external.equals("Y"))
			{
				if(maintain_doc_or_file.equals("D"))
				{
					out.println("<script> alert(getMessage(\"NO_CONFIRM_RECEIPT_DOC\",\"FM\")); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");
				}
				else if(maintain_doc_or_file.equals("F"))
				{
					out.println("<script> alert(getMessage(\"NO_CONFIRM_RECEIPT\",\"FM\")); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");
				}
			}
			if(userSecurity.equals("Y"))
			{
				sql1 = "Select 1 rec_cnt , fs_locn_code from FM_USER_ACCESS_RIGHTS where FACILITY_ID = ?  and APPL_USER_ID = ? and CONFIRM_RECEIPT_FILE_YN = 'Y' ";
				
				pstmt = con.prepareStatement(sql1);

				pstmt.setString(1,facility_id);
				pstmt.setString(2,user_id);
								
				rs = pstmt.executeQuery();

				if(rs != null && rs.next())
				{
					 rec_cnt = rs.getInt(1); //Modified by S.Sathish for IN021089 on Friday, April 30, 2010
					 userVal =  rs.getString("fs_locn_code");
				} 
				if(rec_cnt != 1)
				{
					out.println("<script> alert(getMessage(\"FM_NO_USER_RIGHTS\",\"FM\")); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");
				}
			}
			
			%>
			<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling=no noresize style='height:8vh;width:100vw'></iframe>
			<iframe name='receipt_header' id='receipt_header' src='../../eFM/jsp/FMConfirmReceiptFilesHeader.jsp?doc_or_file=<%=maintain_doc_or_file%>&accessAll=<%=userVal%>&auto_rec_ward_yn=<%=Auto_rec_ward%>&auto_rec_clinic_yn=<%=Auto_rec_clinic%>&auto_rec_procedure_yn=<%=auto_rec_procedure_yn%>&auto_rec_daycare_yn=<%=auto_rec_daycare_yn%>&auto_rec_pract_yn=<%=Auto_rec_pract%>&auto_rec_dept_yn=<%=Auto_rec_dept%>&USER_SECURITY_YN=<%=userSecurity%>&AUTO_REC_EXTERNAL_YN=<%=Auto_rec_external%>&DFLT_ARCHIVE_FS_LOCN_CODE=<%=DFLT_ARCHIVE_FS_LOCN_CODE%>&DFLT_LOST_FS_LOCN_CODE=<%=DFLT_LOST_FS_LOCN_CODE%>' frameborder=0 scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
			<iframe name='receipt_criteria' id='receipt_criteria' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:20vh;width:100vw'></iframe>
			<iframe name='receipt_details' id='receipt_details' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:40vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder='0' noresize style='height:12vh;width:100vw'></iframe>
			
		<%
		if(rs!=null)	rs.close();
		if(stmt!=null)  stmt.close();
		if(pstmt!=null) pstmt.close();
		}catch(Exception e){out.println(e);}
		finally
		{					
				ConnectionManager.returnConnection(con,request);			
		}
		%>
</html>
<%

if(session.getAttribute("username")!=null)
session.removeAttribute("username");
if(session.getAttribute("objKey")!=null)
session.removeAttribute("objKey");
%>
<%!

public static String checkForNull(String inputString)
{
	return ( ( (inputString == null) || (inputString.equals("null") ) ) ? "" : inputString );
}

public static String checkForNull(String inputString, String defaultValue)
{
	return ( ( (inputString == null) || (inputString.equals("null") ) ) ? defaultValue : inputString );
}
%>

