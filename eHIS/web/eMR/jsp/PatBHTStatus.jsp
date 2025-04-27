<!DOCTYPE html>
<!--
CRF Reference No     :  ML-MMOH-CRF-1959
Detected Release  No      :  SEPTEMBER 2023 Release 
File prepared by          :  SANTHOSH KUMAR N
File prepared date        :  1-07-2023
Purpose of the Change   :  As a MR user, In MR Module, I should be able to have a new function Receive BHT where the discharged records of all patient types can be changed to overdue, Delivered, returned or received.
Script Applicable for   :  Beta/Production/Both(Beta and Production)  - Applicable to All ML Sites    
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<body>

<table border='0' cellpadding='2' cellspacing='0' width='90%' align='center'>
<tr>
<td class="label"><fmt:message key="eMR.BHTStatus.label" bundle="${mr_labels}"/></td>
<td class="fields" style="WIDTH: 50px; background-color:#FFFF00"></td>
<td class="label"><fmt:message key="eMR.PENDING.label" bundle="${mr_labels}"/></td>
<td class="fields" style="WIDTH: 50px; background-color:#FF0000"></td>
<td class="label"><fmt:message key="eMR.OVERDUE.label" bundle="${mr_labels}"/></td>
<td class="fields" style="WIDTH: 50px; background-color:#ffa500"></td>
<td class="label"><fmt:message key="eMR.DELIVERED.label" bundle="${mr_labels}"/></td>
<td class="fields" style="WIDTH: 50px; background-color:#00FF00"></td>
<td class="label"><fmt:message key="eMR.RECEIVED.label" bundle="${mr_labels}"/></td>
<td class="fields" style="WIDTH: 50px; background-color:#007FFF"></td>
<td class="label"><fmt:message key="eMR.RETURNED.label" bundle="${mr_labels}"/></td>
</tr>
</table>
</body>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
