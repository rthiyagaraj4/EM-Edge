<!DOCTYPE html>
<%
/*  							 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
02/06/2014	  IN037701		Nijitha												SKR-CRF-0036- new file created.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String p_called_from = request.getParameter("p_called_from") == null? "":request.getParameter("p_called_from");//SPC
%>
	
	<iframe name="encounterSpecificTAB" id="encounterSpecificTAB" src='../../eCA/jsp/SinglePageConsultationEncounterTab.jsp?<%=request.getQueryString()%>' frameborder='0' scrolling='no' noresize style='height:65px;width:100vw'></iframe>
		<iframe name="singlepageconsultationworkflow" id="singlepageconsultationworkflow" src="" frameborder='0' scrolling='no' noresize style='height:85%;width:100vw'></iframe>
		<iframe name="singlepageconsultationActionButton" id="singlepageconsultationActionButton" src='../../eCA/jsp/SinglePageConsultationActionButton.jsp' frameborder='0' noresize style='height:*%;width:100vw'></iframe>
	
	
	
</html>

