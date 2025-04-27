<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
 <HTML>

<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
25/03/2019	  	IN067953	        Devindra  											MMS-KH-CRF-0014 [IN:067953] 
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		
	String url = "../../ePH/jsp/WardAcknowledgementAddModify.jsp" ;
	String params = request.getQueryString() ;
	String source = url +"?"+ params ;


%>
		<iframe name="wardacknowledgequeryframe" id="wardacknowledgequeryframe" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="<%=source%>" style="height:30vh;width:100vw"></iframe>
		<iframe name="wardacknowledgeactionframe" id="wardacknowledgeactionframe" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html" style="height:50vh;width:100vw"></iframe>
		<iframe name="wardretmedicationbuttonframe" id="wardretmedicationbuttonframe" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCommon/html/blank.html" style="height:12vh;width:100vw"></iframe>

</HTML>

