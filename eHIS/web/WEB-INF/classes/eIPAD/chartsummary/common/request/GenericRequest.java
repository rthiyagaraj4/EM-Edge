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
package eIPAD.chartsummary.common.request;

import eIPAD.chartsummary.common.healthobject.PatContext;

/**
 * @author SaraswathiR
 *
 */
public abstract class GenericRequest {

	private PatContext patientContext;

	/**
	 * @return the patientContext
	 */
	public PatContext getPatientContext() {
		return patientContext;
	}

	/**
	 * @param patientContext the patientContext to set
	 */
	public void setPatientContext(PatContext patientContext) {
		this.patientContext = patientContext;
	}
	



}
