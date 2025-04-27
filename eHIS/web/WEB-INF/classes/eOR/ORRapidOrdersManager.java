/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//package eOR.ORRapidOrdersManager ;

package eOR ;
import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import java.io.*;
import oracle.sql.*;
import eOR.Common.* ;

import javax.ejb.* ;
import javax.transaction.* ;

public class ORRapidOrdersManager extends OrEJBSessionAdapter {

	

	StringBuffer error_messages 	= new StringBuffer() ;
	StringBuffer messages 		= new StringBuffer() ;
	
	Connection connection 			= null ;
   	public HashMap insert( HashMap tabData, HashMap sqlMap ) throws RemoteException {

		//SessionContext context ;
		
		//PreparedStatement pstmt 		= null ;
		CallableStatement cstmt_hdr		= null;
		CallableStatement cstmt_line	= null;
		HashMap map 				= new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", new Boolean( false ) ) ;
		StringBuffer error_messages = new StringBuffer();
		final String SQL_OR_RAPID_ORDER_HDR_INSERT		= (String) sqlMap.get("SQL_OR_RAPID_ORDER_HDR_INSERT");
		final String SQL_OR_RAPID_ORDER_LINE_INSERT 	= (String) sqlMap.get("SQL_OR_RAPID_ORDER_LINE_INSERT");
		final String SQL_ORDER_ENTRY_OR_ORDER_LINE_NUM_SELECT 		= (String) sqlMap.get("SQL_ORDER_ENTRY_OR_ORDER_LINE_NUM_SELECT");
		boolean result 					= true;

		int count						= 0,       order_line_num		= 0;
		String grouping					= null;
		String performing_facility_id	= null,		order_category		= null;
		String order_type_code			= null;//		order_catalog_code	= null;
		String order_id					= null,		err_msg				= null;

		TreeMap treemap					= new TreeMap();	
		TreeMap mapOrderId				= new TreeMap();	
		HashMap hashmap					= new HashMap();	
	
		treemap							= ((TreeMap)tabData.get("treemap")) ;
		hashmap  						= ((HashMap)tabData.get("hashmap")) ;

		java.util.Set setValues 		= null; 
		java.util.Iterator iterator		= null;
		StringTokenizer	stGroup			= null;

 try{
		connection = getConnection((Properties)tabData.get( "properties" ) ) ;
		connection.setAutoCommit( false ) ;
//System.err.println("connection"+connection);
//System.err.println("SQL_OR_RAPID_ORDER_HDR_INSERT"+SQL_OR_RAPID_ORDER_HDR_INSERT);
		cstmt_hdr = connection.prepareCall("{ "+SQL_OR_RAPID_ORDER_HDR_INSERT+" }");
		cstmt_line = connection.prepareCall("{ "+SQL_OR_RAPID_ORDER_LINE_INSERT+" }");

setValues	=  treemap.keySet();   //Set 
//System.err.println("setValues"+setValues);

error_messages = new StringBuffer();
		count						=  Integer.parseInt(((String)hashmap.get("total_records")));	 // Total count
//System.err.println("count"+count);
		if(count > 0)  // Insert for the Header
		{
			iterator	= setValues.iterator();
			for(int i=0;i<treemap.size();i++)
			{
				if(result)
				{
					grouping		= ((String)iterator.next());
//System.err.println("grouping"+grouping);
					stGroup			= new StringTokenizer(grouping,"~~");//Get the grouping
					while(stGroup.hasMoreTokens())
					{
						order_category		 	= stGroup.nextToken();
						if(order_category.equals("^^")) {	
							order_category="";
						}
						order_type_code 		= stGroup.nextToken();
						if(order_type_code.equals("^^")) {
							order_type_code="";
						}
						performing_facility_id	= stGroup.nextToken();
						if(performing_facility_id.equals("^^")) { 
							performing_facility_id="";
						}
					}
/*System.err.println("order_category"+order_category);
System.err.println("order_type_code"+order_type_code);
System.err.println("performing_facility_id"+performing_facility_id);
System.err.println("fid"+((String)tabData.get("login_facility_id")));
System.err.println("pid"+((String)hashmap.get("patient_id")));
System.err.println("patient_class"+((String)hashmap.get("patient_class")));
System.err.println("eid"+((String)hashmap.get("encounter_id")));
System.err.println("ltype"+((String)hashmap.get("location_type")));
System.err.println("lcode"+((String)hashmap.get("location_code")));
System.err.println("pid"+((String)hashmap.get("ordering_practitioner")));
System.err.println("login_by_id"+((String)tabData.get("login_by_id")));
System.err.println("login_at_ws_no"+((String)tabData.get("login_at_ws_no")));*/
					cstmt_hdr.setString(1, order_category);  // ORDER_CATEGORY
					cstmt_hdr.setString(2, order_type_code);  // ORDER_TYPE_CODE
					cstmt_hdr.setString(3, (String)tabData.get("login_facility_id")); // ORDERING_FACILITY_ID
					cstmt_hdr.setString(4, performing_facility_id);						// PERFORMING_FACILITY_ID
					cstmt_hdr.setString(5, (String)hashmap.get("patient_id"));		// patient_id
					cstmt_hdr.setString(6, (String)hashmap.get("patient_class") );	// PATIENT_CLASS
					cstmt_hdr.setInt(7, Integer.parseInt(checkForNull((String)hashmap.get("encounter_id"),"0")) );		// ENCOUNTER_ID
					cstmt_hdr.setString(8, (String)hashmap.get("location_type"));		// SOURCE_TYPE
					cstmt_hdr.setString(9, (String)hashmap.get("location_code"));		// SOURCE_CODe
					cstmt_hdr.setString(10, (String)hashmap.get("ordering_practitioner"));	// ORDERING_PRACTITIONER
					cstmt_hdr.setString(11, (String)hashmap.get("comment"));		// REQUEST_COMMENT
					cstmt_hdr.setString(12, null);		//P_New_Old_Order
					cstmt_hdr.setString(13, (String)tabData.get("login_by_id"));		// REQUEST_COMMENT
					cstmt_hdr.setString(14, (String)tabData.get("login_at_ws_no"));		// REQUEST_COMMENT
					cstmt_hdr.registerOutParameter( 15,  Types.VARCHAR ) ;			 // P_ORDER_ID
					cstmt_hdr.registerOutParameter( 16,  Types.VARCHAR ) ;			 // P_err_msg

					cstmt_hdr.execute();
					order_id 	= checkForNull(cstmt_hdr.getString(15),"");
					err_msg 	= checkForNull(cstmt_hdr.getString(16),"");
					if(!order_id.equals("")) {
						mapOrderId.put(grouping, order_id);  // order_id has been stored for that grouping()
					}
					if(!err_msg.equals("")) {
						result = false;
					}
//System.err.println("err_msg"+err_msg);
//System.err.println("order_id"+order_id);
				} // End of if result
			} // End of for
		} // End of if count > 0
//System.err.println("result"+result);
		if(result && count>0)
		{
			for(int i=0;i<count;i++)
			{
				if(result)
				{
					cstmt_line.setString(1, checkForNull((String)hashmap.get("order_category"+i),"") );  // P_ORDER_CATEGORY
//System.err.println("Line OC"+checkForNull((String)hashmap.get("order_category"+i),""));
					cstmt_line.setString(2, checkForNull((String)hashmap.get("order_type_code"+i),"") );  // P_ORDER_TYPE
//System.err.println("Line order_type_code"+checkForNull((String)hashmap.get("order_type_code"+i),""));
					grouping = 	(checkForNull((String)hashmap.get("order_category"+i),"^^"))+"~~"+checkForNull(((String)hashmap.get("order_type_code"+i)),"^^")+"~~"+checkForNull(((String)hashmap.get("performing_facility_id"+i)),"^^");
//System.err.println("Line grouping"+grouping);
					order_id = ((String)mapOrderId.get(grouping));
					cstmt_line.setString(3, order_id );  // P_ORDER_ID
					order_line_num = getLineNum(order_id,SQL_ORDER_ENTRY_OR_ORDER_LINE_NUM_SELECT);
					cstmt_line.setString(4, String.valueOf(order_line_num ));  // P_ORDER_LINE_NUM
//System.err.println("Line order_id"+order_id);
//System.err.println("Line order_line_num"+order_line_num);
					cstmt_line.setString(5, checkForNull((String)hashmap.get("order_catalog_code"+i) ,""));  // P_ORDER_CATALOG 
//System.err.println("Line catalog"+checkForNull((String)hashmap.get("order_catalog_code"+i) ,""));
					cstmt_line.setString(6, checkForNull((String)hashmap.get("catalog_synonym"+i),"")  );  // P_ORDER_CATALOG_DESC 
//System.err.println("Line catalog_synonym"+checkForNull((String)hashmap.get("catalog_synonym"+i),""));
					cstmt_line.setString(7, checkForNull((String)hashmap.get("order_catalog_nature"+i),"") );  // P_ORDER_CATALOG_NATURE
//System.err.println("Line order_catalog_nature"+checkForNull((String)hashmap.get("order_catalog_nature"+i),""));
					cstmt_line.setString(8, (String)tabData.get("login_facility_id") );  // P_ORDERING_FACILITY
					cstmt_line.setString(9, checkForNull((String)tabData.get("ordering_practitioner"),"") );  // P_ORDERING_PRACT
					cstmt_line.setString(10, (String)tabData.get("login_by_id") );  // P_USER
					cstmt_line.setString(11, (String)tabData.get("login_at_ws_no") );  // P_WS_NO
					cstmt_line.registerOutParameter( 12,  Types.VARCHAR ) ;			 // P_err_msg
					cstmt_line.execute();
					err_msg 	= checkForNull(cstmt_line.getString(12),"");
					if(!err_msg.equals("")) {
						result = false;
					}
//System.err.println("Final result line"+result);
//System.err.println("Final result err_msg"+err_msg);
				} // result
			}  // End of for i ...Line Level
		}	// End of result * count >0 
error_messages.append("Final result"+result);
	     if ( result)
	     {
			connection.commit();
			map.put( "result", new Boolean( true ) ) ;
			messages.append( "RECORD_INSERTED" ) ;
	     }else{
			connection.rollback();
			messages.append( " Insert Failed..." + err_msg) ;
			messages.append(error_messages);
	     }
	    }catch( Exception e ){
		try {
			connection.rollback(); 
			System.err.println("EJB-Error Catch"+ e.toString());
		        error_messages.append("In Error Catch"+e.getMessage());
		     } catch ( Exception ex ) {
			System.err.println("EJB-Err Catch EJB "+ ex.toString());
			error_messages.append(ex.getMessage());
			messages.append( ex.getMessage()) ;
		 }
		 messages.append( e.getMessage() ) ;
		System.err.println(e.getMessage() );
		e.printStackTrace() ;
   		} finally{
            	try {
				//closeStatement( pstmt ) ;
				closeStatement( cstmt_hdr ) ;
				closeStatement( cstmt_line ) ;
				//closeResultSet( rset_clob ) ;
			if(connection != null) {
				closeConnection( connection,(Properties)tabData.get( "properties" ) );
			}
   		} catch ( Exception fe ) {
    			System.err.println( fe.getMessage() ) ;
		    	fe.printStackTrace() ;
        }
		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", error_messages.toString() ) ;
		map.put( "flag", "" ) ;
		} // End of finally
		return map ;
	} // end of insert

/*	public HashMap modify( HashMap tabData, HashMap sqlMap ) throws RemoteException {

		//boolean flag = true ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "") ;
		map.put( "flag", new Boolean( false ) ) ;
		return map;
 		return null;

	}// End of modify Method
*/

