/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.result.viewtestresultdetails.request;

import portal.common.request.BaseRequest;

public class TestResultDetailsRequest extends BaseRequest {

	// instance variables
	private String orderId;
	private String location;
	private String resultType;
	private String orderFromDate;
	private String orderToDate;

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
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the orderFromDate
	 */
	public String getOrderFromDate() {
		return orderFromDate;
	}
	/**
	 * @param orderFromDate the orderFromDate to set
	 */
	public void setOrderFromDate(String orderFromDate) {
		this.orderFromDate = orderFromDate;
	}
	/**
	 * @return the orderToDate
	 */
	public String getOrderToDate() {
		return orderToDate;
	}
	/**
	 * @param orderToDate the orderToDate to set
	 */
	public void setOrderToDate(String orderToDate) {
		this.orderToDate = orderToDate;
	}
	/**
	 * @return the resultType
	 */
	public String getResultType() {
		return resultType;
	}
	/**
	 * @param resultType the resultType to set
	 */
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}
	
	
}
