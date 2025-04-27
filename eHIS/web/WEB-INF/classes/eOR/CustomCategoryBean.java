/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import eOR.Common.* ;
import java.io.*;
import java.util.*;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import eOR.Common.* ;
import eCommon.Common.*;

public class CustomCategoryBean extends OrAdapter implements java.io.Serializable 
{
	Hashtable recordSet = null;

	public ArrayList getCustomCategory(String login_user) throws Exception 
	{
		System.out.println("18 CustomCategoryBean.java login_user=>"+login_user+"<=");
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String sql = "";
		ArrayList OrderCat = new ArrayList() ;
		try 
		{
			connection = getConnection() ;
			
			sql = "SELECT order_category, short_desc,custom_category_yn FROM or_custom_category WHERE order_category NOT IN ('CS', 'CN') AND appl_user_id = ?";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString( 1, login_user);
				
			resultSet = pstmt.executeQuery() ;
			System.out.println("32 CustomCategoryBean.java");
			String[] record=null;
			
			while ( resultSet != null && resultSet.next() ) 
			{
				System.out.println("32 CustomCategoryBean.java");
				record = new String[3];
				record[0] = resultSet.getString( "ORDER_CATEGORY" )  ;
				record[1] = resultSet.getString( "SHORT_DESC" )  ;
				record[2] = resultSet.getString( "CUSTOM_CATEGORY_YN")==null?"N":resultSet.getString("CUSTOM_CATEGORY_YN");
				//record[2] = resultSet.getString( "CUSTOM_CATEGORY")==null?"N":resultSet.getString("CUSTOM_CATEGORY");
				
				OrderCat.add(record) ;
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
		return OrderCat;
	}
	public ArrayList getOrderCategory() throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		try 
		{
			connection = getConnection() ;
			
			pstmt = connection.prepareStatement("SELECT order_category, short_desc,'N' custom_category FROM or_order_category WHERE order_category NOT IN ('CS', 'CN') ") ;
			resultSet = pstmt.executeQuery() ;
			String[] record=null;

			while ( resultSet != null && resultSet.next() ) 
			{
				record = new String[3];
				record[0] = resultSet.getString( "ORDER_CATEGORY" )  ;
				record[1] = resultSet.getString( "SHORT_DESC" )  ;
				record[2] = resultSet.getString( "custom_category" )  ;
				OrderCat.add(record) ;
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
		return OrderCat;
	}

	public HashMap insert() 
	{
		/*HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		return map;*/

		Connection con 		= null;
		PreparedStatement pstmt 	= null;	
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
			
			if(recordSet.containsKey("totalRecords"))
				totalNum = Integer.parseInt((String)recordSet.get("totalRecords"));

			String sql = "insert into OR_CUSTOM_CATEGORY(SHORT_DESC,CUSTOM_CATEGORY_YN,ORDER_CATEGORY,APPL_USER_ID)values(?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			
			String orCat = null;
			String shortdesc = null;
			String chk1 = "";
			totalNum=totalNum-1;
			System.out.println("CustomCategoryBean.java,147,totalNum=>"+totalNum);

			for(int i=0;i<=totalNum;i++)
			{
				orCat = "";
				shortdesc="";
				chk1 = "";

 				if(recordSet.containsKey("order_cat"+i))
					orCat  = (String) recordSet.get("order_cat"+i); 

				if(recordSet.containsKey("short_desc"+i))
					shortdesc   = (String) recordSet.get("short_desc"+i);
				shortdesc = shortdesc.equals("")?"N":shortdesc;

				if(recordSet.containsKey("chk1_"+i))
					chk1   = (String) recordSet.get("chk1_"+i);
				chk1 = chk1.equals("")?"N":chk1;
	             
				pstmt.setString(1,shortdesc);
				pstmt.setString(2,chk1);
				pstmt.setString(3,orCat);
				pstmt.setString(4,(String)recordSet.get("login_user"));
				System.out.println("CustomCategoryBean.java,169,shortdesc=>"+shortdesc+",chk1=>"+chk1+",orCat=>"+orCat);
				pstmt.addBatch();
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
			System.out.println("CustomCategoryBean.java,207,message=>"+e.getMessage());
			e.printStackTrace();
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
		Connection con 		= null;
		PreparedStatement pstmt 	= null;	
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
			
			if(recordSet.containsKey("totalRecords"))
				totalNum = Integer.parseInt((String)recordSet.get("totalRecords"));

			String sql = "UPDATE OR_CUSTOM_CATEGORY SET SHORT_DESC=?,CUSTOM_CATEGORY_YN = ? WHERE ORDER_CATEGORY=?";
			
			pstmt = con.prepareStatement(sql);
			
			String orCat = null;
			String shortdesc = null;
			String chk1 = "";
			totalNum=totalNum-1;
			System.out.println("CustomCategoryBean.java,147,totalNum=>"+totalNum);

			for(int i=0;i<=totalNum;i++)
			{
				orCat = "";
				shortdesc="";
				chk1 = "";

 				if(recordSet.containsKey("order_cat"+i))
					orCat  = (String) recordSet.get("order_cat"+i); 

				if(recordSet.containsKey("short_desc"+i))
					shortdesc   = (String) recordSet.get("short_desc"+i);
				shortdesc = shortdesc.equals("")?"N":shortdesc;

				if(recordSet.containsKey("chk1_"+i))
					chk1   = (String) recordSet.get("chk1_"+i);
				chk1 = chk1.equals("")?"N":chk1;
	             
				pstmt.setString(1,shortdesc);
				pstmt.setString(2,chk1);
				pstmt.setString(3,orCat);
				System.out.println("CustomCategoryBean.java,169,shortdesc=>"+shortdesc+",chk1=>"+chk1+",orCat=>"+orCat);
				pstmt.addBatch();
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
			System.out.println("CustomCategoryBean.java,207,message=>"+e.getMessage());
			e.printStackTrace();
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
	}

	public void clear() 
	{
		recordSet = null;
		super.clear() ;
	}
}
