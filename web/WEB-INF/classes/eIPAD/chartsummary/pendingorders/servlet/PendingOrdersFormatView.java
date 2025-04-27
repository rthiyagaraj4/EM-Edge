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
import eIPAD.chartsummary.pendingorders.response.PendingOrderFormatResponse;

/**
 * Servlet implementation class PendingOrdersOrderLineView 
 */
public class PendingOrdersFormatView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("OrderId")==null?"":request.getParameter("OrderId");
		String lineId = request.getParameter("LineNum")==null?"":request.getParameter("LineNum");
		String calledFrom = request.getParameter("called_from")==null?"":request.getParameter("called_from");
		HttpSession session = request.getSession(false);
		PatContext patientContext = (PatContext)session.getAttribute("PatientContext");

		PendingOrderBC bc = new PendingOrderBC();
		PendingOrderFormatResponse formatResp;
		if(lineId.equals("")){
			formatResp = bc.getOrderFormatDetail(patientContext, orderId);
		}else{
			formatResp = bc.getOrderFormatLineDetail(patientContext, orderId, lineId, calledFrom);
		}


		request.setAttribute("POFormatResponse", formatResp);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/PendingOrderFormat.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
