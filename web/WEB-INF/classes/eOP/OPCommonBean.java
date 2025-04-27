package eOP;

import java.sql.*;
import java.io.*;
import java.util.*;
import org.json.simple.*;


public class OPCommonBean implements Serializable{
	
public static JSONArray getPatientApptDtls(Connection con, String locale, String facility_id, String oper_stn_id,String patient_id ) throws Exception {
		Statement stmt 	= con.createStatement();
		ResultSet rs    = null;
		StringBuffer Sql	=new StringBuffer();

		
		Sql.append("SELECT   TO_CHAR (a.appt_time, 'hh24:mi') appt_time, a.appt_status appt_status, ");
		//Sql.append("DECODE ('en','en', a.patient_name,NVL (a.patient_name_loc_lang, a.patient_name)) patient_name, ");
		Sql.append("a.patient_name patient_name,nvl(a.patient_name_loc_lang,a.patient_name) patient_name_ar,  ");
		Sql.append(" NVL (a.patient_id, '') patient_id, op_get_desc.op_clinic (a.facility_id, a.clinic_code,'en',1) clinic_desc, "); 
		Sql.append(" op_get_desc.op_clinic (a.facility_id, a.clinic_code,'ar',1) clinic_desc_ar, ");
		Sql.append("DECODE(a.resource_class,'P', am_get_desc.am_practitioner (a.practitioner_id, '"+locale+"', 1),'R', a.practitioner_id,am_get_desc.am_resource (a.facility_id,a.practitioner_id,'"+locale+"','2')) practitioner_name, ");
		Sql.append("a.clinic_code clinic_code, a.practitioner_id pract_id, a.appt_ref_no appt_ref_no, a.appt_type_code appt_type_code, NVL (a.referral_id, '') referral_id, ");
        Sql.append("TO_CHAR (a.appt_date, 'dd/mm/yyyy') appt_date,TO_CHAR (a.appt_slab_from_time, 'hh24:mi') from_time, TO_CHAR (a.appt_slab_to_time, 'hh24:mi') to_time, " ); Sql.append("mp_get_desc.mp_country (country_code, '"+locale+"', 3) nationality, national_id_no, a.care_locn_type_ind clinic_type, a.resource_class resource_class, "); Sql.append("a.resource_class resource_desc, a.service_code service_code, a.recur_wo_sec_res recur_wo_sec_res, a.patient_cat_code patient_cat_code, ");
        Sql.append("am_get_desc.am_contact_reason (contact_reason_code, '"+locale+"', 1) reason, contact_reason_code, multi_speciality_yn, a.speciality_code speciality_code, ");
        Sql.append(" a.ext_appt_ref_no  ext_appt_ref_no,a.ordering_facility_id ordering_facility_id, a.order_id order_id, a.order_line_num order_line_num, ");
		Sql.append(" a.order_type_code  order_type_code, a.order_catalog_code order_catlog_code, e.short_desc order_catalog_desc, ");
		Sql.append(" (select distinct VISIT_TYPE_IND from op_visit_type where VISIT_TYPE_CODE = a.appt_type_code) visit_type_ind ");
		Sql.append(" FROM oa_appt a, or_order_catalog e ");
		Sql.append(" WHERE a.facility_id = '"+facility_id+"' AND a.appt_date = TRUNC (SYSDATE) AND rd_appt_yn = 'N' AND a.appt_status = '1' AND a.order_catalog_code = e.order_catalog_code(+) ");
		Sql.append("  and a.clinic_code in(SELECT LOCN_CODE FROM am_locn_for_oper_stn b1 WHERE B1.facility_id = '"+facility_id+"' AND b1.oper_stn_id = '"+oper_stn_id+"' AND b1.eff_status = 'E') "); 
		Sql.append(" AND a.care_locn_type_ind IN ('C', 'E') and patient_id = '"+patient_id+"' ORDER BY 1 ");
		
			
		JSONArray patientApptList	= new JSONArray();
		
		try
		{

		stmt = con.createStatement();
		rs= stmt.executeQuery(Sql.toString());
		if(rs!= null)
		{
			while(rs.next()) {

				String visit_type_ind = checkForNull(rs.getString("visit_type_ind"));
				String appt_time = checkForNull(rs.getString("appt_time"));
				String appt_status = checkForNull(rs.getString("appt_status"));
				String patient_name = checkForNull(rs.getString("patient_name"));
				String patient_name_ar = checkForNull(rs.getString("patient_name_ar"));
				String clinic_desc = checkForNull(rs.getString("clinic_desc"));
				String clinic_desc_ar = checkForNull(rs.getString("clinic_desc_ar"));
				String practitioner_name = checkForNull(rs.getString("practitioner_name"));
				String clinic_code = checkForNull(rs.getString("clinic_code"));
				String pract_id = checkForNull(rs.getString("pract_id"));
				String appt_ref_no = checkForNull(rs.getString("appt_ref_no"));
				String appt_type_code = checkForNull(rs.getString("appt_type_code"));
				String referral_id = checkForNull(rs.getString("referral_id"));
				String appt_date = checkForNull(rs.getString("appt_date"));
				String from_time = checkForNull(rs.getString("from_time"));
				String to_time = checkForNull(rs.getString("to_time"));
				String nationality = checkForNull(rs.getString("nationality"));
				String national_id_no = checkForNull(rs.getString("national_id_no"));
				String clinic_type = checkForNull(rs.getString("clinic_type"));
				String resource_class = checkForNull(rs.getString("resource_class"));
				String resource_desc = checkForNull(rs.getString("resource_desc"));
				String service_code = checkForNull(rs.getString("service_code"));
				String recur_wo_sec_res = checkForNull(rs.getString("recur_wo_sec_res"));
				String patient_cat_code = checkForNull(rs.getString("patient_cat_code"));
				String reason = checkForNull(rs.getString("reason"));
				String contact_reason_code = checkForNull(rs.getString("contact_reason_code"));
				String multi_speciality_yn = checkForNull(rs.getString("multi_speciality_yn"));
				String speciality_code = checkForNull(rs.getString("speciality_code"));
				String ext_appt_ref_no = checkForNull(rs.getString("ext_appt_ref_no"));
				String ordering_facility_id = checkForNull(rs.getString("ordering_facility_id"));
				String order_id = checkForNull(rs.getString("order_id"));
				String order_line_num = checkForNull(rs.getString("order_line_num"));
				String order_type_code = checkForNull(rs.getString("order_type_code"));
				String order_catlog_code = checkForNull(rs.getString("order_catlog_code"));
				String order_catalog_desc = checkForNull(rs.getString("order_catalog_desc"));

				JSONObject jsonObj			= new JSONObject();
				
				
				jsonObj.put("appt_time",appt_time);
				jsonObj.put("appt_status",appt_status);
				jsonObj.put("patient_name",patient_name);
				jsonObj.put("patient_name_ar",patient_name_ar);
				jsonObj.put("clinic_desc",clinic_desc);
				jsonObj.put("clinic_desc_ar",clinic_desc_ar);
				jsonObj.put("practitioner_name",practitioner_name);
				jsonObj.put("clinic_code",clinic_code);
				jsonObj.put("pract_id",pract_id);
				jsonObj.put("appt_ref_no",appt_ref_no);
				jsonObj.put("appt_type_code",appt_type_code);
				jsonObj.put("referral_id",referral_id);
				jsonObj.put("appt_date",appt_date);
				jsonObj.put("from_time",from_time);
				jsonObj.put("to_time",to_time);
				jsonObj.put("nationality",nationality);
				jsonObj.put("national_id_no",national_id_no);
				jsonObj.put("clinic_type",clinic_type);
				jsonObj.put("resource_class",resource_class);
				jsonObj.put("resource_desc",resource_desc);
				jsonObj.put("service_code",service_code);
				jsonObj.put("recur_wo_sec_res",recur_wo_sec_res);
				jsonObj.put("patient_cat_code",patient_cat_code);
				jsonObj.put("reason",reason);
				jsonObj.put("contact_reason_code",contact_reason_code);
				jsonObj.put("multi_speciality_yn",multi_speciality_yn);
				jsonObj.put("speciality_code",speciality_code);
				jsonObj.put("ext_appt_ref_no",ext_appt_ref_no);
				jsonObj.put("order_id",order_id);
				jsonObj.put("order_line_num",order_line_num);
				jsonObj.put("order_type_code",order_type_code);
				jsonObj.put("order_catlog_code",order_catlog_code);
				jsonObj.put("order_catalog_desc",order_catalog_desc);
				jsonObj.put("ordering_facility_id",ordering_facility_id);
				jsonObj.put("visit_type_ind",visit_type_ind);



				patientApptList.add(jsonObj);
			}
			
			
		}
		}catch(Exception e){
				e.printStackTrace();
			}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getPatientApptDtls - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
			
		return patientApptList;	
}

public static JSONObject getOPParamDtls(Connection con, String facility_id) throws Exception{
			
			PreparedStatement pstmt	= null;
			ResultSet rs 			= null;
			JSONObject jsonObj		= new JSONObject();
			String sql				= "";

			try{

				 sql = "select action_on_pract_schedule,ASSIGN_QUEUE_NUM_BY,use_template_in_vis_regn_yn, to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sys,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_new, OVERRIDE_PRACT_FOR_APPT_YN, OVERRIDE_VTYPE_ON_EPSD_YN,VISIT_BACKDATE_DAYS, to_char((sysdate - NVL(VISIT_BACKDATE_DAYS,0)),'dd/mm/yyyy hh24:mi:ss') sys1,VISIT_TYPE_DERV_RULE from op_param where operating_facility_id=?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,facility_id);
				rs = pstmt.executeQuery();

				if(rs!=null && rs.next()){
						
					jsonObj.put("action_on_pract_schedule",checkForNull(rs.getString("action_on_pract_schedule")));
					jsonObj.put("assign_q_num_by", checkForNull(rs.getString("ASSIGN_QUEUE_NUM_BY")));
					jsonObj.put("vst_regn_date",checkForNull(rs.getString("sys")));
					jsonObj.put("vst_regn_date_new",checkForNull(rs.getString("sys_new"))); 
					jsonObj.put("override_pract_for_appt_yn",checkForNull(rs.getString("OVERRIDE_PRACT_FOR_APPT_YN")));		
					jsonObj.put("override_vtype_on_epsd_yn",checkForNull(rs.getString("OVERRIDE_VTYPE_ON_EPSD_YN"), "N"));
					jsonObj.put("visit_backdate_days",checkForNull(rs.getString("VISIT_BACKDATE_DAYS")));
					jsonObj.put("allowed_date",checkForNull(rs.getString("sys1")));
					jsonObj.put("vis_det_temp_yn",checkForNull(rs.getString( "use_template_in_vis_regn_yn" ),"N"));
					jsonObj.put("visit_type_derv_rule",checkForNull(rs.getString( "VISIT_TYPE_DERV_RULE" ),"S"));
					
					
				}
				
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
				}catch(Exception ex){
					System.err.println("Exception in getOPParamDtls - "+ex.getMessage());
					ex.printStackTrace();
				}
			}

