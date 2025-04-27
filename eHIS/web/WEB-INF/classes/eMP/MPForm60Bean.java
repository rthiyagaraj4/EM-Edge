/*Created by Dharma on Apr 10th 2017 against KDAH-CRF-0347*/
package eMP;

import java.sql.*;
import java.io.*;
import java.util.*;
import org.json.simple.*;

public class MPForm60Bean implements Serializable{
	
	
	public static JSONObject getEncounterType(Connection con) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		JSONObject json				= new JSONObject();
		String sql					= "";
		JSONArray jsonArray			= new JSONArray();

		try{
			sql						= " select PATIENT_CLASS, short_desc from am_patient_class where PATIENT_CLASS!='XT' order by 1";
			pstmt					= con.prepareStatement(sql);
			rs						= pstmt.executeQuery();
			
			while(rs!=null && rs.next()){
				String patientClass		= rs.getString("PATIENT_CLASS")==null?"":rs.getString("PATIENT_CLASS");
				String shortDesc		= rs.getString("short_desc")==null?"":rs.getString("short_desc");
				JSONObject jsonObj			= new JSONObject();		
				jsonObj.put("patientClass",patientClass);
				jsonObj.put("shortDesc",shortDesc);
				jsonArray.add(jsonObj);
			}
			json.put("results",jsonArray);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getEncounterType method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return json;
	}


	public static JSONObject getEncounterDetails(Connection con,String reqPatientId,String reqEncounterId,String reqEncounterType,int currentPageNo,int recordsPerPage,String isPanCardAvailableYN, String loginFacilityId) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		JSONObject json				= new JSONObject();
		String sql					= "";
		JSONArray jsonArray			= new JSONArray();
		int noOfRecs				= 0;
		int noOfPages	 			= 0;	
		int from 		 			= 1;
		int to			 			= recordsPerPage;
		String form60Sql			= " Where "; 
		
		
		if(currentPageNo!=1){
			from		= (currentPageNo - 1) * recordsPerPage +1;
			to			= (from -1) + recordsPerPage;
		}

