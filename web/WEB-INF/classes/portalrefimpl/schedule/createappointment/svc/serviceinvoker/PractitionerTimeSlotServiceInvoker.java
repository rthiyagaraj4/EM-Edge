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
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.serviceinvoker.AbstractServiceInvoker;
import portalrefimpl.common.serviceinvoker.XMLReaderIdentifier;
import portalrefimpl.common.svc.BaseService;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.createappointment.request.PractitionerTimeSlotRequest;
import portalrefimpl.schedule.createappointment.response.PractitionerTimeSlotResponse;
import portalrefimpl.schedule.createappointment.svc.impl.PractitionerTimeSlotSvcImpl;

/**
 * This is the service invoker class for practitioner time slot service
 * @author GRamamoorthy
 *
 */
public class PractitionerTimeSlotServiceInvoker extends AbstractServiceInvoker {

	/**
	 * Default constructor of the class
	 */
	public PractitionerTimeSlotServiceInvoker(){
		// set xmlReaderIdentifier to XMLReaderIdentifier.JAXB if JAXB
		// unmarshalling is expected
		xmlReaderIdentifier = XMLReaderIdentifier.JAXB;
	}
	
	
	/**
	 * This method returns the practitioner time slot web service URL
	 */
	public String getWebServiceURL(BaseRequest request) {
		String webServiceUrl = PortalHelper
				.getWebServiceURL(PortalConstants.CREATEAPPOINTMENT_GETPRACTITIONERTIMESLOT_WS_URL_KEY);
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
		// cast to the specific request - no need to worry
		// this will work
		PractitionerTimeSlotRequest practitionerTimeSlotRequest = (PractitionerTimeSlotRequest)request;
		// now request specific parameters needs to be added
		// practitioner id
		String practitionerId = practitionerTimeSlotRequest.getPractitionerId();
		parameterBuffer.append(getCompleteParamString(
				CreateAppointmentConstants.PRACTITIONER_PRACTITIONERID_PARAMETER_KEY,
				practitionerId));
		parameterBuffer.append("&");
		
		// facility id
		String facilityId = practitionerTimeSlotRequest.getFacilityId();
		parameterBuffer
				.append(getCompleteParamString(
						CreateAppointmentConstants.PRACTITIONERSTATUS_FACILITYID_REQUEST_PARAMETER,
						facilityId));
		parameterBuffer.append("&");
		
		// resource type
		String resourceType = practitionerTimeSlotRequest.getResourceType();
		parameterBuffer
				.append(getCompleteParamString(
						CreateAppointmentConstants.PRACTITIONERSTATUS_RESOURCETYPE_REQUEST_PARAMETER,
						resourceType));
		parameterBuffer.append("&");
		
		// clinic code
		String clinicCode = practitionerTimeSlotRequest.getClinicCode();
		parameterBuffer
				.append(getCompleteParamString(
						CreateAppointmentConstants.PRACTITIONERSTATUS_CLINICCODE_REQUEST_PARAMETER,
						clinicCode));
		parameterBuffer.append("&");
		
		// clinic type
		String clinicType = practitionerTimeSlotRequest.getClinicType();
		parameterBuffer
				.append(getCompleteParamString(
						CreateAppointmentConstants.PRACTITIONERSTATUS_CLINICTYPE_REQUEST_PARAMETER,
						clinicType));
		parameterBuffer.append("&");
		
		// preferred date
		String preferredDate = practitionerTimeSlotRequest.getPreferredDate();
		parameterBuffer
				.append(getCompleteParamString(
						CreateAppointmentConstants.PRACTITIONERTIMESLOT_PREFERREDDATE_REQUEST_PARAMETER,
						preferredDate));
		
		return parameterBuffer.toString();
	}

	/**
	 * This method returns the practitioner time slot response object
	 */
	public BaseResponse getResponseObject() {
		return new PractitionerTimeSlotResponse();
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
		return new PractitionerTimeSlotSvcImpl();
	}

	/**
	 * This method gets the required data from the underlying 
	 * service implementation
	 */
	public PractitionerTimeSlotResponse getDataThroughService(PractitionerTimeSlotRequest request){
		PractitionerTimeSlotSvcImpl svcImpl = new PractitionerTimeSlotSvcImpl();
		return svcImpl.getPractitionerTimeSlot(request);
	}
	
}
