<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../js/FunctionsForRole.js'></script>
 <script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<iframe name='query_criteria' id='query_criteria' 	src='../../eOT/jsp/FunctionsForRoleMain.jsp'  scrolling='no' noresize  style='height:11vh;width:100vw'></iframe>
<iframe name='result' id='result'		src='../../eCommon/html/blank.html'  scrolling='no' noresize   style='height:89vh;width:100vw'></iframe>
</html>

