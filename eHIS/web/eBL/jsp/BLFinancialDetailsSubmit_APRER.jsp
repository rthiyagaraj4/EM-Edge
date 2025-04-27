<!DOCTYPE html>
<%@  page import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>

<script>
	function test()
	{		
		document.forms[0].rtn_blng_grp.value=parent.frames[0].document.forms[0].rtn_blng_grp.value;
		document.forms[0].rtn_slmt_ind.value=parent.frames[0].document.forms[0].rtn_slmt_ind.value;
		document.forms[0].rtn_credit_doc_reqd_yn.value=parent.frames[0].document.forms[0].rtn_credit_doc_reqd_yn.value;
		document.forms[0].rtn_blng_class.value=parent.frames[0].document.forms[0].rtn_blng_class.value;
		document.forms[0].rtn_emp_code.value=parent.frames[0].document.forms[0].rtn_emp_code.value;
		document.forms[0].rtn_slmt_type_code.value=parent.frames[0].document.forms[0].rtn_slmt_type_code.value;
		document.forms[0].rtn_inst_ref.value=parent.frames[0].document.forms[0].rtn_inst_ref.value;
		document.forms[0].rtn_inst_date.value=parent.frames[0].document.forms[0].rtn_inst_date.value;
		document.forms[0].rtn_inst_remarks.value=parent.frames[0].document.forms[0].rtn_inst_remarks.value;
		document.forms[0].rtn_credit_cust_group_code.value=parent.frames[0].document.forms[0].rtn_credit_cust_group_code.value;
		document.forms[0].rtn_credit_cust_code.value=parent.frames[0].document.forms[0].rtn_credit_cust_code.value;
		document.forms[0].rtn_credit_doc_ref.value=parent.frames[0].document.forms[0].rtn_credit_doc_ref.value;
		document.forms[0].rtn_credit_doc_start_date.value=parent.frames[0].document.forms[0].rtn_credit_doc_start_date.value;
		document.forms[0].rtn_credit_doc_end_date.value=parent.frames[0].document.forms[0].rtn_credit_doc_end_date.value;
		document.forms[0].rtn_sponsor_cust_group_code.value=parent.frames[0].document.forms[0].rtn_sponsor_cust_group_code.value;		
		document.forms[0].rtn_sponsor_cust_code.value=parent.frames[0].document.forms[0].rtn_sponsor_cust_code.value;
		document.forms[0].rtn_sponsor_credit_doc_ref.value=parent.frames[0].document.forms[0].rtn_sponsor_credit_doc_ref.value;
		document.forms[0].rtn_sponsor_credit_doc_start_date.value=parent.frames[0].document.forms[0].rtn_sponsor_credit_doc_start_date.value;
		document.forms[0].rtn_sponsor_credit_doc_end_date.value=parent.frames[0].document.forms[0].rtn_sponsor_credit_doc_end_date.value;

		document.forms[0].rtn_ins_blng_grp.value=parent.frames[0].document.forms[0].rtn_ins_blng_grp.value;
		document.forms[0].rtn_ins_cust_group_code.value=parent.frames[0].document.forms[0].rtn_ins_cust_group_code.value;
		document.forms[0].rtn_ins_cust_code.value=parent.frames[0].document.forms[0].rtn_ins_cust_code.value;
		document.forms[0].rtn_ins_cust_priority.value=parent.frames[0].document.forms[0].rtn_ins_cust_priority.value;
		document.forms[0].rtn_ins_policy_type_code.value=parent.frames[0].document.forms[0].rtn_ins_policy_type_code.value;
		document.forms[0].rtn_ins_policy_no.value=parent.frames[0].document.forms[0].rtn_ins_policy_no.value;
		document.forms[0].rtn_ins_policy_start_date.value=parent.frames[0].document.forms[0].rtn_ins_policy_start_date.value;
		document.forms[0].rtn_ins_policy_expiry_date.value=parent.frames[0].document.forms[0].rtn_ins_policy_expiry_date.value;
		document.forms[0].rtn_ins_credit_auth_ref.value=parent.frames[0].document.forms[0].rtn_ins_credit_auth_ref.value;
		document.forms[0].rtn_ins_credit_auth_date.value=parent.frames[0].document.forms[0].rtn_ins_credit_auth_date.value;
		document.forms[0].rtn_ins_cred_auth_req_yn.value=parent.frames[0].document.forms[0].rtn_ins_cred_auth_req_yn.value;
		document.forms[0].rtn_ins_cred_auth_mand_capt_yn.value=parent.frames[0].document.forms[0].rtn_ins_cred_auth_mand_capt_yn.value;	document.forms[0].rtn_ins_dflt_auth_ref_as_pol_no_yn.value=parent.frames[0].document.forms[0].rtn_ins_dflt_auth_ref_as_pol_no_yn.value;

		document.forms[0].rtn_ins_credit_approval_days.value=parent.frames[0].document.forms[0].rtn_ins_credit_approval_days.value;
		document.forms[0].rtn_ins_credit_approval_amount.value=parent.frames[0].document.forms[0].rtn_ins_credit_approval_amount.value;
		document.forms[0].rtn_ins_policy_eff_from_date.value=parent.frames[0].document.forms[0].rtn_ins_policy_eff_from_date.value;
		document.forms[0].rtn_ins_policy_eff_to_date.value=parent.frames[0].document.forms[0].rtn_ins_policy_eff_to_date.value;
		document.forms[0].rtn_ins_adj_rule_ind.value=parent.frames[0].document.forms[0].rtn_ins_adj_rule_ind.value;
		document.forms[0].rtn_ins_adj_perc_amt_ind.value=parent.frames[0].document.forms[0].rtn_ins_adj_perc_amt_ind.value;
		document.forms[0].rtn_ins_adj_perc_amt_value.value=parent.frames[0].document.forms[0].rtn_ins_adj_perc_amt_value.value;
		document.forms[0].rtn_ins_pmnt_diff_adj_int.value=parent.frames[0].document.forms[0].rtn_ins_pmnt_diff_adj_int.value;
		document.forms[0].rtn_ins_drg_pmnt_diff_adj_int.value=parent.frames[0].document.forms[0].rtn_ins_drg_pmnt_diff_adj_int.value;
		document.forms[0].rtn_ins_spl_srv_pmnt_diff_adj_int.value=parent.frames[0].document.forms[0].rtn_ins_spl_srv_pmnt_diff_adj_int.value;
		document.forms[0].rtn_non_ins_blng_grp.value=parent.frames[0].document.forms[0].rtn_non_ins_blng_grp.value;
		document.forms[0].rtn_non_ins_credit_doc_reqd_yn.value=parent.frames[0].document.forms[0].rtn_non_ins_credit_doc_reqd_yn.value;
		document.forms[0].rtn_non_ins_slmt_type_code.value=parent.frames[0].document.forms[0].rtn_non_ins_slmt_type_code.value;
		document.forms[0].rtn_non_ins_inst_ref.value=parent.frames[0].document.forms[0].rtn_non_ins_inst_ref.value;
		document.forms[0].rtn_non_ins_inst_date.value=parent.frames[0].document.forms[0].rtn_non_ins_inst_date.value;
		document.forms[0].rtn_non_ins_inst_remarks.value=parent.frames[0].document.forms[0].rtn_non_ins_inst_remarks.value;
		document.forms[0].rtn_non_ins_cust_group_code.value=parent.frames[0].document.forms[0].rtn_non_ins_cust_group_code.value;
		document.forms[0].rtn_non_ins_cust_code.value=parent.frames[0].document.forms[0].rtn_non_ins_cust_code.value;
		document.forms[0].rtn_non_ins_credit_doc_ref.value=parent.frames[0].document.forms[0].rtn_non_ins_credit_doc_ref.value;
		document.forms[0].rtn_non_ins_credit_doc_start_date.value=parent.frames[0].document.forms[0].rtn_non_ins_credit_doc_start_date.value;
		document.forms[0].rtn_non_ins_credit_doc_end_date.value=parent.frames[0].document.forms[0].rtn_non_ins_credit_doc_end_date.value;
		document.forms[0].rtn_annual_income.value=parent.frames[0].document.forms[0].rtn_annual_income.value;
		document.forms[0].rtn_family_asset.value=parent.frames[0].document.forms[0].rtn_family_asset.value;
		document.forms[0].rtn_no_of_dependants.value=parent.frames[0].document.forms[0].rtn_no_of_dependants.value;
		document.forms[0].rtn_resp_for_payment.value=parent.frames[0].document.forms[0].rtn_resp_for_payment.value;
		document.forms[0].rtn_pat_reln_with_resp_person.value=parent.frames[0].document.forms[0].rtn_pat_reln_with_resp_person.value;
		document.forms[0].rtn_fin_remarks.value=parent.frames[0].document.forms[0].rtn_fin_remarks.value;
		document.forms[0].rtn_gl_holder_name.value=parent.frames[0].document.forms[0].rtn_gl_holder_name.value;
		document.forms[0].rtn_pat_reln_with_gl_holder.value=parent.frames[0].document.forms[0].rtn_pat_reln_with_gl_holder.value;
		document.forms[0].rtn_upd_patient_fin_dtls_yn.value=parent.frames[0].document.forms[0].rtn_upd_patient_fin_dtls_yn.value;
		document.forms[0].rtn_spl_clinic_rel_enc_YN.value=parent.frames[0].document.forms[0].rtn_spl_clinic_rel_enc_YN.value;
		document.forms[0].rtn_user_id.value=parent.frames[0].document.forms[0].rtn_user_id.value;
		document.forms[0].rtn_fin_auth_user_id.value=parent.frames[0].document.forms[0].rtn_fin_auth_user_id.value;
		document.forms[0].rtn_calling_function_id.value=parent.frames[0].document.forms[0].rtn_calling_function_id.value;
		document.forms[0].rtn_total_records.value=parent.frames[0].document.forms[0].rtn_total_records.value;
		document.forms[0].rtn_ins_restrict_check.value=parent.frames[0].document.forms[0].rtn_ins_restrict_check.value; 
		document.forms[0].rtn_ins_apprd_amt_restrict_check.value=parent.frames[0].document.forms[0].rtn_ins_apprd_amt_restrict_check.value;

		document.forms[0].rtn_ins_apprd_days_restrict_check.value=parent.frames[0].document.forms[0].rtn_ins_apprd_days_restrict_check.value;

		
		document.forms[0].rtn_ref_src_main_code.value=parent.frames[0].document.forms[0].rtn_ref_src_main_code.value;
		document.forms[0].rtn_ref_src_main_desc.value=parent.frames[0].document.forms[0].rtn_ref_src_main_desc.value;
		document.forms[0].rtn_ref_src_sub_code.value=parent.frames[0].document.forms[0].rtn_ref_src_sub_code.value;
		document.forms[0].rtn_ref_src_sub_desc.value=parent.frames[0].document.forms[0].rtn_ref_src_sub_desc.value;

		document.forms[0].rtn_ins_ref_src_main_code.value=parent.frames[0].document.forms[0].rtn_ins_ref_src_main_code.value;
		document.forms[0].rtn_ins_ref_src_main_desc.value=parent.frames[0].document.forms[0].rtn_ins_ref_src_main_desc.value;
		document.forms[0].rtn_ins_ref_src_sub_code.value=parent.frames[0].document.forms[0].rtn_ins_ref_src_sub_code.value;
		document.forms[0].rtn_ins_ref_src_sub_desc.value=parent.frames[0].document.forms[0].rtn_ins_ref_src_sub_desc.value;

		document.forms[0].rtn_non_ins_ref_src_main_code.value=parent.frames[0].document.forms[0].rtn_non_ins_ref_src_main_code.value;
		document.forms[0].rtn_non_ins_ref_src_main_desc.value=parent.frames[0].document.forms[0].rtn_non_ins_ref_src_main_desc.value;
		document.forms[0].rtn_non_ins_ref_src_sub_code.value=parent.frames[0].document.forms[0].rtn_non_ins_ref_src_sub_code.value;
		document.forms[0].rtn_non_ins_ref_src_sub_desc.value=parent.frames[0].document.forms[0].rtn_non_ins_ref_src_sub_desc.value;

		document.forms[0].rtn_tot_valid_enc_with_gl.value=parent.frames[0].document.forms[0].rtn_tot_valid_enc_with_gl.value;
		document.forms[0].rtn_tot_valid_op_enc_with_gl.value=parent.frames[0].document.forms[0].rtn_tot_valid_op_enc_with_gl.value;
		document.forms[0].rtn_tot_valid_ae_enc_with_gl.value=parent.frames[0].document.forms[0].rtn_tot_valid_ae_enc_with_gl.value;
		document.forms[0].rtn_tot_valid_ip_enc_with_gl.value=parent.frames[0].document.forms[0].rtn_tot_valid_ip_enc_with_gl.value;
		document.forms[0].rtn_tot_valid_dc_enc_with_gl.value=parent.frames[0].document.forms[0].rtn_tot_valid_dc_enc_with_gl.value;

		document.forms[0].rtn_tot_availed_enc_with_gl.value=parent.frames[0].document.forms[0].rtn_tot_availed_enc_with_gl.value;
		document.forms[0].rtn_tot_availed_op_enc_with_gl.value=parent.frames[0].document.forms[0].rtn_tot_availed_op_enc_with_gl.value;
		document.forms[0].rtn_tot_availed_ae_enc_with_gl.value=parent.frames[0].document.forms[0].rtn_tot_availed_ae_enc_with_gl.value;
		document.forms[0].rtn_tot_availed_ip_enc_with_gl.value=parent.frames[0].document.forms[0].rtn_tot_availed_ip_enc_with_gl.value;
		document.forms[0].rtn_tot_availed_dc_enc_with_gl.value=parent.frames[0].document.forms[0].rtn_tot_availed_dc_enc_with_gl.value;

		document.forms[0].rtn_gl_doc_ref_exist_YN.value=parent.frames[0].document.forms[0].rtn_gl_doc_ref_exist_YN.value;		
		document.forms[0].rtn_pat_ser_code.value=parent.frames[0].document.forms[0].rtn_pat_ser_code.value;		
//Added for Classification Valued Capturing Purpose 
		document.forms[0].rtn_class_type.value = parent.frames[0].document.forms[0].rtn_class_type.value;
		document.forms[0].rtn_class_code.value = parent.frames[0].document.forms[0].rtn_class_code.value;
		document.forms[0].rtn_remarks.value = parent.frames[0].document.forms[0].rtn_remarks.value;
		document.forms[0].rtn_social_pensioner_id.value = parent.frames[0].document.forms[0].rtn_social_pensioner_id.value;
		document.forms[0].rtn_inc_asset_ind.value = parent.frames[0].document.forms[0].rtn_inc_asset_ind.value;
		document.forms[0].rtn_ind_inc.value = parent.frames[0].document.forms[0].rtn_ind_inc.value;
		document.forms[0].rtn_ind_inc_freq.value = parent.frames[0].document.forms[0].rtn_ind_inc_freq.value;
		document.forms[0].rtn_spouse_inc.value = parent.frames[0].document.forms[0].rtn_spouse_inc.value;
		document.forms[0].rtn_spouse_inc_freq.value = parent.frames[0].document.forms[0].rtn_spouse_inc_freq.value;
		document.forms[0].rtn_dependent_inc.value = parent.frames[0].document.forms[0].rtn_dependent_inc.value;
		document.forms[0].rtn_dependent_inc_freq.value = parent.frames[0].document.forms[0].rtn_dependent_inc_freq.value;
		document.forms[0].rtn_valid_from.value = parent.frames[0].document.forms[0].rtn_valid_from.value;
		document.forms[0].rtn_valid_to.value = parent.frames[0].document.forms[0].rtn_valid_to.value;
		document.forms[0].rtn_last_date.value = parent.frames[0].document.forms[0].rtn_last_date.value;
//--------------------------------------------------------------- 
	
		document.forms[0].encounter_date_time.value=parent.frames[0].document.forms[0].encounter_date_time.value;
		//Added by Rajesh V for CRF - 155
		/*var payerGrpBySetup = parent.frames[0].document.forms[0].payerGrpBySetup.value;
		if(payerGrpBySetup == 'Y'){
			var chkBlngClass = document.forms[0].rtn_ins_blng_grp.value;
			var chkCustGrp = document.forms[0].rtn_ins_cust_group_code.value;
			var chkPatClass = parent.frames[0].document.forms[0].calling_module_id.value;
			//alert(chkPatClass)
			if(chkPatClass == "MP" || chkPatClass == ""){
				chkPatClass="XT";
			}
			else if(chkPatClass == "EM" || chkPatClass == "AE"){ 
				chkPatClass="EM";
			}
			else if(chkPatClass == "OP"){
				chkPatClass="OP";
				}
			else if(chkPatClass == "IP"){
				chkPatClass="IP";
			}
			else if(chkPatClass == "DC"){
				chkPatClass="DC";
			}
			
			if(chkBlngClass.length>0 && chkCustGrp.length>0){
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				var param="func_mode=prevEncounterCheck&blngClass="+chkBlngClass+"&custGrp="+chkCustGrp+"&patClass="+chkPatClass;
				//var param="func_mode=get_Card_Details&card_id="+retVal[0];
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","../../eBL/jsp/EncounterCommonValidation.jsp?"+param,false);
				xmlHttp.send(xmlDoc);
				var responseText=trimString(xmlHttp.responseText);	
				if(responseText == 'Y'){
					alert('Customer Group is not valid for the Selected Billing Group');
					return false;
				}
			}
		}*/
		//Added by Rajesh V for CRF - 155
		
		/* Karthik added the below Function to Authenticate User to check his permissions to add listed Payers - Starts 
		var slmtInd=document.forms[0].rtn_slmt_ind.value;
		if(slmtInd=='X'){
		var payerCode = document.forms[0].rtn_ins_cust_group_code.value;
		var payer = document.forms[0].rtn_ins_cust_code.value;
		var policy = document.forms[0].rtn_ins_policy_type_code.value;
		var blngClass = document.forms[0].rtn_blng_class.value;
			if(validateAllPayers(payerCode,payer,policy,blngClass)==false){
				alert("User dont have Permission to add listed Payer");
				return false;
			}
		}
		Karthik added the below Function to Authenticate User to check his permissions to add listed Payers - Ends */
			
		document.forms[0].action="../../servlet/eBL.BLFinancialDetailsServlet";
		document.forms[0].submit();
	}

	function trimString(sInString) {
		  return sInString.replace(/^\s+|\s+$/g,"");
	}

