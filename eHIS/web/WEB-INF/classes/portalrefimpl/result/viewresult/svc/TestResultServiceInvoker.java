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
package portalrefimpl.result.viewresult.svc;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
import portalrefimpl.result.viewresult.request.TestResultRequest;
import portalrefimpl.result.viewresult.response.TestResult;
import portalrefimpl.result.viewresult.response.TestResultResponse;

/**
 * This is the ServiceInvoker implementation for Test Result Service
 * @author GRamamoorthy
 *
 */
public class TestResultServiceInvoker extends AbstractServiceInvoker {

	/**
	 * This method gets the web service URL to be used
	 * for accessing the test result service
	 */
	public String getWebServiceURL(BaseRequest request) {
		String webserviceURL = PortalHelper
				.getWebServiceURL(PortalConstants.TESTRESULT_WS_URL_KEY);
		return webserviceURL;
	}

	/**
	 * This method gets the URL parameters
	 * for the test result service
	 */
	public String getURLParameters(BaseRequest request) {
		StringBuffer parameterBuffer = new StringBuffer();
		// safely cast to the test result request
		TestResultRequest testResultRequest = (TestResultRequest)request;
		// first add the patient id
		String patientId = testResultRequest.getPatientId();
		parameterBuffer.append(getCompleteParamString(
				PortalConstants.PATIENTID_REQUEST_PARAM_KEY, patientId));
		parameterBuffer.append("&");
		// next portal user
		parameterBuffer.append(getCompleteParamString(
				PortalConstants.PORTALUSER_REQUEST_PARAM_KEY,
				PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE));
		parameterBuffer.append("&");
		
		String orderNumber = testResultRequest.getOrderNumber();
		parameterBuffer.append(getCompleteParamString(
				ResultConstants.TESTRESULT_ORDERID_REQUEST_PARAM_KEY,
				orderNumber));
		parameterBuffer.append("&");
		
		String order = testResultRequest.getOrder();
		try {
			order = URLEncoder.encode(order, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			order = testResultRequest.getOrder();
		}
		parameterBuffer.append(getCompleteParamString(
				ResultConstants.TESTRESULT_ORDER_REQUEST_PARAM_KEY,
				order));
		parameterBuffer.append("&");
		
		String resultType = testResultRequest.getResultType();
		parameterBuffer.append(getCompleteParamString(
				ResultConstants.TESTRESULT_RESULTTYPE_REQUEST_PARAM_KEY,
				resultType));
		
		return parameterBuffer.toString();
	}

	/**
	 * This method returns the response object to be used for
	 * test result service
	 */
	public BaseResponse getResponseObject() {
		return new TestResultResponse();
	}

	/**
	 * This method reads the document object and puts data into
	 * the response
	 * Data is basically the test results
	 */
	public void readXMLContent(Document document, BaseResponse response) {
		// when control comes here, the response has to be a success response
		// safely cast to TestResultResponse object
		TestResultResponse testResultResponse = (TestResultResponse)response;
		/*ErrorInfo errorInfo = testResultResponse.getErrorInfo();*/
		
		
		
		ErrorInfo errorInfo =  null;
		NodeList testResultNodeList = document
				.getElementsByTagName(ResultConstants.TR_RESPONSE_PARENT_XML_TAG);
		//int testResultNodeListLength = testResultNodeList.getLength();
		Node testResultNode = testResultNodeList.item(0);
		// safe check
		if(Node.ELEMENT_NODE != testResultNode.getNodeType()){
			testResultResponse.setTestResultList(new ArrayList<TestResult>());
			int errorCode = ResultConstants.TESTRESULT_DATA_NOTOBTAINED_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.TESTRESULT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			testResultResponse.addError(errorInfo);
			return;
		}
		
		Element testResultElement = (Element)testResultNode;
		// get the order number
		String orderNumber = getNodeValue(testResultElement,
				ResultConstants.TR_RESPONSE_ORDERNUMBER_XML_TAG);
		testResultResponse.setOrderNumber(orderNumber);
		
		// get the order 
		String order = getNodeValue(testResultElement,
				ResultConstants.TR_RESPONSE_ORDER_XML_TAG);
		testResultResponse.setOrder(order);
		
		// get the result type
		String resultType = getNodeValue(testResultElement,
				ResultConstants.TR_RESPONSE_RESULTTYPE_XML_TAG);
		testResultResponse.setResultType(resultType);
		
		// get the published date
		String publishedDateString = getNodeValue(testResultElement,
				ResultConstants.TR_RESPONSE_PUBLISHDATE_XML_TAG);
		Date publishedDate = PortalHelper.getDateFromString(
				publishedDateString,
				ResultConstants.TESTRESULT_RESPONSE_PUBLISHDATE_FORMAT);
		testResultResponse.setPublishDate(publishedDate);
		
		// now the individual results
		// get the results node
		NodeList resultsNodeList = testResultElement
				.getElementsByTagName(ResultConstants.TR_RESPONSE_RESULTS_XML_TAG);
		Node resultsNode = resultsNodeList.item(0);
		// safe check
		if(Node.ELEMENT_NODE != resultsNode.getNodeType()){
			testResultResponse.setTestResultList(new ArrayList<TestResult>());
			int errorCode = ResultConstants.TESTRESULT_DATA_NOTOBTAINED_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.TESTRESULT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			testResultResponse.addError(errorInfo);
			return;
		}
		
		Element resultsElement = (Element)resultsNode;
		NodeList resultNodeList = resultsElement
				.getElementsByTagName(ResultConstants.TR_RESPONSE_RESULT_XML_TAG);
		// get the test result list
		List<TestResult> testResultList = getTestResultList(resultNodeList);
		testResultResponse.setTestResultList(testResultList);

		errorInfo = new ErrorInfo();
		if(testResultList.isEmpty()){
			int errorCode = ResultConstants.TESTRESULT_DATA_NOTOBTAINED_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.TESTRESULT_MODULE_NAME,
							errorCode);
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
		}else{
			errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
		}
		
		testResultResponse.addError(errorInfo);
		/*NodeList orderNumberNodeList = testResultElement
				.getElementsByTagName(ResultConstants.TR_RESPONSE_ORDERNUMBER_XML_TAG);
		Node orderNumberNode = orderNumberNodeList != null?orderNumberNodeList.item(0):null;
		// safe check
		if(orderNumberNode == null){
			return;
		}
		// again a safe check
		if(Node.ELEMENT_NODE != orderNumberNode.getNodeType()){
			return;
		}
		Element orderNumberElement = (Element) orderNumberNode;
		NodeList orderNumberChildNodeList = orderNumberElement.getChildNodes();*/
		
	}

