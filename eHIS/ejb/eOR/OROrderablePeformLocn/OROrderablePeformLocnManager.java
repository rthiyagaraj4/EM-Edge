/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
 * OROrderablePerformingLocationManager.java
 *
 * Created on September 4, 2003, 10:50 AM
 */

package eOR.OROrderablePeformLocn;

import java.rmi.*;
import java.util.*;
import java.sql.*;
import eOR.Common.*;
import javax.ejb.*;
import javax.transaction.*;

/**
*
* @ejb.bean
*	name="OROrderablePeformLocn"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="OROrderablePeformLocn"
*	local-jndi-name="OROrderablePeformLocn"
*	impl-class-name="eOR.OROrderablePeformLocn.OROrderablePeformLocnManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.OROrderablePeformLocn.OROrderablePeformLocnLocal"
*	remote-class="eOR.OROrderablePeformLocn.OROrderablePeformLocnRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.OROrderablePeformLocn.OROrderablePeformLocnLocalHome"
*	remote-class="eOR.OROrderablePeformLocn.OROrderablePeformLocnHome"
*	generate= "local,remote"
*
*
*/

public class OROrderablePeformLocnManager extends OrEJBSessionAdapter {

    /** Method for insert Database Operations
     *@param HashMap tabDataParam insert Parameters
     *@param HashMap sqlMap sql statements
     *@return HashMap results of the insert operations
     */

/**
* @ejb.interface-method
*	 view-type="both"
*/

