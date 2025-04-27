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
package portal.result.viewtestresult.svc;

import portal.common.svc.BaseService;
import portal.result.viewtestresult.request.TestResultRequest;
import portal.result.viewtestresult.response.TestResultResponse;



/**
 * This clas is the service implementation for displaying Testresults
 * 
 * @author GRamamoorthy
 *
 */
public interface TestResultSvc extends BaseService {

	/**
	 * Service method for retrieving 
	 * @param request
	 * @return
	 */
	public TestResultResponse getTestDetails(TestResultRequest request);
	
}
