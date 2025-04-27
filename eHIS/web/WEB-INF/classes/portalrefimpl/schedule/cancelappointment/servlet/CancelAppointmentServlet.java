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
package portalrefimpl.schedule.cancelappointment.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import portalrefimpl.PortalConstants;
import portalrefimpl.schedule.ScheduleConstants;
import portalrefimpl.schedule.cancelappointment.request.CancelAppointmentRequest;
import portalrefimpl.schedule.cancelappointment.response.CancelAppointmentResponse;
import portalrefimpl.schedule.cancelappointment.svc.CancelAppointmentServiceInvoker;
import portalrefimpl.schedule.common.request.AppointmentType;

/**
 * This servlet class performs the cancellation of appointments
 * 
 * @author GRamamoorthy
 * 
 */
public class CancelAppointmentServlet extends HttpServlet {

	/**
	 * 
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * This is the main method of this class Performs the cancellation of an
	 * appointment
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// get the request object
		CancelAppointmentRequest request = getCancelAppointmentRequest(req);

		/*CancelAppointmentSvcImpl svcImpl = new CancelAppointmentSvcImpl();
		svcImpl.registerService(request);*/

		CancelAppointmentServiceInvoker serviceInvoker = new CancelAppointmentServiceInvoker();
		serviceInvoker.registerService(request);
		CancelAppointmentResponse response = (CancelAppointmentResponse) serviceInvoker
				.getDataThroughWebService(request);
		req.setAttribute(ScheduleConstants.CANCELAPPT_RESPONSE_ATTRIBUTE_KEY,
				response);
		req.getRequestDispatcher("./CancelAppResult.jsp").forward(req, resp);

	}

	/**
	 * This method forms an instance of CancelAppointmentRequest using the input
	 * HttpServletRequest object and returns the same
	 * 
	 * @param req
	 * @return
	 */
	private CancelAppointmentRequest getCancelAppointmentRequest(
			HttpServletRequest req) {
		// initialize the request object
		CancelAppointmentRequest request = new CancelAppointmentRequest();
		// get data from the request
		String appointmentNumber = req
				.getParameter(ScheduleConstants.CANCELAPPT_APPT_NUMBER_REQUEST_PARAM_KEY);
		String appointmentStatus = req
				.getParameter(ScheduleConstants.CANCELAPPT_APPT_STATUS_REQUEST_PARAM_KEY);
		String facilityId = req
				.getParameter(ScheduleConstants.CANCELAPPT_FACILITYID_REQUEST_PARAM_KEY);
		String reasonCode = req
				.getParameter(ScheduleConstants.CANCELAPPT_REASONCODE_REQUEST_PARAM_KEY);

		request.setAppointmentReferenceNumber(appointmentNumber);
		AppointmentType appointmentType = null;
		if (appointmentStatus != null) {
			if (ScheduleConstants.CANCELAPPT_APPT_IDENTIFIER
					.equals(appointmentStatus)) {
				appointmentType = AppointmentType.Appointment;
			} else if (ScheduleConstants.CANCELAPPT_APPT_REQUEST_TYPE_IDENTIFIER
					.equals(appointmentStatus)) {
				appointmentType = AppointmentType.Appointment_Request;
			}
			request.setAppointmentType(appointmentType);
		}

		request.setFacilityId(facilityId);
		request.setReasonForCancellation(reasonCode);

		// set the patient id and the portal user name also to request
		HttpSession session = req.getSession();
		String patientId = (String) session
				.getAttribute(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
		if (patientId == null) {
			patientId = (String) getServletConfig().getServletContext()
					.getAttribute("patientId");
			if (patientId == null) {
				patientId = "";
			}
		}
		request.setPatientId(patientId);
		request.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);

		return request;
	}

}
