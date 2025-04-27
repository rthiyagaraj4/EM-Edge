/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD;
import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;
import javax.servlet.*;
import javax.servlet.http.*;
import eIPAD.HealthObjects.* ;
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.util.*;

public class NotesDetail implements java.io.Serializable {
	public List<Notes> getNotes(PatientContext oPatientContext) throws Exception {
		List<Notes> oNotesList = new ArrayList<Notes>() ;
		if(oPatientContext != null && oPatientContext.request != null)
		{
			Connection connection 		= null;
			Statement stmt				= null;
			ResultSet resultSet 			= null;
			String locale = "en";
			StringBuffer sqlStr = new StringBuffer("");
			String facility_id= ""; //(String)session.getValue("facility_id");
			String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
			String strPracType = "";
			String strPatientId = "";
			String strEncounterId = "";
			String strTodate = "";
			String strFromDate = "";
			String strPostBack = "";
			String strInterval = "";
			String strEncounterChk = "";
			String userLogin = "";
			String respID = "CA"; // default value is assigned,
			HttpServletRequest request = oPatientContext.request;
			
			if(oPatientContext.sFacilityId  != null && !oPatientContext.sFacilityId.equals(""))
			{
				facility_id = oPatientContext.sFacilityId;
			}
			if(oPatientContext.sClinicianId != null && !oPatientContext.sClinicianId.equals("") )
			{
				clinicianId  = oPatientContext.sClinicianId;
			}
			if(oPatientContext.sPracType != null && !oPatientContext.sPracType.equals(""))
			{
				strPracType = oPatientContext.sPracType;
			}
			if(oPatientContext.sPatientId != null && !oPatientContext.sPatientId.equals(""))
			{
				strPatientId = oPatientContext.sPatientId;
			}
			if(oPatientContext.sEncounterId != null && !oPatientContext.sEncounterId.equals(""))
			{
				strEncounterId = oPatientContext.sEncounterId;
			}
			if(oPatientContext.responsibilityID != null && !oPatientContext.responsibilityID.equals(""))
			{
				respID = oPatientContext.responsibilityID;
			}
			if(oPatientContext.loggedInUser != null && !oPatientContext.loggedInUser.equals(""))
			{
				 userLogin = oPatientContext.loggedInUser;
			}
			strEncounterChk = oPatientContext.sEncounterCheck;
			strFromDate = oPatientContext.sFromDate;
			strTodate = oPatientContext.sTodate;
			/*
			sqlStr.append(" SELECT a.facility_id, a.accession_num, a.note_type, a.encounter_id, b.note_type_desc, a.service_code, a.event_status status, am_get_desc.am_service (a.service_code, '" + locale + "', '2') service_name, a.event_title_desc, TO_CHAR (a.event_date_time, 'dd/mm/yyyy HH24:MI') event_date_time, TO_CHAR (a.event_date_time, 'dd/mm/yyyy') event_date, TO_CHAR (a.event_date_time, 'HH24:MI') TIME, a.performed_by_id, d.practitioner_name performed_by_name, a.authorized_by_id, ");
			sqlStr.append(" e.practitioner_name authorized_by_name, ca_get_desc.ca_note_group (b.note_group_id, '" + locale +"', '1') note_group_desc, ca_get_appl_note_opern (a.facility_id, a.accession_num, 'CA', '" + clinicianId + "', a.note_type, '" + clinicianId + "' ) rights, ");
			sqlStr.append(" a.ext_image_appl_id FROM ca_encntr_note a, ca_note_type_lang_vw b, am_practitioner_lang_vw d, am_practitioner_lang_vw e WHERE a.contr_mod_accession_num IS NULL AND ( ca_get_appl_note_opern (a.facility_id, a.accession_num, 'CA', '" + clinicianId + "', a.note_type, '" + clinicianId + "' ) IS NOT NULL OR a.contr_mod_accession_num IS NOT NULL ) AND a.note_type = b.note_type ");
			sqlStr.append(" AND b.language_id = '" + locale + "' AND ( a.event_status IN ('3', '4', '5', '9') OR a.contr_mod_accession_num IS NOT NULL ) AND d.practitioner_id(+) = a.performed_by_id AND d.language_id(+) = '" + locale + "' AND e.practitioner_id(+) = a.authorized_by_id AND e.language_id(+) = '" + locale + "' AND a.patient_id = '" + strPatientId + "' AND a.event_status != 9 AND facility_id = '" + facility_id + "' AND a.event_date_time BETWEEN TO_DATE ('" + strFromDate + "', 'dd/mm/yyyy') AND TO_DATE ('"+ strTodate + "', 'dd/mm/yyyy') + .999 ");// ORDER BY b.note_type_desc, a.note_type ");
            */
			sqlStr.append(" SELECT a.facility_id, a.accession_num, a.note_type, a.encounter_id, b.note_type_desc, a.service_code, a.event_status status, am_get_desc.am_service (a.service_code, '" + locale + "', '2') service_name, a.event_title_desc, TO_CHAR (a.event_date_time, 'dd/mm/yyyy HH24:MI') event_date_time, TO_CHAR (a.event_date_time, 'dd/mm/yyyy') event_date, TO_CHAR (a.event_date_time, 'HH24:MI') TIME, a.performed_by_id, d.practitioner_name performed_by_name, a.authorized_by_id, ");
			sqlStr.append(" e.practitioner_name authorized_by_name, ca_get_desc.ca_note_group (b.note_group_id, '" + locale +"', '1') note_group_desc, ca_get_appl_note_opern (a.facility_id, a.accession_num, '"+ respID +"', '" + clinicianId + "', a.note_type, '" + userLogin + "' ) rights, ");
			sqlStr.append(" a.ext_image_appl_id FROM ca_encntr_note a, ca_note_type_lang_vw b, am_practitioner_lang_vw d, am_practitioner_lang_vw e WHERE a.contr_mod_accession_num IS NULL AND ( ca_get_appl_note_opern (a.facility_id, a.accession_num, '" + respID +"', '" + clinicianId + "', a.note_type, '" + userLogin + "' ) IS NOT NULL OR a.contr_mod_accession_num IS NOT NULL ) AND a.note_type = b.note_type ");
			sqlStr.append(" AND b.language_id = '" + locale + "' AND ( a.event_status IN ('2','3', '4', '5', '9') OR a.contr_mod_accession_num IS NOT NULL ) AND d.practitioner_id(+) = a.performed_by_id AND d.language_id(+) = '" + locale + "' AND e.practitioner_id(+) = a.authorized_by_id AND e.language_id(+) = '" + locale + "' AND a.patient_id = '" + strPatientId + "' AND a.event_status != 9 AND facility_id = '" + facility_id + "' AND a.event_date_time BETWEEN TO_DATE ('" + strFromDate + "', 'dd/mm/yyyy') AND TO_DATE ('"+ strTodate + "', 'dd/mm/yyyy') + .999 ");// ORDER BY b.note_type_desc, a.note_type ");
			if(strEncounterChk.equals("true"))
			{
				sqlStr.append(" AND a.encounter_id = '" + strEncounterId + "' ORDER BY b.note_type_desc, a.note_type, a.note_type,event_date_time desc ");
			}
			else
			{
				sqlStr.append(" ORDER BY b.note_type_desc, a.note_type, a.note_type,event_date_time desc");
			}
			
	
			
	
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					if (resultSet != null) 
					{
						resultSet.close();  
					}
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {
						Notes oNotes = new Notes();
						oNotes.sAccessNum = ((resultSet.getString("accession_num") != null) ?resultSet.getString("accession_num") : "") ;
						oNotes.sNoteTypeDesc = ((resultSet.getString("note_type_desc") != null) ?resultSet.getString("note_type_desc") : "") ;
						oNotes.sEventDateTime = ((resultSet.getString("event_date_time") != null) ?resultSet.getString("event_date_time") : "") ;
						oNotesList.add(oNotes);
				}
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( stmt != null ) stmt.close() ;
					 ConnectionManager.returnConnection(connection,request);
			 
			}
		}
		return oNotesList;
		
	}
    public NoteTypeResponse getNoteType(CreateNotesRequest oNotesRequest) throws Exception {
    	NoteTypeResponse oNoteTypeRes = new NoteTypeResponse();
    	List<NoteTypeHO> oNoteTypeList = new ArrayList<NoteTypeHO>();
    	
		if( oNotesRequest != null && oNotesRequest.getRequest() != null)
		{
			Connection connection 		= null;
			Statement stmt				= null;
			ResultSet resultSet 			= null;
			String locale = "en";
			StringBuffer sqlStr = new StringBuffer("");
			String facility_id= ""; //(String)session.getValue("facility_id");
			String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
			String strPracType = "";
			String strPatientId = "";
			String strEncounterId = "";
			String strTodate = "";
			String strFromDate = "";
			String strPostBack = "";
			String strInterval = "";
			String strFilterBy = "P";
			String strPatclass = "IP";
			String appTaskID = "CLINICAL_NOTES";
			String strRespId = "CA";
			HttpServletRequest request = oNotesRequest.getRequest();
			
			if( oNotesRequest.getFacilityId()  != null )
			{
				facility_id = oNotesRequest.getFacilityId() ;
			}
			if( oNotesRequest.getClinicianId() != null )
			{
				clinicianId  = oNotesRequest.getClinicianId();
			}
			if( oNotesRequest.getPracType() != null )
			{
				strPracType =  oNotesRequest.getPracType();
			}
			if( oNotesRequest.getPatientId() != null )
			{
				strPatientId = oNotesRequest.getPatientId();
			}
			if( oNotesRequest.getEncounterId() != null )
			{
				strEncounterId = oNotesRequest.getEncounterId();
			}
			if( oNotesRequest.getPatientClass() != null && !oNotesRequest.getPatientClass().equals(""))
			{
				strPatclass =  oNotesRequest.getPatientClass();
			}
			if( oNotesRequest.getFilterBy() != null && !oNotesRequest.getFilterBy().equals(""))
			{
				strFilterBy =  oNotesRequest.getFilterBy();
			}
			if( oNotesRequest.getApplTaskID() != null && !oNotesRequest.getApplTaskID().equals(""))
			{
				appTaskID = oNotesRequest.getApplTaskID();
			}
			if( oNotesRequest.getRespId() != null && !oNotesRequest.getRespId().equals(""))
			{
				strRespId = oNotesRequest.getRespId();
			}
			
			if(strFilterBy != null)
			{
				if(strFilterBy.equals("P"))
				{
					sqlStr.append(" SELECT DISTINCT a.note_type_id note_type, REPLACE(c.note_type_desc,'''','') note_type_desc FROM ca_note_type_for_resource a , ca_note_type_lang_vw c ");
					sqlStr.append(" WHERE a.resource_TYPE = '" +strFilterBy + "' AND a.RESOURCE_CODE = '" + clinicianId  + "' AND a.note_type_id = c.note_type AND c.language_id = '" + locale + "'" );
					sqlStr.append(" AND DECODE('" + strPatclass + "','IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' ");
					sqlStr.append(" AND EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = '" + strRespId + "'  AND privilege_type != '5' )");
					sqlStr.append(" AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID = '" + appTaskID + "') ORDER BY 2 ");
				}
				else if(strFilterBy.equals("R"))
				{
					sqlStr.append(" SELECT DISTINCT a.note_type_id note_type, REPLACE(c.note_type_desc,'''','') note_type_desc ");
					sqlStr.append(" FROM ca_note_type_for_resource a , ca_note_type_lang_vw c ");
					sqlStr.append(" WHERE ");
					sqlStr.append(" a.note_type_id = c.note_type AND c.language_id = '" +locale + "'");
					sqlStr.append(" AND DECODE('" + strPatclass + "','IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' ");
					sqlStr.append(" AND EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = '" + strRespId + "'  AND privilege_type != '5' )");
					sqlStr.append(" AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID = '" + appTaskID + "') ORDER BY 2 ");
					
					
				}
				else if(strFilterBy.equals("S"))
				{
					sqlStr.append(" SELECT DISTINCT a.note_type_id note_type, REPLACE(c.note_type_desc,'''','') note_type_desc FROM ca_note_type_for_resource a , ca_note_type_lang_vw c ");
					sqlStr.append(" WHERE a.resource_TYPE = '" +strFilterBy + "' AND a.note_type_id = c.note_type AND c.language_id = '" + locale + "'" );
					sqlStr.append(" AND DECODE('" + strPatclass + "','IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' ");
					sqlStr.append(" AND EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = '" + strRespId + "'  AND privilege_type != '5' )");
					sqlStr.append(" AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID = '" + appTaskID + "') ORDER BY 2 ");
				}					
			}
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					if (resultSet != null) 
					{
						resultSet.close();  
					}
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {
						/*
						Notes oNotes = new Notes();
						oNotes.sAccessNum = ((resultSet.getString("accession_num") != null) ?resultSet.getString("accession_num") : "") ;
						oNotes.sNoteTypeDesc = ((resultSet.getString("note_type_desc") != null) ?resultSet.getString("note_type_desc") : "") ;
						oNotes.sEventDateTime = ((resultSet.getString("event_date_time") != null) ?resultSet.getString("event_date_time") : "") ;
						oNotesList.add(oNotes);
						*/
						NoteTypeHO oNoteTypeHO = new NoteTypeHO();
						oNoteTypeHO.setNoteType( checkForNull(resultSet.getString("note_type")));
						oNoteTypeHO.setNoteTypeDesc( checkForNull(resultSet.getString("note_type_desc")));
						oNoteTypeList.add(oNoteTypeHO);
						
				}
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( stmt != null ) stmt.close() ;
					 ConnectionManager.returnConnection(connection,request);
			 
			}
		}
		oNoteTypeRes.setLstNoteType(oNoteTypeList);
		return oNoteTypeRes;
		
	}
    public NoteSectionResponse getNoteSection(CreateNotesRequest oNotesRequest) throws Exception {
    	NoteSectionResponse oNoteSecRes = new NoteSectionResponse();
    	List<NoteSectionHO> oNoteSecList = new ArrayList<NoteSectionHO>();
    	
		if( oNotesRequest != null && oNotesRequest.getRequest() != null)
		{
			Connection connection 		= null;
			Statement stmt				= null;
			ResultSet resultSet 			= null;
			String locale = "en";
			StringBuffer sqlStr = new StringBuffer("");
			String strNoteType = "";
			HttpServletRequest request = oNotesRequest.getRequest();
			
			if( oNotesRequest.getNoteType()  != null && !oNotesRequest.getNoteType().equals(""))
			{
				strNoteType = oNotesRequest.getNoteType() ;
			}
			
			sqlStr.append(" SELECT   sec_hdg_code,1 DOC_EXISTS, note_type,sec_content_type,sec_result_linked_rec_type,NVL(child_sec_hdg_code,sec_hdg_code) child_sec_hdg_code, ");
			sqlStr.append(" child_sec_content_type, child_sec_result_link_rec_type, CHIEF_COMPLAINT_SEC_YN,IMAGE_LINKED_YN,'Y' CONTENT_EDITABLE_YN,nvl(child_sec_result_link_rec_type,sec_result_linked_rec_type) result_link_type,nvl(child_sec_content_type,sec_content_type) content_type, OUTPUT_FORM_EXISTS_YN,SELECTION_TYPE, ");
			sqlStr.append(" CASE WHEN '" +locale + "' = 'en' THEN REPLACE (sec_hdg_desc, '''', '') ELSE REPLACE(ca_get_desc.ca_section_hdg (sec_hdg_code, '" + locale + "', '1'),'''','') END sec_hdg_desc, " );
			sqlStr.append(" CASE  WHEN child_sec_hdg_code = NULL THEN '' ELSE CASE  WHEN '" +locale + "' = 'en' THEN REPLACE (child_sec_hdg_desc, '''', '') ELSE REPLACE(ca_get_desc.ca_section_hdg (child_sec_hdg_code, '" +locale + "', '1'),'''','' ) END END child_sec_hdg_desc");
			sqlStr.append(" FROM ca_note_section_view ");
			sqlStr.append(" WHERE note_type = '" + strNoteType + "' ORDER BY note_sec_seq_num, child_seq_num");
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					if (resultSet != null) 
					{
						resultSet.close();  
					}
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {
						NoteSectionHO  oNoteSecHo = new NoteSectionHO();
						
						oNoteSecHo.setSecHdgCode(checkForNull(resultSet.getString("sec_hdg_code")));
						oNoteSecHo.setDocExists(checkForNull(resultSet.getString("DOC_EXISTS")));
						oNoteSecHo.setNoteType(checkForNull(resultSet.getString("note_type")));
						oNoteSecHo.setSecContentType(checkForNull(resultSet.getString("sec_content_type")));
						oNoteSecHo.setSecResultLinkedRectype(checkForNull(resultSet.getString("sec_result_linked_rec_type")));
						oNoteSecHo.setChildSecHdgCode(checkForNull(resultSet.getString("child_sec_hdg_code")));
						oNoteSecHo.setChildSecContentType(checkForNull(resultSet.getString("child_sec_content_type")));
						oNoteSecHo.setChildSecResultLinkRecType(checkForNull(resultSet.getString("child_sec_result_link_rec_type")));
						oNoteSecHo.setChiefComplaintSecYN(checkForNull(resultSet.getString("CHIEF_COMPLAINT_SEC_YN")));
						oNoteSecHo.setImageLinkedYN(checkForNull(resultSet.getString("IMAGE_LINKED_YN")));
						oNoteSecHo.setContentEditableYN(checkForNull(resultSet.getString("CONTENT_EDITABLE_YN")));
						oNoteSecHo.setResultLinkType(checkForNull(resultSet.getString("result_link_type")));
						oNoteSecHo.setContentType(checkForNull(resultSet.getString("content_type")));
						oNoteSecHo.setOutputFormExistsYN(checkForNull(resultSet.getString("OUTPUT_FORM_EXISTS_YN")));
						oNoteSecHo.setSelectionType(checkForNull(resultSet.getString("SELECTION_TYPE")));
						oNoteSecHo.setSecHdgDesc(checkForNull(resultSet.getString("sec_hdg_desc")));
						oNoteSecHo.setChildSecHdgDesc(checkForNull(resultSet.getString("child_sec_hdg_desc")));
						
						oNoteSecList.add(oNoteSecHo);
						
						
				}
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( stmt != null ) stmt.close() ;
					 ConnectionManager.returnConnection(connection,request);
			 
			}
		}
		oNoteSecRes.setLstNoteSection(oNoteSecList);
		return oNoteSecRes;
		
	}
    public RecentClinicalNotesResponse getRecentNotes(CreateNotesRequest oNotesRequest) throws Exception {
    	RecentClinicalNotesResponse oRecNoteResponse = new RecentClinicalNotesResponse();
    	List<RecentClinicalNotesHO> oRecentNoteList = new ArrayList<RecentClinicalNotesHO>();
    	
		if( oNotesRequest != null && oNotesRequest.getRequest() != null)
		{
			Connection connection 		= null;
			Statement stmt				= null;
			ResultSet resultSet 			= null;
			String locale = "en";
			StringBuffer sqlStr = new StringBuffer("");
			String facility_id= ""; //(String)session.getValue("facility_id");
			String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
			String strPracType = "";
			String strPatientId = "";
			String strEncounterId = "";
			String strTodate = "";
			String strFromDate = "";
			String strPostBack = "";
			String strInterval = "";
			String strFilterBy = "P";
			String strPatclass = "IP";
			String appTaskID = "CLINICAL_NOTES";
			String strRespId = "CA";
			HttpServletRequest request = oNotesRequest.getRequest();
			
			if( oNotesRequest.getFacilityId()  != null )
			{
				facility_id = oNotesRequest.getFacilityId() ;
			}
			if( oNotesRequest.getClinicianId() != null )
			{
				clinicianId  = oNotesRequest.getClinicianId();
			}
			if( oNotesRequest.getPracType() != null )
			{
				strPracType =  oNotesRequest.getPracType();
			}
			if( oNotesRequest.getPatientId() != null )
			{
				strPatientId = oNotesRequest.getPatientId();
			}
			if( oNotesRequest.getEncounterId() != null )
			{
				strEncounterId = oNotesRequest.getEncounterId();
			}
			if( oNotesRequest.getPatientClass() != null && !oNotesRequest.getPatientClass().equals(""))
			{
				strPatclass =  oNotesRequest.getPatientClass();
			}
			if( oNotesRequest.getFilterBy() != null && !oNotesRequest.getFilterBy().equals(""))
			{
				strFilterBy =  oNotesRequest.getFilterBy();
			}
			if( oNotesRequest.getApplTaskID() != null && !oNotesRequest.getApplTaskID().equals(""))
			{
				appTaskID = oNotesRequest.getApplTaskID();
			}
			if( oNotesRequest.getRespId() != null && !oNotesRequest.getRespId().equals(""))
			{
				strRespId = oNotesRequest.getRespId();
			}
	
			/*
			sqlStr.append(" SELECT   a.facility_id,  a.accession_num,  a.note_type, b.note_type_desc, NVL2 (a.ext_image_appl_id, 'Y', 'N') doc_linked,");
			sqlStr.append(" b.doc_linked_note_yn, a.service_code,  am_get_desc.am_service (a.service_code, '" + locale + "', '2') service_name, event_title_desc, TO_CHAR (a.event_date_time, 'dd/mm/yyyy hh24:mi') event_date_time1,");
			sqlStr.append(" a.performed_by_id, REPLACE(am_get_desc.am_practitioner (a.performed_by_id, '"+locale + "', '1'),'''', ' ') performed_by_name,  a.authorized_by_id, ");
			sqlStr.append(" REPLACE(am_get_desc.am_practitioner (a.authorized_by_id, '" + locale + "', '1'), '''',' ') authorized_by_name, a.event_status status, ");
			sqlStr.append("  ca_get_appl_note_opern (a.facility_id, a.accession_num, '" + strRespId +"', '" + clinicianId +"', a.note_type,  '" +clinicianId +"', 'N'  ) operations_allowed, ");
			sqlStr.append(" b.ammendment_type, (SELECT privilege_type FROM ca_note_type_for_resp WHERE resp_id = '" +strRespId  +"' AND note_type = a.note_type) privilege_type,");
			sqlStr.append("  a.modified_by_id modifiedid, a.doc_ref_id doc_ref_id, NULL encline, a.encounter_id  FROM ca_encntr_note a, ca_note_type_lang_vw b ");
			sqlStr.append(" WHERE ca_get_appl_note_opern (a.facility_id,  a.accession_num,  '"+ strRespId +"', '" + clinicianId +"', a.note_type, '" +clinicianId +"', 'N'  ) IS NOT NULL ");
			sqlStr.append("  AND a.note_type = b.note_type ");
			*/
			/*
			sqlStr.append(" SELECT a.facility_id, a.accession_num, a.note_type, a.encounter_id, b.note_type_desc, a.service_code, a.event_status status, am_get_desc.am_service (a.service_code, '" + locale +"', '2') service_name,");
			sqlStr.append(" a.event_title_desc, TO_CHAR (a.event_date_time, 'dd/mm/yyyy HH24:MI') event_date_time, TO_CHAR (a.event_date_time, 'dd/mm/yyyy') event_date, TO_CHAR (a.event_date_time, 'HH24:MI') TIME, a.performed_by_id, d.practitioner_name performed_by_name, a.authorized_by_id, e.practitioner_name authorized_by_name,");
			sqlStr.append(" ca_get_desc.ca_note_group (b.note_group_id, '"+locale +"', '1') note_group_desc, ca_get_appl_note_opern (a.facility_id, a.accession_num, '" + strRespId +"', '" + clinicianId +"', a.note_type, '" + clinicianId +"' ) rights, a.ext_image_appl_id ");
			sqlStr.append(" FROM ca_encntr_note a, ca_note_type_lang_vw b, am_practitioner_lang_vw d, am_practitioner_lang_vw e WHERE a.contr_mod_accession_num IS NULL AND ( ca_get_appl_note_opern (a.facility_id, a.accession_num, '"+ strRespId+"', '"+clinicianId+"', a.note_type, '"+clinicianId +"' ) IS NOT NULL");
			sqlStr.append(" OR a.contr_mod_accession_num IS NOT NULL ) AND a.note_type = b.note_type AND b.language_id = '"+ locale +"' AND ( a.event_status IN ('3', '4', '5', '9') OR a.contr_mod_accession_num IS NOT NULL ) AND d.practitioner_id(+) = a.performed_by_id AND d.language_id(+) = '"+locale +"' AND e.practitioner_id(+) = a.authorized_by_id AND e.language_id(+) = '" + locale +"' ");
			sqlStr.append(" AND a.patient_id = '" +strPatientId +"' AND a.event_status != 9 AND facility_id = '" + facility_id +"' AND a.encounter_id = '" +strEncounterId +"' ORDER BY b.note_type_desc, a.note_type ");
			*/
			sqlStr.append(" SELECT a.facility_id, a.accession_num, a.note_type, a.encounter_id, b.note_type_desc, a.service_code, a.event_status status, am_get_desc.am_service (a.service_code, '" + locale +"', '2') service_name,");
			sqlStr.append(" a.event_title_desc, a.event_date_time, TO_CHAR (a.event_date_time, 'dd/mm/yyyy HH24:MI') event_date_time1, TO_CHAR (a.event_date_time, 'dd/mm/yyyy') event_date, TO_CHAR (a.event_date_time, 'HH24:MI') TIME, a.performed_by_id, a.authorized_by_id,");
			sqlStr.append(" a.ext_image_appl_id ");
			sqlStr.append(" FROM ca_encntr_note a, ca_note_type_lang_vw b WHERE ca_get_appl_note_opern(a.facility_id, a.accession_num, '"+ strRespId+"', '"+clinicianId+"', a.note_type, '"+clinicianId +", N' ) IS NOT NULL");
			sqlStr.append(" AND a.note_type = b.note_type AND a.patient_id = '" +strPatientId +"' AND a.facility_id = '" + facility_id +"' AND a.encounter_id = NVL ('" + strEncounterId+"', 0) AND b.language_id = '"+ locale +"' AND b.note_group_id IN (SELECT note_group  ");
			sqlStr.append(" FROM ca_note_group WHERE appl_task_id = '" + appTaskID +"' ) ORDER BY event_date_time DESC" );
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					if (resultSet != null) 
					{
						resultSet.close();  
					}
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {
						RecentClinicalNotesHO oRecentNotes = new RecentClinicalNotesHO();
						
						oRecentNotes.setFacilityId(checkForNull(resultSet.getString("facility_id")));
						oRecentNotes.setAccessionNum(checkForNull(resultSet.getString("accession_num")));
						oRecentNotes.setNoteTypeDesc(checkForNull(resultSet.getString("note_type_desc")));
						oRecentNotes.setEventDateTime(checkForNull(resultSet.getString("event_date_time1")));
						oRecentNotes.setNoteType(checkForNull(resultSet.getString("note_type")));
						oRecentNoteList.add(oRecentNotes);
						
						
						
				}
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( stmt != null ) stmt.close() ;
					 ConnectionManager.returnConnection(connection,request);
			 
			}
		}
		oRecNoteResponse.setLstRecentClinicalNotes(oRecentNoteList);
		return oRecNoteResponse;
		
	}
    private String checkForNull(String strParam)
    {
            String str ="";
            if(strParam!=null && strParam.length() >0)
            str = strParam;
            return str;
    }
	

}
