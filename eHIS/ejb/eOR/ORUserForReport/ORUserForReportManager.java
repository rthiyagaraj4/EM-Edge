/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.ORUserForReport ;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import javax.ejb.* ;

import eOR.Common.* ;

/**
*
* @ejb.bean
*	name="ORUserForReport"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORUserForReport"
*	local-jndi-name="ORUserForReport"
*	impl-class-name="eOR.ORUserForReport.ORUserForReportManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORUserForReport.ORUserForReportLocal"
*	remote-class="eOR.ORUserForReport.ORUserForReportRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORUserForReport.ORUserForReportLocalHome"
*	remote-class="eOR.ORUserForReport.ORUserForReportHome"
*	generate= "local,remote"
*
*
*/

public class ORUserForReportManager extends OrEJBSessionAdapter {
    SessionContext context ;

    protected StringBuffer traceVals = new StringBuffer();
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap insert( HashMap tabData, HashMap sqlMap ){
		Connection connection = null ;
		PreparedStatement pstmt_insert_user_report = null ;
		PreparedStatement pstmt_insert_user_orderable = null ;
		//StringBuffer traceVals = new StringBuffer();
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;

		traceVals.append("---------------INSERT----------------------");
		traceVals.append("first line");
		int inserted = 0;
		int inserted_orderable=0;
		int inserted_listvalues=0;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;

		try {
			connection = getConnection((Properties)tabData.get( "properties" ) ) ;

			final String USER_FOR_REPORTING_INSERT = (String) sqlMap.get( "USER_FOR_REPORTING_INSERT" ) ;
			pstmt_insert_user_report		= connection.prepareStatement( USER_FOR_REPORTING_INSERT ) ;
			traceVals.append("in EJB : "+USER_FOR_REPORTING_INSERT);

			String responsibility = (String) tabData.get("responsibility") ;
			String practitioner =  (String) tabData.get("practitioner");
			String security_level = (String) tabData.get("security_level") ;

			if(responsibility.equals("") || responsibility.equals(" ") ){
				responsibility= null;
			}
			if(practitioner.equals("") || practitioner.equals(" ") ){
				practitioner= null;
			}

			if(security_level.equals("") || security_level.equals(" ") ){
				security_level= null;
			}


			traceVals.append("in EJB responsibility: "+responsibility+"  == practitioner "+practitioner);

			pstmt_insert_user_report.setString( 1, responsibility) ;
			pstmt_insert_user_report.setString( 2, practitioner) ;
			pstmt_insert_user_report.setString( 3, (String) tabData.get("order_category") ) ;
			pstmt_insert_user_report.setString( 4, (String) tabData.get("order_type") ) ;
			pstmt_insert_user_report.setString( 5, (String) tabData.get("privilege") ) ;
			pstmt_insert_user_report.setString( 6, security_level) ;

			pstmt_insert_user_report.setString( 7, (String) tabData.get( "added_by_id" ) ) ;
			//pstmt_insert_user_report.setString( 8, (String) tabData.get( "added_date" ) ) ;
			pstmt_insert_user_report.setString( 8, (String) tabData.get( "added_at_ws_no" ) ) ;
			pstmt_insert_user_report.setString( 9, (String) tabData.get( "added_facility_id" ) ) ;
			pstmt_insert_user_report.setString( 10, (String) tabData.get( "modified_by_id" ) ) ;
			//pstmt_insert_user_report.setString( 12, (String) tabData.get( "modified_date" ) ) ;
			pstmt_insert_user_report.setString( 11, (String) tabData.get( "modified_at_ws_no" ) ) ;
			pstmt_insert_user_report.setString( 12, (String) tabData.get( "modified_facility_id" ) ) ;
			pstmt_insert_user_report.setString( 13, (String) tabData.get( "rist_perform_loc_chk_val" ) ) ;

			traceVals.append("-- before execute --");
			inserted = pstmt_insert_user_report.executeUpdate() ;
			traceVals.append("-- after execute --");

			traceVals.append("after first insert "+inserted);

		
			if ( inserted < 1 ) {
				traceVals.append("----before rollback---- "+inserted);
				connection.rollback() ;
				messages.append( "Insert Failed" ) ;
				traceVals.append("----after rollback---- "+inserted);
			} else if(inserted >=1){
				traceVals.append("--before calling 2nd insert");
				//inserted = 0;
				//if (((String) tabData.get("rist_perform_loc_chk_val")).equalsIgnoreCase("Y"))
					inserted_listvalues = insertListValues(tabData, sqlMap,connection);
					traceVals.append("----after execute---- "+inserted_listvalues);
/*****************************************************************************************/
				
			final String SQL_OR_RESULT_REPORTING_RESULT_CATALOG_INSERT = (String) sqlMap.get( "SQL_OR_RESULT_REPORTING_RESULT_CATALOG_INSERT" ) ;
			pstmt_insert_user_orderable		= connection.prepareStatement( SQL_OR_RESULT_REPORTING_RESULT_CATALOG_INSERT ) ;
			traceVals.append("in EJB : "+SQL_OR_RESULT_REPORTING_RESULT_CATALOG_INSERT);
									
			traceVals.append("in EJB responsibility: "+responsibility+"  == practitioner "+practitioner);
			traceVals.append("before orderable insert "+inserted);

			String catalog_description = (String) tabData.get( "catalog_desc" ) ;
			if(catalog_description != null){
					StringTokenizer st1		= new StringTokenizer(catalog_description,",");
					String			catalog_desc = "";
				while(st1.hasMoreTokens()){
					
					catalog_desc = (String) st1.nextToken();
					pstmt_insert_user_orderable.setString( 5, catalog_desc ) ;

			pstmt_insert_user_orderable.setString( 1, responsibility) ;
			pstmt_insert_user_orderable.setString( 2, practitioner) ;
			pstmt_insert_user_orderable.setString( 3, (String) tabData.get("order_category") ) ;
			pstmt_insert_user_orderable.setString( 4, (String) tabData.get("order_type") ) ;

			pstmt_insert_user_orderable.setString( 6, (String) tabData.get( "added_by_id" ) ) ;
			pstmt_insert_user_orderable.setString( 7, (String) tabData.get( "added_at_ws_no" ) ) ;
			pstmt_insert_user_orderable.setString( 8, (String) tabData.get( "added_facility_id" ) ) ;
			pstmt_insert_user_orderable.setString( 9, (String) tabData.get( "modified_by_id" ) ) ;
			//pstmt_insert_user_report.setString( 12, (String) tabData.get( "modified_date" ) ) ;
			pstmt_insert_user_orderable.setString( 10, (String) tabData.get( "modified_at_ws_no" ) ) ;
			pstmt_insert_user_orderable.setString( 11, (String) tabData.get( "modified_facility_id" ) ) ;
					
			traceVals.append("-- before execute --");
			inserted_orderable = pstmt_insert_user_orderable.executeUpdate() ;
			traceVals.append("-- after execute --"+inserted_orderable);

			traceVals.append("----after first insert orderable---- "+inserted);
			}
		}
	}	
	
/*****************************************************************************************/
				if (inserted < 0) {
					traceVals.append("----before rollback 1---- "+inserted);
                    connection.rollback();
                    messages.append( "Insert Failed" );
					traceVals.append("----after rollback 1---- "+inserted);
				} else if (inserted >= 0) {
					traceVals.append("----before commit---- "+inserted);
					connection.commit() ;
					map.put( "result", new Boolean( true ) ) ;
					map.put( "message", "Operation Completed Successfully..." ) ;
					messages.append( "RECORD_INSERTED" ) ;
					traceVals.append("----after commit---- "+inserted);
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
				if ( pstmt_insert_user_report != null ) {
					closeStatement(pstmt_insert_user_report);
					pstmt_insert_user_report = null ;
				}
				if ( pstmt_insert_user_orderable != null ) {
					closeStatement(pstmt_insert_user_orderable);
					pstmt_insert_user_orderable = null ;
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
		PreparedStatement pstmt_update_user_report = null ;
		PreparedStatement pstmt_update_user_report_orderable = null ;
		PreparedStatement pstmt_delete_user_report_orderable=null;


		//StringBuffer traceVals = new StringBuffer();
		traceVals.append("-------------------MODIFY1------------------");
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;

		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;

		traceVals.append("-------------------MODIFY2------------------");
		traceVals.append("first line");
		int inserted = 0;
		int inserted_orderable=0;
		int inserted_del_orderable=0;
		int inserted_listvalues=0;
		try {
			connection = getConnection((Properties)tabData.get( "properties" ) ) ;
			String rsp_id =(String) tabData.get("responsibility");
			   if(rsp_id.equals(" ") || rsp_id.equals("") || rsp_id == " " ){
					rsp_id = null;
				}
			String prct_id =  (String) tabData.get("practitioner") ;
			   if(prct_id.equals(" ") || prct_id.equals("") || prct_id == " " ){
					prct_id = null;
				}

			

			final String USER_FOR_REPORTING_UPDATE = (String) sqlMap.get( "USER_FOR_REPORTING_UPDATE" ) ;
			traceVals.append("Update Qry : "+USER_FOR_REPORTING_UPDATE);
			pstmt_update_user_report		= connection.prepareStatement( USER_FOR_REPORTING_UPDATE ) ;

			pstmt_update_user_report.setString( 1, (String) tabData.get("privilege") ) ;
			pstmt_update_user_report.setString( 2, (String) tabData.get("security_level") ) ;

			pstmt_update_user_report.setString( 3, (String) tabData.get( "modified_by_id" ) ) ;
			//pstmt_update_user_report.setString( 4, (String) tabData.get( "modified_date" ) ) ;
			pstmt_update_user_report.setString( 4, (String) tabData.get( "modified_at_ws_no" ) ) ;
			pstmt_update_user_report.setString( 5, (String) tabData.get( "modified_facility_id" ) ) ;
			pstmt_update_user_report.setString( 6,  (String) tabData.get("rist_perform_loc_chk_val") ) ;
			pstmt_update_user_report.setString( 7, (String) tabData.get("responsibility_id") ) ;
			pstmt_update_user_report.setString( 8, rsp_id) ;
			pstmt_update_user_report.setString( 9,  (String) tabData.get("responsibility_id") ) ;
			pstmt_update_user_report.setString( 10, prct_id) ;
			pstmt_update_user_report.setString( 11,  (String) tabData.get("order_category") ) ;


			traceVals.append("-- before execute --");
			inserted = pstmt_update_user_report.executeUpdate() ;
			traceVals.append("-- after execute --");

			traceVals.append("after Update "+inserted);

			if ( inserted < 1 ) {
				connection.rollback() ;
				messages.append( "Updation Failed" ) ;
			}
			
/*****************************************************************************/
			if(inserted >=1){
				String catalog_description = (String) tabData.get( "catalog_desc" ) ;

		
			
			if(catalog_description !=""){
				

			final String SQL_OR_RESULT_REPORTING_RESULT_CATALOG_DELETE = (String) sqlMap.get( "SQL_OR_RESULT_REPORTING_RESULT_CATALOG_DELETE" ) ;
			pstmt_delete_user_report_orderable		= connection.prepareStatement( SQL_OR_RESULT_REPORTING_RESULT_CATALOG_DELETE ) ;

			pstmt_delete_user_report_orderable.setString(1, rsp_id);
			pstmt_delete_user_report_orderable.setString(2, prct_id);
			pstmt_delete_user_report_orderable.setString(3, (String) tabData.get("order_category"));
			pstmt_delete_user_report_orderable.setString(4, (String) tabData.get("order_type") ) ;

			traceVals.append("-- before execute delete_modify--");
			inserted_del_orderable = pstmt_delete_user_report_orderable.executeUpdate() ;
			traceVals.append("-- after execute delete_modify---");

			traceVals.append("after first delete_modify "+inserted_del_orderable);
		
			}

	
		if(catalog_description !=""){

			final String SQL_OR_RESULT_REPORTING_RESULT_CATALOG_INSERT = (String) sqlMap.get( "SQL_OR_RESULT_REPORTING_RESULT_CATALOG_INSERT" ) ;
			pstmt_update_user_report_orderable		= connection.prepareStatement( SQL_OR_RESULT_REPORTING_RESULT_CATALOG_INSERT ) ;
			traceVals.append("in EJB : "+SQL_OR_RESULT_REPORTING_RESULT_CATALOG_INSERT);
							
						
			if(catalog_description != null){
					StringTokenizer st1		= new StringTokenizer(catalog_description,",");
					String			catalog_desc = "";
				while(st1.hasMoreTokens()){
					
					catalog_desc = (String) st1.nextToken();
					pstmt_update_user_report_orderable.setString( 5, catalog_desc ) ;

			pstmt_update_user_report_orderable.setString( 1, rsp_id) ;
			pstmt_update_user_report_orderable.setString( 2, prct_id) ;
			pstmt_update_user_report_orderable.setString( 3, (String) tabData.get("order_category") ) ;
			pstmt_update_user_report_orderable.setString( 4, (String) tabData.get("order_type") ) ;

			pstmt_update_user_report_orderable.setString( 6, (String) tabData.get( "added_by_id" ) ) ;
			pstmt_update_user_report_orderable.setString( 7, (String) tabData.get( "added_at_ws_no" ) ) ;
			pstmt_update_user_report_orderable.setString( 8, (String) tabData.get( "added_facility_id" ) ) ;
			pstmt_update_user_report_orderable.setString( 9, (String) tabData.get( "modified_by_id" ) ) ;
			//pstmt_insert_user_report.setString( 12, (String) tabData.get( "modified_date" ) ) ;
			pstmt_update_user_report_orderable.setString( 10, (String) tabData.get( "modified_at_ws_no" ) ) ;
			pstmt_update_user_report_orderable.setString( 11, (String) tabData.get( "modified_facility_id" ) ) ;
					
		
			traceVals.append("-- before execute insert_modify --");
			inserted_orderable = pstmt_update_user_report_orderable.executeUpdate() ;
			traceVals.append("-- after execute insert_modify--");

			traceVals.append("after first insert_orderable_update "+inserted_orderable);
			}
		
		traceVals.append("--before calling 2nd insert");
		
			}
		}

	}
			


/*****************************************************************************/
	
		if(inserted >=1){
			traceVals.append("--before calling 2nd insert");
			//inserted = 0;
			//if (((String) tabData.get("rist_perform_loc_chk_val")).equalsIgnoreCase("Y"))
					traceVals.append(" ---tabData----:"+tabData);
					traceVals.append(" ---sqlMap---:"+sqlMap);
					traceVals.append(" ---connection---:"+connection);

				inserted_listvalues = insertListValues(tabData, sqlMap,connection);
				traceVals.append("--after calling 2nd insert--"+inserted_listvalues);
			if (inserted < 0) {
				connection.rollback();
				messages.append( "Insert Failed" );
			} else if (inserted >= 0) {
				connection.commit() ;
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", "Operation Completed Successfully..." ) ;
				messages.append( "RECORD_MODIFIED" ) ;
				//messages.append( "Operation Completed Successfully..." ) ;
			}
		}
	 } catch( Exception e ) {
		traceVals.append("Exception if any in  modify -- "+e);

		messages.append( e.getMessage() ) ;
		System.err.println(e.getMessage() );
		e.printStackTrace() ;
	} finally {
		try {

			if ( pstmt_update_user_report != null ) {
				closeStatement(pstmt_update_user_report);
			}
			if ( pstmt_update_user_report_orderable != null ) {
				closeStatement(pstmt_update_user_report_orderable);
			}
			if ( pstmt_delete_user_report_orderable != null ) {
				closeStatement(pstmt_delete_user_report_orderable);
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
		Connection connection = null ;
		PreparedStatement pstmt_update_user_report = null ;
		PreparedStatement pstmt_delete_user_report_list_dtl	= null;
		PreparedStatement pstmt_delete_user_report_orderable= null;
		StringBuffer traceVals = new StringBuffer();
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;

		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;

		int inserted = 0;
			traceVals.append("-------------------delete1------------------");
		try {
			connection = getConnection((Properties)tabData.get( "properties" ) ) ;

			String rsp_id =(String) tabData.get("responsibility");
			   if(rsp_id.equals(" ") || rsp_id.equals("") || rsp_id == " " ){
					rsp_id = null;
				}
			String prct_id =  (String) tabData.get("practitioner") ;
			   if(prct_id.equals(" ") || prct_id.equals("") || prct_id == " " ){
					prct_id = null;
				}

			final String SQL_OR_USRE_FOR_REPORTING_PERFORM_LOCN_DELETE = (String) sqlMap.get( "SQL_OR_USRE_FOR_REPORTING_PERFORM_LOCN_DELETE" ) ;

			pstmt_delete_user_report_list_dtl = connection.prepareStatement( SQL_OR_USRE_FOR_REPORTING_PERFORM_LOCN_DELETE ) ;

			pstmt_delete_user_report_list_dtl.setString(1, (String) tabData.get("responsibility_id"));
			pstmt_delete_user_report_list_dtl.setString(2, (String) tabData.get("responsibility"));
			pstmt_delete_user_report_list_dtl.setString(3, (String) tabData.get("responsibility_id"));
			pstmt_delete_user_report_list_dtl.setString(4, (String) tabData.get("practitioner"));
			pstmt_delete_user_report_list_dtl.setString(5, (String)tabData.get("order_category"));
			pstmt_delete_user_report_list_dtl.executeUpdate();

			traceVals.append("-------------after_delete_locn------------");

			final String SQL_OR_RESULT_REPORTING_RESULT_CATALOG_DELETE = (String) sqlMap.get( "SQL_OR_RESULT_REPORTING_RESULT_CATALOG_DELETE" ) ;
			pstmt_delete_user_report_orderable		= connection.prepareStatement( SQL_OR_RESULT_REPORTING_RESULT_CATALOG_DELETE ) ;
						
			pstmt_delete_user_report_orderable.setString(1, rsp_id);
			pstmt_delete_user_report_orderable.setString(2, prct_id);
			pstmt_delete_user_report_orderable.setString(3, (String) tabData.get("order_category"));
			pstmt_delete_user_report_orderable.setString(4, (String) tabData.get("order_type") ) ;

			traceVals.append("-- before execute_orderable --");
			pstmt_delete_user_report_orderable.executeUpdate() ;
			traceVals.append("-- after execute_orderable --");

			traceVals.append("after first delete orderable "+inserted);


			final String USER_FOR_REPORTING_DELETE = (String) sqlMap.get( "USER_FOR_REPORTING_DELETE" ) ;
			pstmt_update_user_report		= connection.prepareStatement( USER_FOR_REPORTING_DELETE ) ;

			pstmt_update_user_report.setString( 1, (String) tabData.get("responsibility_id") ) ;
			pstmt_update_user_report.setString( 2, rsp_id) ;
			pstmt_update_user_report.setString( 3, (String) tabData.get("responsibility_id") ) ;
			pstmt_update_user_report.setString( 4, prct_id) ;
			pstmt_update_user_report.setString( 5, (String) tabData.get("order_category") ) ;
			pstmt_update_user_report.setString( 6, (String) tabData.get("order_type") ) ;

			traceVals.append("-- before execute_celete_main --");
			inserted = pstmt_update_user_report.executeUpdate() ;
			traceVals.append("-- after execute_delete_main --");

			traceVals.append("after first delete "+inserted);

			


			if ( inserted < 1 ) {
				connection.rollback() ;
				messages.append( "Delete Failed" ) ;
			}else{
					connection.commit() ;
					map.put( "result", new Boolean( true ) ) ;
					map.put( "message", "Operation Completed Successfully..." ) ;
					messages.append( "RECORD_DELETED" ) ;
					//messages.append( "Operation Completed Successfully..." ) ;
			}
		 } catch( Exception e ) {
			traceVals.append("Exception if any -- "+e);

			messages.append( e.getMessage() ) ;
			System.err.println(e.getMessage() );
			e.printStackTrace() ;
		} finally {
			try {

				if ( pstmt_delete_user_report_list_dtl != null ) {
					closeStatement(pstmt_delete_user_report_list_dtl);
				}
				if ( pstmt_update_user_report != null ) {
					closeStatement(pstmt_update_user_report);
				}
				if ( pstmt_delete_user_report_orderable != null ) {
					closeStatement(pstmt_delete_user_report_orderable);
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

	private int insertListValues(HashMap tabData, HashMap sqlMap,Connection connection ) {
						
		
		traceVals.append(" ---just inside 2nd isnert: ");
		StringBuffer messages = new StringBuffer() ;
		PreparedStatement pstmt_insert_user_report_list_dtl = null;
		PreparedStatement pstmt_delete_user_report_list_dtl	= null;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;

		int result=0;

		try {
				String listValues = (String) tabData.get( "listValues" ) ;
				//System.out.println("!@#$tabdata_insert:"+listValues);
				traceVals.append("*** listValues ::: "+listValues);
				
                final String SQL_OR_USRE_FOR_REPORTING_PERFORM_LOCN_DELETE = (String) sqlMap.get( "SQL_OR_USRE_FOR_REPORTING_PERFORM_LOCN_DELETE" ) ;

				pstmt_delete_user_report_list_dtl = connection.prepareStatement( SQL_OR_USRE_FOR_REPORTING_PERFORM_LOCN_DELETE ) ;
				pstmt_delete_user_report_list_dtl.setString(1, (String) tabData.get("responsibility_id"));
				pstmt_delete_user_report_list_dtl.setString(2, (String) tabData.get("responsibility"));
				pstmt_delete_user_report_list_dtl.setString(3, (String) tabData.get("responsibility_id"));
				pstmt_delete_user_report_list_dtl.setString(4, (String) tabData.get("practitioner"));
				pstmt_delete_user_report_list_dtl.setString(5, (String)tabData.get("order_category"));
				pstmt_delete_user_report_list_dtl.executeUpdate();

				traceVals.append("*** After execute delete dtl ::: ");

				if(pstmt_insert_user_report_list_dtl != null)
					closeStatement(pstmt_insert_user_report_list_dtl);
				final String SQL_OR_USER_FOR_REPORTING_PERFORM_LOCN_INSERT = (String) sqlMap.get( "SQL_OR_USER_FOR_REPORTING_PERFORM_LOCN_INSERT" ) ;
				
				pstmt_insert_user_report_list_dtl		= connection.prepareStatement( SQL_OR_USER_FOR_REPORTING_PERFORM_LOCN_INSERT ) ;

				pstmt_insert_user_report_list_dtl.setString( 1, (String) tabData.get("responsibility")) ;
				pstmt_insert_user_report_list_dtl.setString( 2, (String) tabData.get("practitioner"));

				pstmt_insert_user_report_list_dtl.setString( 6, (String) tabData.get( "added_by_id" ) ) ;
				pstmt_insert_user_report_list_dtl.setString( 7, (String) tabData.get( "added_at_ws_no" ) ) ;
				pstmt_insert_user_report_list_dtl.setString( 8, (String) tabData.get( "added_facility_id" ) ) ;
				pstmt_insert_user_report_list_dtl.setString( 9, (String) tabData.get( "modified_by_id" ) ) ;
				pstmt_insert_user_report_list_dtl.setString( 10, (String) tabData.get( "modified_at_ws_no" ) ) ;
				pstmt_insert_user_report_list_dtl.setString( 11, (String) tabData.get( "modified_facility_id" ) ) ;

				if(listValues != null){
					StringTokenizer st1		= new StringTokenizer(listValues,"`");
					String			mainStr = "";
					//String			subStr	= "";
					StringTokenizer st2=null;
					String performing_facility_id = "";
					String performing_deptloc_code = "";
					while(st1.hasMoreTokens()){

						mainStr  = st1.nextToken();
						st2 = new StringTokenizer(mainStr,"~");
						
						//String performing_deptloc_name = "";
						//String performing_facility_name = "";

						traceVals.append("---main token "+mainStr);

						performing_facility_id = (String) st2.nextToken();
						st2.nextToken();
						//performing_facility_name = (String) st2.nextToken();
						performing_deptloc_code = (String) st2.nextToken();
						st2.nextToken();
						//performing_deptloc_name = (String) st2.nextToken();
						pstmt_insert_user_report_list_dtl.setString( 3,  performing_facility_id ) ;
						pstmt_insert_user_report_list_dtl.setString( 4,	 (String)tabData.get("order_category"));
						traceVals.append("order_category"+((String)tabData.get("order_category")));
						pstmt_insert_user_report_list_dtl.setString( 5,  performing_deptloc_code) ;
						result = pstmt_insert_user_report_list_dtl.executeUpdate() ;
						traceVals.append("-- after execute --");
					}
				}


		 } catch( Exception e ) {
			traceVals.append("Exception if any -- "+e);
			result = -1;
			messages.append( e.getMessage() ) ;
			System.err.println(e.getMessage() );
			e.printStackTrace() ;
		} finally {
			try {
				if ( pstmt_delete_user_report_list_dtl != null ) {
					closeStatement(pstmt_delete_user_report_list_dtl);
				}
				if ( pstmt_insert_user_report_list_dtl != null ) {
					closeStatement(pstmt_insert_user_report_list_dtl);
				}
			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		return result;

	}
}
