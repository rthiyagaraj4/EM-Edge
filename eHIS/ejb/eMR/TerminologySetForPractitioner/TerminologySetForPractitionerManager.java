/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR.TerminologySetForPractitioner;

import java.rmi.RemoteException;
import java.sql.*;
import java.util.*;
import java.util.Properties;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="TerminologySetForPractitioner"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="TerminologySetForPractitioner"
*	local-jndi-name="TerminologySetForPractitioner"
*	impl-class-name="eMR.TerminologySetForPractitioner.TerminologySetForPractitionerManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eMR.TerminologySetForPractitioner.TerminologySetForPractitionerLocal"
*	remote-class="eMR.TerminologySetForPractitioner.TerminologySetForPractitionerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMR.TerminologySetForPractitioner.TerminologySetForPractitionerLocalHome"
*	remote-class="eMR.TerminologySetForPractitioner.TerminologySetForPractitionerHome"
*	generate= "local,remote"
*
*
*/

public class TerminologySetForPractitionerManager implements SessionBean
{
	Connection con;
    PreparedStatement pstmt;
    PreparedStatement pstmtDel;

    public TerminologySetForPractitionerManager()
    {
    }

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
        HashMap hashmap1 = new HashMap();
        String modified_by_id = (String)hmap.get("modified_by_id");
        String modified_facility_id = (String)hmap.get("modified_facility_id");
        String modified_at_ws_no = (String)hmap.get("modified_at_ws_no");
        Integer integer = (Integer)hmap.get("totCount");
		String locale			=	properties.getProperty("LOCALE");
        int i = integer.intValue();
        
        StringBuffer stringbuffer = new StringBuffer();
        String term_set_id = "";
		String pract_type="";
        term_set_id = (String)hmap.get("term_set_id");
		pract_type = (String)hmap.get("pract_type");
		if(pract_type==null) pract_type="";
        boolean flag1 = true;
		RecordSet	TerminologyForPractitioner1	=	null;
		TerminologyForPractitioner1	=	(webbeans.eCommon.RecordSet)hmap.get("recordSet");
		for(int ij=0;ij<TerminologyForPractitioner1.getSize();ij++){
			try{
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
        try
        {
            con = ConnectionManager.getConnection(properties);
            con.setAutoCommit(false);
            String sql_delete = "";
            int j = 0;
            sql_delete = "delete from mr_term_set_for_pract where  term_set_id='"+term_set_id+"' and practitioner_id in(select practitioner_id from am_practitioner where pract_type=nvl('"+pract_type+"',pract_type))";
            pstmtDel = con.prepareStatement(sql_delete);
            j = pstmtDel.executeUpdate();
	        if(pstmtDel != null) pstmtDel.close();

            if(j > 0)
                flag1 = true;
            else
                flag1 = false;

            for(int k = 0; k < i; k++)
            {
                //String practitioner_id = (String)hmap.get("chk" + k);
				 String practitioner_id = (String)hmap.get("chk" + k)==null?"":(String)hmap.get("chk" + k);
                String sql_insert = "Insert into mr_term_set_for_pract (practitioner_id, term_set_id, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,dflt_term_set_yn) values ( ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?,? )";
			    pstmt = con.prepareStatement(sql_insert);

                pstmt.setString(1, practitioner_id);
                pstmt.setString(2, term_set_id);
                pstmt.setString(3, modified_by_id);
                pstmt.setString(4, modified_at_ws_no);
                pstmt.setString(5, modified_facility_id);
                pstmt.setString(6, modified_by_id);
                pstmt.setString(7, modified_at_ws_no);
                pstmt.setString(8, modified_facility_id);
				if(!(TerminologyForPractitioner1.containsObject(practitioner_id))){
					pstmt.setString(9, "N");
				}else{
					pstmt.setString(9, "Y");
				}
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

            if(flag1){
                con.commit();
			}
            else{
                con.rollback();
				flag1 = true;
			}

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
        hashmap1.put("status", new Boolean(flag1));
        hashmap1.put("error", stringbuffer.toString());
        return hashmap1;
    }
}
