
/*Created by Thamizh selvi on 24th July 2017 for ML-MMOH-CRF-0689*/ 
package eMO;

import java.sql.*; 
import java.io.*;
import java.util.*;
import org.json.simple.*;

public class MOCommonBean implements Serializable{
	
	public static JSONArray getPatSeriesList(Connection con) throws Exception{

		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();

		try{
			String sql = "select pat_ser_grp_code,short_desc from mp_pat_ser_grp where id_type = 'R' order by short_desc";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				
				String parSeriesCode		= rs.getString("pat_ser_grp_code")==null?"":rs.getString("pat_ser_grp_code");
				String patSeriesshortDesc	= rs.getString("short_desc")==null?"":rs.getString("short_desc");
				
				jsonObj.put("parSeriesCode",parSeriesCode);
				jsonObj.put("patSeriesshortDesc",patSeriesshortDesc);
				
				arrJSON.add(jsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getPatSeriesList - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}

	public static JSONObject chkForExtBidBodyPartPatient(Connection con, String patientId, String facilityId) throws Exception{

		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		JSONObject jsonObj			= new JSONObject();
		Integer bidCount			= 0;
		Integer bodyPartCount		= 0;

		try{
			String bidSql = " SELECT COUNT (*) bid_count FROM mp_patient WHERE patient_id = '"+patientId+"' AND pat_ser_grp_code = (SELECT pat_series_for_bid FROM mo_parameter WHERE facility_id = '"+facilityId+"') ";
			
			pstmt = con.prepareStatement(bidSql);
			rs	= pstmt.executeQuery();

			if(rs!=null && rs.next())
				bidCount = rs.getInt("bid_count");

             if(rs != null) rs.close() ; //Added for checkstyle
			String bodyPartSql = " SELECT COUNT (*) body_part_count FROM mp_patient WHERE patient_id = '"+patientId+"' AND pat_ser_grp_code = (SELECT pat_series_for_body_part FROM mo_parameter WHERE facility_id = '"+facilityId+"') ";
			
			pstmt = con.prepareStatement(bodyPartSql);
			rs	= pstmt.executeQuery();

			if(rs!=null && rs.next())
				bodyPartCount = rs.getInt("body_part_count");

			jsonObj.put("bidCount",bidCount);
			jsonObj.put("bodyPartCount",bodyPartCount);

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in chkForExtBidBodyPartPatient - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}

	public static JSONObject getMOParam(Connection con, String facilityId) throws Exception{

		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		JSONObject jsonObj		= new JSONObject();
		String policeDtlsMandYn	= "";
		String record_pm_find_dtls_yn=""; // added by mujafar for ML-MMOH-CRF-0880
		String enable_rfid_yn = ""; // added by mujafar for ML-MMOH-CRF-0996

		try{
			String sql = " select * from mo_parameter where facility_id='"+facilityId+"' ";
			
			pstmt = con.prepareStatement(sql);
			rs	= pstmt.executeQuery();

			if(rs!=null && rs.next())
			{
				policeDtlsMandYn	= rs.getString("police_dtls_reqd_yn");
				record_pm_find_dtls_yn = rs.getString("pm_dtls_reqd_yn"); // added by mujafar for ML-MMOH-CRF-0880
				enable_rfid_yn = rs.getString("enable_rfid_yn"); // added by mujafar for ML-MMOH-CRF-0996
			}
			
			jsonObj.put("policeDtlsMandYn",policeDtlsMandYn);
			jsonObj.put("record_pm_find_dtls_yn",record_pm_find_dtls_yn); //added by mujafar for ML-MMOH-CRF-0880
			jsonObj.put("enable_rfid_yn",enable_rfid_yn); //added by mujafar for ML-MMOH-CRF-0880

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getMOParam - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}
	
	//Added by Ashwini on 27-Oct-2017 for ML-MMOH-CRF-0790
	public static JSONObject getCurrentDate(Connection con) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONObject jsonObj		= new JSONObject();

		try{
			String sql = "select to_char(sysdate,'yyyy') CurrentYear, to_char(sysdate,'DD/MM/yyyy') CurrentDate from dual";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			if(rs!=null && rs.next()){
				String CurrentYear		= rs.getString("CurrentYear")==null?"":rs.getString("CurrentYear");
				String CurrentDate		= rs.getString("CurrentDate")==null?"":rs.getString("CurrentDate");
				jsonObj.put("CurrentYear",CurrentYear);
				jsonObj.put("CurrentDate",CurrentDate);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getCurrentDate - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}

	/*Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
	public static JSONArray getClaimantType(Connection con, String function_id) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();
		String sql				= "";

		try{

			if(("CLAIMANT_TYPE").equals(function_id) || ("UNIDENT_BODY_PART").equals(function_id))
			{
				sql = "SELECT claimant_type_mstr_code, short_desc FROM mo_claimant_type_mstr WHERE eff_status = 'E' AND claimant_type_mstr_code NOT IN ('K', 'E', 'F') order by short_desc asc";
			}else
			{
				sql = "SELECT claimant_type_mstr_code, short_desc FROM mo_claimant_type_mstr WHERE eff_status = 'E' order by short_desc asc";
			}
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				String claimant_type_mstr_code	= rs.getString("claimant_type_mstr_code")==null?"":rs.getString("claimant_type_mstr_code");
				String short_desc		= rs.getString("short_desc")==null?"":rs.getString("short_desc");
				jsonObj.put("claimant_type_mstr_code",claimant_type_mstr_code);
				jsonObj.put("short_desc",short_desc);
				arrJSON.add(jsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getClaimantType - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}
	/*End ML-MMOH-CRF-1095*/


	//Added by Ashwin K for ML-MMOH-CRF-1891


	
	public static String getMORegState(Connection con,String facility_Id,String patient_id) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		String sql					= "";
		String finalize_yn	= "N";
		try{
			sql				= "SELECT    c.finalize_yn as finalize_yn FROM pr_encounter a,mp_patient b,    mr_death_register_hdr c where b.patient_id  = a.patient_id  and a.encounter_id = c.encounter_id  and a.facility_id = '"+facility_Id+"' and a.facility_id =c.facility_id AND  a.patient_id like '"+patient_id+"'";
			pstmt			= con.prepareStatement(sql);
			rs				= pstmt.executeQuery();
			if(rs!=null && rs.next()){
				finalize_yn			= rs.getString("finalize_yn");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getMORegState method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return finalize_yn;
	}

	//Ended by Ashwin K for ML-MMOH-CRF-1891
} 