<!DOCTYPE html>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Properties"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.healthobject.ClinicalNotesSectionItem"%>
<%@page import="java.util.List"%>
<%@page import="com.ehis.persist.PersistenceHelper"%>
<%@page import="eIPAD.chartsummary.common.response.ErrorInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesSectionListResponse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="webbeans.eCA.RecClinicalNotesSectionBean"%>
<%
webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)PersistenceHelper.getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
PatContext patContext= (PatContext)session.getAttribute("PatientContext");  
String note_type = checkForNull(request.getParameter("note_type"));
String operation_mode = checkForNull(request.getParameter("operation_mode"));
String locale = (String)session.getAttribute("LOCALE");
Boolean isNoteEmpty = true;
Gson gson = new Gson();
String jsonFieldResponse = "";
if(patContext!=null){
	String strKey	=	"";
	String patient_id = patContext.getPatientId();
	String encounter_id = patContext.getEncounterId();
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
					}else if(operation_mode.equals("UpdateRecord")){
						String edited_yn = checkForNull((String) sectionBean.getSectionEdited(sec_hdg_code, subsec_hdg_code),"");
						String notes_section_content = checkForNull((java.lang.String) sectionBean.getSectionContent ( sec_hdg_code,subsec_hdg_code ),"");	
						if(notes_section_content!=null && !notes_section_content.equals("")){
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

response.setContentType("application/json");
response.getWriter().write(jsonFieldResponse);
%>
<%!
public String checkForNull(String inputString)
{
	return (inputString==null)	?	""	:	inputString;
}
public String checkForNull(String inputString, String defaultValue)
{
	if(inputString==null)inputString ="";
	return ( (inputString.equals("") )	?	defaultValue	:	inputString).trim();
}
%> 
