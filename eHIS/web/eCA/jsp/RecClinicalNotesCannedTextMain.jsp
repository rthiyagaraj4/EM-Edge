<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<title><fmt:message key="eCA.CannedText.label" bundle="${ca_labels}"/></title>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name="RecClinicalNotesCTFrame" id="RecClinicalNotesCTFrame" frameborder="no" scrolling="auto" noresize src="../../eCA/jsp/RecClinicalNotesCannedText.jsp?<%=request.getQueryString()%>" style="height:91vh;width:100vw"></iframe>
	<iframe name="RecClinicalNotesCTSelectFrame" id="RecClinicalNotesCTSelectFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesCannedTextSelect.jsp" style="height:7vh;width:100vw"></iframe>


</html>

