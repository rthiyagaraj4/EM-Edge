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

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Provider;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
import portalrefimpl.result.detailedresult.bc.DetailedResultsBC;
import portalrefimpl.result.detailedresult.request.DetailedResultsRequest;
import portalrefimpl.result.detailedresult.response.DetailedResult;
import portalrefimpl.result.detailedresult.response.DetailedResultsResponse;
import portalrefimpl.result.detailedresult.response.ResultStatus;

/**
 * @author GRamamoorthy
 *
 */
@WebServiceProvider
public class DetailedResultsSvcImpl extends BaseServiceImpl implements
		DetailedResultsSvc, Provider<Source> {

	/**
	 * Registers the service with end point
	 */
	public void registerService(BaseRequest request) {
		Endpoint e = Endpoint
				.create(HTTPBinding.HTTP_BINDING, this);
		String serviceURL = PortalHelper
				.getWebServiceURL(PortalConstants.DETAILED_TESTRESULT_WS_URL_KEY);
		e.publish(serviceURL);
	}

	/**
	 * This method validates the detailed test result request
	 * 
	 */
	public BaseResponse isValidRequest(BaseRequest request) {
		ValidationRequest validationRequest = new ValidationRequest();
		validationRequest.setPortalUserName(request.getPortalUserName());
		ValidationResponse validationResponse = isValidRequestor(validationRequest);
		
		BaseResponse response = new BaseResponse();
		response.addAllErrors(validationResponse.getErrors());
		/*response.setErrorInfo(validationResponse.getErrorInfo());*/
		return response;
	}

	/**
	 * This method gives the detailed test results
	 * 
	 */
	public DetailedResultsResponse getDetailedResults(
			DetailedResultsRequest request) {
		// initialize the response
		DetailedResultsResponse detailedResultsResponse = new DetailedResultsResponse();
		
		// // first step
		// validate the request for the common portal user name
		BaseResponse baseResponse = isValidRequest(request);
		if(!baseResponse.isSuccessful()){
			detailedResultsResponse.addAllErrors(baseResponse.getErrors());	
		}
		/*if(ErrorInfo.SUCCESS_CODE != baseResponse.getErrorInfo().getErrorCode()){
			detailedResultsResponse = new DetailedResultsResponse();
			detailedResultsResponse.setErrorInfo(baseResponse.getErrorInfo());
			return detailedResultsResponse;
		}*/
		// validate the other parameters in the request
		BaseResponse validatedResponse = validateDetailedResultsRequest(request);
		
		if(!validatedResponse.isSuccessful()){
			detailedResultsResponse.addAllErrors(validatedResponse.getErrors());
		}
		
		// if there are errors in the response, return it 
		if (detailedResultsResponse.hasErrors()
				&& !detailedResultsResponse.isSuccessful()) {
			return detailedResultsResponse;
		}
		/*if (ErrorInfo.SUCCESS_CODE != detailedResultsResponse.getErrorInfo()
				.getErrorCode()) {
			return detailedResultsResponse;
		}*/
		
		// second step
		// initialize the BC class and get the data from it
		// this initialization is done only for test purpose
		// once this works, the bean instance will be obtained from
		// spring framework
		ApplicationContext context = new ClassPathXmlApplicationContext("app-beans.xml");
		DetailedResultsBC bcInst = (DetailedResultsBC) context
				.getBean("refDetailedTestResultBC");
		detailedResultsResponse = bcInst.getDetailedResults(request);
		
		return detailedResultsResponse;
	}

	/**
	 * This is the main method of the service - this method
	 * gets invoked when the http url of the service is hit
	 */
	public Source invoke(Source arg0) {
		StreamSource reply = null;
		String xmlFileContent = "";
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String)mc.get(MessageContext.QUERY_STRING);
			
			Map<String, String> parameterMap = getRequestParameterMap(path);
			DetailedResultsRequest detailedResultsRequest = getDetailedResultsRequest(parameterMap);
			DetailedResultsResponse detailedResultsResponse = getDetailedResults(detailedResultsRequest);
			xmlFileContent = getDetailedResultsAsXML(detailedResultsResponse);
		} catch (Exception e) {
			// need to form an error info object as the xml output here
			int errorCode = CommonConstants.WEBSERVICE_EXCEPTION_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
							errorCode);
			// there is a need to fill in the web service
			// name in the error message using format
			errorMessage = MessageFormat
					.format(errorMessage,
							new Object[] { CommonConstants.DETAILED_TESTRESULTS_SVC_NAME_KEY });
			StringBuffer xmlContentBuff = new StringBuffer();
			xmlContentBuff
					.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
			//createErrorResponse(errorMessage, errorCode, xmlContentBuff);
			populateXMLForErrorResponse(errorMessage, errorCode, xmlContentBuff);
			xmlFileContent = xmlContentBuff.toString();
		}
		// form the reply object and return it
		/*reply = new StreamSource(new StringReader(xmlFileContent));*/
		
		reply = getServiceResponseAsStreamSource(xmlFileContent,
				CommonConstants.DETAILED_TESTRESULTS_SVC_NAME_KEY);
		
		return reply;
	}
	
	/**
	 * This method gets the detailed results request
	 * @param parameterMap
	 * @return
	 */
	private DetailedResultsRequest getDetailedResultsRequest(
			Map<String, String> parameterMap) {
		DetailedResultsRequest detailedResultsRequest = new DetailedResultsRequest();
		// portal user is obtained
		if (parameterMap
				.containsKey(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY)) {
			String portalUser = parameterMap
					.get(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY);
			detailedResultsRequest.setPortalUserName(portalUser);
		}
		// patient id is obtained next
		if (parameterMap
				.containsKey(PortalConstants.PATIENTID_REQUEST_PARAM_KEY)) {
			String patientId = parameterMap
					.get(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
			detailedResultsRequest.setPatientId(patientId);
		}
		
		// get order number
		String orderNumber = parameterMap
				.get(ResultConstants.DETAILEDRESULTS_ORDERNUMBER_PARAM_KEY);
		if(orderNumber == null){
			orderNumber = "";
		}
		detailedResultsRequest.setOrderNumber(orderNumber);
		
		// get facility
		String facility =  parameterMap
				.get(ResultConstants.DETAILEDRESULTS_FACILITY_PARAM_KEY);
		detailedResultsRequest.setLocation(facility);
		
		// get order category
		String orderCategory = parameterMap
				.get(ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_PARAM_KEY);
		detailedResultsRequest.setOrderCategory(orderCategory);
		
		// get from date
		String fromDate = parameterMap
				.get(ResultConstants.DETAILEDRESULTS_FROMDATE_PARAM_KEY);
		Date fromDateObj = PortalHelper.getDateFromString(fromDate,
				ResultConstants.DETAILEDRESULTS_DATEFORMAT);
		detailedResultsRequest.setFromDate(fromDateObj);
		detailedResultsRequest.setFromDateString(fromDate);
		
		// get to date
		String toDate = parameterMap
				.get(ResultConstants.DETAILEDRESULTS_TODATE_PARAM_KEY);
		Date toDateObj = PortalHelper.getDateFromString(toDate,
				ResultConstants.DETAILEDRESULTS_DATEFORMAT);
		detailedResultsRequest.setToDate(toDateObj);
		detailedResultsRequest.setToDateString(toDate);
		
		// the initial reset value parameter used for GUI
		String initialResetValue = parameterMap
				.get(ResultConstants.DETAILEDRESULTS_INITIALRESET_REQUEST_PARAM_KEY);
		if(initialResetValue == null){
			initialResetValue = ResultConstants.DETAILEDRESULTS_DEFAULT_INITIALRESET_VALUE;
		}
		detailedResultsRequest.setInitialResetValue(initialResetValue);
		
		return detailedResultsRequest;
	}
	
	
	/**
	 * This method validates the detailed results request object
	 * @param request
	 * @return
	 */
	private BaseResponse validateDetailedResultsRequest(
			DetailedResultsRequest request) {
		BaseResponse validationResponse = new BaseResponse();
		/*ErrorInfo errorInfo = new ErrorInfo();*/
		/*errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
		String errorMessage = "";*/
		/*validationResponse.setErrorInfo(errorInfo);*/
		
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		// validation is done for patient id, order category,
		// from date and to date
		
		
		// patient id cannot be null or empty
		String patientId = request.getPatientId();
		if (patientId == null || patientId.trim().equals("")) {
			errorInfo = new ErrorInfo();
			errorCode = ResultConstants.DTLD_RESULT_REQUEST_PATIENTID_ABSENT_CODE;
			errorInfo
					.setErrorCode(errorCode);
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.DETAILED_TESTRESULT_MODULE_NAME,
					errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			validationResponse.addError(errorInfo);
			/*return validationResponse;*/
		}
		
		// next validate order category
		String orderCategory = request.getOrderCategory();
		if(orderCategory == null){
			errorInfo = new ErrorInfo();
			errorCode = ResultConstants.DTLD_RESULT_REQUEST_ORDERCATEGORY_ABSENT_CODE;
			errorInfo
					.setErrorCode(errorCode);
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.DETAILED_TESTRESULT_MODULE_NAME,
					errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			validationResponse.addError(errorInfo);
			/*return validationResponse;*/
		}
		
		// this property is used from the portal GUI only
		// if this property is set, then the application
		// will get the first N records only from the db
		// and retrieval is not based on dates
		// hence there is no need to validate dates
		String initialResetValue = request.getInitialResetValue();
		if (ResultConstants.DETAILEDRESULTS_DEFAULT_INITIALRESET_VALUE
				.equalsIgnoreCase(initialResetValue)) {
			return validationResponse;
		}
		
		// next validation is for from date and to date
		// this is purely logical -
		// either provide both the dates or do not provide any
		// also from date should be earlier than to date
		Date fromDate = request.getFromDate();
		Date toDate = request.getToDate();
		if ((fromDate == null && toDate == null)
				|| (fromDate == null && toDate != null)
				|| (fromDate != null && toDate == null)
				|| (fromDate != null && fromDate.after(toDate))) {
			errorInfo = new ErrorInfo();
			errorCode = ResultConstants.DTLD_RESULT_REQUEST_DATE_INVALID_CODE;
			errorInfo
					.setErrorCode(errorCode);
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.DETAILED_TESTRESULT_MODULE_NAME,
					errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			validationResponse.addError(errorInfo);
		}
				
		return validationResponse;
	}
	
	/**
	 * This method gives the detailed result as XML string
	 * This method takes as input the DetailedResultsResponse object
	 * This method assumes that the DetailedResultsResponse object
	 * will not be null and that it will have ErrorInfo object
	 * defined properly
	 * @param detailedResultsResponse
	 * @return
	 */
	private String getDetailedResultsAsXML(DetailedResultsResponse detailedResultsResponse){
		StringBuffer xmlBuffer = new StringBuffer();
		xmlBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
		
		/*ErrorInfo errorInfo = detailedResultsResponse.getErrorInfo();
		int errorCode = errorInfo.getErrorCode();
		String errorMessage = errorInfo.getErrorMessage();
		// this implies erroneous response
		if(ErrorInfo.SUCCESS_CODE != errorCode){
			createErrorResponse(errorMessage, errorCode, xmlBuffer);
			return xmlBuffer.toString();
		}*/
		
		// check for errors and then return XML file
		if(!detailedResultsResponse.isSuccessful()){
			xmlBuffer.append(detailedResultsResponse.getErrorAsXMLString());
			return xmlBuffer.toString();
		}
		
		// now process successful response
		// start off with the parent tag
		xmlBuffer.append(getXMLStartTag(ResultConstants.DTLDRESULTS_XML_TAG));
		
		String location = null;
		String orderCatalogue = null;
		String orderNumber = null;
		String orderCategory = null;
		Date orderDate = null;
		String orderDateString = null;
		String practitioner = null;
		ResultStatus resultStatus = null;
		String status = null;
		// now iterate through the list of results and populate the xml
		List<DetailedResult> testResultList = detailedResultsResponse.getTestResultList();
		for(DetailedResult result : testResultList){
			// first put the result tag
			xmlBuffer.append(getXMLStartTag(ResultConstants.DTLDRESULTS_RESULT_XML_TAG));
			
			// order catalogue
			orderCatalogue = result.getOrderCatalogue();
			xmlBuffer
					.append(getXMLStartTag(ResultConstants.DTLDRESULTS_RESULT_ORDERCATALOGUE_XML_TAG));
			// code added to enclose the order catalogue in CDATA
			String tempOrderCatalogue = "";
			if(orderCatalogue != null && !orderCatalogue.trim().equals("")){
				tempOrderCatalogue = PortalConstants.CHARDATA_START_KEY;
				tempOrderCatalogue += orderCatalogue;
				tempOrderCatalogue += PortalConstants.CHARDATA_END_KEY;
			}
			xmlBuffer.append(tempOrderCatalogue);
			/*xmlBuffer.append(orderCatalogue);*/
			xmlBuffer
					.append(getXMLEndTag(ResultConstants.DTLDRESULTS_RESULT_ORDERCATALOGUE_XML_TAG));
			
			// order number
			orderNumber = result.getOrderNumber();
			if(orderNumber == null){
				orderNumber = "";
			}
			xmlBuffer
					.append(getXMLStartTag(ResultConstants.DTLDRESULTS_RESULT_ORDERNUMBER_XML_TAG));
			xmlBuffer.append(orderNumber);
			xmlBuffer
					.append(getXMLEndTag(ResultConstants.DTLDRESULTS_RESULT_ORDERNUMBER_XML_TAG));
			
			// location
			location = result.getLocation();
			// just a safe check
			if (location == null) {
				location = "";
			}
			xmlBuffer
					.append(getXMLStartTag(ResultConstants.DTLDRESULTS_RESULT_LOCATION_XML_TAG));
			xmlBuffer.append(location);
			xmlBuffer
					.append(getXMLEndTag(ResultConstants.DTLDRESULTS_RESULT_LOCATION_XML_TAG));
			
			// order category - this will not be null
			orderCategory = result.getOrderCategory();
			xmlBuffer
					.append(getXMLStartTag(ResultConstants.DTLDRESULTS_RESULT_ORDERCATEGORY_XML_TAG));
			xmlBuffer.append(orderCategory);
			xmlBuffer
					.append(getXMLEndTag(ResultConstants.DTLDRESULTS_RESULT_ORDERCATEGORY_XML_TAG));
			
			// order date
			orderDate = result.getOrderDate();
			orderDateString = PortalHelper.getDateAsString(orderDate,
					ResultConstants.DETAILEDRESULTS_DATETIMETOSTRING_FORMAT);
			xmlBuffer
					.append(getXMLStartTag(ResultConstants.DTLDRESULTS_RESULT_ORDERDATE_XML_TAG));
			xmlBuffer.append(orderDateString);
			xmlBuffer
					.append(getXMLEndTag(ResultConstants.DTLDRESULTS_RESULT_ORDERDATE_XML_TAG));
			
			// practitioner - this will not be null
			practitioner = result.getOrderPractitioner();
			xmlBuffer
					.append(getXMLStartTag(ResultConstants.DTLDRESULTS_RESULT_PRACTITIONER_XML_TAG));
			xmlBuffer.append(practitioner);
			xmlBuffer
					.append(getXMLEndTag(ResultConstants.DTLDRESULTS_RESULT_PRACTITIONER_XML_TAG));
			
			// result status
			resultStatus = result.getResultStatus();
			status = resultStatus.toString();
			xmlBuffer
					.append(getXMLStartTag(ResultConstants.DTLDRESULTS_RESULT_STATUS_XML_TAG));
			xmlBuffer.append(status);
			xmlBuffer
					.append(getXMLEndTag(ResultConstants.DTLDRESULTS_RESULT_STATUS_XML_TAG));
			
			// close the result tag
			xmlBuffer.append(getXMLEndTag(ResultConstants.DTLDRESULTS_RESULT_XML_TAG));
		}
		
		// finally close the parent tag
		xmlBuffer.append(getXMLEndTag(ResultConstants.DTLDRESULTS_XML_TAG));
		return xmlBuffer.toString();
	}

}
