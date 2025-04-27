<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title<fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/></title>
<meta name="Generator" content="EditPlus">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>						
<script>
	function returnFormulaDef()
	{
		var firstComponent = parent.templateFormulaComponentListFrame.document.CASectionTemplateDateComponentForm.firstComponent.value;
		var secondComponent = parent.templateFormulaComponentListFrame.document.CASectionTemplateDateComponentForm.secondComponent.value;
		
		var operationAllowed = parent.templateFormulaComponentListFrame.document.CASectionTemplateDateComponentForm.operationAllowed.value;
		var formulaResultUnits = parent.templateFormulaComponentListFrame.document.CASectionTemplateDateComponentForm.formulaResultUnits.value;
		
		var retVal = "";
		//alert(formulaResultUnits);
		if(secondComponent == '***CONSTANT***')
		{
			retVal = ("$$$" + firstComponent  + "###" + "~" + (operationAllowed=='minus'?"-":"+") + "~" +	"$$$" +  parent.templateFormulaComponentListFrame.document.CASectionTemplateDateComponentForm.constantValue.value + "###~||" + formulaResultUnits);
		}
		else
			retVal = ("$$$" + firstComponent  + "###" + "~" + (operationAllowed=='minus'?"-":"+") + "~" + "$$$" + secondComponent + "###~||" + formulaResultUnits);
		
		window.returnValue = retVal;
		window.close();
	}
</script>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/SectionTemplate.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<table width="100%" >
	<tr>
		<td  colspan =4 align = right width = '100%'>
			<input type="button" name="OK" id="OK" onclick="returnFormulaDef()" class="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>'>
			<input type="button" name="cancel" id="cancel" onclick="window.close();" class="button" value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>'>
		</td>
	</tr>
</table>
</body>
</html>

