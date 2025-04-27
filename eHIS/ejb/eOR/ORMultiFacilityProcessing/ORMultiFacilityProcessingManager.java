/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.ORMultiFacilityProcessing;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import javax.ejb.* ;
import eOR.Common.* ;

/**
*
* @ejb.bean
*	name="ORMultiFacilityProcessing"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORMultiFacilityProcessing"
*	local-jndi-name="ORMultiFacilityProcessing"
*	impl-class-name="eOR.ORMultiFacilityProcessing.ORMultiFacilityProcessingManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORMultiFacilityProcessing.ORMultiFacilityProcessingLocal"
*	remote-class="eOR.ORMultiFacilityProcessing.ORMultiFacilityProcessingRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORMultiFacilityProcessing.ORMultiFacilityProcessingLocalHome"
*	remote-class="eOR.ORMultiFacilityProcessing.ORMultiFacilityProcessingHome"
*	generate= "local,remote"
*
*
*/

public class ORMultiFacilityProcessingManager extends OrEJBSessionAdapter {
	StringBuffer messages = new StringBuffer() ;
	StringBuffer traceVal = new StringBuffer() ;

	Connection connection = null ;
	PreparedStatement pstmt = null ;
	PreparedStatement pstmt_del = null ;

    //Added by Siva Kumar for Duplicate Check on 22/8/2003
    private boolean chkDuplicate1(String sql,Connection con ,String
        ordering_facility_id,String order_category,String order_type_code,String source_type_code, String source_location_code, ArrayList arrayList,String performing_facility_id) throws Exception{
        StringBuffer messages = new StringBuffer() ;
        StringBuffer traceVal = new StringBuffer() ;
    try{
            boolean dupFlag = false ;
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,ordering_facility_id);
            pstmt.setString(2,order_category);
            pstmt.setString(5,source_type_code);
            pstmt.setString(6,source_location_code);
            pstmt.setString(7,performing_facility_id);
            //System.out.println("SQL :" + sql);
            //System.out.println(ordering_facility_id + "~" + order_category + "~"
            //+ performing_facility_id);
            ResultSet rs	         = null ;
            int size				= arrayList.size() ;
           if(order_type_code.equals("ALL")){
                pstmt.setString(3,"*ALL");
                pstmt.setString(4,"*ALL");
                rs = pstmt.executeQuery();
                int count = 0;
                 if(rs.next())
                    count = rs.getInt(1);

				 if(rs !=null) {
					closeResultSet( rs ) ;
				}
            //System.out.println("Count :" + count);
            if(count > 0)
                dupFlag = true ;
                return dupFlag;
            } else if(arrayList.size() > 0) {
                //String strCatalog = "";
                for(int i =0 ; i < size ; i++){
                    pstmt.setString(3,order_type_code);
                    pstmt.setString(4,(String)((HashMap)arrayList.get(i)).get("code"));
                    rs = pstmt.executeQuery();
                    int count = 0;
				    if(rs.next())
                        count = rs.getInt(1);

					if(rs !=null) {
						closeResultSet( rs ) ;
					}
                    //System.out.println("Count :" + count);
                    if(count > 0) {
                        dupFlag = true ;
                        break;
                    }
                }
				rs.close();
                return dupFlag;
            }
        }catch(Exception e){
                traceVal.append(e);
                messages.append(e.getMessage());
                throw e;
     }finally
		{
	 try{
		 	closeStatement( pstmt ) ;
	 }catch(Exception ee){ee.printStackTrace();}
	 }
     return false;
    }//End of dulicate chk1

