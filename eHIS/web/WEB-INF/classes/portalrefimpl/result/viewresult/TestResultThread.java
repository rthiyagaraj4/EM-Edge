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

import portalrefimpl.PortalConstants;
import portalrefimpl.result.viewresult.request.TestResultRequest;
import portalrefimpl.result.viewresult.response.TestResultResponse;
import portalrefimpl.result.viewresult.svc.TestResultServiceInvoker;

/**
 * This class is responsible for getting the test results
 * for an order id
 * This class implements Runnable interface and gets
 * the test results in an unsynchronous manner
 * 
 * @author GRamamoorthy
 *
 */
public class TestResultThread implements Runnable {

	/**
	 * 
	 */
	private TestResultRetrieveRequest testResultRetrieveRequest = null;
	
	/**
	 * 
	 */
	private TestResultCache testResultCache = null;
	
	/**
	 * Constructor of the class
	 * @param testResultRetrieveRequest
	 */
	public TestResultThread(
			TestResultRetrieveRequest testResultRetrieveRequest,
			TestResultCache testResultCache) {
		this.testResultRetrieveRequest = testResultRetrieveRequest;
		this.testResultCache = testResultCache;
	}
	
	/**
	 * This is the main method in this class - this method helps
	 * in getting the test results based on the request and the cache
	 * object already set through the constructor
	 * This class gets the test results based on the patient id and the
	 * order id which are set in the request object
	 */
	public void run() {
		// safe check
		if(testResultRetrieveRequest == null || testResultCache == null){
			System.out.println("Cannot get test results as the request objects are null");
			return;
		}
		testResultCache.setStatus(TestResultExecutionStatus.IN_EXCECUTION);
		String patientId = testResultRetrieveRequest.getPatientId();
		String orderId = testResultRetrieveRequest.getOrderId();
		TestResultRequest testResultRequest = new TestResultRequest();
		testResultRequest.setPatientId(patientId);
		testResultRequest.setOrderNumber(orderId);
		testResultRequest.setServiceCall(false);
		testResultRequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
		
		TestResultResponse testResultResponse = null;
		TestResultServiceInvoker svcInvoker = new TestResultServiceInvoker();
		testResultResponse = svcInvoker.getDataThroughService(testResultRequest);
		/*TestResultSvcImpl svcImpl = new TestResultSvcImpl();
		TestResultResponse testResultResponse = svcImpl.getTestResult(testResultRequest);*/
		
		testResultCache.setOrderId(orderId);
		//testResultCache.setErrorInfo(testResultResponse.getErrorInfo());
		testResultCache.setTestResultList(testResultResponse.getTestResultList());
		testResultCache.setStatus(TestResultExecutionStatus.EXECUTED);
		testResultCache.setErrors(testResultResponse.getErrors());
		testResultCache.setSuccessful(testResultResponse.isSuccessful());
		testResultCache.setErrorMessage(testResultResponse.getErrorMessage());
		testResultCache.setOverallPublishDate(testResultResponse.getPublishDate());
		
	}

}