			return jsonObj;
}


public static JSONObject getFollowupVisitDtls(Connection con, String facility_id,String patient_id,String servicecode,String override_vtype_on_epsd_yn,String p_visit_type_ind,String locncode) throws Exception{
			
			PreparedStatement pstmt			= null;
			PreparedStatement pstmt2			= null;
			ResultSet rs 					= null;
			PreparedStatement pstmt3			= null;
			ResultSet rset3 					= null;
			ResultSet rset2 					= null;
			JSONObject jsonObj				= new JSONObject();
			String sql						= "";
			String episode_id				= "";
			String last_visit_fu_reqd_yn	= "";
			String last_visit_date			= "";
			int last_visit_num ;
			int op_episode_visit_num = 0;

			String old_episode_no			= "";
			String visit_date			= "";
			String chkFlag	= "Y";

			String new_op_episode_yn	= "";
			
			String op_episode_id	= "";
			String dur_for_fu_vsts_in_days	= "";
			int no_of_fu_visits_allowed	= 0;
			String episode_close_days_fu	= "";
			String episode_close_days_wo_fu	= "";
	
			try{

				 sql = "SELECT episode_id, last_visit_fu_reqd_yn,TO_CHAR (last_visit_date, 'yyyy-mm-dd') last_visit_date,NVL (last_visit_num, 0) + 1 last_visit_num FROM op_episode_for_service WHERE last_visit_date =(SELECT MAX (last_visit_date) FROM op_episode_for_service WHERE operating_facility_id ='"+facility_id+"' AND episode_status = '01' AND patient_id ='"+patient_id+"' and service_code='"+servicecode+"') and service_code='"+servicecode+"' AND operating_facility_id ='"+facility_id+"' AND episode_status = '01' AND patient_id ='"+patient_id+"' ";

				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				   
				if(rs!=null && rs.next()){
					if (rs.getString("episode_id") != null)
						episode_id = rs.getString( "episode_id" );
					if (rs.getString("last_visit_fu_reqd_yn") != null)
						last_visit_fu_reqd_yn = rs.getString( "last_visit_fu_reqd_yn" );
					if (rs.getString("last_visit_date") != null)
						last_visit_date = rs.getString( "last_visit_date" );

					  last_visit_num = rs.getInt( "last_visit_num" );
					 
					 if(override_vtype_on_epsd_yn.equals("Y")) {

						 sql = "select  nvl(sign(months_between((trunc(to_date('"+last_visit_date+"','rrrr-mm-dd')) + decode('"+last_visit_fu_reqd_yn+"','Y',nvl(episode_close_days_fu,0),nvl(episode_close_days_wo_fu,0))),trunc(sysdate))),0) visit_date, nvl(episode_close_days_fu,0), nvl(episode_close_days_wo_fu,0) from op_param_for_facility_service where service_code ='"+servicecode+"' and operating_facility_id='"+facility_id+"'" ;						 
				
						 pstmt2   = con.prepareStatement(sql);
						 rset2 = pstmt2.executeQuery();
						 if (!rset2.next()) {

							 sql = "select  nvl(sign(months_between((trunc(to_date('"+last_visit_date+"','rrrr-mm-dd')) + decode('"+last_visit_fu_reqd_yn+"','Y',nvl(episode_close_days_fu,0),nvl(episode_close_days_wo_fu,0))),trunc(sysdate))),0) visit_date, nvl(episode_close_days_fu,0), nvl(episode_close_days_wo_fu,0) from op_param where operating_facility_id='"+facility_id+"'" ;							
							
							pstmt3   = con.prepareStatement( sql );
							rset3 = pstmt3.executeQuery();     
							if (!rset3.next()){
								
								chkFlag = "N";
							} else{
								   
								episode_close_days_fu = rset3.getString(2);
								episode_close_days_wo_fu = rset3.getString(3);
								visit_date = rset3.getString("visit_date");
							}           
							if(rset3 != null) rset3.close();
							if(pstmt3 != null) pstmt3.close();

						 }else{
							episode_close_days_fu = rset2.getString(2);
							episode_close_days_wo_fu =rset2.getString(3);
							visit_date = rset2.getString("visit_date");
						 }
						if(rset2 != null) rset2.close();
						if(pstmt2 != null) pstmt2.close();
					 
					 } else if(override_vtype_on_epsd_yn.equals("N")) {    
					   
						sql = "select nvl(sign(months_between((trunc(to_date('"+last_visit_date+"','rrrr-mm-dd'))+ nvl(dur_for_follow_up_vsts_in_days,0)),trunc(sysdate))),0) visit_date, nvl(dur_for_follow_up_vsts_in_days,0) dur_for_follow_up_vsts_in_days, no_of_follow_up_visits_allowed from op_visit_type_control where service_code ='"+servicecode+"' and facility_id ='"+facility_id+"' and clinic_code = '"+locncode+"'" ;	
						 pstmt2   = con.prepareStatement(sql);
						 rset2 = pstmt2.executeQuery();
						 if (!rset2.next()) {
							 
							sql = "select nvl(sign(months_between((trunc(to_date('"+last_visit_date+"','rrrr-mm-dd'))+ nvl(dur_for_follow_up_vsts_in_days,0)),trunc(sysdate))),0) visit_date, nvl(dur_for_follow_up_vsts_in_days,0) dur_for_follow_up_vsts_in_days, no_of_follow_up_visits_allowed from op_param where operating_facility_id='"+facility_id+"'" ;								
							pstmt3 = con.prepareStatement( sql );
							rset3  = pstmt3.executeQuery();     
							if (!rset3.next()) {
								
								chkFlag = "N";
							 } else {
								   
									dur_for_fu_vsts_in_days = rset3.getString("dur_for_follow_up_vsts_in_days");
									no_of_fu_visits_allowed = rset3.getInt("no_of_follow_up_visits_allowed");
									visit_date = rset3.getString("visit_date");
							 }           
							 if(rset3 != null) rset3.close();
							 if(pstmt3 != null) pstmt3.close();

						  }else {
									
									dur_for_fu_vsts_in_days = rset2.getString("dur_for_follow_up_vsts_in_days");
									no_of_fu_visits_allowed = rset2.getInt("no_of_follow_up_visits_allowed");
									visit_date = rset2.getString("visit_date");
							  }
						if(rset2 != null) rset2.close();
						if(pstmt2 != null) pstmt2.close();

				   }

				   jsonObj.put("episode_id",episode_id);
				   jsonObj.put("last_visit_fu_reqd_yn",last_visit_fu_reqd_yn);
				   jsonObj.put("last_visit_date",last_visit_date);
				   jsonObj.put("last_visit_num",String.valueOf(last_visit_num));

				  jsonObj.put("visit_date",visit_date);

				    if(chkFlag.equals("Y")) {
												   
					if(override_vtype_on_epsd_yn.equals("Y")) { 
						
							
						 if (visit_date.equals("-1")|| visit_date.equals("0")) {

							 new_op_episode_yn	= "Y";
							 op_episode_visit_num	= 0;
							 op_episode_id	= "";
				 
						 } else {       
							  
							 if(p_visit_type_ind.equals("F") || episode_id.equals("")) {
									 new_op_episode_yn	= "Y";
									 op_episode_visit_num	= 0;
									 op_episode_id	= "";
								
								} else {

									new_op_episode_yn	= "N";
									op_episode_visit_num	= last_visit_num;
									op_episode_id	= episode_id;
									old_episode_no	= episode_id;
									
								 }
												 
						 }
					}
					else {   
							

						 if (visit_date.equals("-1")|| visit_date.equals("0")|| last_visit_num > (no_of_fu_visits_allowed+1)) {	
									 new_op_episode_yn	= "Y";
									 op_episode_visit_num	= 0;
									 op_episode_id	= "";
		 
						 }
						 else {       
							  
								if(p_visit_type_ind.equals("F") || episode_id.equals("")) {	
									new_op_episode_yn	= "Y";
									op_episode_visit_num	= 0;
									op_episode_id	= "";
		
								}
								else {

									new_op_episode_yn	= "N";
									op_episode_visit_num	= last_visit_num;
									op_episode_id	= episode_id;
									old_episode_no	= episode_id;
									
								}
					
							   
						 }
					}

				 }



				}else {    
					if(override_vtype_on_epsd_yn.equals("Y"))
					{
						pstmt2   = con.prepareStatement("select episode_close_days_fu,episode_close_days_wo_fu from op_param where operating_facility_id = '"+facility_id+"'");

						rset2 = pstmt2.executeQuery();

						if (rset2!= null)
						{
							if(rset2.next())
							{
							  episode_close_days_fu   = rset2.getString("episode_close_days_fu");
							  episode_close_days_wo_fu= rset2.getString("episode_close_days_wo_fu");						  
							}
						}

						if (rset2 != null)   rset2.close();
						if (pstmt2 != null) pstmt2.close();

					}
					new_op_episode_yn	= "Y";
					op_episode_visit_num	= 0;
					op_episode_id	= "";

		}

		
					jsonObj.put("episode_close_days_fu",episode_close_days_fu);
					jsonObj.put("episode_close_days_wo_fu",episode_close_days_wo_fu);
					jsonObj.put("dur_for_fu_vsts_in_days",dur_for_fu_vsts_in_days);
					jsonObj.put("no_of_fu_visits_allowed",String.valueOf(no_of_fu_visits_allowed));
					jsonObj.put("new_op_episode_yn",new_op_episode_yn);
					jsonObj.put("op_episode_visit_num",String.valueOf(op_episode_visit_num));
					jsonObj.put("op_episode_id",op_episode_id);
					jsonObj.put("old_episode_no",op_episode_id);


		  if(rs != null) rs.close();
		  if(pstmt != null)  pstmt.close();



				
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
				}catch(Exception ex){
					System.err.println("Exception in getFollowupVisitDtls - "+ex.getMessage());
					ex.printStackTrace();
				}
			}

			return jsonObj;
}

