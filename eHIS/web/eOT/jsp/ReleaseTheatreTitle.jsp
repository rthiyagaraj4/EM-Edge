<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
</head>
<body  class='CONTENT' onKeyDown="lockKey()">
<form name="theatretitle" id="theatretitle"  onload='FocusFirstElement()'>
<table border="1" width="100%" cellspacing='0' cellpadding=3 align='center'>
<th class='columnHeaderCenter'><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/>
	<fmt:message key="Common.code.label" bundle="${common_labels}"/>
</th>
<th class='columnHeaderCenter'><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/>
	<fmt:message key="Common.description.label" bundle="${common_labels}"/>
</th>
<th class='columnHeaderCenter'>
	<fmt:message key="Common.block.label" bundle="${common_labels}"/>
	<fmt:message key="Common.date.label" bundle="${common_labels}"/>
</th>
<th class='columnHeaderCenter'>
	<fmt:message key="Common.fromtime.label" bundle="${common_labels}"/>
</th>
<th class='columnHeaderCenter'>
	<fmt:message key="Common.totime.label" bundle="${common_labels}"/>
</th>
<th class='columnHeaderCenter'>
	<fmt:message key="Common.Release.label" bundle="${common_labels}"/>
</th>
<th class='columnHeaderCenter'>
	<fmt:message key="Common.reason.label" bundle="${common_labels}"/>
</th>
</tr>
</table>
</form>
</body>
</html>

