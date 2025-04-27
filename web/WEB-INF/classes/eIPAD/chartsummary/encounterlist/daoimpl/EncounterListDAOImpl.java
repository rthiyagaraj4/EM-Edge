/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law. Changes for check in
 ******************************************************************************/
/**
 *  
 */
package eIPAD.chartsummary.encounterlist.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import eIPAD.chartsummary.encounterlist.dao.EncounterListDAO;
import eIPAD.chartsummary.encounterlist.healthobject.EncounterHO;
import eIPAD.chartsummary.encounterlist.request.EncounterListRequest;
import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;
import eIPAD.chartsummary.common.daoimpl.GenericDAOImpl;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;

/**
 * @author SaraswathiR 
 *
 */
public class EncounterListDAOImpl extends GenericDAOImpl implements EncounterListDAO {

	public EncounterListResponse getEncounterDetailsById(String encounterId, String facilityId){
		String locale = "en";
		EncounterListResponse response = new EncounterListResponse();
		StringBuffer encounterListQuery = new StringBuffer("");
		ArrayList<EncounterHO> EncounterArrayList = new ArrayList<EncounterHO>();
		ErrorInfo errorInfo;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			encounterListQuery.append(" Select  to_char(a.visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(a.visit_adm_date_time+7,sysdate), 'dd/mm/yyyy') to_date,  a.ASSIGN_CARE_LOCN_TYPE,a.ASSIGN_CARE_LOCN_CODE, a.ATTEND_PRACTITIONER_ID, a.assign_room_num room_num, a.assign_bed_num bed_num, a.specialty_code SPECIALTY_CODE, SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,'"+locale+"','1') facility_desc, AM_GET_DESC.AM_SERVICE(a.service_code,'"+locale+"','2') service_desc,  DECODE (a.assign_care_locn_type,'N',  (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = '"+locale+"'),  (SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = '"+locale+"')) care_location_desc,  (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN  (SELECT short_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = '"+locale+"') END) pract_short_name,  (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN  (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = '"+locale+"') END) pract_full_name,   a.PATIENT_CLASS patient_class, a.encounter_id, a.facility_id, a.SPECIALTY_CODE from pr_encounter a  where a.ENCOUNTER_ID ='" + encounterId + "' and a.FACILITY_ID ='" + facilityId + "' order by a.visit_adm_date_time desc ");
			con = createConnection();
			if(con == null){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			else{
				pstmt=con.prepareStatement(encounterListQuery.toString());
				rs = pstmt.executeQuery();
				if(rs == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					String visitDate;
					String fromDate;
					String toDate;
					String assignCareLocnType;
					String assignCareLocnCode;
					String attendPractitionerId;
					String facilityDesc;
					String serviceDesc;
					String careLocationDesc;
					String practFullName;
					String practShortName;
					//String facilityId;
					String patientClass;
					//String encounterId;
					String relationshipId;
					String specialtyCode;
					String roomNum;
					String bedNum;
					
					while(rs.next())
					{					
						
						visitDate = rs.getString("visit_date")==null?"":rs.getString("visit_date");
						fromDate = rs.getString("from_date")==null?"":rs.getString("from_date");
						toDate = rs.getString("to_date")==null?"":rs.getString("to_date");
						assignCareLocnType = rs.getString("ASSIGN_CARE_LOCN_TYPE")==null?"":rs.getString("ASSIGN_CARE_LOCN_TYPE");
						assignCareLocnCode = rs.getString("ASSIGN_CARE_LOCN_CODE")==null?"":rs.getString("ASSIGN_CARE_LOCN_CODE");
						attendPractitionerId = rs.getString("ATTEND_PRACTITIONER_ID")==null?"":rs.getString("ATTEND_PRACTITIONER_ID");
						facilityDesc = rs.getString("facility_desc")==null?"":rs.getString("facility_desc");
						serviceDesc = rs.getString("service_desc")==null?"":rs.getString("service_desc");
						careLocationDesc = rs.getString("care_location_desc")==null?"":rs.getString("care_location_desc");
						practFullName = rs.getString("pract_full_name")==null?"":rs.getString("pract_full_name");
						practShortName = rs.getString("pract_short_name")==null?"":rs.getString("pract_short_name");
						facilityId = rs.getString("facility_id")==null?"":rs.getString("facility_id");
						patientClass = rs.getString("patient_class")==null?"":rs.getString("patient_class");
						encounterId = rs.getString("encounter_id")==null?"":rs.getString("encounter_id");
						specialtyCode =  rs.getString("SPECIALTY_CODE")==null?"":rs.getString("SPECIALTY_CODE");
						roomNum = rs.getString("room_num")==null?"":rs.getString("room_num");
						bedNum = rs.getString("bed_num")==null?"":rs.getString("bed_num");
						
						
						EncounterHO encounterHO = new EncounterHO();
						
						encounterHO.setVisitDate(visitDate);
						encounterHO.setFromDate(fromDate);
						encounterHO.setToDate(toDate);
						encounterHO.setAssignCareLocnType(assignCareLocnType);
						encounterHO.setAssignCareLocnCode(assignCareLocnCode);
						encounterHO.setAttendPractitionerId(attendPractitionerId);
						encounterHO.setFacilityDesc(facilityDesc);
						encounterHO.setServiceDesc(serviceDesc);
						encounterHO.setCareLocationDesc(careLocationDesc);
						encounterHO.setPractFullName(practFullName);
						encounterHO.setPractShortName(practShortName);
						encounterHO.setFacilityId(facilityId);
						encounterHO.setPatientClass(patientClass);
						encounterHO.setEncounterId(encounterId);
						//encounterHO.setRelationshipId(relationshipId);
						encounterHO.setSpecialtyCode(specialtyCode);
						encounterHO.setRoomNum(roomNum);
						encounterHO.setBedNum(bedNum);
						
						EncounterArrayList.add(encounterHO);
						
					}
					
					if(EncounterArrayList.size() <= 0){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.ENCOUNTERLIST_EMPTY_DATA,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						response.setEncounterList(EncounterArrayList);
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
						response.getErrorsList().add(errorInfo);
					}
				}
			}
		
		}
		catch(SQLException e){
			System.out.println("A database exception occurred while fetching patient encounters" +e);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
			response.getErrorsList().add(errorInfo);
		}
		catch(Exception e){
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
			response.getErrorsList().add(errorInfo);
		}
		finally{
			int conCloseFailure = closeConnection(con,pstmt,rs);
		}
		return response;
	}
	
