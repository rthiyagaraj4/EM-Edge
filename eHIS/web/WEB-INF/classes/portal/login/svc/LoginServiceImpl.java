/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.login.svc;

import java.io.StringReader;
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
import portal.login.bc.LoginDetailsBC;
import portal.login.request.LoginRequest;
import portal.login.response.LoginResponse;
import portal.tools.ErrorMessageUtil;
import portal.tools.LoginKeyConstants;
import portal.tools.PortalConstants;
import portal.tools.PortalHelper;

/**
 * This class defines all the methods used in Login Service This method takes as
 * input LoginRequest object and returns LoginResponse object
 * 
 * @author skrishnared2
 * 
 */

@WebServiceProvider()
@BindingType(value = HTTPBinding.HTTP_BINDING)
public class LoginServiceImpl extends BaseServiceImpl implements LoginService,
		Provider<Source> {
	private static Logger logger = Logger.getLogger(LoginServiceImpl.class.getName());
	
	@Resource
	protected WebServiceContext wsContext;

	/**
	 * Validation of the input parameters
	 * 
	 * @param request
	 * @return
	 */
	@Override
	public ValidationResponse isValidRequestor(ValidationRequest request) {
		logger.info("Entering the method isValidRequestor :"
				+ request.toString());
		LoginResponse response = new LoginResponse();
		LoginRequest lrequest = (LoginRequest) request;
		response.setValid(true);

		// if portalUserName is null
		if (isEmptyOrNull(lrequest.getPortalUserName())) {
			// ErrorInfo errorInfo =
			// ErrorMessageUtil.getInsuffientRequestParams();
			ErrorInfo errorInfo = ErrorMessageUtil.getErrorMessage(
					LoginKeyConstants.MODULE_NAME,
					ErrorInfo.INSUFFICIENT_REQUEST_PARAMETERS_CODE);
			response.setErrorInfo(errorInfo);
			response.setValid(false);
		} else if (!super.isValidRequestor(request).isValid()) { // if
																	// portalusername
																	// is not
																	// valid
			//ErrorInfo errorInfo = ErrorMessageUtil.getInvalidUserMessage();
			ErrorInfo errorInfo = ErrorMessageUtil.getErrorMessage(
					LoginKeyConstants.MODULE_NAME,
					ErrorInfo.INVALID_LOGIN_CODE);
			response.setErrorInfo(errorInfo);
			response.setValid(false);
		} else if (isEmptyOrNull(lrequest.getPatientId())) { // if patientId or
																// resultSize
																// not passed
			//ErrorInfo errorInfo = ErrorMessageUtil.getInsuffientRequestParams();
			ErrorInfo errorInfo = ErrorMessageUtil.getErrorMessage(
					LoginKeyConstants.MODULE_NAME,
					ErrorInfo.INSUFFICIENT_REQUEST_PARAMETERS_CODE);
			response.setErrorInfo(errorInfo);
			response.setValid(false);
		}
		logger.info("Leaving the method isValidRequestor :");
		return response;
	}

	@Override
	/**
	 * This method registers the http URL for the service with
	 * the end point
	 * 
	 * @param request
	 */
	public void registerService(BaseRequest request) {
		logger.info("URL is registered");
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String loginDetailsUrl = PortalHelper
				.getWebServiceURL(PortalConstants.LOGIN_WS_URL_KEY);
		e.publish(loginDetailsUrl);
		logger.info("URL is published");
	}

	private LoginRequest formRequestFromPath(String path) {
		logger.info("Entered the method formRequestFromPath");
		LoginRequest request = new LoginRequest();

		Map<String, String> parameterMap = getParametersFromRequest(path);
		logger.debug("parameterMap :" + parameterMap.toString());
		
		// now iterate through the hashmap and find the parameters
		if (parameterMap.isEmpty() || parameterMap.size() < 3) {
			return request;
		}
		/* call to update portal user name to rquest */
		setPortalUserNameToRequest(request,parameterMap);
		
		/* sets the URL parameters to request */
		setParamsToRequest(request, parameterMap);
		logger.info("leaving the method formRequestFromPath");
		return request;
	}
	/**
	 * This method sets all the request parameters
	 * @param request
	 * @param parameterMap
	 */
	private void setParamsToRequest(LoginRequest request,
			Map<String, String> parameterMap) {
		logger.info("Entering the method setParamsToRequest");
		if (parameterMap.containsKey("patientId")) {
			request.setPatientId(parameterMap.get("patientId"));
		}
		if (parameterMap.containsKey("dateOfBirth")) {
			request.setDateOfBirth(parameterMap.get("dateOfBirth"));
		}
		if (parameterMap.containsKey("portalUserName")) {
			request.setPortalUserName(parameterMap.get("portalUserName"));
		}
		logger.info("leaving the method setParamsToRequest");
	}

	@Override
	public Source invoke(Source request) {
		logger.info("Invoking the service with request :" + request);
		StreamSource reply = null;
		LoginResponse loginResponse = new LoginResponse();
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String) mc.get(MessageContext.QUERY_STRING);
			logger.debug("Path is  :" + path);

			// get the parameters from the URL path
			LoginRequest loginRequest = formRequestFromPath(path);
			logger.debug("Request formed after formRequestFromPath :"
					+ loginRequest.toString());
			loginResponse = (LoginResponse) isValidRequestor(loginRequest);
			logger.debug("Is respoinse Valid :" + loginResponse.isValid());
			if (loginResponse.isValid()) {
				loginResponse = authenticatePatientLogin(loginRequest);
			}
			logger.debug("Response is :" + loginResponse.toString());
			String xmlFileContent = getXMLFile(loginResponse);
			logger.debug("XML response is :" + xmlFileContent);
			reply = new StreamSource(new StringReader(xmlFileContent));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reply;
	}
	/**
	 * This method calls the BC class to validate the user
	 */
	@Override
	public LoginResponse authenticatePatientLogin(LoginRequest request) {
		logger.info("Entering the method authenticatePatientLogin");
		LoginResponse response = null;
		LoginDetailsBC inst = (LoginDetailsBC) context
				.getBean("loginDetailsBC");
		response = inst.getLoginDetails(request);
		logger.debug("Error Info is:" + response.getErrorInfo().toString());
		logger.info("Leaving the method authenticatePatientLogin");
		return response;
	}
	/**
	 * This method converts the response to XML
	 * @param loginResponse
	 * @return
	 */
	private String getXMLFile(LoginResponse loginResponse) {
		StringBuffer xmlFileContent = new StringBuffer();
		xmlFileContent
				.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
		// just a safe check - response can never be null but still handle it
		if (loginResponse == null) {
			logger.error("Empty response - so no file output");
			return "";
		}
		ErrorInfo errorInfo = loginResponse.getErrorInfo();
		if (errorInfo != null) {
			int errorCode = errorInfo.getErrorCode();
			String errorMessage = null;
			// in case of error, form the error information
			// and put it to the string buffer
			errorMessage = errorInfo.getErrorMessage();
			xmlFileContent = createErrorResponse(errorMessage, errorCode,
					xmlFileContent);
		}
		return xmlFileContent.toString();
	}

	public static void main(String args[]) {
		LoginServiceImpl loginimpl = new LoginServiceImpl();
		String loginDetailsUrl = PortalHelper
				.getWebServiceURL(PortalConstants.LOGIN_WS_URL_KEY);
		LoginRequest request = new LoginRequest();
		request = loginimpl.formRequestFromPath(loginDetailsUrl);
		LoginResponse response = null;
		response = (LoginResponse) loginimpl.isValidRequestor(request);

		if (response.isValid()) {
			response = loginimpl.authenticatePatientLogin(request);
		}
		System.out.println("LoginResponse : "
				+ response.getErrorInfo().getErrorCode());
		System.out.println("LoginResponse : "
				+ response.getErrorInfo().getErrorMessage());

	}
}
