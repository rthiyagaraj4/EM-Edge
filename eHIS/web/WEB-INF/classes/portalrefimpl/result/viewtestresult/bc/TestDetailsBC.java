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
package portalrefimpl.result.viewtestresult.bc;

import portalrefimpl.result.viewtestresult.dac.TestDetailsDAC;
import portalrefimpl.result.viewtestresult.request.TestDetailsRequest;
import portalrefimpl.result.viewtestresult.response.TestDetailsResponse;





/**
 * @author GRamamoorthy
 *
 */
public class TestDetailsBC {

	/**
	 * 
	 * @param request
	 * @return
	 */
	public TestDetailsResponse getTestDetails(TestDetailsRequest request){
		TestDetailsResponse response = new TestDetailsResponse();
		// first step
		// validate the request - this is just a sample so no validation
				
		// second step
		// initialize the DAC class and get the data from it
		TestDetailsDAC dacInst = new TestDetailsDAC();
		response = dacInst.getTestDetails(request);
		
		return response;
	}
	
}
