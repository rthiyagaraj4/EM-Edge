/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.result.viewtestresultreport.bc;

import org.apache.log4j.Logger;

import portal.result.viewtestresultreport.dac.TestReportDAC;
import portal.result.viewtestresultreport.request.TestReportRequest;
import portal.result.viewtestresultreport.response.TestReportResponse;

/**
 * This class is used for creating Business component for viewing 
 * Test Report
 *  
 * @author vkodancha
 */
public class TestReportBC {
	
	private static Logger logger = Logger.getLogger(TestReportBC.class.getName());
	// instance variables
	TestReportDAC testReportDACInst;
	TestReportResponse response;
	/**
	 * This method will return the TestReport Response object after 
	 * Querying the information from DB. 
	 * 
	 * For TestReportDAC, it is mandatory that user sends patientid, orderId 
	 * and portalUserName as a part of the request.
	 * 
	 * @param request
	 * @return
	 */
	public TestReportResponse getTestReport(TestReportRequest request){
		logger.debug("Entering the method : getTestReport with request :"+request.toString());
		// call for DAC
		response= testReportDACInst.getTestReport(request);
		logger.debug("Leaving the method : getTestReport with response :"+response.toString());
		return response;
	}
	/**
	 * This method is used by spring to set the DAC bean on the 
	 * creation of the BC component
	 * @param testReportDACInst the testReportDACInst to set
	 */
	public void setTestReportDACInst(TestReportDAC testReportDACInst) {
		this.testReportDACInst = testReportDACInst;
	}

}
