/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 //This file is saved on 21/12/2005.

package eCP.AssessBasedDepClassification;

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
*	name="AssessBasedDepClassification"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AssessBasedDepClassification"
*	local-jndi-name="AssessBasedDepClassification"
*	impl-class-name="eCP.AssessBasedDepClassification.AssessBasedDepClassificationManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCP.AssessBasedDepClassification.AssessBasedDepClassificationLocal"
*	remote-class="eCP.AssessBasedDepClassification.AssessBasedDepClassificationRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCP.AssessBasedDepClassification.AssessBasedDepClassificationLocalHome"
*	remote-class="eCP.AssessBasedDepClassification.AssessBasedDepClassificationHome"
*	generate= "local,remote"
*
*
*/
public class AssessBasedDepClassificationManager implements SessionBean
{
    Connection con=null;
    PreparedStatement pstmt=null;

    public AssessBasedDepClassificationManager()
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
    public HashMap AddModify(Properties properties, HashMap hashtable)
    {
        HashMap hashtable1 = new HashMap();
        String modified_by_id = (String)hashtable.get("modified_by_id");
        String modified_at_ws_no = (String)hashtable.get("modified_at_ws_no");
		String locale=(String)hashtable.get("locale")==null?"en":(String)hashtable.get("locale");
		String facilityId="";
        String dependency_code="";
        String min_score="";
    	String sql_insert = "";
		facilityId = (String)hashtable.get( "facilityId" ) ;
        Integer integer = (Integer)hashtable.get("totCount");
        int i = integer.intValue();
        StringBuffer stringbuffer = new StringBuffer();
        String assess_note_id = "";
        assess_note_id = (String)hashtable.get("assess_note_id");
        boolean flag1 = true;

        try
        {
            con = ConnectionManager.getConnection(properties);
            con.setAutoCommit(false);
            String sql_delete = "";
            int j = 0;
			int l=0;
			int k = 0;
			try
			{
            sql_delete = "delete from cp_trgd_dep_clsfn_at_assmt where  assess_note_id=?";

            pstmt = con.prepareStatement(sql_delete);
			pstmt.setString(1,assess_note_id);
            j = pstmt.executeUpdate();
			}
			catch(Exception exp)
			{
   			 stringbuffer.append("Error while Deleting " + exp.getMessage());
			}

			if(pstmt!=null) 
			{
				pstmt.close();
				pstmt = null;
			}

            if(j > 0)
                flag1 = true;
            else
                flag1 = false;

			try
			{
				sql_insert = "insert into cp_trgd_dep_clsfn_at_assmt values (?, ?, ?, ?,  SYSDATE, ?, ?, ?, SYSDATE, ?, ? )";
                pstmt = con.prepareStatement(sql_insert);
		    for(k = 0; k <i; k++)
            {
                dependency_code = (String)hashtable.get("chk" + k);
				min_score=(String)hashtable.get("minScore" + k);
                pstmt.setString(1, assess_note_id);
                pstmt.setString(2, dependency_code);
                pstmt.setString(3, min_score);
                pstmt.setString(4, modified_by_id);
                pstmt.setString(5, modified_at_ws_no);
                pstmt.setString(6, facilityId);
                pstmt.setString(7, modified_by_id);
                pstmt.setString(8, modified_at_ws_no);
                pstmt.setString(9, facilityId);
                l = pstmt.executeUpdate();

				if(l > 0)
				   flag1 = true;
				else
				{
				    flag1 = false;
					break;
				}
            }
			}
			catch(Exception exp)
			{
               stringbuffer.append("Error while Inserting" + exp.getMessage());
			}

            if(flag1)
                con.commit();
            else
                con.rollback();

            Hashtable hashtable2 = MessageManager.getMessage(locale, "RECORD_INSERTED","CP");
            stringbuffer.append((String)hashtable2.get("message"));
        }
        catch(Exception exception)
        {
            stringbuffer.append("Error in main try block" + exception.getMessage());
        }
        finally
        {
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
                catch(Exception exception2) 
				{ 
					stringbuffer.append("Error in finally block " + exception2.getMessage());
				}
        }
        hashtable1.put("status", new Boolean(flag1));
        hashtable1.put("error", stringbuffer.toString());
        return hashtable1;
    }
}
