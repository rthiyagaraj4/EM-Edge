<!DOCTYPE html>
<%@  page import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*,eBL.Common.*,com.ehis.util.*,eBL.*" contentType="text/html;charset=UTF-8" %>
<%@page import="eBL.BLReportIdMapper"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<!-- <%@  page import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %> -->

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	String open_pkg_exists_yn=""; 
	String pyrGrpYN="";
    System.err.println("KKKK AddModifyPatFinDetails.jsp?"+request.getQueryString());
	String bean_id		= "PkgAssociateBean" ;
	String bean_name	= "eBL.PkgAssociateBean";
	PkgAssociateBean bean			= (PkgAssociateBean)getBeanObject( bean_id, bean_name, request ) ;
	Connection con = null;
	CallableStatement call_pkg = null;
	PreparedStatement pstmt = null ;
	Statement stmt1				= null;
	ResultSet rs = null, rs0 = null;
	ResultSet rs1 = null, rs2 = null, rs3 = null,rs4 = null;
	ResultSet rset = null;
	String gl_holder_name = "", gl_rel = "";
	String locale			= (String)session.getAttribute("LOCALE");
	int noofdecimal=2;
	String sys_date="";
	String sys_date_wht_sec=""; // System time without seconds
	String encounter_date="";
	String billing_group="";
	String str_slmt_ind="";
	String str_credit_doc_reqd_yn="";
	String str_blng_class="";
	String str_emp_code="";
	String str_slmt_type_code="";
	String str_non_ins_credit_doc_reqd_yn="";
	String str_annual_income="";
	String str_family_asset="";
	String str_no_of_dependants="";
	String str_resp_for_payment="";
	String str_pat_reln_with_resp_person="";
	String str_gl_holder_name="";
	String str_pat_reln_with_gl_holder="";
	String str_upd_patient_fin_dtls_yn="";
	String upd_pat_fin_dtls_YN="";
	String spl_clinic_rel_enc_YN = "";
	String str_spl_clinic_rel_enc_YN="";
	String str_user_id="";
	String sql="";
	String str_adm_rec_flag ="";
	String credit_doc_ref_reqd_yn="";
	String disaster_regn_YN="";
	String strCustomerId = "";

	String ref_src_main_code="";
	String ref_src_main_desc="";
	String ref_src_main_lng_name = "";
	String ref_src_sub_code="";	
	String ref_src_sub_desc="";
	String ref_src_sub_lng_name = "";
	String cur_patient_id ="";

	String sel_frm_prev_enc="N";
	String pat_ser_code="";

	String encounter_date_time = "", encounter_date_aft_trunc="";

	String cash_leg ="", credit_leg ="", sponsor_leg ="", ins_leg ="";

	String fin_class_flag_YN="N", autoFinChk="N", fin_class_dtls_updated_YN="N",class_blng_grp_id="";

	String charge_for_pat_regn_yn = "N";

	String referral_source_capture_YN="N";
	String referral_source_main_mand_YN="N";
	String referral_source_sub_mand_YN="N";

	String fin_auth_user_id="", remarks="";
	String package_enabled_yn="N";//added for package billing
	String facility_id  =  "", strLoggedUser = "" ;
	//Rajesh V
	String hCardYn = "";
	String str_charge_logic ="";
	
	String payerGrpBySetup = "";
	//Rajesh V
	String isUserAuthorizedClass = request.getParameter("isUserAuthorizedClass");
	if(isUserAuthorizedClass == null)		isUserAuthorizedClass="";
//	System.err.println("eBL  Modify PatFin details");
//Boopathy
			String quickAdmissionBillingGroup = null;

			String callingModule= request.getParameter("calling_module_id");
			String callingFunction=request.getParameter("calling_function_id");
			String quickAdmission=request.getParameter("quick_admission");
			if(callingModule==null) callingModule="";
			if(callingFunction==null) callingFunction="";
			if(quickAdmission==null) quickAdmission="N";

//Boopathy
	try
	{
		con = ConnectionManager.getConnection(request);

		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession(false);

		Properties p = (Properties)httpSession.getValue("jdbc");

		
		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);

		cash_leg = (String) bl_labels.getString("eBL.CASH.label");
		if(cash_leg == null) cash_leg="";
		credit_leg = (String) bl_labels.getString("eBL.CREDIT.label");
		if(credit_leg == null) credit_leg="";
		sponsor_leg = (String) bl_labels.getString("eBL.SPONSOR.label");
		if(sponsor_leg == null) sponsor_leg="";
		ins_leg = (String) common_labels.getString("Common.Insurance.label");
		if(ins_leg == null) ins_leg="";

		facility_id = (String)httpSession.getValue("facility_id");
		if(facility_id == null) facility_id="";
		strLoggedUser = p.getProperty("login_user");
		if(strLoggedUser == null) strLoggedUser="";

		String payer_suspended_YN =""; //Added by MuthuN against 32426 on 07-09-12

		encounter_date_time = request.getParameter("encounter_date_time");
		if(encounter_date_time == null) encounter_date_time="";
		String strUpdFinDtls = null;		
		
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
			System.out.println("Exception in getting CUSTOMER_ID"+e);
			e.printStackTrace();
		}
		
			Boolean SiteSpec=false;
			String SiteSpecific ="";
			try
			{
				con = ConnectionManager.getConnection();	
				SiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISABLE_FIN_DETAILS_IN_MP");				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if(SiteSpec){
				SiteSpecific="Y";
			}
			else{
				SiteSpecific="N";
			}
		try
		{
		pstmt = con.prepareStatement("select DFLT_UPDAT_FIN_DTL_CHKBX,NVL(CHARGE_LOGIC_YN,'N') CHARGE_LOGIC ,NVL(ADD_PAYER_CUSTGRP_BY_SETUP,'N') PAYER_GRP  from bl_parameters where OPERATING_FACILITY_ID =?");
		pstmt.setString(1,facility_id);
		ResultSet rsst = pstmt.executeQuery() ;
		if( rsst != null ) 
		{	
			while( rsst.next() )
			{  
				strUpdFinDtls = rsst.getString(1);
				str_charge_logic = rsst.getString(2);
				payerGrpBySetup  = rsst.getString(3);
				
			}
		}
		if (rsst != null) rsst.close();
		pstmt.close();	
		
		}catch(Exception ee)
		{
			strUpdFinDtls = "N";
		}

// Added acc_entity_id='ZZ' in the condition for PE Changes
		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2),to_char(sysdate,'dd/mm/yyyy HH24:MI:SS'),to_char(sysdate,'dd/mm/yyyy HH24:MI') from  sm_acc_entity_param where acc_entity_id='ZZ'");
			ResultSet rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);
				sys_date = rscurr.getString(2);
				sys_date_wht_sec = rscurr.getString(3);
			}	
			if(rscurr!=null) rscurr.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in No of Decimal Query="+e.toString());
		}	

		package_enabled_yn = request.getParameter("package_enabled_yn");
		if(package_enabled_yn==null || !package_enabled_yn.equals("Y")) package_enabled_yn="N";	

		if(encounter_date_time.equals(""))
			encounter_date_time = sys_date_wht_sec;

/* Commented for PE Change
		try
		{
			String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS'),to_char(sysdate,'dd/mm/yyyy HH24:MI'), to_char( (to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') from dual";

			stmt1 = con.createStatement();
			rs4 = stmt1.executeQuery(query_date) ;
			if( rs4 != null ) 
			{
				while( rs4.next() )
				{  
					sys_date = rs4.getString(1);
					sys_date_wht_sec = rs4.getString(2);
					encounter_date_aft_trunc = rs.getString(3);
				}
			}
			if(rs4 !=null) rs4.close();
			stmt1.close();

			query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
			stmt1 = con.createStatement();
			rs4 = stmt1.executeQuery(query_date) ;
			if( rs4 != null ) 
			{
				while( rs4.next() )
				{  
					sys_date_wht_sec = rs4.getString(1);
				}
			}
			if(rs4 !=null) rs4.close();
			stmt1.close();
		}
		catch(Exception e)
		{
			out.println("Exception @ sysdate query"+e);
		}
*/
		try
		{
			String sql_trunc_time="select to_char( (to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') from dual";

			stmt1 = con.createStatement();
			rs = stmt1.executeQuery(sql_trunc_time) ;

			if( rs!= null ) 
			{
				while( rs.next() )
				{  
					encounter_date_aft_trunc = rs.getString(1);
				}
			}
			if (rs != null)   rs.close();
			stmt1.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception while executing sql_trunc_time :"+e);
		}
		if(!encounter_date_aft_trunc.equals(""))
		{
			encounter_date_aft_trunc = com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY","en",locale) ;
		}


		String query_string=request.getQueryString();

		encounter_date=request.getParameter("encounter_date");
		if(encounter_date==null) encounter_date="";

		disaster_regn_YN=request.getParameter("disaster_regn_YN");
		if(disaster_regn_YN==null || disaster_regn_YN.equals("")) disaster_regn_YN = "N";

		String billing_mode = request.getParameter("billing_mode");
		if(billing_mode==null || billing_mode.equals("")) billing_mode = "Add";

		String operation = request.getParameter("operation");
		if(operation==null || operation.equals("")) operation = "Insert";

		sel_frm_prev_enc=request.getParameter("sel_frm_prev_enc");
		if(sel_frm_prev_enc==null || sel_frm_prev_enc.equals("")) sel_frm_prev_enc = "N";

		pat_ser_code =request.getParameter("pat_ser_code");
		if(pat_ser_code==null || pat_ser_code.equals("")) pat_ser_code = "";


		fin_class_flag_YN = request.getParameter("fin_class_flag_YN");
		if(fin_class_flag_YN == null) fin_class_flag_YN="N";

		autoFinChk = request.getParameter("autoFinChk");
		if(autoFinChk == null) autoFinChk="N";
		
		class_blng_grp_id = request.getParameter("class_blng_grp_id");
		if(class_blng_grp_id == null) class_blng_grp_id="N";


		charge_for_pat_regn_yn = request.getParameter("charge_for_pat_regn_yn");
		if(charge_for_pat_regn_yn == null) charge_for_pat_regn_yn="N";

		fin_auth_user_id = request.getParameter("fin_auth_user_id");
		if(fin_auth_user_id == null) fin_auth_user_id="";

		remarks = request.getParameter("remarks");
		if(remarks == null) remarks="";

/*	 The billing_mode & Operation is reset because the billing_group is been reset & to avoid the session to validate  */
		String reset_blng_grp=request.getParameter("reset_blng_grp");

		if(reset_blng_grp==null || reset_blng_grp.equals("")) reset_blng_grp="";
		if(reset_blng_grp.equals("YES")) 
		{
			billing_mode="Add";
			operation="Insert";
		}			
		Boolean siteSpec=false;
		
		try
		{
			
			siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISP_FIN_CLASS_DTLS_BLANK");
	
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception in site specific "+e);
		}


		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{

			HashMap bl_data=(HashMap)session.getAttribute("financial_details");
			if(!(bl_data==null || bl_data.isEmpty()))
			{
				String finDetClose="";
				finDetClose = ((String)bl_data.get("fin_det_close")).trim();
				if(finDetClose == null) finDetClose="";
				
				System.out.println("finDetClose BEF:::"+finDetClose);
				if(siteSpec)
				{
				if(callingModule.equals("IP") || callingModule.equals("DC")) {
					 
					if(finDetClose.equals("Y")){		
				billing_group=((String)bl_data.get("blng_grp")).trim();
				if(billing_group == null) billing_group="";
				str_slmt_ind=((String)bl_data.get("slmt_ind")).trim();
				if(str_slmt_ind == null) str_slmt_ind="";
				str_credit_doc_reqd_yn=((String)bl_data.get("credit_doc_reqd_yn")).trim();
				if(str_credit_doc_reqd_yn == null) str_credit_doc_reqd_yn="";
				str_blng_class=((String)bl_data.get("blng_class")).trim();
				if(str_blng_class == null) str_blng_class="";
				str_emp_code=((String)bl_data.get("emp_code")).trim();
				if(str_emp_code == null) str_emp_code="";
				str_slmt_type_code=((String)bl_data.get("slmt_type_code")).trim();
				if(str_slmt_type_code == null) str_slmt_type_code="";
				str_non_ins_credit_doc_reqd_yn=((String)bl_data.get("non_ins_credit_doc_reqd_yn")).trim();
				if(str_non_ins_credit_doc_reqd_yn == null) str_non_ins_credit_doc_reqd_yn="";
				str_annual_income=((String)bl_data.get("annual_income")).trim();
				if (str_annual_income.equals("")) str_annual_income = "0";
				str_family_asset=((String)bl_data.get("family_asset")).trim();
				if (str_family_asset.equals("")) str_family_asset = "0";
				str_no_of_dependants=((String)bl_data.get("no_of_dependants")).trim();
				if (str_no_of_dependants.equals("")) str_no_of_dependants = "0";
				str_resp_for_payment=((String)bl_data.get("resp_for_payment")).trim();
				if(str_resp_for_payment == null) str_resp_for_payment="";
				str_pat_reln_with_resp_person=((String)bl_data.get("pat_reln_with_resp_person")).trim();
				if(str_pat_reln_with_resp_person == null) str_pat_reln_with_resp_person="";
				str_gl_holder_name=((String)bl_data.get("gl_holder_name")).trim();
				if(str_gl_holder_name == null) str_gl_holder_name="";
				str_pat_reln_with_gl_holder=((String)bl_data.get("pat_reln_with_gl_holder")).trim();
				if(str_pat_reln_with_gl_holder == null) str_pat_reln_with_gl_holder="";
				str_upd_patient_fin_dtls_yn=((String)bl_data.get("upd_patient_fin_dtls_yn")).trim();
				if(str_upd_patient_fin_dtls_yn == null) str_upd_patient_fin_dtls_yn="N";
				str_spl_clinic_rel_enc_YN =((String)bl_data.get("spl_clinic_rel_enc_YN")).trim();
				if(str_spl_clinic_rel_enc_YN == null) str_spl_clinic_rel_enc_YN="N";
				str_user_id=((String)bl_data.get("user_id")).trim();
				if(str_user_id == null) str_user_id="";
				ref_src_main_code=((String)bl_data.get("ref_src_main_code")).trim();
				if(ref_src_main_code==null || ref_src_main_code.equals("")) ref_src_main_code="";
				ref_src_main_desc=((String)bl_data.get("ref_src_main_desc")).trim();
				if(ref_src_main_desc==null || ref_src_main_desc.equals("")) ref_src_main_desc="";
				ref_src_sub_code=((String)bl_data.get("ref_src_sub_code")).trim();
				if(ref_src_sub_code==null || ref_src_sub_code.equals("")) ref_src_sub_code="";
				ref_src_sub_desc=((String)bl_data.get("ref_src_sub_desc")).trim();
				if(ref_src_sub_desc==null || ref_src_sub_desc.equals("")) ref_src_sub_desc="";

				cur_patient_id=((String)bl_data.get("cur_patient_id"));
				if(cur_patient_id==null || cur_patient_id.equals("")) cur_patient_id="";
						
						if(autoFinChk.equals("Y"))
						{
							fin_class_dtls_updated_YN=((String)bl_data.get("fin_class_dtls_updated_YN")).trim();
							if(fin_class_dtls_updated_YN==null || fin_class_dtls_updated_YN.equals("")) fin_class_dtls_updated_YN="N";
						}

				
					}else{					
					
						billing_group=((String)bl_data.get("blng_grp")).trim();
						if(billing_group == null) billing_group="";
						str_no_of_dependants=((String)bl_data.get("no_of_dependants")).trim();
						if (str_no_of_dependants.equals("")) str_no_of_dependants = "0";
					}
				
				}else{

					billing_group=((String)bl_data.get("blng_grp")).trim();
					if(billing_group == null) billing_group="";
					str_slmt_ind=((String)bl_data.get("slmt_ind")).trim();
					if(str_slmt_ind == null) str_slmt_ind="";
					str_credit_doc_reqd_yn=((String)bl_data.get("credit_doc_reqd_yn")).trim();
					if(str_credit_doc_reqd_yn == null) str_credit_doc_reqd_yn="";
					str_blng_class=((String)bl_data.get("blng_class")).trim();
					if(str_blng_class == null) str_blng_class="";
					str_emp_code=((String)bl_data.get("emp_code")).trim();
					if(str_emp_code == null) str_emp_code="";
					str_slmt_type_code=((String)bl_data.get("slmt_type_code")).trim();
					if(str_slmt_type_code == null) str_slmt_type_code="";
					str_non_ins_credit_doc_reqd_yn=((String)bl_data.get("non_ins_credit_doc_reqd_yn")).trim();
					if(str_non_ins_credit_doc_reqd_yn == null) str_non_ins_credit_doc_reqd_yn="";
					str_annual_income=((String)bl_data.get("annual_income")).trim();
					if (str_annual_income.equals("")) str_annual_income = "0";
					str_family_asset=((String)bl_data.get("family_asset")).trim();
					if (str_family_asset.equals("")) str_family_asset = "0";
					str_no_of_dependants=((String)bl_data.get("no_of_dependants")).trim();
					if (str_no_of_dependants.equals("")) str_no_of_dependants = "0";
					str_resp_for_payment=((String)bl_data.get("resp_for_payment")).trim();
					if(str_resp_for_payment == null) str_resp_for_payment="";
					str_pat_reln_with_resp_person=((String)bl_data.get("pat_reln_with_resp_person")).trim();
					if(str_pat_reln_with_resp_person == null) str_pat_reln_with_resp_person="";
					str_gl_holder_name=((String)bl_data.get("gl_holder_name")).trim();
					if(str_gl_holder_name == null) str_gl_holder_name="";
					str_pat_reln_with_gl_holder=((String)bl_data.get("pat_reln_with_gl_holder")).trim();
					if(str_pat_reln_with_gl_holder == null) str_pat_reln_with_gl_holder="";
					str_upd_patient_fin_dtls_yn=((String)bl_data.get("upd_patient_fin_dtls_yn")).trim();
					if(str_upd_patient_fin_dtls_yn == null) str_upd_patient_fin_dtls_yn="N";
					str_spl_clinic_rel_enc_YN =((String)bl_data.get("spl_clinic_rel_enc_YN")).trim();
					if(str_spl_clinic_rel_enc_YN == null) str_spl_clinic_rel_enc_YN="N";
					str_user_id=((String)bl_data.get("user_id")).trim();
					if(str_user_id == null) str_user_id="";
					ref_src_main_code=((String)bl_data.get("ref_src_main_code")).trim();
					if(ref_src_main_code==null || ref_src_main_code.equals("")) ref_src_main_code="";
					ref_src_main_desc=((String)bl_data.get("ref_src_main_desc")).trim();
					if(ref_src_main_desc==null || ref_src_main_desc.equals("")) ref_src_main_desc="";
					ref_src_sub_code=((String)bl_data.get("ref_src_sub_code")).trim();
					if(ref_src_sub_code==null || ref_src_sub_code.equals("")) ref_src_sub_code="";
					ref_src_sub_desc=((String)bl_data.get("ref_src_sub_desc")).trim();
					if(ref_src_sub_desc==null || ref_src_sub_desc.equals("")) ref_src_sub_desc="";

					cur_patient_id=((String)bl_data.get("cur_patient_id"));
					if(cur_patient_id==null || cur_patient_id.equals("")) cur_patient_id="";
					
					if(autoFinChk.equals("Y"))
					{
						fin_class_dtls_updated_YN=((String)bl_data.get("fin_class_dtls_updated_YN")).trim();
						if(fin_class_dtls_updated_YN==null || fin_class_dtls_updated_YN.equals("")) fin_class_dtls_updated_YN="N";
					}	
						
				
				}
				
				}
				else{
					

					billing_group=((String)bl_data.get("blng_grp")).trim();
					if(billing_group == null) billing_group="";
					str_slmt_ind=((String)bl_data.get("slmt_ind")).trim();
					if(str_slmt_ind == null) str_slmt_ind="";
					str_credit_doc_reqd_yn=((String)bl_data.get("credit_doc_reqd_yn")).trim();
					if(str_credit_doc_reqd_yn == null) str_credit_doc_reqd_yn="";
					str_blng_class=((String)bl_data.get("blng_class")).trim();
					if(str_blng_class == null) str_blng_class="";
					str_emp_code=((String)bl_data.get("emp_code")).trim();
					if(str_emp_code == null) str_emp_code="";
					str_slmt_type_code=((String)bl_data.get("slmt_type_code")).trim();
					if(str_slmt_type_code == null) str_slmt_type_code="";
					str_non_ins_credit_doc_reqd_yn=((String)bl_data.get("non_ins_credit_doc_reqd_yn")).trim();
					if(str_non_ins_credit_doc_reqd_yn == null) str_non_ins_credit_doc_reqd_yn="";
					str_annual_income=((String)bl_data.get("annual_income")).trim();
					if (str_annual_income.equals("")) str_annual_income = "0";
					str_family_asset=((String)bl_data.get("family_asset")).trim();
					if (str_family_asset.equals("")) str_family_asset = "0";
					str_no_of_dependants=((String)bl_data.get("no_of_dependants")).trim();
					if (str_no_of_dependants.equals("")) str_no_of_dependants = "0";
					str_resp_for_payment=((String)bl_data.get("resp_for_payment")).trim();
					if(str_resp_for_payment == null) str_resp_for_payment="";
					str_pat_reln_with_resp_person=((String)bl_data.get("pat_reln_with_resp_person")).trim();
					if(str_pat_reln_with_resp_person == null) str_pat_reln_with_resp_person="";
					str_gl_holder_name=((String)bl_data.get("gl_holder_name")).trim();
					if(str_gl_holder_name == null) str_gl_holder_name="";
					str_pat_reln_with_gl_holder=((String)bl_data.get("pat_reln_with_gl_holder")).trim();
					if(str_pat_reln_with_gl_holder == null) str_pat_reln_with_gl_holder="";
					str_upd_patient_fin_dtls_yn=((String)bl_data.get("upd_patient_fin_dtls_yn")).trim();
					if(str_upd_patient_fin_dtls_yn == null) str_upd_patient_fin_dtls_yn="N";
					str_spl_clinic_rel_enc_YN =((String)bl_data.get("spl_clinic_rel_enc_YN")).trim();
					if(str_spl_clinic_rel_enc_YN == null) str_spl_clinic_rel_enc_YN="N";
					str_user_id=((String)bl_data.get("user_id")).trim();
					if(str_user_id == null) str_user_id="";
					ref_src_main_code=((String)bl_data.get("ref_src_main_code")).trim();
					if(ref_src_main_code==null || ref_src_main_code.equals("")) ref_src_main_code="";
					ref_src_main_desc=((String)bl_data.get("ref_src_main_desc")).trim();
					if(ref_src_main_desc==null || ref_src_main_desc.equals("")) ref_src_main_desc="";
					ref_src_sub_code=((String)bl_data.get("ref_src_sub_code")).trim();
					if(ref_src_sub_code==null || ref_src_sub_code.equals("")) ref_src_sub_code="";
					ref_src_sub_desc=((String)bl_data.get("ref_src_sub_desc")).trim();
					if(ref_src_sub_desc==null || ref_src_sub_desc.equals("")) ref_src_sub_desc="";

					cur_patient_id=((String)bl_data.get("cur_patient_id"));
					if(cur_patient_id==null || cur_patient_id.equals("")) cur_patient_id="";
					
					if(autoFinChk.equals("Y"))
					{
						fin_class_dtls_updated_YN=((String)bl_data.get("fin_class_dtls_updated_YN")).trim();
						if(fin_class_dtls_updated_YN==null || fin_class_dtls_updated_YN.equals("")) fin_class_dtls_updated_YN="N";
					}
				}
			}
		}
		else
		{
			billing_group=request.getParameter("billing_group");
	
		}



		if(callingModule.equals("IP") && callingFunction.equals("ADMISSION") && quickAdmission.equalsIgnoreCase("Y")){			
				
				/*	Boolean allowQuickAdmission=true;
					HashMap existingFinDtls=(HashMap)session.getAttribute("financial_details");
					if(existingFinDtls!=null){
					String existingBlngGrp=(String)existingFinDtls.get("blng_grp");
						if(existingBlngGrp==null || existingBlngGrp.equals("")){
						allowQuickAdmission=true;
						}	
						else 	allowQuickAdmission=false;

					}
					
					System.err.println("fin_dtls loaded:"+existingFinDtls);
					System.err.println("allowQuickAdmission flag:"+allowQuickAdmission);
								if(allowQuickAdmission){
					*/


			pstmt = con.prepareStatement( "SELECT DFLT_QUICK_ADM_BLNG_GRP_ID FROM  BL_MP_PARAM");
			ResultSet rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				billing_group = rscurr.getString(1)!= null ? rscurr.getString(1) : "";
			}	
			
			
			}

			if(billing_group == null) billing_group="";
		
		System.err.println("KKKK billing_group  after1 ->"+billing_group);
		
		if(autoFinChk.equals("Y")&&!quickAdmission.equalsIgnoreCase("Y"))
		{
			billing_group = class_blng_grp_id;
		}
		System.err.println("KKKK billing_group  after2 ->"+billing_group);
		System.err.println("KKKK autoFinChk  ->"+autoFinChk);

		String clinic_code_check="";
		String visit_type_code_check="";
		String patient_id_check="";
		String pract_id_check="";
		String billing_reset_flag="";
		String pat_ser_code_check="";

		String strBlngClass ="";
		String strBillType ="";
		String mbilling_group="",mbilling_class="",memployer_code="",package_flag="";
		String ins_auth_flag="",upd_pat_flag="",pkg_bill_type = "",	pkg_bill_no = "";
		String clinic_code ="",visit_type_code="",display="N",display_mode="",show_hide_blng_class="";
		String strEpisodeType = ""; //request.getParameter("episode_type");  
		String strNewEpisodeYN = request.getParameter("episode");  
		String strMessageId = "";
		String strErrorText = "";
		String strSysMessageId="";

		String strHcardSchemeId="";
		String strHcareSchemeId="";
		String strHcardExpiredYN="";
		String strHcareExpiredYN="";
		String strHcardApplicableYN="";
		String strHcareApplicableYN="";
		String strPatBlngGrp="";
		String strMessageDesc="";

		String strPreviousBlngGrp ="";
		String strPreviousBlngGrpDesc="";
		String strHcardPrerequisite_yn="";
		String strSchemeType="";

		String strIPBillingService="";
		String strBedNo="";
		String strDeptCode = "";

		String strdfltbgyn = "N";
		String srtencdfltbgyn="N";
		String strprovselfrmprevencyn="N";
		int prev_enc_check_count=0;
//		int op_ae_prev_enc_check_count=0;
//		int ip_dc_prev_enc_check_count=0;

		String bl_future_admn_YN="";

		String third_party_gl_in_use_yn = "N"; //muthu
		String third_party_gl_mandatory_yn = "N"; //muthu
		String capture_employer_id_yn = "N";

		String strSplSchemeBlngGrpPresent = "0";
		String strBlngGrpAppYN= "Y";

		String strBlngGrpCatgAppYN = "Y";

		String strBlngGrpStatus="";

		String strCategory = "";

		String strPractitionerId = "";
		String strPractitionerTypeInd = "";

		String ref_id = request.getParameter("financial_detail_ref_id");
		if (ref_id == null ) ref_id = "";

		String org_type_ind = request.getParameter("org_type_ind");
		if (org_type_ind == null ) org_type_ind = "";	

		String str_blng_grp_id = "",str_payer_emp_id_mand_yn="N", str_is_blng_grp_pkg_link_YN="N", str_valid_pkg_for_pat_avail_YN="N", str_valid_pkg_for_pat_bg_avail_YN="N";
		String str_short_desc = "";	
		String str_currency_code_for_bg = "",str_currency_desc_for_bg="";


		strPractitionerId = request.getParameter("practitioner_id");
		strPractitionerTypeInd = request.getParameter("practitioner_type_ind");

		if (strPractitionerId == null || strPractitionerId.equals("")) strPractitionerId = "";	
		if (strPractitionerTypeInd == null || strPractitionerTypeInd.equals("")) strPractitionerTypeInd = "";	

		boolean boolPatientFoundMP = false;
		//unused variable, commented on 09/06/05
		//boolean boolBillingGroupFound = false;
		boolean boolSecurity = false;	

		if (strLoggedUser == null) strLoggedUser="";
		if (strNewEpisodeYN==null) strNewEpisodeYN="";
		
		if (strEpisodeType == null) strEpisodeType ="";

			//The following parameters are used to retrieve the values from 
			//Added by Murugavel. on 11/Aug/2002
			// Health Card Expired Y 0r N logic also added 
			//	But the previous window not passing the parameter health_card_expired_yn
			
		String strHealthCardExpired_YN = request.getParameter("health_card_expired_yn");  
		String 	strBLInterfacedYN = "";
		strBedNo = request.getParameter("bed_no");  
		if (strBedNo == null) strBedNo ="";

		if (strBLInterfacedYN == null) strBLInterfacedYN ="N";

		if (strHealthCardExpired_YN == null) strHealthCardExpired_YN="N";

		String strAnnualIncome =  str_annual_income;   

		if (strAnnualIncome == null) strAnnualIncome = "";
		if (strAnnualIncome.equals("0.00")) strAnnualIncome = "";
		if (strAnnualIncome.equals("0")) strAnnualIncome = "";
		try
		{
			CurrencyFormat cf1 = new CurrencyFormat();
		
			if (!(strAnnualIncome.equals("")))
				strAnnualIncome = cf1.formatCurrency(strAnnualIncome,noofdecimal);
		}
		catch(Exception e)
		{
			System.out.println("Currency exception1 ::"+e);
		}

	//	String strFamilyAsset	= request.getParameter("family_asset");	
		String strFamilyAsset	= str_family_asset;	
		if (strFamilyAsset == null) strFamilyAsset="";
		if (strFamilyAsset.equals("0.00")) strFamilyAsset = "";
		if (strFamilyAsset.equals("0")) strFamilyAsset = "";

		try
		{
			CurrencyFormat cf1 = new CurrencyFormat();
		
			if (!(strFamilyAsset.equals("")))
				strFamilyAsset = cf1.formatCurrency(strFamilyAsset,noofdecimal);
		}
		catch(Exception e)
		{
			System.out.println("Currency exception2 ::"+e);
		}

	//	String strNoDependants = request.getParameter("no_of_dependants"); 
		String strNoDependants = str_no_of_dependants; 
			if (strNoDependants == null) strNoDependants = "";
			if (strNoDependants.equals("0")) strNoDependants = "";


	//	String strRespForPayment = request.getParameter("resp_for_payment"); 
		String strRespForPayment = str_resp_for_payment;	

		if (strRespForPayment == null) strRespForPayment = "";

		// Added on 12/09/2006
	//	String strPatRelnWithRespPerson = request.getParameter("pat_reln_with_resp_person"); 
		String strPatRelnWithRespPerson = str_pat_reln_with_resp_person; 
			if (strPatRelnWithRespPerson == null || strPatRelnWithRespPerson.equals("undefined")) strPatRelnWithRespPerson = "";	
			
		// Added on 09/11/2003 

	//	String strGlHolderName = request.getParameter("gl_holder_name"); 
		String strGlHolderName = str_gl_holder_name; 
			if (strGlHolderName == null || strGlHolderName.equals("undefined")) strGlHolderName = "";

	//	String strGlHolderReln = request.getParameter("pat_reln_with_gl_holder"); 
		String strGlHolderReln = str_pat_reln_with_gl_holder; 
			if (strGlHolderReln == null || strGlHolderReln.equals("undefined")) strGlHolderReln = "";	

