<!DOCTYPE html>
<%/*
Sr No              Version                Incident              SCF/CRF                        Developer Name
1                  V201008                IN73731            NMC-JD-SCF-0081 			        Shikha Seth
*/
%>
<%@ page import="org.apache.commons.lang.*,java.sql.*,org.apache.commons.lang.StringUtils, java.util.*,eXH.*,java.lang.*,java.text.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,com.ehis.util.*,eBL.Common.*, eBL.*,eXH.InterfaceUtil" contentType="text/html;charset=UTF-8" %>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<%
	Connection con				= null;
	Statement stmt				= null;
	PreparedStatement pstmt		= null;
	PreparedStatement pstmt1	= null;
	PreparedStatement pstmt7    = null;
	ResultSet rs				= null;
	ResultSet rs2				= null;
	ResultSet rs3				= null;
	ResultSet rs7				= null;
	ResultSet rs1				= null;
	String strPlcyorEnctr		= null;
	//Rajesh - V
	String chargeLogicYn = "";
	String strCustomerId = "";
	
	//Rajesh - V
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	boolean site3TierAlmoFeature = false;
	String site3TierAlmoFeatureYN = "N";
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	try
	{
	con	=	ConnectionManager.getConnection(request);
	HttpSession httpSession = request.getSession(false);
	String oldMapKey="";//added for package billing
	String query_string=request.getQueryString();
	String package_enabled_yn= request.getParameter("package_enabled_yn");// added for package billing 
	if(package_enabled_yn == null) package_enabled_yn="N";
	int noofdecimal=2;
	String restrict_check="";
	String apprd_amt_restrict_check = "";
	String apprd_days_restrict_check = "";
	String cred_auth_req_yn = "", dflt_auth_ref_as_pol_no_yn = "",cred_auth_mand_capt_yn="";
	String readonly="";
	String strModuleId = request.getParameter("calling_module_id");
	if(strModuleId== null) strModuleId="";
	String patient_id = request.getParameter("patient_id");//added for package billing
	if(patient_id== null) patient_id="";//added for package billing
	String facility_id = (String)httpSession.getValue("facility_id");
	String p_patient_class=request.getParameter("patient_class");
	String episode_type="";
	String restricted_YN="";
	String encounter_date_time = "", encounter_date_aft_trunc="", pol_validity_chk_date= "";

	String addl_days_policy_expdt="",days_policy_expdt="",days_policy_strtdt=""; //GHL-0020 SCRUM CRF Related

	String fin_class_flag_YN="N",autoFinChk="N", class_code="";

	String checked_row="", rec_edited_YN="N";

	String total_keys=request.getParameter("total_keys");
	if(total_keys == null) total_keys="";

	String max_priority_arr=request.getParameter("max_priority_arr");
	if(total_keys == null) total_keys="";

	String min_priority_arr=request.getParameter("min_priority_arr");
	if(min_priority_arr == null) min_priority_arr="";

	String priority_arr=request.getParameter("priority_arr");
	if(priority_arr == null) priority_arr="";

	String max_priority=request.getParameter("max_priority");
	if(max_priority == null || max_priority.equals("")) max_priority="0";

	String v_display_hide="", v_display_hide_apprvd_amt="", v_display_hide_apprvd_days="";
	String v_display_hide_cred_auth="", v_credit_auth_val_mand="",v_display_hide_add_aprv="display:none";
	String str_curr_code_for_bg="";

	String billing_group=request.getParameter("billing_group");
	if(billing_group==null || billing_group.equals("")) billing_group="";
	
	String action=request.getParameter("action");
	if(action==null || action.equals("")) action="";

	String modify_refresh=request.getParameter("modify_refresh");
	if(modify_refresh==null || modify_refresh.equals("")) modify_refresh="N";

	String location=request.getParameter("locn");
	if(location==null || location.equals("")) location="";

	fin_class_flag_YN = request.getParameter("fin_class_flag_YN");
	if(fin_class_flag_YN == null) fin_class_flag_YN="N";

	autoFinChk = request.getParameter("autoFinChk");
	if(autoFinChk == null) autoFinChk="N";

	class_code = request.getParameter("class_code");
	if(class_code == null) class_code="";

	checked_row = request.getParameter("checked_row");
	if(checked_row == null) checked_row="";

	rec_edited_YN = request.getParameter("rec_edited_YN");
	if(rec_edited_YN == null) rec_edited_YN="";

	String billing_grp_code ="",blng_grp_code_tokens="";
	String blng_grp_long_desc="";	String billing_grp_qry="";

	String select_billing_group="",payer_desc="", cust_3="", priority="", policy_type_desc="",policy_type_code="",policy_no="";
	String policy_start_date="",policy_exp_date="",credit_auth_ref="",credit_auth_date="";
	String credit_apprd_amt="",credit_apprd_days="",policy_eff_frm_date="",policy_eff_to_date="";
	String adj_rule_ind="",adj_perc_amt_ind="",adj_perc_amt_value="",pmnt_diff_adj_int="";
	String drg_pmnt_diff_adj_int="",spl_srv_pmnt_diff_adj_int="";
	String valid_payer_YN="",valid_policy_type_code_YN="";
	String cust_valid_from_date = "", cust_valid_to_date = "";
	String cust_group_code="",cust_group_name="",str_ins_cust_curr_code="",str_ins_cust_curr_desc="";
	String policy_coverage_basis_ind="";
	String policy_coverage_basis_gbl_ind="";
	String totalRecords="";
	String search_by_items = "", search_code = "", srch_by_desc = "";
	String cnty_sel="", regn_sel="";
    
	//Added by prithivi on 20/12/2016 for mms-qh-crf-0085
	String interfaceYN= "N", visitRegProcFlagYN="N";
	String payerEligibilityParam = "9";

	String payerEligibilityParamSession = "", responseCodeSession = "", responseCodeDescSes = "",statuDescriptionSession = "", validityPeriodSession = "", eligibilityCodeSes = "";
	String transactionIdSes = "", responseDateTimeSes = "", validityPeriodDescSes = "";
	String moduleIdCheck="N";

	payerEligibilityParamSession=request.getParameter("payerElgParam");
	if(payerEligibilityParamSession == null || "null".equals(payerEligibilityParamSession)) 
	payerEligibilityParamSession="";

	responseCodeSession=request.getParameter("respCdSes");
	if(responseCodeSession == null || "null".equals(responseCodeSession)) 
	responseCodeSession="";

	responseCodeDescSes=request.getParameter("respCdDescSes");
	if(responseCodeDescSes==null || "null".equals(responseCodeDescSes)) 
	responseCodeDescSes="";

	statuDescriptionSession=request.getParameter("statDes");
	if(statuDescriptionSession==null || "null".equals(statuDescriptionSession)) 
	statuDescriptionSession=""; 

	validityPeriodSession=request.getParameter("valPer");
	if(validityPeriodSession==null || "null".equals(validityPeriodSession)) 
	validityPeriodSession="";

	validityPeriodDescSes=request.getParameter("valPerDesc");
	if(validityPeriodDescSes==null || "null".equals(validityPeriodDescSes)) 
	validityPeriodDescSes="";

	eligibilityCodeSes=request.getParameter("elgCd");
	if(eligibilityCodeSes==null || "null".equals(eligibilityCodeSes)) 
	eligibilityCodeSes="";

	transactionIdSes=request.getParameter("transId");
	if(transactionIdSes==null || "null".equals(transactionIdSes)) 
	transactionIdSes="";

	responseDateTimeSes=request.getParameter("respDT");
	if(responseDateTimeSes==null || "null".equals(responseDateTimeSes)) 
	responseDateTimeSes="";

	select_billing_group=billing_group;
	
	String payer_suspended_YN="", policy_suspended_YN="";

	policy_coverage_basis_gbl_ind=request.getParameter("policy_coverage_basis_gbl_ind");
	if(policy_coverage_basis_gbl_ind==null) policy_coverage_basis_gbl_ind="";

	totalRecords=request.getParameter("totalRecords");
	if(totalRecords==null) totalRecords="";

	priority=request.getParameter("priority");
	if(priority==null || priority.equals(" ")) priority="";

	encounter_date_time = request.getParameter("encounter_date_time");
	if(encounter_date_time == null) encounter_date_time="";

	CurrencyFormat cf1 = new CurrencyFormat();
	//Added by Rajesh - V
	String todayFormated = "";
	String strModifyPlcyYN = "";
	String addPayerCustGrpbySetup = "";

	//Added by prithivi on 11/12/2016 for mms-qh-crf-0085
	String service_code=request.getParameter("service_code");
	String clinic_code=request.getParameter("clinic_code");
	//Added by Sethu for MMS-QH-CRF-0085 ON 18/11/2019
	String nursing_unit_code=request.getParameter("nursing_unit_code");

	Properties p = (Properties)httpSession.getValue("jdbc");
	String strWsNo   =  p.getProperty("client_ip_address");

	Boolean siteSpec=false;

	if(strWsNo == null) strWsNo="";

	//Added By Vijay For MMS-QF-SCF-567
	Boolean siteSpecPolApprv = false; //Added V190517-Aravindh/NMC-JD-CRF-0010

	try
	{
		
	siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DONT_DFLT_POL_EXP_DAYS_CONFIG");
	//Added V190517-Aravindh/NMC-JD-CRF-0010/Starts
	String polApprvSql = "select NVL(enable_policy_approval_yn,'N') enable_policy_approval_yn from bl_parameters where operating_facility_id = '"+facility_id+"'";
	pstmt = con.prepareStatement(polApprvSql);
	rs = pstmt.executeQuery();
	while(rs.next()) {
		String enablePolicyApprvl = rs.getString("enable_policy_approval_yn");
		if("Y".equals(enablePolicyApprvl)) {
			siteSpecPolApprv = true;
		}
	}
	rs.close();
	pstmt.close();
	//Added V190517-Aravindh/NMC-JD-CRF-0010/Ends
	//System.out.println("AddModifyPatFinDetailsInsBodyEdit.jsp->SiteSpec: "+siteSpec+",siteSpecPolApprv: "+siteSpecPolApprv);
}catch(Exception e)
{
	e.printStackTrace();
	System.out.println("Exception in site specific "+e);
}
	//Added for MMS-DM-CRF-0164.1 Starts
	Boolean Site_spec=false;
	String siteSpecMemberID ="";
	try
	{
		//con = ConnectionManager.getConnection();	
		Site_spec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","MEMBERSHIP_ID_MANDATORY");
	}catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Exception in site specific "+e);
	}
	if(Site_spec){
		siteSpecMemberID="Y";
	}
	else{
		siteSpecMemberID="N";
	}
	//Added for MMS-DM-CRF-0164.1 Ends
	
	//Added for NMC-JD-CRF-0054 Policy_No Starts
	Boolean Site_spec_Pno=false;
	String siteSpecPolicyNo ="";
	try
	{
		//con = ConnectionManager.getConnection();	
		Site_spec_Pno = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","POLICY_NO_MANDATORY");
		//System.err.println("value for Site_spec_Pno"+Site_spec_Pno);
	}catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Exception in site specific "+e);
	}
	if(Site_spec_Pno){
		siteSpecPolicyNo="Y";
	}
	else{
		siteSpecPolicyNo="N";
	}
	//Added for NMC-JD-CRF-0054 Policy_No Ends
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	try {
		//con	=	ConnectionManager.getConnection(request);
		site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","3TIERALMOFEATURE");
		if (site3TierAlmoFeature) {
			site3TierAlmoFeatureYN = "Y";
		}else {
			site3TierAlmoFeatureYN = "N";
		}
	} catch(Exception ex) {
		System.err.println("Error in AddModifyPatFinDetailsInsBodyEdit.jsp for getting site3TierAlmoFeature Connection: "+ex);
		ex.printStackTrace();
	}
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1

	try {
		String sqlBLParam = "Select CHARGE_LOGIC_YN,to_char(sysdate,'dd/mm/yyyy') todaydate,MOD_POLICY_DTL_DURING_REG_YN MODIFY_POLICY_YN,ADD_PAYER_CUSTGRP_BY_SETUP from BL_PARAMETERS WHERE OPERATING_FACILITY_ID = ? ";
		pstmt = con.prepareStatement(sqlBLParam);
		pstmt.setString(1, facility_id);
		rs1 = pstmt.executeQuery();
		if (rs1 != null) {
			while (rs1.next()) {
				chargeLogicYn = rs1.getString("CHARGE_LOGIC_YN");
				todayFormated = rs1.getString("todaydate");
				strModifyPlcyYN = rs1.getString("MODIFY_POLICY_YN");
				addPayerCustGrpbySetup = rs1.getString("ADD_PAYER_CUSTGRP_BY_SETUP");
				chargeLogicYn = chargeLogicYn == null ? "": chargeLogicYn;
			}
		}

		pstmt = null;
		rs1 = null;
	} catch (Exception e) {
		System.out.println("Exception in getting bl_param" + e);
	}

	//Added by Rajesh - V

	try{
		String sqlsiteParam = "Select CUSTOMER_ID from SM_SITE_PARAM ";
		pstmt = con.prepareStatement(sqlsiteParam);		
		rs1 = pstmt.executeQuery();
		if(rs1 != null){
			while(rs1.next()){
				strCustomerId = rs1.getString("CUSTOMER_ID");
				strCustomerId=strCustomerId==null?"":strCustomerId;
			}
		}

		pstmt = null;
		rs1 = null;
	}
	catch(Exception e)
	{
		System.out.println("Exception in getting bl_param"+e);
	}


	try
	{		
		String sql_deci_date = " select nvl(no_of_decimal,2),to_char( (to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') from sm_acc_entity_param where acc_entity_id='ZZ'";
		pstmt = con.prepareStatement( sql_deci_date);
					
		rs1 = pstmt.executeQuery();	
		if( rs1!= null ) 
		{
			while( rs1.next() )
			{
				noofdecimal  =  rs1.getInt(1);
				encounter_date_aft_trunc = rs1.getString(2);
			}
		}
		
		if (rs1 != null)   rs1.close();
		if (pstmt != null) pstmt.close();	
	}
	catch(Exception e)
	{
		System.out.println("4="+e.toString());
	}
	if(encounter_date_aft_trunc == null) encounter_date_aft_trunc="";

/*
	if(autoFinChk.equals("Y"))
	{
		HashMap bl_data=(HashMap)session.getAttribute("financial_details");
		if(!(bl_data==null || bl_data.isEmpty()))
		{
			System.err.println("Inside Class Loop in bodyedit.jsp");
			class_code = ((String)bl_data.get("class_code")).trim();
		}
	}
*/
/* PE Changes
	try
	{
		String sql_trunc_time="select to_char( (to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') from dual";

		stmt = con.createStatement();
		rs = stmt.executeQuery(sql_trunc_time) ;

		if( rs!= null ) 
		{
			while( rs.next() )
			{  
				encounter_date_aft_trunc = rs.getString(1);
			}
		}
		if (rs != null)   rs.close();
		stmt.close();
	}
	catch(Exception e)
	{
		System.out.println("Exception while executing sql_trunc_time :"+e);
	}
	if(encounter_date_aft_trunc == null) encounter_date_aft_trunc="";
*/
	if(!encounter_date_aft_trunc.equals(""))
	{
		encounter_date_aft_trunc = com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY","en",locale);
	}

	if(action.equals("add") && location.equals("outside"))
	{
		blng_grp_code_tokens=request.getParameter("blng_grp_code_array");
		if(blng_grp_code_tokens==null || blng_grp_code_tokens.equals("")) blng_grp_code_tokens="";
	}

	if(action.equals("modify") || action.equals("remove") || (action.equals("add") && modify_refresh.equals("Y")))
	{
		select_billing_group=request.getParameter("select_billing_group");
		if(select_billing_group==null || select_billing_group.equals("")) select_billing_group="";
	
		billing_group=request.getParameter("blng_grp_code");
		if(billing_group==null || billing_group.equals(" ")) billing_group="";

		str_curr_code_for_bg=request.getParameter("curr_code_for_bg");
		if(str_curr_code_for_bg==null || str_curr_code_for_bg.equals(" ")) str_curr_code_for_bg="";

		payer_desc=request.getParameter("payer_desc");
		if(payer_desc==null || payer_desc.equals(" ")) payer_desc="";

		cust_3=request.getParameter("cust_3");
		if(cust_3==null || cust_3.equals(" ")) cust_3="";
		
		cust_group_code=request.getParameter("ins_cust_group_code");
		if(cust_group_code==null || cust_group_code.equals(" ")) cust_group_code="";

		str_ins_cust_curr_code =request.getParameter("ins_cust_curr_code");
		if(str_ins_cust_curr_code==null || str_ins_cust_curr_code.equals(" ")) str_ins_cust_curr_code="";

		str_ins_cust_curr_desc =request.getParameter("ins_cust_curr_desc");
		if(str_ins_cust_curr_desc==null || str_ins_cust_curr_desc.equals(" ")) str_ins_cust_curr_desc="";

		cust_group_name=request.getParameter("ins_cust_group_name");
		if(cust_group_name==null || cust_group_name.equals(" ")) cust_group_name="";
/*
		priority=request.getParameter("priority");
		if(priority==null || priority.equals(" ")) priority="";
*/
		policy_type_desc=request.getParameter("policy_type_desc");
		if(policy_type_desc==null || policy_type_desc.equals(" ")) policy_type_desc="";

		policy_type_code=request.getParameter("policy_type_code");
		if(policy_type_code==null || policy_type_code.equals(" ")) policy_type_code="";

		policy_no=request.getParameter("policy_no");
		if(policy_no==null || policy_no.equals(" ")) policy_no="";
		
		policy_start_date=request.getParameter("policy_start_date");
		if(policy_start_date==null || policy_start_date.equals(" ") || policy_start_date.equals("null")) policy_start_date="";

		policy_exp_date=request.getParameter("policy_exp_date");
		if(policy_exp_date==null || policy_exp_date.equals(" ") || policy_exp_date.equals("null")) policy_exp_date="";
		
//		System.out.println("Expiry date ####  "+policy_exp_date);

		credit_auth_ref=request.getParameter("credit_auth_ref");
		if(credit_auth_ref==null || credit_auth_ref.equals(" ")) credit_auth_ref="";

		credit_auth_date=request.getParameter("credit_auth_date");
		if(credit_auth_date==null || credit_auth_date.equals(" ")) credit_auth_date="";

		credit_apprd_amt=request.getParameter("credit_apprd_amt");
		if(credit_apprd_amt==null || credit_apprd_amt.equals(" ")) credit_apprd_amt="";

		credit_apprd_days=request.getParameter("credit_apprd_days");
		if(credit_apprd_days==null || credit_apprd_days.equals(" ")) credit_apprd_days="";

		policy_eff_frm_date=request.getParameter("policy_eff_frm_date");
		if(policy_eff_frm_date==null || policy_eff_frm_date.equals(" ")) policy_eff_frm_date="";

		policy_eff_to_date=request.getParameter("policy_eff_to_date");
		if(policy_eff_to_date==null || policy_eff_to_date.equals(" ")) policy_eff_to_date="";

		adj_rule_ind=request.getParameter("adj_rule_ind");
		if(adj_rule_ind==null || adj_rule_ind.equals(" ")) adj_rule_ind="";

		adj_perc_amt_ind=request.getParameter("adj_perc_amt_ind");
		if(adj_perc_amt_ind==null || adj_perc_amt_ind.equals(" ")) adj_perc_amt_ind="";

		adj_perc_amt_value=request.getParameter("adj_perc_amt_value");
		if(adj_perc_amt_value==null || adj_perc_amt_value.equals(" ")) adj_perc_amt_value="";
		if(!adj_perc_amt_value.equals(""))
		{
			adj_perc_amt_value = cf1.formatCurrency(adj_perc_amt_value,noofdecimal);
		}

		pmnt_diff_adj_int=request.getParameter("pmnt_diff_adj_int");
		if(pmnt_diff_adj_int==null || pmnt_diff_adj_int.equals(" ")) pmnt_diff_adj_int="";

		drg_pmnt_diff_adj_int=request.getParameter("drg_pmnt_diff_adj_int");
		if(drg_pmnt_diff_adj_int==null || drg_pmnt_diff_adj_int.equals(" ")) drg_pmnt_diff_adj_int="";

		spl_srv_pmnt_diff_adj_int=request.getParameter("spl_srv_pmnt_diff_adj_int");
		if(spl_srv_pmnt_diff_adj_int==null || spl_srv_pmnt_diff_adj_int.equals(" ")) spl_srv_pmnt_diff_adj_int="";

		valid_payer_YN=request.getParameter("valid_payer_YN");
		if(valid_payer_YN==null || valid_payer_YN.equals(" ")) valid_payer_YN="";

		cust_valid_from_date=request.getParameter("cust_valid_from_date");
		if(cust_valid_from_date==null || cust_valid_from_date.equals(" ")) cust_valid_from_date="";

		cust_valid_to_date=request.getParameter("cust_valid_to_date");
		if(cust_valid_to_date==null || cust_valid_to_date.equals(" ")) cust_valid_to_date="";

		valid_policy_type_code_YN=request.getParameter("valid_policy_type_code_YN");
		if(valid_policy_type_code_YN==null || valid_policy_type_code_YN.equals(" ")) valid_policy_type_code_YN="";

		policy_coverage_basis_ind=request.getParameter("policy_coverage_basis_ind");
		if(policy_coverage_basis_ind==null || policy_coverage_basis_ind.equals(" ")) policy_coverage_basis_ind="";

		search_by_items = request.getParameter("search_by_items");
		if(search_by_items==null || search_by_items.equals(" ")) search_by_items="";

		search_code = request.getParameter("search_code");
		if(search_code==null || search_code.equals(" ")) search_code="";

		srch_by_desc = request.getParameter("srch_by_desc");
		if(srch_by_desc==null || srch_by_desc.equals(" ")) srch_by_desc="";

		pol_validity_chk_date = request.getParameter("pol_validity_chk_date");
		if(pol_validity_chk_date==null || pol_validity_chk_date.equals(" ")) pol_validity_chk_date="";

		payer_suspended_YN = request.getParameter("payer_suspended_YN");
		if(payer_suspended_YN==null || payer_suspended_YN.equals(" ")) payer_suspended_YN="";

		policy_suspended_YN = request.getParameter("policy_suspended_YN");
		if(policy_suspended_YN==null || policy_suspended_YN.equals(" ")) policy_suspended_YN="";
	}
	
	if(action.equals("modify") || action.equals("remove") || (action.equals("add") && modify_refresh.equals("Y")))
	{
		if(search_by_items.equals("CY"))
		{
			cnty_sel="SELECTED";
		}
		else if(search_by_items.equals("RN"))
		{
			regn_sel="SELECTED";
		}
		else
		{
			regn_sel="SELECTED";
		}
	}
	else if(action.equals("add") && !modify_refresh.equals("Y"))
	{
		regn_sel="SELECTED";
		cnty_sel="";
	}

	if (!locale.equals("en") && !modify_refresh.equals("Y"))
	{
		if(!policy_start_date.equals(""))
			policy_start_date=com.ehis.util.DateUtils.convertDate(policy_start_date,"DMY","en",locale);
			
		if(!policy_exp_date.equals(""))
			policy_exp_date=com.ehis.util.DateUtils.convertDate(policy_exp_date,"DMY","en",locale);

		if(!credit_auth_date.equals(""))
			credit_auth_date=com.ehis.util.DateUtils.convertDate(credit_auth_date,"DMY","en",locale);

		if(!policy_eff_frm_date.equals(""))
			policy_eff_frm_date=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date,"DMY","en",locale);

		if(!policy_eff_to_date.equals(""))
			policy_eff_to_date=com.ehis.util.DateUtils.convertDate(policy_eff_to_date,"DMY","en",locale);

	}

	if(p_patient_class ==null || (p_patient_class.equals("")))
	{
		if(strModuleId.equals("MP")) p_patient_class="XT";
		else if(strModuleId.equals("EM")) p_patient_class="EM";
		else if(strModuleId.equals("OP")) p_patient_class="OP";
		else if(strModuleId.equals("IP")) p_patient_class="IP";
		else if(strModuleId.equals("DC")) p_patient_class="DC";
	}

	if(strModuleId.equals("MP")) episode_type="R";
	else if(strModuleId.equals("AE")) episode_type="E";
	else if(strModuleId.equals("OP")) episode_type="O";
	else if(strModuleId.equals("IP")) episode_type="I";
	else if(strModuleId.equals("DC")) episode_type="D";


	if(action.equals("modify") || action.equals("remove"))
	{
		readonly="readonly";
	}

	if(!(policy_type_code.equals("") && cust_3.equals("")))
	{
//	String restrict_check_sql="SELECT DECODE('"+episode_type+"','O',NVL(OUTPATIENT_LIMIT_TYPE,'U'),'E',NVL(OUTPATIENT_LIMIT_TYPE,'U'),'I',NVL(INPATIENT_LIMIT_TYPE,'U'),'D',NVL(INPATIENT_LIMIT_TYPE,'U'),'U') FROM BL_INS_POLICY_TYPE_HDR WHERE OPERATING_FACILITY_ID = '"+facility_id+"' AND POLICY_TYPE_CODE = '"+policy_type_code+"' AND CUST_CODE = '"+cust_3+"'";
		try
		{
			String restrict_check_sql="SELECT DECODE('"+episode_type+"','O', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'E', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'I', NVL(a.INPATIENT_LIMIT_TYPE,'U'),'D',NVL(a.INPATIENT_LIMIT_TYPE,'U'),'R',NVL(a.EXTERNAL_LIMIT_TYPE,'U'),'U') , DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'E', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'I', NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'R',NVL(a.EX_APPROVED_AMT_LIMIT_TYPE, 'U'),'U'),DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'E', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'I', NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'D',NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'R',NVL(a.EX_APPROVED_DAYS_LIMIT_TYPE,  'U'),'U'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_REQ_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_REQ_YN,'N'),'I',NVL(a.IP_CRED_AUTH_REQ_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_REQ_YN,'N'),'R',NVL(a.EX_CRED_AUTH_REQ_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'E',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'I',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'D',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'R',NVL(a.EX_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'I',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'R',NVL(a.EX_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'N') FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+policy_type_code+"' AND a.CUST_CODE = '"+cust_3+"' and b.cust_group_code = a.cust_group_code and a.cust_code = b.cust_code and a.cust_group_code='"+cust_group_code+"'";
			String empty_sql_check="N";

			pstmt = con.prepareStatement(restrict_check_sql);
			rs=pstmt.executeQuery();
			if( rs != null ) 
			{
				empty_sql_check="Y";
				while(rs.next())
				{
					restrict_check = rs.getString(1);
					apprd_amt_restrict_check = rs.getString(2); 
					apprd_days_restrict_check = rs.getString(3); 
					cred_auth_req_yn = rs.getString(4); 
					dflt_auth_ref_as_pol_no_yn = rs.getString(5); 
					cred_auth_mand_capt_yn = rs.getString(6); 
					empty_sql_check="N";
				}
			}
			if (rs != null)   rs.close();
			pstmt.close();

			if(empty_sql_check.equals("Y"))
			{
				restrict_check="";
				restrict_check_sql="SELECT DECODE('"+episode_type+"','O', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'E', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'I', NVL(a.INPATIENT_LIMIT_TYPE,'U'),'D',NVL(a.INPATIENT_LIMIT_TYPE,'U'),'R',NVL(a.EXTERNAL_LIMIT_TYPE,'U'),'U'), DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'E', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'I', NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'R',NVL(a.EX_APPROVED_AMT_LIMIT_TYPE, 'U'),'U'),DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'E', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'I', NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'R',NVL(a.EX_APPROVED_DAYS_LIMIT_TYPE,'U'),'U'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_REQ_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_REQ_YN,'N'),'I',NVL(a.IP_CRED_AUTH_REQ_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_REQ_YN,'N'),'R',NVL(a.EX_CRED_AUTH_REQ_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'E',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'I',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'D',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'R',NVL(a.EX_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'I',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'R',NVL(a.EX_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'N') FROM BL_INS_POLICY_TYPE_HDR a WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+policy_type_code+"' AND a.CUST_CODE = '**' and a.cust_group_code ='"+cust_group_code+"'";

				pstmt = con.prepareStatement(restrict_check_sql);
				rs=pstmt.executeQuery();
				if( rs != null ) 
				{
					while(rs.next())
					{
						restrict_check=rs.getString(1);
						apprd_amt_restrict_check = rs.getString(2); 
						apprd_days_restrict_check = rs.getString(3); 
						cred_auth_req_yn = rs.getString(4); 
						dflt_auth_ref_as_pol_no_yn = rs.getString(5); 
						cred_auth_mand_capt_yn = rs.getString(6);
					}
				}
				if (rs != null)   rs.close();
				pstmt.close();
			}
		}
		catch(Exception e)
		{
			out.println("Exception in restrict_check_sql:"+e);
		}
	}
	if(restrict_check==null || restrict_check.equals("")) restrict_check="U";
	if(apprd_amt_restrict_check==null || apprd_amt_restrict_check.equals("")) apprd_amt_restrict_check="U";
	if(apprd_days_restrict_check==null || apprd_days_restrict_check.equals("")) apprd_days_restrict_check="U";
	if(cred_auth_req_yn==null || cred_auth_req_yn.equals("")) cred_auth_req_yn="N";
	if(cred_auth_mand_capt_yn == null || cred_auth_mand_capt_yn.equals("")) cred_auth_mand_capt_yn="N";
	if(dflt_auth_ref_as_pol_no_yn==null || dflt_auth_ref_as_pol_no_yn.equals("")) dflt_auth_ref_as_pol_no_yn="N";

	if(restrict_check.equals("R"))
	{
		restricted_YN="";
		
		if(apprd_amt_restrict_check.equals("U"))
		{
			v_display_hide_apprvd_amt = "display:none";
			credit_apprd_amt="";
		}

		if(apprd_days_restrict_check.equals("U"))
		{
			v_display_hide_apprvd_days = "display:none";
			credit_apprd_days="";
		}
	}
	else if(restrict_check.equals("U"))
	{
		restricted_YN="DISABLED";
		v_display_hide="display:none";
		v_display_hide_apprvd_amt = "display:none";
		v_display_hide_apprvd_days = "display:none";
		credit_apprd_amt="";
		credit_apprd_days="";
	}
	if(cred_auth_req_yn.equals("Y"))
	{
		v_display_hide_cred_auth = "display:inline";
		if(cred_auth_mand_capt_yn.equals("Y"))
		{
			v_credit_auth_val_mand = "display:inline";
		}
		else
		{
			v_credit_auth_val_mand = "display:none";
		}
/*		if(dflt_auth_ref_as_pol_no_yn.equals("Y"))
		{
			if(!policy_no.equals("") && credit_auth_ref.equals(""))
			{
				int policy_no_len = policy_no.length();
				if(policy_no_len <=20 )
					credit_auth_ref = policy_no.substring(0,policy_no_len);
				else
					credit_auth_ref = policy_no.substring(0,20);
			}
		}
		if(credit_auth_date.equals("") && !credit_auth_ref.equals(""))
		{
			credit_auth_date = encounter_date_aft_trunc;
		}
*/
	}
	else
	{
		v_display_hide_cred_auth = "display:none";
		v_credit_auth_val_mand = "display:none";
		credit_auth_ref = "";
		credit_auth_date = "";
	}

	if(modify_refresh.equals("Y"))
	{
		try
		{
			String sql_policy_coverage_basis_ind="SELECT a.POLICY_COVERAGE_BASIS FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+policy_type_code+"' AND a.CUST_GROUP_CODE = '"+cust_group_code+"' AND a.CUST_CODE = '"+cust_3+"' and b.cust_group_code = a.cust_group_code and a.cust_code = b.cust_code";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql_policy_coverage_basis_ind) ;

			String empty_sql_check="N";

			if( rs!= null ) 
			{
				empty_sql_check="Y";
				while( rs.next() )
				{  
					policy_coverage_basis_ind = rs.getString(1);
					empty_sql_check="N";
				}
			}
			if (rs != null)   rs.close();
			stmt.close();

			if(empty_sql_check.equals("Y"))
			{
				sql_policy_coverage_basis_ind="SELECT a.POLICY_COVERAGE_BASIS FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+policy_type_code+"' AND a.CUST_GROUP_CODE = '"+cust_group_code+"' AND a.CUST_CODE = '**' and b.cust_group_code = a.cust_group_code and b.cust_code='"+cust_3+"'";
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql_policy_coverage_basis_ind) ;

				if( rs!= null ) 
				{
					while( rs.next() )
					{  
						policy_coverage_basis_ind = rs.getString(1);
					}
				}
				if (rs != null)   rs.close();
				stmt.close();
			}
		}		
		catch(Exception e)
		{
			out.println("Exception in sql_policy_coverage_basis_ind:"+e);
		}
	}

	if(!credit_apprd_days.equals("") && !policy_eff_frm_date.equals("") && apprd_days_restrict_check.equals("R"))
	{
		if(!pol_validity_chk_date.equals(""))
		{
			if(!modify_refresh.equals("Y"))
				pol_validity_chk_date=com.ehis.util.DateUtils.convertDate(pol_validity_chk_date,"DMY","en",locale);
		}
	}

	if(!cust_3.equals(""))
	{
		try
		{
			pstmt = con.prepareStatement( " select currency_code,currency_desc from ar_customer_lang_vw where cust_code='"+cust_3+"' and language_id='"+locale+"'");
						
			rs1 = pstmt.executeQuery();	
			if ( rs1.next() && rs1 != null ) 
			{
				str_ins_cust_curr_code  =  rs1.getString(1);
				str_ins_cust_curr_desc  =  rs1.getString(2);	
			}
			if(str_ins_cust_curr_code == null) str_ins_cust_curr_code ="";		
			if(str_ins_cust_curr_desc == null) str_ins_cust_curr_desc="";		
			if (rs1 != null)   rs1.close();
			if (pstmt != null) pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("5="+e.toString());
		}
	}

	
	//Added by Niveditha NMC-JD-CRF-0054.1
	
	String protocol_Link_Id="HSWITCHPL";
	String mpmastermodule ="MP";
	List<String> oHistTypeList= new ArrayList<String>();
	List<String> types= new ArrayList<String>();
	String DebugYNProtocolLinkId = StringUtils.EMPTY;	
		
	XHUtil ProtocolLinkID = new XHUtil();
	XHCustomerGroup custGroupDetails = new XHCustomerGroup(); 
	XHPatientDetailsBean CustomerGroupPatDetails = null;
	XHCustomerGroupBean CustomerGroupDetails = null;

	if (patient_id.length()>0){
		CustomerGroupPatDetails = custGroupDetails.getPatientDetails(patient_id);
	}

	if (cust_group_code.length()>0){
		CustomerGroupDetails = custGroupDetails.getCustGroupDetails(cust_group_code);
	}
	
	XHMasterParamBean MasterParamDetails = custGroupDetails.getMasterParamDetails(mpmastermodule);

	String cg_patdet_patient_id=StringUtils.EMPTY, cg_patdet_national_id=StringUtils.EMPTY, cg_patdet_alt_id1_type=StringUtils.EMPTY, cg_patdet_alt_id1_no=StringUtils.EMPTY, cg_patdet_alt_id2_type=StringUtils.EMPTY, 
	cg_patdet_alt_id2_no=StringUtils.EMPTY, cg_patdet_alt_id3_type=StringUtils.EMPTY, cg_patdet_alt_id3_no=StringUtils.EMPTY, cg_patdet_alt_id4_type=StringUtils.EMPTY, cg_patdet_alt_id4_no=StringUtils.EMPTY, cg_patdet_oth_altid_type=StringUtils.EMPTY, cg_patdet_oth_altid_no=StringUtils.EMPTY; 
	
	String cg_det_cust_group_code=StringUtils.EMPTY, cg_det_op_interface=StringUtils.EMPTY, cg_det_em_interface=StringUtils.EMPTY, cg_det_ip_interface=StringUtils.EMPTY, cg_det_dc_interface=StringUtils.EMPTY, cg_det_natid_flag=StringUtils.EMPTY, cg_det_altid1=StringUtils.EMPTY, cg_det_altid2=StringUtils.EMPTY, cg_det_altid3=StringUtils.EMPTY, cg_det_altid4=StringUtils.EMPTY, cg_det_altid5=StringUtils.EMPTY, cg_det_membshpid_flag=StringUtils.EMPTY, cg_det_visitreg_flag=StringUtils.EMPTY, cg_det_policyno_flag=StringUtils.EMPTY;
	
	String mp_det_altid1=StringUtils.EMPTY, mp_det_altid2=StringUtils.EMPTY, mp_det_altid3=StringUtils.EMPTY, mp_det_altid4=StringUtils.EMPTY, citizen_flag=StringUtils.EMPTY;
	
	
	try {
	
	 
		DebugYNProtocolLinkId = ProtocolLinkID.FetchProtocollinkMethod(protocol_Link_Id);
		
		if (patient_id.length()>0){		
			cg_patdet_patient_id = CustomerGroupPatDetails.getPatientId();
			cg_patdet_national_id = CustomerGroupPatDetails.getNationalId();
			cg_patdet_alt_id1_type = CustomerGroupPatDetails.getAltId1Type();
			cg_patdet_alt_id1_no = CustomerGroupPatDetails.getAltId1No();
			cg_patdet_alt_id2_type = CustomerGroupPatDetails.getAltId2Type();
			cg_patdet_alt_id2_no = CustomerGroupPatDetails.getAltId2No();
			cg_patdet_alt_id3_type = CustomerGroupPatDetails.getAltId3Type();
			cg_patdet_alt_id3_no = CustomerGroupPatDetails.getAltId3No();
			cg_patdet_alt_id4_type = CustomerGroupPatDetails.getAltId4Type();
			cg_patdet_alt_id4_no = CustomerGroupPatDetails.getAltId4No();
			cg_patdet_oth_altid_type = CustomerGroupPatDetails.getOthAltIdType();
			cg_patdet_oth_altid_no = CustomerGroupPatDetails.getOthAltIdNo();
		}

		if("Y".equals(DebugYNProtocolLinkId)){
			System.out.println("Modify Financial Details Patient ID ::::"+cg_patdet_patient_id);
			System.out.println("Modify Financial Details Nationality ID ::::"+cg_patdet_national_id);
			System.out.println("Modify Financial Details Alternative ID One Type ::::"+cg_patdet_alt_id1_type);
			System.out.println("Modify Financial Details Alternative ID One No ::::"+cg_patdet_alt_id1_no);
			System.out.println("Modify Financial Details Alternative ID Two Type ::::"+cg_patdet_alt_id2_type);
			System.out.println("Modify Financial Details Alternative ID Two No ::::"+cg_patdet_alt_id2_no);
			System.out.println("Modify Financial Details Alternative ID Three Type ::::"+cg_patdet_alt_id3_type);
			System.out.println("Modify Financial Details Alternative ID Three No ::::"+cg_patdet_alt_id3_no);
			System.out.println("Modify Financial Details Alternative ID Four Type ::::"+cg_patdet_alt_id4_type);
			System.out.println("Modify Financial Details Alternative ID Four No ::::"+cg_patdet_alt_id4_no);
			System.out.println("Modify Financial Details Alternative ID Five No ::::"+cg_patdet_oth_altid_type);
			System.out.println("Modify Financial Details Alternative ID Five No ::::"+cg_patdet_oth_altid_no);
		}
		
		if (cust_group_code.length()>0){

			cg_det_cust_group_code = CustomerGroupDetails.getCustGroupCode();
			cg_det_op_interface = CustomerGroupDetails.getOpInterface();
			cg_det_em_interface = CustomerGroupDetails.getEmInterface();
			cg_det_ip_interface = CustomerGroupDetails.getIpInterface();
			cg_det_dc_interface = CustomerGroupDetails.getDcInterface();
			cg_det_natid_flag = CustomerGroupDetails.getNationalIdFlag();
			cg_det_altid1 = CustomerGroupDetails.getAltId1();
			cg_det_altid2 = CustomerGroupDetails.getAltId2();
			cg_det_altid3 = CustomerGroupDetails.getAltId3();
			cg_det_altid4 = CustomerGroupDetails.getAltId4();
			cg_det_altid5 = CustomerGroupDetails.getAltId5();
			cg_det_membshpid_flag = CustomerGroupDetails.getMembshpIdFlag();
			cg_det_visitreg_flag = CustomerGroupDetails.getVisitRegFlag();
			cg_det_policyno_flag = CustomerGroupDetails.getPolicyNoFlag();
		
		}
		
		if("Y".equals(DebugYNProtocolLinkId)){
			System.out.println("Modify Financial Details Customer Group Code ::::"+cg_det_cust_group_code);
			System.out.println("Modify Financial Details Outpatient Management Interface Flag ::::"+cg_det_op_interface);
			System.out.println("Modify Financial Details Emergency Management Interface Flag ::::"+cg_det_em_interface);
			System.out.println("Modify Financial Details Inpatient Management Interface Flag ::::"+cg_det_ip_interface);
			System.out.println("Modify Financial Details Day Care Interface Flag ::::"+cg_det_dc_interface);
			System.out.println("Modify Financial Details Nationality ID Flag ::::"+cg_det_natid_flag);
			System.out.println("Modify Financial Details Alternative ID One Flag ::::"+cg_det_altid1);
			System.out.println("Modify Financial Details Alternative ID Two Flag ::::"+cg_det_altid2);
			System.out.println("Modify Financial Details Alternative ID Three Flag ::::"+cg_det_altid3);
			System.out.println("Modify Financial Details Alternative ID Four Flag ::::"+cg_det_altid4);
			System.out.println("Modify Financial Details Alternative ID Five Flag ::::"+cg_det_altid5);
			System.out.println("Modify Financial Details Membership ID Flag ::::"+cg_det_membshpid_flag);
			System.out.println("Modify Financial Details Visit Registration Flag ::::"+cg_det_visitreg_flag);
			System.out.println("Modify Financial Details Policy Number Flag ::::"+cg_det_policyno_flag);
		}
		
		
		mp_det_altid1 = MasterParamDetails.getAltId1TypeName();
		mp_det_altid2 = MasterParamDetails.getAltId2TypeName();
		mp_det_altid3 = MasterParamDetails.getAltId3TypeName();
		mp_det_altid4 = MasterParamDetails.getAltId4TypeName();

		if("Y".equals(DebugYNProtocolLinkId)){
			System.out.println("Modify Financial Details Master Patient Parameter :::: Alternative ID One ::::"+mp_det_altid1);
			System.out.println("Modify Financial Details Master Patient Parameter :::: Alternative ID Two ::::"+mp_det_altid2);
			System.out.println("Modify Financial Details Master Patient Parameter :::: Alternative ID Three ::::"+mp_det_altid3);
			System.out.println("Modify Financial Details Master Patient Parameter :::: Alternative ID Four ::::"+mp_det_altid4);
		}
	
		types.add(mp_det_altid1);
		types.add(mp_det_altid2);
		types.add(mp_det_altid3);
		types.add(mp_det_altid4);
	
		oHistTypeList = custGroupDetails.getDescriptionForKey(types);
		
		citizen_flag = custGroupDetails.getCitizen(patient_id);
		
		if("Y".equals(DebugYNProtocolLinkId)){
			System.out.println("Modify Financial Details Patient Citizen Flag ::::"+citizen_flag);
		}
		
		
	}
	catch(Exception e){
		e.printStackTrace();
	}


	try
	{	
%>
<head>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script language='javascript' src='../../eBL/js/AddModifyPatFinDetails.js'></script>
<script Language='javaScript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language="javascript" src='../../eBL/js/AddModifyPatFinDetailsInsBodyPkgApprvDtls.js'></script> 
<script language='javascript' src='../../eXH/js/ExternalApplication.js'></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</head>
<script>
async function callPolicyDetails(count){

	var dialogHeight= "34" ;
	var dialogWidth	= "84" ;													   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; ";
	var arguments	= "" ;	
		
	var payerGroup=document.add_modify_pat_fin_det_ins_bodyedit.ins_cust_group_code.value;
	var payerCode=document.add_modify_pat_fin_det_ins_bodyedit.cust_3.value;
	var policy=document.add_modify_pat_fin_det_ins_bodyedit.policy_type_code.value;	
	if(payerGroup==""|| payerCode=="" || policy==""){
		return;
	}
	var startDate=document.add_modify_pat_fin_det_ins_bodyedit.policy_start_date.value;	
	var endDate=document.add_modify_pat_fin_det_ins_bodyedit.policy_exp_date.value;	
	var priority=document.add_modify_pat_fin_det_ins_bodyedit.priority.value;
	var policyNo=document.add_modify_pat_fin_det_ins_bodyedit.policy_no.value;
	var episodeType=document.add_modify_pat_fin_det_ins_bodyedit.episode_type.value;
	//alert("details>>>"+payerGroup+"/"+payerCode+"/"+policy+"/"+startDate+"/"+endDate+"/"+priority+"/"+policyNo+"/"+episodeType);

	// Patient Id Parameter is passed as null to get Policy Details, If patient_id,episode_id,visit_id,acctseq  is given then Encounter specific Policy Defn will be Loaded
	var queryParams='mode=modify&patinetId=&payergroupCode='+ payerGroup  +
	'&payerCode='+payerCode+'&policyCode='+policy+'&startDate='+startDate+'&endDate='+endDate+'&visitId='+'&acctSeq=&priority='+priority+
	'&policyNo='+policyNo+'&episodeType='+episodeType+'&episodeId='+'&auth=N';
		
	var retVal =await window.showModalDialog('../../eBL/jsp/RcrdApprovalPolicyDefinitionMainFrame.jsp?'+queryParams,arguments,features);
}
// 08/07/2013	Karthikeyan K	MMS-QH-CRF-0010	36789 starts-->
function validAcrossEncounters(){

	var pyrGrp=document.forms[0].ins_cust_group_code.value;
	var pyr=document.forms[0].cust_3.value;
	var pcyCd =document.forms[0].policy_type_code.value;
	var patClass=document.forms[0].p_patient_class.value;
	var patient_id=document.forms[0].patient_id.value;
	var across_encounter=document.forms[0].acrossEncounter.value;
	var priority=document.forms[0].priority.value;
	var facility_id=document.forms[0].facility_id.value;
	//alert('across_encounter:priority'+across_encounter+priority);
	if(pyrGrp!='' && pyr!='' & pcyCd!=''){
	var xmlhttp; 
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  //xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  xmlHttp = new XMLHttpRequest();
	  }

	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {

		var response=xmlhttp.responseText;
		var validAcrossEnc = response.substring(response.indexOf("~")+1,response.indexOf("~")+2);

		if(validAcrossEnc=='Y'){
		document.getElementById('across_encounter_link').disabled = false; 
		}else{
		document.getElementById('across_encounter_link').disabled = true; 
		}
	    }
	  }

	xmlhttp.open("POST","BLInsuranceValidations.jsp?called_from=chk_validity_across_encounters&cust_group_code="+pyrGrp+"&cust_code="+pyr+"&policy_type_code="+pcyCd+"&patClass="+patClass+"&patient_id="+patient_id+"&across_encounter="+across_encounter+"&priority="+priority+"&facility_id="+facility_id,true);
	xmlhttp.send(null);
	}
}

