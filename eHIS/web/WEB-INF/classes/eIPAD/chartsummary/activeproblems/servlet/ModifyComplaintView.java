/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.activeproblems.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eIPAD.chartsummary.activeproblems.bc.ProblemsDiagnosisBC;
import eIPAD.chartsummary.activeproblems.response.ComplaintDetailsResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisDetailsResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;

/**
 * Servlet implementation class ModifyComplaintView 
 */
public class ModifyComplaintView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyComplaintView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		PatContext patientContext;
		
		HttpSession session = request.getSession(false);
		patientContext = (PatContext)session.getAttribute("PatientContext");
		
		String complaintCode = request.getParameter("ComplaintCode")== null? "":request.getParameter("ComplaintCode");

		ComplaintDetailsResponse complDetailsResp;
		ProblemsDiagnosisBC pdBC = new ProblemsDiagnosisBC();
		complDetailsResp = pdBC.getComplaintDetails(patientContext, complaintCode);
		request.setAttribute("ComplaintDetailsResponse", complDetailsResp);
		rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/ModifyComplaint.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