//Added by Manivel on 05/06/07 
		String strRefSrcMainCode=ref_src_main_code;
			if(strRefSrcMainCode==null) strRefSrcMainCode="";

		String strRefSrcSubCode=ref_src_sub_code;
			if(strRefSrcSubCode==null) strRefSrcSubCode="";

		String strRefSrcMainDesc=ref_src_main_desc;
			if(strRefSrcMainDesc==null) strRefSrcMainDesc="";

		String strRefSrcSubDesc=ref_src_sub_desc;
			if(strRefSrcSubDesc==null) strRefSrcSubDesc="";
/******* Over *****/

		// Added End

		//Added on 23/10/2004
		String strCreditStartDate = request.getParameter("cred_start_date"); 
			if (strCreditStartDate == null) strCreditStartDate = "";	

		//Added End


	//	String strCreditDocReqd_YN1 = request.getParameter("credit_doc_reqd_yn1");
		String strCreditDocReqd_YN1 = str_credit_doc_reqd_yn;
			if (strCreditDocReqd_YN1 == null) strCreditDocReqd_YN1 = "";

			
	//	String strCreditDocReqd_YN2 = request.getParameter("credit_doc_reqd_yn2");
		String strCreditDocReqd_YN2 = str_non_ins_credit_doc_reqd_yn;
			if ( strCreditDocReqd_YN2 == null ) strCreditDocReqd_YN2 = "";
		
		String patient_id = request.getParameter("patient_id");
		if(patient_id == null) patient_id = "";

		/** 
			The following variables are for the billing group or any items
			which are imported from the external interface
		**/
			
		String strExtBillingGroup = "";
		String strExtSettlType = "";
		
		String strRepositoryYN =	request.getParameter("bl_data_from_repos_yn");
		String strDataSourceId =  request.getParameter("data_source_id");
		String strItemsDisabled = request.getParameter("items_disabled");
		String bl_oper_yn = request.getParameter("bl_oper_yn");

		String strBillingOverride = "Y";

		String strBedClass = "";
		/************** changed the below code block location for package billing*********start***************/	

		//unused variable, commented on 09/06/05
		//String strBedType ="";
		/************** added for package billing*********start***************/		
		String strBedType ="";

		if(rs3!=null) rs3.close();
		if(pstmt!=null) pstmt.close();

/* Commented and moved the value fetch to the top
		try
		{
			pstmt = con.prepareStatement("SELECT bl_package_enabled_yn(?)  package_enabled_yn from dual");
			pstmt.setString(1,facility_id);
			rs3 = pstmt.executeQuery();
			if( rs3 != null  && rs3.next()) 
			{
					package_enabled_yn = rs3.getString("package_enabled_yn");		
					
					if(package_enabled_yn==null || !package_enabled_yn.equals("Y")) package_enabled_yn="N";						
			}
			if (rs3 != null) rs3.close();
			pstmt.close();		
		}
		catch(Exception e)
		{
			System.out.println("Exception  while geting package_enabled_yn from bl_parameters:"+e);
			e.printStackTrace();
		}
*/		
		if(package_enabled_yn.equals("Y"))
				 strBedType = request.getParameter("bed_type")==null?"":request.getParameter("bed_type");       
				 //System.out.println("strBedType="+strBedType);
		/************** added for package billing*********end***************/
		String strAdmissionType = "";
		String strNursingUnit ="";
		//String strNursingUnitType ="";
		//String strDepReqYN="";
		//String strAddlDepReqYN="";

		String strCitizenYn = "N";
		String nationalityyn = "";
		String care_locn_type_ind="N";
		String alt_id1_exp_date = "";
		
		if(!patient_id.equals(""))
		{
			try
			{
				String sqlCiti = "select a.citizen_yn,to_char(a.alt_id1_exp_date, 'dd/mm/yyyy') alt_id1_exp_date, b.gl_holder_name gl_holder_name, b.pat_reln_with_gl_holder pat_reln_with_gl_holder from mp_patient a, bl_patient_fin_dtls b where a.patient_id ='"+patient_id+"' and a.patient_id=b.patient_id";
				pstmt = con.prepareStatement(sqlCiti);
				rs2 = pstmt.executeQuery() ;
				if( rs2 != null ) 
				{	
					while( rs2.next() )
					{  
						strCitizenYn = rs2.getString("citizen_yn");
						alt_id1_exp_date = rs2.getString("alt_id1_exp_date");
						gl_holder_name = rs2.getString("gl_holder_name");
						gl_rel = rs2.getString("pat_reln_with_gl_holder");
						boolPatientFoundMP = true;
					}
				}
				if (rs2 != null) rs2.close();
				pstmt.close();	
			}
			catch(Exception e)
			{
				System.out.println("Exception in sqlCiti:"+e);
			}
			if(strCitizenYn == null) strCitizenYn="N";
			if (alt_id1_exp_date == null) alt_id1_exp_date = "";
			if ( gl_holder_name == null ) gl_holder_name = "";
			if ( gl_rel == null ) gl_rel = "";
/* commented and added with the above query for PE Changes
			try
			{
				String sql1 = "select gl_holder_name, pat_reln_with_gl_holder from bl_patient_fin_dtls where patient_id = '"+patient_id+"'";
				pstmt = con.prepareStatement(sql1);
				rs0 = pstmt.executeQuery() ;
				if( rs0 != null ) 
				{
					while( rs0.next() )
					{  
						gl_holder_name = rs0.getString("gl_holder_name");
						gl_rel = rs0.getString("pat_reln_with_gl_holder");				
					}
				}
				if(rs0!=null) rs0.close();
				pstmt.close();
			}
			catch(Exception e)
			{
				System.out.println("Exception in sql1:"+e);
			}		
			if ( gl_holder_name == null ) gl_holder_name = "";
			if ( gl_rel == null ) gl_rel = "";
*/
		}

		boolean boolChangeBillQry = false;
		/******* End of the External Interface table data **************/

		if (strRepositoryYN == null ) 
		{
			strRepositoryYN = "";
		}
		if (strDataSourceId == null )
		{
			strDataSourceId = "";
		}
		if (strItemsDisabled ==null)
		{
			strItemsDisabled = "";		
		}

		strBedClass = request.getParameter("bed_class_code");      
		strAdmissionType = request.getParameter("visit_adm_type");     
		strNursingUnit = request.getParameter("nursing_unit_code");        

/* Commented for PE Changes and Added in the Main.jsp
		try
		{
			String sql2 = "select nvl(third_party_gl_in_use_yn,'N') third_party_gl_in_use_yn, nvl(third_party_gl_mandatory_yn,'N') third_party_gl_mandatory_yn, NVL(capture_employer_id_yn,'N') capture_employer_id_yn from bl_parameters where operating_facility_id = '"+facility_id +"'";
		
			pstmt = con.prepareStatement(sql2);
			rs3 = pstmt.executeQuery() ;
			if( rs3 != null ) 
			{
				while( rs3.next() )
				{  
					third_party_gl_in_use_yn = rs3.getString("third_party_gl_in_use_yn");
					third_party_gl_mandatory_yn = rs3.getString("third_party_gl_mandatory_yn");
					capture_employer_id_yn = rs3.getString("capture_employer_id_yn");
				}
			}
			if (rs3 != null) rs3.close();
			pstmt.close();		
		}
		catch(Exception e)
		{
			System.out.println("Exception in sql2:"+e);
		}
*/
		third_party_gl_in_use_yn = request.getParameter("third_party_gl_in_use_yn");
		if(third_party_gl_in_use_yn == null) third_party_gl_in_use_yn="N";

		third_party_gl_mandatory_yn = request.getParameter("third_party_gl_mandatory_yn");
		if(third_party_gl_mandatory_yn == null) third_party_gl_mandatory_yn="N";

		capture_employer_id_yn = request.getParameter("capture_employer_id_yn");
		if(capture_employer_id_yn == null) capture_employer_id_yn="N";

		if (strBedClass == null) strBedClass = "";
		if (strAdmissionType == null) strAdmissionType = "";
		if (strNursingUnit == null) strNursingUnit = "";

		if (strRepositoryYN.equals("Y"))
		{
	//		strExtBillingGroup =  request.getParameter("billing_group");
			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{
				strExtBillingGroup =  billing_group;
			}
			else
			{
				strExtBillingGroup=billing_group;
			}
		//		strExtSettlType = request.getParameter("cash_set_type1");
				strExtSettlType = str_slmt_type_code;

			try
			{
				StringTokenizer strTokenizer = new StringTokenizer(strItemsDisabled,"|");
				String strTotData = "";
				
				int intIdx = 0;
				String strColumn="";
				String strOverride ="N";
				while(strTokenizer.hasMoreElements())
				{	
					strTotData = strTokenizer.nextToken();
						
					intIdx = strTotData.indexOf("-");
					strColumn = strTotData.substring(0,intIdx);
					strOverride = strTotData.substring(intIdx+1);

					if (strColumn.equals("billing_group")) 
					{
						if (strOverride.equals("N"))
						{
							strBillingOverride = "N";
						}
						else 
						{
							strBillingOverride = "Y";
						}
					}
				}
			}
			catch(Exception excep)
			{
				out.println("Exception 3::"+excep);
			}
		}
		if (strExtBillingGroup == null) 
		{
			strExtBillingGroup = "";
			
		}
		if (strExtSettlType == null)
		{
			strExtSettlType="";
		}
/* Commented and moved up for PE Changes
		//Added for Health Card Expiry date check	
		String alt_id1_exp_date = "";
		try
		{
			pstmt = con.prepareStatement("select to_char(alt_id1_exp_date, 'dd/mm/yyyy') alt_id1_exp_date from mp_patient where patient_id = ?");
			pstmt.setString(1, patient_id);
			rs = pstmt.executeQuery();
			if (rs.next())
			{
				alt_id1_exp_date = rs.getString("alt_id1_exp_date");
				if (alt_id1_exp_date == null) alt_id1_exp_date = "";
				boolPatientFoundMP = true;
			}
			if (rs != null) rs.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in alt_id1_exp_date:"+e);
		}
*/
		// End of Addition

		// If the strRepositoryYN = 'Y' then get the items to be disabled
		
		String strDfltBillingGroup = "";
		//String strDfltBillingGroupDesc = "";
		//String query_string=request.getQueryString();
		//String strDefHealthCard_YN = "N";        
		String strArrayHealthCard_YN="";
		String strArrayBillingApp_YN="";	
	//	String user_id = request.getParameter("user_id");
		String user_id = str_user_id;
		String strBillingQuery ="";
		String strblnggrp ="0";
		String strModuleId = "";
		String strFunctionId = "";
		String strChngToVisit = request.getParameter("Chg_to_Visitor_Grp");
		String strSpecialSchemeBlngGrp="";		// 
		String strSpecialSchemeBlngGrpDesc="";		
		String priority="N";
		String strBillGrpId = "";

		if  (strChngToVisit  == null )
		{
			strChngToVisit = "N";
		}

		if(user_id==null) user_id = "";

		
		package_flag = request.getParameter("package_flag");
		if(package_flag==null) package_flag = "N";
		ins_auth_flag = request.getParameter("ins_auth_flag");
		if(ins_auth_flag==null) ins_auth_flag = "N";
		upd_pat_flag=request.getParameter("upd_pat_flag");
		if(upd_pat_flag==null) upd_pat_flag="N";
		String episode = request.getParameter("episode");
		if(episode==null) episode = "";
		String record = request.getParameter("record");
		if(record==null) record = "";

		pkg_bill_type = request.getParameter("pkg_bill_type");
		if(pkg_bill_type==null) pkg_bill_type="";
		pkg_bill_no = request.getParameter("pkg_bill_no");
		if(pkg_bill_no==null) pkg_bill_no="";

		clinic_code = request.getParameter("clinic_code");
		if(clinic_code==null) clinic_code="";
		visit_type_code = request.getParameter("visit_type_code");
		if(visit_type_code==null) visit_type_code="";
		
		display = request.getParameter("display");
		
		if(display==null||display.equals("null")) display="N";

		if(display.equals("Y"))
		{
			display_mode="disabled";
		}

		show_hide_blng_class=request.getParameter("show_hide_blng_class");

		if(show_hide_blng_class==null) show_hide_blng_class="SHOW";

		strModuleId = request.getParameter("calling_module_id");	
	
		strFunctionId = request.getParameter("calling_function_id");

		if (strModuleId == null) strModuleId= "";
		if (strFunctionId == null) strFunctionId = "";

		strdfltbgyn = request.getParameter("dfltbgyn");
		if ( strdfltbgyn == null) strdfltbgyn = "N";

		srtencdfltbgyn = request.getParameter("encdfltbgyn");
		if ( srtencdfltbgyn == null) srtencdfltbgyn = "N";

		strprovselfrmprevencyn = request.getParameter("provselfrmprevencyn");
		if ( strprovselfrmprevencyn == null) strprovselfrmprevencyn = "N";
/*
		try
		{
			String sql0 = "select nvl(dflt_pat_bg_for_encntr_regn_yn,'N') bg,nvl(DFLT_LAST_ENCTR_FIN_DTLS_YN,'N') last_enc_bg,nvl(PROV_TO_SEL_FROM_PRV_ENCTRS_YN,'N') prov_sel_frm_prev_enc from bl_mp_param ";
			pstmt = con.prepareStatement(sql0);
			rs2 = pstmt.executeQuery() ;
				if( rs2 != null ) 
				{
					while( rs2.next() )
					{  
						strdfltbgyn = rs2.getString("bg");
						srtencdfltbgyn=rs2.getString("last_enc_bg");
						strprovselfrmprevencyn=rs2.getString("prov_sel_frm_prev_enc");
					}
				}
				if (rs2 != null) rs2.close();
				pstmt.close();

		}
		catch(Exception e)
		{
			System.out.println("Exception in sqlCiti:"+e);
		}			
*/
		if(srtencdfltbgyn.equals("Y") && strdfltbgyn.equals("N"))
		{
			strdfltbgyn="Y";
		}

		bl_future_admn_YN= request.getParameter("bl_future_admn_YN");
		if(bl_future_admn_YN==null) bl_future_admn_YN="N";

		if(bl_future_admn_YN.equals("Y") && ((strModuleId.equals("IP") || strModuleId.equals("DC")) && strFunctionId.equals("ADMISSION")))
		{
//			System.out.println("Inside the Future Admn Check");
			strdfltbgyn="Y";
		}
		// Added on 16/08/2005

		nationalityyn = request.getParameter("nationality_yn");

		if (nationalityyn == null) nationalityyn = "";	

		if (strModuleId.equals("MP"))
		{
			strCitizenYn = nationalityyn;
			strdfltbgyn = "Y";
		}


		// Added New on 25/12/2003

		if ( strdfltbgyn.equals("N") && (!(strModuleId.equals("MP")) ) )
			{
			strGlHolderName = "";
			strNoDependants = "";
			strGlHolderReln = "";
			}

		// End New on 25/12/2003

		try
		{			
	//		mbilling_group=request.getParameter("billing_group");
			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{
				mbilling_group=billing_group;
			}
			else
			{
				mbilling_group=billing_group;
			}

			priority=request.getParameter("priority");
			if((priority==null) || (priority.equals("null")))
				priority ="N";
			care_locn_type_ind = 	request.getParameter("care_locn_type_ind");

			if((care_locn_type_ind==null) || (care_locn_type_ind.equals("null")))
				care_locn_type_ind ="N";
	//		mbilling_class=request.getParameter("billing_class");
			mbilling_class=str_blng_class;
	//		memployer_code=request.getParameter("employer_code");
			memployer_code=str_emp_code;
			if (mbilling_group == null)
			{
				mbilling_group="";
			}
			if (mbilling_class == null)
			{
				mbilling_class="";
			}

			if (memployer_code == null)
			{
				memployer_code="";
			}
			
			String getDfltEncBg = (String) session.getAttribute("blGetDfltEncBg");
			String getDfltEncCC = (String) session.getAttribute("blGetDfltEncCC");
			String comClinincCode = clinic_code;
			if("".equals(comClinincCode)){
				comClinincCode = strNursingUnit;
			}
			if(getDfltEncCC == null)	getDfltEncCC = "";
			
			if("DC".equals(callingModule)){
				care_locn_type_ind = "D";
			}
			
			try
			{	
				if("Y".equals(getDfltEncBg) || comClinincCode.equals(getDfltEncCC) == false){
					String query="select BL_eBLCOMMON.BL_GET_ENCNTR_DEFAULT_BG(?,?,?,?,?) from dual";		
					pstmt = con.prepareStatement(query);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,care_locn_type_ind);
					pstmt.setString(3,comClinincCode);
					pstmt.setString(4,priority);
					pstmt.setString(5,strCitizenYn);
					rset = pstmt.executeQuery();

					if(rset!=null && rset.next())
					 {
						strBillGrpId = rset.getString(1);  
					 }
					
					if ( strBillGrpId == null ){
						strBillGrpId = "";
					}
					else{
						boolChangeBillQry = true;
						billing_group = strBillGrpId;
						mbilling_group = strBillGrpId;
						/*HashMap bl_data=(HashMap)session.getAttribute("financial_details");
						
						bl_data.put("blng_grp",billing_group);						
						
						session.setAttribute("financial_details",bl_data);			*/								
					}
					if(rset !=null) rset.close();
					pstmt.close();	
					
					session.setAttribute("blGetDfltEncBg", "Y");
					session.setAttribute("blGetDfltEncCC", comClinincCode);
				}
												
			}
			catch(Exception e)
			{
				System.out.println("Exception happened in BL_GET_ENCNTR_DEFAULT_BG :"+e);
			}
		}
		catch(Exception exParm)
		{
			System.out.println("Exception with Modify Mode Block:"+exParm);
		}

		try
		{
			if (!(strModuleId.equalsIgnoreCase("MP"))	)
			{
				String strBLIntQuery = "";
			
				if (strModuleId.equalsIgnoreCase("IP") || strModuleId.equalsIgnoreCase("DC") )
				{
					strBLIntQuery = "select nvl(bl_interfaced_yn,'N') from ip_param where facility_id =?";
				}
				else if ( strModuleId.equalsIgnoreCase("OP") )
				{
					strBLIntQuery = "select nvl(bl_interfaced_yn,'N') from op_param where operating_facility_id =?";
				}
				else if ( strModuleId.equalsIgnoreCase("AE") )
				{
					strBLIntQuery = "select nvl(billing_interfaced_yn,'N') from ae_param where operating_facility_id =?";
				}

				pstmt = con.prepareStatement(strBLIntQuery );
				pstmt.setString(1, facility_id);
				rs = pstmt.executeQuery();
			
				if (rs.next())
				{
					strBLInterfacedYN = rs.getString(1);
				}
				else
				{
					strBLInterfacedYN = "N";
				}
				if (rs != null) rs.close();
				pstmt.close();
			}
			
		}
		catch(Exception exBl)
		{
			System.out.println("Exception in MP check logic:"+exBl);
		}
		
		if ((strModuleId.equals("OP"))|| (strModuleId.equals("AE")))
		{
			try
			{
				pstmt = con.prepareStatement("select bill_type_code , blng_class_code from bl_op_clinic where "+" facility_id =? and clinic_code =? and rownum=1");
				pstmt.setString(1, facility_id);
				pstmt.setString(2, clinic_code);

				rs = pstmt.executeQuery();
				if (rs.next())
				{
					strBlngClass = rs.getString(1);
					strBillType = rs.getString(2);
				}
				if (rs != null) rs.close();
				pstmt.close();
				
				if (strBlngClass == null) strBlngClass="";
				if (strBillType == null) strBillType="";
			}
			catch(Exception e)
			{
				System.out.println("Exception in OP AE check logic:"+e);
			}
		}
	// HealthSchemes
		if (!(strModuleId.equals("MP")))
		{
			try
			{
				CallableStatement call = con.prepareCall("{ call blcommon.GET_HEALTH_SCHEME_DTLS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");						
				call.setString(1,patient_id);
				call.setString(2,facility_id);
				call.setString(3,locale);
				call.registerOutParameter(4,java.sql.Types.VARCHAR); // _hcard_scheme_id out varchar2,
				call.registerOutParameter(5,java.sql.Types.VARCHAR); // _hcare_scheme_id out varchar2,
				call.registerOutParameter(6,java.sql.Types.VARCHAR); // _hcard_scheme_id out varchar2,
				call.registerOutParameter(7,java.sql.Types.VARCHAR); // _hcare_scheme_id out varchar2,
				call.registerOutParameter(8,java.sql.Types.VARCHAR); // p_hcard_expired_yn out varchar2,
				call.registerOutParameter(9,java.sql.Types.VARCHAR); // p_hcare_expired_yn out varchar2,
				call.registerOutParameter(10,java.sql.Types.VARCHAR); // p_dflt_blng_grp_for_hc out varchar2,
				call.registerOutParameter(11,java.sql.Types.VARCHAR); // p_dflt_blng_grp_for_hc_desc out varchar2,
				call.registerOutParameter(12,java.sql.Types.VARCHAR); // p_previous_blng_grp out varchar2,
				call.registerOutParameter(13,java.sql.Types.VARCHAR); // p_previous_blng_grp_desc out varchar2, 
				call.registerOutParameter(14,java.sql.Types.VARCHAR); // p_hcard_prerequisite_yn out varchar2,
				call.registerOutParameter(15,java.sql.Types.VARCHAR); // error text			call.execute();
				call.registerOutParameter(16,java.sql.Types.VARCHAR); // error text			call.execute();
				call.registerOutParameter(17,java.sql.Types.VARCHAR); // error text			call.execute();
				call.registerOutParameter(18,java.sql.Types.VARCHAR); // error text			call.execute();
				call.registerOutParameter(19,java.sql.Types.VARCHAR); // error text			call.execute();

				call.registerOutParameter(20,java.sql.Types.VARCHAR); // error text			call.execute();

				call.execute();

				strPatBlngGrp = call.getString(4);		// _hcard_scheme_id out varchar2,            
				strMessageDesc=call.getString(5);		// _hcare_scheme_id out varchar2,            
				strHcardApplicableYN =call.getString(6);		// _hcard applicable out varchar2,            
				strHcareApplicableYN =call.getString(7);		// _hcard applicable out varchar2,            
				strHcardSchemeId=call.getString(8);		// _hcard_scheme_id out varchar2,            
				strHcareSchemeId=call.getString(9);		// _hcare_scheme_id out varchar2,            
				strHcardExpiredYN=call.getString(10);	// p_hcard_expired_yn out varchar2,          
				strHcareExpiredYN=call.getString(11);	// p_hcare_expired_yn out varchar2,          
				strDfltBillingGroup = call.getString(12);			// p_dflt_blng_grp_for_hc out varchar2,     
				//strDfltBillingGroupDesc = call.getString(12);		// p_dflt_blng_grp_for_hc_desc out varchar2,
				strPreviousBlngGrp = call.getString(14);				// p_previous_blng_grp out varchar2,         
				strPreviousBlngGrpDesc= call.getString(15);			// p_previous_blng_grp_desc out varchar2,    
				strHcardPrerequisite_yn= call.getString(16)	;		// p_hcard_prerequisite_yn out varchar2,     
				strSpecialSchemeBlngGrp=call.getString(17);		// _hcard_scheme_id out varchar2,            
				strSpecialSchemeBlngGrpDesc=call.getString(18);		// _hcare_scheme_id out varchar2,            
				strSchemeType = 	call.getString(19);					 // error text			call.execute();      
				strErrorText = 	call.getString(20);					 // error text			call.execute();      
				
				if ((strHcardSchemeId == null) || ( strHcardSchemeId.equals("")) || ( strHcardSchemeId.equalsIgnoreCase("null")) )
				{ 
					strHcardSchemeId="";
				}

				if ((strHcareSchemeId == null) || ( strHcareSchemeId.equals("")) || ( strHcareSchemeId.equalsIgnoreCase("null")) )
				{ 
					strHcareSchemeId="";
				}

				if ((strHcardExpiredYN == null) || ( strHcardExpiredYN.equals("")) || ( strHcardExpiredYN.equalsIgnoreCase("null")) )
				{ 
					strHcardExpiredYN="";
				}

				if ((strHcareExpiredYN == null) || ( strHcareExpiredYN.equals("")) || ( strHcareExpiredYN.equalsIgnoreCase("null")) )
				{ 
					strHcareExpiredYN="";
				}

				if ((strDfltBillingGroup == null) || ( strDfltBillingGroup.equals("")) || ( strDfltBillingGroup.equalsIgnoreCase("null")) )
				{ 
					//unused variable, commented on 09/06/05
					//strDfltBillingGroupDesc="";
				}

				if ((strPreviousBlngGrp  == null) || ( strPreviousBlngGrp.equals("")) || ( strPreviousBlngGrp.equalsIgnoreCase("null")) )
				{ 
					strPreviousBlngGrp ="";
					strPreviousBlngGrpDesc="";

				}

				if ((strHcardPrerequisite_yn == null) || ( strHcardPrerequisite_yn.equals("")) || ( strHcardPrerequisite_yn.equalsIgnoreCase("null")) )
				{ 
					strHcardPrerequisite_yn  ="";
				}

				if ((strHcardApplicableYN  == null) || ( strHcardApplicableYN.equals("")) || ( strHcardApplicableYN.equalsIgnoreCase("null")) )
				{ 
					strHcardApplicableYN ="";
				}

				if ((strHcareApplicableYN  == null) || ( strHcareApplicableYN.equals("")) || ( strHcareApplicableYN.equalsIgnoreCase("null")) )
				{ 
					strHcareApplicableYN ="";
				}

				if ((strSpecialSchemeBlngGrp== null) || ( strSpecialSchemeBlngGrp.equals("")) || ( strSpecialSchemeBlngGrp.equalsIgnoreCase("null")) )
				{ 
					strSpecialSchemeBlngGrp ="";
					strSpecialSchemeBlngGrpDesc="";
				}
				if ((strMessageDesc== null) || ( strMessageDesc.equals("")) || ( strMessageDesc.equalsIgnoreCase("null")) )
				{ 
					strMessageDesc ="";
				}

				call.close();
			}
			catch(Exception e)
			{
				out.println(" Err: HealthScheme Dtls: "+e);
			}
		}	// End of HealthSchemes details if

		if (strModuleId.equals("OP")||strModuleId.equals("AE"))
		{
			try
			{
				pstmt = con.prepareStatement("select bill_type_code , blng_class_code from bl_op_clinic where "+
							" facility_id =? and clinic_code =? and rownum=1");
				pstmt.setString(1, facility_id);
				pstmt.setString(2, clinic_code);

				rs = pstmt.executeQuery();
				if (rs.next())
				{
					strBlngClass = rs.getString(1);
					strBillType = rs.getString(2);
				}
				if (rs != null) rs.close();
				pstmt.close();
				
				if (strBlngClass == null) strBlngClass="";
				if (strBillType == null) strBillType="";
				
			}
			catch(Exception e)
			{
				System.out.println("Exception in billing class & bill type query exec:"+e);
			}
		}	// End of OP Checking

		if (strModuleId.equals("IP") || strModuleId.equals("DC"))
		{
			try
			{
				CallableStatement call = con.prepareCall("{ call bl_ip_interface.proc_get_ip_billing_details(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");						
				call.setString(1,facility_id);
				call.setString(2,strNursingUnit);
				call.setString(3,strBedClass);
				call.setString(4,strAdmissionType);
				call.setString(5,strBedNo);
				call.registerOutParameter(6,java.sql.Types.VARCHAR); // Nursing Unit type
				call.registerOutParameter(7,java.sql.Types.VARCHAR); // billing class
				call.registerOutParameter(8,java.sql.Types.VARCHAR); // bill type
				call.registerOutParameter(9,java.sql.Types.VARCHAR); // Dep. Reqd
				call.registerOutParameter(10,java.sql.Types.VARCHAR); // Addl. Reqd
				call.registerOutParameter(11,java.sql.Types.VARCHAR);  //
				call.registerOutParameter(12,java.sql.Types.VARCHAR);	
				call.registerOutParameter(13,java.sql.Types.VARCHAR);
				call.registerOutParameter(14,java.sql.Types.VARCHAR);
				call.registerOutParameter(15,java.sql.Types.VARCHAR);
				call.registerOutParameter(16,java.sql.Types.VARCHAR);
				call.execute();
				 
				//unused variable, commented on 09/06/05 
				//strBedType = call.getString(6);
				//strNursingUnitType = call.getString(7);
				strBlngClass = call.getString(8);
				strBillType = call.getString(9);
				strIPBillingService = call.getString(10);
				//strDepReqYN = call.getString(11);
				//strAddlDepReqYN = call.getString(12);
				strDeptCode = call.getString(13);
				strMessageId = call.getString(14);
				strSysMessageId = call.getString(15);
				strErrorText = call.getString(16);

				if ((strMessageId == null) || (strMessageId.equals("null")))
				{
					strMessageId ="";
				}
				if ( (strDeptCode == null) ||  (strDeptCode.equalsIgnoreCase("null")) )
				{
					strDeptCode = "";
				}

				if ( (strBlngClass == null) ||  (strBlngClass.equalsIgnoreCase("null")) )
				{
					strBlngClass = "";
				}
				if ( (strIPBillingService== null) ||  (strIPBillingService.equalsIgnoreCase("null")) )
				{
					strIPBillingService = "";
				}
				if ( (strBillType == null) ||  (strBillType.equalsIgnoreCase("null")) )
				{
					strBillType  = "";
				}

				call.close();
			}
			catch(Exception e)
			{
				out.println("Error "+e);
			}

		}	// End of IP module checking
