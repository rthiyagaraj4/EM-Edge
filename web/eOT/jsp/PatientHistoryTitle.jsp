<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<html>
<tr>
<table cellpadding="3" cellspacing="0" border="2" width='100%' align='center'>
	<td class='columnHeaderCenter' width="11%"> <fmt:message key="eOT.OperationDate.Label" bundle="${ot_labels}"/></td>
	<td class='columnHeaderCenter' width = "31%"> <fmt:message key="Common.operation.label" bundle="${common_labels}"/></td>
	<td class='columnHeaderCenter' width = "30%"> <fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
	<td class='columnHeaderCenter' width = "5%"> <fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	<td class='columnHeaderCenter' width = "10%"><fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
	<td class='columnHeaderCenter' width = "11%"><fmt:message key="Common.notes.label" bundle="${common_labels}"/></td>
</html>