    public HashMap insert(HashMap tabDataParam,HashMap sqlMap) {
    	//System.out.println("### in insert() of ejb,tabDataParam="+tabDataParam);
        StringBuffer messages       = new StringBuffer();
        StringBuffer traceVal       = new StringBuffer();
        HashMap map                 = new HashMap();

        map.put("result", new Boolean(false));
        map.put("flag","flag");

        HashMap tabData_p           = (HashMap)tabDataParam.get("tabData");
        Properties pt               = (Properties)tabDataParam.get("properties");

        ArrayList tabDataMultiple   = (ArrayList)tabData_p.get("records");
		//System.out.println("#### in insert() of ejb,tabData_p="+tabData_p);
        String login_by_id          = (String)tabData_p.get("login_by_id");
        String login_at_ws_no       = (String)tabData_p.get("login_at_ws_no");
        String login_facility_id    = (String)tabData_p.get("login_facility_id");
       //*** String all			= (String)tabData_p.get("deleteall");

        Connection connection       = null;

        PreparedStatement pstmt_default_chk  = null;
		ResultSet rs_default_chk		=null;

        PreparedStatement pstmt_I   = null;
        //***PreparedStatement pstmt_U   = null;
		//***PreparedStatement pstmt_D   = null;
        PreparedStatement pstmt_AD  = null;
        //***PreparedStatement pstmt_AU	= null;
		

        try {
            connection = getConnection(pt);

            pstmt_default_chk	= null ;
            rs_default_chk	= null ;
            pstmt_I		= null ;
 		  	//***pstmt_U 	= null ;
 		  	//***pstmt_D 	= null ;
 		  	pstmt_AD 	= null ;
 		  	//***pstmt_AU 	= null;
		 	int noOfRecords = tabDataMultiple.size() ;

		 	String SQL_OR_ORDERABLES_BY_PERFORM_LOCN_INSERT = (String)sqlMap.get("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_INSERT");
		 	//***String SQL_OR_ORDERABLES_BY_PERFORM_LOCN_UPDATE = (String)sqlMap.get("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_UPDATE");
		 	//***String SQL_OR_ORDERABLES_BY_PERFORM_LOCN_DELETE = (String)sqlMap.get("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_DELETE");
		 	String SQL_OR_ORDERABLES_BY_PERFORM_LOCN_DELETE_ALL = (String)sqlMap.get("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_DELETE_ALL");

			String SQL_OR_ORDERABLES_BY_PERFORM_LOCN_DEFAULT_YN_CHECK = (String)sqlMap.get("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_DEFAULT_YN_CHECK");

			pstmt_AD = connection.prepareStatement(SQL_OR_ORDERABLES_BY_PERFORM_LOCN_DELETE_ALL);
		 	//***pstmt_D = connection.prepareStatement(SQL_OR_ORDERABLES_BY_PERFORM_LOCN_DELETE);
		 	//***pstmt_U = connection.prepareStatement(SQL_OR_ORDERABLES_BY_PERFORM_LOCN_UPDATE);
		 	pstmt_I = connection.prepareStatement(SQL_OR_ORDERABLES_BY_PERFORM_LOCN_INSERT);
			pstmt_default_chk=connection.prepareStatement(SQL_OR_ORDERABLES_BY_PERFORM_LOCN_DEFAULT_YN_CHECK);

			int counter_I=0,counter_AD=0;
		 	//***counter_U=0,counter_D=0;
		 	traceVal.append("***no of recs ="+noOfRecords);
		 	//System.out.println("no of records = "+noOfRecords);
			HashMap tabData     =null;
		 	String  valid	    ="";
		 	String  associate_yn="";
		 	for(int k=0 ; k< noOfRecords ; k++){
		 		tabData     =(HashMap)tabDataMultiple.get(k);
				//System.out.println("###in ejb,tabData="+tabData);
		 		valid	    =(String)tabData.get("valid");
		 		associate_yn=(String)tabData.get("associate_yn");
		 		//System.out.println("in EJB valid:"+valid+",associate_yn:"+associate_yn+",order_catalog_code:"+((String)tabData.get("order_catalog_code")));
		 		traceVal.append("***b4 update=");

		 		//***if (all.equals("N")){
					if(k==0){
		 			//System.out.println("in Delete All");
		 			//***counter_AD++ ;
		 			pstmt_AD.setString(1 ,login_facility_id);
		 			pstmt_AD.setString(2 ,(String)tabData.get("location_type"));
		 			pstmt_AD.setString(3 ,(String)tabData.get("location_code"));
		 			pstmt_AD.setString(4 ,(String)tabData.get("order_type"));
					counter_AD=pstmt_AD.executeUpdate();
					}
					//System.out.println("####counter_AD="+counter_AD);
				//	if(counter_AD>0){
					/*************************************************/
					//HashMap tabData_temp=null;
					//boolean default_dup_chk=false;
					
			
					pstmt_default_chk.setString(1,(String)tabData.get("location_type"));
					pstmt_default_chk.setString(2,(String)tabData.get("order_catalog_code"));
					rs_default_chk=pstmt_default_chk.executeQuery();
					int record_count=0;
					if(rs_default_chk!=null && rs_default_chk.next()){				
						record_count++;
						}
					closeResultSet(rs_default_chk);
					//System.out.println("####record_count="+record_count);
					if(record_count>0 && (((String)tabData.get("default_yn")).equals("Y"))){				
						//System.out.println("###more than default");						
						connection.rollback();
						map.put("result",new Boolean(false));
						map.put("message","ATLEAST_ONE_DEFAULT");
						return map;		
					}
					//System.out.println("##########################");
					/*************************************************/				
				//	}
		 			/***pstmt_AD.addBatch();
		 			break;
		 		} else {
		 		if(valid.trim().equalsIgnoreCase("Y")){
		 			if(associate_yn.trim().equalsIgnoreCase("Y")){//update
		 				//System.out.println("in Update:appt_reqd_yn:"+(String)tabData.get("appt_reqd_yn"));
		 				counter_U++ ;
		 				String appt_reqd_yn = (String)tabData.get("appt_reqd_yn");
		 				String default_yn = (String)tabData.get("default_yn");
						if ((appt_reqd_yn==null) || (appt_reqd_yn.equals("")))
							appt_reqd_yn = "N";
						if ((default_yn==null) || (default_yn.equals("")))
							default_yn = "N";

						//System.out.println("appt_reqd_yn:"+appt_reqd_yn);
		 				pstmt_U.setString(1 ,appt_reqd_yn);
		 				pstmt_U.setString(2 ,default_yn);
		 				pstmt_U.setString(3 ,login_by_id);
		 				pstmt_U.setString(4 ,login_at_ws_no);
		 				pstmt_U.setString(5 ,login_facility_id);
		 				pstmt_U.setString(6 ,login_facility_id);
		 				pstmt_U.setString(7 ,(String)tabData.get("location_type"));
		 				pstmt_U.setString(8 ,(String)tabData.get("location_code"));
		 				pstmt_U.setString(9 ,(String)tabData.get("order_type"));
		 				pstmt_U.setString(10 ,(String)tabData.get("order_catalog_code"));
		 				pstmt_U.addBatch();
		 			} else{//delete
		 				traceVal.append("***begin delete=");
		 				//System.out.println("in Delete");
		 				//System.out.println("performing_facility_id:"+login_facility_id);
		 				//System.out.println("performing_deptloc_type:"+(String)tabData.get("location_type"));
		 				//System.out.println("performing_deptloc_code:"+ (String)tabData.get("location_code"));
		 				//System.out.println("order_type:"+(String)tabData.get("order_type"));
		 				//System.out.println("order_catalog_code:"+(String)tabData.get("order_catalog_code"));
		 				counter_D++ ;
		 				pstmt_D.setString(1 ,login_facility_id);
		 				pstmt_D.setString(2 ,(String)tabData.get("location_type"));
		 				pstmt_D.setString(3 ,(String)tabData.get("location_code"));
		 				pstmt_D.setString(4 ,(String)tabData.get("order_type"));
		 				pstmt_D.setString(5 ,(String)tabData.get("order_catalog_code"));
		 				pstmt_D.addBatch();
		 			}
		 		} else if(valid.equalsIgnoreCase("N")){
		 			traceVal.append("***begin insertion=");
		 			traceVal.append("associate_yn="+(String)tabData.get("associate_yn")) ;
		 			//System.out.println("***begin insertion=");
		 			if(associate_yn.equalsIgnoreCase("Y")){//Insert
		 				//System.out.println("in Insertion");***/
						if((valid.trim().equalsIgnoreCase("Y") && associate_yn.equalsIgnoreCase("Y")) || (valid.trim().equalsIgnoreCase("N") && associate_yn.equalsIgnoreCase("Y"))){
		 				counter_I++;
		 				traceVal.append("performing_facility_id="+login_facility_id) ;
		 				//System.out.println("performing_facility_id="+login_facility_id);
		 				traceVal.append("performing_deptloc_type="+(String)tabData.get("location_type")) ;
		 				//System.out.println("performing_deptloc_type="+(String)tabData.get("location_type"));
		 				traceVal.append("performing_deptloc_code="+(String)tabData.get("location_code"));
		 				//System.out.println("performing_deptloc_code="+(String)tabData.get("location_code"));
		 				traceVal.append("order_type_code="+(String)tabData.get("order_type"));
		 				//System.out.println("order_type_code="+(String)tabData.get("order_type"));
		 				traceVal.append("order_catalog_code="+(String)tabData.get("order_catalog_code"));
		 				//System.out.println("order_catalog_code="+(String)tabData.get("order_catalog_code"));
		 				traceVal.append("appt_reqd_yn="+(String)tabData.get("appt_reqd_yn"));
		 				traceVal.append("default_yn="+(String)tabData.get("default_yn"));
		 				//System.out.println("appt_reqd_yn="+(String)tabData.get("appt_reqd_yn"));
		 				//System.out.println("sql:"+SQL_OR_ORDERABLES_BY_PERFORM_LOCN_INSERT);
						String appt_reqd_yn = (String)tabData.get("appt_reqd_yn");
						if ((appt_reqd_yn==null) || (appt_reqd_yn.equals("")))
							appt_reqd_yn = "N";
						String default_yn = (String)tabData.get("default_yn");
						if ((default_yn==null) || (default_yn.equals("")))
							default_yn = "N";
		 				//System.out.println("appt_reqd_yn="+appt_reqd_yn);

		 				pstmt_I.setString(1 ,login_facility_id);
		 				pstmt_I.setString(2 ,(String)tabData.get("location_type"));
		 				pstmt_I.setString(3 ,(String)tabData.get("location_code"));
		 				pstmt_I.setString(4 ,(String)tabData.get("order_type"));
		 				pstmt_I.setString(5 ,(String)tabData.get("order_catalog_code"));
		 				pstmt_I.setString(6 ,appt_reqd_yn);
		 				pstmt_I.setString(7 ,default_yn);
		 				pstmt_I.setString(8 ,login_by_id);
		 				pstmt_I.setString(9 ,login_at_ws_no);
		 				pstmt_I.setString(10 ,login_facility_id);
		 				pstmt_I.setString(11 ,login_by_id);
		 				pstmt_I.setString(12 ,login_at_ws_no);
		 				pstmt_I.setString(13 ,login_facility_id);
		 				pstmt_I.addBatch();
		 			}
		 			/***}
		 		}***/
		 		traceVal.append("***no of recs ="+k);
		 	} //End of For Looping for all records

		 	//***traceVal.append("counter_I="+counter_I) ;
//System.out.println("###outside for loop");
		 	int [] updatedCounts_I ={};
		 	//***int [] updatedCounts_U ={};
		 	//***int [] updatedCounts_D ={};
		 	//***int [] updatedCounts_AD ={};

		 	if(counter_I > 0) updatedCounts_I = pstmt_I.executeBatch();

		 	//***if(counter_U > 0) updatedCounts_U = pstmt_U.executeBatch();

		 	//***if(counter_D > 0) updatedCounts_D = pstmt_D.executeBatch();

		 	//***if(counter_AD > 0) updatedCounts_AD = pstmt_AD.executeBatch();

		 	boolean updated_I = true ;
		 	//***boolean updated_U = true ;
		 	//***boolean updated_D = true ;
		 	//***boolean updated_AD = true ;

		 	if(counter_I > 0){
		 		//System.out.println("counter_I:"+counter_I+",updatedCounts_I:"+updatedCounts_I.length);
		 		if((updatedCounts_I.length > 0)) updated_I= true ;
		 		else if((updatedCounts_I.length == (-3))) updated_I= false ;
		 	}

		 /***if(counter_U > 0){
		 		//System.out.println("counter_U:"+counter_U+",updatedCounts_U:"+updatedCounts_U.length);
		 		if((updatedCounts_U.length > 0)) updated_U= true ;
		 		else if((updatedCounts_U.length == (-3))) updated_U= false ;
		 	}

		 	if(counter_D > 0){
		 		//System.out.println("counter_D:"+counter_D+",updatedCounts_D:"+updatedCounts_D.length);
		 		if((updatedCounts_D.length > 0)) updated_D= true ;
		 		else if((updatedCounts_D.length == (-3))) updated_D= false ;
		 	}

		 	if(counter_AD > 0){
		 		//System.out.println("counter_AD:"+counter_AD+",updatedCounts_AD:"+updatedCounts_AD.length);
		 		if((updatedCounts_AD.length > 0)) updated_AD= true ;
		 		else if((updatedCounts_AD.length == (-3))) updated_AD= false ;
		 	}***/

		 	//***if (updated_I && updated_U && updated_D && updated_AD ){
		 	if (updated_I){
		 		//System.out.println("before commit");
		 		connection.commit();
		 		//System.out.println("after commit");
		 		map.put( "result", new Boolean( true ) ) ;
		 		messages.append("RECORD_INSERTED") ;
		 	} else{
		 		//System.out.println("before rollback");
		 		connection.rollback();
		 		//System.out.println("after rollback");
		 		messages.append( "Insert Failed" ) ;
		 	}
        }
        catch (Exception e) {
            traceVal.append(e.getMessage());
            map.put( "traceVal", traceVal.toString() ) ;
            try {
                connection.rollback();
                //closeConnection(connection, pt);
            }
            catch (Exception ee) {
                messages.append(ee.getMessage());
            }
            messages.append(e.getMessage());
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
				closeResultSet(rs_default_chk);
				closeStatement(pstmt_default_chk);
            	//***closeStatement(pstmt_AU);
            	closeStatement(pstmt_AD);
            	//***closeStatement(pstmt_D);
            	//***closeStatement(pstmt_U);
            	closeStatement(pstmt_I);
                closeConnection(connection, pt);
            }
            catch (Exception fe) {
                System.err.println(fe.getMessage());
                fe.printStackTrace();
            }
        }

        map.put("message", messages.toString());
        map.put("traceVal", traceVal.toString());
        return map;
    }
    /** Method for modify Database Operations
     *@param HashMap tabDataParam modify Parameters
     *@param HashMap sqlMap sql statements
     *@return HashMap results of the modify operations
     */

/**
* @ejb.interface-method
*	 view-type="both"
*/

    public HashMap modify(HashMap tabDataParam,HashMap sqlMap) {
        StringBuffer messages = new StringBuffer();
        HashMap map = new HashMap();
        map.put("result", new Boolean(false));
        map.put("flag","");
        map.put("message", messages.toString());
        return map;
    }
    /** Method for delete Database Operations
     *@param HashMap tabDataParam delete parameters
     *@param HashMap sqlMap sql statements
     *@return HashMap results of the delete operations
     */

/**
* @ejb.interface-method
*	 view-type="both"
*/

	public HashMap delete(HashMap tabDataParam,HashMap sqlMap) {
        StringBuffer messages = new StringBuffer();
        HashMap map = new HashMap();
        map.put("result", new Boolean(false));
        map.put("flag","");
        map.put("message", messages.toString());
        map.put("callOnSuccess",new Boolean(false));
        return map;
    }

}
