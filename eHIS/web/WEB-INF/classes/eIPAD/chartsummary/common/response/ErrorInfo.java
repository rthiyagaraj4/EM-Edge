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
package eIPAD.chartsummary.common.response;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author SaraswathiR
 *
 */

public class ErrorInfo {
	

	private Errors errorType = Errors.COMMON_SUCCESS;
	private String errorMessage = "SUCCESS";

	/**
	 * @return the errorType
	 */
	public Errors getErrorType() {
		return errorType;
	}
	/**
	 * @param errorType the errorType to set
	 */
	public void setErrorType(Errors errorType, String locale) {
		if(errorType != null){
			this.errorType = errorType;
			try{
				Locale errorLocale;
				if(locale!=null && !locale.equals(""))
					errorLocale = new Locale(locale);
				else
					errorLocale = Locale.getDefault();
				
				ResourceBundle errorBundle = ResourceBundle.getBundle(errorType.getBundleName(), errorLocale);
				if(errorBundle != null)
					this.errorMessage = errorBundle.getString(errorType.getBundleMessage());
				else
					this.errorMessage = errorType.getBundleMessage();
				
			}
			catch(Exception e){
				this.errorMessage = errorType.getBundleMessage();
			}
		}
		
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 * In case the developer wants to set an error message which is not available in the bundle, this method is used
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
