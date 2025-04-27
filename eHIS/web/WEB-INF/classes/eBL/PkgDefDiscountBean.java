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

public class PkgDefDiscountBean extends BlAdapter implements Serializable
{	
	HashMap cust_discount_dtls=new HashMap();// for customer discount dtls
	HashMap blng_grp_discount_dtls=new HashMap();// for Billing grp discount dtls
	HashMap db_cust_discount_dtls=new HashMap();	
	HashMap db_blng_grp_discount_dtls=new HashMap();	

	protected String modify_discount			= "N";
	
	public PkgDefDiscountBean()
	{	
		//System.out.println("PkgDefDiscountBean Initialized");
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
		cust_discount_dtls=new HashMap();// for customer discount dtls
		blng_grp_discount_dtls=new HashMap();// for Billing grp discount dtls
		db_cust_discount_dtls=new HashMap();	
		db_blng_grp_discount_dtls=new HashMap();		
		modify_discount			= "N";	
		
	}
	
	public HashMap getCustDiscountDtls(){
		return this.cust_discount_dtls;
	}
	
	public void setCustDiscountDtls(HashMap cust_discount_dtls){
		 this.cust_discount_dtls=cust_discount_dtls;
	}
	public HashMap getBlngGrpDiscountDtls(){
		return this.blng_grp_discount_dtls;
	}
	
	public void setBlngGrpDiscountDtls(HashMap blng_grp_discount_dtls){
		 this.blng_grp_discount_dtls=blng_grp_discount_dtls;
	}
	public HashMap getDBCustDiscountDtls(){
		return this.db_cust_discount_dtls;
	}
	
	public void setDBCustDiscountDtls(HashMap db_cust_discount_dtls){
		 this.db_cust_discount_dtls=db_cust_discount_dtls;
	}
	public HashMap getDBBlngGrpDiscountDtls(){
		return this.db_blng_grp_discount_dtls;
	}
	
	public void  setDBBlngGrpDiscountDtls(HashMap db_blng_grp_discount_dtls){
		 this.db_blng_grp_discount_dtls=db_blng_grp_discount_dtls;
	}

	public void setModifyDiscount(String modify_discount){
		this.modify_discount=modify_discount;
	}
	
	public String getModifyDiscount(){
		return this.modify_discount;
	}
	
