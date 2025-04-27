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
package eIP.advbedmgmt.transaction.patientsearch.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import eIP.advbedmgmt.transaction.patientsearch.PatientSearchConstants;
import eIP.advbedmgmt.transaction.patientsearch.dao.PatientSearchDAOImpl;
import eIP.advbedmgmt.transaction.patientsearch.request.PatientSearchRequest;
import eIP.advbedmgmt.transaction.patientsearch.response.PatientSearchResponse;

/**
 * This is the servlet class for patient search functionality This servlet finds
 * the nursing unit for a given patient id and returns the same as JSON object
 * 
 * @author gramamoorthy
 * 
 */
public class PatientSearchServlet extends HttpServlet {

	/**
	 * Handles GET request - present only to delegate call to doPost method
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * Handles POST request performs the main logic of retrieving the nursing
	 * unit for the given patient id
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// get data from request parameters - patient id and facility id
		String patientId = req
				.getParameter(PatientSearchConstants.PATIENTID_REQUEST_KEY);
		if(patientId == null){
			patientId = "";
		}
		String facilityId = req
				.getParameter(PatientSearchConstants.FACILITYID_REQUEST_KEY);
		if(facilityId == null){
			facilityId = "";
		}
		
		String locale = req.getLocale().getLanguage();
				
		// initialize the patient search request object
		PatientSearchRequest patSearchRequest = new PatientSearchRequest();
		patSearchRequest.setPatientId(patientId);
		patSearchRequest.setFacilityId(facilityId);
		patSearchRequest.setLocale(locale);
		// initialize the dao instance and get response
		PatientSearchDAOImpl daoImpl = new PatientSearchDAOImpl();
		PatientSearchResponse patSearchResponse = daoImpl
				.getPatientNursingUnit(patSearchRequest);
		
		// check the response and form the json object
		String errorMessage = "";
		String respPatientId = patSearchResponse.getPatientId();
		String respNursingUnit = "";
		String roomNumber = "";
		String bedNumber = "";
		// get the nursing unit only when response is successful
		// else get the error message
		if (patSearchResponse.isSuccessful()) {
			respNursingUnit = patSearchResponse.getNursingUnitCode();
		} else {
			errorMessage = patSearchResponse.getErrorMessage();
		}
		roomNumber = patSearchResponse.getRoomNumber();
		bedNumber = patSearchResponse.getBedNumber();

		// initializing gson object to send the final response
		JsonObject jsonObj = null;
		JsonArray jsonArr = null;
		jsonObj = new JsonObject();
		jsonObj.addProperty(
				PatientSearchConstants.RESPONSE_ERRORMESSAGE_KEYWORD,
				errorMessage);
		jsonObj.addProperty(PatientSearchConstants.RESPONSE_PATIENTID_KEYWORD,
				respPatientId);
		jsonObj.addProperty(
				PatientSearchConstants.RESPONSE_NURSINGUNIT_CODE_KEYWORD,
				respNursingUnit);
		jsonObj.addProperty(
				PatientSearchConstants.RESPONSE_ROOM_NUMBER_KEYWORD, roomNumber);
		jsonObj.addProperty(PatientSearchConstants.RESPONSE_BED_NUMBER_KEYWORD,
				bedNumber);
		jsonObj.addProperty(
				PatientSearchConstants.RESPONSE_ADMISSION_STATUS_KEYWORD,
				patSearchResponse.getPatientStatus().toString());
		
		jsonArr = new JsonArray();
		jsonArr.add(jsonObj);
		Gson gsonInst = new Gson();

		// finally send the JSON array
		PrintWriter out = resp.getWriter();
		out.println(gsonInst.toJson(jsonArr));
		// out.println(jsonArray);
		out.flush();

	}

}
