/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM.FacilityDept;

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
*	name="FacilityDept"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="FacilityDept"
*	local-jndi-name="FacilityDept"
*	impl-class-name="eAM.FacilityDept.FacilityDeptManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eAM.FacilityDept.FacilityDeptLocal"
*	remote-class="eAM.FacilityDept.FacilityDeptRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eAM.FacilityDept.FacilityDeptLocalHome"
*	remote-class="eAM.FacilityDept.FacilityDeptHome"
*	generate= "local,remote"
*
*
*/

public class FacilityDeptManager implements SessionBean{

    Connection con  ;
    PreparedStatement pslPrepStmt = null;
    ResultSet rset ;
    //SessionContext ctx;

    public void ejbCreate(){}
    public void ejbRemove(){}
    public void ejbActivate(){}
    public void ejbPassivate(){}

    public void setSessionContext(SessionContext context )
	{
       context=context;//for avoiding PMD violation
    }

/**
* @ejb.interface-method
*	 view-type="both"
*/
    public HashMap updateFacilityDept(HashMap tabdata)  
	{
		Properties p = (Properties) tabdata.get("p");
		HashMap results = new HashMap();
		boolean result = false;
		try
		{
			con = ConnectionManager.getConnection(p);
			String locale="";
			locale= p.getProperty("LOCALE");
			String added_by_id = (String)tabdata.get("modified_by_id");
			String modifiedFacilityId = (String)tabdata.get("modified_facility_id");
			String client_ip_address = (String)tabdata.get("modified_at_ws_no");
			Integer totCount = (Integer)tabdata.get("totCount");
			int totalCount = totCount.intValue();

			int ilStatus = 0;
			StringBuffer sblQry = new StringBuffer();
			String opfacilityid="";
			opfacilityid = (String) tabdata.get("operating_facility_id");

			String  old_dept_code="";String enabled="";

			sblQry.append("select dept_code  FROM am_facility_dept  where OPERATING_FACILITY_ID ='"+opfacilityid+"'  " );
			pslPrepStmt = con.prepareStatement(sblQry.toString());
			 rset= pslPrepStmt.executeQuery();
			sblQry = new StringBuffer();
			if(pslPrepStmt!=null)pslPrepStmt.close();

			//try
			//{
				while(rset.next())
				{
					old_dept_code= rset.getString(1);
					if (totalCount != 0)
					{
						ilStatus=0;
						for(int i=0; i<totalCount; i++){
							enabled = (String)tabdata.get("enabled"+i);
							if(old_dept_code.equalsIgnoreCase(enabled)){
								sblQry.append("INSERT INTO am_facility_dept  ");
								sblQry.append("(OPERATING_FACILITY_ID, DEPT_CODE,EFF_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ");
								sblQry.append("ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID )");
								sblQry.append("VALUES (");
								sblQry.append("'"+opfacilityid+"', '"+enabled+"','E', '"+ added_by_id +"', sysdate ,'"+ client_ip_address +"', ");
								sblQry.append("'"+ modifiedFacilityId +"', '"+ added_by_id +"', sysdate ,'"+ client_ip_address +"','"+ modifiedFacilityId +"') ");
							}else{
								sblQry.append("update am_facility_dept set EFF_STATUS='D' ,MODIFIED_BY_ID='"+added_by_id+"',MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+client_ip_address+"',MODIFIED_FACILITY_ID='"+modifiedFacilityId+"'  where OPERATING_FACILITY_ID ='"+opfacilityid +"'  and DEPT_CODE='"+old_dept_code+"' ");
							}
							pslPrepStmt = con.prepareStatement(sblQry.toString());
							ilStatus = pslPrepStmt.executeUpdate();
						}if(pslPrepStmt != null){ pslPrepStmt.close();
					}
				}
                
				if(ilStatus == 1){
					java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_INSERTED" ,"SM") ;
					results.put("message",(String) message.get("message"));
					result = true;
					message.clear();
					con.commit();
				}else{
					con.rollback();
					results.put("error","Transaction could not be completed ");
				}
				
				 }if(rset != null) rset.close();
				 tabdata.clear();
				 if(con != null)   ConnectionManager.returnConnection(con,p);
			
		}catch(Exception e){
				results.put("er2", e);
			}finally{
				if(con != null)   ConnectionManager.returnConnection(con,p);
			}
		results.put("status",new Boolean(result));
		return results;
	}
}
