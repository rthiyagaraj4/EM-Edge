/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.ORCatalogBySection ;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import eOR.Common.* ;
import javax.ejb.* ;
import javax.transaction.* ;

/**
*
* @ejb.bean
*	name="ORCatalogBySection"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORCatalogBySection"
*	local-jndi-name="ORCatalogBySection"
*	impl-class-name="eOR.ORCatalogBySection.ORCatalogBySectionManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORCatalogBySection.ORCatalogBySectionLocal"
*	remote-class="eOR.ORCatalogBySection.ORCatalogBySectionRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORCatalogBySection.ORCatalogBySectionLocalHome"
*	remote-class="eOR.ORCatalogBySection.ORCatalogBySectionHome"
*	generate= "local,remote"
*
*
*/

public class ORCatalogBySectionManager extends OrEJBSessionAdapter {

/**
* @ejb.interface-method
*	 view-type="both"
*/

	public HashMap insert(HashMap tabDataParam , HashMap sqlMap ) {

		StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "flag" ) ;


		HashMap tabData_p		 =(HashMap)tabDataParam.get("tabData");
		
		Properties  pt      	 =(Properties)tabDataParam.get("properties");

		ArrayList tabDataMultiple=(ArrayList)tabData_p.get("records");
		//System.out.println("####in insert of ejb,tabDataMultiple="+tabDataMultiple);
		String login_by_id		 =(String)tabData_p.get("login_by_id" ) ;
		String login_at_ws_no	 =(String)tabData_p.get("login_at_ws_no" ) ;
		String login_facility_id =(String)tabData_p.get("login_facility_id" ) ;
		 Connection connection   =  null ;
		 PreparedStatement pstmt_I = null ;
 		 PreparedStatement pstmt_U = null ;
 		 PreparedStatement pstmt_D = null ;

