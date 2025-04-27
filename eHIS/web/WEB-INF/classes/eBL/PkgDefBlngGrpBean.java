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
2			 V211130			 26231			KDAH-SCF-0744-TF			Mohanapriya K
 */
package eBL;
import java.io.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eBL.Common.*;

@SuppressWarnings({"rawtypes","unchecked"})
public class PkgDefBlngGrpBean extends BlAdapter implements Serializable {
	HashMap blng_grp_dtls = new HashMap();// for Blng grp dtls
	HashMap blng_grp_period=new HashMap();// for period dtls
	
	HashMap blng_grp_base_price=new HashMap();// for rate based services dtls
	
	HashMap blng_grp_rate_srv=new HashMap();// for rate based services dtls
	HashMap blng_grp_rate_srv_excl=new HashMap();// for rate based services dtls
	
	HashMap blng_grp_charge_srv=new HashMap();// for rate based services dtls
	HashMap blng_grp_charge_srv_excl=new HashMap();// for rate based services dtls
	
	HashMap db_blng_grp_dtls=new HashMap();// for billing group dtls
	HashMap db_blng_grp_period=new HashMap();// for period dtls
	
	HashMap db_blng_grp_base_price=new HashMap();// for rate based services dtls
	
	HashMap db_blng_grp_rate_srv=new HashMap();// for rate based services dtls
	HashMap db_blng_grp_rate_srv_excl=new HashMap();// for rate based services dtls
	
	HashMap db_blng_grp_charge_srv=new HashMap();// for rate based services dtls
	HashMap db_blng_grp_charge_srv_excl=new HashMap();// for rate based services dtls
	
	protected String modify_blng_grp_base_price			= "N";
	protected String modify_blng_grp_rate_srv			= "N";
	protected String modify_blng_grp_rate_srv_excl		= "N";
	protected String modify_blng_grp_charge_srv			= "N";
	protected String modify_blng_grp_charge_srv_excl			= "N";
	protected String modify_blng_grp			= "N";
	protected String modify_blng_grp_period			= "N";
	
	public PkgDefBlngGrpBean()
	{	
		System.out.println("PkgDefBlngGrpBean Bean Initialized");
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
		blng_grp_dtls=new HashMap();
		blng_grp_period=new HashMap();
		blng_grp_base_price=new HashMap();
		blng_grp_rate_srv=new HashMap();
		blng_grp_rate_srv_excl=new HashMap();
		blng_grp_charge_srv=new HashMap();
		db_blng_grp_charge_srv_excl=new HashMap();
		db_blng_grp_dtls=new HashMap();
		db_blng_grp_period=new HashMap();
		db_blng_grp_base_price=new HashMap();
		db_blng_grp_rate_srv=new HashMap();
		db_blng_grp_rate_srv_excl=new HashMap();
		db_blng_grp_charge_srv=new HashMap();
		db_blng_grp_charge_srv_excl=new HashMap();
		modify_blng_grp_base_price			= "N";
		modify_blng_grp_rate_srv			= "N";
		modify_blng_grp_rate_srv_excl		= "N";
		modify_blng_grp_charge_srv			= "N";
		modify_blng_grp_charge_srv_excl			= "N";
		modify_blng_grp			= "N";
		modify_blng_grp_period			= "N";
	}
	
	public HashMap getBlngGrpDtls(){
		return this.blng_grp_dtls;
	}
	
	public void setBlngGrpDtls(HashMap blng_grp_dtls) {		
		 this.blng_grp_dtls=blng_grp_dtls;
	}
    	
	public HashMap getBlngGrpPeriod(){
		return this.blng_grp_period;
	}
	
	public void setBlngGrpPeriod(HashMap blng_grp_period){
		 this.blng_grp_period=blng_grp_period;
	}
	
	public HashMap getBlngGrpBasePrice(){
		return this.blng_grp_base_price;
	}
	
	public void setBlngGrpBasePrice(HashMap blng_grp_base_price){
		 this.blng_grp_base_price=blng_grp_base_price;
	}
	
	public HashMap getBlngGrpRateSrv(){
		return this.blng_grp_rate_srv;
	}
	
	public void setBlngGrpRateSrv(HashMap blng_grp_rate_srv){
		 this.blng_grp_rate_srv=blng_grp_rate_srv;
	}

	public HashMap getBlngGrpRateSrvExcl(){
		return this.blng_grp_rate_srv_excl;
	}
	
	public void setBlngGrpRateSrvExcl(HashMap blng_grp_rate_srv_excl){
		 this.blng_grp_rate_srv_excl=blng_grp_rate_srv_excl;
	}
	
	public HashMap getBlngGrpChargeSrv(){
		return this.blng_grp_charge_srv;
	}
	
	public void setBlngGrpChargeSrv(HashMap blng_grp_charge_srv){
		 this.blng_grp_charge_srv=blng_grp_charge_srv;
	}

	public HashMap getBlngGrpChargeSrvExcl(){
		return this.db_blng_grp_charge_srv_excl;
	}
	
	public void setBlngGrpChargeSrvExcl(HashMap blng_grp_charge_srv_excl){
		 this.db_blng_grp_charge_srv_excl=blng_grp_charge_srv_excl;
	}	
	
	public HashMap getBlnggrpDBDtls(){
		return this.db_blng_grp_dtls;
	}
	
		public void setBlnggrpDBDtls(HashMap db_blng_grp_dtls){
		 this.db_blng_grp_dtls=db_blng_grp_dtls;
	}
	public HashMap getBlngGrpDBPeriod(){
		return this.db_blng_grp_period;
	}
	
	public void setBlngGrpDBPeriod(HashMap db_blng_grp_period){
		 this.db_blng_grp_period=db_blng_grp_period;
	}
	
	public HashMap getBlngGrpDBBasePrice(){
		return this.db_blng_grp_base_price;
	}
	
	public void setBlngGrpDBBasePrice(HashMap db_blng_grp_base_price){
		 this.db_blng_grp_base_price=db_blng_grp_base_price;
	}

	public HashMap getBlngGrpDBRateSrv(){
		return this.db_blng_grp_rate_srv;
	}
	
	public void setBlngGrpDBRateSrv(HashMap db_blng_grp_rate_srv){
		 this.db_blng_grp_rate_srv=db_blng_grp_rate_srv;
	}

	public HashMap getBlngGrpDBRateSrvExcl(){
		return this.db_blng_grp_rate_srv_excl;
	}
	
	public void setBlngGrpDBRateSrvExcl(HashMap db_blng_grp_rate_srv_excl){
		 this.db_blng_grp_rate_srv_excl=db_blng_grp_rate_srv_excl;
	}	

	public HashMap getBlngGrpDBChargeSrv(){
		return this.db_blng_grp_charge_srv;
	}
	
	public void setBlngGrpDBChargeSrv(HashMap db_blng_grp_charge_srv){
		 this.db_blng_grp_charge_srv=db_blng_grp_charge_srv;
	}

	public HashMap getBlngGrpDBChargeSrvExcl(){
		return this.db_blng_grp_charge_srv_excl;
	}
	
	public void setBlngGrpDBChargeSrvExcl(HashMap db_blng_grp_charge_srv_excl){
		 this.db_blng_grp_charge_srv_excl=db_blng_grp_charge_srv_excl;
	}
	
	public void setModifyBlngGrpBasePrice(String flag){
		this.modify_blng_grp_base_price=flag;
	}
	
	public String getModifyBlngGrpBasePrice(){
		return this.modify_blng_grp_base_price;
	}
	
	public void setModifyBlngGrpRateSrv(String flag){
		this.modify_blng_grp_rate_srv=flag;
	}
	
	public String getModifyBlngGrpRateSrv(){
		return this.modify_blng_grp_rate_srv;
	}
	
	public void setModifyBlngGrpRateSrvExcl(String flag){
		this.modify_blng_grp_rate_srv_excl=flag;
	}
	public String getModifyBlngGrpRateSrvExcl(){
		return this.modify_blng_grp_rate_srv_excl;
	}

	public void setModifyBlngGrpChargeSrv(String flag){
		this.modify_blng_grp_charge_srv=flag;
	}
	
