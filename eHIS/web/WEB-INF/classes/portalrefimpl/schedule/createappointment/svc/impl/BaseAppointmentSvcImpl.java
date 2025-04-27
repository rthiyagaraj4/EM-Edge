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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.common.svc.BaseServiceImpl;
import portalrefimpl.schedule.common.request.AppointmentRequest;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.createappointment.appointmentrequest.ResponseContainer;
import portalrefimpl.schedule.createappointment.appointmentrequest.ResponseContainerImpl;
import portalrefimpl.schedule.createappointment.response.AppointmentResponse;

/**
 * This class is the base class for appointment related transactions
 * 
 * @author GRamamoorthy
 *
 */
public abstract class BaseAppointmentSvcImpl extends BaseServiceImpl {

	/**
	 * This method validates the appointment request and returns
	 * an AppointmentResponse object which will contain either
	 * success or failure code
	 * @param request
	 * @return
	 */
	protected AppointmentResponse validateAppointmentRequest(
			AppointmentRequest request) {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		/*ErrorInfo errorInfo = new ErrorInfo();
		appointmentResponse.setErrorInfo(errorInfo);*/
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		// validate facility id, speciality id, preferred date,
		// preferred from time, preferred to time, practitioner id,
		// validate facility id first
		String facilityId = request.getFacilityId();
		if(facilityId == null || facilityId.trim().equals("")){
			errorCode = CreateAppointmentConstants.APPOINTMENT_INVALID_FACILITYID_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			appointmentResponse.addError(errorInfo);
			/*return appointmentResponse;*/
		}
		// validate speciality id
		String specialityId = request.getSpecialityId();
		if(specialityId == null || specialityId.trim().equals("")){
			errorCode = CreateAppointmentConstants.APPOINTMENT_INVALID_SPECIALITYID_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			appointmentResponse.addError(errorInfo);
			/*return appointmentResponse;*/
		}
		// validate practitioner id
		String practitionerId = request.getPractitionerId();
		if(practitionerId == null || practitionerId.trim().equals("")){
			errorCode = CreateAppointmentConstants.APPOINTMENT_INVALID_PRACTITIONERID_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			appointmentResponse.addError(errorInfo);
			/*return appointmentResponse;*/
		}
		
		// validate preferred date for value and its format
		String preferredDate = request.getPreferredDate();

		final String dateFormat = "dd/MM/yyyy";
		Date currentDate = new Date();
		Date preferredDateVal = null;
		Calendar preferredDateCal = Calendar.getInstance();
		// validate the preferred date's given value
		if(preferredDate != null && !preferredDate.trim().equals("")){
			if(!validatePreferredDate(preferredDate, dateFormat)){
				errorCode = CreateAppointmentConstants.APPOINTMENT_INVALID_PREFERREDDATE_ERRORCODE;
				errorMessage = MessageContainer.getInstance().getDisplayMessage(
						CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				appointmentResponse.addError(errorInfo);
				/*return appointmentResponse;*/
			}
			
			preferredDateVal = PortalHelper.getDateFromString(preferredDate,
					dateFormat);
			if(preferredDateVal == null){
				errorCode = CreateAppointmentConstants.APPOINTMENT_INVALID_PREFERREDDATE_ERRORCODE;
				errorMessage = MessageContainer.getInstance().getDisplayMessage(
						CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				appointmentResponse.addError(errorInfo);
				/*return appointmentResponse;*/
			}else{
				if(preferredDateVal.before(currentDate)){
					errorCode = CreateAppointmentConstants.APPOINTMENT_PAST_PREFERREDDATE_ERRORCODE;
					errorMessage = MessageContainer.getInstance().getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
					errorInfo = new ErrorInfo();
					errorInfo.setErrorCode(errorCode);
					errorInfo.setErrorMessage(errorMessage);
					appointmentResponse.addError(errorInfo);
					/*return appointmentResponse;*/
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
				
				if(preferredDateVal.after(preferredDateCal.getTime())){
					errorCode = CreateAppointmentConstants.APPOINTMENT_PREFERREDDATE_EXCEED_RANGE_ERRORCODE;
					errorMessage = MessageContainer.getInstance()
							.getDisplayMessage(
									CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
									errorCode);
					errorInfo = new ErrorInfo();
					errorInfo.setErrorCode(errorCode);
					errorInfo.setErrorMessage(errorMessage);
					appointmentResponse.addError(errorInfo);
					/*return appointmentResponse;*/
				}
			}
			
			
		}else{
			// indicates preferred date is null
			errorCode = CreateAppointmentConstants.APPOINTMENT_INVALID_PREFERREDDATE_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			appointmentResponse.addError(errorInfo);
			/*return appointmentResponse;*/
		}
		
		final String DATETIME_FORMAT = "dd/MM/yyyy HH:mm";
		// validate preferred from time
		String preferredFromTime = request.getPreferredFromTime();
		Date preferredFromTimeVal = null;
		if(preferredFromTime != null && preferredFromTime.trim().equals("")){
			if(!validatePreferredDate(preferredFromTime, dateFormat)){
				errorCode = CreateAppointmentConstants.APPOINTMENT_INVALID_PREFERREDFROMTIME_ERRORCODE;
				errorMessage = MessageContainer.getInstance().getDisplayMessage(
						CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				return appointmentResponse;
			}
			preferredFromTimeVal = PortalHelper.getDateFromString(
					preferredFromTime, DATETIME_FORMAT);
			if(preferredFromTimeVal == null){
				errorCode = CreateAppointmentConstants.APPOINTMENT_INVALID_PREFERREDFROMTIME_ERRORCODE;
				errorMessage = MessageContainer.getInstance().getDisplayMessage(
						CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				return appointmentResponse;
			}
			
			if(preferredFromTimeVal.before(currentDate)){
				errorCode = CreateAppointmentConstants.APPOINTMENT_INVALID_PREFERREDFROMTIME_ERRORCODE;
				errorMessage = MessageContainer.getInstance().getDisplayMessage(
						CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				return appointmentResponse;
			}
			
			if(preferredFromTimeVal.after(preferredDateCal.getTime())){
				errorCode = CreateAppointmentConstants.APPOINTMENT_PREFERREDFROMTIME_EXCEED_RANGE_ERRORCODE;
				errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(
								CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
								errorCode);
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				return appointmentResponse;
			}
		}else{
			// indicates preferred from time is null or empty
			errorCode = CreateAppointmentConstants.APPOINTMENT_INVALID_PREFERREDFROMTIME_ERRORCODE;
			errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			appointmentResponse.addError(errorInfo);
			/*return appointmentResponse;*/
		}
		
		// validate the preferred to time
		String preferredToTime = request.getPreferredToTime();
		Date preferredToTimeVal = null;
		if(preferredToTime != null && !preferredToTime.trim().equals("")){
			if(!validatePreferredDate(preferredToTime, dateFormat)){
				errorCode = CreateAppointmentConstants.APPOINTMENT_INVALID_PREFERREDTOTIME_ERRORCODE;
				errorMessage = MessageContainer.getInstance().getDisplayMessage(
						CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				appointmentResponse.addError(errorInfo);
				/*return appointmentResponse;*/
			}
			preferredToTimeVal = PortalHelper.getDateFromString(
					preferredToTime, DATETIME_FORMAT);
			if(preferredToTimeVal == null){
				errorCode = CreateAppointmentConstants.APPOINTMENT_INVALID_PREFERREDTOTIME_ERRORCODE;
				errorMessage = MessageContainer.getInstance().getDisplayMessage(
						CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				appointmentResponse.addError(errorInfo);
				/*return appointmentResponse;*/
			}
			
			if(preferredToTimeVal.before(currentDate)){
				errorCode = CreateAppointmentConstants.APPOINTMENT_PAST_PREFERREDTOTIME_ERRORCODE;
				errorMessage = MessageContainer.getInstance().getDisplayMessage(
						CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				appointmentResponse.addError(errorInfo);
				/*return appointmentResponse;*/
			}
			
			if(preferredToTimeVal.after(preferredDateCal.getTime())){
				errorCode = CreateAppointmentConstants.APPOINTMENT_PREFERREDTOTIME_EXCEED_RANGE_ERRORCODE;
				errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(
								CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
								errorCode);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				appointmentResponse.addError(errorInfo);
				/*return appointmentResponse;*/
			}
		}else{
			errorCode = CreateAppointmentConstants.APPOINTMENT_INVALID_PREFERREDTOTIME_ERRORCODE;
			errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			appointmentResponse.addError(errorInfo);
			/*return appointmentResponse;*/
		}
		
		// now check if the preferred from time is later than preferred to time
		if (preferredFromTimeVal != null && preferredToTimeVal != null
				&& preferredFromTimeVal.after(preferredToTimeVal)) {
			errorCode = CreateAppointmentConstants.APPOINTMENT_FROMTIME_LATERTHAN_TOTIME_ERRORCODE;
			errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			appointmentResponse.addError(errorInfo);
		}
		
		// finally set the error code and error message to error info object
		// this is for success case
		if(!appointmentResponse.hasErrors()){
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			appointmentResponse.addError(errorInfo);
		}
		
		return appointmentResponse;
	}
	
	/**
	 * This method validates the preferred date
	 * @param preferredDate
	 * @param format 
	 * @return
	 */
	private boolean validatePreferredDate(String preferredDate, String format){
		boolean isValid = false;
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
		Date dateVal = null;
		try {
			dateVal = dateFormat.parse(preferredDate);
			isValid = true;
		} catch (ParseException e) {
			isValid = false;
		}
		/*final String DELIMITER = "/";
		int dateIndex = preferredDate.indexOf(DELIMITER);
		if(dateIndex <=0){
			return isValid;
		}
		String dateStr = preferredDate.substring(0, dateIndex);
		int dateVal = PortalHelper.getIntegerValue(dateStr, 0);
		if(dateVal <= 0 || dateVal > 31){
			return isValid;
		}
		
		int monthIndex = preferredDate.indexOf(DELIMITER, dateIndex+1);
		if(monthIndex <= 0){
			return isValid;
		}
		String monthStr = preferredDate.substring(dateIndex+1, monthIndex);
		int monthVal = PortalHelper.getIntegerValue(monthStr, 0);
		if(monthVal <= 0){
			return isValid;
		}
		
		String yearStr = preferredDate.substring(monthIndex+1);
		int yearVal = PortalHelper.getIntegerValue(yearStr, 0);
		if(yearVal <= 0){
			return isValid;
		}
		
		if(monthVal == 2){
			GregorianCalendar gregCal = new GregorianCalendar();
			boolean isLeap = gregCal.isLeapYear(yearVal);
			if(isLeap){
				if(dateVal > 29){
					return isValid;
				}
			}else{
				if(dateVal > 28){
					return isValid;
				}
			}
		}*/
		
		
		
		return isValid;
	}
	
	/**
	 * This method populates the common properties for an appointment
	 * service with data obtained from the parameter map
	 * @param parameterMap
	 * @param appointmentRequest
	 */
	protected void populateAppointmentRequest(Map<String, String> parameterMap,
			AppointmentRequest appointmentRequest) {
		// set the portal user name to the request first
		appointmentRequest
				.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
		// next patient id
		if(parameterMap.containsKey(PortalConstants.PATIENTID_REQUEST_PARAM_KEY)){
			String patientId = parameterMap
					.get(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
			appointmentRequest.setPatientId(patientId);
		}
		
		// language id
		String language = Locale.getDefault().getLanguage();
		if(parameterMap.containsKey(CommonConstants.LANGUAGE_WS_PARAMETER_KEY)){
			language = parameterMap.get(CommonConstants.LANGUAGE_WS_PARAMETER_KEY);
		}
		appointmentRequest.setLocale(language);
		// facility id
		if(parameterMap.containsKey(CreateAppointmentConstants.APPOINTMENT_FACILITYID_REQUEST_PARAM)){
			String facilityId = parameterMap
					.get(CreateAppointmentConstants.APPOINTMENT_FACILITYID_REQUEST_PARAM);
			appointmentRequest.setFacilityId(facilityId);
		}
		// specialty id
		if(parameterMap.containsKey(CreateAppointmentConstants.APPOINTMENT_SPECIALITYID_REQUEST_PARAM)){
			String specialtyId = parameterMap
					.get(CreateAppointmentConstants.APPOINTMENT_SPECIALITYID_REQUEST_PARAM);
			appointmentRequest.setSpecialityId(specialtyId);
		}
		// practitioner id
		if(parameterMap.containsKey(CreateAppointmentConstants.APPOINTMENT_PRACTITIONERID_REQUEST_PARAM)){
			String practitionerId = parameterMap
					.get(CreateAppointmentConstants.APPOINTMENT_PRACTITIONERID_REQUEST_PARAM);
			appointmentRequest.setPractitionerId(practitionerId);
		}
		// location code
		if(parameterMap.containsKey(CreateAppointmentConstants.APPOINTMENT_LOCATION_CODE_REQUEST_PARAM)){
			String locationCode = parameterMap
					.get(CreateAppointmentConstants.APPOINTMENT_LOCATION_CODE_REQUEST_PARAM);
			appointmentRequest.setLocationCode(locationCode);
		}
		// preferred date
		String preferredDate = null;
		if(parameterMap.containsKey(CreateAppointmentConstants.APPOINTMENT_PREFERREDDATE_REQUEST_PARAM)){
			preferredDate = parameterMap
					.get(CreateAppointmentConstants.APPOINTMENT_PREFERREDDATE_REQUEST_PARAM);
			appointmentRequest.setPreferredDate(preferredDate);
		}
		// preferred from time
		if(parameterMap.containsKey(CreateAppointmentConstants.APPOINTMENT_PREFERREDFROMTIME_REQUEST_PARAM)){
			String preferredFromTime = parameterMap
					.get(CreateAppointmentConstants.APPOINTMENT_PREFERREDFROMTIME_REQUEST_PARAM);
			if(preferredDate != null && !preferredDate.trim().equals("")){
				preferredFromTime = preferredDate +" "+ preferredFromTime;
			}
			appointmentRequest.setPreferredFromTime(preferredFromTime);
		}
		// preferred to time
		if(parameterMap.containsKey(CreateAppointmentConstants.APPOINTMENT_PREFERREDTOTIME_REQUEST_PARAM)){
			String preferredToTime = parameterMap
					.get(CreateAppointmentConstants.APPOINTMENT_PREFERREDTOTIME_REQUEST_PARAM);
			if(preferredDate != null && !preferredDate.trim().equals("")){
				preferredToTime = preferredDate +" "+ preferredToTime;
			}
			appointmentRequest.setPreferredToTime(preferredToTime);
		}
		
		ResponseContainer container = new ResponseContainerImpl();
		appointmentRequest.setResponseContainer(container);
	}
	

}
