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
package eIPAD.chartsummary.clinicalnotes.bc;

import java.util.*;
import java.util.Map.Entry;

import eDS.Common.JSONObject;
import eIPAD.chartsummary.clinicalnotes.dao.*;
import eIPAD.chartsummary.clinicalnotes.daoimpl.*;
import eIPAD.chartsummary.clinicalnotes.request.*;
import eIPAD.chartsummary.clinicalnotes.response.*;
import eIPAD.chartsummary.clinicalnotes.healthobject.*;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.response.*;

/**
 * @author GaneshkumarC
 * 
 */
public class ClinicalNotesBC {
	public ClinicalNotesResponse getNoteDetails(ClinicalNotesRequest oClnReq) {
		ClinicalNotesResponse oClinicalResponse = null;
		String groupBy = "NoteType";
		if (oClnReq != null) {
			if (oClnReq.getGroupBy() != null
					&& !oClnReq.getGroupBy().equals("")) {
				groupBy = oClnReq.getGroupBy();
			}
			if (groupBy.equalsIgnoreCase("NoteType")) {
				oClinicalResponse = groupByNoteType(oClnReq);
			} else {
				oClinicalResponse = groupByNone(oClnReq);
			}
		}
		return oClinicalResponse;
	}

	public ClinicalNotesResponse getNoteDetailsTimeRange(
			ClinicalNotesRequest oClnReq) {
		ClinicalNotesResponse oClinicalResponse = null;
		String groupBy = "NoteType";
		if (oClnReq != null) {
			if (oClnReq.getGroupBy() != null
					&& !oClnReq.getGroupBy().equals("")) {
				groupBy = oClnReq.getGroupBy();
			}
			if (groupBy.equalsIgnoreCase("NoteType")) {
				oClinicalResponse = groupByNoteTypeTimeRange(oClnReq);
			} else {
				oClinicalResponse = groupByNoneTimeRange(oClnReq);
			}
		}
		return oClinicalResponse;
	}

	private ClinicalNotesResponse groupByNone(ClinicalNotesRequest oClnReq) {
		ClinicalNotesResponse oClnRes;
		ClinicalNotesDao oClinicalDAO = new ClinicalNotesDAOImpl();
		oClnRes = oClinicalDAO.getNoteDetails(oClnReq);
		return oClnRes;
	}

	private ClinicalNotesResponse groupByNoneTimeRange(
			ClinicalNotesRequest oClnReq) {
		ClinicalNotesResponse oClnRes;
		ClinicalNotesDao oClinicalDAO = new ClinicalNotesDAOImpl();
		oClnRes = oClinicalDAO.getNoteDetailsTimeRange(oClnReq);
		return oClnRes;
	}

