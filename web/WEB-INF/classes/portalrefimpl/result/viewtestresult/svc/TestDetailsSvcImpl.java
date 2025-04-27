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
package portalrefimpl.result.viewtestresult.svc;

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
import portalrefimpl.common.request.PatientInfo;
import portalrefimpl.common.request.ValidationRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.common.response.ValidationResponse;
import portalrefimpl.common.svc.BaseServiceImpl;
import portalrefimpl.result.viewtestresult.bc.TestDetailsBC;
import portalrefimpl.result.viewtestresult.request.TestDetailsRequest;
import portalrefimpl.result.viewtestresult.response.TestDetails;
import portalrefimpl.result.viewtestresult.response.TestDetailsResponse;
import portalrefimpl.schedule.viewappointment.svc.AppointmentDetailConstant;


/**
 * This is the service implementation class for test details service
 * This class extends BaseServiceImpl and implements TestDetailsSvc
 * and Provider
 * @author GRamamoorthy
 *
 */
@WebServiceProvider
public class TestDetailsSvcImpl extends BaseServiceImpl implements TestDetailsSvc, Provider<Source> {

	
	/**
	 * Registers the HTTP URL of the service
	 */
	public void registerService(BaseRequest request) {
		Endpoint e = Endpoint
				.create(HTTPBinding.HTTP_BINDING, this);
		String webServiceUrl = PortalHelper
				.getWebServiceURL(PortalConstants.TESTDETAILS_WS_URL_KEY);
		e.publish(webServiceUrl);
		/*if(request instanceof TestDetailsRequest){
			registerService((TestDetailsRequest)request);
		}*/
	}

	/**
	 * This is the main method in the class - invoked
	 * when the HTTP URL for this service is accessed.
	 */
	public Source invoke(Source request) {
		StreamSource reply = null;
		TestDetailsResponse testDetailsResponse = null;
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String)mc.get(MessageContext.QUERY_STRING);
			
