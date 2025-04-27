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
import eIPAD.chartsummary.activeproblems.response.DiagnosisDetailsResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisSetResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;

/**
 * Servlet implementation class ModifyDiagnosisView 
 */
public class ModifyDiagnosisView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		PatContext patientContext;
		
		HttpSession session = request.getSession(false);
		patientContext = (PatContext)session.getAttribute("PatientContext");
		
		String diagSetId = request.getParameter("DiagSetId")== null? "":request.getParameter("DiagSetId");
		String diagCode = request.getParameter("DiagCode")== null? "":request.getParameter("DiagCode");
		String occurSrlNo = request.getParameter("OccurSrlNo")== null? "":request.getParameter("OccurSrlNo");
		
		DiagnosisDetailsResponse diagDetailsResp;
		ProblemsDiagnosisBC pdBC = new ProblemsDiagnosisBC();
		diagDetailsResp = pdBC.getDiagnosisDetails(patientContext, diagSetId, diagCode, occurSrlNo);
		request.setAttribute("DiagnosisDetailsResponse", diagDetailsResp);
		rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/ModifyDiagnosis.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
