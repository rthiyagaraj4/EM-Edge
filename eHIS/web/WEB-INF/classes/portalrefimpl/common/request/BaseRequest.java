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
package portalrefimpl.common.request;

import java.util.Locale;

/**
 * @author GRamamoorthy
 *
 */
public class BaseRequest {

	/**
	 * 
	 */
	protected PatientInfo patientInfo = null;
	
	/**
	 * Stores the common portal user name
	 */
	protected String portalUserName = null;
	
	/**
	 * Stores the locale
	 */
	protected String locale = null;
	
	/**
	 * Stores a flag whether a service is called in the service
	 * mode or in a java pojo mode
	 */
	protected boolean isServiceCall = false;
	
	/**
	 * default constructor of the class
	 * sets the service call as true
	 */
	public BaseRequest(){
		this.isServiceCall = true;
	}
	

	/**
	 * @return the patientInfo
	 */
	public PatientInfo getPatientInfo() {
		return patientInfo;
	}

	/**
	 * @param patientInfo the patientInfo to set
	 */
	public void setPatientInfo(PatientInfo patientInfo) {
		this.patientInfo = patientInfo;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPatientId(){
		String patientId = "";
		if(patientInfo != null){
			patientId = patientInfo.getPatientId();
		}
		return patientId;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getEncounterId(){
		String encounterId = "";
		if(patientInfo != null){
			encounterId = patientInfo.getEncounterId();
		}
		return encounterId;
	}
	
	/**
	 * 
	 * @param patientId
	 */
	public void setPatientId(String patientId){
		if(patientInfo == null){
			patientInfo = new PatientInfo();
		}
		patientInfo.setPatientId(patientId);
	}
	
	/**
	 * 
	 * @param encounterId
	 */
	public void setEncounterId(String encounterId){
		if(patientInfo == null){
			patientInfo = new PatientInfo();
		}
		patientInfo.setEncounterId(encounterId);
	}

	/**
	 * @return the portalUserName
	 */
	public String getPortalUserName() {
		return portalUserName;
	}

	/**
	 * @param portalUserName the portalUserName to set
	 */
	public void setPortalUserName(String portalUserName) {
		this.portalUserName = portalUserName;
	}

	/**
	 * @return the locale
	 */
	public String getLocale() {
		// code modified to initialize locale with language
		// value from Locale object if not set by caller
		if(locale == null || locale.trim().equals("")){
			locale = Locale.getDefault().getLanguage();
		}
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	/**
	 * @return the isServiceCall
	 */
	public boolean isServiceCall() {
		return isServiceCall;
	}

	/**
	 * @param isServiceCall the isServiceCall to set
	 */
	public void setServiceCall(boolean isServiceCall) {
		this.isServiceCall = isServiceCall;
	}
	
	
}
