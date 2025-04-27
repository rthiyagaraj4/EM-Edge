/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM.FacilityForResponsibility;

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
*	name="FacilityForResponsibility"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="FacilityForResponsibility"
*	local-jndi-name="FacilityForResponsibility"
*	impl-class-name="eSM.FacilityForResponsibility.FacilityForResponsibilityManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSM.FacilityForResponsibility.FacilityForResponsibilityLocal"
*	remote-class="eSM.FacilityForResponsibility.FacilityForResponsibilityRemote"
*	generate= "local,remote"
*
* @ejb.home 
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSM.FacilityForResponsibility.FacilityForResponsibilityLocalHome"
*	remote-class="eSM.FacilityForResponsibility.FacilityForResponsibilityHome"
*	generate= "local,remote"
*
*
*/
 
public class FacilityForResponsibilityManager implements SessionBean{

    Connection con  ;
    PreparedStatement pslPrepStmt = null;
    SessionContext ctx;
    public void ejbCreate() {}
    public void ejbRemove(){}
    public void ejbActivate(){}
    public void ejbPassivate(){}
   String locale="";
    public void setSessionContext(SessionContext context ){
        this.ctx = context;
    }

	/**
	 *Method to insert Facility For Responsibility
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap insertModifyRespFacility(java.util.HashMap tabdata1)  
	{
		java.util.Properties p=(java.util.Properties)tabdata1.get("p");
		locale = p.getProperty("LOCALE");

		HashMap tabdata=(HashMap)tabdata1.get("insert_values");	
			

        HashMap results = new HashMap();

        boolean result = false;
    try{

        con = ConnectionManager.getConnection(p);

        String added_by_id = (String)tabdata.get("modified_by_id");
        String modifiedFacilityId = (String)tabdata.get("modified_facility_id");
        String client_ip_address = (String)tabdata.get("modified_at_ws_no");
        Integer totCount = (Integer)tabdata.get("totCount");
        int totalCount = totCount.intValue();
        int ilStatus = 0;
        StringBuffer sblQry = new StringBuffer();
        String facility_id="";
        facility_id = (String) tabdata.get("facility_id");

        String resp_id="",remarks="";  

			sblQry.append("DELETE FROM SM_facility_for_resp where facility_id ='"+facility_id+"'");
			pslPrepStmt = con.prepareStatement(sblQry.toString());
			 pslPrepStmt.executeUpdate();
			 pslPrepStmt.close();
			 ilStatus = 1;
			 String sql="insert into SM_facility_for_resp ( resp_id,facility_id,remarks,added_by_id,added_date,added_at_ws_no,modified_by_id,modified_date,modified_at_ws_no ) values(?,?,?,?,sysdate,?,?,sysdate,?) ";

        try{
                if (totalCount != 0){
					ilStatus=0;
					for(int i=0; i<totalCount; i++){
						resp_id = (String)tabdata.get("respID"+i);
						remarks=  (String)tabdata.get("comments"+i);
						pslPrepStmt = con.prepareStatement(sql);
						pslPrepStmt.setString(1,resp_id);
						pslPrepStmt.setString(2,facility_id);
						pslPrepStmt.setString(3,remarks);
						pslPrepStmt.setString(4,added_by_id);
						pslPrepStmt.setString(5,client_ip_address);
						pslPrepStmt.setString(6,added_by_id);
						pslPrepStmt.setString(7,modifiedFacilityId);

						ilStatus = pslPrepStmt.executeUpdate();
						if(pslPrepStmt != null){ pslPrepStmt.close();
					} 
				}
				if(ilStatus == 1){
				 java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED", "SM");
					results.put("message",(String) message.get("message"));
					result = true;
					message.clear();
					con.commit();
					
					
				}else{
					con.rollback();
					results.put("error","Transaction could not be completed ");
				}

			 }
        }catch(Exception e){
            results.put("er2", e);

        }finally{

           
            if(con != null)      ConnectionManager.returnConnection(con,p);

        }
    }catch(Exception e){
            results.put("er3", e);
    }
        results.put("status",new Boolean(result));
         tabdata.clear();
	    tabdata1.clear();
		return results;
       
	}
}
