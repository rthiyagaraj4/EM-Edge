/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;


import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.io.PrintWriter;
import java.io.IOException;

import java.util.Properties;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import com.ehis.eslp.ServiceLocator;

import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

/**
 * @todo Class members should be moved to method level scope
 */
public class OperatorStationRstrnServlet extends HttpServlet{
	PrintWriter out;
	
	Properties p;

	
	//String shortDesc ;
	HttpSession session;
	String oper_stn_id;
	//String longdesc ;
	//String shortdesc ;
	String locale="";
	//String ws_no;
	
	//String effectiveStatus ;
	String facilityId ;
	String facilityID="";
	String client_ip_address ;
	String bookapptyn;
	String bookapptwopidyn;
	String obookapptyn;
	String bookapptacrosscatgyn;
	String tfrapptyn;
	String tfrapptacrosscatgyn;
	String cancapptyn;
	String registervisityn;
	String registerpatyn;
	String cancelvisityn;
	String revisevisityn;
	String managequeueyn;
	String checkoutpatyn;
	String  createbookingyn      ;
	String  revisebookingyn      ;
	String  cancbookingyn        ;
	String  CONFIRM_BOOKING    ;
	String CREATE_BOOKING_WITH_CONF;
	String  admitpatyn           ;
	String  registerpatinadmnyn  ;
	String  assignbedyn          ;
	String  assigntreatpractyn	 ;
	String  reviseadmissionyn;
	String  cancadmissionyn      ;
	String  emergencytfryn       ;
	String  MAINTAIN_DEATH_REGISTER_YN       ;
	String  routinetfryn         ;
	String  dischargepatyn       ;
	String  reviseleaveyn        ;
	String  checklodgeryn        ;
	String  swapbedyn ;
	String  BACKDATED_ADMISSION_YN ;
	String  BED_CLASS_CHANGE_YN ;
	String  canc_req_yn ;
	String  cfrm_req_yn ;
	String  can_tfr_out_yn ;
	String  pract_tfr_yn ;
	String  dchrg_adv_yn ;
	String  transferoutyn ;
	String  transferinyn ;
	String  chgnuinasgnbedyn ;
	String  admtpatbedyn ;
	String  forcbkapptyn ;
	String  glblbkapptyn ;
	String operation ;
	String locn_type ;
	String locn_code;
	String appluserid ;
	String block_bed_yn="";
	String release_bed_yn="";
	String create_wait_list_yn="";
	String modify_wait_list_yn="";
	String cancel_wait_list_yn="";
	String cancel_checkout_yn="";
	String diag_proc_recode_for_ip_yn="";
	//String cancel_discharge="";
	//String cancel_transfer="";
	//String admitpatientnewborn;
	//String recdiagadmitpat;
	String LINK_BABY_TO_MOTHER_YN="";
	String REG_NEWBORN_FOR_IP_YN="";
	String DISCHARGE_CHECKLIST_YN="";
	String RESERVE_BED_BAY_YN="";
	String RELEASE_BED_BAY_YN="";

	String REG_IP_REFERRAL_YN="";
	String CONFIRM_BEDSIDE_REFERRAL_YN="";


	String register_visit_walkin_yn="";
	String register_visit_referral_yn="";
	String cancel_discharge_yn = "";
	String OVERRIDE_WALKIN_YN = "";


	//15-sep-2008 new String for operation restrictoin
	String CANCEL_RESERVE_BED_YN = "";
	String book_appt_across_catg_yn = "";
	String diag_proc_recode_for_op_yn="";
	String emergency_transfer_yn="";
	
