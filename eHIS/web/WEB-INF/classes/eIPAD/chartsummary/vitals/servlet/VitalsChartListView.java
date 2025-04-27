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

/**
 * Servlet implementation class VitalsChartListView 
 */
public class VitalsChartListView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VitalsChartListView() {
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
		VitalsRequest oVitalsReq = new VitalsRequest();
		oVitalsReq.setPatientContext(patientContext);
		VitalsConfigResponse oVitalsConfigResponse = null;
		SparkLineChartResponse oSparkLineResponse = null;
		VitalsBC oVitalsBC = new VitalsBC();
		try
		{
			oVitalsConfigResponse = oVitalsBC.getVitalsConfig(oVitalsReq);
			oSparkLineResponse =  oVitalsBC.getSparkLineChartData(oVitalsReq);
			
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			request.setAttribute("VitalsConfigResponse", oVitalsConfigResponse);
			request.setAttribute("SparkLineChartResponse", oSparkLineResponse);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/VitalsChart.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