	public String getModifyBlngGrpChargeSrv(){
		return this.modify_blng_grp_charge_srv;
	}
	
	public void setModifyBlngGrpChargeSrvExcl(String flag){
		this.modify_blng_grp_charge_srv_excl=flag;
	}
	public String getModifyBlngGrpChargeSrvExcl(){
		return this.modify_blng_grp_charge_srv_excl;
	}

	public void setModifyBlngGrp(String flag){
		this.modify_blng_grp=flag;
	}
	public String getModifyBlngGrp(){
		return this.modify_blng_grp;
	}
	public void setModifyBlngGrpPeriod(String flag){
		this.modify_blng_grp_period=flag;
	}
	public String getModifyBlngGrpPeriod(){
		return this.modify_blng_grp_period;
	}
	
	public void setDBValues(String packageCode,String language_id, String operating_facility_id) throws Exception {
	Connection connection 		= null;	
	PreparedStatement pstmt 	= null;
	ResultSet rs 		= null;
	String sqlStr="";	

	String[] record;			
	HashMap blng_grp_dtls=new HashMap();
	HashMap db_blng_grp_dtls=new HashMap();
	String blng_grp_code="";		
	String fromDate="";
	String pkg_serv_code="";
	
	String prev_blng_grp_code="";		
	String prev_fromDate="";
	String prev_pkg_serv_code="";
	try{
		connection = ConnectionManager.getConnection();
		//shikha
		sqlStr="SELECT a.blng_grp_id blng_grp_id,DECODE (a.BLNG_GRP_ID,'**', 'All Groups',b.short_desc) blng_grp_desc,pkg_valid_days FROM bl_package_BG_dtls a, BL_BLNG_GRP_LANG_VW b WHERE package_code = ? AND a.operating_facility_id = ?  AND a.BLNG_GRP_ID = b.BLNG_GRP_ID(+) AND b.language_id(+) = ?";

		pstmt=connection.prepareStatement(sqlStr);	
		pstmt.setString(1,packageCode);
		pstmt.setString(2,operating_facility_id);
		pstmt.setString(3,language_id);				
		rs		= pstmt.executeQuery();
		
		while (rs.next()){
			record=new String[3];
			record[0]=rs.getString("blng_grp_id")==null?"":(rs.getString("blng_grp_id")).trim();
			record[1]=rs.getString("blng_grp_desc")==null?"":(rs.getString("blng_grp_desc")).trim();								
			record[2]=checkForNull(rs.getString("pkg_valid_days"));
			//GHL-CRF-0520.1				
			blng_grp_dtls.put(record[0],record); // changed by shikha
			db_blng_grp_dtls.put(record[0],record); // changed by shikha
			//GHL-CRF-0520.1				
		}
		setBlngGrpDtls(blng_grp_dtls);
		setBlnggrpDBDtls(db_blng_grp_dtls);
		
		ArrayList blng_grp_period_list=new ArrayList();
		ArrayList db_blng_grp_period_list=new ArrayList();
		HashMap blng_grp_period=new HashMap();
		HashMap db_blng_grp_period=new HashMap();
		//Modified Query V180122-Gayathri/MMS-DM-CRF-0118
		sqlStr ="SELECT   a.blng_grp_id, TO_CHAR (a.eff_from_date, 'DD/MM/YYYY') eff_from_date,TO_CHAR (a.eff_to_date, 'DD/MM/YYYY') eff_to_date,pkg_price_class_code,(SELECT short_desc FROM bl_price_class_lang_vw WHERE language_id = ? AND price_class_code = a.pkg_price_class_code AND operating_facility_id = ?) pkg_price_class_desc, outside_pkg_price_class_code, (SELECT short_desc FROM bl_price_class_lang_vw WHERE language_id = ? AND price_class_code = a.outside_pkg_price_class_code AND operating_facility_id = ?) outside_pkg_price_class_desc, a.gl_post_ac_for_pkg gl_post_ac_for_pkg, (SELECT acc_int_desc FROM bl_gl_account_lang_vw WHERE acc_int_code = a.gl_post_ac_for_pkg AND language_id = ? AND acc_entity_code = (SELECT acc_entity_code FROM sy_acc_entity b WHERE b.acc_entity_id = ?)) acc_int_desc,a.gl_post_ac_for_disc gl_post_ac_for_disc, (SELECT acc_int_desc FROM bl_gl_account_lang_vw WHERE acc_int_code = a.gl_post_ac_for_disc AND language_id = ? AND acc_entity_code = (SELECT acc_entity_code FROM sy_acc_entity b WHERE b.acc_entity_id = ?)) acc_int_disc_desc,addl_chg_applicable_yn addl_chg_applicable_yn,addl_chg_rule_code addl_chg_rule_code, rule_coverage rule_coverage FROM bl_package_bg_period a WHERE a.package_code = ? AND a.operating_facility_id = ? GROUP BY a.BLNG_GRP_ID,a.eff_from_date,a.eff_to_date,pkg_price_class_code,outside_pkg_price_class_code,gl_post_ac_for_pkg,gl_post_ac_for_disc,addl_chg_applicable_yn,addl_chg_rule_code,rule_coverage ORDER BY 1, 2";
				
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
		
		rs	= pstmt.executeQuery();
		
		while (rs!=null && rs.next()){
			record=new String[15];				
			blng_grp_code=rs.getString("blng_grp_id")==null?"":rs.getString("blng_grp_id");				
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
			if(!blng_grp_code.equals("") ){
				if(blng_grp_code.equals(prev_blng_grp_code) ){
				// add to old list.
					blng_grp_period_list.add(record);							
					db_blng_grp_period_list.add(record);	
				}else{
				if(blng_grp_period_list!=null && blng_grp_period_list.size()>0){
					blng_grp_period.put(prev_blng_grp_code.trim(),blng_grp_period_list);		
					db_blng_grp_period.put(prev_blng_grp_code.trim(),db_blng_grp_period_list);		}
				blng_grp_period_list=new ArrayList();
				db_blng_grp_period_list=new ArrayList();
				blng_grp_period_list.add(record);							
				db_blng_grp_period_list.add(record);							
			}
			prev_blng_grp_code=blng_grp_code;					
			}  			
		}
		if(blng_grp_period_list!=null && blng_grp_period_list.size()>0){
//				System.out.println("blng_grp_period_list="+blng_grp_period_list.toString());		
			blng_grp_period.put(prev_blng_grp_code.trim(),blng_grp_period_list);								
			db_blng_grp_period.put(prev_blng_grp_code.trim(),db_blng_grp_period_list);								
			}
			if(blng_grp_period!=null && blng_grp_period.size()>0){
				System.out.println("in setDBValues,blng_grp_period="+blng_grp_period.toString());
				setBlngGrpPeriod(blng_grp_period);				
				setBlngGrpDBPeriod(db_blng_grp_period);				
				System.out.println("in setDBValues,bean.getBlngGrpDBPeriod()="+((HashMap)getBlngGrpDBPeriod()).toString());
			 }
			
				blng_grp_code="";				
				fromDate="";
				prev_blng_grp_code="";				
				prev_fromDate="";
				ArrayList blng_grp_price_list=new ArrayList();
				ArrayList db_blng_grp_price_list=new ArrayList();
				HashMap blng_grp_base_price=new HashMap();
				HashMap db_blng_grp_base_price=new HashMap();
				//shikha need to change
				sqlStr ="SELECT   a.blng_grp_id blng_grp_id, TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date, a.blng_class_code blng_class_code, DECODE (a.blng_class_code,'**', 'All Groups',b.short_desc) short_desc,a.factor_rate_ind factor_rate_ind, a.factor_rate factor_rate, a.apply_fact_for_srv_lmt_yn apply_fact_for_srv_lmt_yn,rounding_by_integer, rounding_option, deposit_req_yn,allow_partial_deposit_yn, min_partial_deposit_type,min_partial_deposit, factor_for_serv_rate FROM BL_PACKAGE_BG_PRICE a, bl_blng_class_lang_vw b WHERE a.blng_class_code = b.blng_class_code(+) AND b.language_id(+) = ? AND a.package_code = ? AND a.operating_facility_id = ? GROUP BY a.blng_grp_id,a.eff_from_date,a.blng_class_code,b.short_desc,a.factor_rate_ind,a.factor_rate,a.apply_fact_for_srv_lmt_yn,rounding_by_integer,rounding_option,deposit_req_yn,allow_partial_deposit_yn,min_partial_deposit_type,min_partial_deposit,factor_for_serv_rate ORDER BY 1, 2, 3";
						
//				System.out.println("388 in setDBValues,sqlStr="+sqlStr);

				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
					
				pstmt=connection.prepareStatement(sqlStr);	
				pstmt.setString(1,language_id);	
				pstmt.setString(2,packageCode);				
				pstmt.setString(3,operating_facility_id);					
				rs		= pstmt.executeQuery();
//				System.out.println("Result Set size ==> "+rs.getRow());
				while (rs!=null && rs.next()){
					record=new String[12];
					blng_grp_code=rs.getString("blng_grp_id")==null?"":rs.getString("blng_grp_id");	
					fromDate=rs.getString("EFF_FROM_DATE")==null?"":rs.getString("EFF_FROM_DATE");
//					System.err.println("fromDate @403 in BlngGrpBean==> "+fromDate);
					record[0]=rs.getString("BLNG_CLASS_CODE")==null?"":(rs.getString("BLNG_CLASS_CODE")).trim();
//					System.err.println("BLNG_CLASS_CODE BlngGrpBean==> "+record[0]);
					record[1]=rs.getString("short_DESC")==null?"":rs.getString("short_DESC").trim();
//					System.err.println("short_DESC in BlngGrpBean==> "+record[1]);
					record[2]=rs.getString("FACTOR_RATE_IND")==null?"":rs.getString("FACTOR_RATE_IND"); 
//					System.err.println("FACTOR_RATE_IND in BlngGrpBean==> "+record[2]);
					record[3]=checkForNull(rs.getString("FACTOR_RATE"));		
//					System.err.println("FACTOR_RATE in BlngGrpBean==> "+record[3]);
					record[4]=checkForNull(rs.getString("ROUNDING_BY_INTEGER"));
//					System.err.println("ROUNDING_BY_INTEGER in BlngGrpBean==> "+record[4]);
					record[5]=checkForNull(rs.getString("ROUNDING_OPTION"));	
//					System.err.println("ROUNDING_OPTION in BlngGrpBean==> "+record[5]);
					record[6]=checkForNull(rs.getString("APPLY_FACT_FOR_SRV_LMT_YN"));					
//					System.err.println("APPLY_FACT_FOR_SRV_LMT_YN in BlngGrpBean==> "+record[6]);
					record[7] =checkForNull(rs.getString("DEPOSIT_REQ_YN"),"N");
//					System.err.println("DEPOSIT_REQ_YN in BlngGrpBean==> "+record[0]);
					record[8] = checkForNull(rs.getString("ALLOW_PARTIAL_DEPOSIT_YN"),"N");
					record[9] =checkForNull(rs.getString("MIN_PARTIAL_DEPOSIT_TYPE"));
					record[10] =checkForNull(rs.getString("MIN_PARTIAL_DEPOSIT"));
//					System.out.println("Before BlngGrpBean prev_fromDate -===> "+prev_fromDate);
					record[11] =checkForNull(rs.getString("FACTOR_FOR_SERV_RATE"));

		
					if(!blng_grp_code.equals("") && !fromDate.equals("")){
						if(blng_grp_code.equals(prev_blng_grp_code) && fromDate.equals(prev_fromDate)){
						// add to old list.
							blng_grp_price_list.add(record);							
							db_blng_grp_price_list.add(record);							
						}else{
							if(blng_grp_price_list!=null && blng_grp_price_list.size()>0){
								blng_grp_base_price.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim(),blng_grp_price_list);								
								db_blng_grp_base_price.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim(),db_blng_grp_price_list);								
							}
							blng_grp_price_list=new ArrayList();
							blng_grp_price_list.add(record);	
							db_blng_grp_price_list=new ArrayList();
							db_blng_grp_price_list.add(record);								
						}
						prev_blng_grp_code=blng_grp_code;
						prev_fromDate=fromDate;
					}  			
						
				}
				if(blng_grp_price_list!=null && blng_grp_price_list.size()>0){
					blng_grp_base_price.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim(),blng_grp_price_list);								
					db_blng_grp_base_price.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim(),db_blng_grp_price_list);								
				}
				if(blng_grp_base_price!=null && blng_grp_base_price.size()>0){
					setBlngGrpBasePrice(blng_grp_base_price);				
					setBlngGrpDBBasePrice(db_blng_grp_base_price);				
//					System.out.println("in setDBValues,bean.getBlngGrpDBBasePrice()="+((HashMap)getBlngGrpDBBasePrice()).toString());
				}		
			
			/******************* Rate Based Servcies ***********************************/
			blng_grp_code="";
			fromDate="";
			prev_blng_grp_code="";
			prev_blng_grp_code="";
			prev_fromDate="";
			ArrayList blng_grp_rate_srv_list=new ArrayList();
			HashMap blng_grp_rate_srv=new HashMap();
			ArrayList db_blng_grp_rate_srv_list=new ArrayList();
			HashMap db_blng_grp_rate_srv=new HashMap();

			sqlStr ="SELECT   a.blng_grp_id blng_grp_id, TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date,NVL (a.close_package_yn, 'N') close_package_yn, rounding_by_integer,rounding_option, auto_refund_yn, pkg_serv_ind, pkg_serv_code,b.service_desc service_desc, a.order_catalog_code order_catalog_code, (SELECT short_desc FROM or_order_catalog_lang_vw WHERE language_id = ? AND order_catalog_code = a.order_catalog_code) order_catalog_desc, rate_ind, factor_rate, qty_limit, amt_limit_ind, amt_limit,replaceable_yn, replaceable_serv_code,(SELECT short_desc FROM bl_blng_serv_lang_vw WHERE language_id = ? AND blng_serv_code = a.replaceable_serv_code)replaceable_serv_desc,rep_serv_ord_cat_code, (SELECT short_desc FROM or_order_catalog_lang_vw WHERE language_id = ? AND order_catalog_code = a.rep_serv_ord_cat_code) rep_serv_ord_cat_desc, NVL (refund_yn, 'N') refund_yn, NVL (refund_rate, 0) refund_rate,NVL (a.split_allowed_yn, 'N') split_allowed_yn, NVL (a.incl_home_medication_yn, 'N') incl_home_medication_yn,blcommonproc.bl_pharm_service_yn ('"+language_id+"',pkg_serv_ind,pkg_serv_code) enabledisparam,NVL (a.apply_fact_for_srv_lmt_yn, 'N') factor_appl,NVL (daily_amt_limit_yn, 'N') daily_amt_limit_yn, daily_amt_limit,daily_amt_limit_gross_net, NVL (daily_limit_ind,'*') daily_limit_ind,daily_qty_limit FROM bl_package_coverage_for_bg a,(SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc,language_id, status FROM bl_blng_serv_lang_vw UNION ALL SELECT 'P' serv_ind, package_serv_group_code code,short_desc service_desc, 'en', NULL status  FROM bl_package_serv_group_hdr WHERE operating_facility_id = '"+operating_facility_id+"' UNION ALL SELECT 'C' serv_ind, serv_classification_code code,short_desc service_desc, language_id, status FROM bl_serv_classification_lang_vw UNION ALL SELECT 'G' serv_ind, serv_grp_code code, short_desc service_desc, language_id, status FROM bl_blng_serv_grp_lang_vw) b WHERE a.operating_facility_id = ? AND b.status IS NULL AND a.package_code = ? AND a.rate_charge_ind = 'R' AND a.pkg_serv_code = b.code AND a.pkg_serv_ind = b.serv_ind AND b.language_id = ? GROUP BY a.blng_grp_id,a.eff_from_date,NVL (a.close_package_yn, 'N'),rounding_by_integer,rounding_option,auto_refund_yn,pkg_serv_ind,pkg_serv_code,b.service_desc,a.order_catalog_code,rate_ind,factor_rate,qty_limit,amt_limit_ind,amt_limit,replaceable_yn,replaceable_serv_code,rep_serv_ord_cat_code,NVL (refund_yn, 'N'),NVL (refund_rate, 0),NVL (a.split_allowed_yn, 'N'),incl_home_medication_yn,blcommonproc.bl_pharm_service_yn ('"+language_id+"',pkg_serv_ind,pkg_serv_code),NVL (a.apply_fact_for_srv_lmt_yn, 'N'),NVL (daily_amt_limit_yn, 'N'),daily_amt_limit,daily_amt_limit_gross_net,NVL (daily_limit_ind, '*'),daily_qty_limit ORDER BY 1, 2, 3"; //V211130
			
