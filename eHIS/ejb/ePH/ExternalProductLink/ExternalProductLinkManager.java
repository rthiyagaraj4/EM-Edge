/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//saved on 08/11/2005
package ePH.ExternalProductLink ;

import java.rmi.* ;
import java.util.HashMap ;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.* ;
import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;
/**
*
* @ejb.bean
*	name="ExternalProductLink"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ExternalProductLink"
*	local-jndi-name="ExternalProductLink"
*	impl-class-name="ePH.ExternalProductLink.ExternalProductLinkManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.ExternalProductLink.ExternalProductLinkLocal"
*	remote-class="ePH.ExternalProductLink.ExternalProductLinkRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.ExternalProductLink.ExternalProductLinkLocalHome"
*	remote-class="ePH.ExternalProductLink.ExternalProductLinkHome"
*	generate= "local,remote"
*
*
*/
public class ExternalProductLinkManager extends PhEJBSessionAdapter {

//	Properties prop=null;

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/	
	// insert method starts here
    public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		
		return new HashMap();
	}
// insert method ends here
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
//  modify method starts here
	public HashMap modify( HashMap tabData, HashMap sqlMap )  {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "inside Modify" ) ;
		
		Connection connection	= null ;
		PreparedStatement pstmt_update=null;

		
		ArrayList DrugCodearray=new ArrayList();
		ArrayList ExCodearray=new ArrayList();


		int count=0;
		int tmpcount=0;

		DrugCodearray=(ArrayList)tabData.get("DRUGCODES");
		ExCodearray=(ArrayList)tabData.get("EXCODES");
		String user=(String)tabData.get("LOGIN_BY_ID");
		String wsno=(String)tabData.get("LOGIN_AT_WS_NO");
		String facility=(String)tabData.get("LOGIN_FACILITY_ID");

		try {
					
			connection	= 	getConnection( (Properties)tabData.get( "PROPERTIES" ) ) ;
			 count=DrugCodearray.size();

			 pstmt_update=connection.prepareStatement((String) sqlMap.get( "SQLDRUGUPDATE"));

			for (int i=0;i<count ;i++ )
			{
				pstmt_update.setString(1,(String)ExCodearray.get(i));
				pstmt_update.setString(2,user);
				pstmt_update.setString(3,wsno);
				pstmt_update.setString(4,facility);
				pstmt_update.setString(5,(String)DrugCodearray.get(i));
	
				tmpcount =pstmt_update.executeUpdate() ;
				if (tmpcount==0) {
					map.put( "result", new Boolean( false ) ) ;
					map.put( "msgid", "Error During Updation into Ph External Product" );
					return map;
				}
				else
				{
					map.put( "result", new Boolean( true) ) ;
					map.put( "msgid", "RECORD_INSERTED") ;

				}
			
			}
			connection.commit();


		}//end of try
		
		catch( Exception e ) {
			map.put( "result", new Boolean( false ) ) ;
			map.put( "msgid", "Exception in EJB during insertion into ph external product " +e) ;

		}
		finally {
			try {
				closeStatement( pstmt_update) ;
				//closeConnection( connection );
				closeConnection( connection, (Properties)tabData.get( "PROPERTIES" ) );
				connection.rollback();
			}
			catch ( Exception fe ) {
			//	System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		return map ;
	}

				  
	/* Function specific methods end */


			
		
	
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	// delete method starts here
public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		return map;
	}
	// delete method ends here
}
