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
import eIPAD.chartsummary.activeproblems.request.ProblemsDiagnosisRequest;
import eIPAD.chartsummary.activeproblems.response.ProblemsDiagnosisResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;

/**
 * Servlet implementation class ProblemsDiagnosisView
 */
public class ProblemsDiagnosisView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProblemsDiagnosisView() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd;
		PatContext patientContext;
		
		HttpSession session = request.getSession(false);
		
		//if session is null forward to login page
		if(session == null){
			rd = getServletContext().getRequestDispatcher("/ipadlogin");
			rd.forward(request, response);	
		}
		patientContext = (PatContext)session.getAttribute("PatientContext");
		
		//if patientcontext in session returns null forward to IPlist page
		if(patientContext == null){
			rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/IPad.jsp");
			rd.forward(request, response);
		}
		
		String authorized = request.getParameter("authorized") == null ? "N" : request.getParameter("authorized");
		ProblemsDiagnosisRequest pdReq = new ProblemsDiagnosisRequest();
		if(authorized.equals("Y"))
			pdReq.setShowSensitive(true);
		else
			pdReq.setShowSensitive(false);
		ProblemsDiagnosisResponse pdResp;
		if(patientContext!=null){
			pdReq.setPatientContext(patientContext);
		}
		ProblemsDiagnosisBC pdBC = new ProblemsDiagnosisBC();
		pdResp = pdBC.getActiveProblemsAndDiagnosis(pdReq);
		request.setAttribute("ProblemsDiagnosisResponse", pdResp);
		
		rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/ActiveProblemsView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
