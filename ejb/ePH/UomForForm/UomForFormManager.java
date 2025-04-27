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
	Function	 : Units for Form of Drug
	Class Name	 : UomForFormManager.java
	Created By	 : S.Arunagiri
	Created Date : 23-12-2002
	Modified By	 :
	Modified Date:
	Version		 :
	Description  : 				  
*/
//saved on 27/10/2005
package ePH.UomForForm;

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
*	name="UomForForm"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="UomForForm"
*	local-jndi-name="UomForForm"
*	impl-class-name="ePH.UomForForm.UomForFormManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.UomForForm.UomForFormLocal"
*	remote-class="ePH.UomForForm.UomForFormRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.UomForForm.UomForFormLocalHome"
*	remote-class="ePH.UomForForm.UomForFormHome"
*	generate= "local,remote"
*
*
*/

public class UomForFormManager extends PhEJBSessionAdapter {

	Properties  prop							=	null;
	Connection connection						=	null ;
	PreparedStatement pstmt_insert				=	null ;
	PreparedStatement pstmt_delete				=	null ;
//	PreparedStatement pstmt_update				=	null ;
	String		SQL_PH_UOM_FOR_FORM_INSERT		=	"";
	String		SQL_PH_UOM_FOR_FORM_DELETE		=	"";
//	String		SQL_PH_UOM_FOR_FORM_UPDATE		=	"";

	String debug								=	"";

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		//debug	+= "inside ejb";
		StringBuffer messages = new StringBuffer() ;
		

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
				prop				= (Properties)tabData.get( "properties" );			         
		String  login_by_id			= (String)tabData.get("login_by_id");
		String	login_at_ws_no		= (String)tabData.get("login_at_ws_no");
		String	login_facility_id	= (String)tabData.get("login_facility_id");
		String	form_code			= (String)tabData.get("form_code");
		ArrayList insertData		= (ArrayList) tabData.get("insertData");
		//ArrayList deleteData		= (ArrayList) tabData.get("deleteData");
		//ArrayList updateData		= (ArrayList) tabData.get("updateData");

		ArrayList insertRecord		=	null;	

		//ArrayList updateRecord		=	null;

		SQL_PH_UOM_FOR_FORM_INSERT	=(String)	sqlMap.get("SQL_PH_UOM_FOR_FORM_INSERT"); 
		SQL_PH_UOM_FOR_FORM_DELETE	=(String)	sqlMap.get("SQL_PH_UOM_FOR_FORM_DELETE"); 
		//SQL_PH_UOM_FOR_FORM_UPDATE	=(String)	sqlMap.get("SQL_PH_UOM_FOR_FORM_UPDATE"); 
	

	  try	{
		connection = getConnection( prop ) ;

	/******************Deletion Starts***********************/
		pstmt_delete = connection.prepareStatement( SQL_PH_UOM_FOR_FORM_DELETE ) ;
		pstmt_delete.setString(1, form_code);
		pstmt_delete.executeUpdate();
/*
		for(int i=0; i<deleteData.size(); i++)	{
		    pstmt_delete.setString(1, (String)deleteData.get(i));
			pstmt_delete.setString(2, form_code);
			pstmt_delete.addBatch();
			}
	
		int result[]	=	pstmt_delete.executeBatch();

		
		for (int i=0;i<result.length ;i++ ){
			if(result[i]<0  && result[i] != -2 ){
				pstmt_delete.cancel();
				throw new EJBException("Deletion Failed");
				}
				
	   	}
/******************Deletion Ends***************************/

/******************UPdation Starts*************************/
/*
		pstmt_update = connection.prepareStatement( SQL_PH_UOM_FOR_FORM_UPDATE ) ;

		for(int i=0; i<updateData.size(); i++)	{
				updateRecord	=	new ArrayList();
				updateRecord	=	(ArrayList)  updateData.get(i);
		    pstmt_update.setString(1, (String)updateRecord.get(0));
			pstmt_update.setString(2, (String)updateRecord.get(1));
			pstmt_update.setString(3, form_code);
			pstmt_update.addBatch();
			}
		int result2[]	=	pstmt_update.executeBatch();

		
		for (int i=0;i<result2.length ;i++ ){
			if(result2[i]<0  && result2[i] != -2 ){
				pstmt_update.cancel();
				throw new EJBException("Updation Failed");
				}
				
	   	}

*/
/******************UPdation Ends*************************/
/******************Insertion Starts*************************/

		pstmt_insert = connection.prepareStatement( SQL_PH_UOM_FOR_FORM_INSERT ) ;
	

	
			for(int i=0; i<insertData.size(); i++)	{
				insertRecord	=	new ArrayList();
				insertRecord	=	(ArrayList)  insertData.get(i);
		    pstmt_insert.setString(1, form_code);
			pstmt_insert.setString(2, (String)insertRecord.get(0));
			pstmt_insert.setString(3, (String)insertRecord.get(1));
			pstmt_insert.setString(4, login_by_id);
			pstmt_insert.setString(5, login_at_ws_no);
			pstmt_insert.setString(6, login_facility_id);
			pstmt_insert.setString(7, login_by_id);
			pstmt_insert.setString(8, login_at_ws_no);
			pstmt_insert.setString(9, login_facility_id);
			pstmt_insert.addBatch();
			}


		
		int result3[]	=	pstmt_insert.executeBatch();

		
		for (int i=0;i<result3.length ;i++ ){
			if(result3[i]<0  && result3[i] != -2 ){
				pstmt_insert.cancel();
				throw new EJBException("Insertion Failed");
				}
				
	   	}
		
/******************Insertion Ends*************************/
	map.put( "result", new Boolean( true ) ) ;
	messages.append( "RECORD_INSERTED" ) ;
	connection.commit();
	}
		catch( Exception e ) {
			try{
				connection.rollback();
				System.err.println(e.toString());
				throw new EJBException( e.getMessage() ) ;
			}
			catch ( Exception ee ) {
				System.err.println(ee.toString());
				messages.append( ee.getMessage() ) ;
			}
			//messages.append( e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			try {
				closeStatement( pstmt_insert) ;
//				closeStatement( pstmt_update) ;
				closeStatement( pstmt_delete) ;
				closeConnection( connection,prop );
			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
	map.put( "msgid", messages.toString() ) ;
	map.put( "flag",debug.toString());
	return map;
	}	
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap modify( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "flag", "0" ) ;
		return map;
	}

	public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "flag", "0" ) ;
		return map;
	}

}
