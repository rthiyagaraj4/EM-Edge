/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//package eOR ;
package eOR.ORPerformLocation;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import eOR.Common.* ;
import javax.ejb.* ;

/**
*
* @ejb.bean
*	name="ORPerformLocation"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORPerformLocation"
*	local-jndi-name="ORPerformLocation"
*	impl-class-name="eOR.ORPerformLocation.ORPerformLocationManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORPerformLocation.ORPerformLocationLocal"
*	remote-class="eOR.ORPerformLocation.ORPerformLocationRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORPerformLocation.ORPerformLocationLocalHome"
*	remote-class="eOR.ORPerformLocation.ORPerformLocationHome"
*	generate= "local,remote"
*
*
*/

public class ORPerformLocationManager extends OrEJBSessionAdapter {

	/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap insert(HashMap tabDataParam , HashMap sqlMap ) {
		//System.out.println( "one :" ) ;
		//System.err.println("TabData Param in EJB of PerformLocn.  @@@@  " + tabDataParam);
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
		String SQL_OR_PERFORM_LOCN_INSERT				= (String) sqlMap.get("SQL_OR_PERFORM_LOCN_INSERT");
		String SQL_OR_PERFORM_LOCN_DUPLICATE_CHK_MULIPLE = (String) sqlMap.get("SQL_OR_PERFORM_LOCN_DUPLICATE_CHK_MULIPLE");
		//System.out.println( "dddddddddddddSQL_OR_PERFORM_LOCN_INSERT :" +SQL_OR_PERFORM_LOCN_INSERT) ;

	try {
		 connection = getConnection(pt) ;
		 int noOfRecords = tabDataMultiple.size();

		 String  sqlParam1 = " "; //Paramters passed for duplicate chking
		 String  sqlParam2 = " "; //Paramters passed for duplicate chking
		 String  sqlParam3 = " "; //Paramters passed for duplicate chking

		for(int s=1 ; s <= noOfRecords ; s++){
			HashMap temp = (HashMap)tabDataMultiple.get(String.valueOf(s));
			sqlParam1 = (String)temp.get("facility_id");
			sqlParam2 = (String)temp.get("locn_type");
//			sqlParam3 += "'" + (String)temp.get("code") + "',";
			sqlParam3 =sqlParam3+ "'" + (String)temp.get("code") + "',";
		}
			//sqlParam3 = sqlParam1 + sqlParam2 +sqlParam3;
			//System.out.println("sqlParam3 >>>>>>>> "+sqlParam3 );

		int indx = sqlParam3.lastIndexOf(",") ;
		sqlParam3 = sqlParam3.substring(0,indx);//to remove last ',' char

		//System.out.println("here sqlParam1 >>>>>> "+sqlParam1 );
		//System.out.println("sqlParam2 >>>>>> "+sqlParam2 );
		//System.out.println("sqlParam3 >>>>>> "+sqlParam3 );

		//int result=0;

		String arrChkDup[]  =  new String[3] ;
		arrChkDup[0] = sqlParam1 ;
		arrChkDup[1] = sqlParam2 ;
		arrChkDup[2] = sqlParam3 ;
			//System.out.println("arrChkDup >>>>>> "+arrChkDup.length );

		String duplicates[] = giveDuplicateValues(SQL_OR_PERFORM_LOCN_DUPLICATE_CHK_MULIPLE,connection,arrChkDup);

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
		  map.put( "message", "CODE_ALREADY_EXISTS" ) ;
  		  map.put( "invalidCode", msg  ) ;
          map.put( "flag", "Duplicate") ;
		  map.put( "traceVal", "dup loop records" ) ;
		  connection.rollback();
		  return map ;
		}

		/*Batch insertion*/
		pstmt = connection.prepareStatement(SQL_OR_PERFORM_LOCN_INSERT);

		for(int k=1 ; k<= noOfRecords ; k++){

				HashMap tabData  = (HashMap)tabDataMultiple.get(String.valueOf(k));
				//System.err.println("TabData in EJB Perform Loc. @@@ " + tabData);
				traceVal.append(tabData.toString());
				pstmt.setString(1 ,(String)tabData.get("facility_id"));
				pstmt.setString(2 ,(String)tabData.get("locn_type"));
				pstmt.setString(3 ,(String)tabData.get("code"));
				pstmt.setString(4 ,(String)tabData.get("long_desc"));
				pstmt.setString(5 ,(String)tabData.get("short_desc"));
				pstmt.setString(6 ,(String)tabData.get("enabled"));
				pstmt.setString(7 ,(String)tabData.get("added_by_id"));
				pstmt.setString(8 ,(String)tabData.get("added_at_ws_no"));
				pstmt.setString(9 ,(String)tabData.get("added_facility_id"));
				pstmt.setString(10 ,(String)tabData.get("modified_by_id"));
				pstmt.setString(11,(String)tabData.get("modified_at_ws_no"));
				pstmt.setString(12,(String)tabData.get("modified_facility_id"));
				pstmt.setString(13,(String)tabData.get("intext"));//Added by Subhash.Y
				pstmt.addBatch();
			}

			int [] updatedCounts ;
			try{
				 updatedCounts = pstmt.executeBatch();
			}catch(Exception e){
					System.err.println("AA");
					connection.rollback();
					System.out.println("Exception here : "+ e) ;
					return map ;
			}


			boolean updated = false	;
			if((updatedCounts.length > 0)){
				updated= true ;
			}else if((updatedCounts.length == (-3))){
				System.err.println("BB");
				updated= false ;
			}

			if (updated){
						connection.commit();
						map.put( "result", new Boolean( true ) ) ;
						messages.append( "RECORD_INSERTED" ) ;
			}else{
						System.err.println("CC");
						connection.rollback();
						messages.append( "Insert Failed" ) ;
			}

		 }catch( Exception e ){
				try {
						System.err.println("DD");
						connection.rollback();
				} catch ( Exception ee ) {
					System.out.println("Exception in outer block : "+ ee) ;
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
//			map.put( "traceVal", traceVal.toString() ) ;
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

		StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;


		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "update" ) ;
		connection  = null ;
		Properties pt =	(Properties)tabDataParam.get( "properties" ) ;
		String SQL_OR_PERFORM_LOCN_UPDATE = (String) sqlMap.get("SQL_OR_PERFORM_LOCN_UPDATE");

		try
		{
			 connection = getConnection(pt) ;
			 HashMap tabData = (HashMap)tabDataParam.get("records");
	         pstmt = connection.prepareStatement(SQL_OR_PERFORM_LOCN_UPDATE);
			 pstmt.setString(1 ,(String)tabData.get("long_desc"));
			 pstmt.setString(2 ,(String)tabData.get("short_desc"));
			 pstmt.setString(3 ,(String)tabData.get("eff_status"));
			 pstmt.setString(4 ,(String)tabData.get("modified_by_id"));
			 pstmt.setString(5 ,(String)tabData.get("modified_at_ws_no"));
			 pstmt.setString(6 ,(String)tabData.get("modified_facility_id"));
			 pstmt.setString(7 ,(String)tabData.get("int_or_ext"));
			 pstmt.setString(8 ,(String)tabData.get("facility_id"));
			 pstmt.setString(9 ,(String)tabData.get("locn_type"));
			 pstmt.setString(10 ,(String)tabData.get("code"));
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
 	//Connection connection = null ;
	PreparedStatement pstmt = null ;
	ResultSet rs	         = null ;

	StringBuffer messages = new StringBuffer() ;
	//StringBuffer traceVal = new StringBuffer() ;
	String duplicate[]	   	= null;
	//System.out.println("dup chk method is here >>>>>>>>>>>>>>>" +sql);
	try
	  {
			/*Directly replacing the ? in the sql string with the values*/
			int t = sql.lastIndexOf("?");
			sql  = sql.substring(0,t) + arr[2].trim() + sql.substring(t+1)  ;


			pstmt = con.prepareStatement(sql.trim(),ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_READ_ONLY);


			int size = arr.length ;
			String val1 = arr[0] ;
			String val2 = arr[1] ;
			pstmt.setString(1,val1.trim());
			pstmt.setString(2,val2.trim());
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
			  System.out.println("Exception duplicate check : "+ e) ;
				messages.append(e.getMessage());
				throw e;
	 } finally{
     	try {
     		 closeResultSet( rs ) ;
			 closeStatement(pstmt);
		} catch (Exception e) {e.printStackTrace();
		}
	}

	return duplicate;
}//End of dulicate chk

}//End of class
