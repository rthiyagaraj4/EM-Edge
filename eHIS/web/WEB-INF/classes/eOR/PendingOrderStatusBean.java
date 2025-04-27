/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
15/02/2012    IN033926		 Menaka V		Prepare Discharge Advice>View Pending orders>System displays different Practitioner's name for
								the lab orders.
---------------------------------------------------------------------------------------------------------------------------------	
Date		Edit History	Name		Rev.Date   	 Rev.By 	Description
--------------------------------------------------------------------------------------------------------------------------------
25/09/2018	  IN068719		sivabagyam	 25/09/2018	Ramesh G   GHL-CRF-0517.1
--------------------------------------------------------------------------------------------------------------------------------
*/
package eOR;

import eOR.Common.* ;
import java.io.*;
import java.util.*;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import eOR.Common.* ;
import eCommon.Common.*;

public class PendingOrderStatusBean extends OrAdapter implements java.io.Serializable 
{
	Hashtable recordSet = null;
	ArrayList OrderSat = null;
	
	public ArrayList getPendingOrderDetails(String patient_id,String encounter_id,String facility_id,String discharge_ind,int start,int end) throws Exception 
	{
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		ArrayList OrderSat1 = new ArrayList() ;
		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement("SELECT A.CATALOG_DESC, A.ORDER_CATEGORY ORDER_CATEGORY, A.ORDER_ID, to_char(a.start_date_time,'dd/mm/yyyy hh24:mi')start_date_time, to_char(a.end_date_time,'dd/mm/yyyy hh24:mi')end_date_time, DECODE(nvl(A.Priority,'R'),'U','Urgent','S','Stat','R','Routine') priority_desc, OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status, OR_GET_DESC.OR_ORDER_TYPE(b.order_type_code,?,'2') order_type, nvl(am_get_desc.am_practitioner (b.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (b.ord_pract_id,?,'1')) ordering_pract_name from or_order_line A, OR_ORDER B where A.order_id in (select order_id from or_order where patient_id = ? and encounter_id = ? and ordering_facility_id = ?) and (A.order_category,order_line_Status) in (select order_category, order_status from or_status_disch_category where Discharge_ind = ?) AND A.ORDER_ID = B.ORDER_ID ORDER BY TO_CHAR (a.start_date_time, 'YYYYMMDDHH24MISS')DESC") ;//IN032926
			pstmt.setString(1, language_id);
			
			pstmt.setString(2, language_id);
			
			pstmt.setString(3, language_id);
			
			pstmt.setString(4, language_id);
			
			pstmt.setString(5, patient_id);
			
			pstmt.setString(6, encounter_id);
			
			pstmt.setString(7, facility_id);
			
			pstmt.setString(8, discharge_ind);
			
			resultSet = pstmt.executeQuery() ;
			String[] record=null;
			
			if(resultSet!=null) 
			{
				if(start > 0)
					for(int i=0;(i<start-1 && resultSet.next());i++);

				while (start <= end && resultSet != null && resultSet.next() ) 
				{
					record = new String[11];
					record[0] = resultSet.getString( "CATALOG_DESC" )  ;
					record[1] = resultSet.getString( "ORDER_CATEGORY" )  ;
					record[2] = resultSet.getString( "ORDER_ID" )  ;
					record[3] = resultSet.getString( "START_DATE_TIME" )  ;
					
					record[4] = resultSet.getString( "END_DATE_TIME")==null?"":resultSet.getString("END_DATE_TIME");
					record[5] = resultSet.getString( "priority_desc" )  ;
					record[6] = resultSet.getString( "order_status" )  ;
					record[7] = resultSet.getString( "order_type" )  ;
					record[8] = resultSet.getString( "ordering_pract_name" )  ;
					
					
					OrderSat1.add(record) ;
					start++;
				}
				if (resultSet.next())
				{	
					
					String[] templist = (String[])OrderSat1.get(0);
					templist[9] = ""+(end+14);
					OrderSat1.set(0,templist);
				}
			}
		} 
		catch ( Exception e )	
		{			
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}
		return OrderSat1;
	}

	public ArrayList getOrderStatus(String order_category,int start , int end) throws Exception 
	{
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		OrderSat = new ArrayList() ;
		try 
		{
			connection = getConnection() ;
			
			//pstmt = connection.prepareStatement("select A.ORDER_STATUS_CODE ORDER_STATUS_CODE, OR_GET_DESC.OR_ORDER_STATUS_CODE(a.ORDER_STATUS_CODE,?,'2') order_status,(select 'Y' FROM or_status_disch_category b where DISCHARGE_IND='A' AND ORDER_CATEGORY=? AND B.ORDER_STATUS=A.ORDER_STATUS_CODE) DSC_ADVICE,(select 'Y' FROM or_status_disch_category b where DISCHARGE_IND='D' AND ORDER_CATEGORY=? AND B.ORDER_STATUS=A.ORDER_STATUS_CODE) DISCH from OR_ORDER_STATUS_CODE a ORDER BY ORDER_STATUS_CODE") ;//COMMENTED FOR IN068719
			pstmt = connection.prepareStatement("select A.ORDER_STATUS_CODE ORDER_STATUS_CODE, OR_GET_DESC.OR_ORDER_STATUS_CODE(a.ORDER_STATUS_CODE,?,'2') order_status,(select 'Y' FROM or_status_disch_category b where DISCHARGE_IND='A' AND ORDER_CATEGORY=? AND B.ORDER_STATUS=A.ORDER_STATUS_CODE) DSC_ADVICE,(select 'Y' FROM or_status_disch_category b where DISCHARGE_IND='D' AND ORDER_CATEGORY=? AND B.ORDER_STATUS=A.ORDER_STATUS_CODE) DISCH, (SELECT 'Y' FROM or_status_disch_category b WHERE discharge_ind = 'C' AND order_category = ? AND b.order_status = a.order_status_code) AE_CHECK_OUT from OR_ORDER_STATUS_CODE a ORDER BY ORDER_STATUS_CODE") ;//MODIFIED FOR IN068719
			pstmt.setString(1, language_id);
			
			pstmt.setString(2, order_category);
			
			pstmt.setString(3, order_category);
			pstmt.setString(4, order_category);//IN068719
			resultSet = pstmt.executeQuery() ;
			String[] record=null;
			
			if(resultSet!=null) 
			{
				if(start > 0)
					for(int i=0;(i<start-1 && resultSet.next());i++);

				while (start <= end && resultSet != null && resultSet.next() ) 
				{
					record = new String[5];
					record[0] = resultSet.getString( "ORDER_STATUS_CODE" )  ;
					record[1] = resultSet.getString( "order_status" )  ;
					record[2] = resultSet.getString( "DSC_ADVICE")==null?"N":resultSet.getString("DSC_ADVICE");
					record[3] = resultSet.getString( "DISCH")==null?"N":resultSet.getString("DISCH");
					record[4] = resultSet.getString( "AE_CHECK_OUT")==null?"N":resultSet.getString("AE_CHECK_OUT");//IN068719
					OrderSat.add(record) ;
					start++;
				}
				if (resultSet.next())
				{	
					
					String[] templist = (String[])OrderSat.get(0);
					templist[4] = ""+(end+14);
					OrderSat.set(0,templist);
				}
			}
		} 
		catch ( Exception e )	
		{			
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}
		return OrderSat;
	}
