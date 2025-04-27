 /*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

26/04/2023  40016           Ranjith P R       2/04/2023         Ramesh Goli        ML-MMOH-CRF-1823                 
----------------------------------------------------------------------------------------------------------------------------------------------------------	
 */
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.ORUserForReview ;
import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import javax.ejb.* ;

import eOR.Common.* ;

/**
*
* @ejb.bean
*	name="ORUserForReview"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORUserForReview"
*	local-jndi-name="ORUserForReview"
*	impl-class-name="eOR.ORUserForReview.ORUserForReviewManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORUserForReview.ORUserForReviewLocal"
*	remote-class="eOR.ORUserForReview.ORUserForReviewRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORUserForReview.ORUserForReviewLocalHome"
*	remote-class="eOR.ORUserForReview.ORUserForReviewHome"
*	generate= "local,remote"
*
*
*/

public class ORUserForReviewManager extends OrEJBSessionAdapter {
   // SessionContext context ;

	/**
* @ejb.interface-method
*	 view-type="both"
*/
		
		public HashMap insert( HashMap tabData, HashMap sqlMap ) {
			Connection connection = null ;
			PreparedStatement pstmt_insert_user_report = null ;
			StringBuffer traceVals = new StringBuffer();
			StringBuffer messages = new StringBuffer() ;
			HashMap map = new HashMap() ;

			//System.out.println("---------------INSERTING ----- ----------------------");
			traceVals.append("first line");
			int inserted[];
			map.put( "result", new Boolean( false ) ) ;
			map.put( "flag", "") ;
			map.put( "callOnSuccess", new Boolean( false ) ) ;

			try {
				connection = getConnection((Properties)tabData.get( "properties" ) ) ;

				final String SQL_OR_USER_FOR_REVIEW_INSERT = (String) sqlMap.get( "SQL_OR_USER_FOR_REVIEW_INSERT" ) ;
				pstmt_insert_user_report		= connection.prepareStatement( SQL_OR_USER_FOR_REVIEW_INSERT ) ;
				traceVals.append("in EJB : "+SQL_OR_USER_FOR_REVIEW_INSERT);

				String responsibility = (String) tabData.get("responsibility") ;
				String practitioner =  (String) tabData.get("practitioner");

				if(responsibility.equals("") || responsibility.equals(" ") ){
					responsibility= null;
				}
				if(practitioner.equals("") || practitioner.equals(" ") ){
					practitioner= null;
				}


				traceVals.append("in EJB responsibility: "+responsibility+"  == practitioner "+practitioner);

				String order_category = (String)tabData.get("order_category");
				String auth_yn = (String)tabData.get("auth_yn");
				String cosign_yn = (String)tabData.get("cosign_yn");
				String spl_appr_yn = (String)tabData.get("spl_appr_yn");
				String quota_limit_yn = (String)tabData.get("quota_limit_yn");//40016


				StringTokenizer stOrder_category= new StringTokenizer(order_category,"~");
				StringTokenizer stAuth_yn = new StringTokenizer(auth_yn,"~");
				StringTokenizer stcosign_yn = new StringTokenizer(cosign_yn,"~");
				StringTokenizer stSpl_appr_yn = new StringTokenizer(spl_appr_yn,"~");
				StringTokenizer stQuota_limit_yn = new StringTokenizer(quota_limit_yn,"~");//40016

				String order_categoryValue = "";
				String auth_ynValue = "";
				String cosign_ynValue = "";
				String spl_appr_ynValue = "";
				String quota_limit_ynValue = "";//40016


				while(stOrder_category.hasMoreTokens()){

						order_categoryValue = stOrder_category.nextToken();
						auth_ynValue = stAuth_yn.nextToken();
						cosign_ynValue = stcosign_yn.nextToken();
						spl_appr_ynValue = stSpl_appr_yn.nextToken();
						quota_limit_ynValue = stQuota_limit_yn.nextToken();//40016

						pstmt_insert_user_report.setString( 1, responsibility) ;
						pstmt_insert_user_report.setString( 2, practitioner) ;
						pstmt_insert_user_report.setString( 3, (String) order_categoryValue ) ;
						pstmt_insert_user_report.setString( 4, (String) auth_ynValue ) ;
						pstmt_insert_user_report.setString( 5, (String) cosign_ynValue ) ;
						//pstmt_insert_user_report.setString( 5, "N" ) ;
						pstmt_insert_user_report.setString( 6, (String) spl_appr_ynValue ) ;

						pstmt_insert_user_report.setString( 7, (String) tabData.get( "added_by_id" ) ) ;
						pstmt_insert_user_report.setString( 8, (String) tabData.get( "added_at_ws_no" ) ) ;
						pstmt_insert_user_report.setString( 9, (String) tabData.get( "added_facility_id" ) ) ;
						pstmt_insert_user_report.setString( 10, (String) tabData.get( "modified_by_id" ) ) ;
						pstmt_insert_user_report.setString( 11, (String) tabData.get( "modified_at_ws_no" ) ) ;
						pstmt_insert_user_report.setString( 12, (String) tabData.get( "modified_facility_id" ) ) ;
						pstmt_insert_user_report.setString( 13, (String)quota_limit_ynValue ) ;//40016

						/*System.out.println("++++++++ in EJB +++++++:");
						System.out.println("--after --order_category  :"+order_categoryValue);
						System.out.println("-- authorise : "+auth_ynValue);
						System.out.println("--after --co_sign  :"+cosign_ynValue);
						System.out.println("-- sp_apprv : "+spl_appr_ynValue);
						System.out.println("++++++++ in EJB +++++++:");*/


						traceVals.append("-- before execute --");
						pstmt_insert_user_report.addBatch() ;
				}
				inserted = pstmt_insert_user_report.executeBatch() ;
				//System.out.println("***inserted value : "+inserted);

				if ( inserted.length < 1 ) {
					connection.rollback() ;
					messages.append( "Insert Failed" ) ;
				}
				if(inserted.length >=1){

						connection.commit() ;
						map.put( "result", new Boolean( true ) ) ;
						map.put( "message", "Operation Completed Successfully..." ) ;
						messages.append( "RECORD_INSERTED" ) ;
				}
			 } catch( Exception e ) {
				//context.setRollbackOnly();
				messages.append( e.getMessage() ) ;
				System.err.println(e.getMessage() );
				e.printStackTrace() ;
			} finally {
				try {
					if ( pstmt_insert_user_report != null ) {
						closeStatement(pstmt_insert_user_report);
						pstmt_insert_user_report = null ;
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
			StringBuffer traceVals = new StringBuffer();
			StringBuffer messages = new StringBuffer() ;
			HashMap map = new HashMap() ;
			//int rows_updated = 0;

			traceVals.append("---------------MODIFY----------------------");
			traceVals.append("first line");
			int inserted = 0;
			boolean commit_yn = true;
			map.put( "result", new Boolean( false ) ) ;
			map.put( "flag", "") ;
			map.put( "callOnSuccess", new Boolean( false ) ) ;

			try {
				connection = getConnection((Properties)tabData.get( "properties" ) ) ;

				final String SQL_OR_USER_FOR_REVIEW_UPDATE = (String) sqlMap.get( "SQL_OR_USER_FOR_REVIEW_UPDATE" ) ;
				pstmt_update_user_report		= connection.prepareStatement( SQL_OR_USER_FOR_REVIEW_UPDATE ) ;
				traceVals.append("in EJB : "+SQL_OR_USER_FOR_REVIEW_UPDATE);
				//System.out.println("SQL in EJB : "+SQL_OR_USER_FOR_REVIEW_UPDATE);

				String responsibility_id = (String) tabData.get("responsibility_id") ;
				String responsibility = (String) tabData.get("responsibility") ;
				String practitioner =  (String) tabData.get("practitioner");

				String rsp_id =(String) tabData.get("responsibility");
				   if(rsp_id.equals(" ") || rsp_id.equals("") || rsp_id == " " ){
						rsp_id = null;
					}
				String prct_id =  (String) tabData.get("practitioner") ;
				   if(prct_id.equals(" ") || prct_id.equals("") || prct_id == " " ){
						prct_id = null;
					}


				traceVals.append("in EJB responsibility: "+responsibility+"  == practitioner "+practitioner);



				String order_category = (String)tabData.get("order_category");
				String auth_yn = (String)tabData.get("auth_yn");
				String cosign_yn = (String)tabData.get("cosign_yn");
				String spl_appr_yn = (String)tabData.get("spl_appr_yn");
				String quota_limit_yn = (String)tabData.get("quota_limit_yn");//40016


				StringTokenizer storder_category = new StringTokenizer(order_category,"~");
				StringTokenizer stAuth_yn = new StringTokenizer(auth_yn,"~");
				StringTokenizer stcosign_yn = new StringTokenizer(cosign_yn,"~");
				StringTokenizer stSpl_appr_yn = new StringTokenizer(spl_appr_yn,"~");
				StringTokenizer stQuota_limit_yn = new StringTokenizer(quota_limit_yn,"~");//40016

				String order_categoryValue = "";
				String auth_ynValue = "";
				String cosign_ynValue = "";
				String spl_appr_ynValue = "";
				String quota_limit_ynValue = "";//40016


				while(stAuth_yn.hasMoreTokens()){
						order_categoryValue = storder_category.nextToken();
						auth_ynValue = stAuth_yn.nextToken();
						cosign_ynValue = stcosign_yn.nextToken();
						spl_appr_ynValue = stSpl_appr_yn.nextToken();
						quota_limit_ynValue = stQuota_limit_yn.nextToken();//40016

						pstmt_update_user_report.setString( 1, (String) auth_ynValue ) ;
						pstmt_update_user_report.setString( 2, (String) cosign_ynValue ) ;
						//pstmt_update_user_report.setString( 2, "N") ;
						pstmt_update_user_report.setString( 3, (String) spl_appr_ynValue ) ;
						pstmt_update_user_report.setString( 4, (String) tabData.get( "modified_by_id" ) ) ;
						pstmt_update_user_report.setString( 5, (String) tabData.get( "modified_at_ws_no" ) ) ;
						pstmt_update_user_report.setString( 6, (String) tabData.get( "modified_facility_id" ) ) ;
						pstmt_update_user_report.setString( 7, (String) quota_limit_ynValue ) ;//40016
						pstmt_update_user_report.setString( 8, responsibility_id) ;
						pstmt_update_user_report.setString( 9, rsp_id) ;
						pstmt_update_user_report.setString( 10, responsibility_id) ;
						pstmt_update_user_report.setString( 11, prct_id) ;
						pstmt_update_user_report.setString( 12, (String)order_categoryValue) ;
					

					/*	System.out.println("++++++++ MODIFY in EJB +++++++:");
						System.out.println("-- authorise : "+auth_ynValue);
						System.out.println("-- order_categoryValue : "+order_categoryValue);

						System.out.println("-- sp_apprv : "+spl_appr_ynValue);
						System.out.println("-- responsibility_id : "+responsibility_id);
						System.out.println("----rsp_id  :"+rsp_id);
						System.out.println("-- prct_id : "+prct_id);
						System.out.println("++++++++ in EJB +++++++:");*/


						inserted = pstmt_update_user_report.executeUpdate() ;
						if(inserted<1){
							commit_yn = false;
							break;
						}
				}
				if ( !(commit_yn) ) {
					traceVals.append("***rollback**** :");
					map.put( "result", new Boolean( false ) ) ;
					connection.rollback() ;
					messages.append( "Insert Failed" ) ;
				}else {
						traceVals.append("***Commit**** :");
						connection.commit() ;
						map.put( "result", new Boolean( true ) ) ;
						map.put( "message", "Operation Completed Successfully..." ) ;
						messages.append( "RECORD_MODIFIED" ) ;
				}

			 } catch( Exception e ) {
				//context.setRollbackOnly();
				messages.append( e.getMessage() ) ;
				System.err.println(e.getMessage() );
				e.printStackTrace() ;
			} finally {
				try {
					if ( pstmt_update_user_report != null ) {
						closeStatement(pstmt_update_user_report);
						pstmt_update_user_report = null ;
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
		PreparedStatement pstmt_delete_user_review = null ;
		StringBuffer traceVals = new StringBuffer();
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;

		traceVals.append("---------------- DELETE ---------------------");

		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;

		int inserted = 0;

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
		traceVals.append("++++++++ in EJB +++++++:");
		traceVals.append("----rsp_id  :"+rsp_id);
		traceVals.append("-- prct_id : "+prct_id);
		traceVals.append("++++++++ in EJB +++++++:");

			final String USER_FOR_REVIEW_DELETE = (String) sqlMap.get( "USER_FOR_REVIEW_DELETE" ) ;
		traceVals.append("----USER_FOR_REVIEW_DELETE  :"+USER_FOR_REVIEW_DELETE);
			pstmt_delete_user_review		= connection.prepareStatement( USER_FOR_REVIEW_DELETE ) ;

			pstmt_delete_user_review.setString( 1, (String) tabData.get("responsibility_id") ) ;
			pstmt_delete_user_review.setString( 2, rsp_id) ;
			pstmt_delete_user_review.setString( 3, (String) tabData.get("responsibility_id") ) ;
			pstmt_delete_user_review.setString( 4, prct_id) ;

			traceVals.append("-- before execute --");
			inserted = pstmt_delete_user_review.executeUpdate() ;
			traceVals.append("-- after execute --");

			traceVals.append("after first insert "+inserted);

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
				if ( pstmt_delete_user_review != null ) {
					closeStatement(pstmt_delete_user_review);
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


}


