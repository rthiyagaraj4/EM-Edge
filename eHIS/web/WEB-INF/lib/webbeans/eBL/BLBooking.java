/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package blbkin;
import java.net.*;
import java.io.* ;
import java.sql.* ;

import javax.rmi.*;
import java.util.*;
import java.sql.* ;



import webbeans.eCommon.*;

public class BLBooking
{
//	public java.util.Hashtable insert( Properties p,Connection con, String appt_status,String episodeno,Hashtable tabdata,Hashtable prencounter,Hashtable prencounterdetail)
    public java.util.Hashtable billPatientService(Properties p,Connection con, Hashtable tabdata)
	{
//		System.out.println("Entered the billPatientBooking Method");
		CallableStatement statement = null;
		Hashtable results = new Hashtable();
		Hashtable messageHashtable=new Hashtable();
		StringBuffer sb = new StringBuffer();

		Hashtable insert_values = tabdata;

		String strFunctionId = "";
		String strFacilityId= "";
		boolean insertable = true;
		sb.append("");
		String locale			= "";

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

		String str_ref_src_main_code="";
		String str_ref_src_sub_code="";
		String str_ins_ref_src_main_code ="";
		String str_ins_ref_src_sub_code ="";
		String str_non_ins_ref_src_main_code ="";
		String str_non_ins_ref_src_sub_code ="";

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


		String err_level = "";
		String sys_message_id = "";
		String err_text = "";

		double annual_income = 0;
		double family_asset = 0;
		int no_of_dependants = 0;

		String strNull = "";
		String str_appt_bkng_ref_no="",str_appt_bkng_ref_date="";
		
		String creditAuthorisationBy="", claimCode="", membershipNumber="";//Added V190808-Aravindh/AMS-SCF-0808

//		String mother_patient_id="";
		
		try
		{
			locale			= (String)insert_values.get("locale");
			if(locale==null) locale="";
			
			strFunctionId  = (String)tabdata.get("function_id");
			if (strFunctionId  == null) strFunctionId  = "";
//			System.out.println("strFunctionId" +strFunctionId);
			
			strFacilityId=(String)tabdata.get("facilityId");
			if(strFacilityId==null) strFacilityId="";
//			System.out.println("strFacilityId" +strFacilityId);

			String episode_type = (String) tabdata.get("P_EPISODE_TYPE");
			if ( (episode_type == null)||(episode_type.equals("")) ) 
				episode_type = "";

			if(episode_type.equals("I") || episode_type.equals("D"))
			{
				episode_type="B";
			}
			else if(episode_type.equals("O"))
			{
				episode_type="A";
			}

//			System.out.println("episode_type" +episode_type);
			str_appt_bkng_ref_no=(String) tabdata.get("bookingrefno");
			if(str_appt_bkng_ref_no == null) str_appt_bkng_ref_no="";
//			System.out.println("str_appt_bkng_ref_no" +str_appt_bkng_ref_no);

			str_appt_bkng_ref_date=(String) tabdata.get("admissiondate");
			if(str_appt_bkng_ref_date == null) str_appt_bkng_ref_date="";
//			System.out.println("str_appt_bkng_ref_date" +str_appt_bkng_ref_date);
					
//			mother_patient_id=(String) tabdata.get("mother_patient_id");
//			if(mother_patient_id==null) mother_patient_id="";
					
			

/*
			statement=con.prepareCall("{call blaudit.proc_store_old_values( ?,?,?,?,?,?,?,?,?,?,?,?)}");
			statement.setString( 1, (String) tabdata.get("patient_id_new"));
			statement.setString( 2, (String) tabdata.get("facility_id"));
			statement.setString( 3, "MP"); 
			statement.setString( 4, strFunctionId);	// Function Id
			statement.setString( 5, episode_type); // Episode Type
			statement.setLong( 6,0); 
			statement.setInt(7,0);
			statement.setString(8,"P");	// Trn. Type
			statement.setString(9,(String)tabdata.get("credit_auth_user_id"));	// Authorized by
			statement.registerOutParameter(10,java.sql.Types.VARCHAR);
			statement.registerOutParameter(11,java.sql.Types.VARCHAR);
			statement.registerOutParameter(12,java.sql.Types.VARCHAR);
			statement.execute();
				
			err_level = statement.getString(10);
			sys_message_id = statement.getString(11);
			err_text = statement.getString(12);

			System.out.println("err_level in proc_store_old_values:"+err_level);
			System.out.println("sys_message_id in proc_store_old_values:"+sys_message_id);
			System.out.println("err_text in proc_store_old_values:"+err_text);

			if (sys_message_id != null)
			{
				if (!(sys_message_id.equals("")) || !(sys_message_id.equalsIgnoreCase("null") ))
				{
					insertable=false;
					messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
					sb.append("Exception while calling procedure BLAUDIT :"+(String)messageHashtable.get("message"));  
					messageHashtable.clear();
				}
			}
			if ((err_text != null))
			{
				if (!(err_text.equals("")) || !(err_text.equalsIgnoreCase("null") ))
				{
					insertable=false;
					sb.append("Exception while calling procedure BLAUDIT :"+err_text);  
				}
			}

			statement.close();
*/
			if (insertable)
			{
				HashMap billing_data=(HashMap)insert_values.get("fin_dtls");
//				System.out.println("billng_data in bean is:"+billing_data);

				if(billing_data!=null)
				{
					str_blng_grp=(String)billing_data.get("blng_grp");
					if(str_blng_grp==null) str_blng_grp="";
					
					str_slmt_ind=(String)billing_data.get("slmt_ind");
					if(str_slmt_ind==null) str_slmt_ind="";
					
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
					if(str_annual_income==null) str_annual_income="";
					if (str_annual_income.equals("")) str_annual_income = "0";
					
					str_family_asset=(String)billing_data.get("family_asset"); //double
					if(str_family_asset==null) str_family_asset="";
					if (str_family_asset.equals("")) str_family_asset = "0";
					
					str_no_of_dependants=(String)billing_data.get("no_of_dependants"); //int
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
					
					str_pat_reln_with_gl_holder=(String)billing_data.get("pat_reln_with_gl_holder");
					if(str_pat_reln_with_gl_holder==null) str_pat_reln_with_gl_holder="";

					str_ref_src_main_code=(String)billing_data.get("ref_src_main_code");
					if(str_ref_src_main_code==null) str_ref_src_main_code="";

					str_ref_src_sub_code=(String)billing_data.get("ref_src_sub_code");
					if(str_ref_src_sub_code==null) str_ref_src_sub_code="";

					str_ins_ref_src_main_code=(String)billing_data.get("ins_ref_src_main_code");
					if(str_ins_ref_src_main_code==null) str_ins_ref_src_main_code="";
//					System.out.println("str_ins_ref_src_main_code:"+str_ins_ref_src_main_code);

					str_ins_ref_src_sub_code=(String)billing_data.get("ins_ref_src_sub_code");
					if(str_ins_ref_src_sub_code==null) str_ins_ref_src_sub_code="";
//					System.out.println("str_ins_ref_src_sub_code:"+str_ins_ref_src_sub_code);

					str_non_ins_ref_src_main_code=(String)billing_data.get("non_ins_ref_src_main_code");
					if(str_non_ins_ref_src_main_code==null) str_non_ins_ref_src_main_code="";
//					System.out.println("str_non_ins_ref_src_main_code:"+str_non_ins_ref_src_main_code);

					str_non_ins_ref_src_sub_code=(String)billing_data.get("non_ins_ref_src_sub_code");
					if(str_non_ins_ref_src_sub_code==null) str_non_ins_ref_src_sub_code="";
//					System.out.println("str_non_ins_ref_src_sub_code:"+str_non_ins_ref_src_sub_code);

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

					str_cust_group_code = "";
					str_cust_code = "";
					str_doc_ref= "";
					str_doc_start_date="";
					str_doc_end_date="";
				

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
					
					/* Added V190808-Aravindh/AMS-SCF-0808/Starts */
					creditAuthorisationBy=(String) billing_data.get("credit_authorisation_by");
					if(creditAuthorisationBy==null) creditAuthorisationBy="";
					
					claimCode=(String) billing_data.get("claim_code");
					if(claimCode==null) claimCode="";			
					
					membershipNumber=(String) billing_data.get("membership_number");
					if(membershipNumber==null) membershipNumber="";
					/* Added V190808-Aravindh/AMS-SCF-0808/Ends */
				}
				else
				{
					str_blng_grp=(String)insert_values.get("billing_group");
					str_blng_class=(String)insert_values.get("dflt_pat_regn_blng_class");
				}

/*
			if(!str_ins_ref_src_main_code.equals("") && !str_ins_ref_src_sub_code.equals(""))
			{
				str_blng_grp = str_blng_grp+"~"+str_ins_ref_src_main_code+"~"+str_ins_ref_src_sub_code;
			}
*/
				//Modified V190808-Aravindh/AMS-SCF-0808/Added 3 new Parameters 
				String sql = "{call BLCOMMON.BL_INS_UPD_BKNG_FIN_DTLS( '"+(String)insert_values.get("P_MODE")+"','"+str_appt_bkng_ref_no+"',to_date('"+str_appt_bkng_ref_date+"','dd/mm/yyyy hh24:mi '),'"+episode_type+"','"+(String)insert_values.get("P_PATIENT_ID")+"','"+str_blng_grp+"','"+str_ref_src_main_code+"','"+str_ref_src_sub_code+"','"+str_blng_class+"','"+str_emp_code+"','"+str_doc_ref+"',to_date('"+str_doc_start_date+"','dd/mm/yyyy '),to_date('"+str_doc_end_date+"','dd/mm/yyyy'),'"+str_slmt_type_code+"','"+str_inst_ref+"',to_date('"+str_inst_date+"','dd/mm/yyyy'),'"+str_inst_remarks+"','"+str_ins_ref_src_main_code+"','"+str_ins_ref_src_sub_code+"','"+str_cust_group_code+"','"+str_cust_code+"','"+str_ins_cust_priority+"','"+str_ins_policy_type_code+"','"+str_ins_policy_no+"','"+str_ins_policy_start_date+"','"+str_ins_policy_expiry_date+"','"+str_ins_credit_auth_ref+"','"+str_ins_credit_auth_date+"','"+str_ins_policy_eff_from_date+"','"+str_ins_policy_eff_to_date+"','"+str_ins_credit_approval_amount+"','"+str_ins_credit_approval_days+"','"+str_ins_adj_rule_ind+"','"+str_ins_adj_perc_amt_ind+"','"+str_ins_adj_perc_amt_value+"','"+str_ins_pmnt_diff_adj_int+"','"+str_ins_drg_pmnt_diff_adj_int+"','"+str_ins_spl_srv_pmnt_diff_adj_int+"','"+str_non_ins_blng_grp+"','"+str_non_ins_ref_src_main_code+"','"+str_non_ins_ref_src_sub_code+"','"+str_non_ins_cust_group_code+"','"+str_non_ins_cust_code+"','"+annual_income+"','"+family_asset+"','"+no_of_dependants+"','"+str_resp_for_payment+"','"+str_pat_reln_with_resp_person+"',?,'"+str_pat_reln_with_gl_holder+"','"+str_ref_src_main_code+"','"+str_ref_src_sub_code+"','"+(String)insert_values.get("addedById")+"','"+strFacilityId+"','"+(String)insert_values.get("addedAtWorkstation")+"','"+str_fin_remarks+"','"+str_fin_auth_user_id+"','"+str_calling_function_id+"','"+str_spl_clinic_rel_enc_YN+"',to_date('"+str_acct_seq_eff_from_date+"','dd/mm/yyyy'),to_date('"+str_acct_seq_eff_to_date+"','dd/mm/yyyy'),'"+strNull+"',?,?,?,?,?,?)}";
//				System.out.println("The Sql is:"+sql);

					
				statement = con.prepareCall(sql);
				
				statement.setString(1, str_gl_holder_name);
				statement.registerOutParameter( 2,java.sql.Types.VARCHAR);
				statement.registerOutParameter( 3,java.sql.Types.VARCHAR);
				statement.registerOutParameter( 4,java.sql.Types.VARCHAR);
				statement.setString(5, creditAuthorisationBy);
				statement.setString(6, claimCode);
				statement.setString(7, membershipNumber);
				
				statement.execute();
//				System.out.println("The Sql is after e");

				insertable = true;
				
				err_level=statement.getString(2);
				sys_message_id=statement.getString(3);
				err_text=statement.getString(4);

				if(err_level==null) err_level="";
				if(sys_message_id==null) sys_message_id="";
				if(err_text==null) err_text="";

//				System.out.println("err_level:"+err_level);
//				System.out.println("sys_message_id:"+sys_message_id);
//				System.out.println("err_text:"+err_text);

				if(  (!sys_message_id.equals(""))  || (err_level.equals("10") && !err_text.equals("") ) )
				{
					insertable=false;

					if((err_level.equals("10") && !err_text.equals("") ))
					{
						sb.append("<br>"+err_text+"<br> ") ;
//						System.out.println("sb mesage is:"+sb);
					}
					else
					{
						messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
						sb.append((String)messageHashtable.get("message"));
//						System.out.println("sb mesage is:"+sb);
					}
					statement.close();
				}
				
				sys_message_id="";
				err_level="";
				err_text="";

/*
				if (insertable)
				{
		
					statement=con.prepareCall("{call blaudit.proc_update_new_values( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					
					statement.setString( 1, (String) tabdata.get("patient_id_new") );        
					statement.setString( 2, (String) tabdata.get("facility_id")  );      
					statement.setString( 3, "MP"); 
					statement.setString( 4, strFunctionId );
					statement.setString( 5, "" );                                        
					statement.setString(6,episode_type);                                 
					statement.setLong(7,0);              
					statement.setInt(8,0);                
					statement.setString(9,"Y");
					statement.setString(10,"P");                                       
					statement.setString(11,(String)tabdata.get("credit_auth_user_id"));
					statement.setString(12,strNull);
					statement.setString(13,strNull);
					statement.setString(14,strNull);
					statement.setString(15,strNull);
					statement.setString(16,(String)tabdata.get("remarks"));
					statement.setString(17,	(String) tabdata.get("added_by_id")	 );  
					statement.setString(18,	(String) tabdata.get("added_at_ws_no") );    
					statement.registerOutParameter(19,java.sql.Types.NUMERIC);
					statement.registerOutParameter(20,java.sql.Types.VARCHAR);
					statement.registerOutParameter(21,java.sql.Types.VARCHAR);
					statement.registerOutParameter(22,java.sql.Types.VARCHAR);
					statement.execute();
		
					err_level = statement.getString(20);
					sys_message_id = statement.getString(21);
					err_text = statement.getString(22);
					if ((sys_message_id != null))
					{
						if (!(sys_message_id.equals("")) || !(sys_message_id.equalsIgnoreCase("null") ))
						{
							insertable=false;
							messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
							sb.append("Exception while calling blaudit.proc_update_new_values :"+(String)messageHashtable.get("message"));  
							messageHashtable.clear();
						}
						
					}
					if ((err_text != null))
					{
						if (!(err_text.equals("")) || !(err_text.equalsIgnoreCase("null") ) )
						{
							insertable=false;
							sb.append("Exception while calling  blaudit.proc_update_new_values :"+err_text);  
						}
						
					}

					statement.close();
				}
*/
			}
		}
		catch(Exception ebl1)
		{  
			try
			{
				if (statement != null)
				{
					statement.close();
				}
			}
			catch(Exception exc)
			{
			}
			insertable=false;
			sb.append("Exception while calling procedure BL :"+ebl1);  
//			System.out.println("Exception in Procedure:"+ebl1);
		}
		results.put("status",new Boolean(insertable));
		results.put("error",sb.toString());
		return results ;
	}
}	
	
