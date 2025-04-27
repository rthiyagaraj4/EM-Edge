<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%	
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
  	String ammend_called_from = request.getParameter("ammend_called_from");
	if(ammend_called_from==null) ammend_called_from = "Ordering";		
	else ammend_called_from = "Amend";	
%>
<head><title><fmt:message key="eOR.SearchFor.label" bundle="${or_labels}"/> <%=ammend_called_from%> <fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
	<!-- <frameset rows="29%,*%" framespacing="0">-->
		<iframe name="practHdrFrame" id="practHdrFrame" src= "../../eOR/jsp/OrderEntrySearchPractioner.jsp?<%=request.getQueryString()%>" framespacing="0" noresize frameborder="0"  scrolling="no" style='height:29vh;width:100vw'></iframe>
		<iframe name="practDtlFrame" id="practDtlFrame" src= "../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="no" style='height:71vh;width:100vw'></iframe>
	<!-- </frameset>-->
</html>