async function acrossEncountersLink(){
	var pyrGrp=document.forms[0].ins_cust_group_code.value;
	var pyr=document.forms[0].cust_3.value;
	var pcyCd =document.forms[0].policy_type_code.value;
	var ins_cust_group_name =document.forms[0].ins_cust_group_name.value;
	var payer_desc =document.forms[0].payer_desc.value;
	var policy_type_desc =document.forms[0].policy_type_desc.value;
	var patient_id =document.forms[0].patient_id.value;
	var patClass=document.forms[0].p_patient_class.value;
	var  encGrpId=document.forms[0].acrossEncounter.value;
	var priority = document.forms[0].priority.value;
	/*
	var dialogUrl = "../../eBL/jsp/BLPolicyValidAcrossEncounters.jsp?title=Policy Across Encounters&cust_group_code="+pyrGrp+"&cust_code="+pyr+"&policy_type_code="+pcyCd+"&ins_cust_group_name="+ins_cust_group_name+"&payer_desc="+payer_desc+"&policy_type_desc="+policy_type_desc+"&patient_id="+patient_id+"&patClass="+patClass;
	
	*/
	
	var dialogUrl       = "../../eBL/jsp/EncounterSpecAcrossEncounter.jsp?title=Across Encounters"+
	"&payerGroup="+pyrGrp+"&payer="+pyr+"&policy="+pcyCd+"&episodeType="+patClass+
	"&encGrpId="+encGrpId+"&patientId="+patient_id+"&priority="+priority;
	
	
	var dialogFeatures  = "dialogHeight:" + "20" + "; dialogWidth:" + "50" +" ; scroll=auto; ";
	 
	var  returnVal =await window.showModalDialog(dialogUrl,'Across Encounters',dialogFeatures);
	
	//alert('returnValue '+returnVal);
	if(returnVal != 'undefined' && returnVal != 'null' && returnVal != undefined && returnVal != null)
	document.forms[0].acrossEncounter.value=returnVal;
	//alert(document.forms[0].acrossEncounter.value);
}
<!-- 08/07/2013	Karthikeyan K	MMS-QH-CRF-0010	36789 ends-->
async function callPolicy(plcyEnctr,plcyEpisdid,patntId,epsdType,vistId,acseq,plcyno){ // karthik added code INCLUDE_POLICY_DETAILS_CRF
	
	/* Karthik added the below Function to Authenticated User to check User Credentials to modify Policy  - Starts */
	if(doUserAuthenticationValidationMain(document.forms[0].login_user.value)==true)
	{
		await callPolicyLink(plcyEnctr,plcyEpisdid,patntId,epsdType,vistId,acseq,plcyno);
	}else{
		
		var dialogHeight= "14" ;
		var dialogWidth	= "22" ;
		var dialogTop = "225" ;
		var center = "1" ;														   
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;			
		
		var retVal =await window.showModalDialog("../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp",arguments,features);
		var successfulUser=retVal[3];

		if(doUserAuthenticationValidationMain(successfulUser)==true){
			await callPolicyLink(plcyEnctr,plcyEpisdid,patntId,epsdType,vistId,acseq,plcyno);
		}else{
			alert("User "+successfulUser+" dont have permissions to Add/Modify Payer");
		}
		
	}
	/* Karthik added the below Function to Authenticated User to check User Credentials to modify Policy  - Ends */
}

function callPolicyLink(plcyEnctr,plcyEpisdid,patntId,epsdType,vistId,acseq,plcyno){
	var pyrGrp=document.forms[0].ins_cust_group_code.value;
	var pyr=document.forms[0].cust_3.value;
	var pcyCd=document.forms[0].policy_type_code.value;
	var pcyNo=document.forms[0].policy_no.value;
	var priority=document.forms[0].priority.value;
	var policy_start_date=document.forms[0].policy_start_date.value;
	var policy_exp_date=document.forms[0].policy_exp_date.value;
	
	var policyOrEncounter= document.forms[0].plcyorEncounter.value;
//	alert(' policy or encounter ='+plcyEnctr+' episode id ='+plcyEpisdid);
	
	var dialogUrl = "../../eBL/jsp/PolicyDetailsResultFrame.jsp?"+
	"title=Policy Coverage Details"+
	"&startDate="+policy_start_date+
	"&endDate="+policy_exp_date+
	"&mode=modify"+
	"&facility_id="+'<%=facility_id%>'+
	"&payergroupCode="+pyrGrp+
	"&payerCode="+pyr+
	"&policyCode="+pcyCd+
	"&patientId="+patntId+
	"&visitId="+vistId+
	"&acctSeq="+acseq+
	"&priority="+priority+
	"&episodeType="+epsdType+
	"&episodeId="+plcyEpisdid+
	"&policyNo="+plcyno+
	"&policyEncounter="+policyOrEncounter+
	"&priorityKey="+priority+"~"+pyrGrp+"~"+pyr+"~"+pcyCd+"~"+pcyNo;

	//alert('dialog URL '+dialogUrl);
	
	
	var dialogFeatures  = "dialogHeight:" + "30" + "; dialogWidth:" + "75" +" ; scroll=auto; ";
	window.showModalDialog(dialogUrl,'Policy Details',dialogFeatures);		
}
function cancel()
{
//	parent.window.returnValue = "manivel";
	parent.window.close();
}

/*Added By Niveditha for NMC-JD-CRF-054.1*/
function eligibility_details(buttonVar){

	var customarray=new Array();
	<% 
		int i = 0;
		int combinedRecordCount = oHistTypeList.size(); 
		while (i < combinedRecordCount ) { 
			 String elementString = (String) oHistTypeList.get(i);
			 %>
			 customarray.push("<%=oHistTypeList.get(i)%>");
			 <%
			 i++; 
		}
	%>

	var alert_cg_det_natid_flag = document.getElementById("cg_det_natid_flag").value;
	var alert_cg_det_altid1 = document.getElementById("cg_det_altid1").value;
	var alert_cg_det_altid2 = document.getElementById("cg_det_altid2").value;
	var alert_cg_det_altid3 = document.getElementById("cg_det_altid3").value;
	var alert_cg_det_altid4 = document.getElementById("cg_det_altid4").value;
	var alert_cg_det_altid5 = document.getElementById("cg_det_altid5").value;
	var alert_cg_det_membshpid_flag = document.getElementById("cg_det_membshpid_flag").value;
	var alert_cg_det_policyno_flag = document.getElementById("cg_det_policyno_flag").value;
	
	var alert_cg_patdet_national_id = document.getElementById("cg_patdet_national_id").value;
	var alert_cg_patdet_alt_id1_type = document.getElementById("cg_patdet_alt_id1_type").value;
	var alert_cg_patdet_alt_id1_no = document.getElementById("cg_patdet_alt_id1_no").value;
	var alert_cg_patdet_alt_id2_type = document.getElementById("cg_patdet_alt_id2_type").value;
	var alert_cg_patdet_alt_id2_no = document.getElementById("cg_patdet_alt_id2_no").value;
	var alert_cg_patdet_alt_id3_type = document.getElementById("cg_patdet_alt_id3_type").value;
	var alert_cg_patdet_alt_id3_no = document.getElementById("cg_patdet_alt_id3_no").value;
	var alert_cg_patdet_alt_id4_type = document.getElementById("cg_patdet_alt_id4_type").value;
	var alert_cg_patdet_alt_id4_no = document.getElementById("cg_patdet_alt_id4_no").value;
	var alert_cg_patdet_oth_altid_type = document.getElementById("cg_patdet_oth_altid_type").value;
	var alert_cg_patdet_oth_altid_no = document.getElementById("cg_patdet_oth_altid_no").value;
	
	var alert_citizen_flag = document.getElementById("citizen_flag").value;

    var strModuleId = document.forms[0].calling_module_id.value;

	
	var alert_text = "";

	if (buttonVar == "EC")	
		alert_text="For Eligibility check requirements, kindly enter the required fields listed here.";
	else
		alert_text="For data requirements, kindly enter the required fields listed here.";

	var alert_variables="";
	
	if(alert_citizen_flag=='Y'){
		if(alert_cg_det_natid_flag=='Y' && !(alert_cg_patdet_national_id.length > 0) && (strModuleId!="MP")){
			alert_variables = "Nationality ID";
		}
	}
	
	if(alert_citizen_flag != 'Y'){	
		
		if(alert_cg_det_altid1=='Y' && !(alert_cg_patdet_alt_id1_no.length > 0) && (strModuleId!="MP")){
			if (alert_variables.length > 0)
				alert_variables += "\n";
			
			alert_variables += customarray[0];	
		}
		if(alert_cg_det_altid2=='Y' && !(alert_cg_patdet_alt_id2_no.length > 0) && (strModuleId!="MP")){
			if (alert_variables.length > 0)
				alert_variables += "\n";

			alert_variables += customarray[1];	
		}
		if(alert_cg_det_altid3=='Y' && !(alert_cg_patdet_alt_id3_no.length > 0) && (strModuleId!="MP")){
			if (alert_variables.length > 0)
				alert_variables += "\n";

				alert_variables += customarray[2];	
		}
		if(alert_cg_det_altid4=='Y' && !(alert_cg_patdet_alt_id4_no.length > 0) && (strModuleId!="MP")){
			if (alert_variables.length > 0)
				alert_variables += "\n";

				alert_variables += customarray[3];	
		}

		if (alert_cg_det_altid5.length>0 && (alert_cg_det_altid5!='N')) // Whether Alternate ID 5 is configured
		{
			if ((alert_cg_patdet_oth_altid_type.length > 0) && (alert_cg_patdet_oth_altid_no.length>0) &&(strModuleId!="MP")) // Patient other alternate id is captured
			{
				if (!(alert_cg_patdet_oth_altid_type == alert_cg_det_altid5)) //Whether the same other alternate id is configured as mandatory
				{
					if (alert_variables.length > 0)
					alert_variables += "\n";

					alert_variables += "Other Alternative ID - "+alert_cg_det_altid5;	
				}
			}

			if (!(alert_cg_patdet_oth_altid_no.length>0) &&(strModuleId!="MP")) // Patient other alternate id is not captured
			{			
				if (alert_variables.length > 0)
				alert_variables += "\n";

				alert_variables += "Other Alternative ID - "+alert_cg_det_altid5;				
			}
		}
	}
	
	var membershipId = document.forms[0].membershipId.value;  
	membershipId = $.trim(membershipId);

	if(alert_cg_det_membshpid_flag=='Y' && !(membershipId.length > 0))
	{
		if (alert_variables.length > 0)
			alert_variables += "\n";

		alert_variables += "Membership ID";
	}

	var alert_policy_no=document.forms[0].policy_no.value;
	if(alert_cg_det_policyno_flag=='Y' && !(alert_policy_no.length > 0))
	{
		if (alert_variables.length > 0)
			alert_variables += "\n";

		alert_variables += "Policy Number";
	}

	
	if(alert_variables != "" && alert_variables != null && alert_variables != 'undefined'){
		alert(alert_text +"\n"+ alert_variables);
		return false;
	}else{
		return true;
	}
}


/*Added By Niveditha for NMC-JD-CRF-054.1*/
async function getChangePatientDetails(patient_id){
	var dialogHeight = '42.5';
	var dialogWidth = '64';
	var wintop = '65';
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +  '; dialogTop: ' + wintop +';status=no';
	var arguments = '';
	var retVal = '';

	var param = "../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&called_from_newborn=N&module_id=MP&function_id=CHG_PAT_DTLS&function_name=Change Patient Details&function_type=F&home_required_yn=N&access=NYNNN&Patient_ID="+patient_id;
	
	var retVal =await window.showModalDialog(param,arguments,features);
	if(retVal == true){

		$.ajax({	
			url:"../../eBL/jsp/BLInterfaceValidations.jsp",
			type:"GET",
			dataType:"text",
			data:{
				 method:'PatientDetails',
				 patientid:patient_id
			},
			async:false,
			success:function(data){
				patientData = data;
				patientData = patientData.replace("<script>","");
				patientData = patientData.replace("var localeName = \"en\";","");
				patientData = patientData.replace("<\/script>","");
				patientData = trimStr(patientData);
				patientData = jQuery.parseJSON(patientData);
				
				$("#cg_patdet_national_id").val(patientData.nationality_id);
				$("#cg_patdet_alt_id1_type").val(patientData.alt_id1_type);
				$("#cg_patdet_alt_id1_no").val(patientData.alt_id1_no);
				$("#cg_patdet_alt_id2_type").val(patientData.alt_id2_type);
				$("#cg_patdet_alt_id2_no").val(patientData.alt_id2_no);
				$("#cg_patdet_alt_id3_type").val(patientData.alt_id3_type);
				$("#cg_patdet_alt_id3_no").val(patientData.alt_id3_no);
				$("#cg_patdet_alt_id4_type").val(patientData.alt_id4_type);
				$("#cg_patdet_alt_id4_no").val(patientData.alt_id4_no);
				$("#cg_patdet_oth_altid_type").val(patientData.alt_oth_id_type);
				$("#cg_patdet_oth_altid_no").val(patientData.alt_oth_id_no);
				$("#citizen_flag").val(patientData.citizen_flag);
				
				}	
			});

		window.location.reload();	
	}
	if(retVal == undefined || retVal == true) {
		changeToolBar();
	} 


}

function trimStr(str) {
  return str.replace(/^\s+|\s+$/g, '');
}


 
	
//Added by Prithivi on 08/12/2016 for MMS-QH-CRF-0085


function payerEligibilityCheck(buttonVar)
{
	/*Added By Niveditha for NMC-JD-CRF-054.1*/
	if(eligibility_details(buttonVar)==false){
		return false;
	}
	
	
	
/*<PATIENT_ID>#PatientId$!^<ENCOUNTER_ID>$!^<NATIONAL_ID>#NationalId$!^<PATIENT_NAME>#PatientName$!^<PATIENT_DOB>#PatientDOB$!^<MOBILE_NO>#PatientMobileNO$!^<MEMBERSHIP_NO>#MembershipNO$!^<POLICY_HOLDER_NAME>#PolicyHolderName$!^<POLICY_PLAN_NO>#PolicyNO$!^<PROVIDER_CODE>#ProviderCode$!^<SERVICE_TYPE>#ServiceCode$!^<PAYER_CODE>#PayerCode$!^<FACILITY_ID>#FacilityId$!^<LOGGED_IN_USER_ID>#Username$!^<LOGGED_IN_WSNO>#strWsNo$!^<SESSION>REGVISIT */
	
   var dataElements = "<PATIENT_ID>#PatientId$!^<ENCOUNTER_ID>$!^<NATIONAL_ID>#NationalId$!^<PATIENT_NAME>#PatientName$!^<PATIENT_DOB>#PatientDOB$!^<MOBILE_NO>#PatientMobileNO$!^<MEMBERSHIP_NO>#MembershipNO$!^<POLICY_HOLDER_NAME>#PolicyHolderName$!^<POLICY_PLAN_NO>#PolicyNO$!^<PROVIDER_CODE>#ProviderCode$!^<SERVICE_TYPE>#ServiceCode$!^<PAYER_CODE>#PayerCode$!^<FACILITY_ID>#FacilityId$!^<LOGGED_IN_USER_ID>#Username$!^<LOGGED_IN_WSNO>#strWsNo$!^<SESSION>REGVISIT$!^<REQUEST_TYPE>#RequestType$!^<TRANS_NO>#TransNo";

   var userName = document.forms[0].login_user.value;  // username =  login user -- mandatory
   var cust_3=document.forms[0].cust_3.value;        // payer_code -- mandatory
   var policy_no=document.forms[0].policy_no.value;  // policy_plan_no
   var ins_cust_group_code=document.forms[0].ins_cust_group_code.value;  // provider_code --mandatory
   var membershipId = document.forms[0].membershipId.value;   // membership no --mandatory
   var service_code = document.forms[0].service_code.value;   // service_code --mandatory
   var clinic_code = document.forms[0].clinic_code.value;   // service_code --mandatory
   //Added by Sethu for MMS-QH-CRF-0085 ON 18/11/2019
   var nursing_unit_code = document.forms[0].nursing_unit_code.value;   // service_code --mandatory
   var strWsNo = document.forms[0].strWsNo.value;

   // for mandatory fields
   var cust_group_name=document.forms[0].ins_cust_group_name.value;
   var payer_desc=document.forms[0].payer_desc.value;
   var patient_id = document.forms[0].patient_id.value;

   var facility_id = document.forms[0].facility_id.value;
   var strModuleId = document.forms[0].calling_module_id.value;

	var trans_no = document.forms[0].transaction_id.value; //Added by Apoorva for MOHE-CRF-0020
  
 
	/*
	if(service_code=="" || service_code=="")
	{
		alert("Service Type is required for eligibility check ");
		return false;
	}
	*/

   
	if(strModuleId=="OP" || strModuleId=="AE") 
	{
		clinic_code = $.trim(clinic_code);
		if(!(clinic_code.length > 0))
		{
			alert("Clinic/Location cannot be blank ");
			return false;
		}
	}

	 //Added by Sethu for MMS-QH-CRF-0085 ON 18/11/2019

	if(strModuleId=="IP" || strModuleId=="DC") 
	{
		nursing_unit_code = $.trim(nursing_unit_code);
		if(!(nursing_unit_code.length > 0))
		{
			alert("Nursing Unit cannot be blank ");
			return false;
		}
	}
   
   cust_group_name = $.trim(cust_group_name);
   ins_cust_group_code = $.trim(ins_cust_group_code);
	if(!(cust_group_name.length > 0) || !(ins_cust_group_code.length > 0))
	{
		alert(getMessage("BL6277","BL"));
		document.forms[0].ins_cust_group_name.focus();
		return false;
	}
	payer_desc = $.trim(payer_desc);
	cust_3 = $.trim(cust_3);
	if(!(payer_desc.length > 0) || !(cust_3.length > 0))
	{
		alert(getMessage("BL9532","BL"));
		document.forms[0].payer_desc.focus();
		return false;
	}
	
	
	membershipId = $.trim(membershipId);
	//Commented by Muthu for Eligibility Check Mandatory validation for Membership ID field.
	/*
	
	if(!(membershipId.length > 0))
	{		
		alert("Membership Id cannot be blank ");
		document.forms[0].membershipId.focus();
		return false;
	}
	*/
  
	dataElements = dataElements.replace("#Username", userName); 
	dataElements = dataElements.replace("#PayerCode", cust_3);
	dataElements = dataElements.replace("#ProviderCode", ins_cust_group_code);
	dataElements = dataElements.replace("#MembershipNO", membershipId);
	dataElements = dataElements.replace("#PolicyNO", policy_no);
	dataElements = dataElements.replace("#FacilityId", facility_id);
	 //Added by Sethu for MMS-QH-CRF-0085 ON 18/11/2019

	//Added by Apoorva for MOHE-CRF-0020
	if (buttonVar == "CS"){
		dataElements = dataElements.replace("#RequestType", "CHECKSTATUS");
   	}
	else
	{
		dataElements = dataElements.replace("#RequestType", "CHECK_ELIGIBILITY");
	}
	
	dataElements = dataElements.replace("#TransNo", trans_no);


	

	if(strModuleId=="IP" || strModuleId=="AE") 
	{
		dataElements = dataElements.replace("#ServiceCode", nursing_unit_code);
	}
	else if(strModuleId=="OP" || strModuleId=="DC") 
	{
		dataElements = dataElements.replace("#ServiceCode", clinic_code);
	}

	//Added by Apoorva for MOHE-CRF-0020 ends here
	
	dataElements = dataElements.replace("#strWsNo", strWsNo);

	//alert("dataElements after 1st replace...."+dataElements);
	//This fun is available in eXH/js/ExternalApplication.js 
	var response = checkPatientMembershipEligibility(dataElements,patient_id);
	//alert("final response from interface...."+response);
	 //response = "S$!^SUCCESS$!^12345$!^4/06/2017 23:59:59$!^1$!^1$!^4693745283445228247$!^Member is eligible and can be treated!$!^ResponseCode desc$!^Validity period desc$!^Y"; 
	 //response = "S$!^SUCCESS$!^10000021$!^11/05/2017 08:56:20$!^1$!^0$!^$!^9 : Field RD[7] Membership Number cann't be more than 7 or 8 digits$!^1 - Invalid$!^";	
	 
	 if(response.indexOf("$!^") != -1) {
	   
	   //S$!^SUCCESS$!^TransactionID$!^ResponseDateTime$!^ResponseCode$!^ValidityType$!^EligibilityCode$!^ErrorMessage$!^Remarks
       
	   var responseArr = response.split("$!^");

	   if(responseArr[0]=="S")
		{
		   document.forms[0].response_code.value=responseArr[4];
		  /*  if(responseArr[4]=="1")
		   {
			  document.forms[0].response_code_desc.value = "1-Invalid";
		   }
		   else if(responseArr[4]=="2")
		   {
			  document.forms[0].response_code_desc.value = "2-Valid";
		   }
		   else if(responseArr[4]=="3")
		   {
			  document.forms[0].response_code_desc.value = "3-Additional Information Required";
		   }
		   else if(responseArr[4]=="4")
		   {
			  document.forms[0].response_code_desc.value = "4-Error";
		   }

           */

		   document.forms[0].response_code_desc.value = responseArr[8];
		   document.forms[0].response_code_desc_val.value = responseArr[8]; // hidden values for maintaining in session
		   document.forms[0].status_description.value=responseArr[7];
		   document.forms[0].status_desc_text.value=responseArr[7];

		   document.forms[0].validity_period_desc.value=responseArr[9];
		   document.forms[0].validity_period_desc_val.value=responseArr[9];
		   document.forms[0].validity_period.value=responseArr[5];

		   document.forms[0].eligibility_code_desc.value=responseArr[6];
		   document.forms[0].eligibility_code.value=responseArr[6];

		   document.forms[0].transaction_id.value=responseArr[2];
		   document.forms[0].response_date_time.value=responseArr[3];

		   document.forms[0].remarks.value=responseArr[8];
		   document.forms[0].errorMsg.value=responseArr[7];

		   document.forms[0].visitRegProcFlag.value = visitRegProcEnabledInterface(document.forms[0].ins_cust_group_code.value);

		   document.forms[0].payerEligibilityParam.value="1";

		}
		else
		{
			//0 will come
			document.forms[0].payerEligibilityParam.value="0";
			document.forms[0].transaction_id.value=responseArr[2];
			document.forms[0].response_code.value=responseArr[4];

            alert(responseArr[1]);
		}
   }
   else
	{
	   //0 will come
	   document.forms[0].payerEligibilityParam.value="0";
	   alert("Request Failed!!!      "+response);
	}

	trans_no = document.forms[0].transaction_id.value; //Added by Apoorva for MOHE-CRF-0020


	if(trans_no == "" || trans_no == null) 
	{
		if (document.getElementById("check_status") != null)
		document.getElementById("check_status").disabled = true; 

	}
	else
	{
		if (document.getElementById("check_status") != null)
		document.getElementById("check_status").disabled = false; 
	} 

}
	
