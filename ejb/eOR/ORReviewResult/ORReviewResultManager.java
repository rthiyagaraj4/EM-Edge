/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        Description
--------------------------------------------------------------------------------------------------------
?             	100            		?           created
18/07/2012     	IN034064            Chowminya 	Incident No: IN034064 - <Add Notification Alert in summary - include Forward> 
-----------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
28/07/2014		IN053158		Karthi L											Not Able To Complete Review Results Under Notification Alert		
--------------------------------------------------------------------------------------------------------------
*/
package eOR.ORReviewResult;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;

import javax.ejb.* ;
import javax.transaction.* ;

import eOR.Common.* ;

/**
*
* @ejb.bean
*	name="ORReviewResult"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORReviewResult"
*	local-jndi-name="ORReviewResult"
*	impl-class-name="eOR.ORReviewResult.ORReviewResultManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORReviewResult.ORReviewResultLocal"
*	remote-class="eOR.ORReviewResult.ORReviewResultRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORReviewResult.ORReviewResultLocalHome"
*	remote-class="eOR.ORReviewResult.ORReviewResultHome"
*	generate= "local,remote"
*
*
*/

public class ORReviewResultManager extends OrEJBSessionAdapter {
    //SessionContext context ;
	PreparedStatement pstmt = null ;

	StringBuffer traceVals = new StringBuffer();

	/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap insert( HashMap tabData, HashMap sqlMap ) {

		Connection connection = null ;
		StringBuffer messages = new StringBuffer() ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;

		try {
			connection = getConnection((Properties)tabData.get( "properties" ) ) ;
			connection.setAutoCommit( false ) ;
			map = updateValues(connection, tabData, sqlMap);

		 } catch( Exception e ) {
			System.out.println("Exception >>>>>" + e);
			traceVals.append("Exception if any -- "+e);

			try {
				connection.rollback() ;
			} catch ( Exception ee ) {
				messages.append( ee.getMessage() ) ;
			}

			messages.append( e.getMessage() ) ;
			System.err.println(e.getMessage() );
			e.printStackTrace() ;
		} finally {
			try {
				closeStatement( pstmt ) ;
				if(connection != null) {
					closeConnection(connection,(Properties)tabData.get( "properties" ));
					connection = null ;
				}
			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}

	//	map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;
	}

	public HashMap updateValues(Connection connection, HashMap tabData, HashMap sqlMap){
		//System.out.println("====BEGIN *>");
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt1 	= null;
		PreparedStatement pstmt2	= null;	// added for IN053158
		CallableStatement cstmt     = null;
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;

		int count =0;
		//int cnt=0;

		count = Integer.parseInt((String)tabData.get("totalCount"));
		String pract_id 	= (String)tabData.get("pract_id");
		String login_by_id	= (String)tabData.get("login_by_id");
		String[] updt_vals;
		String notifyDeleteSql = "DELETE FROM CA_NOTIFY_REVIEW_PEND_LOG WHERE hist_rec_type=(?) AND accession_num = (?) AND pract_id=(?)";
		int result = 0;
		try{
				pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_RESULT_REVIEW_DELETE") ) ;
				pstmt1 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_RESULT_REVIEW_INSERT") ) ;
				cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_RESULT_REVIEW_REVIEWED_PRACT") +" }");
				pstmt2 = connection.prepareStatement( notifyDeleteSql ) ;	// added for IN053158
			for(int i=0; i<count; i++){

				updt_vals = (String[])tabData.get("review_data"+i);

				pstmt.setString( 1, updt_vals[0] ) ;
				pstmt.setString( 2, updt_vals[3] ) ;
				pstmt.setString( 3, pract_id );

				result = pstmt.executeUpdate();
				// added for IN053158 - Start
				pstmt2.setString( 1, updt_vals[0] ) ;
				pstmt2.setString( 2, updt_vals[3] ) ;
				pstmt2.setString( 3, pract_id );

				result = pstmt2.executeUpdate();
				
				// added for IN053158 - End
				//pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_RESULT_REVIEW_INSERT") ) ;

				pstmt1.setString( 1, pract_id ) ;
				pstmt1.setString( 2, updt_vals[0] ) ;
				pstmt1.setString( 3, updt_vals[1] ) ;
				pstmt1.setString( 4, updt_vals[3] ) ;
				pstmt1.setString( 5, updt_vals[2] ) ;
				pstmt1.setString( 6, updt_vals[5] ) ;
				pstmt1.setString( 7, updt_vals[4] ) ;
				pstmt1.setString( 8, login_by_id ) ;
				pstmt1.setString( 9, login_by_id ) ;
				pstmt1.setString( 10, updt_vals[6] ) ;
				pstmt1.setString( 11, pract_id ) ;

				result = pstmt1.executeUpdate();

				if (!updt_vals[6].equals("")) {
				    //cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_RESULT_REVIEW_REVIEWED_PRACT") +" }");
				    cstmt.setString(1,pract_id);
				    cstmt.setString(2,updt_vals[0]);
				    cstmt.setString(3,updt_vals[1]);
				    cstmt.setString(4,updt_vals[3]);
				    cstmt.setString(5,updt_vals[2]);
				    traceVals.append("in procedure:before:");
				    cstmt.execute();
				    traceVals.append("in procedure:after:");
				}
			}



			if ( result< 1 ) {
				connection.rollback();
				map.put( "message", "Operation failure ..." ) ;

			} else  {
				connection.commit() ;
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", "Operation Completed Successfully..." ) ;
				messages.append( "RECORD_MODIFIED" ) ;
				//messages.append( "Operation Completed Successfully..." ) ;
			}
		}catch(Exception e){
            try {
                connection.rollback();
			    System.out.println("catch here in EJB class >>>>>"+e);
			} catch (Exception ee) {
			    System.out.println(ee.getMessage());
			}

		}
		finally {
			try{
			    closeStatement( pstmt ) ;
				closeStatement( pstmt1 ) ;
			    closeStatement( cstmt ) ;
			    closeStatement( pstmt2 ) ; // added for IN053158
			}catch(Exception ee){
				System.out.println(ee.getMessage());
			}
		}
		map.put( "message", messages.toString() ) ;

		return map;
	}

