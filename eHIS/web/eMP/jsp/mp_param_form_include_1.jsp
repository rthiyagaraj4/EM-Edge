<!-- This file created by Jeyachitra for ML-MMOH-CRF 1759.1 on 20-Dec-2024
Reason - server crashed when mp parameter page open -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page contentType="text/html; charset=UTF-8" import="java.sql.*,java.util.*,webbeans.eCommon.*,eXH.InterfaceUtil,eCommon.XSSRequestWrapper"  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html> 
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../js/mp_param.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/FieldFormatMethods.js"></script>
<% 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con=null ;
	Boolean isStartWith = false; 
	String alt_id1_start_with = "", alt_id2_start_with = "", alt_id3_start_with = "", alt_id4_start_with = "";
	
try{
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
    PreparedStatement pstmt=null;
    ResultSet rs=null;
	java.sql.Statement stmt11 = null;
    ResultSet rset11 = null;
	java.sql.Statement stmt = null ;
    ResultSet rset = null;
    con = ConnectionManager.getConnection(request);
	String locale = checkForNull((String)session.getAttribute("LOCALE"));
	Boolean isAbhaConsentAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ABHA_CONSENT");
	Boolean isDeathRegFormAppl  = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","DEATH_REGISTER_FORM_APPL");
	String aadhaarProfileYN			= checkForNull(request.getParameter("aadhaarProfileYN"),"N");
	String operation = checkForNull( request.getParameter( "operation") );
	String addl_field2_prompt = checkForNull( request.getParameter( "addl_field2_prompt") );
	String sec12 = checkForNull( request.getParameter( "sec12") );
	String sec13 = checkForNull( request.getParameter( "sec13") );
	String upd_pat_dtls_referral_yn = checkForNull( request.getParameter( "upd_pat_dtls_referral_yn") );
	String disp_cancelled_previous_enc_yn = checkForNull( request.getParameter( "disp_cancelled_previous_enc_yn") );
	String unmasking_yn = checkForNull( request.getParameter( "unmasking_yn") );
	String unmask_aadhaar_num_yn = checkForNull( request.getParameter( "unmask_aadhaar_num_yn") );
	String unmask_abha_num_addr_yn = checkForNull( request.getParameter( "unmask_abha_num_addr_yn") );
	String check_unmask_abha = checkForNull( request.getParameter( "check_unmask_abha") );
	String isUHID_valid_appl = checkForNull( request.getParameter( "isUHID_valid_appl") );
	String no_days_UHID_valid = checkForNull( request.getParameter( "no_days_UHID_valid") );
	String death_reg_form_req_yn = checkForNull( request.getParameter( "death_reg_form_req_yn") );
	String death_reg_form_req_yn_check = checkForNull( request.getParameter( "death_reg_form_req_yn_check") );
	String race_required_yn = checkForNull( request.getParameter( "race_required_yn") );
	String country_reqd_yn = checkForNull( request.getParameter( "country_reqd_yn") );
	String region_reqd_yn = checkForNull( request.getParameter( "region_reqd_yn") );
	String addl_field3_prompt = checkForNull( request.getParameter( "addl_field3_prompt") );
	String addl_field3_length = checkForNull( request.getParameter( "addl_field3_length") );
	String sec31 = checkForNull( request.getParameter( "sec31") );
	String sec32 = checkForNull( request.getParameter( "sec32") );
	String sec33 = checkForNull( request.getParameter( "sec33") );
	String addl_field4_prompt = checkForNull( request.getParameter( "addl_field4_prompt") );
	String addl_field4_length = checkForNull( request.getParameter( "addl_field4_length") );
	String sec41 = checkForNull( request.getParameter( "sec41") );
	String sec42 = checkForNull( request.getParameter( "sec42") );
	String sec43 = checkForNull( request.getParameter( "sec43") );
	String addl_field5_prompt = checkForNull( request.getParameter( "addl_field5_prompt") );
	String sec51 = checkForNull( request.getParameter( "sec51") );
	String sec52 = checkForNull( request.getParameter( "sec52") );
	String sec53 = checkForNull( request.getParameter( "sec53") );
	String module_instal_ind = checkForNull( request.getParameter( "module_instal_ind") );
	String dflt_alt_id1_in_emp_id_yn = checkForNull( request.getParameter( "dflt_alt_id1_in_emp_id_yn") );
	String max_patient_age = checkForNull( request.getParameter( "max_patient_age") );
	String entitlement_by_pat_cat_yn = checkForNull( request.getParameter( "entitlement_by_pat_cat_yn") );
	String suspend_service_yn = checkForNull( request.getParameter( "suspend_service_yn") );
	String acpt_appt_rfrl_in_reg_pat_yn = checkForNull( request.getParameter( "acpt_appt_rfrl_in_reg_pat_yn") );
	String  accept_pw_in_chng_pat_dtl_yn = checkForNull( request.getParameter( "accept_pw_in_chng_pat_dtl_yn") );
	String  gen_slno_unknown_pat_yn = checkForNull( request.getParameter( "gen_slno_unknown_pat_yn") );
	String  abha_eng_audio_path = checkForNull( request.getParameter( "abha_eng_audio_path") );
	String  abha_hin_audio_path = checkForNull( request.getParameter( "abha_hin_audio_path") );
	String  addl_field1_prompt = checkForNull( request.getParameter( "addl_field1_prompt") );
	String  addl_field1_length = checkForNull( request.getParameter( "addl_field1_length") );
	String  sec11 = checkForNull( request.getParameter( "sec11") );
	String  addl_field2_length = checkForNull( request.getParameter( "addl_field2_length") );
	String  sec21 = checkForNull( request.getParameter( "sec21") );
	String  sec22 = checkForNull( request.getParameter( "sec22") );
	String  sec23 = checkForNull( request.getParameter( "sec23") );
	String  addl_field5_length = checkForNull( request.getParameter( "addl_field5_length") );
	String  aadhaar_config_enabled_yn = checkForNull( request.getParameter( "aadhaar_config_enabled_yn") );
	String  aadhaar_option_value = checkForNull( request.getParameter( "aadhaar_option_value") );
	String  mobile_no_reqd_yn = checkForNull( request.getParameter( "mobile_no_reqd_yn") );
	String  accept_pw_in_chng_pat_dtl_yn1 = checkForNull( request.getParameter( "accept_pw_in_chng_pat_dtl_yn1") );
	String  inv_pat_search_in_reg_pat_yn = checkForNull( request.getParameter( "inv_pat_search_in_reg_pat_yn") );
	String  round_dob_estd_age = checkForNull( request.getParameter( "round_dob_estd_age") );
	String  pat_photo_renewal_alert_days = checkForNull( request.getParameter( "pat_photo_renewal_alert_days") );
	String  pat_ser_access_by_user_yn = checkForNull( request.getParameter( "pat_ser_access_by_user_yn") );
	String  upt_contact_dtls_oa_yn = checkForNull( request.getParameter( "upt_contact_dtls_oa_yn") );
	String  check_unmask_aadhar = checkForNull( request.getParameter( "check_unmask_aadhar") );
	String  email_id_reqd_yn = checkForNull( request.getParameter( "email_id_reqd_yn") );
	String  postal_cd_reqd_yn = checkForNull( request.getParameter( "postal_cd_reqd_yn") );
	String  area_reqd_yn = checkForNull( request.getParameter( "area_reqd_yn") );
	String  patientcategory_reqd_yn = checkForNull( request.getParameter( "patientcategory_reqd_yn") );
	String  religion_reqd_yn = checkForNull( request.getParameter( "religion_reqd_yn") );
	String  marital_status_reqd_yn = checkForNull( request.getParameter( "marital_status_reqd_yn") );
	String  occupation_reqd_yn = checkForNull( request.getParameter( "occupation_reqd_yn") );
	String  mand_visit_admssn_reg_yn = checkForNull( request.getParameter( "mand_visit_admssn_reg_yn") );
	String  no_days_before_deceased = checkForNull( request.getParameter( "no_days_before_deceased") );
	String  mortuary_release_yn = checkForNull( request.getParameter( "mortuary_release_yn") );
	String  cancel_reason_code = checkForNull( request.getParameter( "cancel_reason_code") );
	String  citizen_nationality_code = checkForNull( request.getParameter( "citizen_nationality_code") );
	String  citizen_nationality_desc = checkForNull( request.getParameter( "citizen_nationality_desc") );
	String  town_reqd_yn = checkForNull( request.getParameter( "town_reqd_yn") );
	String  default_race_code = checkForNull( request.getParameter( "default_race_code") );
	String  race_desc = checkForNull( request.getParameter( "race_desc") );
	String  dflt_language_id = checkForNull( request.getParameter( "dflt_language_id") );
	String  dflt_language_id_desc = checkForNull( request.getParameter( "dflt_language_id_desc") );
	String  dflt_relgn_code = checkForNull( request.getParameter( "dflt_relgn_code") );
	String  basic = checkForNull( request.getParameter( "basic") );
	String  advance = checkForNull( request.getParameter( "advance") );
	String  dflt_relgn_code_desc = checkForNull( request.getParameter( "dflt_relgn_code_desc") );	
	String chked ="";
	System.out.println("include 1 called");
%>

<table cellspacing='0' cellpadding='0' width='100%' border=0>
	<tr>
		<td width= "100%" class="white">
		<ul id="tablist" class="tablist" >
			
			<li class="tablistitem" title='<fmt:message key="Common.PatientAdministration.label" bundle="${common_labels}"/>'>
				<a class="tabA" id="pat_admin_tab" >
					<span class="tabAspan" id="pat_admin_tabspan" onClick='javascript:expandCollapse("pat_admin_tab")'><fmt:message key="Common.PatientAdministration.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eMP.LegalNames.label" bundle="${mp_labels}"/>'>
				<a class="tabA" id="legal_names_tab" >
					<span class="tabAspan" id="legal_names_tabspan" onClick='javascript:expandCollapse("legal_names_tab")'><fmt:message key="eMP.LegalNames.label" bundle="${mp_labels}"/></span>
				</a>
			</li>	
		<li class="tablistitem" title='<fmt:message key="eMP.AlternateIDChecks.label" bundle="${mp_labels}"/> '>
				<a class="tabA" id="alt_id_chk_tab" >
					<span class="tabAspan" id="alt_id_chk_tabspan" onClick='javascript:expandCollapse("alt_id_chk_tab")'><fmt:message key="eMP.AlternateIDChecks.label" bundle="${mp_labels}"/></span>
				</a>
			</li>	
			<li class="tablistitem" title='<fmt:message key="eMP.NewBorn.label" bundle="${mp_labels}"/>'>
				<a class="tabA" id="new_born_tab" >
					<span class="tabAspan" id="new_born_tabspan" onClick='javascript:expandCollapse("new_born_tab")'><fmt:message key="eMP.NewBorn.label" bundle="${mp_labels}"/></span>
				</a>
			</li>	
			<li class="tablistitem" title='<fmt:message key="Common.others.label" bundle="${common_labels}"/>'>
				<a class="tabClicked" id="others_tab" >
					<span class="tabSpanclicked" id="others_tabspan" onClick='javascript:expandCollapse("others_tab")'><fmt:message key="Common.others.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			
			<% if("Y".equalsIgnoreCase(aadhaarProfileYN)) {%>
			<li class="tablistitem" title='AADHAAR FUnction Configuration'>
				<a class="tabA" id="aadhar_tab" >
					<span class="tabAspan" id="aadhar_tabspan" onClick='javascript:expandCollapse("aadhar_tab")'><fmt:message key="eXH.AADHAAR.label" bundle="${xh_labels}"/></span>
				</a>
			</li>
			<% } %>
			</ul>
 </td></tr>
</table>
<table border='0' cellpadding='3' cellspacing='0' width='100%'>
				<tr>
                <td colspan='4' class='COLUMNHEADER'><fmt:message key="Common.general.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
				<td class="label" width='40%'>
				<% if(module_instal_ind.equals("DMS")) { %>
				<fmt:message key="eMP.UM_MaxPatientAge.label" bundle="${mp_labels}"/></td>
				<%} else { %>
				<fmt:message key="eMP.MaxPatientAge.label" bundle="${mp_labels}"/></td>
				<%}%>
				<td class="fields" width='10%'><input type='text' name='max_patient_age' id='max_patient_age' maxLength='3' size='3' onKeyPress='return allowValidNumber(this,event,3, 0);' value="<%=max_patient_age%>" nowrap><fmt:message key="Common.Years.label" bundle="${common_labels}"/>
				 </td>
				 <td class="label"  width='40%'><fmt:message key="eMP.DefaultAltID1ValueinEmp.ID.label" bundle="${mp_labels}"/></td>
				<td class='fields' width='10%'>
				<%
                if ( dflt_alt_id1_in_emp_id_yn .equals( "Y" ) )	
                    out.println( "<input type='checkbox' name='dflt_alt_id1_in_emp_id_yn' id='dflt_alt_id1_in_emp_id_yn' value='Y' checked onClick='checkForMode(this)'>"); 
                else
                    out.println( "<input type='checkbox' name='dflt_alt_id1_in_emp_id_yn' id='dflt_alt_id1_in_emp_id_yn' value='N' onClick='checkForMode(this)'>" ) ;
				%>
			</td>
		</tr>		
		<tr>
					
					<td class='label' width='40%'><% if(module_instal_ind.equals("DMS")) { %><fmt:message key="eMP.UM_ApplyEligibilityRulesbyPatientCategory.label" bundle="${mp_labels}"/>
					<%} else { %>
					<fmt:message key="eMP.ApplyEligibilityRulesbyPatientCategory.label" bundle="${mp_labels}"/>
					<%}%>
					<td class="fields" width='10%'>
						<%
							if ( operation.equalsIgnoreCase( "insert" ) )
							{	
								if (entitlement_by_pat_cat_yn.equals("N") )	{%>
								<input type='checkbox'  name='entitlement_by_pat_cat_yn' id='entitlement_by_pat_cat_yn'  value = 'N'  onClick='checkForMode(this)'>
							<%} else {%>
								<input type='checkbox'  name='entitlement_by_pat_cat_yn' id='entitlement_by_pat_cat_yn' value = 'Y'   checked onClick='checkForMode(this)'>
							<%}
							}else if ( operation.equalsIgnoreCase( "modify" ) ) {
								if (entitlement_by_pat_cat_yn.equals("N") )
								{	
							%>
								<input type='checkbox'  name='entitlement_by_pat_cat_yn' id='entitlement_by_pat_cat_yn' disabled value = 'N'  onClick='checkForMode(this)'>
							<%} else {%>
								<input type='checkbox'  name='entitlement_by_pat_cat_yn' id='entitlement_by_pat_cat_yn' disabled value = 'Y'   checked onClick='checkForMode(this)'>
							<%}
							}
							%>
					</td>
           <td class="label" width='40%'><% if(module_instal_ind.equals("DMS")) { %>
				<fmt:message key="eMP.UM_SuspendingServicetoPatient.label" bundle="${mp_labels}"/><%} else { %>
           <fmt:message key="eMP.SuspendingServicetoPatient.label" bundle="${mp_labels}"/>
				<%}%>
							</td><td class='fields' width='10%'>                
                <%
                if ( suspend_service_yn.equals( "Y" ) )
                    out.println( "<input type='checkbox' name='suspend_service_yn' id='suspend_service_yn' value='Y' checked>" );
                else
                    out.println( "<input type='checkbox' name='suspend_service_yn' id='suspend_service_yn' value='Y'>" );
            %>
           </td>
		</tr>	
		<tr>
			
			<td class="label" width='40%'><% if(module_instal_ind.equals("DMS")) { %>
				<fmt:message key="eMP.UM_AcceptApptRefNoReferralIDinRegisterPatient.label" bundle="${mp_labels}"/><%} else { %>
			<fmt:message key="eMP.AcceptApptRefNoReferralIDinRegisterPatient.label" bundle="${mp_labels}"/>
			<%}%>
			<td class="fields" width='10%'>
					<%
                if ( acpt_appt_rfrl_in_reg_pat_yn .equals( "Y" ) )
                    out.println( "<input type='checkbox' name='acpt_appt_rfrl_in_reg_pat_yn' id='acpt_appt_rfrl_in_reg_pat_yn' value='Y' checked onClick='checkForMode(this)' >" ); 
                else
                    out.println( "<input type='checkbox' name='acpt_appt_rfrl_in_reg_pat_yn' id='acpt_appt_rfrl_in_reg_pat_yn' value='N' onClick='checkForMode(this)' >" ) ;
            %> </td>
				<%
                if ( accept_pw_in_chng_pat_dtl_yn.equals( "Y" ) )
                   accept_pw_in_chng_pat_dtl_yn1 = "checked";
                else
					accept_pw_in_chng_pat_dtl_yn1 = "";
					%>
				<td class="label" width='40%'><% if(module_instal_ind.equals("DMS")) { %>
						<fmt:message key="eMP.UM_AcceptPasswordinChangePatientDtls.label" bundle="${mp_labels}"/>
				<%} else { %>
					<fmt:message key="eMP.AcceptPasswordinChangePatientDtls.label" bundle="${mp_labels}"/>
					<%}%> </td>
					<td class="fields" width='10%'>
				<input type='checkbox' name='accept_pw_in_chng_pat_dtl_yn' id='accept_pw_in_chng_pat_dtl_yn' value='Y'  <%=accept_pw_in_chng_pat_dtl_yn1%>>
				</td>
	</tr>
	<tr>
	<td class="label" width='40%'><% if(module_instal_ind.equals("DMS")) { %>
		<fmt:message key="eMP.UM_InvokePatientSearchinRegisterPatient.label" bundle="${mp_labels}"/>
	<%} else { %>
	<fmt:message key="eMP.InvokePatientSearchinRegisterPatient.label" bundle="${mp_labels}"/>
	<%}%> </td>
	<td class="fields" width='10%'>	
			<%   
				if ( inv_pat_search_in_reg_pat_yn .equals( "Y" ) )
                    out.println( "<input type='checkbox' name='INV_PAT_SEARCH_IN_REG_PAT_YN' id='INV_PAT_SEARCH_IN_REG_PAT_YN' value='Y'   checked >" );
					else
                    out.println( "<input type='checkbox' name='INV_PAT_SEARCH_IN_REG_PAT_YN' id='INV_PAT_SEARCH_IN_REG_PAT_YN' value='Y' >" ) ;
					%>
				</td>
				<td class="label" width='40%'><% if(module_instal_ind.equals("DMS")) { %>
					<fmt:message key="eMP.UM_GenerateSl.No.forUnknownPatients.label" bundle="${mp_labels}"/><%} else { %>
					<fmt:message key="eMP.GenerateSl.No.forUnknownPatients.label" bundle="${mp_labels}"/>
				<%}%>
				</td>
                <td class='fields' width='10%'>
							<% if (gen_slno_unknown_pat_yn.equals("Y")){%>
							<input type='checkbox' name='slno_yn' id='slno_yn' value='Y' checked onclick='Slnochk()' ><%}else{%>
							<input type='checkbox' name='slno_yn' id='slno_yn' value='N' onclick='Slnochk()' ><%}%>
							<input type='hidden' name='gen_slno_unknown_pat_yn' id='gen_slno_unknown_pat_yn' value='<%=gen_slno_unknown_pat_yn%>'>
						</td>					
				</tr>	
				<tr>
					<td class="label" width='40%'><fmt:message key="eMP.RoundoffDOBEstdAge.label" bundle="${mp_labels}"/></td>
					<td class='fields' width='10%'>
						<%                
						if (round_dob_estd_age.equals( "Y" ))
							out.println( "<input type='checkbox' name='round_dob_estd_age' id='round_dob_estd_age' value='Y' checked onclick='roundOffChk(this)'>" );
						else
							out.println( "<input type='checkbox' name='round_dob_estd_age' id='round_dob_estd_age' onclick='roundOffChk(this)'>" ) ;
						%>									
					</td>	
					<td class="label"><fmt:message key="eMP.AlertForPatientPhotoRenewalAfter.label" bundle="${mp_labels}"/></td>
					<td class="fields" width='10%'><input type='text' name='pat_photo_renewal_alert_days' id='pat_photo_renewal_alert_days' maxLength='3' size='3' onKeyPress='return chkForNumeric(event);' onblur ='checkForZero(this)' value="<%=pat_photo_renewal_alert_days%>" nowrap><fmt:message key="Common.days.label" bundle="${common_labels}"/>
				 </td>					
				</tr>	
	
				<tr>
					<td class="label" width='40%'><fmt:message key="eMP.PatSerAccessByUser.label" bundle="${mp_labels}"/></td>
					<td class='fields' width='10%'>
					<%if(pat_ser_access_by_user_yn.equals("Y")){
						out.println( "<input type='checkbox' name='pat_ser_access_by_user_yn' id='pat_ser_access_by_user_yn' value='Y' checked onclick='chkSetValue(this)'>" );
					}else{
						out.println( "<input type='checkbox' name='pat_ser_access_by_user_yn' id='pat_ser_access_by_user_yn' onclick='chkSetValue(this)'>" ) ;
					}%>
					</td>
				
					<td class=label nowrap><fmt:message key="eMP.SynPatientDtlsApt.label" bundle="${mp_labels}"/></td>
					<td class='fields' width='10%'>
					<%if(upt_contact_dtls_oa_yn.equals("Y")){
						out.println( "<input type='checkbox' name='upt_contact_dtls_oa_yn' id='upt_contact_dtls_oa_yn' value='Y' checked onclick='UptContactDtls(this)'>" );
					}else{
						out.println( "<input type='checkbox' name='upt_contact_dtls_oa_yn' id='upt_contact_dtls_oa_yn' onclick='UptContactDtls(this)'>" ) ;
					}%>
					
				</tr>
			
				<tr>
					<td class="label" width='40%'><fmt:message key="eMP.UpdatePatientDetailsToReferrals.label" bundle="${mp_labels}"/></td>
					<td class='fields' width='10%'>
					<%if(upd_pat_dtls_referral_yn.equals("Y")){
						out.println( "<input type='checkbox' name='upd_pat_dtls_referral_yn' id='upd_pat_dtls_referral_yn' value='Y' checked onclick='chkSetValue(this)'>" );
					}else{
						out.println( "<input type='checkbox' name='upd_pat_dtls_referral_yn' id='upd_pat_dtls_referral_yn' onclick='chkSetValue(this)'>" ) ;
					}%>
					</td>
					
					<td class="label" width='40%'><fmt:message key="Common.DisplayCancelledPreviousEncounters.label" bundle="${common_labels}"/></td>
						<td class='fields' width='10%'>
						<%if(disp_cancelled_previous_enc_yn.equals("Y")){
						out.println( "<input type='checkbox' name='disp_cancelled_previous_enc_yn' id='disp_cancelled_previous_enc_yn' value='Y' checked onclick='chkSetValue(this)'>" );
					}else{
						out.println( "<input type='checkbox' name='disp_cancelled_previous_enc_yn' id='disp_cancelled_previous_enc_yn' onclick='chkSetValue(this)'>" ) ;
					}%>
					</tr>
					
					<%if(unmasking_yn.equals("Y")){ %>
					<tr>
					<td class="label" width='40%'><fmt:message key="eMP.UnMaskAadhaarNum.label" bundle="${mp_labels}"/></td>
					<td class='fields' width='10%'>
					<input type='checkbox' name='unmask_aadhaar_num_yn' id='unmask_aadhaar_num_yn' value='<%=unmask_aadhaar_num_yn %>' <%=check_unmask_aadhar %> onclick='chkSetValue(this)'>
					</td>
					</tr>
					<tr>
					<td class="label" width='40%'><fmt:message key="eMP.UnMaskAbhaNumAdd.label" bundle="${mp_labels}"/></td>
					<td class='fields' width='10%'>
					<input type='checkbox' name='unmask_abha_num_addr_yn' id='unmask_abha_num_addr_yn' value='<%=unmask_abha_num_addr_yn %>' <%=check_unmask_abha %> onclick='chkSetValue(this)'>
					</td>
					</tr>
					<%} %>
					
					<%
					if(isUHID_valid_appl.equals("true")){  
					%>
					<tr>
					<td class="label" width='40%'><fmt:message key="eMP.UHIDValidFor.label" bundle="${mp_labels}"/></td>
					<td class='fields' width='10%'>
					<%
						out.println( "<input type='text' name='no_days_UHID_valid_for' id='no_days_UHID_valid_for' maxLength='3' size='3' onKeyPress='return chkForNumeric(event);' value='"+no_days_UHID_valid+"' onpaste='return false;' >" );
					%>
					&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/>
					</td>
					</tr>
					<%
					}
					%>

 					<%if(isDeathRegFormAppl){ %> 
					<tr>
					<td class='label' width='40%'><fmt:message key="eMP.EnableDeathRegFormDuringCheckout.label" bundle="${mp_labels}"/></td>
					<td class='field' width='10%'>
						<input type='checkbox' name='death_reg_form_req_yn' id='death_reg_form_req_yn' value='<%=death_reg_form_req_yn %>' <%=death_reg_form_req_yn_check %> onclick='chkSetValue(this)'>
					</td>
					</tr>
					<%} %>
					<input type='hidden' name='isUHID_valid_appl' id='isUHID_valid_appl' value="<%=isUHID_valid_appl%>" >
					
                <tr>
					<td colspan='4' class='COLUMNHEADER'><fmt:message key="eMP.ReqdDuringRegn.label" bundle="${mp_labels}"/></td>
				</tr>
				<tr>
				<td class="label" colspan='3'><fmt:message key="Common.race.label" bundle="${common_labels}"/>
						<%                
						if ( race_required_yn .equals( "Y" ) )
							out.println( "<input type='checkbox' name='race_required_yn' id='race_required_yn' value='Y' checked onclick='chkSetValue(this)'>" );
						else
							out.println( "<input type='checkbox' name='race_required_yn' id='race_required_yn' onclick='chkSetValue(this)'>" ) ;
						%>	
						<fmt:message key="Common.country.label" bundle="${common_labels}"/>
						<%                
						if ( country_reqd_yn .equals( "Y" ) )
							out.println( "<input type='checkbox' name='country_reqd_yn' id='country_reqd_yn' value='Y' checked onclick='chkSetValue(this)'>" );
						else
							out.println( "<input type='checkbox' name='country_reqd_yn' id='country_reqd_yn' onclick='chkSetValue(this)'>" ) ;
						%>		
						<fmt:message key="eMP.region.label" bundle="${mp_labels}"/>
						<%                
						if ( region_reqd_yn .equals( "Y" ) )
							out.println( "<input type='checkbox' name='region_reqd_yn' id='region_reqd_yn' value='Y' checked onclick='chkSetValue(this)'>" );
						else
							out.println( "<input type='checkbox' name='region_reqd_yn' id='region_reqd_yn' onclick='chkSetValue(this)'>" ) ;
						%>
						<fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/>
						<%                
						if ( mobile_no_reqd_yn .equals( "Y" ) )
							out.println( "<input type='checkbox' name='mobile_no_reqd_yn' id='mobile_no_reqd_yn' value='Y' checked onclick='chkSetValue(this)'>" );
						else
							out.println( "<input type='checkbox' name='mobile_no_reqd_yn' id='mobile_no_reqd_yn' onclick='chkSetValue(this)'>" ) ;
						%>
						<fmt:message key="Common.email.label" bundle="${common_labels}"/>
						<%                
						if ( email_id_reqd_yn .equals( "Y" ) )
							out.println( "<input type='checkbox' name='email_id_reqd_yn' id='email_id_reqd_yn' value='Y' checked onclick='chkSetValue(this)'>" );
						else
							out.println( "<input type='checkbox' name='email_id_reqd_yn' id='email_id_reqd_yn' onclick='chkSetValue(this)'>" ) ;
						%>
						<fmt:message key="eMP.Postal.label" bundle="${mp_labels}"/>
						<%                
						if ( postal_cd_reqd_yn .equals( "Y" ) )
							out.println( "<input type='checkbox' name='postal_cd_reqd_yn' id='postal_cd_reqd_yn' value='Y' checked onclick='chkSetValue(this)'>" );
						else
							out.println( "<input type='checkbox' name='postal_cd_reqd_yn' id='postal_cd_reqd_yn' onclick='chkSetValue(this)'>" ) ;
						%><fmt:message key="Common.area.label" bundle="${common_labels}"/>
						<%                
						if ( area_reqd_yn .equals( "Y" ) )
							out.println( "<input type='checkbox' name='area_reqd_yn' id='area_reqd_yn' value='Y' checked onclick='chkSetValue(this)'>" );
						else
							out.println( "<input type='checkbox' name='area_reqd_yn' id='area_reqd_yn' onclick='chkSetValue(this)'>" ) ;
						%>	
						
						<fmt:message key="Common.category.label" bundle="${common_labels}"/>
						<%                
						if ( patientcategory_reqd_yn .equals( "Y" ) )
							out.println( "<input type='checkbox' name='patientcategory_reqd_yn' id='patientcategory_reqd_yn' value='Y' checked onclick='chkSetValue(this)'>" );
						else
							out.println( "<input type='checkbox' name='patientcategory_reqd_yn' id='patientcategory_reqd_yn' onclick='chkSetValue(this)'>" ) ;
						%>
						
						<fmt:message key="Common.Town.label" bundle="${common_labels}"/>
						<%                
						if ( town_reqd_yn .equals( "Y" ) )
							out.println( "<input type='checkbox' name='town_reqd_yn' id='town_reqd_yn' value='Y' checked onclick='chkSetValue(this)'>" );
						else
							out.println( "<input type='checkbox' name='town_reqd_yn' id='town_reqd_yn' onclick='chkSetValue(this)'>" ) ;
						%> 
						</td>	
						</tr>
						<tr>
						 
						<td class="label" colspan='3'><fmt:message key="Common.religion.label" bundle="${common_labels}"/>
						<%
						if (religion_reqd_yn .equals( "Y" ) )
							out.println("<input type='checkbox' name='religion_reqd_yn' id='religion_reqd_yn' value='Y' checked onclick='chkSetValue(this)'>");
						else
							out.println("<input type='checkbox' name='religion_reqd_yn' id='religion_reqd_yn' onclick='chkSetValue(this)'>") ;
						%>
						<fmt:message key="eMP.maritalstatus.label" bundle="${mp_labels}"/>
						<%                
						if ( marital_status_reqd_yn .equals( "Y" ) )
							out.println( "<input type='checkbox' name='marital_status_reqd_yn' id='marital_status_reqd_yn' value='Y' checked onclick='chkSetValue(this)'>" );
						else
							out.println( "<input type='checkbox' name='marital_status_reqd_yn' id='marital_status_reqd_yn' onclick='chkSetValue(this)'>" ) ;
						%> 
						<fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/>
						<%                
						if ( occupation_reqd_yn .equals( "Y" ) )
							out.println( "<input type='checkbox' name='occupation_reqd_yn' id='occupation_reqd_yn' value='Y' checked onclick='chkSetValue(this)'>" );
						else
							out.println( "<input type='checkbox' name='occupation_reqd_yn' id='occupation_reqd_yn' onclick='chkSetValue(this)'>" ) ;
						%> 
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eMP.mand_visit_admssn_reg.label" bundle="${mp_labels}"/>
						<%                
						if ( mand_visit_admssn_reg_yn .equals( "Y" ) )
							out.println( "<input type='checkbox' name='mand_visit_admssn_reg_yn' id='mand_visit_admssn_reg_yn' value='Y' checked onclick='chkSetValue(this)'>" );
						else
							out.println( "<input type='checkbox' name='mand_visit_admssn_reg_yn' id='mand_visit_admssn_reg_yn' onclick='chkSetValue(this)'>" ) ;
						%>	
                        
					</td>	
										
				</tr> 
			
				<tr>
					<td colspan='4' class='COLUMNHEADER'><fmt:message key="eMP.AutoCancelFutDtls.label" bundle="${mp_labels}"/></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="eMP.NoOfDaysBeforeDeceased.label" bundle="${mp_labels}"/></td>
					<td class="fields" width='10%'><input type='text' name='no_days_before_deceased' id='no_days_before_deceased' maxLength='3' size='3' onblur='makemand(this);' onKeyPress='return chkForNumeric(event);'  value="<%=no_days_before_deceased%>" nowrap><fmt:message key="Common.days.label" bundle="${common_labels}"/>
					</td>
					<%
					
					int mo_cnt=0;
					if(stmt != null)    stmt.close();
					if(rset != null)    rset.close();  
					try
						{
						stmt = con.createStatement();
						rset=stmt.executeQuery("select count(*) from sm_module where module_id='MO' and install_yn='Y'");
						if(rset.next())
						mo_cnt=rset.getInt(1);
						if(stmt != null)    stmt.close();
						if(rset != null)    rset.close();   
						}
					catch(Exception e)		
						{
						e.printStackTrace();
						}
					if(mo_cnt>0)
							{
							%>
							<td class="label" width='40%' nowrap><fmt:message key="eMP.DeceasedPatsReleasedMO.label" bundle="${mp_labels}"/></td>
							<td class='fields' width='10%'>
								<%                
								
								if ( mortuary_release_yn .equals( "Y" ) )
									out.println( "<input type='checkbox' name='mortuary_release_yn' id='mortuary_release_yn' value='Y' checked onclick='chkSetValue(this)'>" );
								else
									out.println( "<input type='checkbox' name='mortuary_release_yn' id='mortuary_release_yn' onclick='chkSetValue(this)'>" ) ;
								%>			
							</td>	
							<%}%>
					</tr>
					<%
						String disReason="";
						if(cancel_reason_code.equals("")){
							disReason="disabled";
						}
									%>
					<tr>
            <td class='label' ><fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/></td>
            <td width='30%' class='fields' >
                <select name="cancel_reason_code" id="cancel_reason_code" style='width:150px' <%=disReason%>>
                <option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
                <%
                    if(stmt != null)    stmt.close();
                    if(rset != null)    rset.close();
                    stmt = con.createStatement() ;
                    rset = stmt.executeQuery ("Select am_get_desc.am_contact_reason(contact_reason_code,'"+locale+"',1)Contact_Reason, Contact_Reason_Code from AM_CONTACT_REASON where CANCEL_APPOINTMENT_YN = 'Y' and CANCEL_BOOKING_YN='Y' and CANCEL_WAIT_LIST_YN='Y' and Eff_Status = 'E' order by 1") ;
                    if(rset != null)
                    {
                        while(rset.next())
                        {
                            chked = "" ;
                            if(cancel_reason_code.equals(rset.getString("Contact_Reason_Code")))
                                chked = "selected" ;
                                out.println( "<option value=\""+rset.getString("Contact_Reason_Code")+"\" "+chked+">"+rset.getString("Contact_Reason")+"</option>" ) ; 
                        }
                    }
                    if(stmt != null)    stmt.close();
                    if(rset != null)    rset.close();                           
                %> </select><img src='../images/mandatory.gif' id='reasonCodeMand' style='visibility:hidden'></img>
                </td>
				<td class="label" width='40%'></td>
				<td class='fields' width='10%'></td>
				</tr>
					
		</table>
 <table border='0' cellpadding='3' cellspacing='0' width='100%'>
				<tr>
                <td colspan='4' class='COLUMNHEADER'><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
				</tr>
				 <tr>
                <td class="label" width='25%' nowrap><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
                <td class="fields" width='25%'>
				<%				if(pstmt!=null) pstmt.close();
								if(rs!=null) rs.close();
								pstmt = con.prepareStatement("select long_desc from mp_country where eff_status='E' and country_code=? and ( sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr') ) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr') ) ) order by long_desc");
                               	pstmt.setString(1,citizen_nationality_code); 
                                rs = pstmt.executeQuery();
                                while( rs.next() )
                                {
                                   citizen_nationality_desc=rs.getString("long_desc");
                                }
                                if(pstmt != null)    pstmt.close();
                                if(rs != null)    rs.close();
					if(!citizen_nationality_desc.equals(""))
						{
					%>
				 <input type='text' name='citizen_nationality_desc' id='citizen_nationality_desc' size='20' maxlength='20' value="<%=citizen_nationality_desc%>" onfocus='calllfocusoth()' onblur='if(this.value!=""){searchNationality(citizen_nationality_code,citizen_nationality_desc);}else{document.forms[0].citizen_nationality_code.value="";}' ><input type='button'   name='citizen_nationality_id' id='citizen_nationality_id' value='?' class='button' onclick='searchNationality(this,citizen_nationality_desc)'>
				<input type='hidden' name='citizen_nationality_code' id='citizen_nationality_code' value="<%=citizen_nationality_code%>">
				<% }
				else
				{ %>
				<input type='text' name='citizen_nationality_desc' id='citizen_nationality_desc' size='20' maxlength='20' value="" onblur='if(this.value!="")searchNationality(citizen_nationality_code,citizen_nationality_desc);' ><input type='button'   name='citizen_nationality_id' id='citizen_nationality_id' value='?' class='button' onclick='searchNationality(this,citizen_nationality_desc)'>
				<input type='hidden' name='citizen_nationality_code' id='citizen_nationality_code' value="">
				<% } %>
				</td>
				<td class="label" width='25%'  nowrap><fmt:message key="Common.race.label" bundle="${common_labels}"/></td>
				<td class="fields" width='25%' >	
					<%			if(pstmt!=null) pstmt.close();
								if(rs!=null) rs.close();
								pstmt = con.prepareStatement("select long_desc from mp_race where eff_status='E' and race_code=? and ( sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr') ) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr') ) ) order by long_desc");
                               	pstmt.setString(1,default_race_code); 
                                rs = pstmt.executeQuery();
                                while( rs.next() )
                                {
                                   race_desc=rs.getString("long_desc");
                                }
                                if(pstmt != null)    pstmt.close();
                                if(rs != null)    rs.close();
					if(!race_desc.equals(""))
						{
					%>
				 <input type='text' name='race_desc' id='race_desc' size='20' maxlength='20' value="<%=race_desc%>" onblur='if(this.value!=""){searchRace(default_race_code,race_desc);}else{document.forms[0].default_race_code.value = "";}' ><input type='button'   name='race_id' id='race_id' value='?' class='button' onclick='searchRace(this,race_desc)'>
				<input type='hidden' name='default_race_code' id='default_race_code' value="<%=default_race_code%>">
				<% }
				else
				{ %>
				<input type='text' name='race_desc' id='race_desc' size='20' maxlength='20' value="" onblur='if(this.value!=""){searchRace(default_race_code,race_desc);}else{document.forms[0].default_race_code.value = "";}' ><input type='button'   name='race_id' id='race_id' value='?' class='button' onclick='searchRace(this,race_desc)'>
				<input type='hidden' name='default_race_code' id='default_race_code' value="">
				<% } %>
				</td>
				</tr>
				<tr>
				<td class='label' colspan='1'>
				<% if(module_instal_ind.equals("DMS")) { %>				
					<fmt:message key="Common.UM_patient.label" bundle="${common_labels}"/>
					&nbsp;<fmt:message key="Common.Language.label" bundle="${common_labels}"/></td>
				<% } else { %>
					<fmt:message key="Common.patient.label" bundle="${common_labels}"/>
					&nbsp;<fmt:message key="Common.Language.label" bundle="${common_labels}"/></td>
				<% } %>
				<td class='fields' > 
				<%				if(pstmt!=null) pstmt.close();
								if(rs!=null) rs.close();
                                pstmt = con.prepareStatement("Select LONG_NAME  from MP_LANGUAGE where Eff_Status = 'E' and  lang_id=? order by 1");
                                pstmt.setString(1, dflt_language_id);
                                rs = pstmt.executeQuery();
                                while( rs.next() )
                                {
                                   dflt_language_id_desc=rs.getString("LONG_NAME");
                                }
                                if(pstmt != null)    pstmt.close();
                                if(rs != null)    rs.close();
					if(!dflt_language_id_desc.equals(""))
						{
					%>
				 <input type='text' name='language_desc' id='language_desc' size='20' maxlength='20' value="<%=dflt_language_id_desc%>" onblur='if(this.value!="")searchLanguage(language_code,language_desc);' ><input type='button'   name='language_code_id' id='language_code_id' value='?' class='button' onclick='searchLanguage(this,language_desc)'>
				<input type='hidden' name='language_code' id='language_code' value="<%=dflt_language_id%>">
				<% }
				else
				{ %>
				<input type='text' name='language_desc' id='language_desc' size='20' maxlength='20' value="" onblur='if(this.value!="")searchLanguage(language_code,language_desc);' ><input type='button'   name='language_code_id' id='language_code_id' value='?' class='button' onclick='searchLanguage(this,language_desc)'>
				<input type='hidden' name='language_code' id='language_code' value="">
				<% } %>
				</td>
				<td class='label' colspan='1'>
				<% if(module_instal_ind.equals("DMS")) { %>				
					<fmt:message key="Common.UM_patient.label" bundle="${common_labels}"/>
				<% } else { %>
					<fmt:message key="Common.patient.label" bundle="${common_labels}"/>
				<% } %>
					&nbsp;<fmt:message key="Common.religion.label" bundle="${common_labels}"/>
				<td class='fields' > 
				<%				if(pstmt!=null) pstmt.close();
								if(rs!=null) rs.close();
                                pstmt = con.prepareStatement("Select LONG_DESC  from MP_RELIGION where Eff_Status = 'E' and  RELGN_CODE=? order by 1");
                                pstmt.setString(1, dflt_relgn_code); 
                                rs = pstmt.executeQuery();
                                while( rs.next() )
                                {
                                   dflt_relgn_code_desc=rs.getString("LONG_DESC");
                                }
                                if(pstmt != null)    pstmt.close();
                                if(rs != null)    rs.close();
				if(!dflt_relgn_code_desc.equals(""))
						{
					%>
				 <input type='text' name='religion_desc' id='religion_desc' size='20' maxlength='20' value="<%=dflt_relgn_code_desc%>" onblur='if(this.value!="")searchReligion(religion_code,religion_desc);'  ><input type='button'   name='religion_code_id' id='religion_code_id' value='?' class='button' onclick='searchReligion(this,religion_desc)'>
				<input type='hidden' name='religion_code' id='religion_code' value="<%=dflt_relgn_code%>">
				<% }
				else
				{ %>
				<input type='text' name='religion_desc' id='religion_desc' size='20' maxlength='20' value="" onblur='if(this.value!="")searchReligion(religion_code,religion_desc);'  ><input type='button'   name='religion_code_id' id='religion_code_id' value='?' class='button' onclick='searchReligion(this,religion_desc)'>
				<input type='hidden' name='religion_code' id='religion_code' value="">
				<% } %>
				</td></tr>
               
				<tr><td colspan='1' class='label' ><fmt:message key="eMP.PatientSearchTab.label" bundle="${mp_labels}"/></td><td class='fields'>
				<select name='pat_search_tab' id='pat_search_tab'   onChange='checkadditionalfield(this,0)'>
				<option value='B' <%=basic%> ><fmt:message key="Common.basic.label" bundle="${common_labels}"/></option>
				<option value='A' <%=advance%> ><fmt:message key="Common.advanced.label" bundle="${common_labels}"/></option>
				</select></td></tr>
			
				</table>
			
				<%if(isAbhaConsentAppl) { %>
				<table  border='0' cellpadding='3' cellspacing='0' width='100%'>
					<tr>
	                	<td colspan='4' class='COLUMNHEADER'><fmt:message key="eMP.AbhaAudioConsentUpload.label" bundle="${mp_labels}"/></td>
					</tr>
					<tr>
		                <td class="label" width='25%' nowrap><fmt:message key="eMP.EnglishAudioPath.label" bundle="${mp_labels}"/></td>
		                <td class='fields' width='25%'><input type='text' name='englishAudioPath' id='englishAudioPath' maxlength='250' size='75' value="<%=abha_eng_audio_path %>" onkeypress="return CheckForSpecCharsWithSpaceBlur(event)"></td>
		                <td class="label" width='25%' nowrap><fmt:message key="eMP.HindiAudioPath.label" bundle="${mp_labels}"/></td>
		                <td class='fields' width='25%'><input type='text' name='hindiAudioPath' id='hindiAudioPath' maxlength='250' size='75' value="<%=abha_hin_audio_path %>" onkeypress="return CheckForSpecCharsWithSpaceBlur(event)"></td>
	                </tr>
				</table>
				<%} %>
			
		<table  border='0' cellpadding='3' cellspacing='0' width='100%'>
				<tr>
                <td colspan='4' class='COLUMNHEADER'><fmt:message key="eMP.AdditionalFields.label" bundle="${mp_labels}"/></td>
				</tr>
   <table border='0' cellpadding='0' cellspacing='0' width='100%'>
    <tr>
    <td class="BORDER">
    <table border='0' cellpadding='3' cellspacing='0' width='100%'>
        <tr> 
			<td width='25%'>&nbsp;</td>
            <td class='querydata' width='25%'><b><fmt:message key="eMP.Legend.label" bundle="${mp_labels}"/></b></td>
            <td class='labelcenter' width='25%' ><b><fmt:message key="eMP.FieldSize.label" bundle="${mp_labels}"/></b></td>
            <td class='querydata' width='25%' ><b><fmt:message key="Common.Section.label" bundle="${common_labels}"/></b></td>
        </tr>
        <tr>    
            <td class='label' ><fmt:message key="Common.Field.label" bundle="${common_labels}"/>1</td>
            <%    
		String addl_field_disable = "";
                if ( operation.equalsIgnoreCase( "insert" ) ) {
                     out.println("<td class='fields'><input type='text' name='addl_field1_prompt' id='addl_field1_prompt' maxlength='15' size='18' onBlur='enablefld(1);makeValidString(this);' ></td><td class='labelcenter'><input type='text' name='addl_field1_length' id='addl_field1_length' maxlength='2' onkeypress='return allowValidNumber(this,event,2, 0);' size='2'  onBlur='CheckNum(this);checkDecimal(this);checkzero(this);' disabled></td><td class='fields'><select name='addl_field1_section' id='addl_field1_section'   onChange='checkadditionalfield(this,0)' disabled> <option value=''>---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"</option><Option value='D' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")+" </Option><Option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ContactAddresses.label","mp_labels")+"</Option></select></td>");
                }
                else if ( operation.equalsIgnoreCase( "modify" ) ) {
                    if (!addl_field1_prompt.equals("")) addl_field_disable = "disabled";
                    else addl_field_disable ="";
                     out.println("<td class='fields'><input type='text' name='addl_field1_prompt' id='addl_field1_prompt' maxlength='15' size='18' value=\""+addl_field1_prompt+"\" "+addl_field_disable+" onBlur='enablefld(1);makeValidString(this)'></td><td class='labelcenter'><input type='text'  name='addl_field1_length' id='addl_field1_length' maxlength='2' size='2' onBlur='CheckNum(this);checkDecimal(this);checkzero(this);' onkeypress='return allowValidNumber(this,event,2, 0);' value='"+addl_field1_length+"' disabled></td><td class='fields'><select name='addl_field1_section' id='addl_field1_section'  disabled onChange='checkadditionalfield(this,0)'> <option value='' "+sec11+">---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option><Option value='D' "+sec12+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")+"<Option value='C' "+sec13+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ContactAddresses.label","mp_labels")+"</option></select></td>");
					
					if(sec12.equalsIgnoreCase("selected")) {%>
						<script>
							section[0] = 'D';
							document.mp_param_form.section0.value = 'D';
							dcount++
						</script>
<%				}
					if(sec13.equalsIgnoreCase("selected")) {%>
						<script>
							section[0] = 'C';
							document.mp_param_form.section0.value = 'C';
							ccount++;
						</script>
<%				}
				}
%>
        </tr> 
        <tr>    
            <td class='label' ><fmt:message key="Common.Field.label" bundle="${common_labels}"/>2</td>
            <%      
			if ( operation.equalsIgnoreCase( "insert" ) ) {
                     out.println("<td class='fields'><input type='text' name='addl_field2_prompt' id='addl_field2_prompt' maxlength='15' size='18' onBlur='enablefld(2);makeValidString(this)' ></td><td class='labelcenter'><input type='text'  name='addl_field2_length' id='addl_field2_length' maxlength='2' onkeypress='return allowValidNumber(this,event,2, 0);' size='2' onBlur='CheckNum(this);checkDecimal(this);checkzero(this);' disabled></td><td class='fields'><select name='addl_field2_section' id='addl_field2_section'   disabled onChange='checkadditionalfield(this,1)'> <option value=''>---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option><Option value='D' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")+"</Option><Option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ContactAddresses.label","mp_labels")+"</Option></select></td>");
                }
                else if ( operation.equalsIgnoreCase( "modify" ) ) {
                    if (!addl_field2_prompt.equals("")) addl_field_disable = "disabled";
                    else addl_field_disable ="";
                     out.println("<td class='fields'><input type='text' name='addl_field2_prompt' id='addl_field2_prompt' maxlength='15' size='18' value=\""+addl_field2_prompt+"\" "+addl_field_disable+" onBlur='enablefld(2);makeValidString(this)'></td><td class='labelcenter'><input type='text'  name='addl_field2_length' id='addl_field2_length' maxlength='2' size='2' onkeypress='return allowValidNumber(this,event,2, 0);' onBlur='CheckNum(this);checkDecimal(this);checkzero(this);' value='"+addl_field2_length+"' disabled></td><td class='fields'><select name='addl_field2_section' id='addl_field2_section'  disabled onChange='checkadditionalfield(this,1)'><option value='' "+sec21+">---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option><Option value='D' "+sec22+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")+"<Option value='C' "+sec23+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ContactAddresses.label","mp_labels")+"</select></td>");
					
					if(sec22.equalsIgnoreCase("selected")) {%>
						<script>section[1] = 'D';document.mp_param_form.section1.value = 'D';dcount++;</script>
<%				}
					if(sec23.equalsIgnoreCase("selected")) {%>
						<script>section[1] = 'C';document.mp_param_form.section1.value = 'C';ccount++;</script>
<%				}
				}
            %>
        </tr>
        <tr>
            <td class='label' ><fmt:message key="Common.Field.label" bundle="${common_labels}"/>3</td>
            <%
                if ( operation.equalsIgnoreCase( "insert" ) ) {
                     out.println("<td class='fields'><input type='text'  name='addl_field3_prompt' id='addl_field3_prompt' maxlength='15' size='18' onBlur='enablefld(3);makeValidString(this)' ></td><td class='labelcenter'><input type='text'  name='addl_field3_length' id='addl_field3_length' maxlength='2' onkeypress='return allowValidNumber(this,event,2, 0);' size='2' onBlur='CheckNum(this);checkDecimal(this);checkzero(this);' disabled></td><td class='fields'><select name='addl_field3_section' id='addl_field3_section'   disabled onChange='checkadditionalfield(this,2)'> <option value=''>---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option><Option value='D' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")+"</Option><Option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ContactAddresses.label","mp_labels")+"</Option></select></td>");
                }
                else if ( operation.equalsIgnoreCase( "modify" ) ) {
                    if (!addl_field3_prompt.equals("")) addl_field_disable = "disabled";
                    else addl_field_disable ="";
                     out.println("<td class='fields'><input type='text'  name='addl_field3_prompt' id='addl_field3_prompt' maxlength='15' size='18' value=\""+addl_field3_prompt+"\" "+addl_field_disable+" onBlur='enablefld(3);makeValidString(this)'></td><td class='labelcenter'><input type='text'  name='addl_field3_length' id='addl_field3_length' maxlength='2' size='2' onBlur='CheckNum(this);checkDecimal(this);checkzero(this);' onkeypress='return allowValidNumber(this,event,2, 0);' value='"+addl_field3_length+"' disabled></td><td class='fields'><select name='addl_field3_section' id='addl_field3_section'  disabled onChange='checkadditionalfield(this,2)'><option value='' "+sec31+">---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option><Option value='D' "+sec32+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")+"<Option value='C' "+sec33+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ContactAddresses.label","mp_labels")+"</select></td>");
					
					if(sec32.equalsIgnoreCase("selected")) {%>
						<script>section[2] = 'D';document.mp_param_form.section2.value = 'D';dcount++;</script>
<%				}
					if(sec33.equalsIgnoreCase("selected")) {%>
						<script>section[2] = 'C';document.mp_param_form.section2.value = 'C';ccount++;</script>
<%				}
				 }
            %>
        </tr> 
        <tr>    
            <td class='label' ><fmt:message key="Common.Field.label" bundle="${common_labels}"/>4</td>
            <%
                if ( operation.equalsIgnoreCase( "insert" ) ) {
                     out.println("<td class='fields'><input type='text'  name='addl_field4_prompt' id='addl_field4_prompt' maxlength='15' size='18' onBlur='enablefld(4);makeValidString(this)' ></td><td class='labelcenter'><input type='text'  name='addl_field4_length' id='addl_field4_length' maxlength='2' size='2' onkeypress='return allowValidNumber(this,event,2, 0);' onBlur='CheckNum(this);checkDecimal(this);checkzero(this);' disabled></td><td class='fields'><select name='addl_field4_section' id='addl_field4_section'   disabled onChange='checkadditionalfield(this,3)'> <option value=''>---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option><Option value='D' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")+"</Option><Option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ContactAddresses.label","mp_labels")+"</Option></select></td>");
                }
                else if ( operation.equalsIgnoreCase( "modify" ) ) {
                    if (!addl_field4_prompt.equals("")) addl_field_disable = "disabled";
                    else addl_field_disable ="";
                     out.println("<td class='fields'><input type='text'  name='addl_field4_prompt' id='addl_field4_prompt' maxlength='15' size='18' value=\""+addl_field4_prompt+"\" "+addl_field_disable+" onBlur='enablefld(4);makeValidString(this)'></td><td class='labelcenter'><input type='text'  name='addl_field4_length' id='addl_field4_length' maxlength='2' size='2' onBlur='CheckNum(this);checkDecimal(this);checkzero(this);' onkeypress='return allowValidNumber(this,event,2, 0);' value='"+addl_field4_length+"' disabled></td><td class='fields'><select name='addl_field4_section' id='addl_field4_section'  disabled onChange='checkadditionalfield(this,3)'><option value='' "+sec41+">---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option><Option value='D' "+sec42+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")+"<Option value='C' "+sec43+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ContactAddresses.label","mp_labels")+"</select></td>");
					
					if(sec42.equalsIgnoreCase("selected")) {%>
						<script>section[3] = 'D';document.mp_param_form.section3.value = 'D';dcount++;</script>
<%				}
					if(sec43.equalsIgnoreCase("selected")) {%>
						<script>section[3] = 'C';document.mp_param_form.section3.value = 'C';ccount++;</script>
<%				}
                }
            %>
        </tr> 
        <tr>    
            <td class='label' ><fmt:message key="Common.Field.label" bundle="${common_labels}"/>5</td>
            <%
                if ( operation.equalsIgnoreCase( "insert" ) ) {
                     out.println("<td class='fields'><input type='text'  name='addl_field5_prompt' id='addl_field5_prompt' maxlength='15' size='18' onBlur='enablefld(5);makeValidString(this)'></td><td class='labelcenter'><input type='text'  name='addl_field5_length' id='addl_field5_length' maxlength='2' size='2' onkeypress='return allowValidNumber(this,event,2, 0);' onBlur='CheckNum(this);checkDecimal(this);checkzero(this);' disabled></td><td class='fields'><select name='addl_field5_section' id='addl_field5_section' onblur='tabs_alignment(2)'   disabled onChange='checkadditionalfield(this,4)'> <option value=''>---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option><Option value='D' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")+"</Option><Option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ContactAddresses.label","mp_labels")+"</Option></select></td>");
                }
                else if ( operation.equalsIgnoreCase( "modify" ) ) {
                    if (!addl_field5_prompt.equals("")) addl_field_disable = "disabled"; 
                    else addl_field_disable ="";
                     out.println("<td class='fields'><input type='text'  name='addl_field5_prompt' id='addl_field5_prompt' maxlength='15' size='18' value=\""+addl_field5_prompt+"\" "+addl_field_disable+" onBlur='enablefld(5);makeValidString(this)'></td><td class='labelcenter'><input type='text'  name='addl_field5_length' id='addl_field5_length' maxlength='2' size='2' onBlur='CheckNum(this);checkDecimal(this);checkzero(this);' onkeypress='return allowValidNumber(this,event,2, 0);' value='"+addl_field5_length+"' disabled></td><td class='fields'><select name='addl_field5_section' id='addl_field5_section'  onblur='tabs_alignment(2)' disabled onChange='checkadditionalfield(this,4)'><option value='' "+sec51+">---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option><Option value='D' "+sec52+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")+"<Option value='C' "+sec53+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ContactAddresses.label","mp_labels")+"</select></td>");
					
					if(sec52.equalsIgnoreCase("selected")) {%>
						<script>section[4] = 'D';document.mp_param_form.section4.value = 'D';dcount++;</script>
<%				}
					if(sec53.equalsIgnoreCase("selected")) {%>
						<script>section[4] = 'C';document.mp_param_form.section4.value = 'C';ccount++;</script>
<%				}
                }
            %>
        </tr> 
    <tr>
    <td colspan=4>&nbsp;</td>
    </tr>
    </table>
	 </td>
    </tr>
    </table>
		</table>
		
