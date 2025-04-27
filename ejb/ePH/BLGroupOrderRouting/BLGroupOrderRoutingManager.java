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
16/03/2021   IN15664         Manickavasagam J	 	   			COMMON-ICN-0029
---------------------------------------------------------------------------------------------------------------
*/
package ePH.BLGroupOrderRouting ;

import java.rmi.* ;
import java.util.* ;
//import java.util.ArrayList;
//import java.util.Properties;
import java.sql.* ;
import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;
/**
*
* @ejb.bean
*	name="BLGroupOrderRouting"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="BLGroupOrderRouting"
*	local-jndi-name="BLGroupOrderRouting"
*	impl-class-name="ePH.BLGroupOrderRouting.BLGroupOrderRoutingManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.BLGroupOrderRouting.BLGroupOrderRoutingLocal"
*	remote-class="ePH.BLGroupOrderRouting.BLGroupOrderRoutingRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.BLGroupOrderRouting.BLGroupOrderRoutingLocalHome"
*	remote-class="ePH.BLGroupOrderRouting.BLGroupOrderRoutingHome"
*	generate= "local,remote"
*
*
*/ 
public class BLGroupOrderRoutingManager extends PhEJBSessionAdapter {
	Properties prop=null;
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;			
		
		final String SQL_PH_BL_GROUP_ORDER_ROUTING_INSERT = (String) sqlMap.get( "SQL_PH_BL_GROUP_ORDER_ROUTING_INSERT" );
		final String SQL_PH_BL_GROUP_ORDER_ROUTING_DTL_INSERT = (String) sqlMap.get( "SQL_PH_BL_GROUP_ORDER_ROUTING_DTL_INSERT" );
		//final String SQL_PH_BLGROUP_ALT_DISP_LOCN_INSERT = (String) sqlMap.get( "SQL_PH_BLGROUP_ALT_DISP_LOCN_INSERT" );

		prop  = (Properties)tabData.get( "properties" );			            
		String  login_by_id			= (String)tabData.get("login_by_id");
		String	login_at_ws_no		= (String)tabData.get("login_at_ws_no");
		String	login_facility_id	= (String)tabData.get("login_facility_id");
		/*int insert_flag=0;
		int update_flag=0;
		int insert_record1=0;
		int res=0;Unused local variable INC63877*/

		ArrayList CommonData		= (ArrayList)tabData.get("CommonData");
		ArrayList ALTDispDetails		= (ArrayList)tabData.get("ALTDispDetails");
		String	ordering_facility_id = (String)CommonData.get(0);
		String	ordering_source_type = (String)CommonData.get(1);
		String	ordering_source_code = (String)CommonData.get(2);
		//String disp_locn_code        = (String)CommonData.get(3);Unused local variable INC63877
		//String day_type              =(String)CommonData.get(4);Unused local variable INC63877
		String routing_code				= "";
		String performing_facility_id	= "";
		String rtn_ord_disp_locn_code	= "";
		String stat_ord_disp_locn_code	= "";
		String disch_ord_disp_locn_code = "";
		String billing_group            = "";
		String customer_group           = "";
		String customer_id              = "";
		String polocy_type              = "";
		
		String frmtime="";
		String totime="";

		ArrayList MultipleData		= (ArrayList)tabData.get("MultipleData");

