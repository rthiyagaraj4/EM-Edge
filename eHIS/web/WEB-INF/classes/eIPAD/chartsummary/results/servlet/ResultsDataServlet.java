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
import eIPAD.chartsummary.results.request.ResultsRequest;
import eIPAD.chartsummary.results.response.ResultsResponse;
import eIPAD.chartsummary.results.request.ResultsCatConstants;

/**
 * Servlet implementation class ResultsDataServlet 
 */
public class ResultsDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
		ResultsRequest resReq = new ResultsRequest();
		ResultsResponse resRes = new ResultsResponse();
		String groupBy = ResultsCatConstants.GROUPBY_SUBCATEGORY;
		if(patientContext!=null){
			resReq.setPatientContext(patientContext);
		}
		String category = request.getParameter("Category")==null?"":request.getParameter("Category");
		ArrayList<String> catReqList = new ArrayList<String>();
		
		if(category.equals(ResultsCatConstants.RESULTCATEGORY_LABORATORY)){
			catReqList.add(ResultsCatConstants.RESULTCATEGORY_LABORATORY);
		}
		else if(category.equals(ResultsCatConstants.RESULTCATEGORY_RADIOLOGYIMAGING)){
			catReqList.add(ResultsCatConstants.RESULTCATEGORY_RADIOLOGYIMAGING);
		}
		else if(category.equals(ResultsCatConstants.RESULTCATEGORY_SURGERYPROCEDURE)){
			catReqList.add(ResultsCatConstants.RESULTCATEGORY_SURGERYPROCEDURE);
		}
		else if(category.equals(ResultsCatConstants.RESULTCATEGORY_DEPTDIAGNOSTICS)){
			catReqList.add(ResultsCatConstants.RESULTCATEGORY_DEPTDIAGNOSTICS);
		}
		else if(category.equals(ResultsCatConstants.RESULTCATEGORY_OTHERS)){
			catReqList.addAll(ResultsCatConstants.GETOTHERSCATLIST());
			//in case of others result list, the tabular form grouping in UI is done by Category and in other cases it is subcategory
			groupBy = ResultsCatConstants.GROUPBY_CATEGORY;
		}

		resReq.setCategories(catReqList);
		ResultsBC bc = new ResultsBC();
		resRes = bc.getResultDetails(resReq);
		request.setAttribute("ResultsResponse", resRes);
		request.setAttribute("GroupBy", groupBy);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/ResultsData.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);	
	}

}
