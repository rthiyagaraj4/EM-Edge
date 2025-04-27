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
package portalrefimpl.login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import portalrefimpl.PortalConstants;
import portalrefimpl.common.serviceinvoker.ServiceInvoker;
import portalrefimpl.login.request.LoginRequest;
import portalrefimpl.login.response.LoginResponse;
import portalrefimpl.login.svc.LoginServiceInvoker;

/**
 * @author GRamamoorthy
 *
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

	/**
	 * 
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String patientId = req.getParameter("name");
		if(patientId == null){
			patientId = "";
		}
		String password = req.getParameter("password");
		if(password == null){
			password = "";
		}
		/*System.out.println("patient id in servlet ="+patientId+", password="+password);*/
		
		//Here comes the logic of calling the login web service
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setPatientId(patientId);
		loginRequest.setDateOfBirth(password);
		loginRequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
		
		// register the service
		/*LoginSvcImpl loginSvc = new LoginSvcImpl();
		loginSvc.registerService(loginRequest);*/
		
		// call the invoker, register the service and
		// invoke the web service and get the response
		ServiceInvoker serviceInvoker = new LoginServiceInvoker();
		serviceInvoker.registerService(loginRequest);
		
		LoginResponse loginResponse = (LoginResponse) serviceInvoker
				.getDataThroughWebService(loginRequest);
		// set the response object to the config
		/*getServletConfig().getServletContext().setAttribute(
				PortalConstants.LOGINRESPONSE_SESSION_KEY, loginResponse);
		getServletConfig().getServletContext().setAttribute(
				PortalConstants.PATIENTID_REQUEST_PARAM_KEY, patientId);
		getServletConfig().getServletContext().setAttribute(
				PortalConstants.USEWEBSERVICE_SESSION_KEY, "Y");*/
		
		// set data to session
		HttpSession session = req.getSession(true);
		session.setAttribute(PortalConstants.LOGINRESPONSE_SESSION_KEY, loginResponse);
		session.setAttribute(PortalConstants.PATIENTID_REQUEST_PARAM_KEY,
				patientId);
		session.setAttribute(PortalConstants.USEWEBSERVICE_SESSION_KEY, "Y");
		
		// finally redirect the url - again this is done based on the LoginResponse
		// no need to check for null here since the response will have the errorinfo
		// always
		if(loginResponse.isSuccessful()){
			resp.sendRedirect("../jsp/PortalHome.jsp");
		}else{
			resp.sendRedirect("../jsp/LoginPage.jsp");
		}
		/*int errorCode = loginResponse.getErrorInfo().getErrorCode();
		
		if(ErrorInfo.SUCCESS_CODE == errorCode){
			resp.sendRedirect("../jsp/PortalHome.jsp");	
		}else{
			resp.sendRedirect("../jsp/LoginPage.jsp");
		}*/
		
		
	}

}
