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
		//Added bean_id1,bean1,bean_name1 for the incident num:23328 on 19/Aug/2010
		String bean_id1			= "ADRReportBean" ;
		String bean_name1		= "ePH.ADRReportBean";
		ADRReportBean bean1 = (ADRReportBean)getBeanObject(bean_id1,bean_name1 ,request) ;
		bean1.setLanguageId(locale);
		
%>

	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 
	<form name="formPHAdverseEvent" id="formPHAdverseEvent" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
		<TH COLSPAN="4" ALIGN="center"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td align="right" class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>	
			<td  align="left">
				<SELECT name="p_report_type" id="p_report_type" style="width:150px" onchange = "changePateintCertainity(formPHAdverseEvent.p_certainity);changeTop();changeOrderBy();changePatientEnable(this);">
					<option value ="S"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
					<option value ="D"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
				</select>
			</td>
		</tr>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td align="right" class="label"><fmt:message key="ePH.Hypersensitivity.label" bundle="${ph_labels}"/> </td>	
			<td  align="left">
				<SELECT name="p_hypersensitivity_type" id="p_hypersensitivity_type" style="width:150px"  onChange = 'populateEventType(this)'>
					<option value =""> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
					<option value ="01"><fmt:message key="Common.Allergy.label" bundle="${common_labels}"/></option>
					<option value ="02"><fmt:message key="ePH.TypeII.label" bundle="${ph_labels}"/> </option>
					<option value ="03"><fmt:message key="ePH.TypeIII.label" bundle="${ph_labels}"/> </option>
					<option value ="04"><fmt:message key="ePH.TypeIV.label" bundle="${ph_labels}"/> </option>
				</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">
			</td>
			<td align="right" class="label"><fmt:message key="Common.EventType.label" bundle="${common_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<SELECT name="p_event_type" id="p_event_type" style="width:150px" onChange='enable_cSubstance()'>					
				</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">
			</td>
		</tr>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td align="right" class="label"><fmt:message key="ePH.Allergen.label" bundle="${ph_labels}"/></td>	
			<td  align="left">
				<input type='text' name='p_allergen_text' id='p_allergen_text' size='24' maxlength='5' value=''/>
				<input type="button" name="locn_lookup_btn" id="locn_lookup_btn" VALUE="?" CLASS="button"  onClick="callAllergenLookup(formPHAdverseEvent.p_allergen_text);" >	
				<input type='hidden' name ='p_allergen_code' value =''/>
			</td>	
			<td align="right" class="label"><fmt:message key="ePH.CausativeSubstance.label" bundle="${ph_labels}"/>  
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type='text' name='p_substance_text' id='p_substance_text' size='24' maxlength='5' value='' disabled/>
				<input type="button" name="sub_lookup_btn" id="sub_lookup_btn" VALUE="?" CLASS="button" 
				onClick="open_cause_subs_lup(); " disabled>
				<input type='hidden' name ='p_substance_code' value =''/>
			</td>
		</tr>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td  class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> &nbsp;</td>
			<td align="left" nowrap>
				<input type="text" name="p_patient_id" id="p_patient_id" size="24" 
						maxlength="" value="" onKeyPress="return CheckForSpecChars(event)" maxlength="<%=bean1.getPatientIDLength()%>" onBlur="callPatientSearch();" disabled> 
				<input type="button" name="Patient_Button" id="Patient_Button" value="?" CLASS="button"  onClick="callPatientSearch()" disabled>
				&nbsp;</td>
				<td><label id="p_patient_name" style='display:none'></label>		
			</td>
		</tr>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
		<td align="right" class="label" ><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/> </td>
		<td  align="left" >
			<input type="text" size="19" maxlength="10" name="dt_from" id="dt_from" OnBlur='CheckDate(this)'>&nbsp;<INPUT TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from');" >
		</td>
		<td> &nbsp;
			<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>
			&nbsp;&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="text" size="19" maxlength="10" name="dt_to" id="dt_to" OnBlur='CheckDate(this)'>&nbsp;<INPUT TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to');" >
		</td>
		</tr>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td align="right" class="label"><fmt:message key="ePH.Certainty.label" bundle="${ph_labels}"/></td>	
			<td  align="left">
				<SELECT name="p_certainity" id="p_certainity" style="width:150px" onchange='changePateintCertainity(this);changeOrderBy();'>
					<option value ="D"><fmt:message key="Common.Definitive.label" bundle="${ph_labels}"/></option>
					<option value ="P"><fmt:message key="Common.Probable.label" bundle="${ph_labels}"/></option>	
					<option value ="" selected> <fmt:message key="Common.all.label" bundle="${common_labels}"/>  </option>
				</select>
			</td>
			<td align="right" class="label"><fmt:message key="Common.status.label" bundle="${common_labels}"/>  &nbsp;&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<SELECT name="p_status" id="p_status" style="width:150px" >
					<option value ="A"><fmt:message key="Common.active.label" bundle="${common_labels}"/></option>
					<option value ="E"><fmt:message key="Common.InError.label" bundle="${common_labels}"/></option>	
					<option value ="R"><fmt:message key="ePH.Resolve.label" bundle="${ph_labels}"/></option>	
					<option value ="" selected> <fmt:message key="Common.all.label" bundle="${common_labels}"/>  </option>
				</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">
			</td>
		</tr>		
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td align="right" class="label"> <fmt:message key="Common.Top.label" bundle="${ph_labels}"/></td>	
			<td  align="left">
				<input type='text' name='p_top' id='p_top' size='3' maxlength='2' value='' onKeyPress='allowPositiveNumber();' onBlur = 'ChkSplChars(this);'  /> &nbsp; <label class="label"><fmt:message key="Common.Items.label" bundle="${common_labels}"/></label>	<!-- Remove disabled for this text regdng incident num:23205 in spira on 12/Aug/2010 -->		
			</td>
			<td  align="left" class="label" ><fmt:message key="ePH.ByNoofPatient(by certainty).label" bundle="${ph_labels}"/> 
				<SELECT name="p_patient_certainity" id="p_patient_certainity" style="width:150px" disabled>
					<option value ="" selected>-----<fmt:message key="Common.Select.label" bundle="${ph_labels}"/>-------- </option>
					<option value ="D"><fmt:message key="Common.Definitive.label" bundle="${ph_labels}"/></option>
					<option value ="P"><fmt:message key="Common.Probable.label" bundle="${ph_labels}"/></option>
					<option value ="A"><fmt:message key="Common.all.label" bundle="${ph_labels}"/></option>
					
				</select>			
			</td>				
		</tr>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td align="right" class="label"> <fmt:message key="Common.orderBy.label" bundle="${ph_labels}"/></td>	
			<td  align="left">
				<SELECT name="p_order_by" id="p_order_by" style="width:170px" disabled >	
					<option value="">-----<fmt:message key="Common.Select.label" bundle="${ph_labels}"/>-------- </option>
                </select>
			</td>
						
		</tr>
		
	</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=p_facility_id%>">
	<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
	
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="p_module_id" id="p_module_id" value="PH">	
	<input type="hidden" name="p_adv_hyper" id="p_adv_hyper" value="">
	<input type="hidden" name="p_adv_event_type" id="p_adv_event_type" value="">
	<input type="hidden" name="p_causative_substance" id="p_causative_substance" value="">
	<input type="hidden" name="p_frm_onset_date" id="p_frm_onset_date" value="">
	<input type="hidden" name="p_to_onset_date" id="p_to_onset_date" value="">
	<input type="hidden" name="p_items_by" id="p_items_by" value="">
	<input type="hidden" name="p_certainty" id="p_certainty" value="">
	
	<input type="hidden" name="p_user_name" id="p_user_name" value="<%= session.getValue( "login_user" ) %>">
	<input type="hidden" name="p_report_id" id="p_report_id" value="">
	<input type="hidden" name="p_reprint" id="p_reprint" value="Y">
	<input type="hidden" name="p_report_name" id="p_report_name" value="">
	<input type="hidden" name="p_report_exec_name" id="p_report_exec_name" value="">
	 <!-- Aded Hidden variables beanid1,bean_name1 for the incident num:23328 on19/Aug/2010 -->
	<INPUT TYPE="hidden" name="bean_id1" id="bean_id1" VALUE="<%=bean_id1%>">    
	<INPUT TYPE="hidden" name="bean_name1" id="bean_name1" VALUE="<%=bean_name1%>">

	
	</form>
	
	
	</body>
	</html>



