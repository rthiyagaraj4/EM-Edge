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
package eIPAD.chartsummary.encounterlist.request;

import eIPAD.chartsummary.common.request.GenericRequest;


/**
 * @author SaraswathiR
 *
 */
public class EncounterListRequest extends GenericRequest {
	
	String filterPatientClass;
	String filterEncounterId;
	String filterFacilityId;
	/**
	 * @return the filterPatientClass
	 */
	public String getFilterPatientClass() {
		return filterPatientClass;
	}
	/**
	 * @param filterPatientClass the filterPatientClass to set
	 */
	public void setFilterPatientClass(String filterPatientClass) {
		this.filterPatientClass = filterPatientClass;
	}
	/**
	 * @return the filterEncounterId
	 */
	public String getFilterEncounterId() {
		return filterEncounterId;
	}
	/**
	 * @param filterEncounterId the filterEncounterId to set
	 */
	public void setFilterEncounterId(String filterEncounterId) {
		this.filterEncounterId = filterEncounterId;
	}
	/**
	 * @return the filterFacilityId
	 */
	public String getFilterFacilityId() {
		return filterFacilityId;
	}
	/**
	 * @param filterFacilityId the filterFacilityId to set
	 */
	public void setFilterFacilityId(String filterFacilityId) {
		this.filterFacilityId = filterFacilityId;
	}
	

}
