<!DOCTYPE html>
<html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String params = request.getQueryString() ; 
	
%>
<head>
<title><fmt:message key="ePH.PreviousOrders.label" bundle="${ph_labels}"/></title>
   <!--  <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->

	<script language="JavaScript" src="../js/Prescription_1.js"></script>
	<script language="JavaScript" src="../js/PrescriptionTest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
   	<iframe name="f_prev_orders_disc_results" id="f_prev_orders_disc_results" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/PrescriptionPrevOrdersDischargeMed.jsp?<%=params%>" style="height:60vh;width:100vw"></iframe><iframe name="f_prev_orders_disc_buttons" id="f_prev_orders_disc_buttons" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PrescriptionPrevButtonsDischargeMed.jsp?<%=params%>" style="height:40vh;width:100vw"></iframe>
</html>