	private ClinicalNotesResponse groupByNoteType(ClinicalNotesRequest oClnReq) {
		ClinicalNotesResponse oClnRes;
		List<DateDetails> oLstDateDtls;
		ClinicalNotesDao oClinicalDAO = new ClinicalNotesDAOImpl();
		oClnRes = oClinicalDAO.getNoteDetails(oClnReq);
		List<NormalViewDetails> listNormalViewDetails = oClnRes
				.getListNormalViewDetails();
		// List<NormalViewDetailsTimeRange> listNormalViewDetailsTimeRanges =
		// oClnRes.getListNormalViewDetailsTimeRange();
		Map<NoteTypeGroup, List<DateDetails>> NoteTypeGroupsMap = new LinkedHashMap<NoteTypeGroup, List<DateDetails>>();
		List<ClinicalNoteGroup> oLstClinicalNoteGroup = new ArrayList<ClinicalNoteGroup>();
		ErrorInfo oErrorInfo = null;
		int nListSize = 0;
		int startIndex = 0;
		int endIndex = 0;
		int nLoopCount = 0;
		startIndex = oClnReq.getStartIndex();
		endIndex = oClnReq.getEndIndex();
		if (listNormalViewDetails != null) {
			nListSize = listNormalViewDetails.size();
			/*
			 * if(endIndex == 0) { endIndex = nListSize; }
			 */
		}
		try {
			if (nListSize > 0) {
				// if(startIndex < nListSize && endIndex <= nListSize)
				// {
				// for(;startIndex < endIndex; startIndex++)
				for (; nLoopCount < nListSize; nLoopCount++) {
					NormalViewDetails oNormalViewDetails = listNormalViewDetails
							.get(nLoopCount);
					NoteTypeGroup oNoteTypeGroup = new NoteTypeGroup();
					DateDetails oDateDtls = new DateDetails();
					if (oNormalViewDetails != null) {
						oNoteTypeGroup.setNoteType(oNormalViewDetails
								.getNoteType());
						oNoteTypeGroup.setNoteTypeDesc(oNormalViewDetails
								.getNoteTypeDesc());
						oNoteTypeGroup.setServiceCode(oNormalViewDetails
								.getServiceCode());
						oNoteTypeGroup.setPerformedBy(oNormalViewDetails
								.getPerformedBy());
						oNoteTypeGroup.setEventClass(oNormalViewDetails
								.getEventClass());
						oNoteTypeGroup
								.setStatus(oNormalViewDetails.getStatus());
						oNoteTypeGroup.setPrimarySpec(oNormalViewDetails
								.getPrimarySpec());

						oDateDtls.setNoteType(oNormalViewDetails.getNoteType());
						oDateDtls.setNoteTypeDesc(oNormalViewDetails
								.getNoteTypeDesc());
						oDateDtls.setServiceCode(oNormalViewDetails
								.getServiceCode());
						oDateDtls.setPerformedBy(oNormalViewDetails
								.getPerformedBy());
						oDateDtls.setAccessionNum(oNormalViewDetails
								.getAccessionNum());
						oDateDtls.setEventClass(oNormalViewDetails
								.getEventClass());
						oDateDtls.setEventDate(oNormalViewDetails
								.getEventDate());
						oDateDtls.setEventTime(oNormalViewDetails
								.getEventTime());
						oDateDtls.setStatus(oNormalViewDetails.getStatus());
						oDateDtls.setPrimarySpec(oNormalViewDetails
								.getPrimarySpec());
						oDateDtls.setEncounterId(oNormalViewDetails
								.getEncounterId());
									oDateDtls.setActionType(oNormalViewDetails.getActionType());
						if (NoteTypeGroupsMap.containsKey(oNoteTypeGroup)) {
							if (NoteTypeGroupsMap.get(oNoteTypeGroup) != null) {
								NoteTypeGroupsMap.get(oNoteTypeGroup).add(
										oDateDtls);
							}
						} else {
							oLstDateDtls = new ArrayList<DateDetails>();
							oLstDateDtls.add(oDateDtls);
							NoteTypeGroupsMap.put(oNoteTypeGroup, oLstDateDtls);
						}
					}
				}
				Iterator<Entry<NoteTypeGroup, List<DateDetails>>> iter = NoteTypeGroupsMap
						.entrySet().iterator();
				while (iter.hasNext()) {
					Map.Entry<NoteTypeGroup, List<DateDetails>> mEntry = iter
							.next();
					NoteTypeGroup oNoteTypeEntry = mEntry.getKey();
					List<DateDetails> oDateEntry = mEntry.getValue();
					if (oNoteTypeEntry != null && oDateEntry != null) {
						oNoteTypeEntry.setChildCount(oDateEntry.size());
						if (startIndex >= 0 && startIndex < oDateEntry.size()
								&& endIndex > startIndex) {
							if (endIndex < oDateEntry.size()) {
								oNoteTypeEntry.setListDateDetails(oDateEntry
										.subList(startIndex, endIndex));
							}
							if (endIndex >= oDateEntry.size()) {
								endIndex = oDateEntry.size();
								if (endIndex > startIndex) {
									oNoteTypeEntry
											.setListDateDetails(oDateEntry
													.subList(startIndex,
															endIndex));
								} else {
									oNoteTypeEntry
											.setListDateDetails(oDateEntry);
								}

							}
						} else {
							oNoteTypeEntry.setListDateDetails(oDateEntry);
						}
						oLstClinicalNoteGroup.add(oNoteTypeEntry);
					}
				}
				// }//if
			}
		} catch (Exception e) {
			e.printStackTrace();
			oErrorInfo = new ErrorInfo();
			oErrorInfo.setErrorMessage(e.toString());
			oClnRes.getErrorsList().add(oErrorInfo);
		} finally {

		}
		oClnRes.setListNoteGroup(oLstClinicalNoteGroup);
		oClnRes.setListNormalViewDetails(null);
		return oClnRes;
	}