			TestDetailsRequest testDetailsRequest = formRequestFromPath(path);
			testDetailsResponse = getTestDetails(testDetailsRequest);
		} catch (Exception e) {
			int errorCode = CommonConstants.WEBSERVICE_EXCEPTION_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
							errorCode);
			// there is a need to fill in the web service
			// name in the error message using format
			errorMessage = MessageFormat
					.format(errorMessage,
							new Object[] { CommonConstants.TESTRESULTS_RECENT_SVC_NAME_KEY });
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			testDetailsResponse = new TestDetailsResponse();
			testDetailsResponse.addError(errorInfo);
		}
		
		String xmlFileContent = getXMLFile(testDetailsResponse);//getXMLFile(appointmentDetailsResponse);
		/*reply = new StreamSource(new StringReader(xmlFileContent));*/
		
		reply = getServiceResponseAsStreamSource(xmlFileContent,
				CommonConstants.TESTRESULTS_RECENT_SVC_NAME_KEY);
		
		return reply;
	}
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	private TestDetailsRequest formRequestFromPath(String path){
		TestDetailsRequest request = new TestDetailsRequest();
		PatientInfo patientInfo = new PatientInfo();
		request.setPatientInfo(patientInfo);
		// the main logic in this method is to break the path based on
		// & character
		/*StringTokenizer parameterTokenizer = new StringTokenizer(path, "&");
		String token = null;
		int index = -1;
		
		Map<String, String> parameterMap = new HashMap<String, String>();
		String paramName = null;
		String paramValue = null;
		while(parameterTokenizer.hasMoreTokens()){
			token = parameterTokenizer.nextToken();
			index = token.indexOf("=");
			if(index >= 0){
				paramName = token.substring(0, index);
				paramValue = token.substring(index+1);
				parameterMap.put(paramName, paramValue);
			}
		}*/
		
		Map<String, String> parameterMap = getRequestParameterMap(path);
		
		// now iterate through the hashmap and find the parameters
		if(parameterMap.isEmpty()){
			return request;
		}
		
		if(parameterMap.containsKey(PortalConstants.PATIENTID_REQUEST_PARAM_KEY)){
			patientInfo.setPatientId(parameterMap
					.get(PortalConstants.PATIENTID_REQUEST_PARAM_KEY));
		}
		if(parameterMap.containsKey(TestDetailsConstant.ENCOUNTERID_PARAM_KEY)){
			patientInfo.setEncounterId(parameterMap
					.get(TestDetailsConstant.ENCOUNTERID_PARAM_KEY));
		}
		String recordCountString = "";
		if(parameterMap.containsKey(TestDetailsConstant.RECORDCOUNT_PARAM_KEY)){
			recordCountString = parameterMap.get(TestDetailsConstant.RECORDCOUNT_PARAM_KEY);
		}
		int recordCount = PortalHelper.getIntegerValue(recordCountString,
				TestDetailsConstant.RECORDCOUNT_DEFAULT_VALUE);
		request.setRecordCount(recordCount);
		
		// portal user name
		if(parameterMap.containsKey(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY)){
			String portalUserName = parameterMap.get(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY);
			if(portalUserName == null){
				portalUserName = "";
			}
			request.setPortalUserName(portalUserName);
		}
		
		
		return request;
	}

	/**
	 * This is the main business method in this class
	 * gets the test results
	 */
	public TestDetailsResponse getTestDetails(TestDetailsRequest request) {
		TestDetailsResponse response = null;
		// // first step
		// validate the request - 
		BaseResponse validationResponse = isValidRequest(request);
		if(!validationResponse.isSuccessful()){
			response = new TestDetailsResponse();
			response.addAllErrors(validationResponse.getErrors());
			return response;
		}

		// second step - get data
		ApplicationContext context = new ClassPathXmlApplicationContext("app-beans.xml");
		TestDetailsBC inst = (TestDetailsBC)context.getBean("refTestDetailsBC");
		response = inst.getTestDetails(request);
		return response;
	}

	/**
	 * 
	 */
	/*private void registerService(TestDetailsRequest request) {
		Endpoint e = Endpoint
				.create(HTTPBinding.HTTP_BINDING, this);
		String patientId = "";
		if(request != null){
			patientId = request.getPatientId();
			if(patientId == null){
				patientId = "";
			}
		}
		String webServiceUrl = PortalHelper
				.getWebServiceURL(PortalConstants.TESTDETAILS_WS_URL_KEY);
		e.publish(webServiceUrl);
	}*/
	
	
	/**
	 * 
	 * @param testDetailsResponse
	 * @return
	 */
	private String getXMLFile(TestDetailsResponse testDetailsResponse){
		StringBuffer xmlFileContent = new StringBuffer();
		xmlFileContent.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
		// just a safe check - response can never be null but still handle it
		if(testDetailsResponse == null){
			System.out.println("Empty response - so no file output");
			return "";
		}
		
		if(testDetailsResponse.isSuccessful()){
			// this is the place where the XML file content
			// for the data part is formed
			List<TestDetails> testDetailsList = testDetailsResponse.getTestDetailsList();
			xmlFileContent.append("<")
					.append(TestDetailsConstant.TESTDETAILS_KEY)
					.append(">");
			if(testDetailsList != null){
				// local vars used for processing
				String orderNo = null;
				String location = null;
				String practId = null;
				String practName = null;
				String status = null;
				String order = null;
				Date orderDate = null;
				String resultType = null;
				// iterate through the test details 
				// and update the xml file content
				for(TestDetails testDetail : testDetailsList){
					// put the testdetail tag
					xmlFileContent.append("<")
							.append(TestDetailsConstant.TESTDETAIL_KEY)
							.append(">");
					
					// first order number is processed
					orderNo = testDetail.getOrderNo();
					xmlFileContent.append("<")
							.append(TestDetailsConstant.ORDERNO_KEY)
							.append(">");
					xmlFileContent.append(orderNo);
					xmlFileContent.append("</")
							.append(TestDetailsConstant.ORDERNO_KEY)
							.append(">");
					// second location is processed
					location = testDetail.getLocation();
					xmlFileContent.append("<")
							.append(TestDetailsConstant.LOCATION_KEY)
							.append(">");
					xmlFileContent.append(location);
					xmlFileContent.append("</")
							.append(TestDetailsConstant.LOCATION_KEY)
							.append(">");
					// third result type is processed
					resultType = testDetail.getResultType();
					xmlFileContent.append("<")
							.append(TestDetailsConstant.RESULTTYPE_KEY)
							.append(">");
					xmlFileContent.append(resultType);
					xmlFileContent.append("</")
							.append(TestDetailsConstant.RESULTTYPE_KEY)
							.append(">");
					// fourth order is processed
					order = testDetail.getOrder();
					xmlFileContent.append("<")
							.append(TestDetailsConstant.ORDER_KEY)
							.append(">");
					xmlFileContent.append(order);
					xmlFileContent.append("</")
							.append(TestDetailsConstant.ORDER_KEY)
							.append(">");
					// fifth order date is processed
					orderDate = testDetail.getOrderDate();
					long orderDateLongValue = orderDate != null ? orderDate
							.getTime() : System.currentTimeMillis();
					xmlFileContent.append("<")
							.append(TestDetailsConstant.ORDER_DATE_KEY)
							.append(">");
					xmlFileContent.append(orderDateLongValue);
					xmlFileContent.append("</")
							.append(TestDetailsConstant.ORDER_DATE_KEY)
							.append(">");
					// sixth order by (practitioner name) is processed
					practName = testDetail.getPractName();
					xmlFileContent.append("<")
							.append(TestDetailsConstant.PRACT_NAME_KEY)
							.append(">");
					xmlFileContent.append(practName);
					xmlFileContent.append("</")
							.append(TestDetailsConstant.PRACT_NAME_KEY)
							.append(">");
					// seventh practid is processed
					practId = testDetail.getPractId();
					xmlFileContent.append("<")
							.append(TestDetailsConstant.PRACT_ID_KEY)
							.append(">");
					xmlFileContent.append(practId);
					xmlFileContent.append("</")
							.append(TestDetailsConstant.PRACT_ID_KEY)
							.append(">");
					// eighth status is processed
					status = testDetail.getStatus();
					xmlFileContent.append("<")
							.append(TestDetailsConstant.STATUS_KEY)
							.append(">");
					xmlFileContent.append(status);
					xmlFileContent.append("</")
							.append(TestDetailsConstant.STATUS_KEY)
							.append(">");
					
					// close the test detail tag
					xmlFileContent.append("</")
							.append(TestDetailsConstant.TESTDETAIL_KEY)
							.append(">");
				}
			}
			// now close the test details tag
			xmlFileContent.append("</")
					.append(TestDetailsConstant.TESTDETAILS_KEY)
					.append(">");
		}else{
			xmlFileContent.append(testDetailsResponse.getErrorAsXMLString());
		}
		
		/*ErrorInfo errorInfo = testDetailsResponse.getErrorInfo();
		if(errorInfo != null){
			int errorCode = errorInfo.getErrorCode();
			String errorMessage = null;
			// in case of error, form the error information
			// and put it to the string buffer
			if(ErrorInfo.SUCCESS_CODE != errorCode){
				errorMessage = errorInfo.getErrorMessage();
				xmlFileContent.append("<")
						.append(PortalConstants.ERRORINFO_KEY)
						.append(">");
				xmlFileContent.append("<")
						.append(PortalConstants.ERRORCODE_KEY)
						.append(">");
				xmlFileContent.append(errorCode);
				xmlFileContent.append("</")
						.append(PortalConstants.ERRORCODE_KEY)
						.append(">");
				xmlFileContent.append("<")
						.append(PortalConstants.ERRORMESSAGE_KEY)
						.append(">");
				xmlFileContent.append(errorMessage);
				xmlFileContent.append("</")
						.append(PortalConstants.ERRORMESSAGE_KEY)
						.append(">");
				xmlFileContent.append("</")
						.append(PortalConstants.ERRORINFO_KEY)
						.append(">");
			}else{
				// this is the place where the XML file content
				// for the data part is formed
				List<TestDetails> testDetailsList = testDetailsResponse.getTestDetailsList();
				xmlFileContent.append("<")
						.append(TestDetailsConstant.TESTDETAILS_KEY)
						.append(">");
				if(testDetailsList != null){
					// local vars used for processing
					String orderNo = null;
					String location = null;
					String practId = null;
					String practName = null;
					String status = null;
					String order = null;
					Date orderDate = null;
					String resultType = null;
					// iterate through the test details 
					// and update the xml file content
					for(TestDetails testDetail : testDetailsList){
						// put the testdetail tag
						xmlFileContent.append("<")
								.append(TestDetailsConstant.TESTDETAIL_KEY)
								.append(">");
						
						// first order number is processed
						orderNo = testDetail.getOrderNo();
						xmlFileContent.append("<")
								.append(TestDetailsConstant.ORDERNO_KEY)
								.append(">");
						xmlFileContent.append(orderNo);
						xmlFileContent.append("</")
								.append(TestDetailsConstant.ORDERNO_KEY)
								.append(">");
						// second location is processed
						location = testDetail.getLocation();
						xmlFileContent.append("<")
								.append(TestDetailsConstant.LOCATION_KEY)
								.append(">");
						xmlFileContent.append(location);
						xmlFileContent.append("</")
								.append(TestDetailsConstant.LOCATION_KEY)
								.append(">");
						// third result type is processed
						resultType = testDetail.getResultType();
						xmlFileContent.append("<")
								.append(TestDetailsConstant.RESULTTYPE_KEY)
								.append(">");
						xmlFileContent.append(resultType);
						xmlFileContent.append("</")
								.append(TestDetailsConstant.RESULTTYPE_KEY)
								.append(">");
						// fourth order is processed
						order = testDetail.getOrder();
						xmlFileContent.append("<")
								.append(TestDetailsConstant.ORDER_KEY)
								.append(">");
						xmlFileContent.append(order);
						xmlFileContent.append("</")
								.append(TestDetailsConstant.ORDER_KEY)
								.append(">");
						// fifth order date is processed
						orderDate = testDetail.getOrderDate();
						long orderDateLongValue = orderDate != null ? orderDate
								.getTime() : System.currentTimeMillis();
						xmlFileContent.append("<")
								.append(TestDetailsConstant.ORDER_DATE_KEY)
								.append(">");
						xmlFileContent.append(orderDateLongValue);
						xmlFileContent.append("</")
								.append(TestDetailsConstant.ORDER_DATE_KEY)
								.append(">");
						// sixth order by (practitioner name) is processed
						practName = testDetail.getPractName();
						xmlFileContent.append("<")
								.append(TestDetailsConstant.PRACT_NAME_KEY)
								.append(">");
						xmlFileContent.append(practName);
						xmlFileContent.append("</")
								.append(TestDetailsConstant.PRACT_NAME_KEY)
								.append(">");
						// seventh practid is processed
						practId = testDetail.getPractId();
						xmlFileContent.append("<")
								.append(TestDetailsConstant.PRACT_ID_KEY)
								.append(">");
						xmlFileContent.append(practId);
						xmlFileContent.append("</")
								.append(TestDetailsConstant.PRACT_ID_KEY)
								.append(">");
						// eighth status is processed
						status = testDetail.getStatus();
						xmlFileContent.append("<")
								.append(TestDetailsConstant.STATUS_KEY)
								.append(">");
						xmlFileContent.append(status);
						xmlFileContent.append("</")
								.append(TestDetailsConstant.STATUS_KEY)
								.append(">");
						
						// close the test detail tag
						xmlFileContent.append("</")
								.append(TestDetailsConstant.TESTDETAIL_KEY)
								.append(">");
					}
				}
				// now close the test details tag
				xmlFileContent.append("</")
						.append(TestDetailsConstant.TESTDETAILS_KEY)
						.append(">");
			}
		}*/
		
		return xmlFileContent.toString();
	}

	/**
	 * This method validates the request
	 */
	public BaseResponse isValidRequest(BaseRequest request) {
		// validate the requestor - call the common method for it
		ValidationRequest validationRequest = new ValidationRequest();
		validationRequest.setPortalUserName(request.getPortalUserName());
		ValidationResponse validationResponse = isValidRequestor(validationRequest);
		
		TestDetailsResponse response = new TestDetailsResponse();
		if(!validationResponse.isSuccessful()){
			response.addAllErrors(validationResponse.getErrors());	
		}
		
		// now validate specifically for this service
		// validate patient id and the record count string
		TestDetailsRequest testDetailsRequest = (TestDetailsRequest) request;
		String patientId = testDetailsRequest.getPatientId();
		ErrorInfo errorInfo = null;
		if(patientId == null || patientId.trim().equals("")){
			int errorCode = AppointmentDetailConstant.APPOINTMENTDETAILS_INVALIDPATIENTID_ERRORCODE;
			String errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.VIEWAPPTDETAILS_MODULE_NAME, errorCode);
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
	
}
