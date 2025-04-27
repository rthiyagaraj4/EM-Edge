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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.common.svc.BaseService;



/**
 * This abstract class is the client for the web services
 * This class provides methods to read the XML content returned by the 
 * web services and form the appropriate response objects
 * For each web service, a specific extension of this class should
 * be written - this specific implementation will implement only
 * the XML reading mechanism to populate data into the response object
 * @author GRamamoorthy
 * 
 */
public abstract class AbstractServiceInvoker implements ServiceInvoker {

	/**
	 * Stores the xml reader identifier - by default it is document
	 * 
	 */
	protected XMLReaderIdentifier xmlReaderIdentifier = XMLReaderIdentifier.DOCUMENT;
	
	
	/**
	 * This is the main method in this class
	 * This method accesses a particular web service through HTTP URL
	 * and processes the response
	 */
	public BaseResponse getDataThroughWebService(BaseRequest request) {
		// get the response object
		BaseResponse response = getResponseObject();
		// initialize the errorInfo object
		ErrorInfo errorInfo = null;
		/*response.setErrorInfo(errorInfo);*/
		
		
		// first validate the request and if found invalid, return response
		/*boolean isValidRequest = validateRequest(request);
		if (!isValidRequest) {
			return response;
		}*/

		String webServiceURL = getWebServiceURL(request);
		String urlParams = getURLParameters(request);
		String completeWebServiceURL = webServiceURL + "?" + urlParams;

		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		
		URL url = null;
		try {
			url = new URL(completeWebServiceURL);
		} catch (MalformedURLException e) {
			System.out.println("could not establish the url connection "
					+ e.getMessage());
			errorInfo = new ErrorInfo();
			errorCode = CommonConstants.WEBSERVICE_INVOKE_ERRORCODE;
			errorInfo.setErrorCode(errorCode);
			/*errorMessage = ErrorInfo.WEBSVC_CONN_ERROR_MESSAGE;*/
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.COMMON_MODULE_NAME, errorCode);
			/*errorMessage = MessageFormat.format(errorMessage,
					new Object[] { e.getMessage() });*/
			errorInfo.setErrorMessage(errorMessage);
			
			response.addError(errorInfo);
			return response;
		}
		// set up the urlconnection to hit the url
		URLConnection connection = null;
		try {
			connection = url.openConnection();
			connection.setDoOutput(true);
		} catch (IOException e) {
			/*System.out.println("could not establish the url connection "
					+ e.getMessage());*/
			errorInfo = new ErrorInfo();
			errorCode = CommonConstants.WEBSERVICE_INVOKE_ERRORCODE;
			errorInfo.setErrorCode(errorCode);
			/*errorMessage = ErrorInfo.WEBSVC_CONN_ERROR_MESSAGE;*/
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.COMMON_MODULE_NAME, errorCode);
			/*errorMessage = MessageFormat.format(errorMessage,
					new Object[] { e.getMessage() });*/
			errorInfo.setErrorMessage(errorMessage);
			