	/*public HashMap delete( HashMap tabData, HashMap sqlMap ) throws RemoteException {
	HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "") ;
		map.put( "flag", new Boolean( false ) ) ;
		return map;
 		return null;
	} // end of delete
*/
	// Below Method is to get the Line No. for the order_id passed (Used when inserting the line num in the line level)
	private int getLineNum(String order_id,String query) throws Exception {
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		int line_num 				= 0;
		try
		{
			pstmt		= connection.prepareStatement(query);
 			pstmt.setString(1,order_id.trim());
  			resultSet	= pstmt.executeQuery() ;
  			if(resultSet!=null) // Only One Record
 			{
 				if(resultSet.next() ) {  // Only one record
  					line_num = resultSet.getInt(1);
  				}
 			}
 			if(line_num == 0 || resultSet == null) line_num = 1;
	 	}catch ( Exception e ){
			error_messages = new StringBuffer();
	  		error_messages.append( "Error getting the line_num Rapid" +e.toString()) ;
	  		e.printStackTrace() ;
	  	} finally {
	  			closeResultSet( resultSet ) ;
	  			closeStatement( pstmt ) ;
	  	}
  		return line_num;
	} // End of getLineNum

	// Check For Null and If value is there return it, other wise return the default value..
	private String checkForNull( String val, String dflt_val)
	{
	    if ( val == null || val.equals(""))
	    	return dflt_val;
	    else
		 	return val;
    }
} // End of Class
