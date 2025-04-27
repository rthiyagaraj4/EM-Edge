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
public class MOrderEntryCategTransItem {
	private String categoryCode;
	private String categoryDesc;
	private boolean transactionResult;
	private String transactionRespDesc;
	private ArrayList<MOrderEntryCatalogTransItem> catalogTransactionItems = new ArrayList<MOrderEntryCatalogTransItem>();
	/**
	 * @return the categoryCode
	 */
	public String getCategoryCode() {
		return categoryCode;
	}
	/**
	 * @param categoryCode the categoryCode to set
	 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	/**
	 * @return the categoryDesc
	 */
	public String getCategoryDesc() {
		return categoryDesc;
	}
	/**
	 * @param categoryDesc the categoryDesc to set
	 */
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	/**
	 * @return the transactionResult
	 */
	public boolean isTransactionResult() {
		return transactionResult;
	}
	/**
	 * @param transactionResult the transactionResult to set
	 */
	public void setTransactionResult(boolean transactionResult) {
		this.transactionResult = transactionResult;
	}

	/**
	 * @return the transactionRespDesc
	 */
	public String getTransactionRespDesc() {
		return transactionRespDesc;
	}
	/**
	 * @param transactionRespDesc the transactionRespDesc to set
	 */
	public void setTransactionRespDesc(String transactionRespDesc) {
		this.transactionRespDesc = transactionRespDesc;
	}
	/**
	 * @return the catalogTransactionItems
	 */
	public ArrayList<MOrderEntryCatalogTransItem> getCatalogTransactionItems() {
		return catalogTransactionItems;
	}
	/**
	 * @param catalogTransactionItems the catalogTransactionItems to set
	 */
	public void setCatalogTransactionItems(
			ArrayList<MOrderEntryCatalogTransItem> catalogTransactionItems) {
		this.catalogTransactionItems = catalogTransactionItems;
	}

	
	
}
