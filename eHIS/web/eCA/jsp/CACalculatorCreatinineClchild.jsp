<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        		Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
29/05/2020	IN069908		Durga Natarajan	 	02/06/2020		Ramesh Goli			To have an additional formula for creatinine clearance calculation for children aged below 18 years old	
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
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

<form name ='CrClCh'>

	<table cellpadding=3 cellspacing=0 border=0  width ='95%' align='center' RULES=NONE>
	<tr>
		<th colspan='2' align='left'>&nbsp;<fmt:message key="eCA.CreatinineclearanceForChildren.label" bundle="${ca_labels}"/></th>
	</tr>	
	<tr>
		<td class="label"  width='40%'><fmt:message key="eCA.SerumCreatinine.label" bundle="${ca_labels}"/>&nbsp;</td>
		<td class="fields">
			<input type="text" name ="serum" size ="4" maxLength ="6" style="text-align: Right" onKeyPress="return allowValidNumber(this,event,'3','4')" > &micro;mol/L&nbsp;</td>  
	</tr>
	<tr>
		<td class="label"  width='40%'><fmt:message key="Common.height.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class="fields">
			<input type="text" name ="height" size ="5" maxLength ="4" style="text-align: Right" onKeyPress="return allowValidNumberOnKeyPress(this,event,'4','0')" onblur="allowValidNumberOnBlur(this)"> Cms</td>
	</tr>
	<tr>
		<td>
			<input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Calculate.label","ca_labels")%>' align="center" onClick='CalculateCreatinineChild()'></td>
	</tr>
	<tr>
		<td class="label"><b><fmt:message key="eCA.EstimatedGfrValue.label" bundle="${ca_labels}"/>&nbsp;</b></td>
		<td class="fields">
			<input type="text" name="gfr" id="gfr" size="5" >&nbsp;(ml/min/1.73m<sup>2</sup>)</td>
	</tr>
	<tr>
		<td class="label"><b><fmt:message key="eCA.ReferenceRange.label" bundle="${ca_labels}"/> : </b></td>
	</tr>
	<tr>
		<td  colspan='2' class="label">&nbsp;Greater than or equal to 75 mL/min/1.73 m<sup>2</sup> simply as ">= 75 mL/min/1.73 m<sup>2</sup>," not an exact number</td>
	</tr>
		
</table>
</form>
</body>
</html>
		
		
		
		

