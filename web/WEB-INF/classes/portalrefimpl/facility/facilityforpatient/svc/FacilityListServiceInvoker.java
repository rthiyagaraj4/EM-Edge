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
package portalrefimpl.facility.facilityforpatient.svc;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.model.Facility;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.common.serviceinvoker.AbstractServiceInvoker;
import portalrefimpl.common.svc.BaseService;
import portalrefimpl.facility.FacilityConstants;
import portalrefimpl.facility.facilityforpatient.request.FacilityListRequest;
import portalrefimpl.facility.facilityforpatient.response.FacilityListResponse;

/**
 * This is the service invoker implementation for facility list service
 * @author GRamamoorthy
 *
 */
public class FacilityListServiceInvoker extends AbstractServiceInvoker {

	/**
	 * Returns the web service url for facility list service
	 */
	public String getWebServiceURL(BaseRequest request) {
		String webserviceURL = PortalHelper
				.getWebServiceURL(PortalConstants.FACILITY_LIST_WS_URL_KEY);
		return webserviceURL;
	}

	/**
	 * This method returns the request parameters for the facility list
	 * web service
	 */
	public String getURLParameters(BaseRequest request) {
		// safely cast the request to the facilityListRequest object
		FacilityListRequest facilityListRequest = (FacilityListRequest)request;
		// the request parameters for this service consists of the portalusername
		// parameter alone as of now
		StringBuffer paramBuffer = new StringBuffer();
		String portalUserName = facilityListRequest.getPortalUserName();
		
		paramBuffer.append(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY);
		paramBuffer.append("=");
		paramBuffer.append(portalUserName);
		
		// optional record count parameter
		int recordCount = facilityListRequest.getRecordCount();
		paramBuffer.append("&");
		paramBuffer.append(FacilityConstants.FACILITY_FORPATIENT_RECORDCOUNT_REQUEST_PARAM);
		paramBuffer.append("=");
		paramBuffer.append(recordCount);
		
		return paramBuffer.toString();
	}

	/**
	 * Return the facilitylistresponse object
	 */
	public BaseResponse getResponseObject() {
		return new FacilityListResponse();
	}

	/**
	 * This method reads the xml content of the facility list
	 * response represented by the document object and 
	 * populates data to the FacilityListResponse object
	 */
	public void readXMLContent(Document document, BaseResponse response) {
		// safely cast the response object to facilityListResponse object
		FacilityListResponse facilityListResponse = (FacilityListResponse) response;
		// set positive response
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
		facilityListResponse.addError(errorInfo);
		
		NodeList facilitiesNodeList = document
				.getElementsByTagName(FacilityConstants.FACILITIES_XML_TAG);
		int facilitiesNodeLength = facilitiesNodeList != null? facilitiesNodeList.getLength():0;
		
		Node facilitiesNode = null;
		Element facilitiesElement = null;
		
		NodeList facilityNodeList = null;
		// iterate through the facilities node and get 
		// data from the dom nodes
		for(int count=0;count<facilitiesNodeLength;count++){
			facilitiesNode = facilitiesNodeList.item(count);
			
			if(Node.ELEMENT_NODE != facilitiesNode.getNodeType()){
				continue;
			}
			
			facilitiesElement = (Element)facilitiesNode;
			
			facilityNodeList = facilitiesElement
					.getElementsByTagName(FacilityConstants.FACILITY_XML_TAG);
			// get the list of facility objects
			List<Facility> facilityList = getFacilityList(facilityNodeList);
			facilityListResponse.setFacilityList(facilityList);
		}
		
	}
	
	/**
	 * This method returns the list of facilities given the facility 
	 * nodeList object
	 * @param facilityNodeList
	 * @return
	 */
	private List<Facility> getFacilityList(NodeList facilityNodeList){
		List<Facility> facilityList = new ArrayList<Facility>();
		
		int facilityNodeLength = facilityNodeList != null ? facilityNodeList
				.getLength() : 0;
		Node facilityNode = null;
		Element facilityElement = null;
		Facility facility = null;
		String facilityId = null;
		String facilityName = null;
		// iterate through the facility nodes and form the facility object
		for(int count=0;count<facilityNodeLength;count++){
			facilityNode = facilityNodeList.item(count);
			
			if(Node.ELEMENT_NODE != facilityNode.getNodeType()){
				continue;
			}
			// initialize the facility object
			facility = new Facility();
			
			facilityElement = (Element)facilityNode;
			// get the facility id value
			facilityId = getNodeValue(facilityElement,
					FacilityConstants.FACILITYID_XML_TAG);
			// safe check
			if(facilityId == null){
				facilityId = "";
			}
			
			facility.setFacilityId(facilityId);
			
			// get the facility name
			facilityName = getNodeValue(facilityElement,
					FacilityConstants.FACILITYNAME_XML_TAG);
			// safe check
			if(facilityName == null){
				facilityName = "";
			}
			
			facility.setFacilityName(facilityName);
			
			// now add the facility object to the list
			facilityList.add(facility);
		}
		
		return facilityList;
	}

	/**
	 * This method returns an instance of the impl class
	 * used for performing the business operation 
	 */
	protected BaseService getServiceImpl() {
		return new FacilityListSvcImpl();
	}
	
	/**
	 * This method gets the required data from the underlying 
	 * service implementation
	 */
	public FacilityListResponse getDataThroughService(FacilityListRequest request){
		FacilityListSvcImpl svcImpl = new FacilityListSvcImpl();
		return svcImpl.getFacilityList(request);
	}

}
