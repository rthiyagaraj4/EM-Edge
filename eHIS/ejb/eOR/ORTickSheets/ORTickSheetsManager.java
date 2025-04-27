/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------
07/06/2020	IN072524	Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
-------------------------------------------------------------------------------------------------------------------------------
*/
package eOR.ORTickSheets ;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import eOR.Common.* ;
import javax.ejb.* ;
import javax.transaction.* ;

/**
*
* @ejb.bean
*	name="ORTickSheets"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORTickSheets"
*	local-jndi-name="ORTickSheets"
*	impl-class-name="eOR.ORTickSheets.ORTickSheetsManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORTickSheets.ORTickSheetsLocal"
*	remote-class="eOR.ORTickSheets.ORTickSheetsRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORTickSheets.ORTickSheetsLocalHome"
*	remote-class="eOR.ORTickSheets.ORTickSheetsHome"
*	generate= "local,remote"
*
*
*/


public class ORTickSheetsManager extends OrEJBSessionAdapter {

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap insert(HashMap tabDataParam , HashMap sqlMap ) {

		Connection connection = null ;
		PreparedStatement pstmt = null ;

	 	StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "insert" ) ;
		//boolean flag = true ;

		HashMap tabDataMultiple = (HashMap)tabDataParam.get("records");
		Properties pt = (Properties)tabDataParam.get( "properties" ) ;
		String SQL_OR_TICK_SHEETS_INSERT				= (String) sqlMap.get("SQL_OR_TICK_SHEETS_INSERT");
		String SQL_OR_TICK_SHEETS_DUPLICATE_CHK_MULIPLE = (String) sqlMap.get("SQL_OR_TICK_SHEETS_DUPLICATE_CHK_MULIPLE");
		String SQL_OR_TICK_SHEETS_DUPLICATE_SEQ_NO_CHK = (String) sqlMap.get("SQL_OR_TICK_SHEETS_DUPLICATE_SEQ_NO_CHK");