function showCalendar_loc(Val1, Val2)
{	
	if (Val2.disabled == true)		
	{
		return false;
	}
	else
	{
		return showCalendar(Val1);
	}
}

function getValidationDetails(){

	var CustGroupConfig=checkCustomerGroupInterface(document.forms[0].ins_cust_group_code.value);

	CustGroupConfig = jQuery.parseJSON(CustGroupConfig);
	
	$("#cg_det_cust_group_code").val(CustGroupConfig.cust_group_code);
	$("#cg_det_op_interface").val(CustGroupConfig.op_interface_flag);
	$("#cg_det_em_interface").val(CustGroupConfig.em_interface_flag);
	$("#cg_det_ip_interface").val(CustGroupConfig.ip_interface_flag);
	$("#cg_det_dc_interface").val(CustGroupConfig.dc_interface_flag);
	$("#cg_det_natid_flag").val(CustGroupConfig.natid_flag);
	$("#cg_det_altid1").val(CustGroupConfig.altid1_flag);
	$("#cg_det_altid2").val(CustGroupConfig.altid2_flag);
	$("#cg_det_altid3").val(CustGroupConfig.altid3_flag);
	$("#cg_det_altid4").val(CustGroupConfig.altid4_flag);
	$("#cg_det_altid5").val(CustGroupConfig.altid5_flag);
	$("#cg_det_membshpid_flag").val(CustGroupConfig.membshpid_flag);
	$("#cg_det_visitreg_flag").val(CustGroupConfig.visitreg_flag);
	$("#cg_det_policyno_flag").val(CustGroupConfig.policyno_flag);

	op_interface_flag = CustGroupConfig.op_interface_flag;
	em_interface_flag = CustGroupConfig.em_interface_flag;
	ip_interface_flag = CustGroupConfig.ip_interface_flag;
	dc_interface_flag = CustGroupConfig.dc_interface_flag;

	membshpid_flag = CustGroupConfig.membshpid_flag;
	policyno_flag = CustGroupConfig.policyno_flag;

}

function checkValues(buttonVar)
{
	/*Added By Niveditha for NMC-JD-CRF-054.1*/
	if(eligibility_details(buttonVar)==false){
		return false;
	}
	
	
	var action=document.forms[0].action.value;
	var locn=document.forms[0].locn.value;
	var blng_grp_select="";
	if(action=="add" && locn=="outside")
	{
		blng_grp_select=document.forms[0].select_billing_group.value;
		if(blng_grp_select=="")
		{
			alert(getMessage("BL9301","BL"));
			document.forms[0].select_billing_group.focus();
			return false;
		}
	}
	var cust_group_name=document.forms[0].ins_cust_group_name.value;
	var payer_desc=document.forms[0].payer_desc.value;
	var priority=document.forms[0].priority.value;
	var policy_type_desc=document.forms[0].policy_type_desc.value;
	var policy_no=document.forms[0].policy_no.value;
//	if(!CheckChars_local(document.forms[0].policy_no))
	if(!CheckCharsAllLang_local(document.forms[0].policy_no))
	{
		alert(getMessage("CANNOT_BE_SPECIAL_CHAR","common"));
		document.forms[0].policy_no.select();
		return false;
	}
	var policy_start_date=document.forms[0].policy_start_date.value;
	var policy_exp_date=document.forms[0].policy_exp_date.value;
	var credit_auth_ref=document.forms[0].credit_auth_ref.value;
//	if(!CheckChars_local(document.forms[0].credit_auth_ref))
	if(!CheckCharsAllLang_local(document.forms[0].credit_auth_ref))
	{
		alert(getMessage("CANNOT_BE_SPECIAL_CHAR","common"));
		document.forms[0].credit_auth_ref.select();
		return false;
	}

	var credit_auth_date=document.forms[0].credit_auth_date.value;
	
	var cred_auth_req_yn = document.forms[0].cred_auth_req_yn.value;
	var cred_auth_mand_capt_yn = document.forms[0].cred_auth_mand_capt_yn.value;

	var credit_apprd_amt=document.forms[0].credit_apprd_amt.value;
	var credit_apprd_days=document.forms[0].credit_apprd_days.value;
	var policy_eff_frm_date=document.forms[0].policy_eff_frm_date.value;
	var policy_eff_to_date=document.forms[0].policy_eff_to_date.value;

	var modify_refresh=document.forms[0].modify_refresh.value;
	var restricted_YN=document.forms[0].restricted_YN.value;

	var restrict_check=document.forms[0].restrict_check.value;
	var apprd_amt_restrict_check=document.forms[0].apprd_amt_restrict_check.value;
	var apprd_days_restrict_check=document.forms[0].apprd_days_restrict_check.value;

	var valid_payer_YN=document.forms[0].valid_payer_YN.value;
	var payer_suspended_YN =document.forms[0].payer_suspended_YN.value;
	var valid_policy_type_code_YN=document.forms[0].valid_policy_type_code_YN.value;
	var policy_suspended_YN =document.forms[0].policy_suspended_YN.value;

	var ins_cust_group_code=document.forms[0].ins_cust_group_code.value;

	var blng_grp_curr_code = document.forms[0].curr_code_for_bg.value;
	var ins_cust_curr_code = document.forms[0].ins_cust_curr_code.value;
	var membershipId = document.forms[0].membershipId.value;//MMS-DM-CRF-0164.1
		
	//Added V190522-Aravindh/NMC-JD-CRF-0010/Starts
	if(document.forms[0].siteSpecPolApprv.value == "true" || document.forms[0].siteSpecPolApprv.value == true) {
		var validateApprovedPolicy = false;
		validateApprovedPolicy = validateApprovedPolicyYN(document.forms[0].ins_cust_group_code,document.forms[0].cust_3,document.forms[0].policy_type_code,document.forms[0].facility_id.value);
		if(validateApprovedPolicy != true) {
			alert(getMessage("BL0831","BL"));
			return false;
		}
	}
	//Added V190522-Aravindh/NMC-JD-CRF-0010/Ends

	var locale = document.forms[0].locale.value;
		if(policy_eff_frm_date!="")
		{
			if((validDate(policy_eff_frm_date,'DMY',locale)))
			{	
				if(isAfter(policy_eff_frm_date,policy_start_date,'DMY',locale))
			{
			}
				else
				{
					alert(getMessage("BL00964","BL"));
					document.forms[0].policy_eff_frm_date.focus();
					return false;
				}
			}
			else
			{
				alert(getMessage("INVALID_DATE_FMT","SM"));
				document.forms[0].policy_eff_frm_date.focus();
				return false;
			}
		}

	if(cust_group_name=="")
	{
		alert(getMessage("BL6277","BL"));
		document.forms[0].ins_cust_group_name.focus();
		return false;
	}

	if(payer_desc=="")
	{
		alert(getMessage("BL9532","BL"));
		document.forms[0].payer_desc.focus();
		return false;
	}
	
	if(priority=="")
	{
		alert(getMessage("BL9325","BL"));
		document.forms[0].priority.focus();
		return false;
	}
	if(parseInt(priority)==0)
	{
		alert(getMessage("BL9833","BL"));
		document.forms[0].priority.select();
		return false;
	}
	if(!chk_for_decimal(document.forms[0].priority))
	{
		return false;
	}

	if(policy_type_desc=="")
	{
		alert(getMessage("BL9103","BL"));	
		document.forms[0].policy_type_desc.focus();
		return false;
	}
	
	if(policy_start_date=="")
	{
		alert(getMessage("BL9324","BL"));
		document.forms[0].policy_start_date.focus();
		return false;
	}
	if(policy_exp_date=="")
	{
		alert(getMessage("BL9105","BL"));
		document.forms[0].policy_exp_date.focus();
		return false;
	}

	if(cred_auth_req_yn == "Y")
	{
		if(cred_auth_mand_capt_yn == "Y")
		{
			if(credit_auth_ref=="")
			{
				alert(getMessage("BL8148","BL"));
				document.forms[0].credit_auth_ref.focus();
				return false;
			}
			if(credit_auth_date=="")
			{
				alert(getMessage("BL9562","BL"));
				document.forms[0].credit_auth_date.focus();
				return false;
			}
		}
		else
		{
			if((credit_auth_ref=="" && credit_auth_date!="") || (credit_auth_ref!="" && credit_auth_date==""))
			{
				alert(getMessage("BL7427","BL"));
				return false;
			}
		}
	}

	if(restrict_check=="R")
	{
		if(apprd_amt_restrict_check == "R")
		{
			if(credit_apprd_amt=="")
			{
				alert(getMessage("BL9564","BL"));
				document.forms[0].credit_apprd_amt.focus();
				return false;
			}
		}
		if(apprd_days_restrict_check == "R")
		{
			if(credit_apprd_days=="")
			{
				alert(getMessage("BL9563","BL"));
				document.forms[0].credit_apprd_days.focus();
				return false;
			}
		}
	}
	
	if(policy_eff_frm_date=="")
	{
		alert(getMessage("BL9565","BL"));
		document.forms[0].policy_eff_frm_date.focus();
		return false;
	}
/*	if(policy_eff_to_date=="")
	{
		alert("policy_eff_to_date cannot be blank");
		return false;
		document.forms[0].policy_eff_to_date.focus();
	}
	*/

	if(valid_payer_YN=="N")
	{
		alert(getMessage("BL9588","BL")+":"+payer_desc);
		return false;
	}
	else if(valid_payer_YN=="Y")
	{
		if(payer_suspended_YN == "S")
		{
			alert(getMessage("BL7435","BL")+":"+payer_desc);
			return false;
		}
	}

	if(valid_policy_type_code_YN=="N")
	{
		alert(getMessage("BL9589","BL")+":"+policy_type_desc);
		return false;
	}
	else if(valid_policy_type_code_YN=="Y")
	{
		if(policy_suspended_YN == "S")
		{
			alert(getMessage("BL7436","BL")+":"+policy_type_desc);
			return false;
		}
	}

	if((blng_grp_curr_code != "" && ins_cust_curr_code == "") || (blng_grp_curr_code == "" && ins_cust_curr_code != "") || (blng_grp_curr_code != "" && ins_cust_curr_code != "" && ins_cust_curr_code != blng_grp_curr_code))		
	{
		alert(getMessage("BL6312","BL"));
		return false;
	}
	//Added by Rajesh For CRF - 155
	var patient_class=document.forms[0].p_patient_class.value;
	var billing_class = document.forms[0].billing_group.value
	var payerGrpBySetup = document.forms[0].blgrp_custgrp.value

	if(payerGrpBySetup == 'Y'){
		if(billing_class.length>0 && ins_cust_group_code.length>0){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			var param="func_mode=prevEncounterCheck&blngClass="+billing_class+"&custGrp="+ins_cust_group_code+"&patClass="+patient_class;
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
	}
	//Added by Rajesh For CRF - 155

	retVal=date_checks();
	if(retVal)
	{
		if(chk_for_valid_apprv_days_entry())
		{
			if(!chk_pol_eff_date_validity())
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		if(!chkvalidcustYN())
		{
			return false;
		}
		acceptPayer();
	}
	else
		return false;


}

function date_checks()
{
	var policy_eff_frm_date=document.forms[0].policy_eff_frm_date;
	var policy_eff_to_date=document.forms[0].policy_eff_to_date;
	var policy_start_date=document.forms[0].policy_start_date;
	var policy_exp_date=document.forms[0].policy_exp_date;
	var credit_auth_date = document.forms[0].credit_auth_date;
	var encounter_date = document.forms[0].encounter_date_aft_trunc;
	var module_id = document.forms[0].calling_module_id.value;

	retVal=false;

/*	if( (chkPolicyStartDate(policy_start_date,policy_exp_date,encounter_date,'N') ) && 
	    (chkPolicyExpiryDate(policy_start_date,policy_exp_date,encounter_date,'N')) &&
		(chkCreditAuthDate(credit_auth_date,'N')) &&
		(chkPolicyEffFromDate(policy_eff_frm_date,policy_eff_to_date,policy_start_date,policy_exp_date,encounter_date)) && 
		(chkPolicyEffToDate(policy_eff_to_date,policy_eff_frm_date,policy_exp_date,encounter_date)) )
*/
	if( (chkPolicyStartDate(policy_start_date,policy_exp_date,encounter_date,'N') ) && 
	    (chkPolicyExpiryDate(policy_start_date,policy_exp_date,encounter_date,'N')) &&
		(chkCreditAuthDate(credit_auth_date,'N')) &&
		(chkPolicyEffFromDateMain(policy_eff_frm_date,policy_eff_to_date,policy_start_date,policy_exp_date,encounter_date)) && 
		(chkPolicyEffToDate(policy_eff_to_date,policy_eff_frm_date,policy_exp_date,encounter_date)) )
		
	{
			retVal=true;
	}
	else
		retVal=false;

	return retVal;
}

function acceptPayer()
{
	var adj_rule_ind_v=document.forms[0].adj_rule_ind_lis.value;
	var adj_perc_amt_value = document.forms[0].adj_perc_amt_value.value;		
	var pmnt_diff_adj_int = document.forms[0].pmnt_diff_adj_int_desc.value;
	var adj_perc_amt_ind_lis = document.forms[0].adj_perc_amt_ind_lis.value;
	
	if(adj_rule_ind_v=="AUT")
	{
		if(adj_perc_amt_value==""  || pmnt_diff_adj_int=="" ||adj_perc_amt_ind_lis=="")
		{
			alert(getMessage("BL7193","BL"));
			return;
		}
	}

	var locale=document.forms[0].locale.value;

	var billing_group_desc=document.forms[0].billing_group_desc.value;
	if(billing_group_desc=="") billing_group_desc=" ";
	var blng_grp_code=document.forms[0].blng_grp_code.value;
	if(blng_grp_code=="") blng_grp_code=" ";
	var payer_desc=document.forms[0].payer_desc.value;
	if(payer_desc=="") payer_desc=" ";
	var cust_3=document.forms[0].cust_3.value;
	if(cust_3=="") cust_3=" ";
	var priority=document.forms[0].priority.value;
	if(priority=="") priority=" ";
	var policy_type_desc=document.forms[0].policy_type_desc.value;
	if(policy_type_desc=="") policy_type_desc=" ";
	var policy_type_code=document.forms[0].policy_type_code.value;
	if(policy_type_code=="") policy_type_code=" ";
	var policy_no=document.forms[0].policy_no.value;
	if(policy_no=="") policy_no=" ";
	var policy_start_date=document.forms[0].policy_start_date.value;
	if(policy_start_date=="") policy_start_date=" ";
	var policy_exp_date=document.forms[0].policy_exp_date.value;
	if(policy_exp_date=="") policy_exp_date=" ";
	var credit_auth_ref=document.forms[0].credit_auth_ref.value;
	if(credit_auth_ref=="") credit_auth_ref=" ";
	var credit_auth_date=document.forms[0].credit_auth_date.value;
	if(credit_auth_date=="") credit_auth_date=" ";
	var cred_auth_req_yn = document.forms[0].cred_auth_req_yn.value;
	if(cred_auth_req_yn=="") cred_auth_req_yn= " ";
	var cred_auth_mand_capt_yn = document.forms[0].cred_auth_mand_capt_yn.value;
	if(cred_auth_mand_capt_yn=="") cred_auth_mand_capt_yn= " ";	
	var dflt_auth_ref_as_pol_no_yn = document.forms[0].dflt_auth_ref_as_pol_no_yn.value;
	if(dflt_auth_ref_as_pol_no_yn=="") dflt_auth_ref_as_pol_no_yn=" ";
	var credit_apprd_amt=document.forms[0].credit_apprd_amt.value;
	if(credit_apprd_amt=="") credit_apprd_amt=" ";
	var credit_apprd_days=document.forms[0].credit_apprd_days.value;
	if(credit_apprd_days=="") credit_apprd_days=" ";
	var policy_eff_frm_date=document.forms[0].policy_eff_frm_date.value;
	if(policy_eff_frm_date=="") policy_eff_frm_date=" ";
	var policy_eff_to_date=document.forms[0].policy_eff_to_date.value;
	if(policy_eff_to_date=="") policy_eff_to_date=" ";
	var adj_rule_ind=document.forms[0].adj_rule_ind.value;
	if(adj_rule_ind=="") adj_rule_ind=" ";
	var adj_perc_amt_ind=document.forms[0].adj_perc_amt_ind.value;
	if(adj_perc_amt_ind=="") adj_perc_amt_ind=" ";
	var adj_perc_amt_value=document.forms[0].adj_perc_amt_value.value;
	if(adj_perc_amt_value=="") adj_perc_amt_value=" ";
	
	var pmnt_diff_adj_int=document.forms[0].pmnt_diff_adj_int.value;
	if(pmnt_diff_adj_int=="") pmnt_diff_adj_int=" ";
	var drg_pmnt_diff_adj_int=document.forms[0].drg_pmnt_diff_adj_int.value;
	if(drg_pmnt_diff_adj_int=="") drg_pmnt_diff_adj_int=" ";
	var spl_srv_pmnt_diff_adj_int=document.forms[0].spl_srv_pmnt_diff_adj_int.value;
	if(spl_srv_pmnt_diff_adj_int=="") spl_srv_pmnt_diff_adj_int=" ";

	var restrict_check=document.forms[0].restrict_check.value;
	if(restrict_check=="") restrict_check=" ";

	var apprd_amt_restrict_check = document.forms[0].apprd_amt_restrict_check.value;
	if(apprd_amt_restrict_check=="") apprd_amt_restrict_check=" ";

	var apprd_days_restrict_check = document.forms[0].apprd_days_restrict_check.value;
	if(apprd_days_restrict_check=="") apprd_days_restrict_check=" ";

	var valid_payer_YN=document.forms[0].valid_payer_YN.value;
	if(valid_payer_YN=="") valid_payer_YN=" ";

	var valid_policy_type_code_YN=document.forms[0].valid_policy_type_code_YN.value;
	if(valid_policy_type_code_YN=="") valid_policy_type_code_YN=" ";

	var ins_cust_group_code=document.forms[0].ins_cust_group_code.value;
	if(ins_cust_group_code=="") ins_cust_group_code=" ";

	var ins_cust_group_name=document.forms[0].ins_cust_group_name.value;
	if(ins_cust_group_name=="") ins_cust_group_name=" ";

	var policy_coverage_basis_ind= document.forms[0].policy_coverage_basis_ind.value;
	if(policy_coverage_basis_ind=="") policy_coverage_basis_ind=" ";

	var cust_valid_from_date = document.forms[0].cust_valid_from_date.value;
	if(cust_valid_from_date == "") cust_valid_from_date= " ";

	var cust_valid_to_date = document.forms[0].cust_valid_to_date.value;
	if(cust_valid_to_date == "") cust_valid_to_date= " ";

	var pol_validity_chk_date = document.forms[0].pol_validity_chk_date.value;
	if(pol_validity_chk_date == "") pol_validity_chk_date= " ";

	var rec_edited_YN = document.forms[0].rec_edited_YN.value;
	
	// Karthik added the code to add claim code starts  - IN50355
	var claim_code = document.forms[0].claim_code.value;
	if(claim_code == "") claim_code= " ";
	
	var credit_authorisation_by = document.forms[0].credit_authorisation_by.value;
	if(credit_authorisation_by == "") credit_authorisation_by= " ";
	
	var membershipId = document.forms[0].membershipId.value;
	if(membershipId == "") membershipId= " ";
	
	var xmlStrClmCrdt ="<root><SEARCH ";
	xmlStrClmCrdt+= "priority=\""+checkSpl(priority)+"\" " ;
	xmlStrClmCrdt+= "claim_code=\""+checkSpl(claim_code)+"\" " ;	
	xmlStrClmCrdt+= "credit_authorisation_by=\""+checkSpl(credit_authorisation_by)+"\" " ;
	xmlStrClmCrdt+= "membershipId=\""+checkSpl(membershipId)+"\" " ;//164.1 starts
	xmlStrClmCrdt+= "policy_no=\""+checkSpl(policy_no)+"\" " ;	//Added against NMC-JD-CRF-0054
	xmlStrClmCrdt +=" /></root>";	
	
	var updationClmCrdt=formValidation(xmlStrClmCrdt,"claimCreditMapSession");	// save these values to bean

	<!-- Karthik added the code to add claim code ends  - IN50355-->	
	
// These 4 values are passed as NULL as these values will b generated in the target page itself...
	var referral_source_main_code=" ", referral_source_main_desc=" ",referral_source_sub_code=" ",referral_source_sub_desc=" ";

	if(locale!="en")
	{
		if(!(policy_start_date=="" || policy_start_date==" "))
			policy_start_date=convertDate(policy_start_date,"DMY",locale,"en");
		
		if(!(policy_exp_date=="" || policy_exp_date==" "))
			policy_exp_date=convertDate(policy_exp_date,"DMY",locale,"en");

		if(!(credit_auth_date=="" || credit_auth_date==" "))
			credit_auth_date=convertDate(credit_auth_date,"DMY",locale,"en");

		if(!(policy_eff_frm_date=="" || policy_eff_frm_date==" "))
			policy_eff_frm_date=convertDate(policy_eff_frm_date,"DMY",locale,"en");

		if(!(policy_eff_to_date=="" || policy_eff_to_date==" "))
			policy_eff_to_date=convertDate(policy_eff_to_date,"DMY",locale,"en");

		if(!(pol_validity_chk_date=="" || pol_validity_chk_date==" "))
			pol_validity_chk_date=convertDate(pol_validity_chk_date,"DMY",locale,"en");
	}
	//Added by prithivi on 08/12/2016 for MMS-QH-CRF-0085 - BUPA Payer eligibility check
	var responseCode = document.forms[0].response_code.value;
	var statuDescription = document.forms[0].status_description.value;
	var validityPeriod = document.forms[0].validity_period.value;
	var eligibilityCode = document.forms[0].eligibility_code.value;

	var transactionId = document.forms[0].transaction_id.value;
	var responseDateTime = document.forms[0].response_date_time.value;

	var errorMsg = document.forms[0].errorMsg.value;
	var remarks = document.forms[0].remarks.value;
	var validity_until = document.forms[0].validity_period_desc_val.value;
	var payerEligibilityParam=document.forms[0].payerEligibilityParam.value;

	var responseCodeDesc = document.forms[0].response_code_desc_val.value;
	var validityPeriodDesc = document.forms[0].validity_period_desc_val.value;

	//Added by Sethu for NMC-JD-CRF-0054.1 on 15/09/2020

	var cg_det_op_interface = document.getElementById("cg_det_op_interface").value;
	var cg_det_em_interface = document.getElementById("cg_det_em_interface").value;
	var cg_det_ip_interface = document.getElementById("cg_det_ip_interface").value;
	var cg_det_dc_interface = document.getElementById("cg_det_dc_interface").value;
	
	var visitRegProcFlag = document.getElementById("cg_det_visitreg_flag").value;

	var interfaceYN = "";

	var calling_module_id = document.forms[0].calling_module_id.value;


	//var visitRegProcFlag = document.forms[0].visitRegProcFlag.value;
	//Commented by Sethu for NMC-JD-CRF-0054.1 on 15/09/2020
	//var visitRegProcFlag = visitRegProcEnabledInterface(document.forms[0].ins_cust_group_code.value);
	//var interfaceYN = document.forms[0].interfaceYN.value;
	//var moduleIdCheck = document.forms[0].moduleIdCheck.value;

	if (calling_module_id == "OP" && cg_det_op_interface == "Y")
	{
		interfaceYN = "Y";
	}
	if (calling_module_id == "IP" && cg_det_ip_interface == "Y")
	{
		interfaceYN = "Y";
	}
	if (calling_module_id == "AE" && cg_det_em_interface == "Y")
	{
		interfaceYN = "Y";
	}
	if (calling_module_id == "DC" && cg_det_dc_interface == "Y")
	{
		interfaceYN = "Y";
	}

	if(interfaceYN =="Y" && visitRegProcFlag == "N" )
	{
		if(responseCode == null || responseCode == "")
		{
			alert("Eligibility check has not been performed. Unable to proceed with visit registration!");
			return;
		}
		else if (responseCode != "2")
        {
		 	alert("Invalid response received. Unable to proceed with visit registration!");
		 	return;
		}
	}
	else if(interfaceYN == "Y")
	{
		if(responseCode == null || responseCode == "")
		{
			alert("Eligibility check has not been performed. Unable to proceed with visit registration!");
			return;
		}
	}

	var retVal=encodeURIComponent(billing_group_desc)+"^~^"+encodeURIComponent(blng_grp_code)+"^~^"+encodeURIComponent(payer_desc)+"^~^"+encodeURIComponent(cust_3)+"^~^"+priority+"^~^"+encodeURIComponent(policy_type_desc)+"^~^"+encodeURIComponent(policy_type_code)+"^~^"+encodeURIComponent(policy_no)+"^~^"+policy_start_date+"^~^"+policy_exp_date+"^~^"+encodeURIComponent(credit_auth_ref)+"^~^"+credit_auth_date+"^~^"+credit_apprd_amt+"^~^"+credit_apprd_days+"^~^"+policy_eff_frm_date+"^~^"+policy_eff_to_date+"^~^"+encodeURIComponent(adj_rule_ind)+"^~^"+encodeURIComponent(adj_perc_amt_ind)+"^~^"+encodeURIComponent(adj_perc_amt_value)+"^~^"+encodeURIComponent(pmnt_diff_adj_int)+"^~^"+encodeURIComponent(drg_pmnt_diff_adj_int)+"^~^"+encodeURIComponent(spl_srv_pmnt_diff_adj_int)+"^~^"+restrict_check+"^~^"+valid_payer_YN+"^~^"+valid_policy_type_code_YN+"^~^"+encodeURIComponent(ins_cust_group_code)+"^~^"+policy_coverage_basis_ind+"^~^"+referral_source_main_code+"^~^"+referral_source_main_desc+"^~^"+referral_source_sub_code+"^~^"+referral_source_sub_desc+"^~^"+apprd_amt_restrict_check+"^~^"+apprd_days_restrict_check+"^~^"+cred_auth_req_yn+"^~^"+dflt_auth_ref_as_pol_no_yn+"^~^"+cust_valid_from_date+"^~^"+cust_valid_to_date+"^~^"+encodeURIComponent(ins_cust_group_name)+"^~^"+pol_validity_chk_date+"^~^"+"Y"+"^~^"+cred_auth_mand_capt_yn+"^~^"+payerEligibilityParam+"^~^"+responseCode+"^~^"+encodeURIComponent(responseCodeDesc)+"^~^"+encodeURIComponent(statuDescription)+"^~^"+encodeURIComponent(validityPeriod)+"^~^"+encodeURIComponent(validityPeriodDesc)+"^~^"+encodeURIComponent(eligibilityCode)+"^~^"+encodeURIComponent(transactionId)+"^~^"+encodeURIComponent(responseDateTime)+"^~^";
	//alert("retVal:"+retVal);//41values
	//alert("retVal:"+retVal);//50values-added by prithivi on 02/01/2017 for mms-qh-crf-0085
	parent.window.returnValue =escape(retVal);
	validAcrossEncounters();
	/******************package billing changes**********start*************/
	
var package_enabled_yn=document.forms[0].package_enabled_yn.value;
var appr_seq_no=document.forms[0].appr_seq_no.value;
if(package_enabled_yn=="" || package_enabled_yn == null) package_enabled_yn="N";
if(package_enabled_yn=="Y")
{
	if(appr_seq_no!=null && appr_seq_no!="")
	appr_seq_no=trimString(appr_seq_no);
	if(credit_auth_ref!=null && credit_auth_ref!="")
	credit_auth_ref=trimString(credit_auth_ref);
	if(credit_apprd_amt!=null && credit_apprd_amt!="")
	credit_apprd_amt=trimString(credit_apprd_amt);
	/*if(credit_auth_ref!=null && credit_auth_ref!="" && credit_apprd_amt!=null && credit_apprd_amt!="")
	{*/// commented for IN 20964
		if(!validatePkgApprvDtlForm()){
			return;
		}
		saveToBean(parent.PkgDtls.document.PkgDtls,'')
		if(!validatePkgApprvPayerDtlForm()){
			return;
		}
		saveToBean(parent.PayerDtls.document.PayerDtls,'')
		var formObj=document.forms[0];	
		var oldMapKey=formObj.oldMapKey.value;
		var currMapKey=trimString(blng_grp_code)+"~~"+trimString(ins_cust_group_code)+"~~"+trimString(cust_3)+"~~"+trimString(priority)+"~~"+trimString(policy_type_code)+"~~"+trimString(policy_no)+"~~"+trimString(policy_eff_frm_date);
		if(oldMapKey!=currMapKey){//rename oldMapKey  with currMapKey in payerDtls collection of PkgApprovalBean
			renameBeanKey(formObj,oldMapKey,currMapKey,'');
		}
		//below xmlStr is modified by prithivi...added 9 values. for MMS-QH-CRF-0085
		var xmlStr ="<root><SEARCH ";	
		xmlStr+= "billing_group_desc=\""+checkSpl(billing_group_desc)+"\" " ;
		xmlStr+= "blng_grp_code=\""+checkSpl(blng_grp_code)+"\" " ;		
		xmlStr+= "payer_desc=\""+checkSpl(payer_desc)+"\" " ;		
		xmlStr+= "cust_3=\""+checkSpl(cust_3)+"\" " ;		
		xmlStr+= "priority=\""+checkSpl(priority)+"\" " ;	
		xmlStr+= "policy_type_desc=\""+checkSpl(policy_type_desc)+"\" " ;	
		xmlStr+= "policy_type_code=\""+checkSpl(policy_type_code)+"\" " ;	
		xmlStr+= "policy_no=\""+checkSpl(policy_no)+"\" " ;	
		xmlStr+= "policy_start_date=\""+checkSpl(policy_start_date)+"\" " ;	
		xmlStr+= "policy_exp_date=\""+checkSpl(policy_exp_date)+"\" " ;	
		xmlStr+= "appr_seq_no=\""+checkSpl(appr_seq_no)+"\" " ;	
		xmlStr+= "credit_auth_ref=\""+checkSpl(credit_auth_ref)+"\" " ;	
		xmlStr+= "credit_auth_date=\""+checkSpl(credit_auth_date)+"\" " ;	
		xmlStr+= "credit_apprd_amt=\""+checkSpl(credit_apprd_amt)+"\" " ;	
		xmlStr+= "credit_apprd_days=\""+checkSpl(credit_apprd_days)+"\" " ;	
		xmlStr+= "policy_eff_frm_date=\""+checkSpl(policy_eff_frm_date)+"\" " ;	
		xmlStr+= "policy_eff_to_date=\""+checkSpl(policy_eff_to_date)+"\" " ;	
		xmlStr+= "adj_rule_ind=\""+checkSpl(adj_rule_ind)+"\" " ;	
		xmlStr+= "adj_perc_amt_ind=\""+checkSpl(adj_perc_amt_ind)+"\" " ;	
		xmlStr+= "adj_perc_amt_value=\""+checkSpl(adj_perc_amt_value)+"\" " ;	
		xmlStr+= "pmnt_diff_adj_int=\""+checkSpl(pmnt_diff_adj_int)+"\" " ;	
		xmlStr+= "drg_pmnt_diff_adj_int=\""+checkSpl(drg_pmnt_diff_adj_int)+"\" " ;	
		xmlStr+= "spl_srv_pmnt_diff_adj_int=\""+checkSpl(spl_srv_pmnt_diff_adj_int)+"\" " ;	
		xmlStr+= "restrict_check=\""+checkSpl(restrict_check)+"\" " ;	
		xmlStr+= "valid_payer_YN=\""+checkSpl(valid_payer_YN)+"\" " ;	
		xmlStr+= "valid_policy_type_code_YN=\""+checkSpl(valid_policy_type_code_YN)+"\" " ;	
		xmlStr+= "ins_cust_group_code=\""+checkSpl(ins_cust_group_code)+"\" " ;	
		xmlStr+= "policy_coverage_basis_ind=\""+checkSpl(policy_coverage_basis_ind)+"\" " ;	
		xmlStr+= "referral_source_main_code=\""+checkSpl(referral_source_main_code)+"\" " ;	
		xmlStr+= "referral_source_main_desc=\""+checkSpl(referral_source_main_desc)+"\" " ;	
		xmlStr+= "referral_source_sub_code=\""+checkSpl(referral_source_sub_code)+"\" " ;	
		xmlStr+= "referral_source_sub_desc=\""+checkSpl(referral_source_sub_desc)+"\" " ;	
		xmlStr+= "apprd_amt_restrict_check=\""+checkSpl(apprd_amt_restrict_check)+"\" " ;	
		xmlStr+= "apprd_days_restrict_check=\""+checkSpl(apprd_days_restrict_check)+"\" " ;	
		xmlStr+= "cred_auth_req_yn=\""+checkSpl(cred_auth_req_yn)+"\" " ;	
		xmlStr+= "dflt_auth_ref_as_pol_no_yn=\""+checkSpl(dflt_auth_ref_as_pol_no_yn)+"\" " ;	
		xmlStr+= "cust_valid_from_date=\""+checkSpl(cust_valid_from_date)+"\" " ;	
		xmlStr+= "cust_valid_to_date=\""+checkSpl(cust_valid_to_date)+"\" " ;	
		xmlStr+= "ins_cust_group_name=\""+checkSpl(ins_cust_group_name)+"\" " ;	
		xmlStr+= "pol_validity_chk_date=\""+checkSpl(pol_validity_chk_date)+"\" " ;
		xmlStr+= "response_code=\""+checkSpl(responseCode)+"\" " ;
		xmlStr+= "status_description=\""+checkSpl(statuDescription)+"\" " ;
		xmlStr+= "validity_period=\""+checkSpl(validityPeriod)+"\" " ;
		xmlStr+= "eligibility_code=\""+checkSpl(eligibilityCode)+"\" " ;
		xmlStr+= "transaction_id=\""+checkSpl(transactionId)+"\" " ;
		xmlStr+= "response_date_time=\""+checkSpl(responseDateTime)+"\" " ;
		xmlStr+= "errorMsg=\""+checkSpl(errorMsg)+"\" " ;
		xmlStr+= "remarks=\""+checkSpl(remarks)+"\" " ;
		xmlStr+= "validity_until=\""+checkSpl(validity_until)+"\" " ;
		xmlStr +=" /></root>";	
		var updation=formValidation(xmlStr,"hdrVals");	// save these values to bean
		//} // commented for IN 20964
	}
		/******************package billing changes**********end*************/
	parent.window.close();
}

var membershipAddPayer="";//Added against MMS-DM-CRF-0164.1_73095
var policyAddPayer="";//Added against NMC-JD-CRF-0054
function cust_grp_lkup(clng_evnt)
{
	var autoFinChk = document.forms[0].autoFinChk.value;
	var target	= document.forms[0].ins_cust_group_name;
	var locale = document.forms[0].locale.value;
	var action=document.forms[0].action.value;
	var locn=document.forms[0].locn.value;
	
	var  blgrp_custgrp =document.forms[0].blgrp_custgrp.value;	
	var blng_grp_id =document.forms[0].billing_group.value;	

	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].ins_cust_group_name.value = "";
			document.forms[0].ins_cust_group_code.value = "";
			return;
		}
	}

	if(action=="add" && locn=="outside")
	{
		if(document.forms[0].select_billing_group.value == "")
		{
			alert(getMessage("BL9301","BL"));
			document.forms[0].select_billing_group.focus();
			return false;
		}
	}
	
	var retVal			= new String();	

	var dialogTop			= "240";
	var dialogHeight		= "32" ;
	var dialogWidth			= "50" ;
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	
	var title=getLabel("eBL.CUSTOMER_GROUP.label","BL");
	title=encodeURIComponent(title);	
	var column_sizes = escape("30%,70%");

	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);	
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);	

	var column_descriptions = code+","+desc;
	var message = '';
	if (autoFinChk == "Y")
	{		
		var blng_grp_id = document.forms[0].blng_grp_code.value;
		var class_code = document.forms[0].class_code.value;		
		sql = " SELECT DISTINCT a.appl_cust_group_code CUST_GROUP_CODE, b.SHORT_DESC SHORT_NAME FROM BL_APPL_BG_BY_CLASSFCTN a, ar_cust_group_lang_vw b WHERE a.appl_cust_group_code = b.CUST_GROUP_CODE AND language_id='"+locale+"' AND a.CLASSIFICATION_CODE = '"+class_code+"' AND a.APPL_BLNG_GRP_ID = '"+blng_grp_id+"' AND b.status IS NULL";
	}
	else
	{
		var sql = "select cust_group_code CUST_GRP_CODE,short_desc SHORT_NAME from ar_cust_group_lang_vw  where  language_id='"+locale+"' and status is null";
	}
	
	if(blgrp_custgrp == 'Y')		
	 sql = "SELECT distinct A.CUST_GROUP_CODE CUST_GRP_CODE,A.SHORT_DESC SHORT_NAME FROM AR_CUST_GROUP_LANG_VW A, BL_PAYERS_PRIORITY_BY_BG  B WHERE  A.CUST_GROUP_CODE = B.CUST_GROUP_CODE and  B.BLNG_GRP_ID = '"+blng_grp_id+"' and    LANGUAGE_ID = '"+locale+"' AND    A.STATUS IS NULL and    NVL(B.STATUS,'E')='E'";	

	sql = escape(sql);		

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";
	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);		
	
	var arr=new Array();		

	var op_interface_flag = "", em_interface_flag = "", ip_interface_flag = "", dc_interface_flag = "";

	var membshpid_flag = "", policyno_flag = ""; 

	if(retVal == null) retVal='';

	if (retVal != null || retVal!="")
	{
		var retVal=unescape(retVal);

		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");	
			document.forms[0].ins_cust_group_code.value=arr[0];
			document.forms[0].ins_cust_group_name.value=arr[1];
			document.forms[0].payer_desc.value='';
			document.forms[0].cust_3.value='';
            
			//Added by prithivi on 20/12/2016 for mms-qh-crf-0085
			//var interfaceYN=checkCustomerGroupInterface(document.forms[0].ins_cust_group_code.value);
			var CustGroupConfig=checkCustomerGroupInterface(document.forms[0].ins_cust_group_code.value);

			CustGroupConfig = jQuery.parseJSON(CustGroupConfig);
			
			$("#cg_det_cust_group_code").val(CustGroupConfig.cust_group_code);
			$("#cg_det_op_interface").val(CustGroupConfig.op_interface_flag);
			$("#cg_det_em_interface").val(CustGroupConfig.em_interface_flag);
			$("#cg_det_ip_interface").val(CustGroupConfig.ip_interface_flag);
			$("#cg_det_dc_interface").val(CustGroupConfig.dc_interface_flag);
			$("#cg_det_natid_flag").val(CustGroupConfig.natid_flag);
			$("#cg_det_altid1").val(CustGroupConfig.altid1_flag);
			$("#cg_det_altid2").val(CustGroupConfig.altid2_flag);
			$("#cg_det_altid3").val(CustGroupConfig.altid3_flag);
			$("#cg_det_altid4").val(CustGroupConfig.altid4_flag);
			$("#cg_det_altid5").val(CustGroupConfig.altid5_flag);
			$("#cg_det_membshpid_flag").val(CustGroupConfig.membshpid_flag);
			$("#cg_det_visitreg_flag").val(CustGroupConfig.visitreg_flag);
			$("#cg_det_policyno_flag").val(CustGroupConfig.policyno_flag);

			op_interface_flag = CustGroupConfig.op_interface_flag;
			em_interface_flag = CustGroupConfig.em_interface_flag;
			ip_interface_flag = CustGroupConfig.ip_interface_flag;
			dc_interface_flag = CustGroupConfig.dc_interface_flag;

			membshpid_flag = CustGroupConfig.membshpid_flag;
			policyno_flag = CustGroupConfig.policyno_flag;

			var p_patient_class=document.forms[0].p_patient_class.value;
			if((op_interface_flag == "Y" && p_patient_class == "OP") || (em_interface_flag == "Y" && p_patient_class == "EM") 
				|| (ip_interface_flag == "Y" && p_patient_class == "IP") || (dc_interface_flag == "Y" && p_patient_class == "DC"))
			{
				if (document.getElementById("eligibility_check") != null)
					document.getElementById("eligibility_check").disabled = false; 

                document.getElementById("payerEligibilityParam").value = "0"; 
			}
			else
			{
				if (document.getElementById("eligibility_check") != null)
					document.getElementById("eligibility_check").disabled = true; 

				document.getElementById("payerEligibilityParam").value = "9"; 
			} 


			if (membshpid_flag == "Y")
				document.getElementById("memberMandImg").style.visibility = "visible";
			else
				document.getElementById("memberMandImg").style.visibility = "hidden";
			

			if (policyno_flag == "Y")
				document.getElementById("policyMandImg").style.visibility = "visible";
			else
				document.getElementById("policyMandImg").style.visibility = "hidden";
				
			/*
			document.forms[0].interfaceYN.value = interfaceYN;

			if(interfaceYN=="Y")
			{
				if (document.getElementById("eligibility_check") != null)
					document.getElementById("eligibility_check").disabled = false; 

                 		document.getElementById("payerEligibilityParam").value = "0"; 
			}
			else
			{
				
				if (document.getElementById("eligibility_check") != null)
					document.getElementById("eligibility_check").disabled = true; 

				document.getElementById("payerEligibilityParam").value = "9"; 
			} 
			*/
			
		}
		else
		{
			document.forms[0].ins_cust_group_code.value='';
			document.forms[0].ins_cust_group_name.value='';	
			document.forms[0].interfaceYN.value = 'N';
			if (document.getElementById("eligibility_check") != null)
				document.getElementById("eligibility_check").disabled = true; 

			document.getElementById("payerEligibilityParam").value = "9"; 
				
		}
	}
	else
	{
		document.forms[0].ins_cust_group_code.value='';
		document.forms[0].ins_cust_group_name.value='';	
		document.forms[0].interfaceYN.value = 'N';
		if (document.getElementById("eligibility_check") != null)
		document.getElementById("eligibility_check").disabled = true; 

		document.getElementById("payerEligibilityParam").value = "9"; 
	}
	var custGrpCode= document.forms[0].ins_cust_group_code.value;
	var custGrpName= document.forms[0].ins_cust_group_name.value;
	
	var custId=document.forms[0].cust_id.value;
	
		//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
		var site3TierAlmoFeatureYN=document.forms[0].site3TierAlmoFeatureYN.value;
		if(custId == "ALMO" || site3TierAlmoFeatureYN == "Y") {	
			if(custGrpCode!= "" && custGrpName != "")
			payerlkup('C');
		}
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1

	// Added by Apoorva for MOHE-CRF-0020 - This is used for getting the check status flag
	var segment_id = "RQA";
	var checkTrnStatusConfig = getTrnStatusFlag(document.forms[0].ins_cust_group_code.value,segment_id);
	
	if(checkTrnStatusConfig == "Y"){
		document.getElementById("check_status").style.display = "inline"; 
	}
	else{
		document.getElementById("check_status").style.display = "none"; 
	}

	// Added by Apoorva for MOHE-CRF-0020 - This is used for getting the check status flag ends here
}

