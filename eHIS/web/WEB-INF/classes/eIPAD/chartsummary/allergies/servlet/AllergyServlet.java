/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.allergies.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eIPAD.chartsummary.allergies.bc.AllergyBC;
import eIPAD.chartsummary.allergies.request.AllergyRequest;
import eIPAD.chartsummary.allergies.response.AllergyResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;

/**
 * Servlet implementation class AllergyServlet 
 */
public class AllergyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
		AllergyRequest allergyRequest = new AllergyRequest();
		AllergyResponse allergyResponse;
		if(patientContext!=null){
			allergyRequest.setPatientContext(patientContext);
		}
		AllergyBC allergyBC = new AllergyBC();
		allergyResponse = allergyBC.getAllergyDetails(allergyRequest);
		request.setAttribute("AllergyResponse", allergyResponse);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/AllergyView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
