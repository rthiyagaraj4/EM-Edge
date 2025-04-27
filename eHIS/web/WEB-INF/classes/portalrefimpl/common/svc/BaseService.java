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
package portalrefimpl.common.svc;

import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.request.ValidationRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.response.ValidationResponse;



/**
 * @author GRamamoorthy
 *
 */
public interface BaseService {

	/**
	 * This method enables the Service to be registered with an end point URL.
	 * Once registered, the Service can be accessed through a HTTP URL 
	 * 
	 * @param request
	 */
	public void registerService(BaseRequest request);
	
	/**
	 * This method enables the Service to validate the requester of the service.
	 * The requester to be validated will be sent through
	 * the ValidationRequest object
	 * This method will return a ValidationResponse object which will contain
	 * the result of the validation  
	 * @param request
	 * @return
	 */
	public ValidationResponse isValidRequestor(ValidationRequest request);
	
	/**
	 * This method validates the request - checks whether the request is valid
	 * syntactically and semantically
	 * individual service implementation class will need to implement this
	 * method
	 * @param request
	 * @return
	 */
	public BaseResponse isValidRequest(BaseRequest request);
	
}
