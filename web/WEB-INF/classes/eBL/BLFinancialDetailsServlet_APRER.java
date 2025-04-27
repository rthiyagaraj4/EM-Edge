/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import javax.naming.*;
import javax.rmi.*;

import org.apache.commons.lang.StringUtils;

import com.ehis.persist.PersistenceHelper;
import webbeans.eCommon.*;



public class BLFinancialDetailsServlet_APRER extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
	{
		PrintWriter out = null;

		try 
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			HttpSession session=req.getSession(false);
			out = res.getWriter();

			insertFinancialDetails(req,res,session,out);
			
		} 
		catch (Exception e) 
		{
				e.printStackTrace();
		}
	}
	private void insertFinancialDetails(HttpServletRequest req,
			HttpServletResponse res,HttpSession session, PrintWriter out) 
	{
		System.err.println("Inside BLFinancialDetailsServlet insertFinancialDetails()");
		try 
		{
			session.setAttribute("blGetDfltEncBg", null);
			HashMap tabdata = new HashMap();

//			String str_total_records=req.getParameter("rtn_total_records");
//			int total_records=Integer.parseInt(str_total_records);
			
			String str_blng_grp=req.getParameter("rtn_blng_grp");
			String str_slmt_ind=req.getParameter("rtn_slmt_ind");
			String str_credit_doc_reqd_yn=req.getParameter("rtn_credit_doc_reqd_yn");
			String str_blng_class=req.getParameter("rtn_blng_class");
			String str_emp_code=req.getParameter("rtn_emp_code");
			String str_slmt_type_code=req.getParameter("rtn_slmt_type_code");
			String str_inst_ref=req.getParameter("rtn_inst_ref");
			String str_inst_date=req.getParameter("rtn_inst_date");
			String str_inst_remarks=req.getParameter("rtn_inst_remarks");
			String str_credit_cust_group_code=req.getParameter("rtn_credit_cust_group_code");
			String str_credit_cust_code=req.getParameter("rtn_credit_cust_code");
			String str_credit_doc_ref=req.getParameter("rtn_credit_doc_ref");
			String str_credit_doc_start_date=req.getParameter("rtn_credit_doc_start_date");
			String str_credit_doc_end_date=req.getParameter("rtn_credit_doc_end_date");
			String str_sponsor_cust_group_code=req.getParameter("rtn_sponsor_cust_group_code");
			String str_sponsor_cust_code=req.getParameter("rtn_sponsor_cust_code");
			String str_sponsor_credit_doc_ref=req.getParameter("rtn_sponsor_credit_doc_ref");
			String str_sponsor_credit_doc_start_date=req.getParameter("rtn_sponsor_credit_doc_start_date");
			String str_sponsor_credit_doc_end_date=req.getParameter("rtn_sponsor_credit_doc_end_date");
			String str_ins_blng_grp=req.getParameter("rtn_ins_blng_grp");
			String str_ins_cust_group_code=req.getParameter("rtn_ins_cust_group_code");
			String str_ins_cust_code=req.getParameter("rtn_ins_cust_code");
			String str_ins_cust_priority=req.getParameter("rtn_ins_cust_priority");
			String str_ins_policy_type_code=req.getParameter("rtn_ins_policy_type_code");
			String str_ins_policy_no=req.getParameter("rtn_ins_policy_no");
			String str_ins_policy_start_date=req.getParameter("rtn_ins_policy_start_date");
			String str_ins_policy_expiry_date=req.getParameter("rtn_ins_policy_expiry_date");
			String str_ins_credit_auth_ref=req.getParameter("rtn_ins_credit_auth_ref");
			String str_ins_credit_auth_date=req.getParameter("rtn_ins_credit_auth_date");

			String str_ins_cred_auth_req_yn=req.getParameter("rtn_ins_cred_auth_req_yn");
			String str_ins_cred_auth_mand_capt_yn=req.getParameter("rtn_ins_cred_auth_mand_capt_yn");
			String str_ins_dflt_auth_ref_as_pol_no_yn=req.getParameter("rtn_ins_dflt_auth_ref_as_pol_no_yn");				
			
			String str_ins_credit_approval_days=req.getParameter("rtn_ins_credit_approval_days");
			String str_ins_credit_approval_amount=req.getParameter("rtn_ins_credit_approval_amount");
			String str_ins_policy_eff_from_date=req.getParameter("rtn_ins_policy_eff_from_date");
			String str_ins_policy_eff_to_date=req.getParameter("rtn_ins_policy_eff_to_date");
			String str_ins_adj_rule_ind=req.getParameter("rtn_ins_adj_rule_ind");
			String str_ins_adj_perc_amt_ind=req.getParameter("rtn_ins_adj_perc_amt_ind");
			String str_ins_adj_perc_amt_value=req.getParameter("rtn_ins_adj_perc_amt_value");
			String str_ins_pmnt_diff_adj_int=req.getParameter("rtn_ins_pmnt_diff_adj_int");
			String str_ins_drg_pmnt_diff_adj_int=req.getParameter("rtn_ins_drg_pmnt_diff_adj_int");
			String str_ins_spl_srv_pmnt_diff_adj_int=req.getParameter("rtn_ins_spl_srv_pmnt_diff_adj_int");
			String str_non_ins_blng_grp=req.getParameter("rtn_non_ins_blng_grp");
			String str_non_ins_credit_doc_reqd_yn=req.getParameter("rtn_non_ins_credit_doc_reqd_yn");
			String str_non_ins_slmt_type_code=req.getParameter("rtn_non_ins_slmt_type_code");
			String str_non_ins_inst_ref=req.getParameter("rtn_non_ins_inst_ref");
			String str_non_ins_inst_date=req.getParameter("rtn_non_ins_inst_date");
			String str_non_ins_inst_remarks=req.getParameter("rtn_non_ins_inst_remarks");
			String str_non_ins_cust_group_code=req.getParameter("rtn_non_ins_cust_group_code");
			String str_non_ins_cust_code=req.getParameter("rtn_non_ins_cust_code");
			String str_non_ins_credit_doc_ref=req.getParameter("rtn_non_ins_credit_doc_ref");
			String str_non_ins_credit_doc_start_date=req.getParameter("rtn_non_ins_credit_doc_start_date");
			String str_non_ins_credit_doc_end_date=req.getParameter("rtn_non_ins_credit_doc_end_date");
			String str_annual_income=req.getParameter("rtn_annual_income");
			String str_family_asset=req.getParameter("rtn_family_asset");
			String str_no_of_dependants=req.getParameter("rtn_no_of_dependants");
			String str_resp_for_payment=req.getParameter("rtn_resp_for_payment");
			String str_pat_reln_with_resp_person=req.getParameter("rtn_pat_reln_with_resp_person");
			String str_fin_remarks=req.getParameter("rtn_fin_remarks");
			String str_gl_holder_name=req.getParameter("rtn_gl_holder_name");
			String str_pat_reln_with_gl_holder=req.getParameter("rtn_pat_reln_with_gl_holder");
			String str_ref_src_main_code=req.getParameter("rtn_ref_src_main_code");
			String str_ref_src_main_desc=req.getParameter("rtn_ref_src_main_desc");
			String str_ref_src_sub_code=req.getParameter("rtn_ref_src_sub_code");
			String str_ref_src_sub_desc=req.getParameter("rtn_ref_src_sub_desc");
			String str_upd_patient_fin_dtls_yn=req.getParameter("rtn_upd_patient_fin_dtls_yn");
			String str_spl_clinic_rel_enc_YN=req.getParameter("rtn_spl_clinic_rel_enc_YN");
			String str_user_id=req.getParameter("rtn_user_id");
			String str_fin_auth_user_id=req.getParameter("rtn_fin_auth_user_id");
			String str_calling_function_id=req.getParameter("rtn_calling_function_id");
			String str_ins_restrict_check=req.getParameter("rtn_ins_restrict_check");
			String str_ins_apprd_amt_restrict_check=req.getParameter("rtn_ins_apprd_amt_restrict_check");
			String str_ins_apprd_days_restrict_check=req.getParameter("rtn_ins_apprd_days_restrict_check");

			String str_ins_ref_src_main_code=req.getParameter("rtn_ins_ref_src_main_code");
			String str_ins_ref_src_main_desc=req.getParameter("rtn_ins_ref_src_main_desc");
			String str_ins_ref_src_sub_code=req.getParameter("rtn_ins_ref_src_sub_code");
			String str_ins_ref_src_sub_desc=req.getParameter("rtn_ins_ref_src_sub_desc");

			String str_non_ins_ref_src_main_code=req.getParameter("rtn_non_ins_ref_src_main_code");
			String str_non_ins_ref_src_main_desc=req.getParameter("rtn_non_ins_ref_src_main_desc");
			String str_non_ins_ref_src_sub_code=req.getParameter("rtn_non_ins_ref_src_sub_code");
			String str_non_ins_ref_src_sub_desc=req.getParameter("rtn_non_ins_ref_src_sub_desc");

			String str_tot_valid_enc_with_gl=req.getParameter("rtn_tot_valid_enc_with_gl");
			String str_tot_valid_op_enc_with_gl=req.getParameter("rtn_tot_valid_op_enc_with_gl");
			String str_tot_valid_ae_enc_with_gl=req.getParameter("rtn_tot_valid_ae_enc_with_gl");
			String str_tot_valid_ip_enc_with_gl=req.getParameter("rtn_tot_valid_ip_enc_with_gl");
			String str_tot_valid_dc_enc_with_gl=req.getParameter("rtn_tot_valid_dc_enc_with_gl");

			String str_tot_availed_enc_with_gl=req.getParameter("rtn_tot_availed_enc_with_gl");
			String str_tot_availed_op_enc_with_gl=req.getParameter("rtn_tot_availed_op_enc_with_gl");
			String str_tot_availed_ae_enc_with_gl=req.getParameter("rtn_tot_availed_ae_enc_with_gl");
			String str_tot_availed_ip_enc_with_gl=req.getParameter("rtn_tot_availed_ip_enc_with_gl");
			String str_tot_availed_dc_enc_with_gl=req.getParameter("rtn_tot_availed_dc_enc_with_gl");

			String str_gl_doc_ref_exist_YN=req.getParameter("rtn_gl_doc_ref_exist_YN");			
			String str_pat_ser_code=req.getParameter("rtn_pat_ser_code");			

// Added for incorporating the Billing Classification Requirement
			String str_class_type=req.getParameter("rtn_class_type");
			if(str_class_type == null) str_class_type="";
			String str_class_code=req.getParameter("rtn_class_code");			
			if(str_class_code == null) str_class_code="";
			String str_inc_asset_ind=req.getParameter("rtn_inc_asset_ind");			
			if(str_inc_asset_ind == null) str_inc_asset_ind="";
			String str_ind_inc=req.getParameter("rtn_ind_inc");			
			if(str_ind_inc == null) str_ind_inc="";
			String str_ind_inc_freq=req.getParameter("rtn_ind_inc_freq");			
			if(str_ind_inc_freq == null) str_ind_inc_freq="";
			String str_spouse_inc=req.getParameter("rtn_spouse_inc");			
			if(str_spouse_inc == null) str_spouse_inc="";
			String str_spouse_inc_freq=req.getParameter("rtn_spouse_inc_freq");			
			if(str_spouse_inc_freq == null) str_spouse_inc_freq="";
			String str_dependent_inc=req.getParameter("rtn_dependent_inc");			
			if(str_dependent_inc == null) str_dependent_inc="";
			String str_dependent_inc_freq=req.getParameter("rtn_dependent_inc_freq");			
			if(str_dependent_inc_freq == null) str_dependent_inc_freq="";
			String str_valid_from=req.getParameter("rtn_valid_from");			
			if(str_valid_from == null) str_valid_from="";
			String str_valid_to=req.getParameter("rtn_valid_to");			
			if(str_valid_to == null) str_valid_to="";
			String str_last_date=req.getParameter("rtn_last_date");			
			if(str_last_date == null) str_last_date="";
			String str_social_pensioner_id=req.getParameter("rtn_social_pensioner_id");			
			if(str_social_pensioner_id == null) str_social_pensioner_id="";
			String str_remarks=req.getParameter("rtn_remarks");			
			if(str_remarks == null) str_remarks="";
// -------------------------------------------------------------------------------------------------

			String encounter_date_time=req.getParameter("encounter_date_time");
			
			String locale=req.getParameter("locale");

			HashMap hosp_dtls=(HashMap)session.getAttribute("hosp_dtls");
			HashMap prof_dtls=(HashMap)session.getAttribute("prof_dtls");
			HashMap addl_dtls=(HashMap)session.getAttribute("addl_dtls");
/*********ADDED BY RAM GHL-CRF-1.2****************************************************/
			HashMap pat_reg_dtls=(HashMap)session.getAttribute("pat_reg_dtls");
/****************END******************************************************************/

			tabdata.put("blng_grp",str_blng_grp);
			tabdata.put("slmt_ind",str_slmt_ind);
			tabdata.put("credit_doc_reqd_yn",str_credit_doc_reqd_yn);
			tabdata.put("blng_class",str_blng_class);
			tabdata.put("emp_code",str_emp_code);
			tabdata.put("slmt_type_code",str_slmt_type_code);
			tabdata.put("inst_ref",str_inst_ref);
			tabdata.put("inst_date",str_inst_date);
			tabdata.put("inst_remarks",str_inst_remarks);
			tabdata.put("credit_cust_group_code",str_credit_cust_group_code);
			tabdata.put("credit_cust_code",str_credit_cust_code);
			tabdata.put("credit_doc_ref",str_credit_doc_ref);
			tabdata.put("credit_doc_start_date",str_credit_doc_start_date);
			tabdata.put("credit_doc_end_date",str_credit_doc_end_date);
			tabdata.put("sponsor_cust_group_code",str_sponsor_cust_group_code);
			tabdata.put("sponsor_cust_code",str_sponsor_cust_code);
			tabdata.put("sponsor_credit_doc_ref",str_sponsor_credit_doc_ref);
			tabdata.put("sponsor_credit_doc_start_date",str_sponsor_credit_doc_start_date);
			tabdata.put("sponsor_credit_doc_end_date",str_sponsor_credit_doc_end_date);
			tabdata.put("ins_blng_grp",str_ins_blng_grp);
			tabdata.put("ins_cust_group_code",str_ins_cust_group_code);
			tabdata.put("ins_cust_code",str_ins_cust_code);
			tabdata.put("ins_cust_priority",str_ins_cust_priority);
			tabdata.put("ins_policy_type_code",str_ins_policy_type_code);
			tabdata.put("ins_policy_no",str_ins_policy_no);
			tabdata.put("ins_policy_start_date",str_ins_policy_start_date);
			tabdata.put("ins_policy_expiry_date",str_ins_policy_expiry_date);
			tabdata.put("ins_credit_auth_ref",str_ins_credit_auth_ref);
			tabdata.put("ins_credit_auth_date",str_ins_credit_auth_date);
			tabdata.put("ins_cred_auth_req_yn",str_ins_cred_auth_req_yn);
			tabdata.put("ins_cred_auth_mand_capt_yn",str_ins_cred_auth_mand_capt_yn);			
			tabdata.put("ins_dflt_auth_ref_as_pol_no_yn",str_ins_dflt_auth_ref_as_pol_no_yn);			
			tabdata.put("ins_credit_approval_days",str_ins_credit_approval_days);
			tabdata.put("ins_credit_approval_amount",str_ins_credit_approval_amount);
			tabdata.put("ins_policy_eff_from_date",str_ins_policy_eff_from_date);
			tabdata.put("ins_policy_eff_to_date",str_ins_policy_eff_to_date);
			tabdata.put("ins_adj_rule_ind",str_ins_adj_rule_ind);
			tabdata.put("ins_adj_perc_amt_ind",str_ins_adj_perc_amt_ind);
			tabdata.put("ins_adj_perc_amt_value",str_ins_adj_perc_amt_value);
			tabdata.put("ins_pmnt_diff_adj_int",str_ins_pmnt_diff_adj_int);
			tabdata.put("ins_drg_pmnt_diff_adj_int",str_ins_drg_pmnt_diff_adj_int);
			tabdata.put("ins_spl_srv_pmnt_diff_adj_int",str_ins_spl_srv_pmnt_diff_adj_int);
			tabdata.put("ins_restrict_check",str_ins_restrict_check);
			tabdata.put("ins_apprd_amt_restrict_check",str_ins_apprd_amt_restrict_check);
			tabdata.put("ins_apprd_days_restrict_check",str_ins_apprd_days_restrict_check);
			tabdata.put("non_ins_blng_grp",str_non_ins_blng_grp);
			tabdata.put("non_ins_credit_doc_reqd_yn",str_non_ins_credit_doc_reqd_yn);
			tabdata.put("non_ins_slmt_type_code",str_non_ins_slmt_type_code);
			tabdata.put("non_ins_inst_ref",str_non_ins_inst_ref);
			tabdata.put("non_ins_inst_date",str_non_ins_inst_date);
			tabdata.put("non_ins_inst_remarks",str_non_ins_inst_remarks);
			tabdata.put("non_ins_cust_group_code",str_non_ins_cust_group_code);
			tabdata.put("non_ins_cust_code",str_non_ins_cust_code);
			tabdata.put("non_ins_credit_doc_ref",str_non_ins_credit_doc_ref);
			tabdata.put("non_ins_credit_doc_start_date",str_non_ins_credit_doc_start_date);
			tabdata.put("non_ins_credit_doc_end_date",str_non_ins_credit_doc_end_date);
			tabdata.put("annual_income",str_annual_income);
			tabdata.put("family_asset",str_family_asset);
			tabdata.put("no_of_dependants",str_no_of_dependants);
			tabdata.put("resp_for_payment",str_resp_for_payment);
			tabdata.put("pat_reln_with_resp_person",str_pat_reln_with_resp_person);
			tabdata.put("fin_remarks",str_fin_remarks);
			tabdata.put("gl_holder_name",str_gl_holder_name);
			tabdata.put("pat_reln_with_gl_holder",str_pat_reln_with_gl_holder);
			tabdata.put("ref_src_main_code",str_ref_src_main_code);
			tabdata.put("ref_src_main_desc",str_ref_src_main_desc);
			tabdata.put("ref_src_sub_code",str_ref_src_sub_code);
			tabdata.put("ref_src_sub_desc",str_ref_src_sub_desc);
			tabdata.put("ins_ref_src_main_code",str_ins_ref_src_main_code);
			tabdata.put("ins_ref_src_main_desc",str_ins_ref_src_main_desc);
			tabdata.put("ins_ref_src_sub_code",str_ins_ref_src_sub_code);
			tabdata.put("ins_ref_src_sub_desc",str_ins_ref_src_sub_desc);
			tabdata.put("non_ins_ref_src_main_code",str_non_ins_ref_src_main_code);
			tabdata.put("non_ins_ref_src_main_desc",str_non_ins_ref_src_main_desc);
			tabdata.put("non_ins_ref_src_sub_code",str_non_ins_ref_src_sub_code);
			tabdata.put("non_ins_ref_src_sub_desc",str_non_ins_ref_src_sub_desc);
			tabdata.put("upd_patient_fin_dtls_yn",str_upd_patient_fin_dtls_yn);
			tabdata.put("spl_clinic_rel_enc_YN",str_spl_clinic_rel_enc_YN);			
			tabdata.put("user_id",str_user_id);
			tabdata.put("fin_auth_user_id",str_fin_auth_user_id);
			tabdata.put("calling_function_id",str_calling_function_id);
			tabdata.put("locale",locale);
			tabdata.put("fin_dtls_updated_YN","Y");
			tabdata.put("encounter_date_time",encounter_date_time);
			tabdata.put("tot_valid_enc_with_gl",str_tot_valid_enc_with_gl);
			tabdata.put("tot_valid_op_enc_with_gl",str_tot_valid_op_enc_with_gl);
			tabdata.put("tot_valid_ae_enc_with_gl",str_tot_valid_ae_enc_with_gl);
			tabdata.put("tot_valid_ip_enc_with_gl",str_tot_valid_ip_enc_with_gl);
			tabdata.put("tot_valid_dc_enc_with_gl",str_tot_valid_dc_enc_with_gl);

			tabdata.put("no_of_enc_gl_availed",str_tot_availed_enc_with_gl);
			tabdata.put("no_of_op_enc_gl_availed",str_tot_availed_op_enc_with_gl);
			tabdata.put("no_of_ae_enc_gl_availed",str_tot_availed_ae_enc_with_gl);
			tabdata.put("no_of_ip_enc_gl_availed",str_tot_availed_ip_enc_with_gl);
			tabdata.put("no_of_dc_enc_gl_availed",str_tot_availed_dc_enc_with_gl);

			tabdata.put("gl_doc_ref_exist_YN",str_gl_doc_ref_exist_YN);			
			tabdata.put("pat_ser_code",str_pat_ser_code);			

/* Added for incorporating the Billing Classification Enhancement */
			tabdata.put("class_type",str_class_type);			
			tabdata.put("class_code",str_class_code);			
			tabdata.put("inc_asset_ind",str_inc_asset_ind);			
			tabdata.put("ind_inc",str_ind_inc);			
			tabdata.put("ind_inc_freq",str_ind_inc_freq);			
			tabdata.put("spouse_inc",str_spouse_inc);			
			tabdata.put("spouse_inc_freq",str_spouse_inc_freq);			
			tabdata.put("dependent_inc",str_dependent_inc);			
			tabdata.put("dependent_inc_freq",str_dependent_inc_freq);			
			tabdata.put("valid_from",str_valid_from);			
			tabdata.put("valid_to",str_valid_to);			
			tabdata.put("last_date",str_last_date);	
			tabdata.put("social_pensioner_id",str_social_pensioner_id);	
			tabdata.put("remarks",str_remarks);	
						
			if(!str_class_code.equals(""))
				tabdata.put("fin_class_dtls_updated_YN","Y");
			else
				tabdata.put("fin_class_dtls_updated_YN","N");
			
/* **************************************************************************** */

			if(hosp_dtls!=null)
			{
				tabdata.put("hosp_dtls",hosp_dtls);
			}
			if(prof_dtls!=null)
			{
				tabdata.put("prof_dtls",prof_dtls);
			}
			if(addl_dtls!=null)
			{
				tabdata.put("addl_dtls",addl_dtls);
			}
/*********ADDED BY RAM GHL-CRF-1.2****************************************************/
			if(pat_reg_dtls!=null)
			{
				tabdata.put("pat_reg_dtls",pat_reg_dtls);
			}
/*******************END******************************************/
		
			/** Added By Rajesh V to get Visit Type **/ 	
			StringTokenizer stPriority=new StringTokenizer(str_ins_cust_priority,"|");				
			StringTokenizer stCustGrp=new StringTokenizer(str_ins_cust_group_code,"|");
			StringTokenizer stCust=new StringTokenizer(str_ins_cust_code,"|");
			StringTokenizer stPolicy=new StringTokenizer(str_ins_policy_type_code,"|");
			StringTokenizer stBlngGrp=new StringTokenizer(str_ins_blng_grp,"|");
			Connection con = null;
			CallableStatement cstmt = null;
			PreparedStatement pstmt = null;
			ResultSet rst = null;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String strPriority = "";
			String strCustGroup = "";
			String strCust = "";
			String strPolicy = "";
			String strBlngGrpId = "";
			String strClinicCode = (String)session.getAttribute("clinic_code");
			String strFacilityId = (String)session.getAttribute("facility_id") ;	
			String calling_function_id = "";
			String outEpisodeId = "";
			String visitType = "";
			String opParam = "";
			String outBlngGrpId = "";
			String outCustGrpCode = "";
			String outCustCode = "";
			String outPolicyCode = "";
			try{
				con = ConnectionManager.getConnection();
				pstmt = con.prepareStatement("Select VISIT_TYPE_DERV_RULE from op_param where operating_facility_id = ? ");
				pstmt.setString(1, strFacilityId);
				rst = pstmt.executeQuery();
				if(rst != null){
					while(rst.next()){
						opParam = rst.getString("VISIT_TYPE_DERV_RULE");
					}
				}
				
		//	opParam ="B";
				System.err.println("opParam->"+opParam);
				


				if("B".equals(opParam))
				{
				while(stPriority.hasMoreTokens()){
					strPriority = stPriority.nextToken();
					strCustGroup =stCustGrp.nextToken();
					strCust = stCust.nextToken();
					strPolicy =stPolicy.nextToken();
					strBlngGrpId = stBlngGrp.nextToken();
					if("1".equals(strPriority)){
							break;
							}
				}


						System.err.println("strPriority->"+strPriority);
						System.err.println("strCustGroup->"+strCustGroup);
						System.err.println("strCust->"+strCust);
						System.err.println("strPolicy->"+strPolicy);
						System.err.println("strBlngGrpId->"+strBlngGrpId);
						System.err.println("strClinicCode->"+strClinicCode);
						System.err.println("encounter_date_time->"+encounter_date_time);

						String clinicPatType = (String) session.getAttribute("clinic_code_bl_op");
						if(clinicPatType == null){
							clinicPatType = "";
						}
						
						String arr[] = clinicPatType.split("::##");
						String strPatientId = "";
						String stClinicCode = "";
						String strEpsdType = "";
						String visitDate = "";
						System.err.println("arr.length->"+arr.length);
						if(arr.length == 5){
							stClinicCode = arr[0];
							strPatientId = arr[1];
							strEpsdType = arr[2];
							calling_function_id = arr[3];
							visitDate = arr[4];
						}
						System.err.println("Session value->"+(String) session.getAttribute("clinic_code_bl_op"));
						System.err.println("stClinicCode->"+stClinicCode);
						System.err.println("strPatientId->"+strPatientId);
						System.err.println("strEpsdType->"+strEpsdType);
						System.err.println("visitDate->"+visitDate);
						if(("O".equals(strEpsdType))&&("VISIT_REGISTRATION".equals(calling_function_id)))
							{
							
								cstmt = con.prepareCall("{ call   bl_interface_proc.proc_first_or_followup_visit (?,?,?,?,to_date(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,?,?,?,?,?,?,?) }");
								cstmt.setString(1, strFacilityId);
								cstmt.setString(2, strPatientId);
								cstmt.setString(3, strEpsdType);
								cstmt.setString(4, stClinicCode);
								
								if((visitDate == null) || (("").equals(visitDate))){
									cstmt.setString(5, "SYSDATE");
								}
								else{
					//				Date fromDt = new Date(sdf.parse(visitDate).getTime());
					//				cstmt.setDate(5, fromDt);
									cstmt.setString(5, visitDate);
								}
								
								cstmt.setString(6, strCustGroup);
								cstmt.setString(7, strCust);
								cstmt.setString(8, strPolicy);
								if(strBlngGrpId == null || "".equals(strBlngGrpId)){
									strBlngGrpId = str_blng_grp;
								}
								
								cstmt.setString(9, strBlngGrpId);
								cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
								cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
								cstmt.registerOutParameter(12, java.sql.Types.VARCHAR);
								cstmt.registerOutParameter(13, java.sql.Types.VARCHAR);
								cstmt.registerOutParameter(14, java.sql.Types.VARCHAR);
								cstmt.registerOutParameter(15, java.sql.Types.VARCHAR);
								cstmt.execute();
								outEpisodeId = cstmt.getString(10);
								visitType = cstmt.getString(11);
								outBlngGrpId = cstmt.getString(12);
								outCustGrpCode = cstmt.getString(13);
								outCustCode = cstmt.getString(14);
								outPolicyCode = cstmt.getString(15);
								System.err.println("outEpisodeId->"+outEpisodeId);
								System.err.println("visitType->"+visitType);
								System.err.println("outEpisodeId->"+outBlngGrpId);
								System.err.println("visitType->"+outCustGrpCode);
								System.err.println("outEpisodeId->"+outCustCode);
								System.err.println("visitType->"+outPolicyCode);
								
								if((visitType != null) && !("".equals(visitType))){
									StringBuffer strScript = new StringBuffer();
									strScript.append("<script> ");
									strScript.append("var returnVar = parent.window.returnValue; ");
									strScript.append("var tempVar = new Array(); ");
									strScript.append("tempVar.push(returnVar); ");
									strScript.append("tempVar.push('"+visitType+"'); ");
									strScript.append("tempVar.push('"+outEpisodeId+"'); ");
									strScript.append("tempVar.push('"+outBlngGrpId+"'); ");
									strScript.append("tempVar.push('"+outCustCode+"'); ");
									strScript.append("tempVar.push('"+outCustGrpCode+"'); ");
									strScript.append("tempVar.push('"+outPolicyCode+"'); ");
									strScript.append("parent.window.returnValue = tempVar; ");									
									strScript.append("</script> ");
									out.println(strScript.toString());
								}
						}
						session.removeAttribute("clinic_code_bl_op");
				///	}
				}
			}
			catch(Exception e){
				System.err.println("Exception in BLFinancialDetailsServlet while getting Visit Type->"+e);
			}
			finally{
				ConnectionManager.returnConnection(con);
				cstmt = null;
			}
			
/** Ends Here**/
/*********ADDED BY KARTHIK TO INCLUDE INSURANCE POLICY DETAILS INCLUDE_POLICY_DETAILS_CRF ****************************************************/
			
				/*
				Karthik added here to test for Adding Policy Details 5/30/2013
				
				For each and every Payer in the Financial Details Page this module 
				adds a Policy Detail bean along with it.
				
				- Policies loaded from EncounterSpecificPolicyMap & Session are merged
				- Key (pyrPriority+"~"+pyrGrp+"~"+pyr+"~"+pcy) is used to fetch detail of a single payer from the Map
				  
				*/
			HashMap policyDetailsMap=new HashMap();
			String policyBLInclusionFlag= (session.getAttribute("LINK_POLICY_IN_BILLING")==null) ? "N": (String)session.getAttribute("LINK_POLICY_IN_BILLING");
			String mp_change_patient_valid= (String) session.getAttribute("MP_CHANGE_PATIENT_VALID");
			if(policyBLInclusionFlag!=null && policyBLInclusionFlag.equals("Y")){			
				
				HashMap encParamMap=(session.getAttribute("ENCOUNTER_POLICY_RECORD_ELEMENTS")==null)? new HashMap():(HashMap)session.getAttribute("ENCOUNTER_POLICY_RECORD_ELEMENTS");
				System.err.println("ENCOUNTER_POLICY_RECORD_ELEMENTS from Session"+encParamMap);
				
				String pol_bean_id		= "PayerPolicyInsuranceMasterBean" ;
				String pol_bean_name	= "eBL.PolicyInsuranceMasterBean";
				PolicyInsuranceMasterBean pol_bean			= (PolicyInsuranceMasterBean)getBeanObject( pol_bean_id, pol_bean_name, req ) ;
				
				//Merging Deleted Bean with Regular Bean - Rajesh V
				/*pol_bean = mergeBeans(req);
				String deletedBeanId = "DeletedPayerPolicyBean";
				PolicyInsuranceMasterBean deletedPolicyBean = (PolicyInsuranceMasterBean) getBeanObject(deletedBeanId, pol_bean_name, req);
				//cleanBeanObject(deletedBeanId, pol_bean_name, req);
				deletedPolicyBean.clearAll();*/
				//Merging Deleted Bean with Regular Bean - Rajesh V				
				
				String enc_pol_bean_id		= "EncPolicyInsuranceMasterBean" ;
				String enc_pol_bean_name	= "eBL.PolicyInsuranceMasterBean";							
				PolicyInsuranceMasterBean enc_pol_bean		= 	(PolicyInsuranceMasterBean)getBeanObject( enc_pol_bean_id, enc_pol_bean_name, req ) ;


				String facility_id= (String)session.getAttribute("facility_id") ;		
				String enc_patient_id="";	
				String enc_episode_type="";
				String enc_episode_id="";	
				String enc_visit_id="";	
				String enc_locale="";		
				String strEncPatRegDate="";

				if(encParamMap != null)
				{				
				 enc_patient_id=	(encParamMap.get("enc_patient_id")==null) ? "":(String)encParamMap.get("enc_patient_id");
				 enc_episode_type=	(encParamMap.get("enc_episode_type")==null) ? "":(String)encParamMap.get("enc_episode_type");
				 enc_episode_id=	(encParamMap.get("enc_episode_id")==null) ? "":(String)encParamMap.get("enc_episode_id");
				 enc_visit_id=		(encParamMap.get("enc_visit_id")==null) ? "":(String)encParamMap.get("enc_visit_id");
				 enc_locale=		(encParamMap.get("enc_locale")==null) ? "":(String)encParamMap.get("enc_locale");
				 strEncPatRegDate=	(encParamMap.get("encounter_date")==null) ? "":(String)encParamMap.get("encounter_date");
				}
				
				PolicyInsuranceMasterBean encBeanInstance	=	null;
				HashMap<String, PolicyInsuranceMasterBean> encMasterMap = null;
				System.err.println("enc_pol_bean.getPreviousEncounterDetials("+facility_id+","+enc_patient_id+","+enc_episode_type+","+enc_episode_id+","+enc_visit_id+","+enc_locale+","+strEncPatRegDate+")");

				
				//Encounter Specific Policy Beans gets loaded here
				if((!enc_episode_id.equals(""))||enc_episode_type.equals("R")){
				System.err.println("enc_pol_bean.getPreviousEncounterDetials("+facility_id+","+enc_patient_id+","+enc_episode_type+","+enc_episode_id+","+enc_visit_id+","+enc_locale+","+strEncPatRegDate+")");
				encBeanInstance=enc_pol_bean.getPreviousEncounterDetials(facility_id, enc_patient_id, enc_episode_type, enc_episode_id, enc_visit_id, enc_locale,strEncPatRegDate);
				/// Values  encounter specific defination mode flag to be enabled
				
				
				encMasterMap=encBeanInstance.getMasterMap();
				}
				if( encMasterMap==null ){
				encMasterMap=new HashMap<String, PolicyInsuranceMasterBean>();
				}
				System.err.println("EncounterMap returned:"+encMasterMap);

				
				HashMap<String, PolicyInsuranceMasterBean> masterMap = new HashMap<String, PolicyInsuranceMasterBean>();
				masterMap=pol_bean.getMasterMap();
				if( masterMap==null ){
					masterMap=new HashMap<String, PolicyInsuranceMasterBean>();
				}				
				
								
					encMasterMap.putAll(masterMap);
				System.err.println("MasterMap returned:"+encMasterMap);
				
				
				//Appending Encounter Specific Bean Records along with the MasterMap which contains all Session Policy Records		
				//masterMap.putAll(encMasterMap);
				//pol_bean.setMasterMap(masterMap);
				//encMasterMap.putAll(masterMap);
				pol_bean.setMasterMap(encMasterMap);

				System.err.println("New MasterMap -> (EncounterMap + MasterMap ):"+encMasterMap);
				
	
				StringTokenizer st1=new StringTokenizer(str_ins_cust_priority,"|");				
				StringTokenizer st2=new StringTokenizer(str_ins_cust_group_code,"|");
				StringTokenizer st3=new StringTokenizer(str_ins_cust_code,"|");
				StringTokenizer st4=new StringTokenizer(str_ins_policy_type_code,"|");
				StringTokenizer st5=new StringTokenizer(str_ins_policy_no,"|");
				
				StringTokenizer st6=new StringTokenizer(str_ins_policy_start_date,"|");
				StringTokenizer st7=new StringTokenizer(str_ins_policy_expiry_date,"|");
				StringTokenizer st8=new StringTokenizer(str_ins_credit_approval_amount,"|");
				StringTokenizer st9=new StringTokenizer(str_ins_credit_approval_days,"|");
				
				PolicyInsuranceMasterBean beanInstance=null;		
				while(st1.hasMoreTokens()){
					String pyrPriority=st1.nextToken();
					String pyrGrp=st2.nextToken();
					String pyr=st3.nextToken();
					String pcy=st4.nextToken();
					String pcyNo=st5.nextToken();
					String pyrKey=pyrPriority+"~"+pyrGrp+"~"+pyr+"~"+pcy+"~"+pcyNo;
					
					System.err.println(">pyrKey:"+pyrKey);
					System.err.println(">>>Master Map in Session:"+pol_bean.getMasterMap());	
				
					//Checks whether the Policy Bean is already present in Session i.e, when the user has modified the policy 					
					if(pol_bean.getMasterMap()!=null){
					System.err.println("Policy Already Present in Session");		
					beanInstance=pol_bean.getMasterMap().get(pyrKey);
					}
					
					//If the data is not in encounter MapList and policyBean MapList get From DB
					if(beanInstance==null){	
					System.err.println("Policy is Taken From DB"+facility_id+" "+pyrGrp+" "+pyr+" "+pcy+" "+locale);

					//Policy is chosen based on the combination of PayerGroup, Payer and Policy from DB as no Records in Session
					beanInstance=pol_bean.getPolicyDefinitionDetials(facility_id, pyrGrp, pyr, pcy, locale); 
					}					
					

					if( beanInstance != null)
					{

					beanInstance.setStartDate(st6.nextToken());
					beanInstance.setEndDate(st7.nextToken());
					beanInstance.setApprovedAmt(st8.nextToken());
					beanInstance.setApprovedDays(st9.nextToken());
					/* 12/07/2013	Karthikeyan K	MMS-QH-CRF-0010	36789 starts*/
					HashMap validAcrossEncMap = (HashMap)session.getAttribute("VALID_ACROSS_ENCOUNTER_MAP");	
					if(validAcrossEncMap!=null){
					String validForEncounter=(String)validAcrossEncMap.get(pcy+pyrPriority);
					beanInstance.setAcrossGroupId(validForEncounter);
					}
					/* 12/07/2013	Karthikeyan K	MMS-QH-CRF-0010	36789 ends*/
					System.err.println(">>>>>>>After Adding policies in beanInstance pyrPriority:AcrossGroupId "+pyrPriority+":"+beanInstance.getAcrossGroupId());
					System.err.println(">>>>>>>After Adding policies in beanInstance startDate "+beanInstance.getStartDate());
					System.err.println(">>>>>>>After Adding policies in beanInstance EndDate "+beanInstance.getEndDate());
					System.err.println(">>>>>>>After Adding policies in beanInstance ApprovedAmt "+beanInstance.getApprovedAmt());
					System.err.println(">>>>>>>After Adding policies in beanInstance ApprovedDays "+beanInstance.getApprovedDays());
					System.err.println(">>>>>>>After Adding policies in policyDetailsMap: "+policyDetailsMap);	
					}


					policyDetailsMap.put(pyrKey, beanInstance);
					session.setAttribute("ENCOUNTER_POLICY_RECORD_ELEMENTS",null);
				}
				
				

				/*
				HashMap<String,List<PolicyInsuranceMasterBean>> policyMap = beanInstance.getPolicyMap();
				System.err.println("#######1  Policy  map details  "+ policyMap);
				List<PolicyInsuranceMasterBean> inclList = policyMap.get("inclExclCoverage");
				System.err.println("#######2  Policy  map details  "+ inclList);
																	
				for(PolicyInsuranceMasterBean outPatBean : inclList)
					{
												System.out.println("#######  "+outPatBean.getDelFlag());
												System.err.println("#######  "+outPatBean.getBillServCode());
												System.err.println("#######  "+outPatBean.getPatClass());
												System.err.println("#######  "+outPatBean.getInclExclInd());
												System.err.println("#######  "+outPatBean.getInclusionBasis());
												System.err.println("#######  "+outPatBean.getValue());
												System.err.println("#######  "+outPatBean.getBillServChk());
												System.err.println("#######  "+outPatBean.getValueChk1());
												System.err.println("#######  "+outPatBean.getInclExclIndChk());
												System.err.println("#######  "+outPatBean.getValueChk4());
												System.err.println("#######  "+outPatBean.getValueChk3());
												System.err.println("#######  "+outPatBean.getAmtPerVisit());
												System.err.println("#######  "+outPatBean.getServItemQty());
												System.err.println("#######  "+outPatBean.getAmtPerIPDay());
												System.err.println("#######  "+outPatBean.getNoOfDays());
												System.err.println("#######  "+outPatBean.getEpisodeEncounter());
												System.err.println("#######  "+outPatBean.getClinicNurs());
												System.err.println("#######  "+outPatBean.getClinicNursCode());
												System.err.println("#######  "+outPatBean.getSpecCode());
		
				}	 
				*/

		
	}

			tabdata.put("payer_plcy_dtls",policyDetailsMap);
			tabdata.put("mp_change_patient_valid",mp_change_patient_valid);
			
/* Karthik added the code to add claim code starts   - IN50355 */	
			
			String credit_authorisation_by="";
			String claim_code="";
			String membership_number="";
			
			String finDetClose="Y";
			
			
			HashMap<String,String> claimCreditMap=(HashMap)session.getAttribute("CLAIM_CREDIT_MAP_SESSION");
			StringTokenizer strPriorityTok=new StringTokenizer(str_ins_cust_priority,"|");
			
			while(strPriorityTok.hasMoreTokens()){
				
				String claimCredit=claimCreditMap.get(strPriorityTok.nextToken());				
				
				String temp_claim_code="";
				String temp_credit_authorisation_by="";
				String temp_membership_number="";
				
				String[] arrClaimCredit= StringUtils.splitPreserveAllTokens(claimCredit,"~");
				if(arrClaimCredit.length >0){
					temp_claim_code=arrClaimCredit[0];
					temp_credit_authorisation_by=arrClaimCredit[1];
					temp_membership_number=arrClaimCredit[2];
				}
/*				StringTokenizer stClaimCredit=new StringTokenizer(claimCredit,"~");
				String temp_claim_code=stClaimCredit.nextToken();
				if(temp_claim_code==null) temp_claim_code="";
				String temp_crdt_auth=stClaimCredit.nextToken();
				if(temp_crdt_auth==null) temp_crdt_auth="";*/
				
				credit_authorisation_by	+= temp_credit_authorisation_by +"|";
				claim_code				+= temp_claim_code+ "|";
				membership_number		+= temp_membership_number+ "|";
				
			}
			


			tabdata.put("credit_authorisation_by", credit_authorisation_by);
			tabdata.put("claim_code", claim_code);
			tabdata.put("membership_number", membership_number);
			
/* Karthik added the code to add claim code ends  - IN50355 */
/*******************END******************************************/	
			
//			tabdata.put("total_records",str_total_records);
			tabdata.put("fin_det_close", finDetClose);
			
			System.err.println("finDetClose :"+finDetClose);
			System.err.println("tabdata:"+tabdata);		
			session.setAttribute("financial_details",(HashMap)tabdata);
			System.err.println("####### BLFianicialDetailsServlet  financial_details -------->"+tabdata);
			System.err.println("####### BLFianicialDetailsServlet  fin_dtls in Submit:"+(HashMap)session.getAttribute("financial_details"));

			if(tabdata!=null)
			{
				session.removeAttribute("hosp_panel_str");
				session.removeAttribute("prof_panel_str");
				session.removeAttribute("addl_panel_str");
				session.removeAttribute("prof_panel_str_YN");
				session.removeAttribute("hosp_panel_str_YN");
				session.removeAttribute("addl_panel_str_YN");
				session.removeAttribute("upd_hosp_chrg_amt");
				session.removeAttribute("upd_hosp_chrg_pat_amt");
				session.removeAttribute("upd_med_chrg_amt");
				session.removeAttribute("upd_med_chrg_pat_amt");
				session.removeAttribute("upd_addl_chrg_amt");
				session.removeAttribute("upd_addl_chrg_pat_amt");
				session.removeAttribute("hosp_dtls");
				session.removeAttribute("prof_dtls");
				session.removeAttribute("addl_dtls");
				session.removeAttribute("fin_dtls_to_chrg_dtls");
				session.removeAttribute("hosp_panel");
				session.removeAttribute("prof_panel");
				session.removeAttribute("addl_panel");
/*********ADDED BY RAM GHL-CRF-1.2****************************************************/
				session.removeAttribute("pat_reg_panel_str");
				session.removeAttribute("pat_reg_panel_str_YN");
				session.removeAttribute("upd_pat_reg_chrg_amt");
				session.removeAttribute("upd_pat_reg_chrg_pat_amt");
				session.removeAttribute("pat_reg_dtls");
				session.removeAttribute("pat_reg_panel");
/********************END**************************************************************/


			}

//			System.out.println("fin_dtls in Submit After Session Removal:"+(HashMap)session.getAttribute("financial_details"));
			
			out.println("<script>parent.window.close(); </script>");
		} 
		catch (Exception e1) 
		{
				e1.printStackTrace();
		}

	}
	
	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		Object obj = PersistenceHelper.getBeanObject(id,ClassName,request);		
		return obj;
	}
	
	/*public PolicyInsuranceMasterBean mergeBeans(HttpServletRequest request){
		String beanId = "PayerPolicyInsuranceMasterBean";
		String beanName = "eBL.PolicyInsuranceMasterBean";
		PolicyInsuranceMasterBean policyBean = null;
		
		PolicyInsuranceMasterBean policyBeanMain = (PolicyInsuranceMasterBean) getBeanObject(beanId, beanName, request);
		
		if(policyBeanMain.getMasterMap() == null)
		{
			policyBeanMain.setMasterMap(new HashMap<String,PolicyInsuranceMasterBean>());
		}
		
		HashMap<String,PolicyInsuranceMasterBean> masterMap = policyBeanMain.getMasterMap();
		
		

		//Delete Definitions
		String deletedBeanId = "DeletedPayerPolicyBean";
		PolicyInsuranceMasterBean deletedPolicyBean = null;
		
		PolicyInsuranceMasterBean deletedPolicyBeanMain = (PolicyInsuranceMasterBean) getBeanObject(deletedBeanId, beanName, request);
		
		if(deletedPolicyBeanMain.getMasterMap() == null)
		{
			deletedPolicyBeanMain.setMasterMap(new HashMap<String,PolicyInsuranceMasterBean>());
		}
		
		HashMap<String,PolicyInsuranceMasterBean> deletedMasterMap = deletedPolicyBeanMain.getMasterMap();		
		//Delete Definitions
		
		for (Iterator iterator = masterMap.keySet().iterator(); iterator.hasNext();) {
			String keyVal = (String) iterator.next();
			if(masterMap.get(keyVal) != null && deletedMasterMap.get(keyVal) != null){
				policyBean = masterMap.get(keyVal);
				deletedPolicyBean = deletedMasterMap.get(keyVal);
				policyBean = mergeIndividualBeans(policyBean,deletedPolicyBean);
				masterMap.put(keyVal, policyBean);
			}
			
		}
		policyBeanMain.setMasterMap(masterMap);
		
		return policyBeanMain;
	}

	private PolicyInsuranceMasterBean mergeIndividualBeans(PolicyInsuranceMasterBean policyBean,PolicyInsuranceMasterBean deletedPolicyBean) {
		if(policyBean != null){
			if(policyBean.getPolicyMap() == null)
			{
				policyBean.setPolicyMap(new HashMap<String, List<PolicyInsuranceMasterBean>>());
			}
			
			if(policyBean.getPopupMap() == null)
			{
				policyBean.setPopupMap(new HashMap<String, List<PolicyInsuranceMasterBean>>());
			}
		}
		
		HashMap<String, List<PolicyInsuranceMasterBean> > policyMap = policyBean.getPolicyMap();
		HashMap<String, List<PolicyInsuranceMasterBean> > popupMap = policyBean.getPopupMap();
		
		//Delete Definitions
		if(deletedPolicyBean != null){
			
			if(deletedPolicyBean.getPolicyMap() == null)
			{
				deletedPolicyBean.setPolicyMap(new HashMap<String, List<PolicyInsuranceMasterBean>>());
			}
			
			if(deletedPolicyBean.getPopupMap() == null)
			{
				deletedPolicyBean.setPopupMap(new HashMap<String, List<PolicyInsuranceMasterBean>>());
			}
		}
		
		HashMap<String, List<PolicyInsuranceMasterBean> > deletedPolicyMap = deletedPolicyBean.getPolicyMap();
		HashMap<String, List<PolicyInsuranceMasterBean> > deletedPopupMap = deletedPolicyBean.getPopupMap();
		//Delete Definitions
		
		List<PolicyInsuranceMasterBean> covList = policyMap.get("inclExclCoverage");
		List<PolicyInsuranceMasterBean> deletedCovList = deletedPolicyMap.get("inclExclCoverage");
		if(covList != null && deletedCovList != null){
			covList.addAll(deletedCovList);
		}
		
		policyMap.put("inclExclCoverage", covList);
		
		covList = null;
		deletedCovList = null;
		
		covList = policyMap.get("preApproval");
		deletedCovList = deletedPolicyMap.get("preApproval");
		if(covList != null && deletedCovList != null){
			covList.addAll(deletedCovList);
		}
		
		policyMap.put("preApproval", covList);
		
		for (Iterator iterator = popupMap.keySet().iterator(); iterator.hasNext();) {
			String keyVal = (String) iterator.next();
			if(popupMap.get(keyVal) != null && deletedPopupMap.get(keyVal) != null){
				covList = popupMap.get(keyVal);
				deletedCovList = deletedPopupMap.get(keyVal);
				covList.addAll(deletedCovList);
				popupMap.put(keyVal, covList);
			}
			
		}
		
		policyBean.setPolicyMap(policyMap);
		policyBean.setPopupMap(popupMap);
		
		return policyBean;
	}*/
}