	public void setDBValues(String packageCode,String language_id, String operating_facility_id) throws Exception {
		Connection connection 		= null;		
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;		
		String sqlStr="";	
	
		String[] record;		
		HashMap cust_discount_dtls=new HashMap();
		HashMap db_cust_discount_dtls=new HashMap();		
		HashMap blng_grp_discount_dtls=new HashMap();
		HashMap db_blng_grp_discount_dtls=new HashMap();

		try{			
			connection = getConnection();
			//sqlStr  ="SELECT a.cust_group_code cust_grp_code, decode(a.cust_group_code,'**','All Groups',c.short_desc) cust_grp_desc, a.cust_code cust_code, decode(a.cust_code,'**','All Customers', b.short_name) cust_desc,a.blng_class_code blng_class_code, decode(a.blng_class_code,'**','All Billing Classes', d.short_desc) blng_class_desc, a.age_group, a.speciality_code, to_char(a.eff_from_date,'dd/mm/yyyy') eff_from_date, to_char(a.eff_to_date,'dd/mm/yyyy') eff_to_date, a.discount_type discount_type, a.discount discount, DECODE (a.age_group, '**', 'All Age Group', e.short_desc) age_group_desc, DECODE (a.speciality_code,'**', 'All Specialty', f.short_desc) speciality_desc, g.package_code package_code, g.short_desc package_Short_desc, h.policy_type_Code policy_type_Code, h.short_desc policy_short_desc from bl_package_cust_discount a, ar_customer_lang_vw b, ar_cust_group_lang_vw c, bl_blng_class_lang_vw d, bl_age_group e, am_speciality f , bl_package g, bl_ins_policy_types h where a.package_code = ? and a.operating_facility_id= ? AND a.cust_group_code = c.cust_group_code(+) AND a.cust_code = b.cust_code(+) AND a.blng_class_code = d.blng_class_code(+) AND b.language_id(+) = ? AND c.language_id(+) = ?  and  d.language_id(+) = ? AND a.age_group = e.age_group_code(+) AND a.speciality_code = f.speciality_code(+)  AND a.package_code = g.package_code AND h.operating_facility_id(+) = a.operating_facility_id  AND  h.policy_type_Code(+) = a.policy_type_Code";       
			//Added against GHL-CRF-0502 & //MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 16/6/2020				

			sqlStr  ="SELECT a.cust_group_code cust_grp_code, decode(a.cust_group_code,'**','All Groups',c.short_desc) cust_grp_desc, a.cust_code cust_code,decode(a.cust_code,'**','All Customers', b.short_name) cust_desc,a.blng_class_code blng_class_code, decode(a.blng_class_code,'**','All Billing Classes', d.short_desc) blng_class_desc, a.age_group, a.speciality_code, to_char(a.eff_from_date,'dd/mm/yyyy') eff_from_date, to_char(a.eff_to_date,'dd/mm/yyyy') eff_to_date, a.discount_type discount_type, a.discount discount, DECODE (a.age_group, '**', 'All Age Group', e.short_desc) age_group_desc, DECODE (a.speciality_code,'**', 'All Specialty', f.short_desc) speciality_desc, g.package_code package_code, g.short_desc package_Short_desc, a.policy_type_Code policy_type_Code, DECODE (a.policy_type_Code,'**', 'All Policies', h.short_desc) policy_short_desc from bl_package_cust_discount a, ar_customer_lang_vw b, ar_cust_group_lang_vw c, bl_blng_class_lang_vw d, bl_age_group e, am_speciality f , bl_package g, bl_ins_policy_types h where a.package_code = ? and a.operating_facility_id= ? AND a.cust_group_code = c.cust_group_code(+) AND a.cust_code = b.cust_code(+) AND a.blng_class_code = d.blng_class_code(+) AND b.language_id(+) = ? AND c.language_id(+) = ?  and  d.language_id(+) = ? AND a.age_group = e.age_group_code(+) AND a.speciality_code = f.speciality_code(+)  AND a.package_code = g.package_code AND h.operating_facility_id(+) = a.operating_facility_id  AND  h.policy_type_Code(+) = a.policy_type_Code"; 
				
			pstmt=connection.prepareStatement(sqlStr);	
			
			pstmt.setString(1,packageCode);			
			pstmt.setString(2,operating_facility_id);
			pstmt.setString(3,language_id);
			pstmt.setString(4,language_id);		
			pstmt.setString(5,language_id);		
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				record=new String[18];  //MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 16/6/2020 
				record[0]=checkForNull(rs.getString("cust_grp_code"));
				record[1]=checkForNull(rs.getString("cust_grp_desc"));
				record[2]=checkForNull(rs.getString("cust_code"));
				record[3]=checkForNull(rs.getString("cust_desc"));
				record[4]=checkForNull(rs.getString("blng_class_code"));
				record[5]=checkForNull(rs.getString("blng_class_desc"));
				record[6]=checkForNull(rs.getString("eff_from_date"));				
				record[7]=checkForNull(rs.getString("eff_to_date"));				
				record[8]=checkForNull(rs.getString("discount_type"));				
				record[9]=checkForNull(rs.getString("discount"));
				//Added against GHL-CRF-0502 Starts
				record[10]=checkForNull(rs.getString("age_group"));
				record[11]=checkForNull(rs.getString("age_group_desc"));
				record[12]=checkForNull(rs.getString("speciality_code"));				
				record[13]=checkForNull(rs.getString("speciality_desc"));
				//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 16/6/2020 
				record[14]=checkForNull(rs.getString("policy_type_code"));
				record[15]=checkForNull(rs.getString("policy_short_desc"));
				//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 16/6/2020
				
				cust_discount_dtls.put(record[0]+"~~"+record[2]+"~~"+record[4]+"~~"+record[6]+"~~"+record[10]+"~~"+record[12],record);				
				db_cust_discount_dtls.put(record[0]+"~~"+record[2]+"~~"+record[4]+"~~"+record[6]+"~~"+record[10]+"~~"+record[12],record);
				//Added against GHL-CRF-0502 Ends
			}
		
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			setCustDiscountDtls(cust_discount_dtls);
			setDBCustDiscountDtls(db_cust_discount_dtls);

			/***************Billing Group Discount Details***********start********************/
			sqlStr="SELECT a.blng_grp_id blng_grp_code, decode(a.blng_grp_id,'**','All Billing Groups',c.short_desc) blng_grp_desc, a.blng_class_code blng_class_code, decode(a.blng_class_code,'**','All Billing Classes', b.short_desc) blng_class_desc, a.age_group, a.speciality_code, to_char(a.eff_from_date,'dd/mm/yyyy') eff_from_date, to_char(a.eff_to_date,'dd/mm/yyyy') eff_to_date, a.discount_type discount_type, a.discount discount, DECODE (a.age_group,'**', 'All Age Group', d.short_desc) age_group_desc, DECODE (a.speciality_code,'**', 'All Specialty', e.short_desc) speciality_desc from bl_package_discount a, bl_blng_class_lang_vw b, bl_blng_grp_lang_vw c, bl_age_group d, am_speciality e where a.package_code=? and a.operating_facility_id=? AND a.blng_class_code = b.blng_class_code(+) and  a.blng_grp_id = c.blng_grp_id(+) and b.language_id(+) =? and c.language_id(+) = ? AND a.age_group = d.age_group_code(+) AND a.speciality_code = e.speciality_code(+)";
			//Added against GHL-CRF-0502
				
			pstmt=connection.prepareStatement(sqlStr);
			System.err.println("147,sqlStr==>"+sqlStr);
			pstmt.setString(1,packageCode);			
			pstmt.setString(2,operating_facility_id);
			pstmt.setString(3,language_id);
			pstmt.setString(4,language_id);		
			rs	 = pstmt.executeQuery();
			
			while (rs.next()){
				record=new String[12];
				record[0]=checkForNull(rs.getString("blng_grp_code"));
				record[1]=checkForNull(rs.getString("blng_grp_desc"));
				record[2]=checkForNull(rs.getString("blng_class_code"));
				record[3]=checkForNull(rs.getString("blng_class_desc"));				
				record[4]=checkForNull(rs.getString("eff_from_date"));				
				record[5]=checkForNull(rs.getString("eff_to_date"));				
				record[6]=checkForNull(rs.getString("discount_type"));				
				record[7]=checkForNull(rs.getString("discount"));
				//Added against GHL-CRF-0502 Starts
				record[8]=checkForNull(rs.getString("age_group"));
				record[9]=checkForNull(rs.getString("age_group_desc"));
				record[10]=checkForNull(rs.getString("speciality_code"));				
				record[11]=checkForNull(rs.getString("speciality_desc"));

				blng_grp_discount_dtls.put(record[0]+"~~"+record[2]+"~~"+record[4]+"~~"+record[8]+"~~"+record[10],record);				
				db_blng_grp_discount_dtls.put(record[0]+"~~"+record[2]+"~~"+record[4]+"~~"+record[8]+"~~"+record[10],record);
				//Added against GHL-CRF-0502 Ends
			}

			if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			//System.out.println("in setDBValues,blng_grp_discount_dtls="+blng_grp_discount_dtls.toString());
			setBlngGrpDiscountDtls(blng_grp_discount_dtls);
			setDBBlngGrpDiscountDtls(db_blng_grp_discount_dtls);
			//System.out.println("in setDBValues,bean.getDBBlngGrpDiscountDtls()="+((HashMap)getDBBlngGrpDiscountDtls()).toString());
/***************Billing Group Discount Details***********end********************/		
		}catch(Exception e){
			System.out.println("Exception e="+e);
			e.printStackTrace();
		}finally{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection !=null ) closeConnection(connection);
		}
	}
	
	public String getSysDate() throws Exception
	{
		Connection connection 		= getConnection();	
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		String sysDate = "";
		try
		{
			String sql = "select to_char(sysdate,'dd/mm/yyyy') syDate from dual";
			pstmt=connection.prepareStatement(sql);	
			rs = pstmt.executeQuery();
			if (rs.next())
				sysDate = rs.getString("syDate");
		}
		catch(Exception e)
		{
			System.out.println("Exception from getSysDate :"+e);
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			closeConnection(connection);
		}
		return sysDate ;
	}
	
	public String getNoOfDecimal() throws Exception
	{
		Connection connection 		= getConnection();	
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		String noofdecimal = "";
		try
		{
			String sql = "select nvl(no_of_decimal,2) noofdecimal from  sm_acc_entity_param";
			pstmt=connection.prepareStatement(sql);	
			rs = pstmt.executeQuery();
			if (rs.next())
				noofdecimal = rs.getString("noofdecimal");
		}
		catch(Exception e)
		{
			System.out.println("Exception from getNoOfDecimal :"+e);
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			closeConnection(connection);
		}
		return noofdecimal ;
	}
}