	String quick_admission_yn =""; //this line Added for this CRF Bru-HIMS-CRF-261

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		session = req.getSession(false);		
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
 locale= p.getProperty("LOCALE");
		try{
			res.setContentType("text/html");
			this.out = res.getWriter();
		 operation = req.getParameter("operation_type");
			if (operation.equals("insert") ) 
			{
				insertOperatorStationRstrn(req, res);
			}else if (operation.equals("modify"))
			{
				    modifyOperatorStationRstrn(req, res);
			}else if (operation.equals("delete"))
			{
				    deleteOperatorStationRstrn(req, res);
			}
		}catch(Exception e){
			out.println("Post Method failed:"+e.toString());
			e.printStackTrace();
		}
	}
	private void deleteOperatorStationRstrn(HttpServletRequest req, HttpServletResponse res)
	{
			facilityID = req.getParameter("facility");
			oper_stn_id =req.getParameter("oprstnid");
			locn_code 	= req.getParameter("locationid");
			locn_type	= req.getParameter("locationtype");
			appluserid	= req.getParameter("user");
			Connection con=webbeans.eCommon.ConnectionManager.getConnection(req);
			PreparedStatement pstmt=null;
			//String errorMsg="Delete operation unsuccessful...";
			String error_value="0";
			try{
				pstmt=con.prepareStatement("delete am_restrn_for_oper_stn where FACILITY_ID=? and OPER_STN_ID=? and APPL_USER_ID=? and LOCN_TYPE=? and LOCN_CODE=?");
				pstmt.setString(1,facilityID);
				pstmt.setString(2,oper_stn_id);
				pstmt.setString(3,appluserid);
				pstmt.setString(4,locn_type);
				pstmt.setString(5,locn_code);
				int result=pstmt.executeUpdate();
				if(result!=0)result=1;
				String errMsg="";
				if(result==1)
				{
					con.commit();
					//errorMsg="Delete operation successful...";
					Map hashtable1 = MessageManager.getMessage(locale, "RECORD_DELETED","SM");
					errMsg = (String)hashtable1.get("message");
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(errMsg,"UTF-8" ) + "&err_value=1");
					error_value="1";

					hashtable1.clear();
				}
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errMsg ,"UTF-8" )+"&err_value="+error_value );
				if(pstmt!=null) pstmt.close();
			}catch(Exception e){
				try{
					con.rollback();	
				}catch(Exception ee){}
				out.println("Delete operation failed: Exception-"+e);
				e.printStackTrace();
			}finally{
				webbeans.eCommon.ConnectionManager.returnConnection(con,req);
			}
	}

	private void insertOperatorStationRstrn(HttpServletRequest req, HttpServletResponse res){
		try{
			res.setContentType("text/html");
			facilityID = req.getParameter("facility_id");
			oper_stn_id =req.getParameter("oprstn");
			locn_code 	= req.getParameter("locid");
			locn_type	= req.getParameter("loctype");
			appluserid	= req.getParameter("user");
			//ws_no 		= req.getParameter("ws_no")==null?"":req.getParameter("ws_no");

			bookapptyn 	= req.getParameter("book_appt_yn");
			if(bookapptyn == null) bookapptyn = "N";

			bookapptwopidyn = req.getParameter("book_appt_wo_pid_yn");
			if(bookapptwopidyn == null) bookapptwopidyn = "N";

			obookapptyn 	= req.getParameter("obook_appt_yn");
			if(obookapptyn == null) obookapptyn = "N";

			bookapptacrosscatgyn = req.getParameter("book_appt_across_catg_yn");
			if(bookapptacrosscatgyn == null) bookapptacrosscatgyn = "N";
			
			//Newly added on 09/01/2005
			create_wait_list_yn = req.getParameter("create_wait_list_yn");
			if(create_wait_list_yn == null) create_wait_list_yn = "N";
			
			modify_wait_list_yn = req.getParameter("modify_wait_list_yn");
			if(modify_wait_list_yn == null) modify_wait_list_yn = "N";

			cancel_wait_list_yn = req.getParameter("cancel_wait_list_yn");
			if(cancel_wait_list_yn == null) cancel_wait_list_yn = "N";

//cancel checkout

            cancel_checkout_yn = req.getParameter("cancel_checkout_yn");
			if(cancel_checkout_yn == null) cancel_checkout_yn = "N";

			diag_proc_recode_for_ip_yn =req.getParameter("diag_proc_recode_for_ip_yn");
			if( diag_proc_recode_for_ip_yn == null) diag_proc_recode_for_ip_yn="N";
            
			tfrapptyn 		= req.getParameter("tfr_appt_yn");
			if(tfrapptyn == null) tfrapptyn = "N";

			tfrapptacrosscatgyn = req.getParameter("tfr_appt_across_catg_yn");
			if(tfrapptacrosscatgyn == null) tfrapptacrosscatgyn = "N";

			registervisityn = req.getParameter("register_visit_yn");
			if(registervisityn == null) registervisityn = "N";

			registerpatyn 	= req.getParameter("register_pat_yn");
			if(registerpatyn == null) registerpatyn = "N";

			cancelvisityn 	= req.getParameter("cancel_visit_yn");
			if(cancelvisityn == null) cancelvisityn = "N";

			revisevisityn 	= req.getParameter("revise_visit_yn");
			if(revisevisityn == null) revisevisityn = "N";

			managequeueyn 	= req.getParameter("manage_queue_yn");
			if(managequeueyn == null) managequeueyn = "N";

			checkoutpatyn 	= req.getParameter("checkout_pat_yn");
			if(checkoutpatyn == null) checkoutpatyn = "N";

			cancapptyn 		= req.getParameter("canc_appt_yn");
			if(cancapptyn == null) cancapptyn = "N";

			block_bed_yn 		= req.getParameter("block_bed_yn");
			if(block_bed_yn == null) block_bed_yn = "N";

			release_bed_yn 		= req.getParameter("release_bed_yn");
			if(release_bed_yn == null) release_bed_yn = "N";

			createbookingyn= req.getParameter("create_booking_yn")==null?"N":req.getParameter("create_booking_yn");
			revisebookingyn= req.getParameter("revise_booking_yn")==null?"N":req.getParameter("revise_booking_yn");
			cancbookingyn  = req.getParameter("canc_booking_yn")==null?"N":req.getParameter("canc_booking_yn");
			CONFIRM_BOOKING= req.getParameter("CONFIRM_BOOKING_YN")==null?"N":req.getParameter("CONFIRM_BOOKING_YN");

			CREATE_BOOKING_WITH_CONF= req.getParameter("CREATE_BOOKING_WITH_CONF_YN")==null?"N":req.getParameter("CREATE_BOOKING_WITH_CONF_YN");
			
			admitpatyn     = req.getParameter("admit_pat_yn")==null?"N":req.getParameter("admit_pat_yn");
			registerpatinadmnyn     = req.getParameter("register_pat_in_admn_yn")==null?"N":req.getParameter("register_pat_in_admn_yn");
			
//		admitpatientnewborn =
//		req.getParameter("ADMIT_PATIENT_FROM_NEWBORN_YN")==null?"N":req.getParameter("ADMIT_PATIENT_FROM_NEWBORN_YN");

//		recdiagadmitpat =
//		req.getParameter("REC_DIAG_FROM_ADMIT_PAT_YN")==null?"N":req.getParameter("REC_DIAG_FROM_ADMIT_PAT_YN");
	
			assignbedyn    = req.getParameter("assign_bed_yn")==null?"N":req.getParameter("assign_bed_yn");
			assigntreatpractyn= req.getParameter("assign_treat_pract_yn")==null?"N":req.getParameter("assign_treat_pract_yn");
			reviseadmissionyn= req.getParameter("revise_admission_yn")==null?"N":req.getParameter("revise_admission_yn");
			cancadmissionyn= req.getParameter("canc_admission_yn")==null?"N":req.getParameter("canc_admission_yn");
			emergencytfryn = req.getParameter("emergency_tfr_yn")==null?"N":req.getParameter("emergency_tfr_yn");
			MAINTAIN_DEATH_REGISTER_YN = req.getParameter("MAINTAIN_DEATH_REGISTER_YN")==null?"N":req.getParameter("MAINTAIN_DEATH_REGISTER_YN");
			routinetfryn   = req.getParameter("routine_tfr_yn")==null?"N":req.getParameter("routine_tfr_yn");
			dischargepatyn = req.getParameter("discharge_pat_yn")==null?"N":req.getParameter("discharge_pat_yn");
			reviseleaveyn  = req.getParameter("revise_leave_yn")==null?"N":req.getParameter("revise_leave_yn");
			checklodgeryn  = req.getParameter("check_lodger_yn")==null?"N":req.getParameter("check_lodger_yn");
			swapbedyn = req.getParameter("SWAP_BED_YN")==null?"N":req.getParameter("SWAP_BED_YN");
			BACKDATED_ADMISSION_YN = req.getParameter("BACKDATED_ADMISSION_YN")==null?"N":req.getParameter("BACKDATED_ADMISSION_YN");
			BED_CLASS_CHANGE_YN = req.getParameter("BED_CLASS_CHANGE_YN")==null?"N":req.getParameter("BED_CLASS_CHANGE_YN");
			canc_req_yn = req.getParameter("canc_req_yn")==null?"N":req.getParameter("canc_req_yn");
			cfrm_req_yn = req.getParameter("cfrm_req_yn")==null?"N":req.getParameter("cfrm_req_yn");
			can_tfr_out_yn = req.getParameter("can_tfr_out_yn")==null?"N":req.getParameter("can_tfr_out_yn");
			pract_tfr_yn = req.getParameter("pract_tfr_yn")==null?"N":req.getParameter("pract_tfr_yn");
			dchrg_adv_yn = req.getParameter("dchrg_adv_yn")==null?"N":req.getParameter("dchrg_adv_yn");

/*			cancel_transfer = req.getParameter("cancel_transfer")==null?"N":req.getParameter("cancel_transfer");
			cancel_discharge = req.getParameter("cancel_discharge")==null?"N":req.getParameter("cancel_discharge");*/

			transferoutyn = req.getParameter("TRANSFER_OUT_PATIENT_YN")==null?"N":req.getParameter("TRANSFER_OUT_PATIENT_YN");
			transferinyn = req.getParameter("TRANSFER_IN_PATIENT_YN")==null?"N":req.getParameter("TRANSFER_IN_PATIENT_YN");
			chgnuinasgnbedyn = req.getParameter("CHG_NURS_UNIT_IN_ASSIGN_BED_YN")==null?"N":req.getParameter("CHG_NURS_UNIT_IN_ASSIGN_BED_YN");
			admtpatbedyn = req.getParameter("ADMIT_PATIENT_WITH_BED_YN")==null?"N":req.getParameter("ADMIT_PATIENT_WITH_BED_YN");
			forcbkapptyn = req.getParameter("FORCED_BOOK_APPT_YN")==null?"N":req.getParameter("FORCED_BOOK_APPT_YN");
			book_appt_across_catg_yn = req.getParameter("book_appt_across_catg_yn")==null?"N":req.getParameter("book_appt_across_catg_yn");
			glblbkapptyn = req.getParameter("GLOBAL_BOOK_APPT_YN")==null?"N":req.getParameter("GLOBAL_BOOK_APPT_YN");
			
			LINK_BABY_TO_MOTHER_YN = req.getParameter("LINK_BABY_TO_MOTHER_YN")==null?"N":req.getParameter("LINK_BABY_TO_MOTHER_YN");
			REG_NEWBORN_FOR_IP_YN = req.getParameter("REG_NEWBORN_FOR_IP_YN")==null?"N":req.getParameter("REG_NEWBORN_FOR_IP_YN");
			DISCHARGE_CHECKLIST_YN = req.getParameter("DISCHARGE_CHECKLIST_YN")==null?"N":req.getParameter("DISCHARGE_CHECKLIST_YN");
			RESERVE_BED_BAY_YN = req.getParameter("RESERVE_BED_BAY_YN")==null?"N":req.getParameter("RESERVE_BED_BAY_YN");
			RELEASE_BED_BAY_YN = req.getParameter("RELEASE_BED_BAY_YN")==null?"N":req.getParameter("RELEASE_BED_BAY_YN");

			REG_IP_REFERRAL_YN = req.getParameter("REG_IP_REFERRAL_YN")==null?"N":req.getParameter("REG_IP_REFERRAL_YN");
			CONFIRM_BEDSIDE_REFERRAL_YN = req.getParameter("CONFIRM_BEDSIDE_REFERRAL_YN")==null?"N":req.getParameter("CONFIRM_BEDSIDE_REFERRAL_YN");

		
			register_visit_walkin_yn =req.getParameter("register_visit_walkin_yn");
			if(register_visit_walkin_yn == null) register_visit_walkin_yn="N";

			register_visit_referral_yn =req.getParameter("register_visit_referral_yn");
			if(register_visit_referral_yn == null) register_visit_referral_yn="N";

			cancel_discharge_yn =req.getParameter("cancel_discharge_yn");
			if(cancel_discharge_yn == null) cancel_discharge_yn="N";	
			
            diag_proc_recode_for_op_yn =req.getParameter("diag_proc_recode_for_op_yn");
			if( diag_proc_recode_for_op_yn == null) diag_proc_recode_for_op_yn="N";
		

			OVERRIDE_WALKIN_YN = req.getParameter("OVERRIDE_WALKIN_YN")==null?"N":req.getParameter("OVERRIDE_WALKIN_YN");

			//15-sep-2008, get parameter of CANCEL_RESERVE_BED_YN for cancelReservebed function

			CANCEL_RESERVE_BED_YN = req.getParameter("CANCEL_RESERVE_BED_YN")==null?"N":req.getParameter("CANCEL_RESERVE_BED_YN");
			
			emergency_transfer_yn = req.getParameter("emergency_transfer_yn")==null?"N":req.getParameter("emergency_transfer_yn");
			
			//Below line Added for this CRF Bru-HIMS-CRF-261
            quick_admission_yn = req.getParameter("quick_admission_yn")==null?"N":req.getParameter("quick_admission_yn");
			


			String addedById 	= p.getProperty( "login_user" ) ;
			String addedDate 	= dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId		= facilityId;
			String modifiedFacilityId 	= addedFacilityId ;
			String addedAtWorkstation	= client_ip_address;
			String modifiedAtWorkstation= addedAtWorkstation ;

			java.sql.Date added_date 	= java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

			HashMap tabdata=new HashMap();

			tabdata.put("facility_id",facilityID);
			tabdata.put("oper_stn_id",oper_stn_id);
			tabdata.put("appl_user_id",appluserid);
			tabdata.put("locn_type",locn_type);
			tabdata.put("locn_code",locn_code);
			tabdata.put("book_appt_yn",bookapptyn);
			tabdata.put("book_appt_wo_pid_yn",bookapptwopidyn);
			tabdata.put("obook_appt_yn",obookapptyn);
			//tabdata.put("book_appt_across_catg_yn",book_appt_across_catg_yn);
			tabdata.put("tfr_appt_yn",tfrapptyn);
			tabdata.put("tfr_appt_across_catg_yn",tfrapptacrosscatgyn);
			tabdata.put("register_visit_yn",registervisityn);
			tabdata.put("register_pat_yn",registerpatyn);
			tabdata.put("cancel_visit_yn",cancelvisityn);
			tabdata.put("manage_queue_yn",managequeueyn);
			tabdata.put("revise_visit_yn",revisevisityn);
			tabdata.put("checkout_pat_yn",checkoutpatyn);
			tabdata.put("canc_appt_yn",cancapptyn);

			tabdata.put("create_booking_yn",createbookingyn);
			tabdata.put("revise_booking_yn",revisebookingyn);
			tabdata.put("canc_booking_yn",cancbookingyn);
			tabdata.put("CONFIRM_BOOKING_YN",CONFIRM_BOOKING);

			tabdata.put("CREATE_BOOKING_WITH_CONF_YN",CREATE_BOOKING_WITH_CONF);
//			tabdata.put("ADMIT_PATIENT_FROM_NEWBORN_YN",admitpatientnewborn);
//			tabdata.put("REC_DIAG_FROM_ADMIT_PAT_YN",recdiagadmitpat);
			
			tabdata.put("admit_pat_yn",admitpatyn);
			tabdata.put("register_pat_in_admn_yn",registerpatinadmnyn);
			tabdata.put("assign_bed_yn",assignbedyn);
			tabdata.put("assign_treat_pract_yn",assigntreatpractyn);
			tabdata.put("revise_admission_yn",reviseadmissionyn);
			tabdata.put("canc_admission_yn",cancadmissionyn);
			tabdata.put("emergency_tfr_yn",emergencytfryn);
			tabdata.put("MAINTAIN_DEATH_REGISTER_YN",MAINTAIN_DEATH_REGISTER_YN);
			tabdata.put("routine_tfr_yn",routinetfryn);
			tabdata.put("discharge_pat_yn",dischargepatyn);
			tabdata.put("revise_leave_yn",reviseleaveyn);
			tabdata.put("check_lodger_yn",checklodgeryn);
			tabdata.put("block_bed_yn",block_bed_yn);
			tabdata.put("release_bed_yn",release_bed_yn);

			tabdata.put("SWAP_BED_YN",swapbedyn);
			tabdata.put("BACKDATED_ADMISSION_YN",BACKDATED_ADMISSION_YN);
			tabdata.put("BED_CLASS_CHANGE_YN",BED_CLASS_CHANGE_YN);
			tabdata.put("CANCEL_REQUEST_YN",canc_req_yn);
			tabdata.put("CONFIRM_REQUEST_YN",cfrm_req_yn);
			tabdata.put("CANCEL_TRANSFER_OUT_YN",can_tfr_out_yn);
			tabdata.put("PRACT_TRANSFER_YN",pract_tfr_yn);
			tabdata.put("DISCHARGE_ADVICE_YN",dchrg_adv_yn);
			/*tabdata.put("cancel_discharge_yn",cancel_discharge);
			tabdata.put("cancel_transfer_yn",cancel_transfer);*/

			tabdata.put("TRANSFER_OUT_PATIENT_YN",transferoutyn);
			tabdata.put("TRANSFER_IN_PATIENT_YN",transferinyn);
			tabdata.put("CHG_NURS_UNIT_IN_ASSIGN_BED_YN",chgnuinasgnbedyn);
			tabdata.put("ADMIT_PATIENT_WITH_BED_YN",admtpatbedyn);
			tabdata.put("FORCED_BOOK_APPT_YN",forcbkapptyn);
			tabdata.put("GLOBAL_BOOK_APPT_YN",glblbkapptyn);

			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			tabdata.put("register_visit_walkin_yn",register_visit_walkin_yn );
			tabdata.put("register_visit_referral_yn",register_visit_referral_yn );
			tabdata.put("create_wait_list_yn",create_wait_list_yn );
			tabdata.put("modify_wait_list_yn",modify_wait_list_yn );
			tabdata.put("cancel_wait_list_yn",cancel_wait_list_yn );
            //cancel checkout
            tabdata.put("cancel_checkout_yn",cancel_checkout_yn );
			tabdata.put("LINK_BABY_TO_MOTHER_YN",LINK_BABY_TO_MOTHER_YN );
			tabdata.put("REG_NEWBORN_FOR_IP_YN",REG_NEWBORN_FOR_IP_YN );
			tabdata.put("DISCHARGE_CHECKLIST_YN",DISCHARGE_CHECKLIST_YN );
			tabdata.put("RESERVE_BED_BAY_YN",RESERVE_BED_BAY_YN );
			tabdata.put("RELEASE_BED_BAY_YN",RELEASE_BED_BAY_YN );
			tabdata.put("REG_IP_REFERRAL_YN",REG_IP_REFERRAL_YN );
			tabdata.put("CONFIRM_BEDSIDE_REFERRAL_YN",CONFIRM_BEDSIDE_REFERRAL_YN );
			tabdata.put("CANCEL_DISCHARGE_YN",cancel_discharge_yn );
			tabdata.put("OVERRIDE_WALKIN_YN",OVERRIDE_WALKIN_YN );
			//15-sep-2008 add cancelreserved bed in hashtable
			tabdata.put("CANCEL_RESERVE_BED_YN",CANCEL_RESERVE_BED_YN );
			tabdata.put("BOOK_APPT_ACROSS_CATG_YN",bookapptacrosscatgyn );
			tabdata.put("DIAG_PROC_RECODE_FOR_OP_YN",diag_proc_recode_for_op_yn);    
		    tabdata.put("DIAG_PROC_RECODE_FOR_IP_YN",diag_proc_recode_for_ip_yn);     
		    tabdata.put("emergency_transfer_yn",emergency_transfer_yn);   
         
            tabdata.put("quick_admission_yn ",quick_admission_yn );		//this line Added for this CRF Bru-HIMS-CRF-261 
			
			
			String dupflds[]={"oper_stn_id","facility_id","appl_user_id","locn_type","locn_code"};

/*
			InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			final java.util.HashMap results = singleTabHandlerManagerRemote.insert(p,tabdata,dupflds,"am_restrn_for_oper_stn");
*/
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		/*	Object argArray[] = new Object[4];
			String table_name="am_restrn_for_oper_stn";

			HashMap hashmap=new HashMap();
			hashmap.put("p",p);
			hashmap.put("tabdata",tabdata);
			hashmap.put("dupflds",dupflds);
			hashmap.put("table_name",table_name);

			argArray[0] = hashmap;
						
			Class [] paramArray = new Class[1];
			paramArray[0] = hashmap.getClass();*/


			Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
				String table_name="am_restrn_for_oper_stn";
				argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =dupflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				//paramArray[0] =hashmap.getClass();
					paramArray[0] =p.getClass();
					paramArray[1] =tabdata.getClass();
					paramArray[2] =dupflds.getClass();
					paramArray[3] =table_name.getClass();

			
			HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		
			//Clears the mapping
			tabdata.clear();

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ){
				 error_value = "1" ;
			}
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8" )+"&err_value="+error_value );

			results.clear();
		}catch ( Exception e ){
			out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			e.printStackTrace();
		}
	}//E.O.Insert

	private void modifyOperatorStationRstrn(HttpServletRequest req, HttpServletResponse res){
		try{
			facilityID = req.getParameter("facility_id");
			oper_stn_id =req.getParameter("oprstn");
			locn_code 	= req.getParameter("locid");
			locn_type	= req.getParameter("loctype");
			appluserid	= req.getParameter("user");

			res.setContentType("text/html");
			//ws_no = req.getParameter("ws_no")==null?"":req.getParameter("ws_no");

			bookapptyn 		= req.getParameter("book_appt_yn");
			if(bookapptyn == null) bookapptyn = "N";

			bookapptwopidyn = req.getParameter("book_appt_wo_pid_yn");
			if(bookapptwopidyn == null) bookapptwopidyn = "N";

			obookapptyn 	= req.getParameter("obook_appt_yn");
			if(obookapptyn == null) obookapptyn = "N";

			bookapptacrosscatgyn = req.getParameter("book_appt_across_catg_yn");
			if(bookapptacrosscatgyn == null) bookapptacrosscatgyn = "N";

			tfrapptyn 		= req.getParameter("tfr_appt_yn");
			if(tfrapptyn == null) tfrapptyn = "N";

			tfrapptacrosscatgyn = req.getParameter("tfr_appt_across_catg_yn");
			if(tfrapptacrosscatgyn == null) tfrapptacrosscatgyn = "N";

			registervisityn = req.getParameter("register_visit_yn");
			if(registervisityn == null) registervisityn = "N";
			//newly added
			create_wait_list_yn = req.getParameter("create_wait_list_yn");
			if(create_wait_list_yn == null) create_wait_list_yn = "N";
			
			modify_wait_list_yn = req.getParameter("modify_wait_list_yn");
			if(modify_wait_list_yn == null) modify_wait_list_yn = "N";
			
			cancel_wait_list_yn = req.getParameter("cancel_wait_list_yn");
			if(cancel_wait_list_yn == null) cancel_wait_list_yn = "N";

//cancel checkout
            cancel_checkout_yn = req.getParameter("cancel_checkout_yn");
			if(cancel_checkout_yn == null) cancel_checkout_yn = "N";

            diag_proc_recode_for_ip_yn =req.getParameter("diag_proc_recode_for_ip_yn");
			if( diag_proc_recode_for_ip_yn == null) diag_proc_recode_for_ip_yn="N";

			registerpatyn 	= req.getParameter("register_pat_yn");
			if(registerpatyn == null) registerpatyn = "N";

			cancelvisityn 	= req.getParameter("cancel_visit_yn");
			if(cancelvisityn == null) cancelvisityn = "N";

			revisevisityn 	= req.getParameter("revise_visit_yn");
			if(revisevisityn == null) revisevisityn = "N";

			managequeueyn 	= req.getParameter("manage_queue_yn");
			if(managequeueyn == null) managequeueyn = "N";

			checkoutpatyn 	= req.getParameter("checkout_pat_yn");
			if(checkoutpatyn == null) checkoutpatyn = "N";

			cancapptyn 		= req.getParameter("canc_appt_yn");
			if(cancapptyn == null) cancapptyn = "N";

			block_bed_yn 		= req.getParameter("block_bed_yn");
			if(block_bed_yn == null) block_bed_yn = "N";

			release_bed_yn 		= req.getParameter("release_bed_yn");
			if(release_bed_yn == null) release_bed_yn = "N";


			swapbedyn = req.getParameter("SWAP_BED_YN")==null?"N":req.getParameter("SWAP_BED_YN");
			BACKDATED_ADMISSION_YN = req.getParameter("BACKDATED_ADMISSION_YN")==null?"N":req.getParameter("BACKDATED_ADMISSION_YN");
			BED_CLASS_CHANGE_YN = req.getParameter("BED_CLASS_CHANGE_YN")==null?"N":req.getParameter("BED_CLASS_CHANGE_YN");
			canc_req_yn = req.getParameter("canc_req_yn")==null?"N":req.getParameter("canc_req_yn");
			cfrm_req_yn = req.getParameter("cfrm_req_yn")==null?"N":req.getParameter("cfrm_req_yn");
			can_tfr_out_yn = req.getParameter("can_tfr_out_yn")==null?"N":req.getParameter("can_tfr_out_yn");
			pract_tfr_yn = req.getParameter("pract_tfr_yn")==null?"N":req.getParameter("pract_tfr_yn");
			dchrg_adv_yn = req.getParameter("dchrg_adv_yn")==null?"N":req.getParameter("dchrg_adv_yn");

	/*		cancel_transfer = req.getParameter("cancel_transfer")==null?"N":req.getParameter("cancel_transfer");
			cancel_discharge = req.getParameter("cancel_discharge")==null?"N":req.getParameter("cancel_discharge");*/
			transferoutyn = req.getParameter("TRANSFER_OUT_PATIENT_YN")==null?"N":req.getParameter("TRANSFER_OUT_PATIENT_YN");
			transferinyn = req.getParameter("TRANSFER_IN_PATIENT_YN")==null?"N":req.getParameter("TRANSFER_IN_PATIENT_YN");
			chgnuinasgnbedyn = req.getParameter("CHG_NURS_UNIT_IN_ASSIGN_BED_YN")==null?"N":req.getParameter("CHG_NURS_UNIT_IN_ASSIGN_BED_YN");
			admtpatbedyn = req.getParameter("ADMIT_PATIENT_WITH_BED_YN")==null?"N":req.getParameter("ADMIT_PATIENT_WITH_BED_YN");
			forcbkapptyn = req.getParameter("FORCED_BOOK_APPT_YN")==null?"N":req.getParameter("FORCED_BOOK_APPT_YN");
			glblbkapptyn = req.getParameter("GLOBAL_BOOK_APPT_YN")==null?"N":req.getParameter("GLOBAL_BOOK_APPT_YN");
			

			createbookingyn= req.getParameter("create_booking_yn")==null?"N":req.getParameter("create_booking_yn");
			revisebookingyn= req.getParameter("revise_booking_yn")==null?"N":req.getParameter("revise_booking_yn");
			cancbookingyn  = req.getParameter("canc_booking_yn")==null?"N":req.getParameter("canc_booking_yn");
			CONFIRM_BOOKING= req.getParameter("CONFIRM_BOOKING_YN")==null?"N":req.getParameter("CONFIRM_BOOKING_YN");

			CREATE_BOOKING_WITH_CONF= req.getParameter("CREATE_BOOKING_WITH_CONF_YN")==null?"N":req.getParameter("CREATE_BOOKING_WITH_CONF_YN");
			
			admitpatyn     = req.getParameter("admit_pat_yn")==null?"N":req.getParameter("admit_pat_yn");
			registerpatinadmnyn     = req.getParameter("register_pat_in_admn_yn")==null?"N":req.getParameter("register_pat_in_admn_yn");
						
//			admitpatientnewborn =
		//req.getParameter("ADMIT_PATIENT_FROM_NEWBORN_YN")==null?"N":req.getParameter("ADMIT_PATIENT_FROM_NEWBORN_YN");

	//	recdiagadmitpat =
//		req.getParameter("REC_DIAG_FROM_ADMIT_PAT_YN")==null?"N":req.getParameter("REC_DIAG_FROM_ADMIT_PAT_YN");

			assignbedyn    = req.getParameter("assign_bed_yn")==null?"N":req.getParameter("assign_bed_yn");
			assigntreatpractyn= req.getParameter("assign_treat_pract_yn")==null?"N":req.getParameter("assign_treat_pract_yn");
			reviseadmissionyn= req.getParameter("revise_admission_yn")==null?"N":req.getParameter("revise_admission_yn");
			cancadmissionyn= req.getParameter("canc_admission_yn")==null?"N":req.getParameter("canc_admission_yn");
			emergencytfryn = req.getParameter("emergency_tfr_yn")==null?"N":req.getParameter("emergency_tfr_yn");
			MAINTAIN_DEATH_REGISTER_YN = req.getParameter("MAINTAIN_DEATH_REGISTER_YN")==null?"N":req.getParameter("MAINTAIN_DEATH_REGISTER_YN");
			routinetfryn   = req.getParameter("routine_tfr_yn")==null?"N":req.getParameter("routine_tfr_yn");
			dischargepatyn = req.getParameter("discharge_pat_yn")==null?"N":req.getParameter("discharge_pat_yn");
			reviseleaveyn  = req.getParameter("revise_leave_yn")==null?"N":req.getParameter("revise_leave_yn");
			checklodgeryn  = req.getParameter("check_lodger_yn")==null?"N":req.getParameter("check_lodger_yn");

			LINK_BABY_TO_MOTHER_YN = req.getParameter("LINK_BABY_TO_MOTHER_YN")==null?"N":req.getParameter("LINK_BABY_TO_MOTHER_YN");
			REG_NEWBORN_FOR_IP_YN = req.getParameter("REG_NEWBORN_FOR_IP_YN")==null?"N":req.getParameter("REG_NEWBORN_FOR_IP_YN");
			DISCHARGE_CHECKLIST_YN = req.getParameter("DISCHARGE_CHECKLIST_YN")==null?"N":req.getParameter("DISCHARGE_CHECKLIST_YN");
			RESERVE_BED_BAY_YN = req.getParameter("RESERVE_BED_BAY_YN")==null?"N":req.getParameter("RESERVE_BED_BAY_YN");
			RELEASE_BED_BAY_YN = req.getParameter("RELEASE_BED_BAY_YN")==null?"N":req.getParameter("RELEASE_BED_BAY_YN");

			REG_IP_REFERRAL_YN = req.getParameter("REG_IP_REFERRAL_YN")==null?"N":req.getParameter("REG_IP_REFERRAL_YN");
			CONFIRM_BEDSIDE_REFERRAL_YN = req.getParameter("CONFIRM_BEDSIDE_REFERRAL_YN")==null?"N":req.getParameter("CONFIRM_BEDSIDE_REFERRAL_YN");

			register_visit_walkin_yn =req.getParameter("register_visit_walkin_yn");
			if(register_visit_walkin_yn == null) register_visit_walkin_yn="N";

			register_visit_referral_yn =req.getParameter("register_visit_referral_yn");
			if(register_visit_referral_yn == null) register_visit_referral_yn="N";

			register_visit_referral_yn =req.getParameter("register_visit_referral_yn");
			if(register_visit_referral_yn == null) register_visit_referral_yn="N";

			cancel_discharge_yn =req.getParameter("cancel_discharge_yn");
			if(cancel_discharge_yn == null) cancel_discharge_yn="N";			

			OVERRIDE_WALKIN_YN = req.getParameter("OVERRIDE_WALKIN_YN")==null?"N":req.getParameter("OVERRIDE_WALKIN_YN");
			//9/15/2008 getparameter for cancelreservedBed
			CANCEL_RESERVE_BED_YN = req.getParameter("CANCEL_RESERVE_BED_YN")==null?"N":req.getParameter("CANCEL_RESERVE_BED_YN");

			diag_proc_recode_for_op_yn =req.getParameter("diag_proc_recode_for_op_yn");
			if( diag_proc_recode_for_op_yn == null) diag_proc_recode_for_op_yn="N";

			emergency_transfer_yn = req.getParameter("emergency_transfer_yn")==null?"N":req.getParameter("emergency_transfer_yn");
			
			quick_admission_yn = req.getParameter("quick_admission_yn")==null?"N":req.getParameter("quick_admission_yn"); 
			
			//Above line Added for this CRF Bru-HIMS-CRF-261

			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			//java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

			HashMap tabdata=new HashMap();
		/*	tabdata.put("facility_id",addedFacilityId);
			tabdata.put("oper_stn_id",oper_stn_id);
			tabdata.put("appl_user_id",addedById);
			tabdata.put("locn_type",locn_type);
			tabdata.put("locn_code",locn_code);*/
			tabdata.put("book_appt_yn",bookapptyn);
			tabdata.put("book_appt_wo_pid_yn",bookapptwopidyn);
			tabdata.put("obook_appt_yn",obookapptyn);
			//tabdata.put("book_appt_across_catg_yn",bookapptacrosscatgyn);
			tabdata.put("tfr_appt_yn",tfrapptyn);
			tabdata.put("tfr_appt_across_catg_yn",tfrapptacrosscatgyn);
			tabdata.put("register_visit_yn",registervisityn);
			tabdata.put("register_pat_yn",registerpatyn);
			tabdata.put("cancel_visit_yn",cancelvisityn);
			tabdata.put("manage_queue_yn",managequeueyn);
			tabdata.put("revise_visit_yn",revisevisityn);
			tabdata.put("checkout_pat_yn",checkoutpatyn);
			tabdata.put("canc_appt_yn",cancapptyn);

			tabdata.put("create_booking_yn",createbookingyn);
			tabdata.put("revise_booking_yn",revisebookingyn);
			tabdata.put("canc_booking_yn",cancbookingyn);
			tabdata.put("CONFIRM_BOOKING_YN",CONFIRM_BOOKING);
			tabdata.put("CREATE_BOOKING_WITH_CONF_YN",CREATE_BOOKING_WITH_CONF);
	
//			tabdata.put("ADMIT_PATIENT_FROM_NEWBORN_YN",admitpatientnewborn);
//			tabdata.put("REC_DIAG_FROM_ADMIT_PAT_YN",recdiagadmitpat);

			tabdata.put("admit_pat_yn",admitpatyn);
			tabdata.put("register_pat_in_admn_yn",registerpatinadmnyn);
			tabdata.put("assign_bed_yn",assignbedyn);
			tabdata.put("assign_treat_pract_yn",assigntreatpractyn);
			tabdata.put("revise_admission_yn",reviseadmissionyn);
			tabdata.put("canc_admission_yn",cancadmissionyn);
			tabdata.put("emergency_tfr_yn",emergencytfryn);
			tabdata.put("MAINTAIN_DEATH_REGISTER_YN",MAINTAIN_DEATH_REGISTER_YN);
			tabdata.put("routine_tfr_yn",routinetfryn);
			tabdata.put("discharge_pat_yn",dischargepatyn);
			tabdata.put("revise_leave_yn",reviseleaveyn);
			tabdata.put("check_lodger_yn",checklodgeryn);
			tabdata.put("block_bed_yn",block_bed_yn);
			tabdata.put("release_bed_yn",release_bed_yn);

			tabdata.put("SWAP_BED_YN",swapbedyn);
			tabdata.put("BACKDATED_ADMISSION_YN",BACKDATED_ADMISSION_YN);
			tabdata.put("BED_CLASS_CHANGE_YN",BED_CLASS_CHANGE_YN);
			tabdata.put("CANCEL_REQUEST_YN",canc_req_yn);
			tabdata.put("CONFIRM_REQUEST_YN",cfrm_req_yn);
			tabdata.put("CANCEL_TRANSFER_OUT_YN",can_tfr_out_yn);
			tabdata.put("PRACT_TRANSFER_YN",pract_tfr_yn);
			tabdata.put("DISCHARGE_ADVICE_YN",dchrg_adv_yn);
			/*tabdata.put("cancel_discharge_yn",cancel_discharge);
			tabdata.put("cancel_transfer_yn",cancel_transfer);*/
			tabdata.put("TRANSFER_OUT_PATIENT_YN",transferoutyn);
			tabdata.put("TRANSFER_IN_PATIENT_YN",transferinyn);
			tabdata.put("CHG_NURS_UNIT_IN_ASSIGN_BED_YN",chgnuinasgnbedyn);
			tabdata.put("ADMIT_PATIENT_WITH_BED_YN",admtpatbedyn);
			tabdata.put("FORCED_BOOK_APPT_YN",forcbkapptyn);
			tabdata.put("GLOBAL_BOOK_APPT_YN",glblbkapptyn);

			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			tabdata.put("register_visit_walkin_yn",register_visit_walkin_yn );
			tabdata.put("register_visit_referral_yn",register_visit_referral_yn );

			tabdata.put("create_wait_list_yn",create_wait_list_yn );
			tabdata.put("modify_wait_list_yn",modify_wait_list_yn );
			tabdata.put("cancel_wait_list_yn",cancel_wait_list_yn );
//cancel checkout
            tabdata.put("cancel_checkout_yn",cancel_checkout_yn );
			tabdata.put("LINK_BABY_TO_MOTHER_YN",LINK_BABY_TO_MOTHER_YN );
			tabdata.put("REG_NEWBORN_FOR_IP_YN",REG_NEWBORN_FOR_IP_YN );
			tabdata.put("DISCHARGE_CHECKLIST_YN",DISCHARGE_CHECKLIST_YN );
			tabdata.put("RESERVE_BED_BAY_YN",RESERVE_BED_BAY_YN );
			tabdata.put("RELEASE_BED_BAY_YN",RELEASE_BED_BAY_YN );
			tabdata.put("REG_IP_REFERRAL_YN",REG_IP_REFERRAL_YN );
			tabdata.put("CONFIRM_BEDSIDE_REFERRAL_YN",CONFIRM_BEDSIDE_REFERRAL_YN );
			tabdata.put("CANCEL_DISCHARGE_YN",cancel_discharge_yn );
			tabdata.put("OVERRIDE_WALKIN_YN",OVERRIDE_WALKIN_YN );

			//15-sep-2008 add cancelreserved bed in hashtable
			tabdata.put("CANCEL_RESERVE_BED_YN",CANCEL_RESERVE_BED_YN );
			tabdata.put("BOOK_APPT_ACROSS_CATG_YN",bookapptacrosscatgyn );
			tabdata.put("DIAG_PROC_RECODE_FOR_OP_YN",diag_proc_recode_for_op_yn);    
		    tabdata.put("DIAG_PROC_RECODE_FOR_IP_YN",diag_proc_recode_for_ip_yn);   
		    tabdata.put("emergency_transfer_yn",emergency_transfer_yn);  

            tabdata.put("quick_admission_yn",quick_admission_yn); 	//this line Added for this CRF Bru-HIMS-CRF-261		
		
			
	

			HashMap condflds=new HashMap();
			condflds.put("oper_stn_id",oper_stn_id);
			condflds.put("facility_id",facilityID);
			condflds.put("appl_user_id",appluserid);
			condflds.put("locn_type",locn_type);
			condflds.put("locn_code",locn_code);
/*
			InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			final java.util.HashMap results = singleTabHandlerManagerRemote.update(p,tabdata,condflds,"am_restrn_for_oper_stn");
*/
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			/*Object argArray[] = new Object[4];
			String table_name="am_restrn_for_oper_stn";
			HashMap hashmap=new HashMap();
			hashmap.put("p",p);
			hashmap.put("tabdata",tabdata);
			hashmap.put("condflds",condflds);
			hashmap.put("table_name",table_name);

			argArray[0] = hashmap;
						
			Class [] paramArray = new Class[1];
			paramArray[0] = hashmap.getClass();*/

								Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
				String table_name="am_restrn_for_oper_stn";
				argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =condflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				//paramArray[0] =hashmap.getClass();
					paramArray[0] =p.getClass();
					paramArray[1] =tabdata.getClass();
					paramArray[2] =condflds.getClass();
					paramArray[3] =table_name.getClass();

			
			HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			//Clears the mapping
			tabdata.clear();
			condflds.clear();
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			//String error_value = "0" ;
			if ( inserted ){
				// error_value = "1" ;
				 out.println("<script>alert(parent.name);</script>");
			}
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  )+"&err_value=0" );

			results.clear();
		}catch ( Exception e ){
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			e.printStackTrace();
		}
	}//E.o.Modify
}//E.o.Class
