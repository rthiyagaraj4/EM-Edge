/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------

11/3/2021              TFS:15756               Shazana                           								check Style Audit report 
--------------------------------------------------------------------------------------------------------------------------------------------
*/

 package eSS.AlternateGroup;

//import java.rmi.RemoteException;
import eSS.Common.SsEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;
import java.sql.* ;

/**
*
* @ejb.bean
*	name="AlternateGroup"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AlternateGroup"
*	local-jndi-name="AlternateGroup"
*	impl-class-name="eSS.AlternateGroup.AlternateGroupManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.AlternateGroup.AlternateGroupLocal"
*	remote-class="eSS.AlternateGroup.AlternateGroupRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.AlternateGroup.AlternateGroupLocalHome"
*	remote-class="eSS.AlternateGroup.AlternateGroupHome"
*	generate= "local,remote"
*
*
*/

public class  AlternateGroupManager extends SsEJBSessionAdapter {

      /**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	 public HashMap insert( HashMap tabData, HashMap sqlMap ) {
		StringBuffer messages						=		new StringBuffer() ;
		String debug								=		"From EJB : ";

		HashMap map									=		new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		Properties	properties						=		null;

		Connection connection						=		null ;
		PreparedStatement pstmt_insert				=		null ;
		PreparedStatement pstmt_delete				=		null ;
																												
		final String SQL_SS_ALTERNATE_GROUP_INSERT  =		(String) sqlMap.get( "SQL_SS_ALTERNATE_GROUP_INSERT" );
		final String SQL_SS_ALTERNATE_GROUP_DELETE  =		(String) sqlMap.get( "SQL_SS_ALTERNATE_GROUP_DELETE" );

		ArrayList insertData						=		(ArrayList)tabData.get("InsertData");
		ArrayList insertRecords						=		null;
		ArrayList deleteData						=		(ArrayList)tabData.get("DeleteData");
		ArrayList deleteRecords						=		null;

		boolean insert_rec							=		false;
		boolean delete_rec							=		false;

		try {
			properties								=		(Properties)	tabData.get("properties");
			connection								=		getConnection(properties);
			pstmt_insert							=		connection.prepareStatement( SQL_SS_ALTERNATE_GROUP_INSERT ) ;
			
			// clear the batch
			pstmt_insert.clearBatch();
			if(insertData.size()>0){
				insert_rec							=		true;
			}
			else{
				insert_rec							=		false;		
			}

		
			if(deleteData.size()>0){
				delete_rec							=		true;
			}
			else{
				delete_rec							=		false;		
			}
			
			if(insert_rec){
				for (int i=0;i<insertData.size() ;i++ ){
					insertRecords					=		new ArrayList();
					insertRecords					=		(ArrayList)insertData.get(i); 
							int fld=1;
							for (int j=0;j<insertRecords.size() ;j++ ){
								pstmt_insert.setString(fld,(String)insertRecords.get(j));
							
							fld++;
							}
					// add the statement to the batch
					pstmt_insert.addBatch();				
				}
				
				
				int[] result_insert					=		pstmt_insert.executeBatch();
				for (int i=0;i<result_insert.length ;i++ ){
					if(result_insert[i]<0  && result_insert[i] != -2 ){
						insert_rec					=		false;
						break;
					}
					else{
						
						insert_rec					=		true;
					}
				}
			}

			
			
			if(delete_rec){
				pstmt_delete						=		connection.prepareStatement( SQL_SS_ALTERNATE_GROUP_DELETE ) ;
				// clear the batch
				pstmt_delete.clearBatch();
				for (int i=0;i<deleteData.size() ;i++ ){
					deleteRecords					=		new ArrayList();
					deleteRecords					=		(ArrayList)deleteData.get(i); 
					int fld							=		1;
						for (int j=0;j<deleteRecords.size() ;j++ ){
							pstmt_delete.setString(fld,(String)deleteRecords.get(j));
						fld++;
						}
						// add the statement to the batch
					pstmt_delete.addBatch();				
				}
				int[] result_delete					=		pstmt_delete.executeBatch();
					for (int i=0;i<result_delete.length ;i++ ){
						if(result_delete[i]<0  && result_delete[i] != -2 ){
							delete_rec				=		false;
							break;
						}
						else{
							delete_rec				=		true;
						}
				  }
			}

			if(insert_rec || delete_rec){
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append( "RECORD_INSERTED" ) ;
			}
			else{
				connection.rollback();
				map.put( "result", new Boolean( false ) ) ;
				//throw new EJBException("Insert/Update Failed");		
			}
		}
		catch( Exception e ) {
			try{
				connection.rollback();
				//throw new EJBException( e.getMessage() ) ;
			}
			catch ( Exception ee ) {
				messages.append( ee.getMessage() ) ;
				//throw new EJBException( e.getMessage() ) ; 
			}
			messages.append( e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			try {
				closeStatement( pstmt_insert ) ;
				closeStatement( pstmt_delete ) ;// Comented by Sakti closed preparedstatement against inc#48061
				//closeConnection( connection,(Properties)tabData.get( "properties" ) );//commented for 15756
				closeConnection( connection,properties); //added for 15756 
			} catch ( Exception fe ) {
				//System.err.println( fe.getMessage() ) ;
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
	public HashMap modify( HashMap tabData, HashMap sqlMap ) {
	HashMap map = new HashMap() ;
	map.put( "result", new Boolean( true ) ) ;
	map.put( "flag", "0" ) ;
	return map;
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap delete( HashMap tabData, HashMap sqlMap ) {
	HashMap map = new HashMap() ;
	map.put( "result", new Boolean( true ) ) ;
	map.put( "flag", "0" ) ;
	return map;
	}
}
