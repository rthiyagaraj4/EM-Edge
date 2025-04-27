/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;
import java.io.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eBL.Common.*;

@SuppressWarnings({"rawtypes","unchecked", "serial"})
public class DailyCashDeliveryReport extends BlAdapter implements Serializable {	
	//public	HttpSession session ;
	//static String  changeBlgName="";
	public LinkedHashMap hasDailyCashSearchValues		= new LinkedHashMap();
	HashSet unionKeys;

	public DailyCashDeliveryReport()
	{	
		System.err.println("DailyCashDeliveryReport Initialized");
	}

	public HashMap validate() throws Exception
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." );
		return map;
	}	
	
	public void clearBean()
	{
		if( hasDailyCashSearchValues != null )
	 	{
			hasDailyCashSearchValues.clear();
	 	}
		else
		{
			hasDailyCashSearchValues	= new java.util.LinkedHashMap();
		}	
	}	
	
		public LinkedHashMap getDailyCashSearchValues()
		{
			System.err.println("Values Temp Table to Hash  "+hasDailyCashSearchValues.size());
			return hasDailyCashSearchValues;		
		}

		public void setDailyCashSearchValues(LinkedHashMap hasDailyCashSearchValues) {
			this.hasDailyCashSearchValues = hasDailyCashSearchValues;
		}	
		
		public int getSize()
		{
			System.err.println(hasDailyCashSearchValues.size());
			return  hasDailyCashSearchValues.size();
		}
		
		
		
		boolean compareServObject(DailyCashReportBean  obj)
		{		
			int index;
			DailyCashReportBean dailyCash;
			for(index=0;index<hasDailyCashSearchValues.size();index++)
			{
				dailyCash = (DailyCashReportBean)hasDailyCashSearchValues.get(""+index);
				if(dailyCash.getServGroupCode().equals(obj.getServGroupCode()))    
				return true;
					}
			return false;
		}		
	
		boolean compareSerObject(DailyCashReportBean  obj)
		{		
			int index;
			DailyCashReportBean dailyCash1;
			for(index=0;index<hasDailyCashSearchValues.size();index++)
			{
				dailyCash1 = (DailyCashReportBean)hasDailyCashSearchValues.get(""+index);
				if(dailyCash1.getServItmCode().equals(obj.getServItmCode()))    
				return true;
					}
			return false;
		}		
	
		
		public void getDBValues() throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			DailyCashReportBean dailyCash;
		
			try{
				String sqlStr = "select SERV_GROUP_CODE,long_desc,short_desc,USE_FOR_UNDEFINED_ITEM , Exempted_receipt_yn from BL_REPORT_SERV_GROUP order by 1";			
				//System.err.println("Query to Fetch Form Temp Table  "+sqlStr);
				conn=ConnectionManager.getConnection();
				pstmt=conn.prepareStatement(sqlStr);
				rs= pstmt.executeQuery();
				//System.err.println("After Execute Query  ");
				//ResultSetMetaData rsmd = rs.getMetaData();
				//int columnsNumber = rsmd.getColumnCount();
				//System.err.print("columnsNumber--"+columnsNumber);
				 while(rs.next()) { 
				/*	for (int i = 1; i <= columnsNumber; i++) {
						if (i > 1) System.err.print(",  ");
						String columnValue = rs.getString(i);
						System.err.print(columnValue + " " + rsmd.getColumnName(i));
					}
				 
					System.err.println("Inside  While  Result Set at line 160");
					*/
					dailyCash = new DailyCashReportBean();
					dailyCash.setServGroupCode(checkForNull(rs.getString("SERV_GROUP_CODE")));			
					dailyCash.setLongDesc(checkForNull(rs.getString("long_desc")));			
					dailyCash.setShortDesc(checkForNull(rs.getString("short_desc")));
					dailyCash.setUsedForUndefinedItems(checkForNull(rs.getString("USE_FOR_UNDEFINED_ITEM")));
					dailyCash.setUsedForExemptedReceipt(checkForNull(rs.getString("Exempted_receipt_yn")));
					//System.err.println("getServGroupCode getDBValues "+dailyCash.getServGroupCode());
					//System.err.println("login_at_ws_no  getDBValues "+dailyCash.getLongDesc());			
					hasDailyCashSearchValues.put(""+dailyCash.getIndexVal(),dailyCash);
				}				System.err.println("hasDailyCashSearchValues 113 size-->"+hasDailyCashSearchValues.size());
			}catch(Exception e){
				System.err.println("Exception e="+e);
				e.printStackTrace();
			}finally{
				//System.err.println("Inside Finally");
				if(rs==null) {
					System.err.println("Result Set Empty");
				}
				if(rs!=null) {
					 System.err.println("Result Set Not Empty");
					rs.close();
				}
				if(pstmt!=null) 
					pstmt.close();			
				ConnectionManager.returnConnection(conn);
			}
		}
		
		public void getServValues(String locale,String serv_grp_code) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			DailyCashReportBean dailyCash1;
		
			try{
				
				String sql="select SERV_ITEM_IND,serv_item_code,(SELECT SHORT_DESC "
						+ "FROM   BL_BLNG_SERV_LANG_VW WHERE  BLNG_SERV_CODE =a.serv_item_code AND UPPER(LANGUAGE_ID)=UPPER(?)) description"+
						" from bl_serv_by_report_serv_group a where serv_group_code =? and SERV_ITEM_IND ='S'"
						+" union " +
						" select SERV_ITEM_IND,serv_item_code,(SELECT SHORT_DESC FROM   MM_ITEM_LANG_VW WHERE UPPER(LANGUAGE_ID)=UPPER(?)"+
						"AND    ITEM_CODE =a.serv_item_code) description from bl_serv_by_report_serv_group a where serv_group_code = ? "+
						"and SERV_ITEM_IND ='I' order by 2";
			
				//System.err.println("Query to Fetch Form Temp tbl  "+sql);
				conn=ConnectionManager.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,serv_grp_code);
				pstmt.setString(3,locale);
				pstmt.setString(4,serv_grp_code);
				rs= pstmt.executeQuery();
				//ResultSetMetaData rsmd = rs.getMetaData();
				//int columnsNumber = rsmd.getColumnCount();
				int j=0;
				while(rs.next()) { 
				/*	for (int i = 1; i <= columnsNumber; i++) {
						//if (i > 1) System.err.print(",  ");
						String columnValue = rs.getString(i);
						System.err.print(columnValue + " " + rsmd.getColumnName(i));
					}  */
					
					//System.err.println("Inside  While  Result Set at line 160");
					dailyCash1 = new DailyCashReportBean();
					dailyCash1.setServItmInd(checkForNull(rs.getString("SERV_ITEM_IND")));			
					dailyCash1.setServItmCode(checkForNull(rs.getString("serv_item_code")));			
					dailyCash1.setServItmDesc(checkForNull(rs.getString("description")));
					hasDailyCashSearchValues.put(""+dailyCash1.getIndex(j),dailyCash1);
					j++;
				}				System.err.println("hasDailyCashSearchValues SERV size-->"+hasDailyCashSearchValues.size());
			}catch(Exception e){
				System.err.println("Exception e="+e);
				e.printStackTrace();
			}finally{
				//System.err.println("Inside Finally");
				if(rs==null) {
					System.err.println("Result Set Empty");
				}
				if(rs!=null) {
					 System.err.println("Result Set Not Empty");
					rs.close();
				}
				if(pstmt!=null) 
					pstmt.close();			
				ConnectionManager.returnConnection(conn);
			}
		}
}