System.err.println("KKKK billing_group3:"+billing_group);
		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			sql="select settlement_ind, adm_rec_flag, credit_doc_ref_reqd_yn  from bl_blng_grp where blng_grp_id = '"+billing_group+"' ";
		}
		else
		{
			sql="select settlement_ind, adm_rec_flag, credit_doc_ref_reqd_yn  from bl_blng_grp where blng_grp_id = '"+billing_group+"' ";
		}
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  
				str_slmt_ind = rs.getString("settlement_ind");
				str_adm_rec_flag = rs.getString("adm_rec_flag");
				credit_doc_ref_reqd_yn = rs.getString("credit_doc_ref_reqd_yn");
			}
		}
		if (rs != null) rs.close();
		pstmt.close();
		
		if(str_slmt_ind==null) str_slmt_ind="";
		if(str_adm_rec_flag==null) str_adm_rec_flag="";
		if(credit_doc_ref_reqd_yn == null) credit_doc_ref_reqd_yn="";

		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
	//		mbilling_group=request.getParameter("billing_group");
			mbilling_group=billing_group;
			priority=request.getParameter("priority");
			if((priority==null) || (priority.equals("null")))
				priority ="N";
			care_locn_type_ind = 	request.getParameter("care_locn_type_ind");
			if((care_locn_type_ind==null) || (care_locn_type_ind.equals("null")))
				care_locn_type_ind ="N";
	//		mbilling_class=request.getParameter("billing_class");
			mbilling_class=str_blng_class;
	//		memployer_code=request.getParameter("employer_code");
			memployer_code=str_emp_code;

			if (mbilling_group == null)
			{
				mbilling_group="";
			}
			if (mbilling_class == null)
			{
				mbilling_class="";
			}

			if (memployer_code == null)
			{
				memployer_code="";
			}
		}
		
		// This modification is done on :09/Sep/2002 for the Gap Identification 
		// the Requirements are Billing Groups filter critrea.
		// Fixing up of Bug for the Health Card Applicable (Enabling)

		//	if (strModuleId.equals("OP")||strModuleId.equals("AE"))  // Episode Type ENH
			
		if (strModuleId.equals("OP")) 
		{
			strEpisodeType = "O";
		}
		else if (strModuleId.equals("AE")) 
		{
			strEpisodeType = "E";
		}
		else if (strModuleId.equals("IP")) 
		{
			strEpisodeType = "I";
		}
		else if (strModuleId.equals("DC")) 
		{
			strEpisodeType = "D";
		}
		else if(strModuleId.equals("MP"))
		{
			strEpisodeType = "R";
		}

		try{
			
					String vst_adm_date_time="";
										
					if(strEpisodeType.equals("O")){
						vst_adm_date_time=request.getParameter("vst_regn_date_time"); 
					}else if(strEpisodeType.equals("I")||strEpisodeType.equals("D")){
						vst_adm_date_time=request.getParameter("encounter_date_time"); 
					}else if(strEpisodeType.equals("E")){
						vst_adm_date_time=sys_date;
					}else{
						vst_adm_date_time=request.getParameter("encounter_date_time");
					}
					
					System.err.println("facility_id/patient_id/strEpisodeType/vst_adm_date_time ::::"+facility_id+"/"+patient_id+"/"+strEpisodeType+"/"+vst_adm_date_time);
					pstmt = con.prepareStatement("SELECT blpackage.get_open_pkg_exists_yn(?,?,?,to_date(?,'dd/mm/yyyy HH24:MI:SS'))  open_pkg_exists_yn from dual");
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,strEpisodeType);
					pstmt.setString(4,vst_adm_date_time);
					rs = pstmt.executeQuery();
					
					
					if( rs!= null && rs.next()) 
					 {
					  open_pkg_exists_yn = rs.getString(1);
					  if(open_pkg_exists_yn==null || !open_pkg_exists_yn.equals("Y")) open_pkg_exists_yn="N";						
					 }
					
					System.err.println("open_pkg_exists_yn "+open_pkg_exists_yn);
					  if (rs != null) rs.close();
					  pstmt.close();
				}
				catch(Exception e)
				{
					System.out.println("Exception in open subscribed package function"+e);
					e.printStackTrace();
				}
		if (strModuleId.equals("MP") && (boolPatientFoundMP == true))	
		{
			strBillingQuery = "SELECT BLNG_GRP_ID,short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SHORT_DESC, "+
							"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
								" REF_YN , status , category "+
								" FROM BL_BLNG_GRP_LANG_VW "+
								" WHERE "+
								" ( NVL(category,'UNRESTRICTED') IN ( DECODE('"+strCitizenYn+"','Y','NATIONALS','N','OTHERS','UNRESTRICTED'), 'UNRESTRICTED')) AND "+
								"  (((NVL(REF_YN,'N')='Y' AND NVL(HCARE_ONLY_YN,'N') = 'N' AND "+
								" nvl(status,'X' )!='S') "+
//								" OR BLNG_GRP_ID = '" + mbilling_group + "' )) and language_id='"+locale+"' order by 2";
								" AND BLNG_GRP_ID = '" + mbilling_group + "' )) and language_id='"+locale+"' order by 2";

			strblnggrp = "1";
		}

		if (strModuleId.equals("MP") && (boolPatientFoundMP == false))
		{
			strBillingQuery =" SELECT BLNG_GRP_ID,short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SHORT_DESC, "+
							"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
							" REF_YN , status , category FROM BL_BLNG_GRP_LANG_VW "+
							" WHERE "+
							" ( NVL(category,'UNRESTRICTED') IN ( DECODE('"+strCitizenYn+"','Y','NATIONALS','N','OTHERS','UNRESTRICTED'), 'UNRESTRICTED')) AND "+	
							" (((NVL(REF_YN,'N')='Y' AND NVL(REF_VALID_FOR_REGN_YN,'N')='Y' AND "+
							" nvl(status,'X' )!='S')  AND NVL(HCARE_ONLY_YN,'N') = 'N'  "+
//							" OR BLNG_GRP_ID = '" + mbilling_group + "' )) and language_id='"+locale+"' order by 2";	
							" AND BLNG_GRP_ID = '" + mbilling_group + "' )) and language_id='"+locale+"' order by 2";	

			strblnggrp = "2";
		}

		//if (strModuleId.equals("OP")||strModuleId.equals("AE"))

		if (strModuleId.equals("OP"))
		{
			strBillingQuery = "SELECT BLNG_GRP_ID,short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SHORT_DESC, "+						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
								" OP_YN , status , category "+
								" FROM BL_BLNG_GRP_LANG_VW "+
								" WHERE "+
								" ((( NVL(category,'UNRESTRICTED') IN ( DECODE('"+strCitizenYn+"','Y','NATIONALS','OTHERS'), 'UNRESTRICTED')) AND "+
								" ((NVL(OP_YN,'N')='Y' AND "+
								" NVL(STATUS,'X' )!='S') AND ( NVL(HEALTH_CARD_APPL_YN,'N')='N' AND NVL(HCARE_ONLY_YN,'N')='N')) "+
								" AND ( BLNG_GRP_ID = '" + mbilling_group + "' AND NVL('"+ strdfltbgyn +"','N') = 'Y' )))  and language_id='"+locale+"' order by 2";
//								" OR ( BLNG_GRP_ID = '" + mbilling_group + "' AND NVL('"+ strdfltbgyn +"','N') = 'Y' )))  and language_id='"+locale+"' order by 2";
//As per the new requirement the OR condtion changed to AND condition by Manivel on 07/05/07
			strblnggrp = "3";
		}
		
		//if (strModuleId.equals("IP") || strModuleId.equals("DC"))

		if (strModuleId.equals("IP"))
		{
			strBillingQuery = "SELECT BLNG_GRP_ID,short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SHORT_DESC, "+						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
							" IP_YN , status , category FROM BL_BLNG_GRP_LANG_VW "+
								" WHERE " + 
								" ((( NVL(category,'UNRESTRICTED') IN ( DECODE('"+strCitizenYn+"','Y','NATIONALS','OTHERS'), 'UNRESTRICTED')) AND "+
									" ((NVL(IP_YN,'N')='Y' AND "+
								" NVL(STATUS,'X' )!='S') AND ( NVL(HEALTH_CARD_APPL_YN,'N')='N' AND NVL(HCARE_ONLY_YN,'N')='N'))  "+
//								" OR (BLNG_GRP_ID = '" + mbilling_group + "' AND NVL('"+ strdfltbgyn +"','N') = 'Y' ) )) and language_id='"+locale+"' order by 2";
								" AND (BLNG_GRP_ID = '" + mbilling_group + "' AND NVL('"+ strdfltbgyn +"','N') = 'Y' ) )) and language_id='"+locale+"' order by 2";
			strblnggrp = "4";
		}

		if (strBillingQuery.equals("")) 
		{
			strBillingQuery = "SELECT BLNG_GRP_ID,short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SHORT_DESC, "+
							"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
							" REF_YN , status , category  FROM BL_BLNG_GRP_LANG_VW WHERE "+
								" ((( NVL(category,'UNRESTRICTED') IN ( DECODE('"+strCitizenYn+"','Y','NATIONALS','OTHERS'), 'UNRESTRICTED')) AND "+
								" ( nvl(status,'X' )!='S'    AND ( NVL(HEALTH_CARD_APPL_YN,'N')= 'N' AND NVL(HCARE_ONLY_YN,'N')='N')  "+ 
								" OR BLNG_GRP_ID = '" + mbilling_group + "' ))) and language_id='"+locale+"' order by 2";
			
			strblnggrp = "5";
		}

		if (strRepositoryYN.equals("Y") && strBillingOverride.equals("N") && strModuleId.equals("MP") &&  (boolPatientFoundMP ==false) &&(!strExtBillingGroup.equals("")))
		{
			boolChangeBillQry =true;
			strBillingQuery = "SELECT BLNG_GRP_ID,short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SHORT_DESC, "+
							"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
							"  REF_YN , status , category  FROM BL_BLNG_GRP_LANG_VW WHERE "+
								" ( NVL(category,'UNRESTRICTED') IN ( DECODE('"+strCitizenYn+"','Y','NATIONALS','N','OTHERS','UNRESTRICTED'), 'UNRESTRICTED')) AND "+
								" (( nvl(status,'X' )!='S' "+ 
								" AND BLNG_GRP_ID = '" + strExtBillingGroup + "' )) and language_id='"+locale+"'";
			strblnggrp = "6";
		}

		if (strModuleId.equals("AE"))
		{
			strBillingQuery = "SELECT BLNG_GRP_ID,short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SHORT_DESC, "+						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
								" AE_YN , status , category "+
								" FROM BL_BLNG_GRP_LANG_VW "+
								" WHERE " +
								" ((( NVL(category,'UNRESTRICTED') IN ( DECODE('"+strCitizenYn+"','Y','NATIONALS','OTHERS'), 'UNRESTRICTED')) AND "+
								" ((NVL(AE_YN,'N')='Y' AND "+
								" NVL(STATUS,'X' )!='S') AND ( NVL(HEALTH_CARD_APPL_YN,'N')='N' AND NVL(HCARE_ONLY_YN,'N')='N')) "+
//								" OR ( BLNG_GRP_ID = '" + mbilling_group + "' AND NVL('"+ strdfltbgyn +"','N') = 'Y' ))) and language_id='"+locale+"' order by 2";
								" AND ( BLNG_GRP_ID = '" + mbilling_group + "' AND NVL('"+ strdfltbgyn +"','N') = 'Y' ))) and language_id='"+locale+"' order by 2";
			strblnggrp = "7";
		}

		if (strModuleId.equals("DC"))
		{
			strBillingQuery = "SELECT BLNG_GRP_ID,short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SHORT_DESC, "+						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
							" DY_YN , status , category FROM BL_BLNG_GRP_LANG_VW "+
								" WHERE " + 
								" ((( NVL(category,'UNRESTRICTED') IN ( DECODE('"+strCitizenYn+"','Y','NATIONALS','OTHERS'), 'UNRESTRICTED')) AND "+
								" ((NVL(DY_YN,'N')='Y' AND "+
								" NVL(STATUS,'X' )!='S') AND ( NVL(HEALTH_CARD_APPL_YN,'N')='N' AND NVL(HCARE_ONLY_YN,'N')='N'))  "+
//								" OR (BLNG_GRP_ID = '" + mbilling_group + "' AND NVL('"+ strdfltbgyn +"','N') = 'Y' ))) and language_id='"+locale+"' order by 2";
								" AND (BLNG_GRP_ID = '" + mbilling_group + "' AND NVL('"+ strdfltbgyn +"','N') = 'Y' ))) and language_id='"+locale+"' order by 2"; 
			strblnggrp = "8";
		}

		if (((strModuleId.equals("MP")) && (boolPatientFoundMP == true)) || ((strModuleId.equals("IP") || strModuleId.equals("DC") ||           strModuleId.equals("OP")||strModuleId.equals("AE")) && (boolPatientFoundMP == true)))
		{
			boolSecurity = true;
		}

%>
<html>	
<head>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eBL/js/AddModifyPatFinDetails.js'></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eBL/js/Hashtable.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language="javascript" src="../../eBL/js/PkgSubs.js"></script>
	<script language="javascript" src='../../eBL/js/PkgAssociate.js'></script> 
	<script language="javascript" src='../../eBL/js/AddModifyPatFinDetailsPkgDiscDtls.js'></script> 
	<script language="javascript" src='../../eBL/js/PkgVisitDiscount.js'></script>
	
	<script language="javascript">
	async function activeHealthCard(){
	var patient_id = document.forms[0].patient_id.value;
	var title = 'Maintain Health Card';
	 

		var retVal =await window.showModalDialog('../../eBL/jsp/BillingPrevilageCardFrame.jsp?title='+title+'&modPatientId='+patient_id+'&called_from=PAS','Maintain Health Card','dialogWidth:800px; dialogHeight:600px;');
		//alert('Active Health card');
	}
	</script>

<% 
		/**** 
			This function is added by 
			Murugavel on 11/Aug/2002
			Reason		:Enhancements
			Script Function	:funHealthCardValue(obj)
			New Field 		:strHealthCard_YN variable, 
						:Check Box, Annual income(label+text field), 
						:Family Asset(label+text field),
						:No. of Dependants(label+text field), and the Responisible for the
						payment.(label+text field),
			Decoration		: Rearranged the position of the 
							Package required information to the second row		
							to optimize the space for the above fields.
					
			Form	table 
			Total Column	: 9					
			
		*******/
	%>	
<script language='javascript'>
//Added for FD - Rajesh V
async function uploadImage(){
	

	var patient_id  =document.forms[0].patient_id.value;
	if(patient_id == '') 
		patient_id = document.forms[0].cur_patient_id.value;

var uplurl=	document.forms[0].uploadurl.value;

	var dialogUrl = uplurl+"title=Upload Document&patient_id="+patient_id;
	var dialogFeatures  = "dialogHeight:" + "20" + "; dialogWidth:" + "70" +" ; scroll=auto; ";
	var returnVal =await window.showModalDialog(dialogUrl,null,dialogFeatures);	
}
//Added for FD - Rajesh V
//Added by MuthuN agianst 32426 on 07-09-12
function payerstatus()
{
	var settlement_ind = parent.frames[0].document.forms[0].setlmt_ind.value;
//	alert(settlement_ind)

//Modidified by DhanasekarV against Quick admission  May 06 2013


//&& settlement_ind !=null & settlement_ind !='undefined'&& settlement_ind !='' 
//alert('enter 	  payerstatus()');
	if(settlement_ind !='C' && settlement_ind !='R' ){ 
		
// 	alert(parent.frames[1].name);//Karthik commented here
// 	alert(parent.frames[1].frames[0].name);
// 	alert(parent.frames[1].frames[0].frames[1]);
// 	alert(parent.frames[1].frames[0].frames[1].document.forms[0].name);
// 	if(parent.frames[1].frames[0].name=='Frame61'){
// 		 rtn_total_records=0;	
// 	}

	var rtn_total_records;
	//alert("flag"+document.forms[0].adm_rec_flag.value);
	if(document.forms[0].adm_rec_flag.value== "1")
		{
		rtn_total_records=0;	
		}
	else{
		rtn_total_records=parent.frames[1].frames[0].frames[1].document.forms[0].total_records.value;	
	}
 	
	
	//alert(rtn_total_records); //Karthik added this validation
	//if(rtn_total_records==null || rtn_total_records=='') rtn_total_records=0;
	var cust_code = "";
	var payer_suspended_YN ="";
	for(var i=0;i<rtn_total_records;i++){
	cust_code =	eval("parent.frames[1].frames[0].frames[1].document.forms[0].cust_3"+i);
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var param="called_from=payersuspended&cust_code="+cust_code.value;	
	var temp_jsp="../../eBL/jsp/BLInsuranceValidations.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText);
	var retVal = responseText;
	payer_suspended_YN = eval("parent.frames[1].frames[0].frames[1].document.forms[0].payer_suspended_YN"+i);
	payer_suspended_YN.value = retVal;
	}
	}
//	alert('exit 	  payerstatus()');
}
//Added by MuthuN agianst 32426 on 07-09-12
		
function funHealthScheme()
{
	var calling_module_id = document.forms[0].calling_module_id.value;
	var billing_mode = document.forms[0].billing_mode.value;
	var hcard_applicable_yn = document.forms[0].hcard_applicable_yn.value;
	var hcare_applicable_yn = document.forms[0].hcare_applicable_yn.value;
	var hcard_scheme_id= document.forms[0].hcard_scheme_id.value;
	var hcare_scheme_id= document.forms[0].hcare_scheme_id.value;
	var hcard_expired_yn= document.forms[0].hcard_expired_yn.value;
	var hcare_expired_yn= document.forms[0].hcare_expired_yn.value;
	var previous_blng_grp= document.forms[0].previous_blng_grp.value;
	var previous_blng_grp_desc= document.forms[0].previous_blng_grp_desc.value;
	var hcard_prerequisite_yn= document.forms[0].hcard_prerequisite_yn.value;
	var special_scheme_blng_grp = document.forms[0].special_scheme_blng_grp.value;	 	
	var special_scheme_blng_grp_desc = document.forms[0].special_scheme_blng_grp_desc.value;
	var special_scheme_message = document.forms[0].special_scheme_message.value;
	var special_scheme_flag = document.forms[0].special_scheme_type.value;
	var patient_blng_grp = document.forms[0].patient_blng_grp.value;
			
	if (calling_module_id != 'MP') 
	{
		document.getElementById('patientSchemeID').innerText = special_scheme_message;

		if (billing_mode == 'Add')			
		{
			if (document.forms[0].strdfltbgyn.value == 'Y' && ( (hcard_applicable_yn == 'Y') || (hcare_applicable_yn == 'Y') ) )
			{
				document.forms[0].billing_group.value = special_scheme_blng_grp;
				document.forms[0].billing_group_desc.value = special_scheme_blng_grp_desc;
				if (document.forms[0].mblnggroup.value != document.forms[0].billing_group.value)
					callSettlements(document.forms[0].billing_group);
			}
		}	
	}
	else
	{
		//document.forms[0].billing_group.value = '';
	}
	
	funHealthCardValue(document.forms[0].billing_group);
}

function pkgSubsMsgDisplay()
{
	var open_pkg_exists_yn = document.forms[0].open_pkg_exists_yn.value;	
	if(open_pkg_exists_yn=='Y'){
				parent.frames[0].document.getElementById('pkgSubsMsg').style.display="inline";
	}
	else
	{
		parent.frames[0].document.getElementById('pkgSubsMsg').style.display=="none";
	}

}
function funChangeBillingGroup(obj)
{
	callglholdercheck(obj,"change_bg");				
	funHealthCardValue(obj);
//	callSettlements(obj);	
}

function disableMappingItemsAll()
{
	callglholdercheck(document.forms[0].billing_group);
	disableMappingItems();
}

function funHealthCardValue(obj)
{
	
	try
	{
		try
		{
			parent.frames[2].document.forms[0].validated_state.value = 'N';
		}
		catch(e)
		{
			//out.println(e.toString());
		}
		var healthCardTot = document.getElementById('HealthCardTot').value;
		var valueBlngGrp = document.PatFinMainForm.billing_group.value;
		var arrConcatenatedScheme = new Array();
		//var totbgroup = document.PatFinMainForm.billing_group.length

		arrConcatenatedScheme = healthCardTot.split("|");
		var totbgroup = arrConcatenatedScheme.length;
		var eachElement = new Array();

		for (i=0;i<totbgroup;i++)
		{	
			eachElement = (arrConcatenatedScheme[i]).split("-");
			if (eachElement[0] == valueBlngGrp)
			{
				if (eachElement[1] == 'N' )
				{
					document.getElementById('blngSchemeID').innerText = " ";
					document.getElementById('special_scheme_appl').value = 'N';
				}
				else if (eachElement[1] == 'C' )
				{
					document.getElementById('blngSchemeID').innerText = "HealthCard Applicable";
					document.getElementById('special_scheme_appl').value  = 'C';
				}
				else if (eachElement[1] == 'R' )
				{
					document.getElementById('blngSchemeID').innerText = "HealthCare Applicable";
					document.getElementById('special_scheme_appl').value  = 'R';
				}
			}
		}
	}
	catch(e)
	{
		//out.println(e.toString());
	}
}

function dispAlert()
{			
	var module_id = document.forms[0].calling_module_id.value;

	if (module_id == "MP" ) 
	{
		alert(getMessage("BL9310","BL"));
	}		
	funChangeBillingGroup();
}

function dispExpAlert()
{

	var module_id = document.forms[0].calling_module_id.value;

	if (module_id == "MP" ) 
	{
		alert(getMessage("BL9305","BL"));
	}
	funChangeBillingGroup();
}

function funModifyPatDet(valflg,enc_sel_check)
{	
	var boolFlag = authScr(valflg,enc_sel_check);	// 	enc_sel_check is added by manivel on 13-Jun-07  to make the form fields enable on change of Previous Encounters

	var strdfltbgyn = '<%=strdfltbgyn%>';

	if(boolFlag[0] == "Y") //&& strdfltbgyn=='N')
	{

	//Dhanasekar
	 document.forms[0].uploadurl.value =  '../../eBL/jsp/AddModifyInsUpldImgFrame.jsp?';

		var fin_auth_user_id=boolFlag[3];
		document.forms[0].fin_auth_user_id.value=fin_auth_user_id;
		if(document.forms[0].blng_grp_sel_frm_pkg_YN.value == "Y")
		{
			document.forms[0].billing_group_desc.value = document.forms[0].selecltd_bg_frm_pkg.value;
			document.forms[0].blnggrpbut.click();
		}
		callglholdercheck(document.forms[0].billing_group);
		//Update pat fin details check box enabled based on parameter value
		
		var upd_fin_dtl_chkbx  =  document.forms[0].upd_fin_dtl_chkbx.value;
		
		if(upd_fin_dtl_chkbx=='Y')
			{
		 document.forms[0].upd_fin_dtls.checked = true;
		 document.forms[0].upd_fin_dtls.disabled = true;
			}

		//22/08/2005
	}
//	}
	//return(boolFlag);
}	

		


// Added on 09/11/2003 -->
async function getBlngGrpSearch()
{
	var billing_group=document.forms[0].billing_group.value;
	
	if(billing_group=="select") billing_group="";

	if(billing_group=="")
	{
			alert(getMessage("BL9301","BL"));
			return;
			//document.forms[0].billing_group.focus();
	}
		
	if((billing_group!=""))
	{
		var retVal;
		var dialogHeight= "15" ;
		var dialogWidth	= "45" ;
		var dialogTop = "280" ;
		var center = "1" ;														   
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var url = "../../eBL/jsp/BLBillingGrpDetFrame.jsp?billing_group=	"+billing_group;
		retVal =await window.showModalDialog(url,arguments,features);
	}
}

async function getRefDet()
{
	var refid = document.forms[0].ref_id.value;
	var retVal;
	var dialogHeight= "38.6" ;
	var dialogWidth	= "100" ;
	var dialogTop = "110" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var url = "../../eMP/jsp/ViewPatReferral.jsp?referral_id="+refid;
	retVal =await window.showModalDialog(url,arguments,features);			
}

/* --Commented for Explanatory display ench

function blnggrplkup()
{	

	var msg="";
	var target			= document.forms[0].billing_group_desc;
	var retVal			= new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var sql1				= "";
	var sql2				= "";
	var search_desc			= "";
	var tit					= "";		
	var blnggrp			= document.forms[0].blnggrp.value; 

	//'<%=strblnggrp%>';

	var ExtBillingGroup = document.forms[0].ext_billing_group.value;

	//'<%=strExtBillingGroup%>';				

	sql1 = " select blng_grp_id, rpad(short_desc,15,` `)||` (` || decode(settlement_ind|| adm_rec_flag, `C`, 	`CASH`, `C0`,`CASH`,`C1`,`CASH`,`C2`,`CASH`,`R`, `CREDIT`,`R0`, `CREDIT`,`R1`, `CREDIT`,`R2`, `CREDIT`,`X1`, `SPONSOR`,`X2`,`INSURANCE`)||`)` from bl_blng_grp_vw where ";

	if ( blnggrp == "1" ) 
	{
		sql2 = "  nvl(ref_yn,`N`)=`Y` and nvl(hcare_only_yn,`N`) = `N` and nvl(status,`X` )!=`S` ";
	}

	if ( blnggrp == "2" ) 
	{
		sql2 = " nvl(ref_yn,`N`)=`Y` and nvl(ref_valid_for_regn_yn,`N`)=`Y` and nvl(status,`X` )!=`S` and nvl(hcare_only_yn,`N`) = `N` " ;	
	}

	if ( blnggrp == "3" ) 
	{
		sql2 = " nvl(op_yn,`N`)=`Y` and nvl(status,`X` )!=`S` and  nvl(health_card_appl_yn,`N`)=`N` and nvl(hcare_only_yn,`N`)=`N` ";
	}

	if ( blnggrp == "4" ) 
	{
		sql2 = "  nvl(ip_yn,`N`)=`Y` and nvl(status,`X` )!=`S` and nvl(health_card_appl_yn,`N`)=`N` and nvl(hcare_only_yn,`N`)=`N`";   
	}

	if ( blnggrp == "5" ) 
	{
		sql2 = " nvl(status,`X` ) != `S` and nvl(health_card_appl_yn,`N`)= `N` and nvl(hcare_only_yn,`N`)=`N`";
	}

	if (blnggrp == "6") 
	{
		sql2 = " nvl(status,`X` )!=`S` and blng_grp_id = `" + ExtBillingGroup + "` ";
	}

	// EPI TYPE ENH

	if ( blnggrp == "7" ) 
	{
		sql2 = " nvl(ae_yn,`N`)=`Y` and nvl(status,`X` )!=`S` and  nvl(health_card_appl_yn,`N`)=`N` and nvl(hcare_only_yn,`N`)=`N` ";
	}

	if ( blnggrp == "8" ) 
	{
		sql2 = " nvl(dy_yn,`N`)=`Y` and nvl(status,`X` )!=`S` and  nvl(health_card_appl_yn,`N`)=`N` and nvl(hcare_only_yn,`N`)=`N` ";
	}

	sql = sql1 + sql2;			
		
	search_code="blng_grp_id";
	search_desc="short_desc";
	tit="Billing Groups "; 
	retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
	
	var arr=new Array();

	if (!(retVal == null))
	{
  	    var retVal=unescape(retVal);
		arr=retVal.split("::");
	
		document.forms[0].billing_group_desc.value=arr[0].substring(0,16);
	    document.forms[0].billing_group.value=arr[1];			
			
		funChangeBillingGroup(document.forms[0].billing_group);
	}
	else
	{				
		//document.forms[0].billing_group_desc.value='';
		//document.forms[0].billing_group.value = '';				
		//Commented on 	26/10/2004
		//	funChangeBillingGroup(document.forms[0].billing_group);
		//Comment ends

		target.focus();
	}
}
*/

