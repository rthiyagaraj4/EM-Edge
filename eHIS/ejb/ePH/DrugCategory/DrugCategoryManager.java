/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
	Module		 : ePH
	Function	 : DrugCategory
	Class Name	 : DrugCategoryManager
	Created By	 : A.S.Raghunath
	Created Date : 05-12-2002
	Modified By	 :
	Modified Date:
	Version		 :
	Description  :
				  1.DrugCategoryManager is used to insert not more than 10 records  into PH_DRUG_CATG.
				  2.In this class addBatch is used ,so all statements will go to the
					db server at once.
				  3.This class is used to update the record.
*/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
04/13/2017      63877   		chithra      UnusedLocal variable
---------------------------------------------------------------------------------------------------------------
*/

package ePH.DrugCategory ;

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
*	name="DrugCategory"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="DrugCategory"
*	local-jndi-name="DrugCategory"
*	impl-class-name="ePH.DrugCategory.DrugCategoryManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.DrugCategory.DrugCategoryLocal"
*	remote-class="ePH.DrugCategory.DrugCategoryRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.DrugCategory.DrugCategoryLocalHome"
*	remote-class="ePH.DrugCategory.DrugCategoryHome"
*	generate= "local,remote"
*
*
*/
public class DrugCategoryManager extends PhEJBSessionAdapter {
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;

		final String SQL_PH_DRUG_CATG_INSERT = (String) sqlMap.get( "SQL_PH_DRUG_CATG_INSERT" );

		String  login_by_id			= (String)tabData.get("login_by_id");
		String	login_at_ws_no		= (String)tabData.get("login_at_ws_no");
		String	login_facility_id	= (String)tabData.get("login_facility_id");
		
		ArrayList arrList=(ArrayList)tabData.get("arrList");
		//String[] qryString=new String[10]; Unused local variable INC63877
	
		Connection connection = null ;
		PreparedStatement pstmt_insert = null ;
		try {
			connection = getConnection( (Properties)tabData.get( "properties" ) ) ;
			pstmt_insert = connection.prepareStatement( SQL_PH_DRUG_CATG_INSERT ) ;
			// clear the batch
			pstmt_insert.clearBatch();
			for (int i=0;i<arrList.size() ;i++ ){
				String[] record=(String[])arrList.get(i); 
				pstmt_insert.setString(1,record[0]);
				pstmt_insert.setString(2,record[1]);
				pstmt_insert.setString(3,record[2]);
				pstmt_insert.setString(4,record[3]);
				pstmt_insert.setString(5,login_by_id);
				pstmt_insert.setString(6,login_at_ws_no);
				pstmt_insert.setString(7,login_facility_id);
				pstmt_insert.setString(8,login_by_id);
				pstmt_insert.setString(9,login_at_ws_no);
				pstmt_insert.setString(10,login_facility_id);
				// add the statement to the batch
				pstmt_insert.addBatch();				
			}
			int[] result= pstmt_insert.executeBatch();
			for (int i=0;i<result.length ;i++ ){
				// A number greater than or equal to zero  indicates success
				// A number -2 indicates that command is successful but number of rows updated is unknow
				// If it won't satisfy any of the above cancel the statement and throw an exception

				if(result[i]<0  && result[i] != -2 ){
					pstmt_insert.cancel();
					throw new EJBException("Insert Failed");
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
		} finally {
			try {
				closeStatement( pstmt_insert ) ;
				closeConnection( connection,(Properties)tabData.get( "properties" ) );
			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		map.put( "msgid", messages.toString() ) ;
		return map ;
	}
/*****************************************   modify()  *********************************/
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify( HashMap tabData, HashMap sqlMap )  {

		StringBuffer debug =new StringBuffer();
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		StringBuffer messages = new StringBuffer() ;
		Connection connection = null ;
		PreparedStatement pstmt_update = null ;
	
		try {
			connection = getConnection( (Properties)tabData.get( "properties" ) ) ;

			debug.append("After Getting the connection (EJB)"+ (Properties)tabData.get( "properties" ));

			pstmt_update = connection.prepareStatement( (String) sqlMap.get( "SQL_PH_DRUG_CATG_UPDATE" ) ) ;

			pstmt_update.setString(1, (String)tabData.get( "long_desc" ));
			pstmt_update.setString(2, (String)tabData.get( "short_desc" ));
			pstmt_update.setString(3, (String)tabData.get( "eff_status" ));
			pstmt_update.setString(4, (String)tabData.get( "login_by_id" ));
			pstmt_update.setString(5, (String)tabData.get( "login_at_ws_no" ));
			pstmt_update.setString(6, (String)tabData.get( "login_facility_id" ));
			pstmt_update.setString(7, (String)tabData.get( "drug_catg_code" ));

			debug.append("Before Execute (EJB)"+(String)tabData.get( "long_desc" ));
			debug.append(tabData.get( "short_desc" ));
			debug.append(tabData.get( "eff_status" ));

			int result = pstmt_update.executeUpdate() ;
			
			debug.append("After Execute(EJB)"+result);

			if ( result < 1 ) {
					connection.rollback();
					map.put( "flag", debug.toString() ) ;
					throw new EJBException("Update Failed");
			}
			else {
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append( "RECORD_MODIFIED" ) ;
				map.put( "flag", debug.toString() ) ;

			}
		}
		catch( Exception e ) {
			try {
				connection.rollback();
				throw new EJBException( this + " : " + e.getMessage() ) ;
			}
			catch ( Exception ee ) {
				map.put( "msgid", ee.getMessage() ) ;
			}
			map.put( "msgid", e.getMessage() ) ;
			System.err.println(debug );
			e.printStackTrace() ;
		}
		finally {
			try {
				closeStatement( pstmt_update ) ;
				closeConnection( connection, (Properties)tabData.get( "properties" ) );
			}
			catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		map.put( "msgid", messages.toString() ) ;
		return map ;
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap delete( HashMap tabData, HashMap sqlMap ) {

		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", messages.toString() ) ;
		return map ;
	}
}
