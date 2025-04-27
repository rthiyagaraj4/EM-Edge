<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ReviewResults.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onLoad='FocusFirstElement();' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name=review_results_hdg>
<table cellpadding=3 cellspacing=0 border=1  id='titleTab' width="100%">
	<tr><td class=columnheader width='7%'><%if ((request.getParameter("groupby")).equals("E")) {%><input type=checkbox name='select_all' id='select_all' onClick='clickAll()' disabled><%}else{%><input type=checkbox name='select_all' id='select_all' onClick='clickAll()' disabled>
	<%}%></td>
	<td class=columnheader width='22%'><fmt:message key="Common.Event.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='9.5%'><fmt:message key="Common.Result.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='10%'><fmt:message key="Common.ReportedBy.label" bundle="${common_labels}"/></td>

		<%if ((request.getParameter("groupby")).equals("E")) {%>
			<td class=columnheader width='8%'><fmt:message key="eOR.ReportedAt.label" bundle="${or_labels}"/></td>
			<td class=columnheader width='14.5%'><fmt:message key="eOR.PatientDetail.label" bundle="${or_labels}"/></td>
			<td class=columnheader width='10%'><fmt:message key="eOR.ReviewType.label" bundle="${or_labels}"/></td>
			<td class=columnheader width='10%'><fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/></td>
			<!-- <th width='4%'>Rems</th> -->
			<td class=columnheader width='9%'><fmt:message key="eOR.ForwardedBy.label" bundle="${or_labels}"/></td>
		<%}else{%>
			<td class=columnheader width='10%'><fmt:message key="eOR.ReportedAt.label" bundle="${or_labels}"/></td>
			<td class=columnheader width='14%'><fmt:message key="eOR.ReviewType.label" bundle="${or_labels}"/></td>
			<td class=columnheader width='14%'><fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/></td>
			<!-- <th width='5.5%'>Rems</th> -->
			<td class=columnheader width='10%'><fmt:message key="eOR.ForwardedBy.label" bundle="${or_labels}"/></td>
		<%}%>
		
	</tr>
</table>
</form>
</body>
<script>
	parent.ReviewResultsResult.location.href="ReviewResultsDetail.jsp?<%=request.getQueryString()%>"
</script>
</html>

