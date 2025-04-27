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
package portalrefimpl.schedule.createappointment.svc.serviceinvoker;

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
import portalrefimpl.schedule.createappointment.request.BookAppointmentRequest;
import portalrefimpl.schedule.createappointment.response.BookAppointmentResponse;
import portalrefimpl.schedule.createappointment.svc.impl.BookAppointmentSvcImpl;

/**
 * This is the service invoker implementation for book appointments
 * 
 * @author GRamamoorthy
 *
 */
public class BookAppointmentServceInvoker extends AbstractServiceInvoker {

	/**
	 * constructor of the class
	 */
	public BookAppointmentServceInvoker(){
		// set xmlReaderIdentifier to XMLReaderIdentifier.JAXB if JAXB
		// unmarshalling is expected
		xmlReaderIdentifier = XMLReaderIdentifier.JAXB;
	}
	
	/**
	 * This method gets the HTTP URL for the web service
	 */
	public String getWebServiceURL(BaseRequest request) {
		String webServiceURL = PortalHelper
				.getConfigPropertyValue(PortalConstants.CREATEAPPOINTMENT_WS_URL_KEY);
		return webServiceURL;
	}

	/**
	 * This method gets the URL parameters for the web service
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
		if(locale != null && !locale.trim().equals("")){
			parameterBuffer.append(getCompleteParamString(
					CommonConstants.LANGUAGE_WS_PARAMETER_KEY, locale));
			parameterBuffer.append("&");
		}
		
		// cast to the specific request - no need to worry
		// this will work
		BookAppointmentRequest bookAppointmentRequest = (BookAppointmentRequest) request;
		// facility id
		String facilityId = bookAppointmentRequest.getFacilityId();
		if(facilityId == null){
			facilityId = "";
		}
		parameterBuffer
				.append(getCompleteParamString(
						CreateAppointmentConstants.APPOINTMENT_FACILITYID_REQUEST_PARAM,
						facilityId));
		parameterBuffer.append("&");
		// specialty id
		String specialtyId = bookAppointmentRequest.getSpecialityId();
		if(specialtyId == null){
			specialtyId = "";
		}
		parameterBuffer
				.append(getCompleteParamString(
						CreateAppointmentConstants.APPOINTMENT_SPECIALITYID_REQUEST_PARAM,
						specialtyId));
		parameterBuffer.append("&");
		// practitioner id
		String practitionerId = bookAppointmentRequest.getPractitionerId();
		if(practitionerId == null){
			practitionerId = "";
		}
		parameterBuffer
				.append(getCompleteParamString(
						CreateAppointmentConstants.APPOINTMENT_PRACTITIONERID_REQUEST_PARAM,
						practitionerId));
		parameterBuffer.append("&");
		
		// location code
		String locationCode = bookAppointmentRequest.getLocationCode();
		parameterBuffer
				.append(getCompleteParamString(
						CreateAppointmentConstants.APPOINTMENT_LOCATION_CODE_REQUEST_PARAM,
						locationCode));
		parameterBuffer.append("&");
		// preferred date
		String preferredDate = bookAppointmentRequest.getPreferredDate();
		if(preferredDate == null){
			preferredDate = "";
		}
		parameterBuffer
				.append(getCompleteParamString(
						CreateAppointmentConstants.APPOINTMENT_PREFERREDDATE_REQUEST_PARAM,
						preferredDate));
		parameterBuffer.append("&");
		// preferred from time
		String preferredFromTime = bookAppointmentRequest.getPreferredFromTime();
		if(preferredFromTime == null){
			preferredFromTime = "";
		}
		parameterBuffer
		.append(getCompleteParamString(
				CreateAppointmentConstants.APPOINTMENT_PREFERREDFROMTIME_REQUEST_PARAM,
				preferredFromTime));
		parameterBuffer.append("&");
		// preferred to time
		String preferredToTime = bookAppointmentRequest.getPreferredToTime();
		if(preferredToTime == null){
			preferredToTime = "";
		}
		parameterBuffer
		.append(getCompleteParamString(
				CreateAppointmentConstants.APPOINTMENT_PREFERREDTOTIME_REQUEST_PARAM,
				preferredToTime));
		
		
		return parameterBuffer.toString();
	}

	/**
	 * this method returns an instance of the response object
	 * which will be used to hold the data
	 */
	public BaseResponse getResponseObject() {
		return new BookAppointmentResponse();
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
		return  new BookAppointmentSvcImpl();
	}

	/**
	 * This method gets the required data from the underlying 
	 * service implementation
	 */
	public BaseResponse getDataThroughService(BookAppointmentRequest request) {
		BookAppointmentSvcImpl svcImpl = new BookAppointmentSvcImpl();
		return svcImpl.bookAppointment(request);
	}

}
