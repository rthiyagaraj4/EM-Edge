/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.result.viewtestresultdetails.svc;

import portal.common.svc.BaseService;
import portal.result.viewtestresultdetails.request.TestResultDetailsRequest;
import portal.result.viewtestresultdetails.response.TestResultDetailsResponse;


/**
 *  This clas is the service implementation for displaying Test Result details
 * 
 * @author skrishnared2
 *
 */
public interface TestResultDetailsSvc extends BaseService {
	
	/**
	 * Service method for retrieving test result details
	 * @param request
	 * @return
	 */
	public TestResultDetailsResponse getTestResultDetails(TestResultDetailsRequest request);

}
