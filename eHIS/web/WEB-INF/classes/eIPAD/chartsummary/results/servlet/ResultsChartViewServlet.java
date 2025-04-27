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
import eIPAD.chartsummary.results.response.ResultsResponse;

/**
 * Servlet implementation class ResultsChartViewServlet 
 */
public class ResultsChartViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
		ResultsRequest resReq = new ResultsRequest();
		ResultsBC bc = new ResultsBC();
		//only numeric results are required since this is a graph view
		String resultDataType =  ResultsCatConstants.RESULTDATATYPE_NUM;
		ArrayList<String> catReqList = new ArrayList<String>();
		if(patientContext!=null){
			resReq.setPatientContext(patientContext);
		}
		
		
		resReq.setResultsType(resultDataType);
		int totalResCount = bc.getResultsCount(patientContext, catReqList, resultDataType);
		request.setAttribute("TotalResultsCount", totalResCount);
		
		//Getting Lab results
		catReqList.add(ResultsCatConstants.RESULTCATEGORY_LABORATORY);
		resReq.setCategories(catReqList);
		ResultsResponse resLabRes;
		resLabRes = bc.getResultDetails(resReq);
		request.setAttribute("LabResultsResponse", resLabRes);
		
		//Getting Radiology results
		catReqList.clear();
		catReqList.add(ResultsCatConstants.RESULTCATEGORY_RADIOLOGYIMAGING);
		resReq.setCategories(catReqList);
		ResultsResponse resRadRes;
		resRadRes = bc.getResultDetails(resReq);
		request.setAttribute("RadiologyResultsResponse", resRadRes);
		
		//Getting Surgery results
		catReqList.clear();
		catReqList.add(ResultsCatConstants.RESULTCATEGORY_SURGERYPROCEDURE);
		resReq.setCategories(catReqList);
		ResultsResponse resSurgRes;
		resSurgRes = bc.getResultDetails(resReq);
		request.setAttribute("SurgeryResultsResponse", resSurgRes);
		
		//Getting Diagnostics results
		catReqList.clear();
		catReqList.add(ResultsCatConstants.RESULTCATEGORY_DEPTDIAGNOSTICS);
		resReq.setCategories(catReqList);
		ResultsResponse resDiagRes;
		resDiagRes = bc.getResultDetails(resReq);
		request.setAttribute("DiagnosticsResultsResponse", resDiagRes);
		
		//Getting other results
		catReqList.clear();
		catReqList.addAll(ResultsCatConstants.GETOTHERSCATLIST());
		resReq.setCategories(catReqList);
		ResultsResponse resOthRes;
		resOthRes = bc.getResultDetails(resReq);
		request.setAttribute("OthersResultsResponse", resOthRes);

	
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/ResultsChart.jsp");
		rd.forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
