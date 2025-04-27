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
package portalrefimpl.contactreason.cancelappointment.svc;

import org.w3c.dom.Document;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.serviceinvoker.AbstractServiceInvoker;
import portalrefimpl.common.serviceinvoker.XMLReaderIdentifier;
import portalrefimpl.common.svc.BaseService;
import portalrefimpl.contactreason.cancelappointment.ContactReasonCancelApptConstant;
import portalrefimpl.contactreason.cancelappointment.request.ContactReasonForCancelApptRequest;
import portalrefimpl.contactreason.cancelappointment.response.ContactReasonForCancelApptResponse;
import portalrefimpl.schedule.common.request.AppointmentType;

/**
 * This is the client class for the contact reason for cancel appointment
 * web service
 * @author GRamamoorthy
 *
 */
public class ContactReasonForCancelApptServiceInvoker extends
		AbstractServiceInvoker {

	public ContactReasonForCancelApptServiceInvoker(){
		// set xmlReaderIdentifier to XMLReaderIdentifier.JAXB if JAXB
		// unmarshalling is expected
		xmlReaderIdentifier = XMLReaderIdentifier.JAXB;
	}
	
	/**
	 * This method returns the HTTP URL for the web service
	 */
	public String getWebServiceURL(BaseRequest request) {
		String webServiceUrl = PortalHelper
				.getWebServiceURL(PortalConstants.CONTACTREASON_CANCELAPPT_WS_URL_KEY);
		return webServiceUrl;
	}

	/**
	 * This method returns the request parameters to be appended
	 * to the web service HTTP URL
	 */
	public String getURLParameters(BaseRequest request) {
		StringBuffer parameterBuffer = new StringBuffer();
		// next portal user
		String portalUserName = request.getPortalUserName();
		parameterBuffer.append(getCompleteParamString(
				PortalConstants.PORTALUSER_REQUEST_PARAM_KEY,
				portalUserName));
		parameterBuffer.append("&");
		// appointment type
		ContactReasonForCancelApptRequest contactReasonRequest = (ContactReasonForCancelApptRequest) request;
		AppointmentType apptType = contactReasonRequest.getAppointmentType();
		if(apptType != null){
			parameterBuffer
					.append(getCompleteParamString(
							ContactReasonCancelApptConstant.APPOINTMENT_TYPE_REQUEST_PARAM_KEY,
							apptType.toString()));
		}
		
		return parameterBuffer.toString();
	}

	/**
	 * This method returns the response object for this service
	 */
	public BaseResponse getResponseObject() {
		return new ContactReasonForCancelApptResponse();
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
		return new ContactReasonForCancelApptSvcImpl();
	}

	/**
	 * This method gets the required data from the underlying 
	 * service implementation
	 */
	public ContactReasonForCancelApptResponse getDataThroughService(ContactReasonForCancelApptRequest request) {
		ContactReasonForCancelApptSvcImpl svcImpl = new ContactReasonForCancelApptSvcImpl();
		return svcImpl.getContactReasons(request);
	}

}
