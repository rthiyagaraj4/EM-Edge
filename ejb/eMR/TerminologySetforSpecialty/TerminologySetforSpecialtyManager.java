/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR.TerminologySetforSpecialty;

import java.rmi.RemoteException;
import java.sql.*;
import java.util.*;
import java.util.Properties;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

/**
*
* @ejb.bean
*	name="TerminologySetforSpecialty"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="TerminologySetforSpecialty"
*	local-jndi-name="TerminologySetforSpecialty"
*	impl-class-name="eMR.TerminologySetforSpecialty.TerminologySetforSpecialtyManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eMR.TerminologySetforSpecialty.TerminologySetforSpecialtyLocal"
*	remote-class="eMR.TerminologySetforSpecialty.TerminologySetforSpecialtyRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMR.TerminologySetforSpecialty.TerminologySetforSpecialtyLocalHome"
*	remote-class="eMR.TerminologySetforSpecialty.TerminologySetforSpecialtyHome"
*	generate= "local,remote"
*
*
*/

public class TerminologySetforSpecialtyManager implements SessionBean
{
	Connection con;
    PreparedStatement pstmt;

    public TerminologySetforSpecialtyManager()
    {}

    public void ejbCreate()
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

    public HashMap SpecialityAddModify(Properties properties, HashMap hmap)
    {
        HashMap hmap1 = new HashMap();
        String modified_by_id = (String)hmap.get("modified_by_id");
        String modified_facility_id = (String)hmap.get("modified_facility_id");
        String modified_at_ws_no = (String)hmap.get("modified_at_ws_no");
        Integer integer = (Integer)hmap.get("totCount");
		String locale=properties.getProperty("LOCALE");
        int i = integer.intValue();
        
        StringBuffer stringbuffer = new StringBuffer();
        String term_set_id = "";
       term_set_id = (String)hmap.get("term_set_id");
	
        boolean flag1 = true;
        try
        {
            con = ConnectionManager.getConnection(properties);
            con.setAutoCommit(false);
            String sql_delete = "";
            int j = 0;
            sql_delete = "delete from mr_term_set_for_specialty where term_set_id='"+term_set_id+"' ";
			pstmt = con.prepareStatement(sql_delete);
            j = pstmt.executeUpdate();
			pstmt.close();
            
			if(j > 0)
                flag1 = true;
            else
                flag1 = false;
            
			for(int k = 0; k < i; k++)
            {
                String specialty_code = (String)hmap.get("chk" + k);
				

                String sql_insert = "Insert into mr_term_set_for_specialty (specialty_code, term_set_id, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values ( ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ? )";
			    pstmt = con.prepareStatement(sql_insert);

                pstmt.setString(1, specialty_code);
                pstmt.setString(2, term_set_id);
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
				if(pstmt != null) pstmt.close();
            }

            if(flag1)
                con.commit();
            else
                con.rollback();
            Hashtable hashtable2 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
            stringbuffer.append((String)hashtable2.get("message"));
			if ( hashtable2 != null ) hashtable2.clear();
        }
        catch(Exception exception)
        {
            stringbuffer.append("Error in main try " + exception.getMessage());
        }
        finally
        {
                    if(con != null)
                        ConnectionManager.returnConnection(con, properties);
       }
        hmap1.put("status", new Boolean(flag1));
        hmap1.put("error", stringbuffer.toString());
        return hmap1;
    }

    
}
