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
package portal.common.svc;

import portal.common.request.BaseRequest;
import portal.common.request.ValidationRequest;
import portal.common.response.ValidationResponse;

/**
 * This class defines an abstract method that have to be 
 * defined for all the services.
 * 
 * isValidRequestor() method has to be overridden when the request is
 * validated before the request parameters are passed to service method
 * 
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
}
