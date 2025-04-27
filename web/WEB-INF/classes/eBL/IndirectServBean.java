/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved. 
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /**
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V220525             	        	GHL-CRF-0632 	           Mohana Priya K
 */
 
package eBL;
 
import java.io.*;
import java.util.*;
import java.sql.* ;
import eBL.Common.*;
import webbeans.eCommon.*;


public class IndirectServBean extends BlAdapter implements java.io.Serializable 
{
	private static final long serialVersionUID = 1L;
	ArrayList OrderSat = null;
	Hashtable recordSet = null;
	
	public ArrayList getAllOrderCategory(Properties properties) throws Exception {
		Connection con 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		String language_id = properties.getProperty("LOCALE");
		try {
			con			= ConnectionManager.getConnection(properties) ;
			pstmt = con.prepareStatement("SELECT  short_desc,order_category FROM or_order_category_lang_vw  WHERE language_id=? ORDER BY short_desc") ;
			pstmt.setString( 1, language_id);

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_category" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				ConnectionManager.returnConnection(con, properties);
		}

		return OrderCat;
	}
	
	public ArrayList getNewOrderStatus(String order_category,String facility_id) throws Exception 
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		OrderSat = new ArrayList() ;
		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement("SELECT A.ORDER_STATUS_CODE ORDER_STATUS_CODE,OR_GET_DESC.OR_ORDER_STATUS_CODE (a.ORDER_STATUS_CODE, ?, '2') order_status,(SELECT restrict_for_opae_yn FROM BL_RESTRICT_CANC_ORDER_STATUS b WHERE operating_facility_id = ? AND ORDER_CATEGORY = ? AND B.ORDER_STATUS = A.ORDER_STATUS_CODE) restrict_for_opae_yn,(SELECT restrict_for_ipdc_yn FROM BL_RESTRICT_CANC_ORDER_STATUS b WHERE operating_facility_id = ? AND ORDER_CATEGORY = ? AND B.ORDER_STATUS = A.ORDER_STATUS_CODE) restrict_for_ipdc_yn FROM OR_ORDER_STATUS_CODE a ORDER BY ORDER_STATUS_CODE") ;
			pstmt.setString(1, language_id);
			
			pstmt.setString(2, facility_id);
			
			pstmt.setString(3, order_category);
			pstmt.setString(4, facility_id);
			pstmt.setString(5, order_category);
			resultSet = pstmt.executeQuery() ;
		
		    while(resultSet!= null&&resultSet.next()){
				OrderSat.add(resultSet.getString( "ORDER_STATUS_CODE" ));
				OrderSat.add(resultSet.getString( "order_status" ));
				OrderSat.add(resultSet.getString( "restrict_for_opae_yn")==null?"N":resultSet.getString("restrict_for_opae_yn"));
				OrderSat.add(resultSet.getString( "restrict_for_ipdc_yn")==null?"N":resultSet.getString("restrict_for_ipdc_yn"));
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
	    return this.OrderSat;
	}
	
	public void setOrderSatList(ArrayList OrderSat) {
		this.OrderSat = OrderSat;
	}
	
	
		public HashMap insert() 
	{
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
			String added_facility_id = "";
			String modified_facility_id = "";
			
			if(recordSet.containsKey("totalRecords"))
				totalNum = Integer.parseInt((String)recordSet.get("totalRecords"));
				
			if(recordSet.containsKey("order_category"))
				order_category = (String)recordSet.get("order_category");
				
			if(recordSet.containsKey("facility_id"))
				added_facility_id = (String)recordSet.get("facility_id");
				
			if(recordSet.containsKey("facility_id"))
				modified_facility_id = (String)recordSet.get("facility_id");
				
			
			String sqldel = "delete from BL_RESTRICT_CANC_ORDER_STATUS WHERE ORDER_CATEGORY=? AND (ADDED_FACILITY_ID=? OR MODIFIED_FACILITY_ID='DF')";
			
			psmt = con.prepareStatement(sqldel);
			psmt.setString(1,order_category);
			psmt.setString(2,added_facility_id);
				
			psmt.executeUpdate();
			
			System.out.println("291 pendingorderstatusbean.java-insert");
			
			String sql = "INSERT INTO bl_restrict_canc_order_status(operating_facility_id, order_category, order_status,restrict_for_opae_yn, restrict_for_ipdc_yn, added_by_id,added_date, added_at_ws_no, added_facility_id, modified_by_id,modified_date, modified_at_ws_no, modified_facility_id)VALUES(?, ?, ?,?, ?, ?,SYSDATE, ?, ?, ?,SYSDATE, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			totalNum=totalNum-1;
			System.out.println("291 pendingorderstatusbean.java-totalNum-"+totalNum);
			
			Set set = recordSet.entrySet();
			Iterator it = set.iterator();
			while (it.hasNext()) {
			  Map.Entry entry = (Map.Entry) it.next();
			  System.out.println(entry.getKey() + " ==:==> " + entry.getValue());
			}
			
			for(int i=0;i<OrderSat.size();i++)
			{
				System.out.println("291 pendingorderstatusbean.java-OrderSat.size()-"+OrderSat.size());
				order_status_code = "";
				long_desc = "";
				chk1 = "";
				chk2 = "";
				
				order_status_code = (String)OrderSat.get(i);
				System.out.println("291 order_status_code-"+i+"-"+order_status_code);
				i=i+1;
				long_desc = (String)OrderSat.get(i);
					long_desc = long_desc.equals("")?"N":long_desc;
					System.out.println("291 long_desc-"+i+"-"+long_desc);
				i=i+1;
				chk1 = (String)OrderSat.get(i);
				  chk1 = chk1.equals("")?"N":chk1;
				System.out.println("291 chk1-"+i+"-"+chk1);
				i=i+1;
				chk2 = (String)OrderSat.get(i);
				chk2 = chk2.equals("")?"N":chk2;
				System.out.println("291 chk2-"+i+"-"+chk2);
					
				pstmt.setString(1,added_facility_id);
				pstmt.setString(2,order_category);
				pstmt.setString(3,order_status_code);
				pstmt.setString(4,chk1);
				pstmt.setString(5,chk2);
				
				pstmt.setString(6,(String)recordSet.get("login_user"));
				pstmt.setString(7, login_at_ws_no);
				pstmt.setString(8, added_facility_id);
				pstmt.setString(9,(String)recordSet.get("login_user"));
				pstmt.setString(10,login_at_ws_no);
				
				pstmt.setString(11,modified_facility_id);
				
				pstmt.addBatch();
			
			}
			int [] updateCounts = pstmt.executeBatch();	
			System.out.println("291 updateCountslen-"+updateCounts.length);
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
		
	public void setAll( Hashtable recordSet ) 
	{		
		this.recordSet = recordSet;	
		this.mode=(String)recordSet.get("mode");
	}

	public HashMap validate() throws Exception 
	{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}
		
	public void clear() 
	{
		this.OrderSat = null;
	}
}
