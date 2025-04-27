/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.clinicalnotes.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC;
import eIPAD.chartsummary.common.healthobject.PatContext;

/**
 * Servlet implementation class CreateClinicalNoteServlet 
 */
public class CreateClinicalNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateClinicalNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd;
		PatContext patientContext;
		
		HttpSession session = request.getSession(false);
		patientContext = (PatContext)session.getAttribute("PatientContext");
		
		
		rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/ClinicalNotes/CreateClinicalNotes.jsp");
		rd.forward(request, response);
		/*rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/ClinicalNotes/RTE03.jsp");
		rd.forward(request, response);*/
		/*rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/ClinicalNotes/RTE04.jsp");
		rd.forward(request, response);*/
		/*rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/ClinicalNotes/RTE05.jsp");
		rd.forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
