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
package eIPAD.chartsummary.clinicalnotes.dao;

import java.util.ArrayList;

import eDS.Common.JSONObject;
import eIPAD.chartsummary.clinicalnotes.healthobject.ClinicalNotesFieldItem;
import eIPAD.chartsummary.clinicalnotes.healthobject.InErrorDetails;
import eIPAD.chartsummary.clinicalnotes.request.*;
import eIPAD.chartsummary.clinicalnotes.response.*;
import eIPAD.chartsummary.common.healthobject.PatContext;
/**
 * @author GaneshkumarC
 *
 */
public interface ClinicalNotesDao {
	public ClinicalNotesResponse getNoteDetails(ClinicalNotesRequest oClnReq);
	public ClinicalNotesResponse getNoteDetailsTimeRange(ClinicalNotesRequest oClnReq);

	public ClinicalNotesFieldResponse getNoteTypeListSfs(PatContext patientContext, String viewPage, String finalStartDate, String finalEndDate, String selectedEncounterID); // NT sfs
	public ClinicalNotesFieldResponse getMedServListSfs(PatContext patientContext, String viewPage, String finalStartDate, String finalEndDate, String selectedEncounterID); //MedServ sfs
	public ClinicalNotesFieldResponse getPerformedByListSfs(PatContext patientContext, String viewPage, String finalStartDate, String finalEndDate, String selectedEncounterID);//perfomedby sfs
	public ClinicalNotesFieldResponse getStatusListSfs(PatContext patientContext, String viewPage, String finalStartDate, String finalEndDate, String selectedEncounterID);//status sfs
	public ClinicalNotesFieldResponse getMySpecialityList(PatContext patientContext);//my speciality list
	
	public ClinicalNotesFieldResponse getNoteTypeList(PatContext patientContext,String filterByVal, String applTaskID,String noteGroupID, String specialityCode);
	public ClinicalNotesFieldResponse getNoteGroupList(PatContext patientContext,String filterByVal, String applTaskID, String specialityCode);
	public ClinicalNotesFieldResponse getMedAncServiceList(String searchText, String searchCriteria,PatContext patientContext);
	public ClinicalNotesFieldResponse getSpecialityList(PatContext patientContext);
	public ClinicalNotesFieldResponse getSelNoteGroup(PatContext patientContext, String selNoteType);
	public ClinicalNotesFieldResponse getSelMedService(PatContext patientContext);
	public ClinicalNotesValidationResponse checkNoOfNotes(PatContext patientContext,String selNoteType, String noteGrpId);
	//public ClinicalNotesSectionResponse getSecNoteListName(PatContext patientContext, String noteType);
	//public ClinicalNotesSectionResponse getSecNoteListName(PatContext patientContext, String noteType, String speciality);
	public ClinicalNotesTemplateResponse getSectionTemplate(String secCode,PatContext patientContext);
	public ClinicalNotesFieldResponse getMedAncServicesList(PatContext patientContext, String ser_spc_yn, String noteType);
	public ClinicalNotesMapResponse getCreateNotesDefaultFilterValues(PatContext patientContext, String appl_task_id);
	public ClinicalNotesMapResponse getNoteTypeSectionDetails(String resp_id, String p_note_type, String locale);
	public ClinicalNotesFieldResponse getFrequentlyUsedNoteTypes(PatContext patientContext,int count);
	public ClinicalNotesFieldResponse getFrequentlyUsedNoteTypes(PatContext patientContext);
	public ClinicalNotesFieldResponse getPractitionerList(PatContext patientContext,String note_type);
	public ClinicalNotesFieldResponse getCannedTextList(PatContext patientContext,String note_type, String sec_hdg_code, String service_code, String text_type );
	public ClinicalNotesFieldResponse getForwardNotesSpecialityList(PatContext patientContext);
	public ClinicalNotesFieldResponse getAllFilterNoteTypes(PatContext patientContext);
	public ArrayList<JSONObject> getRemarkDeatils(String accessionNumber,String facilityId);
	public ClinicalNotesMapResponse getApplicableNoteOperations(PatContext patientContext, String accession_num);
	public ClinicalNotesSectionListResponse getSectionListForNoteType(String note_type, String locale);
	public ArrayList<ClinicalNotesFieldItem> getSfsRecordDeatils(String QueryString,PatContext patientContext);
	public ClinicalNotesFieldItem getInerror(String QueryString,String data);
	public ClinicalNotesTransactionResponse validateNotePreSelection(PatContext patientContext, String noteType);
	
	
}
