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
package portalrefimpl.result.viewresult.response;

import java.util.Date;
import java.util.List;

import portalrefimpl.common.response.BaseResponse;

/**
 * This is the response class for test result service
 * This class will contain the data returned by this service
 * This class extends BaseResponse class
 * @author GRamamoorthy
 *
 */
public class TestResultResponse extends BaseResponse {

	/**
	 * Stores the list of test results for an order
	 */
	private List<TestResult> testResultList = null;
	
	private String orderNumber = null;
	
	private String resultType = null;
	
	private String order = null;
	
	private Date publishDate = null;
	

	/**
	 * @return the testResultList
	 */
	public List<TestResult> getTestResultList() {
		return testResultList;
	}

	/**
	 * @param testResultList the testResultList to set
	 */
	public void setTestResultList(List<TestResult> testResultList) {
		this.testResultList = testResultList;
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
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * @return the publishDate
	 */
	public Date getPublishDate() {
		return publishDate;
	}

	/**
	 * @param publishDate the publishDate to set
	 */
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	
}
