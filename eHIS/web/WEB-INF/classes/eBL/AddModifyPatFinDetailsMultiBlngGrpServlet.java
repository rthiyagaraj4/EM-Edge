/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 
/*
Sr No        Version           Incident        SCF/CRF              					 Developer Name
---------------------------------------------------------------------------------------------------------------
1            V232504							SKR-SCF-1731-TF         				Namrata Charate
2			 V230707							AAKH-CRF-0142.1							Namrata Charate
*/
package eBL;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eBL.*;


public class AddModifyPatFinDetailsMultiBlngGrpServlet extends javax.servlet.http.HttpServlet
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

			multiBlngGrpDetails(req,res,session,out);
			
		} 
		catch (Exception e) 
		{
				e.printStackTrace();
		}
	}
	private void multiBlngGrpDetails(HttpServletRequest req,
			HttpServletResponse res,HttpSession session, PrintWriter out) 
	{
		try 
		{
			HashMap tabdata = new HashMap();

			String str_total_records=req.getParameter("total_records");
			int total_records=Integer.parseInt(str_total_records);
			String str_ins_blng_grp=req.getParameter("rtn_ins_blng_grp");
			String str_ins_blng_grp_desc=req.getParameter("rtn_ins_blng_grp_desc");
			String str_ins_payer_desc=req.getParameter("rtn_ins_payer_desc");
			String str_ins_cust_code=req.getParameter("rtn_ins_cust_code");
			String str_ins_cust_priority=req.getParameter("rtn_ins_cust_priority");
			String str_ins_policy_type_desc=req.getParameter("rtn_ins_policy_type_desc");
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
			String str_ins_restrict_check=req.getParameter("rtn_ins_restrict_check");
			String str_ins_apprd_amt_restrict_check=req.getParameter("rtn_ins_apprd_amt_restrict_check");
			String str_ins_apprd_days_restrict_check=req.getParameter("rtn_ins_apprd_days_restrict_check");
			String str_ins_valid_payer_YN=req.getParameter("rtn_ins_valid_payer_YN");
			String str_ins_valid_policy_type_code_YN=req.getParameter("rtn_ins_valid_policy_type_code_YN");
			String str_ins_cust_group_code=req.getParameter("rtn_ins_cust_group_code");
			String str_ins_cust_group_name=req.getParameter("rtn_ins_cust_group_name");
			String str_ins_policy_coverage_basis_ind=req.getParameter("rtn_ins_policy_coverage_basis_ind");

			String str_ref_src_main_code = req.getParameter("rtn_ref_src_main_code");
			String str_ref_src_main_desc = req.getParameter("rtn_ref_src_main_desc");
			String str_ref_src_sub_code = req.getParameter("rtn_ref_src_sub_code");
			String str_ref_src_sub_desc = req.getParameter("rtn_ref_src_sub_desc");

			 //Added by prithivi on 13/03/2017 for mms-qh-crf-0085 bupa patient eligibility check
			String rtn_payerEligibilityParamSession=req.getParameter("rtn_payerEligibilityParamSession");	
			System.out.println("AddModifyPatFinDetailsMultiBlngGrpServlet.java:::rtn_payerEligibilityParamSession...."+rtn_payerEligibilityParamSession);
			if(rtn_payerEligibilityParamSession == null) rtn_payerEligibilityParamSession="";
			String rtn_responseCode=req.getParameter("rtn_responseCode");			
			if(rtn_responseCode == null) rtn_responseCode="";
			String rtn_responseCodeDesc=req.getParameter("rtn_responseCodeDesc");
			System.out.println("AddModifyPatFinDetailsMultiBlngGrpServlet.java:::rtn_responseCodeDesc...."+rtn_responseCodeDesc);
			if(rtn_responseCodeDesc == null) rtn_responseCodeDesc="";
			String rtn_statuDescription=req.getParameter("rtn_statuDescription");			
			if(rtn_statuDescription == null) rtn_statuDescription="";
			String rtn_validityPeriod=req.getParameter("rtn_validityPeriod");			
			if(rtn_validityPeriod == null) rtn_validityPeriod="";
			String rtn_validityPeriodDesc=req.getParameter("rtn_validityPeriodDesc");			
			if(rtn_validityPeriodDesc == null) rtn_validityPeriodDesc="";
			String rtn_eligibilityCode=req.getParameter("rtn_eligibilityCode");			
			if(rtn_eligibilityCode == null) rtn_eligibilityCode="";
			String rtn_transactionId=req.getParameter("rtn_transactionId");			
			if(rtn_transactionId == null) rtn_transactionId="";
			String rtn_responseDateTime=req.getParameter("rtn_responseDateTime");
			System.out.println("AddModifyPatFinDetailsMultiBlngGrpServlet.java:::rtn_responseDateTime...."+rtn_responseDateTime);
			if(rtn_responseDateTime == null) rtn_responseDateTime="";
			
			//V232504
			String rtn_mcn_for_policy = req.getParameter("rtn_mcn_for_policy");			
			if(rtn_mcn_for_policy == null) rtn_mcn_for_policy="";
			System.out.println("AddModifyPatFinDetailsMultiBlngGrpServlet.java:::rtn_mcn_for_policy...."+rtn_mcn_for_policy);
			
			//V232504
			String rtn_reg_ref_id = req.getParameter("rtn_reg_ref_id");			
			if(rtn_reg_ref_id == null) rtn_reg_ref_id="";
			System.out.println("AddModifyPatFinDetailsMultiBlngGrpServlet.java:::rtn_reg_ref_id...."+rtn_reg_ref_id);
			


			StringTokenizer	tokenizer=null;
			int i=0;
			ArrayList al_ins_blng_grp=new ArrayList();
			ArrayList al_ins_blng_grp_desc=new ArrayList();
			ArrayList al_ins_payer_desc=new ArrayList();
			ArrayList al_ins_cust_code=new ArrayList();
			ArrayList al_ins_cust_group_code=new ArrayList();
			ArrayList al_ins_cust_priority=new ArrayList();
			ArrayList al_ins_policy_type_desc=new ArrayList();
			ArrayList al_ins_policy_type_code=new ArrayList();
			ArrayList al_ins_policy_no=new ArrayList();
			ArrayList al_ins_policy_start_date=new ArrayList();
			ArrayList al_ins_policy_expiry_date=new ArrayList();
			ArrayList al_ins_credit_auth_ref=new ArrayList();
			ArrayList al_ins_credit_auth_date=new ArrayList();
			ArrayList al_ins_cred_auth_req_yn=new ArrayList();
			ArrayList al_ins_cred_auth_mand_capt_yn=new ArrayList();			
			ArrayList al_ins_dflt_auth_ref_as_pol_no_yn=new ArrayList();
			ArrayList al_ins_credit_approval_days=new ArrayList();
			ArrayList al_ins_credit_approval_amount=new ArrayList();
			ArrayList al_ins_policy_eff_from_date=new ArrayList();
			ArrayList al_ins_policy_eff_to_date=new ArrayList();
			ArrayList al_ins_adj_rule_ind=new ArrayList();
			ArrayList al_ins_adj_perc_amt_ind=new ArrayList();
			ArrayList al_ins_adj_perc_amt_value=new ArrayList();
			ArrayList al_ins_pmnt_diff_adj_int=new ArrayList();
			ArrayList al_ins_drg_pmnt_diff_adj_int=new ArrayList();
			ArrayList al_ins_spl_srv_pmnt_diff_adj_int=new ArrayList();
			ArrayList al_ins_restrict_check=new ArrayList();
			ArrayList al_ins_apprd_amt_restrict_check=new ArrayList();
			ArrayList al_ins_apprd_days_restrict_check=new ArrayList();
			ArrayList al_ins_valid_payer_YN=new ArrayList();
			ArrayList al_ins_valid_policy_type_code_YN=new ArrayList();
			ArrayList al_ins_cust_group_name=new ArrayList();
			ArrayList al_ins_policy_coverage_basis_ind=new ArrayList();


			ArrayList al_rtn_payerEligibilityParamSession=new ArrayList();
			ArrayList al_rtn_responseCode=new ArrayList();
			ArrayList al_rtn_responseCodeDesc=new ArrayList();
			ArrayList al_rtn_statuDescription=new ArrayList();
			ArrayList al_rtn_validityPeriod=new ArrayList();
			ArrayList al_rtn_validityPeriodDesc=new ArrayList();
			ArrayList al_rtn_eligibilityCode=new ArrayList();
			ArrayList al_rtn_transactionId=new ArrayList();
			ArrayList al_rtn_responseDateTime=new ArrayList();
			
			ArrayList al_rtn_mcn_for_policy = new ArrayList();  //V232504
			ArrayList al_rtn_reg_ref_id = new ArrayList();  //V232504
			

			System.out.println("******* MultiBlngGrpServlet.java ********* ");
			tokenizer=new StringTokenizer(str_ins_blng_grp_desc,"|");
			while(tokenizer.hasMoreTokens())
			{
				al_ins_blng_grp_desc.add(i,tokenizer.nextToken());
				i++;
			}
			i=0;
			tokenizer=new StringTokenizer(str_ins_blng_grp,"|");
			while(tokenizer.hasMoreTokens())
			{
				al_ins_blng_grp.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_payer_desc,"|");
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_payer_desc.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_cust_code,"|");
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_cust_code.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_cust_priority,"|");
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_cust_priority.add(i,tokenizer.nextToken());
				i++;
			}

			System.out.println("priority list size..."+al_ins_cust_priority.size());

			tokenizer=new StringTokenizer(str_ins_policy_type_desc,"|");
			
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_policy_type_desc.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_policy_type_code,"|");
			
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_policy_type_code.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_policy_no,"|");
			
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_policy_no.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_policy_start_date,"|");
			
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_policy_start_date.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_policy_expiry_date,"|");
			
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_policy_expiry_date.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_credit_auth_ref,"|");
			
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_credit_auth_ref.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_credit_auth_date,"|");
			
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_credit_auth_date.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_cred_auth_req_yn,"|");
			
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_cred_auth_req_yn.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_cred_auth_mand_capt_yn,"|");
			
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_cred_auth_mand_capt_yn.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_dflt_auth_ref_as_pol_no_yn,"|");
			
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_dflt_auth_ref_as_pol_no_yn.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_credit_approval_days,"|");
			
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_credit_approval_days.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_credit_approval_amount,"|");
			
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_credit_approval_amount.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_policy_eff_from_date,"|");
			
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_policy_eff_from_date.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_policy_eff_to_date,"|");
			
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_policy_eff_to_date.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_adj_rule_ind,"|");
			
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_adj_rule_ind.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_adj_perc_amt_ind,"|");
			
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_adj_perc_amt_ind.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_adj_perc_amt_value,"|");
			
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_adj_perc_amt_value.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_pmnt_diff_adj_int,"|");
			
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_pmnt_diff_adj_int.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_drg_pmnt_diff_adj_int,"|");
			
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_drg_pmnt_diff_adj_int.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_spl_srv_pmnt_diff_adj_int,"|");
			
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_spl_srv_pmnt_diff_adj_int.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_restrict_check,"|");
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_restrict_check.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_apprd_amt_restrict_check,"|");
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_apprd_amt_restrict_check.add(i,tokenizer.nextToken());
				i++;
			}
			
			tokenizer=new StringTokenizer(str_ins_apprd_days_restrict_check,"|");
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_apprd_days_restrict_check.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_valid_payer_YN,"|");
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_valid_payer_YN.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_valid_policy_type_code_YN,"|");
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_valid_policy_type_code_YN.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_cust_group_code,"|");
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_cust_group_code.add(i,tokenizer.nextToken());
				i++;
			}

			
			tokenizer=new StringTokenizer(str_ins_cust_group_name,"|");
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_cust_group_name.add(i,tokenizer.nextToken());
				i++;
			}

			tokenizer=new StringTokenizer(str_ins_policy_coverage_basis_ind,"|");
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				al_ins_policy_coverage_basis_ind.add(i,tokenizer.nextToken());
				i++;
			}
			
			tokenizer=new StringTokenizer(rtn_payerEligibilityParamSession,"|");
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				String s1=(String)tokenizer.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				al_rtn_payerEligibilityParamSession.add(i,s1);
				i++;
			}
			if(al_rtn_payerEligibilityParamSession.size()==0)
            al_rtn_payerEligibilityParamSession=AddModifyPatFinDetailsBean.getListWithEmptyValues(al_ins_cust_code.size());

			tokenizer=new StringTokenizer(rtn_responseCode,"|");
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				String s1=(String)tokenizer.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				al_rtn_responseCode.add(i,s1);
				i++;
			}
			if(al_rtn_responseCode.size()==0)
            al_rtn_responseCode=AddModifyPatFinDetailsBean.getListWithEmptyValues(al_ins_cust_code.size());

			tokenizer=new StringTokenizer(rtn_responseCodeDesc,"|");
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				String s1=(String)tokenizer.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				al_rtn_responseCodeDesc.add(i,s1);
				i++;
			}
			if(al_rtn_responseCodeDesc.size()==0)
            al_rtn_responseCodeDesc=AddModifyPatFinDetailsBean.getListWithEmptyValues(al_ins_cust_code.size());

			tokenizer=new StringTokenizer(rtn_statuDescription,"|");
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				String s1=(String)tokenizer.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				al_rtn_statuDescription.add(i,s1);
				i++;
			}
			if(al_rtn_statuDescription.size()==0)
            al_rtn_statuDescription=AddModifyPatFinDetailsBean.getListWithEmptyValues(al_ins_cust_code.size());

			tokenizer=new StringTokenizer(rtn_validityPeriod,"|");
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				String s1=(String)tokenizer.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				al_rtn_validityPeriod.add(i,s1);
				i++;
			}
			if(al_rtn_validityPeriod.size()==0)
            al_rtn_validityPeriod=AddModifyPatFinDetailsBean.getListWithEmptyValues(al_ins_cust_code.size());

			tokenizer=new StringTokenizer(rtn_validityPeriodDesc,"|");
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				String s1=(String)tokenizer.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				al_rtn_validityPeriodDesc.add(i,s1);
				i++;
			}
			if(al_rtn_validityPeriodDesc.size()==0)
            al_rtn_validityPeriodDesc=AddModifyPatFinDetailsBean.getListWithEmptyValues(al_ins_cust_code.size());

			System.out.println("prithvi... rtn_eligibilityCode...."+rtn_eligibilityCode);

			tokenizer=new StringTokenizer(rtn_eligibilityCode,"|");
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				String s1=(String)tokenizer.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				al_rtn_eligibilityCode.add(i,s1);
				i++;
			}
			if(al_rtn_eligibilityCode.size()==0)
            al_rtn_eligibilityCode=AddModifyPatFinDetailsBean.getListWithEmptyValues(al_ins_cust_code.size());

			System.out.println("prithvi... rtn_transactionId...."+rtn_transactionId);

			tokenizer=new StringTokenizer(rtn_transactionId,"|");
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				String s1=(String)tokenizer.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				al_rtn_transactionId.add(i,s1);
				i++;
			}
			if(al_rtn_transactionId.size()==0)
            al_rtn_transactionId=AddModifyPatFinDetailsBean.getListWithEmptyValues(al_ins_cust_code.size());
            
			System.out.println("prithvi... rtn_responseDateTime...."+rtn_responseDateTime);
			tokenizer=new StringTokenizer(rtn_responseDateTime,"|");
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				String s1=(String)tokenizer.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				al_rtn_responseDateTime.add(i,s1);
				i++;
			}
			if(al_rtn_responseDateTime.size()==0)
            al_rtn_responseDateTime=AddModifyPatFinDetailsBean.getListWithEmptyValues(al_ins_cust_code.size());
		
		//V232504
			tokenizer=new StringTokenizer(rtn_mcn_for_policy,"|");
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				String s1=(String)tokenizer.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				al_rtn_mcn_for_policy.add(i,s1);
				i++;
			}
			if(al_rtn_mcn_for_policy.size()==0)
            al_rtn_mcn_for_policy=AddModifyPatFinDetailsBean.getListWithEmptyValues(al_rtn_mcn_for_policy.size());
		
		//V232504
			tokenizer=new StringTokenizer(rtn_reg_ref_id,"|");
			i=0;
			while(tokenizer.hasMoreTokens())
			{
				String s1=(String)tokenizer.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				al_rtn_reg_ref_id.add(i,s1);
				i++;
			}
			if(al_rtn_reg_ref_id.size()==0)
            al_rtn_reg_ref_id=AddModifyPatFinDetailsBean.getListWithEmptyValues(al_rtn_reg_ref_id.size());
		

			String blng_grp_name="";
			ArrayList records_array=new ArrayList();
			for(int j=0;j<total_records;j++)
			{
				//String[] records=new String[41];
			//	String[] records=new String[51];//Modified V180806-Aravindh/ARYU-SCF-0113/From String[50] -> String[51]
			//	String[] records=new String[53];  //V232504
			
				String[] records=new String[55];  //V230707
				
				String temp=(String)al_ins_blng_grp_desc.get(j);
				if(temp.equals(" "))
				{
					records[0]="";
				}
				else
				{
					records[0]=(String)al_ins_blng_grp_desc.get(j);
				}
				blng_grp_name=records[0];
				records[1]=(String)al_ins_blng_grp.get(j);
				records[2]=(String)al_ins_payer_desc.get(j);
				records[3]=(String)al_ins_cust_code.get(j);
				records[4]=(String)al_ins_cust_priority.get(j);
				records[5]=(String)al_ins_policy_type_desc.get(j);
				records[6]=(String)al_ins_policy_type_code.get(j);
				records[7]=(String)al_ins_policy_no.get(j);
				records[8]=(String)al_ins_policy_start_date.get(j);
				records[9]=(String)al_ins_policy_expiry_date.get(j);
				records[10]=(String)al_ins_credit_auth_ref.get(j);
				records[11]=(String)al_ins_credit_auth_date.get(j);
				records[12]=(String)al_ins_credit_approval_amount.get(j);
				records[13]=(String)al_ins_credit_approval_days.get(j);
				records[14]=(String)al_ins_policy_eff_from_date.get(j);
				records[15]=(String)al_ins_policy_eff_to_date.get(j);
				records[16]=(String)al_ins_adj_rule_ind.get(j);
				records[17]=(String)al_ins_adj_perc_amt_ind.get(j);
				records[18]=(String)al_ins_adj_perc_amt_value.get(j);
				records[19]=(String)al_ins_pmnt_diff_adj_int.get(j);
				records[20]=(String)al_ins_drg_pmnt_diff_adj_int.get(j);
				records[21]=(String)al_ins_spl_srv_pmnt_diff_adj_int.get(j);
				records[22]=(String)al_ins_restrict_check.get(j);
				records[23]=(String)al_ins_valid_payer_YN.get(j);
				records[24]=(String)al_ins_valid_policy_type_code_YN.get(j);
				records[25]=(String)al_ins_cust_group_code.get(j);
				records[26]=(String)al_ins_policy_coverage_basis_ind.get(j);
				records[27]=str_ref_src_main_code;
				records[28]=str_ref_src_main_desc;
				records[29]=str_ref_src_sub_code;
				records[30]=str_ref_src_sub_desc;
				records[31]=(String)al_ins_apprd_amt_restrict_check.get(j);
				records[32]=(String)al_ins_apprd_days_restrict_check.get(j);
				records[33]=(String)al_ins_cred_auth_req_yn.get(j);
				records[34]=(String)al_ins_dflt_auth_ref_as_pol_no_yn.get(j);
				records[35]="";
				records[36]="";
				records[37]=(String)al_ins_cust_group_name.get(j);
				records[39]="Y";
				records[40]=(String)al_ins_cred_auth_mand_capt_yn.get(j);

				System.out.println("prithvi.. payer list size..."+al_rtn_payerEligibilityParamSession.size());

				System.out.println("prithvi.. al_rtn_responseDateTime list size..."+al_rtn_responseDateTime.size());

				System.out.println("prithvi.. al_rtn_transactionId list size..."+al_rtn_transactionId.size());

				System.out.println("prithvi.. al_rtn_validityPeriodDesc list size..."+al_rtn_validityPeriodDesc.size());

				System.out.println("prithvi.. al_rtn_eligibilityCode list size..."+al_rtn_eligibilityCode.size());

				records[41]=(String)al_rtn_payerEligibilityParamSession.get(j);
				records[42]=(String)al_rtn_responseCode.get(j);
				records[43]=(String)al_rtn_responseCodeDesc.get(j);
				records[44]=(String)al_rtn_statuDescription.get(j);
				records[45]=(String)al_rtn_validityPeriod.get(j);
				records[46]=(String)al_rtn_validityPeriodDesc.get(j);
				records[47]=(String)al_rtn_eligibilityCode.get(j);
				records[48]=(String)al_rtn_transactionId.get(j);
				records[49]=(String)al_rtn_responseDateTime.get(j);
				
				records[50]=(String)al_ins_policy_eff_to_date.get(j);//Added V180806-Aravindh/ARYU-SCF-0113
				records[51]=(String)al_rtn_mcn_for_policy.get(j);      //V232504
				records[52]=(String)al_rtn_reg_ref_id.get(j);      //V232504
				records[53]="";  //V230707
				records[54]="";  //V230707
				

				records_array.add(records);
			}
			
			HashMap blng_grp_records=new HashMap();
			blng_grp_records.put(blng_grp_name,records_array);
			
			tabdata.put("ins_blng_grp",al_ins_blng_grp);
			tabdata.put("ins_payer_desc",al_ins_payer_desc);
			tabdata.put("ins_cust_code",al_ins_cust_code);
			tabdata.put("ins_cust_priority",al_ins_cust_priority);
			tabdata.put("ins_policy_type_desc",al_ins_policy_type_desc);
			tabdata.put("ins_policy_type_code",al_ins_policy_type_code);
			tabdata.put("ins_policy_no",al_ins_policy_no);
			tabdata.put("ins_policy_start_date",al_ins_policy_start_date);
			tabdata.put("ins_policy_expiry_date",al_ins_policy_expiry_date);
			tabdata.put("ins_credit_auth_ref",al_ins_credit_auth_ref);
			tabdata.put("ins_credit_auth_date",al_ins_credit_auth_date);
			tabdata.put("ins_cred_auth_req_yn",al_ins_cred_auth_req_yn);
			tabdata.put("ins_cred_auth_mand_capt_yn",al_ins_cred_auth_mand_capt_yn);
			tabdata.put("ins_dflt_auth_ref_as_pol_no_yn",al_ins_dflt_auth_ref_as_pol_no_yn);			
			tabdata.put("ins_credit_approval_days",al_ins_credit_approval_days);
			tabdata.put("ins_credit_approval_amount",al_ins_credit_approval_amount);
			tabdata.put("ins_policy_eff_from_date",al_ins_policy_eff_from_date);
			tabdata.put("ins_policy_eff_to_date",al_ins_policy_eff_to_date);
			tabdata.put("ins_adj_rule_ind",al_ins_adj_rule_ind);
			tabdata.put("ins_adj_perc_amt_ind",al_ins_adj_perc_amt_ind);
			tabdata.put("ins_adj_perc_amt_value",al_ins_adj_perc_amt_value);
			tabdata.put("ins_pmnt_diff_adj_int",al_ins_pmnt_diff_adj_int);
			tabdata.put("ins_drg_pmnt_diff_adj_int",al_ins_drg_pmnt_diff_adj_int);
			tabdata.put("ins_spl_srv_pmnt_diff_adj_int",al_ins_spl_srv_pmnt_diff_adj_int);
			tabdata.put("ins_restrict_check",al_ins_restrict_check);
			tabdata.put("ins_apprd_amt_restrict_check",al_ins_apprd_amt_restrict_check);
			tabdata.put("ins_apprd_days_restrict_check",al_ins_apprd_days_restrict_check);
			tabdata.put("ins_valid_payer_YN",al_ins_valid_payer_YN);
			tabdata.put("ins_valid_policy_type_code_YN",al_ins_valid_policy_type_code_YN);
			tabdata.put("ins_valid_policy_type_code_YN",al_ins_cust_group_code);


			session.setAttribute("multi_blng_grp_details",(HashMap)tabdata);
			session.setAttribute("new_blng_grp_records",blng_grp_records);
			session.setAttribute("new_blng_grp_name",blng_grp_name);

			System.out.println("multi_blng_grp_details:"+(HashMap)session.getAttribute("multi_blng_grp_details"));
			
			out.println("<script>parent.window.close();</script>");
		} 
		catch (Exception e1) 
		{
				e1.printStackTrace();
		}

	}
}