<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	25/06/2002
	Module/Function	:	FM/Generate Pulling List 
	Function		:	This function is used call from the main menu.
-->
<%@ page import="java.sql.*, java.util.*, webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
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
	<script language='javascript' src='../../eFM/js/FMIPGeneratePullList.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head> 
<%
	Connection con	=	null;
	Statement stmt	=	null;
	ResultSet rs	=	null;
	PreparedStatement stmt1=null;
	ResultSet rs1=null;
	String sql1 = "";
	String facility_id="", login_user="", sql="";
	String user_security_yn="";
	String access_all = "";

	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String function_id=request.getParameter("function_id");
     if(function_id == null) function_id = "";
	
	try
	{
		con			=	ConnectionManager.getConnection(request);
		facility_id	=	(String)session.getValue("facility_id");
		login_user	=	(String)session.getValue("login_user");
		String install_yn="";
		String row_count = "";		

		stmt	=	con.createStatement();
		
		sql=" Select install_yn from sm_module where module_id = 'IP' ";
		rs = stmt.executeQuery(sql);

		if(rs.next())
		{
			 install_yn = rs.getString("install_yn");
		}
		if(stmt!=null) stmt.close();
		if(rs!=null)	rs.close();

		if(install_yn == null || install_yn.equals("null"))
		install_yn = "N";

		if(install_yn.equals("Y"))
		{
			String fm_param_query="select user_security_yn from fm_parameter where facility_id='"+facility_id+"'";			
			
			stmt	=	con.createStatement();
			rs = stmt.executeQuery(fm_param_query);
			
			if(rs.next())
			{
				user_security_yn	=	rs.getString("user_security_yn");
			}
			if(stmt!=null) stmt.close();
			if(rs!=null)	rs.close();
			
			if(user_security_yn.equals("Y"))
			{					
				sql1 = "Select 1, fs_locn_code from FM_USER_ACCESS_RIGHTS where FACILITY_ID = ? and APPL_USER_ID = ? and TRACK_OUT_TO_IPW_YN = 'Y'";

				stmt1 = con.prepareStatement(sql1);
				stmt1.setString(1,facility_id);
				stmt1.setString(2,login_user);
				rs1   = stmt1.executeQuery();

				if(rs1.next())
				{
					row_count	=	rs1.getString(1);
					access_all = rs1.getString("fs_locn_code");
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
	if(stmt!=null) stmt.close();
	if(rs!=null)	rs.close();
	if(rs1!=null)	rs1.close();
	if(stmt1!=null) stmt1.close();
	}
	catch(Exception e)
	{
		out.println("Exception while fetching connection :"+e);
	}
	finally
	{		
		ConnectionManager.returnConnection(con, request);
	}
if(session.getAttribute("sys_date")!=null)
session.removeAttribute("sys_date");
if(session.getAttribute("sysdate")!=null)
session.removeAttribute("sysdate");
if(session.getAttribute("customer_id")!=null)
session.removeAttribute("customer_id");

%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling=no noresize style='height:6vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eFM/jsp/FMIPGeneratePullListMain.jsp?function_id=<%=function_id%>&user_security_yn=<%=user_security_yn%>&access_all=<%=access_all%>' frameborder='0' scrolling='no' style="height: 84vh; width: 100vw; margin-left: 20px;"></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder='0' noresize style='height:10vh;width:100vw'></iframe>
<iframe name='submit_frame' id='submit_frame' src='../../eCommon/html/blank.html' scrolling='no' frameborder='0' noresize style='height:0%;width:100vw'></iframe>


<form>	    
	<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
    </form>
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

