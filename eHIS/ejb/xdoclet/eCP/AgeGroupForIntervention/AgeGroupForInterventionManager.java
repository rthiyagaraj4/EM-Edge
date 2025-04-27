/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This File is saved on 18/10/2005.
package eCP.AgeGroupForIntervention;
			
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
*	name="AgeGroupForIntervention"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AgeGroupForIntervention"
*	local-jndi-name="AgeGroupForIntervention"
*	impl-class-name="eCP.AgeGroupForIntervention.AgeGroupForInterventionManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCP.AgeGroupForIntervention.AgeGroupForInterventionLocal"
*	remote-class="eCP.AgeGroupForIntervention.AgeGroupForInterventionRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCP.AgeGroupForIntervention.AgeGroupForInterventionLocalHome"
*	remote-class="eCP.AgeGroupForIntervention.AgeGroupForInterventionHome"
*	generate= "local,remote"
*
*
*/

public class  AgeGroupForInterventionManager implements SessionBean
{
	Connection con;
    PreparedStatement pstmt;

    public AgeGroupForInterventionManager()
    {
    }

    public void ejbCreate()
        throws  CreateException
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
    public HashMap SpecialityAddModify(Properties properties, HashMap hashtable)
    {
		
        HashMap hashtable1 = new HashMap();
        String locale="";
		String modified_by_id = (String)hashtable.get("modified_by_id");
        String modified_facility_id = (String)hashtable.get("modified_facility_id");
        String modified_at_ws_no = (String)hashtable.get("modified_at_ws_no");
        locale=(String)hashtable.get("locale");
		Integer integer = (Integer)hashtable.get("totCount");
        int i = integer.intValue();
		StringBuffer stringbuffer = new StringBuffer();
        String age_group_code = "";
        age_group_code = (String)hashtable.get("age_group_code");
        boolean flag1 = true;
        try
        {
            con = ConnectionManager.getConnection(properties);
            con.setAutoCommit(false);
            String sql_delete = "";
            int j = 0;
            sql_delete = "delete from CA_AGE_GRP_FOR_INTERVENTION where  age_group_code=?";
            pstmt = con.prepareStatement(sql_delete);
			pstmt.setString(1,age_group_code);
            j = pstmt.executeUpdate();
			 if(pstmt != null)
			{
				pstmt.close();
			}
			//pstmt = null;
            if(j > 0)
                flag1 = true;
            else
                flag1 = false;

			String sql_insert = "Insert into CA_AGE_GRP_FOR_INTERVENTION (age_group_code,intervention_code,  ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values ( ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ? )";
			pstmt = con.prepareStatement(sql_insert);
            String intervention_code = "";
			for(int k = 0; k < i; k++)
            {
                intervention_code = (String)hashtable.get("chk" + k);
                pstmt.setString(1, age_group_code);
                pstmt.setString(2, intervention_code);
                pstmt.setString(3, modified_by_id);
                pstmt.setString(4, modified_at_ws_no);
                pstmt.setString(5, modified_facility_id);
                pstmt.setString(6, modified_by_id);
                pstmt.setString(7, modified_at_ws_no);
                pstmt.setString(8, modified_facility_id);
                int l = pstmt.executeUpdate();
				if(l > 0)
                    flag1 = true;
                else
				{
                    flag1 = false;
					break;
				}
            }
			
            if(flag1)
                con.commit();
            else
                con.rollback();
			 if(pstmt != null)
			{
                        pstmt.close();					
			}   
		   	 if(con != null)
			{
					 ConnectionManager.returnConnection(con, properties);
			}

           Hashtable hashtable2 = MessageManager.getMessage(locale, "RECORD_INSERTED","CP");

			stringbuffer.append((String)hashtable2.get("message"));
				
        }
        catch(Exception exception)
        {
            stringbuffer.append("Error in main try " + exception.getMessage());
        }
        finally
        {
            if(con != null)
                try
                {
                    if(pstmt != null)
					{
                        pstmt.close();
						//pstmt = null;
					}                  
                        ConnectionManager.returnConnection(con, properties);
                }
                catch(Exception exception2) 
				{ 
					stringbuffer.append("Error in final try " + exception2.getMessage());
				}
        }
        hashtable1.put("status", new Boolean(flag1));
        hashtable1.put("error", stringbuffer.toString());
        return hashtable1;
    }
}
