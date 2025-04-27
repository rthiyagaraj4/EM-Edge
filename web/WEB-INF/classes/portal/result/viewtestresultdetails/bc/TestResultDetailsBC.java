/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.result.viewtestresultdetails.bc;

import org.apache.log4j.Logger;

import portal.result.viewtestresultdetails.dac.TestResultDetailsDAC;
import portal.result.viewtestresultdetails.request.TestResultDetailsRequest;
import portal.result.viewtestresultdetails.response.TestResultDetailsResponse;

/**
 * This class is used for creating Business component for viewing 
 * Test Result Details
 *  
 * @author skrishnared2
 */
public class TestResultDetailsBC {

	// instance variables
	private static Logger logger = Logger.getLogger(TestResultDetailsBC.class.getName());
	TestResultDetailsDAC testResultDetailsInst;
	TestResultDetailsResponse response;
	
	/**
	 * This method will return the TestResultDetail Response object after 
	 * Querying the information from DB. 
	 * 
	 * For TestResultDetailss, it is mandatory that user sends patientid, no of records to be returned 
	 * and portalUserName as a part of the request.
	 * 
	 * TestResultDate is also required as a part of Request parameters, if this information is not 
	 * passed then the results will be retrieved only for previous 1 month
	 * 
	 * @param request
	 * @return
	 */
	public TestResultDetailsResponse getTestResultDetails(TestResultDetailsRequest request){
		// initialize the DAC class and get the data from it
		logger.debug("entering the method getTestResultDetails  with request :"+request.toString());
		response = testResultDetailsInst.getTestResultDetails(request);
		logger.debug("Leaving the method getTestResultDetails  with response :"+response.toString());
		
		return response;
	}

	/**
	 * @return the testResultDetailsInst
	 */
	public TestResultDetailsDAC getTestResultDetailsInst() {
		return testResultDetailsInst;
	}

	/**
	 * @param testResultDetailsInst the testResultDetailsInst to set
	 */
	public void setTestResultDetailsInst(TestResultDetailsDAC testResultDetailsInst) {
		this.testResultDetailsInst = testResultDetailsInst;
	}

	/**
	 * @return the response
	 */
	public TestResultDetailsResponse getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(TestResultDetailsResponse response) {
		this.response = response;
	}


}
