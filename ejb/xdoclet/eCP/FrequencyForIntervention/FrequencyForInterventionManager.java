/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This file is saved on 01/12/2005.

package eCP.FrequencyForIntervention;

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
*	name="FrequencyForIntervention"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="FrequencyForIntervention"
*	local-jndi-name="FrequencyForIntervention"
*	impl-class-name="eCP.FrequencyForIntervention.FrequencyForInterventionManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCP.FrequencyForIntervention.FrequencyForInterventionLocal"
*	remote-class="eCP.FrequencyForIntervention.FrequencyForInterventionRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCP.FrequencyForIntervention.FrequencyForInterventionLocalHome"
*	remote-class="eCP.FrequencyForIntervention.FrequencyForInterventionHome"
*	generate= "local,remote"
*
*
*/

public class FrequencyForInterventionManager implements SessionBean
{
	Connection con;
    PreparedStatement pstmt;

    public FrequencyForInterventionManager()
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
    public HashMap SpecialityAddModify(Properties properties, HashMap hashtable)
    {
        HashMap hashtable1 = new HashMap();
		String intervention_code="";
		  String locale="";
		String sql_insert="";
		String sql_delete="";

        String modified_by_id = (String)hashtable.get("modified_by_id");
		
        String modified_facility_id = (String)hashtable.get("modified_facility_id");
		
        String modified_at_ws_no = (String)hashtable.get("modified_at_ws_no");
		 locale=(String)hashtable.get("locale");
		int j=0,l=0;

		int i = Integer.parseInt((String)hashtable.get("totCount"));

        StringBuffer stringbuffer = new StringBuffer();
        String frequency_code = "";
        frequency_code = (String)hashtable.get("frequency_code");

		sql_insert = "insert into ca_intervention_freq(intervention_code,freq_code,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) values ( ?,?,?,sysdate,?,?,?,sysdate,?,?)";
        sql_delete = "delete from ca_intervention_freq where freq_code=?";

		boolean flag1 = true;
        try
        {
            con = ConnectionManager.getConnection(properties);
            con.setAutoCommit(false);
           
			try
			{
			pstmt = con.prepareStatement(sql_delete);
			pstmt.setString(1,frequency_code);
            j = pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				System.err.println("Exception while deleting"+e.toString());
			}

   			if(pstmt != null) 
			{
				pstmt.close();
				pstmt = null;
			}

          
			try
			{
				if(i>0)
				{
					pstmt = con.prepareStatement(sql_insert);
					for(int k = 0; k < i; k++)
					{
						intervention_code = (String)hashtable.get("chk" + k);
					

						pstmt.setString(1,intervention_code);
						pstmt.setString(2,frequency_code);
						pstmt.setString(3,modified_by_id);
						pstmt.setString(4,modified_at_ws_no);
						pstmt.setString(5,modified_facility_id);
						pstmt.setString(6,modified_by_id);
						pstmt.setString(7,modified_at_ws_no);
						pstmt.setString(8,modified_facility_id);

						l = pstmt.executeUpdate();
					}
				}
			}
			catch(Exception exp)
			{
				System.err.println("Exception while inserting"+exp.toString());
			}

   			if(pstmt != null) 
			{
				pstmt.close();
				pstmt = null;
			}
			if(j>=0 || l>=0)
				flag1=true;
			else
				flag1=false;

			if(flag1)
                con.commit();
            else
                con.rollback();
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
						pstmt = null;
					}
                    if(con != null)
                        ConnectionManager.returnConnection(con, properties);
                }
                catch(Exception exception2) { 				
					System.err.println(exception2.toString());
				}
        }
        hashtable1.put("status", new Boolean(flag1));
        hashtable1.put("error", stringbuffer.toString());
        return hashtable1;
    }
}
