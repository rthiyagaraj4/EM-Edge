<!DOCTYPE html>
<!--saved on 27th Oct 2005 -->
<%@page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="ePH.LastVisitMedication.label" bundle="${ph_labels}"/></title>
 </head>
 <%
 request.setCharacterEncoding("UTF-8");
//Added for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String params = request.getQueryString() ;
 %>
	<iframe name="f_active_order_details" id="f_active_order_details" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/LastVisitMedication.jsp?<%=params%>" style="height:90vh;width:100vw"></iframe><iframe name="f_close_frame" id="f_close_frame" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PrescriptionClose.jsp?called_from=diagnosis" style="height:10vh;width:100vw"></iframe>
</html>


