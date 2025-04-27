/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.ORPractForConsent;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import javax.ejb.* ;
import javax.transaction.* ;

import eOR.Common.* ;

/**
*
* @ejb.bean
*	name="ORPractForConsent"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORPractForConsent"
*	local-jndi-name="ORPractForConsent"
*	impl-class-name="eOR.ORPractForConsent.ORPractForConsentManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORPractForConsent.ORPractForConsentLocal"
*	remote-class="eOR.ORPractForConsent.ORPractForConsentRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORPractForConsent.ORPractForConsentLocalHome"
*	remote-class="eOR.ORPractForConsent.ORPractForConsentHome"
*	generate= "local,remote"
*
*
*/

public class ORPractForConsentManager extends OrEJBSessionAdapter {

	StringBuffer traceVal = new StringBuffer() ;
	Connection connection = null ;
	PreparedStatement pstmt = null ;
	PreparedStatement pstmt_del = null ;
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap insert( HashMap tabDataParam, HashMap sqlMap ){
	
		StringBuffer messages = new StringBuffer() ;
		
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		boolean insert_flag = false ;
		boolean delete_flag = false ;
		
		String group_by					= "";
		String pract_consent_code		= "";
		String login_by_id				= "";
		String login_at_ws_no			= "";
		String login_facility_id		= "";

		int [] insertCounts ;
		int [] deleteCounts ;

		String SQL_OR_PRACT_FOR_CONSENT_INSERT = (String) sqlMap.get("SQL_OR_PRACT_FOR_CONSENT_INSERT");
		String SQL_OR_PRACT_FOR_CONSENT_DELETE = (String) sqlMap.get("SQL_OR_PRACT_FOR_CONSENT_DELETE");

		ArrayList deleteArrList	= null;
		ArrayList insertArrList = null;
		Hashtable HashHdrData	= null;

		insertArrList			= (ArrayList)tabDataParam.get("insertArrList");
		deleteArrList			= (ArrayList)tabDataParam.get("deleteArrList");
		HashHdrData				= (Hashtable)tabDataParam.get("MultiHashData");
		
		group_by				= (String)HashHdrData.get("group_by");
		pract_consent_code		= (String)HashHdrData.get("pract_consent_code");
		login_by_id				= (String)HashHdrData.get("login_by_id");
		login_at_ws_no			= (String)HashHdrData.get("login_at_ws_no");
		login_facility_id		= (String)HashHdrData.get("login_facility_id");

		//System.out.println("From Ejb : "+group_by+" "+pract_consent_code);

		try {
			connection			= getConnection((Properties)tabDataParam.get("properties")) ;
		}catch(Exception Exp){
			throw new EJBException( Exp.getMessage() ) ;
		}

		try{
			 if(insertArrList.size() >0)
				insert_flag = false;
			else
				insert_flag = true;

			if(deleteArrList.size() >0)
				delete_flag = false;
			else
				delete_flag = true;

			if(insertArrList.size() >0){
				pstmt = connection.prepareStatement(SQL_OR_PRACT_FOR_CONSENT_INSERT);
				HashMap tabData  = null;

				for(int k=0 ; k < insertArrList.size() ; k++){
					tabData  = (HashMap)insertArrList.get(k);
					if(group_by.equals("P"))
					{
						pstmt.setString(1 ,pract_consent_code);
						pstmt.setString(2 ,(String)tabData.get("code"));
					}
					else
					{
						pstmt.setString(2 ,pract_consent_code);
						pstmt.setString(1 ,(String)tabData.get("code"));
					}
					pstmt.setString(3 ,login_by_id);
					pstmt.setString(4 ,login_at_ws_no);
					pstmt.setString(5 ,login_facility_id);
					pstmt.setString(6 ,login_by_id);
					pstmt.setString(7 ,login_at_ws_no);
					pstmt.setString(8 ,login_facility_id);
					pstmt.addBatch();
				}
				insertCounts = pstmt.executeBatch();

				for (int i=0;i<insertCounts.length ;i++ ){
			
					if(insertCounts[i]<0 && insertCounts[i]!=-2){
						insert_flag=false;
						break;
					}
					else{
						insert_flag=true;
					}
				}
			}

			if(insert_flag && deleteArrList.size() >0 ){

				pstmt_del	= connection.prepareStatement(SQL_OR_PRACT_FOR_CONSENT_DELETE);

				HashMap delMapData  = new HashMap();

				for(int k=0 ; k < deleteArrList.size() ; k++){
				delMapData  = (HashMap)deleteArrList.get(k);
				if(group_by.equals("P"))
				{
					pstmt_del.setString(1 ,pract_consent_code);
					pstmt_del.setString(2 ,(String)delMapData.get("code"));
				}
				else
				{
					pstmt_del.setString(2 ,pract_consent_code);
					pstmt_del.setString(1 ,(String)delMapData.get("code"));
				}
				pstmt_del.addBatch();
			}

			deleteCounts = pstmt_del.executeBatch();
			for (int i=0;i<deleteCounts.length ;i++ ){
				if(deleteCounts[i]<0 && deleteCounts[i] != -2){
					delete_flag=false;
					break;
				}
				else{
					delete_flag=true;
				}
			}
		}
		if(insert_flag && delete_flag){
			connection.commit();
			map.put( "result", new Boolean( true ) ) ;
			messages.append( "RECORD_INSERTED" ) ;
		}
		else{
			connection.rollback();
			map.put( "result", new Boolean( false ) ) ;
			throw new EJBException("Insert/Update Failed");
		}
	}
	catch(Exception e){
	traceVal.append(e.getMessage());
	map.put( "traceVal", traceVal.toString() ) ;
	}
	finally{
	   try {
		    closeStatement( pstmt ) ;
			closeStatement( pstmt_del ) ;
			closeConnection( connection, (Properties)tabDataParam.get( "properties" ) );
		}catch ( Exception fe ) {
			System.err.println( fe.getMessage() ) ;
			fe.printStackTrace() ;
			traceVal.append(fe.getMessage());
			map.put( "traceVal", traceVal.toString() ) ;
		}
	}
	map.put( "message", messages.toString() ) ;
	map.put( "traceVal", traceVal.toString() ) ;
	return map ;
	}


	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify( HashMap tabDataParam, HashMap sqlMap ) {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		return map ;
	}
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap delete( HashMap tabDataParam, HashMap sqlMap ) {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		return map ;
	}
}
