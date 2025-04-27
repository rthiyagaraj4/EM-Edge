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

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import portalrefimpl.PortalConstants;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.response.ErrorInfo;

/**
 * This class is the specific implementation of XMLResponseReader
 * interface for document style of reading XML response returned by
 * Web Services
 * @author gramamoorthy
 *
 */
public class DocumentResponseReader extends BaseXMLResponseReader implements
		XMLResponseReader {
	
	/**
	 * Constructor of the class
	 * @param serviceInvoker
	 */
	public DocumentResponseReader(ServiceInvoker serviceInvoker){
		super(serviceInvoker);
	}
	
	/**
	 * This method helps in reading the XML response returned by web service
	 * and populating the response with data
	 * In this method, document style reading is followed
	 */
	public BaseResponse readXMLResponse(StringBuffer xmlContent, BaseResponse response) {
		
		byte[] byteArr = xmlContent.toString().getBytes();
		final ByteArrayInputStream is = new ByteArrayInputStream(byteArr);
		InputSource source = new InputSource(is);
		// initialize the document builder factory and document builder
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		// initialize the response object and set the error info in it as well
		ErrorInfo errorInfo = null;
		/*errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);*/
		
		/*if(response != null){
			if (response.getErrorInfo() == null) {
				response.setErrorInfo(errorInfo);
			} else {
				errorInfo = response.getErrorInfo();
			}
			if(!response.hasErrors()){
				response.addError(errorInfo);
			}
		}*/
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.out.println("Could not read from output xml file "
					+ e.getMessage());
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(ErrorInfo.WEBSVC_READ_ERROR_CODE);
			
			response.addError(errorInfo);
			return response;
		}
		// initialize the document object - this will contain
		// the xml contents inside it as nodelist
		Document doc = null;
		try {
			doc = dBuilder.parse(source);
		} catch (Exception e) {
			System.out.println("Could not parse output xml file "
					+ e.getMessage());
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(ErrorInfo.WEBSVC_READ_ERROR_CODE);
			
			response.addError(errorInfo);
			return response;
		}
		doc.getDocumentElement().normalize();
		String rootElement = doc.getDocumentElement().getNodeName();
		// check if xml content has errorinfo
		// then read it and set the response properly
		/*if (PortalConstants.ERRORINFO_KEY
				.equalsIgnoreCase(rootElement)) {*/
		if (PortalConstants.ERRORS_WRAPPER_KEY
					.equalsIgnoreCase(rootElement)) {
			NodeList errorNodeList = doc.getElementsByTagName(PortalConstants.ERROR_KEY);
			int errorNodesLength = errorNodeList != null ?errorNodeList.getLength():0;
			Node errorNode = null;
			
			for(int count=0;count<errorNodesLength;count++){
				errorNode = errorNodeList.item(count);
				if(errorNode.getNodeType() == Node.ELEMENT_NODE){
					errorInfo = new ErrorInfo();
					
					Element errorElement = (Element) errorNode;
					
					NodeList errorCodeNodes = errorElement
							.getElementsByTagName(PortalConstants.ERRORCODE_KEY);
					
					if(errorCodeNodes != null){
						Element errorCodeElement = (Element)errorCodeNodes.item(0);
						NodeList errorCodeChildNodes = errorCodeElement.getChildNodes();
						if(errorCodeChildNodes != null){
							Node errorCodeChildNode = errorCodeChildNodes.item(0);
							if(errorCodeChildNode != null){
								String errorCodeString = errorCodeChildNode.getNodeValue();
								int errorCode = -1;
								try {
									errorCode = Integer.parseInt(errorCodeString);
								} catch (NumberFormatException e) {
									// cannot do much
								}
								
								errorInfo.setErrorCode(errorCode);
								//System.out.println("error code="+errorCode);
							}
						}
					}
					
					NodeList errorMessageNodes = errorElement
							.getElementsByTagName(PortalConstants.ERRORMESSAGE_KEY);
					
					if(errorMessageNodes != null){
						Element errorMessageElement = (Element)errorMessageNodes.item(0);
						NodeList errorMessageChildNodes = errorMessageElement.getChildNodes();
						if(errorMessageChildNodes != null){
							Node errorMessageChildNode = errorMessageChildNodes.item(0);
							if(errorMessageChildNode != null){
								String errorMessage = errorMessageChildNode.getNodeValue();
								//System.out.println("error message="+errorMessage);
								
								errorInfo.setErrorMessage(errorMessage);
							}
						}
					}
					
					response.addError(errorInfo);
				}
			}

			//errorInfo = response.getErrorInfo();
			/*NodeList errorCodeNodes = doc
					.getElementsByTagName(PortalConstants.ERRORCODE_KEY);
			NodeList errorMessageNodes = doc
					.getElementsByTagName(PortalConstants.ERRORMESSAGE_KEY);
			boolean errorFound = false;
			if(errorCodeNodes != null){
				Element errorCodeElement = (Element)errorCodeNodes.item(0);
				NodeList errorCodeChildNodes = errorCodeElement.getChildNodes();
				if(errorCodeChildNodes != null){
					Node errorCodeChildNode = errorCodeChildNodes.item(0);
					if(errorCodeChildNode != null){
						String errorCodeString = errorCodeChildNode.getNodeValue();
						int errorCode = -1;
						try {
							errorCode = Integer.parseInt(errorCodeString);
							errorFound = true;
						} catch (NumberFormatException e) {
							// cannot do much
						}
						errorInfo.setErrorCode(errorCode);
					}
				}
			}
			if(errorMessageNodes != null){
				Element errorMessageElement = (Element)errorMessageNodes.item(0);
				NodeList errorMessageChildNodes = errorMessageElement.getChildNodes();
				if(errorMessageChildNodes != null){
					Node errorMessageChildNode = errorMessageChildNodes.item(0);
					if(errorMessageChildNode != null){
						String errorMessage = errorMessageChildNode.getNodeValue();
						errorInfo.setErrorMessage(errorMessage);
						
						if(!errorFound){
							errorFound = true;
						}
					}
				}
			}
			
			if(errorFound){
				response.addError(errorInfo);
			}*/
			
		}else{
			// success mode
			//errorInfo = response.getErrorInfo();
			/*if(errorInfo != null){
				errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
			}*/
			
			/*errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
			response.addError(errorInfo);*/
			
			if(serviceInvoker instanceof AbstractServiceInvoker){
				((AbstractServiceInvoker)serviceInvoker).readXMLContent(doc,response);	
			}
			
			/*serviceInvoker.readXMLContent(doc,response);*/
		}
		
		return response;
	}

	
	
}