	private ClinicalNotesResponse groupByNoteTypeTimeRange(
			ClinicalNotesRequest oClnReq) {
		ClinicalNotesResponse oClnRes;
		List<DateDetailsTimeRange> oLstDateDtlsTimeRanges;
		ClinicalNotesDao oClinicalDAO = new ClinicalNotesDAOImpl();
		oClnRes = oClinicalDAO.getNoteDetailsTimeRange(oClnReq);
		List<NormalViewDetailsTimeRange> listNormalViewDetailsTimeRanges = oClnRes
				.getListNormalViewDetailsTimeRange();
		// List<NormalViewDetailsTimeRange> listNormalViewDetailsTimeRanges =
		// oClnRes.getListNormalViewDetailsTimeRange();
		Map<NoteTypeGroup, List<DateDetailsTimeRange>> NoteTypeGroupsMap = new LinkedHashMap<NoteTypeGroup, List<DateDetailsTimeRange>>();
		List<ClinicalNoteGroup> oLstClinicalNoteGroup = new ArrayList<ClinicalNoteGroup>();
		ErrorInfo oErrorInfo = null;
		int nListSize = 0;
		int startIndex = 0;
		int endIndex = 0;
		int nLoopCount = 0;
		startIndex = oClnReq.getStartIndex();
		endIndex = oClnReq.getEndIndex();
		if (listNormalViewDetailsTimeRanges != null) {
			nListSize = listNormalViewDetailsTimeRanges.size();
			/*
			 * if(endIndex == 0) { endIndex = nListSize; }
			 */
		}
		try {
			if (nListSize > 0) {
				// if(startIndex < nListSize && endIndex <= nListSize)
				// {
				// for(;startIndex < endIndex; startIndex++)
				for (; nLoopCount < nListSize; nLoopCount++) {
					NormalViewDetailsTimeRange oNormalViewDetailsTimeRange = listNormalViewDetailsTimeRanges
							.get(nLoopCount);
					NoteTypeGroup oNoteTypeGroup = new NoteTypeGroup();
					DateDetailsTimeRange oDateDtlsTimeRange = new DateDetailsTimeRange();
					if (oNormalViewDetailsTimeRange != null) {
						oNoteTypeGroup.setNoteType(oNormalViewDetailsTimeRange
								.getNoteType());
						oNoteTypeGroup
								.setNoteTypeDesc(oNormalViewDetailsTimeRange
										.getNoteTypeDesc());
						oNoteTypeGroup
								.setServiceCode(oNormalViewDetailsTimeRange
										.getServiceCode());
						oNoteTypeGroup
								.setPerformedBy(oNormalViewDetailsTimeRange
										.getPerformedBy());
						oNoteTypeGroup
								.setEventClass(oNormalViewDetailsTimeRange
										.getEventClass());
						oNoteTypeGroup.setStatus(oNormalViewDetailsTimeRange
								.getStatus());
						oNoteTypeGroup
								.setPrimarySpec(oNormalViewDetailsTimeRange
										.getPrimarySpec());

						oDateDtlsTimeRange
								.setNoteType(oNormalViewDetailsTimeRange
										.getNoteType());
						oDateDtlsTimeRange
								.setNoteTypeDesc(oNormalViewDetailsTimeRange
										.getNoteTypeDesc());
						oDateDtlsTimeRange
								.setServiceCode(oNormalViewDetailsTimeRange
										.getServiceCode());
						oDateDtlsTimeRange
								.setPerformedBy(oNormalViewDetailsTimeRange
										.getPerformedBy());
						oDateDtlsTimeRange
								.setAccessionNum(oNormalViewDetailsTimeRange
										.getAccessionNum());
						oDateDtlsTimeRange
								.setEventClass(oNormalViewDetailsTimeRange
										.getEventClass());
						oDateDtlsTimeRange
								.setEventDate(oNormalViewDetailsTimeRange
										.getEventDate());
						oDateDtlsTimeRange
								.setEventTime(oNormalViewDetailsTimeRange
										.getEventTime());
						oDateDtlsTimeRange
								.setStatus(oNormalViewDetailsTimeRange
										.getStatus());
						oDateDtlsTimeRange
								.setPrimarySpec(oNormalViewDetailsTimeRange
										.getPrimarySpec());
						oDateDtlsTimeRange
								.setEncounterId(oNormalViewDetailsTimeRange
										.getEncounterId());
													oDateDtlsTimeRange.setActionType(oNormalViewDetailsTimeRange.getActionType());
						if (NoteTypeGroupsMap.containsKey(oNoteTypeGroup)) {
							if (NoteTypeGroupsMap.get(oNoteTypeGroup) != null) {
								NoteTypeGroupsMap.get(oNoteTypeGroup).add(
										oDateDtlsTimeRange);
							}
						} else {
							oLstDateDtlsTimeRanges = new ArrayList<DateDetailsTimeRange>();
							oLstDateDtlsTimeRanges.add(oDateDtlsTimeRange);
							NoteTypeGroupsMap.put(oNoteTypeGroup,
									oLstDateDtlsTimeRanges);
						}
					}
				}
				Iterator<Entry<NoteTypeGroup, List<DateDetailsTimeRange>>> iter = NoteTypeGroupsMap
						.entrySet().iterator();
				while (iter.hasNext()) {
					Map.Entry<NoteTypeGroup, List<DateDetailsTimeRange>> mEntry = iter
							.next();
					NoteTypeGroup oNoteTypeEntry = mEntry.getKey();
					List<DateDetailsTimeRange> oDateEntry = mEntry.getValue();
					if (oNoteTypeEntry != null && oDateEntry != null) {
						oNoteTypeEntry.setChildCount(oDateEntry.size());
						if (startIndex >= 0 && startIndex < oDateEntry.size()
								&& endIndex > startIndex) {
							if (endIndex < oDateEntry.size()) {
								oNoteTypeEntry
										.setListDateDetailsTimeRange(oDateEntry
												.subList(startIndex, endIndex));
							}
							if (endIndex >= oDateEntry.size()) {
								endIndex = oDateEntry.size();
								if (endIndex > startIndex) {
									oNoteTypeEntry
											.setListDateDetailsTimeRange(oDateEntry
													.subList(startIndex,
															endIndex));
								} else {
									oNoteTypeEntry
											.setListDateDetailsTimeRange(oDateEntry);
								}

							}
						} else {
							oNoteTypeEntry
									.setListDateDetailsTimeRange(oDateEntry);
						}
						oLstClinicalNoteGroup.add(oNoteTypeEntry);
					}
				}
				// }//if
			}
		} catch (Exception e) {
			e.printStackTrace();
			oErrorInfo = new ErrorInfo();
			oErrorInfo.setErrorMessage(e.toString());
			oClnRes.getErrorsList().add(oErrorInfo);
		} finally {

		}
		oClnRes.setListNoteGroup(oLstClinicalNoteGroup);
		oClnRes.setListNormalViewDetailsTimeRange(null);
		return oClnRes;
	}

