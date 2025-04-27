/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package blopin;
import java.io.* ;
import java.sql.* ;

import javax.rmi.*;
import java.util.*;
import java.sql.* ;
import java.net.*;


import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;


public class BLOPCheckOut
{
	public java.util.Hashtable billPatientService( Properties p,Connection con, Hashtable tabdata)
	{
		PreparedStatement stmt =null;

		Statement stmt3 =null;
		CallableStatement statement=null;
		ResultSet rs  =null;
		


//Unused Var's
/*
		String err_out="";
		String strVisitMessage = "";
		String strBillGenYN = "";
		String strBillMessage = "";
*/
		String strFinalMessage ="";
		String strVisitMessage = "";

	/* Newly added variables */

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
		String str_upd_patient_fin_dtls_yn="";
		String str_user_id="";
		String str_fin_auth_user_id="";
		String str_calling_function_id="";

		String str_cust_group_code = "";
		String str_cust_code = "";
		String str_doc_ref= "";
		String str_doc_start_date="";
		String str_doc_end_date="";

//		String str_acct_seq_eff_from_date="";
//		String str_acct_seq_eff_to_date="";

		double annual_income = 0.0;
		double family_asset = 0.0;
		int no_of_dependants = 0;
//		int ins_credit_approval_days=0;
//		double ins_credit_approval_amount=0.0;
//		double ins_adj_perc_amt_value=0.0;

		String strNewHospChrgCreate="";
		String strNewMedChrgCreate="";
		String strNewAddlChrgCreate="";

		String hosp_serv_panel_ind="";
		String hosp_serv_panel_code="";
		String hosp_serv_panel_str="";
		String hosp_serv_panel_qty="1.0";
		String hosp_serv_charge_amt="";

		String med_serv_panel_ind="";
		String med_serv_panel_code="";
		String med_serv_panel_str="";
		String med_serv_panel_qty="1.0";
		String med_serv_charge_amt="";

		String addl_serv_panel_ind="";
		String addl_serv_panel_code="";
		String addl_serv_panel_str="";
		String addl_serv_panel_qty="1.0";
		String addl_serv_charge_amt="";

		int acc_seq_no=0;
		String strAccSeqNo="";

		String exempt_date="";
		String hosp_charge_YN="";
		String med_charge_YN="";
		String addl_charge_YN="";

		double hosp_chrg_amt=0.0;
		double hosp_chrg_pat_amt=0.0;
		double med_chrg_amt=0.0;
		double med_chrg_pat_amt=0.0;
		double addl_chrg_amt=0.0;
		double addl_chrg_pat_amt=0.0;
		double total_chrg_amt=0.0;
		double total_pat_chrg_amt=0.0;
/*** CRF-362 SCRUM related changes starts ****/
		double bed_chrg_pat_amt=0.0;
		double bed_chrg_pat_pay=0.0;
/*** CRF-362 SCRUM related changes ends ****/
		
		String str_hosp_chrg_amt="";
		String str_hosp_chrg_pat_amt="";
		String str_med_chrg_amt="";
		String str_med_chrg_pat_amt="";
		String str_addl_chrg_amt="";
		String str_addl_chrg_pat_amt="";
		String str_total_chrg_amt="";
		String str_total_pat_chrg_amt="";
/*** CRF-362 SCRUM related changes starts ****/
		String str_bed_charge_net_amt="";
		String str_bed_charge_patient_pay="";
/*** CRF-362 SCRUM related changes ends ****/

		String total_bill_text="";
		String bill_gen_yn="";
		String bill_doc_type="";
		String bill_doc_number="";

		String str_bill_later_YN="N";
		String str_bill_gen_later="N";
		String str_total_bill_amt="";

		String str_bill_prt_format_YN = "N";
		String str_bill_prt_format_vals = "";
		String pgm_id ="";
		String session_id ="";
		String pgm_date ="";
		String mpi_id_rep = "";

		String err_level = "";
		String sys_message_id = "";
		String err_text = "";

		String module_id="";
		String facility_id="";
		String episode_type="";
		String episode_id="";
		String visit_id="";
		String encounter_id="";
		String function_id="";
		String visit_type_code="";
		String clinic_code="";
		String practitioner_id="";
		String charge_basis_by_physician_yn = "";
		String locale="";
		String added_by_id="";
		String added_at_ws_no="";
		String patient_id="";

		String strOldClinicCode = "";
		String strOldVstTypeCode = "";
		String strOldPractId= "";
		String strOldChargeByPractYN = "";

		String call_revise_proc_YN = "N";
		String call_charge_proc_YN = "N";

/*** CRF-362 SCRUM related changes starts ****/
		String ae_bed_charge_appl_yn="";
		String ae_treatment_area_code="";
/*** CRF-362 SCRUM related changes ends ****/
		
/**************************************************************/

//		String encounterid="";
		boolean insertable = true;
		StringBuffer sb = new StringBuffer( " " ) ;
		java.util.Hashtable results = new java.util.Hashtable() ;
		Hashtable messageHashtable=new Hashtable();

//		boolean result=false;

		String strBLInterfaceYN = "N";
		String strBillInterfaceQry ="";

		String strNull = "";	

		int noofdecimal=2;
		CurrencyFormat cf1 = new CurrencyFormat();
		
		try
		{		
			String no_of_decimal="select nvl(no_of_decimal,2) from  sm_acc_entity_param";
			stmt3 = con.createStatement();
			rs = stmt3.executeQuery(no_of_decimal) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					noofdecimal  =  rs.getInt(1);	
				}
			}
			stmt3.close();
			if(rs!=null) rs.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in No of Decimal Query="+e.toString());
		}

		try
		{		
			String bill_gen_later_YN_qry="select nvl(ADHOC_DISCOUNT_ALLOWED_YN,'N') from  bl_parameters where operating_facility_id='"+(String) tabdata.get("facility_id")+"'";
			stmt3 = con.createStatement();
			rs = stmt3.executeQuery(bill_gen_later_YN_qry) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					str_bill_later_YN  =  rs.getString(1);	
				}
			}
			if(str_bill_later_YN == null) str_bill_later_YN="N";
