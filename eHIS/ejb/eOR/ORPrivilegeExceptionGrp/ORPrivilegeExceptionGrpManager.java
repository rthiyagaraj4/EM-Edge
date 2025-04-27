/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.ORPrivilegeExceptionGrp;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import javax.ejb.* ;
import eOR.Common.* ;

/**
*
* @ejb.bean
*	name="ORPrivilegeExceptionGrp"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORPrivilegeExceptionGrp"
*	local-jndi-name="ORPrivilegeExceptionGrp"
*	impl-class-name="eOR.ORPrivilegeExceptionGrp.ORPrivilegeExceptionGrpManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORPrivilegeExceptionGrp.ORPrivilegeExceptionGrpLocal"
*	remote-class="eOR.ORPrivilegeExceptionGrp.ORPrivilegeExceptionGrpRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORPrivilegeExceptionGrp.ORPrivilegeExceptionGrpLocalHome"
*	remote-class="eOR.ORPrivilegeExceptionGrp.ORPrivilegeExceptionGrpHome"
*	generate= "local,remote"
*
*
*/

public class ORPrivilegeExceptionGrpManager extends OrEJBSessionAdapter {
	//SessionContext context ;
	StringBuffer messages = new StringBuffer() ;
	StringBuffer traceVal = new StringBuffer() ;

	Connection connection = null ;
	PreparedStatement pstmt_ins_hdr = null ;
	PreparedStatement pstmt_ins_dtl = null ;
	PreparedStatement pstmt_del = null ;

