/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA.SplChartKey;

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
*	name="SplChartKey"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="SplChartKey"
*	local-jndi-name="SplChartKey"
*	impl-class-name="eCA.SplChartKey.SplChartKeyManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCA.SplChartKey.SplChartKeyLocal"
*	remote-class="eCA.SplChartKey.SplChartKeyRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.SplChartKey.SplChartKeyLocalHome"
*	remote-class="eCA.SplChartKey.SplChartKeyHome"
*	generate= "local,remote"
*
*
*/

public class SplChartKeyManager implements SessionBean {
    Connection con;
    PreparedStatement pstmt;
    SessionContext ctx;
	ResultSet rset;
    
	public SplChartKeyManager() 
	{
		con = null;
	    pstmt = null;
		ctx = null;
		rset = null;
    }

    public void ejbCreate() {
    }

    public void ejbRemove() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void setSessionContext(SessionContext sessioncontext) {
        ctx = sessioncontext;
    }

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap insertSplChartKey(Properties properties, HashMap map)
    {
	    HashMap map1 = new HashMap();
        boolean flag = true;
		
		StringBuffer sb = new StringBuffer();

		String error	=	"";
		String locale	=	"";
		
		try 
		{
			
			con = ConnectionManager.getConnection(properties);
			
			String addedById		= (String)map.get("added_by_id");
            String addedFacilityId  = (String)map.get("added_facility_id");
            String addedAtWsNo	    = (String)map.get("added_at_ws_no");
			String splChartType 	= (String)map.get("spl_chart_type");
			String splChartGroup 	= (String)map.get("spl_chart_group");
			String valueUnit 		= (String)map.get("value_unit");
			String xAxis_element	= (String)map.get("xAxis_element");
			locale					= (String)map.get("locale");

			ArrayList keySet		= (ArrayList)map.get("key_set");
			
			String s7 = "select SPL_CHART_TYPE from CA_SPL_CHART_KEY_VALUE where SPL_CHART_TYPE=? AND SPL_CHART_TYPE_GRP_ID = ? and X_ELEMENT_TYPE=?";
            
			pstmt = con.prepareStatement(s7);
			pstmt.setString(1,splChartType);
			pstmt.setString(2,splChartGroup);
			pstmt.setString(3,xAxis_element);
            rset = pstmt.executeQuery();
            
			if(rset.next())
            {
                flag = false;
                error = getMessage(locale,"CODE_ALREADY_EXISTS","Common");
                sb.append(error);
            }
			else
               flag = true;

			if(rset!=null)
				rset.close();
			
			if(pstmt!=null)
				pstmt.close();
			
			if(flag)
			{
				String sqlQry = "insert into CA_SPL_CHART_KEY_VALUE( SPL_CHART_TYPE,KEY_VALUE,START_VALUE,VALUE_UNIT,END_VALUE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,SPL_CHART_TYPE_GRP_ID,X_ELEMENT_TYPE) values(?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?)";
			
				pstmt = con.prepareStatement(sqlQry);
				int size = keySet.size();

	  		    HashMap key = null;
			    String startValue = null;
			    String endValue = null;
			    String keyValue = null;
			   
				for(int i=0;i<size;i++)
		  		{
					key = (HashMap) keySet.get(i);
					startValue = (String) key.get("start_value");
					endValue   = (String) key.get("end_value");
					keyValue   = (String) key.get("key_value");

					pstmt.setString(1,splChartType);
					pstmt.setString(2,keyValue);
					pstmt.setString(3,startValue);
					pstmt.setString(4,valueUnit);
					pstmt.setString(5,endValue);
					pstmt.setString(6,addedById);
					pstmt.setString(7,addedAtWsNo);
					pstmt.setString(8,addedFacilityId);
					pstmt.setString(9,addedById);
					pstmt.setString(10,addedAtWsNo);
					pstmt.setString(11,addedFacilityId);
					pstmt.setString(12,splChartGroup);
					pstmt.setString(13,xAxis_element);
					pstmt.addBatch();
					
				}

				int [] insertCounts = pstmt.executeBatch();	
	
				if (insertCounts.length == -3 || insertCounts.length != size)
					flag=false;

				
				
			}
			if(flag == true)
			{
				con.commit() ;
				error = getMessage(locale,"RECORD_INSERTED","CA");
				
				sb.append(error);
			}
			else
				con.rollback();
		}
		catch(Exception e) 
		{
			flag = false;
		
			sb.append(e);

			try
			{
				con.rollback();
			}
			catch(Exception e1)
			{
				e1.printStackTrace() ;
			}
		}
		finally
		{
			map.clear();
			
			if(pstmt != null)	
			{
				try
				{
					pstmt.close();
				}
				catch(Exception e)
				{
					e.printStackTrace() ;
					sb.append(e);
				}
			}
			if(con != null)		
				ConnectionManager.returnConnection(con, properties);
		}

		map1.put("status", new Boolean(flag));
		map1.put("error", sb.toString());
        
		return map1;
	 }
	 private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}
}



		

		

