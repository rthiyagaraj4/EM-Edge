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
//import webbeans.eCommon.ConnectionManager;


public class PatOrderByLocnBean extends OrAdapter implements java.io.Serializable {

//	private Hashtable allValues 			    = new Hashtable();
	private String	function_id					= "";
	private String	mode						= "";

	public void setFunctionId(String function_id){
			this.function_id = function_id;
	}

	public void setMode(String mode){
			this.mode = mode;
	}

	public String getMode(){
		return mode;
	}

	public String FunctionId(){
		return function_id;
	}


/**
	This will populate the order category by practiotioner ID
	@return		:	ArrayList
*/

	public ArrayList  getOrderType( String order_cat) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCat 			= new ArrayList();
		String[] record				= null;
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SELECT_ORDER_TYPE") ) ;
			   	pstmt.setString(1,order_cat);
				resultSet = pstmt.executeQuery() ;

				while( resultSet != null && resultSet.next() ) {
					record	  = new String[2];
					record[0] = resultSet.getString( "order_type_code" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;
					OrderCat.add(record) ;
				}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database OrderType" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return OrderCat;
	}



	public ArrayList  getOrderCategory() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCat 			= new ArrayList();

		String[]  record			= null;
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC1") ) ;
				pstmt.setString(1,language_id);
				resultSet = pstmt.executeQuery() ;
				while( resultSet != null && resultSet.next() ) {
					record = new String[2];
					record[0] = resultSet.getString( "order_category" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;
					OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database Order Cat" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return OrderCat;
	}

	public ArrayList  getPractionerID() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList Practitioner		= new ArrayList();
		String[] record				= null;

		try {
				connection 	= getConnection() ;
				pstmt 		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_AM_PRACT") ) ;
				resultSet 	= pstmt.executeQuery() ;
				while( resultSet != null && resultSet.next() ) {
					record 		= new String[2];
					record[0] 	= resultSet.getString( "code" )  ;
					record[1] 	= resultSet.getString( "long_desc" )  ;
					Practitioner.add(record) ;
				}
			} catch ( Exception e )	{
				System.err.println( "Error loading values from database Prac" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
		return Practitioner;
	}




/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/
public ArrayList getLocation(String location_type1, String pract_id1,String facility_id1) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			ArrayList Location			= new ArrayList() ;
			String[] record 			= null;
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_SELECT_LOCN") ) ;
				pstmt.setString( 1,language_id);
				pstmt.setString( 2,language_id);
				pstmt.setString( 3,language_id);
				pstmt.setString( 4,language_id);
				pstmt.setString( 5,language_id);
				pstmt.setString( 6, pract_id1.trim() ) ;
				pstmt.setString( 7, location_type1.trim() ) ;
				pstmt.setString( 8,facility_id1.trim() ) ;

				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) {
					record 	  = new String[2];
					record[0] = resultSet.getString( "locn_code" )  ;
					record[1] = resultSet.getString( "locn_short_desc" )  ;
				 	Location.add(record) ;
				}
			} catch ( Exception e )	{
				System.err.println( "Error loading values from database Location" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}

			return Location;
		}


/**
	This will populate the Lists for the Clinic
	@return		:	ArrayList
*/
	public ArrayList getClinicResult(String practitioner_id) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			ArrayList ClinicResult		= new ArrayList() ;
			String[] record 			= null;
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PAT_ORDER_BY_LOCN_CLINIC") ) ;
				pstmt.setString( 1, login_facility_id) ;
				pstmt.setString( 2, practitioner_id) ;
				pstmt.setString( 3, login_facility_id) ;

				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) {
					record 	  = new String[3];
					record[0] = resultSet.getString( "short_desc" )  ;
					record[1] = resultSet.getString( "assign_care_locn_code" )  ;
					record[2] = resultSet.getString( "count" )  ;
				 	ClinicResult.add(record) ;
				}
			} catch ( Exception e )	{
				System.err.println( "Error loading values from database Clinic Result" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}

			return ClinicResult;
	}

