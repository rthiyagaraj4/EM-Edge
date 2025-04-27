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
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.createappointment.bc.PractitionerTimeSlotBC;
import portalrefimpl.schedule.createappointment.request.PractitionerTimeSlotRequest;
import portalrefimpl.schedule.createappointment.response.PractitionerTimeSlotResponse;
import portalrefimpl.schedule.createappointment.svc.PractitionerTimeSlotSvc;

/**
 * This is the implementation class for the practitioner time slot service
 * This class extends BasePractitionerStatusSvcImpl and implements the 
 * service interface PractitionerTimeSlotSvc and also the 
 * interface Provider from JAX-WS API
 * 
 * @author GRamamoorthy
 *
 */
@WebServiceProvider
public class PractitionerTimeSlotSvcImpl extends BasePractitionerStatusSvcImpl implements
		PractitionerTimeSlotSvc, Provider<Source> {

	/**
	 * This method registers the HTTP URL for the practitioner time slot
	 * service
	 */
	public void registerService(BaseRequest request) {
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String practitionerTimeSlotServiceUrl = PortalHelper
				.getWebServiceURL(PortalConstants.CREATEAPPOINTMENT_GETPRACTITIONERTIMESLOT_WS_URL_KEY);
		e.publish(practitionerTimeSlotServiceUrl);
	}

	/**
	 * This method validates the practitioner time slot request
	 * 
	 */
	public BaseResponse isValidRequest(BaseRequest request) {
		ValidationRequest validationRequest = new ValidationRequest();
		validationRequest.setPortalUserName(request.getPortalUserName());
		ValidationResponse validationResponse = isValidRequestor(validationRequest);
		
		PractitionerTimeSlotResponse response = new PractitionerTimeSlotResponse();
		// if basic validation has failed, add the errors to the response
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
		
		// safely cast the request to practitioner time slot request
		PractitionerTimeSlotRequest practitionerTimeSlotRequest = (PractitionerTimeSlotRequest) request;
		// the following needs to be validated
		// 1. practitioner id 2. facility id 3. resource type 
		// 4. preferred date 
		// properties 1-3 are validated through the base class method
		validatePractitionerStatusRequest(practitionerTimeSlotRequest, response);
		// check and return now if the response already contains error
		/*if(ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()){
			return response;
		}*/
		
		ErrorInfo errorInfo = null;
		// now validate the preferred date
		String preferredDate = practitionerTimeSlotRequest.getPreferredDate();
		if(preferredDate == null || preferredDate.trim().equals("")){
			int errorCode = CreateAppointmentConstants.PRACTITIONERTIMESLOT_PREFERREDDATE_MISSING_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
		}
		
		// also check whether the preferred date is within the next X days
		// where X is the number of days in future till which appointment
		// booking can be done
		validatePreferredDate(preferredDate, response);
		// check and return now if the response already contains error
		/*if(ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()){
			return response;
		}*/
		
		// finally if all the validations are successful, set positive response
		if(!response.hasErrors()){
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
			response.addError(errorInfo);
		}
		
		return response;
	}

	/**
	 * This method gets the practitioner time slot information
	 * This method is the main business method in this service
	 */
	public PractitionerTimeSlotResponse getPractitionerTimeSlot(
			PractitionerTimeSlotRequest practitionerTimeSlotRequest) {
		PractitionerTimeSlotResponse response = null;
		// first step - validate the request
		// if validation fails return the response
		response = (PractitionerTimeSlotResponse)isValidRequest(practitionerTimeSlotRequest);
		if(!response.isSuccessful()){
			return response;
		}
		/*ErrorInfo errorInfo = response.getErrorInfo();
		if(ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()){
			return response;
		}*/
		
		// next get the data through the BC class 
		ApplicationContext context = new ClassPathXmlApplicationContext("app-beans.xml");
		PractitionerTimeSlotBC bcInst = (PractitionerTimeSlotBC)context.getBean("refPractitionerTimeSlotBC");
		response = bcInst.getPractitionerTimeSlot(practitionerTimeSlotRequest);
		
		return response;
	}

	/**
	 * This is the main method in this class
	 * This method is invoked when the HTTP URL for this web service
	 * is accessed
	 * This class in turn calls the business method getPractitionerTimeSlot()
	 * to get the practitioner time slot information and then returns
	 * this data in xml format
	 */
	public Source invoke(Source arg0) {
		StreamSource reply = null;
		// initialize the response object
		PractitionerTimeSlotResponse practitionerTimeSlotResponse = null;
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String)mc.get(MessageContext.QUERY_STRING);
			Map<String, String> parameterMap = getRequestParameterMap(path);
			
			PractitionerTimeSlotRequest practitionerTimeSlotRequest = getPractitionerTimeSlotRequest(parameterMap);
			practitionerTimeSlotResponse = getPractitionerTimeSlot(practitionerTimeSlotRequest);
			
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
							new Object[] { CommonConstants.APPTREQUEST_TIMESLOT_SVC_NAME_KEY });
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			practitionerTimeSlotResponse = new PractitionerTimeSlotResponse();
			practitionerTimeSlotResponse.addError(errorInfo);
			/*practitionerTimeSlotResponse.setErrorInfo(errorInfo);*/
		}
		
		/*xmlFileContent = getResponseXMLString(practitionerTimeSlotResponse);
		// form the reply object and return it
		reply = new StreamSource(new StringReader(xmlFileContent));*/
		
		reply = getServiceResponseAsStreamSource(practitionerTimeSlotResponse,
				CommonConstants.APPTREQUEST_TIMESLOT_SVC_NAME_KEY);
		
		return reply;
		
	}
	
	/**
	 * This method gets the practitioner time slot request object
	 * given the parameter map which contains the parameters passed
	 * in the web service URL 
	 * @param parameterMap
	 * @return
	 */
	private PractitionerTimeSlotRequest getPractitionerTimeSlotRequest(
			Map<String, String> parameterMap) {
		// initialize the request object
		PractitionerTimeSlotRequest request = new PractitionerTimeSlotRequest();
		// call the base class method to populate the base properties
		populatePropertyInRequest(request, parameterMap);

		// now populate the specific parameters for this service
		if (parameterMap
				.containsKey(CreateAppointmentConstants.PRACTITIONERTIMESLOT_PREFERREDDATE_REQUEST_PARAMETER)) {
			String preferredDate = parameterMap
					.get(CreateAppointmentConstants.PRACTITIONERTIMESLOT_PREFERREDDATE_REQUEST_PARAMETER);
			request.setPreferredDate(preferredDate);
		}
		// call the method which will populate the common properties in the request object
		populateCommonPropertiesInRequest(request,parameterMap);
		
		return request;
	}
	
	
}