//Added by Rajesh V for CRF-155
async function blnggrplkupNew(clng_evnt){
	
	var target			= document.forms[0].billing_group_desc;
	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{
			document.forms[0].billing_group_desc.value = "";
			document.forms[0].billing_group.value = "";
			parent.frames[1].location.href='../../eCommon/html/blank.html';
			return;
		}
	}
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var blnggrp			= document.forms[0].blnggrp.value; 		
	var ExtBillingGroup = document.forms[0].ext_billing_group.value;
	var strCitizenYn = document.forms[0].CitizenYn.value;
	var patient_id= document.forms[0].patient_id.value;
	var encounter_date = document.forms[0].encounter_date_aft_trunc.value;
	var episode_type = document.forms[0].episode_type.value;
	var function_id = document.forms[0].function_id.value;
	encounter_date = convertDate(encounter_date,'DMY',locale,"en");
	var capture_employer_id_yn = document.forms[0].capture_employer_id_yn.value;
	var dialogHeight= "35" ;
	var dialogWidth	= "70" ;
	var dialogTop = "200" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;	
	var param = 'clng_evnt='+clng_evnt+'&patient_id='+patient_id+'&episode_type='+episode_type+'&function_id='+function_id+
				'&blnggrp='+blnggrp+'&encounter_date='+encounter_date+'&citizen_yn='+strCitizenYn+'&ext_blng_grp='+ExtBillingGroup+
				'&billingGroup='+target.value;
	var retVal =await window.showModalDialog("../../eBL/jsp/BLFinDtlsBGPayerLookup.jsp?"+param,arguments,features);
	
	var arr=new Array();		

	if(retVal == null) retVal='';

	if (retVal != null || retVal!="")
	{
		var retVal=unescape(retVal);
	    if(retVal != null && retVal.length>0 && retVal!='Y')
		{
			arr=retVal.split("^~^");	
			var is_blng_grp_pkg_link_YN = arr[9];
			if(is_blng_grp_pkg_link_YN == null) is_blng_grp_pkg_link_YN="N";
			var sel_bg_has_valid_pkg_YN = arr[10];
			if(sel_bg_has_valid_pkg_YN == null) sel_bg_has_valid_pkg_YN="N";

  		    document.forms[0].billing_group_desc.value=arr[1];
  			//Added by Rajesh V - To avoid on Blur evnt if the Billing grp is not changed
			if(document.forms[0].billing_group.value == arr[0]){
				return false;
			}
			//Added by Rajesh V - To avoid on Blur evnt if the Billing grp is not changed
			//.substring(0,16);
			document.forms[0].billing_group.value=arr[0];

			ref_src_code_YN=arr[3];
			pmry_ref_src_mand_YN = arr[4];
			sec_ref_src_mand_YN = arr[5];

			document.forms[0].currency_code_for_bg.value=arr[6];
			document.forms[0].currency_desc_for_bg.value=arr[7];
			document.forms[0].PAYER_EMP_ID_MAND_YN.value=arr[8];
			document.forms[0].is_blng_grp_pkg_link_YN.value=is_blng_grp_pkg_link_YN;
			document.forms[0].sel_bg_has_valid_pkg_YN.value=sel_bg_has_valid_pkg_YN;

			if(is_blng_grp_pkg_link_YN == "Y" && sel_bg_has_valid_pkg_YN == "N")
			{
				alert(getMessage("BL6360","BL"));
				target.value = "";
				document.forms[0].billing_group.value = "";
				parent.frames[1].location.href='../../eCommon/html/blank.html';
				return false;
			}

		    /*if (billinggroup.length == 0 || 
				 (billinggroup.length > 0  && billinggroup != arr[0]))
	  	    */

			document.forms[0].blnggrpappyn.value = "Y";
			document.forms[0].BlngGrpStatus.value = "";
			document.forms[0].blnggrpcatgappyn.value = "Y";			

			funChangeBillingGroup(document.forms[0].billing_group);

			if(ref_src_code_YN=="Y")
			{
				document.getElementById('ref_src_code_main_leg_disp').style.display="inline";
				document.getElementById('ref_src_code_main_val_disp').style.display="inline";
				document.forms[0].referral_source_main_code.value="";
				document.forms[0].referral_source_main_desc.value="";
				if(pmry_ref_src_mand_YN == "Y")
				{
					document.getElementById('ref_src_code_main_mand_disp').style.display="inline";
				}
				else
				{
					document.getElementById('ref_src_code_main_mand_disp').style.display="none";
				}
				document.getElementById('pmy_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('pmy_ref_src_lng_name').alt="";

				document.getElementById('ref_src_code_sub_leg_disp').style.display="inline";
				document.getElementById('ref_src_code_sub_val_disp').style.display="inline";
				document.getElementById("referral_source_sub_code").value="";
				document.getElementById('referral_source_sub_desc').value="";
				if(sec_ref_src_mand_YN == "Y")
				{
					document.getElementById('ref_src_code_sub_mand_disp').style.display="inline";
				}
				else
				{
					document.getElementById('ref_src_code_sub_mand_disp').style.display="none";
				}
				document.getElementById('sec_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('sec_ref_src_lng_name').alt="";

				document.forms[0].cap_ref_src_dtl_flag.value="Y";
				document.forms[0].referral_source_main_mand_YN.value=pmry_ref_src_mand_YN;
				document.forms[0].referral_source_sub_mand_YN.value=sec_ref_src_mand_YN;
			}
			else if(ref_src_code_YN=="N")
			{
				document.getElementById('ref_src_code_main_leg_disp').style.display="none";
				document.getElementById('ref_src_code_main_val_disp').style.display="none";
				document.forms[0].referral_source_main_code.value="";
				document.forms[0].referral_source_main_desc.value="";
				document.getElementById('pmy_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('pmy_ref_src_lng_name').alt="";

				document.getElementById('ref_src_code_sub_leg_disp').style.display="none";
				document.getElementById('ref_src_code_sub_val_disp').style.display="none";
				document.getElementById("referral_source_sub_code").value="";
				document.getElementById('referral_source_sub_desc').value="";
				document.getElementById('sec_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('sec_ref_src_lng_name').alt="";

				document.forms[0].cap_ref_src_dtl_flag.value="N";
				document.forms[0].referral_source_main_mand_YN.value=pmry_ref_src_mand_YN;
				document.forms[0].referral_source_sub_mand_YN.value=sec_ref_src_mand_YN;
			}
			curr_code();//currency code desc 

			if(capture_employer_id_yn == 'Y')
			{
				if(document.forms[0].PAYER_EMP_ID_MAND_YN.value == 'Y')
				{
					document.getElementById('emp_id_mand_YN_disp').style.display='inline';
				}
				else
				{
					document.getElementById('emp_id_mand_YN_disp').style.display='none';
					document.forms[0].employer_code.value="";
				}
			}
			else
			{
				document.forms[0].employer_code.value="";
				document.getElementById('emp_id_mand_YN_disp').style.display='none';
			}
			if(patient_id !== "")
			{
				if(document.forms[0].sel_bg_has_valid_pkg_YN.value == "Y")
				{
					document.getElementById('vw_pkg_dtl_disp').style.display="inline";
				}
				else
				{
					document.getElementById('vw_pkg_dtl_disp').style.display="none";
				}
			}
		}
		else
		{
			 // funChangeBillingGroup(document.forms[0].billing_group);
//			target.focus();
	     }
	  }

	//Ajax Call Rajesh V
	var ajBillingGroup = document.forms[0].billing_group.value
	if(ajBillingGroup.length>0){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var ajFacilityId = document.forms[0].facility_id.value;
		var ajPatientid = document.forms[0].patient_id.value;
		
		//alert(ajBillingGroup)
		var param="func_mode=getActiveHealthCardVis&facility_id="+ajFacilityId+"&billGroup="+ajBillingGroup+"&patient_id="+ajPatientid;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eBL/jsp/PkgSubscriptionValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var responseText=trimString(xmlHttp.responseText);	
		//alert(responseText);
		//responseText = "Y";
		if(responseText == "Y"){
			document.getElementById('ref_active_health_card_link').style.display='inline';
		}
		else{
			document.getElementById('ref_active_health_card_link').style.display='none';
		}
	}		
	//Ajax Call Rajesh V

	//alert('This is end of fn')
}

function blnggrplkup(clng_evnt)
{

	var target			= document.forms[0].billing_group_desc;
	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{
			document.forms[0].billing_group_desc.value = "";
			document.forms[0].billing_group.value = "";
			parent.frames[1].location.href='../../eCommon/html/blank.html';
			return;
		}
	}
	var billinggroup    = document.forms[0].billing_group.value;
	var retVal			= new String();
	var dialogTop			= "130";
	var dialogHeight		= "32" ;
	var dialogWidth			= "50" ;
	var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var sql1				= "";
	var sql2				= "";		

	var cash_leg=getLabel("eBL.CASH.label","BL");
	cash_leg=encodeURIComponent(cash_leg);
	var credit_leg=getLabel("eBL.CREDIT.label","BL");
	credit_leg=encodeURIComponent(credit_leg);
	var sponsor_leg=getLabel("eBL.SPONSOR.label","BL");
	sponsor_leg=encodeURIComponent(sponsor_leg);
	var ins_leg=getLabel("Common.Insurance.label","common");
	ins_leg=encodeURIComponent(ins_leg);

//	var title="Billing Groups";
	var title=getLabel("Common.BillingGroup.label","common");
	title=encodeURIComponent(title);
	var column_sizes = escape("10%,20%,45%,5%,5%,5%,5%,5%,0%,0%,0%");               
//	var column_descriptions = escape("Code,Description,Explanatory Note"); 
	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);
//	var slmt_type = getLabel("Common.SettlementType.label","common");
//	slmt_type=encodeURIComponent(slmt_type);
	var expnote=getLabel("eBL.EXPLANATORY_NOTE.label","BL");
	expnote=encodeURIComponent(expnote);
	var capt_ref_src_dtl=getLabel("eBL.CAPTURE_REF_SOURCE_DTL.label","BL");
	capt_ref_src_dtl=encodeURIComponent(capt_ref_src_dtl);
	var ref_source_main_mand_yn=getLabel("eBL.PRMY_REF_SRC_MAND.label","BL");
	ref_source_main_mand_yn=encodeURIComponent(ref_source_main_mand_yn);
	var ref_source_sub_mand_yn=getLabel("eBL.SEC_REF_SRC_MAND.label","BL");
	ref_source_sub_mand_yn=encodeURIComponent(ref_source_sub_mand_yn);
	var cust_curr_code=getLabel("eBL.CURR_CODE.label","BL");
	cust_curr_code=encodeURIComponent(cust_curr_code);
	var curr_desc=getLabel("eBL.CURR_DESC.label","BL");
	curr_desc=encodeURIComponent(curr_desc);
	var emp_mand_YN = "Employer ID Mand YN";
	emp_mand_YN = encodeURIComponent(emp_mand_YN);
	var package_YN = "Package YN";
	package_YN = encodeURIComponent(package_YN);
	var package_avail_YN = "Package Available YN";
	package_avail_YN = encodeURIComponent(package_avail_YN);

	var column_descriptions = code+","+desc+","+expnote+','+capt_ref_src_dtl+","+ref_source_main_mand_yn+","+ref_source_sub_mand_yn+","+cust_curr_code+","+curr_desc+","+emp_mand_YN+","+package_YN+","+package_avail_YN;

	var message = '';
	var blnggrp			= document.forms[0].blnggrp.value; 		
	var ExtBillingGroup = document.forms[0].ext_billing_group.value;
	var strCitizenYn = document.forms[0].CitizenYn.value;
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var patient_id= document.forms[0].patient_id.value;
	var encounter_date = document.forms[0].encounter_date_aft_trunc.value;
	var strCitizenYn = document.forms[0].CitizenYn.value;
	var episode_type = document.forms[0].episode_type.value;
	var function_id = document.forms[0].function_id.value;
	encounter_date = convertDate(encounter_date,'DMY',locale,"en");

	var capture_employer_id_yn = document.forms[0].capture_employer_id_yn.value;

	var ref_src_code_YN="N";
	var pmry_ref_src_mand_YN="N";
	var sec_ref_src_mand_YN="N";
	var currency_code_for_bg = "";
	var currency_desc_for_bg = "";
	
	sql = "called_for=BGLKUP&locale="+locale+"&facility_id="+facility_id+"&patient_id="+patient_id+"&episode_type="+episode_type+"&function_id="+function_id+"&blnggrp="+blnggrp+"&encounter_date="+encounter_date+"&citizen_yn="+strCitizenYn+"&ext_blng_grp="+ExtBillingGroup;
/*
	sql1 = "select blng_grp_id,short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SRT_DESC,replace(detail_desc,chr(10),'<br>') DTL_DESC,nvl(CAPTURE_REF_SOURCE_DTL_YN,'N') CAP_REF_SRC_YN, nvl(REF_SOURCE_MAIN_MAND_YN,'N') REF_SRC_MN_MAND_YN, nvl(REF_SOURCE_SUB_MAND_YN,'N') REF_SRC_SB_MAND_YN,CURRENCY_CODE,CURRENCY_DESC,PR_PAYER_EMPLOYER_ID_MAND_YN,PACKAGE_YN,blcore.package_blng_grp_yn('"+facility_id+"','"+patient_id+"','"+episode_type+"','"+function_id+"',blng_grp_id,to_date('"+encounter_date+"','DD/MM/YYYY'),'B',DECODE('"+strCitizenYn+"','Y','NATIONALS','N','OTHERS','UNRESTRICTED')) PKG_AVAIL_YN from BL_BLNG_GRP_LANG_VW a where (NVL(category,'UNRESTRICTED') IN (DECODE('"+strCitizenYn+"','Y','NATIONALS','N','OTHERS','UNRESTRICTED'),'UNRESTRICTED')) and language_id='"+locale+"' AND ";

	if ( blnggrp == "1" ) 
	{
		sql2 = "nvl(ref_yn,'N')='Y' and nvl(hcare_only_yn,'N') = 'N' and nvl(status,'X' )!='S'";
	}

	if ( blnggrp == "2" ) 
	{
		sql2 = "nvl(ref_yn,'N')='Y' and nvl(ref_valid_for_regn_yn,'N')='Y' and nvl(status,'X' )!='S' and nvl(hcare_only_yn,'N') = 'N'" ;	
	}

	if ( blnggrp == "3" ) 
	{
		sql2 = "nvl(op_yn,'N')='Y' and nvl(status,'X' )!='S' and  nvl(health_card_appl_yn,'N')='N' and nvl(hcare_only_yn,'N')='N'";
	}

	if ( blnggrp == "4" ) 
	{
		sql2 = "nvl(ip_yn,'N')='Y' and nvl(status,'X' )!='S' and nvl(health_card_appl_yn,'N')='N' and nvl(hcare_only_yn,'N')='N'";   
	}

	if ( blnggrp == "5" ) 
	{
		sql2 = "nvl(status,'X' )!='S' and nvl(health_card_appl_yn,'N')= 'N' and nvl(hcare_only_yn,'N')='N'";
	}

	if (blnggrp == "6") 
	{
		sql2 = "nvl(status,'X' )!='S' and blng_grp_id='"+ExtBillingGroup+"'";
	}

	// EPI TYPE ENH

	if ( blnggrp == "7" ) 
	{
		sql2 = "nvl(ae_yn,'N')='Y' and nvl(status,'X' )!='S' and  nvl(health_card_appl_yn,'N')='N' and nvl(hcare_only_yn,'N')='N'";
	}

	if ( blnggrp == "8" ) 
	{
		sql2 = "nvl(dy_yn,'N')='Y' and nvl(status,'X' )!='S' and  nvl(health_card_appl_yn,'N')='N' and nvl(hcare_only_yn,'N')='N'";
	}
	sql = sql1 + sql2;
alert(sql);
	sql = escape(sql);	
//	sql = sql1 + sql2;

	sql = encodeURIComponent(sql,"UTF-8"); // Changed the logic for ICN - 5986 on 10/14/2008
*/
	if(document.forms[0].blng_grp_sel_frm_pkg_YN.value == "Y")
	{
		document.forms[0].blng_grp_sel_frm_pkg_YN.value = "N";
//		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=1"+"&col_show_hide=YYYNNNNNNNN";

		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=1"+"&col_show_hide=YYYNNNNNNNN";
	}
	else
	{
//		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYYNNNNNNNN";
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYYNNNNNNNN";
	}

	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);		
	

//	alert("retvalues "+retVal);
	var arr=new Array();		

	if(retVal == null) retVal='';

	if (retVal != null || retVal!="")
	{
		var retVal=unescape(retVal);

	    if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");	
			var is_blng_grp_pkg_link_YN = arr[9];
			if(is_blng_grp_pkg_link_YN == null) is_blng_grp_pkg_link_YN="N";
			var sel_bg_has_valid_pkg_YN = arr[10];
			if(sel_bg_has_valid_pkg_YN == null) sel_bg_has_valid_pkg_YN="N";

  		    document.forms[0].billing_group_desc.value=arr[1];
  			//Added by Rajesh V - To avoid on Blur evnt if the Billing grp is not changed
			if(document.forms[0].billing_group.value == arr[0]){
				return false;
			}
			//Added by Rajesh V - To avoid on Blur evnt if the Billing grp is not changed
			//.substring(0,16);
			document.forms[0].billing_group.value=arr[0];

			ref_src_code_YN=arr[3];
			pmry_ref_src_mand_YN = arr[4];
			sec_ref_src_mand_YN = arr[5];

			document.forms[0].currency_code_for_bg.value=arr[6];
			document.forms[0].currency_desc_for_bg.value=arr[7];
			document.forms[0].PAYER_EMP_ID_MAND_YN.value=arr[8];
			document.forms[0].is_blng_grp_pkg_link_YN.value=is_blng_grp_pkg_link_YN;
			document.forms[0].sel_bg_has_valid_pkg_YN.value=sel_bg_has_valid_pkg_YN;

			if(is_blng_grp_pkg_link_YN == "Y" && sel_bg_has_valid_pkg_YN == "N")
			{
				alert(getMessage("BL6360","BL"));
				target.value = "";
				document.forms[0].billing_group.value = "";
				parent.frames[1].location.href='../../eCommon/html/blank.html';
				return false;
			}

		    /*if (billinggroup.length == 0 || 
				 (billinggroup.length > 0  && billinggroup != arr[0]))
	  	    */

			document.forms[0].blnggrpappyn.value = "Y";
			document.forms[0].BlngGrpStatus.value = "";
			document.forms[0].blnggrpcatgappyn.value = "Y";			

			funChangeBillingGroup(document.forms[0].billing_group);

			if(ref_src_code_YN=="Y")
			{
				document.getElementById('ref_src_code_main_leg_disp').style.display="inline";
				document.getElementById('ref_src_code_main_val_disp').style.display="inline";
				document.forms[0].referral_source_main_code.value="";
				document.forms[0].referral_source_main_desc.value="";
				if(pmry_ref_src_mand_YN == "Y")
				{
					document.getElementById('ref_src_code_main_mand_disp').style.display="inline";
				}
				else
				{
					document.getElementById('ref_src_code_main_mand_disp').style.display="none";
				}
				document.getElementById('pmy_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('pmy_ref_src_lng_name').alt="";

				document.getElementById('ref_src_code_sub_leg_disp').style.display="inline";
				document.getElementById('ref_src_code_sub_val_disp').style.display="inline";
				document.getElementById("referral_source_sub_code").value="";
				document.getElementById('referral_source_sub_desc').value="";
				if(sec_ref_src_mand_YN == "Y")
				{
					document.getElementById('ref_src_code_sub_mand_disp').style.display="inline";
				}
				else
				{
					document.getElementById('ref_src_code_sub_mand_disp').style.display="none";
				}
				document.getElementById('sec_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('sec_ref_src_lng_name').alt="";

				document.forms[0].cap_ref_src_dtl_flag.value="Y";
				document.forms[0].referral_source_main_mand_YN.value=pmry_ref_src_mand_YN;
				document.forms[0].referral_source_sub_mand_YN.value=sec_ref_src_mand_YN;
			}
			else if(ref_src_code_YN=="N")
			{
				document.getElementById('ref_src_code_main_leg_disp').style.display="none";
				document.getElementById('ref_src_code_main_val_disp').style.display="none";
				document.forms[0].referral_source_main_code.value="";
				document.forms[0].referral_source_main_desc.value="";
				document.getElementById('pmy_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('pmy_ref_src_lng_name').alt="";

				document.getElementById('ref_src_code_sub_leg_disp').style.display="none";
				document.getElementById('ref_src_code_sub_val_disp').style.display="none";
				document.getElementById("referral_source_sub_code").value="";
				document.getElementById('referral_source_sub_desc').value="";
				document.getElementById('sec_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('sec_ref_src_lng_name').alt="";

				document.forms[0].cap_ref_src_dtl_flag.value="N";
				document.forms[0].referral_source_main_mand_YN.value=pmry_ref_src_mand_YN;
				document.forms[0].referral_source_sub_mand_YN.value=sec_ref_src_mand_YN;
			}
			curr_code();//currency code desc 

			if(capture_employer_id_yn == 'Y')
			{
				if(document.forms[0].PAYER_EMP_ID_MAND_YN.value == 'Y')
				{
					document.getElementById('emp_id_mand_YN_disp').style.display='inline';
				}
				else
				{
					document.getElementById('emp_id_mand_YN_disp').style.display='none';
					document.forms[0].employer_code.value="";
				}
			}
			else
			{
				document.forms[0].employer_code.value="";
				document.getElementById('emp_id_mand_YN_disp').style.display='none';
			}
			if(patient_id !== "")
			{
				if(document.forms[0].sel_bg_has_valid_pkg_YN.value == "Y")
				{
					document.getElementById('vw_pkg_dtl_disp').style.display="inline";
				}
				else
				{
					document.getElementById('vw_pkg_dtl_disp').style.display="none";
				}
			}
		}
		else
		{
			 // funChangeBillingGroup(document.forms[0].billing_group);
//			target.focus();
	     }
	  }

	//Ajax Call Rajesh V
	var ajBillingGroup = document.forms[0].billing_group.value
	if(ajBillingGroup.length>0){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var ajFacilityId = document.forms[0].facility_id.value;
		var ajPatientid = document.forms[0].patient_id.value;
		
		//alert(ajBillingGroup)
		var param="func_mode=getActiveHealthCardVis&facility_id="+ajFacilityId+"&billGroup="+ajBillingGroup+"&patient_id="+ajPatientid;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eBL/jsp/PkgSubscriptionValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var responseText=trimString(xmlHttp.responseText);	
		//alert(responseText);
		//responseText = "Y";
		if(responseText == "Y"){
			document.getElementById('ref_active_health_card_link').style.display='inline';
		}
		else{
			document.getElementById('ref_active_health_card_link').style.display='none';
		}
	}		
	//Ajax Call Rajesh V



}

function callBlnggrp()
{

//Added by Manivel on 7-May-07 for resetting the settlement frame when blng_grp is null
	if(document.forms[0].billing_group.value=="")
	{
		parent.frames[1].location.href="../../eCommon/html/blank.html";
	}

	var strdfltbgyn = '<%=strdfltbgyn%>';
	var operation=document.forms[0].operation.value;
	var strBillGrpId=document.forms[0].strBillGrpId.value;
	var strModuleId=document.forms[0].calling_module_id.value;
	
	if (strdfltbgyn=='N' || (operation=="Insert" && strBillGrpId!="" && strModuleId!="MP"))
	{
		if(operation=="Insert" && strBillGrpId!="" && strModuleId!="MP")
		{
			enableAllElements();
			disableModifyButton();
	    }
		funChangeBillingGroup(document.forms[0].billing_group);
	}
}
/*	   
function glrellkup(clng_evnt)
{	
	var msg					= "";
	var target				= document.forms[0].pat_reln_with_gl_holder;

	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			target.value = "";
			return;
		}
	}

	var retVal				= new String();
	var dialogTop			= "130";
	var dialogHeight		= "32" ;
	var dialogWidth			= "50" ;
	var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var search_desc			= "";
	var title					= "";				

	var glholdername		= document.forms[0].gl_holder_name.value;
    if (glholdername.length == 0)
		return;
		
	var locale = document.forms[0].locale.value;
		
	sql = "	select relationship_code code, long_desc description from mp_relationship_lang_vw where language_id='"+locale+"' and nvl(eff_status,'E') != 'D' and upper(relationship_code) like upper(?) and upper(long_desc) like upper(?) order by 1";	
	
	title=getLabel("eBL.RELATIONSHIPS.label","BL");

	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = DESC_CODE;		
	retArray = CommonLookup( title, argArray );	
	
	if(retArray != null && retArray !="")
	{
		document.forms[0].pat_reln_with_gl_holder.value='';										
		document.forms[0].pat_reln_with_gl_holder.value=retArray[1];						
	}
	else
	{
		document.forms[0].pat_reln_with_gl_holder.value='';										
		target.focus();
	}

}
*/
/*
function patrellkup()
{
	var msg					= "";
	var target				= document.forms[0].pat_reln_with_resp_person;
	var retVal				= new String();
	var dialogTop			= "130";
	var dialogHeight		= "32" ;
	var dialogWidth			= "50" ;
	var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var search_desc			= "";
	var tit					= "";				

	var respforpymt			= document.forms[0].resp_for_payment.value;
    if (respforpymt.length == 0)
		return;

	var locale = document.forms[0].locale.value;
		
	sql = "	select relationship_code, long_desc from mp_relationship_lang_vw where language_id=`"+locale+"` and nvl(eff_status,`E`) != `D`";	

	search_code="relationship_code";
	search_desc="long_desc";
	tit=getLabel("eBL.RELATIONSHIPS.label","BL");

	retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
	
	var arr=new Array();

	if (!(retVal == null))
	{
  	    var retVal=unescape(retVal);
		arr=retVal.split("::");

		document.forms[0].pat_reln_with_resp_person.value='';										
		document.forms[0].pat_reln_with_resp_person.value=arr[0];
	}
	else
	{	
		document.forms[0].pat_reln_with_resp_person.value='';										
		target.focus();
	}
}
*/
function patrellkup(clng_evnt)

{	

	var locale = document.forms[0].locale.value;

	var target = document.forms[0].pat_reln_with_resp_person;
	
	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].pat_reln_with_resp_person.value='';
			return;
		}
	}

	var message="";
	var retVal				= new String();
	var dialogTop			= "130";
	var dialogHeight		= "32" ;
	var dialogWidth			= "50" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var title				= "";
	var column_descriptions = "";

	var title=getLabel("eBL.RELATIONSHIPS.label","BL"); 
	title=encodeURIComponent(title);		
		
	sql = "select RELATIONSHIP_CODE RELATIONSHIP_CODE,SHORT_DESC SHORT_DESC from MP_RELATIONSHIP_LANG_VW where language_id='"+locale+"' and nvl(eff_status,'E') != 'D'";
	
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
	}
	else
	{	
		target.value='';
	}
}

function glrellkup(clng_evnt)
{	

	var locale = document.forms[0].locale.value;

	var target = document.forms[0].pat_reln_with_gl_holder;
	
	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].pat_reln_with_gl_holder.value='';
			return;
		}
	}

	var message="";
	var retVal				= new String();
	var dialogTop			= "130";
	var dialogHeight		= "32" ;
	var dialogWidth			= "50" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var title				= "";
	var column_descriptions = "";

	var title=getLabel("eBL.RELATIONSHIPS.label","BL"); 
	title=encodeURIComponent(title);		
		
	sql = "select RELATIONSHIP_CODE RELATIONSHIP_CODE,SHORT_DESC SHORT_DESC from MP_RELATIONSHIP_LANG_VW where language_id='"+locale+"' and nvl(eff_status,'E') != 'D'";
	
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
	}
	else
	{	
		target.value='';
	}
}

function gllkup(clng_evnt)
{	     

	var target			= document.forms[0].gl_holder_name;
	var module_id = document.forms[0].calling_module_id.value;

	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			target.value = "";
//			document.forms[0].pat_reln_with_gl_holder.value = "";
			return;
		}
		if(module_id =='MP')
			return ;
	}
	
	var patient_id		= document.forms[0].patient_id.value;						
	var retVal			= new String();		
	var dialogTop			= "130";
	var dialogHeight		= "32" ;
	var dialogWidth			= "50" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";		
	var mode				= "";
	var slmt_ind			= "";
	var adm_rec_flag			="";
		
	var encounter_date_time = document.forms[0].encounter_date_time.value;
	var facility_id = document.forms[0].facility_id.value;		
	var billing_group=document.forms[0].billing_group.value;
	var locale = document.forms[0].locale.value;
	var title=getLabel("eBL.VALID_DOCUMENTS.label","BL");
//	var column_sizes = escape("20%,12%,12%,20%,15%,7%,20%,7%,20%,0%,0%,0%,0%,0%");               
	var column_sizes = escape("20%,12%,12%,20%,7%,20%,7%,20%,0%,0%,0%,0%,0%,0%,0%,0%,0%");               
//	var column_descriptions = escape("Doc Reference,Start Date,End Date,GL Holder Name,Relationship with GL Holder,Customer Code,Customer Name"); 
	var docref=getLabel("eBL.DOC_REF.label","BL");
	var startdate=getLabel("Common.StartDate.label","common");
	var enddate=getLabel("Common.enddate.label","Common");
	var glholname=getLabel("eBL.GL_HOLDER_NAME.label","BL");