/**
	This will populate the Lists for the Nursing Unit
	@return		:	ArrayList
*/
	public ArrayList getNursingUnitResult(String practitioner_id) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			ArrayList NursingUnit		= new ArrayList() ;
			String[] record 			= null;
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PAT_ORDER_BY_LOCN_NURSING") ) ;
				pstmt.setString( 1, login_facility_id) ;
				pstmt.setString( 2, practitioner_id) ;
				pstmt.setString( 3, login_facility_id) ;

				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) {
					record 	  = new String[3];
					record[0] = resultSet.getString( "short_desc" )  ;
					record[1] = resultSet.getString( "nursing_unit_code" )  ;
					record[2] = resultSet.getString( "count" )  ;
				 	NursingUnit.add(record) ;
				}
			} catch ( Exception e )	{
				System.err.println( "Error loading values from database NursingUnit Result" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}

			return NursingUnit;
	}

/**
	This will populate the Lists for the Nursing Unit pateint Details
	@return		:	ArrayList
*/
	public ArrayList getNursingUnitPatientDetails(String nursing_unit) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			ArrayList NursingUnitPatient= new ArrayList();
			String record[]				= null;
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PAT_ORDER_BY_LOCN_NURSING_PAT_DETAILS") ) ;
				pstmt.setString( 1, login_facility_id) ;
				pstmt.setString( 2, nursing_unit) ;

				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) {
					record = new String[5];
					record[0] = resultSet.getString( "patient_details" ) ;
					record[1] = resultSet.getString( "patient_id" ) ;
					record[2] = resultSet.getString( "patient_name" ) ;
					record[3] = resultSet.getString( "sex" ) ;
					record[4] = resultSet.getString( "age" ) ;
					NursingUnitPatient.add(record);
				}
			} catch ( Exception e )	{
				System.err.println( "Error loading values from database NursingUnitPatient" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}

			return NursingUnitPatient;
	}

/**
	This will populate the Lists for the Category Details
	@return		:	ArrayList
*/
	public ArrayList getCategoryDtls(String patient_id) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			ArrayList CategoryDetails	= new ArrayList();
			String record[]				= null;
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PAT_ORDER_BY_LOCN_CAT_DTLS") ) ;
				pstmt.setString( 1, patient_id) ;
				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) {
					record = new String[4];
					record[0] = resultSet.getString( "short_desc" ) ;
					record[1] = resultSet.getString( "patient_id" ) ;
					record[2] = resultSet.getString( "order_category" ) ;
					record[3] = resultSet.getString( "count" ) ;
					CategoryDetails.add(record);
				}
			} catch ( Exception e )	{
				System.err.println( "Error loading values from database Category" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}

			return CategoryDetails;
	}

/**
	This will populate the Lists for the Order Type Details
	@return		:	ArrayList
*/
	public ArrayList getOrderTypeDtls(String patient_id, String order_category) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			ArrayList OrderTypeDetails	= new ArrayList();
			String record[]				= null;
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PAT_ORDER_BY_LOCN_ORDER_TYPE_DTLS") ) ;
				pstmt.setString( 1, order_category) ;
				pstmt.setString( 2, patient_id) ;
				resultSet = pstmt.executeQuery() ;
				while ( resultSet != null && resultSet.next() ) {
					record = new String[2];
					record[0] = resultSet.getString( "order_type_code" ) ;
					record[1] = resultSet.getString( "short_desc" ) ;
					OrderTypeDetails.add(record);
				}
			} catch ( Exception e )	{
				System.err.println( "Error loading values from database OrderType" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}

			return OrderTypeDetails;
	}

/**
	This will populate the Lists for the Order Details
	@return		:	ArrayList
*/
	public ArrayList getOrderDtls(String patient_id, String order_category, String order_type_code) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			ArrayList OrderDetails		= new ArrayList();
			String record[]				= null;
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PAT_ORDER_BY_LOCN_ORDER_DTLS") ) ;
				pstmt.setString( 1, patient_id) ;
				pstmt.setString( 2, order_category) ;
				pstmt.setString( 3, order_type_code) ;
				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) {
					record = new String[2];
					record[0] = resultSet.getString( "catalog_synonym_dc" ) ;
					record[1] = resultSet.getString( "count" ) ;
					OrderDetails.add(record);
				}
			} catch ( Exception e )	{
				System.err.println( "Error loading values from database Order" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}

			return OrderDetails;
	}


