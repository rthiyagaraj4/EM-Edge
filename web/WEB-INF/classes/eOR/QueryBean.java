/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import java.io.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;

import eOR.Common.*;
 
public class  QueryBean extends OrAdapter implements Serializable
{
  public QueryBean(){
  }
 
	// To get the Order Category
	public ArrayList  getOrderCat(String facility_id, Properties properties) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList order_category = new ArrayList();  

		try {

			connection		= ConnectionManager.getConnection(properties) ;
			String sqlQry = " SELECT OR_GET_DESC.OR_ORDER_CATEGORY(ORDER_CATEGORY,?,'2') short_desc, order_category FROM OR_ORDER_CATEGORY  where order_category  not in ('PH','CS','MI') ORDER BY SHORT_DESC"; // modified for IN031304
			//pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_EXISTING_ORDER_OA_ORDER_CATEGORY") ) ;//IN035299
			//pstmt = connection.prepareStatement("SELECT OR_GET_DESC.OR_ORDER_CATEGORY(ORDER_CATEGORY,?,'2') short_desc, order_category FROM OR_ORDER_CATEGORY  where order_category  not in ('PH','CS','MI') and 'Y' =  DECODE(order_category,'RD',NVL((SELECT 'N' FROM SM_MODULES_FACILITY WHERE MODULE_ID = 'RD' AND FACILITY_ID = ? AND OPERATIONAL_YN = 'Y'),'Y'),'Y') ORDER BY SHORT_DESC" ) ;//IN035299																																																						
			pstmt = connection.prepareStatement(sqlQry);
			pstmt.setString(1,language_id);
			//pstmt.setString(2,facility_id);
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) {
					String[] record = new String[2];
					record[0] = resultSet.getString( "order_category" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;

				order_category.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database category" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet) ;
			closeStatement(pstmt) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return order_category;
	}

	public ArrayList  getOrderTypeSpecimen( String order_cat, Properties properties) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderType = new ArrayList();  //SQL_OR_SPECIMEN_ORDER_TYPE_SELECT

		try {

			connection		= ConnectionManager.getConnection(properties) ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SELECT_ORDER_TYPE") ) ;
			
			System.err.println("language_id"+language_id);
			pstmt.setString(1,language_id);
			pstmt.setString(2,order_cat);
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) {
					String[] record = new String[2];
					record[0] = resultSet.getString( "order_type_code" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;

				OrderType.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database getOrderTypeSpecimen" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return OrderType;
	}

	public ArrayList  getActivityType(String order_category, String order_type, Properties properties) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		
		ArrayList ActivityType = new ArrayList();

		try {
				connection		= ConnectionManager.getConnection(properties) ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT") ) ;
				pstmt.setString( 1, language_id);
				pstmt.setString( 2, order_category.trim() ) ;
				pstmt.setString( 3, order_type.trim() ) ;
				//pstmt.setString( 4, language_id);
				//pstmt.setString( 5, order_category.trim() ) ;
				

				resultSet = pstmt.executeQuery() ;
				while(resultSet.next())
				{
					String[] record = new String[2];
					record[0] = resultSet.getString( "activity_type" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;

					ActivityType.add(record) ;
					
				}
						
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database getActivityType" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return ActivityType;
	}

	public ArrayList  getPatientClass(Properties properties) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList PatientClass = new ArrayList();  

		try {

				connection		= ConnectionManager.getConnection(properties) ;
				pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_PATIENT_CLASS_LIST") ) ;
				pstmt.setString(1,language_id);
				resultSet = pstmt.executeQuery() ;

				while( resultSet != null && resultSet.next() ) {
						String[] record = new String[2];
						record[0] = resultSet.getString( "patient_class" )  ;
						record[1] = resultSet.getString( "short_desc" )  ;

					PatientClass.add(record) ;
				}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet) ;
			closeStatement(pstmt) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return PatientClass;
	}

	// To get the Performing Locations
	public ArrayList  getPerformingLocation(String facility_id, Properties properties) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList perfm_location = new ArrayList();  

		try {

			connection		= ConnectionManager.getConnection(properties) ;
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_EXISTING_ORDER_OA_TRANSFER_PERFORMING_LOC") ) ;
			pstmt.setString(1,facility_id);
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) {
					String[] record = new String[2];
					record[0] = resultSet.getString( "performing_location" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;

				perfm_location.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet) ;
			closeStatement(pstmt) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return perfm_location;
	}

	// To get the Results (From Pending Orders Schedule)
	public ArrayList getPendingScheduleSearchDetails(String order_category,String order_type,String activity_type,String order_catalog_code,String performing_locn ,String priority,String patient_id,String patient_class,String period_from,String period_to,String facility_id, Properties properties) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList results = new ArrayList() ;

		try {
				/* Thai date validations start 14/02/2007*/


            if(period_from == null || period_from.equals("null") || period_from.equals("&nbsp;") || period_from.equals(" ")) period_from = "";
            if(period_to == null || period_to.equals("null") || period_to.equals("&nbsp;") || period_to.equals(" ")) period_to = "";

					if (!language_id.equals("en")){

              period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
              period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
					}
				
			/* Thai date validations end 14/02/2007*/


			connection		= ConnectionManager.getConnection(properties) ;
			//String strsql="SELECT   patient_name ||', '||SEX ||' / '||GET_AGE(DATE_OF_BIRTH) ||', ID: '||Patient_id   patient_details,a.order_category order_category, order_category_short_desc,b.Priority  priority_desc,  patient_class_short_desc,patient_class,a.order_id order_id, patient_id,  encounter_id,  TO_CHAR(a.ord_date_time,'DD/MM/YYYY') order_date_time , OR_GET_DESC.OR_ORDER_CATALOG(b.ORDER_CATALOG_CODE,?,1)  order_detail,  b.order_catalog_code catalog_code,source_type, source_code, b.priority priority,b.order_type_code  order_type_code, a.order_type_short_desc  order_type_short_desc, a.ord_pract_id ord_pract_id, ordering_pract_name, order_line_status   order_status, b.order_line_num order_line_num, nvl(b.cont_order_ind,'DO') cont_order_ind, to_char(b.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time, to_char(b.end_date_time,'dd/mm/yyyy hh24:mi') end_date_time, OR_ORDER_LINE_COLOR ('APPT',B.ORDER_ID ,B.ORDER_TYPE_CODE,B.ORDER_CATALOG_CODE,B.ORDER_LINE_NUM,B.START_DATE_TIME,B.ORDER_CATEGORY )  wait_time_indicator,SEX ,b.start_Date_Time Start_Date FROM	or_order_vw a, or_order_line b WHERE a.order_id =b.order_id AND nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR') and Order_line_status = (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ('10')) AND appt_reqd_yn = 'Y' AND PERFORMING_FACILITY_ID = ? AND  a.order_category = NVL(?,a.order_Category)  AND a.order_type_code = nvl(?,a.order_type_code) AND nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))  AND b.order_catalog_Code = nvl(?,b.order_Catalog_code)  AND nvl(a.performing_deptloc_code,'!') = nvl(?,nvl(a.performing_deptloc_code,'!'))  AND b.priority=nvl(?,b.priority)  AND a.patient_id = NVL(?,patient_id)  AND a.patient_class = NVL(?,patient_class)  AND trunc(a.ord_date_time) BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')  AND 'Y' = DECODE(B.ORDER_CATEGORY,'RD',NVL((SELECT 'N' FROM SM_MODULES_FACILITY  WHERE MODULE_ID = 'RD' AND FACILITY_ID = ? AND OPERATIONAL_YN = 'Y'),'Y'), 'OT',NVL((SELECT 'N' FROM SM_MODULES_FACILITY WHERE MODULE_ID = 'OT' AND FACILITY_ID = ? AND OPERATIONAL_YN = 'Y'),'Y'),'Y')  ORDER BY Start_Date DESC";//IN035299
			// commented for IN031304
			//	String strsql="SELECT   patient_name ||', '||SEX ||' / '||GET_AGE(DATE_OF_BIRTH) ||', ID: '||Patient_id   patient_details,a.order_category order_category, order_category_short_desc,b.Priority  priority_desc,  patient_class_short_desc,patient_class,a.order_id order_id, patient_id,  encounter_id,  TO_CHAR(a.ord_date_time,'DD/MM/YYYY') order_date_time , OR_GET_DESC.OR_ORDER_CATALOG(b.ORDER_CATALOG_CODE,?,1)  order_detail,  b.order_catalog_code catalog_code,source_type, source_code, b.priority priority,b.order_type_code  order_type_code, a.order_type_short_desc  order_type_short_desc, a.ord_pract_id ord_pract_id, ordering_pract_name, order_line_status   order_status, b.order_line_num order_line_num, nvl(b.cont_order_ind,'DO') cont_order_ind, to_char(b.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time, to_char(b.end_date_time,'dd/mm/yyyy hh24:mi') end_date_time, OR_ORDER_LINE_COLOR ('APPT',B.ORDER_ID ,B.ORDER_TYPE_CODE,B.ORDER_CATALOG_CODE,B.ORDER_LINE_NUM,B.START_DATE_TIME,B.ORDER_CATEGORY )  wait_time_indicator,SEX ,b.start_Date_Time Start_Date FROM	or_order_vw a, or_order_line b WHERE a.order_id =b.order_id AND nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR') and Order_line_status = (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ('10')) AND appt_reqd_yn = 'Y' AND PERFORMING_FACILITY_ID = ? AND  a.order_category = NVL(?,a.order_Category)  AND a.order_type_code = nvl(?,a.order_type_code) AND nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))  AND b.order_catalog_Code = nvl(?,b.order_Catalog_code)  AND nvl(a.performing_deptloc_code,'!') = nvl(?,nvl(a.performing_deptloc_code,'!'))  AND b.priority=nvl(?,b.priority)  AND a.patient_id = NVL(?,patient_id)  AND a.patient_class = NVL(?,patient_class)  AND trunc(a.ord_date_time) BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')  AND 'Y' = DECODE(B.ORDER_CATEGORY,'RD',NVL((SELECT 'N' FROM SM_MODULES_FACILITY  WHERE MODULE_ID = 'RD' AND FACILITY_ID = ? AND OPERATIONAL_YN = 'Y'),'Y'),'Y')  ORDER BY Start_Date DESC";			//IN035299
			//modified for IN031304
			String strsql="SELECT   patient_name ||', '||SEX ||' / '||GET_AGE(DATE_OF_BIRTH) ||', ID: '||Patient_id   patient_details,a.order_category order_category, order_category_short_desc,b.Priority  priority_desc,  patient_class_short_desc,patient_class,a.order_id order_id, patient_id,  encounter_id,  TO_CHAR(a.ord_date_time,'DD/MM/YYYY') order_date_time , OR_GET_DESC.OR_ORDER_CATALOG(b.ORDER_CATALOG_CODE,?,1)  order_detail,  b.order_catalog_code catalog_code,source_type, source_code, b.priority priority,b.order_type_code  order_type_code, a.order_type_short_desc  order_type_short_desc, a.ord_pract_id ord_pract_id, ordering_pract_name, order_line_status   order_status, b.order_line_num order_line_num, nvl(b.cont_order_ind,'DO') cont_order_ind, to_char(b.start_date_time,'dd/mm/yyyy hh24:mi') start_date_time, to_char(b.end_date_time,'dd/mm/yyyy hh24:mi') end_date_time, OR_ORDER_LINE_COLOR ('APPT',B.ORDER_ID ,B.ORDER_TYPE_CODE,B.ORDER_CATALOG_CODE,B.ORDER_LINE_NUM,B.START_DATE_TIME,B.ORDER_CATEGORY )  wait_time_indicator,SEX ,b.start_Date_Time Start_Date FROM	or_order_vw a, or_order_line b WHERE a.order_id =b.order_id AND nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR') and Order_line_status = (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ('10')) AND appt_reqd_yn = 'Y' AND PERFORMING_FACILITY_ID = ? AND  a.order_category = NVL(?,a.order_Category)  AND a.order_type_code = nvl(?,a.order_type_code) AND nvl(activity_type ,'!') = nvl(?,nvl(activity_type,'!'))  AND b.order_catalog_Code = nvl(?,b.order_Catalog_code)  AND nvl(a.performing_deptloc_code,'!') = nvl(?,nvl(a.performing_deptloc_code,'!'))  AND b.priority=nvl(?,b.priority)  AND a.patient_id = NVL(?,patient_id)  AND a.patient_class = NVL(?,patient_class)  AND trunc(a.ord_date_time) BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') ORDER BY Start_Date DESC";
			
			pstmt = connection.prepareStatement(strsql) ;
			//pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_APPOINTMENT_PENDING_ORDERS")) ;
			pstmt.setString(1,language_id);
			pstmt.setString( 2, facility_id ) ;
			pstmt.setString( 3, order_category ) ;
			pstmt.setString( 4, order_type ) ;
			pstmt.setString( 5, activity_type ) ;
			pstmt.setString( 6, order_catalog_code ) ;
			pstmt.setString( 7, performing_locn ) ;
			pstmt.setString( 8, priority ) ;
			pstmt.setString( 9, patient_id ) ;
 			pstmt.setString( 10, patient_class ) ;
			pstmt.setString( 11, period_from ) ;
			pstmt.setString( 12, period_to ) ;
			//pstmt.setString( 13, facility_id ) ;  commented for IN031304
			//pstmt.setString( 14, facility_id ) ; commented for IN035299

			resultSet=pstmt.executeQuery();

			String[] record = null;

			while( resultSet != null && resultSet.next() ) 
			{
			 	record = new String[25];
				
				record[0] = checkForNull(resultSet.getString( "patient_details" ),"")  ;
				record[1] = checkForNull(resultSet.getString( "order_category" ),"")  ;
				record[2] = checkForNull(resultSet.getString( "order_category_short_desc" ),"")  ;
				record[3] = checkForNull(resultSet.getString( "priority_desc" ),"")  ;
				record[4] = checkForNull(resultSet.getString( "patient_class_short_desc" ),"")  ;
				record[5] = checkForNull(resultSet.getString( "patient_class" ),"")  ;
				record[6] = checkForNull(resultSet.getString( "order_id" ),"")  ;
				record[7] = checkForNull(resultSet.getString( "patient_id" ),"")  ;
				record[8] = checkForNull(resultSet.getString( "encounter_id" ),"")  ;
				record[9] = checkForNull(resultSet.getString( "order_date_time" ),"")  ;
				record[10] = checkForNull(resultSet.getString( "order_detail" ),"")  ;
				record[11] = checkForNull(resultSet.getString( "catalog_code" ),"")  ;
				record[12] = checkForNull(resultSet.getString( "source_type" ),"")  ;
				record[13] = checkForNull(resultSet.getString( "source_code" ),"")  ;
				record[14] = checkForNull(resultSet.getString( "priority" ),"")  ;
				record[15] = checkForNull(resultSet.getString( "order_type_code" ),"")  ;
				record[16] = checkForNull(resultSet.getString( "order_type_short_desc" ),"");
				record[17] = checkForNull(resultSet.getString( "ord_pract_id" ) ,"") ;
				record[18] = checkForNull(resultSet.getString( "ordering_pract_name" ) ,"") ;
				record[19] = checkForNull(resultSet.getString( "order_status" ),"");
			    record[20] = checkForNull(resultSet.getString( "order_line_num"),"");
				record[21] = checkForNull(resultSet.getString( "start_date_time"),"");
				record[22] = checkForNull(resultSet.getString( "end_date_time"),"");
				record[23] = checkForNull(resultSet.getString( "wait_time_indicator"),"");
				record[24] = checkForNull(resultSet.getString( "sex"),"");
			   

				results.add(record) ;
			}
 
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return results;
	}
	
	//--[IN031304] - Start
	// To get the radiology authorization flag
	public String getRadiologyAuthYn(String order_id,String order_line_num) throws Exception 
	{
		Connection connection 		= null;
		CallableStatement cstmt 	= null;
		String rad_auth_yn		= "N";
 		try
		{
			connection			= ConnectionManager.getConnection(properties) ;
			cstmt				= connection.prepareCall("{call RD_CHECK_DEPT_AUTH_REQD_YN(?,?,?)}");
			cstmt.clearParameters();
 			cstmt.setString(1, order_id);		 
			cstmt.setString(2, order_line_num);	 
			cstmt.registerOutParameter( 3,  Types.VARCHAR ) ;
 			cstmt.execute();
			rad_auth_yn= checkForNull(cstmt.getString(3),"N");
 		}catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		}  finally 
		{
 			closeStatement( cstmt ) ;
			if(connection!=null) 
				ConnectionManager.returnConnection(connection, properties);
		}
		return rad_auth_yn;
	} // End of getRadiologyAuthYn
	//--[IN031304] - End

} // End of the class
