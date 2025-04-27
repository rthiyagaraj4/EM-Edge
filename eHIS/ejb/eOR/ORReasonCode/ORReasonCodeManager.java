/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.ORReasonCode ;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import javax.ejb.* ;

import eOR.Common.* ;

/**
*
* @ejb.bean
*	name="ORReasonCode"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORReasonCode"
*	local-jndi-name="ORReasonCode"
*	impl-class-name="eOR.ORReasonCode.ORReasonCodeManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORReasonCode.ORReasonCodeLocal"
*	remote-class="eOR.ORReasonCode.ORReasonCodeRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORReasonCode.ORReasonCodeLocalHome"
*	remote-class="eOR.ORReasonCode.ORReasonCodeHome"
*	generate= "local,remote"
*
*
*/

public class ORReasonCodeManager extends OrEJBSessionAdapter {
    SessionContext context ;

	Connection connection = null ;
	PreparedStatement pstmt_insert_reason = null ;
	PreparedStatement pstmt_insert_order_cat = null ;
	//PreparedStatement pstmt_update_reason = null;
	//PreparedStatement pstmt_update_reason_top = null;
	PreparedStatement pstmt_delete = null;
	PreparedStatement pstmt_delete_reason = null;
	//PreparedStatement pstmt_duplicate	 = null;
	//ResultSet rset = null;

	StringBuffer traceVals = new StringBuffer();
	
	/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap insert( HashMap tabData, HashMap sqlMap ) {
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "" ) ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;

		final String SQL_OR_REASON_CODE1_INSERT_REASON = (String) sqlMap.get( "SQL_OR_REASON_CODE1_INSERT_REASON" ) ;
		final String SQL_OR_REASON_CODE1_INSERT_ORDER_CAT = (String) sqlMap.get( "SQL_OR_REASON_CODE1_INSERT_ORDER_CAT" );
		//int result=0;
		String allOrderCat = (String) tabData.get( "allOrderCats" )  ;
		try {
	  		connection = getConnection((Properties)tabData.get( "properties" ) ) ;

			pstmt_insert_reason		= connection.prepareStatement( SQL_OR_REASON_CODE1_INSERT_REASON ) ;
			pstmt_insert_order_cat	= connection.prepareStatement( SQL_OR_REASON_CODE1_INSERT_ORDER_CAT ) ;

					int sequence = createReasonInsert( pstmt_insert_reason, tabData ) ;
					if ( sequence < 1 ) {
						connection.rollback() ;
						messages.append( "Insert Failed" ) ;
					} else if(!(allOrderCat == "" || allOrderCat== null  || allOrderCat.equals(""))) {
							sequence=0;
							sequence=createReasonOrderCategoryInsert(pstmt_insert_order_cat,tabData);
							if(sequence<1) {
									connection.rollback() ;
									messages.append( "Insert Failed" ) ;
							}
					}
					if(sequence >= 1){
							connection.commit() ;
							map.put( "result", new Boolean( true ) ) ;
							map.put( "message", "Operation Completed Successfully..." ) ;
							messages.append( "RECORD_INSERTED" ) ;
							//messages.append( "Operation Completed Successfully..." ) ;
					}

		 } catch( Exception e ) {
			try {
				context.setRollbackOnly();
			} catch ( Exception ee ) {
				messages.append( ee.getMessage() ) ;
			}

			messages.append( e.getMessage() ) ;
			System.err.println(e.getMessage() );
			e.printStackTrace() ;
		} finally {
			try {
				if ( pstmt_insert_reason != null ) {
					closeStatement(pstmt_insert_reason);		 
					pstmt_insert_reason = null ;
				}

				if ( pstmt_insert_order_cat != null ) {
					closeStatement(pstmt_insert_order_cat);		 
					pstmt_insert_order_cat = null ;
				}

				if(connection != null) {
					//closeConnection(connection);
					closeConnection(connection, (Properties)tabData.get( "properties" ));
				}
			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}

		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;
	}


