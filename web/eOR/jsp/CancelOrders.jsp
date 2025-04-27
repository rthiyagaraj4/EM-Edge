<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
14/10/2019  IN071315	    Nijitha S    14/10/2019  	Ramesh G		GHL-CRF-0607
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String orderId = request.getParameter("orderId");
String ord_typ_code = request.getParameter("ord_typ_code");
String patient_id = request.getParameter("patient_id");
String task_type = request.getParameter("colval1");
String colval = request.getParameter("colval");
String sex =  request.getParameter("sex");
String cont_order_ind = request.getParameter("cont_order_ind");
String p_called_from_ca = request.getParameter("p_called_from_ca");//IN071315
//out.println("<script>alert('in cancelOrder.jsp,ord_typ_code="+ord_typ_code+"');</script>");

task_type = task_type.substring(0,(task_type.length()-1));
//out.println(">"+task_type+"<");
%>
<%if (task_type.equals("Cancel") || task_type.equals("Cancels"))
task_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels");
%>
<title><%=task_type%> - <%=colval%><fmt:message key="Common.Order.label" bundle="${common_labels}"/></title>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<iframe name='CancelOrderTop' id='CancelOrderTop' src='ViewOrderTop.jsp?orderId=<%=orderId%>&ord_typ_code=<%=ord_typ_code%>&patient_id=<%=patient_id%>&cont_order_ind=<%=cont_order_ind%>&sex=<%=sex%>&function_from=Cancel&p_called_from_ca=<%=p_called_from_ca%>' frameborder=0  scrolling=no noresize style='height:27vh;width:99vw'></iframe><!-- //IN071315 -->
	<iframe name='CancelOrderDtl' id='CancelOrderDtl' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:63vh;width:99vw'></iframe>
	<iframe name='CancelOrderBtn' id='CancelOrderBtn' src='CancelOrderBtn.jsp' frameborder=0 scrolling=no noresize style='height:5vh;width:99vw'></iframe>


