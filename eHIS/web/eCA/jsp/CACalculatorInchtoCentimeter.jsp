<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<HTML>
<HEAD>
<%
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
	<form name ='CalInchtoCMSForm' >
<table  width ='100%' height='35%' border=0 cellpadding=0 cellspacing=0 align=center RULES=NONE>
		<tr><th colspan='4' align='left'>&nbsp;<fmt:message key="eCA.Centemeter.label" bundle="${ca_labels}"/><=> <fmt:message key="Common.Inch.label" bundle="${common_labels}"/> </th>
			
		<tr>
					<td align='left' width='20%'>&nbsp;<input type='text' size ='10'  maxLength ='10' name='CMSInput' id='CMSInput' onBlur='CheckNum(this);CaluculateInchCMS()' style="text-align: Right"></td>
						<td class='LABEL' align ='left' width='30%'><fmt:message key="Common.cm.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eCA.IsEqualTo.label" bundle="${ca_labels}"/></td>
								<td class=label id='inchOutput' width='15%' ></td>
									<td class='label' colspan='1'><fmt:message key="Common.Inch.label" bundle="${common_labels}"/></td>
		</tr>

		<tr>
					<td align='left' width='20%'>&nbsp;<input type='text' size ='10'  maxLength ='10' name='inchInput' id='inchInput' onBlur='CheckNum(this);CaluculateInchCMS()' style="text-align: Right"></td>
						<td class='LABEL' align ='left' width='30%'><fmt:message key="Common.Inch.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eCA.IsEqualTo.label" bundle="${ca_labels}"/></td>
							<td class=label id='CMSOutput' width='15%' ></td>
								<td class='label' colspan='1'><fmt:message key="Common.cm.label" bundle="${common_labels}"/></td>     
		</tr>

				<tr><th colspan='4' align='left'>&nbsp;<fmt:message key="eCA.Centemeter.label" bundle="${ca_labels}"/><sup>2</sup> <=> <fmt:message key="Common.Inch.label" bundle="${common_labels}"/><sup>2</sup></th></tr>
		<tr>
					<td align='left'  width='20%'>&nbsp;<input type='text' size ='10'  maxLength ='10' name='inchSqrInput' id='inchSqrInput' onBlur='CheckNum(this);CaluculateInchCMS()' style="text-align: Right"></td>
						<td class='LABEL' align ='left' width='30%'><fmt:message key="Common.Inch.label" bundle="${common_labels}"/><sup>2</sup>&nbsp;<fmt:message key="eCA.IsEqualTo.label" bundle="${ca_labels}"/> &nbsp;</td>
							<td class=label id='CMSSqrOutput' width='15%' ></td>
								<td class='label' colspan='1'><fmt:message key="Common.cm.label" bundle="${common_labels}"/><sup>2</sup></td>
		</tr>
				<tr>
					<td align='left'>&nbsp;<input type='text' size ='10'  maxLength ='10' name='CMSSqrInput' id='CMSSqrInput' onBlur='CheckNum(this);CaluculateInchCMS()' style="text-align: Right"></td>
						<td class='LABEL' align ='left' width='30%'><fmt:message key="Common.cm.label" bundle="${common_labels}"/><sup>2</sup>&nbsp;<fmt:message key="eCA.IsEqualTo.label" bundle="${ca_labels}"/> &nbsp;</td>
							<td class=label id='InchSqrOutput'width='	15%' >
								<td class='label' colspan='1'><fmt:message key="Common.Inch.label" bundle="${common_labels}"/><sup>2</sup></td>
				</tr>

				<tr>
						
						<td colspan=5 align=center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Calculate.label","ca_labels")%>' onClick='CaluculateInchCMSbutt()' class="BUTTON" ></td>

				</tr>
	

</table>
&nbsp;
	<table width ='100%' height='15%' border=0 cellpadding=0 cellspacing=0 align=center RULES=NONE>	
		<tr><th colspan=3 align=left>&nbsp;<fmt:message key="eCA.FormulaAdopted.label" bundle="${ca_labels}"/></th></tr>
		
		<tr>
			<td  align=left   class ='LABEL'><B><fmt:message key="eCA.Centemeter.label" bundle="${ca_labels}"/>  <=> <fmt:message key="Common.Inch.label" bundle="${common_labels}"/>&nbsp;</B>
			</td>
			<td  align=left   class ='LABEL'><B><fmt:message key="Common.Inch.label" bundle="${common_labels}"/>  <=>  <fmt:message key="eCA.Centemeter.label" bundle="${ca_labels}"/>&nbsp;</B>
			</td>
		</tr>
			
			<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class ='LABEL'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1 <fmt:message key="eCA.Centemeter.label" bundle="${ca_labels}"/>  = 0.39 <fmt:message key="Common.Inch.label" bundle="${common_labels}"/>
			</td>
			<!--<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>-->
			<td class ='LABEL'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1 <fmt:message key="Common.Inch.label" bundle="${common_labels}"/>  = 2.54 <fmt:message key="Common.cm.label" bundle="${common_labels}"/>
			</td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<!--<tr>
			<td colspan=2 align=left class ='LABEL'>
			</td>
			<td class ='LABEL'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1 <fmt:message key="eCA.Centemeter.label" bundle="${ca_labels}"/><sup>2</sup>  = 0.16 <fmt:message key="Common.Inch.label" bundle="${common_labels}"/><sup>2</sup>
			</td>
		</tr>-->
		<tr>
			<td  align=left   class ='LABEL'><B><fmt:message key="eCA.Centemeter.label" bundle="${ca_labels}"/><sup>2</sup> <=> <fmt:message key="Common.Inch.label" bundle="${common_labels}"/><sup>2</sup> &nbsp;</B>
			</td>
			<td  align=left   class ='LABEL'><B><fmt:message key="Common.Inch.label" bundle="${common_labels}"/><sup>2</sup> <=> <fmt:message key="eCA.Centemeter.label" bundle="${ca_labels}"/><sup>2</sup> &nbsp;</B>
			</td>
			
		<br><br>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class ='LABEL'> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1 <fmt:message key="eCA.Centemeter.label" bundle="${ca_labels}"/><sup>2</sup>  = 0.16 <fmt:message key="Common.Inch.label" bundle="${common_labels}"/><sup>2</sup>
			</td>
			<!--<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>-->

			<td class ='LABEL'> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1 <fmt:message key="Common.Inch.label" bundle="${common_labels}"/><sup>2</sup>   = 6.45 <fmt:message key="Common.cm.label" bundle="${common_labels}"/><sup>2</sup>
			</td>
		</tr>
	
</table>
</form>
</BODY>
</HTML>

