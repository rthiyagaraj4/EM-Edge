/*Created by Dharma on June 16th 2015*/
package eOA;
import java.util.* ;
import java.io.* ;
import java.sql.* ;
import javax.servlet.http.* ;
import javax.servlet.jsp.PageContext;
import webbeans.eCommon.*;
import eDS.Common.*;

public class PatientPortalBean implements java.io.Serializable{

	public static String getSpecialityLists(Connection con,String locale,String facilityID){
    	String returnStr 	= "";
        PreparedStatement pstmt=null;
    	ResultSet rs=null;
    	try{
	    	//String sql = " select am_get_desc.AM_SPECIALITY(speciality_code,'"+locale+"',2) short_desc, speciality_code from am_speciality where  eff_status='E' ";
	    	//String sql = "select distinct am_get_desc.AM_SPECIALITY(a.speciality_code,'"+locale+"',2) short_desc, speciality_code from oa_clinic_schedule a,oa_clinic_time_table b where a.facility_id = b.facility_id and trunc(a.clinic_date) > trunc(sysdate) and a.facility_id = '"+facilityID+"' and a.time_table_type!=3  and a.clinic_code = b.clinic_code  AND a.srl_no LIKE '%%' AND a.clinic_code LIKE '%%'  order by SHORT_DESC";
			
			//String sql = "select distinct am_get_desc.AM_SPECIALITY(a.speciality_code,'"+locale+"',2) short_desc, speciality_code from oa_clinic_schedule a,oa_clinic_time_table b where  a.facility_id = b.facility_id and  trunc(a.clinic_date) > trunc(sysdate) and a.facility_id = '"+facilityID+"' and a.time_table_type!=3  and a.clinic_code = b.clinic_code    order by SHORT_DESC";
			
			//String sql = "select distinct a.speciality_code, am_get_desc.AM_SPECIALITY(a.speciality_code,'"+locale+"',2) short_desc  from oa_clinic_schedule a,oa_clinic_time_table b where  trunc(a.clinic_date) > trunc(sysdate) and  a.clinic_code = b.clinic_code and a.facility_id = '"+facilityID+"' and a.time_table_type!= '3'  and a.PRACTITIONER_ID = b.PRACTITIONER_ID   ORDER BY short_desc"; 
           
			String sql = "select distinct a.speciality_code,(SELECT short_desc FROM am_speciality_lang_vw  WHERE speciality_code = a.speciality_code AND language_id = '"+locale+"')  short_desc from oa_clinic_schedule a,oa_clinic_time_table b where  a.facility_id = '"+facilityID+"'  and a.clinic_code = b.clinic_code  and trunc(a.clinic_date) > trunc(sysdate) and  a.time_table_type!=3    order by SHORT_DESC";
			
			
			
			
			
			
	    	pstmt = con.prepareStatement(sql);
			System.err.println("qry Speciality List==>"+sql);

	    	rs = pstmt.executeQuery();
	    	JSONObject json		= new JSONObject();
	    	JSONArray jsonArray = new JSONArray();
	    	while(rs!=null && rs.next()){
	    		JSONObject jsonobj 				= new JSONObject();
	    		jsonobj.put("speciality_code",rs.getString("speciality_code"));
	    		jsonobj.put("short_desc",rs.getString("short_desc"));
	    		jsonArray.put(jsonobj);
	    	}
	    	json.put("results",jsonArray);
	    	
	    	returnStr		= json.toString();
    	}catch(Exception ex){
			System.err.println("Exception in getSpecialityLists - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
    	return returnStr;
    }

	public static String getDaysOfWeek(Connection con){
    	String returnStr 	= "";
        PreparedStatement pstmt=null;
    	ResultSet rs=null;
    	try{
	    	String sql = " select day_no,day_of_week from sm_day_of_week order by day_no asc";
	    	pstmt = con.prepareStatement(sql);
	    	rs = pstmt.executeQuery();
	    	JSONObject json		= new JSONObject();
	    	JSONArray jsonArray = new JSONArray();
	    	while(rs!=null && rs.next()){
	    		JSONObject jsonobj 				= new JSONObject();
	    		jsonobj.put("day_no",rs.getString("day_no"));
	    		jsonobj.put("day_of_week",rs.getString("day_of_week"));
	    		jsonArray.put(jsonobj);
	    	}
	    	json.put("daysList",jsonArray);
	    	
	    	returnStr		= json.toString();
    	}catch(Exception ex){
			System.err.println("Exception in getDaysOfWeek - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
    	return returnStr;
    }


	public static String getPratitionerList(Connection con,String specialityCode,String locale,String facilityID){
    	String returnStr 	= "";
        PreparedStatement pstmt=null;
    	ResultSet rs=null;
		String resource_type = "";
		int rowCnt	= 0;
    	try{
	    //	String sql = " SELECT A.srl_no,a.max_patients_per_slab,to_char(A.time_per_patient, 'hh24:mi') time_per_patient, to_char(A.time_per_slab, 'hh24:mi') time_per_slab, op_get_desc.op_clinic (A.facility_id,A.clinic_code,'"+locale+"','1') clinic_short_desc,A.clinic_code, A.resource_class, A.practitioner_id, DECODE (A.resource_class,'P', am_get_desc.am_practitioner (A.practitioner_id, '"+locale+"', '1'),'R', am_get_desc.am_facility_room (A.facility_id,A.practitioner_id,'"+locale+"','2'),'E', am_get_desc.am_resource (A.facility_id, A.practitioner_id, '"+locale+"', '2'),'O', am_get_desc.am_resource (A.facility_id, A.practitioner_id, '"+locale+"', '2') ) practitioner_short_name, A.day_no, TO_CHAR(A.start_time,'HH24:MI') start_time, TO_CHAR(A.end_time,'HH24:MI') end_time , a.max_patients_per_day, A.resource_type, A.time_table_type, A.care_locn_type_ind FROM oa_clinic_time_table A WHERE (a.clinic_code, a.day_no) IN ( SELECT b.clinic_code, (SELECT day_no FROM sm_day_of_week WHERE LTRIM (RTRIM (day_of_week)) IN ( SELECT LTRIM (RTRIM ((TO_CHAR (b.clinic_date, 'DAY' )))) FROM DUAL)) FROM oa_clinic_schedule b WHERE a.facility_id = b.facility_id               AND a.clinic_code = b.clinic_code AND a.practitioner_id = b.practitioner_id AND b.speciality_code = '"+specialityCode+"' AND a.time_table_type != 3 and b.schedule_status is null AND TRUNC (clinic_date) > TRUNC (SYSDATE))  and a.practitioner_id is not null  and a.time_table_type!=3 ORDER BY clinic_short_desc,a.clinic_code,a.practitioner_id, practitioner_short_name, a.day_no ";
	    	String sql = " SELECT A.srl_no,a.max_patients_per_slab,to_char(A.time_per_patient, 'hh24:mi') time_per_patient, to_char(A.time_per_slab, 'hh24:mi') time_per_slab, op_get_desc.op_clinic (A.facility_id,A.clinic_code,?,'1') clinic_short_desc,A.clinic_code, A.resource_class, A.practitioner_id, DECODE (A.resource_class,'P', am_get_desc.am_practitioner (A.practitioner_id,?, '1'),'R', am_get_desc.am_facility_room (A.facility_id,A.practitioner_id,?,'2'),'E', am_get_desc.am_resource (A.facility_id, A.practitioner_id,?, '2'),'O', am_get_desc.am_resource (A.facility_id, A.practitioner_id,?, '2') ) practitioner_short_name, A.day_no, TO_CHAR(A.start_time,'HH24:MI') start_time, TO_CHAR(A.end_time,'HH24:MI') end_time , a.max_patients_per_day, A.resource_type, A.time_table_type, A.care_locn_type_ind FROM oa_clinic_time_table A WHERE (a.clinic_code, a.day_no) IN ( SELECT b.clinic_code, (SELECT day_no FROM sm_day_of_week WHERE LTRIM (RTRIM (day_of_week)) IN ( SELECT LTRIM (RTRIM ((TO_CHAR (b.clinic_date, 'DAY' )))) FROM DUAL)) FROM oa_clinic_schedule b WHERE a.facility_id = b.facility_id AND a.clinic_code = b.clinic_code AND a.practitioner_id = b.practitioner_id AND b.speciality_code = ? AND a.time_table_type != 3 and b.schedule_status is null AND TRUNC (clinic_date) > TRUNC (SYSDATE))  and a.practitioner_id is not null  and a.time_table_type!=3 ORDER BY clinic_short_desc,a.clinic_code,a.practitioner_id, practitioner_short_name, a.day_no ";
			
			System.err.println("qry Practioner List==>"+sql);

	    	pstmt = con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,locale);
			pstmt.setString(6,specialityCode);
	    	rs = pstmt.executeQuery();
	    	JSONObject json		= new JSONObject();
	    	JSONArray jsonArray = new JSONArray();
	    	while(rs!=null && rs.next()){
	    		JSONObject jsonobj 				= new JSONObject();
	    		jsonobj.put("srl_no",rs.getString("srl_no"));
	    		jsonobj.put("max_patients_per_slab",rs.getString("max_patients_per_slab"));
	    		jsonobj.put("time_per_patient",rs.getString("time_per_patient"));
	    		jsonobj.put("time_per_slab",rs.getString("time_per_slab"));
	    		jsonobj.put("clinic_code",rs.getString("clinic_code"));
	    		jsonobj.put("practitioner_id",rs.getString("practitioner_id"));
	    		jsonobj.put("practitioner_short_name",rs.getString("practitioner_short_name"));
	    		jsonobj.put("clinic_short_desc",rs.getString("clinic_short_desc"));
	    		jsonobj.put("start_time",rs.getString("start_time"));
	    		jsonobj.put("end_time",rs.getString("end_time"));
	    		jsonobj.put("day_no",rs.getString("day_no"));
	    		jsonobj.put("max_patients_per_day",rs.getInt("max_patients_per_day"));
	       		jsonobj.put("time_table_type",rs.getString("time_table_type"));
	    		jsonobj.put("care_locn_type_ind",rs.getString("care_locn_type_ind"));
	    		jsonobj.put("resource_class",rs.getString("resource_class"));
	    		jsonArray.put(jsonobj);
				rowCnt++;
	    	}
	    	json.put("PratitionerList",jsonArray);
	    	json.put("PratitionerListCnt",rowCnt);

	
	    	returnStr		= json.toString();
    	}catch(Exception ex){
			System.err.println("Exception in getPratitionerList - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
    	return returnStr;
    }

	public static String getAvailablePratitionerList(Connection con,String specialityCode,String locale,String facilityID){
    	String returnStr 	= "";
        PreparedStatement pstmt=null;
    	ResultSet rs=null;
		int rowCnt	= 0;
		String eff_status	= "N";
    	try{
	    	//String sql = " SELECT a.org_start_time,a.org_end_time,a.org_no_of_slots,a.org_time_table_type,a.srl_no,to_char(b.time_per_patient, 'hh24:mi') time_per_patient, to_char(b.time_per_slab, 'hh24:mi') time_per_slab, b.max_patients_per_slab,a.locn_code, a.locn_type, a.speciality_code, a.resource_id, a.day_no,a.start_time, a.end_time, a.no_of_slots, op_get_desc.op_clinic (a.facility_id,a.locn_code,'"+locale+"','1') clinic_short_desc, a.resource_type, DECODE (a.resource_type,'P', am_get_desc.am_practitioner (a.resource_id, '"+locale+"', '1'),'R', am_get_desc.am_facility_room (a.facility_id,a.resource_id,'"+locale+"','2'),'E', am_get_desc.am_resource (a.facility_id, a.resource_id, '"+locale+"', '2'),'O', am_get_desc.am_resource (a.facility_id, a.resource_id, '"+locale+"', '2') ) practitioner_short_name,a.time_table_type,a.eff_status  FROM OA_PORTAL_SCHEDULE_CONFIG a, oa_clinic_time_table b WHERE a.locn_code = b.clinic_code AND a.resource_id = b.practitioner_id AND a.day_no = b.day_no and a.SPECIALITY_CODE = '"+specialityCode+"' and b.time_table_type!=3 AND  (a.locn_code, a.day_no) IN ( SELECT a.locn_code, (SELECT day_no FROM sm_day_of_week WHERE LTRIM (RTRIM (day_of_week)) IN ( SELECT LTRIM (RTRIM ((TO_CHAR (c.clinic_date, 'DAY' )))) FROM DUAL)) FROM oa_clinic_schedule c WHERE a.facility_id = c.facility_id AND a.locn_code = c.clinic_code AND a.resource_id = c.practitioner_id AND a.speciality_code = '"+specialityCode+"' AND a.time_table_type != 3 and c.schedule_status is null AND TRUNC (clinic_date) > TRUNC (SYSDATE))order by clinic_short_desc, a.locn_code, a.resource_id, practitioner_short_name, a.day_no";
	    	String sql = " SELECT a.org_start_time,a.org_end_time,a.org_no_of_slots,a.org_time_table_type,a.srl_no,to_char(b.time_per_patient, 'hh24:mi') time_per_patient, to_char(b.time_per_slab, 'hh24:mi') time_per_slab, b.max_patients_per_slab,a.locn_code, a.locn_type, a.speciality_code, a.resource_id, a.day_no,a.start_time, a.end_time, a.no_of_slots, op_get_desc.op_clinic (a.facility_id,a.locn_code,?,'1') clinic_short_desc, a.resource_type, DECODE (a.resource_type,'P', am_get_desc.am_practitioner (a.resource_id, ?, '1'),'R', am_get_desc.am_facility_room (a.facility_id,a.resource_id,?,'2'),'E', am_get_desc.am_resource (a.facility_id, a.resource_id,?, '2'),'O', am_get_desc.am_resource (a.facility_id, a.resource_id,?, '2') ) practitioner_short_name,a.time_table_type,a.eff_status  FROM OA_PORTAL_SCHEDULE_CONFIG a, oa_clinic_time_table b WHERE a.locn_code = b.clinic_code AND a.resource_id = b.practitioner_id AND a.day_no = b.day_no and a.SPECIALITY_CODE = ? and b.time_table_type!=3 AND  (a.locn_code, a.day_no) IN ( SELECT a.locn_code, (SELECT day_no FROM sm_day_of_week WHERE LTRIM (RTRIM (day_of_week)) IN ( SELECT LTRIM (RTRIM ((TO_CHAR (c.clinic_date, 'DAY' )))) FROM DUAL)) FROM oa_clinic_schedule c WHERE a.facility_id = c.facility_id AND a.locn_code = c.clinic_code AND a.resource_id = c.practitioner_id AND a.speciality_code = ? AND a.time_table_type != 3 and c.schedule_status is null AND TRUNC (clinic_date) > TRUNC (SYSDATE))order by clinic_short_desc, a.locn_code, a.resource_id, practitioner_short_name, a.day_no";
		
	    	pstmt = con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,locale);
			pstmt.setString(6,specialityCode);
			pstmt.setString(7,specialityCode);
			System.err.println("qry Stored Practioner List==>"+sql);
	    	rs = pstmt.executeQuery();
	    	JSONObject json		= new JSONObject();
	    	JSONArray jsonArray = new JSONArray();
	    	while(rs!=null && rs.next()){
	    		JSONObject jsonobj 				= new JSONObject();
	    		jsonobj.put("max_patients_per_slab",rs.getString("max_patients_per_slab"));
	    		jsonobj.put("time_per_patient",rs.getString("time_per_patient"));
	    		jsonobj.put("time_per_slab",rs.getString("time_per_slab"));
	    		jsonobj.put("locn_type",rs.getString("locn_type"));
	    		jsonobj.put("locn_code",rs.getString("locn_code"));
	    		jsonobj.put("resource_id",rs.getString("resource_id"));
	    		jsonobj.put("start_time",rs.getString("start_time"));
	    		jsonobj.put("end_time",rs.getString("end_time"));
	    		jsonobj.put("day_no",rs.getString("day_no"));
	    		jsonobj.put("no_of_slots",rs.getString("no_of_slots"));
				jsonobj.put("practitioner_short_name",rs.getString("practitioner_short_name"));
	    		jsonobj.put("clinic_short_desc",rs.getString("clinic_short_desc"));
				jsonobj.put("resource_type",rs.getString("resource_type"));
				jsonobj.put("time_table_type",rs.getString("time_table_type"));
				jsonobj.put("srl_no",rs.getString("srl_no"));
				jsonobj.put("org_start_time",rs.getString("org_start_time"));
				jsonobj.put("org_end_time",rs.getString("org_end_time"));
				jsonobj.put("org_no_of_slots",rs.getString("org_no_of_slots"));
				jsonobj.put("org_time_table_type",rs.getString("org_time_table_type"));
	    		jsonArray.put(jsonobj);
				eff_status	= rs.getString("eff_status");
				rowCnt++;
	    	}
	    	json.put("AvailablePratitionerList",jsonArray);
	    	json.put("AvailablePratitionerListCnt",rowCnt);
	    	json.put("eff_status",eff_status);
	    	
	    	returnStr		= json.toString();
    	}catch(Exception ex){
			System.err.println("Exception in getAvailablePratitionerList - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
    	return returnStr;
    }





	public static String getBreakTiming(Connection con,String clinicCodes,String locale,String facilityID){
    	String returnStr 	= "";
        PreparedStatement pstmt=null;
    	ResultSet rs=null;
		int rowCnt	= 0;
    	try{
	    	String sql = " SELECT clinic_code,practitioner_id,day_no,to_char(break_start_time,'hh24:mi') b_start_time, to_char(break_end_time,'hh24:mi') b_end_time, (break_end_time - break_start_time) * 24 * 60 * 60 diff_in_seconds FROM oa_clinic_break WHERE clinic_code in("+clinicCodes+") and practitioner_id is not null and facility_id = '"+facilityID+"' order by clinic_code, practitioner_id, to_number(day_no), break_start_time ";
		
	    	pstmt = con.prepareStatement(sql);
			System.err.println("qry getBreakTiming==>"+sql);
	    	rs = pstmt.executeQuery();
	    	JSONObject json		= new JSONObject();
	    	JSONArray jsonArray = new JSONArray();
	    	while(rs!=null && rs.next()){
	    		JSONObject jsonobj 				= new JSONObject();
	    		jsonobj.put("clinic_code",rs.getString("clinic_code"));
	    		jsonobj.put("practitioner_id",rs.getString("practitioner_id"));
	    		jsonobj.put("day_no",rs.getString("day_no"));
	    		jsonobj.put("b_start_time",rs.getString("b_start_time"));
	    		jsonobj.put("b_end_time",rs.getString("b_end_time"));
	    		jsonobj.put("diff_in_seconds",rs.getString("diff_in_seconds"));
	    		jsonArray.put(jsonobj);
				rowCnt++;
	    	}
	    	json.put("BreakTimeList",jsonArray);
	    	json.put("BreakTimeCount",rowCnt);
	    	
	    	returnStr		= json.toString();
    	}catch(Exception ex){
			System.err.println("Exception in getBreakTiming - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
    	return returnStr;
    }

	public static String getAltIdLegends(Connection con,String locale){
    	String returnStr 	= "";
        PreparedStatement pstmt=null;
    	ResultSet rs=null;
		String alt_id1_type_desc = "";
		String alt_id2_type_desc = "";
		String alt_id3_type_desc = "";
		String alt_id4_type_desc = "";
		String accept_national_id_no_yn = "";
		String nat_id_prompt = "";
    	try{
	    	String sql = " SELECT mp_get_desc.mp_alternate_id_type (alt_id1_type,'"+locale+"','1') alt_id1_type_desc,mp_get_desc.mp_alternate_id_type (alt_id2_type,'"+locale+"','1') alt_id2_type_desc,mp_get_desc.mp_alternate_id_type (alt_id3_type,'"+locale+"','1') alt_id3_type_desc,mp_get_desc.mp_alternate_id_type (alt_id4_type,'"+locale+"','1') alt_id4_type_desc,accept_national_id_no_yn,nat_id_prompt FROM mp_param where module_id='MP' ";
	    	pstmt = con.prepareStatement(sql);
			System.err.println("qry getAltIdLegends==>"+sql);
	    	rs = pstmt.executeQuery();
	    	JSONObject json		= new JSONObject();
	    	if(rs!=null && rs.next()){
				alt_id1_type_desc	= (rs.getString("alt_id1_type_desc") == null)?"":(rs.getString("alt_id1_type_desc"));
				alt_id2_type_desc	= (rs.getString("alt_id2_type_desc") == null)?"":(rs.getString("alt_id2_type_desc"));
				alt_id3_type_desc	= (rs.getString("alt_id3_type_desc") == null)?"":(rs.getString("alt_id3_type_desc"));
				alt_id4_type_desc	= (rs.getString("alt_id4_type_desc") == null)?"":(rs.getString("alt_id4_type_desc"));
				accept_national_id_no_yn	= (rs.getString("accept_national_id_no_yn") == null)?"N":(rs.getString("accept_national_id_no_yn"));
				nat_id_prompt	= (rs.getString("nat_id_prompt") == null)?"":(rs.getString("nat_id_prompt"));
	    	}

			json.put("alt_id1_type_desc",alt_id1_type_desc);
			json.put("alt_id2_type_desc",alt_id2_type_desc);
			json.put("alt_id3_type_desc",alt_id3_type_desc);
			json.put("alt_id4_type_desc",alt_id4_type_desc);
			json.put("accept_national_id_no_yn",accept_national_id_no_yn);
			json.put("nat_id_prompt",nat_id_prompt);

	    	returnStr		= json.toString();
    	}catch(Exception ex){
			System.err.println("Exception in getAltIdLegends - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
    	return returnStr;
    }


	public static String getBookingCtrlsData(Connection con){
    	String returnStr 	= "";
        PreparedStatement pstmt=null;
    	ResultSet rs=null;
		String max_appt_patient_per_day			 = "";
		String adv_max_appt_limits				= "";
		String adv_min_appt_limits				= "";
		String pat_id_enabled_yn				= "";
		String nat_id_enabled_yn				= "";
		String alt_id1_enabled_yn				= "";
		String alt_id2_enabled_yn				= "";
		String alt_id3_enabled_yn				= "";
		String alt_id4_enabled_yn				= "";
		String isRowAvailable					= "N";

		String booking_reason					= "";
		String rescheduling_reason				= "";
		String cancelling_reason				= "";
		String booking_reason_change_yn			= "";
		String rescheduling_reason_change_yn	= "";
		String cancelling_reason_change_yn		= "";
		String max_appt_per_patient				= "";

    	try{
	    	String sql = " Select booking_reason,rescheduling_reason,cancelling_reason,booking_reason_change_yn,rescheduling_reason_change_yn,cancelling_reason_change_yn,max_appt_patient_per_day,adv_max_appt_limits,adv_min_appt_limits,pat_id_enabled_yn,nat_id_enabled_yn,alt_id1_enabled_yn,alt_id2_enabled_yn,alt_id3_enabled_yn,alt_id4_enabled_yn,max_appt_per_patient from oa_portal_booking_ctrls ";
	    	pstmt = con.prepareStatement(sql);
			System.err.println("qry getBookingCtrlsData==>"+sql);
	    	rs = pstmt.executeQuery();
	    	JSONObject json		= new JSONObject();
	    	if(rs!=null && rs.next()){
				max_appt_patient_per_day		= rs.getString("max_appt_patient_per_day");
				adv_max_appt_limits				= rs.getString("adv_max_appt_limits");
				adv_min_appt_limits				= rs.getString("adv_min_appt_limits");
				pat_id_enabled_yn				= rs.getString("pat_id_enabled_yn");
				nat_id_enabled_yn				= rs.getString("nat_id_enabled_yn");
				alt_id1_enabled_yn				= rs.getString("alt_id1_enabled_yn");
				alt_id2_enabled_yn				= rs.getString("alt_id2_enabled_yn");
				alt_id3_enabled_yn				= rs.getString("alt_id3_enabled_yn");
				alt_id4_enabled_yn				= rs.getString("alt_id4_enabled_yn");

				booking_reason					= rs.getString("booking_reason");
				rescheduling_reason				= rs.getString("rescheduling_reason");
				cancelling_reason				= rs.getString("cancelling_reason");
				booking_reason_change_yn		= rs.getString("booking_reason_change_yn");
				rescheduling_reason_change_yn	= rs.getString("rescheduling_reason_change_yn");
				cancelling_reason_change_yn		= rs.getString("cancelling_reason_change_yn");
				max_appt_per_patient		= rs.getString("max_appt_per_patient");




				isRowAvailable				= "Y";
				
	    	}

			json.put("max_appt_patient_per_day",max_appt_patient_per_day);
			json.put("adv_max_appt_limits",adv_max_appt_limits);
			json.put("adv_min_appt_limits",adv_min_appt_limits);
			json.put("pat_id_enabled_yn",pat_id_enabled_yn);
			json.put("nat_id_enabled_yn",nat_id_enabled_yn);
			json.put("alt_id1_enabled_yn",alt_id1_enabled_yn);
			json.put("alt_id2_enabled_yn",alt_id2_enabled_yn);
			json.put("alt_id3_enabled_yn",alt_id3_enabled_yn);
			json.put("alt_id4_enabled_yn",alt_id4_enabled_yn);

			json.put("booking_reason",booking_reason);
			json.put("rescheduling_reason",rescheduling_reason);
			json.put("cancelling_reason",cancelling_reason);
			json.put("booking_reason_change_yn",booking_reason_change_yn);
			json.put("rescheduling_reason_change_yn",rescheduling_reason_change_yn);
			json.put("cancelling_reason_change_yn",cancelling_reason_change_yn);
			json.put("max_appt_per_patient",max_appt_per_patient);




			json.put("isRowAvailable",isRowAvailable);

	    	returnStr		= json.toString();
    	}catch(Exception ex){
			System.err.println("Exception in getAltIdLegends - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
    	return returnStr;
    }

	public static String getReason(Connection con,String locale,String reasonType){
    	String returnStr 			= "";
        PreparedStatement pstmt		= null;
    	ResultSet rs				= null;
		String whereClause			= "";

    	try{
			if(reasonType.equals("booking")){
				whereClause	= " and nvl(BOOK_APPOINTMENT_YN,'N') = 'Y'";
			}else  if(reasonType.equals("cancel")){
				whereClause	= " and nvl(CANCEL_APPOINTMENT_YN,'N') = 'Y'";
			}else if(reasonType.equals("reschedule")){
				whereClause	= " and nvl(TRANSFER_APPOINTMENT_YN,'N') = 'Y'";
			}

					
	    	String sql = "select contact_reason description ,contact_reason_code code from am_contact_reason_lang_vw where eff_status='E' 	and language_id='"+locale+"' "+whereClause+"";
	    	pstmt = con.prepareStatement(sql);
			System.err.println("qry getReason==>"+sql);

	    	rs = pstmt.executeQuery();
	    	JSONObject json		= new JSONObject();
	    	JSONArray jsonArray = new JSONArray();
	    	while(rs!=null && rs.next()){
	    		JSONObject jsonobj 				= new JSONObject();
	    		jsonobj.put("code",rs.getString("code"));
	    		jsonobj.put("description",rs.getString("description"));
	    		jsonArray.put(jsonobj);
	    	}
	    	json.put("results",jsonArray);
	    	
	    	returnStr		= json.toString();
    	}catch(Exception ex){
			System.err.println("Exception in getReason - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
    	return returnStr;
    }





	
}//end of class
