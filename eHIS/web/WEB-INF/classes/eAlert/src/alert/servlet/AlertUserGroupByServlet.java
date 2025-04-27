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

import jcifs.dcerpc.msrpc.netdfs;

import eAlert.src.alert.bc.ProcessAlertBC;
import eAlert.src.alert.request.AlertDetailsRequest;
import eAlert.src.alert.request.AlertsByGroupRequest;
import eAlert.src.alert.request.BaseRequest;
import eAlert.src.alert.response.AlertDetailsResponse;
import eAlert.src.alert.response.AlertUserResponse;
import eAlert.src.alert.response.AlertsByGroupResponse;

/**
 * Servlet implementation class AlertUserGroupByServlet  
 */
public class AlertUserGroupByServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlertUserGroupByServlet() {
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
		String groupCode = "";
		String groupText = "";
		String filtered = "";
		
		userId = (String)session.getAttribute("login_user");
		groupCode = request.getParameter("groupCode");
		groupText = request.getParameter("groupText");
		filtered = request.getParameter("filter");
		ProcessAlertBC alertBC = new ProcessAlertBC();
		AlertsByGroupRequest groupByRequest = new AlertsByGroupRequest();
		AlertsByGroupResponse alertGroupByResponse = null;
		
		groupByRequest.setUserId(userId);
		groupByRequest.setGroupBy(groupCode);
		groupByRequest.setGroupText(groupText);
		groupByRequest.setFiltered(filtered);
		alertGroupByResponse = alertBC.getAlertsByGroup(groupByRequest);
		request.setAttribute("AlertGroupByResponse", alertGroupByResponse);
		
		//RequestDispatcher rd = session.getServletContext().getRequestDispatcher("eAlert/jsp/UserAlert.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("eAlert/jsp/UserAlertGroupBy.jsp");
		rd.forward(request, response);
	}

}