function payerlkup(clng_evnt)
{	
	var autoFinChk = document.forms[0].autoFinChk.value;
	var target			= document.forms[0].payer_desc;	
	var action=document.forms[0].action.value;
	var locn=document.forms[0].locn.value;

	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].payer_desc.value = "";
			if(document.forms[0].cust_3.value != '**')
				document.forms[0].cust_3.value = "";
			document.getElementById('ins_cust_curr_desc_disp').style.display="none";
			document.getElementById('ins_cust_curr_desc_val').innerText="";
			return;
		}
	}
	
	if(action=="add" && locn=="outside")
	{
		if(document.forms[0].select_billing_group.value == "")
		{
			alert(getMessage("BL9301","BL"));
			document.forms[0].select_billing_group.focus();
			return false;
		}
	}

	var cust_grp_code = document.forms[0].ins_cust_group_code.value;
	if(cust_grp_code == "")
	{
		alert(getMessage("BL6277","BL"));
		return false;
	}
	
	var retVal			= new String();	

	var dialogTop			= "240";
	var dialogHeight		= "32" ;
	var dialogWidth			= "50" ;
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var sql1				= "";	
	
	var title=getLabel("Common.Payer.label","common");
	title=encodeURIComponent(title);	
//		var column_sizes = escape("5%,25%,5%,25%,10%,10%,10%,10%");
	var column_sizes = escape("5%,25%,5%,25%,10%,10%,10%,10%,0%,0%");
	var code=getLabel("eBL.PAYER_CODE.label","BL");
	code=encodeURIComponent(code);	
	var desc=getLabel("eBL.PAYER_DESC.label","BL");
	desc=encodeURIComponent(desc);
	var ins_cust_group_code=getLabel("eBL.PAYER_GROUP_CODE.label","BL");
	ins_cust_group_code=encodeURIComponent(ins_cust_group_code);
	var cust_group_desc=getLabel("eBL.PAYER_GROUP_DESC.label","BL");
	cust_group_desc=encodeURIComponent(cust_group_desc);	
	var country = getLabel("Common.country.label","common");
	country = encodeURIComponent(country);
	var region = getLabel("eMP.region.label","MP");
	region = encodeURIComponent(region);
	var cust_valid_frm=getLabel("eBL.VALID_FROM.label","BL");
	cust_valid_frm=encodeURIComponent(cust_valid_frm);	
	var cust_valid_to=getLabel("eBL.VALID_TO.label","BL");
	cust_valid_to=encodeURIComponent(cust_valid_to);
	var curr_code=getLabel("eBL.CURR_CODE.label","BL");
	cust_curr_code=encodeURIComponent(curr_code);
	var curr_desc=getLabel("eBL.CURR_DESC.label","BL");
	curr_desc=encodeURIComponent(curr_desc);

	var column_descriptions = code+","+desc+","+ins_cust_group_code+","+cust_group_desc+","+country+","+region+","+cust_valid_frm+","+cust_valid_to+","+curr_code+","+curr_desc;

	var message = '';		

	var locale = document.forms[0].locale.value;
	var strModuleId = document.forms[0].calling_module_id.value;
	var strCustGroupCode = document.forms[0].ins_cust_group_code.value;

	var action=document.forms[0].action.value;
	var locn=document.forms[0].locn.value;
	var cust_valid_from_date = "", cust_valid_to_date = "",ins_cust_curr_code="",ins_cust_curr_desc="";
	var encounter_date_aft_trunc = document.forms[0].encounter_date_aft_trunc;
	var search_by_items = document.forms[0].search_by_items.value;
	var search_code = document.forms[0].search_code.value ;
	var episode_type = document.forms[0].episode_type.value;
	var blng_grp_curr_code = document.forms[0].curr_code_for_bg.value;
	var facility_id = document.forms[0].facility_id.value;

	var blng_grp_id = document.forms[0].blng_grp_code.value;
	var class_code = document.forms[0].class_code.value;

	/*
		if(action=="add")
		{
			strCustGroupCode="";
		}
	*/
		//new one - added the condition (a.ref_yn = 'Y') on 1-aug-2007  by manivel
	//		sql1="select DISTINCT a.cust_code CUST_CODE, a.short_name CUST_NAME,b.cust_group_code CUST_GROUP_CODE, b.short_desc CUST_GROUP_NAME,to_char(a.VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(a.VALID_TO,'dd/mm/yyyy') VALID_TO from ar_customer_lang_vw a,ar_cust_group_lang_vw b,sy_acc_entity c,bl_ins_policy_type_hdr d where a.acc_entity_code= b.acc_entity_code and a.cust_group_code = b.cust_group_code and (b.cust_group_code='"+strCustGroupCode+"' or '"+strCustGroupCode+"' is null) and a.language_id = b.language_id and  a.language_id='"+locale+"' and a.patient_flag = 'Y' and NVL(a.pat_com_flag,'N') = 'N'  and nvl(a.insurance_yn,'Y') = 'Y'   and a.status is null  and (('"+strModuleId+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or ('"+strModuleId+"' = 'MP' and a.ref_yn = 'Y')) and c.acc_entity_code = a.acc_entity_code and d.operating_facility_id = c.acc_entity_id and d.cust_group_code = a.cust_group_code and (d.cust_code = a.cust_code or d.cust_code = '**') and (('"+strModuleId+"' in ('OP','AE') and nvl(d.outpatient_cover,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(d.inpatient_covered,'N') = 'Y') or ('"+strModuleId+"' = 'MP' and nvl(d.external_covered,'N') = 'Y')) and decode('"+search_by_items+"','CY',nvl(country_code,'XXXX'),'RN',nvl(region_code,'XXXX')) = nvl('"+search_code+"',decode('"+search_by_items+"','CY',nvl(country_code,'XXXX'),'RN',nvl(region_code,'XXXX')))";
		
	//		sql1="select DISTINCT a.cust_code CUST_CODE,a.short_name CUST_NAME,b.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME,a.country_name COUNTRY_NAME,a.region_name REGION_NAME,a.VALID_FROM VALID_FROM,a.VALID_TO VALID_TO from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,sy_acc_entity c,bl_ins_policy_type_hdr d where a.acc_entity_code= b.acc_entity_code and c.acc_entity_code = a.acc_entity_code and d.operating_facility_id = c.acc_entity_id and a.language_id = b.language_id and a.language_id='"+locale+"' and a.cust_group_code = b.cust_group_code and d.cust_group_code = a.cust_group_code and (b.cust_group_code='"+strCustGroupCode+"' or '"+strCustGroupCode+"' is null) and (d.cust_code = a.cust_code or d.cust_code = '**') and a.patient_flag = 'Y' and NVL(a.pat_com_flag,'N') = 'N' and nvl(a.insurance_yn,'Y') = 'Y' and a.status is null and decode('"+search_by_items+"','CY',nvl(country_code,'XXXX'),'RN',nvl(region_code,'XXXX')) = nvl('"+search_code+"',decode('"+search_by_items+"','CY',nvl(country_code,'XXXX'),'RN',nvl(region_code,'XXXX')))";

//    Query changed to match the CRF-134(Multiple Cust Group for single Customer) need
		
		sql = "called_for=INSPAYERLKUP&locale="+locale+"&module_id="+strModuleId+"&episode_type="+episode_type+"&auto_fin_chk="+autoFinChk+"&cust_grp_code="+strCustGroupCode+"&class_code="+class_code+"&blng_grp_id="+blng_grp_id+"&search_by_items="+search_by_items+"&search_code="+search_code+"&facility_id="+facility_id;
/*
		var valid_cust_check = "";
		var valid_pol_check = "";

		if(episode_type == 'R' )
		{
			valid_cust_check=" and ('"+strModuleId+"'='MP' and a.ref_yn='Y') ";
		}
		else if(episode_type == 'O')
		{
			valid_cust_check=" and ('"+strModuleId+"'='OP' and a.op_yn ='Y') ";
		}
		else if(episode_type == 'E')
		{
			valid_cust_check=" and ('"+strModuleId+"'='AE' and a.op_yn='Y') ";
		}
		else if(episode_type == 'I')
		{
			valid_cust_check=" and ('"+strModuleId+"'='IP' and a.ip_yn ='Y') ";
		}
		else if(episode_type == 'D')
		{
			valid_cust_check=" and ('"+strModuleId+"'='DC' and a.ip_yn = 'Y') ";
		}

		if(episode_type == 'R' )
		{
			valid_pol_check=" and ('"+strModuleId+"'='MP' and nvl(c.external_covered,'N')='Y')";
		}
		else if(episode_type == 'O')
		{
			valid_pol_check=" and ('"+strModuleId+"'='OP' and nvl(c.outpatient_cover,'N')='Y')";
		}
		else if(episode_type == 'E')
		{
			valid_pol_check=" and ('"+strModuleId+"'='AE' and nvl(c.outpatient_cover,'N')='Y')";
		}
		else if(episode_type == 'I')
		{
			valid_pol_check=" and ('"+strModuleId+"'='IP' and nvl(c.inpatient_covered,'N')='Y')";
		}
		else if(episode_type == 'D')
		{
			valid_pol_check=" and ('"+strModuleId+"'='DC' and nvl(c.inpatient_covered,'N')='Y')";
		}

		if (autoFinChk == "Y")
		{
			var blng_grp_id = document.forms[0].blng_grp_code.value;
			var class_code = document.forms[0].class_code.value;

			sql1="select d.cust_code C_CDE,a.short_name C_NAM,b.cust_group_code C_GRP_CDE,b.short_desc C_GRP_NAM,"
				+" blcommon.getcntry(a.country_code,'"+locale+"') cny_nam, blcommon.getregn(a.region_code,'"+locale+"') rg_nam,"
				+" a.VALID_FROM VAL_FRM,a.VALID_TO VAL_TO,a.CURRENCY_CODE CUR_COD,a.CURRENCY_DESC CUR_DSC"
				+" from AR_CUSTOMER_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group d,BL_APPL_BG_BY_CLASSFCTN f"
				+" where a.acc_entity_code=b.acc_entity_code"
				+" AND b.acc_entity_code=d.acc_entity_code" 
				+" and a.language_id=b.language_id" 
				+" and a.language_id='"+locale+"'" 
				+" and d.cust_group_code=f.APPL_CUST_GROUP_CODE" 
				+" AND b.cust_group_code =NVL('"+strCustGroupCode+"',b.cust_group_code)"
				+" and f.APPL_CUST_GROUP_CODE=NVL('"+strCustGroupCode+"',f.APPL_CUST_GROUP_CODE)"
				+" and f.CLASSIFICATION_CODE='"+class_code+"'"
				+" and f.APPL_BLNG_GRP_ID='"+blng_grp_id+"'"
				+" and a.cust_code=d.cust_code" 
				+" and d.cust_code = f.APPL_CUST_CODE" 
				+" and a.patient_flag='Y'" 
				+" and NVL(a.pat_com_flag,'N')='N'" 
				+" and nvl(a.insurance_yn,'Y')='Y'" 
				+" and a.status is null" 
				+valid_cust_check
				+" AND EXISTS (SELECT 'Y' FROM bl_ins_policy_type_hdr c WHERE (c.cust_code = d.cust_code OR  c.cust_code = '**') "+valid_pol_check+" AND c.cust_group_code = d.cust_group_code)"
				+" AND decode('"+search_by_items+"','CY',nvl(country_code,'XXXX'),'RN',nvl(region_code,'XXXX'))=nvl('"+search_code+"',decode('"+search_by_items+"','CY',nvl(country_code,'XXXX'),'RN',nvl(region_code,'XXXX')))";
		}
		else
		{
			sql1="select d.cust_code C_CDE,a.short_name C_NAM,b.cust_group_code C_GRP_CDE,b.short_desc C_GRP_NAM,"
				+" blcommon.getcntry(a.country_code,'"+locale+"') cny_nam, blcommon.getregn(a.region_code,'"+locale+"') rg_nam,"
				+" a.VALID_FROM VAL_FRM,a.VALID_TO VAL_TO,a.CURRENCY_CODE CUR_COD,a.CURRENCY_DESC CUR_DSC" 
				+" FROM AR_CUSTOMER_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group d"
				+" WHERE a.acc_entity_code= b.acc_entity_code"
				+" AND b.acc_entity_code= d.acc_entity_code"
				+" AND a.language_id = b.language_id"
				+" AND b.cust_group_code = d.cust_group_code"
				+" AND a.language_id='"+locale+"'"
				+" AND b.cust_group_code =NVL('"+strCustGroupCode+"',b.cust_group_code)"
				+" AND a.cust_code = d.cust_code" 
				+" AND a.patient_flag = 'Y'"
				+" AND NVL(a.pat_com_flag,'N') = 'N'"
				+" AND NVL(a.insurance_yn,'Y') = 'Y'" 
				+" AND a.status IS NULL"
				+valid_cust_check
				+" AND EXISTS (SELECT 'Y' FROM bl_ins_policy_type_hdr c WHERE (c.cust_code = d.cust_code OR  c.cust_code = '**') "+valid_pol_check+" AND c.cust_group_code = d.cust_group_code)"
				+" AND decode('"+search_by_items+"','CY',nvl(country_code,'XXXX'),'RN',nvl(region_code,'XXXX'))=nvl('"+search_code+"',decode('"+search_by_items+"','CY',nvl(country_code,'XXXX'),'RN',nvl(region_code,'XXXX')))";
		}

//		sql = escape(sql1);		
		sql = sql1;		
*/
//		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYYYYYYYNN";

		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYYYYYYYNN";
		
		retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);		

		var arr=new Array();		

	    if(retVal == null) retVal='';

		if (retVal != null || retVal!="")
		{
			var retVal=unescape(retVal);

			if(retVal != null && retVal.length>0)
			{
				arr=retVal.split("^~^");		
				cust_valid_from_date = arr[6].substring(0,10);
				cust_valid_to_date = arr[7].substring(0,10);
				ins_cust_curr_code = arr[8]; 
				ins_cust_curr_desc = arr[9];

				if(cust_valid_from_date != "")
				{
					var cust_valid_from_date_loc=cust_valid_from_date;
					if(locale != 'en')
					cust_valid_from_date_loc=convertDate(cust_valid_from_date_loc,'DMY','en',locale);

					if(!isAfter(encounter_date_aft_trunc.value,cust_valid_from_date_loc,'DMY',locale))
					{
						//Added by Rajesh V - If logic
						if(strModuleId != 'MP'){
							alert(getMessage("BL8227","BL"));
							document.forms[0].payer_desc.select();
							return false;
						}						
					}	
				}
				
				//alert('cust_valid_to_date '+cust_valid_to_date)
				
				//Added By Vijay For MMS-QF-SCf-567
				/* if(cust_valid_to_date=='')
					{
					
					alert('Policy Expiry date is not available in the Policy setup');
					document.forms[0].custValidToDate.value=cust_valid_to_date;				
					return false;
					
					
					}
				 */
				
				if(cust_valid_to_date != "")
				{
					var cust_valid_to_date_loc=cust_valid_to_date;
					if(locale != 'en')
					cust_valid_to_date_loc=convertDate(cust_valid_to_date_loc,'DMY','en',locale);

					if(!isBefore(encounter_date_aft_trunc.value,cust_valid_to_date_loc,'DMY',locale))
					{
						alert(getMessage("BL8227","BL"));
						document.forms[0].payer_desc.select();
						return false;
					}
				}	

				if((blng_grp_curr_code != "" && ins_cust_curr_code == "") || (blng_grp_curr_code == "" && ins_cust_curr_code != "") ||	(blng_grp_curr_code != "" && ins_cust_curr_code != "" && ins_cust_curr_code != blng_grp_curr_code))		
				{
					alert(getMessage("BL6312","BL"));
					document.forms[0].payer_desc.value = "";
					document.forms[0].cust_3.value = "";
					document.forms[0].ins_cust_curr_code.value = "";
					document.forms[0].ins_cust_curr_desc.value = "";
					document.getElementById('ins_cust_curr_desc_disp').style.display="none";
					document.getElementById('ins_cust_curr_desc_val').innerText="";
					return false;
				}
				else
				{
					document.forms[0].ins_cust_curr_code.value = ins_cust_curr_code;
					document.forms[0].ins_cust_curr_desc.value = ins_cust_curr_desc;
				}

				if(document.forms[0].cust_3.value != '**' && (document.forms[0].cust_3.value != arr[0] || document.forms[0].ins_cust_group_code.value != arr[2]))
				{
					document.forms[0].policy_type_code.value="";
					document.forms[0].policy_type_desc.value="";
					document.forms[0].valid_policy_type_code_YN.value="N";
				}
				document.forms[0].cust_3.value=arr[0];
				document.forms[0].payer_desc.value=arr[1];
				document.forms[0].ins_cust_group_code.value=arr[2];
				document.forms[0].ins_cust_group_name.value=arr[3];
				document.forms[0].cust_valid_from_date.value=cust_valid_from_date;
				document.forms[0].cust_valid_to_date.value=cust_valid_to_date;
		//					target.focus();
		//					setTimeout('apprvd_amt_days_check()',200);
				document.forms[0].valid_payer_YN.value="Y";
			}
			else
			{
				document.forms[0].cust_3.value="";
				document.forms[0].payer_desc.value="";
				document.forms[0].valid_payer_YN.value="N";
				document.forms[0].policy_type_code.value="";
				document.forms[0].policy_type_desc.value="";
				document.forms[0].valid_policy_type_code_YN.value="N";
			}
		}
		else
		{
			document.forms[0].cust_3.value="";
			document.forms[0].payer_desc.value="";
			document.forms[0].valid_payer_YN.value="N";
			document.forms[0].policy_type_code.value="";
			document.forms[0].policy_type_desc.value="";
			document.forms[0].valid_policy_type_code_YN.value="N";
		}
		if(apprvd_amt_days_check())
		{
			if(curr_desc_1())
			{
				adjustment_rule();
			}
		}
		var payerDescVal= document.forms[0].payer_desc.value;
		
		var custId=document.forms[0].cust_id.value;
		//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
		var site3TierAlmoFeatureYN=document.forms[0].site3TierAlmoFeatureYN.value;	
		if(custId == "ALMO" || site3TierAlmoFeatureYN == "Y") {	
			if(payerDescVal!= "")
			policylkup('C');
		}
		//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
}

async function getCustDet()
{
	var cust_3=document.forms[0].cust_3.value;	
	var cust_group_code=document.forms[0].ins_cust_group_code.value;

	if(cust_3 == "")
	{
		alert(getMessage("BL9532","BL"));
		return;
	}
				
	if((cust_3!=""))
	{
		var retVal;
		var dialogHeight= "20" ;
		var dialogWidth	= "30" ;
		var dialogTop = "320" ;
		var center = "1" ;														   
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var url = "../../eBL/jsp/BLCustomerDetFrame.jsp?cust_code="+cust_3+"&cust_grp_code="+cust_group_code;;
		retVal =await window.showModalDialog(url,arguments,features);
	}
}

function curr_desc_1()
{
	var ins_cust_curr_desc = document.forms[0].ins_cust_curr_desc.value;

	if(ins_cust_curr_desc != "")
	{
		document.getElementById('ins_cust_curr_desc_disp').style.display="inline";
		document.getElementById('ins_cust_curr_desc_val').innerText=ins_cust_curr_desc;
		return true;
	}
	else
	{
		document.getElementById('ins_cust_curr_desc_disp').style.display="none";
		document.getElementById('ins_cust_curr_desc_val').innerText="";
		return true;
	}

}

function policylkup(clng_evnt)
{	
<!-- 08/07/2013	Karthikeyan K	MMS-QH-CRF-0010	36789 Starts -->
		validAcrossEncounters();
<!-- 08/07/2013	Karthikeyan K	MMS-QH-CRF-0010	36789 Ends-->
//alert('here');
		var target			= document.forms[0].policy_type_desc;		

		if(clng_evnt == 'B')
		{
			if( target.value == "")
			{	
				document.forms[0].policy_type_code.value = "";
				document.forms[0].policy_type_desc.value = "";
				return;
			}
		}

		var retVal			= new String();	

		var dialogTop			= "240";
		var dialogHeight		= "32" ;
		var dialogWidth			= "50" ;
		var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var sql					= "";
		var sql1				= "";		

		var payer_desc		= document.forms[0].payer_desc.value;	
		var facility_id		= document.forms[0].facility_id.value;	
		var strModuleId = document.forms[0].calling_module_id.value;
		var cust_code=document.forms[0].cust_3.value;
		var cust_group_code=document.forms[0].ins_cust_group_code.value;

		var policy_coverage_basis_gbl_ind=document.forms[0].policy_coverage_basis_gbl_ind.value;

		var policy_coverage_basis_ind=document.forms[0].policy_coverage_basis_ind.value;

		var totalRecords=document.forms[0].totalRecords.value;

		if (payer_desc.length == 0)
			return;
		var title=getLabel("eBL.POLICY.label","BL");
		title=encodeURIComponent(title);	

		//var column_sizes = escape("20%,60%,20%");

		var column_sizes = escape("20,60,20");

		var code=getLabel("Common.code.label","common");
		code=encodeURIComponent(code);	
		var desc=getLabel("Common.description.label","common");
		desc=encodeURIComponent(desc);	

		var policy_coverage_basis_ind=getLabel("eBL.POLICY_COVERAGE_BASIS_IND.label","BL");
		policy_coverage_basis_ind=encodeURIComponent(policy_coverage_basis_ind);	

		var column_descriptions = code+","+desc+","+policy_coverage_basis_ind;

		var patient_basd_plcy_leg = getLabel("eBL.PATIENT_BASED.label","BL");
		patient_basd_plcy_leg=encodeURIComponent(patient_basd_plcy_leg);

		var pyer_basd_plcy_leg = getLabel("eBL.PAYER_BASED.label","BL");
		pyer_basd_plcy_leg=encodeURIComponent(pyer_basd_plcy_leg);

		var message = '';		

		var locale = document.forms[0].locale.value;
//		var cust_3=document.forms[0].cust_3.value;

		 
		
//		sql1 ="Select policy_type_code POLICY_TYPE_CODE,short_desc SHORT_DESC from bl_ins_policy_types_lang_vw where language_id='"+locale+"' and cust_code='"+cust_3+"' and operating_facility_id='"+facility_id+"' and nvl(status,'N') <> 'S' ";		

//		sql1 ="Select a.policy_type_code POLICY_TYPE_CODE,a.short_desc SHORT_DESC from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b where a.language_id='"+locale+"' and  a.operating_facility_id='"+facility_id+"' and nvl(a.status,'N') <> 'S' and a.operating_facility_id = b.operating_facility_id and a.policy_type_code = b.policy_type_code and b.cust_code='"+cust_code+"' and (('"+strModuleId+"' in ('OP','AE') and nvl(b.outpatient_cover,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(b.inpatient_covered,'N') = 'Y') or '"+strModuleId+"' = 'MP') ";

		//new one

//		sql1="Select DISTINCT a.policy_type_code POLICY_TYPE_CODE,a.short_desc SHORT_DESC,decode(b.policy_coverage_basis,'I','"+pyer_basd_plcy_leg+"','P','"+patient_basd_plcy_leg+"') POLICY_COVERAGE_BASIS from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b, ar_customer c where a.language_id='"+locale+"' and  a.operating_facility_id='"+facility_id+"' and nvl(a.status,'N') <> 'S' and a.operating_facility_id = b.operating_facility_id and a.policy_type_code = b.policy_type_code and c.cust_code='"+cust_code+"' and c.cust_group_code = b.cust_group_code and (b.cust_code=c.cust_code or b.cust_code = '**') and (('"+strModuleId+"' in ('OP','AE') and nvl(b.outpatient_cover,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(b.inpatient_covered,'N') = 'Y') or ('"+strModuleId+"' = 'MP' and nvl(b.external_covered,'N') = 'Y'))";

//    Query changed to match the CRF-134(Multiple Cust Group for single Customer) need
	//alert(sql1);
	
	//Change for Incident 41309 Starts

			sql1="Select DISTINCT a.policy_type_code POLICY_TYPE_CODE,a.short_desc SHORT_DESC,POLICY_COVERAGE_BASIS POLICY_COVERAGE_BASIS"
			 +" from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b, bl_cust_by_cust_group c" 
			 +" where a.language_id='"+locale+"'" 
			 +" and  a.operating_facility_id='"+facility_id+"'" 
		   	 +" and nvl(a.status,'N') <> 'S'"
			 +" and a.operating_facility_id = b.operating_facility_id"  
			 +" and a.policy_type_code = b.policy_type_code"
			 +" and c.cust_code='"+cust_code+"'" 
			 +" and c.cust_group_code = b.cust_group_code"
			 +" and (b.cust_code=c.cust_code or b.cust_code = '**')"
			 +" AND b.cust_group_code = '"+cust_group_code+"'" 
			 +" and (('"+strModuleId+"' in ('OP','AE') and nvl(b.outpatient_cover,'N') = 'Y')" 
			 +" or ('"+strModuleId+"' in ('IP','DC') and nvl(b.inpatient_covered,'N') = 'Y')"
			 +" or ('"+strModuleId+"' = 'MP' and nvl(b.external_covered,'N') = 'Y'))";			 
	
		//	sql1=document.forms[0].sql1.value;
		//	sql1=sql1+" and c.cust_code='"+cust_code+"' AND b.cust_group_code = '"+cust_group_code+"'" ;
			
	 //	Change for Incident 41309 Starts

	
			//param ="called_from="plcylookup"+"&locale="+locale+"&facility_id="+facility_id+"&cust_code="+cust_code+"&cust_grp_code="+cust_group_code+"&module_id="+strModuleId;

		var action=document.forms[0].action.value;
		var locn=document.forms[0].locn.value;
		//Added by Rajesh V
		var link_policy_in_billing = 'N';
		//Added by Rajesh V
		if(totalRecords>1 || (action=="add" && totalRecords>=1))
		{
			if(policy_coverage_basis_gbl_ind=="I")
			{
				sql1=sql1+" and b.POLICY_COVERAGE_BASIS='"+policy_coverage_basis_gbl_ind+"'";
			}
		}
		
		/*Added by karthik to change the query for Policy specific changes*/
		  <%
		   String LINK_POLICY_IN_BILLING=(String)session.getAttribute("LINK_POLICY_IN_BILLING"); 
		   if(LINK_POLICY_IN_BILLING.equalsIgnoreCase("Y")){
		  %>
			//Added by Rajesh V
		  	link_policy_in_billing = 'Y';
		  //Added by Rajesh V
			sql1 += "and trunc(SYSDATE) BETWEEN NVL(b.POLICY_EFF_FROM,SYSDATE-1) and NVL(b.POLICY_EFF_TO,SYSDATE) ";
		 <% } %>

		
		 
		sql = escape(sql1);
		
	//	sql = sql1;

	//	var param = "sql="+sql+"title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYY";


	//Modified by Rajesh V
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYY"+"&called_for=POLICYLUKP"+
				"&locale="+locale+"&facility_id="+facility_id+"&cust_code="+cust_code+"&cust_group_code="+cust_group_code+"&strModuleId="+strModuleId+
				"&totalRecords="+totalRecords+"&action="+action+"&policy_coverage_basis_gbl_ind="+policy_coverage_basis_gbl_ind+"&link_policy_in_billing="+link_policy_in_billing;

	//Modified by Rajesh V
		//alert(param);

		retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);		

		var arr=new Array();		

	    if(retVal == null) retVal='';

		if (retVal != null || retVal!="")
		{
			var retVal=unescape(retVal);

			if(retVal != null && retVal.length>0)
			{
				arr=retVal.split("^~^");	
	
				document.forms[0].policy_type_desc.value=arr[1];
				document.forms[0].policy_type_code.value=arr[0];
				//				target.focus();
				//				apprvd_amt_days_check();
				//				setTimeout('apprvd_amt_days_check()',200);
				if(apprvd_amt_days_check())
				{
					adjustment_rule();
				}
				document.forms[0].valid_policy_type_code_YN.value="Y";
				//Added V190522-Aravindh/NMC-JD-CRF-0010/Starts
				if(document.forms[0].siteSpecPolApprv.value == "true" || document.forms[0].siteSpecPolApprv.value == true) {
					//validateApprovedPolicyYN(document.forms[0].ins_cust_group_code,document.forms[0].cust_3,document.forms[0].policy_type_code);
					var validateApprovedPolicy = false;
					validateApprovedPolicy = validateApprovedPolicyYN(document.forms[0].ins_cust_group_code,document.forms[0].cust_3,document.forms[0].policy_type_code,document.forms[0].facility_id.value);
					if(validateApprovedPolicy != true) {
						document.forms[0].policy_type_desc.value="";
						document.forms[0].policy_type_code.value="";
						document.forms[0].valid_policy_type_code_YN.value="N";
						alert(getMessage("BL0831","BL"));
					}
				}
				//Added V190522-Aravindh/NMC-JD-CRF-0010/Ends
			}
			else
			{
				document.forms[0].policy_type_desc.value="";
				document.forms[0].policy_type_code.value="";
				document.forms[0].valid_policy_type_code_YN.value="N";
			}
		}
		else
		{
			document.forms[0].policy_type_desc.value="";
			document.forms[0].policy_type_code.value="";
			document.forms[0].valid_policy_type_code_YN.value="N";
		}