	/* SFS methods starts here */
	public ClinicalNotesFieldResponse getNoteTypeListSfs(
			PatContext patientContext, String viewPage, String finalStartDate, String finalEndDate, String selectedEncounterID) {
		ClinicalNotesFieldResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getNoteTypeListSfs(patientContext, viewPage, finalStartDate, finalEndDate, selectedEncounterID);
		return resp;
	}

	public ClinicalNotesFieldResponse getMedServListSfs(
			PatContext patientContext, String viewPage, String finalStartDate, String finalEndDate, String selectedEncounterID) {
		ClinicalNotesFieldResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getMedServListSfs(patientContext, viewPage, finalStartDate, finalEndDate, selectedEncounterID);
		return resp;
	}

	public ClinicalNotesFieldResponse getPerformedByListSfs(
			PatContext patientContext, String viewPage, String finalStartDate, String finalEndDate, String selectedEncounterID) {
		ClinicalNotesFieldResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getPerformedByListSfs(patientContext, viewPage, finalStartDate, finalEndDate, selectedEncounterID);
		return resp;
	}

	public ClinicalNotesFieldResponse getStatusListSfs(
			PatContext patientContext, String viewPage, String finalStartDate, String finalEndDate, String selectedEncounterID) {
		ClinicalNotesFieldResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getStatusListSfs(patientContext, viewPage, finalStartDate, finalEndDate, selectedEncounterID);
		return resp;
	}

