/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.ORConsentFormat;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
//import oracle.sql.CLOB; //IN037372 
import java.io.* ;

import javax.ejb.* ;
import javax.transaction.* ;

import eOR.Common.* ;

/**
*
* @ejb.bean
*	name="ORConsentFormat"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORConsentFormat"
*	local-jndi-name="ORConsentFormat"
*	impl-class-name="eOR.ORConsentFormat.ORConsentFormManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORConsentFormat.ORConsentFormLocal"
*	remote-class="eOR.ORConsentFormat.ORConsentFormRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORConsentFormat.ORConsentFormLocalHome"
*	remote-class="eOR.ORConsentFormat.ORConsentFormHome"
*	generate= "local,remote"
*
*
*/

public class ORConsentFormManager extends OrEJBSessionAdapter {
    //SessionContext context ;

	StringBuffer traceVals = new StringBuffer();

/**
* @ejb.interface-method
*	 view-type="both"
*/

	public HashMap insert( HashMap tabData, HashMap sqlMap ) {

		Connection connection = null ;
		PreparedStatement pstmt_update_duration = null ;
		PreparedStatement pstmt_clob = null;

		traceVals = new StringBuffer();
		StringBuffer messages = new StringBuffer() ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;

		final String SQL_OR_CONSENT_FORM_INSERT = (String) sqlMap.get( "SQL_OR_CONSENT_FORM_INSERT" ) ;
		final String SQL_OR_CONSENT_FORM_UPDATE_CLOB = (String) sqlMap.get("SQL_OR_CONSENT_FORM_UPDATE_CLOB");
		traceVals.append("before try -- "+SQL_OR_CONSENT_FORM_INSERT);
		traceVals.append("before try -- " + SQL_OR_CONSENT_FORM_UPDATE_CLOB);

		int result=0;
		try {
			connection = getConnection((Properties)tabData.get( "properties" ) ) ;
			connection.setAutoCommit( false ) ;

			String id = (String) tabData.get( "id" ) ;
			String eff_status = (String) tabData.get( "eff_status" ) ;

				pstmt_update_duration		= connection.prepareStatement( SQL_OR_CONSENT_FORM_INSERT ) ;
				pstmt_clob					= connection.prepareStatement(SQL_OR_CONSENT_FORM_UPDATE_CLOB);


				traceVals.append("--id -- "+id);
				traceVals.append("--eff_status -- "+eff_status);

				pstmt_update_duration.setString( 1, (String) id) ;
				pstmt_update_duration.setString( 2, (String) eff_status ) ;

				pstmt_update_duration.setString( 3, (String) tabData.get( "added_by_id" ) ) ;
				pstmt_update_duration.setString( 4, (String) tabData.get( "added_at_ws_no" ) ) ;
				pstmt_update_duration.setString( 5, (String) tabData.get( "added_facility_id" ) ) ;
				pstmt_update_duration.setString( 6, (String) tabData.get( "modified_by_id" ) ) ;
				pstmt_update_duration.setString( 7, (String) tabData.get( "modified_at_ws_no" ) ) ;
				pstmt_update_duration.setString( 8, (String) tabData.get( "modified_facility_id" ) ) ;
				pstmt_update_duration.setString( 9, (String) tabData.get( "consent_type" ) ) ;
				pstmt_update_duration.setString( 10, (String) tabData.get( "Consent_form_label" ) ) ;
				pstmt_update_duration.setString( 11, (String) tabData.get( "consent_format" ) );
				pstmt_update_duration.setString( 12, (String) tabData.get( "indexed" ) );


				traceVals.append("-- before execute --");
				result = pstmt_update_duration.executeUpdate() ;
				traceVals.append("-- after execute --");

				if ( result < 1 ) {
					connection.rollback() ;
					messages.append( "Insert Failed" ) ;
				}
				if(result >= 1){
					//String msg = "";
					//msg = 
						insertResultDataClob(pstmt_clob, (String)tabData.get("desc"), id);
						connection.commit() ;
						map.put( "result", new Boolean( true ) ) ;
						map.put( "message", "Operation Completed Successfully..." ) ;
						messages.append( "RECORD_INSERTED" ) ;
				}

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
				if ( pstmt_update_duration != null ) {
 					closeStatement(pstmt_update_duration);
				}
				if (pstmt_clob != null) {
					closeStatement(pstmt_clob);
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

		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVals.toString() ) ;
		traceVals.setLength(0);
		messages.setLength(0);

		return map ;
	}

/**
* @ejb.interface-method
*	 view-type="both"
*/

	public HashMap modify( HashMap tabData, HashMap sqlMap ) {

		Connection connection = null ;
		PreparedStatement pstmt_update_duration = null ;
		//PreparedStatement pstmt_dup_check = null;
		PreparedStatement pstmt_clob = null;

		traceVals = new StringBuffer();
		StringBuffer messages = new StringBuffer() ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;

		final String SQL_OR_CONSENT_FORM_UPDATE = (String) sqlMap.get( "SQL_OR_CONSENT_FORM_UPDATE" ) ;
		final String SQL_OR_CONSENT_FORM_UPDATE_CLOB = (String) sqlMap.get("SQL_OR_CONSENT_FORM_UPDATE_CLOB");
		traceVals.append("before try -- "+SQL_OR_CONSENT_FORM_UPDATE);
		traceVals.append("before try -- " + SQL_OR_CONSENT_FORM_UPDATE_CLOB);

		int result=0;
		try {
			connection = getConnection((Properties)tabData.get( "properties" ) ) ;
			connection.setAutoCommit( false ) ;

			pstmt_update_duration		= connection.prepareStatement( SQL_OR_CONSENT_FORM_UPDATE ) ;
			pstmt_clob					= connection.prepareStatement(SQL_OR_CONSENT_FORM_UPDATE_CLOB);

				String id = (String) tabData.get( "id" ) ;
				String eff_status = (String) tabData.get( "eff_status" ) ;

				traceVals.append("--U-id -- "+id);
				traceVals.append("--U-eff_status -- "+eff_status);

				pstmt_update_duration.setString( 1, (String) eff_status ) ;
				
				pstmt_update_duration.setString( 2, (String) tabData.get( "modified_by_id" ) ) ;
				pstmt_update_duration.setString( 3, (String) tabData.get( "modified_at_ws_no" ) ) ;
				pstmt_update_duration.setString( 4, (String) tabData.get( "modified_facility_id" ) ) ;
				pstmt_update_duration.setString( 5, (String) tabData.get( "Consent_form_label" ) ) ;
				pstmt_update_duration.setString( 6, (String) tabData.get( "consent_format" ) ) ;
				pstmt_update_duration.setString( 7, (String) tabData.get( "indexed" ) ) ;
				pstmt_update_duration.setString( 8, (String) id) ;


				traceVals.append("-- before execute --");
				result = pstmt_update_duration.executeUpdate() ;
				traceVals.append("-- after execute --");

				if ( result < 1 ) {
 					connection.rollback();
					messages.append( "Insert Failed" ) ;
				}
				if(result >= 1){
						//String msg = "";
						//msg = 
						insertResultDataClob(pstmt_clob, (String)tabData.get("desc"), id);
						connection.commit() ;
						map.put( "result", new Boolean( true ) ) ;
						map.put( "message", "Operation Completed Successfully..." ) ;
						messages.append( "RECORD_MODIFIED" ) ;
				}
		 } catch( Exception e ) {
			traceVals.append("Exception if any -- "+e);

			try {
					connection.rollback();
			} catch ( Exception ee ) {
				messages.append( ee.getMessage() ) ;
			}

			messages.append( e.getMessage() ) ;
			System.err.println(e.getMessage() );
			e.printStackTrace() ;
		} finally {
			try {
				if ( pstmt_update_duration != null ) {
					closeStatement(pstmt_update_duration);
				}
				if (pstmt_clob != null) {
					closeStatement(pstmt_clob);
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
		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVals.toString() ) ;
		traceVals.setLength(0);
		messages.setLength(0);

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
		traceVals.setLength(0);
		messages.setLength(0);

		return map ;
	}

	public String insertResultDataClob(PreparedStatement pstmt_clob, String consent_form_content,
										String id)
	{

		//System.out.println("###consent_form_content="+consent_form_content);
		StringBuffer messages = new StringBuffer("");
		ResultSet rset_clob = null;
		try
		{
			messages.append("*insertClob called*");
			pstmt_clob.setString(1,id);
			rset_clob=pstmt_clob.executeQuery();
			if(rset_clob!=null)
			{
				if(rset_clob.next())
				{
					messages.append("z");
					//CLOB clb = (CLOB)rset_clob.getClob("consent_form_content"); //Web logic Conversion -- IN037372
					java.sql.Clob clb = (java.sql.Clob)rset_clob.getClob("consent_form_content");
					messages.append("a");
					//BufferedWriter bw   = new BufferedWriter(clb.getCharacterOutputStream());  //Web logic Conversion -- IN037372
					BufferedWriter bw = new BufferedWriter(clb.setCharacterStream(0));
					messages.append("b");
					bw.write(consent_form_content,0,consent_form_content.length());
					messages.append("c");
					bw.flush();
					messages.append("d");
					bw.close();
					messages.append("**clob**");
				}
			}
			rset_clob.close();
		} catch ( Exception ee ) {
			messages.append("Error "+ee.getMessage() ) ;
			System.err.println(ee.getMessage());
			ee.printStackTrace() ;
		} finally {
			try {
				if (rset_clob != null) {
					closeResultSet(rset_clob);
				}
				if (pstmt_clob != null) {
					closeStatement(pstmt_clob);
				}
			} catch (Exception e){e.printStackTrace() ;}
		}
		//System.out.println("###messages.toString()="+messages.toString());
		return messages.toString();
	}


}