//	var rshipglhol=getLabel("eBL.PATIENT_RELN_WITH_GL_HOLDER.label","BL");
	var custmcode=getLabel("Common.CustomerCode.label","common");
	var custmname=getLabel("Common.Customer.label","common");
	var custgrpcode=getLabel("eBL.CUST_GROUP_CODE.label","BL");
	var custgrpname=getLabel("eBL.CUSTOMER_GROUP.label","BL");
	var tot_gl_valid_enc = "Total GL Valid Encounter";
	var tot_op_gl_valid_enc = "Total GL Valid Encounter for OP";
	var tot_ae_gl_valid_enc = "Total GL Valid Encounter for AE";
	var tot_ip_gl_valid_enc = "Total GL Valid Encounter for IP";
	var tot_dc_gl_valid_enc = "Total GL Valid Encounter for DC";
	var tot_op_availed_enc = "Total GL Encounters availed for OP";
	var tot_ae_availed_enc = "Total GL Encounters availed for AE";
	var tot_ip_availed_enc = "Total GL Encounters availed for IP";
	var tot_dc_availed_enc = "Total GL Encounters availed for DC";

//	var column_descriptions = docref+","+startdate+","+enddate+","+glholname+","+rshipglhol+","+custmcode+","+custmname+","+custgrpcode+","+custgrpname+","+tot_gl_valid_enc+","+tot_ae_gl_valid_enc+","+tot_op_gl_valid_enc+","+tot_ip_gl_valid_enc+","+tot_dc_gl_valid_enc;
	var column_descriptions = docref+","+startdate+","+enddate+","+glholname+","+custmcode+","+custmname+","+custgrpcode+","+custgrpname+","+tot_gl_valid_enc+","+tot_op_gl_valid_enc+","+tot_ae_gl_valid_enc+","+tot_ip_gl_valid_enc+","+tot_dc_gl_valid_enc+","+tot_op_availed_enc+","+tot_ae_availed_enc+","+tot_ip_availed_enc+","+tot_dc_availed_enc;
	var message = '';
		
	if (billing_group.length == 0) return;

//	slmt_ind = parent.frames[1].frames[0].frames[1].document.forms[0].setlmt_ind.value;
	slmt_ind = document.forms[0].setlmt_ind.value;
	adm_rec_flag = document.forms[0].adm_rec_flag.value;
	
	sql="called_for=GLHOLDERLKUP&locale="+locale+"&facility_id="+facility_id+"&patient_id="+patient_id+"&slmt_ind="+slmt_ind+"&encounter_date_time="+encounter_date_time+"&module_id="+module_id;
/*
	if ( module_id == "OP" || module_id == "AE" || module_id == "IP" || module_id == "DC")
	{
		sql = "SELECT DISTINCT credit_doc_ref_desc DOC_REF,TO_CHAR(credit_doc_ref_start_date,'dd/mm/yyyy') ST_DATE,TO_CHAR(credit_doc_ref_date,'dd/mm/yyyy') END_DATE,NVL(gl_holder_name,'') GL_NAME,NVL(cust_code,'') CUST_CODE,NVL(short_name,'') SHRT_DESC,NVL(CUST_GROUP_CODE,'') CUST_GRP_CODE,nvl(CUST_GROUP_DESC,'') cust_grp_desc, nvl(NO_OF_ENC_GL_VALID,'') NO_ENC_GL_VALID,nvl(NO_OF_OP_ENC_GL_VALID,'') NO_OP_ENC_GL_VALID,nvl(NO_OF_AE_ENC_GL_VALID,'') NO_AE_ENC_GL_VALID,nvl(NO_OF_IP_ENC_GL_VALID,'') NO_IP_ENC_GL_VALID,nvl(NO_OF_DC_ENC_GL_VALID,'') NO_DC_ENC_GL_VALID,nvl(NO_OF_OP_ENC_GL_AVAILED,'') NO_OP_ENC_GL_AVAILED,nvl(NO_OF_AE_ENC_GL_AVAILED,'') NO_AE_ENC_GL_AVAILED,nvl(NO_OF_IP_ENC_GL_AVAILED,'') NO_IP_ENC_GL_AVAILED,nvl(NO_OF_DC_ENC_GL_AVAILED,'') NO_DC_ENC_GL_AVAILED FROM BL_GL_HOLDER_LOOKUP_VW WHERE operating_facility_id = '"+facility_id +"' AND language_id='"+locale+"' AND patient_id = '"+patient_id+"' AND settlement_ind = '"+slmt_ind+"' AND credit_doc_ref_date > trunc( to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI'))";
	}
	else
	{
		sql = "select '' DOC_REF,'' ST_DATE,'' END_DATE,' ' GL_NAME,' ' CUST_CODE,' ' SHRT_DESC,' ' CUST_GROUP_CODE,' ' CUST_GRP_DESC, ' ' NO_ENC_GL_VALID, ' ' NO_AE_ENC_GL_VALID, ' ' NO_OP_ENC_GL_VALID, ' ' NO_IP_ENC_GL_VALID, ' ' NO_DC_ENC_GL_VALID ,' ' NO_OP_ENC_GL_AVAILED,' ' NO_AE_ENC_GL_AVAILED,' ' NO_IP_ENC_GL_AVAILED,' ' NO_DC_ENC_GL_AVAILED FROM dual a WHERE 1=2";
	}		

//	sql = escape(sql);					

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=4"+"&col_show_hide=YYYYYYYYNNNNN";
*/
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=4"+"&col_show_hide=YYYYYYYYNNNNN";

	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);	

	var arr=new Array();					
		
	if(retVal == null) retVal='';		

	if (retVal != null || retVal != "")
	{			
		var retVal=unescape(retVal);				

		if (billing_group.length > 0 )
		{
			if(slmt_ind=="X" && adm_rec_flag=="2")
			{
				mode = parent.frames[1].frames[0].frames[1].document.forms[0].Case.value;			
			}
			else
			{
				mode = parent.frames[1].frames[0].document.forms[0].Case.value;	
			}
		}

		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");				   

			if (mode == "2")
			{	
				parent.frames[1].frames[0].document.forms[0].credit_doc_ref1.value  =arr[0];					
				parent.frames[1].frames[0].document.forms[0].credit_doc_start_date1.value=arr[1];					
				parent.frames[1].frames[0].document.forms[0].credit_doc_start_date1.disabled=true;					
				parent.frames[1].frames[0].document.forms[0].credit_doc_date1.value=arr[2];
				parent.frames[1].frames[0].document.forms[0].credit_doc_date1.disabled=true;
				parent.frames[1].frames[0].document.forms[0].cust_1.value=arr[4];	
				parent.frames[1].frames[0].document.forms[0].cust_1_desc.value=arr[5];			   
				parent.frames[1].frames[0].document.forms[0].cust_group_code_1.value=arr[6];	
				parent.frames[1].frames[0].document.forms[0].cust_group_desc_1.value=arr[7];			   
			}
		    else if (mode == "3")
		    { 	
			    parent.frames[1].frames[0].document.forms[0].credit_doc_ref2.value=arr[0];
			    parent.frames[1].frames[0].document.forms[0].credit_doc_start_date2.value=arr[1];
			    parent.frames[1].frames[0].document.forms[0].credit_doc_start_date2.disabled=true;
			    parent.frames[1].frames[0].document.forms[0].credit_doc_date2.value=arr[2];
			    parent.frames[1].frames[0].document.forms[0].credit_doc_date2.disabled=true;
			    parent.frames[1].frames[0].document.forms[0].cust_2.value=arr[4];
				parent.frames[1].frames[0].document.forms[0].cust_2_desc.value=arr[5];			   
				parent.frames[1].frames[0].document.forms[0].cust_group_code_2.value=arr[6];	
				parent.frames[1].frames[0].document.forms[0].cust_group_desc_2.value=arr[7];			   
			}
			parent.frames[1].frames[0].document.forms[0].tot_valid_enc_with_gl.value = arr[8];
			parent.frames[1].frames[0].document.forms[0].tot_valid_enc_with_gl.disabled=true;
			parent.frames[1].frames[0].document.forms[0].tot_valid_op_enc_with_gl.value = arr[9];
			parent.frames[1].frames[0].document.forms[0].tot_valid_op_enc_with_gl.disabled=true;
			parent.frames[1].frames[0].document.forms[0].tot_valid_ae_enc_with_gl.value = arr[10];
			parent.frames[1].frames[0].document.forms[0].tot_valid_ae_enc_with_gl.disabled=true;
			parent.frames[1].frames[0].document.forms[0].tot_valid_ip_enc_with_gl.value = arr[11];
			parent.frames[1].frames[0].document.forms[0].tot_valid_ip_enc_with_gl.disabled=true;
			parent.frames[1].frames[0].document.forms[0].tot_valid_dc_enc_with_gl.value = arr[12];
			parent.frames[1].frames[0].document.forms[0].tot_valid_dc_enc_with_gl.disabled=true;
			document.forms[0].gl_holder_name.value=arr[3];
//			document.forms[0].pat_reln_with_gl_holder.value=if(arr[4]==" ") arr[4]="" ;

			var tot_availed_op_enc_with_gl = arr[13];
			var tot_availed_ae_enc_with_gl = arr[14];
			var tot_availed_ip_enc_with_gl = arr[15];
			var tot_availed_dc_enc_with_gl = arr[16];

			var tot_availed_enc_with_gl = eval(tot_availed_op_enc_with_gl) + eval(tot_availed_ae_enc_with_gl) +eval(tot_availed_ip_enc_with_gl) + eval(tot_availed_dc_enc_with_gl); 

			parent.frames[1].frames[0].document.forms[0].tot_availed_op_enc_with_gl.value = arr[13];
			parent.frames[1].frames[0].document.forms[0].tot_availed_ae_enc_with_gl.value = arr[14];
			parent.frames[1].frames[0].document.forms[0].tot_availed_ip_enc_with_gl.value = arr[15];
			parent.frames[1].frames[0].document.forms[0].tot_availed_dc_enc_with_gl.value = arr[16];
			parent.frames[1].frames[0].document.forms[0].tot_availed_enc_with_gl.value = tot_availed_enc_with_gl;

			parent.frames[1].frames[0].document.forms[0].gl_doc_ref_exist_YN.value = "Y";
		}	
		else
		{
//			document.forms[0].pat_reln_with_gl_holder.value=""; 
//			target.focus();

			if (mode == "2")
			{	
				parent.frames[1].frames[0].document.forms[0].credit_doc_start_date1.disabled=false;					
				parent.frames[1].frames[0].document.forms[0].credit_doc_date1.disabled=false;
			}
			else if (mode == "3")
			{ 	
				parent.frames[1].frames[0].document.forms[0].credit_doc_start_date2.disabled=false;
				parent.frames[1].frames[0].document.forms[0].credit_doc_date2.disabled=false;
			}
			parent.frames[1].frames[0].document.forms[0].tot_valid_enc_with_gl.value = '';
			parent.frames[1].frames[0].document.forms[0].tot_valid_op_enc_with_gl.value = '';
			parent.frames[1].frames[0].document.forms[0].tot_valid_ae_enc_with_gl.value = '';
			parent.frames[1].frames[0].document.forms[0].tot_valid_ip_enc_with_gl.value = '';
			parent.frames[1].frames[0].document.forms[0].tot_valid_dc_enc_with_gl.value = '';
			parent.frames[1].frames[0].document.forms[0].tot_valid_enc_with_gl.disabled=false;
			parent.frames[1].frames[0].document.forms[0].tot_valid_op_enc_with_gl.disabled=false;
			parent.frames[1].frames[0].document.forms[0].tot_valid_ae_enc_with_gl.disabled=false;
			parent.frames[1].frames[0].document.forms[0].tot_valid_ip_enc_with_gl.disabled=false;
			parent.frames[1].frames[0].document.forms[0].tot_valid_dc_enc_with_gl.disabled=false;

			parent.frames[1].frames[0].document.forms[0].tot_availed_enc_with_gl.value = '0';
			parent.frames[1].frames[0].document.forms[0].tot_availed_op_enc_with_gl.value = '0';
			parent.frames[1].frames[0].document.forms[0].tot_availed_ae_enc_with_gl.value = '0';
			parent.frames[1].frames[0].document.forms[0].tot_availed_ip_enc_with_gl.value = '0';
			parent.frames[1].frames[0].document.forms[0].tot_availed_dc_enc_with_gl.value = '0';

			parent.frames[1].frames[0].document.forms[0].gl_doc_ref_exist_YN.value = "N";
		}
	}
}

function sel_frm_prev_enc()
{	 
var payerGrpBySetup=document.forms[0].payerGrpBySetup.value;
//alert("payerGrpBySetup"+payerGrpBySetup);
	if(("Y")!= payerGrpBySetup ){
		if(document.forms[0].fin_auth_user_id.value=="")
		{
			return;
		}
	}

	var episode_type = document.forms[0].episode_type.value;
	var patient_id = document.forms[0].patient_id.value;	
	var facility_id=document.forms[0].facility_id.value;
	var calling_module_id=document.forms[0].calling_module_id.value;

	var sys_date= document.forms[0].sys_date.value;	
	var encounter_date= document.forms[0].encounter_date.value;	
	if(encounter_date==null || encounter_date=="")
		encounter_date=sys_date;

	var remarks = document.forms[0].remarks.value;
	remarks = encodeURIComponent(remarks);
	var fin_auth_user_id = document.forms[0].fin_auth_user_id.value;

	var query_string=document.forms[0].query_string.value;	
	var center='1';
	var dialogTop = "110";
	var dialogHeight = "35" ;
	var dialogWidth = "70" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
	var title=getLabel("eBL.PRV_ENCOUNTER_FIN_DETAILS.label","BL");
	title=encodeURIComponent(title);	
	var arguments = "" ;
	var column_sizes = escape("");               
	var column_descriptions ="";		
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&facility_id="+facility_id+"&patient_id="+patient_id+"&calling_module_id="+calling_module_id+"&episode_type="+episode_type+"&title="+title+"&encounter_date="+encounter_date+"&"+query_string;
	

	retVal=window.showModalDialog("../../eBL/jsp/BLPreviousEncounterMain.jsp?"+param,arguments,features);

	if(retVal=="success")
	{
		if(document.forms[0].package_enabled_yn.value == 'Y')
		{
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			var updation=formValidation(xmlStr,"clearBean");
		}
//		parent.frames[1].location.href="../../eBL/jsp/AddModifyPatFinDetails6.jsp?sel_frm_prev_enc=Y&"+query_string;
		parent.frames[0].location.href="../../eBL/jsp/AddModifyPatFinDetails.jsp?sel_frm_prev_enc=Y&remarks="+remarks+"&fin_auth_user_id="+fin_auth_user_id+"&"+query_string;
	}
}

