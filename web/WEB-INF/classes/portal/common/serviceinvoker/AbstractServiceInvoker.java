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

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import portal.common.request.BaseRequest;
import portal.common.response.BaseResponse;
import portal.common.response.ErrorInfo;
import portal.tools.PortalConstants;

/**
 * @author GRamamoorthy
 * 
 */
public abstract class AbstractServiceInvoker implements ServiceInvoker {

	/**
	 * 
	 */
	public BaseResponse getDataThroughWebService(BaseRequest request) {
		// get the response object
		BaseResponse response = getResponseObject();
		// initialize the errorInfo object
		ErrorInfo errorInfo = new ErrorInfo();
		response.setErrorInfo(errorInfo);
		// first validate the request and if found invalid, return response
		boolean isValidRequest = validateRequest(request);
		if (!isValidRequest) {
			return response;
		}

		String webServiceURL = getWebServiceURL(request);
		String urlParams = getURLParameters(request);
		String completeWebServiceURL = webServiceURL + "?" + urlParams;

		URL url = null;
		try {
			url = new URL(completeWebServiceURL);
		} catch (MalformedURLException e) {
			System.out.println("could not establish the url connection "+ e.getMessage());
			errorInfo.setErrorCode(ErrorInfo.WEBSVC_CONN_ERROR_CODE);
			String errorMessage = ErrorInfo.WEBSVC_CONN_ERROR_MESSAGE;
			errorMessage = MessageFormat.format(errorMessage, new Object[] { e.getMessage() });
			errorInfo.setErrorMessage(errorMessage);
			return response;
		}
		
		// set up the urlconnection to hit the url
		URLConnection connection = null;
		try {
			connection = url.openConnection();
			connection.setDoOutput(true);
		} catch (IOException e) {
			System.out.println("could not establish the url connection " + e.getMessage());
			errorInfo.setErrorCode(ErrorInfo.WEBSVC_CONN_ERROR_CODE);
			String errorMessage = ErrorInfo.WEBSVC_CONN_ERROR_MESSAGE;
			errorMessage = MessageFormat.format(errorMessage, new Object[] { e.getMessage() });
			errorInfo.setErrorMessage(errorMessage);
			return response;
		}
		
		// indicate that the url is to be hit from client to server
		OutputStreamWriter out = null;
		try {
			out = new OutputStreamWriter(connection.getOutputStream());
		} catch (IOException e) {
			System.out.println("could not open the url " + e.getMessage());
			errorInfo.setErrorCode(ErrorInfo.WEBSVC_CONN_ERROR_CODE);
			String errorMessage = ErrorInfo.WEBSVC_CONN_ERROR_MESSAGE;
			errorMessage = MessageFormat.format(errorMessage, new Object[] { e.getMessage() });
			errorInfo.setErrorMessage(errorMessage);
			return response;
		}

		// now initialize the reading from the server
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		} catch (IOException e) {
			System.out.println("could not read from the url " + e.getMessage());
			errorInfo.setErrorCode(ErrorInfo.WEBSVC_CONN_ERROR_CODE);
			String errorMessage = ErrorInfo.WEBSVC_CONN_ERROR_MESSAGE;
			errorMessage = MessageFormat.format(errorMessage, new Object[] { e.getMessage() });
			errorInfo.setErrorMessage(errorMessage);
			return response;
		}

		// now comes the logic where the server's output is read
		String decodedString;
		StringBuffer sbuff = new StringBuffer();
		try {
			while ((decodedString = in.readLine()) != null) {
				System.out.println(decodedString);
				sbuff.append(decodedString);
			}
			in.close();
		} catch (IOException e) {
			System.out.println("could not read the url contents " + e.getMessage());
			errorInfo.setErrorCode(ErrorInfo.WEBSVC_CONN_ERROR_CODE);
			String errorMessage = ErrorInfo.WEBSVC_CONN_ERROR_MESSAGE;
			errorMessage = MessageFormat.format(errorMessage, new Object[] { e.getMessage() });
			errorInfo.setErrorMessage(errorMessage);
			return response;
		}
		
		// call the method which will read the xml file content
		// and set the data to response
		initializeDetails(sbuff, response);

		return response;
	}

	/**
	 * 
	 * @param xmlContent
	 * @return
	 */
	protected void initializeDetails(StringBuffer xmlContent, BaseResponse response) {
		byte[] byteArr = xmlContent.toString().getBytes();
		final ByteArrayInputStream is = new ByteArrayInputStream(byteArr);
		InputSource source = new InputSource(is);
		
		// initialize the document builder factory and document builder
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.out.println("Could not read from output xml file " + e.getMessage());
			return;
		}
		
		// initialize the document object - this will contain
		// the xml contents inside it as nodelist
		Document doc = null;
		try {
			doc = dBuilder.parse(source);
		} catch (Exception e) {
			System.out.println("Could not parse output xml file " + e.getMessage());
			return;
		}
		doc.getDocumentElement().normalize();
		String rootElement = doc.getDocumentElement().getNodeName();
		
		// check if xml content has errorinfo
		// then read it and set the response properly
		if (PortalConstants.ERRORINFO_KEY.equalsIgnoreCase(rootElement)) {
			ErrorInfo errorInfo = response.getErrorInfo();
			NodeList errorCodeNodes = doc.getElementsByTagName(PortalConstants.ERRORCODE_KEY);
			NodeList errorMessageNodes = doc.getElementsByTagName(PortalConstants.ERRORMESSAGE_KEY);
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
					}
				}
			}
		}else{
			readXMLContent(doc,response);
		}
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public abstract String getWebServiceURL(BaseRequest request);

	/**
	 * 
	 * @param request
	 * @return
	 */
	public abstract String getURLParameters(BaseRequest request);

	/**
	 * 
	 * @return
	 */
	public abstract BaseResponse getResponseObject();

	/**
	 * 
	 * @param request
	 * @return
	 */
	public abstract boolean validateRequest(BaseRequest request);
	
	/**
	 * 
	 * @param document
	 * @return
	 */
	public abstract void readXMLContent(Document document,BaseResponse response);

}
