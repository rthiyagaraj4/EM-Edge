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

import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import portalrefimpl.common.response.BaseResponse;

/**
 * This class is the specific implementation of XMLResponseReader
 * interface for JAXB style of reading XML response returned by
 * Web Services
 * @author gramamoorthy
 *
 */
public class JaxbResponseReader extends BaseXMLResponseReader implements XMLResponseReader {

	/**
	 * constructor of the class
	 * @param serviceInvoker
	 */
	public JaxbResponseReader(ServiceInvoker serviceInvoker) {
		super(serviceInvoker);
	}

	/**
	 *  This method helps in reading the XML response returned by web service
	 * and populating the response with data
	 * In this method, JAXB reading API is followed
	 */
	public BaseResponse readXMLResponse(StringBuffer xmlContent, BaseResponse response) {
		Reader reader = null;
		reader = new StringReader(xmlContent.toString());
		//BaseResponse response = null;
		JAXBContext jaxbContext = null;
		Unmarshaller jaxbUnmarshaller = null;
		Object responseObj = null;
		try {
			jaxbContext = JAXBContext.newInstance(response.getClass());
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			responseObj = jaxbUnmarshaller.unmarshal(reader);
			response = (BaseResponse) responseObj;
		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * TODO
			 * need to set error code in the response object
			 */
		}
	return response;
	}
	


}
