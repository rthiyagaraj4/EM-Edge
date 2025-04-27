<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCA/js/CACalculator.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name ='MeanBP'>
		<table  width ='95%' height='50%' border=0 cellpadding=3 cellspacing=0 align=center RULES=NONE>
		<tr><td class='COLUMNHEADER'  ><fmt:message key="eCA.MeanBloodPressure.label" bundle="${ca_labels}"/></td><td class='COLUMNHEADERCENTER'></td></tr>
		
		<tr>
		<td class ='LABEL'  width='50%'><fmt:message key="eCA.SystolicBloodPressure.label" bundle="${ca_labels}"/></td>
		<td class=fields><input type='text' name ='sBP' size ='3' class="DATA" style="text-align: Right" maxLength ='3'>&nbsp;mmHg</td>
		</tr>

		<tr>
		<td class ='LABEL' ><fmt:message key="eCA.DiastolicBloodPressure.label" bundle="${ca_labels}"/></td>
		<td class=fields><input type='text' name ='dBP' size ='3'class="DATA" style="text-align: Right" maxLength ='3'>&nbsp;mmHg</td>
		</tr>
		
		<tr>
		<td colspan=2 align=center><input type='button' value='<fmt:message key="eCA.Calculate.label" bundle="${ca_labels}"/>' onClick='javaScript:CalculateMeanBP()' class="BUTTON" ></td>
		</tr>
		
		<tr>
		<td class="data" ><fmt:message key="eCA.MeanBloodPressure.label" bundle="${ca_labels}"/></td>
		<td class=fields><input type='text' name='mBP' id='mBP' size='3' class="DATA" style="text-align: Left">&nbsp;mmHg</td>
		</tr>
		
		<tr>
		<td class ='QUERYDATA' colspan='2'>&nbsp;<fmt:message key="eCA.ReferenceRange.label" bundle="${ca_labels}"/>:</td>
		</tr>
	
		<tr>
		<td class ='LABEL' colspan ='2'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eCA.NormalmeanBPis93.3mmHg.label" bundle="${ca_labels}"/> </td>
		</tr>

</table>

</form>
</BODY>
</HTML>

