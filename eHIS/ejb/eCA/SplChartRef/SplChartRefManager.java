/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA.SplChartRef;

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
*	name="SplChartRef"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="SplChartRef"
*	local-jndi-name="SplChartRef"
*	impl-class-name="eCA.SplChartRef.SplChartRefManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCA.SplChartRef.SplChartRefLocal"
*	remote-class="eCA.SplChartRef.SplChartRefRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.SplChartRef.SplChartRefLocalHome"
*	remote-class="eCA.SplChartRef.SplChartRefHome"
*	generate= "local,remote"
*
*
*/

public class SplChartRefManager implements SessionBean 
{
    Connection con;
    PreparedStatement pstmt;
    PreparedStatement pstmtDel;
    
    SessionContext ctx;
	ResultSet rset;
	ResultSet rsetDel;

    public SplChartRefManager() {
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

	public HashMap insertSplChartRef(Properties properties, HashMap map)
    {
	    HashMap map1 = new HashMap();
        boolean flag = true;
		StringBuffer sb = new StringBuffer();
		String error1  = "" ;
		try {
            
			con = ConnectionManager.getConnection(properties);
			
			String addedById		= (String)map.get("added_by_id");
            String addedFacilityId  = (String)map.get("added_facility_id");
            String addedAtWsNo	    = (String)map.get("added_at_ws_no");


			String splChartType 	= (String)map.get("spl_chart_type");
			String splChartGroup    = (String)map.get("spl_chart_group");
			String elementType 		= (String)map.get("element_type");
			String gender 			= (String)map.get("gender");
			String xAxis_element	= (String)map.get("xAxis_element");
			
			StringBuffer key_ref = new StringBuffer();
			key_ref.append(splChartType);
			key_ref.append("#");
			key_ref.append(splChartGroup);
			key_ref.append("#");
			key_ref.append(elementType);
			key_ref.append("#");
			key_ref.append(gender);
			String locale			= (String)map.get("locale");
			HashMap prefMap = (HashMap)map.get("prefMap");
			if (prefMap != null)
			{
				Set<String> keySet = prefMap.keySet();	
				
				String hdrDel="delete from CA_SPL_CHART_REF_DTL";
				PreparedStatement pstmtHdrDel = con.prepareStatement(hdrDel);
				//pstmtHdrDel.setString(1,key_ref.toString());
				pstmtHdrDel.executeUpdate();
				if (pstmtHdrDel != null)
				{
					pstmtHdrDel.close();
				}

				String sqlHdr="insert into CA_SPL_CHART_REF_DTL(PREF_ID,PREF_DESC,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values (?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
				PreparedStatement pstmtHdr = con.prepareStatement(sqlHdr);
				for (String pref : keySet )
				{
					String header =(String) prefMap.get(pref);						
					insertHeader(pref,header,addedById,addedFacilityId,addedAtWsNo, pstmtHdr);
					
				}

				if (pstmtHdr != null)
				{
					pstmtHdr.close();
				}
			}			
			
			ArrayList keySet	= (ArrayList)map.get("key_set");

			java.lang.String s7 = "select SPL_CHART_TYPE from CA_SPL_CHART_REF_VALUE where SPL_CHART_TYPE=? AND ELEMENT_TYPE=? AND GENDER=? AND SPL_CHART_TYPE_GRP_ID=? AND X_ELEMENT_TYPE=?";

			String sqlDel = "delete CA_SPL_CHART_REF_VALUE where SPL_CHART_TYPE=? AND ELEMENT_TYPE=? AND GENDER=? AND SPL_CHART_TYPE_GRP_ID=? AND X_ELEMENT_TYPE=?";

            pstmt = con.prepareStatement(s7);
			pstmt.setString(1,splChartType);
			pstmt.setString(2,elementType);
			pstmt.setString(3,gender);
			pstmt.setString(4,splChartGroup);
			pstmt.setString(5,xAxis_element);

            pstmtDel = con.prepareStatement(sqlDel);
			pstmtDel.setString(1,splChartType);
			pstmtDel.setString(2,elementType);
			pstmtDel.setString(3,gender);
			pstmtDel.setString(4,splChartGroup);
			pstmtDel.setString(5,xAxis_element);

			rset = pstmt.executeQuery();
            if(rset.next())
            {
                  int temp = pstmtDel.executeUpdate();
				  temp = temp;
            }
			if(rsetDel!=null)
				rsetDel.close();
			if(pstmtDel!=null)
				pstmtDel.close();
			if(rset!=null)
				rset.close();
			if(pstmt!=null)
				pstmt.close();



			if(flag)
			{
				String sqlQry = "insert into CA_SPL_CHART_REF_VALUE(SPL_CHART_TYPE, ELEMENT_TYPE, GENDER, KEY_VALUE, MEDIAN_VALUE, VARIATION_VALUE, BOX_CON_TRANS_VALUE, PREF1, PREF2, PREF3, PREF4, PREF5, PREF6,PREF7,PREF8, PREF9,PREF10,PREF11,PREF12 ,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,SPL_CHART_TYPE_GRP_ID,X_ELEMENT_TYPE) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?)";
				pstmt = con.prepareStatement(sqlQry);
				int size = keySet.size();
	
				HashMap key = null;
				
				String keyValue = null;
				String medianValue = null;
				String variationValue = null;
				String transValue = null;
				
				String PREF1 = null;
				String PREF2 = null;
				String PREF3 = null;
				String PREF4 = null;
				String PREF5 = null;
				String PREF6 = null;
				String PREF7 = null;
				String PREF8 = null;
				String PREF9 = null;
				String PREF10 = null;
				String PREF11 = null;
				String PREF12 = null;

				for(int i=0;i<size;i++)
				{
					key = (HashMap) keySet.get(i);
					
					keyValue = (String) key.get("key_value");
					medianValue = (String) key.get("median_value");
					variationValue = (String) key.get("variation_value");
					transValue = (String) key.get("trans_value");

					PREF1  = (String) key.get("p1_value");
					PREF2  = (String) key.get("p2_value");
					PREF3 = (String) key.get("p3_value");
					PREF4 = (String) key.get("p4_value");
					PREF5 = (String) key.get("p5_value");
					PREF6 = (String) key.get("p6_value");
					PREF7 = (String) key.get("p7_value");
					PREF8 = (String) key.get("p8_value");
					PREF9 = (String) key.get("p9_value");
					PREF10 = (String) key.get("p10_value");
					PREF11 = (String) key.get("p11_value");
					PREF12 = (String) key.get("p12_value");			
				
				
					pstmt.setString(1,splChartType);
					pstmt.setString(2,elementType);
					pstmt.setString(3,gender);
					pstmt.setString(4,keyValue);
					pstmt.setString(5,medianValue);
					pstmt.setString(6,variationValue);
					pstmt.setString(7,transValue);
					pstmt.setString(8,PREF1);
					pstmt.setString(9,PREF2);
					pstmt.setString(10,PREF3);
					pstmt.setString(11,PREF4);
					pstmt.setString(12,PREF5);
					pstmt.setString(13,PREF6);
					pstmt.setString(14,PREF7);
					pstmt.setString(15,PREF8);
					pstmt.setString(16,PREF9);
					pstmt.setString(17,PREF10);
					pstmt.setString(18,PREF11);
					pstmt.setString(19,PREF12);
					 
					pstmt.setString(20,addedById);
					pstmt.setString(21,addedAtWsNo);
					pstmt.setString(22,addedFacilityId);
					pstmt.setString(23,addedById);
					pstmt.setString(24,addedAtWsNo);
					pstmt.setString(25,addedFacilityId);
					pstmt.setString(26,splChartGroup);
					pstmt.setString(27,xAxis_element);
					pstmt.addBatch();
				}
				int [] insertCounts = pstmt.executeBatch();	
				flag = true;
				for (int k=0;k<insertCounts.length ;k++ ){
					if(insertCounts[k]<0  && insertCounts[k] != -2 ){
							flag=false;
							break;
				}
			}
			if(flag == true)
			{
				error1 = getMessage(locale,"RECORD_INSERTED","CA");
				sb.append(error1);
    			con.commit() ;
			}
		}
		}
		catch(Exception e) {
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

	private void insertHeader(String pref, String header, String addedById,String addedFacilityId,String addedAtWsNo, PreparedStatement pstmtHdr)
	{
		try
		{			
			pstmtHdr.setString(1,pref);
			pstmtHdr.setString(2,header);
			pstmtHdr.setString(3,addedById);
			pstmtHdr.setString(4,addedAtWsNo);
			pstmtHdr.setString(5,addedFacilityId);
			pstmtHdr.setString(6,addedById);
			pstmtHdr.setString(7,addedAtWsNo);
			pstmtHdr.setString(8,addedFacilityId);			

			pstmtHdr.executeUpdate();            
			
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
			

	}
}
