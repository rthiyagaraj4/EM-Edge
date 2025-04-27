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
package portal.common.request;

/**
 * This class defines all the required information that is
 * madatory for all the Requests. All Request classes will extend 
 * this class
 * 
 * @author GRamamoorthy
 *
 */
public class BaseRequest extends ValidationRequest {

	/**
	 * 
	 */
	protected PatientRequest patientInfo = null;
	
	private String language = "en";

	/**
	 * @return the patientInfo
	 */
	public PatientRequest getPatientInfo() {
		return patientInfo;
	}

	/**
	 * @param patientInfo the patientInfo to set
	 */
	public void setPatientInfo(PatientRequest patientInfo) {
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
			patientInfo = new PatientRequest();
		}
		patientInfo.setPatientId(patientId);
	}
	
	/**
	 * 
	 * @param encounterId
	 */
	public void setEncounterId(String encounterId){
		if(patientInfo == null){
			patientInfo = new PatientRequest();
		}
		patientInfo.setEncounterId(encounterId);
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
}
