
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------------------------------------
	?			?				?			?				?					?
06/08/2014  IN049419		Ramesh G										An Audit Trail for Additional Information Amendment of Order	 
20/08/2014	IN056822		Ramesh G		?				?				Button OK / CANCEL are not available in Order Entry Format Item.
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>


<html>
  <head>
	<title><fmt:message key="eOR.OrderFormat.label" bundle="${or_labels}"/></title>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  </head>
		<!--<frameset frameborder=0 framespacing=0 rows='*,5%,10%'>-->
	    		<!-- IN056822 Start. -->
				<!--<frame src="../../eOR/jsp/OrderEntryOrderFormat.jsp?<//%=request.getQueryString()%>" frameborder=0  marginheight=0 marginwidth=0 name="OrderFormat" NORESIZE></frame>-->
	       		<!-- IN056822 End. -->
				<!-- IN049419 Start. -->
				
	       		<!--<frame src="../../eOR/jsp/OrderEntryFormatButtons.jsp" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="no" name="flex_fields_button" id="flex_fields_button" NORESIZE></frame>-->
	       	      		<!-- IN049419 End. -->
	      <!--</frameset>-->
     
       		<iframe src="../../eCA/jsp/blank.jsp" frameborder=0  marginheight=0 marginwidth=0 name="OrderFormat" id="OrderFormat" NORESIZE style='height:80vh;width:100vw'></iframe>
       		<iframe src="../../eOR/jsp/OrderEntryFormatButtons.jsp?<%=request.getQueryString()%>&orderFormatHL=H" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="no" name="flex_fields_button" NORESIZE style='height:8vh;width:100vw'></iframe>
      		<iframe src="../../eCommon/jsp/error.jsp" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="auto" name="message_frame" id="message_frame" NORESIZE style='height:10vh;width:100vw'></iframe>
</html>

