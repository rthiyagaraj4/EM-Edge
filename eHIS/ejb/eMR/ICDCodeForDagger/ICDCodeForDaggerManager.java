/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR.ICDCodeForDagger;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
*
* @ejb.bean
*	name="ICDCodeForDagger"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ICDCodeForDagger"
*	local-jndi-name="ICDCodeForDagger"
*	impl-class-name="eMR.ICDCodeForDagger.ICDCodeForDaggerManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eMR.ICDCodeForDagger.ICDCodeForDaggerLocal"
*	remote-class="eMR.ICDCodeForDagger.ICDCodeForDaggerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMR.ICDCodeForDagger.ICDCodeForDaggerLocalHome"
*	remote-class="eMR.ICDCodeForDagger.ICDCodeForDaggerHome"
*	generate= "local,remote"
*
*
*/


public class ICDCodeForDaggerManager implements SessionBean
{
    Connection con  ;
    PreparedStatement pslPrepStmt = null;
    
    SessionContext ctx;

    public void ejbCreate() {}
    public void ejbRemove(){}
    public void ejbActivate(){}
    public void ejbPassivate(){}

    public void setSessionContext(SessionContext context){  this.ctx = context;
	}


	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap insertICDCodeForDagger(Properties p,HashMap tabdata)
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
			int totalCount = totCount.intValue();
			int ilStatus = 0;
			StringBuffer sblQry = new StringBuffer();
			StringBuffer sbSql = new StringBuffer();
			String dagger_code = (String) tabdata.get("dagger_code");
			String dagger_srl_no = (String) tabdata.get("dagger_srl_no");
			String astk_diag_srl_no = "";
			String astk_diag_code = "";
			String locale = p.getProperty("LOCALE");

			sblQry.append(" DELETE FROM mr_icd_code_dtl WHERE DAG_DIAG_CODE='"+dagger_code+"' ");

			pslPrepStmt = con.prepareStatement(sblQry.toString());
			pslPrepStmt.executeUpdate();
			if ( pslPrepStmt != null ) pslPrepStmt.close();
			ilStatus = 1;

			try
			{
				if (totalCount != 0)
				{
					ilStatus=0;
					for(int i=0; i<totalCount; i++)
					{
						astk_diag_srl_no = (String)tabdata.get("astk_diag_srl_no"+i);
						astk_diag_code	= (String)tabdata.get("astk_diag_code"+i);

						if(sbSql.length() > 0 ) 
							sbSql.delete(0,sbSql.length());

						sbSql.append(" INSERT INTO MR_ICD_CODE_DTL ");
						sbSql.append(" (dag_diag_srl_no, dag_diag_code, astk_diag_srl_no, astk_diag_code, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ) ");
						sbSql.append(" VALUES ");
						sbSql.append(" ( '"+dagger_srl_no+"', '"+dagger_code+"', '"+astk_diag_srl_no+"', '"+astk_diag_code+"', '"+added_by_id+"', sysdate , '"+client_ip_address+"', '"+modifiedFacilityId+"', '"+added_by_id+"', sysdate , '"+client_ip_address+"', '"+modifiedFacilityId+"') ");
						//String InsertSql = " INSERT INTO MR_ICD_CODE_DTL (dag_diag_srl_no, dag_diag_code, astk_diag_srl_no, astk_diag_code, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ) VALUES ( '"+dagger_srl_no+"', '"+dagger_code+"', '"+astk_diag_srl_no+"', '"+astk_diag_code+"', '"+added_by_id+"', sysdate ,'"+client_ip_address+"', '"+modifiedFacilityId+"', '"+added_by_id+"', sysdate ,'"+client_ip_address+"', '"+modifiedFacilityId+"')";
						pslPrepStmt = con.prepareStatement(sbSql.toString());
						ilStatus = pslPrepStmt.executeUpdate();
						results.put("sql",sblQry.toString());
						if ( pslPrepStmt != null ) pslPrepStmt.close();
					}
				}
				if(ilStatus == 1)
				{
					Hashtable message = MessageManager.getMessage( locale, "RECORD_INSERTED","SM" ) ;
					results.put("message",(String) message.get("message"));
					result = true;
					con.commit();
					if ( message != null ) message.clear();
				}else
				{
					con.rollback();
					results.put("error","Transaction could not be completed...");
				}
			}catch(Exception e)
			{
				e.printStackTrace();
				results.put("er2", e);
			}
			finally
			{
				if(con != null)      
					ConnectionManager.returnConnection(con,p);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
            results.put("er3", e);
		}
        results.put("status",new Boolean(result));
        return results;
    }
}
