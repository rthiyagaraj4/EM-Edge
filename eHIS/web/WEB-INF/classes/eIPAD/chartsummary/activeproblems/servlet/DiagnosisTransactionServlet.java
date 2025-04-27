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
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import eIPAD.chartsummary.common.response.TransactionResponse;
import eIPAD.chartsummary.encounterlist.bc.EncounterListBC;
import eIPAD.chartsummary.encounterlist.healthobject.EncounterHO;
import eIPAD.chartsummary.encounterlist.request.EncounterListRequest;
import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;
import eMR.RecDiagnosis.RecDiagnosisHome;

/**
 * Servlet implementation class DiagnosisTransactionServlet
 * based on RecPatChiefComplaintServlet and RecPatChiefComplaintManager 
 */
public class DiagnosisTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mode;
		mode = request.getParameter("hdnMode") != null ? request.getParameter("hdnMode") : "";
		if(mode.equalsIgnoreCase("RECORD")){
			insert(request, response);
		}
		else if(mode.equalsIgnoreCase("MODIFY")){
			modify(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	private void insert(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{

		RequestDispatcher rd;
		PatContext patientContext;
		
		HttpSession session = req.getSession(false);
		
		Logger loggerInst = Logger.getLogger("APPLICATION_LOG");
		
		//if session is null forward to login page
		if(session == null){
			rd = getServletContext().getRequestDispatcher("/ipadlogin");
			rd.forward(req, res);	
		}
		patientContext = (PatContext)session.getAttribute("PatientContext");
		
		//if patientcontext in session returns null forward to IPlist page
		if(patientContext == null){
			rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/IPad.jsp");
			rd.forward(req, res);
		}
		ErrorInfo errorInfo;
		
		//get the Selected encounter details for getting relationship ID and specialty Code
		EncounterListRequest encReq = new EncounterListRequest();
		EncounterHO selEncHO;
		String encounterId=null;
		String locale = "en";
		if(patientContext!=null){
			encounterId = patientContext.getEncounterId();
			encReq.setPatientContext(patientContext);
			encReq.setFilterEncounterId(encounterId);
			locale = patientContext.getLocale();
		}
		EncounterListBC encBC = new EncounterListBC();
		EncounterListResponse selEncResp;
		selEncResp = encBC.getEncounterList(encReq);
		selEncHO = selEncResp.getEncounterList().get(0);
		
		HashMap tabdata=new HashMap();
		Properties p = (Properties)session.getAttribute("jdbc");
		// All variables are maintained with the same name as in the hash map required RecDiagnosisManager , unless mentioned
		String accession_number = "";
		String relationship_id = selEncHO.getRelationshipId();
		String diag_class_code = req.getParameter("hdnDiagClass")!= null ? req.getParameter("hdnDiagClass") : "";
		String associate_codes = "";
		String Practitioner_Id = patientContext.getClinicianId();
		String reason = "";
		String code_set = req.getParameter("hdnDiagSet")!= null ? req.getParameter("hdnDiagSet") : "";
		String remarks = req.getParameter("txtRemarks")!= null ? req.getParameter("txtRemarks") : "";
		String Locn_Code = selEncHO.getAssignCareLocnCode() != null ? selEncHO.getAssignCareLocnCode() : "";
		String old_encounter_id = ""; //This value is required for Modify usecase
		String type = req.getParameter("hdnOnsetType")!= null && !(req.getParameter("hdnOnsetType")).equals("") ? req.getParameter("hdnOnsetType") : "N";
		String mode = "insert";
		String called_from_ot_desc = "N";
		String priority_appl_yn = "Y";
		String x_facility_id = patientContext.getFacilityId();
		String anatomical_oral_sites = req.getParameter("hdnAnatomicalSiteVal")!= null ? req.getParameter("hdnAnatomicalSiteVal") : "";
		String code_indicator = ""; 
		String nature = req.getParameter("hdnNature")!= null ? req.getParameter("hdnNature") : "";
		String diff_group_vals = "";
		String as_evidenced_by_hid = "";
		String priority = req.getParameter("hdnPriority")!= null ? req.getParameter("hdnPriority") : "";
		String diag_Description = req.getParameter("txtDiagDesc")!= null ? req.getParameter("txtDiagDesc") : "";
		String high_risk_code = "";
		String diagprob_code = req.getParameter("hdnDiagCode")!= null ? req.getParameter("hdnDiagCode") : "";
		String Patient_Id = patientContext.getPatientId();
		String old_onset_type = ""; //This value is required for Modify usecase
		String client_ip_address = p.getProperty("client_ip_address") != null ? p.getProperty("client_ip_address") : "";
		String notifiable_code = "";
		String cause_of_death_yn = "N";
		String status = "A"; //Always active
		String onset_date = req.getParameter("hdnOnsetDateTime")!= null ? req.getParameter("hdnOnsetDateTime") : "";
		String complaint_id = req.getParameter("hdnDiagCompl")!= null ? req.getParameter("hdnDiagCompl") : "";
		String accuracy_ind = req.getParameter("hdnDiagAccInd")!= null ? req.getParameter("hdnDiagAccInd") : "";
		String severity = req.getParameter("hdnSeverity")!= null ? req.getParameter("hdnSeverity") : "";
		String Encounter_Id = patientContext.getEncounterId();
		String curr_encr_flag = "Y";
		String stage_code = req.getParameter("hdnEncStage")!= null ? req.getParameter("hdnEncStage") : "";
		String diff_group_id_hid = "";
		String call_from = "";
		String applicable_side = req.getParameter("hdnDiagApplSide")!= null ? req.getParameter("hdnDiagApplSide") : "";
		String occur_srl_no_hid = "";
		String curr_encounter_id = patientContext.getEncounterId();
		String status_date = req.getParameter("hdnAsOnDate")!= null ? req.getParameter("hdnAsOnDate") : "";
		String associate_codes_modify = "";
		String accuracy = req.getParameter("hdnDiagAcc")!= null ? req.getParameter("hdnDiagAcc") : "";
		String anatomical_site = req.getParameter("hdnAnatomicalSite")!= null ? req.getParameter("hdnAnatomicalSite") : "";
		String Locn_Type = selEncHO.getAssignCareLocnType()!= null ? selEncHO.getAssignCareLocnType() : "";
		
		tabdata.put("x_facility_id",x_facility_id);
		tabdata.put("client_ip_address",client_ip_address);
		tabdata.put("old_onset_type",old_onset_type);
		tabdata.put("Practitioner_Id",Practitioner_Id);
		tabdata.put("relationship_id",relationship_id);
		tabdata.put("Locn_Code",Locn_Code);
		tabdata.put("Locn_Type",Locn_Type);
		tabdata.put("Patient_Id",Patient_Id);
		tabdata.put("Encounter_Id",Encounter_Id);
		tabdata.put("curr_encounter_id",curr_encounter_id);
		tabdata.put("code_set",code_set);
		tabdata.put("diagprob_code",diagprob_code);
		tabdata.put("diag_Description",diag_Description);
		tabdata.put("accuracy",accuracy);
		tabdata.put("accuracy_ind",accuracy_ind);
		tabdata.put("nature",nature);
		tabdata.put("priority",priority);
		tabdata.put("severity",severity);
		tabdata.put("onset_date",onset_date);
		tabdata.put("type",type);
		tabdata.put("status",status);
		tabdata.put("status_date",status_date);
		tabdata.put("reason",reason);
		tabdata.put("remarks",remarks);
		tabdata.put("mode",mode);
		tabdata.put("priority_appl_yn",priority_appl_yn);
		tabdata.put("as_evidenced_by_hid",as_evidenced_by_hid);
		tabdata.put("associate_codes",associate_codes);
		tabdata.put("diff_group_id_hid",diff_group_id_hid);
		tabdata.put("occur_srl_no_hid",occur_srl_no_hid);
		tabdata.put("associate_codes_modify",associate_codes_modify);
		tabdata.put("code_indicator",code_indicator);
		tabdata.put("curr_encr_flag",curr_encr_flag);
		tabdata.put("diff_group_vals",diff_group_vals);
		tabdata.put("stage_code",stage_code);
		tabdata.put("cause_of_death_yn",cause_of_death_yn);
		tabdata.put("old_encounter_id",old_encounter_id);
		tabdata.put("anatomical_site",anatomical_site);
		tabdata.put("applicable_side",applicable_side);
		tabdata.put("accession_number",accession_number);
		tabdata.put("high_risk_code",high_risk_code);
		tabdata.put("diag_class_code",diag_class_code);
		tabdata.put("complaint_id",complaint_id);
		tabdata.put("anatomical_oral_sites",anatomical_oral_sites);
		tabdata.put("notifiable_code",notifiable_code);
		tabdata.put("call_from",call_from);
		tabdata.put("called_from_ot_desc",called_from_ot_desc);
		tabdata.put("diag_enc_level","N");
		
		if(loggerInst != null){
			loggerInst.info("Hash map sent to the EJB"+tabdata.toString());	
		}
		
		boolean inserted = false;
		TransactionResponse transactResp = new TransactionResponse();
		
		try
		{
			boolean local_ejbs = false;
			String error="";
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
	
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RecDiagnosis",RecDiagnosisHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
	
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;
	
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
	
			HashMap results = (HashMap)(busObj.getClass().getMethod("insertRecDiagnosis",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
	
			inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			error = (String) results.get("error") ;
		}
		catch(Exception e){
			inserted = false;
			transactResp.setTransactionResult(TransactionResponse.FAILURE);
			System.out.println("An exception occurred while adding adding a new allergy through eMR record adverse event EJB");
			e.printStackTrace();
		}
		
		if(inserted){
        	transactResp.setTransactionResult(TransactionResponse.SUCCESS);
        	errorInfo = new ErrorInfo();
        	errorInfo.setErrorType(Errors.COMMON_TRANSACTION_SUCCESS, locale);
        	transactResp.getErrorsList().add(errorInfo);
        }
        else{
        	transactResp.setTransactionResult(TransactionResponse.FAILURE);
        	errorInfo = new ErrorInfo();
        	errorInfo.setErrorType(Errors.COMMON_TRANSACTION_FAILURE, locale);
        	transactResp.getErrorsList().add(errorInfo);
        }
        req.setAttribute("TRANSACTION_RESPONSE", transactResp);
        
        rd = getServletContext().getRequestDispatcher("/mobile/chartsummary/ChartWidgetsView");
		rd.forward(req, res);
	}
	
	private void modify(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		
		RequestDispatcher rd;
		PatContext patientContext;
		
		HttpSession session = req.getSession(false);
		
		Logger loggerInst = Logger.getLogger("APPLICATION_LOG");
		
		//if session is null forward to login page
		if(session == null){
			rd = getServletContext().getRequestDispatcher("/ipadlogin");
			rd.forward(req, res);	
		}
		patientContext = (PatContext)session.getAttribute("PatientContext");
		
		//if patientcontext in session returns null forward to IPlist page
		if(patientContext == null){
			rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/IPad.jsp");
			rd.forward(req, res);
		}
		ErrorInfo errorInfo;

		String encounterId=null;
		String locale = "en";
		if(patientContext!=null){
			encounterId = patientContext.getEncounterId();
			locale = patientContext.getLocale();
		}
		
		HashMap tabdata=new HashMap();
		Properties p = (Properties)session.getAttribute("jdbc");
		// All variables are maintained with the same name as in the hash map required RecDiagnosisManager , unless mentioned
		String accession_number = req.getParameter("hdnAccessionNum")!= null ? req.getParameter("hdnAccessionNum") : "";
		String relationship_id = req.getParameter("hdnRelnId")!= null ? req.getParameter("hdnRelnId") : "";
		String diag_class_code = req.getParameter("hdnDiagClass")!= null ? req.getParameter("hdnDiagClass") : "";
		String associate_codes = "";
		String Practitioner_Id = patientContext.getClinicianId();
		String reason = "";
		String code_set = req.getParameter("hdnDiagSet")!= null ? req.getParameter("hdnDiagSet") : "";
		String remarks = req.getParameter("txtRemarks")!= null ? req.getParameter("txtRemarks") : "";
		String Locn_Code = req.getParameter("hdnLocnCode")!= null ? req.getParameter("hdnLocnCode") : ""; 
		String old_encounter_id = req.getParameter("hdnDiagEncounterId")!= null ? req.getParameter("hdnDiagEncounterId") : "";
		String type = req.getParameter("hdnOnsetType") != null ? req.getParameter("hdnOnsetType") : "N";
		String mode = "modify";
		String called_from_ot_desc = "N";
		String priority_appl_yn = "Y";
		String x_facility_id = req.getParameter("hdnDiagFacilityId")!= null ? req.getParameter("hdnDiagFacilityId") : "";
		String anatomical_oral_sites = req.getParameter("hdnAnatomicalSiteVal")!= null ? req.getParameter("hdnAnatomicalSiteVal") : "";
		String code_indicator = req.getParameter("hdnCodeIndicator")!= null ? req.getParameter("hdnCodeIndicator") : "";
		String nature = req.getParameter("hdnNature")!= null ? req.getParameter("hdnNature") : "";
		String diff_group_vals = "";
		String as_evidenced_by_hid = "";
		String priority = req.getParameter("hdnPriority")!= null ? req.getParameter("hdnPriority") : "";
		String diag_Description = req.getParameter("txtDiagDesc")!= null ? req.getParameter("txtDiagDesc") : "";
		String high_risk_code = req.getParameter("hdnHighRiskCode")!= null ? req.getParameter("hdnHighRiskCode") : "";
		String diagprob_code = req.getParameter("hdnDiagCode")!= null ? req.getParameter("hdnDiagCode") : "";
		String Patient_Id = patientContext.getPatientId();
		String old_onset_type = req.getParameter("hdnOldOnsetType")!= null ? req.getParameter("hdnOldOnsetType") : "";
		String client_ip_address = p.getProperty("client_ip_address") != null ? p.getProperty("client_ip_address") : "";
		String notifiable_code = req.getParameter("hdnNotifiableCode")!= null ? req.getParameter("hdnNotifiableCode") : "";
		String cause_of_death_yn = "N";
		String status = req.getParameter("hdnStatus")!= null ? req.getParameter("hdnStatus") : ""; //hdnStatus
		String onset_date = req.getParameter("hdnOnsetDateTime")!= null ? req.getParameter("hdnOnsetDateTime") : "";
		String complaint_id = req.getParameter("hdnDiagCompl")!= null ? req.getParameter("hdnDiagCompl") : "";
		String accuracy_ind = req.getParameter("hdnDiagAccInd")!= null ? req.getParameter("hdnDiagAccInd") : "";
		String severity = req.getParameter("hdnSeverity")!= null ? req.getParameter("hdnSeverity") : "";
		String Encounter_Id = patientContext.getEncounterId();
		String curr_encr_flag = "Y";
		String stage_code = req.getParameter("hdnEncStage")!= null ? req.getParameter("hdnEncStage") : "";
		String diff_group_id_hid = req.getParameter("hdnDiffGrpId")!= null ? req.getParameter("hdnDiffGrpId") : "";
		String call_from = "";
		String applicable_side = req.getParameter("hdnDiagApplSide")!= null ? req.getParameter("hdnDiagApplSide") : "";
		String occur_srl_no_hid = req.getParameter("hdnOccurSrlNo")!= null ? req.getParameter("hdnOccurSrlNo") : "";
		String curr_encounter_id = req.getParameter("hdnDiagEncounterId")!= null ? req.getParameter("hdnDiagEncounterId") : "";  
		String status_date = req.getParameter("hdnAsOnDate")!= null ? req.getParameter("hdnAsOnDate") : "";
		String associate_codes_modify = "";
		String accuracy = req.getParameter("hdnDiagAcc")!= null ? req.getParameter("hdnDiagAcc") : "";
		String anatomical_site = req.getParameter("hdnAnatomicalSite")!= null ? req.getParameter("hdnAnatomicalSite") : "";
		String Locn_Type = req.getParameter("hdnLocnType")!= null ? req.getParameter("hdnLocnType") : "";
		
		tabdata.put("x_facility_id",x_facility_id);
		tabdata.put("client_ip_address",client_ip_address);
		tabdata.put("old_onset_type",old_onset_type);
		tabdata.put("Practitioner_Id",Practitioner_Id);
		tabdata.put("relationship_id",relationship_id);
		tabdata.put("Locn_Code",Locn_Code);
		tabdata.put("Locn_Type",Locn_Type);
		tabdata.put("Patient_Id",Patient_Id);
		tabdata.put("Encounter_Id",Encounter_Id);
		tabdata.put("curr_encounter_id",curr_encounter_id);
		tabdata.put("code_set",code_set);
		tabdata.put("diagprob_code",diagprob_code);
		tabdata.put("diag_Description",diag_Description);
		tabdata.put("accuracy",accuracy);
		tabdata.put("accuracy_ind",accuracy_ind);
		tabdata.put("nature",nature);
		tabdata.put("priority",priority);
		tabdata.put("severity",severity);
		tabdata.put("onset_date",onset_date);
		tabdata.put("type",type);
		tabdata.put("status",status);
		tabdata.put("status_date",status_date);
		tabdata.put("reason",reason);
		tabdata.put("remarks",remarks);
		tabdata.put("mode",mode);
		tabdata.put("priority_appl_yn",priority_appl_yn);
		tabdata.put("as_evidenced_by_hid",as_evidenced_by_hid);
		tabdata.put("associate_codes",associate_codes);
		tabdata.put("diff_group_id_hid",diff_group_id_hid);
		tabdata.put("occur_srl_no_hid",occur_srl_no_hid);
		tabdata.put("associate_codes_modify",associate_codes_modify);
		tabdata.put("code_indicator",code_indicator);
		tabdata.put("curr_encr_flag",curr_encr_flag);
		tabdata.put("diff_group_vals",diff_group_vals);
		tabdata.put("stage_code",stage_code);
		tabdata.put("cause_of_death_yn",cause_of_death_yn);
		tabdata.put("old_encounter_id",old_encounter_id);
		tabdata.put("anatomical_site",anatomical_site);
		tabdata.put("applicable_side",applicable_side);
		tabdata.put("accession_number",accession_number);
		tabdata.put("high_risk_code",high_risk_code);
		tabdata.put("diag_class_code",diag_class_code);
		tabdata.put("complaint_id",complaint_id);
		tabdata.put("anatomical_oral_sites",anatomical_oral_sites);
		tabdata.put("notifiable_code",notifiable_code);
		tabdata.put("call_from",call_from);
		tabdata.put("called_from_ot_desc",called_from_ot_desc);
		tabdata.put("diag_enc_level","N");
		
		if(loggerInst != null){
			loggerInst.info("Hash map sent to the EJB"+tabdata.toString());	
		}
		
		boolean inserted = false;
		TransactionResponse transactResp = new TransactionResponse();
		
		try
		{
			boolean local_ejbs = false;
			String error="";
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
	
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RecDiagnosis",RecDiagnosisHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
	
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;
	
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
	
			HashMap results = (HashMap)(busObj.getClass().getMethod("insertRecDiagnosis",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
	
			inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			error = (String) results.get("error") ;
		}
		catch(Exception e){
			inserted = false;
			transactResp.setTransactionResult(TransactionResponse.FAILURE);
			System.out.println("An exception occurred while adding adding a new allergy through eMR record adverse event EJB");
			e.printStackTrace();
		}
		
		if(inserted){
        	transactResp.setTransactionResult(TransactionResponse.SUCCESS);
        	errorInfo = new ErrorInfo();
        	errorInfo.setErrorType(Errors.COMMON_TRANSACTION_SUCCESS, locale);
        	transactResp.getErrorsList().add(errorInfo);
        }
        else{
        	transactResp.setTransactionResult(TransactionResponse.FAILURE);
        	errorInfo = new ErrorInfo();
        	errorInfo.setErrorType(Errors.COMMON_TRANSACTION_FAILURE, locale);
        	transactResp.getErrorsList().add(errorInfo);
        }
        req.setAttribute("TRANSACTION_RESPONSE", transactResp);
        
        rd = getServletContext().getRequestDispatcher("/mobile/chartsummary/ChartWidgetsView");
		rd.forward(req, res);
	}

}
