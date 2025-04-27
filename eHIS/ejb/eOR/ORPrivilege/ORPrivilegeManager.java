/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.ORPrivilege ;


import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import eOR.Common.* ;
import javax.ejb.* ;

import webbeans.eCommon.*;

import eCommon.Common.*;
 
/**
*
* @ejb.bean
*	name="ORPrivilege"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORPrivilege"
*	local-jndi-name="ORPrivilege"
*	impl-class-name="eOR.ORPrivilege.ORPrivilegeManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORPrivilege.ORPrivilegeLocal"
*	remote-class="eOR.ORPrivilege.ORPrivilegeRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORPrivilege.ORPrivilegeLocalHome"
*	remote-class="eOR.ORPrivilege.ORPrivilegeHome"
*	generate= "local,remote"
*
*
*/

public class ORPrivilegeManager extends OrEJBSessionAdapter {

/**
* @ejb.interface-method
*	 view-type="both"
*/
public HashMap insert(HashMap tabDataParam , HashMap sqlMap ) {
	
		String login_by_id = "";
		String login_at_ws_no = "";
		String login_facility_id = "";
	 	StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;
		Connection connection = null ;
		PreparedStatement pstmt_base = null ;
		PreparedStatement pstmt_child = null ;
		PreparedStatement pstmt_seq = null ;
		PreparedStatement pstmt_delete = null ;
		ResultSet rs =null;
	//	int counter = 0;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "insert" ) ;
		//boolean flag = true ;

		HashMap tabDataMultiple = null ;
		Properties pt = null ;
	try {
		 tabDataMultiple = (HashMap)tabDataParam.get("records");
		 int recCount = tabDataMultiple.size();
		 //System.out.println("inhashmapinejb"+tabDataMultiple);
		 //System.out.println("inhashmapsizeinejb"+recCount);

		// ArrayList	grp_exception_store = new ArrayList();
		 pt = (Properties)tabDataParam.get( "properties" ) ;

		String SQL_OR_PRIVILEGE_CTX_INSERT	   =(String)sqlMap.get("SQL_OR_PRIVILEGE_CTX_INSERT");
		String SQL_OR_PRIVILEGE_CTX_EXP_INSERT =(String)sqlMap.get("SQL_OR_PRIVILEGE_CTX_EXP_INSERT");
		String SQL_OR_PRIVILEGE_CTX_DUP		   =(String)sqlMap.get("SQL_OR_PRIVILEGE_CTX_DUP");
		String SQL_OR_PRIVILEGE_SEL_SEQ		   =(String)sqlMap.get("SQL_OR_PRIVILEGE_SEL_SEQ");

		 connection = getConnection(pt) ;

 		String arrChkDup[]  =  new String[4] ;

		String appl_user_id =(((String)tabDataParam.get("appl_user_id")).equals(""))?null:((String)tabDataParam.get("appl_user_id")).trim();
		String reln_id	   =(((String)tabDataParam.get("reln_id")).equals(""))?null:((String)tabDataParam.get("reln_id")).trim();
		String resp_id	   =(((String)tabDataParam.get("resp_id")).equals(""))?null:((String)tabDataParam.get("resp_id")).trim();

		//String privilege_ctx = (((String)tabDataParam.get("privilege_ctx")).equals(""))?null:((String)tabDataParam.get("privilege_ctx")).trim();
		String facility_id = (((String)tabDataParam.get("facility_id")).equals(""))?null:((String)tabDataParam.get("facility_id")).trim();
		//System.out.println("==="+((String)tabDataParam.get("facility_id")));
		arrChkDup[0] = appl_user_id ;
		arrChkDup[1] = reln_id ;
		arrChkDup[2] = resp_id ;
		HashMap temp = null;

		arrChkDup[3] = (String)tabDataParam.get("facility_id");

		temp = (HashMap ) tabDataMultiple.get(String.valueOf("0"));
		login_by_id = (String)temp.get("login_by_id");
		login_at_ws_no = (String)temp.get("login_at_ws_no");
		login_facility_id = (String)temp.get("login_facility_id");

		
		
		boolean duplicate = chkDuplicate(SQL_OR_PRIVILEGE_CTX_DUP,connection,arrChkDup);

		if(duplicate)
		{
		  String msg  =	 "CODE_ALREADY_EXISTS";
		  map.put( "message", msg ) ;
          map.put( "flag", "Duplicate") ;
		  map.put( "traceVal", "dup loop records" ) ;
		  connection.rollback();
		  return map ;
		}

 		/*insertion in or_privilege_ctx*/
		
		pstmt_base = connection.prepareStatement(SQL_OR_PRIVILEGE_CTX_INSERT);
		pstmt_child = connection.prepareStatement(SQL_OR_PRIVILEGE_CTX_EXP_INSERT);
		String  privilege_ctx_id  =  "";
		pstmt_seq = connection.prepareStatement(SQL_OR_PRIVILEGE_SEL_SEQ);

			rs		  = pstmt_seq.executeQuery();
			privilege_ctx_id = "";

			if(rs.next())
			privilege_ctx_id = rs.getString(1);

		//Insert into OR_PRIVILEGE_CTX
			/*System.out.println("privilege_ctx_id"+privilege_ctx_id);
			System.out.println("facility_id"+facility_id);
			System.out.println("appl_user_id"+appl_user_id);
			System.out.println("reln_id"+reln_id);
			System.out.println("resp_id"+resp_id);
			System.out.println("login_by_id"+login_by_id);
			System.out.println("login_at_ws_no"+login_at_ws_no);
			System.out.println("login_facility_id"+login_facility_id);
			System.out.println("login_by_id"+login_by_id);
			System.out.println("login_at_ws_no"+login_at_ws_no);
			System.out.println("login_facility_id"+login_facility_id);*/
 			pstmt_base.setString(1,privilege_ctx_id);
 			pstmt_base.setString(2,facility_id);
			pstmt_base.setString(3,appl_user_id);
			pstmt_base.setString(4,reln_id);
			pstmt_base.setString(5,resp_id);
			pstmt_base.setString(6,login_by_id);
			pstmt_base.setString(7,login_at_ws_no);
			pstmt_base.setString(8,login_facility_id);
			pstmt_base.setString(9,login_by_id);
			pstmt_base.setString(10,login_at_ws_no);
			pstmt_base.setString(11,login_facility_id);
			pstmt_base.addBatch();

		StringTokenizer StrToken = null;
		StringTokenizer StrToken_priv_value = null;
		String privilege_id = "";
		String grp_exception_id = "";
		HashMap tabData=null;
		String privilege_value="";
		String priv_id = "";
		String priv_value="";
		for(int i=0;i<recCount;i++)
		{
 			tabData = (HashMap)tabDataMultiple.get(String.valueOf(i));
			grp_exception_id = (String)tabData.get("grp_exception_id");
 			login_by_id = (String)tabData.get("login_by_id");
			login_at_ws_no = (String)tabData.get("login_at_ws_no");
			login_facility_id = (String)tabData.get("login_facility_id");
 
			privilege_value = (String)tabData.get("privilege_value") ;
			StrToken_priv_value = new StringTokenizer(privilege_value,",");//added by Kavitha.K 1/12/2005
 			privilege_id = (String)tabData.get("privilege_id");
 			StrToken = new StringTokenizer(privilege_id,",");
			priv_id = "";
			priv_value="";

//System.out.println("b4token"+privilege_value);
//System.out.println("b4tokenid"+privilege_id);

 			while(StrToken.hasMoreTokens())
			{
 				priv_id = StrToken.nextToken();
				if(priv_id != null && !priv_id.equals(""))
				{
					if (StrToken_priv_value.hasMoreTokens())
					{
						priv_value= StrToken_priv_value.nextToken();
					}
						pstmt_child.setString(1 ,privilege_ctx_id);
						pstmt_child.setString(2 ,grp_exception_id);
						pstmt_child.setString(3 ,priv_id);
						pstmt_child.setString(4 ,priv_value);
						pstmt_child.setString(5 ,login_by_id);
						pstmt_child.setString(6 ,login_at_ws_no);
						pstmt_child.setString(7 ,login_facility_id);
						pstmt_child.setString(8 ,login_by_id);
						pstmt_child.setString(9, login_at_ws_no);
						pstmt_child.setString(10, login_facility_id);
						pstmt_child.addBatch();
				}
			}
		}//for
		//int updatedCounts1=0 ;
			try{
					pstmt_base.executeBatch();
 				 //updatedCounts1 = pstmt_base.executeUpdate();
 			}catch(Exception e){
				//counter = 0;
 					connection.rollback();
					e.printStackTrace();
					System.err.println("Exception here : "+ e) ;
					return map ;
			}

		int [] updatedCounts ;
		try{
 				 updatedCounts = pstmt_child.executeBatch();
 		 }catch(Exception e){
 					connection.rollback();
					e.printStackTrace();
					traceVal.append(e.getMessage());
					map.put( "traceVal", traceVal.toString() ) ;
					return map ;
		}

 			boolean updated = false	;
			if((updatedCounts.length > 0)){
				updated= true ;
			}else if((updatedCounts.length == (-3))){
				updated= false ;
			}
 			if (updated){
 						connection.commit();
						map.put( "result", new Boolean( true ) ) ;
						messages.append( "RECORD_INSERTED" ) ;
			}else{
						connection.rollback();
						messages.append( "Insert Failed" ) ;
			}

		 }catch( Exception e ){
				try {
 						connection.rollback();
				} catch ( Exception ee ) {
						messages.append(ee.getMessage() ) ;
				}

				messages.append( e.getMessage() ) ;
 				e.printStackTrace() ;
    		  } finally{
	            	try {
						closeResultSet( rs);
						closeStatement( pstmt_base ) ;
						closeStatement( pstmt_child ) ;
						closeStatement( pstmt_seq ) ;
						closeStatement( pstmt_delete ) ;

						 closeConnection( connection ,pt);

        			} catch ( Exception fe ) {
		     			System.err.println( fe.getMessage() ) ;
					   	fe.printStackTrace() ;
			        }
	    	    }
 			map.put( "message", messages.toString() ) ;
			map.put( "traceVal", traceVal.toString() ) ;
			//System.out.println("=====map===="+map+"==========map.get(message)===="+map.get( "message" ));
  			return map ;
  }//End of Insert Method

/****************************************************************************/
	/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap modify( HashMap tabDataParam, HashMap sqlMap ) {
 		String login_by_id = "";
		String login_at_ws_no = "";
		String login_facility_id = "";
		String arrChkDup[]  =  new String[4] ;
	 	StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;
		String privilege_id = "";
		Connection connection = null ;
		PreparedStatement pstmt_base = null ;
		PreparedStatement pstmt_child = null ;
		PreparedStatement pstmt_seq = null ;
		PreparedStatement pstmt_delete = null ;
		PreparedStatement pstmt_temp = null ;
		ResultSet rs =null;
 
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "modify" ) ;

