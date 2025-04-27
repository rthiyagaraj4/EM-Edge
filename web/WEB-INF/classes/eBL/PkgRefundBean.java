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
import eBL.Common.*;
import webbeans.eCommon.*;
import eCommon.Common.CommonAdapter;


public class PkgRefundBean extends BlAdapter implements Serializable
{
	protected ArrayList pkg_srv_dtls		= new ArrayList();
	protected HashMap excl_srv_dtls		= new HashMap();

	public PkgRefundBean()
	{	
		//System.out.println("PkgRefundBean Initialized");
	}

	public HashMap validate() throws Exception
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." );
		return map;
	}
	public void setPkgSrvDtls(ArrayList pkg_srv_dtls){
		this.pkg_srv_dtls=pkg_srv_dtls;	
	}
	public ArrayList getPkgSrvDtls(){
		return this.pkg_srv_dtls;
	}
	public void setExclSrvDtls(HashMap excl_srv_dtls){
		this.excl_srv_dtls=excl_srv_dtls;	
	}
	public HashMap getExclSrvDtls(){
		return this.excl_srv_dtls;
	}
	public void clearBean()
	{
		pkg_srv_dtls=new ArrayList();
		excl_srv_dtls=new HashMap();
		//System.out.println("PkgRefundBean Cleared");		
	}
	
	public String getPatientDtls(String patient_id,String locale) throws Exception{
		String pat_dtls="";
		Connection connection 		= null;		
		CallableStatement call 	= null;		
		try{
			connection = getConnection();	
			call = connection.prepareCall("{ ? = call  get_patient_line(?,?)}");	
			call.registerOutParameter(1,java.sql.Types.VARCHAR);
			call.setString(2,patient_id);
			call.setString(3,locale);
			call.execute();							
			pat_dtls = call.getString(1);				
			call.close();				
		}catch(Exception e)
		{
			System.out.println("Exception no. of patline :"+e);
			e.printStackTrace() ;
		}finally{
		try{
	
			if (call != null) call.close();
			if (connection != null) ConnectionManager.returnConnection(connection);
		}catch(Exception e){
			System.out.println("Exception no. of patline :"+e);
			e.printStackTrace() ;
			throw e;
		}
	}
		return pat_dtls;
	}	
	
	public String[] getPkgDtls(String facility_id,String patient_id,String locale,String pkg_code) throws Exception
	{
	//System.out.println("in bean,getPkgDtls()");
	//System.out.println("facility_id="+facility_id);
	//System.out.println("patient_id="+patient_id);
	//System.out.println("locale="+locale);
	//System.out.println("pkg_code="+pkg_code);
		String[] pkg_dtls=new String[13];
		Connection con = ConnectionManager.getConnection();	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			pstmt=con.prepareStatement("SELECT b.short_desc pkg_desc, A.package_seq_no package_seq_no,TO_CHAR (A.eff_from_date, 'dd/mm/yyyy') eff_from_date,TO_CHAR (A.eff_to_date, 'dd/mm/yyyy') eff_to_date,A.blng_class_code blng_class_code, c.short_desc blng_class_desc,A.cust_group_code cust_group_code, d.short_desc cust_group_desc,A.cust_code cust_code, E.short_name cust_desc,A.package_amt package_amt, A.deposit_amt deposit_amt,A.utilized_amt utilized_amt FROM bl_package_sub_hdr A,       bl_package_lang_vw b,bl_blng_class_lang_vw c,ar_cust_group_lang_vw d,ar_customer_lang_vw E WHERE A.status = 'C'   AND A.operating_facility_id = ? AND A.patient_id = ? AND A.operating_facility_id = b.operating_facility_id AND A.package_code = b.package_code AND b.language_id = ? and b.language_id=c.language_id AND A.blng_class_code = c.blng_class_code(+) AND A.cust_group_code = d.cust_group_code(+)   AND A.cust_code = E.cust_code(+)   AND A.package_code = ?");			
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,locale);
			pstmt.setString(4,pkg_code);
			rs	= pstmt.executeQuery();
			while(rs!=null && rs.next()){
				//System.out.println("@@@@@@@@");
				pkg_dtls[0]=rs.getString("pkg_desc")==null?"":(String)rs.getString("pkg_desc");
				pkg_dtls[1]=rs.getString("PACKAGE_SEQ_NO")==null?"":(String)rs.getString("PACKAGE_SEQ_NO");
				pkg_dtls[2]=rs.getString("EFF_FROM_DATE")==null?"":(String)rs.getString("EFF_FROM_DATE");
				pkg_dtls[3]=rs.getString("EFF_TO_DATE")==null?"":(String)rs.getString("EFF_TO_DATE");
				pkg_dtls[4]=rs.getString("BLNG_CLASS_CODE")==null?"":(String)rs.getString("BLNG_CLASS_CODE");
				pkg_dtls[5]=rs.getString("blng_class_desc")==null?"":(String)rs.getString("blng_class_desc");
				pkg_dtls[6]=rs.getString("CUST_GROUP_CODE")==null?"":(String)rs.getString("CUST_GROUP_CODE");
				pkg_dtls[7]=rs.getString("cust_group_desc")==null?"":(String)rs.getString("cust_group_desc");
				pkg_dtls[8]=rs.getString("CUST_CODE")==null?"":(String)rs.getString("CUST_CODE");
				pkg_dtls[9]=rs.getString("cust_desc")==null?"":(String)rs.getString("cust_desc");
				pkg_dtls[10]=rs.getString("PACKAGE_AMT")==null?"0.00":(String)rs.getString("PACKAGE_AMT");
				pkg_dtls[11]=rs.getString("DEPOSIT_AMT")==null?"0.00":(String)rs.getString("DEPOSIT_AMT");
				pkg_dtls[12]=rs.getString("UTILIZED_AMT")==null?"0.00":(String)rs.getString("UTILIZED_AMT");

			}			
	
		}catch(Exception e){
			System.out.println("Exception in getPkgdtls() in PkgRefundBean.java="+e);
			e.printStackTrace();
		}finally{
			try{		
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if (con != null) ConnectionManager.returnConnection(con);
			}catch(Exception e){
				System.out.println("Exception no. of patline :"+e);
				e.printStackTrace() ;
				throw e;
			}
		}
		return pkg_dtls;
	}
	public ArrayList getSrvDtls(String facility_id,String patient_id,String locale,String pkg_code,String pkg_seq_no) throws Exception
	{
		//System.out.println("in getSrvDtls()=facility_id="+facility_id+",patient_id="+patient_id+",locale="+locale+",pkg_code="+pkg_code+",pkg_seq_no="+pkg_seq_no);
		ArrayList srv_list=new ArrayList();
		String[] record;
		Connection con = ConnectionManager.getConnection();	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{		
		//	pstmt=con.prepareStatement("SELECT A.pkg_serv_ind pkg_serv_ind, A.pkg_serv_code pkg_serv_code,b.service_desc pkg_serv_desc,A.order_catalog_code order_catalog_code, A.rate_ind rate_ind, A.factor_rate factor_rate,A.refund_yn refund_yn, A.refund_rate refund_rate,A.utilized_serv_qty utilized_serv_qty,A.utilized_serv_amt utilized_serv_amt, blpkgrefund.get_refund_amount(?,?,?,A.pkg_serv_code,A.refund_rate) refund_amt,blpkgrefund.refund_processed_yn (?,?,?,A.pkg_serv_code) refunded FROM bl_package_sub_dtls A,  (SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc,language_id FROM bl_blng_serv_lang_vw UNION ALL        SELECT 'C' serv_ind, serv_classification_code code,short_desc service_desc, language_id  FROM bl_serv_classification_lang_vw UNION ALL  SELECT 'G' serv_ind, serv_grp_code code, short_desc service_desc,language_id  FROM bl_blng_serv_grp_lang_vw) b WHERE A.operating_facility_id = ?   AND A.patient_id = ? AND A.package_seq_no = ? AND A.package_code =?  AND A.pkg_serv_code = b.code AND A.pkg_serv_ind = b.serv_ind  AND b.language_id = ?");		
			//pstmt=con.prepareStatement("SELECT A.pkg_serv_ind pkg_serv_ind, A.pkg_serv_code pkg_serv_code,b.service_desc pkg_serv_desc,A.order_catalog_code order_catalog_code, A.refund_yn refund_yn, A.refund_rate refund_rate,A.utilized_serv_qty utilized_serv_qty,A.utilized_serv_amt utilized_serv_amt, blpkgrefund.get_refund_amount(?,?,?,A.pkg_serv_code,A.refund_rate) refund_amt,nvl(refund_processed_yn,'N') refunded,refunded_amount FROM bl_package_sub_dtls A,  (SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc,language_id FROM bl_blng_serv_lang_vw UNION ALL        SELECT 'C' serv_ind, serv_classification_code code,short_desc service_desc, language_id  FROM bl_serv_classification_lang_vw UNION ALL  SELECT 'G' serv_ind, serv_grp_code code, short_desc service_desc,language_id  FROM bl_blng_serv_grp_lang_vw) b WHERE A.operating_facility_id = ?   AND A.patient_id = ? AND A.package_seq_no = ? AND A.package_code =?  AND A.pkg_serv_code = b.code AND A.pkg_serv_ind = b.serv_ind  AND b.language_id = ?");		
			pstmt=con.prepareStatement("SELECT A.pkg_serv_ind pkg_serv_ind, A.pkg_serv_code pkg_serv_code,b.service_desc pkg_serv_desc,A.order_catalog_code order_catalog_code, A.refund_yn refund_yn, A.refund_rate refund_rate,A.utilized_serv_qty utilized_serv_qty,A.utilized_serv_amt utilized_serv_amt, blpkgrefund.get_refund_amount(?,?,?,A.pkg_serv_code,decode(A.refund_yn,'Y',A.refund_rate, 100)) available_amt, nvl(refund_processed_yn,'N') refunded,(refunded_amount*(-1)) refunded_amount FROM bl_package_sub_dtls A,  (SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc,language_id FROM bl_blng_serv_lang_vw UNION ALL        SELECT 'C' serv_ind, serv_classification_code code,short_desc service_desc, language_id  FROM bl_serv_classification_lang_vw UNION ALL  SELECT 'G' serv_ind, serv_grp_code code, short_desc service_desc,language_id  FROM bl_blng_serv_grp_lang_vw) b WHERE A.operating_facility_id = ?   AND A.patient_id = ? AND A.package_seq_no = ? AND A.package_code =?  AND A.pkg_serv_code = b.code AND A.pkg_serv_ind = b.serv_ind  AND b.language_id = ?");		
			
			pstmt.setString(1,facility_id);
			pstmt.setString(2,pkg_seq_no);
			pstmt.setString(3,pkg_code);						
			pstmt.setString(4,facility_id);			
			pstmt.setString(5,patient_id);
			pstmt.setString(6,pkg_seq_no);	
			pstmt.setString(7,pkg_code);
			pstmt.setString(8,locale);
	//System.out.println("facility_id="+facility_id);
	//System.out.println("patient_id="+patient_id);
	//System.out.println("pkg_seq_no="+pkg_seq_no);
	//System.out.println("pkg_code="+pkg_code);
	//System.out.println("locale="+locale);
			rs	= pstmt.executeQuery();
			while(rs!=null && rs.next()){
				
				record=new String[11];
				record[0]=rs.getString("PKG_SERV_IND")==null?"":(String)rs.getString("PKG_SERV_IND");
				record[1]=rs.getString("PKG_SERV_CODE")==null?"":(String)rs.getString("PKG_SERV_CODE");
				record[2]=rs.getString("PKG_SERV_desc")==null?"":(String)rs.getString("PKG_SERV_desc");	
				record[3]=rs.getString("ORDER_CATALOG_CODE")==null?"":(String)rs.getString("ORDER_CATALOG_CODE");
				record[4]=rs.getString("REFUND_YN")==null?"N":(String)rs.getString("REFUND_YN");
				record[5]=rs.getString("REFUND_RATE")==null?"":(String)rs.getString("REFUND_RATE");
				record[6]=rs.getString("UTILIZED_SERV_QTY")==null?"":(String)rs.getString("UTILIZED_SERV_QTY");
				record[7]=rs.getString("UTILIZED_SERV_AMT")==null?"":(String)rs.getString("UTILIZED_SERV_AMT");
				record[8]=rs.getString("available_amt")==null?"":(String)rs.getString("available_amt");
				record[9]=rs.getString("refunded")==null?"N":(String)rs.getString("refunded");
				record[10]=rs.getString("refunded_amount")==null?"0":(String)rs.getString("refunded_amount");
				srv_list.add(record);
			}			
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
					
		}catch(Exception e){
			System.out.println("Exception in getSrvDtls() in PkgRefundBean.java="+e);
			e.printStackTrace();
		}
		//System.out.println("srv_list="+srv_list.toString());
		return srv_list;
	}
		public ArrayList getExclSrvDtls(String facility_id,String patient_id,String locale,String pkg_code,String pkg_seq_no,String pkg_serv_code) throws Exception
	{
		//System.out.println("in getExclSrvDtls()=facility_id="+facility_id+",patient_id="+patient_id+",locale="+locale+",pkg_code="+pkg_code+",pkg_seq_no="+pkg_seq_no);
		ArrayList excl_srv_list=new ArrayList();
		String[] record;
		Connection con = ConnectionManager.getConnection();	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{		
			//pstmt=con.prepareStatement("SELECT A.excl_serv_ind excl_serv_ind, A.excl_serv_code excl_serv_code,b.service_desc excl_serv_desc, A.exclude_yn exclude_yn,A.refund_yn refund_yn, A.refund_rate refund_rate,A.utilized_serv_qty utilized_serv_qty,A.utilized_serv_amt utilized_serv_amt,blpkgrefund.get_refund_amount (?,?,?,A.pkg_serv_code,A.refund_rate) refund_amt,blpkgrefund.refund_processed_yn (?,?,?,A.pkg_serv_code) refunded,'N'  refund_serv  FROM bl_package_sub_excl A, (SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc,language_id FROM bl_blng_serv_lang_vw UNION ALL SELECT 'C' serv_ind, serv_classification_code code,short_desc service_desc, language_id FROM bl_serv_classification_lang_vw  UNION ALL   SELECT 'G' serv_ind, serv_grp_code code, short_desc service_desc, language_id FROM bl_blng_serv_grp_lang_vw) b WHERE A.operating_facility_id = ?   AND A.patient_id=?   AND A.package_seq_no = ?   AND A.package_code = ?   AND pkg_serv_code = ?   AND A.excl_serv_code = b.code AND b.language_id = ?");		
		//	pstmt=con.prepareStatement("SELECT A.excl_serv_ind excl_serv_ind, A.excl_serv_code excl_serv_code,b.service_desc excl_serv_desc, A.exclude_yn exclude_yn,A.refund_yn refund_yn, A.refund_rate refund_rate,A.utilized_serv_qty utilized_serv_qty,A.utilized_serv_amt utilized_serv_amt,blpkgrefund.get_refund_amount (?,?,?,A.pkg_serv_code,A.refund_rate) refund_amt,nvl(refund_processed_yn,'N') refunded,refunded_amount, 'N'  refund_serv  FROM bl_package_sub_excl A, (SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc,language_id FROM bl_blng_serv_lang_vw UNION ALL SELECT 'C' serv_ind, serv_classification_code code,short_desc service_desc, language_id FROM bl_serv_classification_lang_vw  UNION ALL   SELECT 'G' serv_ind, serv_grp_code code, short_desc service_desc, language_id FROM bl_blng_serv_grp_lang_vw) b WHERE A.operating_facility_id = ?   AND A.patient_id=?   AND A.package_seq_no = ?   AND A.package_code = ?   AND pkg_serv_code = ?   AND A.excl_serv_code = b.code AND b.language_id = ?");		
		//	pstmt=con.prepareStatement("SELECT A.excl_serv_ind excl_serv_ind, A.excl_serv_code excl_serv_code,b.service_desc excl_serv_desc, A.exclude_yn exclude_yn,A.refund_yn refund_yn, A.refund_rate refund_rate,A.utilized_serv_qty utilized_serv_qty,A.utilized_serv_amt utilized_serv_amt,blpkgrefund.get_refund_amount (?,?,?,A.pkg_serv_code,decode(A.refund_yn,'Y',A.refund_rate, 100)) available_amt,nvl(refund_processed_yn,'N') refunded,(refunded_amount*(-1)) refunded_amount, 'N'  refund_serv  FROM bl_package_sub_excl A, (SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc,language_id FROM bl_blng_serv_lang_vw UNION ALL SELECT 'C' serv_ind, serv_classification_code code,short_desc service_desc, language_id FROM bl_serv_classification_lang_vw  UNION ALL   SELECT 'G' serv_ind, serv_grp_code code, short_desc service_desc, language_id FROM bl_blng_serv_grp_lang_vw) b WHERE A.operating_facility_id = ?   AND A.patient_id=?   AND A.package_seq_no = ?   AND A.package_code = ?   AND pkg_serv_code = ?   AND A.excl_serv_code = b.code AND b.language_id = ?");		
			pstmt=con.prepareStatement("SELECT A.excl_serv_ind excl_serv_ind, A.excl_serv_code excl_serv_code,b.service_desc excl_serv_desc, A.exclude_yn exclude_yn,A.refund_yn refund_yn, A.refund_rate refund_rate,A.utilized_serv_qty utilized_serv_qty,A.utilized_serv_amt utilized_serv_amt,blpkgrefund.get_refund_amount (?,?,?,A.excl_serv_code,decode(A.refund_yn,'Y',A.refund_rate, 100)) available_amt,nvl(refund_processed_yn,'N') refunded,(refunded_amount*(-1)) refunded_amount, 'N'  refund_serv  FROM bl_package_sub_excl A, (SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc,language_id FROM bl_blng_serv_lang_vw UNION ALL SELECT 'C' serv_ind, serv_classification_code code,short_desc service_desc, language_id FROM bl_serv_classification_lang_vw  UNION ALL   SELECT 'G' serv_ind, serv_grp_code code, short_desc service_desc, language_id FROM bl_blng_serv_grp_lang_vw) b WHERE A.operating_facility_id = ?   AND A.patient_id=?   AND A.package_seq_no = ?   AND A.package_code = ?   AND pkg_serv_code = ?   AND A.excl_serv_code = b.code AND b.language_id = ?");		
			
			pstmt.setString(1,facility_id);
			pstmt.setString(2,pkg_seq_no);
			pstmt.setString(3,pkg_code);		
			pstmt.setString(4,facility_id);			
			pstmt.setString(5,patient_id);
			pstmt.setString(6,pkg_seq_no);	
			pstmt.setString(7,pkg_code);
			pstmt.setString(8,pkg_serv_code);
			pstmt.setString(9,locale);
	//System.out.println("facility_id="+facility_id);
	//System.out.println("patient_id="+patient_id);
	//System.out.println("pkg_seq_no="+pkg_seq_no);
	//System.out.println("pkg_code="+pkg_code);
	//System.out.println("locale="+locale);
	//System.out.println("pkg_serv_code="+pkg_serv_code);
			rs	= pstmt.executeQuery();
			while(rs!=null && rs.next()){				
				record=new String[13];
				record[0]=rs.getString("excl_serv_ind")==null?"":(String)rs.getString("excl_serv_ind");
				record[1]=rs.getString("excl_serv_code")==null?"":(String)rs.getString("excl_serv_code");
				record[2]=rs.getString("excl_serv_desc")==null?"":(String)rs.getString("excl_serv_desc");
				record[3]=rs.getString("exclude_yn")==null?"":(String)rs.getString("exclude_yn");	
				record[4]=rs.getString("refund_yn")==null?"N":(String)rs.getString("refund_yn");
				record[5]=rs.getString("refund_rate")==null?"":(String)rs.getString("refund_rate");
				record[6]=rs.getString("utilized_serv_qty")==null?"":(String)rs.getString("utilized_serv_qty");
				record[7]=rs.getString("utilized_serv_amt")==null?"":(String)rs.getString("utilized_serv_amt");
				record[8]=rs.getString("available_amt")==null?"":(String)rs.getString("available_amt");
				record[9]="0";
				record[10]=rs.getString("refunded")==null?"N":(String)rs.getString("refunded");
				record[11]=rs.getString("refunded_amount")==null?"0":(String)rs.getString("refunded_amount");
				record[12]=rs.getString("refund_serv")==null?"N":(String)rs.getString("refund_serv");			
				excl_srv_list.add(record);
			}			
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
					
		}catch(Exception e){
			System.out.println("Exception in getSrvDtls() in PkgRefundBean.java="+e);
			e.printStackTrace();
		}
		//System.out.println("excl_srv_list="+excl_srv_list.toString());
		return excl_srv_list;
	}
	public boolean getUserPkgRefundAppl(String userId,String operating_facility_id) throws Exception
	{
		Connection connection 		= getConnection();	
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		boolean status = false;
		try
		{
			String sql = "select blpackage.can_user_refund_pkg(?,?) status from dual";
			pstmt=connection.prepareStatement(sql);	
			pstmt.setString(1,operating_facility_id);
			pstmt.setString(2,userId);

			rs = pstmt.executeQuery();
			if (rs.next())
				status = (boolean)(rs.getString("status").equals("Y")? true : false);
		}
		catch(Exception e)
		{
			System.out.println("Exception from packageCreationRight :"+e);
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
		}
			
		return status ;


	}
	public boolean getUserAdhocRefundAppl(String userId,String operating_facility_id) throws Exception
	{
		Connection connection 		= getConnection();	
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		boolean status = false;
		try
		{
			String sql = "select blpackage.can_user_adhov_refund_pkg(?,?) status from dual";
			pstmt=connection.prepareStatement(sql);	
			pstmt.setString(1,operating_facility_id);
			pstmt.setString(2,userId);

			rs = pstmt.executeQuery();
			if (rs.next())
				status = (boolean)(rs.getString("status").equals("Y")? true : false);
		}
		catch(Exception e)
		{
			System.out.println("Exception from packageCreationRight :"+e);
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
		}
			
		return status ;


	}
}
