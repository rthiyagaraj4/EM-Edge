/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.activeproblems.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eIPAD.chartsummary.activeproblems.bc.ProblemsDiagnosisBC;
import eIPAD.chartsummary.activeproblems.response.ComplaintSpecialtyListResponse;
import eIPAD.chartsummary.activeproblems.response.DiagAnatomicalSiteResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisAccuracyResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisClassificationResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisComplaintResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisCustomGroupResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisSetResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisValidationResponse;
import eIPAD.chartsummary.activeproblems.response.ProblemsDiagnosisConstants;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.encounterlist.bc.EncounterListBC;
import eIPAD.chartsummary.encounterlist.healthobject.EncounterHO;
import eIPAD.chartsummary.encounterlist.request.EncounterListRequest;
import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;
import eIPAD.chartsummary.activeproblems.healthobject.DiagnosisAccuracyHO;

import com.google.gson.Gson;

/**
 * Servlet implementation class ProblemsDiagnosisFieldValues 
 */
public class ProblemsDiagnosisJSONFieldValues extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fieldName = request.getParameter("field") == null? "":request.getParameter("field");
		PatContext patientContext;
		HttpSession session = request.getSession(false);
		patientContext = (PatContext)session.getAttribute("PatientContext");
		response.setContentType("application/json");
		Gson gson = new Gson();
		String jsonFieldResponse = "";
		
		
		if(patientContext!=null){
			if(fieldName.equals(ProblemsDiagnosisConstants.DIAGNOSIS_SET)){
				DiagnosisSetResponse diagSetResp;
				ProblemsDiagnosisBC pdBC = new ProblemsDiagnosisBC();
				diagSetResp = pdBC.getDiagnosisSetList(patientContext);
				if(diagSetResp != null && diagSetResp.isSuccessResponse()){
					jsonFieldResponse = gson.toJson(diagSetResp);
				}
			}
			else if(fieldName.equals(ProblemsDiagnosisConstants.DIAGNOSIS_CLASS)){
				String diagSetId = request.getParameter("DiagSetId");
				//DiagSetId is a mandatory parameter
				if(diagSetId != null && !diagSetId.equals("")){
					DiagnosisClassificationResponse diagClassResp;
					ProblemsDiagnosisBC pdBC = new ProblemsDiagnosisBC();
					diagClassResp = pdBC.getDiagnosisClassificationList(patientContext, diagSetId);
					if(diagClassResp != null && diagClassResp.isSuccessResponse()){
						jsonFieldResponse = gson.toJson(diagClassResp);
					}
				}
			}
			else if(fieldName.equals(ProblemsDiagnosisConstants.DIAGNOSIS_COMPLAINTS)){
				String diagSetId = request.getParameter("DiagSetId");
				//DiagSetId is a mandatory parameter
				if(diagSetId != null && !diagSetId.equals("")){
					DiagnosisComplaintResponse diagComplResp;
					ProblemsDiagnosisBC pdBC = new ProblemsDiagnosisBC();
					diagComplResp = pdBC.getDiagnosisComplaintsList(patientContext, diagSetId);
					if(diagComplResp != null && diagComplResp.isSuccessResponse()){
						jsonFieldResponse = gson.toJson(diagComplResp);
					}
				}
				
			}
			else if(fieldName.equals(ProblemsDiagnosisConstants.DIAGNOSIS_COMPLAINTS_EXISTING)){
				String diagSetId = request.getParameter("DiagSetId");
				String diagCode = request.getParameter("DiagCode");
				String occurSrlNo = request.getParameter("OccurSrlNo");
				//DiagSetId is a mandatory parameter
				if(diagSetId != null && !diagSetId.equals("")){
					DiagnosisComplaintResponse diagComplResp;
					ProblemsDiagnosisBC pdBC = new ProblemsDiagnosisBC();
					diagComplResp = pdBC.getDiagnosisComplaintsListExisting(patientContext, diagSetId, diagCode, occurSrlNo);
					if(diagComplResp != null && diagComplResp.isSuccessResponse()){
						jsonFieldResponse = gson.toJson(diagComplResp);
					}
				}
				
			}
			else if(fieldName.equals(ProblemsDiagnosisConstants.DIAGNOSIS_ACCURACY)){
				DiagnosisAccuracyResponse diagAccResp;
				ProblemsDiagnosisBC pdBC = new ProblemsDiagnosisBC();
				diagAccResp = pdBC.getDiagnosisAccuracyList(patientContext);
				if(diagAccResp != null && diagAccResp.isSuccessResponse()){
					jsonFieldResponse = gson.toJson(diagAccResp);
				}
			}
			else if(fieldName.equals(ProblemsDiagnosisConstants.DIAGNOSIS_ANATOMICALSITE)){
				boolean oralCavity = false;
				String oralCavityStr = request.getParameter("OralCavity");
				if(oralCavityStr!=null && !oralCavityStr.equals("") && oralCavityStr.equals("C")){
					oralCavity = true;
				}
				//DiagSetId is a mandatory parameter
				DiagAnatomicalSiteResponse diagAnatResp;
				ProblemsDiagnosisBC pdBC = new ProblemsDiagnosisBC();
				diagAnatResp = pdBC.getDiagnosisAnatomicalSiteList(patientContext, oralCavity);
				if(diagAnatResp != null && diagAnatResp.isSuccessResponse()){
					jsonFieldResponse = gson.toJson(diagAnatResp);
				}
			} 
			else if(fieldName.equals(ProblemsDiagnosisConstants.DIAGNOSIS_CUSTOMLIST)){
				//get the Selected encounter details for getting relationship ID and specialty Code
				EncounterListRequest encReq = new EncounterListRequest();
				EncounterHO selEncHO;
				String encounterId=null;
				if(patientContext!=null){
					//encounterId = (patientContext.getSelectedEncounterId() == null || patientContext.getSelectedEncounterId().equals("")) ? patientContext.getEncounterId() : patientContext.getSelectedEncounterId();
					encounterId = patientContext.getEncounterId();
					encReq.setPatientContext(patientContext);
					encReq.setFilterEncounterId(encounterId);
				}
				EncounterListBC encBC = new EncounterListBC();
				EncounterListResponse selEncResp;
				selEncResp = encBC.getEncounterList(encReq);
				selEncHO = selEncResp.getEncounterList().get(0);
				
				String diagSetId = request.getParameter("DiagSetId");
				DiagnosisCustomGroupResponse diagCustomGroupResp;
				ProblemsDiagnosisBC pdBC = new ProblemsDiagnosisBC();
				if(diagSetId != null && !diagSetId.equals("")){
					diagCustomGroupResp = pdBC.getDiagnosisCustomGroupList(patientContext, diagSetId, selEncHO.getSpecialtyCode());
					if(diagCustomGroupResp != null && diagCustomGroupResp.isSuccessResponse()){
						jsonFieldResponse = gson.toJson(diagCustomGroupResp);
					}
				}
			}
			else if(fieldName.equals(ProblemsDiagnosisConstants.DIAGNOSIS_DUPLICATEVALIDATION)){
				String diagSetId = request.getParameter("DiagSetId");
				String diagCode = request.getParameter("DiagCode");
				ProblemsDiagnosisBC pdBC = new ProblemsDiagnosisBC();
				DiagnosisValidationResponse resp;
				if(diagSetId != null && !diagSetId.equals("") && diagCode != null && !diagCode.equals("")){
					resp = pdBC.checkActiveDiagnosisExists(patientContext, diagSetId, diagCode);
					if(resp != null){
						jsonFieldResponse = gson.toJson(resp);
					}
				}
				
			}
			else if(fieldName.equals(ProblemsDiagnosisConstants.DIAGNOSIS_DUPLICATEPRIMARYVALIDATION)){
				String diagSetId = request.getParameter("DiagSetId");
				ProblemsDiagnosisBC pdBC = new ProblemsDiagnosisBC();
				DiagnosisValidationResponse resp;
				if(diagSetId != null && !diagSetId.equals("")){
					resp = pdBC.checkPrimaryDiagnosisExists(patientContext, diagSetId);
					if(resp != null){
						jsonFieldResponse = gson.toJson(resp);
					}
				}
				
			}
			else if(fieldName.equals(ProblemsDiagnosisConstants.COMPLAINT_DUPLICATEVALIDATION)){
				String complCode = request.getParameter("ComplaintCode");
				ProblemsDiagnosisBC pdBC = new ProblemsDiagnosisBC();
				DiagnosisValidationResponse resp;
				if(complCode != null && !complCode.equals("")){
					resp = pdBC.checkComplaintExists(patientContext, complCode);
					if(resp != null){
						jsonFieldResponse = gson.toJson(resp);
					}
				}
				
			}
			else if(fieldName.equals(ProblemsDiagnosisConstants.COMPLAINT_SPECIALTYLIST)){
				ProblemsDiagnosisBC pdBC = new ProblemsDiagnosisBC();
				ComplaintSpecialtyListResponse resp;
					resp = pdBC.getComplaintSpecialtyList(patientContext);
					if(resp != null){
						jsonFieldResponse = gson.toJson(resp);
					}
				
				
			}
		}
		response.setContentType("application/json");
		response.getWriter().write(jsonFieldResponse);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
