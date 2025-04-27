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
package eIPAD.chartsummary.activeproblems.dao;

import eIPAD.chartsummary.activeproblems.request.ComplaintSfsRequest;
import eIPAD.chartsummary.activeproblems.request.DiagnosisSfsRequest;
import eIPAD.chartsummary.activeproblems.request.ProblemsDiagnosisRequest;
import eIPAD.chartsummary.activeproblems.response.ComplaintDetailsResponse;
import eIPAD.chartsummary.activeproblems.response.ComplaintSfsResponse;
import eIPAD.chartsummary.activeproblems.response.ComplaintSpecialtyListResponse;
import eIPAD.chartsummary.activeproblems.response.DiagAnatomicalSiteResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisAccuracyResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisClassificationResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisComplaintResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisCustomGroupResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisDetailsResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisSetResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisSfsResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisValidationResponse;
import eIPAD.chartsummary.activeproblems.response.ProblemsDiagnosisResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;

/**
 * @author SaraswathiR 
 *
 */
public interface ProblemsDiagnosisDAO {
	public ProblemsDiagnosisResponse getActiveProblemsAndDiagnosis(ProblemsDiagnosisRequest request);
	public int isUserAuthorizedForSensitiveDate(PatContext patientContext, String password);
	public EncounterListResponse getLinkedEncountersForDiagnosis(PatContext patientContext, String termSetId, String diagCode, String status);
	public ProblemsDiagnosisResponse getLinkedProblemsForDiagnosis(PatContext patientContext, String termSetId, String diagCode, String termSetDesc, String occurSrlNo);
	public DiagnosisSetResponse getDiagnosisSetList(PatContext patientContext);
	public DiagnosisComplaintResponse getDiagnosisComplaintsList(PatContext patientContext, String diagSetId);
	public DiagnosisClassificationResponse getDiagnosisClassificationList(PatContext patientContext, String diagSetId);
	public DiagnosisAccuracyResponse getDiagnosisAccuracyList(PatContext patientContext);
	public DiagAnatomicalSiteResponse getDiagnosisAnatomicalSiteList(PatContext patientContext, boolean oralCavity);
	public DiagnosisSfsResponse getDiagnosisCodeList(DiagnosisSfsRequest req);
	public ComplaintSfsResponse getComplaintCodeList(ComplaintSfsRequest req);
	public DiagnosisCustomGroupResponse getDiagnosisCustomGroupList(PatContext patientContext, String diagSetId, String specialtyCode);
	public DiagnosisValidationResponse checkActiveDiagnosisExists(PatContext patientContext, String diagSetId, String diagnosisCode);
	public DiagnosisValidationResponse checkPrimaryDiagnosisExists(PatContext patientContext, String diagSetId);
	public DiagnosisDetailsResponse getDiagnosisDetails(PatContext patientContext, String diagSetId, String diagCode, String occurSrlNo);
	public DiagnosisComplaintResponse getDiagnosisComplaintsListExisting(PatContext patientContext, String diagSetId, String diagCode, String occurSrlNo);
	public DiagnosisValidationResponse checkComplaintExists(PatContext patientContext, String complCode);
	public ComplaintSpecialtyListResponse getComplaintSpecialtyList(PatContext patientContext);
	public ComplaintDetailsResponse getComplaintDetails(PatContext patientContext, String complaintCode);
	
}
