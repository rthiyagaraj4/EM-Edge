<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
08/10/2013     		1   		Sethuraman      Created 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<head>
<% 
	String queryString = request.getQueryString();	
	String patientId = request.getParameter("patient_id");	
	String encounterId = request.getParameter("encounter_id");
%>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<iframe name='EncSummPopupHeaderFrame' id='EncSummPopupHeaderFrame' src='../../eCA/jsp/EncSummPopUpHeader.jsp?patientId=<%=patientId%>&encounterId=<%=encounterId%>' frameborder=0  scrolling='no' style='height:25%;width:100vw'></iframe>
		<iframe name='EncSummPopupPrevEncFrame' id='EncSummPopupPrevEncFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:75%;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize style='height:100vh;width:100vw'></iframe>
		<iframe name='BlankFrame' id='BlankFrame' src='../../eCommon/html/blank.html' frameborder=0 style='height:0%;width:100vw'></iframe>		
	
</html>

