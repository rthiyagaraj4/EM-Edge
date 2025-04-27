/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
 29/04/2024     58928	     Krishna pranay	         30/04/204         Ramesh Goli       	ML-MMOH-CRF-1759.2
 28/10/2024     70704	     Gunasekar R	         28/10/2024         Ashwini Ragupathi           ML-MMOH-CRF-1759
01/10/2024     68508     krishna pranay             13/10/2024  Ashwini Ragupathi  ML-MMOH-CRF-1759	
						
--------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.*;
import java.util.*;
import java.sql.* ;

import javax.naming.*;
import javax.rmi.*;
import eCommon.Common.*;
import eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;
import java.text.SimpleDateFormat;


public class CAMenstrualHistDtlTransBean extends eCA.Common.CaAdapter implements java.io.Serializable {
	 public int[] getMenstrualAgeDetails(String facility_id) throws Exception {
		    Connection connection = null;
		    PreparedStatement pstmt = null;
		    ResultSet resultSet = null;

		    int[] ageDetails = new int[2]; // Array to store MIN_AGE and MAX_AGE

		    try {
		        connection = getConnection();
		        pstmt = connection.prepareStatement("SELECT MIN_AGE, MAX_AGE FROM CA_MENSTRUAL_HIST_DTL WHERE FACILITY_ID=?");
		        pstmt.setString(1, facility_id);
		        resultSet = pstmt.executeQuery();

		        if (resultSet.next()) {
		            // Get MIN_AGE and handle empty/null values
		            int minAge = resultSet.getInt("MIN_AGE");
		            ageDetails[0] = (minAge != 0) ? minAge : 1; // Set default value as 1 if MIN_AGE is empty/null

		            // Get MAX_AGE and handle empty/null values
		            int maxAge = resultSet.getInt("MAX_AGE");
		            ageDetails[1] = (maxAge != 0) ? maxAge : 999; // Set default value as 999 if MAX_AGE is empty/null

		        } else {
		            // If no records found, set default values for both MIN_AGE and MAX_AGE
		            ageDetails[0] = 1;
		            ageDetails[1] = 999;

		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        throw e;
		    } finally {
		        closeResultSet(resultSet);
		        closeStatement(pstmt);
		        closeConnection(connection);
		    }
		    return ageDetails;
		}
	 
			public ArrayList  getPatientMenstrualHistory(String patient_id) throws Exception {
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    Connection con = null;
			ArrayList ResultDetail  =new ArrayList();


		    try {
		    	//String menstrualHistoryQuery = "SELECT patient_id, event, TO_CHAR (last_menstrual_period, 'dd/mm/yyyy') AS last_menstrual_period, TO_CHAR (edd, 'dd/mm/yyyy') AS edd, CASE WHEN gestation_poa_weeks IS NOT NULL AND gestation_poa_days IS NOT NULL AND (gestation_poa_weeks <> 0 OR gestation_poa_days <> 0) THEN gestation_poa_weeks || ' weeks ' || gestation_poa_days || ' days' ELSE '' END AS gestation_poa, CASE WHEN scan_gestation_weeks IS NOT NULL AND scan_gestation_days IS NOT NULL THEN scan_gestation_weeks || ' weeks ' || scan_gestation_days || ' days' ELSE '' END AS scan_gestation, TO_CHAR (unsure_of_date, 'dd/mm/yyyy') AS unsure_of_date, TO_CHAR (redd, 'dd/mm/yyyy') AS redd, CASE WHEN gestation_pog_weeks IS NOT NULL AND gestation_pog_days IS NOT NULL AND (gestation_pog_weeks <> 0 OR gestation_pog_days <> 0) THEN gestation_pog_weeks || ' weeks ' || gestation_pog_days || ' days' ELSE '' END AS gestation_pog, delivery_miscarrage_type, TO_CHAR (delivery_miscarrage_date, 'dd/mm/yyyy' ) AS delivery_miscarrage_date, remarks, modified_remarks, srl_no, event_status, error_remarks, added_date, CASE WHEN (SELECT time_of_birth FROM mp_birth_register bm WHERE bm.patient_id = cm.patient_id AND bm.time_of_birth IS NULL) IS NULL AND cm.event_status = 'C' AND cm.added_date = (SELECT MAX (added_date) FROM ca_mens_his_trans_dtl WHERE patient_id = cm.patient_id) THEN 'E' ELSE '' END AS e_button_display, event_remarks FROM ca_mens_his_trans_dtl cm WHERE cm.patient_id =? AND cm.facility_id =? ORDER BY cm.added_date ASC";
		   // 	String menstrualHistoryQuery = "SELECT patient_id, event, TO_CHAR(last_menstrual_period, 'dd/mm/yyyy') AS last_menstrual_period, TO_CHAR(edd, 'dd/mm/yyyy') AS edd, CASE WHEN gestation_poa_weeks IS NOT NULL AND gestation_poa_days IS NOT NULL AND (gestation_poa_weeks <> 0 OR gestation_poa_days <> 0) THEN gestation_poa_weeks || ' weeks ' || gestation_poa_days || ' days' ELSE '' END AS gestation_poa, CASE WHEN scan_gestation_weeks IS NOT NULL AND scan_gestation_days IS NOT NULL THEN scan_gestation_weeks || ' weeks ' || scan_gestation_days || ' days' ELSE '' END AS scan_gestation, TO_CHAR(unsure_of_date, 'dd/mm/yyyy') AS unsure_of_date, TO_CHAR(redd, 'dd/mm/yyyy') AS redd, CASE WHEN gestation_pog_weeks IS NOT NULL AND gestation_pog_days IS NOT NULL AND (gestation_pog_weeks <> 0 OR gestation_pog_days <> 0) THEN gestation_pog_weeks || ' weeks ' || gestation_pog_days || ' days' ELSE '' END AS gestation_pog, delivery_miscarrage_type, TO_CHAR(delivery_miscarrage_date, 'dd/mm/yyyy') AS delivery_miscarrage_date, remarks, modified_remarks, srl_no, event_status, error_remarks, added_date, CASE WHEN cm.event_status = 'C' AND cm.DELIVERY_MISCARRAGE_DATE = ( SELECT MAX(DELIVERY_MISCARRAGE_DATE) FROM ca_mens_his_trans_dtl WHERE patient_id = cm.patient_id AND event_status = 'C' ) AND NOT EXISTS ( SELECT 1 FROM mp_birth_register bm WHERE bm.MOTHER_PATIENT_ID = cm.patient_id AND bm.time_of_birth IS NOT NULL AND bm.FINALIZED_YN = 'N' AND TO_DATE(TO_CHAR(bm.time_of_birth, 'dd/mm/yyyy'), 'dd/mm/yyyy') = TO_DATE(TO_CHAR(cm.DELIVERY_MISCARRAGE_DATE, 'dd/mm/yyyy'), 'dd/mm/yyyy') ) THEN 'E' ELSE '' END AS e_button_display, event_remarks FROM ca_mens_his_trans_dtl cm WHERE cm.patient_id = ? AND cm.facility_id = ? ORDER BY cm.added_date ASC";
		    	String menstrualHistoryQuery = "	SELECT patient_id, event, TO_CHAR(last_menstrual_period, 'dd/mm/yyyy') AS last_menstrual_period, TO_CHAR(edd, 'dd/mm/yyyy') AS edd, CASE WHEN event = 'L' THEN CASE WHEN gestation_poa_weeks IS NOT NULL AND gestation_poa_days IS NOT NULL AND (gestation_poa_weeks <> 0 OR gestation_poa_days <> 0) THEN gestation_poa_weeks || ' weeks ' || gestation_poa_days || ' days' ELSE '0 weeks 0 days' END ELSE '' END AS gestation_poa, CASE WHEN scan_gestation_weeks IS NOT NULL AND scan_gestation_days IS NOT NULL THEN scan_gestation_weeks || ' weeks ' || scan_gestation_days || ' days' ELSE '' END AS scan_gestation, TO_CHAR(unsure_of_date, 'dd/mm/yyyy') AS unsure_of_date, TO_CHAR(redd, 'dd/mm/yyyy') AS redd, CASE WHEN event = 'U' THEN CASE WHEN gestation_pog_weeks IS NOT NULL AND gestation_pog_days IS NOT NULL AND (gestation_pog_weeks <> 0 OR gestation_pog_days <> 0) THEN gestation_pog_weeks || ' weeks ' || gestation_pog_days || ' days' ELSE '0 weeks 0 days' END ELSE '' END AS gestation_pog, delivery_miscarrage_type, TO_CHAR(delivery_miscarrage_date, 'dd/mm/yyyy') AS delivery_miscarrage_date, remarks, modified_remarks, srl_no, event_status, error_remarks, added_date, CASE WHEN cm.event_status = 'C' AND cm.delivery_miscarrage_date = (SELECT MAX(delivery_miscarrage_date) FROM ca_mens_his_trans_dtl WHERE patient_id = cm.patient_id AND event_status = 'C') AND NOT EXISTS ( SELECT 1 FROM mp_birth_register bm WHERE bm.mother_patient_id = cm.patient_id AND bm.time_of_birth IS NOT NULL AND bm.finalized_yn = 'Y' AND TO_DATE(TO_CHAR(bm.time_of_birth, 'dd/mm/yyyy'), 'dd/mm/yyyy') = TO_DATE(TO_CHAR(cm.delivery_miscarrage_date, 'dd/mm/yyyy'), 'dd/mm/yyyy')) THEN 'E' ELSE '' END AS e_button_display, event_remarks FROM ca_mens_his_trans_dtl cm WHERE cm.patient_id = ?  ORDER BY cm.added_date ASC";
		    
		    	con = getConnection();
		        pstmt = con.prepareStatement(menstrualHistoryQuery);
		        pstmt.setString(1, patient_id);
		      //  pstmt.setString(2, facility_id);


		        rs = pstmt.executeQuery();
		        
		        while (rs != null && rs.next()) {
		            String[] record = new String[19];
		            record[0] = rs.getString("PATIENT_ID");
		            record[1] = rs.getString("EVENT");
		            record[2] = rs.getString("LAST_MENSTRUAL_PERIOD") != null ? rs.getString("LAST_MENSTRUAL_PERIOD") : "N/A ";
		            record[3] = rs.getString("EDD") != null ? rs.getString("EDD") : "N/A";
		            record[4] = rs.getString("GESTATION_POA") != null ? rs.getString("GESTATION_POA") : "N/A";
		            record[5] = rs.getString("SCAN_GESTATION") != null ? rs.getString("SCAN_GESTATION") : "N/A";
		            record[6] = rs.getString("UNSURE_OF_DATE") != null ? rs.getString("UNSURE_OF_DATE") : "N/A ";
		            record[7] = rs.getString("REDD") != null ? rs.getString("REDD") : "N/A ";
		            record[8] = rs.getString("GESTATION_POG") != null ? rs.getString("GESTATION_POG") : "N/A ";
		            record[9] = rs.getString("DELIVERY_MISCARRAGE_TYPE") != null ? rs.getString("DELIVERY_MISCARRAGE_TYPE") : "";
		            record[10] = rs.getString("DELIVERY_MISCARRAGE_DATE") != null ? rs.getString("DELIVERY_MISCARRAGE_DATE") : "";
		            record[11] = rs.getString("REMARKS") != null ? rs.getString("REMARKS") : "";
		            record[12] = rs.getString("MODIFIED_REMARKS") != null ? rs.getString("MODIFIED_REMARKS") : "";
		            record[13] = rs.getString("SRL_NO") ;
		            record[14] = rs.getString("EVENT_STATUS") ;
		            record[15] = rs.getString("ERROR_REMARKS") != null ? rs.getString("ERROR_REMARKS") : "";
		            record[16] = rs.getString("ADDED_DATE") != null ? rs.getString("ADDED_DATE") : "";
		            record[17] = rs.getString("e_button_display") != null ? rs.getString("e_button_display") : "";
		            record[18] = rs.getString("event_remarks") != null ? rs.getString("event_remarks") : "";

		            ResultDetail.add(record);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        throw e;
		    } finally {
		        closeResultSet(rs);
		        closeStatement(pstmt);
		        closeConnection(con);
		    }
		    return ResultDetail;
		}
		
		
		public String[] getEddOfLmpDate(String lmpDateStr) throws Exception {
		    Connection connection = null;
		    CallableStatement callableStmt = null;
		    String[] eddDetails = new String[3];
		    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		    try {
		       
		     String sql = "{CALL CA_CALCULATE_LMP_GEST_DATE(?, ?, ?, ?)}";
			 
		        connection = getConnection();

		        callableStmt = connection.prepareCall(sql);

		        callableStmt.setString(1, lmpDateStr); // Set the prepared statement parameter
		        // Register out parameters
		        callableStmt.registerOutParameter(2, java.sql.Types.DATE); // EDD output
		        callableStmt.registerOutParameter(3, java.sql.Types.NUMERIC); // Gestational weeks
		        callableStmt.registerOutParameter(4, java.sql.Types.NUMERIC); // Remaining days

		        // Execute stored procedure
		        callableStmt.execute();

		        // Retrieve output parameters
		        java.sql.Date edd = callableStmt.getDate(2); // Fetch EDD from stored procedure
		        int gestWeeks = callableStmt.getInt(3);      // Fetch gestational weeks
		        int gestRemDays = callableStmt.getInt(4);    // Fetch remaining days

		        // Format and store values
		        eddDetails[0] = (edd != null) ? sdf.format(edd) : " "; // Format EDD date to "dd/MM/yyyy"
		        eddDetails[1] = (gestWeeks > 0) ? String.valueOf(gestWeeks) : "0"; // Set gestational weeks
		        eddDetails[2] = (gestRemDays > 0) ? String.valueOf(gestRemDays) : "0"; // Set gestational remaining days

		    } catch (Exception e) {
		        e.printStackTrace();
		        throw e; // Optionally rethrow the exception if necessary
		    } finally {
		        // Always ensure resources are closed in the finally block
		         try {
		            closeStatement(callableStmt);
		            closeConnection(connection);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }

		    return eddDetails;
		}

		
		public String[] calculateUnsurePreDate(int scanGestWeeks, int scanGestDays) throws Exception {
		    Connection connection = null;
		    CallableStatement callableStmt = null;
		    String[] results = new String[4]; // To store LMP Date, REDD Date, POG Weeks, and POG Days
		    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		    try {
		        // SQL to call the stored procedure
		        String sql = "{CALL CA_CALC_UNSURE_PREDATE(?, ?, ?, ?, ?, ?)}"; 
		        
		        // Establish database connection
		        connection = getConnection();
		        
		        // Prepare the callable statement
		        callableStmt = connection.prepareCall(sql);
		        
		        // Set the input parameters
		        callableStmt.setInt(1, scanGestWeeks); // Input: Gestation weeks
		        callableStmt.setInt(2, scanGestDays);  // Input: Gestation days
		        
		        // Register the output parameters
		        callableStmt.registerOutParameter(3, java.sql.Types.DATE);   // Output: LMP Date
		        callableStmt.registerOutParameter(4, java.sql.Types.DATE);   // Output: REDD Date (Expected Delivery Date)
		        callableStmt.registerOutParameter(5, java.sql.Types.NUMERIC); // Output: POG Weeks (Pregnancy in weeks)
		        callableStmt.registerOutParameter(6, java.sql.Types.NUMERIC); // Output: POG Days (Remaining days of gestation)
		        
		        // Execute the stored procedure
		        callableStmt.execute();
		        
		        // Retrieve the output values
		        java.sql.Date lmpDate = callableStmt.getDate(3);    // LMP Date
		        java.sql.Date reddDate = callableStmt.getDate(4);   // Expected Delivery Date (REDD)
		        int pogWeeks = callableStmt.getInt(5);              // Gestation Period in Weeks
		        int pogDays = callableStmt.getInt(6);               // Remaining Days of Gestation
		        
		        // Format and store the output values
		        results[0] = (lmpDate != null) ? sdf.format(lmpDate) : "";    // LMP Date formatted
		        results[1] = (reddDate != null) ? sdf.format(reddDate) : "";  // REDD Date formatted
		        results[2] = String.valueOf(pogWeeks);                        // Gestation in Weeks
		        results[3] = String.valueOf(pogDays);                         // Gestation Remaining Days
		        
		    } catch (Exception e) {
		        e.printStackTrace();
		        throw e;
		    } finally {
		        // Close the resources
		        try {
		            closeStatement(callableStmt);
		            closeConnection(connection);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }

		    return results; // Return the LMP Date, REDD Date, POG Weeks, and POG Days
		}

		public ArrayList getMenstrualHistoryMaster(String facilityId) throws Exception {
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    Connection con = null;
		    ArrayList getMasterDetails = new ArrayList();

		    try {
		        String menstrualHistoryQuery = "SELECT CUT_OFF_BACK_DATE, CUT_OFF_DATE_DELIVERY, CUT_OFF_DELIVERY_LMP, CUT_OFF_MISCARRIAGE_LMP, ENABLE_MARK_AS_ERROR_YN FROM CA_MENSTRUAL_HIST_DTL WHERE FACILITY_ID = ?";

		        con = getConnection();  // Assume this method establishes the connection
		        pstmt = con.prepareStatement(menstrualHistoryQuery);
		        pstmt.setString(1, facilityId); // Set the parameter

		        rs = pstmt.executeQuery();

		        while (rs != null && rs.next()) {
		            ArrayList record = new ArrayList();

		            // Using ternary operators to handle null values and cast to String
		            record.add(rs.getString("CUT_OFF_BACK_DATE") == null ? "" : rs.getString("CUT_OFF_BACK_DATE"));
		            record.add(rs.getString("CUT_OFF_DATE_DELIVERY") == null ? "" : rs.getString("CUT_OFF_DATE_DELIVERY"));
		            record.add(rs.getString("CUT_OFF_DELIVERY_LMP") == null ? "" : rs.getString("CUT_OFF_DELIVERY_LMP"));
		            record.add(rs.getString("CUT_OFF_MISCARRIAGE_LMP") == null ? "" : rs.getString("CUT_OFF_MISCARRIAGE_LMP"));
		            record.add(rs.getString("ENABLE_MARK_AS_ERROR_YN") == null ? "" : rs.getString("ENABLE_MARK_AS_ERROR_YN"));

		            getMasterDetails.add(record);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        throw e; // Rethrow the exception for handling at a higher level
		    } finally {
		        closeResultSet(rs);
		        closeStatement(pstmt);
		        closeConnection(con);
		    }
		    return getMasterDetails;
		}
		
		//70704 Starts
		 public String getShortDesc(String result_linked_rec_type, String locale) throws Exception {
			    Connection connection = null;
			    PreparedStatement pstmt = null;
			    ResultSet resultSet = null;

			    String short_desc = "";

			    try {
			        connection = getConnection();
			        pstmt = connection.prepareStatement("SELECT CR_GET_DESC.CR_HIST_REC_TYPE(?,?,'2') SHORT_DESC FROM DUAL");
			        pstmt.setString(1,result_linked_rec_type);
					pstmt.setString(2,locale);
			        resultSet = pstmt.executeQuery();

			        if (resultSet.next()) {
			            short_desc = resultSet.getString("SHORT_DESC");
			        }
			    } catch (Exception e) {
			        System.err.println("Error loading values from database");
			        e.printStackTrace();
			        throw e;
			    } finally {
			        closeResultSet(resultSet);
			        closeStatement(pstmt);
			        closeConnection(connection);
			    }
			    return short_desc;
			}
		 
		 public ArrayList getFields(String sec_hdg_code, String result_linked_rec_type, String result_sub_category ) throws Exception {
			    Connection connection = null;
			    PreparedStatement pstmt = null;
			    ResultSet resultSet = null;

			 	ArrayList  fields			=	new ArrayList();
			 	String  field_ref = "";

			    try {
			        connection = getConnection();
			        pstmt = connection.prepareStatement("select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_SEC_DEF F where f.SEC_HDG_CODE =? and f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY=? order by ORDER_SEQ_NUM");
			    	pstmt.setString(1, sec_hdg_code);
		 			pstmt.setString(2, result_linked_rec_type);
		 			pstmt.setString(3, result_sub_category);
			        resultSet = pstmt.executeQuery();

			        while(resultSet.next()) {
			            field_ref = resultSet.getString("FIELD_REF");
			            fields.add(field_ref);
			        }
			    } catch (Exception e) {
			        System.err.println("Error loading values from database");
			        e.printStackTrace();
			        throw e;
			    } finally {
			        closeResultSet(resultSet);
			        closeStatement(pstmt);
			        closeConnection(connection);
			    }
			    return fields;
			}
		 
		 public ArrayList getFields( String result_linked_rec_type, String result_sub_category ) throws Exception {
			    Connection connection = null;
			    PreparedStatement pstmt = null;
			    ResultSet resultSet = null;

			 	ArrayList  fields			=	new ArrayList();
			 	String  field_ref = "";

			    try {
			        connection = getConnection();
			        pstmt = connection.prepareStatement("select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_DEF  F where f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY=? order by ORDER_SEQ_NUM");
		 			pstmt.setString(1, result_linked_rec_type);
		 			pstmt.setString(2, result_sub_category);
			        resultSet = pstmt.executeQuery();

			        while (resultSet.next()) {
			            field_ref = resultSet.getString("FIELD_REF");
			            fields.add(field_ref);
			        }
			    } catch (Exception e) {
			        System.err.println("Error loading values from database");
			        e.printStackTrace();
			        throw e;
			    } finally {
			        closeResultSet(resultSet);
			        closeStatement(pstmt);
			        closeConnection(connection);
			    }
			    return fields;
			}//70704 Ends
		 
		 public HashMap getRecClinicialNoteLinkMenstResult(HashMap allParam ) throws Exception {
			 HashMap resultParam =	new HashMap();
			 try {
                String result_sub_category = (String) allParam.get("result_sub_category");
                String event_status_a = (String) allParam.get("event_status_a");
                String event_status_ac =  (String) allParam.get("event_status_ac");
                String event_status_c = (String) allParam.get("event_status_c");
                String p_from_date = (String) allParam.get("p_from_date");
                String p_to_date = (String) allParam.get("p_to_date");
                String order_by  = (String) allParam.get("order_by");
                String patient_id  = (String) allParam.get("patient_id");
                String facility_id  = (String) allParam.get("facility_id");

             	StringBuffer sql = new StringBuffer(" ");
        		HashMap sqlMap = new HashMap();
         		HashMap funcMap = new HashMap();
         		ArrayList displayFields = new ArrayList();
         		ArrayList chkFields = new ArrayList();
			 	


             	if(result_sub_category.equals("LMP"))
             		sql.append("SELECT ROWID AS row_id, TO_CHAR (last_menstrual_period, 'DD/MM/YYYY') AS lmp, TO_CHAR (edd, 'DD/MM/YYYY') AS edd, CASE WHEN gestation_poa_weeks IS NOT NULL AND gestation_poa_days IS NOT NULL AND (gestation_poa_weeks <> 0 OR gestation_poa_days <> 0) THEN gestation_poa_weeks || ' weeks ' || gestation_poa_days || ' days' ELSE '' END AS gestation_poa, DECODE (delivery_miscarrage_type, 'D', TO_CHAR (delivery_miscarrage_date, 'DD/MM/YYYY'), '', '' ) AS delivery_date, DECODE (delivery_miscarrage_type, 'M', TO_CHAR (delivery_miscarrage_date, 'DD/MM/YYYY'), '', '' ) AS miscarriage_date, remarks, DECODE (event_status, 'A', 'Active', 'C', 'Close', 'AC', 'Auto Close' ) event_status FROM ca_mens_his_trans_dtl WHERE event = 'L' AND patient_id = ? AND facility_id = ? ");
             	else if(result_sub_category.equals("USOD"))
             	 	sql.append("SELECT ROWID AS row_id, CASE WHEN scan_gestation_weeks IS NOT NULL AND scan_gestation_days IS NOT NULL THEN scan_gestation_weeks || ' weeks ' || scan_gestation_days || ' days' ELSE '' END AS scan_gestation, TO_CHAR (unsure_of_date, 'DD/MM/YYYY') AS lmp, TO_CHAR (redd, 'DD/MM/YYYY') AS redd, CASE WHEN gestation_pog_weeks IS NOT NULL AND gestation_pog_days IS NOT NULL AND (gestation_pog_weeks <> 0 OR gestation_pog_days <> 0) THEN gestation_pog_weeks || ' weeks ' || gestation_pog_days || ' days' ELSE '' END AS gestation_pog, DECODE (delivery_miscarrage_type, 'D', TO_CHAR (delivery_miscarrage_date, 'DD/MM/YYYY'), '', '' ) AS delivery_date, DECODE (delivery_miscarrage_type, 'M', TO_CHAR (delivery_miscarrage_date, 'DD/MM/YYYY'), '', '' ) AS miscarriage_date, remarks, DECODE (event_status, 'A', 'Active', 'C', 'Close', 'AC', 'Auto Close' ) event_status FROM ca_mens_his_trans_dtl WHERE event = 'U' AND patient_id = ? AND facility_id = ? ");
             	
             	if(!(p_from_date.equals("") && p_to_date.equals("")) && result_sub_category.equals("LMP"))
            	    sql.append("AND LAST_MENSTRUAL_PERIOD BETWEEN TO_DATE(NVL(?,'1/1/1900'),'DD/MM/YYYY') and TO_DATE(NVL(?,'1/1/2500'),'DD/MM/YYYY')+.9999 ");
             	
              	if(!(p_from_date.equals("") && p_to_date.equals("")) && result_sub_category.equals("USOD"))
            	    sql.append("AND UNSURE_OF_DATE BETWEEN TO_DATE(NVL(?,'1/1/1900'),'DD/MM/YYYY') and TO_DATE(NVL(?,'1/1/2500'),'DD/MM/YYYY')+.9999 ");
             	
             	sql.append("AND event_status in (?, ?, ?) ");
             	
             	if (order_by.equals("A") && result_sub_category.equals("LMP"))
             		sql.append("order by TO_DATE(LAST_MENSTRUAL_PERIOD, 'DD/MM/YYYY') ");
             	
             	if (order_by.equals("A") && result_sub_category.equals("USOD"))
             		sql.append("order by TO_DATE(UNSURE_OF_DATE, 'DD/MM/YYYY') ");
             	
            	if (order_by.equals("D") && result_sub_category.equals("LMP"))
             		sql.append("order by TO_DATE(LAST_MENSTRUAL_PERIOD, 'DD/MM/YYYY') DESC");
            	
            	if (order_by.equals("D") && result_sub_category.equals("USOD"))
             		sql.append("order by TO_DATE(UNSURE_OF_DATE, 'DD/MM/YYYY') DESC");
            	

            	sqlMap.put("sqlData", sql.toString());
         		displayFields.add("ROW_ID");
         		
         		if(result_sub_category.equals("USOD"))
         			displayFields.add("SCAN_GESTATION");
         		
         		displayFields.add("LMP");
         		
         		if(result_sub_category.equals("LMP"))
         		    displayFields.add("EDD");
         		else if(result_sub_category.equals("USOD"))
         			displayFields.add("REDD");
         		
         		if(result_sub_category.equals("LMP"))
         		    displayFields.add("GESTATION_POA");
         		else if(result_sub_category.equals("USOD"))
         			displayFields.add("GESTATION_POG");
         		
         		    displayFields.add("DELIVERY_DATE");
         		    displayFields.add("MISCARRIAGE_DATE");
         		    displayFields.add("REMARKS");
         		    displayFields.add("EVENT_STATUS");

         		    chkFields.add(patient_id);
         		    chkFields.add(facility_id);
         		
                if(!(p_from_date.equals("") && p_to_date.equals(""))){
                  chkFields.add(p_from_date);
                  chkFields.add(p_to_date); }
                
             	if(event_status_a.equals("A")){
             		 chkFields.add("A");
             	     }
             	else{
             		chkFields.add("");}


        	   if(event_status_c.equals("C"))
        			 chkFields.add("C");
            	else
            		chkFields.add("");
        	
         	if(event_status_ac.equals("AC"))
       		    chkFields.add("AC");
         	else
         		chkFields.add("");

         		funcMap.put("displayFields", displayFields);
         		funcMap.put("chkFields", chkFields);
        		
         		resultParam.put("sqlMap", sqlMap);
         		resultParam.put("funcMap", funcMap);
		
			    } catch (Exception e) {
			        e.printStackTrace();
			    } 
			    return resultParam;
			}//70704 Ends
		 
		 public  ArrayList menstHistPatListResult(HashMap allParam) throws Exception
			{
			    PreparedStatement pstmt = null;
			    ResultSet rs = null;
			    Connection con = null;
			    ArrayList resultData = new ArrayList();
			    ArrayList result = new ArrayList();
				try
				{
					con = getConnection();
					String facilityId 		= (String)allParam.get("facilityId");
					String locale 		= (String)allParam.get("locale");
					String locationType 		= (String)allParam.get("locationType");
					String locationDesc 		= (String)allParam.get("locationDesc");
					String locationCode		= (String)allParam.get("locationCode");
					String patientId 		= (String)allParam.get("patientId");
					String pract 		= (String)allParam.get("pract");
					String pract_code 		= (String)allParam.get("pract_code");
					String specialty 		= (String)allParam.get("specialty");
					String specialtyCode 		= (String)allParam.get("specialtyCode");
					String pFromDate 		= (String)allParam.get("pFromDate");
					String pToDate 		= (String)allParam.get("pToDate");
					String encounterSt 		= (String)allParam.get("encounterSt");
					String menstHisEvent 		= (String)allParam.get("menstHisEvent");
					String orderBy 		= (String)allParam.get("orderBy");
					String reOrder 		= (String)allParam.get("reOrder");
					
				 	StringBuffer sql = new StringBuffer(" ");

					sql.append("select patient_id,patient_name,patient_class,age,sex, location_short_desc,attend_practitioner_id, specialty_short_desc, attend_practitioner_id, practitioner_name, max(visit_adm_date_time) visit_adm_date_time,discharge_date_time,deceased_yn,pat_class_key, episode_id,encounter_id from (SELECT a.patient_id, a.patient_name, DECODE (b.patient_class, 'IP', 'Inpatient', 'OP', 'Outpatient', 'EM', 'Emergency', 'DC', 'Daycare', '' ) patient_class, ca_get_age_in_hrs (a.date_of_birth, a.deceased_date) age, a.sex, CASE WHEN b.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit (?, b.assign_care_locn_code, ?, '2' ) WHEN b.patient_class IN ('OP', 'EM') THEN op_get_desc.op_clinic (?, b.assign_care_locn_code, ?, '2') ELSE NULL END location_short_desc, am_get_desc.am_speciality (b.specialty_code, ?, '2' ) specialty_short_desc, b.attend_practitioner_id, am_get_desc.am_practitioner (b.attend_practitioner_id, ?, '1' ) practitioner_name, TO_CHAR (b.visit_adm_date_time, 'DD/MM/YYYY HH24:MI' ) AS visit_adm_date_time, TO_CHAR (b.discharge_date_time, 'DD/MM/YYYY HH24:MI' ) AS discharge_date_time, a.deceased_yn, b.episode_id, b.patient_class pat_class_key, b.encounter_id FROM mp_patient a, pr_encounter b, ca_mens_his_trans_dtl c WHERE a.patient_id = b.patient_id AND a.patient_id = c.patient_id AND b.patient_id = c.patient_id AND b.visit_adm_date_time = ( SELECT MAX(visit_adm_date_time) FROM pr_encounter WHERE patient_id = c.patient_id AND facility_id = ? ) AND b.facility_id = ? AND c.event_status != 'E' ");

						if(!(locationType.equals("Z")) && !locationType.equals(""))
							sql.append("AND b.patient_class = ? ");

					 	if(!(locationType.equals("Z")) && !locationDesc.equals(""))
							sql.append("AND b.assign_care_locn_code = ? ");

					    if(!patientId.equals(""))
							sql.append("AND a.patient_id = ? ");

				 	    if(!pract.equals(""))
					        sql.append("AND b.attend_practitioner_id = ? ");

				 	    if(!specialty.equals(""))
						        sql.append("AND b.specialty_code = ? ");

		 		if(!(pFromDate.equals("") && pToDate.equals(""))){
				    	    sql.append("AND b.visit_adm_date_time BETWEEN TO_DATE(NVL(?,'1/1/1900'),'DD/MM/YYYY') and TO_DATE(NVL(?,'1/1/2500'),'DD/MM/YYYY')+.9999 ");
				 		}

				 		if(!encounterSt.equals("Z")){
				 			if(encounterSt.equals("A"))
				 				sql.append("AND discharge_date_time is null ");
				 			else if(encounterSt.equals("I")){
				 	 			sql.append(" AND discharge_date_time is not null ");
				 	 			}
				 		} 
				 		
				 	 		 if(!menstHisEvent.equals("Z")){
				 			if(menstHisEvent.equals("A"))
				    	     sql.append("AND c.event_status = 'A'  ");
				 			else if(menstHisEvent.equals("C"))
				 			 sql.append("AND c.event_status in ('C', 'AC') ");
				 		    }  

				 	 		sql.append(" ) group by patient_id,patient_name,patient_class,age,sex,location_short_desc,attend_practitioner_id, specialty_short_desc,attend_practitioner_id, practitioner_name,visit_adm_date_time,discharge_date_time,deceased_yn,pat_class_key,episode_id,encounter_id ");

				 	 		 
				 		String desc="";
						if(reOrder.equals("2"))
						{
							desc=" desc";
						}
						if(orderBy.equals("VD"))
						{
							sql.append(" Order By visit_adm_date_time  ");
							sql.append(desc);
						}
						else if(orderBy.equals("PID"))
						{
							sql.append(" Order By patient_id ");
							sql.append(desc);
						}
						else if(orderBy.equals("PN"))
						{
							sql.append(" Order By patient_name ");
							sql.append(desc);
						}
						else if(orderBy.equals("AGE"))
						{
							sql.append(" Order By age ");
							sql.append(desc);
						}
						else if(orderBy.equals("SEX"))
						{
							sql.append(" Order By sex ");
							sql.append(desc);
						}
						
						else if(orderBy.equals("PC"))
						{
							sql.append(" Order By patient_class ");
							sql.append(desc);
						}
						
						else if(orderBy.equals("LC"))
						{
							sql.append(" Order By location_short_desc ");
							sql.append(desc);
						}
						
						else if(orderBy.equals("SP"))
						{
							sql.append(" Order By specialty_short_desc ");
							sql.append(desc);
						}
						
						else if(orderBy.equals("AP"))
						{
							sql.append(" Order By practitioner_name ");
							sql.append(desc);
						}
						
						else if(orderBy.equals("CD"))
						{
							sql.append(" Order By discharge_date_time ");
							sql.append(desc);
						}
						
						else if(orderBy.equals("ENI"))
						{
							sql.append(" Order By encounter_id ");
							sql.append(desc);
						}


				        pstmt = con.prepareStatement(sql.toString());
				        int count=0;
				        pstmt.setString(++count, facilityId);
				        pstmt.setString(++count, locale);
				        pstmt.setString(++count, facilityId);
				        pstmt.setString(++count, locale);
				        pstmt.setString(++count, locale);
				        pstmt.setString(++count, locale);
				        pstmt.setString(++count, facilityId);
				        pstmt.setString(++count, facilityId);

							if(!(locationType.equals("Z")) && !locationType.equals(""))
								 pstmt.setString(++count, locationType);
							   
							
						 	if(!(locationType.equals("Z")) && !locationDesc.equals(""))
						 		 pstmt.setString(++count, locationCode);
						
						    if(!patientId.equals(""))
						    	 pstmt.setString(++count, patientId);
						
					 	    if(!pract.equals(""))
					 	    	 pstmt.setString(++count, pract_code);
					  		
					 	    if(!specialty.equals(""))
					 	    	 pstmt.setString(++count, specialtyCode);


			 		 if(!(pFromDate.equals("") && pToDate.equals(""))){
			 			pstmt.setString(++count, pFromDate);
			 			pstmt.setString(++count, pToDate);
					 		}
				        
				        rs = pstmt.executeQuery();
				        
				        while (rs != null && rs.next()) {
				            String[] record = new String[15];
				            record[0]=rs.getString("PATIENT_ID") == null ? "" : rs.getString("PATIENT_ID");
				        	record[1] = rs.getString("PATIENT_NAME") == null ? "" : rs.getString("PATIENT_NAME");
				        	record[2] = rs.getString("PATIENT_CLASS") == null ? "" : rs.getString("PATIENT_CLASS");
				        	record[3] = rs.getString("AGE") == null ? "" : rs.getString("AGE");
				        	record[4] = rs.getString("SEX") == null ? "" : rs.getString("SEX");
				        	record[5] = rs.getString("LOCATION_SHORT_DESC") == null ? "" : rs.getString("LOCATION_SHORT_DESC");
				        	record[6] = rs.getString("SPECIALTY_SHORT_DESC") == null ? "" : rs.getString("SPECIALTY_SHORT_DESC");
				        	record[7] = rs.getString("ATTEND_PRACTITIONER_ID") == null ? "" : rs.getString("ATTEND_PRACTITIONER_ID");
				        	record[8] = rs.getString("PRACTITIONER_NAME") == null ? "" : rs.getString("PRACTITIONER_NAME");
				        	record[9] = rs.getString("VISIT_ADM_DATE_TIME") == null ? "" : rs.getString("VISIT_ADM_DATE_TIME");
				        	record[10] = rs.getString("DISCHARGE_DATE_TIME") == null ? "" : rs.getString("DISCHARGE_DATE_TIME");
				        	record[11] = rs.getString("DECEASED_YN") == null ? "" : rs.getString("DECEASED_YN");
				        	record[12] = rs.getString("EPISODE_ID") == null ? "" : rs.getString("EPISODE_ID");
				        	record[13] = rs.getString("PAT_CLASS_KEY") == null ? "" : rs.getString("PAT_CLASS_KEY");
				        	record[14] = rs.getString("ENCOUNTER_ID") == null ? "" : rs.getString("ENCOUNTER_ID");
				        	result.add(record);

				        }

				}
				catch(Exception ex){
					ex.getMessage();
					ex.printStackTrace();
				}
					 finally {
				        closeResultSet(rs);
				        closeStatement(pstmt);
				        closeConnection(con);
				    }
			return result;

			}
			
		public ArrayList getMenstrualHistoryAuditTrailDetails(String patient_id, String srl_no,String selectedValue) throws Exception {
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    Connection con = null;
		    ArrayList getAuditDetails = new ArrayList();

		    try {
		        String menstrualHistoryAuditQuery = "	SELECT field_name, CASE WHEN REGEXP_LIKE (previous_value, '^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$' ) THEN TO_CHAR (TO_DATE (previous_value, 'YYYY-MM-DD HH24:MI:SS'), 'DD/MM/YYYY' ) ELSE previous_value END AS previous_value, amend_by, TO_CHAR (amend_date, 'DD/MM/YYYY HH24:MI') AS amend_date, modified_remarks FROM ca_mens_his_trans_dtl_audit WHERE patient_id = ? AND srl_no = ? AND event = ?  ORDER BY amend_date DESC";

		        con = getConnection();  // Assume this method establishes the connection
		        pstmt = con.prepareStatement(menstrualHistoryAuditQuery);
		        pstmt.setString(1, patient_id); // Set the parameter
		        pstmt.setString(2, srl_no); // Set the parameter
		        pstmt.setString(3, selectedValue); // Set the parameter
		        rs = pstmt.executeQuery();

		        while (rs != null && rs.next()) {
		            String[] record = new String[5];
		            record[0] = rs.getString("field_name");
		            record[1] = rs.getString("previous_value");
		            record[2] = rs.getString("amend_by");
		            record[3] = rs.getString("amend_date");
		            record[4] = rs.getString("modified_remarks") ;
		      	getAuditDetails.add(record);
		      	
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        throw e; // Rethrow the exception for handling at a higher level
		    } finally {
		        closeResultSet(rs);
		        closeStatement(pstmt);
		        closeConnection(con);
		    }
		    return getAuditDetails;
		}
		
		public ArrayList  getPatientMenstrualErrorRemarks(String patient_id,String srl_no) throws Exception {
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    Connection con = null;
			ArrayList ResultDetail  =new ArrayList();


		    try {
		    	 String menstrualHistoryErrorQuery = "SELECT ERROR_REMARKS, MODIFIED_BY_ID, TO_CHAR(MODIFIED_DATE, 'DD/MM/YYYY') AS MODIFIED_DATE FROM ca_mens_his_trans_dtl WHERE patient_id = ? AND SRL_NO =?";
		        con = getConnection();
		        pstmt = con.prepareStatement(menstrualHistoryErrorQuery);
		        pstmt.setString(1, patient_id);
		        pstmt.setString(2, srl_no);
		        rs = pstmt.executeQuery();
		        
		        while (rs != null && rs.next()) {
		            String[] record = new String[3];
		            record[0] = rs.getString("ERROR_REMARKS") != null ? rs.getString("ERROR_REMARKS") : "";
		            record[1] = rs.getString("MODIFIED_BY_ID") != null ? rs.getString("MODIFIED_BY_ID") : "";
		            record[2] = rs.getString("MODIFIED_DATE") != null ? rs.getString("MODIFIED_DATE") : "";
		            ResultDetail.add(record);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        throw e;
		    } finally {
		        closeResultSet(rs);
		        closeStatement(pstmt);
		        closeConnection(con);
		    }
		    return ResultDetail;
		}

		public ArrayList  getPatientAvaliable(String patient_id,String facility_id) throws Exception {
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    Connection con = null;
			ArrayList ResultDetail  =new ArrayList();


		    try {
		    	 String menstrualHistoryPatientQuery = "SELECT patient_id, encounter_id, episode_id FROM (SELECT patient_id, encounter_id, episode_id, ROW_NUMBER() OVER (ORDER BY visit_adm_date_time DESC) AS rn FROM pr_encounter WHERE patient_id = ? AND ( ( patient_class IN ('IP', 'DC') AND adt_status NOT IN ('00', '09')) OR ( patient_class IN ('OP', 'EM') AND visit_status NOT IN ('01', '02', '99')) ) AND facility_id = ? ) WHERE rn = 1";
		        con = getConnection();
		        pstmt = con.prepareStatement(menstrualHistoryPatientQuery);
		        pstmt.setString(1, patient_id);
		        pstmt.setString(2, facility_id);

		        rs = pstmt.executeQuery();
		        
		        while (rs != null && rs.next()) {
		            String[] record = new String[3];
		            record[0] = rs.getString("patient_id") != null ? rs.getString("patient_id") : "";
		            record[1] = rs.getString("encounter_id") != null ? rs.getString("encounter_id") : "";
		            record[2] = rs.getString("episode_id") != null ? rs.getString("episode_id") : "";
		            ResultDetail.add(record);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        throw e;
		    } finally {
		        closeResultSet(rs);
		        closeStatement(pstmt);
		        closeConnection(con);
		    }
		    return ResultDetail;
		}
		
		public int  getRestrictedPosition(String ca_practitioner_id,String facility_id) throws Exception {
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    Connection con = null;
			int restricted_Position=0;

		    try {
		         String 	default_sql = "SELECT COUNT(*) COUNTNUM FROM CA_CNTRL_SPL_POSITION_BY_LOC A, AM_PRACTITIONER B WHERE PRACTITIONER_ID=? AND FACILITY_ID=? AND A.POSITION_CODE=B.POSITION_CODE AND A.PRACT_TYPE=B.PRACT_TYPE";
		        con = getConnection();
		        pstmt = con.prepareStatement(default_sql);
				pstmt.setString(1,ca_practitioner_id);
				pstmt.setString(2,facility_id);
		        rs = pstmt.executeQuery();
		        
		        while (rs != null && rs.next()) {
		    		restricted_Position =rs.getInt("COUNTNUM");
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        throw e;
		    } finally {
		        closeResultSet(rs);
		        closeStatement(pstmt);
		        closeConnection(con);
		    }
		    return restricted_Position;
		}

		public ArrayList  getPatientClass(String locale) throws Exception {
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    Connection con = null;
            ArrayList patClass  = new ArrayList();
		    try {
				 String  sql = "select PATIENT_CLASS, SHORT_DESC  from  am_patient_class_lang_vw where LANGUAGE_ID=? and  patient_class in ('OP','IP','EM','DC') order by 2 ";
		        con = getConnection();
		        pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
		        rs = pstmt.executeQuery();
		        while(rs != null && rs.next()){
		        	String[] records = new String[2];
		        	records[0] = rs.getString("PATIENT_CLASS");	        
		            records[1] = rs.getString("SHORT_DESC");	        
		        	patClass.add(records);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        throw e;
		    } finally {
		        closeResultSet(rs);
		        closeStatement(pstmt);
		        closeConnection(con);
		    }
		    return patClass;
		}
		
		public int getAuditTrailCount(String patient_id, String srl_no, String selectedValue) throws Exception {
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    Connection con = null;
		    int count = 0;

		    try {
		        String menstrualHistoryAuditQuery = "SELECT count(*) as count FROM ca_mens_his_trans_dtl_audit WHERE patient_id = ? AND srl_no = ? AND event = ?";

		        con = getConnection();  // Assume this method establishes the connection
		        pstmt = con.prepareStatement(menstrualHistoryAuditQuery);
		        pstmt.setString(1, patient_id); // Set the parameter
		        pstmt.setString(2, srl_no); // Set the parameter
		        pstmt.setString(3, selectedValue); // Set the parameter
		        rs = pstmt.executeQuery();

		        if (rs != null && rs.next()) {
		            count = rs.getInt("count"); // Retrieve the count from the result set
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        throw e; // Rethrow the exception for handling at a higher level
		    } finally {
		        closeResultSet(rs);
		        closeStatement(pstmt);
		        closeConnection(con);
		    }
		    return count; // Return the count
		}





public ArrayList  getPatientBottomValidation(String patient_id) throws Exception {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Connection con = null;
	ArrayList ResultDetail  =new ArrayList();


    try {
    	String menstrualHistoryQuery = "SELECT patient_id, event, TO_CHAR (last_menstrual_period, 'dd/mm/yyyy' ) AS last_menstrual_period, TO_CHAR (edd, 'dd/mm/yyyy') AS edd, CASE WHEN gestation_poa_weeks IS NOT NULL AND gestation_poa_days IS NOT NULL AND (gestation_poa_weeks <> 0 OR gestation_poa_days <> 0) THEN gestation_poa_weeks || ' weeks ' || gestation_poa_days || ' days' ELSE '' END AS gestation_poa, CASE WHEN scan_gestation_weeks IS NOT NULL AND scan_gestation_days IS NOT NULL THEN scan_gestation_weeks || ' weeks ' || scan_gestation_days || ' days' ELSE '' END AS scan_gestation, TO_CHAR (unsure_of_date, 'dd/mm/yyyy') AS unsure_of_date, TO_CHAR (redd, 'dd/mm/yyyy') AS redd, CASE WHEN gestation_pog_weeks IS NOT NULL AND gestation_pog_days IS NOT NULL AND (gestation_pog_weeks <> 0 OR gestation_pog_days <> 0) THEN gestation_pog_weeks || ' weeks ' || gestation_pog_days || ' days' ELSE '' END AS gestation_pog, delivery_miscarrage_type, TO_CHAR (delivery_miscarrage_date, 'dd/mm/yyyy' ) AS delivery_miscarrage_date, remarks, modified_remarks, srl_no, event_status, error_remarks, added_date, CASE WHEN cm.event_status = 'C' AND cm.delivery_miscarrage_date = (SELECT MAX (delivery_miscarrage_date) FROM ca_mens_his_trans_dtl WHERE patient_id = cm.patient_id AND event_status = 'C') AND NOT EXISTS ( SELECT 1 FROM mp_birth_register bm WHERE bm.mother_patient_id = cm.patient_id AND bm.time_of_birth IS NOT NULL AND bm.finalized_yn = 'Y' AND TO_DATE (TO_CHAR (bm.time_of_birth, 'dd/mm/yyyy'), 'dd/mm/yyyy' ) = TO_DATE (TO_CHAR (cm.delivery_miscarrage_date, 'dd/mm/yyyy' ), 'dd/mm/yyyy' )) THEN 'E' ELSE '' END AS e_button_display, event_remarks FROM ca_mens_his_trans_dtl cm WHERE cm.patient_id = ? AND  cm.EVENT_STATUS !='E'  ORDER BY cm.added_date ASC";
    	//String menstrualHistoryQuery = "SELECT patient_id, event, TO_CHAR (last_menstrual_period, 'dd/mm/yyyy') AS last_menstrual_period, TO_CHAR (edd, 'dd/mm/yyyy') AS edd, CASE WHEN cm.event_status = 'A' AND delivery_miscarrage_date IS NULL AND delivery_miscarrage_type IS NULL AND last_menstrual_period IS NOT NULL THEN TRUNC ((SYSDATE - last_menstrual_period) / 7) || ' weeks ' || MOD (TRUNC (SYSDATE - last_menstrual_period), 7) || ' days' WHEN gestation_poa_weeks IS NOT NULL AND gestation_poa_days IS NOT NULL AND (gestation_poa_weeks <> 0 OR gestation_poa_days <> 0) THEN gestation_poa_weeks || 'weeks ' || gestation_poa_days || 'days' ELSE '' END AS gestation_poa, CASE WHEN scan_gestation_weeks IS NOT NULL AND scan_gestation_days IS NOT NULL THEN scan_gestation_weeks || 'weeks ' || scan_gestation_days || 'days' ELSE '' END AS scan_gestation, TO_CHAR (unsure_of_date, 'dd/mm/yyyy') AS unsure_of_date, TO_CHAR (redd, 'dd/mm/yyyy') AS redd, CASE WHEN cm.event_status = 'A' AND delivery_miscarrage_date IS NULL AND delivery_miscarrage_type IS NULL AND unsure_of_date IS NOT NULL THEN TRUNC ((SYSDATE - unsure_of_date) / 7) || ' weeks ' || MOD (TRUNC (SYSDATE - unsure_of_date), 7) || ' days' WHEN gestation_pog_weeks IS NOT NULL AND gestation_pog_days IS NOT NULL AND (gestation_pog_weeks <> 0 OR gestation_pog_days <> 0) THEN gestation_pog_weeks || 'weeks ' || gestation_pog_days || 'days' ELSE '' END AS gestation_pog, delivery_miscarrage_type, TO_CHAR (delivery_miscarrage_date, 'dd/mm/yyyy' ) AS delivery_miscarrage_date, remarks, modified_remarks, srl_no, event_status, error_remarks,added_date, CASE WHEN (SELECT time_of_birth FROM mp_birth_register bm WHERE bm.patient_id = cm.patient_id AND bm.time_of_birth IS NULL) IS NULL AND cm.event_status = 'C' AND cm.added_date = (SELECT MAX (added_date) FROM ca_mens_his_trans_dtl WHERE patient_id = cm.patient_id) THEN 'E' ELSE '' END AS e_button_display, event_remarks FROM ca_mens_his_trans_dtl cm WHERE cm.patient_id = ? AND cm.facility_id = ?";
    	con = getConnection();
        pstmt = con.prepareStatement(menstrualHistoryQuery);
        pstmt.setString(1, patient_id);
     //   pstmt.setString(2, facility_id);


        rs = pstmt.executeQuery();
        
        while (rs != null && rs.next()) {
            String[] record = new String[19];
            record[0] = rs.getString("PATIENT_ID");
            record[1] = rs.getString("EVENT");
            record[2] = rs.getString("LAST_MENSTRUAL_PERIOD") != null ? rs.getString("LAST_MENSTRUAL_PERIOD") : "N/A ";
            record[3] = rs.getString("EDD") != null ? rs.getString("EDD") : "N/A";
            record[4] = rs.getString("GESTATION_POA") != null ? rs.getString("GESTATION_POA") : "N/A";
            record[5] = rs.getString("SCAN_GESTATION") != null ? rs.getString("SCAN_GESTATION") : "N/A";
            record[6] = rs.getString("UNSURE_OF_DATE") != null ? rs.getString("UNSURE_OF_DATE") : "N/A ";
            record[7] = rs.getString("REDD") != null ? rs.getString("REDD") : "N/A ";
            record[8] = rs.getString("GESTATION_POG") != null ? rs.getString("GESTATION_POG") : "N/A ";
            record[9] = rs.getString("DELIVERY_MISCARRAGE_TYPE") != null ? rs.getString("DELIVERY_MISCARRAGE_TYPE") : "";
            record[10] = rs.getString("DELIVERY_MISCARRAGE_DATE") != null ? rs.getString("DELIVERY_MISCARRAGE_DATE") : "";
            record[11] = rs.getString("REMARKS") != null ? rs.getString("REMARKS") : "";
            record[12] = rs.getString("MODIFIED_REMARKS") != null ? rs.getString("MODIFIED_REMARKS") : "";
            record[13] = rs.getString("SRL_NO") ;
            record[14] = rs.getString("EVENT_STATUS") ;
            record[15] = rs.getString("ERROR_REMARKS") != null ? rs.getString("ERROR_REMARKS") : "";
            record[16] = rs.getString("ADDED_DATE") != null ? rs.getString("ADDED_DATE") : "";
            record[17] = rs.getString("e_button_display") != null ? rs.getString("e_button_display") : "";
            record[18] = rs.getString("event_remarks") != null ? rs.getString("event_remarks") : "";

            ResultDetail.add(record);
        }
    } catch (Exception e) {
        e.printStackTrace();
        throw e;
    } finally {
        closeResultSet(rs);
        closeStatement(pstmt);
        closeConnection(con);
    }
    return ResultDetail;
}


public ArrayList  getPatientPASValidation(String patient_id) throws Exception {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Connection con = null;
	ArrayList ResultDetail  =new ArrayList();


    try {
    	String menstrualHistoryQuery = "SELECT patient_id, event, TO_CHAR (last_menstrual_period, 'dd/mm/yyyy' ) AS last_menstrual_period, TO_CHAR (edd, 'dd/mm/yyyy') AS edd, CASE WHEN gestation_poa_weeks IS NOT NULL AND gestation_poa_days IS NOT NULL AND (gestation_poa_weeks <> 0 OR gestation_poa_days <> 0) THEN gestation_poa_weeks || ' weeks ' || gestation_poa_days || ' days' ELSE '' END AS gestation_poa, CASE WHEN scan_gestation_weeks IS NOT NULL AND scan_gestation_days IS NOT NULL THEN scan_gestation_weeks || ' weeks ' || scan_gestation_days || ' days' ELSE '' END AS scan_gestation, TO_CHAR (unsure_of_date, 'dd/mm/yyyy') AS unsure_of_date, TO_CHAR (redd, 'dd/mm/yyyy') AS redd, CASE WHEN gestation_pog_weeks IS NOT NULL AND gestation_pog_days IS NOT NULL AND (gestation_pog_weeks <> 0 OR gestation_pog_days <> 0) THEN gestation_pog_weeks || ' weeks ' || gestation_pog_days || ' days' ELSE '' END AS gestation_pog, delivery_miscarrage_type, TO_CHAR (delivery_miscarrage_date, 'dd/mm/yyyy' ) AS delivery_miscarrage_date, remarks, modified_remarks, srl_no, event_status, error_remarks, added_date, CASE WHEN cm.event_status = 'C' AND cm.delivery_miscarrage_date = (SELECT MAX (delivery_miscarrage_date) FROM ca_mens_his_trans_dtl WHERE patient_id = cm.patient_id AND event_status = 'C') AND NOT EXISTS ( SELECT 1 FROM mp_birth_register bm WHERE bm.mother_patient_id = cm.patient_id AND bm.time_of_birth IS NOT NULL AND bm.finalized_yn = 'Y' AND TO_DATE (TO_CHAR (bm.time_of_birth, 'dd/mm/yyyy'), 'dd/mm/yyyy' ) = TO_DATE (TO_CHAR (cm.delivery_miscarrage_date, 'dd/mm/yyyy' ), 'dd/mm/yyyy' )) THEN 'E' ELSE '' END AS e_button_display, event_remarks FROM ca_mens_his_trans_dtl cm WHERE cm.patient_id = ?  AND delivery_miscarrage_date IS NOT NULL ORDER BY cm.added_date ASC";
    	//String menstrualHistoryQuery = "SELECT patient_id, event, TO_CHAR (last_menstrual_period, 'dd/mm/yyyy') AS last_menstrual_period, TO_CHAR (edd, 'dd/mm/yyyy') AS edd, CASE WHEN cm.event_status = 'A' AND delivery_miscarrage_date IS NULL AND delivery_miscarrage_type IS NULL AND last_menstrual_period IS NOT NULL THEN TRUNC ((SYSDATE - last_menstrual_period) / 7) || ' weeks ' || MOD (TRUNC (SYSDATE - last_menstrual_period), 7) || ' days' WHEN gestation_poa_weeks IS NOT NULL AND gestation_poa_days IS NOT NULL AND (gestation_poa_weeks <> 0 OR gestation_poa_days <> 0) THEN gestation_poa_weeks || 'weeks ' || gestation_poa_days || 'days' ELSE '' END AS gestation_poa, CASE WHEN scan_gestation_weeks IS NOT NULL AND scan_gestation_days IS NOT NULL THEN scan_gestation_weeks || 'weeks ' || scan_gestation_days || 'days' ELSE '' END AS scan_gestation, TO_CHAR (unsure_of_date, 'dd/mm/yyyy') AS unsure_of_date, TO_CHAR (redd, 'dd/mm/yyyy') AS redd, CASE WHEN cm.event_status = 'A' AND delivery_miscarrage_date IS NULL AND delivery_miscarrage_type IS NULL AND unsure_of_date IS NOT NULL THEN TRUNC ((SYSDATE - unsure_of_date) / 7) || ' weeks ' || MOD (TRUNC (SYSDATE - unsure_of_date), 7) || ' days' WHEN gestation_pog_weeks IS NOT NULL AND gestation_pog_days IS NOT NULL AND (gestation_pog_weeks <> 0 OR gestation_pog_days <> 0) THEN gestation_pog_weeks || 'weeks ' || gestation_pog_days || 'days' ELSE '' END AS gestation_pog, delivery_miscarrage_type, TO_CHAR (delivery_miscarrage_date, 'dd/mm/yyyy' ) AS delivery_miscarrage_date, remarks, modified_remarks, srl_no, event_status, error_remarks,added_date, CASE WHEN (SELECT time_of_birth FROM mp_birth_register bm WHERE bm.patient_id = cm.patient_id AND bm.time_of_birth IS NULL) IS NULL AND cm.event_status = 'C' AND cm.added_date = (SELECT MAX (added_date) FROM ca_mens_his_trans_dtl WHERE patient_id = cm.patient_id) THEN 'E' ELSE '' END AS e_button_display, event_remarks FROM ca_mens_his_trans_dtl cm WHERE cm.patient_id = ? AND cm.facility_id = ?";
    	con = getConnection();
        pstmt = con.prepareStatement(menstrualHistoryQuery);
        pstmt.setString(1, patient_id);
       // pstmt.setString(2, facility_id);


        rs = pstmt.executeQuery();
        
        while (rs != null && rs.next()) {
            String[] record = new String[19];
            record[0] = rs.getString("PATIENT_ID");
            record[1] = rs.getString("EVENT");
            record[2] = rs.getString("LAST_MENSTRUAL_PERIOD") != null ? rs.getString("LAST_MENSTRUAL_PERIOD") : "N/A ";
            record[3] = rs.getString("EDD") != null ? rs.getString("EDD") : "N/A";
            record[4] = rs.getString("GESTATION_POA") != null ? rs.getString("GESTATION_POA") : "N/A";
            record[5] = rs.getString("SCAN_GESTATION") != null ? rs.getString("SCAN_GESTATION") : "N/A";
            record[6] = rs.getString("UNSURE_OF_DATE") != null ? rs.getString("UNSURE_OF_DATE") : "N/A ";
            record[7] = rs.getString("REDD") != null ? rs.getString("REDD") : "N/A ";
            record[8] = rs.getString("GESTATION_POG") != null ? rs.getString("GESTATION_POG") : "N/A ";
            record[9] = rs.getString("DELIVERY_MISCARRAGE_TYPE") != null ? rs.getString("DELIVERY_MISCARRAGE_TYPE") : "";
            record[10] = rs.getString("DELIVERY_MISCARRAGE_DATE") != null ? rs.getString("DELIVERY_MISCARRAGE_DATE") : "";
            record[11] = rs.getString("REMARKS") != null ? rs.getString("REMARKS") : "";
            record[12] = rs.getString("MODIFIED_REMARKS") != null ? rs.getString("MODIFIED_REMARKS") : "";
            record[13] = rs.getString("SRL_NO") ;
            record[14] = rs.getString("EVENT_STATUS") ;
            record[15] = rs.getString("ERROR_REMARKS") != null ? rs.getString("ERROR_REMARKS") : "";
            record[16] = rs.getString("ADDED_DATE") != null ? rs.getString("ADDED_DATE") : "";
            record[17] = rs.getString("e_button_display") != null ? rs.getString("e_button_display") : "";
            record[18] = rs.getString("event_remarks") != null ? rs.getString("event_remarks") : "";

            ResultDetail.add(record);
        }
    } catch (Exception e) {
        e.printStackTrace();
        throw e;
    } finally {
        closeResultSet(rs);
        closeStatement(pstmt);
        closeConnection(con);
    }
    return ResultDetail;
}



public ArrayList  getPatientActiveValidation(String patient_id) throws Exception {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Connection con = null;
	ArrayList ResultDetail  =new ArrayList();


    try {
    	String menstrualHistoryQuery = "SELECT patient_id, event, TO_CHAR (last_menstrual_period, 'dd/mm/yyyy' ) AS last_menstrual_period, TO_CHAR (edd, 'dd/mm/yyyy') AS edd, CASE WHEN gestation_poa_weeks IS NOT NULL AND gestation_poa_days IS NOT NULL AND (gestation_poa_weeks <> 0 OR gestation_poa_days <> 0) THEN gestation_poa_weeks || ' weeks ' || gestation_poa_days || ' days' ELSE '' END AS gestation_poa, CASE WHEN scan_gestation_weeks IS NOT NULL AND scan_gestation_days IS NOT NULL THEN scan_gestation_weeks || ' weeks ' || scan_gestation_days || ' days' ELSE '' END AS scan_gestation, TO_CHAR (unsure_of_date, 'dd/mm/yyyy') AS unsure_of_date, TO_CHAR (redd, 'dd/mm/yyyy') AS redd, CASE WHEN gestation_pog_weeks IS NOT NULL AND gestation_pog_days IS NOT NULL AND (gestation_pog_weeks <> 0 OR gestation_pog_days <> 0) THEN gestation_pog_weeks || ' weeks ' || gestation_pog_days || ' days' ELSE '' END AS gestation_pog, delivery_miscarrage_type, TO_CHAR (delivery_miscarrage_date, 'dd/mm/yyyy' ) AS delivery_miscarrage_date, remarks, modified_remarks, srl_no, event_status, error_remarks, added_date, CASE WHEN cm.event_status = 'C' AND cm.delivery_miscarrage_date = (SELECT MAX (delivery_miscarrage_date) FROM ca_mens_his_trans_dtl WHERE patient_id = cm.patient_id AND event_status = 'C') AND NOT EXISTS ( SELECT 1 FROM mp_birth_register bm WHERE bm.mother_patient_id = cm.patient_id AND bm.time_of_birth IS NOT NULL AND bm.finalized_yn = 'Y' AND TO_DATE (TO_CHAR (bm.time_of_birth, 'dd/mm/yyyy'), 'dd/mm/yyyy' ) = TO_DATE (TO_CHAR (cm.delivery_miscarrage_date, 'dd/mm/yyyy' ), 'dd/mm/yyyy' )) THEN 'E' ELSE '' END AS e_button_display, event_remarks FROM ca_mens_his_trans_dtl cm WHERE cm.patient_id = ?   AND cm.event_status NOT IN ('E', 'A')  AND delivery_miscarrage_date IS NOT NULL ORDER BY cm.added_date ASC";
    	//String menstrualHistoryQuery = "SELECT patient_id, event, TO_CHAR (last_menstrual_period, 'dd/mm/yyyy') AS last_menstrual_period, TO_CHAR (edd, 'dd/mm/yyyy') AS edd, CASE WHEN cm.event_status = 'A' AND delivery_miscarrage_date IS NULL AND delivery_miscarrage_type IS NULL AND last_menstrual_period IS NOT NULL THEN TRUNC ((SYSDATE - last_menstrual_period) / 7) || ' weeks ' || MOD (TRUNC (SYSDATE - last_menstrual_period), 7) || ' days' WHEN gestation_poa_weeks IS NOT NULL AND gestation_poa_days IS NOT NULL AND (gestation_poa_weeks <> 0 OR gestation_poa_days <> 0) THEN gestation_poa_weeks || 'weeks ' || gestation_poa_days || 'days' ELSE '' END AS gestation_poa, CASE WHEN scan_gestation_weeks IS NOT NULL AND scan_gestation_days IS NOT NULL THEN scan_gestation_weeks || 'weeks ' || scan_gestation_days || 'days' ELSE '' END AS scan_gestation, TO_CHAR (unsure_of_date, 'dd/mm/yyyy') AS unsure_of_date, TO_CHAR (redd, 'dd/mm/yyyy') AS redd, CASE WHEN cm.event_status = 'A' AND delivery_miscarrage_date IS NULL AND delivery_miscarrage_type IS NULL AND unsure_of_date IS NOT NULL THEN TRUNC ((SYSDATE - unsure_of_date) / 7) || ' weeks ' || MOD (TRUNC (SYSDATE - unsure_of_date), 7) || ' days' WHEN gestation_pog_weeks IS NOT NULL AND gestation_pog_days IS NOT NULL AND (gestation_pog_weeks <> 0 OR gestation_pog_days <> 0) THEN gestation_pog_weeks || 'weeks ' || gestation_pog_days || 'days' ELSE '' END AS gestation_pog, delivery_miscarrage_type, TO_CHAR (delivery_miscarrage_date, 'dd/mm/yyyy' ) AS delivery_miscarrage_date, remarks, modified_remarks, srl_no, event_status, error_remarks,added_date, CASE WHEN (SELECT time_of_birth FROM mp_birth_register bm WHERE bm.patient_id = cm.patient_id AND bm.time_of_birth IS NULL) IS NULL AND cm.event_status = 'C' AND cm.added_date = (SELECT MAX (added_date) FROM ca_mens_his_trans_dtl WHERE patient_id = cm.patient_id) THEN 'E' ELSE '' END AS e_button_display, event_remarks FROM ca_mens_his_trans_dtl cm WHERE cm.patient_id = ? AND cm.facility_id = ?";
    	con = getConnection();
        pstmt = con.prepareStatement(menstrualHistoryQuery);
        pstmt.setString(1, patient_id);
       // pstmt.setString(2, facility_id);


        rs = pstmt.executeQuery();
        
        while (rs != null && rs.next()) {
            String[] record = new String[19];
            record[0] = rs.getString("PATIENT_ID");
            record[1] = rs.getString("EVENT");
            record[2] = rs.getString("LAST_MENSTRUAL_PERIOD") != null ? rs.getString("LAST_MENSTRUAL_PERIOD") : "N/A ";
            record[3] = rs.getString("EDD") != null ? rs.getString("EDD") : "N/A";
            record[4] = rs.getString("GESTATION_POA") != null ? rs.getString("GESTATION_POA") : "N/A";
            record[5] = rs.getString("SCAN_GESTATION") != null ? rs.getString("SCAN_GESTATION") : "N/A";
            record[6] = rs.getString("UNSURE_OF_DATE") != null ? rs.getString("UNSURE_OF_DATE") : "N/A ";
            record[7] = rs.getString("REDD") != null ? rs.getString("REDD") : "N/A ";
            record[8] = rs.getString("GESTATION_POG") != null ? rs.getString("GESTATION_POG") : "N/A ";
            record[9] = rs.getString("DELIVERY_MISCARRAGE_TYPE") != null ? rs.getString("DELIVERY_MISCARRAGE_TYPE") : "";
            record[10] = rs.getString("DELIVERY_MISCARRAGE_DATE") != null ? rs.getString("DELIVERY_MISCARRAGE_DATE") : "";
            record[11] = rs.getString("REMARKS") != null ? rs.getString("REMARKS") : "";
            record[12] = rs.getString("MODIFIED_REMARKS") != null ? rs.getString("MODIFIED_REMARKS") : "";
            record[13] = rs.getString("SRL_NO") ;
            record[14] = rs.getString("EVENT_STATUS") ;
            record[15] = rs.getString("ERROR_REMARKS") != null ? rs.getString("ERROR_REMARKS") : "";
            record[16] = rs.getString("ADDED_DATE") != null ? rs.getString("ADDED_DATE") : "";
            record[17] = rs.getString("e_button_display") != null ? rs.getString("e_button_display") : "";
            record[18] = rs.getString("event_remarks") != null ? rs.getString("event_remarks") : "";

            ResultDetail.add(record);
        }
    } catch (Exception e) {
        e.printStackTrace();
        throw e;
    } finally {
        closeResultSet(rs);
        closeStatement(pstmt);
        closeConnection(con);
    }
    return ResultDetail;
}
}