//			System.out.println("470 in setDBValues,sqlStr="+sqlStr);
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
				record=new String[30]; //Split reqd
				blng_grp_code=rs.getString("blng_grp_id")==null?"":rs.getString("blng_grp_id");
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
				if(!blng_grp_code.equals("") && !fromDate.equals("")){
					if(blng_grp_code.equals(prev_blng_grp_code)  && fromDate.equals(prev_fromDate)){
					// add to old list.
						blng_grp_rate_srv_list.add(record);							
						db_blng_grp_rate_srv_list.add(record);							
					}else{
						if(blng_grp_rate_srv_list!=null && blng_grp_rate_srv_list.size()>0){
							blng_grp_rate_srv.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim(),blng_grp_rate_srv_list);								
							db_blng_grp_rate_srv.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim(),db_blng_grp_rate_srv_list);								
						}
						blng_grp_rate_srv_list=new ArrayList();
						blng_grp_rate_srv_list.add(record);		
						db_blng_grp_rate_srv_list=new ArrayList();
						db_blng_grp_rate_srv_list.add(record);							
					}
					prev_blng_grp_code=blng_grp_code;					
					prev_fromDate=fromDate;
				}  			
					
			}
			if(blng_grp_rate_srv_list!=null && blng_grp_rate_srv_list.size()>0){
				blng_grp_rate_srv.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim(),blng_grp_rate_srv_list);								
				db_blng_grp_rate_srv.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim(),db_blng_grp_rate_srv_list);								
			}
			if(blng_grp_rate_srv!=null && blng_grp_rate_srv.size()>0){
				setBlngGrpRateSrv(blng_grp_rate_srv);				
				setBlngGrpDBRateSrv(db_blng_grp_rate_srv);				
//				System.out.println("in setDBValues,bean.getBlngGrpDBRateSrv()="+((HashMap)getBlngGrpDBRateSrv()).toString());
			}
		/******************Rate based service Exclusions*************************************************/
			blng_grp_code="";			
			fromDate="";
			pkg_serv_code="";
			prev_blng_grp_code="";
			prev_blng_grp_code="";
			prev_fromDate="";
			prev_pkg_serv_code="";
			ArrayList blng_grp_rate_srv_excl_list=new ArrayList();
			HashMap blng_grp_rate_srv_excl=new HashMap();
			ArrayList db_blng_grp_rate_srv_excl_list=new ArrayList();
			HashMap db_blng_grp_rate_srv_excl=new HashMap();

			sqlStr ="SELECT   a.blng_grp_id blng_grp_id,TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date,a.pkg_serv_code pkg_serv_code, a.excl_serv_ind excl_serv_ind,a.excl_serv_code excl_serv_code, b.service_desc service_desc,a.exclude_yn exclude_yn, qty_limit, amt_limit,a.apply_fact_for_srv_lmt_yn factor_appl, amt_limit_ind, replaceable_yn, replaceable_serv_code,(SELECT long_desc FROM bl_blng_serv_lang_vw WHERE blng_serv_code =a.replaceable_serv_code AND language_id = ?) replaceable_serv_desc,refund_yn, refund_rate, rounding_by_integer, rounding_option,a.split_allowed_yn, a.incl_home_medication_yn,blcommonproc.bl_pharm_service_yn ('"+language_id+"',excl_serv_ind,excl_serv_code) enabledisparam,auto_refund_yn, NVL (daily_amt_limit_yn, 'N') daily_amt_limit_yn,daily_amt_limit, daily_amt_limit_gross_net,NVL (daily_limit_ind, '*') daily_limit_ind, daily_qty_limit FROM bl_package_excl_for_bg a, (SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc,language_id FROM bl_blng_serv_lang_vw UNION ALL SELECT 'P' serv_ind, package_serv_group_code code,short_desc service_desc, 'en' FROM bl_package_serv_group_hdr WHERE operating_facility_id = '"+operating_facility_id+"' UNION ALL SELECT 'T' serv_ind, sale_category_code code,short_desc service_desc, 'en' FROM bl_st_item_sale_catg_hdr UNION ALL SELECT 'G' serv_ind, serv_grp_code code, short_desc description,language_id FROM bl_blng_serv_grp_lang_vw UNION ALL SELECT 'C' serv_ind, serv_classification_code code,short_desc service_desc, language_id FROM bl_serv_classification_lang_vw UNION ALL SELECT 'M' serv_ind, item_code code, short_desc service_desc,language_id FROM mm_item_lang_vw) b WHERE a.operating_facility_id = ? AND a.package_code = ? AND a.excl_serv_code = b.code AND a.excl_serv_ind = b.serv_ind AND b.language_id = ? GROUP BY a.blng_grp_id,eff_from_date,a.pkg_serv_code,a.excl_serv_ind,a.excl_serv_code,b.service_desc,a.exclude_yn,qty_limit,amt_limit,a.apply_fact_for_srv_lmt_yn,amt_limit_ind,replaceable_yn,replaceable_serv_code,refund_yn,refund_rate,rounding_by_integer,rounding_option,a.split_allowed_yn,incl_home_medication_yn,blcommonproc.bl_pharm_service_yn ('"+language_id+"',excl_serv_ind,excl_serv_code),auto_refund_yn,NVL (daily_amt_limit_yn, 'N'),daily_amt_limit,daily_amt_limit_gross_net,NVL (daily_limit_ind, '*'),daily_qty_limit ORDER BY 1, 2, 4, 3"; //V211130
	//				System.out.println("561 in setDBValues,sqlStr="+sqlStr);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
				
			pstmt=connection.prepareStatement(sqlStr);			
			pstmt.setString(1,language_id);		
			pstmt.setString(2,operating_facility_id);		
