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
package portal.result.viewtestresult.svc;

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
import portal.common.response.ErrorInfo;
import portal.common.response.ValidationResponse;
import portal.common.svc.BaseServiceImpl;
import portal.result.viewtestresult.bc.TestResultBC;
import portal.result.viewtestresult.request.TestResultRequest;
import portal.result.viewtestresult.response.TestResult;
import portal.result.viewtestresult.response.TestResultResponse;
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
public class TestResultSvcImpl extends BaseServiceImpl implements
		TestResultSvc, Provider<Source> {

	@Resource
	protected WebServiceContext wsContext;
	
	private static Logger logger = Logger.getLogger(TestResultSvcImpl.class
			.getName());

	/**
	 * Validation of the input parameters
	 * 
	 * @param request
	 * @return
	 */
	@Override
	public ValidationResponse isValidRequestor(ValidationRequest request){
		logger.info("Entering the method isValidRequestor :"
				+ request.toString());
		TestResultResponse response = new TestResultResponse();
		TestResultRequest trequest = (TestResultRequest)request;
		response.setValid(true);
	
		// if portalUserName is null
		if(isEmptyOrNull(trequest.getPortalUserName()) ){
			ErrorInfo errorInfo = ErrorMessageUtil.getErrorMessage(
					TestDetailsConstant.MODULE_NAME,
					ErrorInfo.HOME_TEST_INSUFFICIENT_REQUEST_PARAMETERS_CODE);
			response.setErrorInfo(errorInfo);
			response.setValid(false);
		} else if (!super.isValidRequestor(request).isValid()) { // if portalusername is not valid
			ErrorInfo errorInfo = ErrorMessageUtil.getErrorMessage(
					TestDetailsConstant.MODULE_NAME,
					ErrorInfo.HOME_TEST_INVALID_LOGIN_CODE);
			response.setErrorInfo(errorInfo);
			response.setValid(false);
		} 
		else if(isEmptyOrNull(trequest.getPatientId()) ||  trequest.getResultSetSize() < 1) {  // if patientId or resultSize not passed
			ErrorInfo errorInfo = ErrorMessageUtil.getErrorMessage(
					TestDetailsConstant.MODULE_NAME,
					ErrorInfo.HOME_TEST_INSUFFICIENT_REQUEST_PARAMETERS_CODE);
			response.setErrorInfo(errorInfo);
			response.setValid(false);
		}
		logger.info("Leaving the method isValidRequestor :"
				+ response.isValid());
		return response;
	}

	/**
	 * This method registers the http URL for the service with the end point
	 */
	@Override
	public void registerService(BaseRequest request) {
		logger.info("URL is registered");
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String testResultsUrl = PortalHelper.getWebServiceURL(PortalConstants.TESTDETAILS_WS_URL_KEY);
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
		TestResultResponse testDetailsResponse = new TestResultResponse();
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String) mc.get(MessageContext.QUERY_STRING);
			logger.debug("Path is  :" + path);

			/**
			 * get the parameters from path parameters are expected to be known
			 */
			TestResultRequest testDetailsRequest = formRequestFromPath(path);
			logger.debug("Request formed after formRequestFromPath :"
					+ testDetailsRequest.toString());
			testDetailsResponse = (TestResultResponse) isValidRequestor(testDetailsRequest);
			logger.debug("Is respoinse Valid :" + testDetailsResponse.isValid());
			if (testDetailsResponse.isValid()) {
				testDetailsResponse = getTestDetails(testDetailsRequest);
			}
			logger.debug("Response is :" + testDetailsResponse.toString());

			String xmlFileContent = getXMLFile(testDetailsResponse);
			logger.debug("XML response is :" + xmlFileContent);
			reply = new StreamSource(new StringReader(xmlFileContent));
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal("Exception while converting to stream source", e);
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
	private TestResultRequest formRequestFromPath(String path) {
		logger.info("Entered the method formRequestFromPath");
		TestResultRequest request = new TestResultRequest();

		Map<String, String> parameterMap = getParametersFromRequest(path);
		// now iterate through the hashmap and find the parameters
		if (parameterMap.isEmpty()) {
			return request;
		}
		logger.debug("parameterMap :" + parameterMap.toString());
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
	protected TestResultRequest setParamsToRequest(TestResultRequest request,
			Map<String, String> parameterMap) {
		logger.info("Entered the method setParamsToRequest");
		if (parameterMap.containsKey("patientId")) {
			request.setPatientId(parameterMap.get("patientId"));
		}
		if (parameterMap.containsKey("resultSetSize")) {
			try {
				request.setResultSetSize(Integer.valueOf(
						parameterMap.get("resultSetSize")).intValue());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				request.setResultSetSize(-1);
			}
		}
		logger.info("leaving the method setParamsToRequest");
		return request;
	}

	/**
	 * This is the service method
	 */
	public TestResultResponse getTestDetails(TestResultRequest request) {
		logger.info("Entering the method getTestDetails");
		TestResultResponse response = new TestResultResponse();
		TestResultBC inst = (TestResultBC) context.getBean("TestResultBC");
		response = inst.getTestDetails(request);
		logger.debug("Error Info is:" + response.getErrorInfo().toString());
		logger.info("Leaving the method getTestDetails");
		return response;
	}

	/**
	 * This method converts the response in to XML
	 * @param testDetailsResponse
	 * @return
	 */
	private String getXMLFile(TestResultResponse testDetailsResponse){
		StringBuffer xmlFileContent = new StringBuffer();
		xmlFileContent.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
		// just a safe check - response can never be null but still handle it
		if(testDetailsResponse == null){
			System.out.println("Empty response - so no file output");
			return "";
		}
		ErrorInfo errorInfo = testDetailsResponse.getErrorInfo();
		if(errorInfo != null){
			int errorCode = errorInfo.getErrorCode();
			String errorMessage = errorInfo.getErrorMessage();
			if(ErrorInfo.SUCCESS_CODE != errorCode){
				xmlFileContent = createErrorResponse(errorMessage, errorCode, xmlFileContent);
			} else {
				xmlFileContent.append("<").append(TestDetailsConstant.TESTDETAILS_KEY).append(">");
				List<TestResult> testDetailsList = testDetailsResponse.getTestDetailsList();
						if (testDetailsList != null && !testDetailsList.isEmpty()) {
							String orderNo;
							String resultType;
							String orderDesc;
							String orderDate;
							String practName;
							for(TestResult testDetails : testDetailsList){
								orderNo = testDetails.getOrderNo(); 
								resultType = testDetails.getResultType();
								orderDesc = testDetails.getOrderDesc();
								orderDate = testDetails.getOrderDate();
								practName = testDetails.getPractName();
								xmlFileContent.append("<").append(TestDetailsConstant.TESTDETAIL_KEY).append(">");
								xmlFileContent = createXMLFileContent(xmlFileContent,
										TestDetailsConstant.ORDERNO_KEY,
										orderNo);
								xmlFileContent = createXMLFileContent(xmlFileContent,
										TestDetailsConstant.RESULTTYPE_KEY,
										resultType);
								xmlFileContent = createXMLFileContent(xmlFileContent,
										TestDetailsConstant.ORDER_KEY,
										orderDesc);
								xmlFileContent = createXMLFileContent(xmlFileContent,
										TestDetailsConstant.ORDER_DATE_KEY,
										orderDate);
								xmlFileContent = createXMLFileContent(xmlFileContent,
										TestDetailsConstant.PRACT_NAME_KEY,
										practName);
								xmlFileContent.append("</").append(TestDetailsConstant.TESTDETAIL_KEY).append(">");
							}
		
				// TO-DO create the XML for each test result
				
				}
				xmlFileContent.append("</").append(TestDetailsConstant.TESTDETAILS_KEY).append(">");
			}
		}
		return xmlFileContent.toString();
	}

}
