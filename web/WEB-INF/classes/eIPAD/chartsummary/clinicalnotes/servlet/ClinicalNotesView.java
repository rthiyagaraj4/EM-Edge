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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;


import eIPAD.chartsummary.clinicalnotes.bc.*;
import eIPAD.chartsummary.clinicalnotes.request.*;
import eIPAD.chartsummary.clinicalnotes.response.*;
import eIPAD.chartsummary.common.healthobject.PatContext;

/**
 * Servlet implementation class ClinicalNotesView 
 */
public class ClinicalNotesView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClinicalNotesView() {
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
		String viewType = "";
		String noteType = "";
		if(session.getAttribute("PatientContext") != null)
		{
			patientContext = (PatContext)session.getAttribute("PatientContext");
		}
		ClinicalNotesRequest oCnReq = new ClinicalNotesRequest();
		oCnReq.setPatientContext(patientContext);
		oCnReq.setGroupBy("NoteType");
		ClinicalNotesResponse oCnRes = null;
		ClinicalNotesBC oCnBC = new ClinicalNotesBC();
		String finalStartDate = request.getParameter("finalStartDate");
		String finalEndDate = request.getParameter("finalEndDate");
		String encounterID = request.getParameter("encounterID");
		
		String viewPage = request.getParameter("viewPage")==null?"":request.getParameter("viewPage");
		String filterBy = "";
		
		if(request.getParameter("finalStartDate") !=null){
			finalStartDate = request.getParameter("finalStartDate");
			oCnReq.setFinalStartDate(finalStartDate);
		}
		if(request.getParameter("finalEndDate") !=null){
			finalEndDate = request.getParameter("finalEndDate");
			oCnReq.setFinalEndDate(finalEndDate);
		}
		if(request.getParameter("encounterID") !=null){
			encounterID = request.getParameter("encounterID");
			oCnReq.setEncounterID(encounterID);
		}
		
		
		if(request.getParameter("filterBy") != null)
		{
			filterBy = request.getParameter("filterBy");
			oCnReq.setFilterBy(filterBy);
		}
		if(request.getParameter("viewType") != null)
		{
			viewType = request.getParameter("viewType");
			oCnReq.setViewType(viewType);
		}
		if(request.getParameter("noteType") != null)
		{
			noteType = request.getParameter("noteType");
			oCnReq.setNoteType(noteType);
		}
		if(request.getParameter("startIndex") != null && !request.getParameter("startIndex").equals(""))
		{
			int startIndex = Integer.parseInt(request.getParameter("startIndex"));
			oCnReq.setStartIndex(startIndex);
		}
		if(request.getParameter("endIndex") != null && !request.getParameter("endIndex").equals(""))
		{
			int endIndex = Integer.parseInt(request.getParameter("endIndex"));
			oCnReq.setEndIndex(endIndex);
		}
		try
		{
			if(viewPage.equals("fullView")){
				oCnReq.setViewPage(viewPage);
				oCnRes = oCnBC.getNoteDetails(oCnReq);
			}
			else if(viewPage.equals("fullViewTimeRange")){
				oCnReq.setViewPage(viewPage);
				oCnRes = oCnBC.getNoteDetailsTimeRange(oCnReq);
			}
			else if(viewPage.equals("fullViewEncounter")){
				oCnReq.setViewPage(viewPage);
				oCnRes = oCnBC.getNoteDetails(oCnReq);
				}
			else{
				oCnRes = oCnBC.getNoteDetails(oCnReq);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(viewPage == null){
				//System.out.println("came inside finally If");
				oCnRes = oCnBC.getNoteDetails(oCnReq);
			}
			//oCnRes = oCnBC.getNoteDetails(oCnReq);
			
			request.setAttribute("ClinicalNotesViewResponse", oCnRes);
			if(viewType.equals("AccordionView")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/ClinicalNotesAccordion.jsp");
				rd.forward(request, response);
			}
			else if(viewType.equals("AccordionViewTimeRange")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/ClinicalNotesAccordionTimeRange.jsp");
				rd.forward(request, response);
			}
			else if(viewType.equals("addNoteBubble")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/ClinicalNotesBubble.jsp");
				rd.forward(request, response);
			}
			else
			{
				if(viewPage.equals("fullView"))
				{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/clinicalnotes/ViewClinicalNotes.jsp");
				rd.forward(request, response);
				}
				else if(viewPage.equals("fullViewTimeRange"))
				{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/clinicalnotes/ViewClinicalNotesTimeRange.jsp");
				rd.forward(request, response);
				}
				else if(viewPage.equals("fullViewEncounter"))
				{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/clinicalnotes/ViewClinicalNotes.jsp");
				rd.forward(request, response);
				}
				
				else{ //widgetView
					//if(viewPage.equals("widgetView"))
					//{
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/ClinicalNotes.jsp");
						rd.forward(request, response);
					//}
				}
			}

			
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
