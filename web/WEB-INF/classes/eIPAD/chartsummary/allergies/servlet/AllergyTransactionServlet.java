/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.allergies.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.ehis.util.DateUtils;

import eIPAD.chartsummary.allergies.bc.AllergyBC;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import eIPAD.chartsummary.common.response.TransactionResponse;
import eIPAD.chartsummary.encounterlist.bc.EncounterListBC;
import eIPAD.chartsummary.encounterlist.healthobject.EncounterHO;
import eIPAD.chartsummary.encounterlist.request.EncounterListRequest;
import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;

/**
 * Servlet implementation class AllergyTransactionServlet  
 */
public class AllergyTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mode;
		mode = request.getParameter("hdnTransactionMode") != null ? request.getParameter("hdnTransactionMode") : "";
		if(mode.equalsIgnoreCase("insert")){
			insert(request, response);
		}
		else if(mode.equalsIgnoreCase("modify")){
			modify(request, response);
		}
	}
	private void insert(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		

		RequestDispatcher rd;
		PatContext patientContext;
		
		HttpSession session = req.getSession(false);
		
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
		
		// All variables are maintained with the same name as in the hash map required RecordAdverseEventManager , unless mentioned 
		String modifiedById = "";
		String modifiedAtWorkstation = "";
		String facilityId;
		String locale = "en";
		java.sql.Date added_date;
		
		String PatientId;
		String Encounter_Id;
		
		
		
		String certainity;
		String adv_event_ind;
		String adv_event_type;
		String allergen;
		String onset_date;
		String cause_sub;
		String status_date;
		String route_exp;
		String allergy_test_res;
		String drug_code;
		String status1;
		String no_known_allergy;
		String treat_advice;
		String remarks;
		String sou_of_info;
		String diagnosis_code;
		String term_code;
		String estimated_duration_yn;
		String AllergyConfirmYN;
		String allergy_conf_reqd_yn;
		
		String visit_adm_date_time = "";
		String assign_care_locn_type = "";
		String assign_care_locn_code = "";
		String attend_practitioner_id = "";
		String adv_event_srl_no = "";
		String comments = "";
		String onset_type = "N";
		int adv_event_srl_no_int;
		
		String reaction_date;
		String reaction_code;
		String reaction_desc;
		String severity;
		String Site_Of_Reac_val;
		
		//reac_desc_val variable is not needed in INSERT
		String react_code_val = ""; //othercode1||otherscode2`code1`code2
		String react_values_main = "";//@reaction_date`reactioncode`severity`reactionsite
		String other_reaction_main = "";
		
		/*Below parameters added for this CRF Bru-HIMS-CRF-133*/
		String isPatientEncMovement = "";
	    String Sydate = "";
		String p_queue_date = "";
		String p_queue_status = "";
		//End Bru-HIMS-CRF-133
		
		String react_srlno_to_add; 
		String react_srlnos[];
		
		//27-Dec-2013 The ejb expects value for this hash map 
		//Recently added by PAS Team. Not sure of its functionality. Sending default value 'N' for now, until PMG confirms
		String allergyAlertby = "N";

		Properties p = (Properties)session.getAttribute("jdbc");
		if(p != null){
			modifiedAtWorkstation = p.getProperty("client_ip_address") != null ? p.getProperty("client_ip_address") : "";
			modifiedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
			locale = p.getProperty("LOCALE"); 
		}
		PatientId = patientContext.getPatientId(); //req.getParameter("PatientId")!= null ? req.getParameter("PatientId"):"";
		facilityId = (String)session.getAttribute("facility_id");
		Encounter_Id = patientContext.getEncounterId();

			
		certainity = req.getParameter("certainity")!= null ? req.getParameter("certainity") : "D"; //D is Default -- D-Definitive P-Probable -- field not available in EM-Mobile
		adv_event_ind = req.getParameter("hdnHypSensitivity")!= null ? req.getParameter("hdnHypSensitivity") : ""; //01 - Allergy
		adv_event_type = req.getParameter("hdnEventTypeCode")!= null ? req.getParameter("hdnEventTypeCode") : ""; //Event type code
		allergen = req.getParameter("hdnAllergenCode")!= null ? req.getParameter("hdnAllergenCode") : ""; //Allergen code
		onset_date = req.getParameter("hdnOnsetDateTime")!= null ? req.getParameter("hdnOnsetDateTime") : ""; //Allergy onset date
		comments = req.getParameter("comments")!= null ? req.getParameter("comments") : "";
		onset_type = req.getParameter("onset_type")!= null ? req.getParameter("onset_type") : "N";//Default N --- Onset type -- field not available in EM-Mobile
		if(adv_event_type.equals("DA")){
			cause_sub = req.getParameter("txtCAS")!= null ? req.getParameter("txtCAS") : ""; //Causative Substance text value
		}
		else{
			cause_sub = req.getParameter("txtCA")!= null ? req.getParameter("txtCA") : ""; //Causative Substance text value
		}
		
		status_date = req.getParameter("hdnActiveSinceDate")!= null ? req.getParameter("hdnActiveSinceDate") : ""; //Active date
		route_exp = req.getParameter("route_exp")!= null ? req.getParameter("route_exp") : ""; //Route of Exposure -- field not available in EM-Mobile
		allergy_test_res = req.getParameter("allergy_test_res")!= null ? req.getParameter("allergy_test_res") : ""; //Allergy Test Result -- field not available in EM-Mobile
		treat_advice = req.getParameter("treat_advice")!= null ? req.getParameter("treat_advice") : ""; //Treat Advice/Action Taken -- field not available in EM-Mobile
		remarks = req.getParameter("remarks")!= null ? req.getParameter("remarks") : ""; //Remarks -- field not available in EM-Mobile
		sou_of_info = req.getParameter("sou_of_info")!= null ? req.getParameter("sou_of_info") : "P"; //Source of Info P is default P-Patient Observation, A-Allergy Test Result, S-Staff Observation -- field not available in EM-Mobile
		diagnosis_code = req.getParameter("diagnosis_code")!= null ? req.getParameter("diagnosis_code") : ""; //-- field not available in EM-Mobile
		term_code = req.getParameter("term_code")!= null ? req.getParameter("term_code") : ""; //passed in ADD alone, as empty value -- field not available in EM-Mobile
		drug_code = req.getParameter("hdnCACode")!= null ? req.getParameter("hdnCACode") : ""; //Causative Substance Code
		status1 = req.getParameter("status1")!= null ? req.getParameter("status1") : ""; //Default A -- A-Active R-Resolved E-In Error - Can be left empty in ADD allergy -- field not available in EM-Mobile
		no_known_allergy = req.getParameter("no_known_allergy")!= null ? req.getParameter("no_known_allergy") : "Y"; //Y in the case of ADD allergy
		estimated_duration_yn = req.getParameter("hdnEstimatedDuration")!= null ? req.getParameter("hdnEstimatedDuration") : "N"; //Estimated duration No-N is default
		AllergyConfirmYN = "N";
		allergy_conf_reqd_yn = "N";
		
		react_srlno_to_add = req.getParameter("hdnReactionsToAdd")!= null ? req.getParameter("hdnReactionsToAdd") : "";
		react_srlnos = react_srlno_to_add.split("`");
		
		onset_date			= DateUtils.convertDate(onset_date,"DMYHMS",locale,"en");
		status_date			= DateUtils.convertDate(status_date,"DMY",locale,"en");

		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
		String addedDate = dateFormat.format( new java.util.Date() ) ;
		added_date = java.sql.Date.valueOf( addedDate ) ;
		
	
		EncounterListRequest encRequest = new EncounterListRequest();
		EncounterListResponse encResponse;
		EncounterListBC encBC = new EncounterListBC();
		ArrayList<EncounterHO> encounterList;
		
		//setting filter criteria for encounter list request to get the details of current encounter alone
		encRequest.setPatientContext(patientContext);
		encRequest.setFilterEncounterId(Encounter_Id);
		encRequest.setFilterFacilityId(facilityId);
		
		encResponse = encBC.getEncounterList(encRequest);		
		if(encResponse.isSuccessResponse() && !encResponse.isEmptyDataResponse()){
			encounterList = encResponse.getEncounterList();
			visit_adm_date_time = checkForNull(encounterList.get(0).getVisitDate());
			assign_care_locn_type = checkForNull(encounterList.get(0).getAssignCareLocnType());
			assign_care_locn_code = checkForNull(encounterList.get(0).getAssignCareLocnCode());
			attend_practitioner_id = checkForNull(encounterList.get(0).getAttendPractitionerId());
		}
		
		AllergyBC allergyBC = new AllergyBC();
		adv_event_srl_no_int = allergyBC.getMaxAllergyEventSerialNo(PatientId, adv_event_ind, adv_event_type, allergen);
		//negative number is returned in case of a exception in dao class
		if(adv_event_srl_no_int>=0){
			adv_event_srl_no_int++;
			adv_event_srl_no = String.valueOf(adv_event_srl_no_int);
		}
		
		for(int i=0;i<react_srlnos.length;i++){
			String current_react_srlno = react_srlnos[i];
			reaction_date = checkForNull(req.getParameter("hdnReactionDateTime"+current_react_srlno));
			reaction_date = DateUtils.convertDate(reaction_date,"DMYHM",locale,"en");
			reaction_code = checkForNull(req.getParameter("reactionCode"+current_react_srlno));
			reaction_desc = checkForNull(req.getParameter("reactionDesc"+current_react_srlno));
			severity=checkForNull(req.getParameter("hdnScale"+current_react_srlno));
			if(severity.equals("")) severity="$";
			Site_Of_Reac_val = checkForNull(req.getParameter("txtSite"+current_react_srlno));
			if(Site_Of_Reac_val.equals("")) Site_Of_Reac_val="$";
			if(reaction_code.equals("Oth")){
				other_reaction_main = other_reaction_main+"@"+reaction_date +"`"+reaction_desc+"`"+severity+"`"+Site_Of_Reac_val;
				react_code_val = react_code_val + reaction_desc + "||";
			}
			else{
				react_values_main = react_values_main+"@"+reaction_date +"`"+reaction_code+"`"+severity+"`"+Site_Of_Reac_val;
				react_code_val = react_code_val + reaction_code + "`";
			}
			
		}
		

		
		HashMap hashmap = new HashMap();
        hashmap.put("p", p);
		hashmap.put("PatientId",PatientId);
        hashmap.put("certainity", certainity);
        // hashmap.put("severity_head", severity_head);
        hashmap.put("adv_event_ind", adv_event_ind);
        hashmap.put("adv_event_type", adv_event_type);
        hashmap.put("allergen", allergen);
        hashmap.put("onset_date", onset_date);
		hashmap.put("Encounter_Id",Encounter_Id);
		hashmap.put("cause_sub", cause_sub);
		hashmap.put("route_exp",route_exp);
		// hashmap.put("severity", severity);
		// hashmap.put("reaction_date", reaction_date);
		// hashmap.put("other_reaction", other_reaction);
		// hashmap.put("Site_Of_Reac", Site_Of_Reac);
        hashmap.put("allergy_test_res", allergy_test_res);
        hashmap.put("treat_advice", treat_advice);
        hashmap.put("remarks",remarks);
		hashmap.put("sou_of_info",sou_of_info);
		hashmap.put("react_values_main",react_values_main);
		hashmap.put("other_reaction_main",other_reaction_main);
		hashmap.put("facilityId",facilityId);
		hashmap.put("modifiedById",modifiedById);
		hashmap.put("modifiedAtWorkstation",modifiedAtWorkstation);
		hashmap.put("added_date", added_date);
		hashmap.put("visit_adm_date_time",visit_adm_date_time);
		hashmap.put("assign_care_locn_type",assign_care_locn_type);
		hashmap.put("assign_care_locn_code",assign_care_locn_code);
		hashmap.put("attend_practitioner_id",attend_practitioner_id);
		hashmap.put("adv_event_srl_no", adv_event_srl_no);
		hashmap.put("diagnosis_code",diagnosis_code);
		hashmap.put("term_code",term_code);
		//hashmap.put("status_date",status_date);
		hashmap.put("status_date",status_date);
		hashmap.put("react_code_val",react_code_val);
		hashmap.put("drug_code",drug_code);
		hashmap.put("status1",status1);
		hashmap.put("no_known_allergy",no_known_allergy);
		hashmap.put("estimated_duration_yn",estimated_duration_yn);
		hashmap.put("AllergyConfirmYN",AllergyConfirmYN);//Added for the crf - RUT-CRF-0064
		hashmap.put("allergy_conf_reqd_yn",allergy_conf_reqd_yn);//Added for the crf - RUT-CRF-0064
		//hashmap.put("Site_Of_Reac_oth",Site_Of_Reac_oth);
		//hashmap.put("severity_oth",severity_oth);
		//hashmap.put("other_reaction_date",other_reaction_date);
		//hashmap.put("other_reaction",other_reaction);
		hashmap.put("allergyAlertby", allergyAlertby);
		hashmap.put("comments",comments);
		hashmap.put("onset_type",onset_type);
		hashmap.put("isPatientEncMovement", isPatientEncMovement);
		hashmap.put("Sydate", Sydate);
		hashmap.put("p_queue_date", p_queue_date);
		hashmap.put("p_queue_status", p_queue_status);
		

		try{
			boolean flag = false;
	        flag = true;
	        Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RecordAdverseEvent", eMR.RecordAdverseEvent.RecordAdverseEventHome.class, flag);
	        Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
	        Object aobj[] = new Object[2];
	        aobj[0] = p;
	        aobj[1] = hashmap;
	        Class aclass[] = new Class[2];
	        aclass[0] = p.getClass();
	        aclass[1] = hashmap.getClass();
	        HashMap hashmap1 = (HashMap)obj1.getClass().getMethod("insertAdveEvent", aclass).invoke(obj1, aobj);
	        obj1.getClass().getMethod("remove", null).invoke(obj1, null);
	        boolean flag1 = ((Boolean)hashmap1.get("status")).booleanValue();
	        
	        TransactionResponse transactResp = new TransactionResponse();
	           
	        
	        if(flag1){
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
	        hashmap.clear();
			hashmap1.clear(); 
			
		}
		catch(Exception e){
			System.out.println("An exception occurred while adding adding a new allergy through eMR record adverse event EJB");
			e.printStackTrace();
		}
		finally{
			rd = getServletContext().getRequestDispatcher("/mobile/chartsummary/ChartWidgetsView");
			rd.forward(req, res);
		}
	}

	private void modify(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{

		
		RequestDispatcher rd;
		PatContext patientContext;
		
		HttpSession session = req.getSession(false);
		
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
		
		// All variables are maintained with the same name as in the hash map required RecordAdverseEventManager , unless mentioned 
		String modifiedById = "";
		String modifiedAtWorkstation = "";
		String facilityId;
		String locale = "en";
		java.sql.Date added_date;
		
		String PatientId;
		String Encounter_Id;
		
		
		
		String certainity;
		String adv_event_ind;
		String adv_event_type;
		String allergen;
		String onset_date;
		String cause_sub;
		String status_date;
		String route_exp;
		String allergy_test_res;
		String drug_code;
		String status1;
		String no_known_allergy;
		String treat_advice;
		String remarks;
		String sou_of_info;
		String diagnosis_code;
		//String term_code;
		String estimated_duration_yn;
		String Site_Of_Reac;
		String err_remarks;
		String chkreact1;
		
		
/*		String visit_adm_date_time = "";
		String assign_care_locn_type = "";
		String assign_care_locn_code = "";
		String attend_practitioner_id = "";*/
		
		String adv_event_srl_no = "";
		int adv_event_srl_no_int;
		String adv_dtl_srl_num = "";
		int adv_dtl_srl_num_int;
		
		String reaction_date;
		String reaction_code;
		String reaction_desc;
		String severity;
		String Site_Of_Reac_val;
		
		String reac_desc_val = "";
		String react_code_val = ""; //othercode1||otherscode2`code1`code2
		String react_values_main = "";//@reaction_date`reactioncode`severity`reactionsite
		String other_reaction_main = "";
		
		String react_srlno_to_add; 
		String react_srlnos[] = null;
		
		String reacs_to_error;
		String err_reacts[] = null;
		
		//27-Dec-2013 The ejb expects value for this hash map 
		//Recently added by PAS Team. Not sure of its functionality. Sending default value 'N' for now, until PMG confirms
		String allergyAlertby = "N";
		
		boolean isAddReactionSuccessful = true;
		
		Properties p = (Properties)session.getAttribute("jdbc");
		if(p != null){
			modifiedAtWorkstation = p.getProperty("client_ip_address") != null ? p.getProperty("client_ip_address") : "";
			modifiedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
			locale = p.getProperty("LOCALE"); 
		}
		PatientId = patientContext.getPatientId(); //req.getParameter("PatientId")!= null ? req.getParameter("PatientId"):"";
		facilityId = (String)session.getAttribute("facility_id");
		Encounter_Id = patientContext.getEncounterId();
		
		adv_event_ind = req.getParameter("hdnHypSensitivity")!= null ? req.getParameter("hdnHypSensitivity") : ""; //01 - Allergy
		adv_event_type = req.getParameter("hdnEventTypeCode")!= null ? req.getParameter("hdnEventTypeCode") : ""; //Event type code
		allergen = req.getParameter("hdnAllergenCode")!= null ? req.getParameter("hdnAllergenCode") : ""; //Allergen code

		react_srlno_to_add = req.getParameter("hdnReactionsToAdd")!= null ? req.getParameter("hdnReactionsToAdd") : "";
		if(!react_srlno_to_add.equals("")){
			react_srlnos = react_srlno_to_add.split("`");
		}
		
		reacs_to_error = req.getParameter("hdnErrorReactions")!= null ? req.getParameter("hdnErrorReactions") : "";
		if(!reacs_to_error.equals("")){
			err_reacts = reacs_to_error.split("`");
		}
		
        TransactionResponse transactResp = new TransactionResponse();
        
		//if there are any reactions to add
		if(react_srlnos != null && react_srlnos.length > 0){
			certainity = req.getParameter("certainity")!= null ? req.getParameter("certainity") : "D"; //D is Default -- D-Definitive P-Probable -- field not available in EM-Mobile
			onset_date = req.getParameter("hdnOnsetDateTime")!= null ? req.getParameter("hdnOnsetDateTime") : ""; //Allergy onset date
			if(adv_event_type.equals("DA")){
				cause_sub = req.getParameter("txtCAS")!= null ? req.getParameter("txtCAS") : ""; //Causative Substance text value
			}
			else{
				cause_sub = req.getParameter("txtCA")!= null ? req.getParameter("txtCA") : ""; //Causative Substance text value
			}
			status_date = req.getParameter("hdnActiveSinceDate")!= null ? req.getParameter("hdnActiveSinceDate") : ""; //Active date
			route_exp = req.getParameter("route_exp")!= null ? req.getParameter("route_exp") : ""; //Route of Exposure -- field not available in EM-Mobile
			allergy_test_res = req.getParameter("allergy_test_res")!= null ? req.getParameter("allergy_test_res") : ""; //Allergy Test Result -- field not available in EM-Mobile
			treat_advice = req.getParameter("treat_advice")!= null ? req.getParameter("treat_advice") : ""; //Treat Advice/Action Taken -- field not available in EM-Mobile
			remarks = req.getParameter("remarks")!= null ? req.getParameter("remarks") : ""; //Remarks -- field not available in EM-Mobile
			sou_of_info = req.getParameter("sou_of_info")!= null ? req.getParameter("sou_of_info") : "P"; //Source of Info P is default P-Patient Observation, A-Allergy Test Result, S-Staff Observation -- field not available in EM-Mobile
			diagnosis_code = req.getParameter("diagnosis_code")!= null ? req.getParameter("diagnosis_code") : ""; //-- field not available in EM-Mobile
			//term_code = req.getParameter("term_code")!= null ? req.getParameter("term_code") : ""; //passed in ADD alone, as empty value -- field not available in EM-Mobile
			drug_code = req.getParameter("hdnCACode")!= null ? req.getParameter("hdnCACode") : ""; //Causative Substance Code
			status1 = req.getParameter("status1")!= null ? req.getParameter("status1") : ""; //Default A -- A-Active R-Resolved E-In Error - Can be left empty in ADD allergy -- field not available in EM-Mobile
			no_known_allergy = req.getParameter("no_known_allergy")!= null ? req.getParameter("no_known_allergy") : "Y"; //Y in the case of ADD allergy
			estimated_duration_yn = req.getParameter("hdnEstimatedDuration")!= null ? req.getParameter("hdnEstimatedDuration") : "N"; //Estimated duration No-N is default
			Site_Of_Reac = req.getParameter("Site_Of_Reac")!= null ? req.getParameter("Site_Of_Reac") : ""; //Site_Of_Reac is always passed as empty and is passed in MODIFY alone
			err_remarks = req.getParameter("err_remarks")!= null ? req.getParameter("err_remarks") : ""; //err_remarks is always passed as empty in MODIFY since there is no provision in EM-Mobile to mark an allergy as error
			chkreact1 = req.getParameter("chkreact1")!= null ? req.getParameter("chkreact1") : "N"; //chkreact1 is always passed as "N" in MODIFY but this value is not used in the EJB RecordAdverseEventManager
			reaction_date = req.getParameter("reaction_date")!= null ? req.getParameter("reaction_date") : ""; //reaction_date is passed with some date in MODIFY but this value is not used in the EJB RecordAdverseEventManager
			severity = req.getParameter("severity")!= null ? req.getParameter("severity") : ""; //this value is not used in the EJB RecordAdverseEventManager. Specifying it here inorder to maintain consistency
			
			
			
			onset_date			= DateUtils.convertDate(onset_date,"DMYHMS",locale,"en");
			status_date			= DateUtils.convertDate(status_date,"DMY",locale,"en");
	
			java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			added_date = java.sql.Date.valueOf( addedDate ) ;
			
	/*		reactionCountstr = req.getParameter("count")!= null ? req.getParameter("count") : "";
			otherReactionCountStr = req.getParameter("oth_count")!= null ? req.getParameter("oth_count") : "";
			reactionCount = Integer.parseInt(reactionCountstr);
			otherReactionCount = Integer.parseInt(otherReactionCountStr);*/
			
	/*		EncounterListRequest encRequest = new EncounterListRequest();
			EncounterListResponse encResponse;
			EncounterListBC encBC = new EncounterListBC();
			ArrayList<EncounterHO> encounterList;
			
			//setting filter criteria for encounter list request to get the details of current encounter alone
			encRequest.setPatientContext(patientContext);
			encRequest.setFilterEncounterId(Encounter_Id);
			encRequest.setFilterFacilityId(facilityId);
			
			encResponse = encBC.getEncounterList(encRequest);		
			if(encResponse.isSuccessResponse() && !encResponse.isEmptyDataResponse()){
				encounterList = encResponse.getEncounterList();
				visit_adm_date_time = checkForNull(encounterList.get(0).getVisitDate());
				assign_care_locn_type = checkForNull(encounterList.get(0).getAssignCareLocnType());
				assign_care_locn_code = checkForNull(encounterList.get(0).getAssignCareLocnCode());
				attend_practitioner_id = checkForNull(encounterList.get(0).getAttendPractitionerId());
			}*/
			
			AllergyBC allergyBC = new AllergyBC();
			adv_event_srl_no_int = allergyBC.getMaxAllergyEventSerialNo(PatientId, adv_event_ind, adv_event_type, allergen);
			//negative number is returned in case of a exception in dao class
			if(adv_event_srl_no_int>=0){
				adv_event_srl_no = String.valueOf(adv_event_srl_no_int);
			}
			
			adv_dtl_srl_num_int = allergyBC.getMaxAllergyEventDtlSerialNo(PatientId, adv_event_ind, adv_event_type, allergen);
			//negative number is returned in case of a exception in dao class
			if(adv_dtl_srl_num_int>=0){
				adv_dtl_srl_num_int++;
				adv_dtl_srl_num = String.valueOf(adv_dtl_srl_num_int);
			}
			
			for(int i=0;i<react_srlnos.length;i++){
				String current_react_srlno = react_srlnos[i];
				reaction_date = checkForNull(req.getParameter("hdnReactionDateTime"+current_react_srlno));
				reaction_date = DateUtils.convertDate(reaction_date,"DMYHM",locale,"en");
				reaction_code = checkForNull(req.getParameter("reactionCode"+current_react_srlno));
				reaction_desc = checkForNull(req.getParameter("reactionDesc"+current_react_srlno));
				severity=checkForNull(req.getParameter("hdnScale"+current_react_srlno));
				if(severity.equals("")) severity="$";
				Site_Of_Reac_val = checkForNull(req.getParameter("txtSite"+current_react_srlno));
				if(Site_Of_Reac_val.equals("")) Site_Of_Reac_val="$";
				if(reaction_code.equals("Oth")){
					other_reaction_main = other_reaction_main+"@"+reaction_date +"`"+reaction_desc+"`"+severity+"`"+Site_Of_Reac_val;
					react_code_val = react_code_val + reaction_desc + "||";
					reac_desc_val = reac_desc_val + "`" + reaction_desc + "||";
				}
				else{
					react_values_main = react_values_main+"@"+reaction_date +"`"+reaction_code+"`"+severity+"`"+Site_Of_Reac_val;
					react_code_val = react_code_val + reaction_code + "`";
					reac_desc_val = reac_desc_val  + reaction_code + ";" + reaction_desc + ";";
				}
				
			}
			
	
			
			HashMap hashmap = new HashMap();
	        hashmap.put("p", p);
			hashmap.put("PatientId",PatientId);
	        hashmap.put("certainity", certainity);
	       // hashmap.put("severity_head", severity_head);
	        hashmap.put("adv_event_ind", adv_event_ind);
	        hashmap.put("adv_event_type", adv_event_type);
	        hashmap.put("allergen", allergen);
	        hashmap.put("onset_date", onset_date);
	        hashmap.put("reaction_date", reaction_date);
			hashmap.put("sou_of_info",sou_of_info);
			hashmap.put("remarks",remarks);
			hashmap.put("treat_advice",treat_advice);
			hashmap.put("allergy_test_res",allergy_test_res);
			hashmap.put("Site_Of_Reac",Site_Of_Reac);
			//hashmap.put("other_reaction",other_reaction);
			hashmap.put("severity",severity);
			hashmap.put("route_exp",route_exp);
			hashmap.put("cause_sub",cause_sub);
			hashmap.put("Encounter_Id",Encounter_Id);
			hashmap.put("react_values_main",react_values_main);
			hashmap.put("status1", status1);
	        hashmap.put("status_date",status_date);
			hashmap.put("react_code_val",react_code_val);
			hashmap.put("err_remarks",err_remarks);
			hashmap.put("facilityId",facilityId);
			hashmap.put("modifiedById",modifiedById);
			hashmap.put("modifiedAtWorkstation",modifiedAtWorkstation);
			hashmap.put("added_date", added_date);
			hashmap.put("adv_event_srl_no", adv_event_srl_no);
			hashmap.put("adv_dtl_srl_num",adv_dtl_srl_num);
			hashmap.put("diagnosis_code",diagnosis_code);
			hashmap.put("drug_code",drug_code);
			hashmap.put("other_reaction_main",other_reaction_main);
			hashmap.put("no_known_allergy",no_known_allergy);
			hashmap.put("chkreact1",chkreact1);
			hashmap.put("estimated_duration_yn",estimated_duration_yn);
			hashmap.put("reac_desc_val",reac_desc_val);
			hashmap.put("allergyAlertby", allergyAlertby);
			HashMap hashmap1;
			boolean inserted = false;
			try{
				
				boolean flag = false;
	            flag = true;
	            Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RecordAdverseEvent", eMR.RecordAdverseEvent.RecordAdverseEventHome.class, flag);
	            Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
	            Object aobj[] = new Object[2];
	            aobj[0] = p;
	            aobj[1] = hashmap;
	            Class aclass[] = new Class[2];
	            aclass[0] = p.getClass();
	            aclass[1] = hashmap.getClass();
	            hashmap1 = (HashMap)obj1.getClass().getMethod("modifyAdveEvent", aclass).invoke(obj1, aobj);
	            obj1.getClass().getMethod("remove", null).invoke(obj1, null);
				inserted = ( ((Boolean) hashmap1.get( "status" )).booleanValue() ) ;
				isAddReactionSuccessful = inserted;
		        hashmap.clear();
				hashmap1.clear(); 
			}
			catch(Exception e){
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


		}
		
		//only if reactions were added successfully mark as error is done
		if(isAddReactionSuccessful && err_reacts!=null && err_reacts.length>0){
			String err_reaction_code;
			String err_reaction_desc;
			String err_reaction_srlno;
			int markAsErrorResult = 0;
			
			AllergyBC bc = new AllergyBC();
			
			for(int i=0;i<err_reacts.length;i++){
				String current_react_srlno = err_reacts[i];
				err_reaction_code = checkForNull(req.getParameter("existingReactionCode"+current_react_srlno));
				err_reaction_desc = checkForNull(req.getParameter("existingReactionDesc"+current_react_srlno));
				err_reaction_srlno = checkForNull(req.getParameter("existingReactionSrlNo"+current_react_srlno));
				markAsErrorResult = markAsErrorResult + bc.markReactionAsError(modifiedById, modifiedAtWorkstation, PatientId, allergen, adv_event_ind, adv_event_type, err_reaction_code, err_reaction_srlno, err_reaction_desc);
			}
			transactResp.setTransactionResult(TransactionResponse.SUCCESS);//setting transaction response as success just in case there were no reactions added
        	errorInfo = new ErrorInfo();
        	errorInfo.setErrorType(Errors.COMMON_TRANSACTION_SUCCESS, locale);
        	transactResp.getErrorsList().add(errorInfo);
			System.out.println(markAsErrorResult + " reactions marked as error");
			req.setAttribute("TRANSACTION_RESPONSE", transactResp);
			
		}
		
		rd = getServletContext().getRequestDispatcher("/mobile/chartsummary/ChartWidgetsView");
		rd.forward(req, res);
	}
	
	private String checkForNull(String strParam)
    {
            String str ="";
            if(strParam!=null && strParam.length() > 0)
            	str = strParam;
            return str;
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
