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
package portalrefimpl.facility.facilityforpatient.dac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.model.Facility;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.facility.FacilityConstants;
import portalrefimpl.facility.facilityforpatient.request.FacilityListRequest;
import portalrefimpl.facility.facilityforpatient.response.FacilityListResponse;

/**
 * This is the DAC class for getting facility list for a patient
 * This class will execute a SQL query and get the list of facilities
 * @author GRamamoorthy
 *
 */
public class FacilityListDAC {

	/**
	 * This method gets the facilities list given the facilityRequest object
	 * 
	 * @param facilityListRequest
	 * @return
	 */
	public FacilityListResponse getFacilityList(FacilityListRequest facilityListRequest){
		// initialize the response objects
		FacilityListResponse facilityListResponse = new FacilityListResponse();
		ErrorInfo errorInfo = null;
		//errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
		//facilityListResponse.setErrorInfo(errorInfo);
		
		// SQL query to be executed
		String query = getFacilityListQuery();
		
		Connection conn = PortalHelper.getConnection();
		// safe check
		if(conn == null){
			int errorCode = CommonConstants.DBCONNECTION_FAILURE_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			facilityListResponse.addError(errorInfo);
			return facilityListResponse;
		}
		
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = conn.prepareStatement(query);
			rs = prepStmt.executeQuery();
			if(rs == null){
				int errorCode = FacilityConstants.FACILITYLIST_NULLRESULTSET_ERRORCODE;
				String errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(CommonConstants.FACILITY_MODULE_NAME,
								errorCode);
				
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				
				facilityListResponse.addError(errorInfo);
				return facilityListResponse;
			}
			
			setDataInFacilityResponse(rs,facilityListResponse, facilityListRequest);
		} catch (SQLException e) {
			int errorCode = FacilityConstants.FACILITYLIST_SQLEXCEPTION_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.FACILITY_MODULE_NAME,
							errorCode);
			
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			facilityListResponse.addError(errorInfo);
		}finally{
			PortalHelper.closeResources(conn, prepStmt, rs);
		}
		
		return facilityListResponse;
	}
	
	/**
	 * this method returns the SQL query to be used for getting
	 * the facility list
	 * @return
	 */
	private String getFacilityListQuery(){
		StringBuffer queryBuffer = new StringBuffer();
		queryBuffer
				.append("select DISTINCT SM_FACILITY_PARAM.FACILITY_ID,SM_FACILITY_PARAM.FACILITY_NAME from SM_FACILITY_PARAM,SM_SITE_PARAM where SM_FACILITY_PARAM.SITE_ID=SM_SITE_PARAM.SITE_ID");
		
		return queryBuffer.toString();
	}
	
	/**
	 * This method populates the facilities in the facilityListResponse object
	 * @param rs
	 * @param facilityListResponse
	 * @param facilityListRequest TODO
	 */
	private void setDataInFacilityResponse(ResultSet rs,
			FacilityListResponse facilityListResponse,
			FacilityListRequest facilityListRequest) throws SQLException {
		List<Facility> facilityList = new ArrayList<Facility>();
		Facility facility = null;
		String facilityId = null;
		String facilityName = null;
		int recordCount = facilityListRequest.getRecordCount();
		int counter = 0;
		// iterate through the resultSet and get the data
		while (rs.next()) {
			if(recordCount > 0){
				if(counter < recordCount){
					counter++;
				}else{
					break;
				}
			}
			facilityId = rs.getString("FACILITY_ID");
			facilityName = rs.getString("FACILITY_NAME");

			facility = new Facility();
			facility.setFacilityId(facilityId);
			facility.setFacilityName(facilityName);

			facilityList.add(facility);
		}

		facilityListResponse.setFacilityList(facilityList);

		int errorCode = -1;
		String errorMessage = null;
		// check if there is no data in the result set
		if (facilityList.isEmpty()) {
			errorCode = FacilityConstants.FACILITYLIST_NODATA_FOUND_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.FACILITY_MODULE_NAME, errorCode);
		} else {
			errorCode = ErrorInfo.SUCCESS_CODE;
		}
		// initialize the error info and add it to the response
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(errorCode);
		errorInfo.setErrorMessage(errorMessage);
		facilityListResponse.addError(errorInfo);
	}
	
}
