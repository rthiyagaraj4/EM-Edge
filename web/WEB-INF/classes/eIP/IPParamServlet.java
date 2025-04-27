/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;

public class IPParamServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{ 

	PrintWriter out;
	java.util.Properties p;

	String client_ip_address ;
    String facilityId;
	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session				= req.getSession(false);
		this.p				= (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId		= (String) session.getValue( "facility_id" ) ;
		client_ip_address	= p.getProperty("client_ip_address");

		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String operation = req.getParameter("mode");

			//String a=req.getParameter("allow_booking_without_edd_yn");
			if (operation.equals("insert"))	insertIPParam(req, res);
			if (operation.equals("modify"))	modifyIPParam(req, res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void insertIPParam(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			String facility_id	=checkForNull(req.getParameter("facility_id"));

			String priority_code = checkForNull(req.getParameter("priority"));
			
			String default_ref_pract=checkForNull(req.getParameter("default_ref_pract")); //this line Added for this CRF Bru-HIMS-CRF-354
			
			
			
		/*	String setup_bl_dtls_in_ip_yn  = checkForNull(req.getParameter("setup_bl_dtls_in_ip_yn"),"N");
			String outst_amt_limit = checkForNull(req.getParameter("outst_amt_limit"),"0");
			String policy_expiry_warning_period = checkForNull(req.getParameter("policy_expiry_warning_period"),"0");
			String credit_auth_reqd_yn  = checkForNull(req.getParameter("credit_auth_reqd_yn"),"N");*/
			String addedById 			= p.getProperty( "login_user" ) ;
			String modifiedFacilityId		=	facilityId;
			String addedAtWorkstation	=	client_ip_address;
			//String allow_booking_without_edd_yn = req.getParameter("allow_booking_without_edd_yn");

            
			
			Timestamp added_date	= new Timestamp(System.currentTimeMillis() );

			HashMap tabdata	= new HashMap();                        
			tabdata.put("facility_id",facility_id);
			tabdata.put("bed_block_period_normal", checkForNull(req.getParameter("bed_block_period_normal"),"0"));

			tabdata.put("REVOKE_DEATH_DISP_TYPE", checkForNull(req.getParameter("DISP_TYPE_FOR_REVOKE_DEATH"))); // added by mujafar  for ML-MMOH-CRF-1427
			tabdata.put("MAX_ALLOWED_ACCOM_PERS", checkForNull(req.getParameter("MAX_ALLOWED_ACCOM_PERS"),"0"));
			tabdata.put("CHK_IN_LODGER_MAX_PERIOD", checkForNull(req.getParameter("chk_in_lodger_max_period"),"0"));
			tabdata.put("DEACTIVATE_PSEUDO_BED_YN", checkForNull(req.getParameter("DPBY"),"N"));
			tabdata.put("ALLOW_GATE_PASS_PRE_DIS_ADV_YN", checkForNull(req.getParameter("AGPDA"),"N")); // ADDED by mujafar for MO-CRF-20157
			
			tabdata.put("allowed_admission_type", checkForNull(req.getParameter("allowed_admission_type"),"R"));
			tabdata.put("change_bed_class_yn", checkForNull(req.getParameter("cbcy"),"N"));
			tabdata.put("discharge_checklist_app_yn", checkForNull(req.getParameter("dcay"),"N"));
			tabdata.put("PAT_CHECK_IN_ALLOWED_YN", checkForNull(req.getParameter("PCIAY"),"N"));
			tabdata.put("NO_SHOW_GRACE_PERIOD", checkForNull(req.getParameter("NO_SHOW_GRACE_PERIOD"),"0"));
			tabdata.put("ABSCOND_GRACE_PERIOD", checkForNull(req.getParameter("ABSCOND_GRACE_PERIOD"),"0"));
			tabdata.put("bed_block_period_dis",checkForNull(req.getParameter("bed_block_period_dis"),"0"));
			tabdata.put("bed_block_period_max",checkForNull(req.getParameter("bed_block_period_max"),"0"));
			tabdata.put("DFLT_GATE_PASS_PERIOD",checkForNull(req.getParameter("allwbl_pd_rnw_gtpass"),"0"));
			tabdata.put("disc_chklst_exp_period",checkForNull(req.getParameter("disc_chklst_exp_period"),"0"));
			tabdata.put("adv_bed_book_period_bkg",checkForNull(req.getParameter("adv_bed_book_period_bkg"),"0"));
			tabdata.put("chk_booking_limit_by",checkForNull(req.getParameter("chk_booking_limit_by")));
			tabdata.put("adm_date_chk_days",checkForNull(req.getParameter("adm_date_chk_days"),"0"));
			tabdata.put("allowed_booking_type",checkForNull(req.getParameter("allowed_booking_type")));
			tabdata.put("adm_date_chk_days_type",checkForNull(req.getParameter("adm_date_chk_days_type")));
			tabdata.put("bed_block_period_max_type",checkForNull(req.getParameter("bed_block_period_max_type")));
			tabdata.put("DFLT_GATE_PASS_UNIT",checkForNull(req.getParameter("bed_block_period_max_type1")));
			tabdata.put("disc_chklst_exp_per_unit",checkForNull(req.getParameter("disc_chklst_exp_per_unit"),"H"));
			tabdata.put("dflt_priority_for_bed_booking",checkForNull(req.getParameter("dflt_priority_for_bed_booking")));
			tabdata.put("DFLT_BLK_PRD_FOR_TFR_OUT",checkForNull(req.getParameter("transfer_out"),"0"));
			tabdata.put("dflt_bed_blocking_period",checkForNull(req.getParameter("dflt_bed_blocking_period"),"0"));
			tabdata.put("ALLOW_PAT_TYPE_FOR_LEAVE",checkForNull(req.getParameter("pat_type_override_leave_period")));
			tabdata.put("max_stay_of_lodger_after_disc",checkForNull(req.getParameter("max_stay_of_lodger_after_disc"),"0"));
			tabdata.put("dis_date_chk_days ",checkForNull(req.getParameter("dis_date_chk_days"),"0"));
			/*Below line(s) was added by venkatesh.S (4008) on 30/10/2012 against  Bru-HIMS-CRF-155 [IN030274] */
			tabdata.put("MAX_HRS_FOR_RE_ADMN",checkForNull(req.getParameter("chk_for_readmission"),"0"));
			/* end Bru-HIMS-CRF-155 [IN030274]  */
			tabdata.put("lodger_bill_type_code",checkForNull(req.getParameter("lodger_bill_type_code ")));
			tabdata.put("lodger_blng_serv_code",checkForNull(req.getParameter("lodger_blng_serv_code")));
			tabdata.put("lodger_bill_at_checkout_yn",checkForNull(req.getParameter("lodger_bill_at_checkout_yn")));
			tabdata.put("general_consent_text",checkForNull(req.getParameter("general_consent_text")));
			tabdata.put("disclosure_consent_text",checkForNull(req.getParameter("disclosure_consent_text ")));
			//tabdata.put("start_admit_screen",checkForNull(req.getParameter("start_admit_screen")));
			tabdata.put("lodger_next_srl_no",checkForNull(req.getParameter("lodger_next_srl_no"),"0"));
			tabdata.put("lodger_max_srl_no",checkForNull(req.getParameter("lodger_max_srl_no"),"0"));
			tabdata.put("allow_release_bed_on_lv",checkForNull(req.getParameter("allow_release_bed_on_lv"),"N"));
			tabdata.put("max_allowed_lv_period",checkForNull(req.getParameter("max_allowed_lv_period"),"0"));
			tabdata.put("max_allowed_lv_cancel_period",checkForNull(req.getParameter("max_allowed_lv_cancel_period"),"0"));
			tabdata.put("vital_signs_battery_id",checkForNull(req.getParameter("vital_signs_battery_id")));
			tabdata.put("bl_interfaced_yn",checkForNull(req.getParameter("bl_interfaced_yn"),"N"));
			tabdata.put("setup_bl_dtls_in_ip_yn",checkForNull(req.getParameter("setup_bl_dtls_in_ip_yn"),"N"));
			String bkg_grace_period = checkForNull(req.getParameter("bkg_grace_period"),"0");
			if(bkg_grace_period.equals("") || bkg_grace_period == null)
				bkg_grace_period = "0";
			tabdata.put("bkg_grace_period", bkg_grace_period);

			tabdata.put("UNREGISTERED_PATIENTS_BKG_YN",checkForNull(req.getParameter("unregistered_patients_bkg_yn"),"N"));
			tabdata.put("PRIORITY_APPLICABLE_YN",checkForNull(req.getParameter("priority_appl_yn"),"N"));
			tabdata.put("MAX_DISCH_PERIOD_FOR_DC",checkForNull(req.getParameter("MAX_DISCH_PERIOD_FOR_DC"),"0"));
			tabdata.put("NOSHOW_BKNG_PERIOD",checkForNull(req.getParameter("NOSHOW_BKNG_PERIOD"),"0"));//Added  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
			tabdata.put("WARN_OR_ERROR_MAX_LEAVE",checkForNull(req.getParameter("warn_or_error_max_leave")));
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",addedById);
			tabdata.put("modified_date",added_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",addedAtWorkstation );
			tabdata.put("DIS_DATE_CHK_DAYS_UNIT",checkForNull(req.getParameter("diag_update_period_max_unit")));
			tabdata.put("DFLT_PRIORITY_FOR_TFR_REQ",priority_code);
			//tabdata.put("EXT_INTERFACE_FOR_PRIVILEGE_YN",checkForNull(req.getParameter("ext_interface_for_priviledge_yn"),"N"));
			tabdata.put("MULTI_BOOK_PAT_YN",checkForNull(req.getParameter("multi_book_pat_yn"),"N"));
			tabdata.put("REL_BOOKED_BED_YN",checkForNull(req.getParameter("rel_booked_bed_yn"),"N"));//Added for PMG2016-CRF-0002 IN061508 on 23rd Aug 16
			tabdata.put("block_bed_based_on",checkForNull(req.getParameter("block_bed_based_on"),"P"));
			tabdata.put("CAPTURE_FIN_DTLS_YN",checkForNull(req.getParameter("capture_fin_dtls_yn"),"N"));
			tabdata.put("RESERVE_BED_ON_TFR_YN",checkForNull(req.getParameter("reserve_bed_on_tfr_yn"),"N"));
			
			tabdata.put("CHK_PEN_WARD_RTN_BFR_DIS_ADV",checkForNull(req.getParameter("chk_pen_ward_rtn_bfr_dis_adv"),"N"));//Added by Thamizh selvi on 4th Nov 2016 against GHL-CRF-0412.2
			tabdata.put("chk_pen_sale_rtn_bfr_dis_adv",checkForNull(req.getParameter("chk_pen_sale_rtn_bfr_dis_adv"),"N"));//Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892]
			tabdata.put("dis_ot_pend_ord_yn",checkForNull(req.getParameter("dis_ot_pend_ord_yn"),"N"));
			tabdata.put("dis_adv_ot_pend_ord_yn",checkForNull(req.getParameter("dis_adv_ot_pend_ord_yn"),"N"));
			
			tabdata.put("auto_confirm_tfr_req_yn",checkForNull(req.getParameter("autoCnrmTfrReq"),"N"));//Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617

			tabdata.put("DISP_BED_CLS_CHANGE_AUTH_YN",checkForNull(req.getParameter("dispBedClsChange"),"N"));//Added by Thamizh selvi on 10th Nov 2017 for ML-MMOH-CRF-0866

			tabdata.put("VALIDATE_NATID_IP_ADMSN",checkForNull(req.getParameter("validate_natid_IP_admsn"),"N"));//Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
			
			tabdata.put("ENABLE_DISCH_DIAGNOSIS_YN",checkForNull(req.getParameter("enable_disch_diagnosis_yn"),"N")); //ADDED BY SUJI KEERTHI ON 24-MAR-2020 FOR MOHE-CRF-0014
			/*11/10/2008 3698	SRR20056-CRF-0228*/
			tabdata.put("allow_multiple_bed_for_resv_yn",checkForNull(req.getParameter("allow_multiple_bed_for_resv_yn"),"N"));

			tabdata.put("Allow_Invoke_Maintn_Dth_Reg_YN",checkForNull(req.getParameter("Allow_Invoke_Maintn_Dth_Reg_YN"),"N"));
			
			/*12/9/2008 3752	PMG20089-CRF-0047*/
			tabdata.put("INVOKE_ADM_FROM_NEWBORN_YN",checkForNull(req.getParameter("invk_admsn_frm_nwbrn_regYN"),"N"));
			
		/*18/11/2008 SCR 4020 FDPMG20089CRF0119IP */
			
					//Below code added by venkatesh on 09/November/2011 against the KDAH-CRF-0041 
				tabdata.put("chk_for_pen_orders_bfr_dis_adv",checkForNull(req.getParameter("chk_for_pen_orders_bfr_dis_adv"),"N"));
				tabdata.put("dis_adv_allow_yn",checkForNull(req.getParameter("radioYN"),"N"));
			
		// venkatesh KDAH-CRF-0041 END
		
		   /*Below Line Added for this CRF [JD-CRF-0006] by Senthil*/
		   tabdata.put("chk_for_pen_orders_bfr_dis",checkForNull(req.getParameter("chk_for_pen_orders_bfr_dis"),"N"));
		   tabdata.put("dis_allow_yn",checkForNull(req.getParameter("pending_discharge"),"N"));		
           /*End [JD-CRF-0006]*/
		   
		   tabdata.put("chk_dis_pat_BT_order_pend",checkForNull(req.getParameter("chk_dis_pat_BT_order_pend"),"N"));//Added by Shanmukh on 23rd-MAY-2018 for ML-MMOH-CRF-1135
		   tabdata.put("admission_type",checkForNull(req.getParameter("admission_type")));//Added by Shanmukh on 31st-JULY-2018 for ML-MMOH-CRF-0618
		   
			tabdata.put("ALLOW_BOOKING_WITHOUT_EDD_YN",checkForNull(req.getParameter("allow_booking_without_edd_yn"),"N"));
			tabdata.put("ALLOW_BOOKING_WITH_EDD_YN",checkForNull(req.getParameter("allow_booking_with_edd_yn"),"N"));

			tabdata.put("FUTURE_BOOKING_FOR_BOC_YN",checkForNull(req.getParameter("furure_booking_for_boc_yn"),"N"));
			tabdata.put("NO_OF_DAYS_BEFORE_FOR_BOC",checkForNull(req.getParameter("no_of_days_before_for_boc"),""));
			tabdata.put("CONSIDER_EDD_STOP_FOR_BOC_YN",checkForNull(req.getParameter("consider_edd_stop_for_boc_yn"),"N"));			
			tabdata.put("ACTION_FOR_BOC",checkForNull(req.getParameter("action_for_boc")));

			tabdata.put("FUTURE_BOOKING_FOR_BOU_YN",checkForNull(req.getParameter("furure_booking_for_bou_yn"),"N"));
			tabdata.put("NO_OF_DAYS_BEFORE_FOR_BOU",checkForNull(req.getParameter("no_of_days_before_for_bou"),""));
			tabdata.put("CONSIDER_EDD_STOP_FOR_BOU_YN",checkForNull(req.getParameter("consider_edd_stop_for_bou_yn"),"N"));			
			tabdata.put("ACTION_FOR_BOU",checkForNull(req.getParameter("action_for_bou")));


			tabdata.put("FUTURE_BOOKING_FOR_BNC_YN",checkForNull(req.getParameter("furure_booking_for_bnc_yn"),"N"));
			tabdata.put("NO_OF_DAYS_BEFORE_FOR_BNC",checkForNull(req.getParameter("no_of_days_before_for_bnc"),""));
			tabdata.put("CONSIDER_EDD_STOP_FOR_BNC_YN",checkForNull(req.getParameter("consider_edd_stop_for_bnc_yn"),"N"));			
			tabdata.put("ACTION_FOR_BNC",checkForNull(req.getParameter("action_for_bnc")));
			
			tabdata.put("FUTURE_BOOKING_FOR_BNU_YN",checkForNull(req.getParameter("furure_booking_for_bnu_yn"),"N"));
			tabdata.put("NO_OF_DAYS_BEFORE_FOR_BNU",checkForNull(req.getParameter("no_of_days_before_for_bnu"),""));
			tabdata.put("CONSIDER_EDD_STOP_FOR_BNU_YN",checkForNull(req.getParameter("consider_edd_stop_for_bnu_yn"),"N"));			
			tabdata.put("ACTION_FOR_BNU",checkForNull(req.getParameter("action_for_bnu")));
			
			
			tabdata.put("GRC_PRD_FOR_ASGN_BED_MARK_ARVL",checkForNull(req.getParameter("grc_prd_for_asgn_bed_mark_arvl")));
			tabdata.put("CHANGE_ADMISSION_DTLS",checkForNull(req.getParameter("change_admi")));
			tabdata.put("display_discharge_pat_list",checkForNull(req.getParameter("display_discharge_pat_list"),"A"));
		   // tabdata.put("CONSENT_TXT_DTLS",java.net.URLDecoder.decode(checkForNull(req.getParameter("consent_text_details"))).trim());
			tabdata.put("CONSENT_TXT_DTLS",checkForNull(req.getParameter("consent_text_details")));

			//Added for the CRF - Bru-HIMS-CRF-157
			tabdata.put("ALLOW_LATE_DISCHARGE_REASON",checkForNull(req.getParameter("allow_reason_for_late_discharge"),"N"));
			tabdata.put("TRANSFER_WO_DELINK_YN",checkForNull(req.getParameter("transfer_wo_delink_yn"),"N"));//Added for the CRF - HSA-CRF-0035
			tabdata.put("DFLT_PRACT_BEDSIDE_REFERRAL",default_ref_pract); //this line Added for this CRF Bru-HIMS-CRF-354
			tabdata.put("PRE_DISCH_APPL_YN",checkForNull(req.getParameter("pre_disch_appl_yn"),"N"));//Added for the CRF - KDAH-CRF-0104
			tabdata.put("REASON_MANDATORY_FOR_ADMN_YN",checkForNull(req.getParameter("reason_for_adm_reqd_yn"),"N"));//Added for MMS-QH-CRF-0144
			tabdata.put("allow_muti_bedside_review_yn",checkForNull(req.getParameter("allow_muti_bedside_review_yn"),"N"));//Added for  HSA-CRF-146.1
			tabdata.put("ca_record_referral_note_yn",checkForNull(req.getParameter("ca_record_referral_note_yn"),"N"));//Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362
			tabdata.put("allow_reg_referral_yn",checkForNull(req.getParameter("allow_reg_referral_yn"),"N"));//Added by Kamatchi S for MOHE-CRF-0154
			tabdata.put("WEIGHT_ON_ADMN_MANDATORY",checkForNull(req.getParameter("weight_on_admn_mandatory")));//Added by Dharma on Oct 17th against HSA-CRF-0181 [IN:049541]
			tabdata.put("res_reserve_bed_intraward_yn",checkForNull(req.getParameter("res_reserve_bed_intraward_yn"),"N"));//Added by Maheshwaran K for GHL-CRF-340
			tabdata.put("res_reserve_bed_intraward_yn",checkForNull(req.getParameter("res_reserve_bed_intraward_yn"),"N"));
			//Added for this CRF ML-MMOH-CRF-0688
			tabdata.put("ALLOW_USER_MODIFY_DISC_YN",checkForNull(req.getParameter("allow_user_modify_disc_type_status_yn"),"N"));  // added by mujafar for ML-MMOH-CRF-0659
			tabdata.put("trans_yn_unfnzed_newborn",checkForNull(req.getParameter("trans_yn_unfnzed_newborn"),"N")); //Added by Dharma on 23rd May 2018 against ML-MMOH-CRF-0898 [IN:064757]
			tabdata.put("HEIGHT_ON_ADMN_MANDATORY",checkForNull(req.getParameter("height_on_admn_mandatory")));
			tabdata.put("ENABLE_HEIGHT_BMI_PAT_CLS",checkForNull(req.getParameter("enable_height_bmi_pat_cls")));
			
			String dupflds[]={"facility_id"};

			String table_name	= "ip_param";
			boolean local_ejbs	= false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home   = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = table_name;
            
			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = table_name.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
			{
			error_value = "1" ;
			//Enhancements required
			/*if(setup_bl_dtls_in_ip_yn.equals("Y"))
			{
				HashMap tabdata_bl=new HashMap();

				tabdata_bl.put("facility_id",facilityId);
				tabdata_bl.put("outst_amt_limit",new Integer(Integer.parseInt(outst_amt_limit)));
				tabdata_bl.put("policy_expiry_warning_period",new Integer(Integer.parseInt(policy_expiry_warning_period)));
				tabdata_bl.put("credit_auth_reqd_yn",credit_auth_reqd_yn);
				tabdata_bl.put("added_by_id",addedById);
				tabdata_bl.put("added_date",added_date);
				tabdata_bl.put("added_facility_id", facilityId);
				tabdata_bl.put("added_at_ws_no",addedAtWorkstation);
				tabdata_bl.put("modified_by_id",addedById);
				tabdata_bl.put("modified_date",added_date);
				tabdata_bl.put("modified_facility_id",modifiedFacilityId);
				tabdata_bl.put("modified_at_ws_no",addedAtWorkstation );
				tabdata_bl.put("DFLT_PRIORITY_FOR_TFR_REQ",priority_code);

				table_name = "bl_ip_param";
				argArray[0] = p;
				argArray[1] = tabdata_bl;
				argArray[2] = dupflds;
				argArray[3] = table_name;

				paramArray[0] = p.getClass();
				paramArray[1] = tabdata_bl.getClass();
				paramArray[2] = dupflds.getClass();
				paramArray[3] = table_name.getClass();

				java.util.HashMap results2= (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			}*/

				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{
				error = (String) results.get("error") ;
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}

			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );

			error = (String) results.get("error") ;
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		
		tabdata.clear();
		results.clear();

		}catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

	//////////////////////////// M O D I F Y ///////////////////////////////////
	private void modifyIPParam(HttpServletRequest req, HttpServletResponse res)
	{
//		Connection con = null;
		try	
		{
//			con = ConnectionManager.getConnection(req);
            
			
			
			String facility_id = checkForNull(req.getParameter("facility_id"));
			String setup_bl_dtls_in_ip_yn = checkForNull(req.getParameter("setup_bl_dtls_in_ip_yn"),"N");
			String priority_code = checkForNull(req.getParameter("priority"));
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedFacilityId=facilityId;
			String addedAtWorkstation=client_ip_address;
			
			String default_ref_pract=checkForNull(req.getParameter("default_ref_pract")); //this line Added for this CRF Bru-HIMS-CRF-354
			

			Timestamp added_date = new Timestamp(System.currentTimeMillis() );

			HashMap tabdata=new HashMap();
			tabdata.put("REVOKE_DEATH_DISP_TYPE", checkForNull(req.getParameter("DISP_TYPE_FOR_REVOKE_DEATH"))); // added by mujafar  for ML-MMOH-CRF-1427
			tabdata.put("bed_block_period_normal", checkForNull(req.getParameter("bed_block_period_normal"),"0"));
			tabdata.put("MAX_ALLOWED_ACCOM_PERS", checkForNull(req.getParameter("MAX_ALLOWED_ACCOM_PERS"),"0"));
			tabdata.put("CHK_IN_LODGER_MAX_PERIOD", checkForNull(req.getParameter("chk_in_lodger_max_period"),"0"));
			tabdata.put("PAT_CHECK_IN_ALLOWED_YN", checkForNull(req.getParameter("PCIAY"),"N"));
			tabdata.put("DEACTIVATE_PSEUDO_BED_YN", checkForNull(req.getParameter("DPBY"),"N"));
			tabdata.put("ALLOW_GATE_PASS_PRE_DIS_ADV_YN", checkForNull(req.getParameter("AGPDA"),"N")); // ADDED by mujafar for MO-CRF-20157
			tabdata.put("change_bed_class_yn", checkForNull(req.getParameter("cbcy"),"N"));
			tabdata.put("discharge_checklist_app_yn", checkForNull(req.getParameter("dcay"),"N"));
			tabdata.put("NO_SHOW_GRACE_PERIOD", checkForNull(req.getParameter("NO_SHOW_GRACE_PERIOD"),"0"));
			tabdata.put("ABSCOND_GRACE_PERIOD", checkForNull(req.getParameter("ABSCOND_GRACE_PERIOD"),"0"));
			tabdata.put("bed_block_period_dis",checkForNull(req.getParameter("bed_block_period_dis"),"0"));
			tabdata.put("bed_block_period_max",checkForNull(req.getParameter("bed_block_period_max"),"0"));
			tabdata.put("DFLT_GATE_PASS_PERIOD",checkForNull(req.getParameter("allwbl_pd_rnw_gtpass"),"0"));
			tabdata.put("disc_chklst_exp_period",checkForNull(req.getParameter("disc_chklst_exp_period"),"0"));
			tabdata.put("adv_bed_book_period_bkg",checkForNull(req.getParameter("adv_bed_book_period_bkg"),"0"));
			tabdata.put("allowed_admission_type", checkForNull(req.getParameter("allowed_admission_type"),"R"));
			tabdata.put("chk_booking_limit_by",checkForNull(req.getParameter("chk_booking_limit_by")));
			tabdata.put("adm_date_chk_days",checkForNull(req.getParameter("adm_date_chk_days"),"0"));
			tabdata.put("allowed_booking_type",checkForNull(req.getParameter("allowed_booking_type")));
			tabdata.put("dis_date_chk_days ",checkForNull(req.getParameter("dis_date_chk_days"),"0"));
			/*Below line(s) was added by venkatesh.S (4008) on 30/10/2012 against  Bru-HIMS-CRF-155 [IN030274] */
			tabdata.put("MAX_HRS_FOR_RE_ADMN",checkForNull(req.getParameter("chk_for_readmission"),"0"));
			/*Below line(s) was added by venkatesh.S (4008) on 30/10/2012 against  Bru-HIMS-CRF-155 [IN030274] */
			tabdata.put("lodger_bill_type_code",checkForNull(req.getParameter("lodger_bill_type_code ")));
			tabdata.put("lodger_blng_serv_code",checkForNull(req.getParameter("lodger_blng_serv_code")));
			tabdata.put("lodger_bill_at_checkout_yn",checkForNull(req.getParameter("lodger_bill_at_checkout_yn")));
			tabdata.put("general_consent_text",checkForNull(req.getParameter("general_consent_text")));
			tabdata.put("disclosure_consent_text",checkForNull(req.getParameter("disclosure_consent_text ")));
			//tabdata.put("start_admit_screen",checkForNull(req.getParameter("start_admit_screen")));
			tabdata.put("lodger_next_srl_no",checkForNull(req.getParameter("lodger_next_srl_no"),"0"));
			tabdata.put("lodger_max_srl_no",checkForNull(req.getParameter("lodger_max_srl_no"),"0"));
			tabdata.put("allow_release_bed_on_lv",checkForNull(req.getParameter("allow_release_bed_on_lv"),"N"));
			tabdata.put("max_allowed_lv_period",checkForNull(req.getParameter("max_allowed_lv_period"),"0"));
			tabdata.put("max_allowed_lv_cancel_period",checkForNull(req.getParameter("max_allowed_lv_cancel_period"),"0"));
			tabdata.put("vital_signs_battery_id",checkForNull(req.getParameter("vital_signs_battery_id")));
			tabdata.put("bl_interfaced_yn",checkForNull(req.getParameter("bl_interfaced_yn"),"N"));
			tabdata.put("setup_bl_dtls_in_ip_yn",setup_bl_dtls_in_ip_yn);

			String bkg_grace_period = checkForNull(req.getParameter("bkg_grace_period"),"0");
			if(bkg_grace_period.equals("") || bkg_grace_period == null)
				bkg_grace_period = "0";

			tabdata.put("bkg_grace_period", bkg_grace_period);
			tabdata.put("unregistered_patients_bkg_yn",checkForNull(req.getParameter("unregistered_patients_bkg_yn"),"N"));
			tabdata.put("PRIORITY_APPLICABLE_YN",checkForNull(req.getParameter("priority_appl_yn"),"N"));
			tabdata.put("MAX_DISCH_PERIOD_FOR_DC",checkForNull(req.getParameter("MAX_DISCH_PERIOD_FOR_DC"),"0"));
			tabdata.put("NOSHOW_BKNG_PERIOD",checkForNull(req.getParameter("NOSHOW_BKNG_PERIOD"),"0"));//Added  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
			tabdata.put("warn_or_error_max_leave",checkForNull(req.getParameter("warn_or_error_max_leave")));
			tabdata.put("modified_by_id",addedById);
			tabdata.put("modified_date",added_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",addedAtWorkstation );
			tabdata.put("dis_date_chk_days_unit",checkForNull(req.getParameter("diag_update_period_max_unit")));	

			tabdata.put("adm_date_chk_days_type",checkForNull(req.getParameter("adm_date_chk_days_type")));
			tabdata.put("bed_block_period_max_type",checkForNull(req.getParameter("bed_block_period_max_type")));
			tabdata.put("DFLT_GATE_PASS_UNIT",checkForNull(req.getParameter("bed_block_period_max_type1")));
			tabdata.put("disc_chklst_exp_per_unit",checkForNull(req.getParameter("disc_chklst_exp_per_unit"),"H"));
			tabdata.put("dflt_priority_for_bed_booking",checkForNull(req.getParameter("dflt_priority_for_bed_booking")));
			// transfer_out column changed to DFLT_BLK_PRD_FOR_TFR_OUT on 19th Aug 2003
			tabdata.put("DFLT_BLK_PRD_FOR_TFR_OUT",checkForNull(req.getParameter("transfer_out"),"0"));
			tabdata.put("dflt_bed_blocking_period",checkForNull(req.getParameter("dflt_bed_blocking_period"),"0"));
			// pat_type_override_leave_period column changed to ALLOW_PAT_TYPE_FOR_LEAVE on 19th Aug 2003
			tabdata.put("ALLOW_PAT_TYPE_FOR_LEAVE",checkForNull(req.getParameter("pat_type_override_leave_period")));
			tabdata.put("max_stay_of_lodger_after_disc",checkForNull(req.getParameter("max_stay_of_lodger_after_disc"),"0"));
			tabdata.put("DFLT_PRIORITY_FOR_TFR_REQ",priority_code);
			//tabdata.put("EXT_INTERFACE_FOR_PRIVILEGE_YN",checkForNull(req.getParameter("ext_interface_for_priviledge_yn"),"N"));
			tabdata.put("MULTI_BOOK_PAT_YN",checkForNull(req.getParameter("multi_book_pat_yn"),"N"));
			tabdata.put("REL_BOOKED_BED_YN",checkForNull(req.getParameter("rel_booked_bed_yn"),"N"));//Added  for PMG2016-CRF-0002 IN061508 on 23rd Aug 16
			tabdata.put("block_bed_based_on",checkForNull(req.getParameter("block_bed_based_on"),"N"));
			tabdata.put("capture_fin_dtls_yn",checkForNull(req.getParameter("capture_fin_dtls_yn"),"N"));
			tabdata.put("RESERVE_BED_ON_TFR_YN",checkForNull(req.getParameter("reserve_bed_on_tfr_yn"),"N"));
			
			tabdata.put("CHK_PEN_WARD_RTN_BFR_DIS_ADV",checkForNull(req.getParameter("chk_pen_ward_rtn_bfr_dis_adv"),"N"));//Added by Thamizh selvi on 4th Nov 2016 against GHL-CRF-0412.2
			tabdata.put("chk_pen_sale_rtn_bfr_dis_adv",checkForNull(req.getParameter("chk_pen_sale_rtn_bfr_dis_adv"),"N"));//Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892]

			tabdata.put("dis_ot_pend_ord_yn",checkForNull(req.getParameter("dis_ot_pend_ord_yn"),"N"));
			tabdata.put("dis_adv_ot_pend_ord_yn",checkForNull(req.getParameter("dis_adv_ot_pend_ord_yn"),"N"));

			tabdata.put("auto_confirm_tfr_req_yn",checkForNull(req.getParameter("autoCnrmTfrReq"),"N"));//Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617

			tabdata.put("DISP_BED_CLS_CHANGE_AUTH_YN",checkForNull(req.getParameter("dispBedClsChange"),"N"));//Added by Thamizh selvi on 10th Nov 2017 for ML-MMOH-CRF-0866

			tabdata.put("VALIDATE_NATID_IP_ADMSN",checkForNull(req.getParameter("validate_natid_IP_admsn"),"N"));//Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
			
			tabdata.put("ENABLE_DISCH_DIAGNOSIS_YN",checkForNull(req.getParameter("enable_disch_diagnosis_yn"),"N")); //ADDED BY SUJI KEERTHI ON 24-MAR-2020 FOR MOHE-CRF-0014
			/*11/10/2008 3698	SRR20056-CRF-0228*/
			tabdata.put("allow_multiple_bed_for_resv_yn",checkForNull(req.getParameter("allow_multiple_bed_for_resv_yn"),"N"));
			tabdata.put("Allow_Invoke_Maintn_Dth_Reg_YN",checkForNull(req.getParameter("Allow_Invoke_Maintn_Dth_Reg_YN"),"N"));
					//Below code added by venkatesh on 09/November/2011 against the KDAH-CRF-0041
		 tabdata.put("chk_for_pen_orders_bfr_dis_adv",checkForNull(req.getParameter("chk_for_pen_orders_bfr_dis_adv"),"N"));
		tabdata.put("dis_adv_allow_yn",checkForNull(req.getParameter("radioYN"),"N"));
		 /* CheckStyle Violation Commented by Munisekhar */ 
	    //String testing=req.getParameter("chk_for_pen_orders_bfr_dis_adv"); 
			
			
// venkatesh KDAH-CRF-0041 END

           /*Below Line Added for this CRF [JD-CRF-0006] by Senthil*/
		   tabdata.put("chk_for_pen_orders_bfr_dis",checkForNull(req.getParameter("chk_for_pen_orders_bfr_dis"),"N"));
		   tabdata.put("dis_allow_yn",checkForNull(req.getParameter("pending_discharge"),"N"));	          		   
           /*End [JD-CRF-0006]*/
           tabdata.put("chk_dis_pat_BT_order_pend",checkForNull(req.getParameter("chk_dis_pat_BT_order_pend"),"N"));//Added by Shanmukh on 23rd-MAY-2018 for ML-MMOH-CRF-1135
		   tabdata.put("admission_type",checkForNull(req.getParameter("admission_type")));//Added by Shanmukh on 31st-JULY-2018 for ML-MMOH-CRF-0618

			/*12/9/2008 3752	PMG20089-CRF-0047*/
			tabdata.put("INVOKE_ADM_FROM_NEWBORN_YN",checkForNull(req.getParameter("invk_admsn_frm_nwbrn_regYN"),"N"));
			

			/*18/11/2008 SCR 4020 FDPMG20089CRF0119IP By Sarita Dugge */
			
			
			tabdata.put("ALLOW_BOOKING_WITHOUT_EDD_YN",checkForNull(req.getParameter("allow_booking_without_edd_yn"),"N"));
			tabdata.put("ALLOW_BOOKING_WITH_EDD_YN",checkForNull(req.getParameter("allow_booking_with_edd_yn"),"N"));


			tabdata.put("FUTURE_BOOKING_FOR_BOC_YN",checkForNull(req.getParameter("future_booking_for_boc_yn"),"N"));
			tabdata.put("NO_OF_DAYS_BEFORE_FOR_BOC",checkForNull(req.getParameter("no_of_days_before_for_boc"),""));
			tabdata.put("CONSIDER_EDD_STOP_FOR_BOC_YN",checkForNull(req.getParameter("consider_edd_stop_for_boc_yn"),"N"));			
			tabdata.put("ACTION_FOR_BOC",checkForNull(req.getParameter("action_for_boc")));

			tabdata.put("FUTURE_BOOKING_FOR_BOU_YN",checkForNull(req.getParameter("future_booking_for_bou_yn"),"N"));
			tabdata.put("NO_OF_DAYS_BEFORE_FOR_BOU",checkForNull(req.getParameter("no_of_days_before_for_bou"),""));
			tabdata.put("CONSIDER_EDD_STOP_FOR_BOU_YN",checkForNull(req.getParameter("consider_edd_stop_for_bou_yn"),"N"));			
			tabdata.put("ACTION_FOR_BOU",checkForNull(req.getParameter("action_for_bou")));


			tabdata.put("FUTURE_BOOKING_FOR_BNC_YN",checkForNull(req.getParameter("future_booking_for_bnc_yn"),"N"));
			tabdata.put("NO_OF_DAYS_BEFORE_FOR_BNC",checkForNull(req.getParameter("no_of_days_before_for_bnc"),""));
			tabdata.put("CONSIDER_EDD_STOP_FOR_BNC_YN",checkForNull(req.getParameter("consider_edd_stop_for_bnc_yn"),"N"));			
			tabdata.put("ACTION_FOR_BNC",checkForNull(req.getParameter("action_for_bnc")));
			
			tabdata.put("FUTURE_BOOKING_FOR_BNU_YN",checkForNull(req.getParameter("future_booking_for_bnu_yn"),"N"));
			tabdata.put("NO_OF_DAYS_BEFORE_FOR_BNU",checkForNull(req.getParameter("no_of_days_before_for_bnu"),""));
			tabdata.put("CONSIDER_EDD_STOP_FOR_BNU_YN",checkForNull(req.getParameter("consider_edd_stop_for_bnu_yn"),"N"));			
			tabdata.put("ACTION_FOR_BNU",checkForNull(req.getParameter("action_for_bnu")));

			tabdata.put("GRC_PRD_FOR_ASGN_BED_MARK_ARVL",checkForNull(req.getParameter("grc_prd_for_asgn_bed_mark_arvl")));

			tabdata.put("CHANGE_ADMISSION_DTLS",checkForNull(req.getParameter("change_admi")));
			tabdata.put("display_discharge_pat_list",checkForNull(req.getParameter("display_discharge_pat_list"),"A"));
           // tabdata.put("CONSENT_TXT_DTLS",java.net.URLDecoder.decode(checkForNull(req.getParameter("consent_text_details"))).trim());
			tabdata.put("CONSENT_TXT_DTLS",checkForNull(req.getParameter("consent_text_details")));			

			//Added for the CRF - Bru-HIMS-CRF-157
			tabdata.put("ALLOW_LATE_DISCHARGE_REASON",checkForNull(req.getParameter("allow_reason_for_late_discharge"),"N"));
			tabdata.put("DISCH_REASON_MAND_YN",checkForNull(req.getParameter("mandatoryYN"),"N"));
			
			tabdata.put("DFLT_PRACT_BEDSIDE_REFERRAL",default_ref_pract); //this line Added for this CRF Bru-HIMS-CRF-354
			tabdata.put("TRANSFER_WO_DELINK_YN",checkForNull(req.getParameter("transfer_wo_delink_yn"),"N"));//Added for the CRF - HSA-CRF-0035
			tabdata.put("PRE_DISCH_APPL_YN",checkForNull(req.getParameter("pre_disch_appl_yn"),"N"));//Added for the CRF - KDAH-CRF-0104
			tabdata.put("REASON_MANDATORY_FOR_ADMN_YN",checkForNull(req.getParameter("reason_for_adm_reqd_yn"),"N"));//Added for MMS-QH-CRF-0144
			tabdata.put("allow_muti_bedside_review_yn",checkForNull(req.getParameter("allow_muti_bedside_review_yn"),"N"));//Added for  HSA-CRF-146.1
			tabdata.put("ca_record_referral_note_yn",checkForNull(req.getParameter("ca_record_referral_note_yn"),"N")); //Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362
			tabdata.put("allow_reg_referral_yn",checkForNull(req.getParameter("allow_reg_referral_yn"),"N"));//Added by Kamatchi S for MOHE-CRF-0154
			tabdata.put("WEIGHT_ON_ADMN_MANDATORY",checkForNull(req.getParameter("weight_on_admn_mandatory")));//Added by Dharma on Oct 17th against HSA-CRF-0181 [IN:049541]
			tabdata.put("res_reserve_bed_intraward_yn",checkForNull(req.getParameter("res_reserve_bed_intraward_yn"),"N"));//Added by Maheshwaran K for GHL-CRF-340
			tabdata.put("ALLOW_USER_MODIFY_DISC_YN",checkForNull(req.getParameter("allow_user_modify_disc_type_status_yn"),"N"));  // added by mujafar for ML-MMOH-CRF-0659
			tabdata.put("trans_yn_unfnzed_newborn",checkForNull(req.getParameter("trans_yn_unfnzed_newborn"),"N")); //Added by Dharma on 23rd May 2018 against ML-MMOH-CRF-0898 [IN:064757]
			tabdata.put("HEIGHT_ON_ADMN_MANDATORY",checkForNull(req.getParameter("height_on_admn_mandatory")));
			tabdata.put("ENABLE_HEIGHT_BMI_PAT_CLS",checkForNull(req.getParameter("enable_height_bmi_pat_cls")));
			
			//Added for this CRF ML-MMOH-CRF-0688
			tabdata.put("death_register_mandatory_yn",checkForNull(req.getParameter("invdeathregmandatoryYN"),"N")); 
			
			HashMap condflds=new HashMap();
			condflds.put("facility_id",facility_id);

			String table_name			= "ip_param";
			boolean local_ejbs	= false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home   = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = table_name;
            
			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = table_name.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue());

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
			{
				error_value = "1" ;
				//out.println("inside 2 table");
				//Enhancements required.
				/*if(setup_bl_dtls_in_ip_yn.equals("Y"))
				{
					HashMap tabdata_bl=new HashMap();
					ResultSet rs	= null;
					Statement stmt	= null;
					stmt=con.createStatement();

					try
					{
						String sql = "select * from bl_ip_param where facility_id='"+facility_id+"'";
						out.println("inside try");
						rs=stmt.executeQuery(sql);
						if(rs!=null )
						{
							if(rs.next())
							{
								tabdata_bl.put("outst_amt_limit",new Integer(Integer.parseInt(outst_amt_limit)));
								tabdata_bl.put("policy_expiry_warning_period",new Integer(Integer.parseInt(policy_expiry_warning_period)));
								tabdata_bl.put("credit_auth_reqd_yn",credit_auth_reqd_yn);
								tabdata_bl.put("modified_by_id",addedById);
								tabdata_bl.put("modified_date",added_date);
								tabdata_bl.put("modified_facility_id",modifiedFacilityId);
								tabdata_bl.put("modified_at_ws_no",addedAtWorkstation );
								table_name = "bl_ip_param";

								argArray[0] = p;
								argArray[1] = tabdata_bl;
								argArray[2] = condflds;
								argArray[3] = table_name;

								paramArray[0] = p.getClass();
								paramArray[1] = tabdata_bl.getClass();
								paramArray[2] = condflds.getClass();
								paramArray[3] = table_name.getClass();

								java.util.HashMap results1 = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
								(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
							}
							else
							{
								tabdata_bl.put("facility_id",facilityId);
								tabdata_bl.put("outst_amt_limit",new Integer(Integer.parseInt(outst_amt_limit)));
								tabdata_bl.put("policy_expiry_warning_period",new Integer(Integer.parseInt(policy_expiry_warning_period)));
								tabdata_bl.put("credit_auth_reqd_yn",credit_auth_reqd_yn);
								tabdata_bl.put("added_by_id",addedById);
								tabdata_bl.put("added_date",added_date);
								tabdata_bl.put("added_facility_id", facilityId);
								tabdata_bl.put("added_at_ws_no",addedAtWorkstation);
								tabdata_bl.put("modified_by_id",addedById);
								tabdata_bl.put("modified_date",added_date);
								tabdata_bl.put("modified_facility_id",modifiedFacilityId);
								tabdata_bl.put("modified_at_ws_no",addedAtWorkstation );

								String dupflds[]={"facility_id"};
								out.println(facilityId);
								table_name = "bl_ip_param";
								argArray[0] = p;
								argArray[1] = tabdata_bl;
								argArray[2] = dupflds;
								argArray[3] = table_name;

								paramArray[0] = p.getClass();
								paramArray[1] = tabdata_bl.getClass();
								paramArray[2] = dupflds.getClass();
								paramArray[3] = table_name.getClass();

								java.util.HashMap results2 = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
								(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
							}
						}
					}catch(Exception e)
					{
						out.print(e);
					}
					finally
					{
						if(stmt!=null)		stmt.close();
						if(rs!=null)		rs.close();
					}
				}*/
			}
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );

		tabdata.clear();
		results.clear();
		condflds.clear();

		}catch ( Exception e )
		{
			e.printStackTrace();
			
		}
		finally
		{
//			ConnectionManager.returnConnection(con,req);
		}
	}

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}
