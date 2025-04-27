package blopin;
//added for package billing	
/*
Sr No        Version           TFS/Incident        SCF/CRF            		 			Developer Name
--------------------------------------------------------------------------------------------------------
1			V211221				26886			Alpha-PMG2021-MMS-CRF-0004/01-All payer		Mohanapriya K
2			V220517				30818				GHL-SCF-1652							Mohanapriya K
3			V230707								AAKH-CRF-0142.1								Namrata Charate					
--------------------------------------------------------------------------------------------------------
*/
import eCommon.Common.*;
import eBL.*;	 
import ecis.utils.OnlineReport;
import ecis.utils.OnlineReports;
import javax.servlet.*;
import javax.servlet.http.*;
//end billing package 

import java.net.*;
import java.io.* ;
import java.sql.* ;
import java.util.*;
import java.sql.* ;
import javax.rmi.*;

import blPolicy.BLPayerPolicyDetails;

import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class BLOPVisit
{
    public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS";
    public final String RECORD_INSERTED     = "RECORD_INSERTED";
    public final String RECORD_MODIFIED     = "RECORD_MODIFIED";
    public final String RECORD_DELETED      = "RECORD_DELETED";
    public final String VISIT_REGN_COMPL    = "VISIT_REGN_COMPL";
    public final String VISIT_REGN_INCOMPL  = "VISIT_REGN_INCOMPL";
    public final String ERROR_IN_CALLING_PROC = "ERROR_IN_CALLING_PROC";
    public final String ERROR_IN_INSERTING_INTO = "ERROR_IN_INSERTING_INTO";
    public final String ERROR_IN_UPDATING = "ERROR_IN_UPDATING";
    public final String VISIT_REGISTERED_FOR_APPT = "VISIT_REGISTERED_FOR_APPT";
//	public java.util.Hashtable insert( Properties p,Connection con, String appt_status,String episodeno,Hashtable tabdata,Hashtable prencounter,Hashtable prencounterdetail)
    public java.util.Hashtable billPatientService( Properties p,Connection con, Hashtable tabdata,Hashtable prencounter,Hashtable prencounterdetail)
	{
		CallableStatement statement;
		CallableStatement cstmt = null;		
		ResultSet rs1  =null;
		Statement st=null;
		ResultSet rs  =null;

		Hashtable messageHashtable=new Hashtable();
		String locale			= "";
		
		String strNull = "";		
//		String err_out="";
//		String strVisitMessage = "";
//		String strBillGenYN = "";
//		String strBillMessage = "";
		String strFinalMessage ="";

		String str_total_chrg_amt="";
		String str_total_pat_chrg_amt="";
		double total_chrg_amt=0.0;
		double total_pat_chrg_amt=0.0;

		String patient_id="";
		String customer_id =""; //Muthu against 33582 on 11-7-12

//		String encounterid="";
		boolean insertable = true;
//		String visitCase=(String)prencounter.get("appt_case_yn");
//		String visitType=(String)prencounter.get("visit_adm_type_ind");

		StringBuffer sb = new StringBuffer( "" ) ;
		java.util.Hashtable results = new java.util.Hashtable() ;

//		boolean result=false;

//		String appt_status = (String)tabdata.get("appt_status");
			System.out.println("########   1billing group details  tabledata  "+  tabdata);
			
		patient_id=(String)tabdata.get("patient_id");
		if(patient_id==null) patient_id="";
		
		String episodeno = (String)tabdata.get("episodeno");
		if (episodeno==null) episodeno ="0";

		String added_by_id = (String)tabdata.get("added_by_id");
		if (added_by_id==null) added_by_id ="0";

		String visit_num = (String) prencounter.get("op_episode_visit_num");
		if (visit_num==null) visit_num ="0";
		
		if (visit_num.length() > 4)
		visit_num = visit_num.substring(0,3);

		String strEncounterId=(String)tabdata.get("encounterid");
		if(strEncounterId==null || strEncounterId.equals("")) strEncounterId="";
	//	long encounter_id=Long.parseLong(strEncounterId);
	

		//ML-01-START 
//		String BillDocTypeCode = "";
//		String BillDocNum = "";
		//ML-01-END 
	/*  Added By Manivel as a part of new Changes in Billing Module on 29/11/2006*/
		double annual_income = 0.0;
		double family_asset = 0.0;
		int no_of_dependants = 0;
//		int ins_credit_approval_days=0;
//		double ins_credit_approval_amount=0.0;
//		double ins_adj_perc_amt_value=0.0;

		int noofdecimal=2;

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
		String str_mcn_for_policy = ""; // V220908
		String str_reg_ref_id = ""; //V230315
		String str_userId_for_priv = ""; //V230707
		String str_reasonCode_for_priv = ""; //V230707
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
		String str_user_id="";
		String str_fin_auth_user_id="";
		String str_calling_function_id="";

		String str_cust_group_code = "";
		String str_cust_code = "";
		String str_doc_ref= "";
		String str_doc_start_date="";
		String str_doc_end_date="";

		String str_acct_seq_eff_from_date="";
		String str_acct_seq_eff_to_date="";

		HashMap hosp_dtls=null;
		HashMap prof_dtls=null;
		HashMap addl_dtls=null;

		String strFacilityId="";
		String strEpisodeType="";
		String strClinicCode="";
		String strVisitType="";
		String strPhysicianId="";
		int days_exempt_for_revisit=0;
		int no_of_follow_up_visit_exmp=0;
		String charge_basis_by_physician_yn="";
		String strHospChargeStage="";
		String strMedChargeStage="";
		String strHospServPanelInd="";
		String strHospServPanelCode="";
		String strMedServPanelInd="";
		String strMedServPanelCode="";

		String strAddlServAvailYN="N";
		String strAddlChargeType = "";
		String incl_excl_overide_flag="";
		String dflt_excl_overide_code="";
		String strAddlServPanelInd="";
		String strAddlServPanelCode="";

		String hosp_serv_panel_ind="";
		String hosp_serv_panel_code="";
		String hosp_serv_panel_str="";
	//	double hosp_serv_panel_qty=1.0;
	//	double hosp_serv_charge_amt=0.0;
		String hosp_serv_panel_qty="1.0";
		String hosp_serv_charge_amt="";

		String med_serv_panel_ind="";
		String med_serv_panel_code="";
		String med_serv_panel_str="";
	//	double med_serv_panel_qty=1.0;
	//	double med_serv_charge_amt=0.0;
		String med_serv_panel_qty="1.0";
		String med_serv_charge_amt="";

		String addl_serv_panel_ind="";
		String addl_serv_panel_code="";
		String addl_serv_panel_str="";
	//	double med_serv_panel_qty=1.0;
	//	double med_serv_charge_amt=0.0;
		String addl_serv_panel_qty="1.0";
		String addl_serv_charge_amt="";

		String strNewHospChrgCreate="";
		String strNewMedChrgCreate="";
		String strNewAddlChrgCreate="";

		int strAcctSeqNo=1;

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
		String credit_authorisation_by="";
		String claim_code="";
		String membership_number="";
	/* ******************************* ********************* */

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

		String str_hosp_chrg_amt="";
		String str_hosp_chrg_pat_amt="";
		String str_med_chrg_amt="";
		String str_med_chrg_pat_amt="";
		String str_addl_chrg_amt="";
		String str_addl_chrg_pat_amt="";

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

		String proc_success="Y";

		String strFunctionId = "VISIT_REGISTRATION";

		String service_date="";
		String str_vst_regn_date_time = "";

		String str_epi_type_clinic_code="";

		String strBLInterfaceYN = "";
			StringTokenizer msgIds;
				String pkg_bill_gen_yn="";//added for pkg billing
		ArrayList	pkg_seq_no_for_upd_sub_hdr		=	new ArrayList(); //addded for package billing
		String package_enabled_yn ="N";//added for Package billing
		String pkg_codes_for_disc="";
		String tempPkgCode = "";	//Added for Duplicate Pkg Rajesh V
		
		try
		{		
			String no_of_decimal="select nvl(no_of_decimal,2) from  sm_acc_entity_param";
			st = con.createStatement();
			rs = st.executeQuery(no_of_decimal) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					noofdecimal  =  rs.getInt(1);	
				}
			}
			if(rs!=null) rs.close();
			st.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in No of Decimal Query="+e.toString());
			e.printStackTrace();
		}

		try
		{		
			String bill_gen_later_YN_qry="select nvl(ADHOC_DISCOUNT_ALLOWED_YN,'N') from  bl_parameters where operating_facility_id='"+(String) tabdata.get("facility_id")+"'";
			st = con.createStatement();
			rs = st.executeQuery(bill_gen_later_YN_qry) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					str_bill_later_YN  =  rs.getString(1);	
				}
			}
			System.err.println("str_bill_later_YN-->"+str_bill_later_YN);
			System.err.println("facility-->"+(String) tabdata.get("facility_id"));
			if(str_bill_later_YN == null) str_bill_later_YN="N";
			if(rs!=null) rs.close();
			st.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in No of bill_gen_later_YN_qry Query="+e.toString());
			e.printStackTrace();
		}

//Added by muthuN for 33582 on 11-7-2012
	try
		{		
			PreparedStatement pstmt_cust = con.prepareStatement("select CUSTOMER_ID from sm_site_param");				
			rs1 = pstmt_cust.executeQuery();	
			if ( rs1.next() && rs1 != null )
			{
				customer_id  =  rs1.getString(1);
			}
			if(rs1!=null) rs1.close();
			 pstmt_cust.close();			
			}catch(Exception e)
			{   e.printStackTrace();
				System.out.println("Exception in Customer ID ="+e.toString());
			}			
