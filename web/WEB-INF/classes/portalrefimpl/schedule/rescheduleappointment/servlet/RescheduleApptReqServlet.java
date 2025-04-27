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
package portalrefimpl.schedule.rescheduleappointment.servlet;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import portalrefimpl.PortalConstants;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.rescheduleappointment.RescheduleRequestConstants;
import portalrefimpl.schedule.rescheduleappointment.request.RescheduleAppointmentRequest;
import portalrefimpl.schedule.rescheduleappointment.response.RescheduleAppointmentResponse;
import portalrefimpl.schedule.rescheduleappointment.svc.serviceinvoker.RescheduleAppointmentServiceInvoker;

/**
 * This is the servlet for performing reschedule of an appointment request
 * @author GRamamoorthy
 *
 */
public class RescheduleApptReqServlet extends HttpServlet {

	/**
	 * 
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * This is the main method in the class - performs the 
	 * reschedule of an appointment request
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// get the request object
		RescheduleAppointmentRequest request = getRescheduleApptRequest(req);
		
		RescheduleAppointmentServiceInvoker svcInvoker = new RescheduleAppointmentServiceInvoker();
		svcInvoker.registerService(request);
		RescheduleAppointmentResponse response = (RescheduleAppointmentResponse)svcInvoker.getDataThroughWebService(request);
		
		req.setAttribute(RescheduleRequestConstants.RESCHEDULE_APPTREQ_RESPONSE_PARAM,response);
		req.getRequestDispatcher("./RescheduleApptReqResult.jsp").forward(req, resp);
	}
	
	/**
	 * This method gets the reschedule appointment request
	 * @param req
	 * @return
	 */
	private RescheduleAppointmentRequest getRescheduleApptRequest(HttpServletRequest req){
		RescheduleAppointmentRequest request = new RescheduleAppointmentRequest();
		// only the following request parameters are to be considered
		// "hdnSelectedTimeSlot" - holds the selected time slot
		// "hdnFacilityId" - holds the facility id
		// "hdnSpecialtyId"  - holds the specialty id
		// "referenceNumber" - holds the appointment request reference number
		// "selectedPractitionerIdInPage" - holds the practitioner id
		// "hdnPreferredDateInTimeSlotFrame" - holds the preferred date
		// "hdnClinicCode" - holds the clinic code
		
		// first get patient id from session
		HttpSession session = req.getSession();
		String patientId = (String)session
				.getAttribute(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
		
		// selected from time and to time has to be in the format
		// "HH:mm"
		String selectedTimeSlot = req
				.getParameter(RescheduleRequestConstants.SELECTED_TIMESLOT_PARAM);
		String selectedFromTime = null;
		String selectedToTime = null;
		if(selectedTimeSlot != null){
			int dashIndex = selectedTimeSlot.indexOf("-"); 
			if(dashIndex > 0){
				selectedFromTime = selectedTimeSlot.substring(0, dashIndex);
				selectedFromTime = selectedFromTime.trim();
				selectedToTime = selectedTimeSlot.substring(dashIndex+1);
				selectedToTime = selectedToTime.trim();
			}
		}
		
		String facilityId = req.getParameter(RescheduleRequestConstants.HIDDEN_FACILITY_ID_PARAM);
		String specialtyId = req.getParameter(RescheduleRequestConstants.HIDDEN_SPECIALTY_ID_PARAM);
		String apptReqRefNumber = req.getParameter(RescheduleRequestConstants.GET_APPTREQUESTDETAILS_REFNUMBER_PARAM_KEY);
		String practitionerId = req.getParameter(RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERID_PARAM);
		String preferredDate = req.getParameter(RescheduleRequestConstants.HIDDEN_PREFERRED_DATE_TIMESLOT_PARAM);
		String locationCode = req.getParameter(RescheduleRequestConstants.HIDDEN_CLINIC_CODE_PARAM);
		String rescheduleReasonCode = req.getParameter(RescheduleRequestConstants.RESCHEDULE_REASON_CODE_PARAM);
		
		request.setFacilityId(facilityId);
		request.setAppointmentReferenceNumber(apptReqRefNumber);
		request.setSpecialityId(specialtyId);
		request.setCareLocationTypeIndicator(CreateAppointmentConstants.APPOINTMENT_CARE_LOCATION_TYPE_INDICATOR_VALUE);
		request.setLocale(Locale.getDefault().getLanguage());
		request.setLocationCode(locationCode);
		request.setModifiedFacilityId(facilityId);
		request.setPatientId(patientId);
		request.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
		request.setPractitionerId(practitionerId);
		request.setPreferredDate(preferredDate);
		request.setPreferredFromTime(selectedFromTime);
		request.setPreferredToTime(selectedToTime);
		request.setModifyReasonCode(rescheduleReasonCode);
		
		return request;
	}

}
