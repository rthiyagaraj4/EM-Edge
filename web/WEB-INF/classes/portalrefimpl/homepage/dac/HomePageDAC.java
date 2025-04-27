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
package portalrefimpl.homepage.dac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.model.Address;
import portalrefimpl.common.model.ContactDetails;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.homepage.HomePageConstants;
import portalrefimpl.homepage.request.HospitalDetailsRequest;
import portalrefimpl.homepage.request.PatientDetailsRequest;
import portalrefimpl.homepage.response.HospitalDetailsResponse;
import portalrefimpl.homepage.response.PatientDetailsResponse;

/**
 * This is the DAC class for the home page
 * 
 * @author gramamoorthy
 * 
 */
public class HomePageDAC {

	/**
	 * This method gets the hospital details in hospitalDetailsResponse object
	 * for the given hospitalDetailsRequest object
	 * 
	 * @param hospitalDetailsRequest
	 * @return
	 */
	public HospitalDetailsResponse getHospitalDetails(
			HospitalDetailsRequest hospitalDetailsRequest) {
		HospitalDetailsResponse hospitalDetailsResponse = new HospitalDetailsResponse();
		ErrorInfo errorInfo = null;
		/* errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE); */
		/* hospitalDetailsResponse.setErrorInfo(errorInfo); */

		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		// get the SQL query
		String sqlQuery = getHospitalDetailsQuery();
		// initialize connection
		Connection conn = PortalHelper.getConnection();
		// define the error message and return it
		if (conn == null) {
			errorCode = CommonConstants.DBCONNECTION_FAILURE_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.COMMON_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			hospitalDetailsResponse.addError(errorInfo);
			return hospitalDetailsResponse;
		}

		// initialize prepared statement and result set
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = conn.prepareStatement(sqlQuery);
			// setDataInHospitalPrepStmt(prepStmt,hospitalDetailsRequest);
			rs = prepStmt.executeQuery();
			if (rs == null) {
				errorCode = HomePageConstants.HOSPITALDETAILS_NULLRESULTSET_ERRORCODE;
				errorMessage = MessageContainer
						.getInstance()
						.getDisplayMessage(
								CommonConstants.HOMEPAGE_MODULE_NAME, errorCode);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				hospitalDetailsResponse.addError(errorInfo);
				return hospitalDetailsResponse;
			}

			populateDataInHospitalResponse(rs, hospitalDetailsResponse);
		} catch (SQLException e) {
			errorCode = HomePageConstants.SQLEXCEPTION_HOSPITALDETAILS_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.HOMEPAGE_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			hospitalDetailsResponse.addError(errorInfo);
			return hospitalDetailsResponse;
		} finally {
			PortalHelper.closeResources(conn, prepStmt, rs);
		}

		// finally check if the response has any error objects
		// even if the operation is successful, an error object
		// with success code has to be set
		if (!hospitalDetailsResponse.hasErrors()) {
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			hospitalDetailsResponse.addError(errorInfo);
		}
		
