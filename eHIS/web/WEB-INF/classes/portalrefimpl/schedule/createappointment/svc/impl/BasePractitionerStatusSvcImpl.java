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

import java.util.Date;
import java.util.Map;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.common.svc.BaseServiceImpl;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.createappointment.request.PractitionerStatusRequest;

/**
 * This is the base class for the practitioner schedule status and
 * practitioner time slot service
 * This class provides a method to validate the common parameters
 * in the request object used in the service
 * @author GRamamoorthy
 *
 */
public abstract class BasePractitionerStatusSvcImpl extends BaseServiceImpl {

	/**
	 * This method validates the practitioner status request
	 * and sets the error information in the response object
	 * @param request
	 * @param response
	 */
	protected void validatePractitionerStatusRequest(
			PractitionerStatusRequest request, BaseResponse response) {
		// the following needs to be validated
		// 1. practitioner id 2. facility id 3.resource type
		// 4. clinic code
		// clinic type is not considered for validation now
		
		/*ErrorInfo errorInfo = response.getErrorInfo();*/
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		// 1. practitioner id validation
		String practitionerId = request.getPractitionerId();
		if(practitionerId == null || practitionerId.trim().equals("")){
			errorCode = CreateAppointmentConstants.PRACTITIONERSTATUS_PRACTITIONERID_MISSING_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			/*return;*/
		}
		// 2. facility id validation
		String facilityId = request.getFacilityId();
		if(facilityId == null || facilityId.trim().equals("")){
			errorCode = CreateAppointmentConstants.PRACTITIONERSTATUS_FACILITYID_MISSING_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			/*return;*/
		}
		
		// 3. resource type validation
		String resourceType = request.getResourceType();
		if(resourceType == null || resourceType.trim().equals("")){
			errorCode = CreateAppointmentConstants.PRACTITIONERSTATUS_RESOURCETYPE_MISSING_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			/*return;*/
		}
		
		// 4 clinic code
		String clinicCode = request.getClinicCode();
		if(clinicCode == null || clinicCode.trim().equals("")){
			errorCode = CreateAppointmentConstants.PRACTITIONERSTATUS_CLINICCODE_MISSING_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			/*return;*/
		}
	}
	
	/**
	 * This method will populate the common request parameters
	 * of the practitioner schedule status and practitioner time slot service
	 * @param request
	 * @param parameterMap
	 */
	protected void populatePropertyInRequest(PractitionerStatusRequest request,Map<String, String> parameterMap){
		// set the portal user name to the request first
		if (parameterMap
				.containsKey(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY)) {
			String portalKeyValue = parameterMap
					.get(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY);
			request.setPortalUserName(portalKeyValue);
		}
		
		// next patient id
		if(parameterMap.containsKey(PortalConstants.PATIENTID_REQUEST_PARAM_KEY)){
			String patientId = parameterMap
					.get(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
			request.setPatientId(patientId);
		}
		
		// the common parameters are
		// 1. practitioner id 2. facility id 3. resource type
		// 4. clinic code 5. clinic type
		
		// first the practitioner id
		if (parameterMap
				.containsKey(CreateAppointmentConstants.PRACTITIONERSTATUS_PRACTITIONERID_REQUEST_PARAMETER)) {
			String practitionerId = parameterMap
					.get(CreateAppointmentConstants.PRACTITIONERSTATUS_PRACTITIONERID_REQUEST_PARAMETER);
			request.setPractitionerId(practitionerId);
		}
		
		// facility id
		if (parameterMap
				.containsKey(CreateAppointmentConstants.PRACTITIONERSTATUS_FACILITYID_REQUEST_PARAMETER)) {
			String facilityId = parameterMap
					.get(CreateAppointmentConstants.PRACTITIONERSTATUS_FACILITYID_REQUEST_PARAMETER);
			request.setFacilityId(facilityId);
		}
		
		// resource type
		if (parameterMap
				.containsKey(CreateAppointmentConstants.PRACTITIONERSTATUS_RESOURCETYPE_REQUEST_PARAMETER)) {
			String resourceType = parameterMap
					.get(CreateAppointmentConstants.PRACTITIONERSTATUS_RESOURCETYPE_REQUEST_PARAMETER);
			request.setResourceType(resourceType);
		}
		
		// clinic code
		String clinicCode = "";
		if(parameterMap.containsKey(CreateAppointmentConstants.PRACTITIONERSTATUS_CLINICCODE_REQUEST_PARAMETER)){
			clinicCode = parameterMap
					.get(CreateAppointmentConstants.PRACTITIONERSTATUS_CLINICCODE_REQUEST_PARAMETER);
		}
		request.setClinicCode(clinicCode);
		
		// clinic type
		String clinicType = "";
		if(parameterMap.containsKey(CreateAppointmentConstants.PRACTITIONERSTATUS_CLINICTYPE_REQUEST_PARAMETER)){
			clinicType = parameterMap
					.get(CreateAppointmentConstants.PRACTITIONERSTATUS_CLINICTYPE_REQUEST_PARAMETER);
		}
		request.setClinicType(clinicType);
		
	}
	
	/**
	 * This method will validate the preferred date and set
	 * error information in the response object
	 * @param preferredDate
	 * @return
	 */
	protected void validatePreferredDate(String preferredDateStr,BaseResponse response){
		// here only the preferred date is validated
		// it is checked for past date and for falling within X days from current date
		// where X is the configuration value
		Date preferredDate = PortalHelper.getDateFromString(preferredDateStr,
				CreateAppointmentConstants.PRACTITIONERSTATUS_DATEFORMAT);
		Date currentDate = new Date();
		/*ErrorInfo errorInfo = response.getErrorInfo();*/
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		// check for past date
		if(currentDate.after(preferredDate)){
			errorCode = CreateAppointmentConstants.PRACTITIONERSTATUS_PREFERREDDATE_PASTDATE_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.COMMON_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			/*return;*/
		}
		
		// check for date range
		String dateRangeStr = PortalHelper
				.getConfigPropertyValue(CreateAppointmentConstants.BOOKAPPT_PREFERREDDATE_RANGE_KEY);
		int dateRange = PortalHelper.getIntegerValue(dateRangeStr, 0);
		
		long timeDiff = preferredDate.getTime() - currentDate.getTime();
		final int NUMBEROFHRS_IN_DAY = 24;
		int dateDiff = (int)(timeDiff / (CreateAppointmentConstants.NUMBER_OF_MILLIS_IN_HR * NUMBEROFHRS_IN_DAY));
		if(dateDiff > dateRange){
			errorCode = CreateAppointmentConstants.PRACTITIONERSTATUS_PREFERREDDATE_OUTSIDERANGE_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.COMMON_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			/*return;*/
		}
		
	}
	
	
}
