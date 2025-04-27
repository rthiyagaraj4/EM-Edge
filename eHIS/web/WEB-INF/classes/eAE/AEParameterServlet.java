/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* ***
   *** This Servlet is used for Parameter Setup
   *** */
package eAE;

import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;

import eCommon.SingleTabHandler.*;

public class AEParameterServlet extends HttpServlet implements SingleThreadModel{
	PrintWriter out;
	String facilityId;
	HttpSession session;
	Properties p;
	String client_ip_address;

	boolean inserted		= false;
	String mode;
	String  order_cat_code1;
	String  order_cat_code2;
	String  order_cat_code3;
	String  order_cat_code4;
	String  order_cat_code5;
	String billing_interfaced_yn;
	String visit_backdating_allowed_yn;
	String max_hours_allow_insert;
	String max_days_allow_update;
	String min_age_for_preg_dtl;
	String max_age_for_paed_dtl;
	String min_age_for_lmp;
	String cutoff_hours_prv_day_visit;
	String respiratory;
	String systolicBP;
	String queue_refresh_intervel;
	String record_vital_signs;
	String reg_attendance_for_inpat_yn;
	String invoke_recall_for_AE; //Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657
	String reconfirm_case_of_trauma; //Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
	String disp_type_for_revoke_death; // added by mujafar for ML-MMOH-CRF-1427
	String Rec_diag_not_mdt_BID; //Added by Ashwini on 10-Jan-2017 for ML-MMOH-CRF-0624
	String Rec_diag_not_mdt_absconded; //Added by Ashwini on 10-Jan-2017 for ML-MMOH-CRF-0630
	String enable_accs_rights_in_queue;
	String clinic_code					= "";
	String isAERegisterTypeAutoUpdateAppl = ""; // added by mujafar for KDAH-CRF-0526
	
	String dfltRegAutoUpdateTime="";
	String dfltEmerFollowTypeCode="";

	
	String service_code					= "";
	String visit_type					= "";
	String priority_zone_area			= "";
	String unknown_adult_age_for_dis_regn	= "";
	String allow_chkout_with_bill_stmt_yn   = "";
	String inv_reg_new_born_yn   = "";  //Added by Mani
	String validate_natid_reg_attn; //Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
	
	String action_on_pending_bill			= "";  // Added for MMS-QH-CRF-0126.2 [IN:042931]
	/*Added by Thamizh selvi on 16th Oct 2017 for ML-MMOH-CRF-0623 Start*/
	String backDateConsAllowedYn		= ""; 
	String backDateConsAllowedHrs		= "";
	/*End*/
    String nursing_unit;
   	String observation_ward_type		= "";
   	String nursing_clinic_code		= "";
// below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]

String max_hrs_for_re_attend;

//end CRF  Bru-HIMS-CRF-152 [IN030272]

String five_level_triage_appl_yn="";//this line added for this CRF MMS-QH-CRF-0146 [IN:043836]

String dist_pat_ser_grp=""; //Added for this CRF ML-MMOH-CRF-0466

String re_attendace_within_hour="";//Added fro this CRF ML-MMOH-CRF-0639
String Rec_diag_not_mdt_DID_yn="";       //Added by Mano aganist ML-MMOH-CRF-0783
String Rec_diag_mdt_CALLNOTAROUND_yn=""; //Added by Mano aganist ML-MMOH-CRF-0783
	
