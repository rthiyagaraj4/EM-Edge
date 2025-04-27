/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
This ejb is used to insert or delete day care unit.
@author - 
@version - V3
*/

package eIP.IPDayCareUnit;

import java.rmi.RemoteException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
/**
*
* @ejb.bean
*	name="IPDayCareUnit"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPDayCareUnit"
*	local-jndi-name="IPDayCareUnit"
*	impl-class-name="eIP.IPDayCareUnit.IPDayCareUnitManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPDayCareUnit.IPDayCareUnitLocal"
*	remote-class="eIP.IPDayCareUnit.IPDayCareUnitRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPDayCareUnit.IPDayCareUnitLocalHome"
*	remote-class="eIP.IPDayCareUnit.IPDayCareUnitHome"
*	generate= "local,remote"
*
*
*/
public class IPDayCareUnitManager implements SessionBean
{
    Connection con = null;
	Statement stmt = null;
	ResultSet rset = null;
    PreparedStatement pstmt; 
    SessionContext ctx;

    public void ejbCreate() {}
    public void ejbRemove() {}
    public void ejbActivate(){}
    public void ejbPassivate(){}

    public void setSessionContext(SessionContext sessioncontext)
    {
        ctx = sessioncontext;
    }

	/*
	This method is used to add or delete the DayCare Units for Nursing Unit
	@author - 
	@version - V3
	@param1 - java.util.Properties
	@param2 - java.util.HashMap
	@return - java.util.HashMap
	*/
/**
* @ejb.interface-method
*	 view-type="both"
*/
    public HashMap DayCareUnitAddModify(Properties properties, HashMap hashmap)
    {
		String locale = properties.getProperty("LOCALE");
        HashMap hashmap1			= new HashMap();
        String modifiedbyid			= (String)hashmap.get("modified_by_id");
        String modifiedatwsno		= (String)hashmap.get("modified_at_ws_no");
        Integer integer				= (Integer)hashmap.get("totCount");
        int count					= integer.intValue();//the total count of records
        StringBuffer stringbuffer	= new StringBuffer();
        String nursing_unit_code	= "";
        nursing_unit_code			= (String)hashmap.get("nursing_unit_code");
        String facilityId			= (String)hashmap.get("FACILITY_ID");
		String search_by			= (String)hashmap.get("search_by");
		String search_txt			= (String)hashmap.get("search_txt");
		String search_criteria		=  "";
        boolean flag1				= true;
        try
        {

		con = ConnectionManager.getConnection(properties);
		con.setAutoCommit(false);
		StringBuffer sql_delete	= new StringBuffer();
		StringBuffer sql	= new StringBuffer();
		String n_code				= "";
		String n_code_list			= "";

        int j = 0;
		  
		if(search_by != null && !search_by.equals("00"))
		{
			if(search_txt != null && !search_txt.equals(""))
			{
				if(search_by.equals("01"))
					search_criteria  = " and UPPER(CLINIC_CODE) like UPPER('"+search_txt+"%') ";
				else if(search_by.equals("02"))
					search_criteria  = " and UPPER(CLINIC_SHORT_DESC) like UPPER('"+search_txt+"%')  ";
			}
		}

		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append( " select clinic_code from IP_DC_UNIT_FOR_NURS_UNIT_VW where NURSING_UNIT_CODE='"+nursing_unit_code+"' and FACILITY_ID='"+facilityId+"' ");
		sql.append(search_criteria);

		stmt=con.createStatement();
		rset = stmt.executeQuery(sql.toString());

		boolean first_time = true;
		while(rset.next())
		{
			n_code = rset.getString("clinic_code");
	
			if(first_time)
			   n_code_list = "('"+n_code+"'" ;
			else
				n_code_list = n_code_list + ",'" +n_code +"'";

			first_time = false;
		}

		if(!first_time)
			n_code_list = n_code_list + ")";

		if(n_code_list.equals(""))
			n_code_list = "('')";

		if(stmt!=null)   stmt.close();
		if(rset!=null) rset.close();

		if(sql_delete.length() > 0) sql_delete.delete(0,sql_delete.length());
	    sql_delete.append("delete from ip_dc_unit_for_nurs_unit where  nursing_unit_code='" + nursing_unit_code + "' and FACILITY_ID ='" + facilityId + "' ");
		sql_delete.append(" and CLINIC_CODE in "); 
		sql_delete.append(n_code_list); 

	    pstmt = con.prepareStatement(sql_delete.toString());
        j = pstmt.executeUpdate();

		if(j > 0)
			flag1 = true;
		else
			flag1 = false;

		String clinic_code	= "";
		StringBuffer sql1	= new StringBuffer();
		sql1.append("Insert into ip_dc_unit_for_nurs_unit (FACILITY_ID, NURSING_UNIT_CODE, CLINIC_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ) values (?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ? ) ");
		if(pstmt!=null) pstmt.close();
		pstmt = con.prepareStatement(sql1.toString());
		for(int k = 0; k < count; k++)
		{
			clinic_code = (String)hashmap.get("chk" + k);
			pstmt.setString(1, facilityId);
			pstmt.setString(2, nursing_unit_code);
			pstmt.setString(3, clinic_code);
			pstmt.setString(4, modifiedbyid);
			pstmt.setString(5, modifiedatwsno);
			pstmt.setString(6, facilityId);
			pstmt.setString(7, modifiedbyid);
			pstmt.setString(8, modifiedatwsno);
			pstmt.setString(9, facilityId);
			int l = pstmt.executeUpdate();

			if(l > 0)
				flag1 = true;
			else
				flag1 = false;

		}

			hashmap.clear();
			if(flag1)
                con.commit();
            else
                con.rollback();
			
			if(pstmt!=null) pstmt.close();
            Hashtable hashtable2 = MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
            stringbuffer.append((String)hashtable2.get("message"));
			hashtable2.clear();
	
		}catch(Exception exception)
        {
            stringbuffer.append("Error in main try " + exception.getMessage());
			exception.printStackTrace();
        }
        finally
        {
			try
			{
				if(pstmt != null)  pstmt.close();
			}
			catch(Exception exception2) { }
			if(con != null)    ConnectionManager.returnConnection(con, properties);
        }
        hashmap1.put("status", new Boolean(flag1));
        hashmap1.put("error", stringbuffer.toString());
        return hashmap1;
    }
}
