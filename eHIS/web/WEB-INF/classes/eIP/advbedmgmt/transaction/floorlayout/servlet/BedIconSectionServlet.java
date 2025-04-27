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
import eCommon.Common.CommonBean;
import eIP.advbedmgmt.GBMConstants;
import eIP.advbedmgmt.transaction.floorlayout.FloorLayoutConstants;
import eIP.advbedmgmt.transaction.floorlayout.bc.BedDetailsBC;
import eIP.advbedmgmt.transaction.floorlayout.request.BedIconRequest;
import eIP.advbedmgmt.transaction.floorlayout.response.BedIconResponse;
import eIP.advbedmgmt.transaction.floorlayout.response.BedIconSection;
import eIP.advbedmgmt.transaction.floorlayout.response.RoomForBedIconSection;

/**
 * This servlet is for getting bed icon section data
 * Used to render the images in the icon section of individual beds 
 * @author GRamamoorthy
 *
 */
public class BedIconSectionServlet extends HttpServlet {

	/**
	 * This method in turn calls the doPost() 
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * This is the main method in this class
	 * retrieves bed icon section data and returns as JSON array
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// get data from request and call the dao impl to get bed icon section
		// input to the dao are - facility id, nursing unit code and
		// bill operation
		HttpSession session = req.getSession();
		String facilityId = (String) session
				.getAttribute(GBMConstants.FACILITYID_SESSION_KEY);
		facilityId = CommonBean.checkForNull(facilityId);
		String blOper = (String) session.getAttribute("bl_operational");
		blOper = CommonBean.checkForNull(blOper,
				FloorLayoutConstants.BILL_OPERATIONAL_DEFAULT_VALUE);
		String nursingUnitCode = req
				.getParameter(FloorLayoutConstants.NURSINGUNIT_REQUEST_PARAM_KEY);
		nursingUnitCode = CommonBean.checkForNull(nursingUnitCode);
		String locale = (String)session.getAttribute(GBMConstants.LOCALE_SESSION_KEY);
		locale = CommonBean.checkForNull(locale, GBMConstants.LOCALE_DEFAULT_VALUE);
		final String BED_NUMBER = "%%";
		
		// form the request
		BedIconRequest bedIconRequest = new BedIconRequest();
		bedIconRequest.setFacilityId(facilityId);
		bedIconRequest.setNursingUnitCode(nursingUnitCode);
		bedIconRequest.setBlOperational(blOper);
		bedIconRequest.setLangId(locale);
		bedIconRequest.setBedNumber(BED_NUMBER);
		// get data through BC class
		ApplicationContext context = new ClassPathXmlApplicationContext(
				GBMConstants.SPRING_BEANS_XML_NAME);
		BedDetailsBC bcInst = (BedDetailsBC) context
				.getBean(FloorLayoutConstants.BED_DETAILS_BC_NAME);
		BedIconResponse bedIconResponse = bcInst.getBedIconSectionDetails(bedIconRequest);
		
		// now convert response to JSON
		String errorMessage = bedIconResponse.getErrorMessage();
		errorMessage = CommonAdapter.checkForNull(errorMessage);
		JsonArray jsonArr = new JsonArray();
		JsonObject jsonObj = null;
		// success response 
		if (bedIconResponse.isSuccessful()) {
			List<RoomForBedIconSection> rooms = bedIconResponse.getRooms();
			List<BedIconSection> beds = null;
			String roomNum = null;
			String bedNum = null;
			String encounterId = null;
			String knownAllergy = null;
			String billExists = null;
			int futureBookingCnt = 0;
			int medOverDueCnt = 0;
			int abnormalResultsCnt = 0;
			int pubResultsCnt = 0;
			int ordersCnt = 0;
			// iterate through rooms and get beds
			for(RoomForBedIconSection room : rooms){
				roomNum = room.getRoomNumber();
				beds = room.getBedIcons();
				// ignore empty rooms
				if(beds == null || beds.isEmpty()){
					continue;
				}
 
				for(BedIconSection bed : beds){
					bedNum = bed.getBedNumber();
					encounterId = bed.getEncounterId();
					
					knownAllergy = bed.getKnownAllergy();
					billExists = bed.getBillExists();
					futureBookingCnt = bed.getFutureBookingCount();
					medOverDueCnt = bed.getMedicationOverDueCount();
					abnormalResultsCnt = bed.getAbnormalResultCount();
					pubResultsCnt = bed.getPublishedResultCount();
					ordersCnt = bed.getOrdersCount();
					
					
					jsonObj = new JsonObject();
					jsonObj.addProperty(FloorLayoutConstants.ERRORMESSAGE_RESPONSE_KEY, "");
					jsonObj.addProperty(FloorLayoutConstants.ROOMNUMBER_RESPONSE_KEY, roomNum);
					jsonObj.addProperty(FloorLayoutConstants.BEDNUMBER_RESPONSE_KEY, bedNum);
					jsonObj.addProperty(FloorLayoutConstants.ENCOUNTERID_RESPONSE_KEY,encounterId);
					jsonObj.addProperty(FloorLayoutConstants.KNOWN_ALLERGY_RESPONSE_KEY,knownAllergy);
					jsonObj.addProperty(FloorLayoutConstants.BILL_EXISTS_RESPONSE_KEY,billExists);
					jsonObj.addProperty(FloorLayoutConstants.FUTURE_BOOKING_RESPONSE_KEY,futureBookingCnt);
					jsonObj.addProperty(FloorLayoutConstants.MED_OVER_DUE_RESPONSE_KEY,medOverDueCnt);
					jsonObj.addProperty(FloorLayoutConstants.ABNORMAL_RESULTS_RESPONSE_KEY,abnormalResultsCnt);
					jsonObj.addProperty(FloorLayoutConstants.PUBLISHED_RESULTS_RESPONSE_KEY,pubResultsCnt);
					jsonObj.addProperty(FloorLayoutConstants.ORDERS_RESPONSE_KEY,ordersCnt);
					
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
		resp.setContentType("application/json");
		Gson gsonInst = new Gson();
		PrintWriter out = resp.getWriter();
		//System.out.println(gsonInst.toJson(bedIconResponse));
		out.println(gsonInst.toJson(jsonArr));
		out.flush();
		
	}

	
	
}
