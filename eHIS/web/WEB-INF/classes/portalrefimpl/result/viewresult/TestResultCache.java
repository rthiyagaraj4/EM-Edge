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
package portalrefimpl.result.viewresult;

import java.util.Date;
import java.util.List;

import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.result.viewresult.response.TestResult;

/**
 * @author GRamamoorthy
 *
 */
public class TestResultCache {
	
	/**
	 * Data members in the class
	 */
	private String orderId;
	
	private List<TestResult> testResultList = null;
	
	private ErrorInfo errorInfo = null;
	
	private List<ErrorInfo> errors = null;
	
	private TestResultExecutionStatus status = null;
	
	private boolean isSuccessful = false;
	
	private String errorMessage = null;
	
	private Date overallPublishDate = null;
	
	/**
	 * Default constructor of the class
	 */
	public TestResultCache(){
		// does nothing
	}
	
	
	/**
	 * @param orderId
	 * @param testResultList
	 */
	public TestResultCache(String orderId, List<TestResult> testResultList) {
		this.orderId = orderId;
		this.testResultList = testResultList;
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
	 * @return the errorInfo
	 */
	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}


	/**
	 * @param errorInfo the errorInfo to set
	 */
	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}


	/**
	 * @return the errors
	 */
	public List<ErrorInfo> getErrors() {
		return errors;
	}


	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<ErrorInfo> errors) {
		this.errors = errors;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isSuccessful(){
		return isSuccessful;
	}

	/**
	 * 
	 * @return
	 */
	public boolean hasExecuted(){
		return (TestResultExecutionStatus.EXECUTED == this.status);
	}
	

	/**
	 * @return the status
	 */
	public TestResultExecutionStatus getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(TestResultExecutionStatus status) {
		this.status = status;
	}


	/**
	 * @param isSuccessful the isSuccessful to set
	 */
	public void setSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
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


	/**
	 * @return the overallPublishDate
	 */
	public Date getOverallPublishDate() {
		return overallPublishDate;
	}


	/**
	 * @param overallPublishDate the overallPublishDate to set
	 */
	public void setOverallPublishDate(Date overallPublishDate) {
		this.overallPublishDate = overallPublishDate;
	}
	
	
}
