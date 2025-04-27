/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOP.OPClinic;

import java.rmi.*;
import java.io.*;
import javax.ejb.*;
import java.sql.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.ArrayList;
import webbeans.eCommon.*;



/**
*
* @ejb.bean
*	name="OPClinic"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="OPClinic"
*	local-jndi-name="OPClinic"
*	impl-class-name="eOP.OPClinic.OPClinicManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOP.OPClinic.OPClinicManagerLocal"
*	remote-class="eOP.OPClinic.OPClinicManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOP.OPClinic.OPClinicManagerLocalHome"
*	remote-class="eOP.OPClinic.OPClinicManagerHome"
*	generate= "local,remote"
*
*
*/



public class OPClinicManager implements SessionBean {

	Connection con;

	PreparedStatement pstmt;

	String addedById = "";

	String addedDate = "";

	String modifiedById = "";

	String modifiedDate = "";

	String modifiedFacilityId = "";

	String modifiedAtWorkstation = "";

	Date added_date = null;

	Date modified_date = null;

	String practtype = "";

   	String CATEGORY="";
	String locale = "";
	int display_order=0;
	String pat_ins_id="";
	String default_yn="";
	String pat_ins_sql="";
	String pat_ins_sql_del="";
	ArrayList pat_ins_bean_ejb = new ArrayList();

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
			"yyyy-MM-dd");

	//public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS";

	//public final String RECORD_INSERTED = "RECORD_INSERTED";

	//public final String RECORD_MODIFIED = "RECORD_MODIFIED";

	public void ejbCreate() {
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void setSessionContext(SessionContext context) {
	}

	
		/**
	 *Method to insert single record
	 *@param properties Connection Properties
	 *@param hashaMap Record data 
	 *@param as data for duplication check
	 *@param s Table Name
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public java.util.HashMap insertOPClinic(java.util.Properties p,
			java.util.HashMap tabdata) {
		java.util.HashMap results = new java.util.HashMap();
		boolean result = false;
		boolean insertable = true;
		locale = p.getProperty("LOCALE");
		StringBuffer sb = new StringBuffer();
		String callfunc = (String) tabdata.get("callfunc");

		StringBuffer sql = new StringBuffer();
		
		String isAlertApplicableforBookAppt = (String) tabdata.get("isAlertApplicableforBookAppt"); // added by mujafar for GHL-CRF-0527
		 CATEGORY=(String) tabdata.get("CATEGORY");

		sql
				.append("insert into op_clinic(facility_id,clinic_code,long_desc, short_desc,clinic_type,");
		sql
				.append("working_week_appl_day_1, working_week_appl_day_2,working_week_appl_day_3,working_week_appl_day_4,working_week_appl_day_5,working_week_appl_day_6,working_week_appl_day_7,");
		sql
				.append("working_day_1,working_day_2,working_day_3,working_day_4,working_day_5,working_day_6,working_day_7,");
		sql
				.append(" working_week_1_day_1,	working_week_1_day_2,working_week_1_day_3,	working_week_1_day_4,working_week_1_day_5,	working_week_1_day_6, working_week_1_day_7,");
		sql
				.append(" working_week_2_day_1,	working_week_2_day_2,working_week_2_day_3,	working_week_2_day_4,working_week_2_day_5,	working_week_2_day_6, working_week_2_day_7,");
		sql
				.append(" working_week_3_day_1,	working_week_3_day_2,working_week_3_day_3,	working_week_3_day_4,working_week_3_day_5,	working_week_3_day_6, working_week_3_day_7,");
		sql
				.append(" working_week_4_day_1,	working_week_4_day_2,working_week_4_day_3,	working_week_4_day_4,working_week_4_day_5,	working_week_4_day_6, working_week_4_day_7,");
		sql
				.append(" working_week_5_day_1,	working_week_5_day_2,working_week_5_day_3,	working_week_5_day_4,working_week_5_day_5,	working_week_5_day_6, working_week_5_day_7,");
		sql
				.append("mr_section_type, mr_section_code,  age_group_code,speciality_code,  dept_code,service_code, 	pract_type,open_to_all_pract_yn, ident_at_checkin,");
		sql
				.append("level_of_care_ind,allow_appt_yn,allow_walk_in_yn,allow_referral_yn,allow_non_referral_yn, allow_visit_regn_yn,record_vital_signs_yn, record_immu_yn,record_outcome_yn,");
		sql
				.append("rt_visit_type_appl_yn, sr_visit_type_appl_yn, em_visit_type_appl_yn,");
		sql
				.append("eff_status,added_by_id,added_date,added_facility_id, added_at_ws_no, modified_by_id,	 modified_date,modified_facility_id,modified_at_ws_no, ");
		sql
				.append("allow_unassign_in_practq_yn,mr_location_code,vital_signs_battery_id ,disp_in_ca_queue_after,online_mr_notfn_yn,section_code ,working_day_start_time,working_day_end_time,base_slot_slab_time ,dflt_file_type_code,");

		sql.append("fi_visit_type_appl_yn, fu_visit_type_appl_yn,cs_visit_type_appl_yn,");

		sql	.append("primary_resource_class,QUEUE_NUM_APPL_YN,QUEUE_NUM_BY_PRACT_YN,QUEUE_NUM_BY_OTHER_RES_YN,		QUEUE_NUM_OTHER_RES_CLASS,QUEUE_NUM_OTHER_RES_TYPE,QUEUE_NUM_BY_ROOM_YN,PHYSICAL_LOCATION,");

		sql.append("MAX_WALKIN_FOR_DAY_1,MAX_WALKIN_FOR_DAY_2,MAX_WALKIN_FOR_DAY_3,MAX_WALKIN_FOR_DAY_4,MAX_WALKIN_FOR_DAY_5,MAX_WALKIN_FOR_DAY_6,MAX_WALKIN_FOR_DAY_7,multi_speciality_yn,");//included multi_speciality_yn for the CRF- Bru-HIMS-CRF-0198

		if (callfunc.equals("ProcedureUnit") || callfunc.equals("DaycareUnit")) {
			sql.append("op_appl_yn, ip_appl_yn,dc_appl_yn,em_appl_yn,");
		}

		if (callfunc.equals("ProcedureUnit")) {
			sql.append("rd_appl_yn,");
		}

		sql.append("care_locn_type_ind");
		if (callfunc.equals("ProcedureUnit")) { // added by mujafar for GHL-CRF-0527
			if(isAlertApplicableforBookAppt.equals("true"))
				sql.append(",ALERT_REQ_BOOK_APPT_YN,POPUP_DESC_BOOK_APPT");
		}

		if (callfunc.equals("Clinic"))
		{
			sql.append(",SPECIALIST_CLINIC_YN,VISIT_SPECIALIST_CLINIC_YN,QMS_INTERFACED_YN");//modified for the CRF - BruHIMS-CRF192.1	
			if(isAlertApplicableforBookAppt.equals("true")) // added by mujafar for GHL-CRF-0527
				sql.append(",ALERT_REQ_BOOK_APPT_YN,POPUP_DESC_BOOK_APPT");
		}
		//Modified by Sangeetha for ML-MMOH-CRF-0547
		sql.append(",CALC_WAIT_TIME_BASED_ON,DIAG_RECORDING_MAND_YN,CONTACT_NO, CLINIC_TYPE_SUB,CATEGORY,Queue_No_Mandate");	//Included the column CALC_WAIT_TIME_BASED_ON for Bru-HIMS-CRF-179-DD1//Included the Column CONTACT_NO for MO-CRF-20121.1
		 // Added column Queue_No_Mandate by Himanshu Saxena for ML-BRU-CRF-0628.11 on 02-05-2023-->
		sql.append(")values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,to_date(?,'hh24:mi'),to_date(?,'hh24:mi'),to_date(?,'hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");//included multi_speciality_yn for the CRF- Bru-HIMS-CRF-0198
		if (callfunc.equals("Clinic")) {
			//sql.append(",'C',?,?,?)");//modified for the CRF - BruHIMS-CRF192.1
			if(isAlertApplicableforBookAppt.equals("true")) // added by mujafar for GHL-CRF-0527
			sql.append(",'C',?,?,?,?,?");	
			else
			sql.append(",'C',?,?,?");//modified for the CRF - BruHIMS-CRF192.1
		} else if (callfunc.equals("ProcedureUnit")) {
			//sql.append(",?,?,?,?,?,'E')");
			if(isAlertApplicableforBookAppt.equals("true")) // added by mujafar for GHL-CRF-0527
			sql.append(",?,?,?,?,?,'E',?,?");	
			else
			sql.append(",?,?,?,?,?,'E'");
		} else if (callfunc.equals("DaycareUnit")) {
			//sql.append(",?,?,?,?,'D')");
			sql.append(",?,?,?,?,'D'");
		}	

		//Added by Sangeetha for ML-MMOH-CRF-0547
		sql.append(",?,?,?,?,?,?)");		//Included for Bru-HIMS-CRF-179-DD1//MO-CRF-20121.1	

		System.out.println(sql.toString());

		pat_ins_sql="INSERT INTO op_clinic_pat_instructions(FACILITY_ID, CLINIC_CODE, INSTRUCTION_ID, DISPLAY_ORDER, DEFAULT_LINKED_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

		addedById = p.getProperty("login_user");
		addedDate = dateFormat.format(new java.util.Date());
		modifiedById = addedById;
		modifiedDate = addedDate;
		modifiedFacilityId = (String) tabdata.get("addedFacilityId");
		modifiedAtWorkstation = (String) tabdata.get("addedAtWorkstation");

		added_date = Date.valueOf(addedDate);
		modified_date = Date.valueOf(modifiedDate);

		try {

			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);	
			final String duplicateSql = "select 1 from  op_clinic where facility_id = ? and clinic_code = ?";

			pstmt = con.prepareStatement(duplicateSql);
			pstmt.setString(1, (String) tabdata.get("addedFacilityId"));
			pstmt.setString(2, (String) tabdata.get("cliniccode"));

			ResultSet rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				insertable = false;
				java.util.Hashtable message = MessageManager.getMessage(locale,
						"CODE_ALREADY_EXISTS", "Common");
				sb.append((String) message.get("message"));

				message.clear();

			}
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();


		} catch (Exception e) {
			insertable = false;
			sb.append(e.getMessage() + "<br>");
			e.printStackTrace();
			if (con != null) {
				try {
					con.close();
				} catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		}
		if (insertable) {
			try {

				int res = InsertData(callfunc, tabdata, sql,isAlertApplicableforBookAppt); // modified by mujafar for GHL-CRF-0527
				if (res != 0) {
					result = true;

					java.util.Hashtable message = MessageManager.getMessage(
							locale, "RECORD_INSERTED", "SM");
					sb.append((String) message.get("message"));					
					con.commit();
					message.clear();
				} else {
					result = false;					
					con.rollback();
				}

				sql.setLength(0);
				tabdata.clear();

			} catch (Exception e) {
				try {
					con.rollback();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				sb.append("Error while insertring into OP_CLINIC :"
						+ e.getMessage() + "<br>");
				e.printStackTrace();
			} finally {
                 if (con != null)
					ConnectionManager.returnConnection(con, p);
			}
		}

		results.put("status", new Boolean(result));
		results.put("error", sb.toString());

		return results;
	}

	public int InsertData(String callfunc, java.util.HashMap tabdata,
			StringBuffer sql,String isAlertApplicableforBookAppt) { // modified by mujafar for GHL-CRF-0527
		int rest = 0;
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, (String) tabdata.get("addedFacilityId"));
			pstmt.setString(2, (String) tabdata.get("cliniccode"));
			pstmt.setString(3, (String) tabdata.get("longdesc"));
			pstmt.setString(4, (String) tabdata.get("shortdesc"));
			pstmt.setString(5, (String) tabdata.get("clinictype"));
			pstmt.setString(6, (String) tabdata.get("working_week_appl_day_1"));
			pstmt.setString(7, (String) tabdata.get("working_week_appl_day_2"));
			pstmt.setString(8, (String) tabdata.get("working_week_appl_day_3"));
			pstmt.setString(9, (String) tabdata.get("working_week_appl_day_4"));
			pstmt
					.setString(10, (String) tabdata
							.get("working_week_appl_day_5"));
			pstmt
					.setString(11, (String) tabdata
							.get("working_week_appl_day_6"));
			pstmt
					.setString(12, (String) tabdata
							.get("working_week_appl_day_7"));
			pstmt.setString(13, (String) tabdata.get("working_day_1"));
			pstmt.setString(14, (String) tabdata.get("working_day_2"));
			pstmt.setString(15, (String) tabdata.get("working_day_3"));
			pstmt.setString(16, (String) tabdata.get("working_day_4"));
			pstmt.setString(17, (String) tabdata.get("working_day_5"));
			pstmt.setString(18, (String) tabdata.get("working_day_6"));
			pstmt.setString(19, (String) tabdata.get("working_day_7"));
			pstmt.setString(20, (String) tabdata.get("working_week_1_day_1"));
			pstmt.setString(21, (String) tabdata.get("working_week_1_day_2"));
			pstmt.setString(22, (String) tabdata.get("working_week_1_day_3"));
			pstmt.setString(23, (String) tabdata.get("working_week_1_day_4"));
			pstmt.setString(24, (String) tabdata.get("working_week_1_day_5"));
			pstmt.setString(25, (String) tabdata.get("working_week_1_day_6"));
			pstmt.setString(26, (String) tabdata.get("working_week_1_day_7"));
			pstmt.setString(27, (String) tabdata.get("working_week_2_day_1"));
			pstmt.setString(28, (String) tabdata.get("working_week_2_day_2"));
			pstmt.setString(29, (String) tabdata.get("working_week_2_day_3"));
			pstmt.setString(30, (String) tabdata.get("working_week_2_day_4"));
			pstmt.setString(31, (String) tabdata.get("working_week_2_day_5"));
			pstmt.setString(32, (String) tabdata.get("working_week_2_day_6"));
			pstmt.setString(33, (String) tabdata.get("working_week_2_day_7"));
			pstmt.setString(34, (String) tabdata.get("working_week_3_day_1"));
			pstmt.setString(35, (String) tabdata.get("working_week_3_day_2"));
			pstmt.setString(36, (String) tabdata.get("working_week_3_day_3"));
			pstmt.setString(37, (String) tabdata.get("working_week_3_day_4"));
			pstmt.setString(38, (String) tabdata.get("working_week_3_day_5"));
			pstmt.setString(39, (String) tabdata.get("working_week_3_day_6"));
			pstmt.setString(40, (String) tabdata.get("working_week_3_day_7"));
			pstmt.setString(41, (String) tabdata.get("working_week_4_day_1"));
			pstmt.setString(42, (String) tabdata.get("working_week_4_day_2"));
			pstmt.setString(43, (String) tabdata.get("working_week_4_day_3"));
			pstmt.setString(44, (String) tabdata.get("working_week_4_day_4"));
			pstmt.setString(45, (String) tabdata.get("working_week_4_day_5"));
			pstmt.setString(46, (String) tabdata.get("working_week_4_day_6"));
			pstmt.setString(47, (String) tabdata.get("working_week_4_day_7"));
			pstmt.setString(48, (String) tabdata.get("working_week_5_day_1"));
			pstmt.setString(49, (String) tabdata.get("working_week_5_day_2"));
			pstmt.setString(50, (String) tabdata.get("working_week_5_day_3"));
			pstmt.setString(51, (String) tabdata.get("working_week_5_day_4"));
			pstmt.setString(52, (String) tabdata.get("working_week_5_day_5"));
			pstmt.setString(53, (String) tabdata.get("working_week_5_day_6"));
			pstmt.setString(54, (String) tabdata.get("working_week_5_day_7"));

			pstmt.setString(55, (String) tabdata.get("mrsectiontype"));
			pstmt.setString(56, (String) tabdata.get("mrsection"));
			pstmt.setString(57, (String) tabdata.get("agegroup"));
			pstmt.setString(58, (String) tabdata.get("speciality"));
			pstmt.setString(59, (String) tabdata.get("department"));
			pstmt.setString(60, (String) tabdata.get("service"));

			practtype = (String) tabdata.get("practtype");
			if (practtype == "" || practtype == "null" || practtype == " ") {
				pstmt.setString(61, null);
			} else {
				pstmt.setString(61, practtype);
			}
			pstmt.setString(62, (String) tabdata.get("opentoallpract"));
			pstmt.setString(63, (String) tabdata.get("identitychkin"));
			pstmt.setString(64, (String) tabdata.get("levelofcare"));
			pstmt.setString(65, (String) tabdata.get("allowapptmt"));
			pstmt.setString(66, (String) tabdata.get("allow_walk_in_yn"));
			pstmt.setString(67, (String) tabdata.get("allow_referral_yn"));
			pstmt.setString(68, (String) tabdata.get("allow_non_referral_yn"));
			pstmt.setString(69, (String) tabdata.get("allowvisitregn"));
			pstmt.setString(70, (String) tabdata.get("rcdvitsgns"));
			pstmt.setString(71, (String) tabdata.get("rcdimmun"));
			pstmt.setString(72, (String) tabdata.get("rcdoutcome"));
			pstmt.setString(73, (String) tabdata.get("rtvisittype"));
			pstmt.setString(74, (String) tabdata.get("srvisittype"));
			pstmt.setString(75, (String) tabdata.get("emvisittype"));
			pstmt.setString(76, (String) tabdata.get("effectiveStatus"));
			pstmt.setString(77, addedById);
			pstmt.setDate(78, added_date);
			pstmt.setString(79, (String) tabdata.get("addedFacilityId"));
			pstmt.setString(80, (String) tabdata.get("addedAtWorkstation"));
			pstmt.setString(81, modifiedById);
			//pstmt.setDate(82, modified_date);
			pstmt.setString(82, modifiedFacilityId);
			pstmt.setString(83, modifiedAtWorkstation);
			pstmt.setString(84, (String) tabdata.get("allow_unassign_queue"));
			pstmt.setString(85, (String) tabdata.get("mr_location_code"));
			pstmt.setString(86, (String) tabdata.get("vitalsignsbattery"));
			pstmt.setString(87, (String) tabdata.get("disp_in_ca_queue_after"));
			pstmt.setString(88, (String) tabdata.get("online_mr_notfn_yn"));
			pstmt.setString(89, (String) tabdata.get("sectionCode"));
			pstmt.setString(90, (String) tabdata.get("starttime"));
			pstmt.setString(91, (String) tabdata.get("endtime"));
			pstmt.setString(92, (String) tabdata.get("baseslabslot"));
			pstmt.setString(93, (String) tabdata.get("dfltfiletype"));
			pstmt.setString(94, (String) tabdata.get("fivisittype"));
			pstmt.setString(95, (String) tabdata.get("fuvisittype"));
			pstmt.setString(96, (String) tabdata.get("csvisittype"));
			pstmt.setString(97, (String) tabdata.get("primaryresclass"));
			pstmt.setString(98, (String) tabdata.get("QUEUE_NUM_APPL_YN"));
			pstmt.setString(99, (String) tabdata.get("QUEUE_NUM_BY_PRACT_YN"));
			pstmt.setString(100, (String) tabdata
					.get("QUEUE_NUM_BY_OTHER_RES_YN"));
			pstmt.setString(101, (String) tabdata
					.get("QUEUE_NUM_OTHER_RES_CLASS"));
			pstmt.setString(102, (String) tabdata
					.get("QUEUE_NUM_OTHER_RES_TYPE"));
			pstmt.setString(103, (String) tabdata.get("QUEUE_NUM_BY_ROOM_YN"));
			pstmt.setString(104, (String) tabdata.get("physical_locn"));

			pstmt.setString(105, (String) tabdata.get("max_walkin_for_day_1"));
			pstmt.setString(106, (String) tabdata.get("max_walkin_for_day_2"));
			pstmt.setString(107, (String) tabdata.get("max_walkin_for_day_3"));
			pstmt.setString(108, (String) tabdata.get("max_walkin_for_day_4"));
			pstmt.setString(109, (String) tabdata.get("max_walkin_for_day_5"));
			pstmt.setString(110, (String) tabdata.get("max_walkin_for_day_6"));
			pstmt.setString(111, (String) tabdata.get("max_walkin_for_day_7"));
			pstmt.setString(112, (String) tabdata.get("multi_speciality_yn"));//Included for the CRF - Bru-HIMS-CRF - 0198
			
			
			int nCount = 113;
			if (callfunc.equals("Clinic")) {
				if(isAlertApplicableforBookAppt.equals("true")) // added by mujafar for GHL-CRF-0527
				{
				String temp_val=(String) tabdata.get("alert_req_book_appt_yn");
				 if(temp_val.equals(""))temp_val="N";
				pstmt.setString(nCount++, (String) tabdata.get("SPECIALIST_CLINIC_YN"));
				pstmt.setString(nCount++, (String) tabdata.get("visit_pract_yn"));
				pstmt.setString(nCount++, (String) tabdata.get("qms_interfaced_yn"));
				pstmt.setString(nCount++, temp_val);
				pstmt.setString(nCount++, (String) tabdata.get("popup_desc"));
				}
				else
				{
				pstmt.setString(nCount++, (String) tabdata
						.get("SPECIALIST_CLINIC_YN"));
				pstmt.setString(nCount++, (String) tabdata.get("visit_pract_yn"));
				pstmt.setString(nCount++, (String) tabdata.get("qms_interfaced_yn"));//included for the CRF Bru-HIMS-CRF 192.1
				}
			}
			if (callfunc.equals("ProcedureUnit")
					|| callfunc.equals("DaycareUnit")) {
				pstmt.setString(nCount++, (String) tabdata.get("opclass"));
				pstmt.setString(nCount++, (String) tabdata.get("ipclass"));
				pstmt.setString(nCount++, (String) tabdata.get("dcclass"));
				pstmt.setString(nCount++, (String) tabdata.get("emclass"));
			}			

			if (callfunc.equals("ProcedureUnit")) {
				if(isAlertApplicableforBookAppt.equals("true")) // added by mujafar for GHL-CRF-0527
				{	
				String temp_val=(String) tabdata.get("alert_req_book_appt_yn");
				 if(temp_val.equals(""))temp_val="N";
				pstmt.setString(nCount++, (String) tabdata.get("rd_appl_yn"));				
					pstmt.setString(nCount++, temp_val);
					pstmt.setString(nCount++, (String) tabdata.get("popup_desc"));
			}	
				else
				{
				pstmt.setString(nCount++, (String) tabdata.get("rd_appl_yn"));
				}				
			}	
			pstmt.setString(nCount++, (String) tabdata.get("CALC_WAIT_TIME_BASED_ON"));//included for Bru-HIMS-CRF-179-DD1
			pstmt.setString(nCount++, (String) tabdata.get("diagnosis_not_mndt")); //Added by Sangeetha for ML-MMOH-CRF-0547
			pstmt.setString(nCount++, (String) tabdata.get("contactno"));//included for MO-CRF-20121.1
			pstmt.setString(nCount++, (String) tabdata.get("clinic_type_sub"));//Added by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6
			pstmt.setString(nCount++, (String) tabdata.get("CATEGORY"));//Added by Ajay for MMS-DM-CRF-0209.4
			pstmt.setString(nCount++, (String) tabdata.get("Queuenomandate_yn"));// Added column Queue_No_Mandate by Himanshu Saxena for ML-BRU-CRF-0628.11 on 02-05-2023-->
			
			/*
			if (callfunc.equals("Clinic")) {
				pstmt.setString(114, (String) tabdata
						.get("SPECIALIST_CLINIC_YN"));
				pstmt.setString(115, (String) tabdata.get("visit_pract_yn"));
				pstmt.setString(116, (String) tabdata.get("qms_interfaced_yn"));//included for the CRF Bru-HIMS-CRF 192.1
				pstmt.setString(117, (String) tabdata.get("calc_wait_time_based_on"));//included for Bru-HIMS-CRF-179-DD1
			}
			if (callfunc.equals("ProcedureUnit")
					|| callfunc.equals("DaycareUnit")) {
				pstmt.setString(114, (String) tabdata.get("opclass"));
				pstmt.setString(115, (String) tabdata.get("ipclass"));
				pstmt.setString(116, (String) tabdata.get("dcclass"));
				pstmt.setString(117, (String) tabdata.get("emclass"));
				if(callfunc.equals("DaycareUnit"))
					pstmt.setString(118, (String) tabdata.get("calc_wait_time_based_on"));//included for Bru-HIMS-CRF-179-DD1
			}			

			if (callfunc.equals("ProcedureUnit")) {
				pstmt.setString(118, (String) tabdata.get("rd_appl_yn"));				
				pstmt.setString(119, (String) tabdata.get("calc_wait_time_based_on"));//included for Bru-HIMS-CRF-179-DD1
			}	
			*/
			rest = pstmt.executeUpdate();
			if (pstmt != null)
				pstmt.close();
			pstmt = con.prepareStatement(pat_ins_sql);
			pat_ins_bean_ejb= (ArrayList)tabdata.get("pat_ins_bean");
			int size=pat_ins_bean_ejb.size();
			size=size/4;
			if(size > 0)
			{
			int k=-1;
			for(int m=0;m<size;m++)
			{
				k++;
				display_order=Integer.parseInt(pat_ins_bean_ejb.get(k).toString());
				k=k+2;
				pat_ins_id=pat_ins_bean_ejb.get(k).toString();
				default_yn=pat_ins_bean_ejb.get(++k).toString();				
				pstmt.setString(1, (String) tabdata.get("addedFacilityId"));
				pstmt.setString(2, (String) tabdata.get("cliniccode"));
				pstmt.setString(3, pat_ins_id);
				pstmt.setInt(4, display_order);
				pstmt.setString(5, default_yn);
				pstmt.setString(6,addedById);
				pstmt.setDate(7, added_date);
				pstmt.setString(8, (String) tabdata.get("addedAtWorkstation"));
				pstmt.setString(9, (String) tabdata.get("addedFacilityId"));
				pstmt.setString(10, modifiedById);
				pstmt.setDate(11, modified_date);
				pstmt.setString(12, modifiedAtWorkstation);
				pstmt.setString(13, modifiedFacilityId);
				pstmt.addBatch();
		   }		
        int[] iNoRows = pstmt.executeBatch();
        if(size == iNoRows.length && size > 0 && iNoRows.length > 0)
			rest=rest;
		else
			rest=0;			
		}

		if (pstmt != null)
			pstmt.close();
			
		} catch (Exception e) {
			rest = 0;
			e.printStackTrace();
		}
		tabdata.clear();
		return rest;
	}

	/**
	 *Method to insert single record
	 *@param properties Connection Properties
	 *@param hashaMap Record data 
	 *@param as data for duplication check
	 *@param s Table Name
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public java.util.HashMap updateOPClinic(java.util.Properties p,
			java.util.HashMap tabdata) {

		java.util.HashMap results = new java.util.HashMap();
		boolean result = false;
		StringBuffer sb = new StringBuffer();
        locale = p.getProperty("LOCALE");
		String callfunc = (String) tabdata.get("callfunc");
		StringBuffer sql = new StringBuffer();
		String isAlertApplicableforBookAppt=(String) tabdata.get("isAlertApplicableforBookAppt"); // added by mujafar for GHL-CRF-0527
		CATEGORY=(String) tabdata.get("CATEGORY");
		sql
				.append("update op_clinic set long_desc=?,short_desc = ?,clinic_type = ?,");
		sql
				.append("working_week_appl_day_1=?, working_week_appl_day_2=?,working_week_appl_day_3=?,working_week_appl_day_4=?,working_week_appl_day_5=?,working_week_appl_day_6=?,working_week_appl_day_7=?,");
		sql
				.append("working_day_1=?,working_day_2=?,working_day_3=?,working_day_4=?,working_day_5=?,working_day_6=?,working_day_7=?,");

		sql
				.append("working_week_1_day_1 = ?,working_week_1_day_2 = ?,working_week_1_day_3 =?,working_week_1_day_4	= ?,working_week_1_day_5	= ?,working_week_1_day_6 = ?,working_week_1_day_7	= ?,");
		sql
				.append("working_week_2_day_1 = ?,working_week_2_day_2 = ?,working_week_2_day_3 =?,working_week_2_day_4	= ?,working_week_2_day_5	= ?,working_week_2_day_6 = ?,working_week_2_day_7	= ?,");
		sql
				.append("working_week_3_day_1 = ?,working_week_3_day_2 = ?,working_week_3_day_3 =?,working_week_3_day_4	= ?,working_week_3_day_5	= ?,working_week_3_day_6 = ?,working_week_3_day_7	= ?,");
		sql
				.append("working_week_4_day_1 = ?,working_week_4_day_2 = ?,working_week_4_day_3 =?,working_week_4_day_4	= ?,working_week_4_day_5	= ?,working_week_4_day_6 = ?,working_week_4_day_7	= ?,");
		sql
				.append("working_week_5_day_1 = ?,working_week_5_day_2 = ?,working_week_5_day_3 =?,working_week_5_day_4	= ?,working_week_5_day_5	= ?,working_week_5_day_6 = ?,working_week_5_day_7	= ?,");
		sql
				.append("mr_section_type	= ?,mr_section_code	= ?,age_group_code	= ?, speciality_code	= ?,dept_code = ?,service_code = ?,pract_type		= ?,open_to_all_pract_yn	= ?,ident_at_checkin	= ?, level_of_care_ind = ?,");
		sql
				.append("allow_appt_yn	= ?,allow_walk_in_yn = ?,allow_referral_yn = ?,allow_non_referral_yn	= ?,allow_visit_regn_yn	= ?,record_vital_signs_yn	= ?,record_immu_yn	= ?,record_outcome_yn	= ?,  ");
		sql
				.append("rt_visit_type_appl_yn = ?,sr_visit_type_appl_yn = ?,em_visit_type_appl_yn = ?,");
		sql
				.append("eff_status		= ?,modified_by_id	= ?,modified_date		= sysdate,modified_facility_id	= ?,modified_at_ws_no = ?,");
		sql
				.append(" mr_location_code=?, VITAL_SIGNS_BATTERY_ID =? , disp_in_ca_queue_after=? ,allow_unassign_in_practq_yn=?,online_mr_notfn_yn=? ,section_code=?,");
		sql
				.append("working_day_start_time=to_date(?,'hh24:mi'),working_day_end_time=to_date(?,'hh24:mi'),base_slot_slab_time=to_date(?,'hh24:mi'),dflt_file_type_code=?, ");
		sql
				.append("fi_visit_type_appl_yn = ?,fu_visit_type_appl_yn = ?, cs_visit_type_appl_yn = ?,");
		sql
				.append(" primary_resource_class=?,QUEUE_NUM_APPL_YN=?,QUEUE_NUM_BY_PRACT_YN=?,QUEUE_NUM_BY_OTHER_RES_YN=?,QUEUE_NUM_OTHER_RES_CLASS=?,QUEUE_NUM_OTHER_RES_TYPE=?,QUEUE_NUM_BY_ROOM_YN=?,PHYSICAL_LOCATION=?,");

		sql.append(" MAX_WALKIN_FOR_DAY_1 = ?, MAX_WALKIN_FOR_DAY_2 = ?, MAX_WALKIN_FOR_DAY_3 = ?, MAX_WALKIN_FOR_DAY_4 = ?, MAX_WALKIN_FOR_DAY_5 = ?, MAX_WALKIN_FOR_DAY_6 = ?, MAX_WALKIN_FOR_DAY_7 = ?,multi_speciality_yn=?,CATEGORY =?,Queue_No_Mandate=?,");//included multi_speciality_yn for the CRF- Bru-HIMS-CRF-0198
		//included 'CATEGORY' for the MMS-DM-CRF-0209.4 by Ajay H.		

		

		if (callfunc.equals("Clinic")) {
			if(isAlertApplicableforBookAppt.equals("true")) // added by mujafar for GHL-CRF-0527
				sql.append("care_locn_type_ind='C' , SPECIALIST_CLINIC_YN=? , VISIT_SPECIALIST_CLINIC_YN=?,QMS_INTERFACED_YN=?,ALERT_REQ_BOOK_APPT_YN=?,POPUP_DESC_BOOK_APPT=?");
			else
			sql.append(" care_locn_type_ind='C' , SPECIALIST_CLINIC_YN=? , VISIT_SPECIALIST_CLINIC_YN=?,QMS_INTERFACED_YN=?");//modified for the CRF - Bru-HIMS-CRF-192.1
		} else if (callfunc.equals("ProcedureUnit")) {
			if(isAlertApplicableforBookAppt.equals("true")) // added by mujafar for GHL-CRF-0527
			sql.append("op_appl_yn = ?, ip_appl_yn = ?,dc_appl_yn = ?, em_appl_yn = ?,care_locn_type_ind='E',rd_appl_yn = ?,ALERT_REQ_BOOK_APPT_YN=?,POPUP_DESC_BOOK_APPT=? ");
			else
			sql.append("op_appl_yn = ?, ip_appl_yn = ?,dc_appl_yn = ?, em_appl_yn = ?,care_locn_type_ind='E',rd_appl_yn = ? ");
		} else if (callfunc.equals("DaycareUnit")) {
			sql
					.append("op_appl_yn = ?, ip_appl_yn = ?,dc_appl_yn = ?, em_appl_yn = ?,care_locn_type_ind='D' ");

		}
		//Added by Sangeetha for ML-MMOH-CRF-0547
		sql.append(",CALC_WAIT_TIME_BASED_ON=?,DIAG_RECORDING_MAND_YN=?,CONTACT_NO=?,CLINIC_TYPE_SUB=?");	//Included the column CALC_WAIT_TIME_BASED_ON for Bru-HIMS-CRF-179-DD1
		
		
		sql.append(" where	facility_id 	= ? and clinic_code = ? ");

		pat_ins_sql_del="delete from op_clinic_pat_instructions where FACILITY_ID=? and CLINIC_CODE=?";

		pat_ins_sql="INSERT INTO op_clinic_pat_instructions(FACILITY_ID, CLINIC_CODE, INSTRUCTION_ID, DISPLAY_ORDER, DEFAULT_LINKED_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

		addedById = p.getProperty("login_user");
		addedDate = dateFormat.format(new java.util.Date());
		modifiedById = addedById;
		modifiedDate = addedDate;
		modifiedFacilityId = (String) tabdata.get("addedFacilityId");
		modifiedAtWorkstation = (String) tabdata.get("addedAtWorkstation");

		added_date = Date.valueOf(addedDate);
		modified_date = Date.valueOf(modifiedDate);
		
		
		/*modifiedById = p.getProperty("login_user");
		modifiedDate = dateFormat.format(new java.util.Date());
		modified_date = Date.valueOf(modifiedDate);
		modifiedFacilityId = (String) tabdata.get("addedFacilityId");
		modifiedAtWorkstation = (String) tabdata.get("addedAtWorkstation");*/
		

		try {
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			int res = UpdateData(callfunc, tabdata, sql,isAlertApplicableforBookAppt); // modified by mujafar for GHL-CRF-0527
			
			if (res != 0) {
				result = true;
				con.commit();
				java.util.Hashtable message = MessageManager.getMessage(locale,
						"RECORD_MODIFIED", "SM");
				sb.append((String) message.get("message"));

				message.clear();
			} else {
				result = false;
				con.rollback();
			}

			sql.setLength(0);
			tabdata.clear();
		} catch (Exception e) {
            e.printStackTrace();
			try {
               con.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			sb.append(e.getMessage() + "<br>");
			e.printStackTrace();
		} finally {
			if (con != null)
				ConnectionManager.returnConnection(con, p);
		}
		results.put("status", new Boolean(result));
		results.put("error", sb.toString());

		return results;
	}

	public int UpdateData(String callfunc, java.util.HashMap tabdata,
			StringBuffer sql,String isAlertApplicableforBookAppt) { // added by mujafar for GHL-CRF-0527
		int rest = 0;
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, (String) tabdata.get("longdesc"));
			pstmt.setString(2, (String) tabdata.get("shortdesc"));
			pstmt.setString(3, (String) tabdata.get("clinictype"));
			pstmt.setString(4, (String) tabdata.get("working_week_appl_day_1"));
			pstmt.setString(5, (String) tabdata.get("working_week_appl_day_2"));
			pstmt.setString(6, (String) tabdata.get("working_week_appl_day_3"));
			pstmt.setString(7, (String) tabdata.get("working_week_appl_day_4"));
			pstmt.setString(8, (String) tabdata.get("working_week_appl_day_5"));
			pstmt.setString(9, (String) tabdata.get("working_week_appl_day_6"));
			pstmt.setString(10, (String) tabdata.get("working_week_appl_day_7"));
			pstmt.setString(11, (String) tabdata.get("working_day_1"));
			pstmt.setString(12, (String) tabdata.get("working_day_2"));
			pstmt.setString(13, (String) tabdata.get("working_day_3"));
			pstmt.setString(14, (String) tabdata.get("working_day_4"));
			pstmt.setString(15, (String) tabdata.get("working_day_5"));
			pstmt.setString(16, (String) tabdata.get("working_day_6"));
			pstmt.setString(17, (String) tabdata.get("working_day_7"));

			pstmt.setString(18, (String) tabdata.get("working_week_1_day_1"));
			pstmt.setString(19, (String) tabdata.get("working_week_1_day_2"));
			pstmt.setString(20, (String) tabdata.get("working_week_1_day_3"));
			pstmt.setString(21, (String) tabdata.get("working_week_1_day_4"));
			pstmt.setString(22, (String) tabdata.get("working_week_1_day_5"));
			pstmt.setString(23, (String) tabdata.get("working_week_1_day_6"));
			pstmt.setString(24, (String) tabdata.get("working_week_1_day_7"));
			pstmt.setString(25, (String) tabdata.get("working_week_2_day_1"));
			pstmt.setString(26, (String) tabdata.get("working_week_2_day_2"));
			pstmt.setString(27, (String) tabdata.get("working_week_2_day_3"));
			pstmt.setString(28, (String) tabdata.get("working_week_2_day_4"));
			pstmt.setString(29, (String) tabdata.get("working_week_2_day_5"));
			pstmt.setString(30, (String) tabdata.get("working_week_2_day_6"));
			pstmt.setString(31, (String) tabdata.get("working_week_2_day_7"));
			pstmt.setString(32, (String) tabdata.get("working_week_3_day_1"));
			pstmt.setString(33, (String) tabdata.get("working_week_3_day_2"));
			pstmt.setString(34, (String) tabdata.get("working_week_3_day_3"));
			pstmt.setString(35, (String) tabdata.get("working_week_3_day_4"));
			pstmt.setString(36, (String) tabdata.get("working_week_3_day_5"));
			pstmt.setString(37, (String) tabdata.get("working_week_3_day_6"));
			pstmt.setString(38, (String) tabdata.get("working_week_3_day_7"));
			pstmt.setString(39, (String) tabdata.get("working_week_4_day_1"));
			pstmt.setString(40, (String) tabdata.get("working_week_4_day_2"));
			pstmt.setString(41, (String) tabdata.get("working_week_4_day_3"));
			pstmt.setString(42, (String) tabdata.get("working_week_4_day_4"));
			pstmt.setString(43, (String) tabdata.get("working_week_4_day_5"));
			pstmt.setString(44, (String) tabdata.get("working_week_4_day_6"));
			pstmt.setString(45, (String) tabdata.get("working_week_4_day_7"));
			pstmt.setString(46, (String) tabdata.get("working_week_5_day_1"));
			pstmt.setString(47, (String) tabdata.get("working_week_5_day_2"));
			pstmt.setString(48, (String) tabdata.get("working_week_5_day_3"));
			pstmt.setString(49, (String) tabdata.get("working_week_5_day_4"));
			pstmt.setString(50, (String) tabdata.get("working_week_5_day_5"));
			pstmt.setString(51, (String) tabdata.get("working_week_5_day_6"));
			pstmt.setString(52, (String) tabdata.get("working_week_5_day_7"));

			pstmt.setString(53, (String) tabdata.get("mrsectiontype"));
			pstmt.setString(54, (String) tabdata.get("mrsection"));
			pstmt.setString(55, (String) tabdata.get("agegroup"));
			pstmt.setString(56, (String) tabdata.get("speciality"));
			pstmt.setString(57, (String) tabdata.get("department"));
			pstmt.setString(58, (String) tabdata.get("service"));
			practtype = (String) tabdata.get("practtype");

			if (practtype == "" || practtype == "null" || practtype == " ")
				pstmt.setString(59, null);
			else
				pstmt.setString(59, practtype);
			pstmt.setString(60, (String) tabdata.get("opentoallpract"));
			pstmt.setString(61, (String) tabdata.get("identitychkin"));
			pstmt.setString(62, (String) tabdata.get("levelofcare"));
			pstmt.setString(63, (String) tabdata.get("allowapptmt"));
			pstmt.setString(64, (String) tabdata.get("allow_walk_in_yn"));
			pstmt.setString(65, (String) tabdata.get("allow_referral_yn"));
			pstmt.setString(66, (String) tabdata.get("allow_non_referral_yn"));
			pstmt.setString(67, (String) tabdata.get("allowvisitregn"));
			pstmt.setString(68, (String) tabdata.get("rcdvitsgns"));
			pstmt.setString(69, (String) tabdata.get("rcdimmun"));
			pstmt.setString(70, (String) tabdata.get("rcdoutcome"));
			pstmt.setString(71, (String) tabdata.get("rtvisittype"));
			pstmt.setString(72, (String) tabdata.get("srvisittype"));

			pstmt.setString(73, (String) tabdata.get("emvisittype"));
			pstmt.setString(74, (String) tabdata.get("effectiveStatus"));
			pstmt.setString(75, modifiedById);
			//pstmt.setDate(76, modified_date);
			pstmt.setString(76, modifiedFacilityId);
			pstmt.setString(77, modifiedAtWorkstation);
			pstmt.setString(78, (String) tabdata.get("mr_location_code"));
			pstmt.setString(79, (String) tabdata.get("vitalsignsbattery"));
			pstmt.setString(80, (String) tabdata.get("disp_in_ca_queue_after"));
			pstmt.setString(81, (String) tabdata.get("allow_unassign_queue"));
			pstmt.setString(82, (String) tabdata.get("online_mr_notfn_yn"));
			pstmt.setString(83, (String) tabdata.get("sectionCode"));
			pstmt.setString(84, (String) tabdata.get("starttime"));
			pstmt.setString(85, (String) tabdata.get("endtime"));
			pstmt.setString(86, (String) tabdata.get("baseslabslot"));
			pstmt.setString(87, (String) tabdata.get("dfltfiletype"));
			pstmt.setString(88, (String) tabdata.get("fivisittype"));
			pstmt.setString(89, (String) tabdata.get("fuvisittype"));
			pstmt.setString(90, (String) tabdata.get("csvisittype"));

			pstmt.setString(91, (String) tabdata.get("primaryresclass"));
			pstmt.setString(92, (String) tabdata.get("QUEUE_NUM_APPL_YN"));
			pstmt.setString(93, (String) tabdata.get("QUEUE_NUM_BY_PRACT_YN"));
			pstmt.setString(94, (String) tabdata
					.get("QUEUE_NUM_BY_OTHER_RES_YN"));
			pstmt.setString(95, (String) tabdata
					.get("QUEUE_NUM_OTHER_RES_CLASS"));
			pstmt.setString(96, (String) tabdata
					.get("QUEUE_NUM_OTHER_RES_TYPE"));
			pstmt.setString(97, (String) tabdata.get("QUEUE_NUM_BY_ROOM_YN"));
			pstmt.setString(98, (String) tabdata.get("physical_locn"));

			pstmt.setString(99, (String) tabdata.get("max_walkin_for_day_1"));
			pstmt.setString(100, (String) tabdata.get("max_walkin_for_day_2"));
			pstmt.setString(101, (String) tabdata.get("max_walkin_for_day_3"));
			pstmt.setString(102, (String) tabdata.get("max_walkin_for_day_4"));
			pstmt.setString(103, (String) tabdata.get("max_walkin_for_day_5"));
			pstmt.setString(104, (String) tabdata.get("max_walkin_for_day_6"));
			pstmt.setString(105, (String) tabdata.get("max_walkin_for_day_7"));			
			pstmt.setString(106, (String) tabdata.get("multi_speciality_yn"));	//included for the CRF- Bru-HIMS-CRF-0198
			pstmt.setString(107, (String) tabdata.get("CATEGORY"));	//included for the MMS-DM-CRF-0209.4 by Ajay H.
			pstmt.setString(108, (String) tabdata.get("Queuenomandate_yn"));
            int nCount = 109;
			
			if (callfunc.equals("Clinic")) {
				if(isAlertApplicableforBookAppt.equals("true")) // added by mujafar for GHL-CRF-0527
				{
				 String temp_val=(String) tabdata.get("alert_req_book_appt_yn");
				 if(temp_val.equals(""))temp_val="N";
				pstmt.setString(nCount++, (String) tabdata.get("SPECIALIST_CLINIC_YN"));
				pstmt.setString(nCount++, (String) tabdata.get("visit_pract_yn"));
				pstmt.setString(nCount++, (String) tabdata.get("qms_interfaced_yn"));
				pstmt.setString(nCount++, temp_val);
				pstmt.setString(nCount++, (String) tabdata.get("popup_desc"));
				}
				else
				{
				pstmt.setString(nCount++, (String) tabdata.get("SPECIALIST_CLINIC_YN"));
				pstmt.setString(nCount++, (String) tabdata.get("visit_pract_yn"));
				pstmt.setString(nCount++, (String) tabdata.get("qms_interfaced_yn"));//modified for the CRF - Bru-HIMS-CRF-192.1
				}
			} else if (callfunc.equals("DaycareUnit")) {
				pstmt.setString(nCount++, (String) tabdata.get("opclass"));
				pstmt.setString(nCount++, (String) tabdata.get("ipclass"));
				pstmt.setString(nCount++, (String) tabdata.get("dcclass"));
				pstmt.setString(nCount++, (String) tabdata.get("emclass"));			
			}else if (callfunc.equals("ProcedureUnit")) {
				if(isAlertApplicableforBookAppt.equals("true")) // added by mujafar for GHL-CRF-0527
				{
				String temp_val=(String) tabdata.get("alert_req_book_appt_yn");
				 if(temp_val.equals(""))temp_val="N";
				pstmt.setString(nCount++, (String) tabdata.get("opclass"));
				pstmt.setString(nCount++, (String) tabdata.get("ipclass"));
				pstmt.setString(nCount++, (String) tabdata.get("dcclass"));
				pstmt.setString(nCount++, (String) tabdata.get("emclass"));
				pstmt.setString(nCount++, (String) tabdata.get("rd_appl_yn"));				
				pstmt.setString(nCount++, temp_val);
				pstmt.setString(nCount++, (String) tabdata.get("popup_desc"));
				}
				else
				{
				pstmt.setString(nCount++, (String) tabdata.get("opclass"));
				pstmt.setString(nCount++, (String) tabdata.get("ipclass"));
				pstmt.setString(nCount++, (String) tabdata.get("dcclass"));
				pstmt.setString(nCount++, (String) tabdata.get("emclass"));
				pstmt.setString(nCount++, (String) tabdata.get("rd_appl_yn"));
				}				
			}
			/*if (callfunc.equals("Clinic")) {
				pstmt.setString(108, (String) tabdata.get("SPECIALIST_CLINIC_YN"));
				pstmt.setString(109, (String) tabdata.get("visit_pract_yn"));
				pstmt.setString(110, (String) tabdata.get("qms_interfaced_yn"));//modified for the CRF - Bru-HIMS-CRF-192.1
				pstmt.setString(111, modifiedFacilityId);
				pstmt.setString(112, (String) tabdata.get("cliniccode"));

			} else if (callfunc.equals("DaycareUnit")) {
				pstmt.setString(108, (String) tabdata.get("opclass"));
				pstmt.setString(109, (String) tabdata.get("ipclass"));
				pstmt.setString(110, (String) tabdata.get("dcclass"));
				pstmt.setString(111, (String) tabdata.get("emclass"));			
				pstmt.setString(112, modifiedFacilityId);
				pstmt.setString(113, (String) tabdata.get("cliniccode"));
			}else if (callfunc.equals("ProcedureUnit")) {
				pstmt.setString(108, (String) tabdata.get("opclass"));
				pstmt.setString(109, (String) tabdata.get("ipclass"));
				pstmt.setString(110, (String) tabdata.get("dcclass"));
				pstmt.setString(111, (String) tabdata.get("emclass"));
				pstmt.setString(112, (String) tabdata.get("rd_appl_yn"));				
			 	pstmt.setString(113, modifiedFacilityId);
				pstmt.setString(114, (String) tabdata.get("cliniccode"));
			}*/
			pstmt.setString(nCount++, (String) tabdata.get("CALC_WAIT_TIME_BASED_ON"));//Included the column CALC_WAIT_TIME_BASED_ON for Bru-HIMS-CRF-179-DD1
			pstmt.setString(nCount++, (String) tabdata.get("diagnosis_not_mndt")); //Added by Sangeetha for ML-MMOH-CRF-0547
			pstmt.setString(nCount++, (String) tabdata.get("contactno")); //Added by shagar for MO-CRF-20121.1
			pstmt.setString(nCount++, (String) tabdata.get("clinic_type_sub")); //Added by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6
			pstmt.setString(nCount++, modifiedFacilityId);
			pstmt.setString(nCount++, (String) tabdata.get("cliniccode"));
				
			rest = pstmt.executeUpdate();
			if (pstmt != null)
				pstmt.close();
            pstmt = con.prepareStatement(pat_ins_sql_del);
			pstmt.setString(1, (String) tabdata.get("addedFacilityId"));
			pstmt.setString(2, (String) tabdata.get("cliniccode"));
            pstmt.executeUpdate(); 
			if (pstmt != null)
				pstmt.close();

			pstmt = con.prepareStatement(pat_ins_sql);
			pat_ins_bean_ejb= (ArrayList)tabdata.get("pat_ins_bean");
			int size=pat_ins_bean_ejb.size();			
			size=size/4;
			if(size > 0)
			{
			int k=-1;
			for(int m=0;m<size;m++)
			{
				k++;
				display_order=Integer.parseInt(pat_ins_bean_ejb.get(k).toString());
				k=k+2;
				pat_ins_id=pat_ins_bean_ejb.get(k).toString();
				default_yn=pat_ins_bean_ejb.get(++k).toString();				
				pstmt.setString(1, (String) tabdata.get("addedFacilityId"));
				pstmt.setString(2, (String) tabdata.get("cliniccode"));
				pstmt.setString(3, pat_ins_id);
				pstmt.setInt(4, display_order);
				pstmt.setString(5, default_yn);
				pstmt.setString(6,addedById);
				pstmt.setDate(7, added_date);
				pstmt.setString(8, (String) tabdata.get("addedAtWorkstation"));
				pstmt.setString(9, (String) tabdata.get("addedFacilityId"));
				pstmt.setString(10, modifiedById);
				pstmt.setDate(11, modified_date);
				pstmt.setString(12, modifiedAtWorkstation);
				pstmt.setString(13, modifiedFacilityId);
				pstmt.addBatch();
		}		
        int[] iNoRows = pstmt.executeBatch();
		if(size == iNoRows.length && size > 0 && iNoRows.length > 0)
			rest=rest;
		else
			rest=0;
		}
		if (pstmt != null)
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			rest = 0;
		}
		tabdata.clear();
		return rest;
	}

}