function refsrclkup(ref_code,ref_desc,called_frm,clng_evnt)
{

	var setlmt_ind=document.forms[0].setlmt_ind.value;
	var adm_rec_flag= document.forms[0].adm_rec_flag.value;
	var episode_type=document.forms[0].episode_type.value;
	var locale=document.forms[0].locale.value;
	var billing_group=document.forms[0].billing_group.value;

	if(clng_evnt == 'B')
	{
		if( ref_desc.value == "")
		{	
			ref_code.value = "";
			ref_desc.value = "";
			if(called_frm == "M")
			{
				document.getElementById('pmy_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('pmy_ref_src_lng_name').alt="";
			}
			else if (called_frm == "S")
			{
				document.getElementById('sec_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('sec_ref_src_lng_name').alt="";
			}
			if(setlmt_ind == "X" && adm_rec_flag == "2")
			{
				var total_records=parent.frames[1].frames[0].frames[1].document.forms[0].total_records.value;

				if(total_records > 0)
				{
					for(var i=0;i<total_records;i++)
					{
						var sel_blng_grp=eval("parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_code"+i);

						if(sel_blng_grp.value == billing_group)
						{
							if(called_frm == 'M')
							{
								var ref_src_main_code_for_prmy_blng_grp = eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_main_code"+i);
								ref_src_main_code_for_prmy_blng_grp.value="";

								var ref_src_main_desc_for_prmy_blng_grp = eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_main_desc"+i);
								ref_src_main_desc_for_prmy_blng_grp.value="";

								var blng_grp_visible = eval("parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_visible"+i);
								
								if(blng_grp_visible.value == "Y")
								{
									var pmy_ref_src_lng_name = eval("parent.frames[1].frames[0].frames[1].document.getElementById('pmy_ref_src_lng_name_')"+i);
									pmy_ref_src_lng_name.style.visibility="hidden";
									pmy_ref_src_lng_name.alt="";
								}
							}
							if(called_frm == 'S')
							{
								var ref_src_sub_code_for_prmy_blng_grp = eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_sub_code"+i);
								ref_src_sub_code_for_prmy_blng_grp.value="";

								var ref_src_sub_desc_for_prmy_blng_grp = eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_sub_desc"+i);
								ref_src_sub_desc_for_prmy_blng_grp.value="";
	
								var blng_grp_visible = eval("parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_visible"+i);

								if(blng_grp_visible.value == "Y")
								{
									var sec_ref_src_lng_name = eval("parent.frames[1].frames[0].frames[1].document.getElementById('sec_ref_src_lng_name_')"+i);
									sec_ref_src_lng_name.style.visibility="hidden";
									sec_ref_src_lng_name.alt="";
								}
							}
						}
					}
				}
			}
			return;
		}
	}

	var retVal			= new String();		
	var dialogTop			= "130";
	var dialogHeight		= "32" ;
	var dialogWidth			= "60" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";		
		
	var title=getLabel("Common.referralsource.label","common");
	title=encodeURIComponent(title);
	var column_sizes = escape("20%,20%,20%,30%,10%");               

	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var short_desc=getLabel("Common.shortdescription.label","common");
	short_desc=encodeURIComponent(short_desc);
	var long_desc=getLabel("Common.longdescription.label","common");
	long_desc=encodeURIComponent(long_desc);
	var long_name=getLabel("Common.longname.label","common");
	long_name=encodeURIComponent(long_name);
	var org_type=getLabel("Common.OrganisationType.label","common");
	org_type=encodeURIComponent(org_type);
	var column_descriptions = code+","+short_desc+","+long_desc+","+long_name+","+org_type;

	var gov_leg = getLabel("eBL.GOVT_REFERRAL.label","BL");
	gov_leg=encodeURIComponent(gov_leg);

	var pvt_leg = getLabel("eBL.PVT_REFERRAL.label","BL");
	pvt_leg=encodeURIComponent(pvt_leg);

	var message = '';
		
	if (billing_group.length == 0) return;

	var sql="called_for=REFSRCLKUP&locale="+locale+"&episode_type="+episode_type;

//	var sql="Select REFERRAL_CODE REFERRAL_CODE,SHORT_DESC SHORT_DESC,LONG_DESC LONG_DESC,LONG_NAME LONG_NAME,decode(ORG_TYPE,'G','"+gov_leg+"','P','"+pvt_leg+"') ORG_TYPE from AM_REFERRAL_LANG_VW where (('"+episode_type+"' = 'R' and SOURCE_USE_AT_REGN_YN='Y') or ('"+episode_type+"' in ('O','E') and SOURCE_USE_AT_VISIT_YN ='Y') or ('"+episode_type+"' in ('I','D') and SOURCE_USE_AT_ADM_YN ='Y')) and language_id = '"+locale+"' and nvl(eff_status,'E')='E'";

//	sql = escape(sql);					

//	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(ref_desc.value)+"&srch_by_clmn_index=3"+"&col_show_hide=YYYYY";
	
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+sql+"&"+"message="+message+"&target="+encodeURIComponent(ref_desc.value)+"&srch_by_clmn_index=3"+"&col_show_hide=YYYYY";

	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);	

	var arr=new Array();					
		
	if(retVal == null) retVal='';	
	
	if (retVal != null || retVal != "")
	{	
		var retVal=unescape(retVal);				

		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");				   

			ref_code.value=arr[0];
			ref_desc.value=arr[2];
			var ref_src_lng_name = arr[3];

			if(called_frm == "M")
			{
				if(ref_src_lng_name != "")
				{
					document.getElementById('pmy_ref_src_lng_name').style.visibility="visible";
					document.getElementById('pmy_ref_src_lng_name').alt=arr[3];
				}
				else
				{
					document.getElementById('pmy_ref_src_lng_name').style.visibility="hidden";
				}
			}
			else if (called_frm == "S")
			{
				if(ref_src_lng_name != "")
				{
					document.getElementById('sec_ref_src_lng_name').style.visibility="visible";
					document.getElementById('sec_ref_src_lng_name').alt=arr[3];
				}
				else
				{
					document.getElementById('sec_ref_src_lng_name').style.visibility="hidden";
				}
			}

			if(setlmt_ind == "X" && adm_rec_flag == "2")
			{
				var total_records=parent.frames[1].frames[0].frames[1].document.forms[0].total_records.value;

				if(total_records > 0)
				{
					for(var i=0;i<total_records;i++)
					{
						var sel_blng_grp=eval("parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_code"+i);
						if(sel_blng_grp.value == billing_group)
						{
							if(called_frm == 'M')
							{
								var ref_src_main_code_for_prmy_blng_grp = eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_main_code"+i);
								ref_src_main_code_for_prmy_blng_grp.value=arr[0];

								var ref_src_main_desc_for_prmy_blng_grp = eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_main_desc"+i);
								ref_src_main_desc_for_prmy_blng_grp.value=arr[2];

								var blng_grp_visible = eval("parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_visible"+i);
								
								if(blng_grp_visible.value == "Y")
								{
									if(ref_src_lng_name != "")
									{
										var pmy_ref_src_lng_name = eval("parent.frames[1].frames[0].frames[1].document.getElementById('pmy_ref_src_lng_name_')"+i);

										pmy_ref_src_lng_name.style.visibility="visible";
										pmy_ref_src_lng_name.alt=arr[3];
									}
									else
									{
										var pmy_ref_src_lng_name = eval("parent.frames[1].frames[0].frames[1].document.getElementById('pmy_ref_src_lng_name_')"+i);
										pmy_ref_src_lng_name.style.visibility="hidden";
										pmy_ref_src_lng_name.alt="";
									}
								}
							}
							if(called_frm == 'S')
							{
								var ref_src_sub_code_for_prmy_blng_grp = eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_sub_code"+i);
								ref_src_sub_code_for_prmy_blng_grp.value=arr[0];

								var ref_src_sub_desc_for_prmy_blng_grp = eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_sub_desc"+i);
								ref_src_sub_desc_for_prmy_blng_grp.value=arr[2];

								var blng_grp_visible = eval("parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_visible"+i);
								
								if(blng_grp_visible.value == "Y")
								{
									if(ref_src_lng_name != "")
									{
										var sec_ref_src_lng_name = eval("parent.frames[1].frames[0].frames[1].document.getElementById('sec_ref_src_lng_name_')"+i);

										sec_ref_src_lng_name.style.visibility="visible";
										sec_ref_src_lng_name.alt=arr[3];
									}
									else
									{
										var sec_ref_src_lng_name = eval("parent.frames[1].frames[0].frames[1].document.getElementById('sec_ref_src_lng_name_')"+i);
										sec_ref_src_lng_name.style.visibility="hidden";
										sec_ref_src_lng_name.alt="";
									}
								}
							}
						}
					}

				}
			}
		}	
		else
		{
			ref_code.value="";
			ref_desc.value="";
			if(called_frm == "M")
			{
				document.getElementById('pmy_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('pmy_ref_src_lng_name').alt="";
			}
			else if (called_frm == "S")
			{
				document.getElementById('sec_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('sec_ref_src_lng_name').alt=arr[3];
			}

			if(setlmt_ind == "X" && adm_rec_flag == "2")
			{
				var total_records=parent.frames[1].frames[0].frames[1].document.forms[0].total_records.value;

				if(total_records > 0)
				{
					for(var i=0;i<total_records;i++)
					{
						var sel_blng_grp=eval("parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_code"+i);
						if(sel_blng_grp.value == billing_group)
						{
							if(called_frm == 'M')
							{
								var ref_src_main_code_for_prmy_blng_grp = eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_main_code"+i);
								ref_src_main_code_for_prmy_blng_grp.value="";

								var ref_src_main_desc_for_prmy_blng_grp = eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_main_desc"+i);
								ref_src_main_desc_for_prmy_blng_grp.value="";

								var blng_grp_visible = eval("parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_visible"+i);
								
								if(blng_grp_visible.value == "Y")
								{
									var pmy_ref_src_lng_name = eval("parent.frames[1].frames[0].frames[1].document.getElementById('pmy_ref_src_lng_name_')"+i);
									pmy_ref_src_lng_name.style.visibility="hidden";
									pmy_ref_src_lng_name.alt="";
								}
							}
							if(called_frm == 'S')
							{
								var ref_src_sub_code_for_prmy_blng_grp = eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_sub_code"+i);
								ref_src_sub_code_for_prmy_blng_grp.value="";

								var ref_src_sub_desc_for_prmy_blng_grp = eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_sub_desc"+i);
								ref_src_sub_desc_for_prmy_blng_grp.value="";
	
								var blng_grp_visible = eval("parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_visible"+i);

								if(blng_grp_visible.value == "Y")
								{
									var sec_ref_src_lng_name = eval("parent.frames[1].frames[0].frames[1].document.getElementById('sec_ref_src_lng_name_')"+i);
									sec_ref_src_lng_name.style.visibility="hidden";
									sec_ref_src_lng_name.alt="";
								}
							}
						}
					}
				}
			}
		}
	}
	else
	{
		ref_code.value="";
		ref_desc.value="";
		if(setlmt_ind == "X" && adm_rec_flag == "2")
		{
			var total_records=parent.frames[1].frames[0].frames[1].document.forms[0].total_records.value;

			if(total_records > 0)
			{
				for(var i=0;i<total_records;i++)
				{
					var sel_blng_grp=eval("parent.frames[1].frames[0].frames[1].document.forms[0].blng_grp_code"+i);
					if(sel_blng_grp.value == billing_group)
					{
						if(called_frm == 'M')
						{
							var ref_src_main_code_for_prmy_blng_grp = eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_main_code"+i);
							ref_src_main_code_for_prmy_blng_grp.value="";

							var ref_src_main_desc_for_prmy_blng_grp = eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_main_desc"+i);
							ref_src_main_desc_for_prmy_blng_grp.value="";
						}
						if(called_frm == 'S')
						{
							var ref_src_sub_code_for_prmy_blng_grp = eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_sub_code"+i);
							ref_src_sub_code_for_prmy_blng_grp.value="";

							var ref_src_sub_desc_for_prmy_blng_grp = eval("parent.frames[1].frames[0].frames[1].document.forms[0].referral_source_sub_desc"+i);
							ref_src_sub_desc_for_prmy_blng_grp.value="";
						}
					}
				}

			}
		}
	}

}

function chng_class_for_inv_pyrs_on_rfrsh()
{
	var setlmt_ind=document.forms[0].setlmt_ind.value;
	var adm_rec_flag=document.forms[0].adm_rec_flag.value;
	var qry_odd_evn_chng_class="";

	if(setlmt_ind=="X" && adm_rec_flag=="2")
	{
		var total_records=parent.frames[1].frames[0].frames[1].document.forms[0].total_records.value;

		for (var j=0;j<parent.frames[1].frames[0].frames[1].document.getElementById('ins_data').rows.length;j++)
		{
			if(parent.frames[1].frames[0].frames[1].document.getElementById('ins_data').rows[j].cells[0].className == "QRYEVEN")
				qry_odd_evn_chng_class="QRYODD";

			if(parent.frames[1].frames[0].frames[1].document.getElementById('ins_data').rows[j].cells[0].className == "QRYODD")
				qry_odd_evn_chng_class="QRYEVEN";

			if(parent.frames[1].frames[0].frames[1].document.getElementById('ins_data').rows[j].cells[0].className == "PATIENTLINECOLOR" && j==0)
				qry_odd_evn_chng_class="QRYEVEN";

			if(parent.frames[1].frames[0].frames[1].document.getElementById('ins_data').rows[j].cells[0].className == "RED")
			{
				parent.frames[1].frames[0].frames[1].document.getElementById('ins_data').rows[j].cells[0].className = qry_odd_evn_chng_class;
			}
		}
		
		for(var i=0;i<total_records;i++)
		{
			var ins_blng_grp_code1=eval("parent.frames[1].frames[0].frames[1].document.forms[0].billing_group_desc"+i);
	
			if(ins_blng_grp_code1.className == 'BACKGROUND')
			{
				ins_blng_grp_code1.className='';
			}
		}
	}
}

function curr_code()
{
	var currency_desc_for_bg = document.forms[0].currency_desc_for_bg.value;

	if(currency_desc_for_bg != "")
	{
		document.getElementById('bg_curr_desc_disp').style.display="inline";
		document.getElementById('bg_curr_desc').innerText=currency_desc_for_bg;
	}
	else
	{
		document.getElementById('bg_curr_desc_disp').style.display="none";
		document.getElementById('bg_curr_desc').innerText="";

	}
}

async function view_trmt_pkg_dtl()
{
	var locale = document.forms[0].locale.value;
	var patient_id = document.forms[0].patient_id.value;
	var blng_grp_id = document.forms[0].billing_group.value;
	var encounter_date = document.forms[0].encounter_date_aft_trunc.value;
	encounter_date = convertDate(encounter_date,'DMY',locale,"en");
	var blnggrp	= document.forms[0].blnggrp.value;
	var ExtBillingGroup = document.forms[0].ext_billing_group.value;
	var strCitizenYn = document.forms[0].CitizenYn.value;


	var retVal;
	var dialogHeight= "35" ;
	var dialogWidth	= "70" ;
	var dialogTop = "140" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var url = "../../eBL/jsp/BLViewTrmtPkgDtlsMain.jsp?patient_id="+patient_id+"&blng_grp_id="+blng_grp_id+"&encounter_date="+encounter_date+"&cald_with_bg_YN=Y&cald_frm=REG&blnggrp="+blnggrp+"&citizen_yn="+strCitizenYn+"&ext_billing_group="+ExtBillingGroup;
	retVal =await window.showModalDialog(url,arguments,features);
}

async function call_pkg_win()
	{ 
		var valid_pkg_for_pat_bg_avail_YN=document.forms[0].valid_pkg_for_pat_bg_avail_YN.value;
		var valid_pkg_for_pat_avail_YN=document.forms[0].valid_pkg_for_pat_avail_YN.value;

		if(valid_pkg_for_pat_avail_YN == 'Y')
		{
			var locale = document.forms[0].locale.value;
			var billing_group=document.forms[0].billing_group.value;
			var patient_id=document.forms[0].patient_id.value;	
			var encounter_date_aft_trunc = document.forms[0].encounter_date_aft_trunc.value;
			var blnggrp	= document.forms[0].blnggrp.value;
			var ExtBillingGroup = document.forms[0].ext_billing_group.value;
			var strCitizenYn = document.forms[0].CitizenYn.value;
			
			encounter_date_aft_trunc = convertDate(encounter_date_aft_trunc,'DMY',locale,"en");

			if(billing_group!="" &&  patient_id != "")
			{
				var retVal;
				var dialogHeight= "35" ;
				var dialogWidth	= "70" ;
				var dialogTop = "140" ;
				var center = "1" ;														   
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;
				var url = "../../eBL/jsp/BLViewTrmtPkgDtlsMain.jsp?patient_id="+patient_id+"&blng_grp_id="+billing_group+"&encounter_date="+encounter_date_aft_trunc+"&blnggrp="+blnggrp+"&citizen_yn="+strCitizenYn+"&ext_billing_group="+ExtBillingGroup+"&cald_frm=REG";
				retVal =await window.showModalDialog(url,arguments,features);

				if(retVal == "undefined" || retVal == undefined || retVal == null) retVal="";
				if(retVal != "")
				{
					var arr = retVal.split("||");					

					document.forms[0].selecltd_bg_frm_pkg.value = arr[0];
					document.forms[0].selecltd_bg_desc_frm_pkg.value = arr[1];
					document.forms[0].selecltd_cust_grp_frm_pkg.value = arr[2];
					document.forms[0].selecltd_cust_frm_pkg.value = arr[3];
					document.forms[0].blng_grp_sel_frm_pkg_YN.value = "Y";

	//				alert(getMessage("BL6347","BL"));
					document.getElementById('modify_button').click();
				}
			}
		}
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
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</head>
<%
		

		if(((operation.equals("Update")) || (display.equals("Y")) || 
		( boolSecurity == true) ) && (strModuleId.equals("MP") || (strdfltbgyn.equals("Y") && (!(strModuleId.equals("MP")))) ) )
		{
			if(!("Y").equalsIgnoreCase(payerGrpBySetup))
			{
			
%>
<body onLoad='disableAllElements();callBlnggrp();curr_code();call_pkg_win();pkgSubsMsgDisplay();disable1();' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
			}
			else
			{
%>	
<body onLoad='validate();callBlnggrp();curr_code();call_pkg_win();disableModifyButton();pkgSubsMsgDisplay();disable1();' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
			}
		}
		else if (strRepositoryYN.equals("Y") && strModuleId.equals("MP") )
		{

%>
<body onLoad='disableMappingItemsAll();callBlnggrp();curr_code();call_pkg_win();pkgSubsMsgDisplay();disable1();' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%	
		}
		else if ((strdfltbgyn.equals("N")||strModuleId.equals("MP")) && (operation.equals("Update")))
		{		
			System.out.println("3");
%>
<body onLoad='disableModifyButton();callBlnggrp();curr_code();call_pkg_win();pkgSubsMsgDisplay();disable1();' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		}
		else if (operation.equals("Insert") && !strBillGrpId.equals("") && !strModuleId.equals("MP"))
		{		
			System.out.println("4");
%>
<body onLoad='disableModifyButton();callBlnggrp();curr_code();call_pkg_win();pkgSubsMsgDisplay();disable1();' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		}
		else
		{
			System.out.println("5");
%>
<body onLoad='curr_code();call_pkg_win();pkgSubsMsgDisplay();disable1();' onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 

<%
		}
%>
<%
				/******
		try
		{

			pstmt = con.prepareStatement( " select  NVL(HEALTH_CARD_APPL_YN,'N')    from   bl_blng_grp x,bl_patient_fin_dtls y where x.BLNG_GRP_ID=y.BLNG_GRP_ID and PATIENT_ID='"+patient_id+"'" ) ;

			pstmt = con.prepareStatement( " select  NVL(HEALTH_CARD_APPL_YN,'N')    from   bl_blng_grp_vw x  where x.BLNG_GRP_ID='"+mbilling_group+"'" ) ;

			rs = pstmt.executeQuery() ;
			if( rs != null )
			{
				while( rs.next() ) 
				{
					strHealthCard_YN = rs.getString(1);
				}
			}
			pstmt.close() ;
		}
		catch(Exception sqlException)
		{
			out.println("Err :"+sqlException);
		}
					*****/
		/**************** 
			If the Health Card is Ex, then
			the Default Billing Group is taken
			Correction	: Murugavel.
			Reason  	: Additional Validation for the Health Card.
			Date		: 13/08/2002	


		if (strHealthCardExpired_YN.equals("Y") || (strHealthCard_YN.equals("Y") && alt_id1_exp_date.equals(""))) 
		{
			
			try
			{
				strQuery = " select DEF_BLNG_GRP_FOR_EXPIRED_HC,SHORT_DESC, "+ 
						"	nvl(HEALTH_CARD_APPL_YN,'N') "+        
						" from BL_PARAMETERS,bl_BLNG_GRP_vw "+
						" where BLNG_GRP_ID=DEF_BLNG_GRP_FOR_EXPIRED_HC and "+
						" operating_facility_id = '"+facility_id+"'";

				pstmt = con.prepareStatement(strQuery); 
				rs = pstmt.executeQuery() ;
				if( rs != null )
				{
					while( rs.next() ) 
					{						
						strDfltBillingGroup = rs.getString(1);
						strDfltBillingGroupDesc = rs.getString(2);
						strDefHealthCard_YN = rs.getString(3);
					}
				}
				pstmt.close() ;
			}
			catch(Exception sqlException)
			{
				out.println("Err :"+sqlException);
			}
		}

		************/		

		
%>      

<form name='PatFinMainForm' id='PatFinMainForm' method='post'   scrolling=no >

<!-- The following changes are done for Internationalisation Process
Cellpadding changed from 1 to 3 by Manivel Natarajan on 10/Aug/2006 -->

<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
<tr>
	
	 <%
//System.out.println("Checking the strBillingQuery:"+strBillingQuery);
		pstmt = con.prepareStatement( strBillingQuery ) ;
		rs = pstmt.executeQuery();
//System.out.println("Checking the exception:"+strBillingQuery);
		if( rs != null )
		{
			String blng_grp_id = strExtBillingGroup;
			String short_desc = strExtBillingGroup;	

			boolean boolRecordFound = false;
			while( rs.next() ) 
			{
				blng_grp_id = rs.getString( "blng_grp_id" ) ;
				short_desc = rs.getString( "short_desc" ) ;			


				if(blng_grp_id.equals(strBillGrpId))
				{
					str_blng_grp_id = rs.getString( "blng_grp_id" ) ;
					 str_short_desc = rs.getString( "short_desc" ) ;
				}
		
				strArrayHealthCard_YN = strArrayHealthCard_YN + (blng_grp_id+"-"+rs.getString(3)+"|");	
				strArrayBillingApp_YN = strArrayBillingApp_YN + rs.getString(4)+"|";	

				if (strSpecialSchemeBlngGrp.equals(blng_grp_id))
					strSplSchemeBlngGrpPresent = "1"; 

				if (mbilling_group.equals(blng_grp_id))		
				{
					strBlngGrpAppYN = rs.getString(4);
					strBlngGrpStatus = rs.getString("status");
					strCategory = rs.getString("category");
			
					if (strBlngGrpAppYN== null ||strBlngGrpAppYN.equals("null"))
						strBlngGrpAppYN = "N";		
					if(strBlngGrpStatus == null ||strBlngGrpStatus.equals("null")) 
						strBlngGrpStatus="";
					if(strCategory == null ||strBlngGrpAppYN.equals("null") || strCategory.equals("")) 
						strCategory="UNRESTRICTED";					
//					strCategory="";

					if (strCitizenYn.equals("Y"))
					{
						if (strCategory.equals("UNRESTRICTED") || strCategory.equals("NATIONALS"))
						{
							strBlngGrpCatgAppYN = "Y";
						}
						else
						{
							strBlngGrpCatgAppYN = "N";
						}
					}
					else
					{
						if (strCategory.equals("UNRESTRICTED") || strCategory.equals("OTHERS"))
						{
							strBlngGrpCatgAppYN = "Y";
						}
						else
						{
							strBlngGrpCatgAppYN = "N";
						}
					}
				}

				if (boolChangeBillQry == false)
				{
					if((mbilling_group.equals(blng_grp_id)) && ((strdfltbgyn.equals("Y") && (!(strModuleId.equals("MP"))))||strModuleId.equals("MP")))
					{
						str_blng_grp_id = blng_grp_id;
						str_short_desc = short_desc;
					}
					else
					{																

					}
				}
				else
				{
						str_blng_grp_id = blng_grp_id;
						str_short_desc = short_desc;
				}
				boolRecordFound = true;
//						System.out.println("testing3");			
			}
			if ((boolRecordFound == false) && (boolChangeBillQry == true))
			{
				str_blng_grp_id = blng_grp_id;
				str_short_desc = short_desc;
			}	
			
			//Rajesh V 
			if((str_blng_grp_id != null) && (!("".equals(str_blng_grp_id)))){
				CallableStatement callInt = con.prepareCall("{call  blhealthcard.get_hcard_enable_yn(?,?,SYSDATE,?,?,?,?,null,null)}");	
	
				callInt.setString(1,facility_id);
				callInt.setString(2,patient_id);
				callInt.registerOutParameter(3,java.sql.Types.VARCHAR);
				callInt.setInt(4,0);
				callInt.setInt(5,0);
				callInt.setString(6,str_blng_grp_id);
				callInt.execute();	
				hCardYn = callInt.getString(3);
				//out.println(hCardYn);
				callInt.close();
			}
			//System.err.println("From JSP ->"+hCardYn+"-"+facility_id+"-"+patient_id+"-"+str_blng_grp_id);

			//Rajesh V
		}

		if (strSplSchemeBlngGrpPresent== null||strSplSchemeBlngGrpPresent.equals("null"))		
			strSplSchemeBlngGrpPresent="0";		

		if (rs != null) rs.close();
		pstmt.close();	

		if(!str_blng_grp_id.equals(""))
		{
			String currency_desc_for_bg_qry="Select CURRENCY_CODE,CURRENCY_DESC,PR_PAYER_EMPLOYER_ID_MAND_YN,PACKAGE_YN,nvl(CAPTURE_REF_SOURCE_DTL_YN,'N'),nvl(REF_SOURCE_MAIN_MAND_YN,'N'),nvl(REF_SOURCE_SUB_MAND_YN,'N') from bl_blng_grp_lang_vw where blng_grp_id='"+str_blng_grp_id+"' and language_id='"+locale+"'";
//			System.out.println("currency_desc_for_bg_qry:"+currency_desc_for_bg_qry);
			pstmt = con.prepareStatement( currency_desc_for_bg_qry ) ;
			rs = pstmt.executeQuery();

			if( rs != null )
			{
				while( rs.next() ) 
				{
					str_currency_code_for_bg = rs.getString(1);
					str_currency_desc_for_bg = rs.getString(2);
					str_payer_emp_id_mand_yn = rs.getString(3);
					str_is_blng_grp_pkg_link_YN = rs.getString(4);
					referral_source_capture_YN = rs.getString(5);
					referral_source_main_mand_YN = rs.getString(6);
					referral_source_sub_mand_YN = rs.getString(7);
				}
				if (rs != null) rs.close();
				pstmt.close();	
			}
			if(str_currency_code_for_bg == null) str_currency_code_for_bg="";
			if(str_currency_desc_for_bg == null) str_currency_desc_for_bg="";
			if(str_payer_emp_id_mand_yn == null) str_payer_emp_id_mand_yn="N";
			if(str_is_blng_grp_pkg_link_YN == null) str_is_blng_grp_pkg_link_YN="N";

/*			
			if(!patient_id.equals(""))
			{
				String str_pkg_rel_blng_grp = "";
				String valid_pkg_for_bg_avail_YN_qry="Select 'Y',blng_grp_id from BL_PATIENT_PACKAGE_HDR where  PATIENT_ID='"+patient_id+"' and STATUS = 'O' and facility_id='"+facility_id+"' and to_date('"+com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY",locale,"en")+"','DD/MM/YYYY') between EFF_DATE_FROM and nvl(EFF_DATE_FROM,to_date('"+com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY",locale,"en")+"','DD/MM/YYYY') ";
				System.out.println("valid_pkg_for_bg_avail_YN_qry:"+valid_pkg_for_bg_avail_YN_qry);
				pstmt = con.prepareStatement( valid_pkg_for_bg_avail_YN_qry ) ;
				rs = pstmt.executeQuery();

				if( rs != null )
				{
					while( rs.next() ) 
					{
						str_valid_pkg_for_bg_avail_YN = rs.getString(1);
						str_pkg_rel_blng_grp = rs.getString(2);
					}
					rs.close();
					pstmt.close();	
					if(str_valid_pkg_for_bg_avail_YN == null) str_valid_pkg_for_bg_avail_YN="N";
					if(str_pkg_rel_blng_grp == null) str_pkg_rel_blng_grp="";
				}
				if(str_valid_pkg_for_bg_avail_YN.equals("Y"))
				{
					str_valid_pkg_for_pat_id_YN = "Y";
				}
				else
				{
					str_valid_pkg_for_pat_id_YN = "N";
				}

				if(str_pkg_rel_blng_grp.equals(str_blng_grp_id))
				{
					str_valid_pkg_for_bg_avail_YN = "Y";
				}
				else
				{
					str_valid_pkg_for_bg_avail_YN = "N";
				}
			}
*/
			if(!patient_id.equals(""))
			{
				try
				{
//					System.out.println("encounter_date_aft_trunc:"+encounter_date_aft_trunc);
					call_pkg = con.prepareCall("{ ? = call  blcore.package_blng_grp_yn(?,?,?,?,?,to_date(?,'DD/MM/YYYY'),?,?)}");
					call_pkg.registerOutParameter(1,java.sql.Types.VARCHAR);

					call_pkg.setString(2,facility_id);
					call_pkg.setString(3,patient_id);
					call_pkg.setString(4,strEpisodeType);
					call_pkg.setString(5,strFunctionId);
					call_pkg.setString(6,str_blng_grp_id);
					call_pkg.setString(7,com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY",locale,"en"));
					call_pkg.setString(8,"P");
					if(strCitizenYn.equals("Y"))
					{
						call_pkg.setString(9,"NATIONALS");
					}
					else
					{
						call_pkg.setString(9,"OTHERS");
					}

					call_pkg.execute();							
					str_valid_pkg_for_pat_avail_YN = call_pkg.getString(1);				
					call_pkg.close();
					if ( str_valid_pkg_for_pat_avail_YN == null ) str_valid_pkg_for_pat_avail_YN = "";

					call_pkg = con.prepareCall("{ ? = call  blcore.package_blng_grp_yn(?,?,?,?,?,to_date(?,'DD/MM/YYYY'),?,?)}");
					call_pkg.registerOutParameter(1,java.sql.Types.VARCHAR);

					call_pkg.setString(2,facility_id);
					call_pkg.setString(3,patient_id);
					call_pkg.setString(4,strEpisodeType);
					call_pkg.setString(5,strFunctionId);
					call_pkg.setString(6,str_blng_grp_id);
					call_pkg.setString(7,com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY",locale,"en"));
					call_pkg.setString(8,"B");
					if(strCitizenYn.equals("Y"))
					{
						call_pkg.setString(9,"NATIONALS");
					}
					else
					{
						call_pkg.setString(9,"OTHERS");
					}

					call_pkg.execute();							
					str_valid_pkg_for_pat_bg_avail_YN = call_pkg.getString(1);				
					call_pkg.close();

					
					if ( str_valid_pkg_for_pat_bg_avail_YN == null ) str_valid_pkg_for_pat_bg_avail_YN = "";
				}
				catch(Exception e)
				{
					System.out.println("Exception while chekcing package:"+e.toString());
					out.println("Exception while chekcing package:"+e.toString());
				}
				
				if(str_is_blng_grp_pkg_link_YN.equals("Y") && str_valid_pkg_for_pat_bg_avail_YN.equals("N"))
				{
					str_blng_grp_id = "" ;
					str_short_desc = "" ;
%>
					<script>alert(getMessage("BL6360","BL"));</script>

<%
				}
			}
		}

		if (strModuleId.equals("MP"))
		{ 
	%>

	<td width="25%" class="label"><a href="javascript:getBlngGrpSearch();"><fmt:message key="eBL.PRIMARY_BILLING_GROUP.label" bundle="${bl_labels}"/></a>&nbsp;&nbsp;<div id="bg_curr_desc_disp" style="display:inline"><Font color='red'><b id="bg_curr_desc"></b></font></div></td>
	<%	
		}
		else
		{
	%>		
	<td width="25%" class="label"><a href="javascript:getBlngGrpSearch();"><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;<div id="bg_curr_desc_disp" style="display:inline"><Font color='red'><b id="bg_curr_desc"></b></font></div></td>
	 <%
		}
	 %>
	 <!-- Added By Rajesh V - for CRF-155 -->
	 <%	

	 if("Y".equals(payerGrpBySetup)){ %>
		 <td class='fields' width="25%" nowrap><input type='text' name="billing_group_desc" id="billing_group_desc" maxlength='40' size='40' tabindex='0' value="<%=str_short_desc%>" onBlur="return blnggrplkupNew('B')"><input type='button' class='button' name="blnggrpbut" id="blnggrpbut" value='?' onClick="return blnggrplkupNew('C')" tabindex='0'><img src='../../eCommon/images/mandatory.gif'>
	 <%}
	 else{%>		 
		 <td class='fields' width="25%" nowrap><input type='text' name="billing_group_desc" id="billing_group_desc" maxlength='40' size='40' tabindex='0' value="<%=str_short_desc%>" onBlur="return blnggrplkup('B')"><input type='button' class='button' name="blnggrpbut" id="blnggrpbut" value='?' onClick="return blnggrplkup('C')" tabindex='0'><img src='../../eCommon/images/mandatory.gif'>
	 <%}%>
	  
	 <!-- Added By Rajesh V - for CRF-155 -->	
	<% 	

	//	if(strModuleId.equals("MP") &&strFunctionId.equals("PAT_REG") &&  str_short_desc.length() > 0 ) 
		
		if((strModuleId.equals("MP")) && (strFunctionId.equals("PAT_REG")) && (patient_id.length()>0))
		//	if((cur_patient_id.length()>0)&& strModuleId.equals("MP")&&(strFunctionId.equals("PAT_REG"))
		{ %>

	<a href="javascript:uploadImage()" id='insImage'>Upload Insurance Doc </a>
	<%}	%>
	<!-- Rajesh V -->
	<%if("Y".equals(hCardYn)){ %>
		<div id='ref_active_health_card_link' style='display:inline'><a href="javascript:activeHealthCard();"><fmt:message key="eBL.ActiveHealthCard.label" bundle="${bl_labels}"/></a>
		</div>
	<%}
	else{%>
		<div id='ref_active_health_card_link' style='display:none'><a href="javascript:activeHealthCard();"><fmt:message key="eBL.ActiveHealthCard.label" bundle="${bl_labels}"/></a>
		</div>
	<%} %>
	

	<!-- Rajesh V -->
	</td>

	<input type= "hidden" name="billing_group" id="billing_group"  value="<%=str_blng_grp_id%>">
	<input type= "hidden" name="PAYER_EMP_ID_MAND_YN" id="PAYER_EMP_ID_MAND_YN"  value="<%=str_payer_emp_id_mand_yn%>">
	<input type= "hidden" name="currency_code_for_bg" id="currency_code_for_bg"  value="<%=str_currency_code_for_bg%>">
	<input type= "hidden" name="currency_desc_for_bg" id="currency_desc_for_bg"  value="<%=str_currency_desc_for_bg%>">
	<input type= "hidden" name="is_blng_grp_pkg_link_YN" id="is_blng_grp_pkg_link_YN"  value="<%=str_is_blng_grp_pkg_link_YN%>">
	<input type= "hidden" name="sel_bg_has_valid_pkg_YN" id="sel_bg_has_valid_pkg_YN"  value="">	
	<input type= "hidden" name="valid_pkg_for_pat_avail_YN" id="valid_pkg_for_pat_avail_YN"  value="<%=str_valid_pkg_for_pat_avail_YN%>">	
	<input type= "hidden" name="valid_pkg_for_pat_bg_avail_YN" id="valid_pkg_for_pat_bg_avail_YN"  value="<%=str_valid_pkg_for_pat_bg_avail_YN%>">	



<%
		if(strModuleId.equals("@@@") && (operation.equals("Insert")))
		{
%>
	<td width="25%"  class="label" id='BC1'><fmt:message key="Common.BillingClass.label" bundle="${common_labels}"/></td>
	<td width="25%"  class='fields' id='BC2'><select name="billing_class" id="billing_class" tabIndex='2'><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>

<%
			pstmt = con.prepareStatement( "select blng_class_code, short_desc from bl_blng_class_lang_vw where 	nvl(status,'X') !='S' order by 2" ) ;
			rs1 = pstmt.executeQuery() ;
			if( rs1 != null ) 
			{
				while( rs1.next() ) 
				{
					String blng_class_code = rs1.getString( "blng_class_code" ) ;
					String short_desc = rs1.getString( "short_desc" ) ;
					if(mbilling_class.equals(blng_class_code))
					{
						out.println("<option selected value=\""+blng_class_code+"\">"+short_desc+"</option>");
					}
					else
					{
						out.println("<option value=\""+blng_class_code+"\">"+short_desc+"</option>");
					}
				}
			}
			if(rs1 !=null) rs1.close();
			pstmt.close() ;		
%>      
 </select><img src='../../eCommon/images/mandatory.gif'></td>
<%
		}
		else 
	    {	
%>
	<!--	<td width="25%"  class="label" id='BC1' ></td> -->
	<!--	<td width="" ><input type='hidden' name='billing_class' id='billing_class' value=''>
		<b class="label" id="patientSchemeID"> </b>	</td> -->
<input type='hidden' name='billing_class' id='billing_class' value="<%=mbilling_class%>">
<b class="label" id="patientSchemeID"> </b> 

<%
	    }
		if(operation.equals("Update")||(boolSecurity == true))
		{

%>
<td width="25%" class="label"></td>
<td width="25%" class="button">
<input type=button class='button' name='modify_button' id='modify_button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")%>"  onClick='return funModifyPatDet("<%=upd_pat_flag%>",document.forms[0].sel_frm_prev_enc);'>
<input type=button class='button' name='close_button' id='close_button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='payerstatus();return sendBackFinDetails();'></td>
<%
		}
		else
		{
		%>
<td width="25%" class="label"></td>
<td width="25%" class="fields">
<input type=button class='button' name='close_button' id='close_button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='return sendBackFinDetails();'></td>
</td>
<%
		}
%>
</tr>

<tr>
<%  
		if (capture_employer_id_yn.equals("N"))
		{
%>
<input type='hidden' name='employer_code' id='employer_code' value=""></input>  
<div id='emp_id_mand_YN_disp' style='display:none'><img src='../../eCommon/images/mandatory.gif'></div>
<td width="25%" class="label"></td>
<td width="25%" class="label"></td>
<%
		}
		else
		{
%>
<td width="25%"  class="label" ><fmt:message key="eBL.EMPLOYER_NAME.label" bundle="${bl_labels}"/></td>
<td width="25%"  class='fields' ><select name="employer_code" id="employer_code" tabIndex='3'><option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
			pstmt = con.prepareStatement( "select cust_code, short_name from bl_emp_ins_mst_lang_vw where language_id='"+locale+"' and  nvl(insurance_yn,'N')='N' and status is null order by 2" );
			rs1 = pstmt.executeQuery() ;
			if( rs1 != null ) 
			{
				while( rs1.next() ) 
				{
					String cust_code = rs1.getString( "cust_code" ) ;
					String short_name = rs1.getString( "short_name" ) ;
					if(memployer_code.equals(cust_code))
					{
						out.println("<option selected value=\""+cust_code+"\">"+short_name+"</option>");
					}
					else
					{
						out.println("<option value=\""+cust_code+"\">"+short_name+"</option>");
					}
				}
			}
			if(rs1 !=null) rs1.close();
			pstmt.close() ;
%>      
</select>
<%
	if(str_payer_emp_id_mand_yn.equals("Y"))
	{
%>
<div id='emp_id_mand_YN_disp' style='display:inline'><img src='../../eCommon/images/mandatory.gif'></div>
<%
	}
	else
	{
%>
<div id='emp_id_mand_YN_disp' style='display:none'><img src='../../eCommon/images/mandatory.gif'></div>
<%
	}
%>
</td>
<% 
		}

		if(package_flag.equals("Y"))
		{
%>
<td width="25%" class="labels">
<a href="javascript:getPackageBill('<%=pkg_bill_type%>','<%=pkg_bill_no%>','<%=patient_id%>');"><fmt:message key="eBL.PACKAGE_BILL.label" bundle="${bl_labels}"/></a>
</td>

<td width="25%"  class='fields' >
<input type='text' name='package_bill_ref' id='package_bill_ref'  size=15 maxlength=15 readonly value="<%=pkg_bill_type%>"><input type='text' name='package_bill_ref1' id='package_bill_ref1'  size=15 maxlength=15 readonly value="<%=pkg_bill_no%>">
</td>		
<%
		}
		else
		{
%>
	
<td width="25%" class="label"></td>
<td  width="25%" class="label"></td>

<%
		}
%>
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
<input type='hidden' name='cur_patient_id' id='cur_patient_id' value='<%=cur_patient_id%>'>
<input type='hidden' name='CitizenYn' id='CitizenYn' value='<%=strCitizenYn%>'>
<input type='hidden' name='ins_auth_flag' id='ins_auth_flag' value='<%=ins_auth_flag%>'>
<!--
<input type='hidden' name='upd_fin_dtls' id='upd_fin_dtls' value=''>
-->
<input type='hidden' name='remarks' id='remarks' value="<%=remarks%>">
<input type='hidden' name='user_id' id='user_id' value='<%=user_id%>'>
<input type='hidden' name='clinic_code' id='clinic_code' value="<%=clinic_code%>">
<input type='hidden' name='visit_type_code' id='visit_type_code' value="<%=visit_type_code%>">
<input type='hidden' name='show_hide_blng_class' id='show_hide_blng_class' value='<%=show_hide_blng_class%>'>

<input type='hidden' name='third_party_gl_in_use_yn' id='third_party_gl_in_use_yn' value='<%=third_party_gl_in_use_yn%>'>
<input type='hidden' name='third_party_gl_mandatory_yn' id='third_party_gl_mandatory_yn' value='<%=third_party_gl_mandatory_yn%>'>
<input type='hidden' name='ref_id' id='ref_id' value="<%=ref_id%>">
<input type='hidden' name='org_type_ind' id='org_type_ind' value='<%=org_type_ind%>'>
<input type='hidden' name='capture_employer_id_yn' id='capture_employer_id_yn' value='<%=capture_employer_id_yn%>'>
</tr>

<% 
		if(strModuleId.equals("MP"))
		{
			if (operation.equals("Update"))
			{
%>
<tr>
	<td width="25%"  class="label" ><fmt:message key="eBL.FAMILY_ANNUAL_INCOME.label" bundle="${bl_labels}"/></td>
<!--
	<td width="25%"  class='fields' ><input maxlength='17' type=text name='annual_income' id='annual_income' style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,2))' onblur='put_decimal(this,document.forms[0].noofdecimal.value);' value='<%=strAnnualIncome%>'></input></td>
-->
	<td width="25%"  class='fields' ><input maxlength='17' type=text name='annual_income' id='annual_income' style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))' onblur='CheckSplApprAmt(this);' value='<%=strAnnualIncome%>'></input></td>
	<td width="25%"  class="label" ><fmt:message key="eBL.FAMILY_ASSET.label" bundle="${bl_labels}"/></td>
	<td width="25%"  class='fields' ><input type="text" maxlength='17' name='family_asset' id='family_asset' style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))' onblur='CheckSplApprAmt(this);' value='<%=strFamilyAsset%>' ></input></td>
</tr>	
<%
			}
			else
			{
%>
<tr>
	<td width="25%"  class="label" ><fmt:message key="eBL.FAMILY_ANNUAL_INCOME.label" bundle="${bl_labels}"/></td>
<!--
	<td width="25%"  class='fields' ><input maxlength='17' type=text name='annual_income' id='annual_income' style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,2))' onblur='put_decimal(this,document.forms[0].noofdecimal.value);' value='<%=strAnnualIncome%>'></input></td>
-->
	<td width="25%"  class='fields' ><input maxlength='17' type=text name='annual_income' id='annual_income' style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))' onblur='CheckSplApprAmt(this);' value='<%=strAnnualIncome%>'></input></td>
	<td width="25%"  class="label" ><fmt:message key="eBL.FAMILY_ASSET.label" bundle="${bl_labels}"/></td>
	<td width="25%"  class='fields' ><input type="text" maxlength='17' name='family_asset' id='family_asset' style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))' onblur='CheckSplApprAmt(this);' value='<%=strFamilyAsset%>'  ></input></td>
