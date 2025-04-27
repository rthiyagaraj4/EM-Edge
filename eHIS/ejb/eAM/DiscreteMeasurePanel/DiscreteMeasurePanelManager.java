/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM.DiscreteMeasurePanel;


import java.sql.*;
import java.util.*;
import java.util.HashMap;
import java.util.Properties;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;



/**
*
* @ejb.bean
*	name="DiscreteMeasurePanel"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="DiscreteMeasurePanel"
*	local-jndi-name="DiscreteMeasurePanel"
*	impl-class-name="eAM.DiscreteMeasurePanel.DiscreteMeasurePanelManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eAM.DiscreteMeasurePanel.DiscreteMeasurePanelLocal"
*	remote-class="eAM.DiscreteMeasurePanel.DiscreteMeasurePanelRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eAM.DiscreteMeasurePanel.DiscreteMeasurePanelLocalHome"
*	remote-class="eAM.DiscreteMeasurePanel.DiscreteMeasurePanelHome"
*	generate= "local,remote"
*
*
*/





public class DiscreteMeasurePanelManager implements SessionBean
{
    Connection con;
    PreparedStatement pslPrepStmt;
    ResultSet rset;
    //SessionContext ctx;

    public DiscreteMeasurePanelManager() 
	{
        pslPrepStmt = null;
    }

    public void ejbCreate()  {  }

    public void ejbRemove() {  }

    public void ejbActivate() {  }

    public void ejbPassivate() {  }

