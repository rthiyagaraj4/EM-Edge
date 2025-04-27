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
package portalrefimpl.result.detailedresult.request;

import java.util.Date;

import portalrefimpl.common.request.BaseRequest;

/**
 * This is the request class for getting the detailed results
 * in the results main screen
 * This class extends the BaseRequest class
 * @author GRamamoorthy
 *
 */
public class DetailedResultsRequest extends BaseRequest {

	private String location = null;
	
	private String orderNumber = null;
	
	private String orderCategory = null;
	
	private Date fromDate = null;
	
	private Date toDate = null;
	
	private String fromDateString = null;
	
	private String toDateString = null;
	
	private String initialResetValue = null;

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
	 * @return the orderNumber
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

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
	 * @return the fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * @return the fromDateString
	 */
	public String getFromDateString() {
		return fromDateString;
	}

	/**
	 * @param fromDateString the fromDateString to set
	 */
	public void setFromDateString(String fromDateString) {
		this.fromDateString = fromDateString;
	}

	/**
	 * @return the toDateString
	 */
	public String getToDateString() {
		return toDateString;
	}

	/**
	 * @param toDateString the toDateString to set
	 */
	public void setToDateString(String toDateString) {
		this.toDateString = toDateString;
	}

	/**
	 * @return the initialResetValue
	 */
	public String getInitialResetValue() {
		return initialResetValue;
	}

	/**
	 * @param initialResetValue the initialResetValue to set
	 */
	public void setInitialResetValue(String initialResetValue) {
		this.initialResetValue = initialResetValue;
	}
	
	
}