		return hospitalDetailsResponse;
	}

	/**
	 * This method gets the patient details in PatientDetailsResponse object
	 * given the PatientDetailsRequest object
	 * 
	 * @param patientDetailsRequest
	 * @return
	 */
	public PatientDetailsResponse getPatientDetails(
			PatientDetailsRequest patientDetailsRequest) {
		PatientDetailsResponse patientDetailsResponse = new PatientDetailsResponse();
		ErrorInfo errorInfo = new ErrorInfo();
		// errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
		// patientDetailsResponse.setErrorInfo(errorInfo);

		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;

		// get the connection and check it for null
		Connection conn = PortalHelper.getConnection();
		if (conn == null) {
			errorCode = CommonConstants.DBCONNECTION_FAILURE_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.COMMON_MODULE_NAME, errorCode);
			errorInfo
					.setErrorCode(CommonConstants.DBCONNECTION_FAILURE_ERRORCODE);
			errorInfo.setErrorMessage(errorMessage);

			patientDetailsResponse.addError(errorInfo);
			return patientDetailsResponse;
		}
		// SQL query
		String query = getPatientDetailsQuery();
		// initialize prepared statement and result set
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		try {
			prepStmt = conn.prepareStatement(query);
			setDataInPatientPrepStmt(prepStmt, patientDetailsRequest);

			rs = prepStmt.executeQuery();
			// just a safe check
			if (rs == null) {
				errorCode = HomePageConstants.PATIENT_DETAILS_DATA_NOT_FOUND_ERRORCODE;
				errorMessage = MessageContainer
						.getInstance()
						.getDisplayMessage(
								CommonConstants.HOMEPAGE_MODULE_NAME, errorCode);
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);

				patientDetailsResponse.addError(errorInfo);
				return patientDetailsResponse;
			}

			// set the data in the patient response
			populateDataInPatientResponse(rs, patientDetailsResponse);
		} catch (SQLException e) {
			errorCode = HomePageConstants.PATIENT_DETAILS_DATA_NOT_FOUND_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.HOMEPAGE_MODULE_NAME, errorCode);

		} finally {
			PortalHelper.closeResources(conn, prepStmt, rs);
		}
		// finally check if the response has any error objects
		// even if the operation is successful, an error object
		// with success code has to be set
		if (!patientDetailsResponse.hasErrors()) {
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			patientDetailsResponse.addError(errorInfo);
		}

		return patientDetailsResponse;
	}

	/**
	 * 
	 * @return
	 */
	private String getHospitalDetailsQuery() {
		StringBuffer queryBuff = new StringBuffer();
		/*
		 * queryBuff.append(
		 * "select facility_id, FACILITY_NAME, ADDR_LINE1,ADDR_LINE1, ADDR_LINE2, ADDR_LINE3, ADDR_LINE4, ADDR_POSTAL_CODE, "
		 * ); queryBuff.append(
		 * " (select short_name from MP_COUNTRY where COUNTRY_CODE = a.COUNTRY_CODE) Country, "
		 * ); queryBuff.append(
		 * " (select SHORT_DESC from MP_RES_AREA WHERE RES_AREA_CODE = A.RES_AREA_CODE AND REGION_CODE = A.REGION_CODE ) RES_AREA_NAME, "
		 * ); queryBuff.append(
		 * " (select SHORT_DESC from MP_RES_TOWN where RES_TOWN_CODE = A.RES_TOWN_CODE AND RES_AREA_CODE = A.RES_AREA_CODE ) RES_TOWN_NAME, "
		 * ); queryBuff.append(
		 * " (select SHORT_DESC from MP_REGION where region_code = a.region_code) REGION_NAME, COUNTRY_CODE, RES_AREA_CODE, RES_TOWN_CODE, REGION_CODE, "
		 * ); queryBuff.append(
		 * " TEL_NO1, TEL_NO2, TEL_NO3, TEL_NO4, FAX_NO, EMAIL_ID, WEBSITE_ID "
		 * );
		 * queryBuff.append(" FROM SM_facility_param A where facility_id = ?");
		 */

		queryBuff.append("select * from SM_SITE_PARAM");

		return queryBuff.toString();
	}

	/**
	 * This method sets the data in the prepared statement object which is used
	 * for getting hospital details
	 * 
	 * @param prepStmt
	 * @param hospitalDetailsRequest
	 */
	/*
	 * private void setDataInHospitalPrepStmt(PreparedStatement prepStmt,
	 * HospitalDetailsRequest hospitalDetailsRequest) throws SQLException {
	 * if(prepStmt != null){ String facilityId =
	 * hospitalDetailsRequest.getFacilityId(); int index = 1;
	 * prepStmt.setString(index, facilityId); } }
	 */

	/**
	 * This method sets the data in the prepared statement object which is used
	 * for getting patient details
	 * 
	 * @param prepStmt
	 * @param patientDetailsRequest
	 * @throws SQLException
	 */
	private void setDataInPatientPrepStmt(PreparedStatement prepStmt,
			PatientDetailsRequest patientDetailsRequest) throws SQLException {
		if (prepStmt != null) {
			String patientId = patientDetailsRequest.getPatientId();
			int index = 1;
			prepStmt.setString(index, patientId);
		}
	}

	/**
	 * This method reads data from the result set and populates the
	 * hospitalDetailsResponse object
	 * 
	 * @param rs
	 * @param hospitalDetailsResponse
	 * @throws SQLException
	 */
	private void populateDataInHospitalResponse(ResultSet rs,
			HospitalDetailsResponse hospitalDetailsResponse)
			throws SQLException {
		if (rs.next()) {
			/*
			 * String facilityId = rs.getString("facility_id");
			 * hospitalDetailsResponse.setFacilityId(facilityId); String
			 * facilityName = rs.getString("FACILITY_NAME");
			 * hospitalDetailsResponse.setFacilityName(facilityName);
			 */

			String siteId = rs.getString("SITE_ID");
			hospitalDetailsResponse.setSiteId(siteId);

			String siteName = rs.getString("SITE_NAME");
			hospitalDetailsResponse.setSiteName(siteName);

			Address address = getHospitalAddress(rs);
			hospitalDetailsResponse.setAddress(address);

			/*
			 * ContactDetails contactDetails = getContactDetails(rs);
			 * hospitalDetailsResponse.setContactDetails(contactDetails);
			 */

		} else {
			ErrorInfo errorInfo = new ErrorInfo();
			int errorCode = HomePageConstants.HOSPITALDETAILS_DATANOTFOUND_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.HOMEPAGE_MODULE_NAME,
							errorCode);
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			hospitalDetailsResponse.addError(errorInfo);
		}
	}

	/**
	 * This method returns the SQL query for the patient details
	 * 
	 * @return
	 */
	private String getPatientDetailsQuery() {
		StringBuffer queryBuff = new StringBuffer();
		queryBuff
				.append("select PATIENT_ID,NATIONAL_ID_NO,NAME_PREFIX,NAME_SUFFIX,PATIENT_NAME,SEX,DATE_OF_BIRTH from mp_patient where patient_id = ?");
		return queryBuff.toString();
	}

	/**
	 * This method reads data from the resultset object and sets data in the
	 * patient details response
	 * 
	 * @param rs
	 * @param patientDetailsResponse
	 */
	private void populateDataInPatientResponse(ResultSet rs,
			PatientDetailsResponse patientDetailsResponse) throws SQLException {

		// NATIONAL_ID_NO,NAME_PREFIX,NAME_SUFFIX,PATIENT_NAME,SEX,DATE_OF_BIRTH
		if (rs.next()) {
			String patientId = rs.getString("PATIENT_ID");
			String nationnalIdNumber = rs.getString("NATIONAL_ID_NO");
			String namePrefix = rs.getString("NAME_PREFIX");
			String nameSuffix = rs.getString("NAME_SUFFIX");
			String patientName = rs.getString("PATIENT_NAME");
			String sex = rs.getString("SEX");
			Date dob = rs.getDate("DATE_OF_BIRTH");

			patientDetailsResponse.setPatientId(patientId);
			patientDetailsResponse.setNationalId(nationnalIdNumber);

			/*
			 * patientDetailsResponse.setNamePrefix(namePrefix);
			 * patientDetailsResponse.setNameSuffix(nameSuffix);
			 */
			patientDetailsResponse.setPatientName(patientName);
			// code for forming display name
			String displayName = namePrefix != null ? namePrefix.trim() : "";
			displayName += patientName;
			displayName += nameSuffix != null ? nameSuffix.trim() : "";
			patientDetailsResponse.setPatientDisplayName(displayName);

			patientDetailsResponse.setSex(sex);
			patientDetailsResponse.setDateOfBirth(dob);
		} else {
			/* ErrorInfo errorInfo = patientDetailsResponse.getErrorInfo(); */
			ErrorInfo errorInfo = new ErrorInfo();
			int errorCode = HomePageConstants.PATIENT_DETAILS_DATA_NOT_FOUND_ERRORCODE;
			errorInfo.setErrorCode(errorCode);
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.HOMEPAGE_MODULE_NAME,
							errorCode);
			errorInfo.setErrorMessage(errorMessage);
			patientDetailsResponse.addError(errorInfo);
		}

	}

	/**
	 * This method reads all the address related information from the given
	 * resultset, populates this data into the address object and returns the
	 * address object
	 * 
	 * @param rs
	 * @return
	 */
	private Address getHospitalAddress(ResultSet rs) throws SQLException {
		// initialize the address object
		Address address = new Address();
		// first read the address lines
		String addressLine1 = rs.getString("ADDR_LINE1_PROMPT");
		String addressLine2 = rs.getString("ADDR_LINE2_PROMPT");
		String addressLine3 = rs.getString("ADDR_LINE3_PROMPT");
		String addressLine4 = rs.getString("ADDR_LINE4_PROMPT");
		// this list will store the address lines
		List<String> addressLineList = new ArrayList<String>();
		addressLineList.add(addressLine1);
		addressLineList.add(addressLine2);
		addressLineList.add(addressLine3);
		addressLineList.add(addressLine4);
		// now set the list of address lines to the address object
		address.setAddressLineList(addressLineList);
		// now read the other parts of the address
		String pinCode = rs.getString("POSTAL_CODE_PROMPT");
		address.setPincode(pinCode);
		// country is not present in SM_SITE_PARAM table
		/*
		 * String country = rs.getString("Country");
		 * address.setCountry(country);
		 */
		/*
		 * String areaName = rs.getString("RES_AREA_PROMPT");
		 * address.setResAreaName(areaName); String townName =
		 * rs.getString("RES_TOWN_PROMPT"); address.set String regionName =
		 * rs.getString("REGION_PROMPT"); address.setRegionName(regionName);
		 */

		// COUNTRY_CODE, RES_AREA_CODE, RES_TOWN_CODE, REGION_CODE,
		// these properties are not present in SM_SITE_PARAM table
		/*
		 * String countryCode = rs.getString("COUNTRY_CODE");
		 * address.setCountryCode(countryCode); String areaCode =
		 * rs.getString("RES_AREA_CODE"); address.setAreaCode(areaCode); String
		 * townCode = rs.getString("RES_TOWN_CODE");
		 * address.setTownCode(townCode); String regionCode =
		 * rs.getString("REGION_CODE"); address.setRegionCode(regionCode);
		 */

		return address;
	}

	/**
	 * This method reads the contact details from the result set and returns the
	 * contactdetails object
	 * 
	 * @param rs
	 * @return
	 */
	private ContactDetails getContactDetails(ResultSet rs) throws SQLException {
		// initialize the contact details object
		ContactDetails contactDetails = new ContactDetails();

		// the data to be read from the resultset are
		// TEL_NO1, TEL_NO2, TEL_NO3, TEL_NO4, FAX_NO, EMAIL_ID, WEBSITE_ID

		// first read the telephone numbers and add it to a list
		String telephoneNumber1 = rs.getString("TEL_NO1");
		String telephoneNumber2 = rs.getString("TEL_NO2");
		String telephoneNumber3 = rs.getString("TEL_NO3");
		String telephoneNumber4 = rs.getString("TEL_NO4");

		List<String> telephoneNumberList = new ArrayList<String>();
		telephoneNumberList.add(telephoneNumber1);
		telephoneNumberList.add(telephoneNumber2);
		telephoneNumberList.add(telephoneNumber3);
		telephoneNumberList.add(telephoneNumber4);

		contactDetails.setTelephoneNumbers(telephoneNumberList);

		// now read other details
		String faxNumber = rs.getString("FAX_NO");
		String emailId = rs.getString("EMAIL_ID");
		String websiteId = rs.getString("WEBSITE_ID");
		contactDetails.setFaxNumber(faxNumber);
		contactDetails.setEmailId(emailId);
		contactDetails.setWebsiteId(websiteId);

		return contactDetails;
	}

}
