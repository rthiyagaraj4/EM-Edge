<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
----------------------------------------------------------------------------------------------------------------------------------
Date      	 Edit History      Name        Description
----------------------------------------------------------------------------------------------------------------------------------           
25/05/2017    IN06040      	  Mukesh M    For MMS-DM-CRF-0093
							  
----------------------------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,ePH.*,ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale = (String) session.getAttribute("LOCALE");
	String facilityId = (String) session.getValue("facility_id");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? 
			(String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhRepPayerGrpPrescription.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script> 
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script> 
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
	<form name="frmPHPrescriptionPayer" id="frmPHPrescriptionPayer" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
		<%
			String bean_id = "PrintPrescriptionReportBean";
			String bean_name = "ePH.PrintPrescriptionReportBean";
			PrintPrescriptionReportBean bean = (PrintPrescriptionReportBean) getBeanObject(bean_id, bean_name, request);
			bean.setLanguageId(locale);
			String p_patient_id = request.getParameter("patient_id");
			String curr_sys_date = "";
			String curr_week_date  = "";	
			curr_sys_date = com.ehis.util.DateUtils.getCurrentDate("DMY",localeName);
			curr_week_date	= com.ehis.util.DateUtils.minusDate(curr_sys_date,"DMY",localeName,31,"d");
	    	//	String status = "";//Removed for mms-dm-crf-0093
			if (p_patient_id == null || p_patient_id.equals("null")) {
				p_patient_id = "";
			} 
			String CDROrdersYN=bean.getCDROrdersYN();
			ArrayList iv_legend=new ArrayList();
			iv_legend=bean.getIVLegends();
			
		%>
	<table cellpadding="0" cellspacing="10" width="90%" align="center" border="0">
	    <TH COLSPAN="8"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	    <tr><td colspan="4">&nbsp;</td></tr>
		<tr>
			
			<td class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td>&nbsp;
				<input type="text" name="p_patient_id" id="p_patient_id" id="p_patient_id" value="<%=p_patient_id%>"   maxlength="<%=bean.getPatientIDLength()%>" size="24" onKeyPress="changeToUpper()" onblur="resetValues('Y');Duplicatecheck();" >   <!--resetValues('Y') Modified for MMS-DM-CRF-0093-->
				<input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch(this)"  onblur="resetValues('Y');" ><!-- onblur event added for MMS-DM-CRF-0093 -->
			</td>
			
			<td class="label"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
				<td>&nbsp;
					<select name="order_type" id="order_type">
					
					<option value="" selected><fmt:message key="ePH.NormalRx.label" bundle="${ph_labels}"/></option>
<%					for(int i=0;i<=9;i=i+2){
%>
						<option value="<%=(String)iv_legend.get(i)%>"><%=(String)iv_legend.get(i+1)%></option>
<%
					}
%>
					<option value="6"><fmt:message key="ePH.CompoundingRx.label" bundle="${ph_labels}"/></option>
					<option value="7"><fmt:message key="ePH.TPNStandard.label" bundle="${ph_labels}"/></option>
					<option value="8"><fmt:message key="ePH.TPNNonStandard.label" bundle="${ph_labels}"/></option>
<%
					if(CDROrdersYN.equals("Y")){
%>
						<option value="C"><fmt:message key="ePH.CDROrders.label" bundle="${ph_labels}"/></option>
<%
					}
					else{
%>
						<option value="9"><fmt:message key="ePH.Oncology.label" bundle="${ph_labels}"/></option>
						<option value="0"><fmt:message key="ePH.OncologyAdmixture.label" bundle="${ph_labels}"/></option>
<%
					}
%>
					</select>
				</td>
		</tr>
		<tr>
			<td class="label"><fmt:message key="ePH.EpisodeType.label" bundle="${ph_labels}"/>&nbsp;</td>
			<td >&nbsp;&nbsp;<select name="p_episode_type" id="p_episode_type" style="width:168px">
				<option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
				<option value="I"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
				<option value="O"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
				<option value="D"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
				<option value="E"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
				</select>
				<img src="../../eCommon/images/mandatory.gif"  align="center">
			</td>
			<td class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
			<td>&nbsp;
				<input type="text" name="p_encounter_id" id="p_encounter_id" id="p_encounter_id" maxlength="100" size="24" onBlur="ChangeUpperCase( this );if(this.value!=''){ encounterIdLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
				<input type="button" value="?" class="button" name="btnencounter" id="btnencounter" onClick="return encounterIdLookup()" >
			</td>
		</tr>
		<tr>
			<td class="label"><fmt:message key="Common.Payer.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
			<td>&nbsp;
				<input type="text" name="payergroup" id="payergroup" id="payergroup" maxlength="30" size="24" onBlur="ChangeUpperCase( this );if(this.value!=''){ payerGroupLookup();};resetValues();"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" > <!-- resetValues() Modified for MMS-DM-CRF-0093 -->
				<input type="button" value="?" class="button" name="btnPayerGroup" id="btnPayerGroup" onClick="return payerGroupLookup()" onblur ="resetValues();"  >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"> <!-- onblur event added for MMS-DM-CRF-0093 -->
			</td>
			<td class="label"><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>
			<td>&nbsp;
				<input type="text" name="payer_code" id="payer_code" id="payer_code" maxlength="30" size="24" onBlur="ChangeUpperCase( this );if(this.value!=''){ payerLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();">
				<input type="button" value="?" class="button" name="btnPayer" id="btnPayer" onClick="return payerLookup()">		
			</td>
		</tr>
		</tr>
		<tr>
			<td class="label"><fmt:message key="ePH.Policy.label" bundle="${ph_labels}"/></td>
			<td>&nbsp;
				<input type="text" name="policy_code" id="policy_code" id="policy_code" maxlength="100" size="24" onBlur="ChangeUpperCase( this );if(this.value!=''){ policyLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
				<input type="button" value="?" class="button" name="btnPolicy" id="btnPolicy" onClick="return policyLookup()"  >		
			</td>			
			<td colspan="2"></td>
		</tr>
		<tr>
			<td class="label"><fmt:message key="ePH.OrderedDateFrom.label" bundle="${ph_labels}"/></td> 
			<td>&nbsp;&nbsp;<input type="text" size="12" maxlength=10 name="fm_ord_date" id="fm_ord_date" value="<%=curr_week_date%>" OnBlur="CheckDateT(this);"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('fm_ord_date');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td>
				
			<td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			<td class="label">&nbsp;&nbsp;<input type="text" size="10" name="to_ord_date" id="to_ord_date" maxlength=10 value="<%=curr_sys_date%>" OnBlur="CheckDateT(this);"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('to_ord_date');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td><!--changed CheckDate to CheckDateT for Leap year calculation on 24/02/2012 -->
			<td colspan="2"></td>
		</tr>
	</table>
    <input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>"> 
	<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facilityId%>">
 	<input type="hidden" name="p_user_name" id="p_user_name" value="<%=session.getValue( "login_user" )%>">
 	<input type="hidden" name="p_payergroup" id="p_payergroup" value="">
 	<input type="hidden" name="p_payer_code" id="p_payer_code" value="">
  	<input type="hidden" name="p_policy_code" id="p_policy_code" value="">
	<input type="hidden" name="p_fm_ord_date" id="p_fm_ord_date" value="">
	<input type="hidden" name="p_to_ord_date" id="p_to_ord_date" value="">
	<input type="hidden" name="p_report_type" id="p_report_type" value="02">
	<input type="hidden" name="p_module_id" id="p_module_id" value="PH">
	<input type="hidden" name="p_report_id" id="p_report_id" value="">
	<input type="hidden" name="sys_date" id="sys_date" value="<%=curr_sys_date%>">
	<input type="hidden" name="p_iv_prep_yn" id="p_iv_prep_yn" value="">
	
	</form>
	<%
		putObjectInBean(bean_id, bean, request);
	%>
</body>
</html>

