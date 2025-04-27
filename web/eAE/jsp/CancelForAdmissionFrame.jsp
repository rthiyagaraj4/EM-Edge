<!DOCTYPE html>
<!--
CRF/SCF Reference No 	:  ML-MMOH-CRF-1972
Detected Release  No  	:  SEPTEMBER 2023 Release 
File prepared by      	:  Lakshmanan P
File prepared date    	:  06-07-2023
Purpose of the Script   :  Cancel for Admission in AE current emergency Admission Patient 				   
Script Applicable for   :  Beta/Production/Both(Beta and Production)  - Applicable to All ML Sites	
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head> 
 <title><fmt:message key="eIP.CancelForAdmission.label" bundle="${ip_labels}"/></title>
</head>
<%
String patient_id = request.getParameter("patient_id");
String encounter_id = request.getParameter("encounter_id");
String referral_id = request.getParameter("referral_id");
String params = "Patient_Id="+patient_id+"&encounter_id="+encounter_id+"&referral_id="+referral_id;
String url1="../../eCommon/jsp/pline.jsp?"+params;
String url2="../../eAE/jsp/CancelForAdmission.jsp?"+params;
%>
<iframe name='plineFrame' id='plineFrame'    src='<%=url1%>' frameborder=0 scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
	<iframe name='cancel_for_addmission_frame' id='cancel_for_addmission_frame' 	src='<%=url2%>' frameborder=0 noresize scrolling='auto' style='height:80vh;width:100vw'></iframe>
</html>

