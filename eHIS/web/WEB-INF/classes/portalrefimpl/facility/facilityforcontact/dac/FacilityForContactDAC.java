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
package portalrefimpl.facility.facilityforcontact.dac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.model.Address;
import portalrefimpl.common.model.ContactDetails;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.facility.FacilityConstants;
import portalrefimpl.facility.facilityforcontact.request.FacilityForContactRequest;
import portalrefimpl.facility.facilityforcontact.response.FacilityDetails;
import portalrefimpl.facility.facilityforcontact.response.FacilityForContactResponse;

/**
 * This is the DAC layer class for facility for contact service
 * 
 * @author GRamamoorthy
 * 
 */
public class FacilityForContactDAC {

	/**
	 * This method gets the facilities with their details for the service
	 * 
	 * @param request
	 * @return
	 */
	public FacilityForContactResponse getFacilitiesForContact(
			FacilityForContactRequest request) {
		// initialize the response objects
		FacilityForContactResponse response = new FacilityForContactResponse();
		/*ErrorInfo errorInfo = new ErrorInfo();*/
		ErrorInfo errorInfo = null;
		/*response.setErrorInfo(errorInfo);*/

		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		// get the connection
		Connection conn = PortalHelper.getConnection();
		if (conn == null) {
			errorCode = CommonConstants.DBCONNECTION_FAILURE_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.COMMON_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			return response;
		}
		/**
		 * TODO the site address and the site contact details is not populated
		 * in the response object as there is no data in EM this can be done
		 * only after confirmation from PMG
		 */
		String sqlQuery = getQuery(request);
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = conn.prepareStatement(sqlQuery);
			rs = prepStmt.executeQuery();
			// safe check
			if (rs == null) {
				errorCode = FacilityConstants.FACILITY_FORCONTACT_NULL_RESULTSET_ERRORCODE;
				errorMessage = MessageContainer
						.getInstance()
						.getDisplayMessage(
								CommonConstants.FACILITY_FORCONTACT_MODULE_NAME,
								errorCode);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				response.addError(errorInfo);
				return response;
			}

			populateDataInResponse(rs, response);
			List<FacilityDetails> facilityDetailsList = response.getFacilitiesList();
			// no data check 
			if (facilityDetailsList.isEmpty()) {
				errorCode = FacilityConstants.FACILITY_FORCONTACT_NODATA_FOUND_ERRORCODE;
				errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(
								CommonConstants.FACILITY_FORCONTACT_MODULE_NAME,
								errorCode);
			}
		} catch (SQLException e) {
			errorCode = FacilityConstants.FACILITY_FORCONTACT_SQLEXCEPTION_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.FACILITY_FORCONTACT_MODULE_NAME, errorCode);
		} finally {
			PortalHelper.closeResources(conn, prepStmt, rs);
		}
		// set the error code and the error message to the error info
		errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(errorCode);
		errorInfo.setErrorMessage(errorMessage);
		response.addError(errorInfo);

		return response;
	}

	/**
	 * This method gets the SQL Query for getting the facilities
	 * 
	 * @param request
	 * @return
	 */
	private String getQuery(FacilityForContactRequest request) {
		StringBuffer queryBuffer = new StringBuffer();
		queryBuffer
				.append("select facility_Id,facility_name, addr_line1, addr_line2, addr_line3, addr_line4,");
		queryBuffer
				.append("addr_postal_code,country_code,res_area_code,res_town_code,region_code,");
		queryBuffer
				.append("tel_no1, tel_no2,tel_no3,tel_no4,fax_no,email_id,website_id ");
		queryBuffer.append("from sm_facility_param ");
		queryBuffer
				.append("where site_id = (select site_id from sm_site_param) ");

		List<String> facilityIds = request.getFacilityIds();
		if (facilityIds != null && facilityIds.size() > 0) {
			queryBuffer.append(" and facility_id in (");
			int facilityIdsLen = facilityIds.size();
			for (int count = 0; count < facilityIdsLen; count++) {
				queryBuffer.append("'" + facilityIds.get(count) + "'");
				if (count != (facilityIdsLen - 1)) {
					queryBuffer.append(",");
				}
			}
		}

		int facilityCount = request.getFacilityCount();
		if (facilityCount > 0) {
			queryBuffer.append(" and rownum <= " + facilityCount);
		}

		return queryBuffer.toString();
	}

	/**
	 * This method reads data from the result set and populates the response
	 * object
	 * 
	 * @param rs
	 * @param response
	 * @throws SQLException
	 */
	private void populateDataInResponse(ResultSet rs,
			FacilityForContactResponse response) throws SQLException {

		// local vars
		String facilityId = null;
		String facilityName = null;

		String addressLine1 = null;
		String addressLine2 = null;
		String addressLine3 = null;
		String addressLine4 = null;
		List<String> addressLineList = null;
		String areaCode = null;
		String townCode = null;
		String regionCode = null;
		String countryCode = null;
		String postalCode = null;

		String telephone1 = null;
		String telephone2 = null;
		String telephone3 = null;
		String telephone4 = null;
		String faxNo = null;
		String emailId = null;
		String websiteId = null;
		List<String> telephoneList = null;

		Address address = null;
		ContactDetails contactDetails = null;

		FacilityDetails facilityDetails = null;
		List<FacilityDetails> facilityDetailsList = new ArrayList<FacilityDetails>();
		// iterate through the result set and read its data
		while (rs.next()) {
			facilityId = rs.getString("facility_id");
			facilityName = rs.getString("facility_name");
			// initialize the facility details and set id and name
			facilityDetails = new FacilityDetails();
			facilityDetails.setFacilityId(facilityId);
			facilityDetails.setFacilityName(facilityName);

			// address details
			addressLine1 = rs.getString("addr_line1");
			addressLine2 = rs.getString("addr_line2");
			addressLine3 = rs.getString("addr_line3");
			addressLine4 = rs.getString("addr_line4");
			addressLineList = new ArrayList<String>();
			addressLineList.add(addressLine1);
			addressLineList.add(addressLine2);
			addressLineList.add(addressLine3);
			addressLineList.add(addressLine4);

			countryCode = rs.getString("country_code");
			postalCode = rs.getString("addr_postal_code");
			areaCode = rs.getString("res_area_code");
			townCode = rs.getString("res_town_code");
			regionCode = rs.getString("region_code");

			address = new Address();
			address.setAddressLineList(addressLineList);
			address.setArea(areaCode);
			address.setCountry(countryCode);
			address.setPincode(postalCode);
			address.setRegion(regionCode);
			address.setTown(townCode);

			facilityDetails.setFacilityAddress(address);
			// contact details
			telephone1 = rs.getString("tel_no1");
			telephone2 = rs.getString("tel_no2");
			telephone3 = rs.getString("tel_no3");
			telephone4 = rs.getString("tel_no4");
			telephoneList = new ArrayList<String>();
			telephoneList.add(telephone1);
			telephoneList.add(telephone2);
			telephoneList.add(telephone3);
			telephoneList.add(telephone4);
			faxNo = rs.getString("fax_no");
			emailId = rs.getString("email_id");
			websiteId = rs.getString("website_id");

			contactDetails = new ContactDetails();
			contactDetails.setTelephoneNumbers(telephoneList);
			contactDetails.setFaxNumber(faxNo);
			contactDetails.setEmailId(emailId);
			contactDetails.setWebsiteId(websiteId);
			facilityDetails.setFacilityContactDetails(contactDetails);

			facilityDetailsList.add(facilityDetails);
		}
		// set the facility details list to the response
		response.setFacilitiesList(facilityDetailsList);
		
	}

}
