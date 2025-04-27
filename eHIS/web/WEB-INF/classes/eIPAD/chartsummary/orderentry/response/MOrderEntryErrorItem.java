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

/**
 * @author saraswathir
 *
 */
public class MOrderEntryErrorItem {

	private String errorMessageId;
	private String errorMessage;
	/**
	 * @return the errorMessageId
	 */
	public String getErrorMessageId() {
		return errorMessageId;
	}
	/**
	 * @param errorMessageId the errorMessageId to set
	 */
	public void setErrorMessageId(String errorMessageId) {
		this.errorMessageId = errorMessageId;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
