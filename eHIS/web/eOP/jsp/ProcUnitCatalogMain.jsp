<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
	<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!-- <script language='javascript' src='../js/NursingUnit.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%
		request.setCharacterEncoding("UTF-8");
		String called_from = request.getParameter("called_from");
%>

<iframe name='Search' id='Search'	src='../../eOP/jsp/ProcUnitCatalogSearch.jsp?called_from=<%=called_from%>' frameborder=0 scrolling='no' noresize style='height:25vh;width:100vw'></iframe>
	<iframe name='Result' id='Result' 		src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:75vh;width:100vw'></iframe>
	<iframe name='Dummy' id='Dummy' 		src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:0vh;width:100vw'></iframe>

</html>

