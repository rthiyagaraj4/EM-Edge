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
package portalrefimpl.contactreason.rescheduleapptrequest.dac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.contactreason.ContactReasonConstants;
import portalrefimpl.contactreason.common.model.ContactReasonModel;
import portalrefimpl.contactreason.rescheduleapptrequest.request.ContactReasonRequest;
import portalrefimpl.contactreason.rescheduleapptrequest.response.ContactReasonResponse;

/**
 * This is the DAC layer class used in getting the contact reason for reschedule
 * appointment request service
 * 
 * @author GRamamoorthy
 * 
 */
public class ContactReasonDAC {

	/**
	 * This method gets the contact reason for reschedule appointment request
	 * service
	 * 
	 * @param request
	 * @return
	 */
	public ContactReasonResponse getContactReasons(ContactReasonRequest request) {
		ContactReasonResponse response = new ContactReasonResponse();
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		// get the connection and check it for null - for safety
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

		String sqlQuery = getSQLQuery(request);
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = conn.prepareStatement(sqlQuery);
			setDataInPreparedStatement(request,prepStmt);
			rs = prepStmt.executeQuery();
			// safe check
			if(rs == null){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);

				response.addError(errorInfo);
				return response;
			}
			
			// get data from result set
			populateDataInResponse(rs, request, response);
		} catch (SQLException e) {
			errorCode = ContactReasonConstants.APPT_REQ_SQLEXCEPTION_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.CONTACT_REASON_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);

			response.addError(errorInfo);
		}finally{
			PortalHelper.closeResources(conn, prepStmt, rs);
		}

		return response;
	}

	/**
	 * This method returns the SQL query used to get the contact reasons
	 * 
	 * @param request
	 * @return
	 */
	private String getSQLQuery(ContactReasonRequest request) {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT contact_reason description ,contact_reason_code code FROM am_contact_reason_lang_vw WHERE NVL(modify_wait_list_yn,'N') = 'Y'  AND eff_status='E' AND language_id=? AND UPPER(contact_reason_code) LIKE UPPER(?) AND UPPER(contact_reason) LIKE UPPER(?)  ORDER BY 2");

		return builder.toString();
	}

	/**
	 * This method sets the data to the prepared statement 
	 * @param request
	 * @param prepStmt
	 * @return
	 * @throws SQLException
	 */
	private void setDataInPreparedStatement(ContactReasonRequest request,
			PreparedStatement prepStmt) throws SQLException {
		int index = 1;
		// first comes language
		String language = request.getLocale();
		prepStmt.setString(index, language);
		index++;
		
		// next reason code
		String reasonCode = request.getReasonCode();
		if(reasonCode == null || reasonCode.trim().equals("")){
			reasonCode = ContactReasonConstants.DEFAULT_REASON_CODE;
		}
		prepStmt.setString(index,reasonCode);
		index++;
		
		String reasonDescription = request.getReasonDescription();
		if(reasonDescription == null || reasonDescription.trim().equals("")){
			reasonDescription = ContactReasonConstants.DEFAULT_REASON_DESCRIPTION;
		}
		prepStmt.setString(index, reasonDescription);
	}
	
	/**
	 * This method populates data in the response
	 * @param rs
	 * @param request
	 * @param response
	 * @throws SQLException
	 */
	private void populateDataInResponse(ResultSet rs,
			ContactReasonRequest request, ContactReasonResponse response)
			throws SQLException {
		List<ContactReasonModel> contactReasonModelList = new ArrayList<ContactReasonModel>();
		final String REASON_DESCRIPTION_IDENTIFIER = "description";
		final String REASON_CODE_IDENTIFIER = "code";
		String reasonCode = null;
		String reasonDescription = null;
		ContactReasonModel model = null;
		// iterate through the result set and get data
		while(rs.next()){
			reasonCode = rs.getString(REASON_CODE_IDENTIFIER);
			reasonDescription = rs.getString(REASON_DESCRIPTION_IDENTIFIER);
			
			model = new ContactReasonModel(reasonCode, reasonDescription);
			contactReasonModelList.add(model);
		}
		
		response.setContactReasonList(contactReasonModelList);
		
		// check for empty and set error in the response
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		if(contactReasonModelList.isEmpty()){
			errorCode = ContactReasonConstants.APPT_REQ_DATANOTFOUND_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.CONTACT_REASON_MODULE_NAME, errorCode);
		}
		
		/*ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(errorCode);
		errorInfo.setErrorMessage(errorMessage);*/
		response.addError(errorCode, errorMessage);
	}

	/**
	 * 
	 * @param args
	 */
	/*public static void main(String[] args){
		ContactReasonRequest request = new ContactReasonRequest();
		ContactReasonDAC dacInst = new ContactReasonDAC();
		ContactReasonResponse response = dacInst.getContactReasons(request);
		if(response.hasErrors() && response.isSuccessful()){
			System.out.println("response is obtained successfully");
			List<ContactReasonModel> contactReasonModelList = response.getContactReasonList();
			System.out.println("--------------------------------------------------------------");
			for(ContactReasonModel model : contactReasonModelList){
				System.out.println("reason code="+model.getCode()+";;description="+model.getDescription());
			}
		}else{
			System.out.println("could not get response - error message="+response.getErrorMessage());
		}
	}*/
	
}
