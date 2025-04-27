<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.* "  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title>SplChartKeyIntervalListHdr</title>
	<script src='../../eCA/js/SplChartKey.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
    request.setCharacterEncoding("UTF-8");
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
</head>

<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<!--<table cellpadding='3' cellspacing='0' border='0' width='50%' align='center' bgcolor='blue'>
<tr>
	<td class='COLUMNHEADERCENTER'  width='15%'><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='15%'><fmt:message key="Common.Key.label" bundle="${common_labels}"/> <fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER'  width='70%'><fmt:message key="Common.Range.label" bundle="${common_labels}"/></td>
</tr>
</table>-->
</body>
</html>

