<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<html>
<head>
<title><fmt:message key="eCA.CannedTextDescription.label" bundle="${ca_labels}"/></title>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<iframe name="cannedTextFrame1" id="cannedTextFrame1" frameborder="no" scrolling="auto" noresize src="../../eCA/jsp/RecClinicalNotesCannedTextViewDesc.jsp?<%=request.getQueryString()%>" style="height:90vh;width:100vw"></iframe>
	<iframe name="cannedTextFrame2" id="cannedTextFrame2" frameborder="no" scrolling="no" noresize src="../../eCA/html/RecClinicalNotesCannedTextViewDescCloseBt.html" style="height:10vh;width:100vw"></iframe>


</html>