	/*Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start*/
	String  orderCatalogCode6		= "";
	String  initialMgmtLbl			= "";
	String  CompressionDressngLbl	= "";
	/*End*/
	/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start*/
	String chk_for_pen_orders_bfr_chk	= "N";
	String checkout_allow_yn			= "N";
	/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End*/
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	
	String enable_admission_tab="N"; // <!--Added by Himanshu Saxena on 14-Jun-2023 for ML-MMOH-CRF-1972 Starts-->

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		this.out = res.getWriter();
		try	{   
			session 					= req.getSession(true);
			this.facilityId = (String) session.getValue( "facility_id" ) ;
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.client_ip_address = p.getProperty("client_ip_address");
			billing_interfaced_yn 		=  req.getParameter("billing_interfaced_yn");
			if(billing_interfaced_yn==null || billing_interfaced_yn.equals("") || billing_interfaced_yn=="")
			billing_interfaced_yn		= "N";
			allow_chkout_with_bill_stmt_yn =  req.getParameter("allow_chkout_with_bill_stmt_yn");
			if(allow_chkout_with_bill_stmt_yn==null || allow_chkout_with_bill_stmt_yn.equals("") || allow_chkout_with_bill_stmt_yn=="")
			allow_chkout_with_bill_stmt_yn	= "N";
		
		//Added By Mani
		inv_reg_new_born_yn =  req.getParameter("inv_reg_new_born_yn");
			if(inv_reg_new_born_yn==null || inv_reg_new_born_yn.equals("") || inv_reg_new_born_yn=="")
			inv_reg_new_born_yn	= "N";
		
			/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start*/
			chk_for_pen_orders_bfr_chk	= req.getParameter("chk_for_pen_orders_bfr_chk");
			if(chk_for_pen_orders_bfr_chk==null || chk_for_pen_orders_bfr_chk.equals("") || chk_for_pen_orders_bfr_chk=="")
			chk_for_pen_orders_bfr_chk	= "N";
		
			checkout_allow_yn	= req.getParameter("checkout_allow_yn");
			if(checkout_allow_yn==null || checkout_allow_yn.equals("") || checkout_allow_yn=="")
			checkout_allow_yn	= "N";
			/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End*/
		
			//<!--Added by Himanshu Saxena on 14-Jun-2023 for ML-MMOH-CRF-1972 Starts-->
			enable_admission_tab=req.getParameter("enable_admission_tab");
			
			if(enable_admission_tab==null || enable_admission_tab.equals("") || enable_admission_tab=="")
			{
				enable_admission_tab	= "N";
			}
			//<!--Added by Himanshu Saxena on 14-Jun-2023 for ML-MMOH-CRF-1972 Ends-->
			
			visit_backdating_allowed_yn =  req.getParameter("visit_backdating_allowed_yn");
			if(visit_backdating_allowed_yn==null || visit_backdating_allowed_yn.equals("") || visit_backdating_allowed_yn=="")
			visit_backdating_allowed_yn	= "N";
			reg_attendance_for_inpat_yn =  req.getParameter("reg_attendance_for_inpat_yn");
			if(reg_attendance_for_inpat_yn==null || reg_attendance_for_inpat_yn.equals("") || reg_attendance_for_inpat_yn=="")
			reg_attendance_for_inpat_yn	= "N";
			
			//Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657
			invoke_recall_for_AE =  req.getParameter("invoke_recall_for_AE");
			if(invoke_recall_for_AE==null || invoke_recall_for_AE.equals("") || invoke_recall_for_AE=="")
			invoke_recall_for_AE	= "N";

			//Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
			reconfirm_case_of_trauma = req.getParameter("reconfirm_case_of_trauma");
			if(reconfirm_case_of_trauma==null || reconfirm_case_of_trauma.equals("") || reconfirm_case_of_trauma=="")
			reconfirm_case_of_trauma = "N";

		disp_type_for_revoke_death = checkNull(req.getParameter("DISP_TYPE_FOR_REVOKE_DEATH")); // added by mujfafar for ML-MMOH-CRF-1427
			validate_natid_reg_attn =  req.getParameter("validate_natid_reg_attn");
			if(validate_natid_reg_attn==null || validate_natid_reg_attn.equals("") || validate_natid_reg_attn=="")
			validate_natid_reg_attn	= "N";

			//Added by Ashwini on 10-Jan-2017 for ML-MMOH-CRF-0624
			Rec_diag_not_mdt_BID=req.getParameter("Rec_diag_not_mdt_BID");
			if(Rec_diag_not_mdt_BID==null || Rec_diag_not_mdt_BID.equals("") || Rec_diag_not_mdt_BID=="")
			Rec_diag_not_mdt_BID	= "N";
			
			//Added by Ashwini on 10-Jan-2017 for ML-MMOH-CRF-0630
			Rec_diag_not_mdt_absconded=req.getParameter("Rec_diag_not_mdt_absconded");
			if(Rec_diag_not_mdt_absconded==null || Rec_diag_not_mdt_absconded.equals("") || Rec_diag_not_mdt_absconded=="")
			Rec_diag_not_mdt_absconded	= "N";
		    
			//Added by Mano aganist ML-MMOH-CRF-0783
			Rec_diag_not_mdt_DID_yn=req.getParameter("Rec_diag_not_mdt_DID_yn");
			if(Rec_diag_not_mdt_DID_yn==null || Rec_diag_not_mdt_DID_yn.equals("") || Rec_diag_not_mdt_DID_yn=="")
			Rec_diag_not_mdt_DID_yn	= "N";
		
		    Rec_diag_mdt_CALLNOTAROUND_yn=req.getParameter("Rec_diag_mdt_CALLNOTAROUND_yn");
			if(Rec_diag_mdt_CALLNOTAROUND_yn==null || Rec_diag_mdt_CALLNOTAROUND_yn.equals("") || Rec_diag_mdt_CALLNOTAROUND_yn=="")
			Rec_diag_mdt_CALLNOTAROUND_yn = "N";
		    
			
			max_hours_allow_insert 		= req.getParameter("max_hours_allow_insert");
			max_hours_allow_insert 		= (max_hours_allow_insert == null)?"":max_hours_allow_insert;
			max_days_allow_update 		= req.getParameter("max_days_allow_update");
			max_days_allow_update 		= (max_days_allow_update == null)?"":max_days_allow_update;
			min_age_for_preg_dtl 		= req.getParameter("min_age_for_preg_dtl");
			min_age_for_preg_dtl 		= (min_age_for_preg_dtl == null)?"":min_age_for_preg_dtl;

			max_age_for_paed_dtl 		= req.getParameter("max_age_for_paed_dtl");
			max_age_for_paed_dtl 		= (max_age_for_paed_dtl == null)?"":max_age_for_paed_dtl;

			min_age_for_lmp 		= req.getParameter("min_age_for_lmp");
			min_age_for_lmp 		= (min_age_for_lmp == null)?"":min_age_for_lmp;

			clinic_code 		= req.getParameter("clinic_code");
			clinic_code 		= (clinic_code == null)?"":clinic_code;
			
			isAERegisterTypeAutoUpdateAppl = req.getParameter("isAERegisterTypeAutoUpdateAppl"); // added by mujafar for KDAH-CRF-0526
			isAERegisterTypeAutoUpdateAppl 		= (isAERegisterTypeAutoUpdateAppl == null)?"false":isAERegisterTypeAutoUpdateAppl;
			
			
			
			if(isAERegisterTypeAutoUpdateAppl.equals("true"))
			{
			dfltRegAutoUpdateTime  = req.getParameter("ae_reg_update_val");
			dfltRegAutoUpdateTime  		= (dfltRegAutoUpdateTime  == null)?"":dfltRegAutoUpdateTime;
			
			dfltEmerFollowTypeCode = req.getParameter("emerFollowSel");
			dfltEmerFollowTypeCode 		= (dfltEmerFollowTypeCode == null)?"":dfltEmerFollowTypeCode;
			}
			
			

			service_code 		= req.getParameter("service_code");
			service_code 		= (service_code == null)?"":service_code;

			visit_type 		= req.getParameter("visit_type");
			visit_type 		= (visit_type == null)?"":visit_type;

			priority_zone_area 		= req.getParameter("priority_zone_area");
			priority_zone_area 		= (priority_zone_area == null)?"":priority_zone_area;

			unknown_adult_age_for_dis_regn 		= req.getParameter("unknown_adult_age_for_dis_regn");
			unknown_adult_age_for_dis_regn 		= (unknown_adult_age_for_dis_regn == null)?"":unknown_adult_age_for_dis_regn;

			/*Added by Thamizh selvi on 16th Oct 2017 for ML-MMOH-CRF-0623 Start*/
			backDateConsAllowedYn = checkNullWithDftValue(req.getParameter("back_date_cons_yn"),"N");
			backDateConsAllowedHrs = checkNull(req.getParameter("back_date_cons_hrs")); 
			/*End*/
			nursing_unit 		= req.getParameter("nursing_unit");
			nursing_unit 		= (nursing_unit == null)?"":nursing_unit;

			nursing_clinic_code 		= req.getParameter("nursing_clinic_code");
			nursing_clinic_code 		= (nursing_clinic_code == null)?"":nursing_clinic_code;

			observation_ward_type = req.getParameter("observation_ward_type");
		    if((observation_ward_type==null) || (observation_ward_type.equals("null")) || (observation_ward_type=="") || (observation_ward_type.equals(""))) observation_ward_type	= "";



			cutoff_hours_prv_day_visit	= req.getParameter("cutoff_hours_prv_day_visit");
			cutoff_hours_prv_day_visit	= (cutoff_hours_prv_day_visit == null)?"":cutoff_hours_prv_day_visit;

			order_cat_code1		= req.getParameter("order_cat_code1");
			order_cat_code1						= (order_cat_code1 == null)?"":order_cat_code1;
			order_cat_code2		= req.getParameter("order_cat_code2");
			order_cat_code2					= (order_cat_code2== null)?"":order_cat_code2;
			order_cat_code3		= req.getParameter("order_cat_code3");
			order_cat_code3 						= (order_cat_code3 == null)?"":order_cat_code3;
			order_cat_code4		= req.getParameter("order_cat_code4");
			order_cat_code4					= (order_cat_code4 == null)?"":order_cat_code4;
			order_cat_code5		= req.getParameter("order_cat_code5");
			order_cat_code5 						= (order_cat_code5 == null)?"":order_cat_code5;
			
			/*Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start*/
			orderCatalogCode6		= checkNull(req.getParameter("order_cat_code6"));
			initialMgmtLbl			= checkNull(req.getParameter("initialMgmtLbl"));
			CompressionDressngLbl	= checkNull(req.getParameter("CompressionDressngLbl"));
			/*End*/

			systolicBP		= req.getParameter("systolicBPhdd");
			systolicBP 						= (systolicBP == null)?"":systolicBP;

			respiratory		= req.getParameter("respiratoryhdd");
			respiratory 						= (respiratory == null)?"":respiratory;
		   	queue_refresh_intervel 		= req.getParameter("queue_refresh_intervel");
			queue_refresh_intervel		= (queue_refresh_intervel == null)?"":queue_refresh_intervel;
			record_vital_signs 		= req.getParameter("record_vital_signs");
			record_vital_signs		= (record_vital_signs == null)?"N":record_vital_signs;
	        enable_accs_rights_in_queue		= req.getParameter("enable_accs_rights_in_queue");
	    	// below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
			max_hrs_for_re_attend   =req.getParameter("re_attendace_hour").trim();
			
             //end CRF  Bru-HIMS-CRF-152 [IN030272]
			//enable_accs_rights_in_queue		= (enable_accs_rights_in_queue  == null)?"N":enable_accs_rights_in_queue;
		    if(enable_accs_rights_in_queue==null || enable_accs_rights_in_queue.equals("") || enable_accs_rights_in_queue=="")
			enable_accs_rights_in_queue	= "N";
		    
		    // Added for MMS-QH-CRF-0126.2 [IN:042931] Start
		    
		    action_on_pending_bill 		= req.getParameter("action_on_pending_bill");
		    action_on_pending_bill		= (action_on_pending_bill == null)?"N":action_on_pending_bill;
		    
		    // Added for MMS-QH-CRF-0126.2 [IN:042931] End
			
			/*Below line added for this CRF MMS-QH-CRF-0146 [IN:043836]*/
			 five_level_triage_appl_yn		= req.getParameter("five_level_triage_appl_yn");
			 if(five_level_triage_appl_yn==null || five_level_triage_appl_yn.equals("") || five_level_triage_appl_yn=="")
			 five_level_triage_appl_yn	= "N";
			 
			 //Belwo line added for this CRF ML-MMOH-CRF-0466
			 dist_pat_ser_grp = req.getParameter("dist_pat_ser_grp");
			 dist_pat_ser_grp = (dist_pat_ser_grp == null)?"":dist_pat_ser_grp;
			 
			 //Added fro this CRF ML-MMOH-CRF-0639
			 re_attendace_within_hour = req.getParameter("re_attendace_within_hour");
			 re_attendace_within_hour = (re_attendace_within_hour == null)?"":re_attendace_within_hour;
			 //End this CRF ML-MMOH-CRF-0639
			
			
			
			mode 						= req.getParameter("mode");
			mode 						= (mode == null)?"":mode;
			if(mode.equalsIgnoreCase("INSERT"))
			     insertParameter(res);
            else
			     modifyParameter(res);
		}catch(Exception e){
				e.printStackTrace();
			}
	}

 private void  insertParameter( HttpServletResponse res){
  try{
     	String addedById			= p.getProperty( "login_user" ) ;
    	String addedDate			= dateFormat.format( new java.util.Date() ) ;
		String modifiedById			= addedById ;
		String modifiedDate			= addedDate ;
		String addedFacilityId		= facilityId;
		String modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	= client_ip_address;
		String modifiedAtWorkstation= addedAtWorkstation ;
		java.sql.Date added_date1	= java.sql.Date.valueOf( addedDate ) ;
		java.sql.Date added_date	= new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;

		java.sql.Date modified_date1= java.sql.Date.valueOf(modifiedDate ) ;
	    java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ;

		HashMap tabdata=new HashMap();
				tabdata.put("OPERATING_FACILITY_ID",facilityId);
				tabdata.put("BILLING_INTERFACED_YN",billing_interfaced_yn);
				tabdata.put("allow_chkout_with_bill_stmt_yn",allow_chkout_with_bill_stmt_yn);
				tabdata.put("INV_REG_NEW_BORN_YN",inv_reg_new_born_yn);//Added By Mani
				/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start*/
				tabdata.put("CHK_FOR_PEN_ORDERS_BFR_CHKOUT",chk_for_pen_orders_bfr_chk);
				tabdata.put("CHECKOUT_ALLOW_YN",checkout_allow_yn);
				/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End*/
				
				tabdata.put("VISIT_BACKDATING_ALLOWED_YN",visit_backdating_allowed_yn);
				tabdata.put("MAX_HOURS_ALLOW_INSERT",max_hours_allow_insert);
				tabdata.put("REG_ATTENDANCE_FOR_INPAT_YN",reg_attendance_for_inpat_yn);
				tabdata.put("INVOKE_RECALL_FOR_AE",invoke_recall_for_AE); //Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657
				tabdata.put("RECONFIRM_CASE_OF_TRAUMA",reconfirm_case_of_trauma); //Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
				tabdata.put("REVOKE_DEATH_DISP_TYPE",disp_type_for_revoke_death); //Added by mujafar  for ML-MMOH-CRF-1427
				
				tabdata.put("REC_DIAG_NOT_MDT_BID",Rec_diag_not_mdt_BID); //Added by Ashwini on 10-Jan-2017 for ML-MMOH-CRF-0624
				tabdata.put("REC_DIAG_NOT_MDT_ABSCONDED",Rec_diag_not_mdt_absconded); //Added by Ashwini on 10-Jan-2017 for ML-MMOH-CRF-0630
				tabdata.put("MAX_DAYS_ALLOW_UPDATE",max_days_allow_update);
				tabdata.put("MIN_AGE_FOR_PREG_DTL",min_age_for_preg_dtl);
				tabdata.put("MAX_AGE_FOR_PAED_DTL",max_age_for_paed_dtl);
				tabdata.put("MIN_AGE_FOR_LMP",min_age_for_lmp);
				tabdata.put("DFLT_LOCN_CODE_FOR_DIS_REGN",clinic_code);
				tabdata.put("DFLT_SRVC_CODE_FOR_DIS_REGN",service_code);
				tabdata.put("DFLT_VIS_TYP_CDE_FOR_DIS_REGN",visit_type);
				tabdata.put("NURSING_UNIT_CODE",nursing_unit);
				tabdata.put("CLINIC_CODE",nursing_clinic_code);
				tabdata.put("CUTOFF_HOURS_PRV_DAY_VISIT",cutoff_hours_prv_day_visit);
				 tabdata.put("ORDER_CATALOG_CODE1",order_cat_code1);
				 tabdata.put("ORDER_CATALOG_CODE2",order_cat_code2);
				 tabdata.put("ORDER_CATALOG_CODE3",order_cat_code3);
				 tabdata.put("ORDER_CATALOG_CODE4",order_cat_code4);
				 tabdata.put("ORDER_CATALOG_CODE5",order_cat_code5);
				 tabdata.put("DISCR_MSR_ID1",systolicBP);
				 tabdata.put("DISCR_MSR_ID2",respiratory);
				 tabdata.put("VALIDATE_NATID_REG_ATTN",validate_natid_reg_attn); //Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
				
				/*Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start*/
				tabdata.put("ORDER_CATALOG_CODE6",orderCatalogCode6);
				tabdata.put("INITIAL_MGMT_LABEL_CONFIG",initialMgmtLbl);
				tabdata.put("DRESSING_LABEL_CONFIG",CompressionDressngLbl);
				/*End*/
				
				/*  KDAH-CRF-0526 */
				tabdata.put("DFLT_TIME_REG_AUTO_UPDATE",dfltRegAutoUpdateTime); // added by mujafar for KDAH-CRF-0526
				tabdata.put("DFLT_EMER_FOLLOW_TYPE_CODE",dfltEmerFollowTypeCode);
				/*  KDAH-CRF-0526 */

				tabdata.put("ADDED_BY_ID",addedById);
				tabdata.put("ADDED_DATE",added_date);
				tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
				tabdata.put("ADDED_FACILITY_ID", facilityId);
				tabdata.put("MODIFIED_BY_ID",modifiedById);
				tabdata.put("MODIFIED_DATE",modified_date);
				tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
				tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
				tabdata.put("QUEUE_REFRESH_INTERVAL",queue_refresh_intervel );
				tabdata.put("RECORD_VITAL_SIGNS_YN",record_vital_signs );
				tabdata.put("ENABLE_ACCS_RIGHTS_IN_QUEUE",enable_accs_rights_in_queue);
                tabdata.put("AE_OBSERVE_BATTERY_ID",observation_ward_type );
                tabdata.put("DFLT_PRY_ZONE_FOR_DIS_REGN",priority_zone_area );
                tabdata.put("DFLT_UN_ADULT_AGE_FOR_DIS_REGN",unknown_adult_age_for_dis_regn );
// below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
                tabdata.put("MAX_HRS_FOR_RE_ATTEND",max_hrs_for_re_attend);
//end CRF  Bru-HIMS-CRF-152 [IN030272]
                tabdata.put("ACTION_ON_PENDING_BILL",action_on_pending_bill);  // Added for MMS-QH-CRF-0126.2 [IN:042931]
				
				tabdata.put("FIVE_LEVEL_TRIAGE_APPL_YN",five_level_triage_appl_yn); //Added for this CRF MMS-QH-CRF-0146 [IN:043836]
				
				tabdata.put("DIST_PAT_SER_GRP",dist_pat_ser_grp);  //Added for this CRF ML-MMOH-CRF-0466
				
				tabdata.put("REG_ATTENDACE_WITHIN_HOUR",re_attendace_within_hour);  //Added for this CRF ML-MMOH-CRF-0369
				/*Added by Thamizh selvi on 16th Oct 2017 for ML-MMOH-CRF-0623 Start*/
				tabdata.put("backdate_cons_allowed_yn",backDateConsAllowedYn); 
				tabdata.put("backdate_cons_allowed_hrs",backDateConsAllowedHrs); 
				/*End*/
				tabdata.put("REC_DIAG_NOT_MDT_DID_YN",Rec_diag_not_mdt_DID_yn);            //Added by Mano aganist ML-MMOH-CRF-0783
				tabdata.put("REC_DIAG_MDT_CALLNOTAROUND_YN",Rec_diag_mdt_CALLNOTAROUND_yn);//Added by Mano aganist ML-MMOH-CRF-0783
				
				tabdata.put("ENABLE_ADMISSION_TAB",enable_admission_tab);//<!--Added by Himanshu Saxena on 14-Jun-2023 for ML-MMOH-CRF-1972-->
				
				
   			String dupflds[]={"OPERATING_FACILITY_ID"};
		try{

            boolean local_ejbs = false;
			String tablename ="AE_PARAM";

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = tablename;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = tablename.getClass();


			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;
	    		   if ( inserted )
				   {
					    error_value= "1";
		     			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
	        	   }
		     	   else
		     	   {
						res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
		     	   }
			  results.clear();
			  tabdata.clear();
		     }catch(Exception e)
                {
	              //out.println("From Servlet--Calling EJB:"+e);
                  e.printStackTrace();
				  String error = "Error ";
				  String error_value = "0" ;
			      res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
	            }

	  }catch ( Exception e )
      {
		e.printStackTrace();
		//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End of the insertParameter

 private void  modifyParameter(HttpServletResponse res){
  try{

		String addedById			= p.getProperty( "login_user" ) ;
		String addedDate			= dateFormat.format( new java.util.Date() ) ;
		String modifiedById			= addedById ;
		String modifiedDate			= addedDate ;
		String addedFacilityId		= facilityId;
		String modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	=client_ip_address;
		String modifiedAtWorkstation= addedAtWorkstation ;
		java.sql.Date modified_date1= java.sql.Date.valueOf(modifiedDate ) ;
	    java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ;

		HashMap tabdata=new HashMap();
				tabdata.put("BILLING_INTERFACED_YN",billing_interfaced_yn);
				tabdata.put("ALLOW_CHKOUT_WITH_BILL_STMT_YN",allow_chkout_with_bill_stmt_yn);
				tabdata.put("INV_REG_NEW_BORN_YN",inv_reg_new_born_yn);//Added By Mani
				/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start*/
				tabdata.put("CHK_FOR_PEN_ORDERS_BFR_CHKOUT",chk_for_pen_orders_bfr_chk);
				tabdata.put("CHECKOUT_ALLOW_YN",checkout_allow_yn);
				/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End*/

				tabdata.put("VISIT_BACKDATING_ALLOWED_YN",visit_backdating_allowed_yn);
				tabdata.put("MAX_HOURS_ALLOW_INSERT",max_hours_allow_insert);
				tabdata.put("REG_ATTENDANCE_FOR_INPAT_YN",reg_attendance_for_inpat_yn);
				tabdata.put("INVOKE_RECALL_FOR_AE",invoke_recall_for_AE); //Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657
				tabdata.put("RECONFIRM_CASE_OF_TRAUMA",reconfirm_case_of_trauma); //Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
				tabdata.put("REVOKE_DEATH_DISP_TYPE",disp_type_for_revoke_death); //Added by mujafar  for ML-MMOH-CRF-1427
				tabdata.put("REC_DIAG_NOT_MDT_BID",Rec_diag_not_mdt_BID); //Added by Ashwini on 10-Jan-2017 for ML-MMOH-CRF-0624
				tabdata.put("REC_DIAG_NOT_MDT_ABSCONDED",Rec_diag_not_mdt_absconded); //Added by Ashwini on 10-Jan-2017 for ML-MMOH-CRF-0630
				tabdata.put("MAX_DAYS_ALLOW_UPDATE",max_days_allow_update);
				tabdata.put("MIN_AGE_FOR_PREG_DTL",min_age_for_preg_dtl);
				tabdata.put("MAX_AGE_FOR_PAED_DTL",max_age_for_paed_dtl);
				tabdata.put("MIN_AGE_FOR_LMP",min_age_for_lmp);
				tabdata.put("DFLT_LOCN_CODE_FOR_DIS_REGN",clinic_code);
				tabdata.put("DFLT_SRVC_CODE_FOR_DIS_REGN",service_code);
				tabdata.put("DFLT_VIS_TYP_CDE_FOR_DIS_REGN",visit_type);
				tabdata.put("NURSING_UNIT_CODE",nursing_unit);
				tabdata.put("CLINIC_CODE",nursing_clinic_code);
				tabdata.put("CUTOFF_HOURS_PRV_DAY_VISIT",cutoff_hours_prv_day_visit);
				tabdata.put("VALIDATE_NATID_REG_ATTN",validate_natid_reg_attn); //Added by Ashwini on 06-Mar-2019 for MO-CRF-20148

				 tabdata.put("ORDER_CATALOG_CODE1",order_cat_code1);
				 tabdata.put("ORDER_CATALOG_CODE2",order_cat_code2);
				 tabdata.put("ORDER_CATALOG_CODE3",order_cat_code3);
				 tabdata.put("ORDER_CATALOG_CODE4",order_cat_code4);
				 tabdata.put("ORDER_CATALOG_CODE5",order_cat_code5);
				 tabdata.put("DISCR_MSR_ID1",systolicBP);
				 tabdata.put("DISCR_MSR_ID2",respiratory);
				
				/*Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start*/
				tabdata.put("ORDER_CATALOG_CODE6",orderCatalogCode6);
				tabdata.put("INITIAL_MGMT_LABEL_CONFIG",initialMgmtLbl);
				tabdata.put("DRESSING_LABEL_CONFIG",CompressionDressngLbl);
				/*End*/
				
				/*  KDAH-CRF-0526 */
				tabdata.put("DFLT_TIME_REG_AUTO_UPDATE",dfltRegAutoUpdateTime);
				tabdata.put("DFLT_EMER_FOLLOW_TYPE_CODE",dfltEmerFollowTypeCode);
				/*  KDAH-CRF-0526 */

				tabdata.put("MODIFIED_BY_ID",modifiedById);
				tabdata.put("MODIFIED_DATE",modified_date);
				tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
				tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation);
				tabdata.put("QUEUE_REFRESH_INTERVAL",queue_refresh_intervel );
				tabdata.put("RECORD_VITAL_SIGNS_YN",record_vital_signs );
			    tabdata.put("ENABLE_ACCS_RIGHTS_IN_QUEUE",enable_accs_rights_in_queue);
				tabdata.put("AE_OBSERVE_BATTERY_ID",observation_ward_type );
			    tabdata.put("DFLT_PRY_ZONE_FOR_DIS_REGN",priority_zone_area );
                tabdata.put("DFLT_UN_ADULT_AGE_FOR_DIS_REGN",unknown_adult_age_for_dis_regn );
// below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
                tabdata.put("MAX_HRS_FOR_RE_ATTEND",max_hrs_for_re_attend);
//end CRF  Bru-HIMS-CRF-152 [IN030272]
                tabdata.put("ACTION_ON_PENDING_BILL",action_on_pending_bill);  // Added for MMS-QH-CRF-0126.2 [IN:042931]
				
				tabdata.put("FIVE_LEVEL_TRIAGE_APPL_YN",five_level_triage_appl_yn); //Added for this CRF MMS-QH-CRF-0146 [IN:043836]
				
				tabdata.put("DIST_PAT_SER_GRP",dist_pat_ser_grp);  //Added for this CRF ML-MMOH-CRF-0466
				
				tabdata.put("REG_ATTENDACE_WITHIN_HOUR",re_attendace_within_hour);  //Added for this CRF ML-MMOH-CRF-0369
				
				/*Added by Thamizh selvi on 16th Oct 2017 for ML-MMOH-CRF-0623 Start*/
				tabdata.put("backdate_cons_allowed_yn",backDateConsAllowedYn); 
				tabdata.put("backdate_cons_allowed_hrs",backDateConsAllowedHrs); 
				/*End*/
				tabdata.put("REC_DIAG_NOT_MDT_DID_YN",Rec_diag_not_mdt_DID_yn);               //Added by Mano aganist ML-MMOH-CRF-0783
				tabdata.put("REC_DIAG_MDT_CALLNOTAROUND_YN",Rec_diag_mdt_CALLNOTAROUND_yn); //Added by Mano aganist ML-MMOH-CRF-0783
				
				tabdata.put("ENABLE_ADMISSION_TAB",enable_admission_tab);//<!--Added by Himanshu Saxena on 14-Jun-2023 for ML-MMOH-CRF-1972-->
				

			HashMap condflds=new HashMap();
				condflds.put("OPERATING_FACILITY_ID",facilityId);
		try{

			boolean local_ejbs = false;
			String tablename ="AE_PARAM";

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = tablename;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tablename.getClass();


			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;
	    		   if ( inserted )
				   {
					    error_value= "1";
		     			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
	        	   }
		     	   else
		     	   {
						res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
		     	   }
             results.clear();
			 tabdata.clear();
			 condflds.clear();
		     }catch(Exception e)
                {
	              //out.println("From Servlet--Calling EJB:"+e);
                  e.printStackTrace();
				  String error = "Error ";
				  String error_value = "0" ;
			      res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
	            }
	  }catch ( Exception e )
      {
		e.printStackTrace();
		//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End of the modifyParameter

	public static String checkNull(String str) {
		return ((str == null || str.equals("null") || str.equals("")) ? "" : str);
	}

	public static String checkNullWithDftValue(String str, String dftval) {
		return ((str == null || str.equals("null") || str.equals("")) ? dftval : str);
	}

} // End of the Class
