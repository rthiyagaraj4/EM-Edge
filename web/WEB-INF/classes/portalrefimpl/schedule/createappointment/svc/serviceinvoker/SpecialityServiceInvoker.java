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
import portalrefimpl.schedule.createappointment.request.SpecialityRequest;
import portalrefimpl.schedule.createappointment.response.SpecialityResponse;
import portalrefimpl.schedule.createappointment.svc.impl.SpecialitySvcImpl;

/**
 * @author SaraswathiR
 *
 */
public class SpecialityServiceInvoker extends AbstractServiceInvoker {

	/**
	 * 
	 */
	public SpecialityServiceInvoker() {
		// set xmlReaderIdentifier to XMLReaderIdentifier.JAXB if JAXB
		// unmarshalling is expected
		xmlReaderIdentifier = XMLReaderIdentifier.JAXB;
	}

	/*
	 * Get the webservice url
	 */
	@Override
	public String getWebServiceURL(BaseRequest request) {
		String webServiceUrl = PortalHelper.getWebServiceURL(PortalConstants.CREATEAPPOINTMENT_GETSPECIALITY_WS_URL_KEY);
		return webServiceUrl;
	}

	/**
	 * 
	 */
	public String getURLParameters(BaseRequest request) {
		SpecialityRequest  specialityRequest = (SpecialityRequest) request;
		String patientId = request.getPatientId();
		if (patientId == null) {
			patientId = "";
		}
		String params = "patientId=" + patientId;
		params += "&";
		params += PortalConstants.PORTALUSER_REQUEST_PARAM_KEY;
		params += "=";
		params += PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE;
		
		return params;
	}

	/**
	 * 
	 */
	public BaseResponse getResponseObject() {
		return new SpecialityResponse();
	}

	/* (non-Javadoc)
	 * @see portalrefimpl.common.serviceinvoker.AbstractServiceInvoker#readXMLContent(org.w3c.dom.Document, portalrefimpl.common.response.BaseResponse)
	 */
	@Override
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
		return new SpecialitySvcImpl();
	}

	/**
	 * This method gets the required data from the underlying 
	 * service implementation
	 */
	public SpecialityResponse getDataThroughService(SpecialityRequest request){
		SpecialitySvcImpl svcImpl = new SpecialitySvcImpl();
		return svcImpl.getSpecialities(request);
	}
	
}
