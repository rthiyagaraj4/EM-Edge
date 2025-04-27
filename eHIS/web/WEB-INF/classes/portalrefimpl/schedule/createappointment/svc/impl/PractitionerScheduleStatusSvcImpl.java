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
import java.util.Date;
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
import portalrefimpl.schedule.createappointment.bc.PractitionerScheduleStatusBC;
import portalrefimpl.schedule.createappointment.request.PractitionerScheduleStatusRequest;
import portalrefimpl.schedule.createappointment.response.PractitionerScheduleStatusResponse;
import portalrefimpl.schedule.createappointment.svc.PractitionerScheduleStatusSvc;

/**
 * This class is the implementation class for service PractitionerScheduleStatusSvc
 * This class extends BasePractitionerStatusSvcImpl class and implements the interfaces
 * PractitionerScheduleStatusSvc and Provider
 * @author GRamamoorthy
 *
 */
@WebServiceProvider
public class PractitionerScheduleStatusSvcImpl extends
		BasePractitionerStatusSvcImpl implements PractitionerScheduleStatusSvc,
		Provider<Source> {

	/**
	 * This method registers the HTTP URL for this service with end point
	 */
	public void registerService(BaseRequest request) {
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String practitionerTimeSlotServiceUrl = PortalHelper
				.getWebServiceURL(PortalConstants.CREATEAPPOINTMENT_GETPRACTITIONERSCHEDULESTATUS_WS_URL_KEY);
		e.publish(practitionerTimeSlotServiceUrl);

	}

	/**
	 * This method validates the service request
	 * and returns response
	 */
	public BaseResponse isValidRequest(BaseRequest request) {
		ValidationRequest validationRequest = new ValidationRequest();
		validationRequest.setPortalUserName(request.getPortalUserName());
		ValidationResponse validationResponse = isValidRequestor(validationRequest);
		
		PractitionerScheduleStatusResponse response = new PractitionerScheduleStatusResponse();
		// if basic validation has failed, add the errors to the response object
		if(!validationResponse.isSuccessful()){
			response.addAllErrors(validationResponse.getErrors());
		}
		/*ErrorInfo errorInfo = validationResponse.getErrorInfo();*/
		ErrorInfo errorInfo = null;
		// set the errorinfo to the response
		// here after only the error info will be updated
		/*response.setErrorInfo(errorInfo);
		// request has failed basic validation - so return error response
		if (ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()) {
			return response;
		}*/
		// safe cast - no worries
		PractitionerScheduleStatusRequest practitionerScheduleStatusRequest = (PractitionerScheduleStatusRequest) request;
		// the following needs to be validated
		// 1. practitioner id 2. facility id 3. resource type 
		// 4. preferred date 
		// properties 1-3 are validated through the base class method
		validatePractitionerStatusRequest(practitionerScheduleStatusRequest, response);
		// check and return now if the response already contains error
		/*if(ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()){
			return response;
		}*/
		
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		// validate the from date
		String preferredFromDate = practitionerScheduleStatusRequest.getPreferredFromDate();
		if(preferredFromDate == null || preferredFromDate.trim().equals("")){
			errorCode = CreateAppointmentConstants.PRACTITIONERSCHEDULESTATUS_FROMDATE_MISSING_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			/*return response;*/
		}
		// also check whether the preferred date is within the next X days
		// where X is the number of days in future till which appointment
		// booking can be done
		validatePreferredDate(preferredFromDate, response);
		/*if (ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()) {
			return response;
		}*/
		
		// validate preferred to date
		validateToDate(practitionerScheduleStatusRequest,response);
		
		// finally if all validations have passed, then set the response as positive
		if(!response.hasErrors()){
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
			response.addError(errorInfo);
		}
		
		return response;
	}
	
	/**
	 * This method validates the to date specified in the practitioner schedule
	 * status request
	 * @param practitionerScheduleStatusRequest
	 * @param response
	 */
	private void validateToDate(
			PractitionerScheduleStatusRequest practitionerScheduleStatusRequest,
			PractitionerScheduleStatusResponse response) {
		int errorCode = 0;
		String errorMessage = null;
		ErrorInfo errorInfo = null;
		/*ErrorInfo errorInfo = response.getErrorInfo();*/
		// first check for null or empty value
		String preferredToDateStr = practitionerScheduleStatusRequest.getPreferredToDate();
		if(preferredToDateStr == null || preferredToDateStr.trim().equals("")){
			errorCode = CreateAppointmentConstants.PRACTITIONERSCHEDULESTATUS_TODATE_MISSING_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			/*return;*/
		}
		// get the date equivalent of to date
		Date preferredToDate = PortalHelper.getDateFromString(preferredToDateStr,
				CreateAppointmentConstants.PRACTITIONERSTATUS_DATEFORMAT);
		Date currentDate = new Date();
		// check for past date
		if(currentDate.after(preferredToDate)){
			errorCode = CreateAppointmentConstants.PRACTITIONERSCHEDULESTATUS_TODATE_PASTDATE_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.COMMON_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			/*return;*/
		}
		// get the from date
		String preferredFromDateStr = practitionerScheduleStatusRequest.getPreferredFromDate();
		Date preferredFromDate = PortalHelper.getDateFromString(preferredFromDateStr,
				CreateAppointmentConstants.PRACTITIONERSTATUS_DATEFORMAT);
		// now check if the to date is earlier than the from date
		// if so invalidate - from date will not be null here
		if(preferredToDate.before(preferredFromDate)){
			errorCode = CreateAppointmentConstants.PRACTITIONERSCHEDULESTATUS_TODATE_BEFORE_FROMDATE_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.COMMON_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			/*return;*/
		}
	}

	/**
	 * This is the main method for the web service
	 * This method gets invoked when the HTTP URL for this web service is accessed
	 */
	public Source invoke(Source arg0) {
		StreamSource reply = null;
		PractitionerScheduleStatusResponse response = null;
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String) mc.get(MessageContext.QUERY_STRING);
			Map<String, String> parameterMap = getRequestParameterMap(path);
			
			PractitionerScheduleStatusRequest request = getPractitionerScheduleStatusRequest(parameterMap);
			response = getPractitionerScheduleStatus(request);
			//xmlFileContent = getPractitionerScheduleStatusXMLContent(response);
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
							new Object[] { CommonConstants.APPTREQUEST_PRACT_SCHEDULE_STATUS_SVC_NAME_KEY });
			
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response = new PractitionerScheduleStatusResponse();
			response.addError(errorInfo);
			/*response.setErrorInfo(errorInfo);*/
			//xmlFileContent = JaxbHelper.marshallObject(response);
			/*StringBuffer xmlContentBuff = new StringBuffer();
			xmlContentBuff
					.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
			xmlContentBuff
					.append(getXMLStartTag(CreateAppointmentConstants.PRACTITIONERSCHEDULESTATUS_SERVICE_ROOTELEMENT_KEY));
			createErrorResponse(errorMessage, errorCode, xmlContentBuff);
			xmlContentBuff
					.append(getXMLEndTag(CreateAppointmentConstants.PRACTITIONERSCHEDULESTATUS_SERVICE_ROOTELEMENT_KEY));
			xmlFileContent = xmlContentBuff.toString();*/
		}
		/*xmlFileContent = getResponseXMLString(response);
		// form the reply object and return it
		reply = new StreamSource(new StringReader(xmlFileContent));*/
		
		reply = getServiceResponseAsStreamSource(response,
				CommonConstants.APPTREQUEST_PRACT_SCHEDULE_STATUS_SVC_NAME_KEY);
		
		return reply;
	}

	/**
	 * This method gets the practitioner schedule status response
	 * This method is the main business method in this class
	 */
	public PractitionerScheduleStatusResponse getPractitionerScheduleStatus(
			PractitionerScheduleStatusRequest practitionerScheduleStatusRequest) {
		PractitionerScheduleStatusResponse response = new PractitionerScheduleStatusResponse();
		// first step - validate the request
		// if validation fails return the response
		response = (PractitionerScheduleStatusResponse) isValidRequest(practitionerScheduleStatusRequest);
		if(!response.isSuccessful()){
			return response;
		}
		/*ErrorInfo errorInfo = response.getErrorInfo();
		if(ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()){
			return response;
		}*/
		
		// next get the data through the BC class 
		ApplicationContext context = new ClassPathXmlApplicationContext("app-beans.xml");
		PractitionerScheduleStatusBC bcInst = (PractitionerScheduleStatusBC) context
				.getBean("refPractitionerScheduleStatusBC");
		return bcInst.getPractitionerScheduleStatus(practitionerScheduleStatusRequest);
	}

	/**
	 * This method returns the practitioner schedule status request object
	 * @param parameterMap
	 * @return
	 */
	private PractitionerScheduleStatusRequest getPractitionerScheduleStatusRequest(
			Map<String, String> parameterMap) {
		PractitionerScheduleStatusRequest request = new PractitionerScheduleStatusRequest();
		// call the base class method to populate the base properties
		populatePropertyInRequest(request, parameterMap);
		
		// now populate the preferred from date and the preferred to date
		if (parameterMap
				.containsKey(CreateAppointmentConstants.PRACTITIONERSCHEDULESTATUS_PREFERREDFROMDATE_PARAMETER_KEY)) {
			String fromDateStr = parameterMap
					.get(CreateAppointmentConstants.PRACTITIONERSCHEDULESTATUS_PREFERREDFROMDATE_PARAMETER_KEY);
			request.setPreferredFromDate(fromDateStr);
		}
		if (parameterMap
				.containsKey(CreateAppointmentConstants.PRACTITIONERSCHEDULESTATUS_PREFERREDTODATE_PARAMETER_KEY)) {
			String toDateStr = parameterMap
					.get(CreateAppointmentConstants.PRACTITIONERSCHEDULESTATUS_PREFERREDTODATE_PARAMETER_KEY);
			request.setPreferredToDate(toDateStr);
		}
		// call the method which will populate the common properties in the request object
		populateCommonPropertiesInRequest(request,parameterMap);
				
		
		return request;
	}
	
}
