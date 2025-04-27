/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS.LocnForWorkplace;

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
*	name="LocnForWorkplace"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="LocnForWorkplace"
*	local-jndi-name="LocnForWorkplace"
*	impl-class-name="eRS.LocnForWorkplace.LocnForWorkplaceManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eRS.LocnForWorkplace.LocnForWorkplaceLocal"
*	remote-class="eRS.LocnForWorkplace.LocnForWorkplaceRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eRS.LocnForWorkplace.LocnForWorkplaceLocalHome"
*	remote-class="eRS.LocnForWorkplace.LocnForWorkplaceHome"
*	generate= "local,remote"
*
*
*/

public class LocnForWorkplaceManager implements SessionBean
{
	Connection con;
    PreparedStatement pstmt;
	String locale				="";

    public LocnForWorkplaceManager(){
    }

    public void ejbCreate() throws CreateException{
    }

    public void ejbRemove(){
    }

    public void ejbActivate(){
    }

    public void ejbPassivate(){
    }

    public void setSessionContext(SessionContext sessioncontext){
    }
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap LocationAddModify(Properties properties, HashMap HashMap) {

        HashMap HashMap1 = new HashMap();
        String modified_by_id = (String)HashMap.get("modified_by_id");
        String modified_facility_id = (String)HashMap.get("modified_facility_id");
        String modified_at_ws_no = (String)HashMap.get("modified_at_ws_no");
        Integer integer = (Integer)HashMap.get("totCount");
        int i = integer.intValue();
        StringBuffer stringbuffer = new StringBuffer();
        String workplace_code = "";
		String facility_id = "";
		String location_type = "";
		workplace_code = (String)HashMap.get("workplace_code");
		facility_id = (String)HashMap.get("facility_id");
		locale = (String)HashMap.get("locale");
	    location_type = (String)HashMap.get("location_type");
        boolean flag1 = true;

        try{
            con = ConnectionManager.getConnection(properties);
            con.setAutoCommit(false);
            String sql_delete = "";
            int j = 0;
            sql_delete = "delete from rs_locn_for_workplace where workplace_code='"+workplace_code+"'  and locn_type='"+location_type+"'";
			
			pstmt = con.prepareStatement(sql_delete);
            j = pstmt.executeUpdate();
            if(j > 0)
                flag1 = true;
            else
                flag1 = false;
			
            for(int k = 0; k < i; k++){

                String locn_code = (String)HashMap.get("chk" + k);
				String sql_insert = "Insert into rs_locn_for_workplace (facility_id,workplace_code,locn_type,locn_code, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values ( ?, ?, ?, ?,?,sysdate, ?, ?, ?, sysdate, ?, ? )";
				pstmt = con.prepareStatement(sql_insert);

                pstmt.setString(1,facility_id);
                pstmt.setString(2, workplace_code);
				pstmt.setString(3, location_type);
				pstmt.setString(4, locn_code);
                pstmt.setString(5, modified_by_id);
                pstmt.setString(6, modified_at_ws_no);
                pstmt.setString(7, modified_facility_id);
                pstmt.setString(8, modified_by_id);
                pstmt.setString(9, modified_at_ws_no);
                pstmt.setString(10, modified_facility_id);

                int l = pstmt.executeUpdate();
				if(pstmt !=null)
					pstmt.close();
                if(l > 0)
                    flag1 = true;
                else
                    flag1 = false;
            }

            if(flag1)
                con.commit();
            else
                con.rollback();

            Hashtable HashMap2 = MessageManager.getMessage(locale, "RECORD_INSERTED","RS");
            stringbuffer.append((String)HashMap2.get("message"));
        }
        catch(Exception exception){
            stringbuffer.append("Error in main try " + exception.getMessage());
			
        }
        finally{
			try{
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					ConnectionManager.returnConnection(con, properties);
			}
			catch(Exception exception2) {
				stringbuffer.append("Error in Close Connection " + exception2.getMessage());
			}
        }
        HashMap1.put("status", new Boolean(flag1));
        HashMap1.put("error", stringbuffer.toString());

		System.err.println("HashMap1---------->"+HashMap1);
        return HashMap1;
    }
}
