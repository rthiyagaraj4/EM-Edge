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
import portal.common.model.ContactDetails;
import portal.common.response.ErrorInfo;
import portal.homepage.model.Hospital;
import portal.homepage.request.HospitalRequest;
import portal.homepage.response.HospitalDetailsResponse;
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
public class HospitalDetailsDAC {
	
	private static Logger logger = Logger.getLogger(HospitalDetailsDAC.class.getName());
	HospitalDetailsResponse response;
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
	public void setResponse(HospitalDetailsResponse response) {
		this.response = response;
	}

	/**
	 * This method calls the private method which fetches the data from EM
	 * database
	 * 
	 * @param request
	 * @return
	 */
	public HospitalDetailsResponse getHospitalDetails(HospitalRequest request) {
		logger.info("Entering the method :getHospitalDetails ");
		HospitalDetailsResponse response = selectHospitalDetails(request);
		logger.info("Leaving the method :getHospitalDetails ");
		return response;
	}

	/**
	 * This method retrieves the hospital information from EM Database
	 * 
	 * @param request
	 * @return
	 */
	private HospitalDetailsResponse selectHospitalDetails(
			HospitalRequest request) {
		
		logger.info("Entering the method :selectHospitalDetails ");
		// HospitalDetailsResponse response = new HospitalDetailsResponse();
		// ErrorInfo errorInfo = new ErrorInfo();
		String sqlQuery = "select facility_id, FACILITY_NAME, ADDR_LINE1,ADDR_LINE1, ADDR_LINE2, ADDR_LINE3, ADDR_LINE4, ADDR_POSTAL_CODE, "
				+ " (select short_name from MP_COUNTRY where COUNTRY_CODE = a.COUNTRY_CODE) Country, "
				+ " (select SHORT_DESC from MP_RES_AREA WHERE RES_AREA_CODE = A.RES_AREA_CODE AND REGION_CODE = A.REGION_CODE ) RES_AREA_NAME, "
				+ " (select SHORT_DESC from MP_RES_TOWN where RES_TOWN_CODE = A.RES_TOWN_CODE AND RES_AREA_CODE = A.RES_AREA_CODE ) RES_TOWN_NAME, "
				+ " (select SHORT_DESC from MP_REGION where region_code = a.region_code) REGION_NAME, COUNTRY_CODE, RES_AREA_CODE, RES_TOWN_CODE, REGION_CODE, "
				+ " TEL_NO1, TEL_NO2, TEL_NO3, TEL_NO4, FAX_NO, EMAIL_ID, WEBSITE_ID "
				+ " FROM SM_facility_param A where facility_id = ?";

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
				logger.info("Connection is null in the method :selectHospitalDetails");
				return response;
			}

			pstmt = conn.prepareStatement(sqlQuery);
			pstmt.setString(1, request.getFacilityId());
			// pstmt.setString(1, "RP");
			rs = pstmt.executeQuery();
			Hospital hospital = new Hospital();
			if (rs != null) {
				if (rs.next()) {
					hospital.setHospitalId(rs.getString("facility_id"));
					hospital.setHospitalName(rs.getString("FACILITY_NAME"));

					Address address = new Address();

					address.setAddressLine1(rs.getString("ADDR_LINE1"));
					address.setAddressLine2(rs.getString("ADDR_LINE2"));
					address.setAddressLine3(rs.getString("ADDR_LINE3"));
					address.setPincode(rs.getString("ADDR_POSTAL_CODE"));
					address.setCountry(rs.getString("COUNTRY"));
					address.setResAreaName(rs.getString("RES_AREA_NAME"));
					address.setResTownName(rs.getString("RES_TOWN_NAME"));
					address.setRegionName(rs.getString("REGION_NAME"));
					address.setCountryCode(rs.getString("COUNTRY_CODE"));
					hospital.setAddress(address);

					ContactDetails contact = new ContactDetails();
					contact.setPrimaryTelephoneNo(rs.getString("TEL_NO1"));
					contact.setSecondaryTelephoneNo(rs.getString("TEL_NO2"));
					contact.setFaxNumber(rs.getString("FAX_NO"));
					contact.setEmailId(rs.getString("EMAIL_ID"));
					contact.setWebsiteId(rs.getString("WEBSITE_ID"));
					hospital.setContactDetails(contact);

					response = updateResponse(response, hospital);
					errorInfo = ErrorMessageUtil.getErrorMessage(
							HospitalKeyConstants.MODULE_NAME,
							ErrorInfo.SUCCESS_CODE);
					response.setErrorInfo(errorInfo);
				} else {
					errorInfo = ErrorMessageUtil.getErrorMessage(
							HospitalKeyConstants.MODULE_NAME,
							ErrorInfo.HOSPITAL_NO_DB_DATA_RETURNED_CODE);
					logger.info("No data in the method :selectHospitalDetails");
					response.setErrorInfo(errorInfo);
					return response;
				}

			} else {
				errorInfo = ErrorMessageUtil.getErrorMessage(
						HospitalKeyConstants.MODULE_NAME,
						ErrorInfo.HOSPITAL_NO_DB_DATA_RETURNED_CODE);
				logger.info("No data in the method :getTestReport");
				response.setErrorInfo(errorInfo);
				return response;
			}
			return response;
		} catch (Exception e) {
			ErrorMessageUtil.getErrorMessage(HospitalKeyConstants.MODULE_NAME,
					ErrorInfo.HOSPITAL_SQLEXCEPTION_CODE, e.getMessage());
			response.setErrorInfo(errorInfo);
			logger.error("Exception in the method :selectHospitalDetails : msg:"
					+ e.getStackTrace().toString());
			// logger.log(Priority.toPriority(Priority.ERROR_INT),
			// e.getMessage(), e);
			logger.fatal(
					"Exception in the method :selectHospitalDetails : stack trace: ", e);
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
	private HospitalDetailsResponse updateResponse(
			HospitalDetailsResponse response, Hospital hospital) {
		response.setHospitalName(hospital.getHospitalName());
		Address address = hospital.getAddress();
		response.setAddressDetails(address.getAddressLine1() + " , "
				+ address.getAddressLine2() + " , " + address.getAddressLine3());
		response.setCountry(address.getCountry());
		response.setRegionName(address.getRegionName());
		response.setResidentAreaName(address.getResAreaName());
		response.setResidentTownName(address.getResTownName());
		response.setPincode(address.getCountryCode() + " "
				+ address.getPincode());

		ContactDetails contact = hospital.getContactDetails();
		response.seteMailId(contact.getEmailId());
		response.setPrimaryTelephoneNo(contact.getPrimaryTelephoneNo());
		response.setFaxNumber(contact.getFaxNumber());
		response.setWebsiteDetails(contact.getWebsiteId());
		return response;
	}
}