/*Added by Ashwini on 01-Jul-2021 for AAKH-CRF-0125.1*/
public static JSONArray getListVisitsNotAutoClosed(Connection con, String bl_install_yn, String bl_interfaced_yn, String facility_id, String locale) throws Exception{
	PreparedStatement pstmt	= null;
	ResultSet rs 			= null;
	JSONArray arrJSON		= new JSONArray();
	StringBuffer sqlQuery	= new StringBuffer();

	try{
		sqlQuery.append(" SELECT encounter_id, TO_CHAR (visit_adm_date_time, 'dd/mm/yyyy HH24:MI') visit_adm_date_time, visit_adm_date_time AS visit_adm_date_time_order_by, (CASE WHEN INSTR (get_patient_line (patient_id, '"+locale+"'), '#') > 0 THEN SUBSTR (get_patient_line (patient_id, '"+locale+"'), 1, INSTR (get_patient_line (patient_id, '"+locale+"'), '#') - 1 ) END ) patient_details, national_id_no, mr_mds_recorded_yn (facility_id, encounter_id, patient_class, NULL, 'OC', NULL ) mr_mds_remarks FROM pr_encounter_vw a WHERE facility_id = '"+facility_id+"' AND visit_status < '07' AND patient_class = 'OP' "); 
		
		if( bl_install_yn.equals("Y") && bl_interfaced_yn.equals("Y") ) {
		sqlQuery.append(" AND blopin.visit_auto_close_yn (facility_id, assign_care_locn_code, visit_adm_type, attend_practitioner_id, encounter_id ) = 'Y' ");
		}
		
		sqlQuery.append(" AND TRUNC (visit_adm_date_time) < TRUNC ((SYSDATE - (SELECT visit_compl_days FROM op_param WHERE operating_facility_id = a.facility_id))) ORDER BY visit_adm_date_time_order_by DESC ");
		
		pstmt = con.prepareStatement(sqlQuery.toString());
		rs = pstmt.executeQuery();

		while(rs!=null && rs.next()){
			
			JSONObject jsonObj	= new JSONObject();

			String encounter_id = checkForNull(rs.getString("encounter_id"));
			String visit_adm_date_time = checkForNull(rs.getString("visit_adm_date_time"));
			String patient_details = checkForNull(rs.getString("patient_details"));
			String national_id_no = checkForNull(rs.getString("national_id_no"));
			String mr_mds_remarks = checkForNull(rs.getString("mr_mds_remarks"));
			
			jsonObj.put("encounter_id",encounter_id);
			jsonObj.put("visit_adm_date_time",visit_adm_date_time);
			jsonObj.put("patient_details",patient_details);
			jsonObj.put("national_id_no",national_id_no);
			jsonObj.put("mr_mds_remarks",mr_mds_remarks);

			arrJSON.add(jsonObj);
		}
		
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		try{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		}catch(Exception ex){
			System.err.println("Exception in getListVisitsNotAutoClosed - "+ex.getMessage());
			ex.printStackTrace();
		}
	}
	return arrJSON;
}