	/**
	 * This method returns a list of test result objects
	 * @param resultNodeList
	 * @return
	 */
	private List<TestResult> getTestResultList(NodeList resultNodeList){
		List<TestResult> testResultList = new ArrayList<TestResult>();
		int resultNodeLength = resultNodeList != null? resultNodeList.getLength():0;
		TestResult testResult = null;
		Node testResultNode = null;
		Element testResultElement = null;
		String resultValue = "";
		String resultUOM = "";
		String resultStr = "";
		String publishDateString = "";
		Date publishDate = null;
		String practitionerId = "";
		String reportingPractId = "";
		String notes = "";
		String normalLow = "";
		String normalHigh = "";
		String criticalLow = "";
		String criticalHigh = "";
		String resultOrder = "";
		// iterate through the different result nodes and form
		// testResult objects
		for(int count=0;count<resultNodeLength;count++){
			testResultNode = resultNodeList.item(count);
			if(Node.ELEMENT_NODE != testResultNode.getNodeType()){
				continue;
			}
			testResultElement = (Element)testResultNode;
			// get all the values
			resultValue = getNodeValue(testResultElement,
					ResultConstants.TR_RESPONSE_RESULT_VALUE_XML_TAG);
			resultUOM = getNodeValue(testResultElement,
					ResultConstants.TR_RESPONSE_RESULT_UOM_XML_TAG);
			resultStr = getNodeValue(testResultElement,
					ResultConstants.TR_RESPONSE_RESULT_STR_XML_TAG);
			// for publish date alone, string value is obtained and from
			// that date value is obtained
			publishDateString = getNodeValue(testResultElement,
					ResultConstants.TR_RESPONSE_RESULT_PUBLISHDATE_XML_TAG);
			publishDate = PortalHelper.getDateFromString(publishDateString,
					ResultConstants.TESTRESULT_RESPONSE_PUBLISHDATE_FORMAT);
			practitionerId = getNodeValue(testResultElement,
					ResultConstants.TR_RESPONSE_RESULT_PRACTITIONERID_XML_TAG);
			reportingPractId = getNodeValue(testResultElement,
					ResultConstants.TR_RESPONSE_RESULT_REPORTINGPRACTID_XML_TAG);
			notes = getNodeValue(testResultElement,
					ResultConstants.TR_RESPONSE_RESULT_NOTES_XML_TAG);
			normalLow = getNodeValue(testResultElement,
					ResultConstants.TR_RESPONSE_RESULT_NORMALLOW_XML_TAG);
			normalHigh = getNodeValue(testResultElement,
					ResultConstants.TR_RESPONSE_RESULT_NORMALHIGH_XML_TAG);
			criticalLow = getNodeValue(testResultElement,
					ResultConstants.TR_RESPONSE_RESULT_CRITICALLOW_XML_TAG);
			criticalHigh = getNodeValue(testResultElement,
					ResultConstants.TR_RESPONSE_RESULT_CRITICALHIGH_XML_TAG);
			resultOrder = getNodeValue(testResultElement,
					ResultConstants.TR_RESPONSE_RESULT_ORDER_XML_TAG);
			
			testResult = new TestResult();
			testResult.setResultValue(resultValue);
			testResult.setResultUOM(resultUOM);
			testResult.setResultStrValue(resultStr);
			testResult.setResultPublishDate(publishDate);
			testResult.setPractitionerId(practitionerId);
			testResult.setReportingPractitionerId(reportingPractId);
			testResult.setNotesContent(notes);
			testResult.setNormalLowValue(normalLow);
			testResult.setNormalHighValue(normalHigh);
			testResult.setCriticalLowValue(criticalLow);
			testResult.setCriticalHighValue(criticalHigh);
			testResult.setOrder(resultOrder);
			
			// add the test result object to the list
			testResultList.add(testResult);
		}
		
		
		return testResultList;
	}

	/**
	 * This method returns an instance of the impl class
	 * used for performing the business operation 
	 */
	protected BaseService getServiceImpl() {
		return new TestResultSvcImpl();
	}
	
	/**
	 * This method gets the required data from the underlying 
	 * service implementation
	 */
	public TestResultResponse getDataThroughService(TestResultRequest request){
		TestResultSvcImpl svcImpl = new TestResultSvcImpl();
		return svcImpl.getTestResult(request);
	}
	
}
