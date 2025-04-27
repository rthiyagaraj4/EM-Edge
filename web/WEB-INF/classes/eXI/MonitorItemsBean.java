/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Properties;

import webbeans.eCommon.ConnectionManager;
import eXH.XHUtil;

/**
 * Class contains bean utility methods for Schema Browser
 */
																  
 public class MonitorItemsBean
 { 
	/**																				  
	 * Utility method used for closing the database resources
	 */
	public static String closeSQLObj(Object object, String objectType)
	{
		if(object != null)
		{
			try
			{
				if("ResultSet".equalsIgnoreCase(objectType))
				{
					ResultSet rs = (ResultSet)object;
					rs.close();
				}
				else if("PreparedStatement".equalsIgnoreCase(objectType))
				{
					PreparedStatement pst = (PreparedStatement)object;
					pst.close();
				}
				else if("Connection".equalsIgnoreCase(objectType))
				{
					Connection con = (Connection) object;
					ConnectionManager.returnConnection(con);
				}
				else if("CallableStatement".equalsIgnoreCase(objectType))
				{
					CallableStatement cstmt = (CallableStatement) object;
					cstmt.close();
				}
			}
			catch(Exception se)
			{
				return se.toString();
			}
		}
		return "Object Closed.";
	}

	 public static HashMap<String,String> getDomainList()
	 {
		Connection dbConn = null;
		ResultSet rs = null;
		Statement stmt = null;

		String qryDomain = "SELECT DISTINCT y.module_id,interface_desc FROM xh_interface x, xh_schema_brwsr_func y WHERE x.interface_module_id = y.module_id ORDER BY 1";
		HashMap<String,String> domainList = null;

		try
		{
			dbConn = ConnectionManager.getConnection();
			stmt = dbConn.createStatement();
			rs = stmt.executeQuery(qryDomain);

			if (rs.next())
			{
				domainList = new HashMap<String, String>();
				domainList.put(rs.getString(1), rs.getString(2));
			}
			while (rs.next())
			{
				domainList.put(rs.getString(1), rs.getString(2));
			}
		}
		catch (Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			closeSQLObj(rs, "ResultSet");
			closeSQLObj(stmt, "Statement");
			
			try
			{
				if(stmt!=null)stmt.close();
			    if(rs!=null)rs.close();
				ConnectionManager.returnConnection(dbConn);
			}
			catch(Exception e)
			{
				System.out.println(" Errors in Connection close :"+e);
			}
		}
		return domainList;
	 }

	public static List getDlftTables(String domainID)
	{
		ArrayList interfaceTableList = new ArrayList();
		String strQuery = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try
		{
			if(domainID != null && !domainID.equals(""))
			{
				strQuery = "select object_name from all_objects where object_name LIKE '"+domainID+"%' and object_type='TABLE' and OWNER='XI_INT' order by 1";
			}
			else
			{
				strQuery = "select object_name from all_objects where object_name LIKE 'X%' and object_type='TABLE' and OWNER='XI_INT' order by 1";
			}			

			con = ConnectionManager.getConnection();
			stmt = con.createStatement();					
			rs = stmt.executeQuery(strQuery);

			while (rs.next())
			{				
				interfaceTableList.add(rs.getString(1));
			}			
		}
		catch (Exception e){
			e.printStackTrace(System.err);
		}
		finally{
			try
			{
				closeSQLObj(rs,"ResultSet");
				closeSQLObj(stmt,"Statement");
				
				if(stmt!=null)stmt.close();
			    if(rs!=null)rs.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e)
			{
				System.out.println("Error in SchemaBrowserBean "+e);
			}
		}

		return interfaceTableList;
	}

	public static List<String> getIndexColList(String tblName, Properties prop)
	{
		String user = "XI_INT";
		String qry = "SELECT column_name FROM all_ind_columns WHERE table_name = ? AND TABLE_OWNER = ? ORDER BY column_position";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			if(tblName.startsWith("XF")) user = "XF_INT";			
			
			con = ConnectionManager.getConnection(prop);
			pst = con.prepareStatement(qry);
			pst.setString(1, tblName);
			pst.setString(2, user);
			rs = pst.executeQuery();
			List<String> indexColList = new ArrayList<String>();
			while(rs.next())
			{
				indexColList.add(rs.getString(1));				
			}

			if(indexColList.size() > 0)
			{
				return indexColList;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			XHUtil.closeDBResources(rs, pst, con);			
		}
		return null;
	}

	public static List<String> getTabColList(String tblName, Properties prop)
	{
		String user = "XI_INT";
		String qry = "SELECT column_name FROM all_tab_columns WHERE OWNER = ? and table_name = ? ORDER BY column_id";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			if(tblName.startsWith("XF")) user = "XF_INT";

			con = ConnectionManager.getConnection(prop);

			System.out.println(" ********************** Parameters getTabColList qry : "+qry+" : user : "+user+ " : tblName : "+tblName );
			pst = con.prepareStatement(qry);
			pst.setString(1, user);
			pst.setString(2, tblName);
			rs = pst.executeQuery();
			List<String> indexColList = new ArrayList<String>();			
			
			while(rs.next())
			{				
				indexColList.add(rs.getString(1));
			}
			
			System.out.println(" ********************** Parameters indexColList : "+indexColList.size() );

			if(indexColList.size() > 0)
			{
				return indexColList;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeSQLObj(rs, "ResultSet");
			closeSQLObj(pst, "PreparedStatement");
			closeSQLObj(con, "Connection");
		}
		return null;
	}	

	public static Map<String,String> getTabDataTypeList(String tblName, Properties prop)
	{
		String user = "XI_INT";
		String qry = "SELECT column_name,data_type FROM all_tab_columns WHERE OWNER = ? and table_name = ? ORDER BY column_id";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			if(tblName.startsWith("XF")) user = "XF_INT";

			con = ConnectionManager.getConnection(prop);
			pst = con.prepareStatement(qry);
			pst.setString(1, user);
			pst.setString(2, tblName);
			rs = pst.executeQuery();
			Map<String,String> indexColList = new HashMap<String,String>();			
			
			while(rs.next())
			{				
				indexColList.put(rs.getString("column_name"), rs.getString("data_type"));
			}

			if(indexColList.size() > 0)
			{
				return indexColList;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeSQLObj(rs, "ResultSet");
			closeSQLObj(pst, "PreparedStatement");
			closeSQLObj(con, "Connection");
		}
		return null;
	}

	public String getFuncTableName(String functionID, String purgeStatus)
	{
	//	String qry = "SELECT table_name FROM xi_sap_func_tab WHERE func_id = ? AND queue_type = ?";		
		String qry = "SELECT table_name FROM xh_schema_brwsr_func WHERE func_id = ? AND queue_type = ?";
		String tableName = "";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(qry);
			
			System.out.println(" ********************** Parameters getFuncTableName qry : "+qry+" : functionID : "+functionID+ " : purgeStatus : "+purgeStatus );

			pst.setString(1, functionID);
			pst.setString(2, purgeStatus);
			rs = pst.executeQuery();
			
			if(rs.next())
			{
				tableName = rs.getString("table_name");
			}			

			System.out.println(" ********************** Parameters getFuncTableName tableName : "+tableName );
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeSQLObj(rs, "ResultSet");
			closeSQLObj(pst, "PreparedStatement");
			closeSQLObj(con, "Connection");
		}
		return tableName;
	}

	public static String getDispName(String colName)
	{
		String dispName = colName;

		if("HN".equals(colName)) dispName = "Patient ID";
		if("TRX_NO".equals(colName)) dispName = "Transaction No";
		if("WS_STATUS".equals(colName)) dispName = "Webservice Status";
		if("RECORD_STATUS".equals(colName)) dispName = "Status";
		if("ITEM_CODE".equals(colName)) dispName = "Item Code";

		return dispName;
	}

	public static String checkNumber(String number)
	{
		try
		{
			if(((number == null) || (number.trim().equals("")) || (number.equals("null"))))
			{
				number = "";
			}
			else
			{
				int decIndex = number.indexOf(".");
				if(decIndex > 0) 
				{
					int numLength = number.length();				
					if((numLength - decIndex) < 3)
					{
						for(int i = 1; i < (numLength - decIndex); i++)
						{
							number += "0";
						}
					}
				}
				else number += ".00";
			}
		}
		catch (Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		
		return number;
	}
 }
