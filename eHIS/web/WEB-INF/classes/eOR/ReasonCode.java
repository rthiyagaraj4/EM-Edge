/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import eOR.Common.* ;
import java.io.*;
import java.util.*;
import java.sql.* ;

import javax.naming.*;
import javax.rmi.*;

//import eOR.Common.* ;
import eCommon.Common.*;

import eOR.ORReasonCode.*;

public class ReasonCode extends eOR.Common.OrAdapter implements java.io.Serializable {


	String reason_code_type 	= "" ;
	String reason_code_type_desc = "";
	String reason_code			= "" ;
	String reason_desc			= "" ;
	String reason_short_desc			= "" ;
	String allOrderCats			= "" ;
	String eff_status 				= "" ;


	public void setReasonType(String reason_code_type){
		this.reason_code_type = reason_code_type ;
	}
	public void setReasonTypeDesc(String reason_code_type_desc){
		this.reason_code_type_desc = reason_code_type_desc ;
	}
	public void setReasonCode(String reason_code){
		this.reason_code = reason_code ;
	}
	public void setReasonDesc(String reason_desc){
		//reason_desc = (String)replaceNewLineChar( reason_desc);
		this.reason_desc = reason_desc;
	}
	public void setReasonShortDesc(String reason_short_desc){
		//reason_desc = (String)replaceNewLineChar( reason_desc);
		this.reason_short_desc = reason_short_desc;
	}
	public void setOrdCategory(String allOrderCats){
		this.allOrderCats = allOrderCats;
	}
	public void setEffectiveStatus(String eff_status){
		this.eff_status = eff_status;
	}



	public String getReasonCodeType(){
		return reason_code_type;
	}
	public String getReasonCodeTypeDesc(){
		return reason_code_type_desc;
	}

	public String getReasonCode(){
		return reason_code;
	}
	public String getReasonDesc(){
		return reason_desc;
	}
	public String getReasonShortDesc(){
		return reason_short_desc;
	}
	public String getOrdCategory(){
		return allOrderCats;
	}
	public String getEffectiveStatus(){
		return eff_status;
	}



/**
	This will populate all the order categories with scope of each category
	@return		:	ArrayList
*/

	public ArrayList getOrderCategory () throws Exception {

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC1") ) ;
			pstmt.setString(1,language_id);
			resultSet = pstmt.executeQuery() ;

			//String action_reason_scope_yn = "";
			String[] record=null;
			while ( resultSet != null && resultSet.next() ) {
				record = new String[2];
				record[0] = resultSet.getString( "order_category" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}

		return OrderCat;
	}


/**
	This will populate all the order categories with scope of each category
	@return		:	ArrayList
*/

	public ArrayList allOrderCategory () throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REASON_CODE1_SELECT") ) ;
			pstmt.setString( 1, reason_code_type ) ;
			pstmt.setString( 2, reason_code) ;
			pstmt.setString( 3, reason_code_type ) ;
			pstmt.setString( 4, reason_code) ;
			resultSet = pstmt.executeQuery() ;

			String action_reason_scope_yn = "";
			String[] record=null;
			while ( resultSet != null && resultSet.next() ) {
				record = new String[3];
				record[0] = resultSet.getString( "order_category" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				action_reason_scope_yn = resultSet.getString("action_reason_scope_yn");
				if(action_reason_scope_yn == null) 	{
					action_reason_scope_yn = "";
				}

				record[2] = action_reason_scope_yn;
				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}

		return OrderCat;
	}



/**
	This will populate all the order categories with scope of each category
	@return		:	ArrayList
*/

	public String[] loadDataForUpdate () throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] record = new String[5];

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REASON_CODE1_SELECT_FOR_UPDT") ) ;

			pstmt.setString( 1, reason_code_type ) ;
			pstmt.setString( 2, reason_code) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				record[0] = resultSet.getString( "action_type" )  ;
				record[1] = resultSet.getString( "action_reason_code" )  ;
				record[2] = resultSet.getString( "action_description" )  ;
				record[3] = resultSet.getString( "action_reason_desc" )  ;
				record[4] = resultSet.getString( "eff_status" )  ;

			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}

		return record;
	}


	/* Over-ridden Adapter methods start here */
	public HashMap validate() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		int count = 0;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		if(getMode().equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))
        {
		try {
				connection =  getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REASON_CODE1_REASON_DUPLICATE") ) ;
				pstmt.setString( 1, reason_code ) ;
				pstmt.setString( 2, reason_code_type) ;
				resultSet = pstmt.executeQuery() ;

				if ( resultSet != null && resultSet.next() ) {
					count = resultSet.getInt( 1 ) ;
					if ( count > 0 ) {
						map.put( "result", new Boolean( false ) ) ;
						//map.put( "message", getMessage( "CODE_ALREADY_EXISTS" ) );
						
						map.put( "message", getMessage(language_id,"CODE_ALREADY_EXISTS" , "Common")) ;
						//getMessage(language_id, "CODE_ALREADY_EXISTS", "Common") ;
						//messages.append("APP-002005 Code Already Exists");

					}
					else {
						map.put( "result", new Boolean( true ) ) ;
						map.put( "message", "success.." ) ;
					}
				}
			  } catch ( Exception e ) {
				System.err.println( "Order Type - validate() method error" ) ;
				e.printStackTrace() ;
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", e ) ;
				throw e ;
			} finally {
				try{
					closeResultSet(resultSet);
					closeStatement(pstmt);
					closeConnection(connection);
					}
					catch(Exception es){es.printStackTrace();
										}
				}
		}
		return map ;
	}

