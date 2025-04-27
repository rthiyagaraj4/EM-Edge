/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.common.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.encounterlist.bc.EncounterListBC;
import eIPAD.chartsummary.encounterlist.healthobject.EncounterHO;
import eIPAD.chartsummary.encounterlist.request.EncounterListRequest;
import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;

/**
 * Servlet implementation class ChartWidgetsView 
 */
public class ChartWidgetsView extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		RequestDispatcher rd;
		PatContext patientContext;
		
		patientContext = (PatContext)session.getAttribute("PatientContext");

		EncounterListRequest encReq = new EncounterListRequest();
		EncounterListResponse encResp;
		if(patientContext!=null){
			encReq.setPatientContext(patientContext);
		}
		EncounterListBC encBC = new EncounterListBC();
		encResp = encBC.getEncounterList(encReq);
		
		//get the current encounter details
		encReq.setFilterEncounterId(patientContext.getEncounterId());
		EncounterListResponse currentEncResp;
		currentEncResp = encBC.getEncounterList(encReq);
		
		//Adding Current Base encounter to the top of the list
		if(encResp.isSuccessResponse() && !encResp.isEmptyDataResponse() && currentEncResp.isSuccessResponse() && !currentEncResp.isEmptyDataResponse()){
			ArrayList<EncounterHO> encList = encResp.getEncounterList();
			if(!currentEncResp.getEncounterList().isEmpty()){
				EncounterHO currentEnc = currentEncResp.getEncounterList().get(0);
				boolean curEncRemoved = encList.remove(currentEnc);
				encList.add(0, currentEnc);
			}

		}
			
		request.setAttribute("EncounterListResponse", encResp);
		//request.setAttribute("CurrentEncounterResponse", currentEncResp);
		
		rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/ChartSummaryBase-newUI.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
