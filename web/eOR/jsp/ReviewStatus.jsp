<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
// no need to declare the variables as this file is being included in
// ExistingOrder.jsp where all these variable are initialised
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
 String orderId = request.getParameter("orderId");
 String task_type = request.getParameter("colval1");
 String colval = request.getParameter("colval");
 colval = java.net.URLDecoder.decode(colval,"UTF-8");
 String patient_id = request.getParameter("patient_id");
 String sex = request.getParameter( "sex" ) ;
//out.println("Sex"+sex);
%>
<%if(task_type.trim().equalsIgnoreCase("UpdateOrder")){%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<title><fmt:message key="eOR.ReviewOrderStatus.label" bundle="${or_labels}"/> - <%=colval%><fmt:message key="Common.Order.label" bundle="${common_labels}"/></title>
<%}else{%>
<title><fmt:message key="eOR.ReviewLineStatus.label" bundle="${or_labels}"/> - <%=colval%><fmt:message key="Common.Order.label" bundle="${common_labels}"/></title>
<%}%>
<iframe name='ReviewStatusTop' id='ReviewStatusTop' src='ReviewStatusTop.jsp?orderId=<%=orderId%>&task_type=<%=task_type%>' frameborder=0  scrolling=no noresize style='height:40vh;width:99vw'></iframe>
	<iframe name='ReviewStatusHeader' id='ReviewStatusHeader' src='ReviewStatusHeader.jsp?orderId=<%=orderId%>&task_type=<%=task_type%>&patient_id=<%=patient_id%>&sex=<%=sex%>' frameborder=0 scrolling=no noresize style='height:6vh;width:99vw'></iframe>
	<iframe name='ReviewStatusDtl' id='ReviewStatusDtl' src='ReviewStatusDetail.jsp?orderId=<%=orderId%>&task_type=<%=task_type%>&patient_id=<%=patient_id%>&sex=<%=sex%>' frameborder=0 scrolling=auto noresize style='height:48vh;width:99vw;margin-top:-22px'></iframe>
	<iframe name='ReviewStatusBtn' id='ReviewStatusBtn' src='ReviewStatusBtn.jsp?task_type=<%=task_type%>' frameborder=0 scrolling=no noresize style='height:6vh;width:99vw'></iframe>