	public ClinicalNotesFieldResponse getMySpecialityList(
			PatContext patientContext) {
		ClinicalNotesFieldResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getMySpecialityList(patientContext);
		return resp;
	}

	public ClinicalNotesFieldResponse getNoteTypeList(
			PatContext patientContext, String filterByVal, String applTaskID,
			String noteGroupID, String specialityCode) {
		ClinicalNotesFieldResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getNoteTypeList(patientContext, filterByVal, applTaskID,
				noteGroupID, specialityCode);
		return resp;
	}

	public ClinicalNotesFieldResponse getNoteGroupList(
			PatContext patientContext, String filterByVal, String applTaskID,
			String specialityCode) {
		ClinicalNotesFieldResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getNoteGroupList(patientContext, filterByVal, applTaskID,
				specialityCode);
		return resp;
	}

	public ClinicalNotesFieldResponse getMedAncServiceList(String searchText,
			String searchCriteria, PatContext patientContext) {
		ClinicalNotesFieldResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getMedAncServiceList(searchText, searchCriteria,
				patientContext);
		return resp;
	}

	public ClinicalNotesFieldResponse getSpecialityList(
			PatContext patientContext) {
		ClinicalNotesFieldResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getSpecialityList(patientContext);
		return resp;
	}

	public ClinicalNotesFieldResponse getSelNoteGroup(
			PatContext patientContext, String selNoteType) {
		ClinicalNotesFieldResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getSelNoteGroup(patientContext, selNoteType);
		return resp;
	}

	public ClinicalNotesFieldResponse getSelMedService(PatContext patientContext) {
		ClinicalNotesFieldResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getSelMedService(patientContext);
		return resp;
	}

	public ClinicalNotesValidationResponse checkNoOfNotes(
			PatContext patientContext, String selNoteType, String noteGrpId) {
		ClinicalNotesValidationResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.checkNoOfNotes(patientContext, selNoteType, noteGrpId);
		return resp;
	}

	/*
	 * public ClinicalNotesSectionResponse getSecNoteListName(PatContext
	 * patientContext, String noteType, String speciality ){
	 * ClinicalNotesSectionResponse resp; ClinicalNotesDao dao = new
	 * ClinicalNotesDAOImpl(); resp =
	 * dao.getSecNoteListName(patientContext,noteType,speciality); return resp;
	 * }
	 */
	public ClinicalNotesTemplateResponse getSectionTemplate(String secCode,
			PatContext patientContext) {
		ClinicalNotesTemplateResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getSectionTemplate(secCode, patientContext);
		return resp;
	}

	public ClinicalNotesFieldResponse getMedAncServicesList(
			PatContext patientContext, String ser_spc_yn, String noteType) {
		ClinicalNotesFieldResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getMedAncServicesList(patientContext, ser_spc_yn, noteType);
		return resp;
	}

