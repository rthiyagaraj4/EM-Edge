/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.login.dac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import portal.common.response.ErrorInfo;
import portal.login.request.LoginRequest;
import portal.login.response.LoginResponse;
import portal.tools.ErrorMessageUtil;
import portal.tools.LoginKeyConstants;
import portal.tools.PortalHelper;
/**
 * 
 * This method will connect to the database to validate 
 * the login credentials
 * 
 * @author vkodancha
 *
 */
public class LoginDAC {
	/**
	 * This method gets the patient login information
	 * @param request
	 * @return
	 */
	private static Logger logger = Logger.getLogger(LoginDAC.class.getName());
	
	public LoginResponse getLoginDetails(LoginRequest request) {
		
		logger.info("Entering the method :getLoginDetails");
		LoginResponse response = new LoginResponse();
		ErrorInfo errorInfo = new ErrorInfo();
		response.setErrorInfo(errorInfo);
		
		// Date of birth to be entered as mm/dd/yy format.
		/*String sqlQuery = "select patient_id from mp_patient where patient_id = '" + request.getPatientId() + "' " +
				" and to_char(DATE_OF_BIRTH,'YYYY-MM-DD') = to_char(to_date('" + request.getDateOfBirth() + "','DD/MM/YYYY'), 'YYYY-MM-DD')";*/
		String sqlQuery ="select patient_id from mp_patient where upper(patient_id)=upper('"+ request.getPatientId() +"') " +
				"and DATE_OF_BIRTH=TO_DATE(NVL (('"+ request.getDateOfBirth() +"'),'01/01/1000'),'dd/mm/yyyy')";
		
		logger.debug("sqlQuery : " + sqlQuery);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = PortalHelper.getConnection();
			if (conn == null) {
				errorInfo = ErrorMessageUtil.getErrorMessage(
						LoginKeyConstants.MODULE_NAME,
						ErrorInfo.CONNECTION_FAILURE_CODE);
				response.setErrorInfo(errorInfo);
				logger.info("Connection is null in the method :getLoginDetails");
				return response;
			}

			pstmt = conn.prepareStatement(sqlQuery);
			rs = pstmt.executeQuery();
			if (rs != null) {

				if(rs.next()){
					errorInfo = ErrorMessageUtil.getErrorMessage(
							LoginKeyConstants.MODULE_NAME,
							ErrorInfo.SUCCESS_CODE);
					logger.debug("Success in the method :getLoginDetails");
					response.setErrorInfo(errorInfo);
					return response;					
				} else {
					errorInfo = ErrorMessageUtil.getErrorMessage(
							LoginKeyConstants.MODULE_NAME,
							ErrorInfo.INVALID_LOGIN_CODE);
					logger.debug("Invalid login the method :getLoginDetails");
					response.setErrorInfo(errorInfo);
				}
			} else {
				errorInfo = ErrorMessageUtil.getErrorMessage(
						LoginKeyConstants.MODULE_NAME,
						ErrorInfo.INVALID_LOGIN_CODE);
				logger.debug("Invalid login the method :getLoginDetails");
				response.setErrorInfo(errorInfo);
				return response;
			}

		} catch (Exception e) {
			/**
			 * TODO need to handle this with logging
			 */
			errorInfo = ErrorMessageUtil.getErrorMessage(
					LoginKeyConstants.MODULE_NAME,
					ErrorInfo.SQLEXCEPTION_CODE,e.getMessage());
			logger.error("Exception in the method :getTestReport : msg:"
					+ e.getStackTrace().toString());
			// logger.log(Priority.toPriority(Priority.ERROR_INT),
			// e.getMessage(), e);
			logger.fatal(
					"Exception in the method :getTestReport : stack trace: ", e);
			response.setErrorInfo(errorInfo);
			return response;
		} finally {
			PortalHelper.closeResources(conn, pstmt, rs);
			conn = null;
		}
		return response;
	}
	
	public static void main(String args[]) {
		LoginDAC login = new LoginDAC();
		LoginRequest request = new LoginRequest();
		request.setPatientId("BN05000043");
		request.setDateOfBirth("16/04/1957");
		LoginResponse response = login.getLoginDetails(request);
		System.out.println("LoginResponse : " + response.getErrorInfo().getErrorCode());
		System.out.println("LoginResponse : " + response.getErrorInfo().getErrorMessage());
	}
}
