<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<title><fmt:message key="eCA.ChiefComplaints.label" bundle="${ca_labels}"/></title>

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
<iframe name="RecClinicalNotesCCCriteriaFrame" id="RecClinicalNotesCCCriteriaFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesChiefComplaintCriteria.jsp?<%=request.getQueryString()%>" style="height:20vh;width:100vw"></iframe>
	<iframe name="RecClinicalNotesCCFrame" id="RecClinicalNotesCCFrame" frameborder="no" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:68vh;width:100vw"></iframe>
	<iframe name="RecClinicalNotesCCSelectFrame" id="RecClinicalNotesCCSelectFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesChiefComplaintButtons.jsp" style="height:9vh;width:100vw"></iframe>
	<iframe name="RecClinicalNotesCCControlFrame" id="RecClinicalNotesCCControlFrame" frameborder="no" scrolling="yes"  src="../../eCommon/html/blank.html" style="height:0vh;width:100vw"></iframe>


</html>

