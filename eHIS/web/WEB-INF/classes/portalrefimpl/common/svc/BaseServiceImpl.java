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

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import javax.annotation.Resource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.WebServiceContext;

import portalrefimpl.PortalConstants;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.request.ValidationRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.common.response.ValidationResponse;



/**
 * @author GRamamoorthy
 *
 */
public abstract class BaseServiceImpl implements BaseService {

	@Resource
    protected WebServiceContext wsContext;
	
	/**
	 * This method enables the Service to validate the requester of the service.
	 * The requester to be validated will be sent through
	 * the ValidationRequest object
	 * This method will return a ValidationResponse object which will contain
	 * the result of the validation  
	 * @param request
	 * @return
	 */
	public ValidationResponse isValidRequestor(ValidationRequest request) {
		ValidationResponse response = new ValidationResponse();
		ErrorInfo errorInfo = null;
		String errorMessage = null;
		/*int errorCode = -1;*/
		int errorCode = ErrorInfo.SUCCESS_CODE;
		
		
		boolean isValid = true;
		/*errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
		errorInfo.setErrorMessage(errorMessage);*/
		
		/*response.setErrorInfo(errorInfo);*/
		if(request == null){
			errorCode = ErrorInfo.NULL_REQUEST_ERRORCODE;
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.COMMON_MODULE_NAME,
					errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			
			isValid = false;
		}
		
		boolean isServiceCall = request.isServiceCall();
		if(isServiceCall){
			String portalUserName = request.getPortalUserName();
			if ((portalUserName == null)
					|| (portalUserName.trim().equals(""))
					|| (!(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE
							.equals(portalUserName)))) {
				errorInfo = new ErrorInfo();
				errorCode = ErrorInfo.PORTALUSER_NOTPRESENT_ERRORCODE;
				errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
								ErrorInfo.PORTALUSER_NOTPRESENT_ERRORCODE);
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				response.addError(errorInfo);
				
				if(isValid){
					isValid = false;
				}
			}	
		}
		
		response.setValid(isValid);
		// positive scenario - still need to set an error object
		// to response
		if(isValid){
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
		}
		
