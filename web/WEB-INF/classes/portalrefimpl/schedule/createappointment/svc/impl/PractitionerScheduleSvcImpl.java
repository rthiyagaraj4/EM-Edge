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
import portalrefimpl.schedule.createappointment.bc.PractitionerScheduleBC;
import portalrefimpl.schedule.createappointment.request.PractitionerRequest;
import portalrefimpl.schedule.createappointment.request.PractitionerScheduleRequest;
import portalrefimpl.schedule.createappointment.response.PractitionerScheduleResponse;
import portalrefimpl.schedule.createappointment.svc.PractitionerScheduleSvc;

/**
 * This is the implementation class for the practitioner schedule service This
 * class extends the BasePractitionerSvcImpl and implements the service
 * interface for practitioner schedule and the Provider interface
 * 
 * @author GRamamoorthy
 * 
 */
@WebServiceProvider
public class PractitionerScheduleSvcImpl extends BasePractitionerSvcImpl
		implements PractitionerScheduleSvc, Provider<Source> {

	/**
	 * This method registers the http url of this service with the end point
	 */
	public void registerService(BaseRequest request) {
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String practitionerScheduleUrl = PortalHelper
				.getWebServiceURL(PortalConstants.CREATEAPPOINTMENT_GETPRACTITIONERSCHEDULE_WS_URL_KEY);
		e.publish(practitionerScheduleUrl);
	}

	/**
	 * This method validates the request for getting the practitioner schedule
	 * This method in turn calls the base class isValidRequestor() method to
	 * validate for the security token This method then validates the following
	 * parameters in the request 1. Facility Id 2. Specialty Id 3. Practitioner
	 * Id 4. Oper standard id 5. Resource class 6. Preferred start date 7.
	 * Preferred start time 8. Preferred end time
	 */
	public BaseResponse isValidRequest(BaseRequest request) {
		ValidationRequest validationRequest = new ValidationRequest();
		validationRequest.setPortalUserName(request.getPortalUserName());
		ValidationResponse validationResponse = isValidRequestor(validationRequest);

		PractitionerScheduleResponse response = new PractitionerScheduleResponse();
		// if basic validation has failed, then set the errors to the response object
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
		
		ErrorInfo errorInfo = null;
		// safely cast to practitioner request
		PractitionerRequest practRequest = (PractitionerRequest) request;
		// call the method to validate the request
		// this method is present in the base class
		validatePractitionerRequest(practRequest, response);
		// check and return now if the response already contains error
		/*if (ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()) {
			return response;
		}*/

		// now add the extra validation for practitioner id
		String practitionerId = practRequest.getPractitionerId();
		if (practitionerId == null || practitionerId.trim().equals("")) {
			int errorCode = CreateAppointmentConstants.PRACTITIONER_REQUEST_INVALIDPRACTITIONERID_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
		}
		
		// finally if all validations have passed, set positive response
		if(!response.hasErrors()){
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
			response.addError(errorInfo);
		}

		return response;
	}

	/**
	 * This method obtains the practitioner schedule
	 */
	public PractitionerScheduleResponse getPractitionerSchedule(
			PractitionerScheduleRequest practitionerScheduleRequest) {
		PractitionerScheduleResponse practitionerScheduleResponse = null;
		// first step - validate the request
		// if validation fails return the response
		practitionerScheduleResponse = (PractitionerScheduleResponse) isValidRequest(practitionerScheduleRequest);
		if(!practitionerScheduleResponse.isSuccessful()){
			return practitionerScheduleResponse;
		}
		/*
		 * ErrorInfo errorInfo = practitionerScheduleResponse.getErrorInfo();
		 * if(ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()){ return
		 * practitionerScheduleResponse; }
		 */

		// next get the data through the BC class
		PractitionerScheduleBC bcInst = null;
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"app-beans.xml");
		bcInst = (PractitionerScheduleBC) context
				.getBean("refPractitionerScheduleBC");
		practitionerScheduleResponse = bcInst
				.getPractitionerSchedule(practitionerScheduleRequest);

		return practitionerScheduleResponse;
	}

	/**
	 * This is the main method in this service This method retrieves the
	 * schedule for a practitioner by internally calling the
	 * getPractitionerSchedule() method This method is called when the http url
	 * for this service is accessed
	 */
	public Source invoke(Source arg0) {
		StreamSource reply = null;
		PractitionerScheduleResponse practitionerScheduleResponse = null;
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String) mc.get(MessageContext.QUERY_STRING);
			Map<String, String> parameterMap = getRequestParameterMap(path);

			// get the request object
			PractitionerScheduleRequest practitionerScheduleRequest = new PractitionerScheduleRequest();
			populatePractitionerScheduleRequest(parameterMap,
					practitionerScheduleRequest);

			practitionerScheduleResponse = getPractitionerSchedule(practitionerScheduleRequest);
			// xmlFileContent =
			// getPractitionerScheduleXML(practitionerScheduleResponse);

		} catch (Exception e) {
			// need to form an error info object as the xml output here
			int errorCode = CommonConstants.WEBSERVICE_EXCEPTION_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
							errorCode);
			// there is a need to fill in the web service
			// name in the error message using format
			errorMessage = MessageFormat
					.format(errorMessage,
							new Object[] { CommonConstants.APPTREQUEST_PRACT_SCHEDULE_SVC_NAME_KEY });
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			practitionerScheduleResponse = new PractitionerScheduleResponse();
			practitionerScheduleResponse.addError(errorInfo);
			/* practitionerScheduleResponse.setErrorInfo(errorInfo); */
		}
		/*xmlFileContent = getResponseXMLString(practitionerScheduleResponse);
		// form the reply object and return it
		reply = new StreamSource(new StringReader(xmlFileContent));*/
		
		reply = getServiceResponseAsStreamSource(practitionerScheduleResponse,
				CommonConstants.APPTREQUEST_PRACT_SCHEDULE_SVC_NAME_KEY);
		
		return reply;
	}

	/**
	 * This method forms the practitioner request object
	 * 
	 * @param parameterMap
	 * @return
	 */
	private void populatePractitionerScheduleRequest(
			Map<String, String> parameterMap,
			PractitionerScheduleRequest practitionerScheduleRequest) {
		// first call the super method to populate the all the base parameters
		super.populatePractitionerRequest(parameterMap,
				practitionerScheduleRequest);
		// in this class, we need to populate only practitioner id additionally
		if (parameterMap
				.containsKey(CreateAppointmentConstants.PRACTITIONER_PRACTITIONERID_PARAMETER_KEY)) {
			String practitionerId = parameterMap
					.get(CreateAppointmentConstants.PRACTITIONER_PRACTITIONERID_PARAMETER_KEY);
			practitionerScheduleRequest.setPractitionerId(practitionerId);
		}
	}

}
