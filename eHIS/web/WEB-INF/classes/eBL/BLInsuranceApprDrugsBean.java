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


public class BLInsuranceApprDrugsBean extends BlAdapter implements java.io.Serializable 
{
	//private static final long serialVersionUID = 1L;
	ArrayList OrderSat = null;
	Hashtable recordSet = null;
	HashMap selInsApprdDrugsHM = null;
	
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
	
	public ArrayList getNewOrderStatus(String order_category,String facility_id, String mode, String billingGrp, String payerGroup, String payer, String policyType) throws Exception 
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		OrderSat = new ArrayList() ;
		String qry = "";
		try 
		{
			System.err.println("Inside getNewOrderStatus:"+order_category+"/"+facility_id+"/"+mode+"/"+billingGrp+"/"+payerGroup+"/"+payer+"/"+policyType);
			connection = getConnection() ;
			if("add".equals(mode)){
				qry = "select '**' item_code, 'All Drugs' item_desc, 'N' AGREEMENT_YN, 'N' OP_YN, 'N' EM_YN, 'N' IP_YN, 'N' DC_YN, 'N' ALL_YN from dual UNION select DRUG_CODE item_code,DRUG_DESC item_desc, 'N' AGREEMENT_YN, 'N' OP_YN, 'N' EM_YN, 'N' IP_YN, 'N' DC_YN, 'N' ALL_YN from ph_drug_lang_vw a where language_id=? AND a.DRUG_YN='Y' order by 1";
				pstmt = connection.prepareStatement(qry);
				System.err.println("BLInsuranceApprDrugsBean.java qry in add mode:"+qry);
				pstmt.setString(1, language_id);	

				resultSet = pstmt.executeQuery() ;
		
				while(resultSet!= null&&resultSet.next()){
					OrderSat.add(resultSet.getString( "item_code" ));
					OrderSat.add(resultSet.getString( "item_desc" ));
					OrderSat.add(resultSet.getString( "AGREEMENT_YN"));
					OrderSat.add(resultSet.getString( "IP_YN"));
					OrderSat.add(resultSet.getString( "DC_YN"));				
					OrderSat.add(resultSet.getString( "OP_YN"));
					OrderSat.add(resultSet.getString( "EM_YN"));
					OrderSat.add(resultSet.getString( "ALL_YN"));
				}	
			} else if("modify".equals(mode)){
				
				qry = "SELECT NVL(a.item_code,'**') item_code, 'All Drugs' item_desc, NVL (agreement_yn, 'N') agreement_yn, NVL (op_yn, 'N') op_yn, NVL (em_yn, 'N') em_yn, NVL (ip_yn, 'N') ip_yn, NVL (dc_yn, 'N') dc_yn, (CASE WHEN op_yn = 'Y' AND ip_yn = 'Y' AND em_yn = 'Y' AND dc_yn = 'Y' THEN 'Y' ELSE 'N' END) all_yn from DUAL LEFT JOIN bl_ph_drug_agreement a ON (a.operating_facility_id = ? AND a.blng_grp_id = ? AND a.cust_group_code = ? AND a.cust_code = ? AND a.policy_type_code = ? AND a.item_code = '**')";
				
				qry = qry + " UNION ";
				
				qry = qry + "select a.item_code item_code, a.DRUG_DESC item_desc, NVL(AGREEMENT_YN,'N') AGREEMENT_YN, NVL(OP_YN,'N') OP_YN, NVL(EM_YN,'N') EM_YN, NVL(IP_YN,'N') IP_YN, NVL(DC_YN,'N') DC_YN, (case when OP_YN = 'Y' AND IP_YN = 'Y' AND EM_YN = 'Y' AND DC_YN = 'Y' THEN 'Y' ELSE 'N' END) ALL_YN from ph_drug_lang_vw a left join BL_PH_DRUG_AGREEMENT b on (b.OPERATING_FACILITY_ID = ? and b.BLNG_GRP_ID = ? and b.CUST_GROUP_CODE = ? and b.CUST_CODE = ? and b.POLICY_TYPE_CODE = ? and a.DRUG_CODE = b.ITEM_CODE ) where a.language_id = ? AND a.DRUG_YN='Y' order by 1 ";
				
				System.err.println("BLInsuranceApprDrugsBean.java qry in modify mode:"+qry);
				
				pstmt = connection.prepareStatement(qry);
				pstmt.setString(1, facility_id);
				pstmt.setString(2, billingGrp);
				pstmt.setString(3, payerGroup);
				pstmt.setString(4, payer);		
				pstmt.setString(5, policyType);
				pstmt.setString(6, facility_id);
				pstmt.setString(7, billingGrp);
				pstmt.setString(8, payerGroup);
				pstmt.setString(9, payer);		
				pstmt.setString(10, policyType);				
				pstmt.setString(11, language_id);	

				resultSet = pstmt.executeQuery() ;
			
				while(resultSet!= null&&resultSet.next()){
					OrderSat.add(resultSet.getString( "item_code" ));
					OrderSat.add(resultSet.getString( "item_desc" ));
					OrderSat.add(resultSet.getString( "AGREEMENT_YN"));
					OrderSat.add(resultSet.getString( "IP_YN"));
					OrderSat.add(resultSet.getString( "DC_YN"));				
					OrderSat.add(resultSet.getString( "OP_YN"));
					OrderSat.add(resultSet.getString( "EM_YN"));
					OrderSat.add(resultSet.getString( "ALL_YN"));
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
		//System.err.println("OrderSat:"+OrderSat);
		return OrderSat;
	}
	
	public ArrayList getOrderSatList() {
	    return this.OrderSat;
	}
	
	public void setOrderSatList(ArrayList OrderSat) {
		this.OrderSat = OrderSat;
	}
	
	public void setSelectedInsApprdDrugs(HashMap selInsApprdDrugsHM) {
		this.selInsApprdDrugsHM = selInsApprdDrugsHM;
	}	
	
	public HashMap getSelectedInsApprdDrugs() {
		return this.selInsApprdDrugsHM;
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
