package eMR;

import java.sql.*;
import java.io.*;
import java.util.*;
import org.json.simple.*;

public class MRPatDisposalArchivalBean implements Serializable{
	
public static JSONArray getSpecailtyList(Connection con, String locale,String arch_disp) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		JSONArray specialityArrJSON	= new JSONArray();
	
		try{

			String sql = " select cut_off_period,speciality_code,AM_GET_DESC.AM_SPECIALITY(speciality_code,'"+locale+"',2 ) short_desc from MP_ARCH_DISP_CRITERIA where arch_disp='"+arch_disp+"' order by cut_off_period,short_desc";
			pstmt   = con.prepareStatement(sql);
			rs    = pstmt.executeQuery();

			while(rs!=null && rs.next()){
				
				JSONObject specialityJsonObj	= new JSONObject();
				String specialityCode	= checkForNull(rs.getString("speciality_code"));
				String specialityShortDesc		= checkForNull(rs.getString("short_desc"));
				String cutOffPeriod		= checkForNull(rs.getString("cut_off_period"));

				specialityJsonObj.put("specialityCode",specialityCode);
				specialityJsonObj.put("specialityShortDesc",specialityShortDesc);
				specialityJsonObj.put("cutOffPeriod",cutOffPeriod);
				specialityArrJSON.add(specialityJsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getSpecailtyList - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return specialityArrJSON;
	}

public static JSONArray getBatchIdDtls(Connection con, String locale,String batchId) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		JSONArray batchIdDtlsArrJSON	= new JSONArray();
	
		try{

			String sql = " SELECT a.patient_id patient_id, a.patient_name patient_name,DECODE (a.sex, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender,TO_CHAR (date_of_birth, 'DD/MM/RRRR') dob,CASE WHEN a.national_id_no IS NOT NULL THEN a.national_id_no WHEN a.alt_id1_no IS NOT NULL THEN a.alt_id1_no WHEN a.alt_id2_no IS NOT NULL THEN a.alt_id2_no WHEN a.alt_id3_no IS NOT NULL THEN a.alt_id3_no WHEN a.alt_id4_no IS NOT NULL THEN a.alt_id4_no WHEN a.oth_alt_id_no IS NOT NULL THEN a.oth_alt_id_no END alternate_id, sm_get_desc.sm_appl_user (b.added_by_id, '"+locale+"', 1) added_by, TO_CHAR (b.added_date, 'DD/MM/RRRR') dis_trn_date,am_get_desc.AM_SPECIALITY(b.LAST_ENC_SPECIALITY,'"+locale+"',2) last_enc_speciality,decode(b.LAST_ENC_PAT_CLASS,'IP','Inpatient','OP','Outpatient','EM','Emergency','DC','DayCare') last_enc_pat_class,TO_CHAR (b.LAST_DISCH_DATE,'DD/MM/YYYY HH24:MI') last_disch_date,b.pat_age,decode(b.PAT_STATUS,'D','Death','N','') pat_status FROM mp_patient a, mp_disp_pend_approval b WHERE a.patient_id = b.dispose_pat_id AND disp_batch_id = '"+batchId+"' order by b.dispose_pat_id asc";
			pstmt   = con.prepareStatement(sql);
			rs    = pstmt.executeQuery();

			while(rs!=null && rs.next()){
				
				JSONObject batchIdDtlsJsonObj	= new JSONObject();
				String patient_id	= checkForNull(rs.getString("patient_id"));
				String patient_name		= checkForNull(rs.getString("patient_name"));
				String gender		= checkForNull(rs.getString("gender"));
				String dob	= checkForNull(rs.getString("dob"));
				String alternate_id		= checkForNull(rs.getString("alternate_id"));
				String added_by		= checkForNull(rs.getString("added_by"));
				String dis_trn_date		= checkForNull(rs.getString("dis_trn_date"));
				String last_enc_speciality		= checkForNull(rs.getString("last_enc_speciality"));
				String last_enc_pat_class		= checkForNull(rs.getString("last_enc_pat_class"));
				String last_disch_date		= checkForNull(rs.getString("last_disch_date"));
				String pat_age		= checkForNull(rs.getString("pat_age"));
				String pat_status		= checkForNull(rs.getString("pat_status"));

				batchIdDtlsJsonObj.put("patient_id",patient_id);
				batchIdDtlsJsonObj.put("patient_name",patient_name);
				batchIdDtlsJsonObj.put("gender",gender);
				batchIdDtlsJsonObj.put("dob",dob);
				batchIdDtlsJsonObj.put("alternate_id",alternate_id);
				batchIdDtlsJsonObj.put("added_by",added_by);
				batchIdDtlsJsonObj.put("dis_trn_date",dis_trn_date);
				batchIdDtlsJsonObj.put("last_enc_speciality",last_enc_speciality);
				batchIdDtlsJsonObj.put("last_enc_pat_class",last_enc_pat_class);
				batchIdDtlsJsonObj.put("last_disch_date",last_disch_date);
				batchIdDtlsJsonObj.put("pat_age",pat_age);
				batchIdDtlsJsonObj.put("pat_status",pat_status);
				batchIdDtlsArrJSON.add(batchIdDtlsJsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getBatchIdDtls - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return batchIdDtlsArrJSON;
	}


public static JSONArray getBatchIds(Connection con) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		JSONArray batchIdyArrJSON	= new JSONArray();
	
		try{

			String sql = " select distinct DISP_BATCH_ID  DISP_BATCH_ID from MP_DISP_PEND_APPROVAL";
			pstmt   = con.prepareStatement(sql);
			rs    = pstmt.executeQuery();

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				String batchId	= checkForNull(rs.getString("DISP_BATCH_ID"));
	
				jsonObj.put("batchId",batchId);
				batchIdyArrJSON.add(jsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getBatchIds - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return batchIdyArrJSON;
	}


public static String checkForNull(String inputString){
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}

public static String checkForNull(String inputString,String defaultValue){
	return(((inputString == null) || (inputString.equals("null")) || (inputString.equals("")) ) ? defaultValue : inputString);
	}

}