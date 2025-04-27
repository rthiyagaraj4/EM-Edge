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
package portalrefimpl.common.serviceinvoker;

import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.response.BaseResponse;

/**
 * This interface represents the client for the web services.
 * Since the web services are REST based services, there is a need
 * to implement the client completely in code.
 * 
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
	
	/**
	 * 
	 * @param request
	 */
	public void registerService(BaseRequest request);
		
}
