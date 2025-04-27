/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.vitals.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eIPAD.chartsummary.vitals.request.*;
import eIPAD.chartsummary.vitals.response.*;
import eIPAD.chartsummary.vitals.bc.*;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.constants.*;


/**
 * Servlet implementation class VitalsView 
 */
public class VitalsView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VitalsView() {
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
		VitalsRequest oVitalsReq = new VitalsRequest();
		if(session.getAttribute("PatientContext") != null)
		{
			patientContext = (PatContext)session.getAttribute("PatientContext");
		}
		if(request.getParameter("isRankRequired") != null && request.getParameter("isRankRequired").equals("S"))
		{
			oVitalsReq.setRankRequired(true);
		}
		if(request.getParameter("fromScreen") != null && !request.getParameter("fromScreen").equals(""))
		{
			oVitalsReq.setFromScreen(request.getParameter("fromScreen"));
		}
		if(request.getParameter("DV") != null && !request.getParameter("DV").equals("")) // filter by eventCode
		{
			oVitalsReq.setFilterByEventCode(request.getParameter("DV"));
		}
		String path = LocalizationConstants.VITALS_VIEW;
		oVitalsReq.setPatientContext(patientContext);
		CurrentAndHistoryResponse oCurrentAndHistoryResponse = null;
		VitalsConfigResponse oVitalsConfigResponse = null;
		VitalsBC oVitalsBC = new VitalsBC();
		try
		{
			oVitalsConfigResponse = oVitalsBC.getVitalsConfig(oVitalsReq);
			if(oVitalsConfigResponse != null && oVitalsConfigResponse.getChartId() != null && !oVitalsConfigResponse.getChartId().equals(""))
			{
				oVitalsReq.setChartId(oVitalsConfigResponse.getChartId());
			}
			
			if((oVitalsReq.getFromScreen() == null || (oVitalsReq.getFromScreen() != null && oVitalsReq.getFromScreen().equals(""))) || (oVitalsReq.getFromScreen() != null && !oVitalsReq.getFromScreen().equals("TV")))
			{
				oCurrentAndHistoryResponse = oVitalsBC.getDiscreteValues(oVitalsReq);
			}
			
			//oCurrentAndHistoryResponse = oVitalsBC.getDiscreteValues(oVitalsReq);
			
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			if(oVitalsReq.getFromScreen() != null && oVitalsReq.getFromScreen().equals("CLV")) //chart list view
			{
				path = LocalizationConstants.VITALS_CHART_VIEW;
			}
			if(oVitalsReq.getFromScreen() != null && oVitalsReq.getFromScreen().equals("TV")) // tabular view
			{
				path = LocalizationConstants.VITALS_TABULAR_VIEW;
			}
			if(oVitalsReq.getFromScreen() != null && oVitalsReq.getFromScreen().equals("VV")) // discrete values in tabular view
			{
				path = LocalizationConstants.VITALS_TABULAR_VIEW_VALUE;
			}
			request.setAttribute("VitalsConfigResponse", oVitalsConfigResponse);
			request.setAttribute("CurrentAndHistoryResponse", oCurrentAndHistoryResponse);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(path);
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
