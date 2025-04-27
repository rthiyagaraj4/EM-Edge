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

import portal.common.model.Address;
import portal.common.request.BaseRequest;
import portal.common.response.ErrorInfo;
import portal.homepage.model.HospitalInfo;
import portal.homepage.response.HospitalInfoResponse;
import portal.tools.ErrorMessageUtil;
import portal.tools.HospitalKeyConstants;
import portal.tools.PortalHelper;

/**
 * This class is responsible for the retrieval of the Hospital details from EM
 * data base
 * 
 * @author skrishnared2
 * 
 */
public class HospitalInfoDAC {
	
	private static Logger logger = Logger.getLogger(HospitalInfoDAC.class.getName());
	HospitalInfoResponse response;
	ErrorInfo errorInfo;

	/**
	 * @param errorInfo
	 *            the errorInfo to set
	 */
	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(HospitalInfoResponse response) {
		this.response = response;
	}

	/**
	 * This method calls the private method which fetches the data from EM
	 * database
	 * 
	 * @param request
	 * @return
	 */
	public HospitalInfoResponse getHospitalInformation(BaseRequest request) {
		logger.info("Entering the method :getHospitalInformation ");
		HospitalInfoResponse response = selectHospitalInformation(request);
		logger.info("Leaving the method :getHospitalInformation ");
		return response;
	}

	/**
	 * This method retrieves the hospital information from EM Database
	 * 
	 * @param request
	 * @return
	 */
	private HospitalInfoResponse selectHospitalInformation(
			BaseRequest request) {
		logger.info("Entering the method :selectHospitalInformation ");
		String sqlQuery = "select SITE_ID Facility_Id, " +
				"SITE_NAME as FACILITY_NAME, " +
				"ADDR_LINE1_PROMPT as ADDR_LINE1, " +
				"ADDR_LINE2_PROMPT as ADDR_LINE2, " +
				"ADDR_LINE3_PROMPT as ADDR_LINE3, " +
				"RES_AREA_PROMPT as RES_AREA_NAME, " +
				"RES_TOWN_PROMPT as RES_TOWN_NAME, " +
				"REGION_PROMPT as REGION_NAME, " +
				"POSTAL_CODE_PROMPT as ADDR_POSTAL_CODE " +
				"from SM_SITE_PARAM";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = PortalHelper.getConnection();
			if (conn == null) {
				errorInfo = ErrorMessageUtil.getErrorMessage(
						HospitalKeyConstants.MODULE_NAME,
						ErrorInfo.HOSPITAL_NO_DB_DATA_RETURNED_CODE);
				response.setErrorInfo(errorInfo);
				logger.info("Connection is null in the method :selectHospitalInformation");
				return response;
			}

			pstmt = conn.prepareStatement(sqlQuery);
			rs = pstmt.executeQuery();
			HospitalInfo hospital = new HospitalInfo();
			if (rs != null) {
				if (rs.next()) {
					hospital.setHospitalId(rs.getString("facility_id"));
					hospital.setHospitalName(rs.getString("FACILITY_NAME"));

					Address address = new Address();

					address.setAddressLine1(rs.getString("ADDR_LINE1"));
					address.setAddressLine2(rs.getString("ADDR_LINE2"));
					address.setAddressLine3(rs.getString("ADDR_LINE3"));
					address.setPincode(rs.getString("ADDR_POSTAL_CODE"));
					address.setResAreaName(rs.getString("RES_AREA_NAME"));
					address.setResTownName(rs.getString("RES_TOWN_NAME"));
					address.setRegionName(rs.getString("REGION_NAME"));
					hospital.setAddress(address);

					response = updateResponse(response, hospital);
					errorInfo = ErrorMessageUtil.getErrorMessage(
							HospitalKeyConstants.MODULE_NAME,
							ErrorInfo.SUCCESS_CODE);
					response.setErrorInfo(errorInfo);
				} else {
					errorInfo = ErrorMessageUtil.getErrorMessage(
							HospitalKeyConstants.MODULE_NAME,
							ErrorInfo.HOSPITAL_NO_DB_DATA_RETURNED_CODE);
					logger.info("No data in the method :selectHospitalInformation");
					response.setErrorInfo(errorInfo);
					return response;
				}

			} else {
				errorInfo = ErrorMessageUtil.getErrorMessage(
						HospitalKeyConstants.MODULE_NAME,
						ErrorInfo.HOSPITAL_NO_DB_DATA_RETURNED_CODE);
				logger.info("No data in the method :selectHospitalInformation");
				response.setErrorInfo(errorInfo);
				return response;
			}
			return response;
		} catch (Exception e) {
			ErrorMessageUtil.getErrorMessage(HospitalKeyConstants.MODULE_NAME,
					ErrorInfo.HOSPITAL_SQLEXCEPTION_CODE, e.getMessage());
			logger.error("Exception in the method :selectHospitalInformation : msg:"
					+ e.getStackTrace().toString());
			// logger.log(Priority.toPriority(Priority.ERROR_INT),
			// e.getMessage(), e);
			logger.fatal(
					"Exception in the method :selectHospitalInformation : stack trace: ", e);
			response.setErrorInfo(errorInfo);
			return response;
		} finally {
			PortalHelper.closeResources(conn, pstmt, rs);
			conn = null;
		}
	}

	/**
	 * This method sets response with BOM information
	 * 
	 * @param response
	 * @param hospital
	 * @return
	 */
	private HospitalInfoResponse updateResponse(
			HospitalInfoResponse response, HospitalInfo hospital) {
		response.setHospitalName(hospital.getHospitalName());
		response.setAddressDetails(hospital.getAddress());
		return response;
	}
}