//			System.out.println("str_bill_later_YN:"+str_bill_later_YN);
			stmt3.close();
			if(rs!=null) rs.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in No of bill_gen_later_YN_qry Query="+e.toString());
		}

		try
		{
			strBillInterfaceQry = " SELECT nvl(BL_INTERFACED_YN,'N') from OP_PARAM where "+
				"	OPERATING_FACILITY_ID=?";
			
			stmt = con.prepareStatement( strBillInterfaceQry );
			stmt.setString(1,((String)tabdata.get("facility_id")).trim());
			rs = stmt.executeQuery();

			if (rs.next())
			{
				strBLInterfaceYN = rs.getString(1);
			}
			if ( (strBLInterfaceYN==null ) || (strBLInterfaceYN.equals("")) )
			{
				strBLInterfaceYN = "N";
			}
			if(rs != null) rs.close();
			stmt.close();
		}
		catch(Exception exceptionBL)
		{
			strBLInterfaceYN ="Y";
		}	
	
		if (strBLInterfaceYN.equals("Y"))
		{
			try
			{
				HashMap billing_data=(HashMap)tabdata.get("fin_dtls");
				if(billing_data!=null)
				{
					locale			= (String)billing_data.get("locale");
				}
				if(locale==null || locale.equals("")) locale="en";

				java.util.Locale loc = new java.util.Locale(locale);

				java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
				java.util.ResourceBundle bl_messages = java.util.ResourceBundle.getBundle("eBL.resources.Messages",loc);
				java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);

				String hosp_chrg_leg = bl_labels.getString("eBL.HOSP_CHRG.label");
				String prof_chrg_leg = bl_labels.getString("eBL.PROF_CHRG.label");
				String addl_chrg_leg = bl_labels.getString("eBL.ADDL_CHARGE.label");
				String vst_chrg_exmpt_leg = bl_labels.getString("eBL.VISIT_CHRG_EXEMPT_UPTO.label");
				String bill_gen_yn_leg = bl_labels.getString("eBL.PLS_NOTE_DOWN_THE_BILL.label");
				String bill_gen_yn_leg1 = bl_labels.getString("eBL.FOR_THE_VISIT_CHRG.label");
				String bill_gen_yn_leg2 = bl_labels.getString("eBL.FOR_THE_CHRG.label");
				String patient_payable_leg = common_labels.getString("Common.PatientPayable.label");
				String bill_gen_yn_message = (String) bl_messages.getString("BL7335");

				module_id=(String)tabdata.get("module_id");
				if(module_id==null || module_id.equals("")) module_id="";

				facility_id=(String)tabdata.get("facility_id");
				if(facility_id==null || facility_id.equals("")) facility_id="";

				episode_type=(String)tabdata.get("episode_type");
				if(episode_type==null || episode_type.equals("")) episode_type="";

				episode_id=(String)tabdata.get("episode_id");
				if(episode_id==null || episode_id.equals("")) episode_id="";

				visit_id=(String)tabdata.get("visit_id");
				if(visit_id==null || visit_id.equals("")) visit_id="";

				encounter_id=(String)tabdata.get("p_encounter_id");
				if(encounter_id==null || encounter_id.equals("")) encounter_id="";

				function_id=(String)tabdata.get("function_id");
				if(function_id==null || function_id.equals("")) function_id="";

				visit_type_code=(String)tabdata.get("visit_type_code");
				if(visit_type_code==null || visit_type_code.equals("")) visit_type_code="";

				clinic_code=(String)tabdata.get("p_locn_code");
				if(clinic_code==null || clinic_code.equals("")) clinic_code="";

				practitioner_id=(String)tabdata.get("p_practitioner_id");
				if(practitioner_id==null || practitioner_id.equals("")) practitioner_id="";

				patient_id=(String)tabdata.get("patient_id");
				if(patient_id==null || patient_id.equals("")) patient_id="";

				added_by_id=(String)tabdata.get("login_user");
				if(added_by_id==null || added_by_id.equals("")) added_by_id="";

				added_at_ws_no=(String)tabdata.get("addedAtWorkstation");
				if(added_at_ws_no==null || added_at_ws_no.equals("")) added_at_ws_no="";

				ae_treatment_area_code=(String)tabdata.get("ae_treatment_area_code");
				if(ae_treatment_area_code==null || ae_treatment_area_code.equals("")) ae_treatment_area_code="";



//				System.out.println("billng_data in OP bean is:"+billing_data);
			
				if(billing_data!=null)
				{
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
					
					str_ins_credit_approval_days=(String)billing_data.get("ins_credit_approval_days"); //integer
					if(str_ins_credit_approval_days==null) str_ins_credit_approval_days="";
					str_ins_credit_approval_amount=(String)billing_data.get("ins_credit_approval_amount"); //double
					if(str_ins_credit_approval_amount==null) str_ins_credit_approval_amount="";
					str_ins_policy_eff_from_date=(String)billing_data.get("ins_policy_eff_from_date");
					if(str_ins_policy_eff_from_date==null) str_ins_policy_eff_from_date="";
					str_ins_policy_eff_to_date=(String)billing_data.get("ins_policy_eff_to_date");
					if(str_ins_policy_eff_to_date==null) str_ins_policy_eff_to_date="";
					str_ins_adj_rule_ind=(String)billing_data.get("ins_adj_rule_ind");
					if(str_ins_adj_rule_ind==null) str_ins_adj_rule_ind="";
					str_ins_adj_perc_amt_ind=(String)billing_data.get("ins_adj_perc_amt_ind");
					if(str_ins_adj_perc_amt_ind==null) str_ins_adj_perc_amt_ind="";
					
					str_ins_adj_perc_amt_value=(String)billing_data.get("ins_adj_perc_amt_value"); //double
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
					
					str_annual_income=(String)billing_data.get("annual_income"); //doble
					if(str_annual_income==null || str_annual_income.equals("")) str_annual_income="0";
					
					str_family_asset=(String)billing_data.get("family_asset"); //double
					if(str_family_asset==null || str_family_asset.equals("")) str_family_asset="0";
					
					str_no_of_dependants=(String)billing_data.get("no_of_dependants"); //int
					if(str_no_of_dependants==null || str_no_of_dependants.equals("")) str_no_of_dependants="0";
					
					str_resp_for_payment=(String)billing_data.get("resp_for_payment"); 
					if(str_resp_for_payment==null) str_resp_for_payment="";
					str_pat_reln_with_resp_person=(String)billing_data.get("pat_reln_with_resp_person");
					if(str_pat_reln_with_resp_person==null) str_pat_reln_with_resp_person="";
					str_fin_remarks=(String)billing_data.get("fin_remarks");
					if(str_fin_remarks==null) str_fin_remarks="";
					str_gl_holder_name=(String)billing_data.get("gl_holder_name");
					if(str_gl_holder_name==null) str_gl_holder_name="";
					str_pat_reln_with_gl_holder=(String)billing_data.get("pat_reln_with_gl_holder");
					if(str_pat_reln_with_gl_holder==null) str_pat_reln_with_gl_holder="";
					str_upd_patient_fin_dtls_yn=(String)billing_data.get("upd_patient_fin_dtls_yn");
					if(str_upd_patient_fin_dtls_yn==null) str_upd_patient_fin_dtls_yn="";
					str_user_id=(String)billing_data.get("user_id");
					if(str_user_id==null) str_user_id="";
					str_fin_auth_user_id=(String)billing_data.get("fin_auth_user_id");
					if(str_fin_auth_user_id==null) str_fin_auth_user_id="";
					str_calling_function_id=(String)billing_data.get("calling_function_id");
					if(str_calling_function_id==null) str_calling_function_id="";

					HashMap hosp_dtls=(HashMap)billing_data.get("hosp_dtls");

					if(hosp_dtls!=null)
					{
						hosp_serv_panel_ind=(String)hosp_dtls.get("hosp_serv_panel_ind");
						hosp_serv_panel_code=(String)hosp_dtls.get("hosp_serv_panel_code");
						hosp_serv_panel_str=(String)hosp_dtls.get("hosp_serv_panel_str");
						hosp_serv_panel_qty=(String)hosp_dtls.get("hosp_serv_panel_qty");
						hosp_serv_charge_amt=(String)hosp_dtls.get("hosp_serv_chrg_amt");
					}

					HashMap prof_dtls=(HashMap)billing_data.get("prof_dtls");

					if(prof_dtls!=null)
					{
						med_serv_panel_ind=(String)prof_dtls.get("prof_serv_panel_ind");
						med_serv_panel_code=(String)prof_dtls.get("prof_serv_panel_code");
						med_serv_panel_str=(String)prof_dtls.get("prof_serv_panel_str");
						med_serv_panel_qty=(String)prof_dtls.get("prof_serv_panel_qty");
						med_serv_charge_amt=(String)prof_dtls.get("prof_serv_chrg_amt");
					}

					HashMap addl_dtls=(HashMap)billing_data.get("addl_dtls");

					if(addl_dtls!=null)
					{
						addl_serv_panel_ind=(String)addl_dtls.get("addl_serv_panel_ind");
						addl_serv_panel_code=(String)addl_dtls.get("addl_serv_panel_code");
						addl_serv_panel_str=(String)addl_dtls.get("addl_serv_panel_str");
						addl_serv_panel_qty=(String)addl_dtls.get("addl_serv_panel_qty");
						addl_serv_charge_amt=(String)addl_dtls.get("addl_serv_chrg_amt");
					}

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
				}
//				int intVisitNum = Integer.parseInt((String) tabdata.get("visit_id"));
//				int intEpisodeNum = Integer.parseInt((String) tabdata.get("episode_id"));

				try
				{
					String acc_seq_no_sql="select max(NVL(ACCT_SEQ_NO,1))  from bl_encounter_payer_priority where OPERATING_FACILITY_ID='"+facility_id+"' AND EPISODE_TYPE ='"+episode_type+"' AND EPISODE_ID='"+episode_id+"' AND VISIT_ID ='"+visit_id+"' AND PATIENT_ID  ='"+patient_id+"'";

					stmt3 = con.createStatement();
					rs = stmt3.executeQuery(acc_seq_no_sql) ;
					if( rs != null ) 
					{
						while( rs.next() )
						{  
							strAccSeqNo= rs.getString(1);
						}
					}
					if(rs != null) rs.close();
					stmt3.close();

					if(strAccSeqNo==null || strAccSeqNo.equals("")) strAccSeqNo="0";
		
					acc_seq_no=Integer.parseInt(strAccSeqNo);
	
//					System.out.println("acc_seq_no:"+acc_seq_no);
				}
				catch(Exception e)
				{
					System.out.println("Exception in Acc Seq No:"+e);
				}	

		// WS by IP Address/Name
				
				String str_ws_by_ip_name = "";
				String str_facility_id = ((String) tabdata.get("facility_id"));
				String sqlst1="select ws_by_ip_name from sm_facility_param_vw where facility_id = '"+str_facility_id+"'";
				PreparedStatement pst1=con.prepareStatement(sqlst1);
				ResultSet rst1 = pst1.executeQuery();
				if (rst1!=null)
				{
				   if (rst1.next())
				   {		
						 str_ws_by_ip_name = rst1.getString("ws_by_ip_name");
				   }
				}
				if(rst1 != null) rst1.close();
				pst1.close();

				if ( str_ws_by_ip_name == null ) str_ws_by_ip_name ="";
	
		// WS by IP Adress/Name
	
				module_id = (String) tabdata.get("module_id");
//				System.err.println("module_id BLOPCheckOut---->"+module_id);
				if ( (module_id == null)||(module_id.equals("")) )
				{
					module_id = "OP";
				}

				String p_machine_name = "";

				if (str_ws_by_ip_name.equals("I"))
				{						
					p_machine_name = InetAddress.getByName((String) tabdata.get("client_ip_address")).getHostName();
				}
				else
				{
					p_machine_name = ((String) tabdata.get("client_ip_address"));
				}

				try
				{
					String old_visit_dtls_sql="select CLINIC_CODE,VISIT_TYPE_CODE,PHYSICIAN_ID,CUR_CHARGING_BASIS_BY_PRACT_YN from bl_visit_exm_fin_dtls where OPERATING_FACILITY_ID='"+str_facility_id+"' AND EPISODE_TYPE ='"+episode_type+"' AND EPISODE_ID='"+episode_id+"' AND VISIT_ID ='"+visit_id+"' AND PATIENT_ID  ='"+patient_id+"'";
//					System.out.println("old_visit_dtls_sql:"+old_visit_dtls_sql);
					stmt3 = con.createStatement();
					rs = stmt3.executeQuery(old_visit_dtls_sql) ;
					if( rs != null ) 
					{
						while( rs.next() )
						{  
							strOldClinicCode = rs.getString(1);
							strOldVstTypeCode = rs.getString(2);
							strOldPractId= rs.getString(3);
							strOldChargeByPractYN = rs.getString(4);
						}
					}
					if(rs != null) rs.close();
					stmt3.close();

					if(strOldClinicCode==null || strOldClinicCode.equals("")) strOldClinicCode="";
					if(strOldVstTypeCode==null || strOldVstTypeCode.equals("")) strOldVstTypeCode="";
					if(strOldPractId==null || strOldPractId.equals("")) strOldPractId="";

//					System.out.println("strOldClinicCode:"+strOldClinicCode);
//					System.out.println("strOldVstTypeCode:"+strOldVstTypeCode);
//					System.out.println("strOldPractId:"+strOldPractId);
//					System.out.println("strOldChargeByPractYN:"+strOldChargeByPractYN);
				}
				catch(Exception e)
				{
					System.out.println("Exception in old_visit_dtls_sql:"+e);
				}

				try
				{
					CallableStatement call = con.prepareCall("{ call BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

					call.setString(1,facility_id);
					call.setString(2,clinic_code);
					call.setString(3,visit_type_code);
					call.setString(4,practitioner_id);

					call.registerOutParameter(5,java.sql.Types.INTEGER);
					call.registerOutParameter(6,java.sql.Types.INTEGER);
					call.registerOutParameter(7,java.sql.Types.VARCHAR);
					call.registerOutParameter(8,java.sql.Types.VARCHAR);
					call.registerOutParameter(9,java.sql.Types.VARCHAR);
					call.registerOutParameter(10,java.sql.Types.VARCHAR);
					call.registerOutParameter(11,java.sql.Types.VARCHAR);
					call.registerOutParameter(12,java.sql.Types.VARCHAR);
					call.registerOutParameter(13,java.sql.Types.VARCHAR);	
					call.registerOutParameter(14,java.sql.Types.VARCHAR);
					call.registerOutParameter(15,java.sql.Types.VARCHAR);
					call.registerOutParameter(16,java.sql.Types.VARCHAR);

					call.execute();

					charge_basis_by_physician_yn=call.getString(7);
					if(charge_basis_by_physician_yn==null) charge_basis_by_physician_yn="";

					err_level=call.getString(14);
					sys_message_id=call.getString(15);
					err_text=call.getString(16);
					if (err_level == null) err_level ="";
					if (sys_message_id ==null) sys_message_id ="";
					if (err_text ==null) err_text ="";

//					System.out.println("charge_basis_by_physician_yn:"+charge_basis_by_physician_yn);

//					System.out.println("error_level in BLOPIN:"+err_level);
//					System.out.println("sys_message_id in BLOPIN:"+sys_message_id);
//					System.out.println("error_text in BLOPIN:"+err_text);

					if( (!sys_message_id.equals(""))  || (err_level.equals("10") && !err_text.equals("") ) )
					{
						insertable=false;

						if((err_level.equals("10") && !err_text.equals("") ))
						{
							sb.append("<br>"+err_text+"<br> ") ;
//							System.out.println("sb mesage in Error is:"+sb);
						}
						else
						{
							messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
							sb.append((String)messageHashtable.get("message"));
//							System.out.println("sb mesage in sys_message is:"+sb);
						}
						call.close();
					}
					sys_message_id="";
					err_level="";
					err_text="";
				
					call.close();
				}
				catch(Exception e)
				{
					insertable = false;
					System.out.println("Exception in Procedure GET_VISIT_RULE_BY_CLINIC:"+e);
				}
//				System.err.println("ae_treatment_area_code------->"+ae_treatment_area_code);

/*** CRF-362 SCRUM related changes starts ****/		
				if(insertable)
				{
					try
					{
						if(module_id.equals("AE")&&!ae_treatment_area_code.equals("")) 
						{
							
							String sql_ae_bed="SELECT NVL(AE_BED_CHARGE_APPL_YN,'N') ae_bed_charge FROM Bl_parameters 	Where  operating_facility_id = ?";
							stmt=con.prepareStatement(sql_ae_bed);
							stmt.setString(1,facility_id);
							rs=stmt.executeQuery();
							while(rs.next()) 
							{
								ae_bed_charge_appl_yn=rs.getString(1);
							}
							if(rs!=null) rs.close();		
							if(stmt!=null) stmt.close();
			
							String p_auto_check_yn="";
							if(ae_bed_charge_appl_yn.equals("Y")) 
							{

								//String sqlAuto="select nvl(a.ae_post_chrg_auto_check,'N') ae_post_chrg_auto_check,nvl(b.no_of_decimal,2) noofdecimal from bl_parameters a,sm_acc_entity_param b where operating_facility_id=?";
		
								CallableStatement call = con.prepareCall("{call bl_ae_bed_calc.ae_bed_calculation(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

								call.setString(1, facility_id);
								call.setString(2, episode_type);
								call.setString(3, episode_id);
								call.setString(4,  visit_id);
								call.setString(5,  encounter_id);
								call.setString(6, patient_id);
								call.setString(7, "N");
								call.setString(8,"D");
								call.setString(9,added_by_id);

//								System.err.println("facility_id BLOPCheckOut-->"+facility_id);
//								System.err.println("episode_type BLOPCheckOut-->"+episode_type);
//								System.err.println("episode_id BLOPCheckOut-->"+episode_id);
//								System.err.println("visit_id BLOPCheckOut-->"+visit_id);
//								System.err.println("encounter_id BLOPCheckOut-->"+encounter_id);
//								System.err.println("patient_id BLOPCheckOut-->"+patient_id);
//								System.err.println("p_auto_check_yn BLOPCheckOut-->"+p_auto_check_yn);
//								System.err.println("str_user_id BLOPCheckOut-->"+added_by_id);

								call.registerOutParameter(10,  java.sql.Types.VARCHAR);
								call.registerOutParameter(11,  java.sql.Types.VARCHAR);
								call.registerOutParameter(12, java.sql.Types.VARCHAR);
								call.registerOutParameter(13, java.sql.Types.VARCHAR);
								call.registerOutParameter(14, java.sql.Types.VARCHAR);

								call.execute();

								str_bed_charge_net_amt = call.getString(10);
								str_bed_charge_patient_pay = call.getString(11);
								err_level = call.getString(12);
								sys_message_id = call.getString(13);
								err_text = call.getString(14);

								CurrencyFormat cf = new CurrencyFormat();

								str_bed_charge_net_amt = cf.formatCurrency(str_bed_charge_net_amt,noofdecimal );
								str_bed_charge_patient_pay = cf.formatCurrency(str_bed_charge_patient_pay, noofdecimal);

//								System.err.println("str_bed_charge_net_amt BLOPCheckOut"+str_bed_charge_net_amt);
//								System.err.println("str_bed_charge_patient_pay BLOPCheckOut"+str_bed_charge_patient_pay);
//								System.err.println("err_level BLOPCheckOut"+err_level);
//								System.err.println("sys_message_id BLOPCheckOut"+sys_message_id);
//								System.err.println("err_text BLOPCheckOut"+err_text);


								if(str_bed_charge_net_amt==null || str_bed_charge_net_amt.equals("")) str_bed_charge_net_amt="0.0";
									bed_chrg_pat_amt=Double.parseDouble(str_bed_charge_net_amt);

								if(str_bed_charge_patient_pay==null || str_bed_charge_patient_pay.equals("")) str_bed_charge_patient_pay="0.0";
									bed_chrg_pat_pay=Double.parseDouble(str_bed_charge_patient_pay);							  

								if (err_level == null) err_level ="";
								if (sys_message_id ==null) sys_message_id ="";
								if (err_text ==null) err_text ="";
		
								if((err_level.equals("10") && !err_level.equals("")) || !sys_message_id.equals(""))  
								{
									insertable=false;
									if (err_level.equals("10") && !err_level.equals("")) 
									{
										sb.append("<br>"+err_text+"<br> ") ;
//										System.out.println("sb mesage in Error is:"+sb);
									}
									if(!sys_message_id.equals("")) 
									{
										messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
										sb.append((String)messageHashtable.get("message"));
//										System.out.println("sb mesage in sys_message is:"+sb);
									}
									call.close();
								}

								sys_message_id="";
								err_level="";
								err_text="";
							
								call.close();
							}
						}
					}
					catch (Exception e) 
					{
						insertable = false;
						System.err.println("Exception in Procedure ae_bed_calculation:"+e);
						sb.append("Exception in Procedure ae_bed_calculation:"+e);
					}
				}
/*** CRF-362 SCRUM related changes ends ****/

/* ********************************* Commented for Billing Enhancement Requirements ********************************************* */
/*	
				statement=con.prepareCall("{call blopin.proc_generate_bill(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				statement.setString( 1,"D");
				statement.setString( 2,"POST_CONSULTATION");
			//	statement.setString( 3, "OP");	// Module Id
				statement.setString( 3, module_id);	// Module Id
				statement.setString( 4, (String)tabdata.get("facility_id"));
				statement.setString( 5, (String) tabdata.get("patient_id"));
				statement.setString( 6, (String) tabdata.get("episode_type"));
				statement.setInt( 7, intEpisodeNum);
				statement.setInt( 8, intVisitNum);
				statement.setString( 9, strNull);
				statement.setString( 10, strNull);				
				statement.setString( 11, (String) tabdata.get("login_user"));				
				statement.setString( 12, (String) tabdata.get("client_ip_address"));				
				statement.setString( 13,p_machine_name);		
				statement.registerOutParameter( 14, java.sql.Types.VARCHAR);		
				statement.registerOutParameter( 15, java.sql.Types.VARCHAR);
				statement.registerOutParameter( 16, java.sql.Types.VARCHAR);
				statement.registerOutParameter( 17, java.sql.Types.VARCHAR);
				statement.registerOutParameter( 18, java.sql.Types.VARCHAR);
				statement.registerOutParameter( 19, java.sql.Types.VARCHAR);
				statement.registerOutParameter( 20, java.sql.Types.VARCHAR);

				statement.execute();

				strVisitMessage = statement.getString(14);
				strBillGenYN = statement.getString(15);
				String strBillDocTypeCode = statement.getString(16);
				String strBillDocNumber = statement.getString(17);
				strBillMessage =  statement.getString(18);
	            String strErrMsg  = statement.getString(19);
				String strErrText  = statement.getString(20);
				
				if (strErrMsg != null )
				{
					if (!strErrMsg.equals(""))
					{
						insertable=false;
						sb.append("BLOPCheckOut: Error Code "+strErrMsg);
                        con.rollback();
                        con.setAutoCommit(true);

					}
				}
				if (strErrText != null )
				{
					if (!strErrText.equals(""))
					{
						insertable=false;
						sb.append("BLOPCheckOut: Error Text "+strErrText);
                        con.rollback();
                        con.setAutoCommit(true);

					}
				}
				if (strBillGenYN == null || strBillGenYN.equals(""))
				{
					strBillGenYN = "N";
				}
				if (strBillGenYN.equals("C"))
				{
					if ( strBillMessage != null)
					{
							strFinalMessage = strBillMessage ;
					}
					else
					{
						strFinalMessage =	" ";
					}

				}
				else
				{
					strFinalMessage = " ";
				}		
*/
/* **************************************************************************************************************************** */

//				String sql="{call blopin.proc_main('D','"+function_id+"','"+facility_id+"','"+module_id+"','"+clinic_code+"','"+visit_type_code+"','"+strNull+"','"+patient_id+"','"+episode_type+"','"+encounter_id+"','"+episode_id+"','"+visit_id+"','P','"+practitioner_id+"','"+str_blng_grp+"','"+str_cust_code+"','"+str_ins_policy_type_code+"','"+str_ins_cust_priority+"','"+str_ins_policy_no+"','"+str_ins_policy_start_date+"','"+str_ins_policy_expiry_date+"','"+str_ins_credit_auth_ref+"','"+str_ins_credit_auth_date+"','"+str_ins_policy_eff_from_date+"','"+str_ins_policy_eff_to_date+"','"+str_ins_credit_approval_amount+"','"+str_ins_credit_approval_days+"','"+str_non_ins_blng_grp+"','"+str_non_ins_cust_code+"','"+hosp_serv_panel_ind+"','"+hosp_serv_panel_code+"','"+hosp_serv_panel_str+"','"+hosp_serv_panel_qty+"','"+hosp_serv_charge_amt+"','"+med_serv_panel_ind+"','"+med_serv_panel_code+"','"+med_serv_panel_str+"','"+med_serv_panel_qty+"','"+med_serv_charge_amt+"','"+added_by_id+"','"+added_at_ws_no+"','"+p_machine_name+"',"+acc_seq_no+",'"+strNull+"','"+locale+"',?,?,?,?,?,?,?,?,?,?,?,?)}";
				if(insertable)
				{
					if( (!strOldClinicCode.equals(clinic_code)) || (!strOldVstTypeCode.equals(visit_type_code)) || ((charge_basis_by_physician_yn.equals("Y") && !strOldPractId.equals(practitioner_id)) || (charge_basis_by_physician_yn.equals("N") && !strOldPractId.equals(practitioner_id)) ) )
					{
						call_revise_proc_YN = "Y";
					}
					else
					{
						call_charge_proc_YN = "Y";
					}
					System.err.println("call_charge_proc_YN:"+call_charge_proc_YN);
					if(call_charge_proc_YN.equals("Y"))
					{
						String sql="{call BLVisitCharge.proc_main('D','"+function_id+"','"+facility_id+"','"+module_id+"','"+clinic_code+"','"+visit_type_code+"','"+strNull+"','"+patient_id+"','"+episode_type+"','"+encounter_id+"',"+episode_id+","+visit_id+",'"+strNull+"','P','"+practitioner_id+"','"+str_blng_grp+"','"+str_cust_group_code+"','"+str_cust_code+"','"+str_ins_policy_type_code+"','"+str_ins_cust_priority+"','"+str_ins_policy_no+"','"+str_ins_policy_start_date+"','"+str_ins_policy_expiry_date+"','"+str_ins_credit_auth_ref+"','"+str_ins_credit_auth_date+"','"+str_ins_policy_eff_from_date+"','"+str_ins_policy_eff_to_date+"','"+str_ins_credit_approval_amount+"','"+str_ins_credit_approval_days+"','"+str_non_ins_blng_grp+"','"+str_non_ins_cust_group_code+"','"+str_non_ins_cust_code+"','"+strNewHospChrgCreate+"','"+strNewMedChrgCreate+"','"+strNewAddlChrgCreate+"','"+hosp_serv_panel_ind+"','"+hosp_serv_panel_code+"','"+hosp_serv_panel_str+"','"+hosp_serv_panel_qty+"','"+hosp_serv_charge_amt+"','"+med_serv_panel_ind+"','"+med_serv_panel_code+"','"+med_serv_panel_str+"','"+med_serv_panel_qty+"','"+med_serv_charge_amt+"','"+addl_serv_panel_ind+"','"+addl_serv_panel_code+"','"+addl_serv_panel_str+"','"+addl_serv_panel_qty+"','"+addl_serv_charge_amt+"','"+str_bill_later_YN+"','"+added_by_id+"','"+added_at_ws_no+"','"+p_machine_name+"',"+acc_seq_no+",'"+strNull+"','"+locale+"',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

//						System.out.println("sql:"+sql);

						statement=con.prepareCall(sql);			

						statement.registerOutParameter( 1, java.sql.Types.VARCHAR);		
						statement.registerOutParameter( 2, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 3, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 4, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 5, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 6, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 7, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 8, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 9, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 10, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 11, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 12, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 13, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 14, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 15, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 16, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 17, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 18, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 19, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 20, java.sql.Types.VARCHAR);
							
						statement.execute();

						hosp_charge_YN= statement.getString(1);
						if(hosp_charge_YN==null || hosp_charge_YN.equals("")) hosp_charge_YN="";

						med_charge_YN= statement.getString(2);
						if(med_charge_YN==null || med_charge_YN.equals("")) med_charge_YN="";

						addl_charge_YN= statement.getString(3);
						if(addl_charge_YN==null || addl_charge_YN.equals("")) addl_charge_YN="";

						exempt_date= statement.getString(4);
						if(exempt_date==null || exempt_date.equals("")) exempt_date="";

						str_hosp_chrg_amt=statement.getString(5);
						if(str_hosp_chrg_amt==null || str_hosp_chrg_amt.equals("")) str_hosp_chrg_amt="0.0";
						hosp_chrg_amt= Double.parseDouble(str_hosp_chrg_amt);
						
						str_hosp_chrg_pat_amt=statement.getString(6);
						if(str_hosp_chrg_pat_amt==null || str_hosp_chrg_pat_amt.equals("")) str_hosp_chrg_pat_amt="0.0";
						hosp_chrg_pat_amt=Double.parseDouble(str_hosp_chrg_pat_amt);
											
						str_med_chrg_amt=statement.getString(7);
						if(str_med_chrg_amt==null || str_med_chrg_amt.equals("")) str_med_chrg_amt="0.0";
						med_chrg_amt=Double.parseDouble(str_med_chrg_amt);
										
						str_med_chrg_pat_amt=statement.getString(8);
						if(str_med_chrg_pat_amt==null || str_med_chrg_pat_amt.equals("")) str_med_chrg_pat_amt="0.0";
						med_chrg_pat_amt=Double.parseDouble(str_med_chrg_pat_amt);

						str_addl_chrg_amt=statement.getString(9);
						if(str_addl_chrg_amt==null || str_addl_chrg_amt.equals("")) str_addl_chrg_amt="0.0";
						addl_chrg_amt=Double.parseDouble(str_addl_chrg_amt);
										
						str_addl_chrg_pat_amt=statement.getString(10);
						if(str_addl_chrg_pat_amt==null || str_addl_chrg_pat_amt.equals("")) str_addl_chrg_pat_amt="0.0";
						addl_chrg_pat_amt=Double.parseDouble(str_addl_chrg_pat_amt);
										
						bill_gen_yn=statement.getString(11);
						if(bill_gen_yn==null || bill_gen_yn.equals("")) bill_gen_yn="";
						bill_doc_type=statement.getString(12);
						if(bill_doc_type==null || bill_doc_type.equals("")) bill_doc_type="";
						bill_doc_number=statement.getString(13);
						if(bill_doc_number==null || bill_doc_number.equals("")) bill_doc_number="";

						str_bill_gen_later=statement.getString(14);
						if(str_bill_gen_later==null || str_bill_gen_later.equals("")) str_bill_gen_later="N";
						str_total_bill_amt=statement.getString(15);
						if(str_total_bill_amt==null || str_total_bill_amt.equals("")) str_total_bill_amt="";

						str_bill_prt_format_YN = statement.getString(16);
						if(str_bill_prt_format_YN==null || str_bill_prt_format_YN.equals("")) str_bill_prt_format_YN="N";

						str_bill_prt_format_vals = statement.getString(17);
						if(str_bill_prt_format_vals==null || str_bill_prt_format_vals.equals("")) str_bill_prt_format_vals="";

						System.err.println("str_bill_prt_format_YN in IF:"+str_bill_prt_format_YN);
						System.err.println("str_bill_prt_format_vals in IF:"+str_bill_prt_format_vals);
						
						total_chrg_amt=hosp_chrg_amt+med_chrg_amt+addl_chrg_amt;
						total_pat_chrg_amt=hosp_chrg_pat_amt+med_chrg_pat_amt+addl_chrg_pat_amt;

						str_total_chrg_amt=String.valueOf(total_chrg_amt);
						str_total_pat_chrg_amt=String.valueOf(total_pat_chrg_amt);		
						
						err_level=statement.getString(18);
						sys_message_id=statement.getString(19);
						err_text=statement.getString(20);


						if(err_level==null || err_level.equals("")) err_level="";
						if(sys_message_id==null || sys_message_id.equals("")) sys_message_id="";
						if(sys_message_id==null || sys_message_id.equals("")) sys_message_id="";
					}
					else if (call_revise_proc_YN.equals("Y"))
					{
						String sql_revise_visit="{call BLVISITREVISE.proc_main('D','"+function_id+"','"+facility_id+"','"+module_id+"','"+clinic_code+"','"+visit_type_code+"','"+visit_type_code+"','"+strNull+"','"+patient_id+"','"+episode_type+"','"+encounter_id+"','"+episode_id+"','"+visit_id+"','P','"+practitioner_id+"','"+str_blng_grp+"','"+str_cust_group_code+"','"+str_cust_code+"','"+str_ins_policy_type_code+"','"+str_ins_cust_priority+"','"+str_ins_policy_no+"','"+str_ins_policy_start_date+"','"+str_ins_policy_expiry_date+"','"+str_ins_credit_auth_ref+"','"+str_ins_credit_auth_date+"','"+str_ins_policy_eff_from_date+"','"+str_ins_policy_eff_to_date+"','"+str_ins_credit_approval_amount+"','"+str_ins_credit_approval_days+"','"+str_non_ins_blng_grp+"','"+str_non_ins_cust_group_code+"','"+str_non_ins_cust_code+"','"+hosp_serv_panel_ind+"','"+hosp_serv_panel_code+"','"+hosp_serv_panel_str+"','"+hosp_serv_panel_qty+"','"+hosp_serv_charge_amt+"','"+med_serv_panel_ind+"','"+med_serv_panel_code+"','"+med_serv_panel_str+"','"+med_serv_panel_qty+"','"+med_serv_charge_amt+"','"+addl_serv_panel_ind+"','"+addl_serv_panel_code+"','"+addl_serv_panel_str+"','"+addl_serv_panel_qty+"','"+addl_serv_charge_amt+"','"+str_bill_later_YN+"','"+added_by_id+"','"+added_at_ws_no+"','"+p_machine_name+"',"+acc_seq_no+",'"+strNull+"','"+locale+"',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

//						System.out.println("sql_revise_visit:"+sql_revise_visit);

						statement=con.prepareCall(sql_revise_visit);			

						statement.registerOutParameter( 1, java.sql.Types.VARCHAR);		
						statement.registerOutParameter( 2, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 3, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 4, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 5, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 6, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 7, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 8, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 9, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 10, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 11, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 12, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 13, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 14, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 15, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 16, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 17, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 18, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 19, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 20, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 21, java.sql.Types.VARCHAR);
						statement.registerOutParameter( 22, java.sql.Types.VARCHAR);
						
						statement.execute();

						hosp_charge_YN= statement.getString(1);
						if(hosp_charge_YN==null || hosp_charge_YN.equals("")) hosp_charge_YN="";

						med_charge_YN= statement.getString(2);
						if(med_charge_YN==null || med_charge_YN.equals("")) med_charge_YN="";

						addl_charge_YN= statement.getString(3);
						if(addl_charge_YN==null || addl_charge_YN.equals("")) addl_charge_YN="";

						exempt_date= statement.getString(4);
						if(exempt_date==null || exempt_date.equals("")) exempt_date="";

						str_hosp_chrg_amt=statement.getString(5);
						if(str_hosp_chrg_amt==null || str_hosp_chrg_amt.equals("")) str_hosp_chrg_amt="0.0";
						hosp_chrg_amt= Double.parseDouble(str_hosp_chrg_amt);

						str_hosp_chrg_pat_amt=statement.getString(6);
						if(str_hosp_chrg_pat_amt==null || str_hosp_chrg_pat_amt.equals("")) str_hosp_chrg_pat_amt="0.0";
						hosp_chrg_pat_amt=Double.parseDouble(str_hosp_chrg_pat_amt);
							
						str_med_chrg_amt=statement.getString(7);
						if(str_med_chrg_amt==null || str_med_chrg_amt.equals("")) str_med_chrg_amt="0.0";
						med_chrg_amt=Double.parseDouble(str_med_chrg_amt);

						str_med_chrg_pat_amt=statement.getString(8);
						if(str_med_chrg_pat_amt==null || str_med_chrg_pat_amt.equals("")) str_med_chrg_pat_amt="0.0";
						med_chrg_pat_amt=Double.parseDouble(str_med_chrg_pat_amt);

						str_addl_chrg_amt=statement.getString(9);
						if(str_addl_chrg_amt==null || str_addl_chrg_amt.equals("")) str_addl_chrg_amt="0.0";
						addl_chrg_amt=Double.parseDouble(str_addl_chrg_amt);

						str_addl_chrg_pat_amt=statement.getString(10);
						if(str_addl_chrg_pat_amt==null || str_addl_chrg_pat_amt.equals("")) str_addl_chrg_pat_amt="0.0";
						addl_chrg_pat_amt=Double.parseDouble(str_addl_chrg_pat_amt);

						strVisitMessage=statement.getString(11);
						if(strVisitMessage==null) strVisitMessage="";

						bill_gen_yn=statement.getString(12);
						if(bill_gen_yn==null || bill_gen_yn.equals("")) bill_gen_yn="N";
						bill_doc_type=statement.getString(13);
						if(bill_doc_type==null || bill_doc_type.equals("")) bill_doc_type="";
						bill_doc_number=statement.getString(14);
						if(bill_doc_number==null || bill_doc_number.equals("")) bill_doc_number="";
						total_bill_text=statement.getString(15);
						if(total_bill_text==null || total_bill_text.equals("")) total_bill_text="";

						str_bill_gen_later=statement.getString(16);
						if(str_bill_gen_later==null || str_bill_gen_later.equals("")) str_bill_gen_later="N";
						str_total_bill_amt=statement.getString(17);
						if(str_total_bill_amt==null || str_total_bill_amt.equals("")) str_total_bill_amt="";

						str_bill_prt_format_YN = statement.getString(18);
						if(str_bill_prt_format_YN==null || str_bill_prt_format_YN.equals("")) str_bill_prt_format_YN="N";

						str_bill_prt_format_vals = statement.getString(19);
						if(str_bill_prt_format_vals==null || str_bill_prt_format_vals.equals("")) str_bill_prt_format_vals="";

						System.err.println("str_bill_prt_format_YN in ELSIF:"+str_bill_prt_format_YN);
						System.err.println("str_bill_prt_format_vals in ELSIF:"+str_bill_prt_format_vals);
				
						total_chrg_amt=hosp_chrg_amt+med_chrg_amt+addl_chrg_amt;
						total_pat_chrg_amt=hosp_chrg_pat_amt+med_chrg_pat_amt+addl_chrg_pat_amt;

						str_total_chrg_amt=String.valueOf(total_chrg_amt);
						str_total_pat_chrg_amt=String.valueOf(total_pat_chrg_amt);		

						err_level=statement.getString(20);
						sys_message_id=statement.getString(21);
						err_text=statement.getString(22);

						if(err_level==null || err_level.equals("")) err_level="";
						if(sys_message_id==null || sys_message_id.equals("")) sys_message_id="";
						if(err_text==null || err_text.equals("")) err_text="";
					}

					try
					{
						if (str_hosp_chrg_amt!=null)
							str_hosp_chrg_amt = cf1.formatCurrency(str_hosp_chrg_amt, noofdecimal);
							
						if(str_med_chrg_amt!=null)
							str_med_chrg_amt = cf1.formatCurrency(str_med_chrg_amt, noofdecimal);

						if(str_addl_chrg_amt!=null)
							str_addl_chrg_amt = cf1.formatCurrency(str_addl_chrg_amt, noofdecimal);
						
						if(str_total_chrg_amt!=null)
							str_total_chrg_amt = cf1.formatCurrency(str_total_chrg_amt, noofdecimal);

						if(str_total_pat_chrg_amt!=null)
							str_total_pat_chrg_amt = cf1.formatCurrency(str_total_pat_chrg_amt, noofdecimal);

						if(str_hosp_chrg_pat_amt!=null)
							str_hosp_chrg_pat_amt=cf1.formatCurrency(str_hosp_chrg_pat_amt, noofdecimal);

						if(str_med_chrg_pat_amt!=null)
							str_med_chrg_pat_amt=cf1.formatCurrency(str_med_chrg_pat_amt, noofdecimal);

						if(str_addl_chrg_pat_amt!=null)
							str_addl_chrg_pat_amt=cf1.formatCurrency(str_addl_chrg_pat_amt, noofdecimal);
					}
					catch(Exception e)
					{
						System.out.println("Currency exception ::"+e);
					}
/*
					System.out.println("hosp_charge_YN:"+hosp_charge_YN);
					System.out.println("med_charge_YN:"+med_charge_YN);
					System.out.println("addl_charge_YN:"+addl_charge_YN);
					System.out.println("exempt_date:"+exempt_date);
					System.out.println("hosp_chrg_amt:"+hosp_chrg_amt);
					System.out.println("hosp_chrg_pat_amt:"+hosp_chrg_pat_amt);
					System.out.println("med_chrg_amt:"+med_chrg_amt);
					System.out.println("med_chrg_pat_amt:"+med_chrg_pat_amt);
					System.out.println("addl_chrg_amt:"+addl_chrg_amt);
					System.out.println("addl_chrg_pat_amt:"+addl_chrg_pat_amt);
					System.out.println("bill_gen_yn:"+bill_gen_yn);
					System.out.println("bill_doc_type:"+bill_doc_type);
					System.out.println("bill_doc_number:"+bill_doc_number);
					System.out.println("str_bill_gen_later:"+str_bill_gen_later);
					System.out.println("str_total_bill_amt:"+str_total_bill_amt);
*/
					if(bill_gen_yn.equals("Y") && (bill_doc_type.equals("") && bill_doc_number.equals("0")))
					{
						bill_gen_yn="N";
					}

					if(hosp_charge_YN.equals("Y") && bill_gen_yn.equals("N") && str_bill_gen_later.equals("N"))
					{
						if(hosp_chrg_amt>=0)
						{
							strFinalMessage=hosp_chrg_leg+" "+str_hosp_chrg_amt+" "+patient_payable_leg+" "+str_hosp_chrg_pat_amt;
						}
					}

					if(med_charge_YN.equals("Y") && bill_gen_yn.equals("N") && str_bill_gen_later.equals("N"))
					{
						if(med_chrg_amt>=0)
						{
							strFinalMessage=strFinalMessage+"<BR>"+prof_chrg_leg+" "+str_med_chrg_amt+" "+patient_payable_leg+" "+str_med_chrg_pat_amt;
						}
					}
					

					if(addl_charge_YN.equals("Y") && bill_gen_yn.equals("N") && str_bill_gen_later.equals("N"))
					{
						if(addl_chrg_amt>=0)
						{
							strFinalMessage=strFinalMessage+"<BR>"+addl_chrg_leg+" "+str_addl_chrg_amt+" "+patient_payable_leg+" "+str_addl_chrg_pat_amt;
						}
					}

					if(exempt_date!=null && !exempt_date.equals(""))
					{
						strFinalMessage=strFinalMessage+"<BR>"+vst_chrg_exmpt_leg+" "+exempt_date;
					}

					if(bill_gen_yn.equals("Y") && str_bill_gen_later.equals("N"))
					{
						/*** CRF-362 SCRUM related changes starts ****/
						if(ae_bed_charge_appl_yn.equals("Y") && bed_chrg_pat_amt>=0 && !ae_treatment_area_code.equals("") && module_id.equals("AE"))
						{
							total_chrg_amt=total_chrg_amt+bed_chrg_pat_amt;
							total_pat_chrg_amt=total_pat_chrg_amt+bed_chrg_pat_pay;

							str_total_chrg_amt=String.valueOf(total_chrg_amt);
							str_total_pat_chrg_amt=String.valueOf(total_pat_chrg_amt);

							if(str_total_chrg_amt!=null)
							str_total_chrg_amt = cf1.formatCurrency(str_total_chrg_amt, noofdecimal);

							if(str_total_pat_chrg_amt!=null)
							str_total_pat_chrg_amt = cf1.formatCurrency(str_total_pat_chrg_amt, noofdecimal);

//							System.err.println("total_chrg_amt in CRF-362 loop:"+total_chrg_amt);
//							System.err.println("total_pat_chrg_amt in CRF-362 loop:"+total_pat_chrg_amt);
//							System.err.println("str_total_chrg_amt in CRF-362 loop:"+str_total_chrg_amt);
//							System.err.println("str_total_pat_chrg_amt in CRF-362 loop:"+str_total_pat_chrg_amt);
						}
						
						if(ae_bed_charge_appl_yn.equals("Y") && module_id.equals("AE"))
						{
//							strFinalMessage=strFinalMessage+"<BR>"+bill_gen_yn_leg+" "+bill_doc_type+"/"+bill_doc_number+" "+bill_gen_yn_leg2+" "+str_total_chrg_amt+" "+patient_payable_leg+" "+str_total_pat_chrg_amt;
							strFinalMessage=strFinalMessage+"<BR>"+bill_gen_yn_message+bill_doc_type+"/"+bill_doc_number;
//							System.err.println("strFinalMessage for CRF-362:"+strFinalMessage);
						}/*** CRF-362 SCRUM related changes ends ****/
						else
						{
//							strFinalMessage=strFinalMessage+"<BR>"+bill_gen_yn_leg+" "+bill_doc_type+"/"+bill_doc_number+" "+bill_gen_yn_leg1+" "+str_total_chrg_amt+" "+patient_payable_leg+" "+str_total_pat_chrg_amt;
							strFinalMessage=strFinalMessage+"<BR>"+bill_gen_yn_message+bill_doc_type+"/"+bill_doc_number;
//							System.err.println("strFinalMessage in else:"+strFinalMessage);
						}
					}

/*** CRF-362 SCRUM related changes starts ****/
//					System.err.println("ae_treatment_area_code"+ae_treatment_area_code);
//					System.err.println("ae_treatment_area_code-->"+ae_treatment_area_code);
//					System.err.println("ae_bed_charge_appl_yn-->"+ae_bed_charge_appl_yn);
//					System.err.println("bed_chrg_pat_amt-->"+bed_chrg_pat_amt);

					if(bill_gen_yn.equals("N") && str_bill_gen_later.equals("N") && module_id.equals("AE") && !ae_treatment_area_code.equals("") && bed_chrg_pat_amt>=0 && ae_bed_charge_appl_yn.equals("Y"))
					{
//						System.err.println("enter in the BedChargeloop ");
						java.util.ResourceBundle ip_labels = java.util.ResourceBundle.getBundle("eIP.resources.Labels",loc);
						String bed_charge_leg = ip_labels.getString("eIP.BedCharge.label");

						strFinalMessage=strFinalMessage+"<BR>"+bed_charge_leg+" "+str_bed_charge_net_amt+" "+patient_payable_leg+" "+str_bed_charge_patient_pay;
					}
/*** CRF-362 SCRUM related changes ends ****/					

//					System.out.println("strFinalMessage:"+strFinalMessage);

					if(  (!sys_message_id.equals(""))  || (err_level.equals("10") && !err_text.equals("") ) )
					{
						insertable=false;
						if((err_level.equals("10") && !err_text.equals("") ))
						{
							sb.append("<br>"+err_text+"<br> ") ;
//							System.out.println("sb mesage in Error is:"+sb);
						}
						else
						{
							messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
							sb.append((String)messageHashtable.get("message"));
//							System.out.println("sb mesage in sys_message is:"+sb);
						}
						statement.close();
					}
					sys_message_id="";
					err_level="";
					err_text="";
				}
			} // End of Try Block in Calculation of VisitCharge
			catch(Exception except)
			{
				insertable=false;
				sb.append("BLOPCheckOut: Exception Error Text  "+except);
			}

			if(insertable && str_bill_prt_format_YN.equals("Y"))
			{
				try
				{
					StringTokenizer st1 = new StringTokenizer(str_bill_prt_format_vals,"/");

					while(st1.hasMoreTokens())
					{
						pgm_id = st1.nextToken();
						System.err.println("pgm_id:"+pgm_id);
						session_id = st1.nextToken();
						System.err.println("session_id:"+session_id);
						pgm_date = st1.nextToken();
						System.err.println("pgm_date:"+pgm_date);
						mpi_id_rep = st1.nextToken();
						System.err.println("mpi_id_rep:"+mpi_id_rep);
					}							
/*								
					OnlineReport onlinereportParam = new OnlineReport((String) tabdata.get("facility_id"), "BL", "BLRBLPRT");
					onlinereportParam.addParameter("p_facility_id",(String) tabdata.get("facility_id"));
					onlinereportParam.addParameter("p_pgm_date",pgm_date);
					onlinereportParam.addParameter("p_pgm_id",pgm_id);
					onlinereportParam.addParameter("p_Session_id",session_id);
					System.err.println("Online Report onlinereportParam:"+onlinereportParam);
					OnlineReports onlinereports = new OnlineReports();
					onlinereports.add(onlinereportParam);
					System.err.println("Online Report Added:"+onlinereports);
					String strResults =  onlinereports.execute((HttpServletRequest) billing_data.get("httpreq"), (HttpServletResponse) billing_data.get("httpres"));
					System.err.println("Online Report Executed");
					System.err.println("strResults:"+strResults);

					onlinereportParam = null;
					onlinereports = null;		
*/								
				}
				catch (Exception e)
				{
					insertable=false;
					System.err.println("Error while submitting Print Job to Report Server:"+e);
					sb.append("Mod. Exception while calling Print Report : "+e);
				}
			}
		}
		else
		{
			insertable = true;
		}			

		if ( (strFinalMessage == null) || (strFinalMessage.equals("")) )
		{
			strFinalMessage = " ";
		}	
	//ENDS HERE

		results.put( "status", new Boolean(insertable) ) ;
        results.put( "error", sb.toString() ) ;
        results.put( "message",strFinalMessage);
		results.put( "billgenlater",str_bill_gen_later) ;	
		results.put( "billdoctype",bill_doc_type) ;
		results.put( "billdocnum", bill_doc_number) ;
		results.put( "billtotalamt", str_total_bill_amt) ;

		results.put( "bill_prt_format_YN", str_bill_prt_format_YN);
		results.put( "pgm_id", pgm_id);
		results.put( "session_id", session_id);
		results.put( "pgm_date", pgm_date);
		results.put( "mpi_id_rep", mpi_id_rep);
		System.err.println("results:"+results);
      // results.put( "p_encounter_id", encounterid);
        return results ;
    }

	private PreparedStatement setData(PreparedStatement stmt,Object[] obj)
    {
		try
        {
			for(int i=0;i<obj.length;i++)
            {
				if(obj[i] instanceof java.sql.Date)
                {
					if (obj[i] instanceof java.sql.Date  )
						stmt.setDate((i+1),(java.sql.Date)obj[i]);
                }

				if(obj[i] instanceof String)
                {
                    if(((String)obj[i]).equalsIgnoreCase("null"))
                         stmt.setString((i+1),null);
                    else if((String)obj[i] == null)
                         stmt.setString((i+1),null);
                    else
                         stmt.setString((i+1),(String)obj[i]);
                 }

				 if(obj[i] instanceof Integer)
                 {
                     stmt.setInt((i+1),(((Integer)obj[i]).intValue()));
                 }

				 if(obj[i] instanceof Long)
                 {
                     stmt.setLong((i+1),(  ((Long)obj[i]).longValue() ));
                 }

				 if(obj[i] instanceof Double)
                 {
                     stmt.setDouble((i+1),( ((Double)obj[i]).doubleValue()) );
                 }

                 if(obj[i] instanceof Float)
                 {
                     stmt.setFloat((i+1),(((Float)obj[i]).floatValue()));
                 }
			}
		}
        catch(Exception e)
		{
			e.printStackTrace();
		}
        return(stmt);
	}
}
