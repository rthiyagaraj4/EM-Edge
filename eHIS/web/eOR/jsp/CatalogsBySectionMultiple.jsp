<!DOCTYPE html>
<% /*
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
*/ %>
<html>
<head>
	
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!--<script language="JavaScript" src="../../eOR/js/ORGeneral.js"></script>-->
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

<%@ page session="false" import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
</head>
<%
	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	//String source = url + params ;
	//String order_category= request.getParameter("order_category");
	//String tick_sheet_id= request.getParameter("tick_sheet_id");
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode= request.getParameter("mode");
	//String eff_status= request.getParameter("eff_status");
	String function_id= request.getParameter("function_id");
%>
<frameset rows='35%,*%'>
	
	<frame name='f_query_add_mod_header' src='../../eOR/jsp/CatalogsBySectionHeader.jsp?mode=<%=mode%>&function_id=<%=function_id%>'  scrolling=no  frameborder="0">
	<frame name='f_query_add_mod_detail' src='../../eCommon/html/blank.html' scrolling=auto noresize frameborder="0" >

