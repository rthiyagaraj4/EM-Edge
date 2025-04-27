/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.result.viewtestresultdetails.svc;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.BindingType;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Provider;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;

import org.apache.log4j.Logger;

import portal.common.request.BaseRequest;
import portal.common.request.ValidationRequest;
import portal.common.response.BaseResponse;
import portal.common.response.ErrorInfo;
import portal.common.svc.BaseServiceImpl;
import portal.result.viewtestresultdetails.bc.TestResultDetailsBC;
import portal.result.viewtestresultdetails.request.TestResultDetailsRequest;
import portal.result.viewtestresultdetails.response.TestResultDetails;
import portal.result.viewtestresultdetails.response.TestResultDetailsResponse;
import portal.tools.ErrorMessageUtil;
import portal.tools.PortalConstants;
import portal.tools.PortalHelper;
import portal.tools.TestDetailsConstant;

/**
 * This clas is the service implementation for displaying Testresults
 * 
 * @author GRamamoorthy
 * 
 */
@WebServiceProvider()
@BindingType(value = HTTPBinding.HTTP_BINDING)
public class TestResultDetailsSvcImpl extends BaseServiceImpl implements
		TestResultDetailsSvc, Provider<Source> {

	private static Logger logger = Logger
			.getLogger(TestResultDetailsSvcImpl.class.getName());

	@Resource
	protected WebServiceContext wsContext;

	/**
	 * Validation of the input parameters
	 * 
	 * @param request
	 * @return
	 */
	@Override
	public BaseResponse isValidRequestor(ValidationRequest request) {
		logger.info("Entering the method isValidRequestor :"
				+ request.toString());
		TestResultDetailsResponse response = new TestResultDetailsResponse();
		TestResultDetailsRequest trequest = (TestResultDetailsRequest) request;
		response.setValid(true);

		if (!super.isValidRequestor(request).isValid()) { // if portalusername
															// is not valid
			ErrorInfo errorInfo = ErrorMessageUtil.getErrorMessage(
					TestDetailsConstant.TESTRESULTDETAILS_MODULE_NAME,
					ErrorInfo.TESTRESULTDETAILS_INVALID_LOGIN_CODE);
			response.setErrorInfo(errorInfo);
			response.setValid(false);
		} else if (isEmptyOrNull(trequest.getPatientId())) { // if patientId or
																// resultSize
																// not passed
			ErrorInfo errorInfo = ErrorMessageUtil
					.getErrorMessage(
							TestDetailsConstant.TESTRESULTDETAILS_MODULE_NAME,
							ErrorInfo.TESTRESULTDETAILS_INSUFFICIENT_REQUEST_PARAMETERS_CODE);
			response.setErrorInfo(errorInfo);
			response.setValid(false);
		}
		logger.info("Leaving the method isValidRequestor :");
		return response;
	}

	/**
	 * This method registers the http URL for the service with the end point
	 */
	@Override
	public void registerService(BaseRequest request) {
		logger.info("URL is registered");
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String testResultsUrl = PortalHelper
				.getWebServiceURL(PortalConstants.TESTRESULTDETAILS_WS_URL_KEY);
		e.publish(testResultsUrl);
		logger.info("URL is published");
	}

	/**
	 * This method will invokes an operation occording to the contents of the
	 * request message.
	 */
	@Override
	public Source invoke(Source request) {
		logger.info("Invoking the service with request :" + request);
		StreamSource reply = null;
		TestResultDetailsResponse testDetailsResponse = new TestResultDetailsResponse();
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String) mc.get(MessageContext.QUERY_STRING);
			logger.debug("Path is  :" + path);
			/**
			 * get the parameters from path parameters are expected to be known
			 */
			TestResultDetailsRequest testDetailsRequest = formRequestFromPath(path);
			logger.debug("Request formed after formRequestFromPath :"
					+ testDetailsRequest.toString());
			testDetailsResponse = (TestResultDetailsResponse) isValidRequestor(testDetailsRequest);
			if (testDetailsResponse.isValid()) {
				testDetailsResponse = getTestResultDetails(testDetailsRequest);
			}
			logger.debug("Response is :" + testDetailsResponse.toString());
			String xmlFileContent = getXMLFile(testDetailsResponse);
			logger.debug("XML response is :" + xmlFileContent);
			reply = new StreamSource(new StringReader(xmlFileContent));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reply;
	}

	/**
	 * This method is used for retrieving all the request parameters from the
	 * URL
	 * 
	 * @param path
	 * @return
	 */
	private TestResultDetailsRequest formRequestFromPath(String path) {
		logger.info("Entered the method formRequestFromPath");
		TestResultDetailsRequest request = new TestResultDetailsRequest();

		Map<String, String> parameterMap = getParametersFromRequest(path);
		logger.debug("parameterMap :" + parameterMap.toString());
		// now iterate through the hashmap and find the parameters
		if (parameterMap.isEmpty()) {
			return request;
		}

		/* call to update portal user name to rquest */
		setPortalUserNameToRequest(request, parameterMap);

		/* sets the URL parameters to request */
		request = setParamsToRequest(request, parameterMap);
		logger.info("leaving the method formRequestFromPath");
		return request;
	}

	/**
	 * This method updates the request with portaluserName parameter
	 */
	protected TestResultDetailsRequest setParamsToRequest(
			TestResultDetailsRequest request, Map<String, String> parameterMap) {
		logger.info("Entering the method setParamsToRequest");
		if (parameterMap.containsKey("patientId")) {
			request.setPatientId(parameterMap.get("patientId"));
		}
		if (parameterMap.containsKey("location")) {
			request.setLocation(parameterMap.get("location"));
		}
		if (parameterMap.containsKey("orderFromDate")) {
			request.setOrderFromDate(parameterMap.get("orderFromDate"));
		}
		if (parameterMap.containsKey("orderToDate")) {
			request.setOrderToDate(parameterMap.get("orderToDate"));
		}
		if (parameterMap.containsKey("orderId")) {
			request.setOrderId(parameterMap.get("orderId"));
		}
		if (parameterMap.containsKey("resultType")) {
			request.setResultType(parameterMap.get("resultType"));
		}
		logger.info("Leaving the method setParamsToRequest");
		return request;
	}

	/**
	 * This is the service method
	 */
	public TestResultDetailsResponse getTestResultDetails(
			TestResultDetailsRequest request) {
		logger.info("Entering the method getTestResultDetails");
		TestResultDetailsResponse response = new TestResultDetailsResponse();
		TestResultDetailsBC inst = (TestResultDetailsBC) context
				.getBean("TestResultDetailsBC");
		response = inst.getTestResultDetails(request);
		logger.info("Leaving the method getTestResultDetails");
		return response;
	}

	/**
	 * This method converts the response in to XML
	 * 
	 * @param testDetailsResponse
	 * @return
	 */
	private String getXMLFile(TestResultDetailsResponse testDetailsResponse) {
		StringBuffer xmlFileContent = new StringBuffer();
		xmlFileContent
				.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
		// just a safe check - response can never be null but still handle it
		if (testDetailsResponse == null) {
			System.out.println("Empty response - so no file output");
			return "";
		}
		ErrorInfo errorInfo = testDetailsResponse.getErrorInfo();
		int errorCode = errorInfo.getErrorCode();
		String errorMessage = errorInfo.getErrorMessage();
		if (ErrorInfo.SUCCESS_CODE != errorCode) {
			xmlFileContent = createErrorResponse(errorMessage, errorCode,
					xmlFileContent);
		} else {
			xmlFileContent.append("<")
					.append(TestDetailsConstant.TESTDETAILS_KEY).append(">");
			List<TestResultDetails> testDetailsList = testDetailsResponse
					.getTestResultDetailsList();
			String orderNo;
			String location;
			String resultType;
			String orderDesc;
			String orderDate;
			String practName;
			String status;
			for (TestResultDetails testDetails : testDetailsList) {
				orderNo = testDetails.getOrderNo();
				location = testDetails.getLocation();
				resultType = testDetails.getResultType();
				orderDesc = testDetails.getOrderDesc();
				orderDate = testDetails.getOrderDate();
				practName = testDetails.getPractName();
				status = testDetails.getStatus();
				xmlFileContent.append("<")
						.append(TestDetailsConstant.TESTDETAIL_KEY).append(">");
				xmlFileContent = createXMLFileContent(xmlFileContent,
						TestDetailsConstant.ORDERNO_KEY, orderNo);
				xmlFileContent = createXMLFileContent(xmlFileContent,
						TestDetailsConstant.LOCATION_KEY, location);
				xmlFileContent = createXMLFileContent(xmlFileContent,
						TestDetailsConstant.RESULTTYPE_KEY, resultType);
				xmlFileContent = createXMLFileContent(xmlFileContent,
						TestDetailsConstant.ORDER_KEY, orderDesc);
				xmlFileContent = createXMLFileContent(xmlFileContent,
						TestDetailsConstant.ORDER_DATE_KEY, orderDate);
				xmlFileContent = createXMLFileContent(xmlFileContent,
						TestDetailsConstant.PRACT_NAME_KEY, practName);
				xmlFileContent = createXMLFileContent(xmlFileContent,
						TestDetailsConstant.STATUS_KEY, status);
				xmlFileContent.append("</")
						.append(TestDetailsConstant.TESTDETAIL_KEY).append(">");
			}
			xmlFileContent.append("</")
					.append(TestDetailsConstant.TESTDETAILS_KEY).append(">");
		}

		return xmlFileContent.toString();
	}

}
