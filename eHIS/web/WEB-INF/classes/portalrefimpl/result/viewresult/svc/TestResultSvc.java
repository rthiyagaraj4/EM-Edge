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
package portalrefimpl.result.viewresult.svc;

import portalrefimpl.result.viewresult.request.TestResultRequest;
import portalrefimpl.result.viewresult.response.TestResultResponse;

/**
 * This is the service interface for Test Result functionality
 * This interface has the method to get the data for a test result
 * @author GRamamoorthy
 *
 */
public interface TestResultSvc {

	/**
	 * This method gets a particular test result data
	 * @param testResultRequest
	 * @return
	 */
	public TestResultResponse getTestResult(TestResultRequest testResultRequest);
	
}