//Code Added For ML-BRU-SCF-0184 Start
	public ArrayList getNewOrderStatus(String order_category) throws Exception 
	{
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		OrderSat = new ArrayList() ;
		try 
		{
			connection = getConnection() ;
			
			//pstmt = connection.prepareStatement("select A.ORDER_STATUS_CODE ORDER_STATUS_CODE, OR_GET_DESC.OR_ORDER_STATUS_CODE(a.ORDER_STATUS_CODE,?,'2') order_status,(select 'Y' FROM or_status_disch_category b where DISCHARGE_IND='A' AND ORDER_CATEGORY=? AND B.ORDER_STATUS=A.ORDER_STATUS_CODE) DSC_ADVICE,(select 'Y' FROM or_status_disch_category b where DISCHARGE_IND='D' AND ORDER_CATEGORY=? AND B.ORDER_STATUS=A.ORDER_STATUS_CODE) DISCH from OR_ORDER_STATUS_CODE a ORDER BY ORDER_STATUS_CODE") ;//IN068719
			pstmt = connection.prepareStatement("select A.ORDER_STATUS_CODE ORDER_STATUS_CODE, OR_GET_DESC.OR_ORDER_STATUS_CODE(a.ORDER_STATUS_CODE,?,'2') order_status,(select 'Y' FROM or_status_disch_category b where DISCHARGE_IND='A' AND ORDER_CATEGORY=? AND B.ORDER_STATUS=A.ORDER_STATUS_CODE) DSC_ADVICE,(select 'Y' FROM or_status_disch_category b where DISCHARGE_IND='D' AND ORDER_CATEGORY=? AND B.ORDER_STATUS=A.ORDER_STATUS_CODE) DISCH, (SELECT 'Y' FROM or_status_disch_category b WHERE discharge_ind = 'C' AND order_category = ?  AND b.order_status = a.order_status_code) AE_CHECK_OUT from OR_ORDER_STATUS_CODE a ORDER BY ORDER_STATUS_CODE") ;//IN068719
			pstmt.setString(1, language_id);
			
			pstmt.setString(2, order_category);
			
			pstmt.setString(3, order_category);
			pstmt.setString(4, order_category);//IN068719
			resultSet = pstmt.executeQuery() ;
			//String[] record=null; //Checkstyle
			
		    	while(resultSet!= null&&resultSet.next()){
					OrderSat.add(resultSet.getString( "ORDER_STATUS_CODE" ));
					OrderSat.add(resultSet.getString( "order_status" ));
					OrderSat.add(resultSet.getString( "DSC_ADVICE")==null?"N":resultSet.getString("DSC_ADVICE"));
					OrderSat.add(resultSet.getString( "DISCH")==null?"N":resultSet.getString("DISCH"));
					//OrderSat.add("N") ;//COMMENTED FOR IN068719
					OrderSat.add(resultSet.getString( "AE_CHECK_OUT")==null?"N":resultSet.getString("AE_CHECK_OUT"));//MODIFIED FOR IN068719
					}
					
		} 
		catch ( Exception e )	
		{			
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}
		return OrderSat;
	}
   	public ArrayList getOrderSatList() {
	    System.out.println("Check inside Bean");
		return this.OrderSat;
	}
	
	public void setOrderSatList(ArrayList OrderSat) {
		this.OrderSat = OrderSat;
	}
