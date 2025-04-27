<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<title><fmt:message key="eCA.SectionTemplateToolbar.label" bundle="${ca_labels}"/></title>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown='lockKey()'>
<center>
	<form name='RecClinicalNotesTemplateToolbarForm' id='RecClinicalNotesTemplateToolbarForm'>
	<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
	<tr><td  class="label" width='25%'></td><td  class="label" width='25%'></td><td  class="label" width='25%'></td>
	<td  class="fields" width='25%'>
	<input type="button" class="BUTTON" name="close" id="close" value=" <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%> " onClick="parent.window.close();">
	</td></tr>
	</table>
</form>
</center>
</body>
</html>