//Added by muthuN for 33582 on 11-7-2012

		try
		{
			String query_date="select to_char(sysdate,'dd/mm/yyyy') from dual";
			st = con.createStatement();
			rs = st.executeQuery(query_date) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					service_date = rs.getString(1);
				}
			}
			if(rs!=null) rs.close();
			st.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in Sys Date :"+e);
			e.printStackTrace();
		}

		str_vst_regn_date_time=(String)tabdata.get("visit_date_time");
		if(str_vst_regn_date_time == null) str_vst_regn_date_time="";
		
		
		String tempModule = (String) tabdata.get("module_id");
		if (tempModule == null)
		{
			tempModule = "OP";
		}

		if (tempModule.equalsIgnoreCase("OP") )
		{
			strFunctionId  = "VISIT_REGISTRATION";
		}
		else
		{
			strFunctionId  = "AE_REGISTER_ATTN";
		}
			
		// BL audit variable 

	//sb.append("   at 66 ");

		try
		{
			HashMap billing_data=(HashMap)tabdata.get("fin_dtls");
			HashMap patPackSubsDetails=(HashMap)tabdata.get("PACKAGE_DET");
		
			System.out.println("patPackSubsDetails vijay "+patPackSubsDetails);
			HashMap patPackApprvDtls=(HashMap)tabdata.get("PACKAGE_APPROVALS");
			//Added by prithivi on 06/04/2017 for bupa interface crf-0085
			HashMap payerEligibilityDtlsMap=(HashMap)tabdata.get("PAYER_ELIGIBILITY_CHECK_MAP");
			System.out.println("prithivi...BLOPVisit.java::::payerEligibilityDtlsMap...."+payerEligibilityDtlsMap);
			ArrayList patPackAssociateDtls=(ArrayList)tabdata.get("PACKAGE_ASSOCIATED");
			HashMap support_data   = (HashMap)tabdata.get("SUPPORT_DATA");
			locale			= (String)billing_data.get("locale");
			//Package Discount details Bean
			ArrayList  pkgDiscountDtls = (ArrayList)tabdata.get("PACKAGE_DISCOUNT");
			
			if(locale==null || locale.equals("")) locale="en";

			java.util.Locale loc = new java.util.Locale(locale);

			java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
			java.util.ResourceBundle bl_messages = java.util.ResourceBundle.getBundle("eBL.resources.Messages",loc);
			java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);

			String hosp_chrg_leg = bl_labels.getString("eBL.HOSP_CHRG.label");
			String prof_chrg_leg = bl_labels.getString("eBL.PROF_CHRG.label");

			//Added by muthuN for 33582 on 11-7-2012
			String Reg_chrg_leg = bl_labels.getString("eBL.RegistrationFee.Label");
			String Cons_chrg_leg = bl_labels.getString("eBL.ConsultationFee.Label");
			//Added by muthuN for 33582 on 11-7-2012

			String addl_chrg_leg = bl_labels.getString("eBL.ADDL_CHARGE.label");
			String vst_chrg_exmpt_leg = bl_labels.getString("eBL.VISIT_CHRG_EXEMPT_UPTO.label");
			String bill_gen_yn_leg = bl_labels.getString("eBL.PLS_NOTE_DOWN_THE_BILL.label");
			String bill_gen_yn_leg1 = bl_labels.getString("eBL.FOR_THE_VISIT_CHRG.label");
			String patient_payable_leg = common_labels.getString("Common.PatientPayable.label");
			String bill_gen_yn_message = (String) bl_messages.getString("BL7335");

			if (tabdata.get("bl_install_yn").equals("Y"))
			{
				strBLInterfaceYN = (String)tabdata.get("bl_interface_yn");
				if(strBLInterfaceYN==null) strBLInterfaceYN="";

				strFacilityId=(String) tabdata.get("facility_id");
				if(strFacilityId==null) strFacilityId="";

				strEpisodeType=(String) tabdata.get("episode_type");
				if(strEpisodeType==null) strEpisodeType="";
				
				strClinicCode=(String) prencounter.get("assign_care_locn_code");
				if(strClinicCode==null) strClinicCode="";
				
				strVisitType=(String) prencounter.get("visit_adm_type");
				if(strVisitType==null) strVisitType="";
				
				strPhysicianId = (String) prencounter.get("attend_practitioner_id");
				if(strPhysicianId==null) strPhysicianId="";

				str_epi_type_clinic_code=strEpisodeType+"#"+strClinicCode;

				String recordMode =(String) tabdata.get("recordMode");
				if (recordMode==null) recordMode = "";
				String upd_fin_dtls = (String) tabdata.get("upd_fin_dtls");
				if (upd_fin_dtls==null) upd_fin_dtls = "";
				String credit_doc_date_d = "";
				String credit_doc_ref_start_date_d = "";

				if(tabdata.get("credit_doc_date_d") instanceof java.sql.Date)
					credit_doc_date_d = "test";
				else
					credit_doc_date_d = (String) tabdata.get("credit_doc_date_d");


				if(tabdata.get("credit_doc_ref_start_date_d") instanceof java.sql.Date)
					credit_doc_ref_start_date_d = "test";
				else
					credit_doc_ref_start_date_d = (String) tabdata.get("cred_start_date");	


				String slmt_doc_ref_date_d = "";
				if(tabdata.get("slmt_doc_ref_date_d") instanceof java.sql.Date)
					slmt_doc_ref_date_d = "test";
				else
					slmt_doc_ref_date_d = (String) tabdata.get("slmt_doc_ref_date_d");

				String policy_expiry_date_d = "";
				if(tabdata.get("policy_expiry_date_d") instanceof java.sql.Date)
					policy_expiry_date_d = "test";
				else
					policy_expiry_date_d = (String) tabdata.get("policy_expiry_date_d");

				String package_bill_doc_num = (String) tabdata.get("package_bill_doc_num");
				if ((package_bill_doc_num==null) || (package_bill_doc_num.equals(""))) package_bill_doc_num = "0";

				if (insertable)
				{
					try
					{
		/********************************** Added By Manivel on 29/11/2006 **************************************/

						System.out.println("########   1billing group details "+   billing_data);
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
		//				if (str_ins_credit_approval_days.equals("")) str_ins_credit_approval_days = "0";
						str_ins_credit_approval_amount=(String)billing_data.get("ins_credit_approval_amount"); //double
						if(str_ins_credit_approval_amount==null) str_ins_credit_approval_amount="";
		//				if (str_ins_credit_approval_amount.equals("")) str_ins_credit_approval_amount = "0";
						str_ins_policy_eff_from_date=(String)billing_data.get("ins_policy_eff_from_date");
						if(str_ins_policy_eff_from_date==null) str_ins_policy_eff_from_date="";
						str_ins_policy_eff_to_date=(String)billing_data.get("ins_policy_eff_to_date");
						if(str_ins_policy_eff_to_date==null) str_ins_policy_eff_to_date="";
						
						//V220908
						str_mcn_for_policy = (String)billing_data.get("mcn_for_policy");
						if(str_mcn_for_policy==null) str_mcn_for_policy="";
						System.err.println("str_mcn_for_policy in OPVISIT BEAN:"+str_mcn_for_policy);
						
						//V230315
						str_reg_ref_id = (String)billing_data.get("reg_ref_id");
						if(str_reg_ref_id==null) str_reg_ref_id="";
						System.err.println("str_reg_ref_id in BLOPVISIT :"+str_reg_ref_id);	
						
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
						
						str_ins_adj_perc_amt_value=(String)billing_data.get("ins_adj_perc_amt_value"); //double
						if(str_ins_adj_perc_amt_value==null) str_ins_adj_perc_amt_value="";

		//				if (str_ins_adj_perc_amt_value.equals("")) str_ins_adj_perc_amt_value = "0";
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
						//ML-MMOH-SCF-2459 Starts
						System.out.println("str_gl_holder_name before replace OP=>"+str_gl_holder_name);
						if(!str_gl_holder_name.equals("")){
							str_gl_holder_name = str_gl_holder_name.replace("'", "''");
						}
						System.out.println("str_gl_holder_name after replace OP=>"+str_gl_holder_name);
						//ML-MMOH-SCF-2459 ends
						str_pat_reln_with_gl_holder=(String)billing_data.get("pat_reln_with_gl_holder");
						if(str_pat_reln_with_gl_holder==null) str_pat_reln_with_gl_holder="";

						str_ref_src_main_code=(String)billing_data.get("ref_src_main_code");
						if(str_ref_src_main_code==null) str_ref_src_main_code="";

						str_ref_src_sub_code=(String)billing_data.get("ref_src_sub_code");
						if(str_ref_src_sub_code==null) str_ref_src_sub_code="";

						str_ins_ref_src_main_code=(String)billing_data.get("ins_ref_src_main_code");
						if(str_ins_ref_src_main_code==null) str_ins_ref_src_main_code="";

						str_ins_ref_src_sub_code=(String)billing_data.get("ins_ref_src_sub_code");
						if(str_ins_ref_src_sub_code==null) str_ins_ref_src_sub_code="";

						str_non_ins_ref_src_main_code=(String)billing_data.get("non_ins_ref_src_main_code");
						if(str_non_ins_ref_src_main_code==null) str_non_ins_ref_src_main_code="";

						str_non_ins_ref_src_sub_code=(String)billing_data.get("non_ins_ref_src_sub_code");
						if(str_non_ins_ref_src_sub_code==null) str_non_ins_ref_src_sub_code="";

						str_tot_valid_enc_with_gl=(String)billing_data.get("tot_valid_enc_with_gl");
						if(str_tot_valid_enc_with_gl==null) str_tot_valid_enc_with_gl="";

						str_tot_valid_op_enc_with_gl=(String)billing_data.get("tot_valid_op_enc_with_gl");
						if(str_tot_valid_op_enc_with_gl==null) str_tot_valid_op_enc_with_gl="";

						str_tot_valid_ae_enc_with_gl=(String)billing_data.get("tot_valid_ae_enc_with_gl");
						if(str_tot_valid_ae_enc_with_gl==null) str_tot_valid_ae_enc_with_gl="";

						str_tot_valid_ip_enc_with_gl=(String)billing_data.get("tot_valid_ip_enc_with_gl");
						if(str_tot_valid_ip_enc_with_gl==null) str_tot_valid_ip_enc_with_gl="";

						str_tot_valid_dc_enc_with_gl=(String)billing_data.get("tot_valid_dc_enc_with_gl");
						if(str_tot_valid_dc_enc_with_gl==null) str_tot_valid_dc_enc_with_gl="";
 						
						str_upd_patient_fin_dtls_yn=(String)billing_data.get("upd_patient_fin_dtls_yn");
						if(str_upd_patient_fin_dtls_yn==null) str_upd_patient_fin_dtls_yn="";
						str_user_id=(String)billing_data.get("user_id");
						if(str_user_id==null) str_user_id="";
						str_fin_auth_user_id=(String)billing_data.get("fin_auth_user_id");
						if(str_fin_auth_user_id==null) str_fin_auth_user_id="";
						str_calling_function_id=(String)billing_data.get("calling_function_id");
						if(str_calling_function_id==null) str_calling_function_id="";

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
		//					ins_credit_approval_days=Integer.parseInt(str_ins_credit_approval_days);
		//					ins_credit_approval_amount=Double.parseDouble(str_ins_credit_approval_amount);
		//					ins_adj_perc_amt_value=Double.parseDouble(str_ins_adj_perc_amt_value);
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
							strFacilityId=strFacilityId+"|"+str_ref_src_main_code+"|"+str_ref_src_sub_code;
						}
*/
/*
						if(!str_ins_ref_src_main_code.equals("") && !str_ins_ref_src_sub_code.equals(""))
						{
							str_blng_grp = str_blng_grp+"~"+str_ins_ref_src_main_code+"~"+str_ins_ref_src_sub_code;
						}
*/
						
						hosp_dtls=(HashMap)billing_data.get("hosp_dtls");

						if(hosp_dtls!=null)
						{
							hosp_serv_panel_ind=(String)hosp_dtls.get("hosp_serv_panel_ind");
							hosp_serv_panel_code=(String)hosp_dtls.get("hosp_serv_panel_code");
							hosp_serv_panel_str=(String)hosp_dtls.get("hosp_serv_panel_str");
							hosp_serv_panel_qty=(String)hosp_dtls.get("hosp_serv_panel_qty");
		//					hosp_serv_panel_qty=Double.parseDouble(temp_hosp_serv_panel_qty);
							hosp_serv_charge_amt=(String)hosp_dtls.get("hosp_serv_chrg_amt");
		//					hosp_serv_charge_amt=Double.parseDouble(temp_hosp_serv_charge_amt);
						}

						prof_dtls=(HashMap)billing_data.get("prof_dtls");
			
						if(prof_dtls!=null)
						{
							med_serv_panel_ind=(String)prof_dtls.get("prof_serv_panel_ind");
							med_serv_panel_code=(String)prof_dtls.get("prof_serv_panel_code");
							med_serv_panel_str=(String)prof_dtls.get("prof_serv_panel_str");
							med_serv_panel_qty=(String)prof_dtls.get("prof_serv_panel_qty");
		//					med_serv_panel_qty=Double.parseDouble(temp_med_serv_panel_qty);
							med_serv_charge_amt=(String)prof_dtls.get("prof_serv_chrg_amt");
		//					med_serv_charge_amt=Double.parseDouble(temp_med_serv_charge_amt);
						}

						addl_dtls=(HashMap)billing_data.get("addl_dtls");
						if(addl_dtls!=null)
						{
							addl_serv_panel_ind=(String)addl_dtls.get("addl_serv_panel_ind");
							addl_serv_panel_code=(String)addl_dtls.get("addl_serv_panel_code");
							addl_serv_panel_str=(String)addl_dtls.get("addl_serv_panel_str");
							addl_serv_panel_qty=(String)addl_dtls.get("addl_serv_panel_qty");
		//					med_serv_panel_qty=Double.parseDouble(temp_med_serv_panel_qty);
							addl_serv_charge_amt=(String)addl_dtls.get("addl_serv_chrg_amt");
		//					med_serv_charge_amt=Double.parseDouble(temp_med_serv_charge_amt);
						}

						if(str_vst_regn_date_time.equals(""))
						{
							str_vst_regn_date_time=(String)billing_data.get("encounter_date_time"); // if Interface passed val is null, val is fetched from billing session object
							if(str_vst_regn_date_time == null) str_vst_regn_date_time="";
						}

						
		/* ------------------------------------------------------------------------------------------------------ */
						try
						{
		//sb.append("   at 148:"+tempModule);
							String episode_type = (String) tabdata.get("episode_type");
							if ( (episode_type == null)||(episode_type.equals("")) ) 
								episode_type = "O";

							statement=con.prepareCall("{call blaudit.proc_store_old_values( ?,?,?,?,?,?,?,?,?,?,?,?)}");
							statement.setString( 1, (String) tabdata.get("patient_id"));
							statement.setString( 2, (String) tabdata.get("facility_id"));
		//	Commented by Seshu	statement.setString( 3, "OP"); 
							statement.setString( 3, (String) tabdata.get("module_id")); 
							statement.setString( 4,strFunctionId );	// Function Id
							//	statement.setString( 5, "O"); // Episode Type ENH
							statement.setString( 5, episode_type); // Episode Type						
							statement.setLong( 6,Long.parseLong(episodeno)); 
							statement.setInt(7,Integer.parseInt(visit_num));
							statement.setString(8,"O");	// Trn. Type
							statement.setString(9,str_fin_auth_user_id);	// Authorized by
							statement.registerOutParameter(10,java.sql.Types.VARCHAR);
							statement.registerOutParameter(11,java.sql.Types.VARCHAR);
							statement.registerOutParameter(12,java.sql.Types.VARCHAR);
							statement.execute();

//							String strErrCode = statement.getString(10);
							String strSysMessg = statement.getString(11);
							String strErrText = statement.getString(12);
							if (strSysMessg != null)
							{
								if (!(strSysMessg.equals("")) || !(strSysMessg.equalsIgnoreCase("null") ))
								{
									insertable=false;
									sb.append("Exception while calling procedure BLAUDIT :"+strSysMessg);  
								}
								
							}
							if ((strErrText != null))
							{
								if (!(strErrText.equals("")) || !(strErrText.equalsIgnoreCase("null") ))
								{
									insertable=false;
									sb.append("Exception while calling procedure BLAUDIT :"+strErrText);  
								}
							}
							statement.close();
						}
						catch(Exception ebl1)
						{  
							insertable=false;
							sb.append("Exception while calling procedure BLAUDIT :"+ebl1);  
						}

						// Inserting into BL_EPISODE_FIN_DTLS
						if (insertable)
						{
							String episode_yn = (String) tabdata.get("new_episode_yn");
					 
							if(episode_yn == null || episode_yn.equals("")) episode_yn = "N";

							String episode_mode	= "";
							if(episode_yn.equals("Y"))
								episode_mode = "I";
							else
								episode_mode = "U";

							// Inserting into BL_VISIT_FIN_DTLS
							if (insertable)
							{
								try
								{
								
//Without Membership Id
/*									    String sql = "{call BL_INS_UPD_VISIT_FIN_DTLS( '"+(String)tabdata.get("recordMode")+"','"+(String) tabdata.get("episode_type")+"','"+(String)tabdata.get("patient_id")+"','"+strEncounterId+"',"+Long.parseLong(episodeno)+","+Integer.parseInt(visit_num)+",'"+str_blng_grp+"','"+str_ref_src_main_code+"','"+str_ref_src_sub_code+"','"+str_emp_code+"','"+str_doc_ref+"',to_date('"+str_doc_start_date+"','dd/mm/yyyy'),to_date('"+str_doc_end_date+"','dd/mm/yyyy'),'"+str_slmt_type_code+"','"+str_inst_ref+"',to_date('"+str_inst_date+"','dd/mm/yyyy'),'"+str_inst_remarks+"','"+str_ins_ref_src_main_code+"','"+str_ins_ref_src_sub_code+"','"+str_cust_group_code+"','"+str_cust_code+"','"+str_ins_cust_priority+"','"+str_ins_policy_type_code+"','"+str_ins_policy_no+"','"+str_ins_policy_start_date+"','"+str_ins_policy_expiry_date+"','"+str_ins_credit_auth_ref+"','"+str_ins_credit_auth_date+"','"+str_ins_policy_eff_from_date+"','"+str_ins_policy_eff_to_date+"','"+str_ins_credit_approval_amount+"','"+str_ins_credit_approval_days+"','"+str_ins_adj_rule_ind+"','"+str_ins_adj_perc_amt_ind+"','"+str_ins_adj_perc_amt_value+"','"+str_ins_pmnt_diff_adj_int+"','"+str_ins_drg_pmnt_diff_adj_int+"','"+str_ins_spl_srv_pmnt_diff_adj_int+"','"+str_non_ins_blng_grp+"','"+str_non_ins_ref_src_main_code+"','"+str_non_ins_ref_src_sub_code+"','"+str_non_ins_cust_group_code+"','"+str_non_ins_cust_code+"','"+annual_income+"','"+family_asset+"','"+no_of_dependants+"','"+str_resp_for_payment+"','"+str_pat_reln_with_resp_person+"','"+str_gl_holder_name+"','"+str_pat_reln_with_gl_holder+"','"+(String)tabdata.get("added_by_id")+"','"+strFacilityId+"','"+(String)tabdata.get("added_at_ws_no")+"',?,'"+str_fin_auth_user_id+"','"+str_calling_function_id+"','"+(String)prencounter.get("visit_status")+"',to_date('"+str_acct_seq_eff_from_date+"','dd/mm/yyyy'),to_date('"+str_acct_seq_eff_to_date+"','dd/mm/yyyy'),'"+str_upd_patient_fin_dtls_yn+"','"+str_tot_valid_enc_with_gl+"','"+str_tot_valid_ae_enc_with_gl+"','"+str_tot_valid_op_enc_with_gl+"','"+str_tot_valid_ip_enc_with_gl+"','"+str_tot_valid_dc_enc_with_gl+"','"+credit_authorisation_by+"','"+claim_code+"',?,?,?)}";
									    System.out.println ( "#########  BLOPVisit   "+sql);
										statement = con.prepareCall(sql);
										statement.setString(1,str_fin_remarks);
										statement.registerOutParameter( 2,java.sql.Types.VARCHAR);
										statement.registerOutParameter( 3,java.sql.Types.VARCHAR);
										statement.registerOutParameter( 4,java.sql.Types.VARCHAR);								
										statement.execute();
										insertable = true;
										err_level=statement.getString(2)==null?"":statement.getString(2);
										sys_message_id=statement.getString(3)==null?"":statement.getString(3);
										err_text=statement.getString(4)==null?"":statement.getString(4);
*/

//With Membership Id
									String sql = "{call BL_INS_UPD_VISIT_FIN_DTLS( '"+(String)tabdata.get("recordMode")+"','"+(String) tabdata.get("episode_type")+"','"+(String)tabdata.get("patient_id")+"','"+strEncounterId+"',"+Long.parseLong(episodeno)+","+Integer.parseInt(visit_num)+",'"+str_blng_grp+"','"+str_ref_src_main_code+"','"+str_ref_src_sub_code+"','"+str_emp_code+"','"+str_doc_ref+"',to_date('"+str_doc_start_date+"','dd/mm/yyyy'),to_date('"+str_doc_end_date+"','dd/mm/yyyy'),'"+str_slmt_type_code+"','"+str_inst_ref+"',to_date('"+str_inst_date+"','dd/mm/yyyy'),'"+str_inst_remarks+"','"+str_ins_ref_src_main_code+"','"+str_ins_ref_src_sub_code+"','"+str_cust_group_code+"','"+str_cust_code+"','"+str_ins_cust_priority+"','"+str_ins_policy_type_code+"','"+str_ins_policy_no+"','"+str_ins_policy_start_date+"','"+str_ins_policy_expiry_date+"','"+str_ins_credit_auth_ref+"','"+str_ins_credit_auth_date+"','"+str_ins_policy_eff_from_date+"','"+str_ins_policy_eff_to_date+"','"+str_ins_credit_approval_amount+"','"+str_ins_credit_approval_days+"','"+str_ins_adj_rule_ind+"','"+str_ins_adj_perc_amt_ind+"','"+str_ins_adj_perc_amt_value+"','"+str_ins_pmnt_diff_adj_int+"','"+str_ins_drg_pmnt_diff_adj_int+"','"+str_ins_spl_srv_pmnt_diff_adj_int+"','"+str_non_ins_blng_grp+"','"+str_non_ins_ref_src_main_code+"','"+str_non_ins_ref_src_sub_code+"','"+str_non_ins_cust_group_code+"','"+str_non_ins_cust_code+"','"+annual_income+"','"+family_asset+"','"+no_of_dependants+"','"+str_resp_for_payment+"','"+str_pat_reln_with_resp_person+"','"+str_gl_holder_name+"','"+str_pat_reln_with_gl_holder+"','"+(String)tabdata.get("added_by_id")+"','"+strFacilityId+"','"+(String)tabdata.get("added_at_ws_no")+"',?,'"+str_fin_auth_user_id+"','"+str_calling_function_id+"','"+(String)prencounter.get("visit_status")+"',to_date('"+str_acct_seq_eff_from_date+"','dd/mm/yyyy'),to_date('"+str_acct_seq_eff_to_date+"','dd/mm/yyyy'),'"+str_upd_patient_fin_dtls_yn+"','"+str_tot_valid_enc_with_gl+"','"+str_tot_valid_ae_enc_with_gl+"','"+str_tot_valid_op_enc_with_gl+"','"+str_tot_valid_ip_enc_with_gl+"','"+str_tot_valid_dc_enc_with_gl+"','"+credit_authorisation_by+"','"+claim_code+"',?,?,?,?,?,?,?,?)}";
								    System.out.println ( "#########  BLOPVisit   "+sql);
									statement = con.prepareCall(sql);
									statement.setString(1,str_fin_remarks);
									statement.setString(2, membership_number); // membership_number
									statement.registerOutParameter( 3,java.sql.Types.VARCHAR);
									statement.registerOutParameter( 4,java.sql.Types.VARCHAR);
									statement.registerOutParameter( 5,java.sql.Types.VARCHAR);
									statement.setString(6, str_mcn_for_policy);		//V220908							
									statement.setString(7, str_reg_ref_id);		//V230315
									statement.setString(8, str_userId_for_priv);		//V230707
									statement.setString(9, str_reasonCode_for_priv);		//V230707	
														
					
									statement.execute();

									insertable = true;
									
									err_level=statement.getString(3)==null?"":statement.getString(3);
									sys_message_id=statement.getString(4)==null?"":statement.getString(4);
									err_text=statement.getString(5)==null?"":statement.getString(5);

									
									if(  (!sys_message_id.equals(""))  || (err_level.equals("10") && !err_text.equals("") ) )
									{
									   insertable=false;
			
										if((err_level.equals("10") && !err_text.equals("") ))
										{
											sb.append("<br>"+err_text+"<br> ") ;
										}
										else
										{
											messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
											sb.append((String)messageHashtable.get("message"));
										}
										statement.close();
									}
									sys_message_id="";
									err_level="";
									err_text="";
								}
								catch(Exception ebl2)
								{  
									insertable=false;
									sb.append("Exception while calling procedure BL_VISIT_FIN_DTLS :"+ebl2);  
								}


								/*************************************************************************************/

								// Added By Prithivi For MMS-DM-CRF-0085
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
													
													
													System.out.println("BLOPVisit.java:::facility id:::encounterId::....."+(String) tabdata.get("facility_id")+" ---- "+strEncounterId);
													System.out.println("BLOPVisit.java:::episode type:::episode num::....."+(String) tabdata.get("episode_type")+" ---- "+episodeno);
													System.out.println("BLOPVisit.java:::visit id..."+visit_num);
													System.out.println("BLOPVisit.java:::blng_grp_code:::cust code:::....."+blng_grp_code_update+" ---- "+cust_3_update);
													System.out.println("BLOPVisit.java:::cust group code:::priority:::..."+ins_cust_group_code_update+" ---- "+priority_update);
													System.out.println("BLOPVisit.java:::policy type:::policy num:::....."+policy_type_code_update+" ----- "+policy_no_update);

													transactionId =(String)hdrDtlsUpdate.get("transaction_id");
													responseDateTime =(String)hdrDtlsUpdate.get("response_date_time");
													responseCode =(String)hdrDtlsUpdate.get("response_code");
													eligibilityCode =(String)hdrDtlsUpdate.get("eligibility_code");
													validityPeriod =(String)hdrDtlsUpdate.get("validity_period");
													errorMsg =(String)hdrDtlsUpdate.get("errorMsg");
													remarks =(String)hdrDtlsUpdate.get("remarks");
													validity_until =(String)hdrDtlsUpdate.get("validity_until");
													
													System.out.println("BLOPVisit.java:::transactionId:::responseDateTime:::..."+transactionId+" -- "+responseDateTime);
													System.out.println("BLOPVisit.java:::responseCode:::eligibilityCode:::..."+responseCode+" -- "+eligibilityCode);
													System.out.println("BLOPVisit.java:::validityPeriod:::errorMsg:::remarks::::..."+validityPeriod+" ---- "+errorMsg+" ---- "+remarks);
													System.out.println("BLOPVisit.java:::validity_until:::..."+validity_until);
													
													transactionId=transactionId.trim();//V230627
													System.out.println("BLOPVisit.java:::after test trim");
													if(transactionId!=null && transactionId.length()>0)
													{
														System.out.println("BLOPVisit.java:::transactionId loop");
														statement = con.prepareCall(bl_enc_payer_priority_sql);
														statement.setString(1,(String) tabdata.get("facility_id"));
														if(strEncounterId!=null && strEncounterId!="")
														{
															statement.setLong(2, Long.parseLong(strEncounterId));
														}
														else
														{
															statement.setString(2, strEncounterId);
														}
														statement.setString(3, (String) tabdata.get("episode_type"));
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
														statement.setString(7, (String) tabdata.get("patient_id"));
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
														
														if(responseDateTime!=null && responseDateTime!="" && !responseDateTime.equals(" "))
														{
															statement.setTimestamp(15, getTimeStamp(responseDateTime));
														}
														else
														{
															statement.setString(15, "");
														}
														
														if(responseCode!=null && responseCode!="")
														{
															statement.setInt(16, Integer.parseInt(responseCode));
														}
														else
														{
															statement.setString(16, responseCode);
														}
														statement.setString(17, eligibilityCode);
														if(validityPeriod!=null && validityPeriod!="" && !validityPeriod.equals(" "))
														{
															statement.setInt(18, Integer.parseInt(validityPeriod));
														}
														else
														{
															statement.setString(18, "");  //AAKH-CRF-0142.1 added empty string
														}

														statement.setString(19, errorMsg);
														statement.setString(20, remarks);
														statement.setString(21, validity_until);
														statement.registerOutParameter(22,java.sql.Types.VARCHAR);
														statement.registerOutParameter(23,java.sql.Types.VARCHAR);
												
														statement.execute();
														
														updateResponse=statement.getString(22);
														updateError=statement.getString(23);
														
														System.out.println("BLOPVisit.java:::updateResponse...."+updateResponse);
														System.out.println("BLOPVisit.java:::updateError...."+updateError);
														
														insertable = true;
													}
													else
													{
														System.out.println("BLOPVisit.java:::transactionId length is less than 0");													
													}
													
												}
											}
										}
											
									}
									catch(Exception blp)
									{
										//insertable=false;
										//blp.printStackTrace();
										System.out.println("BLOPVisit.java::: Exception in storing response for eligbility check"+blp);
										sb.append("Exception while calling procedure (only for Eligibility check) bladdlapproval.update_bl_enc_payer_priority :"+blp); 
									}
									
								}


								/*************************************************************************************/
							} // End of Visit Fin Dtls

		//sb.append("   at 503 ");

							// Insert into pre approval and policy addl details.
						} // End of Episode Fin Dtls
					}
					catch (Exception e)
					{
						sb.append("Error "+e);
						insertable=false;
						con.rollback();
						con.setAutoCommit(true);
					}
				}

				if(insertable)
				{
					String fin_class_flag_YN="N";
					String sql_bl_class_flag = "Select NVL(AUTO_FIN_CLASSFCTN_IN_USE_YN,'N') from BL_PARAMETERS Where OPERATING_FACILITY_ID = '"+strFacilityId+"'";
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
						if (rs_temp != null) rs_temp.close();
						if (pstmt_temp != null) pstmt_temp.close();
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
							String sql_class = "{call BLCOMMON.BL_UPD_PAT_CLASS_DTLS('"+strFacilityId+"','"+(String) tabdata.get("patient_id")+"','"+(String)tabdata.get("episode_type")+"','"+episodeno+"','"+visit_num+"','"+strEncounterId+"','"+str_blng_grp+"','"+str_slmt_ind+"','"+str_annual_income+"','"+str_family_asset+"','"+str_inc_asset_ind+"','"+str_ind_inc+"','"+str_ind_inc_freq+"','"+str_spouse_inc+"','"+str_spouse_inc_freq+"','"+str_dependent_inc+"','"+str_dependent_inc_freq+"','"+str_class_code+"','"+str_class_type+"',to_date('"+str_valid_from+"','DD/MM/YYYY'),to_date('"+str_valid_to+"','DD/MM/YYYY'),'"+str_remarks+"','"+str_social_pensioner_id+"','"+str_upd_patient_fin_dtls_yn+"',?,?,?)}";

							statement = con.prepareCall(sql_class);
						
							statement.registerOutParameter( 1,java.sql.Types.VARCHAR);
							statement.registerOutParameter( 2,java.sql.Types.VARCHAR);
							statement.registerOutParameter( 3,java.sql.Types.VARCHAR);
						
						
							statement.execute();
							insertable = true;
						
							err_level=statement.getString(1);
							sys_message_id=statement.getString(2);
							err_text=statement.getString(3);

							if(err_level==null) err_level="";
							if(sys_message_id==null) sys_message_id="";
							if(err_text==null) err_text="";

							if(  (!sys_message_id.equals(""))  || (err_level.equals("10") && !err_text.equals("") ) )
							{
								insertable=false;
								if((err_level.equals("10") && !err_text.equals("") ))
								{										
									sb.append("<br>"+err_text+"<br> ") ;
								}
								else
								{
									messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
									sb.append((String)messageHashtable.get("message"));
								}
								statement.close();
							}
						}
						else
						{
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
			/*********
			The following portion will be used for insertion of the billing Audit information

			*******/
			// Danger Authorized id and the remarks are hard coded

	//sb.append("   at 623 ");

				System.err.println("insertable in BLOPVisit:"+insertable);
				System.err.println("customer_id in BLOPVisit:"+customer_id);
				System.err.println("strBLInterfaceYN in BLOPVisit:"+strBLInterfaceYN);
				System.err.println("hosp_dtls in BLOPVisit:"+hosp_dtls);
				if (insertable)
				{
					 if(hosp_dtls==null || customer_id.equals("ALMO")==true)
					{
						if (strBLInterfaceYN.equals("Y"))
						{
							try
							{
								CallableStatement call = con.prepareCall("{ call BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

								call.setString(1,(String) tabdata.get("facility_id"));
								call.setString(2,strClinicCode);
								call.setString(3,strVisitType);
								call.setString(4,strPhysicianId);
								System.err.println("strFacilityId in BLOPVisit:"+strFacilityId);
								System.err.println("strClinicCode in BLOPVisit:"+strClinicCode);
								System.err.println("strVisitType in BLOPVisit:"+strVisitType);
								System.err.println("strPhysicianId in BLOPVisit:"+strPhysicianId);
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

								days_exempt_for_revisit=call.getInt(5);
								no_of_follow_up_visit_exmp=call.getInt(6);

								charge_basis_by_physician_yn=call.getString(7);
								if(charge_basis_by_physician_yn==null) charge_basis_by_physician_yn="";

								strHospChargeStage=call.getString(8);
								if(strHospChargeStage==null) strHospChargeStage="";

								strMedChargeStage=call.getString(9);
								if(strMedChargeStage==null) strMedChargeStage="";

								strHospServPanelInd=call.getString(10);
								if(strHospServPanelInd==null) strHospServPanelInd="";

								strHospServPanelCode=call.getString(11);
								if(strHospServPanelCode==null) strHospServPanelCode="";

								strMedServPanelInd=call.getString(12);
								if(strMedServPanelInd==null) strMedServPanelInd="";

								strMedServPanelCode=call.getString(13);
								if(strMedServPanelCode==null) strMedServPanelCode="";

								err_level=call.getString(14);
								sys_message_id=call.getString(15);
								err_text=call.getString(16);

								if (err_level == null) err_level ="";
								if (sys_message_id ==null) sys_message_id ="";
								if (err_text ==null) err_text ="";
								System.err.println("err_level in BLOPVisit:"+err_level);
								System.err.println("sys_message_id in BLOPVisit:"+sys_message_id);
								System.err.println("err_text in BLOPVisit:"+err_text);

								if((!sys_message_id.equals(""))  || (err_level.equals("10") && !err_text.equals("")))
								{
									insertable=false;
									proc_success="N";

									if((err_level.equals("10") && !err_text.equals("") ))
									{
										sb.append("<br>"+err_text+"<br> ") ;
									}
									else
									{
										messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
										sb.append((String)messageHashtable.get("message"));
									}
									call.close();
								}
								else
								{
									proc_success="Y";
								}
								sys_message_id="";
								err_level="";
								err_text="";
									
								call.close();
							}
							catch(Exception e)
							{
								insertable=false;
								System.out.println("Exception in Procedure GET_VISIT_RULE_BY_CLINIC:"+e);
								e.printStackTrace();
							}

							if(proc_success.equals("Y"))
							{
								try
								{
									if(!str_non_ins_blng_grp.equals(""))
									{
										ArrayList blng_grp_al = new ArrayList();
										StringTokenizer str= new StringTokenizer(str_blng_grp,"|");
										while(str.hasMoreTokens())
										{
											blng_grp_al.add(str.nextToken());
										}

										ArrayList cust_grp_al = new ArrayList();
										str= new StringTokenizer(str_cust_group_code,"|");
										while(str.hasMoreTokens())
										{
											cust_grp_al.add(str.nextToken());
										}

										ArrayList cust_al = new ArrayList();
										str= new StringTokenizer(str_cust_code,"|");
										while(str.hasMoreTokens())
										{
											cust_al.add(str.nextToken());
										}

										ArrayList pol_type_al = new ArrayList();
										str= new StringTokenizer(str_ins_policy_type_code,"|");
										while(str.hasMoreTokens())
										{
											pol_type_al.add(str.nextToken());
										}
										
										for(int i=0;i<blng_grp_al.size();i++)
										{
											if(strAddlServAvailYN.equals("N"))
											{
												CallableStatement call = con.prepareCall("{ call BLVISITCHARGE.CHECK_ADDL_SERV_CHARGE_BY_CL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

												call.setString(1,strFacilityId);
												call.setString(2,"V");
												call.setString(3,(String)blng_grp_al.get(i));
												call.setString(4,(String)cust_grp_al.get(i));
												call.setString(5,(String)cust_al.get(i));
												call.setString(6,(String)pol_type_al.get(i));
												call.setString(7,strClinicCode);
												call.setString(8,strVisitType);
												call.setString(9,strPhysicianId);

												call.registerOutParameter(10,java.sql.Types.VARCHAR);
												call.registerOutParameter(11,java.sql.Types.VARCHAR);
												call.registerOutParameter(12,java.sql.Types.VARCHAR);
												call.registerOutParameter(13,java.sql.Types.VARCHAR);
												call.registerOutParameter(14,java.sql.Types.VARCHAR);
												call.registerOutParameter(15,java.sql.Types.VARCHAR);
												call.registerOutParameter(16,java.sql.Types.VARCHAR);
												call.registerOutParameter(17,java.sql.Types.VARCHAR);

												call.execute();
											
												strAddlServAvailYN = call.getString(10); 
												if(strAddlServAvailYN == null ) strAddlServAvailYN="N";

												strAddlServPanelInd=call.getString(11);
												if(strAddlServPanelInd==null) strAddlServPanelInd="";

												strAddlServPanelCode=call.getString(12);
												if(strAddlServPanelCode==null) strAddlServPanelCode="";

												strAddlChargeType = call.getString(13);
												if(strAddlChargeType == null) strAddlChargeType="";

												dflt_excl_overide_code = call.getString(14);
												if(dflt_excl_overide_code == null) dflt_excl_overide_code="";
				
												err_level=call.getString(15);
												sys_message_id=call.getString(16);
												err_text=call.getString(17);

												if (err_level == null) err_level ="";
												if (sys_message_id ==null) sys_message_id ="";
												if (err_text ==null) err_text ="";

												call.close();
											}
											
											if((!err_text.equals("") && err_level.equals("10")) || !sys_message_id.equals(""))
											{
												proc_success="N";
											}
											else
											{
												proc_success="Y";
											}
										}
										sys_message_id="";
										err_level="";
										err_text="";
									}
								}
								catch(Exception e)
								{
									System.out.println("Exception in Procedure call:"+e);
									e.printStackTrace();
								}
							}

							if(proc_success.equals("Y"))
							{
								try
								{
									String sql_get_serv_panel_dtls="{call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS('"+(String) tabdata.get("facility_id")+"','"+(String) tabdata.get("module_id")+"','"+str_epi_type_clinic_code+"','"+(String) tabdata.get("patient_id")+"',"+Long.parseLong(episodeno)+","+Integer.parseInt(visit_num)+",'"+strEncounterId+"',"+strAcctSeqNo+",TO_DATE('"+service_date+"','dd/mm/yyyy'),'"+strHospServPanelInd+"','"+strHospServPanelCode+"',1,'P','"+strPhysicianId+"','"+str_blng_grp+"','"+str_cust_group_code+"','"+str_cust_code+"','"+str_ins_policy_type_code+"','"+str_ins_cust_priority+"','"+str_ins_policy_no+"','"+str_ins_policy_start_date+"','"+str_ins_policy_expiry_date+"','"+str_ins_credit_auth_ref+"','"+str_ins_credit_auth_date+"','"+str_ins_policy_eff_from_date+"','"+str_ins_policy_eff_to_date+"','"+str_ins_credit_approval_amount+"','"+str_ins_credit_approval_days+"','"+str_non_ins_blng_grp+"','"+str_non_ins_cust_group_code+"','"+str_non_ins_cust_code+"',?,?,?,?,?,?,'"+strNull+"','"+strNull+"',?,'"+locale+"',?,?,?)}";

									CallableStatement call=con.prepareCall(sql_get_serv_panel_dtls);

									call.registerOutParameter(1,java.sql.Types.VARCHAR);
									call.registerOutParameter(2,java.sql.Types.VARCHAR);
									call.registerOutParameter(3,java.sql.Types.DOUBLE);
									call.registerOutParameter(4,java.sql.Types.DOUBLE);
									call.registerOutParameter(5,java.sql.Types.VARCHAR);
									call.registerOutParameter(6,java.sql.Types.VARCHAR);
									call.registerOutParameter(7,java.sql.Types.VARCHAR);
									call.registerOutParameter(8,java.sql.Types.DOUBLE);
									call.registerOutParameter(9,java.sql.Types.VARCHAR);	
									call.registerOutParameter(10,java.sql.Types.VARCHAR);

									call.execute();	
						
									hosp_serv_panel_str=call.getString(1);	
									if(hosp_serv_panel_str==null)
									{
										hosp_serv_panel_str="";
									}
								else
									{
										hosp_serv_panel_ind=strHospServPanelInd;
										hosp_serv_panel_code=strHospServPanelCode;
										hosp_serv_panel_qty="1.0";
										hosp_serv_charge_amt="";
									}
									
									err_level=call.getString(8);
									sys_message_id=call.getString(9);
									err_text=call.getString(10);

									if (err_level == null) err_level ="";
									if (sys_message_id ==null) sys_message_id ="";
									if (err_text ==null) err_text ="";

									if(  (!sys_message_id.equals(""))  || (err_level.equals("10") && !err_text.equals("") ) )
									{
										insertable=false;
										proc_success="N";
				
										if((err_level.equals("10") && !err_text.equals("") ))
										{
											sb.append("<br>"+err_text+"<br> ") ;
											System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
											sb.append((String)messageHashtable.get("message"));
											System.out.println("sb mesage in sys_message is:"+sb);
										}
										call.close();
									}
									else
									{
										proc_success="Y";
									}
									sys_message_id="";
									err_level="";
									err_text="";
									
									call.close();
								}
								catch(Exception e)
								{
									insertable=false;
									System.out.println("Exception in GET_SERV_PANEL_DTLS for Hospital Charge:"+e);
									e.printStackTrace();
								}
							}

							if(proc_success.equals("Y"))
							{
								try
								{
									String sql_get_serv_panel_dtls="{call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS('"+(String) tabdata.get("facility_id")+"','"+(String) tabdata.get("module_id")+"','"+str_epi_type_clinic_code+"','"+(String) tabdata.get("patient_id")+"',"+Long.parseLong(episodeno)+","+Integer.parseInt(visit_num)+",'"+strEncounterId+"',"+strAcctSeqNo+",TO_DATE('"+service_date+"','dd/mm/yyyy'),'"+strMedServPanelInd+"','"+strMedServPanelCode+"',1,'P','"+strPhysicianId+"','"+str_blng_grp+"','"+str_cust_group_code+"','"+str_cust_code+"','"+str_ins_policy_type_code+"','"+str_ins_cust_priority+"','"+str_ins_policy_no+"','"+str_ins_policy_start_date+"','"+str_ins_policy_expiry_date+"','"+str_ins_credit_auth_ref+"','"+str_ins_credit_auth_date+"','"+str_ins_policy_eff_from_date+"','"+str_ins_policy_eff_to_date+"','"+str_ins_credit_approval_amount+"','"+str_ins_credit_approval_days+"','"+str_non_ins_blng_grp+"','"+str_non_ins_cust_group_code+"','"+str_non_ins_cust_code+"',?,?,?,?,?,?,'"+strNull+"','"+strNull+"',?,'"+locale+"',?,?,?)}";


									CallableStatement call=con.prepareCall(sql_get_serv_panel_dtls);

									call.registerOutParameter(1,java.sql.Types.VARCHAR);
									call.registerOutParameter(2,java.sql.Types.VARCHAR);
									call.registerOutParameter(3,java.sql.Types.DOUBLE);
									call.registerOutParameter(4,java.sql.Types.DOUBLE);
									call.registerOutParameter(5,java.sql.Types.VARCHAR);
									call.registerOutParameter(6,java.sql.Types.VARCHAR);
									call.registerOutParameter(7,java.sql.Types.VARCHAR);
									call.registerOutParameter(8,java.sql.Types.DOUBLE);
									call.registerOutParameter(9,java.sql.Types.VARCHAR);	
									call.registerOutParameter(10,java.sql.Types.VARCHAR);

									call.execute();	

									med_serv_panel_str=call.getString(1);
									if(med_serv_panel_str==null)
									{
										med_serv_panel_str="";
									}
									else
									{
										med_serv_panel_ind=strMedServPanelInd;
										med_serv_panel_code=strMedServPanelCode;
										med_serv_panel_qty="1.0";
										med_serv_charge_amt="";
									}																	
																		
									err_level=call.getString(8);
									sys_message_id=call.getString(9);
									err_text=call.getString(10);

									if (err_level == null) err_level ="";
									if (sys_message_id ==null) sys_message_id ="";
									if (err_text ==null) err_text ="";

									
									call.close();
									if((!err_text.equals("") && err_level.equals("10")) || !sys_message_id.equals(""))
									{
										insertable=false;
										proc_success="N";
									}
									else
									{
										proc_success="Y";
									}
								}
								catch(Exception exp1)
								{			
									insertable=false;
									System.out.println("Exception in GET_SERV_PANEL_DTLS for Professional Charge"+exp1);
									exp1.printStackTrace();
								}
							}

							if(proc_success.equals("Y"))
							{
								if(strAddlServAvailYN.equals("Y") && !strAddlServPanelCode.equals(""))
								{
									try
									{
										String sql_get_serv_panel_dtls="{call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS('"+(String) tabdata.get("facility_id")+"','"+(String) tabdata.get("module_id")+"','"+str_epi_type_clinic_code+"','"+(String) tabdata.get("patient_id")+"',"+Long.parseLong(episodeno)+","+Integer.parseInt(visit_num)+",'"+strEncounterId+"',"+strAcctSeqNo+",TO_DATE('"+service_date+"','dd/mm/yyyy'),'"+strAddlServPanelInd+"','"+strAddlServPanelCode+"',1,'P','"+strPhysicianId+"','"+str_blng_grp+"','"+str_cust_group_code+"','"+str_cust_code+"','"+str_ins_policy_type_code+"','"+str_ins_cust_priority+"','"+str_ins_policy_no+"','"+str_ins_policy_start_date+"','"+str_ins_policy_expiry_date+"','"+str_ins_credit_auth_ref+"','"+str_ins_credit_auth_date+"','"+str_ins_policy_eff_from_date+"','"+str_ins_policy_eff_to_date+"','"+str_ins_credit_approval_amount+"','"+str_ins_credit_approval_days+"','"+str_non_ins_blng_grp+"','"+str_non_ins_cust_group_code+"','"+str_non_ins_cust_code+"',?,?,?,?,?,?,'"+incl_excl_overide_flag+"','"+dflt_excl_overide_code+"',?,'"+locale+"',?,?,?)}";

										
										CallableStatement call=con.prepareCall(sql_get_serv_panel_dtls);

										call.registerOutParameter(1,java.sql.Types.VARCHAR);
										call.registerOutParameter(2,java.sql.Types.VARCHAR);
										call.registerOutParameter(3,java.sql.Types.DOUBLE);
										call.registerOutParameter(4,java.sql.Types.DOUBLE);
										call.registerOutParameter(5,java.sql.Types.VARCHAR);
										call.registerOutParameter(6,java.sql.Types.VARCHAR);
										call.registerOutParameter(7,java.sql.Types.VARCHAR);
										call.registerOutParameter(8,java.sql.Types.DOUBLE);
										call.registerOutParameter(9,java.sql.Types.VARCHAR);	
										call.registerOutParameter(10,java.sql.Types.VARCHAR);

										call.execute();	

										addl_serv_panel_str=call.getString(1);
										if(addl_serv_panel_str==null)
										{
											addl_serv_panel_str="";
										}
										else
										{
											addl_serv_panel_ind=strAddlServPanelInd;
											addl_serv_panel_code=strAddlServPanelCode;
											addl_serv_panel_qty="1.0";
											addl_serv_charge_amt="";
										}																		
																			
										err_level=call.getString(8);
										sys_message_id=call.getString(9);
										err_text=call.getString(10);

										if (err_level == null) err_level ="";
										if (sys_message_id ==null) sys_message_id ="";
										if (err_text ==null) err_text ="";

										call.close();
										if((!err_text.equals("") && err_level.equals("10")) || !sys_message_id.equals(""))
										{
											insertable=false;
											proc_success="N";
										}
										else
										{
											proc_success="Y";
										}
									}
									catch(Exception exp1)
									{			
										insertable=false;
										System.out.println("Exception in GET_SERV_PANEL_DTLS for Addl Charge"+exp1);
										exp1.printStackTrace();
									}
								}
							}
						}
					}
				}

				if (insertable)
				{
					try
					{
						String episode_type = (String) tabdata.get("episode_type");
						if ( (episode_type == null)||(episode_type.equals("")) ) 
							  episode_type = "O";

						statement=con.prepareCall("{call blaudit.proc_update_new_values( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
						
						statement.setString( 1, (String) tabdata.get("patient_id") );        
						statement.setString( 2, (String) tabdata.get("facility_id")  );      
		//	Commented by Seshu		statement.setString( 3, "OP"); 
						statement.setString( 3, (String) tabdata.get("module_id")); 
						statement.setString( 4, strFunctionId);
						statement.setString( 5, "" );                                        
					//	statement.setString(6,"O")   ;                                 
						statement.setString(6,episode_type);  // Episode Type ENH                                 				
						statement.setLong(7,Long.parseLong(episodeno));              
						statement.setInt(8,Integer.parseInt(visit_num));                
						statement.setString(9,str_upd_patient_fin_dtls_yn);
						statement.setString(10,"O");                                       
						statement.setString(11,str_fin_auth_user_id);
						statement.setString(12,strNull);
						statement.setString(13,strNull);
						statement.setString(14,strNull);
						statement.setString(15,strNull);
						statement.setString(16,str_fin_remarks);
						statement.setString(17,	(String) tabdata.get("added_by_id")	 );  
						statement.setString(18,	(String) tabdata.get("added_at_ws_no") );    
						statement.registerOutParameter(19,java.sql.Types.NUMERIC);
						statement.registerOutParameter(20,java.sql.Types.VARCHAR);
						statement.registerOutParameter(21,java.sql.Types.VARCHAR);
						statement.registerOutParameter(22,java.sql.Types.VARCHAR);
						statement.execute();
//						int intAuditNo = statement.getInt(19);
//						String strErrCode = statement.getString(20);
						String strSysMessg = statement.getString(21);
						String strErrText = statement.getString(22);
						if ((strSysMessg != null))
						{
							if (!(strSysMessg.equals("")) || !(strSysMessg.equalsIgnoreCase("null") ))
							{
								insertable=false;
								sb.append("Exception while calling blaudit.proc_update_new_values :"+strSysMessg);  
							}
							
						}
						if ((strErrText != null))
						{
							if (!(strErrText.equals("")) || !(strErrText.equalsIgnoreCase("null") ) )
							{
								insertable=false;
								sb.append("Exception while calling  blaudit.proc_update_new_values :"+strErrText);  
							}
							
						}
						statement.close();
					}
					catch(Exception ebl1)
					{  
						insertable=false;
						sb.append("Exception while calling procedure BLAUDIT PROC_UPDATE :"+ebl1);  
					}
				}
				/*******End of the BL Audit******/
				
				
				
				/*Karthik added code starts here INCLUDE_POLICY_DETAILS_CRF 5-25-2013*/	

				System.out.println("Enter into karthikcode near location");

		 
				if(insertable){

					HashMap plcyDetails=new HashMap(); 
					billing_data=(HashMap)tabdata.get("fin_dtls");
					plcyDetails=(HashMap)billing_data.get("payer_plcy_dtls"); 
					String priority=null;
					String policy_no=null;
System.err.println("plcyDetails "+plcyDetails);
					try{

					String patient_id1=(String)tabdata.get("patient_id");
					if(patient_id1==null) patient_id1="";			
					String visit_id1=(String)tabdata.get("episode_visit_no");
					if(visit_id1==null) visit_id1="";
					String episode_id1=(String)tabdata.get("episode_id");
					if(episode_id1==null) episode_id1="";
					String episode_type1=(String)tabdata.get("episode_type");
					if(episode_type1==null) episode_type1="";
					String encounter_id1=(String)tabdata.get("encounterid");
					if(encounter_id1==null) encounter_id1="";
					String added_by_id1 = (String)tabdata.get("added_by_id");
					if (added_by_id1==null) added_by_id1 ="0";
					String blng_grup11= (String)tabdata.get("blng_grp");
					if (blng_grup11==null) blng_grup11 ="0";
					String facility_id11=(String)tabdata.get("facility_id");
			
					HashMap paramMap= new HashMap();
					if(patient_id1==null) patient_id1="";
					paramMap.put("patientId",patient_id1);		  		
					paramMap.put("episodeType",episode_type1);
					paramMap.put("episodeId",episode_id1);
					paramMap.put("visitId",visit_id1);		   
					paramMap.put("encounterId",encounter_id1);
					paramMap.put("addedById",added_by_id1);
					paramMap.put("modifiedAtWorkstation","tst");
					paramMap.put("blngGrpid",blng_grup11);
					paramMap.put("facility_id",facility_id11);
					paramMap.put("mode","insert");

					System.err.println("#########BLOPvisit 	  paramMap "+paramMap);



					HashMap returnMap = new HashMap();
					Set<String> plcyDetailsSet;
					plcyDetailsSet=(Set<String>)plcyDetails.keySet();
					Iterator<String> plcyDetailsIt=plcyDetailsSet.iterator();
					PolicyInsuranceMasterBean plcyRecord=null;
					BLPayerPolicyDetails policyFetch=new BLPayerPolicyDetails();
					
	//DhanasekarV

				//	HashMap paramMap=(HashMap)billing_data.get("payer_policy_access_specifier");
					
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

					System.err.println("#########BLOPvisit 	 inside  paramMap "+paramMap);
					returnMap=policyFetch.insertHeaderDetails(con,plcyRecord,paramMap);
					
					System.err.println("#returnMap"+returnMap);
					if(((Boolean) returnMap.get("status")).booleanValue()){
						returnMap=policyFetch.insertPolicyDetails(con,plcyRecord,paramMap);
					}
					else{
						insertable = false;
						con.rollback();
						sb=appendMultipleErrors(returnMap,sb,locale);
						break;
					}	
					
					System.err.println("#returnMap"+returnMap);
					if(((Boolean) returnMap.get("status")).booleanValue()){
						returnMap=policyFetch.insertPreApprovalDetails(con,plcyRecord,paramMap);
					}else{
						insertable = false;
						con.rollback();
						String mapValue = "";
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
					catch(Exception except){
						except.printStackTrace();
						insertable=false;
						sb.append("Exception happened while inserting policy Definition details"+except);
					}
				}
							
		
			/*Karthik added code ends here INCLUDE_POLICY_DETAILS_CRF */
				
				
			/*Karthik added code ends here for Overriding Encounter Specific Details Infomation - STARTS */
				if(insertable){					
					
				String procErrorCode=null;
				String procErrorText=null;
				String procErrorLevel = null;
				
				String lat_facility_id=(String) tabdata.get("facility_id");
				String lat_patient_id=(String)tabdata.get("patient_id");
				String lat_upd_patient_fin_dtls_yn=(String)billing_data.get("upd_patient_fin_dtls_yn");
				String lat_added_by_id=	(String) tabdata.get("added_by_id")	 ;
				String lat_added_at_ws_no=(String) tabdata.get("added_at_ws_no");				
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
			
				
				
				

				/****************added for package billing**********************/
				HashMap	pkgCodeSeqNo	=	new HashMap();
				String packageSeqno="";
				String facility_id = ((String) tabdata.get("facility_id"));

				try
				{		
					if(rs!=null) rs.close();
					PreparedStatement pstmt = con.prepareStatement("SELECT bl_package_enabled_yn(?)  package_enabled_yn from dual");
					pstmt.setString(1,facility_id);
					rs = pstmt.executeQuery() ;
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
					if(insertable && patPackSubsDetails!=null && patPackSubsDetails.size()>0)
					{
						String str_ws_by_ip_name1 = "";
				
						String sqlIpAdd="select ws_by_ip_name from sm_facility_param_vw where facility_id = '"+facility_id+"'";
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
						if(pst12 != null) pst12.close();
						if ( str_ws_by_ip_name1 == null ) str_ws_by_ip_name1 ="";
				
						String p_machine_name1 = "";

						if (str_ws_by_ip_name1.equals("I"))
						{						
							p_machine_name1 = InetAddress.getByName((String) tabdata.get("added_at_ws_no")).getHostName() ;
						}
						else
						{
							p_machine_name1 = ((String) tabdata.get("added_at_ws_no"));		
						}
					
						patient_id = (String) tabdata.get("patient_id");
									
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

						try
						{
							String packageCode="",fromDate="",toDate="",strOPYN="Y",packAmt="N",depositAmt="",status="O",utilizedAmt="",valid_episode="",pack_desc="";
							String practitioner_id ="", practitioner_name ="";
							//packEnId="",strEMYN="N",strIPYN="N",strDCYN="N" 
							String str_error_level="",str_sysmesage_id="",str_error_text="";
							String blng_class_code	="",blng_class_desc="";
							String payerGrpCode="",payerGrpDesc="",payerCode="",payerDesc="";
							if(patPackSubsDetails.containsKey(patient_id))
							{
								pkgDtls					=(ArrayList)patPackSubsDetails.get(patient_id);
								if(pkgDtls.size()>0)
								{
									pkgCodes = (ArrayList)pkgDtls.get(0);
									packdescs = (ArrayList)pkgDtls.get(1);
									pkgFrmDate = (ArrayList)pkgDtls.get(2);
									
									pkgToDate = (ArrayList)pkgDtls.get(3);

									pkgAmt = (ArrayList)pkgDtls.get(4);

									//	pkgEncounter_id = (ArrayList)pkgDtls.get(5);								
									
									blng_class_code_list = (ArrayList)pkgDtls.get(5);

									blng_class_desc_list = (ArrayList)pkgDtls.get(6);

									
									payerGrpCode_list=(ArrayList)pkgDtls.get(7);
									payerGrpDesc_list=(ArrayList)pkgDtls.get(8);
									payerCode_list=(ArrayList)pkgDtls.get(9);
									payerDesc_list=(ArrayList)pkgDtls.get(10);
									episode_type_list = (ArrayList)pkgDtls.get(11);//added for IN021023
									practitioner_id_list=(ArrayList)pkgDtls.get(12);//added for IN021023
									practitioner_name_list=(ArrayList)pkgDtls.get(13);//added for IN021023	
									blng_grp_code_list=(ArrayList)pkgDtls.get(15);//V230303
									blng_grp_desc_list=(ArrayList)pkgDtls.get(16);//V230303
								}
							}

							int totRec = 0;
							if(pkgCodes.size() >0)
								totRec = pkgCodes.size();
							for(int i=0;i<totRec;i++)
							{	
								packageCode	=(String)pkgCodes.get(i);
								
								try{
									tempPkgCode = packageCode.substring(0,packageCode.lastIndexOf("@:"));
								}
								catch(Exception pkgEx){
									tempPkgCode = packageCode;
								}
								pkg_codes_for_disc = tempPkgCode+"|"+pkg_codes_for_disc;

								pack_desc	=(String)packdescs.get(i);//Added by muthu

								fromDate	=(String)pkgFrmDate.get(i);

								toDate	=(String)pkgToDate.get(i);

								packAmt	=(String)pkgAmt.get(i);

								//packEnId	=(String)pkgEncounter_id.get(i);

								blng_class_code	=(String)blng_class_code_list.get(i);
								
								blng_class_desc	=(String)blng_class_desc_list.get(i);

								String blng_grp_code=(String)blng_grp_code_list.get(i);
								if(blng_grp_code==null) blng_grp_code="";	
								System.out.println("added for package billing blng_grp_code :"+blng_grp_code);
								String blng_grp_desc=(String)blng_grp_desc_list.get(i);
								if(blng_grp_desc==null) blng_grp_desc="";	
								//V230303
								
								payerGrpCode	=(String)payerGrpCode_list.get(i);
								payerGrpDesc	=(String)payerGrpDesc_list.get(i);
								payerCode	=(String)payerCode_list.get(i);
								payerDesc	=(String)payerDesc_list.get(i);
								valid_episode =(String)episode_type_list.get(i);
								practitioner_id = (String)practitioner_id_list.get(i);//added for IN033044
								practitioner_name = (String)practitioner_name_list.get(i);//added for IN033044
								
								strOPYN="Y";

								String to_date_temp="";
								String addl_Charge="";//V230303
								try
								{
									String sqlInsertSubHdr   ="";
									if(!(toDate.equals("")))
									{
										//Below query is changed by muthu against 33044
										//sqlInsertSubHdr   ="{ call   blpackage.InsertSubHdr(?,?,?,to_date(?,'DD/MM/YYYY'),to_date(?,'DD/MM/YYYY'),?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?)}";
										sqlInsertSubHdr   ="{ call   blpackage.InsertSubHdr(?,?,?,to_date(?,'DD/MM/YYYY HH24:MI:SS'),to_date(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,to_date(?,'DD/MM/YYYY HH24:MI:SS'),?,?)}";
										to_date_temp=toDate;
									}
									else
									{
										//Below query is changed by muthu against 33044
										//sqlInsertSubHdr   ="{ call   blpackage.InsertSubHdr(?,?,?,to_date(?,'DD/MM/YYYY'),?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?)}";
										sqlInsertSubHdr   ="{ call   blpackage.InsertSubHdr(?,?,?,to_date(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,to_date(?,'DD/MM/YYYY HH24:MI:SS'),?,?)}";
										to_date_temp=null;
									}
									cstmt = con.prepareCall(sqlInsertSubHdr);	
								
									cstmt.setString(1,facility_id);
									cstmt.setString(2,patient_id);
									try{
										tempPkgCode = packageCode.substring(0,packageCode.lastIndexOf("@:"));
									}
									catch(Exception pkgEx){
										tempPkgCode = packageCode;
									}
									cstmt.setString(3,tempPkgCode);
									cstmt.setString(4,fromDate);		
									cstmt.setString(5,to_date_temp);							
									cstmt.setString(6,blng_class_code);							
									cstmt.setString(7,payerGrpCode);							
									cstmt.setString(8,payerCode);							
									cstmt.setString(9,packAmt);							
									cstmt.setString(10,depositAmt );						
									cstmt.setString(11,utilizedAmt );
									cstmt.setString(12,practitioner_id);//Added Newly by muthu against 33044
									cstmt.setString(13,status);
								//	cstmt.setString(13,str_user_id);
									cstmt.setString(14,(String) tabdata.get("added_by_id"));
									//cstmt.setString(14,str_user_id);
									cstmt.setString(15,(String) tabdata.get("added_by_id"));
									cstmt.setString(16,p_machine_name1);
									cstmt.setString(17,facility_id);
									cstmt.setString(18,p_machine_name1);
									cstmt.setString(19,facility_id);					
									cstmt.registerOutParameter(20,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(21,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(22,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(23,java.sql.Types.VARCHAR);	
									
//									Karthik added for KDAH-SCF-0351  Admission Date Extra Parameter Starts
									cstmt.setString(24,str_vst_regn_date_time);	
//									Karthik added for KDAH-SCF-0351  Admission Date Extra Parameter Ends									
									cstmt.registerOutParameter(25,java.sql.Types.VARCHAR); //V230303					
									cstmt.setString(26,blng_grp_code); //V230303
									cstmt.execute();	
									packageSeqno=cstmt.getString(20);
									str_error_level=cstmt.getString(21);
									str_sysmesage_id=cstmt.getString(22);					
									str_error_text=cstmt.getString(23);
									System.out.println("str_error_level Blopvisit 2264:"+str_error_level);
									System.out.println("str_sysmesage_id Blopvisit 2264:"+str_sysmesage_id);
									System.out.println("str_error_text Blopvisit 2264:"+str_error_text);
									addl_Charge=cstmt.getString(25); //V230303
										
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									if(packageSeqno==null) packageSeqno="";
									if(addl_Charge==null) addl_Charge="";
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insertable=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											System.out.println(" Blopvisit 2285:"+sb.toString());
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
											}else{								
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message")+"<br>");
											}
										}
										System.out.println(" Blopvisit 2295:"+sb.toString());
										cstmt.close();	
									}			

									pkgCodeSeqNo.put(packageCode,packageSeqno);
		
									if(!packageSeqno.equals("") && !pkg_seq_no_for_upd_sub_hdr.contains(packageSeqno))
									{
										pkg_seq_no_for_upd_sub_hdr.add(packageSeqno);
									}
								}
								catch(Exception e)
								{
									insertable=false;
									sb.append(" Exception while calling blpackage.InsertPackage:"+e);
									System.out.println("Exception in blpackage.InsertPackage Call:"+e);
									e.printStackTrace();
								}
							}
						}
						catch(Exception e)
						{
							insertable=false;
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
							
							for(int i = 0; i < pkgDiscountDtls.size();i++)
							{
								
						     pkgDiscDtl = ""+pkgDiscountDtls.get(i);
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
						     
						     
							pstmt.setString(1,facility_id); 
							try{
								tempPkgCode = pkg_code.substring(0,pkg_code.lastIndexOf("@:"));
							}
							catch(Exception pkgEx){
								tempPkgCode = pkg_code;
							}
							pstmt.setString(2,tempPkgCode);
							pstmt.setInt(3,Integer.parseInt(pkg_seq_no));
							pstmt.setString(4,patient_id);
							pstmt.setString(5,cust_grp_code);
							pstmt.setString(6,discDetl[7].trim());
			
	//System.out.println("pkg_disc_amt in BLOPVisit.java "+pkg_disc_amt);//muthu	
	//System.out.println("pkg_disc_amt in BLOPVisit.java Double "+Double.parseDouble(pkg_disc_amt));//muthu
				//Added by muthu on 5/22/2012
		//if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
						if(discDetl[4]!= null && discDetl[4].trim()!="")
						{													pstmt.setDouble(7,Double.parseDouble(discDetl[3]));
						}
				//Added by muthu on 5/22/2012
							pstmt.setString(8,discDetl[2]);										
							pstmt.setString(9,(String) tabdata.get("added_by_id"));
							pstmt.setString(10,(String) tabdata.get("added_by_id"));
							pstmt.setString(11,(String)tabdata.get("added_at_ws_no"));
							pstmt.setString(12,facility_id);
							pstmt.setString(13,(String)tabdata.get("added_at_ws_no"));
							pstmt.setString(14,facility_id);
							
							
							pstmt.setString(15,discDetl[5].trim());//DESC
							pstmt.setString(16,discDetl[4].trim());
							int insertResult = pstmt.executeUpdate();
//							System.err.println("insertResult:"+insertResult);
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
					
					
					
					
					
					
					

					/********************* insert Associated Pkgs********start************/
					if(insertable && patPackAssociateDtls!=null && patPackAssociateDtls.size()>0)
					{
						try
						{
							String pkg_dtls="";
							String pkg_seq_no="";
							String pkg_code="";
							String pkg_desc="";
							String pkgFromDate=""; //Added By Vijay A.P. For PMG CRF-0005  
							
							String str_error_level="",str_sysmesage_id="",str_error_text="";
							String str_ws_by_ip_name1 = "";
							
							StringTokenizer pkgSt=null;
							String sqlIpAdd="select ws_by_ip_name from sm_facility_param_vw where facility_id = '"+facility_id+"'";
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
							if(pst12 != null) pst12.close();
							if ( str_ws_by_ip_name1 == null ) str_ws_by_ip_name1 ="";

							// End for WS Identification by IP Adress/Name
							String p_machine_name1 = "";
							if (str_ws_by_ip_name1.equals("I"))
							{						
								p_machine_name1 = InetAddress.getByName((String) tabdata.get("added_at_ws_no")).getHostName() ;
							}
							else
							{
								p_machine_name1 = ((String) tabdata.get("added_at_ws_no"));
							}
							String episode_type = (String) tabdata.get("episode_type");
							patient_id = (String) tabdata.get("patient_id");

							String	sqlPkgAssociation   ="{ call   blpackage.AssociateEncounter(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

							CallableStatement pkgAssociate_cstmt = con.prepareCall(sqlPkgAssociation);
							
							for(int i=0;i<patPackAssociateDtls.size();i++)
							{
								pkg_dtls=(String)patPackAssociateDtls.get(i);
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
								if(pkgSt.hasMoreTokens())
								{
									pkgFromDate=(String)pkgSt.nextToken();
								}
								else
									pkgFromDate="";
								
								pkgAssociate_cstmt.setString(1,facility_id);
								pkgAssociate_cstmt.setString(2,str_calling_function_id);
								pkgAssociate_cstmt.setString(3,patient_id);	
								pkgAssociate_cstmt.setString(4,episodeno);
								pkgAssociate_cstmt.setString(5,episode_type);			
								pkgAssociate_cstmt.setString(6,strEncounterId);		
								if(visit_num==null || (visit_num.trim()).equals(""))
								pkgAssociate_cstmt.setString(7,null);	
								else
								pkgAssociate_cstmt.setInt(7,Integer.parseInt(visit_num.trim()));	
								
								try{
									tempPkgCode = pkg_code.substring(0,pkg_code.lastIndexOf("@:"));
								}
								catch(Exception pkgEx){
									tempPkgCode = pkg_code;
								}
								pkgAssociate_cstmt.setString(8,tempPkgCode);	
								if(pkg_seq_no==null || (pkg_seq_no.trim()).equals(""))			
								pkgAssociate_cstmt.setString(9,null);	
								else
								pkgAssociate_cstmt.setLong(9,Long.parseLong(pkg_seq_no.trim()));								
								//pkgAssociate_cstmt.setString(10,str_user_id);//sysdate	
								pkgAssociate_cstmt.setString(10,(String) tabdata.get("added_by_id"));//sysdate	
								pkgAssociate_cstmt.setString(11,p_machine_name1);								
								pkgAssociate_cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
								pkgAssociate_cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
								pkgAssociate_cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
								//pkgAssociate_cstmt.setString(15,str_vst_regn_date_time); -- Commented By Vijay 
								/*Added By Vijay For PMG-CRF-0005*/
								if(pkgFromDate==null || pkgFromDate.equals(""))
									pkgAssociate_cstmt.setString(15,null);
								else
								pkgAssociate_cstmt.setString(15,pkgFromDate);
								/* Ends*/
								pkgAssociate_cstmt.execute();						
								str_error_level=pkgAssociate_cstmt.getString(12);
								str_sysmesage_id=pkgAssociate_cstmt.getString(13);					
								str_error_text=pkgAssociate_cstmt.getString(14);
								if(str_error_level==null) str_error_level="";
								if(str_sysmesage_id==null) str_sysmesage_id="";
								if(str_error_text==null) str_error_text="";		
								System.out.println("str_error_text Blopvisit AssociateEncounter 2554: "+str_error_text);
								System.out.println("str_sysmesage_id Blopvisit 2554: "+str_sysmesage_id);
								System.out.println("str_error_level Blopvisit 2554: "+str_error_level);

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
										}else{
											messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
											sb.append((String)messageHashtable.get("message"));
										}
									}				
									break;
								}			
							}
							if(pkgAssociate_cstmt!=null) 
								pkgAssociate_cstmt.close();
						}
						catch(Exception e)
						{
							insertable=false;
							System.out.println("Exception while inserting package associations="+e);
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
					String policy_eff_frm_date ="";	

					String p_machine_name1 = "";
					String insRec_YN = "N";

					if(insertable && patPackApprvDtls!=null && patPackApprvDtls.size()>0)
					{
						try
						{
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
							String appr_seq_no="";
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
							//String facility_id = ((String) tabdata.get("facility_id"));

							String sqlIpAdd="select ws_by_ip_name from sm_facility_param_vw where facility_id = '"+facility_id+"'";
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
							if(pst12 != null) pst12.close();
							if ( str_ws_by_ip_name1 == null ) str_ws_by_ip_name1 ="";
							// End for WS Identification by IP Adress/Name

							if (str_ws_by_ip_name1.equals("I"))
							{						
								p_machine_name1 = InetAddress.getByName((String) tabdata.get("added_at_ws_no")).getHostName() ;
							}
							else
							{
								p_machine_name1 = ((String) tabdata.get("added_at_ws_no"));
							}
							String episode_type = (String) tabdata.get("episode_type");
							patient_id = (String) tabdata.get("patient_id");
							
							String sqlPayerApproval   ="{ call   bladdlapproval.insencpayerapproval(?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'DD/MM/YYYY'),	?,to_date(?,'DD/MM/YYYY'),?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?)}";
							CallableStatement payer_cstmt = con.prepareCall(sqlPayerApproval);
							String sqlPkgApproval   ="{ call   bladdlapproval.insencpayerpkgapproval(?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'DD/MM/YYYY'),?,?,?,	to_date(?,'DD/MM/YYYY'),?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?)}";
							CallableStatement pkg_cstmt = con.prepareCall(sqlPkgApproval);		

							PkgDtlsSet=(Set<String>)patPackApprvDtls.keySet();
//							System.err.println("PkgDtlsSet="+PkgDtlsSet.toString());
							Iterator<String> pkgIt=PkgDtlsSet.iterator();
//							System.err.println("Calling pkgIt loop");
							while(pkgIt.hasNext())
							{
								if(insertable)
								{
									mapKey=pkgIt.next();	
//									System.err.println("mapKey:"+mapKey);
									payer=(ArrayList)patPackApprvDtls.get(mapKey);	
//									System.err.println("payer:"+payer);
									if(payer!=null && payer.size()>0)
									{
										hdrDtls=	(HashMap)payer.get(0);
										authDtls=	(HashMap)payer.get(1);
										pkgApprovals=	(HashMap)payer.get(2);
//										System.err.println("hdrDtls:"+hdrDtls);
//										System.err.println("authDtls:"+authDtls);
//										System.err.println("pkgApprovals:"+pkgApprovals);
										/*************get hdr dtls*********start************/
										blng_grp_code=(String)hdrDtls.get("blng_grp_code");
										cust_3=(String)hdrDtls.get("cust_3");
										ins_cust_group_code=(String)hdrDtls.get("ins_cust_group_code");
										priority=(String)hdrDtls.get("priority");
										policy_type_code=(String)hdrDtls.get("policy_type_code");
										policy_no=(String)hdrDtls.get("policy_no");
										policy_eff_frm_date=(String)hdrDtls.get("policy_eff_frm_date");

										authDtlsSet=(Set<String>)authDtls.keySet();
										authIt=authDtlsSet.iterator();

										if(authDtls!=null && authDtls.size()>0)
										{
											insRec_YN="Y";
											while(authIt.hasNext())
											{
												record=new ArrayList();						
												authKey=(String)authIt.next();
												record=(ArrayList)authDtls.get(authKey);
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

												if(credit_apprd_amt !=null && !credit_apprd_amt.equals(""))
												{
													payer_cstmt.setString(1,facility_id);
													payer_cstmt.setString(2,episode_type);
													if(episodeno==null || (episodeno.trim()).equals(""))
														payer_cstmt.setString(3,null);
													else 
														payer_cstmt.setLong(3,Long.parseLong(episodeno.trim()));
													if(visit_num==null || (visit_num.trim()).equals(""))
														payer_cstmt.setString(4,null);			
													else
														payer_cstmt.setInt(4,Integer.parseInt(visit_num.trim()));			
													payer_cstmt.setString(5,null);							
													payer_cstmt.setInt(6,strAcctSeqNo);							
													payer_cstmt.setString(7,patient_id);	
													if(strEncounterId==null || (strEncounterId.trim()).equals(""))							payer_cstmt.setString(8,null);
													else							
														payer_cstmt.setLong(8,Long.parseLong(strEncounterId.trim() ));
													payer_cstmt.setString(9,blng_grp_code );
													payer_cstmt.setString(10,ins_cust_group_code);
													payer_cstmt.setString(11,cust_3);
													if(priority==null || (priority.trim()).equals(""))	
														payer_cstmt.setString(12,null);
													else 
														payer_cstmt.setInt(12,Integer.parseInt(priority.trim()));
													payer_cstmt.setString(13,policy_type_code);
													payer_cstmt.setString(14,policy_no);	
													payer_cstmt.setString(15,policy_eff_frm_date);										
													payer_cstmt.setString(16,credit_auth_ref.trim());	
													payer_cstmt.setString(17,credit_auth_date.trim());	
													payer_cstmt.setString(18,appr_seq_no);	
													if(credit_apprd_amt==null || (credit_apprd_amt.trim()).equals(""))							
														payer_cstmt.setString(19,null);
													else 
														payer_cstmt.setDouble(19,Double.parseDouble(credit_apprd_amt.trim()));
													if(credit_apprd_days==null || (credit_apprd_days.trim()).equals(""))
														payer_cstmt.setString(20,null);		
													else 
													payer_cstmt.setLong(20,Long.parseLong(credit_apprd_days.trim()));					
													//payer_cstmt.setString(19,str_user_id);//sysdate
													payer_cstmt.setString(21,(String) tabdata.get("added_by_id"));//sysdate
													//payer_cstmt.setString(20,str_user_id);//sysdate
													payer_cstmt.setString(22,(String) tabdata.get("added_by_id"));//sysdate
													payer_cstmt.setString(23,p_machine_name1);
													payer_cstmt.setString(24,facility_id);
													payer_cstmt.setString(25,p_machine_name1);
													payer_cstmt.setString(26,facility_id);					
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
													System.out.println("str_error_text Blopvisit  2794: "+str_error_text);
													System.out.println("str_sysmesage_id Blopvisit 2794: "+str_sysmesage_id);
													System.out.println("str_error_level Blopvisit 2794: "+str_error_level);

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

																}else{
																	messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
																	sb.append((String)messageHashtable.get("message"));

															}
														}
														//cstmt.close();	
														break;
													}					
													/**********insert pkg approvals*****end*******/		
													if(insertable && pkg_dtls_yn.equals("Y"))
													{
														creditPkgApprovals=new ArrayList();
														if(pkgApprovals!=null && pkgApprovals.size()>0 && pkgApprovals.containsKey(appr_seq_no))
														{
															// changed for IN 20964 from key 'credit_auth_ref' to key 'appr_seq_no'
															creditPkgApprovals=(ArrayList)pkgApprovals.get(appr_seq_no);// individual pkg approvals			// changed for IN 20964 from key 'credit_auth_ref' to key 'appr_seq_no'		
//															System.err.println("creditPkgApprovals:"+creditPkgApprovals);
															if(creditPkgApprovals!=null && creditPkgApprovals.size()>0)
															{
																for(int k=0;k<creditPkgApprovals.size();k++)
																{		
																	pkgApprvRecord=new ArrayList();
																	pkgApprvRecord=(ArrayList)creditPkgApprovals.get(k);
																	pkg_seq_no=(String)pkgApprvRecord.get(0);
																	pkg_code=(String)pkgApprvRecord.get(1);																	
																	
																	if((pkg_seq_no==null || pkg_seq_no.equals("")) && pkgCodeSeqNo!=null && pkgCodeSeqNo.size()>0 && pkgCodeSeqNo.containsKey(pkg_code))
																	{																		
																		pkg_seq_no=(String)pkgCodeSeqNo.get(pkg_code);																																				
																	}
																	pkg_desc=(String)pkgApprvRecord.get(2);
																	pkg_apprv_amt=(String)pkgApprvRecord.get(3);	
																	String pkg_disc_type = (String)pkgApprvRecord.get(4);	
																	String pkg_disc_amt = (String)pkgApprvRecord.get(5);	
																	String pkg_disc_reason = (String)pkgApprvRecord.get(6);	
																	String pkg_disc_reason_desc = (String)pkgApprvRecord.get(7);	
//																	System.err.println("Package Discount Details for :"+pkg_seq_no+":"+pkg_code);
//																	System.err.println("pkg_disc_type:"+pkg_disc_type);
//																	System.err.println("pkg_disc_amt:"+pkg_disc_amt);
//																	System.err.println("pkg_disc_reason:"+pkg_disc_reason);
//																	System.err.println("pkg_disc_reason_desc:"+pkg_disc_reason_desc);
																	pkg_cstmt.setString(1,facility_id);
																	pkg_cstmt.setString(2,episode_type);	
																	if(episodeno==null || (episodeno.trim()).equals(""))										
																	pkg_cstmt.setString(3,null);
																	else
																	pkg_cstmt.setLong(3,Long.parseLong(episodeno.trim()));
																	if(visit_num==null || (visit_num.trim()).equals(""))	
																	pkg_cstmt.setString(4,null);	
																	else
																	pkg_cstmt.setInt(4,Integer.parseInt(visit_num.trim()));		
																	pkg_cstmt.setString(5,null);							
																	pkg_cstmt.setInt(6,strAcctSeqNo);							
																	pkg_cstmt.setString(7,patient_id);	
																	if(strEncounterId==null || (strEncounterId.trim()).equals(""))											
																	pkg_cstmt.setString(8,null);	
																	else 
																	pkg_cstmt.setLong(8,Long.parseLong(strEncounterId.trim() ));						
																	pkg_cstmt.setString(9,blng_grp_code );
																	pkg_cstmt.setString(10,ins_cust_group_code);
																	pkg_cstmt.setString(11,cust_3);
																	if(priority==null || (priority.trim()).equals(""))	
																	pkg_cstmt.setString(12,null);
																	else 
																	pkg_cstmt.setInt(12,Integer.parseInt(priority.trim()));
																	pkg_cstmt.setString(13,policy_type_code);
																	pkg_cstmt.setString(14,policy_no);
																	pkg_cstmt.setString(15,policy_eff_frm_date);
																	if(pkg_seq_no==null || (pkg_seq_no.trim()).equals(""))
																	pkg_cstmt.setString(16,null);
																	else
																	pkg_cstmt.setLong(16,Long.parseLong(pkg_seq_no.trim()));
																	
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
																	if(pkg_apprv_amt==null || (pkg_apprv_amt.trim()).equals(""))										
																	pkg_cstmt.setString(21,null);	
																	else 
																	pkg_cstmt.setDouble(21,Double.parseDouble(pkg_apprv_amt.trim()));					
																	//pkg_cstmt.setString(20,str_user_id);//sysdate
																	pkg_cstmt.setString(22,(String) tabdata.get("added_by_id"));//sysdate
																	//pkg_cstmt.setString(21,str_user_id);//sysdate
																	pkg_cstmt.setString(23,(String) tabdata.get("added_by_id"));//sysdate
																	pkg_cstmt.setString(24,p_machine_name1);
																	pkg_cstmt.setString(25,facility_id);
																	pkg_cstmt.setString(26,p_machine_name1);
																	pkg_cstmt.setString(27,facility_id);					
																	pkg_cstmt.registerOutParameter(28,java.sql.Types.VARCHAR);
																	pkg_cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
																	pkg_cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
																	pkg_cstmt.execute();						
												
																	str_error_level=pkg_cstmt.getString(28);
																	str_sysmesage_id=pkg_cstmt.getString(29);					
																	str_error_text=pkg_cstmt.getString(30);
																	System.out.println("str_error_text Blopvisit  2924: "+str_error_text);
																	System.out.println("str_sysmesage_id Blopvisit 2924: "+str_sysmesage_id);
																	System.out.println("str_error_level Blopvisit 2924: "+str_error_level);

																	if(str_error_level==null) str_error_level="";
																	if(str_sysmesage_id==null) str_sysmesage_id="";
																	if(str_error_text==null) str_error_text="";		
											
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
																			//System.err.println(facility_id+"/"+pkg_code+"/"+pkg_seq_no+"/"+patient_id+"/"+ins_cust_group_code+"/"+cust_3+"/"+pkg_disc_amt+"/"+pkg_disc_type+"/"+(String) tabdata.get("added_by_id")+"/"+p_machine_name1+"/"+pkg_disc_reason+"/"+pkg_disc_reason_desc);
																			PreparedStatement pstmt	= con.prepareStatement(sqlInsert);
																			pstmt.setString(1,facility_id);
																			try{
																				tempPkgCode = pkg_code.substring(0,pkg_code.lastIndexOf("@:"));
																			}
																			catch(Exception pkgEx){
																				tempPkgCode = pkg_code;
																			}
																			pstmt.setString(2,tempPkgCode);
																			pstmt.setInt(3,Integer.parseInt(pkg_seq_no));
																			pstmt.setString(4,patient_id);
																			pstmt.setString(5,ins_cust_group_code);
																			pstmt.setString(6,cust_3);
																			pstmt.setDouble(7,Double.parseDouble(pkg_disc_amt));
																			pstmt.setString(8,pkg_disc_type);										
																			pstmt.setString(9,(String) tabdata.get("added_by_id"));
																			pstmt.setString(10,(String) tabdata.get("added_by_id"));
																			pstmt.setString(11,p_machine_name1);
																			pstmt.setString(12,facility_id);
																			pstmt.setString(13,p_machine_name1);
																			pstmt.setString(14,facility_id);
																			pstmt.setString(15,pkg_disc_reason_desc);//DESC
																			pstmt.setString(16,pkg_disc_reason);
																			int insertResult = pstmt.executeUpdate();
//																			System.err.println("insertResult:"+insertResult);
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
												}// credit_apprd_amt !=null chk							
											}//
										}
										else
										{
											insRec_YN="N";
										}//					
									}//	
								}
								if(!insertable)
								{
									break;
								}
							}//
//							System.err.println("after Calling pkgIt loop");
							if(pkg_cstmt!=null)		
							pkg_cstmt.close();	
							if(payer_cstmt!=null)		
							payer_cstmt.close();
						}
						catch(Exception e)
						{
							insertable=false;
							System.out.println("Exception while inserting package approvals="+e);
							e.printStackTrace();
						}
					}
					/************insert package approvals**************end**********/
//					System.err.println("After Insert Package Approvals:"+insertable+"/"+insRec_YN);
//					if(insertable && !insRec_YN.equals("Y"))

//Corrected By Rajesh on 21/3/2013
//					if(insertable)
		if(insertable && patPackApprvDtls!=null && patPackApprvDtls.size()>0)
					{
						Set<String> PkgDtlsSet=(Set<String>)patPackApprvDtls.keySet();
						String mapKey = "";
						ArrayList payer=new ArrayList();
//						System.err.println("PkgDtlsSet in others="+PkgDtlsSet.toString());
						Iterator<String> pkgIt=PkgDtlsSet.iterator();
//						System.err.println("Calling pkgIt loop in others");
						while(pkgIt.hasNext())
						{
							if(insertable)
							{
								mapKey=pkgIt.next();	
//								System.err.println("mapKey in others:"+mapKey);
								payer=(ArrayList)patPackApprvDtls.get(mapKey);	
//								System.err.println("payer in others:"+payer);
								if(payer!=null && payer.size()>0)
								{
									hdrDtls=	(HashMap)payer.get(0);
									authDtls=	(HashMap)payer.get(1);
									pkgApprovals=	(HashMap)payer.get(2);
//									System.err.println("hdrDtls in Others:"+hdrDtls);
//									System.err.println("authDtls in Others:"+authDtls);
//									System.err.println("pkgApprovals in Others:"+pkgApprovals);
									/*************get hdr dtls*********start************/
									
									Set<String> authDtlsSet=(Set<String>)pkgApprovals.keySet();
									Iterator<String> authIt=authDtlsSet.iterator();

									ArrayList creditPkgApprovals=new ArrayList();
//									Set<String> authDtlsSet=(Set<String>)pkgApprovals.keySet();
//									Iterator<String> authIt=authDtlsSet.iterator();

									if((pkgApprovals!=null && pkgApprovals.size()>0) && (authDtls == null || authDtls.size() == 0))
									{
//										System.err.println("pkgApprovals in others:"+pkgApprovals);
//										System.err.println("pkgApprovals.size() in others:"+pkgApprovals.size());

										while(authIt.hasNext())
										{
											String authKey=(String)authIt.next();					
			System.err.println("authKey ::::: "+authKey);
											creditPkgApprovals = (ArrayList)pkgApprovals.get(authKey);

			System.err.println("creditPkgApprovals in others:"+creditPkgApprovals);
			System.err.println("creditPkgApprovals.size() in others:"+creditPkgApprovals.size());

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
			/*System.err.println("Package Discount Details for :"+pkg_seq_no+":"+pkg_code);
			System.err.println("pkg_desc:	"+pkg_desc);
			System.err.println("pkg_apprv_amt:"+pkg_apprv_amt);
			System.err.println("pkg_disc_type:"+pkg_disc_type);
			System.err.println("pkg_disc_amt:"+pkg_disc_amt);
			System.err.println("pkg_disc_reason:"+pkg_disc_reason);
			System.err.println("pkg_disc_reason_desc:"+pkg_disc_reason_desc);*/

													insertable=true;
													// Inserting Package Discount Details to bl_package_adhoc_discount
													if(pkg_seq_no == null || pkg_seq_no.equals(""))
													{
														messageHashtable=MessageManager.getMessage(locale,"BL8558","BL");
														sb.append((String)messageHashtable.get("message"));
														insertable=false;
														con.rollback();
														break;
													}
//System.err.println("insertable ::::: "+insertable);
													if(insertable)
													{
														try
														{
															String sqlInsert			="insert into bl_package_adhoc_discount(OPERATING_FACILITY_ID,PACKAGE_CODE,PACKAGE_SEQ_NO,PATIENT_ID,CUST_GROUP_CODE,CUST_CODE,DISCOUNT,DISCOUNT_TYPE,ADDED_BY_ID,ADDED_DATE,MODIFIED_BY_ID,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,DISC_REASON_DESC,DISC_REASON_CODE) values(?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?)";
															//System.err.println(facility_id+"/"+pkg_code+"/"+pkg_seq_no+"/"+patient_id+"/"+ins_cust_group_code+"/"+cust_3+"/"+pkg_disc_amt+"/"+pkg_disc_type+"/"+(String) tabdata.get("added_by_id")+"/"+p_machine_name1+"/"+pkg_disc_reason+"/"+pkg_disc_reason_desc);
															PreparedStatement pstmt	= con.prepareStatement(sqlInsert);
															pstmt.setString(1,facility_id);
															try{
																tempPkgCode = pkg_code.substring(0,pkg_code.lastIndexOf("@:"));
															}
															catch(Exception pkgEx){
																tempPkgCode = pkg_code;
															}
															pstmt.setString(2,tempPkgCode);
															pstmt.setInt(3,Integer.parseInt(pkg_seq_no));
															pstmt.setString(4,patient_id);
															pstmt.setString(5,ins_cust_group_code);
															pstmt.setString(6,cust_3);
											
		 //System.out.println("pkg_disc_amt in BLOPVisit.java "+pkg_disc_amt);//muthu	
		 //System.out.println("pkg_disc_amt in BLOPVisit.java Double "+Double.parseDouble(pkg_disc_amt));//muthu
												//Added by muthu on 5/22/2012
										//if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
														if(pkg_disc_amt!= null && pkg_disc_amt!="")
														{													pstmt.setDouble(7,Double.parseDouble(pkg_disc_amt));
														}
												//Added by muthu on 5/22/2012
															pstmt.setString(8,pkg_disc_type);										
															pstmt.setString(9,(String) tabdata.get("added_by_id"));
															pstmt.setString(10,(String) tabdata.get("added_by_id"));
															pstmt.setString(11,p_machine_name1);
															pstmt.setString(12,facility_id);
															pstmt.setString(13,p_machine_name1);
															pstmt.setString(14,facility_id);
															pstmt.setString(15,pkg_disc_reason_desc);//DESC
															pstmt.setString(16,pkg_disc_reason);
															int insertResult = pstmt.executeUpdate();
//															System.err.println("insertResult:"+insertResult);
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
				}	
				
				/********************end of package billing********************************/
				
				
				
				
				
				
				
				

				/*** The new code for the printing of the bill starts here *************/
//				System.err.println("Cross Level - 1:"+insertable);
//				System.err.println("Cross Level - 1:"+sb.toString());
				if(insertable && support_data!=null && support_data.size()>0)
				{
					Hashtable resultsBL1 = billDepDtls(p,con,tabdata);
					String success="";
					String sys_error="";
					sys_message_id = (String) resultsBL1.get("str_sysmesage_id");
					if(sys_message_id==null) sys_message_id="";
					err_text = (String) resultsBL1.get("str_error_text");
					if(err_text==null) err_text="";
					err_level = (String) resultsBL1.get("str_error_level");
					if(err_level==null) err_level="";
					sys_error = (String) resultsBL1.get("sys_error");
					if(sys_error==null) sys_error="";
					System.out.println("err_text Blopvisit  3241: "+err_text);
					System.out.println("sys_message_id Blopvisit 3241: "+sys_message_id);
					System.out.println("err_level Blopvisit 3241: "+err_level);
					System.out.println("sys_error Blopvisit 3241: "+sys_error);

					if(!sys_error.equals(""))
					{
						sb.append(resultsBL1.get("sys_error"));	
						insertable=false;
					}
					success = (String) resultsBL1.get("success");
					if(success.equals("fail"))
					{
						insertable=false;
						if(  (!sys_message_id.equals(""))  || (err_level.equals("10") && !err_text.equals("") ) )
						{
							insertable=false;
							if((err_level.equals("10") && !err_text.equals("") ))
							{
								sb.append("<br>"+err_text+"<br> ") ;								
							}
							else
							{
								if(sys_message_id.indexOf("|") != (-1))
								{
									msgIds=new StringTokenizer(sys_message_id,"|");
									while(msgIds.hasMoreTokens())
									{
										messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
										sb.append((String)messageHashtable.get("message")+"<br>");
									}
								}
								else
								{
									messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
									sb.append((String)messageHashtable.get("message"));
								}
							}
						}//main if
					}//fail
				}	
//						System.err.println("Cross Level - 2:"+insertable);
//						System.err.println("Cross Level - 2:"+sb.toString());
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
				if(pst1 != null) pst1.close();

				if ( str_ws_by_ip_name == null ) str_ws_by_ip_name ="";

				String p_machine_name = "";
				if (str_ws_by_ip_name.equals("I"))
				{						
					p_machine_name = InetAddress.getByName((String) tabdata.get("added_at_ws_no")).getHostName() ;
				}
				else
				{
					p_machine_name = ((String) tabdata.get("added_at_ws_no"));
				}

				String packageCode="",pkg_seq_no="";
				ArrayList	pkgDtls		=	new ArrayList();
				ArrayList	pkgCodes		=	new ArrayList();
//				System.err.println("Cross Level - 3:"+insertable);
//				System.err.println("Cross Level - 3:"+sb.toString());
				if(insertable && patPackSubsDetails!=null && patPackSubsDetails.size()>0)
				{
					String str_error_level="",str_sysmesage_id="",str_error_text="";
					if(patPackSubsDetails.containsKey(patient_id))
					{
						pkgDtls					=(ArrayList)patPackSubsDetails.get(patient_id);
						//System.out.println("added for package billing pkgDtls  order:"+pkgDtls);
						if(pkgDtls.size()>0)
						{
							pkgCodes = (ArrayList)pkgDtls.get(0);
							//System.out.println("added for package billing pkgCodes order:"+pkgCodes);
						}
						int totRec = 0;
						if(pkgCodes.size() >0)
							totRec = pkgCodes.size();
						for(int i=0;i<totRec;i++)
						{	
							packageCode	=(String)pkgCodes.get(i);
							//System.out.println("added for package billing packageCode1 order:"+packageCode);							
						//	if(packageSeqno!=null && !(packageSeqno.equals("")))
							if(pkgCodeSeqNo!=null && pkgCodeSeqNo.size()>0 && pkgCodeSeqNo.containsKey(packageCode))
							{
								pkg_seq_no=(String)pkgCodeSeqNo.get(packageCode);
								//System.out.println("added for package billing packageSeqno 1 order:"+pkg_seq_no);
								try{
									tempPkgCode = packageCode.substring(0,packageCode.lastIndexOf("@:"));
								}
								catch(Exception pkgEx){
									tempPkgCode = packageCode;
								}
								String sqlautoordercatalogs="{ call   blpackage.getautoordercatalogs('"+facility_id+"','VISIT_REGISTRATION','"+patient_id+"','"+episodeno+"','"+strEncounterId+"','"+visit_num+"','"+tempPkgCode+"','"+pkg_seq_no+"','"+str_user_id+"','"+p_machine_name+"',?,?,?)}";
								

								//System.out.println("sqlautoordercatalogs :"+sqlautoordercatalogs);
								cstmt = con.prepareCall(sqlautoordercatalogs);							
									
								cstmt.registerOutParameter(1,java.sql.Types.VARCHAR);
								cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);
								cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
										
								cstmt.execute();					
								
								str_error_level=cstmt.getString(1);
								str_sysmesage_id=cstmt.getString(2);					
								str_error_text=cstmt.getString(3);
									
								if(str_error_level==null) str_error_level="";
								if(str_sysmesage_id==null) str_sysmesage_id="";
								if(str_error_text==null) str_error_text="";
								System.out.println("str_error_text Blopvisit  3364: "+str_error_text);
								System.out.println("str_sysmesage_id Blopvisit 3364: "+str_sysmesage_id);
								System.out.println("str_error_level Blopvisit 3364: "+str_error_level);

								if(!str_error_text.equals("")  )
								{
									insertable=false;
									sb.append("<br>"+str_error_text+"<br> ") ;
								}
								if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
								{
									insertable=false;
									//sb.append("<br>"+str_error_text+"<br> ") ;
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
											//System.out.println("sb mesages in sys_message is:"+sb);
										}else{								
											messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
											sb.append((String)messageHashtable.get("message")+"<br>");
											//System.out.println("sb mesage in sys_message is:"+sb);
										}
									}
									cstmt.close();	
								}
								pkgCodeSeqNo.put(packageCode,packageSeqno);
								
									if(!packageSeqno.equals("") && !pkg_seq_no_for_upd_sub_hdr.contains(packageSeqno))
									{
										pkg_seq_no_for_upd_sub_hdr.add(packageSeqno);
									}
								
								//System.out.println("pkg_seq_no_for_upd_sub_hdr array 123:" +pkg_seq_no_for_upd_sub_hdr);
									/*Added by Rajesh V to invoke Recalculation for each package association*/
					//Commented by Vijay for KDAH-SCF-0387.1 
				
				/*					String visitId = "";
									if(visit_num==null || "null".equals(visit_num)){
										visitId = "";
									}
									else{
										visitId = visit_num;
									}			
				
									HashMap recalculationMap=recalculation(con,facility_id,patient_id,(String) tabdata.get("episode_type"),
											episodeno,visitId,p_machine_name, str_user_id);
									
									insertable=(Boolean) recalculationMap.get("status");
									if(!insertable){
										if(recalculationMap.containsKey("recalcHdr")){
											sb.append((String)recalculationMap.get("recalcHdr")+"<br>");
										}
										if(recalculationMap.containsKey("internalError")){
											sb.append((String)recalculationMap.get("internalError")+"<br>");
										}
									}*/
									/*Added by Rajesh V to invoke Recalculation for each package association*/
							}			
						}
					}
				}
//								System.err.println("Cross Level - 4:"+insertable);
//								System.err.println("Cross Level - 4:"+sb.toString());
				
				
				
				if(insertable)
				{
					try
					{
						// Debugging purpose To be removed Dangerous	
						//strBLInterfaceYN = "Y";
						if (strBLInterfaceYN.equals("Y"))
						{
							int intVisitNum = Integer.parseInt(visit_num);
						//--int intEpisodeNum = Integer.parseInt((String) tabdata.get("op_episode_id"));
							long intEpisodeNum = Long.parseLong(episodeno);

//							String sql="{call blopin.proc_main('D','VISIT_REGISTRATION','"+(String) tabdata.get("facility_id")+"','"+(String) tabdata.get("module_id")+"','"+strClinicCode+"','"+strVisitType+"','"+strNull+"','"+(String) tabdata.get("patient_id")+"','"+(String) tabdata.get("episode_type")+"','"+strEncounterId+"',"+intEpisodeNum+","+intVisitNum+",'P','"+strPhysicianId+"','"+str_blng_grp+"','"+str_cust_code+"','"+str_ins_policy_type_code+"','"+str_ins_cust_priority+"','"+str_ins_policy_no+"','"+str_ins_policy_start_date+"','"+str_ins_policy_expiry_date+"','"+str_ins_credit_auth_ref+"','"+str_ins_credit_auth_date+"','"+str_ins_policy_eff_from_date+"','"+str_ins_policy_eff_to_date+"','"+str_ins_credit_approval_amount+"','"+str_ins_credit_approval_days+"','"+str_non_ins_blng_grp+"','"+str_non_ins_cust_code+"','"+hosp_serv_panel_ind+"','"+hosp_serv_panel_code+"','"+hosp_serv_panel_str+"','"+hosp_serv_panel_qty+"','"+hosp_serv_charge_amt+"','"+med_serv_panel_ind+"','"+med_serv_panel_code+"','"+med_serv_panel_str+"','"+med_serv_panel_qty+"','"+med_serv_charge_amt+"','"+(String) tabdata.get("added_by_id")+"','"+(String) tabdata.get("added_at_ws_no")+"','"+p_machine_name+"',"+strAcctSeqNo+",'"+strNull+"','"+locale+"',?,?,?,?,?,?,?,?,?,?,?,?)}";

							String sql="{call BLVisitCharge.proc_main('D','VISIT_REGISTRATION','"+(String) tabdata.get("facility_id")+"','"+(String) tabdata.get("module_id")+"','"+strClinicCode+"','"+strVisitType+"','"+strNull+"','"+(String) tabdata.get("patient_id")+"','"+(String) tabdata.get("episode_type")+"','"+strEncounterId+"',"+intEpisodeNum+","+intVisitNum+",to_date('"+str_vst_regn_date_time+"','dd/mm/yyyy HH24:MI:SS'),'P','"+strPhysicianId+"','"+str_blng_grp+"','"+str_cust_group_code+"','"+str_cust_code+"','"+str_ins_policy_type_code+"','"+str_ins_cust_priority+"','"+str_ins_policy_no+"','"+str_ins_policy_start_date+"','"+str_ins_policy_expiry_date+"','"+str_ins_credit_auth_ref+"','"+str_ins_credit_auth_date+"','"+str_ins_policy_eff_from_date+"','"+str_ins_policy_eff_to_date+"','"+str_ins_credit_approval_amount+"','"+str_ins_credit_approval_days+"','"+str_non_ins_blng_grp+"','"+str_non_ins_cust_group_code+"','"+str_non_ins_cust_code+"','"+strNewHospChrgCreate+"','"+strNewMedChrgCreate+"','"+strNewAddlChrgCreate+"','"+hosp_serv_panel_ind+"','"+hosp_serv_panel_code+"','"+hosp_serv_panel_str+"','"+hosp_serv_panel_qty+"','"+hosp_serv_charge_amt+"','"+med_serv_panel_ind+"','"+med_serv_panel_code+"','"+med_serv_panel_str+"','"+med_serv_panel_qty+"','"+med_serv_charge_amt+"','"+addl_serv_panel_ind+"','"+addl_serv_panel_code+"','"+addl_serv_panel_str+"','"+addl_serv_panel_qty+"','"+addl_serv_charge_amt+"','"+str_bill_later_YN+"','"+(String) tabdata.get("added_by_id")+"','"+(String) tabdata.get("added_at_ws_no")+"','"+p_machine_name+"',"+strAcctSeqNo+",'"+strNull+"','"+locale+"',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
							//System.out.println("sql:"+sql);

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

							addl_charge_YN = statement.getString(3);
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

							System.err.println("str_bill_prt_format_YN:"+str_bill_prt_format_YN);
							System.err.println("str_bill_prt_format_vals:"+str_bill_prt_format_vals);
						
							total_chrg_amt=hosp_chrg_amt+med_chrg_amt+addl_chrg_amt;
							total_pat_chrg_amt=hosp_chrg_pat_amt+med_chrg_pat_amt+addl_chrg_pat_amt;

							str_total_chrg_amt=String.valueOf(total_chrg_amt);
							str_total_pat_chrg_amt=String.valueOf(total_pat_chrg_amt);
			
							try
							{
								CurrencyFormat cf1 = new CurrencyFormat();
			
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
								e.printStackTrace();
							}

							/*System.out.println("str_hosp_chrg_amt:"+str_hosp_chrg_amt);
							System.out.println("hosp_chrg_amt:"+hosp_chrg_amt);
							System.out.println("str_hosp_chrg_pat_amt:"+str_hosp_chrg_pat_amt);
							System.out.println("hosp_chrg_pat_amt:"+hosp_chrg_pat_amt);
							System.out.println("str_med_chrg_amt:"+str_med_chrg_amt);
							System.out.println("med_chrg_amt:"+med_chrg_amt);
							System.out.println("str_med_chrg_pat_amt:"+str_med_chrg_pat_amt);
							System.out.println("med_chrg_pat_amt:"+med_chrg_pat_amt);
							System.out.println("str_addl_chrg_amt:"+str_addl_chrg_amt);
							System.out.println("addl_chrg_amt:"+addl_chrg_amt);
							System.out.println("str_addl_chrg_pat_amt:"+str_addl_chrg_pat_amt);
							System.out.println("addl_chrg_pat_amt:"+addl_chrg_pat_amt);
							System.out.println("hosp_charge_YN:"+hosp_charge_YN);
							System.out.println("med_charge_YN:"+med_charge_YN);
							System.out.println("addl_charge_YN:"+addl_charge_YN);
							System.out.println("exempt_date:"+exempt_date);
							System.out.println("bill_gen_yn:"+bill_gen_yn);
							System.out.println("bill_doc_type:"+bill_doc_type);
							System.out.println("bill_doc_number:"+bill_doc_number);
							System.out.println("str_bill_gen_later:"+str_bill_gen_later);
							System.out.println("str_total_bill_amt:"+str_total_bill_amt);*/

							pkg_bill_gen_yn=bill_gen_yn;//added for pkg billing

							if(bill_gen_yn.equals("Y") && (bill_doc_type.equals("") && bill_doc_number.equals("0")))
							{
								bill_gen_yn="N";
							}
//Added by muthuN for 33582 on 11-7-2012 Starts Here
							if(customer_id.equals("MOHBR")){
								System.out.println("CustomerID in BLOPVisit.java "+customer_id);
System.out.println("hosp_charge_YN"+hosp_charge_YN+"bill_gen_yn"+bill_gen_yn+"str_bill_gen_later"+str_bill_gen_later);
							if(hosp_charge_YN.equals("Y") && bill_gen_yn.equals("N") && str_bill_gen_later.equals("N"))
							{
								if(hosp_chrg_amt>=0)
								{
									strFinalMessage=Reg_chrg_leg+" "+str_hosp_chrg_amt+" "+patient_payable_leg+" "+str_hosp_chrg_pat_amt;
							System.out.println("strFinalMessage for Reg Fee in BLOPVisit.java "+strFinalMessage);
								}
							}

System.out.println("med_charge_YN"+med_charge_YN+"bill_gen_yn"+bill_gen_yn+"str_bill_gen_later"+str_bill_gen_later);
							if(med_charge_YN.equals("Y") && bill_gen_yn.equals("N") && str_bill_gen_later.equals("N"))
							{
								if(med_chrg_amt>=0)
								{
									strFinalMessage=strFinalMessage+"<BR>"+Cons_chrg_leg+" "+str_med_chrg_amt+" "+patient_payable_leg+" "+str_med_chrg_pat_amt;
							System.out.println("strFinalMessage for Cons Fee in BLOPVisit.java "+strFinalMessage);
								}
							}
							}
							else{
							if(hosp_charge_YN.equals("Y") && bill_gen_yn.equals("N") && str_bill_gen_later.equals("N"))
							{
								if(hosp_chrg_amt>=0)
								{
									strFinalMessage=hosp_chrg_leg+" "+str_hosp_chrg_amt+" "+patient_payable_leg+" "+str_hosp_chrg_pat_amt;
							System.out.println("strFinalMessage for Hosp Fee in BLOPVisit.java  "+strFinalMessage);
								}
							}

							if(med_charge_YN.equals("Y") && bill_gen_yn.equals("N") && str_bill_gen_later.equals("N"))
							{
								if(med_chrg_amt>=0)
								{
									strFinalMessage=strFinalMessage+"<BR>"+prof_chrg_leg+" "+str_med_chrg_amt+" "+patient_payable_leg+" "+str_med_chrg_pat_amt;
							System.out.println("strFinalMessage for Prof Fee in BLOPVisit.java "+strFinalMessage);
								}
							}
							}								
//Added by muthuN for 33582 on 11-7-2012 Ends Here
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
//								strFinalMessage=strFinalMessage+"<BR>"+bill_gen_yn_leg+" "+bill_doc_type+"/"+bill_doc_number+" "+bill_gen_yn_leg1+" "+str_total_chrg_amt+" "+patient_payable_leg+" "+str_total_pat_chrg_amt;
								strFinalMessage=strFinalMessage+"<BR>"+bill_gen_yn_message+bill_doc_type+"/"+bill_doc_number;
							}
							
							//System.out.println("strFinalMessage:"+strFinalMessage);

							err_level=statement.getString(18);
							sys_message_id=statement.getString(19);
							err_text=statement.getString(20);

							if(err_level==null || err_level.equals("")) err_level="";
							if(sys_message_id==null || sys_message_id.equals("")) sys_message_id="";
							if(err_text==null || err_text.equals("")) err_text="";

							//System.out.println("err_level in blopin:"+err_level);
							//System.out.println("sys_message_id in blopin:"+sys_message_id);
							//System.out.println("err_text in blopin:"+err_text);
		/*
							strVisitMessage = statement.getString(20);
							strBillGenYN = statement.getString(21);
							String strBillDocTypeCode = statement.getString(22);
							String strBillDocNumber = statement.getString(23);

							//ML-02-START 
							BillDocTypeCode = statement.getString(22);
							BillDocNum  = statement.getString(23);
							//ML-02-END 
			
							strBillMessage =  statement.getString(24);
							String strErrMsg  = statement.getString(25);
							String strErrText  = statement.getString(26);
							strVisitMessage = statement.getString(20);
							strBillGenYN = statement.getString(21);
							strBillMessage =  statement.getString(24);				
		*/	

		/*					if (BillDocTypeCode == null || BillDocTypeCode == "")
							{
								BillDocTypeCode = "";
							}
							if (BillDocNum == null || BillDocNum == "")
							{
								BillDocNum = "";
							}

							if (err_level != null )
							{
								if (!err_level.equals(""))
								{
									insertable=false;
									sb.append("PROC_CALCULATE_VISIT_CHARGE: Error Code "+err_level);
									con.rollback();
									con.setAutoCommit(true);
								}
							}
							if (err_text != null )
							{
								if (!err_text.equals(""))
								{
									insertable=false;
									sb.append("PROC_CALCULATE_VISIT_CHARGE: Error Text "+err_text);
									con.rollback();
									con.setAutoCommit(true);
								}
							}
		*/	
							
							System.out.println("err_text Blopvisit  3737: "+err_text);
							System.out.println("sys_message_id Blopvisit 3737: "+sys_message_id);
							System.out.println("err_level Blopvisit 3737: "+err_level);
							
							if(  (!sys_message_id.equals(""))  || (err_level.equals("10") && !err_text.equals("") ) )
							{
								insertable=false;
			
								if((err_level.equals("10") && !err_text.equals("") ))
								{
									sb.append("<br>"+err_text+"<br> ") ;
									//System.out.println("sb mesage in Error is:"+sb);
								}
								else
								{
									if(sys_message_id.indexOf("|") != (-1)){
											msgIds=new StringTokenizer(sys_message_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
													
												}
									
								}else
								{
									messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
									sb.append((String)messageHashtable.get("message"));
									//System.out.println("sb mesage in sys_message is:"+sb);
								}
								}
								statement.close();
							}
							sys_message_id="";
							err_level="";
							err_text="";
		/*
							if (strBillGenYN == null || strBillGenYN.equals(""))
							{
								strBillGenYN = "N";
							}
							if (strBillGenYN.equals("V"))
							{	
								strFinalMessage = strBillMessage;
							}
							else
							{
								strFinalMessage = strVisitMessage;
							}
			
							if ((strFinalMessage == null )||strFinalMessage.equalsIgnoreCase("null"))
							{
								strFinalMessage = strVisitMessage;
							}
		*/
						} // End of Try Block in Calculation of VisitCharge
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
					catch(Exception except)
					{
						insertable=false;
						sb.append("Mod. Exception while calling procedure BLVisitCharge.proc_main : "+except);
					}
				}
//				System.err.println("Cross Level - 5:"+insertable);
//				System.err.println("Cross Level - 5:"+sb.toString());
				/********************Added for Package Billing***********************starts***************/
				//System.out.println("package_enabled_yn="+package_enabled_yn+"@@@");

/* Commenting the loop as per the changes reqd by Karupps on 19/11/2010
				if(insertable && package_enabled_yn.equals("Y"))
				{
					String mpi_id1="";
					//System.out.println("bill_doc_type="+bill_doc_type+"@@@");
					//System.out.println("bill_doc_number="+bill_doc_number+"@@@");

					 if(!bill_doc_type.equals("") && !bill_doc_number.equals(""))
					 {
						//System.out.println("bill_doc_type inside");
						String qrympiid="select MPI_ID from bl_bill_hdr where OPERATING_FACILITY_ID='"+facility_id+"' and DOC_TYPE_CODE='"+bill_doc_type+"' and DOC_NUM='"+bill_doc_number+"'";
						Statement st1 = con.createStatement();
						ResultSet rs_d = st1.executeQuery(qrympiid) ;
						if( rs_d != null ) 
						{
							while( rs_d.next() )
							{  
								mpi_id1  =  rs_d.getString(1);	
							}
						}
						st.close();
						if(rs_d!=null) rs_d.close();
					  //System.out.println("mpi_id1="+mpi_id1+"@@@");

						try
						{
							ArrayList	pkgDtls1		=	new ArrayList();
							ArrayList pkgCodes1	=	new ArrayList();
							String packageCode1="",pack_seq_no1="";
							//System.out.println("patPackSubsDetails="+patPackSubsDetails.toString());
							if( patPackSubsDetails!=null && patPackSubsDetails.size()>0)
							{
								pkgDtls1					=(ArrayList)patPackSubsDetails.get(patient_id);
								//System.out.println("pkgDtls1.size()="+pkgDtls1.size());
								if(pkgDtls1.size()>0)
								{
										pkgCodes1 = (ArrayList)pkgDtls1.get(0);
										//System.out.println("added for package billing pkgCodes :"+pkgCodes1);
								}
								//System.out.println("pkg_seq_no_for_upd_sub_hdr.size()="+pkg_seq_no_for_upd_sub_hdr.size());
								//System.out.println("pkg_seq_no_for_upd_sub_hdr="+pkg_seq_no_for_upd_sub_hdr);
								if(pkg_seq_no_for_upd_sub_hdr!=null && pkg_seq_no_for_upd_sub_hdr.size()>0)
								{			
									//System.out.println("inside");
									CallableStatement  cstmt_d = con.prepareCall("{ call    blpackage.calc_package_bill_discount(?,?,?,?,?,?,?,?,?,?)}");
									CallableStatement  cstmt_d1 = con.prepareCall("{ call    blpackage.proc_updt_bill_for_disc(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
									//System.out.println("pkg_seq_no_for_upd_sub_hdr.size()="+pkg_seq_no_for_upd_sub_hdr.size());
									 for(int i=0;i<pkg_seq_no_for_upd_sub_hdr.size();i++)
									 {		
										 //System.out.println("inside1");
										packageCode1	=(String)pkgCodes1.get(i);
										//System.out.println("i="+i+", pack_seq_no packageCode DISC:"+packageCode1);
										//pkg_codes_for_disc = packageCode1+"|"+pkg_codes_for_disc;
										//System.out.println("pkg_codes_for_disc DISC:"+pkg_codes_for_disc);
										pack_seq_no1 = (String)pkg_seq_no_for_upd_sub_hdr.get(i);
//										System.out.println("i="+i+", pack_seq_no pkgCodeSeqNo DISC:"+pack_seq_no1);
//										System.out.println("str_blng_grp DISC:"+str_blng_grp);
										cstmt_d.setString(1,(String) tabdata.get("facility_id"));
										cstmt_d.setString(2,packageCode1);
										cstmt_d.setString(3,pack_seq_no1);
										cstmt_d.setString(4,patient_id);
										cstmt_d.setString(5,"O");
										cstmt_d.setLong(6,Long.parseLong(episodeno));
										cstmt_d.setString(7,visit_num);	
										cstmt_d.setString(8,str_blng_grp);
										cstmt_d.setString(9,(String) tabdata.get("added_by_id"));		
										cstmt_d.setString(10,(String) tabdata.get("added_at_ws_no"));		
										cstmt_d.execute();	

										//System.out.println("called_from opvisit end of calc_package_bill_discount:");
								
										cstmt_d1.setString(1,mpi_id1);
										cstmt_d1.setString(2,bill_doc_type); //from bill doctype
										cstmt_d1.setString(3,null);		//to bill doctype	
										cstmt_d1.setString(4,bill_doc_number); //from bill billnum
										cstmt_d1.setString(5,null);		//to bill billnum
										cstmt_d1.setString(6,pack_seq_no1);
										cstmt_d1.setString(7,(String) tabdata.get("facility_id"));
										cstmt_d1.setString(8,patient_id);
										cstmt_d1.setLong(9,Long.parseLong(episodeno));
										cstmt_d1.setString(10,"O");
										cstmt_d1.setString(11,visit_num);		
										cstmt_d1.setString(12,(String) tabdata.get("added_by_id"));		
										cstmt_d1.setString(13,(String) tabdata.get("added_at_ws_no"));
										cstmt_d1.execute();	
										//System.out.println("called_from opvisit end of proc_updt_bill_for_disc:");
									 }
									if (cstmt_d!=null)   cstmt_d.close();
									if (cstmt_d1!=null)   cstmt_d1.close();
								}
							}
						}
						catch(Exception e1)
						{
							System.out.println("Exception proc_updt_bill_for_disc :"+e1);
							e1.printStackTrace();
						}	
					 }
				}
*/								

				//System.out.println("pkg_bill_gen_yn="+pkg_bill_gen_yn+"@@@");
				//System.out.println("str_bill_gen_later="+str_bill_gen_later+"@@@");
				//System.out.println("bill_doc_type="+bill_doc_type+"@@@");
				//System.out.println("bill_doc_number="+bill_doc_number+"@@@");
//				System.err.println("Cross Level - 6:"+insertable);
//				System.err.println("Cross Level - 6:"+sb.toString());
				if(insertable && package_enabled_yn.equals("Y"))
				{
					String str_error_level="",str_sysmesage_id="",str_error_text="",pack_seq_no="";
					if(pkg_bill_gen_yn.equals("N") && str_bill_gen_later.equals("N") &&  bill_doc_type.equals("") && (bill_doc_number.equals("0") || bill_doc_number.equals("")))
					{
						if( patPackSubsDetails!=null && patPackSubsDetails.size()>0)
						{
							if(pkg_seq_no_for_upd_sub_hdr!=null && pkg_seq_no_for_upd_sub_hdr.size()>0)
							 {
							 cstmt = con.prepareCall("{ call   blpackage.cancel_ordcatalog_variance (?,?,?,?,?,?,?,?,?,?,?)}");	
								for(int i=0;i<pkg_seq_no_for_upd_sub_hdr.size();i++)
								 {	
									pack_seq_no = (String)pkg_seq_no_for_upd_sub_hdr.get(i);
									/*System.out.println("i="+i+", pack_seq_no pkgCodeSeqNo :"+pack_seq_no);
									System.out.println("facility_id="+(String)tabdata.get("facility_id"));
									System.out.println("patient_id="+(String)tabdata.get("patient_id"));
									System.out.println("Long.parseLong(episodeno)="+Long.parseLong(episodeno));
									System.out.println("episode_type="+(String)tabdata.get("episode_type"));
									System.out.println("visit_num="+visit_num);
									System.out.println("added_at_ws_no="+(String)tabdata.get("added_at_ws_no"));
									System.out.println("added_by_id="+(String)tabdata.get("added_by_id"));*/
									cstmt.setString(1,(String) tabdata.get("facility_id"));
									cstmt.setString(2,(String) tabdata.get("patient_id"));
									cstmt.setLong(3,Long.parseLong(episodeno));
									cstmt.setString(4,(String) tabdata.get("episode_type"));		
									cstmt.setString(5,visit_num);							
									cstmt.setString(6,pack_seq_no);							
									cstmt.setString(7,(String) tabdata.get("added_at_ws_no"));							
									cstmt.setString(8,(String) tabdata.get("added_by_id"));							
									cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);									
									cstmt.execute();					
									str_error_level=cstmt.getString(9);
									str_sysmesage_id=cstmt.getString(10);					
									str_error_text=cstmt.getString(11);
				
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";									
									System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
									System.out.println("str_error_text in process:"+str_error_text);
									System.out.println("str_error_text in process:"+str_error_text);
				
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
											
									}	
								}
								cstmt.close();
							}
						}
					}
				}
//				System.err.println("Cross Level - 7:"+insertable);
//				System.err.println("Cross Level - 7:"+sb.toString());
				if(insertable)
				{					
					String mpi_id="";
					String pack_seq_no="";
					int k=0;
					try
					{
						if(!bill_doc_type.equals("") && !bill_doc_number.equals(""))
						{
							String no_of_decimal="select MPI_ID from bl_bill_hdr where OPERATING_FACILITY_ID='"+strFacilityId+"' and DOC_TYPE_CODE='"+bill_doc_type+"' and DOC_NUM='"+bill_doc_number+"'";
							st = con.createStatement();
							rs = st.executeQuery(no_of_decimal) ;
							if( rs != null ) 
							{
								while( rs.next() )
								{  
									mpi_id  =  rs.getString(1);	
								}
							}
							st.close();
							if(rs!=null) rs.close();
							//System.out.println("pkg_seq_no_for_upd_sub_hdr array:" +pkg_seq_no_for_upd_sub_hdr);
							if(pkg_seq_no_for_upd_sub_hdr!=null && pkg_seq_no_for_upd_sub_hdr.size()>0)
							{
								for(k=0;k<pkg_seq_no_for_upd_sub_hdr.size();k++)
								{	
									pack_seq_no = (String)pkg_seq_no_for_upd_sub_hdr.get(k);
									//System.out.println("pack_seq_no pkgCodeSeqNo :"+pack_seq_no);
									String upd_stmt="update bl_package_sub_hdr set BILL_DOC_TYPE_CODE='"+bill_doc_type+"'  ,BILL_DOC_NUM="+Double.parseDouble(bill_doc_number)+",MPI_ID='"+mpi_id+"' where  OPERATING_FACILITY_ID='"+strFacilityId+"' and  PACKAGE_SEQ_NO='"+pack_seq_no+"'";
									PreparedStatement pstmt1 = con.prepareStatement(upd_stmt);

									//System.out.println("pack_seq_no upd_stmt :"+upd_stmt);

									int res_upd = pstmt1.executeUpdate();

									if (res_upd != 0) 
									{
										insertable = true;
									}
									else
									{
										insertable = false;
										break;
									}
									if(pstmt1!=null) pstmt1.close();
									String upd_stmt1="update BL_BILL_HDR set PACKAGE_CMP_YN='Y' where MPI_ID='"+mpi_id+"' AND OPERATING_FACILITY_ID='"+strFacilityId+"' ";		
									PreparedStatement pstmt2 = con.prepareStatement(upd_stmt1);					
									//System.out.println("pack_seq_no upd_stmt1 :"+upd_stmt1);

									int res_upd1 = pstmt2.executeUpdate();

									if (res_upd1 != 0) 
									{
										insertable = true;
									}
									else
									{
										insertable = false;
										break;
									}
									if(pstmt2!=null) pstmt2.close();
								}
							}
						}
					}
					catch(Exception except)
					{
						insertable=false;
						sb.append("Mod. Exception while UPDATING bl_package_sub_hdr : "+except);
					}
				}
//				System.err.println("Cross Level - 8:"+insertable);
//				System.err.println("Cross Level - 8:"+sb.toString());
/**************************package billing********************************ends****/
				
				
	//End of Billing
			}
		}
	    catch(Exception e)
		{
			e.printStackTrace();
            //sb.append( e.getMessage() + "<br>" );
        }
        finally
        {
        }

//ENDS HERE
		/***************** Debugging
		************/
		//strFinalMessage += "<B><CENTER>"+strFinalMessage+"<B></CENTER>";
        results.put( "status", new Boolean(insertable) ) ;
        results.put( "error", sb.toString() ) ;		

		//ML-04-START 
//		if ( !bill_doc_type.equals("") && !bill_doc_number.equals("") )
//		{		
//			results.put( "billdoctype",BillDocTypeCode) ;
//			results.put( "billdocnum", BillDocNum) ;

			results.put( "billgenlater",str_bill_gen_later) ;	
			results.put( "billdoctype",bill_doc_type) ;
			results.put( "billdocnum", bill_doc_number) ;
			results.put( "billtotalamt", str_total_bill_amt) ;
			results.put( "packageseqno", pkg_seq_no_for_upd_sub_hdr) ;//added for package billing 
			results.put( "package_enabled_yn", package_enabled_yn) ;//added for package billing 
			results.put( "pkg_codes_for_disc", pkg_codes_for_disc) ;//added for package billing 

			results.put( "bill_prt_format_YN", str_bill_prt_format_YN);
			results.put( "pgm_id", pgm_id);
			results.put( "session_id", session_id);
			results.put( "pgm_date", pgm_date);
			results.put( "mpi_id_rep", mpi_id_rep);
			System.err.println("results:"+results);
//		}
		//ML-04-END 


		if ((strFinalMessage == null )||strFinalMessage.equalsIgnoreCase("null") || strFinalMessage.equals("") )
		{
			strFinalMessage =  " ";
		}

        results.put( "message",strFinalMessage);

       // results.put( "p_encounter_id", encounterid);

		
		
		//System.out.println("blopvisit results" +results.toString());
        return results ;
    }
	public java.util.Hashtable billDepDtls( Properties p,Connection con,Hashtable tabdata)
	{
		StringBuffer sys_err = new StringBuffer("") ;
		String str_session_id="",str_pgm_date="",str_doc_type_code="",str_doc_no="",str_error_level="",str_error_text="",str_sysmesage_id="",final_msg_doc_type_code="",gen_doc_type="",gen_doc_num="";
		boolean insertable = true;
		//Added by muthu on 25-7-12 Receipt
		String rec_print_format_enabled_yn = "";
		String str_rec_prt_format_vals = "";
		String gen_prt_format ="";
		//Added by muthu on 25-7-12 Receipt 

		java.util.Hashtable results = new java.util.Hashtable() ;
		//System.out.println("from billDepDtls New Method");
		HashMap support_data   = (HashMap)tabdata.get("SUPPORT_DATA");
		HashMap mult_slmt_vals = (HashMap)tabdata.get("MULT_SLMT_VALS");
		String facility_id = (String) support_data.get("facility_id");
		if(facility_id==null) facility_id="";
		String locale = (String) support_data.get("locale");
		if(locale==null) locale="en";
		String patient_id=(String)support_data.get("patient_id");
		if(patient_id==null) patient_id="";			
		String visit_id=(String)support_data.get("visit_id");
		if(visit_id==null) visit_id="";
		String episode_id=(String)support_data.get("episode_id");
		if(episode_id==null) episode_id="";
		String episode_type=(String)support_data.get("episode_type");
		if(episode_type==null) episode_type="";
		String encounter_id=(String)support_data.get("encounter_id");
		if(encounter_id==null) encounter_id="";
		String rcpt_rfnd_ind=(String)support_data.get("rcpt_rfnd_ind");
		if(rcpt_rfnd_ind==null) rcpt_rfnd_ind="";
		String rcpt_nature_code=(String)support_data.get("rcpt_nature_code");
		if(rcpt_nature_code==null) rcpt_nature_code="";
		String cash_counter_code=(String)support_data.get("cash_counter_code");
		if(cash_counter_code==null) cash_counter_code="";
		String shift_id=(String)support_data.get("shift_id");
		if(shift_id==null) shift_id="";
		String doc_amt=(String)support_data.get("doc_amt");
		if(doc_amt==null) doc_amt="";
		String narration=(String)support_data.get("narration");
		if(narration==null) narration="";
		String ip_adm_trf_dep_ind=(String)support_data.get("ip_adm_trf_dep_ind");
		if(ip_adm_trf_dep_ind==null) ip_adm_trf_dep_ind="";
		String rec_ref_format_ind=(String)support_data.get("rec_ref_format_ind");
		if(rec_ref_format_ind==null) rec_ref_format_ind="";
		String rfnd_dep_in_use_yn=(String)support_data.get("rfnd_dep_in_use_yn");
		if(rfnd_dep_in_use_yn==null) rfnd_dep_in_use_yn="";
		String pmnt_thru_mail=(String)support_data.get("pmnt_thru_mail");
		if(pmnt_thru_mail==null) pmnt_thru_mail="";
		String ext_acc_facility_id=(String)support_data.get("ext_acc_facility_id");
		if(ext_acc_facility_id==null) ext_acc_facility_id="";
		String ext_acc_code=(String)support_data.get("ext_acc_code");
		if(ext_acc_code==null) ext_acc_code="";
		String ext_acc_dept_code=(String)support_data.get("ext_acc_dept_code");
		if(ext_acc_dept_code==null) ext_acc_dept_code="";
		String mult_slmt_yn=(String)support_data.get("mult_slmt_yn");
		if(mult_slmt_yn==null) mult_slmt_yn="";
		String downtime_entry_yn=(String)support_data.get("downtime_entry_yn");
		if(downtime_entry_yn==null) downtime_entry_yn="";
		String downtime_reason_code=(String)support_data.get("downtime_reason_code");
		if(downtime_reason_code==null) downtime_reason_code="";
		String downtime_doc_type_code=(String)support_data.get("downtime_doc_type_code");
		if(downtime_doc_type_code==null) downtime_doc_type_code="";
		String downtime_doc_num=(String)support_data.get("downtime_doc_num");
		if(downtime_doc_num==null) downtime_doc_num="";
		String downtime_doc_date=(String)support_data.get("downtime_doc_date");
		if(downtime_doc_date==null) downtime_doc_date="";
		String cc_machine_id=(String)support_data.get("cc_machine_id");
		if(cc_machine_id==null) cc_machine_id="";
		String payers_add1=(String)support_data.get("payers_add1");
		if(payers_add1==null) payers_add1="";
		String payers_add2=(String)support_data.get("payers_add2");
		if(payers_add2==null) payers_add2="";
		String payers_add3=(String)support_data.get("payers_add3");
		if(payers_add3==null) payers_add3="";
		String payers_tel_num=(String)support_data.get("payers_tel_num");
		if(payers_tel_num==null) payers_tel_num="";
		String consolidated_receipt_yn=(String)support_data.get("consolidated_receipt_yn");
		if(consolidated_receipt_yn==null) consolidated_receipt_yn="";			
		String user_id = (String)support_data.get("user_id");
		if(user_id==null) user_id="";			
		String client_ip_address = (String)support_data.get("client_ip_address");
		if(client_ip_address==null) client_ip_address="";
		String rcpt_type_code = (String)support_data.get("rcpt_type_code");
		if(rcpt_type_code==null) rcpt_type_code="";
		String currdate = (String)support_data.get("currdate");
		if(currdate==null) currdate="";
		String str_tot_rec = (String)support_data.get("str_tot_rec");
		if(str_tot_rec==null) str_tot_rec="0";			
		String str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd = (String)support_data.get("str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd");
		if(str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd==null) str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd="";
		String hand_without_counter_chk_out = (String)support_data.get("hand_without_counter_chk_out");
		if(hand_without_counter_chk_out==null) hand_without_counter_chk_out="";			
		String str_doc_amt="";
		int tot_rec=Integer.parseInt(str_tot_rec);
		String str_sysmesage_id_limit="";

		if(str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd.equals("Y"))
		{
			try
			{
				ArrayList rtn_str_slmt_doc_amt=new ArrayList();
				ArrayList rtn_str_slmt_type_code=new ArrayList();
				ArrayList rtn_str_slmt_doc_ref_desc=new ArrayList();
				ArrayList rtn_str_slmt_doc_ref_date=new ArrayList();
				ArrayList rtn_str_slmt_doc_remarks=new ArrayList();
				ArrayList rtn_str_app_ref_no=new ArrayList();
				ArrayList rtn_str_cash_slmt_flag=new ArrayList();
				ArrayList rtn_str_cc_batch_no=new ArrayList();
				ArrayList rtn_str_cc_sale_draft_no=new ArrayList();
				ArrayList rtn_str_cc_swipped_yn=new ArrayList();
				ArrayList rtn_str_bank_code=new ArrayList();
				ArrayList rtn_str_bank_branch=new ArrayList();
				ArrayList rtn_str_cash_amt_given=new ArrayList();
				ArrayList rtn_str_cash_amt_return=new ArrayList();
				ArrayList rtn_str_payer_name=new ArrayList();
				ArrayList rtn_str_rcpt_rfnd_id_no=new ArrayList();
				ArrayList rtn_str_nominee_name=new ArrayList();
				ArrayList rtn_str_doc_sr_no=new ArrayList();

				rtn_str_slmt_doc_amt = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_doc_amt");
				rtn_str_slmt_type_code = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_type_code");
    			rtn_str_slmt_doc_ref_date = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_doc_ref_date");
				rtn_str_slmt_doc_ref_desc = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_doc_ref_desc");
				rtn_str_slmt_doc_remarks = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_doc_remarks");
				rtn_str_app_ref_no = (ArrayList)mult_slmt_vals.get("rtn_str_app_ref_no");
				rtn_str_cash_slmt_flag = (ArrayList)mult_slmt_vals.get("rtn_str_cash_slmt_flag");
				rtn_str_cc_batch_no = (ArrayList)mult_slmt_vals.get("rtn_str_cc_batch_no");
				rtn_str_cc_sale_draft_no = (ArrayList)mult_slmt_vals.get("rtn_str_cc_sale_draft_no");			
				rtn_str_cc_swipped_yn = (ArrayList)mult_slmt_vals.get("rtn_str_cc_swipped_yn");
				rtn_str_bank_code = (ArrayList)mult_slmt_vals.get("rtn_str_bank_code");
				rtn_str_bank_branch = (ArrayList)mult_slmt_vals.get("rtn_str_bank_branch");
				rtn_str_cash_amt_given = (ArrayList)mult_slmt_vals.get("rtn_str_cash_amt_given");
				rtn_str_cash_amt_return = (ArrayList)mult_slmt_vals.get("rtn_str_cash_amt_return");
				rtn_str_payer_name = (ArrayList)mult_slmt_vals.get("rtn_str_payer_name");
				rtn_str_rcpt_rfnd_id_no = (ArrayList)mult_slmt_vals.get("rtn_str_rcpt_rfnd_id_no");
				rtn_str_nominee_name = (ArrayList)mult_slmt_vals.get("rtn_str_nominee_name");
				rtn_str_doc_sr_no = (ArrayList)mult_slmt_vals.get("rtn_str_doc_sr_no");	
				insertable = true;
			/**************added for CRF-13**************************/
				try
				{
					if(hand_without_counter_chk_out.equals("Y"))
					{			
						String str_rcpt_doc_amt="",arr_str_rcpt_doc_amt="",arr_str_slmt_type_code="",str_slmt_type_code="";
						for(int i=0;i<tot_rec;i++)
						{
							arr_str_rcpt_doc_amt=(String)rtn_str_slmt_doc_amt.get(i);
							str_rcpt_doc_amt=str_rcpt_doc_amt+arr_str_rcpt_doc_amt;	
					
							arr_str_slmt_type_code=(String)rtn_str_slmt_type_code.get(i);
							str_slmt_type_code=str_slmt_type_code+arr_str_slmt_type_code;	
						}
			
						str_rcpt_doc_amt=str_rcpt_doc_amt.replace("|","~");
						str_slmt_type_code=str_slmt_type_code.replace("|","~");

						if(insertable)
						{
							str_rcpt_doc_amt = str_rcpt_doc_amt.replace("|","~");
							str_slmt_type_code = str_slmt_type_code.replace("|","~");
							CallableStatement cstmt = con.prepareCall("{ call bl_proc_check_lmt(?,?,?,?,?,?,?,?)}");
							cstmt.setString(1,facility_id);
							cstmt.setString(2,user_id);
							cstmt.setString(3,cash_counter_code);
							cstmt.setString(4,str_slmt_type_code);
							cstmt.setString(5,str_rcpt_doc_amt);					

							cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);	
							cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);	
							cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);

							cstmt.execute();	

							str_error_level		 = cstmt.getString(6);		
							str_sysmesage_id	 = cstmt.getString(7);		
							str_error_text     	 = cstmt.getString(8);				

							if ( str_error_level  == null ) str_error_level = "";
							if ( str_sysmesage_id == null ) str_sysmesage_id ="";
							if ( str_error_text	  == null ) str_error_text ="";
							if ((str_error_level.equals("10") && (!str_error_text.equals(""))) ||!str_sysmesage_id.equals(""))
							{
								if(str_error_level.equals("10") && (!str_error_text.equals("")))
								{
									insertable = false;
								}
								if(!str_sysmesage_id.equals(""))
								{	
									if(	str_sysmesage_id.equals("BL7340"))
									{
										str_sysmesage_id_limit="BL7340";
										insertable = true;
									}
									else
									{
										str_sysmesage_id_limit="";
										insertable = false;
									}
								}
							}
							cstmt.close();
						}//insertable
					}//if
				}
				catch(Exception ee)
				{
					insertable=false;
				sys_err.append(" Exception while calling bl_proc_check_lmt:"+ee);
				System.out.println("Exception in Proc bl_proc_check_lmt Call:"+ee);;
				}
				/*************End*******************************************/		

				for(int i=0;i<tot_rec;i++)
				{
					str_doc_amt=(String)rtn_str_slmt_doc_amt.get(i);
					str_doc_amt=str_doc_amt.substring(0,str_doc_amt.length()-1);
					if(insertable)
					{
						String cash_counter_facility_id="", cc_count="",cc_refund_ded_amt="",calling_function_id="EBL_ENTER_RECEIPT_REFUND";
						str_tot_rec="1";
						//debetor_catagory_code=episode_type
						String sqldoctype="{ call   BL_INSERT_DEPOSIT.BL_INSERT_DEPOSIT_BUILD_TABLE('"+facility_id+"','"+rcpt_rfnd_ind+"','"+rcpt_nature_code+"','"+rcpt_type_code+"','"+episode_type+"','"+episode_type+"','"+patient_id+"','"+episode_id+"','"+visit_id+"','"+encounter_id+"','"+cash_counter_facility_id+"','"+cash_counter_code+"','"+shift_id+"','"+str_doc_amt+"','"+cc_refund_ded_amt+"','"+narration+"','"+ip_adm_trf_dep_ind+"','"+rec_ref_format_ind+"','"+rfnd_dep_in_use_yn+"','"+pmnt_thru_mail+"','"+ext_acc_facility_id+"','"+ext_acc_code+"','"+ext_acc_dept_code+"','"+mult_slmt_yn+"','"+downtime_entry_yn+"','"+downtime_reason_code+"','"+downtime_doc_type_code+"','"+downtime_doc_num+"','"+downtime_doc_date+"','"+cc_machine_id+"','"+payers_add1+"','"+payers_add2+"','"+payers_add3+"','"+payers_tel_num+"','"+consolidated_receipt_yn+"','"+user_id+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+user_id+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+client_ip_address+"','"+facility_id+"','"+client_ip_address+"','"+facility_id+"','"+rtn_str_doc_sr_no.get(i)+"','"+rtn_str_slmt_doc_amt.get(i)+"','"+rtn_str_slmt_type_code.get(i)+"','"+rtn_str_slmt_doc_ref_desc.get(i)+"','"+rtn_str_slmt_doc_ref_date.get(i)+"','"+rtn_str_slmt_doc_remarks.get(i)+"','"+rtn_str_app_ref_no.get(i)+"','"+rtn_str_cash_slmt_flag.get(i)+"','"+rtn_str_cc_batch_no.get(i)+"','"+rtn_str_cc_sale_draft_no.get(i)+"','"+rtn_str_cc_swipped_yn.get(i)+"','"+rtn_str_bank_code.get(i)+"','"+rtn_str_bank_branch.get(i)+"','"+rtn_str_cash_amt_given.get(i)+"','"+rtn_str_cash_amt_return.get(i)+"','"+rtn_str_payer_name.get(i)+"','"+rtn_str_rcpt_rfnd_id_no.get(i)+"','"+rtn_str_nominee_name.get(i)+"','"+user_id+"','"+facility_id+"','"+locale+"','"+client_ip_address+"',?,?,'"+cc_count+"','"+calling_function_id+"',?,?,'"+str_tot_rec+"',?,?,?,?,?,?,?)}";
						//System.out.println("sqlcashctr :"+sqldoctype);				
						CallableStatement cstmt = con.prepareCall(sqldoctype);
						cstmt.setString(1,cash_counter_code);
						cstmt.setString(2,shift_id);
						cstmt.setString(3,str_session_id);
						cstmt.setString(4,str_pgm_date);				
				
						cstmt.registerOutParameter(1,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);					
						cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);//Added by muthu on 25-7-12 Receipt
						cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);//Added by muthu on 25-7-12 Receipt
					//	rec_print_format_enabled_yn=cstmt.getString(7);//Added by muthu on 25-7-12 Receipt
					//	str_rec_prt_format_vals=cstmt.getString(8);//Added by muthu on 25-7-12 Receipt
						
						cstmt.execute();
					
						cash_counter_code = cstmt.getString(1);
						shift_id = cstmt.getString(2);
						str_session_id = cstmt.getString(3);
						str_pgm_date  = cstmt.getString(4);					
						str_doc_type_code = cstmt.getString(5);
						str_doc_no=cstmt.getString(6);
						rec_print_format_enabled_yn=cstmt.getString(7);//Added by muthu on 25-7-12 Receipt
						str_rec_prt_format_vals=cstmt.getString(8);//Added by muthu on 25-7-12 Receipt
						str_error_level=cstmt.getString(9);
						str_sysmesage_id=cstmt.getString(10);					
						str_error_text=cstmt.getString(11);

						if(cash_counter_code==null) cash_counter_code="";
						if(shift_id==null) shift_id="";
						if(str_session_id==null) str_session_id="";
						if(str_pgm_date==null) str_pgm_date="";
						if(str_doc_type_code==null) str_doc_type_code="";
						if(str_doc_no==null) str_doc_no="";					
						if(str_error_level==null) str_error_level="";
						if(str_sysmesage_id==null) str_sysmesage_id="";
						if(str_error_text==null) str_error_text="";
						//Added by muthu on 25-7-12 Receipt
						if(rec_print_format_enabled_yn==null) rec_print_format_enabled_yn="";
						if(str_rec_prt_format_vals==null) str_rec_prt_format_vals="";
						//Added by muthu on 25-7-12 Receipt						

						cstmt.close();

						if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
						{
							insertable=false;
						}
						else
						{
							insertable = true;
							gen_doc_type = str_doc_type_code;
							gen_doc_num = str_doc_no;
							final_msg_doc_type_code =final_msg_doc_type_code+"::"+str_doc_type_code+"/"+str_doc_no;


						}
					}//end insertable
				}//end for
			}
			catch(Exception e)
			{
				insertable=false;
				sys_err.append(" Exception while calling BL_INSERT_DEPOSIT_BUILD_TABLE:"+e);
				System.out.println("Exception in Proc Call:"+e);
			}
		}
		else
		{
			String rtn_str_slmt_doc_amt = (String)mult_slmt_vals.get("rtn_str_slmt_doc_amt");
			if(rtn_str_slmt_doc_amt==null) rtn_str_slmt_doc_amt="";
			String rtn_str_slmt_type_code = (String)mult_slmt_vals.get("rtn_str_slmt_type_code");
			if(rtn_str_slmt_type_code==null) rtn_str_slmt_type_code="";
			String rtn_str_slmt_doc_ref_date = (String)mult_slmt_vals.get("rtn_str_slmt_doc_ref_date");
			if(rtn_str_slmt_doc_ref_date==null) rtn_str_slmt_doc_ref_date="";
			String rtn_str_slmt_doc_ref_desc = (String)mult_slmt_vals.get("rtn_str_slmt_doc_ref_desc");
			if(rtn_str_slmt_doc_ref_desc==null) rtn_str_slmt_doc_ref_desc="";
			String rtn_str_slmt_doc_remarks = (String)mult_slmt_vals.get("rtn_str_slmt_doc_remarks");
			if(rtn_str_slmt_doc_remarks==null) rtn_str_slmt_doc_remarks="";
			String rtn_str_app_ref_no = (String)mult_slmt_vals.get("rtn_str_app_ref_no");
			if(rtn_str_app_ref_no==null) rtn_str_app_ref_no="";
			String rtn_str_cash_slmt_flag = (String)mult_slmt_vals.get("rtn_str_cash_slmt_flag");
			if(rtn_str_cash_slmt_flag==null) rtn_str_cash_slmt_flag="";
			String rtn_str_cc_batch_no = (String)mult_slmt_vals.get("rtn_str_cc_batch_no");
			if(rtn_str_cc_batch_no==null) rtn_str_cc_batch_no="";
			String rtn_str_cc_sale_draft_no = (String)mult_slmt_vals.get("rtn_str_cc_sale_draft_no");
			if(rtn_str_cc_sale_draft_no==null) rtn_str_cc_sale_draft_no="";
			String rtn_str_cc_swipped_yn = (String)mult_slmt_vals.get("rtn_str_cc_swipped_yn");
			if(rtn_str_cc_swipped_yn==null) rtn_str_cc_swipped_yn="";
			String rtn_str_bank_code = (String)mult_slmt_vals.get("rtn_str_bank_code");
			if(rtn_str_bank_code==null) rtn_str_bank_code="";
			String rtn_str_bank_branch = (String)mult_slmt_vals.get("rtn_str_bank_branch");
			if(rtn_str_bank_branch==null) rtn_str_bank_branch="";
			String rtn_str_cash_amt_given = (String)mult_slmt_vals.get("rtn_str_cash_amt_given");
			if(rtn_str_cash_amt_given==null) rtn_str_cash_amt_given="";
			String rtn_str_cash_amt_return = (String)mult_slmt_vals.get("rtn_str_cash_amt_return");
			if(rtn_str_cash_amt_return==null) rtn_str_cash_amt_return="";
			String rtn_str_payer_name = (String)mult_slmt_vals.get("rtn_str_payer_name");
			if(rtn_str_payer_name==null) rtn_str_payer_name="";
			String rtn_str_rcpt_rfnd_id_no = (String)mult_slmt_vals.get("rtn_str_rcpt_rfnd_id_no");
			if(rtn_str_rcpt_rfnd_id_no==null) rtn_str_rcpt_rfnd_id_no="";
			String rtn_str_nominee_name = (String)mult_slmt_vals.get("rtn_str_nominee_name");
			if(rtn_str_nominee_name==null) rtn_str_nominee_name="";
			String rtn_str_doc_sr_no = (String)mult_slmt_vals.get("rtn_str_doc_sr_no");
			if(rtn_str_doc_sr_no==null) rtn_str_doc_sr_no="";
			insertable = true;
/**************added for CRF-13**************************/
			try
			{
				if(hand_without_counter_chk_out.equals("Y"))
				{
					if(insertable)
					{
						String str_rcpt_doc_amt = rtn_str_slmt_doc_amt.replace("|","~");
						String str_slmt_type_code = rtn_str_slmt_type_code.replace("|","~");

						/*System.out.println("str_rcpt_doc_amt 1hh" +str_rcpt_doc_amt);
						System.out.println("str_slmt_type_code 1hh" +str_slmt_type_code);
						System.out.println("cash_counter_code 1hh" +cash_counter_code);
						System.out.println("user_id 1" +user_id);*/
						CallableStatement cstmt = con.prepareCall("{ call bl_proc_check_lmt(?,?,?,?,?,?,?,?)}");
						cstmt.setString(1,facility_id);
						cstmt.setString(2,user_id);
						cstmt.setString(3,cash_counter_code);
						cstmt.setString(4,str_slmt_type_code);
						cstmt.setString(5,str_rcpt_doc_amt);					

						cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);	
						cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);	
						cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
						
						cstmt.execute();	
								
						str_error_level		 = cstmt.getString(6);		
						str_sysmesage_id	 = cstmt.getString(7);		
						str_error_text     	 = cstmt.getString(8);				
						
						if ( str_error_level  == null ) str_error_level = "";
						if ( str_sysmesage_id == null ) str_sysmesage_id ="";
						if ( str_error_text	  == null ) str_error_text ="";

						if ((str_error_level.equals("10") && (!str_error_text.equals(""))) ||!str_sysmesage_id.equals(""))
						{
							if(str_error_level.equals("10") && (!str_error_text.equals("")))
							{
								insertable = false;
							}
							if(!str_sysmesage_id.equals(""))
							{
								if(	str_sysmesage_id.equals("BL7340"))
								{
									str_sysmesage_id_limit="BL7340";
									insertable = true;
								}
								else
								{
									str_sysmesage_id_limit="";
									insertable = false;
								}
							}
						}
						cstmt.close();
					}//insertable
				}//if
			}catch(Exception ee)
			{
				insertable=false;
				sys_err.append(" Exception while calling bl_proc_check_lmt:"+ee);
				System.out.println("Exception in Proc bl_proc_check_lmt Call:"+ee);;
				ee.printStackTrace();
			}
	/*************End*******************************************/		
			try
			{
				if(insertable)
				{
					String cash_counter_facility_id="", cc_count="",cc_refund_ded_amt="",calling_function_id="EBL_ENTER_RECEIPT_REFUND";
		
					String sqldoctype="{ call   BL_INSERT_DEPOSIT.BL_INSERT_DEPOSIT_BUILD_TABLE('"+facility_id+"','"+rcpt_rfnd_ind+"','"+rcpt_nature_code+"','"+rcpt_type_code+"','"+episode_type+"','"+episode_type+"','"+patient_id+"','"+episode_id+"','"+visit_id+"','"+encounter_id+"','"+cash_counter_facility_id+"','"+cash_counter_code+"','"+shift_id+"','"+doc_amt+"','"+cc_refund_ded_amt+"','"+narration+"','"+ip_adm_trf_dep_ind+"','"+rec_ref_format_ind+"','"+rfnd_dep_in_use_yn+"','"+pmnt_thru_mail+"','"+ext_acc_facility_id+"','"+ext_acc_code+"','"+ext_acc_dept_code+"','"+mult_slmt_yn+"','"+downtime_entry_yn+"','"+downtime_reason_code+"','"+downtime_doc_type_code+"','"+downtime_doc_num+"','"+downtime_doc_date+"','"+cc_machine_id+"','"+payers_add1+"','"+payers_add2+"','"+payers_add3+"','"+payers_tel_num+"','"+consolidated_receipt_yn+"','"+user_id+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+user_id+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+client_ip_address+"','"+facility_id+"','"+client_ip_address+"','"+facility_id+"','"+rtn_str_doc_sr_no+"','"+rtn_str_slmt_doc_amt+"','"+rtn_str_slmt_type_code+"','"+rtn_str_slmt_doc_ref_desc+"','"+rtn_str_slmt_doc_ref_date+"','"+rtn_str_slmt_doc_remarks+"','"+rtn_str_app_ref_no+"','"+rtn_str_cash_slmt_flag+"','"+rtn_str_cc_batch_no+"','"+rtn_str_cc_sale_draft_no+"','"+rtn_str_cc_swipped_yn+"','"+rtn_str_bank_code+"','"+rtn_str_bank_branch+"','"+rtn_str_cash_amt_given+"','"+rtn_str_cash_amt_return+"','"+rtn_str_payer_name+"','"+rtn_str_rcpt_rfnd_id_no+"','"+rtn_str_nominee_name+"','"+user_id+"','"+facility_id+"','"+locale+"','"+client_ip_address+"',?,?,'"+cc_count+"','"+calling_function_id+"',?,?,'"+str_tot_rec+"',?,?,?,?,?,?,?)}";
					//System.out.println("sqlcashctr 1:"+sqldoctype);
				
					CallableStatement cstmt = con.prepareCall(sqldoctype);
					cstmt.setString(1,cash_counter_code);
					cstmt.setString(2,shift_id);
					cstmt.setString(3,str_session_id);
					cstmt.setString(4,str_pgm_date);				
			
					cstmt.registerOutParameter(1,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);					
					cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);//Added by muthu on 25-7-12 Receipt
					cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);//Added by muthu on 25-7-12 Receipt
					
					cstmt.execute();
					

					cash_counter_code = cstmt.getString(1);
					shift_id = cstmt.getString(2);
					str_session_id = cstmt.getString(3);
					str_pgm_date  = cstmt.getString(4);					
					str_doc_type_code = cstmt.getString(5);
					str_doc_no=cstmt.getString(6);
					rec_print_format_enabled_yn=cstmt.getString(7);//Added by muthu on 25-7-12 Receipt
					str_rec_prt_format_vals=cstmt.getString(8);//Added by muthu on 25-7-12 Receipt
					str_error_level=cstmt.getString(9);
					str_sysmesage_id=cstmt.getString(10);					
					str_error_text=cstmt.getString(11);

					if(cash_counter_code==null) cash_counter_code="";
					if(shift_id==null) shift_id="";
					if(str_session_id==null) str_session_id="";
					if(str_pgm_date==null) str_pgm_date="";
					if(str_doc_type_code==null) str_doc_type_code="";
					if(str_doc_no==null) str_doc_no="";					
					if(str_error_level==null) str_error_level="";
					if(str_sysmesage_id==null) str_sysmesage_id="";
					if(str_error_text==null) str_error_text="";
//System.out.println("sqlcashctr 1 dfdsffdfdfsffds:");	
					//Added by muthu on 25-7-12 Receipt
					if(rec_print_format_enabled_yn==null) rec_print_format_enabled_yn="";
					if(str_rec_prt_format_vals==null) str_rec_prt_format_vals="";
					//Added by muthu on 25-7-12 Receipt
					cstmt.close();

					if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
					{
						insertable=false;
					}
					else
					{
						insertable = true;
						gen_doc_type = str_doc_type_code;
						gen_doc_num = str_doc_no;
						final_msg_doc_type_code =final_msg_doc_type_code+"::"+str_doc_type_code+"/"+str_doc_no;

					}
				}
			}
			catch(Exception e)
			{
				insertable=false;
				sys_err.append(" Exception while calling BL_INSERT_DEPOSIT_BUILD_TABLE:"+e);
				System.out.println("Exception in Proc Call:"+e);
				e.printStackTrace();
			}
		}// end else 

		if(insertable)
		{
			results.put("success","success") ;	
		}
		else
		{
			results.put("str_sysmesage_id",str_sysmesage_id) ;	
			results.put("str_error_text",str_error_text) ;
			results.put("str_error_level",str_error_level) ;
			results.put("sys_error",sys_err.toString());
			results.put("success","fail") ;	
		}
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
	
	//Copied the method from PkgSubscriptionManager to enable Recalculation for Order Associated packages - Rajesh V
	private HashMap recalculation(Connection con,String facility_id, String patientId,
			String episodeType, String episodeId, String visitId, String client_ip_address, String user_id) {
		HashMap returnMap = new HashMap();
		boolean insertable = false;
		int reqId = 0;
		try{
			System.err.println("Starting Recalculation");
			String str_error_level = "", str_sysmesage_id = "", str_error_text="";
			//String recalc = "{ call   bl_recalc_process.proc_recalculation (?,?,?,?,?,?,?,?,?,?) }";
			String recalc = "{ call   bl_recalc_process.proc_recalc (?,?,?,?,?,?,?,?,?,?,?,?) }";
			CallableStatement cstmt =con.prepareCall(recalc);

			cstmt.setString(1, facility_id);
			cstmt.setString(2,patientId);
			cstmt.setString(3, episodeType);
			cstmt.setString(4, episodeId);
			cstmt.setString(5, visitId);
			cstmt.setString(6, client_ip_address);
			cstmt.setString(7, user_id);
			cstmt.setString(8, "PKG_SUBSCRIPTION");
			cstmt.registerOutParameter(9, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(12, java.sql.Types.INTEGER);
			
			
			cstmt.execute();
			str_error_level = cstmt.getString(10);
			str_sysmesage_id = cstmt.getString(9);
			str_error_text = cstmt.getString(11);
			reqId = cstmt.getInt(12);

			System.err.println("str_error_level-"+str_error_level+"str_sysmesage_id-"+str_sysmesage_id+"str_error_text-"+str_error_text);
			if(str_error_level!=null || str_error_text!=null){
				returnMap.put("recalcHdr", str_error_level+"-"+str_error_text);
			}

			if (!returnMap.isEmpty()) {
				insertable = false;
			} else {
				insertable = true;
			}
			
			returnMap.put("requestId", reqId);
			
			if(cstmt!=null)
			cstmt.close();

		}
		catch(Exception e){
			System.err.println("Exception is "+e);
			returnMap.put("internalError", "Internal Error");
			insertable = false;
		}
		finally{
			returnMap.put("status", new Boolean(insertable));
			return returnMap;
		}
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