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
package portalrefimpl.contactreason.cancelappointment.dac;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.contactreason.cancelappointment.ContactReasonCancelApptConstant;
import portalrefimpl.contactreason.cancelappointment.request.ContactReasonForCancelApptRequest;
import portalrefimpl.contactreason.cancelappointment.response.ContactReasonForCancelApptResponse;
import portalrefimpl.contactreason.common.model.ContactReasonModel;
import portalrefimpl.schedule.common.request.AppointmentType;

/**
 * This is the DAC layer class for the contact reason for cancel appointment
 * service
 * 
 * @author GRamamoorthy
 * 
 */
public class ContactReasonForCancelApptDAC {

	/**
	 * This method gets the contact reasons for the cancel appointment
	 * functionality
	 * 
	 * @param request
	 * @return
	 */
	public ContactReasonForCancelApptResponse getContactReasons(
			ContactReasonForCancelApptRequest request) {
		// initialize the response objects
		ContactReasonForCancelApptResponse response = new ContactReasonForCancelApptResponse();
		ErrorInfo errorInfo = new ErrorInfo();
/*		response.setErrorInfo(errorInfo);*/

		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		// get the connection
		Connection conn = PortalHelper.getConnection();
		// safe check
		if (conn == null) {
			errorCode = CommonConstants.DBCONNECTION_FAILURE_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.COMMON_MODULE_NAME, errorCode);
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			response.addError(errorInfo);
			return response;
		}
		// contact reason is obtained based on the appointment type
		// if the appointment is EM appointment, then there is a small
		// change in the SQL query
		// instead of manipulating one single SQL query , it is better
		// to have individual methods returning the contact reason

		AppointmentType appointmentType = request.getAppointmentType();
		if (AppointmentType.Appointment == appointmentType) {
			getContactReasonForEMAppointment(request, conn, response);
		} else if (AppointmentType.Appointment_Request == appointmentType) {
			getContactReasonForApptRequest(request, conn, response);
		}

		// all is done - return the connection
		PortalHelper.closeResources(conn);

