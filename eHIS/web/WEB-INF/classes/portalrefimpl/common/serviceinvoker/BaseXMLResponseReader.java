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

import portalrefimpl.common.response.BaseResponse;

/**
 * This class is the base implementation of the XMLResponseReader interface
 * This class takes in ServiceInvoker instance
 * The different implementations of the XMLResponseReader - JAXB
 * and Document should extend this class
 * @author gramamoorthy
 *
 */
public abstract class BaseXMLResponseReader implements XMLResponseReader {

	/**
	 * 
	 */
	protected ServiceInvoker serviceInvoker = null;
	
	/**
	 * 
	 * @param serviceInvoker
	 */
	public BaseXMLResponseReader(ServiceInvoker serviceInvoker){
		this.serviceInvoker = serviceInvoker;
	}
	
	/**
	 * 
	 */
	public abstract BaseResponse readXMLResponse(StringBuffer xmlContent, BaseResponse response);
}
