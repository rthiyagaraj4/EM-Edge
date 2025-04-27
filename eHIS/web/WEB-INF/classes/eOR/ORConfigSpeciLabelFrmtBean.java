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

public class ORConfigSpeciLabelFrmtBean extends OrAdapter implements java.io.Serializable {
	private ArrayList<String> order_type_list = new ArrayList<String>();
	private ArrayList<String> remove_order_type_list = new ArrayList<String>();

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
		super.clear() ;
	}
	public ArrayList<String> getOrderTypes()
	{
		return this.order_type_list;
	}

	 public String insert(Hashtable inputHash,Connection con)
	{		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	//	String spec_label_frmt =(String) inputHash.get("SPEC_LABEL_FRMT");
		String facility_id = (String) inputHash.get("FACILITY_ID");
		String ext_appl =(String) inputHash.get("EXT_APPL");
		String spec_num_format = (String) inputHash.get("SPEC_NUM_FORMAT");		
		String appl_order_type = (String) inputHash.get("APPL_ORDER_TYPE");		
		String added_by_id= (String) inputHash.get("ADDED_BY_ID");
		String added_at_ws_no= (String) inputHash.get("ADDED_AT_WS_NO");
		String added_facility_id= (String) inputHash.get("ADDED_FACILITY_ID");			
		String sql="",sql1="";
		String retVal = "";
		String config_ref_no = "";
		int result = 0;
		int[] resultArr = null;

		
         try{	
					String qry = "SELECT OR_SPECIMEN_FRMT_REF.NEXTVAL CONFIG_REF_NO FROM DUAL";
					pstmt = con.prepareStatement(qry);
					rs = pstmt.executeQuery();					
					if(rs != null && rs.next())
					{
						config_ref_no = rs.getString(1);
					}
					if (rs != null)rs.close();
					if (pstmt != null)pstmt.close();

					if (appl_order_type.equals("A"))
					{
						sql="DELETE  FROM OR_CONFIG_SPEC_FRMT_DTL WHERE CONFIG_REF_NO IN (SELECT CONFIG_REF_NO FROM OR_CONFIG_SPEC_FRMT_HDR WHERE FACILITY_ID = ?)";						
						sql1="DELETE  FROM OR_CONFIG_SPEC_FRMT_HDR WHERE FACILITY_ID = ?";	
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1,facility_id);
						pstmt.executeUpdate();
						if (pstmt != null)pstmt.close();
						pstmt = con.prepareStatement(sql1);
						pstmt.setString(1,facility_id);
						pstmt.executeUpdate();
						if (pstmt != null)pstmt.close();
					}
					
				
					sql="insert into	OR_CONFIG_SPEC_FRMT_HDR(CONFIG_REF_NO, FACILITY_ID, EXT_APPL, SPEC_NUM_FORMAT,APPL_ORDER_TYPE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,config_ref_no);
				//	pstmt.setString(2,spec_label_frmt);
					pstmt.setString(2,facility_id);
					pstmt.setString(3,ext_appl);
					pstmt.setString(4,spec_num_format);					
					pstmt.setString(5,appl_order_type);					
					pstmt.setString(6,added_by_id);
					pstmt.setString(7,added_at_ws_no);
					pstmt.setString(8,added_facility_id);
					pstmt.setString(9,added_by_id);
					pstmt.setString(10,added_at_ws_no);
					pstmt.setString(11,added_facility_id);					

					result = pstmt.executeUpdate();
					
					if (pstmt != null)pstmt.close();					
					if (result  > 0 && appl_order_type.equals("S"))
					{
						sql="insert into OR_CONFIG_SPEC_FRMT_DTL (CONFIG_REF_NO, ORDER_TYPE_CODE) VALUES (?,?)";
						pstmt=con.prepareStatement(sql);						
						ArrayList<String> order_type_lst = getOrderTypes();
						
						if (order_type_lst != null && order_type_lst.size() > 0)
						{
							for (int i = 0;i<order_type_lst.size() ;i++ )
							{
								
								pstmt.setString(1,config_ref_no);
								pstmt.setString(2,order_type_lst.get(i));								
								pstmt.addBatch();
							}
							resultArr = pstmt.executeBatch();
							
							retVal = "TRANS_SUCCESS";						
						}											
					}else if (result  > 0 && appl_order_type.equals("A")){
						retVal = "TRANS_SUCCESS";
					}
					
					con.commit();
		}catch(Exception ee)
		{
			try
			{
				ee.printStackTrace();
				retVal = "TRANS_FAILED";
				
				
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
				ee.printStackTrace();
		}		
		
		return retVal;
}

