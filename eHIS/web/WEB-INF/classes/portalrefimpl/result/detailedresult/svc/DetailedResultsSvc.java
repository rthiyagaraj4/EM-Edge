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
package portalrefimpl.result.detailedresult.svc;

import portalrefimpl.result.detailedresult.request.DetailedResultsRequest;
import portalrefimpl.result.detailedresult.response.DetailedResultsResponse;

/**
 * This is the service interface for detailed test results
 * which are shown in the test results main screen in portal application
 * @author GRamamoorthy
 *
 */
public interface DetailedResultsSvc {

	/**
	 * This method gets the test results given a request object
	 * Only completed and in progress test results are retrieved
	 * @param request
	 * @return
	 */
	public DetailedResultsResponse getDetailedResults(DetailedResultsRequest request);
	
}
