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
 * @author SaraswathiR
 * Will be used by to create a JSON response for dropdown or sfs to contain the results
 *
 */
public class MOrderEntryFieldResponse {
	
	public static final int FIELD_DATAFETCH_SUCCESS = 0;
	public static final int FIELD_DATAFETCH_FAILURE = -1;
	
	private int responseStatus = FIELD_DATAFETCH_SUCCESS; // incase we are unable to fetch the data, we say -1 here
	private ArrayList<MOrderEntryFieldItem> fieldItems = new ArrayList<MOrderEntryFieldItem>();
	/**
	 * @return the responseStatus
	 */
	public int getResponseStatus() {
		return responseStatus;
	}
	/**
	 * @param responseStatus the responseStatus to set
	 */
	public void setResponseStatus(int responseStatus) {
		this.responseStatus = responseStatus;
	}
	/**
	 * @return the fieldItems
	 */
	public ArrayList<MOrderEntryFieldItem> getFieldItems() {
		return fieldItems;
	}
	/**
	 * @param fieldItems the fieldItems to set
	 */
	public void setFieldItems(ArrayList<MOrderEntryFieldItem> fieldItems) {
		this.fieldItems = fieldItems;
	}

}
