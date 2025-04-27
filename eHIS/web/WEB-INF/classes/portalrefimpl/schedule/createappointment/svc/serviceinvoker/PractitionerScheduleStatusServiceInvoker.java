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
import portalrefimpl.schedule.createappointment.request.PractitionerScheduleStatusRequest;
import portalrefimpl.schedule.createappointment.response.PractitionerScheduleStatusResponse;
import portalrefimpl.schedule.createappointment.svc.impl.PractitionerScheduleStatusSvcImpl;

/**
 * This class is the service invoker implementation for the practitioner
 * schedule status service
 * @author GRamamoorthy
 *
 */
public class PractitionerScheduleStatusServiceInvoker extends
		AbstractServiceInvoker {
	
	/**
	 * Default constructor of the class
	 */
	public PractitionerScheduleStatusServiceInvoker(){
		// set xmlReaderIdentifier to XMLReaderIdentifier.JAXB if JAXB
		// unmarshalling is expected
		xmlReaderIdentifier = XMLReaderIdentifier.JAXB;
	}
	
	/**
	 * This method gets the HTTP URL for this web service
	 */
	public String getWebServiceURL(BaseRequest request) {
		String webServiceUrl = PortalHelper
				.getWebServiceURL(PortalConstants.CREATEAPPOINTMENT_GETPRACTITIONERSCHEDULESTATUS_WS_URL_KEY);
		return webServiceUrl;
	}

	/**
	 * This method gets the URL parameters to be supplied
	 * for this web service
	 */
	public String getURLParameters(BaseRequest request) {
		StringBuffer parameterBuffer = new StringBuffer();
		// first add the patient id
		String patientId = request.getPatientId();
		parameterBuffer.append(getCompleteParamString(
				PortalConstants.PATIENTID_REQUEST_PARAM_KEY, patientId));
		parameterBuffer.append("&");
		// next portal user
		parameterBuffer.append(getCompleteParamString(
				PortalConstants.PORTALUSER_REQUEST_PARAM_KEY,
				PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE));
		parameterBuffer.append("&");
		// cast to the specific request - no need to worry
		PractitionerScheduleStatusRequest practScheduleStatusRequest = (PractitionerScheduleStatusRequest) request;
		// now request specific parameters needs to be added
		// practitioner id
		String practitionerId = practScheduleStatusRequest.getPractitionerId();
		parameterBuffer.append(getCompleteParamString(
				CreateAppointmentConstants.PRACTITIONER_PRACTITIONERID_PARAMETER_KEY,
				practitionerId));
		parameterBuffer.append("&");
		
		// facility id
		String facilityId = practScheduleStatusRequest.getFacilityId();
		parameterBuffer
				.append(getCompleteParamString(
						CreateAppointmentConstants.PRACTITIONERSTATUS_FACILITYID_REQUEST_PARAMETER,
						facilityId));
		parameterBuffer.append("&");
		
		// resource type
		String resourceType = practScheduleStatusRequest.getResourceType();
		parameterBuffer
				.append(getCompleteParamString(
						CreateAppointmentConstants.PRACTITIONERSTATUS_RESOURCETYPE_REQUEST_PARAMETER,
						resourceType));
		parameterBuffer.append("&");
		
		// clinic code
		String clinicCode = practScheduleStatusRequest.getClinicCode();
		parameterBuffer
				.append(getCompleteParamString(
						CreateAppointmentConstants.PRACTITIONERSTATUS_CLINICCODE_REQUEST_PARAMETER,
						clinicCode));
		parameterBuffer.append("&");
		
		// clinic type
		String clinicType = practScheduleStatusRequest.getClinicType();
		parameterBuffer
				.append(getCompleteParamString(
						CreateAppointmentConstants.PRACTITIONERSTATUS_CLINICTYPE_REQUEST_PARAMETER,
						clinicType));
		parameterBuffer.append("&");
		
		// preferred from date
		String preferredFromDateStr = practScheduleStatusRequest.getPreferredFromDate();
		parameterBuffer
				.append(getCompleteParamString(
						CreateAppointmentConstants.PRACTITIONERSCHEDULESTATUS_PREFERREDFROMDATE_PARAMETER_KEY,
						preferredFromDateStr));
		parameterBuffer.append("&");
		
		// preferred from date
		String preferredToDateStr = practScheduleStatusRequest
				.getPreferredToDate();
		parameterBuffer
				.append(getCompleteParamString(
						CreateAppointmentConstants.PRACTITIONERSCHEDULESTATUS_PREFERREDTODATE_PARAMETER_KEY,
						preferredToDateStr));
				
		
		return parameterBuffer.toString();
	}

	/**
	 * This method gets the PractitionerScheduleStatusResponse
	 * object 
	 */
	public BaseResponse getResponseObject() {
		return new PractitionerScheduleStatusResponse();
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
		return new PractitionerScheduleStatusSvcImpl();
	}
	
	/**
	 * This method gets the required data from the underlying 
	 * service implementation
	 */
	public PractitionerScheduleStatusResponse getDataThroughService(PractitionerScheduleStatusRequest request){
		PractitionerScheduleStatusSvcImpl svcImpl = new PractitionerScheduleStatusSvcImpl();
		return svcImpl.getPractitionerScheduleStatus(request);
	}

}
