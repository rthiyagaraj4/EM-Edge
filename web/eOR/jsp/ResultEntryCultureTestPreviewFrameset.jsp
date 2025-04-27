<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<HTML>
<Head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<TITLE><fmt:message key="Common.Preview.label" bundle="${common_labels}"/></TITLE>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</Head>
<iframe name='ResultEntryCultureTestPreview' id='ResultEntryCultureTestPreview' src='ResultEntryCultureTestPreview.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='yes' style='height:86vh;width:100vw'></iframe>
<iframe name='ResultEntryCultureTestPreviewBtn' id='ResultEntryCultureTestPreviewBtn' src='ResultEntryCultureTestPreviewBtn.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling=no style='height:5vh;width:100vw'></iframe>
</HTML>

