<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	10/06/2002
	Module			:	FM - Assign File Store Location
	Function		:	This function is used call from the main menu.
-->
<%@ page import="java.sql.*, java.util.*, webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
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
	<script language='javascript' src='../../eFM/js/FMAssignStorageLocn.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection con			= null;
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;
	
	String facility_id = "", login_user = "", sql = "";

	String url		= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	String source	= url + params ;
		
	try
	{
		con			=	ConnectionManager.getConnection(request);
		facility_id	=	(String)session.getValue("facility_id");
		login_user	=	(String)session.getValue("login_user");
		
		String user_security_yn = "";
		
		sql		= "Select user_security_yn from fm_parameter where facility_id = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1,facility_id);
		
		rs		= pstmt.executeQuery();
		
		if(rs != null && rs.next())
		{
			 user_security_yn = rs.getString("user_security_yn");
		}
		if(rs != null) rs.close(); if(pstmt != null) pstmt.close();
		
		if(user_security_yn == null || user_security_yn.equals("null"))
		user_security_yn = "";
	
		if(user_security_yn.equals("Y"))
		{
			String sql1 = "select 1 from fm_user_access_rights where facility_id = ? and appl_user_id = ? and assign_fs_locn_yn = 'Y' ";

			pstmt = con.prepareStatement(sql1);
			
			pstmt.setString(1,facility_id);
			pstmt.setString(2,login_user);
			
			rs = pstmt.executeQuery();

			if(!rs.next())
			{
			%>
				<script>
					var errortext = getMessage('FM_NO_USER_RIGHTS','FM');
					alert(errortext);
					parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
				</script>	

			<%				
			}
		}
	if(rs!=null)	rs.close();		
	if(pstmt!=null) pstmt.close();
	}catch(Exception e){out.println("Exception while fetching connection :"+e);}
	finally
	{					
		ConnectionManager.returnConnection(con, request);		
	}
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling=no noresize style='height:7vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eFM/jsp/FMAssignStorageLocnMain.jsp' frameborder='0' scrolling='no' style='height:83vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder='0' noresize style='height:9vh;width:100vw'></iframe>
	
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

