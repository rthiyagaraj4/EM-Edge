<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        		Description
--------------------------------------------------------------------------------------------------------
?            100            ?           		created
06/11/2012	 IN035424		Chowminya G	 		In the clinical calculator for Glomerular Filtration Rate, the Serum Creatitine unit of measure is mg/dl
22/07/2013   IN035424       Akbar				micro - included
--------------------------------------------------------------------------------------------------------
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
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


</HEAD>

<BODY class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name ='GlomerularFR'>
<table  width ='95%' height='75%' border=0 cellpadding=3 cellspacing=0 align=center RULES=NONE>
		<tr><td class='COLUMNHEADER'><fmt:message key="eCA.GlomerularFiltrationRate.label" bundle="${ca_labels}"/></td><td class='COLUMNHEADER'></td></tr>
		<tr><td colspan ='2' align ='center'><h5><fmt:message key="eCA.CorkCroft.label" bundle="${ca_labels}"/></h5></td></tr>

		<tr>
			<td class="LABEL"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td class="LABEL" ><fmt:message key="Common.male.label" bundle="${common_labels}"/> <input type ='radio' checked name ='male' onClick = 'checkValue(this)'  value ='M'>&nbsp;&nbsp;<fmt:message key="Common.female.label" bundle="${common_labels}"/> <input type ='radio' name ='female' onClick = 'checkValue(this)' value ='F'>
		</tr>


		<tr>
		<td class="LABEL"><fmt:message key="Common.age.label" bundle="${common_labels}"/>&nbsp;</td>
		<td  class ='fields' ><input type='text' name ='age' size ='3' class="DATA" style="text-align: Right"  maxLength ='3'> years</td>
		</tr>
		
		<tr>
		<td class="LABEL" ><fmt:message key="Common.weight.label" bundle="${common_labels}"/>&nbsp;</td>
		<td   class ='fields' ><input type='text' name ='weight' size ='3' class="DATA" style="text-align: Right"  maxLength ='4'> Kgs</td>
		</tr>

		<tr>
		<td class="LABEL" ><fmt:message key="eCA.Serumcreatinine.label" bundle="${ca_labels}"/>&nbsp;</td>
		<td  class ='fields' ><input type='text' name ='sCR' size ='3' class="DATA" style="text-align: Right"  onKeyPress="return allowValidNumber(this,event,'3','2')" maxLength ='6'> &micro;mol/L	<!-- mg/dl--></td><!--[IN035424]-->
		</tr>


		<tr>
		<td colspan=2 align=center><input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Calculate.label","ca_labels")%>' onClick='javaScript:CalculateGlomerular()' class="BUTTON" ></td>
		</tr>

		<tr>
		<td colspan ='1' class="data"><fmt:message key="eCA.GlomerularFiltrationRate.label" bundle="${ca_labels}"/></td>
		<td  class ='fields' ><input type='text' name='GFR' id='GFR' size='5' class="DATA" style="text-align: Left">ml/min</td>
		</tr>
		<tr>
		<td colspan=2   class ='QUERYDATA'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eCA.ReferenceRange.label" bundle="${ca_labels}"/> :</td>
		</tr>
		
		<tr>
	<td  colspan=2   class ='LABEL'><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.male.label" bundle="${common_labels}"/> :</b>100-130 ml/min </td>
		</tr>
		
		<tr>
			<td colspan=2  class ='LABEL'><B>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.female.label" bundle="${common_labels}"/> : </B>85-105 ml/min </td>
		</tr>

</table>

</form>
</BODY>
</HTML>

