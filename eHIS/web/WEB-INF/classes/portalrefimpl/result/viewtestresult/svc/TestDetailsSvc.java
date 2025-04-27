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
package portalrefimpl.result.viewtestresult.svc;

import portalrefimpl.common.svc.BaseService;
import portalrefimpl.result.viewtestresult.request.TestDetailsRequest;
import portalrefimpl.result.viewtestresult.response.TestDetailsResponse;





/**
 * @author GRamamoorthy
 *
 */
public interface TestDetailsSvc extends BaseService {

	/**
	 * This method retrieves recently completed test results
	 * based on the TestDetailsRequest object 
	 * @param request
	 * @return
	 */
	public TestDetailsResponse getTestDetails(TestDetailsRequest request);
	
}
