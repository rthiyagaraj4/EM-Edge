/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT ;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import eOT.Common.OTAdapter;
import eOT.Common.OTRepository;
public class SetUpParamForFacilityBean extends OTAdapter implements Serializable 
{

	HashMap rows = null;
	String empty = "".intern();

	public SetUpParamForFacilityBean(){
	  rows = new HashMap();
	}

	public void clear(){
		rows=null;
	}

	public void setAll(HashMap hash){
		rows.putAll(hash);
		}

	public HashMap validate() throws Exception 
	{
		HashMap map = new HashMap() ;
		String message = "";
		// Keep here all the Database Validations/Alerts/Warnings before commiting the transaction.
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", message ) ;
		return map;
	}

	public HashMap apply(){
		return ("INSERT".equals( (String) rows.get("mode")) )?insert():modify();
	}

	public String getMode()
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rst = null;
		String mode = "";
		String SQL="SELECT DECODE(COUNT(1),'0','INSERT','UPDATE') FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID=?";
		try
		{
		 connection = getConnection();
          pstmt = connection.prepareStatement(SQL);
		 pstmt.setString(1,login_facility_id);
		 rst = pstmt.executeQuery();
		 while(rst.next()){
			mode = rst.getString(1);
         }//end of while
		}
		catch(Exception e)
		{
		 e.printStackTrace();
	 }
		finally 
		{
			try
			{
			 rst.close();
			 pstmt.close();
			 closeConnection(connection); //COMMON-ICN-0077
			 //connection.close();
		 }
		 catch(Exception e){}
	 }
	 return mode;
	}

	public String getCurrentDate()
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rst = null;
		String date=empty;
		String SQL="SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') AS DAT1 FROM DUAL";
		try
		{
		 connection = getConnection();
         pstmt = connection.prepareStatement(SQL);
		 rst = pstmt.executeQuery();
			while(rst.next())
			date = rst.getString(1);
		}
		catch(Exception e)
		{
		 e.printStackTrace();
	 }
		finally 
		{
			try
			{
			 rst.close();
			 pstmt.close();
			 closeConnection(connection); //COMMON-ICN-0077
			 //connection.close();
		 }
		 catch(Exception e){}
	 }
	 return date;
	}

	public HashMap insert()
	{
		HashMap message = new HashMap();
		String bl_interface_flag=(String)rows.get("bl_interface_flag");
		if("".equals((String)rows.get("bl_interface_flag")))
		bl_interface_flag="N";
		Connection connection=null;
		PreparedStatement pstmt=null;
		int flag = 0;
		StringBuffer saveDetailsBuffer = new StringBuffer();
		String overBooking = "";
		int setIndex = 0; //IN054191
		try
		{
			connection = getConnection();
//			SQL = "INSERT INTO OT_PARAM_FOR_FACILITY(OPERATING_FACILITY_ID,UNIT_OT_TIME,START_OT_BOOKING_TIME, END_OT_BOOKING_TIME,START_HOL_BOOK_TIME,END_HOL_BOOK_TIME,PRINT_BOOKING_SLIP,OT_SEC1_NOTICE_FM_TIME,OT_SEC1_NOTICE_TO_TIME,OT_SEC2_NOTICE_FM_TIME,OT_SEC2_NOTICE_TO_TIME,OT_SEC3_NOTICE_FM_TIME,OT_SEC3_NOTICE_TO_TIME,NEXT_BOOKING_NUM,MAX_BOOKING_NUM,NEXT_WAITLIST_NUM,MAX_WAITLIST_NUM,NEXT_OPER_NUM_IP,MAX_OPER_NUM_IP,NEXT_OPER_NUM_OP,MAX_OPER_NUM_OP,WARN_LIMIT_WAITLIST_DAYS,WARN_UNSCHEDULED_CASES_ONLY,IPBOOKING_WITH_THEATRE_YN,BKG_FIN_ALERT_FOR_OP,BKG_FIN_ALERT_FOR_EM,PAC_REVIEW_ORDERABLE,NO_OF_SWAB_COUNT_REQD,CHK_SURGEON_DOC_CMPL_FOR_STS,CHK_NURSING_DOC_CMPL_FOR_STS,CHK_INTRA_DOC_CMPL_FOR_STS,DISP_LAST_ANTIB_PREOP_YN,BL_INTERFACE_FLAG,CSSD_INTERFACE_YN,SS_DCO_TYPE_CODE,ST_DOC_TYPE_SLI,ST_INTERFACE_FLAG,INV_DOC_TYPE, RESTRICT_THEATRE_BOOKING_YN,ST_DOC_TYPE_RTI,DIARY_SCHED_FOR_SURG_REQD_YN,CUT_OFF_TIME_FOR_ELEC_CASES,RESEQUENCE_REASON_MANDATORY_YN,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,SLATE_LOGIN_REQD_YN,INCLUDE_CASES_FOR_PAST_DAYS,CHECKIN_BACKDATE_LIMIT,OPERATION_SUB_SERVICES_YN,REC_SURG_ACCESSORIES_UNDER,CHARGE_HOLDING_AREA_YN, CHARGE_OPERATING_ROOM_YN, CHARGE_RECOVERY_ROOM_YN,HOLD_FINALIZATION_STAGE,OPER_ROOM_FINALIZATION_STAGE, RECY_ROOM_FINALIZATION_STAGE,REC_IMPLANTS_IN_SURG_NOTES_YN,REC_IMPLANTS_IN_NURS_NOTES_YN,REC_IMPLANTS_IN_ADMIN_YN,FINALIZE_IMPLANTS_IN,REC_EQUP_IN_NURS_NOTES_YN,REC_EQUP_IN_ADMIN_YN,FINALIZE_EQUP_IN,REC_INSTR_IN_NURS_NOTES_YN,REC_INSTR_IN_ADMIN_YN,FINALIZE_INSTR_IN,REC_PACKS_IN_NURS_NOTES_YN,REC_PACKS_IN_ADMIN_YN,FINALIZE_PACKS_IN,OPER_FINALIZATION_STAGE,OH_INTERFACE_FLAG,OH_TASK_CATALOG,CSSD_IMAGE_LOCATION, CSSD_DOC_TYPE_REQ, CSSD_DOC_TYPE_RET, CSSD_STORE_REQ, CSSD_STORE_RET, TAT_FROM_STATUS, TAT_TO_STATUS, TAT_RQ_YN, OVER_BOOKING_WINDOW_USER, MULTI_FACILITY,EXTERNAL_LINK_YN,DISPLAY_HOSPITAL_YN,CHARGES_APPL_CHECKIN_YN,DEF_USER_ROLE,BOOKING_PRIORITY_ORDERS_YN) VALUES(?,TO_DATE(?,'HH24:MI'), TO_DATE(?,'HH24:MI'), TO_DATE(?,'HH24:MI'), TO_DATE(?,'HH24:MI'), TO_DATE(?,'HH24:MI'), NVL(?,'N'), TO_DATE(?,'HH24:MI'), TO_DATE(?,'HH24:MI'), TO_DATE(?,'HH24:MI'), TO_DATE(?,'HH24:MI'), TO_DATE(?,'HH24:MI'), TO_DATE(?,'HH24:MI'),?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,nvl(?,'N'),nvl(?,'N'),nvl(?,'N'),nvl(?,'N'),nvl(?,'N'),nvl(?,'N'),?,?,nvl(?,'N'),?,nvl(?,'N'),?,?,TO_DATE(?,'HH24:MI'),?,?,SYSDATE,?,?,?,SYSDATE,?,?,NVL(?,'N'),?,?,nvl(?,'N'),nvl(?,'N'),nvl(?,'N'),nvl(?,'N'),?,?,?,nvl(?,'N'),nvl(?,'N'),nvl(?,'N'),?,nvl(?,'N'),nvl(?,'N'),?,nvl(?,'N'),nvl(?,'N'),?,nvl(?,'N'),nvl(?,'N'),?,?,?,?,?,?,?,?,?,?,?,?,?,?, NVL(?,'N'),NVL(?,'N'),NVL(?,'N'),NVL(?,'N'),NVL(?,'N')),?";//PMG-CRF-003  booking_priority_orders_yn column for  KDAH-CRF-0283 [IN:050553]

			saveDetailsBuffer.append("	INSERT INTO ot_param_for_facility							");
			saveDetailsBuffer.append("	(operating_facility_id, unit_ot_time, start_ot_booking_time,		");
			saveDetailsBuffer.append("	end_ot_booking_time, start_hol_book_time,		");
			saveDetailsBuffer.append("	end_hol_book_time, print_booking_slip, ot_sec1_notice_fm_time,		");
			saveDetailsBuffer.append("	ot_sec1_notice_to_time, ot_sec2_notice_fm_time,		");
			saveDetailsBuffer.append("	ot_sec2_notice_to_time, ot_sec3_notice_fm_time,		");
			saveDetailsBuffer.append("	ot_sec3_notice_to_time, next_booking_num, max_booking_num,		");
			saveDetailsBuffer.append("	next_waitlist_num, max_waitlist_num, next_oper_num_ip,		");
			saveDetailsBuffer.append("	max_oper_num_ip, next_oper_num_op, max_oper_num_op,		");
			saveDetailsBuffer.append("	warn_limit_waitlist_days, warn_unscheduled_cases_only,		");
			saveDetailsBuffer.append("	ipbooking_with_theatre_yn, bkg_fin_alert_for_op,		");
			saveDetailsBuffer.append("	bkg_fin_alert_for_em, pac_review_orderable,		");
			saveDetailsBuffer.append("	no_of_swab_count_reqd, chk_surgeon_doc_cmpl_for_sts,		");
			saveDetailsBuffer.append("	chk_nursing_doc_cmpl_for_sts, chk_intra_doc_cmpl_for_sts,		");
			saveDetailsBuffer.append("	disp_last_antib_preop_yn, bl_interface_flag, cssd_interface_yn,		");
			saveDetailsBuffer.append("	ss_dco_type_code, st_doc_type_sli, st_interface_flag,		");
			saveDetailsBuffer.append("	inv_doc_type, restrict_theatre_booking_yn, st_doc_type_rti,		");
			saveDetailsBuffer.append("	diary_sched_for_surg_reqd_yn, cut_off_time_for_elec_cases,		");
			saveDetailsBuffer.append("	resequence_reason_mandatory_yn, added_by_id, added_date,		");
			saveDetailsBuffer.append("	added_at_ws_no, added_facility_id, modified_by_id,		");
			saveDetailsBuffer.append("	modified_date, modified_at_ws_no, modified_facility_id,		");
			saveDetailsBuffer.append("	slate_login_reqd_yn, include_cases_for_past_days,		");
			saveDetailsBuffer.append("	checkin_backdate_limit, operation_sub_services_yn,		");
			saveDetailsBuffer.append("	rec_surg_accessories_under, charge_holding_area_yn,		");
			saveDetailsBuffer.append("	charge_operating_room_yn, charge_recovery_room_yn,		");
			saveDetailsBuffer.append("	hold_finalization_stage, oper_room_finalization_stage,		");
			saveDetailsBuffer.append("	recy_room_finalization_stage, rec_implants_in_surg_notes_yn,		");
			saveDetailsBuffer.append("	rec_implants_in_nurs_notes_yn, rec_implants_in_admin_yn,		");
			saveDetailsBuffer.append("	finalize_implants_in, rec_equp_in_nurs_notes_yn,		");
			saveDetailsBuffer.append("	rec_equp_in_admin_yn, finalize_equp_in,		");
			saveDetailsBuffer.append("	rec_instr_in_nurs_notes_yn, rec_instr_in_admin_yn,		");
			saveDetailsBuffer.append("	finalize_instr_in, rec_packs_in_nurs_notes_yn,		");
			saveDetailsBuffer.append("	rec_packs_in_admin_yn, finalize_packs_in,		");
			saveDetailsBuffer.append("	oper_finalization_stage, oh_interface_flag, oh_task_catalog,		");
			saveDetailsBuffer.append("	cssd_image_location, cssd_doc_type_req, cssd_doc_type_ret,		");
			saveDetailsBuffer.append("	cssd_store_req, cssd_store_ret, tat_from_status, tat_to_status,		");
			saveDetailsBuffer.append("	tat_rq_yn, over_booking_window_user, multi_facility,		");
			saveDetailsBuffer.append("	external_link_yn, display_hospital_yn, charges_appl_checkin_yn,		");
			saveDetailsBuffer.append("	def_user_role, booking_priority_orders_yn, Link_Oper_Record_Notes_YN, allwd_swab_cnts,		"); //PMG MOD-0005, IN054191
			saveDetailsBuffer.append("	ammend_bookings, chk_bookings_exist_days, include_blocked_slot, multi_check_in_yn ,");//ML-MMOH-CRF-0337 and PMG2016-KDAH-CRF-0001
			//saveDetailsBuffer.append("	ASA_SCORE, CCS_SCORE , NYHA_SCORE  "); //Added Against ML-MMOH-CRF-1952
			saveDetailsBuffer.append("	Include_fpp_yn,ANES_PROC_START_END_TIME_YN,ANES_START_END_TIME_YN,SURGERY_START_END_TIME_YN,PREPARATION_START_END_TIME_YN,RECORD_SURGEON_NOTES_YN,RECORD_NURSING_NOTES_YN,AUTO_SCHDL_TO_NXTDAY_YN,ALLOW_TO_UPDATE ");//Added Against ML-MMOH-CRF-1939-US1 and ML-MMOH-CRF-1936 and PMG2023-MMS-CRF-0002
			saveDetailsBuffer.append("	)		");
			saveDetailsBuffer.append("	VALUES (?, TO_DATE (?, 'HH24:MI'), TO_DATE (?, 'HH24:MI'),		");
			saveDetailsBuffer.append("	TO_DATE (?, 'HH24:MI'), TO_DATE (?, 'HH24:MI'),		");
			saveDetailsBuffer.append("	TO_DATE (?, 'HH24:MI'), NVL (?, 'N'), TO_DATE (?, 'HH24:MI'),		");
			saveDetailsBuffer.append("	TO_DATE (?, 'HH24:MI'), TO_DATE (?, 'HH24:MI'),		");
			saveDetailsBuffer.append("	TO_DATE (?, 'HH24:MI'), TO_DATE (?, 'HH24:MI'),		");
			saveDetailsBuffer.append("	TO_DATE (?, 'HH24:MI'), ?, ?,		");
			saveDetailsBuffer.append("	?, ?, ?,		");
			saveDetailsBuffer.append("	?, ?, ?,		");
			saveDetailsBuffer.append("	?, ?,		");
			saveDetailsBuffer.append("	?, ?,		");
			saveDetailsBuffer.append("	?, ?,		");
			saveDetailsBuffer.append("	?, NVL (?, 'N'),		");
			saveDetailsBuffer.append("	NVL (?, 'N'), NVL (?, 'N'),		");
			saveDetailsBuffer.append("	NVL (?, 'N'), NVL (?, 'N'), NVL (?, 'N'),		");
			saveDetailsBuffer.append("	?, ?, NVL (?, 'N'),		");
			saveDetailsBuffer.append("	?, NVL (?, 'N'), ?,		");
			saveDetailsBuffer.append("	?, TO_DATE (?, 'HH24:MI'),		");
			saveDetailsBuffer.append("	?, ?, SYSDATE,		");
			saveDetailsBuffer.append("	?, ?, ?,		");
			saveDetailsBuffer.append("	SYSDATE, ?, ?,					");
			saveDetailsBuffer.append("	NVL (?, 'N'), ?,					");
			saveDetailsBuffer.append("	?, NVL (?, 'N'),					");
			saveDetailsBuffer.append("	NVL (?, 'N'), NVL (?, 'N'),		");
			saveDetailsBuffer.append("	NVL (?, 'N'), ?,		");
			saveDetailsBuffer.append("	?, ?,		");
			saveDetailsBuffer.append("	NVL (?, 'N'), NVL (?, 'N'),		");
			saveDetailsBuffer.append("	NVL (?, 'N'), ?,		");
			saveDetailsBuffer.append("	NVL (?, 'N'), NVL (?, 'N'),		");
			saveDetailsBuffer.append("	?, NVL (?, 'N'),		");
			saveDetailsBuffer.append("	NVL (?, 'N'), ?,		");
			saveDetailsBuffer.append("	NVL (?, 'N'), NVL (?, 'N'),		");
			saveDetailsBuffer.append("	?, ?,		");
			saveDetailsBuffer.append("	?, ?, ?,		");
			saveDetailsBuffer.append("	?, ?, ?,		");
			saveDetailsBuffer.append("	?, ?, ?, ?,		");
			saveDetailsBuffer.append("	?, ?, NVL (?, 'N'),		");
			saveDetailsBuffer.append("	NVL (?, 'N'), NVL (?, 'N'), NVL (?, 'N'),		");
			saveDetailsBuffer.append("	NVL (?, 'N'), ?,NVL(?,'N'),?,		");//PMG MOD-0005
			saveDetailsBuffer.append("	?, ?, ?,NVL(?,'N'), ");//ML-MMOH-CRF-0337 and PMG2016-KDAH-CRF-0001
			//saveDetailsBuffer.append("  NVL(?,'N'),NVL(?,'N'),NVL(?,'N'),NVL(?,'N')");//Added Against ML-MMOH-CRF-1952
			saveDetailsBuffer.append(" NVL(?,'N'),NVL(?,'N'),NVL(?,'N'),NVL(?,'N'),NVL(?,'N'),NVL(?,'N'),NVL(?,'N'),NVL(?,'N'),NVL(?,'N') ");//Added Against ML-MMOH-CRF-1939-US1 and ML-MMOH-CRF-1936 and ML-MMOH-CRF-1791 and and PMG2023-MMS-CRF-0002
			saveDetailsBuffer.append("	)		");

			pstmt = connection.prepareStatement(saveDetailsBuffer.toString()); //KDAH-CRF-0283 [IN:050553]
			pstmt.setString(++setIndex, login_facility_id);
			pstmt.setString(++setIndex, (String)rows.get("unit_ot_time"));
			pstmt.setString(++setIndex, (String)rows.get("start_ot_booking_time"));
			pstmt.setString(++setIndex, (String)rows.get("end_ot_booking_time"));
			pstmt.setString(++setIndex, (String)rows.get("start_hol_book_time"));
			pstmt.setString(++setIndex, (String)rows.get("end_hol_book_time"));
			pstmt.setString(++setIndex, (String)rows.get("print_booking_slip"));
			pstmt.setString(++setIndex, (String)rows.get("ot_sec1_notice_fm_time"));
			pstmt.setString(++setIndex, (String)rows.get("ot_sec1_notice_to_time"));
			pstmt.setString(++setIndex, (String)rows.get("ot_sec2_notice_fm_time"));
			pstmt.setString(++setIndex, (String)rows.get("ot_sec2_notice_to_time"));
			pstmt.setString(++setIndex, (String)rows.get("ot_sec3_notice_fm_time"));
			pstmt.setString(++setIndex, (String)rows.get("ot_sec3_notice_to_time"));
			pstmt.setString(++setIndex, (String)rows.get("next_booking_num"));
			pstmt.setString(++setIndex, (String)rows.get("max_booking_num"));
			pstmt.setString(++setIndex, (String)rows.get("next_waitlist_num"));
			pstmt.setString(++setIndex, (String)rows.get("max_waitlist_num"));
			pstmt.setString(++setIndex, (String)rows.get("next_oper_num_ip"));
			pstmt.setString(++setIndex, (String)rows.get("max_oper_num_ip"));
			pstmt.setString(++setIndex, (String)rows.get("next_oper_num_op"));
			pstmt.setString(++setIndex, (String)rows.get("max_oper_num_op"));
			pstmt.setString(++setIndex, getRealvalue((String)rows.get("warn_limit_waitlist_days"), ""));
			pstmt.setString(++setIndex, (String)rows.get("warn_unscheduled_cases_only"));
			pstmt.setString(++setIndex, (String)rows.get("ipbooking_with_theatre_yn"));
			pstmt.setString(++setIndex, (String)rows.get("bkg_fin_alert_for_op"));
			pstmt.setString(++setIndex, (String)rows.get("bkg_fin_alert_for_em"));
			pstmt.setString(++setIndex, (String)rows.get("pac_review_orderable"));
			pstmt.setString(++setIndex, (String)rows.get("no_of_swab_count_reqd"));
			pstmt.setString(++setIndex, (String)rows.get("chk_surgeon_doc_cmpl_for_sts"));
			pstmt.setString(++setIndex, (String)rows.get("chk_nursing_doc_cmpl_for_sts"));
			pstmt.setString(++setIndex, (String)rows.get("chk_intra_doc_cmpl_for_sts"));
			pstmt.setString(++setIndex, (String)rows.get("disp_last_antib_preop_yn"));
			pstmt.setString(++setIndex, (String)rows.get("bl_interface_flag"));
				String cssdInterface="";
				if("on".equals((String)rows.get("cssdInterface")))
					cssdInterface = "Y";
				else
					cssdInterface="N";
			pstmt.setString(++setIndex, cssdInterface);
			pstmt.setString(++setIndex, (String)rows.get("ss_dco_type_code"));
			pstmt.setString(++setIndex, (String)rows.get("st_doc_type_sli")); 
			pstmt.setString(++setIndex, (String)rows.get("st_interface_flag"));
			pstmt.setString(++setIndex, (String)rows.get("inv_doc_type"));
			pstmt.setString(++setIndex, (String)rows.get("restrict_theatre_booking_yn"));
			pstmt.setString(++setIndex, (String)rows.get("st_doc_type_rti"));
			pstmt.setString(++setIndex, (String)rows.get("diary_sched_for_surg_reqd_yn"));
			pstmt.setString(++setIndex, (String)rows.get("booking_cut_off_time_elec_case"));
			pstmt.setString(++setIndex, (String)rows.get("reason_for_rearrange_seqence"));
			pstmt.setString(++setIndex, login_by_id);
			pstmt.setString(++setIndex, login_at_ws_no);
			pstmt.setString(++setIndex, login_facility_id);
			pstmt.setString(++setIndex, login_by_id);
			pstmt.setString(++setIndex, login_at_ws_no);
			pstmt.setString(++setIndex, login_facility_id);
			pstmt.setString(++setIndex, (String)rows.get("slate_login_reqd_yn"));
			pstmt.setString(++setIndex, getRealvalue((String)rows.get("ot_slate_no_of_days"), ""));
			pstmt.setString(++setIndex, getRealvalue((String)rows.get("check_in_backdate_limit_days"), "")); 
				//Newly Including Billing Setup Tab...,
			pstmt.setString(++setIndex, (String)rows.get("billing_sub_services"));
			pstmt.setString(++setIndex, (String)rows.get("admin_func_charging_un"));
			pstmt.setString(++setIndex, (String)rows.get("holding_area_bill_yn"));
			pstmt.setString(++setIndex, (String)rows.get("operating_room_bill_yn"));
			pstmt.setString(++setIndex, (String)rows.get("recovery_room_bill_yn"));
			pstmt.setString(++setIndex, (String)rows.get("holding_area"));
			pstmt.setString(++setIndex, (String)rows.get("operating_room"));
			pstmt.setString(++setIndex, (String)rows.get("recovry_room"));
			pstmt.setString(++setIndex, (String)rows.get("pros_srgn_notes_yn"));
			pstmt.setString(++setIndex, (String)rows.get("pros_nursing_notes_yn"));
			pstmt.setString(++setIndex, (String)rows.get("pros_admin_yn"));
			pstmt.setString(++setIndex, (String)rows.get("pros_imp_val"));
			pstmt.setString(++setIndex, (String)rows.get("equip_nursing_notes_yn"));
			pstmt.setString(++setIndex, (String)rows.get("equip_admin_yn"));
			pstmt.setString(++setIndex, (String)rows.get("equip_val"));
			pstmt.setString(++setIndex, (String)rows.get("cssd_nursing_notes_yn"));
			pstmt.setString(++setIndex, (String)rows.get("cssd_admin_yn"));
			pstmt.setString(++setIndex, (String)rows.get("instr_cssd_val"));
			pstmt.setString(++setIndex, (String)rows.get("cons_nursing_notes_yn"));
			pstmt.setString(++setIndex, (String)rows.get("cons_admin_yn"));
			pstmt.setString(++setIndex, (String)rows.get("consumable_pack_val"));
			pstmt.setString(++setIndex, (String)rows.get("oper_proc_fin_stg"));
			pstmt.setString(++setIndex, (String)rows.get("oh_interface_flag"));
			pstmt.setString(++setIndex, (String)rows.get("oh_task_catalog"));
			pstmt.setString(++setIndex, (String)rows.get("ot_image_cssd"));
			pstmt.setString(++setIndex, (String)rows.get("request_doc_hdn"));
			pstmt.setString(++setIndex, (String)rows.get("return_doc_hdn"));
			pstmt.setString(++setIndex, (String)rows.get("request_store_hdn"));
			pstmt.setString(++setIndex, (String)rows.get("issue_store_hdn"));
			pstmt.setString(++setIndex, (String)rows.get("fromStatus"));
			pstmt.setString(++setIndex, (String)rows.get("toStatus"));
				String turnAround="";
			    if("on".equals((String)rows.get("turnAround")))
					    turnAround = "Y";
			    else
				    turnAround="N";
			pstmt.setString(++setIndex, turnAround);
			    if("on".equals((String)rows.get("overBookingRestriction")))
					    overBooking = "Y";
			    else
				    overBooking="N";
			pstmt.setString(++setIndex, overBooking);
			pstmt.setString(++setIndex, (String)rows.get("multi_facility"));
			pstmt.setString(++setIndex, (String)rows.get("external_link"));
			pstmt.setString(++setIndex, (String)rows.get("display_hospital"));
			pstmt.setString(++setIndex, (String)rows.get("charges_appl_checkin_yn"));//Against 47105
			pstmt.setString(++setIndex, (String)rows.get("default_user_role"));//PMG-CRF-003
			pstmt.setString(++setIndex, (String)rows.get("booking_priority_orders_yn")); //KDAH-CRF-0283 [IN:050553]
			pstmt.setString(++setIndex,(String)rows.get("Link_Operation_And_Notes_in_Record_Surgeon_Notes"));//PMG MOD-0005
			pstmt.setString(++setIndex, (String)rows.get("allwdSwabCnts")); //IN054191
			pstmt.setString(++setIndex, (String)rows.get("chkAmmendBookings"));
			pstmt.setString(++setIndex, (String)rows.get("chkAmmendBookingsDays"));
			pstmt.setString(++setIndex, (String)rows.get("IncludeBlockedSlot"));//ML-MMOH-CRF-0337
			pstmt.setString(++setIndex,(String)rows.get("multicheckinallowed_yn"));//PMG2016-KDAH-CRF-0001
			pstmt.setString(++setIndex, (String)rows.get("Include_fpp"));//Added Against ML-MMOH-CRF-1939-US1
			//Added Against ML-MMOH-CRF-1936-starts
			String AnesProcedureStartEndTimeYN="";
				if("on".equals((String)rows.get("AnesProcedureStartEndTimeYN")))
					AnesProcedureStartEndTimeYN = "Y";
				else
					AnesProcedureStartEndTimeYN="N";
			pstmt.setString(++setIndex, AnesProcedureStartEndTimeYN);
			String AnesStartEndTimeYN="";
				if("on".equals((String)rows.get("AnesStartEndTimeYN")))
					AnesStartEndTimeYN = "Y";
				else
					AnesStartEndTimeYN="N";
			pstmt.setString(++setIndex, AnesStartEndTimeYN);
			String SurgeryStartEndTimeYN="";
				if("on".equals((String)rows.get("SurgeryStartEndTimeYN")))
					SurgeryStartEndTimeYN = "Y";
				else
					SurgeryStartEndTimeYN="N";
			pstmt.setString(++setIndex, SurgeryStartEndTimeYN);
			String PreparationStartEndTimeYN="";
				if("on".equals((String)rows.get("PreparationStartEndTimeYN")))
					PreparationStartEndTimeYN = "Y";
				else
					PreparationStartEndTimeYN="N";
			pstmt.setString(++setIndex, PreparationStartEndTimeYN);
			String RecordSurgeonNotesYN="";
				if("on".equals((String)rows.get("RecordSurgeonNotesYN")))
					RecordSurgeonNotesYN = "Y";
				else
					RecordSurgeonNotesYN="N";
			pstmt.setString(++setIndex, RecordSurgeonNotesYN);
			String RecordNursingNotesYN="";
				if("on".equals((String)rows.get("RecordNursingNotesYN")))
					RecordNursingNotesYN = "Y";
				else
					RecordNursingNotesYN="N";
			pstmt.setString(++setIndex, RecordNursingNotesYN);
			//Added Against ML-MMOH-CRF-1936-ends
			pstmt.setString(++setIndex, (String)rows.get("auto_schdl_to_nxtday_yn"));//Added for ML-MMOH-CRF-1791-US001
			pstmt.setString(++setIndex, (String)rows.get("allow_to_update"));//Added for PMG2023-MMS-CRF-0002
			
			System.err.println(" 349 in insert");
			flag = pstmt.executeUpdate();
			if(flag>0)
			{
			   connection.commit();
			   message.put( "result", new Boolean( true ) ) ;
			   message.put( "message", "RECORD_INSERTED" ) ;
			   message.put( "flag", "1" ) ;
			}
			else
			{
				connection.rollback();
			   message.put( "result", new Boolean( false ) ) ;
			   message.put( "message", "RECORD_FAILED" ) ;
			   message.put( "flag", "0" ) ;
			}
			rows.clear();
		}
		catch(Exception e)
		{
		 e.printStackTrace();
		}
		finally
		{
			try
			{
				pstmt.close();
				closeConnection(connection); //COMMON-ICN-0077
				//connection.close();
		 	}
		 	catch(Exception e){}
		}
		return message;
	}

	public HashMap modify()
	{
		String SQL = "";
		HashMap message = new HashMap();
		HashMap allRows = new HashMap();
		Connection connection=null;
		PreparedStatement pstmt=null;
		int flag = 0;
		try
		{
			connection = getConnection();
			allRows = getAllRows(login_facility_id);
			SQL="UPDATE OT_PARAM_FOR_FACILITY SET UNIT_OT_TIME=TO_DATE(?,'HH24:MI'),START_OT_BOOKING_TIME=TO_DATE(?,'HH24:MI'),END_OT_BOOKING_TIME=TO_DATE(?,'HH24:MI'),START_HOL_BOOK_TIME=TO_DATE(?,'HH24:MI'),END_HOL_BOOK_TIME=TO_DATE(?,'HH24:MI'),PRINT_BOOKING_SLIP=nvl(?,'N'),OT_SEC1_NOTICE_FM_TIME=TO_DATE(?,'HH24:MI'),OT_SEC1_NOTICE_TO_TIME=TO_DATE(?,'HH24:MI'),OT_SEC2_NOTICE_FM_TIME=TO_DATE(?,'HH24:MI'),OT_SEC2_NOTICE_TO_TIME=TO_DATE(?,'HH24:MI'),OT_SEC3_NOTICE_FM_TIME=TO_DATE(?,'HH24:MI'),OT_SEC3_NOTICE_TO_TIME=TO_DATE(?,'HH24:MI'),MAX_BOOKING_NUM=?,MAX_WAITLIST_NUM=?,MAX_OPER_NUM_IP=?,MAX_OPER_NUM_OP=?,RESTRICT_THEATRE_BOOKING_YN=nvl(?,'N'),WARN_LIMIT_WAITLIST_DAYS=?,WARN_UNSCHEDULED_CASES_ONLY=nvl(?,'N'),IPBOOKING_WITH_THEATRE_YN=nvl(?,'N'),BKG_FIN_ALERT_FOR_OP=?,BKG_FIN_ALERT_FOR_EM=?,PAC_REVIEW_ORDERABLE=?,NO_OF_SWAB_COUNT_REQD=?,CHK_SURGEON_DOC_CMPL_FOR_STS=nvl(?,'N'),CHK_NURSING_DOC_CMPL_FOR_STS=nvl(?,'N'),CHK_INTRA_DOC_CMPL_FOR_STS=nvl(?,'N'),DISP_LAST_ANTIB_PREOP_YN=nvl(?,'N'),BL_INTERFACE_FLAG=nvl(?,'N'),CSSD_INTERFACE_YN=nvl(?,'N'),SS_DCO_TYPE_CODE=?,ST_DOC_TYPE_SLI=?,ST_INTERFACE_FLAG=nvl(?,'N'),ST_DOC_TYPE_RTI=?,INV_DOC_TYPE=?,DIARY_SCHED_FOR_SURG_REQD_YN=NVL(?,'N'),CUT_OFF_TIME_FOR_ELEC_CASES=TO_DATE(?,'HH24:MI'),RESEQUENCE_REASON_MANDATORY_YN=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,SLATE_LOGIN_REQD_YN=NVL(?,'N'),INCLUDE_CASES_FOR_PAST_DAYS=?,CHECKIN_BACKDATE_LIMIT=?, OPERATION_SUB_SERVICES_YN=nvl(?,'N'),REC_SURG_ACCESSORIES_UNDER=nvl(?,'N'),CHARGE_HOLDING_AREA_YN=nvl(?,'N'), CHARGE_OPERATING_ROOM_YN=nvl(?,'N'), CHARGE_RECOVERY_ROOM_YN=nvl(?,'N'),HOLD_FINALIZATION_STAGE=?,OPER_ROOM_FINALIZATION_STAGE=?, RECY_ROOM_FINALIZATION_STAGE=?,REC_IMPLANTS_IN_SURG_NOTES_YN=nvl(?,'N'),REC_IMPLANTS_IN_NURS_NOTES_YN=nvl(?,'N'),REC_IMPLANTS_IN_ADMIN_YN=nvl(?,'N'),FINALIZE_IMPLANTS_IN=?,REC_EQUP_IN_NURS_NOTES_YN=nvl(?,'N'),REC_EQUP_IN_ADMIN_YN=nvl(?,'N'),FINALIZE_EQUP_IN=?,REC_INSTR_IN_NURS_NOTES_YN=nvl(?,'N'),REC_INSTR_IN_ADMIN_YN=nvl(?,'N'),FINALIZE_INSTR_IN=?,REC_PACKS_IN_NURS_NOTES_YN=nvl(?,'N'),REC_PACKS_IN_ADMIN_YN=nvl(?,'N'),FINALIZE_PACKS_IN=?,OPER_FINALIZATION_STAGE=?,OH_INTERFACE_FLAG=? ,OH_TASK_CATALOG=?, CSSD_IMAGE_LOCATION =?, CSSD_DOC_TYPE_REQ=?, CSSD_DOC_TYPE_RET=?, CSSD_STORE_REQ=?, CSSD_STORE_RET=?, TAT_FROM_STATUS=?, TAT_TO_STATUS=?, TAT_RQ_YN=?, OVER_BOOKING_WINDOW_USER=?, MULTI_FACILITY = ?,EXTERNAL_LINK_YN=nvl(?,'N'),DISPLAY_HOSPITAL_YN=nvl(?,'N'), charges_appl_checkin_yn = ? ,DEF_USER_ROLE = nvl(?,'N'),booking_priority_orders_yn = nvl(?,'N'),Link_Oper_Record_Notes_YN=nvl(?,'N'), allwd_swab_cnts = ?, ammend_bookings = ?, chk_bookings_exist_days = ?, include_blocked_slot=nvl(?,'N'),multi_check_in_yn=nvl(?,'N'),Include_fpp_yn=nvl(?,'N'),ANES_PROC_START_END_TIME_YN=nvl(?,'N'),ANES_START_END_TIME_YN=nvl(?,'N'),SURGERY_START_END_TIME_YN=nvl(?,'N'),PREPARATION_START_END_TIME_YN=nvl(?,'N'),RECORD_SURGEON_NOTES_YN=nvl(?,'N'),RECORD_NURSING_NOTES_YN=nvl(?,'N'),AUTO_SCHDL_TO_NXTDAY_YN=nvl(?,'N'),ALLOW_TO_UPDATE = nvl(?,'N') WHERE OPERATING_FACILITY_ID=?"; //IN054191 & ML-MMOH-CRF-0337 and PMG2016-KDAH-CRF-0001 and PMG2023-MMS-CRF-0002
			pstmt = connection.prepareStatement(SQL);
				pstmt.setString(1,getRealvalue((String)rows.get("unit_ot_time"),(String)allRows.get("unit_ot_time")));
				pstmt.setString(2,getRealvalue((String)rows.get("start_ot_booking_time"),(String)allRows.get("start_ot_booking_time")));
				pstmt.setString(3,getRealvalue((String)rows.get("end_ot_booking_time"),(String)allRows.get("end_ot_booking_time")));
				pstmt.setString(4,getRealvalue((String)rows.get("start_hol_book_time"),(String)allRows.get("start_hol_book_time")));
				pstmt.setString(5,getRealvalue((String)rows.get("end_hol_book_time"),(String)allRows.get("end_hol_book_time")));
				pstmt.setString(6,getRealvalue((String)rows.get("print_booking_slip"),(String)allRows.get("print_booking_slip")));
				pstmt.setString(7,getRealvalue((String)rows.get("ot_sec1_notice_fm_time"),(String)allRows.get("ot_sec1_notice_fm_time")));
				pstmt.setString(8,getRealvalue((String)rows.get("ot_sec1_notice_to_time"),(String)allRows.get("ot_sec1_notice_to_time")));
				pstmt.setString(9,getRealvalue((String)rows.get("ot_sec2_notice_fm_time"),(String)allRows.get("ot_sec2_notice_fm_time")));
				pstmt.setString(10,getRealvalue((String)rows.get("ot_sec2_notice_to_time"),(String)allRows.get("ot_sec2_notice_to_time")));
				pstmt.setString(11,getRealvalue((String)rows.get("ot_sec3_notice_fm_time"),(String)allRows.get("ot_sec3_notice_fm_time")));
				pstmt.setString(12,getRealvalue((String)rows.get("ot_sec3_notice_to_time"),(String)allRows.get("ot_sec3_notice_to_time")));
				pstmt.setString(13,getRealvalue((String)rows.get("max_booking_num"),(String)allRows.get("max_booking_num")));
				pstmt.setString(14,getRealvalue((String)rows.get("max_waitlist_num"),(String)allRows.get("max_waitlist_num")));
				pstmt.setString(15,getRealvalue((String)rows.get("max_oper_num_ip"),(String)allRows.get("max_oper_num_ip")));
				pstmt.setString(16,getRealvalue((String)rows.get("max_oper_num_op"),(String)allRows.get("max_oper_num_op")));
				pstmt.setString(17,getRealvalue((String)rows.get("restrict_theatre_booking_yn"),(String)allRows.get("restrict_theatre_booking_yn")));
				pstmt.setString(18,getRealvalue((String)rows.get("warn_limit_waitlist_days"),(String)allRows.get("warn_limit_waitlist_days")));
				pstmt.setString(19,getRealvalue((String)rows.get("warn_unscheduled_cases_only"),(String)allRows.get("warn_unscheduled_cases_only")));
				pstmt.setString(20,getRealvalue((String)rows.get("ipbooking_with_theatre_yn"),(String)allRows.get("ipbooking_with_theatre_yn")));
				pstmt.setString(21,getRealvalue((String)rows.get("bkg_fin_alert_for_op"),(String)allRows.get("bkg_fin_alert_for_op")));
				pstmt.setString(22,getRealvalue((String)rows.get("bkg_fin_alert_for_em"),(String)allRows.get("bkg_fin_alert_for_em")));
				pstmt.setString(23,getRealvalue((String)rows.get("pac_review_orderable"),(String)allRows.get("pac_review_orderable")));
				pstmt.setString(24,getRealvalue((String)rows.get("no_of_swab_count_reqd"),(String)allRows.get("no_of_swab_count_reqd")));
				pstmt.setString(25,getRealvalue((String)rows.get("chk_surgeon_doc_cmpl_for_sts"),(String)allRows.get("chk_surgeon_doc_cmpl_for_sts")));
				pstmt.setString(26,getRealvalue((String)rows.get("chk_nursing_doc_cmpl_for_sts"),(String)allRows.get("chk_nursing_doc_cmpl_for_sts")));
				pstmt.setString(27,getRealvalue((String)rows.get("chk_intra_doc_cmpl_for_sts"),(String)allRows.get("chk_intra_doc_cmpl_for_sts")));
				pstmt.setString(28,getRealvalue((String)rows.get("disp_last_antib_preop_yn"),(String)allRows.get("disp_last_antib_preop_yn")));
				pstmt.setString(29,getRealvalue((String)rows.get("bl_interface_flag"),(String)allRows.get("bl_interface_flag")));
				String cssdInterface="";
			    if("on".equals((String)rows.get("cssdInterface")))
				    cssdInterface = "Y";
			    else
				    cssdInterface="N";
				pstmt.setString(30,getRealvalue(cssdInterface,(String)allRows.get("cssd_interface_yn")));
				pstmt.setString(31,getRealvalue((String)rows.get("ss_dco_type_code"),(String)allRows.get("ss_dco_type_code")));
				pstmt.setString(32,getRealvalue((String)rows.get("st_doc_type_sli"),(String)allRows.get("st_doc_type_sli")));
				pstmt.setString(33,getRealvalue((String)rows.get("st_interface_flag"),(String)allRows.get("st_interface_flag")));
				pstmt.setString(34,getRealvalue((String)rows.get("st_doc_type_rti"),(String)allRows.get("st_doc_type_rti")));
				pstmt.setString(35,getRealvalue((String)rows.get("inv_doc_type"),(String)allRows.get("inv_doc_type")));
				pstmt.setString(36,getRealvalue((String)rows.get("diary_sched_for_surg_reqd_yn"),(String)allRows.get("diary_sched_for_surg_reqd_yn")));
				pstmt.setString(37,getRealvalue((String)rows.get("booking_cut_off_time_elec_case"),(String)allRows.get("booking_cut_off_time_elec_case")));
				pstmt.setString(38,getRealvalue((String)rows.get("reason_for_rearrange_seqence"),(String)allRows.get("reason_for_rearrange_seqence")));
				pstmt.setString(39,login_by_id);
				pstmt.setString(40,login_at_ws_no);
				pstmt.setString(41,login_facility_id);
				pstmt.setString(42,getRealvalue((String)rows.get("slate_login_reqd_yn"),(String)allRows.get("slate_login_reqd_yn")));
				pstmt.setString(43,getRealvalue((String)rows.get("ot_slate_no_of_days"),(String)allRows.get("ot_slate_no_of_days")));
				pstmt.setString(44,getRealvalue((String)rows.get("check_in_backdate_limit_days"),(String)allRows.get("check_in_backdate_limit_days")));
				pstmt.setString(45,getRealvalue((String)rows.get("billing_sub_services"),(String)allRows.get("billing_sub_services")));
				pstmt.setString(46,getRealvalue((String)rows.get("admin_func_charging_un"),(String)allRows.get("admin_func_charging_un")));
				pstmt.setString(47,getRealvalue((String)rows.get("holding_area_bill_yn"),(String)allRows.get("holding_area_bill_yn")));
				pstmt.setString(48,getRealvalue((String)rows.get("operating_room_bill_yn"),(String)allRows.get("operating_room_bill_yn")));
				pstmt.setString(49,getRealvalue((String)rows.get("recovery_room_bill_yn"),(String)allRows.get("recovery_room_bill_yn")));
				pstmt.setString(50,getRealvalue((String)rows.get("holding_area"),(String)allRows.get("holding_area")));
				pstmt.setString(51,getRealvalue((String)rows.get("operating_room"),(String)allRows.get("operating_room")));
				pstmt.setString(52,getRealvalue((String)rows.get("recovry_room"),(String)allRows.get("recovry_room")));
				pstmt.setString(53,getRealvalue((String)rows.get("pros_srgn_notes_yn"),(String)allRows.get("pros_srgn_notes_yn")));
				pstmt.setString(54,getRealvalue((String)rows.get("pros_nursing_notes_yn"),(String)allRows.get("pros_nursing_notes_yn")));
				pstmt.setString(55,getRealvalue((String)rows.get("pros_admin_yn"),(String)allRows.get("pros_admin_yn")));
				pstmt.setString(56,getRealvalue((String)rows.get("pros_imp_val"),(String)allRows.get("pros_imp_val")));
				pstmt.setString(57,getRealvalue((String)rows.get("equip_nursing_notes_yn"),(String)allRows.get("equip_nursing_notes_yn")));
				pstmt.setString(58,getRealvalue((String)rows.get("equip_admin_yn"),(String)allRows.get("equip_admin_yn")));
				pstmt.setString(59,getRealvalue((String)rows.get("equip_val"),(String)allRows.get("equip_val")));
				pstmt.setString(60,getRealvalue((String)rows.get("cssd_nursing_notes_yn"),(String)allRows.get("cssd_nursing_notes_yn")));
				pstmt.setString(61,getRealvalue((String)rows.get("cssd_admin_yn"),(String)allRows.get("cssd_admin_yn")));
				pstmt.setString(62,getRealvalue((String)rows.get("instr_cssd_val"),(String)allRows.get("instr_cssd_val")));
				pstmt.setString(63,getRealvalue((String)rows.get("cons_nursing_notes_yn"),(String)allRows.get("cons_nursing_notes_yn")));
				pstmt.setString(64,getRealvalue((String)rows.get("cons_admin_yn"),(String)allRows.get("cons_admin_yn")));
				pstmt.setString(65,getRealvalue((String)rows.get("consumable_pack_val"),(String)rows.get("consumable_pack_val")));
				pstmt.setString(66,getRealvalue((String)rows.get("oper_proc_fin_stg"),(String)allRows.get("oper_proc_fin_stg")));
				pstmt.setString(67,getRealvalue((String)rows.get("oh_interface_flag"),(String)allRows.get("oh_interface_flag")));
				pstmt.setString(68,getRealvalue((String)rows.get("oh_task_catalog"),(String)allRows.get("oh_task_catalog")));
				pstmt.setString(69,getRealvalue((String)rows.get("ot_image_cssd"),(String)allRows.get("ot_image_cssd")));
				pstmt.setString(70,getRealvalue((String)rows.get("request_doc_hdn"),(String)allRows.get("cssd_doc_type_req")));
				pstmt.setString(71,getRealvalue((String)rows.get("return_doc_hdn"),(String)allRows.get("cssd_doc_type_ret")));
				pstmt.setString(72,getRealvalue((String)rows.get("request_store_hdn"),(String)allRows.get("cssd_store_req")));
				pstmt.setString(73,getRealvalue((String)rows.get("issue_store_hdn"),(String)allRows.get("cssd_store_ret")));
				pstmt.setString(74,getRealvalue((String)rows.get("fromStatus"),(String)allRows.get("tat_from_status")));
				pstmt.setString(75,getRealvalue((String)rows.get("toStatus"),(String)allRows.get("tat_to_status")));
				String turnAround="";
			if("on".equals((String)rows.get("turnAround")))
					turnAround = "Y";
			else
				turnAround="N";
				pstmt.setString(76,getRealvalue(turnAround,(String)allRows.get("tat_rq_yn")));
				String overBooking = "";
			if("on".equals((String)rows.get("overBookingRestriction")))
					overBooking = "Y";
			else
				overBooking="N";
				pstmt.setString(77,getRealvalue(overBooking,(String)allRows.get("over_booking_window_user")));
				pstmt.setString(78,getRealvalue((String)rows.get("multi_facility"),(String)allRows.get("multi_facility")));
				pstmt.setString(79,getRealvalue((String)rows.get("external_link"),(String)allRows.get("EXTERNAL_LINK_YN")));
				pstmt.setString(80,getRealvalue((String)rows.get("display_hospital"),(String)allRows.get("DISPLAY_HOSPITAL_YN")));
				if(((String)rows.get("charges_appl_checkin_yn")) != null && ((String)rows.get("charges_appl_checkin_yn")).trim().equalsIgnoreCase("Y"))//047397
					pstmt.setString(81, "Y");
				else
				pstmt.setString(81, "N");
				pstmt.setString(82,getRealvalue((String)rows.get("default_user_role"),(String)allRows.get("DEF_USER_ROLE")));//PMG-CRF-003
				pstmt.setString(83,getRealvalue((String)rows.get("booking_priority_orders_yn"),(String)allRows.get("BOOKING_PRIORITY_ORDERS_YN")));//KDAH-CRF-0283 [IN:050553]
				pstmt.setString(84,getRealvalue((String)rows.get("Link_Operation_And_Notes_in_Record_Surgeon_Notes"),(String)allRows.get("Link_Operation_And_Notes_in_Record_Surgeon_Notes")));//PMG MOD-0005
			pstmt.setString(85,getRealvalue((String)rows.get("allwdSwabCnts"),(String)allRows.get("allwdSwabCnts"))); //IN054191
			pstmt.setString(86, getRealvalue((String)rows.get("chkAmmendBookings"),(String)allRows.get("chkAmmendBookings")));
			pstmt.setString(87, getRealvalue((String)rows.get("chkAmmendBookingsDays"),(String)allRows.get("chkAmmendBookingsDays")));
			pstmt.setString(88, getRealvalue((String)rows.get("IncludeBlockedSlot"),(String)allRows.get("IncludeBlockedSlot")));//ML-MMOH-CRF-0337
			pstmt.setString(89,getRealvalue((String)rows.get("multicheckinallowed_yn"),(String)allRows.get("multicheckinallowed_yn")));//PMG2016-KDAH-CRF-0001
			pstmt.setString(90,getRealvalue((String)rows.get("Include_fpp"),(String)allRows.get("Include_fpp_yn")));//Added Against ML-MMOH-CRF-1939-US1
			//Added Against ML-MMOH-CRF-1936 Starts
			String AnesProcedureStartEndTimeYN="";
			    if("on".equals((String)rows.get("AnesProcedureStartEndTimeYN")))
				    AnesProcedureStartEndTimeYN = "Y";
			    else
				    AnesProcedureStartEndTimeYN="N";
			pstmt.setString(91,getRealvalue(AnesProcedureStartEndTimeYN,(String)allRows.get("ANES_PROC_START_END_TIME_YN")));
			String AnesStartEndTimeYN="";
			    if("on".equals((String)rows.get("AnesStartEndTimeYN")))
				    AnesStartEndTimeYN = "Y";
			    else
				    AnesStartEndTimeYN="N";
			pstmt.setString(92,getRealvalue(AnesStartEndTimeYN,(String)allRows.get("ANES_START_END_TIME_YN")));
			String SurgeryStartEndTimeYN="";
			    if("on".equals((String)rows.get("SurgeryStartEndTimeYN")))
				    SurgeryStartEndTimeYN = "Y";
			    else
				    SurgeryStartEndTimeYN="N";
			pstmt.setString(93,getRealvalue(SurgeryStartEndTimeYN,(String)allRows.get("ANES_START_END_TIME_YN")));
			String PreparationStartEndTimeYN="";
			    if("on".equals((String)rows.get("PreparationStartEndTimeYN")))
				    PreparationStartEndTimeYN = "Y";
			    else
				    PreparationStartEndTimeYN="N";
			pstmt.setString(94,getRealvalue(PreparationStartEndTimeYN,(String)allRows.get("PREPARATION_START_END_TIME_YN")));
			String RecordSurgeonNotesYN="";
			    if("on".equals((String)rows.get("RecordSurgeonNotesYN")))
				    RecordSurgeonNotesYN = "Y";
			    else
				    RecordSurgeonNotesYN="N";
			pstmt.setString(95,getRealvalue(RecordSurgeonNotesYN,(String)allRows.get("RECORD_SURGEON_NOTES_YN")));
			String RecordNursingNotesYN="";
			    if("on".equals((String)rows.get("RecordNursingNotesYN")))
				    RecordNursingNotesYN = "Y";
			    else
				    RecordNursingNotesYN="N";
			pstmt.setString(96,getRealvalue(RecordNursingNotesYN,(String)allRows.get("RECORD_NURSING_NOTES_YN")));
			//Added Against ML-MMOH-CRF-1936-ends
			pstmt.setString(97,getRealvalue((String)rows.get("auto_schdl_to_nxtday_yn"),(String)allRows.get("auto_schdl_to_nxtday_yn")));//Added Against ML-MMOH-CRF-1791-US001
			pstmt.setString(98,getRealvalue((String)rows.get("allow_to_update"),(String)allRows.get("allow_to_update")));//Added Against PMG2023-MMS-CRF-0002
			pstmt.setString(99, login_facility_id);
		flag = pstmt.executeUpdate();
			System.err.println("375,flag===="+flag);
		if(flag>0)
		{
		   connection.commit();
		   message.put( "result", new Boolean( true ) ) ;
		   message.put( "message", "RECORD_INSERTED" ) ;
		   message.put( "flag", "1" ) ;
		}
		else
		{
		   connection.rollback();
		   message.put( "result", new Boolean( false ) ) ;
		   message.put( "message", "RECORD_FAILED" ) ;
		   message.put( "flag", "0" ) ;
		}
		rows.clear();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				pstmt.close();
				closeConnection(connection); //COMMON-ICN-0077
				//connection.close();
			}
			catch(Exception e){}
		}
		return message;
	}

	private HashMap getAllRows(String login_facility_id) 
	{
		// TODO Auto-generated method stub
		HashMap map = new HashMap();
		HashMap fullmap = new HashMap();
		map = getQueryDtls("MainPage",login_facility_id);
		fullmap.putAll(map);
		map = getQueryDtls("OtherDetails",login_facility_id);
		fullmap.putAll(map);
		map = getQueryDtls("BillingSetup",login_facility_id);
		fullmap.putAll(map);
		map = getQueryDtls("AdditionalDetails",login_facility_id);
		fullmap.putAll(map);
		return fullmap;
	}

	public String getRealvalue(String value,String key)
	{
		String retvalue="";
		if(value != null)
			retvalue = value;
		else
			retvalue = key;
		return retvalue;
	}

	public HashMap getQueryDtls(String tab_id,String facility_id)
	{
		HashMap hm_method = new HashMap();
		if("MainPage".equals(tab_id) )
			hm_method=getMainPageDtls(facility_id);
		else if ("OtherDetails".equals(tab_id) )
			hm_method=getOtherPageDtls(facility_id);
		else if ("BillingSetup".equals(tab_id)) 
			hm_method=getBillingSetupPageDtls(facility_id);
		else if ("AdditionalDetails".equals(tab_id)) 
			hm_method=getAdditionalDetailsPageDtls(facility_id);
		return hm_method;
	}

	private HashMap getAdditionalDetailsPageDtls(String facility_id)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rst = null;
		HashMap recordSet = new HashMap();
		String sqlAddDet="SELECT CSSD_INTERFACE_YN,CSSD_DOC_TYPE_REQ,CSSD_DOC_TYPE_RET,CSSD_STORE_REQ,CSSD_STORE_RET,TAT_RQ_YN ,TAT_FROM_STATUS,TAT_TO_STATUS,OVER_BOOKING_WINDOW_USER,ANES_PROC_START_END_TIME_YN,ANES_START_END_TIME_YN,SURGERY_START_END_TIME_YN,PREPARATION_START_END_TIME_YN,RECORD_SURGEON_NOTES_YN,RECORD_NURSING_NOTES_YN FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID=?";
		try
		{
		 connection = getConnection();
         pstmt = connection.prepareStatement(sqlAddDet);
		 pstmt.setString(1,facility_id);
		 int record =0;
		 rst = pstmt.executeQuery();
			while(rst.next())
			{
            ++record;
            recordSet.put("cssd_interface_yn",checkForNull(rst.getString("CSSD_INTERFACE_YN")));
			recordSet.put("cssd_doc_type_req",checkForNull(rst.getString("CSSD_DOC_TYPE_REQ")));
			recordSet.put("cssd_doc_type_ret",checkForNull(rst.getString("CSSD_DOC_TYPE_RET")));
			recordSet.put("cssd_store_req",checkForNull(rst.getString("CSSD_STORE_REQ")));
			recordSet.put("cssd_store_ret",checkForNull(rst.getString("CSSD_STORE_RET")));
			recordSet.put("tat_rq_yn",checkForNull(rst.getString("TAT_RQ_YN")));
			recordSet.put("tat_from_status",checkForNull(rst.getString("TAT_FROM_STATUS")));
			recordSet.put("tat_to_status",checkForNull(rst.getString("TAT_TO_STATUS")));
			recordSet.put("over_booking_window_user",checkForNull(rst.getString("OVER_BOOKING_WINDOW_USER")));
			recordSet.put("AnesProcedureStartEndTimeYN",checkForNull(rst.getString("ANES_PROC_START_END_TIME_YN")));
			recordSet.put("AnesStartEndTimeYN",checkForNull(rst.getString("ANES_START_END_TIME_YN")));
			recordSet.put("SurgeryStartEndTimeYN",checkForNull(rst.getString("SURGERY_START_END_TIME_YN")));
			recordSet.put("PreparationStartEndTimeYN",checkForNull(rst.getString("PREPARATION_START_END_TIME_YN")));
			recordSet.put("RecordSurgeonNotesYN",checkForNull(rst.getString("RECORD_SURGEON_NOTES_YN")));
			recordSet.put("RecordNursingNotesYN",checkForNull(rst.getString("RECORD_NURSING_NOTES_YN")));
		}//end of while
			if(record==0)
			{
			recordSet.put("cssd_interface_yn","");
			recordSet.put("cssd_doc_type_req","");
			recordSet.put("cssd_doc_type_ret","");
			recordSet.put("cssd_store_req","");
			recordSet.put("cssd_store_ret","");
			recordSet.put("tat_rq_yn","");
			recordSet.put("tat_from_status","");
			recordSet.put("tat_to_status","");
			recordSet.put("over_booking_window_user","");
			recordSet.put("AnesProcedureStartEndTimeYN","");
			recordSet.put("AnesStartEndTimeYN","");
			recordSet.put("SurgeryStartEndTimeYN","");
			recordSet.put("PreparationStartEndTimeYN","");
			recordSet.put("RecordSurgeonNotesYN","");
			recordSet.put("RecordNursingNotesYN","");
		}
		}
		catch(Exception e)
		{
		 e.printStackTrace();
	 }
		finally
		{
			try
			{
		 rst.close();
		 pstmt.close();
		 closeConnection(connection); //COMMON-ICN-0077
		 //connection.close();
		 }
		 catch(Exception e){}
	 }
	return recordSet;
	}

	public HashMap getMainPageDtls(String facility_id)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rst = null;
		HashMap recordSet = new HashMap();
		String SQL="SELECT TO_CHAR(UNIT_OT_TIME,'HH24:MI') AS UNIT_OT_TIME,TO_CHAR(START_OT_BOOKING_TIME,'HH24:MI') AS START_OT_BOOKING_TIME, TO_CHAR(END_OT_BOOKING_TIME,'HH24:MI') AS END_OT_BOOKING_TIME, TO_CHAR(START_HOL_BOOK_TIME,'HH24:MI') AS START_HOL_BOOK_TIME,TO_CHAR(END_HOL_BOOK_TIME,'HH24:MI') AS END_HOL_BOOK_TIME,PRINT_BOOKING_SLIP,TO_CHAR(OT_SEC1_NOTICE_FM_TIME,'HH24:MI') AS OT_SEC1_NOTICE_FM_TIME, TO_CHAR(OT_SEC1_NOTICE_TO_TIME,'HH24:MI') AS OT_SEC1_NOTICE_TO_TIME, TO_CHAR(OT_SEC2_NOTICE_FM_TIME,'HH24:MI') AS OT_SEC2_NOTICE_FM_TIME,TO_CHAR(OT_SEC2_NOTICE_TO_TIME,'HH24:MI') AS OT_SEC2_NOTICE_TO_TIME, TO_CHAR(OT_SEC3_NOTICE_FM_TIME,'HH24:MI') AS OT_SEC3_NOTICE_FM_TIME,TO_CHAR(OT_SEC3_NOTICE_TO_TIME,'HH24:MI') AS OT_SEC3_NOTICE_TO_TIME,NEXT_BOOKING_NUM,MAX_BOOKING_NUM,NEXT_WAITLIST_NUM, MAX_WAITLIST_NUM,NEXT_OPER_NUM_IP, MAX_OPER_NUM_IP,NEXT_OPER_NUM_OP, MAX_OPER_NUM_OP,NVL(RESTRICT_THEATRE_BOOKING_YN,'N') RESTRICT_THEATRE_BOOKING_YN, NVL(MULTI_FACILITY,'N')  MULTI_FACILITY FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID=?";
		try
		{
		 connection = getConnection();
         pstmt = connection.prepareStatement(SQL);
		 pstmt.setString(1,facility_id);
		 int record =0;
		 rst = pstmt.executeQuery();

		 while(rst.next())
		 {
            ++record;
            recordSet.put("unit_ot_time",checkForNull(rst.getString("UNIT_OT_TIME")));
			recordSet.put("start_ot_booking_time",checkForNull(rst.getString("START_OT_BOOKING_TIME")));
			recordSet.put("end_ot_booking_time",checkForNull(rst.getString("END_OT_BOOKING_TIME")));
			recordSet.put("start_hol_book_time",checkForNull(rst.getString("START_HOL_BOOK_TIME")));
			recordSet.put("end_hol_book_time",checkForNull(rst.getString("END_HOL_BOOK_TIME")));
			recordSet.put("print_booking_slip",checkForNull(rst.getString("PRINT_BOOKING_SLIP")));
			recordSet.put("ot_sec1_notice_fm_time",checkForNull(rst.getString("OT_SEC1_NOTICE_FM_TIME")));
			recordSet.put("ot_sec1_notice_to_time",checkForNull(rst.getString("OT_SEC1_NOTICE_TO_TIME")));
			recordSet.put("ot_sec2_notice_fm_time",checkForNull(rst.getString("OT_SEC2_NOTICE_FM_TIME")));
			recordSet.put("ot_sec2_notice_to_time",checkForNull(rst.getString("OT_SEC2_NOTICE_TO_TIME")));
			recordSet.put("ot_sec3_notice_fm_time",checkForNull(rst.getString("OT_SEC3_NOTICE_FM_TIME")));
			recordSet.put("ot_sec3_notice_to_time",checkForNull(rst.getString("OT_SEC3_NOTICE_TO_TIME")));
			recordSet.put("next_booking_num",checkForNull(rst.getString("NEXT_BOOKING_NUM")));
			recordSet.put("max_booking_num",checkForNull(rst.getString("MAX_BOOKING_NUM")));
			recordSet.put("next_waitlist_num",checkForNull(rst.getString("NEXT_WAITLIST_NUM")));
			recordSet.put("max_waitlist_num",checkForNull(rst.getString("MAX_WAITLIST_NUM")));
			recordSet.put("next_oper_num_ip",checkForNull(rst.getString("NEXT_OPER_NUM_IP")));
			recordSet.put("max_oper_num_ip",checkForNull(rst.getString("MAX_OPER_NUM_IP")));
			recordSet.put("next_oper_num_op",checkForNull(rst.getString("NEXT_OPER_NUM_OP")));
			recordSet.put("max_oper_num_op",checkForNull(rst.getString("MAX_OPER_NUM_OP")));
			recordSet.put("restrict_theatre_booking_yn",checkForNull(rst.getString("RESTRICT_THEATRE_BOOKING_YN")));
			recordSet.put("multi_facility",checkForNull(rst.getString("multi_facility")));
		}//end of while
		if(record==0)
		{
			recordSet.put("unit_ot_time","");
			recordSet.put("start_ot_booking_time","");
			recordSet.put("end_ot_booking_time","");
			recordSet.put("start_hol_book_time","");
			recordSet.put("end_hol_book_time","");
			recordSet.put("print_booking_slip","");
			recordSet.put("ot_sec1_notice_fm_time","");
			recordSet.put("ot_sec1_notice_to_time","");
			recordSet.put("ot_sec2_notice_fm_time","");
			recordSet.put("ot_sec2_notice_to_time","");
			recordSet.put("ot_sec3_notice_fm_time","");
			recordSet.put("ot_sec3_notice_to_time","");
			recordSet.put("next_booking_num","");
			recordSet.put("max_booking_num","");
			recordSet.put("next_waitlist_num","");
			recordSet.put("max_waitlist_num","");
			recordSet.put("next_oper_num_ip","");
			recordSet.put("max_oper_num_ip","");
			recordSet.put("next_oper_num_op","");
			recordSet.put("max_oper_num_op","");
			recordSet.put("restrict_theatre_booking_yn","");
			recordSet.put("multi_facility","");
		}

		}
		catch(Exception e)
		{
		 e.printStackTrace();
	 }
		finally 
		{
			try
			{
		 rst.close();
		 pstmt.close();
		 closeConnection(connection); //COMMON-ICN-0077
		 //connection.close();
		 }
			catch(Exception e)
			{}
	 }
	return recordSet;
}

	public HashMap getOtherPageDtls(String facility_id)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rst = null;
		HashMap recordSet = new HashMap();
		String SQL="SELECT BL_INTERFACE_FLAG,CSSD_INTERFACE_YN,ST_INTERFACE_FLAG,OH_INTERFACE_FLAG,OH_TASK_CATALOG,SS_DCO_TYPE_CODE,	INV_DOC_TYPE,ST_DOC_TYPE_SLI,ST_DOC_TYPE_RTI,PAC_REVIEW_ORDERABLE,WARN_LIMIT_WAITLIST_DAYS,WARN_UNSCHEDULED_CASES_ONLY,IPBOOKING_WITH_THEATRE_YN,BKG_FIN_ALERT_FOR_OP,BKG_FIN_ALERT_FOR_EM,CHK_SURGEON_DOC_CMPL_FOR_STS,CHK_NURSING_DOC_CMPL_FOR_STS,CHK_INTRA_DOC_CMPL_FOR_STS,DISP_LAST_ANTIB_PREOP_YN,NO_OF_SWAB_COUNT_REQD,DIARY_SCHED_FOR_SURG_REQD_YN,OPERATION_SUB_SERVICES_YN,TO_CHAR(CUT_OFF_TIME_FOR_ELEC_CASES,'HH24:MI') AS CUT_OFF_TIME_FOR_ELEC_CASES,RESEQUENCE_REASON_MANDATORY_YN,SLATE_LOGIN_REQD_YN,INCLUDE_CASES_FOR_PAST_DAYS,CHECKIN_BACKDATE_LIMIT,CSSD_IMAGE_LOCATION,EXTERNAL_LINK_YN,DISPLAY_HOSPITAL_YN,DEF_USER_ROLE,BOOKING_PRIORITY_ORDERS_YN,Link_Oper_Record_Notes_YN, allwd_swab_cnts, ammend_bookings, chk_bookings_exist_days,include_blocked_slot,multi_check_in_yn,Include_fpp_yn,ANES_PROC_START_END_TIME_YN,ANES_START_END_TIME_YN,SURGERY_START_END_TIME_YN,PREPARATION_START_END_TIME_YN,RECORD_SURGEON_NOTES_YN,RECORD_NURSING_NOTES_YN,AUTO_SCHDL_TO_NXTDAY_YN,ALLOW_TO_UPDATE FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID=?"; //IN054191//PMG2016-KDAH-CRF-0001
		try{
		 connection = getConnection();
         pstmt = connection.prepareStatement(SQL);
		 pstmt.setString(1,facility_id);

		 String ss_module_YN = "";
		 rst = pstmt.executeQuery();
		 String pac_code = "";
		 String cssd_code = "";
		 String store_code = "";
		 String doc_code = "";
		 int rec = 0;
		 while(rst.next())
		 {
			 ++rec;
			ss_module_YN = isSSModuleInstalledYN();
            pac_code = checkForNull(rst.getString("PAC_REVIEW_ORDERABLE"));
			cssd_code = checkForNull(rst.getString("ST_DOC_TYPE_SLI")); //-------------------------------->new
			store_code = checkForNull(rst.getString("st_doc_type_rti")); //----------------------->new
		    doc_code = checkForNull(rst.getString("INV_DOC_TYPE"));
			recordSet.put("warn_limit_waitlist_days",checkForNull(rst.getString("WARN_LIMIT_WAITLIST_DAYS")));
			recordSet.put("warn_unscheduled_cases_only",checkForNull(rst.getString("WARN_UNSCHEDULED_CASES_ONLY")));
			recordSet.put("ipbooking_with_theatre_yn",checkForNull(rst.getString("IPBOOKING_WITH_THEATRE_YN")));
			recordSet.put("bkg_fin_alert_for_op",checkForNull(rst.getString("BKG_FIN_ALERT_FOR_OP")));
			recordSet.put("bkg_fin_alert_for_em",checkForNull(rst.getString("BKG_FIN_ALERT_FOR_EM")));
			recordSet.put("pac_review_orderable",checkForNull(rst.getString("PAC_REVIEW_ORDERABLE")));
			recordSet.put("no_of_swab_count_reqd",checkForNull(rst.getString("NO_OF_SWAB_COUNT_REQD")));
			recordSet.put("chk_surgeon_doc_cmpl_for_sts",checkForNull(rst.getString("CHK_SURGEON_DOC_CMPL_FOR_STS")));
			recordSet.put("chk_nursing_doc_cmpl_for_sts",checkForNull(rst.getString("CHK_NURSING_DOC_CMPL_FOR_STS")));
			recordSet.put("chk_intra_doc_cmpl_for_sts",checkForNull(rst.getString("CHK_INTRA_DOC_CMPL_FOR_STS")));
			recordSet.put("disp_last_antib_preop_yn",checkForNull(rst.getString("DISP_LAST_ANTIB_PREOP_YN")));
			recordSet.put("bl_interface_flag",checkForNull(rst.getString("BL_INTERFACE_FLAG")));
			recordSet.put("cssd_interface_yn",checkForNull(rst.getString("CSSD_INTERFACE_YN")));
			recordSet.put("ss_dco_type_code",checkForNull(rst.getString("SS_DCO_TYPE_CODE")));
			recordSet.put("st_doc_type_sli",checkForNull(rst.getString("ST_DOC_TYPE_SLI"))); //------------------------------->new
			recordSet.put("st_doc_type_rti",checkForNull(rst.getString("ST_DOC_TYPE_RTI"))); //------------------------------->new
			recordSet.put("st_interface_flag",checkForNull(rst.getString("ST_INTERFACE_FLAG")));
			recordSet.put("oh_interface_flag",checkForNull(rst.getString("OH_INTERFACE_FLAG")));//----Added by Suma For CRF 707
			recordSet.put("oh_task_catalog",checkForNull(rst.getString("OH_TASK_CATALOG")));//----Added by Suma For CRF 707
			recordSet.put("inv_doc_type",checkForNull(rst.getString("INV_DOC_TYPE")));
			recordSet.put("genpac_desc",checkForNull(getReviewOrderableDesc(pac_code)));
			recordSet.put("st_doc_type_sli_desc",getCSSDDesc(cssd_code));
			recordSet.put("st_doc_type_rti_desc",getSTOREDesc(store_code)); //Newly added to retreive DefaultStoreDesc on 06/08 by rajesh
			recordSet.put("doc_desc",getDocTypeDesc(doc_code));
			recordSet.put("ss_module_YN",checkForNull(ss_module_YN,"N"));
			recordSet.put("diary_sched_for_surg_reqd_yn",checkForNull(rst.getString("DIARY_SCHED_FOR_SURG_REQD_YN"),"N"));
			recordSet.put("booking_cut_off_time_elec_case",checkForNull(rst.getString("CUT_OFF_TIME_FOR_ELEC_CASES")));
			recordSet.put("reason_for_rearrange_seqence",checkForNull(rst.getString("RESEQUENCE_REASON_MANDATORY_YN")));
			recordSet.put("slate_login_reqd_yn",checkForNull(rst.getString("SLATE_LOGIN_REQD_YN")));
			recordSet.put("ot_slate_no_of_days",checkForNull(rst.getString("INCLUDE_CASES_FOR_PAST_DAYS")));
			recordSet.put("check_in_backdate_limit_days",checkForNull(rst.getString("CHECKIN_BACKDATE_LIMIT")));
			recordSet.put("ot_image_cssd",checkForNull(rst.getString("CSSD_IMAGE_LOCATION")));
			recordSet.put("external_link",checkForNull(rst.getString("EXTERNAL_LINK_YN")));
			recordSet.put("display_hospital",checkForNull(rst.getString("DISPLAY_HOSPITAL_YN")));
			recordSet.put("default_user_role",checkForNull(rst.getString("DEF_USER_ROLE")));//PMG-CRF-003
			recordSet.put("booking_priority_orders_yn",checkForNull(rst.getString("BOOKING_PRIORITY_ORDERS_YN")));//KDAH-CRF-0283 [IN:050553]
			recordSet.put("Link_Operation_And_Notes_in_Record_Surgeon_Notes",checkForNull(rst.getString("Link_Oper_Record_Notes_YN")));//PMG-MOD-0005
			recordSet.put("allwdSwabCnts", checkForNull(rst.getString("allwd_swab_cnts")) == "" ? "3" : checkForNull(rst.getString("allwd_swab_cnts"))); //IN054191
			recordSet.put("chkAmmendBookings",checkForNull(rst.getString("ammend_bookings")));
			recordSet.put("chkAmmendBookingsDays",checkForNull(rst.getString("chk_bookings_exist_days")));
			recordSet.put("IncludeBlockedSlot",checkForNull(rst.getString("include_blocked_slot"))); //ML-MMOH-CRF-0337
			recordSet.put("multiCheckInAllowed_YN",checkForNull(rst.getString("multi_check_in_yn"))); //PMG2016-KDAH-CRF-0001
			recordSet.put("Include_fpp",checkForNull(rst.getString("Include_fpp_yn"))); // Added Against ML-MMOH-CRF-1939-US1
			recordSet.put("AnesProcedureStartEndTimeYN",checkForNull(rst.getString("ANES_PROC_START_END_TIME_YN"))); // Added Against ML-MMOH-CRF-1936
			recordSet.put("AnesStartEndTimeYN",checkForNull(rst.getString("ANES_START_END_TIME_YN"))); // Added Against ML-MMOH-CRF-1936
			recordSet.put("SurgeryStartEndTimeYN",checkForNull(rst.getString("SURGERY_START_END_TIME_YN"))); // Added Against ML-MMOH-CRF-1936
			recordSet.put("PreparationStartEndTimeYN",checkForNull(rst.getString("PREPARATION_START_END_TIME_YN"))); // Added Against ML-MMOH-CRF-1936
			recordSet.put("RecordSurgeonNotesYN",checkForNull(rst.getString("RECORD_SURGEON_NOTES_YN"))); // Added Against ML-MMOH-CRF-1936
			recordSet.put("RecordNursingNotesYN",checkForNull(rst.getString("RECORD_NURSING_NOTES_YN"))); // Added Against ML-MMOH-CRF-1936
			recordSet.put("auto_schdl_to_nxtday_yn",checkForNull(rst.getString("auto_schdl_to_nxtday_yn"))); // Added Against ML-MMOH-CRF-1791
			recordSet.put("allow_to_update",checkForNull(rst.getString("allow_to_update"))); // Added Against PMG2023-MMS-CRF-0002
		}
		if(rec==0)
		{
			ss_module_YN = isSSModuleInstalledYN();
            recordSet.put("warn_limit_waitlist_days","");
			recordSet.put("warn_unscheduled_cases_only","");
			recordSet.put("ipbooking_with_theatre_yn","");
			recordSet.put("bkg_fin_alert_for_op","");
			recordSet.put("bkg_fin_alert_for_em","");
			recordSet.put("pac_review_orderable","");
			recordSet.put("no_of_swab_count_reqd","2"); // Added Against PMG2017-MO-CRF-0001 [IN:063849]
			recordSet.put("chk_surgeon_doc_cmpl_for_sts","");
			recordSet.put("chk_nursing_doc_cmpl_for_sts","");
			recordSet.put("chk_intra_doc_cmpl_for_sts","");
			recordSet.put("disp_last_antib_preop_yn","");
			recordSet.put("bl_interface_flag","");
			recordSet.put("cssd_interface_yn","");
			recordSet.put("ss_dco_type_code","");
			recordSet.put("st_doc_type_sli","");
			recordSet.put("st_doc_type_rti","");
			recordSet.put("st_interface_flag","");
			recordSet.put("oh_interface_flag","");
			recordSet.put("oh_task_catalog","");
			recordSet.put("inv_doc_type","");
			recordSet.put("genpac_desc","");
			recordSet.put("st_doc_type_sli_desc","");
			recordSet.put("st_doc_type_rti_desc","");
			recordSet.put("doc_desc","");
			recordSet.put("ss_module_YN",checkForNull(ss_module_YN,"N"));
			recordSet.put("ss_module_YN",checkForNull(ss_module_YN,"N"));
			recordSet.put("diary_sched_for_surg_reqd_yn","N");
			recordSet.put("booking_cut_off_time_elec_case","");
			recordSet.put("reason_for_rearrange_seqence","N");
			recordSet.put("slate_login_reqd_yn","");
			recordSet.put("ot_slate_no_of_days","");
			recordSet.put("check_in_backdate_limit_days","");
			recordSet.put("ot_image_cssd","");
			recordSet.put("external_link","");
			recordSet.put("display_hospital","");
			recordSet.put("default_user_role","");//PMG-CRF-003
			recordSet.put("booking_priority_orders_yn","N");//KDAH-CRF-0283 [IN:050553]
			recordSet.put("Link_Operation_And_Notes_in_Record_Surgeon_Notes","Y");//PMG-MOD-0005
			recordSet.put("allwdSwabCnts","3"); //IN054191
			recordSet.put("chkAmmendBookings", "N");
			recordSet.put("chkAmmendBookingsDays", "");
			recordSet.put("IncludeBlockedSlot", "N");//ML-MMOH-CRF-0337
			recordSet.put("multiCheckInAllowed_YN", "");//PMG2016-KDAH-CRF-0001
			recordSet.put("Include_fpp","N"); // Added Against ML-MMOH-CRF-1939-US1
			recordSet.put("AnesProcedureStartEndTimeYN", ""); // Added Against ML-MMOH-CRF-1936
			recordSet.put("AnesStartEndTimeYN", ""); // Added Against ML-MMOH-CRF-1936
			recordSet.put("SurgeryStartEndTimeYN", ""); // Added Against ML-MMOH-CRF-1936
			recordSet.put("PreparationStartEndTimeYN", ""); // Added Against ML-MMOH-CRF-1936
			recordSet.put("RecordSurgeonNotesYN", ""); // Added Against ML-MMOH-CRF-1936
			recordSet.put("RecordNursingNotesYN", ""); // Added Against ML-MMOH-CRF-1936
			recordSet.put("auto_schdl_to_nxtday_yn", ""); // Added Against ML-MMOH-CRF-1791
			recordSet.put("allow_to_update", ""); // Added Against PMG2023-MMS-CRF-0002
		}
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 finally {
		 try{
			rst.close();
			pstmt.close();
			closeConnection(connection); //COMMON-ICN-0077
			//connection.close();
		 }
		 catch(Exception e){}
	 }
	return recordSet;
 }

