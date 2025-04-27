/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.ORIndexOrderCatalog;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import javax.ejb.* ;
import eOR.Common.* ;

/**
*
* @ejb.bean
*	name="ORIndexOrderCatalog"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORIndexOrderCatalog"
*	local-jndi-name="ORIndexOrderCatalog"
*	impl-class-name="eOR.ORIndexOrderCatalog.ORIndexOrderCatalogManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORIndexOrderCatalog.ORIndexOrderCatalogLocal"
*	remote-class="eOR.ORIndexOrderCatalog.ORIndexOrderCatalogRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORIndexOrderCatalog.ORIndexOrderCatalogLocalHome"
*	remote-class="eOR.ORIndexOrderCatalog.ORIndexOrderCatalogHome"
*	generate= "local,remote"
*
*
*/

public class ORIndexOrderCatalogManager extends OrEJBSessionAdapter {
	//SessionContext context ;
	//StringBuffer messages = new StringBuffer() ;
	StringBuffer traceVal = new StringBuffer() ;

	Connection connection = null ;
	PreparedStatement pstmt = null ;
	PreparedStatement pstmt_del = null ;
/**
* @ejb.interface-method
*	 view-type="both"
*/

    public HashMap insert( HashMap tabDataParam, HashMap sqlMap ){
		//System.out.println("####sqlMap="+sqlMap);
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		boolean insert_flag = false ;
		boolean delete_flag = false ;

		String service_code				= "";

		String login_by_id				= "";
		String login_at_ws_no			= "";
		String login_facility_id		= "";

		int [] insertCounts ;
		int [] deleteCounts ;
		//int insSourceCount = 0;

		String SQL_OR_INDEX_ORDER_CATALOG_INSERT = (String) sqlMap.get("SQL_OR_INDEX_ORDER_CATALOG_INSERT");
		//System.out.println("######error here######");
		String SQL_OR_INDEX_ORDER_CATALOG_DELETE = (String) sqlMap.get("SQL_OR_INDEX_ORDER_CATALOG_DELETE");
//System.out.println("######error here33333333333######");
		ArrayList deleteArrList	= new ArrayList();
		ArrayList insertArrList = new ArrayList();

		Hashtable HashHdrData			= new Hashtable();

		insertArrList			= (ArrayList)tabDataParam.get("insertArrList");
		deleteArrList			= (ArrayList)tabDataParam.get("deleteArrList");
		//System.out.println("######deleteArrList="+deleteArrList);
		//System.out.println("######insertArrList="+insertArrList);
		//System.out.println("######insert_flag="+insert_flag);
		//System.out.println("######delete_flag="+delete_flag);
		//System.out.println("######deleteArrList.size()="+deleteArrList.size());

		HashHdrData				= (Hashtable)tabDataParam.get("MultiHashData");

		service_code			= (String)HashHdrData.get("service_code");
//System.out.println("######service_code="+service_code);
		login_by_id				= (String)HashHdrData.get("login_by_id");
		login_at_ws_no			= (String)HashHdrData.get("login_at_ws_no");
		login_facility_id		= (String)HashHdrData.get("login_facility_id");

		try {
			connection				= getConnection((Properties)tabDataParam.get("properties")) ;
		}catch(Exception Exp){
			throw new EJBException( Exp.getMessage() ) ;
		}

		try{
			 if(insertArrList.size() >0)
				insert_flag = false;
			else
				insert_flag = true;

			if(deleteArrList.size() >0)
				delete_flag = false;
			else
				delete_flag = true;
//System.out.println("######1111insert_flag="+insert_flag);
//System.out.println("######11111delete_flag="+delete_flag);
			if(insertArrList.size() >0){
				pstmt					= connection.prepareStatement(SQL_OR_INDEX_ORDER_CATALOG_INSERT);
				HashMap tabData  = new HashMap();

				for(int k=0 ; k < insertArrList.size() ; k++){
					tabData  = (HashMap)insertArrList.get(k);
					pstmt.setString(1 ,(String)tabData.get("code"));
					pstmt.setString(2 ,"S");
					pstmt.setString(3 ,service_code);
					pstmt.setString(4 ,login_by_id);
					pstmt.setString(5 ,login_at_ws_no);
					pstmt.setString(6 ,login_facility_id);
					pstmt.setString(7 ,login_by_id);
					pstmt.setString(8 ,login_at_ws_no);
					pstmt.setString(9 ,login_facility_id);

					pstmt.addBatch();
				}

				insertCounts = pstmt.executeBatch();
//System.out.println("#####insertCounts="+insertCounts);
				for (int i=0;i<insertCounts.length ;i++ ){
					if(insertCounts[i]<0  && insertCounts[i] != -2 ){
						//System.out.println("1111111111");
						insert_flag=false;
						break;
					}
					else{
						//System.out.println("2222222222");
					insert_flag=true;
					}
				}
			}
//System.out.println("#####2222insert_flag="+insert_flag);
//System.out.println("#####2222deleteArrList.size()="+deleteArrList.size());

			if(insert_flag && deleteArrList.size() >0 ){

				pstmt_del	= connection.prepareStatement(SQL_OR_INDEX_ORDER_CATALOG_DELETE);

				HashMap delMapData  = new HashMap();

				for(int k=0 ; k < deleteArrList.size() ; k++){
				delMapData  = (HashMap)deleteArrList.get(k);

				pstmt_del.setString(1 ,service_code);
				pstmt_del.setString(2 ,(String)delMapData.get("code"));

				pstmt_del.addBatch();
			}

			deleteCounts = pstmt_del.executeBatch();
			//System.out.println("#####deleteCounts="+deleteCounts);


			for (int i=0;i<deleteCounts.length ;i++ ){
				if(deleteCounts[i]<0  && deleteCounts[i] != -2 ){
					//System.out.println("3333333333333333");

					delete_flag=false;
					break;
				}
				else{
					//System.out.println("44444444444");
					delete_flag=true;
				}
			}
		}
	//System.out.println("#####3333insert_flag="+insert_flag);
	//System.out.println("#####3333delete_flag="+delete_flag);

		if(insert_flag && delete_flag){
			connection.commit();
			map.put( "result", new Boolean( true ) ) ;
			messages.append( "RECORD_INSERTED" ) ;
		}
		else{
			connection.rollback();
			map.put( "result", new Boolean( false ) ) ;
			throw new EJBException("Insert/Update Failed");
		}

	}
	catch(Exception e){
	traceVal.append(e.getMessage());
	map.put( "traceVal", traceVal.toString() ) ;
	}
	finally{
	   try {
		    closeStatement( pstmt ) ;
			closeStatement( pstmt_del ) ;
			closeConnection( connection, (Properties)tabDataParam.get( "properties" ) );
		}catch ( Exception fe ) {
			System.err.println( fe.getMessage() ) ;
			fe.printStackTrace() ;
			traceVal.append(fe.getMessage());
			map.put( "traceVal", traceVal.toString() ) ;
		}
	}
	map.put( "message", messages.toString() ) ;
	map.put( "traceVal", traceVal.toString() ) ;
	return map ;
	}

/**
* @ejb.interface-method
*	 view-type="both"
*/

	 public HashMap modify( HashMap tabDataParam, HashMap sqlMap ) {

		//StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		return map ;
	}

/**
* @ejb.interface-method
*	 view-type="both"
*/

	 public HashMap delete( HashMap tabDataParam, HashMap sqlMap ) {
		//StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		return map ;
	}


}///End of Class
