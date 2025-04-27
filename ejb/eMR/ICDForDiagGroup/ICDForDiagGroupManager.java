/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR.ICDForDiagGroup;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import java.rmi.RemoteException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.CreateException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;
import java.sql.PreparedStatement;
import java.sql.Connection;


/**
*
* @ejb.bean
*	name="ICDForDiagGroup"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ICDForDiagGroup"
*	local-jndi-name="ICDForDiagGroup"
*	impl-class-name="eMR.ICDForDiagGroup.ICDForDiagGroupManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eMR.ICDForDiagGroup.ICDForDiagGroupLocal"
*	remote-class="eMR.ICDForDiagGroup.ICDForDiagGroupRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMR.ICDForDiagGroup.ICDForDiagGroupLocalHome"
*	remote-class="eMR.ICDForDiagGroup.ICDForDiagGroupHome"
*	generate= "local,remote"
*
*
*/

public class ICDForDiagGroupManager implements SessionBean
{
    Connection con  ;
    PreparedStatement pslPrepStmt = null;
	SessionContext ctx;

    public void ejbCreate() {}
    public void ejbRemove(){}
    public void ejbActivate(){}
    public void ejbPassivate(){}

    public void setSessionContext(SessionContext context )
	{
        this.ctx = context;
    }

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap insertICDForDiagGroup(Properties p,HashMap tabdata) 
	{
        HashMap results = new HashMap();
        boolean result = false;
		try
		{
			con = ConnectionManager.getConnection(p);

			String added_by_id = (String)tabdata.get("modified_by_id");
			String modifiedFacilityId = (String)tabdata.get("modified_facility_id");
			String client_ip_address = (String)tabdata.get("modified_at_ws_no");
			Integer totCount = (Integer)tabdata.get("totCount");
			String locale = p.getProperty("LOCALE");
			int totalCount = totCount.intValue();

			int ilStatus = 0;
			StringBuffer sblQry = new StringBuffer();
			String diag_group_code="";
			diag_group_code = (String) tabdata.get("diag_group_code");
			String diag_code_scheme="";
			diag_code_scheme = (String) tabdata.get("diag_code_scheme");
			String group_type="";
			group_type = (String) tabdata.get("group_type");


			String icdCodeNum = "";
			if (group_type.equals("P")&&diag_code_scheme.equals("3"))
				sblQry.append("DELETE FROM MR_PROC_GROUP_DTL  where GROUP_TYPE = '"+group_type+"' AND DIAG_GROUP_CODE ='"+diag_group_code+"'");
			else
				sblQry.append("DELETE FROM MR_DIAG_GROUP_DTL  where GROUP_TYPE = '"+group_type+"' AND DIAG_GROUP_CODE ='"+diag_group_code+"'");
					
				pslPrepStmt = con.prepareStatement(sblQry.toString());
				pslPrepStmt.executeUpdate();
				pslPrepStmt.close();
				ilStatus = 1;

			try
			{
				if(totalCount != 0)
				{
					ilStatus=0;
					for(int i=0; i<totalCount; i++)
					{
						icdCodeNum = (String)tabdata.get("icdCodeNum"+i);
						sblQry = new StringBuffer();
						if (group_type.equals("P")&&diag_code_scheme.equals("3"))
						{
							sblQry.append("INSERT INTO MR_PROC_GROUP_DTL ");
							sblQry.append("(GROUP_TYPE,DIAG_GROUP_CODE, CPT_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ");
							sblQry.append("ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID )");
							sblQry.append("VALUES (");
							sblQry.append("'"+group_type+"','"+diag_group_code+"', '"+icdCodeNum+"', '"+ added_by_id +"', sysdate ,'"+ client_ip_address +"', ");
							sblQry.append("'"+ modifiedFacilityId +"', '"+ added_by_id +"', sysdate ,'"+ client_ip_address +"','"+ modifiedFacilityId +"') ");
						}
						else
						{
							sblQry.append("INSERT INTO MR_DIAG_GROUP_DTL ");
							sblQry.append("(GROUP_TYPE,DIAG_GROUP_CODE, DIAG_SRL_NO, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ");
							sblQry.append("ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID )");
							sblQry.append("VALUES (");
							sblQry.append("'"+group_type+"','"+diag_group_code+"', '"+icdCodeNum+"', '"+ added_by_id +"', sysdate ,'"+ client_ip_address +"', ");
							sblQry.append("'"+ modifiedFacilityId +"', '"+ added_by_id +"', sysdate ,'"+ client_ip_address +"','"+ modifiedFacilityId +"') ");
						}

						pslPrepStmt = con.prepareStatement(sblQry.toString());
						ilStatus = pslPrepStmt.executeUpdate();
						pslPrepStmt.close();
						results.put("sql",sblQry.toString());
					}
				}
				
				if(ilStatus == 1)
				{
					Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM");
					results.put("message",(String) message.get("message"));
					if ( message != null ) message.clear();
					result = true;
					con.commit();
				}else
				{
					con.rollback();
					results.put("error","Not insert");
				}
			if(pslPrepStmt != null)	pslPrepStmt.close(); 			
			}catch(Exception e)
			{
				results.put("error", e);
			}
			finally
			{
				if(con != null)      
					ConnectionManager.returnConnection(con,p);
			}

		}catch(Exception e)
		{
            results.put("error", e);
		}

        results.put("status",new Boolean(result));
        return results;
    }
}