/**
	This will Insert the values to DB
	@return		:	HashMap
*/

public HashMap insert() {
		HashMap map = new HashMap() ;
		//StringBuffer traceVal = new StringBuffer();
		StringBuffer tmpBuff	= new StringBuffer();
		map.put( "result", new Boolean( false ) ) ;
		//traceVal.append("first line of insert");
		HashMap tabdata = new HashMap() ;
		tabdata.put( "reason_code_type",	reason_code_type ) ;
		tabdata.put( "reason_code",			reason_code ) ;
		tabdata.put( "reason_desc",			reason_desc ) ;
		tabdata.put( "reason_short_desc",			reason_short_desc ) ;
		tabdata.put( "allOrderCats",		allOrderCats ) ;
		tabdata.put("eff_status",	 		eff_status);
	//	traceVal.append("first line of insert" +reason_code_type);

		tabdata.put( "added_by_id",			login_by_id ) ;
		//tabdata.put( "added_date",			added_date ) ;
		tabdata.put( "added_at_ws_no",		login_at_ws_no ) ;
		tabdata.put( "added_facility_id",	login_facility_id ) ;
		tabdata.put( "modified_by_id",		login_by_id ) ;
		//tabdata.put( "modified_date",		modified_date ) ;
		tabdata.put( "modified_facility_id",login_facility_id ) ;
		tabdata.put( "modified_at_ws_no",	login_at_ws_no ) ;


		HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "SQL_OR_REASON_CODE1_INSERT_REASON", OrRepository.getOrKeyValue("SQL_OR_REASON_CODE1_INSERT_REASON") );
			sqlMap.put( "SQL_OR_REASON_CODE1_INSERT_ORDER_CAT", OrRepository.getOrKeyValue("SQL_OR_REASON_CODE1_INSERT_ORDER_CAT") );
		}catch(Exception e){e.printStackTrace();
		}

		//ORReasonCodeHome home = null ;
		//ORReasonCodeRemote remote = null ;

		try {
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( OrRepository.getOrKeyValue("REASON_CODE_JNDI") ) ;
				home  = (ORReasonCodeHome) PortableRemoteObject.narrow( object, ORReasonCodeHome.class ) ;
				remote = home.create() ;*/
				tabdata.put( "properties", getProperties() );
		//		traceVal.append("b45 calling ejb" );
				//map = remote.insert( tabdata, sqlMap ) ;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("REASON_CODE_JNDI"), ORReasonCodeHome.class, getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]	= new Object[2];
					argArray[0]		= tabdata;
					argArray[1]		= sqlMap;
				Class [] paramArray = new Class[2];
					paramArray[0]	= tabdata.getClass();
					paramArray[1]	= sqlMap.getClass();
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
						
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
					
						argArray	= null;
						paramArray	= null;

			if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
			map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
		}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
			map.put( "message", getMessage(language_id, (String) map.get( "message" ), "Common")) ;
		
		}
		map.put("traceVal", (String)tmpBuff.toString());
		tmpBuff.setLength(0);



			//	traceVal.append("after calling ejb" );
		} catch(Exception e) {
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			clear();
			/*try {
				if( remote != null )
					remote.remove() ;
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}*/
		}
		//map.put("traceVal",traceVal.toString());

		return map ;
	}

/**
	This will update the values to DB
	@return		:	HashMap
*/

