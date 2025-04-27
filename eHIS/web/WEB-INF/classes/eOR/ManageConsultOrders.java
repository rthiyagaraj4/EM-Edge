/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           created
06/09/2012      IN033474		Chowminya G     Order catalogue package containing Multi consult orders
06/09/2013      IN028193		Chowminya G     The Order Associated Package would reduce a doctor work to place orders.
17/09/2013 		IN043423		Chowminya G		Multi Consult Order Window - APP-OR0397 Exception Occurred - Unable to complete the Operation. Please Retry
24/07/2018		IN067437		Subha M			In multi consult order for package patient, packages of both facility are appearing.
17/10/2019	  IN071558		sivabagyam	 17/10/2019        Ramesh G       KDAH-SCF-0602
19/11/2019	  IN071816		sivabagyam	 17/10/2019        Ramesh G      BL-KDAH-MultiConsult Orders
--------------------------------------------------------------------------------------------------------------------
*/ 
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

public class ManageConsultOrders extends OrAdapter implements java.io.Serializable 
{
	private ArrayList<String> order_type_list = new ArrayList<String>();
	private ArrayList<String> remove_order_type_list = new ArrayList<String>();
	private HashMap dataMap =new HashMap();
	protected String cust_rep_grp_code			= "" ;
	protected String cust_rep_grp_desc					= "" ;
	protected String order_category					= "" ;
	protected String cust_report_id				= "" ;
	protected String report_type_id				= "" ;
	public HashMap getDataMap()
	{
		return (HashMap)dataMap;
	}
	public void  setDataMap(String key,String[] value)
	{
			dataMap.put(key,value);
	}
	public String[] getDataMapValues(String key)
	{

		if(dataMap.containsKey(key))
		return (String[])dataMap.get(key);
		else
		return null;
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
	 

	public String insert(Hashtable inputHash)
	{
		Connection con = null;
		String added_by_id= (String) inputHash.get("ADDED_BY_ID");
		String added_at_ws_no= (String) inputHash.get("ADDED_AT_WS_NO");
		String added_facility_id= (String) inputHash.get("ADDED_FACILITY_ID");
		String retVal = "";
		int result = 0;
		CallableStatement cstmt_update_cons_order_dtl = null;
		CallableStatement cstmt_update_bl_table = null;//IN028193
		PreparedStatement cstmt_update_cons_order = null;
		PreparedStatement pstmt_get_order_detail = null;//IN028193
		ResultSet rs 		= null;//IN028193
		String error_code ="";
		
		HashMap consultMap = new HashMap();
         try
         {
         	con =  ConnectionManager.getConnection();
			con.setAutoCommit( false ) ;
			cstmt_update_cons_order_dtl			= con.prepareCall("{call OR_UPDATE_CONS_ORDER_DTL(?,?,?,?,?,?,?,?,?,?,?) }");
			cstmt_update_cons_order 			= con.prepareStatement("UPDATE or_order SET order_status = (SELECT order_status_code FROM or_order_status_code WHERE order_status_type ='85'),  modified_by_id = ?, modified_date =sysdate, modified_at_ws_no=? , modified_facility_id=?	where order_id = ?") ;//--[IN033474]
			cstmt_update_bl_table				= con.prepareCall("{call bl_interface_proc.upd_phyid_for_order_ass_pkg(?,?,?,?,?,?,?,?,?,?,?,?) }");//IN028193
			pstmt_get_order_detail				= con.prepareStatement("Select b.order_line_num order_line_num, decode(a.PATIENT_CLASS,'OP','O','IP','I','DC','D','XT','R','EM','E') episode_type, a.EPISODE_VISIT_NUM visit_id,a.CONTR_SYS_ID module_id, a.episode_id episode_id from or_order a,or_order_line b where a.order_id = b.order_id and a.order_id=?");//IN028193
			consultMap = (HashMap)getDataMap();
			
			if(consultMap.size()>0)
			{
				Set newmap=consultMap.keySet();
				Iterator iterator 	 = newmap.iterator();
				while( iterator. hasNext() )
				{
					String record[]= (String[])consultMap.get(iterator.next());
					String changestatus = (String) record[18];
					String consultdate	  = (String) record[12];
					String locncode	  = (String) record[10];
					String practId	  = (String) record[8];
					String specCode	  = (String) record[6];
					String orderId	  = (String) record[3];
					String billingPackageRef	  = (String) record[19];
					String encounter_id	  = (String) record[15];
					String patient_id	  = (String) record[16];
					//IN028193 - Start
					String episode_id	  = "";
					String episode_type	  = "";
					String order_line	  = "";
					String visit_id	  	  = "";
					String module_id	  = "";
					
					if(!"".equals(practId))
					{
						pstmt_get_order_detail.setString(1,orderId);
						rs	= pstmt_get_order_detail.executeQuery();
						while (rs != null && rs.next() ) 
						{
							episode_type = rs.getString("episode_type")==null?"":rs.getString("episode_type");
							order_line 	 = rs.getString("order_line_num")==null?"":rs.getString("order_line_num");
							visit_id     = rs.getString("visit_id")==null?"":rs.getString("visit_id");
							module_id    = rs.getString("module_id")==null?"":rs.getString("module_id");
							episode_id    = rs.getString("episode_id")==null?"":rs.getString("episode_id");
						}
					//IN043423 - Commented	
					//	if (rs != null)rs.close();
					//	if (pstmt_get_order_detail != null)pstmt_get_order_detail.close();

						if (rs != null)rs.close();//15950
					}
					//IN028193 - End
					if(changestatus.equals("C"))
					{
						++result;

						cstmt_update_cons_order_dtl.setString(1 , billingPackageRef==null?"":billingPackageRef);
						cstmt_update_cons_order_dtl.setString(2 , orderId==null?"":orderId);
						cstmt_update_cons_order_dtl.setString(3 , specCode==null?"":specCode);
						cstmt_update_cons_order_dtl.setString(4 , practId==null?"":practId);
						cstmt_update_cons_order_dtl.setString(5 , locncode==null?"":locncode);
						cstmt_update_cons_order_dtl.setString(6 , consultdate==null?"":consultdate);
						cstmt_update_cons_order_dtl.setString(7 , added_by_id );
						cstmt_update_cons_order_dtl.setString(8 , added_at_ws_no );
						cstmt_update_cons_order_dtl.setString(9 , added_facility_id);
						cstmt_update_cons_order_dtl.setString(10 , encounter_id==null?"":encounter_id);
						cstmt_update_cons_order_dtl.setString(11 , patient_id==null?"":patient_id);
						cstmt_update_cons_order_dtl.execute();
						//--[IN033474] - start
						cstmt_update_cons_order.setString(1, added_by_id);
						cstmt_update_cons_order.setString(2, added_at_ws_no);
						cstmt_update_cons_order.setString(3, added_facility_id);
						cstmt_update_cons_order.setString(4, orderId==null?"":orderId);
						cstmt_update_cons_order.execute();
						//--[IN033474] - End
						//IN028193 - start
						cstmt_update_bl_table.setString(1, added_facility_id);
						cstmt_update_bl_table.setString(2, patient_id);
						cstmt_update_bl_table.setString(3, episode_type);
						cstmt_update_bl_table.setString(4, episode_id);
						cstmt_update_bl_table.setString(5, visit_id);
						cstmt_update_bl_table.setString(6, module_id);
						cstmt_update_bl_table.setString(7, orderId);
						cstmt_update_bl_table.setString(8, order_line);
						cstmt_update_bl_table.setString(9, practId);
						cstmt_update_bl_table.registerOutParameter( 10,  Types.VARCHAR ) ;			
						cstmt_update_bl_table.registerOutParameter( 11,  Types.VARCHAR ) ;		
						cstmt_update_bl_table.registerOutParameter( 12,  Types.VARCHAR ) ;	
						
						cstmt_update_bl_table.execute();
						
						error_code = cstmt_update_bl_table.getString(10);					

						if(error_code == null)
							error_code = "";
						//IN028193 - End 
					}
				}
				if(result>0 )
				{
					retVal = "TRANS_SUCCESS";
					con.commit() ;
				}
				else
				{
					retVal = "NO_CHANGE_TO_SAVE";
					con.rollback();
				}
			}
			else
			 {
				retVal = "TRANS_FAILED";
				con.rollback();
			 }
		}
		catch(Exception ee)
		{
			try
			{
				ee.printStackTrace();
				retVal = "TRANS_FAILED";
                //IN043423 - Commented				
				//if (cstmt_update_cons_order_dtl != null) cstmt_update_cons_order_dtl.close();
				//if (cstmt_update_cons_order != null) cstmt_update_cons_order.close();//--[IN033474]
				//if (cstmt_update_bl_table != null) cstmt_update_bl_table.close();//IN028193
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
				//IN043423 - Start
				if (cstmt_update_cons_order_dtl != null) cstmt_update_cons_order_dtl.close();
				if (cstmt_update_cons_order != null) cstmt_update_cons_order.close();//--[IN033474]
				if (cstmt_update_bl_table != null) cstmt_update_bl_table.close();//IN028193
				if (rs != null)rs.close();
				if (pstmt_get_order_detail != null)pstmt_get_order_detail.close();
				//IN043423 - End
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return retVal;
}	
		
//public ArrayList loadConsultOrders(String facility_id,String encounter_id ) throws Exception//IN071558
public ArrayList loadConsultOrders(String facility_id,String encounter_id,String patient_id) throws Exception//IN071558
{
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet rs 		= null;
	ArrayList OrderCat = new ArrayList() ;
	String Consultrowid = "";
	
	try 
	{

		connection	= ConnectionManager.getConnection();
		//IN067437 Start.
		//String sqlQuery = "SELECT A.ROWID CONSULTROWID,A.BILLING_PACKAGE_REF||'/'||d.short_desc BILLING_PACKAGE_REF,A.BILLING_PACKAGE_REF PACKAGE_REF, to_char(EFF_FROM_DATE,'dd/mm/yyyy hh24:mi')  PACK_START_DATE,to_char(trunc(c.eff_to_date)+nvl(e.valid_days_for_pkg_orders,0),'dd/mm/yyyy')||' 23:59' PACK_END_DATE, A.ORDER_ID ORDER_ID, A.CATATLOG_CODE CATALOG_CODE, OR_GET_DESC.OR_ORDER_CATALOG(A.CATATLOG_CODE,?,2) CATALOG_DESC, A.SPECILITY_CODE SPECILITY_CODE,  AM_GET_DESC. AM_SPECIALITY(A.SPECILITY_CODE,?,2) SPECIALITY_DESC, A.PRACITIONER_ID PRACT_ID ,AM_GET_DESC.AM_PRACTITIONER(A.PRACITIONER_ID,?,1) PRACT_NAME, A.LOCATION_CODE LOCATION_CODE ,OP_GET_DESC.OP_CLINIC(a.parent_facility_id,A.LOCATION_CODE,?,2) CLINIC_DESC, TO_CHAR(A.CONSULT_DATE,'DD/MM/YYYY HH24:MI') CONSULT_DATE_STR, OR_GET_DESC.OR_ORDER_STATUS_CODE(B.ORDER_STATUS,?,2) ORDER_STATUS_DESC, A.CURRENT_STATUS CURRENT_STATUS,a.PARENT_ENC_ID encounter_id,b.patient_id patient_id FROM OR_CONSULT_DTLS A ,OR_ORDER B,bl_package_sub_hdr c, bl_package_lang_vw d, bl_parameters e WHERE PARENT_FACILITY_ID  =? AND  PARENT_ENC_ID=? and c.PACKAGE_SEQ_NO=a.BILLING_PACKAGE_REF and c.PACKAGE_CODE=d.PACKAGE_CODE  and d.LANGUAGE_ID=? and e.operating_facility_id=?    AND A.ORDER_ID=B.ORDER_ID ORDER BY BILLING_PACKAGE_REF, CONSULT_DATE"; //Commented V130628-Subha/KDAH-SCF-0497
		//String sqlQuery = "SELECT A.ROWID CONSULTROWID,A.BILLING_PACKAGE_REF||'/'||d.short_desc BILLING_PACKAGE_REF,A.BILLING_PACKAGE_REF PACKAGE_REF, to_char(EFF_FROM_DATE,'dd/mm/yyyy hh24:mi')  PACK_START_DATE,to_char(trunc(c.eff_to_date)+nvl(e.valid_days_for_pkg_orders,0),'dd/mm/yyyy')||' 23:59' PACK_END_DATE, A.ORDER_ID ORDER_ID, A.CATATLOG_CODE CATALOG_CODE, OR_GET_DESC.OR_ORDER_CATALOG(A.CATATLOG_CODE,?,2) CATALOG_DESC, A.SPECILITY_CODE SPECILITY_CODE,  AM_GET_DESC. AM_SPECIALITY(A.SPECILITY_CODE,?,2) SPECIALITY_DESC, A.PRACITIONER_ID PRACT_ID ,AM_GET_DESC.AM_PRACTITIONER(A.PRACITIONER_ID,?,1) PRACT_NAME, A.LOCATION_CODE LOCATION_CODE ,OP_GET_DESC.OP_CLINIC(a.parent_facility_id,A.LOCATION_CODE,?,2) CLINIC_DESC, TO_CHAR(A.CONSULT_DATE,'DD/MM/YYYY HH24:MI') CONSULT_DATE_STR, OR_GET_DESC.OR_ORDER_STATUS_CODE(B.ORDER_STATUS,?,2) ORDER_STATUS_DESC, A.CURRENT_STATUS CURRENT_STATUS,a.PARENT_ENC_ID encounter_id,b.patient_id patient_id FROM OR_CONSULT_DTLS A ,OR_ORDER B,bl_package_sub_hdr c, bl_package_lang_vw d, bl_parameters e WHERE PARENT_FACILITY_ID  =? AND  PARENT_ENC_ID=? and c.PACKAGE_SEQ_NO=a.BILLING_PACKAGE_REF and c.operating_facility_id=a.parent_facility_id and D.OPERATING_FACILITY_ID=a.parent_facility_id and c.PACKAGE_CODE=d.PACKAGE_CODE  and d.LANGUAGE_ID=? and e.operating_facility_id=?   AND A.ORDER_ID=B.ORDER_ID ORDER BY BILLING_PACKAGE_REF, CONSULT_DATE"; //Added V130628-Subha/KDAH-SCF-0497
		String sqlQuery = "SELECT A.ROWID CONSULTROWID,A.BILLING_PACKAGE_REF||'/'||d.short_desc BILLING_PACKAGE_REF,A.BILLING_PACKAGE_REF PACKAGE_REF, to_char(EFF_FROM_DATE,'dd/mm/yyyy hh24:mi')  PACK_START_DATE,to_char(trunc(c.eff_to_date)+nvl(e.valid_days_for_pkg_orders,0),'dd/mm/yyyy')||' 23:59' PACK_END_DATE, A.ORDER_ID ORDER_ID, A.CATATLOG_CODE CATALOG_CODE, OR_GET_DESC.OR_ORDER_CATALOG(A.CATATLOG_CODE,?,2) CATALOG_DESC, A.SPECILITY_CODE SPECILITY_CODE,  AM_GET_DESC. AM_SPECIALITY(A.SPECILITY_CODE,?,2) SPECIALITY_DESC, A.PRACITIONER_ID PRACT_ID ,AM_GET_DESC.AM_PRACTITIONER(A.PRACITIONER_ID,?,1) PRACT_NAME, A.LOCATION_CODE LOCATION_CODE ,OP_GET_DESC.OP_CLINIC(a.parent_facility_id,A.LOCATION_CODE,?,2) CLINIC_DESC, TO_CHAR(A.CONSULT_DATE,'DD/MM/YYYY HH24:MI') CONSULT_DATE_STR, OR_GET_DESC.OR_ORDER_STATUS_CODE(B.ORDER_STATUS,?,2) ORDER_STATUS_DESC, A.CURRENT_STATUS CURRENT_STATUS,a.PARENT_ENC_ID encounter_id,b.patient_id patient_id FROM OR_CONSULT_DTLS A ,OR_ORDER B,bl_package_sub_hdr c, bl_package_lang_vw d, bl_parameters e WHERE PARENT_FACILITY_ID  =? AND  PARENT_ENC_ID=? and c.PACKAGE_SEQ_NO=a.BILLING_PACKAGE_REF and c.operating_facility_id=a.parent_facility_id and D.OPERATING_FACILITY_ID=a.parent_facility_id and c.PACKAGE_CODE=d.PACKAGE_CODE  and d.LANGUAGE_ID=? and e.operating_facility_id=? AND A.ORDER_ID=B.ORDER_ID";
		if(!"".equals(patient_id)) {//IN071816
			sqlQuery += " and c.patient_id=?";
		}
		sqlQuery += " ORDER BY BILLING_PACKAGE_REF, CONSULT_DATE"; //Added for KDAH-SCF-602//IN071558//IN071816
		//IN067437 End.
		pstmt		= connection.prepareStatement(sqlQuery) ;
		pstmt.setString(1, language_id) ;
		pstmt.setString(2, language_id) ;
		pstmt.setString(3, language_id) ;
		pstmt.setString(4, language_id) ;
		pstmt.setString(5, language_id) ;
		pstmt.setString(6, facility_id) ;
		pstmt.setString(7, encounter_id) ;
		pstmt.setString(8, language_id) ;
		pstmt.setString(9, facility_id) ;
		pstmt.setString(10, patient_id) ;//IN071558
		rs	= pstmt.executeQuery();
		String[] record=null;
		while (rs != null && rs.next() ) 
		{
			int row = 0;
			record = new String[20];
			record[row++] = rs.getString("BILLING_PACKAGE_REF")==null?"":rs.getString("BILLING_PACKAGE_REF");
			record[row++] = rs.getString("PACK_START_DATE")==null?"":rs.getString("PACK_START_DATE");
			record[row++] = rs.getString("PACK_END_DATE")==null?"":rs.getString("PACK_END_DATE");
			record[row++] = rs.getString("ORDER_ID")==null?"":rs.getString("ORDER_ID");
			record[row++] = rs.getString("CATALOG_CODE")==null?"":rs.getString("CATALOG_CODE");
			record[row++] = rs.getString("CATALOG_DESC")==null?"":rs.getString("CATALOG_DESC");
			record[row++] = rs.getString("SPECILITY_CODE")==null?"":rs.getString("SPECILITY_CODE");
			record[row++] = rs.getString("SPECIALITY_DESC")==null?"":rs.getString("SPECIALITY_DESC");
			record[row++] = rs.getString("PRACT_ID")==null?"":rs.getString("PRACT_ID");
			record[row++] = rs.getString("PRACT_NAME")==null?"":rs.getString("PRACT_NAME");
			record[row++] = rs.getString("LOCATION_CODE")==null?"":rs.getString("LOCATION_CODE");
			record[row++] = rs.getString("CLINIC_DESC")==null?"":rs.getString("CLINIC_DESC");
			record[row++] = rs.getString("CONSULT_DATE_STR")==null?"":rs.getString("CONSULT_DATE_STR");
			record[row++] = rs.getString("ORDER_STATUS_DESC")==null?"":rs.getString("ORDER_STATUS_DESC");
			record[row++] = rs.getString("CURRENT_STATUS")==null?"":rs.getString("CURRENT_STATUS");
			record[row++] = rs.getString("encounter_id")==null?"":rs.getString("encounter_id");
			record[row++] = rs.getString("patient_id")==null?"":rs.getString("patient_id");
			Consultrowid =	  rs.getString("CONSULTROWID")==null?"":rs.getString("CONSULTROWID");
			record[row++] = Consultrowid;
			record[row++] = "";
			record[row++] = rs.getString("PACKAGE_REF")==null?"":rs.getString("PACKAGE_REF");
			OrderCat.add(record) ;	
			
				dataMap.put(Consultrowid,record);
			
		}
		if (rs != null)rs.close();
		if (pstmt != null)pstmt.close();

	  } 
	  catch ( Exception e )	
	  {
		e.printStackTrace() ;
	  }
	  finally 
	  {
		try
		{
			if(connection != null) connection.close();
		}
		catch ( Exception e )	{
			e.printStackTrace() ;
		}
	}
	
	return OrderCat;
	}
}