	/* (non-Javadoc)
	 * @see eIPAD.chartsummary.encounterlist.dao.EncounterListDAO#getInPatientEncounterList(eIPAD.chartsummary.encounterlist.request.EncounterListRequest)
	 * query taken from eCA ChartSummaryEncounterList.jsp and part of query for retrieving relationship_id was taken from CAMain.jsp
	 */
	public EncounterListResponse getEncounterList(EncounterListRequest request) {
		EncounterListResponse response = new EncounterListResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		
		if(request != null){
			PatContext rPatContext = request.getPatientContext();
			
			if(rPatContext != null){
				locale = (rPatContext.getLocale() == null || rPatContext.getLocale() == "") ? "en": rPatContext.getLocale();
				String patientId = rPatContext.getPatientId();
				//String patientClass = rPatContext.getPatientClass();
				StringBuffer encounterListQuery = new StringBuffer("");
				ArrayList<EncounterHO> EncounterArrayList = new ArrayList<EncounterHO>();
				
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try{
					/*encounterListQuery.append("Select to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date, ");
					encounterListQuery.append(" rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,'" + locale + "','1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,'" + locale + "','2')||', '||DECODE (a.assign_care_locn_type,'N', ");
					encounterListQuery.append(" (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = '" + locale + "'),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code ");
					encounterListQuery.append(" AND facility_id = a.facility_id and language_id = '" + locale + "'))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = '" + locale + "') END),','),',')Details, ");
					encounterListQuery.append(" decode(PATIENT_CLASS,'OP','OP','EM','OP','IP') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1, ");
					encounterListQuery.append(" (select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,'" + locale + "','1') from dual) Encounter_dtls2,a.facility_id,'A' link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from ");
					encounterListQuery.append(" (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= '" + patientId + "' ) where RANK_NO <16)  and a.patient_class = '" + patientClass + "' order by visit_adm_date_time desc");*/
					
					/*encounterListQuery.append("Select to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy') to_date, ");
					encounterListQuery.append(" ASSIGN_CARE_LOCN_TYPE, ASSIGN_CARE_LOCN_CODE, ATTEND_PRACTITIONER_ID, SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,'"+locale+"','1') facility_desc, AM_GET_DESC.AM_SERVICE(a.service_code,'"+locale+"','2') service_desc,");
					encounterListQuery.append(" DECODE (a.assign_care_locn_type,'N',  (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = '"+locale+"'), ");
					encounterListQuery.append(" (SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = '"+locale+"')) care_location_desc, ");
					encounterListQuery.append(" (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN  (SELECT short_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = '"+locale+"') END) pract_short_name, ");
					encounterListQuery.append(" (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN  (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = '"+locale+"') END) pract_full_name, ");
					encounterListQuery.append(" PATIENT_CLASS patient_class, encounter_id, a.facility_id from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID ");
					encounterListQuery.append(" from  (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= '"+patientId+"' ) where RANK_NO <16) ");*/
					
					encounterListQuery.append(" Select  to_char(a.visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(a.visit_adm_date_time+7,sysdate), 'dd/mm/yyyy') to_date, ");
					encounterListQuery.append(" a.ASSIGN_CARE_LOCN_TYPE,a.ASSIGN_CARE_LOCN_CODE, a.ATTEND_PRACTITIONER_ID, SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,'"+locale+"','1') facility_desc, AM_GET_DESC.AM_SERVICE(a.service_code,'"+locale+"','2') service_desc, ");
					encounterListQuery.append(" DECODE (a.assign_care_locn_type,'N',  (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = '"+locale+"'), ");
					encounterListQuery.append(" (SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = '"+locale+"')) care_location_desc, ");
					encounterListQuery.append(" (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN  (SELECT short_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = '"+locale+"') END) pract_short_name, ");
					encounterListQuery.append(" (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN  (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = '"+locale+"') END) pract_full_name, ");
					encounterListQuery.append("  a.PATIENT_CLASS patient_class, a.encounter_id, a.facility_id, a.SPECIALTY_CODE, (select PRACT_RELN_ID from CA_ENCNTR_PRACT_RELN where facility_id=a.facility_id and NVL(ENCOUNTER_ID,0) = NVL(a.ENCOUNTER_ID,0) ");
					encounterListQuery.append("  and practitioner_id = a.ATTEND_PRACTITIONER_ID and patient_id=a.patient_id AND NVL(STATUS,'01')='01' AND nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) BETWEEN SYSDATE AND  nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) AND BEGIN_DATE_TIME<SYSDATE and rownum = 1)");
					encounterListQuery.append("  PRACT_RELN_ID from pr_encounter a  where (a.facility_id,a.encounter_id) in  (select FACILITY_ID,ENCOUNTER_ID ");
					encounterListQuery.append(" from  (select FACILITY_ID, ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= '"+patientId+"' AND (visit_status != '99' or visit_status is null) AND (ADT_STATUS != '09' or ADT_STATUS is null) ) where RANK_NO <16)");
					
				
							
							
					
					/*if(request.getFilterPatientClass() != null && !request.getFilterPatientClass().trim().equals(""))
						encounterListQuery.append(" and a.patient_class ='" + request.getFilterPatientClass() + "'");*/
					
					if(request.getFilterEncounterId() != null && !request.getFilterEncounterId().trim().equals(""))
						encounterListQuery.append(" and a.ENCOUNTER_ID ='" + request.getFilterEncounterId() + "'");
					
					if(request.getFilterFacilityId() != null && !request.getFilterFacilityId().trim().equals(""))
						encounterListQuery.append(" and a.FACILITY_ID ='" + request.getFilterFacilityId() + "'");
					
					encounterListQuery.append(" order by a.visit_adm_date_time desc");
					
					
					
					con = createConnection();
					if(con == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						pstmt=con.prepareStatement(encounterListQuery.toString());
						rs = pstmt.executeQuery();
						if(rs == null){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							String visitDate;
							String fromDate;
							String toDate;
							String assignCareLocnType;
							String assignCareLocnCode;
							String attendPractitionerId;
							String facilityDesc;
							String serviceDesc;
							String careLocationDesc;
							String practFullName;
							String practShortName;
							String facilityId;
							String patientClass;
							String encounterId;
							String relationshipId;
							String specialtyCode;
							
							while(rs.next())
							{					
								
								visitDate = rs.getString("visit_date")==null?"":rs.getString("visit_date");
								fromDate = rs.getString("from_date")==null?"":rs.getString("from_date");
								toDate = rs.getString("to_date")==null?"":rs.getString("to_date");
								assignCareLocnType = rs.getString("ASSIGN_CARE_LOCN_TYPE")==null?"":rs.getString("ASSIGN_CARE_LOCN_TYPE");
								assignCareLocnCode = rs.getString("ASSIGN_CARE_LOCN_CODE")==null?"":rs.getString("ASSIGN_CARE_LOCN_CODE");
								attendPractitionerId = rs.getString("ATTEND_PRACTITIONER_ID")==null?"":rs.getString("ATTEND_PRACTITIONER_ID");
								facilityDesc = rs.getString("facility_desc")==null?"":rs.getString("facility_desc");
								serviceDesc = rs.getString("service_desc")==null?"":rs.getString("service_desc");
								careLocationDesc = rs.getString("care_location_desc")==null?"":rs.getString("care_location_desc");
								practFullName = rs.getString("pract_full_name")==null?"":rs.getString("pract_full_name");
								practShortName = rs.getString("pract_short_name")==null?"":rs.getString("pract_short_name");
								facilityId = rs.getString("facility_id")==null?"":rs.getString("facility_id");
								patientClass = rs.getString("patient_class")==null?"":rs.getString("patient_class");
								encounterId = rs.getString("encounter_id")==null?"":rs.getString("encounter_id");
								relationshipId = rs.getString("PRACT_RELN_ID")==null?"":rs.getString("PRACT_RELN_ID");
								specialtyCode =  rs.getString("SPECIALTY_CODE")==null?"":rs.getString("SPECIALTY_CODE");
								
								
								EncounterHO encounterHO = new EncounterHO();
								
								encounterHO.setVisitDate(visitDate);
								encounterHO.setFromDate(fromDate);
								encounterHO.setToDate(toDate);
								encounterHO.setAssignCareLocnType(assignCareLocnType);
								encounterHO.setAssignCareLocnCode(assignCareLocnCode);
								encounterHO.setAttendPractitionerId(attendPractitionerId);
								encounterHO.setFacilityDesc(facilityDesc);
								encounterHO.setServiceDesc(serviceDesc);
								encounterHO.setCareLocationDesc(careLocationDesc);
								encounterHO.setPractFullName(practFullName);
								encounterHO.setPractShortName(practShortName);
								encounterHO.setFacilityId(facilityId);
								encounterHO.setPatientClass(patientClass);
								encounterHO.setEncounterId(encounterId);
								encounterHO.setRelationshipId(relationshipId);
								encounterHO.setSpecialtyCode(specialtyCode);
								
								EncounterArrayList.add(encounterHO);
								
							}
							
							if(EncounterArrayList.size() <= 0){
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.ENCOUNTERLIST_EMPTY_DATA,locale);
								response.getErrorsList().add(errorInfo);
							}
							else{
								response.setEncounterList(EncounterArrayList);
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
								response.getErrorsList().add(errorInfo);
							}
						}
					}
					
				}
				catch(SQLException e){
					System.out.println("A database exception occurred while fetching patient encounters" +e);
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				catch(Exception e){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				finally{
					int conCloseFailure = closeConnection(con,pstmt,rs);
				}
			}
			else{
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
				response.getErrorsList().add(errorInfo);
			}
		}
		else 
		{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		
		return response;
	}

}