		//boolean flag = true ;

		HashMap tabDataMultiple = null ;
		Properties pt = null ;
 	try {
		 pt = (Properties)tabDataParam.get( "properties" ) ;
		 

		String privilege_ctx_id = (String)tabDataParam.get("privilege_ctx_id") ;
		StringTokenizer StrToken = null;
		StringTokenizer StrToken_priv_value = null;

		String SQL_OR_PRIVILEGE_CTX_INSERT	   =(String)sqlMap.get("SQL_OR_PRIVILEGE_CTX_INSERT");
		String SQL_OR_PRIVILEGE_CTX_EXP_INSERT =(String)sqlMap.get("SQL_OR_PRIVILEGE_CTX_EXP_INSERT");
		String SQL_OR_PRIVILEGE_CTX_DUP		   =(String)sqlMap.get("SQL_OR_PRIVILEGE_CTX_DUP");
		//String SQL_OR_PRIVILEGE_SEL_SEQ		   =(String)sqlMap.get("SQL_OR_PRIVILEGE_SEL_SEQ");
 
	/******************************************************************************************/
	String SQL_OR_PRIVILEGE_CTX_EXP_DELETE =(String)sqlMap.get("SQL_OR_PRIVILEGE_CTX_EXP_DELETE");

 		connection = getConnection(pt) ;
		pstmt_delete = connection.prepareStatement(SQL_OR_PRIVILEGE_CTX_EXP_DELETE);
 
		pstmt_delete.setString(1,privilege_ctx_id);

		int res_del  = pstmt_delete.executeUpdate();

		if(res_del == 0){
 		connection.rollback();
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", "Delete Failed in Child Table While Updating") ;
		return map ;
		}

		pstmt_base = connection.prepareStatement((String)sqlMap.get("SQL_OR_PRIVILEGE_CTX_DELETE"));
 		pstmt_base.setString(1,privilege_ctx_id);

		int res  = pstmt_base.executeUpdate();

		closeStatement( pstmt_base ) ;
 		if(res == 0){
 		connection.rollback();
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", "Update Failed in Base Table") ;
		return map ;
		}
 		

		boolean updated = false	;
		if( res > 0 && res_del >0)
			updated= true ;
		else if(res <= 0 || res_del <= 0){
			updated= false ;
		}

		if (updated){
			map.put( "result", new Boolean( true ) ) ;
			}else{
				connection.rollback();
				messages.append( "Delete Failed" ) ;
			}


	////////////// - INSERT HERE /////////////////////////

  	//	ArrayList grp_exception_store = new ArrayList();
 		String appl_user_id =(((String)tabDataParam.get("appl_user_id")).equals(""))?null:((String)tabDataParam.get("appl_user_id")).trim();
		String reln_id	   =(((String)tabDataParam.get("reln_id")).equals(""))?null:((String)tabDataParam.get("reln_id")).trim();
		String resp_id	   =(((String)tabDataParam.get("resp_id")).equals(""))?null:((String)tabDataParam.get("resp_id")).trim();

		//String privilege_ctx = (((String)tabDataParam.get("privilege_ctx")).equals(""))?null:((String)tabDataParam.get("privilege_ctx")).trim();
		String facility_id = (((String)tabDataParam.get("facility_id")).equals(""))?null:((String)tabDataParam.get("facility_id")).trim();

		arrChkDup[0] = appl_user_id ;
		arrChkDup[1] = reln_id ;
		arrChkDup[2] = resp_id ;
		arrChkDup[3] = facility_id;

		HashMap temp = null;

		
			boolean duplicate = chkDuplicate(SQL_OR_PRIVILEGE_CTX_DUP,connection,arrChkDup);
 		if(duplicate)
		{
 		  String msg  =	 "CODE_ALREADY_EXISTS";
		  map.put( "message", msg ) ;
          map.put( "flag", "Duplicate") ;
		  map.put( "traceVal", "dup loop records" ) ;
		  connection.rollback();
		  return map ;
		}

		pstmt_base = null;
		pstmt_child = null;
 		pstmt_base = connection.prepareStatement(SQL_OR_PRIVILEGE_CTX_INSERT);
		pstmt_child = connection.prepareStatement(SQL_OR_PRIVILEGE_CTX_EXP_INSERT);

 	    tabDataMultiple = (HashMap)tabDataParam.get("records");
 
		temp = (HashMap ) tabDataMultiple.get(String.valueOf("0"));
		login_by_id = (String)temp.get("login_by_id");
		login_at_ws_no = (String)temp.get("login_at_ws_no");
		login_facility_id = (String)temp.get("login_facility_id");

 		int recCount = tabDataMultiple.size();
 		pstmt_base.setString(1 ,privilege_ctx_id);
 		pstmt_base.setString(2 ,facility_id);
		pstmt_base.setString(3 , appl_user_id);
		pstmt_base.setString(4 , reln_id);
		pstmt_base.setString(5 , resp_id);
 		pstmt_base.setString(6,login_by_id);
		pstmt_base.setString(7,login_at_ws_no);
		pstmt_base.setString(8,login_facility_id);
		pstmt_base.setString(9,login_by_id);
		pstmt_base.setString(10,login_at_ws_no);
		pstmt_base.setString(11,login_facility_id);

		HashMap tabData=null;
		String grp_exception_id="";
		String privilege_value="";
		String priv_id = "";
		String priv_value="";

		for(int i=0;i<recCount;i++)
		{
 		tabData = (HashMap)tabDataMultiple.get(String.valueOf(i));
 
 		//int noOfRecords = grp_exception_store.size() ;
			login_by_id = (String)tabData.get("login_by_id");
			login_at_ws_no = (String)tabData.get("login_at_ws_no");
			login_facility_id = (String)tabData.get("login_facility_id");

			grp_exception_id="";
			grp_exception_id = (String)tabData.get("grp_exception_id");
			privilege_value = (String)tabData.get("privilege_value") ;
			StrToken_priv_value = new StringTokenizer(privilege_value,",");//added by Kavitha.K 1/12/2005
			privilege_id = (String)tabData.get("privilege_id");
 			StrToken = new StringTokenizer(privilege_id,",");
			priv_id = "";
			priv_value="";

 			while(StrToken.hasMoreTokens())
			{
 				priv_id = StrToken.nextToken();
				if(priv_id != null && !priv_id.equals(""))
				{
					if (StrToken_priv_value.hasMoreTokens())
					{
						priv_value= StrToken_priv_value.nextToken();
					}
 						pstmt_child.setString(1 ,privilege_ctx_id);
						pstmt_child.setString(2 ,grp_exception_id);
						pstmt_child.setString(3 ,priv_id);
						pstmt_child.setString(4 ,priv_value);
						pstmt_child.setString(5 ,login_by_id);
						pstmt_child.setString(6 ,login_at_ws_no);
						pstmt_child.setString(7 ,login_facility_id);
						pstmt_child.setString(8 ,login_by_id);
						pstmt_child.setString(9, login_at_ws_no);
						pstmt_child.setString(10, login_facility_id);
						pstmt_child.addBatch();
				}//end of if
			}//end of while
		}//for
		//int updatedCounts1 ;
			try{
				  pstmt_base.executeUpdate();
				 //updatedCounts1 = pstmt_base.executeUpdate();

			}catch(Exception e){
 
					connection.rollback();

					System.err.println("Exception here : "+ e) ;
					e.printStackTrace();
					return map ;
			}

		int [] updatedCounts = null;
		try{
 				 updatedCounts = pstmt_child.executeBatch();
 		 }catch(Exception e){
					connection.rollback();
					e.printStackTrace();
					traceVal.append(e.getMessage());
					map.put( "traceVal", traceVal.toString() ) ;
		}

	  		updated = false	;
			if((updatedCounts.length > 0)){
				updated= true ;
			}else if((updatedCounts.length == (-3))){
				updated= false ;
			}
 			if (updated){
 						connection.commit();
						map.put( "result", new Boolean( true ) ) ;
						messages.append( "RECORD_MODIFIED" ) ;
			}else{
						connection.rollback();
						messages.append( "Insert Failed" ) ;
			}

		 }catch( Exception e ){
				try {
						connection.rollback();
						e.printStackTrace();
				} catch ( Exception ee ) {
						messages.append(ee.getMessage() ) ;
				}

				messages.append( e.getMessage() ) ;
	 			e.printStackTrace() ;
    		  } finally{
	            	try {
						 closeResultSet( rs);
						 closeStatement( pstmt_base ) ;
						 closeStatement( pstmt_child ) ;
						 closeStatement( pstmt_seq ) ;
						 closeStatement( pstmt_delete ) ;
						 closeStatement( pstmt_temp ) ;
						 closeConnection( connection ,pt);

        			} catch ( Exception fe ) {
		     			System.err.println( fe.getMessage() ) ;
					   	fe.printStackTrace() ;
			        }
	    	    }

 		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVal.toString() ) ;

	return map ;
}
/*******************this method give range of duplicates******************/
private boolean chkDuplicate(String sql,Connection con , String arr[]) throws Exception{
	StringBuffer messages = new StringBuffer() ;
	StringBuffer traceVal = new StringBuffer() ;
	PreparedStatement pstmt = con.prepareStatement(sql);
	ResultSet rs	         = null ;
try{
		boolean dupFlag = false ;
		int size				= arr.length ;
		for(int i =0 ; i < size ; i++){
			pstmt.setString(i+1,arr[i]);
		}
		rs = pstmt.executeQuery();

		int count = 0;

		if(rs.next())
		{
			count = rs.getInt(1);
		}

		if(count > 0)
		dupFlag = true ;
		return dupFlag;
		}catch(Exception e){
				traceVal.append(e);
				messages.append(e.getMessage());
				throw e;
	 }
	 finally{
		 try{
			closeResultSet( rs);
			closeStatement( pstmt ) ;
		 }catch(Exception ee){ee.printStackTrace();}
	 }

}//End of dulicate chk

