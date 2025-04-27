<!DOCTYPE html>
 <%-- saved on 30/12/2009 --%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	//
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script>
 -->	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../ePH/js/SRRPhRepReissue.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../js/PhCommon.js"></script>
<!-- 	<script language="javascript" src="../js/PhMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 --></head>
<%
	String bean_id				= "SRRPHRepDispStatisByDispBean" ;
	String bean_name			= "ePH.SRRPHRepDispStatisByDispBean";
	SRRPHRepDispStatisByDispBean bean	= (SRRPHRepDispStatisByDispBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	String sys_date=bean.getSysDate();	
	String myLoginFacilityId = (String)session.getValue("facility_id");
	ArrayList dispLocnList = bean.getDispLocnList(myLoginFacilityId);
			if(dispLocnList == null)
				dispLocnList = new ArrayList();
%>


<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formSRRPhRepReissueCriteria.p_patient_id.focus()"> 
						
<form name="formSRRPhRepReissueCriteria" id="formSRRPhRepReissueCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
<br><br><br><br><br>
<table cellpadding="0" cellspacing="0" width="80%" align="center" border="0">
<TH COLSPAN="5"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	 <tr> <td class="label" colspan="4">&nbsp;</td></tr>
	 <tr>   	
		<td class="label" ><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td> 
		<td>&nbsp;&nbsp;<input type="text" size="12" maxlength=10 name="p_dt_from_text" id="p_dt_from_text" value="<%=com.ehis.util.DateUtils.convertDate(sys_date,"DMY","en",locale)%>" OnBlur='CheckDate(this);chkDate(p_dt_from_text,p_dt_to_text);'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_dt_from_text');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td>
		<input type = "hidden" name = "p_dt_from" value = "">
		<td>&nbsp;&nbsp;<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label></td><td>&nbsp;&nbsp;<input type="text" size="10" name="p_dt_to_text" id="p_dt_to_text" maxlength=10 value="<%=com.ehis.util.DateUtils.convertDate(sys_date,"DMY","en",locale)%>" OnBlur='CheckDate(this);chkDate(p_dt_from_text,p_dt_to_text);'><IMG  SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_dt_to_text');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
		<input type = "hidden" name = "p_dt_to" value = "">
	</tr>
	<tr><td>&nbsp;</td></tr>
	<TR>
				<TD CLASS="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></TD>
				<TD>&nbsp;&nbsp;<select name='p_disp_locn' id='p_disp_locn'>
						<option value='ALL'>--- <fmt:message key="Common.all.label" bundle="${common_labels}"/> ---</option>
<%
							for(int i=0; i<dispLocnList.size();i+=2){
%>
								<option value = <%= dispLocnList.get(i)%>><%= dispLocnList.get(i+1)%></option>
<%
							}
%>
					</select>
				</TD>
				<TD class="label" colspan="1"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></TD>
				<TD colspan="3">&nbsp;&nbsp;<input type="text" name="p_reason_desc" id="p_reason_desc" maxlength="60" size="60" readonly ><input type="button" class="button" value="?" name="reason_code_search" id="reason_code_search" onfocus="ReasonLookup(p_reason_desc);" onclick="ReasonLookup(p_reason_desc);">
				<input type="hidden" name="p_reason_code" id="p_reason_code" value="">
			</TD>	
	</TR>
	<tr>
						<td class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
						<td>&nbsp;&nbsp;<select name="p_locn_type" id="p_locn_type" onChange='clear1(this)'>
								<option value=""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;</option>
								<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
								<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
								</select>
						</td>
						<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
						<td>&nbsp;&nbsp;<input type="text" name="p_locn_name" id="p_locn_name" maxlength="20" size="20"   ><input type="button" name="btnLocation" id="btnLocation" class="button" value="?" onfocus="locationLookup(p_locn_name)" onClick="locationLookup(p_locn_name)">
						<input type="hidden" name="p_locn_code" id="p_locn_code">
					</td>		
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr>
		<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<input type="text" name="p_patient_id" id="p_patient_id" maxlength="<%=bean.getPatientIDLength()%>" size="20"  onKeyPress="changeToUpper()" ><input type="button" class="button" value="?" name="pat_search" id="pat_search" onfocus="callPatientSearch(document.formSRRPhRepReissueCriteria.p_patient_id)" onClick="callPatientSearch(document.formSRRPhRepReissueCriteria.p_patient_id)"></td>
  		
	</tr>
	<tr> <td class="label" colspan="4">&nbsp;</td></tr>
	<tr>
		<td class="label"><fmt:message key="ePH.DRUG/MEDICALSUPPLY.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;&nbsp;<select name="p_drug_med_supply" id="p_drug_med_supply" onChange='ChangeLegend(this)'>
				<option value="Y"> <fmt:message key="Common.Drug.label" bundle="${common_labels}"/> &nbsp;&nbsp;</option>
				<option value="N"><fmt:message key="ePH.MEDICALSUPPLY.label" bundle="${ph_labels}"/></option>
				<option value="" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			</select>
		</td>
			<TD class="label" colspan="1"  id="drug_item_label"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></TD>
				<TD colspan="3">&nbsp;&nbsp;<input type="text" name="p_drug_name" id="p_drug_name" maxlength="60" size="60"  ><input type="button" class="button" value="?" name="reason_code_search" id="reason_code_search" onfocus="Drug_ItemLookup(p_drug_name);" onclick="Drug_ItemLookup(p_drug_name);">
				<input type="hidden" name="p_drug_code" id="p_drug_code" value="">
			</TD>	

	</tr>
	<tr>
						<td class="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
						<td>&nbsp;&nbsp;<select name="p_order_by" id="p_order_by" >
							<!--	<option value=""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;</option> -->
								<option value="R"><fmt:message key="ePH.ReissueDispensingLocation.label" bundle="${ph_labels}"/></option>
								<option value="L"><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></option>
								</select>
						</td>
						<td class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
						<td>&nbsp;&nbsp;<select name="p_report_type" id="p_report_type" onChange='DisableOrderBy(this)'>
							
								<option value="D"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
								<option value="S"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
								</select>
						</td>
	</tr>

	</table>
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHRREISSUE">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="P_REPRINT" id="P_REPRINT" VALUE="Y">

	</form>
	<INPUT TYPE="hidden" name="SQL_PH_REISSUE_MEDICATION_SELECT4" id="SQL_PH_REISSUE_MEDICATION_SELECT4" VALUE="SELECT REASON_CODE code, REASON_DESC description FROM PH_MEDN_TRN_REASON_LANG_VW PH_MEDN_TRN_REASON WHERE  UPPER(REASON_CODE) LIKE UPPER(?) AND UPPER(REASON_DESC) LIKE UPPER(?) AND  APPL_TRN_TYPE='R' AND EFF_STATUS='E' AND LANGUAGE_ID =">
	<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">
	<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>">
	<INPUT TYPE="hidden" name="drug_search_query" id="drug_search_query" VALUE="SELECT DRUG_CODE code, DRUG_DESC description FROM PH_DRUG_LANG_VW PH_DRUG WHERE  DISCONTINUED_YN='N' AND DRUG_YN='Y' AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?)  AND LANGUAGE_ID =">
	<INPUT TYPE="hidden" name="item_search_query" id="item_search_query" VALUE="SELECT DRUG_CODE code, DRUG_DESC description FROM PH_DRUG_LANG_VW PH_DRUG WHERE  DISCONTINUED_YN='N' AND DRUG_YN='N' AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?)  AND LANGUAGE_ID =">
	<INPUT TYPE="hidden" name="drug_item_search_query" id="drug_item_search_query" VALUE="SELECT DRUG_CODE code, DRUG_DESC description FROM PH_DRUG_LANG_VW PH_DRUG WHERE  DISCONTINUED_YN='N' AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?)  AND LANGUAGE_ID =">
<% putObjectInBean(bean_id,bean,request); %>
	</body>
</html>

