<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<% 
	  request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
      String query_string			= "bean_id="+request.getParameter("bean_id")+"&bean_name="+request.getParameter("bean_name")+"&mode="+request.getParameter("mode")+"&function_id="+request.getParameter("function_id")+"&consent_type="+request.getParameter("consent_type")+"&consent_form_id="+request.getParameter("consent_form_id")+"&consent_form_label="+request.getParameter("consent_form_label")+"&consent_format="+request.getParameter("consent_format")+"&effective_status="+request.getParameter("effective_status")+"&indexed="+request.getParameter("indexed"); 
%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<iframe name="f_query_add_mod" id="f_query_add_mod" src="../../eOR/jsp/ConsentFormatEditorMainFrameSet.jsp?<%=query_string%>" frameborder="none" border="none" scrolling="auto" noresize style="height:100vh;width:100vw"></iframe> 


