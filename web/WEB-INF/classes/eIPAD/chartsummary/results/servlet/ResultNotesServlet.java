/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.results.servlet;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eIPAD.chartsummary.results.bc.ResultsBC;
/**
 * @author SaraswathiR 
 *
 */

public class ResultNotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String histRecType = request.getParameter("HistRecType")==null?"":request.getParameter("HistRecType");
		String contSysId = request.getParameter("ContSysId")==null?"":request.getParameter("ContSysId");
		String accessionNum = request.getParameter("AccessionNum")==null?"":request.getParameter("AccessionNum");
		String contrSysEventCode = request.getParameter("ContrSysEventCode")==null?"":request.getParameter("ContrSysEventCode");
		ResultsBC bc = new ResultsBC();
		String notes = bc.getResultNotes(histRecType, contSysId, accessionNum, contrSysEventCode);
		request.setAttribute("Notes", notes);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/ResultNotes.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
