package eMR;

import java.sql.*;
import java.io.*;
import java.util.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;
import webbeans.eCommon.*;

public class MRCoaderDiagBean implements Serializable{

	public static JSONArray getDiagClassCodeType(Connection con) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();
		try{
			String sql = "";
			sql="SELECT DIAG_CLASS_CODE, DIAG_CLASS_TYPE FROM MR_DIAG_CLASS WHERE EFF_STATUS='E' ORDER BY DIAG_CLASS_CODE";
			
					
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				String diagClassCode			= checkForNull(rs.getString("DIAG_CLASS_CODE"));
				String diagClassType			= checkForNull(rs.getString("DIAG_CLASS_TYPE"));
				JSONObject jsonObj	= new JSONObject();
				jsonObj.put("diagClassCode",diagClassCode);
				jsonObj.put("diagClassType",diagClassType);
				arrJSON.add(jsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getDiagClassCodeType - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}


	public static JSONArray getTermsetList(Connection con) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();

		try{
			String sql =  "select term_set_id,term_set_desc from mr_term_set where diag_spec_yn='Y' and eff_status = 'E'";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				String term_set_id		= rs.getString("term_set_id")==null?"":rs.getString("term_set_id");
				String term_set_desc		= rs.getString("term_set_desc")==null?"":rs.getString("term_set_desc");
				jsonObj.put("term_set_id",term_set_id);
				jsonObj.put("term_set_desc",term_set_desc);
				arrJSON.add(jsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getTermsetList - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}
	
	public static String getTermCodeDesc(Connection con, String termSetId, String termCode, String locale) throws Exception {
			String termCodeDesc	="";
			Statement stmt			= null;
			ResultSet rs 			= null;
			
		try{
			stmt = con.createStatement();
			String sql = "select short_desc from MR_D_"+termSetId+"_LANG_VW where  term_set_id='"+termSetId+"' and term_code='"+termCode+"' and language_id='"+locale+"' ";
			rs	= stmt.executeQuery(sql);
			if(rs!=null && rs.next()) {
				termCodeDesc = rs.getString("short_desc");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
				}catch(Exception ex){
					System.err.println("Exception in getTermCodeDesc - "+ex.getMessage());
					ex.printStackTrace();
				}
			}
		return termCodeDesc;
	}


public static JSONArray getDiagClassification(Connection con, String termSetId,String locale) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();
		try{
			String sql = "";
			sql="SELECT A.DIAG_CLASS_CODE, mr_get_desc.mr_diag_class(a.diag_class_code,'"+locale+"','2')SHORT_DESC,DIAG_CLASS_TYPE,B.DEFAULT_STATUS FROM MR_DIAG_CLASS A, MR_DIAG_CLASS_DTL B WHERE A.DIAG_CLASS_CODE = B.DIAG_CLASS_CODE AND B.TERM_SET_ID='"+termSetId+"' AND A.EFF_STATUS='E' ORDER BY SHORT_DESC";
			
					
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				String diagClassCode			= checkForNull(rs.getString("DIAG_CLASS_CODE"));
				String diagShortDesc			= checkForNull(rs.getString("SHORT_DESC"));
				String diagClassType			= checkForNull(rs.getString("DIAG_CLASS_TYPE"));
				String diagClassDefaultYN		= checkForNull(rs.getString("DEFAULT_STATUS"));
				
				JSONObject jsonObj	= new JSONObject();
				jsonObj.put("diagClassCode",diagClassCode);
				jsonObj.put("diagShortDesc",diagShortDesc);
				jsonObj.put("diagClassType",diagClassType);
				jsonObj.put("diagClassDefaultYN",diagClassDefaultYN);
				arrJSON.add(jsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getDiagClassification - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}

	public static String getLastModifiedDate(Connection con, String encounterId, String facilityId, String patientId) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 			= null;
		String modified_date		= "";
		try{

			String sql	= "select distinct to_char(modified_date,'dd/mm/rrrr hh24:mi') modified_date  FROM  PR_CODER_DIAGNOSIS_DTLS where encounter_id = ? and  facility_id = ? and patient_id = ? and INCLUDE_YN = 'Y'  order by modified_date desc";
			pstmt					= con.prepareStatement(sql);
			pstmt.setString(1,encounterId);
			pstmt.setString(2,facilityId);
			pstmt.setString(3,patientId);
			rs						= pstmt.executeQuery();
			if(rs!=null && rs.next()){
				 modified_date			= rs.getString("modified_date");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			
			}catch(Exception ex){
				System.err.println("Exception in getLastModifiedDate - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return modified_date;
	}

	public static JSONObject getDiagnosisList(Connection con, String patientId,String encounterId,String facilityId,String locale) throws Exception{
		//Statement stmt			= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();
		JSONObject json = new JSONObject();
				PreparedStatement pstmt		= null;
				PreparedStatement pstmt1		= null;
		try{
			String sql = "";
			int coderCount	= 0;
			//int noOfRecs	= 0;
			//sql="select count(*) cnt from PR_CODER_HDR where patient_id = '"+patientId+"' and encounter_id = '"+encounterId+"' and facility_id = '"+facilityId+"'";
			sql="select count(*) cnt from PR_CODER_HDR where encounter_id = ? and facility_id = ?";
			/*stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);*/

			pstmt					= con.prepareStatement(sql);
			pstmt.setString(1,encounterId);
			pstmt.setString(2,facilityId);
			rs						= pstmt.executeQuery();

			if(rs!=null && rs.next()){
				 coderCount			= rs.getInt("cnt");
			}
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(coderCount > 0){
				//sql="SELECT COUNT (*) OVER () noofrecords,b.term_set_id term_set_id, b.term_code term_code, mr_get_desc.mr_term_code(b.term_set_id,b.term_code,'en','2') term_short_desc, b.diag_class_code diag_class_code, b.poa_indicator poa_indicator, b.poa_indicator poa_indicator,to_char(b.onset_date,'dd/mm/rrrr hh24:mi') onset_date,b.reported_yn FROM pr_coder_hdr a, PR_CODER_DIAGNOSIS_DTLS b WHERE a.patient_id = b.patient_id AND a.encounter_id = b.encounter_id AND b.patient_id = '"+patientId+"' AND b.encounter_id = '"+encounterId+"' AND b.INCLUDE_YN = 'Y' AND b.facility_id = '"+facilityId+"' order by b.modified_date desc";
				sql="SELECT b.term_set_id term_set_id, b.term_code term_code, mr_get_desc.mr_term_code(b.term_set_id,b.term_code,'en','2') term_short_desc, b.diag_class_code diag_class_code, b.poa_indicator poa_indicator, b.poa_indicator poa_indicator,to_char(b.onset_date,'dd/mm/rrrr hh24:mi') onset_date,b.reported_yn,to_char(b.modified_date,'dd/mm/rrrr hh24:mi') modified_date  FROM  PR_CODER_DIAGNOSIS_DTLS b WHERE b.facility_id = ? AND b.encounter_id = ? and b.patient_id = ?  AND b.INCLUDE_YN = 'Y'  order by b.modified_date desc";
			}else{
				sql = "SELECT b.term_set_id term_set_id, b.term_code term_code, mr_get_desc.mr_term_code(b.term_set_id,b.term_code,'"+locale+"','2') term_short_desc,b.diag_class_code diag_class_code, b.poa_indicator poa_indicator,to_char(a.onset_date,'dd/mm/rrrr hh24:mi') onset_date  FROM pr_diagnosis a, pr_diagnosis_enc_dtl b WHERE a.patient_id = b.patient_id AND a.term_set_id = b.term_set_id and a.term_code = b.term_code AND a.occur_srl_no = b.occur_srl_no AND b.facility_id = ? AND b.encounter_id = ?  AND b.patient_id = ?  AND b.status <> 'E' order by b.modified_date desc";
			}
			
			pstmt1					= con.prepareStatement(sql);
			pstmt1.setString(1,facilityId);
			pstmt1.setString(2,encounterId);
			pstmt1.setString(3,patientId);
			rs						= pstmt1.executeQuery();


			while(rs!=null && rs.next()) {
				JSONObject jsonObj = new JSONObject();

				jsonObj.put("term_set_id",checkForNull(rs.getString("term_set_id")));
				jsonObj.put("term_code",checkForNull(rs.getString("term_code")));
				jsonObj.put("term_short_desc",checkForNull(rs.getString("term_short_desc")));
				jsonObj.put("diag_class_code",checkForNull(rs.getString("diag_class_code")));
				jsonObj.put("poa_indicator",checkForNull(rs.getString("poa_indicator")));
				jsonObj.put("onset_date",checkForNull(rs.getString("onset_date")));
				if(coderCount>0){
					jsonObj.put("reported_yn",checkForNull(rs.getString("reported_yn")));
					jsonObj.put("modified_date",checkForNull(rs.getString("modified_date")));
				}else{
					jsonObj.put("reported_yn","Y");
					jsonObj.put("modified_date","");
				}
				arrJSON.add(jsonObj);
			}


			json.put("coderCount",coderCount);
			json.put("diagnosisList",arrJSON);

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				//if(stmt!=null)stmt.close();
				if(pstmt!=null)pstmt.close();
				if(pstmt1!=null)pstmt1.close();
			}catch(Exception ex){
				System.err.println("Exception in getDiagnosisList - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return json;
	}

	public static String isCoderDiagnosisExist(Connection con, String patientId,String encounterId,String facilityId, String termSetId, String termCode) throws Exception {
			int cnt	=0;
			Statement stmt			= null;
			ResultSet rs 			= null;
			String isCodeExist		= "N";		
			
		try{
			stmt = con.createStatement();
			String sql = "select count(*) cnt from PR_CODER_DIAGNOSIS_DTLS where patient_id = '"+patientId+"' and encounter_id='"+encounterId+"' and facility_id='"+facilityId+"' and term_set_id = '"+termSetId+"' and term_code='"+termCode+"'";
			rs	= stmt.executeQuery(sql);
			if(rs!=null && rs.next()) {
				cnt = rs.getInt("cnt");
			}
			if(cnt>0){
					isCodeExist	 = "Y";
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
				}catch(Exception ex){
					System.err.println("Exception in getTermCodeDesc - "+ex.getMessage());
					ex.printStackTrace();
				}
			}
		return isCodeExist;
	}

	public static String getExistingTermCodeDtls(Connection con, String encounterId,String facilityId) throws Exception {
			Statement stmt			= null;
			ResultSet rs 			= null;
			String existingTermCodeDtls		= "";		
			
		try{
			stmt = con.createStatement();
			String sql = "select TERM_SET_ID || '~' || TERM_CODE term_set_code from PR_CODER_DIAGNOSIS_DTLS where encounter_id = '"+encounterId+"' and facility_id = '"+facilityId+"' ";
			rs	= stmt.executeQuery(sql);
			while(rs!=null && rs.next()) {
				existingTermCodeDtls = existingTermCodeDtls + rs.getString("term_set_code")+"|@|";
			}
	
		}
		catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
				}catch(Exception ex){
					System.err.println("Exception in getExistingTermCodeDtls - "+ex.getMessage());
					ex.printStackTrace();
				}
			}
		return existingTermCodeDtls;
	}
public static JSONObject getPatDemographicEncDtls(Connection con,String encounterId,String patientId,String facilityId, String locale) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONObject jsonObj	= new JSONObject();

		try{
			//Modified By Dharma on Aug 8th 2020 against AAKH-SCF-0444
			//String sql = "SELECT patient_id,DECODE ('"+locale+"','en', patient_name, NVL (patient_name_loc_lang, patient_name)) patient_name, sex, TO_CHAR(date_of_birth,'dd/mm/yyyy') date_of_birth, (CASE WHEN nationality_code IS NOT NULL THEN (mp_get_desc.mp_country (nationality_code, '"+locale+"', 3)) END) nationality_desc,DECODE (assign_care_locn_type,'N', ip_get_desc.ip_nursing_unit (facility_id,assign_care_locn_code,'"+locale+"','2'),op_get_desc.op_clinic (facility_id, assign_care_locn_code, '"+locale+"', '2')) location_desc,attend_practitioner_id,am_get_desc.am_practitioner (attend_practitioner_id,'"+locale+"','1') practitioner_name, TO_CHAR(visit_adm_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date_time, patient_class,(CASE WHEN attend_practitioner_id IS NOT NULL THEN (SELECT apc_no FROM am_practitioner WHERE practitioner_id = a.attend_practitioner_id) END ) apc_no,(CASE WHEN patient_class = 'OP' THEN (op_get_desc.op_visit_type (facility_id, visit_adm_type, '"+locale+"', '2' ) ) END ) visit_type_desc, (SELECT short_name   FROM ar_customer_lang_vw  WHERE language_id = '"+locale+"' AND cust_code IN ( SELECT cust_code  FROM bl_visit_fin_dtls WHERE operating_facility_id = '"+facilityId+"'   AND episode_type IN ('O', 'E')   AND encounter_id = '"+encounterId+"') UNION SELECT short_name   FROM ar_customer_lang_vw  WHERE language_id = '"+locale+"' AND cust_code IN ( SELECT cust_code  FROM bl_episode_fin_dtls WHERE operating_facility_id = '"+facilityId+"'   AND episode_type IN ('I', 'D')   AND encounter_id = '"+encounterId+"')) payer_dtls  FROM pr_encounter_vw a WHERE encounter_id = '"+encounterId+"' AND a.patient_id = '"+patientId+"' and FACILITY_ID = '"+facilityId+"'"; 
			// Modified by Lakshmanan against AAKH-CRF-0172 US011	
		//	String sql = "SELECT patient_id,DECODE ('"+locale+"','en', patient_name, NVL (patient_name_loc_lang, patient_name)) patient_name, sex, TO_CHAR(date_of_birth,'dd/mm/yyyy') date_of_birth, (CASE WHEN nationality_code IS NOT NULL THEN (mp_get_desc.mp_country (nationality_code, '"+locale+"', 3)) END) nationality_desc,DECODE (assign_care_locn_type,'N', ip_get_desc.ip_nursing_unit (facility_id,assign_care_locn_code,'"+locale+"','2'),op_get_desc.op_clinic (facility_id, assign_care_locn_code, '"+locale+"', '2')) location_desc,attend_practitioner_id,am_get_desc.am_practitioner (attend_practitioner_id,'"+locale+"','1') practitioner_name, TO_CHAR(visit_adm_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date_time, patient_class,(CASE WHEN attend_practitioner_id IS NOT NULL THEN (SELECT apc_no FROM am_practitioner WHERE practitioner_id = a.attend_practitioner_id) END ) apc_no,(select pr_coder_patient_visit_status('"+facilityId+"','"+patientId+"','"+encounterId+"') visit_type_desc from dual) visit_type_desc, (SELECT short_name   FROM ar_customer_lang_vw  WHERE language_id = '"+locale+"' AND cust_code IN ( SELECT cust_code  FROM bl_visit_fin_dtls WHERE operating_facility_id = '"+facilityId+"'   AND episode_type IN ('O', 'E')   AND encounter_id = '"+encounterId+"') UNION SELECT short_name   FROM ar_customer_lang_vw  WHERE language_id = '"+locale+"' AND cust_code IN ( SELECT cust_code  FROM bl_episode_fin_dtls WHERE operating_facility_id = '"+facilityId+"'   AND episode_type IN ('I', 'D')   AND encounter_id = '"+encounterId+"')) payer_dtls  FROM pr_encounter_vw a WHERE encounter_id = '"+encounterId+"' AND a.patient_id = '"+patientId+"' and FACILITY_ID = '"+facilityId+"'"; 
			String sql = "SELECT a.patient_id,DECODE ('"+locale+"','en', patient_name, NVL (patient_name_loc_lang, patient_name)) patient_name, sex, TO_CHAR(date_of_birth,'dd/mm/yyyy') date_of_birth, (CASE WHEN nationality_code IS NOT NULL THEN (mp_get_desc.mp_country (nationality_code, '"+locale+"', 3)) END) nationality_desc,DECODE (assign_care_locn_type,'N', ip_get_desc.ip_nursing_unit (a.facility_id,assign_care_locn_code,'"+locale+"','2'),op_get_desc.op_clinic (a.facility_id, assign_care_locn_code, '"+locale+"', '2')) location_desc,attend_practitioner_id,am_get_desc.am_practitioner (attend_practitioner_id,'"+locale+"','1') practitioner_name, TO_CHAR(visit_adm_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date_time, a.patient_class,(CASE WHEN attend_practitioner_id IS NOT NULL THEN (SELECT apc_no FROM am_practitioner WHERE practitioner_id = a.attend_practitioner_id) END ) apc_no,(select pr_coder_patient_visit_status('"+facilityId+"','"+patientId+"','"+encounterId+"') visit_type_desc from dual) visit_type_desc, (SELECT short_name   FROM ar_customer_lang_vw  WHERE language_id = '"+locale+"' AND cust_code IN ( SELECT cust_code  FROM bl_visit_fin_dtls WHERE operating_facility_id = '"+facilityId+"'   AND episode_type IN ('O', 'E')   AND encounter_id = '"+encounterId+"') UNION SELECT short_name   FROM ar_customer_lang_vw  WHERE language_id = '"+locale+"' AND cust_code IN ( SELECT cust_code  FROM bl_episode_fin_dtls WHERE operating_facility_id = '"+facilityId+"'   AND episode_type IN ('I', 'D')   AND encounter_id = '"+encounterId+"')) payer_dtls , DECODE (b.STATUS,'SC','SUPERVISOR CLEARANCE COMPLETED','SQ', 'SUPERVISOR QUERY','DQ', 'DOCTOR QUERY','PC', 'PARTIALLY COMPLETED','HD', 'HOLD','CO', 'COMPLETED','NW', 'NEW','NEW') STATUS FROM pr_encounter_vw a, CA_CODER_STATUS b WHERE a.encounter_id = '"+encounterId+"' AND a.patient_id = '"+patientId+"' and a.FACILITY_ID = '"+facilityId+"' AND A.ENCOUNTER_ID=B.ENCOUNTER_ID(+) AND A.FACILITY_ID=B.FACILITY_ID(+) AND A.PATIENT_ID=B.PATIENT_ID(+) AND A.PATIENT_CLASS=B.PATIENT_CLASS(+) "; 


			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			if(rs!=null && rs.next()){
				
				jsonObj.put("patient_id",checkForNull(rs.getString("patient_id")));
				jsonObj.put("patient_name",checkForNull(rs.getString("patient_name")));
				jsonObj.put("patient_class",checkForNull(rs.getString("patient_class")));
				jsonObj.put("sex",checkForNull(rs.getString("sex")));
				jsonObj.put("date_of_birth",checkForNull(rs.getString("date_of_birth")));
				jsonObj.put("nationality_desc",checkForNull(rs.getString("nationality_desc")));
				jsonObj.put("location_desc",checkForNull(rs.getString("location_desc")));
				jsonObj.put("visit_type_desc",checkForNull(rs.getString("visit_type_desc")));
				jsonObj.put("attend_practitioner_id",checkForNull(rs.getString("attend_practitioner_id")));
				jsonObj.put("practitioner_name",checkForNull(rs.getString("practitioner_name")));
				jsonObj.put("visit_adm_date_time",checkForNull(rs.getString("visit_adm_date_time")));
				jsonObj.put("apc_no",checkForNull(rs.getString("apc_no")));
				jsonObj.put("payer_dtls",checkForNull(rs.getString("payer_dtls")));
				jsonObj.put("status",checkForNull(rs.getString("STATUS"))); // added against AAKH-CRF-0172 US011
				
							
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getPatDemographicEncDtls - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}




	public static String checkForNull(String inputString){
			return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	
}