		return response;
	}

	/**
	 * This method retrieves the contact reason for an EM appointment and
	 * populates it in the response object
	 * 
	 * @param request
	 * @param conn
	 * @param response
	 */
	private void getContactReasonForEMAppointment(
			ContactReasonForCancelApptRequest request, Connection conn,
			ContactReasonForCancelApptResponse response) {
		String sqlQuery = getSQLQueryForEMAppointment(request);
		Statement stmt = null;
		ResultSet rs = null;
		/*ErrorInfo errorInfo = response.getErrorInfo();*/
		ErrorInfo errorInfo = new ErrorInfo();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlQuery);
			if (rs == null) {
				int errorCode = ContactReasonCancelApptConstant.CANCEL_EM_APPT_NULLRESULTSET_ERRORCODE;
				String errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(
								CommonConstants.CONTACT_REASON_MODULE_NAME,
								errorCode);
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				
				response.addError(errorInfo);
				return;
			}

			// now populate the code and the description to the response object
			List<ContactReasonModel> contactReasonList = new ArrayList<ContactReasonModel>();
			ContactReasonModel contactReason = null;
			String code = null;
			String description = null;
			// iterate through the result set and get the data
			while (rs.next()) {
				code = rs.getString("code");
				description = rs.getString("description");

				contactReason = new ContactReasonModel(code, description);
				contactReasonList.add(contactReason);
			}
			// set the list to response
			response.setContactReasonList(contactReasonList);
			// check for no data
			if (contactReasonList.isEmpty()) {
				int errorCode = ContactReasonCancelApptConstant.CANCEL_EM_APPT_NO_DATA_FOUND_ERRORCODE;
				String errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(
								CommonConstants.CONTACT_REASON_MODULE_NAME,
								errorCode);
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				
				response.addError(errorInfo);
				return;
			}
			// finally set the success code to the error info object
			errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
			response.addError(errorInfo);
		} catch (SQLException e) {
			int errorCode = ContactReasonCancelApptConstant.CANCEL_EM_APPT_SQLEXCEPTION_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CONTACT_REASON_MODULE_NAME,
							errorCode);
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			response.addError(errorInfo);
		} finally {
			PortalHelper.closeResources(rs, stmt);
		}
	}

	/**
	 * This method gets the SQL query for getting contact reason for an EM
	 * appointment
	 * 
	 * @param request
	 * @return
	 */
	private String getSQLQueryForEMAppointment(
			ContactReasonForCancelApptRequest request) {
		String language = request.getLocale();
		StringBuffer queryBuffer = new StringBuffer();
		queryBuffer
				.append("Select CONTACT_REASON_CODE code, CONTACT_REASON description ");
		queryBuffer.append(" from AM_CONTACT_REASON_LANG_VW ");
		queryBuffer.append(" where cancel_Appointment_Yn = 'Y' ");
		queryBuffer.append(" and Eff_Status = 'E' ");
		queryBuffer.append(" and language_id = '" + language + "'");
		queryBuffer.append(" and upper(CONTACT_REASON_CODE) like upper('%') ");
		queryBuffer.append(" and upper(CONTACT_REASON) like upper('%') ");
		queryBuffer.append(" ORDER BY 2 ");
		return queryBuffer.toString();
	}

	/**
	 * This method retrieves the contact reason for an portal appointment
	 * request and populates it in the response object
	 * 
	 * @param request
	 * @param conn
	 * @param response
	 */
	private void getContactReasonForApptRequest(
			ContactReasonForCancelApptRequest request, Connection conn,
			ContactReasonForCancelApptResponse response) {
		String sqlQuery = getSQLQueryForApptRequest(request);
		Statement stmt = null;
		ResultSet rs = null;
		/*ErrorInfo errorInfo = response.getErrorInfo();*/
		ErrorInfo errorInfo = new ErrorInfo();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlQuery);
			if (rs == null) {
				int errorCode = ContactReasonCancelApptConstant.CANCEL_APPTREQ_NULLRESULTSET_ERRORCODE;
				String errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(
								CommonConstants.CONTACT_REASON_MODULE_NAME,
								errorCode);
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				
				response.addError(errorInfo);
				return;
			}

			// now populate the code and the description to the response object
			List<ContactReasonModel> contactReasonList = new ArrayList<ContactReasonModel>();
			ContactReasonModel contactReason = null;
			String code = null;
			String description = null;
			// iterate through the result set and get the data
			while (rs.next()) {
				code = rs.getString("code");
				description = rs.getString("description");

				contactReason = new ContactReasonModel(code, description);
				contactReasonList.add(contactReason);
			}
			// set the list to response
			response.setContactReasonList(contactReasonList);
			// check for no data
			if (contactReasonList.isEmpty()) {
				int errorCode = ContactReasonCancelApptConstant.CANCEL_APPTREQ_NO_DATA_FOUND_ERRORCODE;
				String errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(
								CommonConstants.CONTACT_REASON_MODULE_NAME,
								errorCode);
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				
				response.addError(errorInfo);
				return;
			}

			// finally set the success code to the error info object
			errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
			response.addError(errorInfo);
		} catch (SQLException e) {
			int errorCode = ContactReasonCancelApptConstant.CANCEL_APPTREQ_SQLEXCEPTION_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CONTACT_REASON_MODULE_NAME,
							errorCode);
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			response.addError(errorInfo);
		} finally {
			PortalHelper.closeResources(rs, stmt);
		}

	}

	/**
	 * This method gets the SQL query for getting contact reason for a portal
	 * appointment request
	 * 
	 * @param request
	 * @return
	 */
	private String getSQLQueryForApptRequest(
			ContactReasonForCancelApptRequest request) {
		String language = request.getLocale();
		StringBuffer queryBuffer = new StringBuffer();
		queryBuffer
				.append("Select CONTACT_REASON_CODE code, CONTACT_REASON description ");
		queryBuffer.append(" from AM_CONTACT_REASON_LANG_VW ");
		queryBuffer.append(" where CANCEL_WAIT_LIST_YN = 'Y' ");
		queryBuffer.append(" and Eff_Status = 'E' ");
		queryBuffer.append(" and language_id = '" + language + "'");
		queryBuffer.append(" and upper(CONTACT_REASON_CODE) like upper('%') ");
		queryBuffer.append(" and upper(CONTACT_REASON) like upper('%') ");
		queryBuffer.append(" ORDER BY 2 ");

		return queryBuffer.toString();
	}
	
	
	public static void main(String[] args){
		ContactReasonForCancelApptRequest request = new ContactReasonForCancelApptRequest();
//		request.setAppointmentType(AppointmentType.Appointment);
		request.setAppointmentType(AppointmentType.Appointment_Request);
		
		ContactReasonForCancelApptDAC dacInst = new ContactReasonForCancelApptDAC();
		ContactReasonForCancelApptResponse response = dacInst.getContactReasons(request);
		/*String xmlContent = JaxbHelper.marshallObject(response);
		System.out.println(xmlContent);*/
	}

}
