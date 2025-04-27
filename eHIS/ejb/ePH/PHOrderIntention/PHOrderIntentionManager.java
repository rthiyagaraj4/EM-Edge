/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//saved on 08/11/2005
package ePH.PHOrderIntention ;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import javax.ejb.* ;
import javax.transaction.* ;

/**
*
* @ejb.bean
*	name="PHOrderIntention"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORDER_INTENTION_JNDI"
*	local-jndi-name="ORDER_INTENTION_JNDI"
*	impl-class-name="ePH.PHOrderIntention.PHOrderIntentionManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.PHOrderIntention.PHOrderIntentionLocal"
*	remote-class="ePH.PHOrderIntention.PHOrderIntentionRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.PHOrderIntention.PHOrderIntentionLocalHome"
*	remote-class="ePH.PHOrderIntention.PHOrderIntentionHome"
*	generate= "local,remote"
*
*
*/



public class PHOrderIntentionManager extends PhEJBSessionAdapter {
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap insert(HashMap tabDataParam , HashMap sqlMap )  {

		Connection connection = null ;
		PreparedStatement pstmt = null ;

	 	StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;
		HashMap map = new HashMap() ;

		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "insert" ) ;
//		boolean flag = true ;
		Properties pt = (Properties)tabDataParam.get( "properties" ) ;
	try {
		HashMap tabDataMultiple = (HashMap)tabDataParam.get("records");

		String SQL_PH_ORDER_INTENTION_INSERT				= (String) sqlMap.get("SQL_PH_ORDER_INTENTION_INSERT");
		String SQL_PH_ORDER_INTENTION_DUPLICATE_CHK_MULIPLE = (String) sqlMap.get("SQL_PH_ORDER_INTENTION_DUPLICATE_CHK_MULIPLE");

		 connection = getConnection(pt) ;
		 int noOfRecords = tabDataMultiple.size() ;

		 String  sqlParam1 = " "; //Paramters passed for duplicate chking
		 String  sqlParam2 = " "; //Paramters passed for duplicate chking

		for(int s=1 ; s <= noOfRecords ; s++){
			HashMap temp = (HashMap)tabDataMultiple.get(String.valueOf(s));
			sqlParam1 = (String)temp.get("indicator");
			sqlParam2 = sqlParam2 + "'" + (String)temp.get("order_intention_id") + "',";
		}

		int indx = sqlParam2.lastIndexOf(",") ;
		sqlParam2 = sqlParam2.substring(0,indx);//to remove last ',' char

//		int result=0;

		String arrChkDup[]  =  new String[2] ;
		arrChkDup[0] = sqlParam1 ;
		arrChkDup[1] = sqlParam2 ;

		String duplicates[] = giveDuplicateValues(SQL_PH_ORDER_INTENTION_DUPLICATE_CHK_MULIPLE,connection,arrChkDup);
		if(duplicates != null )
		{
//		  String msg  =	 "CODE_ALREADY_EXISTS";
		  String msg  =	 "";
		  int len = duplicates.length ;
//		  String msg =  "@for following ID" ;

		  while(len > 0)
			  msg = msg + "," + duplicates[--len] ;

		  int t= msg.indexOf(",");

		 // msg  = msg.substring(0,t) ;
		  msg    = msg.substring(t+1) ;

		//  msg  = msg.substring(0,t) + ": " + msg.substring(t+1) +" ...." ;
		  messages.append(msg);
		  map.put( "result", new Boolean( false ) ) ;
		  map.put( "message", "CODE_ALREADY_EXISTS" ) ;
  		  map.put( "invalidCode", msg  ) ;
          map.put( "flag", "Duplicate") ;
		  map.put( "traceVal", "dup loop records" ) ;
		  connection.rollback();
		  return map ;
		}

		/*Batch insertion*/
		pstmt = connection.prepareStatement(SQL_PH_ORDER_INTENTION_INSERT);

		for(int k=1 ; k<= noOfRecords ; k++){

				HashMap tabData  = (HashMap)tabDataMultiple.get(String.valueOf(k));
				traceVal.append(tabData.toString());
				pstmt.setString(1 ,(String)tabData.get("order_intention_id"));
				pstmt.setString(2 ,(String)tabData.get("indicator"));
				pstmt.setString(3 ,(String)tabData.get("order_intention_short_desc"));
				pstmt.setString(4 ,(String)tabData.get("order_intention_long_desc"));
				pstmt.setString(5 ,(String)tabData.get("eff_status"));
				pstmt.setString(6 ,(String)tabData.get("added_by_id"));
				pstmt.setString(7 ,(String)tabData.get("added_at_ws_no"));
				pstmt.setString(8 ,(String)tabData.get("added_facility_id"));
				pstmt.setString(9 ,(String)tabData.get("modified_by_id"));
				pstmt.setString(10,(String)tabData.get("modified_at_ws_no"));
				pstmt.setString(11,(String)tabData.get("modified_facility_id"));
				pstmt.addBatch();
			}

			int [] updatedCounts ;
			try{
				 updatedCounts = pstmt.executeBatch();
			}catch(Exception e){

					connection.rollback();
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
						closeStatement( pstmt );
						 closeConnection( connection ,pt);

        			} catch ( Exception fe ) {

					   	fe.printStackTrace() ;
			        }
	    }

