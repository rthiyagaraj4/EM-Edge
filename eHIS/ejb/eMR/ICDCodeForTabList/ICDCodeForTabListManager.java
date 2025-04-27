/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR.ICDCodeForTabList;

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
import java.sql.Statement;
import java.sql.Connection;
import java.util.*;

/**
*
* @ejb.bean
*	name="ICDCodeForTabList"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ICDCodeForTabList"
*	local-jndi-name="ICDCodeForTabList"
*	impl-class-name="eMR.ICDCodeForTabList.ICDCodeForTabListManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eMR.ICDCodeForTabList.ICDCodeForTabListLocal"
*	remote-class="eMR.ICDCodeForTabList.ICDCodeForTabListRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMR.ICDCodeForTabList.ICDCodeForTabListLocalHome"
*	remote-class="eMR.ICDCodeForTabList.ICDCodeForTabListHome"
*	generate= "local,remote"
*
*
*/

public class ICDCodeForTabListManager implements SessionBean{

    Connection con  ;
    PreparedStatement pslPrepStmt = null;
    Statement stmt = null;
    SessionContext ctx;

    public void ejbCreate() {}
    public void ejbRemove(){}
    public void ejbActivate(){}
    public void ejbPassivate(){}

    public void setSessionContext(SessionContext context ){
        this.ctx = context;
    }
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/


    public HashMap insertICDCodeForTabList(Properties p,HashMap tabdata)
	{
        HashMap results = new HashMap();
        boolean result = false;
		StringBuffer	messageBuffer= new StringBuffer("");
		String temp="";
    try{
        con = ConnectionManager.getConnection(p);
        String added_by_id = (String)tabdata.get("modified_by_id");
        String modifiedFacilityId = (String)tabdata.get("modified_facility_id");
        String client_ip_address = (String)tabdata.get("modified_at_ws_no");
        String totalCount = (String)tabdata.get("totCount");
//		String selectedAlpha = (String)tabdata.get("selectedAlpha");
		String locale = p.getProperty("LOCALE");


		int ilStatus = 0;
        StringBuffer sblQry = new StringBuffer();
        String tabulation_list="";
        tabulation_list = (String) tabdata.get("tabulation_list");
		String recVals = (String) tabdata.get("recVals");

        String icdCodeNum = "";
		ilStatus = 1;

        try
		{

				stmt = con.createStatement();
				try
				{
					//recVals="('106123','106784','109976','105120')";
					String 	sql = "DELETE MR_ICD_FOR_TAB_LIST where DIAG_SRL_NO IN"+recVals+" AND TAB_LIST_NO='"+tabulation_list+"'";
					int res1 = stmt.executeUpdate(sql);
					if(res1>0) 
						result = true; 
					else
					{
						messageBuffer.append("Eror in deletion from MR_ICD_FOR_TAB_LIST");
						result = false;
					}
					if(stmt != null) stmt.close();
				}
				catch (Exception es)
				{
					es.printStackTrace();
					messageBuffer.append("Exception in deleting from MR_ICD_FOR_TAB_LIST" + es.getMessage());
					result = false;
				}
				ilStatus=0;
				if(sblQry.length()>0) sblQry.delete(0,sblQry.length());
				if(result)
				{

					StringTokenizer str= new StringTokenizer(totalCount,"#") ;
					StringTokenizer str12=null; 

					while(str.hasMoreTokens() && result)
					{
						temp=str.nextToken();
						if (!temp.equals(""))
						{
							str12=new StringTokenizer(temp,"|") ;
						/* Same variable "icdCodeNum" is used twice below because the second value has to be stored. Dummay variable used for first token was removed for PMD corrections */
							if(str12.hasMoreTokens())
							   icdCodeNum=str12.nextToken();
							if(str12.hasMoreTokens())
								icdCodeNum=str12.nextToken();
							else
								icdCodeNum="";
						}
					
					sblQry.append("INSERT INTO MR_ICD_FOR_TAB_LIST ");
					sblQry.append("(TAB_LIST_NO, DIAG_SRL_NO, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO,");
					sblQry.append("ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID )");
					sblQry.append("VALUES (");
					sblQry.append("'"+tabulation_list+"', '"+icdCodeNum+"', '"+ added_by_id +"', sysdate ,'"+ client_ip_address +"', ");
					sblQry.append("'"+ modifiedFacilityId +"', '"+ added_by_id +"', sysdate ,'"+ client_ip_address +"','"+ modifiedFacilityId +"') ");
						pslPrepStmt = con.prepareStatement(sblQry.toString());
						ilStatus = pslPrepStmt.executeUpdate();

						if(ilStatus>0) 
							result = true; 
						else
						{
							messageBuffer.append("Eror in insertion in MR_ICD_FOR_TAB_LIST");
							result = false;
						}

						if(pslPrepStmt != null) pslPrepStmt.close();
						if (sblQry.length()>0) sblQry.delete(0,sblQry.length());	
					}
				}

			if(ilStatus == 1 && result)
			{
				Hashtable message = MessageManager.getMessage( locale, "RECORD_INSERTED","SM" ) ;
				results.put("message",(String) message.get("message"));
				if ( message != null ) message.clear();
				result = true;
				con.commit();
			}else
			{
				con.rollback();
				//results.put("error","Transaction could not be completed ");
				results.put("error",messageBuffer.toString());
			}

		}catch(Exception e)
		{
            results.put("er2", e);

        }
		finally
		{
            if(con != null)      
				ConnectionManager.returnConnection(con,p);
        }
    }
	catch(Exception e){
            results.put("er3", e);
    }
        results.put("status",new Boolean(result));
        return results;
    }
}
