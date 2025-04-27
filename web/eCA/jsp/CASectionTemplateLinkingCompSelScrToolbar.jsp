<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function callOnNext()
	{
		parent.templateLinkingCompSelectionFrame.document.compSelectionForm.submit();
		parent.document.getElementById("templateLinkingCompSelectionFrame").style.height="99vh";
		parent.document.getElementById("templateLinkingCompSelectionToolbarFrame").style.height="0vh";
		//parent.frameSetId.rows = "*,0%";
		//parent.window.close();
	}
	function callOnOk()
	{
		parent.templateLinkingCompSelectionFrame.document.compSelectionForm.target="dummyFrame";
		parent.templateLinkingCompSelectionFrame.document.compSelectionForm.action= "CASectionTemplateLinkingCompSelScrUpdateBean.jsp"
		parent.templateLinkingCompSelectionFrame.document.compSelectionForm.submit();
	}
	</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
	<form>
		<table  width='100%' border='0' cellspacing='0' cellpadding='3' >
		<tr> <td width='25%'></td><td width='25%'></td><td width='25%'></td>
			<td width='25%'  ><input type="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")%>" class="button" onClick="callOnNext()">&nbsp;<input type="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" class="button" onClick="callOnOk();">&nbsp;<input type="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" class="button" onClick="parent.window.close();"></td>
		</tr>
	</form>
</body>
</html>

