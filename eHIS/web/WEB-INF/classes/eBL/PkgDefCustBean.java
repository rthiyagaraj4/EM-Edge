/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
  /*
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210416             17021        	Common-ICN-0009-TF	           NandhiniM
2			 V211130			26231		KDAH-SCF-0744-TF		Mohanapriya K
 */
package eBL;
import java.io.*;
import java.util.*;
import java.sql.*;
import eBL.Common.*;
import webbeans.eCommon.*;

@SuppressWarnings({"rawtypes","unchecked"})
public class PkgDefCustBean extends BlAdapter implements Serializable
{
	HashMap cust_dtls=new HashMap();// for customer dtls
	HashMap cust_period=new HashMap();// for period dtls
	
	HashMap cust_base_price=new HashMap();// for rate based services dtls
	
	HashMap cust_rate_srv=new HashMap();// for rate based services dtls
	HashMap cust_rate_srv_excl=new HashMap();// for rate based services dtls
	
	HashMap cust_charge_srv=new HashMap();// for rate based services dtls
	HashMap cust_charge_srv_excl=new HashMap();// for rate based services dtls
	
	HashMap db_cust_dtls=new HashMap();// for customer dtls
	HashMap db_cust_period=new HashMap();// for period dtls
	
	HashMap db_cust_base_price=new HashMap();// for rate based services dtls
	
	HashMap db_cust_rate_srv=new HashMap();// for rate based services dtls
	HashMap db_cust_rate_srv_excl=new HashMap();// for rate based services dtls
	
	HashMap db_cust_charge_srv=new HashMap();// for rate based services dtls
	HashMap db_cust_charge_srv_excl=new HashMap();// for rate based services dtls
	
	protected String modify_cust_base_price			= "N";
	protected String modify_cust_rate_srv			= "N";
	protected String modify_cust_rate_srv_excl		= "N";
	protected String modify_cust_charge_srv			= "N";
	protected String modify_cust_charge_srv_excl			= "N";
	protected String modify_cust			= "N";
	protected String modify_cust_period			= "N";

	
	public PkgDefCustBean()
	{	
		//System.out.println("Bean Initialized");
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
		cust_dtls=new HashMap();
		cust_period=new HashMap();
		cust_base_price=new HashMap();
		cust_rate_srv=new HashMap();
		cust_rate_srv_excl=new HashMap();
		cust_charge_srv=new HashMap();
		cust_charge_srv_excl=new HashMap();
		db_cust_dtls=new HashMap();
		db_cust_period=new HashMap();
		db_cust_base_price=new HashMap();
		db_cust_rate_srv=new HashMap();
		db_cust_rate_srv_excl=new HashMap();
		db_cust_charge_srv=new HashMap();
		db_cust_charge_srv_excl=new HashMap();
		modify_cust_base_price			= "N";
		modify_cust_rate_srv			= "N";
		modify_cust_rate_srv_excl		= "N";
		modify_cust_charge_srv			= "N";
		modify_cust_charge_srv_excl		= "N";
		modify_cust			= "N";
		modify_cust_period			= "N";
	}
	
	public HashMap getCustDtls(){
		return this.cust_dtls;
	}
	
		public void setCustDtls(HashMap cust_dtls){
		 this.cust_dtls=cust_dtls;
	}
	public HashMap getCustPeriod(){
		return this.cust_period;
	}
	
	public void setCustPeriod(HashMap cust_period){
		 this.cust_period=cust_period;
	}
	
//
	public HashMap getCustBasePrice(){
		return this.cust_base_price;
	}
	
	public void setCustBasePrice(HashMap cust_base_price){
		 this.cust_base_price=cust_base_price;
	}
	//
	public HashMap getCustRateSrv(){
		return this.cust_rate_srv;
	}
	
	public void setCustRateSrv(HashMap cust_rate_srv){
		 this.cust_rate_srv=cust_rate_srv;
	}
//

	public HashMap getCustRateSrvExcl(){
		return this.cust_rate_srv_excl;
	}
	
	public void setCustRateSrvExcl(HashMap cust_rate_srv_excl){
		 this.cust_rate_srv_excl=cust_rate_srv_excl;
	}
	
//

	public HashMap getCustChargeSrv(){
		return this.cust_charge_srv;
	}
	
	public void setCustChargeSrv(HashMap cust_charge_srv){
		 this.cust_charge_srv=cust_charge_srv;
	}
//

	public HashMap getCustChargeSrvExcl(){
		return this.cust_charge_srv_excl;
	}
	
	public void setCustChargeSrvExcl(HashMap cust_charge_srv_excl){
		 this.cust_charge_srv_excl=cust_charge_srv_excl;
	}	
	
	public HashMap getCustDBDtls(){
		return this.db_cust_dtls;
	}
	
		public void setCustDBDtls(HashMap db_cust_dtls){
		 this.db_cust_dtls=db_cust_dtls;
	}
	public HashMap getCustDBPeriod(){
		return this.db_cust_period;
	}
	
	public void setCustDBPeriod(HashMap db_cust_period){
		 this.db_cust_period=db_cust_period;
	}
	
//
	public HashMap getCustDBBasePrice(){
		return this.db_cust_base_price;
	}
	
	public void setCustDBBasePrice(HashMap db_cust_base_price){
		 this.db_cust_base_price=db_cust_base_price;
	}
	//
	public HashMap getCustDBRateSrv(){
		return this.db_cust_rate_srv;
	}
	
	public void setCustDBRateSrv(HashMap db_cust_rate_srv){
		 this.db_cust_rate_srv=db_cust_rate_srv;
	}
//

	public HashMap getCustDBRateSrvExcl(){
		return this.db_cust_rate_srv_excl;
	}
	
	public void setCustDBRateSrvExcl(HashMap db_cust_rate_srv_excl){
		 this.db_cust_rate_srv_excl=db_cust_rate_srv_excl;
	}
	
//

	public HashMap getCustDBChargeSrv(){
		return this.db_cust_charge_srv;
	}
	
	public void setCustDBChargeSrv(HashMap db_cust_charge_srv){
		 this.db_cust_charge_srv=db_cust_charge_srv;
	}
//

	public HashMap getCustDBChargeSrvExcl(){
		return this.db_cust_charge_srv_excl;
	}
	
	public void setCustDBChargeSrvExcl(HashMap db_cust_charge_srv_excl){
		 this.db_cust_charge_srv_excl=db_cust_charge_srv_excl;
	}
	
	public void setModifyCustBasePrice(String flag){
		this.modify_cust_base_price=flag;
	}
	
	public String getModifyCustBasePrice(){
		return this.modify_cust_base_price;
	}
	
	public void setModifyCustRateSrv(String flag){
		this.modify_cust_rate_srv=flag;
	}
	
	public String getModifyCustRateSrv(){
		return this.modify_cust_rate_srv;
	}
	
	public void setModifyCustRateSrvExcl(String flag){
		this.modify_cust_rate_srv_excl=flag;
	}
	public String getModifyCustRateSrvExcl(){
		return this.modify_cust_rate_srv_excl;
	}

	public void setModifyCustChargeSrv(String flag){
		this.modify_cust_charge_srv=flag;
	}
	
	public String getModifyCustChargeSrv(){
		return this.modify_cust_charge_srv;
	}
	
	public void setModifyCustChargeSrvExcl(String flag){
		this.modify_cust_charge_srv_excl=flag;
	}
	public String getModifyCustChargeSrvExcl(){
		return this.modify_cust_charge_srv_excl;
	}

	public void setModifyCust(String flag){
		this.modify_cust=flag;
	}
	public String getModifyCust(){
		return this.modify_cust;
	}
	public void setModifyCustPeriod(String flag){
		this.modify_cust_period=flag;
	}
	public String getModifyCustPeriod(){
		return this.modify_cust_period;
	}	
	