//Code Added For ML-BRU-SCF-0184 End
	/*public HashMap insert() 
	{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		return map;
	}*/
	public HashMap insert() 
	{
		/*HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		return map;*/

		Connection con 		= null;
		PreparedStatement pstmt 	= null;	
		PreparedStatement psmt 	= null;	
		HashMap map = new HashMap() ;
		map.put( "flag","") ;
		map.put( "traceVal","");
		boolean	flag		  = false;
		StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;

		try
		{
			con = getConnection(); 
			int totalNum = 0;
			String order_category ="";
			String order_status_code = "";
			String long_desc = "";
			String chk1 = "";
			String chk2 = "";
			String chk3 = "";//IN068719
		//	String added_at_ws_no = "";//commented for checkstyle IN068719
			String added_facility_id = "";
			//String modified_at_ws_no = ""; //Checkstyle
			String modified_facility_id = "";
			
			if(recordSet.containsKey("totalRecords"))
				totalNum = Integer.parseInt((String)recordSet.get("totalRecords"));
				
			if(recordSet.containsKey("order_category"))
				order_category = (String)recordSet.get("order_category");
				
			if(recordSet.containsKey("facility_id"))
				added_facility_id = (String)recordSet.get("facility_id");
				
			if(recordSet.containsKey("facility_id"))
				modified_facility_id = (String)recordSet.get("facility_id");
				
			
			//String sqldel = "delete from or_status_disch_category WHERE ORDER_CATEGORY=? AND ADDED_FACILITY_ID=?";
			String sqldel = "delete from or_status_disch_category WHERE ORDER_CATEGORY=? AND (ADDED_FACILITY_ID=? OR MODIFIED_FACILITY_ID='DF')";
			
			psmt = con.prepareStatement(sqldel);
			
				psmt.setString(1,order_category);
				
				psmt.setString(2,added_facility_id);
				
					
			psmt.executeUpdate();
			
			
			String sql = "INSERT INTO or_status_disch_category (DISCHARGE_IND, ORDER_CATEGORY, ORDER_STATUS, ADDED_DATE, ADDED_BY_ID, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_DATE, MODIFIED_BY_ID, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)VALUES(?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			
			totalNum=totalNum-1;
			Set set = recordSet.entrySet();
			Iterator it = set.iterator();
			while (it.hasNext()) {
			  Map.Entry entry = (Map.Entry) it.next();
			  System.out.println(entry.getKey() + " ==:==> " + entry.getValue());
			}
			int jlio = 0;
			for(int i=0;i<OrderSat.size();i++)
			{
				
				order_status_code = "";
				long_desc = "";
				chk1 = "";
				chk2 = "";
				chk3 = "";//IN068719
				
				order_status_code = (String)OrderSat.get(i);
				
				i=i+1;
				long_desc = (String)OrderSat.get(i+1);
					long_desc = long_desc.equals("")?"N":long_desc;
				
				i=i+1;
				chk1 = (String)OrderSat.get(i);
				  chk1 = chk1.equals("")?"N":chk1;
				
				i=i+1;
				chk2 = (String)OrderSat.get(i);
					chk2 = chk2.equals("")?"N":chk2;
					//IN068719starts
					i=i+1;
					chk3 = (String)OrderSat.get(i);
						chk3 = chk3.equals("")?"N":chk3;
						//IN068719 ends
				if(chk1.equalsIgnoreCase("A") || chk1.equalsIgnoreCase("Y"))
				{
				    jlio= jlio+1;
					pstmt.setString(1,"A");
					pstmt.setString(2,order_category);
					pstmt.setString(3,order_status_code);
					pstmt.setString(4,(String)recordSet.get("login_user"));
					
				    pstmt.setString(5, login_at_ws_no);
					pstmt.setString(6, added_facility_id);
					pstmt.setString(7,(String)recordSet.get("login_user"));
					pstmt.setString(8,login_at_ws_no);
					pstmt.setString(9,modified_facility_id);
					
					pstmt.addBatch();
				}
				if(chk2.equalsIgnoreCase("D") || chk2.equalsIgnoreCase("Y"))
				{
					pstmt.setString(1,"D");
					pstmt.setString(2,order_category);
					pstmt.setString(3,order_status_code);
					pstmt.setString(4,(String)recordSet.get("login_user"));
					pstmt.setString(5,login_at_ws_no);
					pstmt.setString(6,added_facility_id);
					pstmt.setString(7,(String)recordSet.get("login_user"));
					pstmt.setString(8,login_at_ws_no);
					pstmt.setString(9,modified_facility_id);
					pstmt.addBatch();
				}
				//i=i+1;//IN068719
				//pstmt.addBatch();
				//IN068719 starts
				if(chk3.equalsIgnoreCase("C") || chk3.equalsIgnoreCase("Y"))
				{
					pstmt.setString(1,"C");
					pstmt.setString(2,order_category);
					pstmt.setString(3,order_status_code);
					pstmt.setString(4,(String)recordSet.get("login_user"));
					pstmt.setString(5,login_at_ws_no);
					pstmt.setString(6,added_facility_id);
					pstmt.setString(7,(String)recordSet.get("login_user"));
					pstmt.setString(8,login_at_ws_no);
					pstmt.setString(9,modified_facility_id);
					pstmt.addBatch();
				}
				//IN068719 ends
			}
			int [] updateCounts = pstmt.executeBatch();	
			flag = true;
			
			for (int k=0;k<updateCounts.length ;k++ )
			{
				if(updateCounts[k]<0  && updateCounts[k] != -2 )
				{
					flag=false;
					break;
				}
			}

			if(flag == true)
			{
				messages.append( getMessage(language_id, "RECORD_MODIFIED", "SM") ) ;				
    			con.commit() ;
			}
			else
			{
				con.rollback();
			}
		}
		catch(Exception e) 
		{
			flag = false;
			traceVal.append(e.getMessage());
			try
			{
				con.rollback();
			}
			catch(Exception e1)
			{
				traceVal.append(e.getMessage());
				e.printStackTrace();
			}
			
			e.printStackTrace();
		}
		finally
		{
			map.clear();
			
			if(psmt != null)	
			{
				try
				{
					psmt.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					traceVal.append(e.getMessage());
				}
			}

			if(pstmt != null)	
			{
				try
				{
					pstmt.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					traceVal.append(e.getMessage());
				}
			}

			if(con != null)
			{
				try
				{
					closeConnection(con);
				}
				catch(Exception e)
				{
					e.printStackTrace();
					traceVal.append(e.getMessage());
				}
			}
		}
		map.put( "result", new Boolean(flag));
		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVal.toString() ) ;
   		return map ;
	}
	public HashMap validate() throws Exception 
	{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}

	public HashMap modify() 
	{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		return map;
	}

	public void setAll( Hashtable recordSet ) 
	{		
		this.recordSet = recordSet;	
		this.mode=(String)recordSet.get("mode");
	}

	public void clear() 
	{
		recordSet = null;
		this.OrderSat = null;
		//super.clear() ;
	}
}
