/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.OROrderCatalogMultiConsent ;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import eOR.Common.* ;
import javax.ejb.* ;
import javax.transaction.* ;

import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="OROrderCatalogMultiConsent"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="OROrderCatalogMultiConsent"
*	local-jndi-name="OROrderCatalogMultiConsent"
*	impl-class-name="eOR.OROrderCatalogMultiConsent.OROrderCatalogMultiConsentManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.OROrderCatalogMultiConsent.OROrderCatalogMultiConsentLocal"
*	remote-class="eOR.OROrderCatalogMultiConsent.OROrderCatalogMultiConsentRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.OROrderCatalogMultiConsent.OROrderCatalogMultiConsentLocalHome"
*	remote-class="eOR.OROrderCatalogMultiConsent.OROrderCatalogMultiConsentHome"
*	generate= "local,remote"
*
*
*/

public class OROrderCatalogMultiConsentManager extends OrEJBSessionAdapter 
{

	StringBuffer traceVals = new StringBuffer();

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap delete( HashMap tabData, HashMap sqlMap ) 
	{

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
	public HashMap insert( HashMap tabData, HashMap sqlMap ) 
	{

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
	public HashMap modify(HashMap tabDataParam , HashMap sqlMap ) 
	{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ArrayList tabData	= null;
		StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;
		


		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "insert" ) ;
		String SQL_OR_ORDER_CATALOG_MULTI_CONSENT_DELETE = (String) sqlMap.get("SQL_OR_ORDER_CATALOG_MULTI_CONSENT_DELETE");
		String SQL_OR_ORDER_CATALOG_MULTI_CONSENT_INSERT = (String) sqlMap.get("SQL_OR_ORDER_CATALOG_MULTI_CONSENT_INSERT");
		
		ArrayList tabDataMultiple = (ArrayList)tabDataParam.get("UpdateData");
		Properties pt = (Properties)tabDataParam.get("properties");
		String catalogCode = (String) tabDataParam.get("catalogCode");


		try 
		{
			connection = getConnection(pt) ;
			int noOfRecords = tabDataMultiple.size();
			pstmt = connection.prepareStatement(SQL_OR_ORDER_CATALOG_MULTI_CONSENT_DELETE);
			pstmt.setString(1,catalogCode);
			pstmt.executeUpdate();
			closeStatement(pstmt);
			//Batch insertion
			pstmt = connection.prepareStatement(SQL_OR_ORDER_CATALOG_MULTI_CONSENT_INSERT);
			
			for(int i=0;i<noOfRecords;i++)
			{
				tabData  = (ArrayList)tabDataMultiple.get(i);
				traceVal.append(tabData.toString());
				pstmt.setString(1 ,(String)tabData.get(0));
				pstmt.setString(2 ,(String)tabData.get(1));
				pstmt.setString(3 ,(String)tabData.get(2));
				pstmt.setString(4 ,(String)tabData.get(3));
				pstmt.setString(5 ,(String)tabData.get(4));
				pstmt.setString(6 ,(String)tabData.get(5));
				pstmt.setString(7 ,(String)tabData.get(6));
				pstmt.setString(8 ,(String)tabData.get(7));
				pstmt.setString(9 ,(String)tabData.get(8));
				pstmt.setString(10,(String)tabData.get(9));
				pstmt.setString(11,(String)tabData.get(10));
				pstmt.addBatch();
				tabData.clear();
			}
			tabDataMultiple.clear();
			int [] updatedCounts ;
			try
			{
				updatedCounts = pstmt.executeBatch();
			}
			catch(Exception e)
			{
				connection.rollback();
				traceVal.append(e.getMessage());
				map.put( "traceVal", traceVal.toString() ) ;
				return map ;
			}
			if(updatedCounts.length>0)
			{
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append( "RECORD_INSERTED" ) ;
			}
			else
			{
				connection.rollback();
				messages.append( "Insert Failed" ) ;
			}

		}
		catch( Exception e )
		{
			traceVal.append("In Exception==");
			e.printStackTrace();
			traceVal.append(e.getMessage());
			map.put( "traceVal", traceVal.toString() ) ;
			
			try 
			{
				connection.rollback();
				closeConnection( connection,pt);
				//	closeConnection(connection);
			} 
			catch ( Exception ee ) 
			{
				messages.append(ee.getMessage() ) ;
			}
			if (e instanceof java.lang.NullPointerException || (((String)e.getMessage()).indexOf("Index: 0, Size: 0") != -1))
			{
				messages.delete(0, messages.length());
				messages.append("Cannot Update. Try Again Later...");
			}
			else
				messages.append( e.getMessage() ) ;
			System.err.println(e.getMessage());
			e.printStackTrace() ;
		} 
		finally
		{
			try 
			{
				closeStatement(pstmt);
				closeConnection( connection ,pt);
			}
			catch ( Exception fe ) 
			{
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVal.toString() ) ;
		return map ;
	}//End of Insert Method
}
