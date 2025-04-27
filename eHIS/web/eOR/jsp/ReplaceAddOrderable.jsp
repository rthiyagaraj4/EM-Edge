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
String orderId = request.getParameter("orderId");
String task_type = request.getParameter("colval1");
String colval = request.getParameter("colval");
String  sex =  request.getParameter("sex");
String patient_id = request.getParameter("patient_id");
//out.println(sex);
//out.println("<script>alert('in ReplaceAddOrderable.jsp,orderId="+orderId+"');</script>");
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%if(task_type.trim().equalsIgnoreCase("Replace"))
task_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Replace.label","common_labels");
%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<title><%=task_type%> - <%=colval%> <fmt:message key="Common.Order.label" bundle="${common_labels}"/></title>
 
	<iframe name='ReplaceAddOrderTop' id='ReplaceAddOrderTop' src='ViewOrderTop.jsp?<%=request.getQueryString()%>&function_from=Replace' frameborder=0  scrolling=auto noresize style='height:40vh;width:100vw'></iframe>
 	<iframe name='CompleteOrderDtl' id='CompleteOrderDtl' src='../../eCommon/html/blank.html' frameborder=0 scrolling=auto style='height:50vh;width:100vw'></iframe>
	<iframe name='ReplaceAddOrderBtn' id='ReplaceAddOrderBtn' src='ReplaceAddOrderBtn.jsp' frameborder=0 scrolling=no noresize style='height:6vh;width:98vw'></iframe>


