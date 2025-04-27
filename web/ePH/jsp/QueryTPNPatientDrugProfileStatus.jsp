<!DOCTYPE html>
  <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.Common.*, ePH.* " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="PatientDrugProfileStatus" id="PatientDrugProfileStatus">
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" bordercolor="black" id="patientdrugprofiletable" >
<tr>
	<td class="white" align="center" style="border-top:none;border-bottom:none;border-right:none;border-left:none;background-color:#FF5E5E" ><label class="label" style="font-size:9;color:white" width="16%"><b>&nbsp;<fmt:message key="Common.active.label" bundle="${common_labels}"/></b></label>	</td>		
	<td class="white" align="center" style="border:none;background-color:#C40062">
	<label class="label" style="font-size:9;color:white" width="16%"><b>&nbsp;<fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/> </b></label></td>
	<td class="white" align="center" style="border:none;background-color:#F0F000" width="16%"><label class="label" style="font-size:9"><b>&nbsp;<fmt:message key="ePH.Hold.label" bundle="${ph_labels}"/></b></label></td>
	<td class="white" align="center" style="border:none;background-color:#D9B86C" width="16%" nowrap><label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="ePH.ExpiredMedicationOrders.label" bundle="${ph_labels}"/></b></label></td>
	<td class="white" align="center" style="border:none;background-color:#99FFCC" width="16%"><label class="label" style="font-size:9"><b>&nbsp;<fmt:message key="ePH.FutureRx.label" bundle="${ph_labels}"/></b></label>
	</td>
</tr>
<tr>
	<td class="white" align="center" style="background-color:#478F8F;border:none"><label class="label" align="center" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="Common.Standard.label" bundle="${common_labels}"/>  </b></label></td>
	<td class="white" align="center" style="border:none;background-color:#92C9C9"><label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="ePH.NonStandard.label" bundle="${ph_labels}"/></b></label></td>
	<td class="white" align="center" style="border:none;background-color:#FF9DFF"><label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="Common.DischargeMedication.label" bundle="${common_labels}"/></b></label></td>	
	<td class="white" align="center" style="border:none;background-color:#990000"><label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></b></label></td>
	<td class="white" align="center" style="border:none;background-color:#8204FF"><label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="ePH.YettobeDispensed.label" bundle="${ph_labels}"/></b></label></td>
</tr>
<tr>
	<td class="" align="center" style="background-color:#0099FF"><label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="Common.PendingAuthorization.label" bundle="${common_labels}"/></b></label></td>
	<td class="" align="center" style="background-color:#33CC99"><label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="Common.PendingConsent.label" bundle="${common_labels}"/></b></label></td> 
	<td class="" align="center" style="background-color:#C48400"><label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="ePH.PendingSplAprvl.label" bundle="${ph_labels}"/></b></label></td>		
	<td class="" ><label class="label" style="font-size:9;color:white"><b>&nbsp;</b></label></td>
	<td class="" ><label class="label" style="font-size:9;color:white"><b>&nbsp;</b></label></td>
</tr>
</table>
</body>
</html>

