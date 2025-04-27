/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH.WsTokenSeries ;

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
*	name="WsTokenSeries"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="WsTokenSeries"
*	local-jndi-name="WsTokenSeries"
*	impl-class-name="ePH.WsTokenSeries.WsTokenSeriesManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.WsTokenSeries.WsTokenSeriesLocal"
*	remote-class="ePH.WsTokenSeries.WsTokenSeriesRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.WsTokenSeries.WsTokenSeriesLocalHome"
*	remote-class="ePH.WsTokenSeries.WsTokenSeriesHome"
*	generate= "local,remote"
*
*
*/
public class WsTokenSeriesManager extends PhEJBSessionAdapter {
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
	public HashMap modify( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		return map;
	}

	private HashMap updateTable( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;

		Connection connection = null ;
		PreparedStatement pstmt_insert = null ;

		PreparedStatement pstmt_delete = null ;

		try {
			HashMap commonData		= (HashMap)tabData.get( "COMMONDATA" );
			ArrayList insertData	= (ArrayList)tabData.get( "INSERTDATA" ) ;			
			//ArrayList deleteData	= (ArrayList)tabData.get( "DELETEDATA" ) ;
			boolean continueFlag	= false;
			String defTokenSeriesCode=(String)tabData.get( "DEF_TOKENSERIESCODE" ); //added for [IN:037465]
			connection = getConnection( (Properties)tabData.get( "PROPERTIES" ) ) ;
			pstmt_insert = connection.prepareStatement( (String) sqlMap.get( "INSERTSQL" ) ) ;			
			pstmt_delete = connection.prepareStatement( (String) sqlMap.get( "DELETESQL" ) ) ;
			pstmt_insert.clearBatch();			
			pstmt_delete.clearBatch();

			if (insertData.size() > 0 ) {
			/*	for (int i=0; i<deleteData.size(); i+=2 ) {*/
					pstmt_delete.setString(1, (String)commonData.get( "ws_no" ));
					pstmt_delete.setString(2, (String)commonData.get( "locn_code" ));					
					pstmt_delete.setString(3, (String)commonData.get("login_facility_id"));
					pstmt_delete.addBatch();
			//	}

				int[] qryresult = pstmt_delete.executeBatch();
				for (int j=0;j<qryresult.length;j++ ) {
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
					}
				}
			}

			if (insertData.size() > 0 ) {
				for (int i=0; i<insertData.size(); i++) {

					pstmt_insert.setString(1, (String)commonData.get("login_facility_id"));					
					pstmt_insert.setString(2, (String)commonData.get( "locn_code" ));
					pstmt_insert.setString(3, (String)insertData.get(i));
					pstmt_insert.setString(4, (String)commonData.get( "ws_no" ));					
					if( defTokenSeriesCode.equals((String)insertData.get(i))) //if and else block added for [IN:037465]
						pstmt_insert.setString(5, "Y");
					else
						pstmt_insert.setString(5, "N");
					pstmt_insert.setString(6, (String)commonData.get( "login_by_id" ));
					pstmt_insert.setString(7, (String)commonData.get( "login_at_ws_no" ));
					pstmt_insert.setString(8, (String)commonData.get( "login_facility_id" ));
					pstmt_insert.setString(9, (String)commonData.get( "login_by_id" ));
					pstmt_insert.setString(10, (String)commonData.get( "login_at_ws_no" ));
					pstmt_insert.setString(11, (String)commonData.get( "login_facility_id" ));
					pstmt_insert.addBatch();
				}

				int[] qryresult1 = pstmt_insert.executeBatch();
				for (int j=0;j<qryresult1.length;j++ ) {
					if(qryresult1[j] < 0 && qryresult1[j] != -2 ) {
						continueFlag = false;
						pstmt_insert.cancel();
						connection.rollback();
						throw new EJBException("Insert Failed at batch call");
					}
					else {
						continueFlag = true;
						map.put( "result", new Boolean( true ) ) ;
						map.put( "msgid", "RECORD_INSERTED" ) ;
					}
				}
			}
			else{
				continueFlag = false;
				map.put( "result", new Boolean( false ) ) ;
				map.put( "msgid", "PH_ATLEAST_ONE_SELECTED" ) ;
			}			

			if (continueFlag) {
				connection.commit();
			}
			else {
				connection.rollback();
				//throw new EJBException("Insert Failed");
			}
		}
		catch( Exception e ) {
			map.put( "msgid", " Exception in EJB : " + e.getMessage() ) ;
		
			e.printStackTrace() ;
		}
		finally {
			try {
				closeStatement( pstmt_insert ) ;				
				closeStatement( pstmt_delete ) ;
				closeConnection( connection, (Properties)tabData.get( "PROPERTIES" ) );
			}
			catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}

		return map ;
	}


    public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "msgid", "Success" ) ;
		map.put( "flag", "0" ) ;
		return map ;
	}
}