    public void setSessionContext(SessionContext sessioncontext) 
	{
       sessioncontext= sessioncontext;//for avoiding PMD violation
    }
/**
* @ejb.interface-method
*	 view-type="both"
*/
    public HashMap manageDiscreteMeasurePanel(HashMap tabdata) 
	{
		
		

		HashMap hash=(HashMap)tabdata.get("tabdata");
		java.util.Properties p =(Properties) hash.get("p");
	
		String locale="";
		locale= p.getProperty("LOCALE");
		HashMap hash1 = new HashMap();
		boolean flag2 = false;
		try 
		{
			con		  = ConnectionManager.getConnection(p);
			String modified_by_id			=(String)hash.get("modified_by_id");
			String modified_facility_id		=(String)hash.get("modified_facility_id");
			String modified_at_ws_no		=(String)hash.get("modified_at_ws_no");
			java.sql.Timestamp modified_date=(java.sql.Timestamp)hash.get("modified_date");
			String added_by_id				= (String)hash.get("added_by_id");
			String added_facility_id		= (String)hash.get("added_facility_id");
			String added_at_ws_no			= (String)hash.get("added_at_ws_no");
			java.sql.Timestamp added_date	= (java.sql.Timestamp)hash.get("added_date");
			

			int j = 0;
			String discr_msr_battery_id	="";
			String discr_msr_id ="";
			String order_srl_no ="";
			String old_order_srl_no = "";
			String mandatory_yn	= "";
			String mode="";
		//	try 
		//	{
				int ilCount = 0;
				discr_msr_battery_id 		=(String)hash.get("discr_msr_battery_id");
				discr_msr_id 				=(String)hash.get("discr_msr_id");
				order_srl_no 				=(String)hash.get("order_srl_no");
				old_order_srl_no			=(String)hash.get("old_order_srl_no");
				mandatory_yn				=(String)hash.get("mandatory_yn");
				mode						=(String)hash.get("mode");
				StringBuffer sblQry			= new StringBuffer("");

				hash.clear();
				tabdata.clear();

				if(mode.equalsIgnoreCase("delete"))
				{

					sblQry.append("Delete from am_discr_msr_battery ");
					sblQry.append(" WHERE discr_msr_battery_id = '"+ discr_msr_battery_id +"' ");
					sblQry.append(" AND discr_msr_id ='"+ discr_msr_id + "'");

					pslPrepStmt = con.prepareStatement(sblQry.toString());
					j = pslPrepStmt.executeUpdate();
					if(pslPrepStmt!=null) pslPrepStmt.close();
				}

				if(mode.equals("insert"))
				{
					sblQry = new StringBuffer();

					sblQry.append("SELECT COUNT(*) FROM am_discr_msr_battery  ");
					sblQry.append("WHERE  DISCR_MSR_ID ='"+ discr_msr_id +"' ");
					sblQry.append("AND  DISCR_MSR_BATTERY_ID ='" +discr_msr_battery_id+ "'");

					pslPrepStmt = con.prepareStatement(sblQry.toString());
					rset = pslPrepStmt.executeQuery();

					while(rset.next())
					{
						ilCount = rset.getInt(1);
					}

					if(rset!=null)rset.close();
					if(pslPrepStmt!=null) pslPrepStmt.close(); 
				}

			//	try 
		//		{
					if(ilCount != 0)
					{
						Hashtable hash2 = MessageManager.getMessage(locale,"COMBINATION_EXISTS","CA");
						hash1.put("error", (String)hash2.get("message"));
						hash2.clear();
					}
					else if(mode.equals("insert") || mode.equals("update"))
					{
						ilCount=0;
						sblQry = new StringBuffer("");

						if ((mode.equals("insert")) || (mode.equals("update") && old_order_srl_no != order_srl_no))
						{
							sblQry.append("SELECT COUNT(*) FROM am_discr_msr_battery");
							sblQry.append(" WHERE ORDER_SRL_NO ="+ order_srl_no);
							sblQry.append("  AND DISCR_MSR_BATTERY_ID ='" + discr_msr_battery_id + "'");
							pslPrepStmt = con.prepareStatement(sblQry.toString());
							rset = pslPrepStmt.executeQuery();
							
							while(rset.next())
							{
								ilCount = rset.getInt(1);
							}
							if(pslPrepStmt!=null) pslPrepStmt.close(); 
						}
						
						if(ilCount != 0)
						{
							Hashtable hash2 = MessageManager.getMessage(locale,"DUPLICATE_SRL_NO","CA");
							hash1.put("error",(String)hash2.get("message"));
							hash2.clear();
						}else
						{
							j = 0;
							
							if(mode.equals("insert")) 
							{
								sblQry = new StringBuffer("");
								
								

								String	sql	= "INSERT INTO AM_DISCR_MSR_BATTERY(DISCR_MSR_BATTERY_ID," +
								"DISCR_MSR_ID," +
								"ORDER_SRL_NO," +
								"MANDATORY_YN," +
								"ADDED_BY_ID," +
								"ADDED_DATE," +
								"ADDED_AT_WS_NO," +
								"ADDED_FACILITY_ID," +
								"MODIFIED_BY_ID," +
								"MODIFIED_DATE," +
								"MODIFIED_AT_WS_NO," +
								"MODIFIED_FACILITY_ID" +
								") values (?,?,?,?,?,?,?,?,?,?,?,?)" ;
					
								pslPrepStmt = con.prepareStatement(sql);

								pslPrepStmt.setString(1 ,discr_msr_battery_id);
								pslPrepStmt.setString(2 ,discr_msr_id);
								pslPrepStmt.setString(3 ,order_srl_no);
								pslPrepStmt.setString(4 ,mandatory_yn);
								pslPrepStmt.setString(5 ,added_by_id);
								pslPrepStmt.setTimestamp(6 ,added_date);
								pslPrepStmt.setString(7 ,added_at_ws_no);
								pslPrepStmt.setString(8 ,added_facility_id);
								pslPrepStmt.setString(9 ,modified_by_id);
								pslPrepStmt.setTimestamp(10 ,modified_date);
								pslPrepStmt.setString(11 ,modified_at_ws_no);
								pslPrepStmt.setString(12 ,modified_facility_id);

								j = pslPrepStmt.executeUpdate();
								if(pslPrepStmt!=null)pslPrepStmt.close();

							}else if(mode.equals("update"))
							{
								String sqlUpdate = "Update am_discr_msr_battery  set  " +
								"ORDER_SRL_NO=?, " +
								"MANDATORY_YN=?, " +
								"MODIFIED_BY_ID=?, " +
								"MODIFIED_DATE=?, " +
								"MODIFIED_AT_WS_NO=?, " +
								"MODIFIED_FACILITY_ID=? " +
								" where DISCR_MSR_ID='"+ discr_msr_id +
								"' and DISCR_MSR_BATTERY_ID='" +discr_msr_battery_id + "'" ;

								pslPrepStmt = con.prepareStatement(sqlUpdate);

								pslPrepStmt.setString(1 ,order_srl_no);
								pslPrepStmt.setString(2 ,mandatory_yn);
								pslPrepStmt.setString(3 ,modified_by_id);
								pslPrepStmt.setTimestamp(4 ,modified_date);
								pslPrepStmt.setString(5 ,modified_at_ws_no);
								pslPrepStmt.setString(6 ,modified_facility_id)	;

								j = pslPrepStmt.executeUpdate();
							}
						}
					}
			//	}catch(Exception e) 
			//	{
					//hash1.put("error", "Transaction failed: "+e);
			//	}

				if(j == 1) 
				{
					Hashtable hash2 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
					hash1.put("error", (String)hash2.get("message"));
					flag2 = true;
					con.commit();
					hash2.clear();
				} else 
				{
					con.rollback();
				}

					if(rset !=null) rset.close();
					if(pslPrepStmt != null)
					pslPrepStmt.close();
		//	}catch(Exception exception2) 
		//	{
				//hash1.put("er2", exception2);
			//}
			
		}catch(Exception exception) 
		{
			hash1.put("er3", exception);
			hash1.put("error", "Transaction failed: "+exception);
			hash1.put("er2", exception);
		}

		finally 
			{
				
				if(con != null)
				ConnectionManager.returnConnection(con, p);
			}
			hash1.put("status", new Boolean(flag2));
			return hash1;
	}

}
