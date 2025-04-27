<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String queryString=request.getQueryString();

%>
<title><fmt:message key="Common.Consent.label" bundle="${common_labels}"/></title>
</head>
	<iframe name='ExistingOrderMultipleConsentSearchFrame' id='ExistingOrderMultipleConsentSearchFrame' src="ExistingOrderMultipleConsentSearch.jsp?<%=queryString%>" noresize  frameborder=no marginheight=0 marginwidth=0 scrolling=no style='height:21vh;width:100vw'></iframe>
	<iframe name='prevnextframe' id='prevnextframe' src="../../eCommon/html/blank.html" noresize  scrolling=no  frameborder=no  marginheight=0 marginwidth=0 style='height:79vh;width:100vw'></iframe>
</html>

