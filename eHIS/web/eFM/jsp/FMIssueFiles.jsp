<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="FMIssueFilesCart" scope="session" class="webbeans.eFM.FMFilesIssueCart"/>
<jsp:useBean id="FMIssueFileAddBean" scope="session" class="eFM.FMIssueFileAddBean"/>

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
	<script src='../../eFM/js/FMIssueFiles.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		String url			= "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params	= request.getQueryString() ;
		String prev_menu	= checkForNull(request.getParameter("prev_menu"));
		String source	= url + params;
		
		Connection con					= ConnectionManager.getConnection(request);
		java.sql.Statement stmt		= null;
		PreparedStatement pstmt	= null;
		ResultSet rs						= null;
		
		String facility_id			= (String) session.getValue("facility_id");
		String user_id			= (String) session.getValue("login_user");

		String sql					= "";
		String userSecurity		= "";
		String resLocnIdentities	= "N";
		String refresh				= "5";
		String file_doc				= "";
		String file_type_yn			= "";
		String access_all			= "";
		String p_tracer_card_yn	= "";
		String issue_file_refresh_interval	= "";//Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 18th 2014

		int userVal = 0;
		
		FMIssueFilesCart.clearCart();
	try
	{
		stmt = con.createStatement();

		sql = "select MAINTAIN_DOC_OR_FILE, file_type_appl_yn from mp_param"  ;
		//stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		if(rs != null && rs.next())
		{
			file_doc = rs.getString("MAINTAIN_DOC_OR_FILE");
			file_type_yn = rs.getString("file_type_appl_yn");
		} 
		if(rs!=null) rs.close();
		
		sql = "";
		//issue_file_refresh_interval added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 18th 2014
		sql  = "Select USER_SECURITY_YN,print_tr_card_iss_from_mr_yn,issue_file_refresh_interval from FM_PARAMETER where facility_id = '"+facility_id+"' ";
		rs   = stmt.executeQuery(sql);
		if(rs != null && rs.next())
		{
			 userSecurity = rs.getString(1);
			 p_tracer_card_yn = rs.getString("print_tr_card_iss_from_mr_yn");
			 issue_file_refresh_interval	= (rs.getString("issue_file_refresh_interval")=="" || rs.getString("issue_file_refresh_interval")==null)?"":rs.getString("issue_file_refresh_interval");
		} if(rs!=null)	rs.close();

		if(userSecurity == null || userSecurity.equals("null")) userSecurity = "N";

		if(userSecurity.equals("Y"))
		{
			sql = "";				
			sql = "Select 1, fs_locn_code from FM_USER_ACCESS_RIGHTS where FACILITY_ID = ?  and APPL_USER_ID = ?  and (ISS_YN = 'Y' or ISS_ACROSS_FACILITIES_YN = 'Y')";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,user_id);			
			rs = pstmt.executeQuery();

			if(rs != null && rs.next())
			{
				 userVal = rs.getInt(1);
				 access_all = rs.getString("fs_locn_code");
			} 

				if(userVal != 1) 
			{
				out.println("<script> alert(getMessage(\"FM_NO_USER_RIGHTS\",\"FM\")); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");
			}
		}
	if(rs!=null)	rs.close();
	if(stmt!=null)  stmt.close();
	if(pstmt!=null) pstmt.close();
	}catch(Exception e){out.println("Exception e :"+e);}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
if(session.getAttribute("username")!=null)
session.removeAttribute("username");

%>
	 <iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling=no noresize style='height:6vh;width:100vw'></iframe> 
	 <iframe name='issue_header' id='issue_header' src='../../eFM/jsp/FMIssueFilesHeader.jsp?userSecurity=<%=userSecurity%>&resLocnIdentities=<%=resLocnIdentities%>&refresh=<%=refresh%>&file_doc=<%=file_doc%>&access_all=<%=access_all%>&p_tracer_card_yn=<%=p_tracer_card_yn%>&file_type_yn=<%=file_type_yn%>&prev_menu=<%=prev_menu%>&issue_file_refresh_interval=<%=issue_file_refresh_interval%>'  frameborder=0 scrolling='no'  noresize style='height:7vh;width:100vw'></iframe>
	 <iframe name='issue_tab' id='issue_tab' src='../../eCommon/html/blank.html' frameborder='0' scrolling='no'  style='height:31vh;width:100vw'></iframe>
	 <iframe name='issue_detail' id='issue_detail' src='../../eCommon/html/blank.html' frameborder='0' scrolling='no' noresize style='height:48vh;width:100vw'></iframe>
     <iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder='0' noresize style='position: absolute; bottom: 0; left: 0; width: 100vw; height:9vh; border: none;'></iframe>
	 
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

