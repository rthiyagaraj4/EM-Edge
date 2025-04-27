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
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import portalrefimpl.PortalConstants;
import portalrefimpl.schedule.common.request.AppointmentRequest;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.createappointment.appointmentrequest.ResponseContainerImpl;
import portalrefimpl.schedule.createappointment.request.BookAppointmentRequest;
import portalrefimpl.schedule.createappointment.response.BookAppointmentResponse;
import portalrefimpl.schedule.createappointment.svc.serviceinvoker.BookAppointmentServceInvoker;

/**
 * @author GRamamoorthy
 *
 */
public class BookAppointmentServlet extends HttpServlet {

	
	/**
	 * 
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * this is the main method of this class
	 * handles the book appointment functionality
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BookAppointmentRequest bookAppointmentRequest = getBookAppointmentRequest(req);
		
		/*BookAppointmentSvcImpl svcImpl = new BookAppointmentSvcImpl();
		svcImpl.registerService(bookAppointmentRequest);*/
		BookAppointmentServceInvoker serviceInvoker = new BookAppointmentServceInvoker();
		serviceInvoker.registerService(bookAppointmentRequest);
		BookAppointmentResponse response = (BookAppointmentResponse) serviceInvoker
				.getDataThroughWebService(bookAppointmentRequest);
		req.setAttribute("BookAppointmentResponse", response);
		req.getRequestDispatcher("./BookAppointmentResult.jsp").forward(req, resp);
		
	}
	
	/**
	 * This method forms an instance of the book appointment request
	 * and returns it
	 * @param req
	 * @return
	 */
	private BookAppointmentRequest getBookAppointmentRequest(HttpServletRequest req){
		BookAppointmentRequest request = new BookAppointmentRequest();
		
		// get all the parameters from the request
		String facilityId = req
				.getParameter(CreateAppointmentConstants.APPT_PREFERREDFACILITY_PARAMETER_KEY);
		if(facilityId == null){
			facilityId = "";
		}
		
		String preferredDate = req
				.getParameter(CreateAppointmentConstants.BOOKAPPOINTMENT_PREFERREDDATE_REQUEST_PARAM);
		if(preferredDate == null){
			preferredDate = "";
		}
		
		String practitionerId = req
				.getParameter(CreateAppointmentConstants.BOOKAPPOINTMENT_PRACTITIONERID_REQUEST_PARAM);
		if(practitionerId == null){
			practitionerId = "";
		}
		
		String specialty = req
				.getParameter(CreateAppointmentConstants.BOOKAPPOINTMENT_SELECTEDSPECIALTY_REQUEST_PARAM);
		if(specialty == null){
			specialty = "";
		}
		
		String clinicCode = req
				.getParameter(CreateAppointmentConstants.BOOKAPPOINTMENT_CLINICCODE_REQUEST_PARAM);
		if(clinicCode == null){
			clinicCode = "";
		}
		// selected from time and to time has to be in the format
		// "dd/MM/yyyy HH:mm"
		String selectedTimeSlot = req
				.getParameter(CreateAppointmentConstants.BOOKAPPOINTMENT_SELECTEDTIMESLOT_REQUEST_PARAM);
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
			//selectedFromTime = preferredDate + " " + selectedFromTime;
			//selectedToTime = preferredDate + " " + selectedToTime;
		}
		
		HttpSession session = req.getSession();
		String patientId = (String)session
				.getAttribute(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
		
		request.setFacilityId(facilityId);
		request.setLocale(Locale.getDefault().getLanguage());
		request.setPatientId(patientId);
		request.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
		request.setPractitionerId(practitionerId);
		request.setPreferredDate(preferredDate);
		request.setPreferredFromTime(selectedFromTime);
		request.setPreferredToTime(selectedToTime);
		request.setRequestObjectType(AppointmentRequest.BOOKAPPOINTMENT_TYPE);
		request.setResponseContainer(new ResponseContainerImpl());
		request.setSpecialityId(specialty);
		request.setServiceCall(true);
		request.setLocationCode(clinicCode);
		
		return request;
	}
	

}
