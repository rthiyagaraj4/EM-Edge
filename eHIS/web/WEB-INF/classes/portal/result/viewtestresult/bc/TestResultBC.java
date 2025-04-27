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
package portal.result.viewtestresult.bc;

import org.apache.log4j.Logger;

import portal.result.viewtestresult.dac.TestResultsDAC;
import portal.result.viewtestresult.request.TestResultRequest;
import portal.result.viewtestresult.response.TestResultResponse;

/**
 *
 * This class is used for creating Business component for TestResults
 * 
 * @author skrishnared2
 */
public class TestResultBC {
	
	private static Logger logger = Logger
			.getLogger(TestResultBC.class.getName());
	// instance variables
	TestResultsDAC testDetailsInst;
	TestResultResponse response;
	
	/**
	 * This method will return the TestDetailResponse object after 
	 * Querying the information from DB. 
	 * 
	 * For TestResults, it is mandatory that user sends patientid, no of records to be returned 
	 * and portalUserName as a part of the request.
	 * 
	 * TestResultDate is also required as a part of Request parameters, if this information is not 
	 * passed then the results will be retrieved only for previous 1 month
	 * 
	 * @param request
	 * @return
	 */
	public TestResultResponse getTestDetails(TestResultRequest request){
		logger.debug("inside the method getTestDetails");
		// initialize the DAC class and get the data from it
		response = testDetailsInst.getTestDetails(request);
		
		return response;
	}

	/**
	 * @param testDetailsInst the testDetailsInst to set
	 */
	public void setTestDetailsInst(TestResultsDAC testDetailsInst) {
		logger.debug("setting the DAC object TestResultsDAC");
		this.testDetailsInst = testDetailsInst;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(TestResultResponse response) {
		logger.debug("setting the Response object TestResultResponse");
		this.response = response;
	}
	
}
