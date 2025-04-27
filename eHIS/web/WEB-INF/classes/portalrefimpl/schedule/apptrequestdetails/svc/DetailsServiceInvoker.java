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
package portalrefimpl.schedule.apptrequestdetails.svc;

import org.w3c.dom.Document;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.serviceinvoker.AbstractServiceInvoker;
import portalrefimpl.common.serviceinvoker.XMLReaderIdentifier;
import portalrefimpl.common.svc.BaseService;
import portalrefimpl.schedule.apptrequestdetails.request.DetailsRequest;
import portalrefimpl.schedule.apptrequestdetails.response.DetailsResponse;
import portalrefimpl.schedule.rescheduleappointment.RescheduleRequestConstants;

/**
 * This is the service invoker class for the get appointment request details service
 * @author GRamamoorthy
 *
 */
public class DetailsServiceInvoker extends AbstractServiceInvoker {

	/**
	 * Constructor of the class
	 */
	public DetailsServiceInvoker(){
		xmlReaderIdentifier = XMLReaderIdentifier.JAXB;
	}
	
	/**
	 * Gets the web service HTTP URL
	 */
	public String getWebServiceURL(BaseRequest request) {
		String webServiceUrl = PortalHelper
				.getWebServiceURL(PortalConstants.GET_APPTREQDETAILS_WS_URL_KEY);
		return webServiceUrl;
	}

	/**
	 * Gets the URL parameters to be filled in the web service URL
	 */
	public String getURLParameters(BaseRequest request) {
		StringBuffer parameterBuffer = new StringBuffer();
		// first add the patient id
		String patientId = request.getPatientId();
		if(patientId == null){
			patientId = "";
		}
		parameterBuffer.append(getCompleteParamString(
				PortalConstants.PATIENTID_REQUEST_PARAM_KEY, patientId));
		parameterBuffer.append("&");
		// next portal user
		String portalUserName = request.getPortalUserName();
		if(portalUserName == null){
			portalUserName = "";
		}
		parameterBuffer.append(getCompleteParamString(
				PortalConstants.PORTALUSER_REQUEST_PARAM_KEY, portalUserName));
		parameterBuffer.append("&");
		// next reference number
		DetailsRequest detailsRequest = (DetailsRequest) request;
		String referenceNumber = detailsRequest.getApptRequestReferenceNumber();
		if(referenceNumber == null){
			referenceNumber = "";
		}
		parameterBuffer.append(getCompleteParamString(
				RescheduleRequestConstants.GET_APPTREQUESTDETAILS_REFNUMBER_PARAM_KEY,
				referenceNumber));
		return parameterBuffer.toString();
	}

	/**
	 * returns the response object used in the get appointment request
	 * details web service
	 */
	public BaseResponse getResponseObject() {
		return new DetailsResponse();
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
		return new DetailsSvcImpl();
	}


	/**
	 * This method gets the required data from the underlying 
	 * service implementation
	 */
	public DetailsResponse getDataThroughService(DetailsRequest request) {
		DetailsSvcImpl svcImpl = new DetailsSvcImpl();
		return svcImpl.getApptRequestDetails(request);
	}

}
