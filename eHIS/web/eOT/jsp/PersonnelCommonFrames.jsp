<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<% 
   String params = request.getQueryString(); 
%>
 
<iframe name="pers_tab" id="pers_tab" scrolling="no" noresize src="../../eOT/jsp/PersonnelTab.jsp?<%=params%>" style="height:8vh;width:100vw;border:0"></iframe>
<iframe name='ChildBaseFrame' id='ChildBaseFrame' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no' style='height:92vh;width:100vw;border:0'></iframe>



