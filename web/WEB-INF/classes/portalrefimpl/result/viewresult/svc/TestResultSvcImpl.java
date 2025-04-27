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

import java.io.ByteArrayInputStream;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Provider;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.request.ValidationRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.common.response.ValidationResponse;
import portalrefimpl.common.svc.BaseServiceImpl;
import portalrefimpl.result.ResultConstants;
import portalrefimpl.result.viewresult.bc.TestResultBC;
import portalrefimpl.result.viewresult.request.TestResultRequest;
import portalrefimpl.result.viewresult.response.TestResult;
import portalrefimpl.result.viewresult.response.TestResultResponse;

/**
 * This is the service implementation class for Test Result
 * This class extends BaseServiceImpl class and implements
 * the service interface for test result and the interface
 * which will make this class as web service impl class
 * @author GRamamoorthy
 *
 */
@WebServiceProvider
public class TestResultSvcImpl extends BaseServiceImpl implements
		TestResultSvc, Provider<Source> {

	/**
	 * This method registers the HTTP URL for the test result service
	 * with the end point
	 */
	public void registerService(BaseRequest request) {
		Endpoint e = Endpoint
				.create(HTTPBinding.HTTP_BINDING, this);
		String serviceURL = PortalHelper
				.getWebServiceURL(PortalConstants.TESTRESULT_WS_URL_KEY);
		e.publish(serviceURL);
	}

	/**
	 * This method validates the test result request
	 */
	public BaseResponse isValidRequest(BaseRequest request) {
		ValidationRequest validationRequest = new ValidationRequest();
		validationRequest.setPortalUserName(request.getPortalUserName());
		// code added to check if the request is part of a web service call
		validationRequest.setServiceCall(request.isServiceCall());
		ValidationResponse validationResponse = isValidRequestor(validationRequest);
		
		TestResultResponse response = new TestResultResponse();
		if(!validationResponse.isSuccessful()){
			response.addAllErrors(validationResponse.getErrors());	
		}
		
		/*ErrorInfo errorInfo = validationResponse.getErrorInfo();*/
		// request has failed basic validation - so return error response
		/*if(ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()){
			response.setErrorInfo(errorInfo);
			return response;
		}*/
		/*response.setErrorInfo(errorInfo); */
		
		
		
		ErrorInfo errorInfo = null;
		// now validate the request's other details
		// there is a need to validate the patient id and the order id
		TestResultRequest testResultRequest = (TestResultRequest) request;
		String patientId = testResultRequest.getPatientId();
		if(patientId == null || patientId.trim().equals("")){
			int errorCode = ResultConstants.TESTRESULT_PATIENTID_ABSENT_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.TESTRESULT_MODULE_NAME,
							errorCode);
			
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			response.addError(errorInfo);
			/*return response;*/
		}
		
		String orderId = testResultRequest.getOrderNumber();
		if(orderId == null || orderId.trim().equals("")){
			int errorCode = ResultConstants.TESTRESULT_ORDERID_ABSENT_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.TESTRESULT_MODULE_NAME,
							errorCode);
			
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			response.addError(errorInfo);
		}
		
		// when code comes here, response has either got errors
		// or all the validation has passed
		// if all the validation has passed, then we need to set
		// a positive error
		if(!response.hasErrors()){
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
			response.addError(errorInfo);
		}
		
		return response;
	}
	
	
	/**
	 * This method gets the test result given the request object
	 */
	public TestResultResponse getTestResult(TestResultRequest testResultRequest) {
		// initialize the response object
		TestResultResponse testResultResponse = null;
		
		// first step - validate the request
		// if validation fails return the response
		testResultResponse = (TestResultResponse)isValidRequest(testResultRequest);
		if(!testResultResponse.isSuccessful()){
			return testResultResponse;
		}
		/*ErrorInfo errorInfo = testResultResponse.getErrorInfo();
		if(ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()){
			return testResultResponse;
		}*/
		
		// proceed to second step only after validation succeeds
		// second step - get the test result
		/*ApplicationContext context = new ClassPathXmlApplicationContext("app-beans.xml");*/
		TestResultBC bcInst = null;
		/*bcInst = (TestResultBC)context.getBean("refTestResultBC");*/
		bcInst = new TestResultBC();
		testResultResponse = bcInst.getTestResult(testResultRequest);
		
		return testResultResponse;
	}

	/**
	 * This is the main method of the web service
	 * This method is invoked when the http URL for the service
	 * is hit 
	 */
	public Source invoke(Source arg0) {
		StreamSource reply = null;
		String xmlFileContent = "";
		
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String)mc.get(MessageContext.QUERY_STRING);
			Map<String, String> parameterMap = getRequestParameterMap(path);
			TestResultRequest testResultRequest = getTestResultRequest(parameterMap);
			TestResultResponse testResultResponse = getTestResult(testResultRequest);
			
			xmlFileContent = getTestResultXML(testResultResponse);
		}catch (Exception e) {
			// need to form an error info object as the xml output here
			int errorCode = CommonConstants.WEBSERVICE_EXCEPTION_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
							errorCode);
			// there is a need to fill in the web service
			// name in the error message using format
			errorMessage = MessageFormat
					.format(errorMessage,
							new Object[] { CommonConstants.TESTRESULT_SVC_NAME_KEY });
			StringBuffer xmlContentBuff = new StringBuffer();
			xmlContentBuff
					.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
			/*createErrorResponse(errorMessage, errorCode, xmlContentBuff);*/
			populateXMLForErrorResponse(errorMessage, errorCode, xmlContentBuff);
			xmlFileContent = xmlContentBuff.toString();
		}
		
		// form the reply object and return it
		/*reply = new StreamSource(new StringReader(xmlFileContent));*/
		
		reply = getServiceResponseAsStreamSource(xmlFileContent,
				CommonConstants.TESTRESULT_SVC_NAME_KEY);
		return reply;
	}

	/**
	 * This method creates the test result request object
	 * @param parameterMap
	 * @return
	 */
	private TestResultRequest getTestResultRequest(
			Map<String, String> parameterMap) {
		TestResultRequest testResultRequest = new TestResultRequest();
		// set the portal user name to the request first
		testResultRequest
				.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
		// next patient id
		if(parameterMap.containsKey(PortalConstants.PATIENTID_REQUEST_PARAM_KEY)){
			String patientId = parameterMap
					.get(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
			testResultRequest.setPatientId(patientId);
		}
		
		// next order id
		if(parameterMap.containsKey(ResultConstants.TESTRESULT_ORDERID_REQUEST_PARAM_KEY)){
			String orderId =  parameterMap
					.get(ResultConstants.TESTRESULT_ORDERID_REQUEST_PARAM_KEY);
			testResultRequest.setOrderNumber(orderId);
		}
		
		// next order
		if(parameterMap.containsKey(ResultConstants.TESTRESULT_ORDER_REQUEST_PARAM_KEY)){
			String order = parameterMap.get(ResultConstants.TESTRESULT_ORDER_REQUEST_PARAM_KEY);
			testResultRequest.setOrder(order);
		}
		
		// next result type
		if(parameterMap.containsKey(ResultConstants.TESTRESULT_RESULTTYPE_REQUEST_PARAM_KEY)){
			String resultType = parameterMap
					.get(ResultConstants.TESTRESULT_RESULTTYPE_REQUEST_PARAM_KEY);
			testResultRequest.setResultType(resultType);
		}
		
		return testResultRequest;
	}
	
	/**
	 * This method returns the contents of the response as XML string 
	 * @param testResultResponse
	 * @return
	 */
	private String getTestResultXML(TestResultResponse testResultResponse){
		StringBuffer xmlBuffer = new StringBuffer();
		xmlBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
		
		/*ErrorInfo errorInfo = testResultResponse.getErrorInfo();
		int errorCode = errorInfo.getErrorCode();
		String errorMessage = errorInfo.getErrorMessage();
		// this implies erroneous response
		if(ErrorInfo.SUCCESS_CODE != errorCode){
			createErrorResponse(errorMessage, errorCode, xmlBuffer);
			return xmlBuffer.toString();
		}*/
		
		if(!testResultResponse.isSuccessful()){
			String xmlString = testResultResponse.getErrorAsXMLString();
			xmlBuffer.append(xmlString);
			return xmlBuffer.toString();
		}
		
		// now process successful response
		// start off with the parent tag
		xmlBuffer.append(getXMLStartTag(ResultConstants.TR_RESPONSE_PARENT_XML_TAG));
		// now order number tag
		String orderNumber = testResultResponse.getOrderNumber();
		if(orderNumber == null){
			orderNumber = "";
		}
		xmlBuffer.append(getXMLStartTag(ResultConstants.TR_RESPONSE_ORDERNUMBER_XML_TAG));
		xmlBuffer.append(orderNumber);
		xmlBuffer.append(getXMLEndTag(ResultConstants.TR_RESPONSE_ORDERNUMBER_XML_TAG));
		
		// now order tag
		String order = testResultResponse.getOrder();
		xmlBuffer.append(getCompleteXMLTag(
				ResultConstants.TR_RESPONSE_ORDER_XML_TAG, order));
		
		// now result type
		String resultType = testResultResponse.getResultType();
		xmlBuffer.append(getCompleteXMLTag(
				ResultConstants.TR_RESPONSE_RESULTTYPE_XML_TAG, resultType));
		
		// now publish date
		Date publishDate = testResultResponse.getPublishDate();
		String publishDateString = "";
		if(publishDate != null){
			publishDateString = PortalHelper.getDateAsString(publishDate,
					ResultConstants.TESTRESULT_RESPONSE_PUBLISHDATE_FORMAT);	
		}
		xmlBuffer.append(getCompleteXMLTag(
				ResultConstants.TR_RESPONSE_PUBLISHDATE_XML_TAG, publishDateString));
		
		// now the results
		xmlBuffer.append(getXMLStartTag(ResultConstants.TR_RESPONSE_RESULTS_XML_TAG));
		// now iterate through the results and add the result string
		List<TestResult> testResultList = testResultResponse.getTestResultList();
		for(TestResult result : testResultList){
			xmlBuffer.append(result.getXMLContent());
		}
		
		// close the results
		xmlBuffer.append(getXMLEndTag(ResultConstants.TR_RESPONSE_RESULTS_XML_TAG));
		
		// end by closing the parent tag
		xmlBuffer.append(getXMLEndTag(ResultConstants.TR_RESPONSE_PARENT_XML_TAG));
		
		return xmlBuffer.toString();
	}
	
	
	public static void main(String[] args){
		TestResultSvcImpl svcImpl = new TestResultSvcImpl();
		String patientId = "DU00000692";
		String order = "Gen Chem";
		String orderNumber = "LBOPHS000040105";
		String resultType = "Lab Order";
		String portalUserName = PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE;
		
		TestResultRequest testResultRequest = new TestResultRequest();
		testResultRequest.setPatientId(patientId);
		testResultRequest.setPortalUserName(portalUserName);
		testResultRequest.setOrder(order);
		testResultRequest.setOrderNumber(orderNumber);
		testResultRequest.setResultType(resultType);
		
		TestResultResponse testResultResponse = svcImpl.getTestResult(testResultRequest);
		/*String xmlContent = svcImpl.getTestResultXML(testResultResponse);
		System.out.println(xmlContent);
		StringBuffer xmlBuffer = new StringBuffer(xmlContent);
		
		Document doc = getDocument(xmlBuffer);
		TestResultResponse newTestResultResponse = new TestResultResponse();
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
		newTestResultResponse.setErrorInfo(errorInfo);
		TestResultServiceInvoker testResultServiceInvoker = new TestResultServiceInvoker();
		testResultServiceInvoker.readXMLContent(doc, newTestResultResponse);*/
		System.out.println("all is well");
	}
	
	
	/**
	 * 
	 * @param xmlContent
	 * @return
	 */
	private static Document getDocument(StringBuffer xmlContent){
		byte[] byteArr = xmlContent.toString().getBytes();
		final ByteArrayInputStream is = new ByteArrayInputStream(byteArr);
		InputSource source = new InputSource(is);
		// initialize the document builder factory and document builder
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.out.println("Could not read from output xml file "
					+ e.getMessage());
			return null;
		}
		// initialize the document object - this will contain
		// the xml contents inside it as nodelist
		Document doc = null;
		try {
			doc = dBuilder.parse(source);
		} catch (Exception e) {
			System.out.println("Could not parse output xml file "
					+ e.getMessage());
			return null;
		}
		
		return doc;
	}

}
