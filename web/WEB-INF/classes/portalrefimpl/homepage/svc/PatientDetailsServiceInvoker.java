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

import java.util.Date;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.common.serviceinvoker.AbstractServiceInvoker;
import portalrefimpl.common.svc.BaseService;
import portalrefimpl.homepage.HomePageConstants;
import portalrefimpl.homepage.request.PatientDetailsRequest;
import portalrefimpl.homepage.response.PatientDetailsResponse;

/**
 * This is the service invoker class for the patient details service method
 * part of the home page service
 * @author GRamamoorthy
 *
 */
public class PatientDetailsServiceInvoker extends AbstractServiceInvoker {

	/**
	 * This method gives the patient details web service URL
	 */
	public String getWebServiceURL(BaseRequest request) {
		String webServiceUrl = PortalHelper
				.getWebServiceURL(PortalConstants.HOMEPAGE_WS_URL_KEY);
		return webServiceUrl;
	}

	/**
	 * This method gets the URL parameters to be passed
	 * to patient details service method
	 */
	public String getURLParameters(BaseRequest request) {
		StringBuffer paramBuff = new StringBuffer();
		// safely cast to PatientDetailsRequest object
		PatientDetailsRequest patientDetailsRequest = (PatientDetailsRequest)request;
		String patientId = patientDetailsRequest.getPatientId();
		if(patientId == null){
			patientId = "";
		}
		paramBuff.append(PortalConstants.PATIENTID_REQUEST_PARAM_KEY).append("=");
		paramBuff.append(patientId);
		paramBuff.append("&");
		paramBuff.append(HomePageConstants.METHOD_NAME).append("=");
		paramBuff.append(HomePageConstants.GETPATIENTDETAILS_METHOD_KEY);
		paramBuff.append("&");
		paramBuff.append(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY).append("=");
		paramBuff.append(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
		
		return paramBuff.toString();
	}

	/**
	 * This method returns the response object for patient details
	 * service method
	 */
	public BaseResponse getResponseObject() {
		return new PatientDetailsResponse();
	}

	/**
	 * This is a very important method
	 * This method reads the document object and forms the 
	 * patient details response with data
	 */
	public void readXMLContent(Document document, BaseResponse response) {
		//safely cast to patient details response
		PatientDetailsResponse patientDetailsResponse = (PatientDetailsResponse) response;
		/*ErrorInfo errorInfo = patientDetailsResponse.getErrorInfo();
		errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);*/
		
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
		patientDetailsResponse.addError(errorInfo);
		
		// get the nodes from the document
		NodeList patientDetailsNodeList = document
				.getElementsByTagName(HomePageConstants.PATIENT_DETAILS_XML_TAG);
		int patientDetailsNodeLength = patientDetailsNodeList != null ? patientDetailsNodeList
				.getLength() : 0;
		
		Node patientDetailsNode = null;
		NodeList patientIdNodeList = null;
		NodeList nationalIdNodeList = null;
		NodeList patientNameNodeList = null;
		NodeList patientDisplayNameNodeList = null;
		NodeList sexNodeList = null;
		NodeList dobNodeList = null;
		NodeList ageNodeList = null;
		
		String patientId = null;
		String nationalId = null;
		String patientName = null;
		String patientDisplayName = null;
		String sex = null;
		String dob = null;
		String age = null;
		
		// iterate through the patient details nodes
		// and populate data to the patient node
		for(int count=0;count<patientDetailsNodeLength;count++){
			patientDetailsNode = patientDetailsNodeList.item(count);
			
			if(Node.ELEMENT_NODE == patientDetailsNode.getNodeType()){
				Element patientDetailNode = (Element)patientDetailsNode;
				// patient id
				patientIdNodeList = patientDetailNode
						.getElementsByTagName(HomePageConstants.PATIENTID_XML_TAG);
				if (patientIdNodeList != null) {
					Element patientIdElement = (Element) patientIdNodeList
							.item(0);

					NodeList patientIdChildNodeList = patientIdElement
							.getChildNodes();
					Node patientIdNode = ((Node) patientIdChildNodeList.item(0));
					patientId = patientIdNode != null ? patientIdNode
							.getNodeValue() : null;
					if (patientId == null) {
						patientId = "";
					}
					// set patient id to response
					patientDetailsResponse.setPatientId(patientId);
				}
				
				// national id 
				nationalIdNodeList = patientDetailNode
						.getElementsByTagName(HomePageConstants.NATIIONALID_XML_TAG);
				if (nationalIdNodeList != null) {
					Element nationalIdElement = (Element) nationalIdNodeList
							.item(0);

					NodeList nationalIdChildNodeList = nationalIdElement
							.getChildNodes();
					Node nationalIdNode = ((Node) nationalIdChildNodeList
							.item(0));
					nationalId = nationalIdNode != null ? nationalIdNode
							.getNodeValue() : null;
					if (nationalId == null) {
						nationalId = "";
					}
					// set national id to response
					patientDetailsResponse.setNationalId(nationalId);
				}
				
				// patient name
				patientNameNodeList = patientDetailNode
						.getElementsByTagName(HomePageConstants.PATIENTNAME_XML_TAG);
				if (patientNameNodeList != null) {
					Element patientNameElement = (Element) patientNameNodeList
							.item(0);
					NodeList patientNameChildNodeList = patientNameElement
							.getChildNodes();
					Node patientNameNode = ((Node) patientNameChildNodeList
							.item(0));
					patientName = patientNameNode != null ? patientNameNode
							.getNodeValue() : null;
					if (patientName == null) {
						patientName = "";
					}
					// set patient name to response
					patientDetailsResponse.setPatientName(patientName);
				}
				
				// patient display name
				patientDisplayNameNodeList = patientDetailNode
						.getElementsByTagName(HomePageConstants.PATIENT_DISPLAYNAME_XML_TAG);
				if (patientDisplayNameNodeList != null) {
					Element patientDisplayNameElement = (Element) patientDisplayNameNodeList
							.item(0);
					NodeList patientDisplayNameChildNodeList = patientDisplayNameElement
							.getChildNodes();
					Node patientDisplayNameNode = ((Node) patientDisplayNameChildNodeList
							.item(0));
					patientDisplayName = patientDisplayNameNode != null ? patientDisplayNameNode
							.getNodeValue() : null;
					if (patientDisplayName == null) {
						patientDisplayName = "";
					}
					// set display name to response
					patientDetailsResponse.setPatientDisplayName(patientDisplayName);
				}
				
				// sex
				sexNodeList = patientDetailNode
						.getElementsByTagName(HomePageConstants.PATIENTSEX_XML_TAG);
				if (sexNodeList != null) {
					Element sexElement = (Element) sexNodeList
							.item(0);
					NodeList sexChildNodeList = sexElement
							.getChildNodes();
					Node sexNode = ((Node) sexChildNodeList
							.item(0));
					sex = sexNode != null ? sexNode
							.getNodeValue() : null;
					if (sex == null) {
						sex = "";
					}
					// set sex to response
					patientDetailsResponse.setSex(sex);
				}
				
				// dob
				dobNodeList = patientDetailNode
						.getElementsByTagName(HomePageConstants.DATEOFBIRTH_XML_TAG);
				if (dobNodeList != null) {
					Element dobElement = (Element) dobNodeList
							.item(0);
					NodeList dobChildNodeList = dobElement
							.getChildNodes();
					Node dobNode = ((Node) dobChildNodeList
							.item(0));
					dob = dobNode != null ? dobNode
							.getNodeValue() : null;
					if (dob == null) {
						dob = "";
					}
					// set dob to response
					Date dateOfBirth = PortalHelper.getDateFromString(dob,
							HomePageConstants.PATIENTDETAILS_DATEFORMAT);
					patientDetailsResponse.setDateOfBirth(dateOfBirth);
				}
			}
		}
		
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
	public PatientDetailsResponse getDataThroughService(PatientDetailsRequest request){
		HomePageSvcImpl svcImpl = new HomePageSvcImpl();
		return svcImpl.getPatientDetails(request);
	}
	
}
