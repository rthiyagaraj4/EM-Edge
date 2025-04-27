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
package portal.result.viewtestresult.request;

import portal.common.request.BaseRequest;


/**
 * This class provides the list of parameters that 
 * have to be passed as a part of URL parameters while
 * invoking the TestResult service
 * 
 * @author Sandhya
 */
public class TestDetailsRequest extends BaseRequest {

	// instance variables
	private int resultSetSize;
	
	// these variables are used when filtering part 
	// is implemented
	private String orderId;
	private String location;
	private String resultType;
	private String orderFromDate;
	private String orderToDate;
	
	/**
	 * @return the resultSetSize
	 */
	public int getResultSetSize() {
		return resultSetSize;
	}
	
	/**
	 * @param resultSetSize the resultSetSize to set
	 */
	public void setResultSetSize(int resultSetSize) {
		this.resultSetSize = resultSetSize;
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

	/**
	 * @return the orderDate
	 */
	public String getOrderFromDate() {
		return orderFromDate;
	}

	/**
	 * @param orderDate the orderDate to set
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
}
