/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.homepage.dac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import portal.common.request.BaseRequest;
import portal.common.response.ErrorInfo;
import portal.homepage.response.PatientDetailsResponse;
import portal.tools.ErrorMessageUtil;
import portal.tools.PatientDetailsConstants;
import portal.tools.PortalHelper;
/**
 * This class is responsible for the retrieval 
 * of the patient details from EM data base
 * @author vkodancha
 *
 */
public class PatientDetailsDAC {
	
	private static Logger logger = Logger.getLogger(PatientDetailsDAC.class.getName());
	
	PatientDetailsResponse response;
	ErrorInfo errorInfo;

	/**
	 * @param errorInfo the errorInfo to set
	 */
	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(PatientDetailsResponse response) {
		this.response = response;
	}
	/**
	 * This method is called by the patient details business component 
	 * to retrieval the patient details from EM Data base
	 * @param request
	 * @return
	 */
	public PatientDetailsResponse getPatientDetails(BaseRequest request) {
		logger.info("Entering the method :getPatientDetails ");
		//PatientDetailsResponse response = new PatientDetailsResponse();
		//ErrorInfo errorInfo = new ErrorInfo();
		//response.setErrorInfo(errorInfo);

		String sqlQuery = "select patient_name,patient_id,NATIONAL_ID_NO,SEX,trunc(months_between(sysdate,DATE_OF_BIRTH)/12) age from mp_patient where patient_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = PortalHelper.getConnection();
			if (conn == null) {
				errorInfo = ErrorMessageUtil.getErrorMessage(
						PatientDetailsConstants.MODULE_NAME,
						ErrorInfo.PATIENT_CONNECTION_FAILURE_CODE);
				response.setErrorInfo(errorInfo);
				logger.info("Connection is null in the method :getPatientDetails");
				return response;
			}

			pstmt = conn.prepareStatement(sqlQuery);
			pstmt.setString(1, request.getPatientId());
			rs = pstmt.executeQuery();
			if (rs != null) {

				if (rs.next()) {
					response.setPatientName(rs.getString("patient_name"));
					response.setNationalIdNo(rs.getString("NATIONAL_ID_NO"));
					response.setSex(rs.getString("SEX"));
					response.setAge(rs.getInt("age"));
					errorInfo = ErrorMessageUtil.getErrorMessage(
							PatientDetailsConstants.MODULE_NAME,
							ErrorInfo.SUCCESS_CODE);
					response.setErrorInfo(errorInfo);
				}else{
					errorInfo = ErrorMessageUtil.getErrorMessage(
							PatientDetailsConstants.MODULE_NAME,
							ErrorInfo.PATIENT_NO_DB_DATA_RETURNED_CODE);
					response.setErrorInfo(errorInfo);
				}

			} else {
				errorInfo = ErrorMessageUtil.getErrorMessage(
						PatientDetailsConstants.MODULE_NAME,
						ErrorInfo.PATIENT_NO_DB_DATA_RETURNED_CODE);
				logger.info("No data in the method :getPatientDetails");
				response.setErrorInfo(errorInfo);
				return response;
			}

		} catch (Exception e) {
			/**
			 * TODO need to handle this with logging
			 */
			System.out.println("exception while obtaining test data "
					+ e.getMessage());
			errorInfo = ErrorMessageUtil.getErrorMessage(
					PatientDetailsConstants.MODULE_NAME,
					ErrorInfo.PATIENT_SQLEXCEPTION_CODE,e.getMessage());
			logger.error("Exception in the method :getPatientDetails : msg:"
					+ e.getStackTrace().toString());
			// logger.log(Priority.toPriority(Priority.ERROR_INT),
			// e.getMessage(), e);
			logger.fatal(
					"Exception in the method :getPatientDetails : stack trace: ", e);
			response.setErrorInfo(errorInfo);
			return response;
		} finally {
			PortalHelper.closeResources(conn, pstmt, rs);
			conn = null;
		}
		logger.info("Leaving the method :getHospitalInformation ");
		return response;
	}

}
