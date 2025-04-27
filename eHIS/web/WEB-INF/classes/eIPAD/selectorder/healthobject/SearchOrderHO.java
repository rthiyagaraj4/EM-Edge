/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.selectorder.healthobject;

public class SearchOrderHO implements java.io.Serializable {

	 private String orderCatalogCode;
	 private String catalogSynonym;
	 private String groupName;
	 private String privYN;
	 private String orderCategoryCode;
	 private String orderTypeCode;
	 private String promptAlertYN;
	 private String PromptMsg;
	/**
	 * @return the orderCatalogCode
	 */
	public String getOrderCatalogCode() {
		return orderCatalogCode;
	}
	/**
	 * @param orderCatalogCode the orderCatalogCode to set
	 */
	public void setOrderCatalogCode(String orderCatalogCode) {
		this.orderCatalogCode = orderCatalogCode;
	}
	/**
	 * @return the catalogSynonym
	 */
	public String getCatalogSynonym() {
		return catalogSynonym;
	}
	/**
	 * @param catalogSynonym the catalogSynonym to set
	 */
	public void setCatalogSynonym(String catalogSynonym) {
		this.catalogSynonym = catalogSynonym;
	}
	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}
	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/**
	 * @return the privYN
	 */
	public String getPrivYN() {
		return privYN;
	}
	/**
	 * @param privYN the privYN to set
	 */
	public void setPrivYN(String privYN) {
		this.privYN = privYN;
	}
	/**
	 * @return the orderCategoryCode
	 */
	public String getOrderCategoryCode() {
		return orderCategoryCode;
	}
	/**
	 * @param orderCategoryCode the orderCategoryCode to set
	 */
	public void setOrderCategoryCode(String orderCategoryCode) {
		this.orderCategoryCode = orderCategoryCode;
	}
	/**
	 * @return the orderTypeCode
	 */
	public String getOrderTypeCode() {
		return orderTypeCode;
	}
	/**
	 * @param orderTypeCode the orderTypeCode to set
	 */
	public void setOrderTypeCode(String orderTypeCode) {
		this.orderTypeCode = orderTypeCode;
	}
	/**
	 * @return the promptAlertYN
	 */
	public String getPromptAlertYN() {
		return promptAlertYN;
	}
	/**
	 * @param promptAlertYN the promptAlertYN to set
	 */
	public void setPromptAlertYN(String promptAlertYN) {
		this.promptAlertYN = promptAlertYN;
	}
	/**
	 * @return the promptMsg
	 */
	public String getPromptMsg() {
		return PromptMsg;
	}
	/**
	 * @param promptMsg the promptMsg to set
	 */
	public void setPromptMsg(String promptMsg) {
		PromptMsg = promptMsg;
	}
	 
}
