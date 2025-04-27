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
package portalrefimpl.homepage.svc;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.serviceinvoker.AbstractServiceInvoker;
import portalrefimpl.common.svc.BaseService;
import portalrefimpl.homepage.HomePageConstants;
import portalrefimpl.homepage.request.HospitalDetailsRequest;
import portalrefimpl.homepage.response.HospitalDetailsResponse;

/**
 * This is the service invoker class for the hospital details service method
 * part of the home page service
 * @author GRamamoorthy
 *
 */
public class HospitalDetailsServiceInvoker extends AbstractServiceInvoker {

	/**
	 * This method gives the hospital details web service URL
	 */
	public String getWebServiceURL(BaseRequest request) {
		String webServiceUrl = PortalHelper
				.getWebServiceURL(PortalConstants.HOMEPAGE_WS_URL_KEY);
		return webServiceUrl;
	}

	/**
	 * This method gets the URL parameters to be passed
	 * to hospital details service method
	 */
	public String getURLParameters(BaseRequest request) {
		// safely cast to HospitalDetailsRequest 
		HospitalDetailsRequest hospitalDetailsRequest = (HospitalDetailsRequest) request;
		StringBuffer paramBuff = new StringBuffer();
		String facilityId = hospitalDetailsRequest.getFacilityId();
		if(facilityId == null){
			facilityId = "";
		}
		paramBuff.append("facilityId=").append(facilityId);
		paramBuff.append("&");
		paramBuff.append(HomePageConstants.METHOD_NAME).append("=");
		paramBuff.append(HomePageConstants.GETHOSPITALDETAILS_METHOD_KEY);
		paramBuff.append("&");
		paramBuff.append(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY).append("=");
		paramBuff.append(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
		
		return paramBuff.toString();
	}

	/**
	 * This method returns the response object for hospital details
	 * service method
	 */
	public BaseResponse getResponseObject() {
		return new HospitalDetailsResponse();
	}

	/**
	 * This is a very important method
	 * This method reads the document object and forms the 
	 * hospital details response with data
	 */
	public void readXMLContent(Document document, BaseResponse response) {
		NodeList hospitalDetailsNodeList = document
				.getElementsByTagName(HomePageConstants.HOSPITALDETAILS_XML_TAG);
	}

	/**
	 * This method returns an instance of the impl class
	 * used for performing the business operation 
	 */
	protected BaseService getServiceImpl() {
		return new HomePageSvcImpl();
	}

	/**
	 * This method gets the required data from the underlying 
	 * service implementation
	 */
	public HospitalDetailsResponse getDataThroughService(HospitalDetailsRequest request){
		HomePageSvcImpl svcImpl = new HomePageSvcImpl();
		return svcImpl.getHospitalDetails(request);
	}
	
}
