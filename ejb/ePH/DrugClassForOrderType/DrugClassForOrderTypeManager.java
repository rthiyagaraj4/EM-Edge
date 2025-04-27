/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH.DrugClassForOrderType ;

import java.rmi.* ;
import java.util.HashMap ;
import java.util.ArrayList ;
import java.util.Properties ;
import java.sql.* ;

import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;
/**
*
* @ejb.bean
*	name="DrugClassForOrderType"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="DrugClassForOrderType"
*	local-jndi-name="DrugClassForOrderType"
*	impl-class-name="ePH.DrugClassForOrderType.DrugClassForOrderTypeManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.DrugClassForOrderType.DrugClassForOrderTypeLocal"
*	remote-class="ePH.DrugClassForOrderType.DrugClassForOrderTypeRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.DrugClassForOrderType.DrugClassForOrderTypeLocalHome"
*	remote-class="ePH.DrugClassForOrderType.DrugClassForOrderTypeHome"
*	generate= "local,remote"
*
*
*/

public class DrugClassForOrderTypeManager extends PhEJBSessionAdapter {
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		return updateTable( tabData, sqlMap ) ;
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	private HashMap updateTable( HashMap tabData, HashMap sqlMap )  {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;

		Connection connection = null ;
		PreparedStatement pstmt_insert = null ;
		PreparedStatement pstmt_modify = null ;
		PreparedStatement pstmt_delete = null ;

		try {
			HashMap commonData		= (HashMap)tabData.get( "COMMONDATA" );
			ArrayList insertData	= (ArrayList)tabData.get( "INSERTDATA" ) ;
			ArrayList modifyData	= (ArrayList)tabData.get( "MODIFYDATA" ) ;
			ArrayList deleteData	= (ArrayList)tabData.get( "DELETEDATA" ) ;
			boolean continueFlag	= false;

			connection = getConnection( (Properties)tabData.get( "PROPERTIES" ) ) ;
			pstmt_insert = connection.prepareStatement( (String) sqlMap.get( "INSERTSQL" ) ) ;
			pstmt_modify = connection.prepareStatement( (String) sqlMap.get( "MODIFYSQL" ) ) ;
			pstmt_delete = connection.prepareStatement( (String) sqlMap.get( "DELETESQL" ) ) ;

			pstmt_insert.clearBatch();
			pstmt_modify.clearBatch();
			pstmt_delete.clearBatch();

			if (deleteData.size() > 0 ) {
				for (int i=0; i<deleteData.size(); i++ ) {
					pstmt_delete.setString(1, (String)deleteData.get(i));
					pstmt_delete.addBatch();
				}

				int[] qryresult = pstmt_delete.executeBatch();
				for (int j=0;j<qryresult.length ;j++ ) {
					if(qryresult[j] < 0 && qryresult[j] != -2 ) {
						continueFlag = false;
						pstmt_delete.cancel();
						connection.rollback();
						throw new EJBException("Delete Failed");
					}
					else {
						continueFlag = true;
						map.put( "result", new Boolean( true ) ) ;
						map.put( "msgid", "RECORD_DELETED" ) ;
						//connection.commit();
					}
				}
			}

			if (modifyData.size() > 0 ) {
				for (int i=0; i<modifyData.size(); i++ ) {
					pstmt_modify.setString(1, (String)modifyData.get(i++));
					pstmt_modify.setString(2, (String)commonData.get( "login_by_id" ));
					pstmt_modify.setString(3, (String)commonData.get( "login_at_ws_no" ));
					pstmt_modify.setString(4, (String)commonData.get( "login_facility_id" ));
					pstmt_modify.setString(5, (String)modifyData.get(i));
					pstmt_modify.addBatch();
				}

				int[] qryresult = pstmt_modify.executeBatch();
				for (int j=0;j<qryresult.length ;j++ ) {
					if(qryresult[j] < 0 && qryresult[j] != -2 ) {
						continueFlag = false;
						pstmt_modify.cancel();
						connection.rollback();
						throw new EJBException("Modify Failed");
					}
					else {
						continueFlag = true;
						map.put( "result", new Boolean( true ) ) ;
						map.put( "msgid", "RECORD_MODIFIED" ) ;
						//connection.commit();
					}
				}
			}

			if (insertData.size() > 0 ) {
				for (int i=0; i<insertData.size(); i++ ) {
					pstmt_insert.setString(1, (String)insertData.get(i++));
					pstmt_insert.setString(2, (String)insertData.get(i));
					pstmt_insert.setString(3, (String)commonData.get( "login_by_id" ));
					pstmt_insert.setString(4, (String)commonData.get( "login_at_ws_no" ));
					pstmt_insert.setString(5, (String)commonData.get( "login_facility_id" ));
					pstmt_insert.setString(6, (String)commonData.get( "login_by_id" ));
					pstmt_insert.setString(7, (String)commonData.get( "login_at_ws_no" ));
					pstmt_insert.setString(8, (String)commonData.get( "login_facility_id" ));
					pstmt_insert.addBatch();
				}

				int[] qryresult = pstmt_insert.executeBatch();
				for (int j=0;j<qryresult.length ;j++ ) {
					if(qryresult[j] < 0 && qryresult[j] != -2 ) {
						continueFlag = false;
						pstmt_insert.cancel();
						connection.rollback();
						throw new EJBException("Insert Failed");
					}
					else {
						continueFlag = true;
						map.put( "result", new Boolean( true ) ) ;
						map.put( "msgid", "RECORD_INSERTED" ) ;
						//connection.commit();
					}
				}
			}

			if (continueFlag) {
				connection.commit();
			}
			else {
				connection.rollback();
			}
		}
		catch( Exception e ) {
			map.put( "msgid", "Exception in EJB : " + e.getMessage() ) ;
			e.printStackTrace() ;
		}
		finally {
			try {
				closeStatement( pstmt_insert ) ;
				closeStatement( pstmt_modify ) ;
				closeStatement( pstmt_delete ) ;
				closeConnection( connection, (Properties)tabData.get( "PROPERTIES" ) );
			}
			catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		return map ;
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap modify( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "msgid", "Success" ) ;
		map.put( "flag", "0" ) ;
		return map ;
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "msgid", "Success" ) ;
		map.put( "flag", "0" ) ;
		return map ;
	}
}
