/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.proceduredetails.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.proceduredetails.bc.*;
import eIPAD.chartsummary.proceduredetails.request.*;
import eIPAD.chartsummary.proceduredetails.response.*;


/**
 * Servlet implementation class ProcedureView 
 */
public class ProcedureView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcedureView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		PatContext patientContext = null;
		if(session.getAttribute("PatientContext") != null)
		{
			patientContext = (PatContext)session.getAttribute("PatientContext");
		}
		ProcedureDetailsRequest oProcReq = new ProcedureDetailsRequest();
		ProcedureDetailsResponse oProcRes = null;
		ProcedureDetailsBC oProcBC = new ProcedureDetailsBC();
		if(patientContext != null)
		{
			oProcReq.setPatientContext(patientContext);
		}
		try
		{
			oProcRes = oProcBC.getProcedureDetails(oProcReq);
			request.setAttribute("ProcedureDetailsResponse", oProcRes);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/ProcedureDetailView.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
