/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH.TPNConsGeneric ;

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
*	name="TPNConsGeneric"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="TPNConsGeneric"
*	local-jndi-name="TPNConsGeneric"
*	impl-class-name="ePH.TPNConsGeneric.TPNConsGenericManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.TPNConsGeneric.TPNConsGenericLocal"
*	remote-class="ePH.TPNConsGeneric.TPNConsGenericRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.TPNConsGeneric.TPNConsGenericLocalHome"
*	remote-class="ePH.TPNConsGeneric.TPNConsGenericHome"
*	generate= "local,remote"
*
*
*/
public class TPNConsGenericManager extends PhEJBSessionAdapter {
	
//	Properties prop=null;

	
	// insert method starts here
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		
		return new HashMap();
	}
// insert method ends here

//  modify method starts here
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

//6/17/2005		ResultSet resultSet = null ;

	
		String user=(String)tabData.get("LOGIN_BY_ID");
		String wsno=(String)tabData.get("LOGIN_AT_WS_NO");
		String facility=(String)tabData.get("LOGIN_FACILITY_ID");
		String gCode=(String)tabData.get("GCODE");
		String gName=(String)tabData.get("GNAME");
		String item_fluid_appl_yn=(String)tabData.get("ITEMFLUID");
        String eff_status = (String)tabData.get("EFF_STATUS"); // Added for ML-MMOH-CRF-1126
		try {
					
				connection	= 	getConnection( (Properties)tabData.get( "PROPERTIES" ) ) ;

			 pstmt_update=connection.prepareStatement((String) sqlMap.get( "SQLUPDATE"));
			
			if(tabData.get("SITE_SPECIFIC").equals("Y")){ // Added for ML-MMOH-CRF-1126 - Start
				 pstmt_update.setString(1,gName);
				 if(eff_status.equals("")){
					 eff_status="E";
				 }
				 pstmt_update.setString(2,eff_status);
				 pstmt_update.setString(3,user);
				 pstmt_update.setString(4,wsno);
				 pstmt_update.setString(5,facility);
				 pstmt_update.setString(6,item_fluid_appl_yn);
				 pstmt_update.setString(7,gCode);
			} // Added for ML-MMOH-CRF-1126 - End
			else{
			 pstmt_update.setString(1,gName);
			 pstmt_update.setString(2,user);
			 pstmt_update.setString(3,wsno);
			 pstmt_update.setString(4,facility);
			 pstmt_update.setString(5,item_fluid_appl_yn);
			 pstmt_update.setString(6,gCode);
			}
			tmpcount =pstmt_update.executeUpdate() ;
			if (tmpcount==0) {
					map.put( "result", new Boolean( false ) ) ;
					map.put( "msgid", "Error During Updation into Constituent Generic!!! ");
					connection.rollback();
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
			map.put( "msgid", "Error During Updation into Constituent Generic!!!  " +e) ;

		}
		finally {
			try {
				closeStatement( pstmt_update) ;
				closeConnection( connection, (Properties)tabData.get( "PROPERTIES" ) );
				
			}
			catch ( Exception fe ) {
			//	System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
				
			}
		}
		return map ;

	}

				  
	/* Function specific methods end */


			
		
	

	// delete method starts here
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