		String routing_level="";
		Connection connection = null ;
		PreparedStatement pstmt_insert1=null,pstmt_insert2 = null;//pstmt_insert=null,pstmt_update=null ;Unused local variable INC63877
		boolean sourceFlag =false;
		boolean otherThanSourceFlag =false;
		ArrayList dataRow = null;
		try{
			connection = getConnection( prop ) ;
			pstmt_insert1 = connection.prepareStatement( SQL_PH_BL_GROUP_ORDER_ROUTING_INSERT ) ;
			pstmt_insert2 = connection.prepareStatement( SQL_PH_BL_GROUP_ORDER_ROUTING_DTL_INSERT ) ;
			for (int i=0;i<MultipleData.size() ;i++ ){
				dataRow = (ArrayList)MultipleData.get(i);
				routing_level			= (String)dataRow.get(0);
				routing_code				= (String)dataRow.get(1);
				performing_facility_id	= (String)dataRow.get(2);
				rtn_ord_disp_locn_code	= (String)dataRow.get(3);
				stat_ord_disp_locn_code	= (String)dataRow.get(4);
				disch_ord_disp_locn_code = (String)dataRow.get(5);
				billing_group            = (String)dataRow.get(6);
				customer_group           = (String)dataRow.get(7);
				customer_id              = (String)dataRow.get(8);
				polocy_type              = (String)dataRow.get(9);
				frmtime="";
				totime="";
				
				if (routing_code==null || routing_code.equals("")){
					sourceFlag = true;
					pstmt_insert1.setString(1,ordering_facility_id.trim());
					pstmt_insert1.setString(2,ordering_source_type.trim());
					pstmt_insert1.setString(3,ordering_source_code.trim());
					pstmt_insert1.setString(4,billing_group.trim());
					pstmt_insert1.setString(5,customer_group.trim());
					pstmt_insert1.setString(6,customer_id.trim());
					pstmt_insert1.setString(7,polocy_type.trim());
					pstmt_insert1.setString(8,performing_facility_id.trim());
					pstmt_insert1.setString(9,rtn_ord_disp_locn_code.trim());
					pstmt_insert1.setString(10,stat_ord_disp_locn_code.trim());
					pstmt_insert1.setString(11,disch_ord_disp_locn_code.trim());
					pstmt_insert1.setString(12,login_by_id.trim());
					pstmt_insert1.setString(13,login_at_ws_no.trim());
					pstmt_insert1.setString(14,login_facility_id.trim());
					pstmt_insert1.setString(15,login_by_id.trim());
					pstmt_insert1.setString(16,login_at_ws_no.trim());
					pstmt_insert1.setString(17,login_facility_id.trim());
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
					pstmt_insert2.setString(16,billing_group.trim());
					pstmt_insert2.setString(17,customer_group.trim());
					pstmt_insert2.setString(18,customer_id.trim());
					pstmt_insert2.setString(19,polocy_type.trim());
					pstmt_insert2.addBatch();
				}
			}
			if (sourceFlag==true){
				int[] result1= pstmt_insert1.executeBatch();
				for ( int i=0;i<result1.length ;i++ ){
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
				for ( int i=0;i<result2.length ;i++ ){
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result2[i]<0  && result2[i] != -2 ){
						pstmt_insert2.cancel();
						throw new EJBException("Insert Failed");
					}			
				}			
			}
			if(ALTDispDetails.size()>0) {
				updateTable( connection,tabData, sqlMap ) ;
			}
			map.put( "result", new Boolean( true ) ) ;
			messages.append( "RECORD_INSERTED" ) ;
			connection.commit();
		}
		catch( Exception e ) {
			System.err.println("Error @ inserting BLGroupOrderRouting tabData="+tabData);
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
				fe.printStackTrace() ;
			}
		}
		map.put( "msgid", messages.toString() ) ;
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
		
		final String SQL_PH_BL_GROUP_ORDER_ROUTING_DTL_UPDATE = (String) sqlMap.get("ModifySQL");
		
		Properties  prop  = (Properties)tabData.get( "properties" );			            
		ArrayList ModifyData  = (ArrayList)tabData.get("ModifyData");
		ArrayList ALTDispDetails		= (ArrayList)tabData.get("ALTDispDetails");
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
		String billing_group_code = (String)ModifyData.get(9); 
		String customer_group_code = (String)ModifyData.get(10); 
		String customer_id_code = (String)ModifyData.get(11); 
		String polocy_type_code = (String)ModifyData.get(12); 
		Connection connection = null ;
		PreparedStatement pstmt_update = null ;
		try {
			connection = getConnection( prop ) ;
			pstmt_update = connection.prepareStatement( SQL_PH_BL_GROUP_ORDER_ROUTING_DTL_UPDATE ) ;
			pstmt_update.setString(1,performing_facility_id.trim());
			pstmt_update.setString(2,rtn_ord_disp_locn_code.trim());
			pstmt_update.setString(3,stat_ord_disp_locn_code.trim());
			pstmt_update.setString(4,disch_ord_disp_locn_code.trim());
			pstmt_update.setString(5,customer_group_code.trim());
			pstmt_update.setString(6,customer_id_code.trim());
			pstmt_update.setString(7,polocy_type_code.trim());
			pstmt_update.setString(8,login_by_id.trim());
			pstmt_update.setString(9,login_at_ws_no.trim());
			pstmt_update.setString(10,login_facility_id.trim());
			pstmt_update.setString(11,ordering_facility_id.trim());
			pstmt_update.setString(12,ordering_source_type.trim());
			pstmt_update.setString(13,ordering_source_code.trim());
			pstmt_update.setString(14,routing_level.trim());
			pstmt_update.setString(15,routing_code.trim());
			pstmt_update.setString(16,billing_group_code.trim());
			pstmt_update.setString(17,customer_group_code.trim());
			pstmt_update.setString(18,customer_id_code.trim());
			pstmt_update.setString(19,polocy_type_code.trim());
			//int result= //commented for COMMON-ICN-0048 
			pstmt_update.executeUpdate();//Modified for COMMON-ICN-0048
			if(ALTDispDetails.size()>0) 
				updateTable( connection,tabData, sqlMap ) ;

			map.put( "result", new Boolean( true ) ) ;				
			map.put( "msgid","RECORD_MODIFIED");
			connection.commit();
		}
		catch( Exception e ) {
			System.err.println("Error @ Modify BLGroupOrderRouting tabData="+tabData);
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
		return map ;
	}
	// delete method starts here
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap delete(HashMap tabData, HashMap sqlMap )  {

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
		String routing_code = "",billing_group = "",customer_id = "",polocy_type = "",customer_group = "";       
		Connection connection = null ;
		PreparedStatement pstmt_delete=null;
		PreparedStatement pstmt_delete_alt=null;
		try{
			connection = getConnection( prop ) ;
			if (DeleteData.size()==7){
				ordering_facility_id = (String)DeleteData.get(0);
				ordering_source_type = (String)DeleteData.get(1);
				ordering_source_code = (String)DeleteData.get(2);
				billing_group        = (String)DeleteData.get(3);
				customer_group       = (String)DeleteData.get(4);
				customer_id          = (String)DeleteData.get(5);
				polocy_type          = (String)DeleteData.get(6);
				final String SQL_PH_BL_ORDER_ROUTING_DELETE = (String) sqlMap.get( "DeleteSQL" );
				pstmt_delete = connection.prepareStatement( SQL_PH_BL_ORDER_ROUTING_DELETE ) ;
				pstmt_delete.setString(1,ordering_facility_id.trim());
				pstmt_delete.setString(2,ordering_source_type.trim());
				pstmt_delete.setString(3,ordering_source_code.trim());
				pstmt_delete.setString(4,billing_group.trim());
				pstmt_delete.setString(5,customer_group.trim());
				pstmt_delete.setString(6,customer_id.trim());
				pstmt_delete.setString(7,polocy_type.trim());
				//int result = //commented for COMMON-ICN-0048
				pstmt_delete.executeUpdate(); //Modified for COMMON-ICN-0048
				final String SQL_PH_BL_ORDER_ROUTING_ALT_DELETE_FOR_SOURCE = (String) sqlMap.get( "DeleteALTSQL" );
				pstmt_delete_alt = connection.prepareStatement( SQL_PH_BL_ORDER_ROUTING_ALT_DELETE_FOR_SOURCE ) ;
				pstmt_delete_alt.setString(1,ordering_facility_id.trim());
				pstmt_delete_alt.setString(2,ordering_source_type.trim());
				pstmt_delete_alt.setString(3,ordering_source_code.trim());
				//int result_Alt = //commented for COMMON-ICN-0048
				pstmt_delete_alt.executeUpdate(); //Modified for COMMON-ICN-0048
			}
			else {		
				ordering_facility_id = (String)DeleteData.get(0);
				ordering_source_type = (String)DeleteData.get(1);
				ordering_source_code = (String)DeleteData.get(2);
				routing_level		 = (String)DeleteData.get(3);
				routing_code		 = (String)DeleteData.get(4);
				billing_group        = (String)DeleteData.get(5);
				customer_group       = (String)DeleteData.get(6);
				customer_id          = (String)DeleteData.get(7);
				polocy_type          = (String)DeleteData.get(8);
				final String SQL_PH_BL_ORDER_ROUTING_DTL_DELETE = (String) sqlMap.get( "DeleteSQL" );
				pstmt_delete = connection.prepareStatement( SQL_PH_BL_ORDER_ROUTING_DTL_DELETE ) ;
				pstmt_delete.setString(1,ordering_facility_id.trim());
				pstmt_delete.setString(2,ordering_source_type.trim());
				pstmt_delete.setString(3,ordering_source_code.trim());
				pstmt_delete.setString(4,routing_level.trim());
				pstmt_delete.setString(5,routing_code.trim());
				pstmt_delete.setString(6,billing_group.trim());
				pstmt_delete.setString(7,customer_group.trim());
				pstmt_delete.setString(8,customer_id.trim());
				pstmt_delete.setString(9,polocy_type.trim());
				//int result = //Commented by Prabha
				pstmt_delete.executeUpdate(); //Modified by Prabha
				final String SQL_PH_BL_ORDER_ROUTING_ALT_DELETE = (String) sqlMap.get( "DeleteALTSQL" );
				pstmt_delete_alt = connection.prepareStatement( SQL_PH_BL_ORDER_ROUTING_ALT_DELETE ) ;
				pstmt_delete_alt.setString(1,ordering_facility_id.trim());
				pstmt_delete_alt.setString(2,ordering_source_type.trim());
				pstmt_delete_alt.setString(3,ordering_source_code.trim());
				pstmt_delete_alt.setString(4,routing_level.trim());
				pstmt_delete_alt.setString(5,routing_code.trim());
				//int result_Alt =  //Commented by Prabha
				pstmt_delete_alt.executeUpdate(); //Modified by Prabha
			}			
			//int result = pstmt_delete.executeUpdate();
			map.put( "result", new Boolean( true ) ) ;
			messages.append( "RECORD_DELETED" ) ;
			connection.commit();
		}
		catch(Exception e){
			System.err.println("Error @ Deleting BLGroupOrderRouting tabData="+tabData);
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
				closeStatement( pstmt_delete_alt ) ;//common-icn-0029
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
	}	// delete method ends here

	private void updateTable(  Connection connection,HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;

		//Connection connection = null ;
		String frmtime="";
		String totime="";
		PreparedStatement pstmt_insert = null ;
		PreparedStatement pstmt_update = null ;
		/*int insert_record1=0;
	    int insert_flag=0;
		int update_flag=0;
		int res=0;
		int res1=0;
		int res2=0;Unused local variable INC63877*/
		try {
			//HashMap commonData		= (HashMap)tabData.get( "COMMONDATA" ); //commented for COMMON-ICN-0048
			ArrayList ALTDispDetails		= (ArrayList)tabData.get("ALTDispDetails");
			//connection = getConnection( (Properties)tabData.get( "PROPERTIES" ) ) ;
			pstmt_insert = connection.prepareStatement( (String) sqlMap.get( "INSERTSQL" ) ) ;
			pstmt_update= connection.prepareStatement( (String) sqlMap.get( "UPDATESQL" ) ) ; 	

			/*String disp_locn_code=""; 
			String routing_level="";Unused local variable INC63877*/
			String routing_code="";
			/*String day_type="";
			String ordering_facility_id="";
			String ordering_source_type="";
			String performing_facility_id="";
			String ordering_source_code="";Unused local variable INC63877*/
			String login_by_id			= (String)tabData.get("login_by_id");
		    String login_at_ws_no		= (String)tabData.get("login_at_ws_no");
		    String login_facility_id	= (String)tabData.get("login_facility_id");
			ArrayList altdisplocns=new ArrayList();
			HashMap rtn=new HashMap();
			HashMap stat=new HashMap();
			HashMap D=new HashMap();
			HashMap tempaltdisp			=new HashMap();
			String key, flag;// code, priority ;Unused local variable INC63877
			Set keyset;
			Iterator keyiterator;
			HashMap record = null;
			if(ALTDispDetails.size()>0){   
				for(int k=0;k<ALTDispDetails.size();k+=3){
					rtn=(HashMap)ALTDispDetails.get(k);
					stat=(HashMap)ALTDispDetails.get(k+1);
					D=(HashMap)ALTDispDetails.get(k+2);
				}
				if( stat!=null || !stat.equals("")){
					keyset = stat.keySet() ;
					keyiterator= keyset.iterator() ;
					while(keyiterator.hasNext()){
						key   = (String)keyiterator.next();
						tempaltdisp  = (HashMap)stat.get(key);
					}
					keyset = tempaltdisp.keySet() ;
					keyiterator= keyset.iterator() ;
					while(keyiterator.hasNext()){
						key   = (String)keyiterator.next();
						altdisplocns  = (ArrayList)tempaltdisp.get(key);
						for(int j=0;j<altdisplocns.size();j++){
							record	=(HashMap)altdisplocns.get((j));
							routing_code=(String)record.get("routing_code");
							if(routing_code.equals(""))
								routing_code="*A";
							pstmt_update.setString(1, (String)record.get("order_fcy"));//ordering_facility_id
							pstmt_update.setString(2, (String)record.get("order_src_type"));//ordering_source_type
							pstmt_update.setString(3, (String)record.get("ord_src_code"));//ordering_source_code
							pstmt_update.setString(4, (String)record.get("perform_fcy"));//performing_facility_id
							pstmt_update.setString(5, (String)record.get("disp_locn_code"));//disp_locn_code
							pstmt_update.setString(6, (String)record.get("day_type"));//day_type
							pstmt_update.setString(7, (String)record.get("id"));//priority
							pstmt_update.setString(8, (String)record.get("routing_level_code"));//routing_level
							pstmt_update.setString(9, routing_code);//
							pstmt_update.addBatch();
						}
					}
				}

				if( rtn!=null || !rtn.equals("")){
					keyset = rtn.keySet() ;
					keyiterator= keyset.iterator() ;
					while(keyiterator.hasNext()){
						key   = (String)keyiterator.next();
						tempaltdisp  = (HashMap)rtn.get(key);
					}
					keyset = tempaltdisp.keySet() ;
					keyiterator= keyset.iterator() ;
					while(keyiterator.hasNext()){
						key   = (String)keyiterator.next();
						altdisplocns  = (ArrayList)tempaltdisp.get(key);
						for(int j=0;j<altdisplocns.size();j++){
							record	=(HashMap)altdisplocns.get((j));
							routing_code=(String)record.get("routing_code");
							if(routing_code.equals(""))
								routing_code="*A";
							pstmt_update.setString(1, (String)record.get("order_fcy"));//ordering_facility_id
							pstmt_update.setString(2, (String)record.get("order_src_type"));//ordering_source_type
							pstmt_update.setString(3, (String)record.get("ord_src_code"));//ordering_source_code
							pstmt_update.setString(4, (String)record.get("perform_fcy"));//performing_facility_id
							pstmt_update.setString(5, (String)record.get("disp_locn_code"));//disp_locn_code
							pstmt_update.setString(6, (String)record.get("day_type"));//day_type
							pstmt_update.setString(7, (String)record.get("id"));//priority
							pstmt_update.setString(8, (String)record.get("routing_level_code"));//routing_level
							pstmt_update.setString(9, routing_code);//
							pstmt_update.addBatch();

						}
					}
				}

				if( D!=null || !D.equals("")){
					keyset = D.keySet() ;
					keyiterator= keyset.iterator() ;
					while(keyiterator.hasNext()){
						key   = (String)keyiterator.next();
						tempaltdisp  = (HashMap)D.get(key);
					}
					keyset = tempaltdisp.keySet() ;
					keyiterator= keyset.iterator() ;
					while(keyiterator.hasNext()){
						key   = (String)keyiterator.next();
						altdisplocns  = (ArrayList)tempaltdisp.get(key);
						for( int j=0;j<altdisplocns.size();j++){
							record	=(HashMap)altdisplocns.get((j));
							routing_code=(String)record.get("routing_code");
							if(routing_code.equals(""))
								routing_code="*A";
							pstmt_update.setString(1, (String)record.get("order_fcy"));//ordering_facility_id
							pstmt_update.setString(2, (String)record.get("order_src_type"));//ordering_source_type
							pstmt_update.setString(3, (String)record.get("ord_src_code"));//ordering_source_code
							pstmt_update.setString(4, (String)record.get("perform_fcy"));//performing_facility_id
							pstmt_update.setString(5, (String)record.get("disp_locn_code"));//disp_locn_code
							pstmt_update.setString(6, (String)record.get("day_type"));//day_type
							pstmt_update.setString(7, (String)record.get("id"));//priority
							pstmt_update.setString(8, (String)record.get("routing_level_code"));//routing_level
							pstmt_update.setString(9, routing_code);//
							pstmt_update.addBatch();
						}	
					}
				}
				int[] result=pstmt_update.executeBatch();	
				for (int i=0;i<result.length ;i++ ){
					if(result[i]<0  && result[i] != -2 ){
						pstmt_update.cancel();
						connection.rollback();
						throw new EJBException("Error: Insert Dtl Tmp failed");
					}		
				}

				for(int k=0;k<ALTDispDetails.size();k+=3){
					rtn=(HashMap)ALTDispDetails.get(k);
					stat=(HashMap)ALTDispDetails.get(k+1);
					D=(HashMap)ALTDispDetails.get(k+2);
				}
				//for( int i=0;i<ALTDispDetails.size();i++){
					if( !stat.isEmpty()){
						keyset = stat.keySet() ;
						keyiterator= keyset.iterator() ;
						while(keyiterator.hasNext()){
							key   = (String)keyiterator.next();
							tempaltdisp  = (HashMap)stat.get(key);
						}
						keyset = tempaltdisp.keySet() ;
						keyiterator= keyset.iterator() ;
						while(keyiterator.hasNext()){
							key   = (String)keyiterator.next();
							altdisplocns  = (ArrayList)tempaltdisp.get(key);
							
						for(int j=0;j<altdisplocns.size();j++){
							record	=(HashMap)altdisplocns.get((j));
							flag=(String)record.get("flag");
							frmtime=(String)record.get("frmtime");
							totime=(String)record.get("totime");

							if(flag.equals("I") && !frmtime.equals("") && !totime.equals("") ){
								routing_code=(String)record.get("routing_code");
								if(routing_code.equals(""))
									routing_code="*A";

								pstmt_insert.setString(1, (String)record.get("order_fcy"));//ordering_facility_id
								pstmt_insert.setString(2, (String)record.get("order_src_type"));//ordering_source_type
								pstmt_insert.setString(3, (String)record.get("ord_src_code"));//ordering_source_code
								pstmt_insert.setString(4, (String)record.get("perform_fcy"));//performing_facility_id
								pstmt_insert.setString(6, (String)record.get("code")); //code
								pstmt_insert.setString(5, (String)record.get("disp_locn_code"));//disp_locn_code
								pstmt_insert.setString(7, (String)record.get("day_type"));//day_type
								pstmt_insert.setString(8, login_by_id);
								pstmt_insert.setString(9, login_at_ws_no);
								pstmt_insert.setString(10, login_facility_id);
								pstmt_insert.setString(11, login_by_id);
								pstmt_insert.setString(12, login_at_ws_no);
								pstmt_insert.setString(13, login_facility_id);
								pstmt_insert.setString(14, frmtime);
								pstmt_insert.setString(15, totime);
								pstmt_insert.setString(16, (String)record.get("eff_status"));
								pstmt_insert.setString(17, (String)record.get("id"));//priority
								pstmt_insert.setString(18, (String)record.get("routing_level_code"));//routing_level
									pstmt_insert.setString(19, routing_code);//routing_code
								pstmt_insert.addBatch();	
							}
						}	
					}
					result=pstmt_insert.executeBatch();	
					for ( int i=0;i<result.length ;i++ ){
						if(result[i]<0  && result[i] != -2 ){
							pstmt_insert.cancel();
							connection.rollback();
							throw new EJBException("insertion failed for stat orders");
						}		
					}
				}
				if( !rtn.isEmpty()){
					keyset = rtn.keySet() ;
					keyiterator= keyset.iterator() ;
					keyset = rtn.keySet() ;
					keyiterator= keyset.iterator() ;
					while(keyiterator.hasNext()){
						key   = (String)keyiterator.next();
						tempaltdisp  = (HashMap)rtn.get(key);
					}
					keyset = tempaltdisp.keySet() ;
					keyiterator= keyset.iterator() ;
					while(keyiterator.hasNext()){
						key   = (String)keyiterator.next();
						altdisplocns  = (ArrayList)tempaltdisp.get(key);
						for( int j=0;j<altdisplocns.size();j++){
							record	=(HashMap)altdisplocns.get((j));
							flag=(String)record.get("flag");
							frmtime=(String)record.get("frmtime");
							totime=(String)record.get("totime");
							if(flag.equals("I") && !frmtime.equals("") && !totime.equals("") ){
								routing_code=(String)record.get("routing_code");
								if(routing_code.equals(""))
									routing_code="*A";

								pstmt_insert.setString(1, (String)record.get("order_fcy"));//ordering_facility_id
								pstmt_insert.setString(2, (String)record.get("order_src_type"));//ordering_source_type
								pstmt_insert.setString(3, (String)record.get("ord_src_code"));//ordering_source_code
								pstmt_insert.setString(4, (String)record.get("perform_fcy"));//performing_facility_id
								pstmt_insert.setString(6, (String)record.get("code")); //code
								pstmt_insert.setString(5, (String)record.get("disp_locn_code"));//disp_locn_code
								pstmt_insert.setString(7, (String)record.get("day_type"));//day_type
								pstmt_insert.setString(8, login_by_id);
								pstmt_insert.setString(9, login_at_ws_no);
								pstmt_insert.setString(10, login_facility_id);
								pstmt_insert.setString(11, login_by_id);
								pstmt_insert.setString(12, login_at_ws_no);
								pstmt_insert.setString(13, login_facility_id);
								pstmt_insert.setString(14, frmtime);
								pstmt_insert.setString(15, totime);
								pstmt_insert.setString(16, (String)record.get("eff_status"));
								pstmt_insert.setString(17, (String)record.get("id"));//priority
								pstmt_insert.setString(18, (String)record.get("routing_level_code"));//routing_level
								pstmt_insert.setString(19, routing_code);//routing_code
								pstmt_insert.addBatch();	
							}
						}	
					}
					result=pstmt_insert.executeBatch();	
					for ( int i=0;i<result.length ;i++ ){
						if(result[i]<0  && result[i] != -2 ){
							pstmt_insert.cancel();
							connection.rollback();
							throw new EJBException("insertion failed for rtn orders");
						}		
					}
				}
				if( !D.isEmpty()){
					keyset = D.keySet() ;
					keyiterator= keyset.iterator() ;
					while(keyiterator.hasNext()){
						key   = (String)keyiterator.next();
							tempaltdisp  = (HashMap)D.get(key);
						}
						keyset = tempaltdisp.keySet() ;
						keyiterator= keyset.iterator() ;
						while(keyiterator.hasNext()){
							key   = (String)keyiterator.next();
							altdisplocns  = (ArrayList)tempaltdisp.get(key);
							for( int j=0;j<altdisplocns.size();j++){
								record	=(HashMap)altdisplocns.get((j));
								
								flag=(String)record.get("flag");
								frmtime=(String)record.get("frmtime");
								totime=(String)record.get("totime");
								if(flag.equals("I") && !frmtime.equals("") && !totime.equals("") ){
									routing_code=(String)record.get("routing_code");
									if(routing_code.equals(""))
										routing_code="*A";

									pstmt_insert.setString(1, (String)record.get("order_fcy"));//ordering_facility_id
									pstmt_insert.setString(2, (String)record.get("order_src_type"));//ordering_source_type
									pstmt_insert.setString(3, (String)record.get("ord_src_code"));//ordering_source_code
									pstmt_insert.setString(4, (String)record.get("perform_fcy"));//performing_facility_id
									pstmt_insert.setString(6, (String)record.get("code")); //code
									pstmt_insert.setString(5, (String)record.get("disp_locn_code"));//disp_locn_code
									pstmt_insert.setString(7, (String)record.get("day_type"));//day_type
									pstmt_insert.setString(8, login_by_id);
									pstmt_insert.setString(9, login_at_ws_no);
									pstmt_insert.setString(10, login_facility_id);
									pstmt_insert.setString(11, login_by_id);
									pstmt_insert.setString(12, login_at_ws_no);
									pstmt_insert.setString(13, login_facility_id);
									pstmt_insert.setString(14, frmtime);
									pstmt_insert.setString(15, totime);
									pstmt_insert.setString(16, (String)record.get("eff_status"));
									pstmt_insert.setString(17, (String)record.get("id"));//priority
									pstmt_insert.setString(18, (String)record.get("routing_level_code"));//routing_level
									pstmt_insert.setString(19, routing_code);//routing_code
									pstmt_insert.addBatch();	
								}
							}
						}
						result=pstmt_insert.executeBatch();	
						for ( int i=0;i<result.length ;i++ ){
							if(result[i]<0  && result[i] != -2 ){
								pstmt_insert.cancel();
								connection.rollback();
								throw new EJBException("insertion failed for D orders");
							}		
						}
					}
				//}
			}
		}
		catch ( Exception e ){				
			e.printStackTrace() ;
		}
		finally {
			try{
				closeStatement(pstmt_update);
				closeStatement( pstmt_insert) ;
			}
			catch(Exception es){ 
				es.printStackTrace();	
			}
		}
	}
}
