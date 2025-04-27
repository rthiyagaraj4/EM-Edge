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
 * @author SaraswathiR
 *
 */
public class MOrderEntryCatalogTransItem {
	private String catalogCode;
	private String catalogDesc;
	private String errorMessage;
	/**
	 * @return the catalogCode
	 */
	public String getCatalogCode() {
		return catalogCode;
	}
	/**
	 * @param catalogCode the catalogCode to set
	 */
	public void setCatalogCode(String catalogCode) {
		this.catalogCode = catalogCode;
	}
	/**
	 * @return the catalogDesc
	 */
	public String getCatalogDesc() {
		return catalogDesc;
	}
	/**
	 * @param catalogDesc the catalogDesc to set
	 */
	public void setCatalogDesc(String catalogDesc) {
		this.catalogDesc = catalogDesc;
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