	/**
* @ejb.interface-method
*	 view-type="both"
*/
    public HashMap insert( HashMap tabDataParam, HashMap sqlMap ) {

		//traceVal.append("Inside*******");
		
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		boolean insert_flag = false ;
		boolean delete_flag = false ;

		String exception_type			= "";
		String grp_exception_id			= "";
		String grp_exception_name		= "";
		//String order_category			= "";
		//String order_type_code			= "";
		String bean_mode				= "";


		String login_by_id				= "";
		String login_at_ws_no			= "";
		String login_facility_id		= "";

		int [] insertHdrCounts ;
		int [] insertDtlCounts ;
		int [] deleteCounts ;
		//int insSourceCount = 0;
		
		String SQL_OR_PRIV_GRP_EXCEPTION_INSERT = (String) sqlMap.get("SQL_OR_PRIV_GRP_EXCEPTION_INSERT");
		String SQL_OR_PRIV_GRP_EXCEPTION_COMP_INSERT = (String) sqlMap.get("SQL_OR_PRIV_GRP_EXCEPTION_COMP_INSERT");
		String SQL_OR_PRIV_GRP_EXCEPTION_COMP_DELETE = (String) sqlMap.get("SQL_OR_PRIV_GRP_EXCEPTION_COMP_DELETE");


		//traceVal.append(SQL_OR_INDEX_TICK_SHEET_DELETE);
		ArrayList deleteArrList	= new ArrayList();
		ArrayList insertArrList = new ArrayList();

		Hashtable HashHdrData			= new Hashtable();

		insertArrList			= (ArrayList)tabDataParam.get("insertArrList");
		deleteArrList			= (ArrayList)tabDataParam.get("deleteArrList");
		HashHdrData				= (Hashtable)tabDataParam.get("MultiHashData");

		///traceVal.append(HashHdrData.toString());
		///traceVal.append(insertArrList.toString());
		
		exception_type			= (String)HashHdrData.get("exception_type");
		grp_exception_id		= (String)HashHdrData.get("grp_exception_id");
		grp_exception_name		= (String)HashHdrData.get("grp_exception_name");
		//order_category			= (String)HashHdrData.get("order_category");
		//order_type_code			= (String)HashHdrData.get("order_type_code");
		bean_mode				= (String)HashHdrData.get("bean_mode");

		//traceVal.append("mode*******"+bean_mode);
		login_by_id				= (String)HashHdrData.get("login_by_id");
		login_at_ws_no			= (String)HashHdrData.get("login_at_ws_no");
		login_facility_id		= (String)HashHdrData.get("login_facility_id");

		try {
			connection				= getConnection((Properties)tabDataParam.get( "properties" )) ;
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

			if(insertArrList.size() >0){
				pstmt_ins_hdr	 = connection.prepareStatement(SQL_OR_PRIV_GRP_EXCEPTION_INSERT);
				pstmt_ins_dtl	 = connection.prepareStatement(SQL_OR_PRIV_GRP_EXCEPTION_COMP_INSERT);

				HashMap tabData  = new HashMap();
				if(bean_mode.equals("I")){
					pstmt_ins_hdr.setString(1 ,grp_exception_id);
					pstmt_ins_hdr.setString(2 ,grp_exception_name);
					pstmt_ins_hdr.setString(3 ,exception_type);
					pstmt_ins_hdr.setString(4 ,login_by_id);
					pstmt_ins_hdr.setString(5 ,login_at_ws_no);
					pstmt_ins_hdr.setString(6 ,login_facility_id);
					pstmt_ins_hdr.setString(7 ,login_by_id);
					pstmt_ins_hdr.setString(8 ,login_at_ws_no);
					pstmt_ins_hdr.setString(9 ,login_facility_id);
					pstmt_ins_hdr.addBatch();
					insertHdrCounts = pstmt_ins_hdr.executeBatch();
//System.out.println("======insertHdrCounts.length=============="+insertHdrCounts.length+"===");

					for (int i=0;i<insertHdrCounts.length ;i++ ){
						if(insertHdrCounts[i]<0  && insertHdrCounts[i] != -2 ){
							insert_flag=false;
							break;
						}
						else{
							insert_flag=true;
						}
					}
				}else if(bean_mode.equals("M")){
					insert_flag=true;
				}
//System.out.println("============insert_flag=============="+insert_flag+"===");
				if(insert_flag){
					for(int k=0 ; k < insertArrList.size() ; k++){
						tabData  = (HashMap)insertArrList.get(k);
						pstmt_ins_dtl.setString(1 ,grp_exception_id);
						pstmt_ins_dtl.setString(2 ,(String)tabData.get("code"));
						pstmt_ins_dtl.setString(3 ,exception_type);
						pstmt_ins_dtl.setString(4 ,login_by_id);
						pstmt_ins_dtl.setString(5 ,login_at_ws_no);
						pstmt_ins_dtl.setString(6 ,login_facility_id);
						pstmt_ins_dtl.setString(7 ,login_by_id);
						pstmt_ins_dtl.setString(8 ,login_at_ws_no);
						pstmt_ins_dtl.setString(9 ,login_facility_id);
						pstmt_ins_dtl.addBatch();
					}
				}
				insertDtlCounts = pstmt_ins_dtl.executeBatch();
				//System.out.println("============insertDtlCounts.length====="+insertDtlCounts.length+"===");
				for (int i=0;i<insertDtlCounts.length ;i++ ){
						if(insertDtlCounts[i]<0  && insertDtlCounts[i] != -2 ){
							insert_flag=false;
							break;
						}
						else{
							insert_flag=true;
						}
					}

				//traceVal.append("insertHdrCounts's Count:*** "+insertHdrCounts.length );
				//traceVal.append("insertDtlCounts's Count:*** "+insertDtlCounts.length );

			}
			//traceVal.append("insert_flag:*** "+insert_flag);


			if(insert_flag && deleteArrList.size() >0 ){
			pstmt_del	= connection.prepareStatement(SQL_OR_PRIV_GRP_EXCEPTION_COMP_DELETE);
			HashMap delMapData  = new HashMap();
			for(int k=0 ; k < deleteArrList.size() ; k++){
				delMapData  = (HashMap)deleteArrList.get(k);

				pstmt_del.setString(1 ,grp_exception_id);
				pstmt_del.setString(2 ,(String)delMapData.get("code"));
				pstmt_del.setString(3 ,exception_type);
				pstmt_del.addBatch();
			}
			deleteCounts = pstmt_del.executeBatch();
			//traceVal.append("deleteCounts's Count:*** "+deleteCounts.length );

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

		//traceVal.append("delete_flag:*** "+delete_flag);

		/*
		}else if(multiRec.equals("A")){
			pstmt					= connection.prepareStatement(SQL_OR_INDEX_TICK_SHEET_INSERT);

			pstmt.setString(1 ,order_category);
			pstmt.setString(2 ,tick_sheet_id);
			pstmt.setString(3 ,index_type);
			pstmt.setString(4 ,facility_id);
			pstmt.setString(5 ,"A");
			pstmt.setString(6 ,"*ALL");
			pstmt.setNull(7 ,java.sql.Types.NUMERIC);
			pstmt.setNull(8 ,java.sql.Types.NUMERIC);
			pstmt.setString(9  ,login_by_id);
			pstmt.setString(10 ,login_at_ws_no);
			pstmt.setString(11 ,login_facility_id);
			pstmt.setString(12 ,login_by_id);
			pstmt.setString(13 ,login_at_ws_no);
			pstmt.setString(14 ,login_facility_id);

			try{
				insSourceCount = pstmt.executeUpdate();
			}catch(Exception eSrc){
				traceVal.append(eSrc.getMessage());
				map.put( "traceVal", traceVal.toString() ) ;
			}

			if(insSourceCount > 0){
				insert_flag = true;
				delete_flag = true;
			}
		}
		*/

		if(insert_flag && delete_flag){
			//traceVal.append("abt to commit");
			connection.commit();
			map.put( "result", new Boolean( true ) ) ;
			//messages.append( "RECORD_INSERTED" ) ;
			messages = new StringBuffer("RECORD_INSERTED");
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
	messages.append(e.getMessage()) ;
	}
	finally{
	   try {
		    closeStatement( pstmt_ins_hdr ) ;
			closeStatement( pstmt_ins_dtl ) ;
			closeStatement( pstmt_del ) ;
			closeConnection( connection, (Properties)tabDataParam.get( "properties" ) );
		}catch ( Exception fe ) {
			System.err.println( fe.getMessage() ) ;
			fe.printStackTrace() ;
			traceVal.append(fe.getMessage());
			map.put( "traceVal", traceVal.toString() ) ;
		}
	}
	map.put( "msgid", messages.toString() ) ;
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


}//End of Class
