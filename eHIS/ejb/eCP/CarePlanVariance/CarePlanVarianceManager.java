/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        	Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           	created
23/05/2013		IN039387			vijayakumark	In manage Care Plan, Unable to record the Varience.When record button is clicked, Nothing is happens & again while trying to add a new varience system displays Java null Point Exception.
--------------------------------------------------------------------------------------------------------------------
*/
//This file is saved on 07/11/2005.
package eCP.CarePlanVariance;

import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.*;
//import webbeans.eCommon.ConnectionManager;
//import webbeans.eCommon.MessageManager;
/**
*
* @ejb.bean
*	name="CarePlanVariance"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="CarePlanVariance"
*	local-jndi-name="CarePlanVariance"
*	impl-class-name="eCP.CarePlanVariance.CarePlanVarianceManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCP.CarePlanVariance.CarePlanVarianceLocal"
*	remote-class="eCP.CarePlanVariance.CarePlanVarianceRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCP.CarePlanVariance.CarePlanVarianceLocalHome"
*	remote-class="eCP.CarePlanVariance.CarePlanVarianceHome"
*	generate= "local,remote"
*
*
*/
public class CarePlanVarianceManager implements SessionBean
{
	Connection conn=null;
	StringBuffer stringbuffer = new StringBuffer();
	HashMap messages = new HashMap() ;

	PreparedStatement pstmt_insert_var=null;
	PreparedStatement pstmt_insert_var_dtl=null;
	PreparedStatement pstmt_variance_log_id=null;
	ResultSet rset_variance_log_id=null;

    String message="";

	Hashtable messageMap=new Hashtable();

	int dtlCnt=0;
	int inserted=0;

	int md_care_plan_id=0;
	int care_plan_id=0;
	String var_comp_type="";

	String added_by_id="";
	String added_facility_id="";
	String added_at_ws_no="";
	String locale="";
	String variance_cause="";
	String variance_reason="";
	String variance_remarks="";
	String variance_action_plan="";
	String term_code="";
	String term_set_id="";
	String outcome_code="";
	String goal_code="";

	String variance_remarks1="";
	String variance_action_plan1="";

    String cons_remarks="";
	String cons_action_plan="";
	String variance_rec_by = "";//IN039387

	int n=0;
	int srl_no=1;
	int variance_log_id=0;

	String sql_insert_var="insert into cp_pat_care_plan_var (MD_CARE_PLAN_ID, CARE_PLAN_ID, VARIANCE_LOG_ID, VARIANCE_LOG_DATE, VARIANCE_REC_BY, VARIANCE_REMARKS, ACTION_PLAN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values (?,?,?,sysdate,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
	String sql_insert_var_dtl="insert into cp_pat_care_plan_var_dtl (MD_CARE_PLAN_ID, CARE_PLAN_ID, VARIANCE_LOG_ID, SRL_NO, VAR_REASON_CODE, VAR_CAUSE_CODE, VAR_COMP_TYPE, VAR_TERM_CODE, VAR_GOAL_CODE, VAR_OUTCOME_CODE, VARIANCE_REMARKS, ACTION_PLAN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO,ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,TERM_SET_ID) values (?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)";
	String sql_variance_log_id="select cp_pat_care_plan_var_seq.nextval variance_log_id from dual";

    public CarePlanVarianceManager(){}

    public void ejbCreate() throws  CreateException
    {
    }

    public void ejbRemove()
    {
    }

    public void ejbActivate()
    {
    }

    public void ejbPassivate()
    {
    }