/* ***************GHL-0020 SCRUM CRF related changes ***************** */
		var cust_code=document.forms[0].cust_3.value;
		var policy_type_code=document.forms[0].policy_type_code.value;
		var ins_cust_group_code=document.forms[0].ins_cust_group_code.value;

		if((!(cust_code=="")) && (!(policy_type_code==""))&&(!(ins_cust_group_code=="")))
		{
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";

			//var cust_code=document.forms[0].cust_3.value;
			//var policy_type_code=document.forms[0].policy_type_code.value;
			var facility_id=document.forms[0].facility_id.value;
			//var cust_group_code=document.forms[0].ins_cust_group_code.value;
			var encounter_date_time=document.forms[0].encounter_date_time.value;

			var param="encounter_date_time="+encodeURIComponent(encounter_date_time)+"&cust_code="+encodeURIComponent(cust_code)+"&policy_type_code="+encodeURIComponent(policy_type_code)+"&cust_group_code="+cust_group_code+"&facility_id="+facility_id+"&called_from=pocy_date_valid";

			var temp_jsp="../../eBL/jsp/BLInsuranceValidations.jsp?"+param;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=trimString(xmlHttp.responseText);

			var retVal = responseText.split("&^&");
			var cust_id =  document.forms[0].cust_id.value;
			//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
			var site3TierAlmoFeatureYN =  document.forms[0].site3TierAlmoFeatureYN.value;
			
			
			if(retVal[0]!=''&&retVal[1]!='' && (cust_id !='ALMO' && site3TierAlmoFeatureYN !='Y')) 
			{//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1	 			
		
				/*
				document.forms[0].policy_start_date.value=retVal[0];
				document.forms[0].policy_exp_date.value=retVal[1];
				*/
				/*RUT-SCF-0195: Change done by Karthik on 3/4/2013 to Provide Locale */
				var pStDate=convertDate(retVal[0],"DMY","en",locale);
				var pExDate=convertDate(retVal[1],"DMY","en",locale);
				
				
								
				document.forms[0].policy_start_date.value=pStDate;
				
				
					
				document.forms[0].policy_exp_date.value=pExDate;
				
									
				chkPolicyStartDateMain(document.forms[0].policy_start_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc);

				chkPolicyExpiryDateMain(document.forms[0].policy_start_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc);
			}
/*
			else
            {
				document.forms[0].policy_eff_frm_date.value=retVal[0];
				document.forms[0].policy_eff_to_date.value=retVal[1];

			}
*/

		 }

		 /*
		 * Defaulting policy start and end  dates based on policys 
		 */
/* ***************GHL-0020 SCRUM CRF related changes ***************** */	 
//alert('before check_for_related_policies'); 
check_for_related_policies('B');
		var chargeLogicYn = document.forms[0].chargeLogicYn.value;
		/* Code changes by Boopath for efault - PolicyStartdate /End date Approved Amounmt , Aprroved no of days Starts Here */	 
		//Rajesh V		
		if(chargeLogicYn == 'Y'){
			 if(strModuleId=="OP" || strModuleId=="IP" 
					 || strModuleId=="DC" || strModuleId=="AE"||strModuleId=="MP") 
			 {
				 if(policy_type_code!=null && policy_type_code!="")
				 {
					 LoadDefaultPolicyDateAndApprovedAmount(cust_group_code,cust_code,policy_type_code,strModuleId);	 
					 document.forms[0].plcyorEncounter.value = 'policy';
				 }
		 
			 }
		}
		 /* Code changes by Boopath for efault - PolicyStartdate /End date Approved Amounmt , Aprroved no of days Ends Here */
				
		 
		
		
}

function policyDateHandle()
{
	
	dflt_policy_exp_date();
	
	dflt_policy_eff_to_date();
	
	var pStDate = document.forms[0].policy_start_date.value;
	var pExDate = document.forms[0].policy_exp_date.value;
	
		
	
	
		
	//pStDate  = pStDate.trim();
	//pExDate  = pExDate.trim();
	if( pStDate !='')			
		{
	
		document.forms[0].plcyStrtCalen.disabled = true;
		document.forms[0].policy_start_date.readOnly = true;		
		}
	else
		{
		document.forms[0].plcyStrtCalen.disabled = false;
		document.forms[0].policy_start_date.readOnly = false;
		}
		
	
	if(pExDate !='')
		{					
	
		document.forms[0].plcyExpCalen.disabled = true;		
		document.forms[0].policy_exp_date.readOnly = true;
		}
	else
		{
		
		document.forms[0].plcyExpCalen.disabled = false;		
		document.forms[0].policy_exp_date.readOnly = false;
		document.forms[0].plcyExpCalen.disabled = false;
		}
	
	var approvedAmt = document.forms[0].credit_apprd_amt;
	
	
	if(approvedAmt.value !='' && approvedAmt.value != null)
	{					
	document.forms[0].credit_apprd_amt.readOnly = true;
	}
else
	{	
	document.forms[0].credit_apprd_amt.readOnly = false;
	}
	
	var approved_days =  document.forms[0].credit_apprd_days ;
	
	if(approved_days.value !='' && approved_days.value != null)
	{					
	document.forms[0].credit_apprd_days.readOnly = true;
	}
else
	{	
	document.forms[0].credit_apprd_days.readOnly = false;
	}
	
	
	if(document.forms[0].policy_eff_frm_date.value == ''){
		document.forms[0].policy_eff_frm_date.value = document.forms[0].todayFormated.value;
	}
	
	
	
	
}


function  validate_eff_to_apprday()
{
	
	
	
	var policy_eff_frm_date=document.forms[0].policy_eff_frm_date;
	var policy_eff_to_date  =  document.forms[0].policy_eff_to_date.value;
	var approved_days =  document.forms[0].credit_apprd_days ;
	
	var cust_id =  document.forms[0].cust_id.value;
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	var site3TierAlmoFeatureYN =  document.forms[0].site3TierAlmoFeatureYN.value;	
	if(cust_id != "ALMO" && site3TierAlmoFeatureYN != "Y")
		return;
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	
	var locale = document.forms[0].locale.value;

	var pol_validity_chk_date;	
	
	
		
			if(approved_days.value != '' &&  approved_days.value != null  && policy_eff_to_date != '' && policy_eff_to_date != null && policy_eff_frm_date.value != null && policy_eff_frm_date.value != '')
			{			       
		
			 pol_validity_chk_date = plusDate(policy_eff_frm_date.value,'DMY',locale,eval(approved_days.value)-1,'d');
			 
	
			 if(!isBefore(policy_eff_to_date,pol_validity_chk_date,'DMY',locale))
				 {
	
				 alert(getMessage("BL00280","BL"));
				 document.forms[0].policy_eff_to_date.value	= pol_validity_chk_date;
				 document.forms[0].policy_eff_to_date.focus();
				 }
			 
			}
	
	}

function  dflt_policy_exp_date()
{
	
	var approved_days =  document.forms[0].credit_apprd_days ;
	var exp_days  =  document.forms[0].exp_days ;
	var policy_start_date = document.forms[0].policy_start_date;
	
	var policy_exp_date =document.forms[0].policy_exp_date.value; 
	
		
	var locale = document.forms[0].locale.value;

	var pol_validity_chk_date='';
	
	
	
	
	
	if( policy_exp_date == '' || policy_exp_date == null || policy_exp_date == 'undefined' || policy_exp_date == 'null')
		{
	
	
		
	if( exp_days.value != ''  && exp_days.value != null)
	  {
	  pol_validity_chk_date = plusDate(policy_start_date.value,'DMY',locale,eval(exp_days.value)-1,'d');

	  }
/*
  Commented by  Dhanasekar as per karups & paban info  on 8/10/2013
	else if(approved_days.value != '' &&  approved_days.value != null)
	{			       

 	pol_validity_chk_date = plusDate(policy_start_date.value,'DMY',locale,eval(approved_days.value)-1,'d');

	}
*/
  document.forms[0].policy_exp_date.value  = 	 pol_validity_chk_date;
		}
	
	}


function  dflt_policy_eff_to_date()
{
	
	
	var policy_exp_date=document.forms[0].policy_exp_date.value;
	var policy_eff_frm_date=document.forms[0].policy_eff_frm_date;
	var policy_eff_to_date=document.forms[0].policy_eff_to_date; 
	var approved_days =  document.forms[0].credit_apprd_days ;
	var exp_days  =  document.forms[0].exp_days ;
	
	var cust_id =  document.forms[0].cust_id.value;
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	var site3TierAlmoFeatureYN =  document.forms[0].site3TierAlmoFeatureYN.value;	
	if(cust_id != "ALMO" && site3TierAlmoFeatureYN != "Y") 
		return;
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1

	var locale = document.forms[0].locale.value;

	var encounter_date_trunc =  document.forms[0].encounter_date_aft_trunc;
	
	
	 if(policy_eff_frm_date.value !='' && encounter_date_trunc.value != '' && !isBefore(policy_eff_frm_date.value,encounter_date_trunc.value,'DMY',locale))
	 {
			//Added by Rajesh V - If logic
			var strModuleId = document.forms[0].calling_module_id.value;
			if(!isBefore(policy_eff_frm_date.value,encounter_date_trunc.value,'DMY',locale)){
				if(strModuleId != 'MP'){
					 alert(getMessage("BL8222","BL"));	 
					 document.forms[0].policy_eff_frm_date.value = encounter_date_trunc.value;
					 document.forms[0].policy_eff_frm_date.focus();
				}
			}
			else{
				alert(getMessage("BL8222","BL"));	 
				 document.forms[0].policy_eff_frm_date.value = encounter_date_trunc.value;
				 document.forms[0].policy_eff_frm_date.focus();
			}
			//Added by Rajesh V - If logic
	 }
/* MMS-DM-SCF-0212 - Temp Policy Effective date changed as 'EffectiveToDate', earlier is Assigned to null,  */	
var pol_validity_chk_date=policy_eff_to_date.value;

if(approved_days.value != '' &&  approved_days.value != null)
{	      

 pol_validity_chk_date = plusDate(policy_eff_frm_date.value,'DMY',locale,eval(approved_days.value)-1,'d');
}
else if( exp_days.value != ''  && exp_days.value != null)
  {
  pol_validity_chk_date = plusDate(policy_eff_frm_date.value,'DMY',locale,eval(exp_days.value)-1,'d');
  }

/* Added V180321-Aravindh/IN67010 - Included extra condition in if
 * '|| ((exp_days.value == '' || exp_days.value == null) && (approved_days.value == '' || approved_days.value == null))'
 */ 
if( pol_validity_chk_date == null || pol_validity_chk_date == '' || ( policy_exp_date.value!=undefined && !isBefore(pol_validity_chk_date.value,policy_exp_date.value,'DMY',locale))
		|| ((exp_days.value == '' || exp_days.value == null) && (approved_days.value == '' || approved_days.value == null)))
  {
	document.forms[0].policy_eff_to_date.value  = 	policy_exp_date;

  }
 else		    	
  {
  document.forms[0].policy_eff_to_date.value  = 	 pol_validity_chk_date;
 }

if(validDateObj(policy_eff_frm_date,"DMY",locale) && validDateObj(document.forms[0].policy_eff_to_date,"DMY",locale) && isBefore(policy_eff_frm_date.value,document.forms[0].policy_eff_to_date.value,"DMY",locale)){
	var approvedDays = daysBetween(policy_eff_frm_date.value,document.forms[0].policy_eff_to_date.value,'DMY',locale);
	approvedDays = parseInt(approvedDays)+parseInt(1);
	approved_days.value = approvedDays;
}

	}

/* Code changes by Boopath for efault - PolicyStartdate /End date Approved Amounmt , Aprroved no of days Starts Here */
function LoadDefaultPolicyDateAndApprovedAmount(cust_group_code,cust_code,policy_type_code,strModuleId)
{
	 
	
//	alert("IN LoadDefaultPolicyDateAndApprovedAmount::::: ");
//	alert("CUSTOM GROUP CODE::::: "+cust_group_code);
//	 alert("cust_code::::: "+cust_code);
//	 alert("policy_type_code::::: "+policy_type_code);
	 //alert("policy_type_desc::::: "+policy_type_desc);
	 
	 
	// alert("strModuleId::::::"+strModuleId);
	
	var out;
	
	var xmlhttp;    
	/*if (str=="")
	  {
	  document.getElementById("txtHint").innerHTML="";
	  return;
	  }*/
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  //xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  xmlHttp = new XMLHttpRequest();
	  }
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
		  out = xmlhttp.responseText;
		  var response = out.substring(out.indexOf("!")+1,out.length);
		  var actual=response.split("~");
		  
		 var site_spec= document.getElementById('siteSpec').value;
		  if(site_spec=="true"){
		  if(actual[1]==null || actual[1]=='undefined' || actual[1]=='')
		  {
			  alert('Expiry date is not available in the Policy setup');
				document.forms[0].custValidToDate.value=actual[1];	
				document.forms[0].policy_type_desc.value='';
				return false;
				
		  }
			  
		  }  
			  
		  if(actual[0]!=null && actual[0] !='undefined')
		  document.forms[0].policy_start_date.value = actual[0];
		  if(actual[1]!=null && actual[1] !='undefined')
		  document.forms[0].policy_exp_date.value 	= actual[1];
		  if(actual[2]!=null && actual[2] !='undefined')
		  document.forms[0].credit_apprd_days.value = actual[2];
		  if(actual[3]!=null && actual[3] !='undefined')
		  document.forms[0].credit_apprd_amt.value 	= actual[3];
		  if(actual[4]!=null && actual[4] !='undefined')
		  document.forms[0].exp_days.value 	= actual[4];
			  
		  
		  var custid = document.forms[0].cust_id.value;	
		
		  if(custid=='ALMO') 			 policyDateHandle();
		  
	    }
	  }
	xmlhttp.open("POST","../../eBL/jsp/LoadDefaultPolicyDateAndApprovedAmount.jsp?cust_group_code="+cust_group_code+"&cust_code="+cust_code+"&policy_type_code="+policy_type_code+"&strModuleId="+strModuleId,true);
	xmlhttp.send(null);
	

}

/* Code changes by Boopath for efault - PolicyStartdate /End date Approved Amounmt , Aprroved no of days Ends Here */

function LoadDefaultPolicydetails(cust_group_code,cust_code,policy_type_code,strModuleId)
{
	 
	
//	alert("IN LoadDefaultPolicyDateAndApprovedAmount::::: ");
//	alert("CUSTOM GROUP CODE::::: "+cust_group_code);
//	 alert("cust_code::::: "+cust_code);
//	 alert("policy_type_code::::: "+policy_type_code);
	 //alert("policy_type_desc::::: "+policy_type_desc);
	 
	 
	// alert("strModuleId::::::"+strModuleId);
	
	var out;
	
	var xmlhttp;    
	/*if (str=="")
	  {
	  document.getElementById("txtHint").innerHTML="";
	  return;
	  }*/
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  //xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  xmlHttp = new XMLHttpRequest();
	  }
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
		  out = xmlhttp.responseText;
		  var response = out.substring(out.indexOf("!")+1,out.length);
		  var actual=response.split("~");
		  
		  
		  if(actual[0]!=null && actual[0] !='undefined' && (document.forms[0].policy_start_date.value == '' || document.forms[0].policy_start_date.value == undefined) )
		  document.forms[0].policy_start_date.value = actual[0];
		  if(actual[1]!=null && actual[1] !='undefined' && (document.forms[0].policy_exp_date.value == '' || document.forms[0].policy_exp_date.value == undefined) )
		  document.forms[0].policy_exp_date.value 	= actual[1];
		  if(actual[2]!=null && actual[2] !='undefined' && (document.forms[0].credit_apprd_days.value == '' || document.forms[0].credit_apprd_days.value == undefined) )
		  document.forms[0].credit_apprd_days.value = actual[2];
		  if(actual[3]!=null && actual[3] !='undefined' && (document.forms[0].credit_apprd_amt.value == '' || document.forms[0].credit_apprd_amt.value == undefined) )
		  document.forms[0].credit_apprd_amt.value 	= actual[3];
		  if(actual[4]!=null && actual[4] !='undefined' && (document.forms[0].exp_days.value == '' || document.forms[0].exp_days.value == undefined) )
		  document.forms[0].exp_days.value 	= actual[4];
			  
		  
		  var custid = document.forms[0].cust_id.value;	
		
		  if(custid=='ALMO') 			 policyDateHandle();
		  
	    }
	  }
	xmlhttp.open("POST","../../eBL/jsp/LoadDefaultPolicyDateAndApprovedAmount.jsp?cust_group_code="+cust_group_code+"&cust_code="+cust_code+"&policy_type_code="+policy_type_code+"&strModuleId="+strModuleId,true);
	xmlhttp.send(null);
	

}

function temp_test()
{
	
}
function adjustment_rule()
{
	var payer_desc=document.forms[0].payer_desc.value;
	var policy_type_desc=document.forms[0].policy_type_desc.value;
	var priority=document.forms[0].priority.value;
	var billing_group="";
	var blng_grp_select="";
	var action=document.forms[0].action.value;
	var locn=document.forms[0].locn.value;
	if(action=="add" && locn=="outside")
	{
		billing_group=document.forms[0].select_billing_group.value;
	}
	else if(action=="add" && locn=="inside")
	{
		billing_group=document.forms[0].blng_grp_code.value;
	}
	else
	{
		billing_group=document.forms[0].blng_grp_code.value;
	}

	var facility_id=document.forms[0].facility_id.value;
	var patient_class=document.forms[0].p_patient_class.value;
	
	if(action=="add" && locn=="outside")
	{
		if((!(payer_desc=="")) && (!(policy_type_desc=="")) && (!(priority=="")) && (!(billing_group=="")))
		{
			var cust_group_code = document.forms[0].ins_cust_group_code.value;
			var cust_code=document.forms[0].cust_3.value;
			var policy_type_code=document.forms[0].policy_type_code.value;
			cust_code=encodeURIComponent(cust_code);
			policy_type_code=encodeURIComponent(policy_type_code);
/*			parent.frames[1].location.href="../../eBL/jsp/BLInsuranceValidations.jsp?cust_code="+cust_code+"&policy_type_code="+policy_type_code+"&priority="+priority+"&facility_id="+facility_id+"&billing_group="+billing_group+"&patient_class="+patient_class+"&called_from=adj_rul";
*/
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			
			var param="cust_group_code="+encodeURIComponent(cust_group_code)+"&cust_code="+encodeURIComponent(cust_code)+"&policy_type_code="+encodeURIComponent(policy_type_code)+"&priority="+priority+"&facility_id="+facility_id+"&billing_group="+encodeURIComponent(billing_group)+"&patient_class="+patient_class+"&called_from=adj_rul";
			var temp_jsp="../../eBL/jsp/BLInsuranceValidations.jsp?"+param;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=trimString(xmlHttp.responseText);

			var retVal = responseText.split("&^&");

			document.forms[0].adj_rule_ind.value=retVal[0];
			document.forms[0].adj_perc_amt_ind.value=retVal[1];
			document.forms[0].adj_perc_amt_value.value=retVal[2];
			if(document.forms[0].adj_perc_amt_value.value != " " && document.forms[0].adj_perc_amt_value.value != "")
			{
				put_decimal(document.forms[0].adj_perc_amt_value,document.forms[0].noofdecimal.value);
			}
			document.forms[0].pmnt_diff_adj_int.value=retVal[3];
			document.forms[0].drg_pmnt_diff_adj_int.value=retVal[4];
			document.forms[0].spl_srv_pmnt_diff_adj_int.value=retVal[5];
			document.forms[0].pmnt_diff_adj_int_desc.value = retVal[6];

			if(document.forms[0].adj_rule_ind.value == "A")
				document.forms[0].adj_rule_ind_lis.value = "AUT";
			else
				document.forms[0].adj_rule_ind_lis.value = "NA";
			if(document.forms[0].adj_perc_amt_ind.value == "P")
				document.forms[0].adj_perc_amt_ind_lis.value = "PER";
			else if(document.forms[0].adj_perc_amt_ind.value == "A")
				document.forms[0].adj_perc_amt_ind_lis.value = "AMT";
			else
				document.forms[0].adj_perc_amt_ind_lis.value = "";
		}
	}
	else
	{
		if((!(payer_desc=="")) && (!(policy_type_desc=="")) && (!(priority=="")))
		{
			var cust_group_code = document.forms[0].ins_cust_group_code.value;
			var cust_code=document.forms[0].cust_3.value;
			var policy_type_code=document.forms[0].policy_type_code.value;
		/*	parent.frames[1].location.href="../../eBL/jsp/BLInsuranceValidations.jsp?cust_code="+cust_code+"&policy_type_code="+policy_type_code+"&priority="+priority+"&facility_id="+facility_id+"&billing_group="+billing_group+"&patient_class="+patient_class+"&called_from=adj_rul";
		*/
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			
			var param="cust_group_code="+encodeURIComponent(cust_group_code)+"&cust_code="+encodeURIComponent(cust_code)+"&policy_type_code="+encodeURIComponent(policy_type_code)+"&priority="+priority+"&facility_id="+facility_id+"&billing_group="+encodeURIComponent(billing_group)+"&patient_class="+patient_class+"&called_from=adj_rul";
			var temp_jsp="../../eBL/jsp/BLInsuranceValidations.jsp?"+param;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=trimString(xmlHttp.responseText);

			var retVal = responseText.split("&^&");

			document.forms[0].adj_rule_ind.value=retVal[0];
			document.forms[0].adj_perc_amt_ind.value=retVal[1];
			document.forms[0].adj_perc_amt_value.value=retVal[2];
			if(document.forms[0].adj_perc_amt_value.value != " " && document.forms[0].adj_perc_amt_value.value != "")
			{
				put_decimal(document.forms[0].adj_perc_amt_value,document.forms[0].noofdecimal.value);
			}
			document.forms[0].pmnt_diff_adj_int.value=retVal[3];
			document.forms[0].drg_pmnt_diff_adj_int.value=retVal[4];
			document.forms[0].spl_srv_pmnt_diff_adj_int.value=retVal[5];
			document.forms[0].pmnt_diff_adj_int_desc.value = retVal[6];

			if(document.forms[0].adj_rule_ind.value == "A")
				document.forms[0].adj_rule_ind_lis.value = "AUT";
			else
				document.forms[0].adj_rule_ind_lis.value = "NA";
			if(document.forms[0].adj_perc_amt_ind.value == "P")
				document.forms[0].adj_perc_amt_ind_lis.value = "PER";
			else if(document.forms[0].adj_perc_amt_ind.value == "A")
				document.forms[0].adj_perc_amt_ind_lis.value = "AMT";
			else
				document.forms[0].adj_perc_amt_ind_lis.value = "";
		}
	}
	return true;
//	apprvd_amt_days_check();
}

function disableAllElements_modify()
{
	var len = document.forms[0].elements.length;

	for(var i=0;i<len;i++)
	{
		document.forms[0].elements(i).disabled=true;
	}
	document.forms[0].modify_button.disabled=false;
	document.forms[0].cancel_button.disabled=false;
}

function disableAllElements_remove()
{
	var len = document.forms[0].elements.length;

	for(var i=0;i<len;i++)
	{
		document.forms[0].elements(i).disabled=true;
	}
//	document.forms[0].remove_button.disabled=false;
	document.forms[0].cancel_button.disabled=false;
}

function enableAllElements_modify()
{
	var len = document.forms[0].elements.length;
	for(var i=0;i<len;i++)
	{
		document.forms[0].elements(i).disabled=false;
	}
//	document.forms[0].remove_button.disabled=true;
	document.forms[0].modify_button.disabled=true;

	var restricted_YN=document.forms[0].restricted_YN.value;

	if(restricted_YN=="DISABLED")
	{
		document.forms[0].credit_apprd_amt.disabled=true;
		document.forms[0].credit_apprd_days.disabled=true;
	}
}


function remove_payer()
{
	parent.window.returnValue = "remove";
	parent.window.close();
	
}

function chkPolicyStartDateMain(policy_start_date,policy_exp_date,encounter_date)
{
	if(chkPolicyStartDate(policy_start_date,policy_exp_date,encounter_date))
		return dflt_policy_eff_frm_to_date();
	else
		return false;
}

function chkPolicyExpiryDateMain(policy_start_date,policy_exp_date,encounter_date)
{
	
	if(chkPolicyExpiryDate(policy_start_date,policy_exp_date,encounter_date))
		return dflt_policy_eff_frm_to_date();
	else
		return false;
}

function chkPolicyEffFromDateMain(policy_eff_frm_date,policy_eff_to_date,policy_start_date,policy_exp_date,encounter_date_aft_trunc)
{
	
	var blng_grp_code = document.forms[0].blng_grp_code.value;
	var payer_group_code = document.forms[0].ins_cust_group_code.value;
	var payer_code = document.forms[0].cust_3.value;
	var policy_type_code = document.forms[0].policy_type_code.value;
	var policy_no = document.forms[0].policy_no.value;
	var priority = document.forms[0].priority.value;

	if(policy_eff_frm_date.value != "")
	{
		if(chkPolicyEffFromDate(policy_eff_frm_date,policy_eff_to_date,policy_start_date,policy_exp_date,encounter_date_aft_trunc))
		{
			if(chk_pol_eff_date_validity(policy_eff_frm_date,'I'))
			{
				return pol_eff_dates_check(blng_grp_code,payer_group_code,payer_code,policy_type_code,policy_no,priority,policy_start_date,policy_exp_date,policy_eff_frm_date,policy_eff_to_date);
			}
			else
				return false;
		}
		else
			return false;
	}
	else
		return true;
}

function set_blng_values()
{
	document.forms[0].blng_grp_code.value=document.forms[0].select_billing_group.value;
	var billing_group =document.forms[0].blng_grp_code.value;

//	parent.frames[1].location.href="../../eBL/jsp/BLInsuranceValidations.jsp?billing_group="+billing_group+"&called_from=bg_curr_code";

	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	
	var param="billing_group="+encodeURIComponent(billing_group)+"&called_from=bg_curr_code";
	var temp_jsp="../../eBL/jsp/BLInsuranceValidations.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText);
	document.forms[0].curr_code_for_bg.value=responseText;
}

function set_selected_blng_grp()
{
	var curr_code_for_bg = document.forms[0].curr_code_for_bg.value;
	
	if(curr_code_for_bg == '' || curr_code_for_bg == null || curr_code_for_bg == 'null' || curr_code_for_bg ==undefined ||curr_code_for_bg == 'undefined')
		{
		set_blng_values();
		check_priority();
		}
		
	}