//			System.out.println("BlngGrpBean operating_facility_id ==> "+operating_facility_id);
			pstmt.setString(3,packageCode);
//			System.out.println("BlngGrpBean packageCode ==> "+packageCode);
			pstmt.setString(4,language_id);
//			System.out.println("BlngGrpBean language_id ==> "+language_id);
					
			rs		= pstmt.executeQuery();
			
			while (rs!=null && rs.next()){
				record=new String[24];//Split reqd
				blng_grp_code=rs.getString("blng_grp_id")==null?"":rs.getString("blng_grp_id");				
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
/*				System.out.println("Result Size ==> "+rs.getRow());
				System.out.println("fromDate ==> "+fromDate);
				System.out.println("pkg_serv_code 607 ==> "+pkg_serv_code);
				System.out.println("excl_serv_code 608 ==> "+record[1]);*/
				
				if(!blng_grp_code.equals("") && !fromDate.equals("") && !pkg_serv_code.equals("")){
			//	System.out.println("Testing 611 "+pkg_serv_code+"prev_pkg_serv_code  "+prev_pkg_serv_code);
			//		System.out.println("612");
				if(blng_grp_code.equals(prev_blng_grp_code)&& fromDate.equals(prev_fromDate) && pkg_serv_code.equals(prev_pkg_serv_code)){ 
					// add to old list.
						blng_grp_rate_srv_excl_list.add(record);							
						db_blng_grp_rate_srv_excl_list.add(record);							
					}else{

						if(blng_grp_rate_srv_excl_list!=null && blng_grp_rate_srv_excl_list.size()>0){
							blng_grp_rate_srv_excl.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),blng_grp_rate_srv_excl_list);								
						db_blng_grp_rate_srv_excl.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),db_blng_grp_rate_srv_excl_list);					
						}
						blng_grp_rate_srv_excl_list=new ArrayList();
						blng_grp_rate_srv_excl_list.add(record);	
						db_blng_grp_rate_srv_excl_list=new ArrayList();
						db_blng_grp_rate_srv_excl_list.add(record);							
					}
					prev_blng_grp_code=blng_grp_code;					
					prev_fromDate=fromDate;
					prev_pkg_serv_code=pkg_serv_code;
				}  
					
			}
			if(blng_grp_rate_srv_excl_list!=null && blng_grp_rate_srv_excl_list.size()>0){
				blng_grp_rate_srv_excl.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),blng_grp_rate_srv_excl_list);								
			
			db_blng_grp_rate_srv_excl.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),db_blng_grp_rate_srv_excl_list);	
			

			}
			if(blng_grp_rate_srv_excl!=null && blng_grp_rate_srv_excl.size()>0){
				setBlngGrpRateSrvExcl(blng_grp_rate_srv_excl);				
				setBlngGrpDBRateSrvExcl(db_blng_grp_rate_srv_excl);				
			}			
				
			/******************* Charge Based Servcies ***********************************/
			blng_grp_code="";			
			fromDate="";
			prev_blng_grp_code="";			
			prev_fromDate="";
			ArrayList blng_grp_charge_srv_list=new ArrayList();
			HashMap blng_grp_charge_srv=new HashMap();
			ArrayList db_blng_grp_charge_srv_list=new ArrayList();
			HashMap db_blng_grp_charge_srv=new HashMap();
				sqlStr ="SELECT   a.blng_grp_id blng_grp_id,TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date, pkg_serv_ind,pkg_serv_code, b.service_desc service_desc, amt_limit_ind, amt_limit,rounding_by_integer, rounding_option, NVL (refund_yn, 'N') refund_yn,NVL (refund_rate, 0) refund_rate, auto_refund_yn,NVL (a.apply_fact_for_srv_lmt_yn, 'N') factor_appl,NVL (a.split_allowed_yn, 'N') split_allowed_yn,NVL (a.incl_home_medication_yn, 'N') incl_home_medication_yn,blcommonproc.bl_pharm_service_yn ('"+language_id+"', pkg_serv_ind,pkg_serv_code) enabledisparam, (SELECT 'Y' FROM bl_package_excl_for_BG c WHERE c.operating_facility_id = a.operating_facility_id AND c.package_code = a.package_code AND c.pkg_serv_code = a.pkg_serv_code AND c.pkg_serv_ind = a.pkg_serv_ind AND ROWNUM = 1) service_limit FROM bl_package_coverage_for_bg a,(SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc,language_id, status FROM bl_blng_serv_lang_vw UNION ALL SELECT 'M' serv_ind, item_code code, short_desc service_desc,language_id, NULL status FROM mm_item_lang_vw) b WHERE a.operating_facility_id = ? AND b.status IS NULL AND a.package_code = ? AND a.rate_charge_ind = 'C' AND a.pkg_serv_code = b.code AND a.pkg_serv_ind = b.serv_ind AND b.language_id = ? ORDER BY 1, 2, 3";
	//		System.out.println("656 in setDBValues,sqlStr="+sqlStr);
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
				blng_grp_code=rs.getString("blng_grp_id")==null?"":rs.getString("blng_grp_id");				
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
				
				if(!blng_grp_code.equals("") && !fromDate.equals("")){
					if(blng_grp_code.equals(prev_blng_grp_code)  && fromDate.equals(prev_fromDate)){
					// add to old list.
						blng_grp_charge_srv_list.add(record);							
						db_blng_grp_charge_srv_list.add(record);							
					}else{
						if(blng_grp_charge_srv_list!=null && blng_grp_charge_srv_list.size()>0){
//							System.out.println("blng_grp_charge_srv_list="+blng_grp_charge_srv_list.toString());		
							blng_grp_charge_srv.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim(),blng_grp_charge_srv_list);								
							db_blng_grp_charge_srv.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim(),db_blng_grp_charge_srv_list);								
						}
						blng_grp_charge_srv_list=new ArrayList();
						blng_grp_charge_srv_list.add(record);	
						db_blng_grp_charge_srv_list=new ArrayList();
						db_blng_grp_charge_srv_list.add(record);							
					}
					prev_blng_grp_code=blng_grp_code;					
					prev_fromDate=fromDate;
				}  			
					
			}
			if(blng_grp_charge_srv_list!=null && blng_grp_charge_srv_list.size()>0){
	//			System.out.println("blng_grp_charge_srv_list="+blng_grp_charge_srv_list.toString());		
				blng_grp_charge_srv.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim(),blng_grp_charge_srv_list);								
				db_blng_grp_charge_srv.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim(),db_blng_grp_charge_srv_list);								
			}
			if(blng_grp_charge_srv!=null && blng_grp_charge_srv.size()>0){
				setBlngGrpChargeSrv(blng_grp_charge_srv);				
				setBlngGrpDBChargeSrv(db_blng_grp_charge_srv);				
//				System.out.println("in setDBValues,bean.getBlngGrpDBChargeSrv()="+((HashMap)getBlngGrpDBChargeSrv()).toString());
			}
				/******************Charge based service Exclusions*************************************************/
			blng_grp_code="";
			
			fromDate="";
			pkg_serv_code="";
			prev_blng_grp_code="";			
			prev_fromDate="";
			prev_pkg_serv_code="";
			ArrayList blng_grp_charge_srv_excl_list=new ArrayList();
			HashMap blng_grp_charge_srv_excl=new HashMap();
			ArrayList db_blng_grp_charge_srv_excl_list=new ArrayList();
			HashMap db_blng_grp_charge_srv_excl=new HashMap();
			sqlStr ="SELECT   a.blng_grp_id blng_grp_id,TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date,a.pkg_serv_code pkg_serv_code, a.excl_serv_code excl_serv_code,b.short_desc service_desc, a.exclude_yn exclude_yn, qty_limit,a.split_allowed_yn, a.incl_home_medication_yn,blcommonproc.bl_pharm_service_yn ('"+language_id+"',excl_serv_ind,excl_serv_code) enabledisparam,amt_limit FROM bl_package_excl_for_bg a, mm_item_lang_vw b WHERE a.operating_facility_id = ? AND a.package_code = ? AND a.rate_charge_ind = 'C' AND a.excl_serv_code = b.item_code AND b.language_id = ? GROUP BY a.blng_grp_id,eff_from_date,a.pkg_serv_code,a.excl_serv_code,b.short_desc,a.exclude_yn,qty_limit,a.split_allowed_yn,incl_home_medication_yn,blcommonproc.bl_pharm_service_yn ('"+language_id+"',excl_serv_ind,excl_serv_code),amt_limit ORDER BY 1, 2, 3";
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
				
			pstmt=connection.prepareStatement(sqlStr);			
			pstmt.setString(1,operating_facility_id);
			pstmt.setString(2,packageCode);								
			
			pstmt.setString(3,language_id);						
					
			rs		= pstmt.executeQuery();
			
			while (rs!=null && rs.next()){
				record=new String[8];//Split reqd
				blng_grp_code=rs.getString("blng_grp_id")==null?"":rs.getString("blng_grp_id");
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
				if(!blng_grp_code.equals("")  && !fromDate.equals("") && !pkg_serv_code.equals("")){
					if(blng_grp_code.equals(prev_blng_grp_code) &&  fromDate.equals(prev_fromDate) && pkg_serv_code.equals(prev_pkg_serv_code)){
					// add to old list.
						blng_grp_charge_srv_excl_list.add(record);							
						db_blng_grp_charge_srv_excl_list.add(record);							
					}else{
						if(blng_grp_charge_srv_excl_list!=null && blng_grp_charge_srv_excl_list.size()>0){
							blng_grp_charge_srv_excl.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),blng_grp_charge_srv_excl_list);								
							db_blng_grp_charge_srv_excl.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),db_blng_grp_charge_srv_excl_list);								
						}
						blng_grp_charge_srv_excl_list=new ArrayList();
						blng_grp_charge_srv_excl_list.add(record);		
						db_blng_grp_charge_srv_excl_list=new ArrayList();
						db_blng_grp_charge_srv_excl_list.add(record);								
					}
					prev_blng_grp_code=blng_grp_code;					
					prev_fromDate=fromDate;
					prev_pkg_serv_code=pkg_serv_code;
				}  			
					
			}
			if(blng_grp_charge_srv_excl_list!=null && blng_grp_charge_srv_excl_list.size()>0){
//				System.out.println("blng_grp_charge_srv_excl_list="+blng_grp_charge_srv_excl_list.toString());		
				blng_grp_charge_srv_excl.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),blng_grp_charge_srv_excl_list);								
				db_blng_grp_charge_srv_excl.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),db_blng_grp_charge_srv_excl_list);								
			}
			if(blng_grp_charge_srv_excl!=null && blng_grp_charge_srv_excl.size()>0){
//				System.out.println("in setDBValues,blng_grp_charge_srv_excl="+blng_grp_charge_srv_excl.toString());
				setBlngGrpChargeSrvExcl(blng_grp_charge_srv_excl);				
				setBlngGrpDBChargeSrvExcl(db_blng_grp_charge_srv_excl);				
//				System.out.println("in setDBValues,bean.getBlngGrpDBChargeSrvExcl()="+((HashMap)getBlngGrpDBChargeSrvExcl()).toString());
			}
		}catch(Exception e){
			System.out.println("Exception e="+e);
			e.printStackTrace();
		}finally{
			if(rs!=null) rs.close();
			if(pstmt!=null) 
				pstmt.close();			
			ConnectionManager.returnConnection(connection);
		}
	}

		public String getSysDate() throws Exception
	{
		Connection connection 		= ConnectionManager.getConnection();	
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
			ConnectionManager.returnConnection(connection);
		}