public String update(Connection con,Hashtable inputHash)
	{		
		PreparedStatement pstmt = null;			
		ResultSet rs =null;
		String sql="";
		String sql1="";
		String retVal = "";	
		int result = 0;
		int[] resultArr = null;	
		
         try{											
					String spec_frmt_exists_yn = "";
					String config_ref_no = (String) inputHash.get("CONFIG_REF_NO");
					String facility_id = (String) inputHash.get("FACILITY_ID");
					//String ext_appl =(String) inputHash.get("EXT_APPL"); //COMMON-ICN-0122
					String spec_num_format = (String) inputHash.get("SPEC_NUM_FORMAT");		
					String appl_order_type = (String) inputHash.get("APPL_ORDER_TYPE");		
					String added_by_id= (String) inputHash.get("ADDED_BY_ID");
					String added_at_ws_no= (String) inputHash.get("ADDED_AT_WS_NO");
					String added_facility_id= (String) inputHash.get("ADDED_FACILITY_ID");	
															
					sql="SELECT 'Y' FROM OR_CONFIG_SPEC_FRMT_HDR WHERE FACILITY_ID =? AND APPL_ORDER_TYPE='A'";

					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,facility_id);
					rs = pstmt.executeQuery();
					if (rs.next())
					{
						spec_frmt_exists_yn = rs.getString(1);
					}
					if (rs != null)rs.close();
					if (pstmt != null)pstmt.close();
					
					if (spec_frmt_exists_yn.equals("Y") || appl_order_type.equals("A"))
					{
						sql="DELETE  FROM OR_CONFIG_SPEC_FRMT_DTL WHERE CONFIG_REF_NO IN (SELECT CONFIG_REF_NO FROM OR_CONFIG_SPEC_FRMT_HDR WHERE FACILITY_ID = ?)";						
						sql1="DELETE  FROM OR_CONFIG_SPEC_FRMT_HDR WHERE FACILITY_ID = ? AND CONFIG_REF_NO !=?";						
						
					}else{
						sql="DELETE  FROM OR_CONFIG_SPEC_FRMT_DTL WHERE  CONFIG_REF_NO=?";
					}
									
					pstmt=con.prepareStatement(sql);	
					if (!spec_frmt_exists_yn.equals("Y"))
						pstmt.setString(1,config_ref_no);
					else
						pstmt.setString(1,facility_id);
					
					pstmt.executeUpdate();
					if (pstmt != null)pstmt.close();			
					
					if (spec_frmt_exists_yn.equals("Y")){
						pstmt=con.prepareStatement(sql1);	
						pstmt.setString(1,facility_id);
						pstmt.setString(2,config_ref_no);
						pstmt.executeUpdate();
					}
					if (pstmt != null)pstmt.close();			
					sql="UPDATE OR_CONFIG_SPEC_FRMT_HDR SET SPEC_NUM_FORMAT=?,APPL_ORDER_TYPE = ?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE  CONFIG_REF_NO=?";

					pstmt=con.prepareStatement(sql);			
					pstmt.setString(1,spec_num_format);
					pstmt.setString(2,appl_order_type);
					pstmt.setString(3,added_by_id);
					pstmt.setString(4,added_at_ws_no);
					pstmt.setString(5,added_facility_id);
					pstmt.setString(6,config_ref_no);

					result = pstmt.executeUpdate(); 
					if (pstmt != null)pstmt.close();			
					if (appl_order_type.equals("S"))
					{			
						sql="INSERT INTO OR_CONFIG_SPEC_FRMT_DTL (CONFIG_REF_NO, ORDER_TYPE_CODE) VALUES (?,?)";
						pstmt=con.prepareStatement(sql);						
						ArrayList<String> order_type_lst = getOrderTypes();
						
						if (order_type_lst != null && order_type_lst.size() > 0)
						{
							for (int i = 0;i<order_type_lst.size() ;i++ )
							{
								
								pstmt.setString(1,config_ref_no);
								pstmt.setString(2,order_type_lst.get(i));								
								pstmt.addBatch();
							}
							resultArr = pstmt.executeBatch();
							if (pstmt != null)pstmt.close();
							retVal = "TRANS_SUCCESS";						
						}		
					}else if (appl_order_type.equals("A")){
						retVal = "TRANS_SUCCESS";
					}
			
				
				con.commit();
		}catch(Exception ee)
		{
			try
			{
				ee.printStackTrace();
				retVal = "TRANS_FAILED";
				
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
				ee.printStackTrace();
		}		
		
		return retVal;
}