/*Added by Arthi on 30-May-2022 for MOHE-CRF-0134*/
public static JSONArray getFacilityValue(Connection con, String p_user_name, String locale, String p_resp_id, String p_gov_code) throws Exception{
	Statement stmt			= null;
	ResultSet rs 			= null;
	JSONArray arrJSON		= new JSONArray();
	String sql				= "";

	try{

		if(("All").equals(p_gov_code))
		{
			sql = "SELECT u.facility_id facility_id, p.facility_name facility_name FROM sm_facility_for_user u, sm_facility_param_lang_vw p WHERE u.appl_user_id = '"+ p_user_name+"' AND p.language_id = '"+locale+"' AND p.facility_id = u.facility_id AND u.facility_id IN (SELECT DISTINCT facility_id FROM sm_facility_for_resp WHERE resp_id = '"+p_resp_id+"') ORDER BY 2";
		}else
		{
			sql = "SELECT u.facility_id facility_id, p.facility_name facility_name FROM sm_facility_for_user u, sm_facility_param_lang_vw p WHERE p.region_code = '"+ p_gov_code+"' AND u.appl_user_id = '"+ p_user_name+"' AND p.language_id = '"+locale+"' AND p.facility_id = u.facility_id AND u.facility_id IN (SELECT DISTINCT facility_id FROM sm_facility_for_resp WHERE resp_id = '"+p_resp_id+"') ORDER BY 2";
		}
		
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);

		while(rs!=null && rs.next()){
			
			JSONObject jsonObj = new JSONObject();
			String facility_id = rs.getString("facility_id")==null?"":rs.getString("facility_id");
			String facility_name = rs.getString("facility_name")==null?"":rs.getString("facility_name");

			jsonObj.put("facility_id",facility_id);
			jsonObj.put("facility_name",facility_name);
			arrJSON.add(jsonObj);
		}
		
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		try{
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}catch(Exception ex){
			System.err.println("Exception in getFacilityValue - "+ex.getMessage());
			ex.printStackTrace();
		}
	}
	return arrJSON;
}
/*End MOHE-CRF-0134*/

/*Added by Arthi for MOHE-CRF-0134*/
public static JSONObject getSMSiteParamDetail(Connection con, String locale) throws Exception{
			
		JSONObject jsonObj		= new JSONObject();
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String sql				= "";
		String region_prompt	= "";

		try{

			sql = "SELECT initcap(region_prompt) region_prompt,REGION_APPL_YN FROM sm_site_param_LANG_VW where language_id='"+locale+"' ";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				region_prompt = checkForNull(rs.getString("region_prompt"));
			}

			jsonObj.put("region_prompt",region_prompt);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getSMSiteParamDetail - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		return jsonObj;
	}
   /*End MOHE-CRF-0134*/

public static String checkForNull(String inputString){
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString,String defaultValue){
		return(((inputString == null) || (inputString.equals("null")) || (inputString.equals("")) ) ? defaultValue : inputString);
	}
}