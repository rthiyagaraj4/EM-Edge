<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<title><fmt:message key="eCA.SectionTemplateToolbar.label" bundle="${ca_labels}"/></title>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<style>
textarea {
  resize: none;
}
</style>
<body onKeyDown="lockKey()">
<center>
	<form name='RecClinicalNotesTemplateToolbarForm' id='RecClinicalNotesTemplateToolbarForm'>
	<table border='0' cellpadding='3' cellspacing='0' width='100%'>
	<tr>
	<td width='100%' colspan ='4' align ='right'>

	<input type="button" class="BUTTON" name="close" id="close" value=" <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%> " onClick="const dialogTag = parent.parent.document.getElementById('dialog_tag').close();">
	</td></tr>
	</table>
</form>
</center>
</body>
</html>

