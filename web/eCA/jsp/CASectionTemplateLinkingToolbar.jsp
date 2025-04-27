<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function callOnOk()
	{
		parent.templateLinkingDetailFrame.document.compLinkingForm.calledFrom.value="OK";
		parent.templateLinkingDetailFrame.document.compLinkingForm.submit();
		//window.returnValue="OK";
		//parent.window.close();
	}
	function callOnBack()
	{
		parent.window.dialogHeight= "80vh";
		parent.window.dialogWidth= "50vw";		
		parent.window.dialogTop = "0vh";
		parent.window.dialogLeft = "0vw";
		var qs=document.forms[0].qs.value;
		parent.parent.templateLinkingCompSelectionFrame.location.href="CASectionTemplateLinkingCompSelScr.jsp?"+qs;
		//parent.parent.frameSetId.rows = "*,6%,0%";
		
		parent.parent.document.getElementById("templateLinkingCompSelectionFrame").style.height="84vh";
		parent.parent.document.getElementById("templateLinkingCompSelectionToolbarFrame").style.height="6vh";
		
	}
	</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
	<form name='CASectionTemplatePreviewForm' id='CASectionTemplatePreviewForm'>
		<table  width='100%' border='0' cellspacing='0' cellpadding='3' align='center' >
		<tr>
			<td width='25%'></td><td width='25%'></td><td width='25%'></td>
			<td width='25%'><input type="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Back.label","common_labels")%>" class="button" onClick="callOnBack()">&nbsp;<input type="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" class="button" onClick="callOnOk()">&nbsp;<input type="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" class="button" onClick="parent.window.close();"></td>
		</tr> </table>
		<input name=qs type=hidden value=<%=request.getQueryString()%>>
	</form>
</body>
</html>