</script>
<%
		String locale=(String)session.getAttribute("LOCALE");
%>

<html>
<head>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eBL/js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body onLoad="test()"  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='BLFinDetSubForm' id='BLFinDetSubForm' method='post' >

<input type='hidden' name='rtn_blng_grp' id='rtn_blng_grp' value=''>
<input type='hidden' name='rtn_slmt_ind' id='rtn_slmt_ind' value=''>
<input type='hidden' name='rtn_credit_doc_reqd_yn' id='rtn_credit_doc_reqd_yn' value=''>
<input type='hidden' name='rtn_blng_class' id='rtn_blng_class' value=''>
<input type='hidden' name='rtn_emp_code' id='rtn_emp_code' value=''>
<input type='hidden' name='rtn_slmt_type_code' id='rtn_slmt_type_code' value=''>
<input type='hidden' name='rtn_inst_ref' id='rtn_inst_ref' value=''>
<input type='hidden' name='rtn_inst_date' id='rtn_inst_date' value=''>
<input type='hidden' name='rtn_inst_remarks' id='rtn_inst_remarks' value=''>
<input type='hidden' name='rtn_credit_cust_group_code' id='rtn_credit_cust_group_code' value="">
<input type='hidden' name='rtn_credit_cust_code' id='rtn_credit_cust_code' value=''>
<input type='hidden' name='rtn_credit_doc_ref' id='rtn_credit_doc_ref' value=''>
<input type='hidden' name='rtn_credit_doc_start_date' id='rtn_credit_doc_start_date' value=''>
<input type='hidden' name='rtn_credit_doc_end_date' id='rtn_credit_doc_end_date' value=''>
<input type='hidden' name='rtn_sponsor_cust_group_code' id='rtn_sponsor_cust_group_code' value="">
<input type='hidden' name='rtn_sponsor_cust_code' id='rtn_sponsor_cust_code' value=''>
<input type='hidden' name='rtn_sponsor_credit_doc_ref' id='rtn_sponsor_credit_doc_ref' value=''>
<input type='hidden' name='rtn_sponsor_credit_doc_start_date' id='rtn_sponsor_credit_doc_start_date' value=''>
<input type='hidden' name='rtn_sponsor_credit_doc_end_date' id='rtn_sponsor_credit_doc_end_date' value=''>
<input type='hidden' name='rtn_ins_blng_grp' id='rtn_ins_blng_grp' value=''>
<input type='hidden' name='rtn_ins_cust_group_code' id='rtn_ins_cust_group_code' value="">
<input type='hidden' name='rtn_ins_cust_code' id='rtn_ins_cust_code' value=''>
<input type='hidden' name='rtn_ins_cust_priority' id='rtn_ins_cust_priority' value=''>
<input type='hidden' name='rtn_ins_policy_type_code' id='rtn_ins_policy_type_code' value=''>
<input type='hidden' name='rtn_ins_policy_no' id='rtn_ins_policy_no' value=''>
<input type='hidden' name='rtn_ins_policy_start_date' id='rtn_ins_policy_start_date' value=''>
<input type='hidden' name='rtn_ins_policy_expiry_date' id='rtn_ins_policy_expiry_date' value=''>
<input type='hidden' name='rtn_ins_credit_auth_ref' id='rtn_ins_credit_auth_ref' value=''>
<input type='hidden' name='rtn_ins_credit_auth_date' id='rtn_ins_credit_auth_date' value=''>
<input type='hidden' name='rtn_ins_cred_auth_req_yn' id='rtn_ins_cred_auth_req_yn' value="">
<input type='hidden' name='rtn_ins_cred_auth_mand_capt_yn' id='rtn_ins_cred_auth_mand_capt_yn' value="">
<input type='hidden' name='rtn_ins_dflt_auth_ref_as_pol_no_yn' id='rtn_ins_dflt_auth_ref_as_pol_no_yn' value="">
<input type='hidden' name='rtn_ins_credit_approval_days' id='rtn_ins_credit_approval_days' value=''>
<input type='hidden' name='rtn_ins_credit_approval_amount' id='rtn_ins_credit_approval_amount' value=''>
<input type='hidden' name='rtn_ins_policy_eff_from_date' id='rtn_ins_policy_eff_from_date' value=''>
<input type='hidden' name='rtn_ins_policy_eff_to_date' id='rtn_ins_policy_eff_to_date' value=''>
<input type='hidden' name='rtn_ins_adj_rule_ind' id='rtn_ins_adj_rule_ind' value=''>
<input type='hidden' name='rtn_ins_adj_perc_amt_ind' id='rtn_ins_adj_perc_amt_ind' value=''>
<input type='hidden' name='rtn_ins_adj_perc_amt_value' id='rtn_ins_adj_perc_amt_value' value=''>
<input type='hidden' name='rtn_ins_pmnt_diff_adj_int' id='rtn_ins_pmnt_diff_adj_int' value=''>
<input type='hidden' name='rtn_ins_drg_pmnt_diff_adj_int' id='rtn_ins_drg_pmnt_diff_adj_int' value=''>
<input type='hidden' name='rtn_ins_spl_srv_pmnt_diff_adj_int' id='rtn_ins_spl_srv_pmnt_diff_adj_int' value=''>
<input type='hidden' name='rtn_non_ins_blng_grp' id='rtn_non_ins_blng_grp' value=''>
<input type='hidden' name='rtn_non_ins_credit_doc_reqd_yn' id='rtn_non_ins_credit_doc_reqd_yn' value=''>
<input type='hidden' name='rtn_non_ins_slmt_type_code' id='rtn_non_ins_slmt_type_code' value=''>
<input type='hidden' name='rtn_non_ins_inst_ref' id='rtn_non_ins_inst_ref' value=''>
<input type='hidden' name='rtn_non_ins_inst_date' id='rtn_non_ins_inst_date' value=''>
<input type='hidden' name='rtn_non_ins_inst_remarks' id='rtn_non_ins_inst_remarks' value=''>
<input type='hidden' name='rtn_non_ins_cust_group_code' id='rtn_non_ins_cust_group_code' value="">
<input type='hidden' name='rtn_non_ins_cust_code' id='rtn_non_ins_cust_code' value=''>
<input type='hidden' name='rtn_non_ins_credit_doc_ref' id='rtn_non_ins_credit_doc_ref' value=''>
<input type='hidden' name='rtn_non_ins_credit_doc_start_date' id='rtn_non_ins_credit_doc_start_date' value=''>
<input type='hidden' name='rtn_non_ins_credit_doc_end_date' id='rtn_non_ins_credit_doc_end_date' value=''>
<input type='hidden' name='rtn_annual_income' id='rtn_annual_income' value=''>
<input type='hidden' name='rtn_family_asset' id='rtn_family_asset' value=''>
<input type='hidden' name='rtn_no_of_dependants' id='rtn_no_of_dependants' value=''>
<input type='hidden' name='rtn_resp_for_payment' id='rtn_resp_for_payment' value=''>
<input type='hidden' name='rtn_pat_reln_with_resp_person' id='rtn_pat_reln_with_resp_person' value=''>
<input type='hidden' name='rtn_fin_remarks' id='rtn_fin_remarks' value=''>
<input type='hidden' name='rtn_gl_holder_name' id='rtn_gl_holder_name' value=''>
<input type='hidden' name='rtn_pat_reln_with_gl_holder' id='rtn_pat_reln_with_gl_holder' value=''>
<input type='hidden' name='rtn_upd_patient_fin_dtls_yn' id='rtn_upd_patient_fin_dtls_yn' value=''>
<input type='hidden' name='rtn_spl_clinic_rel_enc_YN' id='rtn_spl_clinic_rel_enc_YN' value=''>
<input type='hidden' name='rtn_user_id' id='rtn_user_id' value=''>
<input type='hidden' name='rtn_fin_auth_user_id' id='rtn_fin_auth_user_id' value=''>
<input type='hidden' name='rtn_calling_function_id' id='rtn_calling_function_id' value=''>
<input type='hidden' name='rtn_total_records' id='rtn_total_records' value=''>
<input type='hidden' name='rtn_ins_restrict_check' id='rtn_ins_restrict_check' value=''>
<input type='hidden' name='rtn_ins_apprd_amt_restrict_check' id='rtn_ins_apprd_amt_restrict_check' value="">
<input type='hidden' name='rtn_ins_apprd_days_restrict_check' id='rtn_ins_apprd_days_restrict_check' value="">
<input type='hidden' name='rtn_ref_src_main_code' id='rtn_ref_src_main_code' value=''>
<input type='hidden' name='rtn_ref_src_main_desc' id='rtn_ref_src_main_desc' value=''>
<input type='hidden' name='rtn_ref_src_sub_code' id='rtn_ref_src_sub_code' value=''>
<input type='hidden' name='rtn_ref_src_sub_desc' id='rtn_ref_src_sub_desc' value=''>

