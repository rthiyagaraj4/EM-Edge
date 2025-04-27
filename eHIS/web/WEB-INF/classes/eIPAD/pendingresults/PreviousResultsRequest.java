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
package eIPAD.pendingresults;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import eIPAD.IPADConstants;

/**
 * @author GRamamoorthy
 *
 */
public class PreviousResultsRequest implements Serializable {

	/**
	 * Stores the servlet request
	 */
	private HttpServletRequest request = null;
	
	/**
	 * stores the session
	 */
	private HttpSession session = null;
	
	/**
	 * Stores the locale information
	 */
	private String locale = null;
	
	private String patientId = null;
	
	private String eventClass = null;
	
	private String eventCode = null;
	
	private String eventGroup = null;
	
	private String histRectType = null;
	
	/**
	 * This is a workaround to be used
	 * in places where from date and to
	 * date are not supposed to be used
	 */
	private boolean maskDates = false;
	
	private String fromDate = null;
	
	private String toDate = null;
	
	private String normalcyIndicator = null;
	
	
	/**
	 * default constructor of the class
	 */
	public PreviousResultsRequest() {
	}
	
	/**
	 * 
	 * @return
	 */
	public String getFlowSheetId(){
		String flowSheetId = "";
		if(request != null){
			flowSheetId = request.getParameter("cboFlowSheetComp");
			if(flowSheetId == null){
				flowSheetId = "";
			}	
		}
		return flowSheetId;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPatientId(){
		if (request != null
				&& (this.patientId == null || this.patientId.trim().equals(""))) {
			patientId = request.getParameter("hdnPatient_Id");
			if(patientId == null){
				patientId = "";
			}	
		}
		return patientId;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getHistoryRecordType(){
		if(request != null && (histRectType == null || histRectType.trim().equals(""))){
			histRectType = request.getParameter("hdnHistRectType");
			if(histRectType == null){
				histRectType = "";
			}	
		}
		return histRectType;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getEventClass(){
		if(request != null && (eventClass == null || eventClass.trim().equals(""))){
			eventClass = request.getParameter("hdnEventClass");
			if(eventClass == null){
				eventClass = "";
			}	
		}
		return eventClass;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getEventGroup(){
		if (request != null
				&& (eventGroup == null || eventGroup.trim().equals(""))) {
			eventGroup = request.getParameter("hdnEventGroup");
			if(eventGroup == null){
				eventGroup = "";
			}	
		}
		return eventGroup;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getEventCode(){
		if (request != null
				&& (eventCode == null || eventCode.trim().equals(""))) {
			eventCode = request.getParameter("hdnEventCode");
			if(eventCode == null){
				eventCode = "";
			}	
		}
		return eventCode;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getFromDate(){
		/*
		 if(request != null && !maskDates){
			String selectedPeriod = request.getParameter("hdnSelectedPeriod");
			if(selectedPeriod != null && !selectedPeriod.trim().equals("")){
				List<String> timePeriodList = ClinicalEventHistory.getSelectedTimePeriod(selectedPeriod, "");
				if(timePeriodList != null && timePeriodList.size() == 2){
					fromDate = timePeriodList.get(0);
				}
			}else{
				fromDate = request.getParameter("hdnFromPeriod");
				if(fromDate == null){
					fromDate = "";
				}		
			}
			
		}*/
		
		if(maskDates){
			fromDate = "";
		}
				
		return fromDate;		
	}

	/**
	 * 
	 * @return
	 */
	public String getToDate(){
		/*if(request != null && !maskDates){
			String selectedPeriod = request.getParameter("hdnSelectedPeriod");
			if(selectedPeriod != null && !selectedPeriod.trim().equals("")){
				List<String> timePeriodList = ClinicalEventHistory.getSelectedTimePeriod(selectedPeriod, "");
				if(timePeriodList != null && timePeriodList.size() == 2){
					toDate = timePeriodList.get(1);
				}
			}else{
				toDate = request.getParameter("hdnToPeriod");
				if(toDate == null){
					toDate = "";
				}	
			}
		}*/
		if(maskDates){
			toDate = "";
		}
		return toDate;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getFacilityId(){
		String facilityId = "";
		if(request != null){
			facilityId = request.getParameter("hdnFacilityId");
			if(facilityId == null){
				facilityId = "";
			}	
		}
		return facilityId;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getEncounterId(){
		String encounterId = "";
		if(request != null){
			encounterId = request.getParameter("encounter_id");
			if(encounterId == null){
				encounterId = "";
			}	
		}
		return encounterId;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getEncounterType(){
		String encounterType = "";
		String episodeType = getEpisodeType();
		if(IPADConstants.INPATIENT_EPISODE_KEY.equals(episodeType)){
			encounterType = IPADConstants.INPATIENT_KEYWORD;
		}else if(IPADConstants.OUTPATIENT_EPISODE_KEY.equals(episodeType)){
			encounterType = IPADConstants.OUTPATIENT_KEYWORD;
		}else if(IPADConstants.DAYCARE_EPISODE_KEY.equals(episodeType)){
			encounterType = IPADConstants.DAYCAREPATIENT_KEYWORD;
		}else if(IPADConstants.EMERGENCY_EPISODE_KEY.equals(episodeType)){
			encounterType = IPADConstants.EMERGENCYPATIENT_KEYWORD;
		}
		
		return encounterType;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getEpisodeType(){
		String episodeType = "";
		if(request != null){
			episodeType = request.getParameter("episode_type");
			if(episodeType == null){
				episodeType = "";
			}	
		}
		return episodeType;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSortOrder(){
		String sortOrder = "";
		if(request != null){
			sortOrder = request.getParameter("graphorder");
			if(sortOrder == null){
				sortOrder = "desc";
			}	
		}
		
		return sortOrder;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAbnormal(){
		String abnormalStr = "";
		if(request != null){
			abnormalStr = request.getParameter("abnormal");
			if(abnormalStr == null){
				abnormalStr = "N";
			}	
		}
		
		return abnormalStr;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getViewConf(){
		String viewConf = "";
		if(request != null){
			viewConf = request.getParameter("viewConfRes");
			if(viewConf == null){
				viewConf = "";
			}	
		}
		
		return viewConf;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getErrorEvent(){
		String errorEvent = "";
		if(request != null){
			errorEvent = request.getParameter("errorEvent");
			if(errorEvent == null){
				errorEvent = "";
			}	
		}
		return errorEvent;
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @param request the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * @return the session
	 */
	public HttpSession getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}

	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	/**
	 * @return the histRectType
	 */
	public String getHistRectType() {
		return histRectType;
	}

	/**
	 * @param histRectType the histRectType to set
	 */
	public void setHistRectType(String histRectType) {
		this.histRectType = histRectType;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	/**
	 * @param eventClass the eventClass to set
	 */
	public void setEventClass(String eventClass) {
		this.eventClass = eventClass;
	}

	/**
	 * @param eventCode the eventCode to set
	 */
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	/**
	 * @param eventGroup the eventGroup to set
	 */
	public void setEventGroup(String eventGroup) {
		this.eventGroup = eventGroup;
	}

	/**
	 * @return the maskDates
	 */
	public boolean isMaskDates() {
		return maskDates;
	}

	/**
	 * @param maskDates the maskDates to set
	 */
	public void setMaskDates(boolean maskDates) {
		this.maskDates = maskDates;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	/**
	 * @return the normalcyIndicator
	 */
	public String getNormalcyIndicator() {
		return normalcyIndicator;
	}

	/**
	 * @param normalcyIndicator the normalcyIndicator to set
	 */
	public void setNormalcyIndicator(String normalcyIndicator) {
		this.normalcyIndicator = normalcyIndicator;
	}
}