public CommonCollectionUtils<String, String> getFacilities()
	{

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="";		
		
		sql = "SELECT  FACILITY_ID, FACILITY_NAME FROM SM_FACILITY_PARAM WHERE STATUS='E' ORDER BY FACILITY_NAME";	
		try
		{
				con =  ConnectionManager.getConnection();
				ps = con.prepareStatement(sql);			
				rs = ps.executeQuery();								
				String facility_id = "";
				CommonCollectionUtils<String, String> facilityMap = new CommonCollectionUtils<String, String>();
				//CommonCollectionUtils<String, String> orderTypeMapCode = new CommonCollectionUtils<String, String>();
				while(rs.next())
				{
					facility_id = rs.getString("FACILITY_ID")==null ? "" : rs.getString("FACILITY_ID");
					facilityMap.add(facility_id, rs.getString("FACILITY_NAME")==null ? "" : rs.getString("FACILITY_NAME"));
					//orderTypeMapCode.add(order_type_code, rs.getString("ORDER_TYPE_CODE")==null ? "" : rs.getString("ORDER_TYPE_CODE"))
				}			
				if (rs != null)rs.close();
				if (ps != null)ps.close();
				return facilityMap;
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

/**
*	getSpecimenNoFormats	- 
*/
	public CommonCollectionUtils<String, String> getSpecimenNoFormats()
	{

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="";		
		
		sql = "SELECT  SPEC_NO_FRMT_CODE, DESCRIPTION, SPEC_NO_FORMAT FROM OR_SPECIMEN_NO_FORMAT ORDER BY DESCRIPTION";
		try
		{
				con =  ConnectionManager.getConnection();
				ps = con.prepareStatement(sql);			
				rs = ps.executeQuery();
				//int i = 0; //COMMON-ICN-0122
				String spec_no_frmt_code = "";
				CommonCollectionUtils<String, String> specimenNoFrmtMap = new CommonCollectionUtils<String, String>();				
				while(rs.next())
				{
					spec_no_frmt_code = rs.getString("SPEC_NO_FRMT_CODE")==null ? "" : rs.getString("SPEC_NO_FRMT_CODE");
					specimenNoFrmtMap.add(spec_no_frmt_code, rs.getString("DESCRIPTION")==null ? "" : rs.getString("DESCRIPTION"));				
				}
				
				if (rs != null)rs.close();
				if (ps != null)ps.close();
				return specimenNoFrmtMap;
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

	public CommonCollectionUtils<String, String> getExtApplications()
	{

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="";		
		
		sql = "select A.EXT_IMAGE_APPL_ID,B.EXT_IMAGE_APPL_NAME from CA_EXT_APPL_DETAIL A , CA_EXT_IMAGE_APPL B WHERE A.ORDER_CATEGORY IN ('LB','OR') and B.EXT_IMAGE_APPL_ID =  A.EXT_IMAGE_APPL_ID AND A.EFF_STATUS = 'E' ORDER BY B.EXT_IMAGE_APPL_NAME";
		try
		{
				con =  ConnectionManager.getConnection();
				ps = con.prepareStatement(sql);			
				rs = ps.executeQuery();
				//int i = 0;			//COMMON-ICN-0122	
				CommonCollectionUtils<String, String> specimenlblFrmtMap = new CommonCollectionUtils<String, String>();				
				specimenlblFrmtMap.add("IBAOR", "IBA Order Entry");
				while(rs.next())
				{					
					specimenlblFrmtMap.add(rs.getString("EXT_IMAGE_APPL_ID"), rs.getString("EXT_IMAGE_APPL_NAME")==null ? "" : rs.getString("EXT_IMAGE_APPL_NAME"));				
				}			
				if (rs != null)rs.close();
				if (ps != null)ps.close();
				return specimenlblFrmtMap;
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

/**
*	getQueryVaccineForCategory	-
*	@param	categoryId - this is String
*/
	public CommonCollectionUtils<String, String> getOrderTypes(HashMap<String,String> paramMap )
	{

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="";
		//String mode = paramMap.get("MODE")==null?"":paramMap.get("MODE"); //COMMON-ICN-0122
		String config_ref_no = paramMap.get("CONFIG_REF_NO")==null?"":paramMap.get("CONFIG_REF_NO");		
		String facility_id = paramMap.get("FACILITY_ID")==null?"":paramMap.get("FACILITY_ID");		
		
		if(!config_ref_no.equals(""))
		{
			//String sql = "SELECT  ORDER_TYPE_CODE , SHORT_DESC FROM OR_ORDER_TYPE B WHERE ORDER_CATEGORY IN ('LB','RL') AND EFF_STATUS ='E' ORDER BY SHORT_DESC";
			sql = "SELECT  ORDER_TYPE_CODE , SHORT_DESC FROM OR_ORDER_TYPE B WHERE ORDER_CATEGORY IN ('LB','RL') AND EFF_STATUS ='E' AND NOT EXISTS (SELECT 1 FROM OR_CONFIG_SPEC_FRMT_DTL A,OR_CONFIG_SPEC_FRMT_HDR C WHERE A.ORDER_TYPE_CODE = B.ORDER_TYPE_CODE AND C.CONFIG_REF_NO = A.CONFIG_REF_NO AND A.CONFIG_REF_NO NOT IN (?) AND FACILITY_ID=? ) ORDER BY 2";
		}
		else
		{
			sql = "SELECT  ORDER_TYPE_CODE , SHORT_DESC FROM OR_ORDER_TYPE B WHERE ORDER_CATEGORY IN ('LB','RL') AND EFF_STATUS ='E' AND NOT EXISTS (SELECT 1 FROM OR_CONFIG_SPEC_FRMT_DTL A,OR_CONFIG_SPEC_FRMT_HDR C WHERE A.ORDER_TYPE_CODE = B.ORDER_TYPE_CODE AND C.CONFIG_REF_NO = A.CONFIG_REF_NO AND FACILITY_ID=?) ORDER BY 2";
		}

		try
		{
				con =  ConnectionManager.getConnection();
				ps = con.prepareStatement(sql);
			//	ps.setString(1,order_category);
				if(!config_ref_no.equals(""))
				{
					ps.setString(1,config_ref_no);					
					ps.setString(2,facility_id);					
				}else{
					ps.setString(1,facility_id);			
				}
				rs = ps.executeQuery();
				//int i = 0; //COMMON-ICN-0122
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

	public String getSpecNumFrmtValues() {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String  description	="";
		String  value="";
	try
		{
			String sqlQuery = "SELECT  SPEC_NO_FRMT_CODE, DESCRIPTION, SPEC_NO_FORMAT FROM OR_SPECIMEN_NO_FORMAT ORDER BY DESCRIPTION"; 
			connection		= ConnectionManager.getConnection();
			pstmt			= connection.prepareStatement(sqlQuery);			
			resultSet		= pstmt.executeQuery() ;
			StringBuffer sb	= new StringBuffer();
			while (resultSet!=null && resultSet.next())
			{
				  description		= resultSet.getString(2);
				  value			= resultSet.getString(1);
				  sb.append(value+ "," + description + ",");
			}
			 String str =   sb.toString() ;
			 sb.setLength(0);
			 return str.substring(0, str.length()-1);
		}
		catch(Exception e){
			System.err.println(e.getMessage());
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
public String getSpecLabelFrmtValues() {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String  description	="";
		String  value="";
	try
		{
			String sqlQuery = "SELECT  SPEC_NO_FRMT_CODE, DESCRIPTION, SPEC_NO_FORMAT FROM OR_SPECIMEN_NO_FORMAT ORDER BY DESCRIPTION"; 
			connection		= ConnectionManager.getConnection();
			pstmt			= connection.prepareStatement(sqlQuery);			
			resultSet		= pstmt.executeQuery() ;
			StringBuffer sb	= new StringBuffer();
			while (resultSet!=null && resultSet.next())
			{
				  value			= resultSet.getString(1);
				  description		= resultSet.getString(2);				 
				  sb.append(value+ "," + description + ",");
			}
			 String str =   sb.toString() ;
			 sb.setLength(0);
			 return str.substring(0, str.length()-1);
		}
		catch(Exception e){
			System.err.println(e.getMessage());
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

	public HashMap<String,String> loadData(String config_ref_no)
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;
		HashMap<String,String> dataMap = null;
		
		try {
			dataMap = new HashMap<String,String>();
			connection	= ConnectionManager.getConnection();
			String sqlQuery = "SELECT CONFIG_REF_NO, FACILITY_ID, EXT_APPL, SPEC_NUM_FORMAT,APPL_ORDER_TYPE FROM OR_CONFIG_SPEC_FRMT_HDR WHERE CONFIG_REF_NO =?";
			pstmt		= connection.prepareStatement(sqlQuery) ;
			pstmt.setString(1, config_ref_no) ;
			rs	= pstmt.executeQuery();
			if(rs.next())
			{
					dataMap.put("CONFIG_REF_NO",rs.getString("CONFIG_REF_NO"));
					dataMap.put("APPL_ORDER_TYPE",rs.getString("APPL_ORDER_TYPE"));
					dataMap.put("FACILITY_ID",rs.getString("FACILITY_ID"));
					dataMap.put("EXT_APPL",rs.getString("EXT_APPL"));
					dataMap.put("SPEC_NUM_FORMAT",rs.getString("SPEC_NUM_FORMAT"));					
					
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

	public void loadOrderTypes(String config_ref_no)
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;

		
		try {

			connection	= ConnectionManager.getConnection();
			String sqlQuery = "SELECT ORDER_TYPE_CODE FROM OR_CONFIG_SPEC_FRMT_DTL WHERE CONFIG_REF_NO =?";
			pstmt		= connection.prepareStatement(sqlQuery) ;
			pstmt.setString(1, config_ref_no) ;
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
		PreparedStatement pstmt = null;
		ResultSet resultset = null;		
		String config_ref_no = "";
	//	String spec_label_frmt =(String) inputHash.get("SPEC_LABEL_FRMT");
		String facility_id = (String) inputHash.get("FACILITY_ID");
		String ext_appl =(String) inputHash.get("EXT_APPL");
		String spec_num_format = (String) inputHash.get("SPEC_NUM_FORMAT");	
		//COMMON-ICN-0122 Start		
		//String appl_order_type = (String) inputHash.get("APPL_ORDER_TYPE");		
		//String added_by_id= (String) inputHash.get("ADDED_BY_ID");
		//String added_at_ws_no= (String) inputHash.get("ADDED_AT_WS_NO");
		//String added_facility_id= (String) inputHash.get("ADDED_FACILITY_ID");		
		//String spec_frmt_exists_yn= (String) inputHash.get("SPEC_FRMT_EXISTS_YN");		
		//COMMON-ICN-0122 End
		String sql="";
		String retVal = "";				
		//String config_ref_no = "";				

         try
        {
				con =  ConnectionManager.getConnection();   												
				sql="SELECT CONFIG_REF_NO FROM OR_CONFIG_SPEC_FRMT_HDR WHERE FACILITY_ID =? AND APPL_ORDER_TYPE='A'";
				pstmt=con.prepareStatement(sql);				
				pstmt.setString(1,facility_id);
				resultset = pstmt.executeQuery();
				if (resultset.next())
				{
					config_ref_no = resultset.getString("CONFIG_REF_NO");
				}
				if(resultset!=null)resultset.close();
				if(pstmt!=null)pstmt.close();		 		
				
				if(!config_ref_no.equals(""))
				{
					inputHash.put("CONFIG_REF_NO",config_ref_no);
				}
				
				
				if (config_ref_no.equals(""))
				{
					sql="SELECT CONFIG_REF_NO FROM OR_CONFIG_SPEC_FRMT_HDR WHERE FACILITY_ID =? AND EXT_APPL = ? AND SPEC_NUM_FORMAT=?";
					pstmt=con.prepareStatement(sql);
					//pstmt.setString(1,spec_label_frmt);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,ext_appl);
					pstmt.setString(3,spec_num_format);
					resultset = pstmt.executeQuery();
					
					while(resultset!=null&&resultset.next())
					{
						config_ref_no = resultset.getString("CONFIG_REF_NO") ==null ? "" : resultset.getString("CONFIG_REF_NO") ;
						inputHash.put("CONFIG_REF_NO",config_ref_no);
					}
				}
				
				
				if(!config_ref_no.equals(""))
				{
					retVal = update(con,inputHash);								
				}
				else
				{
					 retVal = insert(inputHash,con);						
				}
				
				if(resultset!=null)resultset.close();
				if(pstmt!=null)pstmt.close();		 			 
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
				if (resultset != null)resultset.close();		
				if (pstmt != null)pstmt.close();									
				if (con != null)	con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return retVal;
		}

	//	public String getConfigrefNo(String spec_label_frmt,String facility_id,String ext_appl,String spec_num_format)
		public String getConfigrefNo(String facility_id,String ext_appl,String spec_num_format)
		{	
			String config_ref_no = "";
			Connection con = null;		
			PreparedStatement pstmt = null;
			ResultSet rs = null;		
			try
			{
				con =  ConnectionManager.getConnection();         		         			
				String sql="SELECT CONFIG_REF_NO FROM OR_CONFIG_SPEC_FRMT_HDR WHERE FACILITY_ID =? AND EXT_APPL = ? AND SPEC_NUM_FORMAT=?";
				pstmt=con.prepareStatement(sql);
				//pstmt.setString(1,spec_label_frmt);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,ext_appl);
				pstmt.setString(3,spec_num_format);
				rs = pstmt.executeQuery();
				
				while(rs!=null&&rs.next())
				{
					config_ref_no = rs.getString("CONFIG_REF_NO") ==null ? "" : rs.getString("CONFIG_REF_NO") ;
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}finally
			{
				try
				{
					if (rs != null)rs.close();		
					if (pstmt != null)pstmt.close();									
					if (con != null)	con.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			return config_ref_no;
		}		
  

public String getFacilityString() {
Connection 	connection  = null;
java.sql.PreparedStatement pstmt		= null;
java.sql.ResultSet			rs			= null;
try
	{
		connection  = getConnection();
		String sql = "SELECT  FACILITY_ID, FACILITY_NAME FROM SM_FACILITY_PARAM WHERE STATUS='E' ORDER BY FACILITY_NAME";	

		pstmt						= connection.prepareStatement(sql);		
		 rs		= pstmt.executeQuery();
	    StringBuffer sb			    = new StringBuffer();
		while (rs.next())
			{
				sb.append(ChkDef.defaultString(rs.getString(1)));
			    sb.append(",");
			    sb.append(ChkDef.defaultString(rs.getString(2)));
				 sb.append(",");
			}

		 String str =   sb.toString() ;
		 return str.substring(0, str.length()-1);
	}
	catch(Exception e){
		e.printStackTrace();
		return null;
	}
	finally
	{
		try
		 {
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace() ;

		 }
	}
}

public String getExternalString() {
Connection 	connection  = null;
java.sql.PreparedStatement pstmt		= null;
java.sql.ResultSet			rs			= null;
try
	{
		connection  = getConnection();
		String sql = "select A.EXT_IMAGE_APPL_ID,B.EXT_IMAGE_APPL_NAME from CA_EXT_APPL_DETAIL A , CA_EXT_IMAGE_APPL B WHERE A.ORDER_CATEGORY IN ('LB','OR') and B.EXT_IMAGE_APPL_ID =  A.EXT_IMAGE_APPL_ID ORDER BY B.EXT_IMAGE_APPL_NAME";

		pstmt						= connection.prepareStatement(sql);		
		 rs		= pstmt.executeQuery();
	    StringBuffer sb			    = new StringBuffer();
		sb.append("IBAOR,IBA Order Entry,");		
	
		while (rs.next())
			{
				sb.append(ChkDef.defaultString(rs.getString(1)));
			    sb.append(",");
			    sb.append(ChkDef.defaultString(rs.getString(2)));
				 sb.append(",");
			}

		 String str =   sb.toString() ;
		 return str.substring(0, str.length()-1);
	}
	catch(Exception e){
		e.printStackTrace();
		return null;
	}
	finally
	{
		try
		 {
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace() ;

		 }
	}
}

public String getSpecFrmtString() {
Connection 	connection  = null;
java.sql.PreparedStatement pstmt		= null;
java.sql.ResultSet			rs			= null;
try
	{
		connection  = getConnection();
		String sql = "SELECT  SPEC_NO_FRMT_CODE, DESCRIPTION FROM OR_SPECIMEN_NO_FORMAT ORDER BY DESCRIPTION";	

		pstmt						= connection.prepareStatement(sql);		
		 rs		= pstmt.executeQuery();
	    StringBuffer sb			    = new StringBuffer();
	
		while (rs.next())
			{
			    sb.append(ChkDef.defaultString(rs.getString(1)));
			    sb.append(",");
			    sb.append(ChkDef.defaultString(rs.getString(2)));
				 sb.append(",");
			}

		 String str =   sb.toString() ;
		 return str.substring(0, str.length()-1);
	}
	catch(Exception e){
		e.printStackTrace();
		return null;
	}
	finally
	{
		try
		 {
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace() ;

		 }
	}
}
public String isExistsSpecFrmtForAllOT(String facility_id)
{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="";		
		String config_ref_no = "";
		
		sql="SELECT config_ref_no FROM OR_CONFIG_SPEC_FRMT_HDR WHERE FACILITY_ID =? AND APPL_ORDER_TYPE='A'";
		try
		{
				con =  ConnectionManager.getConnection();
				ps = con.prepareStatement(sql);		
				ps.setString(1,facility_id);
				rs = ps.executeQuery();				
				if(rs.next())
				{	
					config_ref_no = rs.getString("config_ref_no")==null ? "" : rs.getString("config_ref_no");										
				}			
				if (rs != null)rs.close();
				if (ps != null)ps.close();
				return config_ref_no;
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
}
