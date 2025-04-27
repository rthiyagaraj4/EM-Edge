<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           	    ?				?			created
30/07/2018	IN061886		Ramesh G				    					To be able to plot Growth Charts for Pre Term babies and abnormal babies.
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.* "  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title>ChartAddmodify</title>
		<script src='../../eCA/js/SplChartKey.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String xAxis_element= request.getParameter("xAxis_element")==null?"*K":request.getParameter("xAxis_element");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
</head>

<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name="SplChartKeyStaticMainHdr" id="SplChartKeyStaticMainHdr" method="post">
<table cellpadding='3' cellspacing='0' border='0' width='98%' align=center>

<tr>
	<td width='14%' nowrap>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Unit.label" bundle="${common_labels}"/>&nbsp;</td>
	<td label='fields'>
		<SELECT name="unit" id="unit">
			<%if("*K".equals(xAxis_element)){%>
			<option value = 'D' ><fmt:message key="Common.days.label" bundle="${common_labels}"/></option> 
			<option value = 'M' SELECTED ><fmt:message key="Common.months.label" bundle="${common_labels}"/></option> 
			<option value = 'Y' ><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
			<option value = 'W' ><fmt:message key="Common.weeks.label" bundle="${common_labels}"/></option> <!-- IN061886-->
			<%}else if("WT".equals(xAxis_element)){%>
			<option value = 'KG' ><fmt:message key="Common.Kgs.label" bundle="${common_labels}"/></option>
			<%}else if("BM".equals(xAxis_element)){%>
			<option value = 'KM' ><fmt:message key="eCA.kgm2.label" bundle="${ca_labels}"/></option>
			<%}else if("LN".equals(xAxis_element)||"HC".equals(xAxis_element)||"CC".equals(xAxis_element)){%>
			<option value = 'CM' ><fmt:message key="eCA.centimeters.label" bundle="${ca_labels}"/></option>
			<%}%>
		</SELECT>
	</td>
</tr>
</table>
<table cellpadding='3' cellspacing='0' border='1' width='98%' align=center>
<tr>
	<td class='COLUMNHEADERCENTER' width='30%'><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='34%'><fmt:message key="Common.Start.label" bundle="${common_labels}"/> <fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='34%'><fmt:message key="Common.End.label" bundle="${common_labels}"/> <fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
</tr>
</table>
</form>
</body>
</html>

