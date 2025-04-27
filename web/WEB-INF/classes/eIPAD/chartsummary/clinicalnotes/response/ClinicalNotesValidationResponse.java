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
package eIPAD.chartsummary.clinicalnotes.response;

import java.util.ArrayList;
import java.util.List;

import eIPAD.chartsummary.clinicalnotes.healthobject.ClinicalNotesErrorItem;
import eIPAD.chartsummary.common.response.GenericResponse;

/**
 * @author vchoughule
 *
 */
public class ClinicalNotesValidationResponse{
	private List<ClinicalNotesErrorItem> errorList = new ArrayList<ClinicalNotesErrorItem>();
	
	public static final int VALIDATION_SUCCESS = 0;
	public static final int VALIDATION_ERROR = 1;
	public static final int VALIDATION_STATUS_FETCH_FAILURE = -1;
	
	private int validationResult;

	/**
	 * @return the errorList
	 */
	public List<ClinicalNotesErrorItem> getErrorList() {
		return errorList;
	}

	/**
	 * @param errorList the errorList to set
	 */
	public void setErrorList(List<ClinicalNotesErrorItem> errorList) {
		this.errorList = errorList;
	}

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
