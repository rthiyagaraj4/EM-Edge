<!DOCTYPE html>
<% 
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
03/07/2015	IN052940		Ramesh G										In Clinical note there should be an option to auto fetch/Copy data from same template if filled up earlier for same patient in template format.
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<title>Recording Previous Notes Search</title>

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
<iframe name="RecPreviousNotesSrchCriteriaFrame" id="RecPreviousNotesSrchCriteriaFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/RecPreviousNotesSrchCriteria.jsp?<%=request.getQueryString()%>" style="height:8vh;width:100vw"></iframe>
	<iframe name="RecPreviousNotesSrchResultsFrame" id="RecPreviousNotesSrchResultsFrame" frameborder="no" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:36vh;width:100vw"></iframe>
	<iframe name="RecPreviousNotesSelsectedResultDtlFrame" id="RecPreviousNotesSelsectedResultDtlFrame" frameborder="no" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:48vh;width:100vw"></iframe>
	<iframe name="RecPreviousNotesToolbarFrame" id="RecPreviousNotesToolbarFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/RecPreviousNotesToolbar.jsp" style="height:8vh;width:100vw"></iframe>


</html>

