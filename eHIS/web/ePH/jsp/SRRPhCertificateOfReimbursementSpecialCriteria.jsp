<!DOCTYPE html>
	 <%-- saved on 16/2/2010 --%>
	<%-- JSP Page specific attributes start --%>
	<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
	<%-- JSP Page specific attributes end --%>
	<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

	<%-- Mandatory declarations start --%>

	<%-- Mandatory declarations end --%>
	<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>

	<html>
	<head>

	<% 
			request.setCharacterEncoding("UTF-8");
			String locale			= (String)session.getAttribute("LOCALE");
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
			(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<!-- import the calendar script -->
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script LANGUAGE="javascript" src="../../ePH/js/SRRPhCertificateOfReimbursementSpecial.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
		<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	    <!-- 'DateUtils' is added on 12/1/2010 by Archanan Dhal related to incident no. IN0 23829 -->
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String p_facility_id		= (String) session.getValue( "facility_id" ) ;
		
		String bean_id			= "SRRPHDrugUsageByPractBean" ;
		String bean_name		= "ePH.SRRPHDrugUsageByPractBean";
		SRRPHDrugUsageByPractBean bean = (SRRPHDrugUsageByPractBean)getBeanObject( bean_id,bean_name,request ) ;
		bean.setLanguageId(locale);
		java.util.Date date_time	 	= new java.util.Date();
		String currentdate				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		
%>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 
	<form name="formCRForSpecial" id="formCRForSpecial" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	<table cellpadding="0" cellspacing="1" width="100%" align="center" border="0">
		<TH COLSPAN="6" ALIGN="center"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		<tr colspan="6">
			<td align="right" class="label"  ><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>	
			<td  align="left">
				<SELECT name="p_report_type" id="p_report_type" style="width:150px">
					<option value =""> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
					<option value ="O" selected><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
					<option value ="I"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
				</select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'  ></img>
			</td>
			<td align="right" class="label"  ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>	
			<td  align="left">
				<SELECT name="p_search_by" id="p_search_by" style="width:150px" onChange="enableBillReceipt(this);">
					<option value =""> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
					<option value ="B"> <fmt:message key="ePH.BillNo.label" bundle="${ph_labels}"/>.</option>
					<option value ="R"><fmt:message key="Common.receiptno.label" bundle="${common_labels}"/>.</option>
				</select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'  ></img>
			</td>			
		</tr>
		<tr colspan="6">
			<td align="right" class="label"  ><fmt:message key="ePH.BillDate.label" bundle="${ph_labels}"/> </td>	
			<td  align="left">
				<input type="text" size="19" maxlength="10" name="bill_date" id="bill_date" OnBlur='CheckDate(this)' disabled>&nbsp;<INPUT TYPE="image" name = "bill_calender"  SRC="../../eCommon/images/CommonCalendar.gif" id="Calendar" onclick="return showCalendar('bill_date');" disabled>
			</td>
			<td align="right" class="label"  ><fmt:message key="ePH.BillNo.label" bundle="${ph_labels}"/>.</td>	
			<td  align="left">
				<input type="text" size="19" maxlength="6" name="bill_number" id="bill_number" OnBlur='' disabled> / <input type="text" size="19"  maxlength="8" name="bill_number1" id="bill_number1" OnBlur='' disabled>
			</td>			
		</tr>
		<tr colspan="6">
			<td align="right" class="label"  ><fmt:message key="Common.receiptdate.label" bundle="${common_labels}"/> </td>	
			<td  align="left">
				<input type="text" size="19"  name="receipt_date" id="receipt_date" OnBlur='CheckDate(this)' disabled>&nbsp;<INPUT TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif" id="Calendar1" name="receipt_calender" id="receipt_calender" onclick="return showCalendar('receipt_date');" disabled>
			</td>
			<td align="right" class="label"  ><fmt:message key="Common.receiptno.label" bundle="${common_labels}"/>.</td>	
			<td  align="left">
				<input type="text" size="19" maxlength="6" name="receipt_number" id="receipt_number" OnBlur='' disabled> / <input type="text" size="19"  maxlength="8" name="receipt_number1" id="receipt_number1" OnBlur='' disabled>
			</td>			
		</tr>
		<tr colspan='6'>
			<td  class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> &nbsp;</td>
			<td align="left">
				<input type="text" name="p_patient_id" id="p_patient_id" size="24" 
						maxlength="" value="" onKeyPress="changeToUpper()" > 
				<input type="button" name="Patient_Button" id="Patient_Button" value="?" CLASS="button"  onClick="callPatientSearch(document.formCRForSpecial.p_patient_id)" >
				
				
			</td>
			<td  class="label"><fmt:message key="ePH.BillingGroup.label" bundle="${ph_labels}"/> &nbsp;</td>
			<td align="left">
				<input type="text" name="p_billing" id="p_billing" size="24" maxlength="" value=""> 
				<input type="button" name="billing_Button" id="billing_Button" value="?" CLASS="button"  onClick="selectBillingGroup(document.formCRForSpecial.p_billing)" >
				<input type ='hidden' name='p_privilege' id='p_privilege' value =''/>
			</td>
			<td  class="label"><fmt:message key="Common.Payer.label" bundle="${common_labels}"/> &nbsp;</td>
			<td align="left">
				<input type="text" name="p_payer_txt" id="p_payer_txt" size="24" value=""> 
				<input type="button" name="Payer_Button" id="Payer_Button" value="?" CLASS="button"  onClick="callPayerLookup(p_payer_txt)" >
				<input type="hidden" name="p_payer" id="p_payer" value="" />

			</td>
		</tr>
		<tr colspan='6'>
			<td  class="label"><fmt:message key="Common.ReportOption.label" bundle="${common_labels}"/> &nbsp;</td>
			<td align="left">
				<SELECT name="p_report_option" id="p_report_option" style="width:150px">					
					<option value ="R"><fmt:message key="Common.Reimburse.label" bundle="${common_labels}"/></option>
					<option value ="NR" selected><fmt:message key="ePH.NonReimburse.label" bundle="${ph_labels}"/> </option>
					<option value ="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>  <!--Corrected for 23829  -->
				</select>
			</td>
		</tr>
		<tr colspan='6'>
			<td colspan='4'>
			<td align="right">	<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callResultPage()">&nbsp;&nbsp;
				<input type="button" class="button" name="print" id="print" value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>' onClick="showPrint()" disabled></td>
			
		</tr>
		
	</table>
		<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
		<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
		<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
		<INPUT TYPE="hidden" name="currentdate" id="currentdate" VALUE="<%= currentdate %>">
		<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
		<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">
		<INPUT TYPE="hidden" name="p_reprint" id="p_reprint" VALUE="Y">
		<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=p_facility_id%>">
	
	</form>
</body>
</html>

