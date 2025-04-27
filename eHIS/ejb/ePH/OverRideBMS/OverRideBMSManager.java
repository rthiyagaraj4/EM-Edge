/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
04/13/2017      63877   		chithra      UnusedLocal variable
---------------------------------------------------------------------------------------------------------------
*/
package ePH.OverRideBMS ;
import java.rmi.* ;
import java.util.HashMap ;
import java.util.ArrayList;
import java.util.Properties;
//import java.util.Set;
//import java.util.Iterator;
import java.sql.* ;
import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;

/**
*
* @ejb.bean
*	name="OverRideBMS"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="OverRideBMS"
*	local-jndi-name="OverRideBMS"
*	impl-class-name="ePH.OverRideBMS.OverRideBMSManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.OverRideBMS.OverRideBMSLocal"
*	remote-class="ePH.OverRideBMS.OverRideBMSRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.OverRideBMS.OverRideBMSLocalHome"
*	remote-class="ePH.OverRideBMS.OverRideBMSHome"
*	generate= "local,remote"
*
*
*/



public class OverRideBMSManager extends PhEJBSessionAdapter {

	Properties prop=null;

	// insert method starts here
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/	
    public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "msgid", messages.toString() ) ;
		map.put( "flag","0");
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
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;	
		
		Connection connection		= null ;
		try{
			
			prop		= (Properties)tabData.get( "properties" );	
			connection	= getConnection( prop ) ;

			// update OR_ORDER & OR_ORDER_LINE
			updateOrderTables(connection,tabData,sqlMap);

			connection.commit();
			//connection.rollback();
			map.put( "result", new Boolean( true) ) ;
			map.put("msgid","RECORD_MODIFIED");

		}catch(Exception e){
			e.printStackTrace();
			try{
			connection.rollback();
			map.put("msgid",e.toString());
			map.put("flag",e.toString());
			map.put("result",  new Boolean( false)); 
			} catch(Exception ess) {ess.printStackTrace();}
		}finally{	
			try {
			closeConnection( connection,prop );
			}
			catch(Exception es) { es.printStackTrace();}
		}
		return map;
	}

	// delete method starts here
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap delete( HashMap tabData, HashMap sqlMap )  {

		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", messages.toString() ) ;
		return map ;
	}
	// delete method ends here



private void updateOrderTables(Connection connection,HashMap tabData,HashMap sqlMap) throws Exception {

		String order_id									=	null;
		String order_line_no							=	null;	
		ResultSet	resultSet							=	null;
		PreparedStatement pstmt_or_order_line_select	=	null;
		PreparedStatement pstmt_or_update				=	null;
		PreparedStatement pstmt_or_order_line_update	=	null;
        PreparedStatement pstmt_or_update_reason		=	null;	
        PreparedStatement pstmt_or_update_order			=	null;	

		
		try{
			pstmt_or_order_line_update	= connection.prepareStatement((String)sqlMap.get("SQL_PH_OVERRIDE_BMS_UPDATE1")) ;
			pstmt_or_order_line_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_OVERRIDE_BMS_SELECT2")) ;	
			pstmt_or_update				= connection.prepareStatement( (String)sqlMap.get("SQL_PH_OVERRIDE_BMS_UPDATE2") ) ;
			pstmt_or_update_reason		= connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_LINE_PH_UPDATE3") ) ;
			pstmt_or_update_order		= connection.prepareStatement((String)sqlMap.get("SQL_PH_OVERRIDE_BMS_UPDATE3")) ;

			ArrayList all_records	=	(ArrayList)tabData.get("all_records");
			HashMap record_status	=	(HashMap)tabData.get("record_status");

			String login_by_id		=	(String)tabData.get("login_by_id");
			String login_at_ws_no	=	(String)tabData.get("login_at_ws_no");
			String facility_id		=	(String)tabData.get("facility_id");
			String reason = "";

			int reasonUpdate		=	0;
			int line_res			=	0;
			//int	total				=	1; Unused local variable INC63877
	//		int ord_res				=	0;

	//		OR_ORDER_LINE_UPDATE 
			for(int i=0; i<all_records.size(); i+=2) {

				order_id		=	(String)all_records.get(i);
				order_line_no	=	(String)all_records.get(i+1);				
	            reason			=	"";		

			if((record_status.containsKey(order_id+order_line_no)))
		    {
                reason=(String)record_status.get(order_id+order_line_no);
				if((reason!=null && !(reason.equals(""))))
				{
				pstmt_or_update_reason.setString(1,login_by_id);
				pstmt_or_update_reason.setString(2,login_at_ws_no);
				pstmt_or_update_reason.setString(3,facility_id);
				pstmt_or_update_reason.setString(4,reason);
				pstmt_or_update_reason.setString(5,order_id);
				pstmt_or_update_reason.setString(6,order_line_no);
 			    reasonUpdate	=	pstmt_or_update_reason.executeUpdate();
                pstmt_or_order_line_update.setString(1,login_by_id);
				pstmt_or_order_line_update.setString(2,login_at_ws_no);
				pstmt_or_order_line_update.setString(3,facility_id);
				pstmt_or_order_line_update.setString(4,order_id);
				pstmt_or_order_line_update.setString(5,order_line_no);
				line_res	=	pstmt_or_order_line_update.executeUpdate();
				if(line_res < 0 )
					{
						throw new Exception("Orderline update failed");
					}

				}
		   }
			
		}			
				

					// OR_ORDER UPDATE
                 for(int i=0; i<all_records.size(); i+=2) 
				 {

				   order_id		=	(String)all_records.get(i);

                  if(record_status.containsKey(order_id+order_line_no)) 
					{
					pstmt_or_update_order.setString(1,getNumberOfPrescriptions(connection,order_id,sqlMap));
					pstmt_or_update_order.setString(2,login_by_id);
					pstmt_or_update_order.setString(3,login_at_ws_no);
					pstmt_or_update_order.setString(4,facility_id);
					pstmt_or_update_order.setString(5,order_id);
					pstmt_or_update_order.executeUpdate();
					
					}
				}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally{	
			try {
			closeResultSet( resultSet );
			closeStatement( pstmt_or_update ) ;
			closeStatement( pstmt_or_order_line_select ) ;
			closeStatement( pstmt_or_order_line_update ) ;
			closeStatement( pstmt_or_update_reason ) ;
			closeStatement( pstmt_or_update_order ) ;
			}
			catch(Exception es) { es.printStackTrace();}
		}
	}

/*-------------order_line_status ---------------------*/

public String getNumberOfPrescriptions(Connection connection,String order_id,HashMap sqlMap)throws Exception{

		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList arr_list=new ArrayList();
		String update_string="OS";
		try {
			pstmt = connection.prepareStatement((String)sqlMap.get("SQL_PH_RELEASE_BATCHES_SELECT8"));
			pstmt.setString(1,order_id.trim());		
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				arr_list.add(resultSet.getString("ORDER_LINE_STATUS"));
			}


			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			
				if(arr_list.contains("OS")){
					update_string="OS";
				}else if(arr_list.contains("RG")){
					update_string="RG";
				}else if(arr_list.contains("HD")){
					update_string="HD";
				}else if(arr_list.contains("VF")){
					update_string="VF";
				}else if(arr_list.contains("AL")){
					update_string="AL";
				}else if(arr_list.contains("IP")){
					update_string="IP";
				}else if(arr_list.contains("DP")){
					update_string="DP";
				}else if(arr_list.contains("DF")){
					update_string="DF";
				}
				

		}
		catch ( Exception e ){
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}catch(Exception es){ es.printStackTrace();
			}
		}
		return update_string;
	}	


}
