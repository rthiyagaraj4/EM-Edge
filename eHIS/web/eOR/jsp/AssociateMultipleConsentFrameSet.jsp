<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*,eOR.*,eOR.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<% 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079  
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
%>

<html>
  <head>
	<title>
		<fmt:message key="eOR.ConsentRequiredfor.label" bundle="${or_labels}"/>-<%=request.getParameter("order_catalog_desc")%>
	</title>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  </head>
	<iframe name="multi_title" id="multi_title" src="../../eOR/jsp/AssociateMultipleConsentTitle.jsp?<%=request.getQueryString()%>" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="no" name="multi_btn" NORESIZE style="height:12vh;width:100vw"></iframe>
			<iframe src="../../eCommon/html/blank.html" frameborder=0  marginheight=0 marginwidth=0 name="multi_detail" id="multi_detail" SCROLLING="auto" NORESIZE style="height:78vh;width:97vw"></iframe>
       		<iframe src="../../eCommon/html/blank.html" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="no" name="multi_btn" id="multi_btn" NORESIZE style="height:10vh;width:97vw"></iframe>
      		
	
</html>

