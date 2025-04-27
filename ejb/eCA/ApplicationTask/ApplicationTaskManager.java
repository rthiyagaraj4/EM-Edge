/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA.ApplicationTask;

import java.rmi.RemoteException;
import java.sql.*;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Properties;
import javax.ejb.*;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

/**
*
* @ejb.bean
*	name="ApplicationTaskManager"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ApplicationTaskManager"
*	local-jndi-name="ApplicationTaskManager"
*	impl-class-name="eCA.ApplicationTask.ApplicationTaskManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCA.ApplicationTask.ApplicationTaskLocal"
*	remote-class="eCA.ApplicationTask.ApplicationTaskRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.ApplicationTask.ApplicationTaskLocalHome"
*	remote-class="eCA.ApplicationTask.ApplicationTaskHome"
*	generate= "local,remote"
*
*
*/


public class ApplicationTaskManager implements SessionBean
{
   SessionContext ctx;

   public void ejbCreate() 
	{
    }

    public void ejbRemove() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void setSessionContext(SessionContext sessioncontext) {
        ctx = sessioncontext;
    }

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap insertApplicationTask(Properties properties, HashMap hashtable)
    {
        Connection con	= null;;
		PreparedStatement pslPrepStmt = null;

		HashMap		hashtableprep	= new HashMap();
		Hashtable	hashtablemsg	= new Hashtable();
		boolean		bUpdateFlag		= true;
        
		try 
		{
			con = ConnectionManager.getConnection(properties);

            String modified_by_id			= (String)hashtable.get("modified_by_id");
            String modified_facility_id		= (String)hashtable.get("modified_facility_id");
            String modified_at_ws_no		= (String)hashtable.get("modified_at_ws_no");
            Integer totCount				= (Integer)hashtable.get("count");
			String locale					= (String) hashtable.get("locale");
			String task_text				= (String)hashtable.get("task_text");
			String taskApplicable			= (String)hashtable.get("taskApplicable");

            int			ilCount		= totCount.intValue();

			StringBuffer SQLstringbuffer = new StringBuffer();

			SQLstringbuffer.append("Update ca_appl_task set dflt_privilege_status = 'X' , access_rigths_appl = 'NA'");
			
			if(!task_text.equals(""))
				SQLstringbuffer.append(" where upper(APPL_TASK_DESC) like ? ");
			
			if(taskApplicable.equals("A"))
				SQLstringbuffer.append(" and DFLT_PRIVILEGE_STATUS ='A' ");
			else if(taskApplicable.equals("X"))
				SQLstringbuffer.append(" and DFLT_PRIVILEGE_STATUS ='X' ");
			
			pslPrepStmt = con.prepareStatement(SQLstringbuffer.toString());
			
			if(!task_text.equals(""))
				pslPrepStmt.setString(1,task_text);
			
			pslPrepStmt.executeUpdate();
	
			if (pslPrepStmt != null) pslPrepStmt.close();	

			if(ilCount != 0) 
			{
				SQLstringbuffer = new StringBuffer();
			
				SQLstringbuffer.append("   Update ca_appl_task set dflt_privilege_status = 'A'  ");
				SQLstringbuffer.append(" , modified_by_id =?");
				SQLstringbuffer.append(" , modified_facility_id =?");
				SQLstringbuffer.append(" , modified_at_ws_no =?");
				SQLstringbuffer.append(" , modified_date = sysdate ");
				SQLstringbuffer.append(" , access_rigths_appl =? ");
				SQLstringbuffer.append("   where appl_task_id =?");

				pslPrepStmt = con.prepareStatement(SQLstringbuffer.toString());	
			
				for(int k = 1; k <= ilCount; k++)
				{
					String task_status_k = (String)hashtable.get("task_status" + k);
					String access_right = (String)hashtable.get("app_access_rights" + k);
					pslPrepStmt.setString(1,modified_by_id);
					pslPrepStmt.setString(2,modified_facility_id);
					pslPrepStmt.setString(3,modified_at_ws_no);
					pslPrepStmt.setString(5,task_status_k);
					pslPrepStmt.setString(4,access_right);
					pslPrepStmt.addBatch();
				}
				
				int [] j = pslPrepStmt.executeBatch();

				if (j.length == -3 || j.length != ilCount)
					bUpdateFlag = false;

				if(pslPrepStmt != null) pslPrepStmt.close();
			}
				
			if(bUpdateFlag) 
			{
				con.commit();
				hashtablemsg = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
				hashtableprep.put("message", (String)hashtablemsg.get("message"));
			} 
			else 
			{
				con.rollback();
				hashtablemsg = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
			}

			hashtableprep.put("message", (String)hashtablemsg.get("message"));
        } 
		catch(Exception exception) 
		{
			exception.printStackTrace() ;
            hashtableprep.put("er3", exception);
        }
		finally 
		{
			hashtable.clear();
			hashtablemsg.clear();
			if(con != null) ConnectionManager.returnConnection(con, properties);
        }
        
		hashtableprep.put("status", new Boolean(bUpdateFlag));
		return hashtableprep;
    }
}
