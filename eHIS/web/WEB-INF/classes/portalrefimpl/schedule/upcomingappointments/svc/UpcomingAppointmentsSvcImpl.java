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
package portalrefimpl.schedule.upcomingappointments.svc;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import portalrefimpl.common.svc.BaseServiceImpl;
import portalrefimpl.schedule.ScheduleConstants;
import portalrefimpl.schedule.upcomingappointments.bc.UpcomingAppointmentsBC;
import portalrefimpl.schedule.upcomingappointments.request.UpcomingAppointmentsRequest;
import portalrefimpl.schedule.upcomingappointments.response.UpcomingAppointmentsResponse;

/**
 * @author SaraswathiR This class can be made into a RESTful web service by
 *         implementing Provider interface given by JAX-WS
 */
@WebServiceProvider
public class UpcomingAppointmentsSvcImpl extends BaseServiceImpl implements
		UpcomingAppointmentsSvc, Provider<Source> {

	/**
	 * method registers the HTTP URL with end point
	 */
	public void registerService(BaseRequest request) {
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String upcomingAppointmentDetailsUrl = PortalHelper
				.getWebServiceURL(PortalConstants.UPCOMINGAPPOINTMENTDETAILS_WS_URL_KEY);
		e.publish(upcomingAppointmentDetailsUrl);

	}

	/**
	 * validates the request
	 */
	public BaseResponse isValidRequest(BaseRequest request) {
		// basic validation - authentication
		ValidationRequest validationRequest = new ValidationRequest();
		validationRequest.setPortalUserName(request.getPortalUserName());
		ValidationResponse validationResponse = isValidRequestor(validationRequest);

		UpcomingAppointmentsResponse response = new UpcomingAppointmentsResponse();
		// add the errors from basic validation only to the response
		if (!validationResponse.isSuccessful()) {
			response.addAllErrors(validationResponse.getErrors());
		}
		/*
		 * ErrorInfo errorInfo = validationResponse.getErrorInfo(); // request
		 * has failed basic validation - so return error response if
		 * (ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()) {
		 * response.setErrorInfo(errorInfo); return response; }
		 * response.setErrorInfo(errorInfo);
		 */

		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		// now validate the request's other details
		// there is a need to validate the patient id and the order id
		UpcomingAppointmentsRequest upcomingAppointmentsRequest = (UpcomingAppointmentsRequest) request;
		String patientId = upcomingAppointmentsRequest.getPatientId();
		if (patientId == null || patientId.trim().equals("")) {
			errorCode = ScheduleConstants.UPCOMING_APPOINTMENTS_PATIENTID_ABSENT_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
					errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);

			response.addError(errorInfo);
			/* return response; */
		}

		int startRecordNum = upcomingAppointmentsRequest.getStartRecordNum();
		int endRecordNum = upcomingAppointmentsRequest.getEndRecordNum();
		// Both start and end record num cannot be lesser than 0
		if (startRecordNum < 0 || endRecordNum < 0) {
			errorCode = ScheduleConstants.UPCOMING_APPOINTMENTS_START_END_RECORDNUM_INVALID_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
					errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);

			response.addError(errorInfo);
			/* return response; */
		}
		// When start end record num is given start record num should also be
		// given
		if (startRecordNum <= 0 && endRecordNum > 0) {
			errorCode = ScheduleConstants.UPCOMING_APPOINTMENTS_STARTRECORDNUM_ABSENT_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
					errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);

			response.addError(errorInfo);
			/* return response; */
		}
		// When start record num is given, end record num should als be given
		if (startRecordNum > 0 && endRecordNum <= 0) {
			errorCode = ScheduleConstants.UPCOMING_APPOINTMENTS_ENDRECORDNUM_ABSENT_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
					errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);

			response.addError(errorInfo);
			/* return response; */
		}
		// Start record num cannor be greater than end record num
		if (startRecordNum > endRecordNum) {
			errorCode = ScheduleConstants.UPCOMING_APPOINTMENTS_START_GREATER_THAN_END_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
					errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);

			response.addError(errorInfo);
			/* return response; */
		}

		// Date validations
		String fromDate = upcomingAppointmentsRequest.getFromDate();
		String toDate = upcomingAppointmentsRequest.getToDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				ScheduleConstants.UPCOMINGAPPOINTMENTS_DATE_FORMAT);
		Date from_date = null;
		Date to_date = null;
		Date today = new Date();
		// From date - Converting string date to date object. If parse error
		// occurs error response is returned
		if (fromDate != null && !fromDate.trim().equals("")) {
			try {
				from_date = dateFormat.parse(fromDate);
			} catch (ParseException e) {
				errorCode = ScheduleConstants.UPCOMING_APPOINTMENTS_FROM_DATE_INVALIDFORMAT_ERRORCODE;
				errorMessage = MessageContainer
						.getInstance()
						.getDisplayMessage(
								CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
								errorCode);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);

				response.addError(errorInfo);
				/* return response; */
			}
		}
		// To date - Converting string date to date object. If parse error
		// occurs error response is returned
		if (toDate != null && !toDate.trim().equals("")) {
			try {
				to_date = dateFormat.parse(toDate);
			} catch (ParseException e) {
				errorCode = ScheduleConstants.UPCOMING_APPOINTMENTS_TODATE_INVALIDFORMAT_ERRORCODE;
				errorMessage = MessageContainer
						.getInstance()
						.getDisplayMessage(
								CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
								errorCode);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);

				response.addError(errorInfo);
				/* return response; */
			}
		}
		// Either of from or to date cannot be given
		// Both should be given, or both should not be given
		if ((fromDate == null || fromDate.trim().equals(""))
				&& (toDate != null && !toDate.trim().equals(""))) {
			errorCode = ScheduleConstants.UPCOMING_APPOINTMENTS_FROMDATE_ABSENT_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
					errorCode);

			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);

			response.addError(errorInfo);
			/* return response; */
		}

		if ((fromDate != null && !fromDate.trim().equals(""))
				&& (toDate == null || toDate.trim().equals(""))) {
			errorCode = ScheduleConstants.UPCOMING_APPOINTMENTS_TODATE_ABSENT_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
					errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);

			response.addError(errorInfo);
			/* return response; */
		}
		// from date cannot be after to date
		if (from_date != null && to_date != null && from_date.after(to_date)) {
			errorCode = ScheduleConstants.UPCOMING_APPOINTMENTS_TODATE_BEFORE_FROMDATE_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
					errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);

			response.addError(errorInfo);
			/* return response; */
		}
		// from date cannot be before today
		if (from_date != null && from_date.before(today)) {
			errorCode = ScheduleConstants.UPCOMING_APPOINTMENTS_FROMDATE_BEFORE_CURRENTDATE_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
					errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);

			response.addError(errorInfo);
			/* return response; */
		}

		// finally check if the response does not have any errors
		// this is possible if all validations passed
		// in this case, a positive error info object should be added to
		// response
		if (!response.hasErrors()) {
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			response.addError(errorInfo);
		}

		return response;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * portalrefimpl.schedule.upcomingappointments.svc.UpcomingAppointmentsSvc
	 * #getUpcomingAppointmentDetails
	 * (portalrefimpl.schedule.upcomingappointments
	 * .request.UpcomingAppointmentsRequest)
	 * 
	 * main service impl method to return UpcomingAppointmentsResponse by
	 * calling the business component
	 */
	@Override
	public UpcomingAppointmentsResponse getUpcomingAppointmentDetails(
			UpcomingAppointmentsRequest upcomingAppointmentsRequest) {
		// initialize the response object
		UpcomingAppointmentsResponse upcomingAppointmentsResponse = new UpcomingAppointmentsResponse();

		// first step - validate the request
		// if validation fails return the response
		upcomingAppointmentsResponse = (UpcomingAppointmentsResponse) isValidRequest(upcomingAppointmentsRequest);
		// check if the response is successful after validation
		// if not, return the response
		if(!upcomingAppointmentsResponse.isSuccessful()){
			return upcomingAppointmentsResponse;
		}
		/*
		 * ErrorInfo errorInfo = upcomingAppointmentsResponse.getErrorInfo(); if
		 * (ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()) { return
		 * upcomingAppointmentsResponse; }
		 */

		// proceed to second step only after validation succeeds
		// second step - get the test result
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"app-beans.xml");
		UpcomingAppointmentsBC bcInst = (UpcomingAppointmentsBC) context
				.getBean("refUpcomingAppointmentsBC");
		upcomingAppointmentsResponse = bcInst
				.getUpcomingAppointmentDetails(upcomingAppointmentsRequest);

		return upcomingAppointmentsResponse;

	}

	/**
	 * this is the main method of the web service - called
	 * when the HTTP URL of the web service is invoked
	 */
	public Source invoke(Source request) {

		StreamSource reply = null;
		String xmlFileContent = "";

		UpcomingAppointmentsResponse upcomingAppointmentsResponse = null;
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String) mc.get(MessageContext.QUERY_STRING);
			Map<String, String> parameterMap = getRequestParameterMap(path);
			UpcomingAppointmentsRequest upcomingAppointmentsRequest = getUpcomingAppointmentsRequest(parameterMap);
			upcomingAppointmentsResponse = getUpcomingAppointmentDetails(upcomingAppointmentsRequest);
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
							new Object[] { CommonConstants.UPCOMING_APPOINTMENTS_SVC_NAME_KEY });
			
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			xmlFileContent = populateXMLForErrorResponse(errorMessage,
					errorCode);
			/*upcomingAppointmentsResponse.setErrorInfo(errorInfo);*/
			// xmlFileContent =
			// JaxbHelper.marshallObject(upcomingAppointmentsResponse);
			/*
			 * StringBuffer xmlContentBuff = new StringBuffer();
			 * xmlContentBuff.append
			 * ("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
			 * xmlContentBuff.append("<" +
			 * ScheduleConstants.UPCOMINGAPPOINTMENTS_ROOT_XML_TAG + ">");
			 * createErrorResponse(errorMessage, errorCode, xmlContentBuff);
			 * xmlContentBuff.append("</" +
			 * ScheduleConstants.UPCOMINGAPPOINTMENTS_ROOT_XML_TAG + ">");
			 * xmlFileContent = xmlContentBuff.toString();
			 */
		}

		/*xmlFileContent = getResponseXMLString(upcomingAppointmentsResponse);
		// form the reply object and return it
		reply = new StreamSource(new StringReader(xmlFileContent));*/
		
		reply = getServiceResponseAsStreamSource(upcomingAppointmentsResponse,
				CommonConstants.UPCOMING_APPOINTMENTS_SVC_NAME_KEY);
		
		return reply;

	}

	/**
	 * This method creates the upcoming appointments result request object
	 * 
	 * @param parameterMap
	 * @return
	 */
	private UpcomingAppointmentsRequest getUpcomingAppointmentsRequest(
			Map<String, String> parameterMap) {
		UpcomingAppointmentsRequest upcomingAppointmentsRequest = new UpcomingAppointmentsRequest();
		// set the portal user name to the request first
		upcomingAppointmentsRequest
				.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
		// next patient id
		if (parameterMap
				.containsKey(PortalConstants.PATIENTID_REQUEST_PARAM_KEY)) {
			String patientId = parameterMap
					.get(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
			upcomingAppointmentsRequest.setPatientId(patientId);
		}

		// next facility id
		if (parameterMap
				.containsKey(ScheduleConstants.UPCOMINGAPPOINTMENTS_FACILITYID_REQUEST_PARAM_KEY)) {
			String facilityId = parameterMap
					.get(ScheduleConstants.UPCOMINGAPPOINTMENTS_FACILITYID_REQUEST_PARAM_KEY);
			upcomingAppointmentsRequest.setFacilityId(facilityId);
		}

		// next start record num
		if (parameterMap
				.containsKey(ScheduleConstants.UPCOMINGAPPOINTMENTS_STARTRECORDNUM_REQUEST_PARAM_KEY)) {
			String startRecordNum = parameterMap
					.get(ScheduleConstants.UPCOMINGAPPOINTMENTS_STARTRECORDNUM_REQUEST_PARAM_KEY);
			try {
				upcomingAppointmentsRequest.setStartRecordNum(Integer
						.parseInt(startRecordNum));
			} catch (NumberFormatException e) {
				upcomingAppointmentsRequest.setStartRecordNum(0);
			}
		}

		// next end record num
		if (parameterMap
				.containsKey(ScheduleConstants.UPCOMINGAPPOINTMENTS_ENDRECORDNUM_REQUEST_PARAM_KEY)) {
			String endRecordNum = parameterMap
					.get(ScheduleConstants.UPCOMINGAPPOINTMENTS_ENDRECORDNUM_REQUEST_PARAM_KEY);
			try {
				upcomingAppointmentsRequest.setEndRecordNum(Integer
						.parseInt(endRecordNum));
			} catch (NumberFormatException e) {
				upcomingAppointmentsRequest.setStartRecordNum(0);
			}
		}

		// next from date
		if (parameterMap
				.containsKey(ScheduleConstants.UPCOMINGAPPOINTMENTS_FROMDATE_REQUEST_PARAM_KEY)) {
			String fromDate = parameterMap
					.get(ScheduleConstants.UPCOMINGAPPOINTMENTS_FROMDATE_REQUEST_PARAM_KEY);
			upcomingAppointmentsRequest.setFromDate(fromDate);
		}

		// next to date
		if (parameterMap
				.containsKey(ScheduleConstants.UPCOMINGAPPOINTMENTS_TODATE_REQUEST_PARAM_KEY)) {
			String toDate = parameterMap
					.get(ScheduleConstants.UPCOMINGAPPOINTMENTS_TODATE_REQUEST_PARAM_KEY);
			upcomingAppointmentsRequest.setToDate(toDate);
		}

		return upcomingAppointmentsRequest;
	}

}
