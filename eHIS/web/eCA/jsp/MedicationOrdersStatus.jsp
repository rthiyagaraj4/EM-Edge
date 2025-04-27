<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.Common.*, ePH.*,eCommon.Common.* " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<style>
			TD.NON_FORMULARY{
				BACKGROUND-COLOR:#FF9999;
				FONT-SIZE: 8pt ;
				height:10;
				BORDER-STYLE: solid;
			}
		</style>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="PatientDrugProfileStatus" id="PatientDrugProfileStatus">
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="2" bordercolor="black" id="patientdrugprofiletable" >
				<tr>
					<td class="ACTIVE" width="10%" >   
						<label class="label" style="font-size:9;color:white" width="17%"><b>&nbsp;<fmt:message key="Common.active.label" bundle="${common_labels}"/></b></label>
					</td>		
					<td class="DIS-CONTINUED" width="10%" >
						<label class="label" style="font-size:9;color:white" width="17%"><b>&nbsp;<fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/> </b></label>
					</td>
					<td class="HOLD" width="10%">
						<label class="label" style="font-size:9"><b>&nbsp;<fmt:message key="ePH.Hold.label" bundle="${ph_labels}"/></b></label> 
					</td>
					<td class="ReturnedMedication" width="10%">
						<label class="label" style="font-size:9"><b>&nbsp;<fmt:message key="ePH.ReturnedMedication.label" bundle="${ph_labels}"/></b></label>
					</td>
					<td class="Refill_Rx" width="10%">
						<label class="label" style="font-size:9"><b>&nbsp;<fmt:message key="ePH.RefillRx.label" bundle="${ph_labels}"/></b></label>
					</td>
					<td class="EXPIRED_MEDICATION" width="14%"  nowrap>
						<label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="ePH.ExpiredMedicationOrders.label" bundle="${ph_labels}"/></b></label>
					</td>
				</tr>
				<tr>
					<td class="STANDARD"><label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="ePH.IVFluid.label" bundle="${ph_labels}"/> </b></label></td>
					<td class="NONSTANDARD" ><label class="label" style="font-size:9"><b>&nbsp;<fmt:message key="ePH.IVIngredients.label" bundle="${ph_labels}"/> </b></label></td>
					<td class="DISCHARGEMED1" ><label class="label" style="font-size:9;color:white"><b>&nbsp; <fmt:message key="Common.DischargeMedication.label" bundle="${common_labels}"/></b></label></td>		
					<td class="CANCEL" ><label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></b></label></td>
					<td class="YET_TO_BE_DISPENSED" ><label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="ePH.YettobeDispensed.label" bundle="${ph_labels}"/></b></label></td>
					<td class="FUTURE_Rx"><label class="label" style="font-size:9"><b>&nbsp;<fmt:message key="ePH.FutureRx.label" bundle="${ph_labels}"/></b></label></td>
				</tr>
				<tr>
					<td class="" style="background-color:#0099FF"><label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="Common.PendingAuthorization.label" bundle="${common_labels}"/></b></label></td>
					<td class="" style="background-color:#33CC99"><label class="label" style="font-size:9;color:black"><b>&nbsp;<fmt:message key="Common.PendingConsent.label" bundle="${common_labels}"/></b></label></td>
					<td class="" style="background-color:#C48400"><label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="ePH.PendingSplAprvl.label" bundle="${ph_labels}"/></b></label></td>		
					<td class="NON_FORMULARY">
						<label style="font-size:9;color:black"><b>&nbsp;<fmt:message key="ePH.NonFormulary.label" bundle="${ph_labels}"/></b></label>
					</td>
					<td class="" ><label class="label" style="font-size:9;color:white"><b>&nbsp;</b></label></td>
					<td class="HOME_MED"><label style="font-size:9;color:white"><b>&nbsp;<fmt:message key="ePH.HomeLeaveMedication.label" bundle="${ph_labels}"/></b></label></td>	<!--Added for Bru-HIMS-CRF-093-DD1[IN047223] -->		
				</tr>
			</table>
		</form>
	</body>
</html>

