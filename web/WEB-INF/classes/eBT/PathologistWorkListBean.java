/*

*/
package eBT;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import webbeans.eCommon.*;

import java.sql.*;
import java.io.*;



public class PathologistWorkListBean implements Serializable {


	
public ArrayList getOrderingFacilityId(String locale) throws Exception{	
	Connection connection = null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet = null ;
	ArrayList result=new ArrayList();
	try {
		connection = ConnectionManager.getConnection() ;
	
		pstmt = connection.prepareStatement("SELECT FACILITY_ID ,FACILITY_NAME  FROM  SM_FACILITY_PARAM_LANG_VW  WHERE STATUS ='E'AND LANGUAGE_ID= ? order by FACILITY_NAME") ;
		
		pstmt.setString(1,locale);

		resultSet = pstmt.executeQuery() ;
		while (resultSet.next()) {
			result.add(resultSet.getString("FACILITY_ID"));
			result.add(resultSet.getString("FACILITY_NAME"));
		}
	}catch ( Exception e ) {
		e.printStackTrace() ;
		result.add(e.toString());
	}finally{
		if(connection!=null)  ConnectionManager.returnConnection(connection); //Common-ICN-0045
		pstmt.close();
		resultSet.close();}
	return result;
}
	
public ArrayList getPathologistWorkList(String section_code,String patient_id,String specimen_number,String order_facility_name_search, String performing_facility_id_search, String ordering_pract_code_search, String reporting_facility_id_search, String fromDate_search,String toDate_search, String assigned_red_code_search, String lab_order_status) throws Exception{	
			
		ArrayList pathologistworklist	= new ArrayList();
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
		ResultSet resultSet 			= null;
		String sqlQuery = null;
		/* String a = null;
		String b = null;
		String c = null;
		String d = null;
		String ep = null; */ //Common-ICN-0045
		
	 sqlQuery = "SELECT a.ordered_facility_id, a.operating_facility_id, a.patient_id, b.patient_name, a.section_code, a.specimen_no,get_age (b.date_of_birth) AS age, b.sex,DECODE (a.status, '', 'Registered', 'O', 'Registered', 'H', 'On Hold', 'A', 'Review') AS status_name,  a.status, c.facility_name AS performing_facility, a.reporting_pathologist_id, d.ord_pract_id, TO_CHAR(a.spec_recd_date_time, 'dd/mm/yyyy hh24:mi') spec_recd_date_time, a.assign_by_id, a.assign_patho_remarks, (SELECT COUNT (*) FROM rl_request_header a WHERE specimen_no=a.specimen_no AND operating_facility_id=a.operating_facility_id) COUNT, (SELECT appl_user_name FROM sm_appl_user WHERE a.reporting_pathologist_id=appl_user_id) as ASSIGNED_PATHOLOGIST, (SELECT c.facility_name FROM sm_facility_param c WHERE a.reporting_facility_id = c.facility_id) as reporting_facility FROM rl_request_header a, mp_patient b, sm_facility_param c, or_order d WHERE a.patient_id = b.patient_id AND a.operating_facility_id = c.facility_id AND a.order_id = d.order_id(+) "; 
	 
		if(null != ordering_pract_code_search && !"".equals(ordering_pract_code_search)) {
			sqlQuery += " AND d.ord_pract_id = '"+ordering_pract_code_search+"' ";
		}

		if(null != order_facility_name_search && !"".equals(order_facility_name_search)) {
			sqlQuery += " AND a.ordered_facility_id = '"+order_facility_name_search+"' ";
		}

		if(null != performing_facility_id_search && !"".equals(performing_facility_id_search)) {
			sqlQuery += " AND a.operating_facility_id = '"+performing_facility_id_search+"' ";
		}

		if(null != section_code && !"".equals(section_code)) {
			sqlQuery += " AND a.section_code = '"+section_code+"' ";
		}

		if(null != patient_id && !"".equals(patient_id)) {
			sqlQuery += " AND a.patient_id = '"+patient_id+"' ";
		}

		if(null != reporting_facility_id_search && !"".equals(reporting_facility_id_search)) {
			sqlQuery += " AND a.reporting_facility_id = '"+reporting_facility_id_search+"' ";
		}	
		
		if(null != assigned_red_code_search && !"".equals(assigned_red_code_search)) {
			sqlQuery += " AND a.reporting_pathologist_id = '"+assigned_red_code_search+"' ";			
		}

		if(null != lab_order_status && !"".equals(lab_order_status)) {
			
			if("R".equals(lab_order_status)){
				sqlQuery += "AND not exists (select 'X' from rl_technician_review where operating_facility_id = a.operating_facility_id AND specimen_no = a.specimen_no) AND not exists (select 'X' from rl_normal_review where operating_facility_id = a.operating_facility_id AND specimen_no = a.specimen_no) AND not exists (select 'X' from rl_abnormal_review where operating_facility_id = a.operating_facility_id AND specimen_no = a.specimen_no)";
			}else if("FLR".equals(lab_order_status)){
				sqlQuery += "AND exists (select 'X' from rl_technician_review where operating_facility_id = a.operating_facility_id AND specimen_no = a.specimen_no)";
			}else if("SLR".equals(lab_order_status)){
				sqlQuery += "AND exists (select 'X' from rl_normal_review where operating_facility_id = a.operating_facility_id AND specimen_no = a.specimen_no)";
			}else if("SLAR".equals(lab_order_status)){
				sqlQuery += "AND exists (select 'X' from rl_abnormal_review where operating_facility_id = a.operating_facility_id AND specimen_no = a.specimen_no)";
			}	
		}
		
		
		if( null != specimen_number && !"".equals(specimen_number) && null !=fromDate_search  && !"".equals(fromDate_search) && null !=toDate_search  && !"".equals(toDate_search)){
			sqlQuery += " AND trunc(a.spec_recd_date_time) BETWEEN TO_DATE ('"+fromDate_search+"', 'DD/MM/YYYY HH24:MI') AND TO_DATE ('"+toDate_search+"', 'DD/MM/YYYY HH24:MI') ";
			
			sqlQuery += "AND a.specimen_no='"+specimen_number+"' AND NVL (a.cancelled_yn, 'N') = 'N' AND NVL (a.status, 'O') NOT IN ('R', 'P') AND NOT EXISTS(SELECT 'X' FROM rl_specimens_for_verify WHERE operating_facility_id = a.operating_facility_id AND specimen_no = a.specimen_no) AND NOT EXISTS (select 'X' from RL_INTERVAL_TEST_SPECIMENS where operating_facility_id = a.operating_facility_id  AND (specimen_no = a.specimen_no or interval_test_specimen_no = a.specimen_no)) ORDER BY a.specimen_no";
			
					
		}else if(null != specimen_number && !"".equals(specimen_number)) {	
			sqlQuery += "AND a.specimen_no='"+specimen_number+"' AND NVL (a.cancelled_yn, 'N') = 'N' AND NVL (a.status, 'O') NOT IN ('R', 'P') AND NOT EXISTS(SELECT 'X' FROM rl_specimens_for_verify WHERE operating_facility_id = a.operating_facility_id AND specimen_no = a.specimen_no) AND NOT EXISTS (select 'X' from RL_INTERVAL_TEST_SPECIMENS where operating_facility_id = a.operating_facility_id  AND (specimen_no = a.specimen_no or interval_test_specimen_no = a.specimen_no))  ORDER BY a.specimen_no";
			
		}else if(null !=fromDate_search  && !"".equals(fromDate_search) && null !=toDate_search  && !"".equals(toDate_search)){	
				sqlQuery += "AND trunc(a.spec_recd_date_time) BETWEEN TO_DATE ('"+fromDate_search+"', 'DD/MM/YYYY HH24:MI') AND TO_DATE ('"+toDate_search+"', 'DD/MM/YYYY HH24:MI') ";

				sqlQuery += " AND NVL (a.cancelled_yn, 'N') = 'N' AND NVL (a.status, 'O') NOT IN ('R', 'P')  AND NOT EXISTS (SELECT 'X' FROM rl_specimens_for_verify WHERE operating_facility_id = a.operating_facility_id AND specimen_no = a.specimen_no) AND NOT EXISTS (select 'X' from RL_INTERVAL_TEST_SPECIMENS where operating_facility_id = a.operating_facility_id  AND (specimen_no = a.specimen_no or interval_test_specimen_no = a.specimen_no)) ORDER BY a.specimen_no ";
			
		} else{
			 sqlQuery += "AND NVL (a.cancelled_yn, 'N') = 'N' AND NVL (a.status, 'O') NOT IN ('R', 'P') AND NOT EXISTS (SELECT 'X' FROM rl_specimens_for_verify WHERE operating_facility_id = a.operating_facility_id AND specimen_no = a.specimen_no) AND NOT EXISTS (select 'X' from RL_INTERVAL_TEST_SPECIMENS where operating_facility_id = a.operating_facility_id  AND (specimen_no = a.specimen_no or interval_test_specimen_no = a.specimen_no)) ORDER BY a.specimen_no ";
		}

	
	try {
		
			connection				= ConnectionManager.getConnection() ;
			pstmt					= connection.prepareStatement( sqlQuery ) ;

			resultSet = pstmt.executeQuery() ;
			
			   while(resultSet.next()){
					pathologistworklist.add(resultSet.getString("SPECIMEN_NO")); //0
					pathologistworklist.add(resultSet.getString("SPEC_RECD_DATE_TIME")); //1
					pathologistworklist.add(resultSet.getString("PATIENT_ID")); //2
					pathologistworklist.add(resultSet.getString("PATIENT_NAME")); //3
					pathologistworklist.add(resultSet.getString("AGE")+ "/"+resultSet.getString("SEX")); //4
					pathologistworklist.add(resultSet.getString("PERFORMING_FACILITY")); //5
					pathologistworklist.add(resultSet.getString("REPORTING_FACILITY")); //6
					pathologistworklist.add(resultSet.getString("ASSIGN_BY_ID")); //7
					pathologistworklist.add(resultSet.getString("ASSIGN_PATHO_REMARKS")); //8
					pathologistworklist.add(resultSet.getString("COUNT")); //9
					pathologistworklist.add(resultSet.getString("STATUS_NAME")); //10
					pathologistworklist.add(resultSet.getString("ORDERED_FACILITY_ID")); //11
					pathologistworklist.add(resultSet.getString("OPERATING_FACILITY_ID")); //12
					pathologistworklist.add(resultSet.getString("ORD_PRACT_ID")); //13		
					pathologistworklist.add(resultSet.getString("REPORTING_PATHOLOGIST_ID")); //14		
					pathologistworklist.add(resultSet.getString("STATUS")); //15		
					pathologistworklist.add(resultSet.getString("ASSIGNED_PATHOLOGIST")); //16	
			   }
 
		if( resultSet != null && resultSet.next() ) {
				
			}			   
		} 
		catch (Exception e) {
          e.printStackTrace();
		  pathologistworklist.add(e.toString());
      } finally {
		if(connection!=null)  ConnectionManager.returnConnection(connection); //Common-ICN-0045		  
		pstmt.close();
		resultSet.close();
		}
	return  pathologistworklist;
	}
	
	
	
}