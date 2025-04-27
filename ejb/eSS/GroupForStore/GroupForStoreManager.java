/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eSS.GroupForStore ;

import java.rmi.* ;
import java.util.HashMap ;
import java.util.ArrayList;
import java.util.Properties;

import java.sql.* ;

import javax.ejb.* ;
import eSS.Common.SsEJBSessionAdapter ;

/**
*
* @ejb.bean
*	name="GroupForStore"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="GroupForStore"
*	local-jndi-name="GroupForStore"
*	impl-class-name="eSS.GroupForStore.GroupForStoreManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.GroupForStore.GroupForStoreLocal"
*	remote-class="eSS.GroupForStore.GroupForStoreRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.GroupForStore.GroupForStoreLocalHome"
*	remote-class="eSS.GroupForStore.GroupForStoreHome"
*	generate= "local,remote"
*
*
*/

public class GroupForStoreManager extends SsEJBSessionAdapter {

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap insert( HashMap tabData, HashMap sqlMap )  {

		StringBuffer messages = new StringBuffer() ;
		//StringBuffer sb=new StringBuffer();
		String debug = "From EJB : ";
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		//map.put( "flag", "0" ) ;

		final String SQL_SS_GROUP_FOR_STORE_INSERT = (String) sqlMap.get( "SQL_SS_GROUP_FOR_STORE_INSERT" );
		final String SQL_SS_GROUP_FOR_STORE_UPDATE = (String) sqlMap.get( "SQL_SS_GROUP_FOR_STORE_UPDATE" );

		ArrayList insertData=(ArrayList)tabData.get("InsertData");
		ArrayList insertRecords=null;
		ArrayList modifyData=(ArrayList)tabData.get("ModifyData");
		ArrayList modifyRecords=null;

		Connection connection = null ;
		PreparedStatement pstmt_insert = null ;
		PreparedStatement pstmt_modify = null ;
		boolean insert_rec=false;
		boolean modify_rec=false;

		try {
			connection = getConnection( (Properties)tabData.get( "properties" ) ) ;
			pstmt_insert = connection.prepareStatement( SQL_SS_GROUP_FOR_STORE_INSERT ) ;
			// clear the batch
			pstmt_insert.clearBatch();
			//System.out.println("A");

			//System.out.println("insertData"+insertData.size());
			//System.out.println("modifyData"+modifyData.size());

			if(insertData.size()>0){
				insert_rec=false;
			}
			else{
				insert_rec=true;
			}

			//System.out.println("1"+insert_rec+"/"+modify_rec);

			if(modifyData.size()>0){
				modify_rec=false;
			}
			else{
				modify_rec=true;
			}

			//System.out.println("2"+insert_rec+"/"+modify_rec);


			if(insertData.size()>0)
			{
			for (int i=0;i<insertData.size() ;i++ ){
				//System.out.println("inside");
				insertRecords=new ArrayList();
				insertRecords=(ArrayList)insertData.get(i);
					int fld=1;
						for (int j=0;j<insertRecords.size() ;j++ ){
							pstmt_insert.setString(fld,(String)insertRecords.get(j));
						fld++;
						}
				// add the statement to the batch
				pstmt_insert.addBatch();
			}


			int[] result_insert= pstmt_insert.executeBatch();
			for (int i=0;i<result_insert.length ;i++ ){//System.out.println("inside 2");
				if(result_insert[i]<0  && result_insert[i] != -2 ){
					insert_rec=false;
					break;
				}
				else{
				insert_rec=true;
				}
			}
			}
			else
			insert_rec=true;

			//System.out.println("3"+insert_rec+"/"+modify_rec);

			if(insert_rec&&modifyData.size()>0){
//System.out.println("4");
				pstmt_modify = connection.prepareStatement( SQL_SS_GROUP_FOR_STORE_UPDATE ) ;
				// clear the batch
				pstmt_modify.clearBatch();
				for (int i=0;i<modifyData.size() ;i++ ){
					modifyRecords=new ArrayList();
					modifyRecords=(ArrayList)modifyData.get(i);
					int fld=1;
						for (int j=0;j<modifyRecords.size() ;j++ ){
							pstmt_modify.setString(fld,(String)modifyRecords.get(j));
						fld++;
						}
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
			}

//System.out.println("5"+insert_rec+"/"+modify_rec);
			//if(insert_rec && modify_rec){

				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append( "RECORD_INSERTED" ) ;
		/*	}
			else{
				connection.rollback();
				map.put( "result", new Boolean( false ) ) ;
				throw new EJBException("Insert/Update Failed");
			}
			*/
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
				closeStatement( pstmt_insert ) ;
				closeStatement( pstmt_modify ) ;
				closeConnection( connection,(Properties)tabData.get( "properties" ) );
			} catch ( Exception fe ) {
				//System.out.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		map.put( "msgid", messages.toString() ) ;
	//	map.put( "sb", sb.toString() ) ;
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
public HashMap delete( HashMap tabData, HashMap sqlMap )  {
HashMap map = new HashMap() ;
map.put( "result", new Boolean( true ) ) ;
map.put( "flag", "0" ) ;
return map;

}



 }//class
