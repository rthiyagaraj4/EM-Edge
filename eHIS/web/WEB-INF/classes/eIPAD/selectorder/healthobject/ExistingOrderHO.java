/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.selectorder.healthobject;

public class ExistingOrderHO implements java.io.Serializable{
	private String orderCategory;
	private String orderID;
	private String patientId;
	private String encounterId;
	private String orderDetail;
	private String orderCatalogCode;
	private String orderTypeCode;
	private String orderTypeDesc;
	private String startDate;
	private String endDate;
	private String catalogSynonym;
	private String orderStatusDesc;
	/**
	 * @return the orderCategory
	 */
	public String getOrderCategory() {
		return orderCategory;
	}
	/**
	 * @param orderCategory the orderCategory to set
	 */
	public void setOrderCategory(String orderCategory) {
		this.orderCategory = orderCategory;
	}
	/**
	 * @return the orderID
	 */
	public String getOrderID() {
		return orderID;
	}
	/**
	 * @param orderID the orderID to set
	 */
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	/**
	 * @return the patientId
	 */
	public String getPatientId() {
		return patientId;
	}
	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	/**
	 * @return the encounterId
	 */
	public String getEncounterId() {
		return encounterId;
	}
	/**
	 * @param encounterId the encounterId to set
	 */
	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
	}
	/**
	 * @return the orderDetail
	 */
	public String getOrderDetail() {
		return orderDetail;
	}
	/**
	 * @param orderDetail the orderDetail to set
	 */
	public void setOrderDetail(String orderDetail) {
		this.orderDetail = orderDetail;
	}
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
	 * @return the orderTypeDesc
	 */
	public String getOrderTypeDesc() {
		return orderTypeDesc;
	}
	/**
	 * @param orderTypeDesc the orderTypeDesc to set
	 */
	public void setOrderTypeDesc(String orderTypeDesc) {
		this.orderTypeDesc = orderTypeDesc;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
