/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.ORIndexOrderCareSet;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import javax.ejb.* ;
import eOR.Common.* ;

/**
*
* @ejb.bean
*	name="ORIndexOrderCareSet"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORIndexOrderCareSet"
*	local-jndi-name="ORIndexOrderCareSet"
*	impl-class-name="eOR.ORIndexOrderCareSet.ORIndexOrderCareSetManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORIndexOrderCareSet.ORIndexOrderCareSetLocal"
*	remote-class="eOR.ORIndexOrderCareSet.ORIndexOrderCareSetRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORIndexOrderCareSet.ORIndexOrderCareSetLocalHome"
*	remote-class="eOR.ORIndexOrderCareSet.ORIndexOrderCareSetHome"
*	generate= "local,remote"
*
*
*/

public class ORIndexOrderCareSetManager extends OrEJBSessionAdapter {


/**
* @ejb.interface-method
*	 view-type="both"
*/

public HashMap insert( HashMap tabDataParam, HashMap sqlMap ) 
	{
		HashMap map = new HashMap() ;
		StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		PreparedStatement pstmt_del = null ;
		map.put( "result", new Boolean( false ) ) ;
		boolean insert_flag = false ;
		boolean delete_flag = false ;
		
		String care_set_id				= "";
		String index_type				= "";
		String facility_id				= "";
		String source_type				= "";
		String multiRec					= "";
		String diag_code_scheme			= "";
		String diagnosis_code			= "";

		String login_by_id				= "";
		String login_at_ws_no			= "";
		String login_facility_id		= "";

		int [] insertCounts ;
		int [] deleteCounts ;
		int insSourceCount = 0;
			
		String SQL_OR_INDEX_CARE_SET_INSERT = (String) sqlMap.get("SQL_OR_INDEX_CARE_SET_INSERT");
		String SQL_OR_INDEX_CARE_SET_DELETE = (String) sqlMap.get("SQL_OR_INDEX_CARE_SET_DELETE");
		
		ArrayList deleteArrList	= new ArrayList();
		ArrayList insertArrList = new ArrayList();

		Hashtable HashHdrData			= new Hashtable();

		insertArrList			= (ArrayList)tabDataParam.get("insertArrList");
		deleteArrList			= (ArrayList)tabDataParam.get("deleteArrList");
		HashHdrData				= (Hashtable)tabDataParam.get("MultiHashData");

		traceVal.append("MultiHashData = "+HashHdrData.toString());
		traceVal.append("InsertRecords = "+insertArrList.toString());
		traceVal.append("DeleteRecords = "+deleteArrList.toString());

		care_set_id				= (String)HashHdrData.get("care_set_id");
		index_type				= (String)HashHdrData.get("index_type");
		facility_id				= (String)HashHdrData.get("facility_id");
		source_type				= (String)HashHdrData.get("source_type");
		multiRec				= (String)HashHdrData.get("multiRec");
		diag_code_scheme		= (String)HashHdrData.get("diag_code_scheme");
		diagnosis_code			= (String)HashHdrData.get("diagnosis_code");

		login_by_id				= (String)HashHdrData.get("login_by_id");							
		login_at_ws_no			= (String)HashHdrData.get("login_at_ws_no");
		login_facility_id		= (String)HashHdrData.get("login_facility_id");

		try {
			connection = getConnection((Properties)tabDataParam.get( "properties" )) ;
		}catch(Exception Exp){
			throw new EJBException( Exp.getMessage() ) ;
		}

		try{
			if(!multiRec.equals("A")){

				if(insertArrList.size() >0)
					insert_flag = false;
				else
					insert_flag = true;

				if(deleteArrList.size() >0)
					delete_flag = false;
				else
					delete_flag = true;
				traceVal.append("index_type = "+index_type);
				traceVal.append("multiRec = "+multiRec);
				if(insertArrList.size() > 0)
				{
					pstmt = connection.prepareStatement(SQL_OR_INDEX_CARE_SET_INSERT);
					HashMap tabData  = new HashMap();	
					for(int k=0 ; k < insertArrList.size() ; k++)
					{
						tabData  = (HashMap)insertArrList.get(k);
						int para = 1;
						pstmt.setString(para++ ,care_set_id);
						pstmt.setString(para++ ,index_type);

						if(index_type.equals("F")){
							pstmt.setString(para++ ,facility_id);
							pstmt.setString(para++ ,source_type);
						}else{
							pstmt.setNull(para++ ,java.sql.Types.NUMERIC);
							pstmt.setNull(para++ ,java.sql.Types.NUMERIC);
						}

						if((multiRec.equals("C")) || (multiRec.equals("N")))
							pstmt.setString(para++ ,(String)tabData.get("code"));
						else
							pstmt.setNull(para++ ,java.sql.Types.NUMERIC);					

						if(multiRec.equals("P"))
							pstmt.setString(para++ ,(String)tabData.get("code"));
						else
							pstmt.setNull(para++ ,java.sql.Types.NUMERIC);

						pstmt.setNull(para++ ,java.sql.Types.NUMERIC);

						if(multiRec.equals("S"))
							pstmt.setString(para++ ,(String)tabData.get("code"));
						else
							pstmt.setNull(para++ ,java.sql.Types.NUMERIC);
						
						pstmt.setNull(para++ ,java.sql.Types.NUMERIC);
						pstmt.setNull(para++ ,java.sql.Types.NUMERIC);

						pstmt.setString(para++ ,login_by_id);
						pstmt.setString(para++ ,login_at_ws_no);
						pstmt.setString(para++ ,login_facility_id);
						pstmt.setString(para++ ,login_by_id);
						pstmt.setString(para++ ,login_at_ws_no);
						pstmt.setString(para++ ,login_facility_id);
						
						pstmt.addBatch();
					}
					
					insertCounts = pstmt.executeBatch();

					closeStatement(pstmt);
					traceVal.append("insertCount's Count:*** "+insertCounts.length );
								
					for (int i=0;i<insertCounts.length ;i++ ){
						if(insertCounts[i]<0  && insertCounts[i] != -2 ){
							insert_flag=false;
							break;
						}
						else{
						insert_flag=true;
						}
					}
				}else if (index_type.equals("D"))
				{
					pstmt = connection.prepareStatement(SQL_OR_INDEX_CARE_SET_INSERT);
					int para = 1;
					pstmt.setString(para++ ,care_set_id);
					pstmt.setString(para++ ,index_type);
					pstmt.setString(para++ ,"");
					pstmt.setString(para++ ,"");
					pstmt.setString(para++ ,"");
					pstmt.setString(para++ ,"");
					pstmt.setString(para++ ,"");
					pstmt.setString(para++ ,"");
					pstmt.setString(para++ ,diag_code_scheme);
					pstmt.setString(para++ ,diagnosis_code);
					pstmt.setString(para++ ,login_by_id);
					pstmt.setString(para++ ,login_at_ws_no);
					pstmt.setString(para++ ,login_facility_id);
					pstmt.setString(para++ ,login_by_id);
					pstmt.setString(para++ ,login_at_ws_no);
					pstmt.setString(para++ ,login_facility_id);

					int diag_result = pstmt.executeUpdate();

					closeStatement(pstmt);
					if(diag_result == 1)	insert_flag = true;
				}				
				
				if(insert_flag && deleteArrList.size() >0 )
				{
					pstmt_del	= connection.prepareStatement(SQL_OR_INDEX_CARE_SET_DELETE);
					HashMap delMapData  = new HashMap();	

					for(int k=0 ; k < deleteArrList.size() ; k++){
					delMapData  = (HashMap)deleteArrList.get(k);

					pstmt_del.setString(1 ,care_set_id);
					if(multiRec.equals("P") || multiRec.equals("S")){
						pstmt_del.setString(2 ,(String)delMapData.get("code"));
					}else if(multiRec.equals("N") || multiRec.equals("C")){
						pstmt_del.setString(2 ,facility_id);
						pstmt_del.setString(3 ,multiRec);
						pstmt_del.setString(4 ,(String)delMapData.get("code"));
					}else if(multiRec.equals("D")){
						pstmt_del.setString(2 ,diag_code_scheme);
						pstmt_del.setString(3 ,diagnosis_code);
					}
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
			
			
		}else if(multiRec.equals("A")){
			pstmt = connection.prepareStatement(SQL_OR_INDEX_CARE_SET_INSERT);
			int para = 1;
			pstmt.setString(para++ ,care_set_id);
			pstmt.setString(para++ ,index_type);
			pstmt.setString(para++ ,facility_id);
			pstmt.setString(para++ ,"A");
			pstmt.setString(para++ ,"*ALL");
			pstmt.setNull(para++ ,java.sql.Types.NUMERIC);
			pstmt.setNull(para++ ,java.sql.Types.NUMERIC);
			pstmt.setNull(para++ ,java.sql.Types.NUMERIC);
			pstmt.setNull(para++ ,java.sql.Types.NUMERIC);
			pstmt.setNull(para++ ,java.sql.Types.NUMERIC);
			pstmt.setString(para++ ,login_by_id);
			pstmt.setString(para++ ,login_at_ws_no);
			pstmt.setString(para++ ,login_facility_id);
			pstmt.setString(para++ ,login_by_id);
			pstmt.setString(para++ ,login_at_ws_no);
			pstmt.setString(para++ ,login_facility_id);
			
			insSourceCount = pstmt.executeUpdate();	
			closeStatement(pstmt);
			if(insSourceCount > 0){
				insert_flag = true;
				delete_flag = true;
			}
		}
	
		if(insert_flag && delete_flag)
		{
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
	catch(Exception e)
	{
		System.err.println("E"+e.toString());
		String errormsg = e.toString();
		if(errormsg.indexOf("unique") >= 1)
			messages.append("CODE_ALREADY_EXISTS");
	}
	finally{
	   try {
		    closeStatement( pstmt ) ;
			closeStatement( pstmt_del ) ;
			closeConnection( connection, (Properties)tabDataParam.get( "properties" ) );
		}catch ( Exception fe ) {
			System.err.println( fe.getMessage() ) ;
			traceVal.append(fe.getMessage());
		}
	}
	
	map.put( "msgid", messages.toString()) ;
	map.put( "traceVal", traceVal.toString() ) ;
	
	return map ;
	}

/**
* @ejb.interface-method
*	 view-type="both"
*/

	 public HashMap modify( HashMap tabDataParam, HashMap sqlMap )  {
	
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

	 public HashMap delete( HashMap tabDataParam, HashMap sqlMap )  {
		//StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		return map ;
	}


}///End of Class