</tr>	
<%
			}
		}
		else
		{

%>
<input type='hidden' name="annual_income" id="annual_income" value="<%=strAnnualIncome%>">
<input type='hidden' name="family_asset" id="family_asset" value="<%=strFamilyAsset%>">
	
<%
		}
%>
<input type=hidden name="HealthCardTot" id="HealthCardTot" value='<%=strArrayHealthCard_YN%>'> 
<input type=hidden name="bl_oper_yn" id="bl_oper_yn" value='<%=bl_oper_yn%>'> 
<input type=hidden name="HealthCardExpired" id="HealthCardExpired" value='<%=strHealthCardExpired_YN%>'> 
<input type=hidden name="special_scheme_appl" id="special_scheme_appl" value='N'> 
<input type=hidden name="alt_id1_exp_date" id="alt_id1_exp_date" value='<%=alt_id1_exp_date%>'> 
<input type=hidden name="blng_applicable_yn" id="blng_applicable_yn" value='<%=strArrayBillingApp_YN%>'>	
<input type=hidden name="bl_data_from_repos_yn" id="bl_data_from_repos_yn" value='<%=strRepositoryYN%>'>	
<input type=hidden name="data_source_id" id="data_source_id" value='<%=strDataSourceId%>'>	
<input type=hidden name="items_disabled" id="items_disabled" value='<%=strItemsDisabled%>'>	
<input type=hidden name="calling_module_id" id="calling_module_id" value='<%=strModuleId%>'>	
<input type=hidden name="ext_billing_group" id="ext_billing_group" value="<%=strExtBillingGroup%>">	
<input type=hidden name="ext_settl_type" id="ext_settl_type" value='<%=strExtSettlType%>'>	
<input type=hidden name="function_id" id="function_id" value='<%=strFunctionId%>'>	
<input type=hidden name="patient_found" id="patient_found" value='<%=boolPatientFoundMP%>'>
<input type=hidden name="boolean_security" id="boolean_security" value='<%=boolSecurity%>'>		
<input type=hidden name='chng_to_visit_yn' id='chng_to_visit_yn'   value='<%=strChngToVisit%>'>
<input type=hidden name='facility_id' id='facility_id'   value='<%=facility_id%>'>
<input type=hidden name='episode_type' id='episode_type'   value='<%=strEpisodeType%>'>
<input type=hidden name='bl_interfaced_yn' id='bl_interfaced_yn'   value='<%=strBLInterfacedYN%>'>
<input type=hidden name='logged_user_id' id='logged_user_id'   value='<%=strLoggedUser%>'>
<input type=hidden name='temp_blng_class' id='temp_blng_class'   value="<%=strBlngClass%>">
<input type=hidden name='temp_bill_type' id='temp_bill_type'   value="<%=strBillType%>">
<input type=hidden name='bed_class_code' id='bed_class_code'   value="<%=strBedClass%>">
<input type=hidden name='bed_type' id='bed_type'   value="<%=strBedType%>">
<input type=hidden name='bed_no' id='bed_no'   value='<%=strBedNo%>'>
<input type=hidden name='visit_adm_type' id='visit_adm_type'   value="<%=strAdmissionType%>">
<input type=hidden name='nursing_unit_code' id='nursing_unit_code'   value="<%=strNursingUnit%>">
<input type=hidden name='ip_message_id' id='ip_message_id'   value='<%=strMessageId%>'>
<input type=hidden name='dept_code' id='dept_code'   value='<%=strDeptCode%>'>
<input type=hidden name='special_scheme_type' id='special_scheme_type'		value='<%=strSchemeType%>'>
<input type=hidden name='special_scheme_message' id='special_scheme_message'		value="<%=strMessageDesc%>">
<input type="hidden" name="practitioner_id" id="practitioner_id"     value="<%=strPractitionerId%>"></input>
<input type="hidden" name="practitioner_type_ind" id="practitioner_type_ind"     value="<%=strPractitionerTypeInd%>"></input>
<input type=hidden name='patient_blng_grp' id='patient_blng_grp'		value="<%=strPatBlngGrp%>">
<input type=hidden name='special_scheme_blng_grp' id='special_scheme_blng_grp'		value="<%=strSpecialSchemeBlngGrp%>">
<input type=hidden name='special_scheme_blng_grp_desc' id='special_scheme_blng_grp_desc'	value="<%=strSpecialSchemeBlngGrpDesc%>">
<input type=hidden name='spl_scheme_blng_grp_present' id='spl_scheme_blng_grp_present' value="<%=strSplSchemeBlngGrpPresent%>">	
<input type=hidden name='blnggrpappyn' id='blnggrpappyn' value='<%=strBlngGrpAppYN%>'>		
<input type=hidden name='blnggrpcatgappyn' id='blnggrpcatgappyn' value='<%=strBlngGrpCatgAppYN%>'>
<input type=hidden name='BlngGrpStatus' id='BlngGrpStatus' value='<%=strBlngGrpStatus%>'>		
<input type=hidden name='mblnggroup' id='mblnggroup' value="<%=mbilling_group%>">		
<input type=hidden name='hcard_applicable_yn' id='hcard_applicable_yn'		value='<%=strHcardApplicableYN%>'>
<input type=hidden name='hcare_applicable_yn' id='hcare_applicable_yn'		value='<%=strHcareApplicableYN%>'>
<input type=hidden name='hcard_scheme_id' id='hcard_scheme_id'		value='<%=strHcardSchemeId%>'>
<input type=hidden name='hcare_scheme_id' id='hcare_scheme_id'		value='<%=strHcareSchemeId%>'>
<input type=hidden name='hcard_expired_yn' id='hcard_expired_yn'		value='<%=strHcardExpiredYN%>'>
<input type=hidden name='hcare_expired_yn' id='hcare_expired_yn'		value='<%=strHcareExpiredYN%>'>
<input type=hidden name='previous_blng_grp' id='previous_blng_grp'			value="<%=strPreviousBlngGrp%>">
<input type=hidden name='previous_blng_grp_desc' id='previous_blng_grp_desc'	value="<%=strPreviousBlngGrpDesc%>">
<input type=hidden name='hcard_prerequisite_yn' id='hcard_prerequisite_yn' 	value='<%=strHcardPrerequisite_yn%>'>
<input type=hidden name='operation' id='operation'	value='<%=operation%>'>
<input type=hidden name='billing_mode' id='billing_mode' 	value='<%=billing_mode%>'>
<input type=hidden name='glholdername' id='glholdername' 	value="<%=gl_holder_name%>">
<input type=hidden name='glrel' id='glrel' 	value="<%=gl_rel%>">
<input type=hidden name='payresp' id='payresp' 	value="<%=strRespForPayment%>">
<input type=hidden name='blnggrp' id='blnggrp' 	value="<%=strblnggrp%>">
<input type=hidden name='strBillGrpId' id='strBillGrpId' 	value="<%=strBillGrpId%>">
<input type=hidden name='strdfltbgyn' id='strdfltbgyn' 	value='<%=strdfltbgyn%>'>
<input type=hidden name='upd_fin_dtl_chkbx' id='upd_fin_dtl_chkbx' 	value='<%=strUpdFinDtls%>'>
<%
		if (operation.equals("Update"))
		{
%>
<tr>
	<td width="25%" class="label" ><fmt:message key="eBL.NO_OF_DEPENDANTS.label" bundle="${bl_labels}"/></td>
	<td width="25%" class='fields' ><input type="text" maxlength='2' size="2" name='no_of_dependants' id='no_of_dependants' style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,0))' value='<%=strNoDependants%>'></input></td>
<%
			if(!patient_id.equals(""))
			{
				if(str_valid_pkg_for_pat_bg_avail_YN.equals("Y"))
				{
%>
	<td width='25%' class="label"><div id='vw_pkg_dtl_disp' style="display:inline"><a href="javascript:view_trmt_pkg_dtl();"><fmt:message key="eBL.VW_SUBS_OPEN_PACKAGE_DTL.label" bundle="${bl_labels}"/></a></div></td>
<%
				}	
				else
				{
%>
	<td width='25%' class="label"><div id='vw_pkg_dtl_disp' style="display:none"><a href="javascript:view_trmt_pkg_dtl();"><fmt:message key="eBL.VW_SUBS_OPEN_PACKAGE_DTL.label" bundle="${bl_labels}"/></a></div></td>
<%
				}
			}
			else
			{
%>
	<td width='25%'></td>
<%
			}
%>
	<td width='25%'></td>
</tr>

<tr>
	<td width="25%" class="label" ><fmt:message key="eBL.RESPONSIBLE_FOR_PAYMENT.label" bundle="${bl_labels}"/></td>
	<td width="25%"  class="fields" ><input maxlength='30' size='20' type=text name='resp_for_payment' id='resp_for_payment'  value="<%=strRespForPayment%>" onKeyPress='return CheckForSpecChars_local(event)' onBlur="chk_for_entry(this,document.forms[0].pat_reln_with_resp_person,document.forms[0].patrelbut);"></input>
<!--
		<%
			if (!(ref_id.equals("")))
			{	
				if (org_type_ind.equals("P"))
			{%>
			<a href="javascript:getRefDet();"><fmt:message key="eBL.PVT_REFERRAL.label"  bundle="${bl_labels}"/></a></td>
			<%}
				else if (org_type_ind.equals("G"))
			{%>
			<a href="javascript:getRefDet();"><fmt:message key="eBL.GOVT_REFERRAL.label" bundle="${bl_labels}"/></a></td>
			<%}
			else 
			{%>

			<a href="javascript:getRefDet();"><fmt:message key="eBL.REFERRAL_LINK.label" bundle="${bl_labels}"/></a></td>
			<%}
			}
		%>	
			
		
-->
<%
if(strCustomerId.equalsIgnoreCase("GP")) {
//	if(str_slmt_ind.equalsIgnoreCase("R")) {	
	if(str_slmt_ind.equalsIgnoreCase("R")||str_slmt_ind.equalsIgnoreCase("X")) {	
	
	%>
	<div id='sel_resp_for_pay_disp' style="display:none"><img src='../../eCommon/images/mandatory.gif'></div>
<%} 
	//else if(str_slmt_ind.equalsIgnoreCase("C")||str_slmt_ind.equalsIgnoreCase("X")){
		else if(str_slmt_ind.equalsIgnoreCase("C")){
%>
<div id='sel_resp_for_pay_disp' style="display:inline"><img src='../../eCommon/images/mandatory.gif'></div>
<%} 
else{ 
%>
<div id='sel_resp_for_pay_disp' style="display:none"><img src='../../eCommon/images/mandatory.gif'></div>
<%} 
	
	} %>

	</td>
	<td width="25%" class="label" ><fmt:message key="eBL.PATIENT_RELN_WITH_RESP_PERSON.label" bundle="${bl_labels}"/></td>
	<td width="25%"  class="fields" ><input type='text' name="pat_reln_with_resp_person" id="pat_reln_with_resp_person" maxlength='30' size='20' tabindex='0'  value="<%=strPatRelnWithRespPerson%>" onBlur="return patrellkup('B')" DISABLED><input type='button' class='button' name="patrelbut" id="patrelbut" value='?' onClick="return patrellkup('C')" tabindex='0' DISABLED></td>
</tr>

<% 
			if (third_party_gl_in_use_yn.equals("Y"))
			{	
%>	

<tr>
	<td width="25%"  class="label" ><fmt:message key="eBL.GL_HOLDER_NAME.label" bundle="${bl_labels}"/></td>
	<td width="25%"  class="fields" ><input maxlength='60' size='30' type=text name='gl_holder_name' id='gl_holder_name'  value="<%=strGlHolderName%>" onKeyPress='return CheckForSpecChars_local(event)' onBlur="gllkup('B');chk_for_entry(this,document.forms[0].pat_reln_with_gl_holder,document.forms[0].glrelbut);">
<%
	if(!strModuleId.equals("MP"))
	{
%>
		<input type='button' class='button' name="glbut" id="glbut" value='?' onClick="return gllkup('C')"  tabindex='0'>
<%
	}
%>
	</td>	
	<td width="25%" class="label" ><fmt:message key="eBL.PATIENT_RELN_WITH_GL_HOLDER.label" bundle="${bl_labels}"/></td>
	<td width="25%"  class="fields" ><input type='text' name="pat_reln_with_gl_holder" id="pat_reln_with_gl_holder" maxlength='30' size='20' tabindex='0'  value="<%=strGlHolderReln%>" onBlur="return glrellkup('B')" DISABLED><input type='button' class='button' name="glrelbut" id="glrelbut" value='?' onClick="return glrellkup('C')" tabindex='0' DISABLED></td>
</tr>		
<%
		    }	
			else
			{
%>
	<input type='hidden' name='gl_holder_name' id='gl_holder_name' value=''>
	<input type='hidden' name='pat_reln_with_gl_holder' id='pat_reln_with_gl_holder' value=''>
<%

			}
			
			if(!(strModuleId.equals("MP")) && !(strFunctionId.equals("BOOKING")))
			{
				if(str_upd_patient_fin_dtls_yn.equals("Y"))
					upd_pat_fin_dtls_YN="checked";
				if(strUpdFinDtls.equals("Y"))
					upd_pat_fin_dtls_YN="checked  readonly";
%>
<tr>
	<td width="25%"  class="label" ><fmt:message key="eBL.UPDATE_PATIENT_FIN_DTL.label" bundle="${bl_labels}"/></td>
	<td width="25%"  class="fields" ><input type=checkbox name='upd_fin_dtls' id='upd_fin_dtls' style='text-align:right' onClick='chng_class_for_inv_pyrs_on_rfrsh()' <%=upd_pat_fin_dtls_YN%>></input></td>
	<td width="25%"  class="label" >
<%
				if (!(ref_id.equals("")))
				{	
					if (org_type_ind.equals("P"))
					{	
%>
	<a href="javascript:getRefDet();"><fmt:message key="eBL.PVT_REFERRAL.label"  bundle="${bl_labels}"/></a></td>		
<%
					}
					else if(org_type_ind.equals("G"))
					{
%>
	<a href="javascript:getRefDet();"><fmt:message key="eBL.GOVT_REFERRAL.label" bundle="${bl_labels}"/></a></td>
<%
					}
					else
					{
%>
	<a href="javascript:getRefDet();"><fmt:message key="eBL.REFERRAL_LINK.label" bundle="${bl_labels}"/></a></td>	
<%
					}
				}
%>
	</td>
	<td width="25%"  class="label" ></td>
</tr>
<%
			}
			else
			{
%>
	<input type='hidden' name='upd_fin_dtls' id='upd_fin_dtls' value='N'>
<%
			}
		}
		else
		{
%>
<tr>
	<td width="25%"  class="label" ><fmt:message key="eBL.NO_OF_DEPENDANTS.label" bundle="${bl_labels}"/></td>
	<td width="25%"  class='fields' ><input type="text" size="2" maxlength='2' name='no_of_dependants' id='no_of_dependants' style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,0))' value='<%=strNoDependants%>'></input></td> 
<%
			if(!patient_id.equals(""))
			{
				if(str_valid_pkg_for_pat_bg_avail_YN.equals("Y"))
				{
%>
	<td width='25%' class="label"><div id='vw_pkg_dtl_disp' style="display:none"><a href="javascript:view_trmt_pkg_dtl();"><fmt:message key="eBL.VW_SUBS_OPEN_PACKAGE_DTL.label" bundle="${bl_labels}"/></a></div></td>
<%
				}	
				else
				{
%>
	<td width='25%' class="label"><div id='vw_pkg_dtl_disp' style="display:none"><a href="javascript:view_trmt_pkg_dtl();"><fmt:message key="eBL.VW_SUBS_OPEN_PACKAGE_DTL.label" bundle="${bl_labels}"/></a></div></td>
<%
				}
			}
			else
			{
%>
	<td width='25%'></td>
<%
			}
%>
	<td width='25%'></td>
</tr>

<tr>
	<td width="25%"  class="label" ><fmt:message key="eBL.RESPONSIBLE_FOR_PAYMENT.label" bundle="${bl_labels}"/></td>
	<td width="25%"  class="fields" ><input maxlength='30' size='20' type=text name='resp_for_payment' id='resp_for_payment' value="<%=strRespForPayment%>" onKeyPress='return CheckForSpecChars_local(event)' onBlur="chk_for_entry(this,document.forms[0].pat_reln_with_resp_person,document.forms[0].patrelbut);"></input>
<!--
	<%
			if (!(ref_id.equals("")))
			{	
			   if (org_type_ind.equals("P"))
				{%><a href="javascript:getRefDet();"><fmt:message key="eBL.PVT_REFERRAL.label"  bundle="${bl_labels}"/></a></td><%}
			   else if (org_type_ind.equals("G"))
				{%><a href="javascript:getRefDet();"><fmt:message key="eBL.GOVT_REFERRAL.label" bundle="${bl_labels}"/></a></td><%}
			   else 
				{%><a href="javascript:getRefDet();"><fmt:message key="eBL.REFERRAL_LINK.label" bundle="${common_labels}"/></a></td><%}
			}
	%>		
-->	


<%

if(strCustomerId.equalsIgnoreCase("GP")) {	
//	if(str_slmt_ind.equalsIgnoreCase("R")) {	
	if(str_slmt_ind.equalsIgnoreCase("R")||str_slmt_ind.equalsIgnoreCase("X")) {		
		%>
	<div id='sel_resp_for_pay_disp' style="display:none"><img src='../../eCommon/images/mandatory.gif'></div>
<%} 
//else if(str_slmt_ind.equalsIgnoreCase("C")||str_slmt_ind.equalsIgnoreCase("X")){
	else if(str_slmt_ind.equalsIgnoreCase("C")){
	System.out.println("str_slmt_ind"+str_slmt_ind);
	%>
<div id='sel_resp_for_pay_disp' style="display:inline"><img src='../../eCommon/images/mandatory.gif'></div>
<%} 
else{ 
%>
<div id='sel_resp_for_pay_disp' style="display:none"><img src='../../eCommon/images/mandatory.gif'></div>
<%} 
	} %>


	</td>
		<td width="25%" class="label" ><fmt:message key="eBL.PATIENT_RELN_WITH_RESP_PERSON.label" bundle="${bl_labels}"/></td>
		<td width="25%"  class="fields" ><input type='text' name="pat_reln_with_resp_person" id="pat_reln_with_resp_person" maxlength='30' size='20' tabindex='0'  value="<%=strPatRelnWithRespPerson%>" onBlur="return patrellkup('B')" DISABLED><input type='button' class='button' name="patrelbut" id="patrelbut" value='?' onClick="return patrellkup('C')" tabindex='0' DISABLED></td>
	</tr>

<!-- Added on 09/11/2003 -->
<% 
			if (third_party_gl_in_use_yn.equals("Y"))
			{	
%>
<tr>
	<td width="25%"  class="label" ><fmt:message key="eBL.GL_HOLDER_NAME.label" bundle="${bl_labels}"/></td>
	<td width="25%"  class="fields" ><input maxlength='60' size='30' type=text name='gl_holder_name' id='gl_holder_name'  value="<%=strGlHolderName%>" onKeyPress='return CheckForSpecChars_local(event)' onBlur="gllkup('B');chk_for_entry(this,document.forms[0].pat_reln_with_gl_holder,document.forms[0].glrelbut);">
<%
	if(!strModuleId.equals("MP"))
	{
%>
	<input type='button' class='button' name="glbut" id="glbut" value='?' onClick="return gllkup('C')" tabindex='0' >
<%
	}
%>
	</td>	

	<td width="25%"  class="label" ><fmt:message key="eBL.PATIENT_RELN_WITH_GL_HOLDER.label" bundle="${bl_labels}"/></td>
	<td width="25%"  class="fields" ><input type='text' name="pat_reln_with_gl_holder" id="pat_reln_with_gl_holder" maxlength='30' size='20' tabindex='0'  value="<%=strGlHolderReln%>" onBlur="return glrellkup('B')" DISABLED><input type='button' class='button' name="glrelbut" id="glrelbut" value='?' onClick="return glrellkup('C')" tabindex='0' DISABLED></td>
</tr>
<%
			}
			else
			{
%>
	<input type='hidden' name='gl_holder_name' id='gl_holder_name' value=''>
	<input type='hidden' name='pat_reln_with_gl_holder' id='pat_reln_with_gl_holder' value=''>
<%

			}
			if(!(strModuleId.equals("MP")) && !(strFunctionId.equals("BOOKING")))
			{
				if(str_upd_patient_fin_dtls_yn.equals("Y"))
					upd_pat_fin_dtls_YN="checked";
				if(strUpdFinDtls.equals("Y"))
					upd_pat_fin_dtls_YN="checked  readonly";
%>
<tr>
	<td width="25%"  class="label" ><fmt:message key="eBL.UPDATE_PATIENT_FIN_DTL.label" bundle="${bl_labels}"/></td>
	<td width="25%"  class="fields" ><input type=checkbox name='upd_fin_dtls' id='upd_fin_dtls' style='text-align:right' onClick='' <%=upd_pat_fin_dtls_YN%>></input></td>
	<td width="25%"  class="label" >
<%
				if (!(ref_id.equals("")))
				{	
					if (org_type_ind.equals("P"))
					{	
%>
	<a href="javascript:getRefDet();"><fmt:message key="eBL.PVT_REFERRAL.label"  bundle="${bl_labels}"/></a></td>		
<%
					}
					else if(org_type_ind.equals("G"))
					{
%>
	<a href="javascript:getRefDet();"><fmt:message key="eBL.GOVT_REFERRAL.label" bundle="${bl_labels}"/></a></td>
<%
					}
					else
					{
%>
	<a href="javascript:getRefDet();"><fmt:message key="eBL.REFERRAL_LINK.label" bundle="${bl_labels}"/></a></td>	
<%
					}
				}
%>
	</td>
	<td width="25%"  class="label" ></td>
</tr>
<%
			}
			else
			{
%>
	<input type='hidden' name='upd_fin_dtls' id='upd_fin_dtls' value='N'>
<%
			}	
		}
%>
<%
	String ref_src_code_disp="";
	String ref_src_code_main_mand_disp ="";
	String ref_src_code_sub_mand_disp = "";

/*	Commented and moved up for PE Changes
	String ref_src_code_qry="select nvl(CAPTURE_REF_SOURCE_DTL_YN,'N'),nvl(REF_SOURCE_MAIN_MAND_YN,'N'),nvl(REF_SOURCE_SUB_MAND_YN,'N') from bl_blng_grp where BLNG_GRP_ID='"+str_blng_grp_id+"'";

	try
	{
		pstmt = con.prepareStatement(ref_src_code_qry);
		rs2 = pstmt.executeQuery() ;
		if( rs2 != null ) 
		{	
			while( rs2.next() )
			{  
				referral_source_capture_YN = rs2.getString(1);
				referral_source_main_mand_YN = rs2.getString(2);
				referral_source_sub_mand_YN = rs2.getString(3);
			}
		}
		if (rs2 != null) rs2.close();
		pstmt.close();	
	}
	catch(Exception e)
	{
		System.out.println("Exception in ref_src_code_qry:"+e);
	}
*/		
	if(referral_source_capture_YN.equals("Y"))
	{
		ref_src_code_disp="display:inline";
		if(referral_source_main_mand_YN.equals("Y"))
		{
			ref_src_code_main_mand_disp = "display:inline";
		}
		else
		{
			ref_src_code_main_mand_disp = "display:none";
		}
		if(referral_source_sub_mand_YN.equals("Y"))
		{
			ref_src_code_sub_mand_disp = "display:inline";
		}
		else
		{
			ref_src_code_sub_mand_disp = "display:none";
		}
	}
	else if(referral_source_capture_YN.equals("N"))
	{
		ref_src_code_disp="display:none";
		ref_src_code_main_mand_disp = "display:none";
		ref_src_code_sub_mand_disp = "display:none";
	}
	else
	{
		ref_src_code_disp="display:none";
	}

	if(!strRefSrcMainCode.equals(""))
	{
		CallableStatement call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
		call.registerOutParameter(1,java.sql.Types.VARCHAR);

		call.setString(2,strRefSrcMainCode);
		call.setString(3,locale);
		call.setString(4,"3");

		call.execute();							
		ref_src_main_lng_name = call.getString(1);				
		call.close();
		if ( ref_src_main_lng_name == null ) ref_src_main_lng_name = "";
	}
	else
	{
		ref_src_main_lng_name="";
	}

	if(!strRefSrcSubCode.equals(""))
	{
		CallableStatement call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
		call.registerOutParameter(1,java.sql.Types.VARCHAR);

		call.setString(2,strRefSrcSubCode);
		call.setString(3,locale);
		call.setString(4,"3");

		call.execute();							
		ref_src_sub_lng_name = call.getString(1);				
		call.close();
		if ( ref_src_sub_lng_name == null ) ref_src_sub_lng_name = "";
	}
	else
	{
		ref_src_sub_lng_name="";
	}
//	System.out.println("ref_src_code_disp:"+ref_src_code_disp);
//	System.out.println("referral_source_main_mand_YN:"+referral_source_main_mand_YN);
//	System.out.println("referral_source_sub_mand_YN:"+referral_source_sub_mand_YN);
%>
<input type='hidden' name='cap_ref_src_dtl_flag' id='cap_ref_src_dtl_flag' value='<%=referral_source_capture_YN%>'>
<input type='hidden' name='referral_source_main_mand_YN' id='referral_source_main_mand_YN' value='<%=referral_source_main_mand_YN%>'>
<input type='hidden' name='referral_source_sub_mand_YN' id='referral_source_sub_mand_YN' value='<%=referral_source_sub_mand_YN%>'>
<tr>
	
	<td width="25%" class="Label">
		<div id='ref_src_code_main_leg_disp' style='<%=ref_src_code_disp%>'><fmt:message key="eBL.PMY_REF_SRC.label" bundle="${bl_labels}"/>
		</div>
	</td>

	<td width="25%" class="fields">
		<div id='ref_src_code_main_val_disp' style='<%=ref_src_code_disp%>'>
			<input type='text' name="referral_source_main_desc" id="referral_source_main_desc" maxlength='50' size='25' tabindex='0'  value="<%=strRefSrcMainDesc%>" onBlur="return refsrclkup(document.forms[0].referral_source_main_code,document.forms[0].referral_source_main_desc,'M','B')">
			<input type='button' class='button' name="refsrcmainbut" id="refsrcmainbut" value='?' onClick="return refsrclkup(document.forms[0].referral_source_main_code,document.forms[0].referral_source_main_desc,'M','C')" tabindex='0'>
			<div id='ref_src_code_main_mand_disp' style='<%=ref_src_code_main_mand_disp%>'><img src='../../eCommon/images/mandatory.gif'></div>
<%
			if(ref_src_main_lng_name.equals(""))
			{
%>
			<img src='../../eCommon/images/more.gif' name="pmy_ref_src_lng_name" id="pmy_ref_src_lng_name" align='center' style="visibility:hidden">
<%
			}
			else
			{
%>
			<img src='../../eCommon/images/more.gif' name="pmy_ref_src_lng_name" id="pmy_ref_src_lng_name" align='center' style="visibility:inline" alt="<%=ref_src_main_lng_name%>">
<%
			}
%>			
		</div>
	</td>
	
	<td width="25%" class="Label">
		<div id='ref_src_code_sub_leg_disp' style='<%=ref_src_code_disp%>'><fmt:message key="eBL.SEC_REF_SRC.label" bundle="${bl_labels}"/>
		</div>
	</td>
	
	<td width="25%" class="fields">
		<div id='ref_src_code_sub_val_disp' style='<%=ref_src_code_disp%>'>
			<input type='text' name="referral_source_sub_desc" id="referral_source_sub_desc" maxlength='50' size='25' tabindex='0'  value="<%=strRefSrcSubDesc%>" onBlur="return refsrclkup(document.forms[0].referral_source_sub_code,document.forms[0].referral_source_sub_desc,'S','B')">
			<input type='button' class='button' name="refsrcsubbut" id="refsrcsubbut" value='?' onClick="return refsrclkup(document.forms[0].referral_source_sub_code,document.forms[0].referral_source_sub_desc,'S','F')" tabindex='0'>
			<div id='ref_src_code_sub_mand_disp' style='<%=ref_src_code_sub_mand_disp%>'><img src='../../eCommon/images/mandatory.gif'></div>
<%
			if(ref_src_sub_lng_name.equals(""))
			{
%>
			<img src='../../eCommon/images/more.gif' name="sec_ref_src_lng_name" id="sec_ref_src_lng_name" align='center' style="visibility:hidden">
<%
			}
			else
			{
%>
			<img src='../../eCommon/images/more.gif' name="sec_ref_src_lng_name" id="sec_ref_src_lng_name" align='center' style="visibility:inline" alt="<%=ref_src_sub_lng_name%>">
<%
			}
%>				
		</div>
	</td>
	
