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
import eIPAD.chartsummary.allergies.request.EventTypeRequest;
import eIPAD.chartsummary.allergies.response.EventTypeResponse;



/**
 * Servlet implementation class RecordAllergyView 
 */
public class RecordAllergyView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordAllergyView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String locale = "en";
		String eventTypeIndicator = "01";
		String transferPage = "/eIPAD/jsp/chartwidgets/RecordAllergy.jsp";
		if(session.getAttribute("LOCALE") != null)
		{
			 locale = (String)session.getAttribute("LOCALE");
			 if(locale.equals(""))
			 {
				 locale = "en";
			 }
		}
		if(request.getParameter("eventTypeIndicator") != null && !request.getParameter("eventTypeIndicator").equals(""))
		{
			eventTypeIndicator = request.getParameter("eventTypeIndicator");
			transferPage = "/eIPAD/jsp/chartwidgets/ComboPopulate.jsp";
		}
		EventTypeRequest oEvtTypReq = new EventTypeRequest();
		EventTypeResponse oEvtTypeRes = null ;
		oEvtTypReq.setLocale(locale);
		oEvtTypReq.setEventTypeIndicator(eventTypeIndicator);
		AllergyBC allergyBC = new AllergyBC();
		try
		{
			oEvtTypeRes = allergyBC.getEventTypeDetails(oEvtTypReq);
			
		}
		catch(Exception e)
		{
			if(oEvtTypeRes != null)
			{
				oEvtTypeRes.setbServletException(true);
				oEvtTypeRes.setExceptionMessage(e.toString());
				e.printStackTrace();
			}
		}
		finally
		{
			request.setAttribute("EventTypeResponse",oEvtTypeRes);
			RequestDispatcher rd = session.getServletContext().getRequestDispatcher(transferPage);
			rd.forward(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
