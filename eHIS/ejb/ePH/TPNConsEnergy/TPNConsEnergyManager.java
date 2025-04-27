/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH.TPNConsEnergy;

import java.rmi.* ;
import java.util.HashMap ;
//import java.util.ArrayList;
import java.util.Properties;
import java.sql.* ;
import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;

/**
*
* @ejb.bean
*	name="TPNConsEnergy"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="TPNConsEnergy"
*	local-jndi-name="TPNConsEnergy"
*	impl-class-name="ePH.TPNConsEnergy.TPNConsEnergyManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.TPNConsEnergy.TPNConsEnergyLocal"
*	remote-class="ePH.TPNConsEnergy.TPNConsEnergyRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.TPNConsEnergy.TPNConsEnergyLocalHome"
*	remote-class="ePH.TPNConsEnergy.TPNConsEnergyHome"
*	generate= "local,remote"
*
*
*/ 

//saved on 26/10/2005
public class TPNConsEnergyManager extends PhEJBSessionAdapter {
	
//	Properties prop=null;

	
	// insert method starts here
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		
		return new HashMap();
	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify( HashMap tabData, HashMap sqlMap )  {
			
							
HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "inside Modify" ) ;
		
		Connection connection	= null ;
		PreparedStatement pstmt_update=null;
//		String debug=null;
		int tmpcount;

//		ResultSet resultSet = null ;

	
		String user=(String)tabData.get("LOGIN_BY_ID");
		String wsno=(String)tabData.get("LOGIN_AT_WS_NO");
		String facility=(String)tabData.get("LOGIN_FACILITY_ID");
		String gCode=(String)tabData.get("GCODE");
		String gName=(String)tabData.get("GNAME");

		try {
					
			connection	= 	getConnection( (Properties)tabData.get( "PROPERTIES" ) ) ;

			 pstmt_update=connection.prepareStatement((String) sqlMap.get( "SQLUPDATE"));
			
			 pstmt_update.setString(1,gName);
			 pstmt_update.setString(2,user);
			 pstmt_update.setString(3,wsno);
			 pstmt_update.setString(4,facility);
			 pstmt_update.setString(5,gCode);
	
			tmpcount =pstmt_update.executeUpdate() ;
			if (tmpcount==0) {
					map.put( "result", new Boolean( false ) ) ;
					map.put( "msgid", "Error During Updation into Constituent Energy!!! ");
					return map;
			}
			else
			{
					map.put( "result", new Boolean( true) ) ;
					map.put( "msgid", "RECORD_INSERTED") ;

			}
			
			connection.commit();


		}//end of try
		
		catch( Exception e ) {
			map.put( "result", new Boolean( false ) ) ;
			map.put( "msgid", "Error During Updation into Constituent Energy!!!  " +e) ;

		}
		finally {
			try {
				closeStatement( pstmt_update) ;
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
public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		return map;
	}
	// delete method ends here
}