</tr>
<input type='hidden' name='referral_source_main_code' id='referral_source_main_code' value="<%=strRefSrcMainCode%>">
<input type='hidden' name='referral_source_sub_code' id='referral_source_sub_code' value="<%=strRefSrcSubCode%>">
<%
	try
	{
		String prev_enc_check_qry = "";
//		String op_ae_prev_enc_check_qry="";
//		String ip_dc_prev_enc_check_qry="";
/*
		if(strEpisodeType.equals("O") || strEpisodeType.equals("E"))
		{
			prev_enc_check_qry="select count(1) from op_last_visit where OPERATING_FACILITY_ID ='"+facility_id+"' and last_episode_type ='"+strEpisodeType+"' and LAST_PATIENT_ID = '"+patient_id+"'";
		}
		else if(strEpisodeType.equals("I") || strEpisodeType.equals("D"))
		{
			prev_enc_check_qry="select count(1) from ip_last_episode where FACILITY_ID ='"+facility_id+"' and last_episode_type ='"+strEpisodeType+"' and PATIENT_ID = '"+patient_id+"'";
		}

		op_ae_prev_enc_check_qry="select count(1) from op_last_visit where OPERATING_FACILITY_ID ='"+facility_id+"' and last_episode_type in ('O','E') and LAST_PATIENT_ID = '"+patient_id+"'";

		if(!op_ae_prev_enc_check_qry.equals("")) 
		{
			pstmt = con.prepareStatement(op_ae_prev_enc_check_qry);
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{	
				while( rs2.next() )
				{  
					op_ae_prev_enc_check_count = rs2.getInt(1);
				}
			}
			if (rs2 != null) rs2.close();
			pstmt.close();	
		}

		ip_dc_prev_enc_check_qry="select count(1) from ip_last_episode where FACILITY_ID ='"+facility_id+"' and last_episode_type in ('I','D') and PATIENT_ID = '"+patient_id+"'";

		if(!ip_dc_prev_enc_check_qry.equals(""))
		{
			pstmt = con.prepareStatement(ip_dc_prev_enc_check_qry);
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{	
				while( rs2.next() )
				{  
					ip_dc_prev_enc_check_count = rs2.getInt(1);
				}
			}
			if (rs2 != null) rs2.close();
			pstmt.close();	
		}
*/
		pstmt = con.prepareStatement("SELECT count(*) FROM pr_encounter WHERE patient_id=? and FACILITY_ID=? AND ((patient_class IN ('OP','EM') AND visit_status NOT IN ('99')) OR (patient_class IN ('IP','DC') AND adt_status NOT IN ('09')))");
		pstmt.setString(1,patient_id);
		pstmt.setString(2,facility_id);
		rs2 = pstmt.executeQuery() ;
		if( rs2 != null ) 
		{	
			while( rs2.next() )
			{  
				prev_enc_check_count = rs2.getInt(1);
			}
		}
		if (rs2 != null) rs2.close();
		pstmt.close();	

//System.out.println("prev_enc_check_count:"+prev_enc_check_count);
	}
	catch(Exception e)
	{
		System.out.println("Exception in ref_src_code_qry:"+e);
	}
%>
	<tr>
<td width="25%">&nbsp;</td>
<td width="25%">&nbsp;</td>
 <td colspan='2' width="25%" class='label'>
	<div id="pkgSubsMsg" style="display: none">
		<b>
		<font color="#bf40bf">
		<fmt:message key="eBL.PKG_SUBS_MSG.label" bundle="${bl_labels}" />
		</font>
		</b>
	</div>
 </td>	
</tr>
			<tr>
<%
	if(strEpisodeType.equals("I") || strEpisodeType.equals("D") || (strEpisodeType.equals("I") && strFunctionId.equals("BOOKING")))
	{
		if(str_spl_clinic_rel_enc_YN.equals("Y"))
			spl_clinic_rel_enc_YN="checked";
		else
			spl_clinic_rel_enc_YN="";
%>
		<td width="25%" class='label'><fmt:message key="eBL.IS_SPL_CLINIC_ENC_YN.label" bundle="${bl_labels}"/></td>
		<td width="25%"  class="fields" ><input type=checkbox name='spl_clinic_rel_enc_YN' id='spl_clinic_rel_enc_YN' style='text-align:right' onClick='' <%=spl_clinic_rel_enc_YN%>></input></td>
<%
	}
	else
	{
%>		
		<td width="25%">&nbsp;</td>
		<td width="25%">&nbsp;</td>
		<input type='hidden' name='spl_clinic_rel_enc_YN' id='spl_clinic_rel_enc_YN' value='N'>
<%
	}
	//added for package billing   previous encounter link  separeted if it not OP 
//if it is OP package subscription is added along with prv Enounter link 
/***** package billing *************** start**************/	
	
	if(package_enabled_yn.equals("Y") && (strModuleId.equals("OP") || strModuleId.equals("IP")))
	{	
%>
			<td width="25%" class="Label">
		<div id="pkgAssociateSubs" style="display:none">
<%	

		String associate_pkg_req_yn=bean.subsOpenPkgsExists(facility_id,locale,patient_id,encounter_date_aft_trunc);
		if(associate_pkg_req_yn.equals("Y"))
		{
%>
			<a  href="javascript:associatePkgFromVisit(document.forms[0].patient_id.value,document.forms[0].encounter_date.value,document.forms[0].encounter_date_time.value,document.forms[0].encounter_date_aft_trunc.value,document.forms[0].calling_module_id.value,document.forms[0].firstVisitDateTime.value);">[<fmt:message key="eBL.AssociateSubscribedPackage.label" bundle="${bl_labels}"/>]</a>
<%
		}	
%>		
			<a  href="javascript:subscribePackageFromVisit(document.forms[0].patient_id.value,document.forms[0].calling_module_id.value);">[<fmt:message key="eBL.Subs_pack.label" bundle="${bl_labels}"/>]</a>
			<%
			//Karthik commented on 21/7/2013 as Discount Page was called Twice IN050265
			//if(str_charge_logic.equals("Y"))
			//{
			 %>
			<a  href="javascript:callPackgeDiscount(document.forms[0].patient_id.value,document.forms[0].calling_module_id.value);">[<fmt:message key="eBL.PackageDiscount.label" bundle="${bl_labels}"/>]</a>
			<% //} %>
			</div>
			
			</td>
			
<%
	}//end module id if
	/***** package billing *************** end**************/	

//	if(srtencdfltbgyn.equals("Y") && strprovselfrmprevencyn.equals("Y") && !strModuleId.equals("MP") && (op_ae_prev_enc_check_count>0 || ip_dc_prev_enc_check_count>0))
/*System.err.println("AddModifyPatFinDetails.jsp $$$$$$$$$$$$$$-------->"+srtencdfltbgyn+"    "+strprovselfrmprevencyn+"   "+strModuleId+"  "+prev_enc_check_count);*/

	String custID= BLReportIdMapper.getCustomerId();
	if( ( ( srtencdfltbgyn.equals("Y") && strprovselfrmprevencyn.equals("Y") ) || "ALKA".equals(custID) ) && !strModuleId.equals("MP") && prev_enc_check_count>0)
	{

	
%>
	<td width="25%" class="Label">
		<div id="sel_frm_prev_enc_disp" style="display:none">
			<a href="javascript:sel_frm_prev_enc();"><B>[<fmt:message key="eBL.SEL_FRM_PREV_ENC.label" bundle="${bl_labels}"/>]</b></a>
		</div>
	</td>
</tr>

<%
	}
	else
	{
%>
<tr>
	<td colspan='2'>&nbsp;</td>
</tr>
<%
	}
%>

<input type= 'hidden' name="locale" id="locale"  value='<%=locale%>'>
<input type= 'hidden' name="noofdecimal" id="noofdecimal"  value='<%=noofdecimal%>'>
<input type= 'hidden' name="sys_date" id="sys_date"  value='<%=sys_date%>'>
<input type= 'hidden' name="encounter_date" id="encounter_date"  value='<%=encounter_date%>'>
<input type= 'hidden' name="sel_frm_prev_enc" id="sel_frm_prev_enc"  value='<%=sel_frm_prev_enc%>'>
<input type= 'hidden' name="pat_ser_code" id="pat_ser_code"  value='<%=pat_ser_code%>'>

<input type='hidden' name='setlmt_ind' id='setlmt_ind' value='<%=str_slmt_ind%>'>
<input type='hidden' name='adm_rec_flag' id='adm_rec_flag' value='<%=str_adm_rec_flag%>'>
<input type='hidden' name='credit_doc_ref_reqd_yn' id='credit_doc_ref_reqd_yn' value='<%=credit_doc_ref_reqd_yn%>'>
<input type='hidden' name='disaster_regn_YN' id='disaster_regn_YN' value='<%=disaster_regn_YN%>'>

<input type='hidden' name='Case' id='Case' value=''>
<input type= 'hidden' name="fin_auth_user_id" id="fin_auth_user_id"  value='<%=fin_auth_user_id%>'>

<input type='hidden' name='fin_class_flag_YN' id='fin_class_flag_YN' value='<%=fin_class_flag_YN%>'>
<input type='hidden' name='autoFinChk' id='autoFinChk' value='<%=autoFinChk%>'>
<input type='hidden' name='fin_class_dtls_updated_YN' id='fin_class_dtls_updated_YN' value='<%=fin_class_dtls_updated_YN%>'>

<input type='hidden' name='charge_for_pat_regn_yn' id='charge_for_pat_regn_yn' value='<%=charge_for_pat_regn_yn%>'>

<!-- Newly added for transfereing the values to a BLFinancialDetailsSubmit.jsp -->
<input type='hidden' name='rtn_blng_grp' id='rtn_blng_grp' value="">
<input type='hidden' name='rtn_slmt_ind' id='rtn_slmt_ind' value="">
<input type='hidden' name='rtn_credit_doc_reqd_yn' id='rtn_credit_doc_reqd_yn' value="">
<input type='hidden' name='rtn_blng_class' id='rtn_blng_class' value="">
<input type='hidden' name='rtn_emp_code' id='rtn_emp_code' value="">
<input type='hidden' name='rtn_slmt_type_code' id='rtn_slmt_type_code' value="">
<input type='hidden' name='rtn_inst_ref' id='rtn_inst_ref' value="">
<input type='hidden' name='rtn_inst_date' id='rtn_inst_date' value="">
<input type='hidden' name='rtn_inst_remarks' id='rtn_inst_remarks' value="">
<input type='hidden' name='rtn_credit_cust_group_code' id='rtn_credit_cust_group_code' value="">
<input type='hidden' name='rtn_credit_cust_code' id='rtn_credit_cust_code' value="">
<input type='hidden' name='rtn_credit_doc_ref' id='rtn_credit_doc_ref' value="">
<input type='hidden' name='rtn_credit_doc_start_date' id='rtn_credit_doc_start_date' value="">
<input type='hidden' name='rtn_credit_doc_end_date' id='rtn_credit_doc_end_date' value="">
<input type='hidden' name='rtn_sponsor_cust_group_code' id='rtn_sponsor_cust_group_code' value="">
<input type='hidden' name='rtn_sponsor_cust_code' id='rtn_sponsor_cust_code' value="">
<input type='hidden' name='rtn_sponsor_credit_doc_ref' id='rtn_sponsor_credit_doc_ref' value="">
<input type='hidden' name='rtn_sponsor_credit_doc_start_date' id='rtn_sponsor_credit_doc_start_date' value="">
<input type='hidden' name='rtn_sponsor_credit_doc_end_date' id='rtn_sponsor_credit_doc_end_date' value="">
<input type='hidden' name='rtn_ins_blng_grp' id='rtn_ins_blng_grp' value="">
<input type='hidden' name='rtn_ins_cust_group_code' id='rtn_ins_cust_group_code' value="">
<input type='hidden' name='rtn_ins_cust_code' id='rtn_ins_cust_code' value="">
<input type='hidden' name='rtn_ins_cust_priority' id='rtn_ins_cust_priority' value="">
<input type='hidden' name='rtn_ins_policy_type_code' id='rtn_ins_policy_type_code' value="">
<input type='hidden' name='rtn_ins_policy_no' id='rtn_ins_policy_no' value="">
<input type='hidden' name='rtn_ins_policy_start_date' id='rtn_ins_policy_start_date' value="">
<input type='hidden' name='rtn_ins_policy_expiry_date' id='rtn_ins_policy_expiry_date' value="">
<input type='hidden' name='rtn_ins_credit_auth_ref' id='rtn_ins_credit_auth_ref' value="">
<input type='hidden' name='rtn_ins_credit_auth_date' id='rtn_ins_credit_auth_date' value="">
<input type='hidden' name='rtn_ins_cred_auth_req_yn' id='rtn_ins_cred_auth_req_yn' value="">
<input type='hidden' name='rtn_ins_cred_auth_mand_capt_yn' id='rtn_ins_cred_auth_mand_capt_yn' value="">
<input type='hidden' name='rtn_ins_dflt_auth_ref_as_pol_no_yn' id='rtn_ins_dflt_auth_ref_as_pol_no_yn' value="">
<input type='hidden' name='rtn_ins_credit_approval_days' id='rtn_ins_credit_approval_days' value="">
<input type='hidden' name='rtn_ins_credit_approval_amount' id='rtn_ins_credit_approval_amount' value="">
<input type='hidden' name='rtn_ins_policy_eff_from_date' id='rtn_ins_policy_eff_from_date' value="">
<input type='hidden' name='rtn_ins_policy_eff_to_date' id='rtn_ins_policy_eff_to_date' value="">
<input type='hidden' name='rtn_ins_adj_rule_ind' id='rtn_ins_adj_rule_ind' value="">
<input type='hidden' name='rtn_ins_adj_perc_amt_ind' id='rtn_ins_adj_perc_amt_ind' value="">
<input type='hidden' name='rtn_ins_adj_perc_amt_value' id='rtn_ins_adj_perc_amt_value' value="">
<input type='hidden' name='rtn_ins_pmnt_diff_adj_int' id='rtn_ins_pmnt_diff_adj_int' value="">
<input type='hidden' name='rtn_ins_drg_pmnt_diff_adj_int' id='rtn_ins_drg_pmnt_diff_adj_int' value="">
<input type='hidden' name='rtn_ins_spl_srv_pmnt_diff_adj_int' id='rtn_ins_spl_srv_pmnt_diff_adj_int' value="">
<input type='hidden' name='rtn_non_ins_blng_grp' id='rtn_non_ins_blng_grp' value="">
<input type='hidden' name='rtn_non_ins_credit_doc_reqd_yn' id='rtn_non_ins_credit_doc_reqd_yn' value="">
<input type='hidden' name='rtn_non_ins_slmt_type_code' id='rtn_non_ins_slmt_type_code' value="">
<input type='hidden' name='rtn_non_ins_inst_ref' id='rtn_non_ins_inst_ref' value="">
<input type='hidden' name='rtn_non_ins_inst_date' id='rtn_non_ins_inst_date' value="">
<input type='hidden' name='rtn_non_ins_inst_remarks' id='rtn_non_ins_inst_remarks' value="">
<input type='hidden' name='rtn_non_ins_cust_group_code' id='rtn_non_ins_cust_group_code' value="">
<input type='hidden' name='rtn_non_ins_cust_code' id='rtn_non_ins_cust_code' value="">
<input type='hidden' name='rtn_non_ins_credit_doc_ref' id='rtn_non_ins_credit_doc_ref' value="">
<input type='hidden' name='rtn_non_ins_credit_doc_start_date' id='rtn_non_ins_credit_doc_start_date' value="">
<input type='hidden' name='rtn_non_ins_credit_doc_end_date' id='rtn_non_ins_credit_doc_end_date' value="">
<input type='hidden' name='rtn_annual_income' id='rtn_annual_income' value="">
<input type='hidden' name='rtn_family_asset' id='rtn_family_asset' value="">
<input type='hidden' name='rtn_no_of_dependants' id='rtn_no_of_dependants' value="">
<input type='hidden' name='rtn_resp_for_payment' id='rtn_resp_for_payment' value="">
<input type='hidden' name='rtn_pat_reln_with_resp_person' id='rtn_pat_reln_with_resp_person' value="">
<input type='hidden' name='rtn_fin_remarks' id='rtn_fin_remarks' value="">
<input type='hidden' name='rtn_gl_holder_name' id='rtn_gl_holder_name' value="">
<input type='hidden' name='rtn_pat_reln_with_gl_holder' id='rtn_pat_reln_with_gl_holder' value="">
<input type='hidden' name='rtn_upd_patient_fin_dtls_yn' id='rtn_upd_patient_fin_dtls_yn' value="">
<input type='hidden' name='rtn_spl_clinic_rel_enc_YN' id='rtn_spl_clinic_rel_enc_YN' value="">
<input type='hidden' name='rtn_user_id' id='rtn_user_id' value="">
<input type='hidden' name='rtn_fin_auth_user_id' id='rtn_fin_auth_user_id' value="">
<input type='hidden' name='rtn_calling_function_id' id='rtn_calling_function_id' value="">
<input type='hidden' name='rtn_total_records' id='rtn_total_records' value="">
<input type='hidden' name='rtn_ins_restrict_check' id='rtn_ins_restrict_check' value="">
<input type='hidden' name='rtn_ins_apprd_amt_restrict_check' id='rtn_ins_apprd_amt_restrict_check' value="">
<input type='hidden' name='rtn_ins_apprd_days_restrict_check' id='rtn_ins_apprd_days_restrict_check' value="">
<input type='hidden' name='rtn_ref_src_main_code' id='rtn_ref_src_main_code' value="">
<input type='hidden' name='rtn_ref_src_main_desc' id='rtn_ref_src_main_desc' value="">
<input type='hidden' name='rtn_ref_src_sub_code' id='rtn_ref_src_sub_code' value="">
<input type='hidden' name='rtn_ref_src_sub_desc' id='rtn_ref_src_sub_desc' value="">

<input type='hidden' name='rtn_ins_ref_src_main_code' id='rtn_ins_ref_src_main_code' value="">
<input type='hidden' name='rtn_ins_ref_src_main_desc' id='rtn_ins_ref_src_main_desc' value="">
<input type='hidden' name='rtn_ins_ref_src_sub_code' id='rtn_ins_ref_src_sub_code' value="">
<input type='hidden' name='rtn_ins_ref_src_sub_desc' id='rtn_ins_ref_src_sub_desc' value="">

<input type='hidden' name='rtn_non_ins_ref_src_main_code' id='rtn_non_ins_ref_src_main_code' value="">
<input type='hidden' name='rtn_non_ins_ref_src_main_desc' id='rtn_non_ins_ref_src_main_desc' value="">
<input type='hidden' name='rtn_non_ins_ref_src_sub_code' id='rtn_non_ins_ref_src_sub_code' value="">
<input type='hidden' name='rtn_non_ins_ref_src_sub_desc' id='rtn_non_ins_ref_src_sub_desc' value="">

<input type='hidden' name='encounter_date_time' id='encounter_date_time' value='<%=encounter_date_time%>'>
<input type='hidden' name='encounter_date_aft_trunc' id='encounter_date_aft_trunc' value='<%=encounter_date_aft_trunc%>'>

<input type='hidden' name='query_string' id='query_string' value="<%=query_string%>">
<input type='hidden' name='selecltd_bg_frm_pkg' id='selecltd_bg_frm_pkg' value="">
<input type='hidden' name='selecltd_bg_desc_frm_pkg' id='selecltd_bg_desc_frm_pkg' value="">
<input type='hidden' name='selecltd_cust_grp_frm_pkg' id='selecltd_cust_grp_frm_pkg' value="">
<input type='hidden' name='selecltd_cust_frm_pkg' id='selecltd_cust_frm_pkg' value="">
<input type='hidden' name='blng_grp_sel_frm_pkg_YN' id='blng_grp_sel_frm_pkg_YN' value="">

<input type='hidden' name='rtn_tot_valid_enc_with_gl' id='rtn_tot_valid_enc_with_gl' value="">
<input type='hidden' name='rtn_tot_valid_op_enc_with_gl' id='rtn_tot_valid_op_enc_with_gl' value="">
<input type='hidden' name='rtn_tot_valid_ae_enc_with_gl' id='rtn_tot_valid_ae_enc_with_gl' value="">
<input type='hidden' name='rtn_tot_valid_ip_enc_with_gl' id='rtn_tot_valid_ip_enc_with_gl' value="">
<input type='hidden' name='rtn_tot_valid_dc_enc_with_gl' id='rtn_tot_valid_dc_enc_with_gl' value="">

<input type='hidden' name='rtn_tot_availed_enc_with_gl' id='rtn_tot_availed_enc_with_gl' value="">
<input type='hidden' name='rtn_tot_availed_op_enc_with_gl' id='rtn_tot_availed_op_enc_with_gl' value="">
<input type='hidden' name='rtn_tot_availed_ae_enc_with_gl' id='rtn_tot_availed_ae_enc_with_gl' value="">
<input type='hidden' name='rtn_tot_availed_ip_enc_with_gl' id='rtn_tot_availed_ip_enc_with_gl' value="">
<input type='hidden' name='rtn_tot_availed_dc_enc_with_gl' id='rtn_tot_availed_dc_enc_with_gl' value="">

<input type='hidden' name='rtn_gl_doc_ref_exist_YN' id='rtn_gl_doc_ref_exist_YN' value="">
<input type='hidden' name='rtn_pat_ser_code' id='rtn_pat_ser_code' value="">

			<input type='hidden' name='open_pkg_exists_yn' id='open_pkg_exists_yn' value="<%=open_pkg_exists_yn%>">
<!-- Added for Classification Valued Capturing Purpose -->
<input type='hidden' name='rtn_class_type' id='rtn_class_type' value='' >
<input type='hidden' name='rtn_class_code' id='rtn_class_code' value='' >	
<input type='hidden' name='rtn_remarks' id='rtn_remarks' value='' >				
<input type='hidden' name='rtn_social_pensioner_id' id='rtn_social_pensioner_id' value='' >				
<input type='hidden' name='rtn_inc_asset_ind' id='rtn_inc_asset_ind' value='' >			
<input type='hidden' name='rtn_ind_inc' id='rtn_ind_inc' value='' >				
<input type='hidden' name='rtn_ind_inc_freq' id='rtn_ind_inc_freq' value='' >		
<input type='hidden' name='rtn_spouse_inc' id='rtn_spouse_inc' value='' >			
<input type='hidden' name='rtn_spouse_inc_freq' id='rtn_spouse_inc_freq' value='' >	
<input type='hidden' name='rtn_dependent_inc' id='rtn_dependent_inc' value='' >	
<input type='hidden' name='rtn_dependent_inc_freq' id='rtn_dependent_inc_freq' value='' >
<input type='hidden' name='rtn_valid_from' id='rtn_valid_from' value='' >
<input type='hidden' name='rtn_valid_to' id='rtn_valid_to' value='' >
<input type='hidden' name='rtn_last_date' id='rtn_last_date' value=''  />
<input type='hidden' name='package_enabled_yn' id='package_enabled_yn' value="<%=package_enabled_yn%>"  />
<input type='hidden' name='isUserAuthorizedClass' id='isUserAuthorizedClass' value='<%= isUserAuthorizedClass%>'>
<input type='hidden' name='str_charge_logic' id='str_charge_logic' value='<%=str_charge_logic%>'><!-- 48333 -->
<input type='hidden' name='uploadurl' id='uploadurl' value ='../../eBL/jsp/AddModifyInsUpldImgDtl.jsp?pat_view=Y&'>
<input type='hidden' name='customer_id' id='customer_id' value='<%=strCustomerId%>'>
<input type='hidden' name='SiteSpecific' id='SiteSpecific' id='SiteSpecific' value="<%=SiteSpecific%>" /> 
<!-- Added by MuthuN against 32426 on 07-09-12 -->
<input type='hidden' name='payer_suspended_YN' id='payer_suspended_YN' value="<%=payer_suspended_YN%>"   />
<!-- Added by MuthuN against 32426 on 07-09-12 -->
<!-- Added by Rajesh V for CRF - 155 -->
<input type='hidden' name='payerGrpBySetup' id='payerGrpBySetup' value="<%=payerGrpBySetup%>">
<!-- Added by Karthik for 47345 -->
<input type='hidden' name='successfulUserAuthentication' id='successfulUserAuthentication' value='false'>
<!-- Karthik modified Default From Date for MMS-DM-SCF-0214.1 /MMS-DM-SCF-0152.1 Starts  -->
<% 
String firstVisitDateTime="";
if(callingModule.equals("OP")){
	firstVisitDateTime=request.getParameter("vst_regn_date_time"); 
}else if(callingModule.equals("IP")){
	firstVisitDateTime=request.getParameter("encounter_date_time"); 
}	
%>
<input type='hidden' name='firstVisitDateTime' id='firstVisitDateTime' id='firstVisitDateTime' value="<%=firstVisitDateTime%>">

<!--  Karthik added Default From Date for MMS-DM-SCF-0214.1 /MMS-DM-SCF-0152.1 Ends -->
</table>
</form>
</body>
</html>
<%
	/*****
	if (strHealthCardExpired_YN.equals("Y") && (boolPatientFoundMP==true)) 
	{		
		if (!strDfltBillingGroup.equals(mbilling_group))
		{
			out.println("<script>setTimeout('dispExpAlert()',100);</script>");	
		}
	} //Added as request by HMC on 20/8/2002.
	else if (strHealthCard_YN.equals("Y") && alt_id1_exp_date.equals("")&& (boolPatientFoundMP==true)) 
	{
		out.println("<script>setTimeout('dispAlert()',100);</script>");	
	}
	******/
		out.println("<script>setTimeout('funHealthScheme();',500);</script>");	
	
		clinic_code_check=(String)session.getAttribute("clinic_code");
		if(clinic_code_check == null) clinic_code_check="";
		visit_type_code_check=(String)session.getAttribute("visit_type_code");
		if(visit_type_code_check == null) visit_type_code_check="";
		patient_id_check=(String)session.getAttribute("patient_id");
		if(patient_id_check == null) patient_id_check="";
		pract_id_check=(String)session.getAttribute("practitioner_id");
		if(pract_id_check == null) pract_id_check="";
		billing_reset_flag=(String)request.getParameter("billingFlag");
		if(billing_reset_flag==null) billing_reset_flag="";

		pat_ser_code_check = (String)session.getAttribute("pat_ser_code");
		if(pat_ser_code_check == null) pat_ser_code_check="";
//System.err.println("pat_ser_code_check from sess:"+pat_ser_code_check);
//System.err.println("pat_ser_code_check from req:"+pat_ser_code);
		if( ((!clinic_code.equals(clinic_code_check) || !visit_type_code.equals(visit_type_code_check) || !patient_id.equals(patient_id_check) || !strPractitionerId.equals(pract_id_check) || billing_reset_flag.equals("N")) && !strModuleId.equals("MP")) || (strModuleId.equals("MP") && !pat_ser_code_check.equals(pat_ser_code) && charge_for_pat_regn_yn.equals("Y")))
		{
//			System.err.println("Inside Session values clear");
			session.removeAttribute("hosp_panel_str");
			session.removeAttribute("prof_panel_str");
			session.removeAttribute("prof_panel_str_YN");
			session.removeAttribute("hosp_panel_str_YN");
			session.removeAttribute("upd_hosp_chrg_amt");
			session.removeAttribute("upd_hosp_chrg_pat_amt");
			session.removeAttribute("upd_med_chrg_amt");
			session.removeAttribute("upd_med_chrg_pat_amt");
//			System.err.println("Inside Session values hosp_dtls");
			session.removeAttribute("hosp_dtls");
//			System.err.println("Inside Session values prof_dtls");
			session.removeAttribute("prof_dtls");
			session.removeAttribute("fin_dtls_to_chrg_dtls");
			session.removeAttribute("hosp_panel");
			session.removeAttribute("prof_panel");
		}

		session.setAttribute("clinic_code",clinic_code);
		session.setAttribute("visit_type_code",visit_type_code);
		session.setAttribute("patient_id",patient_id);
		session.setAttribute("practitioner_id",strPractitionerId);
		session.setAttribute("pat_ser_code",pat_ser_code);

		if(((billing_mode.equals("Modify") || operation.equals("Update")) && autoFinChk.equals("N")) || ((billing_mode.equals("Modify") || operation.equals("Update")) && autoFinChk.equals("Y") && fin_class_dtls_updated_YN.equals("Y")))
		{
%>
<script>
	parent.frames[1].location.href="../../eBL/jsp/AddModifyPatFinDetails6.jsp?setlmt_ind=<%=str_slmt_ind%>&boolean_security=<%=boolSecurity%>&payerGrpBySetup=<%=payerGrpBySetup%>&adm_rec_flag=<%=str_adm_rec_flag%>&credit_doc_ref_reqd_yn=<%=credit_doc_ref_reqd_yn%>&CitizenYn=<%=strCitizenYn%>&<%=query_string%>";	
</script>
<%
		}
		if(str_valid_pkg_for_pat_bg_avail_YN.equals("Y") || str_valid_pkg_for_pat_avail_YN.equals("Y"))
		{
%>
<script>

//	var sel_frm_valid_pkg_for_pat_id = confirm(getMessage("BL6346","BL"));

	

</script>
<%
		}
	}
	catch(Exception ee)
	{
		out.println("Exception in Details.jsp"+ee);
	}
	finally
	{
		if(pstmt != null)pstmt.close();
	
	}
	putObjectInBean(bean_id,bean,request);
	
	/*Added by Karthik to take Patient Financial details by default - starts */
	
	
	try
	{

		quickAdmissionBillingGroup = "";		
		System.err.println("~~~~~callingModule:"+callingModule);	
		System.err.println("~~~~~callingFunction:"+callingFunction);	
		System.err.println("~~~~~quickAdmission:"+quickAdmission);	
		if(callingModule.equals("IP") && callingFunction.equals("ADMISSION") && quickAdmission.equalsIgnoreCase("Y")){			

			out.println("<script>blnggrplkup();</script>");//blnggrplkup();	
			out.println("<script>setTimeout('sendBackFinDetails();',500)</script>");//blnggrplkup();	
		}

	}
	catch(Exception ee)
	{
		out.println("Exception in quickAdmission:::::: "+ee);
	}
	finally
	{
		if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con, request);
	}
	
	
	/*Added by Karthik to take Patient Financial details by default - ends*/
	
%>

