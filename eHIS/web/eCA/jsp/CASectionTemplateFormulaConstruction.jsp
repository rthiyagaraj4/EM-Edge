<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCA/js/SectionTemplate.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String temp = request.getParameter("temp");
	if(temp == null) temp ="";  
%>
<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name=templateFormulaConstructionForm method=post action="../../eCA/jsp/CASectionTemplateFormulaExprValidation.jsp" target=messageFrame>
<table width='98%' cellpadding='3' id=formtable style="border: 1.5px solid blue; border-collapse: collapse;">
<tr style="border: 1.5px solid blue; border-collapse: collapse;" width='100%'>
	<td style="border: 1.5px solid blue; border-collapse: collapse;" width='35%' >
		<b><fmt:message key="eCA.Constants.label" bundle="${ca_labels}"/></b><br>
		<input type=button class=button value='  1  ' name=one	 onClick="onOperation('1');">&nbsp;&nbsp;
		<input type=button class=button value='  2  ' name=two   onClick="onOperation('2');">&nbsp;&nbsp;
		<input type=button class=button value='  3  ' name=three onClick="onOperation('3');"><br><br>
		<input type=button class=button value='  4  ' name=four  onClick="onOperation('4');">&nbsp;&nbsp;
		<input type=button class=button value='  5  ' name=five  onClick="onOperation('5');">&nbsp;&nbsp;
		<input type=button class=button value='  6  ' name=six   onClick="onOperation('6');"><br><br>
		<input type=button class=button value='  7  ' name=seven onClick="onOperation('7');">&nbsp;&nbsp;
		<input type=button class=button value='  8  ' name=eight onClick="onOperation('8');">&nbsp;&nbsp;
		<input type=button class=button value='  9  ' name=nine  onClick="onOperation('9');"><br><br>
		<input type=button class=button value='  .  ' name=dot   onClick="onOperation('.');checkDecimal(document.getElementById("intVal"));">&nbsp;&nbsp;
		<input type=button class=button value='  0  ' name=zero  onClick="onOperation('0');"><br></br>
		<input type=text  size=10 value='' id=intVal name=finVal maxlength=38 onKeyPress='return allowValidNumber(this,event,38,38);'>&nbsp;&nbsp;
		<input type=button class=button value='Insert' name=insVal size=10 onClick="newTextInt(document.forms[0].finVal);clearVal();">
	</td>	
	
	<td style="border: 1.5px solid blue; border-collapse: collapse;" width='25%' > 
		<b><fmt:message key="eCA.Operators.label" bundle="${ca_labels}"/></b><br><br><br>
		<input type=button class=button value='   +   ' name='+' id='+' onClick="newTextOpe(this);">&nbsp;&nbsp;
		<input type=button class=button value='   -   ' name='-' id='-' onClick="newTextOpe(this);"><br><br>
		<input type=button class=button value='   *   ' name='*' id='*' onClick="newTextOpe(this);">&nbsp;&nbsp;
		<input type=button class=button value='   /   ' name='/' id='/' onClick="newTextOpe(this);"><br><br>
		<input type=button class=button value='   (   ' name='(' id='(' onClick="newTextOpe(this);">&nbsp;&nbsp;
		<input type=button class=button value='   )   ' name=')' id=')' onClick="newTextOpe(this);"><br><br>
	</td>
	<td style="border: 1.5px solid blue; border-collapse: collapse;" class='label' width='40%' height='100%' >  
		<b><fmt:message key="eCA.PlacingOption.label" bundle="${ca_labels}"/></b> <br><br><br>
		<input type=radio class=radio value='R' name=replace id=replaceOpt disabled> <a onclick="radioCheck(document.getElementById("replaceOpt"));"> <fmt:message key="Common.Replace.label" bundle="${common_labels}"/> </a> &nbsp;&nbsp;
		<input type=radio class=radio value='IL' name=replace id=replaceLefOpt disabled> <a onclick="radioCheck(document.getElementById("replaceLefOpt"));"> <fmt:message key="eCA.InsertLeft.label" bundle="${ca_labels}"/> </a>&nbsp;&nbsp;
		<input type=radio class=radio value='IR' name=replace id=replaceRigOpt disabled> <a onclick="radioCheck(document.getElementById("replaceRigOpt"));"> <fmt:message key="eCA.InsertRight.label" bundle="${ca_labels}"/> </a>&nbsp;&nbsp;
		<br><br>
		<hr color=black height=1>
		<br><br>
		<input type=button class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Remove.label","common_labels")%>' id=remov name=remove onClick="removeValue();"  disabled>
		<input type=button class=button align=right id=rese value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%>' name=resetBtn onClick="onReset();" disabled>
	</td>
</tr>
<tr id=t  width='100%'> 
	<td colspan=3 > <div id=f></div> </td> 
</tr>
<tr  width='100%' >
<td colspan=3>
	<input type="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Validate.label","ca_labels")%>' class="button"  name='validate' onclick='callOnValidate()' id='validat' disabled>
	<input type="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>'  class="button"  name='ok' onclick='callOnOk()' id='ok1'>
	<input type="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>'  class="button"  name='close' onclick='callClose()' id='clos'>
</td>
</tr>
</table>
	<input type=hidden name=defContent value="">
	<input type=hidden name=calledFrom value="">
	<input type=hidden name="formulaDefinition" id="formulaDefinition" value=""  > 
</form>
</body>
</html>
<script>displayValues();</script>

