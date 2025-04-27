/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH.DiscontinueDrug ;

import java.rmi.* ;
import java.util.HashMap ;
import java.util.ArrayList ;
import java.util.Properties ;
import java.sql.* ;

import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;
/**
*
* @ejb.bean
*	name="DiscontinueDrug"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="DiscontinueDrug"
*	local-jndi-name="DiscontinueDrug"
*	impl-class-name="ePH.DiscontinueDrug.DiscontinueDrugManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.DiscontinueDrug.DiscontinueDrugLocal"
*	remote-class="ePH.DiscontinueDrug.DiscontinueDrugRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.DiscontinueDrug.DiscontinueDrugLocalHome"
*	remote-class="ePH.DiscontinueDrug.DiscontinueDrugHome"
*	generate= "local,remote"
*
*
*/
public class DiscontinueDrugManager extends PhEJBSessionAdapter {
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "msgid", "Success" ) ;
		map.put( "flag", "0" ) ;
		return map ;
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap modify( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		boolean continueFlag = false ;
		StringBuffer s = new StringBuffer();

		Connection connection = null ;
		PreparedStatement pstmt_ph_drug = null ;
		PreparedStatement pstmt_or_order = null ;

		try {
			ArrayList drugData	= (ArrayList)tabData.get( "DRUGDATA" ) ;

			ArrayList orderData	= null;
			if (tabData.get("ORDERDATA") != null )
				orderData = (ArrayList)tabData.get( "ORDERDATA" ) ;

			connection = getConnection( (Properties)tabData.get( "PROPERTIES" ) ) ;
			pstmt_ph_drug = connection.prepareStatement( (String) sqlMap.get( "SQLPHDRUG" ) ) ;

			if (sqlMap.get("SQLORCATALOG") != null)
				pstmt_or_order = connection.prepareStatement( (String) sqlMap.get( "SQLORCATALOG" ) ) ;

			pstmt_ph_drug.setString(1,	(String)drugData.get(0));
			pstmt_ph_drug.setString(2,	(String)drugData.get(1));
			pstmt_ph_drug.setString(3,	(String)drugData.get(2));
			pstmt_ph_drug.setString(4,	(String)drugData.get(3));
			pstmt_ph_drug.setString(5,	(String)drugData.get(4));
			pstmt_ph_drug.setString(6,	(String)drugData.get(5));
			pstmt_ph_drug.setString(7,	(String)drugData.get(6));

			int result = pstmt_ph_drug.executeUpdate() ;

			if ( result<1 ) {
				connection.rollback();
				throw new EJBException("Update Failed");
			}
			else
				continueFlag = true ;

			if (continueFlag && orderData != null) {
				pstmt_or_order.setString(1,	(String)orderData.get(0));
				pstmt_or_order.setString(2,	(String)orderData.get(1));

				result = pstmt_or_order.executeUpdate() ;

				if ( result<1 ) {
					connection.rollback();
					throw new EJBException("Update Failed");
				}
				else {
					map.put( "result", new Boolean( true ) ) ;
					map.put( "msgid", "RECORD_MODIFIED" ) ;
					connection.commit();
				}
			}
			else {
				map.put( "result", new Boolean( true ) ) ;
				map.put( "msgid", "RECORD_MODIFIED" ) ;
				connection.commit();
			}
		}
		catch( Exception e ) {
			map.put( "msgid", "Exception in EJB : " + e.getMessage() ) ;
			e.printStackTrace() ;
		}
		finally {
			try {
				closeStatement( pstmt_ph_drug ) ;
				closeStatement( pstmt_or_order ) ;
				closeConnection( connection, (Properties)tabData.get( "PROPERTIES" ) );
			}
			catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		map.put( "flag", s.toString());
		return map ;
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "msgid", "Success" ) ;
		map.put( "flag", "0" ) ;
		return map ;
	}
}
