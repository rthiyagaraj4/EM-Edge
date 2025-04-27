/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.facility.dac;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import portal.common.response.ErrorInfo;
import portal.facility.request.FacilityRequest;
import portal.facility.response.Facility;
import portal.facility.response.FacilityResponse;
import portal.tools.ErrorMessageUtil;
import portal.tools.FacilityConstants;
import portal.tools.PortalHelper;

/**
 * This class is used for retrieving All facilities from EM DB.
 * 
 * @author vkodancha
 * 
 */
public class FacilityDAC {

	private static Logger logger = Logger
			.getLogger(FacilityDAC.class.getName());

	// static query
	private static final String query = "select DISTINCT SM_FACILITY_PARAM.FACILITY_ID FACILITY_ID , SM_FACILITY_PARAM.FACILITY_NAME FACILITY_NAME"
			+ " from SM_FACILITY_PARAM,SM_SITE_PARAM where SM_FACILITY_PARAM.SITE_ID=SM_SITE_PARAM.SITE_ID";

	// instance variables
	private ErrorInfo errorInfo;
	private FacilityResponse response;

	/**
	 * This method fetches the facilities from EM DB for patient portal
	 * application home page
	 * 
	 * @param request
	 * @return
	 */
	public FacilityResponse getFacilities(FacilityRequest request) {
		logger.info("Entering the method :getFacilities");
		List<Facility> facilityList = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		conn = PortalHelper.getConnection();
		if (conn == null) {
			errorInfo = ErrorMessageUtil.getErrorMessage(
					FacilityConstants.MODULE_NAME,
					ErrorInfo.FACILITY_CONNECTION_FAILURE_CODE);
			logger.info("Connection is null in the method :getFacilities");
		} else {
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				if (rs != null) {
					facilityList = getFacilityList(rs);
				}
				if (facilityList == null || facilityList.isEmpty()) {
					errorInfo = ErrorMessageUtil.getErrorMessage(
							FacilityConstants.MODULE_NAME,
							ErrorInfo.FACILITY_NO_DB_DATA_RETURNED_CODE);
				} else {
					errorInfo = ErrorMessageUtil.getErrorMessage(
							FacilityConstants.MODULE_NAME,
							ErrorInfo.SUCCESS_CODE);
				}
			} catch (SQLException e) {
				errorInfo = ErrorMessageUtil.getErrorMessage(
						FacilityConstants.MODULE_NAME,
						ErrorInfo.FACILITY_SQLEXCEPTION_CODE, e.getMessage());
				logger.error("Exception in the method :getFacilities : msg:"
						+ e.getStackTrace().toString());
				// logger.log(Priority.toPriority(Priority.ERROR_INT),
				// e.getMessage(), e);
				logger.fatal(
						"Exception in the method :getFacilities : stack trace: ",
						e);
			} finally {
				PortalHelper.closeResources(conn, stmt, rs);
				conn = null;
			}
		}
		response.setErrorInfo(errorInfo);
		response.setFacilityList(facilityList);
		logger.info("Leaving the method :getFacilities");
		return response;
	}

	/**
	 * This method gets the list of facilities from result
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private List<Facility> getFacilityList(ResultSet rs) throws SQLException {
		List<Facility> facilityList = new ArrayList<Facility>();
		while (rs.next()) {
			facilityList.add(new Facility(rs.getString("FACILITY_ID"), rs
					.getString("FACILITY_NAME")));
		}
		return facilityList;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(FacilityResponse response) {
		this.response = response;
	}

}
