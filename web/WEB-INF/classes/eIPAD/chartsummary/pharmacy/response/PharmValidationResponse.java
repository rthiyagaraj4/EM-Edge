/**
 * 
 */
package eIPAD.chartsummary.pharmacy.response;

import java.util.ArrayList;

import eIPAD.chartsummary.pharmacy.healthobject.PharmErrorItem;

/**
 * @author SaraswathiR
 *
 */
public class PharmValidationResponse {

	public static final int VALIDATION_SUCCESS = 0;
	public static final int VALIDATION_ERROR = 1;
	public static final int VALIDATION_WARNING = 2;
	public static final int VALIDATION_STATUS_FETCH_FAILURE = -1;
	
	private int validationResult;
	private ArrayList<PharmErrorItem> errorItems;
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
	/**
	 * @return the errorItems
	 */
	public ArrayList<PharmErrorItem> getErrorItems() {
		return errorItems;
	}
	/**
	 * @param errorItems the errorItems to set
	 */
	public void setErrorItems(ArrayList<PharmErrorItem> errorItems) {
		this.errorItems = errorItems;
	}
	
}
