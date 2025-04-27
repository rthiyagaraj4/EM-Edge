<!DOCTYPE html>

<%@  page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
</head>
<%  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends
	String params	= request.getQueryString();
	String tab_name = request.getParameter("tab_name") ;
	System.out.println("tab_name"+tab_name);
	if(tab_name==null) tab_name="MealType";
	if(tab_name!=null && tab_name.equals("null")) tab_name="MealType";
%>
<iframe name="complaintsFrame" id="complaintsFrame" frameborder="0" scrolling="no" noresize src="../../eDS/jsp/MealPrepareServeComplaintsMultiRecord.jsp?<%=params%>" style="height:15vh;width:100vw"></iframe>
<iframe name="meal_plan_details_frame" id="meal_plan_details_frame" frameborder="0" scrolling="yes" noresize src="../../eCommon/html/blank.html" style="height:85vh;width:100vw"></iframe>