	/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap modify( HashMap tabData, HashMap sqlMap ) {
		//System.out.println("####in modify() of ejb,tabData="+tabData);
        HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;

		StringBuffer messages = new StringBuffer() ;
		Connection connection = null ;
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt1 	= null;
		PreparedStatement pstmt0 	= null;
		PreparedStatement dupchk_pstmt 	= null;
		ResultSet dupchk_rs 	= null;
		ResultSet flg_rs  = null;
		int count1 = 0;
		String acc_num  = null;



		try {
			connection = getConnection((Properties)tabData.get( "properties" ) ) ;
			connection.setAutoCommit( false ) ;

            int result = 0;
           

			ArrayList forwardPract_id = (ArrayList)tabData.get("forwardPract_id");
    		ArrayList forwardPractHash 	= (ArrayList)tabData.get("forwardPractHash");
    		String login_by_id	= (String)tabData.get("login_by_id");
    		String practioner_id	= (String)tabData.get("pract_id");
    		//map = updateValues(connection, tabData, sqlMap);

    		pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_RESULT_REVIEW_INSERT_FORWARD_PRACT") ) ;
			pstmt0 = connection.prepareStatement( "Select COUNT (*) count From CA_NOTIFY_REVIEW_PEND_LOG where accession_num=?" ) ; //--[IN034064] 
			pstmt1 = connection.prepareStatement( "insert into CA_NOTIFY_REVIEW_PEND_LOG ( pract_id,hist_rec_type,contr_sys_id,accession_num,event_code,create_date_time,review_type,added_by_id,added_date,modified_by_id,modified_date,requested_by_pract_id,normalcy_ind) values (?,?,?,?,?,sysdate,?,?,sysdate,?,sysdate,?,?)" ) ; //--[IN034064] 
    		dupchk_pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_RESULT_REVIEW_INSERT_FORWARD_PRACT_DUPCHK") ) ;

            for (int i = 0; i < forwardPract_id.size();i++) {
                String pract_id = (String)forwardPract_id.get(i);
                for (int j = 0; j < forwardPractHash.size();j++) {
					//try{
                    HashMap record  = (HashMap)forwardPractHash.get(j);
					
					dupchk_pstmt.setString(1,pract_id);                    
                    dupchk_pstmt.setString(2,(String)record.get("hist_rec_type"));                    
                    dupchk_pstmt.setString(3,(String)record.get("contr_sys_id"));                    
                    dupchk_pstmt.setString(4,(String)record.get("accession_num"));                    
                    dupchk_pstmt.setString(5,(String)record.get("event_code"));
					dupchk_rs = dupchk_pstmt.executeQuery();									
					int count=0;
					if(dupchk_rs!=null && dupchk_rs.next()){
					count=dupchk_rs.getInt("count");
					} 
					closeResultSet( dupchk_rs ) ;
				//System.out.println("###count="+count);
					if(count<1)
					{
						
                    pstmt.setString(1,pract_id);
                    traceVals.append("pract_id -- "+pract_id);
                    pstmt.setString(2,(String)record.get("hist_rec_type"));
                    traceVals.append("hist_rec_type -- "+(String)record.get("hist_rec_type"));
                    pstmt.setString(3,(String)record.get("contr_sys_id"));
                    traceVals.append("contr_sys_id -- "+(String)record.get("contr_sys_id"));
                    pstmt.setString(4,(String)record.get("accession_num"));
                    traceVals.append("accession_num -- "+(String)record.get("accession_num"));
                    pstmt.setString(5,(String)record.get("event_code"));
                    traceVals.append("event_code -- "+(String)record.get("event_code"));
                    pstmt.setString(6,(String)record.get("review_type"));
                    traceVals.append("review_type -- "+(String)record.get("review_type"));
                    pstmt.setString(7,login_by_id);
                    traceVals.append("login_by_id -- "+login_by_id);
                    pstmt.setString(8,login_by_id);
                    pstmt.setString(9,practioner_id);    //REQUESTED_BY_PRACT_ID
                    pstmt.setString(10,(String)record.get("normalcy_ind"));    //normalcy_ind
					//--[IN034064] 
					pstmt1.setString(1,pract_id);
                    traceVals.append("pract_id -- "+pract_id);
                    pstmt1.setString(2,(String)record.get("hist_rec_type"));
                    traceVals.append("hist_rec_type -- "+(String)record.get("hist_rec_type"));
                    pstmt1.setString(3,(String)record.get("contr_sys_id"));
                    traceVals.append("contr_sys_id -- "+(String)record.get("contr_sys_id"));
                    pstmt1.setString(4,(String)record.get("accession_num"));
                    traceVals.append("accession_num -- "+(String)record.get("accession_num"));
                    pstmt1.setString(5,(String)record.get("event_code"));
                    traceVals.append("event_code -- "+(String)record.get("event_code"));
                    pstmt1.setString(6,(String)record.get("review_type"));
                    traceVals.append("review_type -- "+(String)record.get("review_type"));
                    pstmt1.setString(7,login_by_id);
                    traceVals.append("login_by_id -- "+login_by_id);
                    pstmt1.setString(8,login_by_id);
                    pstmt1.setString(9,practioner_id);    //REQUESTED_BY_PRACT_ID
                    pstmt1.setString(10,(String)record.get("normalcy_ind"));    //normalcy_ind
					
					//--[IN034064] - Added logic to find if its notification/result review
					acc_num = (String)record.get("accession_num") ;
					pstmt0.setString(1,acc_num);  
					flg_rs = pstmt0.executeQuery();
					
					if(flg_rs!=null && flg_rs.next())
					{
					count1=flg_rs.getInt("count");
					} 

					closeResultSet( flg_rs ) ;		
					if(count1<1) //--[IN034064]
					{
						result = pstmt.executeUpdate();
					}
					else
					{
						result = pstmt1.executeUpdate();
					}
                    traceVals.append("result -- "+result);
					}else{
						//System.out.println("####count >1");	
						traceVals.append("====ROLLBACK");
						map.put( "result", new Boolean( false ) ) ;	
						connection.rollback();
						map.put( "message", "Record already exists" ) ;
						messages.append( "RECORD_ALREADY_EXISTS" ) ;
						map.put( "message", messages.toString() ) ;
						map.put( "traceVal", traceVals.toString() ) ;
						//result=0;
						return map;
					} 
					/*}catch(Exception ex){System.err.println("exception222222222="+ex);
					ex.printStackTrace();}*/
                }
            }
			//System.out.println("after loop result="+result);
            if ( result< 1 ) {
				connection.rollback();
				map.put( "message", "Operation failure ..." ) ;

			} else  {
				connection.commit() ;
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", "Operation Completed Successfully..." ) ;
				messages.append( "RECORD_MODIFIED" ) ;

				//messages.append( "Operation Completed Successfully..." ) ;
			}

		 } catch( Exception e ) {
			System.out.println("Exception >>>>>" + e);
			traceVals.append("Exception if any -- "+e);

			try {
				connection.rollback() ;
			} catch ( Exception ee ) {
				messages.append( ee.getMessage() ) ;
			}

			messages.append( e.getMessage() ) ;
			System.err.println(e.getMessage() );
			e.printStackTrace() ;
		} finally {
			try {
					closeResultSet( dupchk_rs ) ;
					closeStatement( dupchk_pstmt ) ;
					closeStatement( pstmt ) ;
					closeStatement( pstmt0 ) ;
					closeStatement( pstmt1 ) ;
					if(connection != null) {
						closeConnection(connection,(Properties)tabData.get( "properties" ));
						connection = null ;
					}
			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}

		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVals.toString() ) ;

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
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;
	}
}
