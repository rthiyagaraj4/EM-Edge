/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.OROrderingRule ;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import javax.ejb.* ;

import eOR.Common.* ;

/**
*
* @ejb.bean
*	name="OROrderingRule"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="OROrderingRule"
*	local-jndi-name="OROrderingRule"
*	impl-class-name="eOR.OROrderingRule.OROrderingRuleManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.OROrderingRule.OROrderingRuleLocal"
*	remote-class="eOR.OROrderingRule.OROrderingRuleRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.OROrderingRule.OROrderingRuleLocalHome"
*	remote-class="eOR.OROrderingRule.OROrderingRuleHome"
*	generate= "local,remote"
*
*
*/

public class OROrderingRuleManager extends OrEJBSessionAdapter {
    SessionContext context ;

/**
* @ejb.interface-method
*	 view-type="both"
*/

	public HashMap insert( HashMap tabData, HashMap sqlMap ) {
		Connection connection = null ;
		PreparedStatement pstmt_ordering_rule = null ;

		StringBuffer traceVals = new StringBuffer();
		StringBuffer messages = new StringBuffer() ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;

		final String ORDERING_RULE_BY_PATIENT_CLASS_INSERT = (String) sqlMap.get( "ORDERING_RULE_BY_PATIENT_CLASS_INSERT" ) ;
		traceVals.append(" in insert method before try pilllll-- ");

		int result[];
		try {
			connection = getConnection((Properties)tabData.get( "properties" ) ) ;
			traceVals.append("connectionl-- "+connection);

			pstmt_ordering_rule		= connection.prepareStatement( ORDERING_RULE_BY_PATIENT_CLASS_INSERT ) ;

			traceVals.append("pstmt_ordering_rule-- "+pstmt_ordering_rule);

				String order_category = (String) tabData.get( "order_category" );
				String patient_class = (String) tabData.get( "patient_class" ) ;
				String preselect_ord_type = (String) tabData.get( "preselect_ord_type" ) ;
				String time_based_rule = (String) tabData.get( "time_based_rule" ) ;
				String expiry_rule = (String) tabData.get( "expiry_rule" ) ;
				String future_order = (String) tabData.get( "future_order" ) ;
				String futureorderduration = (String) tabData.get( "futureorderduration" ) ;
				String floor_to_start_day_yn = (String) tabData.get( "floor_to_start_day_yn" ) ;

				traceVals.append("order_category -- "+order_category);
				traceVals.append("patient_class -- "+patient_class);
/*				traceVals.append("time_based_rule -- "+time_based_rule);
				traceVals.append("expiry_rule -- "+expiry_rule);
				traceVals.append("preselect_ord_type -- "+preselect_ord_type);
				traceVals.append("@@@@@@@@@@@@");
*/

				StringTokenizer stPatient_class = new StringTokenizer(patient_class,"~");
				StringTokenizer stTime_based_rule = new StringTokenizer(time_based_rule,"~");
				StringTokenizer stExpiry_rule = new StringTokenizer(expiry_rule,"~");
				StringTokenizer stPreselect_ord_type = new StringTokenizer(preselect_ord_type,"~");
				StringTokenizer stfuture_order = new StringTokenizer(future_order,"~");
				StringTokenizer stfutureorderduration = new StringTokenizer(futureorderduration,"~");
				StringTokenizer stFloor_to_start_day_yn = new StringTokenizer(floor_to_start_day_yn,"~");

				String patient_classValue = "";
				String time_based_ruleValue = "";
				String expiry_ruleValue = "";
				String preselect_ord_typeValue = "";
				String future_orderValue = "";
				String futureorderdurationValue = "";
				String floor_to_start_day_ynValue = "";
				int count = 0;

				while(stPatient_class.hasMoreTokens()){


						patient_classValue = stPatient_class.nextToken();
						pstmt_ordering_rule.setString( 2, (String) patient_classValue ) ;

						preselect_ord_typeValue = stPreselect_ord_type.nextToken();
						pstmt_ordering_rule.setString( 3, (String) preselect_ord_typeValue ) ;

						time_based_ruleValue = stTime_based_rule.nextToken();
					    if(time_based_ruleValue.equals(" ") || time_based_ruleValue == " "){
					    	time_based_ruleValue = null;
						}
						pstmt_ordering_rule.setString( 4, (String) time_based_ruleValue ) ;

						expiry_ruleValue = stExpiry_rule.nextToken();
					    if(expiry_ruleValue.equals(" ") || expiry_ruleValue == " "){
					    	expiry_ruleValue = null;
						}
						pstmt_ordering_rule.setString( 5, (String) expiry_ruleValue ) ;

						future_orderValue = stfuture_order.nextToken();
					    if(future_orderValue.equals(" ") || future_orderValue == " "){
					    	future_orderValue = null;
						}
						pstmt_ordering_rule.setString( 6, (String) future_orderValue ) ;

						futureorderdurationValue = stfutureorderduration.nextToken();
					    if(futureorderdurationValue.equals(" ") || futureorderdurationValue == " "){
					    	futureorderdurationValue = null;
						}
						pstmt_ordering_rule.setString( 7, (String) futureorderdurationValue ) ;

						floor_to_start_day_ynValue = stFloor_to_start_day_yn.nextToken();
					    if(floor_to_start_day_ynValue.equals(" ") || floor_to_start_day_ynValue == " "){
					    	floor_to_start_day_ynValue = null;
						}
						pstmt_ordering_rule.setString( 8, (String) floor_to_start_day_ynValue ) ;


						pstmt_ordering_rule.setString( 1, (String) order_category ) ;

						pstmt_ordering_rule.setString( 9, (String) tabData.get( "added_by_id" ) ) ;
						pstmt_ordering_rule.setString( 10, (String) tabData.get( "added_at_ws_no" ) ) ;
						pstmt_ordering_rule.setString( 11, (String) tabData.get( "added_facility_id" ) ) ;
						pstmt_ordering_rule.setString( 12, (String) tabData.get( "modified_by_id" ) ) ;
						pstmt_ordering_rule.setString( 13, (String) tabData.get( "modified_at_ws_no" ) ) ;
						pstmt_ordering_rule.setString( 14, (String) tabData.get( "modified_facility_id" ) ) ;

						traceVals.append("-- before execute bottom frame--");
						pstmt_ordering_rule.addBatch() ;
						count++;
						traceVals.append("-- after execute bottom frame--");
				}
						traceVals.append("***** Before batch update*** count --"+count);
						result = pstmt_ordering_rule.executeBatch() ;
						traceVals.append("******** result length --"+result.length);


				if ( result.length < 1 ) {
					context.setRollbackOnly();
					messages.append( "Insert Failed" ) ;
				}
				if(result.length >= 1){
						connection.commit() ;
						map.put( "result", new Boolean( true ) ) ;
						map.put( "message", "Operation Completed Successfully..." ) ;
						//messages.append( "Operation Completed Successfully..." ) ;
						messages.append( "RECORD_INSERTED" ) ;
				}
		 } catch( Exception e ) {
			traceVals.append("Exception if any -- "+e);

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
				if ( pstmt_ordering_rule != null ) {
					closeStatement(pstmt_ordering_rule);
				}
				if(connection != null) {
					closeConnection(connection,(Properties)tabData.get( "properties" ));
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

/**
* @ejb.interface-method
*	 view-type="both"
*/


	public HashMap modify( HashMap tabData, HashMap sqlMap ) {
		Connection connection = null ;
		PreparedStatement pstmt_ordering_rule = null ;

		StringBuffer traceVals = new StringBuffer();
		StringBuffer messages = new StringBuffer() ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;

		final String ORDERING_RULE_BY_PATIENT_CLASS_INSERT = (String) sqlMap.get( "ORDERING_RULE_BY_PATIENT_CLASS_INSERT" ) ;
		final String ORDERING_RULE_BY_PATIENT_CLASS_DELETE = (String) sqlMap.get( "ORDERING_RULE_BY_PATIENT_CLASS_DELETE" ) ;
		traceVals.append("modify ethod --------- before try -- ");

		int result[];
		try {
			connection = getConnection((Properties)tabData.get( "properties" ) ) ;


			String order_category = (String) tabData.get( "order_category" );
			String patient_class = (String) tabData.get( "patient_class" ) ;
			String preselect_ord_type = (String) tabData.get( "preselect_ord_type" ) ;
			String time_based_rule = (String) tabData.get( "time_based_rule" ) ;
			String expiry_rule = (String) tabData.get( "expiry_rule" ) ;
			String future_order = (String) tabData.get( "future_order" ) ;
			String futureorderduration = (String) tabData.get( "futureorderduration" ) ;
			String floor_to_start_day_yn = (String) tabData.get( "floor_to_start_day_yn" ) ;


			pstmt_ordering_rule		= connection.prepareStatement( ORDERING_RULE_BY_PATIENT_CLASS_DELETE) ;
			pstmt_ordering_rule.setString(1, (String)order_category);

			int deleted  = pstmt_ordering_rule.executeUpdate() ;
			traceVals.append("**** deleted records "+deleted);

			if ( pstmt_ordering_rule != null ) {
					closeStatement(pstmt_ordering_rule);
			}

			if(deleted > 0){
				pstmt_ordering_rule		= connection.prepareStatement( ORDERING_RULE_BY_PATIENT_CLASS_INSERT ) ;

				StringTokenizer stPatient_class = new StringTokenizer(patient_class,"~");
				StringTokenizer stTime_based_rule = new StringTokenizer(time_based_rule,"~");
				StringTokenizer stExpiry_rule = new StringTokenizer(expiry_rule,"~");
				StringTokenizer stPreselect_ord_type = new StringTokenizer(preselect_ord_type,"~");
				StringTokenizer stfuture_order = new StringTokenizer(future_order,"~");
				StringTokenizer stfutureorderduration = new StringTokenizer(futureorderduration,"~");
				StringTokenizer stFloor_to_start_day_yn = new StringTokenizer(floor_to_start_day_yn,"~");

				traceVals.append("**** stPreselect_ord_type : "+stPreselect_ord_type);

				String patient_classValue = "";
				String time_based_ruleValue = "";
				String expiry_ruleValue = "";
				String preselect_ord_typeValue = "";
				String future_orderValue = "";
				String futureorderdurationValue = "";
				String floor_to_start_day_ynValue = "";
				int count = 0;

				while(stPatient_class.hasMoreTokens()){


						patient_classValue = stPatient_class.nextToken();
						pstmt_ordering_rule.setString( 2, (String) patient_classValue ) ;

						preselect_ord_typeValue = stPreselect_ord_type.nextToken();
						pstmt_ordering_rule.setString( 3, (String) preselect_ord_typeValue ) ;

						traceVals.append("**** preselect_ord_typeValue : "+preselect_ord_typeValue);


						time_based_ruleValue = stTime_based_rule.nextToken();
					    if(time_based_ruleValue.equals(" ") || time_based_ruleValue == " "){
					    	time_based_ruleValue = null;
						}
						pstmt_ordering_rule.setString( 4, (String) time_based_ruleValue ) ;

						expiry_ruleValue = stExpiry_rule.nextToken();
					    if(expiry_ruleValue.equals(" ") || expiry_ruleValue == " "){
					    	expiry_ruleValue = null;
						}
						pstmt_ordering_rule.setString( 5, (String) expiry_ruleValue ) ;

						future_orderValue = stfuture_order.nextToken();
					    if(future_orderValue.equals(" ") || future_orderValue == " "){
					    	future_orderValue = null;
						}
						pstmt_ordering_rule.setString( 6, (String) future_orderValue ) ;

						futureorderdurationValue = stfutureorderduration.nextToken();
					    if(futureorderdurationValue.equals(" ") || futureorderdurationValue == " "){
					    	futureorderdurationValue = null;
						}
						pstmt_ordering_rule.setString( 7, (String) futureorderdurationValue ) ;
						floor_to_start_day_ynValue = stFloor_to_start_day_yn.nextToken();
					    if(floor_to_start_day_ynValue.equals(" ") || floor_to_start_day_ynValue == " "){
					    	floor_to_start_day_ynValue = null;
						}
						pstmt_ordering_rule.setString( 8, (String) floor_to_start_day_ynValue ) ;


						pstmt_ordering_rule.setString( 1, (String) order_category ) ;

						pstmt_ordering_rule.setString( 9, (String) tabData.get( "added_by_id" ) ) ;
						pstmt_ordering_rule.setString( 10, (String) tabData.get( "added_at_ws_no" ) ) ;
						pstmt_ordering_rule.setString( 11, (String) tabData.get( "added_facility_id" ) ) ;
						pstmt_ordering_rule.setString( 12, (String) tabData.get( "modified_by_id" ) ) ;
						pstmt_ordering_rule.setString( 13, (String) tabData.get( "modified_at_ws_no" ) ) ;
						pstmt_ordering_rule.setString( 14, (String) tabData.get( "modified_facility_id" ) ) ;

						traceVals.append("-- before execute bottom frame--");
						pstmt_ordering_rule.addBatch() ;
						count++;
						traceVals.append("-- after execute bottom frame--");
				}
						traceVals.append("***** Before batch update*** count --"+count);
						result = pstmt_ordering_rule.executeBatch() ;
						traceVals.append("******** result length --"+result.length);


					if ( result.length < 1 ) {
						context.setRollbackOnly();
						messages.append( "Insert Failed" ) ;
					}
					if(result.length >= 1){
							connection.commit() ;
							map.put( "result", new Boolean( true ) ) ;
							map.put( "message", "Operation Completed Successfully..." ) ;
							//messages.append( "Operation Completed Successfully..." ) ;
							messages.append( "RECORD_INSERTED" ) ;
					}
			}
		 } catch( Exception e ) {
			traceVals.append("Exception if any -- "+e);

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
				if ( pstmt_ordering_rule != null ) {
					closeStatement(pstmt_ordering_rule);
			}
				if(connection != null) {
					closeConnection(connection,(Properties)tabData.get( "properties" ));
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


