/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.resulttype.svc;

import portal.resulttype.request.ResultTypeRequest;
import portal.resulttype.response.ResultTypeResponse;

/**
 * This class defines all the abstract methods used in Result Type Service
 * @author vkodancha
 *
 */
public interface ResultTypeSvc {

	/**
	 * This method retrieves the list of Result Type for patient portal.
	 * This method takes as input Result Type Request object
	 * and returns Result Type Response object
	 * @param request
	 * @return
	 */
	public ResultTypeResponse getResultTypes(ResultTypeRequest request);
}