<input type='hidden' name='rtn_ins_ref_src_main_code' id='rtn_ins_ref_src_main_code' value=''>
<input type='hidden' name='rtn_ins_ref_src_main_desc' id='rtn_ins_ref_src_main_desc' value=''>
<input type='hidden' name='rtn_ins_ref_src_sub_code' id='rtn_ins_ref_src_sub_code' value=''>
<input type='hidden' name='rtn_ins_ref_src_sub_desc' id='rtn_ins_ref_src_sub_desc' value=''>

<input type='hidden' name='rtn_non_ins_ref_src_main_code' id='rtn_non_ins_ref_src_main_code' value="">
<input type='hidden' name='rtn_non_ins_ref_src_main_desc' id='rtn_non_ins_ref_src_main_desc' value="">
<input type='hidden' name='rtn_non_ins_ref_src_sub_code' id='rtn_non_ins_ref_src_sub_code' value="">
<input type='hidden' name='rtn_non_ins_ref_src_sub_desc' id='rtn_non_ins_ref_src_sub_desc' value="">

<input type='hidden' name='rtn_tot_valid_enc_with_gl' id='rtn_tot_valid_enc_with_gl' value="">
<input type='hidden' name='rtn_tot_valid_op_enc_with_gl' id='rtn_tot_valid_op_enc_with_gl' value="">
<input type='hidden' name='rtn_tot_valid_ae_enc_with_gl' id='rtn_tot_valid_ae_enc_with_gl' value="">
<input type='hidden' name='rtn_tot_valid_ip_enc_with_gl' id='rtn_tot_valid_ip_enc_with_gl' value="">
<input type='hidden' name='rtn_tot_valid_dc_enc_with_gl' id='rtn_tot_valid_dc_enc_with_gl' value="">

