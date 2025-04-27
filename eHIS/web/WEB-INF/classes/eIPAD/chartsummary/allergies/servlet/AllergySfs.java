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

import eIPAD.chartsummary.common.bc.*;
import eIPAD.chartsummary.common.response.*;
import eIPAD.chartsummary.allergies.request.*;

/**
 * Servlet implementation class AllergySfs 
 */
public class AllergySfs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllergySfs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		// TODO Auto-generated method stub
/*		HttpSession session = request.getSession(true);
		String path = "/eIPAD/jsp/chartwidgets/AllergenSFS.jsp";

		if(request.getParameter("hdnSfsType").equals("3"))
		{
			path = "/eIPAD/jsp/chartwidgets/ReactionSFS.jsp";
		}
		RequestDispatcher rd = session.getServletContext().getRequestDispatcher(path);
		rd.forward(request, response);*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String locale = "en";
		String eventTypeIndicator = "01";
		String eventTypeCode = "";
	//	boolean bCanExecuteQuery = false;
		String searchCriteria = "";
		String searchBy = "DESCRIPTION";
		String allergenType = "";
		
		AllergySFSRequest oAllergySfsReq = new AllergySFSRequest();
		SfsResponse oSfsRes = null;
		String path = "/eIPAD/jsp/chartwidgets/AllergenSFS.jsp";
		if(request.getParameter("SC") != null && !request.getParameter("SC").equals(""))
		{
			searchCriteria = request.getParameter("SC");
		}
		if(request.getParameter("SB") != null && !request.getParameter("SB").equals(""))
		{
			searchBy = request.getParameter("SB");
		}
		if(session.getAttribute("LOCALE") != null)
		{
			 locale = (String)session.getAttribute("LOCALE");
			 if(locale.equals(""))
			 {
				 locale = "en";
			 }
		}
		oAllergySfsReq.setLocale(locale);
		oAllergySfsReq.setbDuplicateValues(false);
		oAllergySfsReq.setSearhcBy(searchBy);
		oAllergySfsReq.setSearchCriteria(searchCriteria);
		
		if(request.getParameter("hdnSfsType") != null && !request.getParameter("hdnSfsType").equals(""))
		{
			if(request.getParameter("hdnSfsType").equals("1"))
			{
				if(request.getParameter("EI") != null && !request.getParameter("EI").equals(""))
				{
					eventTypeIndicator = request.getParameter("EI");
				}
				if(request.getParameter("EC") != null && !request.getParameter("EC").equals(""))
				{
					eventTypeCode = request.getParameter("EC");
				}
				oAllergySfsReq.setSfsType(1);
				oAllergySfsReq.setEventTypeCode(eventTypeCode);
				oAllergySfsReq.setEventTypeIndicator(eventTypeIndicator);
			}
			if(request.getParameter("hdnSfsType").equals("2"))
			{
				if(request.getParameter("AT") != null )
				{
					allergenType = request.getParameter("AT");
				}
				oAllergySfsReq.setAllergenType(allergenType);
				oAllergySfsReq.setSfsType(2);
			}
			if(request.getParameter("hdnSfsType").equals("3"))
			{
				if(request.getParameter("EI") != null && !request.getParameter("EI").equals(""))
				{
					eventTypeIndicator = request.getParameter("EI");
				}
				if(request.getParameter("EC") != null && !request.getParameter("EC").equals(""))
				{
					eventTypeCode = request.getParameter("EC");
				}
				if(request.getParameter("AT") != null )
				{
					allergenType = request.getParameter("AT");
				}
				oAllergySfsReq.setAllergenType(allergenType);
				oAllergySfsReq.setbDuplicateValues(true);
				oAllergySfsReq.setSfsType(3);
				oAllergySfsReq.setEventTypeCode(eventTypeCode);
				oAllergySfsReq.setEventTypeIndicator(eventTypeIndicator);
				path = "/eIPAD/jsp/chartwidgets/ReactionSFS.jsp";
			}
		}
		SfsBC OsfsBc = new SfsBC();
		try
		{
			oSfsRes = OsfsBc.getSfsDetails(oAllergySfsReq);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			request.setAttribute("SfsResponse",oSfsRes);
			//request.setAttribute("EC",eventTypeCode);
			//request.setAttribute("EI",eventTypeIndicator);
			RequestDispatcher rd = session.getServletContext().getRequestDispatcher(path);
			rd.forward(request, response);
		}
		
	}

}
