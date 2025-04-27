<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	17/06/2002
	Module			:	FM - Change File Return Date.
	Function		:	This function is used call from the main menu.
-->
<%@ page import="java.sql.*, java.util.*, webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
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
	<script language='javascript' src='../../eFM/js/FMChFileRetDate.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;

	String facility_id = "", login_user = "", sql = "";

	String url		= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	String source	= url + params ;

	String p_accass_all		= "";
	String user_security_yn = "";		
			int userVal = 0;
	try
	{
		con			= ConnectionManager.getConnection(request);
		facility_id	= (String)session.getValue("facility_id");
		login_user	= (String)session.getValue("login_user");
		
		stmt = con.createStatement();
		
		sql = "Select user_security_yn from fm_parameter where facility_id = '"+facility_id+"' ";
		rs  = stmt.executeQuery(sql);

		if(rs.next())
		{
			 user_security_yn = rs.getString("user_security_yn");
		}
		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();		

		if(user_security_yn == null || user_security_yn.equals("null"))
		user_security_yn = "";

		if(user_security_yn.equals("Y"))
		{
			stmt = con.createStatement();

			String sql1 = "select 1,fs_locn_code from fm_user_access_rights where facility_id = ? and appl_user_id = ? and change_return_date_yn='Y' ";
			
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,login_user);
			
			rs  = pstmt.executeQuery();
			
			if(rs != null && rs.next())
			{
			      userVal = rs.getInt(1);
				 p_accass_all = rs.getString("fs_locn_code");
				
			}
			if(userVal != 1) 
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
		if(stmt!=null)  stmt.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e);
	}
	finally
	{		
		ConnectionManager.returnConnection(con, request);
	}
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling=no noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_a</iframe>dd_mod' src='../../eFM/jsp/FMChFileRetDateMain.jsp?user_security_yn=<%=user_security_yn%>&p_accass_all=<%=p_accass_all%>' frameborder='0' scrolling='no' style='height:84vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder='0' noresize style='height:8vh;width:100vw'></iframe>
	
</html>

