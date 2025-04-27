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

	<iframe name='perioCompareGraphCustomList' id='perioCompareGraphCustomList' src='../../eOH/jsp/PatientCompareChartHeader.jsp?<%=queryString%>' noresize scrolling='no' style='height:55%;width:100vw'></iframe> 
			<iframe name='perioCompareGraphCustomList' id='perioCompareGraphCustomList' src='../../eOH/jsp/PerioCompareCustomGraphList.jsp?<%=queryString%>' scrolling='No' noresize style='height:20%;width:100vw'></iframe> 
 			<iframe name='perioCompareGraphCustomBuccalView' id='perioCompareGraphCustomBuccalView' src='../../eOH/jsp/PerioCompareBuccalGraph.jsp?<%=queryString%>' scrolling='auto' noresize style='height:240%;width:100vw'></iframe>
			<iframe name='perioCompareGraphCustomBuccalTable' id='perioCompareGraphCustomBuccalTable' src='../../eOH/jsp/PerioCompareGraphBuccalTableView.jsp?<%=queryString%>' scrolling='auto' noresize style='height:90%;width:100vw'></iframe>
			<iframe name='perioCompareGraphCustomPalatalView' id='perioCompareGraphCustomPalatalView' src='../../eCommon/html/blank.html?<%=queryString%>' scrolling='auto' noresize style='height:230%;width:100vw'></iframe>
			<iframe name='perioCompareGraphCustomPalatalTable' id='perioCompareGraphCustomPalatalTable' src='../../eCommon/html/blank.html?<%=queryString%>' scrolling='auto' noresize style='height:100vh;width:100vw'></iframe> 
	
</html>

