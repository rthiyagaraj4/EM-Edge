/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law. 
 ******************************************************************************/
/**
 * 
 */
package eIPAD.chartsummary.clinicalnotes.daoimpl;
import eDS.Common.JSONObject;
import eIPAD.InPatientDetails.bc.Inds;
import eIPAD.chartsummary.clinicalnotes.dao.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import  java.sql.Clob;


import webbeans.eCommon.ConnectionManager;

import eIPAD.chartsummary.common.healthobject.*;
import eIPAD.chartsummary.common.daoimpl.*;
import eIPAD.chartsummary.common.response.*;
import eIPAD.chartsummary.clinicalnotes.request.*;
import eIPAD.chartsummary.clinicalnotes.response.*;
import eIPAD.chartsummary.clinicalnotes.healthobject.*;
/**
 * @author GaneshkumarC
 *
 */
public class ClinicalNotesDAOImpl extends GenericDAOImpl implements ClinicalNotesDao{
	public ClinicalNotesResponse getNoteDetails(ClinicalNotesRequest oClnReq) {
		Connection connection 		= null;
		PreparedStatement pStmt				= null;
		ResultSet resultSet 		= null;
		String locale = "en";
		String strPatientId = "";
		String respId = "";
		String encounterId = "";
		String facilityId = "";
		String loggedInUser = "";
		String noteType = "";
		//String ApplTaskId = "CLINICAL_NOTES";
		String ClinicianId = "";
		StringBuffer sqlStr = new StringBuffer("");
		ClinicalNotesResponse oClnRes = new ClinicalNotesResponse();
		ErrorInfo oErrInfo = new ErrorInfo();
		List<NormalViewDetails> listNormalViewDetails = new ArrayList<NormalViewDetails>();
		if(oClnReq != null)
		{
			PatContext oPatContext = oClnReq.getPatientContext();
			if(oPatContext != null)
			{
				strPatientId = checkForNull(oPatContext.getPatientId());
				locale =  checkForNull(oPatContext.getLocale());
				respId = checkForNull(oPatContext.getResponsibilityID());
				encounterId = (oPatContext.getSelectedEncounterId() == null || oPatContext.getSelectedEncounterId().equals("")) ? oPatContext.getEncounterId() : oPatContext.getSelectedEncounterId();//checkForNull(oPatContext.getEncounterId());
				facilityId = checkForNull(oPatContext.getFacilityId());
				loggedInUser = checkForNull(oPatContext.getLoggedInUser());
				ClinicianId = checkForNull(oPatContext.getClinicianId());
				noteType = checkForNull(oClnReq.getNoteType());
				oErrInfo.setErrorType(Errors.COMMON_SUCCESS, locale);
				
				if("fullViewEncounter".equals(oClnReq.getViewPage())){
					encounterId = oClnReq.getEncounterID();
				}
				
				//Query taken from eCA ChartSummaryClinicalNotesD.jsp
				
				sqlStr.append(" SELECT  c.primary_speciality_code, a.event_class, a.facility_id, a.accession_num, a.note_type, a.service_code, a.performed_by_id,  b.note_type_desc,  b.note_group_id, event_title_desc, ");
				sqlStr.append("  a.event_date_time,  TO_CHAR (a.event_date_time, 'dd/mm/yyyy') event_date_time1,  TO_CHAR (a.event_date_time, 'hh24:mi') event_date_time2, ");
				sqlStr.append("  a.event_status status, a.encounter_id,  DECODE (a.event_class, 'PHY$', 'Physician Notes', 'CLI$', 'Clinician Notes', 'NUR$', 'Nursing Notes'  ) event_class_desc ");
				sqlStr.append(" FROM ca_encntr_note a, ca_note_type_lang_vw b, am_practitioner c ");
				sqlStr.append( " where ");
				sqlStr.append(" ca_get_appl_note_opern (a.facility_id,  a.accession_num, '" + respId + "', '" + ClinicianId + "', a.note_type, '" + loggedInUser + "', 'N'  ) IS NOT NULL ");
				sqlStr.append(" AND a.note_type = b.note_type  AND a.patient_id = '" + strPatientId + "' AND a.facility_id = '" + facilityId + "' ");
				/*if((oClnReq.getViewPage())== "fullViewEncounter"){*/
				sqlStr.append(" AND a.encounter_id IN ('" + encounterId + "')  ");
				/*}*/
				sqlStr.append(" AND b.language_id = '" + locale + "' ");
				sqlStr.append(" AND c.practitioner_id = a.performed_by_id ");
				/*sqlStr.append(" AND d.ACTION_TYPE IN ('SN','RV') ");*/
				//sqlStr.append(" AND a.event_status NOT IN ('9') ");
				sqlStr.append(" AND b.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID in ('CLINICAL_NOTES','DISCHARGE_SUMMARY')) ");
				if(oClnReq.getFilterBy() != null && !oClnReq.getFilterBy().equals(""))
				{
					//sqlStr.append(" AND a.event_class = '" + oClnReq.getFilterBy() + "' ");
					//sqlStr.append(" AND a.event_class in (" + oClnReq.getFilterBy() +")" );
					if(oClnReq.getFilterBy().indexOf(",") == -1)
					{
						sqlStr.append(" AND a.event_class = '" + oClnReq.getFilterBy() + "' ");
					}
					else
					{
						sqlStr.append(" AND a.event_class in ( " );
						StringTokenizer st = null;
						st = new StringTokenizer(oClnReq.getFilterBy(),",");
						int nTokenCount = 0;
						while (st.hasMoreTokens())
						{
							if(nTokenCount == 0)
							{
								sqlStr.append(" '" +st.nextElement() + "'");
							}
							else
							{
								sqlStr.append(" , '" +st.nextElement() + "'");
							}
							nTokenCount++;
							
						}
						sqlStr.append( " ) ");
						
					}
				}
				if(!noteType.equals(""))
				{
					sqlStr.append(" AND a.note_type = '" + noteType+ "'");
				}
				sqlStr.append(" ORDER BY event_date_time desc,a.note_type ");
				try
				{
					connection = createConnection();
					if(connection != null)
					{
						pStmt = connection.prepareStatement(sqlStr.toString());
						
					}
					if(pStmt != null){
						resultSet = pStmt.executeQuery();
					}
					if(resultSet != null)
					{
						while(resultSet.next())
						{
							NormalViewDetails oNorVwDtls = new NormalViewDetails();
							
							oNorVwDtls.setEventClass(checkForNull(resultSet.getString("event_class")));
							oNorVwDtls.setNoteType(checkForNull(resultSet.getString("note_type")));
							oNorVwDtls.setAccessionNum(checkForNull(resultSet.getString("accession_num")));
							oNorVwDtls.setNoteTypeDesc(checkForNull(resultSet.getString("note_type_desc")));
							oNorVwDtls.setEventDate(checkForNull(resultSet.getString("event_date_time1")));
							oNorVwDtls.setEventTime(checkForNull(resultSet.getString("event_date_time2")));
							oNorVwDtls.setStatus(checkForNull(resultSet.getString("status")));
							oNorVwDtls.setServiceCode(checkForNull(resultSet.getString("service_code")));
							oNorVwDtls.setPerformedBy(checkForNull(resultSet.getString("performed_by_id")));
							oNorVwDtls.setPrimarySpec(checkForNull(resultSet.getString("primary_speciality_code")));
							//oNorVwDtls.setActionType(checkForNull(resultSet.getString("ACTION_TYPE")));
							
							listNormalViewDetails.add(oNorVwDtls);
						}
						if(listNormalViewDetails.size() == 0)
						{
							oErrInfo.setErrorType(Errors.CLINICALNOTES_EMPTY_DATA, locale);
						}
						oClnRes.setListNormalViewDetails(listNormalViewDetails);
					}
				}
				catch(Exception e)
				{
			         e.printStackTrace();
					
					oErrInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION, locale);
				}
				finally
				{
					int conCloseFailure = closeConnection(connection,pStmt,resultSet);
					if(conCloseFailure > 0)
					{
						System.out.println("Connection not closed in the method eIPAD.chartsummary.clinicalnotes.daoimpl.ClinicalNotesDAOImpl.getNoteDetails");
					}
				}
			}
			else
			{
				oErrInfo.setErrorType(Errors.COMMON_NULL_REQUEST, locale);
			}
		}
		else
		{
			oErrInfo.setErrorType(Errors.COMMON_NULL_REQUEST, locale);
		}
		oClnRes.getErrorsList().add(oErrInfo);
		return oClnRes;
	}
	
	public ClinicalNotesResponse getNoteDetailsTimeRange(ClinicalNotesRequest oClnReq) {
		Connection connection 		= null;
		PreparedStatement pStmt				= null;
		ResultSet resultSet 		= null;
		String locale = "en";
		String strPatientId = "";
		String respId = "";
		//String encounterId = "";
		String facilityId = "";
		String loggedInUser = "";
		String noteType = "";
		//String ApplTaskId = "CLINICAL_NOTES";
		String ClinicianId = "";
		String finalStartDate ="";
		String finalEndDate = "";
		StringBuffer sqlStr = new StringBuffer("");
		ClinicalNotesResponse oClnRes = new ClinicalNotesResponse();
		ErrorInfo oErrInfo = new ErrorInfo();
		List<NormalViewDetailsTimeRange> listNormalViewDetailsTimeRange = new ArrayList<NormalViewDetailsTimeRange>();
		if(oClnReq != null)
		{
			finalStartDate = oClnReq.getFinalStartDate();
			finalEndDate = oClnReq.getFinalEndDate();
			PatContext oPatContext = oClnReq.getPatientContext();
			if(oPatContext != null)
			{
				strPatientId = checkForNull(oPatContext.getPatientId());
				locale =  checkForNull(oPatContext.getLocale());
				respId = checkForNull(oPatContext.getResponsibilityID());
				//encounterId = (oPatContext.getSelectedEncounterId() == null || oPatContext.getSelectedEncounterId().equals("")) ? oPatContext.getEncounterId() : oPatContext.getSelectedEncounterId();//checkForNull(oPatContext.getEncounterId());
				facilityId = checkForNull(oPatContext.getFacilityId());
				loggedInUser = checkForNull(oPatContext.getLoggedInUser());
				ClinicianId = checkForNull(oPatContext.getClinicianId());
				noteType = checkForNull(oClnReq.getNoteType());
				//finalStartDate = checkForNull(oPatContext.getFinalStartDate());
				//finalEndDate = checkForNull(oPatContext.getFinalEndDate());
				oErrInfo.setErrorType(Errors.COMMON_SUCCESS, locale);
				
				//Query taken from eCA ChartSummaryClinicalNotesD.jsp
				
				sqlStr.append(" SELECT primary_speciality_code, event_class, performed_by_id,facility_id, service_code,accession_num, note_type, note_type_desc, note_group_id, event_title_desc, event_date_time, ");
				sqlStr.append(" event_date_time1, event_date_time2, status, encounter_id ");
				sqlStr.append(" FROM ( SELECT  c.primary_speciality_code, a.event_class, a.facility_id, a.accession_num, a.note_type, a.service_code, a.performed_by_id,  b.note_type_desc,  b.note_group_id, event_title_desc, ");
				sqlStr.append(" a.event_date_time,  TO_CHAR (a.event_date_time, 'YYYY-MM-DD') event_date_time1,  TO_CHAR (a.event_date_time, 'hh24:mi') event_date_time2, ");
				sqlStr.append(" a.event_status status, a.encounter_id,  DECODE (a.event_class, 'PHY$', 'Physician Notes', 'CLI$', 'Clinician Notes', 'NUR$', 'Nursing Notes'  ) event_class_desc ");
				sqlStr.append(" FROM ca_encntr_note a, ca_note_type_lang_vw b, am_practitioner c ");
				sqlStr.append(" where ");
				sqlStr.append(" ca_get_appl_note_opern (a.facility_id,  a.accession_num, '" + respId + "', '" + ClinicianId + "', a.note_type, '" + loggedInUser + "', 'N'  ) IS NOT NULL ");
				sqlStr.append(" AND a.note_type = b.note_type  AND a.patient_id = '" + strPatientId + "' AND a.facility_id = '" + facilityId + "' ");
				sqlStr.append(" AND c.practitioner_id = a.performed_by_id ");
				/*sqlStr.append(" AND d.accession_num = a.accession_num ");*/
				/*sqlStr.append(" AND d.ACTION_TYPE IN ('SN','RV') ");*/
				/*sqlStr.append(" AND a.FACILITY_ID = d.FACILITY_ID AND a.event_status NOT IN ('9')");*/
				sqlStr.append(" AND b.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID in ('CLINICAL_NOTES','DISCHARGE_SUMMARY')) ");
				sqlStr.append(" AND b.language_id = '" + locale + "' ");

				
				if(oClnReq.getFilterBy() != null && !oClnReq.getFilterBy().equals(""))
				{
					//sqlStr.append(" AND a.event_class = '" + oClnReq.getFilterBy() + "' ");
					//sqlStr.append(" AND a.event_class in (" + oClnReq.getFilterBy() +")" );
					if(oClnReq.getFilterBy().indexOf(",") == -1)
					{
						sqlStr.append(" AND a.event_class = '" + oClnReq.getFilterBy() + "' ");
					}
					else
					{
						sqlStr.append(" AND a.event_class in ( " );
						StringTokenizer st = null;
						st = new StringTokenizer(oClnReq.getFilterBy(),",");
						int nTokenCount = 0;
						while (st.hasMoreTokens())
						{
							if(nTokenCount == 0)
							{
								sqlStr.append(" '" +st.nextElement() + "'");
							}
							else
							{
								sqlStr.append(" , '" +st.nextElement() + "'");
							}
							nTokenCount++;
							
						}
						sqlStr.append( " ) ");
						
					}
				}
				if(!noteType.equals(""))
				{
					sqlStr.append(" AND a.note_type = '" + noteType + "'");
				}
				sqlStr.append("ORDER BY event_date_time desc,a.note_type ");
				sqlStr.append(")WHERE event_date_time1 BETWEEN '" + finalStartDate + "'  AND '" + finalEndDate + "' " );
				try
				{
					connection = createConnection();
					if(connection != null)
					{
						pStmt = connection.prepareStatement(sqlStr.toString());
						
					}
					if(pStmt != null){
						resultSet = pStmt.executeQuery();
					}
					if(resultSet != null)
					{
						while(resultSet.next())
						{
							NormalViewDetailsTimeRange oNorVwDtls = new NormalViewDetailsTimeRange();
							oNorVwDtls.setEventClass(checkForNull(resultSet.getString("event_class")));
							oNorVwDtls.setNoteType(checkForNull(resultSet.getString("note_type")));
							oNorVwDtls.setAccessionNum(checkForNull(resultSet.getString("accession_num")));
							oNorVwDtls.setNoteTypeDesc(checkForNull(resultSet.getString("note_type_desc")));
							oNorVwDtls.setEventDate(checkForNull(resultSet.getString("event_date_time1")));
							oNorVwDtls.setEventTime(checkForNull(resultSet.getString("event_date_time2")));
							oNorVwDtls.setStatus(checkForNull(resultSet.getString("status")));
							oNorVwDtls.setServiceCode(checkForNull(resultSet.getString("service_code")));
							oNorVwDtls.setPerformedBy(checkForNull(resultSet.getString("performed_by_id")));
							oNorVwDtls.setPrimarySpec(checkForNull(resultSet.getString("primary_speciality_code")));
							//oNorVwDtls.setActionType(checkForNull(resultSet.getString("ACTION_TYPE")));
							
							listNormalViewDetailsTimeRange.add(oNorVwDtls);
						}
						if(listNormalViewDetailsTimeRange.size() == 0)
						{

							
							
							oErrInfo.setErrorType(Errors.CLINICALNOTES_EMPTY_DATA, locale);
						}
						oClnRes.setListNormalViewDetailsTimeRange(listNormalViewDetailsTimeRange);
					}
				}
				catch(Exception e)
				{
			         e.printStackTrace();
					
					oErrInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION, locale);
				}
				finally
				{
					int conCloseFailure = closeConnection(connection,pStmt,resultSet);
					if(conCloseFailure > 0)
					{
						System.out.println("Connection not closed in the method eIPAD.chartsummary.clinicalnotes.daoimpl.ClinicalNotesDAOImpl.getNoteDetails");
					}
				}
			}
			else
			{
				oErrInfo.setErrorType(Errors.COMMON_NULL_REQUEST, locale);
			}
		}
		else
		{
			oErrInfo.setErrorType(Errors.COMMON_NULL_REQUEST, locale);
		}
		oClnRes.getErrorsList().add(oErrInfo);
		return oClnRes;
	}
	
	
	
	
	private String checkForNull(String strParam)
    {
            String str ="";
            if(strParam!=null && strParam.length() > 0)
            str = strParam;
            return str;
    }
	public ClinicalNotesFieldResponse getNoteTypeListSfs(PatContext patientContext, String viewPage, String finalStartDate, String finalEndDate, String selectedEncounterID){
		ClinicalNotesFieldResponse response = new ClinicalNotesFieldResponse();
	
		ErrorInfo errorInfo;
		String locale = "en";
		
		if(patientContext != null){
			String respId = patientContext.getResponsibilityID();
			String ClinicianId = patientContext.getClinicianId();
			String loggedInUser = patientContext.getLoggedInUser();
			String strPatientId = patientContext.getPatientId();
		
			String facilityId = patientContext.getFacilityId();
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
		
			
			ArrayList<ClinicalNotesFieldItem> noteTypeListSFS = new ArrayList<ClinicalNotesFieldItem>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		
			StringBuffer sqlStr = new StringBuffer("");
		
			
			
			
			sqlStr.append(" SELECT DISTINCT Note_Type_Code , Note_Type_Description FROM( ");
			sqlStr.append(" SELECT note_type Note_Type_Code, note_type_desc Note_Type_Description, event_date_time1 FROM( ");
			sqlStr.append(" SELECT a.note_type, b.note_type_desc, "); 
			sqlStr.append(" TO_CHAR (a.event_date_time, 'YYYY-MM-DD') event_date_time1 ");
			sqlStr.append(" FROM ca_encntr_note a, ca_note_type_lang_vw b WHERE "); 
			sqlStr.append(" ca_get_appl_note_opern (a.facility_id,  a.accession_num, '" + respId + "', '" + ClinicianId + "', "); 
			sqlStr.append(" a.note_type, '" + loggedInUser + "', 'N'  ) IS NOT NULL "); 
			sqlStr.append(" AND a.note_type = b.note_type  AND a.patient_id = '" + strPatientId + "' AND a.facility_id = '" + facilityId + "' ");
			sqlStr.append(" AND b.language_id = '" + locale + "' ");  
			if( viewPage.equals("fullViewEncounter") || viewPage.equals("fullView")){
				sqlStr.append(" AND a.encounter_id = NVL ('" + selectedEncounterID + "', 0) ");
			} 
			sqlStr.append(" AND b.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID in ('CLINICAL_NOTES','DISCHARGE_SUMMARY'))) "); 

			if( finalStartDate != null && finalEndDate != null ){
				sqlStr.append(" WHERE event_date_time1 BETWEEN '" + finalStartDate + "'  AND '" + finalEndDate + "' "); 
			}	
			sqlStr.append(" ) GROUP BY Note_Type_Code, Note_Type_Description"); 
			sqlStr.append(" ORDER BY Note_Type_Description ");
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(sqlStr.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String NoteTypeCode ;
						String NoteTypeDesc;
						
						
						
						while(rs.next())
						{
							NoteTypeCode=rs.getString("Note_Type_Code")==null?"":rs.getString("Note_Type_Code");
							NoteTypeDesc=rs.getString("Note_Type_Description")==null?"":rs.getString("Note_Type_Description");
							
							ClinicalNotesFieldItem cnNoteTypeList = new ClinicalNotesFieldItem();
							cnNoteTypeList.setCode(NoteTypeCode);
							cnNoteTypeList.setDesc(NoteTypeDesc);
							noteTypeListSFS.add(cnNoteTypeList);
						}
							
						response.setFieldList(noteTypeListSFS);
							if(noteTypeListSFS.size() <= 0){
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
								response.getErrorsList().add(errorInfo);
							}
							else{
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
								response.getErrorsList().add(errorInfo);
							}
							
						}
					}
		}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching the list" +e);
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
			
		
		return response;
		
		
		}
	
	public ClinicalNotesFieldResponse getMedServListSfs(PatContext patientContext, String viewPage, String finalStartDate, String finalEndDate, String selectedEncounterID){
		ClinicalNotesFieldResponse response = new ClinicalNotesFieldResponse();
	
		ErrorInfo errorInfo;
		String locale = "en";
		
		if(patientContext != null){
			String respId = patientContext.getResponsibilityID();
			String ClinicianId = patientContext.getClinicianId();
			String loggedInUser = patientContext.getLoggedInUser();
			String strPatientId = patientContext.getPatientId();
		
			String facilityId = patientContext.getFacilityId();
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			
			
			ArrayList<ClinicalNotesFieldItem> medServListSFS = new ArrayList<ClinicalNotesFieldItem>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		
			StringBuffer sqlStr = new StringBuffer("");
			
			
				
			
			sqlStr.append(" SELECT DISTINCT Service_Code,  Med_Service_desc FROM ( ");
			sqlStr.append(" SELECT service_code Service_Code, med_service_desc Med_Service_desc, event_date_time1 FROM( ");
			sqlStr.append(" SELECT  a.service_code, am_get_desc.AM_SERVICE(a.SERVICE_CODE,'" + locale + "',2) med_service_desc, ");
			sqlStr.append(" TO_CHAR (a.event_date_time, 'YYYY-MM-DD') event_date_time1 ");
			sqlStr.append(" FROM ca_encntr_note a, ca_note_type_lang_vw b  WHERE ");
			sqlStr.append(" ca_get_appl_note_opern (a.facility_id,  a.accession_num, '" + respId + "', '" + ClinicianId + "', ");
			sqlStr.append(" a.note_type, '" + loggedInUser + "', 'N'  ) IS NOT NULL ");
			sqlStr.append(" AND a.note_type = b.note_type  AND a.patient_id = '" + strPatientId + "' AND a.facility_id = '" + facilityId + "' ");
			sqlStr.append(" AND b.language_id = '" + locale + "' ");
			if( viewPage.equals("fullViewEncounter") || viewPage.equals("fullView")){
				sqlStr.append(" AND a.encounter_id = NVL ('" + selectedEncounterID + "', 0) ");
			} 
			sqlStr.append(" AND b.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID in ('CLINICAL_NOTES','DISCHARGE_SUMMARY'))) ");  
			if( finalStartDate != null && finalEndDate != null ){
				sqlStr.append(" WHERE event_date_time1 BETWEEN '" + finalStartDate + "'  AND '" + finalEndDate + "' "); 
			}
			sqlStr.append(" )GROUP BY Service_Code, Med_Service_desc ");
			sqlStr.append(" ORDER BY Med_Service_desc ");
		
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(sqlStr.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String MedServCode;
						String MedServDesc;
						
						while(rs.next())
						{
							MedServCode=rs.getString("Service_Code")==null?"":rs.getString("Service_Code");
							MedServDesc=rs.getString("Med_Service_desc")==null?"":rs.getString("Med_Service_desc");
							
							ClinicalNotesFieldItem cnMedServList = new ClinicalNotesFieldItem();
							cnMedServList.setCode(MedServCode);
							cnMedServList.setDesc(MedServDesc);
							medServListSFS.add(cnMedServList);
						}
							
						response.setFieldList(medServListSFS);
							if(medServListSFS.size() <= 0){
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
								response.getErrorsList().add(errorInfo);
							}
							else{
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
								response.getErrorsList().add(errorInfo);
							}
							
						}
					}
		}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching the list" +e);
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
		
		return response;
		
		}
	
	public ClinicalNotesFieldResponse getPerformedByListSfs(PatContext patientContext, String viewPage, String finalStartDate, String finalEndDate, String selectedEncounterID){
		ClinicalNotesFieldResponse response = new ClinicalNotesFieldResponse();
	
		ErrorInfo errorInfo;
		String locale = "en";
		
		if(patientContext != null){
			String respId = patientContext.getResponsibilityID();
			String ClinicianId = patientContext.getClinicianId();
			String loggedInUser = patientContext.getLoggedInUser();
			String strPatientId = patientContext.getPatientId();
			//String encounterId = (patientContext.getSelectedEncounterId() == null || patientContext.getSelectedEncounterId().equals("")) ? patientContext.getEncounterId() : patientContext.getSelectedEncounterId();//checkForNull(oPatContext.getEncounterId());
			String facilityId = patientContext.getFacilityId();
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			
			ArrayList<ClinicalNotesFieldItem> performedByListSFS = new ArrayList<ClinicalNotesFieldItem>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		
			StringBuffer sqlStr = new StringBuffer("");
			
		
				
			sqlStr.append(" SELECT DISTINCT Performed_by, Practitioner_desc FROM( ");
			sqlStr.append(" SELECT performed_by_id Performed_by, Practitioner_desc , event_date_time1 FROM( ");
			sqlStr.append(" SELECT a.performed_by_id, am_get_desc.AM_PRACTITIONER(a.performed_by_id,'" + locale + "',1) Practitioner_desc, ");
			sqlStr.append(" TO_CHAR (a.event_date_time, 'YYYY-MM-DD') event_date_time1  ");
			sqlStr.append(" FROM ca_encntr_note a, ca_note_type_lang_vw b   WHERE ");
			sqlStr.append(" ca_get_appl_note_opern (a.facility_id,  a.accession_num, '" + respId + "', '" + ClinicianId + "', ");
			sqlStr.append(" a.note_type, '" + loggedInUser + "', 'N'  ) IS NOT NULL ");
			sqlStr.append(" AND a.note_type = b.note_type  AND a.patient_id = '" + strPatientId + "' AND a.facility_id = '" + facilityId + "' ");
			sqlStr.append(" AND b.language_id = '" + locale + "'");		
			if( viewPage.equals("fullViewEncounter") || viewPage.equals("fullView")){
				sqlStr.append(" AND a.encounter_id = NVL ('" + selectedEncounterID + "', 0) ");
			}		
			sqlStr.append(" AND b.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID in ('CLINICAL_NOTES','DISCHARGE_SUMMARY'))) "); 
			if( finalStartDate != null && finalEndDate != null ){
				sqlStr.append(" WHERE event_date_time1 BETWEEN '" + finalStartDate + "'  AND '" + finalEndDate + "' "); 
			}
			sqlStr.append(" )GROUP BY Performed_by, Practitioner_desc "); 
			sqlStr.append(" ORDER BY Practitioner_desc ");
					
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(sqlStr.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String PerformedByID;
						String PerformedByDesc;
						
						while(rs.next())
						{
							PerformedByID=rs.getString("Performed_by")==null?"":rs.getString("Performed_by");
							PerformedByDesc=rs.getString("Practitioner_desc")==null?"":rs.getString("Practitioner_desc");
							
							ClinicalNotesFieldItem cnPerformedByList = new ClinicalNotesFieldItem();
							cnPerformedByList.setCode(PerformedByID);
							cnPerformedByList.setDesc(PerformedByDesc);
							performedByListSFS.add(cnPerformedByList);
						}
							
						response.setFieldList(performedByListSFS);
							if(performedByListSFS.size() <= 0){
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
								response.getErrorsList().add(errorInfo);
							}
							else{
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
								response.getErrorsList().add(errorInfo);
							}
							
						}
					}
		}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching the list" +e);
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
		
		return response;
		
		}
	
	public ClinicalNotesFieldResponse getStatusListSfs(PatContext patientContext, String viewPage, String finalStartDate, String finalEndDate, String selectedEncounterID){
		ClinicalNotesFieldResponse response = new ClinicalNotesFieldResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		
		if(patientContext != null){
			String respId = patientContext.getResponsibilityID();
			String ClinicianId = patientContext.getClinicianId();
			String loggedInUser = patientContext.getLoggedInUser();
			String strPatientId = patientContext.getPatientId();
			//String encounterId = (patientContext.getSelectedEncounterId() == null || patientContext.getSelectedEncounterId().equals("")) ? patientContext.getEncounterId() : patientContext.getSelectedEncounterId();//checkForNull(oPatContext.getEncounterId());
			String facilityId = patientContext.getFacilityId();
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
		 
			
			ArrayList<ClinicalNotesFieldItem> statusListSFS = new ArrayList<ClinicalNotesFieldItem>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		
			StringBuffer sqlStr = new StringBuffer("");
			
		
			
			sqlStr.append(" SELECT DISTINCT  Event_Status,  Status_desc  FROM( ");
			sqlStr.append(" SELECT event_status Event_Status, status_desc Status_desc, event_date_time1 FROM ( ");
			sqlStr.append(" SELECT a.event_status, decode( a.event_status,'1','In Progress','2','Transcribed','3','Unauthorized','4','Authorized','5','Modified','9','In Error') status_desc, ");
			sqlStr.append(" TO_CHAR (a.event_date_time, 'YYYY-MM-DD') event_date_time1 ");
			sqlStr.append(" FROM ca_encntr_note a, ca_note_type_lang_vw b   WHERE ");
			sqlStr.append(" ca_get_appl_note_opern (a.facility_id,  a.accession_num, '" + respId + "', '" + ClinicianId + "', ");
			sqlStr.append(" a.note_type, '" + loggedInUser + "', 'N'  ) IS NOT NULL ");
			sqlStr.append(" AND a.note_type = b.note_type  AND a.patient_id = '" + strPatientId + "' AND a.facility_id = '" + facilityId + "' ");
			sqlStr.append(" AND b.language_id = '" + locale + "'");
			if( viewPage.equals("fullViewEncounter") || viewPage.equals("fullView")){
				sqlStr.append(" AND a.encounter_id = NVL ('" + selectedEncounterID + "', 0) ");
			}		
			sqlStr.append(" AND b.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID in ('CLINICAL_NOTES','DISCHARGE_SUMMARY'))) "); 
			if( finalStartDate != null && finalEndDate != null ){
				sqlStr.append(" WHERE event_date_time1 BETWEEN '" + finalStartDate + "'  AND '" + finalEndDate + "' "); 
			}
			sqlStr.append(" )GROUP BY Event_Status, Status_desc ");
			sqlStr.append(" ORDER BY Event_Status ");
					
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(sqlStr.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String StatusCode;
						String StatusDesc;
						//String StatusCount;
						
						while(rs.next())
						{
							StatusCode=rs.getString("Event_Status")==null?"":rs.getString("Event_Status");
							StatusDesc=rs.getString("Status_desc")==null?"":rs.getString("Status_desc");
							//StatusCount=rs.getString("Status_desc_Count")==null?"":rs.getString("Status_desc_Count");
							
							ClinicalNotesFieldItem cnStatusList = new ClinicalNotesFieldItem();
							cnStatusList.setCode(StatusCode);
							cnStatusList.setDesc(StatusDesc);
							//cnStatusList.setDetail(StatusCount);
							statusListSFS.add(cnStatusList);
						}
							
						response.setFieldList(statusListSFS);
							if(statusListSFS.size() <= 0){
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
								response.getErrorsList().add(errorInfo);
							}
							else{
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
								response.getErrorsList().add(errorInfo);
							}
							
						}
					}
		}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching the list" +e);
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
		
		return response;
		
		}
	public ClinicalNotesFieldResponse getMySpecialityList(PatContext patientContext){
		ClinicalNotesFieldResponse response = new ClinicalNotesFieldResponse();

		ErrorInfo errorInfo;
		String locale = "en";
		
		if(patientContext != null){
			
			String loggedInUser = patientContext.getLoggedInUser();
			ArrayList<ClinicalNotesFieldItem> mySpecialityListSFS = new ArrayList<ClinicalNotesFieldItem>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		
			StringBuffer sqlStr = new StringBuffer("");
			
			sqlStr.append(" SELECT resource_code Speciality_code, note_type_id NoteType_code "); 
			sqlStr.append(" FROM ca_note_type_for_resource "); 
			sqlStr.append(" WHERE resource_code IN "); 
			sqlStr.append(" (SELECT primary_speciality_code "); 
			sqlStr.append(" FROM am_practitioner "); 
			sqlStr.append(" WHERE practitioner_id = '" + loggedInUser + "') "); 
			sqlStr.append(" AND resource_type ='S'" );
			
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(sqlStr.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String specialityCode;
						String noteTypeCode;
						
						while(rs.next())
						{
							specialityCode=rs.getString("Speciality_code")==null?"":rs.getString("Speciality_code");
							noteTypeCode=rs.getString("NoteType_code")==null?"":rs.getString("NoteType_code");
							
							
							ClinicalNotesFieldItem cnMySpecialityList = new ClinicalNotesFieldItem();
							cnMySpecialityList.setCode(specialityCode);
							cnMySpecialityList.setDesc(noteTypeCode);
							mySpecialityListSFS.add(cnMySpecialityList);
						}
							
						response.setFieldList(mySpecialityListSFS);
							if(mySpecialityListSFS.size() <= 0){
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
								response.getErrorsList().add(errorInfo);
							}
							else{
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
								response.getErrorsList().add(errorInfo);
							}
							
						}
					}
		}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching the list" +e);
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
		
		return response;
		
		}
	
	

	public ClinicalNotesFieldResponse getNoteTypeList(PatContext patientContext, String filterByVal, String applTaskID,String noteGroupID, String specialityCode)
	{
		ClinicalNotesFieldResponse response = new ClinicalNotesFieldResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		
		if(patientContext != null){
			String practType = patientContext.getPracType();
			String practID = patientContext.getClinicianId();
			String facilityId = patientContext.getFacilityId();
			String encounterId = patientContext.getEncounterId();
			String patientClass = patientContext.getPatientClass();
			String respID = patientContext.getResponsibilityID();
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			
			
			ArrayList<ClinicalNotesFieldItem> noteTypeList = new ArrayList<ClinicalNotesFieldItem>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			StringBuffer noteTypeListQuery = new StringBuffer("");
			if(!filterByVal.equals("R")){
				noteTypeListQuery.append(" Select distinct a.note_type_id note_type, replace(c.note_type_desc,'''','') note_type_desc,(select a.TRANSCRIPTION_YN from CA_NOTE_GROUP a where a.NOTE_GROUP " );
				noteTypeListQuery.append(" =c.NOTE_GROUP_ID ) dflt_transcription_yn from ca_note_type_for_resource a , ca_note_type_lang_vw c where  ");
				if(filterByVal.equals("P") || filterByVal.equals("")){
					filterByVal = "P";
					noteTypeListQuery.append(" a.resource_TYPE ='"+filterByVal+"'  AND a.RESOURCE_CODE = '"+practID+"' ");
				}
				else if(filterByVal.equals("S") && (specialityCode.equals(""))){
					noteTypeListQuery.append(" a.resource_type='"+filterByVal+"'  and a.RESOURCE_CODE in (SELECT PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID='"+practID+"' UNION SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE PRACTITIONER_ID= '"+practID+"')  ");
				}
				else{
					noteTypeListQuery.append(" a.resource_type='"+filterByVal+"'  and a.RESOURCE_CODE='"+ specialityCode+"'  ");
				}
				noteTypeListQuery.append(" and a.note_type_id = c.note_type and c.language_id ='"+locale+"' and decode('"+patientClass+"','IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' ");
				noteTypeListQuery.append(" and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = '"+respID+"'  AND privilege_type != '5' ) ");
				if(noteGroupID.equals("")){
					noteTypeListQuery.append(" AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID='"+applTaskID+"')  	order by  2 ");
				}
				else
				{
					noteTypeListQuery.append(" AND c.NOTE_GROUP_ID = '"+noteGroupID+"'	order by  2 ");
				}
			}
			else
			{
				noteTypeListQuery.append(" Select distinct a.note_type, replace(c.note_type_desc,'''','') note_type_desc from ca_note_type_for_resp a , ca_note_type_lang_vw c where a.resp_id = '"+respID+"'  and ");
				noteTypeListQuery.append(" a.note_type = c.note_type and c.language_id = '"+locale+"' and a.privilege_type != '5' and decode('"+patientClass+"','IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E'  	 ");
				if(noteGroupID.equals("")){
					noteTypeListQuery.append(" AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID='"+applTaskID+"')  	order by  2 ");
				}
				else {
					noteTypeListQuery.append(" AND c.NOTE_GROUP_ID ='"+noteGroupID+"'  	order by  2 ");
				}
			}
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(noteTypeListQuery.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String noteType ;
						String noteTypeDesc;
						boolean dflt_Transcription_YN;
						
						while(rs.next())
						{
							ClinicalNotesFieldItem cnNoteType = new ClinicalNotesFieldItem();
							noteType=rs.getString("note_type")==null?"":rs.getString("note_type");
							noteTypeDesc=rs.getString("note_type_desc")==null?"":rs.getString("note_type_desc");
							if(!filterByVal.equals("R")){
								dflt_Transcription_YN=rs.getString("dflt_Transcription_YN")!=null && rs.getString("dflt_Transcription_YN").equals("Y")?true:false;
								cnNoteType.setDefaultField(dflt_Transcription_YN);
							}
							cnNoteType.setCode(noteType);
							cnNoteType.setDesc(noteTypeDesc);
							noteTypeList.add(cnNoteType);
						}
							/*response.setNoteTypeList(noteTypeList);*/
						response.setFieldList(noteTypeList);
						if(noteTypeList.size() <= 0){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}
							
					}
				}
			}
				catch(SQLException e){
					System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
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
		return response;
	}
	
	public ClinicalNotesFieldResponse getNoteGroupList(PatContext patientContext, String filterByVal, String applTaskID, String specialityCode)
	{
		ClinicalNotesFieldResponse response = new ClinicalNotesFieldResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		if(patientContext != null){
			String practType = patientContext.getPracType();
			String practID = patientContext.getClinicianId();
			String facilityId = patientContext.getFacilityId();
			String encounterId = patientContext.getEncounterId();
			String patientClass = patientContext.getPatientClass();
			String respID = patientContext.getResponsibilityID();
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			
			ArrayList<ClinicalNotesFieldItem> noteGroupList = new ArrayList<ClinicalNotesFieldItem>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			StringBuffer noteTypeListQuery = new StringBuffer("");
			if(!filterByVal.equals("R")){
				noteTypeListQuery.append(" Select note_group, note_group_desc from ca_note_group_lang_vw  a  where a.eff_status='E'  and a.language_id = '"+locale+"'   and a.APPL_TASK_ID='"+applTaskID+"'   and " );
				if(filterByVal.equals(""))
				{
					filterByVal = "P";
				}
				noteTypeListQuery.append(" exists (select 1 from ca_note_type ia,ca_note_type_for_resource ib where IB.RESOURCE_TYPE='"+filterByVal+"' ");
				if(filterByVal.equals("P")|| filterByVal.equals(""))
				{
					
					noteTypeListQuery.append(" AND ib.RESOURCE_CODE = '"+practID+"' ");
				}
				else if(filterByVal.equals("S") && (specialityCode.equals("")))
				{
					noteTypeListQuery.append(" and ib.RESOURCE_CODE in (SELECT PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID='"+practID+"' UNION SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE PRACTITIONER_ID= '"+practID+"') ");
				}
				else {
					noteTypeListQuery.append(" and ib.RESOURCE_CODE='"+specialityCode+"' ");
				}
				noteTypeListQuery.append(" and ib.note_type_id=ia.note_type and ia.NOTE_GROUP_ID = a.NOTE_GROUP and rownum=1)  order by 2 ");
			}
			else{
				if(filterByVal.equals("R")){
					noteTypeListQuery.append(" Select note_group, note_group_desc from ca_note_group_lang_vw  a  where a.eff_status='E'  and a.language_id = '"+locale+"'   and a.APPL_TASK_ID='"+applTaskID+"'   and  ");
					noteTypeListQuery.append(" exists (select 1 from ca_note_type ia,ca_note_type_for_resp ib where ib.resp_id='"+respID+"' and ib.note_type=ia.note_type and ia.NOTE_GROUP_ID = a.NOTE_GROUP and rownum=1)  order by 2 ");
				}
			}
				
			
			/*noteTypeListQuery.append(" Select note_group, note_group_desc from ca_note_group_lang_vw  a  where a.eff_status='E'  and a.language_id = '"+locale+"'   and a.APPL_TASK_ID='CLINICAL_NOTES'   and " );
			noteTypeListQuery.append(" exists (select 1 from ca_note_type ia,ca_note_type_for_resource ib where IB.RESOURCE_TYPE='P'  AND ib.RESOURCE_CODE = '"+practID+"' and ib.note_type_id=ia.note_type   ");
			noteTypeListQuery.append(" and ia.NOTE_GROUP_ID = a.NOTE_GROUP and rownum=1)  order by 2 ");*/
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(noteTypeListQuery.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String noteGroup ;
						String noteGroupDesc;
						
						
						while(rs.next())
						{
							noteGroup=rs.getString("note_group")==null?"":rs.getString("note_group");
							noteGroupDesc=rs.getString("note_group_desc")==null?"":rs.getString("note_group_desc");
							ClinicalNotesFieldItem cnNoteType = new ClinicalNotesFieldItem();
							cnNoteType.setCode(noteGroup);
							cnNoteType.setDesc(noteGroupDesc);
							noteGroupList.add(cnNoteType);
						}
						response.setFieldList(noteGroupList);
						if(noteGroupList.size() <= 0){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}
							
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
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
		return response;
	}
	
	public ClinicalNotesFieldResponse getSpecialityList(PatContext patientContext)
	{
		ClinicalNotesFieldResponse response = new ClinicalNotesFieldResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		
		if(patientContext != null){
			String practType = patientContext.getPracType();
			String practID = patientContext.getClinicianId();
			String facilityId = patientContext.getFacilityId();
			String encounterId = patientContext.getEncounterId();
			String patientClass = patientContext.getPatientClass();
			String respID = patientContext.getResponsibilityID();
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			
			ArrayList<ClinicalNotesFieldItem> noteGroupList = new ArrayList<ClinicalNotesFieldItem>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			StringBuffer specialityListQuery = new StringBuffer("");
			
			specialityListQuery.append(" select SPECIALITY_CODE,am_get_desc.AM_SPECIALITY(SPECIALITY_CODE,'"+locale+"','2') short_desc from am_speciality_lang_vw where language_id='"+locale+"' and SPECIALITY_CODE " );
			specialityListQuery.append(" IN (select A.PRIMARY_SPECIALITY_CODE from AM_PRACTITIONER A where A.PRACTITIONER_ID = '"+practID+"' UNION  select B.SPECIALITY_CODE from AM_PRACT_SPECIALITIES B   ");
			specialityListQuery.append(" where B.PRACTITIONER_ID = '"+practID+"' and B.FACILITY_ID = '"+facilityId+"') and eff_status = 'E' order by 2 ");
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(specialityListQuery.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String specialityCode ;
						String specialityDesc;
						
						
						while(rs.next())
						{
							specialityCode=rs.getString("SPECIALITY_CODE")==null?"":rs.getString("SPECIALITY_CODE");
							specialityDesc=rs.getString("short_desc")==null?"":rs.getString("short_desc");
							ClinicalNotesFieldItem cnSpecialityField = new ClinicalNotesFieldItem();
							cnSpecialityField.setCode(specialityCode);
							cnSpecialityField.setDesc(specialityDesc);
							noteGroupList.add(cnSpecialityField);
						}
							/*response.setNoteGroupList(noteGroupList) ;*/
						response.setFieldList(noteGroupList);
						if(noteGroupList.size() <= 0){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}
							
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
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
		return response;
	}
	
	public ClinicalNotesFieldResponse getMedAncServiceList(String searchText, String searchCriteria,PatContext patientContext){
		ClinicalNotesFieldResponse response = new ClinicalNotesFieldResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		
		if(patientContext != null){
			String practType = patientContext.getPracType();
			String practID = patientContext.getClinicianId();
			String facilityId = patientContext.getFacilityId();
			String encounterId = patientContext.getEncounterId();
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
		
		/*searchText = "";
		searchCriteria = "C";*/
		ArrayList<ClinicalNotesFieldItem> medAncServiceList = new ArrayList<ClinicalNotesFieldItem>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// rite now values r added directly have to get from somewhere
		StringBuffer medAncSerivceListQuery = new StringBuffer("");
		
		
		medAncSerivceListQuery.append(" select a.service_code code, replace(a.short_desc ,'''','')  short_desc from  am_service_lang_vw a where nvl(a.eff_status,'E') ='E'  and a.LANGUAGE_ID='"+locale+"' and  " );
		medAncSerivceListQuery.append(" exists (select 1 from AM_FACILITY_SERVICE where  operating_facility_id = '"+facilityId+"' and SERVICE_CODE=a.SERVICE_CODE )  ");
		if(!searchText.equals(""))
		{
			if(searchCriteria.equals("C"))
			{
				medAncSerivceListQuery.append(" and upper(service_code) like upper('%" + searchText + "%' )") ;
				
			}
			else if(searchCriteria.equals("D"))
			{
				medAncSerivceListQuery.append(" and upper(short_desc ) like upper('%" + searchText + "%' ) ");
				
			}

		}
		else
		{
			if(searchCriteria.equals("C"))
			{
				medAncSerivceListQuery.append(" order by code ");
			}
			else if(searchCriteria.equals("D"))
			{
				medAncSerivceListQuery.append(" order by short_desc ");
			}
		}
		try{
			con = createConnection();
			if(con == null){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			else{
				pstmt=con.prepareStatement(medAncSerivceListQuery.toString());
				rs = pstmt.executeQuery();
				if(rs == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					String code ;
					String desc;
					
					while(rs.next())
					{
						code=rs.getString("code")==null?"":rs.getString("code");
						desc=rs.getString("short_desc")==null?"":rs.getString("short_desc");
						
						
						
						ClinicalNotesFieldItem cnNoteType = new ClinicalNotesFieldItem();
						cnNoteType.setCode(code);
						cnNoteType.setDesc(desc);
						medAncServiceList.add(cnNoteType);
					}
						/*response.setNoteGroupList(noteGroupList) ;*/
					response.setFieldList(medAncServiceList);
						if(medAncServiceList.size() <= 0){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}
						
					}
				}
	}
		catch(SQLException e){
			System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
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

		return response;
	}
	
	//select the corresponding notegroup when note type is selected -- only one field item will be returned
	public ClinicalNotesFieldResponse getSelNoteGroup(PatContext patientContext, String selNoteType)
	{
		ClinicalNotesFieldResponse response = new ClinicalNotesFieldResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		String filterByVal = "R";
		
		if(patientContext != null){
			String practType = patientContext.getPracType();
			String practID = patientContext.getClinicianId();
			String facilityId = patientContext.getFacilityId();
			String encounterId = patientContext.getEncounterId();
			String patientClass = patientContext.getPatientClass();
			String respID = patientContext.getResponsibilityID();
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			
			ArrayList<ClinicalNotesFieldItem> headerFieldList = new ArrayList<ClinicalNotesFieldItem>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			StringBuffer headerFieldQuery = new StringBuffer("");
			headerFieldQuery.append(" select b.event_class, b.note_type_desc, b.serv_facl_spec_yn, b.note_group_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time,b.DOC_LINKED_NOTE_YN,(select a.TRANSCRIPTION_YN from CA_NOTE_GROUP a where a.NOTE_GROUP =b.NOTE_GROUP_ID ) dflt_transcription_yn, " );
			headerFieldQuery.append(" d.note_group_desc from CA_NOTE_TYPE_FOR_RESP a,CA_NOTE_TYPE_lang_vw b ,SM_RESP C, ca_note_group_lang_vw d where C.resp_id = '"+respID+"' and A.note_type = '"+selNoteType+"' and b.language_id = '"+locale+"' and	c.RESP_ID=A.RESP_ID	and	b.NOTE_TYPE=A.NOTE_TYPE	and	b.EFF_STATUS='E' ");
			headerFieldQuery.append(" and note_group IN(select  b.note_group_id from 	CA_NOTE_TYPE_FOR_RESP a,CA_NOTE_TYPE_lang_vw b ,SM_RESP C where C.resp_id = '"+respID+"' and A.note_type = '"+selNoteType+"' and b.language_id = '"+locale+"' and	c.RESP_ID=A.RESP_ID	and	b.NOTE_TYPE=A.NOTE_TYPE	and	b.EFF_STATUS='E') and d.language_id='"+locale+"' ");			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(headerFieldQuery.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String noteGroupDesc;	
						String noteGroupID;
						String serv_facl_spec_yn;
						
						while(rs.next())
						{
							noteGroupID = rs.getString("note_group_id")==null?"":rs.getString("note_group_id");
							noteGroupDesc = rs.getString("note_group_desc")==null?"":rs.getString("note_group_desc");
							serv_facl_spec_yn = rs.getString("serv_facl_spec_yn")==null?"":rs.getString("serv_facl_spec_yn");//ser_spc_yn parameter for selecting medical anc services

							ClinicalNotesFieldItem cnNoteType = new ClinicalNotesFieldItem();
							cnNoteType.setCode(noteGroupID);
							cnNoteType.setDesc(noteGroupDesc);
							cnNoteType.setDetail(serv_facl_spec_yn);
							headerFieldList.add(cnNoteType);
						}
							/*response.setNoteGroupList(noteGroupList) ;*/
						response.setFieldList(headerFieldList);
						if(headerFieldList.size() <= 0){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
							response.getErrorsList().add(errorInfo);
						}
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
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
		return response;
	}
	public ClinicalNotesFieldResponse getMedAncServicesList(PatContext patientContext, String ser_spc_yn, String noteType)
	{
		ClinicalNotesFieldResponse response = new ClinicalNotesFieldResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		
		if(patientContext != null){
			String facilityId = patientContext.getFacilityId();
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			
			ArrayList<ClinicalNotesFieldItem> headerFieldList = new ArrayList<ClinicalNotesFieldItem>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			StringBuffer headerFieldQuery = new StringBuffer("");
			headerFieldQuery.append("select a.service_code code, replace(a.short_desc ,'''','')  short_desc from  am_service_lang_vw a where nvl(a.eff_status,'E') ='E'  and a.LANGUAGE_ID=? and exists (select 1 from AM_FACILITY_SERVICE where  operating_facility_id = ? and SERVICE_CODE=a.SERVICE_CODE ) ");

			if(ser_spc_yn.equals("Y"))
			{
				headerFieldQuery.append(" and exists (select service_code from ca_note_type_by_serv where facility_id=? and note_type = ? and service_code=a.SERVICE_CODE)");
			}
			headerFieldQuery.append(" order by short_desc");
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt = con.prepareStatement(headerFieldQuery.toString());
					pstmt.setString(1,locale);
					pstmt.setString(2,facilityId);
					
					if(ser_spc_yn.equals("Y"))
					{
						pstmt.setString(3,facilityId);
						pstmt.setString(4,noteType);
					}
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String medServiceDesc ;	
						String medServiceID;
						
						while(rs.next())
						{
							medServiceID = rs.getString("code")==null?"":rs.getString("code");
							medServiceDesc=rs.getString("short_desc")==null?"":rs.getString("short_desc");

							ClinicalNotesFieldItem cnNoteType = new ClinicalNotesFieldItem();
							cnNoteType.setCode(medServiceID);
							cnNoteType.setDesc(medServiceDesc);
							headerFieldList.add(cnNoteType);
						}
							/*response.setNoteGroupList(noteGroupList) ;*/
						response.setFieldList(headerFieldList);
							if(headerFieldList.size() <= 0){
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
								response.getErrorsList().add(errorInfo);
							}
						}
					}
		}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
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
		return response;
	}
	public ClinicalNotesFieldResponse getSelMedService(PatContext patientContext)
	{
		ClinicalNotesFieldResponse response = new ClinicalNotesFieldResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		
		if(patientContext != null){
			String practType = patientContext.getPracType();
			String practID = patientContext.getClinicianId();
			String facilityId = patientContext.getFacilityId();
			String encounterId = patientContext.getEncounterId();
			String patientClass = patientContext.getPatientClass();
			String respID = patientContext.getResponsibilityID();
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			
			ArrayList<ClinicalNotesFieldItem> headerFieldList = new ArrayList<ClinicalNotesFieldItem>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			// rite now values r added directly have to get from somewhere
			StringBuffer headerFieldQuery = new StringBuffer("");
			// from this query only notegroup Id is taken. The Query is same as that of EM so not done any chanegs 
			headerFieldQuery.append(" SELECT a.service_code med_splty_grp_code, b.short_desc  FROM pr_encounter a, am_service_lang_vw b  WHERE a.encounter_id = '"+encounterId+"' and a.facility_id= '"+facilityId+"' " );
			headerFieldQuery.append(" and b.service_code IN(SELECT service_code med_splty_grp_code  FROM pr_encounter WHERE encounter_id = '"+encounterId+"' and facility_id= '"+facilityId+"'and language_id='"+locale+"' )  ");			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(headerFieldQuery.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String medServiceDesc ;	
						String medServiceID;
						
						while(rs.next())
						{
							medServiceID = rs.getString("med_splty_grp_code")==null?"":rs.getString("med_splty_grp_code");
							medServiceDesc=rs.getString("short_desc")==null?"":rs.getString("short_desc");

							ClinicalNotesFieldItem cnNoteType = new ClinicalNotesFieldItem();
							cnNoteType.setCode(medServiceID);
							cnNoteType.setDesc(medServiceDesc);
							headerFieldList.add(cnNoteType);
						}
							/*response.setNoteGroupList(noteGroupList) ;*/
						response.setFieldList(headerFieldList);
							if(headerFieldList.size() <= 0){
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
								response.getErrorsList().add(errorInfo);
							}
						}
					}
		}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
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
		return response;
	}
	public ClinicalNotesValidationResponse checkNoOfNotes(PatContext patientContext,String selNoteType, String noteGrpId)
	{
		ClinicalNotesValidationResponse validationResponse = new ClinicalNotesValidationResponse();
		validationResponse.setValidationResult(ClinicalNotesValidationResponse.VALIDATION_SUCCESS);
		ErrorInfo errorInfo;
		String locale = "en";
		ClinicalNotesErrorItem errorItem;
		ArrayList<ClinicalNotesErrorItem> errorItems = new ArrayList<ClinicalNotesErrorItem>();
		
		if(patientContext != null){
			String practType = patientContext.getPracType();
			String practID = patientContext.getClinicianId();
			String facilityId = patientContext.getFacilityId();
			String encounterId = patientContext.getEncounterId();
			String patientClass = patientContext.getPatientClass();
			String respID = patientContext.getResponsibilityID();
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			String  maxNoOfNotes = "";
			int notePerEnc = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			
			StringBuffer query01 = new StringBuffer("");
			// from this query only notegroup Id is taken. The Query is same as that of EM so not done any chanegs 
			query01.append(" select NO_OF_REC_PER_ENC,ROLE_BASED_ACCESS_YN,PRE_COND_FOR_REC from ca_note_group where NOTE_GROUP='"+noteGrpId+"' " );			
			try{
				con = createConnection();
				if(con == null){
					errorItem = new ClinicalNotesErrorItem();
					errorItem.setErrorMessageId("SQL_EXCEPTION");
					errorItem.setErrorMessage("SQL exception occured");
					errorItems.add(errorItem);
					validationResponse.setValidationResult(ClinicalNotesValidationResponse.VALIDATION_STATUS_FETCH_FAILURE);
				}
				else{
					pstmt=con.prepareStatement(query01.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorItem = new ClinicalNotesErrorItem();
						errorItem.setErrorMessageId("SQL_EXCEPTION");
						errorItem.setErrorMessage("SQL exception occured");
						errorItems.add(errorItem);
						validationResponse.setValidationResult(ClinicalNotesValidationResponse.VALIDATION_STATUS_FETCH_FAILURE);
					}
					else{
						while(rs.next())
						{
							maxNoOfNotes=rs.getString("NO_OF_REC_PER_ENC")==null?"":rs.getString("NO_OF_REC_PER_ENC");
							/*maxNoOfNotes = rs.getInt("NO_OF_REC_PER_ENC");*/
						}
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
				errorItem = new ClinicalNotesErrorItem();
				errorItem.setErrorMessageId("SQL_EXCEPTION");
				errorItem.setErrorMessage("SQL exception occured");
				errorItems.add(errorItem);
				validationResponse.setValidationResult(ClinicalNotesValidationResponse.VALIDATION_STATUS_FETCH_FAILURE);
			}
			catch(Exception e){
				errorItem = new ClinicalNotesErrorItem();
				errorItem.setErrorMessageId("SQL_EXCEPTION");
				errorItem.setErrorMessage("SQL exception occured");
				errorItems.add(errorItem);
				validationResponse.setValidationResult(ClinicalNotesValidationResponse.VALIDATION_STATUS_FETCH_FAILURE);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
			
			StringBuffer query02 = new StringBuffer(""); 
			query02.append(" select count(*) notes_per_enc from ca_encntr_note where encounter_id = '"+encounterId+"' and facility_id='"+facilityId+"' and note_type = '"+selNoteType+"' and event_status in ('1','2','3','4','5') " );			
			try{
				con = createConnection();
				if(con == null){
					errorItem = new ClinicalNotesErrorItem();
					errorItem.setErrorMessageId("SQL_EXCEPTION");
					errorItem.setErrorMessage("SQL exception occured");
					errorItems.add(errorItem);
					validationResponse.setValidationResult(ClinicalNotesValidationResponse.VALIDATION_STATUS_FETCH_FAILURE);
				}
				else{
					pstmt=con.prepareStatement(query02.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorItem = new ClinicalNotesErrorItem();
						errorItem.setErrorMessageId("SQL_EXCEPTION");
						errorItem.setErrorMessage("SQL exception occured");
						errorItems.add(errorItem);
						validationResponse.setValidationResult(ClinicalNotesValidationResponse.VALIDATION_STATUS_FETCH_FAILURE);
					}
					else{
						while(rs.next())
						{
							notePerEnc=rs.getInt("notes_per_enc");
						}
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
				errorItem = new ClinicalNotesErrorItem();
				errorItem.setErrorMessageId("SQL_EXCEPTION");
				errorItem.setErrorMessage("SQL exception occured");
				errorItems.add(errorItem);
				validationResponse.setValidationResult(ClinicalNotesValidationResponse.VALIDATION_STATUS_FETCH_FAILURE);
			}
			catch(Exception e){
				errorItem = new ClinicalNotesErrorItem();
				errorItem.setErrorMessageId("SQL_EXCEPTION");
				errorItem.setErrorMessage("SQL exception occured");
				errorItems.add(errorItem);
				validationResponse.setValidationResult(ClinicalNotesValidationResponse.VALIDATION_STATUS_FETCH_FAILURE);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
			
			if(!(maxNoOfNotes.equals("")||maxNoOfNotes.equals(null))){
				int maxNotes = Integer.parseInt(maxNoOfNotes);
				if(notePerEnc >=maxNotes){
					
					errorItem = new ClinicalNotesErrorItem();
					errorItem.setErrorMessageId("MAX_NOTES");
					errorItem.setErrorMessage("Maximum notes for Encounter reached");
					errorItems.add(errorItem);
					validationResponse.setValidationResult(ClinicalNotesValidationResponse.VALIDATION_ERROR);
				}
				else{
					validationResponse.setValidationResult(ClinicalNotesValidationResponse.VALIDATION_SUCCESS);
				}// note cn be created
			}
			else{
				validationResponse.setValidationResult(ClinicalNotesValidationResponse.VALIDATION_SUCCESS);// note cn be created
			}
		}
		else{
			errorItem = new ClinicalNotesErrorItem();
			errorItem.setErrorMessageId("NULL_PATCONTEXT");
			errorItem.setErrorMessage("No Patient was selected");
			errorItems.add(errorItem);
			validationResponse.setValidationResult(ClinicalNotesValidationResponse.VALIDATION_STATUS_FETCH_FAILURE);
		}
		return validationResponse;
	}
	

	/**
	 * Method returns the PatientHash which is set to RecClinicalNotesSectionBean
	 * SQL query and code taken from RecClinicalNotesSection.jsp
	 * @param patientContext
	 * @return
	 */
	public Hashtable getPatientHash(PatContext patientContext){
		Hashtable PatientHash =new Hashtable();
		String patient_id;
		String facility_id;
		String locale;
		String location_code;
		String patient_class;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		if(patientContext != null){
			patient_id = patientContext.getPatientId();
			facility_id = patientContext.getFacilityId();
			locale = patientContext.getLocale();
			location_code = patientContext.getLocationCode();
			patient_class = patientContext.getPatientClass();
			
			try{
				String patient_name;
				String age;
				String Sex;
				String location_desc;
				String print_date_time;
				String regn_date;
				String date_of_birth;
				String mar_status;
				String nationality;
				String res_area_code;
				String res_town_desc;
				String relgn;
				String name_prefix;
				String region_code;
				String facility_name;
				String res_addr;
				String blood_grp;
				String rh_factor;
				String national_id;
				
				
				
				String strPatInfoQuery = "select patient_name patient_name,get_age(date_of_birth) patient_age,Sex Gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,CASE WHEN ? IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(?,?,?,'1') ELSE OP_GET_DESC.OP_CLINIC(?,?,?,'1')  END LOCN_DESC , to_Char(REGN_DATE,'dd/mm/yyyy') REGN_DATE,to_Char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH, mp_get_desc.MP_MARITAL_STATUS(MAR_STATUS_CODE,?,2) MAR_STATUS, mp_get_desc.MP_COUNTRY(NATIONALITY_CODE,?,2) NATIONALITY ,mp_get_desc.MP_RES_AREA(RES_AREA_CODE,?,2) RES_AREA_CODE,RES_TOWN_DESC,mp_get_desc.MP_RELIGION(RELGN_CODE,?,2) RELGN ,NAME_PREFIX,mp_get_desc.MP_REGION(REGION_CODE,?,2) REGION_CODE,sm_get_desc.SM_FACILITY_PARAM(?,?,1) FACILITY_NAME,b.ADDR1_LINE1||','||b.ADDR1_LINE2||','||b.ADDR1_LINE3||','||b.ADDR1_LINE4 res_addr,c.BLOOD_GRP ,c.RH_FACTOR,a.NATIONAL_ID_NO from mp_patient a,MP_PAT_ADDRESSES b,MP_PAT_OTH_DTLS c where a.PATIENT_ID = b.PATIENT_ID and a.PATIENT_ID = c.PATIENT_ID and a.patient_id = ?";//IN043083
				con = createConnection();
				if(con!=null){
					pstmt	= con.prepareStatement(strPatInfoQuery);
					pstmt.setString(1,patient_class);
					pstmt.setString(2,facility_id);
					pstmt.setString(3,location_code);
					pstmt.setString(4,locale);
					pstmt.setString(5,facility_id);
					pstmt.setString(6,location_code);
					pstmt.setString(7,locale);//
					pstmt.setString(8,locale);//
					pstmt.setString(9,locale);//
					pstmt.setString(10,locale);//
					pstmt.setString(11,locale);//
					pstmt.setString(12,locale);//
					pstmt.setString(13,facility_id);//
					pstmt.setString(14,locale);//
					pstmt.setString(15,patient_id);
					rs = pstmt.executeQuery();
	
					while(rs.next())
					{
						patient_name = rs.getString("patient_name")==null?"":rs.getString("patient_name");
						age = rs.getString("patient_age")==null?"":rs.getString("patient_age");
						Sex = rs.getString("Gender")==null?"":rs.getString("Gender");
						location_desc = rs.getString("LOCN_DESC")==null?"":rs.getString("LOCN_DESC");
						print_date_time = rs.getString("print_date_time")==null?"":rs.getString("print_date_time");
						regn_date = rs.getString("regn_date")==null?"":rs.getString("regn_date");
						date_of_birth = rs.getString("date_of_birth")==null?"":rs.getString("date_of_birth");
						mar_status = rs.getString("mar_status")==null?"":rs.getString("mar_status");
						nationality = rs.getString("nationality")==null?"":rs.getString("nationality");
						res_area_code = rs.getString("res_area_code")==null?"":rs.getString("res_area_code");
						res_town_desc = rs.getString("res_town_desc")==null?"":rs.getString("res_town_desc");
						relgn = rs.getString("relgn")==null?"":rs.getString("relgn");
						name_prefix = rs.getString("name_prefix")==null?"":rs.getString("name_prefix");
						region_code = rs.getString("region_code")==null?"":rs.getString("region_code");		
						facility_name = rs.getString("FACILITY_NAME")==null?"":rs.getString("FACILITY_NAME");		
						res_addr = rs.getString("res_addr")==null?"":rs.getString("res_addr");		
						blood_grp = rs.getString("BLOOD_GRP")==null?"":rs.getString("BLOOD_GRP");		
						rh_factor = rs.getString("RH_FACTOR")==null?"":rs.getString("RH_FACTOR");		
						national_id = rs.getString("NATIONAL_ID_NO")==null?"":rs.getString("NATIONAL_ID_NO");	//IN043083
			

						/*if(Sex.equals("M") )
								Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
							else if(Sex.equals("F") )
								Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
							else
								Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

						if(patient_class.equals("OP"))
								patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
						else if(patient_class.equals("IP"))
								patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
						else if(patient_class.equals("EM"))
								patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
						else if(patient_class.equals("DC"))
								patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");*/

					}
						//setPatOutDetails
				}
				
				}
				catch(Exception ee)
				{
					System.out.println("Exceptioninget PatientHash method"+ee.toString());
					ee.printStackTrace();
				}
				finally
				{
					int conCloseFailure = closeConnection(con,pstmt,rs);
				}
		}
		return PatientHash;
	}
	
	
	
	
	public ClinicalNotesTemplateResponse getSectionTemplate(String secCode,PatContext patientContext ){
		ClinicalNotesTemplateResponse response = new ClinicalNotesTemplateResponse();
		
		ErrorInfo errorInfo;
		String locale="en";
		if(patientContext != null){
		locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
		StringBuffer contentXML = new StringBuffer();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			//ArrayList<ClinicalNotesTemplateField> secTemplateList = new ArrayList<ClinicalNotesTemplateField>();
			StringBuffer secTemplateQuery = new StringBuffer("");
			// from this query only notegroup Id is taken. The Query is same as that of EM so not done any chanegs 
			secTemplateQuery.append(" Select AGE_GRP_DEP_COMP_INFO,DEP_AGE_GRP_INFO,TEMPLATE_FORMAT from CA_SECTION_HDG where sec_hdg_code ='"+secCode+"' ");
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(secTemplateQuery.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String ageDependentCompIds;
						String compDependentAgeGrps;
						while(rs.next())
						{
							ClinicalNotesTemplateField oTemplateField = new ClinicalNotesTemplateField();
							ageDependentCompIds = rs.getString(1)==null?"":rs.getString(1); 
							compDependentAgeGrps = rs.getString(2)==null?"":rs.getString(2);
							Clob clb = rs.getClob(3);
							
							if(clb!=null)
							{
								java.io.BufferedReader r = new java.io.BufferedReader(clb.getCharacterStream());
								String line = null;

								while((line=r.readLine()) != null) 
								{
									contentXML.append(line);
								}
							}
							
							oTemplateField.setContentXML(contentXML);
							//secTemplateList.add(oTemplateField);
							//response.setTemplateLst(oTemplateField);
							response.setTemplateField(oTemplateField);
						}
						
						/*if(oTemplateField.size() <= 0){
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
								response.getErrorsList().add(errorInfo);
							}*/
						}
					}
		}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
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
		
		return response; 
	}
	
	public ClinicalNotesMapResponse getCreateNotesDefaultFilterValues(PatContext patientContext, String appl_task_id){
		ErrorInfo errorInfo;
		String locale="en";
		ClinicalNotesMapResponse response = new ClinicalNotesMapResponse();
		HashMap map = new HashMap();
		response.setMap(map);
		if(patientContext != null){
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			String resp_id = patientContext.getResponsibilityID();
			String practId = patientContext.getClinicianId();
			String default_sql = "SELECT count(*) existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b, SM_QUICK_LINK_LIST_LANG_VW c WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id = ? AND b.link_type = 'F' AND a.option_id = b.option_id AND b.option_id = ? AND c.eff_STATUS='E' AND c.LANGUAGE_ID = ? AND c.FUNCTION_SPEC_YN ='Y'";//changed for regression issue DineshT 2009-12-29
			Connection con = null;
			PreparedStatement stmtsql = null;
			ResultSet rs = null;
			try{
				con = createConnection();
				if(con != null){
					int Existance_Count = 0;
					stmtsql = con.prepareStatement(default_sql);
					stmtsql.setString(1,practId);
					stmtsql.setString(2,resp_id);
					stmtsql.setString(3,appl_task_id);
					stmtsql.setString(4,locale);
					rs = stmtsql.executeQuery();
					if(rs.next())
					{
						Existance_Count = rs.getInt("EXISTANCE_COUNT");
					}
					if(rs != null) rs.close();
					if(stmtsql != null) stmtsql.close();
					
					//get quick link ref number for pract or responsibility
					StringBuffer default_query = new StringBuffer();
					default_query.append("select A.QUICK_LINK_REF from ");
					if(Existance_Count>0)//changed for regression issue DineshT 2009-12-29
						default_query.append(" SM_QUICK_LINK_FOR_USER A where A.APPL_USER_ID = ? ");
					else
						default_query.append(" SM_QUICK_LINK_RESP A where A.RESP_ID = ? ");
					default_query.append(" and LINK_TYPE = 'F' and DEFAULT_YN = 'Y' and OPTION_ID=? ");
					
					stmtsql = con.prepareStatement(default_query.toString());
					if(Existance_Count >0)//changed for regression issue DineshT 2009-12-29
						stmtsql.setString(1,practId);
					else
						stmtsql.setString(1,resp_id);

						stmtsql.setString(2,appl_task_id);

					rs = stmtsql.executeQuery();
					String ql_ref = "";
					if(rs.next())
					{
						ql_ref = rs.getString(1) == null ? "" : rs.getString(1);
					}

					if(stmtsql != null) stmtsql.close();
					if(rs != null) rs.close();
					
					if(!ql_ref.equals(""))
					{
						String sqlFilter = "select a.COLUMN_ID, (select COLUMN_DESC from SM_QUICK_LINK_CRITERIA where COLUMN_ID = a.COLUMN_ID AND OPTION_ID=?) COLUMN_DESC , a.VALUE_TYPE, a.ACTUAL_VALUE, a.DATETIME_RELATIVE_IND, a.DATETIME_RELATIVE_VAL, a.DATETIME_RELATIVE_UNIT, a.RELATIVE_FIELD_REF from SM_QUICK_LINK_DEFN a where QUICK_LINK_REF = ?";
						stmtsql = con.prepareStatement(sqlFilter);
						stmtsql.setString(1,appl_task_id);
						stmtsql.setString(2,ql_ref);
						rs = stmtsql.executeQuery();
						
						String column_id;
						String column_desc;
						String value_type;
						String actual_value;
						String date_time_rel_id;
						String date_time_rel_val; 
						String date_time_rel_unit;
						String relative_value;
						String final_value;
						while(rs.next())
						{
							column_id = rs.getString("COLUMN_ID") == null ? "" : rs.getString("COLUMN_ID");
							column_desc = rs.getString("COLUMN_DESC") == null ? "" : rs.getString("COLUMN_DESC");
							value_type = rs.getString("VALUE_TYPE") == null ? "" : rs.getString("VALUE_TYPE");
							actual_value = rs.getString("ACTUAL_VALUE") == null ? "" : rs.getString("ACTUAL_VALUE");
							date_time_rel_id = rs.getString("DATETIME_RELATIVE_IND") == null ? "" : rs.getString("DATETIME_RELATIVE_IND");
							date_time_rel_val = rs.getString("DATETIME_RELATIVE_VAL") == null ? "" : rs.getString("DATETIME_RELATIVE_VAL");
							date_time_rel_unit = rs.getString("DATETIME_RELATIVE_UNIT") == null ? "" : rs.getString("DATETIME_RELATIVE_UNIT");
							relative_value = rs.getString("RELATIVE_FIELD_REF") == null ? "" : rs.getString("RELATIVE_FIELD_REF");

							if(value_type.equals("A"))
								final_value = actual_value;
							else
							{
								if(column_id.equals("DATE_TIME"))
								{
									if(!date_time_rel_id.equals("") && !date_time_rel_val.equals("") && !date_time_rel_unit.equals("") && !relative_value.equals(""))
									{
										final_value = date_time_rel_id + "|" + date_time_rel_val + "|" + date_time_rel_unit + "|" + relative_value;
									}
									else
									{
										final_value = "";
									}
								}
								else
									final_value = relative_value;
							}

							map.put(column_id,final_value);

						}
						if(stmtsql != null) stmtsql.close();
						if(rs != null) rs.close();
					}
					String serviceCodeSql = "select service_code from pr_encounter where facility_id = ?  and     encounter_id = ?";
					String serviceCode = "";
					stmtsql = con.prepareStatement(serviceCodeSql);
					stmtsql.setString(1,patientContext.getFacilityId());
					stmtsql.setString(2,patientContext.getEncounterId());
					rs = stmtsql.executeQuery();
					while(rs.next())
					{
						serviceCode = rs.getString("service_code") == null ? "" : rs.getString("service_code");
						map.put("SERVICE_CODE",serviceCode);
					}
					
				}
					
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
				e.printStackTrace();
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
				int conCloseFailure = closeConnection(con,stmtsql,rs);
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		
		return response; 
		
	}
	
	
	public ClinicalNotesSectionListResponse getSectionListForNoteType(String note_type, String locale){
		
		ClinicalNotesSectionListResponse response = new ClinicalNotesSectionListResponse();
		ErrorInfo errorInfo;
		if(note_type != null && !note_type.equals("")){
			if(locale==null || locale.equals(""))
				locale = "en";
			ArrayList<ClinicalNotesSectionItem> clinicalNotesSectionItemList = new ArrayList<ClinicalNotesSectionItem>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			StringBuffer query_section_details = new StringBuffer();
			query_section_details.append("select sec_hdg_code,1 DOC_EXISTS,");
			query_section_details.append("case when ? = 'en' then replace(sec_hdg_desc,'''','') else ");
			query_section_details.append("replace(CA_GET_DESC.CA_SECTION_HDG(SEC_HDG_CODE ,? ,'1'),'''','') end sec_hdg_desc");
			query_section_details.append(",sec_content_type,sec_result_linked_rec_type,");
			query_section_details.append("NVL(child_sec_hdg_code,sec_hdg_code) child_sec_hdg_code, ");
			query_section_details.append("CASE 	WHEN CHILD_SEC_HDG_CODE = NULL THEN ''");
			query_section_details.append("ELSE case when ? = 'en' then replace(child_sec_hdg_desc,'''','') ");
			query_section_details.append("else replace(CA_GET_DESC.CA_SECTION_HDG(child_sec_hdg_code,?,'1'),'''','') ");
			query_section_details.append("end end child_sec_hdg_desc ");
			query_section_details.append(",child_sec_content_type, child_sec_result_link_rec_type, CHIEF_COMPLAINT_SEC_YN");
			query_section_details.append(",IMAGE_LINKED_YN,'Y' CONTENT_EDITABLE_YN");
			query_section_details.append(",nvl(child_sec_result_link_rec_type,sec_result_linked_rec_type) result_link_type");
			query_section_details.append(",nvl(child_sec_content_type,sec_content_type) content_type, OUTPUT_FORM_EXISTS_YN,SELECTION_TYPE ");  
			query_section_details.append("from ca_note_section_view where note_type = ?  order by note_sec_seq_num, child_seq_num");
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt =	con.prepareStatement(query_section_details.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					pstmt.setString(1,locale);
					pstmt.setString(2,locale);
					pstmt.setString(3,locale);
					pstmt.setString(4,locale);
					pstmt.setString(5,note_type);
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String sectionCode;
						String sectionDesc;
						String sectionContentType;
						String childSectionCode;
						String childSectionDesc;
						String childSectionContentType;
						String secResultLinkedRecType;
						String docExists;
						String childSecResultLinkRecType;
						String chiefComplaintSecYN;
						String imageLinkedYN;
						String contentEditableYN;
						String resultLinkType;
						String contentType;
						String outputFormExistsYN;
						String selectionType;
						while(rs.next())
						{
							docExists									=	checkForNull(rs.getString("DOC_EXISTS"));
							sectionCode								=	checkForNull( rs.getString("sec_hdg_code") );
							sectionDesc								=	checkForNull( rs.getString("sec_hdg_desc") );
							sectionContentType							=	checkForNull( rs.getString("sec_content_type") );
							secResultLinkedRecType					=	checkForNull( rs.getString("sec_result_linked_rec_type") );
							childSectionCode							=	checkForNull( rs.getString("child_sec_hdg_code") );
							childSectionDesc							=	checkForNull( rs.getString("child_sec_hdg_desc") );
							childSectionContentType						=	checkForNull( rs.getString("child_sec_content_type") );
							childSecResultLinkRecType				=	checkForNull( rs.getString("child_sec_result_link_rec_type") );
							chiefComplaintSecYN						=   checkForNull( rs.getString("chief_complaint_sec_yn") );
							imageLinkedYN								=   checkForNull( rs.getString("image_linked_yn") );
							contentEditableYN						=	checkForNull( rs.getString("CONTENT_EDITABLE_YN") );
							contentType								=	checkForNull( rs.getString("content_type") );
							resultLinkType							=	checkForNull( rs.getString("result_link_type") );
							outputFormExistsYN							=	rs.getString("OUTPUT_FORM_EXISTS_YN") ;
							selectionType							= rs.getString("SELECTION_TYPE")==null?"S":rs.getString("SELECTION_TYPE"); 	
							
							ClinicalNotesSectionItem clinicalNotesSectionItem = new ClinicalNotesSectionItem();
							clinicalNotesSectionItem.setDocExists(docExists);
							clinicalNotesSectionItem.setSectionCode(sectionCode);
							clinicalNotesSectionItem.setSectionDesc(sectionDesc);
							clinicalNotesSectionItem.setSectionContentType(sectionContentType);
							clinicalNotesSectionItem.setSecResultLinkedRecType(secResultLinkedRecType);
							clinicalNotesSectionItem.setChildSectionCode(childSectionCode);
							clinicalNotesSectionItem.setChildSectionDesc(childSectionDesc);
							clinicalNotesSectionItem.setChildSectionContentType(childSectionContentType);
							clinicalNotesSectionItem.setChildSecResultLinkRecType(childSecResultLinkRecType);
							clinicalNotesSectionItem.setChiefComplaintSecYN(chiefComplaintSecYN);
							clinicalNotesSectionItem.setImageLinkedYN(imageLinkedYN);
							clinicalNotesSectionItem.setContentEditableYN(contentEditableYN);
							clinicalNotesSectionItem.setContentType(contentType);
							clinicalNotesSectionItem.setResultLinkType(resultLinkType);
							clinicalNotesSectionItem.setOutputFormExistsYN(outputFormExistsYN);
							clinicalNotesSectionItem.setSelectionType(selectionType);
							clinicalNotesSectionItemList.add(clinicalNotesSectionItem);
							
						}
						response.setSectionList(clinicalNotesSectionItemList);
						if(clinicalNotesSectionItemList.size() <= 0){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}
						
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
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
		
		return response;
		
		
	}
	
	
	//Query taken from RecClinincalNotesHeader
	public ClinicalNotesMapResponse getNoteTypeSectionDetails(String resp_id, String p_note_type, String locale){
		
		ErrorInfo errorInfo;
		ClinicalNotesMapResponse response = new ClinicalNotesMapResponse();
		HashMap map = new HashMap();
		response.setMap(map);
		if(p_note_type != null && resp_id != null && locale != null){
			String query_section_details = "select b.event_class, b.serv_facl_spec_yn, A.privilege_type, b.note_type_desc, b.event_type_caption, b.security_level, b.event_date_caption, b.event_perf_by_caption, b.event_title_caption, b.event_auth_by_caption, b.event_status_caption, b.note_group_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time,b.DOC_LINKED_NOTE_YN from 	CA_NOTE_TYPE_FOR_RESP a,CA_NOTE_TYPE_lang_vw b ,SM_RESP C where C.resp_id = ? and A.note_type = ? and b.language_id = ? and	c.RESP_ID=A.RESP_ID	and	b.NOTE_TYPE=A.NOTE_TYPE	and	b.EFF_STATUS='E'";
			Connection con = null;
			PreparedStatement stmtsql = null;
			ResultSet rs = null;
			try{
				con = createConnection();
				if(con != null){
					stmtsql = con.prepareStatement(query_section_details);
					stmtsql.setString(1, resp_id);
					stmtsql.setString(2, p_note_type);
					stmtsql.setString(3, locale);
					rs = stmtsql.executeQuery();
					if(rs.next())
					{
						map.put("event_class", checkForNull(rs.getString("event_class")));
						map.put("serv_facl_spec_yn", checkForNull(rs.getString("serv_facl_spec_yn")));
						map.put("privilege_type", checkForNull(rs.getString("privilege_type")));
						map.put("note_type_desc", checkForNull(rs.getString("note_type_desc")));
						map.put("event_type_caption", checkForNull(rs.getString("event_type_caption")));
						map.put("security_level", checkForNull(rs.getString("security_level")));
						map.put("event_date_caption", checkForNull(rs.getString("event_date_caption")));
						map.put("event_perf_by_caption", checkForNull(rs.getString("event_perf_by_caption")));
						map.put("event_title_caption", checkForNull(rs.getString("event_title_caption")));
						map.put("event_title_desc", checkForNull(rs.getString("event_title_caption")));
						map.put("event_auth_by_caption", checkForNull(rs.getString("event_auth_by_caption")));
						map.put("event_status_caption", checkForNull(rs.getString("event_status_caption")));
						map.put("event_status_caption", checkForNull(rs.getString("event_status_caption")));
						map.put("doc_linked_note_yn", checkForNull(rs.getString("DOC_LINKED_NOTE_YN")));
					}
					if(rs != null) rs.close();
					if(stmtsql != null) stmtsql.close();
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching section details" +e);
				e.printStackTrace();
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
				int conCloseFailure = closeConnection(con,stmtsql,rs);
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		if(map.isEmpty()){
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.CLINICALNOTES_EMPTY_DATA,locale);
			response.getErrorsList().add(errorInfo);
		}
		
		return response; 
		
	}
	public ClinicalNotesFieldResponse getFrequentlyUsedNoteTypes(PatContext patientContext){
		return getFrequentlyUsedNoteTypes(patientContext,10);
	}
	
	public ClinicalNotesFieldResponse getFrequentlyUsedNoteTypes(PatContext patientContext,int count){
		ClinicalNotesFieldResponse response = new ClinicalNotesFieldResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		if(patientContext != null){
			String practID = patientContext.getClinicianId();
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			ArrayList<ClinicalNotesFieldItem> noteTypeList = new ArrayList<ClinicalNotesFieldItem>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String freqQuery = "select note_count, aa.note_type,b.note_type_desc  from (select count(a.note_type) note_count ,a.note_type from ca_encntr_note a,  ca_note_type_for_resp c  where a.performed_by_id = ? and a.event_date_time >=sysdate-30  and c.resp_id = ? and a.note_type = c.note_type  and c.privilege_type != '5'  group by a.note_type ) aa, ca_note_type_lang_vw b where aa.note_type = b.note_type and b.language_id = ? AND b.NOTE_GROUP_ID IN (SELECT NOTE_GROUP  FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=? and EFF_STATUS='E' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y'  ) order by note_count desc";
			
			try{
				con = createConnection();
				System.out.println("FREQ_NOTES - This is the query::: " +freqQuery);
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(freqQuery);
					System.out.println("FREQ_NOTES-query parameters- practID: "+practID+" count: "+ count +" RespId: "+patientContext.getResponsibilityID()+"  PatClass: " + patientContext.getPatientClass());
					pstmt.setString(1, practID);
					pstmt.setString(2, patientContext.getResponsibilityID());
					pstmt.setString(3, locale);
					pstmt.setString(4, "CLINICAL_NOTES");
					pstmt.setString(5, patientContext.getPatientClass());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String note_type;
						String note_type_desc;
						ClinicalNotesFieldItem fieldItem;
						while(rs.next())
						{
							note_type = rs.getString("note_type")==null?"":rs.getString("note_type");
							note_type_desc = rs.getString("note_type_desc")==null?"":rs.getString("note_type_desc");
							fieldItem = new ClinicalNotesFieldItem();
							fieldItem.setCode(note_type);
							fieldItem.setDesc(note_type_desc);
							noteTypeList.add(fieldItem);
						}
						System.out.println("FREQ_NOTES-count of Freq Notes :: " +noteTypeList.size());
						response.setFieldList(noteTypeList);
					}
				}
			}
			catch(SQLException e){
				System.out.println("FREQ_NOTES-A database exception occurred while fetching frequently accessed notes" +e);
				e.printStackTrace();
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				System.out.println("FREQ_NOTES-A database exception occurred while fetching frequently accessed notes" +e);
				e.printStackTrace();
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
		}
		else{
			System.out.println("FREQ_NOTES-Invalide Patient Context");
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		
		return response;
	}
	
	public ClinicalNotesFieldResponse getCannedTextList(PatContext patientContext,String note_type, String sec_hdg_code, String service_code, String text_type ){
		ClinicalNotesFieldResponse response = new ClinicalNotesFieldResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		if(patientContext != null){
			String practID = patientContext.getClinicianId();
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			ArrayList<ClinicalNotesFieldItem> cannedTextList = new ArrayList<ClinicalNotesFieldItem>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			StringBuffer cannedTextQuery;
			if(text_type!=null && text_type.equals("E")){
				
			}
			else if(text_type!=null && text_type.equals("T")){
				
			}
			cannedTextQuery = new StringBuffer("");
			
			cannedTextQuery.append("Select text_blk_id, decode(text_type,'E',CA_GET_DESC.CA_TEXT_CLOB_BLK_BY_SERV_PRACT(text_blk_id,'en','1'), 'T', CA_GET_DESC.CA_TEXT_BLK_BY_SERV_PRACT(text_blk_id,'en','1')) text_blk, text_type	from ca_text_blk_by_serv_pract where  nvl( practitioner_id, ? ) = ? ");
			
			if(note_type != null && !note_type.equals(""))
				cannedTextQuery.append(" and nvl(note_type, ?) = ? ");
			if(sec_hdg_code != null && !sec_hdg_code.equals(""))
				cannedTextQuery.append(" and nvl(sec_hdg_code, nvl(?,'***')) = nvl(?,'***') ");
			if(service_code!= null && !service_code.equals(""))
				cannedTextQuery.append(" and nvl(service_code, ? ) = ? ");
			if(text_type != null && !text_type.equals(""))
				cannedTextQuery.append(" and nvl(text_type, ? )  = ? ");
			
			cannedTextQuery.append(" and APPLICABLE_CATEGORY='N' AND text_blk IS NOT NULL AND EFF_STATUS='E' ORDER BY text_blk_id ");
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(cannedTextQuery.toString());
					int i=1;
					/*pstmt.setString(i,locale);
					i=i+1;
					pstmt.setString(i,locale);
					i=i+1;*/
					pstmt.setString(i++,practID);
					pstmt.setString(i++,practID);
					if(note_type != null && !note_type.equals("")){
						pstmt.setString(i++,note_type);						
						pstmt.setString(i++,note_type);						
					}
					
					if(sec_hdg_code != null && !sec_hdg_code.equals("")){
						pstmt.setString(i++,sec_hdg_code);						
						pstmt.setString(i++,sec_hdg_code);						
					}
					
					if(service_code != null && !service_code.equals("")){						
						pstmt.setString(i++,service_code);
						pstmt.setString(i++,service_code);
					}
					
					if(text_type != null && !text_type.equals("")){						
						pstmt.setString(i++,text_type);
						pstmt.setString(i++,text_type);						
					}
					
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						//String note_type;
						String text_blk_id;
						String text_blk;
						String text_blk_type;
						ClinicalNotesFieldItem fieldItem; 
						while(rs.next())
						{
							text_blk_id = rs.getString("text_blk_id")==null?"":rs.getString("text_blk_id");
							text_blk = rs.getString("text_blk")==null?"":rs.getString("text_blk");
							text_blk_type = rs.getString("text_type")==null?"":rs.getString("text_type");
							fieldItem = new ClinicalNotesFieldItem();
							//fieldItem.setCode(note_type);
							fieldItem.setCode(text_blk_id);
							fieldItem.setDesc(text_blk);
							fieldItem.setDetail(text_blk_type);
							cannedTextList.add(fieldItem);
						}
						response.setFieldList(cannedTextList);
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching frequently accessed notes" +e);
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
		
		return response;
	}
	public ClinicalNotesFieldResponse getPractitionerList(PatContext patientContext, String note_type){
		ClinicalNotesFieldResponse response = new ClinicalNotesFieldResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		if(patientContext != null){
			String practID = patientContext.getClinicianId();
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			ArrayList<ClinicalNotesFieldItem> noteTypeList = new ArrayList<ClinicalNotesFieldItem>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String pracListQuery = "select  distinct a.practitioner_id code, b.practitioner_name description from am_pract_for_facility a, am_practitioner_lang_vw b, ca_note_type_for_resp ib, sm_appl_user ia, sm_resp_for_user ic where ib.note_type = ? and ib.privilege_type in ('3','4','5') and ia.appl_user_id = ic.appl_user_id and ic.resp_id = ib.resp_id and ia.eff_status = 'E' and  a.practitioner_id=ia.func_role_id and b.language_id = ? and b.practitioner_id = a.practitioner_id and a.practitioner_id != ? and a.eff_status = 'E' ORDER BY 2";
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(pracListQuery);
					
					pstmt.setString(1, note_type);
					pstmt.setString(2, locale);
					pstmt.setString(3, practID);
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String pract_id;
						String pract_desc;
						ClinicalNotesFieldItem fieldItem;
						while(rs.next())
						{
							pract_id = rs.getString("code")==null?"":rs.getString("code");
							pract_desc = rs.getString("description")==null?"":rs.getString("description");
							fieldItem = new ClinicalNotesFieldItem();
							fieldItem.setCode(pract_id);
							fieldItem.setDesc(pract_desc);
							noteTypeList.add(fieldItem);
						}
						response.setFieldList(noteTypeList);
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching practitioner list" +e);
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
		
		return response;
	}
	
	public ClinicalNotesFieldResponse getForwardNotesSpecialityList(PatContext patientContext){
		ClinicalNotesFieldResponse response = new ClinicalNotesFieldResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		if(patientContext != null){
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			ArrayList<ClinicalNotesFieldItem> noteTypeList = new ArrayList<ClinicalNotesFieldItem>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String specialityListQuery = "Select speciality_code, short_desc speciality_desc from am_speciality_lang_vw where EFF_STATUS = 'E' and language_id = ? ORDER BY 2";
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(specialityListQuery);
					pstmt.setString(1, locale);
					
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String spec_id;
						String spec_desc;
						ClinicalNotesFieldItem fieldItem;
						while(rs.next())
						{
							spec_id = rs.getString("SPECIALITY_CODE")==null?"":rs.getString("SPECIALITY_CODE");
							spec_desc = rs.getString("SPECIALITY_DESC")==null?"":rs.getString("SPECIALITY_DESC");
							fieldItem = new ClinicalNotesFieldItem();
							fieldItem.setCode(spec_id);
							fieldItem.setDesc(spec_desc);
							noteTypeList.add(fieldItem);
						}
						response.setFieldList(noteTypeList);
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching speciality list" +e);
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
		
		return response;
	}
	
	public ClinicalNotesTransactionResponse validateNotePreSelection(PatContext patientContext, String noteType){
		
		ClinicalNotesTransactionResponse response = new ClinicalNotesTransactionResponse();
		String locale = "en";
		String transactionMessage;
		if(patientContext != null){
			
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			String encounterId = patientContext.getEncounterId();
			String facilityId = patientContext.getFacilityId();
			String patient_class = patientContext.getPatientClass();
			String patientId = patientContext.getPatientId();
			String respId = patientContext.getResponsibilityID();
			ArrayList<ClinicalNotesFieldItem> noteTypeList = new ArrayList<ClinicalNotesFieldItem>();
			ClinicalNotesMapResponse mapResp = getNoteTypeSectionDetails(respId, noteType,locale);
			HashMap map = mapResp.getMap();
			String privilege_type = (String)map.get("privilege_type");
			if(privilege_type!=null && !privilege_type.equals("1")){
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String specialityListQuery = "select NO_OF_REC_PER_ENC,ROLE_BASED_ACCESS_YN,PRE_COND_FOR_REC from ca_note_group where NOTE_GROUP=(select note_group_id from ca_note_type where note_type= ?)";
				try{
					con = createConnection();
					if(con == null){
						response.setTransactionResult(response.TRANSACTION_RESULT_FAILURE);
						transactionMessage = "Problem in choosing the note. Please try again later";
						response.setTransactionMessage(transactionMessage);
					}
					else{
						
						response.setTransactionResult(response.TRANSACTION_RESULT_SUCCESS);
						transactionMessage = "SUCCESS";
						response.setTransactionMessage(transactionMessage);
						
						pstmt=con.prepareStatement(specialityListQuery);
						pstmt.setString(1, noteType);
						
						rs = pstmt.executeQuery();
						if(rs == null){
							response.setTransactionResult(response.TRANSACTION_RESULT_FAILURE);
							transactionMessage = "Problem in choosing the note. Please try again later";
							response.setTransactionMessage(transactionMessage);
						}
						else{
							int no_of_rec_per_enc = 0;
							String role_based_access_yn = "";
							String pre_cond_for_rec = "";
							if(rs.next()){
								no_of_rec_per_enc = rs.getInt("NO_OF_REC_PER_ENC");
								role_based_access_yn = rs.getString("ROLE_BASED_ACCESS_YN")==null?"":rs.getString("ROLE_BASED_ACCESS_YN");
								pre_cond_for_rec = rs.getString("PRE_COND_FOR_REC")==null?"":rs.getString("PRE_COND_FOR_REC");
								
								if(no_of_rec_per_enc>0){
									String max_enc_query = "select count(*) count_note from ca_encntr_note where encounter_id = ? and facility_id=? and note_type = ? and event_status in ('1','2','3','4','5') ";
									PreparedStatement pstmt_maxenc = con.prepareStatement(max_enc_query);
									pstmt_maxenc.setString(1, encounterId);
									pstmt_maxenc.setString(2, facilityId);
									pstmt_maxenc.setString(3, noteType);
									ResultSet rs_maxenc = pstmt_maxenc.executeQuery();
									
									if(rs_maxenc == null){
										response.setTransactionResult(response.TRANSACTION_RESULT_FAILURE);
										transactionMessage = "Problem in choosing the note. Please try again later";
										response.setTransactionMessage(transactionMessage);
									}else{
										if(rs_maxenc.next()){
											int notesCount = rs_maxenc.getInt("count_note");
											if(notesCount >= no_of_rec_per_enc){
												response.setTransactionResult(response.TRANSACTION_RESULT_FAILURE);
												transactionMessage = "Cannot create a new note for this note type as the allowed number of records per encounter is reached";
												response.setTransactionMessage(transactionMessage);
											}else{
												response.setTransactionResult(response.TRANSACTION_RESULT_SUCCESS);
												transactionMessage = "SUCCESS";
												response.setTransactionMessage(transactionMessage);
											}
										}else{
											response.setTransactionResult(response.TRANSACTION_RESULT_FAILURE);
											transactionMessage = "Problem in choosing the note. Please try again later";
											response.setTransactionMessage(transactionMessage);
										}
									}
									closeConnection(pstmt_maxenc);
									closeConnection(rs_maxenc);
								}
								if(response.getTransactionResult() == response.TRANSACTION_RESULT_SUCCESS){
									if(pre_cond_for_rec.equals("D") && (patient_class.equals("IP") || patient_class.equals("DC"))){
										String discharge_query = "select 1 from ip_discharge_advice where facility_id =? and  encounter_id=? and DIS_ADV_STATUS in ('0','1')";
										PreparedStatement pstmt_discharge = con.prepareStatement(discharge_query);
										pstmt_discharge.setString(1, facilityId);
										pstmt_discharge.setString(2, encounterId);
										ResultSet rs_discharge = pstmt_discharge.executeQuery();
										
										if(rs_discharge == null){
											response.setTransactionResult(response.TRANSACTION_RESULT_FAILURE);
											transactionMessage = "Problem in choosing the note. Please try again later";
											response.setTransactionMessage(transactionMessage);
										}else{
											if(rs_discharge.next()){
												response.setTransactionResult(response.TRANSACTION_RESULT_SUCCESS);
												transactionMessage = "SUCCESS";
												response.setTransactionMessage(transactionMessage);
											}else{
												response.setTransactionResult(response.TRANSACTION_RESULT_FAILURE);
												transactionMessage = "Cannot create a new note for this note type as discharge advice is not yet prepared for this admission";
												response.setTransactionMessage(transactionMessage);
											}
										}
										closeConnection(pstmt_discharge);
										closeConnection(rs_discharge);
									}else if(pre_cond_for_rec.equals("E")){
										String deceased_query = "SELECT CASE WHEN  INSTALL_YN = 'Y' THEN (SELECT 'Y' FROM MR_DEATH_REGISTER_HDR WHERE PATIENT_ID=?) ELSE (select DECEASED_YN from mp_patient where patient_id=? and DECEASED_YN='Y') END deceased FROM SM_MODULE WHERE MODULE_ID='AE'";
										PreparedStatement pstmt_deceased = con.prepareStatement(deceased_query);
										pstmt_deceased.setString(1, patientId);
										pstmt_deceased.setString(2, patientId);
										ResultSet rs_deceased = pstmt_deceased.executeQuery();
										
										if(rs_deceased == null){
											response.setTransactionResult(response.TRANSACTION_RESULT_FAILURE);
											transactionMessage = "Problem in choosing the note. Please try again later";
											response.setTransactionMessage(transactionMessage);
										}else{
											if(rs_deceased.next()){
												String deceasedYN = rs_deceased.getString("deceased") == null?"N":rs_deceased.getString("deceased");
												if(deceasedYN.equals("Y")){
													response.setTransactionResult(response.TRANSACTION_RESULT_SUCCESS);
													transactionMessage = "SUCCESS";
													response.setTransactionMessage(transactionMessage);
												}else{
													response.setTransactionResult(response.TRANSACTION_RESULT_FAILURE);
													transactionMessage = "Cannot create a new note as this note type is configured for deceased patients";
													response.setTransactionMessage(transactionMessage);
												}
											}else{
												response.setTransactionResult(response.TRANSACTION_RESULT_FAILURE);
												transactionMessage = "Cannot create a new note as this note type is configured for deceased patients";
												response.setTransactionMessage(transactionMessage);
											}
										}
										closeConnection(pstmt_deceased);
										closeConnection(rs_deceased);
									}
								}
								
							}else{
								response.setTransactionResult(response.TRANSACTION_RESULT_FAILURE);
								transactionMessage = "Problem in choosing the note. Please try again later";
								response.setTransactionMessage(transactionMessage);
							}
						}
					}
				}
				catch(SQLException e){
					System.out.println("A database exception occurred while fetching db data" +e);
					response.setTransactionResult(response.TRANSACTION_RESULT_FAILURE);
					transactionMessage = "Problem in choosing the note. Please try again later";
					response.setTransactionMessage(transactionMessage);
				}
				catch(Exception e){
					response.setTransactionResult(response.TRANSACTION_RESULT_FAILURE);
					transactionMessage = "Problem in choosing the note. Please try again later";
					response.setTransactionMessage(transactionMessage);
				}
				finally{
					int conCloseFailure = closeConnection(con,pstmt,rs);
				}
			}else{
				response.setTransactionResult(response.TRANSACTION_RESULT_FAILURE);
				transactionMessage = "You do not have the privilege to record this note. Please contact system administrator";
				response.setTransactionMessage(transactionMessage);
			}
		}
		else{
			response.setTransactionResult(response.TRANSACTION_RESULT_FAILURE);
			transactionMessage = "Problem in choosing the note. Please try again later";
			response.setTransactionMessage(transactionMessage);
		}
			
		
		return response;
	}
	
	
	public ClinicalNotesFieldResponse getAllFilterNoteTypes(PatContext patientContext){
		ClinicalNotesFieldResponse response = new ClinicalNotesFieldResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		if(patientContext != null){
			String practID = patientContext.getClinicianId();
			String patientClass = patientContext.getPatientClass();
			locale = patientContext.getLocale();
			String respId = patientContext.getResponsibilityID();
			
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			ArrayList<ClinicalNotesFieldItem> noteTypeList = new ArrayList<ClinicalNotesFieldItem>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			StringBuffer allNoteTypesQuery;
			allNoteTypesQuery = new StringBuffer("");
			allNoteTypesQuery.append("Select distinct a.note_type, replace(c.note_type_desc,'''','') note_type_desc,  'N' as speciality_yn, '' as speciality_code, '' as speciality_name from ca_note_type_for_resp a , ");
			allNoteTypesQuery.append(" ca_note_type_lang_vw c where a.resp_id = ? and a.note_type = c.note_type and c.language_id = ? and a.privilege_type != '5' and ");
			allNoteTypesQuery.append(" decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");
			allNoteTypesQuery.append(" AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID in ('CLINICAL_NOTES','DISCHARGE_SUMMARY')) ");
			allNoteTypesQuery.append(" and  a.note_type not in (select note_type_id from ca_note_type_for_resource where resource_type = 'S' and RESOURCE_CODE in ");
			allNoteTypesQuery.append(" (SELECT PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=? UNION SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE PRACTITIONER_ID= ?)) ");
			allNoteTypesQuery.append(" UNION ");
			allNoteTypesQuery.append(" Select distinct a.note_type_id note_type, replace(c.note_type_desc,'''','') note_type_desc,'Y' as speciality_yn, a.RESOURCE_CODE speciality_code, ");
			allNoteTypesQuery.append(" am_get_desc.AM_SPECIALITY(a.RESOURCE_CODE,?,'2') speciality_name from ca_note_type_for_resource a , ca_note_type_lang_vw c ");
			allNoteTypesQuery.append(" where a.resource_type='S'  and a.RESOURCE_CODE in (SELECT PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=? UNION SELECT SPECIALITY_CODE FROM ");
			allNoteTypesQuery.append(" AM_PRACT_SPECIALITIES WHERE PRACTITIONER_ID= ?)   and a.note_type_id = c.note_type and c.language_id =? and ");
			allNoteTypesQuery.append(" decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND ");
			allNoteTypesQuery.append(" EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )   	AND c.NOTE_GROUP_ID");
			allNoteTypesQuery.append("  IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID in ('CLINICAL_NOTES', 'DISCHARGE_SUMMARY'))  ");
			allNoteTypesQuery.append(" order by  3, 2 ");
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(allNoteTypesQuery.toString());
					int i=1;
					pstmt.setString(i++,respId);
					pstmt.setString(i++,locale);
					pstmt.setString(i++,patientClass);
					pstmt.setString(i++,practID);
					pstmt.setString(i++,practID);
					pstmt.setString(i++,locale);
					pstmt.setString(i++,practID);
					pstmt.setString(i++,practID);
					pstmt.setString(i++,locale);
					pstmt.setString(i++,patientClass);
					pstmt.setString(i++,respId);
					
					
					
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						//String note_type;
						String note_type;
						String note_type_desc;
						String speciality_yn;
						String speciality_name;
						String speciality_code;
						ClinicalNotesFieldItem fieldItem; 
						while(rs.next())
						{
							fieldItem = new ClinicalNotesFieldItem();
							note_type = rs.getString("note_type")==null?"":rs.getString("note_type");
							fieldItem.setCode(note_type);
							note_type_desc = rs.getString("note_type_desc")==null?"":rs.getString("note_type_desc");
							fieldItem.setDesc(note_type_desc);
							speciality_yn = rs.getString("speciality_yn")==null?"":rs.getString("speciality_yn");
							if(speciality_yn.equals("Y")){
								speciality_name = rs.getString("speciality_name")==null?"":rs.getString("speciality_name");
								speciality_code = rs.getString("speciality_code")==null?"":rs.getString("speciality_code");
								fieldItem.setDetail(speciality_name);
								fieldItem.setDetail2(speciality_code);
							}
							noteTypeList.add(fieldItem);
						}
						response.setFieldList(noteTypeList);
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching frequently accessed notes" +e);
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
		
		return response;
	}
	
	//RecClinicalNotesSearchResult.jsp
	public ClinicalNotesMapResponse getApplicableNoteOperations(PatContext patientContext, String accession_num){
		ErrorInfo errorInfo;
		ClinicalNotesMapResponse response = new ClinicalNotesMapResponse();
		HashMap map = new HashMap();
		response.setMap(map);
		String operations_allowed;
		String ammendment_type;
		String event_status_code;
		String locale = "en";
		if(patientContext != null && accession_num != null && !accession_num.equals("")){
			StringBuffer applicableOperationsQuery;
			String loggedinUser = patientContext.getLoggedInUser();
			String practId = patientContext.getClinicianId();
			String respId = patientContext.getResponsibilityID();
			locale = patientContext.getLocale();
			applicableOperationsQuery = new StringBuffer("");
			applicableOperationsQuery.append("select CA_GET_APPL_NOTE_OPERN( a.facility_id,  a.accession_num, ?, ?, a.note_type, ? , 'N','N','N','N') operations_allowed, b.ammendment_type ammendment_type, a.event_status from ca_encntr_note a, ca_note_type b where a.accession_num = ? and a.note_type = b.note_type");
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				con = createConnection();
				if(con != null){
					pstmt = con.prepareStatement(applicableOperationsQuery.toString());
					int i=1;
					pstmt.setString(i++,respId);
					pstmt.setString(i++,practId);
					pstmt.setString(i++,loggedinUser);
					pstmt.setString(i++,accession_num);
					rs = pstmt.executeQuery();
					if(rs.next())
					{
						operations_allowed = rs.getString("operations_allowed")==null?"":rs.getString("operations_allowed");
						ammendment_type = rs.getString("ammendment_type")==null?"":rs.getString("ammendment_type");
						event_status_code = rs.getString("event_status")==null?"":rs.getString("event_status");
						map.put("operations_allowed", operations_allowed);
						map.put("ammendment_type", ammendment_type);
						map.put("event_status_code", event_status_code);
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching section details" +e);
				e.printStackTrace();
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
		if(map.isEmpty()){
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.CLINICALNOTES_EMPTY_DATA,locale);
			response.getErrorsList().add(errorInfo);
		}
		
		return response; 
		
	}
	
	
	private static String[] construct(String sqlQuery)
	{
		StringBuffer temp = new StringBuffer(sqlQuery);
		String retVal[];
		int count = 0;
		if(temp.indexOf("$$") == temp.lastIndexOf("$$"))
			retVal = new String[2];
		else
		{
			int start_index = 0;
			while (true)
			{
				start_index = temp.indexOf("$$", start_index);
				if(start_index == -1)
					break;
				else
				{
					count++;
					start_index += 2;
				}
			}
			retVal = new String[count+1];
		}

		count = 1;
		while(temp.indexOf("$$") != -1)
		{
			int start_index = temp.indexOf("$$");
			int end_index = temp.indexOf("##");
			String paramValue = temp.substring(start_index+2, end_index);
			temp.replace(start_index, end_index+2, "?");

			retVal[count] = paramValue;
			count++;
		}
		retVal[0] = temp.toString();

		return retVal;
	}
	
	
	public ArrayList<ClinicalNotesFieldItem> getSfsRecordDeatils(String Querys,PatContext patientContext) {
		
		
		
	

		ArrayList<ClinicalNotesFieldItem> allResult= new ArrayList<ClinicalNotesFieldItem>();


		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		String locale = "en";
		String sqlStr = Querys;
		String retVal[] = null;
	


		try {
			connection = ConnectionManager.getConnection();
			if (connection != null) {
				stmt = connection.createStatement();
			}
			if (resultSet != null) {
				resultSet.close();
			}

		
			
			
			if((sqlStr.indexOf("$$") != -1)&&(sqlStr.indexOf("##") != -1))
			{
					retVal = construct(sqlStr);
					int setStringCount = 1;
					pstmt = connection.prepareStatement(retVal[0]);
					
					System.out.println("querys"+pstmt);
					for(int i=1;i<retVal.length;i++)
					{
						String param = retVal[i];
							if(param.equals("PATIENT_ID"))
							pstmt.setString(setStringCount++, patientContext.getPatientId());
						else if(param.equals("ENCOUNTER_ID"))
							pstmt.setString(setStringCount++, patientContext.getEncounterId());
						else if(param.equals("FACILITY_ID"))
							pstmt.setString(setStringCount++, patientContext.getFacilityId());	
						else if(param.equals("SPECIALITY_CODE"))
							pstmt.setString(setStringCount++, patientContext.getFacilityId());	
						else if(param.equals("MAST_TYPE_REF"))
							pstmt.setString(setStringCount++, "");	
						else if(param.equals("LANGUAGE_ID"))
							pstmt.setString(setStringCount++,patientContext.getLocale());	
					}
			}
			else
				pstmt = connection.prepareStatement(sqlStr);
			

			resultSet = pstmt.executeQuery();


			if (resultSet != null) {

				while (resultSet.next()) {

					System.out.println("Inside Result set"+resultSet);
					ClinicalNotesFieldItem reds= new ClinicalNotesFieldItem();
					ResultSetMetaData rsmd = resultSet.getMetaData();
					String SPECIALITY_CODE = resultSet.getString(rsmd.getColumnName(1));
					String SHORT_DESC = resultSet.getString(rsmd.getColumnName(2));
					
					reds.setCode(SPECIALITY_CODE);
					reds.setDesc(SHORT_DESC);
					
					
					allResult.add(reds);
					
					

				} 
			}


		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {

			ConnectionManager.returnConnection(connection);
			// checkForIndicators=false;

		}

		
		return allResult;
		
		
	
		
	}

	/* (non-Javadoc)
	 * @see eIPAD.chartsummary.clinicalnotes.dao.ClinicalNotesDao#getRemarkDeatils(eIPAD.chartsummary.common.healthobject.PatContext)
	 */

	public ArrayList<JSONObject> getRemarkDeatils(String accessionNumber,String facilityId) {
		
		
	
		
		ArrayList<JSONObject> remark =new ArrayList<JSONObject>();
		
		
		

		String  messager = "" ;

		boolean checkForIndicators = false;

		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		String locale = "en";
		StringBuffer sqlStr = new StringBuffer("");

		
		String facility_id = facilityId;
		String accession_num = accessionNumber;
		
		
		
		
		sqlStr.append("SELECT ACTION_COMMENT FROM CA_ENCNTR_NOTE_AUDIT_LOG WHERE FACILITY_ID='"+facility_id+"' AND ACCESSION_NUM='"+accession_num+"' AND ACTION_TYPE='ER'");
	
		
		
		
		
		
		

		try {
			connection = ConnectionManager.getConnection();
			if (connection != null) {
				stmt = connection.createStatement();
			}
			if (resultSet != null) {
				resultSet.close();
			}

			if (stmt != null)
				resultSet = stmt.executeQuery(sqlStr.toString());

			if (resultSet != null) {

				while (resultSet.next()) {


			 messager = resultSet.getString("ACTION_COMMENT")==null?"":resultSet.getString("ACTION_COMMENT");
			 
			 

				} 
			}


		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {

			ConnectionManager.returnConnection(connection);
			// checkForIndicators=false;

		}

		
		 JSONObject obj = new JSONObject();

	      obj.put("message", messager);
	   
	      remark.add(obj);
	      
	      
	

	return remark;
		
		
		
	}

	public ClinicalNotesFieldItem getInerror(String accesionNumber,String lang) {
		// TODO Auto-generated method stub
	

	ClinicalNotesFieldItem reds= new ClinicalNotesFieldItem();
	String  messager = "" ;

	boolean checkForIndicators = false;

	Connection connection = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet resultSet = null;
	String locale = "en";
	StringBuffer sqlStr = new StringBuffer("");
	

	
	sqlStr.append("select distinct a.ADDED_DATE, to_char(a.action_date_time,'dd/mm/yyyy hh24:mi:ss') s_action_date_time, b.practitioner_name clinician_name, a.action_type,  action_status action_desc, dbms_lob.getlength(pre_amendment_note_content) clob_len,a.action_date_time,a.action_comment,d.practitioner_name requested_by_pract,to_char(REQUEST_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') requested_time, a.privilege_type, am_get_desc.AM_SPECIALITY(a.ACTION_BY_GROUP_CODE,'"+lang+"',2) spl_desc from ca_encntr_note_audit_log a, am_practitioner_lang_vw  b ,am_speciality_lang_vw c, am_practitioner_lang_vw d where b.practitioner_id(+) = a.action_by_id and c.speciality_code(+)=a.action_by_group_code and d.practitioner_id(+) = a.REQUEST_BY_ID /*and a.facility_id = ? */and a.accession_num = '"+accesionNumber+"'  and  b.language_id = '"+lang+"'  and  d.language_id(+) = '"+lang+"'  and a.action_type='ER' order by nvl(a.action_date_time,a.ADDED_DATE) desc,action_status desc,action_type desc");

	try {
		connection = ConnectionManager.getConnection();
		if (connection != null) {
			stmt = connection.createStatement();
		}
		if (resultSet != null) {
			resultSet.close();
		}

		if (stmt != null)
			resultSet = stmt.executeQuery(sqlStr.toString());

		if (resultSet != null) {

			while (resultSet.next()) {			
				InErrorDetails inerror =new InErrorDetails();
				
		String action_date_time= resultSet.getString("s_action_date_time")==null?"":resultSet.getString("s_action_date_time");
        String clinician_name= resultSet.getString("clinician_name")==null?"":resultSet.getString("clinician_name");
		String action_desc= resultSet.getString("action_desc")==null?"":resultSet.getString("action_desc");
		String action_type= resultSet.getString("action_type")==null?"":resultSet.getString("action_type");
	
		
		
		reds.setCode(action_date_time);
		reds.setDesc(action_desc);
		reds.setDetail(clinician_name);
		reds.setDetail2(action_type);
		
		
		
		 
	
			} 
		}


	} catch (Exception e) {
		e.printStackTrace();
		try {
			throw e;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	} finally {

		ConnectionManager.returnConnection(connection);
		// checkForIndicators=false;

	}


	
		return reds;
	}
}