public HashMap getBillingSetupPageDtls(String facility_id){
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rst = null;
		HashMap recordSet = new HashMap();
		//String SQL="SELECT OPERATION_SUB_SERVICES_YN,REC_SURG_ACCESSORIES_UNDER,CHARGE_HOLDING_AREA_YN, CHARGE_OPERATING_ROOM_YN, CHARGE_RECOVERY_ROOM_YN,HOLD_FINALIZATION_STAGE,OPER_ROOM_FINALIZATION_STAGE, RECY_ROOM_FINALIZATION_STAGE,REC_IMPLANTS_IN_SURG_NOTES_YN,REC_IMPLANTS_IN_NURS_NOTES_YN,REC_IMPLANTS_IN_ADMIN_YN,FINALIZE_IMPLANTS_IN,REC_EQUP_IN_NURS_NOTES_YN,REC_EQUP_IN_ADMIN_YN,FINALIZE_EQUP_IN,REC_INSTR_IN_NURS_NOTES_YN,REC_INSTR_IN_ADMIN_YN,FINALIZE_INSTR_IN,REC_PACKS_IN_NURS_NOTES_YN,REC_PACKS_IN_ADMIN_YN,FINALIZE_PACKS_IN,OPER_FINALIZATION_STAGE, charges_appl_checkin_yn FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID=?";
		StringBuffer billingSetupDetBuffer = new StringBuffer();
		int rec = 0;
		try
		{
		 connection = getConnection();

			billingSetupDetBuffer.append("	SELECT operation_sub_services_yn, rec_surg_accessories_under,	");
			billingSetupDetBuffer.append("	charge_holding_area_yn, charge_operating_room_yn,	");
			billingSetupDetBuffer.append("	charge_recovery_room_yn, hold_finalization_stage,	");
			billingSetupDetBuffer.append("	oper_room_finalization_stage, recy_room_finalization_stage,	");
			billingSetupDetBuffer.append("	rec_implants_in_surg_notes_yn, rec_implants_in_nurs_notes_yn,	");
			billingSetupDetBuffer.append("	rec_implants_in_admin_yn, finalize_implants_in,	");
			billingSetupDetBuffer.append("	rec_equp_in_nurs_notes_yn, rec_equp_in_admin_yn, finalize_equp_in,	");
			billingSetupDetBuffer.append("	rec_instr_in_nurs_notes_yn, rec_instr_in_admin_yn, finalize_instr_in,	");
			billingSetupDetBuffer.append("	rec_packs_in_nurs_notes_yn, rec_packs_in_admin_yn, finalize_packs_in,	");
			billingSetupDetBuffer.append("	oper_finalization_stage, charges_appl_checkin_yn , Include_fpp_yn, ANES_PROC_START_END_TIME_YN,ANES_START_END_TIME_YN,SURGERY_START_END_TIME_YN,PREPARATION_START_END_TIME_YN,RECORD_SURGEON_NOTES_YN,RECORD_NURSING_NOTES_YN ");//Added against ML-MMOH-CRF-1939--US1 and ML-MMOH-CRF-1936
			billingSetupDetBuffer.append("	FROM ot_param_for_facility	");
			billingSetupDetBuffer.append("	WHERE operating_facility_id = ?	");

			pstmt = connection.prepareStatement(billingSetupDetBuffer.toString());
			System.out.println("========facility_id====getBillingSetupPageDtls==="+facility_id);
		 pstmt.setString(1,facility_id);
		 rst = pstmt.executeQuery();
			while(rst.next())
			{
			 ++rec;
			recordSet.put("billing_sub_services",checkForNull(rst.getString("OPERATION_SUB_SERVICES_YN")));
			recordSet.put("admin_func_charging_un",checkForNull(rst.getString("REC_SURG_ACCESSORIES_UNDER")));
			recordSet.put("holding_area_bill_yn",checkForNull(rst.getString("CHARGE_HOLDING_AREA_YN")));
			recordSet.put("operating_room_bill_yn",checkForNull(rst.getString("CHARGE_OPERATING_ROOM_YN")));
			recordSet.put("recovery_room_bill_yn",checkForNull(rst.getString("CHARGE_RECOVERY_ROOM_YN")));
			recordSet.put("holding_area",checkForNull(rst.getString("HOLD_FINALIZATION_STAGE")));
			recordSet.put("operating_room",checkForNull(rst.getString("OPER_ROOM_FINALIZATION_STAGE")));
			recordSet.put("recovry_room",checkForNull(rst.getString("RECY_ROOM_FINALIZATION_STAGE")));
			recordSet.put("pros_srgn_notes_yn",checkForNull(rst.getString("REC_IMPLANTS_IN_SURG_NOTES_YN")));
			recordSet.put("pros_nursing_notes_yn",checkForNull(rst.getString("REC_IMPLANTS_IN_NURS_NOTES_YN")));
			recordSet.put("pros_admin_yn",checkForNull(rst.getString("REC_IMPLANTS_IN_ADMIN_YN")));
			recordSet.put("pros_imp_val",checkForNull(rst.getString("FINALIZE_IMPLANTS_IN")));
			recordSet.put("equip_nursing_notes_yn",checkForNull(rst.getString("REC_EQUP_IN_NURS_NOTES_YN")));
			recordSet.put("equip_admin_yn",checkForNull(rst.getString("REC_EQUP_IN_ADMIN_YN")));
			recordSet.put("equip_val",checkForNull(rst.getString("FINALIZE_EQUP_IN")));
			recordSet.put("cssd_nursing_notes_yn",checkForNull(rst.getString("REC_INSTR_IN_NURS_NOTES_YN")));
			recordSet.put("cssd_admin_yn",checkForNull(rst.getString("REC_INSTR_IN_ADMIN_YN")));
			recordSet.put("instr_cssd_val",checkForNull(rst.getString("FINALIZE_INSTR_IN")));
			recordSet.put("cons_nursing_notes_yn",checkForNull(rst.getString("REC_PACKS_IN_NURS_NOTES_YN")));
			recordSet.put("cons_admin_yn",checkForNull(rst.getString("REC_PACKS_IN_ADMIN_YN")));
			recordSet.put("consumable_pack_val",checkForNull(rst.getString("FINALIZE_PACKS_IN")));
			recordSet.put("oper_proc_fin_stg",checkForNull(rst.getString("OPER_FINALIZATION_STAGE")));
			recordSet.put("charges_appl_checkin_yn",checkForNull(rst.getString("charges_appl_checkin_yn")));
			recordSet.put("Include_fpp",checkForNull(rst.getString("INCLUDE_FPP_YN")));//Added against ML-MMOH-CRF-1939-US1
			recordSet.put("AnesProcedureStartEndTimeYN",checkForNull(rst.getString("ANES_PROC_START_END_TIME_YN")));//Added against ML-MMOH-CRF-1936
			recordSet.put("AnesStartEndTimeYN",checkForNull(rst.getString("ANES_START_END_TIME_YN")));//Added against ML-MMOH-CRF-1936
			recordSet.put("SurgeryStartEndTimeYN",checkForNull(rst.getString("SURGERY_START_END_TIME_YN")));//Added against ML-MMOH-CRF-1936
			recordSet.put("PreparationStartEndTimeYN",checkForNull(rst.getString("PREPARATION_START_END_TIME_YN")));//Added against ML-MMOH-CRF-1936
			recordSet.put("RecordSurgeonNotesYN",checkForNull(rst.getString("RECORD_SURGEON_NOTES_YN")));//Added against ML-MMOH-CRF-1936
			recordSet.put("RecordNursingNotesYN",checkForNull(rst.getString("RECORD_NURSING_NOTES_YN")));//Added against ML-MMOH-CRF-1936
		}//end of while
			if(rec==0)
			{
	        recordSet.put("billing_sub_services","");
			recordSet.put("admin_func_charging_un","");
			recordSet.put("holding_area_bill_yn","");
			recordSet.put("operating_room_bill_yn","");
			recordSet.put("recovery_room_bill_yn","");
			recordSet.put("holding_area","");
			recordSet.put("operating_room","1");
			recordSet.put("recovry_room","");
			recordSet.put("pros_srgn_notes_yn","");
			recordSet.put("pros_nursing_notes_yn","");
			recordSet.put("pros_admin_yn","");
			recordSet.put("pros_imp_val","");
			recordSet.put("equip_nursing_notes_yn","");
			recordSet.put("equip_admin_yn","");
			recordSet.put("equip_val","");
			recordSet.put("cssd_nursing_notes_yn","");
			recordSet.put("cssd_admin_yn","");
			recordSet.put("instr_cssd_val","");
			recordSet.put("cons_nursing_notes_yn","");
			recordSet.put("cons_admin_yn","");
			recordSet.put("consumable_pack_val","");
			recordSet.put("oper_proc_fin_stg","");
			recordSet.put("charges_appl_checkin_yn", "");
			recordSet.put("Include_fpp","");//Added against ML-MMOH-CRF-1939-US1
			recordSet.put("AnesProcedureStartEndTimeYN","");//Added against ML-MMOH-CRF-1936
			recordSet.put("AnesStartEndTimeYN","");//Added against ML-MMOH-CRF-1936
			recordSet.put("SurgeryStartEndTimeYN","");//Added against ML-MMOH-CRF-1936
			recordSet.put("PreparationStartEndTimeYN","");//Added against ML-MMOH-CRF-1936
			recordSet.put("RecordSurgeonNotesYN","");//Added against ML-MMOH-CRF-1936
			recordSet.put("RecordNursingNotesYN","");//Added against ML-MMOH-CRF-1936
		}
		}
		catch(Exception e)
		{
		 e.printStackTrace();
	 }
		finally
		{
			try
			{
			rst.close();
			pstmt.close();
			closeConnection(connection); //COMMON-ICN-0077
			//connection.close();
		 }
		 catch(Exception e){}
	 }
	return recordSet;
 }

 public String getReviewOrderableDesc(String code){
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rst = null;
		String desc=empty;
		String SQL="SELECT LONG_DESC FROM OR_ORDER_CATALOG WHERE ORDER_CATALOG_CODE = ? ";
		try{
		 connection = getConnection();
         pstmt = connection.prepareStatement(SQL);
		 pstmt.setString(1,code);
		 rst = pstmt.executeQuery();
		 while(rst.next()){
			desc = rst.getString(1);
         }//end of while
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 finally {
		 try{
			 rst.close();
			 pstmt.close();
			 closeConnection(connection); //COMMON-ICN-0077
			 //connection.close();
		 }
		 catch(Exception e){}
	 }
	 return desc;
	}

	public String getCSSDDesc(String code){
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rst = null;
		String desc=empty;
		String SQL="SELECT SHORT_DESC FROM MM_STORE WHERE STORE_CODE = ?";
		//SELECT ST.DOC_TYPE_CODE CODE ,SY.SHORT_DESC DESCRIPTION FROM ST_TRN_DOC_TYPE ST,SY_DOC_TYPE_MASTER_LANG_VW SY WHERE T.DOC_TYPE_CODE='HSSAL' AND ST.DOC_TYPE_CODE = SY.DOC_TYPE_CODE AND SY.LANGUAGE_ID='en' AND ST.FACILITY_ID='HS'
		try{
		 connection = getConnection();
         pstmt = connection.prepareStatement(SQL);
		 pstmt.setString(1,code);
		 rst = pstmt.executeQuery();
		 while(rst.next()){
			desc = rst.getString(1);
         }//end of while
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 finally {
		 try{
			 rst.close();
			 pstmt.close();
			 closeConnection(connection); //COMMON-ICN-0077
			 //connection.close();
		 }
		 catch(Exception e){}
	 }
	 return desc;
	}


public String getSTOREDesc(String code){
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rst = null;
		String desc=empty;
		String SQL="SELECT SHORT_DESC FROM MM_STORE WHERE STORE_CODE = ?";
		try{
		 connection = getConnection();
         pstmt = connection.prepareStatement(SQL);
		 pstmt.setString(1,code);
		 rst = pstmt.executeQuery();
		 while(rst.next()){
			desc = rst.getString(1);
         }//end of while
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 finally {
		 try{
			 rst.close();
			 pstmt.close();
			 closeConnection(connection); //COMMON-ICN-0077
			 //connection.close();
		 }
		 catch(Exception e){}
	 }
	 return desc;
	}
	 public String getDocTypeDesc(String code){
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rst = null;
		String desc=empty;
		String SQL="SELECT SHORT_DESC FROM SY_DOC_TYPE_MASTER WHERE doc_type_code = ? ";
		try{
		 connection = getConnection();
         pstmt = connection.prepareStatement(SQL);
		 pstmt.setString(1,code);
		 rst = pstmt.executeQuery();
		 while(rst.next()){
			desc = rst.getString(1);
         }//end of while
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 finally {
		 try{
			 rst.close();
			 pstmt.close();
			 closeConnection(connection); //COMMON-ICN-0077
			 //connection.close();
		 }
		 catch(Exception e){}
	 }
	 return desc;
	}

	public String isSSModuleInstalledYN(){
		Connection con=null;
		CallableStatement cstmt = null;
		String modules_list = "";
		String ss_module_yn="";
		try{
			con = getConnection();
			// Check for CA Module Existence
			cstmt=con.prepareCall("{call GET_OPERATIONAL_MODULES(?,?)}");
			cstmt.setString(1,login_facility_id);
			cstmt.registerOutParameter(2,12);
			cstmt.execute();
			modules_list=cstmt.getString(2);
			if(modules_list.indexOf("SS|")>=0)
				ss_module_yn="Y";	// When CA is  Operational
			else
				ss_module_yn="N";	// When CA is not Operational
		}catch(Exception e){
		 e.printStackTrace();
		}finally {
			try{
				if(cstmt !=null) cstmt.close();
				closeConnection(con); //COMMON-ICN-0077
				//if(con!=null)con.close();
			}catch(Exception e){}
		}
		return ss_module_yn;
	}

	public boolean fetchCustomerId()
	{
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;//MO-CRF-20106
		ResultSet rst = null;
		ResultSet rst1 = null;//MO-CRF-20106
		Connection con = null;
		try
		{
			con = getConnection();
			//MO-CRF-20106
			String siteParamSQL="";
			String customer_id="";
			String sql_customerId="Select customer_id from SM_SITE_PARAM where rownum = 1";
			pstmt1=con.prepareStatement(sql_customerId);
			rst1=pstmt1.executeQuery();
			if(rst1 !=null && rst1.next())
				customer_id=checkForNull(rst1.getString("customer_id"));				
			if(rst1!=null)
				rst1.close();
			if(pstmt1!=null)
				pstmt1.close();
			
			if(customer_id.equalsIgnoreCase("MOD"))
			{
				siteParamSQL = OTRepository.getOTKeyValue("ALT_FAC_SITE_SETTING_MOD");				
			}else if (customer_id.equalsIgnoreCase("MOHBR"))
			{
				siteParamSQL = OTRepository.getOTKeyValue("ALT_FAC_SITE_SETTING");				
			}
			//MO-CRF-20106
			
			pstmt = con.prepareStatement(siteParamSQL);			
			rst = pstmt.executeQuery();
			
			if(rst !=null && rst.next())
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(pstmt !=null) pstmt.close();
				if(rst !=null) rst.close();
				closeConnection(con); //COMMON-ICN-0077
				//if(con!=null)con.close();
			}
			catch(Exception e){}
		}
		return false;
	}

}
