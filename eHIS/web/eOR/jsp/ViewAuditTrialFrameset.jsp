<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper " contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<HTML>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>

<Head><title><fmt:message key="eOR.ViewAuditTrail.label" bundle="${or_labels}"/></title>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</Head>
<iframe name='AuditSearch' id='AuditSearch' src='ViewAuditTrial.jsp?<%=request.getQueryString()%>' frameborder=0  scrolling='auto' noresize style='height:90vh;width:100vw'></iframe>
	<iframe name='AuditBtn' id='AuditBtn' src='ViewAuditTrialBtn.jsp' frameborder=0 scrolling=no style='height:10vh;width:100vw'></iframe>
</HTML>

