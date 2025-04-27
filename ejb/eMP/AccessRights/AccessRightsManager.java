/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/***  Last Modified Date TIle : 9/23/2005 9:44 AM ***/
package eMP.AccessRights;

import webbeans.eCommon.*;
import java.rmi.*;
import javax.ejb.*;
import java.util.*;

import java.sql.*;
import javax.naming.*;
import javax.rmi.*;

/**
*
* @ejb.bean
*	name="AccessRights"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AccessRights"
*	local-jndi-name="AccessRights"
*	impl-class-name="eMP.AccessRights.AccessRightsManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eMP.AccessRights.AccessRightsLocal"
*	remote-class="eMP.AccessRights.AccessRightsRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMP.AccessRights.AccessRightsLocalHome"
*	remote-class="eMP.AccessRights.AccessRightsHome"
*	generate= "local,remote"
*
*
*/

public class AccessRightsManager implements SessionBean
{
    Connection con					= null;
    PreparedStatement pslPrepStmt	= null;
	PreparedStatement delPrepStmt	= null;

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


    public HashMap insertAccessRights(Properties p,HashMap tabdata)
	{
        HashMap results = new HashMap();

		String locale="";
		locale=p.getProperty("LOCALE");
      
        boolean result = false;
		
		try
		{
			con = ConnectionManager.getConnection(p);

	        String added_by_id			= (String)tabdata.get("modified_by_id");
		    String modifiedFacilityId	= (String)tabdata.get("modified_facility_id");
			String client_ip_address	= (String)tabdata.get("modified_at_ws_no");
	        Integer totCount			= (Integer)tabdata.get("ilCount");
	
			int totalCount	= totCount.intValue();
	        int ilStatus	= 0;

			StringBuffer sblQry = new StringBuffer();

			String RespId       = "";
			String VwPhotoYN    = "";
			String VwFinaDtlsYN = "";

	        
				if(totalCount != 0 )
				{
					ilStatus = 0;
					
					sblQry.append(" INSERT INTO MP_ACCESS_RIGHTS (RESP_ID, VIEW_PAT_PHOTO_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,VIEW_PAT_FIN_DTLS_YN ) VALUES (?,?,?,sysdate,?,?,?,sysdate,?,?,?) ");

					pslPrepStmt = con.prepareStatement(sblQry.toString());
					
					delPrepStmt = con.prepareStatement("DELETE FROM mp_access_rights where resp_id = ?");

					for(int i=1; i<=totalCount; i++)
					{
						RespId	        = (String) tabdata.get("RespId"+i);
						VwPhotoYN	    = (String) tabdata.get("viewpatphotoyn"+i);
						VwFinaDtlsYN	= (String) tabdata.get("viewpatfindtlsyn"+i);
						
						delPrepStmt.setString(1,RespId);
						delPrepStmt.executeUpdate();
				
						pslPrepStmt.setString(1,RespId);
						pslPrepStmt.setString(2,VwPhotoYN);
						pslPrepStmt.setString(3,added_by_id);
						pslPrepStmt.setString(4,client_ip_address);
						pslPrepStmt.setString(5,modifiedFacilityId);
						pslPrepStmt.setString(6,added_by_id);
						pslPrepStmt.setString(7,client_ip_address);
						pslPrepStmt.setString(8,modifiedFacilityId);
						pslPrepStmt.setString(9,VwFinaDtlsYN);
						
						ilStatus = pslPrepStmt.executeUpdate();

						results.put("sql :",sblQry.toString());
						
						if(sblQry != null && sblQry.length() > 0)
						{
							sblQry.delete(0,sblQry.length());
						}
					}
					

					if(pslPrepStmt != null) pslPrepStmt.close();
					if(delPrepStmt != null) delPrepStmt.close();


				}
				if(ilStatus == 1)
				{
					java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_INSERTED","SM" ) ;
					results.put("message",(String) message.get("message"));
					result = true;
					con.commit();
					message.clear();
				}
				else
				{
					con.rollback();
					results.put("error","Transaction could not be completed ");
				}
				if(pslPrepStmt != null){ pslPrepStmt.close(); }
			
			tabdata.clear();
		}
		catch(Exception e)
		{
			e.printStackTrace();
            results.put("er3", e);
		}
		finally
		{
			if (con!= null) ConnectionManager.returnConnection(con,p);
		}

        results.put("status", new Boolean(result));
        return results;
    }
}
