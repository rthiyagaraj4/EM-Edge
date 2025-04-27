/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This File is saved on 18/10/2005.
package eCP.EvaluateCarePlanMarkError;
import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
/**
*
* @ejb.bean
*	name="EvaluateCarePlanMarkError"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="EvaluateCarePlanMarkError"
*	local-jndi-name="EvaluateCarePlanMarkError"
*	impl-class-name="eCP.EvaluateCarePlanMarkError.EvaluateCarePlanMarkErrorManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCP.EvaluateCarePlanMarkError.EvaluateCarePlanMarkErrorLocal"
*	remote-class="eCP.EvaluateCarePlanMarkError.EvaluateCarePlanMarkErrorRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCP.EvaluateCarePlanMarkError.EvaluateCarePlanMarkErrorLocalHome"
*	remote-class="eCP.EvaluateCarePlanMarkError.EvaluateCarePlanMarkErrorHome"
*	generate= "local,remote"
*
*
*/
public class EvaluateCarePlanMarkErrorManager implements SessionBean
{
	Connection con = null;
    PreparedStatement pstmt = null;
	StringBuffer stringbuffer = new StringBuffer();
    public EvaluateCarePlanMarkErrorManager()
    {
    }
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
    public HashMap AddModify(Properties properties, HashMap hashmap)
	{
		HashMap tempHash = new HashMap();
		try
		{
			con = ConnectionManager.getConnection(properties);
            con.setAutoCommit(false);
			String eval_id = (String) hashmap.get("EVAL_ID");
			String md_plan_id = (String) hashmap.get("MD_PLAN_ID");
			String care_plan_id = (String) hashmap.get("CARE_PLAN_ID");
			String mrk_reason = (String) hashmap.get("MRK_REASON");
			// Queries for Update.
			String sql_cp_pat_care_plan_eval = "update cp_pat_care_plan_eval set status='E', status_remarks=? where md_care_plan_id=? and care_plan_id=? and eval_id=?";
			String sql_cp_pat_term_code_eval = "update cp_pat_term_code_eval set status='E' ,status_remarks=? where md_care_plan_id=? and care_plan_id=? and eval_id=?";
			String sql_cp_pat_goal_eval = "update cp_pat_goal_eval set status='E', status_remarks=? where md_care_plan_id=? and care_plan_id=? and eval_id=?";
			String sql_cp_pat_outcome_eval = "update cp_pat_outcome_eval set status='E', status_remarks=? where md_care_plan_id=? and care_plan_id=? and eval_id=?";
			// End of Queries used for Update.
			//Updating cp_pat_care_pla_eval
			pstmt = con.prepareStatement(sql_cp_pat_care_plan_eval);
			pstmt.setString(1,mrk_reason);
			pstmt.setString(2,md_plan_id);
			pstmt.setString(3,care_plan_id);
			pstmt.setString(4,eval_id);
			pstmt.executeUpdate();
			if(pstmt!=null) 
			{	
				pstmt.close();
				pstmt = null;
			}
			//End of cp_pat_care_pla_eval update.
			//Updating cp_pat_term_code_eval
			pstmt = con.prepareStatement(sql_cp_pat_term_code_eval);
			pstmt.setString(1,mrk_reason);
			pstmt.setString(2,md_plan_id);
			pstmt.setString(3,care_plan_id);
			pstmt.setString(4,eval_id);
			pstmt.executeUpdate();
			if(pstmt!=null) 
			{	
				pstmt.close();
				pstmt = null;
			}
			//End of cp_pat_term_code_eval update.
			//Updating cp_pat_goal_eval
			pstmt = con.prepareStatement(sql_cp_pat_goal_eval);
			pstmt.setString(1,mrk_reason);
			pstmt.setString(2,md_plan_id);
			pstmt.setString(3,care_plan_id);
			pstmt.setString(4,eval_id);
			pstmt.executeUpdate();
			if(pstmt!=null) 
			{	
				pstmt.close();
				pstmt = null;
			}
			//End of cp_pat_goal_eval update.
			//Updating cp_pat_outcome_eval
			pstmt = con.prepareStatement(sql_cp_pat_outcome_eval);
			pstmt.setString(1,mrk_reason);
			pstmt.setString(2,md_plan_id);
			pstmt.setString(3,care_plan_id);
			pstmt.setString(4,eval_id);
			pstmt.executeUpdate();
			if(pstmt!=null) 
			{	
				pstmt.close();
				pstmt = null;
			}
			//End of cp_pat_outcome_eval update.
			con.commit();
			tempHash.put("status",new Boolean(true));
			tempHash.put("error",stringbuffer.toString());
			if(con!=null)
				ConnectionManager.returnConnection(con, properties);
		}
        catch(Exception exception)
        {
            stringbuffer.append("Error in main try " + exception.getMessage());
			exception.printStackTrace();
			tempHash.put("status",new Boolean(false));
			tempHash.put("error",stringbuffer.toString());
			try
			{
				con.rollback();
			}
			catch(Exception es)
			{
				es.printStackTrace();		
			}
        }
        finally
        {
            if(con != null)
			try
			{
				if(pstmt!=null) 
				{	
					pstmt.close();
					pstmt = null;
				}
				if(con != null)ConnectionManager.returnConnection(con, properties);
			}
			catch(Exception exception2) 
			{
				System.err.println(exception2.toString());
			}
        }
		return tempHash;
    }
}
