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
package portalrefimpl.schedule.rescheduleappointment.svc.impl;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;

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
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.rescheduleappointment.RescheduleRequestConstants;
import portalrefimpl.schedule.rescheduleappointment.bc.RescheduleAppointmentBC;
import portalrefimpl.schedule.rescheduleappointment.request.RescheduleAppointmentRequest;
import portalrefimpl.schedule.rescheduleappointment.response.RescheduleAppointmentResponse;
import portalrefimpl.schedule.rescheduleappointment.svc.RescheduleAppointmentSvc;

/**
 * This is the service implementation class for reschedule appointment service.
 * This class extends BaseServiceImpl and implements RescheduleAppointmentSvc
 * and Provider interfaces.
 * @author GRamamoorthy
 *
 */
@WebServiceProvider
public class RescheduleAppointmentSvcImpl extends BaseServiceImpl implements
		RescheduleAppointmentSvc, Provider<Source> {

	/**
	 * This method registers the HTTP URL for this service
	 * with the end point 
	 */
	public void registerService(BaseRequest request) {
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String webServiceUrl = PortalHelper
				.getWebServiceURL(PortalConstants.RESCHEDULE_APPT_REQ_WS_URL_KEY);
		e.publish(webServiceUrl);
	}

	/**
	 * This method validates the request for this service
	 */
	public BaseResponse isValidRequest(BaseRequest request) {
		ValidationRequest validationRequest = new ValidationRequest();
		validationRequest.setPortalUserName(request.getPortalUserName());
		ValidationResponse validationResponse = isValidRequestor(validationRequest);
		
		RescheduleAppointmentResponse response = new RescheduleAppointmentResponse();
		// if basic validation has failed, then set these errors to response
		if (!validationResponse.isSuccessful()) {
			response.addAllErrors(validationResponse.getErrors());
		}
		
		// safely cast - no problem
		RescheduleAppointmentRequest rescheduleApptReqRequest = (RescheduleAppointmentRequest) request;
		validateRequest(rescheduleApptReqRequest, response);
		
		return response;
	}

	/**
	 * This is the main method in this service implementation
	 * This method is invoked when the HTTP URL for this service
	 * is accessed.
	 * This method in turns calls the business method rescheduleAppointment()
	 * to perform the business operation
	 */
	public Source invoke(Source arg0) {
		StreamSource reply = null;
		// initialize the response object
		RescheduleAppointmentResponse response = null;
		
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String) mc.get(MessageContext.QUERY_STRING);
			Map<String, String> parameterMap = getRequestParameterMap(path);
			RescheduleAppointmentRequest request = getRequest(parameterMap);
			response = rescheduleAppointmentRequest(request);
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
							new Object[] { CommonConstants.RESCHEDULE_APPTREQUEST_SVC_NAME_KEY });
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response = new RescheduleAppointmentResponse();
			response.addError(errorInfo);
		}
		
		reply = getServiceResponseAsStreamSource(response,
				CommonConstants.RESCHEDULE_APPTREQUEST_SVC_NAME_KEY);
		
		return reply;
	}

	/**
	 * This is the main business method in this class
	 * performs the reschedule of appointment
	 */
	public RescheduleAppointmentResponse rescheduleAppointmentRequest(
			RescheduleAppointmentRequest request) {
		RescheduleAppointmentResponse response = new RescheduleAppointmentResponse();
		// first validate the request
		response = (RescheduleAppointmentResponse)isValidRequest(request);
		if(!response.isSuccessful()){
			return response;
		}
		
		// next get the data through the BC class 
		ApplicationContext context = new ClassPathXmlApplicationContext("app-beans.xml");
		RescheduleAppointmentBC bcInst = (RescheduleAppointmentBC)context.getBean("refRescheduleApptReqBC");
		return bcInst.rescheduleAppointmentRequest(request);
	}
	
	/**
	 * This method validates the request object
	 * @param request
	 * @return
	 */
	private void validateRequest(
			RescheduleAppointmentRequest request,
			RescheduleAppointmentResponse response) {
		// validate the following parameters in the request object
		// patient id, facility id, reference number, preferred date
		// preferred from time, preferred to time, practitioner id
		// location code, modified facility id
		
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		String patientId = request.getPatientId();
		if(patientId == null || patientId.trim().equals("")){
			errorCode = RescheduleRequestConstants.APPTREQ_PATIENTID_INVALID_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
					errorCode);
			response.addError(errorCode, errorMessage);
		}
		
		String facilityId = request.getFacilityId();
		if(facilityId == null || facilityId.trim().equals("")){
			errorCode = RescheduleRequestConstants.APPTREQ_FACILITYID_INVALID_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
					errorCode);
			response.addError(errorCode, errorMessage);
		}
		
		String refNumber = request.getAppointmentReferenceNumber();
		if(refNumber == null || refNumber.trim().equals("")){
			errorCode = RescheduleRequestConstants.APPTREQ_REF_NUMBER_INVALID_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
					errorCode);
			response.addError(errorCode, errorMessage);
		}
		
		// used for validating preferred date
		Date currentDate = new Date();
		Calendar preferredDateCal = Calendar.getInstance();
		// preferred date
		String preferredDate = request.getPreferredDate();
		if(preferredDate == null || preferredDate.trim().equals("")){
			errorCode = RescheduleRequestConstants.APPTREQ_PREFERRED_DATE_INVALID_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
					errorCode);
			response.addError(errorCode, errorMessage);	
		}else{
			// check the format of the date - it should be dd/MM/yyyy
			Date preferredDateObj = PortalHelper
					.getDateFromString(
							preferredDate,
							RescheduleRequestConstants.APPTREQ_DETAILS_DATE_DISPLAY_FORMAT);
			if(preferredDateObj == null){
				errorCode = RescheduleRequestConstants.APPTREQ_PREFERRED_DATE_INVALID_FORMAT_ERRORCODE;
				errorMessage = MessageContainer.getInstance().getDisplayMessage(
						CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
						errorCode);
				errorMessage = MessageFormat
						.format(errorMessage,
								new Object[] { 
								RescheduleRequestConstants.APPTREQ_DETAILS_DATE_DISPLAY_FORMAT });
				response.addError(errorCode, errorMessage);	
			}else{
				// checking for past date
				if(preferredDateObj.before(currentDate)){
					errorCode = RescheduleRequestConstants.APPTREQ_PREFERRED_DATE_PAST_DATE_ERRORCODE;
					errorMessage = MessageContainer.getInstance().getDisplayMessage(
							CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME, errorCode);
					response.addError(errorCode,errorMessage);
				}
				
				// validate if the preferred date is after the configured date range
				String preferredDateRangeStr = PortalHelper
						.getConfigPropertyValue(CreateAppointmentConstants.BOOKAPPT_PREFERREDDATE_RANGE_KEY);
				int preferredDateRange = PortalHelper
						.getIntegerValue(
								preferredDateRangeStr,
								CreateAppointmentConstants.BOOKAPPT_PREFERREDDATE_DEFAULT_RANGE);
				
				preferredDateCal.setTime(currentDate);
				preferredDateCal.add(Calendar.DATE, preferredDateRange);
				
				if(preferredDateObj.after(preferredDateCal.getTime())){
					errorCode = RescheduleRequestConstants.APPTREQ_PREFERRED_DATE_RANGE_EXCEED_ERRORCODE;
					errorMessage = MessageContainer.getInstance()
							.getDisplayMessage(
									CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
									errorCode);
					errorMessage = MessageFormat.format(errorMessage,
							new Object[] { new Integer(preferredDateRange) });
					response.addError(errorCode,errorMessage);
				}
			}
		}
		
		// preferred from time
		String preferredFromTime = request.getPreferredFromTime();
		if(preferredFromTime == null || preferredFromTime.trim().equals("")){
			errorCode = RescheduleRequestConstants.APPTREQ_PREFERRED_FROMTIME_INVALID_ERRORCODE;
			errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
							errorCode);
			response.addError(errorCode,errorMessage);
		}else{
			// check for its format
			boolean isValidFormat = isTimeInCorrectFormat(preferredFromTime);
			if(!isValidFormat){
				errorCode = RescheduleRequestConstants.APPTREQ_PREFERRED_FROMTIME_INVALID_FORMAT_ERRORCODE;
				errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(
								CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
								errorCode);
				errorMessage = MessageFormat
						.format(errorMessage,
								new Object[] { RescheduleRequestConstants.APPTREQ_DETAILS_TIME_FORMAT });
				response.addError(errorCode,errorMessage);
			}
		}
		
		// preferred to time
		String preferredToTime = request.getPreferredToTime();
		if(preferredToTime == null || preferredToTime.trim().equals("")){
			errorCode = RescheduleRequestConstants.APPTREQ_PREFERRED_TOTIME_INVALID_ERRORCODE;
			errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
							errorCode);
			response.addError(errorCode,errorMessage);
		}else{
			// check for its format
			boolean isValidFormat = isTimeInCorrectFormat(preferredToTime);
			if (!isValidFormat) {
				errorCode = RescheduleRequestConstants.APPTREQ_PREFERRED_TOTIME_INVALID_FORMAT_ERRORCODE;
				errorMessage = MessageContainer
						.getInstance()
						.getDisplayMessage(
								CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
								errorCode);
				errorMessage = MessageFormat
						.format(errorMessage,
								new Object[] { RescheduleRequestConstants.APPTREQ_DETAILS_TIME_FORMAT });
				response.addError(errorCode, errorMessage);
			}
			
			// now check if the preferred from time is greater than preferred to time
			if(preferredFromTime != null && !preferredFromTime.trim().equals("")){
				int fromHrs = getHours(preferredFromTime);
				int toHrs = getHours(preferredToTime);
				if(fromHrs > toHrs){
					errorCode = RescheduleRequestConstants.APPTREQ_FROMTIME_EXCEEDS_TOTIME_ERRORCODE;
					errorMessage = MessageContainer
							.getInstance()
							.getDisplayMessage(
									CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
									errorCode);
					response.addError(errorCode, errorMessage);
				}else if(fromHrs == toHrs){
					int fromMinutes = getMinutes(preferredFromTime);
					int toMinutes = getMinutes(preferredToTime);
					if(fromMinutes >= toMinutes){
						errorCode = RescheduleRequestConstants.APPTREQ_FROMTIME_EXCEEDS_TOTIME_ERRORCODE;
						errorMessage = MessageContainer
								.getInstance()
								.getDisplayMessage(
										CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
										errorCode);
						response.addError(errorCode, errorMessage);
					}
				}
			}
		}
		
		//practitioner id
		String practitionerId = request.getPractitionerId();
		if(practitionerId == null || practitionerId.trim().equals("")){
			errorCode = RescheduleRequestConstants.APPTREQ_PRACTITIONERID_INVALID_ERRORCODE;
			errorMessage = MessageContainer
					.getInstance()
					.getDisplayMessage(
							CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
							errorCode);
			response.addError(errorCode, errorMessage);
		}
		
		// location code
		String locationCode = request.getLocationCode();
		if(locationCode == null || locationCode.trim().equals("")){
			errorCode = RescheduleRequestConstants.APPTREQ_LOCATIONCODE_INVALID_ERRORCODE;
			errorMessage = MessageContainer
					.getInstance()
					.getDisplayMessage(
							CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
							errorCode);
			response.addError(errorCode, errorMessage);
		}
		
		// modified facility id
		String modifiedFacilityId = request.getModifiedFacilityId();
		if(modifiedFacilityId == null || modifiedFacilityId.trim().equals("")){
			errorCode = RescheduleRequestConstants.APPTREQ_MODIFIED_FACILITYID_INVALID_ERRORCODE;
			errorMessage = MessageContainer
					.getInstance()
					.getDisplayMessage(
							CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
							errorCode);
			response.addError(errorCode, errorMessage);
		}
		
		// reason code
		String reasonCode = request.getModifyReasonCode();
		if(reasonCode == null || reasonCode.trim().equals("")){
			errorCode = RescheduleRequestConstants.APPTREQ_REASON_CODE_ERRORCODE;
			errorMessage = MessageContainer
					.getInstance()
					.getDisplayMessage(
							CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
							errorCode);
			response.addError(errorCode, errorMessage);
		}
		
		// finally if all validations have passed then add a positive error 
		if(!response.hasErrors()){
			response.addError(errorCode, errorMessage);
		}
		
	}
	
	/**
	 * This method checks if the given time value matches
	 * the time format - this method uses regular expression
	 * to validate 
	 * @param timeValue
	 * @param format
	 * @return
	 */
	private boolean isTimeInCorrectFormat(String timeValue){
		boolean isValid = false;
		/*Pattern patInst = Pattern.compile(RescheduleRequestConstants.APPTREQ_TIME_REGEX_PATTERN1);
		Matcher matcher = patInst.matcher(timeValue);
		isValid = matcher.matches();*/
		// check for the pattern which will validate hours from 00-19
		isValid = Pattern.matches(RescheduleRequestConstants.APPTREQ_TIME_REGEX_PATTERN1, timeValue);
		if(isValid){
			return isValid;
		}
		// check for pattern which will validate hours from 20-23
		isValid = Pattern.matches(RescheduleRequestConstants.APPTREQ_TIME_REGEX_PATTERN2, timeValue);
		
		return isValid;
	}
	
	/**
	 * This method gets the hours value from the input timeValue
	 * the format of the input is HH:mm
	 * @param timeValue
	 * @return
	 */
	private int getHours(String timeValue){
		int hrVal = 0;
		String hrsStr = null;
		int hrIndex = timeValue.indexOf(ScheduleConstants.TIME_DELIMITER);
		if(hrIndex > 0){
			hrsStr = timeValue.substring(0, hrIndex);
			hrVal = PortalHelper.getIntegerValue(hrsStr, 0);
		}
		
		return hrVal;
	}
	
	/**
	 * This method gets the minutes value from the input timeValue
	 * the format of the input is HH:mm
	 * @param timeValue
	 * @return
	 */
	private int getMinutes(String timeValue){
		int minutes = 0;
		String minStr = null;
		int minIndex = timeValue.indexOf(ScheduleConstants.TIME_DELIMITER);
		if(minIndex > 0){
			minStr = timeValue.substring(minIndex+1);
			minutes = PortalHelper.getIntegerValue(minStr, 0);
		}
		
		return minutes;
	}
	
	
	/**
	 * This method forms the request object by reading data from the input
	 * parameter map
	 * @param parameterMap
	 * @return
	 */
	private RescheduleAppointmentRequest getRequest(Map<String, String> parameterMap){
		RescheduleAppointmentRequest request = new RescheduleAppointmentRequest();
		// set the portal user name to the request first - mandatory field
		if (parameterMap
				.containsKey(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY)) {
			String portalKeyValue = parameterMap
					.get(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY);
			request.setPortalUserName(portalKeyValue);
		}

		// next patient id - mandatory field
		if (parameterMap
				.containsKey(PortalConstants.PATIENTID_REQUEST_PARAM_KEY)) {
			String patientId = parameterMap
					.get(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
			request.setPatientId(patientId);
		}
		
		// language is optional 
		if (parameterMap.containsKey(CommonConstants.LANGUAGE_WS_PARAMETER_KEY)) {
			String language = parameterMap
					.get(CommonConstants.LANGUAGE_WS_PARAMETER_KEY);
			request.setLocale(language);
		}
		
		// facility id - mandatory field
		if(parameterMap.containsKey(RescheduleRequestConstants.APPTREQ_FACILITYID_PARAM_KEY)){
			String facilityId = parameterMap
					.get(RescheduleRequestConstants.APPTREQ_FACILITYID_PARAM_KEY);
			request.setFacilityId(facilityId);
		}
		
		// reference number - mandatory field
		if(parameterMap.containsKey(RescheduleRequestConstants.APPTREQ_REF_NUMBER_PARAM_KEY)){
			String refNumber = parameterMap
					.get(RescheduleRequestConstants.APPTREQ_REF_NUMBER_PARAM_KEY);
			request.setAppointmentReferenceNumber(refNumber);
		}
		
		// preferred date - mandatory field
		String preferredDate = null;
		if(parameterMap.containsKey(RescheduleRequestConstants.APPTREQ_PREFERRED_DATE_PARAM_KEY)){
			preferredDate = parameterMap
					.get(RescheduleRequestConstants.APPTREQ_PREFERRED_DATE_PARAM_KEY);
			request.setPreferredDate(preferredDate);
		}
		
		// preferred from time - mandatory field
		if(parameterMap.containsKey(RescheduleRequestConstants.APPTREQ_PREFERRED_FROMTIME_PARAM_KEY)){
			String preferredFromTime = parameterMap
					.get(RescheduleRequestConstants.APPTREQ_PREFERRED_FROMTIME_PARAM_KEY);
			/*if(preferredDate != null && !preferredDate.trim().equals("")){
				preferredFromTime = preferredDate + " " + preferredFromTime;
			}*/
			request.setPreferredFromTime(preferredFromTime);
		}
		
		// preferred to time - mandatory field
		if(parameterMap.containsKey(RescheduleRequestConstants.APPTREQ_PREFERRED_TOTIME_PARAM_KEY)){
			String preferredToTime = parameterMap
					.get(RescheduleRequestConstants.APPTREQ_PREFERRED_TOTIME_PARAM_KEY);
			/*if(preferredDate != null && !preferredDate.trim().equals("")){
				preferredToTime = preferredDate + " " + preferredToTime;
			}*/
			request.setPreferredToTime(preferredToTime);
		}
		
		// practitioner id - mandatory field
		if(parameterMap.containsKey(RescheduleRequestConstants.APPTREQ_PRACTITIONERID_PARAM_KEY)){
			String practitionerId = parameterMap
					.get(RescheduleRequestConstants.APPTREQ_PRACTITIONERID_PARAM_KEY);
			request.setPractitionerId(practitionerId);
		}
		
		// location code - mandatory field
		if(parameterMap.containsKey(RescheduleRequestConstants.APPTREQ_LOCATIONCODE_PARAM_KEY)){
			String locationCode = parameterMap
					.get(RescheduleRequestConstants.APPTREQ_LOCATIONCODE_PARAM_KEY);
			request.setLocationCode(locationCode);
		}

		// modified facility id - mandatory field
		if(parameterMap.containsKey(RescheduleRequestConstants.APPTREQ_MODIFIED_FACILITYID_PARAM_KEY)){
			String modifiedFacilityId = parameterMap
					.get(RescheduleRequestConstants.APPTREQ_MODIFIED_FACILITYID_PARAM_KEY);
			request.setModifiedFacilityId(modifiedFacilityId);
		}

		// care location indicator - this is optional
		String careLocationInd = CreateAppointmentConstants.APPOINTMENT_CARE_LOCATION_TYPE_INDICATOR_VALUE;
		if(parameterMap.containsKey(RescheduleRequestConstants.APPTREQ_CARELOCATIONINDICATOR_PARAM_KEY)){
			careLocationInd = parameterMap
					.get(RescheduleRequestConstants.APPTREQ_CARELOCATIONINDICATOR_PARAM_KEY);
		}
		request.setCareLocationTypeIndicator(careLocationInd);
		
		// reason code
		if(parameterMap.containsKey(RescheduleRequestConstants.RESCHEDULE_REASON_CODE_PARAM)){
			String reasonCode = parameterMap
					.get(RescheduleRequestConstants.RESCHEDULE_REASON_CODE_PARAM);
			request.setModifyReasonCode(reasonCode);
		}
		
		return request;
	}

}
