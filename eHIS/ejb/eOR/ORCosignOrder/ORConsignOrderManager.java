/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.ORCosignOrder;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;

import javax.ejb.* ;
import javax.transaction.* ;

import eOR.Common.* ;

/**
*
* @ejb.bean
*	name="ORCosignOrder"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORCosignOrder"
*	local-jndi-name="ORCosignOrder"
*	impl-class-name="eOR.ORCosignOrder.ORConsignOrderManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORCosignOrder.ORConsignOrderLocal"
*	remote-class="eOR.ORCosignOrder.ORConsignOrderRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORCosignOrder.ORConsignOrderLocalHome"
*	remote-class="eOR.ORCosignOrder.ORConsignOrderHome"
*	generate= "local,remote"
*
*
*/

public class ORConsignOrderManager extends OrEJBSessionAdapter {
   // SessionContext context ;
	PreparedStatement pstmt = null ;

	StringBuffer traceVals = new StringBuffer();

/**
* @ejb.interface-method
*	 view-type="both"
*/

	public HashMap insert( HashMap tabData, HashMap sqlMap ) {

		Connection connection = null ;
		StringBuffer messages = new StringBuffer() ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;


		try {
			connection = getConnection((Properties)tabData.get( "properties" ) ) ;
			connection.setAutoCommit( false ) ;

			map = updateValues(connection, tabData, sqlMap);

		 } catch( Exception e ) {
			traceVals.append("Exception if any -- "+e);

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
				if ( pstmt != null ) {
					closeStatement(pstmt);
				}
				if(connection != null) {
					closeConnection(connection,(Properties)tabData.get( "properties" ));
					connection = null ;
				}
			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}

	//	map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;
	}



	public HashMap updateValues(Connection connection, HashMap tabData, HashMap sqlMap){
		//PreparedStatement pstmt 	= null;
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;

		int count =0;
		//int cnt=0;

		count = Integer.parseInt((String)tabData.get("totalCount"));
		String pract_id = (String)tabData.get("pract_id");


		traceVals.append("====count *>"+count);
		String[] updt_vals = new String[1];
		int result = 0;
		String cont_order_ind = "";
		try{
			for(int i=0; i<count; i++){

				updt_vals = (String[])tabData.get("consign_data"+i);
				cont_order_ind = (String)tabData.get("cont_order_ind"+i);
				cont_order_ind = cont_order_ind.trim();

				//System.out.println(" >>> COSIGN order cont_order_ind >> "+cont_order_ind);

				pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_CONSIGN_ORDER_UPDATE_ORDER") ) ;

				pstmt.setString( 1, pract_id) ;
				pstmt.setString( 2, ((String)tabData.get("login_by_id"))) ;
				pstmt.setString( 3, ((String)tabData.get("login_at_ws_no"))) ;
				pstmt.setString( 4, ((String)tabData.get("login_facility_id"))) ;
				pstmt.setString( 5, updt_vals[0] ) ;

				result = pstmt.executeUpdate();
				closeStatement(pstmt);

				if(cont_order_ind.equals("DR") || cont_order_ind.equals("CR") ){
					pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_CONSIGN_ORDER_UPDATE_ORDER_FREQ_EXPLN") ) ;

					pstmt.setString( 1, pract_id) ;
					pstmt.setString( 2, ((String)tabData.get("login_by_id"))) ;
					pstmt.setString( 3, ((String)tabData.get("login_at_ws_no"))) ;
					pstmt.setString( 4, ((String)tabData.get("login_facility_id"))) ;
					pstmt.setString( 5, updt_vals[0] ) ;

					pstmt.executeUpdate();
					//result = pstmt.executeUpdate();
					closeStatement(pstmt);
				}
			}

				//System.out.println(" >>> COSIGN order result >> "+result);


			if ( result< 1 ) {
				map.put( "result", new Boolean( false ) ) ;
				connection.rollback();
				map.put( "message", "Operation failure ..." ) ;

			} else  {
				connection.commit() ;
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", "Operation Completed Successfully..." ) ;
				messages.append( "RECORD_MODIFIED" ) ;
				//messages.append( "Operation Completed Successfully..." ) ;
			}
		}catch(Exception e){
			System.err.println("Error here::");
			e.printStackTrace();

		}
		map.put( "message", messages.toString() ) ;

		return map;
	}

/**
* @ejb.interface-method
*	 view-type="both"
*/

	public HashMap modify( HashMap tabData, HashMap sqlMap ) {

		StringBuffer messages = new StringBuffer() ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;

		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;
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
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;
	}
}

