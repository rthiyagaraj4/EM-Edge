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
package eIP.advbedmgmt.transaction.patientfinancial.response;

import eIP.advbedmgmt.common.response.BaseResponse;

/**
 * this is the response class containing the meta data for getting
 * patient financial information
 * @author GRamamoorthy
 *
 */
public class FinancialInfoResponse extends BaseResponse {

	/**
	 * data members in this class
	 */
	private String encounterVisitNum = null;
	
	private String encounterId = null;
	
	private String patientId = null;

	/**
	 * @return the encounterVisitNum
	 */
	public String getEncounterVisitNum() {
		return encounterVisitNum;
	}

	/**
	 * @param encounterVisitNum the encounterVisitNum to set
	 */
	public void setEncounterVisitNum(String encounterVisitNum) {
		this.encounterVisitNum = encounterVisitNum;
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
	
	
}
