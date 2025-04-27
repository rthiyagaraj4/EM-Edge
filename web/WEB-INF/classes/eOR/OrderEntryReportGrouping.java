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
import java.lang.*;
import javax.naming.*;
import javax.rmi.*;
import eCA.CommonCollectionUtils;

import eOR.Common.* ;
import eCommon.Common.*;
import webbeans.eCommon.ConnectionManager;

public class OrderEntryReportGrouping extends OrAdapter implements java.io.Serializable {
	private ArrayList<String> order_type_list = new ArrayList<String>();
	private ArrayList<String> remove_order_type_list = new ArrayList<String>();
	protected String cust_rep_grp_code			= "" ;
	protected String cust_rep_grp_desc					= "" ;
	protected String order_category					= "" ;
	protected String cust_report_id				= "" ;
	protected String report_type_id				= "" ;

	public void setOrderType(String order_type)
	{
		order_type_list.add(order_type);
	}
	public void removeOrderType(String order_type)
	{
		//if (order_type_list.contains(order_type))
		//{
			order_type_list.remove(order_type);
			remove_order_type_list.add(order_type);
		//}

	}

	public void clearObject()
	{
		this.order_type_list.clear();
		this.remove_order_type_list.clear();
		cust_rep_grp_code			= "" ;
		cust_rep_grp_desc					= "" ;
		order_category					= "" ;
		cust_report_id				= "" ;
		report_type_id				= "" ;
		super.clear() ;
	}
	public ArrayList<String> getOrderTypes()
	{
		return this.order_type_list;
	}

