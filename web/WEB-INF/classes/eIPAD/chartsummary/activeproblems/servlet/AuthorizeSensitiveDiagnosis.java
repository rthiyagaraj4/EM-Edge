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
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eIPAD.chartsummary.activeproblems.bc.ProblemsDiagnosisBC;
import eIPAD.chartsummary.common.healthobject.PatContext;

/**
 * Servlet implementation class AuthorizeSensitiveDiagnosis
 */
public class AuthorizeSensitiveDiagnosis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorizeSensitiveDiagnosis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        out = response.getWriter();
        
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
        
		String password = request.getParameter("SensitiveDataPwd") == null ? "" : request.getParameter("SensitiveDataPwd").toUpperCase();
		
        ProblemsDiagnosisBC bc = new ProblemsDiagnosisBC();
        int authResult = bc.isUserAuthorizedForSensitiveDate(patientContext, password);
        if(authResult==1){
        	out.println("SUCCESS");
        }
        else
        	out.println("FAILURE");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
