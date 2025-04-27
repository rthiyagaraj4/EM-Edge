<!DOCTYPE html>
<% 
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
24/10/2016  created			Raja S											MO-CRF-20108[IN058912] 
20/07/2018	IN067717		Ramesh G	20/07/2018		Ramesh G			ML-MMOH-CRF-0898.1
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<title>Clinical Notes</title>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String  function_id			=   request.getParameter("function_id")== null ? "" : request.getParameter("function_id");//IN067717

	
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!--IN067717 starts-->
<%if("BIRTH_REG_NOTES".equals(function_id)){%>
<iframe name="ViewMotherLinkedNotesSrchResultsFrame" id="ViewMotherLinkedNotesSrchResultsFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/ViewMotherLinkedNotesSrchResults.jsp?<%=request.getQueryString()%>" style="height:10%;width:100vw"></iframe>
	<iframe name="ViewMotherLinkedNotesSelsectedResultDtlFrame" id="ViewMotherLinkedNotesSelsectedResultDtlFrame" frameborder="no" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:100vh;width:100vw"></iframe>
	<iframe name="ViewMotherLinkedNotesToolbarFrame" id="ViewMotherLinkedNotesToolbarFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/ViewMotherLinkedNotesToolbar.jsp" style="height:8%;width:100vw"></iframe>

<%}else{%>
<!--IN067717 ends-->
<iframe name="ViewMotherLinkedNotesSrchCriteriaFrame" id="ViewMotherLinkedNotesSrchCriteriaFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/ViewMotherLinkedNotesSrchCriteria.jsp?<%=request.getQueryString()%>" style="height:8%;width:100vw"></iframe>
	<iframe name="ViewMotherLinkedNotesSrchResultsFrame" id="ViewMotherLinkedNotesSrchResultsFrame" frameborder="no" scrolling="yes" noresize src="../../eCommon/html/blank.html" style="height:36%;width:100vw"></iframe>
	<iframe name="ViewMotherLinkedNotesSelsectedResultDtlFrame" id="ViewMotherLinkedNotesSelsectedResultDtlFrame" frameborder="no" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:48%;width:100vw"></iframe>
	<iframe name="ViewMotherLinkedNotesToolbarFrame" id="ViewMotherLinkedNotesToolbarFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/ViewMotherLinkedNotesToolbar.jsp" style="height:8%;width:100vw"></iframe>

<%}%><!--IN067717-->
</html>