			map.put( "message", messages.toString() ) ;
//			map.put( "traceVal", traceVal.toString() ) ;
			return map ;

  }//End of Insert Method

/****************************************************************************/
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify( HashMap tabDataParam, HashMap sqlMap )  {

		Connection connection = null ;
		PreparedStatement pstmt = null ;

		StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;


		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "update" ) ;
		connection  = null ;
		Properties pt =	(Properties)tabDataParam.get( "properties" ) ;
		String SQL_PH_ORDER_INTENTION_UPDATE = (String) sqlMap.get("SQL_PH_ORDER_INTENTION_UPDATE");
		try
		{
			 connection = getConnection(pt) ;
			 HashMap tabData = (HashMap)tabDataParam.get("records");
	         pstmt = connection.prepareStatement(SQL_PH_ORDER_INTENTION_UPDATE);
			 pstmt.setString(1 ,(String)tabData.get("order_intention_long_desc"));
			 pstmt.setString(2 ,(String)tabData.get("order_intention_short_desc"));
			 pstmt.setString(3 ,(String)tabData.get("eff_status"));
			 pstmt.setString(4 ,(String)tabData.get("modified_by_id"));
			 pstmt.setString(5 ,(String)tabData.get("modified_at_ws_no"));
			 pstmt.setString(6 ,(String)tabData.get("modified_facility_id"));
			 pstmt.setString(7 ,((String)tabData.get("order_intention_id")).trim());
			 pstmt.setString(8 ,((String)tabData.get("indicator")).trim());

			 int updated = pstmt.executeUpdate();

		  	 if (updated != 0){
						connection.commit();
						map.put( "result", new Boolean( true ) ) ;
						messages.append( "RECORD_MODIFIED" ) ;
			 }else{
						connection.rollback();
						messages.append( "Update Failed" ) ;

			   }
		}catch( Exception e ){
			
			try {
				connection.rollback();
			}catch( Exception ee ){
				messages.append(ee.getMessage() ) ;
			}

				messages.append( e.getMessage() ) ;
				
				e.printStackTrace() ;
      } finally{
	         	try {
					closeStatement( pstmt );
				 closeConnection( connection ,pt);
					} catch ( Exception fe ) {
		     			
					   	fe.printStackTrace() ;
			        }
	    	    }

	        map.put( "traceVal", traceVal.toString() ) ;
			map.put( "message", messages.toString() ) ;
			return map ;

	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
public HashMap delete( HashMap tabData, HashMap sqlMap ) {

		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;
		map.put( "message", messages.toString() ) ;

		return map ;
	}

/*******************this method give range of duplicates******************/
	private String[] giveDuplicateValues(String sql,Connection con , String arr[]) throws Exception{
// 	Connection connection = null ;
	PreparedStatement pstmt = null ;

	StringBuffer messages = new StringBuffer() ;

	String duplicate[]	   	= null;
	ResultSet rs	         = null ;

	try
	  {
			/*Directly replacing the ? in the sql string with the values*/
			int t = sql.lastIndexOf("?");
			sql  = sql.substring(0,t) + arr[1].trim() + sql.substring(t+1)  ;

			pstmt = con.prepareStatement(sql.trim(),ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);

			int size = arr.length ;
			String val1 = arr[0] ;
			pstmt.setString(1,val1.trim());
			size = 0 ;

			rs = pstmt.executeQuery();

			while (rs.next())
			++size;

			if(size == 0 )
				return null ;

			duplicate = new String[size] ;
			rs.beforeFirst()  ;
			int i =0 ;


			while(rs.next()){

				duplicate[i] = rs.getString(1);
				++i;
			}
		  }catch(Exception e){
			  	
				messages.append(e.getMessage());
				throw e;
	 }
	  finally{
	         	try {
					closeResultSet ( rs );
					  closeStatement( pstmt );
//				      closeConnection( connection ,pt);
					} catch ( Exception fe ) {
		     			
					   	fe.printStackTrace() ;
			        }
	    	    }
	return duplicate;
}//End of dulicate chk

}//End of class


