/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package eIP.advbedmgmt.transaction.patientfinancial.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import eIP.advbedmgmt.GBMConstants;
import eIP.advbedmgmt.transaction.patientfinancial.FinancialInfoConstants;
import eIP.advbedmgmt.transaction.patientfinancial.dao.FinancialInfoDAO;
import eIP.advbedmgmt.transaction.patientfinancial.dao.FinancialInfoDAOImpl;
import eIP.advbedmgmt.transaction.patientfinancial.request.FinancialInfoRequest;
import eIP.advbedmgmt.transaction.patientfinancial.response.FinancialInfoResponse;

/**
 * This servlet is used to get meta data needed for obtaining patient
 * financial information 
 * @author GRamamoorthy
 *
 */
public class FinancialInfoServlet extends HttpServlet {

	/**
	 * This method in turn calls doPost method
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * This is the main method in this class
	 * retrieves the meta data for obtaining patient financial information
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// get the facility id, patient id and encounter id from request
		HttpSession session = req.getSession();
		String facilityId = (String) session.getAttribute(GBMConstants.FACILITYID_SESSION_KEY);
		
		FinancialInfoRequest financialInfoRequest = new FinancialInfoRequest();
		financialInfoRequest.setFacilityId(facilityId);
		
		FinancialInfoDAO daoInst = new FinancialInfoDAOImpl();
		FinancialInfoResponse financialInfoResponse = daoInst
				.getPatientFinancialInfo(financialInfoRequest);
		
		String errorMessage = financialInfoResponse.getErrorMessage();
		if(errorMessage == null){
			errorMessage = "";
		}
		String encounterVisitNum = financialInfoResponse.getEncounterVisitNum();
		if(encounterVisitNum == null){
			encounterVisitNum = "";
		}
		
		// need to use gson to send out the response
		// initializing gson object to send the final response
		JsonObject jsonObj = null;
		jsonObj = new JsonObject();
		jsonObj.addProperty(FinancialInfoConstants.RESPONSE_ERRORMESSAGE_KEY,
				errorMessage);
		jsonObj.addProperty(FinancialInfoConstants.RESPONSE_ENCOUNTER_VISIT_NUM_KEY,
				encounterVisitNum);
		
		JsonArray jsonArr = new JsonArray();
		jsonArr.add(jsonObj);
		Gson gsonInst = new Gson();

		// finally send the JSON array
		PrintWriter out = resp.getWriter();
		out.println(gsonInst.toJson(jsonArr));
		// out.println(jsonArray);
		out.flush();
	}

}
