<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
</head>
<body  class='CONTENT' onKeyDown="lockKey()">
<form name="SurgeonDiaryMaintainScheduleTitles" id="SurgeonDiaryMaintainScheduleTitles"  onload='FocusFirstElement()'>
<table border="1" width="100%" cellspacing='0' cellpadding=3 align='center'>
<!-- header-->
<th class='columnHeaderCenter' width="15	%"><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/>
</th>
<th class='columnHeaderCenter' width="20%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
</th>
<th class='columnHeaderCenter' width="15%">
	<fmt:message key="Common.BookingDate.label" bundle="${common_labels}"/>
</th>
<th class='columnHeaderCenter' width="10%">
	<fmt:message key="Common.day.label" bundle="${common_labels}"/>
</th>
<th class='columnHeaderCenter' width="20%">
	<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
	<fmt:message key="Common.code.label" bundle="${common_labels}"/>
</th>
<th class='columnHeaderCenter' width="20%">
	<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
	<fmt:message key="Common.name.label" bundle="${common_labels}"/>
</th>
<th class='columnHeaderCenter' width="10%">
	<fmt:message key="Common.delete.label" bundle="${common_labels}"/>
</th>
</tr>
<!--</table>-->

