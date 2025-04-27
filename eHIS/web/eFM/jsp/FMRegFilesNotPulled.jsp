<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	25/06/2002
	Module/Function	:	FM/Register Files Not Pulled
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
	<script language='javascript' src='../../eFM/js/FMRegFilesNotPulled.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection con	=	null;
	Statement stmt	=	null;
	ResultSet rs	=	null;

	String facility_id="", login_user="", sql="";

	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	
	try
	{
		con			=	ConnectionManager.getConnection(request);
		facility_id	=	(String)session.getValue("facility_id");
		login_user	=	(String)session.getValue("login_user");
		String install_yn="";
		String row_count = "";
		String user_security_yn="";
		stmt	=	con.createStatement();
		
		sql=" Select install_yn from sm_module where module_id = 'OA' ";
		rs = stmt.executeQuery(sql);

		if(rs.next())
		{
			 install_yn = rs.getString("install_yn");
		}
		if(rs!=null)	rs.close();	
		if(stmt!=null) stmt.close();

		if(install_yn == null || install_yn.equals("null"))
		install_yn = "N";

		if(install_yn.equals("Y"))
		{
			String fm_param_query="select user_security_yn from fm_parameter where facility_id='"+facility_id+"'";
			
			if(stmt != null)stmt=null;	
			stmt	=	con.createStatement();
			rs = stmt.executeQuery(fm_param_query);
			
			if(rs.next())
			{
				user_security_yn	=	rs.getString("user_security_yn");
			}
			if(rs!=null)	rs.close();	
			if(stmt!=null) stmt.close();
			
			if(user_security_yn.equals("Y"))
			{
				if(stmt != null)stmt=null;	
				stmt =con.createStatement();
				sql = "Select 1 from FM_USER_ACCESS_RIGHTS where FACILITY_ID = '"+facility_id+"' and FS_LOCN_CODE = '*ALL' and APPL_USER_ID = '"+login_user+"' UNION Select 1 from FM_USER_ACCESS_RIGHTS  where APPL_USER_ID='"+login_user+"' and FACILITY_ID = '"+facility_id+"' and TRACK_OUT_TO_OPD_YN ='Y'";
				rs = stmt.executeQuery(sql);

				if(rs.next())
				{
					row_count	=	rs.getString(1);
				}

				if(!row_count.equals("1"))
				{					
					out.println("<script> alert(getMessage('FM_NO_USER_RIGHTS','FM')); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");
				}
			}
		}
		else
		{			
			out.println("<script> alert(getMessage('FM_NO_USER_RIGHTS','FM')); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");

		}
	if(rs!=null)	rs.close();	
	if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception while fetching connection :"+e);
	}
	finally
	{		
		ConnectionManager.returnConnection(con, request);
	}

%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling=no noresize style='height:8%;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eFM/jsp/FMRegFilesNotPulledMain.jsp' frameborder='0' scrolling='no'>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder='0' noresize style='height:100vh;width:100vw'></iframe>


</html>

