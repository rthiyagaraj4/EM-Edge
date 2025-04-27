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
package portalrefimpl.common.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.homepage.svc.HomePageSvcImpl;

/**
 * @author gramamoorthy
 *
 */
public class PortalInitializationServlet extends HttpServlet {

	/**
	 * 
	 */
	public void init() throws ServletException {
		System.out.println("in init method");
	}

	/**
	 * 
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("in init method with servlet config");
		
		/*Endpoint e = Endpoint
				.create(HTTPBinding.HTTP_BINDING, this);
		String webServiceUrl = PortalHelper
				.getWebServiceURL(PortalConstants.LOGIN_WS_URL_KEY);
		e.publish(webServiceUrl);*/
		
		// for test details service
		/*
		webServiceUrl = PortalHelper
				.getWebServiceURL(PortalConstants.TESTDETAILS_WS_URL_KEY);
		e.publish(webServiceUrl);*/
		
		BaseRequest baseRequest = new BaseRequest();
		HomePageSvcImpl homePageSvcImpl = new HomePageSvcImpl();
		homePageSvcImpl.registerService(baseRequest);
		System.out.println("after initializing the home page service");
	}

}
