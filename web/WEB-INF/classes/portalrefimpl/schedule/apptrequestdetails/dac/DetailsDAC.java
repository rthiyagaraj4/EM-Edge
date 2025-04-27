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
package portalrefimpl.schedule.apptrequestdetails.dac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.schedule.apptrequestdetails.request.DetailsRequest;
import portalrefimpl.schedule.apptrequestdetails.response.DetailsResponse;
import portalrefimpl.schedule.rescheduleappointment.RescheduleRequestConstants;

/**
 * This is the DAC layer class for the service to get details
 * of an appointment request
 * @author GRamamoorthy
 *
 */
public class DetailsDAC {

	/**
	 * This method gets the details of an appointment request
	 * This method takes as input an instance of DetailsRequest
	 * This method gets the details by querying the table
	 * PR_WAIT_LIST
	 * @param request
	 * @return
	 */
	public DetailsResponse getApptRequestDetails(DetailsRequest request){
		// initialize the response object
		DetailsResponse response = new DetailsResponse();
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		
		Connection conn = PortalHelper.getConnection();
		// safe approach
		if(conn == null){
			errorCode = CommonConstants.DBCONNECTION_FAILURE_ERRORCODE;
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
							errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			return response;
		}
		
		String sqlQuery = getDetailsQuery(request);
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = conn.prepareStatement(sqlQuery);
			setDataInPreparedStatement(prepStmt,request);
			rs = prepStmt.executeQuery();
			if(rs == null){
				errorCode = RescheduleRequestConstants.GET_APPTREQUESTDETAILS_NULLRESULTSET_ERRORCODE;
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
								errorCode);
				errorInfo.setErrorMessage(errorMessage);
				response.addError(errorInfo);
			}else{
				populateDataInDetailsResponse(conn,rs, response, request);
			}
		} catch (SQLException e) {
			errorCode = RescheduleRequestConstants.GET_APPTREQUESTDETAILS_SQLEXCEPTION_ERRORCODE;
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
							errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			
		}finally{
			PortalHelper.closeResources(conn, prepStmt, rs);
		}
		
		
		return response;
	}
	
	/**
	 * This method gets the SQL query for getting details of an appointment request
	 * @param detailsRequest
	 * @return
	 */
	private String getDetailsQuery(DetailsRequest detailsRequest){
		StringBuffer queryBuffer = new StringBuffer();
		queryBuffer.append("select FACILITY_ID,WAIT_LIST_NO,PREFERRED_DATE_TIME,SPECIALTY_CODE,CARE_LOCN_TYPE_IND,LOCN_CODE,");
		queryBuffer.append("RESOURCE_CLASS,RESOURCE_ID,PATIENT_ID,PREF_FROM_TIME,PREF_TO_TIME ");
		queryBuffer.append("from PR_WAIT_LIST ");
		queryBuffer.append("where wait_list_status = 'O' and ");
		queryBuffer.append("web_req_yn = 'Y' and ");
		// now add segments for the patient id and reference number
		queryBuffer.append("PATIENT_ID = ? and ");
		queryBuffer.append("WAIT_LIST_NO = ?");
		
		return queryBuffer.toString();
	}
	
	/**
	 * This method sets data in the prepared statement object
	 * by taking in data from the request object
	 * @param prepStmt
	 * @param request
	 * @throws SQLException
	 */
	private void setDataInPreparedStatement(PreparedStatement prepStmt,
			DetailsRequest request) throws SQLException {
		int index = 1;
		// first patient id
		String patientId = request.getPatientId();
		if(patientId == null){
			patientId = "";
		}
		prepStmt.setString(index, patientId);
		index++;
		
		// next appointment reference number
		String referenceNumber = request.getApptRequestReferenceNumber();
		if(referenceNumber == null){
			referenceNumber = "";
		}
		prepStmt.setString(index, referenceNumber);
	}
	
	/**
	 * This method populates data from the result set object to the 
	 * details response object
	 * @param conn 
	 * @param rs
	 * @param response
	 * @param request 
	 * @throws SQLException
	 */
	private void populateDataInDetailsResponse(Connection conn,
			ResultSet rs, DetailsResponse response, DetailsRequest request) throws SQLException {
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		String facilityName = null;
		String specialityName = null;
		String resourceName = null;
		// get the language from the request object
		String language = request.getLocale();
		// check if the result set has data
		if(rs.next()){
			String facilityId = rs.getString("FACILITY_ID");
			String waitListNumber = rs.getString("WAIT_LIST_NO");
			Timestamp preferredDateTime = rs.getTimestamp("PREFERRED_DATE_TIME");
			String specialityCode = rs.getString("SPECIALTY_CODE");
			String careLocationTypeIndicator = rs.getString("CARE_LOCN_TYPE_IND");
			String locationCode = rs.getString("LOCN_CODE");
			String resourceClass = rs.getString("RESOURCE_CLASS");
			String resourceId = rs.getString("RESOURCE_ID");
			String patientId = rs.getString("PATIENT_ID");
			Timestamp preferredFromTimeObj = rs.getTimestamp("PREF_FROM_TIME");
			Timestamp preferredToTimeObj = rs.getTimestamp("PREF_TO_TIME");
			
			facilityName = getFacilityName(conn, facilityId);
			specialityName = getSpecialtyName(specialityCode,conn);
			resourceName = getResourceName(resourceId, facilityId, language, conn);
			String preferredFromTime = PortalHelper
					.getDateAsString(
							preferredFromTimeObj,
							RescheduleRequestConstants.APPTREQ_DETAILS_DATE_TIME_FORMAT);
			String preferredToTime = PortalHelper
					.getDateAsString(
							preferredToTimeObj,
							RescheduleRequestConstants.APPTREQ_DETAILS_DATE_TIME_FORMAT);
			
			response.setFacilityId(facilityId);
			response.setFacilityName(facilityName);
			response.setApptRequestReferenceNumber(waitListNumber);
			response.setPreferredDate(preferredDateTime);
			response.setSpecialityCode(specialityCode);
			response.setSpecialityName(specialityName);
			response.setCareLocationTypeIndicator(careLocationTypeIndicator);
			response.setLocationCode(locationCode);
			response.setResourceClass(resourceClass);
			response.setResourceId(resourceId);
			response.setResourceName(resourceName);
			response.setPatientId(patientId);
			response.setPreferredFromTime(preferredFromTime);
			response.setPreferredToTime(preferredToTime);
		}else{
			// data is not present - set error code
			errorCode = RescheduleRequestConstants.GET_APPTREQUESTDETAILS_DATA_NOTFOUND_ERRORCODE;
			errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
							errorCode);
		}
		
		// finally set the error info object to the response
		errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(errorCode);
		errorInfo.setErrorMessage(errorMessage);
		response.addError(errorInfo);
	}
	
	/**
	 * This method returns the facility name given the facility id
	 * and a connection object
	 * @param conn
	 * @param facilityId
	 * @return
	 */
	private String getFacilityName(Connection conn,String facilityId){
		String facilityName = null;
		String sqlQuery = "select DISTINCT SM_FACILITY_PARAM.FACILITY_NAME from SM_FACILITY_PARAM,SM_SITE_PARAM where SM_FACILITY_PARAM.SITE_ID=SM_SITE_PARAM.SITE_ID and SM_FACILITY_PARAM.FACILITY_ID = '"+facilityId+"'";
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = conn.prepareStatement(sqlQuery);
			rs = prepStmt.executeQuery();
			if(rs != null && rs.next()){
				facilityName = rs.getString("FACILITY_NAME");
			}
		} catch (SQLException e) {
			// cannot do much
			facilityName = "";
		}
		
		return facilityName;
	}
	
	/**
	 * This method returns the specialty name given the specialty id
	 * and a connection object
	 * @param specialtyCode
	 * @param conn
	 * @return
	 */
	private String getSpecialtyName(String specialtyCode,Connection conn){
		String specialtyName = null;
		
		String sqlQuery = "select am_get_desc.AM_SPECIALITY(speciality_code,'en',2) short_desc from am_speciality where  eff_status='E' and speciality_code  = '"+specialtyCode+"'";
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = conn.prepareStatement(sqlQuery);
			rs = prepStmt.executeQuery();
			if(rs != null && rs.next()){
				specialtyName = rs.getString("short_desc");
			}
		} catch (SQLException e) {
			// cannot do much
			specialtyName = "";
		}
		
		return specialtyName;
	}
	
	/**
	 * This method returns the resource name given the resource id
	 * and a connection object
	 * @param resourceId
	 * @param conn
	 * @return
	 */
	private String getResourceName(String resourceId,String facilityId,String language,Connection conn){
		String resourceName = null;
		
		String sqlQuery = "Select b.short_name practName from am_pract_for_facility_vw a, am_practitioner_lang_vw b where a.operating_facility_id ='"+facilityId+"'  and a.practitioner_id = b.practitioner_id and b.language_id = '"+language+"' and a.eff_status = 'E' and a.practitioner_id = '"+resourceId+"'";
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = conn.prepareStatement(sqlQuery);
			rs = prepStmt.executeQuery();
			if(rs != null && rs.next()){
				resourceName = rs.getString("practName");
			}
		} catch (SQLException e) {
			// cannot do much
			resourceName = "";
		}
		
		return resourceName;
	}
	
	
	public static void main(String[] args){
		DetailsDAC dacInst = new DetailsDAC();
		DetailsRequest detailsRequest = new DetailsRequest();
		detailsRequest.setPatientId("HC00007128");
		detailsRequest.setApptRequestReferenceNumber("13594");
		detailsRequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
		DetailsResponse response = dacInst.getApptRequestDetails(detailsRequest);
		if(response.isSuccessful()){
			System.out.println("reference number ="+response.getApptRequestReferenceNumber());
			System.out.println("facility id ="+response.getFacilityId());
			System.out.println("facility name ="+response.getFacilityName());
			System.out.println("care location indicator ="+response.getCareLocationTypeIndicator());
			System.out.println("location code ="+response.getLocationCode());
			System.out.println("patient id ="+response.getPatientId());
			System.out.println("resource class ="+response.getResourceClass());
			System.out.println("resource id ="+response.getResourceId());
			System.out.println("resource name ="+response.getResourceName());
			System.out.println("specialty code ="+response.getSpecialityCode());
			System.out.println("specialty name ="+response.getSpecialityName());
			System.out.println("preferred date ="+response.getPreferredDate());
			String preferredFromTime = response.getPreferredFromTime();
			System.out.println("preferred from time ="+preferredFromTime);
			Date preferredFromTimeObj = PortalHelper
					.getDateFromString(
							preferredFromTime,
							RescheduleRequestConstants.APPTREQ_DETAILS_DATE_TIME_FORMAT);
			System.out.println("Preferred from time date object value ="+preferredFromTimeObj);
			System.out.println("preferred to time  ="+response.getPreferredToTime());
		}else{
			System.out.println("could not get appt request details response");
		}
		
	}
	
}
