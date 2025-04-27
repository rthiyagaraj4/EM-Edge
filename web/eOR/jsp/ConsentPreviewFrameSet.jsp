<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 <%
 request.setCharacterEncoding("UTF-8");
 request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
 response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
 response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
 %>
  <title><%=(request.getParameter("order_id")==null)?com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.EditorPreview.label","or_labels"):(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.RecordedConsent.label","or_labels")+request.getParameter("consent_form_label"))%></title>
 <iframe name="preview" id="preview"   src="../../eOR/jsp/ConsentPreview.jsp?<%=request.getQueryString()%>" frameborder="none" border="none" scrolling="auto" noresize style="height:92vh;width:99vw"></iframe> 
	<iframe name="preview_button" id="preview_button"   src="../../eOR/jsp/ConsentPreviewButton.jsp?<%=request.getQueryString()%>" frameborder="none" border="none" scrolling="no" noresize style="height:6vh;width:99vw"></iframe> 


