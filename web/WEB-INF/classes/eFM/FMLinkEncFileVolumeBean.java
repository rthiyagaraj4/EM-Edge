package eFM;

import java.sql.*;
import java.io.*;
import java.util.*;
import org.json.simple.*;

public class FMLinkEncFileVolumeBean implements Serializable{

	public static JSONObject getFMParamValues(Connection con,String facilityId) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		JSONObject jsonObj			= new JSONObject();	
		String sql					= "";
		String user_security_yn					= "N";
		String link_bet_file_and_enctr_yn		= "N";

		try{

			sql						= "select user_security_yn,link_bet_file_and_enctr_yn from fm_parameter where facility_id = ?";
			pstmt					= con.prepareStatement(sql);
			pstmt.setString(1,facilityId);
			rs						= pstmt.executeQuery();
			
			if(rs!=null && rs.next()){
				user_security_yn					= rs.getString("user_security_yn")==null?"N":rs.getString("user_security_yn");
				link_bet_file_and_enctr_yn			= rs.getString("link_bet_file_and_enctr_yn")==null?"N":rs.getString("link_bet_file_and_enctr_yn");
			}

			jsonObj.put("user_security_yn",user_security_yn);
			jsonObj.put("link_bet_file_and_enctr_yn",link_bet_file_and_enctr_yn);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getFMParamValues method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}

	public static int getFMUserAccessRightsCount(Connection con,String facilityId){
		String sql ="SELECT 1 FROM fm_user_access_rights WHERE facility_id=?";
		int count=0;
		PreparedStatement pstmt=null;
		ResultSet  rs=null;
		try{
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,facilityId);
			rs=pstmt.executeQuery();
		
			if(rs!=null && rs.next()){
				count=rs.getInt(1);
			}
		}catch(Exception ex){
			System.err.println("Exception in getFMUserAccessRightsCount --> "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
		return count;
	}


	public static JSONObject getEncFileVolumeAuditDtls(Connection con,String reqPatientId,String reqFileNo,String reqFileType,String localeName,int currentPageNo,int recordsPerPage) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		JSONObject json				= new JSONObject();
		String sql					= "";
		JSONArray jsonArray			= new JSONArray();
		int noOfRecs				= 0;
		int noOfPages	 			= 0;	
		int from 		 			= 1;
		int to			 			= recordsPerPage;
		
		
		if(currentPageNo!=1){
			from		= (currentPageNo - 1) * recordsPerPage +1;
			to			= (from -1) + recordsPerPage;
		}

		try{
			
			sql						= "SELECT * FROM (SELECT ROWNUM AS rcnt,results.*  FROM (";
			sql						= sql + " SELECT COUNT (*) OVER () noOfRecords,AM_GET_DESC.AM_PATIENT_CLASS(PATIENT_CLASS,'"+localeName+"','1') encounterType,encounter_id, TO_CHAR(Encounter_Date_Time,'dd/mm/rrrr hh24:mi') encounterDateTime,volume_no,facility_id,patient_id,file_no,decode(TRNS_TYPE,'C','Change','L','Link','D','De-Link') TRNS_TYPE, TO_CHAR(MODIFIED_DATE,'dd/mm/rrrr hh24:mi') activityDateTime,sm_get_desc.sm_appl_user(added_by_id,'"+localeName+"',1) done_by,DECODE(ASSIGN_CARE_LOCN_TYPE,'N',IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, ASSIGN_CARE_LOCN_CODE,'"+localeName+"','1'), OP_GET_DESC.OP_CLINIC(FACILITY_ID, ASSIGN_CARE_LOCN_CODE,'"+localeName+"','1')) location,MR_GET_DESC.MR_FILE_TYPE(FACILITY_ID, FILE_TYPE_CODE,'"+localeName+"','2') file_type_desc, file_type_code from FM_ENCOUNTER_VOLUME_LINK_LOG where patient_id='"+reqPatientId+"'";
			
			if(!reqFileNo.equals("")){
				sql					= sql + " and file_no = '"+reqFileNo+"'";
			}
			if(!reqFileType.equals("")){
				sql					= sql + " and file_type_code = '"+reqFileType+"'";
			}
			sql		= sql+" order by modified_date desc";

			sql		= sql+" ) results) where rcnt between '"+from+"' AND '"+to+"'";

			
			pstmt					= con.prepareStatement(sql);
			rs						= pstmt.executeQuery();
			while(rs!=null && rs.next()){
				String encounterType		= rs.getString("encounterType")==null?"":rs.getString("encounterType");
				String encounterID			= rs.getString("encounter_id")==null?"":rs.getString("encounter_id");
				String encounterDateTime	= rs.getString("encounterDateTime")==null?"":rs.getString("encounterDateTime");
				String fileNO				= rs.getString("file_no")==null?"":rs.getString("file_no");
				String fileVolumeNo			= rs.getString("volume_no")==null?"":rs.getString("volume_no");
				String activity				= rs.getString("TRNS_TYPE")==null?"":rs.getString("TRNS_TYPE");
				String activityDateTime		= rs.getString("activityDateTime")==null?"":rs.getString("activityDateTime");
				String doneBy				= rs.getString("done_by")==null?"":rs.getString("done_by");
				String location				= rs.getString("location")==null?"":rs.getString("location");
				String patientId			= rs.getString("patient_id")==null?"":rs.getString("patient_id");
				String facilityId			= rs.getString("facility_id")==null?"":rs.getString("facility_id");
				String fileTypCode			= rs.getString("file_type_code")==null?"":rs.getString("file_type_code");
				String fileTypeDesc			= rs.getString("file_type_desc")==null?"":rs.getString("file_type_desc");
				noOfRecs					= rs.getInt("noOfRecords");
				JSONObject jsonObj			= new JSONObject();	
				
				jsonObj.put("encounterType",encounterType);
				jsonObj.put("encounterID",encounterID);
				jsonObj.put("encounterDateTime",encounterDateTime);
				jsonObj.put("location",location);
				jsonObj.put("fileNO",fileNO);
				jsonObj.put("fileVolumeNo",fileVolumeNo);
				jsonObj.put("activity",activity);
				jsonObj.put("activityDateTime",activityDateTime);
				jsonObj.put("doneBy",doneBy);
				jsonObj.put("facilityId",facilityId);
				jsonObj.put("patientId",patientId);
				jsonObj.put("fileTypCode",fileTypCode);
				jsonObj.put("fileTypeDesc",fileTypeDesc);
				jsonArray.add(jsonObj);

			}
			
			noOfPages = (int) Math.ceil(noOfRecs * 1.0 / recordsPerPage);
			if(to > noOfRecs){
				to	= noOfRecs;
			}
			json.put("fileVolumeAuditDtls",jsonArray);
			json.put("currentPageNo", currentPageNo);
			json.put("noOfRecords", noOfRecs);
			json.put("noOfPages", noOfPages);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getEncFileVolumeAuditDtls method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return json;
	}
}//End of Bean