/**
	This will populate the Orderable  Details for all the Patients
	@return		:	ArrayList
*/
	public ArrayList getOrderableDetails(StringBuffer  stPatient) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			ArrayList OrderableDetails	= new ArrayList();
			String record[]				= null;

			String str					= "", 	sql	= "";

			str							= stPatient.toString();
			if(str.length() > 0)
			{
				try {
						connection = getConnection() ;

						str 			= str.substring(0, str.length()-1);
						sql 			= OrRepository.getOrKeyValue("SQL_OR_PAT_ORDER_BY_LOCN_ORDER_VIEW_DTLS");
						int count 		= sql.lastIndexOf("?");
						sql  			= sql.substring(0,count) + str.trim() + sql.substring(count+1)  ;
						pstmt = connection.prepareStatement( sql) ;
						resultSet = pstmt.executeQuery() ;

						while ( resultSet != null && resultSet.next() ) {
							record = new String[3];
							record[0] = resultSet.getString( "catalog_synonym_dc" ) ;
							record[1] = resultSet.getString( "order_catalog_code" ) ;
							record[2] = resultSet.getString( "patient_id" ) ;
							OrderableDetails.add(record);
						}
					} catch ( Exception e )	{
					System.err.println( "Error loading values from database Details" ) ;
					e.printStackTrace() ;
					throw e ;
				} finally {
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection(connection);
				}
			}
			return OrderableDetails;
	}