function apprvd_amt_days_check()
{
	var episode_type=document.forms[0].episode_type.value;
	var facility_id=document.forms[0].facility_id.value;
	var cust_group_code=document.forms[0].ins_cust_group_code.value;
	var cust_code=document.forms[0].cust_3.value;
	var policy_type_code=document.forms[0].policy_type_code.value;
	var payer_desc=document.forms[0].payer_desc.value;
	var policy_type_desc=document.forms[0].policy_type_desc.value;
	var policy_no=document.forms[0].policy_no.value; 
	var credit_auth_ref = document.forms[0].credit_auth_ref.value;
	var credit_auth_date = document.forms[0].credit_auth_date.value;
	var encounter_date_aft_trunc = document.forms[0].encounter_date_aft_trunc.value; 

	if(payer_desc!="" && policy_type_desc!="")
	{
		var action=document.forms[0].action.value;

		if(action=="modify" || action=="add")
			document.forms[0].modify_refresh.value="Y";

		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		
		var param="episode_type="+episode_type+"&facility_id="+facility_id+"&cust_group_code="+encodeURIComponent(cust_group_code)+"&cust_code="+encodeURIComponent(cust_code)+"&policy_type_code="+encodeURIComponent(policy_type_code)+"&called_from=cust_pol_change";
		var temp_jsp="../../eBL/jsp/BLInsuranceValidations.jsp?"+param;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=trimString(xmlHttp.responseText);
		
		var retVal = responseText;
		var retArr = retVal.split("/");
		document.forms[0].restrict_check.value = retArr[0];
		document.forms[0].apprd_amt_restrict_check.value = retArr[1];		
		document.forms[0].apprd_days_restrict_check.value = retArr[2];
		document.forms[0].cred_auth_req_yn.value =  retArr[3];
		document.forms[0].dflt_auth_ref_as_pol_no_yn.value = retArr[4];
		document.forms[0].policy_coverage_basis_ind.value = retArr[5];
		document.forms[0].cred_auth_mand_capt_yn.value = retArr[6];

		if(retArr[0]=="R")
		{
			document.forms[0].restricted_YN.value="";
				
			if(retArr[1]=="U")
			{
				document.forms[0].credit_apprd_amt.disabled = true;
				document.getElementById('apprd_amt_leg_disp').style.display = "none";
				document.getElementById('apprd_amt_val_disp').style.display = "none";
				/**** added for package billing *********** start *********commented for IN 20964****
				if(document.forms[0].package_enabled_yn.value=="Y" && document.getElementById('addl_apprv_leg_disp') !=null){
					document.getElementById('addl_apprv_leg_disp').style.display = "none";
					document.getElementById('addl_apprv_val_disp').style.display = "none";
					parent.PayerDtls.location.href="../../eCommon/html/blank.html";
					parent.PkgDtls.location.href="../../eCommon/html/blank.html";
					

				}
				**** added for package billing *********** end *************/
				/**** added for package billing *********** start *********changed for IN 20964****/
				if(document.forms[0].package_enabled_yn.value=="Y" && document.getElementById('addl_apprv_leg_disp') !=null){
					document.getElementById('addl_apprv_leg_disp').style.display = "inline";
					document.getElementById('addl_apprv_val_disp').style.display = "inline";
					parent.PayerDtls.location.href="../../eCommon/html/blank.html";
					parent.PkgDtls.location.href="../../eCommon/html/blank.html";
					parent.PkgDiscDtls.location.href="../../eCommon/html/blank.html";
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					var updation=formValidation(xmlStr,"clearBean");
				}
				/**** added for package billing *********** end *************/
				document.forms[0].credit_apprd_amt.value="";
			}
			else if(retArr[1]=="R")
			{
				document.forms[0].credit_apprd_amt.disabled = false;
				document.getElementById('apprd_amt_leg_disp').style.display = "inline";
				document.getElementById('apprd_amt_val_disp').style.display = "inline";
				/**** added for package billing *********** start ****commented for IN 20964*********
				if(document.forms[0].package_enabled_yn.value=="Y" && document.getElementById('addl_apprv_leg_disp') !=null && document.getElementById('credit_auth_leg_disp').style.display=="inline" && document.getElementById('credit_auth_val_disp').style.display=="inline"){
					document.getElementById('addl_apprv_leg_disp').style.display = "inline";
					document.getElementById('addl_apprv_val_disp').style.display = "inline";
					parent.PayerDtls.location.href="../../eCommon/html/blank.html";
					parent.PkgDtls.location.href="../../eCommon/html/blank.html";

				}
				**** added for package billing *********** end *************/
				/**** added for package billing *********** start ****change for IN 20964*********/
				if(document.forms[0].package_enabled_yn.value=="Y" && document.getElementById('addl_apprv_leg_disp') !=null){
					document.getElementById('addl_apprv_leg_disp').style.display = "inline";
					document.getElementById('addl_apprv_val_disp').style.display = "inline";
					parent.PayerDtls.location.href="../../eCommon/html/blank.html";
					parent.PkgDtls.location.href="../../eCommon/html/blank.html";
					parent.PkgDiscDtls.location.href="../../eCommon/html/blank.html";
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					var updation=formValidation(xmlStr,"clearBean");
				}
				/**** added for package billing *********** end ****change for IN 20964*********/

				
			}

			if(retArr[2]=="U")
			{
				document.forms[0].credit_apprd_days.disabled = true;
				document.getElementById('apprd_days_leg_disp').style.display = "none";
				document.getElementById('apprd_days_val_disp').style.display = "none";
				document.forms[0].credit_apprd_days.value="";
			}
			else if(retArr[2]=="R")
			{
				document.forms[0].credit_apprd_days.disabled = false;
				document.getElementById('apprd_days_leg_disp').style.display = "inline";
				document.getElementById('apprd_days_val_disp').style.display = "inline";
			}
		}
		else 
		{
			document.forms[0].restricted_YN.value="DISABLED";
			document.getElementById('apprd_amt_leg_disp').style.display = "none";
			document.getElementById('apprd_amt_val_disp').style.display = "none";
			/**** added for package billing *********** start ****commented for IN 20964*********
			if(document.forms[0].package_enabled_yn.value=="Y" && document.getElementById('addl_apprv_leg_disp') !=null){
				document.getElementById('addl_apprv_leg_disp').style.display = "none";
				document.getElementById('addl_apprv_val_disp').style.display = "none";
				parent.PayerDtls.location.href="../../eCommon/html/blank.html";
				parent.PkgDtls.location.href="../../eCommon/html/blank.html";
			}
			**** added for package billing *********** end *************/
			/**** added for package billing *********** end *************/
			if(document.forms[0].package_enabled_yn.value=="Y" && document.getElementById('addl_apprv_leg_disp') !=null){
					document.getElementById('addl_apprv_leg_disp').style.display = "inline";
					document.getElementById('addl_apprv_val_disp').style.display = "inline";
					parent.PayerDtls.location.href="../../eCommon/html/blank.html";
					parent.PkgDtls.location.href="../../eCommon/html/blank.html";
					parent.PkgDiscDtls.location.href="../../eCommon/html/blank.html";
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					var updation=formValidation(xmlStr,"clearBean");
				}
			/**** added for package billing *********** end *************/
			document.getElementById('apprd_days_leg_disp').style.display = "none";
			document.getElementById('apprd_days_val_disp').style.display = "none";
			document.forms[0].credit_apprd_amt.value="";
			document.forms[0].credit_apprd_days.value="";
		}

		if(retArr[3]=="Y")
		{
			document.getElementById('credit_auth_leg_disp').style.display = "inline";
			document.getElementById('credit_auth_val_disp').style.display = "inline";
		//	alert('document.getElementById('apprd_amt_leg_disp').style='+document.getElementById('apprd_amt_leg_disp').style.display)
		/**** added for package billing *********** start *****commented for IN 20964********
			if(document.forms[0].package_enabled_yn.value=="Y" && document.getElementById('addl_apprv_leg_disp') !=null && document.getElementById('apprd_amt_leg_disp').style.display=="inline" && document.getElementById('apprd_amt_val_disp').style.display=="inline"){
					document.getElementById('addl_apprv_leg_disp').style.display = "inline";
					document.getElementById('addl_apprv_val_disp').style.display = "inline";
					parent.PayerDtls.location.href="../../eCommon/html/blank.html";
					parent.PkgDtls.location.href="../../eCommon/html/blank.html";
			}
			**** added for package billing *********** end *************/
			document.getElementById('credit_auth_date_leg_disp').style.display = "inline";
			document.getElementById('credit_auth_date_val_disp').style.display = "inline";
			
			if(retArr[6] == "Y")
			{
				document.getElementById('credit_auth_ref_mand').style.display = "inline";	
				document.getElementById('credit_auth_ref_date_mand').style.display = "inline";	
			}
			else
			{
				document.getElementById('credit_auth_ref_mand').style.display = "none";	
				document.getElementById('credit_auth_ref_date_mand').style.display = "none";	
			}

			if(retArr[4]=="Y")
			{
				if(policy_no!="" && credit_auth_ref=="")
				{
					var policy_no_len = policy_no.length;
					if(policy_no_len <=20 )
						document.forms[0].credit_auth_ref.value = policy_no.substring(0,policy_no_len);
					else
						document.forms[0].credit_auth_ref.value = policy_no.substring(0,20);
				}
			}
			if(retArr[6] == "Y")
			{
				if(credit_auth_date=="")
				{
					document.forms[0].credit_auth_date.value = encounter_date_aft_trunc;
				}
			}
			else
			{
				if(document.forms[0].credit_auth_ref.value == "" && credit_auth_date !="")
				{
					document.forms[0].credit_auth_date.value = "";
				}
			}
		}
		else
		{
			document.getElementById('credit_auth_leg_disp').style.display = "none";
			document.getElementById('credit_auth_val_disp').style.display = "none";
			/**** added for package billing *********** start *******commented for IN 20964******
		if(document.forms[0].package_enabled_yn.value=="Y" && document.getElementById('addl_apprv_leg_disp') !=null){
			document.getElementById('addl_apprv_leg_disp').style.display = "none";
			document.getElementById('addl_apprv_val_disp').style.display = "none";
			parent.PayerDtls.location.href="../../eCommon/html/blank.html";
			parent.PkgDtls.location.href="../../eCommon/html/blank.html";
			}
			**** added for package billing *********** end *************/

			document.getElementById('credit_auth_date_leg_disp').style.display = "none";
			document.getElementById('credit_auth_date_val_disp').style.display = "none";
			document.getElementById('credit_auth_ref_mand').style.display = "none";	
			document.getElementById('credit_auth_ref_date_mand').style.display = "none";	
			document.forms[0].credit_auth_ref.value = "";
			document.forms[0].credit_auth_date.value = "";
		}
		
		return true;
	}
	else
	{
		return true;
	}
}

function dflt_policy_eff_frm_to_date()
{
	var policy_start_date=document.forms[0].policy_start_date.value;
	var policy_exp_date=document.forms[0].policy_exp_date.value;
	var policy_eff_frm_date=document.forms[0].policy_eff_frm_date;
	var policy_eff_to_date=document.forms[0].policy_eff_to_date;
	var encounter_date_aft_trunc = document.forms[0].encounter_date_aft_trunc.value;
	var module_id = document.forms[0].calling_module_id.value;
	var locale=document.forms[0].locale.value;
	
	var cust_id =  document.forms[0].cust_id.value;
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	var site3TierAlmoFeatureYN =  document.forms[0].site3TierAlmoFeatureYN.value;
	if(cust_id == "ALMO" || site3TierAlmoFeatureYN == "Y")  
		return true;
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1

	if(policy_start_date!="" && policy_exp_date!="")
	{
		if(module_id == "MP")
		{
			if(!isBeforeNow(document.forms[0].policy_start_date.value,'DMY',locale))
			{
				policy_eff_frm_date.value=policy_start_date;
			}
			else
			{
				policy_eff_frm_date.value=encounter_date_aft_trunc;
			}
		}
		else if(module_id == "IP" || module_id == "DC")
		{
			if(!isBefore(document.forms[0].policy_start_date.value,encounter_date_aft_trunc,"DMY",locale))
//			if(!isBeforeNow(document.forms[0].policy_start_date.value,'DMY',locale))
			{
				policy_eff_frm_date.value=policy_start_date;
			}
			else
			{
				policy_eff_frm_date.value=encounter_date_aft_trunc;
			}
		}
		else
		{
			policy_eff_frm_date.value=encounter_date_aft_trunc;
		}
	
		policy_eff_to_date.value=policy_exp_date;

		//chkPolicyEffFromDateMain(policy_eff_frm_date,policy_eff_to_date,document.forms[0].policy_start_date,document.forms[0].policy_exp_date,encounter_date_aft_trunc);
	}
	else
	{
		policy_eff_frm_date.value = "";
		policy_eff_to_date.value = "";
	}
	return true;
}

function dflt_pol_eff_frm_date()
{
	
	
	var policy_eff_frm_date = document.forms[0].policy_eff_frm_date;
	var encounter_date_aft_trunc = document.forms[0].encounter_date_aft_trunc;
	var module_id = document.forms[0].calling_module_id.value;
	var modify_refresh = document.forms[0].modify_refresh.value;
	var locale=document.forms[0].locale.value;
	var rec_edited_YN = document.forms[0].rec_edited_YN.value;

	if(rec_edited_YN == "N" || rec_edited_YN == "")
	{
		if(module_id != 'MP')
		{
			if(module_id == 'IP' || module_id == 'DC')
			{
				if(modify_refresh == 'Y')
				{
					if(policy_eff_frm_date.value =="")
						policy_eff_frm_date.value = encounter_date_aft_trunc.value;
				}
				else
				{
					if(!isBeforeNow(document.forms[0].policy_start_date.value,'DMY',locale))
					{
						policy_eff_frm_date.value = policy_eff_frm_date.value;//No change in date
					}
					else
					{
						policy_eff_frm_date.value = encounter_date_aft_trunc.value;
					}
				}
			}
			else
			{
				if(modify_refresh == 'Y')
				{
					if(policy_eff_frm_date.value =="")
						policy_eff_frm_date.value = encounter_date_aft_trunc.value;
				}
				else
				{
					//Added By Vijay For MMS-QF-SCf-567
					if(document.forms[0].payer_desc.value!=''){
					policy_eff_frm_date.value = encounter_date_aft_trunc.value;
							}
				}
			}
		}
	}
	
}

function bring_focus()
{
	var modify_refresh=document.forms[0].modify_refresh.value;
	if(modify_refresh=="Y")
	{
		var payer_desc=document.forms[0].payer_desc.value;
		var policy_type_desc=document.forms[0].policy_type_desc.value;
		var priority=document.forms[0].priority.value;

		if(payer_desc!="" && policy_type_desc!="")
		{
			document.forms[0].policybut.focus();
		}
	}
}

function check_priority()
{
	var total_records=document.forms[0].totalRecords.value;
	var action=document.forms[0].action.value;
	var locn=document.forms[0].locn.value;

	var select_billing_group=document.forms[0].blng_grp_code.value;
	var priority=document.forms[0].priority;
	var max_priority=document.forms[0].max_priority.value;

	var existing_priority_modify="";

	var priorities=document.forms[0].priority_arr.value;
	var priority_arr=priorities.split(',');

	if(parseInt(priority.value)==0)
	{
		alert(getMessage("BL9833","BL"));
		priority.select();
		return false;
	}

	if(action=="modify")
		existing_priority_modify=document.forms[0].existing_priority_modify.value;

	if(priority.value!="" )
	{
		for (var i=0;i<priority_arr.length;i++)
		{
			var priority_var1 = priority_arr[i];

			if((parseInt(priority_var1)==parseInt(priority.value)) && (( parseInt(priority.value) !=  parseInt(existing_priority_modify) && action=="modify") || action!="modify" ))
			{
				alert(getMessage("BL9831","BL"));
				priority.select();
				return false;
			}
		}
	}

	if(select_billing_group!="" && priority.value!="" )
	{
		if(locn=="outside" && total_records>=1)
		{
			var total_keys=document.forms[0].total_keys.value;
			var max_priorities=document.forms[0].max_priority_arr.value;
			var min_priorities=document.forms[0].min_priority_arr.value;

			var total_keys_arr=total_keys.split(',');
			var max_priority_arr=max_priorities.split(',');
			var min_priority_arr=min_priorities.split(',');

			var prev_blng_grp_max_prio="";
			var next_blng_grp_min_prio="";

			for(var i=0;i<total_keys_arr.length;i++)
			{
				if(total_keys_arr[i]==select_billing_group)
				{
					if(max_priority_arr[i-1] != null)
						prev_blng_grp_max_prio=max_priority_arr[i-1];

					if(min_priority_arr[i+1] != null)
						next_blng_grp_min_prio=min_priority_arr[i+1];

					if(prev_blng_grp_max_prio != "")
					{
						if(parseInt(priority.value) <= parseInt(prev_blng_grp_max_prio))
						{
							alert(getMessage("BL9829","BL"));
							priority.select();
							return false;
						}
					}
					if(next_blng_grp_min_prio != "")
					{
						if(parseInt(priority.value) >= parseInt(next_blng_grp_min_prio))
						{
							alert(getMessage("BL9830","BL"));
							priority.select();
							return false;
						}
					}
				}
			}
		}
		else if(locn=="inside")
		{
			if(parseInt(priority.value) <= max_priority)
			{
				alert(getMessage("BL9831","BL"));
				priority.select();
				return false;
			}
		}
	}
}

function chk_for_decimal(obj,cld_frm)
{
	var form_var=obj.value;

	var count="";
	count=form_var.indexOf(".");

	if(parseInt(count) >= 0)
	{
		if(cld_frm != "I")
		{
			alert(getMessage("BL9832","BL"));
		}
		obj.select();
		return false;
	}
	return true;
}

function dflt_pol_no_2_credit_auth(pol_no)
{
	var cred_auth_req_yn = document.forms[0].cred_auth_req_yn.value;
	var cred_auth_mand_capt_yn = document.forms[0].cred_auth_mand_capt_yn.value;
	var dflt_auth_ref_as_pol_no_yn = document.forms[0].dflt_auth_ref_as_pol_no_yn.value;
	var policy_no = pol_no.value;
	var credit_auth_ref ="";

	if(cred_auth_req_yn =="Y" && dflt_auth_ref_as_pol_no_yn=="Y" && cred_auth_mand_capt_yn=="Y")
	{
		credit_auth_ref = policy_no.substring(0,20);
		document.forms[0].credit_auth_ref.value = credit_auth_ref;
	}

	check_for_related_policies('B');
}

function chk_for_valid_apprv_days_entry()
{
	var policy_eff_frm_date = document.forms[0].policy_eff_frm_date.value;
	var policy_eff_to_date = document.forms[0].policy_eff_to_date.value;
	var credit_apprd_days = document.forms[0].credit_apprd_days.value;
	var locale=document.forms[0].locale.value;
	var apprd_days_restrict_check = document.forms[0].apprd_days_restrict_check.value;

	if(apprd_days_restrict_check == "R")
	{
		if(policy_eff_frm_date != "" && policy_eff_to_date != "" && credit_apprd_days !="")
		{
			var no_of_days = eval(daysBetween(policy_eff_frm_date,policy_eff_to_date,"DMY",locale))+1;

			if(eval(credit_apprd_days) >  eval(no_of_days))
			{
				alert(getMessage("BL0029","BL"));
//				document.forms[0].credit_apprd_days.select();
				return false;
			}
			else
			{
				return true;
			}
		}
		else
		{
			return true;
		}
	}
	else
	{
		return true;
	}
}

function chkvalidcustYN()
{
	var cust_valid_from_date = document.forms[0].cust_valid_from_date.value;
	var cust_valid_to_date = document.forms[0].cust_valid_to_date.value;
	var encounter_date_aft_trunc = document.forms[0].encounter_date_aft_trunc;
	var locale = document.forms[0].locale.value;

	if(locale != 'en')
	{
		cust_valid_from_date=convertDate(cust_valid_from_date,'DMY','en',locale);
		cust_valid_to_date=convertDate(cust_valid_to_date,'DMY','en',locale);
	}

	if(cust_valid_from_date != "")
	{
		if(!isAfter(encounter_date_aft_trunc.value,cust_valid_from_date,'DMY',locale))
		{
			//Added by Rajesh V - If logic
			var strModuleId = document.forms[0].calling_module_id.value;
			if(strModuleId != 'MP'){
				alert(getMessage("BL8227","BL"));
				return false;
			}
			//Added by Rajesh V - If logic
		}
	}
	if(cust_valid_to_date != "")
	{
		if(!isBefore(encounter_date_aft_trunc.value,cust_valid_to_date,'DMY',locale))
		{
			alert(getMessage("BL8227","BL"));
			return false;
		}
	}
	return true;
}

function srch_by_crit_for_cust()
{
	var srch_by = document.forms[0].search_by_items.value;
/*
	if(srch_by == "CG")
	{
		document.getElementById('srch_by_leg').innerText=getLabel("eBL.CUSTOMER_GROUP.label","BL");
	}
	else
*/
	if (srch_by == "CY")
	{
		document.getElementById('srch_by_leg').innerText=getLabel("Common.country.label","common");
	}
	else if (srch_by == "RN")
	{
		document.getElementById('srch_by_leg').innerText=getLabel("eMP.region.label","MP");
	}
	
	if(document.forms[0].modify_refresh.value != 'Y')
	{
		document.forms[0].srch_by_desc.value='';
		document.forms[0].search_code.value = '';
	}

	if(document.forms[0].modify_refresh.value == 'Y')
		document.forms[0].modify_refresh.value = '';
}

function srchbylkup(clng_evnt)
{	
	var srch_by = document.forms[0].search_by_items.value;
	var locale = document.forms[0].locale.value;

	var target_code	= document.forms[0].search_code ;
	var target = document.forms[0].srch_by_desc;
	
	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].srch_by_desc.value='';
			document.forms[0].search_code.value = '';
			return;
		}
	}

	var message="";
	var retVal				= new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var title				= "";
	var column_descriptions = "";

/*	
	if(srch_by == "CG")
	{
		var title=getLabel("eBL.CUSTOMER_GROUP.label","BL"); 
		title=encodeURIComponent(title);		
		
		sql = "	select cust_group_code CUST_GRP_CODE,short_desc SHORT_NAME from ar_cust_group_lang_vw  where  language_id='"+locale+"' and status is null";	
	}
	else 
*/
	if (srch_by == "CY")
	{
		var title=getLabel("Common.country.label","common"); 
		title=encodeURIComponent(title);		
		
		sql = "select country_code COUNTRY_CODE,short_name SHORT_NAME from mp_country_lang_vw where language_id='"+locale+"' and eff_status = 'E'";	
	}
	else if (srch_by == "RN")
	{
		var title=getLabel("eMP.region.label","MP"); 
		title=encodeURIComponent(title);		
		
		sql = "select region_code REGION_CODE,short_desc SHORT_NAME from mp_region_lang_vw where language_id='"+locale+"' and eff_status = 'E'";	
	}

	var column_sizes = escape("30%,70%");
	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);

	column_descriptions = code+","+desc;

	sql=escape(sql);

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";

	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);	
	
	var arr=new Array();

	if (!(retVal == null))
	{
  	    var retVal=unescape(retVal);
		arr=retVal.split("^~^");

		target.value=arr[1];
		target_code.value = arr[0];
	}
	else
	{	
		target.value='';
		target_code.value = '';
	}
}

function chk_pol_eff_date_validity(obj,cld_frm)
{
	var policy_eff_frm_date = document.forms[0].policy_eff_frm_date;
	var credit_apprd_days = document.forms[0].credit_apprd_days;
	var encounter_date_aft_trunc = document.forms[0].encounter_date_aft_trunc;
	var locale=document.forms[0].locale.value;
	var apprd_days_restrict_check = document.forms[0].apprd_days_restrict_check.value;
	var module_id = document.forms[0].calling_module_id.value;

	if(module_id != 'MP')
	{
		if(policy_eff_frm_date.value != "" && credit_apprd_days.value != "" && apprd_days_restrict_check=='R')
		{
			if(chk_for_decimal(credit_apprd_days,'I'))
			{
				var pol_validity_chk_date = plusDate(policy_eff_frm_date.value,'DMY',locale,eval(credit_apprd_days.value)-1,'d');

				if(!isAfter(pol_validity_chk_date,encounter_date_aft_trunc.value,'DMY',locale))
				{
					alert(getMessage("BL6203","BL"));
	/*
					if(cld_frm == 'I')
					{
						obj.vale='';
						obj.focus();
					}
	*/
					return false;
				}
				else
				{
					document.forms[0].pol_validity_chk_date.value=pol_validity_chk_date;
					return true;
				}
			}
		}
		else
		{
			return true;
		}
	}
	else
	{
		return true;
	}
}

function CheckForChar(Obj)
{
	var check_var = Obj.value;

	numList = '1234567890.';
	
	for (i=0;i<check_var.length;i++)
	{
		if (numList.indexOf(check_var.charAt(i)) == -1) 
		{
			alert(getMessage("CANNOT_BE_SPECIAL_CHAR",'Common'));
			Obj.select();
			return false;  
		}
	}
	return true;
}

function CheckSplApprAmt(Obj)
{
	var flag = CheckForChar(Obj);

	if(flag)
	{
		put_decimal(Obj,document.forms[0].noofdecimal.value);
		return true;
	}
	else
	{
		return false;
	}
}

