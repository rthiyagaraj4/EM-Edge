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
import portalrefimpl.common.svc.BaseServiceImpl;
import portalrefimpl.schedule.createappointment.bc.SpecialityBC;
import portalrefimpl.schedule.createappointment.request.SpecialityRequest;
import portalrefimpl.schedule.createappointment.response.SpecialityResponse;
import portalrefimpl.schedule.createappointment.svc.SpecialitySvc;

/**
 * @author SaraswathiR RESTful web service class for getting the Speciality List
 * 
 */
@WebServiceProvider
public class SpecialitySvcImpl extends BaseServiceImpl implements
		SpecialitySvc, Provider<Source> {

	/**
	 * 
	 * Register web Service to a HTTP URL
	 */
	public void registerService(BaseRequest request) {
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String specialityListUrl = PortalHelper
				.getWebServiceURL(PortalConstants.CREATEAPPOINTMENT_GETSPECIALITY_WS_URL_KEY);
		e.publish(specialityListUrl);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see
	 * portalrefimpl.common.svc.BaseService#isValidRequest(portalrefimpl.common
	 * .request.BaseRequest)
	 */
	public BaseResponse isValidRequest(BaseRequest request) {
		ValidationRequest validationRequest = new ValidationRequest();
		validationRequest.setPortalUserName(request.getPortalUserName());
		ValidationResponse validationResponse = isValidRequestor(validationRequest);

		SpecialityResponse response = new SpecialityResponse();
		// add all the error objects from validation response object
		// to the speciality response object - there is no need to
		// check for the presence of errors or anything of that sort
		response.addAllErrors(validationResponse.getErrors());
		/*ErrorInfo errorInfo = validationResponse.getErrorInfo();
		// request has failed basic validation - so return error response
		if (ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()) {
			response.setErrorInfo(errorInfo);
			return response;
		}
		// add any other validations if needed
		response.setErrorInfo(errorInfo);*/
		return response;
	}

	/**
	 * This is the main business method in this service
	 * (non-Javadoc)
	 * 
	 * @see
	 * portalrefimpl.schedule.createappointment.svc.SpecialitySvc#getSpecialities
	 * (portalrefimpl.schedule.createappointment.request.SpecialityRequest)
	 */
	public SpecialityResponse getSpecialities(
			SpecialityRequest specialityRequest) {
		// Initialize the response object
		SpecialityResponse specialityResponse = new SpecialityResponse();

		// first step - validate the request
		// if validation fails return the response
		specialityResponse = (SpecialityResponse) isValidRequest(specialityRequest);
		if(!specialityResponse.isSuccessful()){
			return specialityResponse;
		}
		/*ErrorInfo errorInfo = specialityResponse.getErrorInfo();
		if (ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()) {
			return specialityResponse;
		}*/
		// proceed to second step only after validation succeeds
		// second step - get the test result
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"app-beans.xml");
		SpecialityBC bcInst = (SpecialityBC) context.getBean("refSpecialityBC");
		specialityResponse = bcInst.getSpecialityList(specialityRequest);

		return specialityResponse;

	}

	/**
	 * This is the main method in this web service
	 * is invoked when the HTTP URL of this service is invoked
	 */
	public Source invoke(Source arg0) {
		StreamSource reply = null;

		SpecialityResponse specialityResponse = null;
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String) mc.get(MessageContext.QUERY_STRING);
			Map<String, String> parameterMap = getRequestParameterMap(path);
			SpecialityRequest specialityRequest = getSpecialityRequest(parameterMap);
			specialityResponse = getSpecialities(specialityRequest);

			// xmlFileContent = getSpecialityXML(specialityResponse);
		} catch (Exception e) {
			int errorCode = CommonConstants.WEBSERVICE_EXCEPTION_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.COMMON_MODULE_NAME,
							errorCode);
			// there is a need to fill in the web service
			// name in the error message using format
			errorMessage = MessageFormat
					.format(errorMessage,
							new Object[] { CommonConstants.APPTREQUEST_SPECIALITY_LIST_SVC_NAME_KEY });

			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			specialityResponse = new SpecialityResponse();
			specialityResponse.addError(errorInfo);
			/*specialityResponse.setErrorInfo(errorInfo);*/
			// xmlFileContent = JaxbHelper.marshallObject(specialityResponse);
			/*
			 * StringBuffer xmlContentBuff = new StringBuffer();
			 * xmlContentBuff.append
			 * ("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
			 * xmlContentBuff.append("<" +
			 * ScheduleConstants.SPECIALITY_LIST_ROOT_XML_TAG + ">");
			 * createErrorResponse(errorMessage, errorCode, xmlContentBuff);
			 * xmlContentBuff.append("</" +
			 * ScheduleConstants.SPECIALITY_LIST_ROOT_XML_TAG + ">");
			 * xmlFileContent = xmlContentBuff.toString();
			 */
		}

		/*xmlFileContent = getResponseXMLString(specialityResponse);
		// form the reply object and return it
		reply = new StreamSource(new StringReader(xmlFileContent));*/
		
		reply = getServiceResponseAsStreamSource(specialityResponse,
				CommonConstants.APPTREQUEST_SPECIALITY_LIST_SVC_NAME_KEY);
		
		return reply;
	}

	/**
	 * This method creates the Speciality request object
	 * 
	 * @param parameterMap
	 * @return
	 */
	private SpecialityRequest getSpecialityRequest(
			Map<String, String> parameterMap) {
		SpecialityRequest specialityRequest = new SpecialityRequest();
		// set the portal user name to the request first
		if (parameterMap
				.containsKey(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY)) {
			String authKey = parameterMap
					.get(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY);
			if (authKey == null) {
				authKey = "";
			}
			specialityRequest.setPortalUserName(authKey);
		}
		
		return specialityRequest;
	}

}
