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
package portalrefimpl.login.svc;

import java.text.MessageFormat;
import java.util.Map;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.BindingType;
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
import portalrefimpl.login.bc.LoginBC;
import portalrefimpl.login.request.LoginRequest;
import portalrefimpl.login.response.LoginResponse;

/**
 * This is the web service implementation class for login service.
 * 
 * @author GRamamoorthy
 *
 */
@WebServiceProvider
@BindingType(value = HTTPBinding.HTTP_BINDING)
public class LoginSvcImpl extends BaseServiceImpl implements LoginSvc,
		Provider<Source> {

	
	/**
	 * This method registers the http url for this web service
	 * with the end point
	 */
	public void registerService(BaseRequest request) {
		Endpoint e = Endpoint
				.create(HTTPBinding.HTTP_BINDING, this);
		String webServiceUrl = PortalHelper
				.getWebServiceURL(PortalConstants.LOGIN_WS_URL_KEY);
		e.publish(webServiceUrl);
	}

	/**
	 * This method is the main business method in this service
	 * This method authenticates the patient id and the dob
	 */
	public LoginResponse validateUserLogin(LoginRequest loginRequest) {
		// // first step
		// validate the request - this is just a sample so no validation
		LoginResponse loginResponse = (LoginResponse)isValidRequest(loginRequest);
		// login has failed validation so return the response
		if(!loginResponse.isSuccessful()){
			return loginResponse;
		}
		/*ErrorInfo errorInfo = loginResponse.getErrorInfo();
		if(ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()){
			return loginResponse;
		}*/
		// second step
		// initialize the BC class and get the data from it
		// this initialization is done only for test purpose
		// once this works, the bean instance will be obtained from
		// spring framework
		ApplicationContext context = new ClassPathXmlApplicationContext("app-beans.xml");
		LoginBC bcInst = (LoginBC)context.getBean("refLoginDetailsBC");
		loginResponse = bcInst.validateLoginUser(loginRequest);
		return loginResponse;
	}

	/**
	 * This is the main method in this web service implementation
	 * This method is invoked once the HTTP URL of this web service
	 * is accessed
	 */
	public Source invoke(Source request) {
		StreamSource reply = null;
		LoginResponse loginResponse = null;
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String)mc.get(MessageContext.QUERY_STRING);
			
			LoginRequest loginRequest = formRequestFromPath(path);
			loginResponse = validateUserLogin(loginRequest);
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
							new Object[] { CommonConstants.LOGIN_SVC_NAME_KEY });
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			loginResponse = new LoginResponse();
			//loginResponse.setErrorInfo(errorInfo);
			loginResponse.addError(errorInfo);
		}
		
		/*String xmlFileContent = getXMLFile(loginResponse);
		try {
			reply = new StreamSource(new StringReader(xmlFileContent));
		} catch (Exception e) {
			// cannot do much - so simply initialize the reply
			reply = new StreamSource();
		}*/
		String xmlFileContent = getXMLFile(loginResponse);
		reply = getServiceResponseAsStreamSource(xmlFileContent,
				CommonConstants.LOGIN_SVC_NAME_KEY);
		
		return reply;
	}
	
	/**
	 * This method forms the request object
	 * @param path
	 * @return
	 */
	private LoginRequest formRequestFromPath(String path){
		LoginRequest request = new LoginRequest();
		PatientInfo patientInfo = new PatientInfo();
		request.setPatientInfo(patientInfo);
		
		Map<String, String> parameterMap = getRequestParameterMap(path);
		
		// now iterate through the hashmap and find the parameters
		if(parameterMap.isEmpty()){
			return request;
		}
		
		if(parameterMap.containsKey("patientId")){
			patientInfo.setPatientId(parameterMap.get("patientId"));
		}
		if(parameterMap.containsKey("password")){
			request.setDateOfBirth(parameterMap.get("password"));
		}
		if(parameterMap.containsKey(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY)){
			String authValue = parameterMap.get(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY);
			request.setPortalUserName(authValue);
		}
		return request;
	}
	
	/**
	 * This method gets the XML content corresponding to the 
	 * response object
	 * @param loginResponse
	 * @return
	 */
	private String getXMLFile(LoginResponse loginResponse){
		StringBuffer xmlFileContent = new StringBuffer();
		xmlFileContent.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
		// just a safe check - response can never be null but still handle it
		if(loginResponse == null){
			int errorCode = CommonConstants.NULLRESPONSE_ERROR_CODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
							errorCode);
			populateXMLForErrorResponse(errorMessage, errorCode, xmlFileContent);
			return xmlFileContent.toString();
			/*System.out.println("Empty response - so no file output");
			return "";*/
		}
		// for the login functionality, the xml response should contain only
		// the error information alone
		String errorContent = getErrorsInResponseAsXML(loginResponse);
		xmlFileContent.append(errorContent);
		
		/*ErrorInfo errorInfo = loginResponse.getErrorInfo();
		if(errorInfo != null){
			int errorCode = errorInfo.getErrorCode();
			String errorMessage = errorInfo.getErrorMessage();
			if(errorMessage == null){
				errorMessage = "";
			}
			xmlFileContent.append("<").append(PortalConstants.ERRORINFO_KEY)
					.append(">");
			xmlFileContent.append("<").append(PortalConstants.ERRORCODE_KEY)
					.append(">");
			xmlFileContent.append(errorCode);
			xmlFileContent.append("</").append(PortalConstants.ERRORCODE_KEY)
					.append(">");
			xmlFileContent.append("<").append(PortalConstants.ERRORMESSAGE_KEY)
					.append(">");
			xmlFileContent.append(errorMessage);
			xmlFileContent.append("</")
					.append(PortalConstants.ERRORMESSAGE_KEY).append(">");
			xmlFileContent.append("</").append(PortalConstants.ERRORINFO_KEY)
					.append(">");
		}*/
		
		return xmlFileContent.toString();
	}

	/**
	 * This method is used to validate the request object
	 */
	public BaseResponse isValidRequest(BaseRequest request) {
		ValidationRequest validationRequest = new ValidationRequest();
		validationRequest.setPortalUserName(request.getPortalUserName());
		ValidationResponse validationResponse = isValidRequestor(validationRequest);
		
		LoginResponse response = new LoginResponse();
		if(!validationResponse.isSuccessful()){
			response.addAllErrors(validationResponse.getErrors());
		}
		/*ErrorInfo errorInfo = validationResponse.getErrorInfo();
		// set the errorinfo to the response
		// here after only the error info will be updated
		response.setErrorInfo(errorInfo);
		// request has failed basic validation - so return error response
		if (ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()) {
			return response;
		}*/
		
		ErrorInfo errorInfo = null;
		LoginRequest loginRequest = (LoginRequest)request;
		// now validate for patient id and date of birth
		String patientId = loginRequest.getPatientId();
		if(patientId == null || patientId.trim().equals("")){
			int errorCode = LoginConstant.PATIENTID_INVALID_ERRORCODE;
			String errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.LOGIN_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			/*return response;*/
		}
		
		// validate date of birth
		String dob = loginRequest.getDateOfBirth();
		if(dob == null || dob.trim().equals("")){
			int errorCode = LoginConstant.PATIENTID_INVALID_ERRORCODE;
			String errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.LOGIN_MODULE_NAME, errorCode);
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