    public void setSessionContext(SessionContext sessioncontext)
    {
    }
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/	
    public HashMap insert(Properties properties, HashMap tabData)
    {
		HashMap retMap = new HashMap();
		retMap.put("result",new Boolean(false));

		try
		{
		conn=ConnectionManager.getConnection(properties);
        conn.setAutoCommit(false);

		pstmt_variance_log_id=conn.prepareStatement(sql_variance_log_id);
		rset_variance_log_id=pstmt_variance_log_id.executeQuery();

     	n=Integer.parseInt((String)tabData.get("TOTAL_RECORDS"));
		if(rset_variance_log_id!=null)
		{
			while(rset_variance_log_id.next())
			{
                 variance_log_id=Integer.parseInt(rset_variance_log_id.getString("variance_log_id"));
			}
		}

		ArrayList variance_data=new ArrayList();

		md_care_plan_id=Integer.parseInt((String)tabData.get("MD_CARE_PLAN_ID"));
		care_plan_id=Integer.parseInt((String)tabData.get("CARE_PLAN_ID"));
		var_comp_type=(String)tabData.get("VAR_COM_TYPE");
		term_code=(String)tabData.get("TERM_CODE");
		term_set_id=(String)tabData.get("TERM_SET_ID");
		goal_code=(String)tabData.get("GOAL_CODE");
		//outcome_code=(String)tabData.get("OUTCOME_CODE");
		added_by_id=(String)tabData.get("ADDED_BY_ID");
		added_facility_id=(String)tabData.get("ADDED_FCY_ID");
		added_at_ws_no=(String)tabData.get("ADDED_AT_WS_NO");
		cons_remarks=(String)tabData.get("CONS_REMARKS");
		cons_action_plan=(String)tabData.get("CONS_ACTION_PLAN");
		locale=(String)tabData.get("locale");
		variance_rec_by = (String)tabData.get("variance_rec_by"); //IN039387
	
        pstmt_insert_var_dtl=conn.prepareStatement(sql_insert_var_dtl);

        try
		{
			pstmt_insert_var=conn.prepareStatement(sql_insert_var);

			pstmt_insert_var.setInt(1,md_care_plan_id);
			pstmt_insert_var.setInt(2,care_plan_id);
			pstmt_insert_var.setInt(3,variance_log_id);
			//IN039387 starts
			//pstmt_insert_var.setString(4,added_by_id);
			pstmt_insert_var.setString(4,variance_rec_by);
			//IN039387 ends
			pstmt_insert_var.setString(5,cons_remarks);
			pstmt_insert_var.setString(6,cons_action_plan);
			pstmt_insert_var.setString(7,added_by_id);
			pstmt_insert_var.setString(8,added_at_ws_no);
			pstmt_insert_var.setString(9,added_facility_id);
			pstmt_insert_var.setString(10,added_by_id);
			pstmt_insert_var.setString(11,added_at_ws_no);
			pstmt_insert_var.setString(12,added_facility_id);

			inserted=pstmt_insert_var.executeUpdate();
		
			for(int k=1;k<=n;k++)
			{
	    	variance_data=(ArrayList)tabData.get("VARIANCE_DATA"+k);

            outcome_code=(String)variance_data.get(0);
		    variance_cause=(String)variance_data.get(1);
            variance_reason=(String)variance_data.get(2);
            variance_remarks=(String)variance_data.get(3);
            variance_action_plan=(String)variance_data.get(4);

			pstmt_insert_var_dtl.setInt(1,md_care_plan_id);
			pstmt_insert_var_dtl.setInt(2,care_plan_id);
			pstmt_insert_var_dtl.setInt(3,variance_log_id);
			pstmt_insert_var_dtl.setInt(4,srl_no++);
			pstmt_insert_var_dtl.setString(5,variance_reason);
    		pstmt_insert_var_dtl.setString(6,variance_cause);
			pstmt_insert_var_dtl.setString(7,var_comp_type);
    		pstmt_insert_var_dtl.setString(8,term_code);
    		pstmt_insert_var_dtl.setString(9,goal_code);
    		pstmt_insert_var_dtl.setString(10,outcome_code);
    		pstmt_insert_var_dtl.setString(11,variance_remarks);
    		pstmt_insert_var_dtl.setString(12,variance_action_plan);
			pstmt_insert_var_dtl.setString(13,added_by_id);
			pstmt_insert_var_dtl.setString(14,added_at_ws_no);
			pstmt_insert_var_dtl.setString(15,added_facility_id);
			pstmt_insert_var_dtl.setString(16,added_by_id);
			pstmt_insert_var_dtl.setString(17,added_at_ws_no);
			pstmt_insert_var_dtl.setString(18,added_facility_id);
			pstmt_insert_var_dtl.setString(19,term_set_id);

			dtlCnt=pstmt_insert_var_dtl.executeUpdate();
			dtlCnt++;
			}
    	}
		catch(Exception batchException)
		{
			//IN039387 starts
			//System.out.println(batchException.toString());
			batchException.printStackTrace();
			//IN039387 ends
		}

         if(dtlCnt>0 && inserted>0)
         {  
			 conn.commit();
             retMap.put( "result", new Boolean( true ) ) ;
			 messageMap.clear();
			 messageMap = MessageManager.getMessage(locale, "RECORD_INSERTED","CP");
			 messages.clear();
			 messages.put("MESSAGE",(String)messageMap.get("message"));
         }
		 else
    	 {
			 conn.rollback();
             retMap.put( "result", new Boolean( false ) ) ;
 			 messageMap.clear();
			 messageMap = MessageManager.getMessage(locale, "ERROR_IN_INSERTING_INTO","CP");
 			 messages.clear();
			 messages.put("MESSAGE",(String)messageMap.get("message"));
		 }
		}
		catch(Exception exp)
		{
			exp.printStackTrace(); //IN039387
			try{
				conn.rollback();
				retMap.put( "result", new Boolean( false ) ) ;
				stringbuffer.append(exp.getMessage());
      			messageMap.clear();
				Hashtable messageMap = MessageManager.getMessage(locale, "ERROR_IN_INSERTING_INTO","CP");
				messages.clear();
    			messages.put("MESSAGE",(String) messageMap.get("message"));
			}
			catch(Exception ex)	{
				ex.printStackTrace();
			}
		}

		finally
		{
			try
			{
				if(pstmt_insert_var != null) 
				{
					pstmt_insert_var.close();
					pstmt_insert_var = null;
				}
				if(pstmt_insert_var_dtl != null)
				{
					pstmt_insert_var_dtl.close();
					pstmt_insert_var_dtl = null;
				}
				if( pstmt_variance_log_id!= null)
				{
					pstmt_variance_log_id.close();
					pstmt_variance_log_id = null;
				}
				if( rset_variance_log_id!= null)
				{
					rset_variance_log_id.close();
					rset_variance_log_id = null;
				}
				if(conn != null) {
					ConnectionManager.returnConnection(conn,properties);
	    		}
     		}
			catch(Exception exp)
			{
					exp.printStackTrace();
			}
	}
	message=(String)messages.get("MESSAGE");
	retMap.put( "message",message);
	retMap.put( "traceVal",stringbuffer.toString());
	retMap.put( "invalidCode","");
   	return retMap;
	}
}