	try {

		 connection = getConnection(pt) ;
//	 	 Connection connection = getConnection() ;
		  pstmt_I = null ;
 		  pstmt_U = null ;
 		  pstmt_D = null ;
		 int noOfRecords = tabDataMultiple.size() ;

		String SQL_OR_CATALOGSBYSECTION_INSERT	= (String)sqlMap.get("SQL_OR_CATALOGSBYSECTION_INSERT");
		String SQL_OR_CATALOGSBYSECTION_UPDATE	= (String)sqlMap.get("SQL_OR_CATALOGSBYSECTION_UPDATE");
		String SQL_OR_CATALOGSBYSECTION_DELETE	= (String)sqlMap.get("SQL_OR_CATALOGSBYSECTION_DELETE");

		pstmt_D = connection.prepareStatement(SQL_OR_CATALOGSBYSECTION_DELETE);
		pstmt_U = connection.prepareStatement(SQL_OR_CATALOGSBYSECTION_UPDATE);
		pstmt_I = connection.prepareStatement(SQL_OR_CATALOGSBYSECTION_INSERT);



		int counter_I=0,counter_U=0,counter_D=0;
		traceVal.append("***no of recs ="+noOfRecords);
		HashMap tabData =null;
		String  valid="";
		String  associate_yn="";

		for(int k=0 ; k< noOfRecords ; k++){

		tabData     =(HashMap)tabDataMultiple.get(k);
		valid	    =(String)tabData.get("valid");
		associate_yn=(String)tabData.get("associate_yn");
			traceVal.append("***b4 update=");
		if(valid.trim().equalsIgnoreCase("Y")){
			if(associate_yn.trim().equalsIgnoreCase("Y")){//update
			counter_U++ ;
			pstmt_U.setString(1 ,(String)tabData.get("order_type_sel"));
			pstmt_U.setString(2 ,(String)tabData.get("tick_sheet_seq_num"));
			pstmt_U.setString(3 ,login_by_id);
			pstmt_U.setString(4 ,login_at_ws_no);
			pstmt_U.setString(5 ,login_facility_id);
			pstmt_U.setString(6 ,(String)tabData.get("order_category"));
			pstmt_U.setString(7 ,(String)tabData.get("tick_sheet_id"));
			pstmt_U.setString(8 ,(String)tabData.get("section_code"));
			pstmt_U.setString(9 ,(String)tabData.get("order_catalog_code"));
			pstmt_U.addBatch();
			}else{//delete
			traceVal.append("***begin delete=");
			counter_D++ ;
			pstmt_D.setString(1 ,(String)tabData.get("order_category"));
			pstmt_D.setString(2 ,(String)tabData.get("tick_sheet_id"));
			pstmt_D.setString(3 ,(String)tabData.get("section_code"));
			pstmt_D.setString(4 ,(String)tabData.get("order_catalog_code"));
			pstmt_D.addBatch();
			}
		}
		if(valid.equalsIgnoreCase("N")){
			traceVal.append("***begin insertion=");
			traceVal.append("associate_yn="+(String)tabData.get("associate_yn")) ;
			if(associate_yn.equalsIgnoreCase("Y")){//Insert
			counter_I++;
			traceVal.append("tick_sheet_id="+(String)tabData.get("tick_sheet_id")) ;
			traceVal.append("order_category="+(String)tabData.get("order_category")) ;

			pstmt_I.setString(1 ,(String)tabData.get("order_category"));
			pstmt_I.setString(2 ,(String)tabData.get("tick_sheet_id"));
			pstmt_I.setString(3 ,(String)tabData.get("section_code"));
			pstmt_I.setString(4 ,(String)tabData.get("tick_sheet_seq_num"));
			pstmt_I.setString(5 ,(String)tabData.get("order_catalog_code"));
			pstmt_I.setString(6 ,(String)tabData.get("order_type_sel"));
			pstmt_I.setString(7 ,login_by_id);
			pstmt_I.setString(8 ,login_at_ws_no);
			pstmt_I.setString(9 ,login_facility_id);
			pstmt_I.setString(10,login_by_id);
			pstmt_I.setString(11,login_at_ws_no);
			pstmt_I.setString(12,login_facility_id);
			pstmt_I.addBatch();
		   }
		 }
		traceVal.append("***no of recs ="+k);

	  }//End of For Looping for all records


//System.out.println("####counter_I="+counter_I);
//System.out.println("####counter_U="+counter_U);
//System.out.println("####counter_D="+counter_D);
	  traceVal.append("counter_I="+counter_I) ;

			int [] updatedCounts_I ={};
			int [] updatedCounts_U ={};
			int [] updatedCounts_D ={};

			 if(counter_I > 0)
				 updatedCounts_I = pstmt_I.executeBatch();

	         if(counter_U > 0)
			 		 updatedCounts_U = pstmt_U.executeBatch();

			 if(counter_D > 0)
			 		 updatedCounts_D = pstmt_D.executeBatch();




			boolean updated_I = true ;
			boolean updated_U = true ;
			boolean updated_D = true ;

			if(counter_I > 0){
			 if((updatedCounts_I.length > 0)){
					updated_I= true ;
			 }else if((updatedCounts_I.length == (-3))){
					updated_I= false ;
			 }
			}

			if(counter_U > 0){
			 if((updatedCounts_U.length > 0)){
					updated_U= true ;
		     }else if((updatedCounts_U.length == (-3))){
					updated_U= false ;
			 }
			}

			if(counter_D > 0){
			 if((updatedCounts_D.length > 0)){
					updated_D= true ;
			 }else if((updatedCounts_D.length == (-3))){
					updated_D= false ;
			 }
			}


			if (updated_I && updated_U && updated_D ){
				//System.out.println("###on success");
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append("RECORD_INSERTED") ;
			}else{
				//System.out.println("###on Failure");
				connection.rollback();
				messages.append( "Insert Failed" ) ;
			}

		}catch( Exception e ){
					traceVal.append(e.getMessage());
					map.put( "traceVal", traceVal.toString() ) ;

					try {
						connection.rollback();
						closeConnection( connection,pt );
					} catch ( Exception ee ) {
						messages.append(ee.getMessage() ) ;
						}
				messages.append( e.getMessage() ) ;
				System.err.println(e.getMessage() );
				e.printStackTrace() ;
    		  } finally{
	            	try {
	            		closeStatement(pstmt_I);
	            		closeStatement(pstmt_U);
	            		closeStatement(pstmt_D);
					closeConnection( connection,pt);

					} catch ( Exception fe ) {
		     			System.err.println( fe.getMessage() ) ;
					   	fe.printStackTrace() ;
			        }
	    	    }

			map.put( "message", messages.toString() ) ;
			map.put( "traceVal", traceVal.toString() ) ;
			return map ;


  }//End of Insert Method

/****************************************************************************/

/**
* @ejb.interface-method
*	 view-type="both"
*/

public HashMap modify( HashMap tabDataParam, HashMap sqlMap ) {
	StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;
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


}//End of class

