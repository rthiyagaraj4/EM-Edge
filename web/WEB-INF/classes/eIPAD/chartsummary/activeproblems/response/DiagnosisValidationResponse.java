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
package eIPAD.chartsummary.activeproblems.response;

import eIPAD.chartsummary.common.response.GenericResponse;

/**
 * @author SaraswathiR 
 *
 */
public class DiagnosisValidationResponse extends GenericResponse {
	
	private int validationResult = 0; //1-Success 0-Fail -1 - unable to retrieve result due to failure

	/**
	 * @return the validationResult
	 */
	public int getValidationResult() {
		return validationResult;
	}

	/**
	 * @param validationResult the validationResult to set
	 */
	public void setValidationResult(int validationResult) {
		this.validationResult = validationResult;
	}


}
