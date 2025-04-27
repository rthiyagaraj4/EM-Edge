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
package eIPAD.chartsummary.orderentry.response;

import java.util.ArrayList;

/**
 * @author saraswathir
 *
 */
public class MOrderEntryValidationResponse {
	
	public static final int VALIDATION_SUCCESS = 0;
	public static final int VALIDATION_ERROR = 1;
	public static final int VALIDATION_STATUS_FETCH_FAILURE = -1;
	
	private int validationResult;
	private ArrayList<MOrderEntryErrorItem> errorItems;

	/**
	 * @return the errorItems
	 */
	public ArrayList<MOrderEntryErrorItem> getErrorItems() {
		return errorItems;
	}
	/**
	 * @param errorItems the errorItems to set
	 */
	public void setErrorItems(ArrayList<MOrderEntryErrorItem> errorItems) {
		this.errorItems = errorItems;
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