		try{
			sql						= "SELECT * FROM (SELECT ROWNUM AS rcnt,results.*  FROM (";
			sql						= sql + " SELECT COUNT (*) OVER () noOfRecords,a.patient_id,a.encounter_id,to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date_time,a.facility_id,a.patient_class,a.episode_id,a.op_episode_visit_num,DECODE (a.patient_class,'OP', 'O','IP', 'I','DC', 'D','EM', 'E','R') episode_type,to_char(a.discharge_date_time,'dd/mm/yyyy hh24:mi') discharge_date_time FROM pr_encounter a ";
			if("Y".equals(isPanCardAvailableYN)){
				form60Sql		= " , mp_form60 b where a.patient_id = b.patient_id and a.encounter_id = b.encounter_id and a.facility_id=b.facility_id and b.status <> 'C' and ";
			}
			sql						= sql + form60Sql+ " (a.visit_status != '99' OR a.adt_status != '09') AND a.patient_id = '"+reqPatientId+"' and a.facility_id = '"+loginFacilityId+"' ";
			
			if(!reqEncounterId.equals("")){
				sql					= sql + " and a.encounter_id = '"+reqEncounterId+"'";
			}
			if(!reqEncounterType.equals("")){
				sql					= sql + " and a.patient_class = '"+reqEncounterType+"'";
			}
			sql		= sql+" order by a.visit_adm_date_time desc";

			sql		= sql+" ) results) where rcnt between '"+from+"' AND '"+to+"'";

			pstmt					= con.prepareStatement(sql);
			rs						= pstmt.executeQuery();
			while(rs!=null && rs.next()){
				String encounterID			= rs.getString("encounter_id")==null?"":rs.getString("encounter_id");
				String visitAdmDateTime		= rs.getString("visit_adm_date_time")==null?"":rs.getString("visit_adm_date_time");
				String facilityId			= rs.getString("facility_id")==null?"":rs.getString("facility_id");
				String patientId			= rs.getString("patient_id")==null?"":rs.getString("patient_id");
				String encounterType		= rs.getString("patient_class")==null?"":rs.getString("patient_class");
				String episodeId			= rs.getString("episode_id")==null?"":rs.getString("episode_id");
				String opEpisodeVisitNum	= rs.getString("op_episode_visit_num")==null?"":rs.getString("op_episode_visit_num");
				String episodeType			= rs.getString("episode_type")==null?"":rs.getString("episode_type");
				String dischargeDatetime	= rs.getString("discharge_date_time")==null?"":rs.getString("discharge_date_time");
				noOfRecs					= rs.getInt("noOfRecords");
				JSONObject jsonObj			= new JSONObject();	
				
				jsonObj.put("encounterID",encounterID);
				jsonObj.put("visitAdmDateTime",visitAdmDateTime);
				jsonObj.put("facilityId",facilityId);
				jsonObj.put("patientId",patientId);
				jsonObj.put("encounterType",encounterType);
				jsonObj.put("episodeId",episodeId);
				jsonObj.put("opEpisodeVisitNum",opEpisodeVisitNum);
				jsonObj.put("episodeType",episodeType);
				jsonObj.put("dischargeDatetime",dischargeDatetime);
				jsonArray.add(jsonObj);


			}
			
			noOfPages = (int) Math.ceil(noOfRecs * 1.0 / recordsPerPage);
			if(to > noOfRecs){
				to	= noOfRecs;
			}
			json.put("encounterLists",jsonArray);
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
				System.err.println("Exception in getEncounterDetails method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return json;
	}
	
	
	public static String getForm60StatusForEncounter(Connection con,String encounterId) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		String sql					= "";
		int i						= 1;
		String status				= "";
		try{
			sql						= " SELECT STATUS FROM mp_form60  WHERE ENCOUNTER_ID = ? and status!='C'";
			pstmt					= con.prepareStatement(sql);
			pstmt.setString( i++, encounterId ) ;
			rs						= pstmt.executeQuery();
			if(rs!=null && rs.next()){
				status			= rs.getString("STATUS")==null?"":rs.getString("STATUS");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getForm60StatusForEncounter method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return status;
	}

	public static String getForm60AckNo(Connection con,String encounterId) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		String sql					= "";
		int i						= 1;
		String ACKNOWLEDG_NO_FORM60				= "";
		try{
			sql						= " SELECT ACKNOWLEDG_NO_FORM60 FROM mp_form60  WHERE ENCOUNTER_ID = ? and status!='C'";
			pstmt					= con.prepareStatement(sql);
			pstmt.setString( i++, encounterId ) ;
			rs						= pstmt.executeQuery();
			if(rs!=null && rs.next()){
				ACKNOWLEDG_NO_FORM60			= rs.getString("ACKNOWLEDG_NO_FORM60")==null?"":rs.getString("ACKNOWLEDG_NO_FORM60");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getForm60AckNo method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return ACKNOWLEDG_NO_FORM60;
	}

	public static String getForm60StatusForPatient(Connection con,String reqPatientId) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		PreparedStatement pstmt1	= null;
		ResultSet rs1				= null;
		String sql					= "";
		String patientId			= "";
		String encounterId			= "";
		String status				= "";
		String ackNo				= "";
		int form60Count				= 0;
		String returnValue			= "";
		String sqlOpenEncounterList	= "";
		String openEncounterIds		= "";
		try{
			sqlOpenEncounterList						= " SELECT encounter_id FROM pr_encounter WHERE (visit_status != '99' OR adt_status != '09') AND discharge_date_time IS NULL AND patient_id = ?";
			//sqlOpenEncounterList						= " SELECT encounter_id FROM pr_encounter WHERE (visit_status != '99' OR adt_status != '09') AND patient_id = ?";
			pstmt1					= con.prepareStatement(sqlOpenEncounterList);
			pstmt1.setString(1, reqPatientId ) ;
			rs1						= pstmt1.executeQuery();
			while(rs1!=null && rs1.next()){
				openEncounterIds	=  openEncounterIds + rs1.getString("ENCOUNTER_ID")==null?"":rs1.getString("ENCOUNTER_ID")+",";
			}
			if(!openEncounterIds.equals("")){
				openEncounterIds	= openEncounterIds.substring(0, openEncounterIds.length()-1);
			}
			if(rs1!=null)rs1.close();
			if(pstmt1!=null)pstmt1.close();
			if(!openEncounterIds.equals("")){
			
				sql						= " SELECT ENCOUNTER_ID,PATIENT_ID,STATUS,ACKNOWLEDG_NO_FORM60 FROM mp_form60  WHERE patient_id = ? and ENCOUNTER_ID in ("+openEncounterIds+") and status!='C' ";
				pstmt					= con.prepareStatement(sql);
				
				pstmt.setString(1, reqPatientId ) ;
				rs						= pstmt.executeQuery();
				while(rs!=null && rs.next()){
					patientId		= rs.getString("PATIENT_ID")==null?"":rs.getString("PATIENT_ID");
					encounterId		= rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID");
					status			= rs.getString("STATUS")==null?"":rs.getString("STATUS");
					ackNo			= rs.getString("ACKNOWLEDG_NO_FORM60")==null?"":rs.getString("ACKNOWLEDG_NO_FORM60");
					returnValue		= returnValue+patientId+"~"+encounterId+"~"+status+"~"+ackNo+"|";
					form60Count++;

				}
				if(form60Count > 0){
					returnValue	= returnValue+"##"+form60Count;
				}
			}			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(rs1!=null)rs1.close();
				if(pstmt1!=null)pstmt1.close();
			}catch(Exception ex){
				System.err.println("Exception in getForm60StatusForPatient method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return returnValue;
	}


	public static JSONObject getForm60Details(Connection con,String reqPatientId,String reqEncounterId,String status,String locale) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		JSONObject json				= new JSONObject();
		JSONArray jsonArray			= new JSONArray();
		int i						= 1;
		
		String sql					= "";

		String firstName	= "";                                           
		String middleName	= "";                                            
		String surname	= "";                                         
		String dobInsOfDec	= "";                                             
		String fatherFirstName	= "";                                                 
		String fatherMiddleName	= "";                                                  
		String fatherSurname	= "";                                               
		String flatRoomNo	= "";                                            
		String floorNo	= "";                                         
		String nameOfPremises	= "";              
		String blockNameNo	= "";              
		String roadStreetLane	= "";              
		String areaLocality	= "";              
		String townCity	= "";                      
		String district	= "";                                      
		String state	= "";                                   
		String country	= "";                                     
		String pinCode	= "";                                     
		String telephoneNo	= "";                                         
		String mobileNo	= "";                                      
		String amountOfTransaction	= "";                                                 
		String dateOfTransaction	= "";                                                 
		String noOfPersonsInvolved	= "";                                                 
		String trans_mode_cash_yn	= "";                                                    
		String trans_mode_cheque_yn	= "";                                                      
		String trans_mode_card_yn	= "";                                                    
		String trans_mode_dbs_yn	= "";                                                   
		String trans_mode_online_transfer_yn	= "";                                                      
		String trans_mode_other_yn	= "";                                                     
		String AdharNoIssuedByUIDAI	= "";                                                  
		String isAppliedForPan	= "";                                             
		String PANAcknowledgement	= "";                                                
		String PANDateOfApplication	= "";                                                  
		String estAgriIncome	= "";                                           
		String estNonAgriIncome	= "";                                              
		String idProofDocCode	= "";                                            
		String idProofDocIdNo	= "";                                            
		String idProofNameAddOfAuthority	= "";                                                       
		String addProofDocCode	= "";                                             
		String addProofDocIdNo	= "";                                             
		String addProofNameAddOfAuthority	= ""; 
		String encounterId					= "";
		String ACKNOWLEDG_NO_FORM60			= "";
		String patientID	= "";
	
		try{
			if(!status.equals("")){

				sql = " select FACILITY_ID,ENCOUNTER_ID,PATIENT_ID,ACKNOWLEDG_NO_FORM60,FIRST_NAME,SECOND_NAME,THIRD_NAME FAMILY_NAME,to_char(date_of_birth, 'dd/mm/yyyy') DATE_OF_BIRTH,FATHER_FIRST_NAME,FATHER_SECOND_NAME,FATHER_THIRD_NAME,ADDR_FLAT_NO,ADDR_FLOOR_NO,ADDR_NAME_PREMISES,ADDR_BLOCK_NAME,ADDR_LANE,ADDR_LOCALITY,RES_TOWN_DESC,RES_DISTRICT_DESC,STATE_DESC,COUNTRY_DESC,POSTAL_CODE POSTAL_CODE_DESC,CONTACT_TEL_NO,CONTACT_MOB_NO,TRANS_AMT,to_char(DATE_OF_TRANS, 'dd/mm/yyyy') DATE_OF_TRANS,TRANS_NO_PERSONS,AADHAR_NO,ACKNOWLEDGE_NO_PAN,to_char(DATE_OF_APP_PAN, 'dd/mm/yyyy') DATE_OF_APP_PAN,AGRICULTURAL_INCOME,AGRICULTURAL_NON_INCOME,ADDED_AT_WS_NO,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,STATUS,PAN_APPLIED_YN,TRANS_MODE_CASH_YN,TRANS_MODE_CHEQUE_YN,TRANS_MODE_CARD_YN,TRANS_MODE_DBS_YN,TRANS_MODE_ONLINETRANS_YN,TRANS_MODE_OTHER_YN,ID_PROOF_DOC_CODE,ID_PROOF_DOC_ID_NO,ID_PROOF_ADDR_AUTH,ADDR_PROOF_DOC_CODE,ADDR_PROOF_DOC_ID_NO,ADDR_PROOF_ADDR_AUTH from MP_FORM60 where encounter_id=? and PATIENT_ID = ? and status!='C'";
				pstmt					= con.prepareStatement(sql);
				pstmt.setString( i++, reqEncounterId ) ;
				pstmt.setString( i++, reqPatientId ) ;
				
			}else{
				sql	= " SELECT mp_pat.patient_id,mp_pat.FIRST_NAME FIRST_NAME,mp_pat.SECOND_NAME SECOND_NAME,mp_pat.FAMILY_NAME FAMILY_NAME,to_char(mp_pat.date_of_birth, 'dd/mm/yyyy') DATE_OF_BIRTH,mp_pat_add.ADDR1_LINE1 ADDR_FLAT_NO,mp_pat_add.ADDR1_LINE2 ADDR_FLOOR_NO ,mp_pat_add.ADDR1_LINE3 ADDR_NAME_PREMISES,mp_pat_add.ADDR1_LINE4 ADDR_BLOCK_NAME,mp_pat.res_town_code res_town_code, (CASE WHEN mp_pat.res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(mp_pat.res_town_code,'"+locale+"',2)) END ) RES_TOWN_DESC,mp_pat.res_area_code res_area_code, (CASE WHEN mp_pat.res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(mp_pat.res_area_code,'"+locale+"',2)) END ) RES_DISTRICT_DESC, mp_pat.region_code region_code,  (CASE WHEN mp_pat.region_code IS NOT NULL THEN (mp_get_desc.mp_region(mp_pat.region_code,'"+locale+"',2)) END ) STATE_DESC, mp_pat.nationality_code nationality_code, (CASE WHEN mp_pat.nationality_code IS NOT NULL THEN (mp_get_desc.mp_country(mp_pat.nationality_code,'"+locale+"',3)) END ) COUNTRY_DESC,mp_pat_add.postal1_code POSTAL_CODE,mp_get_desc.MP_POSTAL_CODE(mp_pat_add.postal1_code,'"+locale+"',1) POSTAL_CODE_DESC, mp_pat.contact3_no CONTACT_TEL_NO,mp_pat.CONTACT1_NO CONTACT_MOB_NO  FROM mp_patient mp_pat, mp_pat_addresses mp_pat_add WHERE mp_pat.patient_id = ? and mp_pat.patient_id=mp_pat_add.patient_id";
				pstmt					= con.prepareStatement(sql);
				pstmt.setString( i++, reqPatientId ) ;
			}
				

			rs						= pstmt.executeQuery();
			
			if(rs!=null && rs.next()){

				firstName								= rs.getString("FIRST_NAME")==null?"":rs.getString("FIRST_NAME");
				middleName								= rs.getString("SECOND_NAME")==null?"":rs.getString("SECOND_NAME");
				surname									= rs.getString("FAMILY_NAME")==null?"":rs.getString("FAMILY_NAME");
				dobInsOfDec								= rs.getString("DATE_OF_BIRTH")==null?"":rs.getString("DATE_OF_BIRTH");
				flatRoomNo								= rs.getString("ADDR_FLAT_NO")==null?"":rs.getString("ADDR_FLAT_NO");
				floorNo									= rs.getString("ADDR_FLOOR_NO")==null?"":rs.getString("ADDR_FLOOR_NO");
				nameOfPremises							= rs.getString("ADDR_NAME_PREMISES")==null?"":rs.getString("ADDR_NAME_PREMISES");
				blockNameNo								= rs.getString("ADDR_BLOCK_NAME")==null?"":rs.getString("ADDR_BLOCK_NAME");
				townCity								= rs.getString("RES_TOWN_DESC")==null?"":rs.getString("RES_TOWN_DESC");
				district								= rs.getString("RES_DISTRICT_DESC")==null?"":rs.getString("RES_DISTRICT_DESC");
				state									= rs.getString("STATE_DESC")==null?"":rs.getString("STATE_DESC");
				country									= rs.getString("COUNTRY_DESC")==null?"":rs.getString("COUNTRY_DESC");
				pinCode									= rs.getString("POSTAL_CODE_DESC")==null?"":rs.getString("POSTAL_CODE_DESC");
				telephoneNo								= rs.getString("CONTACT_TEL_NO")==null?"":rs.getString("CONTACT_TEL_NO");
				mobileNo								= rs.getString("CONTACT_MOB_NO")==null?"":rs.getString("CONTACT_MOB_NO");
				patientID								= rs.getString("patient_id")==null?"":rs.getString("patient_id");


				if(!status.equals("")){
					fatherFirstName						= rs.getString("FATHER_FIRST_NAME")==null?"":rs.getString("FATHER_FIRST_NAME");                                                 
					fatherMiddleName					= rs.getString("FATHER_SECOND_NAME")==null?"":rs.getString("FATHER_SECOND_NAME");                                                   
					fatherSurname						= rs.getString("FATHER_THIRD_NAME")==null?"":rs.getString("FATHER_THIRD_NAME");                                               
					roadStreetLane						= rs.getString("ADDR_LANE")==null?"":rs.getString("ADDR_LANE");               
					areaLocality						= rs.getString("ADDR_LOCALITY")==null?"":rs.getString("ADDR_LOCALITY");              
					amountOfTransaction					= rs.getString("TRANS_AMT")==null?"":rs.getString("TRANS_AMT");                                                  
					dateOfTransaction					= rs.getString("DATE_OF_TRANS")==null?"":rs.getString("DATE_OF_TRANS");                                                  
					noOfPersonsInvolved					= rs.getString("TRANS_NO_PERSONS")==null?"":rs.getString("TRANS_NO_PERSONS");                                                 
					trans_mode_cash_yn					= rs.getString("TRANS_MODE_CASH_YN")==null?"":rs.getString("TRANS_MODE_CASH_YN");                                                    
					trans_mode_cheque_yn				= rs.getString("TRANS_MODE_CHEQUE_YN")==null?"":rs.getString("TRANS_MODE_CHEQUE_YN");                                            
					trans_mode_card_yn					= rs.getString("trans_mode_card_yn")==null?"":rs.getString("trans_mode_card_yn");                                                  
					trans_mode_dbs_yn					= rs.getString("trans_mode_dbs_yn")==null?"":rs.getString("trans_mode_dbs_yn");                                                   
					trans_mode_online_transfer_yn		= rs.getString("TRANS_MODE_ONLINETRANS_YN")==null?"":rs.getString("TRANS_MODE_ONLINETRANS_YN");
					trans_mode_other_yn					= rs.getString("trans_mode_other_yn")==null?"":rs.getString("trans_mode_other_yn");
					AdharNoIssuedByUIDAI				= rs.getString("AADHAR_NO")==null?"":rs.getString("AADHAR_NO");                                                  
					isAppliedForPan						= rs.getString("PAN_APPLIED_YN")==null?"":rs.getString("PAN_APPLIED_YN");                                             
					PANAcknowledgement					= rs.getString("ACKNOWLEDGE_NO_PAN")==null?"":rs.getString("ACKNOWLEDGE_NO_PAN");                                                
					PANDateOfApplication				= rs.getString("DATE_OF_APP_PAN")==null?"":rs.getString("DATE_OF_APP_PAN");                                                 
					estAgriIncome						= rs.getString("AGRICULTURAL_INCOME")==null?"":rs.getString("AGRICULTURAL_INCOME");			                                        
					estNonAgriIncome					= rs.getString("AGRICULTURAL_NON_INCOME")==null?"":rs.getString("AGRICULTURAL_NON_INCOME");                                              
					idProofDocCode						= rs.getString("ID_PROOF_DOC_CODE")==null?"":rs.getString("ID_PROOF_DOC_CODE");                                            
					idProofDocIdNo						= rs.getString("ID_PROOF_DOC_ID_NO")==null?"":rs.getString("ID_PROOF_DOC_ID_NO");                                            
					idProofNameAddOfAuthority			= rs.getString("ID_PROOF_ADDR_AUTH")==null?"":rs.getString("ID_PROOF_ADDR_AUTH");                                                       
					addProofDocCode						= rs.getString("ADDR_PROOF_DOC_CODE")==null?"":rs.getString("ADDR_PROOF_DOC_CODE");                                             
					addProofDocIdNo						= rs.getString("ADDR_PROOF_DOC_ID_NO")==null?"":rs.getString("ADDR_PROOF_DOC_ID_NO");                                            
					addProofNameAddOfAuthority			= rs.getString("ADDR_PROOF_ADDR_AUTH")==null?"":rs.getString("ADDR_PROOF_ADDR_AUTH"); 
					encounterId							= rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID"); 
					ACKNOWLEDG_NO_FORM60				= rs.getString("ACKNOWLEDG_NO_FORM60")==null?"":rs.getString("ACKNOWLEDG_NO_FORM60"); 
				}

				JSONObject jsonObj		= new JSONObject();		
				jsonObj.put("firstName",firstName);
				jsonObj.put("middleName",middleName);
				jsonObj.put("surname",surname);
				jsonObj.put("dobInsOfDec",dobInsOfDec);
				jsonObj.put("flatRoomNo",flatRoomNo);
				jsonObj.put("floorNo",floorNo);
				jsonObj.put("nameOfPremises",nameOfPremises);
				jsonObj.put("blockNameNo",blockNameNo);
				jsonObj.put("townCity",townCity);
				jsonObj.put("district",district);
				jsonObj.put("state",state);
				jsonObj.put("country",country);
				jsonObj.put("pinCode",pinCode);
				jsonObj.put("telephoneNo",telephoneNo);
				jsonObj.put("mobileNo",mobileNo);
				jsonObj.put("patientID",patientID);



				jsonObj.put("fatherFirstName",fatherFirstName);
				jsonObj.put("fatherMiddleName",fatherMiddleName);
				jsonObj.put("fatherSurname",fatherSurname);
				jsonObj.put("roadStreetLane",roadStreetLane);
				jsonObj.put("areaLocality",areaLocality);
				jsonObj.put("amountOfTransaction",amountOfTransaction);
				jsonObj.put("dateOfTransaction",dateOfTransaction);
				jsonObj.put("noOfPersonsInvolved",noOfPersonsInvolved);
				jsonObj.put("trans_mode_cash_yn",trans_mode_cash_yn);
				jsonObj.put("trans_mode_cheque_yn",trans_mode_cheque_yn);
				jsonObj.put("trans_mode_card_yn",trans_mode_card_yn);
				jsonObj.put("trans_mode_dbs_yn",trans_mode_dbs_yn);
				jsonObj.put("trans_mode_online_transfer_yn",trans_mode_online_transfer_yn);
				jsonObj.put("trans_mode_other_yn",trans_mode_other_yn);
				jsonObj.put("AdharNoIssuedByUIDAI",AdharNoIssuedByUIDAI);
				jsonObj.put("isAppliedForPan",isAppliedForPan);
				jsonObj.put("PANAcknowledgement",PANAcknowledgement);
				jsonObj.put("PANDateOfApplication",PANDateOfApplication);
				jsonObj.put("estAgriIncome",estAgriIncome);
				jsonObj.put("estNonAgriIncome",estNonAgriIncome);
				jsonObj.put("idProofDocCode",idProofDocCode);
				jsonObj.put("idProofDocIdNo",idProofDocIdNo);
				jsonObj.put("idProofNameAddOfAuthority",idProofNameAddOfAuthority);
				jsonObj.put("addProofDocCode",addProofDocCode);
				jsonObj.put("addProofDocIdNo",addProofDocIdNo);
				jsonObj.put("addProofNameAddOfAuthority",addProofNameAddOfAuthority);

				jsonObj.put("encounterId",encounterId);
				jsonObj.put("ACKNOWLEDG_NO_FORM60",ACKNOWLEDG_NO_FORM60);




				jsonArray.add(jsonObj);
			}
			json.put("form60Details",jsonArray);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getForm60Details method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return json;
	}
	public static JSONObject getIdAddressProofDtls(Connection con,String type) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		JSONObject json				= new JSONObject();
		String sql					= "";
		JSONArray jsonArray			= new JSONArray();

		try{
			
			sql						= " select DOC_TYPE, SUPP_DOC_DESC from mp_document_type where EFF_STATUS = 'E'";
			if(type.equals("I")) {
				sql	= sql + " and IDENTITY_PROOF_YN = 'Y'";
			}else if(type.equals("A")) {
				sql	= sql + " and ADDRESS_PROOF_YN = 'Y'";
			}
			pstmt					= con.prepareStatement(sql);
			rs						= pstmt.executeQuery();
			
			while(rs!=null && rs.next()){
				String docType			= rs.getString("DOC_TYPE")==null?"":rs.getString("DOC_TYPE");
				String shortDesc		= rs.getString("SUPP_DOC_DESC")==null?"":rs.getString("SUPP_DOC_DESC");
				JSONObject jsonObj			= new JSONObject();		
				jsonObj.put("docType",docType);
				jsonObj.put("shortDesc",shortDesc);
				jsonArray.add(jsonObj);
			}
			json.put("results",jsonArray);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getIdAddressProofDtls method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return json;
	}


	public static String getIsBillGenerated(Connection con,String facilityId,String episodeId,String episodeType,String opEpisodeVisitNum) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		String sql					= "";
		//int i						= 1;
		String isBillGenerated		= "";
		try{
			sql						= " select blcommon.is_bill_gen_yn ( '"+facilityId+"',  '"+episodeType+"', '"+episodeId+"',  '"+opEpisodeVisitNum+"') bill_generated_yn from dual";
			pstmt					= con.prepareStatement(sql);

		
			rs						= pstmt.executeQuery();
			if(rs!=null && rs.next()){
				isBillGenerated			= rs.getString("bill_generated_yn")==null?"":rs.getString("bill_generated_yn");
				
			}

		

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getIsBillGenerated method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return isBillGenerated;
	}


	public static JSONObject getBlTransDtls(Connection con,String facilityId,String patientId,String episodeId,String episodeType,String opEpisodeVisitNum) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		JSONObject json				= new JSONObject();
		String sql					= "";
		JSONArray jsonArray			= new JSONArray();

		try{

			//sql						= " SELECT TO_CHAR(MIN(TRUNC(b.doc_date)),'DD/MM/YYYY') transaction_date,NVL(SUM (ROUND(b.bill_tot_amt,2)),0) transaction_amount, SUM (b.bill_tot_amt) transaction_amount, bl_func_get_transaction_mode ('"+facilityId+"','"+patientId+"','"+episodeType+"','"+episodeId+"','"+opEpisodeVisitNum+"') transaction_mode FROM mp_form60 f, bl_bill_hdr b WHERE b.operating_facility_id = '"+facilityId+"' AND NVL (b.bill_status, '~') <> 'C' AND f.patient_id = b.patient_id AND NVL (f.status, 'X') in ('D','F') AND b.episode_type != 'R' AND b.patient_id = '"+patientId+"' AND b.episode_id = '"+episodeId+"' ";
			sql						= " SELECT TO_CHAR(MIN(TRUNC(b.doc_date)),'DD/MM/YYYY') transaction_date,SUM (ROUND (b.bill_amt, 2)) transaction_amount, bl_func_get_transaction_mode ('"+facilityId+"','"+patientId+"','"+episodeType+"','"+episodeId+"','"+opEpisodeVisitNum+"') transaction_mode FROM mp_form60 f, bl_bill_hdr b WHERE b.operating_facility_id = '"+facilityId+"' AND NVL (b.bill_status, '~') <> 'C' AND f.patient_id = b.patient_id AND NVL (f.status, 'X') in ('D','F') AND b.episode_type != 'R' AND b.patient_id = '"+patientId+"' AND b.episode_id = '"+episodeId+"'  AND (   (b.episode_type IN ('O', 'E') AND b.visit_id = '"+opEpisodeVisitNum+"') OR (b.episode_type NOT IN ('O', 'E'))) AND (   (b.episode_type IN ('I', 'D') AND b.episode_id = f.encounter_id) OR ( b.episode_type IN ('O', 'E') AND b.episode_id || LTRIM (LPAD (b.visit_id, 4, '0')) = f.encounter_id ))";

			pstmt					= con.prepareStatement(sql);
			rs						= pstmt.executeQuery();
			
			while(rs!=null && rs.next()){
				String transaction_date			= rs.getString("transaction_date")==null?"":rs.getString("transaction_date");
				String transaction_amount		= rs.getString("transaction_amount")==null?"":rs.getString("transaction_amount");
				String transaction_mode			= rs.getString("transaction_mode")==null?"":rs.getString("transaction_mode");
				JSONObject jsonObj				= new JSONObject();		
				jsonObj.put("transaction_date",transaction_date);
				jsonObj.put("transaction_amount",transaction_amount);
				jsonObj.put("transaction_mode",transaction_mode);
				jsonArray.add(jsonObj);
			}
			json.put("blTransDtls",jsonArray);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getBlTransDtls method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return json;
	}
}