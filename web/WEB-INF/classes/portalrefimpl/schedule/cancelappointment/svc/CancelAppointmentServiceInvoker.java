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
package portalrefimpl.schedule.cancelappointment.svc;

import org.w3c.dom.Document;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.serviceinvoker.AbstractServiceInvoker;
import portalrefimpl.common.serviceinvoker.XMLReaderIdentifier;
import portalrefimpl.common.svc.BaseService;
import portalrefimpl.schedule.ScheduleConstants;
import portalrefimpl.schedule.cancelappointment.request.CancelAppointmentRequest;
import portalrefimpl.schedule.cancelappointment.response.CancelAppointmentResponse;
import portalrefimpl.schedule.common.request.AppointmentType;

/**
 * This is the service invoker implementation for the cancel appointment
 * web service - this is basically the client for the web service
 * @author gramamoorthy
 *
 */
public class CancelAppointmentServiceInvoker extends AbstractServiceInvoker {

	/**
	 * Default constructor
	 */
	public CancelAppointmentServiceInvoker(){
		// set xmlReaderIdentifier to XMLReaderIdentifier.JAXB if JAXB
		// unmarshalling is expected
		xmlReaderIdentifier = XMLReaderIdentifier.JAXB;
	}
	
	/**
	 * This method returns the web service URL
	 */
	public String getWebServiceURL(BaseRequest request) {
		String webServiceUrl = PortalHelper
				.getWebServiceURL(PortalConstants.CANCEL_APPOINTMENT_WS_URL_KEY);
		return webServiceUrl;
	}

	/**
	 * This method returns the request parameters to be appended
	 * to the web service HTTP URL
	 */
	public String getURLParameters(BaseRequest request) {
		StringBuffer parameterBuffer = new StringBuffer();
		// first add the patient id
		String patientId = request.getPatientId();
		parameterBuffer.append(getCompleteParamString(
				PortalConstants.PATIENTID_REQUEST_PARAM_KEY, patientId));
		parameterBuffer.append("&");
		// next portal user
		String portalUserName = request.getPortalUserName();
		parameterBuffer.append(getCompleteParamString(
				PortalConstants.PORTALUSER_REQUEST_PARAM_KEY,
				portalUserName));
		parameterBuffer.append("&");
		
		// cast the request 
		CancelAppointmentRequest cancelAppointmentRequest = (CancelAppointmentRequest) request;
		// appointment number
		String appointmentNumber = cancelAppointmentRequest.getAppointmentReferenceNumber();
		parameterBuffer.append(getCompleteParamString(
				ScheduleConstants.CANCELAPPT_APPT_NUMBER_REQUEST_PARAM_KEY,
				appointmentNumber));
		parameterBuffer.append("&");
		// appointment status
		AppointmentType appointmentType = cancelAppointmentRequest.getAppointmentType();
		if(appointmentType != null){
			String apptType = ScheduleConstants.CANCELAPPT_APPT_IDENTIFIER;
			if(AppointmentType.Appointment_Request == appointmentType){
				apptType = ScheduleConstants.CANCELAPPT_APPT_REQUEST_TYPE_IDENTIFIER;
			}
			parameterBuffer.append(getCompleteParamString(
					ScheduleConstants.CANCELAPPT_APPT_STATUS_REQUEST_PARAM_KEY,
					apptType));
			parameterBuffer.append("&");
		}
		// facility id
		String facilityId = cancelAppointmentRequest.getFacilityId();
		parameterBuffer.append(getCompleteParamString(
				ScheduleConstants.CANCELAPPT_FACILITYID_REQUEST_PARAM_KEY,
				facilityId));
		parameterBuffer.append("&");
		
		// reason for cancellation
		String reasonForCancellation = cancelAppointmentRequest.getReasonForCancellation();
		parameterBuffer.append(getCompleteParamString(
				ScheduleConstants.CANCELAPPT_REASONCODE_REQUEST_PARAM_KEY,
				reasonForCancellation));
		
		return parameterBuffer.toString();
	}

	/**
	 * This method returns the response object
	 */
	public BaseResponse getResponseObject() {
		return new CancelAppointmentResponse();
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
		return new CancelAppointmentSvcImpl();
	}

	/**
	 * This method gets the required data from the underlying 
	 * service implementation
	 */
	public CancelAppointmentResponse getDataThroughService(CancelAppointmentRequest request) {
		CancelAppointmentSvcImpl svcImpl = new CancelAppointmentSvcImpl();
		return svcImpl.cancelAppointment(request);
	}

}
