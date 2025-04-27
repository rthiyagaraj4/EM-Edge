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
 *
 */
public class MOrderEntryTransactionResponse {
	
	private ArrayList<MOrderEntryCategTransItem> categoryTransactionItems = new ArrayList<MOrderEntryCategTransItem>();

	/**
	 * @return the categoryTransactionItems
	 */
	public ArrayList<MOrderEntryCategTransItem> getCategoryTransactionItems() {
		return categoryTransactionItems;
	}

	/**
	 * @param categoryTransactionItems the categoryTransactionItems to set
	 */
	public void setCategoryTransactionItems(
			ArrayList<MOrderEntryCategTransItem> categoryTransactionItems) {
		this.categoryTransactionItems = categoryTransactionItems;
	}



}
