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
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.results.bc.ResultsBC;
import eIPAD.chartsummary.results.request.ResultsCatConstants;
import eIPAD.chartsummary.results.request.ResultsRequest;

/**
 * Servlet implementation class ResultsViewServlet 
 */
public class ResultsViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
		
		int allCount = 0;
		int labCount = 0;
		int radCount = 0;
		int surgCount = 0;
		int diagCount = 0;
		int othersCount = 0;
		String resultDataType = ResultsCatConstants.RESULTDATATYPE_ALL;
		ResultsBC bc = new ResultsBC();
		ArrayList<String> catReqList = new ArrayList<String>();
		
		//getting all results count by passing empty arraylist
		allCount = bc.getResultsCount(patientContext, catReqList, resultDataType);
		//getting lab results count
		catReqList.add(ResultsCatConstants.RESULTCATEGORY_LABORATORY);
		labCount = bc.getResultsCount(patientContext, catReqList, resultDataType);
		
		//getting radiology results count
		catReqList.clear();
		catReqList.add(ResultsCatConstants.RESULTCATEGORY_RADIOLOGYIMAGING);
		radCount = bc.getResultsCount(patientContext, catReqList, resultDataType);
		
		//getting Surgery results count
		catReqList.clear();
		catReqList.add(ResultsCatConstants.RESULTCATEGORY_SURGERYPROCEDURE);
		surgCount = bc.getResultsCount(patientContext, catReqList, resultDataType);
		
		//getting diagnostics results count
		catReqList.clear();
		catReqList.add(ResultsCatConstants.RESULTCATEGORY_DEPTDIAGNOSTICS);
		diagCount = bc.getResultsCount(patientContext, catReqList, resultDataType);
		
		//getting other results count
		catReqList.clear();
		catReqList.addAll(ResultsCatConstants.GETOTHERSCATLIST());
		othersCount = bc.getResultsCount(patientContext, catReqList, resultDataType);
		
		request.setAttribute("AllCount", allCount);
		request.setAttribute("LabCount", labCount);
		request.setAttribute("RadCount", radCount);
		request.setAttribute("SurgCount", surgCount);
		request.setAttribute("DiagCount", diagCount);
		request.setAttribute("OthersCount", othersCount);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/ResultsView.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);	
	}

}
