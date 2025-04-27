/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.schedule.viewupcomingappointment.dac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import portal.common.response.ErrorInfo;
import portal.schedule.viewupcomingappointment.request.UpcomingAppointmentDetailsRequest;
import portal.schedule.viewupcomingappointment.response.UpcomingAppointmentDetails;
import portal.schedule.viewupcomingappointment.response.UpcomingAppointmentDetailsResponse;
import portal.tools.ErrorMessageUtil;
import portal.tools.PortalHelper;
import portal.tools.UpcomingAppointmentDetailsConstant;

/**
 * This class is used to fetch the future appointments for the logged in patient
 * 
 * @author vkodancha
 * 
 */
public class UpcomingAppointmentDetailsDAC {

	private static Logger logger = Logger
			.getLogger(UpcomingAppointmentDetailsDAC.class.getName());
	private UpcomingAppointmentDetailsResponse response;
	private ErrorInfo errorInfo;

	/**
	 * This method is used to get the query. will be used only once during the
	 * first class call
	 * 
	 * @return
	 */
	public String getQuery(UpcomingAppointmentDetailsRequest request) {
		StringBuffer queryBuff = new StringBuffer();
		queryBuff
				.append(" select APPT_REF_NO APPT_NUMBER, to_char(appt_date,'dd/mm/yyyy') APPT_DATE,to_char(APPT_SLAB_FROM_TIME,'hh:mi AM') APPT_FROM_TIME, ");

		queryBuff
				.append(" to_char(APPT_SLAB_TO_TIME,'hh:mi AM') APPT_TO_TIME, ");
		queryBuff
				.append(" CLINIC_SHORT_DESC  CLINIC_NAME,PRACTITIONER_SHORT_NAME PRACTITIONER_NAME,SPECIALITY_DESC SPECIALITY,facility_id, facility_name,Appt_status,CLINIC_CODE ");
		queryBuff.append(" from oa_appt_vw where patient_id= ? ");
		// checking for facility Id
		if (request.getFaciltiyId() != null
				&& !request.getFaciltiyId().trim().isEmpty()) {
			queryBuff.append(" and facility_id= ? ");
		}

		// checking for from date and setting sysdate if from date is not sent
		if (request.getDateFrom() != null
				&& !request.getDateFrom().trim().isEmpty()) {
			queryBuff
					.append(" and trunc(appt_date) >=  to_date(?,'dd/mm/yyyy hh24:mi:ss')");
		} else {
			queryBuff
					.append(" and trunc(appt_date) >= trunc(sysdate) ");
		}
		// checking for the to date and setting parameter
		if (request.getDateTo() != null
				&& !request.getDateTo().trim().isEmpty()) {
			queryBuff
					.append("and trunc(appt_date) <=  to_date(?,'dd/mm/yyyy hh24:mi:ss')");
		}

		queryBuff.append(" order by appt_date,APPT_SLAB_FROM_TIME");
		return queryBuff.toString();
	}

	/**
	 * This method fetches the appointments from EM DB for patient portal
	 * application home page
	 * 
	 * @param request
	 * @return
	 */
	public UpcomingAppointmentDetailsResponse getUpcomingAppointmentDetails(
			UpcomingAppointmentDetailsRequest request) {
		logger.debug("inside the method : getUpcomingAppointmentDetails");
		response.setUpcomingAppointmentDetails(getUpcomingAppointmentList(request));
		logger.debug("returning the method : getUpcomingAppointmentDetails with response");
		return response;
	}

	/**
	 * This method queries the DB with the request information and gets the
	 * appointment details
	 * 
	 * @param request
	 * @return
	 */
	private List<UpcomingAppointmentDetails> getUpcomingAppointmentList(
			UpcomingAppointmentDetailsRequest request) {
		logger.info("Entering the method :getUpcomingAppointmentList");
		List<UpcomingAppointmentDetails> appointmentDetailsList = new ArrayList<UpcomingAppointmentDetails>();
		String patientId = request.getPatientId();
		String facilityId = request.getFaciltiyId();
		String fromDate = request.getDateFrom();
		String toDate = request.getDateTo();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = getQuery(request);
		logger.info("query in the  method :getUpcomingAppointmentList : "+query);
		int i = 2;
		conn = PortalHelper.getConnection();
		if (conn == null) {
			errorInfo = ErrorMessageUtil.getErrorMessage(
					UpcomingAppointmentDetailsConstant.MODULE_NAME,
					ErrorInfo.UPCOMING_APPT_CONNECTION_FAILURE_CODE);
			response.setErrorInfo(errorInfo);
			logger.info("Commection is null in the method :getUpcomingAppointmentList");
			return appointmentDetailsList;
		}
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, patientId);
			// setting facility Id
			if (facilityId != null && !facilityId.trim().isEmpty()) {
				pstmt.setString(i, facilityId);
				i++;
			}

