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

public class  OrderEntryCalendarBean extends OrAdapter implements Serializable
{
 public OrderEntryCalendarBean(){
 // try{
    //doCommon();
 // }catch(Exception e) {}
 }

public String getYearMonth(String state, int total)	throws Exception {

			Calendar calend	= Calendar.getInstance();
			//int current		= calend.get(Calendar.MONTH);
			String yearMonth= "";
			String month	= "";
		try{
				if(state!=null && (state.equals("previous") || state.equals("next")) )
				{
					calend.add(Calendar.MONTH,+total);
					yearMonth	= String.valueOf(calend.get(Calendar.YEAR));
					month		= String.valueOf(calend.get(Calendar.MONTH)+1);
					//if(calend.get(Calendar.MONTH)>=current) state="current";
				}
				else if(state!=null && state.equals("current"))
				{
					yearMonth	= String.valueOf(calend.get(Calendar.YEAR));
					month		= String.valueOf(calend.get(Calendar.MONTH)+1);
				}
				if(month.length()==1)
					month		= 0 + month;
					yearMonth	= yearMonth + month;
		}catch(Exception e)
		{
				System.err.println( "Error getting Calendar state Instance" +e) ;
				e.printStackTrace() ;
				throw e ;
		}
		return yearMonth;
	} // getYearMonth()

	public String getCalendarString(String year_month) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String calendar_string		= "";
		try
		{
			connection  = ConnectionManager.getConnection() ;
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_CALENDAR_STRING") ) ;
			pstmt.setString(1, year_month);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				while(resultSet.next())
				{
					calendar_string = resultSet.getString( "calendar_string" )  ;
				}
			}
		}catch ( Exception e )	{
				System.err.println( "Error loading getCalendarString" +e) ;
				e.printStackTrace() ;
				throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null)	ConnectionManager.returnConnection(connection);
				//closeConnection(connection);
		}
		return calendar_string;
	} // End of getCalendarString


	public String getCalendarStatusColor(String facility_id, String pract_id, String year_month) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String calendar_string		= "";
		try
		{
			connection  = ConnectionManager.getConnection() ;
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_CALENDAR_STATUS") ) ;
			pstmt.setString(1, facility_id);
			pstmt.setString(2, pract_id);
			pstmt.setString(3, year_month);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				while(resultSet.next())
				{
					calendar_string = resultSet.getString( "status_color" )  ;
				}
			}
		}catch ( Exception e )	{
				System.err.println( "Error loading getCalendarString" +e) ;
				e.printStackTrace() ;
				throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null)	ConnectionManager.returnConnection(connection);
		}
		return calendar_string;
	} // End of getCalanderStatusColor

	public int getActiveBookings(String facility_id,String practitioner_id,String booking_date) throws Exception {
		//,String patient_id
	 Connection connection 		= null;
	 PreparedStatement pstmt 	= null;
	 ResultSet resultSet 		= null;
	 int active_count			= 0;
	 try {
			connection  = ConnectionManager.getConnection() ;

			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_CALENDAR_ACTIVE_BOOKINGS"));
			pstmt.setString(1, facility_id);
			pstmt.setString(2, practitioner_id);
			pstmt.setString(3, booking_date);

			//System.err.println("facility_id="+facility_id + ",practitioner_id=" + practitioner_id + ",booking_date=" + booking_date);

            //pstmt.setString(1, patient_id);
		    resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the date
			{
				while(resultSet.next())
				{
					active_count = resultSet.getInt( "total" )  ;
				}
			}
	 	} catch ( Exception e )	{
			System.err.println( "When getting active_count" +e) ;
			e.printStackTrace() ;
			throw e ;
	 	} finally {
			closeResultSet( resultSet);
			closeStatement( pstmt);
			if(connection!=null)	ConnectionManager.returnConnection(connection);
 		}
 		return active_count;
	 } // End of getActiveBookings


	 public ArrayList getApptDetails(String patient_id) throws Exception{
		 Connection connection 		= null;
	  	 PreparedStatement pstmt 	= null;
	 	 ResultSet resultSet 		= null;
 		 ArrayList ApptDetails		 = new ArrayList() ;

		 try{
				connection  = ConnectionManager.getConnection() ;
				pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_APPT_DETAILS"));
				pstmt.setString(1, language_id);
				pstmt.setString(2, language_id);
				pstmt.setString(3, language_id);
				pstmt.setString(4, language_id);
				pstmt.setString(5, patient_id);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
		     			record 	  = new String[11];
						record[0] = checkForNull(resultSet.getString( "order_date_time" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "priority" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "priority_desc" ),"")  ;
						record[3] = checkForNull(resultSet.getString( "order_category_short_desc" ),"")  ;
						record[4] = checkForNull(resultSet.getString( "catalog_code"),"")  ;
						record[5] = checkForNull(resultSet.getString( "order_status" ),"")  ;
						record[6] = checkForNull(resultSet.getString( "order_status_short_desc" ),"")  ;
						record[7] = checkForNull(resultSet.getString( "order_detail" ),"")  ;
						record[8] = checkForNull(resultSet.getString( "ord_pract_id" ),"")  ;
						record[9] = checkForNull(resultSet.getString( "ordering_pract_name" ),"")  ;
						record[10] = checkForNull(resultSet.getString( "order_type_short_desc" ),"")  ;
						ApptDetails.add(record) ;
					}
				}
			}catch ( Exception e )	{
				System.err.println( "Appt Details display OT" +e) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null)	ConnectionManager.returnConnection(connection);
			}
			return ApptDetails;
	} // End of

	// Method to get the Default Sysdate
	 public String getSysDate() throws Exception {
	 Connection connection 		= null;
	 PreparedStatement pstmt 	= null;
	 ResultSet resultSet 		= null;
	 String sys_date			= "";
	 try {
			connection  = ConnectionManager.getConnection() ;
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME"));
		    resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the date
			{
				while(resultSet.next())
				{
					sys_date = checkForNull(resultSet.getString( "sys_date" ),"")  ;
				}
			}
	 	} catch ( Exception e )	{
			System.err.println( "When getting Date" +e) ;
			e.printStackTrace() ;
			throw e ;
	 	} finally {
			closeResultSet( resultSet);
			closeStatement( pstmt);
			if(connection!=null)	ConnectionManager.returnConnection(connection);
 		}
 		return sys_date;
	 } // End of getSysdate

}//end of class
