/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH.TPNConsGroup ;

import java.rmi.* ;
import java.util.HashMap ;
//import java.util.ArrayList;
import java.util.Properties;
import java.sql.* ;
import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;

//saved on 26/10/2005
/**
*
* @ejb.bean
*	name="TPNConsGroup"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="TPNConsGroup"
*	local-jndi-name="TPNConsGroup"
*	impl-class-name="ePH.TPNConsGroup.TPNConsGroupManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.TPNConsGroup.TPNConsGroupLocal"
*	remote-class="ePH.TPNConsGroup.TPNConsGroupRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.TPNConsGroup.TPNConsGroupLocalHome"
*	remote-class="ePH.TPNConsGroup.TPNConsGroupHome"
*	generate= "local,remote"
*
*
*/

public class TPNConsGroupManager extends PhEJBSessionAdapter {
	
//	Properties prop=null;

	
	// insert method starts here
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		//added for ML-MMOH-CRF-1126 start
    	HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "inserted" ) ;
		
		Connection connection	= null ;
		PreparedStatement pstmt_insert=null;

//		String debug=null;
		int tmpcount;
        String count_code="";
    	ResultSet resultSet = null ;

		String user=(String)tabData.get("LOGIN_BY_ID");
		String wsno=(String)tabData.get("LOGIN_AT_WS_NO");
		String facility=(String)tabData.get("LOGIN_FACILITY_ID");
		String gCode=(String)tabData.get("GCODE");
		String gName=(String)tabData.get("GNAME");
		String eff_status=(String)tabData.get("EFF_STATUS");
		if(eff_status.equals("")||eff_status==null)
			eff_status="D";
		String display_sri_no=(String)tabData.get("DISPLAY_SRI_NO");

		try {
					
			
			connection	= 	getConnection( (Properties)tabData.get( "PROPERTIES" ) ) ;
			String disp_count_code="select count(*) disp_count_code from PH_TPN_CONSTITUENT_GROUP where CONST_GROUP_CODE= ?";
			
			pstmt_insert=connection.prepareStatement(disp_count_code);
			pstmt_insert.setString(1,gCode);
			 resultSet=pstmt_insert.executeQuery();
			 if(resultSet !=null && resultSet.next())
				{
				 count_code=	resultSet.getString("DISP_COUNT_CODE");
				
				System.out.println("count_code==> "+count_code);
				}
				closeStatement( pstmt_insert) ;//common-icn-0029
			if(Integer.parseInt(count_code) == 0){
				pstmt_insert=connection.prepareStatement((String) sqlMap.get( "SQLINSERT"));
				
				pstmt_insert.setString(1,gCode);
				pstmt_insert.setString(2,gName);
				pstmt_insert.setString(3,display_sri_no);
				pstmt_insert.setString(4,eff_status);
				pstmt_insert.setString(5,user);
				pstmt_insert.setString(6,wsno);
				pstmt_insert.setString(7,facility);
				pstmt_insert.setString(8,user);
				pstmt_insert.setString(9,wsno);
				pstmt_insert.setString(10,facility);
			 	
			tmpcount =pstmt_insert.executeUpdate() ;
			if (tmpcount==0) {
					map.put( "result", new Boolean( false ) ) ;
					map.put( "msgid", "Error During Updation into Constituent Group!!! ");
					return map;
			}
			else
			{
					map.put( "result", new Boolean( true) ) ;
					map.put( "msgid", "RECORD_INSERTED") ;

			}
			
			connection.commit();
		}else{
			map.put( "msgid", "CONSTITUENT_GROUP_CODE") ;
			map.put( "result", new Boolean( false ) ) ;
		}//end of try
		
		}catch( Exception e ) {
			map.put( "result", new Boolean( false ) ) ;
			map.put( "msgid",e.toString()) ;

		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_insert) ;
				closeConnection( connection, (Properties)tabData.get( "PROPERTIES" ) );
				
			}
			catch ( Exception fe ) {
			//	System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}

		return map ;
		
}
// added for ML-MMOH-CRF-1126 end	
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
//				String debug=null;
				int tmpcount;

//				ResultSet resultSet = null ;

				String user=(String)tabData.get("LOGIN_BY_ID");
				String wsno=(String)tabData.get("LOGIN_AT_WS_NO");
				String facility=(String)tabData.get("LOGIN_FACILITY_ID");
				String gCode=(String)tabData.get("GCODE");
				String gName=(String)tabData.get("GNAME");
				String eff_status = (String)tabData.get("EFF_STATUS"); // Added for ML-MMOH-CRF-1126

				try {
							
					 
					connection	= 	getConnection( (Properties)tabData.get( "PROPERTIES" ) ) ;

					 pstmt_update=connection.prepareStatement((String) sqlMap.get( "SQLUPDATE"));
					 if(tabData.get("SITE_SPECIFIC").equals("Y")){ // Added for ML-MMOH-CRF-1126 - Start
						 pstmt_update.setString(1,gName);
						 if(eff_status.equals("")){
							 eff_status="E";
						 } 
						 pstmt_update.setString(2,user);
						 pstmt_update.setString(3,wsno);
						 pstmt_update.setString(4,facility);
						 pstmt_update.setString(5,eff_status);
						 pstmt_update.setString(6,gCode);
					}
					else{  // Added for ML-MMOH-CRF-1126 - End
					
					 pstmt_update.setString(1,gName);
					 pstmt_update.setString(2,user);
					 pstmt_update.setString(3,wsno);
					 pstmt_update.setString(4,facility);
					 pstmt_update.setString(5,gCode);
					}  // Added for ML-MMOH-CRF-1126 one line 
					tmpcount =pstmt_update.executeUpdate() ;
					if (tmpcount==0) {
							map.put( "result", new Boolean( false ) ) ;
							map.put( "msgid", "Error During Updation into Constituent Group!!! ");
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
					map.put( "msgid", "Error During Updation into Constituent Group!!!  " +e) ;

				}
				finally {
					try {
						closeStatement( pstmt_update) ;
						closeConnection( connection, (Properties)tabData.get( "PROPERTIES" ) );
						//closeConnection( connection, (Properties)tabData.get( "properties" ) );
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


			
		
	

	// delete method starts here
public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		return map;
	}
	// delete method ends here
}
