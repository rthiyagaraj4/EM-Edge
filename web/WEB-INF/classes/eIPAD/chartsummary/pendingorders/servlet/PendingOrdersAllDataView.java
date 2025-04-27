/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.pendingorders.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.pendingorders.bc.PendingOrderBC;
import eIPAD.chartsummary.pendingorders.request.PendingOrderRequest;
import eIPAD.chartsummary.pendingorders.response.PendingOrderResponse;

/**
 * Servlet implementation class PendingOrdersAllDataView 
 */
public class PendingOrdersAllDataView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PendingOrdersAllDataView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
		//String orderCat = request.getParameter("OrderCategory")==null?"":request.getParameter("OrderCategory");
		PendingOrderRequest pendingOrderRequest = new PendingOrderRequest();
		//pendingOrderRequest.setOrderCategory(orderCat);
		pendingOrderRequest.setPatientContext(patientContext);
		PendingOrderBC bc = new PendingOrderBC();
		PendingOrderResponse ordersResp = bc.getPendingOrdersDetails(pendingOrderRequest);


		request.setAttribute("POResponse", ordersResp);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/PendingOrderAllDetails.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
