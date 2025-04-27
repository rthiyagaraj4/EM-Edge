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
import portalrefimpl.schedule.createappointment.request.PractitionerRequest;
import portalrefimpl.schedule.createappointment.response.PractitionerResponse;
import portalrefimpl.schedule.createappointment.svc.impl.PractitionerSvcImpl;

/**
 * This is the service invoker implementation for practitioner service
 * 
 * @author GRamamoorthy
 *
 */
public class PractitionerServiceInvoker extends AbstractServiceInvoker {
	
	/**
	 * Default constructor of the class
	 */
	public PractitionerServiceInvoker() {
		// set xmlReaderIdentifier to XMLReaderIdentifier.JAXB if JAXB
		// unmarshalling is expected
		xmlReaderIdentifier = XMLReaderIdentifier.JAXB;
	}

	/**
	 * This method gets this web service URL
	 */
	public String getWebServiceURL(BaseRequest request) {
		String webServiceUrl = PortalHelper
				.getWebServiceURL(PortalConstants.CREATEAPPOINTMENT_GETPRACTITIONER_WS_URL_KEY);
		return webServiceUrl;
	}

	/**
	 * This method gets the URL parameters
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
		
		// next speciality code
		PractitionerRequest practitionerRequest = (PractitionerRequest)request;
		String speciality = practitionerRequest.getSpecialityCode();
		parameterBuffer.append(getCompleteParamString(
				CreateAppointmentConstants.SPECIALITY_WS_PARAMETER_KEY,
				speciality));
		parameterBuffer.append("&");
		
		// facility id
		String facilityId = practitionerRequest.getFacilityId();
		parameterBuffer.append(getCompleteParamString(
				CreateAppointmentConstants.APPT_PREFERREDFACILITYID_PARAMETER_KEY,
				facilityId));
		parameterBuffer.append("&");
		
		// preferred date
		String preferredDateStr = practitionerRequest.getPreferredDateAsString();
		parameterBuffer.append(getCompleteParamString(
				CreateAppointmentConstants.PRACTITIONER_PREFERRED_DATE_PARAMETER_KEY,
				preferredDateStr));
		parameterBuffer.append("&");
		
		// preferred start time
		String preferredStartTimeStr = practitionerRequest.getPreferredStartTime();
		parameterBuffer.append(getCompleteParamString(
				CreateAppointmentConstants.PRACTITIONER_PREFERRED_STARTTIME_PARAMETER_KEY,
				preferredStartTimeStr));
		parameterBuffer.append("&");
		
		// preferred end time
		String preferredEndTimeStr = practitionerRequest.getPreferredEndTime();
		parameterBuffer.append(getCompleteParamString(
				CreateAppointmentConstants.PRACTITIONER_PREFERRED_ENDTIME_PARAMETER_KEY,
				preferredEndTimeStr));
		parameterBuffer.append("&");
		
		// opr stnd id
		String oprStndId = practitionerRequest.getOperationStandardId();
		parameterBuffer.append(getCompleteParamString(
				CreateAppointmentConstants.PRACTITIONER_OPRSTN_ID_PARAMETER_KEY,
				oprStndId));
		parameterBuffer.append("&");
		
		// resource class
		String resourceClass = practitionerRequest.getResourceClass();
		parameterBuffer.append(getCompleteParamString(
				CreateAppointmentConstants.PRACTITIONER_RESOURCECLASS_PARAMETER_KEY,
				resourceClass));
		
		return parameterBuffer.toString();
	}

	/**
	 * 
	 */
	public BaseResponse getResponseObject() {
		return new PractitionerResponse();
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
		return new PractitionerSvcImpl();
	}
	

	/**
	 * This method gets the required data from the underlying 
	 * service implementation
	 */
	public PractitionerResponse getDataThroughService(PractitionerRequest request){
		PractitionerSvcImpl svcImpl = new PractitionerSvcImpl();
		return svcImpl.getPractitionerList(request);
	}

}