function CheckSplApprDays(Obj)
{
	var flag = CheckForChar(Obj);

	if(flag)
	{
		if(chk_for_decimal(Obj))
		{
			if(chk_for_valid_apprv_days_entry())
			{
				if(chk_pol_eff_date_validity(document.forms[0].credit_apprd_days,"I"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	else
	{
		return false;
	}
}

function priority_checks(obj)
{
	if(chk_for_decimal(obj))
	{
		if(adjustment_rule())
		{
			check_priority();
		}
	}
}

function adj_rule_ind_set(obj)
{
	var adj_rule_ind_v=obj.value;

	if(adj_rule_ind_v=="AUT")
	{
		document.forms[0].adj_rule_ind.value="A";

		document.forms[0].adj_perc_amt_value.disabled=false;	
		document.forms[0].adj_perc_amt_ind_lis.disabled=false;
		document.forms[0].pmnt_diff_adj_int.disabled=false;
		document.forms[0].pmnt_diff_adj_int_desc.disabled=false;
		document.forms[0].adj_diff_btn.disabled=false;
	}
	else if(adj_rule_ind_v=="NA")
	{
		document.forms[0].adj_perc_amt_ind_lis.selectedIndex=0;
		document.forms[0].adj_rule_ind.value="";

		document.forms[0].adj_perc_amt_ind.value="";
		document.forms[0].adj_perc_amt_value.value="";
		document.forms[0].pmnt_diff_adj_int_desc.value="";
		document.forms[0].pmnt_diff_adj_int.value="";
		
		document.forms[0].adj_perc_amt_ind_lis.disabled=true;
		document.forms[0].adj_perc_amt_value.disabled=true;			
		document.forms[0].pmnt_diff_adj_int.disabled=true;
		document.forms[0].pmnt_diff_adj_int_desc.disabled=true;
		document.forms[0].adj_diff_btn.disabled=true;
	}
}

function adj_perc_amt_ind_set(obj)
{
	var adj_perc_amt_ind_v=obj.value;
	if(adj_perc_amt_ind_v=="PER")
	{
		document.forms[0].adj_perc_amt_ind.value="P";
	}
	else if(adj_perc_amt_ind_v=="AMT")
	{
		document.forms[0].adj_perc_amt_ind.value="A";
	}
	document.forms[0].adj_perc_amt_value.value="";
}

function adjinterfacelkp(clng_evnt)
{
	var target	 = document.forms[0].pmnt_diff_adj_int_desc;		
	var adj_code = document.forms[0].pmnt_diff_adj_int.value;		
	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].pmnt_diff_adj_int.value = "";
			document.forms[0].pmnt_diff_adj_int_desc.value = "";
			return;
		}
	}

	var retVal			= new String();	

	var dialogTop			= "240";
	var dialogHeight		= "32" ;
	var dialogWidth			= "50" ;
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var sql1				= "";	
//	var title=encodeURIComponent(getLabel("eBL.PRACT_STAFF_TYPE.label","BL"));
	var title=getLabel("eBL.ADJUSTMENT_INTERFACE_CODE.label","BL");
	title = encodeURIComponent(title);
	var column_sizes = escape("20%,60%");
	var acc_code=encodeURIComponent(getLabel("eBL.ADJUSTMENT_INTERFACE_CODE.label","bl"));
	var acc_desc=encodeURIComponent(getLabel("Common.description.label","common"));
	var message="";
	var column_descriptions =acc_desc+","+acc_code;
	var locale = document.forms[0].locale.value;
	var facility_id		= document.forms[0].facility_id.value;	


	sql1="SELECT acc_int_desc description,acc_int_code code FROM bl_gl_account_lang_vw WHERE SubStr(acc_int_code ,1,1)='R' and NVL(status, 'X') != 'S' AND acc_entity_code = (select acc_entity_code from sy_acc_entity where acc_entity_id='"+facility_id+"' and LANGUAGE_ID='"+locale+"') and language_id='"+locale+"'";

	sql = escape(sql1);							

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=1"+"&col_show_hide=YY";
	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);		

	var arr=new Array();	
	if(retVal == null) retVal='';
	if (retVal != null || retVal!="")
	{
		if(retVal!='undefined' && retVal!=undefined)
		{
			var retVal=unescape(retVal);	

			if(retVal != null && retVal.length>0)
			{
			arr=retVal.split("^~^");	
			document.forms[0].pmnt_diff_adj_int.value=arr[1];		
			document.forms[0].pmnt_diff_adj_int_desc.value=arr[0];
			}
		}
	}
}

function adj_amt_chk(obj)
{

	var amt_check = CheckSplApprAmt(obj);
	if(amt_check)
	{
		var adj_perc_amt_value = document.forms[0].adj_perc_amt_value.value;
		var adj_perc_amt_ind = document.forms[0].adj_perc_amt_ind.value;

		if(adj_perc_amt_ind=='P')
		{
			if(eval(adj_perc_amt_value) < 1 || eval(adj_perc_amt_value) >100)
			{
				alert(getMessage("BL8115","BL"));
				document.forms[0].adj_perc_amt_value.select();
			}
		}
	}
}

function adj_perc_amt_lis()
{
	var adj_rule_ind_v=document.forms[0].adj_rule_ind_lis.value;
	var adj_rule_ind=document.forms[0].adj_rule_ind.value;
	var adj_perc_amt_ind=document.forms[0].adj_perc_amt_ind.value;

	if(adj_rule_ind!='A' )
	{
		document.forms[0].adj_perc_amt_ind_lis.selectedIndex=0;
		document.forms[0].adj_perc_amt_ind.value="";
		document.forms[0].adj_perc_amt_value.value="";
		document.forms[0].pmnt_diff_adj_int_desc.value="";
		document.forms[0].pmnt_diff_adj_int.value="";
		document.forms[0].adj_rule_ind.value="";
		document.forms[0].adj_perc_amt_ind.value="";
		document.forms[0].adj_perc_amt_ind_lis.disabled=true;
		document.forms[0].adj_perc_amt_value.disabled=true;			
		document.forms[0].pmnt_diff_adj_int.disabled=true;
		document.forms[0].pmnt_diff_adj_int_desc.disabled=true;
		document.forms[0].adj_diff_btn.disabled=true;
	}
}

function CheckSplAdjVal(Obj)
{
	var flag = CheckForChar(Obj);

	if(flag)
	{
		put_decimal(Obj,document.forms[0].noofdecimal.value);
	}
	else
	{
		return false;
	}
}

function pol_eff_dates_check(blng_grp_code,payer_group_code,payer_code,policy_type_code,policy_no,priority,policy_start_date,policy_exp_date,policy_eff_frm_date,policy_eff_to_date)
{
	var checked_row = document.forms[0].checked_row.value;
	var locn = document.forms[0].locn.value;
	var action = document.forms[0].action.value;
	if(blng_grp_code != "" && payer_group_code != "" && payer_code != "" && policy_type_code != "" && policy_no != "" && priority != "" && policy_eff_frm_date.value != "")
	{
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		
		var param="called_from=pol_eff_dates_check&blng_grp_code="+blng_grp_code+"&payer_group_code="+payer_group_code+"&payer_code="+payer_code+"&policy_type_code="+policy_type_code+"&policy_no="+policy_no+"&priority="+priority+"&policy_start_date="+policy_start_date.value+"&policy_exp_date="+policy_exp_date.value+"&policy_eff_frm_date="+policy_eff_frm_date.value+"&policy_eff_to_date="+policy_eff_to_date.value+"&checked_row="+checked_row+"&action="+action+"&locn="+locn;
		var temp_jsp="../../eBL/jsp/BLInsuranceValidations.jsp?"+param;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=trimString(xmlHttp.responseText);
		
		if(responseText == "Y")
		{
//			alert("Policy Eff. date Cannot Overlap for the same Payer Group,Payer,Policy Type,Policy No Combination");
			alert(getMessage("BL7425","BL"));
			return false;
		}
		else
		{
			return true;
		}
	}
	else
	{
		return true;
	}
}

function check_for_related_policies(clng_evnt)
{
	<!-- 12/07/2013	Karthikeyan K	MMS-QH-CRF-0010	36789 starts -->
	validAcrossEncounters();
	<!-- 12/07/2013	Karthikeyan K	MMS-QH-CRF-0010	36789 ends-->	
	var action = document.forms[0].action.value;
	var locn = document.forms[0].locn.value;
	var blng_grp_code = document.forms[0].blng_grp_code.value;
	var ins_cust_group_code = document.forms[0].ins_cust_group_code.value;
	var cust_code = document.forms[0].cust_3.value;
	var policy_type_code = document.forms[0].policy_type_code.value;
	var priority = document.forms[0].priority.value;
	var policy_no = document.forms[0].policy_no.value;
	var policy_eff_frm_date = document.forms[0].policy_eff_frm_date.value;//added for package billing
	var policy_start_date = document.forms[0].policy_start_date.value;
	var policy_exp_date = document.forms[0].policy_exp_date.value;
	var rec_edited_YN = document.forms[0].rec_edited_YN.value;
	var total_records = document.forms[0].totalRecords.value;
	var checked_row = document.forms[0].checked_row.value;
	var locale = document.forms[0].locale.value;
	var cur_pol_least_prio_YN;
	
	var  cust_id =  document.forms[0].cust_id.value;
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	var  site3TierAlmoFeatureYN =  document.forms[0].site3TierAlmoFeatureYN.value;	
	if(cust_id == "ALMO" || site3TierAlmoFeatureYN == "Y")  
		return;
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1

	if(locale!="en")
	{
		if(!(policy_eff_frm_date=="" || policy_eff_frm_date==" "))
			policy_eff_frm_date=convertDate(policy_eff_frm_date,"DMY",locale,"en");

		if(!(policy_start_date=="" || policy_start_date==" "))
			policy_start_date=convertDate(policy_start_date,"DMY",locale,"en");

		if(!(policy_exp_date=="" || policy_exp_date==" "))
			policy_exp_date=convertDate(policy_exp_date,"DMY",locale,"en");
	}
	if((total_records == 1 && ((action != "modify" && locn == "outside") || ((action == "add" || action == "modify") && locn == "inside"))) || total_records != 1)
	{
		if(blng_grp_code != "" && ins_cust_group_code != "" && cust_code != "" && policy_type_code != "" && priority != "" && policy_no != "")
		{
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			
			var param="called_from=chk_for_rltd_policies&action="+action+"&locn="+locn+"&blng_grp_code="+blng_grp_code+"&payer_group_code="+ins_cust_group_code+"&payer_code="+cust_code+"&policy_type_code="+policy_type_code+"&policy_no="+policy_no+"&priority="+priority+"&policy_start_date="+policy_start_date+"&policy_exp_date="+policy_exp_date+"&checked_row="+checked_row;

			var temp_jsp="../../eBL/jsp/BLInsuranceValidations.jsp?"+param;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=trimString(xmlHttp.responseText);
			
			var retArr = responseText.split("&^&");

			if(retArr[0] == "Y")
			{
				if(clng_evnt == "B")
				{
					
					document.forms[0].policy_start_date.value = retArr[1];
					document.forms[0].policy_exp_date.value = retArr[2];
					cur_pol_least_prio_YN = retArr[3];
					if(chkPolicyStartDateMain(document.forms[0].policy_start_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc))
					{
						if(chkPolicyExpiryDateMain(document.forms[0].policy_start_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc))
						{
							if(cur_pol_least_prio_YN == "N")
							{
								document.forms[0].policy_start_date.disabled = true;
								document.forms[0].policy_exp_date.disabled = true;	
							}
							else
							{
								document.forms[0].policy_start_date.disabled = false;
								document.forms[0].policy_exp_date.disabled = false;	
							}
						}
					}
				}
				else if(clng_evnt == "L")
				{
					cur_pol_least_prio_YN = retArr[3];
					if(cur_pol_least_prio_YN == "N")
					{
						document.forms[0].policy_start_date.disabled = true;
						document.forms[0].policy_exp_date.disabled = true;	
					}
					else
					{
						document.forms[0].policy_start_date.disabled = false;
						document.forms[0].policy_exp_date.disabled = false;	
					}
				}
			}
			else if(retArr[0] == "N")
			{
				if(clng_evnt == "B")
				{
					
					document.forms[0].policy_start_date.value = retArr[1];
					document.forms[0].policy_exp_date.value = retArr[2];
					if(chkPolicyStartDateMain(document.forms[0].policy_start_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc))
					{
						if(chkPolicyExpiryDateMain(document.forms[0].policy_start_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc))
						{
							document.forms[0].policy_start_date.disabled = false;
							document.forms[0].policy_exp_date.disabled = false;
						}
					}
				}
				else if(clng_evnt == "L")
				{
					document.forms[0].policy_start_date.disabled = false;
					document.forms[0].policy_exp_date.disabled = false;
				}
			}
		}
	}
}
</script>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="bring_focus();dflt_pol_eff_frm_date();srch_by_crit_for_cust();check_priority();curr_desc_1();check_for_related_policies('L');"><!-- Dont Change the order of call of the script functions -->

<form name='add_modify_pat_fin_det_ins_bodyedit' id='add_modify_pat_fin_det_ins_bodyedit' method='post' action="../../eBL/jsp/AddModifyPatFinDetailsInsBodyEdit.jsp">

<table cellpadding=3 cellspacing=0  width="100%" align='left'>

<td align='left' class='columnHeader' colspan='4'><fmt:message key="eBL.PAYER_POLICY_DTLS.label" bundle="${bl_labels}"/></td>
<tr>
<%
if(action.equals("add") && location.equals("outside"))
{
%>

<td width="25%" class="label"><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
<td width="25%" class='fields' ><select name="select_billing_group" id="select_billing_group" onChange="set_blng_values();check_priority();" onBlur='adjustment_rule();'><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%	
	String code = request.getParameter("ins_cust_group_code");
	StringTokenizer st=new StringTokenizer(blng_grp_code_tokens,"|");
	String temp_string="";
	while( st.hasMoreTokens() ) 
	{
		billing_grp_code = st.nextToken();

	if(!(temp_string.equals(billing_grp_code)))
	{
		billing_grp_qry="SELECT SHORT_DESC FROM BL_BLNG_GRP_LANG_VW WHERE BLNG_GRP_ID = '"+billing_grp_code+"' AND LANGUAGE_ID = '"+locale+"'";
		pstmt1 = con.prepareStatement(billing_grp_qry);
		rs3=pstmt1.executeQuery();
		if( rs3 != null ) 
		{
			while(rs3.next())
			{
				blng_grp_long_desc=rs3.getString(1);
			}
		}
		if(rs3 != null) rs3.close();
		pstmt1.close();
		if(blng_grp_long_desc == null) blng_grp_long_desc="";
		
		if(select_billing_group.equals(billing_grp_code))
		{
			out.println("<option value=\""+billing_grp_code+"\" SELECTED>"+blng_grp_long_desc+"</option>");
			temp_string=billing_grp_code;
		}
		else
		{
			out.println("<option value=\""+billing_grp_code+"\">"+blng_grp_long_desc+"</option>");
			temp_string=billing_grp_code;
		}
	}
	}
	
	pstmt.close() ;
%>
<input type='hidden' name="billing_group_desc" id="billing_group_desc" value=''>
<input type='hidden' name="blng_grp_code" id="blng_grp_code" value="<%=select_billing_group%>">
<input type=hidden name='curr_code_for_bg' id='curr_code_for_bg' value="<%=str_curr_code_for_bg%>">
</select></td>

</td>

<%
		/******Remove this payer from the PkgApprovalBean and then insert the modified one********start*******/
oldMapKey=select_billing_group.trim()+"~~"+cust_group_code.trim()+"~~"+cust_3.trim()+"~~"+priority.trim()+"~~"+policy_type_code.trim()+"~~"+policy_no.trim()+"~~"+policy_eff_frm_date.trim();
/******Remove this payer from the PkgApprovalBean and then insert the modified one********end*******/
	}
	else if(action.equals("add") && location.equals("inside"))
	{

		billing_grp_qry="SELECT SHORT_DESC,CURRENCY_CODE FROM BL_BLNG_GRP_LANG_VW WHERE BLNG_GRP_ID = '"+billing_group+"' AND LANGUAGE_ID = '"+locale+"'";
	
		pstmt = con.prepareStatement(billing_grp_qry);
		rs2=pstmt.executeQuery();
		if( rs2 != null ) 
		{
			while(rs2.next())
			{
				blng_grp_long_desc=rs2.getString(1);
				str_curr_code_for_bg=rs2.getString(2);
			}
		}
		if(str_curr_code_for_bg == null) str_curr_code_for_bg="";
		if(rs2 != null) rs2.close();
		pstmt.close();
%>

<td width="25%" class="label"><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
<td class='fields' width='25%'><B><%=blng_grp_long_desc%></B></td>
<input type=hidden name='billing_group_desc' id='billing_group_desc' value="<%=blng_grp_long_desc%>">
<input type=hidden name='blng_grp_code' id='blng_grp_code' value="<%=billing_group%>">
<input type=hidden name='curr_code_for_bg' id='curr_code_for_bg' value="<%=str_curr_code_for_bg%>">
</td>

<%
		/******Remove this payer from the PkgApprovalBean and then insert the modified one*******start********/
oldMapKey=billing_group.trim()+"~~"+cust_group_code.trim()+"~~"+cust_3.trim()+"~~"+priority.trim()+"~~"+policy_type_code.trim()+"~~"+policy_no.trim()+"~~"+policy_eff_frm_date.trim();
		/******Remove this payer from the PkgApprovalBean and then insert the modified one*******end********/
	}
	else if(action.equals("modify") || action.equals("remove"))
	{
		billing_grp_qry="SELECT SHORT_DESC,CURRENCY_CODE FROM BL_BLNG_GRP_LANG_VW WHERE BLNG_GRP_ID = '"+billing_group+"' AND LANGUAGE_ID = '"+locale+"'";
	
		pstmt = con.prepareStatement(billing_grp_qry);
		rs2=pstmt.executeQuery();
		if( rs2 != null ) 
		{
			while(rs2.next())
			{
				blng_grp_long_desc=rs2.getString(1);
				str_curr_code_for_bg=rs2.getString(2);
			}
		}
		if(str_curr_code_for_bg == null) str_curr_code_for_bg="";
		if(rs2 != null) rs2.close();
		pstmt.close();
%>

<td width="25%" class="label"><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
<td class='fields' width='25%'><B><%=blng_grp_long_desc%></B></td>
	<input type=hidden name='billing_group_desc' id='billing_group_desc' value="<%=blng_grp_long_desc%>">
	<input type=hidden name='blng_grp_code' id='blng_grp_code' value="<%=billing_group%>">
	<input type=hidden name='curr_code_for_bg' id='curr_code_for_bg' value="<%=str_curr_code_for_bg%>">
</td>

<%
		/******Remove this payer from the PkgApprovalBean and then insert the modified one********start*******/
oldMapKey=billing_group.trim()+"~~"+cust_group_code.trim()+"~~"+cust_3.trim()+"~~"+priority.trim()+"~~"+policy_type_code.trim()+"~~"+policy_no.trim()+"~~"+policy_eff_frm_date.trim();
	/******Remove this payer from the PkgApprovalBean and then insert the modified one********end*******/
	}
	if(!encounter_date_time.equals(""))
	{
%>
<td width="25%" class='label'><fmt:message key="Common.encounterdatetime.label" bundle="${common_labels}"/></td>
<td width="25%" class='label'><B><%=com.ehis.util.DateUtils.convertDate(encounter_date_time,"DMYHM","en",locale)%><B></td>
<%
	}
	else
	{
%>
<td width="25%" colspan='2'>&nbsp;</td>
<%
	}
%>
</tr>

<tr>	
		<td width="25%" class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></div></td>
		<td width="25%" class="fields">
				<select name='search_by_items' id='search_by_items' onChange='srch_by_crit_for_cust();' >
<!--
					<option value='CG' SELECTED><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/></option>
-->
					<option value='CY' <%=cnty_sel%>><fmt:message key="Common.country.label" bundle="${common_labels}"/></option>
					<option value='RN' <%=regn_sel%>><fmt:message key="eMP.region.label" bundle="${mp_labels}"/></option>
				</select>
		</td>

		<td width="25%" class="label"><b id='srch_by_leg'><fmt:message key="eMP.region.label" bundle="${mp_labels}"/></td>
		<td width="25%" class='fields' ><input type='text' name="srch_by_desc" id="srch_by_desc" maxlength='30' size='20'  tabindex='0' value="<%=srch_by_desc%>" onBlur="return srchbylkup('B')"><input type='button' class='button' name="srchbybut" id="srchbybut" value='?' onClick="return srchbylkup('C')" tabindex='0'><input type= 'hidden' name="search_code" id="search_code"  value=""><input type= 'hidden' name="search_by_items_rfsh" id="search_by_items_rfsh"  value="<%=srch_by_desc%>"></td>			
</tr>

<tr>
<td class='label' width='25%'><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
<td class='fields' width='25%' ><input maxlength='15' size='30' type=text name='ins_cust_group_name' id='ins_cust_group_name' value="<%=cust_group_name%>" onBlur="return cust_grp_lkup('B');"><input type='button' class='button' name="custgrpbut" id="custgrpbut" value='?'  tabindex='0' onClick="return cust_grp_lkup('C')"><input type='hidden' name='ins_cust_group_code' id='ins_cust_group_code' value="<%=cust_group_code%>"><img src='../../eCommon/images/mandatory.gif'></td>
<td width="25%">&nbsp;</td>
<td width="25%">&nbsp;</td>
</tr>

<tr>
	<td class='label' width='25%'><a href="javascript:getCustDet();"><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;<div id="ins_cust_curr_desc_disp" style="display:none"><Font color='red'><b id="ins_cust_curr_desc_val"></b></font></div></td>
	<td class='fields' width='25%' ><input maxlength='40' size='30' type=text name='payer_desc' id='payer_desc'  value="<%=payer_desc%>"   onBlur="return payerlkup('B');" onChange='' onBlur=""><input type='button' class='button' name="payerbut" id="payerbut" value='?'  tabindex='0' onClick="return payerlkup('C')" onBlur=''><img src='../../eCommon/images/mandatory.gif'>

		<input type='hidden' name='cust_3' id='cust_3' value="<%=cust_3%>">
		<input type='hidden' name='ins_cust_curr_code' id='ins_cust_curr_code' value="<%=str_ins_cust_curr_code%>">
		<input type='hidden' name='ins_cust_curr_desc' id='ins_cust_curr_desc' value="<%=str_ins_cust_curr_desc%>">
		<input type='hidden' name='valid_payer_YN' id='valid_payer_YN' value='<%=valid_payer_YN%>'>
		<input type='hidden' name='cust_valid_from_date' id='cust_valid_from_date' value='<%=cust_valid_from_date%>'>
		<input type='hidden' name='cust_valid_to_date' id='cust_valid_to_date' value='<%=cust_valid_to_date%>'>
	</td>
	<td class='label' width='25%'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'><input type="text" maxlength='2' size="3" name='priority' id='priority' style='text-align:right'  value='<%=priority%>' onBlur='priority_checks(this);' onKeyPress='return(ChkNumberInput(this,event,0))'><img src='../../eCommon/images/mandatory.gif'></td>
</tr>

<!-- Change for Incident 41309 Starts

<%
String sql1="Select DISTINCT a.policy_type_code POLICY_TYPE_CODE,a.short_desc SHORT_DESC,POLICY_COVERAGE_BASIS POLICY_COVERAGE_BASIS"
			 +" from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b, bl_cust_by_cust_group c" 
			 +" where a.language_id='"+locale+"'" 
			 +" and  a.operating_facility_id='"+facility_id+"'" 
		   	 +" and nvl(a.status,'N') <> 'S'"
			 +" and a.operating_facility_id = b.operating_facility_id"  
			 +" and a.policy_type_code = b.policy_type_code"
			 +" and c.cust_group_code = b.cust_group_code"
			 +" and (b.cust_code=c.cust_code or b.cust_code = '**')"
			 +" and (('"+strModuleId+"' in ('OP','AE') and nvl(b.outpatient_cover,'N') = 'Y')" 
			 +" or ('"+strModuleId+"' in ('IP','DC') and nvl(b.inpatient_covered,'N') = 'Y')"
			 +" or ('"+strModuleId+"' = 'MP' and nvl(b.external_covered,'N') = 'Y'))";
%>
<input type='hidden' name='sql1' id='sql1' value="<%=sql1%>">
Change for Incident 41309 ends-->

<tr>
	<td class='label' width='25%'><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
	<% if( "Y".equals(chargeLogicYn)) { %>
		<td class='fields' width='25%' ><input maxlength='40' size='10' type=text name='policy_type_desc' id='policy_type_desc'  value="<%=policy_type_desc%>"  onBlur= "return policylkup('B');" ><input type='button' class='button' name="policybut" id="policybut" value='?'  tabindex='0' onClick= "return policylkup('C'); " onBlur=''><img src='../../eCommon/images/mandatory.gif'>
		<a name='' href="#" onClick="callPolicyDetails(<%=totalRecords%>)" >(dtls)</a>
	</td>
	<%}else{%>
		<td class='fields' width='25%' ><input maxlength='40' size='30' type=text name='policy_type_desc' id='policy_type_desc'  value="<%=policy_type_desc%>"  onBlur= "return policylkup('B');" ><input type='button' class='button' name="policybut" id="policybut" value='?'  tabindex='0' onClick= "return policylkup('C'); " onBlur=''><img src='../../eCommon/images/mandatory.gif'>
	</td>
	
	<%}%>	
	<input type=hidden name='policy_type_code' id='policy_type_code' value="<%=policy_type_code%>"><input type='hidden' name='valid_policy_type_code_YN' id='valid_policy_type_code_YN' value='<%=valid_policy_type_code_YN%>'>
	
	
<!--
	<td class='label' width='25%'><fmt:message key="eBL.POLICY_NO.label" bundle="${bl_labels}"/></td>
	<td class='fields' width='25%'><input type="text" maxlength='30' size="23" name='policy_no' id='policy_no'   value="<%=policy_no%>" onKeyPress='return CheckForSpecChars_local(event)' onBlur='dflt_pol_no_2_credit_auth(document.forms[0].policy_no);'><img src='../../eCommon/images/mandatory.gif'></td>
-->
	<%
	//Added against NMC-JD-CRF-0054 starts
	HashMap<String,String> claimCreditMap=(HashMap)session.getAttribute("CLAIM_CREDIT_MAP_SESSION");
	String claim_code="";
	String credit_authorisation_by="";
	String membershipId="";
	if(claimCreditMap!=null)
	{
		String claimCredit=claimCreditMap.get(priority);
		String PolicyNumber=request.getParameter("policy_no");//Added against MMS-DM-CRF-0164.1_73081
		
		if(claimCredit!=null)
		{		
			String[] arrClaimCredit= StringUtils.splitPreserveAllTokens(claimCredit,"~");
			if(arrClaimCredit.length >0)
			{
				claim_code=arrClaimCredit[0];
				credit_authorisation_by=arrClaimCredit[1];
				membershipId=arrClaimCredit[2];
				//added against NMC-JD-CRF-0054
				if(policy_eff_frm_date.equals(""))
				{
					membershipId="";
				}
				if(membershipId == null) membershipId=""; //31-08-2020
			}
		}
		else
		{
			String memSql="SELECT membership_no,POLICY_NUMBER from bl_encounter_payer_priority  WHERE patient_id ='"+patient_id+"' and settlement_Ind='X' and priority='"+priority+"'";
			pstmt7 = con.prepareStatement(memSql);
			rs7=pstmt7.executeQuery();
			while(rs7.next())
			{
				membershipId = rs7.getString(1);
				policy_no = rs7.getString(2);
			}
			if(policy_no == null) policy_no ="";
			if(membershipId == null) membershipId ="";	//31-08-2020		
			
			if (rs7 != null)  rs7.close();
			if (pstmt7 != null)  pstmt7.close();
		}			
	}
	//Added against NMC-JD-CRF-0054 ends
	%>


	<td class='label' width='25%'><fmt:message key="eBL.POLICY_NO.label" bundle="${bl_labels}"/></td>
	<td class='fields' width='25%'>
	<%
		if(siteSpecPolicyNo.equals("Y"))
		{
	%>
			<input type="text" maxlength='30' size="23" name='policy_no' id='policy_no'   value="<%=policy_no%>" onKeyPress='return CheckForSpecCharsAllNotAlwSpc_local(event)' onBlur='dflt_pol_no_2_credit_auth(document.forms[0].policy_no);'>
			<%
				if(cg_det_policyno_flag.equals("Y")){
			%>
					<img id="policyMandImg" src='../../eCommon/images/mandatory.gif' >
			<%
				}
				else
				{
			%>
					<img id="policyMandImg" src='../../eCommon/images/mandatory.gif' style='visibility:hidden'>
			<%
				}
		}
		else
		{
			%>
				<input type="text" maxlength='30' size="23" name='policy_no' id='policy_no'   value="<%=policy_no%>" onKeyPress='return CheckForSpecCharsAllNotAlwSpc_local(event)' onBlur='dflt_pol_no_2_credit_auth(document.forms[0].policy_no);'><img id="policyMandImg" src='../../eCommon/images/mandatory.gif'>
	<%
		}
	%>
	</td>
	<!--Added against NMC-JD-CRF-0054 ends-->
</tr>
<%
	/* ***************GHL-0020 SCRUM CRF related changes begins ***************** */

//	String encounter_date="";
	try
	{
/*		String enc_Date="select to_char((to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') sys from dual";
		pstmt = con.prepareStatement(enc_Date);
		rs2=pstmt.executeQuery();
		if( rs2 != null ) 
		{
			while(rs2.next())
			{
				encounter_date=rs2.getString("sys");
			}
		}
		
		if(rs2 != null) rs2.close();
		pstmt.close();

//		if(policy_start_date.equals("") || !policy_start_date.equals(encounter_date))
*/ //Commented the Query as its already available above with variable encounter_date_aft_trunc

	//Commented by Karthik against incident  IN035788 on date 25/3/2013

	//	if(policy_start_date.equals("") || !policy_start_date.equals(encounter_date_aft_trunc))

	//end  IN035788
	
	

	if(policy_start_date.equals("") && ((!strCustomerId.equals("ALMO")) && !site3TierAlmoFeatureYN.equals("Y")))
		{ //AAKH-SCF-0404.1
			//String pocy_date_valid="select  ADDL_DAYS_POLICY_EXPDT,To_Char (to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI')+ADDL_DAYS_POLICY_EXPDT,'DD/MM/YYYY') SYS1, to_char((to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') sys from BL_INS_POLICY_TYPE_HDR 	where CUST_GROUP_CODE   = '"+cust_group_code+"' and POLICY_TYPE_CODE  ='"+policy_type_code +"' and CUST_CODE = '"+cust_3+"'  AND   DEF_REQ_POLICY_DATES='Y'";
			
			String pocy_date_valid="SELECT addl_days_policy_expdt, to_char(to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI') + nvl(addl_days_policy_expdt,0),'DD/MM/YYYY') sys1, to_char((to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') sys FROM bl_ins_policy_type_hdr WHERE OPERATING_FACILITY_ID='"+facility_id+"'AND cust_group_code = '"+cust_group_code+"' AND policy_type_code = '"+policy_type_code +"' AND (cust_code = '"+cust_3+"' OR (cust_code <> '"+cust_3+"' AND cust_code = '**')) AND def_req_policy_dates = 'Y'";

			pstmt = con.prepareStatement(pocy_date_valid);
			rs2=pstmt.executeQuery();
				
			if( rs2 != null ) 
			{
				while(rs2.next())
				{
					addl_days_policy_expdt=rs2.getString("addl_days_policy_expdt");
					policy_start_date=days_policy_strtdt=rs2.getString("sys");
					policy_exp_date=days_policy_expdt=rs2.getString("sys1");
				}
			}
		
			if(rs2 != null) rs2.close();
			pstmt.close();	
		}	
	}
	catch(Exception ex)
	{
		System.err.println("Exception occred in default policy validation"+ex);
		ex.printStackTrace();
	}	
/* ***************GHL-0020 SCRUM CRF related changes end ***************** */
%>
<tr>
	<td class='label' width='25%'><fmt:message key="eBL.POLICY_START_DATE.label" bundle="${bl_labels}"/></td>
	
	 <% 
		 //if((strCustomerId.equals("ALMO") || site3TierAlmoFeature == true)&&  policy_start_date.length() > 0) 
		if((strCustomerId.equals("ALMO") || site3TierAlmoFeatureYN.equals("Y")) &&  policy_start_date.length() > 0) 
		 {
	%>	 
	
	<td class='fields' width='25%' ><input type='text'  name='policy_start_date' id='policy_start_date' size='10' maxlength='10' value='<%=policy_start_date%>'  readonly ><img name='plcyStrtCalen' src="../../eCommon/images/CommonCalendar.gif"  readonly ><img  src='../../eCommon/images/mandatory.gif'></td>
	
	<%} else { %>
	<td class='fields' width='25%' ><input type='text'  name='policy_start_date' id='policy_start_date' size='10' maxlength='10' value='<%=policy_start_date%>'  onBlur='return chkPolicyStartDateMain(document.forms[0].policy_start_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc)' ><img name='plcyStrtCalen' src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar_loc('policy_start_date',document.forms[0].policy_start_date);" ><img  src='../../eCommon/images/mandatory.gif'></td>
	<%} %>

	<td class='label' width='25%'><fmt:message key="eBL.POLICY_EXPIRY_DATE.label" bundle="${bl_labels}"/></td>
	
	 <%	 
	//if((strCustomerId.equals("ALMO") || site3TierAlmoFeature == true)  &&  policy_exp_date.length() > 0)
	 if((strCustomerId.equals("ALMO") || site3TierAlmoFeatureYN.equals("Y"))  &&  policy_exp_date.length() > 0) 
	 {
	%>
	
	<td class='fields' width='25%'><input type='text'  name='policy_exp_date' id='policy_exp_date' size='10' maxlength='10'  value='<%=policy_exp_date%>' readonly ><img name='plcyExpCalen' src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar_loc('policy_exp_date',document.forms[0].policy_exp_date);"  disabled ><img src='../../eCommon/images/mandatory.gif'></td>
<%} else { %>
		<td class='fields' width='25%'><input type='text'  name='policy_exp_date' id='policy_exp_date' size='10' maxlength='10'  value='<%=policy_exp_date%>' onBlur='dflt_policy_eff_to_date();return chkPolicyExpiryDateMain(document.forms[0].policy_start_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc);' ><img name='plcyExpCalen' src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar_loc('policy_exp_date',document.forms[0].policy_exp_date);" ><img src='../../eCommon/images/mandatory.gif'></td>
		
		<%}  %>
</tr>
<!-- ***************GHL-0020 SCRUM CRF related changes end ***************** -->
<%
	//if(rec_edited_YN.equals("N") && (strCustomerId.equals("ALMO")==false && site3TierAlmoFeature == false))
	if(rec_edited_YN.equals("N") && ((!strCustomerId.equals("ALMO")) && !site3TierAlmoFeatureYN.equals("Y")))
	{
%>
	<script>
		// Based on policy start and end date defaulting the  Policy effective from and to date
		setTimeout('chkPolicyStartDateMain(document.forms[0].policy_start_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc)',5)	;
		setTimeout('chkPolicyExpiryDateMain(document.forms[0].policy_start_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc)',5)	;
	</script>
<%
	}
%>
<!-- ***************GHL-0020 SCRUM CRF related changes end ***************** -->
<tr>
<!-- ***************Package billing changes - changed label from Crdit Auth to Initia Credit Auth, added onBlur method for credit_auth_ref ie changePayerDtls(this), changed eBL.CREDIT_AUTH_DATE.label to eBL.InitialCreditAuthorizationDate.label,***************** -->
<%if(package_enabled_yn.equals("Y")){%>
<td class='label' width='25%'><div id="credit_auth_leg_disp" style=<%=v_display_hide_cred_auth%> ><fmt:message key="eBL.InitialCreditAuthorization.label" bundle="${bl_labels}"/></div></td>
	<td class='fields' width='25%'><div id="credit_auth_val_disp" style=<%=v_display_hide_cred_auth%> ><input type="text" maxlength='20' size="17" name='credit_auth_ref' id='credit_auth_ref' value="<%=credit_auth_ref%>" onBlur="changePayerDtls(this)" onKeyPress='return CheckForSpecCharsAllNotAlwSpc_local(event)'></div><div id="credit_auth_ref_mand" style=<%=v_credit_auth_val_mand%> ><img src='../../eCommon/images/mandatory.gif'></div></td>

	<td class='label' width='25%'><div id="credit_auth_date_leg_disp" style=<%=v_display_hide_cred_auth%> ><fmt:message key="eBL.InitialCreditAuthorizationDate.label" bundle="${bl_labels}"/></div></td>
	<td class='fields' width='25%'><div id="credit_auth_date_val_disp" style=<%=v_display_hide_cred_auth%> ><input type='text'  name='credit_auth_date' id='credit_auth_date' size='10' maxlength='10' value='<%=credit_auth_date%>' onBlur="return chkCreditAuthDate(document.forms[0].credit_auth_date);changePayerDtls(this);" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar_loc('credit_auth_date',document.forms[0].credit_auth_date);"><div id="credit_auth_date_mand" style=<%=v_credit_auth_val_mand%> ></div><div id="credit_auth_ref_date_mand" style=<%=v_credit_auth_val_mand%> ><img src='../../eCommon/images/mandatory.gif'></div></td>	
</tr>

<tr>
	<td class='label' width='25%' ><div id="apprd_amt_leg_disp" style=<%=v_display_hide_apprvd_amt%> ><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/></div></td>
	
	 <% 
	//if((strCustomerId.equals("ALMO") ||site3TierAlmoFeature == true )&&  credit_apprd_amt.length() > 0)
	if((strCustomerId.equals("ALMO") || site3TierAlmoFeatureYN.equals("Y")) &&  credit_apprd_amt.length() > 0) 
	{	%>
		<td class='fields' width='25%'><div id="apprd_amt_val_disp" style=<%=v_display_hide_apprvd_amt%> ><input type="text" maxlength='10' size="15" name='credit_apprd_amt' id='credit_apprd_amt' style='text-align:right'  value='<%=credit_apprd_amt%>'  readonly ><img src='../../eCommon/images/mandatory.gif'></div></td>
	<% }else{ %>
	<td class='fields' width='25%'><div id="apprd_amt_val_disp" style=<%=v_display_hide_apprvd_amt%> ><input type="text" maxlength='10' size="15" name='credit_apprd_amt' id='credit_apprd_amt' style='text-align:right'  value='<%=credit_apprd_amt%>' onKeyPress='return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value));' onBlur='changePayerDtls(this);return CheckSplApprAmt(this);' <%=restricted_YN%>><img src='../../eCommon/images/mandatory.gif'></div></td>
    <%} %> 
    
	<td  class='label' width='25%'  ><div id="apprd_days_leg_disp" style=<%=v_display_hide_apprvd_days%> ><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}"/></div></td>
	
	 <% 
		//if((strCustomerId.equals("ALMO") || site3TierAlmoFeature == true ) &&  credit_apprd_days.length() > 0)	
		if((strCustomerId.equals("ALMO") || site3TierAlmoFeatureYN.equals("Y")) &&  credit_apprd_days.length() > 0)	 
		{
	%>
	<td class='fields' width='25%'><div id="apprd_days_val_disp" style=<%=v_display_hide_apprvd_days%> ><input type="text" maxlength='4' size="4" name='credit_apprd_days' id='credit_apprd_days' style='text-align:right'  value='<%=credit_apprd_days%>' onBlur='CheckSplApprDays(this);changePayerDtls(this)' onKeyPress='return(ChkNumberInput(this,event,0))' readonly><img src='../../eCommon/images/mandatory.gif' ></div></td>
	<% }else{ %>
	<td class='fields' width='25%'><div id="apprd_days_val_disp" style=<%=v_display_hide_apprvd_days%> ><input type="text" maxlength='4' size="4" name='credit_apprd_days' id='credit_apprd_days' style='text-align:right'  value='<%=credit_apprd_days%>' onBlur='CheckSplApprDays(this);changePayerDtls(this);dflt_policy_eff_to_date();' onKeyPress='return(ChkNumberInput(this,event,0))' <%=restricted_YN%>><img src='../../eCommon/images/mandatory.gif' ></div></td>
	  <%} %>
</tr>

<%}else{%>
	<td class='label' width='25%'><div id="credit_auth_leg_disp" style=<%=v_display_hide_cred_auth%> ><fmt:message key="eBL.CREDIT_AUTH.label" bundle="${bl_labels}"/></div></td>
	<!--	
		<td class='fields' width='25%'><div id="credit_auth_val_disp" style=<%=v_display_hide_cred_auth%> ><input type="text" maxlength='20' size="17" name='credit_auth_ref' id='credit_auth_ref' value="<%=credit_auth_ref%>" onKeyPress='return CheckForSpecChars_local(event)'><img src='../../eCommon/images/mandatory.gif'></div></td>
	-->
	<td class='fields' width='25%'><div id="credit_auth_val_disp" style=<%=v_display_hide_cred_auth%> ><input type="text" maxlength='20' size="17" name='credit_auth_ref' id='credit_auth_ref' value="<%=credit_auth_ref%>" onKeyPress='return CheckForSpecCharsAllNotAlwSpc_local(event)'></div><div id="credit_auth_ref_mand" style=<%=v_credit_auth_val_mand%> ><img src='../../eCommon/images/mandatory.gif'></div></td>

	<td class='label' width='25%'><div id="credit_auth_date_leg_disp" style=<%=v_display_hide_cred_auth%> ><fmt:message key="eBL.CREDIT_AUTH_DATE.label" bundle="${bl_labels}"/></div></td>
	
	<td class='fields' width='25%'><div id="credit_auth_date_val_disp" style=<%=v_display_hide_cred_auth%> ><input type='text'  name='credit_auth_date' id='credit_auth_date' size='10' maxlength='10' value='<%=credit_auth_date%>' onBlur="return chkCreditAuthDate(document.forms[0].credit_auth_date);" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar_loc('credit_auth_date',document.forms[0].credit_auth_date);"><div id="credit_auth_date_mand" style=<%=v_credit_auth_val_mand%> ></div><div id="credit_auth_ref_date_mand" style=<%=v_credit_auth_val_mand%> ><img src='../../eCommon/images/mandatory.gif'></div></td>	
</tr>

<tr>
	<td class='label' width='25%' ><div id="apprd_amt_leg_disp" style=<%=v_display_hide_apprvd_amt%> ><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/></div></td>
	<td class='fields' width='25%'><div id="apprd_amt_val_disp" style=<%=v_display_hide_apprvd_amt%> ><input type="text" maxlength='10' size="15" name='credit_apprd_amt' id='credit_apprd_amt' style='text-align:right'  value='<%=credit_apprd_amt%>' onKeyPress='return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value));' onblur='return CheckSplApprAmt(this)' <%=restricted_YN%>><img src='../../eCommon/images/mandatory.gif'></div></td>

	<td  class='label' width='25%'  ><div id="apprd_days_leg_disp" style=<%=v_display_hide_apprvd_days%> ><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}"/></div></td>
	<td class='fields' width='25%'><div id="apprd_days_val_disp" style=<%=v_display_hide_apprvd_days%> ><input type="text" maxlength='4' size="4" name='credit_apprd_days' id='credit_apprd_days' style='text-align:right'  value='<%=credit_apprd_days%>' onBlur='CheckSplApprDays(this);' onKeyPress='return(ChkNumberInput(this,event,0))' <%=restricted_YN%>><img src='../../eCommon/images/mandatory.gif' ></div></td>
</tr>
		<%}%>
<tr>
	<td class='label' width='25%' ><fmt:message key="eBL.POLICY_EFFECTIVE_FROM.label" bundle="${bl_labels}"/></td>
	<td class='fields' width='25%'><input type='text'  name='policy_eff_frm_date' id='policy_eff_frm_date' size='10' maxlength='10' value='<%=policy_eff_frm_date%>' onBlur='dflt_policy_eff_to_date();return chkPolicyEffFromDateMain(document.forms[0].policy_eff_frm_date,document.forms[0].policy_eff_to_date,document.forms[0].policy_start_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc);' ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar_loc('policy_eff_frm_date',document.forms[0].policy_eff_frm_date);" ><img src='../../eCommon/images/mandatory.gif'></td>

	<td class='label' width='25%' ><fmt:message key="eBL.POLICY_EFFECTIVE_TO.label" bundle="${bl_labels}"/></td>
	<%
		//if(("ALMO".equals(strCustomerId) ||site3TierAlmoFeature == true ) && "Y".equals(chargeLogicYn)){ 
		if((strCustomerId.equals("ALMO") || site3TierAlmoFeatureYN.equals("Y") ) && "Y".equals(chargeLogicYn)) { 
	%>
		<td class='fields' width='25%'><input type='text'  name='policy_eff_to_date' id='policy_eff_to_date' size='10' maxlength='10' value='<%=policy_eff_to_date%>' onBlur='return chkPolicyEffToDate(document.forms[0].policy_eff_to_date,document.forms[0].policy_eff_frm_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc);' ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar_loc('policy_eff_to_date',document.forms[0].policy_eff_to_date);" ></td>
	<%} else{ %>
		<td class='fields' width='25%'><input type='text'  name='policy_eff_to_date' id='policy_eff_to_date' size='10' maxlength='10' value='<%=policy_eff_to_date%>' onBlur=' validate_eff_to_apprday();dflt_policy_eff_to_date();return chkPolicyEffToDate(document.forms[0].policy_eff_to_date,document.forms[0].policy_eff_frm_date,document.forms[0].policy_exp_date,document.forms[0].encounter_date_aft_trunc);' ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar_loc('policy_eff_to_date',document.forms[0].policy_eff_to_date);" ></td>		
	<%} %> 

</tr>
<%
	String adj_rule_select_A="",adj_rule_select_NA="";
	if(adj_rule_ind.equals("A"))
	{
		adj_rule_select_A = "SELECTED";
		adj_rule_select_NA = "";
	}
	else
	{
		adj_rule_select_NA= "SELECTED";
		adj_rule_select_A = "";
	}

	String adj_ind_select_P="",adj_ind_select_A="";
	if(adj_perc_amt_ind.equals("P"))
	{
		adj_ind_select_P = "SELECTED";
		adj_ind_select_A = "";
	}
	else if(adj_perc_amt_ind.equals("A"))
	{
		adj_ind_select_A= "SELECTED";
		adj_ind_select_P = "";
	}
	else
	{
		adj_ind_select_A= "";
		adj_ind_select_P = "";
	}
%>
<tr>
	<td class='label' width='25%' ><fmt:message key="eBL.ADJUSTMENT_RULE_INDICATOR.label" bundle="${bl_labels}"/></td>
	<td class='fields' width='25%'>
		<select name="adj_rule_ind_lis" id="adj_rule_ind_lis"	onChange="adj_rule_ind_set(this)" DISABLED>
			<option value='AUT' <%=adj_rule_select_A%>><fmt:message key="eBL.AUTOMATIC.label" bundle="${bl_labels}"/></option>
			<option value='NA' <%=adj_rule_select_NA%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
		</select>
		<input type='hidden' name='adj_rule_ind' id='adj_rule_ind' value="<%=adj_rule_ind%>" >
	</td>

	<td class='label' width='25%' ><fmt:message key="eBL.PERC_AMOUNT_INDICATOR.label" bundle="${bl_labels}"/></td>
	<td class='fields' width='25%'>
		<select name="adj_perc_amt_ind_lis" id="adj_perc_amt_ind_lis" onChange='adj_perc_amt_ind_set(this)' DISABLED>
			<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<option value='PER' <%=adj_ind_select_P%>><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
			<option value='AMT' <%=adj_ind_select_A%>><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
		</select>
		<input type='hidden' name='adj_perc_amt_ind' id='adj_perc_amt_ind' value="<%=adj_perc_amt_ind%>" >
	</td>
</tr>
<tr>
	<td class='label' width='25%' ><fmt:message key="eBL.ADJUSTMENT_VALUE.label" bundle="${bl_labels}"/></td>
	<td class='fields' width='25%'>
		<!--<input type='text'  name='adj_perc_amt_value' id='adj_perc_amt_value' size='10' maxlength='10' value='<%=adj_perc_amt_value%>' onBlur="adj_amt_chk(this)"  style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))' READONLY>-->
		<input type='text'  name='adj_perc_amt_value' id='adj_perc_amt_value' size='10' maxlength='10' value='<%=adj_perc_amt_value%>' style='text-align:right' READONLY>
	</td>