	public ClinicalNotesMapResponse getCreateNotesDefaultFilterValues(
			PatContext patientContext, String appl_task_id) {
		ClinicalNotesMapResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getCreateNotesDefaultFilterValues(patientContext,
				appl_task_id);
		return resp;

	}

	public ClinicalNotesMapResponse getNoteTypeSectionDetails(String resp_id,
			String p_note_type, String locale) {
		ClinicalNotesMapResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getNoteTypeSectionDetails(resp_id, p_note_type, locale);
		return resp;
	}

	public ClinicalNotesFieldResponse getFrequentlyUsedNoteTypes(
			PatContext patientContext, int count) {
		ClinicalNotesFieldResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getFrequentlyUsedNoteTypes(patientContext, count);
		return resp;
	}

	public ClinicalNotesFieldResponse getFrequentlyUsedNoteTypes(
			PatContext patientContext) {
		ClinicalNotesFieldResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getFrequentlyUsedNoteTypes(patientContext);
		return resp;
	}
	
	public ClinicalNotesFieldResponse getPractitionerList(
			PatContext patientContext,String note_type) {
		
//		, String note_type
		ClinicalNotesFieldResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getPractitionerList(patientContext,note_type);
		return resp;
	}
	
	public ClinicalNotesFieldResponse getForwardNotesSpecialityList(
			PatContext patientContext) {
		
		ClinicalNotesFieldResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getForwardNotesSpecialityList(patientContext);
		return resp;
	}

	public ClinicalNotesFieldResponse getCannedTextList(
			PatContext patientContext, String note_type, String sec_hdg_code,
			String service_code, String text_type) {
		ClinicalNotesFieldResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getCannedTextList(patientContext, note_type, sec_hdg_code,
				service_code, text_type);
		return resp;
	}

	public ClinicalNotesFieldResponse getAllFilterNoteTypes(
			PatContext patientContext) {
		ClinicalNotesFieldResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getAllFilterNoteTypes(patientContext);
		return resp;
	}

	public ClinicalNotesMapResponse getApplicableNoteOperations(
			PatContext patientContext, String accession_num) {
		ClinicalNotesMapResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getApplicableNoteOperations(patientContext, accession_num);
		return resp;
	}

	public ClinicalNotesSectionListResponse getSectionListForNoteType(
			String note_type, String locale) {
		ClinicalNotesSectionListResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.getSectionListForNoteType(note_type, locale);
		return resp;
	}

	// abc

	public ArrayList<ClinicalNotesFieldItem> getRecordsForSfs(String std_comp_id,PatContext patientContext)
			throws Exception {


		eCA.StandardCompRepository stdCompRepository = new eCA.StandardCompRepository();
		String sql_query = (String) stdCompRepository.getCAKeyValue(std_comp_id
				.trim());
		ClinicalNotesDao sfsintf = new ClinicalNotesDAOImpl();

		ArrayList<ClinicalNotesFieldItem> allComboDetails = sfsintf
				.getSfsRecordDeatils(sql_query,patientContext);


		return allComboDetails;

	}
	
	public ArrayList<JSONObject> getMarkAsError(String accessionNumber,String facilityId)
			throws Exception {

	
		
		ClinicalNotesDao remarks = new ClinicalNotesDAOImpl();

		ArrayList<JSONObject> resp=  remarks.getRemarkDeatils(accessionNumber, facilityId);
	 
	 
		
        return resp;
		

	}

	
	public ClinicalNotesFieldItem getINErrorResult(String accessionNumber,String data)
			throws Exception {

	
		
		ClinicalNotesDao remarks = new ClinicalNotesDAOImpl();

		ClinicalNotesFieldItem resp=  remarks.getInerror(accessionNumber,data);
	 
	 
		
        return resp;
		

	}
	
	public ClinicalNotesTransactionResponse validateNotePreSelection(PatContext patientContext, String noteType){
		ClinicalNotesTransactionResponse resp;
		ClinicalNotesDao dao = new ClinicalNotesDAOImpl();
		resp = dao.validateNotePreSelection(patientContext, noteType);
		return resp;
	}

	
	
}
