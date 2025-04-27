/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package blmpin;

import java.net.*;
import java.io.*;
import java.sql.*;

import javax.rmi.*;

import blPolicy.BLPayerPolicyDetails;
import eBL.PolicyInsuranceMasterBean;

import java.util.*;
import java.sql.*;

import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;

public class BLMPInterface {
	// public java.util.Hashtable insert( Properties p,Connection con, String
	// appt_status,String episodeno,Hashtable tabdata,Hashtable
	// prencounter,Hashtable prencounterdetail)
	public java.util.Hashtable billPatientService(Properties p, Connection con,
			Hashtable tabdata) {
		System.err
				.println("Entered the billPatientService Method MP Interface");
		CallableStatement statement = null;
		Hashtable results = new Hashtable();
		Hashtable messageHashtable = new Hashtable();
		StringBuffer sb = new StringBuffer();

		Statement st = null;
		ResultSet rs = null;

		double annual_income = 0;
		double family_asset = 0;
		int no_of_dependants = 0;
		// int ins_credit_approval_days=0;
		// double ins_credit_approval_amount=0;
		// double ins_adj_perc_amt_value=0;
		Hashtable insert_values = tabdata;
		String strFunctionId = "";
		String strFacilityId = "";
		boolean insertable = true;
		String proc_success = "N";
		sb.append("");
		String locale = "";

		String str_blng_grp = "";
		String str_slmt_ind = "";
		String str_credit_doc_reqd_yn = "";
		String str_blng_class = "";
		String str_emp_code = "";
		String str_slmt_type_code = "";
		String str_inst_ref = "";
		String str_inst_date = "";
		String str_inst_remarks = "";
		String str_credit_cust_group_code = "";
		String str_credit_cust_code = "";
		String str_credit_doc_ref = "";
		String str_credit_doc_start_date = "";
		String str_credit_doc_end_date = "";
		String str_sponsor_cust_group_code = "";
		String str_sponsor_cust_code = "";
		String str_sponsor_credit_doc_ref = "";
		String str_sponsor_credit_doc_start_date = "";
		String str_sponsor_credit_doc_end_date = "";
		String str_ins_blng_grp = "";
		String str_ins_cust_group_code = "";
		String str_ins_cust_code = "";
		String str_ins_cust_priority = "";
		String str_ins_policy_type_code = "";
		String str_ins_policy_no = "";
		String str_ins_policy_start_date = "";
		String str_ins_policy_expiry_date = "";
		String str_ins_credit_auth_ref = "";
		String str_ins_credit_auth_date = "";
		String str_ins_credit_approval_days = "";
		String str_ins_credit_approval_amount = "";
		String str_ins_policy_eff_from_date = "";
		String str_ins_policy_eff_to_date = "";
		String str_ins_adj_rule_ind = "";
		String str_ins_adj_perc_amt_ind = "";
		String str_ins_adj_perc_amt_value = "";
		String str_ins_pmnt_diff_adj_int = "";
		String str_ins_drg_pmnt_diff_adj_int = "";
		String str_ins_spl_srv_pmnt_diff_adj_int = "";
		String str_non_ins_blng_grp = "";
		String str_non_ins_credit_doc_reqd_yn = "";
		String str_non_ins_slmt_type_code = "";
		String str_non_ins_inst_ref = "";
		String str_non_ins_inst_date = "";
		String str_non_ins_inst_remarks = "";
		String str_non_ins_cust_group_code = "";
		String str_non_ins_cust_code = "";
		String str_non_ins_credit_doc_ref = "";
		String str_non_ins_credit_doc_start_date = "";
		String str_non_ins_credit_doc_end_date = "";
		String str_annual_income = "";
		String str_family_asset = "";
		String str_no_of_dependants = "";
		String str_resp_for_payment = "";
		String str_pat_reln_with_resp_person = "";
		String str_fin_remarks = "";
		String str_gl_holder_name = "";
		String str_pat_reln_with_gl_holder = "";

		String str_ref_src_main_code = "";
		String str_ref_src_sub_code = "";
		String str_ins_ref_src_main_code = "";
		String str_ins_ref_src_sub_code = "";
		String str_non_ins_ref_src_main_code = "";
		String str_non_ins_ref_src_sub_code = "";

		String str_upd_patient_fin_dtls_yn = "";
		String str_user_id = "";
		String str_fin_auth_user_id = "";
		String str_calling_function_id = "";
		String str_acct_seq_eff_from_date = "";
		String str_acct_seq_eff_to_date = "";
		String str_cust_group_code = "";
		String str_cust_code = "";
		String str_doc_ref = "";
		String str_doc_start_date = "";
		String str_doc_end_date = "";

		String err_level = "";
		String sys_message_id = "";
		String err_text = "";

		String mother_patient_id = "";

		String apptrefno = "";
		String bookingrefno = "";
		String str_appt_bkng_ref_no = "";
		String str_appt_bkng_episode_type = "";

		// Added for incorporating the Billing Classification Requirement
		String str_class_type = "";
		String str_class_code = "";
		String str_ref_no = "";
		String str_inc_asset_ind = "";
		String str_ind_inc = "";
		String str_ind_inc_freq = "";
		String str_spouse_inc = "";
		String str_spouse_inc_freq = "";
		String str_dependent_inc = "";
		String str_dependent_inc_freq = "";
		String str_valid_from = "";
		String str_valid_to = "";
		String str_last_date = "";
		String str_remarks = "";
		String str_social_pensioner_id = "";

		/* ************************************************************** */
		// int strAcctSeqNo=1;
		int noofdecimal = 2;

		String str_pat_ser_code = "";

		HashMap hosp_dtls = null;
		String hosp_serv_panel_ind = "";
		String hosp_serv_panel_code = "";
		String hosp_serv_panel_str = "";
		String hosp_serv_panel_qty = "1.0";
		String hosp_serv_charge_amt = "";

		String strNewHospChrgCreate = "Y";
		String str_pat_reg_charged_YN = "N";

		String str_total_chrg_amt = "";
		String str_total_pat_chrg_amt = "";
		double total_chrg_amt = 0.0;
		double total_pat_chrg_amt = 0.0;

		String hosp_charge_YN = "";

		double hosp_chrg_amt = 0.0;
		double hosp_chrg_pat_amt = 0.0;

		String str_hosp_chrg_amt = "";
		String str_hosp_chrg_pat_amt = "";

		String strFinalMessage = "";
		String bill_gen_yn = "";
		String bill_doc_type = "";
		String bill_doc_number = "";

		String str_bill_later_YN = "N";
		String str_bill_gen_later = "N";
		String str_total_bill_amt = "";

		String str_bill_prt_format_YN = "N";
		String str_bill_prt_format_vals = "";
		String pgm_id = "";
		String session_id = "";
		String pgm_date = "";
		String mpi_id_rep = "";

		String strModuleId = "MP";
		String pat_regn_prev_date = "";
		String pat_regn_date_time = "";

		String patientId = "";
		/* ************************************************************** */

		// -------------------------------------------------------------------------------------------------

		try {
			// System.err.println("tabdata:"+tabdata);
			locale = (String) insert_values.get("locale");
			if (locale == null)
				locale = "";
			strFunctionId = (String) tabdata.get("calling_function_id");
			if (strFunctionId == null) {
				strFunctionId = "PAT_REG";
			}

			if (strFunctionId.equals("")) {
				strFunctionId = "PAT_REG";
			}

			// System.err.println("strFunctionId MPINF:"+strFunctionId);

			strFacilityId = (String) tabdata.get("facility_id");
			if (strFacilityId == null)
				strFacilityId = "";

			String episode_type = (String) tabdata.get("episode_type");

			if ((episode_type == null) || (episode_type.equals("")))
				// episode_type = "O";
				episode_type = "R";

			java.util.Locale loc = new java.util.Locale(locale);

			java.util.ResourceBundle bl_labels = java.util.ResourceBundle
					.getBundle("eBL.resources.Labels", loc);
			java.util.ResourceBundle common_labels = java.util.ResourceBundle
					.getBundle("eCommon.resources.Labels", loc);

			String pat_reg_chrg_leg = bl_labels
					.getString("eBL.PAT_REG_CHRG.label");
			String bill_gen_yn_leg = bl_labels
					.getString("eBL.PAT_REG_CHARGE_BILL_GEN.label");
			String patient_payable_leg = common_labels
					.getString("Common.PatientPayable.label");

			mother_patient_id = (String) tabdata.get("mother_patient_id");
			if (mother_patient_id == null)
				mother_patient_id = "";

			apptrefno = (String) tabdata.get("apptrefno");
			if (apptrefno == null)
				apptrefno = "";

			bookingrefno = (String) tabdata.get("bookingrefno");
			if (bookingrefno == null)
				bookingrefno = "";

			// System.err.println("apptrefno:"+apptrefno);
			// System.err.println("bookingrefno:"+bookingrefno);

			if (!apptrefno.equals("")) {
				str_appt_bkng_ref_no = apptrefno;
				str_appt_bkng_episode_type = "A";
			}

			if (!bookingrefno.equals("")) {
				str_appt_bkng_ref_no = bookingrefno;
				str_appt_bkng_episode_type = "B";
			}

			// System.err.println("str_appt_bkng_ref_no:"+str_appt_bkng_ref_no);
			// System.err.println("str_appt_bkng_episode_type:"+str_appt_bkng_episode_type);

			/*
			 * String str_annual_income = (String)tabdata.get("annual_income");
			 * if (str_annual_income==null) str_annual_income = "0";
			 * 
			 * String str_family_asset = (String)tabdata.get("family_asset"); if
			 * (str_family_asset==null) str_family_asset = "0";
			 * 
			 * String str_no_of_dependants =
			 * (String)tabdata.get("no_of_dependants"); if
			 * (str_no_of_dependants==null) str_no_of_dependants = "0";
			 * 
			 * try { annual_income = Double.parseDouble(str_annual_income);
			 * family_asset = Double.parseDouble(str_family_asset);
			 * no_of_dependants = Integer.parseInt(str_no_of_dependants); }
			 * catch(Exception e) { sb.append("Error in conversion "+e); }
			 */
			try {
				String no_of_decimal = "select nvl(no_of_decimal,2) from  sm_acc_entity_param";
				st = con.createStatement();
				rs = st.executeQuery(no_of_decimal);
				if (rs != null) {
					while (rs.next()) {
						noofdecimal = rs.getInt(1);
					}
				}
				st.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				System.err.println("Exception in No of Decimal Query="
						+ e.toString());
			}

			try {
				String bill_gen_later_YN_qry = "select nvl(ADHOC_DISCOUNT_ALLOWED_YN,'N') from  bl_parameters where operating_facility_id='"
						+ (String) tabdata.get("facility_id") + "'";
				st = con.createStatement();
				rs = st.executeQuery(bill_gen_later_YN_qry);
				if (rs != null) {
					while (rs.next()) {
						str_bill_later_YN = rs.getString(1);
					}
				}
				if (str_bill_later_YN == null)
					str_bill_later_YN = "N";
				// System.out.println("str_bill_later_YN:"+str_bill_later_YN);
				st.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				System.out
						.println("Exception in No of bill_gen_later_YN_qry Query="
								+ e.toString());
			}

			String strNull = "";

			statement = con
					.prepareCall("{call blaudit.proc_store_old_values( ?,?,?,?,?,?,?,?,?,?,?,?)}");
			statement.setString(1, (String) tabdata.get("patient_id_new"));
			statement.setString(2, (String) tabdata.get("facility_id"));

			statement.setString(3, "MP");
			statement.setString(4, strFunctionId); // Function Id

			// statement.setString( 5, "O"); // Episode Type
			statement.setString(5, episode_type); // Episode Type
			statement.setLong(6, 0);
			statement.setInt(7, 0);
			statement.setString(8, "P"); // Trn. Type
			statement.setString(9, (String) tabdata.get("credit_auth_user_id")); // Authorized
																					// by
			statement.registerOutParameter(10, java.sql.Types.VARCHAR);
			statement.registerOutParameter(11, java.sql.Types.VARCHAR);
			statement.registerOutParameter(12, java.sql.Types.VARCHAR);
			statement.execute();

			err_level = statement.getString(10);
			sys_message_id = statement.getString(11);
			err_text = statement.getString(12);

			// System.err.println("err_level in proc_store_old_values:"+err_level);
			// System.err.println("sys_message_id in proc_store_old_values:"+sys_message_id);
			// System.err.println("err_text in proc_store_old_values:"+err_text);

			if (sys_message_id != null) {
				if (!(sys_message_id.equals(""))
						|| !(sys_message_id.equalsIgnoreCase("null"))) {
					insertable = false;
					messageHashtable = MessageManager.getMessage(locale,
							sys_message_id, "BL");
					sb.append("Exception while calling procedure BLAUDIT :"
							+ (String) messageHashtable.get("message"));
					messageHashtable.clear();
				}

			}
			if ((err_text != null)) {
				if (!(err_text.equals(""))
						|| !(err_text.equalsIgnoreCase("null"))) {
					insertable = false;
					sb.append("Exception while calling procedure BLAUDIT :"
							+ err_text);
				}

			}

			statement.close();

			if (insertable) {

				/*
				 * String sql = "{call INS_UPD_BL_PAT_FIN_DTLS( '" + (String)
				 * insert_values.get("operation_mode") + "'," + "'" +
				 * ((String)insert_values.get("patient_id_new")) + "'," + "'" +
				 * (String)insert_values.get("billing_group") + "'," + "'" +
				 * (String)insert_values.get("billing_class") + "'," + "'" +
				 * (String)insert_values.get("employer_code") + "'," + "'" +
				 * (String)insert_values.get("setlmt_ind") + "'," + "'" +
				 * (String)insert_values.get("credit_doc_ref_desc") + "'," +
				 * "to_date('" + (String)insert_values.get("credit_doc_date") +
				 * "','dd/mm/yyyy')," + "'" +
				 * (String)insert_values.get("cust_code") + "'," + "'" +
				 * (String)insert_values.get("slmt_type_code") + "'," + "'" +
				 * (String)insert_values.get("slmt_doc_ref_desc") + "'," +
				 * "to_date('" + (String)insert_values.get("slmt_doc_ref_date")
				 * + "','dd/mm/yyyy')," + "'" +
				 * (String)insert_values.get("slmt_doc_remarks") + "'," + "'" +
				 * (String)insert_values.get("remarks") + "'," + "'" +
				 * (String)insert_values.get("policy_type") + "'," + "'" +
				 * (String)insert_values.get("policy_no") + "'," + "to_date('" +
				 * (String)insert_values.get("policy_expiry_date") +
				 * "','dd/mm/yyyy')," + "'" +
				 * (String)insert_values.get("non_insur_blng_grp") + "'," + "'"
				 * + (String)insert_values.get("cust_4") + "'," + "" +
				 * annual_income+ "," + "" + family_asset + "," + "" +
				 * no_of_dependants + "," + "'" +
				 * (String)insert_values.get("resp_for_payment") + "'," + "'" +
				 * (String)insert_values.get("added_by_id") + "'," + "'" +
				 * (String)insert_values.get("facility_id") + "'," + "'" +
				 * (String)insert_values.get("added_at_ws_no") + "'," + "'" +
				 * (String)insert_values.get("GL_HOLDER_NAME") + "'," + "'" +
				 * (String)insert_values.get("GL_HOLDER_RELN") + "',to_date(" +
				 * "'" + (String)insert_values.get("CRED_START_DT") +
				 * "','dd/mm/yyyy')," + "?" + ")}";
				 */

				// String returnedString=(String)insert_values.get("fin_dtls");
				HashMap billing_data = (HashMap) insert_values.get("fin_dtls");
				// System.err.println("billng_data in bean is:"+billing_data);

				/*
				 * StringTokenizer st=new StringTokenizer(returnedString,"~");
				 * System.err.println("String Tokens size :"+st.countTokens());
				 * System.err.println("String Token elements :"+st); ArrayList
				 * al=new ArrayList();
				 * 
				 * while(st.hasMoreTokens()) { String
				 * temp=(String)st.nextToken(); if(temp.equals("")) {
				 * System.err.println("inside if loop"); al.add(" "); } else
				 * al.add(temp); }
				 * System.err.println("Arrylist elements are:"+al);
				 * System.err.println("Arrylist size is:"+al.size());
				 */

				/*
				 * String str_blng_grp=((String)al.get(0)).trim(); String
				 * str_slmt_ind=((String)al.get(1)).trim(); String
				 * str_credit_doc_reqd_yn=((String)al.get(2)).trim(); String
				 * str_blng_class=((String)al.get(3)).trim(); String
				 * str_emp_code=((String)al.get(4)).trim(); String
				 * str_slmt_type_code=((String)al.get(5)).trim();
				 * System.err.println("7.1"); String
				 * str_inst_ref=((String)al.get(6)).trim();
				 * System.err.println("7.1.1"); String
				 * str_inst_date=((String)al.get(7)).trim();
				 * System.err.println("7.1.2"); String
				 * str_inst_remarks=((String)al.get(8)).trim(); String
				 * str_credit_cust_code=((String)al.get(9)).trim(); String
				 * str_credit_doc_ref=((String)al.get(10)).trim();
				 * System.err.println("7.2"); String
				 * str_credit_doc_start_date=((String)al.get(11)).trim(); String
				 * str_credit_doc_end_date=((String)al.get(12)).trim(); String
				 * str_sponsor_cust_code=((String)al.get(13)).trim(); String
				 * str_sponsor_credit_doc_ref=((String)al.get(14)).trim();
				 * String
				 * str_sponsor_credit_doc_start_date=((String)al.get(15)).
				 * trim(); String
				 * str_sponsor_credit_doc_end_date=((String)al.get(16)).trim();
				 * System.err.println("7.3"); String
				 * str_ins_cust_code=((String)al.get(17)).trim(); String
				 * str_ins_cust_priority=((String)al.get(18)).trim(); String
				 * str_ins_policy_type_code=((String)al.get(19)).trim(); String
				 * str_ins_policy_no=((String)al.get(20)).trim();
				 * System.err.println("7.4"); String
				 * str_ins_policy_start_date=((String)al.get(21)).trim(); String
				 * str_ins_policy_expiry_date=((String)al.get(22)).trim();
				 * String str_ins_credit_auth_ref=((String)al.get(23)).trim();
				 * String str_ins_credit_auth_date=((String)al.get(24)).trim();
				 * System.err.println("7.5"); String
				 * str_ins_credit_approval_days=((String)al.get(25)).trim();
				 * //integer // if (str_ins_credit_approval_days.equals(""))
				 * str_ins_credit_approval_days = "0"; String
				 * str_ins_credit_approval_amount=((String)al.get(26)).trim();
				 * //double // if (str_ins_credit_approval_amount.equals(""))
				 * str_ins_credit_approval_amount = "0"; String
				 * str_ins_policy_eff_from_date=((String)al.get(27)).trim();
				 * String
				 * str_ins_policy_eff_to_date=((String)al.get(28)).trim();
				 * String str_ins_adj_rule_ind=((String)al.get(29)).trim();
				 * String str_ins_adj_perc_amt_ind=((String)al.get(30)).trim();
				 * System.err.println("7.6"); String
				 * str_ins_adj_perc_amt_value=((String)al.get(31)).trim();
				 * //double // if (str_ins_adj_perc_amt_value.equals(""))
				 * str_ins_adj_perc_amt_value = "0"; String
				 * str_ins_pmnt_diff_adj_int=((String)al.get(32)).trim(); String
				 * str_ins_drg_pmnt_diff_adj_int=((String)al.get(33)).trim();
				 * String
				 * str_ins_spl_srv_pmnt_diff_adj_int=((String)al.get(34)).
				 * trim(); String
				 * str_non_ins_blng_grp=((String)al.get(35)).trim();
				 * System.err.println("7.7"); String
				 * str_non_ins_credit_doc_reqd_yn=((String)al.get(36)).trim();
				 * String
				 * str_non_ins_slmt_type_code=((String)al.get(37)).trim();
				 * String str_non_ins_inst_ref=((String)al.get(38)).trim();
				 * String str_non_ins_inst_date=((String)al.get(39)).trim();
				 * String str_non_ins_inst_remarks=((String)al.get(40)).trim();
				 * System.err.println("7.8"); String
				 * str_non_ins_cust_code=((String)al.get(41)).trim(); String
				 * str_non_ins_credit_doc_ref=((String)al.get(42)).trim();
				 * String
				 * str_non_ins_credit_doc_start_date=((String)al.get(43)).
				 * trim(); String
				 * str_non_ins_credit_doc_end_date=((String)al.get(44)).trim();
				 * System.err.println("7.9"); String
				 * str_annual_income=((String)al.get(45)).trim(); //doble if
				 * (str_annual_income.equals("")) str_annual_income = "0";
				 * System.err.println("7.10"); String
				 * str_family_asset=((String)al.get(46)).trim(); //double if
				 * (str_family_asset.equals("")) str_family_asset = "0";
				 * System.err.println("7.11"); String
				 * str_no_of_dependants=((String)al.get(47)).trim(); //int if
				 * (str_no_of_dependants.equals("")) str_no_of_dependants = "0";
				 * System.err.println("7.12"); String
				 * str_resp_for_payment=((String)al.get(48)).trim(); String
				 * str_pat_reln_with_resp_person=((String)al.get(49)).trim();
				 * String str_fin_remarks=((String)al.get(50)).trim(); String
				 * str_gl_holder_name=((String)al.get(51)).trim(); String
				 * str_pat_reln_with_gl_holder=((String)al.get(52)).trim();
				 * String
				 * str_upd_patient_fin_dtls_yn=((String)al.get(53)).trim();
				 * String str_user_id=((String)al.get(54)).trim(); String
				 * str_fin_auth_user_id=((String)al.get(55)).trim(); String
				 * str_calling_function_id=((String)al.get(56)).trim();
				 */
				if (billing_data != null) {

					patientId = (String) tabdata.get("patient_id_new");
					if (patientId == null)
						patientId = "";
					System.out.println("patientId " + patientId);
					str_blng_grp = (String) billing_data.get("blng_grp");
					if (str_blng_grp == null)
						str_blng_grp = "";

					str_slmt_ind = (String) billing_data.get("slmt_ind");
					if (str_slmt_ind == null)
						str_slmt_ind = "";

					str_credit_doc_reqd_yn = (String) billing_data
							.get("credit_doc_reqd_yn");
					if (str_credit_doc_reqd_yn == null)
						str_credit_doc_reqd_yn = "";

					str_blng_class = (String) billing_data.get("blng_class");
					if (str_blng_class == null)
						str_blng_class = "";

					if (str_blng_class.equals("")) {
						str_blng_class = (String) insert_values
								.get("dflt_pat_regn_blng_class");
						if (str_blng_class == null)
							str_blng_class = "";
					}

					str_emp_code = (String) billing_data.get("emp_code");
					if (str_emp_code == null)
						str_emp_code = "";

					str_slmt_type_code = (String) billing_data
							.get("slmt_type_code");
					if (str_slmt_type_code == null)
						str_slmt_type_code = "";

					str_inst_ref = (String) billing_data.get("inst_ref");
					if (str_inst_ref == null)
						str_inst_ref = "";

					str_inst_date = (String) billing_data.get("inst_date");
					if (str_inst_date == null)
						str_inst_date = "";

					str_inst_remarks = (String) billing_data
							.get("inst_remarks");
					if (str_inst_remarks == null)
						str_inst_remarks = "";

					str_credit_cust_group_code = (String) billing_data
							.get("credit_cust_group_code");
					if (str_credit_cust_group_code == null)
						str_credit_cust_group_code = "";

					str_credit_cust_code = (String) billing_data
							.get("credit_cust_code");
					if (str_credit_cust_code == null)
						str_credit_cust_code = "";

					str_credit_doc_ref = (String) billing_data
							.get("credit_doc_ref");
					if (str_credit_doc_ref == null)
						str_credit_doc_ref = "";

					str_credit_doc_start_date = (String) billing_data
							.get("credit_doc_start_date");
					if (str_credit_doc_start_date == null)
						str_credit_doc_start_date = "";

					str_credit_doc_end_date = (String) billing_data
							.get("credit_doc_end_date");
					if (str_credit_doc_end_date == null)
						str_credit_doc_end_date = "";

					str_sponsor_cust_group_code = (String) billing_data
							.get("sponsor_cust_group_code");
					if (str_sponsor_cust_group_code == null)
						str_sponsor_cust_group_code = "";

					str_sponsor_cust_code = (String) billing_data
							.get("sponsor_cust_code");
					if (str_sponsor_cust_code == null)
						str_sponsor_cust_code = "";

					str_sponsor_credit_doc_ref = (String) billing_data
							.get("sponsor_credit_doc_ref");
					if (str_sponsor_credit_doc_ref == null)
						str_sponsor_credit_doc_ref = "";

					str_sponsor_credit_doc_start_date = (String) billing_data
							.get("sponsor_credit_doc_start_date");
					if (str_sponsor_credit_doc_start_date == null)
						str_sponsor_credit_doc_start_date = "";

					str_sponsor_credit_doc_end_date = (String) billing_data
							.get("sponsor_credit_doc_end_date");
					if (str_sponsor_credit_doc_end_date == null)
						str_sponsor_credit_doc_end_date = "";

					str_ins_blng_grp = (String) billing_data
							.get("ins_blng_grp");
					if (str_ins_blng_grp == null)
						str_ins_blng_grp = "";

					str_ins_cust_group_code = (String) billing_data
							.get("ins_cust_group_code");
					if (str_ins_cust_group_code == null)
						str_ins_cust_group_code = "";

					str_ins_cust_code = (String) billing_data
							.get("ins_cust_code");
					if (str_ins_cust_code == null)
						str_ins_cust_code = "";

					str_ins_cust_priority = (String) billing_data
							.get("ins_cust_priority");
					if (str_ins_cust_priority == null)
						str_ins_cust_priority = "";

					str_ins_policy_type_code = (String) billing_data
							.get("ins_policy_type_code");
					if (str_ins_policy_type_code == null)
						str_ins_policy_type_code = "";

					str_ins_policy_no = (String) billing_data
							.get("ins_policy_no");
					if (str_ins_policy_no == null)
						str_ins_policy_no = "";

					str_ins_policy_start_date = (String) billing_data
							.get("ins_policy_start_date");
					if (str_ins_policy_start_date == null)
						str_ins_policy_start_date = "";

					str_ins_policy_expiry_date = (String) billing_data
							.get("ins_policy_expiry_date");
					if (str_ins_policy_expiry_date == null)
						str_ins_policy_expiry_date = "";

					str_ins_credit_auth_ref = (String) billing_data
							.get("ins_credit_auth_ref");
					if (str_ins_credit_auth_ref == null)
						str_ins_credit_auth_ref = "";

					str_ins_credit_auth_date = (String) billing_data
							.get("ins_credit_auth_date");
					if (str_ins_credit_auth_date == null)
						str_ins_credit_auth_date = "";

					str_ins_credit_approval_days = (String) billing_data
							.get("ins_credit_approval_days"); // integer
					if (str_ins_credit_approval_days == null)
						str_ins_credit_approval_days = "";
					// if (str_ins_credit_approval_days.equals(""))
					// str_ins_credit_approval_days = "0";

					str_ins_credit_approval_amount = (String) billing_data
							.get("ins_credit_approval_amount"); // double
					if (str_ins_credit_approval_amount == null)
						str_ins_credit_approval_amount = "";
					// if (str_ins_credit_approval_amount.equals(""))
					// str_ins_credit_approval_amount = "0";

					str_ins_policy_eff_from_date = (String) billing_data
							.get("ins_policy_eff_from_date");
					if (str_ins_policy_eff_from_date == null)
						str_ins_policy_eff_from_date = "";

					str_ins_policy_eff_to_date = (String) billing_data
							.get("ins_policy_eff_to_date");
					if (str_ins_policy_eff_to_date == null)
						str_ins_policy_eff_to_date = "";

					str_ins_adj_rule_ind = (String) billing_data
							.get("ins_adj_rule_ind");
					if (str_ins_adj_rule_ind == null)
						str_ins_adj_rule_ind = "";

					str_ins_adj_perc_amt_ind = (String) billing_data
							.get("ins_adj_perc_amt_ind");
					if (str_ins_adj_perc_amt_ind == null)
						str_ins_adj_perc_amt_ind = "";

					str_ins_adj_perc_amt_value = (String) billing_data
							.get("ins_adj_perc_amt_value"); // double
					if (str_ins_adj_perc_amt_value == null)
						str_ins_adj_perc_amt_value = "";
					// if (str_ins_adj_perc_amt_value.equals(""))
					// str_ins_adj_perc_amt_value = "0";

					str_ins_pmnt_diff_adj_int = (String) billing_data
							.get("ins_pmnt_diff_adj_int");
					if (str_ins_pmnt_diff_adj_int == null)
						str_ins_pmnt_diff_adj_int = "";

					str_ins_drg_pmnt_diff_adj_int = (String) billing_data
							.get("ins_drg_pmnt_diff_adj_int");
					if (str_ins_drg_pmnt_diff_adj_int == null)
						str_ins_drg_pmnt_diff_adj_int = "";

					str_ins_spl_srv_pmnt_diff_adj_int = (String) billing_data
							.get("ins_spl_srv_pmnt_diff_adj_int");
					if (str_ins_spl_srv_pmnt_diff_adj_int == null)
						str_ins_spl_srv_pmnt_diff_adj_int = "";

					str_non_ins_blng_grp = (String) billing_data
							.get("non_ins_blng_grp");
					if (str_non_ins_blng_grp == null)
						str_non_ins_blng_grp = "";

					str_non_ins_credit_doc_reqd_yn = (String) billing_data
							.get("non_ins_credit_doc_reqd_yn");
					if (str_non_ins_credit_doc_reqd_yn == null)
						str_non_ins_credit_doc_reqd_yn = "";

					str_non_ins_slmt_type_code = (String) billing_data
							.get("non_ins_slmt_type_code");
					if (str_non_ins_slmt_type_code == null)
						str_non_ins_slmt_type_code = "";

					str_non_ins_inst_ref = (String) billing_data
							.get("non_ins_inst_ref");
					if (str_non_ins_inst_ref == null)
						str_non_ins_inst_ref = "";

					str_non_ins_inst_date = (String) billing_data
							.get("non_ins_inst_date");
					if (str_non_ins_inst_date == null)
						str_non_ins_inst_date = "";

					str_non_ins_inst_remarks = (String) billing_data
							.get("non_ins_inst_remarks");
					if (str_non_ins_inst_remarks == null)
						str_non_ins_inst_remarks = "";

					str_non_ins_cust_group_code = (String) billing_data
							.get("non_ins_cust_group_code");
					if (str_non_ins_cust_group_code == null)
						str_non_ins_cust_group_code = "";

					str_non_ins_cust_code = (String) billing_data
							.get("non_ins_cust_code");
					if (str_non_ins_cust_code == null)
						str_non_ins_cust_code = "";

					str_non_ins_credit_doc_ref = (String) billing_data
							.get("non_ins_credit_doc_ref");
					if (str_non_ins_credit_doc_ref == null)
						str_non_ins_credit_doc_ref = "";

					str_non_ins_credit_doc_start_date = (String) billing_data
							.get("non_ins_credit_doc_start_date");
					if (str_non_ins_credit_doc_start_date == null)
						str_non_ins_credit_doc_start_date = "";

					str_non_ins_credit_doc_end_date = (String) billing_data
							.get("non_ins_credit_doc_end_date");
					if (str_non_ins_credit_doc_end_date == null)
						str_non_ins_credit_doc_end_date = "";

					str_annual_income = (String) billing_data
							.get("annual_income"); // doble
					if (str_annual_income == null)
						str_annual_income = "";
					if (str_annual_income.equals(""))
						str_annual_income = "0";

					str_family_asset = (String) billing_data
							.get("family_asset"); // double
					if (str_family_asset == null)
						str_family_asset = "";
					if (str_family_asset.equals(""))
						str_family_asset = "0";

					str_no_of_dependants = (String) billing_data
							.get("no_of_dependants"); // int
					if (str_no_of_dependants == null)
						str_no_of_dependants = "";
					if (str_no_of_dependants.equals(""))
						str_no_of_dependants = "0";

					str_resp_for_payment = (String) billing_data
							.get("resp_for_payment");
					if (str_resp_for_payment == null)
						str_resp_for_payment = "";

					str_pat_reln_with_resp_person = (String) billing_data
							.get("pat_reln_with_resp_person");
					if (str_pat_reln_with_resp_person == null)
						str_pat_reln_with_resp_person = "";

					str_fin_remarks = (String) billing_data.get("fin_remarks");
					if (str_fin_remarks == null)
						str_fin_remarks = "";

					str_gl_holder_name = (String) billing_data
							.get("gl_holder_name");
					if (str_gl_holder_name == null)
						str_gl_holder_name = "";

					//ML-MMOH-SCF-2459 Starts
					System.out.println("str_gl_holder_name before replace MP=>"+str_gl_holder_name);
					if(!str_gl_holder_name.equals("")){
						str_gl_holder_name = str_gl_holder_name.replace("'", "''");
					}
					System.out.println("str_gl_holder_name after replace MP=>"+str_gl_holder_name);
					//ML-MMOH-SCF-2459 ends
					
					str_pat_reln_with_gl_holder = (String) billing_data
							.get("pat_reln_with_gl_holder");
					if (str_pat_reln_with_gl_holder == null)
						str_pat_reln_with_gl_holder = "";

					str_ref_src_main_code = (String) billing_data
							.get("ref_src_main_code");
					if (str_ref_src_main_code == null)
						str_ref_src_main_code = "";

					str_ref_src_sub_code = (String) billing_data
							.get("ref_src_sub_code");
					if (str_ref_src_sub_code == null)
						str_ref_src_sub_code = "";

					str_ins_ref_src_main_code = (String) billing_data
							.get("ins_ref_src_main_code");
					if (str_ins_ref_src_main_code == null)
						str_ins_ref_src_main_code = "";
					// System.err.println("str_ins_ref_src_main_code:"+str_ins_ref_src_main_code);

					str_ins_ref_src_sub_code = (String) billing_data
							.get("ins_ref_src_sub_code");
					if (str_ins_ref_src_sub_code == null)
						str_ins_ref_src_sub_code = "";
					// System.err.println("str_ins_ref_src_sub_code:"+str_ins_ref_src_sub_code);

					str_non_ins_ref_src_main_code = (String) billing_data
							.get("non_ins_ref_src_main_code");
					if (str_non_ins_ref_src_main_code == null)
						str_non_ins_ref_src_main_code = "";
					// System.err.println("str_non_ins_ref_src_main_code:"+str_non_ins_ref_src_main_code);

					str_non_ins_ref_src_sub_code = (String) billing_data
							.get("non_ins_ref_src_sub_code");
					if (str_non_ins_ref_src_sub_code == null)
						str_non_ins_ref_src_sub_code = "";
					// System.err.println("str_non_ins_ref_src_sub_code:"+str_non_ins_ref_src_sub_code);

					str_upd_patient_fin_dtls_yn = (String) billing_data
							.get("upd_patient_fin_dtls_yn");
					if (str_upd_patient_fin_dtls_yn == null)
						str_upd_patient_fin_dtls_yn = "";

					str_user_id = (String) billing_data.get("user_id");
					if (str_user_id == null)
						str_user_id = "";

					str_fin_auth_user_id = (String) billing_data
							.get("fin_auth_user_id");
					if (str_fin_auth_user_id == null)
						str_fin_auth_user_id = "";

					str_calling_function_id = (String) billing_data
							.get("calling_function_id");
					if (str_calling_function_id == null)
						str_calling_function_id = "";
					// System.err.println("str_calling_function_id:"+str_calling_function_id);

					str_pat_ser_code = (String) billing_data
							.get("pat_ser_code");
					if (str_pat_ser_code == null)
						str_pat_ser_code = "";

					// Added for incorporating the Billing Classification
					// Requirement
					str_class_type = (String) billing_data.get("class_type");
					if (str_class_type == null)
						str_class_type = "";

					str_class_code = (String) billing_data.get("class_code");
					if (str_class_code == null)
						str_class_code = "";

					str_ref_no = (String) billing_data.get("ref_no");
					if (str_ref_no == null)
						str_ref_no = "";

					str_inc_asset_ind = (String) billing_data
							.get("inc_asset_ind");
					if (str_inc_asset_ind == null)
						str_inc_asset_ind = "";

					str_ind_inc = (String) billing_data.get("ind_inc");
					if (str_ind_inc == null)
						str_ind_inc = "";

					str_ind_inc_freq = (String) billing_data
							.get("ind_inc_freq");
					if (str_ind_inc_freq == null)
						str_ind_inc_freq = "";

					str_spouse_inc = (String) billing_data.get("spouse_inc");
					if (str_spouse_inc == null)
						str_spouse_inc = "";

					str_spouse_inc_freq = (String) billing_data
							.get("spouse_inc_freq");
					if (str_spouse_inc_freq == null)
						str_spouse_inc_freq = "";

					str_dependent_inc = (String) billing_data
							.get("dependent_inc");
					if (str_dependent_inc == null)
						str_dependent_inc = "";

					str_dependent_inc_freq = (String) billing_data
							.get("dependent_inc_freq");
					if (str_dependent_inc_freq == null)
						str_dependent_inc_freq = "";

					str_valid_from = (String) billing_data.get("valid_from");
					if (str_valid_from == null)
						str_valid_from = "";

					str_valid_to = (String) billing_data.get("valid_to");
					if (str_valid_to == null)
						str_valid_to = "";

					str_last_date = (String) billing_data.get("last_date");
					if (str_last_date == null)
						str_last_date = "";

					str_remarks = (String) billing_data.get("remarks");
					if (str_remarks == null)
						str_remarks = "";

					str_social_pensioner_id = (String) billing_data
							.get("social_pensioner_id");
					if (str_social_pensioner_id == null)
						str_social_pensioner_id = "";
					/* ************************************************************************************* */

					str_acct_seq_eff_from_date = "";
					str_acct_seq_eff_to_date = "";

					str_cust_group_code = "";
					str_cust_code = "";
					str_doc_ref = "";
					str_doc_start_date = "";
					str_doc_end_date = "";

					try {
						// ins_credit_approval_days=Integer.parseInt(str_ins_credit_approval_days);
						// ins_credit_approval_amount=Double.parseDouble(str_ins_credit_approval_amount);
						// ins_adj_perc_amt_value=Double.parseDouble(str_ins_adj_perc_amt_value);
						annual_income = Double.parseDouble(str_annual_income);
						family_asset = Double.parseDouble(str_family_asset);
						no_of_dependants = Integer
								.parseInt(str_no_of_dependants);
					} catch (Exception e) {
						sb.append("Error in conversion " + e);
					}

					if (str_slmt_ind.equals("R")) {
						str_cust_group_code = str_credit_cust_group_code;
						str_cust_code = str_credit_cust_code;
						str_doc_ref = str_credit_doc_ref;
						str_doc_start_date = str_credit_doc_start_date;
						str_doc_end_date = str_credit_doc_end_date;
					} else if (str_slmt_ind.equals("X")
							&& str_non_ins_blng_grp.equals("")) {
						str_cust_group_code = str_sponsor_cust_group_code;
						str_cust_code = str_sponsor_cust_code;
						str_doc_ref = str_sponsor_credit_doc_ref;
						str_doc_start_date = str_sponsor_credit_doc_start_date;
						str_doc_end_date = str_sponsor_credit_doc_end_date;
					} else if (str_slmt_ind.equals("X")
							&& !str_non_ins_blng_grp.equals("")) {
						str_blng_grp = str_ins_blng_grp;
						str_cust_group_code = str_ins_cust_group_code;
						str_cust_code = str_ins_cust_code;
						str_doc_ref = str_non_ins_credit_doc_ref;
						str_doc_start_date = str_non_ins_credit_doc_start_date;
						str_doc_end_date = str_non_ins_credit_doc_end_date;
						str_slmt_type_code = str_non_ins_slmt_type_code;
					} else {
						str_doc_ref = str_credit_doc_ref;
						str_doc_start_date = str_credit_doc_start_date;
						str_doc_end_date = str_credit_doc_end_date;
					}

					hosp_dtls = (HashMap) billing_data.get("hosp_dtls");

					if (hosp_dtls != null) {
						hosp_serv_panel_ind = (String) hosp_dtls
								.get("hosp_serv_panel_ind");
						hosp_serv_panel_code = (String) hosp_dtls
								.get("hosp_serv_panel_code");
						hosp_serv_panel_str = (String) hosp_dtls
								.get("hosp_serv_panel_str");
						hosp_serv_panel_qty = (String) hosp_dtls
								.get("hosp_serv_panel_qty");
						hosp_serv_charge_amt = (String) hosp_dtls
								.get("hosp_serv_chrg_amt");
					}

					// System.err.println("hosp_serv_panel_ind: " +
					// hosp_serv_panel_ind);
					// System.err.println("hosp_serv_panel_code: " +
					// hosp_serv_panel_code);
					// System.err.println("hosp_serv_panel_str: " +
					// hosp_serv_panel_str);
					// System.err.println("hosp_serv_panel_qty: " +
					// hosp_serv_panel_qty);
					// System.err.println("hosp_serv_charge_amt: " +
					// hosp_serv_charge_amt);
				} else {
					str_blng_grp = (String) insert_values.get("billing_group");
					str_blng_class = (String) insert_values
							.get("dflt_pat_regn_blng_class");
					str_calling_function_id = (String) tabdata
							.get("calling_function_id");
					if (str_calling_function_id == null)
						str_calling_function_id = "";
				}
				/*
				 * if(!(str_ref_src_main_code.equals("") &&
				 * str_ref_src_sub_code.equals(""))) {
				 * strFacilityId=strFacilityId
				 * +"|"+str_ref_src_main_code+"|"+str_ref_src_sub_code; }
				 */
				/*
				 * if(!str_ins_ref_src_main_code.equals("") &&
				 * !str_ins_ref_src_sub_code.equals("")) { str_blng_grp =
				 * str_blng_grp
				 * +"~"+str_ins_ref_src_main_code+"~"+str_ins_ref_src_sub_code;
				 * }
				 */
				// Karthik added the code to add claim code starts - IN50355

				String credit_authorisation_by = "";
				String claim_code = "";
				String membership_number = "";

				StringTokenizer tknCustGrpCode = new StringTokenizer(
						str_ins_cust_group_code, "|");
				StringTokenizer tknCustCode = new StringTokenizer(
						str_ins_cust_code, "|");
				StringTokenizer tknCustPriority = new StringTokenizer(
						str_ins_cust_priority, "|");
				StringTokenizer tknPolicyStartDate = new StringTokenizer(
						str_ins_policy_start_date, "|");
				StringTokenizer tknPolicyExpDate = new StringTokenizer(
						str_ins_policy_expiry_date, "|");
				StringTokenizer tknPolicyEffFromDate = new StringTokenizer(
						str_ins_policy_eff_from_date, "|");
				StringTokenizer tknPolicyNo = new StringTokenizer(
						str_ins_policy_no, "|");

				String custGrpCodeTmp = "";
				String custCodeTmp = "";
				String custPriority = "";
				String PolStrtDate = "";
				String PolExpDate = "";
				String polEffFromdate = "";
				String PolNo = "";
				String membershipNoTmp = "";

				if (billing_data != null) {
					credit_authorisation_by = (billing_data
							.get("credit_authorisation_by") == null ? ""
							: (String) billing_data
									.get("credit_authorisation_by"));
					claim_code = (billing_data.get("claim_code") == null ? ""
							: (String) billing_data.get("claim_code"));
					membership_number = (billing_data.get("membership_number") == null ? ""
							: (String) billing_data.get("membership_number"));
					if (membership_number == null
							|| "null".equals(membership_number)
							|| "".equals(membership_number)) {

						PreparedStatement pstmt = null;

						String sql = "SELECT claim_code, credit_auth_by, membership_no "
								+ " FROM bl_encounter_payer_priority "
								+ " WHERE patient_id = ? "
								+ " AND cust_group_code = ? "
								+ " AND cust_code = ? "
								+ " AND priority = ? and POLICY_START_DATE=to_date(?,'dd/mm/yyyy')  and POLICY_EXPIRY_DATE=to_date(?,'dd/mm/yyyy')  and EFFECTIVE_FROM=to_date(?,'dd/mm/yyyy')  and POLICY_NUMBER=? order by ACCT_SEQ_EFF_FROM_DATE desc";

						System.out.println("sql " + sql);

						while (tknCustPriority.hasMoreTokens()) {

							custGrpCodeTmp = tknCustGrpCode.nextToken();
							custCodeTmp = tknCustCode.nextToken();
							custPriority = tknCustPriority.nextToken();
							PolStrtDate = tknPolicyStartDate.nextToken();
							PolExpDate = tknPolicyExpDate.nextToken();
							polEffFromdate = tknPolicyEffFromDate.nextToken();
							PolNo = tknPolicyNo.nextToken();
							pstmt = con.prepareStatement(sql);

							pstmt.setString(1, patientId);
							pstmt.setString(2, custGrpCodeTmp);
							pstmt.setString(3, custCodeTmp);
							pstmt.setString(4, custPriority);
							pstmt.setString(5, PolStrtDate);
							pstmt.setString(6, PolExpDate);
							pstmt.setString(7, polEffFromdate);
							pstmt.setString(8, PolNo);
							rs = pstmt.executeQuery();
							if (rs.next()) {

								membershipNoTmp = rs.getString(3);
								membership_number += membershipNoTmp + "|";
								if (membership_number == null)
									membership_number = "";
								System.out.println("membership_number "
										+ membership_number);

							}
							if (rs != null)
								rs.close();
							if (pstmt != null)
								pstmt.close();

						}

					}
				}
				// Karthik added the code to add claim code ends - IN50355

				String sql = "{call BL_INS_UPD_PAT_FIN_DTLS( '"
						+ (String) insert_values.get("operation_mode") + "','"
						+ (String) insert_values.get("patient_id_new") + "','"
						+ str_blng_grp + "','" + str_ref_src_main_code + "','"
						+ str_ref_src_sub_code + "','" + str_blng_class + "','"
						+ str_emp_code + "','" + str_doc_ref + "',to_date('"
						+ str_doc_start_date + "','dd/mm/yyyy'),to_date('"
						+ str_doc_end_date + "','dd/mm/yyyy'),'"
						+ str_slmt_type_code + "','" + str_inst_ref
						+ "',to_date('" + str_inst_date + "','dd/mm/yyyy'),'"
						+ str_inst_remarks + "','" + str_ins_ref_src_main_code
						+ "','" + str_ins_ref_src_sub_code + "','"
						+ str_cust_group_code + "','" + str_cust_code + "','"
						+ str_ins_cust_priority + "','"
						+ str_ins_policy_type_code + "','" + str_ins_policy_no
						+ "','" + str_ins_policy_start_date + "','"
						+ str_ins_policy_expiry_date + "','"
						+ str_ins_credit_auth_ref + "','"
						+ str_ins_credit_auth_date + "','"
						+ str_ins_policy_eff_from_date + "','"
						+ str_ins_policy_eff_to_date + "','"
						+ str_ins_credit_approval_amount + "','"
						+ str_ins_credit_approval_days + "','"
						+ str_ins_adj_rule_ind + "','"
						+ str_ins_adj_perc_amt_ind + "','"
						+ str_ins_adj_perc_amt_value + "','"
						+ str_ins_pmnt_diff_adj_int + "','"
						+ str_ins_drg_pmnt_diff_adj_int + "','"
						+ str_ins_spl_srv_pmnt_diff_adj_int + "','"
						+ str_non_ins_blng_grp + "','"
						+ str_non_ins_ref_src_main_code + "','"
						+ str_non_ins_ref_src_sub_code + "','"
						+ str_non_ins_cust_group_code + "','"
						+ str_non_ins_cust_code + "','" + annual_income + "','"
						+ family_asset + "','" + no_of_dependants + "','"
						+ str_resp_for_payment + "','"
						+ str_pat_reln_with_resp_person + "','"
						+ str_gl_holder_name + "','"
						+ str_pat_reln_with_gl_holder + "','"
						+ (String) insert_values.get("added_by_id") + "','"
						+ strFacilityId + "','"
						+ (String) insert_values.get("added_at_ws_no") + "','"
						+ str_fin_remarks + "','" + str_fin_auth_user_id
						+ "','" + strFunctionId + "',to_date('"
						+ str_acct_seq_eff_from_date
						+ "','dd/mm/yyyy'),to_date('"
						+ str_acct_seq_eff_to_date + "','dd/mm/yyyy'),'"
						+ mother_patient_id + "','" + credit_authorisation_by
						+ "','" + claim_code + "',?,?,?,?)}";
				// System.err.println("The Sql is:"+sql);

				statement = con.prepareCall(sql);

				// statement.registerOutParameter(1, 12);
				statement.setString(1, membership_number); // membership_number
				statement.registerOutParameter(2, java.sql.Types.VARCHAR);
				statement.registerOutParameter(3, java.sql.Types.VARCHAR);
				statement.registerOutParameter(4, java.sql.Types.VARCHAR);

				statement.execute();

				insertable = true;

				// String strOutput = statement.getString(1);
				err_level = statement.getString(2);
				sys_message_id = statement.getString(3);
				err_text = statement.getString(4);

				if (err_level == null)
					err_level = "";
				if (sys_message_id == null)
					sys_message_id = "";
				if (err_text == null)
					err_text = "";

				// System.err.println("err_level:"+err_level);
				// System.err.println("sys_message_id:"+sys_message_id);
				// System.err.println("err_text:"+err_text);
				/*
				 * if(!strOutput.equals("0")) { int j = strOutput.indexOf("**");
				 * insertable = false; if(j != -1) sb.append("<br>" + strOutput
				 * + "<br> "); else sb.append("Error Updating bl_pat_fin_dtls");
				 * } statement.close(); }
				 * 
				 * strErrCode = ""; strSysMessg = ""; strErrText = "";
				 */

				if ((!sys_message_id.equals(""))
						|| (err_level.equals("10") && !err_text.equals("")))

				{

					// int chk_code=err_code.indexOf("**");
					insertable = false;
					// debug_buffer.append("<br> here in err Code");

					if ((err_level.equals("10") && !err_text.equals(""))) {
						sb.append("<br>" + err_text + "<br> ");
						// System.err.println("sb mesage is:"+sb);
					} else {
						messageHashtable = MessageManager.getMessage(locale,
								sys_message_id, "BL");
						sb.append((String) messageHashtable.get("message"));
						// System.err.println("sb mesage is:"+sb);
					}
					statement.close();

				}

				sys_message_id = "";
				err_level = "";
				err_text = "";

				if (insertable) {
					String fin_class_flag_YN = "N";
					String sql_bl_class_flag = "Select NVL(AUTO_FIN_CLASSFCTN_IN_USE_YN,'N') from BL_PARAMETERS Where OPERATING_FACILITY_ID = '"
							+ strFacilityId + "'";
					try {
						PreparedStatement pstmt_temp = con
								.prepareStatement(sql_bl_class_flag);
						ResultSet rs_temp = pstmt_temp.executeQuery();
						if (rs_temp != null) {
							while (rs_temp.next()) {
								fin_class_flag_YN = rs_temp.getString(1);
							}
						}
						if (pstmt_temp != null)
							pstmt_temp.close();
						if (rs_temp != null)
							rs_temp.close();
						// System.err.println("From Query fin_class_flag_YN:"+fin_class_flag_YN);
					} catch (Exception e) {
						System.err.println("Exception in sql_bl_class::" + e);
					}
					if (fin_class_flag_YN == null)
						fin_class_flag_YN = "N";

					try {
						if (fin_class_flag_YN.equals("Y")) {
							String sql_class = "{call BLCOMMON.BL_UPD_PAT_CLASS_DTLS('"
									+ strFacilityId
									+ "','"
									+ (String) insert_values
											.get("patient_id_new")
									+ "','"
									+ episode_type
									+ "','"
									+ strNull
									+ "','"
									+ strNull
									+ "','"
									+ strNull
									+ "','"
									+ str_blng_grp
									+ "','"
									+ str_slmt_ind
									+ "','"
									+ str_annual_income
									+ "','"
									+ str_family_asset
									+ "','"
									+ str_inc_asset_ind
									+ "','"
									+ str_ind_inc
									+ "','"
									+ str_ind_inc_freq
									+ "','"
									+ str_spouse_inc
									+ "','"
									+ str_spouse_inc_freq
									+ "','"
									+ str_dependent_inc
									+ "','"
									+ str_dependent_inc_freq
									+ "','"
									+ str_class_code
									+ "','"
									+ str_class_type
									+ "',to_date('"
									+ str_valid_from
									+ "','DD/MM/YYYY'),to_date('"
									+ str_valid_to
									+ "','DD/MM/YYYY'),'"
									+ str_remarks
									+ "','"
									+ str_social_pensioner_id + "','N',?,?,?)}";
							// System.err.println("sql_class:"+sql_class);
							statement = con.prepareCall(sql_class);

							statement.registerOutParameter(1,
									java.sql.Types.VARCHAR);
							statement.registerOutParameter(2,
									java.sql.Types.VARCHAR);
							statement.registerOutParameter(3,
									java.sql.Types.VARCHAR);

							statement.execute();
							// System.err.println("Step1");
							insertable = true;

							err_level = statement.getString(1);
							sys_message_id = statement.getString(2);
							err_text = statement.getString(3);

							if (err_level == null)
								err_level = "";
							if (sys_message_id == null)
								sys_message_id = "";
							if (err_text == null)
								err_text = "";
							// System.err.println("Step2:"+err_text);
							if ((!sys_message_id.equals(""))
									|| (err_level.equals("10") && !err_text
											.equals(""))) {
								insertable = false;
								// System.err.println("Step3:"+err_text);
								if ((err_level.equals("10") && !err_text
										.equals(""))) { // System.err.println("Step3.1:"+err_text);
									sb.append("<br>" + err_text + "<br> ");
								} else {
									// System.err.println("Step3.2:"+err_text);
									messageHashtable = MessageManager
											.getMessage(locale, sys_message_id,
													"BL");
									sb.append((String) messageHashtable
											.get("message"));
								}
								statement.close();
							}
							// System.err.println("Step4:"+err_text);

							if (insertable) {

								// pat_regn_prev_date =
								// (String)insert_values.get("pat_regn_prev_date");
								pat_regn_date_time = (String) tabdata
										.get("pat_regn_date_time");
								if (pat_regn_date_time == null)
									pat_regn_date_time = "";

								pat_regn_prev_date = (String) tabdata
										.get("pat_regn_prev_date");
								if (pat_regn_prev_date == null)
									pat_regn_prev_date = "";
								// if(pat_regn_prev_date.trim().length()==0)
								// pat_regn_prev_date=pat_regn_date_time;

								// System.out.println("####### Testing  pat_regn_date_time  "+pat_regn_date_time+"   pat_regn_prev_date  "+pat_regn_prev_date);

								statement = null;
								String updPatFinClassFnDtls = "{call BLCOMMONPROC.BL_UPD_PAT_FIN_CLASFN_DTLS('"
										+ strFacilityId
										+ "','"
										+ (String) insert_values
												.get("patient_id_new")
										+ "',to_date('"
										+ pat_regn_date_time
										+ "','dd/mm/yyyy HH24:MI:SS'),"
										+ "to_date('"
										+ pat_regn_prev_date
										+ "','dd/mm/yyyy HH24:MI:SS')"
										+ ",'"
										+ (String) insert_values
												.get("added_at_ws_no")
										+ "','"
										+ (String) insert_values
												.get("added_by_id")
										+ "',?,?,?)}";
								// System.err.println("####### call Method "+updPatFinClassFnDtls);
								statement = con
										.prepareCall(updPatFinClassFnDtls);

								statement.registerOutParameter(1,
										java.sql.Types.VARCHAR);
								statement.registerOutParameter(2,
										java.sql.Types.VARCHAR);
								statement.registerOutParameter(3,
										java.sql.Types.VARCHAR);

								statement.execute();
								insertable = true;

								err_level = statement.getString(1);
								sys_message_id = statement.getString(2);
								err_text = statement.getString(3);

								if (err_level == null)
									err_level = "";
								if (sys_message_id == null)
									sys_message_id = "";
								if (err_text == null)
									err_text = "";

								if ((!sys_message_id.equals(""))
										|| (err_level.equals("10") && !err_text
												.equals(""))) {
									insertable = false;
									if ((err_level.equals("10") && !err_text
											.equals(""))) {
										sb.append("<br>" + err_text + "<br> ");
									} else {
										messageHashtable = MessageManager
												.getMessage(locale,
														sys_message_id, "BL");
										sb.append((String) messageHashtable
												.get("message"));
									}

								}
								if (statement != null) {
									statement.close();
								}
							}
						} else {
							// System.err.println("Step5:"+err_text);
							insertable = true;
						}
					} catch (Exception e) {
						insertable = false;
						System.err
								.println("Exception in Classification Date Updation::"
										+ e);
					}
				}

				/*
				 * Karthik added code starts here INCLUDE_POLICY_DETAILS_CRF
				 * 5-25-2013
				 */
				if (insertable) {

					HashMap plcyDetails = new HashMap();
					billing_data = (HashMap) tabdata.get("fin_dtls");
					if (billing_data != null) {
						plcyDetails = (HashMap) billing_data
								.get("payer_plcy_dtls");
						String priority = null;
						String policy_no = null;

						try {

							String patient_id1 = (String) tabdata
									.get("patient_id_new");
							if (patient_id1 == null)
								patient_id1 = "";
							String episode_type1 = (String) tabdata
									.get("episode_type");
							if (episode_type1 == null)
								episode_type1 = "R";
							String added_by_id1 = (String) tabdata
									.get("added_by_id");
							if (added_by_id1 == null)
								added_by_id1 = "0";
							String blng_grup11 = (String) tabdata
									.get("billing_group");
							if (blng_grup11 == null)
								blng_grup11 = "0";
							String facility_id11 = (String) tabdata
									.get("facility_id");

							HashMap paramMap = new HashMap();
							if (patient_id1 == null)
								patient_id1 = "";
							paramMap.put("patientId", patient_id1);
							paramMap.put("episodeType", episode_type1);
							paramMap.put("addedById", added_by_id1);
							paramMap.put("modifiedAtWorkstation", "tst");
							paramMap.put("blngGrpid", blng_grup11);
							paramMap.put("facility_id", facility_id11);
							paramMap.put("mode", "insert");

							HashMap returnMap = new HashMap();
							Set<String> plcyDetailsSet;
							plcyDetailsSet = (Set<String>) plcyDetails.keySet();
							Iterator<String> plcyDetailsIt = plcyDetailsSet
									.iterator();
							PolicyInsuranceMasterBean plcyRecord = null;
							BLPayerPolicyDetails policyFetch = new BLPayerPolicyDetails();
							// HashMap
							// paramMap=(HashMap)billing_data.get("payer_policy_access_specifier");

							while (plcyDetailsIt.hasNext()) {
								String plcyDetailsKey = (String) plcyDetailsIt
										.next();
								plcyRecord = (PolicyInsuranceMasterBean) plcyDetails
										.get(plcyDetailsKey);

								StringTokenizer stTok = new StringTokenizer(
										plcyDetailsKey, "~");
								if (stTok.hasMoreTokens()) {
									priority = stTok.nextToken();
									stTok.nextToken();
									stTok.nextToken();
									stTok.nextToken();
									policy_no = stTok.nextToken();
								}

								paramMap.put("policyNo", policy_no);
								paramMap.put("Priority", priority);

								returnMap = policyFetch.insertHeaderDetails(
										con, plcyRecord, paramMap);

								if (((Boolean) returnMap.get("status"))
										.booleanValue()) {
									returnMap = policyFetch
											.insertPolicyDetails(con,
													plcyRecord, paramMap);
								} else {
									insertable = false;
									con.rollback();
									sb = appendMultipleErrors(returnMap, sb,
											locale);
									break;
								}

								if (((Boolean) returnMap.get("status"))
										.booleanValue()) {
									returnMap = policyFetch
											.insertPreApprovalDetails(con,
													plcyRecord, paramMap);
								} else {
									insertable = false;
									con.rollback();
									sb = appendMultipleErrors(returnMap, sb,
											locale);
									break;
								}

								String mp_change_patient_valid = (String) billing_data
										.get("mp_change_patient_valid");

								if (mp_change_patient_valid != null
										&& mp_change_patient_valid.equals("Y")) {
									// if( mp_change_patient_valid.equals("Y")){
									if (((Boolean) returnMap.get("status"))
											.booleanValue()) {
										returnMap = policyFetch
												.insertAuditProcedure(con,
														paramMap);
									} else {
										insertable = false;
										con.rollback();
										sb = appendMultipleErrors(returnMap,
												sb, locale);
										break;
									}
								}

								if (!((Boolean) returnMap.get("status"))
										.booleanValue()) {
									insertable = false;
									con.rollback();
									sb = appendMultipleErrors(returnMap, sb,
											locale);
									break;

								}

							}

						} catch (Exception e) {
							System.err
									.println("Exception happened while inserting policy Definition details"
											+ e);
						}
					}
				}
				/* Karthik added code ends here INCLUDE_POLICY_DETAILS_CRF */

				sys_message_id = "";
				err_level = "";
				err_text = "";

				String charge_for_pat_regn_yn = "N";
				String sql_charge_for_pat_regn_yn = "Select NVL(CHARGE_FOR_PAT_REGN_YN,'N') from BL_PARAMETERS Where OPERATING_FACILITY_ID = '"
						+ strFacilityId + "'";
				try {
					PreparedStatement pstmt_temp = con
							.prepareStatement(sql_charge_for_pat_regn_yn);
					ResultSet rs_temp = pstmt_temp.executeQuery();
					if (rs_temp != null) {
						while (rs_temp.next()) {
							charge_for_pat_regn_yn = rs_temp.getString(1);
						}
					}
					if (pstmt_temp != null)
						pstmt_temp.close();
					if (rs_temp != null)
						rs_temp.close();
					// System.err.println("From Query charge_for_pat_regn_yn:"+charge_for_pat_regn_yn);
				} catch (Exception e) {
					System.err.println("Exception in charge_for_pat_regn_yn::"
							+ e);
				}
				if (charge_for_pat_regn_yn == null)
					charge_for_pat_regn_yn = "N";

				if (charge_for_pat_regn_yn.equals("Y")
						&& !strFunctionId.equals("CHG_PAT_DTLS")) {
					if (insertable) {
						if (hosp_dtls == null) {
							try {
								String main_blng_grp_id = "";
								String main_cust_grp_code = "";
								String main_cust_code = "";

								if (!str_non_ins_blng_grp.equals("")) {
									main_blng_grp_id = str_blng_grp.substring(
											0, str_blng_grp.indexOf("|"));
									main_cust_grp_code = str_cust_group_code
											.substring(0, str_cust_group_code
													.indexOf("|"));
									main_cust_code = str_cust_code.substring(0,
											str_cust_code.indexOf("|"));
								} else {
									main_blng_grp_id = str_blng_grp;
									main_cust_grp_code = str_cust_group_code;
									main_cust_code = str_cust_code;
								}
								// System.err.println("main_blng_grp_id:"+main_blng_grp_id);
								// System.err.println("main_cust_grp_code:"+main_cust_grp_code);
								// System.err.println("main_cust_code:"+main_cust_code);

								str_pat_ser_code = (String) tabdata
										.get("pat_ser_grp_code");
								if (str_pat_ser_code == null)
									str_pat_ser_code = "";

								// System.err.println("str_pat_ser_code:"+str_pat_ser_code);

								CallableStatement call = con
										.prepareCall("{ call BLPATIENTREGNCHARGE.GETPATREGNSERVDTL(?,?,?,?,?,?,?,?,?,?,?,?)}");

								call.setString(1, strFacilityId);
								call.setString(2, str_pat_ser_code);// P_pat_ser_grp_code
								call.setString(3, main_blng_grp_id);
								call.setString(4, main_cust_grp_code);
								call.setString(5, main_cust_code);

								call.registerOutParameter(6,
										java.sql.Types.VARCHAR);
								call.registerOutParameter(7,
										java.sql.Types.VARCHAR);
								call.registerOutParameter(8,
										java.sql.Types.VARCHAR);
								call.registerOutParameter(9,
										java.sql.Types.VARCHAR);
								call.registerOutParameter(10,
										java.sql.Types.VARCHAR);
								call.registerOutParameter(11,
										java.sql.Types.VARCHAR);
								call.registerOutParameter(12,
										java.sql.Types.VARCHAR);

								call.execute();
								// System.err.println("Check");
								String regn_charge_YN = call.getString(6);
								if (regn_charge_YN == null)
									regn_charge_YN = "N";

								String regn_charge_dur_enc_YN = call
										.getString(7);
								if (regn_charge_dur_enc_YN == null)
									regn_charge_dur_enc_YN = "N";

								hosp_serv_panel_ind = call.getString(8);
								if (hosp_serv_panel_ind == null)
									hosp_serv_panel_ind = "";
								hosp_serv_panel_code = call.getString(9);
								if (hosp_serv_panel_code == null)
									hosp_serv_panel_code = "";

								err_level = call.getString(10);
								sys_message_id = call.getString(11);
								err_text = call.getString(12);

								if (err_level == null)
									err_level = "";
								if (sys_message_id == null)
									sys_message_id = "";
								if (err_text == null)
									err_text = "";

								call.close();

								// System.err.println("hosp_serv_panel_ind:"+hosp_serv_panel_ind);
								// System.err.println("hosp_serv_panel_code:"+hosp_serv_panel_code);
								// System.err.println("regn_charge_YN:"+regn_charge_YN);
								// System.err.println("regn_charge_dur_enc_YN:"+regn_charge_dur_enc_YN);

								// System.err.println("error_level in GETPATREGNSERVDTL:"+err_level);
								// System.err.println("sys_message_id in GETPATREGNSERVDTL:"+sys_message_id);
								// System.err.println("error_text in GETPATREGNSERVDTL:"+err_text);

								if ((!sys_message_id.equals(""))
										|| (err_level.equals("10") && !err_text
												.equals(""))) {
									insertable = false;
									proc_success = "N";

									if ((err_level.equals("10") && !err_text
											.equals(""))) {
										sb.append("<br>" + err_text + "<br> ");
										// System.err.println("sb mesage in Error is:"+sb);
									} else {
										messageHashtable = MessageManager
												.getMessage(locale,
														sys_message_id, "BL");
										sb.append((String) messageHashtable
												.get("message"));
										// System.err.println("sb mesage in sys_message is:"+sb);
									}
									call.close();
								} else {
									proc_success = "Y";
								}
								sys_message_id = "";
								err_level = "";
								err_text = "";

								call.close();
							} catch (Exception e) {
								insertable = false;
								System.err
										.println("Exception in Procedure GET_VISIT_RULE_BY_CLINIC:"
												+ e);
							}

							if (proc_success.equals("Y")) {
								try {
									String sql_get_serv_panel_dtls = "{call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS('"
											+ (String) tabdata
													.get("facility_id")
											+ "','"
											+ strModuleId
											+ "','"
											+ episode_type
											+ "','"
											+ (String) tabdata
													.get("patient_id_new")
											+ "','"
											+ strNull
											+ "','"
											+ strNull
											+ "','"
											+ strNull
											+ "','"
											+ strNull
											+ "',sysdate,'"
											+ hosp_serv_panel_ind
											+ "','"
											+ hosp_serv_panel_code
											+ "',1,'P','"
											+ strNull
											+ "','"
											+ str_blng_grp
											+ "','"
											+ str_cust_group_code
											+ "','"
											+ str_cust_code
											+ "','"
											+ str_ins_policy_type_code
											+ "','"
											+ str_ins_cust_priority
											+ "','"
											+ str_ins_policy_no
											+ "','"
											+ str_ins_policy_start_date
											+ "','"
											+ str_ins_policy_expiry_date
											+ "','"
											+ str_ins_credit_auth_ref
											+ "','"
											+ str_ins_credit_auth_date
											+ "','"
											+ str_ins_policy_eff_from_date
											+ "','"
											+ str_ins_policy_eff_to_date
											+ "','"
											+ str_ins_credit_approval_amount
											+ "','"
											+ str_ins_credit_approval_days
											+ "','"
											+ str_non_ins_blng_grp
											+ "','"
											+ str_non_ins_cust_group_code
											+ "','"
											+ str_non_ins_cust_code
											+ "',?,?,?,?,?,?,'"
											+ strNull
											+ "','"
											+ strNull
											+ "',?,'"
											+ locale + "',?,?,?)}";

									// System.err.println("sql_get_serv_panel_dtls for hospital:"+sql_get_serv_panel_dtls);
									CallableStatement call = con
											.prepareCall(sql_get_serv_panel_dtls);

									call.registerOutParameter(1,
											java.sql.Types.VARCHAR);
									call.registerOutParameter(2,
											java.sql.Types.VARCHAR);
									call.registerOutParameter(3,
											java.sql.Types.DOUBLE);
									call.registerOutParameter(4,
											java.sql.Types.DOUBLE);
									call.registerOutParameter(5,
											java.sql.Types.VARCHAR);
									call.registerOutParameter(6,
											java.sql.Types.VARCHAR);
									call.registerOutParameter(7,
											java.sql.Types.VARCHAR);
									call.registerOutParameter(8,
											java.sql.Types.DOUBLE);
									call.registerOutParameter(9,
											java.sql.Types.VARCHAR);
									call.registerOutParameter(10,
											java.sql.Types.VARCHAR);

									call.execute();

									hosp_serv_panel_str = call.getString(1);
									if (hosp_serv_panel_str == null) {
										hosp_serv_panel_str = "";
									} else {
										hosp_serv_panel_ind = hosp_serv_panel_ind;
										hosp_serv_panel_code = hosp_serv_panel_code;
										hosp_serv_panel_qty = "1.0";
										hosp_serv_charge_amt = "";
									}

									// System.err.println("hosp_serv_panel_ind: "
									// + hosp_serv_panel_ind);
									// System.err.println("hosp_serv_panel_code: "
									// + hosp_serv_panel_code);
									// System.err.println("strHospServPanelStr: "
									// + hosp_serv_panel_str);
									// System.err.println("hosp_serv_panel_qty: "
									// + hosp_serv_panel_qty);
									// System.err.println("hosp_serv_charge_amt: "
									// + hosp_serv_charge_amt);

									// System.err.println("Charge bases YN in Hospital:"+(String)call.getString(2));
									// System.err.println("Total Amount in Hospital:"+(String)call.getString(3));
									// System.err.println("Patient Payable Amount in Hospital:"+(String)call.getString(4));

									err_level = call.getString(8);
									sys_message_id = call.getString(9);
									err_text = call.getString(10);

									if (err_level == null)
										err_level = "";
									if (sys_message_id == null)
										sys_message_id = "";
									if (err_text == null)
										err_text = "";

									// System.err.println("error_level for Hosp_panel:"+err_level);
									// System.err.println("sys_message_id for Hosp_panel:"+sys_message_id);
									// System.err.println("error_text for Hosp_panel:"+err_text);

									if ((!sys_message_id.equals(""))
											|| (err_level.equals("10") && !err_text
													.equals(""))) {
										insertable = false;
										proc_success = "N";

										if ((err_level.equals("10") && !err_text
												.equals(""))) {
											sb.append("<br>" + err_text
													+ "<br> ");
											// System.err.println("sb mesage in Error is:"+sb);
										} else {
											messageHashtable = MessageManager
													.getMessage(locale,
															sys_message_id,
															"BL");
											sb.append((String) messageHashtable
													.get("message"));
											// System.err.println("sb mesage in sys_message is:"+sb);
										}
										call.close();
									} else {
										proc_success = "Y";
									}
									sys_message_id = "";
									err_level = "";
									err_text = "";

									call.close();
								} catch (Exception e) {
									insertable = false;
									System.err
											.println("Exception in GET_SERV_PANEL_DTLS for Hospital Charge:"
													+ e);
								}
							}
						}
					}

					if (insertable) {
						try {
							String sql_pat_reg = "{call BLPatientRegnCharge.Main('"
									+ (String) insert_values
											.get("operation_mode")
									+ "','"
									+ strFunctionId
									+ "','"
									+ strFacilityId
									+ "','"
									+ strModuleId
									+ "','"
									+ (String) tabdata.get("patient_id_new")
									+ "','"
									+ str_pat_ser_code
									+ "','"
									+ episode_type
									+ "',sysdate,'"
									+ strNull
									+ "','"
									+ strNull
									+ "','"
									+ str_blng_grp
									+ "','"
									+ str_cust_group_code
									+ "','"
									+ str_cust_code
									+ "','"
									+ str_ins_policy_type_code
									+ "','"
									+ str_ins_cust_priority
									+ "','"
									+ str_ins_policy_no
									+ "','"
									+ str_ins_policy_start_date
									+ "','"
									+ str_ins_policy_expiry_date
									+ "','"
									+ str_ins_credit_auth_ref
									+ "','"
									+ str_ins_credit_auth_date
									+ "','"
									+ str_ins_policy_eff_from_date
									+ "','"
									+ str_ins_policy_eff_to_date
									+ "','"
									+ str_ins_credit_approval_amount
									+ "','"
									+ str_ins_credit_approval_days
									+ "','"
									+ str_non_ins_blng_grp
									+ "','"
									+ str_non_ins_cust_group_code
									+ "','"
									+ str_non_ins_cust_code
									+ "','"
									+ strNewHospChrgCreate
									+ "','"
									+ hosp_serv_panel_ind
									+ "','"
									+ hosp_serv_panel_code
									+ "','"
									+ hosp_serv_panel_str
									+ "','"
									+ hosp_serv_panel_qty
									+ "','"
									+ hosp_serv_charge_amt
									+ "','"
									+ str_bill_later_YN
									+ "','"
									+ (String) insert_values.get("added_by_id")
									+ "','"
									+ (String) insert_values
											.get("added_at_ws_no")
									+ "','"
									+ (String) insert_values
											.get("added_at_ws_no")
									+ "','"
									+ strNull
									+ "','"
									+ strNull
									+ "','"
									+ locale
									+ "',?,'"
									+ strNull
									+ "','"
									+ strNull
									+ "','"
									+ strNull
									+ "','"
									+ strNull
									+ "','"
									+ strNull
									+ "',?,?,?,?,?,?,?,?,?,?,?,?)}";
							// System.err.println("sql:"+sql_pat_reg);
							statement = con.prepareCall(sql_pat_reg);

							statement.setString(1, "Y");

							statement.registerOutParameter(1,
									java.sql.Types.VARCHAR);
							statement.registerOutParameter(2,
									java.sql.Types.VARCHAR);
							statement.registerOutParameter(3,
									java.sql.Types.VARCHAR);
							statement.registerOutParameter(4,
									java.sql.Types.VARCHAR);
							statement.registerOutParameter(5,
									java.sql.Types.VARCHAR);
							statement.registerOutParameter(6,
									java.sql.Types.VARCHAR);
							statement.registerOutParameter(7,
									java.sql.Types.VARCHAR);
							statement.registerOutParameter(8,
									java.sql.Types.VARCHAR);
							statement.registerOutParameter(9,
									java.sql.Types.VARCHAR);
							statement.registerOutParameter(10,
									java.sql.Types.VARCHAR);
							statement.registerOutParameter(11,
									java.sql.Types.VARCHAR);
							statement.registerOutParameter(12,
									java.sql.Types.VARCHAR);
							statement.registerOutParameter(13,
									java.sql.Types.VARCHAR);

							statement.execute();

							insertable = true;

							hosp_charge_YN = statement.getString(1);
							if (hosp_charge_YN == null
									|| hosp_charge_YN.equals(""))
								hosp_charge_YN = "N";

							str_hosp_chrg_amt = statement.getString(2);
							if (str_hosp_chrg_amt == null
									|| str_hosp_chrg_amt.equals(""))
								str_hosp_chrg_amt = "0.0";
							hosp_chrg_amt = Double
									.parseDouble(str_hosp_chrg_amt);

							str_hosp_chrg_pat_amt = statement.getString(3);
							if (str_hosp_chrg_pat_amt == null
									|| str_hosp_chrg_pat_amt.equals(""))
								str_hosp_chrg_pat_amt = "0.0";
							hosp_chrg_pat_amt = Double
									.parseDouble(str_hosp_chrg_pat_amt);

							bill_gen_yn = statement.getString(4);
							if (bill_gen_yn == null)
								bill_gen_yn = "N";
							bill_doc_type = statement.getString(5);
							if (bill_doc_type == null)
								bill_doc_type = "";
							bill_doc_number = statement.getString(6);
							if (bill_doc_number == null)
								bill_doc_number = "";
							str_bill_gen_later = statement.getString(7);
							if (str_bill_gen_later == null
									|| str_bill_gen_later.equals(""))
								str_bill_gen_later = "N";
							str_total_bill_amt = statement.getString(8);
							if (str_total_bill_amt == null
									|| str_total_bill_amt.equals(""))
								str_total_bill_amt = "";

							str_bill_prt_format_YN = statement.getString(9);
							if (str_bill_prt_format_YN == null
									|| str_bill_prt_format_YN.equals(""))
								str_bill_prt_format_YN = "N";

							str_bill_prt_format_vals = statement.getString(10);
							if (str_bill_prt_format_vals == null
									|| str_bill_prt_format_vals.equals(""))
								str_bill_prt_format_vals = "";

							err_level = statement.getString(11);
							sys_message_id = statement.getString(12);
							err_text = statement.getString(13);

							if (err_level == null)
								err_level = "";
							if (sys_message_id == null)
								sys_message_id = "";
							if (err_text == null)
								err_text = "";

							total_chrg_amt = hosp_chrg_amt;
							total_pat_chrg_amt = hosp_chrg_pat_amt;

							str_total_chrg_amt = String.valueOf(total_chrg_amt);
							str_total_pat_chrg_amt = String
									.valueOf(total_pat_chrg_amt);

							if (total_chrg_amt > 0)
								str_pat_reg_charged_YN = "Y";
							else
								str_pat_reg_charged_YN = "N";

							try {
								CurrencyFormat cf1 = new CurrencyFormat();

								if (str_hosp_chrg_amt != null)
									str_hosp_chrg_amt = cf1.formatCurrency(
											str_hosp_chrg_amt, noofdecimal);

								if (str_total_chrg_amt != null)
									str_total_chrg_amt = cf1.formatCurrency(
											str_total_chrg_amt, noofdecimal);

								if (str_total_pat_chrg_amt != null)
									str_total_pat_chrg_amt = cf1
											.formatCurrency(
													str_total_pat_chrg_amt,
													noofdecimal);

								if (str_hosp_chrg_pat_amt != null)
									str_hosp_chrg_pat_amt = cf1.formatCurrency(
											str_hosp_chrg_pat_amt, noofdecimal);

							} catch (Exception e) {
								System.err.println("Currency exception ::" + e);
							}

							// System.err.println("str_hosp_chrg_amt:"+str_hosp_chrg_amt);
							// System.err.println("hosp_chrg_amt:"+hosp_chrg_amt);
							// System.err.println("str_hosp_chrg_pat_amt:"+str_hosp_chrg_pat_amt);
							// System.err.println("hosp_chrg_pat_amt:"+hosp_chrg_pat_amt);
							// System.err.println("hosp_charge_YN:"+hosp_charge_YN);
							// System.err.println("bill_gen_yn:"+bill_gen_yn);
							// System.err.println("bill_doc_type:"+bill_doc_type);
							// System.err.println("bill_doc_number:"+bill_doc_number);
							// System.err.println("str_bill_gen_later:"+str_bill_gen_later);
							// System.err.println("str_total_bill_amt:"+str_total_bill_amt);
							// System.err.println("err_level:"+err_level);
							// System.err.println("err_text:"+err_text);
							// System.err.println("sys_message_id:"+sys_message_id);

							if (bill_gen_yn.equals("Y")
									&& (bill_doc_type.equals("") && bill_doc_number
											.equals("0"))) {
								bill_gen_yn = "N";
							}

							if (hosp_charge_YN.equals("Y")
									&& bill_gen_yn.equals("N")
									&& str_bill_gen_later.equals("N")) {
								if (hosp_chrg_amt >= 0) {
									strFinalMessage = pat_reg_chrg_leg + " "
											+ str_hosp_chrg_amt + " "
											+ patient_payable_leg + " "
											+ str_hosp_chrg_pat_amt;
								}
							}

							if (bill_gen_yn.equals("Y")
									&& str_bill_gen_later.equals("N")) {
								bill_gen_yn_leg = bill_gen_yn_leg
										.replaceAll(
												"#",
												(bill_doc_type + "/" + bill_doc_number));
								bill_gen_yn_leg = bill_gen_yn_leg.replaceAll(
										"%", str_total_chrg_amt);
								bill_gen_yn_leg = bill_gen_yn_leg.replaceAll(
										"&", str_total_pat_chrg_amt);

								strFinalMessage = bill_gen_yn_leg;
							}
							// strFinalMessage=strFinalMessage+"<BR>";

							// System.err.println("strFinalMessage:"+strFinalMessage);

							if ((!sys_message_id.equals(""))
									|| (err_level.equals("10") && !err_text
											.equals(""))) {
								insertable = false;

								if ((err_level.equals("10") && !err_text
										.equals(""))) {
									sb.append("<br>" + err_text + "<br> ");
								} else {
									messageHashtable = MessageManager
											.getMessage(locale, sys_message_id,
													"BL");
									sb.append((String) messageHashtable
											.get("message"));
								}
								statement.close();
							}

							if (insertable
									&& str_bill_prt_format_YN.equals("Y")) {
								try {
									StringTokenizer st1 = new StringTokenizer(
											str_bill_prt_format_vals, "/");

									while (st1.hasMoreTokens()) {
										pgm_id = st1.nextToken();
										System.err.println("pgm_id:" + pgm_id);
										session_id = st1.nextToken();
										System.err.println("session_id:"
												+ session_id);
										pgm_date = st1.nextToken();
										System.err.println("pgm_date:"
												+ pgm_date);
										mpi_id_rep = st1.nextToken();
										System.err.println("mpi_id_rep:"
												+ mpi_id_rep);
									}
									/*
									 * OnlineReport onlinereportParam = new
									 * OnlineReport((String)
									 * tabdata.get("facility_id"), "BL",
									 * "BLRBLPRT");
									 * onlinereportParam.addParameter
									 * ("p_facility_id",(String)
									 * tabdata.get("facility_id"));
									 * onlinereportParam
									 * .addParameter("p_pgm_date",pgm_date);
									 * onlinereportParam
									 * .addParameter("p_pgm_id",pgm_id);
									 * onlinereportParam
									 * .addParameter("p_Session_id",session_id);
									 * System.err.println(
									 * "Online Report onlinereportParam:"
									 * +onlinereportParam); OnlineReports
									 * onlinereports = new OnlineReports();
									 * onlinereports.add(onlinereportParam);
									 * System
									 * .err.println("Online Report Added:"+
									 * onlinereports); String strResults =
									 * onlinereports
									 * .execute((HttpServletRequest)
									 * billing_data.get("httpreq"),
									 * (HttpServletResponse)
									 * billing_data.get("httpres"));
									 * System.err.println
									 * ("Online Report Executed");
									 * System.err.println
									 * ("strResults:"+strResults);
									 * 
									 * onlinereportParam = null; onlinereports =
									 * null;
									 */
								} catch (Exception e) {
									insertable = false;
									System.err
											.println("Error while submitting Print Job to Report Server:"
													+ e);
									sb.append("Mod. Exception while calling Print Report : "
											+ e);
								}
							}
						} catch (Exception e) {
							insertable = false;
							System.err
									.println("Exception in Patient Registration Charges Insertion::"
											+ e);
						}
					}

					if (insertable) {
						try {
							String main_blng_grp_id = "";
							String main_cust_grp_code = "";
							String main_cust_code = "";

							if (!str_non_ins_blng_grp.equals("")) {
								main_blng_grp_id = str_blng_grp.substring(0,
										str_blng_grp.indexOf("|"));
								main_cust_grp_code = str_cust_group_code
										.substring(0, str_cust_group_code
												.indexOf("|"));
								main_cust_code = str_cust_code.substring(0,
										str_cust_code.indexOf("|"));
							} else {
								main_blng_grp_id = str_blng_grp;
								main_cust_grp_code = str_cust_group_code;
								main_cust_code = str_cust_code;
							}
							// System.err.println("main_blng_grp_id:"+main_blng_grp_id);
							// System.err.println("main_cust_grp_code:"+main_cust_grp_code);
							// System.err.println("main_cust_code:"+main_cust_code);
							String sql_pat_dtls_upd = "{call BLPatientRegnCharge.BL_UPD_PAT_FIN_DTLS('"
									+ (String) insert_values
											.get("operation_mode")
									+ "','"
									+ strFacilityId
									+ "','"
									+ strFunctionId
									+ "','"
									+ (String) tabdata.get("patient_id_new")
									+ "','"
									+ str_pat_ser_code
									+ "','"
									+ main_blng_grp_id
									+ "','"
									+ main_cust_grp_code
									+ "','"
									+ main_cust_code + "',?,?,?)}";

							// System.err.println("sql_pat_dtls_upd:"+sql_pat_dtls_upd);

							statement = con.prepareCall(sql_pat_dtls_upd);

							statement.registerOutParameter(1,
									java.sql.Types.VARCHAR);
							statement.registerOutParameter(2,
									java.sql.Types.VARCHAR);
							statement.registerOutParameter(3,
									java.sql.Types.VARCHAR);

							statement.execute();

							insertable = true;

							if ((!sys_message_id.equals(""))
									|| (err_level.equals("10") && !err_text
											.equals(""))) {
								insertable = false;

								if ((err_level.equals("10") && !err_text
										.equals(""))) {
									sb.append("<br>" + err_text + "<br> ");
								} else {
									messageHashtable = MessageManager
											.getMessage(locale, sys_message_id,
													"BL");
									sb.append((String) messageHashtable
											.get("message"));
								}
								statement.close();
							}
						} catch (Exception e) {
							insertable = false;
							System.err
									.println("Exception in Patient Registration Charges while updating BL_PAT_FIN_DTLS::"
											+ e);
						}
					}
				}
				if (insertable) {
					if (!str_appt_bkng_ref_no.equals("")) {
						String update_bkng_fin_qry = "{call BLCOMMON.bl_update_bkng_fin_dtls('"
								+ (String) tabdata.get("facility_id")
								+ "','"
								+ str_appt_bkng_episode_type
								+ "','"
								+ (String) insert_values.get("patient_id_new")
								+ "','','" + str_appt_bkng_ref_no + "',?,?,?)}";

						// System.err.println("The update_bkng_fin_qry is:"+update_bkng_fin_qry);

						statement = con.prepareCall(update_bkng_fin_qry);
						statement.registerOutParameter(1,
								java.sql.Types.VARCHAR);
						statement.registerOutParameter(2,
								java.sql.Types.VARCHAR);
						statement.registerOutParameter(3,
								java.sql.Types.VARCHAR);

						statement.execute();

						insertable = true;

						err_level = statement.getString(1);
						sys_message_id = statement.getString(2);
						err_text = statement.getString(3);

						if (err_level == null)
							err_level = "";
						if (sys_message_id == null)
							sys_message_id = "";
						if (err_text == null)
							err_text = "";

						// System.err.println("err_level in BL_UPD_PAT_ID_IN_BKNG_FIN_DTLS:"+err_level);
						// System.err.println("sys_message_id in BL_UPD_PAT_ID_IN_BKNG_FIN_DTLS:"+sys_message_id);
						// System.err.println("err_text in BL_UPD_PAT_ID_IN_BKNG_FIN_DTLS:"+err_text);

						if ((!sys_message_id.equals(""))
								|| (err_level.equals("10") && !err_text
										.equals(""))) {
							insertable = false;

							if ((err_level.equals("10") && !err_text.equals(""))) {
								sb.append("<br>" + err_text + "<br> ");
								// System.err.println("sb mesage is:"+sb);
							} else {
								messageHashtable = MessageManager.getMessage(
										locale, sys_message_id, "BL");
								sb.append((String) messageHashtable
										.get("message"));
								// System.err.println("sb mesage is:"+sb);
							}
							statement.close();

						}

						sys_message_id = "";
						err_level = "";
						err_text = "";
					}
				}

				if (insertable) {

					statement = con
							.prepareCall("{call blaudit.proc_update_new_values( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

					statement.setString(1,
							(String) tabdata.get("patient_id_new"));
					statement.setString(2, (String) tabdata.get("facility_id"));
					// Commented by Seshu statement.setString( 3, "OP");
					statement.setString(3, "MP");
					statement.setString(4, strFunctionId);
					statement.setString(5, "");
					// statement.setString(6,"O") ;
					statement.setString(6, episode_type);
					statement.setLong(7, 0);
					statement.setInt(8, 0);
					statement.setString(9, "Y");
					statement.setString(10, "P");
					statement.setString(11, str_fin_auth_user_id);
					statement.setString(12, strNull);
					statement.setString(13, strNull);
					statement.setString(14, strNull);
					statement.setString(15, strNull);
					statement.setString(16, str_fin_remarks);
					statement
							.setString(17, (String) tabdata.get("added_by_id"));
					statement.setString(18,
							(String) tabdata.get("added_at_ws_no"));
					statement.registerOutParameter(19, java.sql.Types.NUMERIC);
					statement.registerOutParameter(20, java.sql.Types.VARCHAR);
					statement.registerOutParameter(21, java.sql.Types.VARCHAR);
					statement.registerOutParameter(22, java.sql.Types.VARCHAR);
					statement.execute();

					// int intAuditNo = statement.getInt(19);
					err_level = statement.getString(20);
					sys_message_id = statement.getString(21);
					err_text = statement.getString(22);
					if ((sys_message_id != null)) {
						if (!(sys_message_id.equals(""))
								|| !(sys_message_id.equalsIgnoreCase("null"))) {
							insertable = false;
							messageHashtable = MessageManager.getMessage(
									locale, sys_message_id, "BL");
							sb.append("Exception while calling blaudit.proc_update_new_values :"
									+ (String) messageHashtable.get("message"));
							messageHashtable.clear();
						}

					}
					if ((err_text != null)) {
						if (!(err_text.equals(""))
								|| !(err_text.equalsIgnoreCase("null"))) {
							insertable = false;
							sb.append("Exception while calling  blaudit.proc_update_new_values :"
									+ err_text);
						}

					}

					statement.close();

				}
			}
		} catch (Exception ebl1) {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (Exception exc) {
			}
			insertable = false;
			sb.append("Exception while calling procedure BL :" + ebl1);
			// System.err.println("Exception in Procedure:"+ebl1);
		}

		results.put("transaction_completed", new Boolean(insertable));
		if (insertable) {
			results.put("success_message", strFinalMessage);
			// sb.append(strFinalMessage);
		}
		results.put("error", sb.toString());
		results.put("billgenlater", str_bill_gen_later);
		results.put("billdoctype", bill_doc_type);
		results.put("billdocnum", bill_doc_number);
		results.put("billtotalamt", str_total_bill_amt);
		results.put("bill_prt_format_YN", str_bill_prt_format_YN);
		results.put("pgm_id", pgm_id);
		results.put("session_id", session_id);
		results.put("pgm_date", pgm_date);
		results.put("mpi_id_rep", mpi_id_rep);
		System.err.println("results:" + results);
		return results;
	}

	private StringBuffer appendMultipleErrors(HashMap returnMap,
			StringBuffer sb, String locale) {
		String mapKey = "";
		String mapValue = "";
		Hashtable messageHashtable = new Hashtable();
		for (Iterator iterator = returnMap.keySet().iterator(); iterator
				.hasNext();) {
			String type = (String) iterator.next();
			if (!("status".equals(type))) {
				mapKey = (String) returnMap.get(type);
				if (mapKey != null) {
					messageHashtable = MessageManager.getMessage(locale,
							mapKey, "BL");
					mapValue = (messageHashtable.get("message") == null) ? ""
							: (String) messageHashtable.get("message");
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
}
