<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------
Date        Edit History    Name         Description
--------------------------------------------------------------------------------------------------------
?            100            ?            created
22/07/2013   IN036900		Akbar		 Bru-HIMS-CRF-330 - Creatitine Clearance Calculator
04/10/2013    IN043652      Vijayakumar K  Alpha-CA-System Allowing user to enter negative values at Age and Weight fields.
--------------------------------------------------------------------------------------------------------
*/
%>
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
	<form name ='CrCl'>
<table  width ='95%' height='80%' border=0 cellpadding=3 cellspacing=0 align=center RULES=NONE>
		<tr><th class='COLUMNHEADER'  colspan="3" align="left">&nbsp;<fmt:message key="eCA.CreatinineclearanceForAdult.label" bundle="${ca_labels}"/></th>
		</tr>
		<!--
		<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td class ='LABEL' align ='right' width='40%'>Urine Creatinine&nbsp;</td>
		<td class=label><input type='text' name ='uCreatinine' size ='4' class="DATA" style="text-align: Right" onKeyPress="return allowValidNumber(this,event,'4','0')" maxLength ='4'> mg/dl</td>
		</tr>
		<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td class ='LABEL' align ='right'>Serum Creatinine&nbsp;</td>
		<td  class=label><input type='text' name ='sCreatinine' size ='5'class="DATA" style="text-align: Right" onKeyPress="return allowValidNumber(this,event,'3','2')" maxLength ='6'> mg/dl</td>
		</tr>

		<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td class ='LABEL' align ='right'>Urine&nbsp;Volume(24hr)&nbsp;</td>
		<td  class=label><input type='text' name ='uVolume' size ='4'class="DATA" style="text-align: Right" onKeyPress="return allowValidNumber(this,event,'4','0')" maxLength ='4'> ml</td>
		</tr>

		<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td class ='LABEL' align ='right'>BSA&nbsp;</td>
		<td  class=label><input type='text' name ='bsa' size ='5'class="DATA" style="text-align: Right" onKeyPress="return allowValidNumber(this,event,'2','2')" maxLength ='5'> Sq.m</td>
		</tr> -->
		
		<tr>
		
		<td class ='LABEL'  width='40%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class=fields><input type="radio" name="order" id="order" value="1" checked class="DATA" style="text-align: Right" ><fmt:message key="eCA.Men.label" bundle="${ca_labels}"/> 
		<input type="radio" name="order" id="order" value="0.85" class="DATA" style="text-align: Right" ><fmt:message key="eCA.Women.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr>
		
		<td class ='LABEL'  width='40%'><fmt:message key="Common.age.label" bundle="${common_labels}"/>&nbsp;</td>
		<!-- IN043652 starts -->
		<!--<td class=fields><input type='text' name ='uCreatinine' size ='4' class="DATA" style="text-align: Right" onKeyPress="return allowValidNumber(this,event,'4','2')" maxLength ='4'> Years</td>-->
		<td class=fields><input type='text' name ='uCreatinine' size ='4' class="DATA" style="text-align: Right" onKeyPress="return allowValidNumberOnKeyPress(this,event,'4','2')"  maxLength ='4' onblur="allowValidNumberOnBlur(this)"> Years</td>
		<!-- IN043652 ends -->
		</tr>
		<tr>
		
		<td class ='LABEL' ><fmt:message key="Common.weight.label" bundle="${common_labels}"/>&nbsp;</td>
		<!-- IN043652 starts -->
		<!--<td  class=fields><input type='text' name ='sCreatinine' size ='5'class="DATA" style="text-align: Right" onKeyPress="return allowValidNumber(this,event,'4','2')" maxLength ='6'> Kg</td>-->
		<td  class=fields><input type='text' name ='sCreatinine' size ='5'class="DATA" style="text-align: Right" onKeyPress="return allowValidNumberOnKeyPress(this,event,'4','2')" maxLength ='6' onblur="allowValidNumberOnBlur(this)"> Kg</td>
		<!-- IN043652 ends -->
		</tr>
 
		<tr>
		
		<td class ='LABEL' ><fmt:message key="eCA.PlasmaCreatinine.label" bundle="${ca_labels}"/>&nbsp;</td>
		<!-- <td  class=fields><input type='text' name ='uVolume' size ='4'class="DATA" style="text-align: Right" onKeyPress="return allowValidNumber(this,event,'3','4')" maxLength ='6'> mmol/L&nbsp;</td>  -->  <!-- commented for IN036900 -->
		<td  class=fields><input type='text' name ='uVolume' size ='4'class="DATA" style="text-align: Right" onKeyPress="return allowValidNumber(this,event,'3','4')" maxLength ='6'> &micro;mol/L&nbsp;</td>  <!-- IN036900 -->
		</tr>

		
		<tr><td>
		<input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Calculate.label","ca_labels")%>' align=center onClick='javaScript:CalculateCreatinine()' class="BUTTON" ></td><td colspan=1></td>
		</tr>
		<tr>
		
		<td class="LABEL"><b><fmt:message key="eCA.Creatinineclearance.label" bundle="${ca_labels}"/>&nbsp;</b></td><td  class=fields><input type='text' name='crcl' id='crcl' size='5' class="DATA" style="text-align: Left">&nbsp;ml/min</td>
		</tr>

		<tr>
			
			<td colspan ='2' class="QUERYDATA">&nbsp;<fmt:message key="eCA.ReferenceRange.label" bundle="${ca_labels}"/> : </td>
		</tr>

		<tr>
			
			<td colspan ='2' id="men" class="LABEL"><b><fmt:message key="eCA.Men.label" bundle="${ca_labels}"/> :</b></td>
		</tr>
		<tr>
			
			<td colspan ='2' class="LABEL"><fmt:message key="Common.Average.label" bundle="${common_labels}"/> : 120 ml/min </td>
		</tr>
		<tr>
			
			<td colspan ='2' class="LABEL"><fmt:message key="Common.Range.label" bundle="${common_labels}"/> : 97-137 ml/min </td>
		</tr>

		<tr>
			
			<td colspan ='2' class="LABEL"><b><fmt:message key="eCA.Women.label" bundle="${ca_labels}"/> :</b></td>
		</tr>
		<tr>
			
 			<td colspan ='2' class="LABEL"><fmt:message key="Common.Average.label" bundle="${common_labels}"/> : 95 ml/min </td>
		</tr>
		<tr>
			
			<td colspan ='2' class="LABEL"><fmt:message key="Common.Range.label" bundle="${common_labels}"/> : 88-128 ml/min </td>
		</tr>


</table>

</form>
</BODY>
</HTML>

