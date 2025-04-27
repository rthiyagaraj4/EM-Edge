/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOP; 
/********* added for package billing************/
import eBL.*;	

import com.ehis.persist.*;
/********end***********/

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.*;
import webbeans.eCommon.*;
import eOP.VisitRegistration.*;
import eOR.RefusalOrdersBean;

import ecis.utils.OnlineReport;
import ecis.utils.OnlineReports;

import eBL.BLInsuranceImageBean;
import com.ehis.persist.PersistenceHelper;

import eCommon.XSSRequestWrapper;

public class VisitRegistrationServlet extends javax.servlet.http.HttpServlet {

	//Connection con=null;
//	String locale="";
	String req_no = "";
	String addedById = "";
	String sStyle="";
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req,	HttpServletResponse res) throws javax.servlet.ServletException,IOException {
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		
		HttpSession session=null;
		PrintWriter out=null;
		out = res.getWriter();
		session = req.getSession(false);		
		String flag="";
		java.util.Properties p		= null;	
		p = (java.util.Properties) session.getValue("jdbc");
		
		String attributes[] = session.getValueNames();
	//	locale = p.getProperty("LOCALE");		
		for (int j = 0; j < attributes.length; j++) {
			String attr = attributes[j].toString();
			if (attr.equalsIgnoreCase("Flag")) {
				flag = session.getValue(attr).toString();
				session.removeValue(attr);
			}
		}
		flag = (flag == null) ? "" : flag;
		sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		try {	
			
			out.println("<!DOCTYPE html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link><script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='JavaScript'> async function callVisitRegistrationServletHtml (){ ");			
			req_no = req.getParameter("req_no");
			if (req_no == null) req_no = "";
			
			if(req_no =="") {
				insertVisitRegistration(req, res);
			} else {
				boolean inserted = true;
				doOnlineReport(inserted,req, res);
			}
			out.println("} callVisitRegistrationServletHtml ();</script><body></body></html>");
		} catch (Exception e) {
			
			e.printStackTrace();
			out.println(e.toString());
		} finally {
			//if (con != null)
			//	ConnectionManager.returnConnection(con, req);
		}
	}

	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws javax.servlet.ServletException, IOException {
		try {
			PrintWriter out=null;
			out = res.getWriter();
			HttpSession session=null;		
			session = req.getSession(false);	
			//String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE")	: "IeStyle.css";

			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"
							+ sStyle
							+ "'></link><script language='javascript' src='../eMP/js/Occupation.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/commonToolbar.jsp?function_name=Occupation' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void insertVisitRegistration(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		java.util.Properties p=null;
		HttpSession session         = null;
		session           	        = req.getSession(false) ;
		PrintWriter out=null;
		out               	        = res.getWriter() ;
		HashMap tabdata = new HashMap();
		Hashtable tabdata1 = new Hashtable();
		HashMap prencounter = new HashMap();
		Hashtable prencounter1 = new Hashtable();
		HashMap prencounterdetail = new HashMap();
		Hashtable prencounterdetail1 = new Hashtable();
		StringBuffer sb = new StringBuffer();
		java.sql.Date added_date = null;
		
	   //Added by Senthil 
    	int recordCount=0;
		String fm_install_yn = "N";		
		//End Senthil

	java.sql.Date credit_doc_date_d = null;

	java.sql.Date slmt_doc_ref_date_d = null;

	java.sql.Date policy_expiry_date_d = null;

	java.sql.Date modified_date = null;

	String patientId;

	String facilityId;

	String assign_q_num_by;

	String self_chkin_appt_yn	= "N";//Added by Dharma on 24th Feb 2020 against MO-CRF-20155
	boolean fileGenerated = false;

	String pat_ser_grp_code;

	String mr_section_code="";

	String single_or_multi_files_ind;

	String client_ip_address;

	String assign_care_locn_code = "";

	String assign_care_locn_type = "";

	String visit_adm_type = "";

	String oper_stn_id = "";

	String op_episode_id = "";
	String addedDate = "";
    String query_string   ="";
	
	
	//Below line added for this CRF GDOH-CRF-0129
	String assigncare_loctype_ind="";
	String assigncare_locacode="";
	
    //End GDOH-CRF-0129
	
	String form60_YN=""; //Added by Sangeetha for KDAH-CRF-0347 on 14/apr/17

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
			"yyyy-MM-dd");

	String l_encounter_id = "";

	/* this line was commmanted by VenkateshS,Reason is this is "unused variable" while generate checkstyle report  */
	//String flag = "";

	String attend_practitioner_id = "";

	String l_episode_visit_num = "";

	String l_episode_id = "";

	String gen_file_no = "";

	String function_id = "";

	String menu_function_id = "";

	String error_value = "";


	String maintain_doc_or_file = "";

	String patFlag = "N";

	String specialty_code = "";

	String dept_code = "";

	String bill_type_code = "";

	String blng_class_code = "";
	
	
	String old_episode_id = "";

	String op_episode_visit_num = "";

	String emergency_detail = "";

	String service_code = "";

	String subservice_code = "";

	String build_episode_rule = "";

	String ident_at_checkin = "";
	String upt_contact_dtls_oa_yn="";//added changes for HSA-CRF-0226 [IN:050599]

	String gen_file_yn = "";

	String episode_close_days_fu = "";

	String episode_close_days_wo_fu = "";

	String pract_type = "";

	String callFromMPQuery = "";

	String oa_install_yn = "";

	String invitation_no = "";

	String wait_list = "";

	String other_res_code = "";

	String other_res_type = "";

	String appt_id = "";

	String visit_adm_type_ind = "";

	String referral_source_type = "";

	String referral_source_code = "";

	String referral_practitioner_id = "";

	String referral_practitioner_name = "";

	String ambulatory_status = "";

	String h_visit_type_ind = "";

	String new_episode_yn = "";

	String visit_charge_stage = "";

	String bl_interface_yn = "";

	String bl_install_yn = "";

	String billing_group = "";

	String billing_class = "";

	String employer_code = "";

	String cash_set_type1 = "";

	String cash_insmt_ref1 = "";

	String cash_insmt_date1 = "";

	String cash_insmt_rmks1 = "";

	String cust_1 = "", credit_doc_ref1 = "";

	String cust_2 = "", credit_doc_date1 = "";

	String credit_doc_ref2 = "", credit_doc_date2 = "", cust_3 = "";

	String policy_type = "", policy_no = "";

	String policy_expiry_date = "", non_insur_blng_grp = "", cash_set_type2 = "", cash_insmt_ref2 = "";

	String cash_insmt_date2 = "", cash_insmt_rmks2 = "";

	String cust_4 = "", credit_doc_ref3 = "", credit_doc_date3 = "";

	String setlmt_ind = "";

	String upd_fin_dtls = "";

	String annual_income = "";

	String family_asset = "";

	String no_of_dependants = "";

	String resp_for_payment = "";

	String credit_doc_reqd_yn1 = "";

	String credit_doc_reqd_yn2 = "";

	String cred_start_dt1 = "";

	String cred_start_dt2 = "";

	String cred_start_dt3 = "";

	String gl_holder_name = "";

	String gl_holder_reln = "";

	String pkg_serv_code = "";

	String base_qty = "";

	String base_rate = "";

	String base_charge_amt = "";

	String gross_charge_amt = "";

	String disc_amt = "";

	String net_charge_amt = "";

	String pat_base_qty = "";

	String pat_base_rate = "";

	String pat_serv_qty = "";

	String pat_base_charge_amt = "";

	String pat_gross_charge_amt = "";

	String pat_disc_amt = "";

	String pat_net_charge_amt = "";

	String cust_base_qty = "";

	String cust_base_rate = "";

	String cust_serv_qty = "";

	String cust_base_charge_amt = "";

	String cust_gross_charge_amt = "";

	String cust_disc_amt = "";

	String cust_net_charge_amt = "";

	String pkg_ins_pat_ind = "";

	String split_yn = "";

	String pkg_bill_doc_type = "";

	String pkg_bill_doc_num = "";

	String day_type_code = "";

	String time_type_code = "";

	String disc_perc = "";

	String addl_fctr = "";

	String credit_doc_ref_desc = "";

	String credit_doc_date = "";

	String cust_code = "";

	String slmt_type_code = "";

	String slmt_doc_ref_desc = "";

	String slmt_doc_ref_date = "";

	String slmt_doc_remarks = "";

	/* below 5 lines was commmanted by VenkateshS,Reason is this is "unused variable" while generate checkstyle report  */
	
	//String credit_auth_ref = "";

	//String credit_auth_date = "";

	//String effective_date = "";

	//String approved_amt = "0";

	//String approved_days = "0";

	String episode_type = "O";

	String remarks = "";

	String user_id = "";

	String upd_user_flag = "";

	String package_bill_doc_type = "";

	String package_bill_doc_num = "";

	String contact_reason_code = "";

	String other_remarks = ""; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

	String room_no = "";

	String room_type = "";

	String frame_ref = "";

	String pat_class = "";

	String ordering_facility_id = "";

	String order_id = "";

	String order_line_num = "";

	String order_type_code = "";

	HashMap order_catalog_map =new HashMap();
	String order_catalog_code = "";
	String order_category = "";
	String order_category_code = "";
	String multiple_orders_yn = "N";

	String queryString = "";

	String mod_id = "";
	String call_from = "";

	String practWorkingYN = "N";

	String roomWorkingYN = "N";

	String arrival_code = "";

	String escort_name = "";

	String escort_add_ln1 = "";

	String escort_add_ln2 = "";

	String escort_add_ln3 = "";

	String escort_add_ln4 = "";

	String escort_add_postal_code = "";

	String escort_tel_num = "";

	String escort_mv_reg_no = "";

	String encounter_type = "";

	String visit_adm_desc = "";

	String res_tel_no = "";

	String oth_contact_no = "";

	String res_area_code = "";

	String res_town_code = "";

	String res_region_code = "";

	String email_id = "";

	String res_addr_line1 = "";

	String res_addr_line2 = "";

	String res_addr_line3 = "";

	String res_addr_line4 = "";

	String postal_code = "";

	String country_code = "";

	String mail_addr_line1 = "";

	String mail_addr_line2 = "";

	String mail_addr_line3 = "";

	String mail_addr_line4 = "";

	String mail_area_code = "";

	String mail_town_code = "";

	String mail_postal_code = "";

	String mail_region_code = "";

	String mail_country_code = "";

	/*Added by Thamizh selvi on 29th Jan 2018 against ML-MMOH-CRF-0601 Start*/
	String altAddrLine1		= "";
	String altAddrLine2		= "";
	String altAddrLine3		= "";
	String altAddrLine4		= "";
	String altAreaCode		= "";
	String altTownCode		= "";
	String altPostalCode	= "";
	String altRegionCode	= "";
	String altCountryCode	= "";
	/*End*/

	String isPractoApptYn	= "N";
	int reccnt = 0;

	String recordMode = "";

	String recordCnt = "";

	

	String modifiedById = "";

	String modifiedDate = "";

	String addedFacilityId = "";

	String modifiedFacilityId = "";

	String addedAtWorkstation = "";

	String modifiedAtWorkstation = "";

	String ct_date = "";

	String billing_mode = "";

	String error = "";

	String cred_start_dt = "";

	String new_file_no = "";

	String referral_id = "";

	String wait_list_flag = "N";

	String entitlement_by_cat_yn = "";

	String p_hosp_main = "";

	String p_hosp_sub = "";

	String p_card_id = "";

	String p_expiry_date = "";

	String p_privl_type_code = "";

	String vst_regn_date_time = "";

	int cnt1 = 0;

	

	String online_mr_notfn_yn = "N";

	String fs_locn_code = "";

	String success_msg = "";
	String qms_interfaced_yn = "N";
	String multi_speciality_yn = "N";//Added for the CRF - Bru-HIMS-CRF-0198

	//Added for the MMS-SCF-0082
	
	String blng_grp_id="";
	String cust_code_insurance="";
	String cust_grp_code="";
	String policy_type_code="";
	String visit_type_derv_rule="";
	String isAllowRegForSameService = "";

	Boolean isInvokeUploadDocAppl = false;//Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11
	
	//Added by Ashwini on 23-Sep-2022 for TH-KW-CRF-0020.1
	String isQMSInOPVisitRegAppl = "";
	String common_queue_status = "";
	String common_queue_status_msg = "";
	String common_queue_id = "";
	String common_queue_no = "";
	String common_queue_issue_dt_tm = "";
	String common_queue_called_dt_tm = "";
	String virtual_queue_status = "";
	String virtual_queue_status_msg = "";
	String virtual_queue_id = "";
	String virtual_queue_no = "";
	String virtual_queue_issue_dt_tm = "";
	String virtual_queue_called_dt_tm = "";
	String smartCardFunc ="";
	String biometric_reason="";
	p = (java.util.Properties) session.getValue("jdbc");
 
	String locale="";
	locale = p.getProperty("LOCALE");

	facilityId = (String) session.getValue("facility_id");
		client_ip_address = p.getProperty("client_ip_address");

		try {
			con = ConnectionManager.getConnection(req);
			smartCardFunc = eCommon.Common.CommonBean.isSiteSpecificforBiometric(con);//Added by Himanshu for AAKH-CRF-0175
			isInvokeUploadDocAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MP","INVOKE_UPLOAD_DOCUMENT");//Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11

			patientId = req.getParameter("patient_id");
			patientId = (patientId == null) ? "" : patientId;
			self_chkin_appt_yn = req.getParameter("self_chkin_appt_yn");
			self_chkin_appt_yn = (self_chkin_appt_yn == null) ? "N" : self_chkin_appt_yn;
			oper_stn_id = req.getParameter("oper_stn_id");
			oper_stn_id = (oper_stn_id == null) ? "" : oper_stn_id;
			pat_ser_grp_code = req.getParameter("pat_ser_grp_code");
			pat_ser_grp_code = (pat_ser_grp_code == null) ? "" : pat_ser_grp_code;
			if (mr_section_code == null || mr_section_code.equals("null") || mr_section_code == "")
				mr_section_code = "";
			single_or_multi_files_ind = "S";
		assign_q_num_by = req.getParameter("assign_q_num_by") == null ? "S" : req.getParameter("assign_q_num_by");
		service_code = req.getParameter("service_code") == null ? "" : req.getParameter("service_code");
		subservice_code = req.getParameter("subservice_code") == null ? "" : req.getParameter("subservice_code");
		build_episode_rule = req.getParameter("build_episode_rule") == null ? ""	: req.getParameter("build_episode_rule");
		ident_at_checkin = req.getParameter("ident_at_checkin") == null ? ""	: req.getParameter("ident_at_checkin");
		gen_file_yn = req.getParameter("gen_file_yn") == null ? "" : req.getParameter("gen_file_yn");
		episode_close_days_fu = req.getParameter("episode_close_days_fu") == null ? ""	: req.getParameter("episode_close_days_fu");
		episode_close_days_wo_fu = req.getParameter("episode_close_days_wo_fu") == null ?"":req.getParameter("episode_close_days_wo_fu");
		pract_type = req.getParameter("pract_type") == null ? "" : req.getParameter("pract_type");
		callFromMPQuery = req.getParameter("callFromMPQuery") == null ? "N": req.getParameter("callFromMPQuery");
		patFlag = req.getParameter("patFlag") == null ? "N" : req.getParameter("patFlag");
		if (patFlag.equals(""))
			patFlag = "N";
		function_id = (req.getParameter("functionId") == null) ? "" : req.getParameter("functionId");
		menu_function_id = (req.getParameter("menu_function_id") == null) ? "": req.getParameter("menu_function_id");
		entitlement_by_cat_yn = req.getParameter("entitlement_by_cat_yn");
		
		//Below line added for this CRF GDOH-CRF-0129
		assigncare_loctype_ind=(req.getParameter("assigncare_loctype_ind") == null) ? "" : req.getParameter("assigncare_loctype_ind");
		assigncare_locacode=(req.getParameter("assigncare_locacode") == null) ? "" : req.getParameter("assigncare_locacode");		
		//End GDOH-CRF-0129
		isAllowRegForSameService =  req.getParameter("isAllowRegForSameService") == null ? "false": req.getParameter("isAllowRegForSameService");
		
		//Added by Ashwini on 23-Sep-2022 for TH-KW-CRF-0020.1
		isQMSInOPVisitRegAppl = req.getParameter("isQMSInOPVisitRegAppl") == null ? "false": req.getParameter("isQMSInOPVisitRegAppl");
		common_queue_status = (req.getParameter("common_queue_status") == null) ? "" : req.getParameter("common_queue_status");
		common_queue_status_msg = (req.getParameter("common_queue_status_msg") == null) ? "" : req.getParameter("common_queue_status_msg");
		common_queue_id = (req.getParameter("common_queue_id") == null) ? "" : req.getParameter("common_queue_id");
		common_queue_no = (req.getParameter("common_queue_no") == null) ? "" : req.getParameter("common_queue_no");
		common_queue_issue_dt_tm = (req.getParameter("common_queue_issue_dt_tm") == null) ? "" : req.getParameter("common_queue_issue_dt_tm");
		common_queue_called_dt_tm = (req.getParameter("common_queue_called_dt_tm") == null) ? "" : req.getParameter("common_queue_called_dt_tm");
		virtual_queue_status = (req.getParameter("virtual_queue_status") == null) ? "" : req.getParameter("virtual_queue_status");
		virtual_queue_status_msg = (req.getParameter("virtual_queue_status_msg") == null) ? "" : req.getParameter("virtual_queue_status_msg");
		virtual_queue_id = (req.getParameter("virtual_queue_id") == null) ? "" : req.getParameter("virtual_queue_id");
		virtual_queue_no = (req.getParameter("virtual_queue_no") == null) ? "" : req.getParameter("virtual_queue_no");
		virtual_queue_issue_dt_tm = (req.getParameter("virtual_queue_issue_dt_tm") == null) ? "" : req.getParameter("virtual_queue_issue_dt_tm");
		virtual_queue_called_dt_tm = (req.getParameter("virtual_queue_called_dt_tm") == null) ? "" : req.getParameter("virtual_queue_called_dt_tm");
		//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023		
		if(smartCardFunc.equals("01")) {
		biometric_reason							    = (String) session.getValue( "biometric_reason" ) ;
		session.removeAttribute("biometric_reason");
		}
		//Ends	
		//Added by Sangeetha for KDAH-CRF-0347 on 14/apr/17
		form60_YN			=  req.getParameter("form60_YN");
		if((form60_YN==null) || (form60_YN.equals("null")) || (form60_YN=="") || (form60_YN.equals(""))) 	
			form60_YN		= "";

		if (entitlement_by_cat_yn == null)
			entitlement_by_cat_yn = "N";
		if (function_id.equals("PROCD_REGISTRATION") && menu_function_id.equals("VISIT_REGISTRATION"))
			function_id = menu_function_id;
		else
			function_id = function_id;
		
		oa_install_yn = req.getParameter("oa_install_yn") == null ? "N" : req.getParameter("oa_install_yn");
		invitation_no = req.getParameter("invitation_no") == null ? "" : req.getParameter("invitation_no");
		wait_list = req.getParameter("wait_list") == null ? "" : req.getParameter("wait_list");
		wait_list_flag = req.getParameter("wait_list_flag") == null ? "" : req.getParameter("wait_list_flag");
		other_res_code = req.getParameter("other_res_code") == null ? "" : req.getParameter("other_res_code");
		other_res_type = req.getParameter("other_res_type") == null ? "" : req.getParameter("other_res_type");
		visit_adm_type = req.getParameter("visit_adm_type")== null ? "" : req.getParameter("visit_adm_type");
		appt_id = req.getParameter("appt_ref_no")== null ? "" : req.getParameter("appt_ref_no");
		visit_adm_type_ind = req.getParameter("visit_adm_type_ind")== null ? "" : req.getParameter("visit_adm_type_ind");
		assign_care_locn_code = req.getParameter("assign_care_locn_code")== null ? "" : req.getParameter("assign_care_locn_code");
		attend_practitioner_id = req.getParameter("attend_practitioner_id")== null ? "" : req.getParameter("attend_practitioner_id"); 	
		referral_source_type = req.getParameter("referral_source_type")== null ? "" : req	.getParameter("referral_source_type");
		referral_source_code = req.getParameter("referral_source_code")== null ? "" : req.getParameter("referral_source_code");
		referral_practitioner_id = req.getParameter("referral_practitioner_id")== null ? "" : req.getParameter("referral_practitioner_id");
		referral_practitioner_name = req.getParameter("referral_practitioner_text")== null ? "" : req.getParameter("referral_practitioner_text");
		ambulatory_status = req.getParameter("ambulatory_status")== null ? "" : req.getParameter("ambulatory_status");
		h_visit_type_ind = req.getParameter("h_visit_type_ind")== null ? "" : req.getParameter("h_visit_type_ind");
		contact_reason_code = req.getParameter("contact_reason_code")== null ? "" : req.getParameter("contact_reason_code");
		other_remarks = req.getParameter("other_remarks")== null ? "" : req.getParameter("other_remarks"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
		room_no = req.getParameter("room_no1")== null ? "" : req.getParameter("room_no1");
		room_type = req.getParameter("room_type")== null ? "" : req.getParameter("room_type");
		pat_class = req.getParameter("pat_class");
		frame_ref = (req.getParameter("frame_ref") == null) ? "" : req.getParameter("frame_ref");		
		if (appt_id.equals(" ") || appt_id.equals("null"))appt_id = "";
		if (pat_class == null || pat_class.equals(""))pat_class = "OP";
		ordering_facility_id = (req.getParameter("ordering_facility_id") == null) ? "": req.getParameter("ordering_facility_id");
		order_id = (req.getParameter("order_id") == null) ? "" : req.getParameter("order_id");
		order_line_num = (req.getParameter("order_line_num") == null) ? "": req.getParameter("order_line_num");
		order_type_code = (req.getParameter("order_type_code") == null) ? "": req.getParameter("order_type_code");
		query_string = (String) session.getValue("queryString");
		if (queryString == null)
			queryString = "";
		mod_id = req.getParameter("called_from") == null ? "" : req.getParameter("called_from");
		call_from = req.getParameter("call_from") == null ? "" : req.getParameter("call_from");
		vst_regn_date_time = req.getParameter("vst_regn_date_time") == null ? "" : req.getParameter("vst_regn_date_time");
		isPractoApptYn = req.getParameter("isPractoApptYn") == null ? "N" : req.getParameter("isPractoApptYn");
		if(!vst_regn_date_time.equals(""))vst_regn_date_time=com.ehis.util.DateUtils.convertDate(vst_regn_date_time,"DMYHMS",locale, "en");//format changed by Srinivasrao Yeluri for incident  no 29368
	/*	multiple_orders_yn = (req.getParameter("multiple_orders_yn") == null) ? "N": req.getParameter("multiple_orders_yn");
		if(multiple_orders_yn.equals("N"))
		{
			order_catalog_code = (req.getParameter("order_cat_code") == null) ? "": req.getParameter("order_cat_code");
			order_category_code = (req.getParameter("order_category_code") == null) ? "": req.getParameter("order_category_code");
			order_type_code = (req.getParameter("order_type_code") == null) ? "": req.getParameter("order_type_code");
			if(!(order_catalog_code.equals(""))){
				order_catalog_map.put(order_catalog_code,order_category_code);
				order_catalog_map.put(order_catalog_code,order_type_code);
				order_catalog_map.put(order_catalog_code,"Y");
			}
				
		}
		else
		{
			RefusalOrdersBean Orderables = (RefusalOrdersBean) com.ehis.persist.PersistenceHelper.getBeanObject("refusalOrdersBean","eOR.RefusalOrdersBean",req);
			int rec_cnt=Orderables.getSize();
			ArrayList arr= new ArrayList();
			arr= Orderables.getArrayList();
			StringBuffer sb_ord_ctlg = new StringBuffer();
			String order_code = "";
			String order_desc = "";
			for(int i=0;i<rec_cnt;i++)
			{
				String order_string = arr.get(i).toString();
				StringTokenizer order_val = new StringTokenizer(order_string,"$$");
				while(order_val.hasMoreTokens())
				{
					order_code = order_val.nextToken();
					order_desc = order_val.nextToken();
					order_type_code = order_val.nextToken();
					order_category = order_val.nextToken();
					order_catalog_map.put(order_code,order_category);
					order_catalog_map.put(order_code,order_type_code);
					order_catalog_map.put(order_code,"Y");
				//	sb_ord_ctlg.append(order_code);
				//	sb_ord_ctlg.append("|");

				}
			}
			//order_catalog_code = sb_ord_ctlg.toString();
		}		*/
			
		if (appt_id.equals("")) {
			if (!attend_practitioner_id.equals("")) {
				HashMap practWorkingHash = ifPractitionerWorkingYN(facilityId, assign_care_locn_code,attend_practitioner_id, con);
				practWorkingYN = (String) practWorkingHash.get("practWorkingYN");
				practWorkingHash.clear();
			}
		}
		if (practWorkingYN == null)practWorkingYN = "N";
			
		if (practWorkingYN.equals("Y") || attend_practitioner_id.equals("") || !appt_id.equals("")) {
			if (appt_id.equals("")) {
				if (!room_no.equals("")) {
					HashMap roomWorkingHash = ifPractitionerWorkingYN(	facilityId, assign_care_locn_code, room_no, con);
					roomWorkingYN = (String) roomWorkingHash.get("practWorkingYN");
					roomWorkingHash.clear();
				}
			}
			if (roomWorkingYN == null)	roomWorkingYN = "N";

				if (roomWorkingYN.equals("Y") || room_no.equals("") || !appt_id.equals("")) {
			
					new_episode_yn = req.getParameter("new_episode_yn") == null ? "" : req.getParameter("new_episode_yn");
			
					visit_charge_stage = req.getParameter("visit_charge_stage");
			
					bl_interface_yn = req.getParameter("bl_interface_yn");
			
					bl_install_yn = req.getParameter("bl_install_yn");
			
					billing_group = req.getParameter("billing_group");
			
					billing_class = req.getParameter("billing_class");
			
					employer_code = req.getParameter("employer_code");
			
					cash_set_type1 = req.getParameter("cash_set_type1");
			
					cash_insmt_ref1 = req.getParameter("cash_insmt_ref1");
			
					cash_insmt_date1 = req.getParameter("cash_insmt_date1");
			
					cash_insmt_rmks1 = req.getParameter("cash_insmt_rmks1");
			
					cust_1 = req.getParameter("cust_1");
			
					credit_doc_ref1 = req.getParameter("credit_doc_ref1");
			
					credit_doc_date1 = req.getParameter("credit_doc_date1");
			
					cust_2 = req.getParameter("cust_2");
			
					credit_doc_ref2 = req.getParameter("credit_doc_ref2");
			
					credit_doc_date2 = req.getParameter("credit_doc_date2");
			
					cust_3 = req.getParameter("cust_3");
			
					policy_type = req.getParameter("policy_type");
			
					policy_no = req.getParameter("policy_no");
			
					policy_expiry_date = req.getParameter("policy_expiry_date");
			
					non_insur_blng_grp = req.getParameter("non_insur_blng_grp");
			
					cash_set_type2 = req.getParameter("cash_set_type2");
			
					cash_insmt_ref2 = req.getParameter("cash_insmt_ref2");
			
					cash_insmt_date2 = req.getParameter("cash_insmt_date2");
			
					cash_insmt_rmks2 = req.getParameter("cash_insmt_rmks2");
			
					cust_4 = req.getParameter("cust_4");
			
					credit_doc_ref3 = req.getParameter("credit_doc_ref3");
			
					credit_doc_date3 = req.getParameter("credit_doc_date3");
			
					setlmt_ind = req.getParameter("setlmt_ind");
			
					upd_fin_dtls = req.getParameter("upd_fin_dtls");
			
					annual_income = req.getParameter("annual_income");
			
					family_asset = req.getParameter("family_asset");
			
					no_of_dependants = req.getParameter("no_of_dependants");
			
					resp_for_payment = req.getParameter("resp_for_payment");
			
					credit_doc_reqd_yn1 = req.getParameter("credit_doc_reqd_yn1");
			
					credit_doc_reqd_yn2 = req.getParameter("credit_doc_reqd_yn2");
			
					cred_start_dt1 = req.getParameter("cred_start_dt1");
			
					cred_start_dt2 = req.getParameter("cred_start_dt2");
			
					cred_start_dt3 = req.getParameter("cred_start_dt3");
			
					gl_holder_name = req.getParameter("gl_holder_name");
			
					gl_holder_reln = req.getParameter("gl_holder_reln");
			
					pkg_serv_code = req.getParameter("pkg_serv_code");
			
					base_qty = req.getParameter("base_qty");
			
					base_rate = req.getParameter("base_rate");
			
					base_charge_amt = req.getParameter("base_charge_amt");
			
					gross_charge_amt = req.getParameter("gross_charge_amt");
			
					disc_amt = req.getParameter("disc_amt");
			
					net_charge_amt = req.getParameter("net_charge_amt");
			
					pat_base_qty = req.getParameter("pat_base_qty");
			
					pat_base_rate = req.getParameter("pat_base_rate");
			
					pat_serv_qty = req.getParameter("pat_serv_qty");
			
					pat_base_charge_amt = req.getParameter("pat_base_charge_amt");
			
					pat_gross_charge_amt = req.getParameter("pat_gross_charge_amt");
			
					pat_disc_amt = req.getParameter("pat_disc_amt");
			
					pat_net_charge_amt = req.getParameter("pat_net_charge_amt");
			
					cust_base_qty = req.getParameter("cust_base_qty");
			
					cust_base_rate = req.getParameter("cust_base_rate");
			
					cust_serv_qty = req.getParameter("cust_serv_qty");
			
					cust_base_charge_amt = req.getParameter("cust_base_charge_amt");
			
					cust_gross_charge_amt = req.getParameter("cust_gross_charge_amt");
			
					cust_disc_amt = req.getParameter("cust_disc_amt");
			
					cust_net_charge_amt = req.getParameter("cust_net_charge_amt");
			
					pkg_ins_pat_ind = req.getParameter("pkg_ins_pat_ind");
					
					split_yn = req.getParameter("split_yn");
					
					pkg_bill_doc_type = req.getParameter("pkg_bill_doc_type");
					
					pkg_bill_doc_num = req.getParameter("pkg_bill_doc_num");
					
					day_type_code = req.getParameter("day_type_code");
					
					time_type_code = req.getParameter("time_type_code");
					
					disc_perc = req.getParameter("disc_perc");
					
					addl_fctr = req.getParameter("addl_fctr");
					
					remarks = req.getParameter("remarks");
					
					user_id = req.getParameter("user_id");
					
					upd_user_flag = req.getParameter("upd_user_flag");
					
					package_bill_doc_type = req.getParameter("pkg_bill_type");
					
					package_bill_doc_type = req.getParameter("pkg_bill_type");
					
					package_bill_doc_num = req.getParameter("pkg_bill_no");
			
					p_hosp_main = req.getParameter("p_hosp_main");
					
					p_hosp_sub = req.getParameter("p_hosp_sub");
					
					p_card_id = req.getParameter("p_card_id");
					
					p_expiry_date = req.getParameter("p_expiry_date");
					
					p_privl_type_code = req.getParameter("p_privl_type_code");
					
					cred_start_dt = "";
			
					if (cred_start_dt1 == null) cred_start_dt1 = "";
					if (cred_start_dt2 == null) cred_start_dt2 = "";
					if (cred_start_dt3 == null) cred_start_dt3 = "";
					cred_start_dt = (!cred_start_dt1.equals("")) ? cred_start_dt1
							: ((!cred_start_dt2.equals("")) ? cred_start_dt2
									: ((!cred_start_dt3.equals("") ? cred_start_dt3 : "")));
					if (gl_holder_name == null)	gl_holder_name = "";
					if (gl_holder_reln == null) gl_holder_reln = "";
					if (annual_income == null) annual_income = "0";
					if (family_asset == null) family_asset = "0";
					if (no_of_dependants == null) no_of_dependants = "0";
					if (resp_for_payment == null) resp_for_payment = "";
					if (credit_doc_reqd_yn1 == null) credit_doc_reqd_yn1 = "";
					if (credit_doc_reqd_yn2 == null)	credit_doc_reqd_yn2 = "";
					if (pkg_serv_code == null)	pkg_serv_code = "";
					if ((base_qty == null) || (base_qty.equals("")))
						base_qty = "0";
					if ((base_rate == null) || (base_rate.equals("")))
						base_rate = "0";
					if ((base_charge_amt == null) || (base_charge_amt.equals("")))
						base_charge_amt = "0";
					if ((gross_charge_amt == null) || (gross_charge_amt.equals("")))
						gross_charge_amt = "0";
					if ((disc_amt == null) || (disc_amt.equals("")))
						disc_amt = "0";
					if ((net_charge_amt == null) || (net_charge_amt.equals("")))
						net_charge_amt = "0";
					if ((pat_base_qty == null) || (pat_base_qty.equals("")))
						pat_base_qty = "0";
					if ((pat_base_rate == null) || (pat_base_rate.equals("")))
						pat_base_rate = "0";
					if ((pat_serv_qty == null) || (pat_serv_qty.equals("")))
						pat_serv_qty = "0";
					if ((pat_base_charge_amt == null) || (pat_base_charge_amt.equals("")))
						pat_base_charge_amt = "0";
					if ((pat_gross_charge_amt == null) || (pat_gross_charge_amt.equals("")))
						pat_gross_charge_amt = "0";
					if ((pat_disc_amt == null) || (pat_disc_amt.equals("")))
						pat_disc_amt = "0";
					if ((pat_net_charge_amt == null) || (pat_net_charge_amt.equals("")))
						pat_net_charge_amt = "0";
					if ((cust_base_qty == null) || (cust_base_qty.equals("")))
						cust_base_qty = "0";
					if ((cust_base_rate == null) || (cust_base_rate.equals("")))
						cust_base_rate = "0";
					if ((cust_serv_qty == null) || (cust_serv_qty.equals("")))
						cust_serv_qty = "0";
					if ((cust_base_charge_amt == null) || (cust_base_charge_amt.equals("")))
						cust_base_charge_amt = "0";
					if ((cust_gross_charge_amt == null)	|| (cust_gross_charge_amt.equals("")))
						cust_gross_charge_amt = "0";
					if ((cust_disc_amt == null) || (cust_disc_amt.equals("")))
						cust_disc_amt = "0";
					if ((cust_net_charge_amt == null) || (cust_net_charge_amt.equals("")))
						cust_net_charge_amt = "0";
					if (pkg_ins_pat_ind == null)
						pkg_ins_pat_ind = "";
					if (split_yn == null)
						split_yn = "";
					if ((pkg_bill_doc_type == null) || (pkg_bill_doc_type.equals("null")))
						pkg_bill_doc_type = "";
					if (pkg_bill_doc_num == null)
						pkg_bill_doc_num = "0";
					if ((day_type_code == null) || (day_type_code.equals("")))
						day_type_code = "";
					if ((time_type_code == null) || (time_type_code.equals("")))
						time_type_code = "";
					if ((disc_perc == null) || (disc_perc.equals("")))
						disc_perc = "0";
					if ((addl_fctr == null) || (addl_fctr.equals("")))
						addl_fctr = "1";
					if (user_id == null)
						user_id = "";
					if (upd_user_flag == null)
						upd_user_flag = "";
					if ((package_bill_doc_type == null) || (package_bill_doc_type.equals("null")))
						package_bill_doc_type = "";
					if ((package_bill_doc_num == null) || (package_bill_doc_num.equals("")))
						package_bill_doc_num = "0";
					if (visit_charge_stage == null)
						visit_charge_stage = "";
					if (bl_interface_yn == null)
						bl_interface_yn = "";
					if (billing_group == null)
						billing_group = "";
					if (billing_class == null)
						billing_class = "";
					if (employer_code == null)
						employer_code = "";
					if (cash_set_type1 == null)
						cash_set_type1 = "";
					if (cash_insmt_ref1 == null)
						cash_insmt_ref1 = "";
					if (cash_insmt_date1 == null)
						cash_insmt_date1 = "";
					if (cash_insmt_rmks1 == null)
						cash_insmt_rmks1 = "";
					if (cust_1 == null)
						cust_1 = "";
					if (credit_doc_ref1 == null)
						credit_doc_ref1 = "";
					if (credit_doc_date1 == null)
						credit_doc_date1 = "";
					if (cust_2 == null)
						cust_2 = "";
					if (credit_doc_ref2 == null)
						credit_doc_ref2 = "";
					if (credit_doc_date2 == null)
						credit_doc_date2 = "";
					if (cust_3 == null)
						cust_3 = "";
					if (policy_type == null)
						policy_type = "";
					if (policy_no == null)
						policy_no = "";
					if (policy_expiry_date == null)
						policy_expiry_date = "";
					if (non_insur_blng_grp == null)
						non_insur_blng_grp = "";
					if (cash_set_type2 == null)
						cash_set_type2 = "";
					if (cash_insmt_ref2 == null)
						cash_insmt_ref2 = "";
					if (cash_insmt_date2 == null)
						cash_insmt_date2 = "";
					if (cash_insmt_rmks2 == null)
						cash_insmt_rmks2 = "";
					if (cust_4 == null)
						cust_4 = "";
					if (credit_doc_ref3 == null)
						credit_doc_ref3 = "";
					if (credit_doc_date3 == null)
						credit_doc_date3 = "";
					if (setlmt_ind == null)
						setlmt_ind = "";
					if (upd_fin_dtls == null)
						upd_fin_dtls = "";
					if (!(credit_doc_ref1.equals("")))
						credit_doc_ref_desc = credit_doc_ref1;
					if (!(credit_doc_ref2.equals("")))
						credit_doc_ref_desc = credit_doc_ref2;
					if (!(credit_doc_ref3.equals("")))
						credit_doc_ref_desc = credit_doc_ref3;
					if (!(credit_doc_date1.equals("")))
						credit_doc_date = credit_doc_date1;
					if (!(credit_doc_date2.equals("")))
						credit_doc_date = credit_doc_date2;
					if (!(credit_doc_date3.equals("")))
						credit_doc_date = credit_doc_date3;
					if (!(cust_1.equals("")))
						cust_code = cust_1;
					if (!(cust_2.equals("")))
						cust_code = cust_2;
					if (!(cust_3.equals("")))
						cust_code = cust_3;
					if (!(cash_set_type1.equals("")))
						slmt_type_code = cash_set_type1;
					if (!(cash_set_type2.equals("")))
						slmt_type_code = cash_set_type2;
					if (!(cash_insmt_ref1.equals("")))
						slmt_doc_ref_desc = cash_insmt_ref1;
					if (!(cash_insmt_ref2.equals("")))
						slmt_doc_ref_desc = cash_insmt_ref2;
					if (!(cash_insmt_date1.equals("")))
						slmt_doc_ref_date = cash_insmt_date1;
					if (!(cash_insmt_date2.equals("")))
						slmt_doc_ref_date = cash_insmt_date2;
					if (!(cash_insmt_rmks1.equals("")))
						slmt_doc_remarks = cash_insmt_rmks1;
					if (!(cash_insmt_rmks2.equals("")))
						slmt_doc_remarks = cash_insmt_rmks2;
			
					if (p_hosp_main == null)
						p_hosp_main = "";
					if (p_hosp_sub == null)
						p_hosp_sub = "";
					if (p_card_id == null)
						p_card_id = "";
					if (p_expiry_date == null)
						p_expiry_date = "";
					if (p_privl_type_code == null)
						p_privl_type_code = "";		
			
					if (credit_doc_date != null && (!(credit_doc_date.equals("")))) {
						StringTokenizer stoken = new StringTokenizer(credit_doc_date,"/");
						String dd = stoken.nextToken();
						String mm = stoken.nextToken();
						String yyyy = stoken.nextToken();
						credit_doc_date = yyyy + "-" + mm + "-" + dd;
					}
			
					if (slmt_doc_ref_date != null && (!(slmt_doc_ref_date.equals("")))) {
			
						StringTokenizer stoken1 = new StringTokenizer(slmt_doc_ref_date, "/");
						String dd = stoken1.nextToken();
						String mm = stoken1.nextToken();
						String yyyy = stoken1.nextToken();
						slmt_doc_ref_date = yyyy + "-" + mm + "-" + dd;
					}
			
					if (policy_expiry_date != null
							&& (!(policy_expiry_date.equals("")))) {
						StringTokenizer stoken2 = new StringTokenizer(
								policy_expiry_date, "/");
						String dd = stoken2.nextToken();
						String mm = stoken2.nextToken();
						String yyyy = stoken2.nextToken();
						policy_expiry_date = yyyy + "-" + mm + "-" + dd;
					}
			
					if (!(credit_doc_date.equals(""))) {
						credit_doc_date_d = java.sql.Date.valueOf(credit_doc_date);
					}
			
					if (!(slmt_doc_ref_date.equals(""))) {
						slmt_doc_ref_date_d = java.sql.Date.valueOf(slmt_doc_ref_date);
					}
			
					if (!(policy_expiry_date.equals(""))) {
						policy_expiry_date_d = java.sql.Date
								.valueOf(policy_expiry_date);
					}		
					
					billing_mode = req.getParameter("billing_mode");
					if (billing_mode == null)
						billing_mode = "";
					if (bl_interface_yn.equals("Y")) {
						bill_type_code = "";
						blng_class_code = "";
					}
			
					if (!(req.getParameter("episodeReqd").equals("X"))) {
						op_episode_id = req.getParameter("op_episode_id");
						old_episode_id = req.getParameter("old_episode_no");
						op_episode_visit_num = req.getParameter("op_episode_visit_num");
					}
			
					arrival_code = req.getParameter("arrival_code");
			
					escort_name = req.getParameter("escort_name");
			
					escort_add_ln1 = req.getParameter("escort_add_ln1");
			
					escort_add_ln2 = req.getParameter("escort_add_ln2");
			
					escort_add_ln3 = req.getParameter("escort_add_ln3");
			
					escort_add_ln4 = req.getParameter("escort_add_ln4");
			
					escort_add_postal_code = req.getParameter("escort_add_postal_code");
			
					escort_tel_num = req.getParameter("escort_tel_num");
			
					escort_mv_reg_no = req.getParameter("escort_mv_reg_no");
			
					encounter_type = req.getParameter("encounter_type");
			
					emergency_detail = req.getParameter("emergency_details");
			        upt_contact_dtls_oa_yn=req.getParameter("upt_contact_dtls_oa_yn"); //added changes for HSA-CRF-0226 [IN:050599]
					visit_adm_desc = req.getParameter("visit_adm_desc");
					multi_speciality_yn = req.getParameter("multi_speciality_yn")==null?"N":req.getParameter("multi_speciality_yn");//Added for the CRF - BRU-HIMS-CRF 0198
					blng_grp_id = req.getParameter("blng_grp_id")==null?"":req.getParameter("blng_grp_id");//Added for the SCF - MMS-SCF-0082
					cust_code_insurance = req.getParameter("cust_code")==null?"":req.getParameter("cust_code");//Added for the SCF - MMS-SCF-0082
					cust_grp_code = req.getParameter("cust_grp_code")==null?"":req.getParameter("cust_grp_code");//Added for the SCF - MMS-SCF-0082
					policy_type_code= req.getParameter("policy_type_code")==null?"":req.getParameter("policy_type_code");//Added for the SCF - MMS-SCF-0082
					visit_type_derv_rule= req.getParameter("visit_type_derv_rule")==null?"S":req.getParameter("visit_type_derv_rule");//Added for the SCF - MMS-SCF-0082
			
					if (visit_adm_desc == null)
						visit_adm_desc = "";
					if (arrival_code == null)
						arrival_code = "";
					if (escort_name == null)
						escort_name = "";
					if (escort_add_ln1 == null)
						escort_add_ln1 = "";
					if (escort_add_ln2 == null)
						escort_add_ln2 = "";
					if (escort_add_ln3 == null)
						escort_add_ln3 = "";
					if (escort_add_ln4 == null)
						escort_add_ln4 = "";
					if (escort_add_postal_code == null)
						escort_add_postal_code = "";
					if (escort_tel_num == null)
						escort_tel_num = "";
					if (escort_mv_reg_no == null)
						escort_mv_reg_no = "";
					if (encounter_type == null)
						encounter_type = "";
					if (emergency_detail == null)
						emergency_detail = "";
					if (visit_adm_desc == null)
						visit_adm_desc = "";
			
					addedById = p.getProperty("login_user");
					addedDate = dateFormat.format(new java.util.Date());
					modifiedById = addedById;
					modifiedDate = addedDate;
					addedFacilityId = facilityId;
					modifiedFacilityId = addedFacilityId;
					addedAtWorkstation = client_ip_address;
					modifiedAtWorkstation = addedAtWorkstation;
			
					res_tel_no = req.getParameter("contact1_no");
			
					oth_contact_no = req.getParameter("contact2_no");
			
					res_area_code = req.getParameter("res_area_code");
			
					res_town_code = req.getParameter("res_town_code");
			
					res_region_code = req.getParameter("region_code");
			
					email_id = req.getParameter("email");
			
					res_addr_line1 = req.getParameter("addr_line1");
			
					res_addr_line2 = req.getParameter("addr_line2");
			
					res_addr_line3 = req.getParameter("addr_line3");
			
					res_addr_line4 = req.getParameter("addr_line4");
			
					postal_code = req.getParameter("postal_code");
			
					country_code = req.getParameter("country_code");
			
					mail_addr_line1 = req.getParameter("mail_addr_line1");
			
					mail_addr_line2 = req.getParameter("mail_addr_line2");
			
					mail_addr_line3 = req.getParameter("mail_addr_line3");
			
					mail_addr_line4 = req.getParameter("mail_addr_line4");
			
					mail_area_code = req.getParameter("mail_res_area_code");
			
					mail_town_code = req.getParameter("mail_res_town_code");
			
					mail_postal_code = req.getParameter("mail_postal_code");
			
					mail_region_code = req.getParameter("mail_region_code");
			
					mail_country_code = req.getParameter("mail_country_code");
					
					/*Added by Thamizh selvi on 29th Jan 2018 against ML-MMOH-CRF-0601 Start*/
					altAddrLine1	= checkForNull(req.getParameter("alt_addr_line1"));
					altAddrLine2	= checkForNull(req.getParameter("alt_addr_line2"));
					altAddrLine3	= checkForNull(req.getParameter("alt_addr_line3"));
					altAddrLine4	= checkForNull(req.getParameter("alt_addr_line4"));
					altAreaCode		= checkForNull(req.getParameter("alt_area_code"));
					altTownCode		= checkForNull(req.getParameter("alt_town_code"));
					altPostalCode	= checkForNull(req.getParameter("alt_postal_code"));
					altRegionCode	= checkForNull(req.getParameter("alt_region_code"));
					altCountryCode	= checkForNull(req.getParameter("alt_country_code"));
					/*End*/
					
					recordCnt = req.getParameter("reccnt");
			
					if ((recordCnt == null) || (recordCnt.equals("")))
						recordCnt = "0";
					reccnt = Integer.parseInt(recordCnt);
					if (reccnt > 0)
						recordMode = "U";
					else
						recordMode = "I";
					
					added_date = java.sql.Date.valueOf(addedDate);
					modified_date = java.sql.Date.valueOf(modifiedDate);
					qms_interfaced_yn=eOP.QMSInterface.isClinicQMSInterfaced(assign_care_locn_code,facilityId,con);
					try {
						//con = ConnectionManager.getConnection(req); 	
						pstmt = con
								.prepareStatement("select clinic_type,speciality_code, dept_code,to_char(sysdate,'dd/mm/yyyy') ct_date,online_mr_notfn_yn,mr_location_code from op_clinic where clinic_code = '"
										+ assign_care_locn_code
										+ "' and facility_id='"
										+ facilityId + "'");
						rs = pstmt.executeQuery();
						if (rs.next()) {
							assign_care_locn_type = rs.getString(1);
							specialty_code = rs.getString(2);
							dept_code = rs.getString(3);
							ct_date = rs.getString("ct_date");
							online_mr_notfn_yn = rs.getString("online_mr_notfn_yn");
							fs_locn_code	   = rs.getString("mr_location_code");
			
							if (specialty_code == null)
								specialty_code = "";
							if (dept_code == null)
								dept_code = "";
						}
						pstmt.close();
						rs.close();
			
						ResultSet rs_temp = null;
						Statement st_temp = con.createStatement();
						if (h_visit_type_ind.equals("")) {
							String sql_temp = "select  visit_type_ind from op_visit_type where visit_type_code='"
									+ visit_adm_type
									+ "' and facility_id='"
									+ facilityId
									+ "'";
							rs_temp = st_temp.executeQuery(sql_temp);
							if (rs_temp != null) {
								if (rs_temp.next()) {
									h_visit_type_ind = rs_temp.getString(1);
								}
							}
						}
						if (rs_temp != null)
							rs_temp.close();
						if (st_temp != null)
							st_temp.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
			
					tabdata.clear();
					tabdata.put("facility_id", facilityId);
					tabdata.put("assign_q_num_by", assign_q_num_by);
					tabdata.put("qms_interfaced_yn", qms_interfaced_yn);
					tabdata.put("patient_id", patientId);
					tabdata.put("service_code", service_code);
					tabdata.put("subservice_code", subservice_code);
					tabdata.put("build_episode_rule", build_episode_rule);
					tabdata.put("pat_ser_grp_code", pat_ser_grp_code);
					tabdata.put("mr_section_code", mr_section_code);
					tabdata.put("single_or_multi_files_ind", single_or_multi_files_ind);
					tabdata.put("ident_at_checkin", ident_at_checkin);
					tabdata.put("patient_class", h_visit_type_ind);
					tabdata.put("gen_file_yn", gen_file_yn);
					tabdata.put("appt_id", appt_id);
					tabdata.put("episode_close_days_fu", episode_close_days_fu);
					tabdata.put("episode_close_days_wo_fu", episode_close_days_wo_fu);
					tabdata.put("invitation_no", invitation_no);
					tabdata.put("wait_list_flag", wait_list_flag);
					tabdata.put("other_res_code", other_res_code);
					tabdata.put("other_res_type", other_res_type);
					tabdata.put("ct_date", ct_date);
					tabdata.put("op_episode_id", op_episode_id);
					tabdata.put("old_episode_id", old_episode_id);
					tabdata.put("new_episode_yn", new_episode_yn);
					tabdata.put("pract_type", pract_type);
					tabdata.put("room_no", room_no);
					tabdata.put("room_type", room_type);
					tabdata.put("added_by_id", addedById);
					tabdata.put("added_date", added_date);
					tabdata.put("added_facility_id", facilityId);
					tabdata.put("added_at_ws_no", addedAtWorkstation);
					tabdata.put("modified_by_id", modifiedById);
					tabdata.put("modified_date", modified_date);
					tabdata.put("modified_facility_id", modifiedFacilityId);
					tabdata.put("modified_at_ws_no", modifiedAtWorkstation);
					tabdata.put("bl_interface_yn", bl_interface_yn);
					tabdata.put("bl_install_yn", bl_install_yn);
					tabdata.put("visit_charge_stage", visit_charge_stage);
					tabdata.put("billing_group", billing_group);
			
					if(bl_install_yn.equalsIgnoreCase("y")){
						HashMap fin_dtls=(HashMap)session.getAttribute("financial_details");
						tabdata.put("fin_dtls",(HashMap)fin_dtls);
						String bean_id		= "PkgSubsBean" ;
						String bean_name	= "eBL.PkgSubsBean";
						PkgSubsBean bean			= (PkgSubsBean)PersistenceHelper.getBeanObject( bean_id, bean_name, req ) ;			
				
						HashMap  patPackSubsDtls=bean.getPatientPackSubsDtls();		
						
						tabdata.put("PACKAGE_DET",(HashMap)patPackSubsDtls);
						
						String bean_id1		= "PkgAssociateBean" ;
						String bean_name1	= "eBL.PkgAssociateBean";
						PkgAssociateBean bean1			= (PkgAssociateBean)PersistenceHelper.getBeanObject( bean_id1, bean_name1, req ) ;			
				
						ArrayList  patPackAssociateDtls=(ArrayList)bean1.getAssociatedPkgs();		
					
						tabdata.put("PACKAGE_ASSOCIATED",patPackAssociateDtls);
						
						String bean_id2		= "PkgApprovalBean" ;
						String bean_name2	= "eBL.PkgApprovalBean";
						PkgApprovalBean bean2			= (PkgApprovalBean)PersistenceHelper.getBeanObject( bean_id2, bean_name2, req ) ;			
				
						HashMap  patPackApprvDtls=(HashMap)bean2.getPayerDtls();		
					
						tabdata.put("PACKAGE_APPROVALS",patPackApprvDtls);
						
						
						String bean_id3		= "PkgDiscountBean" ;
						String bean_name3	= "eBL.PkgDiscountBean";
						PkgDiscountBean bean3			= (PkgDiscountBean)PersistenceHelper.getBeanObject( bean_id3, bean_name3, req ) ;			
				
						ArrayList  patPackDiscountDtls=(ArrayList)bean3.getdiscPkgs();
						
						tabdata.put("PACKAGE_DISCOUNT",patPackDiscountDtls);
					}
					
					tabdata.put("episode_type", episode_type);
					tabdata.put("recordMode", recordMode);
					tabdata.put("dept_code", dept_code);
					tabdata.put("bill_type_code", bill_type_code);
					tabdata.put("pkg_serv_code", pkg_serv_code);
					tabdata.put("base_qty", base_qty);
					tabdata.put("base_rate", base_rate);
					tabdata.put("base_charge_amt", base_charge_amt);
					tabdata.put("gross_charge_amt", gross_charge_amt);
					tabdata.put("disc_amt", disc_amt);
					tabdata.put("net_charge_amt", net_charge_amt);
					tabdata.put("pat_base_qty", pat_base_qty);
					tabdata.put("pat_base_rate", pat_base_rate);
					tabdata.put("pat_serv_qty", pat_serv_qty);
					tabdata.put("pat_base_charge_amt", pat_base_charge_amt);
					tabdata.put("pat_gross_charge_amt", pat_gross_charge_amt);
					tabdata.put("pat_disc_amt", pat_disc_amt);
					tabdata.put("pat_net_charge_amt", pat_net_charge_amt);
					tabdata.put("cust_base_qty", cust_base_qty);
					tabdata.put("cust_base_rate", cust_base_rate);
					tabdata.put("cust_serv_qty", cust_serv_qty);
					tabdata.put("cust_base_charge_amt", cust_base_charge_amt);
					tabdata.put("cust_gross_charge_amt", cust_gross_charge_amt);
					tabdata.put("cust_disc_amt", cust_disc_amt);
					tabdata.put("cust_net_charge_amt", cust_net_charge_amt);
					tabdata.put("pkg_ins_pat_ind", pkg_ins_pat_ind);
					tabdata.put("split_yn", split_yn);
					tabdata.put("pkg_bill_doc_type", pkg_bill_doc_type);
					tabdata.put("pkg_bill_doc_num", pkg_bill_doc_num);
					tabdata.put("day_type_code", day_type_code);
					tabdata.put("time_type_code", time_type_code);
					tabdata.put("disc_perc", disc_perc);
					tabdata.put("addl_fctr", addl_fctr);
					tabdata.put("upd_user_flag", upd_user_flag);
					tabdata.put("user_id", user_id);
					tabdata.put("module_id", "OP");
					tabdata.put("mod_id", mod_id);
					tabdata.put("cred_start_date", cred_start_dt + "");
					tabdata.put("gl_holder_name", gl_holder_name + "");
					tabdata.put("gl_holder_reln", gl_holder_reln + "");
					tabdata.put("res_tel_no", res_tel_no);
					tabdata.put("oth_contact_no", oth_contact_no);
					tabdata.put("res_area_code", res_area_code);
					tabdata.put("res_town_code", res_town_code);
					tabdata.put("res_region_code", res_region_code);
					tabdata.put("email_id", email_id);
					tabdata.put("res_addr_line1", res_addr_line1);
					tabdata.put("res_addr_line2", res_addr_line2);
					tabdata.put("res_addr_line3", res_addr_line3);
					tabdata.put("res_addr_line4", res_addr_line4);
					tabdata.put("postal_code", postal_code);
					tabdata.put("country_code", country_code);
					tabdata.put("mail_addr_line1", mail_addr_line1);
					tabdata.put("mail_addr_line2", mail_addr_line2);
					tabdata.put("mail_addr_line3", mail_addr_line3);
					tabdata.put("mail_addr_line4", mail_addr_line4);
					tabdata.put("mail_area_code", mail_area_code);
					tabdata.put("mail_town_code", mail_town_code);
					tabdata.put("mail_postal_code", mail_postal_code);
					tabdata.put("mail_region_code", mail_region_code);
					tabdata.put("mail_country_code", mail_country_code);
					tabdata.put("ordering_facility_id", ordering_facility_id);
					tabdata.put("order_id", order_id);
					tabdata.put("order_line_num", order_line_num);
					tabdata.put("order_type_code", order_type_code);
					tabdata.put("order_catalog_map", order_catalog_map);
					tabdata.put("REQUEST", req);
					tabdata.put("p_hosp_main", p_hosp_main);
					tabdata.put("p_hosp_sub", p_hosp_sub);
					tabdata.put("p_card_id", p_card_id);
					tabdata.put("p_expiry_date", p_expiry_date);
					tabdata.put("p_privl_type_code", p_privl_type_code);
					tabdata.put("vst_regn_date_time", vst_regn_date_time);
					tabdata.put("self_chkin_appt_yn", self_chkin_appt_yn);/*Added by Dharma on 24th Feb 2020 against MO-CRF-20155*/
					tabdata.put("isPractoApptYn", isPractoApptYn);
					tabdata.put("multi_speciality_yn", multi_speciality_yn);//Added for the CRF - Bru-HIMS-CRF-0198
					tabdata.put("blng_grp_id",blng_grp_id);//Added for the SCF - MMS-SCF-0082
					tabdata.put("cust_code",cust_code_insurance); //Added for the SCF - MMS-SCF-0082
					tabdata.put("cust_grp_code",cust_grp_code);//Added for the SCF - MMS-SCF-0082
					tabdata.put("policy_type_code",policy_type_code);//Added for the SCF - MMS-SCF-0082
					tabdata.put("visit_type_derv_rule",visit_type_derv_rule);//Added for the SCF - MMS-SCF-0082
					tabdata.put("upt_contact_dtls_oa_yn",upt_contact_dtls_oa_yn);//added changes for HSA-CRF-0226 [IN:050599]
					/*Added by Thamizh selvi on 29th Jan 2018 against ML-MMOH-CRF-0601 Start*/
					tabdata.put("altAddrLine1",altAddrLine1);
					tabdata.put("altAddrLine2",altAddrLine2);
					tabdata.put("altAddrLine3",altAddrLine3);
					tabdata.put("altAddrLine4",altAddrLine4);
					tabdata.put("altAreaCode",altAreaCode);
					tabdata.put("altTownCode",altTownCode);
					tabdata.put("altPostalCode",altPostalCode);
					tabdata.put("altRegionCode",altRegionCode);
					tabdata.put("altCountryCode",altCountryCode);
					/*End*/
					tabdata.put("isAllowRegForSameService",isAllowRegForSameService);
			
					//Added by Ashwini on 23-Sep-2022 for TH-KW-CRF-0020.1
					tabdata.put("isQMSInOPVisitRegAppl",isQMSInOPVisitRegAppl);
					tabdata.put("common_queue_status",common_queue_status);
					tabdata.put("common_queue_status_msg",common_queue_status_msg);
					tabdata.put("common_queue_id",common_queue_id);
					tabdata.put("common_queue_no",common_queue_no);
					tabdata.put("common_queue_issue_dt_tm",common_queue_issue_dt_tm);
					tabdata.put("common_queue_called_dt_tm",common_queue_called_dt_tm);
					tabdata.put("virtual_queue_status",virtual_queue_status);
					tabdata.put("virtual_queue_status_msg",virtual_queue_status_msg);
					tabdata.put("virtual_queue_id",virtual_queue_id);
					tabdata.put("virtual_queue_no",virtual_queue_no);
					tabdata.put("virtual_queue_issue_dt_tm",virtual_queue_issue_dt_tm);
					tabdata.put("virtual_queue_called_dt_tm",virtual_queue_called_dt_tm);
					
					//Added By Himanshu on 25-08-23 for AAKH-CRF-0175
					tabdata.put("biometric_reason",biometric_reason);
				
					tabdata1.clear();
					tabdata1.put("facility_id", facilityId);
					tabdata1.put("patient_id", patientId);
					tabdata1.put("service_code", service_code);
					tabdata1.put("subservice_code", subservice_code);
					tabdata1.put("build_episode_rule", build_episode_rule);
					tabdata1.put("pat_ser_grp_code", pat_ser_grp_code);
					tabdata1.put("mr_section_code", mr_section_code);
					tabdata1.put("single_or_multi_files_ind", single_or_multi_files_ind);
					tabdata1.put("ident_at_checkin", ident_at_checkin);
					tabdata1.put("patient_class", h_visit_type_ind);
					tabdata1.put("gen_file_yn", gen_file_yn);
					tabdata1.put("appt_id", appt_id);
					tabdata1.put("episode_close_days_fu", episode_close_days_fu);
					tabdata1.put("episode_close_days_wo_fu", episode_close_days_wo_fu);
					tabdata1.put("invitation_no", invitation_no);
					tabdata1.put("op_episode_id", op_episode_id);
					tabdata1.put("old_episode_id", old_episode_id);
					tabdata1.put("new_episode_yn", new_episode_yn);
					tabdata1.put("pract_type", pract_type);
					tabdata1.put("room_no", room_no);
					tabdata1.put("room_type", room_type);
					tabdata1.put("added_by_id", addedById);
					tabdata1.put("added_date", added_date);
					tabdata1.put("added_facility_id", facilityId);
					tabdata1.put("added_at_ws_no", addedAtWorkstation);
					tabdata1.put("modified_by_id", modifiedById);
					tabdata1.put("modified_date", modified_date);
					tabdata1.put("modified_facility_id", modifiedFacilityId);
					tabdata1.put("modified_at_ws_no", modifiedAtWorkstation);
					tabdata1.put("bl_interface_yn", bl_interface_yn);
					tabdata1.put("bl_install_yn", bl_install_yn);
					tabdata1.put("visit_charge_stage", visit_charge_stage);
					tabdata1.put("billing_group", billing_group);
					
					if(bl_install_yn.equalsIgnoreCase("y")) {
						HashMap fin_dtls= (HashMap)session.getAttribute("financial_details");
						tabdata1.put("fin_dtls",(HashMap)fin_dtls);
						String bean_id		= "PkgSubsBean" ;
						String bean_name	= "eBL.PkgSubsBean";
						PkgSubsBean bean			= (PkgSubsBean)PersistenceHelper.getBeanObject( bean_id, bean_name, req ) ;			
			
						HashMap  patPackSubsDtls=bean.getPatientPackSubsDtls();		
			
						tabdata1.put("PACKAGE_DET",(HashMap)patPackSubsDtls);
						
						String bean_id1		= "PkgAssociateBean" ;
						String bean_name1	= "eBL.PkgAssociateBean";
						PkgAssociateBean bean1			= (PkgAssociateBean)PersistenceHelper.getBeanObject( bean_id1, bean_name1, req ) ;			
			
						ArrayList  patPackAssociateDtls=(ArrayList)bean1.getAssociatedPkgs();		
						tabdata1.put("PACKAGE_ASSOCIATED",patPackAssociateDtls);
						
						String bean_id2		= "PkgApprovalBean" ;
						String bean_name2	= "eBL.PkgApprovalBean";
						PkgApprovalBean bean2		= (PkgApprovalBean)PersistenceHelper.getBeanObject( bean_id2, bean_name2, req ) ;
						HashMap  patPackApprvDtls=(HashMap)bean2.getPayerDtls();		
						tabdata1.put("PACKAGE_APPROVALS",patPackApprvDtls);
			
						HashMap  payerEligibilityDtlsMap=(HashMap)bean2.getPayerDtls();		
						tabdata1.put("PAYER_ELIGIBILITY_CHECK_MAP",payerEligibilityDtlsMap);
						
						String bean_id3		= "PkgDiscountBean" ;
						String bean_name3	= "eBL.PkgDiscountBean";
						PkgDiscountBean bean4			= (PkgDiscountBean)PersistenceHelper.getBeanObject( bean_id3, bean_name3, req ) ;			
			
						ArrayList  patPackDiscountDtls=(ArrayList)bean4.getdiscPkgs();
						
						tabdata1.put("PACKAGE_DISCOUNT",patPackDiscountDtls);
						
						
			
						bean_id		= "PkgEnterReceptRefundBean" ;
						bean_name	= "eBL.PkgEnterReceptRefundBean";
						PkgEnterReceptRefundBean bean3 = (PkgEnterReceptRefundBean)PersistenceHelper.getBeanObject( bean_id, bean_name, req ) ;
						HashMap  support_data = bean3.getSupportData();		
						HashMap  mult_slmt_vals = bean3.getMultSlmtVals();	
						tabdata1.put("SUPPORT_DATA",(HashMap)support_data);
						tabdata1.put("MULT_SLMT_VALS",(HashMap)mult_slmt_vals);
					}
			
					tabdata1.put("episode_type", episode_type);
			
					tabdata1.put("recordMode", recordMode);
			
					tabdata1.put("dept_code", dept_code);
			
					tabdata1.put("bill_type_code", bill_type_code);
			
					tabdata1.put("pkg_serv_code", pkg_serv_code);
			
					tabdata1.put("base_qty", base_qty);
			
			
					tabdata1.put("base_rate", base_rate);
			
					tabdata1.put("base_charge_amt", base_charge_amt);
			
					tabdata1.put("gross_charge_amt", gross_charge_amt);
			
					tabdata1.put("disc_amt", disc_amt);
			
					tabdata1.put("net_charge_amt", net_charge_amt);
			
					tabdata1.put("pat_base_qty", pat_base_qty);
			
					tabdata1.put("pat_base_rate", pat_base_rate);
			
					tabdata1.put("pat_serv_qty", pat_serv_qty);
			
					tabdata1.put("pat_base_charge_amt", pat_base_charge_amt);
			
					tabdata1.put("pat_gross_charge_amt", pat_gross_charge_amt);
			
					tabdata1.put("pat_disc_amt", pat_disc_amt);
			
					tabdata1.put("pat_net_charge_amt", pat_net_charge_amt);
			
					tabdata1.put("cust_base_qty", cust_base_qty);
			
					tabdata1.put("cust_base_rate", cust_base_rate);
			
					tabdata1.put("cust_serv_qty", cust_serv_qty);
			
					tabdata1.put("cust_base_charge_amt", cust_base_charge_amt);
			
					tabdata1.put("cust_gross_charge_amt", cust_gross_charge_amt);
			
					tabdata1.put("cust_disc_amt", cust_disc_amt);
			
					tabdata1.put("cust_net_charge_amt", cust_net_charge_amt);
			
					tabdata1.put("pkg_ins_pat_ind", pkg_ins_pat_ind);
			
					tabdata1.put("split_yn", split_yn);
			
					tabdata1.put("pkg_bill_doc_type", pkg_bill_doc_type);
			
					tabdata1.put("pkg_bill_doc_num", pkg_bill_doc_num);
			
					tabdata1.put("day_type_code", day_type_code);
			
					tabdata1.put("time_type_code", time_type_code);
			
					tabdata1.put("disc_perc", disc_perc);
			
					tabdata1.put("addl_fctr", addl_fctr);
			
					tabdata1.put("upd_user_flag", upd_user_flag);
			
					tabdata1.put("user_id", user_id);
					tabdata1.put("module_id", "OP");
			
					tabdata1.put("mod_id", mod_id);
			
					tabdata1.put("cred_start_date", cred_start_dt + "");
			
					tabdata1.put("gl_holder_name", gl_holder_name + "");
			
					tabdata1.put("gl_holder_reln", gl_holder_reln + "");
			
					tabdata1.put("res_tel_no", res_tel_no);
			
					tabdata1.put("oth_contact_no", oth_contact_no);
			
					tabdata1.put("res_area_code", res_area_code);
			
					tabdata1.put("res_town_code", res_town_code);
			
					tabdata1.put("res_region_code", res_region_code);
			
					tabdata1.put("email_id", email_id);
			
					tabdata1.put("res_addr_line1", res_addr_line1);
			
					tabdata1.put("res_addr_line2", res_addr_line2);
			
					tabdata1.put("res_addr_line3", res_addr_line3);
			
					tabdata1.put("res_addr_line4", res_addr_line4);
			
					tabdata1.put("postal_code", postal_code);
			
					tabdata1.put("country_code", country_code);
			
					tabdata1.put("mail_addr_line1", mail_addr_line1);
			
					tabdata1.put("mail_addr_line2", mail_addr_line2);
			
					tabdata1.put("mail_addr_line3", mail_addr_line3);
			
					tabdata1.put("mail_addr_line4", mail_addr_line4);
			
					tabdata1.put("mail_area_code", mail_area_code);
			
					tabdata1.put("mail_town_code", mail_town_code);
			
					tabdata1.put("mail_postal_code", mail_postal_code);
			
					tabdata1.put("mail_region_code", mail_region_code);
			
					tabdata1.put("mail_country_code", mail_country_code);
			
					tabdata1.put("ordering_facility_id", ordering_facility_id);
			
					tabdata1.put("order_id", order_id);
			
					tabdata1.put("order_line_num", order_line_num);
			
					tabdata1.put("order_type_code", order_type_code);
			
					tabdata1.put("order_catalog_map", order_catalog_map);
					/*Added by Thamizh selvi on 29th Jan 2018 against ML-MMOH-CRF-0601 Start*/
					tabdata1.put("altAddrLine1",altAddrLine1);
					tabdata1.put("altAddrLine2",altAddrLine2);
					tabdata1.put("altAddrLine3",altAddrLine3);
					tabdata1.put("altAddrLine4",altAddrLine4);
					tabdata1.put("altAreaCode",altAreaCode);
					tabdata1.put("altTownCode",altTownCode);
					tabdata1.put("altPostalCode",altPostalCode);
					tabdata1.put("altRegionCode",altRegionCode);
					tabdata1.put("altCountryCode",altCountryCode);
					/*End*/
					
					prencounter.clear();
					prencounter.put("pat_class", pat_class);
					prencounter.put("facility_id", facilityId);
					prencounter.put("patient_id", patientId);
					prencounter.put("appt_id", appt_id);
					prencounter.put("visit_adm_type", visit_adm_type);
					prencounter.put("visit_adm_type_facility_id", facilityId);
					prencounter.put("visit_adm_type_ind", h_visit_type_ind);
					prencounter.put("assign_care_locn_type", assign_care_locn_type);
					prencounter.put("assign_care_locn_code", assign_care_locn_code);
					prencounter.put("attend_practitioner_id", attend_practitioner_id);
					referral_id = req.getParameter("referral_code");
					if (referral_id == null)
						referral_id = "";
			
					if (!referral_id.equals(""))
						prencounter.put("referral_id", referral_id);
					prencounter.put("specialty_code", specialty_code);
					prencounter.put("contact_reason_code", contact_reason_code);
					prencounter.put("other_remarks", other_remarks); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
					if (!appt_id.equals(""))
						prencounter.put("appt_case_yn", "A");
					else
						prencounter.put("appt_case_yn", "W");
					prencounter.put("ancillary_yn", "N");
					prencounter.put("ambulatory_status", ambulatory_status);
			
					if (!op_episode_visit_num.equals("")) {
						prencounter.put("op_episode_visit_num", op_episode_visit_num);
			
					} else {
						prencounter.put("op_episode_visit_num", "1");
			
					}
					prencounter.put("recall_yn", "N");
					prencounter.put("mds_complete_yn", "N");
					prencounter.put("backdated_yn", "N");
					prencounter.put("visit_status", "01");
					prencounter.put("added_by_id", addedById);
					prencounter.put("added_facility_id", facilityId);
					prencounter.put("added_at_ws_no", addedAtWorkstation);
					prencounter.put("modified_by_id", modifiedById);
					prencounter.put("modified_facility_id", modifiedFacilityId);
					prencounter.put("modified_at_ws_no", modifiedAtWorkstation);
					
					//Added for this CRF GDOH-CRF-0129
					prencounter.put("assigncare_loctype_ind", assigncare_loctype_ind);
					prencounter.put("assigncare_locacode", assigncare_locacode);		 
					//End this CRF GDOH-CRF-0129
					
					//Added by Sangeetha for KDAH-CRF-0347 on 14/apr/17
					prencounter.put("form60_YN", form60_YN);	
			
					prencounter1.clear();
					prencounter1.put("pat_class", pat_class);
					prencounter1.put("facility_id", facilityId);
					prencounter1.put("patient_id", patientId);
					prencounter1.put("appt_id", appt_id);
					prencounter1.put("visit_adm_type", visit_adm_type);
					prencounter1.put("visit_adm_type_facility_id", facilityId);
					prencounter1.put("visit_adm_type_ind", h_visit_type_ind);
					prencounter1.put("assign_care_locn_type", assign_care_locn_type);
					prencounter1.put("assign_care_locn_code", assign_care_locn_code);
					prencounter1.put("attend_practitioner_id", attend_practitioner_id);
			
					if (!referral_id.equals(""))
						prencounter1.put("referral_id", referral_id);
					prencounter1.put("specialty_code", specialty_code);
					prencounter1.put("contact_reason_code", contact_reason_code);
					prencounter1.put("other_remarks", other_remarks); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
					if (!appt_id.equals(""))
						prencounter1.put("appt_case_yn", "A");
					else
						prencounter1.put("appt_case_yn", "W");
					prencounter1.put("ancillary_yn", "N");
					prencounter1.put("ambulatory_status", ambulatory_status);
			
					if (!op_episode_visit_num.equals("")) {
						prencounter1.put("op_episode_visit_num", op_episode_visit_num);
			
					} else {
						prencounter1.put("op_episode_visit_num", "1");
			
					}
					prencounter1.put("recall_yn", "N");
					prencounter1.put("mds_complete_yn", "N");
					prencounter1.put("backdated_yn", "N");
					prencounter1.put("visit_status", "1");
					prencounter1.put("added_by_id", addedById);
					prencounter1.put("added_facility_id", facilityId);
					prencounter1.put("added_at_ws_no", addedAtWorkstation);
					prencounter1.put("modified_by_id", modifiedById);
					prencounter1.put("modified_facility_id", modifiedFacilityId);
					prencounter1.put("modified_at_ws_no", modifiedAtWorkstation);
			
					prencounterdetail.clear();
					prencounterdetail.put("operating_facility_id", facilityId);
					prencounterdetail.put("arrival_code", arrival_code);
					prencounterdetail.put("escort_name", escort_name);
					prencounterdetail.put("escort_add_ln1", escort_add_ln1);
					prencounterdetail.put("escort_add_ln2", escort_add_ln2);
					prencounterdetail.put("escort_add_ln3", escort_add_ln3);
					prencounterdetail.put("escort_add_ln4", escort_add_ln4);
					prencounterdetail.put("escort_add_postal_code", escort_add_postal_code);
					prencounterdetail.put("escort_mv_reg_no", escort_mv_reg_no);
					prencounterdetail.put("encounter_type", encounter_type);
					prencounterdetail.put("visit_adm_desc", visit_adm_desc);
					if (emergency_detail != null)
						prencounterdetail.put("emergency_detail", emergency_detail);
					prencounterdetail.put("added_by_id", addedById);
					prencounterdetail.put("added_date", added_date);
					prencounterdetail.put("added_facility_id", facilityId);
					prencounterdetail.put("added_at_ws_no", addedAtWorkstation);
					prencounterdetail.put("modified_by_id", modifiedById);
					prencounterdetail.put("modified_date", modified_date);
					prencounterdetail.put("modified_facility_id", modifiedFacilityId);
					prencounterdetail.put("modified_at_ws_no", modifiedAtWorkstation);
			
					prencounterdetail1.clear();
					prencounterdetail1.put("operating_facility_id", facilityId);
					prencounterdetail1.put("arrival_code", arrival_code);
					prencounterdetail1.put("escort_name", escort_name);
					prencounterdetail1.put("escort_add_ln1", escort_add_ln1);
					prencounterdetail1.put("escort_add_ln2", escort_add_ln2);
					prencounterdetail1.put("escort_add_ln3", escort_add_ln3);
					prencounterdetail1.put("escort_add_ln4", escort_add_ln4);
					prencounterdetail1
							.put("escort_add_postal_code", escort_add_postal_code);
					prencounterdetail1.put("escort_mv_reg_no", escort_mv_reg_no);
					prencounterdetail1.put("encounter_type", encounter_type);
					prencounterdetail1.put("visit_adm_desc", visit_adm_desc);
					if (emergency_detail != null)
						prencounterdetail1.put("emergency_detail", emergency_detail);
					prencounterdetail1.put("added_by_id", addedById);
					prencounterdetail1.put("added_date", added_date);
					prencounterdetail1.put("added_facility_id", facilityId);
					prencounterdetail1.put("added_at_ws_no", addedAtWorkstation);
					prencounterdetail1.put("modified_by_id", modifiedById);
					prencounterdetail1.put("modified_date", modified_date);
					prencounterdetail1.put("modified_facility_id", modifiedFacilityId);
					prencounterdetail1.put("modified_at_ws_no", modifiedAtWorkstation);
					
					String status = "0";
								
					if (entitlement_by_cat_yn.equals("Y")) {
						try {
			
							pstmt = con
									.prepareStatement("select MP_ENTITLEMENT_VALIDATION(?,to_char(sysdate,'dd/mm/yyyy'),?,?,?,?,?,'') from dual");
							pstmt.setString(1, patientId);
							pstmt.setString(2, facilityId);
							pstmt.setString(3, assign_care_locn_type);
							pstmt.setString(4, assign_care_locn_code);
							pstmt.setString(5, pat_class);
							pstmt.setString(6, specialty_code);
							rs = pstmt.executeQuery();
							if (rs != null) {
								if (rs.next()) {
									status = rs.getString(1);
									if (status == null)
										status = "";
								}
							}
							if (pstmt != null)
								pstmt.close();
							if (rs != null)
								rs.close();
			
						} catch (Exception e) {
							e.printStackTrace();
						}
			
					}
					
					if (status.equals("0")) {
			
						boolean local_ejbs = false;
			
						if ((getServletConfig().getServletContext()
								.getInitParameter("LOCAL_EJBS") != null)
								&& (getServletConfig().getServletContext()
										.getInitParameter("LOCAL_EJBS")
										.equalsIgnoreCase("TRUE")))
							local_ejbs = true;
			
						Object home = com.ehis.eslp.ServiceLocator
								.getInstance()
								.getHome("java:comp/env/VisitRegistration",
										VisitRegistrationHome.class, local_ejbs);
						Object busObj = (home.getClass().getMethod("create",
								null)).invoke(home, null);
						Object argArray[] = new Object[7];
			
						argArray[0] = p;
						argArray[1] = tabdata;
						argArray[2] = prencounter;
						argArray[3] = prencounterdetail;
						argArray[4] = tabdata1;
						argArray[5] = prencounter1;
						argArray[6] = prencounterdetail1;
			
						Class[] paramArray = new Class[7];
						paramArray[0] = p.getClass();
						paramArray[1] = tabdata.getClass();
						paramArray[2] = prencounter.getClass();
						paramArray[3] = prencounterdetail.getClass();
						paramArray[4] = tabdata1.getClass();
						paramArray[5] = prencounter1.getClass();
						paramArray[6] = prencounterdetail1.getClass();
			
						java.util.HashMap results = (java.util.HashMap) (busObj
								.getClass().getMethod("insert", paramArray))
								.invoke(busObj, argArray);
			
						(busObj.getClass().getMethod("remove", null)).invoke(
								busObj, null);
			
						boolean inserted = (((Boolean) results.get("status"))
								.booleanValue());
			
						error = (String) results.get("error");
			
						l_encounter_id = (String) results.get("p_encounter_id");
						l_episode_visit_num = (String) results.get("p_episode_visit_num");
						l_episode_id = (String) results.get("p_episode_id");
									
						//Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11
						if (inserted)
						{
							if(isInvokeUploadDocAppl)
							{
								int ins_count = eMP.MPCommonBean.getInsuranceCount(con,l_encounter_id,patientId);
								if(ins_count > 0)
								{
								
									String htmlFor = "var dialogHeight = '40'; var dialogWidth = '70'; var arguments = ''; var getUrl = '../eMP/jsp/MPUploadDocument.jsp?function_id="
									+ "UPLOAD_DOC"
									+ "&patient_id="
									+ patientId
									+ "&encounter_id="
									+ l_encounter_id
									+ "'; var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll = auto; status = no;' ; var retVal = await window.showModalDialog(getUrl,arguments,features);";
			
									out.println(htmlFor);
			
								}
							}
						}
						// Added By Sridhar Reddy to provide OrderEntry Screen for Satya Sai	 Change on 14.02.2011			
						if (inserted)
						{
							//This called to open Preview Order Screen
							multiple_orders_yn = (req.getParameter("multiple_orders_yn") == null) ? "N": req.getParameter("multiple_orders_yn");
							String check_box_value = "";
							String catalog_nature = "";
							RefusalOrdersBean Orderables = (RefusalOrdersBean) com.ehis.persist.PersistenceHelper.getBeanObject("refusalOrdersBean","eOR.RefusalOrdersBean",req);
							
							if(multiple_orders_yn.equals("N"))
							{
								order_catalog_code = (req.getParameter("order_cat_code") == null) ? "": req.getParameter("order_cat_code");
								order_category_code = (req.getParameter("order_category_code") == null) ? "": req.getParameter("order_category_code");
								order_type_code = (req.getParameter("order_type_code") == null) ? "": req.getParameter("order_type_code");
								
								if(!(order_catalog_code.equals(""))){								
									catalog_nature = Orderables.getCatalogNature(order_catalog_code);								
									if (catalog_nature.equals("S"))
										order_category_code = "CS";
									else
										order_category_code = order_category_code;
								
									order_catalog_map.put("h1"+order_catalog_code,order_category_code);
									order_catalog_map.put("h2"+order_catalog_code,order_type_code);
									order_catalog_map.put("ck"+order_catalog_code,"Y");
									check_box_value = "ck"+order_catalog_code;
								}
									
							}
							else
							{
								int rec_cnt=Orderables.getSize();
								ArrayList arr= new ArrayList();
								arr= Orderables.getArrayList();
								/* CheckStyle Violation Commented by Munisekhar */
								//StringBuffer sb_ord_ctlg = new StringBuffer();
								String order_code = "";
								String order_desc = "";								
								for(int i=0;i<rec_cnt;i++)
								{
									String order_string = arr.get(i).toString();
									//StringTokenizer order_val = new StringTokenizer(order_string,"$$");
									//Above line commented and below lind added for this CRF Bru-HIMS-CRF-165.1
									StringTokenizer order_val = new StringTokenizer(order_string,"~~");
									
									while(order_val.hasMoreTokens())
									{
										order_code = order_val.nextToken();
										order_desc = order_val.nextToken();
										order_type_code = order_val.nextToken();
										order_category = order_val.nextToken();
										catalog_nature = Orderables.getCatalogNature(order_code);
										if (catalog_nature.equals("S"))
											order_category = "CS";
										else
											order_category = order_category;
										order_catalog_map.put("h1"+order_code,order_category);
										order_catalog_map.put("h2"+order_code,order_type_code);
										order_catalog_map.put("ck"+order_code,"Y");				
										check_box_value = check_box_value+"ck"+order_code+",";
									}
								}								
								if (check_box_value.length()>0)
								{
									check_box_value=check_box_value.substring(0,check_box_value.length()-1);
								}															
							}	
							
							if (order_catalog_map != null && order_catalog_map.size()>0)
							{	
								PreparedStatement pstmt1 = null;
								ResultSet rs1 = null;
								try
								{	
									String Sex = "";
									String Age = "";
									String Dob = "";									
									String pract_name = req.getParameter("pract_name")==null?"":req.getParameter("pract_name");
			
			                        java.util.Hashtable message = MessageManager.getMessage( locale, "ORDER_CATALOG_SELECTED_CANNOT_CLOSE","OP" ) ;
					                String msg_odr_catlg = (String) message.get("message");  // Added by Sangeetha for GHL-SCF-995 on 11-Aug-2016
			
									//String appl_user_name = session.getValue("appl_user_name")==null?"":(String)session.getValue("appl_user_name");		
									String login_user = session.getValue("login_user")==null?"":(String)session.getValue("login_user"); 	
									pstmt1 = con.prepareStatement("select SEX,to_char(date_of_birth,'dd/mm/yyyy')  DOB,mp_get_age_ymd(date_of_birth,deceased_date) AGE from mp_patient where patient_id=?");
									pstmt1.setString(1,patientId);
									rs1 = pstmt1.executeQuery();
									if (rs1.next())
									{
										Sex = rs1.getString("SEX");
										Age = rs1.getString("AGE");
										Dob = rs1.getString("DOB");
									}
									/* Below line was commanted by Venkatesh.S against check style report error clearing */
									//if (rs1!=null)rs.close();
									/* Below one line was added by Venkatesh.S against check style report error clearing */
									if (rs1!=null)rs1.close();
									if (pstmt1!=null)pstmt1.close();																
									String bean_id = "@orderentrybean"+patientId+l_encounter_id;
									eOR.OrderEntryBean bean				= (eOR.OrderEntryBean)com.ehis.persist.PersistenceHelper.getBeanObject( bean_id, "eOR.OrderEntryBean", req) ;
									eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
									if (orderEntryRecordBean == null)
									{
										orderEntryRecordBean = new eOR.Common.OrderEntryRecordBean();
									}
									eOR.OrderEntryBillingQueryBean orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) bean.getOrderEntryBillBean();
									if (orderEntryBillBean == null)
									{
										orderEntryBillBean = new eOR.OrderEntryBillingQueryBean();
									}									
									bean.setOrderEntryRecordBean(orderEntryRecordBean);
									bean.setOrderEntryBillBean(orderEntryBillBean);
									bean.setCatalogCodes(check_box_value);
									bean.setFacilityName(session.getValue("facility_name")==null?"":(String)session.getValue("facility_name"));
									bean.setAmendOrder("");															
									bean.setPatientId(patientId);
									bean.setEncounterId(l_encounter_id);
									bean.setEpisodeID(l_episode_id);
									bean.setEpisodeVisitNum(l_episode_visit_num);
									bean.setPractitionerId(attend_practitioner_id);
									bean.setPractitionerName(pract_name);								
									bean.setAttendPractitionerId(attend_practitioner_id);
									bean.setAttendPractitionerName(pract_name);
									bean.setLoginPractId(login_user);
									bean.setPatientDischarged("N");
									bean.setPatientClass("OP");
									bean.setSex(Sex);
									bean.setAge(Age);
									bean.setDob(Dob);
									bean.setLocationType(assign_care_locn_type);
									bean.setLocationCode(assign_care_locn_code);
									bean.setVisitAdmDate(vst_regn_date_time);
									String property_name =(bean.getPatientId()+bean.getEncounterId()); 									
									orderEntryRecordBean.setCheckedEntries(property_name,order_catalog_map);															
									com.ehis.persist.PersistenceHelper.putObjectInBean(bean_id, bean, req);														
										String htmlFor1 = "var dialogHeight = '94vh';	var dialogWidth = '75vw'; var dialogTop = '0vh'; var dialogLeft= '0vw'; var arguments = ''; var getUrl = '../../eOR/jsp/OrderEntryRapidPreview.jsp?patient_class="
										+ "OP"
										+ "&encounter_id="
										+ l_encounter_id
										+ "&episode_id="
										+ l_episode_id
										+ "&episode_visit_num="
										+ l_episode_visit_num
										+ "&location_type="
										+ assign_care_locn_type
										+ "&location_code="
										+ assign_care_locn_code
										+ "&patient_id="
										+ patientId
										+"&bean_id="
										+bean_id
										+"&bean_name=eOR.OrderEntryBean"	
										+"&Sex="
										+ Sex
										+"&Age="
										+ Age
										+"&Dob="
										+ Dob
										+"&visit_adm_date="
										+ vst_regn_date_time
										+"&licence_key=ORFV&called_from=OP_VISIT_REG"
										+"&pract_id="
										+attend_practitioner_id									
										+ "';	var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ; var retVal = await top.window.showModalDialog(getUrl,arguments,features) ; 	 		if(retVal!=\"TRUE\"){ alert('"+msg_odr_catlg+"');}else{}";  //modified for GHL-SCF-995 on 11-Aug-2016
										out.println(htmlFor1); 
										
								}
								catch (Exception e)
								{
									e.printStackTrace();
								}finally{
									if (rs1!=null)rs.close();
									if (pstmt1!=null)pstmt1.close();		
								}
							}
						}	
			//End
						if (bl_install_yn.equals("Y")) {
			
							String billdoctype = (String) results
									.get("billdoctype");
							String billdocnum = (String) results
									.get("billdocnum");
			
							String billgenlater = (String) results
									.get("billgenlater");
							//String billtotalamt = (String) results
							//		.get("billtotalamt");
							String billAlreadyPrinted = "N";
							String package_enabled_yn = (String) results.get("package_enabled_yn");		
							String pkg_codes_for_disc = (String) results.get("pkg_codes_for_disc");		
							if (package_enabled_yn==null) package_enabled_yn = "N";
					
							String strpackageseqno="";
							ArrayList packageseqno = new ArrayList();
							if(package_enabled_yn.equals("Y"))
							{
								packageseqno = (ArrayList) results.get("packageseqno");
																
								int k=0;
								if(packageseqno!=null && packageseqno.size()>0)
								 {
									for(k=0;k<packageseqno.size();k++)
									{	
										strpackageseqno=(String)packageseqno.get(k)+"|"+strpackageseqno;
									}
								 	}
							}
			
							String str_bill_prt_format_YN = (String) results.get("bill_prt_format_YN");		
							if(str_bill_prt_format_YN == null || str_bill_prt_format_YN.equals("")) str_bill_prt_format_YN="N";
							String str_bill_prt_format_vals = (String) results.get("bill_prt_format_vals");	
							if(str_bill_prt_format_vals==null || (("null").equals(str_bill_prt_format_vals))) str_bill_prt_format_vals="";
							
							if(str_bill_prt_format_YN.equals("Y") && !(("").equals(str_bill_prt_format_vals)))
							{
								try
								{
									String pgm_id = (String) results.get("pgm_id");	
									if(pgm_id == null) pgm_id="";
									String session_id = (String) results.get("session_id");	
									if(session_id == null) session_id="";
									String pgm_date = (String) results.get("pgm_date");	
									if(pgm_date == null) pgm_date="";
									String mpi_id_rep = (String) results.get("mpi_id_rep");	
									if(mpi_id_rep == null) mpi_id_rep="";
									
									/*Added by Rajesh V for ML-MMOH-CRF-0753*/
									Boolean printRequired = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BILL_PRINT_NOT_REQD");
									String bill_print_reqd = "";
									int docNum = 0;
									String reportId="BLRBLPRT";
									
			
									try{
										/* BLReportIdMapper.getReportId function used in other modules also
										 * eAE - AEManagePatientServlet.java, AERegisterAttnServlet.java
										 * eBL - BLAdhocDiscSubmit.jsp, BLBillSlmtValidation.jsp, BLPatRegValidation.jsp, BLReprintReportHdr.jsp, BLStoreBillSlmtMain.jsp
										 * eMP - PatientRegistrationServlet.java
										 * eOP - PatCheckoutServlet.java, QmgmtRe_AssignPractServlet.java, ReviseVisitServlet.java, VisitRegistrationServlet.java
										 */
										reportId=BLReportIdMapper.getReportId(con, locale,reportId, facilityId); //Added facilityId By Subha for MMS-DM-CRF-131.1
										
									}catch(Exception e)
									{
										e.printStackTrace();
										reportId="BLRBLPRT";
										System.err.println("Exception in VisitRegistrationServlet for reportID "+e);
									}						
									if(printRequired){
										try{
											pstmt = con.prepareStatement("Select blopin.op_visit_bill_print_reqd(?,?,?)  from dual ");
											docNum = Integer.parseInt(billdocnum);
											pstmt.setString(1,facilityId);							
											pstmt.setString (2,billdoctype);
											pstmt.setInt(3,docNum);
											  rs = pstmt.executeQuery();
											 if(rs != null && rs.next()){
												 bill_print_reqd = rs.getString(1);
											   }
											 if("Y".equals(bill_print_reqd)) {									 
												 
												 	OnlineReport onlinereportParam = new OnlineReport(facilityId, "BL", reportId);
													onlinereportParam.addParameter("p_facility_id",facilityId);
													onlinereportParam.addParameter("p_pgm_date",pgm_date);
													onlinereportParam.addParameter("p_pgm_id",pgm_id);
													onlinereportParam.addParameter("p_Session_id",session_id);
													OnlineReports onlinereports = new OnlineReports();
													onlinereports.add(onlinereportParam);
													//String strResults =  onlinereports.execute(req,res); //COMMENTED FOR CHECKSTYLE
			
													onlinereportParam = null;
													onlinereports = null;	
													billAlreadyPrinted = "Y";
											}
											}
											 catch (Exception e) {
													e.printStackTrace();
												}
												finally{
													//pstmt = null;
													//rs = null;
													if(pstmt !=null) pstmt.close(); //Added for checkstyle
			                                        if(rs !=null) rs.close();  //Added for checkstyle
			
												}
									}
									else{
										OnlineReport onlinereportParam = new OnlineReport(facilityId, "BL", reportId);
										onlinereportParam.addParameter("p_facility_id",facilityId);
										onlinereportParam.addParameter("p_pgm_date",pgm_date);
										onlinereportParam.addParameter("p_pgm_id",pgm_id);
										onlinereportParam.addParameter("p_Session_id",session_id);
										OnlineReports onlinereports = new OnlineReports();
										onlinereports.add(onlinereportParam);
										//String strResults =  onlinereports.execute(req,res); //COMMENTED FOR CHECKSTYLE
			
										onlinereportParam = null;
										onlinereports = null;
									}
									/*Added by Rajesh V for ML-MMOH-CRF-0753*/
																	
								}
								catch (Exception e)
								{
									System.err.println("Error while submitting Print Job to Report Server:"+e);
								}
							}
			
							/*
							String htmlFor1 = " <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"
									+ sStyle
									+ "'></link></head><body class='message'><script language = 'JavaScript'>var enter_yn ; var dialogHeight    = '40' ;	 var dialogWidth = '70' ;	var dialogTop = '100' ;	 var center    = '1'  ;	 var arguments =   '';	if(eval('"
									+ frame_ref
									+ "checkingBL()')) { var getUrl  = '../eBL/jsp/BLBillSlmtMain.jsp?billdoctypecode="
									+ billdoctype
									+ "&billdocnum="
									+ billdocnum
									+ "&blnggrp="
									+ billing_group
									+ "'; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;' ;var retVal = window.showModalDialog(getUrl,arguments,features);eval('"
									+ frame_ref
									+ "setBL()'); }</script></body></html>";
									*/
			
							//Added By Rajesh V
							String restrictFlag = BLReportIdMapper.windowCloseRestrict(facilityId);
							String charge_logic_yn = BLReportIdMapper.getChargeLogic(facilityId);
							//Added By Rajesh V
					
							String htmlFor1 = "var toAllowInternalReport = true; var enter_yn ; var billdoctype='"+billdoctype+"'; var billdocnum='"+billdocnum+"'; var arr = new Array(); var dialogHeight    = '90vh' ;	 var dialogWidth = '90vw' ;	var dialogTop = '100' ;	 var center    = '1'  ;	 var arguments =   ''; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;' ; if("
							+ frame_ref
							+ "checkingBL()) { var getUrl  = '../../eBL/jsp/BLAdhocDiscFrame.jsp?patient_id="
							+patientId
							+"&episode_type=O"
							+"&episode_id="
							+l_episode_id
							+"&visit_id="
							+l_episode_visit_num
							+"&encounter_id="
							+l_encounter_id
							+"&pract_id="
							+attend_practitioner_id
							+"&locn_code="
							+assign_care_locn_code
							+"&billgenlater="
							+ billgenlater
							+"&function_id="
							+ function_id
							+"&module_id=OP"
							+"&visit_type_code="
							+ visit_adm_type
							+"&blnggrp="
							+ billing_group
							+"&strpackageseqno="
							+ strpackageseqno
							+"&package_enabled_yn="
							+ package_enabled_yn
							+"&pkg_codes_for_disc="
							+ pkg_codes_for_disc
							+"&called_frm=OTH_MOD"
							+"';"
							//	+ " if('"+billgenlater+"' == 'Y') {  var retVal = window.showModalDialog(getUrl,arguments,features);"
							//Modified by Rajesh V
							/* below Added by PalaniNarayanan against AMS-CRF-0256 */
							+ " if('"+billgenlater+"' == 'Y') {  var retVal; "
							+" if('"+restrictFlag+"' == 'Y'){ "
							+" do{ retVal = await window.showModalDialog(getUrl,arguments,features);}while(retVal == undefined || retVal == 'undefined');   "
							+" } else{ " 
							//+" retVal = window.showModalDialog(getUrl,arguments,features); "
							+" do{retVal = await top.window.showModalDialog(getUrl,arguments,features);}while(retVal == undefined || retVal == 'undefined');   "
							+" } "
							/* End by PalaniNarayanan against AMS-CRF-0256 */
							//Modified by Rajesh V
							+" if(retVal == undefined || retVal == 'undefined') { retVal = '';} if(retVal != ''){"
							+" arr = retVal.split('|'); billdoctype = arr[0];"
							+" billdocnum  = arr[1]; "
							+" } } "
							+" if('"+package_enabled_yn+"' == 'Y' && '"+charge_logic_yn+"' == 'N' && '"+packageseqno+"'!=null && '"+packageseqno.size()+"'>0 && billdoctype!='' && billdocnum!='') {"
							//Karthik commented on 21/7/2013 as Discount Page was called Twice IN050265
						/*	+" var getUrl2  = '../eBL/jsp/PkgVisitAdhocDiscountFrame.jsp?patientId="
							+patientId
							+"&strpackageseqno="
							+strpackageseqno
							+"&episode_id="
							+l_episode_id
							+"&visit_id="
							+l_episode_visit_num
							+"&encounter_id="
							+l_encounter_id
							+"&blnggrp="
							+ billing_group
							+"&billdoctype='+billdoctype+'"
							+"&billdocnum='+billdocnum+'"
							+"&called_from=VISITREG"
							+"';"
							+" var retVal = window.showModalDialog(getUrl2,arguments,features);"*/
							//Karthik commented on 21/7/2013 as Discount Page was called Twice
							+"}"
							+"var getUrl1  = '../../eBL/jsp/BLBillSlmtMain.jsp?billdoctypecode='+billdoctype+'"
							+ "&billdocnum='+billdocnum+'"
							+ "&blnggrp="
							+ billing_group
							+"&billgenlater="
							+ billgenlater
							+"&billAlreadyPrinted="
							+ billAlreadyPrinted
							+"'; retVal =await  top.window.showModalDialog(getUrl1,arguments,features);eval('"
							+ frame_ref
							+ "setBL()'); }";
			
							out.println(htmlFor1);
						}
						
						String x_fut_ord_exists_yn = "N";
						int cnt=0;
			
			
						pstmt = con.prepareStatement("select count(*) cnt FROM sm_modules_facility where MODULE_ID='OR' and FACILITY_ID=? AND OPERATIONAL_YN='Y'");
			
						pstmt.setString(1, facilityId);
			
						rs = pstmt.executeQuery();
						if (rs != null) {
							if (rs.next()) {
								cnt = rs.getInt(1);
							}
						}
						if (pstmt != null)
							pstmt.close();
						if (rs != null)
							rs.close();
			
						if(cnt>0)
						{
			
							try {
			
								pstmt = con.prepareStatement("select OR_CHECK_UNBILL_ORD_EXISTS_YN(?,?) from dual");
			
								pstmt.setString(1, patientId);
								pstmt.setString(2, facilityId);
			
								rs = pstmt.executeQuery();
								if (rs != null) {
									if (rs.next()) {
										x_fut_ord_exists_yn = rs.getString(1) == null ? "N" : rs.getString(1);
									}
								}
								if (pstmt != null)
									pstmt.close();
								if (rs != null)
									rs.close();
			
							} catch (Exception e) {
								e.printStackTrace();
							}
			
							if(x_fut_ord_exists_yn.equals("Y")) 
							{
								String htmlFor1 = "var dialogHeight = '90vh';	var dialogWidth = '65vw'; var dialogTop = '0vh'; var arguments = ''; var getUrl = '../../eOR/jsp/FutureOrderDtl.jsp?p_patient_class="
									+ "OP"
									+ "&p_encounter_id="
									+ l_encounter_id
									+ "&p_episode_id="
									+ l_episode_id
									+ "&p_episode_visit_num="
									+ l_episode_visit_num
									+ "&p_source_type="
									+ assign_care_locn_type
									+ "&p_source_code="
									+ assign_care_locn_code
									+ "&p_patient_id="
									+ patientId
									+ "';	var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ;  var retVal = await window.showModalDialog(getUrl,arguments,features);";
			
								out.println(htmlFor1);
			
							}
						}
						
						tabdata.clear();
						tabdata1.clear();
						prencounter.clear();
						prencounter1.clear();
						prencounterdetail.clear();
						prencounterdetail1.clear();
						results.clear();
						if(inserted)
			             {
			                session.removeAttribute("financial_details");
			                session.removeAttribute("classTypChangeAuthYnPatId");
			                session.removeAttribute("str_clinic_code");                                
			             }
			
						java.util.Hashtable message = MessageManager.getMessage(locale, "VISIT_REGN_COMPL", "OP");
						success_msg = ((String) message.get("message"));
						success_msg = success_msg +" "+ l_encounter_id;
						message.clear();
			
						try {				
				
							if (inserted) {
								/* new file creation logic */
								String createFileAtRegVstSql = "select CREATE_FILE_AT_REG_VISIT_YN, FILE_TYPE_APPL_YN,SINGLE_OR_MULTI_FILES_IND,SEPARATE_FILE_NO_YN,MAINTAIN_DOC_OR_FILE from mp_param";
								String createFileAtReg = "";
								single_or_multi_files_ind = "";
								String p_seperate_file_no_yn = "";
								String mr_section_type = "";
								String p_create_file_no_yn = "";
				
								try {
									PreparedStatement createFileStmt = con
											.prepareStatement(createFileAtRegVstSql);
									ResultSet createFileResultSet = createFileStmt
											.executeQuery();
									if (createFileResultSet != null
											&& createFileResultSet.next()) {
										createFileAtReg = createFileResultSet
												.getString("CREATE_FILE_AT_REG_VISIT_YN");
										single_or_multi_files_ind = createFileResultSet
												.getString("SINGLE_OR_MULTI_FILES_IND");
										p_seperate_file_no_yn = createFileResultSet
												.getString("SEPARATE_FILE_NO_YN");
										maintain_doc_or_file = createFileResultSet
												.getString("MAINTAIN_DOC_OR_FILE");
									}
									if (createFileStmt != null)
										createFileStmt.close();
									if (createFileResultSet != null)
										createFileResultSet.close();
								} catch (Exception createfilexcpn) {
									createfilexcpn.printStackTrace();
								}
				
								if (maintain_doc_or_file.equals("F")
										&& createFileAtReg.equals("Y")) {
									HashMap hashFILE_NO_EXISTS = File_No_ExistsCall(patientId,
											facilityId, "OP", assign_care_locn_code, con);
									p_seperate_file_no_yn = (String) hashFILE_NO_EXISTS
											.get("p_seperate_file_no_yn");
									p_create_file_no_yn = (String) hashFILE_NO_EXISTS
											.get("p_create_file_no_yn");
									if (p_create_file_no_yn == null)
										p_create_file_no_yn = "";
									if (p_seperate_file_no_yn == null)
										p_seperate_file_no_yn = "";
									mr_section_code = (String) hashFILE_NO_EXISTS
											.get("p_mr_section_code");
									if (mr_section_code == null)
										mr_section_code = "";
									mr_section_type = (String) hashFILE_NO_EXISTS
											.get("p_mr_section_type");
									if (mr_section_type == null)
										mr_section_type = "";
				
									hashFILE_NO_EXISTS.clear();
								}
								cnt = 0;
				
								try {
									pstmt = con.prepareStatement("select count(*) from op_online_report where OPERATING_FACILITY_ID='"
													+ facilityId
													+ "' and PRINT_AT_CI_YN='Y' and (clinic_code='"
													+ assign_care_locn_code
													+ "' or clinic_code ='*All') and (VISIT_TYPE_CODE='"
													+ visit_adm_type
													+ "' OR VISIT_TYPE_CODE='*A') and report_id not in ('OPRNTFMR','FMFLRQSL')");
									rs = pstmt.executeQuery();
									if (rs != null) {
										if (rs.next()) {
											cnt = rs.getInt(1);
										}
									}
									if (rs != null)
										rs.close();
									if (pstmt != null)
										pstmt.close();
				
									pstmt = con.prepareStatement("select count(*) from op_online_report where OPERATING_FACILITY_ID='"
													+ facilityId
													+ "' and PRINT_AT_CI_YN='Y' and (clinic_code='"
													+ assign_care_locn_code
													+ "' or clinic_code ='*All') and (VISIT_TYPE_CODE='"
													+ visit_adm_type
													+ "' OR VISIT_TYPE_CODE='*A') and report_id not in ('MPBFLLBL','OPRNTFMR','FMFLRQSL')");
									rs = pstmt.executeQuery();
									if (rs != null) {
										if (rs.next()) {
											cnt1 = rs.getInt(1);
										}
									}
									if (rs != null)
										rs.close();
									if (pstmt != null)
										pstmt.close();
				
								} catch (Exception e) {
									
											e.printStackTrace();
								}
								//  18408 Thursday, January 21, 2010 VenkatS
								String sqlStringOP="";
								String sqlStringMP="";
								if(assign_q_num_by.equals("S"))
								{
									sqlStringOP = "select distinct report_id, sm_get_desc.SM_REPORT(MODULE_ID,report_id,'"+locale+"','1')report_desc, 1 no_of_copies, module_id from op_online_report where OPERATING_FACILITY_ID='"
										+ facilityId
										+ "' and PRINT_AT_CI_YN='Y' and (clinic_code='"
										+ assign_care_locn_code
										+ "' or clinic_code ='*All') and (VISIT_TYPE_CODE='"
										+ visit_adm_type
										+ "' OR VISIT_TYPE_CODE='*A') and report_id not in ('MPBFLLBL','OPRNTFMR','FMFLRQSL') order by 2";
									sqlStringMP = "select distinct report_id, sm_get_desc.SM_REPORT(MODULE_ID,report_id,'"+locale+"','1')report_desc, 1 no_of_copies, module_id,1 orderby from op_online_report where OPERATING_FACILITY_ID='"
										+ facilityId
										+ "' and PRINT_AT_CI_YN='Y' and (clinic_code='"
										+ assign_care_locn_code
										+ "' or clinic_code ='*All') and (VISIT_TYPE_CODE='"
										+ visit_adm_type
										+ "' OR VISIT_TYPE_CODE='*A') and report_id not in ('OPRNTFMR','FMFLRQSL') ORDER BY 5,2";
								}
								else
								{
									sqlStringOP = "select distinct report_id, sm_get_desc.SM_REPORT(MODULE_ID,report_id,'"+locale+"','1')report_desc, 1 no_of_copies, module_id from op_online_report where OPERATING_FACILITY_ID='"
										+ facilityId
										+ "' and PRINT_AT_CI_YN='Y' and (clinic_code='"
										+ assign_care_locn_code
										+ "' or clinic_code ='*All') and (VISIT_TYPE_CODE='"
										+ visit_adm_type
										+ "' OR VISIT_TYPE_CODE='*A') and report_id not in ('MPBFLLBL','OPRNTFMR','FMFLRQSL','OPBQTKNO') order by 2";
				
									sqlStringMP = "select distinct report_id, sm_get_desc.SM_REPORT(MODULE_ID,report_id,'"+locale+"','1')report_desc, 1 no_of_copies, module_id,1 orderby from op_online_report where OPERATING_FACILITY_ID='"
										+ facilityId
										+ "' and PRINT_AT_CI_YN='Y' and (clinic_code='"
										+ assign_care_locn_code
										+ "' or clinic_code ='*All') and (VISIT_TYPE_CODE='"
										+ visit_adm_type
										+ "' OR VISIT_TYPE_CODE='*A') and report_id not in ('OPRNTFMR','FMFLRQSL','OPBQTKNO') ORDER BY 5,2";
								}
								String reportParamNamesOP = "p_encounter_id,p_clinic_code,p_clinic_type,p_patient_id,p_user_name";
								String reportParamValuesOP = "" + l_encounter_id + ","
										+ assign_care_locn_code + "," + assign_care_locn_type
										+ "," + patientId + "," + addedById + "";
								int idval = error.indexOf("<br>");
								String err1 = "";
								String err2 = "";
				
								if (idval != -1) {
									err1 = error.substring(0, idval);
									err2 = error.substring(idval + 4);
								}
								
								 //Senthil below line Added
								Statement stmt_fm = con.createStatement();
								ResultSet rset_fm = null;
								
					
								rset_fm = stmt_fm
										.executeQuery("select install_yn from sm_module where module_id ='FM'");
								if (rset_fm != null && rset_fm.next()) {
									fm_install_yn = rset_fm.getString("install_yn");
								}
								if (rset_fm != null)
									rset_fm.close();
							
								String autoRegSql = "select count(*) as recordCount from mr_pat_file_index where patient_id = '"+patientId+"' and facility_id = '"+facilityId+"'";
							
								rset_fm = stmt_fm.executeQuery(autoRegSql);
								if (rset_fm != null && rset_fm.next()) {
									recordCount = rset_fm.getInt("recordCount");
								}
								if (rset_fm != null)
									rset_fm.close();
								if (stmt_fm != null)
									stmt_fm.close();
								
								//End senthil Added					
				
								if (maintain_doc_or_file.equals("F")) {
									if (p_create_file_no_yn.equals("Y")) {
										//if (!mr_section_type.equals("")	&& !mr_section_code.equals("")) {
										error_value = "1";
			
										java.util.Hashtable message1 = MessageManager
											.getMessage(locale, "FILE_NO_SUCCESS", "MP");
										String msg = ((String) message1.get("message"));
			
			
										session.setAttribute("VISIT_SQLSTRINGOP",sqlStringOP);
										session.setAttribute("VISIT_SQLSTRINGMP",sqlStringMP);
			
										String htmlFor = "var dialogHeight = '55vh';	var dialogWidth = '55vw'; var dialogTop = '0'; var arguments = ''; var getUrl = '../../eMP/jsp/CallCreateFileComponent.jsp?Called_From="
												+ "OP"
												+ "&Location_Type="
												+ assign_care_locn_type
												+ "&Location_Code="
												+ assign_care_locn_code
												+ "&P_Patient_ID="
												+ patientId
												+ "&P_Single_or_multi_files_ind="
												+ single_or_multi_files_ind
												+ "&P_Seperate_file_no_yn="
												+ p_seperate_file_no_yn
												+ "&P_Pat_Ser_Grp_Code="
												+ pat_ser_grp_code
												+ "&P_Mr_Section_Type="
												+ mr_section_type
												+ "&P_Mr_Section_Code="
												+ mr_section_code
												+ "&p_encounter_id="
												+ l_encounter_id
												+ "&p_patient_class="
												+ "OP"
												+ "&p_encounter_date_time="
												+ vst_regn_date_time
												+ "';	var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ; var fileString='"+msg+"'; var retVal = await window.showModalDialog(getUrl,arguments,features); var newval=' ';  var fileval=' ';                                              if(retVal==null) {retVal=' ` '; fileString=' '; }                                                     var arr = retVal.split('`');                                                                                            if(arr[0]==null || arr[0]==''){arr[0]=' ';fileString=' '; }                                       if (arr[1]==null || arr[1]==''){arr[1]=' ';}  if(arr[0]!= ' '){ var arr1=arr[0].split('||'); if(arr1[0] == null || arr1[0] == ''){arr1[0]=' ';fileString=' '; newval=' ';fileval='';}else{if(arr1.length==2){newval=arr1[0];fileval=arr1[1];}else{newval=arr1[0];fileval=arr1[0];}}     if(arr1[1] == null || arr1[1] == ''){arr1[1]=' ';}eval('"
												+ frame_ref
												+ "assignnewfileno(fileval)'); }  if(!(arr[0]!=' '))                                                                                                                                        {                                                                                                                                               var dialogHeight    = '55vh' ;	var dialogWidth = '50vw' ;	var dialogTop = '65'; vararguments =   '';var new_file_no= fileval; if(new_file_no == null) new_file_no='';	 if("
												+ cnt1
												+ " > 0){ var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=OP&P_function_id=VISIT_REGISTRATION&step=1&sql_querykey=VISIT_SQLSTRINGOP" //modified this line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the Query String.
												//+ java.net.URLEncoder.encode(sqlStringOP,"UTF-8")
												+ "&EncounterId="
												+ l_encounter_id
												+ "&dest_locn_type="
												+ assign_care_locn_type
												+ "&dest_locn_code="
												+ assign_care_locn_code
												+ "&reportParamNames="
												+ reportParamNamesOP
												+ ",p_file_no&reportParamValues="
												+ reportParamValuesOP
												+ ",'+new_file_no;	var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ; retVal = await window.showModalDialog(getUrl,arguments,features);}	if('"
												+ call_from
												+ "' == 'CA'){ fileString=fileString.replace('%',newval);err_msg='"+success_msg+"';				err_msg = err_msg+'\\n'+fileString+''+arr[1]; parent.window.returnValue='Y';alert(err_msg);top.close();} else {	"
												+" if(parent.f_query_add_mod) { parent.f_query_add_mod.location.href = '../eOP/jsp/VisitRegistrationMain.jsp?oa_install_yn=Y&oper_stn_id="
												+ oper_stn_id
												+ "&wait_list_inv="
												+ wait_list
			                                    + "&query_string="
												+java.net.URLEncoder.encode(query_string,"UTF-8")
												+ "&status=Y&function_id="
												+ function_id
												+ "&fromserv=Y';}  fileString=fileString.replace('%',newval);"
												+ "parent.messageFrame.location.href = '../eCommon/jsp/error.jsp?err_num="
												+ error
												+ "<br>'+fileString+''+arr[1]+'&err_value="
												+ error_value
												+ "'; toAllowInternalReport = false;} } else { var dialogHeight    = '50vh' ;	var dialogWidth = '55vw' ;	var dialogTop = '65'; var arguments =   ''; 	var new_file_no= fileval; if(new_file_no == null) new_file_no='';if("
												+ cnt
												+ " > 0){ var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=OP&P_function_id=VISIT_REGISTRATION&step=1&sql_querykey=VISIT_SQLSTRINGMP" //modified this line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the Query String.
												//+ java.net.URLEncoder.encode(sqlStringMP,"UTF-8")
												+ "&EncounterId="
												+ l_encounter_id
												+ "&dest_locn_type="
												+ assign_care_locn_type
												+ "&dest_locn_code="
												+ assign_care_locn_code
												+ "&reportParamNames="
												+ reportParamNamesOP
												+ ",p_file_no&reportParamValues="
												+ reportParamValuesOP
												+ ",'+new_file_no;	var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ; retVal = await window.showModalDialog(getUrl,arguments,features);}	if('"
												+ call_from
												+ "' == 'CA'){fileString=fileString.replace('%',newval);err_msg='"+success_msg+"';	err_msg = err_msg+'\\n'+fileString+''+arr[1];	alert(err_msg);parent.window.returnValue='Y';top.close();} else {	parent.f_query_add_mod.location.href = '../eOP/jsp/VisitRegistrationMain.jsp?oa_install_yn=Y&oper_stn_id="
												+ oper_stn_id
												+ "&query_string="
												+ java.net.URLEncoder.encode(query_string,"UTF-8")
												+ "&wait_list_inv="
												+ wait_list
												+ "&status=Y&function_id="
												+ function_id
												+ "&fromserv=Y'; fileString=fileString.replace('%',newval);"
												+ "parent.messageFrame.location.href = '../eCommon/jsp/error.jsp?err_num="
												+ error
												+ "<br>'+fileString+''+ arr[1]+' &err_value="
												+ error_value
												+ "'; return false} } ";
										out.println(htmlFor);							
										message1.clear();
				
										//}
									}
								} else if (maintain_doc_or_file.equals("D")
										&& patFlag.equals("Y")) {
				
											
									session.setAttribute("VISIT_SQLSTRINGMP",sqlStringMP);
				
									String htmlFor = "var dialogHeight    = '50vh' ;	var dialogWidth = '55vw' ;var dialogTop = '65'; var arguments =   '';var newval=' ';var fileString='';var fileString2='';  var fileval=''; var new_file_no= fileval; if(new_file_no == null) new_file_no=''; if("
											+ cnt
											+ " > 0){var getUrl        =  '../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=OP&P_function_id=VISIT_REGISTRATION&step=1&sql_querykey=VISIT_SQLSTRINGMP" //modified this line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the Query String.
											//+ java.net.URLEncoder.encode(sqlStringMP,"UTF-8")
											+ "&EncounterId="
											+ l_encounter_id
											+ "&dest_locn_type="
											+ assign_care_locn_type
											+ "&dest_locn_code="
											+ assign_care_locn_code
											+ "&reportParamNames="
											+ reportParamNamesOP
											+ "&reportParamValues="
											+ reportParamValuesOP
											+ "';	var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;'; var retVal = await window.showModalDialog(getUrl,arguments,features);} if('"
													+ call_from
													+ "' == 'CA'){ alert('"+success_msg+"'); parent.window.returnValue='Y'; top.close();} else {	 parent.f_query_add_mod.location.href = '../eOP/jsp/VisitRegistrationMain.jsp?oa_install_yn=Y&oper_stn_id="
											+ oper_stn_id
											+ "&query_string="
											+ java.net.URLEncoder.encode(query_string,"UTF-8")
											+ "&wait_list_inv="
											+ wait_list
											+ "&status=Y&function_id="
											+ function_id
											+ "&fromserv=Y';"
											+ "parent.messageFrame.location.href = '../eCommon/jsp/error.jsp?err_num="
											+ error
											+ "&err_value="
											+ error_value
											+ "'} ";
				
									out.println(htmlFor);
								} else if (maintain_doc_or_file.equals("D")
										&& patFlag.equals("N")) {
				
											
									session.setAttribute("VISIT_SQLSTRINGOP",sqlStringOP);
				
									String htmlFor = "var dialogHeight = '50vh';	var dialogWidth = '55vw' ;var dialogTop = '65'; var arguments =   '';var newval=' ';var fileString='';var fileString2='';  var fileval=''; var new_file_no= fileval; if(new_file_no == null) new_file_no='';if("
											+ cnt1
											+ " > 0){ var getUrl        =  '../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=OP&P_function_id=VISIT_REGISTRATION&step=1&sql_querykey=VISIT_SQLSTRINGOP" //modified this line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the Query String.
											//+ java.net.URLEncoder.encode(sqlStringOP,"UTF-8")
											+ "&EncounterId="
											+ l_encounter_id
											+ "&dest_locn_type="
											+ assign_care_locn_type
											+ "&dest_locn_code="
											+ assign_care_locn_code
											+ "&reportParamNames="
											+ reportParamNamesOP
											+ "&reportParamValues="
											+ reportParamValuesOP
											+ "';	var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;'; var retVal =await window.showModalDialog(getUrl,arguments,features);}if('"
											+ mod_id
											+ "' == 'MP'){alert('"
											+ err1
											+ "'+' '+'"
											+ err2
											+ "'+' '+fileString+newval+fileString2);top.close();}else{ if('"
													+ call_from
													+ "' == 'CA'){ alert('"+success_msg+"'); parent.window.returnValue='Y'; top.close();} else {	parent.f_query_add_mod.location.href = '../eOP/jsp/VisitRegistrationMain.jsp?oa_install_yn=Y&oper_stn_id="
											+ oper_stn_id
											+ "&query_string="
											+ java.net.URLEncoder.encode(query_string,"UTF-8")
											+ "&wait_list_inv="
											+ wait_list
											+ "&status=Y&function_id="
											+ function_id
											+ "&fromserv=Y';"
											+ "parent.messageFrame.location.href = '../eCommon/jsp/error.jsp?err_num="
											+ error
											+ "&err_value="
											+ error_value
											+ "'} }";
				
									out.println(htmlFor);
								}
				
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						error_value = "1";
					
						try {			
				
							/*Below line commented by senthil Requested file*/
							/*Statement stmt_fm = con.createStatement();
							ResultSet rset_fm = null;
							String fm_install_yn = "N";
				
							rset_fm = stmt_fm
									.executeQuery("select install_yn from sm_module where module_id ='FM'");
							if (rset_fm != null && rset_fm.next()) {
								fm_install_yn = rset_fm.getString("install_yn");
							}
							if (rset_fm != null)
								rset_fm.close();
				
							int recordCount=0;
							String autoRegSql = "select count(*) as recordCount from mr_pat_file_index where patient_id = '"+patientId+"' and facility_id = '"+facilityId+"'";
							
							System.err.println("autoRegSql===>"+autoRegSql);
							
							rset_fm = stmt_fm.executeQuery(autoRegSql);
							if (rset_fm != null && rset_fm.next()) {
								recordCount = rset_fm.getInt("recordCount");
							}
							if (rset_fm != null)
								rset_fm.close();
							if (stmt_fm != null)
								stmt_fm.close();
				
							System.err.println("inserted===>"+inserted);
				            System.err.println("req_no===>"+req_no);	 
				            System.err.println("maintain_doc_or_file===>"+maintain_doc_or_file);
				            System.err.println("appt_id===>"+appt_id);	
				            System.err.println("fm_install_yn===>"+fm_install_yn);			
							System.err.println("online_mr_notfn_yn===>"+online_mr_notfn_yn);
				            System.err.println("recordCount===>"+recordCount);  */
							//End Senthil
				 			
								
							if (inserted) {
								
								if(req_no =="")  {
									if (maintain_doc_or_file.equals("F")) {
										new_file_no = req.getParameter("new_file_no"); 
										if (new_file_no == null)
											new_file_no = "";
										
										if (appt_id.equals("")) {
											if(fm_install_yn.equals("Y")) {
												if(online_mr_notfn_yn.equals("Y")) {
												// check whether file exists for the logged-in facility in mr_pat_file_index. if exists, call this method.
												/*   The Integer recordCount is introduced for the Incident IN017952 on 19.01.2009 by Suresh.
												       If file creation and regstration of visit is done in different facility then Auto file Request window does not exists.
												 */
													//recordCount = 0;
													if(recordCount >= 1) {
														//requestfile("1", patientId, facilityId,assign_care_locn_code, con);
														try {
															
															StringBuffer htmlFor = new StringBuffer();
															htmlFor.setLength(0);
										
															htmlFor.append("var jsp_name = '../../eCommon/blank.html';");
															htmlFor.append(" jsp_name = '../../eFM/jsp/FMAcceptFileTypeVolumeNoFrame.jsp?patient_id="
																			+ patientId
																			+ "&online_mr_notfn_yn="
																			+ online_mr_notfn_yn
																			+ "&fs_locn_code="
																			+ fs_locn_code
																			+ "&encounter_id="
																			+ l_encounter_id
																			+ "&req_locn_id="
																			+ assign_care_locn_code + "';");
															htmlFor.append("var retValue = '';");
															htmlFor.append("dialogHeight	= '35vh';");
															htmlFor.append("dialogWidth		= '30vw';");
															htmlFor.append("dialogTop		= '185';");
															htmlFor.append("dialogLeft		= '250';");
															htmlFor.append("center			= '0';");
															htmlFor.append("status			= 'no';");
															htmlFor.append("var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + '; center: ' + center + '; status: ' + status + '; dialogTop :' + dialogTop + ';dialogLeft:' + dialogLeft+';scroll=no';");
															htmlFor.append("var arguments		= '';");
															htmlFor.append("retValue	 =await window.showModalDialog(jsp_name,arguments, features );");
															htmlFor.append("if(retValue== null)  retValue = 'N';");
															
															//htmlFor.append("document.form1.submit();}");
															//htmlFor.append("<body class='message'>");
															htmlFor.append("var HTMLVal = \"");
															htmlFor.append("<form name='form1' method='post' action='../servlet/eOP.VisitRegistrationServlet' target='messageFrame'>");
															htmlFor.append("<input type='hidden' name='req_no'></input>");
															htmlFor.append("<input type='hidden' name='appt_id' value='"+appt_id+"'></input>");
															htmlFor.append("<input type='hidden' name='facilityId' value='"+facilityId+"'></input>");
															htmlFor.append("<input type='hidden' name='assign_care_locn_code' value='"+assign_care_locn_code+"'></input>");
															htmlFor.append("<input type='hidden' name='assign_care_locn_type' value='"+assign_care_locn_type+"'></input>");
															htmlFor.append("<input type='hidden' name='visit_adm_type' value='"+visit_adm_type+"'></input>");
															htmlFor.append("<input type='hidden' name='cnt1' value='"+cnt1+"'></input>");
															htmlFor.append("<input type='hidden' name='l_encounter_id' value='"+l_encounter_id+"'></input>");
															htmlFor.append("<input type='hidden' name='mod_id' value='"+mod_id+"'></input>");
															htmlFor.append("<input type='hidden' name='fileGenerated' value='"+fileGenerated+"'></input>");
															htmlFor.append("<input type='hidden' name='call_from' value='"+call_from+"'></input>");
															htmlFor.append("<input type='hidden' name='success_msg' value='"+success_msg+"'></input>");
															htmlFor.append("<input type='hidden' name='call_from' value='"+call_from+"'></input>");
															htmlFor.append("<input type='hidden' name='oper_stn_id' value='"+oper_stn_id+"'></input>");
															htmlFor.append("<input type='hidden' name='mod_id' value='"+mod_id+"'></input>");
															htmlFor.append("<input type='hidden' name='invitation_no' value='"+invitation_no+"'></input>");
															htmlFor.append("<input type='hidden' name='call_from' value='"+call_from+"'></input>");
															htmlFor.append("<input type='hidden' name='wait_list' value='"+wait_list+"'></input>");
															htmlFor.append("<input type='hidden' name='function_id' value='"+function_id+"'></input>");
															htmlFor.append("<input type='hidden' name='query_string' value='"+query_string+"'></input>");
															htmlFor.append("<input type='hidden' name='patientId' value='"+patientId+"'></input>");
															htmlFor.append("<input type='hidden' name='error' value='"+error+"'></input>");
															htmlFor.append("<input type='hidden' name='error_value' value='"+error_value+"'></input>");
															htmlFor.append("</form>\";");
															htmlFor.append("toAllowInternalReport=false;");
															htmlFor.append("showModal();");
															//htmlFor.append("console.log(self);");
															//htmlFor.append("console.log(self.document.form1);");
															htmlFor.append("self.document.form1.req_no.value =retValue; ");
									
															htmlFor.append("self.document.form1.submit();");
															htmlFor.append("await new Promise(resolve => setTimeout(resolve, 1000));");
															error_value = "1";
															//out.println("</body>");
															//htmlFor.append("</body>");
															
										
															out.println(htmlFor.toString());
															htmlFor.setLength(0);
				
														} catch (Exception e) {
															out.println(e);
															e.printStackTrace();
														}
													}
												}
											}
										}
									}
								}
				
								//  18408 Thursday, January 21, 2010 VenkatS
								String sqlString="";
								if(assign_q_num_by.equals("S"))
								{
									sqlString = "select distinct report_id, sm_get_desc.SM_REPORT(MODULE_ID,report_id,'"+locale+"','1') report_desc, 1 no_of_copies, module_id from op_online_report where OPERATING_FACILITY_ID='"
										+ facilityId
										+ "' and PRINT_AT_CI_YN='Y' and (clinic_code='"
										+ assign_care_locn_code
										+ "' or clinic_code ='*All') and (VISIT_TYPE_CODE='"
										+ visit_adm_type
										+ "' OR VISIT_TYPE_CODE='*A') and report_id not in ('OPRNTFMR','MPBFLLBL','FMFLRQSL') order by 2";
								}
								else
								{
									sqlString = "select distinct report_id, sm_get_desc.SM_REPORT(MODULE_ID,report_id,'"+locale+"','1') report_desc, 1 no_of_copies, module_id from op_online_report where OPERATING_FACILITY_ID='"
										+ facilityId
										+ "' and PRINT_AT_CI_YN='Y' and (clinic_code='"
										+ assign_care_locn_code
										+ "' or clinic_code ='*All') and (VISIT_TYPE_CODE='"
										+ visit_adm_type
										+ "' OR VISIT_TYPE_CODE='*A') and report_id not in ('OPRNTFMR','MPBFLLBL','FMFLRQSL','OPBQTKNO') order by 2";
								}
								String reportParamNames = "p_encounter_id,p_clinic_code,p_clinic_type,p_patient_id,p_user_name,p_file_no";
								String reportParamValues = "" + l_encounter_id + ","
										+ assign_care_locn_code + "," + assign_care_locn_type
										+ "," + patientId + "," + addedById + "," + gen_file_no
										+ "";
								
								session.setAttribute("VISIT_SQLSTRING",sqlString);
				
								String htmlFor = "if(typeof toAllowInternalReport !== 'undefined' && toAllowInternalReport){var dialogHeight    = '50vh' ;	var dialogWidth = '55vw' ;				var dialogTop = '65';	var arguments =   ''; if("
										+ cnt1
										+ " > 0 ){	var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=OP&P_function_id=VISIT_REGISTRATION&step=1&sql_querykey=VISIT_SQLSTRING" //modified this line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the Query String.
										//+ java.net.URLEncoder.encode(sqlString,"UTF-8")
										+ "&EncounterId="
										+ l_encounter_id
										+ "&dest_locn_type="
										+ assign_care_locn_type
										+ "&dest_locn_code="
										+ assign_care_locn_code
										+ "&reportParamNames="
										+ reportParamNames
										+ "&reportParamValues="
										+ reportParamValues
										+ "';	var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ; retVal = await window.showModalDialog(getUrl,arguments,features); }}";
				
				
								out.println(htmlFor);
								
								if (oa_install_yn.equals("N") && mod_id.equals("MP")) {
									int indval = error.indexOf("<br>");
									out.println("alert(\"" + error.substring(0, indval)
											+ error.substring(indval + 4)
											+ "\");top.close();");
								} else {
									error_value = "1";
									if (fileGenerated) {
										out.println("if('"
													+ call_from
													+ "' == 'CA'){ alert('"+success_msg+"'); parent.window.returnValue='Y'; top.close(); } else {	parent.f_query_add_mod.location.href = '../eOP/jsp/VisitRegistrationMain.jsp?oa_install_yn=Y&oper_stn_id="
														+ oper_stn_id
														+ "&query_string="
													    + java.net.URLEncoder.encode(query_string,"UTF-8")
														+ "&wait_list_inv="
														+ wait_list
														+ "&status=Y&function_id="
														+ function_id
														+ "&fromserv=Y';"
														+ "parent.messageFrame.location.href = '../eCommon/jsp/error.jsp?err_num="
														+ error + "&err_value=" + error_value
														+ "';" + " }");
									} else {
										/*Added by Dharma on 24th Feb 2020 against MO-CRF-20155 Start*/
										if(self_chkin_appt_yn.equals("Y")){
											out.println("parent.searchCriteria.location.href='../eOP/jsp/SelfChkInAppCriteria.jsp?oa_install_yn=Y&oper_stn_id="+ oper_stn_id+"';parent.SearchResults.location.href='../eCommon/html/blank.html';"
												+ "parent.messageFrame.location.href = '../eCommon/jsp/error.jsp?err_num="
														+ error + "&err_value=" + error_value
														+ "';");
										}else{
											/*Added by Dharma on 24th Feb 2020 against MO-CRF-20155 End*/
											out.println("if('"
													+ call_from
													+ "' == 'CA'){ alert('"+success_msg+"'); parent.window.returnValue='Y'; top.close(); } else {	parent.f_query_add_mod.location.href = '../eOP/jsp/VisitRegistrationMain.jsp?oa_install_yn=Y&oper_stn_id="
														+ oper_stn_id
														+ "&query_string="
													    + java.net.URLEncoder.encode(query_string,"UTF-8")
														+ "&wait_list_inv="
														+ wait_list
														+ "&status=Y&function_id="
														+ function_id
														+ "&fromserv=Y';"
														+ "parent.messageFrame.location.href = '../eCommon/jsp/error.jsp?err_num="
														+ error + "&err_value=" + error_value
														+ "';" + " }");
										}
									}
								}
								/*Added for the CRF - MMS-QH-CRF-0066 - start*/
								if (bl_install_yn.equals("Y")) {
									try
									{
										String bean_id		= "bl_blinsuranceimagebean" ;
										String bean_name	= "eBL.BLInsuranceImageBean";
										BLInsuranceImageBean bean = (BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id, bean_name, req ) ;
										bean.insertInsuranceDBvalues(patientId);  
									}
									catch(Exception ex)
									{
										System.out.println("Exception while calling BLInsuranceImageBean:::: "+ex);
									}
								}
								/*Added for the CRF - MMS-QH-CRF-0066 - End*/
							} 
							else 
							{
								if(error.equals("NO_REC_ON_OA_APPT")){/*Added By Dharma on 25th Nov 2014 against HSA-SCF-0145 [IN:051698]*/
									out.println("parent.frames[1].frames[0].onError(\""+error+"\");");
										//message.clear();
								}else{
									res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
										+ java.net.URLEncoder.encode(error,"UTF-8"));
								}
							}
				
						} catch (Exception e) {
							e.printStackTrace();
						} 
					} else if (status.equals("1")) {
						java.util.Hashtable message = MessageManager
								.getMessage(locale, "PAT_CAT_EXP", "MP");
						String msg = ((String) message.get("message"));
						out.println("parent.parent.frames[2].f_query_add_mod.patient_sub.erroDisplayFromServlet('LOC_NOT_ENTITLED','MP');");
						out.println("if(parent.parent.frames[2].frames[1].patient_main.checkin_tab){parent.parent.frames[2].frames[1].patient_main.checkin_tab.disabled=false;};if(parent.parent.frames[2].frames[1].patient_main.addvisit_tab){parent.parent.frames[2].frames[1].patient_main.addvisit_tab.disabled=false;};if(parent.parent.frames[2].frames[1].patient_main.invitation_tab){parent.parent.frames[2].frames[1].patient_main.invitation_tab.disabled=false;}");
							res
									.sendRedirect("../eCommon/jsp/error.jsp?err_num="
											+ java.net.URLEncoder.encode(msg,"UTF-8"));
							message.clear();
						//out.println("<script>parent.parent.frames[2].f_query_add_mod.patient_sub.erroDisplayFromServlet('PAT_CAT_EXP','MP');</script>");
					} else if (status.equals("2")) {
						java.util.Hashtable message = MessageManager
								.getMessage(locale, "LOC_NOT_ENTITLED", "MP");
						String msg = ((String) message.get("message"));
						out.println("parent.parent.frames[2].f_query_add_mod.patient_sub.erroDisplayFromServlet('LOC_NOT_ENTITLED','MP');");
						out.println("if(parent.parent.frames[2].frames[1].patient_main.checkin_tab){parent.parent.frames[2].frames[1].patient_main.checkin_tab.disabled=false;};if(parent.parent.frames[2].frames[1].patient_main.addvisit_tab){parent.parent.frames[2].frames[1].patient_main.addvisit_tab.disabled=false;};if(parent.parent.frames[2].frames[1].patient_main.invitation_tab){parent.parent.frames[2].frames[1].patient_main.invitation_tab.disabled=false;}");
							res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
											+ java.net.URLEncoder.encode(msg,"UTF-8"));
							message.clear();
						//out.println("<script>parent.parent.frames[2].f_query_add_mod.patient_sub.erroDisplayFromServlet('LOC_NOT_ENTITLED','MP');</script>");
			
					} else if (status.equals("3")) {
						java.util.Hashtable message = MessageManager
								.getMessage(locale, "SPL_NOT_ENTITLED", "MP");
						String msg = ((String) message.get("message"));
						out.println("if(parent.parent.frames[2].frames[1].patient_main.checkin_tab){parent.parent.frames[2].frames[1].patient_main.checkin_tab.disabled=false;};if(parent.parent.frames[2].frames[1].patient_main.addvisit_tab){parent.parent.frames[2].frames[1].patient_main.addvisit_tab.disabled=false;};if(parent.parent.frames[2].frames[1].patient_main.invitation_tab){parent.parent.frames[2].frames[1].patient_main.invitation_tab.disabled=false;}");
						res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
											+ java.net.URLEncoder.encode(msg,"UTF-8"));
						message.clear();
						//out.println("<script>parent.parent.frames[2].f_query_add_mod.patient_sub.erroDisplayFromServlet('SPL_NOT_ENTITLED','MP');</script>");
			
					} else if (status.equals("4")) {
						java.util.Hashtable message = MessageManager
								.getMessage(locale, "BDCL_NOT_ENTITLED", "MP");
						String msg = ((String) message.get("message"));
						out.println("if(parent.parent.frames[2].frames[1].patient_main.checkin_tab){parent.parent.frames[2].frames[1].patient_main.checkin_tab.disabled=false;};if(parent.parent.frames[2].frames[1].patient_main.addvisit_tab){parent.parent.frames[2].frames[1].patient_main.addvisit_tab.disabled=false;};if(parent.parent.frames[2].frames[1].patient_main.invitation_tab){parent.parent.frames[2].frames[1].patient_main.invitation_tab.disabled=false;}");
						res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
											+ java.net.URLEncoder.encode(msg,"UTF-8"));
						message.clear();
						//out.println("<script>parent.parent.frames[2].f_query_add_mod.patient_sub.erroDisplayFromServlet('BDCL_NOT_ENTITLED','MP');</script>");
			
					}
			
				}else{
					java.util.Hashtable message = MessageManager
						.getMessage(locale, "ROOM_WORKING_YN", "OP");
					String msg = ((String) message.get("message"));
					out.println("if(parent.parent.frames[2].frames[1].patient_main.checkin_tab){parent.parent.frames[2].frames[1].patient_main.checkin_tab.disabled=false;};if(parent.parent.frames[2].frames[1].patient_main.addvisit_tab){parent.parent.frames[2].frames[1].patient_main.addvisit_tab.disabled=false;};if(parent.parent.frames[2].frames[1].patient_main.invitation_tab){parent.parent.frames[2].frames[1].patient_main.invitation_tab.disabled=false;}");
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
							+ java.net.URLEncoder.encode(msg,"UTF-8"));
					message.clear();
					//out.println("<script>parent.parent.frames[2].f_query_add_mod.patient_sub.erroDisplayFromServlet('ROOM_WORKING_YN','OP');</script>");
				}

			}// if practitioner is working loop added on 6/30/2004 for
				// Resource scheduling
			else {

					java.util.Hashtable message = MessageManager.getMessage(
							locale, "PRACT_WORKING_YN", "OP");
					String msg = ((String) message.get("message"));
					out.println("alert(parent.parent.frames[2].frames[3].name)");
					out.println("alert(parent.parent.frames[2].frames[4].name)");
					out.println("if(parent.parent.frames[2].frames[1].patient_main.checkin_tab){parent.parent.frames[2].frames[1].patient_main.checkin_tab.disabled=false;};if(parent.parent.frames[2].frames[1].patient_main.addvisit_tab){parent.parent.frames[2].frames[1].patient_main.addvisit_tab.disabled=false;};if(parent.parent.frames[2].frames[1].patient_main.invitation_tab){parent.parent.frames[2].frames[1].patient_main.invitation_tab.disabled=false;}");
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
							+ java.net.URLEncoder.encode(msg,"UTF-8"));
					message.clear();
					//out.println("<script>parent.parent.frames[2].f_query_add_mod.patient_sub.msgDisplayFromServlet('PRACT_WORKING_YN','OP');</script>");
		
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "
							+ e.toString() + sb.toString());
			out.println("Values sent are : <br>");
		} finally {
			if (con != null)
				ConnectionManager.returnConnection(con, req);
		}
	}

	/*public void getEpisodeStatus(HttpServletRequest req) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void tokeniseValues() {

			
	}

	public void getValues(HttpServletRequest req) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		
	}


	public void callFutureOrder() {


		
	}


	public void filecreatemethod1(boolean inserted, HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		
	}

	public void filecreatemethod2(boolean inserted, HttpServletRequest req,
			HttpServletResponse res) {

		Connection con = null;		

		
	}

	public void getData(HttpServletRequest req) {

		
	}

	public void getData1(HttpServletRequest req) {

		
	}

	public void getData2(HttpServletRequest req) {

		

	}

	public void nullcheck() {

		

	}

//	public void InsertTabdata() {
	public void InsertTabdata(HttpServletRequest req) {//// Changed As Part of Package Billing. Added Request Object
		

	}

	//public void InsertTabdata1() {
		public void InsertTabdata1(HttpServletRequest req) {//// Changed As Part of Package Billing. Added Request Object

		

	}

	public void InsertPrencounter(HttpServletRequest req) {
		

	}

	public void InsertPrencounter1() {
		

	}

	public void InsertPrencounterdetail() {
		

	}

	public void InsertPrencounterdetail1() {
		

	}

	private void requestfile(String from, String patientid, String facId, String locationCode, Connection conn)
			throws Exception {

		
	}*/

	public HashMap File_No_ExistsCall(String patId, String facyId,
			String callFrom, String assn_care_locn_code, Connection conne)
			throws Exception {

		String fileCreateSql = "{call FILE_NO_EXISTS(?,?,?,?,?,?,?,?,?,?,?,?)}";
		String p_create_file_no_yn = "N";
		HashMap hashFILE_NO_EXISTS = new HashMap();

		CallableStatement fileCreateCS = conne.prepareCall(fileCreateSql);
		fileCreateCS.setString(1, patId);
		fileCreateCS.setString(2, facyId);
		fileCreateCS.setString(3, callFrom);
		fileCreateCS.setString(4, assn_care_locn_code);
		fileCreateCS.registerOutParameter(5, java.sql.Types.VARCHAR);
		fileCreateCS.registerOutParameter(6, java.sql.Types.VARCHAR);
		fileCreateCS.registerOutParameter(7, java.sql.Types.VARCHAR);
		fileCreateCS.registerOutParameter(8, java.sql.Types.VARCHAR);
		fileCreateCS.registerOutParameter(9, java.sql.Types.VARCHAR);
		fileCreateCS.registerOutParameter(10, java.sql.Types.VARCHAR);
		fileCreateCS.registerOutParameter(11, java.sql.Types.VARCHAR);
		fileCreateCS.registerOutParameter(12, java.sql.Types.INTEGER);
		try {
			fileCreateCS.execute();

			p_create_file_no_yn = fileCreateCS.getString(5);

			if (p_create_file_no_yn == null)
				p_create_file_no_yn = "";

			hashFILE_NO_EXISTS.put("p_create_file_no_yn", p_create_file_no_yn);

			String p_seperate_file_no_yn = fileCreateCS.getString(6);
			if (p_seperate_file_no_yn == null)
				p_seperate_file_no_yn = "";
			hashFILE_NO_EXISTS.put("p_seperate_file_no_yn",
					p_seperate_file_no_yn);

			String p_pat_ser_grp_code = fileCreateCS.getString(7);
			if (p_pat_ser_grp_code == null)
				p_pat_ser_grp_code = "";
			hashFILE_NO_EXISTS.put("p_pat_ser_grp_code", p_pat_ser_grp_code);

			String p_mr_section_type = fileCreateCS.getString(8);
			if (p_mr_section_type == null)
				p_mr_section_type = "";
			hashFILE_NO_EXISTS.put("p_mr_section_type", p_mr_section_type);

			String p_mr_section_code = fileCreateCS.getString(9);
			if (p_mr_section_code == null)
				p_mr_section_code = "";
			hashFILE_NO_EXISTS.put("p_mr_section_code", p_mr_section_code);

			String p_single_or_multi_files_ind = fileCreateCS.getString(10);
			if (p_single_or_multi_files_ind == null)
				p_single_or_multi_files_ind = "";
			hashFILE_NO_EXISTS.put("p_single_or_multi_files_ind",
					p_single_or_multi_files_ind);

			String p_error_message = fileCreateCS.getString(11);
			if (p_error_message == null)
				p_error_message = "";
			hashFILE_NO_EXISTS.put("p_error_message", p_error_message);

		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			fileCreateCS.close();
		}

		return hashFILE_NO_EXISTS; 
	}

	public HashMap ifPractitionerWorkingYN(String ftyId,
			String assign_locn_code, String a_practitioner_id, Connection cnn)
			throws Exception {
		String fileCreateSql = "{call GET_WORKING_DAY_YN(?,?,?,sysdate,?,?)}";

		String practWorkingYN = "N";
		HashMap hashFILE_NO_EXISTS = new HashMap();

		CallableStatement fileCreateCS = cnn.prepareCall(fileCreateSql);
		fileCreateCS.setString(1, ftyId);
		fileCreateCS.setString(2, assign_locn_code);
		fileCreateCS.setString(3, a_practitioner_id);
		fileCreateCS.registerOutParameter(4, java.sql.Types.VARCHAR);
		fileCreateCS.registerOutParameter(5, java.sql.Types.VARCHAR);

		try {
			fileCreateCS.execute();

			practWorkingYN = fileCreateCS.getString(4);
			if (practWorkingYN == null)
				practWorkingYN = "N";
			hashFILE_NO_EXISTS.put("practWorkingYN", practWorkingYN);
			
			String P_ERR_MSG = fileCreateCS.getString(5);
			if (P_ERR_MSG == null)
				P_ERR_MSG = "";
			hashFILE_NO_EXISTS.put("P_ERR_MSG", P_ERR_MSG);
		} catch (Exception e1) {

			
			e1.printStackTrace();

		} finally {
			fileCreateCS.close();
		}

		return hashFILE_NO_EXISTS;

	}

		public void doOnlineReport(boolean inserted, HttpServletRequest req,
			HttpServletResponse res)throws ServletException, IOException, SQLException {
		HttpSession session=null;
		PrintWriter out=null;		
		out = res.getWriter();
		session = req.getSession(false);	

		java.util.Properties p		= null;	
		p = (java.util.Properties) session.getValue("jdbc");
		String locale="";
		locale = p.getProperty("LOCALE");
		//Below line added by senthil 		
		Connection con_req = null;
		PreparedStatement pstmt_req = null;
		ResultSet rs_req = null;

		try {
			
			String perm_fs_locn = "";
			String new_req_no = "";
			String gen_file_no = "";
			


			if(!req_no.equals("N"))  {
				StringTokenizer st  = new StringTokenizer(req_no,"&");
				while(st.hasMoreTokens())	{
							new_req_no = st.nextToken();
							perm_fs_locn      = st.nextToken();
				}
			}


			String appt_id = req.getParameter("appt_id");
			String facilityId = req.getParameter("facilityId");
			String assign_care_locn_code = req.getParameter("assign_care_locn_code");
			String assign_care_locn_type = req.getParameter("assign_care_locn_type");
			String visit_adm_type = req.getParameter("visit_adm_type");
			int cnt1 = Integer.parseInt(req.getParameter("cnt1"));
			String l_encounter_id = req.getParameter("l_encounter_id");
			String oa_install_yn = req.getParameter("oa_install_yn");
			boolean fileGenerated = Boolean.valueOf(req.getParameter("fileGenerated"));
			String call_from = req.getParameter("call_from");
			String success_msg = req.getParameter("success_msg");
			String mod_id = req.getParameter("mod_id");
			String oper_stn_id = req.getParameter("oper_stn_id");
			String wait_list = req.getParameter("wait_list");
			String function_id = req.getParameter("function_id");
			/* this line was commmanted by VenkateshS,Reason is this is "unused variable" while generate checkstyle report */
			//String invitation_no = req.getParameter("invitation_no");
			String error = req.getParameter("error");
			String error_value = req.getParameter("error_value");
			String query_string = req.getParameter("query_string");
			String patientId = req.getParameter("patientId");
			String assign_q_num_by = req.getParameter("assign_q_num_by") == null ? "S" : req.getParameter("assign_q_num_by");
			error = URLDecoder.decode(error, "UTF-8");
		        
		    // Step 2: Manually replace HTML entities with corresponding symbols
			error = error
		                .replace("&lt;", "<")
		                .replace("&gt;", ">")
		                .replace("&amp;", "&")
		                .replace("&quot;", "\"")
		                .replace("&#39;", "'");

			if(oa_install_yn == null)  oa_install_yn = "";
			
			
			     try{
				    con_req = ConnectionManager.getConnection(req);
					if(req_no.equals("N") || req_no.equals("")){
					pstmt_req = con_req.prepareStatement("select count(*) from op_online_report where OPERATING_FACILITY_ID='"
									+ facilityId
									+ "' and PRINT_AT_CI_YN='Y' and (clinic_code='"
									+ assign_care_locn_code
									+ "' or clinic_code ='*All') and (VISIT_TYPE_CODE='"
									+ visit_adm_type
									+ "' OR VISIT_TYPE_CODE='*A') and report_id not in ('OPRNTFMR','FMFLRQSL','MPBFLLBL')");
					rs_req = pstmt_req.executeQuery();
					if (rs_req != null) {
						if (rs_req.next()) {
							cnt1 = rs_req.getInt(1);
						}
					}
					}else{
						pstmt_req = con_req.prepareStatement("select count(*) from op_online_report where OPERATING_FACILITY_ID='"
									+ facilityId
									+ "' and PRINT_AT_CI_YN='Y' and (clinic_code='"
									+ assign_care_locn_code
									+ "' or clinic_code ='*All') and (VISIT_TYPE_CODE='"
									+ visit_adm_type
									+ "' OR VISIT_TYPE_CODE='*A')");
					rs_req = pstmt_req.executeQuery();
					if (rs_req != null) {
						if (rs_req.next()) {
							cnt1 = rs_req.getInt(1);
						}
					}
					
					}
					if (rs_req != null)rs_req.close();
					if (pstmt_req != null)pstmt_req.close();
						
				} catch (Exception e) {
					
							e.printStackTrace();
				}finally{
			          if (con_req != null)ConnectionManager.returnConnection(con_req, req);
					  }
			
			
			//End line modified senthil


			if (inserted) {

				String appt_case_yn1 = "";
				String p_call_from = "WALKIN";
				String sqlString = "";


					if (!appt_id.equals("") || req_no.equals("N"))
			             appt_case_yn1 = "A";
					else
						appt_case_yn1 = "W";

 // 18408 Thursday, January 21, 2010 VenkatS
 
 
if(assign_q_num_by.equals("S"))
				{
				if (appt_case_yn1 == "A" && !req_no.equals("N")) { //this condtion Added by senthil

				sqlString = "select distinct report_id, sm_get_desc.SM_REPORT(MODULE_ID,report_id,'"+locale+"','1') report_desc, 1 no_of_copies, module_id from op_online_report where OPERATING_FACILITY_ID='"
						+ facilityId
						+ "' and PRINT_AT_CI_YN='Y' and (clinic_code='"
						+ assign_care_locn_code
						+ "' or clinic_code ='*All') and (VISIT_TYPE_CODE='"
						+ visit_adm_type
						+ "' OR VISIT_TYPE_CODE='*A') order by 2";  // and report_id not in ('MPBFLLBL','FMFLRQSL') order by 2"; //commented by senthil

				} else if (appt_case_yn1 == "A" && req_no.equals("N")) { //else if condtion Added by senthil
			   
				sqlString = "select distinct report_id, sm_get_desc.SM_REPORT(MODULE_ID,report_id,'"+locale+"','1') report_desc, 1 no_of_copies, module_id from op_online_report where OPERATING_FACILITY_ID='"
						+ facilityId
						+ "' and PRINT_AT_CI_YN='Y' and (clinic_code='"
						+ assign_care_locn_code
						+ "' or clinic_code ='*All') and (VISIT_TYPE_CODE='"
						+ visit_adm_type
						+ "' OR VISIT_TYPE_CODE='*A') and report_id not in ('MPBFLLBL','FMFLRQSL','OPRNTFMR') order by 2";
                  //End Added by senthil
				}
				else if (appt_case_yn1 == "W")  {

					sqlString = "select distinct report_id, sm_get_desc.SM_REPORT(MODULE_ID,report_id,'"+locale+"','1') report_desc, 1 no_of_copies, module_id from op_online_report where OPERATING_FACILITY_ID='"
						+ facilityId
						+ "' and PRINT_AT_CI_YN='Y' and (clinic_code='"
						+ assign_care_locn_code
						+ "' or clinic_code ='*All') and (VISIT_TYPE_CODE='"
						+ visit_adm_type
						+ "' OR VISIT_TYPE_CODE='*A') and report_id not in ('MPBFLLBL') order by 2";
				}
				}else
				{
					if (appt_case_yn1 == "A") {

				sqlString = "select distinct report_id, sm_get_desc.SM_REPORT(MODULE_ID,report_id,'"+locale+"','1') report_desc, 1 no_of_copies, module_id from op_online_report where OPERATING_FACILITY_ID='"
						+ facilityId
						+ "' and PRINT_AT_CI_YN='Y' and (clinic_code='"
						+ assign_care_locn_code
						+ "' or clinic_code ='*All') and (VISIT_TYPE_CODE='"
						+ visit_adm_type
						+ "' OR VISIT_TYPE_CODE='*A') and report_id not in ('MPBFLLBL','FMFLRQSL','OPBQTKNO') order by 2";

				} else if (appt_case_yn1 == "W")  {

					sqlString = "select distinct report_id, sm_get_desc.SM_REPORT(MODULE_ID,report_id,'"+locale+"','1') report_desc, 1 no_of_copies, module_id from op_online_report where OPERATING_FACILITY_ID='"
						+ facilityId
						+ "' and PRINT_AT_CI_YN='Y' and (clinic_code='"
						+ assign_care_locn_code
						+ "' or clinic_code ='*All') and (VISIT_TYPE_CODE='"
						+ visit_adm_type
						+ "' OR VISIT_TYPE_CODE='*A') and report_id not in ('MPBFLLBL','OPBQTKNO') order by 2";
				}
				}


				String reportParamNames = "p_encounter_id,p_call_from,p_clinic_code,p_clinic_type,p_patient_id,p_user_name,p_req_no,p_file_no";
				String reportParamValues = "" + l_encounter_id + "," + p_call_from + ","
						+ assign_care_locn_code + "," + assign_care_locn_type
						+ "," + patientId + "," + addedById + "," + new_req_no + ","+ gen_file_no
						+ "";

				
				session.setAttribute("VISIT_SQLSTRING",sqlString);

				String htmlFor = "var dialogHeight    = '50vh' ;	var dialogWidth = '55vw' ;				var dialogTop = '65';	var arguments =   ''; if("
						+ cnt1
						+ " > 0 ){	var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=OP&P_function_id=VISIT_REGISTRATION&step=1&sql_querykey=VISIT_SQLSTRING" //modified this line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the Query String.
						//+ java.net.URLEncoder.encode(sqlString,"UTF-8")
						+ "&EncounterId="
						+ l_encounter_id
						+ "&dest_locn_type="
						+ assign_care_locn_type
						+ "&dest_locn_code="
						+ assign_care_locn_code
						+ "&perm_fs_locn_code="
						+ perm_fs_locn
						+ "&reportParamNames="
						+ reportParamNames
						+ "&reportParamValues="
						+ reportParamValues
						+ "';	var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ; retVal = await window.showModalDialog(getUrl,arguments,features); } ";

				out.println(htmlFor);
				//out.println("</body></html>");

				if (oa_install_yn.equals("N") && mod_id.equals("MP")) {

					int indval = error.indexOf("<br>");
					out.println("alert(\"" + error.substring(0, indval)
							+ error.substring(indval + 4)
							+ "\");top.close();");
				} else {

					error_value = "1";
					if (fileGenerated) {

						out.println("if('"
									+ call_from
									+ "' == 'CA'){ alert('"+success_msg+"'); parent.window.returnValue='Y'; top.close(); } else {	parent.f_query_add_mod.location.href = '../eOP/jsp/VisitRegistrationMain.jsp?oa_install_yn=Y&oper_stn_id="
										+ oper_stn_id
										+ "&query_string="
									    + java.net.URLEncoder.encode(query_string,"UTF-8")
										+ "&wait_list_inv="
										+ wait_list
										+ "&status=Y&function_id="
										+ function_id
										+ "&fromserv=Y';"
										+ "parent.messageFrame.location.href = '../eCommon/jsp/error.jsp?err_num="
										+ error+"&err_value=" + error_value
										+ "';" + " }");
					} else {
						
						out.println("if('"
									+ call_from
									+ "' == 'CA'){ alert('"+success_msg+"'); parent.window.returnValue='Y'; top.close(); } else {	parent.f_query_add_mod.location.href = '../eOP/jsp/VisitRegistrationMain.jsp?oa_install_yn=Y&oper_stn_id="
										+ oper_stn_id
										+ "&query_string="
									    + java.net.URLEncoder.encode(query_string,"UTF-8")
										+ "&wait_list_inv="
										+ wait_list
										+ "&status=Y&function_id="
										+ function_id
										+ "&fromserv=Y'; let error = '"+error+"';" 
										+ "parent.messageFrame.location.href = '../eCommon/jsp/error.jsp?err_num='+error+'&err_value="+ error_value
										+ "';" + " }");
										
					}
				}
			} else {

					res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
							+ java.net.URLEncoder.encode(error,"UTF-8"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			out.println(e.toString());
		} finally {
			//if (con != null)
				//ConnectionManager.returnConnection(con, req);
		}
	}

	public static String checkForNull(String inputString){
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
}


