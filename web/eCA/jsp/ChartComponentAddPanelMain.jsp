<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		//String queryString = request.getQueryString();
		String searchText = request.getParameter("searchText")==null ? "" : request.getParameter("searchText");
		String chart_id = request.getParameter("chart_id")==null ? "" : request.getParameter("chart_id");
%>
<html>
	<head>
		<title><fmt:message key="eCA.AddNewPanel.label" bundle="${ca_labels}"/></title>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<iframe name='chartComponentAddPanelCriteriaFrame' id='chartComponentAddPanelCriteriaFrame' src='../../eCA/jsp/ChartComponentAddPanelCriteria.jsp?searchText=<%=searchText%>&chart_id=<%=chart_id%>' frameborder='0' scrolling='no' noresize style='height:20vh;width:95vw'></iframe>
		<iframe name='chartComponentAddPanelFrame' id='chartComponentAddPanelFrame' src='../../eCA/jsp/blank.jsp' frameborder='0' scrolling='no' noresize style='height:70vh;width:95vw'></iframe>
		
</html> 

