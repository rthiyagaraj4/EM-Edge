/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH.PHStressFactor ;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import javax.ejb.* ;
import javax.transaction.* ;
//saved on 26/10/2005

/**
*
* @ejb.bean
*	name="PHStressFactor"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PHStressFactor"
*	local-jndi-name="PHStressFactor"
*	impl-class-name="ePH.PHStressFactor.PHStressFactorManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.PHStressFactor.PHStressFactorLocal"
*	remote-class="ePH.PHStressFactor.PHStressFactorRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.PHStressFactor.PHStressFactorLocalHome"
*	remote-class="ePH.PHStressFactor.PHStressFactorHome"
*	generate= "local,remote"
*
*
*/



public class PHStressFactorManager extends PhEJBSessionAdapter {

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap insert(HashMap tabDataParam , HashMap sqlMap )  {

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		PreparedStatement pstmt1 = null ;

	 	StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;
		HashMap map = new HashMap() ;

		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "insert" ) ;

		ResultSet rs	         = null ;
		Properties pt = (Properties)tabDataParam.get( "properties" ) ;
	try {
		HashMap tabDataMultiple = (HashMap)tabDataParam.get("records");

		
		String SQL_PH_STRESS_FACTOR_INSERT = (String) sqlMap.get("SQL_PH_STRESS_FACTOR_INSERT");
		String SQL_PH_STRESS_FACTOR_MAX_COUNT = (String) sqlMap.get("SQL_PH_STRESS_FACTOR_MAX_COUNT");

		 connection = getConnection(pt) ;
		 int noOfRecords = tabDataMultiple.size() ;

		/*Batch insertion*/
		pstmt = connection.prepareStatement(SQL_PH_STRESS_FACTOR_INSERT);

		for(int k=1 ; k<= noOfRecords ; k++){

				pstmt1 = connection.prepareStatement(SQL_PH_STRESS_FACTOR_MAX_COUNT);

				rs =  pstmt1.executeQuery();
				String record_no = "";
				int record_no_int = 0;
				while(rs.next()){
					record_no = rs.getString(1);
				}
				if(rs!=null) closeResultSet(rs);
				if(pstmt1!=null) closeStatement(pstmt1);
				
				if(record_no == null || record_no == ""){
					record_no_int = 1;
				}else{
					record_no_int = Integer.parseInt(record_no);
					record_no_int = record_no_int + k;
				}
				record_no = String.valueOf(record_no_int);

				HashMap tabData  = (HashMap)tabDataMultiple.get(String.valueOf(k));

				pstmt.setString(1 ,record_no);
				pstmt.setString(2 ,(String)tabData.get("stress_related_option"));
				pstmt.setString(3 ,(String)tabData.get("weightage"));
				pstmt.setString(4 ,(String)tabData.get("default_yn"));
				pstmt.setString(5 ,(String)tabData.get("system_defined_yn"));
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
						closeResultSet ( rs );
						 closeStatement ( pstmt );
 						 closeStatement ( pstmt1 );
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
		String SQL_PH_STRESS_FACTOR_UPDATE = (String) sqlMap.get("SQL_PH_STRESS_FACTOR_UPDATE");
		try
		{
			 connection = getConnection(pt) ;
			 HashMap tabData = (HashMap)tabDataParam.get("records");
	         pstmt = connection.prepareStatement(SQL_PH_STRESS_FACTOR_UPDATE);
	         pstmt.setString(1 ,(String)tabData.get("stress_related_option"));
		 	 pstmt.setString(2 ,(String)tabData.get("weightage"));
		 	 pstmt.setString(3 ,(String)tabData.get("default_yn"));
		 	 pstmt.setString(4 ,(String)tabData.get("modified_by_id"));
			 pstmt.setString(5 ,(String)tabData.get("modified_at_ws_no"));
			 pstmt.setString(6 ,(String)tabData.get("modified_facility_id"));
			 pstmt.setString(7 ,((String)tabData.get("srl_no")).trim());

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
					 closeStatement ( pstmt );
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
public HashMap delete( HashMap tabDataParam, HashMap sqlMap ) {
		

		Connection connection = null ;
		PreparedStatement pstmt = null ;

		StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;


		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "delete" ) ;
		connection  = null ;
		Properties pt =	(Properties)tabDataParam.get( "properties" ) ;
		String SQL_PH_STRESS_FACTOR_DELETE = (String) sqlMap.get("SQL_PH_STRESS_FACTOR_DELETE");
		try
		{
			 connection = getConnection(pt) ;
			 HashMap tabData = (HashMap)tabDataParam.get("records");
	         pstmt = connection.prepareStatement(SQL_PH_STRESS_FACTOR_DELETE);

			 pstmt.setString(1 ,((String)tabData.get("srl_no")).trim());

			 int updated = pstmt.executeUpdate();

		  	 if (updated != 0){
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
			}catch( Exception ee ){
				messages.append(ee.getMessage() ) ;
			}

				messages.append( e.getMessage() ) ;
				
				e.printStackTrace() ;
      } finally{
	         	try {
					 closeStatement ( pstmt );
				 closeConnection( connection ,pt);
					} catch ( Exception fe ) {
		     			
					   	fe.printStackTrace() ;
			        }
	    	    }

	        map.put( "traceVal", traceVal.toString() ) ;
			map.put( "message", messages.toString() ) ;
			return map ;
	}



}//End of class


