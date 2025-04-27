<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="Common.ClinicalNotes.label" bundle="${common_labels}"/></title>
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
<iframe name="EditorTitleFrame" id="EditorTitleFrame" frameborder="1" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesEditorTitle.jsp?<%=request.getQueryString()%>" style="height:7%;width:100vw"></iframe>
	<iframe name="RecClinicalNotesSecDetailsFrame" id="RecClinicalNotesSecDetailsFrame" frameborder="1" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:93%;width:100vw"></iframe>

</html>

