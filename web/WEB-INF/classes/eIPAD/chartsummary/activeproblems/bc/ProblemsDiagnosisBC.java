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
package eIPAD.chartsummary.activeproblems.bc;

import eIPAD.chartsummary.activeproblems.dao.ProblemsDiagnosisDAO;
import eIPAD.chartsummary.activeproblems.daoimpl.ProblemsDiagnosisDAOImpl;
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
public class ProblemsDiagnosisBC {
	public ProblemsDiagnosisResponse getActiveProblemsAndDiagnosis(ProblemsDiagnosisRequest request) {
		ProblemsDiagnosisResponse resp = new ProblemsDiagnosisResponse();
		ProblemsDiagnosisDAO dao = new ProblemsDiagnosisDAOImpl();
		resp = dao.getActiveProblemsAndDiagnosis(request);
		return resp;
	}
	public int isUserAuthorizedForSensitiveDate(PatContext patientContext, String password){
		ProblemsDiagnosisDAO dao = new ProblemsDiagnosisDAOImpl();
		return dao.isUserAuthorizedForSensitiveDate(patientContext, password);
	}
	
	public ProblemsDiagnosisResponse getLinkedProblemsForDiagnosis(PatContext patientContext, String termSetId, String diagCode, String termSetDesc, String occurSrlNo){
		ProblemsDiagnosisResponse resp = new ProblemsDiagnosisResponse();
		ProblemsDiagnosisDAO dao = new ProblemsDiagnosisDAOImpl();
		resp = dao.getLinkedProblemsForDiagnosis(patientContext,termSetId,diagCode,termSetDesc,occurSrlNo);
		return resp;
	}
	public EncounterListResponse getLinkedEncountersForDiagnosis(PatContext patientContext, String termSetId, String diagCode, String status){
		EncounterListResponse resp = new EncounterListResponse();
		ProblemsDiagnosisDAO dao = new ProblemsDiagnosisDAOImpl();
		resp = dao.getLinkedEncountersForDiagnosis(patientContext,termSetId,diagCode,status);
		return resp;
	}
	public DiagnosisSetResponse getDiagnosisSetList(PatContext patientContext){
		DiagnosisSetResponse resp;
		ProblemsDiagnosisDAO dao = new ProblemsDiagnosisDAOImpl();
		resp = dao.getDiagnosisSetList(patientContext);
		return resp;
	}
	public DiagnosisComplaintResponse getDiagnosisComplaintsList(PatContext patientContext, String diagSetId ){
		DiagnosisComplaintResponse resp;
		ProblemsDiagnosisDAO dao = new ProblemsDiagnosisDAOImpl();
		resp = dao.getDiagnosisComplaintsList(patientContext, diagSetId);
		return resp;
	}
	public DiagnosisClassificationResponse getDiagnosisClassificationList(PatContext patientContext, String diagSetId){
		DiagnosisClassificationResponse resp;
		ProblemsDiagnosisDAO dao = new ProblemsDiagnosisDAOImpl();
		resp = dao.getDiagnosisClassificationList(patientContext,diagSetId);
		return resp;
	}
	public DiagnosisAccuracyResponse getDiagnosisAccuracyList(PatContext patientContext){
		DiagnosisAccuracyResponse resp;
		ProblemsDiagnosisDAO dao = new ProblemsDiagnosisDAOImpl();
		resp = dao.getDiagnosisAccuracyList(patientContext);
		return resp;
	}
	public DiagAnatomicalSiteResponse getDiagnosisAnatomicalSiteList(PatContext patientContext, boolean oralCavity){
		DiagAnatomicalSiteResponse resp;
		ProblemsDiagnosisDAO dao = new ProblemsDiagnosisDAOImpl();
		resp = dao.getDiagnosisAnatomicalSiteList(patientContext,oralCavity);
		return resp;
	}
	public DiagnosisSfsResponse getDiagnosisCodeList(DiagnosisSfsRequest req){
		DiagnosisSfsResponse resp;
		ProblemsDiagnosisDAO dao = new ProblemsDiagnosisDAOImpl();
		resp = dao.getDiagnosisCodeList(req);
		return resp;
	}
	public ComplaintSfsResponse getComplaintCodeList(ComplaintSfsRequest req){
		ComplaintSfsResponse resp;
		ProblemsDiagnosisDAO dao = new ProblemsDiagnosisDAOImpl();
		resp = dao.getComplaintCodeList(req);
		return resp;
	}
	public DiagnosisCustomGroupResponse getDiagnosisCustomGroupList(PatContext patientContext, String diagSetId, String specialtyCode){
		DiagnosisCustomGroupResponse resp;
		ProblemsDiagnosisDAO dao = new ProblemsDiagnosisDAOImpl();
		resp = dao.getDiagnosisCustomGroupList(patientContext,diagSetId,specialtyCode);
		return resp;
	}
	public DiagnosisValidationResponse checkActiveDiagnosisExists(PatContext patientContext, String diagSetId, String diagnosisCode){
		DiagnosisValidationResponse resp;
		ProblemsDiagnosisDAO dao = new ProblemsDiagnosisDAOImpl();
		resp = dao.checkActiveDiagnosisExists(patientContext,diagSetId,diagnosisCode);
		return resp;
	}
	public DiagnosisValidationResponse checkPrimaryDiagnosisExists(PatContext patientContext, String diagSetId){
		DiagnosisValidationResponse resp;
		ProblemsDiagnosisDAO dao = new ProblemsDiagnosisDAOImpl();
		resp = dao.checkPrimaryDiagnosisExists(patientContext,diagSetId);
		return resp;
	}
	public DiagnosisDetailsResponse getDiagnosisDetails(PatContext patientContext, String diagSetId, String diagCode, String occurSrlNo){
		DiagnosisDetailsResponse resp;
		ProblemsDiagnosisDAO dao = new ProblemsDiagnosisDAOImpl();
		resp = dao.getDiagnosisDetails(patientContext,diagSetId,diagCode,occurSrlNo);
		return resp;
	}
	public DiagnosisComplaintResponse getDiagnosisComplaintsListExisting(PatContext patientContext, String diagSetId, String diagCode, String occurSrlNo){
		DiagnosisComplaintResponse resp;
		ProblemsDiagnosisDAO dao = new ProblemsDiagnosisDAOImpl();
		resp = dao.getDiagnosisComplaintsListExisting(patientContext,diagSetId,diagCode,occurSrlNo);
		return resp;
	}
	public DiagnosisValidationResponse checkComplaintExists(PatContext patientContext, String complCode){
		DiagnosisValidationResponse resp;
		ProblemsDiagnosisDAO dao = new ProblemsDiagnosisDAOImpl();
		resp = dao.checkComplaintExists(patientContext,complCode);
		return resp;
	}
	public ComplaintSpecialtyListResponse getComplaintSpecialtyList(PatContext patientContext){
		ComplaintSpecialtyListResponse resp;
		ProblemsDiagnosisDAO dao = new ProblemsDiagnosisDAOImpl();
		resp = dao.getComplaintSpecialtyList(patientContext);
		return resp;
	}
	public ComplaintDetailsResponse getComplaintDetails(PatContext patientContext, String complaintCode){
		ComplaintDetailsResponse resp;
		ProblemsDiagnosisDAO dao = new ProblemsDiagnosisDAOImpl();
		resp = dao.getComplaintDetails(patientContext,complaintCode);
		return resp;
	}
}
