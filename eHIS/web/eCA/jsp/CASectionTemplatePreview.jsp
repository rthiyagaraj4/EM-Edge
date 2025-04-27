<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
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
<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../js/SectionTemplate.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
function getClose()
{
	parent.parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	parent.location.href='../../eCommon/html/blank.html';
}

</script>
<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='CASectionTemplatePreviewForm' id='CASectionTemplatePreviewForm'>
<table  width='100%' border='0' cellspacing='0' cellpadding='3'  align ='center'>
<tr>
<td width='25%'></td><td width='25%'></td><td width='25%'></td>
<td width='25%' ><input type="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PreviewTemplate.label","ca_labels")%>" class="button" onClick="showSectionTemplate()">&nbsp;<!-- <input type="button" value="Close" class="button" onClick="getClose()"> --></td>
</tr>
</form>
</body>
</html>