	private int createReasonInsert( PreparedStatement pstmt_insert_reason, HashMap tabData )
		throws Exception {
		int result1=0;
			try {

				String reason_code_type = (String) tabData.get( "reason_code_type" );
				String reason_code = (String) tabData.get( "reason_code" ) ;
				String reason_desc = (String) tabData.get( "reason_desc" ) ;
				String reason_short_desc = (String) tabData.get( "reason_short_desc" ) ;
				String eff_status = (String) tabData.get( "eff_status" ) ;

				pstmt_insert_reason.setString( 1, (String) reason_code_type ) ;
				pstmt_insert_reason.setString( 2, (String) reason_code ) ;
				pstmt_insert_reason.setString(3, (String) reason_short_desc) ;
				pstmt_insert_reason.setString( 4, (String) reason_desc ) ;
				pstmt_insert_reason.setString( 5, (String) eff_status) ;
				pstmt_insert_reason.setString( 6, (String) tabData.get( "added_by_id" ) ) ;
				//pstmt_insert_reason.setString( 6, (String) tabData.get( "added_date" ) ) ;
				pstmt_insert_reason.setString( 7, (String) tabData.get( "added_at_ws_no" ) ) ;
				pstmt_insert_reason.setString( 8, (String) tabData.get( "added_facility_id" ) ) ;
				pstmt_insert_reason.setString( 9, (String) tabData.get( "modified_by_id" ) ) ;
				//pstmt_insert_reason.setString( 10, (String) tabData.get( "modified_date" ) ) ;
				pstmt_insert_reason.setString( 10, (String) tabData.get( "modified_at_ws_no" ) ) ;
				pstmt_insert_reason.setString( 11, (String) tabData.get( "modified_facility_id" ) ) ;
			
				result1 = pstmt_insert_reason.executeUpdate() ;


		} catch ( Exception e ) {
			e.printStackTrace() ;
			throw e ;
		} finally {
			try {
				if ( pstmt_insert_reason!= null ) {
					closeStatement(pstmt_insert_reason);		 
					pstmt_insert_reason = null ;
				}
			} catch ( Exception ee ) {
				throw ee ;
			}
		}

		return result1 ;
	}


	private int createReasonOrderCategoryInsert( PreparedStatement pstmt_insert_order_cat, HashMap tabData ) throws Exception {
		int result = 0 ;
		try {
				pstmt_insert_order_cat.setString( 1, (String) tabData.get( "added_by_id" )  );
				//pstmt_insert_order_cat.setString( 2, (String) tabData.get( "added_date" ) ) ;
				pstmt_insert_order_cat.setString( 2, (String) tabData.get( "added_at_ws_no" ) ) ;
				pstmt_insert_order_cat.setString( 3, (String) tabData.get( "added_facility_id" ) ) ;
				pstmt_insert_order_cat.setString( 4, (String) tabData.get( "modified_by_id" ) ) ;
				//pstmt_insert_order_cat.setString( 6, (String) tabData.get( "modified_date" ) ) ;
				pstmt_insert_order_cat.setString( 5, (String) tabData.get( "modified_at_ws_no" ) ) ;
				pstmt_insert_order_cat.setString( 6, (String) tabData.get( "modified_facility_id" ) ) ;
				pstmt_insert_order_cat.setString( 7, (String) tabData.get( "reason_code_type" ) ) ;
				pstmt_insert_order_cat.setString( 8, (String) tabData.get( "reason_code" ) ) ;

				String allOrderCats = (String) tabData.get( "allOrderCats" )  ;

				StringTokenizer token = new StringTokenizer(allOrderCats,"~");
				String value = "";
				String value_yn = "";
				while (token.hasMoreTokens()){
					value = token.nextToken();
					value_yn  = value.substring(0,1);
					value = value.substring(1,value.length());

					pstmt_insert_order_cat.setString( 9, value ) ;

					if(value_yn.equals("Y")){
						pstmt_insert_order_cat.setString( 10, "Y" ) ;
					}else{
						pstmt_insert_order_cat.setString( 10, "N" ) ;
					}

					result= pstmt_insert_order_cat.executeUpdate() ;
					if(result < 1) {
						return result;
					}
				}

		} catch ( Exception e ) {
			e.printStackTrace() ;
			throw e ;
		} finally {
			try {
					if ( pstmt_insert_order_cat != null ) {
						closeStatement(pstmt_insert_order_cat);	
						pstmt_insert_order_cat=null;
					}
			} catch ( Exception ee ) {
				throw ee ;
			}
		}

		return result ;
	}
	
	/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap modify( HashMap tabData, HashMap sqlMap ) {
		/*****/
		//System.out.println("###in modify of ejb");
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "" ) ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;

