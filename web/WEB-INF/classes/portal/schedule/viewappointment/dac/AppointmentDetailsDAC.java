/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.schedule.viewappointment.dac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import portal.common.response.ErrorInfo;
import portal.schedule.viewappointment.request.AppointmentDetailsRequest;
import portal.schedule.viewappointment.response.AppointmentDetails;
import portal.schedule.viewappointment.response.AppointmentDetailsResponse;
import portal.tools.AppointmentDetailConstant;
import portal.tools.ErrorMessageUtil;
import portal.tools.PortalHelper;

/**
 * This class is used to fetch the future 
 * appointments for the logged in patient
 * 
 * @author vkodancha
 * 
 */
public class AppointmentDetailsDAC {

	private static Logger logger = Logger
			.getLogger(AppointmentDetailsDAC.class.getName());
	AppointmentDetailsResponse response;
	ErrorInfo errorInfo;

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(AppointmentDetailsResponse response) {
		this.response = response;
	}

	/**
	 * @param errorInfo
	 *            the errorInfo to set
	 */
	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}

	/**
	 * This method fetches the appointments from EM DB for patient portal
	 * application home page
	 * 
	 * @param request
	 * @return
	 */
	public AppointmentDetailsResponse getAppointmentDetails(
			AppointmentDetailsRequest request) {
		logger.debug("Entering the method :getAppointmentDetails");
		List<AppointmentDetails> appointmentDetailsList = new ArrayList<AppointmentDetails>();
		appointmentDetailsList = getAppointmentDetailsList(request);

		// set the list of appointment details to the response
		response.setAppointmentDetailsList(appointmentDetailsList);
		logger.debug("Leaving the method :getAppointmentDetails");
		return response;
	}

	/**
	 * This method queries the DB with the request information and gets the
	 * appointment details
	 * 
	 * @param request
	 * @return
	 */
	private List<AppointmentDetails> getAppointmentDetailsList(
			AppointmentDetailsRequest request) {
		logger.debug("Entering the method :getAppointmentDetailsList");
		List<AppointmentDetails> appointmentDetailsList = new ArrayList<AppointmentDetails>();
		String patientId = request.getPatientId();
		int resultSize = request.getResultSetSize();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer queryBuff = getQueryString(resultSize);
		logger.debug("queryBuff :"+queryBuff.toString());
		try {

			conn = PortalHelper.getConnection();
			if (conn == null) {
				errorInfo = ErrorMessageUtil.getErrorMessage(
						AppointmentDetailConstant.MODULE_NAME,
						ErrorInfo.HOME_APPT_CONNECTION_FAILURE_CODE);
				response.setErrorInfo(errorInfo);
				logger.info("Connection is null in the method :getAppointmentDetailsList");
				return appointmentDetailsList;
			}

			pstmt = conn.prepareStatement(queryBuff.toString());

			pstmt.setString(1, patientId);
			//pstmt.setString(2, facilityId);
			if (resultSize > 0) {
				pstmt.setInt(2, resultSize);
			}
			rs = pstmt.executeQuery();
			if (rs != null) {
				appointmentDetailsList = getAppointmentDetailsList(rs);
			}
			if (appointmentDetailsList == null
					|| appointmentDetailsList.isEmpty()) {
				errorInfo = ErrorMessageUtil.getErrorMessage(
						AppointmentDetailConstant.MODULE_NAME,
						ErrorInfo.HOME_APPT_NO_DB_DATA_RETURNED_CODE);
				logger.info("NO DB data in the method :getAppointmentDetailsList");
			} else {
				errorInfo = ErrorMessageUtil.getErrorMessage(
						AppointmentDetailConstant.MODULE_NAME,
						ErrorInfo.SUCCESS_CODE);
				logger.info("SUCCESS in the method :getAppointmentDetailsList");
			}
		} catch (SQLException e) {
			errorInfo = ErrorMessageUtil.getErrorMessage(
					AppointmentDetailConstant.MODULE_NAME,
					ErrorInfo.HOME_APPT_SQLEXCEPTION_CODE,e.getMessage());
			System.out.println(e.getMessage());
			logger.error("Exception in the method :getAppointmentDetailsList : msg:"
					+ e.getStackTrace().toString());
			// logger.log(Priority.toPriority(Priority.ERROR_INT),
			// e.getMessage(), e);
			logger.fatal(
					"Exception in the method :getAppointmentDetailsList : stack trace: ",
					e);
		} finally {
			PortalHelper.closeResources(conn, pstmt, rs);
			conn = null;
		}
		logger.debug("Leaving the method :getAppointmentDetailsList");
		response.setErrorInfo(errorInfo);
		return appointmentDetailsList;
	}

	/**
	 * This method creates the customized query for fetching the result
	 * 
	 * @param resultSize
	 * @return
	 */
	private StringBuffer getQueryString(int resultSize) {
		StringBuffer queryBuff = new StringBuffer();
		queryBuff
				.append(" select APPT_REF_NO APPT_NUMBER, to_char(appt_date,'dd/mm/yyyy') APPT_DATE,to_char(APPT_SLAB_FROM_TIME,'hh:mi AM') APPT_FROM_TIME, ");

		queryBuff
				.append(" to_char(APPT_SLAB_TO_TIME,'hh:mi AM') APPT_TO_TIME, ");
		queryBuff
				.append(" CLINIC_SHORT_DESC  CLINIC_NAME,PRACTITIONER_SHORT_NAME PRACTITIONER_NAME,SPECIALITY_DESC SPECIALITY ");
		queryBuff.append(" from oa_appt_vw where patient_id= ? ");
		queryBuff
		.append("and trunc(appt_date) >= trunc(sysdate");
		 if("1".equals(PortalHelper.getWebServiceURL("isTestDataEnabled"))){
			 queryBuff.append("-182");
		 }
		 queryBuff
			.append(")");
		if (resultSize > 0) {
			queryBuff.append(" and rownum <= ? ");
		}
		queryBuff.append(" order by appt_date,APPT_SLAB_FROM_TIME");
		return queryBuff;
	}

	/**
	 * This method creates the response list from result set
	 * 
	 * @param rs
	 * @return
	 */
	private List<AppointmentDetails> getAppointmentDetailsList(ResultSet rs)
			throws SQLException {
		List<AppointmentDetails> appointmentDetailsList = new ArrayList<AppointmentDetails>();
		AppointmentDetails appointmentDetails = null;

		String practId = null;
		String speciality = null;
		String apptDate = null;
		String toTime = null;
		String fromTime = null;
		String apptNumber = null;

		while (rs.next()) {
			appointmentDetails = new AppointmentDetails();

			apptNumber = rs.getString("APPT_NUMBER");
			appointmentDetails.setApptNumber(apptNumber);

			apptDate = rs.getString("APPT_DATE");
			appointmentDetails.setAppointmentDate(apptDate);

			practId = rs.getString("PRACTITIONER_NAME");
			appointmentDetails.setPractitioner(practId);

			speciality = rs.getString("SPECIALITY");
			appointmentDetails.setApptSpeciality(speciality);

			fromTime = rs.getString("APPT_FROM_TIME");
			appointmentDetails.setApptStartTime(fromTime);

			toTime = rs.getString("APPT_TO_TIME");
			appointmentDetails.setApptEndTime(toTime);

			appointmentDetailsList.add(appointmentDetails);
		}
		return appointmentDetailsList;
	}

}
