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
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.common.svc.BaseServiceImpl;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.createappointment.request.PractitionerRequest;

/**
 * This is the base service implementation class for the practitioner services
 * This class will be extended by practitioner list service and
 * practitioner schedule service
 * @author GRamamoorthy
 *
 */
public abstract class BasePractitionerSvcImpl extends BaseServiceImpl {

	/**
	 * This method validates the common parameters in the practitioner service
	 * This method validates the following parameters in the request
	 * 1. Facility Id 2. Specialty Id 3. Oper standard id
	 * 4. Resource class 5. Preferred start date 6. Preferred start time
	 * 7. Preferred end time
	 * @param request
	 * @param response
	 */
	protected void validatePractitionerRequest(BaseRequest request,BaseResponse response){
		// safely cast to practitioner request
		PractitionerRequest practRequest = (PractitionerRequest)request;

		/*ErrorInfo errorInfo = response.getErrorInfo();*/
		ErrorInfo errorInfo = null;
		// 1 validate the facility id
		String facilityId = practRequest.getFacilityId();
		if(facilityId == null || facilityId.trim().equals("")){
			int errorCode = CreateAppointmentConstants.PRACTITIONER_REQUEST_INVALIDFACILITY_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			response.addError(errorInfo);
			/*return;*/
		}
		// 2 validate the speciality code
		String specialityCode = practRequest.getSpecialityCode();
		if(specialityCode == null || specialityCode.trim().equals("")){
			int errorCode = CreateAppointmentConstants.PRACTITIONER_REQUEST_INVALIDSPECIALITY_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			/*return;*/
		}
		
		// 3 Opr stand id - this has to be "ALL"
		String oprStndId = practRequest.getOperationStandardId();
		if(!CreateAppointmentConstants.PRACTITIONER_SERVICE_OPRSTN_DEFAULT_VALUE.equalsIgnoreCase(oprStndId)){
			int errorCode = CreateAppointmentConstants.PRACTITIONER_REQUEST_INVALIDOPRSTNID_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			/*return;*/
		}
		
		// 4 resource class - this has to be non empty
		String resourceClass = practRequest.getResourceClass();
		if(resourceClass == null || resourceClass.trim().equals("")){
			int errorCode = CreateAppointmentConstants.PRACTITIONER_REQUEST_INVALIDOPRSTNID_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			/*return;*/
		}

		// instance of current date used for validation
		Date currentDate = new Date();
		Calendar preferredDateCal = Calendar.getInstance();
		
		// used for validation of range
		String preferredDateRangeStr = PortalHelper
				.getConfigPropertyValue(CreateAppointmentConstants.BOOKAPPT_PREFERREDDATE_RANGE_KEY);
		int preferredDateRange = PortalHelper
				.getIntegerValue(
						preferredDateRangeStr,
						CreateAppointmentConstants.BOOKAPPT_PREFERREDDATE_DEFAULT_RANGE);
		
		// 5 validate preferred start date
		// this needs the start time of the appointment too
		String preferredFromDateStr = practRequest.getPreferredFromDateAsString();
		String preferredStartTime = practRequest.getPreferredStartTime();
		String completeFromDate = preferredFromDateStr + " " + preferredStartTime;
		final String DATETIME_FORMAT = "dd/MM/yyyy HH:mm";
		// get the date object equivalent
		Date preferredFromDate = PortalHelper.getDateFromString(
				completeFromDate, DATETIME_FORMAT);
		// check if the date is not specified by the user at all
		// the date object will be null if user has not specified the preferred from date
		// or if the preferred from date is not valid
		if(preferredFromDate == null){
			int errorCode = CreateAppointmentConstants.PRACTITIONER_REQUEST_INVALIDPREFERREDDATE_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			/*return;*/
		}else{
			// validate for past date
			if(currentDate.after(preferredFromDate)) {
				int errorCode = CreateAppointmentConstants.PRACTITIONER_REQUEST_PASTPREFERREDDATE_ERRORCODE;
				String errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(
								CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
								errorCode);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				response.addError(errorInfo);
				/*return;*/
			}
			
			// validate if the preferred date is after the configured date range
			preferredDateCal.setTime(currentDate);
			preferredDateCal.add(Calendar.DATE, preferredDateRange);
			
			if(preferredFromDate.after(preferredDateCal.getTime())){
				int errorCode = CreateAppointmentConstants.PRACTITIONER_REQUEST_PREFERREDDATE_RANGE_OVERSHOOT_ERRORCODE;
				String errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(
								CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
								errorCode);
				errorMessage = MessageFormat.format(errorMessage,
						new Object[] { preferredDateRange + "" });
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				response.addError(errorInfo);
				/*return;*/
			}
		}
		
		// 6 validate preferred start time
		if(preferredStartTime == null || preferredStartTime.trim().equals("")){
			int errorCode = CreateAppointmentConstants.PRACTITIONER_REQUEST_INVALIDPREFERREDTSTARTTIME_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			/*return;*/
		}
		
		// validation of the preferred end time against the configured end times
		// is not needed now - it is commented - Date 06/06/2013
		/*AppointmentTimeRequest apptTimeRequest = new AppointmentTimeRequest(
				ScheduleConstants.BOOKAPPT_START_TIME_IDENTIFIER);
		AppointmentTimeResponse apptTimeResponse = ScheduleHelper
				.getAppointmentTimeResponse(apptTimeRequest);
		// check for invalid start appointment time
		if(!apptTimeResponse.containsAppointmentTime(preferredStartTime)){
			int errorCode = CreateAppointmentConstants.PRACTITIONER_REQUEST_INVALIDPREFERREDTSTARTTIME_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			return;
		}
		// get the index at which the start appointment time exists
		// and check if it is last - if so, it is an invalid time
		// the last time slot in the day should not be selected by user
		int startIndex = apptTimeResponse.getAppointmentTimeIndex(preferredStartTime);
		List<AppointmentTime> apptTimeList = apptTimeResponse.getAppointmentTimeList();
		if(apptTimeList.size() == (startIndex+1)){
			int errorCode = CreateAppointmentConstants.PRACTITIONER_REQUEST_INVALIDPREFERREDTSTARTTIME_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			return;
		}*/
		
		// 7 validate preferred end time
		// validate the time value for null or empty
		// also validate if the date time value is a past date
		// or exceeds range
		String preferredEndTime = practRequest.getPreferredEndTime();
		if(preferredEndTime == null || preferredEndTime.trim().equals("")){
			int errorCode = CreateAppointmentConstants.PRACTITIONER_REQUEST_INVALIDPREFERREDTENDTIME_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
		}else{
			String preferredEndDateStr = practRequest.getPreferredToDateAsString();
			String completeToDate = preferredEndDateStr + " " + preferredEndTime;
			
			// get the date object equivalent
			Date preferredToDate = PortalHelper.getDateFromString(
					completeToDate, DATETIME_FORMAT);
			// check if the date is not specified by the user at all
			// the date object will be null if user has not specified the preferred from date
			// or if the preferred from date is not valid
			if(preferredToDate == null){
				int errorCode = CreateAppointmentConstants.PRACTITIONER_REQUEST_INVALIDPREFERREDTENDTIME_ERRORCODE;
				String errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(
								CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
								errorCode);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				response.addError(errorInfo);
			}else{
				// validate for past date
				if(currentDate.after(preferredToDate)) {
					int errorCode = CreateAppointmentConstants.PRACTITIONER_REQUEST_PASTPREFERREDENDDATE_ERRORCODE;
					String errorMessage = MessageContainer.getInstance()
							.getDisplayMessage(
									CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
									errorCode);
					errorInfo = new ErrorInfo();
					errorInfo.setErrorCode(errorCode);
					errorInfo.setErrorMessage(errorMessage);
					response.addError(errorInfo);
					/*return;*/
				}
				
				if(preferredToDate.after(preferredDateCal.getTime())){
					int errorCode = CreateAppointmentConstants.PRACTITIONER_REQUEST_PREFERREDENDDATE_RANGE_OVERSHOOT_ERRORCODE;
					String errorMessage = MessageContainer.getInstance()
							.getDisplayMessage(
									CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
									errorCode);
					errorMessage = MessageFormat.format(errorMessage,
							new Object[] { preferredDateRange + "" });
					errorInfo = new ErrorInfo();
					errorInfo.setErrorCode(errorCode);
					errorInfo.setErrorMessage(errorMessage);
					response.addError(errorInfo);
					/*return;*/
				}
			}
		}
		
		
		
		// validation of the preferred end time against the configured end times
		// is not needed now - it is commented Date 06/06/2013
		/*apptTimeRequest.setTimeType(ScheduleConstants.BOOKAPPT_TO_TIME_IDENTIFIER);
		apptTimeResponse = ScheduleHelper
				.getAppointmentTimeResponse(apptTimeRequest);
		// check for invalid end appointment time
		if(!apptTimeResponse.containsAppointmentTime(preferredEndTime)){
			int errorCode = CreateAppointmentConstants.PRACTITIONER_REQUEST_INVALIDPREFERREDTENDTIME_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			return;
		}
		// get the index at which the specified end time occurs in the list
		// check this index - it should not be 0 
		// the start time index should not be greater than equals to
		// the end time index - this is also invalid
		int endIndex = apptTimeResponse.getAppointmentTimeIndex(preferredEndTime);
		if(endIndex == 0 || (startIndex >= endIndex)){
			int errorCode = CreateAppointmentConstants.PRACTITIONER_REQUEST_INVALIDPREFERREDTENDTIME_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			return;
		}*/
	}
	
	
	/**
	 * This method forms the practitioner request object
	 * @param parameterMap
	 * @return
	 */
	protected void populatePractitionerRequest(
			Map<String, String> parameterMap,
			PractitionerRequest practitionerRequest) {
		// set the portal user name to the request first
		practitionerRequest
				.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
		// next patient id
		if(parameterMap.containsKey(PortalConstants.PATIENTID_REQUEST_PARAM_KEY)){
			String patientId = parameterMap
					.get(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
			practitionerRequest.setPatientId(patientId);
		}
		// speciality id
		String speciality = null;
		if(parameterMap.containsKey(CreateAppointmentConstants.SPECIALITY_WS_PARAMETER_KEY)){
			speciality = parameterMap
					.get(CreateAppointmentConstants.SPECIALITY_WS_PARAMETER_KEY);
			practitionerRequest.setSpecialityCode(speciality);
		}else if(parameterMap.containsKey(CreateAppointmentConstants.APPT_PREFERREDSPECIALITYID_PARAMETER_KEY)){
			// this is needed for the practitioner schedule service
			speciality = parameterMap
					.get(CreateAppointmentConstants.APPT_PREFERREDSPECIALITYID_PARAMETER_KEY);
			practitionerRequest.setSpecialityCode(speciality);
		}
		
		// speciality description
		if(parameterMap.containsKey(CreateAppointmentConstants.APPT_PREFERREDSPECIALITYDESC_PARAMETER_KEY)){
			// this is needed for the practitioner schedule service
			String specialityDesc = parameterMap
					.get(CreateAppointmentConstants.APPT_PREFERREDSPECIALITYDESC_PARAMETER_KEY);
			practitionerRequest.setSpecialityDesc(specialityDesc);
		}
		
		// facility id
		if(parameterMap.containsKey(CreateAppointmentConstants.APPT_PREFERREDFACILITYID_PARAMETER_KEY)){
			String facilityId = parameterMap
					.get(CreateAppointmentConstants.APPT_PREFERREDFACILITYID_PARAMETER_KEY);
			practitionerRequest.setFacilityId(facilityId);
		}
		
		// facility description
		if(parameterMap.containsKey(CreateAppointmentConstants.APPT_PREFERREDFACILITYDESC_PARAMETER_KEY)){
			String facilityDesc = parameterMap
					.get(CreateAppointmentConstants.APPT_PREFERREDFACILITYDESC_PARAMETER_KEY);
			practitionerRequest.setFacilityId(facilityDesc);
		}
		
		// preferred date
		if(parameterMap.containsKey(CreateAppointmentConstants.PRACTITIONER_PREFERRED_DATE_PARAMETER_KEY)){
			String preferredDateStr = parameterMap
					.get(CreateAppointmentConstants.PRACTITIONER_PREFERRED_DATE_PARAMETER_KEY);
			practitionerRequest.setPreferredDateAsString(preferredDateStr);
			
			Date preferredDate = PortalHelper
					.getDateFromString(
							preferredDateStr,
							CreateAppointmentConstants.PRACTITIONER_SERVICE_PREFERRED_DATE_FORMAT);
			// vars to hold the preferred start and end date
			String preferredStartDateStr = "";
			String preferredEndDateStr = "";
			if(preferredDate != null){
				// start date is simple - set it to the preferred date given
				preferredStartDateStr = preferredDateStr;
				// now calculate the end date
				Calendar cal = Calendar.getInstance();
				cal.setTime(preferredDate);
				cal.add(Calendar.DATE,
						CreateAppointmentConstants.BOOKAPPT_PREFERREDENDDATE_RANGE);
				Date preferredEndDate = cal.getTime();
				preferredEndDateStr = PortalHelper
						.getDateAsString(
								preferredEndDate,
								CreateAppointmentConstants.PRACTITIONER_SERVICE_PREFERRED_DATE_FORMAT);
				// finally set the start and end date as string values
				//to the request
				practitionerRequest.setPreferredFromDateAsString(preferredStartDateStr);
				practitionerRequest.setPreferredToDateAsString(preferredEndDateStr);
			}
		}
		
		// preferred start time
		if(parameterMap.containsKey(CreateAppointmentConstants.PRACTITIONER_PREFERRED_STARTTIME_PARAMETER_KEY)){
			String prefferedStartTimeStr = parameterMap
					.get(CreateAppointmentConstants.PRACTITIONER_PREFERRED_STARTTIME_PARAMETER_KEY);
			practitionerRequest.setPreferredStartTime(prefferedStartTimeStr);
		}
		
		// preferred end time
		if(parameterMap.containsKey(CreateAppointmentConstants.PRACTITIONER_PREFERRED_ENDTIME_PARAMETER_KEY)){
			String prefferedEndTimeStr = parameterMap
					.get(CreateAppointmentConstants.PRACTITIONER_PREFERRED_ENDTIME_PARAMETER_KEY);
			practitionerRequest.setPreferredEndTime(prefferedEndTimeStr);
		}
		
		// operation standard id
		if(parameterMap.containsKey(CreateAppointmentConstants.PRACTITIONER_OPRSTN_ID_PARAMETER_KEY)){
			String oprStnId = parameterMap
					.get(CreateAppointmentConstants.PRACTITIONER_OPRSTN_ID_PARAMETER_KEY);
			practitionerRequest.setOperationStandardId(oprStnId);
		}
		
		// resource class
		if (parameterMap
				.containsKey(CreateAppointmentConstants.PRACTITIONER_RESOURCECLASS_PARAMETER_KEY)) {
			String resourceClass = parameterMap
					.get(CreateAppointmentConstants.PRACTITIONER_RESOURCECLASS_PARAMETER_KEY);
			practitionerRequest.setResourceClass(resourceClass);
		}
		
		// the below parameters are always set to ""
		practitionerRequest.setPractitionerId("");
		practitionerRequest.setPositionCode("");
		practitionerRequest.setClinicCode("");
		practitionerRequest.setCareLocationIndicator("");
		practitionerRequest.setCatalogCode("");
		practitionerRequest.setVisitType("");
		practitionerRequest.setLocale(Locale.getDefault().getLanguage());
		
	}
	
}
