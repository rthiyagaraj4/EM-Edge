<!DOCTYPE html>
<%
/*
Sr No        Version            Incident          SCF/CRF             Developer Name
1           V232504							SKR-SCF-1731-TF         Namrata Charate
*/
%>
<%@  page import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<script>
	function test()
	{
		document.forms[0].total_records.value=parent.frames[2].document.forms[0].total_records.value;
		document.forms[0].rtn_ins_blng_grp.value=parent.frames[2].document.forms[0].rtn_ins_blng_grp.value;
		document.forms[0].rtn_ins_blng_grp_desc.value=parent.frames[2].document.forms[0].rtn_ins_blng_grp_desc.value;
		document.forms[0].rtn_ins_payer_desc.value=parent.frames[2].document.forms[0].rtn_ins_payer_desc.value;
		document.forms[0].rtn_ins_cust_code.value=parent.frames[2].document.forms[0].rtn_ins_cust_code.value;
		document.forms[0].rtn_ins_cust_priority.value=parent.frames[2].document.forms[0].rtn_ins_cust_priority.value;
		document.forms[0].rtn_ins_policy_type_desc.value=parent.frames[2].document.forms[0].rtn_ins_policy_type_desc.value;
		document.forms[0].rtn_ins_policy_type_code.value=parent.frames[2].document.forms[0].rtn_ins_policy_type_code.value;
		document.forms[0].rtn_ins_policy_no.value=parent.frames[2].document.forms[0].rtn_ins_policy_no.value;
		document.forms[0].rtn_ins_policy_start_date.value=parent.frames[2].document.forms[0].rtn_ins_policy_start_date.value;
		document.forms[0].rtn_ins_policy_expiry_date.value=parent.frames[2].document.forms[0].rtn_ins_policy_expiry_date.value;
		document.forms[0].rtn_ins_credit_auth_ref.value=parent.frames[2].document.forms[0].rtn_ins_credit_auth_ref.value;
		document.forms[0].rtn_ins_credit_auth_date.value=parent.frames[2].document.forms[0].rtn_ins_credit_auth_date.value;
		document.forms[0].rtn_ins_cred_auth_req_yn.value=parent.frames[2].document.forms[0].rtn_ins_cred_auth_req_yn.value;
		document.forms[0].rtn_ins_cred_auth_mand_capt_yn.value=parent.frames[2].document.forms[0].rtn_ins_cred_auth_mand_capt_yn.value;
		document.forms[0].rtn_ins_dflt_auth_ref_as_pol_no_yn.value=parent.frames[2].document.forms[0].rtn_ins_dflt_auth_ref_as_pol_no_yn.value;

		document.forms[0].rtn_ins_credit_approval_days.value=parent.frames[2].document.forms[0].rtn_ins_credit_approval_days.value;
		document.forms[0].rtn_ins_credit_approval_amount.value=parent.frames[2].document.forms[0].rtn_ins_credit_approval_amount.value;
		document.forms[0].rtn_ins_policy_eff_from_date.value=parent.frames[2].document.forms[0].rtn_ins_policy_eff_from_date.value;
		document.forms[0].rtn_ins_policy_eff_to_date.value=parent.frames[2].document.forms[0].rtn_ins_policy_eff_to_date.value;
		document.forms[0].rtn_ins_adj_rule_ind.value=parent.frames[2].document.forms[0].rtn_ins_adj_rule_ind.value;
		document.forms[0].rtn_ins_adj_perc_amt_ind.value=parent.frames[2].document.forms[0].rtn_ins_adj_perc_amt_ind.value;
		document.forms[0].rtn_ins_adj_perc_amt_value.value=parent.frames[2].document.forms[0].rtn_ins_adj_perc_amt_value.value;
		document.forms[0].rtn_ins_pmnt_diff_adj_int.value=parent.frames[2].document.forms[0].rtn_ins_pmnt_diff_adj_int.value;
		document.forms[0].rtn_ins_drg_pmnt_diff_adj_int.value=parent.frames[2].document.forms[0].rtn_ins_drg_pmnt_diff_adj_int.value;
		document.forms[0].rtn_ins_spl_srv_pmnt_diff_adj_int.value=parent.frames[2].document.forms[0].rtn_ins_spl_srv_pmnt_diff_adj_int.value;

		document.forms[0].rtn_ins_restrict_check.value=parent.frames[2].document.forms[0].rtn_ins_restrict_check.value;
		document.forms[0].rtn_ins_apprd_amt_restrict_check.value=parent.frames[2].document.forms[0].rtn_ins_apprd_amt_restrict_check.value;
		document.forms[0].rtn_ins_apprd_days_restrict_check.value=parent.frames[2].document.forms[0].rtn_ins_apprd_days_restrict_check.value;

		document.forms[0].rtn_ins_valid_payer_YN.value=parent.frames[2].document.forms[0].rtn_ins_valid_payer_YN.value;
		document.forms[0].rtn_ins_valid_policy_type_code_YN.value=parent.frames[2].document.forms[0].rtn_ins_valid_policy_type_code_YN.value;

		document.forms[0].rtn_ins_cust_group_code.value=parent.frames[2].document.forms[0].rtn_ins_cust_group_code.value;
		document.forms[0].rtn_ins_cust_group_name.value=parent.frames[2].document.forms[0].rtn_ins_cust_group_name.value;	
		document.forms[0].rtn_ins_policy_coverage_basis_ind.value=parent.frames[2].document.forms[0].rtn_ins_policy_coverage_basis_ind.value;
		document.forms[0].rtn_ref_src_main_code.value=parent.frames[2].document.forms[0].rtn_ref_src_main_code.value;
		document.forms[0].rtn_ref_src_main_desc.value=parent.frames[2].document.forms[0].rtn_ref_src_main_desc.value;
		document.forms[0].rtn_ref_src_sub_code.value=parent.frames[2].document.forms[0].rtn_ref_src_sub_code.value;
		document.forms[0].rtn_ref_src_sub_desc.value=parent.frames[2].document.forms[0].rtn_ref_src_sub_desc.value;

		document.forms[0].rtn_payerEligibilityParamSession.value=parent.frames[2].document.forms[0].rtn_payerEligibilityParamSession.value;
		document.forms[0].rtn_responseCode.value=parent.frames[2].document.forms[0].rtn_responseCode.value;	
		document.forms[0].rtn_responseCodeDesc.value=parent.frames[2].document.forms[0].rtn_responseCodeDesc.value;
		document.forms[0].rtn_statuDescription.value=parent.frames[2].document.forms[0].rtn_statuDescription.value;
		document.forms[0].rtn_validityPeriod.value=parent.frames[2].document.forms[0].rtn_validityPeriod.value;
		document.forms[0].rtn_validityPeriodDesc.value=parent.frames[2].document.forms[0].rtn_validityPeriodDesc.value;
		document.forms[0].rtn_eligibilityCode.value=parent.frames[2].document.forms[0].rtn_eligibilityCode.value;
		document.forms[0].rtn_transactionId.value=parent.frames[2].document.forms[0].rtn_transactionId.value;
		document.forms[0].rtn_responseDateTime.value=parent.frames[2].document.forms[0].rtn_responseDateTime.value;

		//V232504
		document.forms[0].rtn_mcn_for_policy.value=parent.frames[2].document.forms[0].rtn_mcn_for_policy.value;
		document.forms[0].rtn_reg_ref_id.value=parent.frames[2].document.forms[0].rtn_reg_ref_id.value;
		




		document.forms[0].action="../../servlet/eBL.AddModifyPatFinDetailsMultiBlngGrpServlet";
		document.forms[0].submit();
	}

