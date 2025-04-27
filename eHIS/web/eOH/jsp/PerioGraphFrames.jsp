<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
		request.setCharacterEncoding("UTF-8");
		String queryString = request.getQueryString() == null ? "" : request.getQueryString();
%>

<html>
	<head>
		<title><fmt:message key="eCA.Viewgraph.label" bundle="${ca_labels}"/></title>
		<script src="../../eCommon/js/common.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<iframe name='perioGraphCustomList' id='perioGraphCustomList' src='../../eOH/jsp/PatientChartHeader.jsp?<%=queryString%>' scrolling='auto'  style='height:18%;width:100vw'></iframe> 
			<iframe name='perioGraphCustomList' id='perioGraphCustomList' src='../../eOH/jsp/PerioCustomGraphList.jsp?<%=queryString%>' scrolling='auto'  style='height:26%;width:100vw'></iframe> 
			<iframe name='perioGraphCustomBuccalView' id='perioGraphCustomBuccalView' src='../../eOH/jsp/PerioBuccalGraph.jsp?<%=queryString%>' scrolling='auto'  style='height:270%;width:100vw'></iframe>
			<iframe name='perioGraphCustomBuccalTable' id='perioGraphCustomBuccalTable' src='../../eOH/jsp/PerioGraphBuccalTableView.jsp?<%=queryString%>' scrolling='auto'  style='height:50%;width:100vw'></iframe>
			<iframe name='perioGraphCustomPalatalView' id='perioGraphCustomPalatalView' src='../../eOH/jsp/PerioPalatalGraph.jsp?<%=queryString%>' scrolling='auto'  style='height:270%;width:100vw'></iframe>
			<iframe name='perioGraphCustomPalatalTable' id='perioGraphCustomPalatalTable' src='../../eOH/jsp/PerioGraphPalatalTableView.jsp?<%=queryString%>' scrolling='auto'  style='height:100vh;width:100vw'></iframe> 
		
	</html>

