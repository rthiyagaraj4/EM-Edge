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
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;


public class BLFinancialDetailsCloseConsultServlet extends javax.servlet.http.HttpServlet
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
		try 
		{
			HashMap tabdata = new HashMap();

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
			String str_ins_restrict_check="";

			String locale			= (String)session.getAttribute("LOCALE");

			HashMap hosp_dtls=(HashMap)session.getAttribute("hosp_dtls");
//			System.out.println("hosp_dtls in servlet:"+hosp_dtls);
			HashMap prof_dtls=(HashMap)session.getAttribute("prof_dtls");
//			System.out.println("prof_dtls in servlet:"+prof_dtls);
			HashMap addl_dtls=(HashMap)session.getAttribute("addl_dtls");
//			System.out.println("addl_dtls in servlet:"+addl_dtls);

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
			tabdata.put("upd_patient_fin_dtls_yn",str_upd_patient_fin_dtls_yn);
			tabdata.put("user_id",str_user_id);
			tabdata.put("fin_auth_user_id",str_fin_auth_user_id);
			tabdata.put("calling_function_id",str_calling_function_id);
			tabdata.put("locale",locale);
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
			
			session.setAttribute("financial_details",(HashMap)tabdata);
//			System.out.println("fin_dtls in CloseConsultServlet:"+(HashMap)session.getAttribute("financial_details"));

			
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
			}

//			System.out.println("fin_dtls in CloseConsultServlet After Session Removal:"+(HashMap)session.getAttribute("financial_details"));
			
			//out.println("<script>parent.window.close();</script>");
			//out.println("<script>parent.parent.document.getElementById('dialog_tag').close()</script>");
			out.println("<script>parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();</script>");
		} 
		catch (Exception e1) 
		{
				e1.printStackTrace();
		}

	}
}
