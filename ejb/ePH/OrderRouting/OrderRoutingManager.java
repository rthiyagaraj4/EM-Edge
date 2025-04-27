/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH.OrderRouting ;

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
*	name="OrderRouting"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="OrderRouting"
*	local-jndi-name="OrderRouting"
*	impl-class-name="ePH.OrderRouting.OrderRoutingManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.OrderRouting.OrderRoutingLocal"
*	remote-class="ePH.OrderRouting.OrderRoutingRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.OrderRouting.OrderRoutingLocalHome"
*	remote-class="ePH.OrderRouting.OrderRoutingHome"
*	generate= "local,remote"
*
*
*/

public class OrderRoutingManager extends PhEJBSessionAdapter {

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
		map.put( "flag", "0" ) ;			
		
		final String SQL_PH_ORDER_ROUTING_INSERT = (String) sqlMap.get( "SQL_PH_ORDER_ROUTING_INSERT" );
		final String SQL_PH_ORDER_ROUTING_DTL_INSERT = (String) sqlMap.get( "SQL_PH_ORDER_ROUTING_DTL_INSERT" );

		prop  = (Properties)tabData.get( "properties" );			            
		String  login_by_id			= (String)tabData.get("login_by_id");
		String	login_at_ws_no		= (String)tabData.get("login_at_ws_no");
		String	login_facility_id	= (String)tabData.get("login_facility_id");

		ArrayList CommonData		= (ArrayList)tabData.get("CommonData");
		String	ordering_facility_id = (String)CommonData.get(0);
		String	ordering_source_type = (String)CommonData.get(1);
		String	ordering_source_code = (String)CommonData.get(2);

		ArrayList MultipleData		= (ArrayList)tabData.get("MultipleData");

