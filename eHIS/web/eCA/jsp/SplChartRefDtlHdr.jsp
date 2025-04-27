<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title>SplChartRefDtlHdr</title>
	<script src='../../eCA/js/SplChartRef.js' language='javascript'></script>
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
<!--<table cellpadding='3' cellspacing='0' border='1' width='98%' align='center' bgcolor='blue'>
<tr>
	<td class='COLUMNHEADERCENTER'  width='14%'><fmt:message key="Common.Range.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER'  width='8%'><fmt:message key="eCA.Median.label" bundle="${ca_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='8%'><fmt:message key="Common.Variance.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='8%'><fmt:message key="eCA.Trans.label" bundle="${ca_labels}"/></td>

	<td class='COLUMNHEADERCENTER' width='6%'>P2</td>
	<td class='COLUMNHEADERCENTER' width='6%'>P5</td>
	<td class='COLUMNHEADERCENTER' width='6%'>P10</td>
	<td class='COLUMNHEADERCENTER' width='6%'>p25</td>
	<td class='COLUMNHEADERCENTER' width='6%'>P50</td>
	<td class='COLUMNHEADERCENTER' width='6%'>P75</td>
	<td class='COLUMNHEADERCENTER' width='6%'>P90</td>
	<td class='COLUMNHEADERCENTER' width='6%'>P95</td>
	<td class='COLUMNHEADERCENTER' width='6%'>P97</td>
</tr>-->
</table>
</body>
</html>

