/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.result.viewtestresultreport.svc;

import java.io.StringReader;
import java.util.Iterator;
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
import portal.result.viewtestresultreport.bc.TestReportBC;
import portal.result.viewtestresultreport.request.TestReportRequest;
import portal.result.viewtestresultreport.response.Report;
import portal.result.viewtestresultreport.response.TestReportResponse;
import portal.tools.ErrorMessageUtil;
import portal.tools.PortalConstants;
import portal.tools.PortalHelper;
import portal.tools.TestDetailsConstant;
import portal.tools.TestReportConstant;

/**
 * This class is the service implementation for displaying Test report
 * 
 * @author vkodancha
 * 
 */
@WebServiceProvider()
@BindingType(value = HTTPBinding.HTTP_BINDING)
public class TestReportSvcImpl extends BaseServiceImpl implements
		TestReportSvc, Provider<Source> {

	private static Logger logger = Logger.getLogger(TestReportSvcImpl.class
			.getName());

	@Resource
	protected WebServiceContext wsContext;

	@Override
	public void registerService(BaseRequest request) {
		logger.info("URL is registered");
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String testResultsUrl = PortalHelper
				.getWebServiceURL(PortalConstants.TESTREPORT_WS_URL_KEY);
		e.publish(testResultsUrl);
		logger.info("URL is published");
	}

	@Override
	public Source invoke(Source request) {
		logger.info("Invoking the service with request :" + request);
		StreamSource reply = null;
		TestReportResponse testDetailsResponse = new TestReportResponse();
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String) mc.get(MessageContext.QUERY_STRING);
			logger.debug("Path is  :" + path);
			/**
			 * get the parameters from path parameters are expected to be known
			 */
			TestReportRequest testReportRequest = formRequestFromPath(path);
			logger.debug("Request formed after formRequestFromPath :"
					+ testReportRequest.toString());
			testDetailsResponse = (TestReportResponse) isValidRequestor(testReportRequest);
			logger.debug("Is respoinse Valid :" + testDetailsResponse.isValid());
			if (testDetailsResponse.isValid()) {
				testDetailsResponse = getTestReport(testReportRequest);
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
	 * Validation of the input parameters
	 * 
	 * @param request
	 * @return
	 */
	@Override
	public BaseResponse isValidRequestor(ValidationRequest request) {
		logger.info("Entering the method isValidRequestor :"
				+ request.toString());
		TestReportResponse response = new TestReportResponse();
		TestReportRequest trequest = (TestReportRequest) request;
		response.setValid(true);

		if (!super.isValidRequestor(request).isValid()) { // if portalusername
															// is not valid
			ErrorInfo errorInfo = ErrorMessageUtil.getErrorMessage(
					TestReportConstant.MODULE_NAME,
					ErrorInfo.TESTREPORT_INVALID_LOGIN_CODE);
			response.setErrorInfo(errorInfo);
			response.setValid(false);
		} else if (isEmptyOrNull(trequest.getPatientId())
				|| isEmptyOrNull(trequest.getOrderId())
				|| isEmptyOrNull(trequest.getOrder())
				|| isEmptyOrNull(trequest.getResultType())) { // if patientId or
																// oderId Or
																// Order or
																// resultType //
																// not passed
			ErrorInfo errorInfo = ErrorMessageUtil.getErrorMessage(
					TestDetailsConstant.MODULE_NAME,
					ErrorInfo.TESTREPORT_INSUFFICIENT_REQUEST_PARAMETERS_CODE);
			response.setErrorInfo(errorInfo);
			response.setValid(false);
		}
		logger.info("Leaving the method isValidRequestor :");
		return response;
	}

	/**
	 * This method is used for retrieving all the request parameters from the
	 * URL
	 * 
	 * @param path
	 * @return
	 */
	private TestReportRequest formRequestFromPath(String path) {
		logger.info("Entered the method formRequestFromPath");
		TestReportRequest request = new TestReportRequest();
		Map<String, String> parameterMap = getParametersFromRequest(path);

		logger.debug("parameterMap :" + parameterMap.toString());
		// now iterate through the hash map and find the parameters
		if (parameterMap.isEmpty()) {
			return request;
		}

		/* call to update portal user name to request */
		setPortalUserNameToRequest(request, parameterMap);

		/* sets the URL parameters to request */
		request = setParamsToRequest(request, parameterMap);
		logger.info("leaving the method formRequestFromPath");
		return request;
	}

	/**
	 * This method updates the request with parameters
	 */
	private TestReportRequest setParamsToRequest(TestReportRequest request,
			Map<String, String> parameterMap) {
		logger.info("Entering the method setParamsToRequest");
		if (parameterMap.containsKey("patientId")) {
			request.setPatientId(parameterMap.get("patientId"));
		}
		if (parameterMap.containsKey("orderId")) {
			request.setOrderId(parameterMap.get("orderId"));
		}
		if (parameterMap.containsKey("resultType")) {
			request.setResultType(parameterMap.get("resultType"));
		}
		if (parameterMap.containsKey("order")) {
			request.setOrder(parameterMap.get("order"));
		}
		if (parameterMap.containsKey("language")) {
			request.setLanguage(parameterMap.get("language"));
		}
		logger.info("leaving the method setParamsToRequest");
		return request;
	}

	/**
	 * This method calls the Business component which fetches the Data from DB
	 */
	@Override
	public TestReportResponse getTestReport(TestReportRequest request) {
		logger.info("Entering the method getTestReport");
		// ApplicationContext context1 = new
		// ClassPathXmlApplicationContext("Beans.xml");

		TestReportBC inst = (TestReportBC) context.getBean("TestReportBC");
		TestReportResponse response = inst.getTestReport(request);

		logger.debug("Error Info is:" + response.getErrorInfo().toString());
		logger.info("Leaving the method getTestReport");
		return response;
	}

	/**
	 * This method generates the XML from response object
	 * 
	 * @param testDetailsResponse
	 * @return
	 */
	private String getXMLFile(TestReportResponse testReportResponse) {
		StringBuffer xmlFileContent = new StringBuffer();
		xmlFileContent
				.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");

		if (testReportResponse == null) {
			logger.error("Empty response - so no file output");
			return "";
		}
		ErrorInfo errorInfo = testReportResponse.getErrorInfo();
		if (errorInfo != null) {
			int errorCode = errorInfo.getErrorCode();
			String errorMessage = errorInfo.getErrorMessage();
			if (ErrorInfo.SUCCESS_CODE != errorCode) {
				xmlFileContent = createErrorResponse(errorMessage, errorCode,
						xmlFileContent);
			} else {
				xmlFileContent.append(getXMLForTestReport(testReportResponse));
			}
		}
		return xmlFileContent.toString();
	}

	/**
	 * This method generates the XML for Test report response object
	 * 
	 * @param testReportResponse
	 * @return
	 */
	private Object getXMLForTestReport(TestReportResponse testReportResponse) {
		StringBuffer xmlFileContent = new StringBuffer();
		xmlFileContent.append("<").append(TestReportConstant.MODULE_NAME)
				.append(">");
		// header components
		xmlFileContent = createXMLFileContent(xmlFileContent,
				TestReportConstant.ORDER_KEY, testReportResponse.getOrder());
		xmlFileContent = createXMLFileContent(xmlFileContent,
				TestReportConstant.ORDERNO_KEY, testReportResponse.getOrderNo());
		xmlFileContent = createXMLFileContent(xmlFileContent,
				TestReportConstant.RESULTTYPE_KEY,
				testReportResponse.getResultType());
		xmlFileContent = createXMLFileContent(xmlFileContent,
				TestReportConstant.ORDER_DATE_TIME_KEY,
				testReportResponse.getOrderDateandTime());

		// list iterations
		if (testReportResponse.getReportList() != null
				&& !testReportResponse.getReportList().isEmpty()) {
			xmlFileContent.append("<").append(TestReportConstant.REPORTS)
					.append(">");
			Iterator<Report> it = testReportResponse.getReportList().iterator();
			while (it.hasNext()) {
				Report report = (Report) it.next();
				xmlFileContent.append(getXMLForReport(report));
			}
			xmlFileContent.append("</").append(TestReportConstant.REPORTS)
					.append(">");
		}
		xmlFileContent.append("</").append(TestReportConstant.MODULE_NAME)
				.append(">");
		return xmlFileContent;
	}

	/**
	 * This method generates the XML for report elements
	 * 
	 * @param report
	 * @return
	 */
	private String getXMLForReport(Report report) {
		StringBuffer sb = new StringBuffer();
		sb.append("<").append(TestReportConstant.REPORT).append(">");
		sb = createXMLFileContent(sb, TestReportConstant.RESULTNUMBER,
				report.getResultNumber());
		sb = createXMLFileContent(sb, TestReportConstant.RESULTNUMBERUOM,
				report.getResultNumberUom());
		sb = createXMLFileContentForCDATA(sb, TestReportConstant.RESULTSTR,
				report.getResultStr());
		sb = createXMLFileContentForCDATA(sb, TestReportConstant.RESULTDATA,
				report.getResultData());
		sb = createXMLFileContent(sb, TestReportConstant.REPORTINGDATE,
				report.getReportingDate());
		sb = createXMLFileContent(sb, TestReportConstant.NORMALLOW,
				report.getNormalLow());
		sb = createXMLFileContent(sb, TestReportConstant.NORMALHIGH,
				report.getNormalHigh());
		sb = createXMLFileContent(sb, TestReportConstant.CRITICALLOW,
				report.getCriticalLow());
		sb = createXMLFileContent(sb, TestReportConstant.CRITICALHIGH,
				report.getCriticalHigh());
		sb = createXMLFileContent(sb, TestReportConstant.NORMALABNORMALIND,
				report.getNormalAbnormalInd());
		sb = createXMLFileContent(sb, TestReportConstant.REPORTCAPTION,
				report.getReportCaption());
		sb = createXMLFileContent(sb, TestReportConstant.RESULTTYPE,
				report.getResultType());
		sb = createXMLFileContent(sb, TestReportConstant.ORDERTYPE,
				report.getOrderType());
		sb = createXMLFileContent(sb, TestReportConstant.PRACTITIONERID,
				report.getPractitionerId());
		sb = createXMLFileContent(sb,
				TestReportConstant.REPORTINGPRACTITIONERID,
				report.getReportingPractitionerId());
		sb = createXMLFileContent(sb, TestReportConstant.ACCESSSIONNUMBER,
				report.getAccesssionNumber());
		sb = createXMLFileContent(sb, TestReportConstant.NUMDATAYNIND,
				report.getNumDataYnInd());
		sb = createXMLFileContent(sb, TestReportConstant.STATUS,
				report.getStatus());
		sb = createXMLFileContent(sb, TestReportConstant.NORMALACYSTR,
				report.getNormalacyStr());
		sb.append("</").append(TestReportConstant.REPORT).append(">");
		return sb.toString();
	}

}