/**
	This will paint the Orderable and Result Details
	@return		:	ArrayList
*/
	public ArrayList getOrderableResultDetails(String order_catalog_code, String patient_id) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			ArrayList OrderResultDetails= new ArrayList();
			String record[]				= null;

			try {
					connection = getConnection() ;
					pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PAT_ORDER_BY_LOCN_ORDER_RESULT_DTLS")) ;
					pstmt.setString(1, order_catalog_code);
					pstmt.setString(2, patient_id);
					resultSet = pstmt.executeQuery() ;
					while ( resultSet != null && resultSet.next() ) {
						record = new String[7];
						record[0] = resultSet.getString( "start_date_time" ) ;
						record[1] = resultSet.getString( "order_id" ) ;
						record[2] = resultSet.getString( "order_line_status" ) ;
						record[3] = resultSet.getString( "time" ) ;
						record[4] = resultSet.getString( "order_category" ) ;
						record[5] = resultSet.getString( "short_desc" ) ;
						record[6] = resultSet.getString( "order_line_num" ) ;
						OrderResultDetails.add(record);
					}
				} catch ( Exception e )	{
				System.err.println( "Error loading values from database OrderableResultDetails" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
		return OrderResultDetails;
	}

/**
	This will paint the Result Details
	@return		:	ArrayList
*/
	public ArrayList getResultDetails(String patient_id, String order_id,String order_line_num) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			ArrayList OrderResultDetails= new ArrayList();
			String record[]				= null;

			try {
					connection = getConnection() ;
					pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PAT_ORDER_BY_LOCN_RESULT_DTLS")) ;
					pstmt.setString(1, patient_id);
					pstmt.setString(2, order_id);
					pstmt.setString(3, order_line_num);

					resultSet = pstmt.executeQuery() ;
					while ( resultSet != null && resultSet.next() ) {
						record = new String[41];
						record[0] = resultSet.getString( "accession_num" ) ;
						record[1] = resultSet.getString( "hist_rec_type" ) ;
						record[2] = resultSet.getString( "contr_sys_event_code" ) ;
						record[3] = resultSet.getString( "patient_id" ) ;
						record[4] = resultSet.getString( "facility_id" ) ;
						record[5] = resultSet.getString( "encounter_id" ) ;
						record[6] = resultSet.getString( "visit_id" ) ;
						record[7] = resultSet.getString( "event_class" ) ;
						record[8] = resultSet.getString( "event_code" ) ;
						record[9] = resultSet.getString( "event_group" ) ;
						record[10] = resultSet.getString( "event_date" ) ;
						record[11] = resultSet.getString( "event_end_date" ) ;
						record[12] = resultSet.getString( "hist_data_type" ) ;
						record[13] = resultSet.getString( "num_data_yn" ) ;
						record[14] = resultSet.getString( "result_num" ) ;
						record[15] = resultSet.getString( "result_num_uom" ) ;
						record[16] = resultSet.getString( "result_str" ) ;
						record[17] = resultSet.getString( "normalcy_ind" ) ;
						record[18] = resultSet.getString( "normal_low" ) ;
						record[19] = resultSet.getString( "normal_high" ) ;
						record[20] = resultSet.getString( "critical_low" ) ;
						record[21] = resultSet.getString( "critical_high" ) ;
						record[22] = resultSet.getString( "hist_storage_ind" ) ;
						record[23] = resultSet.getString( "hist_data_file" ) ;
						record[24] = resultSet.getString( "application_id" ) ;
						record[25] = resultSet.getString( "ext_image_obj_id" ) ;
						record[26] = resultSet.getString( "ext_image_appl_id" ) ;
						record[27] = resultSet.getString( "practitioner_id" ) ;
						record[28] = resultSet.getString( "performed_by_id" ) ;
						record[29] = resultSet.getString( "event_auth_date_time" ) ;
						record[30] = resultSet.getString( "authorized_by_id" ) ;
						record[31] = resultSet.getString( "security_level" ) ;
						record[32] = resultSet.getString( "protection_ind" ) ;
						record[33] = resultSet.getString( "event_short_desc" ) ;
						record[34] = resultSet.getString( "practitioner_name" ) ;
						record[35] = resultSet.getString( "result_num_prefix" ) ;
						record[36] = resultSet.getString( "status" ) ;
						record[37] = resultSet.getString( "request_num" ) ;
						record[38] = resultSet.getString( "request_num_seq" ) ;
						record[39] = resultSet.getString( "long_desc" ) ;
						record[40] = resultSet.getString( "contr_sys_id" ) ;

						OrderResultDetails.add(record);
					}
				} catch ( Exception e )	{
				System.err.println( "Error loading values from database Result" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
		return OrderResultDetails;
	}


	public String[] getAbnormalCondition()throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String result_data[] 		= new String[6];

		try{
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_ABNORMAL_CONDN") ) ;
				resultSet = pstmt.executeQuery() ;

				while(resultSet != null && resultSet.next() ) {
					result_data[0] = resultSet.getString("high_str");
					result_data[1] = resultSet.getString("low_str");
					result_data[2] = resultSet.getString("abn_str");
					result_data[3] = resultSet.getString("crit_str");
					result_data[4] = resultSet.getString("crit_high_str");
					result_data[5] = resultSet.getString("crit_low_str");
				}
			}catch ( Exception e )	{
				System.err.println( "Error loading values from database" ) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return result_data;
		}
	public ArrayList getSysDateTime() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList  currentDate		= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME") ) ;
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				currentDate.add(resultSet.getString("curr_date"))  ;
				currentDate.add(resultSet.getString("last_week_date"))  ;
				currentDate.add(resultSet.getString("sys_date_time"))  ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}

		return currentDate;
		}

/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/

/*	public void setAll( Hashtable recordSet ) {
	}
*/

/**
	This will populate all the Status list by Category
	@return		:	ArrayList
*/



public void clear() {
		super.clear();
}

public HashMap insert(){
	HashMap map = new HashMap();
	map.put( "result", new Boolean( true ) ) ;
	map.put( "message", "Insert" );
	return map;
}

public HashMap delete(){
	HashMap map = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "Delete" );
	return map;
 }//end of delete

 public HashMap modify(){
 	HashMap map = new HashMap();
 	map.put( "result", new Boolean( false ) ) ;
 	map.put( "message", "Modify" );
 	return map;
 }//end of modify

}//ENd of the class
