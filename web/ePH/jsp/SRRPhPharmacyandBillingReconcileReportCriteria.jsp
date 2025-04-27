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
		<script LANGUAGE="javascript" src="../../ePH/js/SRRPhDrugMedicalSupplyDispByPatientClass.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
		<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
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
	<form name="formRxBillingReconicle" id="formRxBillingReconicle" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
		<TH COLSPAN="4" ALIGN="center"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td align="right" class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>	
			<td  align="left">
				<SELECT name="p_report_type" id="p_report_type" style="width:150px" >
					<option value ="S" selected><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
					<option value ="B"><fmt:message key="ePH.ByBillingGroup.label" bundle="${ph_labels}"/></option>
				</select>&nbsp;
			</td>
		</tr>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td align="right" class="label"> <fmt:message key="Common.Store.label" bundle="${common_labels}"/> </td>	
			<td  align="left">
				<input type='text' name='p_store_text' id='p_store_text' size='20' maxlength='5' value=''/>
				<input type="button" name="locn_lookup_btn" id="locn_lookup_btn" VALUE="?" CLASS="button"  onClick="callStoreLookup(formRxBillingReconicle.p_store_text);" >				
				&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">
				<input type='hidden' name ='p_store_code' value=''/>
				
			</td>				
		</tr>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
		<td align="right" class="label" ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<td  align="left" >
			<input type="text" size="19" maxlength="10"  name="dt_from" id="dt_from" value="<%=currentdate%>" OnBlur='CheckDate(this)'>&nbsp;<INPUT TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">
		</td>
		<td> &nbsp;
			<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>
			&nbsp;&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="text" size="19" maxlength="10" name="dt_to" id="dt_to" value="<%=currentdate%>" OnBlur='CheckDate(this)'>&nbsp;<INPUT TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
		</tr>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td align="right" class="label"> <fmt:message key="ePH.TimeHH:MM.label" bundle="${ph_labels}"/> </td>	
			<td  align="left">
				<input type='text' name='p_time_from' id='p_time_from' size='19' maxlength='5' value='' onBlur='ChkSplChars_time(this);' onkeypress='return allowPositiveNumber();' /> &nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td>
				<td><label class="label">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></label>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type='text' name='p_time_to' id='p_time_to' size='19' maxlength='5' value='' onkeypress='return allowPositiveNumber();' onBlur='ChkSplChars_time(this);'  />&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">
			</td>
		</tr>		
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td align="right" class="label"> <fmt:message key="ePH.TokenNo.label" bundle="${ph_labels}"/>.</td>	
			<td  align="left">
				<input type='text' name='p_token_from' id='p_token_from' size='19' maxlength='4' value=''  onBlur='ChkSplChars(this)' /></td>
				<td><label class="label">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></label>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type='text' name='p_token_to' id='p_token_to' size='19' maxlength='4' value=''  onBlur='ChkSplChars(this)'  />
			</td>
		</tr>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td align="right" class="label" ><fmt:message key="ePH.IncludeSale/PatientIssueandSaleReturn.label" bundle="${ph_labels}"/>  
			</td>
			<td><input type="checkbox" name="p_sale_return" id="p_sale_return" value="Y" onClick ="checkSaleReturn(this);" checked></td>
		</tr>
	</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=p_facility_id%>">
	<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
	
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="p_module_id" id="p_module_id" value="PH">	
	<input type="hidden" name="p_frm_time" id="p_frm_time" value="">
	<input type="hidden" name="p_to_time" id="p_to_time" value="">
	<input type="hidden" name="p_frm_date" id="p_frm_date" value="">
	<input type="hidden" name="p_to_date" id="p_to_date" value="">
	
	<input type="hidden" name="p_user_name" id="p_user_name" value="<%= session.getValue( "login_user" ) %>">
	<input type="hidden" name="p_report_id" id="p_report_id" value="">
	<input type="hidden" name="p_reprint" id="p_reprint" value="Y">
	<input type="hidden" name="p_report_name" id="p_report_name" value="">
	<input type="hidden" name="p_report_exec_name" id="p_report_exec_name" value="">	
	<input type="hidden" name="p_frm_token_no" id="p_frm_token_no" value="">	
	<input type="hidden" name="p_to_token_no" id="p_to_token_no" value="">	
	<input type="hidden" name="p_sale_flag" id="p_sale_flag" value="">	
	</form>
	
	</body>
	</html>

