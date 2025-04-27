<!DOCTYPE html>
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
06/08/2014  IN049419		Ramesh G										An Audit Trail for Additional Information Amendment of Order	 
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String lineId_ = request.getParameter("lineId")==null?"":request.getParameter("lineId" ) ;

%>

<html>
  <head>
  	<% if("".equals(lineId_)){ %>
	<title><fmt:message key="eOR.OrderFormatAuditTrail.label" bundle="${or_labels}"/></title>
	<%}else if(!"".equals(lineId_)){ %>
	<title><fmt:message key="eOR.OrderFormatLineAuditTrail.label" bundle="${or_labels}"/></title>
	<%}%>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  </head>
	<iframe name="orderFormatAuditTrailList" id="orderFormatAuditTrailList" src="../../eOR/jsp/OrderEntryOrderFormatAutidTrailList.jsp?<%=request.getQueryString()%>" frameborder=1  marginheight=0 marginwidth=0  SCROLLING="yes" NORESIZE style="height:40vh;width:99vw"></iframe>
       		<iframe name="orderFormatAuditTrailDtls" id="orderFormatAuditTrailDtls" src="../../eCommon/html/blank.html" frameborder=0  marginheight=0 marginwidth=1 SCROLLING="yes"  NORESIZE style="height:50vh;width:99vw"></iframe>
      		<iframe name="orderFormatAuditTrail" id="orderFormatAuditTrail" src="../../eOR/jsp/OrderEntryOrderFormatAutidTrailBtn.jsp" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="auto"  NORESIZE style="height:5vh;width:99vw"></iframe>
	
</html>

