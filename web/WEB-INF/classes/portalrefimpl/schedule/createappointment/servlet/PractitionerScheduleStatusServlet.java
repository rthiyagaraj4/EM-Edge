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
package portalrefimpl.schedule.createappointment.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import portalrefimpl.PortalConstants;
import portalrefimpl.schedule.ScheduleHelper;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.createappointment.request.PractitionerScheduleStatusRequest;
import portalrefimpl.schedule.createappointment.response.PractitionerScheduleStatusResponse;
import portalrefimpl.schedule.createappointment.response.ScheduleStatus;
import portalrefimpl.schedule.createappointment.svc.serviceinvoker.PractitionerScheduleStatusServiceInvoker;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * This servlet is used to direct the user to
 * select time slot for a practitioner
 * @author GRamamoorthy
 *
 */
public class PractitionerScheduleStatusServlet extends HttpServlet {

	/**
	 * 
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * This is the main method in this class
	 * invokes the practitioner time slot jsp in turn
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// get data from request 
		String facilityId = req.getParameter(CreateAppointmentConstants.APPT_PREFERREDFACILITY_PARAMETER_KEY);//"HS";
		if(facilityId == null){
			facilityId = "";
		}
		
		// preferred date is the preferred from date
		String preferredDate = req.getParameter(CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY);
		if(preferredDate == null){
			preferredDate = req.getParameter("hdnPreferredDate");
			if(preferredDate == null){
				preferredDate = "";
			}
		}
		
		// this is for calculating the end date
		// by default the end date is 1 month from the from date
		/*Date dateVal = PortalHelper.getDateFromString(preferredDate,
				CreateAppointmentConstants.PRACTITIONERSTATUS_DATEFORMAT);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(dateVal);
		endCalendar.add(Calendar.DATE,
				CreateAppointmentConstants.BOOKAPPT_PREFERREDENDDATE_RANGE);
		String endDateStr = PortalHelper.getDateAsString(endCalendar.getTime(),
				CreateAppointmentConstants.PRACTITIONERSTATUS_DATEFORMAT);*/
		String endDateStr = ScheduleHelper.getPreferredEndDateForTimeSlot(preferredDate);
		
		/*String preferredFromTime = req.getParameter(CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY);
		if(preferredFromTime == null){
			preferredFromTime = "";
		}
		
		String preferredToTime = req.getParameter(CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY);
		if(preferredToTime == null){
			preferredToTime = "";
		}*/
		
		String clinicCode = req.getParameter("hdnClinicCode");//AC4";
		if(clinicCode == null){
			clinicCode = "";
		}

		String practitionerId = req.getParameter("hdnPractitionerId");//"AFNIZAR";
		if(practitionerId == null){
			practitionerId = "";
		}
		
		String clinicType = CreateAppointmentConstants.PRACTITIONERSCHEDULESTATUS_DEFAULT_CLINICTYPE;
		String resourceType = CreateAppointmentConstants.PRACTITIONER_SERVICE_RESOURCECLASS_DEFAULT_VALUE;
		
		// initialize the request object for the service call
		PractitionerScheduleStatusRequest request = new PractitionerScheduleStatusRequest();
		request.setFacilityId(facilityId);
		request.setPractitionerId(practitionerId);
		request.setClinicCode(clinicCode);
		request.setClinicType(clinicType);
		request.setResourceType(resourceType);
		request.setLocale(Locale.getDefault().getLanguage());
		request.setPreferredFromDate(preferredDate);
		request.setPreferredToDate(endDateStr);
		
		String patientId = (String)req.getSession().getAttribute(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
		if(patientId == null){
			patientId = "";
		}
		request.setPatientId(patientId);
		request.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
		
		// initialize the service impl and register it
		// this is needed to make a successful service call
		/*PractitionerScheduleStatusSvcImpl svcImpl = new PractitionerScheduleStatusSvcImpl();
		svcImpl.registerService(request);*/
		// initialize the service client class
		// through this only we will get data
		PractitionerScheduleStatusServiceInvoker svcInvoker = new PractitionerScheduleStatusServiceInvoker();
		svcInvoker.registerService(request);
		PractitionerScheduleStatusResponse response = (PractitionerScheduleStatusResponse) svcInvoker
				.getDataThroughWebService(request);
		
		/*JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = null;*/
		Gson gsonInst = new Gson();
		JsonArray jsonArray = new JsonArray();
		JsonObject jsonObject = null;
		
		// inspect the response for error - if so
		// form an error json object and return it
		/*ErrorInfo errorInfo = response.getErrorInfo();*/
		/*if(ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()){*/
		if(response.isSuccessful()){
			// response is successful - get the schedule status objects
			// form json objects and add to array
			List<ScheduleStatus> scheduleStatusList = response.getScheduleDateList();
			for(ScheduleStatus scheduleStatus : scheduleStatusList){
				jsonObject = new JsonObject();
				jsonObject.addProperty("errorMessage","");
				jsonObject.addProperty("scheduleDate",scheduleStatus.getScheduleDate());
				jsonObject.addProperty("scheduleStatus", scheduleStatus.getStatus().toString());
				jsonArray.add(jsonObject);
			}
			
			/*jsonObject = new JsonObject();
			String errorMessage = response.getErrorMessage();
			jsonObject.addProperty("errorMessage", errorMessage);
			jsonObject.addProperty("scheduleDate","");
			jsonObject.addProperty("scheduleStatus", "");
			jsonArray.add(jsonObject);*/
			
		}else{
			jsonObject = new JsonObject();
			String errorMessage = response.getErrorMessage();
			jsonObject.addProperty("errorMessage", errorMessage);
			jsonObject.addProperty("scheduleDate","");
			jsonObject.addProperty("scheduleStatus", "");
			jsonArray.add(jsonObject);
			
			
			/*// response is successful - get the schedule status objects
			// form json objects and add to array
			List<ScheduleStatus> scheduleStatusList = response.getScheduleDateList();
			for(ScheduleStatus scheduleStatus : scheduleStatusList){
				jsonObject = new JSONObject();
				jsonObject.put("scheduleDate",scheduleStatus.getScheduleDate());
				jsonObject.put("scheduleStatus", scheduleStatus.getStatus().toString());
				jsonObject.put("errorMessage","");
				
				jsonArray.add(jsonObject);
				
				jsonObject = new JsonObject();
				jsonObject.addProperty("errorMessage","");
				jsonObject.addProperty("scheduleDate",scheduleStatus.getScheduleDate());
				jsonObject.addProperty("scheduleStatus", scheduleStatus.getStatus().toString());
				jsonArray.add(jsonObject);
			}*/
		}
		
		// finally send the JSON array
		PrintWriter out = resp.getWriter();
		out.println(gsonInst.toJson(jsonArray));
		//out.println(jsonArray);
		out.flush();
		
	}

}
