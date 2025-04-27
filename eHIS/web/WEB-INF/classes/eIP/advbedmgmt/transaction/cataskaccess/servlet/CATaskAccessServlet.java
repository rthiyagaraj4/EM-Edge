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
package eIP.advbedmgmt.transaction.cataskaccess.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import eIP.advbedmgmt.transaction.cataskaccess.CATaskAccessConstants;
import eIP.advbedmgmt.transaction.cataskaccess.dao.CATaskAccessDAOImpl;
import eIP.advbedmgmt.transaction.cataskaccess.request.CATaskAccessRequest;
import eIP.advbedmgmt.transaction.cataskaccess.response.CATaskAccessResponse;
import eIP.advbedmgmt.transaction.cataskaccess.response.CATaskAccessResult;

/**
 * This is the servlet class for checking GBM module access to CA task
 * 
 * @author GRamamoorthy
 * 
 */
public class CATaskAccessServlet extends HttpServlet {

	/**
	 * delegates call to doPost
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * main method in this class checks whether a specified task (in the
	 * request) in CA module can be accessed by a specified responsibility
	 * Returns the result of the check as GSON (JSON) object
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// get the facility id,responsibility id and the task id from the
		// request parameter
		String facilityId = req
				.getParameter(CATaskAccessConstants.FACILITYID_REQUEST_KEY);
		String responsibilityId = req
				.getParameter(CATaskAccessConstants.RESPONSIBILITY_ID_REQUEST_KEY);
		String taskId = req
				.getParameter(CATaskAccessConstants.TASK_ID_REQUEST_KEY);

		// initialize the request object
		CATaskAccessRequest caTaskAccessRequest = new CATaskAccessRequest();
		caTaskAccessRequest.setFacilityId(facilityId);
		caTaskAccessRequest.setResponsibilityId(responsibilityId);
		caTaskAccessRequest.setTaskId(taskId);
		// initialize the dao impl, call the operation and get response
		CATaskAccessDAOImpl daoImpl = new CATaskAccessDAOImpl();
		CATaskAccessResponse caTaskAccessResponse = daoImpl
				.checkCATaskAccess(caTaskAccessRequest);

		// check the response and form the json object
		String errorMessage = caTaskAccessResponse.getErrorMessage();
		CATaskAccessResult taskResult = caTaskAccessResponse.getAccessResult();
		// initializing gson object to send the final response
		JsonObject jsonObj = null;
		JsonArray jsonArr = null;
		jsonObj = new JsonObject();
		jsonObj.addProperty(
				CATaskAccessConstants.RESPONSE_ERRORMESSAGE_KEYWORD,
				errorMessage);
		jsonObj.addProperty(
				CATaskAccessConstants.RESPONSE_ACCESSRESULT_KEYWORD,
				taskResult.toString());
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
