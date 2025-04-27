/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;

import eOR.Common.* ;
import eCommon.Common.*;

public class DispenseBean extends OrAdapter implements java.io.Serializable
{
	//public String  tempChk	= "";
/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/
	//private ArrayList parameters =  new ArrayList();

	public void clear()	{
		// parameters =  new ArrayList();
	}

/**
	This will populate the order category by practitioner ID
	@return		:	ArrayList
*/

	public ArrayList getOrderType() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCat = new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SELECT_ORDER_TYPE") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, "PH") ; // order_category
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null)
			{
				while( resultSet != null && resultSet.next() )
				{
					String[] record = new String[2];
					record[0] = resultSet.getString( "order_type_code" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;

					OrderCat.add(record) ;
				}
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return OrderCat;
	}

/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/

	public ArrayList getLocation(String facility_id, String practitioner_id, String location_type) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCat 			= new ArrayList() ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_SELECT_LOCN") ) ;
			pstmt.setString( 1,language_id);
			pstmt.setString( 2,language_id);
			pstmt.setString( 3,language_id);
			pstmt.setString( 4,language_id);
			pstmt.setString( 5,language_id);
			pstmt.setString(6, practitioner_id.trim() );
			pstmt.setString(7, location_type.trim() ) ;
			pstmt.setString(8, facility_id.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "locn_code" )  ;
				record[1] = resultSet.getString( "locn_short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return OrderCat;
	}

/**
		To populate the patient class
		@return		:	ArrayList
	*/
		public ArrayList getPatientClass() throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			ArrayList patient_class		= new ArrayList() ;
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_DISPENSE_PATIENT_CLASS") ) ;
				pstmt.setString( 1, language_id);
				resultSet = pstmt.executeQuery() ;

				if ( resultSet != null)
				{
					while(resultSet.next() )
					{
						String[] record = new String[14];
							record[0] = resultSet.getString( "patient_class" )  ;
							record[1] = resultSet.getString( "short_desc" )  ;
							patient_class.add(record) ;
					}
				}
			} catch ( Exception e )	{
				System.err.println( "Error loading values from database" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			}
			return patient_class;
		}

	/**
		This will query on the basis of the parameters passed.
		@return		:	ArrayList
	*/
		public ArrayList getSearchDetails(HashMap Parameters, int start, int end) throws Exception 
		{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			ArrayList results 			= new ArrayList() ;
			int cnt						= 0;
			String sql					= "";

			try 
			{
				connection = getConnection() ;

				String patient_id = (String)Parameters.get("patient_id")==null?"":(String)Parameters.get("patient_id");
				String encounter_id = (String)Parameters.get("encounter_id")==null?"":(String)Parameters.get("encounter_id");
				String order_id = (String)Parameters.get("order_id")==null?"":(String)Parameters.get("order_id");
				
				if (!language_id.equals("en"))
				{
					String date_from=(String)Parameters.get("date_from");
					String date_to=(String)Parameters.get("date_to");
					if (date_from.equals(" ") || date_from.equals("null")) date_from="";
					if (date_to.equals(" ") || date_to.equals("null")) date_to="";
					date_from=com.ehis.util.DateUtils.convertDate(date_from,"DMY",language_id,"en");
					date_to=com.ehis.util.DateUtils.convertDate(date_to,"DMY",language_id,"en");

					Parameters.put("date_from",date_from);
					Parameters.put("date_to",date_to);
				}

				String practitioner_type = (String)Parameters.get("practitioner_type");

//				if(!practitioner_type.equals("PH"))
//					pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_DISPENSE_RESULT") ) ;
//				else
				sql = (String)OrRepository.getOrKeyValue("SQL_OR_DISPENSE_RESULT_PH");

				if(!patient_id.equals(""))
				{
					sql = sql.replace("&&PATIENTID##"," AND a.patient_id = ?");
				}
				else
				{
					sql = sql.replace("&&PATIENTID##"," ");
				}

				if(!encounter_id.equals(""))
				{
					sql = sql.replace("&&ENCOUNTERID##"," AND encounter_id = ?");
				}
				else
				{
					sql = sql.replace("&&ENCOUNTERID##"," ");
				}

				if(!order_id.equals(""))
				{
					sql = sql.replace("&&ORDERID##"," AND order_id = ?");
				}
				else
				{
					sql = sql.replace("&&ORDERID##"," ");
				}
		
				pstmt = connection.prepareStatement( sql ) ;
			
				pstmt.setString( ++cnt , language_id);
				pstmt.setString( ++cnt , language_id);
				pstmt.setString( ++cnt , language_id);
				pstmt.setString( ++cnt , language_id);
				pstmt.setString( ++cnt , language_id);
				pstmt.setString( ++cnt , language_id);
				pstmt.setString( ++cnt , (String)Parameters.get("practitioner_type") ) ;		
				pstmt.setString( ++cnt , language_id);
				pstmt.setString( ++cnt , language_id);
				pstmt.setString( ++cnt , language_id);
				pstmt.setString( ++cnt , language_id);
				pstmt.setString( ++cnt , language_id);
				pstmt.setString( ++cnt , (String)Parameters.get("date_from") ) ;
				pstmt.setString( ++cnt , (String)Parameters.get("date_to") ) ;
				
				if(!patient_id.equals(""))
				{
					pstmt.setString( ++cnt , patient_id ) ;	
				}
				
				if(!encounter_id.equals(""))
				{
					pstmt.setString( ++cnt , encounter_id ) ;	
				}
				
				if(!order_id.equals(""))
				{
					pstmt.setString( ++cnt , order_id ) ;
				}
			
				pstmt.setString( ++cnt , (String)Parameters.get("priority") ) ;
				//pstmt.setString( ++cnt , (String)Parameters.get("order_category") ) ;
				//				if(!practitioner_type.equals("PH"))
//				{
//					pstmt.setString( 9, (String)Parameters.get("location_type") ) ;
//					pstmt.setString( 10, (String)Parameters.get("location_type") ) ; //location_type is to be set twice.
//					pstmt.setString( 11, (String)Parameters.get("location") ) ;
//					pstmt.setString( 12, (String)Parameters.get("facility_id") ) ;
//					pstmt.setString( 13, (String)Parameters.get("practitioner_id") ) ;
//					pstmt.setString( 14, (String)Parameters.get("patient_class") ) ;
//				}
//				else
				//{

				pstmt.setString( ++cnt , (String)Parameters.get("order_type") ) ;
				pstmt.setString( ++cnt , (String)Parameters.get("patient_class") ) ;
				//}

				resultSet = pstmt.executeQuery() ;
				if(resultSet!=null) 
				{
				/*resultSet.last(); //move to the last
				total_records = resultSet.getRow();
			}
			if(resultSet!=null && total_records > 0){
					resultSet.beforeFirst()  ;
					if(start!=0 && start!=1)
	 					resultSet.absolute(start-1); */

					if(start > 0)
						for(int i=0;(i<start-1 && resultSet.next());i++);	
					
					while ( start <= end && resultSet!=null && resultSet.next()) 
					{
					//while ( resultSet != null && resultSet.next() )
					//{
						String[] record = new String[15];
						record[0] = resultSet.getString( "order_date_time" )  ;
						record[1] = resultSet.getString( "priority_desc" )  ;
						record[2] = resultSet.getString( "order_detail" )  ;
						record[3] = resultSet.getString( "encounter_dtls" )  ;
						record[4] = resultSet.getString( "order_status_short_desc" )  ;

						record[5] = resultSet.getString( "order_category" )  ;
						record[6] = resultSet.getString( "order_category_short_desc" )  ;
						if(!practitioner_type.equals("PH"))
						{
							record[7] = resultSet.getString( "source_type")+resultSet.getString( "source_code");
							record[8] = resultSet.getString( "location_details" )  ;
						}else
						{
							record[7] = resultSet.getString( "order_type_code" )  ;
							record[8] = resultSet.getString( "order_type_short_desc" )  ;
						}
						record[9] = resultSet.getString( "order_id" )  ;
						record[10] = resultSet.getString( "order_status" )  ;
						record[11] = resultSet.getString( "patient_id" )  ;
						record[12] = resultSet.getString( "popup_menu_flag" )  ;
						record[13] = resultSet.getString( "priority" )  ;

						results.add(record) ;
						start++;
					}
					if (resultSet.next())
					{
						String[] templist = (String[])results.get(0);
						templist[14] = ""+(end+7);
						results.set(0,templist);
					}
				}
			} 
			catch ( Exception e )	
			{
				System.err.println( "Error loading values from database" ) ;
				e.printStackTrace() ;
				throw e ;
			} 
			finally 
			{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			}
			return results;
		}

	/*public String getSysDate() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String currentDate 			= "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( CommonRepository.getCommonKeyValue("SQL_SYS_DATE_TIME") ) ;
			resultSet = pstmt.executeQuery() ;
			if( resultSet != null && resultSet.next() ) {
				currentDate = resultSet.getString("sys_date")  ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return currentDate;
	}*/
	public ArrayList getSysDateTime() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList  currentDate		= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME1") ) ;
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				currentDate.add(resultSet.getString("curr_date"))  ;
				currentDate.add(resultSet.getString("last_week_date"))  ;
				currentDate.add(resultSet.getString("sys_date"))  ;
				currentDate.add(resultSet.getString("sys_date_time"))  ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
            try{ 
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
			}
			catch(Exception e){
				System.err.println("finally"+e.toString());
			}
		}


		return currentDate;
	}

	public HashMap insert(){

	HashMap map = new HashMap() ;
	//HashMap sqlMap = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	return map;
	}
}
