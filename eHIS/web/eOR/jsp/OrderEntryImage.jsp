<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<!--
<frameset cols="27%,*" framespacing="0" > 
	<frame name="displayImage" src="../../eCommon/html/blank.html" frameborder="none" border="none" scrolling="no" noresize style='border-style: groove ; border-color: red; border-width:2'> 
	<frame name="displayTransaction" src="../../eOR/jsp/OrderEntryImageFrameSet.jsp?<%=request.getQueryString()%>" frameborder="none" border="none" scrolling="no" noresize> 
</frameset>
-->
<div style="display: flex;">
    <!-- <div style="flex: 0 0 27%;height: 450px; border: 2px groove red;"> -->
	<div style="width: 400px;height: 494px; border: 2px groove red;">
        <!-- Content for the left panel goes here -->
        <iframe name="displayImage" src="../../eCommon/html/blank.html" frameborder="none" scrolling="no" style="width: 100%; height: 100%;"></iframe>
    </div>
     <div style="flex: 1;">
        <!-- Content for the right panel goes here -->
        <iframe name="displayTransaction" src="../../eOR/jsp/OrderEntryImageFrameSet.jsp?<%=request.getQueryString()%>" frameborder="none" scrolling="no" style="width: 100%; height: 100%;"></iframe>
    </div> 
</div>
