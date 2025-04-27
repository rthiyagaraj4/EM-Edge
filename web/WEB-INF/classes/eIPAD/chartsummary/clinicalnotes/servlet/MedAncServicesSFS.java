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

import eIPAD.chartsummary.activeproblems.bc.ProblemsDiagnosisBC;
import eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC;
import eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesFieldResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;

/**
 * Servlet implementation class MedAncServicesSFS 
 */
public class MedAncServicesSFS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedAncServicesSFS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd;
		boolean postBack = request.getParameter("hdnPostback")!=null&&request.getParameter("hdnPostback").equals("true")?true:false;
		HttpSession session = request.getSession(false);
		PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
		
		if(patientContext!=null){
			if(postBack){
				String searchCriteria = request.getParameter("hdnSearchType") == null? "":request.getParameter("hdnSearchType");//Code or Desc
				String searchText = request.getParameter("SearchText") == null? "":request.getParameter("SearchText");//Search Text
				
				ClinicalNotesFieldResponse cnResponse ;
				ClinicalNotesBC cnBC = new ClinicalNotesBC();
				cnResponse = cnBC.getMedAncServiceList( searchText,  searchCriteria,patientContext);
				request.setAttribute("SfsResponse",cnResponse);
			}
		}
		
		rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesMedAncServiceSFS.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
