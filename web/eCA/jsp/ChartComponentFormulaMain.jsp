<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String queString = request.getQueryString();	
%>
<html>
	<head>
		<title><fmt:message key="eCA.FormulaDefinitionForChartComponents.label" bundle="${ca_labels}"/></title>
		<script language='javascript' src='../../eCA/js/ChartComponent.js'></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<iframe name='chartSectionComponentListFrame' id='chartSectionComponentListFrame' src='../../eCA/jsp/ChartComponentSectionList.jsp?<%=request.getQueryString()%>' frameborder='0' scrolling='auto' noresize style='height:38vh;width:100vw'></iframe>
		<iframe name='chartSectionFormulaConstructionFrame' id='chartSectionFormulaConstructionFrame' src='../../eCommon/html/blank.html' frameborder='0' scrolling='auto' noresize style='height:50vh;width:99vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder="no" scrolling="no" noresize style='height:8vh;width:100vw'></iframe>
		<iframe name="blankframeformula" id="blankframeformula" src="../../eCommon/html/blank.html"    scrolling="no"  frameborder=0 style="height:0%;width:100vw"></iframe>
</html>