<% 	
		if("Y".equalsIgnoreCase(aadhaarProfileYN))
		{ 
			 String aadhaar_config_enabled_checked = "";
			 String aadhaar_option_disabled = "disabled";
			 String aadhaar_option1_checked = "";
			 String aadhaar_option2_checked = "";
			 String aadhaar_option3_checked = "";
			 if("Y".equalsIgnoreCase(aadhaar_config_enabled_yn))
			 {
				 aadhaar_config_enabled_checked = "checked";
				 aadhaar_option_disabled = "";
			 }
			 else
			 {
				 aadhaar_config_enabled_checked = "";
				 aadhaar_option_disabled = "disabled";
			 }
			 if("0".equalsIgnoreCase(aadhaar_option_value))
			 {
				 aadhaar_option1_checked = "checked";
				 aadhaar_option2_checked = "";
				 aadhaar_option3_checked = "";
			 }
			 else if("1".equalsIgnoreCase(aadhaar_option_value))
			 {
				 aadhaar_option2_checked = "checked";
				 aadhaar_option1_checked = "";
				 aadhaar_option3_checked = "";
			 }
			 else if("2".equalsIgnoreCase(aadhaar_option_value))
			 {
				 aadhaar_option3_checked = "checked";
				 aadhaar_option2_checked = "";
				 aadhaar_option1_checked = "";
			 }
		%>
		<div id="AADHAAR" style = 'display:none'>
			<table cellspacing='0' cellpadding='0' width='100%' border=0>
				<tr>
					<td width= "100%" class="white">
						<ul id="tablist" class="tablist" >
						 <li class="tablistitem" title='<fmt:message key="Common.PatientAdministration.label" bundle="${common_labels}"/>'>
							<a class="tabClicked" id="pat_number_tab" >
								<span class="tabSpanclicked" id="pat_number_tabspan" onClick='javascript:expandCollapse("pat_admin_tab")'><fmt:message key="Common.PatientAdministration.label" bundle="${common_labels}"/></span>
							</a>
						</li>		
						<li class="tablistitem" title='<fmt:message key="eMP.LegalNames.label" bundle="${mp_labels}"/>'>
							<a class="tabA" id="legal_names_tab" >
								<span class="tabAspan" id="legal_names_tabspan" onClick='javascript:expandCollapse("legal_names_tab")'><fmt:message key="eMP.LegalNames.label" bundle="${mp_labels}"/></span>
							</a>
						</li>	
						<li class="tablistitem" title='<fmt:message key="eMP.AlternateIDChecks.label" bundle="${mp_labels}"/> '>
							<a class="tabA" id="alt_id_chk_tab" >
								<span class="tabAspan" id="alt_id_chk_tabspan" onClick='javascript:expandCollapse("alt_id_chk_tab")'><fmt:message key="eMP.AlternateIDChecks.label" bundle="${mp_labels}"/></span>
							</a>
						</li>	
						<li class="tablistitem" title='<fmt:message key="eMP.NewBorn.label" bundle="${mp_labels}"/>'>
							<a class="tabA" id="new_born_tab" >
								<span class="tabAspan" id="new_born_tabspan" onClick='javascript:expandCollapse("new_born_tab")'><fmt:message key="eMP.NewBorn.label" bundle="${mp_labels}"/></span>
							</a>
						</li>	
						<li class="tablistitem" title='<fmt:message key="Common.others.label" bundle="${common_labels}"/>'>
							<a class="tabA" id="others_tab" >
								<span class="tabAspan" id="others_tabspan" onClick='javascript:expandCollapse("others_tab")'><fmt:message key="Common.others.label" bundle="${common_labels}"/></span>
						</a>
						</li>				
						<li class="tablistitem" title='Aadhaar Function Configuration'>
							<a class="tabA" id="aadhar_tab" >
								<span class="tabAspan" id="aadhar_tabspan" onClick='javascript:expandCollapse("aadhar_tab")'><fmt:message key="eXH.AADHAAR.label" bundle="${xh_labels}"/> </span>
						</a>
						</li>				
						</ul>
					</td>
				</tr>
			</table>
			<table width="100%" cellPadding="1" noWrap="nowrap" bgcolor="#000000">
				<tr>
					<td class="COLUMNHEADER" rowSpan="1" colSpan="2"> <fmt:message key="eXH.AADHAARconfiguration.label" bundle="${xh_labels}"/> </td>
				</tr>
				<tr>
					<td class="label" align="right" width="20%">
						<fmt:message key="eXH.EnableAadhaarConfig.label" bundle="${xh_labels}"/>
					</td>
					<td class="fields"  align="left" width="80%">
					<input type='checkbox' name='aadhar_config_enabled_yn' id='aadhar_config_enabled_yn' value='Y' <%=aadhaar_config_enabled_checked %>  onClick="aadharConfig(this)">
					</td>
				</tr>
				<tr>
					<td class="label" align="right" width="20%"> Aadhaar Function Behaviour</td>
					<td class="fields"  align="left" width="80%">
					<input type="radio" name="aadhar_option_value" id="aadhar_option_value" id="aadhar_option_value" value="0" <%=aadhaar_option1_checked %> <%=aadhaar_option_disabled %>> <fmt:message key="eXH.LaunchAadhaarConfig.label" bundle="${xh_labels}"/> <br>
					</td>
				</tr>
				<tr>
					<td class="label" align="right" width="20%"> </td>
					<td class="fields"  align="left" width="80%">
					<input type="radio" name="aadhar_option_value" id="aadhar_option_value" id="aadhar_option_value" value="1" <%=aadhaar_option2_checked %> <%=aadhaar_option_disabled %> > <fmt:message key="eXH.ReplaceWithAadhaarDetails.label" bundle="${xh_labels}"/> <br>
					</td>
				</tr>
				<tr>
					<td class="label" align="right" width="20%"> </td>
					<td class="fields"  align="left" width="80%">
					<input type="radio" name="aadhar_option_value" id="aadhar_option_value" id="aadhar_option_value" value="2" <%=aadhaar_option3_checked %> <%=aadhaar_option_disabled %> > <fmt:message key="eXH.ValidateAadhaarDetails.label" bundle="${xh_labels}"/> <br>
					</td>
				</tr>
			</table>
		</div>
	<% 
		} 
	%>
<%
    if(pstmt != null ) pstmt.close() ;
	if(rs!= null ) rs.close() ;
	}
	catch( Exception ce ) {ce.printStackTrace();}
    finally
    {
        
        if(con != null) ConnectionManager.returnConnection(con,request);
    }
%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}

%>   

