<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
 <%
 request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
 
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
 <script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name=color_form >
<table border=1 align='left' cellspacing='0' cellpadding='2' border='0' width='100%'>
		<tr>
				
				<!-- <td style="background-color:#99CCFF" width="20%"><font size=1 ><fmt:message key="Common.completed.label" bundle="${common_labels}"/></font></td>
				<td style="background-color:#99FFCC" width="20%"><font size=1 ><fmt:message key="Common.Due.label" bundle="${common_labels}"/></font></td>
				<td style="background-color:#99CC00" width="20%"><font size=1><fmt:message key="Common.Elapsed.label" bundle="${common_labels}"/></font></td>
				<td style="background-color:#FF8000" width="20%"><font size=1><fmt:message key="Common.InError.label" bundle="${common_labels}"/></font></td>
				<td width="20%"><font size=1><fmt:message key="Common.NotAdministered.label" bundle="${common_labels}"/></font></td> -->
			
			<td width='13%'><font size=1>&nbsp;<img src='../../eCA/images/Future.gif'>&nbsp;&nbsp;<fmt:message key="Common.Future.label" bundle="${common_labels}"/></font></td>
			<td width='13%'><font size=1>&nbsp;<img src='../../eCA/images/Due.gif'>&nbsp;&nbsp;<fmt:message key="Common.Due.label" bundle="${common_labels}"/></font></td>
			<td width='13%'><font size=1>&nbsp;<img src='../../eCA/images/OverDue.gif'>&nbsp;&nbsp;<fmt:message key="Common.Overdue.label" bundle="${common_labels}"/></font></td>
			<td width='13%'><font size=1>&nbsp;<img src='../../eCA/images/Completed.gif'>&nbsp;&nbsp;<fmt:message key="Common.completed.label" bundle="${common_labels}"/></font></td>			
			<td width='13%'><font size=1>&nbsp;<img src='../../eCA/images/Elapsed.gif'>&nbsp;&nbsp;<fmt:message key="Common.Elapsed.label" bundle="${common_labels}"/></font></td>
			<td width='13%'><font size=1>&nbsp;<img src='../../eCA/images/notadministered.gif'>&nbsp;&nbsp;<fmt:message key="eCA.ErrMrkDlt.label" bundle="${ca_labels}"/></font></td>
			<td >&nbsp;&nbsp;<font size=1><img src='../../eCA/images/In-Error.gif'>&nbsp;&nbsp;<fmt:message key="Common.NotAdministered.label" bundle="${common_labels}"/></font></td>
				
		</tr>
</table>
</form>
</body>
</html>