<input type='hidden' name='rtn_tot_availed_enc_with_gl' id='rtn_tot_availed_enc_with_gl' value="">
<input type='hidden' name='rtn_tot_availed_op_enc_with_gl' id='rtn_tot_availed_op_enc_with_gl' value="">
<input type='hidden' name='rtn_tot_availed_ae_enc_with_gl' id='rtn_tot_availed_ae_enc_with_gl' value="">
<input type='hidden' name='rtn_tot_availed_ip_enc_with_gl' id='rtn_tot_availed_ip_enc_with_gl' value="">
<input type='hidden' name='rtn_tot_availed_dc_enc_with_gl' id='rtn_tot_availed_dc_enc_with_gl' value="">

<input type='hidden' name='rtn_gl_doc_ref_exist_YN' id='rtn_gl_doc_ref_exist_YN' value="">
<input type='hidden' name='rtn_pat_ser_code' id='rtn_pat_ser_code' value="">

<!-- Added for Classification Valued Capturing Purpose -->
<input type='hidden' name='rtn_class_type' id='rtn_class_type' value='' >
<input type='hidden' name='rtn_class_code' id='rtn_class_code' value='' >	
<input type='hidden' name='rtn_remarks' id='rtn_remarks' value='' >				
<input type='hidden' name='rtn_social_pensioner_id' id='rtn_social_pensioner_id' value='' >				
<input type='hidden' name='rtn_inc_asset_ind' id='rtn_inc_asset_ind' value='' >			
<input type='hidden' name='rtn_ind_inc' id='rtn_ind_inc' value='' >				
<input type='hidden' name='rtn_ind_inc_freq' id='rtn_ind_inc_freq' value='' >		
<input type='hidden' name='rtn_spouse_inc' id='rtn_spouse_inc' value='' >			
<input type='hidden' name='rtn_spouse_inc_freq' id='rtn_spouse_inc_freq' value='' >	
<input type='hidden' name='rtn_dependent_inc' id='rtn_dependent_inc' value='' >	
<input type='hidden' name='rtn_dependent_inc_freq' id='rtn_dependent_inc_freq' value='' >
<input type='hidden' name='rtn_valid_from' id='rtn_valid_from' value='' >
<input type='hidden' name='rtn_valid_to' id='rtn_valid_to' value='' >
<input type='hidden' name='rtn_last_date' id='rtn_last_date' value=''  />
<input type='hidden' name='encounter_date_time' id='encounter_date_time' value=''>
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>

</form>
</body>

</html>

