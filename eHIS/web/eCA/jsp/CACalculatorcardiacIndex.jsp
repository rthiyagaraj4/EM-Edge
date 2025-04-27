<!DOCTYPE html>
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
<script src='../../eCA/js/CACalculator.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	
	/*function check(cardiac){
	
		var cardiacOutput = document.forms[0].cardOutput.value;
		var BSA = document.forms[0].BSA.value;
		var weight=document.forms[0].weight.value;
		var height=document.forms[0].height.value;
		if(cardiacOutput!=null || BSA!=null || height!=null || weight!=null){
		if (isNaN(cardiacOutput) || isNaN(BSA)==true || isNaN(height) || isNaN(weight)) {
			alert("Please enter a number");
			cardiac.select();
			return false;
		}
		}
	}	*/	
			
		
	
	


</script>

</HEAD>

<BODY class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name ='MeanBP' >
<table  width ='95%' height='50%' border=0 cellpadding=3 cellspacing=0 align=center RULES=NONE>
		<tr><td class='COLUMNHEADER'  >&nbsp;<fmt:message key="eCA.CardiacIndex.label" bundle="${ca_labels}"/></td><td class='COLUMNHEADERCENTER'></td>
		<tr>
		<td class='LABEL' width=40%><fmt:message key="eCA.CardiacOutput.label" bundle="${ca_labels}"/>&nbsp;</td>
		<td class=fields><input type='text' name ='cardOutput' size ='5' class="DATA" style="text-align: Right" maxLength ='5' onBlur='CheckNum(this)'> liters/min</td>
		</tr>

		<tr>
		<td class='LABEL' ><fmt:message key="Common.weight.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class=fields><input type='text' name ='weight' size ='3' class="DATA" style="text-align: Right" maxLength ='4' onBlur='CheckNum(this);calculateBSA()'>&nbsp;Kgs
		</tr>

		<tr>
		<td class='LABEL' ><fmt:message key="Common.height.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class=fields><input type='text' name ='height' size ='3' class="DATA" style="text-align: Right" maxLength ='4' onBlur ='CheckNum(this);calculateBSA()'>&nbsp;Cms
		</tr>

		<tr>
		<td class='LABEL' ><fmt:message key="Common.BSA.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class=fields><input type='text' name ='BSA' size ='6' class="DATA" style="text-align: Right" maxLength ='6'  >&nbsp;M&quot;2&nbsp;&nbsp;
		</tr>
		<tr><td colspan=3 ></td></tr>

		<tr>
		<td colspan=3 align=center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Calculate.label","ca_labels")%>' onClick='javaScript:Calculate()' class="BUTTON" ></td>
		</tr>
				<tr><td colspan=3 ></td></tr>

		<tr>
		<td class="LABEL" ><b><fmt:message key="eCA.CardiacIndex.label" bundle="${ca_labels}"/></b>&nbsp;</td><td class=fields><input type='text' name='cIndex' id='cIndex' size='5' class="DATA" style="text-align: Left" maxLength ='5'>&nbsp;L/min/M2</td>
		</tr>

		<tr><td colspan=3 ></td></tr>
		<tr>
			<td colspan ='2' class="QUERYDATA">&nbsp;<fmt:message key="eCA.NormalRange.label" bundle="${ca_labels}"/> : </td>
		</tr>

		<tr>
			<td colspan ='2'   class="LABEL"><fmt:message key="eCA.Normal25to36LminM2.label" bundle="${ca_labels}"/></b></td>
		</tr>

</table>

</form>
</BODY>
</HTML>

