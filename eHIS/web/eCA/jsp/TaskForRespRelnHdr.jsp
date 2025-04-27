<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eCA.TaskForResponosibilityRelationshipHeader.label" bundle="${ca_labels}"/></title>
<%request.setCharacterEncoding("UTF-8");	%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js"	language="javascript"></script>
<script src='../js/TaskForResp.js'					language='javascript'></script>
<script src="../../eCommon/js/common.js"			language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="document.formTaskForRespRelnHdr.group_by.focus();" OnMouseDown="CodeArrest()" class='CONTENT' onKeyDown="lockKey()">
<form name='formTaskForRespRelnHdr' id='formTaskForRespRelnHdr'>
<BR>
	<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
		<tr>
			<td class='label'  width='25%'><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
			<td class='fields' ><select name='group_by' id='group_by' onChange='return fetchDetailsRecords(this);'>
				<option value=""> --------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------- </option>	
				<option value="TS"><fmt:message key="Common.Task.label" bundle="${common_labels}"/></option>
				<option value="RL"><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></option>
				<option value="RS"><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/></option>
				</select><img src="../../eCommon/images/mandatory.gif"></img></td>
		</tr>
	</table>
</form>
</body>
</html>

