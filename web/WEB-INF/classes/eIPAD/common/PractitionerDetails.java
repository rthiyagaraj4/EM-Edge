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
package eIPAD.common;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import webbeans.eCommon.ConnectionManager;

/**
 * This class is the bean class which will be used for
 * getting Practitioner details
 * 
 * @author GRamamoorthy
 *
 */
public class PractitionerDetails implements Serializable {

	/**
	 * Default constructor of the class
	 */
	public PractitionerDetails() {
	}
	
	/**
	 * 
	 * @param practitionerRequest
	 * @return
	 */
	public PractitionerDetailResponse getPractitionerDetails(
			PractitionerDetailRequest practitionerRequest) {
		PractitionerDetailResponse practitionerResponse = new PractitionerDetailResponse();
		// safe check
		if(practitionerRequest == null){
			return practitionerResponse;
		}
		// get the data from the request
		String locale = practitionerRequest.getLocale();
		String userId = practitionerRequest.getUserId();
		HttpServletRequest servletRequest = practitionerRequest.getRequest();
		// initialize the connection
		Connection conn = null;
		conn = ConnectionManager.getConnection(servletRequest);
		if(conn == null){
			return practitionerResponse;
		}
		// form the SQL query
		StringBuffer queryBuff = new StringBuffer();
		queryBuff.append("SELECT func_role_id practitioner_id, AM_GET_DESC.AM_PRACTITIONER(a.func_role_id,");
		queryBuff.append("'").append(locale).append("'");
		queryBuff.append(",'1') practitioner_name FROM sm_appl_user a WHERE appl_user_id =");
		queryBuff.append("'").append(userId).append("'");
		// execute the query and process the results
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(queryBuff.toString());
			if(rs != null){
				String practitionerId = null;
				String practitionerName = null;
				while(rs.next()){
					practitionerId = rs.getString("practitioner_id");
					practitionerName = rs.getString("practitioner_name");
				}
				practitionerResponse.setPractitionerId(practitionerId);
				practitionerResponse.setPractitionerName(practitionerName);
			}
		} catch (SQLException e) {
			/**
			 * TODO
			 * need to properly handle this
			 */
			return practitionerResponse;
		}
		finally{
			try{
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					ConnectionManager.returnConnection(conn);
			}
			catch(SQLException e){
			}
		}
		
		return practitionerResponse;
	}
	
	/**
	 * This method gets the practitioner details (only the practitioner name)
	 * given a request which contains the locale and accession number
	 * @param notesRequest
	 * @return
	 */
	public PractitionerDetailResponse getPractitionerForAccessionNumber(NotesRequest notesRequest){
		PractitionerDetailResponse practitionerResponse = new PractitionerDetailResponse();
		// safe check
		if(notesRequest == null){
			return practitionerResponse;
		}
		// check request has a non null accession number
		String accessionNumber = notesRequest.getAccessionNumber();
		if(accessionNumber == null){
			return practitionerResponse;
		}
		// get the other data members from request
		String locale = notesRequest.getLocale();
		HttpServletRequest servletRequest = notesRequest.getRequest();
		// initialize the connection
		Connection conn = ConnectionManager.getConnection(servletRequest);
		if(conn == null){
			return practitionerResponse;
		}
		// initialize the SQL query, prepared statement and execute the query
		// get the result set and set the data to response
		String query = " select am_get_desc.am_practitioner(practitioner_id,?,2) practitioner_name from cr_encounter_detail where accession_num=?";
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		String practitionerName = null;
		try {
			prepStmt = conn.prepareStatement(query);
			prepStmt.setString(1, locale);
			prepStmt.setString(2, accessionNumber);
			
			rs = prepStmt.executeQuery();
			if(rs != null){
				while (rs.next()) {
					practitionerName = rs.getString("practitioner_name");
				}
			}
			practitionerResponse.setPractitionerName(practitionerName);
			
		} catch (SQLException e) {
			/**
			 * TODO
			 * need to process properly
			 */
		}
		finally{
			try{
				if(rs!=null)
					rs.close();
				if(prepStmt!=null)
					prepStmt.close();
				if(conn!=null)
					ConnectionManager.returnConnection(conn);
			}
			catch(SQLException e){
			}
			
		}
		
		return practitionerResponse;
	}
	
	
	

}
