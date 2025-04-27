/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.ORSpecialityForOrderable;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import javax.ejb.* ;
import eOR.Common.* ;
/**
*
* @ejb.bean
*	name="ORSpecialityForOrderable"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORSpecialityForOrderable"
*	local-jndi-name="ORSpecialityForOrderable"
*	impl-class-name="eOR.ORSpecialityForOrderable.ORSpecialityForOrderableManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORSpecialityForOrderable.ORSpecialityForOrderableLocal"
*	remote-class="eOR.ORSpecialityForOrderable.ORSpecialityForOrderableRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORSpecialityForOrderable.ORSpecialityForOrderableLocalHome"
*	remote-class="eOR.ORSpecialityForOrderable.ORSpecialityForOrderableHome"
*	generate= "local,remote"
*
*
*/

public class ORSpecialityForOrderableManager extends OrEJBSessionAdapter {
	StringBuffer traceVal = new StringBuffer() ;
    Connection connection = null ;
	PreparedStatement pstmt = null ;
	PreparedStatement pstmt_del = null ;
	PreparedStatement pstmt_update = null ;
/**
* @ejb.interface-method		 
*	 view-type="both"
*/

    public HashMap insert( HashMap tabDataParam, HashMap sqlMap ){
		System.out.println("####tabDataParam="+tabDataParam);
		System.out.println("####sqlMap="+sqlMap);
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
        boolean insert_flag = false ;
		boolean delete_flag = false ;
		boolean update_flag = false ;
        String order_catalog_code	= "";
        String speciality_code	= "";
        String login_by_id			    = "";
		String login_at_ws_no			= "";
		String login_facility_id			= "";
		int [] insertCounts ;
		int [] deleteCounts ;
		//int [] updateCounts ; //Checkstyle
      //  String SQL_OR_SPLTY_FOR_ORDERABLE_SPLTY_DELETE = (String) sqlMap.get("SQL_OR_SPLTY_FOR_ORDERABLE_SPLTY_DELETE"); //Checkstyle
		String SQL_OR_SPLTY_FOR_ORDERABLE_CATALOG_DELETE = (String) sqlMap.get("SQL_OR_SPLTY_FOR_ORDERABLE_CATALOG_DELETE");
		String SQL_OR_SPLTY_FOR_ORDERABLE_INSERT= (String) sqlMap.get("SQL_OR_SPLTY_FOR_ORDERABLE_INSERT");
		ArrayList deleteArrList	= new ArrayList();
		ArrayList insertArrList = new ArrayList();
		ArrayList updateArrList = new ArrayList();
        Hashtable HashHdrData			= new Hashtable();
		insertArrList			= (ArrayList)tabDataParam.get("insertArrList");
		deleteArrList			= (ArrayList)tabDataParam.get("deleteArrList");
		updateArrList			= (ArrayList)tabDataParam.get("updateArrList");
		HashHdrData				= (Hashtable)tabDataParam.get("MultiHashData");
		order_catalog_code			= (String)HashHdrData.get("order_catalog_code");
		speciality_code			= (String)HashHdrData.get("speciality_code");
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
			if(updateArrList.size() >0)
				update_flag = false;
			else
				update_flag = true;
              if(insertArrList.size() >0){
				pstmt					= connection.prepareStatement(SQL_OR_SPLTY_FOR_ORDERABLE_INSERT);
				HashMap tabData  = new HashMap();

				    for(int k=0 ; k < insertArrList.size() ; k++){
					tabData  = (HashMap)insertArrList.get(k);
					pstmt.setString(1 ,order_catalog_code);
					pstmt.setString(2 ,(String)tabData.get("code"));
					pstmt.setString(3 ,(String)tabData.get("default_yn"));
					pstmt.setString(4,login_by_id);
					pstmt.setString(5 ,login_at_ws_no);
					pstmt.setString(6 ,login_facility_id);
					pstmt.setString(7 ,login_by_id);
					pstmt.setString(8 ,login_at_ws_no);
					pstmt.setString(9 ,login_facility_id);
                    pstmt.addBatch();
				}
                insertCounts = pstmt.executeBatch();
				for (int i=0;i<insertCounts.length ;i++ ){
					if(insertCounts[i]<0  && insertCounts[i] != -2 ){
						insert_flag=false;
						break;
					}
					else{
					insert_flag=true;
					}
				}
			}
			if(insert_flag && deleteArrList.size() >0 ){
				System.out.println("131 it enters");
                pstmt_del	= connection.prepareStatement(SQL_OR_SPLTY_FOR_ORDERABLE_CATALOG_DELETE);
                HashMap delMapData  = new HashMap();
                for(int k=0 ; k < deleteArrList.size() ; k++){
				delMapData  = (HashMap)deleteArrList.get(k);
                pstmt_del.setString(1 ,(String)delMapData.get("code"));
				pstmt_del.setString(2 ,order_catalog_code);
                pstmt_del.addBatch();
			}

			deleteCounts = pstmt_del.executeBatch();
            for (int i=0;i<deleteCounts.length ;i++ ){
				if(deleteCounts[i]<0  && deleteCounts[i] != -2 ){
                    delete_flag=false;
					break;
				}
				else{
					delete_flag=true;
				}
			}
		}
               /*if(updateArrList.size() >0 ){
                pstmt_update	= connection.prepareStatement(SQL_OR_SPECIMEN_FOR_ORDERABLE_UPDATE_DEFAULT_YN);
                HashMap updateMapData  = new HashMap();
                for(int k=0 ; k < updateArrList.size() ; k++){
				updateMapData  = (HashMap)updateArrList.get(k);
                pstmt_update.setString(1 ,(String)updateMapData.get("default_yn"));
				pstmt_update.setString(2 ,order_catalog_code);
				pstmt_update.setString(3 ,(String)updateMapData.get("code"));
                pstmt_update.addBatch();
			}
                updateCounts = pstmt_update.executeBatch();
			    for (int i=0;i<updateCounts.length ;i++ ){
				if(updateCounts[i]<0  && updateCounts[i] != -2 ){
					update_flag=false;
					break;
				}
				else{
					update_flag=true;
				}
			}
		}*/
    if(insert_flag && delete_flag && update_flag){
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
			closeStatement( pstmt_update ) ;
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
