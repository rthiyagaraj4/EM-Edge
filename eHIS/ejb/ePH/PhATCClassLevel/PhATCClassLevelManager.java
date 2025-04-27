/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//saved on 08/11/2005
/*
	Module		 : ePH
	Function	 : ATC Classification
	Class Name	 : PhATCClassLevelManager.java
	Created By	 : S.Arunagiri
	Created Date : 23-12-2002
	Modified By	 :
	Modified Date:
	Version		 :
	Description  : 				  
*/

package ePH.PhATCClassLevel;

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
*	name="PhATCClassLevel"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PhATCClassLevel"
*	local-jndi-name="PhATCClassLevel"
*	impl-class-name="ePH.PhATCClassLevel.PhATCClassLevelManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.PhATCClassLevel.PhATCClassLevelLocal"
*	remote-class="ePH.PhATCClassLevel.PhATCClassLevelRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.PhATCClassLevel.PhATCClassLevelLocalHome"
*	remote-class="ePH.PhATCClassLevel.PhATCClassLevelHome"
*	generate= "local,remote"
*
*
*/



public class PhATCClassLevelManager extends PhEJBSessionAdapter {

	Properties  prop							=	null;
	Connection connection						=	null ;
	PreparedStatement pstmt_update				=	null ;
	PreparedStatement pstmt_delete				=	null ;
 	String		SQL_PH_ATC_CLASS_LEVEL_DELETE	=	"";
	String		SQL_PH_ATC_CLASS_LEVEL_UPDATE	=	"";
 	String debug								=	"";

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/		
    public HashMap modify( HashMap tabData, HashMap sqlMap )  {
		//debug	+= "inside ejb";
		StringBuffer messages = new StringBuffer() ;
		

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
									prop= (Properties)tabData.get( "properties" );			         
		String  login_by_id			= (String)tabData.get("login_by_id");
		String	login_at_ws_no		= (String)tabData.get("login_at_ws_no");
		String	login_facility_id	= (String)tabData.get("login_facility_id");
		ArrayList whereData			= (ArrayList) tabData.get("whereData");
		ArrayList deleteData		= (ArrayList) tabData.get("deleteData");
		ArrayList updateData		= (ArrayList) tabData.get("updateData");
		ArrayList updateRecord		=	null;
		int levelNo					= Integer.parseInt((String)tabData.get("levelNo"));
	

		if(levelNo==1)	{
			SQL_PH_ATC_CLASS_LEVEL_DELETE	=	(String)sqlMap.get("SQL_PH_ATC_CLASS_LEVEL1_DELETE");
			SQL_PH_ATC_CLASS_LEVEL_UPDATE	=	(String)sqlMap.get("SQL_PH_ATC_CLASS_LEVEL1_UPDATE");
		} else if(levelNo==2)	{
			SQL_PH_ATC_CLASS_LEVEL_DELETE	=(String)	sqlMap.get("SQL_PH_ATC_CLASS_LEVEL2_DELETE");
			SQL_PH_ATC_CLASS_LEVEL_UPDATE	=(String)	sqlMap.get("SQL_PH_ATC_CLASS_LEVEL2_UPDATE");
		} else if(levelNo==3)	{
			SQL_PH_ATC_CLASS_LEVEL_DELETE	=(String)	sqlMap.get("SQL_PH_ATC_CLASS_LEVEL3_DELETE"); 
			SQL_PH_ATC_CLASS_LEVEL_UPDATE	=(String)	sqlMap.get("SQL_PH_ATC_CLASS_LEVEL3_UPDATE"); 
		
		} else if(levelNo==4)	{
			SQL_PH_ATC_CLASS_LEVEL_DELETE	=(String)	sqlMap.get("SQL_PH_ATC_CLASS_LEVEL4_DELETE"); 
			SQL_PH_ATC_CLASS_LEVEL_UPDATE	=(String)	sqlMap.get("SQL_PH_ATC_CLASS_LEVEL4_UPDATE"); 
		
		} else if(levelNo==5)	{
			SQL_PH_ATC_CLASS_LEVEL_DELETE	=(String)	sqlMap.get("SQL_PH_ATC_CLASS_LEVEL5_DELETE"); 
			SQL_PH_ATC_CLASS_LEVEL_UPDATE	=(String)	sqlMap.get("SQL_PH_ATC_CLASS_LEVEL5_UPDATE"); 
		}

	  try	{
		connection = getConnection( prop ) ;
		pstmt_delete = connection.prepareStatement( SQL_PH_ATC_CLASS_LEVEL_DELETE ) ;
		pstmt_update = connection.prepareStatement( SQL_PH_ATC_CLASS_LEVEL_UPDATE ) ;
	
//		debug	+= "level no"+levelNo+"deleteDatasize:"+deleteData.size();
		if(levelNo==1) {
			for(int i=0; i<deleteData.size(); i++)	{
		    pstmt_delete.setString(1, (String)deleteData.get(i));
			pstmt_delete.addBatch();
			}
			
			for(int i=0; i<updateData.size(); i++)	{
			updateRecord	=	new ArrayList();
			updateRecord	=(ArrayList)  updateData.get(i);
				if(updateRecord.size() > 0 )	{
				pstmt_update.setString(1, (String)updateRecord.get(1));
				pstmt_update.setString(2, (String)updateRecord.get(2));
				pstmt_update.setString(3, login_by_id);
				pstmt_update.setString(4, login_at_ws_no);
				pstmt_update.setString(5, login_facility_id);
				pstmt_update.setString(6, (String)updateRecord.get(0));
				}  
			pstmt_update.addBatch();
			}

		}
		else if(levelNo==2 ) {
			for(int i=0; i<deleteData.size(); i++)	{
			pstmt_delete.setString(1, (String)whereData.get(0));
		    pstmt_delete.setString(2, (String)deleteData.get(i));				
		    pstmt_delete.addBatch();
			}

			for(int i=0; i<updateData.size(); i++)	{
			updateRecord	=	new ArrayList();
			updateRecord	=(ArrayList)  updateData.get(i);
				if(updateRecord.size() > 0 )	{
				pstmt_update.setString(1, (String)updateRecord.get(1));
				pstmt_update.setString(2, (String)updateRecord.get(2));
				pstmt_update.setString(3, login_by_id);
				pstmt_update.setString(4, login_at_ws_no);
				pstmt_update.setString(5, login_facility_id);
				pstmt_update.setString(6, (String)whereData.get(0));
				pstmt_update.setString(7, (String)updateRecord.get(0));
			    }
			pstmt_update.addBatch();
			}

		}
		else if(levelNo==3 ) {
			for(int i=0; i<deleteData.size(); i++)	{
   		    pstmt_delete.setString(1, (String)whereData.get(0));
			pstmt_delete.setString(2, (String)whereData.get(1));
		    pstmt_delete.setString(3, (String)deleteData.get(i));				
			pstmt_delete.addBatch();
			}

			for(int i=0; i<updateData.size(); i++)	{
			updateRecord	=	new ArrayList();
			updateRecord	=(ArrayList)  updateData.get(i);
				if(updateRecord.size() > 0 )	{
				pstmt_update.setString(1, (String)updateRecord.get(1));
				pstmt_update.setString(2, (String)updateRecord.get(2));
				pstmt_update.setString(3, login_by_id);
				pstmt_update.setString(4, login_at_ws_no);
				pstmt_update.setString(5, login_facility_id);
				pstmt_update.setString(6, (String)whereData.get(0));
				pstmt_update.setString(7, (String)whereData.get(1));
				pstmt_update.setString(8, (String)updateRecord.get(0));
			    }
			pstmt_update.addBatch();
			}
		}
		else if(levelNo==4 ) {
			for(int i=0; i<deleteData.size(); i++)	{
		    pstmt_delete.setString(1, (String)whereData.get(0));
			pstmt_delete.setString(2, (String)whereData.get(1));
			pstmt_delete.setString(3, (String)whereData.get(2));
		    pstmt_delete.setString(4, (String)deleteData.get(i));				
			pstmt_delete.addBatch();
			}

			for(int i=0; i<updateData.size(); i++)	{
			updateRecord	=	new ArrayList();
			updateRecord	=(ArrayList)  updateData.get(i);
				if(updateRecord.size() > 0 )	{
				pstmt_update.setString(1, (String)updateRecord.get(1));
				pstmt_update.setString(2, (String)updateRecord.get(2));
				pstmt_update.setString(3, login_by_id);
				pstmt_update.setString(4, login_at_ws_no);
				pstmt_update.setString(5, login_facility_id);
				pstmt_update.setString(6, (String)whereData.get(0));
				pstmt_update.setString(7, (String)whereData.get(1));
				pstmt_update.setString(8, (String)whereData.get(2));
				pstmt_update.setString(9, (String)updateRecord.get(0));
			    }
			pstmt_update.addBatch();
			}

		}
		else if(levelNo==5) {
			for(int i=0; i<deleteData.size(); i++)	{
   		    pstmt_delete.setString(1, (String)whereData.get(0));
			pstmt_delete.setString(2, (String)whereData.get(1));
			pstmt_delete.setString(3, (String)whereData.get(2));
			pstmt_delete.setString(4, (String)whereData.get(3));
		    pstmt_delete.setString(5, (String)deleteData.get(i));				
			pstmt_delete.addBatch();
			}

			for(int i=0; i<updateData.size(); i++)	{
			updateRecord	=	new ArrayList();
			updateRecord	=(ArrayList)  updateData.get(i);
				if(updateRecord.size() > 0 )	{
				pstmt_update.setString(1, (String)updateRecord.get(1));
				pstmt_update.setString(2, (String)updateRecord.get(2));
				pstmt_update.setString(3, login_by_id);
				pstmt_update.setString(4, login_at_ws_no);
				pstmt_update.setString(5, login_facility_id);
				pstmt_update.setString(6, (String)whereData.get(0));
				pstmt_update.setString(7, (String)whereData.get(1));
				pstmt_update.setString(8, (String)whereData.get(2));
				pstmt_update.setString(9, (String)whereData.get(3));
				pstmt_update.setString(10, (String)updateRecord.get(0));
			    }
			pstmt_update.addBatch();
			}


		}

	int result[]	=	pstmt_delete.executeBatch();
	int result1[]	=	pstmt_update.executeBatch();
	
		for (int i=0;i<result.length ;i++ ){
			if(result[i]<0  && result[i] != -2 ){
				pstmt_delete.cancel();
				throw new EJBException("Deletion Failed");
				}			
	   	}
		for (int i=0;i<result1.length ;i++ ){
			if(result1[i]<0  && result1[i] != -2 ){
				pstmt_update.cancel();
				throw new EJBException("Updation Failed");
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
				closeStatement( pstmt_delete) ;
				closeStatement( pstmt_update) ;
				closeConnection( connection,prop );
			} catch ( Exception fe ) {
				
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

}
