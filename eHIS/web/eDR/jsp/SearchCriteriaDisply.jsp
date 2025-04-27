
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title> <fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/> </title>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/SearchCriteriaMain.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String criteria	= request.getParameter("criteria");
	String display	= request.getParameter("display");

	if(criteria == null) criteria = "dflt";
	if(display == null) display = "";
	
%>
	<!-- <iframe name='dummy2' id='dummy2' src=""  scrolling='no' noresize style='height:4vh;width:100vw'></iframe>-->
		<iframe name='f_query_add_mod' id='f_query_add_m</iframe>od' src='../../eDR/jsp/SearchCriteriaMain.jsp?criteria=<%=criteria%>&display=<%=display%>' scrolling='no' style='height:100vh;width:100vw' FRAMEBORDER="0"></iframe>
		<!-- <iframe name='dummy1' id='dummy1' src='' scrolling='no'  noresize style='height:2vh;width:100vw'></iframe>-->
	
</html>

