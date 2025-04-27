/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.homepage.svc;

import java.io.StringReader;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.BindingType;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Provider;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;

import org.apache.log4j.Logger;

import portal.common.request.BaseRequest;
import portal.common.request.PatientRequest;
import portal.common.request.ValidationRequest;
import portal.common.response.ErrorInfo;
import portal.common.response.ValidationResponse;
import portal.common.svc.BaseServiceImpl;
import portal.homepage.bc.PatientDetailsBC;
import portal.homepage.response.PatientDetailsResponse;
import portal.tools.ErrorMessageUtil;
import portal.tools.PatientDetailsConstants;
import portal.tools.PortalConstants;
import portal.tools.PortalHelper;

/**
 * @author Vkodancha
 * This class can be made into a RESTful web service
 * by implementing Provider interface given by JAX-WS
 * This class is used to get the patient details
 * 
 */
@WebServiceProvider()
@BindingType(value = HTTPBinding.HTTP_BINDING)
public class PatientDetailsSvcImpl extends BaseServiceImpl implements
		PatientDetailsSvc, Provider<Source> {
	
	private static Logger logger = Logger.getLogger(PatientDetailsSvcImpl.class
			.getName());
	@Resource
	protected WebServiceContext wsContext;

	@Override
	public Source invoke(Source request) {
		logger.info("Invoking the service with request :" + request);
		StreamSource reply = null;
		PatientDetailsResponse patientResponse = new PatientDetailsResponse();
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String) mc.get(MessageContext.QUERY_STRING);
			logger.debug("Path is  :" + path);
			/**
			 * 
			 * get the parameters from path parameters are expected to be known
			 */
			BaseRequest patientRequest = formRequestFromPath(path);
			logger.debug("Request formed after formRequestFromPath :"
					+ patientRequest.toString());
			patientResponse = (PatientDetailsResponse) isValidRequestor(patientRequest);
			logger.debug("Is respoinse Valid :" + patientResponse.isValid());	
			if(patientResponse.isValid()){
				patientResponse = getPatientDetails(patientRequest);
			}
			logger.debug("Response is :" + patientResponse.toString());
			String xmlFileContent = getXMLFile(patientResponse);
			logger.debug("XML response is :" + xmlFileContent);
			reply = new StreamSource(new StringReader(xmlFileContent));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reply;
	}
	/**
	 * This method converts the Response into XML String
	 * it is used by web service to respond the request by sending source
	 * @param patientResponse
	 * @return
	 */
	private String getXMLFile(PatientDetailsResponse patientResponse) {
		// just a safe check - response can never be null but still handle it
		if (patientResponse == null) {
			logger.info("Empty response - so no file output");
			return "";
		}
		StringBuffer xmlFileContent = new StringBuffer();
		xmlFileContent
				.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");

		ErrorInfo errorInfo = patientResponse.getErrorInfo();
		if (errorInfo != null) {
			int errorCode = errorInfo.getErrorCode();
			String errorMessage = null;
			// in case of error, form the error information
			// and put it to the string buffer
			if (ErrorInfo.SUCCESS_CODE != errorCode) {
				errorMessage = errorInfo.getErrorMessage();
				xmlFileContent = createErrorResponse(errorMessage, errorCode,
						xmlFileContent);
			} else {
				// this is the place where the XML file content
				// for the data part is formed
				xmlFileContent.append("<")
						.append(PatientDetailsConstants.PATIENTDETAILS_KEY)
						.append(">");
				xmlFileContent = createXMLFileContent(xmlFileContent,
						PatientDetailsConstants.PATIENT_NAME,
						patientResponse.getPatientName());
				xmlFileContent = createXMLFileContent(xmlFileContent,
						PatientDetailsConstants.NICRID,
						patientResponse.getNationalIdNo());
				xmlFileContent = createXMLFileContent(xmlFileContent,
						PatientDetailsConstants.SEX, patientResponse.getSex());
				xmlFileContent = createXMLFileContent(xmlFileContent,
						PatientDetailsConstants.AGE,
						String.valueOf(patientResponse.getAge()));
				// now close the test details tag
				xmlFileContent.append("</")
						.append(PatientDetailsConstants.PATIENTDETAILS_KEY)
						.append(">");
			}
		}

		return xmlFileContent.toString();
	}
	/**
	 * This method is used by Web service to create the request from 
	 * the invoking request URL parameters
	 * @param path
	 * @return BaseRequest
	 */
	private BaseRequest formRequestFromPath(String path) {
		logger.info("Entered the method formRequestFromPath");
		BaseRequest request = new BaseRequest();
		PatientRequest patientInfo = new PatientRequest();
		request.setPatientInfo(patientInfo);
		Map<String, String> parameterMap = getParametersFromRequest(path);
		logger.debug("parameterMap :" + parameterMap.toString());
		// now iterate through the hashmap and find the parameters
		if(parameterMap.isEmpty()){
			return request;
		}
		
		/* call to update portal user name to rquest */
		setPortalUserNameToRequest(request,parameterMap);
		
		/* sets the URL parameters to request */
		setParamsToRequest(request, parameterMap);
		logger.info("leaving the method formRequestFromPath");
		return request;
	}
	
	/**
	 * This method sets the URL parameters to the request
	 * @param request
	 * @param parameterMap
	 */
	private void setParamsToRequest(BaseRequest request,
			Map<String, String> parameterMap) {
		logger.info("Entering the method setParamsToRequest");
		if (parameterMap.containsKey("patientId")) {
			request.setPatientId(parameterMap.get("patientId"));
		}
		logger.info("Leaving the method setParamsToRequest");
		
	}
	/**
	 * Validation of the input parameters
	 * @param request
	 * @return
	 */
	@Override	
	public ValidationResponse isValidRequestor(ValidationRequest request){
		logger.info("Entering the method isValidRequestor :"
				+ request.toString());
		PatientDetailsResponse patientResponse = new PatientDetailsResponse();
		BaseRequest prequest = (BaseRequest)request;
		patientResponse.setValid(true);
		
		if(!super.isValidRequestor(prequest).isValid()){
			ErrorInfo errorInfo = ErrorMessageUtil.getErrorMessage(
					PatientDetailsConstants.MODULE_NAME,
					ErrorInfo.PATIENT_INVALID_LOGIN_CODE);
			patientResponse.setErrorInfo(errorInfo);
			patientResponse.setValid(false);
		} 
		else if(isEmptyOrNull(prequest.getPatientId())) {
			ErrorInfo errorInfo = ErrorMessageUtil.getErrorMessage(
					PatientDetailsConstants.MODULE_NAME,
					ErrorInfo.PATIENT_INSUFFICIENT_REQUEST_PARAMETERS_CODE);
			patientResponse.setErrorInfo(errorInfo);
			patientResponse.setValid(false);
		}
		logger.info("Leaving the method isValidRequestor :");
		return patientResponse;
	}
	/**
	 * 
	 */
	@Override
	public void registerService(BaseRequest request) {
		logger.info("URL is registered");
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String webServiceUrl = PortalHelper
				.getWebServiceURL(PortalConstants.PATIENT_WS_URL_KEY);
		e.publish(webServiceUrl);
		logger.info("URL is published");
	}
	/**
	 * This method calls the Business component with valid base request
	 * and returns the patientDetails response
	 */
	@Override
	public PatientDetailsResponse getPatientDetails(BaseRequest request) {
		logger.info("Entering the method getPatientDetails");
		PatientDetailsResponse response = new PatientDetailsResponse();
		PatientDetailsBC inst = (PatientDetailsBC) context
				.getBean("PatientDetailsBC");
		response = inst.getPatientDetails(request);
		logger.debug("Error Info is:" + response.getErrorInfo().toString());
		logger.info("Leaving the method getPatientDetails");
		return response;
	}
}
