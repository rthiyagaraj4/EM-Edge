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
package portalrefimpl.schedule.rescheduleappointment.svc.serviceinvoker;

import org.w3c.dom.Document;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.serviceinvoker.AbstractServiceInvoker;
import portalrefimpl.common.serviceinvoker.XMLReaderIdentifier;
import portalrefimpl.common.svc.BaseService;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.rescheduleappointment.RescheduleRequestConstants;
import portalrefimpl.schedule.rescheduleappointment.request.RescheduleAppointmentRequest;
import portalrefimpl.schedule.rescheduleappointment.response.RescheduleAppointmentResponse;
import portalrefimpl.schedule.rescheduleappointment.svc.impl.RescheduleAppointmentSvcImpl;

/**
 * This is the service invoker implementation class for reschedule appointment
 * service. This is basically the client class for the service.
 * This class extends the AbstractServiceInvoker class
 * @author GRamamoorthy
 *
 */
public class RescheduleAppointmentServiceInvoker extends AbstractServiceInvoker {

	/**
	 * Constructor of the class
	 */
	public RescheduleAppointmentServiceInvoker(){
		// set xmlReaderIdentifier to XMLReaderIdentifier.JAXB if JAXB
		// unmarshalling is expected
		xmlReaderIdentifier = XMLReaderIdentifier.JAXB;
	}
	
	/**
	 * This method returns the web service URL for this service
	 */
	public String getWebServiceURL(BaseRequest request) {
		String webServiceUrl = PortalHelper
				.getWebServiceURL(PortalConstants.RESCHEDULE_APPT_REQ_WS_URL_KEY);
		return webServiceUrl;
	}

	/**
	 * This method returns the URL parameters for this service
	 */
	public String getURLParameters(BaseRequest request) {
		StringBuilder parameterBuffer = new StringBuilder();
		
		String patientId = request.getPatientId();
		parameterBuffer.append(getCompleteParamString(
				PortalConstants.PATIENTID_REQUEST_PARAM_KEY, patientId));
		parameterBuffer.append("&");
		// next portal user
		parameterBuffer.append(getCompleteParamString(
				PortalConstants.PORTALUSER_REQUEST_PARAM_KEY,
				PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE));
		parameterBuffer.append("&");
		// locale also can be passed
		String locale = request.getLocale();
		if (locale != null && !locale.trim().equals("")) {
			parameterBuffer.append(getCompleteParamString(
					CommonConstants.LANGUAGE_WS_PARAMETER_KEY, locale));
			parameterBuffer.append("&");
		}
		RescheduleAppointmentRequest rescheduleApptRequest = (RescheduleAppointmentRequest)request;
		// facility id
		String facilityId = rescheduleApptRequest.getFacilityId();
		if (facilityId == null) {
			facilityId = "";
		}
		parameterBuffer
				.append(getCompleteParamString(
						RescheduleRequestConstants.APPTREQ_FACILITYID_PARAM_KEY,
						facilityId));
		parameterBuffer.append("&");
		
		// reference number
		String apptRefNumber = rescheduleApptRequest.getAppointmentReferenceNumber();
		if(apptRefNumber == null){
			apptRefNumber = "";
		}
		parameterBuffer.append(getCompleteParamString(
				RescheduleRequestConstants.APPTREQ_REF_NUMBER_PARAM_KEY,
				apptRefNumber));
		parameterBuffer.append("&");
		
		// preferred date
		String preferredDate = rescheduleApptRequest.getPreferredDate();
		if(preferredDate == null){
			preferredDate = "";
		}
		parameterBuffer.append(getCompleteParamString(
				RescheduleRequestConstants.APPTREQ_PREFERRED_DATE_PARAM_KEY,
				preferredDate));
		parameterBuffer.append("&");
		
		// preferred from time
		String preferredFromTime = rescheduleApptRequest.getPreferredFromTime();
		if(preferredFromTime == null){
			preferredFromTime = "";
		}
		parameterBuffer.append(getCompleteParamString(
				RescheduleRequestConstants.APPTREQ_PREFERRED_FROMTIME_PARAM_KEY,
				preferredFromTime));
		parameterBuffer.append("&");
		
		// preferred to time
		String preferredToTime = rescheduleApptRequest.getPreferredToTime();
		if(preferredToTime == null){
			preferredToTime = "";
		}
		parameterBuffer.append(getCompleteParamString(
				RescheduleRequestConstants.APPTREQ_PREFERRED_TOTIME_PARAM_KEY,
				preferredToTime));
		parameterBuffer.append("&");
		
		// practitioner id
		String practitionerId = rescheduleApptRequest.getPractitionerId();
		if(practitionerId == null){
			practitionerId = "";
		}
		parameterBuffer.append(getCompleteParamString(
				RescheduleRequestConstants.APPTREQ_PRACTITIONERID_PARAM_KEY,
				practitionerId));
		parameterBuffer.append("&");
		
		// location code
		String locationCode = rescheduleApptRequest.getLocationCode();
		if(locationCode == null){
			locationCode = "";
		}
		parameterBuffer.append(getCompleteParamString(
				RescheduleRequestConstants.APPTREQ_LOCATIONCODE_PARAM_KEY,
				locationCode));
		parameterBuffer.append("&");
		
		// modified facility id
		String modifiedFacilityId = rescheduleApptRequest.getModifiedFacilityId();
		if(modifiedFacilityId == null){
			modifiedFacilityId = "";
		}
		parameterBuffer.append(getCompleteParamString(
				RescheduleRequestConstants.APPTREQ_MODIFIED_FACILITYID_PARAM_KEY,
				modifiedFacilityId));
		parameterBuffer.append("&");
		
		// care location indicator
		String careLocationIndicator = rescheduleApptRequest.getCareLocationTypeIndicator();
		if(careLocationIndicator == null || careLocationIndicator.trim().equals("")){
			careLocationIndicator = CreateAppointmentConstants.APPOINTMENT_CARE_LOCATION_TYPE_INDICATOR_VALUE;
		}
		parameterBuffer.append(getCompleteParamString(
				RescheduleRequestConstants.APPTREQ_CARELOCATIONINDICATOR_PARAM_KEY,
				careLocationIndicator));
		parameterBuffer.append("&");
		
		String reasonCode = rescheduleApptRequest.getModifyReasonCode();
		parameterBuffer.append(getCompleteParamString(
				RescheduleRequestConstants.RESCHEDULE_REASON_CODE_PARAM,
				reasonCode));
		
		return parameterBuffer.toString();
	}

	/**
	 * This method returns the response object for this service
	 */
	public BaseResponse getResponseObject() {
		return new RescheduleAppointmentResponse();
	}

	/**
	 * 
	 */
	public void readXMLContent(Document document, BaseResponse response) {
		// This method need not be implemented when we are doing JAXB
		// unmarshalling This method is implemented merely to satisfy the
		// contract
	}

	/**
	 * This method returns an instance of the impl class
	 * used for performing the business operation 
	 */
	protected BaseService getServiceImpl() {
		return new RescheduleAppointmentSvcImpl();
	}
	
	/**
	 * This method gets the required data from the underlying 
	 * service implementation
	 */
	public RescheduleAppointmentResponse getDataThroughService(RescheduleAppointmentRequest request){
		RescheduleAppointmentSvcImpl svcImpl = new RescheduleAppointmentSvcImpl();
		return svcImpl.rescheduleAppointmentRequest(request);
	}

}
