/*Created by Ashwini on 25-May-2017 for ML-MMOH-CRF-0610*/
package eOA;

import java.sql.*;
import java.io.*;
import java.util.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;

public class OACommonBean implements Serializable{

	public static JSONArray getSpeciality(Connection con, String locale) throws Exception{
		Statement stmt		=null;
		ResultSet rs 		= null;
		JSONArray arrJSON	= new JSONArray();

		try{
			String sql = "select short_desc, speciality_code from am_speciality_lang_vw where eff_status = 'E' and language_id='"+locale+"' order by short_desc";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				String Spec_short_desc		= rs.getString("short_desc")==null?"":rs.getString("short_desc");
				jsonObj.put("short_desc",Spec_short_desc);
				String speciality_code		= rs.getString("speciality_code")==null?"":rs.getString("speciality_code");
				jsonObj.put("speciality_code",speciality_code);
				arrJSON.add(jsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getSpeciality - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}

	public static JSONArray getLocationType(Connection con, String locale) throws Exception{
		Statement stmt1			=null;
		ResultSet rs1 			= null;
		JSONArray locArrJSON	= new JSONArray();

		try{
			String sql1 = "select locn_type,short_desc,CARE_LOCN_TYPE_IND from am_care_locn_type_lang_vw where SYS_USER_DEF_IND='S' and locn_type in ('C','E','Y') and language_id='"+locale+"' order by short_desc";
			
			stmt1 = con.createStatement();
			rs1	= stmt1.executeQuery(sql1);

			while(rs1!=null && rs1.next()){
				
				JSONObject jsonObjLoc	= new JSONObject();
				String loc_short_desc		= rs1.getString("short_desc")==null?"":rs1.getString("short_desc");
				String care_locn_type_ind	= rs1.getString("care_locn_type_ind")==null?"":rs1.getString("care_locn_type_ind");
				String locn_type			= rs1.getString("locn_type")==null?"":rs1.getString("locn_type");
				
				jsonObjLoc.put("short_desc",loc_short_desc);
				jsonObjLoc.put("care_locn_type_ind",care_locn_type_ind);
				jsonObjLoc.put("locn_type",locn_type);
				locArrJSON.add(jsonObjLoc);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs1!=null)rs1.close();
				if(stmt1!=null)stmt1.close();
			}catch(Exception ex){
				System.err.println("Exception in getLocationType - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return locArrJSON;
	}

	public static JSONObject getApptHistory(Connection con, String locale, String patient_id, String speciality, String frm_appt_date, String to_appt_date, String location_type ,String b_loc_val, String resourceType_1, String practitioner_name, String p_fm_service_code, String p_to_service_code, String facility_id,int recordsPerPage,int currentPageNo) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rset 			= null;
		JSONObject json			= new JSONObject();
		JSONArray arrJSON		= new JSONArray();
		StringBuffer sqlQuery	= new StringBuffer();
	
		int noOfRecs				= 0;
		int noOfRecords 			= 0;
		int noOfPages	 			= 0;	
		int from 		 			= 1;
		int to			 			= recordsPerPage;

		if(currentPageNo!=1){
			from		= (currentPageNo - 1) * recordsPerPage +1;
			to			= (from -1) + recordsPerPage;
		}

		try
		{
			sqlQuery.append("SELECT *  FROM (SELECT ROWNUM AS rcnt, results.* FROM ( ");
			sqlQuery.append("SELECT COUNT (*) OVER () noofrecords, rnm, status, facility_id, patient_id, patient_name, appt_ref_no, app_date, app_re_schedule,");
			sqlQuery.append("app_cancel, speciality, LOCATION, resources, service, reason, remarks, done_by, action_date, app_date_order FROM (");
			sqlQuery.append("SELECT '1' rnm, 'APPT-BOOKED' status, a.facility_id, a.patient_id, a.patient_name, TO_NUMBER (a.appt_ref_no) appt_ref_no, TO_CHAR (a.appt_date, 'DD/MM/YYYY') || ' ' || TO_CHAR (a.appt_slab_from_time, 'HH24:MI') app_date, TO_CHAR ('') app_re_schedule, TO_CHAR ('') app_cancel, am_get_desc.am_speciality (a.speciality_code, '"+locale+"', '2' ) speciality, DECODE (a.care_locn_type_ind, 'C', 'Clinic', 'D', 'Daycare Unit', 'E', 'Procedure Unit' ) || ' / ' || op_get_desc.op_clinic (a.facility_id, a.clinic_code, '"+locale+"', '1' ) LOCATION, DECODE (a.resource_class, 'P', 'Practitioner', 'E', 'Equipment', 'R', 'Room', 'O', 'Other' ) || ' / ' || DECODE (a.resource_class, 'P', am_get_desc.am_practitioner (a.practitioner_id, '"+locale+"', '1' ), 'E', am_get_desc.am_resource (a.facility_id, a.practitioner_id, '"+locale+"', '2' ), 'R', am_get_desc.am_facility_room (a.facility_id, a.practitioner_id, '"+locale+"', '2' ), 'O', am_get_desc.am_resource (a.facility_id, a.practitioner_id, '"+locale+"', '2' ) ) resources, am_get_desc.am_service (a.service_code, '"+locale+"', '2') service, '' reason, '' remarks, sm_get_desc.sm_appl_user (a.added_by_id, '"+locale+"', '1') done_by, TO_CHAR (a.added_date, 'DD/MM/YYYY HH24:MI') action_date, TO_NUMBER (1) app_date_order FROM oa_appt a WHERE a.facility_id = '"+facility_id+"' AND NOT EXISTS ( SELECT 'Y' FROM oa_appt_del_tr m WHERE a.facility_id = m.facility_id AND a.appt_ref_no = m.appt_ref_no AND m.srlno = '1') AND NVL (a.patient_id, 'X') LIKE UPPER (NVL ('"+patient_id+"', '%')) AND NVL (a.speciality_code, 'X') LIKE UPPER (NVL ('"+speciality+"', '%')) AND a.care_locn_type_ind LIKE UPPER (NVL ('"+location_type+"', '%')) AND a.clinic_code LIKE UPPER (NVL ('"+b_loc_val+"', '%')) AND a.resource_class LIKE UPPER (NVL ('"+resourceType_1+"', '%')) AND a.practitioner_id LIKE UPPER (NVL ('"+practitioner_name+"', '%')) AND NVL (a.service_code, 'X') BETWEEN NVL ('"+p_fm_service_code+"', '!') AND NVL ('"+p_to_service_code+"', '~') AND a.appt_date BETWEEN TO_DATE (NVL ('"+frm_appt_date+"', '01/01/1970'), 'DD/MM/YYYY' ) AND TO_DATE (NVL ('"+to_appt_date+"', '01/12/2050'), 'DD/MM/YYYY' ) UNION SELECT '1' rnm, 'APPT-BOOKED' status, c.facility_id, c.patient_id, c.patient_name, TO_NUMBER (c.appt_ref_no) appt_ref_no, TO_CHAR (c.appt_date, 'DD/MM/YYYY') || ' ' || TO_CHAR (c.appt_slab_from_time, 'HH24:MI') app_date, TO_CHAR ('') app_re_schedule, TO_CHAR ('') app_cancel, am_get_desc.am_speciality (NVL (c.from_speciality_code, c.speciality_code ), '"+locale+"', '2' ) speciality, DECODE (c.care_locn_type_ind, 'C', 'Clinic', 'D', 'Daycare Unit', 'E', 'Procedure Unit' ) || ' / ' || op_get_desc.op_clinic (c.facility_id, NVL (c.from_clinic_code, c.clinic_code), '"+locale+"', '1' ) LOCATION, DECODE (c.resource_class, 'P', 'Practitioner', 'E', 'Equipment', 'R', 'Room', 'O', 'Other' ) || ' / ' || DECODE (c.resource_class, 'P', am_get_desc.am_practitioner (c.practitioner_id, '"+locale+"', '1' ), 'E', am_get_desc.am_resource (c.facility_id, c.practitioner_id, '"+locale+"', '2' ), 'R', am_get_desc.am_facility_room (c.facility_id, c.practitioner_id, '"+locale+"', '2' ), 'O', am_get_desc.am_resource (c.facility_id, c.practitioner_id, '"+locale+"', '2' ) ) resources, am_get_desc.am_service (c.service_code, '"+locale+"', '2') service, '' reason, '' remarks, sm_get_desc.sm_appl_user (c.appt_booked_by_id, '"+locale+"', '1' ) done_by, TO_CHAR (c.appt_booked_date, 'DD/MM/YYYY HH24:MI') action_date, c.srlno app_date_order FROM oa_appt_del_tr b, oa_appt_del_tr c WHERE b.facility_id = '"+facility_id+"' AND b.facility_id = c.facility_id AND b.appt_ref_no = c.appt_ref_no AND c.appt_ref_no LIKE '%%' AND c.srlno = '1' AND b.srlno = c.srlno AND EXISTS ( SELECT 'Y' FROM oa_appt_del_tr a WHERE a.facility_id = b.facility_id AND a.appt_ref_no = b.appt_ref_no AND NVL (a.appt_tr_date, a.appt_date) = NVL (b.appt_tr_date, b.appt_date) AND TRUNC (a.appt_date) BETWEEN TO_DATE (NVL ('"+frm_appt_date+"', '01/01/1970' ), 'DD/MM/YYYY' ) AND TO_DATE (NVL ('"+to_appt_date+"', '01/12/2050' ), 'DD/MM/YYYY' )) AND NVL (b.patient_id, 'X') LIKE UPPER (NVL ('"+patient_id+"', '%')) AND NVL (b.from_speciality_code, b.speciality_code) LIKE UPPER (NVL ('"+speciality+"', '%')) AND b.care_locn_type_ind LIKE UPPER (NVL ('"+location_type+"', '%')) AND NVL (b.from_clinic_code, b.clinic_code) LIKE UPPER (NVL ('"+b_loc_val+"', '%')) AND b.resource_class LIKE UPPER (NVL ('"+resourceType_1+"', '%')) AND b.practitioner_id LIKE UPPER (NVL ('"+practitioner_name+"', '%')) AND NVL (b.service_code, 'X') BETWEEN NVL ('"+p_fm_service_code+"', '!') AND NVL ('"+p_to_service_code+"', '~') AND DECODE (b.appt_status, 'S', TRUNC (b.appt_date), TRUNC (b.appt_tr_date) ) BETWEEN TO_DATE (NVL ('"+frm_appt_date+"', '01/01/1970'), 'DD/MM/YYYY' ) AND TO_DATE (NVL ('"+to_appt_date+"', '01/12/2050'), 'DD/MM/YYYY' ) UNION SELECT '2' rnm, 'APPT-RESCHEDULE' status, b.facility_id, b.patient_id, b.patient_name, TO_NUMBER (b.appt_ref_no) appt_ref_no, TO_CHAR (b.appt_date, 'DD/MM/YYYY') || ' ' || TO_CHAR (b.appt_slab_from_time, 'HH24:MI') app_date, TO_CHAR (b.appt_tr_date, 'DD/MM/YYYY') || ' ' || TO_CHAR (NVL (b.tr_appt_slab_from_time, b.appt_slab_from_time), 'HH24:MI' ) app_re_schedule, TO_CHAR ('') app_cancel, am_get_desc.am_speciality (b.speciality_code, '"+locale+"', '2' ) speciality, DECODE (b.care_locn_type_ind, 'C', 'Clinic', 'D', 'Daycare Unit', 'E', 'Procedure Unit' ) || ' / ' || op_get_desc.op_clinic (b.facility_id, b.clinic_code, '"+locale+"', '1' ) LOCATION, DECODE (NVL (b.tr_resource_class, b.resource_class), 'P', 'Practitioner', 'E', 'Equipment', 'R', 'Room', 'O', 'Other' ) || ' / ' || DECODE (NVL (b.tr_resource_class, b.resource_class), 'P', am_get_desc.am_practitioner (NVL (b.tr_practitioner_id, b.practitioner_id ), '"+locale+"', '1' ), 'E', am_get_desc.am_resource (b.facility_id, NVL (b.tr_practitioner_id, b.practitioner_id ), '"+locale+"', '2' ), 'R', am_get_desc.am_facility_room (b.facility_id, NVL (b.tr_practitioner_id, b.practitioner_id ), '"+locale+"', '2' ), 'O', am_get_desc.am_resource (b.facility_id, NVL (b.tr_practitioner_id, b.practitioner_id ), '"+locale+"', '2' ) ) resources, am_get_desc.am_service (b.service_code, '"+locale+"', '2') service, am_get_desc.am_contact_reason (b.reason_for_transfer, '"+locale+"', '1' ) reason, remarks_for_transfer remarks, sm_get_desc.sm_appl_user (b.added_by_id, '"+locale+"', '1') done_by, TO_CHAR (b.added_date, 'DD/MM/YYYY HH24:MI') action_date, b.srlno app_date_order FROM oa_appt_del_tr b WHERE b.facility_id = '"+facility_id+"' AND b.appt_status IN ('N', 'T') AND NVL (b.patient_id, 'X') LIKE UPPER (NVL ('"+patient_id+"', '%')) AND NVL (b.speciality_code, 'X') LIKE UPPER (NVL ('"+speciality+"', '%')) AND b.care_locn_type_ind LIKE UPPER (NVL ('"+location_type+"', '%')) AND b.clinic_code LIKE UPPER (NVL ('"+b_loc_val+"', '%')) AND NVL (b.tr_resource_class, b.resource_class) LIKE UPPER (NVL ('"+resourceType_1+"', '%')) AND NVL (b.tr_practitioner_id, b.practitioner_id) LIKE UPPER (NVL ('"+practitioner_name+"', '%')) AND NVL (b.service_code, 'X') BETWEEN NVL ('"+p_fm_service_code+"', '!') AND NVL ('"+p_to_service_code+"', '~') AND TRUNC (b.appt_tr_date) BETWEEN TO_DATE (NVL ('"+frm_appt_date+"', '01/01/1970' ), 'DD/MM/YYYY' ) AND TO_DATE (NVL ('"+to_appt_date+"', '01/12/2050' ), 'DD/MM/YYYY' ) UNION SELECT '3' rnm, 'APPT-CANCEL' status, b.facility_id, b.patient_id, b.patient_name, TO_NUMBER (b.appt_ref_no) appt_ref_no, TO_CHAR (b.appt_date, 'DD/MM/YYYY') || ' ' || TO_CHAR (b.appt_slab_from_time, 'HH24:MI') app_date, TO_CHAR ('') app_re_schedule, DECODE (b.appt_status, 'S', TO_CHAR (b.added_date, 'DD/MM/YYYY'), TO_CHAR (b.appt_tr_date, 'DD/MM/YYYY HH24:MI') ) app_cancel, am_get_desc.am_speciality (b.speciality_code, '"+locale+"', '2' ) speciality, DECODE (b.care_locn_type_ind, 'C', 'Clinic', 'D', 'Daycare Unit', 'E', 'Procedure Unit' ) || ' / ' || op_get_desc.op_clinic (b.facility_id, b.clinic_code, '"+locale+"', '1' ) LOCATION, DECODE (b.resource_class, 'P', 'Practitioner', 'E', 'Equipment', 'R', 'Room', 'O', 'Other' ) || ' / ' || DECODE (b.resource_class, 'P', am_get_desc.am_practitioner (b.practitioner_id, '"+locale+"', '1' ), 'E', am_get_desc.am_resource (b.facility_id, b.practitioner_id, '"+locale+"', '2' ), 'R', am_get_desc.am_facility_room (b.facility_id, b.practitioner_id, '"+locale+"', '2' ), 'O', am_get_desc.am_resource (b.facility_id, b.practitioner_id, '"+locale+"', '2' ) ) resources, am_get_desc.am_service (b.service_code, '"+locale+"', '2') service, am_get_desc.am_contact_reason (b.reason_for_cancel, '"+locale+"', '1' ) reason, remarks_for_cancel remarks, sm_get_desc.sm_appl_user (b.added_by_id, '"+locale+"', '1') done_by, DECODE (b.appt_status, 'S', TO_CHAR (b.added_date, 'DD/MM/YYYY'), TO_CHAR (b.added_date, 'DD/MM/YYYY HH24:MI') ) action_date, b.srlno app_date_order FROM oa_appt_del_tr b WHERE b.facility_id = '"+facility_id+"' AND b.appt_status IN ('C', 'S') AND NVL (b.patient_id, 'X') LIKE UPPER (NVL ('"+patient_id+"', '%')) AND NVL (b.speciality_code, 'X') LIKE UPPER (NVL ('"+speciality+"', '%')) AND b.care_locn_type_ind LIKE UPPER (NVL ('"+location_type+"', '%')) AND b.clinic_code LIKE UPPER (NVL ('"+b_loc_val+"', '%')) AND b.resource_class LIKE UPPER (NVL ('"+resourceType_1+"', '%')) AND b.practitioner_id LIKE UPPER (NVL ('"+practitioner_name+"', '%')) AND NVL (b.service_code, 'X') BETWEEN NVL ('"+p_fm_service_code+"', '!') AND NVL ('"+p_to_service_code+"', '~') AND TRUNC (b.appt_date) BETWEEN TO_DATE (NVL ('"+frm_appt_date+"', '01/01/1970' ), 'DD/MM/YYYY' ) AND TO_DATE (NVL ('"+to_appt_date+"', '01/12/2050'), 'DD/MM/YYYY' ) ORDER BY appt_ref_no, rnm, app_date_order");			sqlQuery.append(" )) results) where rcnt between '"+from+"' AND '"+to+"'"); //Remarks Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

			pstmt= con.prepareStatement(sqlQuery.toString());
			rset= pstmt.executeQuery();

			while(rset!=null && rset.next())
			{
				JSONObject jsonObj	= new JSONObject();
				noOfRecs	= rset.getInt("noOfRecords");
				String pat_id = rset.getString("patient_id")==null?"":rset.getString("patient_id");
				String patient_name = rset.getString("patient_name")==null?"":rset.getString("patient_name");
				String appt_ref_no = rset.getString("appt_ref_no")==null?"":rset.getString("appt_ref_no");
				String app_date = rset.getString("app_date")==null?"":rset.getString("app_date");
				String app_re_schedule = rset.getString("app_re_schedule")==null?"":rset.getString("app_re_schedule");
				String app_cancel = rset.getString("app_cancel")==null?"":rset.getString("app_cancel");
				String speciality1 = rset.getString("speciality")==null?"":rset.getString("speciality");
				String location = rset.getString("location")==null?"":rset.getString("location");
				String resources = rset.getString("resources")==null?"":rset.getString("resources");
				String service = rset.getString("service")==null?"":rset.getString("service");
				String status = rset.getString("status")==null?"":rset.getString("status");
				String reason = rset.getString("reason")==null?"":rset.getString("reason");
				String done_by= rset.getString("done_by")==null?"":rset.getString("done_by");
				String action_date = rset.getString("action_date")==null?"":rset.getString("action_date");
				String remarks = rset.getString("remarks")==null?"":rset.getString("remarks"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

				jsonObj.put("patient_id",pat_id);
				jsonObj.put("patient_name",patient_name);
				jsonObj.put("appt_ref_no",appt_ref_no);
				jsonObj.put("app_date",app_date);
				jsonObj.put("app_re_schedule",app_re_schedule);
				jsonObj.put("app_cancel",app_cancel);
				jsonObj.put("speciality",speciality1);
				jsonObj.put("location",location);
				jsonObj.put("resources",resources);
				jsonObj.put("service",service);
				jsonObj.put("status",status);
				jsonObj.put("reason",reason);
				jsonObj.put("done_by",done_by);
				jsonObj.put("action_date",action_date);
				jsonObj.put("remarks",remarks); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
				arrJSON.add(jsonObj);
			}

			noOfPages = (int) Math.ceil(noOfRecs * 1.0 / recordsPerPage);
			if(to > noOfRecs)	{
				to	= noOfRecs;
			}
			json.put("ApptHisjsonArr",arrJSON);
			json.put("currentPageNo", currentPageNo);
			json.put("noOfRecords", noOfRecs);
			json.put("noOfPages", noOfPages);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try
			{
				if(rset!=null)rset.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getApptHistory - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return json;
	}
	public static String getApptRemarks(Connection con, String facilityId, String apptNo) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String apptRemarks		= "";
		String sql				= "";
		try{
			
			//sql	= " SELECT appt_remarks FROM oa_appt WHERE facility_id = '"+facilityId+"' AND appt_ref_no = '"+apptNo+"' ";
			sql	= " SELECT appt_remarks FROM oa_appt WHERE facility_id = ? AND appt_ref_no = ? ";
			
			pstmt	= con.prepareStatement(sql);
			pstmt.setString(1,facilityId);
			pstmt.setString(2,apptNo);
			rs		= pstmt.executeQuery();
			while(rs!=null && rs.next()){
				apptRemarks	= checkForNull(rs.getString("appt_remarks"));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getApptRemarks - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return apptRemarks;
	} 
	/*End*/
	/* added by mujafar for ML-MMOH-CRF-1070 */
	public static String getVIPPatient(Connection con, String patient_id, String facilityId) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String vip_result_yn		= "";
		String sql				= "";
		try{
			
			
			//sql = " SELECT NVL ((SELECT CASE WHEN govt_or_pvt_ind = 'V' THEN 'TRUE' ELSE 'FALSE' END vip FROM (SELECT a.pat_cat_code, b.govt_or_pvt_ind FROM mp_patient a, mp_pat_category b WHERE patient_id = '"+patient_id+"' and a.added_facility_id='"+facilityId+"' AND a.pat_cat_code = b.pat_cat_code and a.added_facility_id = b.added_facility_id)), 'FALSE' )vip_result  FROM DUAL  ";
			sql = " SELECT NVL ((SELECT CASE WHEN govt_or_pvt_ind = 'V' THEN 'TRUE' ELSE 'FALSE' END vip FROM (SELECT a.pat_cat_code, b.govt_or_pvt_ind FROM mp_patient a, mp_pat_category b WHERE patient_id = ? and a.added_facility_id=? AND a.pat_cat_code = b.pat_cat_code and a.added_facility_id = b.added_facility_id)), 'FALSE' )vip_result  FROM DUAL  ";
			
			pstmt	= con.prepareStatement(sql);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,facilityId);
			rs		= pstmt.executeQuery();
			
			System.out.println("sql::"+sql);

			if(rs!=null && rs.next()){
				vip_result_yn	= checkForNull(rs.getString("VIP_RESULT"));
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getVIPPatient - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		
		System.out.println("final vip_result_yn ::"+vip_result_yn);
		
		return vip_result_yn;
	} 
	
	/*Added by Ashwini on 27-May-2020 for MOHE-CRF-0017*/
	public static String getTimeElapsedYN(Connection con, String end_time, String current_time) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String time_elapsed_yn	= "";
		String sql				= "";

		try{
			
			sql	= " SELECT NVL ((SELECT 'Y' FROM DUAL WHERE '"+end_time+"' < '"+current_time+"'), 'N') time_elapsed_yn FROM DUAL ";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs!=null && rs.next()){

				time_elapsed_yn	= checkForNull(rs.getString("time_elapsed_yn"));
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getTimeElapsedYN - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return time_elapsed_yn;
	}

	public static int getScheduleCount(Connection con, String clinic_code, String practitioner_id,  String facility_id, String start_time) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String sql				= "";
		int sch_cnt				= 0;

		try{
			
			//sql	= " SELECT COUNT (*) sch_count FROM oa_clinic_schedule_slot_slab WHERE clinic_code = '"+clinic_code+"' AND TRUNC (clinic_date) = TRUNC (SYSDATE) AND practitioner_id = '"+practitioner_id+"' AND facility_id = '"+facility_id+"' AND pri_appt_ref_no IS NULL AND TO_DATE (TO_CHAR (SYSDATE, 'hh24:mi'), 'hh24:mi') > TO_DATE ('"+start_time+"', 'hh24:mi') AND TO_DATE (TO_CHAR (slot_slab_end_time, 'hh24:mi'), 'hh24:mi') < TO_DATE (TO_CHAR (SYSDATE, 'hh24:mi'), 'hh24:mi') ";
			sql	= " SELECT COUNT (*) sch_count FROM oa_clinic_schedule_slot_slab WHERE clinic_code = ? AND TRUNC (clinic_date) = TRUNC (SYSDATE) AND practitioner_id = ? AND facility_id = ? AND pri_appt_ref_no IS NULL AND TO_DATE (TO_CHAR (SYSDATE, 'hh24:mi'), 'hh24:mi') > TO_DATE (?, 'hh24:mi') AND TO_DATE (TO_CHAR (slot_slab_end_time, 'hh24:mi'), 'hh24:mi') < TO_DATE (TO_CHAR (SYSDATE, 'hh24:mi'), 'hh24:mi') ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,clinic_code);
			pstmt.setString(2,practitioner_id);
			pstmt.setString(3,facility_id);
			pstmt.setString(4,start_time);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){

				sch_cnt	= rs.getInt("sch_count");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getScheduleCount - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return sch_cnt;
	}
	/*End MOHE-CRF-0017*/
	
	/*Added by Ashwini on 24-Jun-2020 for PMG2020-MOHE-CRF-0001*/
	public static int getFutureSlotCount(Connection con, String clinic_code, String practitioner_id,  String facility_id, String start_time, String end_time) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String sql				= "";
		int future_slot_count	= 0;

		try{
			
			//sql	= " SELECT COUNT (*) future_slot_count FROM oa_clinic_schedule_slot_slab WHERE clinic_code = '"+clinic_code+"' AND TRUNC (clinic_date) = TRUNC (SYSDATE) AND practitioner_id = '"+practitioner_id+"' AND facility_id = '"+facility_id+"' AND pri_appt_ref_no IS NULL AND TO_DATE (TO_CHAR (SYSDATE, 'hh24:mi'), 'hh24:mi') > TO_DATE ('"+start_time+"', 'hh24:mi') AND TO_DATE (TO_CHAR (SYSDATE, 'hh24:mi'), 'hh24:mi') < TO_DATE ('"+end_time+"', 'hh24:mi') AND TO_DATE (TO_CHAR (slot_slab_end_time, 'hh24:mi'), 'hh24:mi') > TO_DATE (TO_CHAR (SYSDATE, 'hh24:mi'), 'hh24:mi') ";
			sql	= " SELECT COUNT (*) future_slot_count FROM oa_clinic_schedule_slot_slab WHERE clinic_code = ? AND TRUNC (clinic_date) = TRUNC (SYSDATE) AND practitioner_id = ? AND facility_id = ? AND pri_appt_ref_no IS NULL AND TO_DATE (TO_CHAR (SYSDATE, 'hh24:mi'), 'hh24:mi') > TO_DATE (?, 'hh24:mi') AND TO_DATE (TO_CHAR (SYSDATE, 'hh24:mi'), 'hh24:mi') < TO_DATE (?, 'hh24:mi') AND TO_DATE (TO_CHAR (slot_slab_end_time, 'hh24:mi'), 'hh24:mi') > TO_DATE (TO_CHAR (SYSDATE, 'hh24:mi'), 'hh24:mi') ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,clinic_code);
			pstmt.setString(2,practitioner_id);
			pstmt.setString(3,facility_id);
			pstmt.setString(4,start_time);
			pstmt.setString(5,end_time);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){

				future_slot_count	= rs.getInt("future_slot_count");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getFutureSlotCount - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return future_slot_count;
	}
	/*End PMG2020-MOHE-CRF-0001*/  

	/*Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112*/
	public static int getScheduleExtendYNCnt(Connection con) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		String sql					= "";
		int extnd_cnt				= 0;

		try{
			sql	= "SELECT SUM (schedule_exist) schedule_exist_cnt FROM (SELECT COUNT (*) schedule_exist FROM oa_clinic_schedule WHERE schedule_extend_yn = 'Y' UNION SELECT COUNT (*) schedule_exist FROM oa_clinic_time_table WHERE schedule_extend_yn = 'Y')";
			
			pstmt			= con.prepareStatement(sql);
			rs				= pstmt.executeQuery();

			if(rs!=null && rs.next()){
				extnd_cnt	= rs.getInt("schedule_exist_cnt");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getScheduleExtendYNCnt method - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return extnd_cnt;
	}

	public static String getEndTimeDifference(Connection con, String endtime) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String time_diff		= "";
		String sql				= "";

		try{
			
			sql	= " SELECT TO_CHAR ( TO_DATE ('00:00', 'hh24:mi') + ( TO_DATE ('23:59', 'hh24:mi') - TO_DATE ('"+endtime+"', 'hh24:mi') ), 'hh24:mi' ) AS time_diff FROM DUAL ";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs!=null && rs.next()){

				time_diff = checkForNull(rs.getString("time_diff"));
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getEndTimeDifference - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return time_diff;
	}
	/*End NMC-JD-CRF-0112*/
	

	public static String checkForNull(String inputString){
		return(((inputString==null) || (("null").equals(inputString))) ? "" : inputString);
	}
}
/* End ML-MMOH-CRF-0610 */