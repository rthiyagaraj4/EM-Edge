/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR.FactorsForTermCode;
import java.rmi.RemoteException;
import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

/**
*
* @ejb.bean
*	name="FactorsForTermCode"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="FactorsForTermCode"
*	local-jndi-name="FactorsForTermCode"
*	impl-class-name="eMR.FactorsForTermCode.FactorsForTermCodeManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eMR.FactorsForTermCode.FactorsForTermCodeLocal"
*	remote-class="eMR.FactorsForTermCode.FactorsForTermCodeRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMR.FactorsForTermCode.FactorsForTermCodeLocalHome"
*	remote-class="eMR.FactorsForTermCode.FactorsForTermCodeHome"
*	generate= "local,remote"
*
*
*/

public class FactorsForTermCodeManager implements SessionBean
{
	Connection con = null;
    PreparedStatement pstmt = null;
 	StringBuffer stringbuffer = new StringBuffer();
   public FactorsForTermCodeManager()
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

    public HashMap AddModify(Properties properties, HashMap hashmap)
	{
		HashMap tempHash = new HashMap();
		ArrayList arr_fact = new ArrayList();
		String factor_code = "";	
		String defn_characteristic_yn = "";	
		String related_factor_yn = "";	
		String risk_factor_yn = "";	
		try
		{
			con = ConnectionManager.getConnection(properties);
            con.setAutoCommit(false);
			// Queries for deleting and inserting into mr_factor_for_term_code.
			String sql_delete = "delete from mr_factor_for_term_code where term_set_id=? and term_code=?";
			String sql_insert = "insert into mr_factor_for_term_code (term_set_id,term_code,factor_code,defn_characteristic_yn,related_factor_yn,risk_factor_yn,eff_status,added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values (?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			// End of Queries 
			arr_fact = (ArrayList) hashmap.get("ARR_MAIN");
			String term_set_id = (String) hashmap.get("TERM_SET_ID");
			String term_code= (String) hashmap.get("TERM_CODE");
			String added_by_id = (String) hashmap.get("ADDED_BY_ID");
			String added_at_ws_no = (String) hashmap.get("ADDED_AT_WS_NO");
			String added_facility_id = (String) hashmap.get("ADDED_FACILITY_ID");
			String modified_by_id = (String) hashmap.get("MODIFIED_BY_ID");
			String modified_at_ws_no = (String) hashmap.get("MODIFIED_AT_WS_NO");
			String modified_facility_id = (String) hashmap.get("MODIFIED_FACILITY_ID");
			pstmt = con.prepareStatement(sql_delete);
			pstmt.setString(1,term_set_id);
			pstmt.setString(2,term_code);
			pstmt.executeUpdate();
			pstmt = null;
			pstmt = con.prepareStatement(sql_insert);
			for(int i=0;i<arr_fact.size();i+=4)
			{
				factor_code = (String) arr_fact.get(i);
				defn_characteristic_yn = (String) arr_fact.get(i+1);
				related_factor_yn = (String) arr_fact.get(i+2);
				risk_factor_yn = (String) arr_fact.get(i+3);
				pstmt.setString(1,term_set_id);
				pstmt.setString(2,term_code);
				pstmt.setString(3,factor_code);
				pstmt.setString(4,defn_characteristic_yn);
				pstmt.setString(5,related_factor_yn);
				pstmt.setString(6,risk_factor_yn);
				pstmt.setString(7,"E");
				pstmt.setString(8,added_by_id);
				pstmt.setString(9,added_at_ws_no);
				pstmt.setString(10,added_facility_id);
				pstmt.setString(11,modified_by_id);
				pstmt.setString(12,modified_at_ws_no);
				pstmt.setString(13,modified_facility_id);
				pstmt.executeUpdate();
			}
			pstmt.close();
			con.commit();
			tempHash.put("status",new Boolean(true));
			tempHash.put("error",stringbuffer.toString());
		}
        catch(Exception exception)
        {
            stringbuffer.append("Error in main try " + exception.getMessage());
			exception.printStackTrace();
			tempHash.put("status",new Boolean(false));
			tempHash.put("error",stringbuffer.toString());
			try
			{
				con.rollback();
			}
			catch(Exception es)
			{
				es.printStackTrace();		
			}
        }
        finally
        {   
			if ( arr_fact != null ) arr_fact.clear();
			try
			{
				if(pstmt!=null) pstmt.close();
				if(con != null)ConnectionManager.returnConnection(con, properties);
			}
			catch(Exception exception2) 
			{
			}
        }
		return tempHash;
    }
}