			// setting from date
			if (fromDate != null && !fromDate.trim().isEmpty()) {
				pstmt.setString(i, fromDate);
				i++;
			}
			// setting to date
			if (toDate != null && !toDate.trim().isEmpty()) {
				pstmt.setString(i, toDate);
				i++;
			}
			rs = pstmt.executeQuery();
			if (rs != null) {
				appointmentDetailsList = getUpcomingAppointMentList(rs);
			}
			if (appointmentDetailsList == null
					|| appointmentDetailsList.isEmpty()) {
				errorInfo = ErrorMessageUtil.getErrorMessage(
						UpcomingAppointmentDetailsConstant.MODULE_NAME,
						ErrorInfo.UPCOMING_APPT_NO_DB_DATA_RETURNED_CODE);
				logger.info("NO DB data in the method :getUpcomingAppointmentList");
			} else {
				errorInfo = ErrorMessageUtil.getErrorMessage(
						UpcomingAppointmentDetailsConstant.MODULE_NAME,
						ErrorInfo.SUCCESS_CODE);
				logger.info("Success in the method :getUpcomingAppointmentList");
			}
		} catch (SQLException e) {
			errorInfo = ErrorMessageUtil.getErrorMessage(
					UpcomingAppointmentDetailsConstant.MODULE_NAME,
					ErrorInfo.UPCOMING_APPT_SQLEXCEPTION_CODE, e.getMessage());
			logger.error("Exception in the method :getUpcomingAppointmentList : msg:"
					+ e.getStackTrace().toString());
			// logger.log(Priority.toPriority(Priority.ERROR_INT),
			// e.getMessage(), e);
			logger.fatal(
					"Exception in the method :getUpcomingAppointmentList : stack trace: ",
					e);
		} finally {
			PortalHelper.closeResources(conn, pstmt, rs);
			conn = null;
		}
		response.setErrorInfo(errorInfo);
		logger.info("Leaving the method :getUpcomingAppointmentList");
		return appointmentDetailsList;
	}

	/**
	 * This method gets the list of appointments from result
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private List<UpcomingAppointmentDetails> getUpcomingAppointMentList(
			ResultSet rs) throws SQLException {
		logger.info("Entering the method :getUpcomingAppointMentList");
		List<UpcomingAppointmentDetails> appointmentDetailsList = new ArrayList<UpcomingAppointmentDetails>();
		while (rs.next()) {
			appointmentDetailsList.add(setResultSetToAppointment(rs));
		}
		logger.info("Leaving the method :getUpcomingAppointMentList");
		return appointmentDetailsList;
	}

	/**
	 * This method is used to get each appointment details from result set
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private UpcomingAppointmentDetails setResultSetToAppointment(ResultSet rs)
			throws SQLException {
		UpcomingAppointmentDetails appointmentDetails = new UpcomingAppointmentDetails();
		appointmentDetails.setApptNumber(rs.getString("APPT_NUMBER"));
		appointmentDetails.setAppointmentDate(rs.getString("APPT_DATE"));
		appointmentDetails.setPractitioner(rs.getString("PRACTITIONER_NAME"));
		appointmentDetails.setApptSpeciality(rs.getString("SPECIALITY"));
		appointmentDetails.setApptStartTime(rs.getString("APPT_FROM_TIME"));
		appointmentDetails.setApptEndTime(rs.getString("APPT_TO_TIME"));
		appointmentDetails.setLocation(rs.getString("CLINIC_CODE"));
		appointmentDetails.setFacilityName(rs.getString("facility_name"));
		appointmentDetails.setFacilityId(rs.getString("facility_id"));
		appointmentDetails.setStatus(rs.getString("Appt_status"));
		return appointmentDetails;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(UpcomingAppointmentDetailsResponse response) {
		this.response = response;
	}
}