		return response;
	}

	/**
	 * 
	 * @return
	 */
	protected Map<String, String> getRequestParameterMap(String path){
		// the main logic in this method is to break the path based on
		// & character
		StringTokenizer parameterTokenizer = new StringTokenizer(path, "&");
		String token = null;
		int index = -1;
		
		Map<String, String> parameterMap = new HashMap<String, String>();
		String paramName = null;
		String paramValue = null;
		while(parameterTokenizer.hasMoreTokens()){
			token = parameterTokenizer.nextToken();
			index = token.indexOf("=");
			if(index >= 0){
				paramName = token.substring(0, index);
				paramValue = token.substring(index+1);
				parameterMap.put(paramName, paramValue);
			}
		}
		
		return parameterMap;
	}
	
	/**
	 * This method creates the XML tag for each key and value
	 * @param xmlFileContent
	 * @param key
	 * @param value
	 * @return
	 */
	protected StringBuffer createXMLFileContent(StringBuffer xmlFileContent,
			String key, String value) {
		xmlFileContent.append("<").append(key).append(">");
		if(value != null && value.trim().length() > 0) {
			xmlFileContent.append(value);
		}
		xmlFileContent.append("</").append(key).append(">");
		return xmlFileContent;
	}
	
	
	/**
	 * This method creates the error tag for response
	 * @param errormsg
	 * @param errorCode
	 * @param xmlFileContent
	 * @return
	 */
	protected void createErrorResponse(String errormsg, int errorCode,
			StringBuffer xmlFileContent) {
		xmlFileContent.append("<").append(PortalConstants.ERRORINFO_KEY)
				.append(">");
		xmlFileContent.append("<").append(PortalConstants.ERRORCODE_KEY)
				.append(">");
		xmlFileContent.append(errorCode);
		xmlFileContent.append("</").append(PortalConstants.ERRORCODE_KEY)
				.append(">");
		xmlFileContent.append("<").append(PortalConstants.ERRORMESSAGE_KEY)
				.append(">");
		xmlFileContent.append(errormsg != null ? errormsg : "");
		xmlFileContent.append("</").append(PortalConstants.ERRORMESSAGE_KEY)
				.append(">");
		xmlFileContent.append("</").append(PortalConstants.ERRORINFO_KEY)
				.append(">");
		
	}
	
	
	/**
	 * 
	 * @param tagKey
	 * @return
	 */
	protected String getXMLStartTag(String tagKey){
		StringBuffer xmlBuffer = new StringBuffer();
		xmlBuffer.append(PortalConstants.OPEN_XML_TAG);
		xmlBuffer.append(tagKey);
		xmlBuffer.append(PortalConstants.XML_CLOSE_TAG);
		
		return xmlBuffer.toString();
	}
	
	/**
	 * 
	 * @param tagKey
	 * @return
	 */
	protected String getXMLEndTag(String tagKey){
		StringBuffer xmlBuffer = new StringBuffer();
		xmlBuffer.append(PortalConstants.CLOSE_XML_TAG);
		xmlBuffer.append(tagKey);
		xmlBuffer.append(PortalConstants.XML_CLOSE_TAG);
		
		return xmlBuffer.toString();
	}
	
	/**
	 * 
	 * @param tagKey
	 * @param value
	 * @return
	 */
	protected String getCompleteXMLTag(String tagKey,String value){
		StringBuffer xmlBuffer = new StringBuffer();
		xmlBuffer.append(getXMLStartTag(tagKey));
		if(value == null){
			value = "";
		}
		xmlBuffer.append(value);
		xmlBuffer.append(getXMLEndTag(tagKey));
		
		return xmlBuffer.toString();
	}
	
	/**
	 * This method populates the base common properties from the 
	 * parameter map into the request object 
	 * @param request
	 * @param parameterMap
	 */
	protected void populateCommonPropertiesInRequest(BaseRequest request,
			Map<String, String> parameterMap) {
		// first the locale 
		String language = null;
		if(parameterMap.containsKey(CommonConstants.LANGUAGE_WS_PARAMETER_KEY)){
			language = parameterMap.get(CommonConstants.LANGUAGE_WS_PARAMETER_KEY);
		}else{
			language = Locale.getDefault().getLanguage();
		}
		request.setLocale(language);
		
		// portal user name
		String portalUserName = PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE;
		if(parameterMap.containsKey(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY)){
			portalUserName = parameterMap.get(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY)	;
		}
		request.setPortalUserName(portalUserName);
		
		// next patient id
		if(parameterMap.containsKey(PortalConstants.PATIENTID_REQUEST_PARAM_KEY)){
			String patientId = parameterMap
					.get(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
			request.setPatientId(patientId);
		}
	}
	
	/**
	 * This method helps in marshalling a web service response
	 * to xml file content
	 * @param response
	 * @param serviceIdentifier 
	 * @return
	 */
	protected String getResponseXMLString(BaseResponse response,
			String serviceIdentifier) {
		String xmlContent = null;
		if (response != null) {
			Writer writer = new StringWriter();
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(response
						.getClass());
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				jaxbMarshaller.marshal(response, writer);
				xmlContent = writer.toString();
			} catch (Exception e) {
				// e.printStackTrace();
				/* xmlContent = ""; */
				int errorCode = CommonConstants.WEBSERVICE_RESPONSE_STREAMSOURCE_EXCEPTION_ERRORCODE;
				String errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
								errorCode);
				/*
				 * errorMessage = MessageFormat.format(errorMessage, new
				 * Object[] { serviceIdentifier });
				 */
				xmlContent = populateXMLForErrorResponse(errorMessage,
						errorCode);
			}
		}

		return xmlContent;
	}

	/**
	 * This method populates an XML content when the response of 
	 * a service is null
	 * @param errorMessage
	 * @param errorCode
	 * @param xmlFileContent
	 */
	protected void populateXMLForErrorResponse(String errorMessage,
			int errorCode, StringBuffer xmlFileContent) {
		// next Errors 
		xmlFileContent.append(getXMLStartTag(PortalConstants.ERRORS_WRAPPER_KEY));
		// next Error
		xmlFileContent.append(getXMLStartTag(PortalConstants.ERROR_KEY));
		// error code and error message
		xmlFileContent.append(getCompleteXMLTag(PortalConstants.ERRORCODE_KEY,
				errorCode+""));
		xmlFileContent.append(getCompleteXMLTag(PortalConstants.ERRORMESSAGE_KEY,
				errorMessage));
		
		xmlFileContent.append(getXMLEndTag(PortalConstants.ERROR_KEY));
		// end the Errors tag
		xmlFileContent.append(getXMLEndTag(PortalConstants.ERRORS_WRAPPER_KEY));
	}
	
	/**
	 * 
	 * @param errorMessage
	 * @param errorCode
	 * @param xmlFileContent
	 */
	protected String populateXMLForErrorResponse(String errorMessage,
			int errorCode) {
		StringBuffer xmlBuffer = new StringBuffer();
		populateXMLForErrorResponse(errorMessage, errorCode, xmlBuffer);
		return xmlBuffer.toString();
	}

	/**
	 * This method gets the XML equivalent of the errors in the 
	 * response object
	 * @param response
	 * @return
	 */
	protected String getErrorsInResponseAsXML(BaseResponse response){
		StringBuffer xmlContent = new StringBuffer();
		// next Errors 
		xmlContent.append(getXMLStartTag(PortalConstants.ERRORS_WRAPPER_KEY));
		// response object will always have error information
		List<ErrorInfo> errorList = response.getErrors();
		for(ErrorInfo errorInfo : errorList){
			// every object would be enclosed within Error tag
			xmlContent.append(getXMLStartTag(PortalConstants.ERROR_KEY));
			// error code and error message
			xmlContent.append(getCompleteXMLTag(PortalConstants.ERRORCODE_KEY,
					"" + errorInfo.getErrorCode()));
			xmlContent.append(getCompleteXMLTag(PortalConstants.ERRORMESSAGE_KEY,
					errorInfo.getErrorMessage()));
			
			xmlContent.append(getXMLEndTag(PortalConstants.ERROR_KEY));
		}
		
		
		// end the Errors tag
		xmlContent.append(getXMLEndTag(PortalConstants.ERRORS_WRAPPER_KEY));
		
		return xmlContent.toString();
	}
	
	/**
	 * This method helps all the child service implementations
	 * to safely get the response XML content as a StreamSource instance 
	 * The logic inside this method is only a best effort try
	 * to get the stream source object
	 * @param response
	 * @return
	 */
	protected StreamSource getServiceResponseAsStreamSource(BaseResponse response,
			String serviceIdentifier) {
		StringBuffer xmlContent = new StringBuffer();
		xmlContent.append(getResponseXMLString(response, serviceIdentifier));
		
		StreamSource streamSource = getServiceResponseAsStreamSource(
				xmlContent.toString(), serviceIdentifier);
		/*
		try {
			streamSource = new StreamSource(new StringReader(
					xmlContent.toString()));
		} catch (Exception e) {
			// not much can be done
			xmlContent.delete(0, xmlContent.length());
			int errorCode = CommonConstants.WEBSERVICE_RESPONSE_STREAMSOURCE_EXCEPTION_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
							errorCode);
			errorMessage = MessageFormat.format(errorMessage,
					new Object[] { serviceIdentifier });
			populateXMLForErrorResponse(errorMessage, errorCode, xmlContent);
			
			// once again get the stream source
			try {
				streamSource = new StreamSource(new StringReader(
						xmlContent.toString()));
			} catch (Exception e1) {
				// nothing much can be done
			}
		}*/

		return streamSource;
	}
	
	/**
	 * This method helps all the child service implementations
	 * to safely get the response XML content as a StreamSource instance 
	 * The logic inside this method is only a best effort try
	 * to get the stream source object
	 * @param responseOutput
	 * @param serviceIdentifier
	 * @return
	 */
	protected StreamSource getServiceResponseAsStreamSource(
			String responseOutput, String serviceIdentifier) {
		StreamSource streamSource = null;

		try {
			streamSource = new StreamSource(new StringReader(responseOutput));
		} catch (Exception e) {
			// not much can be done
			int errorCode = CommonConstants.WEBSERVICE_RESPONSE_STREAMSOURCE_EXCEPTION_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
							errorCode);
			errorMessage = MessageFormat.format(errorMessage,
					new Object[] { serviceIdentifier });
			String updatedXMLContent = populateXMLForErrorResponse(
					errorMessage, errorCode);

			// once again get the stream source
			try {
				streamSource = new StreamSource(new StringReader(
						updatedXMLContent));
			} catch (Exception e1) {
				// nothing much can be done
			}
		}

		return streamSource;
	}
	
	
}
