/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAlert.src.alert.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eAlert.src.alert.bc.ProcessAlertBC;
import eAlert.src.alert.common.AlertBaseResponse;
import eAlert.src.alert.common.AlertErrorInfo;
import eAlert.src.alert.request.AlertFwdManageRequest;
import eAlert.src.alert.request.AlertRequest;
import eAlert.src.alert.request.AlertReviewMangRequest;

/**
 * Servlet implementation class AlertArchiveServlet  
 */
public class AlertArchiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlertArchiveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		String userId = "";
		String salertId = "";
		long alertId = 0;
		String sPatientRecipientId = "";
		long patientRecipientId = 0;
		
		salertId = request.getParameter("alertId");
		sPatientRecipientId = request.getParameter("alertPatientRecipientIdhdn");
		if(salertId != "")
			alertId = Long.parseLong(salertId);
		if(sPatientRecipientId != "")
			patientRecipientId = Long.parseLong(sPatientRecipientId);
		
		userId = (String)session.getAttribute("login_user");
		ProcessAlertBC alertBC = new ProcessAlertBC();
		AlertBaseResponse manageResponse = null;
		
		AlertRequest archiveRequest = new AlertRequest();
		archiveRequest.setAlertId(alertId);
		archiveRequest.setPatRecipientId(patientRecipientId);
		
			
		manageResponse = alertBC.archiveAlert(archiveRequest);
		if(manageResponse.getErrorInfo().getErrorCode() == AlertErrorInfo.SUCCESS_CODE)
			response.getWriter().println("true");
	}

}
