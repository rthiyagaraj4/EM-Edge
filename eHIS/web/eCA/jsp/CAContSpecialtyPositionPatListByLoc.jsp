<%
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
01/31/2024   49654      Twinkle Shah    Ramesh Goli      ML-MMOH-CRF-2109
--------------------------------------------------------------------------------------------------------
*/
%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='javascript' src='../../eCA/js/CAContSpecialtyPositionPatListByLoc.js'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	</head>

	<iframe name='f_query_add_mod_query' id='f_query_add_mod_query' 	 src='../../eCA/jsp/CAContSpecialtyPositionPatListByLocQuery.jsp' frameborder=0 noresize scrolling='no' frameborder='0' style='height:55%;width:100vw'></iframe><iframe name='f_query_add_mod_res' id='f_query_add_mod_res' 	 src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' frameborder='0' style='height:100vh;width:100vw'></iframe>
</html>

