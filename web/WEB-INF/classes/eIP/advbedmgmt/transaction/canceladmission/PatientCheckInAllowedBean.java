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
package eIP.advbedmgmt.transaction.canceladmission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Map;

import org.apache.commons.collections.map.LRUMap;

import webbeans.eCommon.ConnectionManager;

/**
 * This bean class is used to get the patient checked in allowed status
 * for a facility
 * This bean stores the status for each facility in a LRUMap
 * 
 * @author GRamamoorthy
 *
 */
public class PatientCheckInAllowedBean {

	/**
	 * Stores the status against a facility
	 * 
	 */
	private Map<String, String> statusMap = null;
	
	/**
	 * Constructor of the class
	 */
	@SuppressWarnings("unchecked")
	public PatientCheckInAllowedBean(){
		final int maxSize = 100;
		/**
		 * TODO
		 * the max size should be obtained from a properties file
		 */
		statusMap = (Map<String, String>)Collections.synchronizedMap(new LRUMap(maxSize));
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public PatientCheckInStatusResponse getPatientCheckedInStatus(
			PatientCheckInStatusRequest request) {
		PatientCheckInStatusResponse response = new PatientCheckInStatusResponse();
		final String RESULT_COL_NAME = "pat_check_in_allowed_yn";
		String facilityId = request.getFacilityId();
		String statusVal = null;
		// check if the status map already contains the facility id
		// if so get the status
		if(statusMap.containsKey(facilityId)){
			statusVal = statusMap.get(facilityId);
			response.setPatientCheckedInStatus(statusVal);
		}else{
			// read the checked in status from the db
			Connection conn = ConnectionManager.getConnection();
			// safe check
			if(conn == null){
				/**
				 * TODO
				 * need to log
				 */
				return response;
			}
			
			String query = getSQLQuery();
			PreparedStatement prepStmt = null;
			ResultSet rs = null;
			
			try {
				prepStmt = conn.prepareStatement(query);
				setDataInPreparedStatement(prepStmt, request);
				rs = prepStmt.executeQuery();
				if(rs == null){
					/**
					 * TODO
					 * need to log
					 */
					return response;
				}
				// get the data from result set as well
				while(rs.next()){
					statusVal = rs.getString(RESULT_COL_NAME);
				}
				
				response.setPatientCheckedInStatus(statusVal);
			} catch (SQLException e) {
				/**
				 * TODO
				 * need to log
				 */
			}finally{
				if(rs != null){
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(prepStmt != null){
					try {
						prepStmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				ConnectionManager.returnConnection(conn);
			}
			
		}
		
		return response;
	}
	
	/**
	 * This method returns the SQL query for getting the patient checked in status
	 * @return
	 */
	private String getSQLQuery(){
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT pat_check_in_allowed_yn FROM IP_PARAM  WHERE facility_id=?");
		return queryBuilder.toString();
	}
	
	/**
	 * This method sets data to the prepared statement
	 * @param prepStmt
	 * @param request
	 * @throws SQLException
	 */
	private void setDataInPreparedStatement(PreparedStatement prepStmt,
			PatientCheckInStatusRequest request) throws SQLException {
		String facilityId = request.getFacilityId();
		// safe check
		if(facilityId == null){
			facilityId = "";
		}
		// set the data at the specified index
		int index = 1;
		prepStmt.setString(index, facilityId);
	}	

	
}
