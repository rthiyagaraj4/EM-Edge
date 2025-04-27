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

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import portalrefimpl.PortalConstants;
import portalrefimpl.result.viewresult.TestResultCacheManager;

/**
 * @author GRamamoorthy
 *
 */
public class LogoutServlet extends HttpServlet {

	/**
	 * 
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * 
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		// get the patient id
		String patientId = (String)session
				.getAttribute(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
		// remove the patient's test results from the cache manager
		TestResultCacheManager.getInstance().removePatientData(patientId);
		try {
			session.removeAttribute(PortalConstants.LOGINRESPONSE_SESSION_KEY);
			session.removeAttribute(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
			session.removeAttribute(PortalConstants.USEWEBSERVICE_SESSION_KEY);
			session.removeAttribute(PortalConstants.PATIENTNAME_SESSION_KEY);
		} catch (Exception e) {
		}
		
		getServletConfig().getServletContext().removeAttribute(
				PortalConstants.LOGINRESPONSE_SESSION_KEY);
		getServletConfig().getServletContext().removeAttribute(
				PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
		getServletConfig().getServletContext().removeAttribute(
				PortalConstants.USEWEBSERVICE_SESSION_KEY);
		
		resp.sendRedirect("../jsp/LoginPage.jsp");
		
	}

}
