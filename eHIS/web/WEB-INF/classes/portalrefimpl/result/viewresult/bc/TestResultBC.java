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
package portalrefimpl.result.viewresult.bc;

import portalrefimpl.result.viewresult.dac.TestResultDAC;
import portalrefimpl.result.viewresult.request.TestResultRequest;
import portalrefimpl.result.viewresult.response.TestResultResponse;

/**
 * This is the BC class for the test result service
 * @author GRamamoorthy
 *
 */
public class TestResultBC {

	/**
	 * This method gets the test results
	 * @param testResultRequest
	 * @return
	 */
	public TestResultResponse getTestResult(TestResultRequest testResultRequest){
		// call the persistence layer class to get the data
		TestResultDAC dacInst = new TestResultDAC();
		return dacInst.getTestResult(testResultRequest); 
	}
	
}
