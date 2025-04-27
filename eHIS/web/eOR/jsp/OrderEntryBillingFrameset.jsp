<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%


request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//String orderId = request.getParameter("orderId");
//String lineId = request.getParameter("lineId");
//String patient_id = request.getParameter("patient_id");
//String sex = request.getParameter("sex");
//String image_ref = request.getParameter("image_ref");
//String encounter_id = request.getParameter("encounter_id");
//String patient_class = request.getParameter("patient_class");
//System.out.println("=========="+orderId+lineId+patient_id+sex+encounter_id+patient_class);

//out.println("<script>alert("+orderId+lineId+called_from+");</script>");
String called_from=request.getParameter("called_from");
called_from = (called_from == null) ? "" : called_from;
%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<title><fmt:message key="eOR.ChargeDtls.label" bundle="${or_labels}"/></title>
<%
    String height1, height2, height3, height4;
    if(!called_from.equals("register_visit")) {
        height1 = "27vh";  
        height2 = "5vh";   
        height3 = "59vh"; 
        height4 = "5vh";   
    } else {
        height1 = "16vh";  
        height2 = "76vh";  
        height3 = "8vh";   
        height4 = "0vh";   
    }
%>
	<% if(!called_from.equals("register_visit")) { %> 
			<iframe name="ViewOrderTop" src="ViewOrderTop.jsp?<%=request.getQueryString()%>&function_from=view" frameborder="0" scrolling="auto" noresize style="height:<%=height1%>;width:98vw"></iframe> 
<% } %> 
			<iframe name="OrderBillChargeHeader" id="OrderBillChargeHeader" src="OrderEntryBillingChargeHeader.jsp?<%=request.getQueryString()%>" frameborder="0" scrolling="no" noresize style="height:<%=height2%>;width:98vw"></iframe>
			<iframe name="OrderBillChargeDetail" id="OrderBillChargeDetail" src="OrderEntryBillingChargeDtls.jsp?<%=request.getQueryString()%>" frameborder="0" scrolling="auto" noresize style="height:<%=height3%>;width:98vw"></iframe> 
			<iframe name="OrderBillChargBtn" id="OrderBillChargBtn" src="OrderEntryBillingChargeBtn.jsp?<%=request.getQueryString()%>" frameborder="0" scrolling="auto" noresize style="height:<%=height4%>;width:98vw"></iframe>
