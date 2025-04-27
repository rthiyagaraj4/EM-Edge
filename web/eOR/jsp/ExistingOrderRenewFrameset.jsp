<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<html>
<%--<Script>alert('<%=request.getQueryString()%>')</script>--%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String Patient_id = request.getParameter("patientId") ;
	if(Patient_id == null || Patient_id.equals("null")) Patient_id =""; else Patient_id = Patient_id.trim();
String order_id = request.getParameter("order_id");
if (order_id == null) order_id = "";
%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<title><fmt:message key="eOR.RenewOrders.label" bundle="${or_labels}"/></title>
<frameset rows='8%,*,12%'>
	<frame name='framePatientPendingOrdersHdr' id='framePatientPendingOrdersHdr'
	src="../../eOR/jsp/PatientPendingOrdersHdr.jsp"	frameborder=0  noresize scrolling='auto'>

	<Frame name='framePatientPendingOrdersResult' id='framePatientPendingOrdersResult' src="../../eOR/jsp/ExistingOrderRenewResults.jsp?Patient_id=<%=Patient_id%>&order_id=<%=order_id%>" FrameBorder='0' scrolling='auto' noresize>

	<Frame name='framePatientPendingOrdersClose' id='framePatientPendingOrdersClose' src="../../eOR/jsp/ExistingOrderRenewClose.jsp"
	FrameBorder='0' scrolling='no' noresize>

</frameset>
<html>

