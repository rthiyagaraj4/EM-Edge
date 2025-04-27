/**
 * 
 */
package eIPAD.chartsummary.pharmacy.healthobject;

import java.util.HashMap;

/**
 * @author SaraswathiR
 *
 */
public class PharmErrorItem {
	
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
	private String errorMessageId;
	private String errorMessage;
	private HashMap errorDetails;
	/**
	 * @return the errorDetails
	 */
	public HashMap getErrorDetails() {
		return errorDetails;
	}
	/**
	 * @param errorDetails the errorDetails to set
	 */
	public void setErrorDetails(HashMap errorDetails) {
		this.errorDetails = errorDetails;
	}
	

}
