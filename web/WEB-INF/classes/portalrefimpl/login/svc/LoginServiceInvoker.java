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

import org.w3c.dom.Document;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.common.serviceinvoker.AbstractServiceInvoker;
import portalrefimpl.common.svc.BaseService;
import portalrefimpl.login.request.LoginRequest;
import portalrefimpl.login.response.LoginResponse;



/**
 * this is the service invoker implementation for the Login mechanism
 * @author GRamamoorthy
 *
 */
public class LoginServiceInvoker extends AbstractServiceInvoker {

	/**
	 * 
	 */
	public String getWebServiceURL(BaseRequest request) {
		String webServiceUrl = PortalHelper
				.getWebServiceURL(PortalConstants.LOGIN_WS_URL_KEY);
		return webServiceUrl;
	}

	/**
	 * This method forms the parameters which needs to be added
	 * to the web service URL to get the complete http URL
	 * The parameters in the login scenario are the 
	 * patient id and the date of birth
	 */
	public String getURLParameters(BaseRequest request) {
		String patientId = request.getPatientId();
		if(patientId == null){
			patientId = "";
		}
		String dateOfBirth = "";
		if(request instanceof LoginRequest){
			dateOfBirth = ((LoginRequest)request).getDateOfBirth();
		}
		if(dateOfBirth == null){
			dateOfBirth = "";
		}
		// form the parameters in a string buffer
		StringBuffer paramBuff = new StringBuffer();
		paramBuff.append("patientId="+patientId);
		paramBuff.append("&");
		paramBuff.append("password="+dateOfBirth);
		paramBuff.append("&");
		// next portal user
		String portalUserName = request.getPortalUserName();
		paramBuff.append(getCompleteParamString(
				PortalConstants.PORTALUSER_REQUEST_PARAM_KEY,
				portalUserName));
		return paramBuff.toString();
	}

	/**
	 * This method returns the response object
	 */
	public BaseResponse getResponseObject() {
		return new LoginResponse();
	}
	

	/**
	 * This method reads the XML content returned by the web service call
	 * In the login functionality there is no need to do anything
	 * since in login only error info tag is present in the xml output
	 * given by the web service
	 * The logic of reading the error info tag is already present
	 * in the abstract service invoker class
	 * This will be a dummy method
	 */
	public void readXMLContent(Document document, BaseResponse response) {
		// no implementation here
		// only set positive response
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
		response.addError(errorInfo);
	}

	/**
	 * This method returns an instance of the impl class
	 * used for performing the business operation 
	 */
	protected BaseService getServiceImpl() {
		return new LoginSvcImpl();
	}

	/**
	 * This method gets the required data from the underlying 
	 * service implementation
	 */
	public LoginResponse getDataThroughService(LoginRequest loginRequest){
		LoginSvcImpl svcImpl = new LoginSvcImpl();
		return svcImpl.validateUserLogin(loginRequest);
	}
	
}
