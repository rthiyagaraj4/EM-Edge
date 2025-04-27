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
package portal.common.serviceinvoker;

import portal.common.request.BaseRequest;
import portal.common.response.BaseResponse;

/**
 * @author GRamamoorthy
 *
 */
public interface ServiceInvoker {

	/**
	 * 
	 * @param request
	 * @return
	 */
	public BaseResponse getDataThroughWebService(BaseRequest request);
	
}
