<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
 	<script language='javascript' src='../../eDS/js/MealStatistics.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
<%
	String params = request.getQueryString() ;

	%>
	<iframe name='query_criteria' id='query_criteria' src='../../eDS/jsp/MealStatisticsQueryCriteria.jsp' frameborder=0 noresize style='height:20vh;width:97vw'></iframe>
	<iframe name='query_result' id='query_result'	src='../../eCommon/html/blank.html' frameborder=0 noresize  style='height:76vh;width:97vw'></iframe>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name="QueryForm" id="QueryForm">
			<input type="hidden" name="params" id="params" value="<%=params%>">
		</form>
	</body>
</html>