</script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

<html>
<body onLoad="test()"  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='BLFinDetSubForm' id='BLFinDetSubForm' method='post' >

<input type='hidden' name='total_records' id='total_records' value=''>
<input type='hidden' name='rtn_ins_blng_grp_desc' id='rtn_ins_blng_grp_desc' value=''>
<input type='hidden' name='rtn_ins_blng_grp' id='rtn_ins_blng_grp' value=''>
<input type='hidden' name='rtn_ins_payer_desc' id='rtn_ins_payer_desc' value=''>
<input type='hidden' name='rtn_ins_cust_code' id='rtn_ins_cust_code' value=''>
<input type='hidden' name='rtn_ins_cust_priority' id='rtn_ins_cust_priority' value=''>
<input type='hidden' name='rtn_ins_policy_type_desc' id='rtn_ins_policy_type_desc' value=''>
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
<input type='hidden' name='rtn_ins_restrict_check' id='rtn_ins_restrict_check' value=''>
<input type='hidden' name='rtn_ins_apprd_amt_restrict_check' id='rtn_ins_apprd_amt_restrict_check' value="">
<input type='hidden' name='rtn_ins_apprd_days_restrict_check' id='rtn_ins_apprd_days_restrict_check' value="">
<input type='hidden' name='rtn_ins_valid_payer_YN' id='rtn_ins_valid_payer_YN' value=''>
<input type='hidden' name='rtn_ins_valid_policy_type_code_YN' id='rtn_ins_valid_policy_type_code_YN' value=''>
<input type='hidden' name='rtn_ins_cust_group_code' id='rtn_ins_cust_group_code' value=''>
<input type='hidden' name='rtn_ins_cust_group_name' id='rtn_ins_cust_group_name' value=''>
<input type='hidden' name='rtn_ins_policy_coverage_basis_ind' id='rtn_ins_policy_coverage_basis_ind' value=''>

<input type='hidden' name='rtn_ref_src_main_code' id='rtn_ref_src_main_code' value="">
<input type='hidden' name='rtn_ref_src_main_desc' id='rtn_ref_src_main_desc' value="">
<input type='hidden' name='rtn_ref_src_sub_code' id='rtn_ref_src_sub_code' value="">
<input type='hidden' name='rtn_ref_src_sub_desc' id='rtn_ref_src_sub_desc' value="">


<input type='hidden' name='rtn_payerEligibilityParamSession' id='rtn_payerEligibilityParamSession' value="">
<input type='hidden' name='rtn_responseCode' id='rtn_responseCode' value="">
<input type='hidden' name='rtn_responseCodeDesc' id='rtn_responseCodeDesc' value="">
<input type='hidden' name='rtn_statuDescription' id='rtn_statuDescription' value="">
<input type='hidden' name='rtn_validityPeriod' id='rtn_validityPeriod' value="">
<input type='hidden' name='rtn_validityPeriodDesc' id='rtn_validityPeriodDesc' value="">
<input type='hidden' name='rtn_eligibilityCode' id='rtn_eligibilityCode' value="">
<input type='hidden' name='rtn_transactionId' id='rtn_transactionId' value="">
<input type='hidden' name='rtn_responseDateTime' id='rtn_responseDateTime' value="">

<input type='hidden' name='rtn_mcn_for_policy' id='rtn_mcn_for_policy' value="">  <!-- V232504 -->
<input type='hidden' name='rtn_reg_ref_id' id='rtn_reg_ref_id' value="">  <!-- V232504 -->




</form>
</body>

</html>

