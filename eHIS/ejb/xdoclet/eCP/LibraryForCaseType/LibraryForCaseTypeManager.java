/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This File is saved on 18/10/2005.
package eCP.LibraryForCaseType;

import java.sql.*;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Properties;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
/**
*
* @ejb.bean
*	name="LibraryForCaseType"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="LibraryForCaseType"
*	local-jndi-name="LibraryForCaseType"
*	impl-class-name="eCP.LibraryForCaseType.LibraryForCaseTypeManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCP.LibraryForCaseType.LibraryForCaseTypeLocal"
*	remote-class="eCP.LibraryForCaseType.LibraryForCaseTypeRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCP.LibraryForCaseType.LibraryForCaseTypeLocalHome"
*	remote-class="eCP.LibraryForCaseType.LibraryForCaseTypeHome"
*	generate= "local,remote"
*
*
*/
public class LibraryForCaseTypeManager implements SessionBean
{
	Connection con;
    PreparedStatement pstmt;

	 public LibraryForCaseTypeManager()
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
        String modified_by_id = (String)hashtable.get("modified_by_id");
        String modified_facility_id = (String)hashtable.get("modified_facility_id");
        String modified_at_ws_no = (String)hashtable.get("modified_at_ws_no");
        Integer integer = (Integer)hashtable.get("totCount");
		String locale=(String)hashtable.get("locale")==null?"en":(String)hashtable.get("locale");
        int i = integer.intValue();
        StringBuffer stringbuffer = new StringBuffer();
		String case_type_code = "";
        case_type_code = (String)hashtable.get("case_type_code");
		boolean flag1 = true;
        try
        {
			con = ConnectionManager.getConnection(properties);
            con.setAutoCommit(false);
            String sql_delete = "";
            int j = 0;
            sql_delete = "delete from CP_CASE_TYPE_FOR_LIBRARY where  case_type_code='"+case_type_code+"' ";

			pstmt = con.prepareStatement(sql_delete);
            j = pstmt.executeUpdate();
            if(j > 0)
                flag1 = true;
            else
                flag1 = false;
					StringTokenizer st = null;
   			if(pstmt != null) 
			{
				pstmt.close();
				//pstmt = null;
			}


            String sql_insert = "Insert into CP_CASE_TYPE_FOR_LIBRARY (library_id,version_no,case_type_code,  ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values ( ?,?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ? )";

			pstmt = con.prepareStatement(sql_insert);
			String two_val = "";
			String library_id = "";
			String version_no= "";
            for(int k = 0; k < i; k++)
            {
				two_val = (String)hashtable.get("chk" + k);
				st = new StringTokenizer(two_val,"~");
				library_id= st.nextToken();
				version_no= st.nextToken();
                pstmt.setString(1, library_id);
				pstmt.setString(2, version_no);
                pstmt.setString(3, case_type_code);
				pstmt.setString(4, modified_by_id);
                pstmt.setString(5, modified_at_ws_no);
                pstmt.setString(6, modified_facility_id);
                pstmt.setString(7, modified_by_id);
                pstmt.setString(8, modified_at_ws_no);
                pstmt.setString(9, modified_facility_id);
    			

				int l =0;
				try
				{
						l = pstmt.executeUpdate();
						/*if(pstmt != null) 
						{
							pstmt.close();
							pstmt = null;
						}*/
				}
				catch(Exception e)
				{
						System.err.println("error in lib===="+e);
				}
                if(l > 0)
                    flag1 = true;
                else
                    flag1 = false;
            }
			if(flag1)
                con.commit();
            else
                con.rollback();
            Hashtable hashtable2 = MessageManager.getMessage(locale, "RECORD_INSERTED","CP");
            stringbuffer.append((String)hashtable2.get("message"));
			 if(con != null)              
                {
					if(pstmt != null) 
					{
						pstmt.close();
						//pstmt = null;
					}
                    if(con != null)
                        ConnectionManager.returnConnection(con, properties);
                }
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
                catch(Exception exception2) {System.err.println(exception2.toString()); }
        }
        hashtable1.put("status", new Boolean(flag1));
        hashtable1.put("error", stringbuffer.toString());
        return hashtable1;
    }
}
