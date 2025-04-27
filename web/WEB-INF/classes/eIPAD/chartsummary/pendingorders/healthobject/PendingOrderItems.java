/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.pendingorders.healthobject;

public class PendingOrderItems implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String catalogDescription;
	private String practitionerId;
	private String practitionerName;
	private String orderDateTime;
	private String formatExistYN;
	private String orderId;
	private String orderLineNum;
	private String orderStatusDesc;
	/**
	 * @return the catalogDescription 
	 */
	public String getCatalogDescription() {
		return catalogDescription;
	}
	/**
	 * @param catalogDescription the catalogDescription to set
	 */
	public void setCatalogDescription(String catalogDescription) {
		this.catalogDescription = catalogDescription;
	}
	/**
	 * @return the practitionerId
	 */
	public String getPractitionerId() {
		return practitionerId;
	}
	/**
	 * @param practitionerId the practitionerId to set
	 */
	public void setPractitionerId(String practitionerId) {
		this.practitionerId = practitionerId;
	}
	/**
	 * @return the orderDateTime
	 */
	public String getOrderDateTime() {
		return orderDateTime;
	}
	/**
	 * @param orderDateTime the orderDateTime to set
	 */
	public void setOrderDateTime(String orderDateTime) {
		this.orderDateTime = orderDateTime;
	}
	
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the orderLineNum
	 */
	public String getOrderLineNum() {
		return orderLineNum;
	}
	/**
	 * @param orderLineNum the orderLineNum to set
	 */
	public void setOrderLineNum(String orderLineNum) {
		this.orderLineNum = orderLineNum;
	}
	/**
	 * @return the formatExistYN
	 */
	public String getFormatExistYN() {
		return formatExistYN;
	}
	/**
	 * @param formatExistYN the formatExistYN to set
	 */
	public void setFormatExistYN(String formatExistYN) {
		this.formatExistYN = formatExistYN;
	}
	/**
	 * @return the practitionerName
	 */
	public String getPractitionerName() {
		return practitionerName;
	}
	/**
	 * @param practitionerName the practitionerName to set
	 */
	public void setPractitionerName(String practitionerName) {
		this.practitionerName = practitionerName;
	}
	/**
	 * @return the orderStatusDesc
	 */
	public String getOrderStatusDesc() {
		return orderStatusDesc;
	}
	/**
	 * @param orderStatusDesc the orderStatusDesc to set
	 */
	public void setOrderStatusDesc(String orderStatusDesc) {
		this.orderStatusDesc = orderStatusDesc;
	}

}
