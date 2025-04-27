<!DOCTYPE html>
<!--
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
18/11/2011    IN29413    Dinesh T     ARTEMIS - Added the new method
29/12/2011    IN30250    Dinesh T     ARTEMIS - Changed for the ipconsultation function in patient chart										  also
21/08/2011    IN034688    Dinesh T     Handling the billing related issue, while trying to charge consultation for more patients, charges were not posting to the billing tables										  
-----------------------------------------------------------------------------------------------
-->
<%@page import="java.sql.*,java.util.*,eCA.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
	<script language='javascript' src='../../eCA/js/IPConsultationList.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<!-- Modified by Arvind @28-11-2008 -->
		<iframe src="../../eCA/jsp/IPConsultationListTop.jsp?<%=request.getQueryString()%>" name='IPConsultationListTopFrame' id='IPConsultationListTopFrame' scrolling = "no" noresize frameborder='0' style='height:12vh;width:100vw'></iframe>
		<iframe src="../../eCommon/html/blank.html" name='IPConsultationListTabsFrame' id='IPConsultationListTabsFrame' scrolling = "no" noresize frameborder='0' style='height:4vh;width:100vw'></iframe>
		<iframe src="../../eCommon/html/blank.html" name='IPConsultationListCriteriaFrame' id='IPConsultationListCriteriaFrame' scrolling = "no" noresize  frameborder='0' style='height:21vh;width:100vw'></iframe>
		<iframe src="../../eCommon/html/blank.html" name='IPConsultationListResultFrame' id='IPConsultationListResultFrame' scrolling = "no" noresize  frameborder='0' style='height:52vh;width:100vw'></iframe>
		<iframe name='IPConsultationListToolbarFrame' id='IPConsultationListToolbarFrame' src="../../eCA/jsp/IPConsultationListToolbar.jsp?<%=request.getQueryString()%>" name='IPConsultationListToolbarFrame' scrolling = "no" noresize  frameborder='0' style='height:7vh;width:100vw'></iframe><!--IN034688-->
</html>

