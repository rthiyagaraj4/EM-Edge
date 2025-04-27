<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
	<head>
	<script language='JavaScript' src='../../eCommon/js/ValidateControl.js'></script>
 	<script language='javascript' src='../../eOH/js/PeriodontalChart.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
	String params = request.getQueryString() ;
	%>
	<iframe name='PerioToothApplicabilityHeader' id='PerioToothApplicabilityHeader'	src="../../eOH/jsp/PerioToothApplicabilityHeader.jsp?<%= params %>" frameborder=0 scrolling='no' style='height:7%;width:100vw'></iframe><iframe name='PerioToothApplicabilityDetails' id='PerioToothApplicabilityDetails' src='../../eCommon/html/blank.h</iframe>tml?<%= params %>' frameborder=0 scrolling='auto'>
		<iframe name='PerioToothApplicabilityFooter' id='PerioToothApplicabilityFooter' src='../../eCommon/html/blank.html?<%= params %>' frameborder=0 scrolling='auto'>
		<iframe name='hidden_frame' id='hidden_frame'	frameborder="0" src='../../eOH/jsp/CommonMasterObjectCollect.jsp'  noresize style='height:30%;width:100vw'></iframe>
	
	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
	<form>
	<input type="hidden" name="source" id="source" value="<%=params%>">
	</form>
</html>

