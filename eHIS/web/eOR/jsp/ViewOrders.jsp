<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%/*
---------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------------------------------------
15/01/2018  IN065844 		Sharanraj					Ramesh				ML-MMOH-CRF-1000	 
18/07/2018   IN061961		sivabagyam M    18/07/2018		Ramesh G		GHL-CRF-0433
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<%
String task_type = request.getParameter("colval1");
String task_type1 = request.getParameter("colval1");
String colval =request.getParameter("colval");
String accssion_num = request.getParameter("accssion_num")==null?"":request.getParameter("accssion_num");
String orderId = request.getParameter("orderId")==null?"":request.getParameter("orderId" ) ; //IN065844
String order_line_num=request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num" ) ;//IN061961
String catalog_code = (request.getParameter("catalog_code")==null||request.getParameter("catalog_code").equals("null"))?"":request.getParameter("catalog_code");//	IN061961
String view_by = (request.getParameter("view_by")==null||request.getParameter("view_by").equals("null"))?"":request.getParameter("view_by");//	IN061961
String ord_cat_code = request.getParameter("val1")==null?"":request.getParameter("val1");//IN061961

%>
<%
if (task_type.equals("View"))
	task_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels");
else if(task_type.equals("ViewReplacedOrder"))
	task_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ViewReplacedOrder.label","or_labels");
else if(task_type.equals("ViewOriginalOrder"))
	task_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ViewOriginalOrder.label","or_labels");


%>

<title><%=task_type%> - <%=colval%> <fmt:message key="Common.Order.label" bundle="${common_labels}"/></title>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

<!--<frameset rows='45%,55%,10%'>-->
	 <iframe name='ViewOrderTop' id='ViewOrderTop' src='ViewOrderTop.jsp?<%=request.getQueryString()%>&function_from=View' frameborder='0' scrolling='no' noresize style='height:40vh;width:100vw'></iframe>
	 <iframe name='ViewOrderDtl' id='ViewOrderDtl' src='../../eCommon/html/blank.html' frameborder='0' scrolling='no' noresize style='height:50vh;width:100vw'></iframe>
<!-- <frame name='ViewOrderBtn' id='ViewOrderBtn' src='ViewOrderBtn.jsp?orderId=<%=orderId%>&colval=<%=task_type1%>&accssion_num=<%=accssion_num%>' frameborder=0 scrolling=no noresize>--> <!-- IN065844 -->
	 <iframe name='ViewOrderBtn' id='ViewOrderBtn' src='ViewOrderBtn.jsp?orderId=<%=orderId%>&colval=<%=task_type1%>&accssion_num=<%=accssion_num%>&order_line_num=<%=order_line_num%>&catalog_code=<%=catalog_code%>&view_by=<%=view_by%>&ord_cat_code=<%=ord_cat_code%>' frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw'></iframe> <!-- IN061961 -->
<!--</frameset>-->

