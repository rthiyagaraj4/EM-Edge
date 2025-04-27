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
package portalrefimpl.facility.facilityforcontact.svc;

import java.util.List;

import org.w3c.dom.Document;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.serviceinvoker.AbstractServiceInvoker;
import portalrefimpl.common.serviceinvoker.XMLReaderIdentifier;
import portalrefimpl.common.svc.BaseService;
import portalrefimpl.facility.FacilityConstants;
import portalrefimpl.facility.facilityforcontact.request.FacilityForContactRequest;
import portalrefimpl.facility.facilityforcontact.response.FacilityForContactResponse;

/**
 * This is the client class for the facility for contact web service
 * 
 * @author GRamamoorthy
 * 
 */
public class FacilityForContactServiceInvoker extends AbstractServiceInvoker {

	/**
	 * Default constructor of the class
	 */
	public FacilityForContactServiceInvoker(){
		// set xmlReaderIdentifier to XMLReaderIdentifier.JAXB if JAXB
		// unmarshalling is expected
		xmlReaderIdentifier = XMLReaderIdentifier.JAXB;
	}
	
	/**
	 * This method returns the HTTP URL for web service
	 */
	public String getWebServiceURL(BaseRequest request) {
		String serviceURL = PortalHelper
				.getWebServiceURL(PortalConstants.FACILITY_FOR_CONTACT_WS_URL_KEY);
		return serviceURL;
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
				PortalConstants.PORTALUSER_REQUEST_PARAM_KEY, portalUserName));
		parameterBuffer.append("&");
		// safely cast - no worries
		FacilityForContactRequest facilityRequest = (FacilityForContactRequest) request;
		// facility ids
		List<String> facilityIds = facilityRequest.getFacilityIds();
		if (facilityIds != null && !facilityIds.isEmpty()) {
			StringBuffer facilityIdsBuffer = new StringBuffer();
			int facilitySize = facilityIds.size();
			String facilityId = null;
			for (int count = 0; count < facilitySize; count++) {
				facilityId = facilityIds.get(count);
				facilityIdsBuffer.append(facilityId);
				if (count != (facilitySize - 1)) {
					facilityIdsBuffer
							.append(FacilityConstants.FACILITY_FORCONTACT_FACILITYIDS_DELIMITER);
				}
			}
			parameterBuffer
					.append(getCompleteParamString(
							FacilityConstants.FACILITY_FORCONTACT_FACILITYIDS_REQUEST_PARAM_KEY,
							facilityIdsBuffer.toString()));
			parameterBuffer.append("&");
		}
		// facility record count
		int recordCount = facilityRequest.getFacilityCount();
		if (recordCount != 0) {
			parameterBuffer
					.append(getCompleteParamString(
							FacilityConstants.FACILITY_FORCONTACT_FACILITY_RECORD_COUNT_REQUEST_PARAM_KEY,
							"" + recordCount));
		}
		return parameterBuffer.toString();
	}

	/**
	 * This method creates a new instance of the response object and returns the
	 * same
	 * 
	 */
	public BaseResponse getResponseObject() {
		return new FacilityForContactResponse();
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
		return new FacilityForContactSvcImpl();
	}

	/**
	 * This method gets the required data from the underlying 
	 * service implementation
	 */
	public FacilityForContactResponse getDataThroughService(FacilityForContactRequest request) {
		FacilityForContactSvcImpl svcImpl = new FacilityForContactSvcImpl();
		return svcImpl.getFacilitiesForContact(request);
	}

}