public HashMap modify() {
		HashMap map = new HashMap() ;
		StringBuffer tmpBuff	= new StringBuffer();
		map.put( "result", new Boolean( false ) ) ;

		HashMap tabdata = new HashMap() ;

		tabdata.put( "reason_code_type",	reason_code_type ) ;
		tabdata.put( "reason_code",			reason_code ) ;
		tabdata.put( "reason_desc",			reason_desc ) ;
		tabdata.put( "reason_short_desc",			reason_short_desc ) ;
		tabdata.put( "allOrderCats",		allOrderCats ) ;
		tabdata.put("eff_status",	 		eff_status);
	//	traceVal.append("first line of insert" +reason_code_type);

		tabdata.put( "added_by_id",			login_by_id ) ;
		//tabdata.put( "added_date",			added_date ) ;
		tabdata.put( "added_at_ws_no",		login_at_ws_no ) ;
		tabdata.put( "added_facility_id",	login_facility_id ) ;
		tabdata.put( "modified_by_id",		login_by_id ) ;
		//tabdata.put( "modified_date",		modified_date ) ;
		tabdata.put( "modified_facility_id",login_facility_id ) ;
		tabdata.put( "modified_at_ws_no",	login_at_ws_no ) ;

		HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "SQL_OR_REASON_CODE1_DELETE", OrRepository.getOrKeyValue("SQL_OR_REASON_CODE1_DELETE") );
			sqlMap.put( "SQL_OR_REASON_CODE1_REASON_DELETE", OrRepository.getOrKeyValue("SQL_OR_REASON_CODE1_REASON_DELETE") );
			sqlMap.put( "SQL_OR_REASON_CODE1_INSERT_REASON", OrRepository.getOrKeyValue("SQL_OR_REASON_CODE1_INSERT_REASON") );
			sqlMap.put( "SQL_OR_REASON_CODE1_INSERT_ORDER_CAT", OrRepository.getOrKeyValue("SQL_OR_REASON_CODE1_INSERT_ORDER_CAT") );
		}catch(Exception e){e.printStackTrace();
		}

		//ORReasonCodeHome home = null ;
		//ORReasonCodeRemote remote = null ;

		try {
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( OrRepository.getOrKeyValue("REASON_CODE_JNDI") ) ;
				home  = (ORReasonCodeHome) PortableRemoteObject.narrow( object, ORReasonCodeHome.class ) ;
				remote = home.create() ;
				
				map = remote.modify( tabdata, sqlMap ) ;*/

				tabdata.put( "properties", getProperties() );
			//	map = modify( tabdata, sqlMap ) ;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("REASON_CODE_JNDI"), ORReasonCodeHome.class, getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]	= new Object[2];
					argArray[0]		= tabdata;
					argArray[1]		= sqlMap;
				Class [] paramArray = new Class[2];
					paramArray[0]	= tabdata.getClass();
					paramArray[1]	= sqlMap.getClass();
				map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
						
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
					
						argArray	= null;
						paramArray	= null;

						map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
						map.put("traceVal", (String)tmpBuff.toString());

		} catch(Exception e) {
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			clear();
		}
		return map ;
		/****HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		HashMap tabdata = new HashMap() ;
		tabdata.put( "reason_code_type",	reason_code_type ) ;
		tabdata.put( "reason_code",			reason_code ) ;
		tabdata.put( "reason_desc",			reason_desc ) ;
		tabdata.put("eff_status",	 		eff_status);
		tabdata.put( "allOrderCats",		allOrderCats ) ;
		tabdata.put( "modified_by_id",		login_by_id ) ;
//		tabdata.put( "modified_date",		modified_date ) ;
		tabdata.put( "modified_facility_id",login_facility_id ) ;
		tabdata.put( "modified_at_ws_no",	login_at_ws_no ) ;


		HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "SQL_OR_REASON_CODE1_UPDATE", OrRepository.getOrKeyValue("SQL_OR_REASON_CODE1_UPDATE") );
			sqlMap.put( "SQL_OR_REASON_CODE1_REASON_UPDATE", OrRepository.getOrKeyValue("SQL_OR_REASON_CODE1_REASON_UPDATE") );
		}catch(Exception e){e.printStackTrace();
		}

		//ORReasonCodeHome home = null ;
		//ORReasonCodeRemote remote = null ;

		try {
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( OrRepository.getOrKeyValue("REASON_CODE_JNDI") ) ;
				home  = (ORReasonCodeHome) PortableRemoteObject.narrow( object, ORReasonCodeHome.class ) ;
				remote = home.create() ;
				
				map = remote.modify( tabdata, sqlMap ) ;*/

			/****	tabdata.put( "properties", getProperties() );
			//	map = modify( tabdata, sqlMap ) ;


				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("REASON_CODE_JNDI"), ORReasonCodeHome.class, getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]	= new Object[2];
					argArray[0]		= tabdata;
					argArray[1]		= sqlMap;
				Class [] paramArray = new Class[2];
					paramArray[0]	= tabdata.getClass();
					paramArray[1]	= sqlMap.getClass();
				map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
						
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
					
						argArray	= null;
						paramArray	= null;



		} catch(Exception e) {
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			clear();
			/*try {
				if( remote != null )
					remote.remove() ;
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}*/
		/***}
		return map ;***/
	}

	public void setAll( Hashtable recordSet ) {
		//System.out.println("####in setall recordSet="+recordSet);
		if(recordSet.containsKey("reason_type"))
			setReasonType((String)recordSet.get("reason_type")) ;

		if(recordSet.containsKey("reason_code"))
			setReasonCode((String)recordSet.get("reason_code")) ;

		if(recordSet.containsKey("reason_desc")){
			String desc_val = (String)recordSet.get("reason_desc");
			setReasonDesc(desc_val) ;
		}
		if(recordSet.containsKey("reason_short_desc")){
			String reason_short_desc = (String)recordSet.get("reason_short_desc");
			setReasonShortDesc(reason_short_desc) ;
		}
		//this will have a String of values for the checked order categories
		if(recordSet.containsKey("allOrderCats"))
			setOrdCategory((String)recordSet.get("allOrderCats")) ;

		if(recordSet.containsKey("eff_status"))
			setEffectiveStatus((String)recordSet.get("eff_status")) ;

	}


	public void clear() {
		reason_code_type 	= "" ;
		reason_code			= "" ;
		reason_desc			= "" ;
		reason_short_desc			= "" ;
		eff_status 				= "" ;

		super.clear() ;
	}

}