	try {
		 connection = getConnection(pt) ;
		 int noOfRecords = tabDataMultiple.size() ;

		 String  sqlParam1 = " "; //Paramters passed for duplicate chking
		 String  sqlParam2 = " "; //Paramters passed for duplicate chking
		 String  sqlParam3 = " "; //Paramters passed for duplicate chking

		for(int s=1 ; s <= noOfRecords ; s++){
			HashMap temp = (HashMap)tabDataMultiple.get(String.valueOf(s));
			
			sqlParam1 = (String)temp.get("order_category");
			sqlParam2 = sqlParam2 + "'" + (String)temp.get("tick_sheet_id") + "',";
			sqlParam3 = sqlParam3 + "'" + (String)temp.get("seq_no") + "',";
			}

		int indx = sqlParam2.lastIndexOf(",") ;
		int indx1 = sqlParam3.lastIndexOf(",");
		sqlParam2 = sqlParam2.substring(0,indx);//to remove last ',' char
		sqlParam3 = sqlParam3.substring(0,indx1);//to remove last ',' char

		//int result=0;

		String arrChkDup[]  =  new String[2] ;
		//arrChkDup[0] = sqlParam1 ;
		arrChkDup[0] = sqlParam2 ;

		String arrChkDup1[] = new String[2] ;
		arrChkDup1[0] = sqlParam1;
		arrChkDup1[1] = sqlParam3;

		String duplicates[] = giveDuplicateValues(SQL_OR_TICK_SHEETS_DUPLICATE_CHK_MULIPLE,connection,arrChkDup);
		String duplicates1[] = giveDuplicateValues1(SQL_OR_TICK_SHEETS_DUPLICATE_SEQ_NO_CHK,connection,arrChkDup1);
		if(duplicates != null )
		{
		  String msg  =	 "";
		  int len = duplicates.length ;

		  while(len > 0)
			  msg = msg + "," + duplicates[--len] ;

		  int t= msg.indexOf(",");

		  msg    = msg.substring(t+1) ;
		  messages.append(msg);
		  map.put( "message", "CODE_ALREADY_EXISTS" ) ;
  		  map.put( "invalidCode", msg  ) ;
          map.put( "flag", "Duplicate") ;
		  map.put( "traceVal", "dup loop records" ) ;
		  connection.rollback();
		  return map ;
		}
		if(duplicates1 != null )
		{
			
		  String msg  =	 "";
		  int len = duplicates1.length ;
		
		  while(len > 0)
			  msg = msg + ":" + duplicates1[--len] + "s" ;
			
		  int t= msg.indexOf(":");
		  msg    = msg.substring(t+1) ;
		  messages.append(msg);
		  map.put( "message", "CODE_ALREADY_EXISTS" ) ;
  		  map.put( "invalidCode", msg  ) ;
          map.put( "flag", "Duplicate") ;
		  map.put( "traceVal", "dup loop records" ) ;
		  connection.rollback();
		  return map ;
		}
		/*Batch insertion*/
		pstmt = connection.prepareStatement(SQL_OR_TICK_SHEETS_INSERT);

		for(int k=1 ; k<= noOfRecords ; k++){

				HashMap tabData  = (HashMap)tabDataMultiple.get(String.valueOf(k));
				traceVal.append(tabData.toString());
				pstmt.setString(1 ,(String)tabData.get("order_category"));
				pstmt.setString(2 ,(String)tabData.get("tick_sheet_id"));
				pstmt.setString(3 ,(String)tabData.get("tick_sheet_desc"));
				pstmt.setString(4 ,(String)tabData.get("seq_no"));
				pstmt.setString(5 ,(String)tabData.get("indexed_yn"));
				pstmt.setString(6 ,(String)tabData.get("eff_status"));
				pstmt.setString(7 ,(String)tabData.get("fpp_yn"));//IN072524
				pstmt.setString(8 ,(String)tabData.get("added_by_id"));//IN072524
				pstmt.setString(9 ,(String)tabData.get("added_at_ws_no"));//IN072524
				pstmt.setString(10 ,(String)tabData.get("added_facility_id"));//IN072524
				pstmt.setString(11 ,(String)tabData.get("modified_by_id"));//IN072524
				pstmt.setString(12,(String)tabData.get("modified_at_ws_no"));//IN072524
				pstmt.setString(13,(String)tabData.get("modified_facility_id"));//IN072524
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
				System.err.println(e.getMessage() );
				e.printStackTrace() ;
    		  } finally{
	            	try {
	            		closeStatement(pstmt);
						 closeConnection( connection ,pt);

        			} catch ( Exception fe ) {
		     			System.err.println( fe.getMessage() ) ;
					   	fe.printStackTrace() ;
			        }
	    	    }

			map.put( "message", messages.toString() ) ;
			return map ;

  }//End of Insert Method

/****************************************************************************/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify( HashMap tabDataParam, HashMap sqlMap ) {

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs	         = null ;
		String Seq_No	= "";

		StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "update" ) ;
		connection  = null ;
		Properties pt =	(Properties)tabDataParam.get( "properties" ) ;
		String SQL_OR_TICK_SHEETS_UPDATE = (String) sqlMap.get("SQL_OR_TICK_SHEETS_UPDATE");
		String SQL_OR_TICK_SHEETS_DUPLICATE_UPDATE_SEQ_NO_CHK = (String) sqlMap.get("SQL_OR_TICK_SHEETS_DUPLICATE_UPDATE_SEQ_NO_CHK");
		String SQL_OR_TICK_SHEETS_DUPLICATE_UPDATE_SEQ_NO_NULL_CHK=(String) sqlMap.get("SQL_OR_TICK_SHEETS_DUPLICATE_UPDATE_SEQ_NO_NULL_CHK");
		try
		{
			 
			 connection = getConnection(pt) ;
			 HashMap tabData = (HashMap)tabDataParam.get("records");
			 pstmt=connection.prepareStatement(SQL_OR_TICK_SHEETS_DUPLICATE_UPDATE_SEQ_NO_NULL_CHK);
			 pstmt.setString(1 ,(String)tabData.get("order_category"));
			 pstmt.setString(2 ,(String)tabData.get("tick_sheet_id"));
			 rs=pstmt.executeQuery();
			 while(rs.next())			
			 Seq_No=rs.getString("seq_no");
			 
			 closeResultSet(rs);
			 closeStatement(pstmt);
			 if (Seq_No==null || Seq_No.equals(""))
			 {
			 pstmt=connection.prepareStatement(SQL_OR_TICK_SHEETS_DUPLICATE_UPDATE_SEQ_NO_CHK);
			 pstmt.setString(1 ,(String)tabData.get("order_category"));
			 pstmt.setString(2 ,(String)tabData.get("seq_no"));
			 int updated1=0;

			 rs=pstmt.executeQuery();
			 while(rs.next()){
				 updated1 = rs.getInt("count_seq_no");
			 }

			 closeResultSet(rs);
			 closeStatement(pstmt);
			 
			 if (updated1 != 0)
			{
				String msg  =	 "";
				msg = msg + ":" + ((String)tabData.get("seq_no")) ;				
				messages.append(msg);
				map.put( "message", "CODE_ALREADY_EXISTS" ) ;
  				map.put( "invalidCode", msg  ) ;
				map.put( "flag", "Duplicate") ;
				map.put( "traceVal", "dup loop records" ) ;
				connection.rollback();
				return map ;
							
			}
				 else
			 {			
				pstmt = connection.prepareStatement(SQL_OR_TICK_SHEETS_UPDATE);
				pstmt.setString(1 ,(String)tabData.get("tick_sheet_desc"));
				pstmt.setString(2 ,(String)tabData.get("seq_no"));
				pstmt.setString(3 ,(String)tabData.get("indexed_yn"));
				pstmt.setString(4 ,(String)tabData.get("eff_status"));
				pstmt.setString(5,(String)tabData.get("modified_by_id"));
				pstmt.setString(6 ,(String)tabData.get("modified_at_ws_no"));
				pstmt.setString(7 ,(String)tabData.get("modified_facility_id"));
				pstmt.setString(8 ,(String)tabData.get("tick_sheet_id"));
				pstmt.setString(9 ,(String)tabData.get("order_category"));
				int updated = pstmt.executeUpdate();

				if (updated != 0){
						connection.commit();
						map.put( "result", new Boolean( true ) ) ;
						messages.append( "RECORD_MODIFIED" ) ;
				}else{
						connection.rollback();
						messages.append( "Update Failed" ) ;

				}
				closeStatement(pstmt);
				
				map.put( "traceVal", traceVal.toString() ) ;
				map.put( "message", messages.toString() ) ;
				return map ;
				}
			 }//end of seq_no check for null in the table
			else
				{			
				pstmt = connection.prepareStatement(SQL_OR_TICK_SHEETS_UPDATE);
				pstmt.setString(1 ,(String)tabData.get("tick_sheet_desc"));
				pstmt.setString(2 ,(String)tabData.get("seq_no"));
				pstmt.setString(3 ,(String)tabData.get("indexed_yn"));
				pstmt.setString(4 ,(String)tabData.get("eff_status"));
				pstmt.setString(5,(String)tabData.get("modified_by_id"));
				pstmt.setString(6 ,(String)tabData.get("modified_at_ws_no"));
				pstmt.setString(7 ,(String)tabData.get("modified_facility_id"));
				pstmt.setString(8 ,(String)tabData.get("tick_sheet_id"));
				pstmt.setString(9 ,(String)tabData.get("order_category"));
				int updated = pstmt.executeUpdate();

				if (updated != 0){
						connection.commit();
						map.put( "result", new Boolean( true ) ) ;
						messages.append( "RECORD_MODIFIED" ) ;
				}else{
						connection.rollback();
						messages.append( "Update Failed" ) ;

				}
				closeStatement(pstmt);
				
				map.put( "traceVal", traceVal.toString() ) ;
				map.put( "message", messages.toString() ) ;
				return map ;
				}
				
		}
			catch( Exception e ){
			try {
				connection.rollback();
				}catch( Exception ee ){				
				messages.append(ee.getMessage() ) ;
				}
				messages.append( e.getMessage() ) ;
				System.err.println(e.getMessage() );
				e.printStackTrace() ;

			} finally{
	         	try {
	         		
					closeResultSet(rs);
					closeStatement(pstmt);
					closeConnection( connection ,pt);
					} 
					catch ( Exception fe ) {
		     			System.err.println( fe.getMessage() ) ;
					   	fe.printStackTrace() ;
			        }
	    	    }
				map.put( "message", messages.toString() ) ;
				return map;
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

/*******************this method give range of duplicates for Tick Sheet ID******************/
	private String[] giveDuplicateValues(String sql,Connection con , String arr[]) throws Exception{
 	//Connection connection = null ;
	PreparedStatement pstmt = null ;
	ResultSet rs	         = null ;
	StringBuffer messages = new StringBuffer() ;
	//StringBuffer traceVal = new StringBuffer() ;
	String duplicate[]	   	= null;

	try
	  {
			/*Directly replacing the ? in the sql string with the values*/
			int t = sql.lastIndexOf("?");
			sql  = sql.substring(0,t) + arr[0].trim() + sql.substring(t+1)  ;


			pstmt = con.prepareStatement(sql.trim(),ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_READ_ONLY);


			int size = arr.length ;
			//String val1 = arr[0] ;
			//pstmt.setString(1,val1.trim());
			size = 0 ;

			rs = pstmt.executeQuery();

			//while (rs.next())
			//++size;
			if(rs!=null) {
				rs.last(); //move to the last
				size = rs.getRow();
			}

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
	 } finally {
	 	try {
	 		closeResultSet(rs);
	 		closeStatement(pstmt);
	 	} catch (Exception ee) {ee.printStackTrace();}
	 }

	return duplicate;
}//End of dulicate chk
/*******************this method gives range of duplicates for Sequence No******************/
	private String[] giveDuplicateValues1(String sql,Connection con , String arr[]) throws Exception{
 	//Connection connection = null ;
	PreparedStatement pstmt = null ;
	ResultSet rs	         = null ;
	StringBuffer messages = new StringBuffer() ;
	//StringBuffer traceVal = new StringBuffer() ;
	String duplicate[]	   	= null;

	try
	  {
			/*Directly replacing the ? in the sql string with the values*/
			int t = sql.lastIndexOf("?");
			sql  = sql.substring(0,t) + arr[1].trim() + sql.substring(t+1)  ;


			pstmt = con.prepareStatement(sql.trim(),ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_READ_ONLY);


			int size = arr.length ;
			String val1 = arr[0] ;
			pstmt.setString(1,val1.trim());
			size = 0 ;

			rs = pstmt.executeQuery();

			//while (rs.next())
			//++size;
			if(rs!=null) {
				rs.last(); //move to the last
				size = rs.getRow();
			}

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
	 } finally {
	 	try {
	 		closeResultSet(rs);
	 		closeStatement(pstmt);
	 	} catch (Exception ee) {ee.printStackTrace();}
	 }

	return duplicate;
}//End of dulicate chk

}//End of class

