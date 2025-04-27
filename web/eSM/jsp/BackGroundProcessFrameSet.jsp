<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%
          request.setCharacterEncoding("UTF-8");
          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eSM/js/BackGroundProcesses.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
	<iframe name='list' id='list'	src='../../eSM/jsp/BackGroundProcessQuery.jsp' frameborder=0 scrolling='auto' noresize style='height:57vh;width:100vw'></iframe>
		<iframe name='list1' id='list1'	src='../../eSM/jsp/BackGroundProcessRefresh.jsp' frameborder=0 scrolling='no' noresize style='height:5vh;width:100vw'></iframe>
		<iframe name='add_mod' id='add_mod' 	src='../../eSM/jsp/BackGroundProcessAddModify.jsp' frameborder=0 style='height:36vh;width:100vw'></iframe>
</html>

