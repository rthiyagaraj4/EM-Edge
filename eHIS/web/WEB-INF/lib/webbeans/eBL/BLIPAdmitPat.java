/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 
 /*
Sr No        Version           TFS/Incident        SCF/CRF            		 			Developer Name
--------------------------------------------------------------------------------------------------------
1			V230707								AAKH-CRF-0142.1								Namrata Charate					
--------------------------------------------------------------------------------------------------------
*/
package blipin;
import webbeans.eCommon.*;
import java.io.*;
import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import java.sql.* ;
import javax.naming.*;
import javax.transaction.*;
import eCommon.Common.*;
import blPolicy.BLPayerPolicyDetails;
import eBL.PolicyInsuranceMasterBean;
import java.text.SimpleDateFormat;
import javax.rmi.*;
import java.net.*;// added for package  billing
import blPolicy.BLPayerPolicyDetails;
import eBL.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;

import java.text.ParseException;

public class BLIPAdmitPat
{
	public Hashtable billPatientService(Properties p, Connection con,Hashtable hashtableBill)
	{

		//System.out.println(" in blipadmitpat.java,Values passed to BLIPAdmit Bean from IP EJB:"+hashtableBill);

		boolean insertable = true;
//		String cs2,cs3,cs4;
		String strNull = "";

		CallableStatement statement = null;

		//Billing related
//		CallableStatement cstmt = null;
		CallableStatement cstmt1 = null;
//		CallableStatement cstmt2 = null;
//		CallableStatement cstmt3 = null;
//		CallableStatement cstmt4 = null;

		String trntype = "A";
		int	intSrlno = 1;
		/** Starting of the Parameters ***/

		/******  MOD#01   Additional Paramters added**/
		int P_TOT_DEP_AMT=0;
//		int INS_DEDUCT_AMT=0;

		int		P_DLY_CHARGE= 0;
		int		P_DEP_AMT = 0;
		String  strBillingInterfaced="N";	
		String deposit_amount="";
		String admn_dep_coll_reqd_yn = "N", str_deposit_appl_yn="N", str_nursing_unit_type="";
	
		StringBuffer sb = new StringBuffer(" ");
		Hashtable messageHashtable=new Hashtable();

		String facilityId = (String) hashtableBill.get("facilityId");

		String moduleid = (String) hashtableBill.get("module_id");
		if (moduleid == null || moduleid.equals(""))
		{
			 moduleid = "IP";
		}

		String locale			= (String)hashtableBill.get("locale");
		if(locale==null) locale="";

		String temp_encounter_id=(String)hashtableBill.get("encounterid");
		if(temp_encounter_id==null || temp_encounter_id.equals("")) temp_encounter_id="";
		long encounter_id=Long.parseLong(temp_encounter_id);

		String str_blng_grp="";
		String str_slmt_ind="";
		String str_credit_doc_reqd_yn="";
		String str_blng_class="";
		String str_emp_code="";
		String str_slmt_type_code="";
		String str_inst_ref="";
		String str_inst_date="";
		String str_inst_remarks="";
		String str_credit_cust_group_code="";
		String str_credit_cust_code="";
		String str_credit_doc_ref="";
		String str_credit_doc_start_date="";
		String str_credit_doc_end_date="";
		String str_sponsor_cust_group_code="";
		String str_sponsor_cust_code="";
		String str_sponsor_credit_doc_ref="";
		String str_sponsor_credit_doc_start_date="";
		String str_sponsor_credit_doc_end_date="";
		String str_ins_blng_grp="";
		String str_ins_cust_group_code="";
		String str_ins_cust_code="";
		String str_ins_cust_priority="";
		String str_ins_policy_type_code="";
		String str_ins_policy_no="";
		String str_ins_policy_start_date="";
		String str_ins_policy_expiry_date="";
		String str_ins_credit_auth_ref="";
		String str_ins_credit_auth_date="";
		String str_ins_credit_approval_days="";
		String str_ins_credit_approval_amount="";
		String str_ins_policy_eff_from_date="";
		String str_ins_policy_eff_to_date="";
		String str_mcn_for_policy = ""; // V220908	
		String str_reg_ref_id = ""; //V230315
		String str_userId_for_priv = ""; //V230707
		String str_reasonCode_for_priv = ""; //V230707
		String str_ins_adj_rule_ind="";
		String str_ins_adj_perc_amt_ind="";
		String str_ins_adj_perc_amt_value="";
		String str_ins_pmnt_diff_adj_int="";
		String str_ins_drg_pmnt_diff_adj_int="";
		String str_ins_spl_srv_pmnt_diff_adj_int="";
		String str_non_ins_blng_grp="";
		String str_non_ins_credit_doc_reqd_yn="";
		String str_non_ins_slmt_type_code="";
		String str_non_ins_inst_ref="";
		String str_non_ins_inst_date="";
		String str_non_ins_inst_remarks="";
		String str_non_ins_cust_group_code="";
		String str_non_ins_cust_code="";
		String str_non_ins_credit_doc_ref="";
		String str_non_ins_credit_doc_start_date="";
		String str_non_ins_credit_doc_end_date="";
		String str_annual_income="";
		String str_family_asset="";
		String str_no_of_dependants="";
		String str_resp_for_payment="";
		String str_pat_reln_with_resp_person="";
		String str_fin_remarks="";
		String str_gl_holder_name="";
		String str_pat_reln_with_gl_holder="";

		String str_ref_src_main_code="";
		String str_ref_src_sub_code="";
		String str_ins_ref_src_main_code ="";
		String str_ins_ref_src_sub_code ="";
		String str_non_ins_ref_src_main_code ="";
		String str_non_ins_ref_src_sub_code ="";

		String str_tot_valid_enc_with_gl="", str_tot_valid_op_enc_with_gl="", str_tot_valid_ae_enc_with_gl="", str_tot_valid_ip_enc_with_gl="", str_tot_valid_dc_enc_with_gl="";

		String str_upd_patient_fin_dtls_yn="";
		String str_spl_clinic_rel_enc_YN="";
		String str_user_id="";
		String str_fin_auth_user_id="";
		String str_calling_function_id="";
		String str_acct_seq_eff_from_date="";
		String str_acct_seq_eff_to_date="";
		String str_cust_group_code = "";
		String str_cust_code = "";
		String str_doc_ref= "";
		String str_doc_start_date="";
		String str_doc_end_date="";
		double annual_income = 0;
		double family_asset = 0;
		int no_of_dependants = 0;
		String credit_authorisation_by="";
		String claim_code="";
		String membership_number="";

		String err_level = "";
		String sys_message_id = "";
		String err_text = "";

	// Added for incorporating the Billing Classification Requirement
		String str_class_type="";
		String str_class_code="";
		String str_ref_no="";
		String str_inc_asset_ind="";
		String str_ind_inc="";
		String str_ind_inc_freq="";
		String str_spouse_inc="";
		String str_spouse_inc_freq="";
		String str_dependent_inc="";
		String str_dependent_inc_freq="";
		String str_valid_from="";
		String str_valid_to="";
		String str_last_date="";
		String str_remarks="";
		String str_social_pensioner_id="";
		Hashtable resultBL =  new Hashtable();
	/* ******************************* ********************* */
		String str_package_seq_num="",str_package_amt="",str_package_code="";
		String bookingrefno = (String) hashtableBill.get("bookingrefno");
//		String patientid = (String) hashtableBill.get("patientid");
		String encounteridTemp = (String) hashtableBill.get("encounterid");// Long
		long encounterid =0;
		if (encounteridTemp != null)
		{
			encounterid = Long.parseLong(encounteridTemp);
		}
		long P_EPISODE_ID = encounterid ;
		
		
//		String sourcetype = (String) hashtableBill.get("sourcetype");
//		String source = (String) hashtableBill.get("source");
//		String refpractitioner = (String) hashtableBill.get("refpractitioner");
//		String admissiondate = (String) hashtableBill.get("admissiondate");
		String admissiontype = (String) hashtableBill.get("admissiontype");
//		String circumstanceofinjury = (String) hashtableBill.get("circumstanceofinjury");
		String chiefcomplaint = (String) hashtableBill.get("chiefcomplaint");
//		String otdatetime = (String) hashtableBill.get("otdatetime");
//		String practitioner = (String) hashtableBill.get("practitioner");
//		String speciality = (String) hashtableBill.get("speciality");
///		String medicalteam = (String) hashtableBill.get("medicalteam");
//		String patienttype = (String) hashtableBill.get("patienttype");
		String bedclass = (String) hashtableBill.get("bedclass");
		
		String nursingunit = (String) hashtableBill.get("nursingunit");
//		String service = (String) hashtableBill.get("service");
//		String bedno = (String) hashtableBill.get("bedno");
		
//		String roomno = (String) hashtableBill.get("roomno");
		String dailychargeTemp = (String) hashtableBill.get("dailycharge");	//int
		int dailycharge = 0;
		if (dailychargeTemp != null)
		{
			dailycharge = Integer.parseInt(dailychargeTemp);
		}
//uNUSED vAR'S
/*
		String ambulatorystatus = (String) hashtableBill.get("ambulatorystatus");
		String modeofarrival = (String) hashtableBill.get("modeofarrival");
		String name = (String) hashtableBill.get("name");
		String address1 = (String) hashtableBill.get("address1");
		String address2 = (String) hashtableBill.get("address2");
		String address3 = (String) hashtableBill.get("address3");
		String address4 = (String) hashtableBill.get("address4");
		String postalcode = (String) hashtableBill.get("postalcode");
		String telno = (String) hashtableBill.get("telno");
		String mvregnno = (String) hashtableBill.get("mvregnno");
		String emergencydetail = (String) hashtableBill.get("emergencydetail");
		String admtypeind = (String) hashtableBill.get("admtypeind");
		String ancillaryyn = (String) hashtableBill.get("ancillaryyn");
		String patientclass = (String) hashtableBill.get("patientclass");
		String refpractitionername = (String) hashtableBill.get("refpractitionername");
*/
		String addedAtWorkstation = (String) hashtableBill.get("addedAtWorkstation");
		String billing_interfaced = (String) hashtableBill.get("billing_interfaced");
//		String isBlInstalled = (String) hashtableBill.get("isBlInstalled");
//		String P_MODE = (String) hashtableBill.get("P_MODE");
		String P_PATIENT_ID = (String) hashtableBill.get("P_PATIENT_ID");
		String P_BLNG_GRP_ID = (String) hashtableBill.get("P_BLNG_GRP_ID");

	/*Added Newly by muthu against 33044
		String practitioner_id=(String)hashtableBill.get("practitioner_id");
		if(practitioner_id==null) practitioner_id="";
		System.out.println("practitioner_id in IPAdmitPat.java ==> "+practitioner_id);
		String practitioner_name=(String)hashtableBill.get("practitioner_name");
		if(practitioner_name==null) practitioner_name="";
		System.out.println("practitioner_name in IPAdmitPat.java ==> "+practitioner_name);
	//Added Newly by muthu against 33044*/
/*
		String P_BLNG_CLASS_CODE = (String) hashtableBill.get("P_BLNG_CLASS_CODE");
		if (P_BLNG_CLASS_CODE == null)
		{
			P_BLNG_CLASS_CODE ="";
		}
		String P_EMPLOYER_CODE = (String) hashtableBill.get("P_EMPLOYER_CODE");
		String P_SETTLEMENT_IND = (String) hashtableBill.get("P_SETTLEMENT_IND");
		String P_CREDIT_DOC_REF_DESC = (String) hashtableBill.get("P_CREDIT_DOC_REF_DESC");

		String P_CREDIT_DOC_REF_DATE1 = (String) hashtableBill.get("P_CREDIT_DOC_REF_DATE");
		java.sql.Date P_CREDIT_DOC_REF_DATE = null;
		if (!( (P_CREDIT_DOC_REF_DATE1 == null) || (P_CREDIT_DOC_REF_DATE1.equals("")) || (P_CREDIT_DOC_REF_DATE1.equalsIgnoreCase("null") ) ) )
		{
			P_CREDIT_DOC_REF_DATE = java.sql.Date.valueOf(P_CREDIT_DOC_REF_DATE1);
		}

		String P_CREDIT_DOC_REF_START_DATE1 = (String) hashtableBill.get("cred_start_date");
		java.sql.Date P_CREDIT_DOC_REF_START_DATE = null;
		if (!( (P_CREDIT_DOC_REF_START_DATE1 == null) || (P_CREDIT_DOC_REF_START_DATE1.equals("") ) || (P_CREDIT_DOC_REF_START_DATE1.equalsIgnoreCase("null") ) ) )
		{
			P_CREDIT_DOC_REF_START_DATE = java.sql.Date.valueOf(P_CREDIT_DOC_REF_START_DATE1);
		}
	
		String P_CUST_CODE = (String) hashtableBill.get("P_CUST_CODE");
		String P_SLMT_TYPE_CODE = (String) hashtableBill.get("P_SLMT_TYPE_CODE");
		String P_SLMT_DOC_REF_DESC = (String) hashtableBill.get("P_SLMT_DOC_REF_DESC");
		String P_SLMT_DOC_REF_DATE1 = (String) hashtableBill.get("P_SLMT_DOC_REF_DATE");//java.sql.Date   

		java.sql.Date P_SLMT_DOC_REF_DATE =  null;
		if (!( (P_SLMT_DOC_REF_DATE1 == null)|| (P_SLMT_DOC_REF_DATE1.equals("")) || (P_SLMT_DOC_REF_DATE1.equalsIgnoreCase("null") ) ) )
		{
			P_SLMT_DOC_REF_DATE = java.sql.Date.valueOf(P_SLMT_DOC_REF_DATE1);
		}

		String P_SLMT_DOC_REMARKS = (String) hashtableBill.get("P_SLMT_DOC_REMARKS");
		String P_REMARKS = (String) hashtableBill.get("P_REMARKS");
		if (P_REMARKS == null)
		{
			P_REMARKS ="";
		}
		String P_POLICY_TYPE_CODE  = (String) hashtableBill.get("P_POLICY_TYPE_CODE");
		String P_POLICY_NUMBER  = (String) hashtableBill.get("P_POLICY_NUMBER");
		String   P_POLICY_EXPIRY_DATE1 = (String)hashtableBill.get("P_POLICY_EXPIRY_DATE");  		//?

		java.sql.Date P_POLICY_EXPIRY_DATE =  null;
		if (!( (P_POLICY_EXPIRY_DATE1 == null) || (P_POLICY_EXPIRY_DATE1.equals("")) || (P_POLICY_EXPIRY_DATE1.equalsIgnoreCase("null") ) ) )
		{
			P_POLICY_EXPIRY_DATE = java.sql.Date.valueOf(P_POLICY_EXPIRY_DATE1);
		}
	
		String P_NON_INS_BLNG_GRP_ID = (String) hashtableBill.get("P_NON_INS_BLNG_GRP_ID");
		String P_NON_INS_CUST_CODE = (String) hashtableBill.get("P_NON_INS_CUST_CODE");
*/
		String P_EPISODE_TYPE = (String) hashtableBill.get("P_EPISODE_TYPE");
//		String P_PACKAGE_BILL_DOC_TYPE = (String) hashtableBill.get("P_PACKAGE_BILL_DOC_TYPE");
		String P_PACKAGE_BILL_DOC_NUM_TEMP = (String) hashtableBill.get("P_PACKAGE_BILL_DOC_NUM");
		int P_PACKAGE_BILL_DOC_NUM = 0;
		if (P_PACKAGE_BILL_DOC_NUM_TEMP != null)
		{
			P_PACKAGE_BILL_DOC_NUM = Integer.parseInt( P_PACKAGE_BILL_DOC_NUM_TEMP);
		}

/*
		String P_CREDIT_AUTH_REF = (String) hashtableBill.get("P_CREDIT_AUTH_REF");
		String P_CREDIT_AUTH_DATE1 = (String) hashtableBill.get("P_CREDIT_AUTH_DATE");

		java.sql.Date P_CREDIT_AUTH_DATE =  null;
		if (!( (P_CREDIT_AUTH_DATE1 == null) || (P_CREDIT_AUTH_DATE1.equals("") )|| (P_CREDIT_AUTH_DATE1.equalsIgnoreCase("null") ) ) )
		{
			P_CREDIT_AUTH_DATE = java.sql.Date.valueOf(P_CREDIT_AUTH_DATE1);
		}

		java.sql.Date P_EFFECTIVE_DATE = null;
		String  P_EFFECTIVE_DATE1 = (String) hashtableBill.get("P_EFFECTIVE_DATE");

		if (!( (P_EFFECTIVE_DATE1 == null)|| (P_EFFECTIVE_DATE1.equals("")) || (P_EFFECTIVE_DATE1.equalsIgnoreCase("null") ) ) )
		{
			P_EFFECTIVE_DATE = java.sql.Date.valueOf(P_EFFECTIVE_DATE1);
		}

		String P_APPROVED_AMT_TEMP = (String) hashtableBill.get("P_APPROVED_AMT"); //int
		int P_APPROVED_AMT =0;
		if (P_APPROVED_AMT_TEMP != null)
		{
			P_APPROVED_AMT = Integer.parseInt(P_APPROVED_AMT_TEMP);
		}
		String P_APPROVED_DAYS_TEMP = (String) hashtableBill.get("P_APPROVED_DAYS"); //int
		int P_APPROVED_DAYS = 0;
		if (P_APPROVED_DAYS_TEMP != null )
		{	
			P_APPROVED_DAYS = Integer.parseInt(P_APPROVED_DAYS_TEMP);
		}
*/
		String tempPkgCode = ""; //Added for Duplicate Pkg Rajesh V
		String P_EPISODE_STATUS = (String) hashtableBill.get("P_EPISODE_STATUS");
		String P_VISIT_ID = (String) hashtableBill.get("P_VISIT_ID");  //int - added for package billing
		String package_enabled_yn ="N";//added for Package billing
//		String P_ADM_DOCTOR = (String) hashtableBill.get("P_ADM_DOCTOR");
//		String insTrackDtlsExists = (String) hashtableBill.get("insTrackDtlsExists");
//		String expecteddischargedate = (String) hashtableBill.get("expecteddischargedate");
//		String referralid = (String) hashtableBill.get("referralid");
/*
		String upd_fin_dtls = (String) hashtableBill.get("upd_fin_dtls");
		String annual_income = (String) hashtableBill.get("annual_income");
		String family_asset = (String) hashtableBill.get("family_asset");	
		String no_of_dependants = (String) hashtableBill.get("no_of_dependants");

		String resp_for_payment = (String) hashtableBill.get("resp_for_payment");
		String gl_holder_name = (String) hashtableBill.get("gl_holder_name");
		String gl_holder_rel = (String) hashtableBill.get("gl_holder_rel");	
*/

/* ********************************* Adding the Financial Details Values on 5/12/06 by Manivel ********************************** */

		try
		{
			HashMap billing_data=(HashMap)hashtableBill.get("fin_dtls");
			//System.out.println("billng_data in IPAdmitPat bean is:"+billing_data);
			
		//	HashMap payerEligibilityDtlsMap=(HashMap)tabdata.get("PAYER_ELIGIBILITY_CHECK_MAP");
		//	System.out.println("prithivi...BLOPVisit.java::::payerEligibilityDtlsMap...."+payerEligibilityDtlsMap);
		
			
			
		
			
	
			str_blng_grp=(String)billing_data.get("blng_grp");
			
			if(str_blng_grp==null) str_blng_grp="";
			str_slmt_ind=(String)billing_data.get("slmt_ind");
			
			if(str_slmt_ind==null) str_slmt_ind="";
			str_credit_doc_reqd_yn="";
			str_credit_doc_reqd_yn=(String)billing_data.get("credit_doc_reqd_yn");
			
			if(str_credit_doc_reqd_yn==null) str_credit_doc_reqd_yn="";
			
			str_blng_class=(String)billing_data.get("blng_class");
			
			if(str_blng_class==null) str_blng_class="";
			str_emp_code=(String)billing_data.get("emp_code");
			
			if(str_emp_code==null) str_emp_code="";
			str_slmt_type_code=(String)billing_data.get("slmt_type_code");
			
			if(str_slmt_type_code==null) str_slmt_type_code="";
			
			str_inst_ref=(String)billing_data.get("inst_ref");
			if(str_inst_ref==null) str_inst_ref="";
			
			str_inst_date=(String)billing_data.get("inst_date");
			if(str_inst_date==null) str_inst_date="";
			
			str_inst_remarks=(String)billing_data.get("inst_remarks");
			if(str_inst_remarks==null) str_inst_remarks="";
			str_credit_cust_group_code=(String)billing_data.get("credit_cust_group_code");
			if(str_credit_cust_group_code==null) str_credit_cust_group_code="";
			str_credit_cust_code=(String)billing_data.get("credit_cust_code");
			if(str_credit_cust_code==null) str_credit_cust_code="";
			str_credit_doc_ref=(String)billing_data.get("credit_doc_ref");
			if(str_credit_doc_ref==null) str_credit_doc_ref="";
			
			str_credit_doc_start_date=(String)billing_data.get("credit_doc_start_date");
			if(str_credit_doc_start_date==null) str_credit_doc_start_date="";
			str_credit_doc_end_date=(String)billing_data.get("credit_doc_end_date");
			if(str_credit_doc_end_date==null) str_credit_doc_end_date="";
			str_sponsor_cust_group_code=(String)billing_data.get("sponsor_cust_group_code");
			if(str_sponsor_cust_group_code==null) str_sponsor_cust_group_code="";
			str_sponsor_cust_code=(String)billing_data.get("sponsor_cust_code");
			if(str_sponsor_cust_code==null) str_sponsor_cust_code="";
			str_sponsor_credit_doc_ref=(String)billing_data.get("sponsor_credit_doc_ref");
			if(str_sponsor_credit_doc_ref==null) str_sponsor_credit_doc_ref="";
			str_sponsor_credit_doc_start_date=(String)billing_data.get("sponsor_credit_doc_start_date");
			if(str_sponsor_credit_doc_start_date==null) str_sponsor_credit_doc_start_date="";
			str_sponsor_credit_doc_end_date=(String)billing_data.get("sponsor_credit_doc_end_date");
			if(str_sponsor_credit_doc_end_date==null) str_sponsor_credit_doc_end_date="";
			
			str_ins_blng_grp=(String)billing_data.get("ins_blng_grp");
			if(str_ins_blng_grp==null) str_ins_blng_grp="";
			str_ins_cust_group_code=(String)billing_data.get("ins_cust_group_code");
			if(str_ins_cust_group_code==null) str_ins_cust_group_code="";
			str_ins_cust_code=(String)billing_data.get("ins_cust_code");
			if(str_ins_cust_code==null) str_ins_cust_code="";
			str_ins_cust_priority=(String)billing_data.get("ins_cust_priority");
			if(str_ins_cust_priority==null) str_ins_cust_priority="";
			str_ins_policy_type_code=(String)billing_data.get("ins_policy_type_code");
			if(str_ins_policy_type_code==null) str_ins_policy_type_code="";
			str_ins_policy_no=(String)billing_data.get("ins_policy_no");
			if(str_ins_policy_no==null) str_ins_policy_no="";
			
			str_ins_policy_start_date=(String)billing_data.get("ins_policy_start_date");
			if(str_ins_policy_start_date==null) str_ins_policy_start_date="";
			str_ins_policy_expiry_date=(String)billing_data.get("ins_policy_expiry_date");
			if(str_ins_policy_expiry_date==null) str_ins_policy_expiry_date="";
			str_ins_credit_auth_ref=(String)billing_data.get("ins_credit_auth_ref");
			if(str_ins_credit_auth_ref==null) str_ins_credit_auth_ref="";
			str_ins_credit_auth_date=(String)billing_data.get("ins_credit_auth_date");
			if(str_ins_credit_auth_date==null) str_ins_credit_auth_date="";
			
			str_ins_credit_approval_days=(String)billing_data.get("ins_credit_approval_days");
			if(str_ins_credit_approval_days==null) str_ins_credit_approval_days="";
			str_ins_credit_approval_amount=(String)billing_data.get("ins_credit_approval_amount"); 
			if(str_ins_credit_approval_amount==null) str_ins_credit_approval_amount="";
			str_ins_policy_eff_from_date=(String)billing_data.get("ins_policy_eff_from_date");
			if(str_ins_policy_eff_from_date==null) str_ins_policy_eff_from_date="";
			str_ins_policy_eff_to_date=(String)billing_data.get("ins_policy_eff_to_date");
			if(str_ins_policy_eff_to_date==null) str_ins_policy_eff_to_date="";
			
			//V220908
			str_mcn_for_policy = (String)billing_data.get("mcn_for_policy");
			if(str_mcn_for_policy==null) str_mcn_for_policy="";
			System.err.println("str_mcn_for_policy in IPADMISSION BEAN:"+str_mcn_for_policy);			
			
			//V230315
			str_reg_ref_id = (String)billing_data.get("reg_ref_id");
			if(str_reg_ref_id==null) str_reg_ref_id="";
			System.err.println("str_reg_ref_id in IPADMISSION BEAN:"+str_reg_ref_id);
			
			//V230707
			str_userId_for_priv = (String)billing_data.get("userId_for_priv");
			if(str_userId_for_priv==null) str_userId_for_priv="";
			System.err.println("str_userId_for_priv in IPADMISSION BEAN:"+str_userId_for_priv);
			
			//V230707
			str_reasonCode_for_priv = (String)billing_data.get("reasonCode_for_priv");
			if(str_reasonCode_for_priv==null) str_reasonCode_for_priv="";
			System.err.println("str_reasonCode_for_priv in IPADMISSION BEAN:"+str_reasonCode_for_priv);
			
			str_ins_adj_rule_ind=(String)billing_data.get("ins_adj_rule_ind");
			if(str_ins_adj_rule_ind==null) str_ins_adj_rule_ind="";
			str_ins_adj_perc_amt_ind=(String)billing_data.get("ins_adj_perc_amt_ind");
			if(str_ins_adj_perc_amt_ind==null) str_ins_adj_perc_amt_ind="";
			
			str_ins_adj_perc_amt_value=(String)billing_data.get("ins_adj_perc_amt_value");
			if(str_ins_adj_perc_amt_value==null) str_ins_adj_perc_amt_value="";
			str_ins_pmnt_diff_adj_int=(String)billing_data.get("ins_pmnt_diff_adj_int");
			if(str_ins_pmnt_diff_adj_int==null) str_ins_pmnt_diff_adj_int="";
			str_ins_drg_pmnt_diff_adj_int=(String)billing_data.get("ins_drg_pmnt_diff_adj_int");
			if(str_ins_drg_pmnt_diff_adj_int==null) str_ins_drg_pmnt_diff_adj_int="";
			str_ins_spl_srv_pmnt_diff_adj_int=(String)billing_data.get("ins_spl_srv_pmnt_diff_adj_int");
			if(str_ins_spl_srv_pmnt_diff_adj_int==null) str_ins_spl_srv_pmnt_diff_adj_int="";
			str_non_ins_blng_grp=(String)billing_data.get("non_ins_blng_grp");
			if(str_non_ins_blng_grp==null) str_non_ins_blng_grp="";
			
			str_non_ins_credit_doc_reqd_yn=(String)billing_data.get("non_ins_credit_doc_reqd_yn");
			if(str_non_ins_credit_doc_reqd_yn==null) str_non_ins_credit_doc_reqd_yn="";
			str_non_ins_slmt_type_code=(String)billing_data.get("non_ins_slmt_type_code");
			if(str_non_ins_slmt_type_code==null) str_non_ins_slmt_type_code="";
			str_non_ins_inst_ref=(String)billing_data.get("non_ins_inst_ref");
			if(str_non_ins_inst_ref==null) str_non_ins_inst_ref="";
			str_non_ins_inst_date=(String)billing_data.get("non_ins_inst_date");
			if(str_non_ins_inst_date==null) str_non_ins_inst_date="";
			str_non_ins_inst_remarks=(String)billing_data.get("non_ins_inst_remarks");
			if(str_non_ins_inst_remarks==null) str_non_ins_inst_remarks="";

			str_non_ins_cust_group_code=(String)billing_data.get("non_ins_cust_group_code");
			if(str_non_ins_cust_group_code==null) str_non_ins_cust_group_code="";

			str_non_ins_cust_code=(String)billing_data.get("non_ins_cust_code");
			if(str_non_ins_cust_code==null) str_non_ins_cust_code="";
			str_non_ins_credit_doc_ref=(String)billing_data.get("non_ins_credit_doc_ref");
			if(str_non_ins_credit_doc_ref==null) str_non_ins_credit_doc_ref="";
			str_non_ins_credit_doc_start_date=(String)billing_data.get("non_ins_credit_doc_start_date");
			if(str_non_ins_credit_doc_start_date==null) str_non_ins_credit_doc_start_date="";
			str_non_ins_credit_doc_end_date=(String)billing_data.get("non_ins_credit_doc_end_date");
			if(str_non_ins_credit_doc_end_date==null) str_non_ins_credit_doc_end_date="";
			
			str_annual_income=(String)billing_data.get("annual_income");
			if(str_annual_income==null) str_annual_income="";
			if (str_annual_income.equals("")) str_annual_income = "0";
			
			str_family_asset=(String)billing_data.get("family_asset");
			if(str_family_asset==null) str_family_asset="";
			if (str_family_asset.equals("")) str_family_asset = "0";
			
			str_no_of_dependants=(String)billing_data.get("no_of_dependants");
			if(str_no_of_dependants==null) str_no_of_dependants="";
			if (str_no_of_dependants.equals("")) str_no_of_dependants = "0";
			
			str_resp_for_payment=(String)billing_data.get("resp_for_payment"); 
			if(str_resp_for_payment==null) str_resp_for_payment="";
			str_pat_reln_with_resp_person=(String)billing_data.get("pat_reln_with_resp_person");
			if(str_pat_reln_with_resp_person==null) str_pat_reln_with_resp_person="";
			str_fin_remarks=(String)billing_data.get("fin_remarks");
			if(str_fin_remarks==null) str_fin_remarks="";
			str_gl_holder_name=(String)billing_data.get("gl_holder_name");
			if(str_gl_holder_name==null) str_gl_holder_name="";
			//ML-MMOH-SCF-2459 Starts
			System.out.println("str_gl_holder_name before replace IP=>"+str_gl_holder_name);
			if(!str_gl_holder_name.equals("")){
				str_gl_holder_name = str_gl_holder_name.replace("'", "''");
			}
			System.out.println("str_gl_holder_name after replace IP=>"+str_gl_holder_name);
			//ML-MMOH-SCF-2459 ends
			
			str_pat_reln_with_gl_holder=(String)billing_data.get("pat_reln_with_gl_holder");
			if(str_pat_reln_with_gl_holder==null) str_pat_reln_with_gl_holder="";
	
			str_ref_src_main_code=(String)billing_data.get("ref_src_main_code");
			if(str_ref_src_main_code==null) str_ref_src_main_code="";

			str_ref_src_sub_code=(String)billing_data.get("ref_src_sub_code");
			if(str_ref_src_sub_code==null) str_ref_src_sub_code="";

			str_ins_ref_src_main_code=(String)billing_data.get("ins_ref_src_main_code");
			if(str_ins_ref_src_main_code==null) str_ins_ref_src_main_code="";
			//System.out.println("str_ins_ref_src_main_code:"+str_ins_ref_src_main_code);

			str_ins_ref_src_sub_code=(String)billing_data.get("ins_ref_src_sub_code");
			if(str_ins_ref_src_sub_code==null) str_ins_ref_src_sub_code="";
			//System.out.println("str_ins_ref_src_sub_code:"+str_ins_ref_src_sub_code);

			str_non_ins_ref_src_main_code=(String)billing_data.get("non_ins_ref_src_main_code");
			if(str_non_ins_ref_src_main_code==null) str_non_ins_ref_src_main_code="";
			//System.out.println("str_non_ins_ref_src_main_code:"+str_non_ins_ref_src_main_code);

			str_non_ins_ref_src_sub_code=(String)billing_data.get("non_ins_ref_src_sub_code");
			if(str_non_ins_ref_src_sub_code==null) str_non_ins_ref_src_sub_code="";
			//System.out.println("str_non_ins_ref_src_sub_code:"+str_non_ins_ref_src_sub_code);

			str_tot_valid_enc_with_gl=(String)billing_data.get("tot_valid_enc_with_gl");
			if(str_tot_valid_enc_with_gl==null) str_tot_valid_enc_with_gl="";
			//System.out.println("str_tot_valid_enc_with_gl:"+str_tot_valid_enc_with_gl);

			str_tot_valid_op_enc_with_gl=(String)billing_data.get("tot_valid_op_enc_with_gl");
			if(str_tot_valid_op_enc_with_gl==null) str_tot_valid_op_enc_with_gl="";
			//System.out.println("str_tot_valid_op_enc_with_gl:"+str_tot_valid_op_enc_with_gl);

			str_tot_valid_ae_enc_with_gl=(String)billing_data.get("tot_valid_ae_enc_with_gl");
			if(str_tot_valid_ae_enc_with_gl==null) str_tot_valid_ae_enc_with_gl="";
			//System.out.println("str_tot_valid_ae_enc_with_gl:"+str_tot_valid_ae_enc_with_gl);

			str_tot_valid_ip_enc_with_gl=(String)billing_data.get("tot_valid_ip_enc_with_gl");
			if(str_tot_valid_ip_enc_with_gl==null) str_tot_valid_ip_enc_with_gl="";
			//System.out.println("str_tot_valid_ip_enc_with_gl:"+str_tot_valid_ip_enc_with_gl);

			str_tot_valid_dc_enc_with_gl=(String)billing_data.get("tot_valid_dc_enc_with_gl");
			if(str_tot_valid_dc_enc_with_gl==null) str_tot_valid_dc_enc_with_gl="";
			//System.out.println("str_tot_valid_dc_enc_with_gl:"+str_tot_valid_dc_enc_with_gl);

			str_upd_patient_fin_dtls_yn=(String)billing_data.get("upd_patient_fin_dtls_yn");
			if(str_upd_patient_fin_dtls_yn==null) str_upd_patient_fin_dtls_yn="";

			str_spl_clinic_rel_enc_YN =(String)billing_data.get("spl_clinic_rel_enc_YN");
			if(str_spl_clinic_rel_enc_YN==null) str_spl_clinic_rel_enc_YN="N";

			str_user_id=(String)billing_data.get("user_id");
			if(str_user_id==null) str_user_id="";
			str_fin_auth_user_id=(String)billing_data.get("fin_auth_user_id");
			if(str_fin_auth_user_id==null) str_fin_auth_user_id="";
			str_calling_function_id=(String)billing_data.get("calling_function_id");
			if(str_calling_function_id==null) str_calling_function_id="";
			str_acct_seq_eff_from_date="";
			str_acct_seq_eff_to_date="";

			str_cust_group_code="";
			str_cust_code = "";
			str_doc_ref= "";
			str_doc_start_date="";
			str_doc_end_date="";

			// Added for incorporating the Billing Classification Requirement
			str_class_type=(String)billing_data.get("class_type");
			if(str_class_type==null) str_class_type="";

			str_class_code=(String)billing_data.get("class_code");
			if(str_class_code==null) str_class_code="";

			str_ref_no=(String)billing_data.get("ref_no");
			if(str_ref_no==null) str_ref_no="";

			str_inc_asset_ind=(String)billing_data.get("inc_asset_ind");
			if(str_inc_asset_ind==null) str_inc_asset_ind="";

			str_ind_inc=(String)billing_data.get("ind_inc");
			if(str_ind_inc==null) str_ind_inc="";

			str_ind_inc_freq=(String)billing_data.get("ind_inc_freq");
			if(str_ind_inc_freq==null) str_ind_inc_freq="";

			str_spouse_inc=(String)billing_data.get("spouse_inc");
			if(str_spouse_inc==null) str_spouse_inc="";

			str_spouse_inc_freq=(String)billing_data.get("spouse_inc_freq");
			if(str_spouse_inc_freq==null) str_spouse_inc_freq="";

			str_dependent_inc=(String)billing_data.get("dependent_inc");
			if(str_dependent_inc==null) str_dependent_inc="";

			str_dependent_inc_freq=(String)billing_data.get("dependent_inc_freq");
			if(str_dependent_inc_freq==null) str_dependent_inc_freq="";

			str_valid_from=(String)billing_data.get("valid_from");
			if(str_valid_from==null) str_valid_from="";

			str_valid_to=(String)billing_data.get("valid_to");
			if(str_valid_to==null) str_valid_to="";

			str_last_date=(String)billing_data.get("last_date");
			if(str_last_date==null) str_last_date="";

			str_remarks =(String)billing_data.get("remarks");
			if(str_remarks==null) str_remarks="";

			str_social_pensioner_id=(String)billing_data.get("social_pensioner_id");
			if(str_social_pensioner_id==null) str_social_pensioner_id="";
			
			// Karthik added the code to add claim code starts  - IN50355
			
			credit_authorisation_by=(String) billing_data.get("credit_authorisation_by");
			if(credit_authorisation_by==null) credit_authorisation_by="";
			
			claim_code=(String) billing_data.get("claim_code");
			if(claim_code==null) claim_code="";			
			
			membership_number=(String) billing_data.get("membership_number");
			if(membership_number==null) membership_number="";	
			
			//Karthik added the code to add claim code starts  - IN50355
			
/* ************************************************************************************* */
			
			try
			{
				annual_income = Double.parseDouble(str_annual_income);
				family_asset = Double.parseDouble(str_family_asset);
				no_of_dependants = Integer.parseInt(str_no_of_dependants);
			}
			catch(Exception e)
			{
				sb.append("Error in conversion "+e);
			}
		
			if(str_slmt_ind.equals("R"))
			{
				 str_cust_group_code = str_credit_cust_group_code;	
				 str_cust_code = str_credit_cust_code;
				 str_doc_ref= str_credit_doc_ref;
				 str_doc_start_date=str_credit_doc_start_date;
				 str_doc_end_date=str_credit_doc_end_date;
			}
			else if(str_slmt_ind.equals("X") && str_non_ins_blng_grp.equals(""))
			{
				 str_cust_group_code = str_sponsor_cust_group_code;
				 str_cust_code = str_sponsor_cust_code;
				 str_doc_ref= str_sponsor_credit_doc_ref;
				 str_doc_start_date=str_sponsor_credit_doc_start_date;
				 str_doc_end_date=str_sponsor_credit_doc_end_date;
			}
			else if(str_slmt_ind.equals("X") && !str_non_ins_blng_grp.equals(""))
			{
				 str_blng_grp = str_ins_blng_grp;
				 str_cust_group_code = str_ins_cust_group_code;
				 str_cust_code = str_ins_cust_code;
				 str_doc_ref= str_non_ins_credit_doc_ref;
				 str_doc_start_date=str_non_ins_credit_doc_start_date;
				 str_doc_end_date=str_non_ins_credit_doc_end_date;
				 str_slmt_type_code=str_non_ins_slmt_type_code;
			}
			else
			{
				 str_doc_ref= str_credit_doc_ref;
				 str_doc_start_date=str_credit_doc_start_date;
				 str_doc_end_date=str_credit_doc_end_date;
			}
/*
			if(!(str_ref_src_main_code.equals("") && str_ref_src_sub_code.equals("")))
			{
				facilityId=facilityId+"|"+str_ref_src_main_code+"|"+str_ref_src_sub_code;
			}
*/
/*
			if(!str_ins_ref_src_main_code.equals("") && !str_ins_ref_src_sub_code.equals(""))
			{
				str_blng_grp = str_blng_grp+"~"+str_ins_ref_src_main_code+"~"+str_ins_ref_src_sub_code;
			}
*/
		}
		catch(Exception e)
		{
			System.out.println("Exception in Financial Details Values Acquisition:"+e);
			e.printStackTrace();
		}
	
/* ------------------------------------------------------------------------------------------------------------------------------ */

//Unused Var's
/*
		String contact_details = (String) hashtableBill.get("contact_details");
		String res_tel_no = (String) hashtableBill.get("res_tel_no");
		String oth_contact_no = (String) hashtableBill.get("oth_contact_no");
		String email_id = (String) hashtableBill.get("email_id");
		String postal_code = (String) hashtableBill.get("postal_code");
		String country_code = (String) hashtableBill.get("country_code");
		String res_addr_line1 = (String) hashtableBill.get("res_addr_line1");
		String res_addr_line2 = (String) hashtableBill.get("res_addr_line2");
		String res_addr_line3 = (String) hashtableBill.get("res_addr_line3");
		String res_addr_line4 = (String) hashtableBill.get("res_addr_line4");
*/
		String addedById = (String) hashtableBill.get("addedById");
		String modifiedAtWorkstation = (String) hashtableBill.get("modifiedAtWorkstation");
		if(modifiedAtWorkstation==null) modifiedAtWorkstation="";

		String exp_no_of_day_stay = (String) hashtableBill.get("exp_no_of_day_stay"); //int
		if(exp_no_of_day_stay==null) exp_no_of_day_stay="";

//		java.sql.Date added_date = (java.sql.Date) hashtableBill.get("added_date");	//java.sql.Date
		String nursingunittype = (String) hashtableBill.get("nursingunittype");
		if(nursingunittype==null) nursingunittype="";

		String bedtype = (String) hashtableBill.get("bedtype");
		if(bedtype==null) bedtype="";
		
		HashMap payerEligibilityDtlsMap=(HashMap)hashtableBill.get("PACKAGE_APPROVALS");

		System.out.println("patPackSubsDetails payerEligibilityDtlsMap:"+payerEligibilityDtlsMap);

		
		String srlno = (String)hashtableBill.get("srlno");
		String user_id = (String)hashtableBill.get("user_id");
		if (user_id == null)
		{
			user_id = "";
		}
		if (srlno !=null)
		{
			intSrlno = Integer.parseInt(srlno);
		}
		String strFunctionId = (String) hashtableBill.get("calling_function_id");
		String strMessage = " ";
	
		if ( (strFunctionId == null) || (strFunctionId.equals("")) )
		{
			strFunctionId = "ADMISSION";
		}
		String 	credit_auth_user_id = "";
		
		try
		{
			credit_auth_user_id = (String)hashtableBill.get("credit_auth_user_id");
			if (credit_auth_user_id == null)
			{
				credit_auth_user_id = user_id;
			}
		}
		catch (Exception e){}

		try
		{
			String sql_nurs_unit_type = "select NURSING_UNIT_TYPE_CODE from IP_NURSING_UNIT where NURSING_UNIT_CODE = '"+nursingunit+"'";

			//System.err.println("sql_nurs_unit_type:"+sql_nurs_unit_type);
			PreparedStatement pstmt = con.prepareStatement(sql_nurs_unit_type);
			ResultSet rs = pstmt.executeQuery() ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					str_nursing_unit_type = rs.getString(1);
				}
			}
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();
			if(str_nursing_unit_type == null) str_nursing_unit_type="";
			//System.err.println("From BLIPAdmit Pat Bean--> str_nursing_unit_type:"+str_nursing_unit_type);
		}
		catch(Exception e)
		{
			System.err.println("Exception in sql_nurs_unit_type::"+e);
			e.printStackTrace();
		}
		
		try
		{
			String sql_admn_dep_coll_reqd_yn = "select NVL(DEPOSIT_APPL_YN,'N'),NVL(COLLECT_DEP_DURING_ADM_YN,'N') from BL_IP_NURSING_UNIT_TYPE where NURSING_UNIT_TYPE_CODE = '"+str_nursing_unit_type+"'";

			//System.err.println("sql_admn_dep_coll_reqd_yn:"+sql_admn_dep_coll_reqd_yn);
			PreparedStatement pstmt_temp = con.prepareStatement(sql_admn_dep_coll_reqd_yn);
			ResultSet rs_temp = pstmt_temp.executeQuery() ;
			if( rs_temp != null ) 
			{
				while( rs_temp.next() )
				{  
					str_deposit_appl_yn = rs_temp.getString(1);
					admn_dep_coll_reqd_yn = rs_temp.getString(2);
				}
			}
			if (pstmt_temp != null) pstmt_temp.close();
			if (rs_temp != null) rs_temp.close();
			if(str_deposit_appl_yn == null) str_deposit_appl_yn="N";
			if(admn_dep_coll_reqd_yn == null) admn_dep_coll_reqd_yn="N";
			//System.err.println("From BLIPAdmit Pat Bean--> str_deposit_appl_yn:"+str_deposit_appl_yn);
			//System.err.println("From BLIPAdmit Pat Bean--> admn_dep_coll_reqd_yn:"+admn_dep_coll_reqd_yn);
		}
		catch(Exception e)
		{
			System.err.println("Exception in sql_admn_dep_coll_reqd_yn::"+e);
			e.printStackTrace();
		}
		
	
	/** Ending of the Parameters**/

		try
		{
			/***
			Statement patFinStmt = con.createStatement();
			ResultSet patFinRs = null;
			String patFinSql = "Select count(*) ct from BL_PATIENT_FIN_DTLS where patient_id='"+P_PATIENT_ID+"'";
	
			try
			{
				patFinRs =patFinStmt.executeQuery(patFinSql);
				if(patFinRs.next())
				{
					if(patFinRs.getInt("ct")>0)
						P_MODE="U";
					else
						P_MODE="I";
				}
			}
			catch (Exception pat)
			{
				sb.append(pat.toString());
			}
			finally
			{
				if(patFinStmt!=null) patFinStmt.close();
				if(patFinRs!=null) patFinRs.close();
			}
	******/

/*********
The following portion will be used for insertion of the billing Audit information
*******/

			try
			{
				statement=con.prepareCall("{call blaudit.proc_store_old_values( ?,?,?,?,?,?,?,?,?,?,?,?)}");
				statement.setString( 1, P_PATIENT_ID);
				statement.setString( 2, (String) hashtableBill.get("facilityId"));
				//statement.setString( 3, "IP"  );
				statement.setString( 3, moduleid);	
				statement.setString( 4, strFunctionId);  // Function Id
				statement.setString( 5, P_EPISODE_TYPE  ); // Episode Type
				statement.setLong( 6,P_EPISODE_ID   );
				statement.setInt(7,0);
				statement.setString(8,"I");     // Trn. Type
				statement.setString(9,str_fin_auth_user_id);        // Authorized by
				statement.registerOutParameter(10,java.sql.Types.VARCHAR);
				statement.registerOutParameter(11,java.sql.Types.VARCHAR);
				statement.registerOutParameter(12,java.sql.Types.VARCHAR);
				statement.execute();

				err_level = statement.getString(10);
				sys_message_id = statement.getString(11);
				err_text = statement.getString(12);

				if ((sys_message_id != null))
				{
					if (!(sys_message_id.equals("")) || !(sys_message_id.equalsIgnoreCase("null") ) )
					{
						insertable=false;
						sb.append("Exception while calling procedure BL_PATIENT_FIN_DTLS :"+sys_message_id);
					}

				}
				if ((err_text != null))
				{
					if (!(err_text.equals("")) || !(err_text.equalsIgnoreCase("null") ))
					{
						insertable=false;
						sb.append("Exception while calling procedure BL_PATIENT_FIN_DTLS :"+err_text);
					}
				}
				err_level ="";
				sys_message_id ="";
				err_text ="";
				
				statement.close();
			}
			catch(Exception ebl1)
			{
				insertable=false;
				sb.append("Exception while calling procedure BLAUDIT :"+ebl1);
			}
/*
			try
			{
				if( insertable)
				{
					cstmt = con.prepareCall("{call INS_UPD_BL_PAT_FIN_DTLS( ?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				cstmt.setString(1, P_MODE);
				cstmt.setString(2, P_PATIENT_ID);
				cstmt.setString(3, P_BLNG_GRP_ID);
				cstmt.setString(4, P_BLNG_CLASS_CODE);
				cstmt.setString(5, P_EMPLOYER_CODE);
				cstmt.setString(6, P_SETTLEMENT_IND     );
				cstmt.setString(7, P_CREDIT_DOC_REF_DESC);
				cstmt.setDate  (8, P_CREDIT_DOC_REF_DATE);
				cstmt.setString(9, P_CUST_CODE);
				cstmt.setString(10,P_SLMT_TYPE_CODE);
				cstmt.setString(11,P_SLMT_DOC_REF_DESC);
				cstmt.setDate  (12,P_SLMT_DOC_REF_DATE);
				cstmt.setString(13,P_SLMT_DOC_REMARKS);
				cstmt.setString(14,P_REMARKS);
				cstmt.setString(15,P_POLICY_TYPE_CODE);
				cstmt.setString(16,P_POLICY_NUMBER);
				cstmt.setDate  (17,P_POLICY_EXPIRY_DATE);
				cstmt.setString(18,P_NON_INS_BLNG_GRP_ID);
				cstmt.setString(19,P_NON_INS_CUST_CODE);
				cstmt.setString(20,annual_income);
				cstmt.setString(21,family_asset);
				cstmt.setString(22,no_of_dependants);
				cstmt.setString(23,resp_for_payment);
				cstmt.setString(24, addedById);
				cstmt.setString(25, facilityId);
				cstmt.setString(26, addedAtWorkstation);
				cstmt.setString( 27,gl_holder_name);                
				cstmt.setString( 28, gl_holder_rel);                 
				cstmt.setDate( 29, P_CREDIT_DOC_REF_START_DATE);     
	            cstmt.registerOutParameter( 30, java.sql.Types.VARCHAR);
	
				cstmt.execute();
				cstmt.close();
		
				String cs1 = cstmt.getString(30);
			}
		}
		catch(Exception w)
		{
			sb.append("Procedure-INS_UPD_BL_PAT_FIN_DTLS:"+w.toString());
		}
*/
			try
			{
				if (insertable)
				{				
/*
					cstmt1 = con.prepareCall("{call INS_UPD_BL_EPI_FIN_DTLS( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:MI'),?,?,?,?,?,?,?,?,?)}");
					cstmt1.setString(1, "I"  );
					cstmt1.setString(2, P_PATIENT_ID           );
					cstmt1.setLong  (3, P_EPISODE_ID           );
					cstmt1.setString(4, P_EPISODE_TYPE         );
					cstmt1.setString(5, P_BLNG_GRP_ID          );
					cstmt1.setString(6, P_EMPLOYER_CODE        );
					cstmt1.setString(7, P_SETTLEMENT_IND       );
					cstmt1.setString(8, P_CREDIT_DOC_REF_DESC  );
					cstmt1.setDate(9, P_CREDIT_DOC_REF_DATE  );
					cstmt1.setString(10,P_CUST_CODE            );
					cstmt1.setString(11,P_SLMT_TYPE_CODE       );
					cstmt1.setString(12,P_SLMT_DOC_REF_DESC    );
					cstmt1.setDate(13,P_SLMT_DOC_REF_DATE    );
					cstmt1.setString(14,P_SLMT_DOC_REMARKS     );
					cstmt1.setString(15,P_POLICY_TYPE_CODE     );
					cstmt1.setString(16,P_POLICY_NUMBER        );
					cstmt1.setDate(17,P_POLICY_EXPIRY_DATE   );
					cstmt1.setString(18,P_NON_INS_BLNG_GRP_ID  );
					cstmt1.setString(19,P_NON_INS_CUST_CODE    );
					cstmt1.setString(20,P_REMARKS               );
					cstmt1.setString(21,P_PACKAGE_BILL_DOC_TYPE);
					if(P_PACKAGE_BILL_DOC_NUM==0)
					{
						cstmt1.setNull(22,java.sql.Types.VARCHAR);
					}
					else
					{
						cstmt1.setInt(22,P_PACKAGE_BILL_DOC_NUM );
					}
					cstmt1.setString(23,P_CREDIT_AUTH_REF      );
					cstmt1.setDate(24,P_CREDIT_AUTH_DATE     );
					cstmt1.setDate(25,P_EFFECTIVE_DATE       );
	
					if(P_APPROVED_AMT==0)
					{
						cstmt1.setNull(26,java.sql.Types.VARCHAR);
					}
					else
					{
						cstmt1.setInt(26,P_APPROVED_AMT);
					}
			
					if(P_APPROVED_DAYS==0)
					{
						cstmt1.setNull(27,java.sql.Types.VARCHAR);
					}
					else
					{	
						cstmt1.setInt(27,P_APPROVED_DAYS);
					}		
					cstmt1.setString(28,P_EPISODE_STATUS       );
					cstmt1.setInt(29,P_TOT_DEP_AMT         );
					cstmt1.setInt(30,INS_DEDUCT_AMT );
					cstmt1.setString(31, admissiondate );
					cstmt1.setString(32,no_of_dependants);
					cstmt1.setString(33,resp_for_payment);
					cstmt1.setString(34, addedById);
					cstmt1.setString(35, facilityId);
					cstmt1.setString(36, addedAtWorkstation);
					cstmt1.setString(37, gl_holder_name);
					cstmt1.setString(38, gl_holder_rel);
					cstmt1.setDate(39, P_CREDIT_DOC_REF_START_DATE);
					cstmt1.registerOutParameter(40,java.sql.Types.VARCHAR);
	
					cstmt1.execute();

					cs2 = cstmt1.getString(40);
					cstmt1.close();
*/	
					String sql = "{call BL_INS_UPD_EPI_FIN_DTLS('"+(String)hashtableBill.get("P_MODE")+"','"+(String) hashtableBill.get("P_EPISODE_TYPE")+"','"+(String)hashtableBill.get("patientid")+"',"+encounter_id+","+P_EPISODE_ID+",'"+str_blng_grp+"','"+str_ref_src_main_code+"','"+str_ref_src_sub_code+"','"+str_emp_code+"','"+str_doc_ref+"',to_date('"+str_doc_start_date+"','dd/mm/yyyy'),to_date('"+str_doc_end_date+"','dd/mm/yyyy'),'"+str_slmt_type_code+"','"+str_inst_ref+"',to_date('"+str_inst_date+"','dd/mm/yyyy'),'"+str_inst_remarks+"','"+str_ins_ref_src_main_code+"','"+str_ins_ref_src_sub_code+"','"+str_cust_group_code+"','"+str_cust_code+"','"+str_ins_cust_priority+"','"+str_ins_policy_type_code+"','"+str_ins_policy_no+"','"+str_ins_policy_start_date+"','"+str_ins_policy_expiry_date+"','"+str_ins_credit_auth_ref+"','"+str_ins_credit_auth_date+"','"+str_ins_policy_eff_from_date+"','"+str_ins_policy_eff_to_date+"','"+str_ins_credit_approval_amount+"','"+str_ins_credit_approval_days+"','"+str_ins_adj_rule_ind+"','"+str_ins_adj_perc_amt_ind+"','"+str_ins_adj_perc_amt_value+"','"+str_ins_pmnt_diff_adj_int+"','"+str_ins_drg_pmnt_diff_adj_int+"','"+str_ins_spl_srv_pmnt_diff_adj_int+"','"+str_non_ins_blng_grp+"','"+str_non_ins_ref_src_main_code+"','"+str_non_ins_ref_src_sub_code+"','"+str_non_ins_cust_group_code+"','"+str_non_ins_cust_code+"','"+annual_income+"','"+family_asset+"','"+no_of_dependants+"','"+str_resp_for_payment+"','"+str_pat_reln_with_resp_person+"','"+str_gl_holder_name+"','"+str_pat_reln_with_gl_holder+"','"+addedById+"','"+facilityId+"','"+addedAtWorkstation+"','"+str_fin_remarks+"','"+str_fin_auth_user_id+"','"+str_calling_function_id+"','"+P_TOT_DEP_AMT+"','"+P_EPISODE_STATUS+"','"+str_upd_patient_fin_dtls_yn+"','"+str_spl_clinic_rel_enc_YN+"',to_date('"+str_acct_seq_eff_from_date+"','dd/mm/yyyy'),to_date('"+str_acct_seq_eff_to_date+"','dd/mm/yyyy'),'"+str_tot_valid_enc_with_gl+"','"+str_tot_valid_ae_enc_with_gl+"','"+str_tot_valid_op_enc_with_gl+"','"+str_tot_valid_ip_enc_with_gl+"','"+str_tot_valid_dc_enc_with_gl+"','"+credit_authorisation_by+"','"+claim_code+"',?,?,?,?,?,?,?,?,?)}";

					//System.out.println("The Sql in Visit IP is :"+sql);

					statement = con.prepareCall(sql);
					statement.setString(1, membership_number); // membership_number
					statement.registerOutParameter( 2,java.sql.Types.VARCHAR);
					statement.registerOutParameter( 3,java.sql.Types.VARCHAR);
					statement.registerOutParameter( 4,java.sql.Types.VARCHAR);
					statement.setString(5, null);		
					statement.setString(6, str_mcn_for_policy);		//V220908	
					statement.setString(7, str_reg_ref_id);		//V230315
					statement.setString(8, str_userId_for_priv);		//V230707	
					statement.setString(9, str_reasonCode_for_priv);		//V230707	
								
					statement.execute();
	
					insertable = true;
					err_level=statement.getString(2)==null?"":statement.getString(2);
					sys_message_id=statement.getString(3)==null?"":statement.getString(3);
					err_text=statement.getString(4)==null?"":statement.getString(4);

					
		
					if(  (!sys_message_id.equals(""))  || (err_level.equals("10") && !err_text.equals("") ) )
				    {
						insertable=false;

						if((err_level.equals("10") && !err_text.equals("") ))
						{
							sb.append("<br>"+err_text+"<br> ") ;
							//System.out.println("sb mesage is:"+sb);
						}
						else
						{
							messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
							sb.append((String)messageHashtable.get("message"));
							//System.out.println("sb mesage is:"+sb);
						}
						statement.close();
					}
			
					sys_message_id="";
					err_level="";
					err_text="";
				}
			}
			catch(Exception q)
			{
				insertable = false;
				sb.append("Procedure-INS_UPD_BL_EPI_FIN_DTLS:"+q.toString());
			}
			
			
			if(insertable && payerEligibilityDtlsMap!=null && payerEligibilityDtlsMap.size()>0)
								{
									System.out.println("BLOPVisit.java:::Entering into update loop and payerEligibilityDtlsMap size..."+payerEligibilityDtlsMap.size());
									try{
										 String bl_enc_payer_priority_sql="{ CALL XHBUPAINSURANCE.update_bl_enc_payer_priority(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" ; 
										 String mapKeyUpdate="";
										 String blng_grp_code_update="";
										 String cust_3_update="";
										 String ins_cust_group_code_update="";
										 String priority_update="";
										 String policy_type_code_update="";
										 String policy_no_update="";
										 String transactionId="";
										 String responseDateTime="";
										 String responseCode="";
										 String eligibilityCode="";
										 String validityPeriod="";
										 String errorMsg="";
										 String remarks="";
										 String updateError="";
										 String updateResponse="";
										 String validity_until="";
										 String strEncounterId="";
										 String facility_id = "";
										 String episode_type = "";
										 String episodeno = "";
										 String visit_num = "";
										 String patient_id = "";
										 
										 ArrayList payerUpdate=new ArrayList();
										 HashMap hdrDtlsUpdate=new HashMap();
										 Set<String> PkgDtlsSetUpdate =(Set<String>)payerEligibilityDtlsMap.keySet();
										 Iterator<String> pkgItUpdate=PkgDtlsSetUpdate.iterator();
											
										while(pkgItUpdate.hasNext())
										{
											if(insertable)
											{
												mapKeyUpdate=pkgItUpdate.next();	
												payerUpdate=(ArrayList)payerEligibilityDtlsMap.get(mapKeyUpdate);	
												if(payerUpdate!=null && payerUpdate.size()>0)
												{
													hdrDtlsUpdate =	(HashMap)payerUpdate.get(0);
													
													blng_grp_code_update=(String)hdrDtlsUpdate.get("blng_grp_code");
													cust_3_update=(String)hdrDtlsUpdate.get("cust_3");
													ins_cust_group_code_update=(String)hdrDtlsUpdate.get("ins_cust_group_code");
													priority_update=(String)hdrDtlsUpdate.get("priority");
													policy_type_code_update=(String)hdrDtlsUpdate.get("policy_type_code");
													policy_no_update=(String)hdrDtlsUpdate.get("policy_no");
													strEncounterId=(String)hashtableBill.get("encounterid");
													visit_num=(String) hashtableBill.get("P_VISIT_ID");
													episodeno = ""+P_EPISODE_ID;
													
													System.out.println("BLIPVisit.java:::facility id:::encounterId::....."+(String) hashtableBill.get("facilityId")+" ---- "+strEncounterId);
													System.out.println("BLIPVisit.java:::episode type:::episode num::....."+(String) hashtableBill.get("P_EPISODE_TYPE")+" ---- "+episodeno);
													System.out.println("BLIPVisit.java:::visit id..."+visit_num);
													System.out.println("BLIPVisit.java:::blng_grp_code:::cust code:::....."+blng_grp_code_update+" ---- "+cust_3_update);
													System.out.println("BLIPVisit.java:::cust group code:::priority:::..."+ins_cust_group_code_update+" ---- "+priority_update);
													System.out.println("BLIPVisit.java:::policy type:::policy num:::....."+policy_type_code_update+" ----- "+policy_no_update);

													transactionId =(String)hdrDtlsUpdate.get("transaction_id");
													responseDateTime =(String)hdrDtlsUpdate.get("response_date_time");
													responseCode =(String)hdrDtlsUpdate.get("response_code");
													eligibilityCode =(String)hdrDtlsUpdate.get("eligibility_code");
													validityPeriod =(String)hdrDtlsUpdate.get("validity_period");
													errorMsg =(String)hdrDtlsUpdate.get("errorMsg");
													remarks =(String)hdrDtlsUpdate.get("remarks");
													validity_until =(String)hdrDtlsUpdate.get("validity_until");
													
													System.out.println("BLIPVisit.java:::transactionId:::responseDateTime:::..."+transactionId+" -- "+responseDateTime);
													System.out.println("BLIPVisit.java:::responseCode:::eligibilityCode:::..."+responseCode+" -- "+eligibilityCode);
													System.out.println("BLIPVisit.java:::validityPeriod:::errorMsg:::remarks::::..."+validityPeriod+" ---- "+errorMsg+" ---- "+remarks);
													System.out.println("BLIPVisit.java:::validity_until:::..."+validity_until);
													
													transactionId=transactionId.trim();//V230627
													System.out.println("BLIPVisit.java:::after test trim");
													if(transactionId!=null && transactionId.length()>0)
													{
														System.out.println("BLIPVisit.java:::transactionId loop");
														statement = con.prepareCall(bl_enc_payer_priority_sql);
														statement.setString(1,(String) hashtableBill.get("facilityId"));
														if(strEncounterId!=null && strEncounterId!="")
														{
															statement.setLong(2, Long.parseLong(strEncounterId));
														}
														else
														{
															statement.setString(2, strEncounterId);
														}
														statement.setString(3, (String) hashtableBill.get("P_EPISODE_TYPE"));
														if(episodeno!=null && episodeno!="")
														{
															statement.setLong(4, Long.parseLong(episodeno));
														}
														else
														{
															statement.setString(4, episodeno);
														}
														if(visit_num!=null && visit_num!="")
														{
															statement.setInt(5, Integer.parseInt(visit_num));
														}
														else
														{
															statement.setString(5, visit_num);
														}
														statement.setInt(6, 0); // Acct Seq No.
														statement.setString(7, (String) hashtableBill.get("P_PATIENT_ID"));
														statement.setString(8, blng_grp_code_update);
														statement.setString(9, "X");
														statement.setString(10, cust_3_update);
														if(priority_update!=null && priority_update!="")
														{
															statement.setInt(11, Integer.parseInt(priority_update));
														}
														else
														{
															statement.setString(11, priority_update);
														}
														statement.setString(12, policy_type_code_update);
														statement.setString(13, ins_cust_group_code_update);
														if(transactionId!=null && transactionId!="")
														{
															statement.setInt(14, Integer.parseInt(transactionId));
														}
														else
														{
															statement.setString(14, transactionId);
														}
														System.out.println("BLIPVisit.java:::transactionId...."+transactionId);
														if(responseDateTime!=null && responseDateTime!="" && !responseDateTime.equals(" "))
														{
															statement.setTimestamp(15, getTimeStamp(responseDateTime));
														}
														else
														{
															statement.setString(15, "");
														}
														System.out.println("BLIPVisit.java:::responseDateTime...."+responseDateTime);
														if(responseCode!=null && responseCode!="")
														{
															statement.setInt(16, Integer.parseInt(responseCode));
														}
														else
														{
															statement.setString(16, responseCode);
														}
														System.out.println("BLIPVisit.java:::responseCode...."+responseCode);
														statement.setString(17, eligibilityCode);
														System.out.println("BLIPVisit.java:::eligibilityCode...."+eligibilityCode);
														if(validityPeriod!=null && validityPeriod!="" && !validityPeriod.equals(" "))
														{
															statement.setInt(18, Integer.parseInt(validityPeriod));
														}
														else
														{
															statement.setString(18, "");  //AAKH-CRF-0142.1 added empty string
														}
														System.out.println("BLIPVisit.java:::validityPeriod...."+validityPeriod);
														statement.setString(19, errorMsg);
														System.out.println("BLIPVisit.java:::errorMsg...."+errorMsg);
														statement.setString(20, remarks);
														System.out.println("BLIPVisit.java:::remarks...."+remarks);
														statement.setString(21, validity_until);
														System.out.println("BLIPVisit.java:::validity_until...."+validity_until);
														statement.registerOutParameter(22,java.sql.Types.VARCHAR);
														statement.registerOutParameter(23,java.sql.Types.VARCHAR);
												
														statement.execute();
														
														updateResponse=statement.getString(22);
														updateError=statement.getString(23);
														
														System.out.println("BLIPVisit.java:::updateResponse...."+updateResponse);
														System.out.println("BLIPVisit.java:::updateError...."+updateError);
														
														insertable = true;
													}
													else
													{
														System.out.println("BLIPVisit.java:::transactionId length is less than 0");													
													}
													
												}
											}
										}
											
									}
									catch(Exception blp)
									{
										//insertable=false;
										//blp.printStackTrace();
										System.out.println("BLIPVisit.java::: Exception in storing response for eligbility check"+blp);
										sb.append("Exception while calling procedure (only for Eligibility check) bladdlapproval.update_bl_enc_payer_priority :"+blp); 
									}
									
								}
			

			if(insertable)
			{
				String fin_class_flag_YN="N";
				String sql_bl_class_flag = "Select NVL(AUTO_FIN_CLASSFCTN_IN_USE_YN,'N') from BL_PARAMETERS Where OPERATING_FACILITY_ID = '"+facilityId+"'";
				try
				{
					PreparedStatement pstmt_temp = con.prepareStatement(sql_bl_class_flag);
					ResultSet rs_temp = pstmt_temp.executeQuery() ;
					if( rs_temp != null ) 
					{
						while( rs_temp.next() )
						{  
							fin_class_flag_YN = rs_temp.getString(1);
						}
					}
					if (pstmt_temp != null) pstmt_temp.close();
					if (rs_temp != null) rs_temp.close();
					//System.err.println("From Query fin_class_flag_YN:"+fin_class_flag_YN);
				}
				catch(Exception e)
				{
					System.err.println("Exception in sql_bl_class::"+e);
					e.printStackTrace();
				}
				if(fin_class_flag_YN == null) fin_class_flag_YN="N";		
				
				try
				{
					if(fin_class_flag_YN.equals("Y"))
					{
						String sql_class = "{call BLCOMMON.BL_UPD_PAT_CLASS_DTLS('"+facilityId+"','"+P_PATIENT_ID+"','"+P_EPISODE_TYPE+"','"+P_EPISODE_ID+"','"+strNull+"','"+encounter_id+"','"+str_blng_grp+"','"+str_slmt_ind+"','"+str_annual_income+"','"+str_family_asset+"','"+str_inc_asset_ind+"','"+str_ind_inc+"','"+str_ind_inc_freq+"','"+str_spouse_inc+"','"+str_spouse_inc_freq+"','"+str_dependent_inc+"','"+str_dependent_inc_freq+"','"+str_class_code+"','"+str_class_type+"',to_date('"+str_valid_from+"','DD/MM/YYYY'),to_date('"+str_valid_to+"','DD/MM/YYYY'),'"+str_remarks+"','"+str_social_pensioner_id+"','"+str_upd_patient_fin_dtls_yn+"',?,?,?)}";
						//System.err.println("sql_class:"+sql_class);
						statement = con.prepareCall(sql_class);
					
						statement.registerOutParameter( 1,java.sql.Types.VARCHAR);
						statement.registerOutParameter( 2,java.sql.Types.VARCHAR);
						statement.registerOutParameter( 3,java.sql.Types.VARCHAR);
					
					
						statement.execute();
						//System.err.println("Step1");
						insertable = true;
					
						err_level=statement.getString(1);
						sys_message_id=statement.getString(2);
						err_text=statement.getString(3);

						if(err_level==null) err_level="";
						if(sys_message_id==null) sys_message_id="";
						if(err_text==null) err_text="";
						//System.err.println("Step2:"+err_text);
						if(  (!sys_message_id.equals(""))  || (err_level.equals("10") && !err_text.equals("") ) )
						{
							insertable=false;
									//System.err.println("Step3:"+err_text);
							if((err_level.equals("10") && !err_text.equals("") ))
							{						//System.err.println("Step3.1:"+err_text);
								sb.append("<br>"+err_text+"<br> ") ;
							}
							else
							{
														//System.err.println("Step3.2:"+err_text);
								messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
								sb.append((String)messageHashtable.get("message"));
							}
							statement.close();
						}
						//System.err.println("Step4:"+err_text);
					}
					else
					{
						//System.err.println("Step5:"+err_text);
						insertable = true;
					}
				}
				catch(Exception e)
				{
					insertable = false;
					System.err.println("Exception in Classification Date Updation::"+e);
					e.printStackTrace();
				}
			}

			sys_message_id="";
			err_level="";
			err_text="";

			try
			{
				if (insertable)
				{
					if ( (P_EPISODE_TYPE == null)||(P_EPISODE_TYPE.equals("")) ) 
					P_EPISODE_TYPE = "I";

					statement=con.prepareCall("{call blaudit.proc_update_new_values( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		
					statement.setString( 1, P_PATIENT_ID);
					statement.setString( 2, (String) hashtableBill.get("facilityId"));
					//statement.setString( 3, "IP");
					statement.setString( 3, moduleid);
					statement.setString( 4, "ADMISSION");
					statement.setString( 5, "");
					//statement.setString(6,"I");
					statement.setString(6,P_EPISODE_TYPE);
					statement.setLong(7,P_EPISODE_ID );
					statement.setInt(8,0);
					statement.setString(9,str_upd_patient_fin_dtls_yn);
					statement.setString(10,"I");
					statement.setString(11,str_fin_auth_user_id);   //Danger
					statement.setString(12,strNull);
					statement.setString(13,strNull);
					statement.setString(14,strNull);
					statement.setString(15,strNull);
					statement.setString(16,str_fin_remarks);
					statement.setString(17, addedById  );
					statement.setString(18, addedAtWorkstation );
					statement.registerOutParameter(19,java.sql.Types.NUMERIC);
					statement.registerOutParameter(20,java.sql.Types.VARCHAR);
					statement.registerOutParameter(21,java.sql.Types.VARCHAR);
					statement.registerOutParameter(22,java.sql.Types.VARCHAR);
					statement.execute();

//					int intAuditNo = statement.getInt(19);
					err_level = statement.getString(20);
					sys_message_id = statement.getString(21);
					err_text = statement.getString(22);
					if ((sys_message_id != null))
					{
						if (!(sys_message_id.equals("")) || !(sys_message_id.equalsIgnoreCase("null") ) )
						{
							insertable=false;
							sb.append("Exception while calling procedure BLAUDIT  :"+sys_message_id);
						}
					}
					if ((err_text != null))
					{
						if (!(err_text.equals("")) || !(err_text.equalsIgnoreCase("null") ) )
						{
							insertable=false;
							sb.append("Exception while calling procedure BL_PATIENT_FIN_DTLS :"+err_text);
						}
					}
					err_level ="";
					sys_message_id ="";
					err_text = "";

					statement.close();
				}
			}
			catch(Exception ebl1)
			{
				insertable=false;
				sb.append("Exception while calling procedure BLAUDIT PROC_UPDATE :"+ebl1);
			}

/*******
End of the BL Audit
******/





/*Karthik added code starts here INCLUDE_POLICY_DETAILS_CRF 5-25-2013*/	
		if(insertable){

			HashMap plcyDetails=new HashMap(); 
			HashMap billing_data=(HashMap)hashtableBill.get("fin_dtls");
			plcyDetails=(HashMap)billing_data.get("payer_plcy_dtls"); 
			String priority=null;
			String policy_no=null;

			System.err.println("#########BLIPAdmitPat value "+billing_data);

			try{
				
				String patient_id1=(String)hashtableBill.get("P_PATIENT_ID");
				if(patient_id1==null) patient_id1="";	
				String episode_id1=(String)hashtableBill.get("P_EPISODE_ID");
				if(episode_id1==null) episode_id1="";
				String episode_type1=(String)hashtableBill.get("P_EPISODE_TYPE");
				if(episode_type1==null) episode_type1="";
				String encounter_id1=(String)hashtableBill.get("encounterid");
				if(encounter_id1==null) encounter_id1="";
				String added_by_id1 = (String)hashtableBill.get("addedById");
				if (added_by_id1==null) added_by_id1 ="0";
				String blng_grup11= (String)hashtableBill.get("P_BLNG_GRP_ID");
				if (blng_grup11==null) blng_grup11 ="0";
				String facility_id11=(String) hashtableBill.get("facilityId");
				String modified_at_wstn1=(String) hashtableBill.get("modifiedAtWorkstation");
				if (modified_at_wstn1==null) modified_at_wstn1 ="TST";

				HashMap paramMap= new HashMap();
				if(patient_id1==null) patient_id1="";
				paramMap.put("patientId",patient_id1);		  		
				paramMap.put("episodeType",episode_type1);
				paramMap.put("episodeId",encounter_id1);  
				paramMap.put("encounterId",episode_id1);
				paramMap.put("addedById",added_by_id1);
				paramMap.put("modifiedAtWorkstation",modified_at_wstn1);
				paramMap.put("blngGrpid",blng_grup11);
				paramMap.put("facility_id",facility_id11);
				paramMap.put("mode","insert");
				
			HashMap returnMap = new HashMap();
			Set<String> plcyDetailsSet;
			plcyDetailsSet=(Set<String>)plcyDetails.keySet();
			Iterator<String> plcyDetailsIt=plcyDetailsSet.iterator();
			PolicyInsuranceMasterBean plcyRecord=null;
			BLPayerPolicyDetails policyFetch=new BLPayerPolicyDetails();
			//HashMap paramMap=(HashMap)billing_data.get("payer_policy_access_specifier");
			
			while(plcyDetailsIt.hasNext())
			{
			String plcyDetailsKey=(String)plcyDetailsIt.next();
			plcyRecord=(PolicyInsuranceMasterBean)plcyDetails.get(plcyDetailsKey);
			
			StringTokenizer stTok=new StringTokenizer(plcyDetailsKey,"~");
			if(stTok.hasMoreTokens()){
				priority=stTok.nextToken();
				stTok.nextToken();
				stTok.nextToken();
				stTok.nextToken();
				policy_no=stTok.nextToken();
			}

					 paramMap.put("policyNo",policy_no);
					  paramMap.put("Priority",priority);

			
			returnMap=policyFetch.insertHeaderDetails(con,plcyRecord,paramMap);
			
			if(((Boolean) returnMap.get("status")).booleanValue()){
				returnMap=policyFetch.insertPolicyDetails(con,plcyRecord,paramMap);
			}
			else{
				insertable = false;
				con.rollback();
				sb=appendMultipleErrors(returnMap,sb,locale);
				break;
			}							
			
			if(((Boolean) returnMap.get("status")).booleanValue()){
				returnMap=policyFetch.insertPreApprovalDetails(con,plcyRecord,paramMap);
			}else{
				insertable = false;
				con.rollback();
				sb=appendMultipleErrors(returnMap,sb,locale);
				break;
			}
			
			if(!((Boolean) returnMap.get("status")).booleanValue()){						
				insertable = false;
				con.rollback();
				sb=appendMultipleErrors(returnMap,sb,locale);
				break;
			
			}
			
			}

			}
			catch(Exception e){
				System.err.println("Exception happened while inserting policy Definition details");
			}
		}
	/*Karthik added code ends here INCLUDE_POLICY_DETAILS_CRF */



		/*Karthik added code ends here for Overriding Encounter Specific Details Infomation - STARTS */
		if(insertable){			
		
		HashMap billing_data=(HashMap)hashtableBill.get("fin_dtls");			
		String procErrorCode=null;
		String procErrorText=null;
		String procErrorLevel = null;
		
		String lat_facility_id=(String) hashtableBill.get("facilityId");	
		String lat_patient_id=(String) hashtableBill.get("P_PATIENT_ID");
		String lat_upd_patient_fin_dtls_yn=(String)billing_data.get("upd_patient_fin_dtls_yn");
		String lat_added_by_id=	(String)hashtableBill.get("addedById");
		String lat_added_at_ws_no=(String) hashtableBill.get("addedAtWorkstation");			
		System.out.println(lat_facility_id+":"+lat_patient_id+":"+lat_upd_patient_fin_dtls_yn+":"+lat_added_by_id+":"+lat_added_at_ws_no);
		
		CallableStatement updFinLtstStmt = con.prepareCall("{ call blcommonproc.bl_upd_pat_fin_with_lat_data(?,?,?,?,?,?,?,?) }");						
		updFinLtstStmt.setString(1,lat_facility_id);
		updFinLtstStmt.setString(2,lat_patient_id );
		updFinLtstStmt.setString(3,lat_upd_patient_fin_dtls_yn);		
		updFinLtstStmt.setString(4, lat_added_at_ws_no);
		updFinLtstStmt.setString(5,	lat_added_by_id);
		updFinLtstStmt.registerOutParameter(6, Types.VARCHAR);
		updFinLtstStmt.registerOutParameter(7, Types.VARCHAR);
		updFinLtstStmt.registerOutParameter(8, Types.VARCHAR);
		updFinLtstStmt.executeUpdate();

		procErrorLevel = updFinLtstStmt.getString(6);
		procErrorCode = updFinLtstStmt.getString(7);
		procErrorText = updFinLtstStmt.getString(8);		
	
		if(procErrorLevel==null) procErrorLevel="";
		if(procErrorCode==null) procErrorCode="";
		if(procErrorText==null) procErrorText="";
		
		if( !procErrorCode.equals("")  ||  !procErrorText.equals("")  )
		{
			insertable=false;
			sb.append("Exception while Calling blcommonproc.bl_upd_pat_fin_with_lat_data");
			sb.append(procErrorLevel+"-"+procErrorText);
			con.rollback();
		}
		else
		{
			insertable = true;						
		}
		
		if(updFinLtstStmt!=null)
		updFinLtstStmt.close();
		
		}
		
	/*Karthik added code ends here for Overriding Encounter Specific Details Infomation - ENDS */



	if(billing_interfaced.equals("true"))
	{
		// Charge Part
		/****************added for package billing************start**********/
		/********************* insert Associated Pkgs********start************/
//		System.err.println("*** in BLIPAdmitPat****");
		//System.out.println("hashtableBill="+hashtableBill.toString());
		HashMap patPackSubsDetails=(HashMap)hashtableBill.get("PACKAGE_DET");		
		HashMap patPackApprvDtls=(HashMap)hashtableBill.get("PACKAGE_APPROVALS");
		ArrayList patPackAssociateDtls=(ArrayList)hashtableBill.get("PACKAGE_ASSOCIATED");
		ArrayList  pkgDiscountDtls = (ArrayList)hashtableBill.get("PACKAGE_DISCOUNT");
		
		
		StringTokenizer msgIds;	
		System.err.println("patPackSubsDetails V230303="+patPackSubsDetails);
//		System.err.println("patPackApprvDtls 123243434="+patPackSubsDetails);
//		System.err.println("patPackAssociateDtls 123243434="+patPackSubsDetails);
		HashMap	pkgCodeSeqNo	=	new HashMap();
		try
		{		
			PreparedStatement pstmt = con.prepareStatement("SELECT bl_package_enabled_yn(?)  package_enabled_yn from dual");
			pstmt.setString(1,facilityId);
			ResultSet rs = pstmt.executeQuery() ;
			if( rs != null  && rs.next()) 
			{				
					package_enabled_yn  =  rs.getString("package_enabled_yn");	
			}
			
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception  while geting package_enabled_yn from bl_parameters:"+e);
			e.printStackTrace();
		}
		if(package_enabled_yn.equals("Y"))
		{
		//if(patPackSubsDetails!=null && patPackSubsDetails.size()>0)
		//System.out.println("patPackSubsDetails="+patPackSubsDetails.toString());
		//System.out.println("added for package billing start:");
		if(insertable && patPackSubsDetails!=null && patPackSubsDetails.size()>0)
		{
//			System.err.println("When Package Subs Dtls are not NULL");
			String str_ws_by_ip_name1 = "";
		
			String sqlIpAdd="select ws_by_ip_name from sm_facility_param_vw where facility_id = '"+facilityId+"'";
			PreparedStatement pst12=con.prepareStatement(sqlIpAdd);
			ResultSet rst12 = pst12.executeQuery();
			if (rst12!=null)
			{
				if (rst12.next())
				{
					str_ws_by_ip_name1 = rst12.getString("ws_by_ip_name");
				}
			}
			if(rst12 != null) rst12.close();

			if(str_ws_by_ip_name1 == null ) str_ws_by_ip_name1 ="";

			// End for WS Identification by IP Adress/Name

			String p_machine_name1 = "";

			if (str_ws_by_ip_name1.equals("I"))
			{						
				p_machine_name1 = InetAddress.getByName(addedAtWorkstation).getHostName() ;
			}
			else
			{
				p_machine_name1 = addedAtWorkstation;
			}
			ArrayList	pkgDtls		=	new ArrayList();
			ArrayList	pkgCodes		=	new ArrayList();
			ArrayList	packdescs		=	new ArrayList();//Added by muthu
			ArrayList	pkgFrmDate		=	new ArrayList();
			ArrayList	pkgToDate		=	new ArrayList();
			ArrayList	pkgAmt		=	new ArrayList();			
			ArrayList	blng_class_code_list	=	new ArrayList();
			ArrayList	blng_class_desc_list	=	new ArrayList();	
			ArrayList	payerGrpCode_list	=	new ArrayList();
			ArrayList	payerGrpDesc_list	=	new ArrayList();
			ArrayList	payerCode_list	=	new ArrayList();
			ArrayList	payerDesc_list	=	new ArrayList();
			ArrayList	episode_type_list	=	new ArrayList();	//added for IN033044
			ArrayList	practitioner_id_list	=	new ArrayList();	//added for IN033044
			ArrayList	practitioner_name_list	=	new ArrayList();	//added for IN033044
			ArrayList	blng_grp_code_list	=	new ArrayList();	//added for V230303
			ArrayList	blng_grp_desc_list	=	new ArrayList();	//added for V230303
			//ArrayList	pkgEncounter_id	=	new ArrayList(); unused

			try
			{
				//System.out.println("try block blpackage.InsertSubHdr");
				String packageCode="",fromDate="",toDate="",strOPYN="Y",packAmt="N",depositAmt="",status="O",utilizedAmt="";
				//packEnId="",strEMYN="N",strIPYN="N",strDCYN="N"  unused
				String str_error_level="",str_sysmesage_id="",str_error_text="",packageSeqno="";
				String blng_class_code	="",blng_class_desc="",valid_episode="";
				String payerGrpCode="",payerGrpDesc="",payerCode="",payerDesc="";
				String practitioner_id ="", practitioner_name ="",pack_desc=""; //Added by muthu
				CallableStatement pkgSubs_cstmt = null;
				//System.out.println("patPackSubsDetails :"+patPackSubsDetails);
				//System.out.println("condn :"+(patPackSubsDetails.containsKey(P_PATIENT_ID)));

				if(patPackSubsDetails.containsKey(P_PATIENT_ID))
				{
					pkgDtls					=(ArrayList)patPackSubsDetails.get(P_PATIENT_ID);
					//System.out.println("added for package billing pkgDtls :"+pkgDtls);
					if(pkgDtls.size()>0)
					{
						//System.out.println("PkgDtls blpackage.InsertSubHdr");
						pkgCodes = (ArrayList)pkgDtls.get(0);
						//System.out.println("added for package billing pkgCodes :"+pkgCodes);
						
						packdescs = (ArrayList)pkgDtls.get(1);
						//System.out.println("added for package billing packdescs :"+packdescs);

						pkgFrmDate = (ArrayList)pkgDtls.get(2);
						//System.out.println("added for package billing pkgFrmDate :"+pkgFrmDate);

						pkgToDate = (ArrayList)pkgDtls.get(3);
						//System.out.println("added for package billing pkgToDate :"+pkgToDate);

						pkgAmt = (ArrayList)pkgDtls.get(4);
						//System.out.println("added for package billing pkgAmt :"+pkgAmt);

						//	pkgEncounter_id = (ArrayList)pkgDtls.get(5);
						//System.out.println("added for package billing pkgEncounter_id :"+pkgEncounter_id);
			
						blng_class_code_list = (ArrayList)pkgDtls.get(5);
						//System.out.println("added for package billing pkgEncounter_id :"+pkgEncounter_id);
						blng_class_desc_list = (ArrayList)pkgDtls.get(6);
						//System.out.println("added for package billing pkgEncounter_id :"+pkgEncounter_id);
			
						payerGrpCode_list=(ArrayList)pkgDtls.get(7);
						payerGrpDesc_list=(ArrayList)pkgDtls.get(8);
						payerCode_list=(ArrayList)pkgDtls.get(9);
						payerDesc_list=(ArrayList)pkgDtls.get(10);
						episode_type_list = (ArrayList)pkgDtls.get(11);//added for IN021023
						practitioner_id_list=(ArrayList)pkgDtls.get(12);//added for IN033044
						practitioner_name_list=(ArrayList)pkgDtls.get(13);//added for IN033044
						blng_grp_code_list=(ArrayList)pkgDtls.get(15);//V230303
						blng_grp_desc_list=(ArrayList)pkgDtls.get(16);//V230303
					}
				}

				int totRec = 0;
				if(pkgCodes.size() >0)
					totRec = pkgCodes.size();
					//System.out.println("totRec :"+totRec);

				for(int i=0;i<totRec;i++)
				{	
					//System.out.println("for blpackage.InsertSubHdr");
					packageCode	=(String)pkgCodes.get(i);
					//System.out.println("added for package billing packageCode :"+packageCode);
					try{
						tempPkgCode = packageCode.substring(0,packageCode.lastIndexOf("@:"));
					}
					catch(Exception pkgEx){
						tempPkgCode = packageCode;
					}
					str_package_code=tempPkgCode+"|"+str_package_code;
					//System.out.println("str_package_code in process:"+str_package_code);
					pack_desc	=(String)packdescs.get(i);//Added by muthu
					//System.out.println("pack_desc in process:"+pack_desc);

					fromDate	=(String)pkgFrmDate.get(i);
					//System.out.println("added for package billing fromDate :"+fromDate);

					toDate	=(String)pkgToDate.get(i);
					System.out.println("toDate ejb"+toDate);
					//System.out.println("added for package billing toDate :"+toDate);

					packAmt	=(String)pkgAmt.get(i);
					//System.out.println("added for package billing packAmt :"+packAmt);
					str_package_amt = packAmt+"|"+str_package_amt;
					//System.out.println("str_package_amt in process:"+str_package_amt);
					//packEnId	=(String)pkgEncounter_id.get(i);
					//System.out.println("added for package billing packEnId :"+packEnId);
					blng_class_code	=(String)blng_class_code_list.get(i);
					//System.out.println("added for package billing blng_class_code :"+blng_class_code);
		
					blng_class_desc	=(String)blng_class_desc_list.get(i);
					//System.out.println("added for package billing blng_class_desc :"+blng_class_desc);
					String blng_grp_code=(String)blng_grp_code_list.get(i);
					if(blng_grp_code==null) blng_grp_code="";	
					System.out.println("added for package billing blng_grp_code :"+blng_grp_code);
					String blng_grp_desc=(String)blng_grp_desc_list.get(i);
					if(blng_grp_desc==null) blng_grp_desc="";	
					//V230303
					payerGrpCode	=(String)payerGrpCode_list.get(i);
					//System.out.println("added for package billing payerGrpCode :"+payerGrpCode);
					payerGrpDesc	=(String)payerGrpDesc_list.get(i);
					//System.out.println("added for package billing payerGrpDesc :"+payerGrpDesc);
					payerCode	=(String)payerCode_list.get(i);
					//System.out.println("added for package billing payerCode :"+payerCode);
					payerDesc	=(String)payerDesc_list.get(i);
					//System.out.println("added for package billing payerDesc :"+payerDesc);
					valid_episode =(String)episode_type_list.get(i);//added for IN033044
					//System.out.println("added for valid_episode billing payerDesc :"+valid_episode);
					practitioner_id = (String)practitioner_id_list.get(i);//added for IN033044
					//System.out.println("added for package billing practitioner_id :"+practitioner_id);
					practitioner_name = (String)practitioner_name_list.get(i);//added for IN033044
					//System.out.println("added for package billing practitioner_name :"+practitioner_name);
		
					strOPYN="Y";

					String to_date_temp="";
					
					String addl_Charge="";//Added V171212-Gayathri/MMS-DM-CRF-0118
		
					try
					{
						String sqlInsertSubHdr   ="";
						if(!(toDate.equals("")))
						{
							//Below query is changed by muthu against 33044
							//sqlInsertSubHdr   ="{ call   blpackage.InsertSubHdr(?,?,?,to_date(?,'DD/MM/YYYY'),to_date(?,'DD/MM/YYYY'),?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?)}";
							sqlInsertSubHdr   ="{ call   blpackage.InsertSubHdr(?,?,?,to_date(?,'DD/MM/YYYY HH24:MI:SS'),to_date(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?)}";
							to_date_temp=toDate;
							System.out.println("to_date_temp not null ");
						}
						else
						{
							//Below query is changed by muthu against 33044
							//sqlInsertSubHdr   ="{ call   blpackage.InsertSubHdr(?,?,?,to_date(?,'DD/MM/YYYY'),?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?)}";
							sqlInsertSubHdr   ="{ call   blpackage.InsertSubHdr(?,?,?,to_date(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?)}";
							to_date_temp=null;
							System.out.println("to_date_temp  null ");
						}

						pkgSubs_cstmt = con.prepareCall(sqlInsertSubHdr);			
						pkgSubs_cstmt.setString(1,facilityId);
						pkgSubs_cstmt.setString(2,P_PATIENT_ID);
						pkgSubs_cstmt.setString(3,tempPkgCode);
						pkgSubs_cstmt.setString(4,fromDate);		
						pkgSubs_cstmt.setString(5,to_date_temp);							
						pkgSubs_cstmt.setString(6,blng_class_code);							
						pkgSubs_cstmt.setString(7,payerGrpCode);							
						pkgSubs_cstmt.setString(8,payerCode);							
						pkgSubs_cstmt.setString(9,packAmt);							
						pkgSubs_cstmt.setString(10,depositAmt );						
						pkgSubs_cstmt.setString(11,utilizedAmt );
						pkgSubs_cstmt.setString(12,practitioner_id);//Added Newly by muthu against 33044
						pkgSubs_cstmt.setString(13,status);
			//			pkgSubs_cstmt.setString(13,str_user_id);
			//			pkgSubs_cstmt.setString(14,str_user_id);
						pkgSubs_cstmt.setString(14,addedById);
						pkgSubs_cstmt.setString(15,addedById);
						pkgSubs_cstmt.setString(16,p_machine_name1);
						pkgSubs_cstmt.setString(17,facilityId);
						pkgSubs_cstmt.setString(18,p_machine_name1);
						pkgSubs_cstmt.setString(19,facilityId);					
						pkgSubs_cstmt.registerOutParameter(20,java.sql.Types.VARCHAR);
						pkgSubs_cstmt.registerOutParameter(21,java.sql.Types.VARCHAR);
						pkgSubs_cstmt.registerOutParameter(22,java.sql.Types.VARCHAR);
						pkgSubs_cstmt.registerOutParameter(23,java.sql.Types.VARCHAR);	
						pkgSubs_cstmt.setString(24,null);
						pkgSubs_cstmt.registerOutParameter(25,java.sql.Types.VARCHAR); //Added V171212-Gayathri/MMS-DM-CRF-0118					
						pkgSubs_cstmt.setString(26,blng_grp_code);
						pkgSubs_cstmt.execute();					
						packageSeqno=pkgSubs_cstmt.getString(20);
						str_error_level=pkgSubs_cstmt.getString(21);
						str_sysmesage_id=pkgSubs_cstmt.getString(22);					
						str_error_text=pkgSubs_cstmt.getString(23);
						addl_Charge=pkgSubs_cstmt.getString(25); //Added V171212-Gayathri/MMS-DM-CRF-0118 //V230303
							
						if(str_error_level==null) str_error_level="";
						if(str_sysmesage_id==null) str_sysmesage_id="";
						if(str_error_text==null) str_error_text="";
						if(packageSeqno==null) packageSeqno="";
						if(addl_Charge==null) addl_Charge=""; //Added V171212-Gayathri/MMS-DM-CRF-0118
						System.err.println("blng_grp_code in blipadmitpat:"+blng_grp_code);
						System.err.println("ppackageseqno in process:"+packageSeqno);
						System.err.println("str_sysmesage_id in process:"+str_sysmesage_id);
						System.err.println("str_error_text in process:"+str_error_text);
						System.err.println("str_error_text in process:"+str_error_text);
						str_package_seq_num	=packageSeqno+"|"+str_package_seq_num;
						//System.out.println("str_package_seq_num in process:"+str_package_seq_num);
						if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
						{
							insertable=false;
							sb.append("<br>"+str_error_text+"<br> ") ;
						}

						if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
						{
							insertable=false;
							if((str_error_level.equals("10") && !str_error_text.equals("") ))
							{	
								sb.append("<br>"+str_error_text+"<br> ") ;
								//System.out.println("sb mesage in Error is:"+sb);
							}
							else
							{
								if(str_sysmesage_id.indexOf("|") != (-1))
								{
									msgIds=new StringTokenizer(str_sysmesage_id,"|");
									while(msgIds.hasMoreTokens())
									{
										messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
										sb.append((String)messageHashtable.get("message")+"<br>");
									}
									//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
								}
								else
								{
									messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
									sb.append((String)messageHashtable.get("message"));
									//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
								}
							}
							pkgSubs_cstmt.close();	
						}
						if(packageSeqno!=null && !packageSeqno.equals(""))
						{
							pkgCodeSeqNo.put(packageCode,packageSeqno);
						}
						/*************************************/
						
						
						
											
						
						
						
						
						
						
						/*System.out.println("facilityId="+facilityId);
						System.out.println("P_EPISODE_TYPE="+P_EPISODE_TYPE);
						System.out.println("P_PATIENT_ID="+P_PATIENT_ID);
						System.out.println("P_EPISODE_ID=encounterid="+encounterid);
						System.out.println("P_VISIT_ID="+P_VISIT_ID);
						System.out.println("encounteridTemp ="+encounteridTemp );
						System.out.println("str_user_id="+str_user_id);
						System.out.println("addedById="+addedById);
						System.out.println("p_machine_name1="+p_machine_name1);*/
						if(insertable)
						{
							HashMap billing_data=(HashMap)hashtableBill.get("fin_dtls");
							String str_vst_regn_date_time=(String)billing_data.get("encounter_date_time"); 
							if(str_vst_regn_date_time == null) str_vst_regn_date_time="";
							
							String	sqlPkgSubsAssociation   ="{ call   blpackage.AssociateEncounter(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

							//System.out.println("sqlPkgSubsAssociation :"+sqlPkgSubsAssociation);
							CallableStatement pkgSubsAssociate_cstmt = con.prepareCall(sqlPkgSubsAssociation);
							
							pkgSubsAssociate_cstmt.setString(1,facilityId);
							pkgSubsAssociate_cstmt.setString(2,str_calling_function_id);
							pkgSubsAssociate_cstmt.setString(3,P_PATIENT_ID);	
							pkgSubsAssociate_cstmt.setString(4,encounteridTemp);
							pkgSubsAssociate_cstmt.setString(5,P_EPISODE_TYPE);			
							pkgSubsAssociate_cstmt.setString(6,encounteridTemp);			
							pkgSubsAssociate_cstmt.setInt(7,Integer.parseInt(P_VISIT_ID));		
							try{
								tempPkgCode = packageCode.substring(0,packageCode.lastIndexOf("@:"));
							}
							catch(Exception pkgEx){
								tempPkgCode = packageCode;
							}
							pkgSubsAssociate_cstmt.setString(8,tempPkgCode);							
							pkgSubsAssociate_cstmt.setLong(9,Long.parseLong(packageSeqno));								
				//			pkgSubsAssociate_cstmt.setString(10,str_user_id);//sysdate	
							pkgSubsAssociate_cstmt.setString(10,addedById);//sysdate	
							pkgSubsAssociate_cstmt.setString(11,p_machine_name1);				
							pkgSubsAssociate_cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
							pkgSubsAssociate_cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
							pkgSubsAssociate_cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
							pkgSubsAssociate_cstmt.setString(15,str_vst_regn_date_time);
							pkgSubsAssociate_cstmt.execute();						
							str_error_level=pkgSubsAssociate_cstmt.getString(12);
							str_sysmesage_id=pkgSubsAssociate_cstmt.getString(13);					
							str_error_text=pkgSubsAssociate_cstmt.getString(14);
							if(str_error_level==null) str_error_level="";
							if(str_sysmesage_id==null) str_sysmesage_id="";
							if(str_error_text==null) str_error_text="";		
							//System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
							//System.out.println("str_error_text in process:"+str_error_text);
							//System.out.println("str_error_text in process:"+str_error_text);
							if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
							{					
								insertable=false;
								sb.append("<br>"+str_error_text+"<br> ") ;
							}								
							if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
							{
								insertable=false;
								if((str_error_level.equals("10") && !str_error_text.equals("") ))
								{
									sb.append("<br>"+str_error_text+"<br> ") ;
									//System.out.println("sb mesage in Error is:"+sb);
								}
								else
								{
									if(str_sysmesage_id.indexOf("|") != (-1))
									{
										msgIds=new StringTokenizer(str_sysmesage_id,"|");
										while(msgIds.hasMoreTokens())
										{
											messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
											sb.append((String)messageHashtable.get("message")+"<br>");								
										}
										//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
									}
									else
									{
										messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
										sb.append((String)messageHashtable.get("message"));
										//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
									}
								}	
								pkgSubsAssociate_cstmt.close();			
							}
						}			
						/**********************************/
						//	String episode_id="",visit_id="";			 unused
					}
					catch(Exception e)
					{
						insertable=false;
						sb.append(" Exception while calling blpackage.InsertPackage:"+e);
						System.out.println("Exception in blpackage.InsertPackage Call:"+e);
						e.printStackTrace();
					}
				}
				
				/*******Start of pkgDiscountDtls**********************************************************/
				
				if(insertable && pkgDiscountDtls!=null && pkgDiscountDtls.size()>0)
				{
				
				

					try
					{
						String sqlInsert			="insert into bl_package_adhoc_discount(OPERATING_FACILITY_ID,PACKAGE_CODE,PACKAGE_SEQ_NO,PATIENT_ID,CUST_GROUP_CODE,CUST_CODE,DISCOUNT,DISCOUNT_TYPE,ADDED_BY_ID,ADDED_DATE,MODIFIED_BY_ID,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,DISC_REASON_DESC,DISC_REASON_CODE) values(?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?)";
						//System.err.println(facility_id+"/"+pkg_code+"/"+pkg_seq_no+"/"+patient_id+"/"+ins_cust_group_code+"/"+cust_3+"/"+pkg_disc_amt+"/"+pkg_disc_type+"/"+(String) tabdata.get("added_by_id")+"/"+p_machine_name1+"/"+pkg_disc_reason+"/"+pkg_disc_reason_desc);
						PreparedStatement pstmt	= con.prepareStatement(sqlInsert);
						String pkgDiscDtl="";
						String discDetl[];//Pakagecode~~PackageseqNo~~Disc type~~Disc amount~~Reason code~~Reason desc~~cust_grp_code~~custcode
						String pkg_seq_no;
						String pkg_code;
						String cust_grp_code;
						
						for(int ii = 0; ii < pkgDiscountDtls.size();ii++)
						{
							
							pkgDiscDtl = ""+pkgDiscountDtls.get(ii);
							discDetl =  pkgDiscDtl.split("~~");
					     
							pkg_code  =discDetl[0].trim();
					     
							pkg_seq_no = discDetl[1].trim();
							cust_grp_code  =  discDetl[6].trim();
							 
							if(cust_grp_code.equals("CASH") ||cust_grp_code.equals("undefined"))
								cust_grp_code ="";
							 
						     
							if((pkg_seq_no==null || pkg_seq_no.equals("")) && pkgCodeSeqNo!=null && pkgCodeSeqNo.size()>0 && pkgCodeSeqNo.containsKey(pkg_code))
							{
								pkg_seq_no=(String)pkgCodeSeqNo.get(pkg_code);
							}
						     
						     
						   if(pkg_seq_no == null || pkg_seq_no.equals(""))
						   {
								messageHashtable=MessageManager.getMessage(locale,"BL8558","BL");
								sb.append((String)messageHashtable.get("message"));
								insertable=false;
								con.rollback();
								break;
						   }
						     
						     
							pstmt.setString(1,facilityId); 
							try{
								tempPkgCode = pkg_code.substring(0,pkg_code.lastIndexOf("@:"));
							}
							catch(Exception pkgEx){
								tempPkgCode = pkg_code;
							}
							pstmt.setString(2,tempPkgCode);
							pstmt.setInt(3,Integer.parseInt(pkg_seq_no));
							pstmt.setString(4,P_PATIENT_ID);
							pstmt.setString(5,cust_grp_code);
							pstmt.setString(6,discDetl[7].trim());

							//System.out.println("pkg_disc_amt in BLIPVisit.java "+pkg_disc_amt);//muthu	
							//System.out.println("pkg_disc_amt in BLIPVisit.java Double "+Double.parseDouble(pkg_disc_amt));//muthu
							//Added by muthu on 5/22/2012
							//if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
						if(discDetl[4]!= null && discDetl[4].trim()!="")
						{													
							pstmt.setDouble(7,Double.parseDouble(discDetl[3]));
						}
						//Added by muthu on 5/22/2012
						pstmt.setString(8,discDetl[2]);										
						pstmt.setString(9,addedById);
						pstmt.setString(10,addedById);
						pstmt.setString(11,addedAtWorkstation);
						pstmt.setString(12,facilityId);
						pstmt.setString(13,addedAtWorkstation);
						pstmt.setString(14,facilityId);
							
							
						pstmt.setString(15,discDetl[5].trim());//DESC
						pstmt.setString(16,discDetl[4].trim());
						int insertResult = pstmt.executeUpdate();
							//System.err.println("insertResult:"+insertResult);
						if(insertResult !=-2 && insertResult < 0) 
						{
							sb.append("<br>"+"Insert Failed on BL_PACKAGE_ADHOC_DISCOUNT"+"<br> ") ;				
							insertable = false;
							con.rollback();
							break;
						}
						else	
						{
							insertable=true;
						}
						
					}
						
						
						if(pstmt!=null) pstmt.close();
					}
					catch(Exception e)
					{
						insertable = false;
						System.err.println("Insert Failed on BL_PACKAGE_ADHOC_DISCOUNT"+e);
						e.printStackTrace();
						sb.append("<br>"+"Insert Failed on BL_PACKAGE_ADHOC_DISCOUNT"+"<br> ") ;
					}
									
					
				}					
				
				
				
				/*******end of pkgDiscountDtls**********************************************************/
				

				//System.out.println("str_package_amt afterInsertPackage Call:"+str_package_amt);
				//System.out.println("str_package_code  afterInsertPackage Call:"+str_package_code);
				//System.out.println("str_package_seq_num  afterInsertPackage Call:"+str_package_seq_num);
				resultBL.put("str_package_amt",str_package_amt);
				resultBL.put("str_package_code",str_package_code);
				resultBL.put("str_package_seq_num",str_package_seq_num);
			}
			catch(Exception e)
			{
				insertable=false;
				//sb.append(" Exception while calling blpackage.InsertPackage:"+e);
				System.out.println("Exception in blpackage.InsertPackage Call:"+e);
				e.printStackTrace();
			}
		}		

		if(insertable && patPackAssociateDtls!=null && patPackAssociateDtls.size()>0)
		{
//			System.err.println("When Package Association Dtls are not NULL");
			try
			{		
				String pkg_dtls="";
				String pkg_seq_no="";
				String pkg_code="";
				String pkg_desc="";
				String str_error_level="",str_sysmesage_id="",str_error_text="";
				String str_ws_by_ip_name1 = "";
				
				StringTokenizer pkgSt=null;
				String sqlIpAdd="select ws_by_ip_name from sm_facility_param_vw where facility_id = '"+facilityId+"'";
				PreparedStatement pst12=con.prepareStatement(sqlIpAdd);
				ResultSet rst12 = pst12.executeQuery();
				if (rst12!=null)
				{
				   if (rst12.next())
				   {
						 str_ws_by_ip_name1 = rst12.getString("ws_by_ip_name");
				   }
				}
				if(rst12 != null) rst12.close();
				if ( str_ws_by_ip_name1 == null ) str_ws_by_ip_name1 ="";

				// End for WS Identification by IP Adress/Name
				String p_machine_name1 = "";
				if (str_ws_by_ip_name1.equals("I"))
				{						
					p_machine_name1 = InetAddress.getByName(addedAtWorkstation).getHostName() ;
				}
				else
				{
					p_machine_name1 = addedAtWorkstation;
				}
		
	
				/*System.out.println("facilityId="+facilityId); 
				System.out.println("P_EPISODE_TYPE="+P_EPISODE_TYPE);
				System.out.println("P_PATIENT_ID="+P_PATIENT_ID);
				System.out.println("P_EPISODE_ID=encounterid="+encounterid);
				System.out.println("P_VISIT_ID="+P_VISIT_ID);
				System.out.println("encounteridTemp ="+encounteridTemp );
				System.out.println("str_user_id="+str_user_id);
				System.out.println("addedById="+addedById);
				System.out.println("p_machine_name1="+p_machine_name1);
				System.out.println("patPackAssociateDtls="+patPackAssociateDtls.toString());*/

				String	sqlPkgAssociation   ="{ call   blpackage.AssociateEncounter(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				HashMap billing_data=(HashMap)hashtableBill.get("fin_dtls");
				String str_vst_regn_date_time=(String)billing_data.get("encounter_date_time"); 
				if(str_vst_regn_date_time == null) str_vst_regn_date_time="";

				//System.out.println("sqlPkgAssociation :"+sqlPkgAssociation);
				CallableStatement pkgAssociate_cstmt = con.prepareCall(sqlPkgAssociation);
				for(int i=0;i<patPackAssociateDtls.size();i++)
				{
					pkg_dtls=(String)patPackAssociateDtls.get(i);
					//System.out.println("pkg_dtls="+pkg_dtls);
					pkgSt=new StringTokenizer(pkg_dtls,"~~");
					if(pkgSt.hasMoreTokens())
						pkg_code=(String)pkgSt.nextToken();
					else
						pkg_code="";
					if(pkgSt.hasMoreTokens())
					pkg_desc=(String)pkgSt.nextToken();
					else
						pkg_desc="";
					if(pkgSt.hasMoreTokens())
						pkg_seq_no=(String)pkgSt.nextToken();	
					else
						pkg_seq_no="";
						//System.out.println("i="+i);
						//System.out.println("pkg_code="+pkg_code);
						//System.out.println("pkg_desc="+pkg_desc);
						//System.out.println("pkg_seq_no="+pkg_seq_no);
			
					pkgAssociate_cstmt.setString(1,facilityId);
					pkgAssociate_cstmt.setString(2,str_calling_function_id);
					pkgAssociate_cstmt.setString(3,P_PATIENT_ID);	
					pkgAssociate_cstmt.setString(4,encounteridTemp);
					pkgAssociate_cstmt.setString(5,P_EPISODE_TYPE);			
					pkgAssociate_cstmt.setString(6,encounteridTemp);
					if(P_VISIT_ID==null || P_VISIT_ID.equals(""))
					pkgAssociate_cstmt.setString(7,null);		
					else
					pkgAssociate_cstmt.setInt(7,Integer.parseInt(P_VISIT_ID));			
					pkgAssociate_cstmt.setString(8,pkg_code);	
					if(pkg_seq_no==null || pkg_seq_no.equals(""))			
					pkgAssociate_cstmt.setString(9,null);	
					else 
					pkgAssociate_cstmt.setLong(9,Long.parseLong(pkg_seq_no));								
					pkgAssociate_cstmt.setString(10,str_user_id);//sysdate	
					pkgAssociate_cstmt.setString(11,p_machine_name1);				
					pkgAssociate_cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
					pkgAssociate_cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
					pkgAssociate_cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
					pkgAssociate_cstmt.setString(15,str_vst_regn_date_time);
					pkgAssociate_cstmt.execute();						
					str_error_level=pkgAssociate_cstmt.getString(12);
					str_sysmesage_id=pkgAssociate_cstmt.getString(13);					
					str_error_text=pkgAssociate_cstmt.getString(14);
					if(str_error_level==null) str_error_level="";
					if(str_sysmesage_id==null) str_sysmesage_id="";
					if(str_error_text==null) str_error_text="";		
					//System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
					//System.out.println("str_error_text in process:"+str_error_text);
					//System.out.println("str_error_text in process:"+str_error_text);
					if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
					{
						insertable=false;
						sb.append("<br>"+str_error_text+"<br> ") ;
					}								
					if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
					{
						insertable=false;
						if((str_error_level.equals("10") && !str_error_text.equals("") ))
						{
							sb.append("<br>"+str_error_text+"<br> ") ;
							//System.out.println("sb mesage in Error is:"+sb);
						}
						else
						{
							if(str_sysmesage_id.indexOf("|") != (-1)){
							msgIds=new StringTokenizer(str_sysmesage_id,"|");
							while(msgIds.hasMoreTokens())
							{
								messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
								sb.append((String)messageHashtable.get("message")+"<br>");													
							}
							//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
							}else{
								messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
								sb.append((String)messageHashtable.get("message"));
								//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
							}
						}				
						break;
					}			
				}
				if(pkgAssociate_cstmt!=null) pkgAssociate_cstmt.close();
			}
			catch(Exception e)
			{
				insertable=false;
				System.out.println("Exception while inserting package approvals="+e);
				//out.println("Exception while inserting package approvals="+);
				e.printStackTrace();
			}
		}
		/********************* insert Associated Pkgs********end************/
		/************insert package approvals**************start**********/
		HashMap hdrDtls=new HashMap();
		HashMap authDtls=new HashMap();
		HashMap pkgApprovals=new HashMap();

		String blng_grp_code ="";
		String cust_3 ="";
		String ins_cust_group_code ="";
		String priority ="";
		String policy_type_code ="";
		String policy_no ="";	
		String policy_eff_frm_date="";
		String p_machine_name1 = "";
		String insRec_YN = "N";
		if(insertable && patPackApprvDtls!=null && patPackApprvDtls.size()>0)
		{
//			System.err.println("When Package Approval Dtls are not NULL");
			try
			{
				/*********************************/
				ArrayList payer=new ArrayList();
				//Set<String> 	credit_auth_ref_set;	

				ArrayList creditPkgApprovals=new ArrayList();
				ArrayList record=new ArrayList();
				ArrayList pkgApprvRecord=new ArrayList();
				Set<String> PkgDtlsSet;
				Set<String> authDtlsSet;
				Iterator<String> authIt;
				
				String pkg_seq_no="";
				String pkg_code="";
				String pkg_desc="";
				String pkg_apprv_amt="";
				String appr_seq_no="";//// added for IN 20964 
				String credit_auth_ref="";
				String credit_auth_date="";
				String credit_apprd_amt="";
				String credit_apprd_days="";
				String pkg_dtls_yn="";
				String pol_validity_chk_date="";
				String mapKey="";
				String authKey="";
				String str_error_level="",str_sysmesage_id="",str_error_text="";
				String str_ws_by_ip_name1 = "";

				String sqlIpAdd="select ws_by_ip_name from sm_facility_param_vw where facility_id = '"+facilityId+"'";
				PreparedStatement pst12=con.prepareStatement(sqlIpAdd);
				ResultSet rst12 = pst12.executeQuery();
				if (rst12!=null)
				{
				   if (rst12.next())
				   {
						str_ws_by_ip_name1 = rst12.getString("ws_by_ip_name");
				   }
				}
				if(rst12 != null) rst12.close();
				if ( str_ws_by_ip_name1 == null ) str_ws_by_ip_name1 ="";
		// End for WS Identification by IP Adress/Name

				if (str_ws_by_ip_name1.equals("I"))
				{						
					p_machine_name1 = InetAddress.getByName(addedAtWorkstation).getHostName() ;
				}
				else
				{
					p_machine_name1 =addedAtWorkstation;
				}

				String sqlPayerApproval   ="{ call   bladdlapproval.insencpayerapproval(?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'DD/MM/YYYY'),	?,to_date(?,'DD/MM/YYYY'),?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?)}";
				CallableStatement payer_cstmt = con.prepareCall(sqlPayerApproval);
				String sqlPkgApproval   ="{ call   bladdlapproval.insencpayerpkgapproval(?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'DD/MM/YYYY'),?,?,	?,to_date(?,'DD/MM/YYYY'),?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?)}";
				CallableStatement pkg_cstmt = con.prepareCall(sqlPkgApproval);		
				//System.out.println("facilityId="+facilityId);
				//System.out.println("P_EPISODE_TYPE="+P_EPISODE_TYPE);
				//System.out.println("P_PATIENT_ID="+P_PATIENT_ID);
				//System.out.println("bookingrefno="+bookingrefno);
				//System.out.println("P_EPISODE_ID="+P_EPISODE_ID);
				//System.out.println("P_VISIT_ID="+P_VISIT_ID);
				//System.out.println(" encounterid ="+ encounterid );
				//System.out.println("str_user_id="+str_user_id);
				//System.out.println("addedById="+addedById);
				//System.out.println("p_machine_name1="+p_machine_name1);
				//System.out.println("patPackApprvDtls="+patPackApprvDtls.toString());

				PkgDtlsSet=(Set<String>)patPackApprvDtls.keySet();
				//System.out.println("PkgDtlsSet="+PkgDtlsSet.toString());
				Iterator<String> pkgIt=PkgDtlsSet.iterator();
				while(pkgIt.hasNext())
				{
	//				System.err.println(" inside pkgIt iinsertable="+insertable);
					if(insertable)
					{
						mapKey=pkgIt.next();			
						payer=(ArrayList)patPackApprvDtls.get(mapKey);	
	//					System.err.println("1805 payer="+payer.toString());	
						//System.out.println("mapKey="+mapKey);				
						if(payer!=null && payer.size()>0)
						{
							hdrDtls=	(HashMap)payer.get(0);
							authDtls=	(HashMap)payer.get(1);
							pkgApprovals=	(HashMap)payer.get(2);
							/*************get hdr dtls*********start************/
							blng_grp_code=(String)hdrDtls.get("blng_grp_code");
							cust_3=(String)hdrDtls.get("cust_3");
							ins_cust_group_code=(String)hdrDtls.get("ins_cust_group_code");
							priority=(String)hdrDtls.get("priority");
							policy_type_code=(String)hdrDtls.get("policy_type_code");
							policy_no=(String)hdrDtls.get("policy_no");
							policy_eff_frm_date=(String)hdrDtls.get("policy_eff_frm_date");
							/*************get hdr dtls*********end************/						
							//System.out.println("blng_grp_code="+blng_grp_code);				
							//System.out.println("cust_3="+cust_3);				
							//System.out.println("ins_cust_group_code="+ins_cust_group_code);				
							//System.out.println("priority="+priority);				
							//System.out.println("policy_type_code="+policy_type_code);				
							//System.out.println("policy_no="+policy_no);				
							//System.out.println("hdrDtls="+hdrDtls.toString());				
							//System.out.println("authDtls="+authDtls.toString());				
							//System.out.println("pkgApprovals="+pkgApprovals.toString());
							authDtlsSet=(Set<String>)authDtls.keySet();
	//						System.err.println("1831 authDtlsSet="+authDtlsSet.toString());
							authIt=authDtlsSet.iterator();
					
							if(authDtls!=null && authDtls.size()>0)
							{
								insRec_YN="Y";
								while(authIt.hasNext())
								{
	//								System.err.println("1838 authIt not null");
									record=new ArrayList();						
									authKey=(String)authIt.next();
									record=(ArrayList)authDtls.get(authKey);
									//System.out.println("record="+record.toString());
									appr_seq_no=(String)record.get(0);
									credit_auth_ref=(String)record.get(1);
									credit_auth_date=(String)record.get(2);
									credit_apprd_amt=(String)record.get(3);
									credit_apprd_days=(String)record.get(4);
									pkg_dtls_yn=(String)record.get(5);	
									pol_validity_chk_date=(String)record.get(6);	
									if(appr_seq_no!=null && !appr_seq_no.equals(""))
										appr_seq_no=appr_seq_no.trim();
									if(credit_auth_ref!=null && !credit_auth_ref.equals(""))
										credit_auth_ref=credit_auth_ref.trim();
									if(credit_apprd_amt!=null && !credit_apprd_amt.equals(""))
										credit_apprd_amt=credit_apprd_amt.trim();
									if(credit_apprd_days!=null && !credit_apprd_days.equals(""))
										credit_apprd_days=credit_apprd_days.trim();
									if(pkg_dtls_yn!=null && !pkg_dtls_yn.equals(""))
										pkg_dtls_yn=pkg_dtls_yn.trim();
									//System.out.println("credit_auth_ref="+credit_auth_ref);								
									//System.out.println("credit_auth_date="+credit_auth_date);								
	//								System.err.println("credit_apprd_amt="+credit_apprd_amt);								
	//								System.err.println("credit_apprd_days="+credit_apprd_days);	
									//System.out.println("pkg_dtls_yn="+pkg_dtls_yn);	
									//System.out.println("pol_validity_chk_date="+pol_validity_chk_date);	
									//System.out.print("**** insert payer approv**@@@@****");		
									/**********insert payer approvals*****start*******/
									//sqlPkgApproval   ="";
									//sqlPkgApproval   ="{ call   bladdlapproval.insencpayerapproval(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,	to_date(?,'DD/MM/YYYY'),?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?)}";

									//	System.out.println("sqlPkgApproval :"+sqlPkgApproval);
									//payer_cstmt = con.prepareCall(sqlPkgApproval);	
									if(credit_apprd_amt !=null && !credit_apprd_amt.equals(""))
									{
										payer_cstmt.setString(1,facilityId);
										payer_cstmt.setString(2,P_EPISODE_TYPE);
										payer_cstmt.setLong(3,P_EPISODE_ID);
										if(P_VISIT_ID==null || P_VISIT_ID.equals(""))
											payer_cstmt.setString(4,null);	
										else
											payer_cstmt.setInt(4,Integer.parseInt(P_VISIT_ID));			
									//  Commented on  27/12/2013   against  MMS-SCF-0205 
										//payer_cstmt.setString(5,bookingrefno);							
										payer_cstmt.setString(5,null);

										payer_cstmt.setString(6,"1");							
										payer_cstmt.setString(7,P_PATIENT_ID);							
										payer_cstmt.setLong(8, encounterid);						
										payer_cstmt.setString(9,blng_grp_code );
										payer_cstmt.setString(10,ins_cust_group_code);
										payer_cstmt.setString(11,cust_3);
										if(priority==null || priority.equals(""))
											payer_cstmt.setString(12,null);
										else 
											payer_cstmt.setInt(12,Integer.parseInt(priority));
										payer_cstmt.setString(13,policy_type_code);
										payer_cstmt.setString(14,policy_no);	
										payer_cstmt.setString(15,policy_eff_frm_date);								
										payer_cstmt.setString(16,credit_auth_ref.trim());												
										payer_cstmt.setString(17,credit_auth_date.trim());	
										payer_cstmt.setString(18,appr_seq_no);								
										if(credit_apprd_amt==null || credit_apprd_amt.equals(""))							
											payer_cstmt.setString(19,null);	
										else 
											payer_cstmt.setDouble(19,Double.parseDouble(credit_apprd_amt));	
										if(credit_apprd_days==null || credit_apprd_days.equals(""))									
											payer_cstmt.setString(20,null);	
										else
										payer_cstmt.setLong(20,Long.parseLong(credit_apprd_days));					
	//									payer_cstmt.setString(19,str_user_id);//sysdate
	//									payer_cstmt.setString(20,str_user_id);//sysdate
										payer_cstmt.setString(21,addedById);//sysdate
										payer_cstmt.setString(22,addedById);//sysdate
										payer_cstmt.setString(23,p_machine_name1);
										payer_cstmt.setString(24,facilityId);
										payer_cstmt.setString(25,p_machine_name1);
										payer_cstmt.setString(26,facilityId);					
										payer_cstmt.registerOutParameter(27,java.sql.Types.VARCHAR);
										payer_cstmt.registerOutParameter(28,java.sql.Types.VARCHAR);
										payer_cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
										payer_cstmt.execute();						
							
										str_error_level=payer_cstmt.getString(27);
										str_sysmesage_id=payer_cstmt.getString(28);					
										str_error_text=payer_cstmt.getString(29);
										if(str_error_level==null) str_error_level="";
										if(str_sysmesage_id==null) str_sysmesage_id="";
										if(str_error_text==null) str_error_text="";		
								
										//System.out.println("payer_cstmt,str_sysmesage_id in process:"+str_sysmesage_id);
										//System.out.println("payer_cstmt,str_error_text in process:"+str_error_text);
										//System.out.println("payer_cstmt,str_error_text in process:"+str_error_text);
										if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
										{
											insertable=false;
											sb.append("<br>"+str_error_text+"<br> ") ;
										}								
										if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
										{
											insertable=false;
											if((str_error_level.equals("10") && !str_error_text.equals("") ))
											{
												sb.append("<br>"+str_error_text+"<br> ") ;
												//System.out.println("sb mesage in Error is:"+sb);
											}
											else
											{
												if(str_sysmesage_id.indexOf("|") != (-1))
												{
													msgIds=new StringTokenizer(str_sysmesage_id,"|");
													while(msgIds.hasMoreTokens())
													{
														messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
														sb.append((String)messageHashtable.get("message")+"<br>");													
													}
													//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
												}
												else
												{
													messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
													sb.append((String)messageHashtable.get("message"));
													//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
												}
											}
											//cstmt.close();	
											break;
										}					
										/**********insert pkg approvals*****end*******/	
										if(insertable && pkg_dtls_yn.equals("Y"))
										{//
											creditPkgApprovals=new ArrayList();
											if(pkgApprovals!=null && pkgApprovals.size()>0 && pkgApprovals.containsKey(appr_seq_no))
											{/// changed for IN 20964 from key 'credit_auth_ref' to key 'appr_seq_no'
												creditPkgApprovals=(ArrayList)pkgApprovals.get(appr_seq_no);// individual pkg approvals	/ changed for IN 20964 from key 'credit_auth_ref' to key 'appr_seq_no'				
												//System.out.println("creditPkgApprovals="+creditPkgApprovals.toString());	
												if(creditPkgApprovals!=null && creditPkgApprovals.size()>0)
												{//
													for(int k=0;k<creditPkgApprovals.size();k++)
													{//		
														pkgApprvRecord=new ArrayList();
														pkgApprvRecord=(ArrayList)creditPkgApprovals.get(k);
														pkg_seq_no=(String)pkgApprvRecord.get(0);
														pkg_code=(String)pkgApprvRecord.get(1);
														//System.out.println("pkg_seq_no="+pkg_seq_no);
														//System.out.println("pkgCodeSeqNo="+pkgCodeSeqNo.toString());
														if((pkg_seq_no==null || pkg_seq_no.equals("")) && pkgCodeSeqNo!=null && pkgCodeSeqNo.size()>0 && pkgCodeSeqNo.containsKey(pkg_code))
														{
															pkg_seq_no=(String)pkgCodeSeqNo.get(pkg_code);
														}
														//System.out.println(" after pkg_seq_no="+pkg_seq_no);
														pkg_desc=(String)pkgApprvRecord.get(2);
														pkg_apprv_amt=(String)pkgApprvRecord.get(3);	
														String pkg_disc_type = (String)pkgApprvRecord.get(4);	
														String pkg_disc_amt = (String)pkgApprvRecord.get(5);	
														String pkg_disc_reason = (String)pkgApprvRecord.get(6);	
														String pkg_disc_reason_desc = (String)pkgApprvRecord.get(7);	
														System.err.println("Package Discount Details for :"+pkg_seq_no+":"+pkg_code);
														System.err.println("pkg_disc_type:"+pkg_disc_type);
														System.err.println("pkg_disc_amt:"+pkg_disc_amt);
														System.err.println("pkg_disc_reason:"+pkg_disc_reason);
														System.err.println("pkg_disc_reason_desc:"+pkg_disc_reason_desc);
								
														//System.out.println("pkg_seq_no="+pkg_seq_no);								
														//System.out.println("pkg_code="+pkg_code);								
														//System.out.println("pkg_desc="+pkg_desc);								
														//System.out.println("pkg_apprv_amt="+pkg_apprv_amt);	
														//System.out.print("**** insert pkg approv******");		
														/**********insert pkg approvals*****start*******/
										
														//sqlPkgApproval   ="{ call   bladdlapproval.insencpayerpkgapproval(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,	to_date(?,'DD/MM/YYYY'),?,?,sysdate,?,sysdate,?,?,?,?,?,?,?)}";
														//System.out.println("sqlPkgApproval :"+sqlPkgApproval);
														//cstmt = con.prepareCall(sqlPkgApproval);							
														pkg_cstmt.setString(1,facilityId);
														pkg_cstmt.setString(2,P_EPISODE_TYPE);										
														pkg_cstmt.setLong(3,P_EPISODE_ID);
														if(P_VISIT_ID==null || P_VISIT_ID.equals(""))		
															pkg_cstmt.setString(4,null);	
														else
															pkg_cstmt.setInt(4,Integer.parseInt(P_VISIT_ID));		

														//  Commented on  27/12/2013   against  MMS-SCF-0205 
														//pkg_cstmt.setString(5,bookingrefno);				
														pkg_cstmt.setString(5,null);																		
														pkg_cstmt.setString(6,"1");							
														pkg_cstmt.setString(7,P_PATIENT_ID);							
														pkg_cstmt.setLong(8, encounterid);						
														pkg_cstmt.setString(9,blng_grp_code );
														pkg_cstmt.setString(10,ins_cust_group_code);
														pkg_cstmt.setString(11,cust_3);
														if(priority==null || priority.equals(""))	
															pkg_cstmt.setString(12,null);
														else
															pkg_cstmt.setInt(12,Integer.parseInt(priority));
														pkg_cstmt.setString(13,policy_type_code);
														pkg_cstmt.setString(14,policy_no);
														pkg_cstmt.setString(15,policy_eff_frm_date);
														if(pkg_seq_no==null || pkg_seq_no.equals(""))
															pkg_cstmt.setString(16,null);
														else
															pkg_cstmt.setLong(16,Long.parseLong(pkg_seq_no));
														
														try{
															tempPkgCode = pkg_code.substring(0,pkg_code.lastIndexOf("@:"));
														}
														catch(Exception pkgEx){
															tempPkgCode = pkg_code;
														}
														pkg_cstmt.setString(17,tempPkgCode);					
														pkg_cstmt.setString(18,credit_auth_ref.trim());					
														pkg_cstmt.setString(19,credit_auth_date.trim());	
														pkg_cstmt.setString(20,appr_seq_no);	
														if(pkg_apprv_amt==null || pkg_apprv_amt.equals(""))
															pkg_cstmt.setString(21,null);	
														else
															pkg_cstmt.setDouble(21,Double.parseDouble(pkg_apprv_amt));					
	//													pkg_cstmt.setString(20,str_user_id);//sysdate
	//													pkg_cstmt.setString(21,str_user_id);//sysdate
														pkg_cstmt.setString(22,addedById);//sysdate
														pkg_cstmt.setString(23,addedById);//sysdate
														pkg_cstmt.setString(24,p_machine_name1);
														pkg_cstmt.setString(25,facilityId);
														pkg_cstmt.setString(26,p_machine_name1);
														pkg_cstmt.setString(27,facilityId);					
														pkg_cstmt.registerOutParameter(28,java.sql.Types.VARCHAR);
														pkg_cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
														pkg_cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
														pkg_cstmt.execute();						
						
														str_error_level=pkg_cstmt.getString(28);
														str_sysmesage_id=pkg_cstmt.getString(29);					
														str_error_text=pkg_cstmt.getString(30);
						
														if(str_error_level==null) str_error_level="";
														if(str_sysmesage_id==null) str_sysmesage_id="";
														if(str_error_text==null) str_error_text="";		
												
														//System.out.println("pkg_cstmt, str_sysmesage_id in process:"+str_sysmesage_id);
														//System.out.println("pkg_cstmt, str_error_level in process:"+str_error_level);
														//System.out.println("pkg_cstmt, str_error_text in process:"+str_error_text);
			
														if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
														{
															insertable=false;
															sb.append("<br>"+str_error_text+"<br> ") ;
														}								

														if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
														{
															insertable=false;
							
															if((str_error_level.equals("10") && !str_error_text.equals("") ))
															{
																sb.append("<br>"+str_error_text+"<br> ") ;
																//System.out.println("sb mesage in Error is:"+sb);
															}
															else
															{
																if(str_sysmesage_id.indexOf("|") != (-1))
																{
																	msgIds=new StringTokenizer(str_sysmesage_id,"|");
																	while(msgIds.hasMoreTokens())
																	{
																		messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");

																		sb.append((String)messageHashtable.get("message")+"<br>");
																	}
																	//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
																}
																else
																{
																	messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
																	sb.append((String)messageHashtable.get("message"));
																	//System.out.println("sb mesage in sys_message is:"+sb);
																}
															}
															break;
														}	
														else
														{
															insertable=true;
															// Inserting Package Discount Details to bl_package_adhoc_discount
															try
															{
																String sqlInsert			="insert into bl_package_adhoc_discount(OPERATING_FACILITY_ID,PACKAGE_CODE,PACKAGE_SEQ_NO,PATIENT_ID,CUST_GROUP_CODE,CUST_CODE,DISCOUNT,DISCOUNT_TYPE,ADDED_BY_ID,ADDED_DATE,MODIFIED_BY_ID,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,DISC_REASON_DESC,DISC_REASON_CODE) values(?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?)";
																System.err.println(facilityId+"/"+pkg_code+"/"+pkg_seq_no+"/"+P_PATIENT_ID+"/"+ins_cust_group_code+"/"+cust_3+"/"+pkg_disc_amt+"/"+pkg_disc_type+"/"+addedById+"/"+p_machine_name1+"/"+pkg_disc_reason+"/"+pkg_disc_reason_desc);
																PreparedStatement pstmt	= con.prepareStatement(sqlInsert);
																pstmt.setString(1,facilityId);
																try{
																	tempPkgCode = pkg_code.substring(0,pkg_code.lastIndexOf("@:"));
																}
																catch(Exception pkgEx){
																	tempPkgCode = pkg_code;
																}
																pstmt.setString(2,tempPkgCode);
																pstmt.setInt(3,Integer.parseInt(pkg_seq_no));
																pstmt.setString(4,P_PATIENT_ID);
																pstmt.setString(5,ins_cust_group_code);
																pstmt.setString(6,cust_3);
																pstmt.setDouble(7,Double.parseDouble(pkg_disc_amt));
																pstmt.setString(8,pkg_disc_type);										
																pstmt.setString(9,addedById);
																pstmt.setString(10,addedById);
																pstmt.setString(11,p_machine_name1);
																pstmt.setString(12,facilityId);
																pstmt.setString(13,p_machine_name1);
																pstmt.setString(14,facilityId);
																pstmt.setString(15,pkg_disc_reason_desc);//DESC
																pstmt.setString(16,pkg_disc_reason);
																int insertResult = pstmt.executeUpdate();
																System.err.println("insertResult:"+insertResult);
																if(insertResult !=-2 && insertResult < 0) 
																{
																	sb.append("<br>"+"Insert Failed on BL_PACKAGE_ADHOC_DISCOUNT"+"<br> ") ;				
																	insertable = false;
																	con.rollback();
																	break;
																}
																else	
																{
																	insertable=true;
																}	
																if(pstmt!=null) pstmt.close();
															}
															catch(Exception e)
															{
																insertable = false;
																System.err.println("Insert Failed on BL_PACKAGE_ADHOC_DISCOUNT"+e);
																e.printStackTrace();
																sb.append("<br>"+"Insert Failed on BL_PACKAGE_ADHOC_DISCOUNT"+"<br> ") ;
															}
														}
														/**********insert pkg approvals*****end*******/
													}//
												}//
											}//
										}//			
									}// if(credit_apprd_amt !=null && !credit_apprd_amt.equals("")) chk				
								}//
							}//					
							else
							{
								insRec_YN="N";
							}
						}//	
					}
					if(!insertable)
					{
						break;
					}
				}//
				if(pkg_cstmt!=null)		
					pkg_cstmt.close();	
			}
			catch(Exception e)
			{
				insertable=false;
				System.out.println("Exception while inserting package approvals="+e);
				//out.println("Exception while inserting package approvals="+);
				e.printStackTrace();
			}
		}

//					if(insertable && !insRec_YN.equals("Y"))
		if(insertable)
		{
			Set<String> PkgDtlsSet=(Set<String>)patPackApprvDtls.keySet();
			String mapKey = "";
			ArrayList payer=new ArrayList();
			System.err.println("PkgDtlsSet in others="+PkgDtlsSet.toString());
			Iterator<String> pkgIt=PkgDtlsSet.iterator();
			System.err.println("Calling pkgIt loop in others");
			while(pkgIt.hasNext())
			{
				if(insertable)
				{
					mapKey=pkgIt.next();	
					System.err.println("mapKey in others:"+mapKey);
					payer=(ArrayList)patPackApprvDtls.get(mapKey);	
					System.err.println("payer in others:"+payer);
					if(payer!=null && payer.size()>0)
					{
						hdrDtls=	(HashMap)payer.get(0);
						authDtls=	(HashMap)payer.get(1);
						pkgApprovals=	(HashMap)payer.get(2);
						System.err.println("hdrDtls in Others:"+hdrDtls);
						System.err.println("authDtls in Others:"+authDtls);
						System.err.println("pkgApprovals in Others:"+pkgApprovals);
						/*************get hdr dtls*********start************/
						
						Set<String> authDtlsSet=(Set<String>)pkgApprovals.keySet();
						Iterator<String> authIt=authDtlsSet.iterator();

						ArrayList creditPkgApprovals=new ArrayList();
//									Set<String> authDtlsSet=(Set<String>)pkgApprovals.keySet();
//									Iterator<String> authIt=authDtlsSet.iterator();

						if((pkgApprovals!=null && pkgApprovals.size()>0) && (authDtls == null || authDtls.size() == 0))
						{
							System.err.println("pkgApprovals:"+pkgApprovals);
							System.err.println("pkgApprovals.size():"+pkgApprovals.size());

							while(authIt.hasNext())
							{
								String authKey=(String)authIt.next();					
								creditPkgApprovals = (ArrayList)pkgApprovals.get(authKey);

								System.err.println("creditPkgApprovals:"+creditPkgApprovals);
								System.err.println("creditPkgApprovals.size():"+creditPkgApprovals.size());
								if(creditPkgApprovals!=null && creditPkgApprovals.size()>0)
								{
									for(int k=0;k<creditPkgApprovals.size();k++)
									{		
										ArrayList pkgApprvRecord=new ArrayList();
										pkgApprvRecord=(ArrayList)creditPkgApprovals.get(k);
										String pkg_seq_no=(String)pkgApprvRecord.get(0);
										String pkg_code=(String)pkgApprvRecord.get(1);
										if((pkg_seq_no==null || pkg_seq_no.equals("")) && pkgCodeSeqNo!=null && pkgCodeSeqNo.size()>0 && pkgCodeSeqNo.containsKey(pkg_code))
										{
											pkg_seq_no=(String)pkgCodeSeqNo.get(pkg_code);
										}
										String pkg_desc=(String)pkgApprvRecord.get(2);
										String pkg_apprv_amt=(String)pkgApprvRecord.get(3);	
										String pkg_disc_type = (String)pkgApprvRecord.get(4);	
										String pkg_disc_amt = (String)pkgApprvRecord.get(5);	
										String pkg_disc_reason = (String)pkgApprvRecord.get(6);	
										String pkg_disc_reason_desc = (String)pkgApprvRecord.get(7);	
										System.err.println("Package Discount Details for :"+pkg_seq_no+":"+pkg_code);
										System.err.println("pkg_disc_type:"+pkg_disc_type);
										System.err.println("pkg_disc_amt:"+pkg_disc_amt);
										System.err.println("pkg_disc_reason:"+pkg_disc_reason);
										System.err.println("pkg_disc_reason_desc:"+pkg_disc_reason_desc);
										insertable=true;
										if(pkg_seq_no == null || pkg_seq_no.equals(""))
										{
											messageHashtable=MessageManager.getMessage(locale,"BL8558","BL");
											sb.append((String)messageHashtable.get("message"));
											insertable=false;
											con.rollback();
											break;
										}
										if(insertable)
										{
										// Inserting Package Discount Details to bl_package_adhoc_discount
											try
											{
												String sqlInsert			="insert into bl_package_adhoc_discount(OPERATING_FACILITY_ID,PACKAGE_CODE,PACKAGE_SEQ_NO,PATIENT_ID,CUST_GROUP_CODE,CUST_CODE,DISCOUNT,DISCOUNT_TYPE,ADDED_BY_ID,ADDED_DATE,MODIFIED_BY_ID,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,DISC_REASON_DESC,DISC_REASON_CODE) values(?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?)";
												System.err.println(facilityId+"/"+pkg_code+"/"+pkg_seq_no+"/"+P_PATIENT_ID+"/"+ins_cust_group_code+"/"+cust_3+"/"+pkg_disc_amt+"/"+pkg_disc_type+"/"+addedById+"/"+p_machine_name1+"/"+pkg_disc_reason+"/"+pkg_disc_reason_desc);
												PreparedStatement pstmt	= con.prepareStatement(sqlInsert);
												pstmt.setString(1,facilityId);
												try{
													tempPkgCode = pkg_code.substring(0,pkg_code.lastIndexOf("@:"));
												}
												catch(Exception pkgEx){
													tempPkgCode = pkg_code;
												}
												pstmt.setString(2,tempPkgCode);
												pstmt.setInt(3,Integer.parseInt(pkg_seq_no));
												pstmt.setString(4,P_PATIENT_ID);
												pstmt.setString(5,ins_cust_group_code);
												pstmt.setString(6,cust_3);
												pstmt.setDouble(7,Double.parseDouble(pkg_disc_amt));
												pstmt.setString(8,pkg_disc_type);										
												pstmt.setString(9,addedById);
												pstmt.setString(10,addedById);
												pstmt.setString(11,p_machine_name1);
												pstmt.setString(12,facilityId);
												pstmt.setString(13,p_machine_name1);
												pstmt.setString(14,facilityId);
												pstmt.setString(15,pkg_disc_reason_desc);//DESC
												pstmt.setString(16,pkg_disc_reason);
												int insertResult = pstmt.executeUpdate();
												System.err.println("insertResult:"+insertResult);
												if(insertResult !=-2 && insertResult < 0) 
												{
													sb.append("<br>"+"Insert Failed on BL_PACKAGE_ADHOC_DISCOUNT"+"<br> ") ;				
													insertable = false;
													con.rollback();
													break;
												}
												else	
												{
													insertable=true;
												}	
												if(pstmt!=null) pstmt.close();
											}
											catch(Exception e)
											{
												insertable = false;
												System.err.println("Insert Failed on BL_PACKAGE_ADHOC_DISCOUNT"+e);
												e.printStackTrace();
												sb.append("<br>"+"Insert Failed on BL_PACKAGE_ADHOC_DISCOUNT"+"<br> ") ;
											}
										}
			/**********insert pkg approvals*****end*******/	
									}//
								}//
							}
						}//
					}
				}
			}
		}
	//System.out.println("insertable="+insertable);
	/************insert package approvals**************end**********/
	}
		
		
		
		
		
		
/****************added for package billing************end**********/
	try
	{
		if (insertable)
		{
			//System.out.println("Executing BL_IP_INTERFACE.PROC_MAIN");

			String sql_proc_main = "{call BL_IP_INTERFACE.PROC_MAIN('V','ADMISSION','Y','"+strBillingInterfaced+"','"+(String) hashtableBill.get("facilityId")+"','"+moduleid+"','"+trntype+"','"+P_PATIENT_ID+"','"+P_EPISODE_TYPE+"',"+P_EPISODE_ID+","+encounterid+","+intSrlno+",'"+admissiontype+"','"+strNull+"','"+P_BLNG_GRP_ID+"','"+str_cust_group_code+"','"+str_cust_code+"','"+str_non_ins_blng_grp+"','"+str_non_ins_cust_group_code+"','"+str_non_ins_cust_code+"','"+str_slmt_ind+"','"+nursingunit+"','"+bedclass+"','"+bedtype+"','"+bookingrefno+"','"+addedById+"','"+modifiedAtWorkstation+"','"+exp_no_of_day_stay+"','"+locale+"',?,?,?,?,?,?,?,'"+chiefcomplaint+"')}";

			//System.out.println("The Sql PROC_MAIN :"+sql_proc_main);
	
			cstmt1 = con.prepareCall(sql_proc_main);
/*
			cstmt1.setString(1, "V"     );                                 
			cstmt1.setString(2,  "ADMISSION"              );           
			cstmt1.setString(3, "Y"                   );//bl_inst          
			cstmt1.setString(4, strBillingInterfaced           );          
			cstmt1.setString(5, facilityId                   );            
			//cstmt1.setString(6, "IP"                         );            
			cstmt1.setString(6, moduleid );            
			cstmt1.setString(7, trntype );                                 
			cstmt1.setString(8, P_PATIENT_ID                 );            
			cstmt1.setString(9, P_EPISODE_TYPE               );            
			cstmt1.setLong(10, P_EPISODE_ID                 );             
			cstmt1.setLong(11, encounterid                  );             
			cstmt1.setInt(12,intSrlno);                                    
			cstmt1.setString(13,admissiontype              );              
			cstmt1.setString(14,strNull);                                  
			cstmt1.setString(15,P_BLNG_GRP_ID            );                
//					cstmt1.setString(16,P_CUST_CODE                 );             			
			cstmt1.setString(16,str_cust_code                 );             			
//					cstmt1.setString(17,P_NON_INS_BLNG_GRP_ID       );             			
			cstmt1.setString(17,str_non_ins_blng_grp       );             			
//					cstmt1.setString(18,P_NON_INS_CUST_CODE         );             			
			cstmt1.setString(18,str_non_ins_cust_code         );             			
//					cstmt1.setString(19,P_SETTLEMENT_IND            );             			
			cstmt1.setString(19,str_slmt_ind            );             			
			cstmt1.setString(20,nursingunit                 );             			
			cstmt1.setString(21,bedclass                    );             			
			cstmt1.setString(22,bedtype                      );   //bedno           			
			cstmt1.setString(23,bookingrefno               );              			
			cstmt1.setString(24,addedById );                               			
			cstmt1.setString(25,modifiedAtWorkstation       );             			
			cstmt1.setString(26,exp_no_of_day_stay          );             			
			cstmt1.setString(27,locale);             			
*/
			cstmt1.registerOutParameter(1,java.sql.Types.INTEGER);        			
			cstmt1.registerOutParameter(2,java.sql.Types.INTEGER);        			
			cstmt1.registerOutParameter(3,java.sql.Types.INTEGER);        			
			cstmt1.registerOutParameter(4,java.sql.Types.VARCHAR);        
			cstmt1.registerOutParameter(5,java.sql.Types.VARCHAR);
			cstmt1.registerOutParameter(6,java.sql.Types.VARCHAR);
			cstmt1.registerOutParameter(7,java.sql.Types.VARCHAR);	

			cstmt1.execute();

			P_DLY_CHARGE = cstmt1.getInt(1);
			P_DEP_AMT =cstmt1.getInt(2);
			P_TOT_DEP_AMT=cstmt1.getInt(3);

			err_level=cstmt1.getString(4);
			if(err_level==null) err_level="";

			sys_message_id=cstmt1.getString(5);
			if(sys_message_id==null) sys_message_id="";

			err_text = cstmt1.getString(7);
			if(err_text==null) err_text="";

			strMessage = cstmt1.getString(6);
			if(strMessage==null) strMessage="";

			/*System.out.println("P_DLY_CHARGE:"+P_DLY_CHARGE);
			System.out.println("P_DEP_AMT:"+P_DEP_AMT);
			System.out.println("P_TOT_DEP_AMT:"+P_TOT_DEP_AMT);
			System.out.println("strMessage:"+strMessage);
			System.out.println("err_level:"+err_level);
			System.out.println("sys_message_id:"+sys_message_id);
			System.out.println("err_text:"+err_text);*/

			deposit_amount = String.valueOf(P_DEP_AMT);
			

			if(  (!sys_message_id.equals(""))  || (err_level.equals("10") && !err_text.equals("") ) )
			{
				insertable=false;

				if((err_level.equals("10") && !err_text.equals("") ))
				{
					sb.append("<br>"+err_text+"<br> ") ;
					//System.out.println("sb mesage is:"+sb);
				}
				else
				{
					messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
					sb.append((String)messageHashtable.get("message"));
					//System.out.println("sb mesage is:"+sb);
				}
				statement.close();
			}
			else
			{
				insertable=true;
			}
		
			sys_message_id="";
			err_level="";
			err_text="";

			strMessage = "<b>" +strMessage+ "</b>";

			cstmt1.close();
		}
	}
	catch( Exception ee)
	{	
		insertable = false;
		sb.append ("BLInterface "+ee);
	}	
	}
	

	
	if (insertable)
	{
/*	
		try
		{
			String mode = "";

			if(!(P_POLICY_TYPE_CODE == null || P_POLICY_TYPE_CODE.equals("")) )
			{
				Statement deductStmt = con.createStatement();
				ResultSet deductRs = null;
				String deductSql = "SELECT NVL(INS_DEDUCT_AMT ,0) INS_DEDUCT_AMT "+
									" FROM BL_INS_DEDUCTIBLE_HDR WHERE "+
									" POLICY_TYPE_CODE = '"+P_POLICY_TYPE_CODE+"' AND CUST_CODE = '"+P_CUST_CODE+"' AND "+
									" NVL(ILLN_VISIT_IND, 'N') = 'I'";
				try
				{
					deductRs =deductStmt.executeQuery(deductSql);
					if(deductRs.next()) 
					{
						if(deductRs.getInt("INS_DEDUCT_AMT")>0) 
						INS_DEDUCT_AMT = deductRs.getInt("INS_DEDUCT_AMT") ;
						else INS_DEDUCT_AMT=0;
					}
				}
				catch (Exception pat)
				{
					sb.append(pat.toString());
				}
				finally 
				{
					if(deductStmt!=null) deductStmt.close();
					if(deductRs!=null) deductRs.close();
				}
			// End of billing interface == true if
				if(insTrackDtlsExists.equals("N")) mode="I";
				if(insTrackDtlsExists.equals("Y")) mode="U";

				cstmt2 = con.prepareCall("{call INS_UPD_BL_INS_TRACK_DTLS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

				cstmt2.setString(1, mode              );
				cstmt2.setString(2, P_PATIENT_ID        );
				cstmt2.setString(3, P_EPISODE_TYPE      );
				cstmt2.setLong(4,	P_EPISODE_ID        );
				cstmt2.setInt(5, 0          );
				cstmt2.setString(6, P_BLNG_GRP_ID       );
				cstmt2.setString(7, P_CUST_CODE         );
				cstmt2.setString(8, P_POLICY_TYPE_CODE  );
				cstmt2.setString(9, P_POLICY_NUMBER     );
				cstmt2.setDate(10,P_POLICY_EXPIRY_DATE);

				if(P_APPROVED_DAYS==0)
				{	
					cstmt2.setNull(11,java.sql.Types.VARCHAR);
				}
				else
				{
					cstmt2.setInt(11,P_APPROVED_DAYS);
				}

				if(P_APPROVED_AMT==0)
				{
					cstmt2.setNull(12,java.sql.Types.VARCHAR);
				}
				else	
				{
				cstmt2.setInt(12,P_APPROVED_AMT);
				}

				cstmt2.setDate(13,	added_date     );
				cstmt2.setString(14,P_CREDIT_AUTH_REF   );
				cstmt2.setDate(15,P_CREDIT_AUTH_DATE  );
				cstmt2.setString(16,P_ADM_DOCTOR        );
				cstmt2.setString(17,addedById);
				cstmt2.setString(18, facilityId);
				cstmt2.setString(19, addedAtWorkstation);

				cstmt2.registerOutParameter(20,java.sql.Types.VARCHAR);
	
				cstmt2.execute();

				cs3 = cstmt2.getString(20);
				if (cs3 != null)
				{
					if (!(cs3.equalsIgnoreCase("0")))
					{
						insertable =  false;
					}	
				}
			} // End of policy if
		} // End of policy try
		catch(Exception k)
		{
			insertable =  false;
			sb.append("Procedure-INS_UPD_BL_INS_TRACK_DTLS:"+k.toString());
		}

		try
		{
			if(!(P_POLICY_TYPE_CODE == null || P_POLICY_TYPE_CODE.equals("")) )
			{
				cstmt3 = con.prepareCall("{call INS_UPD_BL_INS_POLICY_ADDL(?,?,?,?,?,?,?,?,?,?,?)}");

				cstmt3.setString(1, "I"    );
				cstmt3.setString(2, P_PATIENT_ID    );
				cstmt3.setString(3, P_EPISODE_TYPE    );
				cstmt3.setLong(4,	P_EPISODE_ID   );
				cstmt3.setInt(5, 0    );
				cstmt3.setString(6, P_POLICY_TYPE_CODE   );
				cstmt3.setString(7, P_CUST_CODE      );
				cstmt3.setString(8, addedById);
				cstmt3.setString(9, facilityId);
				cstmt3.setString(10, addedAtWorkstation);
				cstmt3.registerOutParameter(11,java.sql.Types.VARCHAR);

				cstmt3.execute();
				cs4 = cstmt3.getString(11);
			}
		}
		catch(Exception l)
		{
			insertable =  false;
			sb.append("Procedure-INS_UPD_BL_INS_POLICY_ADDL:"+l.toString());
		}

		try
		{
			cstmt4 = con.prepareCall("{call INS_UPD_BL_INS_PREAPP(?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt4.setString(1, "I"    );
			cstmt4.setString(2, P_PATIENT_ID    );
			cstmt4.setString(3, P_EPISODE_TYPE    );
			cstmt4.setLong(4, P_EPISODE_ID   );
			cstmt4.setInt(5, 0    );
			cstmt4.setString(6, P_POLICY_TYPE_CODE   );
			cstmt4.setString(7, P_CUST_CODE      );
			cstmt4.setString(8, addedById);
			cstmt4.setString(9, facilityId);
			cstmt4.setString(10, addedAtWorkstation);
			cstmt4.registerOutParameter(11,java.sql.Types.VARCHAR);
			cstmt4.execute();

			String cs5 = cstmt4.getString(11);
		}
		catch(Exception z)
		{
			insertable =  false;
			sb.append("Procedure-INS_UPD_BL_INS_PREAPP:"+z.toString());
		}
*/
	}
	}
	catch (Exception exceptionSql)
	{

	}
	
		//Hashtable resultBL =  new Hashtable();
	if (strMessage == null)
	{
		strMessage = " ";
	}
	resultBL.put("status",new Boolean(insertable));
	resultBL.put("error",sb.toString());
	resultBL.put("message",strMessage);
	resultBL.put("deposit_amount",deposit_amount);
	resultBL.put("admn_dep_coll_reqd_yn",admn_dep_coll_reqd_yn);
	resultBL.put("package_enabled_yn",package_enabled_yn);
	return(resultBL);
	}
	
	private StringBuffer appendMultipleErrors(HashMap returnMap,StringBuffer sb,String locale){
		String mapKey = "";
		String mapValue = "";
		Hashtable messageHashtable=new Hashtable();
		for (Iterator iterator = returnMap.keySet().iterator(); iterator.hasNext();) {
			String type = (String) iterator.next();
			if(!("status".equals(type))){
				mapKey = (String) returnMap.get(type);
				if(mapKey != null){							
				messageHashtable=MessageManager.getMessage(locale,mapKey,"BL");
				mapValue=(messageHashtable.get("message")==null)?"":(String)messageHashtable.get("message");
				if (!mapValue.equals("")) {
					sb.append(mapValue + "<br/>");
				} else {
					sb.append(type + " Internal Error <br/>");
				}
				}
			}
		}	
		return sb;	
	}
	
	private static Timestamp getTimeStamp(String dateStr)
		{
			//String startDate="01/02/2013 11:30:25.0";
			Timestamp timestamp=null;
			try{
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
				java.util.Date parsedDate = dateFormat.parse(dateStr);
				timestamp = new java.sql.Timestamp(parsedDate.getTime());
				System.out.println("BLOPVisit.java::::responseDate time value......."+timestamp);
				//timestamp.
			}catch(Exception e){//this generic but you can control another types of exception
			 e.printStackTrace(); 
			}
			return timestamp;
		}
}