		String routing_level="";
		Connection connection = null ;
		PreparedStatement pstmt_insert1=null,pstmt_insert2 = null ;
		boolean sourceFlag =false;
		boolean otherThanSourceFlag =false;
		try{
			connection = getConnection( prop ) ;
			pstmt_insert1 = connection.prepareStatement( SQL_PH_ORDER_ROUTING_INSERT ) ;
			pstmt_insert2 = connection.prepareStatement( SQL_PH_ORDER_ROUTING_DTL_INSERT ) ;
			ArrayList dataRow = null;
			for (int i=0;i<MultipleData.size() ;i++ ){
				dataRow = (ArrayList)MultipleData.get(i);
				routing_level			= (String)dataRow.get(0);
				String routing_code				= (String)dataRow.get(1);
				String performing_facility_id	= (String)dataRow.get(2);
				String rtn_ord_disp_locn_code	= (String)dataRow.get(3);
				String stat_ord_disp_locn_code	= (String)dataRow.get(4);
				String disch_ord_disp_locn_code = (String)dataRow.get(5);
				if (routing_code==null || routing_code.equals("")){
					sourceFlag = true;
					/*rtn_ord_disp_locn_code=rtn_ord_disp_locn_code;
					stat_ord_disp_locn_code=stat_ord_disp_locn_code;
					disch_ord_disp_locn_code=disch_ord_disp_locn_code;*/

					pstmt_insert1.setString(1,ordering_facility_id.trim());
					pstmt_insert1.setString(2,ordering_source_type.trim());
					pstmt_insert1.setString(3,ordering_source_code.trim());
					pstmt_insert1.setString(4,performing_facility_id.trim());
					pstmt_insert1.setString(5,rtn_ord_disp_locn_code.trim());
					pstmt_insert1.setString(6,stat_ord_disp_locn_code.trim());
					pstmt_insert1.setString(7,disch_ord_disp_locn_code.trim());
					pstmt_insert1.setString(8,login_by_id.trim());
					pstmt_insert1.setString(9,login_at_ws_no.trim());
					pstmt_insert1.setString(10,login_facility_id.trim());
					pstmt_insert1.setString(11,login_by_id.trim());
					pstmt_insert1.setString(12,login_at_ws_no.trim());
					pstmt_insert1.setString(13,login_facility_id.trim());
					pstmt_insert1.addBatch();			
				}
				else{	
					otherThanSourceFlag=true;
					pstmt_insert2.setString(1,ordering_facility_id.trim());
					pstmt_insert2.setString(2,ordering_source_type.trim());
					pstmt_insert2.setString(3,ordering_source_code.trim());
					pstmt_insert2.setString(4,routing_level.trim());
					pstmt_insert2.setString(5,routing_code.trim());
					pstmt_insert2.setString(6,performing_facility_id.trim());
					pstmt_insert2.setString(7,rtn_ord_disp_locn_code.trim());
					pstmt_insert2.setString(8,stat_ord_disp_locn_code.trim());
					pstmt_insert2.setString(9,disch_ord_disp_locn_code.trim());
					pstmt_insert2.setString(10,login_by_id.trim());
					pstmt_insert2.setString(11,login_at_ws_no.trim());
					pstmt_insert2.setString(12,login_facility_id.trim());
					pstmt_insert2.setString(13,login_by_id.trim());
					pstmt_insert2.setString(14,login_at_ws_no.trim());
					pstmt_insert2.setString(15,login_facility_id.trim());
					pstmt_insert2.addBatch();
				}
			}
			
			if (sourceFlag==true){
				int[] result1= pstmt_insert1.executeBatch();
				for (int i=0;i<result1.length ;i++ ){
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result1[i]<0  && result1[i] != -2 ){
						pstmt_insert1.cancel();
						throw new EJBException("Insert Failed");
					}			
				}
			}
			if (otherThanSourceFlag ==true){
				int[] result2= pstmt_insert2.executeBatch();
				for (int i=0;i<result2.length ;i++ ){
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result2[i]<0  && result2[i] != -2 ){
						pstmt_insert2.cancel();
						throw new EJBException("Insert Failed");
					}			
				}			
			}
			map.put( "result", new Boolean( true ) ) ;
			messages.append( "RECORD_INSERTED" ) ;
			connection.commit();
		}
		catch( Exception e ) {
			try{
				connection.rollback();
				throw new EJBException( e.getMessage() ) ;
			}
			catch ( Exception ee ) {
				messages.append( ee.getMessage() ) ;
			}
			messages.append( e.getMessage() ) ;
			e.printStackTrace() ;
		}
		finally {
			try {
				closeStatement( pstmt_insert1 ) ;
				closeStatement( pstmt_insert2 ) ;
				closeConnection( connection,prop );
			} 
			catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		map.put( "msgid", messages.toString() ) ;
		map.put( "flag","");
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

		final String SQL_PH_ORDER_ROUTING_DTL_UPDATE = (String) sqlMap.get("ModifySQL");
		
		prop  = (Properties)tabData.get( "properties" );			            
		ArrayList ModifyData  = (ArrayList)tabData.get("ModifyData");
		String login_by_id			= (String)tabData.get("login_by_id");
		String login_at_ws_no		= (String)tabData.get("login_at_ws_no");
		String login_facility_id	= (String)tabData.get("login_facility_id");
	
		String performing_facility_id =	(String)ModifyData.get(0); 
		String rtn_ord_disp_locn_code =	(String)ModifyData.get(1); 
		String stat_ord_disp_locn_code =(String)ModifyData.get(2); 
		String disch_ord_disp_locn_code =(String)ModifyData.get(3);  
		String ordering_facility_id =(String)ModifyData.get(4); 
		String ordering_source_type = (String)ModifyData.get(5); 
		String ordering_source_code = (String)ModifyData.get(6); 
		String routing_level = (String)ModifyData.get(7); 
		String routing_code = (String)ModifyData.get(8); 
		
		Connection connection = null ;
		PreparedStatement pstmt_update = null ;
		try {
			connection = getConnection( prop ) ;
			pstmt_update = connection.prepareStatement( SQL_PH_ORDER_ROUTING_DTL_UPDATE ) ;
			pstmt_update.setString(1,performing_facility_id.trim());
			pstmt_update.setString(2,rtn_ord_disp_locn_code.trim());
			pstmt_update.setString(3,stat_ord_disp_locn_code.trim());
			pstmt_update.setString(4,disch_ord_disp_locn_code.trim());
			pstmt_update.setString(5,login_by_id.trim());
			pstmt_update.setString(6,login_at_ws_no.trim());
			pstmt_update.setString(7,login_facility_id.trim());
			pstmt_update.setString(8,ordering_facility_id.trim());
			pstmt_update.setString(9,ordering_source_type.trim());
			pstmt_update.setString(10,ordering_source_code.trim());
			pstmt_update.setString(11,routing_level.trim());
			pstmt_update.setString(12,routing_code.trim());
			pstmt_update.executeUpdate();
			
			map.put( "result", new Boolean( true ) ) ;				
			map.put( "msgid","RECORD_MODIFIED");
			connection.commit();
		}
		catch( Exception e ) {
			try{
				map.put( "result", new Boolean( false ) ) ;
				map.put( "flag",e);
				connection.rollback();
				throw new EJBException( e.getMessage() ) ;
			}
			catch ( Exception ee ) {
				map.put( "result", new Boolean( false ) ) ;
				map.put( "flag",ee);
				map.put( "msgid",ee.getMessage());
			}			
			map.put( "msgid",e.getMessage());
			e.printStackTrace() ;
		} 
		finally {
			try {
				closeStatement( pstmt_update ) ;
				closeConnection( connection,prop );
			} 
			catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		map.put( "flag","");
		return map ;
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

		Properties  prop  = (Properties)tabData.get( "properties" );			            
		ArrayList DeleteData = (ArrayList)tabData.get("DeleteData");
		String ordering_facility_id = "";
		String ordering_source_type = "";
		String ordering_source_code = "";
		String routing_level = "";      
		String routing_code = "";       
		Connection connection = null ;
		PreparedStatement pstmt_delete=null;
		try{
			connection = getConnection( prop ) ;
			if (DeleteData.size()==3){
				ordering_facility_id = (String)DeleteData.get(0);
				ordering_source_type = (String)DeleteData.get(1);
				ordering_source_code = (String)DeleteData.get(2);
				final String SQL_PH_ORDER_ROUTING_DELETE = (String) sqlMap.get( "DeleteSQL" );
				pstmt_delete = connection.prepareStatement( SQL_PH_ORDER_ROUTING_DELETE ) ;
				pstmt_delete.setString(1,ordering_facility_id.trim());
				pstmt_delete.setString(2,ordering_source_type.trim());
				pstmt_delete.setString(3,ordering_source_code.trim());
			}
			else {		
				ordering_facility_id = (String)DeleteData.get(0);
				ordering_source_type = (String)DeleteData.get(1);
				ordering_source_code = (String)DeleteData.get(2);
				routing_level		 = (String)DeleteData.get(3);
				routing_code		 = (String)DeleteData.get(4);
				final String SQL_PH_ORDER_ROUTING_DTL_DELETE = (String) sqlMap.get( "DeleteSQL" );
				pstmt_delete = connection.prepareStatement( SQL_PH_ORDER_ROUTING_DTL_DELETE ) ;
				pstmt_delete.setString(1,ordering_facility_id.trim());
				pstmt_delete.setString(2,ordering_source_type.trim());
				pstmt_delete.setString(3,ordering_source_code.trim());
				pstmt_delete.setString(4,routing_level.trim());
				pstmt_delete.setString(5,routing_code.trim());

			}			
			pstmt_delete.executeUpdate();
			map.put( "result", new Boolean( true ) ) ;
			messages.append( "RECORD_DELETED" ) ;
			connection.commit();
		}
		catch(Exception e){
			map.put( "result", new Boolean( false ) ) ;
			messages.append(e);
			try{
				connection.rollback();
			}
			catch(Exception ee){
				map.put( "result", new Boolean( false ) ) ;
				messages.append(e);
				ee.printStackTrace();
			}
		}
		finally {
			try {
				closeStatement( pstmt_delete ) ;
				closeConnection( connection,prop );
			} 
			catch ( Exception fe ) {
				map.put( "result", new Boolean( false ) ) ;
				fe.printStackTrace() ;
				messages.append(fe);
			}
		}
		map.put( "msgid", messages.toString() ) ;
		map.put( "flag","0");
		return map ;
	}
	// delete method ends here
}