<%
	String acc_int_desc="";

	String adj_code_sql="SELECT acc_int_desc FROM bl_gl_account_lang_vw WHERE acc_entity_code = (select acc_entity_code from sy_acc_entity where acc_entity_id='"+facility_id+"') and acc_int_code='"+pmnt_diff_adj_int+"' and LANGUAGE_ID='"+locale+"'";

	pstmt = con.prepareStatement(adj_code_sql);
	rs=pstmt.executeQuery();
	while(rs.next())
	{
		acc_int_desc = rs.getString(1);
	}
	if (rs != null)   rs.close();
	pstmt.close();

%>
	<td class='label' width='25%' ><fmt:message key="eBL.ADJUSTMENT_INTERFACE_CODE.label" bundle="${bl_labels}"/></td>
	<td class='fields' width='25%'>
		<!--
		<input type='text'  name='pmnt_diff_adj_int_desc' id='pmnt_diff_adj_int_desc' size='30' maxlength='100' value='<%=acc_int_desc%>' onblur="return adjinterfacelkp('B')" READONLY>
		<input type='button' class='button' name="adj_diff_btn" id="adj_diff_btn" value='?' onClick="return adjinterfacelkp('C')">
		-->
		<input type='text'  name='pmnt_diff_adj_int_desc' id='pmnt_diff_adj_int_desc' size='30' maxlength='100' value='<%=acc_int_desc%>' READONLY>

	</td>
	<input type=hidden name='pmnt_diff_adj_int' id='pmnt_diff_adj_int' value="<%=pmnt_diff_adj_int%>" >
</tr>
<!-- Karthik added the code to add claim code starts  - IN50355-->

<tr>
	<td class='label' width='25%' ><fmt:message key="eBL.ClaimCode.label" bundle="${bl_labels}"/></td>
	<td class='fields' width='25%'><input name='claim_code' id='claim_code' type='text' value='<%=claim_code%>'></td>
	<td class='label' width='25%' ><fmt:message key="eBL.CreditAuthorisationBy.label" bundle="${bl_labels}"/></td>
	<td class='fields' width='25%'><input name='credit_authorisation_by' id='credit_authorisation_by' type='text' value='<%=credit_authorisation_by%>'></td>
</tr>
<!-- Karthik added the code to add claim code  ends  - IN50355-->

<%
		/**** added for package billing *********** start *************/		
if(package_enabled_yn.equals("Y") && !v_display_hide_apprvd_amt.equals("display:none") ){
v_display_hide_add_aprv="display:inline";
}else{
v_display_hide_add_aprv="display:none";
}


if((strModuleId.equals("OP") || strModuleId.equals("IP")) && package_enabled_yn.equals("Y")){%>
<tr>

<td class='label' width='25%'><div id="addl_apprv_leg_disp"  style='display:inline'><fmt:message key="eBL.additionalApprovals.label" bundle="${bl_labels}"/> / <fmt:message key="eBL.PackageDiscount.label" bundle="${bl_labels}"/></div></td>
<td class='label' width='25%' ><div id="addl_apprv_val_disp"  style='display:inline' ><a name='addlApprvDtls' href='#' onClick='showAddlApprv(calling_module_id);'><fmt:message key="eBL.Dtls.label" bundle="${bl_labels}"/></a></div>


</td>
<td class='label' width='25%'></td>
<td class='label' width='25%'>&nbsp;</td>
</tr>
<%}		/**** added for package billing *********** end *************/
%>
<!-- karthik added code INCLUDE_POLICY_DETAILS_CRF -->

<tr>
	<td class='label' width='25%' >Membership Id</td>
	<td class='fields' width='25%'>
	<input type='text'  name='membershipId' id='membershipId' id='membershipId'  size='30' maxlength='100' value='<%=membershipId%>'>
	<%
		if(!(cg_det_membshpid_flag.equals("null")) && cg_det_membshpid_flag.equals("Y"))
		{
	%>
			<img id="memberMandImg" src='../../eCommon/images/mandatory.gif'>
	<%
		}
		else
		{
	%>
			<img id="memberMandImg" src='../../eCommon/images/mandatory.gif' style='visibility:hidden'>
	<%
		}
	%>
	</td>
	<input type='hidden' id='siteSpecPolicyNo' name='siteSpecPolicyNo' id='siteSpecPolicyNo' value="<%=siteSpecPolicyNo%>">
	<!--Added Against NMC-JD-CRF-0054 -->
	<!-- 08/07/2013	Karthikeyan K	MMS-QH-CRF-0010	36789 starts-->
	<td class='fields' width='25%'>
	<a href='#' name="across_encounter_link"  disabled onClick="acrossEncountersLink()">Across Encounter</a>
	</td>
	<!-- 08/07/2013	Karthikeyan K	MMS-QH-CRF-0010	36789 ends-->
	<td class='label' width='25%'>
	<% 

			 strPlcyorEnctr ="policy";
			String enc_episode_id ="";
			String  enc_patient_id ="";
			String  enc_visit_id ="";
			String  enc_episode_type ="";
			String  enc_locale ="";
			String  strEncPatRegDate="";
			String enc_facility_id="";
			String enc_acc_seq ="";
			String enc_polcy_no="";
			String dflt_policy_vst_reg="";

		if(session.getAttribute("ENCOUNTER_POLICY_RECORD_ELEMENTS")!=null)
		{
			HashMap hashPlcyorEnctr=(HashMap)session.getAttribute("ENCOUNTER_POLICY_RECORD_ELEMENTS");

			enc_facility_id		=""+hashPlcyorEnctr.get("enc_facility_id");
			enc_patient_id		=""+hashPlcyorEnctr.get("enc_patient_id");
			enc_episode_type	=""+hashPlcyorEnctr.get("enc_episode_type");
			enc_episode_id		=""+hashPlcyorEnctr.get("enc_episode_id");
			enc_visit_id		=""+hashPlcyorEnctr.get("enc_visit_id");
			enc_acc_seq			=""+hashPlcyorEnctr.get("acct_seq");
			enc_polcy_no		=""+hashPlcyorEnctr.get("policy_num");
			dflt_policy_vst_reg =""+hashPlcyorEnctr.get("dflt_policy_vst_reg");

			enc_locale			=""+hashPlcyorEnctr.get("enc_locale");
			strEncPatRegDate =  ""+hashPlcyorEnctr.get("encounter_date");			
			
			//if((enc_episode_type.equals("R") || (enc_episode_id!=null && enc_episode_id.equals("null")==false && !"".equals(enc_episode_id)) ) && dflt_policy_vst_reg.equals("N"))
			//	strPlcyorEnctr ="encounter";		
		}
		try{
			String strPolicyorEncQry = " SELECT count(*) FROM bl_ins_policy_addl_hdr hdr "+
			" WHERE hdr.operating_facility_id = '"+facility_id+"'"+
			" AND hdr.cust_group_code  = '"+cust_group_code+"'"+
			" AND hdr.cust_code  = '"+cust_3+"'"+
			" AND hdr.policy_type_code = '"+policy_type_code+"'"+
			" AND hdr.patient_id  = '"+patient_id+"'"+
			" AND hdr.episode_type  = 'R'";

			PreparedStatement pstmtPolEnc = con.prepareStatement(strPolicyorEncQry);		
			ResultSet rsPolEnc = pstmtPolEnc.executeQuery();
			if(rsPolEnc != null){
				while(rsPolEnc.next()){
				String strPolicyorEnc = rsPolEnc.getString(1);
				if(strPolicyorEnc!=null){
					int polEncChk=Integer.parseInt(strPolicyorEnc);
					if(polEncChk==0){
						strPlcyorEnctr ="policy";
					}else{
						strPlcyorEnctr ="encounter";
					}
				}
				}
			}
			if(pstmtPolEnc!=null){
				pstmtPolEnc.close();
			}
			if(rsPolEnc!=null){
				rsPolEnc.close();
			}
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Exception in getting strPolicyorEncQry"+e);
	}	
			
	String policyBLInclusionFlag= (session.getAttribute("LINK_POLICY_IN_BILLING")==null) ? "N": (String)session.getAttribute("LINK_POLICY_IN_BILLING");
	if(policyBLInclusionFlag!=null && policyBLInclusionFlag.equals("Y") && strModifyPlcyYN.equals("Y")){ %>
	<a name="callPolicy" href=
		'#' onClick="callPolicy('<%=strPlcyorEnctr%>','<%=enc_episode_id%>','<%=enc_patient_id%>','<%=enc_episode_type%>','<%=enc_visit_id%>','<%=enc_acc_seq%>','<%=enc_polcy_no%>');">Modify Policy Details</a>
	<% }%>
	</td>
<!-- 	<td class='label' width='25%'>&nbsp;</td> -->

</tr>
<%
	String profile_id_exists="N";
	
	String check_trxn_status="";  //Added by Apoorva for MOHE-CRF-0020
    String disabledStr="disabled";
	String checkStatusdisabledStr="disabled"; //Added by Apoorva for MOHE-CRF-0020
	String hiddenStr="hidden"; //Added by Apoorva for MOHE-CRF-0020
	
	CallableStatement checkProfileIdStatement = null;
	CallableStatement checkStatusStatement = null; //Added by Apoorva for MOHE-CRF-0020

    try
	{		    
		String check_profileId="ELCPROF1"; //modified by Apoorva for MOHE-CRF-0020 from HSWITCH profile to eligibility check profile
		String checkProfileIdQuery = "{ ? = call xh_standard_profile_exists(?) }";

		checkProfileIdStatement = con.prepareCall(checkProfileIdQuery);
		checkProfileIdStatement.registerOutParameter(1,java.sql.Types.VARCHAR);
		checkProfileIdStatement.setString(2, check_profileId);
		checkProfileIdStatement.execute();		
		profile_id_exists = checkProfileIdStatement.getString(1);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Modify Financial Details ::::Exception in checkProfileIdStatement..."+e);
	}
	finally{
         checkProfileIdStatement.close();
	}

	//Added by Apoorva for MOHE-CRF-0020
	try
	{		    
		String check_cust_group_code = cust_group_code; //modified by Apoorva for MOHE-CRF-0020 from HSWITCH profile to eligibility check profile
		String check_seg_id= "RQA";
		String checkStatusQuery = "{ CALL XHBUPAINSURANCE.CHECK_ELIG_PROFILE_VALUES(?,?,?,?,?) }";

		checkStatusStatement = con.prepareCall(checkStatusQuery);
		checkStatusStatement.setString(1, check_cust_group_code);
		checkStatusStatement.setString(2, check_seg_id);
		checkStatusStatement.registerOutParameter(3,java.sql.Types.VARCHAR);
		checkStatusStatement.registerOutParameter(4,java.sql.Types.VARCHAR);
		checkStatusStatement.registerOutParameter(5,java.sql.Types.VARCHAR);
		checkStatusStatement.execute();		
		check_trxn_status = checkStatusStatement.getString(3);

	    System.out.println("Modify Financial Details ::::cust_group_code value..."+cust_group_code);
     
		System.out.println("Modify Financial Details ::::check_trxn_status value..."+check_trxn_status);

     	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Modify Financial Details ::::Exception in checkStatusStatement..."+e);
	}
	finally{
         checkStatusStatement.close();
	}
	//Added by Apoorva for MOHE-CRF-0020 ends here
	
	if("Y".equals(profile_id_exists))
	{  	   
		
		//System.out.println("AddModifyPatFinDetailsInsBodyEdit.jsp:::payerEligibilityCheck...cust_group_code...."+cust_group_code);
		
		if (cust_group_code.length()>0)
		{
			try
			{
	
			//Modified by Niveditha NMC-JD-CRF-0054.1

				if("Y".equals(DebugYNProtocolLinkId)){
					System.out.println("Modify Financial Details :::checkInterfaceEnabled...cg_det_op_interface..."+cg_det_op_interface);				
					System.out.println("Modify Financial Details :::checkInterfaceEnabled...cg_det_em_interface..."+cg_det_em_interface);				
					System.out.println("Modify Financial Details :::checkInterfaceEnabled...cg_det_ip_interface..."+cg_det_ip_interface);				
					System.out.println("Modify Financial Details :::checkInterfaceEnabled...cg_det_dc_interface..."+cg_det_dc_interface);
				}

				if(("Y".equals(cg_det_op_interface) && "OP".equals(p_patient_class)) || ("Y".equals(cg_det_em_interface) && "EM".equals(p_patient_class)) || ("Y".equals(cg_det_ip_interface) && "IP".equals(p_patient_class)) || ("Y".equals(cg_det_dc_interface) && "DC".equals(p_patient_class)))
				{
					disabledStr = "";
					if(payerEligibilityParamSession=="" || payerEligibilityParamSession==null)
					{
						payerEligibilityParam = "0";
					}
					else
					{
						payerEligibilityParam=payerEligibilityParamSession;
					}
					//Added by Apoorva for MOHE-CRF-0020
					if ("Y".equals(check_trxn_status)){

						hiddenStr="";
					}
					else{
						hiddenStr="style=display:none";
					}
					//Added by Apoorva for MOHE-CRF-0020 ends here
				}
				else
				{
				   disabledStr = "disabled";
				   payerEligibilityParam = "9";
				   //Added by Apoorva for MOHE-CRF-0020
					if ("Y".equals(check_trxn_status)){
						hiddenStr="";
					}
					else{
						hiddenStr="style=display:none";
					}
					//Added by Apoorva for MOHE-CRF-0020 ends here
				}
			}
			catch(Exception exp)
			{
				System.out.println("(Modify Financial Details :checkInterfaceEnabled) Exception at executing procedure");
				exp.printStackTrace(System.err);
			}	
		}
		else  //cust_group_code is empty
		{
           	disabledStr = "disabled";
		   	payerEligibilityParam = "9";
		}	   	   
	   %>

	<tr id="bupaEligibilityCheck1" >
		<td class='label' width='25%' valign="top"><fmt:message key="eBL.ResponseCode.label" bundle="${bl_labels}"/></td>
		<td class='fields' width='25%' valign="top"><input name='response_code_desc' id='response_code_desc' type='text' value='<%=responseCodeDescSes%>' readonly></td>
		<td class='label' width='25%' valign="top"><fmt:message key="eBL.ValidityPeriod.label" bundle="${bl_labels}"/></td>
		<td class='fields' width='25%' valign="top"><input name='validity_period_desc' id='validity_period_desc' type='text' value='<%=validityPeriodDescSes%>' readonly></td>	
    	</tr>
	<tr id="bupaEligibilityCheck2" >
		<td class='label' width='25%' valign="top"><fmt:message key="eBL.EligibilityCode.label" bundle="${bl_labels}"/></td>
		<td class='fields' width='25%' valign="top"><input name='eligibility_code_desc' id='eligibility_code_desc' type='text' value='<%=eligibilityCodeSes%>' readonly></td>
		<td class='label' width='25%' valign="top"><fmt:message key="eBL.StatusDescription.label" bundle="${bl_labels}"/></td>
		<td class='fields' width='25%' valign="top">
		<textarea rows="3" cols="40" id="status_desc_text" name="status_desc_text" readonly wrap="hard" style="text-align: left">
		<%=statuDescriptionSession%>
		</textarea>
		</td>
		
    </tr> 
   <%
		}
	%>
<br>
<tr>
<%
	if(action.equals("add"))
	{
%>
	<td class='label' width='25%'>&nbsp;</td>
	<td class='label' width='25%'>&nbsp;</td>
	
	<td class='label' width='25%' colspan="2">
	<!--if("Y".equals(profile_id_exists) && "Y".equals(moduleIdCheck))-->
	
	<% 
		if("Y".equals(profile_id_exists))
		{
			if(!strModuleId.equals("MP")) 
			{
	%>
	<!-- Added By Niveditha for NMC-JD-CRF-0054.1 -->
		<input type="button" name="update_eligibility_check" id="update_eligibility_check" id="update_eligibility_check"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Update.label","common_labels")%>" class="button" onClick='getChangePatientDetails(document.forms[0].patient_id.value)'>&nbsp;
	<%
			}
	%>
        <input type="button" name="eligibility_check" id="eligibility_check" id="eligibility_check"   value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EligibilityCheck.label","common_labels")%>" class="button" onClick='payerEligibilityCheck("EC")' <%=disabledStr%>>&nbsp;

		<!-- Added By Apoorva for MOHE-CRF-0020 -->
		<input type="button" name="check_status" id="check_status" id="check_status"   value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckStatus.label","common_labels")%>" class="button" onClick='payerEligibilityCheck("CS")' <%=checkStatusdisabledStr%> <%=hiddenStr%>>&nbsp;

		<!-- Added By Apoorva for MOHE-CRF-0020 ends here -->
		<% 
		} 
		%>
		<input type="button" name="accept_button" id="accept_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")%>" class="button" onClick='checkValues("CV")' >&nbsp;
		<input type="button" name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" class="button"  onClick='cancel()' >
	</td>
<%
	}
	else
	{
%>
	<td width='25%'>&nbsp;</td>
	<td width='25%'>&nbsp;</td>
	
	<td class='label' width='25%' colspan="2">

	<!--if("Y".equals(profile_id_exists) && "Y".equals(moduleIdCheck))-->
	
	
	<% 
		if("Y".equals(profile_id_exists))
		{
			if(!strModuleId.equals("MP")) 
			{
	%>
	<!-- Added By Niveditha for NMC-JD-CRF-0054.1 -->
		<input type="button" name="update_eligibility_check" id="update_eligibility_check" id="update_eligibility_check"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Update.label","common_labels")%>" class="button" onClick='getChangePatientDetails(document.forms[0].patient_id.value)'>&nbsp;
	<%
			}
	%>
        <input type="button" name="eligibility_check" id="eligibility_check" id="eligibility_check"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EligibilityCheck.label","common_labels")%>" class="button" onClick='payerEligibilityCheck("EC")' <%=disabledStr%>>&nbsp;

		<!-- Added By Apoorva for MOHE-CRF-0020 -->
		<input type="button" name="check_status" id="check_status" id="check_status"   value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckStatus.label","common_labels")%>" class="button" onClick='payerEligibilityCheck("CS")' <%=checkStatusdisabledStr%> <%=hiddenStr%>>&nbsp;

		<!-- Added By Apoorva for MOHE-CRF-0020 ends here -->
	<% 
		} 
	%>	
<!--
		<input type="button" name="modify_button" id="modify_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")%>" class="button" onClick='enableAllElements_modify()' >&nbsp;

	<td class='label' width='25%'><input align=right type="button" name="remove_button" id="remove_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Remove.label","common_labels")%>" class="button" onClick='remove_payer()' ></td>
-->
		<input type="button" name="accept_button" id="accept_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")%>" class="button" onClick='return checkValues("CV")' >&nbsp;

		<input type="button" name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" class="button"  onClick='cancel()' >
	</td>
	<%
	}
	}catch(Exception e)
	{
		out.println("Exception in Design:"+e);
	}
	%>
</tr>

	<!--<input type=hidden name='adj_rule_ind' id='adj_rule_ind' value="<%=adj_rule_ind%>" >
	<input type=hidden name='adj_perc_amt_ind' id='adj_perc_amt_ind' value="<%=adj_perc_amt_ind%>" >
	<!--<input type=hidden name='adj_perc_amt_value' id='adj_perc_amt_value' value="<%=adj_perc_amt_value%>" >-->
	<input type=hidden name='drg_pmnt_diff_adj_int' id='drg_pmnt_diff_adj_int' value="<%=drg_pmnt_diff_adj_int%>" >
	<input type=hidden name='spl_srv_pmnt_diff_adj_int' id='spl_srv_pmnt_diff_adj_int' value="<%=spl_srv_pmnt_diff_adj_int%>" >
	<input type=hidden name='restrict_check' id='restrict_check' value='<%=restrict_check%>' >
	<input type=hidden name='apprd_amt_restrict_check' id='apprd_amt_restrict_check' value='<%=apprd_amt_restrict_check%>' >
	<input type=hidden name='apprd_days_restrict_check' id='apprd_days_restrict_check' value='<%=apprd_days_restrict_check%>' >

	<input type=hidden name='cred_auth_req_yn' id='cred_auth_req_yn' value='<%=cred_auth_req_yn%>' >
	<input type=hidden name='cred_auth_mand_capt_yn' id='cred_auth_mand_capt_yn' value='<%=cred_auth_mand_capt_yn%>' >
	<input type=hidden name='dflt_auth_ref_as_pol_no_yn' id='dflt_auth_ref_as_pol_no_yn' value='<%=dflt_auth_ref_as_pol_no_yn%>' >

	<input type=hidden name='policy_coverage_basis_ind' id='policy_coverage_basis_ind' value='<%=policy_coverage_basis_ind%>'>

	</table>
	<input type=hidden name="custValidToDate" id="custValidToDate" value="">
	<input type=hidden name="locale" id="locale"  value='<%=locale%>'>
	<input type=hidden name="calling_module_id" id="calling_module_id"  value='<%=strModuleId%>'>
	<input type=hidden name="noofdecimal" id="noofdecimal"  value='<%=noofdecimal%>'>
	<input type=hidden name="billing_group" id="billing_group"  value="<%=billing_group%>">
	<input type=hidden name="p_patient_class" id="p_patient_class"  value='<%=p_patient_class%>'>
	<input type=hidden name="facility_id" id="facility_id"  value='<%=facility_id%>'>
	<input type=hidden name="modify_refresh" id="modify_refresh" value='<%=modify_refresh%>'>
	<input type=hidden name="restricted_YN" id="restricted_YN" value='<%=restricted_YN%>'>
	<input type=hidden name="action" id="action" value='<%=action%>'>
	<input type=hidden name="locn" id="locn" value='<%=location%>'>
	<input type=hidden name="episode_type" id="episode_type" value='<%=episode_type%>'>
	<input type=hidden name="query_string" id="query_string" value="<%=query_string%>">
	<input type=hidden name="blng_grp_code_array" id="blng_grp_code_array" value="<%=blng_grp_code_tokens%>">

	<input type=hidden name="policy_coverage_basis_gbl_ind" id="policy_coverage_basis_gbl_ind" value='<%=policy_coverage_basis_gbl_ind%>'>
	<input type=hidden name="totalRecords" id="totalRecords" value='<%=totalRecords%>'>

	<input type=hidden name="total_keys" id="total_keys" value='<%=total_keys%>'>
	<input type=hidden name="max_priority_arr" id="max_priority_arr" value='<%=max_priority_arr%>'>
	<input type=hidden name="min_priority_arr" id="min_priority_arr" value='<%=min_priority_arr%>'>
	<input type=hidden name="priority_arr" id="priority_arr" value='<%=priority_arr%>'>
	<input type=hidden name="existing_priority_modify" id="existing_priority_modify" value='<%=priority%>'>
	<input type=hidden name="max_priority" id="max_priority" value='<%=max_priority%>'>

	<input type=hidden name="encounter_date_time" id="encounter_date_time" value='<%=encounter_date_time%>'>
	<input type=hidden name="encounter_date_aft_trunc" id="encounter_date_aft_trunc" value='<%=encounter_date_aft_trunc%>'>
	<input type=hidden name="pol_validity_chk_date" id="pol_validity_chk_date" value='<%=pol_validity_chk_date%>'>

	<input type='hidden' name='fin_class_flag_YN' id='fin_class_flag_YN' value='<%=fin_class_flag_YN%>'>
	<input type='hidden' name='autoFinChk' id='autoFinChk' value='<%=autoFinChk%>'>
	<input type='hidden' name='class_code' id='class_code' value='<%=class_code%>'>
	<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
	<input type='hidden' name='oldMapKey' id='oldMapKey' value='<%=oldMapKey%>'>
	<input type='hidden' name='package_enabled_yn' id='package_enabled_yn' value="<%=package_enabled_yn%>">
	<input type='hidden' name='appr_seq_no' id='appr_seq_no' value="1">
	<input type='hidden' name='checked_row' id='checked_row' value='<%=checked_row%>'>
	<input type='hidden' name='rec_edited_YN' id='rec_edited_YN' value='<%=rec_edited_YN%>'>

	<input type='hidden' name='payer_suspended_YN' id='payer_suspended_YN' value='<%=payer_suspended_YN%>'>
	<input type='hidden' name='policy_suspended_YN' id='policy_suspended_YN' value='<%=policy_suspended_YN%>'>
	<input type='hidden' name='chargeLogicYn' id='chargeLogicYn' value='<%=chargeLogicYn%>'>

	<input type='hidden' name='cust_id' id='cust_id' value='<%=strCustomerId%>'>
	<!-- 08/07/2013	Karthikeyan K	MMS-QH-CRF-0010	36789 -->
	<input type='hidden' name='acrossEncounter' id='acrossEncounter' value=''>
	<!-- 08/07/2013	Karthikeyan K	MMS-QH-CRF-0010	36789 -->
	<!-- todayFormated Hidden variable Added by Rajesh V -->
	<input type='hidden' name='todayFormated' id='todayFormated' value='<%=todayFormated%>'>

	<input type='hidden' name='plcyorEncounter' id='plcyorEncounter' value='<%=strPlcyorEnctr%>'>
	<input type='hidden' name='exp_days' id='exp_days' value=''>
	<input type='hidden' name='login_user' id='login_user' value='<%=(String)session.getAttribute("login_user")%>'>

	<input type='hidden' name='blgrp_custgrp' id='blgrp_custgrp'	value='<%=addPayerCustGrpbySetup%>'>

	<input type='hidden' name='strWsNo' id='strWsNo' value='<%=strWsNo%>' >
	<input type='hidden' name='service_code' id='service_code' value='<%=service_code%>' >
	<input type='hidden' name='clinic_code' id='clinic_code' value='<%=clinic_code%>' >
	<!--Added by Sethu for MMS-QH-CRF-0085 ON 18/11/2019-->
	<input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value='<%=nursing_unit_code%>' >

	<input type='hidden' name='interfaceYN' id='interfaceYN' value='<%=interfaceYN%>'>
	<input type='hidden' name='moduleIdCheck' id='moduleIdCheck' value='<%=moduleIdCheck%>'>
	<input type= "hidden" name="payerEligibilityParam" id="payerEligibilityParam"  value='<%=payerEligibilityParam%>'>
	<input type='hidden' name='status_description' id='status_description' value='<%=statuDescriptionSession%>'>
	<input type='hidden' name='validity_period' id='validity_period' value='<%=validityPeriodSession%>'>
	<input type='hidden' name='validity_period_desc_val' id='validity_period_desc_val' value='<%=validityPeriodDescSes%>'>
	<input type='hidden' name='eligibility_code' id='eligibility_code'  value='<%=eligibilityCodeSes%>'>
	<input type='hidden' name='response_code_desc_val' id='response_code_desc_val' value='<%=responseCodeDescSes%>'>
	<input type='hidden' name='response_code' id='response_code' value='<%=responseCodeSession%>'>
	<input type=hidden name='transaction_id' id='transaction_id'  value='<%=transactionIdSes%>'>
	<input type=hidden name='response_date_time' id='response_date_time' value='<%=responseDateTimeSes%>'>
	<input type=hidden name='errorMsg' id='errorMsg' value='<%=statuDescriptionSession%>'>
	<input type=hidden name='remarks' id='remarks'  value='<%=responseCodeDescSes%>'>
	<input type=hidden name='visitRegProcFlag' id='visitRegProcFlag'  value='<%=visitRegProcFlagYN%>'>

	<input type=hidden name="siteSpec" id="siteSpec" id="siteSpec" value="<%=siteSpec %>"> <!-- Added By Vijay For MMS-QF-SCF-567 -->
	<input type=hidden name="siteSpecPolApprv" id="siteSpecPolApprv" id="siteSpecPolApprv" value="<%=siteSpecPolApprv %>" /> <!-- Added V190517-Aravindh/NMC-JD-CRF-0010 -->

	<!-- Added By Niveditha for NMC-JD-CRF-054.1 -->

	<input type=hidden name="cg_det_cust_group_code" id="cg_det_cust_group_code" id="cg_det_cust_group_code" value="<%=cg_det_cust_group_code %>" /> 
	<input type=hidden name="cg_det_op_interface" id="cg_det_op_interface" id="cg_det_op_interface" value="<%=cg_det_op_interface %>" /> 
	<input type=hidden name="cg_det_em_interface" id="cg_det_em_interface" id="cg_det_em_interface" value="<%=cg_det_em_interface %>" /> 
	<input type=hidden name="cg_det_ip_interface" id="cg_det_ip_interface" id="cg_det_ip_interface" value="<%=cg_det_ip_interface %>" /> 
	<input type=hidden name="cg_det_dc_interface" id="cg_det_dc_interface" id="cg_det_dc_interface" value="<%=cg_det_dc_interface %>" /> 
	<input type=hidden name="cg_det_natid_flag" id="cg_det_natid_flag" id="cg_det_natid_flag" value="<%=cg_det_natid_flag %>" /> 
	<input type=hidden name="cg_det_altid1" id="cg_det_altid1" id="cg_det_altid1" value="<%=cg_det_altid1 %>" /> 
	<input type=hidden name="cg_det_altid2" id="cg_det_altid2" id="cg_det_altid2" value="<%=cg_det_altid2 %>" /> 
	<input type=hidden name="cg_det_altid3" id="cg_det_altid3" id="cg_det_altid3" value="<%=cg_det_altid3 %>" /> 
	<input type=hidden name="cg_det_altid4" id="cg_det_altid4" id="cg_det_altid4" value="<%=cg_det_altid4 %>" /> 
	<input type=hidden name="cg_det_altid5" id="cg_det_altid5" id="cg_det_altid5" value="<%=cg_det_altid5 %>" /> 
	<input type=hidden name="cg_det_membshpid_flag" id="cg_det_membshpid_flag" id="cg_det_membshpid_flag" value="<%=cg_det_membshpid_flag %>" /> 
	<input type=hidden name="cg_det_visitreg_flag" id="cg_det_visitreg_flag" id="cg_det_visitreg_flag" value="<%=cg_det_visitreg_flag %>" /> 
	<input type=hidden name="cg_det_policyno_flag" id="cg_det_policyno_flag" id="cg_det_policyno_flag" value="<%=cg_det_policyno_flag %>" /> 

	<input type=hidden name="cg_patdet_patient_id" id="cg_patdet_patient_id" id="cg_patdet_patient_id" value="<%=cg_patdet_patient_id %>" /> 
	<input type=hidden name="cg_patdet_national_id" id="cg_patdet_national_id" id="cg_patdet_national_id" value="<%=cg_patdet_national_id %>" /> 
	<input type=hidden name="cg_patdet_alt_id1_type" id="cg_patdet_alt_id1_type" id="cg_patdet_alt_id1_type" value="<%=cg_patdet_alt_id1_type %>" /> 
	<input type=hidden name="cg_patdet_alt_id1_no" id="cg_patdet_alt_id1_no" id="cg_patdet_alt_id1_no" value="<%=cg_patdet_alt_id1_no %>" /> 
	<input type=hidden name="cg_patdet_alt_id2_type" id="cg_patdet_alt_id2_type" id="cg_patdet_alt_id2_type" value="<%=cg_patdet_alt_id2_type %>" /> 
	<input type=hidden name="cg_patdet_alt_id2_no" id="cg_patdet_alt_id2_no" id="cg_patdet_alt_id2_no" value="<%=cg_patdet_alt_id2_no %>" /> 
	<input type=hidden name="cg_patdet_alt_id3_type" id="cg_patdet_alt_id3_type" id="cg_patdet_alt_id3_type" value="<%=cg_patdet_alt_id3_type %>" /> 
	<input type=hidden name="cg_patdet_alt_id3_no" id="cg_patdet_alt_id3_no" id="cg_patdet_alt_id3_no" value="<%=cg_patdet_alt_id3_no %>" /> 
	<input type=hidden name="cg_patdet_alt_id4_type" id="cg_patdet_alt_id4_type" id="cg_patdet_alt_id4_type" value="<%=cg_patdet_alt_id4_type %>" /> 
	<input type=hidden name="cg_patdet_alt_id4_no" id="cg_patdet_alt_id4_no" id="cg_patdet_alt_id4_no" value="<%=cg_patdet_alt_id4_no %>" /> 
	<input type=hidden name="cg_patdet_oth_altid_type" id="cg_patdet_oth_altid_type" id="cg_patdet_oth_altid_type" value="<%=cg_patdet_oth_altid_type %>" /> 
	<input type=hidden name="cg_patdet_oth_altid_no" id="cg_patdet_oth_altid_no" id="cg_patdet_oth_altid_no" value="<%=cg_patdet_oth_altid_no %>" /> 

	<input type=hidden name="citizen_flag" id="citizen_flag" id="citizen_flag" value="<%=citizen_flag %>" /> 

	<!-- Added By Niveditha for NMC-JD-CRF-054.1 -->

	<input type='hidden' name='site3TierAlmoFeatureYN' id='site3TierAlmoFeatureYN' id='site3TierAlmoFeatureYN' value='<%=site3TierAlmoFeatureYN %>'>

	<!-- todayFormated Hidden variable Added by Rajesh V -->
	</form>
	</body>
	<%if(action.equals("add") && location.equals("outside"))  { %>
	<script> set_selected_blng_grp();	</script>
	<% 
		//if((("ALMO").equals(strCustomerId) || site3TierAlmoFeature == true )) {	
		if(strCustomerId.equals("ALMO") || site3TierAlmoFeatureYN.equals("Y") ) {	
	%>
		<script>cust_grp_lkup('C');</script>
	<%}%>
	<%}%>
	<% 
		//if((strCustomerId.equals("ALMO") ||site3TierAlmoFeature == true ) &&  policy_type_code.length() > 0){ 
		if((strCustomerId.equals("ALMO") || site3TierAlmoFeatureYN.equals("Y") ) &&  policy_type_code.length() > 0) {  
	%>
		<script>LoadDefaultPolicydetails('<%=cust_group_code%>','<%=cust_3%>','<%=policy_type_code%>','<%=strModuleId%>');</script>
	<%} %>
</html>

<%
	String bean_id		= "PkgApprovalBean" ;
	String bean_name	= "eBL.PkgApprovalBean";
	PkgApprovalBean bean			= (PkgApprovalBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setDetails(new ArrayList());
	
	putObjectInBean(bean_id,bean,request);	
	}
	catch(Exception e)
	{ 
		e.printStackTrace();
		out.println("Main Exception:"+e);
	}
	finally
	{	
		if(stmt != null)		stmt.close();
		if(pstmt7 != null)		pstmt7.close();
		ConnectionManager.returnConnection(con, request);
	}
%>

