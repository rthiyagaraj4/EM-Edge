/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portalrefimpl.schedule.createappointment.svc.impl;

import java.text.MessageFormat;
import java.util.Map;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Provider;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.request.ValidationRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.common.response.ValidationResponse;
import portalrefimpl.schedule.createappointment.bc.PractitionerBC;
import portalrefimpl.schedule.createappointment.request.PractitionerRequest;
import portalrefimpl.schedule.createappointment.response.PractitionerResponse;
import portalrefimpl.schedule.createappointment.svc.PractitionerSvc;

/**
 * Service impl to get practitioners for a speciality
 * 
 * @author GRamamoorthy
 * 
 */
@WebServiceProvider
public class PractitionerSvcImpl extends BasePractitionerSvcImpl implements
		PractitionerSvc, Provider<Source> {

	/**
	 * This method registers the http url for this web service
	 */
	public void registerService(BaseRequest request) {
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String practitionerListUrl = PortalHelper
				.getWebServiceURL(PortalConstants.CREATEAPPOINTMENT_GETPRACTITIONER_WS_URL_KEY);
		e.publish(practitionerListUrl);
	}

	/**
	 * This method does the basic validation of the request parameters
	 * This method in turn calls the base class isValidRequestor() method
	 * to validate for the security token
	 * This method then validates the following parameters in the request
	 * 1. Facility Id 2. Specialty Id 3. Oper standard id
	 * 4. Resource class 5. Preferred start date 6. Preferred start time
	 * 7. Preferred end time
	 */
	public BaseResponse isValidRequest(BaseRequest request) {
		ValidationRequest validationRequest = new ValidationRequest();
		validationRequest.setPortalUserName(request.getPortalUserName());
		ValidationResponse validationResponse = isValidRequestor(validationRequest);

		PractitionerResponse response = new PractitionerResponse();
		if(!validationResponse.isSuccessful()){
			response.addAllErrors(validationResponse.getErrors());
		}
		/*ErrorInfo errorInfo = validationResponse.getErrorInfo();
		// set the errorinfo to the response
		// here after only the error info will be updated
		response.setErrorInfo(errorInfo);
		// request has failed basic validation - so return error response
		if (ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()) {
			return response;
		}*/
		// safely cast to practitioner request
		PractitionerRequest practRequest = (PractitionerRequest)request;
		// call the method to validate the request
		// this method is present in the base class
		validatePractitionerRequest(practRequest,response);
		// finally there is a need to set a positive response
		// if there are no errors in the response object
		if(!response.hasErrors()){
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
			response.addError(errorInfo);
		}
		
		return response;
	}

	/**
	 * This method gets the practitioner list given
	 * the practitioner request object
	 */
	public PractitionerResponse getPractitionerList(
			PractitionerRequest practitionerRequest) {
		PractitionerResponse practitionerResponse = new PractitionerResponse();
		// first step - validate the request
		// if validation fails return the response
		practitionerResponse = (PractitionerResponse)isValidRequest(practitionerRequest);
		if(!practitionerResponse.isSuccessful()){
			return practitionerResponse;
		}
		/*ErrorInfo errorInfo = practitionerResponse.getErrorInfo();
		if(ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()){
			return practitionerResponse;
		}*/
		
		// next get the data through the BC class 
		PractitionerBC bcInst = null;
		ApplicationContext context = new ClassPathXmlApplicationContext("app-beans.xml");
		bcInst = (PractitionerBC)context.getBean("refPractitionerBC");
		practitionerResponse = bcInst.getPractitionerList(practitionerRequest);
		
		return practitionerResponse;
	}

	/**
	 * main method in this class - this method is invoked
	 * when the http URL for this service is accessed
	 * This method in turn calls the getPractitionerList() to 
	 * get the practitioner list
	 * 
	 */
	public Source invoke(Source arg0) {
		StreamSource reply = null;
		PractitionerResponse practitionerResponse = null;
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String)mc.get(MessageContext.QUERY_STRING);
			Map<String, String> parameterMap = getRequestParameterMap(path);
			// get the request object
			PractitionerRequest practitionerRequest = new PractitionerRequest();
			populatePractitionerRequest(parameterMap,practitionerRequest);
			practitionerResponse = getPractitionerList(practitionerRequest);
			
			//xmlFileContent = getPractitionerXML(practitionerResponse);
		}catch (Exception e) {
			// need to form an error info object as the xml output here
			int errorCode = CommonConstants.WEBSERVICE_EXCEPTION_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
							errorCode);
			// there is a need to fill in the web service
			// name in the error message using format
			errorMessage = MessageFormat
					.format(errorMessage,
							new Object[] { CommonConstants.APPTREQUEST_PRACT_LIST_SVC_NAME_KEY });
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			practitionerResponse = new PractitionerResponse();
			practitionerResponse.addError(errorInfo);
			/*practitionerResponse.setErrorInfo(errorInfo);*/
			//xmlFileContent = JaxbHelper.marshallObject(practitionerResponse);
			
			/*StringBuffer xmlContentBuff = new StringBuffer();
			xmlContentBuff
					.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
			xmlContentBuff.append(getXMLStartTag(CreateAppointmentConstants.PRACTITIONERLIST_SERVICE_ROOTELEMENT_KEY));
			createErrorResponse(errorMessage, errorCode, xmlContentBuff);
			xmlContentBuff.append(getXMLEndTag(CreateAppointmentConstants.PRACTITIONERLIST_SERVICE_ROOTELEMENT_KEY));
			xmlFileContent = xmlContentBuff.toString();*/
		}
		/*xmlFileContent = getResponseXMLString(practitionerResponse);
		// form the reply object and return it
		reply = new StreamSource(new StringReader(xmlFileContent));*/
		
		reply = getServiceResponseAsStreamSource(practitionerResponse,
				CommonConstants.APPTREQUEST_PRACT_LIST_SVC_NAME_KEY);
		
		return reply;
	}
	
	
}