		final String SQL_OR_REASON_CODE1_DELETE = (String) sqlMap.get( "SQL_OR_REASON_CODE1_DELETE" ) ;
		final String SQL_OR_REASON_CODE1_REASON_DELETE = (String) sqlMap.get( "SQL_OR_REASON_CODE1_REASON_DELETE" );
		//int result=0;
		//String allOrderCat = (String) tabData.get( "allOrderCats" )  ;
		try {
	  		connection = getConnection((Properties)tabData.get( "properties" ) ) ;

			pstmt_delete		= connection.prepareStatement( SQL_OR_REASON_CODE1_DELETE ) ;
			pstmt_delete_reason	= connection.prepareStatement( SQL_OR_REASON_CODE1_REASON_DELETE ) ;

			int result1=0;	

			String reason_code_type = (String) tabData.get( "reason_code_type" );
			String reason_code = (String) tabData.get( "reason_code" ) ;

			pstmt_delete.setString( 1, (String) reason_code ) ;
			pstmt_delete.setString( 2, (String) reason_code_type ) ;

			result1 = pstmt_delete.executeUpdate() ;
			//System.out.println("###in modify of ejb,result1="+result1);
			if(result1 >=0 ) {

			int result2=0;
			pstmt_delete_reason.setString( 1, (String) reason_code ) ;
			pstmt_delete_reason.setString( 2, (String) reason_code_type ) ;
			result2 = pstmt_delete_reason.executeUpdate() ;
			//System.out.println("###in modify of ejb,result2="+result2);
			if(result2>=0){

				final String SQL_OR_REASON_CODE1_INSERT_REASON = (String) sqlMap.get( "SQL_OR_REASON_CODE1_INSERT_REASON" ) ;
				final String SQL_OR_REASON_CODE1_INSERT_ORDER_CAT = (String) sqlMap.get( "SQL_OR_REASON_CODE1_INSERT_ORDER_CAT" );
						//int result=0;
				String allOrderCat = (String) tabData.get( "allOrderCats" )  ;
				try {
	  		
					pstmt_insert_reason		= connection.prepareStatement(SQL_OR_REASON_CODE1_INSERT_REASON ) ;
					pstmt_insert_order_cat	= connection.prepareStatement( SQL_OR_REASON_CODE1_INSERT_ORDER_CAT ) ;

					int sequence = createReasonInsert( pstmt_insert_reason, tabData ) ;
					//System.out.println("###in modify of ejb,sequence="+sequence);
					if ( sequence < 1 ) {
						connection.rollback() ;
						messages.append( "Update Failed" ) ;
					} else if(!(allOrderCat == "" || allOrderCat== null  || allOrderCat.equals(""))) {
							sequence=0;
							sequence=createReasonOrderCategoryInsert(pstmt_insert_order_cat,tabData);
							if(sequence<1) {
									connection.rollback() ;
									messages.append( "Update Failed" ) ;
							}
					}
					if(sequence >= 1){
							//System.out.println("###in modify of ejb,Operation Completed Successfully...");
							connection.commit() ;
							map.put( "result", new Boolean( true ) ) ;
							map.put( "message", "Operation Completed Successfully..." ) ;
							messages.append( "RECORD_MODIFIED" ) ;
							//messages.append( "Operation Completed Successfully..." ) ;
					}

		 } catch( Exception e ) {
			try {
				context.setRollbackOnly();
			} catch ( Exception ee ) {
				messages.append( ee.getMessage() ) ;
			}

			messages.append( e.getMessage() ) ;
			System.err.println(e.getMessage() );
			e.printStackTrace() ;
		} finally {
			try {
				if ( pstmt_insert_reason != null ) {
					closeStatement(pstmt_insert_reason);		 
					pstmt_insert_reason = null ;
				}

				if ( pstmt_insert_order_cat != null ) {
					closeStatement(pstmt_insert_order_cat);		 
					pstmt_insert_order_cat = null ;
				}

			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}

	}else{
		connection.rollback() ;
		messages.append( "Delete Failed" ) ;
	}
}else{
		connection.rollback() ;
		messages.append( "Delete Failed" ) ;
	}

} catch( Exception e ) {
			try {
				context.setRollbackOnly();
			} catch ( Exception ee ) {
				messages.append( ee.getMessage() ) ;
			}

			messages.append( e.getMessage() ) ;
			System.err.println(e.getMessage() );
			e.printStackTrace() ;
		} finally {
			try {
				if ( pstmt_delete_reason != null ) {
					closeStatement(pstmt_delete_reason);		 
					pstmt_delete_reason = null ;
				}

				if ( pstmt_delete != null ) {
					closeStatement(pstmt_delete);		 
					pstmt_delete = null ;
				}

				if(connection != null) {
					//closeConnection(connection);
					closeConnection(connection, (Properties)tabData.get( "properties" ));
				}
			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}

		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;


		/****/

		/**StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;



		final String SQL_OR_REASON_CODE1_UPDATE = (String) sqlMap.get( "SQL_OR_REASON_CODE1_UPDATE" ) ;
		final String SQL_OR_REASON_CODE1_REASON_UPDATE = (String) sqlMap.get("SQL_OR_REASON_CODE1_REASON_UPDATE");
		traceVals.append("-- B4 try inmodify blk");
		int result=0;
		//String allOrderCat = (String) tabData.get( "allOrderCats" )  ;
		try {
	  		connection = getConnection((Properties)tabData.get( "properties" ) ) ;
			traceVals.append("-- connection  "+connection);
			pstmt_update_reason		= connection.prepareStatement( SQL_OR_REASON_CODE1_UPDATE ) ;
			pstmt_update_reason_top	= connection.prepareStatement( SQL_OR_REASON_CODE1_REASON_UPDATE ) ;

				String reason_code_type = (String) tabData.get( "reason_code_type" );
				String reason_code = (String) tabData.get( "reason_code" ) ;
				String eff_status = (String) tabData.get( "eff_status" ) ;
				String reason_desc  = (String) tabData.get( "reason_desc" ) ;


				pstmt_update_reason_top.setString( 1, (String) tabData.get( "modified_by_id" ) ) ;
				//pstmt_update_reason_top.setString( 2, (String) tabData.get( "modified_date" ) ) ;
				pstmt_update_reason_top.setString( 2, (String) tabData.get( "modified_at_ws_no" ) ) ;
				pstmt_update_reason_top.setString( 3, (String) tabData.get( "modified_facility_id" ) ) ;
				pstmt_update_reason_top.setString( 4, (String) reason_desc ) ;
				pstmt_update_reason_top.setString( 5, (String) eff_status ) ;
				pstmt_update_reason_top.setString( 6, (String) reason_code ) ;
				pstmt_update_reason_top.setString( 7, (String) reason_code_type ) ;

				traceVals.append("-- b4 execute of top ");

				result = pstmt_update_reason_top.executeUpdate() ;

				if ( result < 1 ) {
					traceVals.append("-- failure of top ");
					context.setRollbackOnly();
					messages.append( "Insert Failed" ) ;
				}else{


					pstmt_update_reason.setString( 1, (String) tabData.get( "modified_by_id" ) ) ;
					//pstmt_update_reason.setString( 2, (String) tabData.get( "modified_date" ) ) ;
					pstmt_update_reason.setString( 2, (String) tabData.get( "modified_at_ws_no" ) ) ;
					pstmt_update_reason.setString( 3, (String) tabData.get( "modified_facility_id" ) ) ;
					pstmt_update_reason.setString( 5, (String) reason_code ) ;
					pstmt_update_reason.setString( 6, (String) reason_code_type ) ;

					String allOrderCats = (String) tabData.get( "allOrderCats" )  ;

					StringTokenizer token = new StringTokenizer(allOrderCats,"~");
					String value = "";
					String value_yn = "";
					while (token.hasMoreTokens()){
						value = token.nextToken();
						value_yn  = value.substring(0,1);
						value = value.substring(1,value.length());

						pstmt_update_reason.setString( 7, value ) ;

						if(value_yn.equals("Y")){
							pstmt_update_reason.setString( 4, "Y" ) ;
						}else{
							traceVals.append("-- NO --");
							pstmt_update_reason.setString( 4, "N" ) ;
						}
						traceVals.append("-- b4 execute of bottom frame");
						result = pstmt_update_reason.executeUpdate() ;
					}
				}
				if ( result < 1 ) {
					context.setRollbackOnly();
					messages.append( "Insert Failed" ) ;
				}
				if(result >= 1){
						connection.commit() ;
						map.put( "result", new Boolean( true ) ) ;
						map.put( "message", "Operation Completed Successfully..." ) ;
						messages.append( "RECORD_MODIFIED" ) ;
						//messages.append( "Operation Completed Successfully..." ) ;
				}
		 } catch( Exception e ) {
			try {
				connection.rollback() ;
			} catch ( Exception ee ) {
				messages.append( ee.getMessage() ) ;
			}

			messages.append( e.getMessage() ) ;
			System.err.println(e.getMessage() );
			e.printStackTrace() ;
		} finally {
			try {
				if ( pstmt_update_reason != null ) {
					closeStatement(pstmt_update_reason);					
				}
				if(pstmt_update_reason_top!=null) {
					closeStatement(pstmt_update_reason_top);	
				}
				if(connection != null) {
					//closeConnection( connection );
					closeConnection(connection, (Properties)tabData.get( "properties" ));
					connection = null ;
				}
			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;**/
	}

	/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap delete( HashMap tabData, HashMap sqlMap ) {
	StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;
		map.put( "message", messages.toString() ) ;

		return map ;
	}


}