//			System.out.println("sysDate:"+sysDate);
		return sysDate ;

	}
	public String getNoOfDecimal() throws Exception
	{
		Connection connection 		= ConnectionManager.getConnection();	
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
			ConnectionManager.returnConnection(connection);
		}
//			System.out.println("noofdecimal:"+noofdecimal);
		return noofdecimal ;

	}
	public String getGLSmryYN(String facility_id) throws Exception
	{
		Connection connection 		= ConnectionManager.getConnection();	
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
			ConnectionManager.returnConnection(connection);
		}
//		System.out.println("glSmryYN:"+glSmryYN);
		if(glSmryYN==null) glSmryYN="";
		return glSmryYN ;

	}
	
	public String setPrevDateFromBean(String tab,String packageCode,String language_id, String operating_facility_id,String blngGroupCode, String effFromDate) throws Exception {
		String modified = "N";
		Connection connection 		= null;	
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;
		String sqlStr="";	
		
		String[] record;			
		String blng_grp_code="";
		String fromDate="";
		String pkg_serv_code="";
		
		String prev_blng_grp_code="";
		String prev_fromDate="";
		String prev_pkg_serv_code="";
		try{			
			connection = ConnectionManager.getConnection();
			
			/******************* Rate Based Servcies ***********************************/
			if("BLNG_GRP_RATE_BASED".equals(tab)){
			blng_grp_code="";
			fromDate="";
			prev_blng_grp_code="";			
			prev_fromDate="";
			ArrayList blng_grp_rate_srv_list=new ArrayList();
			HashMap blng_grp_rate_srv=getBlngGrpRateSrv();
				
			sqlStr ="SELECT   a.blng_grp_id blng_grp_id,TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date,NVL (a.close_package_yn, 'N') close_package_yn, rounding_by_integer,rounding_option, auto_refund_yn, pkg_serv_ind, pkg_serv_code,b.service_desc service_desc, a.order_catalog_code order_catalog_code,(SELECT short_desc FROM or_order_catalog_lang_vw WHERE language_id = ? AND order_catalog_code = a.order_catalog_code)order_catalog_desc,rate_ind, factor_rate, qty_limit, amt_limit_ind, amt_limit, replaceable_yn, replaceable_serv_code,(SELECT short_desc FROM bl_blng_serv_lang_vw WHERE language_id = ? AND blng_serv_code = a.replaceable_serv_code)replaceable_serv_desc,rep_serv_ord_cat_code,(SELECT short_desc FROM or_order_catalog_lang_vw WHERE language_id = ? AND order_catalog_code = a.rep_serv_ord_cat_code)rep_serv_ord_cat_desc, NVL (refund_yn, 'N') refund_yn, NVL (refund_rate, 0) refund_rate,NVL (a.split_allowed_yn, 'N') split_allowed_yn,NVL (a.incl_home_medication_yn, 'N') incl_home_medication_yn,bl_pharm_service_yn (language_id,pkg_serv_ind,pkg_serv_code ) enabledisparam,NVL (a.apply_fact_for_srv_lmt_yn, 'N') factor_appl,NVL (daily_amt_limit_yn, 'N') daily_amt_limit_yn, daily_amt_limit,daily_amt_limit_gross_net, NVL (daily_limit_ind,'*') daily_limit_ind,daily_qty_limit FROM bl_package_coverage_for_bg a,(SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc,language_id, status FROM bl_blng_serv_lang_vw UNION ALL SELECT 'P' serv_ind, package_serv_group_code code,short_desc service_desc, 'en', NULL status FROM bl_package_serv_group_hdr WHERE operating_facility_id = '"+operating_facility_id+"' UNION ALL SELECT 'C' serv_ind, serv_classification_code code,short_desc service_desc, language_id, status FROM bl_serv_classification_lang_vw UNION ALL SELECT 'G' serv_ind, serv_grp_code code, short_desc service_desc,language_id, status FROM bl_blng_serv_grp_lang_vw) b WHERE a.operating_facility_id = ? AND b.status IS NULL AND a.package_code = ? AND a.rate_charge_ind = 'R' AND a.pkg_serv_code = b.code AND a.pkg_serv_ind = b.serv_ind AND b.language_id = ? AND a.blng_grp_id = ? AND a.eff_from_date = (SELECT MAX (c.eff_from_date) FROM bl_package_bg_period c WHERE c.operating_facility_id = a.operating_facility_id AND c.package_code = a.package_code AND c.blng_grp_id = a.blng_grp_id )GROUP BY a.blng_grp_id,a.eff_from_date,NVL (a.close_package_yn, 'N'),rounding_by_integer,rounding_option,auto_refund_yn,pkg_serv_ind,pkg_serv_code,b.service_desc,a.order_catalog_code,rate_ind,factor_rate,qty_limit,amt_limit_ind,amt_limit,replaceable_yn,replaceable_serv_code,rep_serv_ord_cat_code,NVL (refund_yn, 'N'),NVL (refund_rate, 0),NVL (a.split_allowed_yn, 'N'),NVL (a.apply_fact_for_srv_lmt_yn, 'N'),NVL (a.incl_home_medication_yn, 'N'),bl_pharm_service_yn (language_id, pkg_serv_ind, pkg_serv_code),NVL (daily_amt_limit_yn, 'N'),daily_amt_limit,daily_amt_limit_gross_net,NVL (daily_limit_ind, '*'),daily_qty_limit ORDER BY 1, 2, 3"; //V211130

			pstmt=connection.prepareStatement(sqlStr);	
			pstmt.setString(1,language_id);	
			pstmt.setString(2,language_id);	
			pstmt.setString(3,language_id);	
			pstmt.setString(4,operating_facility_id);	
			pstmt.setString(5,packageCode);				
			pstmt.setString(6,language_id);	
			pstmt.setString(7,blngGroupCode);
		
			rs		= pstmt.executeQuery();
			
			while (rs!=null && rs.next()){
				record=new String[30]; //Split reqd
				blng_grp_code=blngGroupCode;			
				fromDate=effFromDate;
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
				if(!blng_grp_code.equals("") && !fromDate.equals("")){
					if(blng_grp_code.equals(prev_blng_grp_code) && fromDate.equals(prev_fromDate)){
					// add to old list.
						blng_grp_rate_srv_list.add(record);													
					}else{
						if(blng_grp_rate_srv_list!=null && blng_grp_rate_srv_list.size()>0){
							blng_grp_rate_srv.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim(),blng_grp_rate_srv_list);																							
						}
						blng_grp_rate_srv_list=new ArrayList();
						blng_grp_rate_srv_list.add(record);							
					}
					prev_blng_grp_code=blng_grp_code;					
					prev_fromDate=fromDate;
				}  			
					
			}
			if(blng_grp_rate_srv_list!=null && blng_grp_rate_srv_list.size()>0){
				modified = "Y";
				blng_grp_rate_srv.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim(),blng_grp_rate_srv_list);																				
			}
			if(blng_grp_rate_srv!=null && blng_grp_rate_srv.size()>0){
				setBlngGrpRateSrv(blng_grp_rate_srv);											
//				System.out.println("in setDBValues,bean.getBlngGrpDBRateSrv()="+((HashMap)getBlngGrpDBRateSrv()).toString());
			}
			}
		/******************Rate based service Exclusions*************************************************/
			if("BLNG_GRP_RATE_BASED_SERV_LIMIT".equals(tab)){
			blng_grp_code="";			
			fromDate="";
			pkg_serv_code="";
			prev_blng_grp_code="";			
			prev_fromDate="";
			prev_pkg_serv_code="";
			ArrayList blng_grp_rate_srv_excl_list=new ArrayList();
			HashMap blng_grp_rate_srv_excl=getBlngGrpRateSrvExcl();


			sqlStr ="SELECT   a.blng_grp_id blng_grp_id,TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date,a.pkg_serv_code pkg_serv_code, a.excl_serv_ind excl_serv_ind,a.excl_serv_code excl_serv_code, b.service_desc service_desc,a.exclude_yn exclude_yn, qty_limit, amt_limit,a.apply_fact_for_srv_lmt_yn factor_appl, amt_limit_ind,replaceable_yn, replaceable_serv_code,(SELECT long_desc FROM bl_blng_serv_lang_vw WHERE blng_serv_code = a.replaceable_serv_code AND language_id = ?) replaceable_serv_desc,refund_yn, refund_rate, rounding_by_integer, rounding_option,a.split_allowed_yn, a.incl_home_medication_yn,bl_pharm_service_yn (language_id,excl_serv_ind,excl_serv_code) enabledisparam,auto_refund_yn, NVL (daily_amt_limit_yn, 'N') daily_amt_limit_yn,daily_amt_limit, daily_amt_limit_gross_net,NVL (daily_limit_ind, '*') daily_limit_ind, daily_qty_limit FROM bl_package_excl_for_bg a,(SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc,language_id FROM bl_blng_serv_lang_vw UNION ALL SELECT 'P' serv_ind, package_serv_group_code code,short_desc service_desc, 'en' FROM bl_package_serv_group_hdr WHERE operating_facility_id = '"+operating_facility_id+"' UNION ALL SELECT 'T' serv_ind, sale_category_code code,short_desc service_desc, 'en' FROM bl_st_item_sale_catg_hdr UNION ALL SELECT 'G' serv_ind, serv_grp_code code, short_desc description,language_id FROM bl_blng_serv_grp_lang_vw UNION ALL SELECT 'C' serv_ind, serv_classification_code code,short_desc service_desc, language_id FROM bl_serv_classification_lang_vw UNION ALL SELECT 'M' serv_ind, item_code code, short_desc service_desc,language_id FROM mm_item_lang_vw) b WHERE a.operating_facility_id = ? AND a.package_code = ? AND a.excl_serv_code = b.code AND a.excl_serv_ind = b.serv_ind AND b.language_id = ? AND a.blng_grp_id = ? AND a.eff_from_date =(SELECT MAX (c.eff_from_date) FROM bl_package_bg_period c WHERE c.operating_facility_id = a.operating_facility_id AND c.package_code = a.package_code AND c.blng_grp_id = a.blng_grp_id) GROUP BY a.blng_grp_id,eff_from_date,a.pkg_serv_code,a.excl_serv_ind,a.excl_serv_code,b.service_desc,a.exclude_yn,qty_limit,amt_limit,a.apply_fact_for_srv_lmt_yn,amt_limit_ind,replaceable_yn,replaceable_serv_code,refund_yn,refund_rate,rounding_by_integer,rounding_option,a.split_allowed_yn,a.incl_home_medication_yn,bl_pharm_service_yn (language_id, excl_serv_ind, excl_serv_code),auto_refund_yn,NVL (daily_amt_limit_yn, 'N'),daily_amt_limit,daily_amt_limit_gross_net,NVL (daily_limit_ind, '*'), daily_qty_limit ORDER BY 1, 2, 4, 3"; //V211130
//					System.out.println("1001 in setDBValues,sqlStr="+sqlStr);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
				
			pstmt=connection.prepareStatement(sqlStr);			
			pstmt.setString(1,language_id);		
			pstmt.setString(2,operating_facility_id);		
			pstmt.setString(3,packageCode);
			pstmt.setString(4,language_id);
			pstmt.setString(5,blngGroupCode);
			
			rs		= pstmt.executeQuery();
			
			while (rs!=null && rs.next()){
				record=new String[24];//Split reqd
				blng_grp_code= blngGroupCode; 			
				fromDate=effFromDate;
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
				
				if(!blng_grp_code.equals("") && !fromDate.equals("") && !pkg_serv_code.equals("")){

				if(blng_grp_code.equals(prev_blng_grp_code) && fromDate.equals(prev_fromDate) && pkg_serv_code.equals(prev_pkg_serv_code)){ 
					// add to old list.
						blng_grp_rate_srv_excl_list.add(record);												
					}else{

						if(blng_grp_rate_srv_excl_list!=null && blng_grp_rate_srv_excl_list.size()>0){
							blng_grp_rate_srv_excl.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),blng_grp_rate_srv_excl_list);								
						}
						blng_grp_rate_srv_excl_list=new ArrayList();
						blng_grp_rate_srv_excl_list.add(record);						
					}
					prev_blng_grp_code=blng_grp_code;					
					prev_fromDate=fromDate;
					prev_pkg_serv_code=pkg_serv_code;
				}  
					
			}
			if(blng_grp_rate_srv_excl_list!=null && blng_grp_rate_srv_excl_list.size()>0){
				modified = "Y";
				blng_grp_rate_srv_excl.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),blng_grp_rate_srv_excl_list);								
			
			

			}
			if(blng_grp_rate_srv_excl!=null && blng_grp_rate_srv_excl.size()>0){
				setBlngGrpRateSrvExcl(blng_grp_rate_srv_excl);				
			}
			}
			
			/******************* Charge Based Servcies ***********************************/
			if("BLNG_GRP_CHARGE_BASED".equals(tab)){
			blng_grp_code="";			
			fromDate="";
			prev_blng_grp_code="";			
			prev_fromDate="";
			ArrayList blng_grp_charge_srv_list=new ArrayList();
			HashMap blng_grp_charge_srv=getBlngGrpChargeSrv();
				sqlStr ="SELECT   a.blng_grp_id blng_grp_id,TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date, pkg_serv_ind,pkg_serv_code, b.service_desc service_desc, amt_limit_ind, amt_limit,rounding_by_integer, rounding_option, NVL (refund_yn, 'N') refund_yn,NVL (refund_rate, 0) refund_rate, auto_refund_yn,NVL (a.apply_fact_for_srv_lmt_yn, 'N') factor_appl,NVL (a.split_allowed_yn, 'N') split_allowed_yn,NVL (a.incl_home_medication_yn, 'N') incl_home_medication_yn,bl_pharm_service_yn (language_id,excl_serv_ind,excl_serv_code) enabledisparam,(SELECT 'Y' FROM bl_package_excl_for_bg c WHERE c.operating_facility_id = a.operating_facility_id AND c.package_code = a.package_code AND c.pkg_serv_code = a.pkg_serv_code AND c.pkg_serv_ind = a.pkg_serv_ind AND ROWNUM = 1) service_limit FROM bl_package_coverage_for_bg a,(SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc,language_id, status FROM bl_blng_serv_lang_vw UNION ALL SELECT 'M' serv_ind, item_code code, short_desc service_desc,language_id, NULL status FROM mm_item_lang_vw) b WHERE a.operating_facility_id = ? AND b.status IS NULL AND a.package_code = ? AND a.rate_charge_ind = 'C' AND a.pkg_serv_code = b.code AND a.pkg_serv_ind = b.serv_ind AND b.language_id = ? AND a.blng_grp_id = ? AND a.eff_from_date =(SELECT MAX (c.eff_from_date) FROM bl_package_bg_period c WHERE c.operating_facility_id = a.operating_facility_id AND c.package_code = a.package_code AND c.blng_grp_id = a.blng_grp_id) ORDER BY 1, 2, 3";
//			System.out.println("1084 in setDBValues,sqlStr="+sqlStr);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();				
			pstmt=connection.prepareStatement(sqlStr);	
			pstmt.setString(1,operating_facility_id);	
			pstmt.setString(2,packageCode);
			pstmt.setString(3,language_id);	
			pstmt.setString(4,blngGroupCode);			
			rs		= pstmt.executeQuery();			
			while (rs!=null && rs.next()){
				record=new String[15];//Aplit reqd
				blng_grp_code=blngGroupCode;				
				fromDate=effFromDate;
				record[0]=rs.getString("pkg_serv_ind")==null?"":rs.getString("pkg_serv_ind").trim();
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
				if(!blng_grp_code.equals("") && !fromDate.equals("")){
					if(blng_grp_code.equals(prev_blng_grp_code)  && fromDate.equals(prev_fromDate)){
					// add to old list.
						blng_grp_charge_srv_list.add(record);													
					}else{
						if(blng_grp_charge_srv_list!=null && blng_grp_charge_srv_list.size()>0){
	//						System.out.println("blng_grp_charge_srv_list="+blng_grp_charge_srv_list.toString());		
							blng_grp_charge_srv.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim(),blng_grp_charge_srv_list);								
						}
						blng_grp_charge_srv_list=new ArrayList();
						blng_grp_charge_srv_list.add(record);								
					}
					prev_blng_grp_code=blng_grp_code;				
					prev_fromDate=fromDate;
				}  			
					
			}
			if(blng_grp_charge_srv_list!=null && blng_grp_charge_srv_list.size()>0){
//				System.out.println("blng_grp_charge_srv_list="+blng_grp_charge_srv_list.toString());		
				modified = "Y";
				blng_grp_charge_srv.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim(),blng_grp_charge_srv_list);								
			}
			if(blng_grp_charge_srv!=null && blng_grp_charge_srv.size()>0){
				setBlngGrpChargeSrv(blng_grp_charge_srv);				
	//			System.out.println("in setDBValues,bean.getBlngGrpDBChargeSrv()="+((HashMap)getBlngGrpDBChargeSrv()).toString());
			}
			}
				/******************Charge based service Exclusions*************************************************/
			if("BLNG_GRP_CHARGE_BASED_SERV_LIMIT".equals(tab)){
			blng_grp_code="";			
			fromDate="";
			pkg_serv_code="";
			prev_blng_grp_code="";			
			prev_fromDate="";
			prev_pkg_serv_code="";
			ArrayList blng_grp_charge_srv_excl_list=new ArrayList();
			HashMap blng_grp_charge_srv_excl=getBlngGrpChargeSrvExcl();
			sqlStr ="SELECT   a.blng_grp_id blng_grp_id,TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date,a.pkg_serv_code pkg_serv_code, a.excl_serv_code excl_serv_code,b.short_desc service_desc, a.exclude_yn exclude_yn, qty_limit,a.split_allowed_yn, a.incl_home_medication_yn,bl_pharm_service_yn (language_id,excl_serv_ind,excl_serv_code) enabledisparam,amt_limit FROM bl_package_excl_for_bg a, mm_item_lang_vw b WHERE a.operating_facility_id = ? AND a.package_code = ? AND a.rate_charge_ind = 'C' AND a.excl_serv_code = b.item_code AND b.language_id = ? AND a.blng_grp_id = ? AND a.eff_from_date =(SELECT MAX (c.eff_from_date) FROM bl_package_bg_period c WHERE c.operating_facility_id = a.operating_facility_id AND c.package_code = a.package_code AND c.blng_grp_id = a.blng_grp_id) GROUP BY a.blng_grp_id,eff_from_date,a.pkg_serv_code,a.excl_serv_code,b.short_desc,a.exclude_yn,qty_limit,a.split_allowed_yn,amt_limit ORDER BY 1, 2, 3";
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
				
			pstmt=connection.prepareStatement(sqlStr);			
			pstmt.setString(1,operating_facility_id);
			pstmt.setString(2,packageCode);								
			
			pstmt.setString(3,language_id);	
			pstmt.setString(4,blngGroupCode);			
					
			rs		= pstmt.executeQuery();
			
			while (rs!=null && rs.next()){
				record=new String[8];//Split reqd
				blng_grp_code=blngGroupCode;//rs.getString("cust_group_code")==null?"":rs.getString("cust_group_code");				
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
				if(!blng_grp_code.equals("") && !fromDate.equals("") && !pkg_serv_code.equals("")){
					if(blng_grp_code.equals(prev_blng_grp_code) && fromDate.equals(prev_fromDate) && pkg_serv_code.equals(prev_pkg_serv_code)){
					// add to old list.
						blng_grp_charge_srv_excl_list.add(record);												
					}else{
						if(blng_grp_charge_srv_excl_list!=null && blng_grp_charge_srv_excl_list.size()>0){
							blng_grp_charge_srv_excl.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),blng_grp_charge_srv_excl_list);								
						}
						blng_grp_charge_srv_excl_list=new ArrayList();
						blng_grp_charge_srv_excl_list.add(record);									
					}
					prev_blng_grp_code=blng_grp_code;					
					prev_fromDate=fromDate;
					prev_pkg_serv_code=pkg_serv_code;
				}  			
					
			}
			if(blng_grp_charge_srv_excl_list!=null && blng_grp_charge_srv_excl_list.size()>0){
				modified = "Y";
				blng_grp_charge_srv_excl.put(prev_blng_grp_code.trim()+"~~"+prev_fromDate.trim()+"~~"+prev_pkg_serv_code.trim(),blng_grp_charge_srv_excl_list);								
			}
			if(blng_grp_charge_srv_excl!=null && blng_grp_charge_srv_excl.size()>0){				
				setBlngGrpChargeSrvExcl(blng_grp_charge_srv_excl);								
			}
			}							
		}catch(Exception e){
			System.out.println("Exception e="+e);
			e.printStackTrace();
		}finally{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			ConnectionManager.returnConnection(connection);
		}
		return modified;
	}
	
	public Set<String> getPackageBlngGrpPeriod(String facilityId, String packageCode){
		Set<String> blngGrpPeriodSet = new HashSet<String>();
		Connection con = null;
		ResultSet rst = null;
		PreparedStatement pstmt = null;
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement("Select blng_grp_id blng_grp_id,TO_CHAR(EFF_FROM_DATE,'DD/MM/YYYY') eff_from_date from bl_package_bg_period where operating_facility_id = ? and package_code = ?");
			pstmt.setString(1, facilityId);
			pstmt.setString(2, packageCode);
			
			rst = pstmt.executeQuery();
			if(rst != null ){
				while(rst.next()){
					blngGrpPeriodSet.add(rst.getString("blng_grp_id")+"~~"+							
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
			if(pstmt!=null) pstmt.close();
			if(rst!=null) rst.close();
			ConnectionManager.returnConnection(con);
			}
			catch(Exception e)
			{
				System.out.println("Exception in getPackageBlngGrpPeriod:"+e);
				e.printStackTrace();
			}
		//Added against V210416 ends
		return blngGrpPeriodSet;
	}
	}
}
