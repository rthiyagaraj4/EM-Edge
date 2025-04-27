/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.clinicalnotes.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ehis.persist.PersistenceHelper;
import com.google.gson.Gson;

import eDS.Common.JSONObject;
import eIPAD.chartsummary.activeproblems.bc.ProblemsDiagnosisBC;
import eIPAD.chartsummary.activeproblems.response.DiagnosisClassificationResponse;
import eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC;
import eIPAD.chartsummary.clinicalnotes.healthobject.ClinicalNotesFieldItem;
import eIPAD.chartsummary.clinicalnotes.healthobject.ClinicalNotesSectionItem;
import eIPAD.chartsummary.clinicalnotes.healthobject.InErrorDetails;
import eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesFieldResponse;
import eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesMapResponse;
import eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesResponse;
import eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesSectionListResponse;
import eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesTransactionResponse;
import eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesValidationResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.response.ErrorInfo;

/**
 * Servlet implementation class ClinicalNotesJSONServlet 
 */
public class ClinicalNotesJSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClinicalNotesJSONServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PatContext patientContext;
		Gson gson = new Gson();
		String jsonFieldResponse = "";
		HttpSession session = request.getSession(false);
		patientContext = (PatContext)session.getAttribute("PatientContext");
		response.setContentType("application/json");
		
		String getValueFrom =request.getParameter("field") == null? "":request.getParameter("field");
		String filterByVal = request.getParameter("filterBy") == null? "":request.getParameter("filterBy");
		String applTaskID = "CLINICAL_NOTES";
		String noteGroupID = request.getParameter("noteGroupID") == null? "":request.getParameter("noteGroupID");
		String selNoteType = request.getParameter("NoteType") == null? "":request.getParameter("NoteType");
		String specialityCode = request.getParameter("specialityCode") == null? "":request.getParameter("specialityCode");
		String noteGrpId = request.getParameter("NoteGrpId") == null? "":request.getParameter("NoteGrpId");
		String ser_spc_yn = request.getParameter("ser_spc_yn") == null? "":request.getParameter("ser_spc_yn");
	    String facilityId = request.getParameter("facilityId") == null? "":request.getParameter("facilityId");
		String accessionNumber = request.getParameter("accessionNumber") == null? "":request.getParameter("accessionNumber");
		String note_type = request.getParameter("note_type") == null? "":request.getParameter("note_type");
		String operation_mode = request.getParameter("operation_mode") == null? "":request.getParameter("operation_mode");
		
		
		String locale = patientContext.getLocale();
		/*String filterByVal = request.getParameter("filterBy");*/
		/*String noteGroupID ="";*/
		if(getValueFrom.equals("NT")){
			ClinicalNotesFieldResponse cnResponse ;
			ClinicalNotesBC cnBC = new ClinicalNotesBC();
			cnResponse = cnBC.getNoteTypeList(patientContext,filterByVal,applTaskID,noteGroupID,specialityCode);
			if(cnResponse != null ){
				jsonFieldResponse = gson.toJson(cnResponse);
				
			}
		}
		else if(getValueFrom.equals("NG")){
			ClinicalNotesFieldResponse cnResponse ;
			ClinicalNotesBC cnBC = new ClinicalNotesBC();
			cnResponse = cnBC.getNoteGroupList(patientContext,filterByVal,applTaskID,specialityCode);
			if(cnResponse != null ){
				jsonFieldResponse = gson.toJson(cnResponse);
				
			}	
		}
		else if(getValueFrom.equals("SP")){
			ClinicalNotesFieldResponse cnResponse ;
			ClinicalNotesBC cnBC = new ClinicalNotesBC();
			cnResponse = cnBC.getSpecialityList(patientContext);
			if(cnResponse != null ){
				jsonFieldResponse = gson.toJson(cnResponse);
			}
		}
		else if(getValueFrom.equals("MS")){
			ClinicalNotesFieldResponse cnResponse ;
			ClinicalNotesBC cnBC = new ClinicalNotesBC();
			cnResponse = cnBC.getMedAncServicesList(patientContext, ser_spc_yn, selNoteType);
			if(cnResponse != null ){
				jsonFieldResponse = gson.toJson(cnResponse);
			}
		}
		else if(getValueFrom.equals("SelNG")){
			ClinicalNotesFieldResponse cnResponse ;
			ClinicalNotesBC cnBC = new ClinicalNotesBC();
			cnResponse = cnBC.getSelNoteGroup(patientContext,selNoteType);
			if(cnResponse != null ){
				jsonFieldResponse = gson.toJson(cnResponse);
			}
		}
		else if(getValueFrom.equals("SelMS")){
			ClinicalNotesFieldResponse cnResponse ;
			ClinicalNotesBC cnBC = new ClinicalNotesBC();
			cnResponse = cnBC.getSelMedService(patientContext);
			if(cnResponse != null ){
				jsonFieldResponse = gson.toJson(cnResponse);
			}
		}
		else if(getValueFrom.equals("ChckMax")){
			ClinicalNotesValidationResponse cnResponse ;
			ClinicalNotesBC cnBC = new ClinicalNotesBC();
			cnResponse = cnBC.checkNoOfNotes(patientContext,selNoteType,noteGrpId);
			if(cnResponse != null ){
				jsonFieldResponse = gson.toJson(cnResponse);
			}
		}
		else if(getValueFrom.equals("DEFAULTS")){
			ClinicalNotesMapResponse cnResponse ;
			ClinicalNotesBC cnBC = new ClinicalNotesBC();
			cnResponse = cnBC.getCreateNotesDefaultFilterValues(patientContext, applTaskID);
			if(cnResponse != null ){
				jsonFieldResponse = gson.toJson(cnResponse);
			}
		}
		else if(getValueFrom.equals("FREQUENT_NOTES")){
			ClinicalNotesFieldResponse cnResponse ;
			ClinicalNotesBC cnBC = new ClinicalNotesBC();
			cnResponse = cnBC.getFrequentlyUsedNoteTypes(patientContext);
			if(cnResponse != null ){
				jsonFieldResponse = gson.toJson(cnResponse);
			}
		}
		else if(getValueFrom.equals("NOTETYPE_DETAILS")){
			ClinicalNotesMapResponse cnResponse ;
			ClinicalNotesBC cnBC = new ClinicalNotesBC();
			cnResponse = cnBC.getNoteTypeSectionDetails(patientContext.getResponsibilityID(),selNoteType,locale);
			if(cnResponse != null ){
				jsonFieldResponse = gson.toJson(cnResponse);
			}
		}else if(getValueFrom.equals("ALL_FILTER_NOTE_TYPES")){
			ClinicalNotesFieldResponse cnResponse ;
			ClinicalNotesBC cnBC = new ClinicalNotesBC();
			cnResponse = cnBC.getAllFilterNoteTypes(patientContext);
			if(cnResponse != null ){
				jsonFieldResponse = gson.toJson(cnResponse);
			}
		}else if(getValueFrom.equals("FORWARD_PRAC")){
			ClinicalNotesFieldResponse cnResponse ;
			ClinicalNotesBC cnBC = new ClinicalNotesBC();
			cnResponse = cnBC.getPractitionerList(patientContext,note_type);
			
			if(cnResponse != null ){
				jsonFieldResponse = gson.toJson(cnResponse);
			}
		}else if(getValueFrom.equals("FORWARD_SPEC")){
			ClinicalNotesFieldResponse cnResponse ;
			ClinicalNotesBC cnBC = new ClinicalNotesBC();
			cnResponse = cnBC.getForwardNotesSpecialityList(patientContext);
			if(cnResponse != null ){
				jsonFieldResponse = gson.toJson(cnResponse);
			}
		}else if(getValueFrom.equals("REMARK")){
			ClinicalNotesFieldResponse cnResponse ;
			ClinicalNotesBC cnBC = new ClinicalNotesBC();
			
			

			ArrayList<JSONObject> resp=new ArrayList<JSONObject>();
			try {
				resp = cnBC.getMarkAsError(accessionNumber, facilityId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(resp != null ){
				jsonFieldResponse = gson.toJson(resp);
			}
		}else if(getValueFrom.equals("INERROR")){
			ClinicalNotesFieldResponse cnResponse ;
			ClinicalNotesBC cnBC = new ClinicalNotesBC();			
		
			

			ClinicalNotesFieldItem resp=new ClinicalNotesFieldItem();
			try {
				resp = cnBC.getINErrorResult(accessionNumber, locale);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(resp != null ){
				jsonFieldResponse = gson.toJson(resp);
			}
		}
		else if(getValueFrom.equals("ISNOTEEMPTY")){
			try{
				webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)PersistenceHelper.getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
				Boolean isNoteEmpty = true;
				if(patientContext!=null){
					String strKey	=	"";
					String patient_id = patientContext.getPatientId();
					String encounter_id = patientContext.getEncounterId();
					strKey = patient_id + "~"+ encounter_id;
					strKey = strKey.trim();
					Properties patSections = sectionBean.getPatientSection(strKey);
					if(!operation_mode.equals("ModifySection")){
						ClinicalNotesBC bc = new ClinicalNotesBC();
						ClinicalNotesSectionListResponse sectResp =  bc.getSectionListForNoteType(note_type, locale);
						if(sectResp!=null){
							boolean isSuccessResponse = sectResp.isSuccessResponse();
							boolean isEmptyResponse = sectResp.isEmptyDataResponse();
							ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();
							List<ClinicalNotesSectionItem> sectList = sectResp.getSectionList();
							errorList = sectResp.getErrorsList();
							if(sectList!=null  && !sectList.isEmpty())
								isEmptyResponse = false;
							if(isSuccessResponse && !isEmptyResponse){
								for(int i=0;i<sectList.size();i++){
									ClinicalNotesSectionItem currentSect = sectList.get(i);
									String sec_hdg_code = currentSect.getSectionCode();
									String subsec_hdg_code = currentSect.getChildSectionCode();
									if(operation_mode.equals("ModifyAddendum")){
										String edited_yn = checkForNull((String) sectionBean.getSectionEdited(sec_hdg_code, subsec_hdg_code),"");
										String ammend_text = (String) sectionBean.getAddendumText( sec_hdg_code, subsec_hdg_code);
										if(edited_yn.equals("Y") && ammend_text!=null && !ammend_text.equals("")){
											isNoteEmpty = false;
										}
									}else{
										String edited_yn = checkForNull((String) sectionBean.getSectionEdited(sec_hdg_code, subsec_hdg_code),"");
										String notes_section_content = checkForNull((java.lang.String) sectionBean.getSectionContent ( sec_hdg_code,subsec_hdg_code ),"");	
										if(edited_yn.equals("Y") && notes_section_content!=null && !notes_section_content.equals("")){
											isNoteEmpty = false;
										}
									}
								}
								
							}
							if(operation_mode.equals("ModifyAddendum")){
								String commonAddendumTxt =  sectionBean.getAddendumText("*AmmendNotes*","*AmmendNotes*");
								if(!commonAddendumTxt.equals("")){
									isNoteEmpty = false;
								}
							}
						}
					}else{ //in case of modify section, we are not considering to check for empty
						isNoteEmpty = false;
					}
					
					
				}
				if(isNoteEmpty){
					jsonFieldResponse = gson.toJson("true");
				}else{
					jsonFieldResponse = gson.toJson("false");
				}
				
			}catch(Exception e){
				
			}
			
		}else if(getValueFrom.equals("PRESEL_VALIDATION")){
			ClinicalNotesTransactionResponse cnResponse;
			ClinicalNotesBC cnBC = new ClinicalNotesBC();
			cnResponse = cnBC.validateNotePreSelection(patientContext, note_type);
			if(cnResponse != null ){
				jsonFieldResponse = gson.toJson(cnResponse);
			}
		}
		response.setContentType("application/json");
		response.getWriter().write(jsonFieldResponse);

	}
	public String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	public String checkForNull(String inputString, String defaultValue)
	{
		if(inputString==null)inputString ="";
		return ( (inputString.equals("") )	?	defaultValue	:	inputString).trim();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