	public void setDBValues(String packageCode,String language_id, String operating_facility_id) throws Exception {
		Connection connection 		= null;	
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;
		String sqlStr="";		

		String[] record;			
		HashMap cust_dtls=new HashMap();
		HashMap db_cust_dtls=new HashMap();
		String cust_grp_code="";
		String cust_code="";
		String fromDate="";
		String pkg_serv_code="";
		
		String prev_cust_grp_code="";
		String prev_cust_code="";
		String prev_fromDate="";
		String prev_pkg_serv_code="";
		try{			
			connection = getConnection();
			sqlStr="SELECT a.cust_group_code cust_grp_code, decode(a.cust_group_code,'**','All Groups',c.short_desc) cust_grp_desc, a.cust_code cust_code, decode(a.cust_code,'**','All Customers',b.short_name) cust_desc,pkg_valid_days FROM bl_package_cust_dtls a, ar_customer_lang_vw b, ar_cust_group_lang_vw c WHERE package_code =?    and a.operating_facility_id=? AND a.cust_group_code = c.cust_group_code(+) AND a.cust_code = b.cust_code(+) AND b.language_id(+) = ?  AND c.language_id(+) = ? ";

			pstmt=connection.prepareStatement(sqlStr);	
			pstmt.setString(1,packageCode);
			pstmt.setString(2,operating_facility_id);
			pstmt.setString(3,language_id);
			pstmt.setString(4,language_id);			
			rs	= pstmt.executeQuery();
			
			while (rs.next()){
				record=new String[5];
				record[0]=rs.getString("cust_grp_code")==null?"":(rs.getString("cust_grp_code")).trim();
				record[1]=rs.getString("cust_grp_desc")==null?"":(rs.getString("cust_grp_desc")).trim();
				record[2]=rs.getString("cust_code")==null?"":(rs.getString("cust_code")).trim(); 
				record[3]=checkForNull(rs.getString("cust_desc"));
				record[4]=checkForNull(rs.getString("pkg_valid_days"));				
				cust_dtls.put(record[0]+"~~"+record[2],record);				
				db_cust_dtls.put(record[0]+"~~"+record[2],record);				
			}
			setCustDtls(cust_dtls);
			setCustDBDtls(db_cust_dtls);
			
			ArrayList cust_period_list=new ArrayList();
			ArrayList db_cust_period_list=new ArrayList();
			HashMap cust_period=new HashMap();
			HashMap db_cust_period=new HashMap();
			//Modified Query V180122-Gayathri/MMS-DM-CRF-0118
			sqlStr ="SELECT a.cust_group_code,a.cust_code,TO_CHAR (a.eff_from_date, 'DD/MM/YYYY') eff_from_date,TO_CHAR (a.eff_to_date,'DD/MM/YYYY') eff_to_date, pkg_price_class_code,(SELECT short_desc FROM bl_price_class_lang_vw WHERE language_id = ?  AND price_class_code = a.pkg_price_class_code  AND operating_facility_id = ?) pkg_price_class_desc,outside_pkg_price_class_code,(SELECT short_desc FROM bl_price_class_lang_vw WHERE language_id = ? AND price_class_code = a.outside_pkg_price_class_code AND operating_facility_id = ?) outside_pkg_price_class_desc,a.GL_POST_AC_FOR_PKG gl_post_ac_for_pkg,(SELECT acc_int_desc FROM bl_gl_account_lang_vw WHERE acc_int_code = a.gl_post_ac_for_pkg AND language_id = ?  AND acc_entity_code =  (SELECT acc_entity_code  FROM sy_acc_entity b  WHERE b.acc_entity_id =?)) acc_int_desc,a.gl_post_ac_for_disc gl_post_ac_for_disc,(SELECT acc_int_desc FROM bl_gl_account_lang_vw WHERE acc_int_code = a.gl_post_ac_for_disc AND language_id = ?  AND acc_entity_code =  (SELECT acc_entity_code  FROM sy_acc_entity b  WHERE b.acc_entity_id =?)) acc_int_disc_desc, addl_chg_applicable_yn addl_chg_applicable_yn, addl_chg_rule_code addl_chg_rule_code,rule_coverage rule_coverage  FROM bl_package_cust_period a WHERE a.package_code = ?    AND a.operating_facility_id = ? GROUP BY a.cust_group_code, a.cust_code,a.eff_from_date,a.eff_to_date, pkg_price_class_code,outside_pkg_price_class_code,gl_post_ac_for_pkg,gl_post_ac_for_disc,addl_chg_applicable_yn,addl_chg_rule_code,rule_coverage ORDER BY 1,2";
					
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			
			pstmt=connection.prepareStatement(sqlStr);	
			pstmt.setString(1,language_id);				
			pstmt.setString(2,operating_facility_id);				
			pstmt.setString(3,language_id);	
			pstmt.setString(4,operating_facility_id);
			pstmt.setString(5,language_id);
			pstmt.setString(6,operating_facility_id);
			pstmt.setString(7,language_id);
			pstmt.setString(8,operating_facility_id);
			pstmt.setString(9,packageCode);
			pstmt.setString(10,operating_facility_id);
			
			rs		= pstmt.executeQuery();
			
			while (rs!=null && rs.next()){
				record=new String[15];				
				cust_grp_code=rs.getString("cust_group_code")==null?"":rs.getString("cust_group_code");
				cust_code=rs.getString("cust_code")==null?"":rs.getString("cust_code");
				record[0]=rs.getString("eff_from_date")==null?"":(rs.getString("eff_from_date")).trim();
				record[1]=rs.getString("eff_to_date")==null?"":rs.getString("eff_to_date").trim();
				record[2]=rs.getString("pkg_price_class_code")==null?"":(rs.getString("pkg_price_class_code")).trim(); 
				record[3]=checkForNull(rs.getString("pkg_price_class_desc"));
				record[4]=checkForNull(rs.getString("outside_pkg_price_class_code"));				
				record[5]=checkForNull(rs.getString("outside_pkg_price_class_desc"));	
				record[6]=checkForNull(rs.getString("gl_post_ac_for_pkg"));	
				record[7]=checkForNull(rs.getString("acc_int_desc"));	
				record[8]=checkForNull(rs.getString("gl_post_ac_for_disc"));	
				record[9]=checkForNull(rs.getString("acc_int_disc_desc"));	
				//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
				record[10]=checkForNull(rs.getString("addl_chg_applicable_yn"));
				record[11]=checkForNull(rs.getString("addl_chg_rule_code"));
				record[12]=checkForNull(rs.getString("rule_coverage"));
				
				record[13]="modify";
				record[14]=checkForNull(rs.getString("addl_chg_applicable_yn"));
					//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
				if(!cust_grp_code.equals("") && !cust_code.equals("")){
					if(cust_grp_code.equals(prev_cust_grp_code) && cust_code.equals(prev_cust_code)){
					// add to old list.
						cust_period_list.add(record);							
						db_cust_period_list.add(record);	
					}else{
						if(cust_period_list!=null && cust_period_list.size()>0){
							cust_period.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim(),cust_period_list);								
							db_cust_period.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim(),db_cust_period_list);								
						}
						cust_period_list=new ArrayList();
						db_cust_period_list=new ArrayList();
						cust_period_list.add(record);							
						db_cust_period_list.add(record);							
					}
					prev_cust_grp_code=cust_grp_code;
					prev_cust_code=cust_code;
				}  			
			}
			if(cust_period_list!=null && cust_period_list.size()>0){
				cust_period.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim(),cust_period_list);								
				db_cust_period.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim(),db_cust_period_list);								
			}
			if(cust_period!=null && cust_period.size()>0){
				setCustPeriod(cust_period);				
				setCustDBPeriod(db_cust_period);				
			 }
			
				cust_grp_code="";
				cust_code="";
				fromDate="";
				prev_cust_grp_code="";
				prev_cust_code="";
				prev_fromDate="";
				ArrayList cust_price_list=new ArrayList();
				ArrayList db_cust_price_list=new ArrayList();
				HashMap cust_base_price=new HashMap();
				HashMap db_cust_base_price=new HashMap();
				sqlStr ="select A.CUST_GROUP_CODE CUST_GROUP_CODE,A.CUST_CODE CUST_CODE,to_char(A.EFF_FROM_DATE,'dd/mm/yyyy') EFF_FROM_DATE,A.BLNG_CLASS_CODE BLNG_CLASS_CODE, decode(A.BLNG_CLASS_CODE,'**','All Groups',B.SHORT_DESC) short_DESC, A.FACTOR_RATE_IND FACTOR_RATE_IND, A.FACTOR_RATE FACTOR_RATE, A.APPLY_FACT_FOR_SRV_LMT_YN APPLY_FACT_FOR_SRV_LMT_YN, ROUNDING_BY_INTEGER, ROUNDING_OPTION,DEPOSIT_REQ_YN, ALLOW_PARTIAL_DEPOSIT_YN, MIN_PARTIAL_DEPOSIT_TYPE, MIN_PARTIAL_DEPOSIT,FACTOR_FOR_SERV_RATE from BL_PACKAGE_CUST_PRICE A,BL_BLNG_CLASS_LANG_VW B where  A.BLNG_CLASS_CODE=B.BLNG_CLASS_CODE(+) and B.LANGUAGE_ID(+)=? and A.PACKAGE_CODE=? and A.OPERATING_FACILITY_ID = ? GROUP BY a.cust_group_code, a.cust_code,a.eff_from_date,a.BLNG_CLASS_CODE, B.SHORT_DESC,a.FACTOR_RATE_IND,a.FACTOR_RATE,a.APPLY_FACT_FOR_SRV_LMT_YN,ROUNDING_BY_INTEGER,ROUNDING_OPTION,DEPOSIT_REQ_YN, ALLOW_PARTIAL_DEPOSIT_YN, MIN_PARTIAL_DEPOSIT_TYPE, MIN_PARTIAL_DEPOSIT, FACTOR_FOR_SERV_RATE ORDER BY 1,2,3";
						
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
					
				pstmt=connection.prepareStatement(sqlStr);	
				pstmt.setString(1,language_id);	
				pstmt.setString(2,packageCode);				
				pstmt.setString(3,operating_facility_id);					
				rs		= pstmt.executeQuery();
				while (rs!=null && rs.next()){
					record=new String[12];
					cust_grp_code=rs.getString("CUST_GROUP_CODE")==null?"":rs.getString("CUST_GROUP_CODE");
					cust_code=rs.getString("CUST_CODE")==null?"":rs.getString("CUST_CODE");
					fromDate=rs.getString("EFF_FROM_DATE")==null?"":rs.getString("EFF_FROM_DATE");
					record[0]=rs.getString("BLNG_CLASS_CODE")==null?"":(rs.getString("BLNG_CLASS_CODE")).trim();
					record[1]=rs.getString("short_DESC")==null?"":rs.getString("short_DESC").trim();
					record[2]=rs.getString("FACTOR_RATE_IND")==null?"":rs.getString("FACTOR_RATE_IND"); 
					record[3]=checkForNull(rs.getString("FACTOR_RATE"));		
					record[4]=checkForNull(rs.getString("ROUNDING_BY_INTEGER"));
					record[5]=checkForNull(rs.getString("ROUNDING_OPTION"));	
					record[6]=checkForNull(rs.getString("APPLY_FACT_FOR_SRV_LMT_YN"));					
					record[7] =checkForNull(rs.getString("DEPOSIT_REQ_YN"),"N");
					//System.err.println("DEPOSIT_REQ_YN in CustBean==> "+record[0]);
					record[8] = checkForNull(rs.getString("ALLOW_PARTIAL_DEPOSIT_YN"),"N");
					record[9] =checkForNull(rs.getString("MIN_PARTIAL_DEPOSIT_TYPE"));
					record[10] =checkForNull(rs.getString("MIN_PARTIAL_DEPOSIT"));
					//System.out.println("Before CustBean prev_fromDate -===> "+prev_fromDate);
					record[11] =checkForNull(rs.getString("FACTOR_FOR_SERV_RATE"));

		
					if(!cust_grp_code.equals("") && !cust_code.equals("") && !fromDate.equals("")){
						if(cust_grp_code.equals(prev_cust_grp_code) && cust_code.equals(prev_cust_code) && fromDate.equals(prev_fromDate)){
						// add to old list.
							cust_price_list.add(record);							
							db_cust_price_list.add(record);							
						}else{
							if(cust_price_list!=null && cust_price_list.size()>0){
								cust_base_price.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim(),cust_price_list);								
								db_cust_base_price.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim(),db_cust_price_list);								
							}
							cust_price_list=new ArrayList();
							cust_price_list.add(record);	
							db_cust_price_list=new ArrayList();
							db_cust_price_list.add(record);								
						}
						prev_cust_grp_code=cust_grp_code;
						prev_cust_code=cust_code;
						prev_fromDate=fromDate;
					}  			
						
				}
				if(cust_price_list!=null && cust_price_list.size()>0){
					cust_base_price.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim(),cust_price_list);								
					db_cust_base_price.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim(),db_cust_price_list);								
				}
				if(cust_base_price!=null && cust_base_price.size()>0){
					setCustBasePrice(cust_base_price);				
					setCustDBBasePrice(db_cust_base_price);				
					//System.out.println("in setDBValues,bean.getCustDBBasePrice()="+((HashMap)getCustDBBasePrice()).toString());
				}		
			
			/******************* Rate Based Servcies ***********************************/
			cust_grp_code="";
			cust_code="";
			fromDate="";
			prev_cust_grp_code="";
			prev_cust_code="";
			prev_fromDate="";
			ArrayList cust_rate_srv_list=new ArrayList();
			HashMap cust_rate_srv=new HashMap();
			ArrayList db_cust_rate_srv_list=new ArrayList();
			HashMap db_cust_rate_srv=new HashMap();
		/*	if(!copyFrm_pkgCode.equals("")){
				sqlStr ="SELECT   a.cust_group_code cust_group_code, a.cust_code cust_code,TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date,NVL (a.close_package_yn, 'N') close_package_yn, rounding_by_integer,rounding_option, auto_refund_yn, pkg_serv_ind, pkg_serv_code,b.service_desc service_desc, a.order_catalog_code order_catalog_code,(SELECT short_desc  FROM or_order_catalog_lang_vw WHERE language_id = ? AND order_catalog_code = a.order_catalog_code)   order_catalog_desc,rate_ind, factor_rate, qty_limit, amt_limit_ind, amt_limit,replaceable_yn, replaceable_serv_code,        (SELECT short_desc FROM bl_blng_serv_lang_vw WHERE language_id = ? AND blng_serv_code = a.replaceable_serv_code)   replaceable_serv_desc, rep_serv_ord_cat_code,(SELECT short_desc FROM or_order_catalog_lang_vw WHERE language_id = ? AND order_catalog_code = a.rep_serv_ord_cat_code)  rep_serv_ord_cat_desc, NVL (refund_yn, 'N') refund_yn, NVL(refund_rate, 0) refund_rate, NVL (a.apply_fact_for_srv_lmt_yn, 'N') factor_appl  FROM bl_package_coverage_for_cust a, (SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc, language_id FROM bl_blng_serv_lang_vw  UNION ALL SELECT 'C' serv_ind, serv_classification_code code, short_desc service_desc, language_id FROM bl_serv_classification_lang_vw UNION ALL  SELECT 'G' serv_ind, serv_grp_code code, short_desc service_desc, language_id  FROM bl_blng_serv_grp_lang_vw) b WHERE a.operating_facility_id = ? AND a.package_code = ? AND a.rate_charge_ind = 'R'  AND a.pkg_serv_code = b.code AND a.pkg_serv_ind = b.serv_ind AND b.language_id = ? ANd a.eff_from_date = (select max(c.eff_from_Date) from bl_package_coverage_for_cust c WHERE c.operating_facility_id = a.operating_facility_id  AND c.package_code = a.package_code ANd c.cust_group_code=a.cust_group_code AND c.cust_code=a.cust_code) ORDER BY 1, 2, 3";
			}else{*/							
					sqlStr ="SELECT   A.cust_group_code cust_group_code, A.cust_code cust_code,TO_CHAR (A.eff_from_date, 'dd/mm/yyyy') eff_from_date,NVL (A.close_package_yn, 'N') close_package_yn, rounding_by_integer,rounding_option, auto_refund_yn, pkg_serv_ind, pkg_serv_code,b.service_desc service_desc, A.order_catalog_code order_catalog_code,(SELECT short_desc FROM or_order_catalog_lang_vw WHERE language_id = ? AND order_catalog_code = A.order_catalog_code) order_catalog_desc,rate_ind, factor_rate, qty_limit, amt_limit_ind, amt_limit,replaceable_yn, replaceable_serv_code, (SELECT short_desc FROM bl_blng_serv_lang_vw WHERE language_id = ? AND blng_serv_code = A.replaceable_serv_code) replaceable_serv_desc,rep_serv_ord_cat_code,(SELECT short_desc FROM or_order_catalog_lang_vw WHERE language_id = ?  AND order_catalog_code = A.rep_serv_ord_cat_code)  rep_serv_ord_cat_desc,NVL (refund_yn, 'N') refund_yn, NVL(refund_rate, 0) refund_rate, NVL(A.split_allowed_yn,'N') split_allowed_yn, NVL(A.INCL_HOME_MEDICATION_YN,'N') INCL_HOME_MEDICATION_YN,blcommonproc.bl_pharm_service_yn('"+language_id+"',pkg_serv_ind,PKG_SERV_CODE) enableDisParam, NVL (A.apply_fact_for_srv_lmt_yn, 'N') factor_appl, NVL(DAILY_AMT_LIMIT_YN,'N') DAILY_AMT_LIMIT_YN, DAILY_AMT_LIMIT, DAILY_AMT_LIMIT_GROSS_NET, NVL(DAILY_LIMIT_IND,'*') DAILY_LIMIT_IND, DAILY_QTY_LIMIT,GROUP_SERVICE_IND  FROM bl_package_coverage_for_cust A,(SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc,language_id, status FROM bl_blng_serv_lang_vw union all select 'P' serv_ind, package_serv_group_code code, short_desc service_desc, 'en', null status from bl_package_serv_group_hdr WHERE operating_facility_id = '"+operating_facility_id+"' UNION ALL  SELECT 'C' serv_ind, serv_classification_code code,short_desc service_desc, language_id, status FROM bl_serv_classification_lang_vw   UNION ALL SELECT 'G' serv_ind, serv_grp_code code, short_desc service_desc,language_id, status FROM bl_blng_serv_grp_lang_vw) b WHERE A.operating_facility_id = ? AND b.status is null AND A.package_code = ?  AND A.rate_charge_ind = 'R' AND A.pkg_serv_code = b.code AND A.pkg_serv_ind = b.serv_ind AND b.language_id = ? GROUP BY A.cust_group_code, A.cust_code, A.eff_from_date, NVL (A.close_package_yn, 'N'),  rounding_by_integer, rounding_option, auto_refund_yn,pkg_serv_ind,pkg_serv_code, b.service_desc,A.order_catalog_code, rate_ind,factor_rate,qty_limit, amt_limit_ind, amt_limit,replaceable_yn,       replaceable_serv_code, rep_serv_ord_cat_code,NVL (refund_yn, 'N'), NVL (refund_rate, 0), NVL(A.split_allowed_yn,'N'), INCL_HOME_MEDICATION_YN,blcommonproc.bl_pharm_service_yn('"+language_id+"',pkg_serv_ind,PKG_SERV_CODE),NVL (A.apply_fact_for_srv_lmt_yn, 'N'),NVL (daily_amt_limit_yn, 'N'), daily_amt_limit, daily_amt_limit_gross_net, NVL(DAILY_LIMIT_IND,'*'), DAILY_QTY_LIMIT,GROUP_SERVICE_IND ORDER BY 1,2,3"; //V211130

			/*Commented by muthu for testing on 5/25/2012 down query rate_charge_ind is removed--
			sqlStr ="SELECT   A.cust_group_code cust_group_code, A.cust_code cust_code,TO_CHAR (A.eff_from_date, 'dd/mm/yyyy') eff_from_date,NVL (A.close_package_yn, 'N') close_package_yn, rounding_by_integer,rounding_option, auto_refund_yn, pkg_serv_ind, pkg_serv_code,b.service_desc service_desc, A.order_catalog_code order_catalog_code,(SELECT short_desc FROM or_order_catalog_lang_vw WHERE language_id = ? AND order_catalog_code = A.order_catalog_code) order_catalog_desc,rate_ind, factor_rate, qty_limit, amt_limit_ind, amt_limit,replaceable_yn, replaceable_serv_code, (SELECT short_desc FROM bl_blng_serv_lang_vw WHERE language_id = ? AND blng_serv_code = A.replaceable_serv_code) replaceable_serv_desc,rep_serv_ord_cat_code,(SELECT short_desc FROM or_order_catalog_lang_vw WHERE language_id = ?  AND order_catalog_code = A.rep_serv_ord_cat_code)  rep_serv_ord_cat_desc,NVL (refund_yn, 'N') refund_yn, NVL(refund_rate, 0) refund_rate,NVL (A.apply_fact_for_srv_lmt_yn, 'N') factor_appl  FROM bl_package_coverage_for_cust A,(SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc,language_id FROM bl_blng_serv_lang_vw union all select 'P' serv_ind, package_serv_group_code code, short_desc service_desc, 'en' from bl_package_serv_group_hdr UNION ALL  SELECT 'C' serv_ind, serv_classification_code code,short_desc service_desc, language_id FROM bl_serv_classification_lang_vw   UNION ALL SELECT 'G' serv_ind, serv_grp_code code, short_desc service_desc,language_id FROM bl_blng_serv_grp_lang_vw) b WHERE A.operating_facility_id = ? AND A.package_code = ? AND A.pkg_serv_code = b.code AND A.pkg_serv_ind = b.serv_ind AND b.language_id = ? GROUP BY A.cust_group_code, A.cust_code, A.eff_from_date, NVL (A.close_package_yn, 'N'),  rounding_by_integer, rounding_option, auto_refund_yn,pkg_serv_ind,pkg_serv_code, b.service_desc,A.order_catalog_code, rate_ind,factor_rate,qty_limit, amt_limit_ind, amt_limit,replaceable_yn,       replaceable_serv_code, rep_serv_ord_cat_code,NVL (refund_yn, 'N'), NVL (refund_rate, 0),NVL (A.apply_fact_for_srv_lmt_yn, 'N') ORDER BY 1,2,3";*/
			//	}
			
			//System.out.println("581 in setDBValues,sqlStr="+sqlStr);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
				
			pstmt=connection.prepareStatement(sqlStr);	
			pstmt.setString(1,language_id);	
			pstmt.setString(2,language_id);	
			pstmt.setString(3,language_id);	
			pstmt.setString(4,operating_facility_id);	
			pstmt.setString(5,packageCode);				
			pstmt.setString(6,language_id);						
		
			rs		= pstmt.executeQuery();
			
			while (rs!=null && rs.next()){
				record=new String[31]; //Split reqd
				cust_grp_code=rs.getString("CUST_GROUP_CODE")==null?"":rs.getString("CUST_GROUP_CODE");
				cust_code=rs.getString("CUST_CODE")==null?"":rs.getString("CUST_CODE");
				fromDate=rs.getString("EFF_FROM_DATE")==null?"":rs.getString("EFF_FROM_DATE");
				record[0]=rs.getString("pkg_serv_ind")==null?"":(rs.getString("pkg_serv_ind")).trim();
				record[1]=rs.getString("pkg_serv_code")==null?"":rs.getString("pkg_serv_code").trim();
				record[2]=rs.getString("service_desc")==null?"":rs.getString("service_desc"); 
				record[3]=checkForNull(rs.getString("order_catalog_code"));
				record[4]=checkForNull(rs.getString("order_catalog_desc"));				
				record[5]=checkForNull(rs.getString("rate_ind"));				
				record[6]=checkForNull(rs.getString("factor_rate"));		
				record[7]=checkForNull(rs.getString("qty_limit"));		
				record[8]=checkForNull(rs.getString("AMT_LIMIT_IND"));		
				record[9]=checkForNull(rs.getString("amt_limit"));		
				record[10]=checkForNull(rs.getString("replaceable_yn"));		
				record[11]=checkForNull(rs.getString("replaceable_serv_code"));		
				record[12]=checkForNull(rs.getString("replaceable_serv_desc"));		
				record[13]=checkForNull(rs.getString("rep_serv_ord_cat_code"));		
				record[14]=checkForNull(rs.getString("rep_serv_ord_cat_desc"));		
				record[15]=checkForNull(rs.getString("refund_yn"));		
				record[16]=checkForNull(rs.getString("REFUND_RATE"));		
				record[17]=checkForNull(rs.getString("AUTO_REFUND_YN"));		
				record[18]=checkForNull(rs.getString("factor_appl"));		
				record[19]=checkForNull(rs.getString("ROUNDING_BY_INTEGER"));		
				record[20]=checkForNull(rs.getString("ROUNDING_OPTION"));		
				record[21]=checkForNull(rs.getString("CLOSE_PACKAGE_YN"),"N");	
				record[22]=checkForNull(rs.getString("split_allowed_yn"),"N");
				record[23]=checkForNull(rs.getString("INCL_HOME_MEDICATION_YN"),"N");
				record[24]=checkForNull(rs.getString("enableDisParam"),"N");
				record[25]=checkForNull(rs.getString("DAILY_AMT_LIMIT_YN"),"N");//Added V190320-Aravindh/MMS-DM-CRF-0129
				record[26]=checkForNull(rs.getString("DAILY_AMT_LIMIT"));//Added V190320-Aravindh/MMS-DM-CRF-0129
				record[27]=checkForNull(rs.getString("DAILY_AMT_LIMIT_GROSS_NET"));//Added V190320-Aravindh/MMS-DM-CRF-0129
				record[28]=checkForNull(rs.getString("DAILY_LIMIT_IND"));//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				record[29]=checkForNull(rs.getString("DAILY_QTY_LIMIT"));//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				record[30]=checkForNull(rs.getString("GROUP_SERVICE_IND"));//Added 200728-Shikha/MMS-QH-CRF-0170
				if(!cust_grp_code.equals("") && !cust_code.equals("") && !fromDate.equals("")){
					if(cust_grp_code.equals(prev_cust_grp_code) && cust_code.equals(prev_cust_code) && fromDate.equals(prev_fromDate)){
					// add to old list.
						cust_rate_srv_list.add(record);							
						db_cust_rate_srv_list.add(record);							
					}else{
						if(cust_rate_srv_list!=null && cust_rate_srv_list.size()>0){
							cust_rate_srv.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim(),cust_rate_srv_list);								
							db_cust_rate_srv.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim(),db_cust_rate_srv_list);								
						}
						cust_rate_srv_list=new ArrayList();
						cust_rate_srv_list.add(record);		
						db_cust_rate_srv_list=new ArrayList();
						db_cust_rate_srv_list.add(record);							
					}
					prev_cust_grp_code=cust_grp_code;
					prev_cust_code=cust_code;
					prev_fromDate=fromDate;
				}  			
					
			}
			if(cust_rate_srv_list!=null && cust_rate_srv_list.size()>0){
				cust_rate_srv.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim(),cust_rate_srv_list);								
				db_cust_rate_srv.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim(),db_cust_rate_srv_list);								
			}
			if(cust_rate_srv!=null && cust_rate_srv.size()>0){
				setCustRateSrv(cust_rate_srv);				
				setCustDBRateSrv(db_cust_rate_srv);				
				//System.out.println("in setDBValues,bean.getCustDBRateSrv()="+((HashMap)getCustDBRateSrv()).toString());
			}
		/******************Rate based service Exclusions*************************************************/
			cust_grp_code="";
			cust_code="";
			fromDate="";
			pkg_serv_code="";
			prev_cust_grp_code="";
			prev_cust_code="";
			prev_fromDate="";
			prev_pkg_serv_code="";
			ArrayList cust_rate_srv_excl_list=new ArrayList();
			HashMap cust_rate_srv_excl=new HashMap();
			ArrayList db_cust_rate_srv_excl_list=new ArrayList();
			HashMap db_cust_rate_srv_excl=new HashMap();
			/*if(!copyFrm_pkgCode.equals("")){
				sqlStr ="SELECT  a.cust_group_code cust_group_code,a.cust_code cust_code,to_char(a.eff_from_date,'dd/mm/yyyy') eff_from_date,a.PKG_SERV_CODE pkg_serv_code,a.excl_serv_ind excl_serv_ind,a.excl_serv_code excl_serv_code, b.service_desc service_desc,a.exclude_yn exclude_yn, qty_limit, amt_limit,a.apply_fact_for_srv_lmt_yn factor_appl,AMT_LIMIT_IND, REPLACEABLE_YN, REPLACEABLE_SERV_CODE,(SELECT long_desc FROM bl_blng_serv_lang_vw  WHERE blng_serv_code = A.replaceable_serv_code AND language_id = ?) REPLACEABLE_SERV_DESC, REFUND_YN, REFUND_RATE, ROUNDING_BY_INTEGER, ROUNDING_OPTION, AUTO_REFUND_YN FROM BL_PACKAGE_EXCL_FOR_CUST a, (select 'S' Serv_Ind, blng_serv_code code, short_desc service_desc,language_id from BL_BLNG_SERV_lang_vw  union all  select 'C' serv_ind, serv_classification_code code, short_desc service_desc,language_id from BL_SERV_CLASSIFICATION_lang_vw ) b WHERE a.operating_facility_id = ?   AND a.package_code =? AND a.rate_charge_ind = 'R'  and  a.excl_serv_code=b.code  AND a.excl_serv_ind=b.Serv_Ind AND b.language_id=? ANd a.eff_from_date = (select max(c.eff_from_Date) from BL_PACKAGE_EXCL_FOR_CUST c WHERE c.operating_facility_id = a.operating_facility_id  AND c.package_code = a.package_code ANd c.cust_group_code=a.cust_group_code AND c.cust_code=a.cust_code) order by 1,2,3";
			}else{*/
			//Changes done 		

			sqlStr ="SELECT  a.cust_group_code cust_group_code,a.cust_code cust_code,to_char(a.eff_from_date,'dd/mm/yyyy') eff_from_date,a.PKG_SERV_CODE pkg_serv_code,a.excl_serv_ind excl_serv_ind,a.excl_serv_code excl_serv_code, b.service_desc service_desc,a.exclude_yn exclude_yn, qty_limit, amt_limit,a.apply_fact_for_srv_lmt_yn factor_appl,AMT_LIMIT_IND, REPLACEABLE_YN, REPLACEABLE_SERV_CODE,(SELECT long_desc FROM bl_blng_serv_lang_vw  WHERE blng_serv_code = A.replaceable_serv_code AND language_id = ?) REPLACEABLE_SERV_DESC, REFUND_YN, REFUND_RATE, ROUNDING_BY_INTEGER, ROUNDING_OPTION, a.split_allowed_yn,a.INCL_HOME_MEDICATION_YN,blcommonproc.bl_pharm_service_yn('"+language_id+"',excl_serv_ind,excl_serv_code) enableDisParam, AUTO_REFUND_YN, NVL(DAILY_AMT_LIMIT_YN,'N') DAILY_AMT_LIMIT_YN, DAILY_AMT_LIMIT, DAILY_AMT_LIMIT_GROSS_NET, NVL(DAILY_LIMIT_IND,'*') DAILY_LIMIT_IND, DAILY_QTY_LIMIT FROM BL_PACKAGE_EXCL_FOR_CUST a, (select 'S' Serv_Ind, blng_serv_code code, short_desc service_desc,language_id from BL_BLNG_SERV_lang_vw  union all select 'P' serv_ind, package_serv_group_code code, short_desc service_desc, 'en' from bl_package_serv_group_hdr WHERE operating_facility_id = '"+operating_facility_id+"' union all select 'T' serv_ind, sale_category_code code, short_desc service_desc, 'en' from bl_st_item_sale_catg_hdr union all select 'G' serv_ind, serv_grp_code code, short_desc description, language_id from bl_blng_serv_grp_lang_vw union all  select 'C' serv_ind, serv_classification_code code, short_desc service_desc,language_id from BL_SERV_CLASSIFICATION_lang_vw union all select 'M' serv_ind, item_code code, short_desc service_desc,language_id from MM_ITem_lang_vw ) b WHERE a.operating_facility_id = ?   AND a.package_code =? and  a.excl_serv_code=b.code  AND a.excl_serv_ind=b.Serv_Ind AND b.language_id=? GROUP BY A.cust_group_code , A.cust_code ,eff_from_date,A.pkg_serv_code ,A.excl_serv_ind ,A.excl_serv_code , b.service_desc ,A.exclude_yn, qty_limit,amt_limit,A.apply_fact_for_srv_lmt_yn ,amt_limit_ind,replaceable_yn,replaceable_serv_code, refund_yn, refund_rate, rounding_by_integer,  rounding_option, a.split_allowed_yn, INCL_HOME_MEDICATION_YN,blcommonproc.bl_pharm_service_yn('"+language_id+"',excl_serv_ind,excl_serv_code),auto_refund_yn, NVL(DAILY_AMT_LIMIT_YN,'N'), DAILY_AMT_LIMIT, DAILY_AMT_LIMIT_GROSS_NET, NVL(DAILY_LIMIT_IND,'*'), DAILY_QTY_LIMIT order by 1,2,4,3"; //V211130
			//sqlStr ="SELECT  a.cust_group_code cust_group_code,a.cust_code cust_code,to_char(a.eff_from_date,'dd/mm/yyyy') eff_from_date,a.PKG_SERV_CODE pkg_serv_code,a.excl_serv_ind excl_serv_ind,a.excl_serv_code excl_serv_code, b.service_desc service_desc,a.exclude_yn exclude_yn, qty_limit, amt_limit,a.apply_fact_for_srv_lmt_yn factor_appl,AMT_LIMIT_IND, REPLACEABLE_YN, REPLACEABLE_SERV_CODE,(SELECT long_desc FROM bl_blng_serv_lang_vw  WHERE blng_serv_code = A.replaceable_serv_code AND language_id = ?) REPLACEABLE_SERV_DESC, REFUND_YN, REFUND_RATE, ROUNDING_BY_INTEGER, ROUNDING_OPTION, AUTO_REFUND_YN FROM BL_PACKAGE_EXCL_FOR_CUST a, (select 'S' Serv_Ind, blng_serv_code code, short_desc service_desc,language_id from BL_BLNG_SERV_lang_vw  union all  select 'C' serv_ind, serv_classification_code code, short_desc service_desc,language_id from BL_SERV_CLASSIFICATION_lang_vw ) b WHERE a.operating_facility_id = ?   AND a.package_code =? AND a.rate_charge_ind = 'R'  and  a.excl_serv_code=b.code  AND a.excl_serv_ind=b.Serv_Ind AND b.language_id=? GROUP BY A.cust_group_code , A.cust_code ,eff_from_date,A.pkg_serv_code ,A.excl_serv_ind ,A.excl_serv_code , b.service_desc ,A.exclude_yn, qty_limit,amt_limit,A.apply_fact_for_srv_lmt_yn ,amt_limit_ind,replaceable_yn,replaceable_serv_code, refund_yn, refund_rate, rounding_by_integer,  rounding_option, auto_refund_yn order by 1,2,3";


			/*Commented by muthu for testing on 5/25/2012 above query rate_charge_ind & order By is Changed				sqlStr ="SELECT  a.cust_group_code cust_group_code,a.cust_code cust_code,to_char(a.eff_from_date,'dd/mm/yyyy') eff_from_date,a.PKG_SERV_CODE pkg_serv_code,a.excl_serv_ind excl_serv_ind,a.excl_serv_code excl_serv_code, b.service_desc service_desc,a.exclude_yn exclude_yn, qty_limit, amt_limit,a.apply_fact_for_srv_lmt_yn factor_appl,AMT_LIMIT_IND, REPLACEABLE_YN, REPLACEABLE_SERV_CODE,(SELECT long_desc FROM bl_blng_serv_lang_vw  WHERE blng_serv_code = A.replaceable_serv_code AND language_id = ?) REPLACEABLE_SERV_DESC, REFUND_YN, REFUND_RATE, ROUNDING_BY_INTEGER, ROUNDING_OPTION, AUTO_REFUND_YN FROM BL_PACKAGE_EXCL_FOR_CUST a, (select 'S' Serv_Ind, blng_serv_code code, short_desc service_desc,language_id from BL_BLNG_SERV_lang_vw  union all select 'P' serv_ind, package_serv_group_code code, short_desc service_desc, 'en' from bl_package_serv_group_hdr union all select 'T' serv_ind, sale_category_code code, short_desc service_desc, 'en' from bl_st_item_sale_catg_hdr union all select 'G' serv_ind, serv_grp_code code, short_desc description, language_id from bl_blng_serv_grp_lang_vw union all  select 'C' serv_ind, serv_classification_code code, short_desc service_desc,language_id from BL_SERV_CLASSIFICATION_lang_vw union all select 'M' serv_ind, item_code code, short_desc service_desc,language_id from MM_ITem_lang_vw ) b WHERE a.operating_facility_id = ?   AND a.package_code =? AND a.rate_charge_ind = 'R'  and  a.excl_serv_code=b.code  AND a.excl_serv_ind=b.Serv_Ind AND b.language_id=? GROUP BY A.cust_group_code , A.cust_code ,eff_from_date,A.pkg_serv_code ,A.excl_serv_ind ,A.excl_serv_code , b.service_desc ,A.exclude_yn, qty_limit,amt_limit,A.apply_fact_for_srv_lmt_yn ,amt_limit_ind,replaceable_yn,replaceable_serv_code, refund_yn, refund_rate, rounding_by_integer,  rounding_option, auto_refund_yn order by 1,2,3";*/

		//	}
					//System.out.println("674 in setDBValues,sqlStr="+sqlStr);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
				
			pstmt=connection.prepareStatement(sqlStr);			
			pstmt.setString(1,language_id);		
			pstmt.setString(2,operating_facility_id);		
			//System.out.println("CustBean operating_facility_id ==> "+operating_facility_id);
			pstmt.setString(3,packageCode);
			//System.out.println("CustBean packageCode ==> "+packageCode);
			pstmt.setString(4,language_id);
			//System.out.println("CustBean language_id ==> "+language_id);
					
			rs		= pstmt.executeQuery();
			
			while (rs!=null && rs.next()){
				record=new String[24];//Split reqd
				cust_grp_code=rs.getString("cust_group_code")==null?"":rs.getString("cust_group_code");
				cust_code=rs.getString("cust_code")==null?"":rs.getString("cust_code");
				fromDate=rs.getString("eff_from_date")==null?"":rs.getString("eff_from_date");
				pkg_serv_code=rs.getString("pkg_serv_code")==null?"":rs.getString("pkg_serv_code");
				record[0]=rs.getString("excl_serv_ind")==null?"":(rs.getString("excl_serv_ind")).trim();
				record[1]=rs.getString("excl_serv_code")==null?"":rs.getString("excl_serv_code").trim();
				record[2]=rs.getString("service_desc")==null?"":rs.getString("service_desc"); 
				record[3]=checkForNull(rs.getString("exclude_yn"));
				record[4]=checkForNull(rs.getString("qty_limit"));				
				record[5]=checkForNull(rs.getString("AMT_LIMIT_IND"));				
				record[6]=checkForNull(rs.getString("amt_limit"));				
				record[7]=checkForNull(rs.getString("ROUNDING_BY_INTEGER"));		
				record[8]=checkForNull(rs.getString("ROUNDING_OPTION"));		
				record[9]=checkForNull(rs.getString("REPLACEABLE_YN"));		
				record[10]=checkForNull(rs.getString("REPLACEABLE_SERV_CODE"));		
				record[11]=checkForNull(rs.getString("REPLACEABLE_SERV_DESC"));		
				record[12]=checkForNull(rs.getString("REFUND_YN"));		
				record[13]=checkForNull(rs.getString("REFUND_RATE"));		
				record[14]=checkForNull(rs.getString("AUTO_REFUND_YN"));		
				record[15]=checkForNull(rs.getString("factor_appl"));	
				record[16]=checkForNull(rs.getString("split_allowed_yn"),"N");//Split reqd
				record[17]=checkForNull(rs.getString("INCL_HOME_MEDICATION_YN"),"N");//Split reqd
				record[18]=checkForNull(rs.getString("enableDisParam"),"N");//Split reqd
				record[19]=checkForNull(rs.getString("DAILY_AMT_LIMIT_YN"),"N");//Added V190320-Aravindh/MMS-DM-CRF-0129
				record[20]=checkForNull(rs.getString("DAILY_AMT_LIMIT"));//Added V190320-Aravindh/MMS-DM-CRF-0129
				record[21]=checkForNull(rs.getString("DAILY_AMT_LIMIT_GROSS_NET"));//Added V190320-Aravindh/MMS-DM-CRF-0129
				record[22]=checkForNull(rs.getString("DAILY_LIMIT_IND"));//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				record[23]=checkForNull(rs.getString("DAILY_QTY_LIMIT"));//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				//System.out.println("Result Size ==> "+rs.getRow());
				//System.out.println("fromDate ==> "+fromDate);
				//System.out.println("pkg_serv_code 742 ==> "+pkg_serv_code);
				//System.out.println("excl_serv_code 742.1 ==> "+record[1]);
				
				if(!cust_grp_code.equals("") && !cust_code.equals("") && !fromDate.equals("") && !pkg_serv_code.equals("")){
				//if(!cust_grp_code.equals("") && !cust_code.equals("") && !fromDate.equals("")){ - Commented by muthu on 5/27/2012
				//System.out.println("Testing 743 "+pkg_serv_code+"prev_pkg_serv_code  "+prev_pkg_serv_code);
				//	System.out.println("743.1");
				if(cust_grp_code.equals(prev_cust_grp_code) && cust_code.equals(prev_cust_code) && fromDate.equals(prev_fromDate) && pkg_serv_code.equals(prev_pkg_serv_code)){ 
					// add to old list.
						cust_rate_srv_excl_list.add(record);							
						db_cust_rate_srv_excl_list.add(record);							
					}else{

						if(cust_rate_srv_excl_list!=null && cust_rate_srv_excl_list.size()>0){
							cust_rate_srv_excl.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),cust_rate_srv_excl_list);								
						db_cust_rate_srv_excl.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),db_cust_rate_srv_excl_list);					
						}
						cust_rate_srv_excl_list=new ArrayList();
						cust_rate_srv_excl_list.add(record);	
						db_cust_rate_srv_excl_list=new ArrayList();
						db_cust_rate_srv_excl_list.add(record);							
					}
					prev_cust_grp_code=cust_grp_code;
					prev_cust_code=cust_code;
					prev_fromDate=fromDate;
					prev_pkg_serv_code=pkg_serv_code;
				}  
					
			}
			if(cust_rate_srv_excl_list!=null && cust_rate_srv_excl_list.size()>0){
				cust_rate_srv_excl.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),cust_rate_srv_excl_list);								
			
			db_cust_rate_srv_excl.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),db_cust_rate_srv_excl_list);	
			

			}
			if(cust_rate_srv_excl!=null && cust_rate_srv_excl.size()>0){
				setCustRateSrvExcl(cust_rate_srv_excl);				
				setCustDBRateSrvExcl(db_cust_rate_srv_excl);				
			}			
				
			/******************* Charge Based Servcies ***********************************/
			cust_grp_code="";
			cust_code="";
			fromDate="";
			prev_cust_grp_code="";
			prev_cust_code="";
			prev_fromDate="";
			ArrayList cust_charge_srv_list=new ArrayList();
			HashMap cust_charge_srv=new HashMap();
			ArrayList db_cust_charge_srv_list=new ArrayList();
			HashMap db_cust_charge_srv=new HashMap();
		/*	if(!copyFrm_pkgCode.equals("")){
				sqlStr ="SELECT A.cust_group_code cust_group_code, A.cust_code cust_code,TO_CHAR (A.eff_from_date, 'dd/mm/yyyy') eff_from_date,pkg_serv_code, b.short_desc service_desc,amt_limit_ind, amt_limit,rounding_by_integer,rounding_option,NVL (refund_yn, 'N') refund_yn,NVL(refund_rate, 0) refund_rate,auto_refund_yn,NVL (A.apply_fact_for_srv_lmt_yn, 'N') factor_appl FROM bl_package_coverage_for_cust a, bl_blng_serv_lang_vw b WHERE a.operating_facility_id = ?  AND a.package_code = ?  AND a.rate_charge_ind = 'C'   AND a.pkg_serv_code =b.blng_serv_code AND b.language_id = ? ANd a.eff_from_date = (select max(c.eff_from_Date) from bl_package_coverage_for_cust c WHERE c.operating_facility_id = a.operating_facility_id  AND c.package_code = a.package_code ANd c.cust_group_code=a.cust_group_code AND c.cust_code=a.cust_code) order by 1,2,3";
			}else{*/
				//sqlStr ="SELECT A.cust_group_code cust_group_code, A.cust_code cust_code,TO_CHAR (A.eff_from_date, 'dd/mm/yyyy') eff_from_date,pkg_serv_code, b.short_desc service_desc,amt_limit_ind, amt_limit,rounding_by_integer,rounding_option,NVL (refund_yn, 'N') refund_yn,NVL(refund_rate, 0) refund_rate,auto_refund_yn,NVL (A.apply_fact_for_srv_lmt_yn, 'N') factor_appl FROM bl_package_coverage_for_cust a, bl_blng_serv_lang_vw b WHERE a.operating_facility_id = ?  AND a.package_code = ?  AND a.rate_charge_ind = 'C'   AND a.pkg_serv_code =b.blng_serv_code AND b.language_id = ? GROUP BY A.cust_group_code, A.cust_code, A.eff_from_date, pkg_serv_code, b.short_desc, amt_limit_ind, amt_limit,rounding_by_integer, rounding_option, NVL (refund_yn, 'N'), NVL (refund_rate, 0),auto_refund_yn,NVL (A.apply_fact_for_srv_lmt_yn, 'N') ORDER BY 1,2,3";
				//sqlStr ="SELECT a.cust_group_code cust_group_code, a.cust_code cust_code,TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date , pkg_serv_ind, pkg_serv_code,  b.service_desc service_desc, amt_limit_ind, amt_limit,rounding_by_integer, rounding_option, NVL (refund_yn, 'N') refund_yn, NVL (refund_rate, 0) refund_rate, auto_refund_yn,NVL (a.apply_fact_for_srv_lmt_yn, 'N') factor_appl FROM bl_package_coverage_for_cust a, (SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc,language_id FROM bl_blng_serv_lang_vw UNION ALL SELECT 'M' serv_ind, item_code code, short_desc service_desc,language_id FROM mm_item_lang_vw) b WHERE a.operating_facility_id = ? AND a.package_code = ?  AND a.rate_charge_ind = 'C' AND a.pkg_serv_code = b.code  and a.pkg_serv_ind = b.serv_ind AND b.language_id = ? GROUP BY a.cust_group_code, a.cust_code, a.eff_from_date,  pkg_serv_ind, pkg_serv_code, b.service_desc, amt_limit_ind, amt_limit, rounding_by_integer, rounding_option, NVL (refund_yn, 'N'), NVL (refund_rate, 0), auto_refund_yn, NVL (a.apply_fact_for_srv_lmt_yn, 'N') ORDER BY 1,2,3";
				sqlStr ="SELECT   a.cust_group_code cust_group_code, a.cust_code cust_code, TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date, pkg_serv_ind,pkg_serv_code, b.service_desc service_desc, amt_limit_ind, amt_limit,rounding_by_integer, rounding_option, NVL (refund_yn, 'N') refund_yn, NVL (refund_rate, 0) refund_rate, auto_refund_yn,NVL (a.apply_fact_for_srv_lmt_yn, 'N') factor_appl,  NVL(A.split_allowed_yn,'N') split_allowed_yn, NVL(A.INCL_HOME_MEDICATION_YN,'N') INCL_HOME_MEDICATION_YN,blcommonproc.bl_pharm_service_yn('"+language_id+"',pkg_serv_ind,PKG_SERV_CODE) enableDisParam,(SELECt 'Y' FROM BL_PACKAGE_EXCL_FOR_CUST c WHERE c.operating_facility_id = a.operating_facility_id AND c.package_code = a.package_code AND c.pkg_serv_code = a.pkg_serv_code	AND c.pkg_serv_ind = a.pkg_serv_ind AND ROWNUM = 1) service_limit,GROUP_SERVICE_IND FROM bl_package_coverage_for_cust a, (SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc, language_id, status FROM bl_blng_serv_lang_vw UNION ALL SELECT 'M' serv_ind, item_code code, short_desc service_desc, language_id, null status FROM mm_item_lang_vw) b WHERE a.operating_facility_id = ? AND b.status is null AND a.package_code = ? AND a.rate_charge_ind = 'C' AND a.pkg_serv_code = b.code AND a.pkg_serv_ind = b.serv_ind AND b.language_id = ? ORDER BY 1, 2, 3";
			//}		
			//System.out.println("756 in setDBValues,sqlStr="+sqlStr);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();				
			pstmt=connection.prepareStatement(sqlStr);	
			pstmt.setString(1,operating_facility_id);	
			pstmt.setString(2,packageCode);
			pstmt.setString(3,language_id);						
			rs		= pstmt.executeQuery();			
			while (rs!=null && rs.next()){
				record=new String[15];//Aplit reqd
//				record=new String[11];//MuthuN against 28192
				//record=new String[10];
				cust_grp_code=rs.getString("cust_group_code")==null?"":rs.getString("cust_group_code");
				cust_code=rs.getString("cust_code")==null?"":rs.getString("cust_code");
				fromDate=rs.getString("eff_from_date")==null?"":rs.getString("eff_from_date");
				record[0]=rs.getString("pkg_serv_ind")==null?"":rs.getString("pkg_serv_ind").trim();//MuthuN against 28192
				//record[0]=rs.getString("pkg_serv_code")==null?"":rs.getString("pkg_serv_code").trim();//MuthuN against 28192
				record[1]=rs.getString("pkg_serv_code")==null?"":rs.getString("pkg_serv_code").trim();	
				record[2]=rs.getString("service_desc")==null?"":rs.getString("service_desc"); 
				record[3]=checkForNull(rs.getString("amt_limit_ind"));
				record[4]=checkForNull(rs.getString("amt_limit"));				
				record[5]=checkForNull(rs.getString("rounding_by_integer"));				
				record[6]=checkForNull(rs.getString("rounding_option"));		
				record[7]=checkForNull(rs.getString("refund_yn"));		
				record[8]=checkForNull(rs.getString("refund_rate"));		
				record[9]=checkForNull(rs.getString("auto_refund_yn"));		
				record[10]=checkForNull(rs.getString("factor_appl"));
				record[11]=checkForNull(rs.getString("service_limit"));
				record[12]=checkForNull(rs.getString("split_allowed_yn"));//Split reqd
				record[13]=checkForNull(rs.getString("INCL_HOME_MEDICATION_YN"));//Split reqd
				record[14]=checkForNull(rs.getString("enableDisParam"));//Split reqd
				/*record[0]=rs.getString("pkg_serv_code")==null?"":rs.getString("pkg_serv_code").trim();
				record[1]=rs.getString("service_desc")==null?"":rs.getString("service_desc"); 
				record[2]=checkForNull(rs.getString("amt_limit_ind"));
				record[3]=checkForNull(rs.getString("amt_limit"));				
				record[4]=checkForNull(rs.getString("rounding_by_integer"));				
				record[5]=checkForNull(rs.getString("rounding_option"));		
				record[6]=checkForNull(rs.getString("refund_yn"));		
				record[7]=checkForNull(rs.getString("refund_rate"));		
				record[8]=checkForNull(rs.getString("auto_refund_yn"));		
				record[9]=checkForNull(rs.getString("factor_appl"));*/	
				if(!cust_grp_code.equals("") && !cust_code.equals("") && !fromDate.equals("")){
					if(cust_grp_code.equals(prev_cust_grp_code) && cust_code.equals(prev_cust_code) && fromDate.equals(prev_fromDate)){
					// add to old list.
						cust_charge_srv_list.add(record);							
						db_cust_charge_srv_list.add(record);							
					}else{
						if(cust_charge_srv_list!=null && cust_charge_srv_list.size()>0){
							//System.out.println("cust_charge_srv_list="+cust_charge_srv_list.toString());		
							cust_charge_srv.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim(),cust_charge_srv_list);								
							db_cust_charge_srv.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim(),db_cust_charge_srv_list);								
						}
						cust_charge_srv_list=new ArrayList();
						cust_charge_srv_list.add(record);	
						db_cust_charge_srv_list=new ArrayList();
						db_cust_charge_srv_list.add(record);							
					}
					prev_cust_grp_code=cust_grp_code;
					prev_cust_code=cust_code;
					prev_fromDate=fromDate;
				}  			
					
			}
			if(cust_charge_srv_list!=null && cust_charge_srv_list.size()>0){
				//System.out.println("cust_charge_srv_list="+cust_charge_srv_list.toString());		
				cust_charge_srv.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim(),cust_charge_srv_list);								
				db_cust_charge_srv.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim(),db_cust_charge_srv_list);								
			}
			if(cust_charge_srv!=null && cust_charge_srv.size()>0){
				setCustChargeSrv(cust_charge_srv);				
				setCustDBChargeSrv(db_cust_charge_srv);				
				//System.out.println("in setDBValues,bean.getCustDBChargeSrv()="+((HashMap)getCustDBChargeSrv()).toString());
			}
				/******************Charge based service Exclusions*************************************************/
			cust_grp_code="";
			cust_code="";
			fromDate="";
			pkg_serv_code="";
			prev_cust_grp_code="";
			prev_cust_code="";
			prev_fromDate="";
			prev_pkg_serv_code="";
			ArrayList cust_charge_srv_excl_list=new ArrayList();
			HashMap cust_charge_srv_excl=new HashMap();
			ArrayList db_cust_charge_srv_excl_list=new ArrayList();
			HashMap db_cust_charge_srv_excl=new HashMap();
		/*	if(!copyFrm_pkgCode.equals("")){
				sqlStr ="SSELECT  a.cust_group_code cust_group_code,a.cust_code cust_code,to_char(a.eff_from_date,'dd/mm/yyyy') eff_from_date,a.pkg_serv_code pkg_serv_code,a.excl_serv_code excl_serv_code, b.short_desc service_desc,a.exclude_yn exclude_yn, qty_limit, amt_limit FROM BL_PACKAGE_EXCL_FOR_CUST a, mm_item_lang_vw b WHERE a.operating_facility_id = ?   AND a.package_code =? AND a.rate_charge_ind = 'C'  and  a.excl_serv_code=b.item_code  AND b.language_id=? ANd a.eff_from_date = (select max(c.eff_from_Date) from BL_PACKAGE_EXCL_FOR_CUST c WHERE c.operating_facility_id = a.operating_facility_id  AND c.package_code = a.package_code ANd c.cust_group_code=a.cust_group_code AND c.cust_code=a.cust_code) order by 1,2,3";
			}else{*/
			sqlStr ="SELECT  a.cust_group_code cust_group_code,a.cust_code cust_code,to_char(a.eff_from_date,'dd/mm/yyyy') eff_from_date,a.pkg_serv_code pkg_serv_code,a.excl_serv_code excl_serv_code, b.short_desc service_desc,a.exclude_yn exclude_yn, qty_limit, a.split_allowed_yn,a.INCL_HOME_MEDICATION_YN,blcommonproc.bl_pharm_service_yn('"+language_id+"',EXCL_SERV_IND,excl_serv_code) enableDisParam, amt_limit FROM BL_PACKAGE_EXCL_FOR_CUST a, mm_item_lang_vw b WHERE a.operating_facility_id = ?   AND a.package_code =? AND a.rate_charge_ind = 'C'  and  a.excl_serv_code=b.item_code  AND b.language_id=? GROUP BY a.cust_group_code , a.cust_code ,eff_from_date,a.pkg_serv_code ,a.excl_serv_code , b.short_desc ,a.exclude_yn, qty_limit, a.split_allowed_yn, INCL_HOME_MEDICATION_YN,blcommonproc.bl_pharm_service_yn('"+language_id+"',EXCL_SERV_IND,excl_serv_code),amt_limit order by 1,2,3";
		//	}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
				
			pstmt=connection.prepareStatement(sqlStr);			
			pstmt.setString(1,operating_facility_id);
			pstmt.setString(2,packageCode);								
			
			pstmt.setString(3,language_id);						
					
			rs		= pstmt.executeQuery();
			
			while (rs!=null && rs.next()){
				record=new String[8];//Split reqd
				cust_grp_code=rs.getString("cust_group_code")==null?"":rs.getString("cust_group_code");
				cust_code=rs.getString("cust_code")==null?"":rs.getString("cust_code");
				fromDate=rs.getString("eff_from_date")==null?"":rs.getString("eff_from_date");
				pkg_serv_code=rs.getString("pkg_serv_code")==null?"":rs.getString("pkg_serv_code");
				record[0]=rs.getString("excl_serv_code")==null?"":rs.getString("excl_serv_code").trim();
				record[1]=rs.getString("service_desc")==null?"":rs.getString("service_desc"); 
				record[2]=checkForNull(rs.getString("exclude_yn"));
				record[3]=checkForNull(rs.getString("qty_limit"));						
				record[4]=checkForNull(rs.getString("amt_limit"));	
				record[5]=checkForNull(rs.getString("split_allowed_yn"),"N");	//Split reqd
				record[6]=checkForNull(rs.getString("INCL_HOME_MEDICATION_YN"),"N");	//Split reqd
				record[7]=checkForNull(rs.getString("enableDisParam"),"N");	//Split reqd
				if(!cust_grp_code.equals("") && !cust_code.equals("") && !fromDate.equals("") && !pkg_serv_code.equals("")){
					if(cust_grp_code.equals(prev_cust_grp_code) && cust_code.equals(prev_cust_code) && fromDate.equals(prev_fromDate) && pkg_serv_code.equals(prev_pkg_serv_code)){
					// add to old list.
						cust_charge_srv_excl_list.add(record);							
						db_cust_charge_srv_excl_list.add(record);							
					}else{
						if(cust_charge_srv_excl_list!=null && cust_charge_srv_excl_list.size()>0){
							cust_charge_srv_excl.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),cust_charge_srv_excl_list);								
							db_cust_charge_srv_excl.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),db_cust_charge_srv_excl_list);								
						}
						cust_charge_srv_excl_list=new ArrayList();
						cust_charge_srv_excl_list.add(record);		
						db_cust_charge_srv_excl_list=new ArrayList();
						db_cust_charge_srv_excl_list.add(record);								
					}
					prev_cust_grp_code=cust_grp_code;
					prev_cust_code=cust_code;
					prev_fromDate=fromDate;
					prev_pkg_serv_code=pkg_serv_code;
				}  			
					
			}
			if(cust_charge_srv_excl_list!=null && cust_charge_srv_excl_list.size()>0){
				//System.out.println("cust_charge_srv_excl_list="+cust_charge_srv_excl_list.toString());		
				cust_charge_srv_excl.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),cust_charge_srv_excl_list);								
				db_cust_charge_srv_excl.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),db_cust_charge_srv_excl_list);								
			}
			if(cust_charge_srv_excl!=null && cust_charge_srv_excl.size()>0){
				//System.out.println("in setDBValues,cust_charge_srv_excl="+cust_charge_srv_excl.toString());
				setCustChargeSrvExcl(cust_charge_srv_excl);				
				setCustDBChargeSrvExcl(db_cust_charge_srv_excl);				
				//System.out.println("in setDBValues,bean.getCustDBChargeSrvExcl()="+((HashMap)getCustDBChargeSrvExcl()).toString());
			}
		}catch(Exception e){
			System.out.println("Exception e="+e);
			e.printStackTrace();
		}finally{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			closeConnection(connection);
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
			//System.out.println("sysDate:"+sysDate);
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
			//System.out.println("noofdecimal:"+noofdecimal);
		return noofdecimal ;

	}
	public String getGLSmryYN(String facility_id) throws Exception
	{
		Connection connection 		= getConnection();	
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		String glSmryYN = "";
		try
		{
			String sql = "select GL_POST_FOR_PKG_BY_SUMMARY_YN from  bl_parameters where operating_facility_id=?";
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1,facility_id);			
			rs = pstmt.executeQuery();
			if (rs.next())
				glSmryYN = rs.getString("GL_POST_FOR_PKG_BY_SUMMARY_YN");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception from getGLSmryYN()= :"+e);
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			closeConnection(connection);
		}
		if(glSmryYN==null) glSmryYN="";
		return glSmryYN ;
	}
	
	public String setPrevDateFromBean(String tab,String packageCode,String language_id, String operating_facility_id,
			String custGroupCode, String custCode, String effFromDate) throws Exception {
		String modified = "N";
		Connection connection 		= null;	
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;
		String sqlStr="";	
		
		String[] record;			
		String cust_grp_code="";
		String cust_code="";
		String fromDate="";
		String pkg_serv_code="";
		
		String prev_cust_grp_code="";
		String prev_cust_code="";
		String prev_fromDate="";
		String prev_pkg_serv_code="";
		try{			
			connection = getConnection();
			
			/******************* Rate Based Servcies ***********************************/
			if("CUST_RATE_BASED".equals(tab)){
			cust_grp_code="";
			cust_code="";
			fromDate="";
			prev_cust_grp_code="";
			prev_cust_code="";
			prev_fromDate="";
			ArrayList cust_rate_srv_list=new ArrayList();
			HashMap cust_rate_srv=getCustRateSrv();
				
			sqlStr ="SELECT   A.cust_group_code cust_group_code, A.cust_code cust_code,TO_CHAR (A.eff_from_date, 'dd/mm/yyyy') eff_from_date,NVL (A.close_package_yn, 'N') close_package_yn, rounding_by_integer,rounding_option, auto_refund_yn, pkg_serv_ind, pkg_serv_code,b.service_desc service_desc, A.order_catalog_code order_catalog_code,(SELECT short_desc FROM or_order_catalog_lang_vw WHERE language_id = ? AND order_catalog_code = A.order_catalog_code) order_catalog_desc,rate_ind, factor_rate, qty_limit, amt_limit_ind, amt_limit,replaceable_yn, replaceable_serv_code, (SELECT short_desc FROM bl_blng_serv_lang_vw WHERE language_id = ? AND blng_serv_code = A.replaceable_serv_code) replaceable_serv_desc,rep_serv_ord_cat_code,(SELECT short_desc FROM or_order_catalog_lang_vw WHERE language_id = ?  AND order_catalog_code = A.rep_serv_ord_cat_code)  rep_serv_ord_cat_desc,NVL (refund_yn, 'N') refund_yn, NVL(refund_rate, 0) refund_rate, NVL(A.split_allowed_yn,'N') split_allowed_yn, NVL(A.INCL_HOME_MEDICATION_YN,'N') INCL_HOME_MEDICATION_YN,bl_pharm_service_yn(language_id,pkg_serv_ind,PKG_SERV_CODE) enableDisParam, NVL (A.apply_fact_for_srv_lmt_yn, 'N') factor_appl, NVL(DAILY_AMT_LIMIT_YN,'N') DAILY_AMT_LIMIT_YN, DAILY_AMT_LIMIT, DAILY_AMT_LIMIT_GROSS_NET, NVL(DAILY_LIMIT_IND,'*') DAILY_LIMIT_IND, DAILY_QTY_LIMIT,GROUP_SERVICE_IND  FROM bl_package_coverage_for_cust A,(SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc,language_id, status FROM bl_blng_serv_lang_vw union all select 'P' serv_ind, package_serv_group_code code, short_desc service_desc, 'en', null status from bl_package_serv_group_hdr WHERE operating_facility_id = '"+operating_facility_id+"' UNION ALL  SELECT 'C' serv_ind, serv_classification_code code,short_desc service_desc, language_id, status FROM bl_serv_classification_lang_vw   UNION ALL SELECT 'G' serv_ind, serv_grp_code code, short_desc service_desc,language_id, status FROM bl_blng_serv_grp_lang_vw) b WHERE A.operating_facility_id = ? AND b.status is null AND A.package_code = ?  AND A.rate_charge_ind = 'R' AND A.pkg_serv_code = b.code AND A.pkg_serv_ind = b.serv_ind AND b.language_id = ? "+
					"and a.cust_group_code = ? and a.cust_code = ? and a.eff_from_date = (select max(c.eff_from_Date) from bl_package_cust_period c WHERE c.operating_facility_id = a.operating_facility_id  AND c.package_code = a.package_code and c.cust_group_code = a.cust_group_code and c.cust_code = a.cust_code ) "+
					"GROUP BY A.cust_group_code, A.cust_code, A.eff_from_date, NVL (A.close_package_yn, 'N'),  rounding_by_integer, rounding_option, auto_refund_yn,pkg_serv_ind,pkg_serv_code, b.service_desc,A.order_catalog_code, rate_ind,factor_rate,qty_limit, amt_limit_ind, amt_limit,replaceable_yn,       replaceable_serv_code, rep_serv_ord_cat_code,NVL (refund_yn, 'N'), NVL (refund_rate, 0), NVL(A.split_allowed_yn,'N'), NVL (A.apply_fact_for_srv_lmt_yn, 'N'),NVL (a.incl_home_medication_yn, 'N'), bl_pharm_service_yn (language_id, pkg_serv_ind, pkg_serv_code), NVL (daily_amt_limit_yn, 'N'), daily_amt_limit, daily_amt_limit_gross_net, NVL(DAILY_LIMIT_IND,'*'), DAILY_QTY_LIMIT ORDER BY 1,2,3";

			pstmt=connection.prepareStatement(sqlStr);	
			pstmt.setString(1,language_id);	
			pstmt.setString(2,language_id);	
			pstmt.setString(3,language_id);	
			pstmt.setString(4,operating_facility_id);	
			pstmt.setString(5,packageCode);				
			pstmt.setString(6,language_id);	
			pstmt.setString(7,custGroupCode);
			pstmt.setString(8,custCode);
		
			rs		= pstmt.executeQuery();
			
			while (rs!=null && rs.next()){
				record=new String[31]; //Split reqd
				cust_grp_code=custGroupCode;//rs.getString("CUST_GROUP_CODE")==null?"":rs.getString("CUST_GROUP_CODE");
				cust_code=custCode;//rs.getString("CUST_CODE")==null?"":rs.getString("CUST_CODE");
				fromDate=effFromDate;//rs.getString("EFF_FROM_DATE")==null?"":rs.getString("EFF_FROM_DATE");
				record[0]=rs.getString("pkg_serv_ind")==null?"":(rs.getString("pkg_serv_ind")).trim();
				record[1]=rs.getString("pkg_serv_code")==null?"":rs.getString("pkg_serv_code").trim();
				record[2]=rs.getString("service_desc")==null?"":rs.getString("service_desc"); 
				record[3]=checkForNull(rs.getString("order_catalog_code"));
				record[4]=checkForNull(rs.getString("order_catalog_desc"));				
				record[5]=checkForNull(rs.getString("rate_ind"));				
				record[6]=checkForNull(rs.getString("factor_rate"));		
				record[7]=checkForNull(rs.getString("qty_limit"));		
				record[8]=checkForNull(rs.getString("AMT_LIMIT_IND"));		
				record[9]=checkForNull(rs.getString("amt_limit"));		
				record[10]=checkForNull(rs.getString("replaceable_yn"));		
				record[11]=checkForNull(rs.getString("replaceable_serv_code"));		
				record[12]=checkForNull(rs.getString("replaceable_serv_desc"));		
				record[13]=checkForNull(rs.getString("rep_serv_ord_cat_code"));		
				record[14]=checkForNull(rs.getString("rep_serv_ord_cat_desc"));		
				record[15]=checkForNull(rs.getString("refund_yn"));		
				record[16]=checkForNull(rs.getString("REFUND_RATE"));		
				record[17]=checkForNull(rs.getString("AUTO_REFUND_YN"));		
				record[18]=checkForNull(rs.getString("factor_appl"));		
				record[19]=checkForNull(rs.getString("ROUNDING_BY_INTEGER"));		
				record[20]=checkForNull(rs.getString("ROUNDING_OPTION"));		
				record[21]=checkForNull(rs.getString("CLOSE_PACKAGE_YN"),"N");	
				record[22]=checkForNull(rs.getString("split_allowed_yn"),"N");
				record[23]=checkForNull(rs.getString("INCL_HOME_MEDICATION_YN"),"N");
				record[24]=checkForNull(rs.getString("enableDisParam"),"N");
				record[25]=checkForNull(rs.getString("DAILY_AMT_LIMIT_YN"),"N");//Added V190320-Aravindh/MMS-DM-CRF-0129
				record[26]=checkForNull(rs.getString("DAILY_AMT_LIMIT"));//Added V190320-Aravindh/MMS-DM-CRF-0129
				record[27]=checkForNull(rs.getString("DAILY_AMT_LIMIT_GROSS_NET"));//Added V190320-Aravindh/MMS-DM-CRF-0129
				record[28]=checkForNull(rs.getString("DAILY_LIMIT_IND"));//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				record[29]=checkForNull(rs.getString("DAILY_QTY_LIMIT"));//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				record[30]=checkForNull(rs.getString("GROUP_SERVICE_IND"));//Added V200728-Shikha/MMS-QH-CRF-0170
				if(!cust_grp_code.equals("") && !cust_code.equals("") && !fromDate.equals("")){
					if(cust_grp_code.equals(prev_cust_grp_code) && cust_code.equals(prev_cust_code) && fromDate.equals(prev_fromDate)){
					// add to old list.
						cust_rate_srv_list.add(record);													
					}else{
						if(cust_rate_srv_list!=null && cust_rate_srv_list.size()>0){
							cust_rate_srv.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim(),cust_rate_srv_list);																							
						}
						cust_rate_srv_list=new ArrayList();
						cust_rate_srv_list.add(record);							
					}
					prev_cust_grp_code=cust_grp_code;
					prev_cust_code=cust_code;
					prev_fromDate=fromDate;
				}  			
					
			}
			if(cust_rate_srv_list!=null && cust_rate_srv_list.size()>0){
				modified = "Y";
				cust_rate_srv.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim(),cust_rate_srv_list);																				
			}
			if(cust_rate_srv!=null && cust_rate_srv.size()>0){
				setCustRateSrv(cust_rate_srv);											
				//System.out.println("in setDBValues,bean.getCustDBRateSrv()="+((HashMap)getCustDBRateSrv()).toString());
			}
			}
		/******************Rate based service Exclusions*************************************************/
			if("CUST_RATE_BASED_SERV_LIMIT".equals(tab)){
			cust_grp_code="";
			cust_code="";
			fromDate="";
			pkg_serv_code="";
			prev_cust_grp_code="";
			prev_cust_code="";
			prev_fromDate="";
			prev_pkg_serv_code="";
			ArrayList cust_rate_srv_excl_list=new ArrayList();
			HashMap cust_rate_srv_excl=getCustRateSrvExcl();

			/*if(!copyFrm_pkgCode.equals("")){
				sqlStr ="SELECT  a.cust_group_code cust_group_code,a.cust_code cust_code,to_char(a.eff_from_date,'dd/mm/yyyy') eff_from_date,a.PKG_SERV_CODE pkg_serv_code,a.excl_serv_ind excl_serv_ind,a.excl_serv_code excl_serv_code, b.service_desc service_desc,a.exclude_yn exclude_yn, qty_limit, amt_limit,a.apply_fact_for_srv_lmt_yn factor_appl,AMT_LIMIT_IND, REPLACEABLE_YN, REPLACEABLE_SERV_CODE,(SELECT long_desc FROM bl_blng_serv_lang_vw  WHERE blng_serv_code = A.replaceable_serv_code AND language_id = ?) REPLACEABLE_SERV_DESC, REFUND_YN, REFUND_RATE, ROUNDING_BY_INTEGER, ROUNDING_OPTION, AUTO_REFUND_YN FROM BL_PACKAGE_EXCL_FOR_CUST a, (select 'S' Serv_Ind, blng_serv_code code, short_desc service_desc,language_id from BL_BLNG_SERV_lang_vw  union all  select 'C' serv_ind, serv_classification_code code, short_desc service_desc,language_id from BL_SERV_CLASSIFICATION_lang_vw ) b WHERE a.operating_facility_id = ?   AND a.package_code =? AND a.rate_charge_ind = 'R'  and  a.excl_serv_code=b.code  AND a.excl_serv_ind=b.Serv_Ind AND b.language_id=? ANd a.eff_from_date = (select max(c.eff_from_Date) from BL_PACKAGE_EXCL_FOR_CUST c WHERE c.operating_facility_id = a.operating_facility_id  AND c.package_code = a.package_code ANd c.cust_group_code=a.cust_group_code AND c.cust_code=a.cust_code) order by 1,2,3";
			}else{*/
			//Changes done 		

			sqlStr ="SELECT  a.cust_group_code cust_group_code,a.cust_code cust_code,to_char(a.eff_from_date,'dd/mm/yyyy') eff_from_date,a.PKG_SERV_CODE pkg_serv_code,a.excl_serv_ind excl_serv_ind,a.excl_serv_code excl_serv_code, b.service_desc service_desc,a.exclude_yn exclude_yn, qty_limit, amt_limit,a.apply_fact_for_srv_lmt_yn factor_appl,AMT_LIMIT_IND, REPLACEABLE_YN, REPLACEABLE_SERV_CODE,(SELECT long_desc FROM bl_blng_serv_lang_vw  WHERE blng_serv_code = A.replaceable_serv_code AND language_id = ?) REPLACEABLE_SERV_DESC, REFUND_YN, REFUND_RATE, ROUNDING_BY_INTEGER, ROUNDING_OPTION, a.split_allowed_yn,a.INCL_HOME_MEDICATION_YN,bl_pharm_service_yn(language_id,EXCL_SERV_IND,excl_serv_code) enableDisParam, AUTO_REFUND_YN, NVL(DAILY_AMT_LIMIT_YN,'N') DAILY_AMT_LIMIT_YN, DAILY_AMT_LIMIT, DAILY_AMT_LIMIT_GROSS_NET, NVL(DAILY_LIMIT_IND,'*') DAILY_LIMIT_IND, DAILY_QTY_LIMIT FROM BL_PACKAGE_EXCL_FOR_CUST a, (select 'S' Serv_Ind, blng_serv_code code, short_desc service_desc,language_id from BL_BLNG_SERV_lang_vw  union all select 'P' serv_ind, package_serv_group_code code, short_desc service_desc, 'en' from bl_package_serv_group_hdr WHERE operating_facility_id = '"+operating_facility_id+"' union all select 'T' serv_ind, sale_category_code code, short_desc service_desc, 'en' from bl_st_item_sale_catg_hdr union all select 'G' serv_ind, serv_grp_code code, short_desc description, language_id from bl_blng_serv_grp_lang_vw union all  select 'C' serv_ind, serv_classification_code code, short_desc service_desc,language_id from BL_SERV_CLASSIFICATION_lang_vw union all select 'M' serv_ind, item_code code, short_desc service_desc,language_id from MM_ITem_lang_vw ) b WHERE a.operating_facility_id = ?   AND a.package_code =? and  a.excl_serv_code=b.code  AND a.excl_serv_ind=b.Serv_Ind AND b.language_id=? "+
					"and a.cust_group_code = ? and a.cust_code = ? and a.eff_from_date = (select max(c.eff_from_Date) from bl_package_cust_period c WHERE c.operating_facility_id = a.operating_facility_id  AND c.package_code = a.package_code and c.cust_group_code = a.cust_group_code and c.cust_code = a.cust_code ) "+
					"GROUP BY A.cust_group_code , A.cust_code ,eff_from_date,A.pkg_serv_code ,A.excl_serv_ind ,A.excl_serv_code , b.service_desc ,A.exclude_yn, qty_limit,amt_limit,A.apply_fact_for_srv_lmt_yn ,amt_limit_ind,replaceable_yn,replaceable_serv_code, refund_yn, refund_rate, rounding_by_integer,  rounding_option, a.split_allowed_yn, a.incl_home_medication_yn, bl_pharm_service_yn (language_id,excl_serv_ind,excl_serv_code), auto_refund_yn, NVL(DAILY_AMT_LIMIT_YN,'N'), DAILY_AMT_LIMIT, DAILY_AMT_LIMIT_GROSS_NET, NVL(DAILY_LIMIT_IND,'*'), DAILY_QTY_LIMIT order by 1,2,4,3";
			//sqlStr ="SELECT  a.cust_group_code cust_group_code,a.cust_code cust_code,to_char(a.eff_from_date,'dd/mm/yyyy') eff_from_date,a.PKG_SERV_CODE pkg_serv_code,a.excl_serv_ind excl_serv_ind,a.excl_serv_code excl_serv_code, b.service_desc service_desc,a.exclude_yn exclude_yn, qty_limit, amt_limit,a.apply_fact_for_srv_lmt_yn factor_appl,AMT_LIMIT_IND, REPLACEABLE_YN, REPLACEABLE_SERV_CODE,(SELECT long_desc FROM bl_blng_serv_lang_vw  WHERE blng_serv_code = A.replaceable_serv_code AND language_id = ?) REPLACEABLE_SERV_DESC, REFUND_YN, REFUND_RATE, ROUNDING_BY_INTEGER, ROUNDING_OPTION, AUTO_REFUND_YN FROM BL_PACKAGE_EXCL_FOR_CUST a, (select 'S' Serv_Ind, blng_serv_code code, short_desc service_desc,language_id from BL_BLNG_SERV_lang_vw  union all  select 'C' serv_ind, serv_classification_code code, short_desc service_desc,language_id from BL_SERV_CLASSIFICATION_lang_vw ) b WHERE a.operating_facility_id = ?   AND a.package_code =? AND a.rate_charge_ind = 'R'  and  a.excl_serv_code=b.code  AND a.excl_serv_ind=b.Serv_Ind AND b.language_id=? GROUP BY A.cust_group_code , A.cust_code ,eff_from_date,A.pkg_serv_code ,A.excl_serv_ind ,A.excl_serv_code , b.service_desc ,A.exclude_yn, qty_limit,amt_limit,A.apply_fact_for_srv_lmt_yn ,amt_limit_ind,replaceable_yn,replaceable_serv_code, refund_yn, refund_rate, rounding_by_integer,  rounding_option, auto_refund_yn order by 1,2,3";


			/*Commented by muthu for testing on 5/25/2012 above query rate_charge_ind & order By is Changed				sqlStr ="SELECT  a.cust_group_code cust_group_code,a.cust_code cust_code,to_char(a.eff_from_date,'dd/mm/yyyy') eff_from_date,a.PKG_SERV_CODE pkg_serv_code,a.excl_serv_ind excl_serv_ind,a.excl_serv_code excl_serv_code, b.service_desc service_desc,a.exclude_yn exclude_yn, qty_limit, amt_limit,a.apply_fact_for_srv_lmt_yn factor_appl,AMT_LIMIT_IND, REPLACEABLE_YN, REPLACEABLE_SERV_CODE,(SELECT long_desc FROM bl_blng_serv_lang_vw  WHERE blng_serv_code = A.replaceable_serv_code AND language_id = ?) REPLACEABLE_SERV_DESC, REFUND_YN, REFUND_RATE, ROUNDING_BY_INTEGER, ROUNDING_OPTION, AUTO_REFUND_YN FROM BL_PACKAGE_EXCL_FOR_CUST a, (select 'S' Serv_Ind, blng_serv_code code, short_desc service_desc,language_id from BL_BLNG_SERV_lang_vw  union all select 'P' serv_ind, package_serv_group_code code, short_desc service_desc, 'en' from bl_package_serv_group_hdr union all select 'T' serv_ind, sale_category_code code, short_desc service_desc, 'en' from bl_st_item_sale_catg_hdr union all select 'G' serv_ind, serv_grp_code code, short_desc description, language_id from bl_blng_serv_grp_lang_vw union all  select 'C' serv_ind, serv_classification_code code, short_desc service_desc,language_id from BL_SERV_CLASSIFICATION_lang_vw union all select 'M' serv_ind, item_code code, short_desc service_desc,language_id from MM_ITem_lang_vw ) b WHERE a.operating_facility_id = ?   AND a.package_code =? AND a.rate_charge_ind = 'R'  and  a.excl_serv_code=b.code  AND a.excl_serv_ind=b.Serv_Ind AND b.language_id=? GROUP BY A.cust_group_code , A.cust_code ,eff_from_date,A.pkg_serv_code ,A.excl_serv_ind ,A.excl_serv_code , b.service_desc ,A.exclude_yn, qty_limit,amt_limit,A.apply_fact_for_srv_lmt_yn ,amt_limit_ind,replaceable_yn,replaceable_serv_code, refund_yn, refund_rate, rounding_by_integer,  rounding_option, auto_refund_yn order by 1,2,3";*/

		//	}
					//System.out.println("674 in setDBValues,sqlStr="+sqlStr);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
				
			pstmt=connection.prepareStatement(sqlStr);			
			pstmt.setString(1,language_id);		
			pstmt.setString(2,operating_facility_id);		
			pstmt.setString(3,packageCode);
			pstmt.setString(4,language_id);
			pstmt.setString(5,custGroupCode);
			pstmt.setString(6,custCode);
					
			rs		= pstmt.executeQuery();
			
			while (rs!=null && rs.next()){
				record=new String[24];//Split reqd
				cust_grp_code= custGroupCode; //rs.getString("cust_group_code")==null?"":rs.getString("cust_group_code");
				cust_code= custCode;//rs.getString("cust_code")==null?"":rs.getString("cust_code");
				fromDate=effFromDate;//rs.getString("eff_from_date")==null?"":rs.getString("eff_from_date");
				pkg_serv_code=rs.getString("pkg_serv_code")==null?"":rs.getString("pkg_serv_code");
				record[0]=rs.getString("excl_serv_ind")==null?"":(rs.getString("excl_serv_ind")).trim();
				record[1]=rs.getString("excl_serv_code")==null?"":rs.getString("excl_serv_code").trim();
				record[2]=rs.getString("service_desc")==null?"":rs.getString("service_desc"); 
				record[3]=checkForNull(rs.getString("exclude_yn"));
				record[4]=checkForNull(rs.getString("qty_limit"));				
				record[5]=checkForNull(rs.getString("AMT_LIMIT_IND"));				
				record[6]=checkForNull(rs.getString("amt_limit"));				
				record[7]=checkForNull(rs.getString("ROUNDING_BY_INTEGER"));		
				record[8]=checkForNull(rs.getString("ROUNDING_OPTION"));		
				record[9]=checkForNull(rs.getString("REPLACEABLE_YN"));		
				record[10]=checkForNull(rs.getString("REPLACEABLE_SERV_CODE"));		
				record[11]=checkForNull(rs.getString("REPLACEABLE_SERV_DESC"));		
				record[12]=checkForNull(rs.getString("REFUND_YN"));		
				record[13]=checkForNull(rs.getString("REFUND_RATE"));		
				record[14]=checkForNull(rs.getString("AUTO_REFUND_YN"));		
				record[15]=checkForNull(rs.getString("factor_appl"));	
				record[16]=checkForNull(rs.getString("split_allowed_yn"),"N");//Split reqd
				record[17]=checkForNull(rs.getString("INCL_HOME_MEDICATION_YN"),"N");//Split reqd
				record[18]=checkForNull(rs.getString("enableDisParam"),"N");//Split reqd
				record[19]=checkForNull(rs.getString("DAILY_AMT_LIMIT_YN"),"N");//Added V190320-Aravindh/MMS-DM-CRF-0129
				record[20]=checkForNull(rs.getString("DAILY_AMT_LIMIT"));//Added V190320-Aravindh/MMS-DM-CRF-0129
				record[21]=checkForNull(rs.getString("DAILY_AMT_LIMIT_GROSS_NET"));//Added V190320-Aravindh/MMS-DM-CRF-0129
				record[22]=checkForNull(rs.getString("DAILY_LIMIT_IND"));//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				record[23]=checkForNull(rs.getString("DAILY_QTY_LIMIT"));//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				
				if(!cust_grp_code.equals("") && !cust_code.equals("") && !fromDate.equals("") && !pkg_serv_code.equals("")){

				if(cust_grp_code.equals(prev_cust_grp_code) && cust_code.equals(prev_cust_code) && fromDate.equals(prev_fromDate) && pkg_serv_code.equals(prev_pkg_serv_code)){ 
					// add to old list.
						cust_rate_srv_excl_list.add(record);												
					}else{

						if(cust_rate_srv_excl_list!=null && cust_rate_srv_excl_list.size()>0){
							cust_rate_srv_excl.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),cust_rate_srv_excl_list);								
						}
						cust_rate_srv_excl_list=new ArrayList();
						cust_rate_srv_excl_list.add(record);						
					}
					prev_cust_grp_code=cust_grp_code;
					prev_cust_code=cust_code;
					prev_fromDate=fromDate;
					prev_pkg_serv_code=pkg_serv_code;
				}  
					
			}
			if(cust_rate_srv_excl_list!=null && cust_rate_srv_excl_list.size()>0){
				modified = "Y";
				cust_rate_srv_excl.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),cust_rate_srv_excl_list);								
			
			

			}
			if(cust_rate_srv_excl!=null && cust_rate_srv_excl.size()>0){
				setCustRateSrvExcl(cust_rate_srv_excl);				
			}
			}
			
			/******************* Charge Based Servcies ***********************************/
			if("CUST_CHARGE_BASED".equals(tab)){
			cust_grp_code="";
			cust_code="";
			fromDate="";
			prev_cust_grp_code="";
			prev_cust_code="";
			prev_fromDate="";
			ArrayList cust_charge_srv_list=new ArrayList();
			HashMap cust_charge_srv=getCustChargeSrv();
		/*	if(!copyFrm_pkgCode.equals("")){
				sqlStr ="SELECT A.cust_group_code cust_group_code, A.cust_code cust_code,TO_CHAR (A.eff_from_date, 'dd/mm/yyyy') eff_from_date,pkg_serv_code, b.short_desc service_desc,amt_limit_ind, amt_limit,rounding_by_integer,rounding_option,NVL (refund_yn, 'N') refund_yn,NVL(refund_rate, 0) refund_rate,auto_refund_yn,NVL (A.apply_fact_for_srv_lmt_yn, 'N') factor_appl FROM bl_package_coverage_for_cust a, bl_blng_serv_lang_vw b WHERE a.operating_facility_id = ?  AND a.package_code = ?  AND a.rate_charge_ind = 'C'   AND a.pkg_serv_code =b.blng_serv_code AND b.language_id = ? ANd a.eff_from_date = (select max(c.eff_from_Date) from bl_package_coverage_for_cust c WHERE c.operating_facility_id = a.operating_facility_id  AND c.package_code = a.package_code ANd c.cust_group_code=a.cust_group_code AND c.cust_code=a.cust_code) order by 1,2,3";
			}else{*/
				//sqlStr ="SELECT A.cust_group_code cust_group_code, A.cust_code cust_code,TO_CHAR (A.eff_from_date, 'dd/mm/yyyy') eff_from_date,pkg_serv_code, b.short_desc service_desc,amt_limit_ind, amt_limit,rounding_by_integer,rounding_option,NVL (refund_yn, 'N') refund_yn,NVL(refund_rate, 0) refund_rate,auto_refund_yn,NVL (A.apply_fact_for_srv_lmt_yn, 'N') factor_appl FROM bl_package_coverage_for_cust a, bl_blng_serv_lang_vw b WHERE a.operating_facility_id = ?  AND a.package_code = ?  AND a.rate_charge_ind = 'C'   AND a.pkg_serv_code =b.blng_serv_code AND b.language_id = ? GROUP BY A.cust_group_code, A.cust_code, A.eff_from_date, pkg_serv_code, b.short_desc, amt_limit_ind, amt_limit,rounding_by_integer, rounding_option, NVL (refund_yn, 'N'), NVL (refund_rate, 0),auto_refund_yn,NVL (A.apply_fact_for_srv_lmt_yn, 'N') ORDER BY 1,2,3";
				//sqlStr ="SELECT a.cust_group_code cust_group_code, a.cust_code cust_code,TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date , pkg_serv_ind, pkg_serv_code,  b.service_desc service_desc, amt_limit_ind, amt_limit,rounding_by_integer, rounding_option, NVL (refund_yn, 'N') refund_yn, NVL (refund_rate, 0) refund_rate, auto_refund_yn,NVL (a.apply_fact_for_srv_lmt_yn, 'N') factor_appl FROM bl_package_coverage_for_cust a, (SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc,language_id FROM bl_blng_serv_lang_vw UNION ALL SELECT 'M' serv_ind, item_code code, short_desc service_desc,language_id FROM mm_item_lang_vw) b WHERE a.operating_facility_id = ? AND a.package_code = ?  AND a.rate_charge_ind = 'C' AND a.pkg_serv_code = b.code  and a.pkg_serv_ind = b.serv_ind AND b.language_id = ? GROUP BY a.cust_group_code, a.cust_code, a.eff_from_date,  pkg_serv_ind, pkg_serv_code, b.service_desc, amt_limit_ind, amt_limit, rounding_by_integer, rounding_option, NVL (refund_yn, 'N'), NVL (refund_rate, 0), auto_refund_yn, NVL (a.apply_fact_for_srv_lmt_yn, 'N') ORDER BY 1,2,3";
				sqlStr ="SELECT   a.cust_group_code cust_group_code, a.cust_code cust_code, TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date, pkg_serv_ind,pkg_serv_code, b.service_desc service_desc, amt_limit_ind, amt_limit,rounding_by_integer, rounding_option, NVL (refund_yn, 'N') refund_yn, NVL (refund_rate, 0) refund_rate, auto_refund_yn,NVL (a.apply_fact_for_srv_lmt_yn, 'N') factor_appl,  NVL(A.split_allowed_yn,'N') split_allowed_yn, NVL(A.INCL_HOME_MEDICATION_YN,'N') INCL_HOME_MEDICATION_YN,bl_pharm_service_yn(language_id,EXCL_SERV_IND,excl_serv_code) enableDisParam,(SELECt 'Y' FROM BL_PACKAGE_EXCL_FOR_CUST c WHERE c.operating_facility_id = a.operating_facility_id AND c.package_code = a.package_code AND c.pkg_serv_code = a.pkg_serv_code	AND c.pkg_serv_ind = a.pkg_serv_ind AND ROWNUM = 1) service_limit,GROUP_SERVICE_IND FROM bl_package_coverage_for_cust a, (SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc, language_id, status FROM bl_blng_serv_lang_vw UNION ALL SELECT 'M' serv_ind, item_code code, short_desc service_desc, language_id, null status FROM mm_item_lang_vw) b WHERE a.operating_facility_id = ? AND b.status is null AND a.package_code = ? AND a.rate_charge_ind = 'C' AND a.pkg_serv_code = b.code AND a.pkg_serv_ind = b.serv_ind AND b.language_id = ? "+
						"and a.cust_group_code = ? and a.cust_code = ? and a.eff_from_date = (select max(c.eff_from_Date) from bl_package_cust_period c WHERE c.operating_facility_id = a.operating_facility_id  AND c.package_code = a.package_code and c.cust_group_code = a.cust_group_code and c.cust_code = a.cust_code ) "+
						"ORDER BY 1, 2, 3";
			//}		
			//System.out.println("756 in setDBValues,sqlStr="+sqlStr);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();				
			pstmt=connection.prepareStatement(sqlStr);	
			pstmt.setString(1,operating_facility_id);	
			pstmt.setString(2,packageCode);
			pstmt.setString(3,language_id);	
			pstmt.setString(4,custGroupCode);
			pstmt.setString(5,custCode);
			rs		= pstmt.executeQuery();			
			while (rs!=null && rs.next()){
				record=new String[15];//Aplit reqd
//				record=new String[11];//MuthuN against 28192
				//record=new String[10];
				cust_grp_code=custGroupCode;//rs.getString("cust_group_code")==null?"":rs.getString("cust_group_code");
				cust_code=custCode;//rs.getString("cust_code")==null?"":rs.getString("cust_code");
				fromDate=effFromDate;//rs.getString("eff_from_date")==null?"":rs.getString("eff_from_date");
				record[0]=rs.getString("pkg_serv_ind")==null?"":rs.getString("pkg_serv_ind").trim();//MuthuN against 28192
				//record[0]=rs.getString("pkg_serv_code")==null?"":rs.getString("pkg_serv_code").trim();//MuthuN against 28192
				record[1]=rs.getString("pkg_serv_code")==null?"":rs.getString("pkg_serv_code").trim();	
				record[2]=rs.getString("service_desc")==null?"":rs.getString("service_desc"); 
				record[3]=checkForNull(rs.getString("amt_limit_ind"));
				record[4]=checkForNull(rs.getString("amt_limit"));				
				record[5]=checkForNull(rs.getString("rounding_by_integer"));				
				record[6]=checkForNull(rs.getString("rounding_option"));		
				record[7]=checkForNull(rs.getString("refund_yn"));		
				record[8]=checkForNull(rs.getString("refund_rate"));		
				record[9]=checkForNull(rs.getString("auto_refund_yn"));		
				record[10]=checkForNull(rs.getString("factor_appl"));
				record[11]=checkForNull(rs.getString("service_limit"));
				record[12]=checkForNull(rs.getString("split_allowed_yn"));//Split reqd
				record[13]=checkForNull(rs.getString("INCL_HOME_MEDICATION_YN"));//Split reqd
				record[14]=checkForNull(rs.getString("enableDisParam"));//Split reqd
				/*record[0]=rs.getString("pkg_serv_code")==null?"":rs.getString("pkg_serv_code").trim();
				record[1]=rs.getString("service_desc")==null?"":rs.getString("service_desc"); 
				record[2]=checkForNull(rs.getString("amt_limit_ind"));
				record[3]=checkForNull(rs.getString("amt_limit"));				
				record[4]=checkForNull(rs.getString("rounding_by_integer"));				
				record[5]=checkForNull(rs.getString("rounding_option"));		
				record[6]=checkForNull(rs.getString("refund_yn"));		
				record[7]=checkForNull(rs.getString("refund_rate"));		
				record[8]=checkForNull(rs.getString("auto_refund_yn"));		
				record[9]=checkForNull(rs.getString("factor_appl"));*/	
				if(!cust_grp_code.equals("") && !cust_code.equals("") && !fromDate.equals("")){
					if(cust_grp_code.equals(prev_cust_grp_code) && cust_code.equals(prev_cust_code) && fromDate.equals(prev_fromDate)){
					// add to old list.
						cust_charge_srv_list.add(record);													
					}else{
						if(cust_charge_srv_list!=null && cust_charge_srv_list.size()>0){
							//System.out.println("cust_charge_srv_list="+cust_charge_srv_list.toString());		
							cust_charge_srv.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim(),cust_charge_srv_list);								
						}
						cust_charge_srv_list=new ArrayList();
						cust_charge_srv_list.add(record);								
					}
					prev_cust_grp_code=cust_grp_code;
					prev_cust_code=cust_code;
					prev_fromDate=fromDate;
				}  			
					
			}
			if(cust_charge_srv_list!=null && cust_charge_srv_list.size()>0){
				//System.out.println("cust_charge_srv_list="+cust_charge_srv_list.toString());		
				modified = "Y";
				cust_charge_srv.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim(),cust_charge_srv_list);								
			}
			if(cust_charge_srv!=null && cust_charge_srv.size()>0){
				setCustChargeSrv(cust_charge_srv);				
				//System.out.println("in setDBValues,bean.getCustDBChargeSrv()="+((HashMap)getCustDBChargeSrv()).toString());
			}
			}
				/******************Charge based service Exclusions*************************************************/
			if("CUST_CHARGE_BASED_SERV_LIMIT".equals(tab)){
			cust_grp_code="";
			cust_code="";
			fromDate="";
			pkg_serv_code="";
			prev_cust_grp_code="";
			prev_cust_code="";
			prev_fromDate="";
			prev_pkg_serv_code="";
			ArrayList cust_charge_srv_excl_list=new ArrayList();
			HashMap cust_charge_srv_excl=getCustChargeSrvExcl();
		/*	if(!copyFrm_pkgCode.equals("")){
				sqlStr ="SSELECT  a.cust_group_code cust_group_code,a.cust_code cust_code,to_char(a.eff_from_date,'dd/mm/yyyy') eff_from_date,a.pkg_serv_code pkg_serv_code,a.excl_serv_code excl_serv_code, b.short_desc service_desc,a.exclude_yn exclude_yn, qty_limit, amt_limit FROM BL_PACKAGE_EXCL_FOR_CUST a, mm_item_lang_vw b WHERE a.operating_facility_id = ?   AND a.package_code =? AND a.rate_charge_ind = 'C'  and  a.excl_serv_code=b.item_code  AND b.language_id=? ANd a.eff_from_date = (select max(c.eff_from_Date) from BL_PACKAGE_EXCL_FOR_CUST c WHERE c.operating_facility_id = a.operating_facility_id  AND c.package_code = a.package_code ANd c.cust_group_code=a.cust_group_code AND c.cust_code=a.cust_code) order by 1,2,3";
			}else{*/
			sqlStr ="SELECT  a.cust_group_code cust_group_code,a.cust_code cust_code,to_char(a.eff_from_date,'dd/mm/yyyy') eff_from_date,a.pkg_serv_code pkg_serv_code,a.excl_serv_code excl_serv_code, b.short_desc service_desc,a.exclude_yn exclude_yn, qty_limit, a.split_allowed_yn,a.INCL_HOME_MEDICATION_YN,bl_pharm_service_yn(language_id,EXCL_SERV_IND,excl_serv_code) enableDisParam, amt_limit FROM BL_PACKAGE_EXCL_FOR_CUST a, mm_item_lang_vw b WHERE a.operating_facility_id = ?   AND a.package_code =? AND a.rate_charge_ind = 'C'  and  a.excl_serv_code=b.item_code  AND b.language_id=? "+
					"and a.cust_group_code = ? and a.cust_code = ? and a.eff_from_date = (select max(c.eff_from_Date) from bl_package_cust_period c WHERE c.operating_facility_id = a.operating_facility_id  AND c.package_code = a.package_code and c.cust_group_code = a.cust_group_code and c.cust_code = a.cust_code ) "+
					"GROUP BY a.cust_group_code , a.cust_code ,eff_from_date,a.pkg_serv_code ,a.excl_serv_code , b.short_desc ,a.exclude_yn, qty_limit, a.split_allowed_yn,amt_limit order by 1,2,3";
		//	}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
				
			pstmt=connection.prepareStatement(sqlStr);			
			pstmt.setString(1,operating_facility_id);
			pstmt.setString(2,packageCode);								
			
			pstmt.setString(3,language_id);	
			pstmt.setString(4,custGroupCode);
			pstmt.setString(5,custCode);
					
			rs		= pstmt.executeQuery();
			
			while (rs!=null && rs.next()){
				record=new String[8];//Split reqd
				cust_grp_code=custGroupCode;//rs.getString("cust_group_code")==null?"":rs.getString("cust_group_code");
				cust_code=custCode;//rs.getString("cust_code")==null?"":rs.getString("cust_code");
				fromDate=effFromDate;//rs.getString("eff_from_date")==null?"":rs.getString("eff_from_date");
				pkg_serv_code=rs.getString("pkg_serv_code")==null?"":rs.getString("pkg_serv_code");
				record[0]=rs.getString("excl_serv_code")==null?"":rs.getString("excl_serv_code").trim();
				record[1]=rs.getString("service_desc")==null?"":rs.getString("service_desc"); 
				record[2]=checkForNull(rs.getString("exclude_yn"));
				record[3]=checkForNull(rs.getString("qty_limit"));						
				record[4]=checkForNull(rs.getString("amt_limit"));	
				record[5]=checkForNull(rs.getString("split_allowed_yn"),"N");	//Split reqd
				record[6]=checkForNull(rs.getString("INCL_HOME_MEDICATION_YN"),"N");	//Split reqd
				record[7]=checkForNull(rs.getString("enableDisParam"),"N");	//Split reqd
				if(!cust_grp_code.equals("") && !cust_code.equals("") && !fromDate.equals("") && !pkg_serv_code.equals("")){
					if(cust_grp_code.equals(prev_cust_grp_code) && cust_code.equals(prev_cust_code) && fromDate.equals(prev_fromDate) && pkg_serv_code.equals(prev_pkg_serv_code)){
					// add to old list.
						cust_charge_srv_excl_list.add(record);												
					}else{
						if(cust_charge_srv_excl_list!=null && cust_charge_srv_excl_list.size()>0){
							cust_charge_srv_excl.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),cust_charge_srv_excl_list);								
						}
						cust_charge_srv_excl_list=new ArrayList();
						cust_charge_srv_excl_list.add(record);									
					}
					prev_cust_grp_code=cust_grp_code;
					prev_cust_code=cust_code;
					prev_fromDate=fromDate;
					prev_pkg_serv_code=pkg_serv_code;
				}  			
					
			}
			if(cust_charge_srv_excl_list!=null && cust_charge_srv_excl_list.size()>0){
				//System.out.println("cust_charge_srv_excl_list="+cust_charge_srv_excl_list.toString());	
				modified = "Y";
				cust_charge_srv_excl.put(prev_cust_grp_code.trim()+"~~"+prev_cust_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),cust_charge_srv_excl_list);								
			}
			if(cust_charge_srv_excl!=null && cust_charge_srv_excl.size()>0){
				//System.out.println("in setDBValues,cust_charge_srv_excl="+cust_charge_srv_excl.toString());
				setCustChargeSrvExcl(cust_charge_srv_excl);							
				//System.out.println("in setDBValues,bean.getCustDBChargeSrvExcl()="+((HashMap)getCustDBChargeSrvExcl()).toString());
			}
			}
				
			
		}catch(Exception e){
			System.out.println("Exception e="+e);
			e.printStackTrace();
		}finally{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			closeConnection(connection);
		}
		return modified;
	}
	
	
	public Set<String> getPackageCustPeriod(String facilityId, String packageCode){
		Set<String> custPeriodSet = new HashSet<String>();
		Connection con = null;
		ResultSet rst = null;
		PreparedStatement pstmt = null;
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement("Select cust_group_code,cust_code,TO_CHAR(EFF_FROM_DATE,'DD/MM/YYYY') eff_from_date from bl_package_cust_period where operating_facility_id = ? and package_code = ?");
			pstmt.setString(1, facilityId);
			pstmt.setString(2, packageCode);
			
			rst = pstmt.executeQuery();
			if(rst != null ){
				while(rst.next()){
					custPeriodSet.add(rst.getString("cust_group_code")+"~~"+
							rst.getString("cust_code")+"~~"+
							rst.getString("eff_from_date"));
				}				
			}
		}
		catch(Exception e){
			e.printStackTrace();			
		}
		finally{
			//pstmt = null;
			//rst = null;
			//Added against V210416 starts
			try{
				ConnectionManager.returnConnection(con);
			if(pstmt!=null) pstmt.close();
			if(rst!=null) rst.close();
			}
			catch(Exception e)
			{
				System.out.println("exception in getPackageCustPeriod:"+e);
				e.printStackTrace();
			}
			//Added against V210416 ends
		}
		return custPeriodSet;
	}
}
