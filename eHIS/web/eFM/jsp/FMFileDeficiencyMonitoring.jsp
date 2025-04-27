<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eFM/js/FMFileDeficiencyMonitoring.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<%
	String url		= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	String source	= url + params;

	Connection con			= ConnectionManager.getConnection(request);
	java.sql.Statement stmt	= null;
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;
	
	

	String facility_id	= (String) session.getValue("facility_id");
	String user_id		= (String) session.getValue("login_user");

	
	String sql				= "";
	String userSecurity		= "";
	String access_all		= "";
	String dflt_incomplete_fs_locn_code = "";
	String mntr_fldfcy_inc_fslocn_ntdf_yn = "";

	int userVal		= 0;
	int checkVal	= 0;

	try
	{
		stmt = con.createStatement();
		sql  = "Select COUNT(*) cnt from SM_MODULE where module_id='IP' and INSTALL_YN = 'Y' ";
		rs = stmt.executeQuery(sql);
		if(rs != null && rs.next())
		{
			userVal = rs.getInt(1);
		} if(rs != null) rs.close();
		
		if(userVal == 0)
		{
			out.println("<script> alert(getMessage(\"NO_ACCESS_FOR_DEFICIENCY\",\"FM\")); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");
		}
		else
		{
			sql = "";
			sql = "Select USER_SECURITY_YN,DFLT_INCOMPLETE_FS_LOCN_CODE,MNTR_FLDFCY_INC_FSLOCN_NTDF_YN from FM_PARAMETER where facility_id = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			rs = pstmt.executeQuery();

			if(rs != null && rs.next())
			{
				 userSecurity = rs.getString("USER_SECURITY_YN");
				 dflt_incomplete_fs_locn_code = rs.getString("DFLT_INCOMPLETE_FS_LOCN_CODE");
				 mntr_fldfcy_inc_fslocn_ntdf_yn = rs.getString("MNTR_FLDFCY_INC_FSLOCN_NTDF_YN");
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			if(userSecurity == null || userSecurity.equals("null")) userSecurity = "N";
			if(dflt_incomplete_fs_locn_code == null || dflt_incomplete_fs_locn_code.equals("null")) dflt_incomplete_fs_locn_code = "";
			if(mntr_fldfcy_inc_fslocn_ntdf_yn == null || mntr_fldfcy_inc_fslocn_ntdf_yn.equals("null")) mntr_fldfcy_inc_fslocn_ntdf_yn = "";

			if(userSecurity.equals("Y"))
			{
				sql = "";
				sql = "Select 1 ,fs_locn_code from FM_USER_ACCESS_RIGHTS where FACILITY_ID = ?  and APPL_USER_ID = ? and DEFICIENCY_CHECK_YN = 'Y' ";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,user_id);				
				rs = pstmt.executeQuery();

				if(rs != null && rs.next())
				{
					 checkVal = rs.getInt(1);
					 access_all = rs.getString("fs_locn_code");
				}

				if(checkVal != 1)
				{
					out.println("<script> alert(getMessage(\"FM_NO_USER_RIGHTS\",\"FM\")); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");
				}
			}
		}
	if(rs!=null)	rs.close();
	if(stmt!=null)	stmt.close();
	if(pstmt!=null)	pstmt.close();
	}catch(Exception e){out.println(e);}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='deficiency_header' id='deficiency_header' src='../../eFM/jsp/FMFileDeficiencyMonitoringHeader.jsp?userSecurity=<%=userSecurity%>&access_all=<%=access_all%>&dflt_incomplete_fs_locn_code=<%=dflt_incomplete_fs_locn_code%>&mntr_fldfcy_inc_fslocn_ntdf_yn=<%=mntr_fldfcy_inc_fslocn_ntdf_yn%>'frameborder='0' noresize scrolling='no' style='height:20vh;width:100vw'></iframe>
	<iframe name='deficiency_result' id='deficiency_result' src='../../eCommon/html/blank.html' noresize frameborder='0' scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
	<iframe name='deficiency_detail' id='deficiency_detail' src='../../eCommon/html/blank.html' noresize frameborder='0' scrolling='auto' noresize style='height:20vh;width:100vw'></iframe>
	<iframe name='deficiency_detail_add' id='deficiency_detail_add' src='../../eCommon/html/blank.html' frameborder='0'noresize scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder='0' noresize style='height:12vh;width:100vw'></iframe>
	
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

