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
 * This interface allows reading the XML content returned
 * by the web services
 * This interface should be implemented by individual XML
 * reading algorithms
 * @author gramamoorthy
 *
 */
public interface XMLResponseReader {

	/**
	 * This method helps in reading the XML content returned by web service
	 * This method takes as input the XML content stored in a string buffer
	 * and the response object in which data has to be populated
	 * @param xmlContent
	 * @param response
	 */
	public BaseResponse readXMLResponse(StringBuffer xmlContent, BaseResponse response);
	
}
