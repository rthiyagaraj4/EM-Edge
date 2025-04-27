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
import eAlert.src.alert.request.AlertDetailsRequest;
import eAlert.src.alert.request.BaseRequest;
import eAlert.src.alert.response.AlertDetailsResponse;

/**
 * Servlet implementation class AlertDetailServlet  
 */
public class AlertDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlertDetailServlet() {
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
		String sCount = "";
		int count = 0;
		
		salertId = request.getParameter("alertId");
		sCount = request.getParameter("count");
		if(salertId != "")
			alertId = Long.parseLong(salertId);
		if(sCount != ""){
			count = Integer.parseInt(sCount);
		}
		
		userId = (String)session.getAttribute("login_user");
		ProcessAlertBC alertBC = new ProcessAlertBC();
		AlertDetailsRequest detailsRequest = new AlertDetailsRequest();
		AlertDetailsResponse alertDetailsResponse = null;
		
		detailsRequest.setUserId(userId);
		detailsRequest.setAlertId(alertId);
		alertDetailsResponse = alertBC.getAlertDetails(detailsRequest);
		alertDetailsResponse.setTotalCount(count);
		request.setAttribute("AlertDetailsResponse", alertDetailsResponse);
		
		//RequestDispatcher rd = session.getServletContext().getRequestDispatcher("eAlert/jsp/UserAlert.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("eAlert/jsp/AlertDetail.jsp");
		rd.forward(request, response);
	}

}
