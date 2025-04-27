<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
	<script language='javascript' src='../js/FunctionsForStatus.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='query_criteria' id='query_criteria' 	src='../../eOT/jsp/FunctionsForStatusMain.jsp' scrolling='no' noresize  style='height:11vh;width:100vw'></iframe>
<iframe name='result' id='result'		src='../../eCommon/html/blank.html'  scrolling='no' noresize   style='height:89vh;width:100vw'></iframe>
</html>

