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
package portalrefimpl.login.dac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.login.request.LoginRequest;
import portalrefimpl.login.response.LoginResponse;
import portalrefimpl.login.svc.LoginConstant;

/**
 * This is the DAC layer class for login functionality
 * @author GRamamoorthy
 *
 */
public class LoginDAC {

	/**
	 * This method validates the user trying to login against the eHIS db
	 * @param loginRequest
	 * @return
	 */
	public LoginResponse validateLoginUser(LoginRequest loginRequest){
		LoginResponse loginResponse = new LoginResponse();
		// initialize the error object and set it in the response
		/*ErrorInfo errorInfo = new ErrorInfo();*/
		ErrorInfo errorInfo = null;
		/*loginResponse.setErrorInfo(errorInfo);*/
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		/*errorInfo.setErrorCode(errorCode);
		errorInfo.setErrorMessage(errorMessage);*/
		
		String patientId = loginRequest.getPatientId();
		String dateOfBirth = loginRequest.getDateOfBirth();
		// SQL query to
		String query = "select count(*) \"COUNT\" from mp_patient where upper(patient_id)=upper(?) and DATE_OF_BIRTH=TO_DATE (NVL ((?),'01/01/1000'),'dd/mm/yyyy') ";
		// the query is modified to convert the date to string value without the time value 
		query = "select count(*) \"COUNT\" from mp_patient where upper(patient_id)=upper(?) and TO_CHAR(DATE_OF_BIRTH,'dd/mm/yyyy')=NVL (?,'01/01/1000')";
		// get the connection
		Connection conn = PortalHelper.getConnection();
		// safe check
		if(conn == null){
			errorCode = CommonConstants.DBCONNECTION_FAILURE_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.COMMON_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			return loginResponse;
		}
		
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			// execute the query through a prepared statement
			prepStmt = conn.prepareStatement(query);
			prepStmt.setString(1, patientId);
			prepStmt.setString(2, dateOfBirth);
			
			rs = prepStmt.executeQuery();
			if(rs != null){
				int count = 0;
				while(rs.next()){
					count = rs.getInt("COUNT");	
				}
				// we should expect one row of data if there is a match in db
				if(count == 1){
					errorCode = ErrorInfo.SUCCESS_CODE;
				}else if(count <= 0){
					errorCode = LoginConstant.INVALID_LOGIN_ERRORCODE;
					errorMessage = MessageContainer.getInstance()
							.getDisplayMessage(CommonConstants.LOGIN_MODULE_NAME,
									errorCode);
				}
			}else{
				errorCode = LoginConstant.NULLRESULTSET_ERRORCODE;
				errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(CommonConstants.LOGIN_MODULE_NAME,
								errorCode);
			}
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			loginResponse.addError(errorInfo);
		} catch (SQLException e) {
			// set the error code and message in error info object
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(ErrorInfo.SQLEXCEPTION_CODE);
			errorMessage = ErrorInfo.EXCEPTION_MESSAGE;
			errorMessage = MessageFormat.format(errorMessage,
					new Object[] { e.getMessage() });
			errorInfo.setErrorMessage(errorMessage);
			loginResponse.addError(errorInfo);
		}finally{
			PortalHelper.closeResources(conn, prepStmt, rs);
			/*if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if(prepStmt != null){
				try {
					prepStmt.close();
				} catch (SQLException e) {
				}
			}
			conn = null;*/
		}
		
		
		return loginResponse;
	}
	
}
