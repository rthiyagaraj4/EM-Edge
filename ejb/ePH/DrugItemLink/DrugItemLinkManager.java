/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH.DrugItemLink ;

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
*	name="DrugItemLink"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="DrugItemLink"
*	local-jndi-name="DrugItemLink"
*	impl-class-name="ePH.DrugItemLink.DrugItemLinkManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.DrugItemLink.DrugItemLinkLocal"
*	remote-class="ePH.DrugItemLink.DrugItemLinkRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.DrugItemLink.DrugItemLinkLocalHome"
*	remote-class="ePH.DrugItemLink.DrugItemLinkHome"
*	generate= "local,remote"
*
*
*/
public class DrugItemLinkManager extends PhEJBSessionAdapter {
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap modify( HashMap tabData, HashMap sqlMap )  {
		
		StringBuffer messages = new StringBuffer() ;
		String debug = "From EJB : ";
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;		
		final String SQL_PH_DRUG_ITEM_LINK_UPDATE			= (String) sqlMap.get( "SQL_PH_DRUG_ITEM_LINK_UPDATE" );
		final String SQL_PH_INVENTORY_ITEM_FOR_DRUG_INSERT	= (String) sqlMap.get( "SQL_PH_INVENTORY_ITEM_FOR_DRUG_INSERT" );

		ArrayList modifyData			=	(ArrayList)tabData.get("ModifyData");
		ArrayList mandatory_flds		=	(ArrayList)tabData.get("mandatory_flds");

		HashMap modifyRecords			=	null;	
		Connection connection			=	null ;
		PreparedStatement pstmt_modify	=	null ;
		PreparedStatement pstmt_insert	=	null ;
		boolean modify_rec				=	false;
		boolean insert_rec				=	false;

		try {
			connection = getConnection( (Properties)tabData.get( "properties" ) ) ;
			pstmt_modify = connection.prepareStatement( SQL_PH_DRUG_ITEM_LINK_UPDATE ) ;
				// clear the batch
			pstmt_modify.clearBatch();
			for (int i=0;i<modifyData.size() ;i++ ){
				modifyRecords=new HashMap();
				modifyRecords=(HashMap)modifyData.get(i); 
				pstmt_modify.setString(1,(String)modifyRecords.get("ITEM_CODE"));
				pstmt_modify.setString(2,(String)modifyRecords.get("ITEM_DESC"));
				pstmt_modify.setString(3,(String)modifyRecords.get("DRUG_CODE"));
				// add the statement to the batch
				pstmt_modify.addBatch();	
				}
							
				int[] result_modify= pstmt_modify.executeBatch();
					for (int i=0;i<result_modify.length ;i++ ){
						if(result_modify[i]<0  && result_modify[i] != -2 ){
							modify_rec=false;
							break;
						}
						else{
							modify_rec=true;
						}
				  }

			if(modify_rec){
			
				pstmt_insert = connection.prepareStatement( SQL_PH_INVENTORY_ITEM_FOR_DRUG_INSERT ) ;

				for (int i=0;i<modifyData.size() ;i++ ){
				modifyRecords=(HashMap)modifyData.get(i); 
				pstmt_insert.setString(1,(String)modifyRecords.get("DRUG_CODE"));
				pstmt_insert.setString(2,(String)modifyRecords.get("ITEM_CODE"));
				pstmt_insert.setString(3,(String)modifyRecords.get("STOCK_UOM"));
				pstmt_insert.setString(4,(String)modifyRecords.get("CONTENT_IN_PRES_BASE_UOM"));
				pstmt_insert.setString(5,"");
				pstmt_insert.setString(6,(String) mandatory_flds.get(0) );
				pstmt_insert.setString(7,(String) mandatory_flds.get(1) );
				pstmt_insert.setString(8,(String) mandatory_flds.get(2) );
				pstmt_insert.setString(9,(String) mandatory_flds.get(0) );
				pstmt_insert.setString(10,(String) mandatory_flds.get(1) );
				pstmt_insert.setString(11,(String) mandatory_flds.get(2) );
				// add the statement to the batch
				pstmt_insert.addBatch();	
				}
							
				int[] result_insert= pstmt_insert.executeBatch();
					for (int i=0;i<result_insert.length ;i++ ){
						if(result_insert[i]<0  && result_insert[i] != -2 ){
							insert_rec=false;
							break;
						}
						else{
							insert_rec=true;
						}
				  }
				
				if(insert_rec) {
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append( "RECORD_INSERTED" ) ;
				}
				else	{
				connection.rollback();
				map.put( "result", new Boolean( false ) ) ;
				throw new EJBException("Insert/Update Failed");		

				}
			}
			else{
				connection.rollback();
				map.put( "result", new Boolean( false ) ) ;
				throw new EJBException("Insert/Update Failed");		
			}
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
		} finally {
			try {
				closeStatement( pstmt_modify ) ;
				closeStatement( pstmt_insert ) ;
				closeConnection( connection,(Properties)tabData.get( "properties" ) );
			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		map.put( "msgid", messages.toString() ) ;
		map.put( "flag", debug ) ;
		return map ;
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
public HashMap insert( HashMap tabData, HashMap sqlMap )  {
HashMap map = new HashMap() ;
map.put( "result", new Boolean( true ) ) ;
map.put( "flag", "0" ) ;
return map;
	
}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
public HashMap delete( HashMap tabData, HashMap sqlMap )  {
HashMap map = new HashMap() ;
map.put( "result", new Boolean( true ) ) ;
map.put( "flag", "0" ) ;
return map;
	
}



}//class
