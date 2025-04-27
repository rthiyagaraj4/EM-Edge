/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH.RFD ;

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
*	name="RFD"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RFD"
*	local-jndi-name="RFD"
*	impl-class-name="ePH.RFD.RFDManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.RFD.RFDLocal"
*	remote-class="ePH.RFD.RFDRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.RFD.RFDLocalHome"
*	remote-class="ePH.RFD.RFDHome"
*	generate= "local,remote"
*
*
*/
public class RFDManager extends PhEJBSessionAdapter {

//	Properties prop=null;

	
	// insert method starts here
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	
    public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "inside Insert" ) ;
		
		Connection connection	= null ;
		PreparedStatement pstmt_insert		= null ;
		PreparedStatement pstmt_update=null;
		PreparedStatement pstmt_delete=null;
//		String debug=null;
	
		ArrayList RFIdarrayI=new ArrayList();
		ArrayList RFQtyarrayI=new ArrayList();
		ArrayList StabilityInfoarrayI=new ArrayList();
		ArrayList DefaultarrayI=new ArrayList();
//		ArrayList SelectarrayI=new ArrayList();

		ArrayList RFIdarrayU=new ArrayList();
		ArrayList RFQtyarrayU=new ArrayList();
		ArrayList StabilityInfoarrayU=new ArrayList();
		ArrayList DefaultarrayU=new ArrayList();
//		ArrayList SelectarrayU=new ArrayList();

		ArrayList RFIdarrayD=new ArrayList();

		int count=0;
		int tmpcount=0;

		RFIdarrayI=(ArrayList)tabData.get("RFIDI");
		RFQtyarrayI=(ArrayList)tabData.get("RFQTYI");
		StabilityInfoarrayI=(ArrayList)tabData.get("RFINFOI");
		DefaultarrayI=(ArrayList)tabData.get("DEFAULTI");
//		SelectarrayI=(ArrayList)tabData.get("SELECTI");

		
		RFIdarrayU=(ArrayList)tabData.get("RFIDU");
		RFQtyarrayU=(ArrayList)tabData.get("RFQTYU");
		StabilityInfoarrayU=(ArrayList)tabData.get("RFINFOU");
		DefaultarrayU=(ArrayList)tabData.get("DEFAULTU");
//		SelectarrayU=(ArrayList)tabData.get("SELECTU");

		RFIdarrayD=(ArrayList)tabData.get("RFIDD");

		try {
					
				connection	= getConnection( (Properties)tabData.get( "properties" ) ) ;

			count=RFIdarrayI.size();

			if (count>0)
			{
				//insert operations have to be performed
				pstmt_insert=connection.prepareStatement((String) sqlMap.get( "SQLRFDINSERT"));


				for (int i=0;i<count ;i++ )
				{
				pstmt_insert.setString(1,(String)tabData.get("DRUG_CODE"));
				pstmt_insert.setString(2,(String)RFIdarrayI.get(i));
				pstmt_insert.setString(3,(String)RFIdarrayI.get(i));
				pstmt_insert.setString(4,(String)tabData.get("DRUG_CODE"));
				pstmt_insert.setString(5,(String)tabData.get("DRUG_CODE"));
				pstmt_insert.setString(6,(String)RFQtyarrayI.get(i));
				pstmt_insert.setString(7,(String)RFIdarrayI.get(i));
				pstmt_insert.setString(8,(String)StabilityInfoarrayI.get(i));
				pstmt_insert.setString(9,(String)tabData.get("login_by_id"));
				pstmt_insert.setString(10,(String)tabData.get("login_at_ws_no"));
				pstmt_insert.setString(11,(String)tabData.get("login_facility_id"));
				pstmt_insert.setString(12,(String)tabData.get("login_by_id"));
				pstmt_insert.setString(13,(String)tabData.get("login_at_ws_no"));
				pstmt_insert.setString(14,(String)tabData.get("login_facility_id"));
				pstmt_insert.setString(15,(String)DefaultarrayI.get(i));


				tmpcount =pstmt_insert.executeUpdate() ;
				if (tmpcount==0) {
					map.put( "result", new Boolean( false ) ) ;
					map.put( "msgid", "Error During Insertion into RFD" );
					return map;
					}
			
			  }
			}
			//else check if update has to be performed				
			count=RFIdarrayU.size();

			if (count>0)
			{
				//update operations have to be performed
				pstmt_update=connection.prepareStatement((String) sqlMap.get( "SQLRFDUPDATE"));

				for (int i=0;i<count ;i++ )
				{

				pstmt_update.setString(1,(String)RFQtyarrayU.get(i));
				pstmt_update.setString(2,(String)StabilityInfoarrayU.get(i));
				pstmt_update.setString(3,(String)tabData.get("login_by_id"));
				pstmt_update.setString(4,(String)tabData.get("login_at_ws_no"));
				pstmt_update.setString(5,(String)tabData.get("login_facility_id"));
				pstmt_update.setString(6,(String)DefaultarrayU.get(i));
				pstmt_update.setString(7,(String)tabData.get("DRUG_CODE"));
				pstmt_update.setString(8,(String)RFIdarrayU.get(i));


				tmpcount =pstmt_update.executeUpdate() ;
				if (tmpcount==0) {
					map.put( "result", new Boolean( false ) ) ;
					map.put( "msgid", "Error During Updation into Fill Process Param" );
					return map;
					}
			
			  }
			}
			//else check if insert has to be performed				
			count=RFIdarrayD.size();

			if (count>0)
			{
				//update operations have to be performed
				pstmt_delete=connection.prepareStatement((String) sqlMap.get( "SQLRFDDELETE"));

				for (int i=0;i<count ;i++ )
				{
				pstmt_delete.setString(1,(String)tabData.get("DRUG_CODE"));
				pstmt_delete.setString(2,(String)RFIdarrayD.get(i));
			
				tmpcount =pstmt_delete.executeUpdate() ;
				if (tmpcount==0) {
					map.put( "result", new Boolean( false ) ) ;
					map.put( "msgid", "Error During Deletion into Fill Process Param" );
					return map;
					}
			
			  }
			}

			map.put( "result", new Boolean( true) ) ;
			map.put( "msgid", "RECORD_INSERTED") ;
			connection.commit();


		}//end of try
		
		catch( Exception e ) {
			map.put( "result", new Boolean( false ) ) ;
			
			map.put( "msgid", "Exception in EJB : " +e) ;
					try
			{
			connection.rollback();
			}
			catch (Exception ex)
			{ex.printStackTrace();
			}
					}
		finally {
			try {
				closeStatement( pstmt_insert ) ;
				closeStatement( pstmt_update ) ;
				closeStatement( pstmt_delete ) ;
				//closeConnection( connection );
				closeConnection( connection, (Properties)tabData.get( "properties" ) );
			}
			catch ( Exception fe ) {
			
				fe.printStackTrace() ;
			}
		}
		return map ;

	}
// insert method ends here

//  modify method starts here
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	
	public HashMap modify( HashMap tabData, HashMap sqlMap )  {

		HashMap map = new HashMap() ;
		return map;
	}

	// delete method starts here
public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		return map;
	}
	// delete method ends here
}
