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
package portalrefimpl.homepage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Date;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.response.ErrorInfo;

/**
 * @author GRamamoorthy
 *
 */
public class HomePageInfoHandler {

	/**
	 * 
	 * @param homePageInfoRequest
	 * @return
	 */
	public HomePageInfoResponse getHomePageInfo(HomePageInfoRequest homePageInfoRequest){
		HomePageInfoResponse response = new HomePageInfoResponse();
		ErrorInfo errorInfo = new ErrorInfo();
		response.setErrorInfo(errorInfo);
		// safe check
		if(homePageInfoRequest == null){
			errorInfo.setErrorCode(ErrorInfo.INVALID_REQUEST_ERROR_CODE);
			errorInfo.setErrorMessage(ErrorInfo.INVALID_REQUEST_ERROR_MESSAGE);
			return response;
		}
		String patientId = homePageInfoRequest.getPatientId();
		String query = "select NATIONAL_ID_NO,NAME_PREFIX,NAME_SUFFIX,PATIENT_NAME,SEX,DATE_OF_BIRTH from mp_patient where patient_id = '"+patientId+"'";
		Connection conn = PortalHelper.getConnection();
		// check for null connection - safe check
		if(conn == null){
			errorInfo.setErrorCode(ErrorInfo.CONNECTION_FAILURE_CODE);
			errorInfo.setErrorMessage(ErrorInfo.CONNECTION_FAILURE_MESSAGE);
			return response;
		}
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			// safe check for null result set
			if(rs == null){
				errorInfo.setErrorCode(ErrorInfo.NODATA_ERROR_CODE);
				errorInfo.setErrorMessage(ErrorInfo.NODATA_ERROR_MESSAGE);
			}else{
				String nricId = null;
				String patientNamePrefix = null;
				String patientNameSuffix = null;
				String patientName = null;
				String sex = null;
				Date dob = null;
				// iterate through the result set and get the data
				while(rs.next()){
					nricId = rs.getString("NATIONAL_ID_NO");
					patientNamePrefix = rs.getString("NAME_PREFIX");
					patientNameSuffix = rs.getString("NAME_SUFFIX");
					patientName = rs.getString("PATIENT_NAME");
					sex = rs.getString("SEX");
					dob = rs.getDate("DATE_OF_BIRTH");
					
					response.setNricId(nricId);
					response.setPatientNamePrefix(patientNamePrefix);
					response.setPatientNameSuffix(patientNameSuffix);
					response.setPatientName(patientName);
					response.setSex(sex);
					response.setDateOfBirth(dob);
				}
			}
		} catch (SQLException e) {
			errorInfo.setErrorCode(ErrorInfo.SQLEXCEPTION_CODE);
			String errorMessage = ErrorInfo.EXCEPTION_MESSAGE;
			errorMessage = MessageFormat.format(errorMessage, new Object[]{e.getMessage()});
			errorInfo.setErrorMessage(errorMessage);
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
			
			conn = null;
		}
		
		return response;
	}
	
}