	  public ArrayList getcatagory () throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC2") ) ;
			pstmt.setString(1,language_id);
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
			closeConnection(connection) ;
		}

		return OrderCat;
	}






	public String insert(Hashtable inputHash)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		String report_type_id1 =(String) inputHash.get("REPORT_TYPE_ID");
		String cust_rep_grp_code1 = (String) inputHash.get("CUST_REP_GRP_CODE");
		String cust_rep_grp_desc1 =(String) inputHash.get("CUST_REP_GRP_DESC");
		String order_category1 = (String) inputHash.get("ORDER_CATEGORY");
		String cust_report_id1 =(String) inputHash.get("CUST_REPORT_ID");
		String appl_ord_type = (String) inputHash.get("APPL_ORD_TYPE");
		String added_by_id= (String) inputHash.get("ADDED_BY_ID");
		String added_at_ws_no= (String) inputHash.get("ADDED_AT_WS_NO");
		String added_facility_id= (String) inputHash.get("ADDED_FACILITY_ID");
		String eff_status= (String) inputHash.get("EFF_STATUS");
		//String mode= (String) inputHash.get("MODE");
		String sql="";
		String retVal = "";
		int result = 0;
		int[] resultArr = null;
		
         try{
					con =  ConnectionManager.getConnection();
					sql="DELETE FROM OR_CUST_REP_GRP_DTL WHERE CUST_REP_GRP_CODE = ?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,cust_rep_grp_code1);
					result = pstmt.executeUpdate();

					if (pstmt != null)pstmt.close();
					//if(mode.equalsIgnoreCase("1"))
					//{

					sql="DELETE FROM OR_CUST_REP_GRP_HDR WHERE CUST_REP_GRP_CODE = ?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,cust_rep_grp_code1);
					result = pstmt.executeUpdate();
					if (pstmt != null)pstmt.close();


							sql="insert into	OR_CUST_REP_GRP_HDR(REPORT_TYPE_ID,CUST_REP_GRP_CODE, CUST_REP_GRP_DESC, ORDER_CATEGORY, CUST_REPORT_ID,  APPL_ORD_TYPE, ADDED_BY_ID, ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,EFF_STATUS) values(?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)";
							pstmt=con.prepareStatement(sql);
							pstmt.setString(1,report_type_id1);
							pstmt.setString(2,cust_rep_grp_code1);
							pstmt.setString(3,cust_rep_grp_desc1);
							pstmt.setString(4,order_category1);
							pstmt.setString(5,cust_report_id1);
							pstmt.setString(6,appl_ord_type);
							pstmt.setString(7,added_by_id);
							pstmt.setString(8,added_at_ws_no);
							pstmt.setString(9,added_facility_id);
							pstmt.setString(10,added_by_id);
							pstmt.setString(11,added_at_ws_no);
							pstmt.setString(12,added_facility_id);
							pstmt.setString(13,eff_status);

							result = pstmt.executeUpdate();

							if (pstmt != null)pstmt.close();

					//}
					//else
					//{
						/*	sql="update OR_CUST_REP_GRP_HDR set CUST_REP_GRP_DESC = (?),APPL_ORD_TYPE=(?),EFF_STATUS=(?),MODIFIED_BY_ID=(?),MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=(?),MODIFIED_FACILITY_ID=(?) WHERE CUST_REP_GRP_CODE = ?";
							pstmt=con.prepareStatement(sql);
							pstmt.setString(1,cust_rep_grp_desc1);
							pstmt.setString(2,appl_ord_type);
							pstmt.setString(3,eff_status);
							pstmt.setString(4,added_by_id);
							pstmt.setString(5,added_at_ws_no);
							pstmt.setString(6,added_facility_id);
							pstmt.setString(7,cust_report_id1);

							result = pstmt.executeUpdate();

							if (pstmt != null)pstmt.close();
					}*/
					if (result  > 0)
					{
						sql="insert into OR_CUST_REP_GRP_DTL (CUST_REP_GRP_CODE, ORDER_TYPE_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE,MODIFIED_AT_WS_NO,	MODIFIED_FACILITY_ID) VALUES (?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
						pstmt=con.prepareStatement(sql);
						if(appl_ord_type.equals("S"))
						{
							ArrayList<String> order_type_lst = getOrderTypes();
							if (order_type_lst != null && order_type_lst.size() > 0)
							{
								for (int i = 0;i<order_type_lst.size() ;i++ )
								{
									pstmt.setString(1,cust_rep_grp_code1);
									pstmt.setString(2,order_type_lst.get(i));
									pstmt.setString(3,added_by_id);
									pstmt.setString(4,added_at_ws_no);
									pstmt.setString(5,added_facility_id);
									pstmt.setString(6,added_by_id);
									pstmt.setString(7,added_at_ws_no);
									pstmt.setString(8,added_facility_id);
									pstmt.addBatch();
								}
								resultArr = pstmt.executeBatch();
							/*	if (resultArr != null && resultArr.length > 0)
								{*/
									retVal = "TRANS_SUCCESS";
							//	}

							}
						}
						else if(appl_ord_type.equals("A"))
						{
							retVal = "TRANS_SUCCESS";
							/*pstmt.setString(1,cust_rep_grp_code);
							pstmt.setString(2,"*ALL");
							pstmt.setString(3,added_by_id);
							pstmt.setString(4,added_at_ws_no);
							pstmt.setString(5,added_facility_id);
							pstmt.setString(6,added_by_id);
							pstmt.setString(7,added_at_ws_no);
							pstmt.setString(8,added_facility_id);
							result = pstmt.executeUpdate();
							if (result > 0)
							{
								retVal = "TRANS_SUCCESS";
							}*/


						}
						closeStatement(pstmt);
					}
					con.commit();
		}catch(Exception ee)
		{
			try
			{
				ee.printStackTrace();
				retVal = "TRANS_FAILED";
				con.rollback();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
				ee.printStackTrace();
		}
		finally
		{
			try
			{
				if (con != null)	con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		return retVal;
}

/**
*	getQueryVaccineForCategory	-
*	@param	categoryId - this is String
*/
	public CommonCollectionUtils<String, String> getOrderTypes(String order_category,String mode,String cust_rep_grp_code)
	{

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="";
		//String sql = "SELECT  ORDER_TYPE_CODE , SHORT_DESC FROM OR_ORDER_TYPE B WHERE ORDER_CATEGORY = ? AND EFF_STATUS ='E' AND NOT EXISTS ( SELECT 1 FROM OR_CUST_REP_GRP_DTL A WHERE A.ORDER_TYPE_CODE = B.ORDER_TYPE_CODE ) ORDER BY SHORT_DESC";
		if(mode.equalsIgnoreCase("2"))
		{
			//String sql = "SELECT  ORDER_TYPE_CODE , SHORT_DESC FROM OR_ORDER_TYPE B WHERE ORDER_CATEGORY = ? AND EFF_STATUS ='E' ORDER BY SHORT_DESC";
			sql ="SELECT  ORDER_TYPE_CODE ORDER_TYPE_CODE , SHORT_DESC SHORT_DESC FROM OR_ORDER_TYPE B WHERE ORDER_CATEGORY = ? AND EFF_STATUS ='E' AND NOT EXISTS ( SELECT 1 FROM OR_CUST_REP_GRP_DTL A,OR_CUST_REP_GRP_HDR c  WHERE A.ORDER_TYPE_CODE = B.ORDER_TYPE_CODE and a.CUST_REP_GRP_CODE=c.CUST_REP_GRP_CODE and c.eff_status='E') union SELECT c.ORDER_TYPE_CODE ORDER_TYPE_CODE,d.short_desc SHORT_DESC FROM OR_CUST_REP_GRP_DTL c,or_order_type d  WHERE c.CUST_REP_GRP_CODE =? and c.order_type_code=d.order_type_code AND d.EFF_STATUS ='E' ORDER BY SHORT_DESC";
		}
		else
		{
			sql ="SELECT  ORDER_TYPE_CODE , SHORT_DESC FROM OR_ORDER_TYPE B WHERE ORDER_CATEGORY = ? AND EFF_STATUS ='E' AND NOT EXISTS ( SELECT 1 FROM OR_CUST_REP_GRP_DTL A,OR_CUST_REP_GRP_HDR c WHERE A.ORDER_TYPE_CODE = B.ORDER_TYPE_CODE and a.CUST_REP_GRP_CODE=c.CUST_REP_GRP_CODE and c.eff_status='E') ORDER BY SHORT_DESC";
		}

		try
		{
				con =  ConnectionManager.getConnection();
				ps = con.prepareStatement(sql);
				ps.setString(1,order_category);
				if(mode.equalsIgnoreCase("2"))
				{
					ps.setString(2,cust_rep_grp_code);
				}
				rs = ps.executeQuery();
				//int i = 0;
				String order_type_code = "";
				CommonCollectionUtils<String, String> orderTypeMap = new CommonCollectionUtils<String, String>();
				//CommonCollectionUtils<String, String> orderTypeMapCode = new CommonCollectionUtils<String, String>();
				while(rs.next())
				{
					order_type_code = rs.getString("ORDER_TYPE_CODE")==null ? "" : rs.getString("ORDER_TYPE_CODE");
					orderTypeMap.add(order_type_code, rs.getString("SHORT_DESC")==null ? "" : rs.getString("SHORT_DESC"));
					//orderTypeMapCode.add(order_type_code, rs.getString("ORDER_TYPE_CODE")==null ? "" : rs.getString("ORDER_TYPE_CODE"))
				}
				if (rs != null)rs.close();
				if (ps != null)ps.close();
				return orderTypeMap;
		}
		catch(Exception ee)
		{

			ee.printStackTrace();
		}
		finally
		{
			try
			{
				if (con != null)con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}

	public CommonCollectionUtils<String, String> getCustomRepIDs()
	{
		CommonCollectionUtils<String, String> hashMap = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			hashMap = new CommonCollectionUtils<String, String>();
			String sql = "SELECT  CUST_REPORT_ID, CUST_REPORT_DESC FROM OR_CUSTOM_REPORTS ORDER BY 2";
			con =  ConnectionManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next())
			{
				hashMap.add(rs.getString("CUST_REPORT_ID"),rs.getString("CUST_REPORT_DESC"));
			}
			if (rs != null)rs.close();
			if (ps != null)ps.close();
			return hashMap;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}finally{
			try
			{
				if(con != null) con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}

	public String getOrderCategoryValues() {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String  description	="";
		String  value="";
	try
		{
			connection		= ConnectionManager.getConnection();
			pstmt			= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC2"));
			pstmt.setString(1,language_id);
			resultSet		= pstmt.executeQuery() ;
			StringBuffer sb	= new StringBuffer();
			while (resultSet!=null && resultSet.next())
			{
				  description		= resultSet.getString(1);
				  value			= resultSet.getString(2);
				  sb.append(value+ "," + description + ",");
			}
			 String str =   sb.toString() ;
			 sb.setLength(0);
			 return str.substring(0, str.length()-1);
		}
		catch(Exception e){
			e.printStackTrace() ;
			return null;
		}
		finally
		{
			try
			 {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			 }catch(Exception e){
				 e.printStackTrace() ;
			 }
		}
}

	public HashMap<String,String> loadData(String cust_rep_grp_code2)
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;
		HashMap<String,String> dataMap = null;

		try {
			dataMap = new HashMap<String,String>();
			connection	= ConnectionManager.getConnection();
			String sqlQuery = "SELECT CUST_REP_GRP_CODE, CUST_REP_GRP_DESC, ORDER_CATEGORY, CUST_REPORT_ID, REPORT_TYPE_ID, APPL_ORD_TYPE, EFF_STATUS FROM OR_CUST_REP_GRP_HDR WHERE CUST_REP_GRP_CODE =?";
			pstmt		= connection.prepareStatement(sqlQuery) ;
			pstmt.setString(1, cust_rep_grp_code2) ;
			rs	= pstmt.executeQuery();
			if(rs.next())
			{
					dataMap.put("CUST_REP_GRP_CODE",rs.getString("CUST_REP_GRP_CODE"));
					dataMap.put("CUST_REP_GRP_DESC",rs.getString("CUST_REP_GRP_DESC"));
					dataMap.put("ORDER_CATEGORY",rs.getString("ORDER_CATEGORY"));
					dataMap.put("CUST_REPORT_ID",rs.getString("CUST_REPORT_ID"));
					dataMap.put("REPORT_TYPE_ID",rs.getString("REPORT_TYPE_ID"));
					dataMap.put("APPL_ORD_TYPE",rs.getString("APPL_ORD_TYPE"));
					dataMap.put("EFF_STATUS",rs.getString("EFF_STATUS"));

			}
			if (rs != null)rs.close();
			if (pstmt != null)pstmt.close();


			return dataMap;

		} catch ( Exception e )	{
			e.printStackTrace() ;
		} finally {
			try
			{
				if(connection != null) connection.close();
			}
			catch ( Exception e )	{
				e.printStackTrace() ;
			}
		}
		return null;
	}

	public void loadOrderTypes(String cust_rep_grp_code2)
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;


		try {

			connection	= ConnectionManager.getConnection();
			String sqlQuery = "SELECT ORDER_TYPE_CODE FROM OR_CUST_REP_GRP_DTL WHERE CUST_REP_GRP_CODE =?";
			pstmt		= connection.prepareStatement(sqlQuery) ;
			pstmt.setString(1, cust_rep_grp_code2) ;
			rs	= pstmt.executeQuery();
			while(rs.next())
			{
				ArrayList orderTypeValues = (ArrayList)getOrderTypes();
				String order_type = rs.getString("ORDER_TYPE_CODE");


				if(!orderTypeValues.contains(order_type))
				{			
					if(!remove_order_type_list.contains(order_type))
					{
						setOrderType(order_type);	

					}
				}
				//setOrderType(rs.getString("ORDER_TYPE_CODE"));

			}
			if (rs != null)rs.close();
			if (pstmt != null)pstmt.close();

		} catch ( Exception e )	{
			e.printStackTrace() ;
		} finally {
			try
			{
				if(connection != null) connection.close();
			}
			catch ( Exception e )	{
				e.printStackTrace() ;
			}
		}
	}

	public String validate(Hashtable inputHash)
	{
		Connection con = null;
		PreparedStatement pstmt_cat = null;
		PreparedStatement pstmt_specific = null;
		PreparedStatement pstmt = null;
		ResultSet resultset = null;
		ResultSet resultset_cat = null;
		ResultSet resultset_specific = null;
		//String report_type_id =(String) inputHash.get("REPORT_TYPE_ID");
		String cust_rep_grp_code = (String) inputHash.get("CUST_REP_GRP_CODE");
		//String cust_rep_grp_desc =(String) inputHash.get("CUST_REP_GRP_DESC");
		String order_category = (String) inputHash.get("ORDER_CATEGORY");
		//String cust_report_id =(String) inputHash.get("CUST_REPORT_ID");
		String appl_ord_type = (String) inputHash.get("APPL_ORD_TYPE");
		//String added_by_id= (String) inputHash.get("ADDED_BY_ID");
		//String added_at_ws_no= (String) inputHash.get("ADDED_AT_WS_NO");
		//String added_facility_id= (String) inputHash.get("ADDED_FACILITY_ID");
		String eff_status= (String) inputHash.get("EFF_STATUS");
		String mode= (String) inputHash.get("MODE");
		String sql="";
		String retVal = "";
		//int result = 0;
		int total = 0;
		int total_cat = 0;
		int total_specific = 0;
		//int[] resultArr = null;
		boolean flag = true;
		
		
         try
         {
				con =  ConnectionManager.getConnection();
         		//if((mode.equalsIgnoreCase("1"))&&(eff_status.equalsIgnoreCase("E")))
         		if((mode.equalsIgnoreCase("1")))//&&(eff_status.equalsIgnoreCase("E")))
			   {
         			
					sql="select count(*) total FROM OR_CUST_REP_GRP_HDR WHERE CUST_REP_GRP_CODE = ?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,cust_rep_grp_code);
					resultset = pstmt.executeQuery();

					while(resultset!=null&&resultset.next())
					{
						total = Integer.parseInt(resultset.getString("total"));
					}
					if(total>0)
					{
						retVal = "RECORD_EXISTS1";
						flag = false;
					}
					else
					{
						retVal = "RECORD_NOT_EXISTS";
					}

			   }
			   if(flag&&eff_status.equalsIgnoreCase("E"))
			   {
				   if(appl_ord_type.equalsIgnoreCase("A"))
				   {
						sql="select count(*) total FROM OR_CUST_REP_GRP_HDR WHERE eff_status= 'E' and order_category=(?)  and CUST_REP_GRP_CODE not in (?)";
				   }
					else
				   {
						sql="select count(*) total FROM OR_CUST_REP_GRP_HDR WHERE eff_status= 'E' and order_category=(?)  and CUST_REP_GRP_CODE not in (?) and APPL_ORD_TYPE='A'";
				   }
					pstmt_cat=con.prepareStatement(sql);
					pstmt_cat.setString(1,order_category.trim());
					pstmt_cat.setString(2,cust_rep_grp_code.trim());
					resultset_cat = pstmt_cat.executeQuery();
				
					while(resultset_cat!=null&&resultset_cat.next())
					{
						total_cat = Integer.parseInt(resultset_cat.getString("total"));
					}

					if(total_cat>0)
					{
						retVal = "RECORD_EXISTS_FOR_CATEGORY";
						flag = false;
					}
					else
					{
						 if(appl_ord_type.equalsIgnoreCase("S"))
						{
							 sql = "select count(*) total from OR_CUST_REP_GRP_DTL A,OR_CUST_REP_GRP_HDR b WHERE  a.CUST_REP_GRP_CODE = b.CUST_REP_GRP_CODE and b.order_category=? AND  a.CUST_REP_GRP_CODE =? AND EXISTS (SELECT 1 FROM  OR_CUST_REP_GRP_DTL c, OR_CUST_REP_GRP_HDR d WHERE c.CUST_REP_GRP_CODE!=? 	AND c.ORDER_TYPE_CODE=A.ORDER_TYPE_CODE and c.CUST_REP_GRP_CODE=d.CUST_REP_GRP_CODE and d.eff_status='E')";
							pstmt_specific=con.prepareStatement(sql);
							pstmt_specific.setString(1,order_category.trim());
							pstmt_specific.setString(2,cust_rep_grp_code.trim());
							pstmt_specific.setString(3,cust_rep_grp_code.trim());
							resultset_specific = pstmt_specific.executeQuery();
						
							while(resultset_specific!=null&&resultset_specific.next())
							{
								total_specific = Integer.parseInt(resultset_specific.getString("total"));
							}

							if(total_specific>0)
							{
								retVal = "RECORD_EXISTS_FOR_CATEGORY";
								flag = false;
							}
							else
							{
								retVal = "RECORD_NOT_EXISTS";
							}
						}
						else
						{
							retVal = "RECORD_NOT_EXISTS";
						}
					}

				   
		   }
		   else if(flag)
			{
				retVal = "RECORD_NOT_EXISTS";
			}
					
		}catch(Exception ee)
		{
			try
			{
				ee.printStackTrace();
				retVal = "TRANS_FAILED";

				con.rollback();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
				ee.printStackTrace();
		}
		finally
		{
			try
			{
				if (pstmt != null)pstmt.close();	
				if (pstmt_cat != null)pstmt_cat.close();	
				if (pstmt_specific != null)pstmt_specific.close();	
				if (resultset != null)resultset.close();
				if (resultset_cat != null)resultset_cat.close();
				if (resultset_specific != null)resultset_specific.close();
				if (con != null)	con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		return retVal;
		}

		public String getOrderCategoryDesc(String code) 
		{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			String  description	="";
			//String  value="";
			try
			{
				connection		= ConnectionManager.getConnection();
				pstmt			= connection.prepareStatement("SELECT  short_desc FROM or_order_category_lang_vw  WHERE language_id=?  and order_category=(?)");


				pstmt.setString(1,language_id);
				pstmt.setString(2,code);
				resultSet		= pstmt.executeQuery() ;
				while (resultSet!=null && resultSet.next())
				{
					  description		= resultSet.getString("short_desc");
				}

			 return description;
			}
			catch(Exception e){
				e.printStackTrace() ;
				return null;
			}
			finally
			{
				try
				 {
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection(connection);
				 }catch(Exception e){
					 e.printStackTrace() ;
				 }
			}
	}
  }