/**
* @ejb.interface-method
*	 view-type="both"
*/
public HashMap delete( HashMap tabDataParam, HashMap sqlMap ) 

{
		//String login_by_id = "";
	//	String login_at_ws_no = "";
		//String login_facility_id = "";
		StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;
		//String privilege_id = "";
		Connection connection = null ;
		PreparedStatement pstmt_child = null ;
		PreparedStatement pstmt_delete = null ;
		ResultSet rs =null;
 
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "modify" ) ;

	//	boolean flag = true ;

		//HashMap tabDataMultiple = null ;
		Properties pt = null ;
 	try {
		 pt = (Properties)tabDataParam.get( "properties" ) ;
		 

		String privilege_ctx_id = (String)tabDataParam.get("privilege_ctx_id") ;
		
 
String SQL_OR_PRIVILEGE_CTX_EXP_DELETE =(String)sqlMap.get("SQL_OR_PRIVILEGE_CTX_EXP_DELETE");

 		connection = getConnection(pt) ;
		pstmt_delete = connection.prepareStatement(SQL_OR_PRIVILEGE_CTX_EXP_DELETE);
 
		pstmt_delete.setString(1,privilege_ctx_id);

		int res_del  = pstmt_delete.executeUpdate();

		if(res_del == 0){
 		connection.rollback();
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", "Delete Failed in Child Table While Updating") ;
		return map ;
		}

		boolean updated = false	;
		if( res_del >0)
			updated= true ;
		else if( res_del <= 0){
			updated= false ;
		}

		if (updated){
 			connection.commit();
			map.put( "result", new Boolean( true ) ) ;
			messages.append( "RECORD_DELETED" ) ;
			}else{
				connection.rollback();
				messages.append( "Delete Failed" ) ;
			}
	}catch( Exception e ){
				try {
						connection.rollback();
						e.printStackTrace();
				} catch ( Exception ee ) {
						messages.append(ee.getMessage() ) ;
				}

				messages.append( e.getMessage() ) ;
	 			e.printStackTrace() ;
    		  } finally{
	            	try {
						 closeResultSet( rs);
						 closeStatement( pstmt_child ) ;
						 closeStatement( pstmt_delete ) ;
						 closeConnection( connection ,pt);
        			} catch ( Exception fe ) {
		     			System.err.println( fe.getMessage() ) ;
					   	fe.printStackTrace() ;
			        }
	    	    }

			map.put( "message", messages.toString() ) ;
			map.put( "traceVal", traceVal.toString() ) ;
			return map ;

	}
}//End of class


