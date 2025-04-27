<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>

<html>
<head>
	
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!--<script language="JavaScript" src="../../eOR/js/ORGeneral.js"></script>-->
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

<%@ page session="false" %>
</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	//String source = url + params ;
	//String order_category= request.getParameter("order_category");
	//String location_type=request.getParameter("location_type");
	//String tick_sheet_id= request.getParameter("tick_sheet_id");
	//String location_code = request.getParameter("location_code");
	String mode= request.getParameter("mode");
	//String eff_status= request.getParameter("eff_status");
	String function_id= request.getParameter("function_id");
%>
<iframe name='f_query_add_mod_header' id='f_query_add_mod_header' src='../../eOR/jsp/OrderablePerformingLocationHeader.jsp?mode=<%=mode%>&function_id=<%=function_id%>'  scrolling=no  frameborder="0" style='height:22vh;width:99vw'></iframe>
<iframe name='f_query_add_mod_detail' id='f_query_add_mod_detail' src='../../eCommon/html/blank.html' scrolling=no frameborder="0" style='height:67vh;width:99vw'></iframe>

