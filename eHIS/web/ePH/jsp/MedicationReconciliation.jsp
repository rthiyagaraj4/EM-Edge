<!DOCTYPE html>
 <!--This file is saved on 22/05/2019-->
<html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String params = request.getQueryString() ; 
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
%>
<head>
<title><fmt:message key="ePH.MedicalRecon.label" bundle="${ph_labels}"/></title>
</head>
   	<iframe name="med_reconc_criteria" id="med_reconc_criteria" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/MedicationReconciliationCriteria.jsp?<%=params%>" style="height:18vh;width:100vw"></iframe><iframe name="med_reconc_results" id="med_reconc_results" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:77vh;width:100vw"></iframe><iframe name="med_reconc_buttons" id="med_reconc_buttons" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:5vh;width:100vw"></iframe>
</html>

