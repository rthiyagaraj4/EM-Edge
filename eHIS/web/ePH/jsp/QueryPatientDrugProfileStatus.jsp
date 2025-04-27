<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
12/10/2020      IN073397            Prabha     12/10/2020     Manickavasagam J          MOHE-CRF-0032
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*,java.sql.*,webbeans.eCommon.*" %> <!-- modified for MOHE-CRF-0032 -->
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
			 TD.EXPIRED_ORDER{    /* added for MOHE-CRF-0032 */
			BACKGROUND-COLOR:#FFA500; //code modified for MOHE-CRF-0032
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
<%
Connection con			= null;  // Added for MOHE-CRF-0032
        try{ // try catch added for MOHE-CRF-0032
			con				= ConnectionManager.getConnection(request);	// Added for MOHE-CRF-0032
			boolean expired_order = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","EXPIRY_ORDER_APP"); //Added for MOHE-CRF-0032
%>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="2" bordercolor="black" id="patientdrugprofiletable" >
				<tr>
					<td class="ACTIVE" width="10%" style="background-color: #d4601de3;">   
						<label class="label" style="font-size:9;color:white" width="17%"><b>&nbsp;<fmt:message key="Common.active.label" bundle="${common_labels}"/></b></label>
					</td>		
					<td class="DIS-CONTINUED" width="10%" style="background-color: maroon;">
						<label class="label" style="font-size:9;color:white" width="17%"><b>&nbsp;<fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/> </b></label>
					</td>
					<td class="HOLD" width="10%" style="background-color: yellow;">
						<label class="label" style="font-size:9"><b>&nbsp;<fmt:message key="ePH.Hold.label" bundle="${ph_labels}"/></b></label> 
					</td>
					<td class="ReturnedMedication" width="10%" style="background-color: orange;">
						<label class="label" style="font-size:9"><b>&nbsp;<fmt:message key="ePH.ReturnedMedication.label" bundle="${ph_labels}"/></b></label>
					</td>
					<td class="Refill_Rx" width="10%" style="background-color: darkgrey;">
						<label class="label" style="font-size:9"><b>&nbsp;<fmt:message key="ePH.RefillRx.label" bundle="${ph_labels}"/></b></label>
					</td>
					<%if(expired_order){ %> <!-- Modified for MOHE-CRF-0032 -->
					<td class="EXPIRED_ORDER" width="14%"  nowrap style="background-color: lightsalmon;">
						<label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="ePH.ExpiredMedicationOrders.label" bundle="${ph_labels}"/></b></label>
					</td>
					<%}else{ %>
					<td class="EXPIRED_MEDICATION" width="14%"  nowrap style="background-color: #dca43d;">
						<label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="ePH.ExpiredMedicationOrders.label" bundle="${ph_labels}"/></b></label>
					</td>
					<%} %>
				</tr>
				<tr>
					<td class="STANDARD" style="background-color: green;"><label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="ePH.IVFluid.label" bundle="${ph_labels}"/> </b></label></td>
					<td class="NONSTANDARD" style="background-color: lightblue;"><label class="label" style="font-size:9"><b>&nbsp;<fmt:message key="ePH.IVIngredients.label" bundle="${ph_labels}"/> </b></label></td>
					<td class="DISCHARGEMED1" style="background-color: lightpink;"><label class="label" style="font-size:9;color:white"><b>&nbsp; <fmt:message key="Common.DischargeMedication.label" bundle="${common_labels}"/></b></label></td>		
					<td class="CANCEL"  style="background-color: maroon;"><label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></b></label></td>
					<td class="YET_TO_BE_DISPENSED" style="background-color: purple;"><label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="ePH.YettobeDispensed.label" bundle="${ph_labels}"/></b></label></td>
					<td class="FUTURE_Rx" style="background-color: lightgreen;"><label class="label" style="font-size:9"><b>&nbsp;<fmt:message key="ePH.FutureRx.label" bundle="${ph_labels}"/></b></label></td>
				</tr>
				<tr>
					<td class="" style="background-color:#0099FF"><label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="Common.PendingAuthorization.label" bundle="${common_labels}"/></b></label></td>
					<td class="" style="background-color:#33CC99"><label class="label" style="font-size:9;color:black"><b>&nbsp;<fmt:message key="Common.PendingConsent.label" bundle="${common_labels}"/></b></label></td>
					<td class="" style="background-color:#C48400"><label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="ePH.PendingSplAprvl.label" bundle="${ph_labels}"/></b></label></td>		
					<td class="NON_FORMULARY">
						<label style="font-size:9;color:black"><b>&nbsp;<fmt:message key="ePH.NonFormulary.label" bundle="${ph_labels}"/></b></label>
					</td>
					<td class="" ><label class="label" style="font-size:9;color:white"><b>&nbsp;</b></label></td>
					<td class="HOME_MED" style="background-color: darkseagreen;"><label style="font-size:9;color:white"><b>&nbsp;<fmt:message key="ePH.HomeLeaveMedication.label" bundle="${ph_labels}"/></b></label></td>	<!--Added for Bru-HIMS-CRF-093-DD1[IN047223] -->		
				</tr>
			</table>
<% }
	catch(Exception e){ //Added for MOHE-CRF-0032
	e.printStackTrace();
		}
   finally{ //Added for MOHE-CRF-0032
     if(con != null)
          		ConnectionManager.returnConnection(con,request);	
          } // Added for MOHE-CRF-0032
%>	
		</form>
	</body>
</html>

