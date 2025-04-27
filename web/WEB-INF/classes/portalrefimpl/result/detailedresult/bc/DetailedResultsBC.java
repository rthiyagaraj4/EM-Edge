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
package portalrefimpl.result.detailedresult.bc;

import portalrefimpl.result.detailedresult.dac.DetailedResultsDAC;
import portalrefimpl.result.detailedresult.request.DetailedResultsRequest;
import portalrefimpl.result.detailedresult.response.DetailedResultsResponse;

/**
 * @author GRamamoorthy
 *
 */
public class DetailedResultsBC {

	/**
	 * 
	 * @param request
	 * @return
	 */
	public DetailedResultsResponse getDetailedResults(DetailedResultsRequest request){
		DetailedResultsResponse resultsResponse = null;
		DetailedResultsDAC dacInst = new DetailedResultsDAC();
		resultsResponse = dacInst.getDetailedResults(request);
		return resultsResponse;
	}
	
}
