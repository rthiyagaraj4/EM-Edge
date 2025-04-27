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
package portalrefimpl.result.detailedresult.svc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.common.serviceinvoker.AbstractServiceInvoker;
import portalrefimpl.common.svc.BaseService;
import portalrefimpl.result.ResultConstants;
import portalrefimpl.result.detailedresult.request.DetailedResultsRequest;
import portalrefimpl.result.detailedresult.response.DetailedResult;
import portalrefimpl.result.detailedresult.response.DetailedResultsResponse;
import portalrefimpl.result.detailedresult.response.ResultStatus;

/**
 * This is the service invoker for the detailed test results
 * @author GRamamoorthy
 *
 */
public class DetailedResultsServiceInvoker extends AbstractServiceInvoker {

	/**
	 * This method gets the web service URL to be used
	 * for accessing the detailed test result service
	 */
	public String getWebServiceURL(BaseRequest request) {
		String webserviceURL = PortalHelper
				.getWebServiceURL(PortalConstants.DETAILED_TESTRESULT_WS_URL_KEY);
		return webserviceURL;
	}

	/**
	 * This method returns the URL parameters
	 */
	public String getURLParameters(BaseRequest request) {
		// safely cast the request to the detailedresultsrequest object
		DetailedResultsRequest detailedResultsRequest = (DetailedResultsRequest) request;
		StringBuffer parameterBuffer = new StringBuffer();
		// first add the patient id
		parameterBuffer.append(PortalConstants.PATIENTID_REQUEST_PARAM_KEY).append("=");
		String patientId = detailedResultsRequest.getPatientId();
		if(patientId == null){
			patientId = "";
		}
		parameterBuffer.append(patientId);
		parameterBuffer.append("&");
		// next portal user
		parameterBuffer.append(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY).append("=");
		parameterBuffer.append(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
		parameterBuffer.append("&");

		// add order number to parameter
		String orderNumber = detailedResultsRequest.getOrderNumber();
		if(orderNumber == null){
			orderNumber = "";
		}
		parameterBuffer.append(ResultConstants.DETAILEDRESULTS_ORDERNUMBER_PARAM_KEY).append("=");
		parameterBuffer.append(orderNumber);
		
		parameterBuffer.append("&");
		
		// add location
		String location = detailedResultsRequest.getLocation();
		if(location == null){
			location = "";
		}
		parameterBuffer.append(ResultConstants.DETAILEDRESULTS_FACILITY_PARAM_KEY).append("=");
		parameterBuffer.append(location);
		
		parameterBuffer.append("&");
		
		// add order category
		String orderCategory = detailedResultsRequest.getOrderCategory();
		if(orderCategory == null){
			orderCategory = "";
		}
		parameterBuffer.append(ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_PARAM_KEY).append("=");
		parameterBuffer.append(orderCategory);
		
		parameterBuffer.append("&");
		
		// add from date
		String fromDateString = detailedResultsRequest.getFromDateString();
		if(fromDateString == null){
			fromDateString = "";
		}
		parameterBuffer.append(ResultConstants.DETAILEDRESULTS_FROMDATE_PARAM_KEY).append("=");
		parameterBuffer.append(fromDateString);
		
		parameterBuffer.append("&");
		// add to date
		String toDateString = detailedResultsRequest.getToDateString();
		if(toDateString == null){
			toDateString = "";
		}
		parameterBuffer.append(ResultConstants.DETAILEDRESULTS_TODATE_PARAM_KEY).append("=");
		parameterBuffer.append(toDateString);
		
		parameterBuffer.append("&");
		String initialResetValue = detailedResultsRequest.getInitialResetValue();
		if(initialResetValue == null){
			initialResetValue = ResultConstants.DETAILEDRESULTS_DEFAULT_INITIALRESET_VALUE;
		}
		parameterBuffer.append(
				ResultConstants.DETAILEDRESULTS_INITIALRESET_REQUEST_PARAM_KEY)
				.append("=");
		parameterBuffer.append(initialResetValue);
		
		return parameterBuffer.toString();
	}

	/**
	 * Returns the response object
	 */
	public BaseResponse getResponseObject() {
		return new DetailedResultsResponse();
	}

	/**
	 * This method reads the XML content and populates the response object
	 */
	public void readXMLContent(Document document, BaseResponse response) {
		//safely cast to detailed results response object
		DetailedResultsResponse detailedResultsResponse = (DetailedResultsResponse) response;
		/*ErrorInfo errorInfo = detailedResultsResponse.getErrorInfo();*/
		
		NodeList detailedResultsNodeList = document
				.getElementsByTagName(ResultConstants.DTLDRESULTS_XML_TAG);
		int detailedResultsNodeLength = detailedResultsNodeList != null ? detailedResultsNodeList
				.getLength() : 0;
				
		Node detailedResultsNode = null;
		Element detailedResultsElement = null;
		NodeList detailedResultNodeList = null;
		int detailedResultNodeListLength = 0;
		
		Node detailedResultNode = null;
		Element detailedResultElement = null;
		
		String orderCatalogue = null;
		String orderNumber = null;
		String location = null;
		String orderCategory = null;
		String orderDate = null;
		Date orderDateObj = null;
		String practitioner = null;
		String resultStatus = null;
		ResultStatus status = null;
		
		List<DetailedResult> detailedResultList = new ArrayList<DetailedResult>();
		DetailedResult detailedResult = null;
		// iterate through the patient details nodes
		// and populate data to the patient node
		for(int count=0;count<detailedResultsNodeLength;count++){
			detailedResultsNode = detailedResultsNodeList.item(count);
			
			if(Node.ELEMENT_NODE != detailedResultsNode.getNodeType()){
				continue;
			}
			
			detailedResultsElement = (Element)detailedResultsNode;
			detailedResultNodeList = detailedResultsElement
					.getElementsByTagName(ResultConstants.DTLDRESULTS_RESULT_XML_TAG);
			detailedResultNodeListLength = detailedResultNodeList != null ? detailedResultNodeList
					.getLength() : 0;
			
			// iterate through the nodes
			for(int nodeCnt=0;nodeCnt<detailedResultNodeListLength;nodeCnt++){
				detailedResultNode = detailedResultNodeList.item(nodeCnt);
				
				if(Node.ELEMENT_NODE != detailedResultNode.getNodeType()){
					continue;
				}
				
				detailedResultElement = (Element)detailedResultNode;
				
				// now start reading the individual elements
				// order catalogue
				orderCatalogue = getNodeValue(
						detailedResultElement,
						ResultConstants.DTLDRESULTS_RESULT_ORDERCATALOGUE_XML_TAG);
				
				// order number
				orderNumber = getNodeValue(detailedResultElement,
						ResultConstants.DTLDRESULTS_RESULT_ORDERNUMBER_XML_TAG);
				
				location = getNodeValue(detailedResultElement,
						ResultConstants.DTLDRESULTS_RESULT_LOCATION_XML_TAG);
				
				orderCategory = getNodeValue(
						detailedResultElement,
						ResultConstants.DTLDRESULTS_RESULT_ORDERCATEGORY_XML_TAG);
				
				orderDate = getNodeValue(detailedResultElement,
						ResultConstants.DTLDRESULTS_RESULT_ORDERDATE_XML_TAG);
				orderDateObj = PortalHelper
						.getDateFromString(
								orderDate,
								ResultConstants.DETAILEDRESULTS_DATETIMETOSTRING_FORMAT);
				
				
				practitioner = getNodeValue(detailedResultElement,
						ResultConstants.DTLDRESULTS_RESULT_PRACTITIONER_XML_TAG);
				
				resultStatus = getNodeValue(detailedResultElement,
						ResultConstants.DTLDRESULTS_RESULT_STATUS_XML_TAG);
				status = ResultStatus.valueOf(resultStatus);
				
				// initialize and populate the detailedresult object
				detailedResult = new DetailedResult();
				detailedResult.setLocation(location);
				detailedResult.setOrderCatalogue(orderCatalogue);
				detailedResult.setOrderCategory(orderCategory);
				detailedResult.setOrderDate(orderDateObj);
				detailedResult.setOrderNumber(orderNumber);
				detailedResult.setOrderPractitioner(practitioner);
				detailedResult.setResultStatus(status);
				// add the detailedresult object to the list
				detailedResultList.add(detailedResult);
				
			}
		}
		
		
		// last minute check - if there is no data then
		// set error info 
		ErrorInfo errorInfo = new ErrorInfo();
		if(detailedResultList.isEmpty()){
			errorInfo.setErrorCode(ResultConstants.DTLD_RESULT_EMPTYDATA_CODE);
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.DETAILED_TESTRESULT_MODULE_NAME,
							ResultConstants.DTLD_RESULT_EMPTYDATA_CODE);
			errorInfo.setErrorMessage(errorMessage);
			detailedResultsResponse.addError(errorInfo);
			
		}else{
			errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);	
			// this is a last ditch attempt to set error information in the response
			// this is just a safe code
			if(!detailedResultsResponse.hasErrors()){
				detailedResultsResponse.addError(errorInfo);
			}
		}
		
		
		// finally set the list to the response object
		detailedResultsResponse.setTestResultList(detailedResultList);
		
	}

	/**
	 * This method returns an instance of the impl class
	 * used for performing the business operation 
	 */
	protected BaseService getServiceImpl() {
		return new DetailedResultsSvcImpl();
	}

	/**
	 * This method gets the required data from the underlying 
	 * service implementation
	 */
	public BaseResponse getDataThroughService(DetailedResultsRequest request) {
		DetailedResultsSvcImpl svcImpl = new DetailedResultsSvcImpl();
		return svcImpl.getDetailedResults(request);
	}

}
