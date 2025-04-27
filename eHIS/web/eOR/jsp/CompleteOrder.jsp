<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String orderId = request.getParameter("orderId")==null?"":request.getParameter("orderId");
String task_type = request.getParameter("colval1")==null?"":request.getParameter("colval1");
String colval = request.getParameter("colval")==null?"":request.getParameter("colval");
String  sex =  request.getParameter("sex")==null?"":request.getParameter("sex");
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
String performing_facility = request.getParameter("performing_facility")==null?"":request.getParameter("performing_facility");
String encounterId = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
//System.out.println("encounterId="+encounterId);
String perform_from = request.getParameter("perform_from")==null?"": request.getParameter("perform_from");
String order_set_id = request.getParameter("order_set_id")==null?"": request.getParameter("order_set_id");

if (task_type.equals("Completion"))
{
	task_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Completion.label","or_labels");
}
//out.println(sex);
%>
<title><%=task_type%> - <%=colval%> <fmt:message key="Common.Order.label" bundle="${common_labels}"/></title>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<iframe name='CompleteOrderTop' id='CompleteOrderTop' src='ViewOrderTop.jsp?orderId=<%=orderId%>&patient_id=<%=patient_id%>&sex=<%=sex%>&function_from=Complete&perform_from=<%=perform_from%>&order_set_id=<%=order_set_id%>' frameborder=0  scrolling=no noresize style='height:40vh;width:98vw'></iframe>
	<iframe name='CompleteOrderDtl' id='CompleteOrderDtl' src='../../eCommon/html/blank.html' frameborder=0 scrolling=auto noresize style='height:50vh;width:98vw'></iframe>
	<iframe name='CompleteOrderBtn' id='CompleteOrderBtn' src='CompleteOrderBtn.jsp?orderId=<%=orderId%>&patient_id=<%=patient_id%>&patient_class=<%=patient_class%>&performing_facility=<%=performing_facility%>&encounterId=<%=encounterId%>&sex=<%=sex%>&colval=<%=colval%>&colval1=<%=task_type%>&order_set_id=<%=order_set_id%>' frameborder=0 scrolling=no noresize style='height:6vh;width:98vw'></iframe>


