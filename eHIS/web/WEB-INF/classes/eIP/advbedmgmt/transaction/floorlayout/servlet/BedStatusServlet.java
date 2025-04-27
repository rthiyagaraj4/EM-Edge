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
package eIP.advbedmgmt.transaction.floorlayout.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import eCommon.Common.CommonAdapter;
import eIP.advbedmgmt.GBMConstants;
import eIP.advbedmgmt.common.CommonHelper;
import eIP.advbedmgmt.common.model.BasicBed;
import eIP.advbedmgmt.common.model.BasicRoom;
import eIP.advbedmgmt.common.model.BedStatusEnum;
import eIP.advbedmgmt.transaction.BedHelper;
import eIP.advbedmgmt.transaction.floorlayout.FloorLayoutConstants;
import eIP.advbedmgmt.transaction.floorlayout.bc.BedDetailsBC;
import eIP.advbedmgmt.transaction.floorlayout.request.BedStatusRequest;
import eIP.advbedmgmt.transaction.floorlayout.response.BedStatusResponse;

/**
 * This is the servlet for getting bed statuses
 * 
 * @author GRamamoorthy
 * 
 */
public class BedStatusServlet extends HttpServlet {

	/**
	 * 
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * This is the main method in this class This class gets the bed status and
	 * returns JSON response
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// get data from request and call the dao impl to get bed status
		HttpSession session = req.getSession();
		String facilityId = (String) session
				.getAttribute(GBMConstants.FACILITYID_SESSION_KEY);
		String nursingUnitCode = req
				.getParameter(FloorLayoutConstants.NURSINGUNIT_REQUEST_PARAM_KEY);
		String bedCountStr = req	
				.getParameter(FloorLayoutConstants.BEDCOUNT_REQUEST_PARAM_KEY);
		int bedCount = CommonHelper.getIntegerValue(bedCountStr, 0);
		final String BED_NUMBER = "%%";
		
		BedStatusRequest bedStatusRequest = new BedStatusRequest();
		bedStatusRequest.setBedCount(bedCount);
		bedStatusRequest.setFacilityId(facilityId);
		bedStatusRequest.setNursingUnitCode(nursingUnitCode);
		bedStatusRequest.setBedNumber(BED_NUMBER);

		/*BedDetailsDAO daoImpl = new BedDetailsDAOImpl();*/
		// get data through BC class
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"app-beans.xml");
		BedDetailsBC bcInst = (BedDetailsBC) context.getBean("basicBedDetails");
		BedStatusResponse bedStatusResponse = bcInst
				.getBedStatusDetails(bedStatusRequest);
		String errorMessage = bedStatusResponse.getErrorMessage();
		errorMessage = CommonAdapter.checkForNull(errorMessage);
		
		JsonArray jsonArr = new JsonArray();
		JsonObject jsonObj = null;
		// success response 
		if (bedStatusResponse.isSuccessful()) {
			List<BasicRoom> roomList = bedStatusResponse.getRoomList();
			List<BasicBed> bedList = null;
			// room list will be valid
			String roomNumber = null;
			String bedNumber = null;
			String bedColor = null;
			String bedTxtColor = null;
			BedStatusEnum bedStatus = null;
			for(BasicRoom room : roomList){
				roomNumber = room.getRoomNumber();
				bedList = room.getBedList();
				// safe check
				if(bedList == null || bedList.isEmpty()){
					continue;
				}
				// iterate through bed instances and form json object
				for(BasicBed bedInst : bedList){
					bedNumber = bedInst.getBedNumber();
					bedStatus = bedInst.getBedStatus();
					bedColor = BedHelper.getBedStatusColor(bedStatus);
					bedTxtColor = BedHelper.getBedTxtColor(bedStatus);
					
					jsonObj = new JsonObject();
					jsonObj.addProperty(FloorLayoutConstants.ERRORMESSAGE_RESPONSE_KEY, "");
					jsonObj.addProperty(FloorLayoutConstants.ROOMNUMBER_RESPONSE_KEY, roomNumber);
					jsonObj.addProperty(FloorLayoutConstants.BEDNUMBER_RESPONSE_KEY, bedNumber);
					jsonObj.addProperty(FloorLayoutConstants.BEDCOLOR_RESPONSE_KEY,bedColor);
					jsonObj.addProperty(FloorLayoutConstants.BED_TXT_COLOR_RESPONSE_KEY,bedTxtColor);
				
					
					jsonArr.add(jsonObj);
				}
			}
		}else{
			jsonObj = new JsonObject();
			jsonObj.addProperty(FloorLayoutConstants.ERRORMESSAGE_RESPONSE_KEY,
					errorMessage);
			jsonArr.add(jsonObj);
		}

		// finally send the JSON array
		Gson gsonInst = new Gson();
		PrintWriter out = resp.getWriter();
		out.println(gsonInst.toJson(jsonArr));
		out.flush();

	}

}