/**
* @ejb.interface-method
*	 view-type="both"
*/

    public HashMap insert( HashMap tabDataParam, HashMap sqlMap ) {
//System.out.println("####in insert() of ejb"+tabDataParam);
//System.out.println("####in insert() of ejb sqlMap"+sqlMap);
		//traceVal.append("Inside*******");

		messages 						= new StringBuffer() ;
		HashMap map 					= new HashMap() ;

		map.put( "result", new Boolean( false ) ) ;

		boolean insert_flag 			= false ;
		boolean delete_flag 			= false ;

		String ordering_facility_id		= "";
		String order_category			= "";
		String order_type_code			= "";
		String performing_facility_id	= "";
		String source_type_code			= "";
		String source_location_code		= "";
		String performing_location_code = "";

		String login_by_id				= "";
		String login_at_ws_no			= "";
		String login_facility_id		= "";

		int [] insertCounts ;
		int [] deleteCounts ;

		int insCategoryCount 			= 0;
        //Added by Siva Kumar for Duplicate Check on 22/8/2003
        String SQL_OR_MULTI_FAC_PROCESSING_DUP_CHK1 = (String)
            sqlMap.get("SQL_OR_MULTI_FAC_PROCESSING_DUP_CHK1");
        //End of Addition
		String SQL_OR_MULTI_FAC_PROCESSING_INSERT = (String) sqlMap.get("SQL_OR_MULTI_FAC_PROCESSING_INSERT");
		String SQL_OR_MULTI_FAC_PROCESSING_DELETE = (String) sqlMap.get("SQL_OR_MULTI_FAC_PROCESSING_DELETE");

		ArrayList deleteArrList	= new ArrayList();
		ArrayList insertArrList = new ArrayList();

		Hashtable HashHdrData			= new Hashtable();

		insertArrList			= (ArrayList)tabDataParam.get("insertArrList");
		deleteArrList			= (ArrayList)tabDataParam.get("deleteArrList");
		HashHdrData				= (Hashtable)tabDataParam.get("MultiHashData");
		//System.out.println("###insertArrList="+insertArrList);
		//System.out.println("###deleteArrList="+deleteArrList);
		//traceVal.append(HashHdrData.toString());
		//traceVal.append(deleteArrList.toString());

		ordering_facility_id		= (String)HashHdrData.get("ordering_facility_id");
		order_category				= (String)HashHdrData.get("order_category");
		order_type_code				= (String)HashHdrData.get("order_type_code");
		performing_facility_id		= (String)HashHdrData.get("performing_facility_id");
		source_type_code			= (String)HashHdrData.get("source_type_code");
		source_location_code		= (String)HashHdrData.get("source_location_code");
		performing_location_code	= (String)HashHdrData.get("performing_location_code");

		login_by_id					= (String)HashHdrData.get("login_by_id");
		login_at_ws_no				= (String)HashHdrData.get("login_at_ws_no");
		login_facility_id			= (String)HashHdrData.get("login_facility_id");

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

            traceVal.append("Before dup chk");

		boolean duplicate =
            chkDuplicate1(SQL_OR_MULTI_FAC_PROCESSING_DUP_CHK1,connection,ordering_facility_id,
            order_category,order_type_code,source_type_code,source_location_code,insertArrList,performing_facility_id);

		traceVal.append("After dup chk");
       // System.out.println("duplicate value :" + duplicate);
		if(duplicate){
            connection.rollback();
			String msg  =	 "CODE_ALREADY_EXISTS";
            map.put( "msgid", msg ) ;
            map.put( "flag", "Duplicate") ;
            map.put( "traceVal", "dup loop records" ) ;
            //connection.rollback();
            map.put( "result", new Boolean( false ) ) ;
			//messages.append( msg ) ;
            return map ;
		}
		if(!order_type_code.equals("ALL")){

				if(insertArrList.size() >0){
					if(pstmt != null)
						closeStatement(pstmt);
					pstmt					= connection.prepareStatement(SQL_OR_MULTI_FAC_PROCESSING_INSERT);
					HashMap tabData  = new HashMap();

					for(int k=0 ; k < insertArrList.size() ; k++){
						tabData  = (HashMap)insertArrList.get(k);

						pstmt.setString(1, ordering_facility_id);
						//System.out.println("ordering_facility_id="+ordering_facility_id);
						pstmt.setString(2, order_category);
						//System.out.println("order_category="+order_category);
						pstmt.setString(3, order_type_code);
						//System.out.println("order_type_code="+order_type_code);
						pstmt.setString(4, (String)tabData.get("code"));
						//System.out.println("order_catalog="+((String)tabData.get("code")));
						pstmt.setString(5, performing_facility_id);
						//System.out.println("performing_facility_id="+performing_facility_id);
						pstmt.setString(6, login_by_id);
						//System.out.println("login_by_id="+login_by_id);
						pstmt.setString(7, login_at_ws_no);
						//System.out.println("login_at_ws_no="+login_at_ws_no);
						pstmt.setString(8, login_facility_id);
						//System.out.println("login_facility_id="+login_facility_id);
						pstmt.setString(9, login_by_id);
						//System.out.println("login_by_id="+login_by_id);
						pstmt.setString(10,login_at_ws_no);
						//System.out.println("login_at_ws_no="+login_at_ws_no);
						pstmt.setString(11,login_facility_id);
						//System.out.println("login_facility_id="+login_facility_id);
						pstmt.setString(12,source_type_code);
						//System.out.println("source_type_code="+source_type_code);
						pstmt.setString(13,source_location_code);
						//System.out.println("source_location_code="+source_location_code);
						pstmt.setString(14,((order_category.equals("LB"))?"L":((order_category.equals("RD"))?"R":((order_category.equals("RX"))?"I":((order_category.equals("MI"))?"M":((order_category.equals("TR"))?"T":((order_category.equals("PC"))?"P":"")))))));
						//System.out.println("perf_locn_type="+((order_category.equals("LB"))?"L":((order_category.equals("RD"))?"R":((order_category.equals("RX"))?"I":((order_category.equals("MI"))?"M":((order_category.equals("TR"))?"T":((order_category.equals("PC"))?"P":"")))))));
						pstmt.setString(15,(String)tabData.get("performing_locn"));
						//System.out.println("performing_locn="+((String)tabData.get("performing_locn")));

						//updatedCounts = pstmt.executeUpdate();
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

					closeStatement(pstmt);
				}
				//System.out.println("insert_flag:*** "+insert_flag);
				//traceVal.append("insert_flag:*** "+insert_flag);
				//traceVal.append("deleteArrList.size() :*** "+deleteArrList.size() );
				if(insert_flag && deleteArrList.size() >0 ){
					pstmt_del	= connection.prepareStatement(SQL_OR_MULTI_FAC_PROCESSING_DELETE);
					HashMap delMapData  = new HashMap();
					for(int k=0 ; k < deleteArrList.size() ; k++){
					delMapData  = (HashMap)deleteArrList.get(k);
					pstmt_del.setString(1,(String)delMapData.get("code"));
					//System.out.println("catalog_code="+((String)delMapData.get("code")));
					pstmt_del.setString(2, ordering_facility_id);
					//System.out.println("ordering_facility_id="+ordering_facility_id);
					pstmt_del.setString(3, order_category);
					//System.out.println("order_category="+order_category);
					pstmt_del.setString(4, order_type_code);
					//System.out.println("order_type_code="+order_type_code);
					pstmt_del.setString(5, source_type_code);
					//System.out.println("source_type_code="+source_type_code);
					pstmt_del.setString(6, source_location_code);
					//System.out.println("source_location_code="+source_location_code);
					pstmt_del.addBatch();
				}

				deleteCounts = pstmt_del.executeBatch();
				//traceVal.append("deleteCounts's Count:*** "+deleteCounts.length );
				//System.out.println("deleteCounts.length*** "+deleteCounts.length);

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

		}else{

			pstmt	= connection.prepareStatement(SQL_OR_MULTI_FAC_PROCESSING_INSERT);

			pstmt.setString(1, ordering_facility_id);
			//System.out.println("ordering_facility_id="+ordering_facility_id);
			pstmt.setString(2, order_category);
			//System.out.println("order_category="+order_category);
			pstmt.setString(3, "*ALL");
			//System.out.println("order_type="+"*ALL");
			//pstmt.setNull(4 ,java.sql.Types.NUMERIC);
			pstmt.setString(4 ,"*ALL");
			//System.out.println("order_catalog="+"*ALL");
			pstmt.setString(5, performing_facility_id);
			//System.out.println("performing_facility_id="+performing_facility_id);
			pstmt.setString(6, login_by_id);
			//System.out.println("login_by_id="+login_by_id);
			pstmt.setString(7, login_at_ws_no);
			//System.out.println("login_at_ws_no="+login_at_ws_no);
			pstmt.setString(8, login_facility_id);
			//System.out.println("login_facility_id="+login_facility_id);
			pstmt.setString(9, login_by_id);
			//System.out.println("login_by_id="+login_by_id);
			pstmt.setString(10,login_at_ws_no);
			//System.out.println("login_at_ws_no="+login_at_ws_no);
			pstmt.setString(11,login_facility_id);
			//System.out.println("login_facility_id="+login_facility_id);
			pstmt.setString(12,source_type_code);
			//System.out.println("source_type_code="+source_type_code);
			pstmt.setString(13,source_location_code);
			//System.out.println("source_location_code="+source_location_code);
			pstmt.setString(14,((order_category.equals("LB"))?"L":((order_category.equals("RD"))?"R":((order_category.equals("RX"))?"I":((order_category.equals("MI"))?"M":((order_category.equals("TR"))?"T":((order_category.equals("PC"))?"P":"")))))));
			//System.out.println("performing_locn_type="+((order_category.equals("LB"))?"L":((order_category.equals("RD"))?"R":((order_category.equals("RX"))?"I":((order_category.equals("MI"))?"M":((order_category.equals("TR"))?"T":((order_category.equals("PC"))?"P":"")))))));
			pstmt.setString(15,performing_location_code);
			//System.out.println("performing_locn="+performing_location_code);

			try{
				insCategoryCount = pstmt.executeUpdate();
			}catch(Exception eSrc){
			    traceVal.append(eSrc.getMessage());
				map.put( "traceVal", traceVal.toString() ) ;
			}
            if(insCategoryCount > 0){
				insert_flag = true;
				delete_flag = true;
			}else{
				insert_flag = false;
				delete_flag = false;
			}
		}
		//traceVal.append("delete_flag:*** "+delete_flag);
		//System.out.println("delete_flag:*** "+delete_flag);
		//System.out.println("insert_flag:***++ "+insert_flag);
       // System.out.println("ASK Here after exception :");
		if(insert_flag && delete_flag){

			//traceVal.append("abt to commit");
			//System.out.println("abt to commit");
			connection.commit();
			map.put( "result", new Boolean( true ) ) ;
			messages.append( "RECORD_INSERTED" ) ;
		}
		else{
			connection.rollback();
			map.put( "result", new Boolean( false ) ) ;
			messages.append( "CODE_ALREADY_EXISTS" ) ;
			throw new EJBException("Insert/Update Failed");
		}
//System.out.println("before close"+messages.toString());
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
	map.put( "msgid", messages.toString() ) ;
	map.put( "traceVal", traceVal.toString() ) ;
	return map ;
	}


/**
* @ejb.interface-method
*	 view-type="both"
*/

public HashMap modify( HashMap tabDataParam, HashMap sqlMap ) 
{

		messages 						= new StringBuffer() ;
		HashMap map 					= new HashMap() ;

		map.put( "result", new Boolean( false ) ) ;

		boolean insert_flag 			= false ;
		boolean delete_flag 			= false ;

		String ordering_facility_id		= "";
		String order_category			= "";
		String order_type_code			= "";
		String performing_facility_id	= "";
		String source_type_code			= "";
		String source_location_code		= "";
		String performing_location_code = "";

		String login_by_id				= "";
		String login_at_ws_no			= "";
		String login_facility_id		= "";

		int [] insertCounts ;
		int [] deleteCounts ;

		int insCategoryCount 			= 0;
  
		String SQL_OR_MULTI_FAC_PROCESSING_INSERT = (String) sqlMap.get("SQL_OR_MULTI_FAC_PROCESSING_INSERT");
		String SQL_OR_MULTI_FAC_PROCESSING_DELETE = (String) sqlMap.get("SQL_OR_MULTI_FAC_PROCESSING_DELETE");
		String SQL_OR_MULTI_FAC_PROCESSING_UPDATE = (String) sqlMap.get("SQL_OR_MULTI_FAC_PROCESSING_UPDATE");

		ArrayList deleteArrList	= new ArrayList();
		ArrayList insertArrList = new ArrayList();

		Hashtable HashHdrData			= new Hashtable();

		insertArrList			= (ArrayList)tabDataParam.get("insertArrList");
		deleteArrList			= (ArrayList)tabDataParam.get("deleteArrList");
		HashHdrData				= (Hashtable)tabDataParam.get("ModifyMultiHashData");
		
		ordering_facility_id		= (String)HashHdrData.get("ordering_facility_id");
		order_category				= (String)HashHdrData.get("order_category");
		order_type_code				= (String)HashHdrData.get("order_type_code");
		performing_facility_id		= (String)HashHdrData.get("performing_facility_id");
		source_type_code			= (String)HashHdrData.get("source_type_code");
		source_location_code		= (String)HashHdrData.get("source_location_code");
		performing_location_code	= (String)HashHdrData.get("performing_location_code");

		login_by_id					= (String)HashHdrData.get("login_by_id");
		login_at_ws_no				= (String)HashHdrData.get("login_at_ws_no");
		login_facility_id			= (String)HashHdrData.get("login_facility_id");

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

            traceVal.append("Before dup chk");


		traceVal.append("After dup chk");
       
		if(!order_type_code.equals("ALL")){

				if(insertArrList.size() >0){
					if(pstmt != null)
						closeStatement(pstmt);
					pstmt					= connection.prepareStatement(SQL_OR_MULTI_FAC_PROCESSING_INSERT);
					HashMap tabData  = new HashMap();

					for(int k=0 ; k < insertArrList.size() ; k++){
						tabData  = (HashMap)insertArrList.get(k);

						pstmt.setString(1, ordering_facility_id);
						pstmt.setString(2, order_category);
						pstmt.setString(3, order_type_code);
						pstmt.setString(4, (String)tabData.get("code"));
						pstmt.setString(5, performing_facility_id);
						pstmt.setString(6, login_by_id);
						pstmt.setString(7, login_at_ws_no);
						pstmt.setString(8, login_facility_id);
						pstmt.setString(9, login_by_id);
						pstmt.setString(10,login_at_ws_no);
						pstmt.setString(11,login_facility_id);
						pstmt.setString(12,source_type_code);
						pstmt.setString(13,source_location_code);						pstmt.setString(14,((order_category.equals("LB"))?"L":((order_category.equals("RD"))?"R":((order_category.equals("RX"))?"I":((order_category.equals("MI"))?"M":((order_category.equals("TR"))?"T":((order_category.equals("PC"))?"P":"")))))));
						pstmt.setString(15,(String)tabData.get("performing_locn"));
						
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

					closeStatement(pstmt);
				}
				
				if(insert_flag && deleteArrList.size() >0 ){
					pstmt_del	= connection.prepareStatement(SQL_OR_MULTI_FAC_PROCESSING_DELETE);
					HashMap delMapData  = new HashMap();
					for(int k=0 ; k < deleteArrList.size() ; k++){
					delMapData  = (HashMap)deleteArrList.get(k);
					pstmt_del.setString(1,(String)delMapData.get("code"));
					pstmt_del.setString(2, ordering_facility_id);
					pstmt_del.setString(3, order_category);
					pstmt_del.setString(4, order_type_code);
					pstmt_del.setString(5, source_type_code);
					pstmt_del.setString(6, source_location_code);
				
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

		}else{

			pstmt	= connection.prepareStatement(SQL_OR_MULTI_FAC_PROCESSING_UPDATE);
	
			pstmt.setString(1, performing_location_code);
			pstmt.setString(2, login_by_id);
			pstmt.setString(3,login_at_ws_no);
			pstmt.setString(4,login_facility_id);
			pstmt.setString(5, ordering_facility_id);
			pstmt.setString(6,source_type_code);
			pstmt.setString(7,source_location_code);
			pstmt.setString(8, order_category);
			pstmt.setString(9, "*ALL");
			pstmt.setString(10, performing_facility_id);
			pstmt.setString(11 ,"*ALL");
			try{
				insCategoryCount = pstmt.executeUpdate();
			}catch(Exception eSrc){
			    traceVal.append(eSrc.getMessage());
				map.put( "traceVal", traceVal.toString() ) ;
			}
            if(insCategoryCount > 0){
				insert_flag = true;
				delete_flag = true;
			}else{
				insert_flag = false;
				delete_flag = false;
			}
		}

		if(insert_flag && delete_flag){
			connection.commit();
			map.put( "result", new Boolean( true ) ) ;
			messages.append( "RECORD_MODIFIED" ) ;
		}
		else{
			connection.rollback();
			map.put( "result", new Boolean( false ) ) ;
			messages.append( "CODE_ALREADY_EXISTS" ) ;
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
	map.put( "msgid", messages.toString() ) ;
	map.put( "traceVal", traceVal.toString() ) ;
	return map ;
}
	

/**
* @ejb.interface-method
*	 view-type="both"
*/

 public HashMap delete( HashMap tabData, HashMap sqlMap )
{
		
	HashMap map = new HashMap() ;
	StringBuffer messages = new StringBuffer();
	StringBuffer traceVal = new StringBuffer();

	map.put( "result", new Boolean( false ) );
	map.put( "flag", "") ;
	map.put( "callOnSuccess", new Boolean( false ) ) ;
	map.put( "message", messages.toString() ) ;

	//to get the query from repository file

	String sql_or_multi_fac_processing_delete = "";
	
	String ordering_facility_id="";
    String order_category="";
	String order_type_code="";
    String source_type_code="";
    String source_location_code="";
    String performing_facility_id="";
	
	int count=0;
	
	if(tabData.isEmpty())
	{
			return null;
	}
	else
	{
		
		sql_or_multi_fac_processing_delete = (String) sqlMap.get("SQL_OR_MULTI_FAC_PROCESSING_DELETE");
		ordering_facility_id = (String )tabData.get("ordering_facility_id");
		order_category = (String )tabData.get("order_category");
		order_type_code = (String )tabData.get("order_type_code");
		source_type_code = (String )tabData.get("source_type_code");
		source_location_code = (String )tabData.get("source_location_code");
		performing_facility_id = (String )tabData.get("performing_facility_id");
		if(order_type_code.equalsIgnoreCase("ALL"))
		{
			order_type_code="*ALL";
		}

		
		try{
			connection = getConnection( (Properties)tabData.get( "properties" ));

			connection.setAutoCommit(false);  // avoide Committing the transaction automatically

			pstmt_del = connection.prepareStatement(sql_or_multi_fac_processing_delete);
			pstmt_del.setString(1,ordering_facility_id);
			pstmt_del.setString(2,order_category);
			pstmt_del.setString(3,order_type_code);
			pstmt_del.setString(4,source_type_code);
			pstmt_del.setString(5,source_location_code);
			pstmt_del.setString(6,performing_facility_id);
			count = pstmt_del.executeUpdate(); //execution of delete query
			
			if(count>0)
			{
				
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", "RECORD_DELETED" ) ;
			}
			else
			{
				connection.rollback();
				map.put( "result", new Boolean( false ) ) ;
			}

			map.put("RecordCount",String.valueOf(count));
		}catch(SQLException sqle)
		{
			try{
			connection.rollback();  // rollback the current transaction
		}catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
			System.out.println(sqle.getMessage());
			sqle.printStackTrace();
		}
		catch(Exception e)
		{
			try{
			connection.rollback();  // rollback the current transaction
		}catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try{
			closeStatement(pstmt);
			closeStatement(pstmt_del);
			
			closeConnection(connection,(Properties)tabData.get( "properties" ));
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
				traceVal.append(e.getMessage());
			}
	}
	messages.setLength(0);
	traceVal.setLength(0);
	
	return map ;
	}// end of else
}
}///End of Class
