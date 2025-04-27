<!DOCTYPE html>
<!-- Created for ML-MMOH-CRF-0687 -->
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
 	<script language='javascript' src='../../eDS/js/DSMealComplaint.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js' ></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script language="Javascript" src="../../eDS/js/json.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
<%
	String params = request.getQueryString();
%>
	<iframe name='query_criteria' id='query_criteria' src='../../eDS/jsp/DSMealComplaintsQueryCriteria.jsp' scrolling='no' frameborder=0 noresize style='height:23vh;width:100vw'></iframe>
	<iframe name='query_result' id='query_result'	src='../../eCommon/html/blank.html' frameborder=0 noresize  style='height:77vh;width:100vw'></iframe>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name="QueryForm" id="QueryForm">
			<input type="hidden" name="params" id="params" value="<%=params%>">			
		</form>
	</body>
</html>

