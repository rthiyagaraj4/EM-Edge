/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.common.model;

/**
 * This class defines all the attributes required for 
 * patient information 
 * 
 * @author skrishnared2
 */
public class Patient extends Person {
	
	/**
	 * Instance variables
	 */
	private String patientId;
	private String encounterId;
	private String nricId;
	private String lastVisitedSiteDate;
	
	/**
	 * @return the patientId
	 */
	public String getPatientId() {
		return patientId;
	}
	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	/**
	 * @return the encounterId
	 */
	public String getEncounterId() {
		return encounterId;
	}
	/**
	 * @param encounterId the encounterId to set
	 */
	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
	}
	/**
	 * @return the nricId
	 */
	public String getNricId() {
		return nricId;
	}
	/**
	 * @param nricId the nricId to set
	 */
	public void setNricId(String nricId) {
		this.nricId = nricId;
	}
	/**
	 * @return the lastVisitedSiteDate
	 */
	public String getLastVisitedSiteDate() {
		return lastVisitedSiteDate;
	}
	/**
	 * @param lastVisitedSiteDate the lastVisitedSiteDate to set
	 */
	public void setLastVisitedSiteDate(String lastVisitedSiteDate) {
		this.lastVisitedSiteDate = lastVisitedSiteDate;
	}

}