			response.addError(errorInfo);
			return response;
		}
		// indicate that the url is to be hit from client to server
		OutputStreamWriter out = null;
		try {
			out = new OutputStreamWriter(connection.getOutputStream());
		} catch (IOException e) {
			//System.out.println("could not open the url " + e.getMessage());
			errorInfo = new ErrorInfo();
			errorCode = CommonConstants.WEBSERVICE_INVOKE_ERRORCODE;
			errorInfo.setErrorCode(errorCode);
			/*errorMessage = ErrorInfo.WEBSVC_CONN_ERROR_MESSAGE;*/
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.COMMON_MODULE_NAME, errorCode);
			/*errorMessage = MessageFormat.format(errorMessage,
					new Object[] { e.getMessage() });*/
			errorInfo.setErrorMessage(errorMessage);
			
			response.addError(errorInfo);
			return response;
		}

		// now initialize the reading from the server
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
		} catch (IOException e) {
			//e.printStackTrace();
			//System.out.println("could not read from the url " + e.getMessage());
			errorInfo = new ErrorInfo();
			errorCode = CommonConstants.WEBSERVICE_INVOKE_ERRORCODE;
			errorInfo.setErrorCode(errorCode);
			/*errorMessage = ErrorInfo.WEBSVC_CONN_ERROR_MESSAGE;*/
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.COMMON_MODULE_NAME, errorCode);
			/*errorMessage = MessageFormat.format(errorMessage,
					new Object[] { e.getMessage() });*/
			errorInfo.setErrorMessage(errorMessage);
			
			response.addError(errorInfo);
			return response;
		}

		// now comes the logic where the server's output is read
		String decodedString;
		StringBuffer sbuff = new StringBuffer();
		try {
			while ((decodedString = in.readLine()) != null) {
				//System.out.println(decodedString);
				sbuff.append(decodedString);
			}
			in.close();
		} catch (IOException e) {
			/*System.out.println("could not read the url contents "
					+ e.getMessage());*/
			errorInfo = new ErrorInfo();
			errorCode = CommonConstants.WEBSERVICE_INVOKE_ERRORCODE;
			errorInfo.setErrorCode(errorCode);
			/*errorMessage = ErrorInfo.WEBSVC_CONN_ERROR_MESSAGE;*/
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.COMMON_MODULE_NAME, errorCode);
			/*errorMessage = MessageFormat.format(errorMessage,
					new Object[] { e.getMessage() });*/
			errorInfo.setErrorMessage(errorMessage);
			
			response.addError(errorInfo);
			return response;
		}
		
		// call the method which will read the xml file content
		// and set the data to response
		// code modified to synch with the new signature
		// of the initialize details method
		response = initializeDetails(sbuff, response);

		return response;
	}

	/**
	 * This method reads the XML content and populates the 
	 * response object with data
	 * This method code is modified to instantiate an instance
	 * of the XMLResponseReader - currently two impl are available
	 * Document reader implementation and JAXB implementation
	 * @param xmlContent
	 * @return
	 */
	protected BaseResponse initializeDetails(StringBuffer xmlContent, BaseResponse response) {
		XMLResponseReader xmlResponseReader = null;
		if(XMLReaderIdentifier.DOCUMENT == getXmlReaderIdentifier()){
			// indicates Document style of reading
			xmlResponseReader = new DocumentResponseReader(this);
		}else if(XMLReaderIdentifier.JAXB == getXmlReaderIdentifier()){
			// indicates JAXB style of reading
			xmlResponseReader = new JaxbResponseReader(this);
		}
		response = xmlResponseReader.readXMLResponse(xmlContent, response);
		return response;
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
	/*public abstract boolean validateRequest(BaseRequest request);*/
	
	/**
	 * 
	 * @param document
	 * @return
	 */
	public abstract void readXMLContent(Document document,BaseResponse response);

	/**
	 * 
	 * @param nodeElement
	 * @param elementKey
	 * @return
	 */
	protected String getNodeValue(Element nodeElement,String elementKey){
		NodeList nodeList = nodeElement
				.getElementsByTagName(elementKey);
		String nodeValue = "";
		StringBuffer nodeValueBuffer = new StringBuffer();
		if(nodeList != null){
			Element element = (Element) nodeList
					.item(0);
			
			if(element != null){
				NodeList childNodeList = element
						.getChildNodes();
				// code modified to iterate through all the child
				// nodes instead of only the first node
				int childNodeLength = childNodeList != null?childNodeList.getLength():0;
				Node childNode = null;
				for(int count=0;count<childNodeLength;count++){
					childNode = ((Node) childNodeList.item(count));
					nodeValue = childNode != null ? childNode
							.getNodeValue() : null;
					if (nodeValue == null) {
						nodeValue = "";
					}		
					nodeValueBuffer.append(nodeValue);
				}
			}
		}
		
		return nodeValueBuffer.toString();
	}
	
	/**
	 * This method gets the complete parameter string
	 * @param paramKey
	 * @param paramValue
	 * @return
	 */
	protected String getCompleteParamString(String paramKey,String paramValue){
		StringBuffer parameterBuffer = new StringBuffer();
		parameterBuffer.append(paramKey).append("=");
		if(paramValue == null){
			paramValue = "";
		}
		parameterBuffer.append(paramValue);
		
		return parameterBuffer.toString();
	}

	/**
	 * @return the xmlReaderIdentifier
	 */
	public XMLReaderIdentifier getXmlReaderIdentifier() {
		return xmlReaderIdentifier;
	}

	/**
	 * @param xmlReaderIdentifier the xmlReaderIdentifier to set
	 */
	public void setXmlReaderIdentifier(XMLReaderIdentifier xmlReaderIdentifier) {
		this.xmlReaderIdentifier = xmlReaderIdentifier;
	}

	/**
	 * 
	 */
	public void registerService(BaseRequest request) {
		BaseService serviceImpl = getServiceImpl();
		if(serviceImpl != null){
			serviceImpl.registerService(request);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	protected abstract BaseService getServiceImpl(); 
	
	
}
