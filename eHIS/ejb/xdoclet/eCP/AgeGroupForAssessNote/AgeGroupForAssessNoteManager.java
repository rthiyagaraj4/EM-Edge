/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This file is saved on 18/10/2005.
package eCP.AgeGroupForAssessNote;

import java.sql.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
/**
*
* @ejb.bean
*	name="AgeGroupForAssessNote"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AgeGroupForAssessNote"
*	local-jndi-name="AgeGroupForAssessNote"
*	impl-class-name="eCP.AgeGroupForAssessNote.AgeGroupForAssessNoteManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCP.AgeGroupForAssessNote.AgeGroupForAssessNoteLocal"
*	remote-class="eCP.AgeGroupForAssessNote.AgeGroupForAssessNoteRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCP.AgeGroupForAssessNote.AgeGroupForAssessNoteLocalHome"
*	remote-class="eCP.AgeGroupForAssessNote.AgeGroupForAssessNoteHome"
*	generate= "local,remote"
*
*
*/
public class AgeGroupForAssessNoteManager implements SessionBean
{
	Connection con;
    PreparedStatement pstmt;

    public AgeGroupForAssessNoteManager()
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
        HashMap hashtable1		= new HashMap();
        String modified_by_id		= (String)hashtable.get("modified_by_id");
        String modified_facility_id = (String)hashtable.get("modified_facility_id");
        String modified_at_ws_no	= (String)hashtable.get("modified_at_ws_no");
        Integer integer				= (Integer)hashtable.get("totCount");
		String locale=(String)hashtable.get("locale")==null?"en":(String)hashtable.get("locale");
        
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
            sql_delete = "delete from CP_ASSESS_NOTE_AGE_GROUP where  assess_note_id='"+assess_note_id+"' ";

			pstmt = con.prepareStatement(sql_delete);
            j = pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;
            
			if(j > 0)
                flag1 = true;
            else
                flag1 = false;
			 String sql_insert = "Insert into CP_ASSESS_NOTE_AGE_GROUP (age_group_code, assess_note_id, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values ( ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ? )";
			    pstmt = con.prepareStatement(sql_insert);

            for(int k = 0; k < i; k++)
            {
                String age_group_code = (String)hashtable.get("chk" + k);

               // String sql_insert = "Insert into CP_ASSESS_NOTE_AGE_GROUP (age_group_code, assess_note_id, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values ( ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ? )";
			   // pstmt = con.prepareStatement(sql_insert);

                pstmt.setString(1, age_group_code);
                pstmt.setString(2, assess_note_id);
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
			if(con != null)
			{
				 if(pstmt != null)
					{
                        pstmt.close();
					}
                    if(con != null)
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
                    if(con != null)
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
