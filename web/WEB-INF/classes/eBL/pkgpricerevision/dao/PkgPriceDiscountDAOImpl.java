/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
---------------------------------------------------------------------------------------------
SNo			Version     TFS ID		CRF/SCF     			Developer Name
---------------------------------------------------------------------------------------------
1      		V210624     19511		MMS-DM-CRF-118.9        Nandhini M
---------------------------------------------------------------------------------------------
*/
package eBL.pkgpricerevision.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import webbeans.eCommon.ConnectionManager;
import webbeans.op.CurrencyFormat;

import eBL.Common.BlRepository;
import eBL.pkgpricerevision.request.BulkUpdateBean;
import eBL.pkgpricerevision.request.PackagePriceBean;
import eBL.pkgpricerevision.request.PkgPriceRevisionRequest;
import eBL.pkgpricerevision.response.PkgPriceRevisionResponse;
/**
 * This file acts as the DAO Layer for the function Package price Discount Revision
 * This implements the Interface PkgpriceDiscountDAO.
 * It communicates with the Database layer to perform all DB calls for this function
 * @author Rajesh V
 *
 */
public class PkgPriceDiscountDAOImpl implements PkgPriceDiscountDAO{

	Connection con = null;
	PreparedStatement pstmt = null;
	CallableStatement cstmt = null;
	ResultSet rst = null;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public PkgPriceRevisionResponse basePriceRevision(
			PkgPriceRevisionRequest priceRevisionRequest) {
		PkgPriceRevisionResponse priceRevisionResponse = new PkgPriceRevisionResponse();
		List<PackagePriceBean> priceList = new ArrayList<PackagePriceBean>();
		try{
			PackagePriceBean priceBean = null;
			con = ConnectionManager.getConnection();
			/*Added for Getting the Decimal Places*/
			String getNoOfDecimal = "select nvl(no_of_decimal,2) no_of_decimal from sm_acc_entity_param";
			int noOfDecimal = 0;
			pstmt = con.prepareStatement(getNoOfDecimal);
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					noOfDecimal = rst.getInt("no_of_decimal");
				}
			}
			pstmt = null;
			rst = null;
			/*Added for Getting the Decimal Places*/
			String select = "select rownum rnum,a.package_code,c.short_desc,a.BLNG_CLASS_CODE,a.factor_rate,a.factor_rate_ind,to_char(a.eff_from_date,'dd/mm/yyyy') eff_from_date,TO_CHAR (b.eff_to_date, 'dd/mm/yyyy') eff_to_date, b.ADDL_CHG_RULE_CODE "; //Added by nandhini against 21208
			String sql = "from bl_package_base_price a, bl_package_period b, bl_package  c "+
					    "where  a.package_code = b.package_code "+
					   " and a.package_code = c.package_code "+
					    "and   a.eff_from_date = b.eff_from_date "+
					    "and a.operating_facility_id = b.operating_facility_id "+
					    "and a.operating_facility_id = c.operating_facility_id "+
					    "and a.operating_facility_id = ? ";
					   // " AND ( b.eff_to_date IS NULL  OR b.eff_to_date > SYSDATE) ";
			
			if(!"".equals(priceRevisionRequest.getPkgCode()) && !"**".equals(priceRevisionRequest.getPkgCode())){
				sql = sql+" and b.package_code = '"+priceRevisionRequest.getPkgCode()+"'";
			}
			
			if(!"".equals(priceRevisionRequest.getBlngClassCode()) && !"ALL".equals(priceRevisionRequest.getBlngClassCode())){
				sql = sql+" and a.BLNG_CLASS_CODE = '"+priceRevisionRequest.getBlngClassCode()+"'";
			}
			String countSql = "select count(*) total_count "+sql;
			sql =  "Select * from ( "+select+sql +" order by a.eff_from_date ) where rnum between "+priceRevisionRequest.getStartFrom() +" and "+priceRevisionRequest.getEndWith();
			pstmt = con.prepareStatement(countSql);
			pstmt.setString(1,priceRevisionRequest.getFacilityId());
			rst = pstmt.executeQuery();
			if(rst != null && rst.next()){
				priceRevisionResponse.setTotalCount(rst.getInt("total_count"));
			}
			pstmt = null;
			rst = null;
			pstmt = con.prepareStatement(sql);
			//pstmt.setString(1, priceRevisionRequest.getPkgCode());
			pstmt.setString(1,priceRevisionRequest.getFacilityId());
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					priceBean = new PackagePriceBean();
					priceBean.setPkgCode(checkForNull(rst.getString("package_code")));
					priceBean.setPkgDesc(checkForNull(rst.getString("short_desc")));
					priceBean.setBlngClassCode(checkForNull(rst.getString("BLNG_CLASS_CODE")));
					priceBean.setCurrentPriceValue(CurrencyFormat.formatCurrency(checkForNull(rst.getString("factor_rate")), noOfDecimal) );
					priceBean.setCurrentPriceType(checkForNull(rst.getString("factor_rate_ind")));
					priceBean.setEffectiveFrom(checkForNull(rst.getString("eff_from_date")));
					priceBean.setEffectiveTo(checkForNull(rst.getString("eff_to_date")));
					priceBean.setVatInd(checkForNull(rst.getString("ADDL_CHG_RULE_CODE")));//Added by nandhini against 21208
					priceList.add(priceBean);
				}
			}
			priceRevisionResponse.setPriceList(priceList);
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in basePriceRevision ->"+e);			
		}
		finally{
			//pstmt = null;
			//rst = null;
			try{//added against checkstyle
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception in basePriceRevision:"+e);
		}
		//added against checkstyle
		return priceRevisionResponse;
	}
			}

	
	public PkgPriceRevisionResponse custPriceRevision(
			PkgPriceRevisionRequest priceRevisionRequest) {
		PkgPriceRevisionResponse priceRevisionResponse = new PkgPriceRevisionResponse();
		List<PackagePriceBean> priceList = new ArrayList<PackagePriceBean>();
		try{
			PackagePriceBean priceBean = null;
			con = ConnectionManager.getConnection();
			/*Added for Getting the Decimal Places*/
			String getNoOfDecimal = "select nvl(no_of_decimal,2) no_of_decimal from sm_acc_entity_param";
			int noOfDecimal = 0;
			pstmt = con.prepareStatement(getNoOfDecimal);
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					noOfDecimal = rst.getInt("no_of_decimal");
				}
			}
			pstmt = null;
			rst = null;
			/*Added for Getting the Decimal Places*/
			
			String select =  "select rownum rnum,a.package_code,c.short_desc,a.cust_group_code,a.cust_code,a.BLNG_CLASS_CODE,a.factor_rate,a.factor_rate_ind,to_char(a.eff_from_date,'dd/mm/yyyy') eff_from_date,TO_CHAR (b.eff_to_date, 'dd/mm/yyyy') eff_to_date ,b.ADDL_CHG_RULE_CODE  ";//added by Nandhini
			
			String sql = "from bl_package_cust_price a, bl_package_cust_period b, bl_package  c "+
					    "where  a.package_code = b.package_code "+
					   " and a.package_code = c.package_code "+
					    "and   a.eff_from_date = b.eff_from_date "+
					    "and   a.cust_group_code = b.cust_group_code "+
					    "and   a.cust_code = b.cust_code "+
					    "and a.operating_facility_id = b.operating_facility_id "+
					    "and a.operating_facility_id = c.operating_facility_id "+
					    "and   a.operating_facility_id = ? ";
					    //" AND ( b.eff_to_date IS NULL  OR b.eff_to_date > SYSDATE) ";
			
			if(!"".equals(priceRevisionRequest.getPkgCode()) && !"**".equals(priceRevisionRequest.getPkgCode())){
				sql = sql+" and b.package_code = '"+priceRevisionRequest.getPkgCode()+"'";
			}
			
			if(!"".equals(priceRevisionRequest.getBlngClassCode()) && !"ALL".equals(priceRevisionRequest.getBlngClassCode())){
				sql = sql+" and a.BLNG_CLASS_CODE = '"+priceRevisionRequest.getBlngClassCode()+"'";
			}
			if(!"".equals(priceRevisionRequest.getCustGroupCode()) && !"**".equals(priceRevisionRequest.getCustGroupCode())){
				sql = sql+" and a.cust_group_code = '"+priceRevisionRequest.getCustGroupCode()+"'";
			}
			if(!"".equals(priceRevisionRequest.getCustCode()) && !"**".equals(priceRevisionRequest.getCustCode())){
				sql = sql+" and a.cust_code = '"+priceRevisionRequest.getCustCode()+"'";
			}
			String countSql = "select count(*) total_count "+sql;
			sql =  "Select * from ( "+select+sql +" order by a.cust_group_code,a.cust_code,a.eff_from_date ) where rnum between "+priceRevisionRequest.getStartFrom() +" and "+priceRevisionRequest.getEndWith();
			pstmt = con.prepareStatement(countSql);
			pstmt.setString(1,priceRevisionRequest.getFacilityId());
			rst = pstmt.executeQuery();
			if(rst != null && rst.next()){
				priceRevisionResponse.setTotalCount(rst.getInt("total_count"));
			}
			pstmt = null;
			rst = null;
			pstmt = con.prepareStatement(sql);

			//pstmt.setString(1, priceRevisionRequest.getPkgCode());
			pstmt.setString(1,priceRevisionRequest.getFacilityId());
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					priceBean = new PackagePriceBean();
					priceBean.setPkgCode(checkForNull(rst.getString("package_code")));
					priceBean.setPkgDesc(checkForNull(rst.getString("short_desc")));
					priceBean.setCustGroupCode(checkForNull(rst.getString("cust_group_code")));
					priceBean.setCustCode(checkForNull(rst.getString("cust_code")));
					priceBean.setBlngClassCode(checkForNull(rst.getString("BLNG_CLASS_CODE")));
					priceBean.setCurrentPriceValue(CurrencyFormat.formatCurrency(checkForNull(rst.getString("factor_rate")),noOfDecimal));
					priceBean.setCurrentPriceType(checkForNull(rst.getString("factor_rate_ind")));
					priceBean.setEffectiveFrom(checkForNull(rst.getString("eff_from_date")));
					priceBean.setEffectiveTo(checkForNull(rst.getString("eff_to_date")));
					priceBean.setVatInd(checkForNull(rst.getString("ADDL_CHG_RULE_CODE")));//added by Nandhini against 21280
					priceList.add(priceBean);
				}
			}
			priceRevisionResponse.setPriceList(priceList);
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in basePriceRevision ->"+e);			
		}
		finally{
			//pstmt = null;
			//rst = null;
			try{//added against checkstyle
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception in custPriceRevision:"+e);
			}
		//added against checkstyle
		return priceRevisionResponse;
		}
	}

	
	public PkgPriceRevisionResponse baseDiscountRevision(
			PkgPriceRevisionRequest priceRevisionRequest) {
		PkgPriceRevisionResponse priceRevisionResponse = new PkgPriceRevisionResponse();
		List<PackagePriceBean> discountList = new ArrayList<PackagePriceBean>();
		try{
			PackagePriceBean discountBean = null;
			con = ConnectionManager.getConnection();
			String select =   "select rownum rnum,a.package_code,c.short_desc,a.BLNG_CLASS_CODE,a.blng_grp_id, "+
							" a.discount_type,a.discount,to_char(a.eff_from_date,'dd/mm/yyyy') eff_from_date,to_char(a.eff_to_date,'dd/mm/yyyy') eff_to_date  ";

			String sql = " from bl_package_discount a, bl_package  c "+
					    "where a.package_code = c.package_code "+
					    "and a.operating_facility_id = c.operating_facility_id "+
					    "and  a.operating_facility_id = ? ";
					    //" AND (a.eff_to_date IS NULL OR a.eff_to_date > SYSDATE) ";
			
			if(!"".equals(priceRevisionRequest.getPkgCode()) && !"**".equals(priceRevisionRequest.getPkgCode())){
				sql = sql+" and c.package_code = '"+priceRevisionRequest.getPkgCode()+"'";
			}
			
			if(!"".equals(priceRevisionRequest.getBlngClassCode()) && !"ALL".equals(priceRevisionRequest.getBlngClassCode())){
				sql = sql+" and a.BLNG_CLASS_CODE = '"+priceRevisionRequest.getBlngClassCode()+"'";
			}
			if(!"".equals(priceRevisionRequest.getBlngGroupCode()) && !"ALL".equals(priceRevisionRequest.getBlngGroupCode())){
				sql = sql+" and a.blng_grp_id = '"+priceRevisionRequest.getBlngGroupCode()+"'";
			}
			String countSql = "select count(*) total_count "+sql;
			sql =  "Select * from ( "+select+sql +" order by a.blng_grp_id,a.eff_from_date ) where rnum between "+priceRevisionRequest.getStartFrom() +" and "+priceRevisionRequest.getEndWith();
			pstmt = con.prepareStatement(countSql);
			pstmt.setString(1,priceRevisionRequest.getFacilityId());
			rst = pstmt.executeQuery();
			if(rst != null && rst.next()){
				priceRevisionResponse.setTotalCount(rst.getInt("total_count"));
			}
			pstmt = null;
			rst = null;			
			pstmt = con.prepareStatement(sql);
			//pstmt.setString(1, priceRevisionRequest.getPkgCode());
			pstmt.setString(1,priceRevisionRequest.getFacilityId());
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					discountBean = new PackagePriceBean();
					discountBean.setPkgCode(checkForNull(rst.getString("package_code")));
					discountBean.setPkgDesc(checkForNull(rst.getString("short_desc")));
					discountBean.setBlngClassCode(checkForNull(rst.getString("BLNG_CLASS_CODE")));
					discountBean.setBlngGroupCode(checkForNull(rst.getString("blng_grp_id")));
					discountBean.setCurrentPriceType(checkForNull(rst.getString("discount_type")));
					discountBean.setCurrentPriceValue(checkForNull(rst.getString("discount")));
					discountBean.setEffectiveFrom(checkForNull(rst.getString("eff_from_date")));
					discountBean.setEffectiveTo(checkForNull(rst.getString("eff_to_date")));
					discountList.add(discountBean);
				}
			}
			priceRevisionResponse.setPriceList(discountList);
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in basePriceRevision ->"+e);			
		}
		finally{
			//pstmt = null;
			//rst = null;
			try{ //added against checkstyle
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception in baseDiscountRevision:"+e);
			}
		//added against checkstyle
		return priceRevisionResponse;
	}
}

	
	public PkgPriceRevisionResponse custDiscountRevision(
			PkgPriceRevisionRequest priceRevisionRequest) {
		PkgPriceRevisionResponse priceRevisionResponse = new PkgPriceRevisionResponse();
		List<PackagePriceBean> discountList = new ArrayList<PackagePriceBean>();
		try{
			PackagePriceBean discountBean = null;
			con = ConnectionManager.getConnection();
			String select =  "select rownum rnum,a.package_code,c.short_desc,a.cust_group_code,a.cust_code,a.BLNG_CLASS_CODE, "+
							"a.discount_type,a.discount,to_char(a.eff_from_date,'dd/mm/yyyy') eff_from_date,to_char(a.eff_to_date,'dd/mm/yyyy') eff_to_date ";
					
			String sql = 	"from bl_package_cust_discount a, bl_package  c "+
					    "where  a.package_code = c.package_code "+		
					    "and a.operating_facility_id = c.operating_facility_id "+
					    "and  a.operating_facility_id = ? ";					   
					    //" AND (a.eff_to_date IS NULL OR a.eff_to_date > SYSDATE) ";
			
			if(!"".equals(priceRevisionRequest.getPkgCode()) && !"**".equals(priceRevisionRequest.getPkgCode())){
				sql = sql+" and c.package_code = '"+priceRevisionRequest.getPkgCode()+"'";
			}
			if(!"".equals(priceRevisionRequest.getBlngClassCode())  && !"ALL".equals(priceRevisionRequest.getBlngClassCode())){
				sql = sql+" and a.BLNG_CLASS_CODE = '"+priceRevisionRequest.getBlngClassCode()+"'";
			}
			if(!"".equals(priceRevisionRequest.getCustGroupCode())  && !"**".equals(priceRevisionRequest.getCustGroupCode())){
				sql = sql+" and a.cust_group_code = '"+priceRevisionRequest.getCustGroupCode()+"'";
			}
			if(!"".equals(priceRevisionRequest.getCustCode())  && !"**".equals(priceRevisionRequest.getCustCode())){
				sql = sql+" and a.cust_code = '"+priceRevisionRequest.getCustCode()+"'";
			}
			//MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020 start
			if(!"".equals(priceRevisionRequest.getPolicyCode())  && !"**".equals(priceRevisionRequest.getPolicyCode())){
				sql = sql+" and a.POLICY_TYPE_CODE = '"+priceRevisionRequest.getPolicyCode()+"'";
			}
			//MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020 end
			String countSql = "select count(*) total_count "+sql;
			sql =  "Select * from ( "+select+sql +" order by a.cust_group_code,a.cust_code,a.eff_from_date ) where rnum between "+priceRevisionRequest.getStartFrom() +" and "+priceRevisionRequest.getEndWith();
			pstmt = con.prepareStatement(countSql);
			pstmt.setString(1,priceRevisionRequest.getFacilityId());
			rst = pstmt.executeQuery();
			if(rst != null && rst.next()){
				priceRevisionResponse.setTotalCount(rst.getInt("total_count"));
			}
			pstmt = null;
			rst = null;
			pstmt = con.prepareStatement(sql);
			//pstmt.setString(1, priceRevisionRequest.getPkgCode());
			pstmt.setString(1,priceRevisionRequest.getFacilityId());
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					discountBean = new PackagePriceBean();
					discountBean.setPkgCode(checkForNull(rst.getString("package_code")));
					discountBean.setPkgDesc(checkForNull(rst.getString("short_desc")));
					discountBean.setCustGroupCode(checkForNull(rst.getString("cust_group_code")));
					discountBean.setCustCode(checkForNull(rst.getString("cust_code")));
					discountBean.setBlngClassCode(checkForNull(rst.getString("BLNG_CLASS_CODE")));
					discountBean.setCurrentPriceType(checkForNull(rst.getString("discount_type")));
					discountBean.setCurrentPriceValue(checkForNull(rst.getString("discount")));
					discountBean.setEffectiveFrom(checkForNull(rst.getString("eff_from_date")));
					discountBean.setEffectiveTo(checkForNull(rst.getString("eff_to_date")));
					discountList.add(discountBean);
				}
			}
			priceRevisionResponse.setPriceList(discountList);
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in basePriceRevision ->"+e);			
		}
		finally{
			//pstmt = null;
			//rst = null;
			try{
				if(pstmt!=null) pstmt.close();//added against checkstyle
				if(rst!=null) rst.close();//added against checkstyle
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception in custDiscountRevision :"+e);
			}
		return priceRevisionResponse;
	}
			}

	private String checkForNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}

	
	public PkgPriceRevisionResponse insertPkgDiscountInd(
			PkgPriceRevisionRequest priceRevisionRequest)  {
		PkgPriceRevisionResponse pkgResponse = new PkgPriceRevisionResponse();
		if(priceRevisionRequest.getPriceRevision() == null){
			priceRevisionRequest.setPriceRevision(new ArrayList<PackagePriceBean>());
		}
		
		if(priceRevisionRequest.getDiscountRevision() == null){
			priceRevisionRequest.setDiscountRevision(new ArrayList<PackagePriceBean>());
		}
		
		List<PackagePriceBean> priceRevision = priceRevisionRequest.getPriceRevision();
		List<PackagePriceBean> discountRevision = priceRevisionRequest.getDiscountRevision();
		List<String> error = new ArrayList<String>();
		int rowsInserted = 0;
		try{
			con = ConnectionManager.getConnection();
			//Inserting Price Revision
			for(PackagePriceBean bean:priceRevision){
				/* PkgCode should not be Null/Empty */
				if(!"".equals(bean.getPkgCode())){
					cstmt = con.prepareCall(BlRepository.getBlKeyValue("INSERT_PKG_UPD_REQ"));
					rowsInserted++;
					cstmt.setString(1, priceRevisionRequest.getFacilityId());
					cstmt.setString(2, priceRevisionRequest.getSessionId());
					cstmt.setString(3, priceRevisionRequest.getPgmDate());
					cstmt.setString(4, priceRevisionRequest.getUserId());
					cstmt.setString(5, bean.getPkgCode());
					cstmt.setString(6, bean.getCustGroupCode());
					cstmt.setString(7, bean.getCustCode());
					cstmt.setString(8, bean.getBlngClassCode());
					cstmt.setString(9, bean.getBlngGroupCode());
					if((bean.getEffectiveFrom() == null) || ("".equals(bean.getEffectiveFrom()))){
						cstmt.setString(10, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(bean.getEffectiveFrom()).getTime());
						cstmt.setDate(10, fromDt);
					}
					if((bean.getEffectiveTo() == null) || ("".equals(bean.getEffectiveTo()))){
						cstmt.setString(11, null);
					}
					else{
						Date toDt = new Date(sdf.parse(bean.getEffectiveTo()).getTime());
						cstmt.setDate(11, toDt);
					}
				
					if(bean.getPackagePrice()  == "R"){
						cstmt.setString(12, null);
					}else{
						cstmt.setString(12, "R");
					}
					cstmt.setString(13, bean.getRevisedPriceType());						
					cstmt.setString(14, "N");
					cstmt.setString(15, null);
					cstmt.setString(16, bean.getRevisedPriceValue());
					cstmt.setString(17, "N");
					//MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020 start
					cstmt.setString(18, null); 
					cstmt.setString(19, null);
					cstmt.setString(20, null);
					//MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020 end
					//MMS-DM-CRF-118.9 starts
						cstmt.setString(21, bean.getPackagePrice());
						cstmt.setString(22, bean.getVAT());
						cstmt.setString(23, bean.getVatApplicable());
						cstmt.setString(24, bean.getVatRule());
						cstmt.setString(25, bean.getRuleCoverage());
						//MMS-DM-CRF-118.9 ends.
					cstmt.execute();
				}
			}
			
			//Inserting Bulk Data for Discount
			for(PackagePriceBean bean:discountRevision){
				if(!"".equals(bean.getPkgCode())){
					cstmt = con.prepareCall(BlRepository.getBlKeyValue("INSERT_PKG_UPD_REQ"));
					System.err.println("The Params to Insert -> ");
					System.err.println(priceRevisionRequest.getFacilityId());
					System.err.println(priceRevisionRequest.getSessionId());
					System.err.println(priceRevisionRequest.getPgmDate());
					System.err.println( priceRevisionRequest.getUserId());
					System.err.println(bean.getPkgCode());
					System.err.println(bean.getCustGroupCode());
					System.err.println(bean.getCustCode());
					System.err.println(bean.getBlngClassCode());
					System.err.println(bean.getBlngGroupCode());
					System.err.println(bean.getEffectiveFrom());
					System.err.println(bean.getEffectiveTo());
					System.err.println("D");
					System.err.println(bean.getRevisedPriceType());						
					System.err.println("N");
					System.err.println("null");
					System.err.println(bean.getRevisedPriceValue());
					System.err.println("N");
					//MMS-DM-CRF-118.9 starts
						System.err.println(bean.getPackagePrice());
						System.err.println(bean.getVAT());
						System.err.println(bean.getVatApplicable());
						System.err.println(bean.getVatRule());
						System.err.println(bean.getRuleCoverage());
						//MMS-DM-CRF-118.9 ends
					rowsInserted++;
					cstmt.setString(1, priceRevisionRequest.getFacilityId());
					cstmt.setString(2, priceRevisionRequest.getSessionId());
					cstmt.setString(3, priceRevisionRequest.getPgmDate());
					cstmt.setString(4, priceRevisionRequest.getUserId());
					cstmt.setString(5, bean.getPkgCode());
					cstmt.setString(6, bean.getCustGroupCode());
					cstmt.setString(7, bean.getCustCode());
					cstmt.setString(8, bean.getBlngClassCode());
					cstmt.setString(9, bean.getBlngGroupCode());
					if((bean.getEffectiveFrom() == null) || ("".equals(bean.getEffectiveFrom()))){
						cstmt.setString(10, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(bean.getEffectiveFrom()).getTime());
						cstmt.setDate(10, fromDt);
					}
					if((bean.getEffectiveTo() == null) || ("".equals(bean.getEffectiveTo()))){
						cstmt.setString(11, null);
					}
					else{
						Date toDt = new Date(sdf.parse(bean.getEffectiveTo()).getTime());
						cstmt.setDate(11, toDt);
					}
					cstmt.setString(12, "D");
					cstmt.setString(13, bean.getRevisedPriceType());						
					cstmt.setString(14, "N");
					cstmt.setString(15, null);
					cstmt.setString(16, bean.getRevisedPriceValue());
					cstmt.setString(17, "N");
					//MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020 start
					cstmt.setString(18, null);
					cstmt.setString(19, null);
					cstmt.setString(20, null);
					//MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020 end
					//MMS-DM-CRF-118.9 starts
						cstmt.setString(21, bean.getPackagePrice());
						cstmt.setString(22, bean.getVAT());
						cstmt.setString(23, bean.getVatApplicable());
						cstmt.setString(24, bean.getVatRule());
						cstmt.setString(25, bean.getRuleCoverage());
						//MMS-DM-CRF-118.9 ends.
					cstmt.execute();
				}
				//MMS-DM-CRF-118.9 starts
			}
			int count = checkOverlapFlag(priceRevisionRequest, con);
			pkgResponse.setRowsInserted(rowsInserted);
			pkgResponse.setTotalCount(count);
			pkgResponse.setError(error);
			pkgResponse.setStatus(true);
			con.commit();
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in insertPkgDiscountInd ->"+e);
			pkgResponse.setStatus(false);
			error.add(e.toString());
			pkgResponse.setError(error);
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				System.err.println("Exception in insertPkgDiscountInd ->"+e1);
			}
		}
		finally{
			ConnectionManager.returnConnection(con);
		}
		return pkgResponse;
	}

	
	public PkgPriceRevisionResponse insertPkgDiscountBulk(
			PkgPriceRevisionRequest priceRevisionRequest) {
		PkgPriceRevisionResponse pkgResponse = new PkgPriceRevisionResponse();
		if(priceRevisionRequest.getBulkUpdateDiscount() == null){
			priceRevisionRequest.setBulkUpdateDiscount(new ArrayList<BulkUpdateBean>());
		}
		
		if(priceRevisionRequest.getBulkUpdatePrice() == null){
			priceRevisionRequest.setBulkUpdatePrice(new ArrayList<BulkUpdateBean>());
		}
		
		List<BulkUpdateBean> bulkUpdatePrice = priceRevisionRequest.getBulkUpdatePrice();
		List<BulkUpdateBean> bulkUpdateDiscount = priceRevisionRequest.getBulkUpdateDiscount();
		List<String> error = new ArrayList<String>();
		int rowsInserted = 0;
		try{
			con = ConnectionManager.getConnection();
			//Inserting Bulk Data for Price
			//if("Y".equals(priceRevisionRequest.getPriceBulkUpdateFlag())){
				for(BulkUpdateBean bean:bulkUpdatePrice){
					if(!"".equals(bean.getPkgPriceDiscType())){
						cstmt = con.prepareCall(BlRepository.getBlKeyValue("INSERT_PKG_UPD_REQ"));
						System.err.println("The Params to Insert -> ");
						System.err.println(priceRevisionRequest.getFacilityId());
						System.err.println(priceRevisionRequest.getSessionId());
						System.err.println(priceRevisionRequest.getPgmDate());
						System.err.println( priceRevisionRequest.getUserId());
						System.err.println(priceRevisionRequest.getPkgCode());
						System.err.println(priceRevisionRequest.getCustGroupCode());
						System.err.println(priceRevisionRequest.getCustCode());
						System.err.println(priceRevisionRequest.getBlngClassCode());
						System.err.println(priceRevisionRequest.getBlngGroupCode());
						System.err.println(bean.getEffectiveFrom());
						System.err.println(bean.getEffectiveTo());
						System.err.println("R");
						System.err.println(bean.getPkgPriceDiscType());						
						System.err.println(bean.getMarkUpDown());
						System.err.println( bean.getRoundOff());
						System.err.println(bean.getPkgPriceDiscValue());
						System.err.println(bean.getRndMarkUpDown());
						//MMS-DM-CRF-118.9 starts
						System.err.println("pkgprice-->"+bean.getPackagePrice());
						System.err.println("VAT-->"+bean.getVAT());
						System.err.println("VATapp-->"+bean.getVatApplicable());
						System.err.println("VATrule-->"+bean.getVatRule());
						System.err.println("rulecov-->"+bean.getRuleCoverage());
						//MMS-DM-CRF-118.9 ends
						rowsInserted++;
						cstmt.setString(1, priceRevisionRequest.getFacilityId());
						cstmt.setString(2, priceRevisionRequest.getSessionId());
						cstmt.setString(3, priceRevisionRequest.getPgmDate());
						cstmt.setString(4, priceRevisionRequest.getUserId());
						cstmt.setString(5, priceRevisionRequest.getPkgCode());
						cstmt.setString(6, priceRevisionRequest.getCustGroupCode());
						cstmt.setString(7, priceRevisionRequest.getCustCode());
						cstmt.setString(8, priceRevisionRequest.getBlngClassCode());
						cstmt.setString(9, priceRevisionRequest.getBlngGroupCode());
						if((bean.getEffectiveFrom() == null) || ("".equals(bean.getEffectiveFrom()))){
							cstmt.setString(10, null);
						}
						else{
							Date fromDt = new Date(sdf.parse(bean.getEffectiveFrom()).getTime());
							cstmt.setDate(10, fromDt);
						}						
						if((bean.getEffectiveTo() == null) || ("".equals(bean.getEffectiveTo()))){
							cstmt.setString(11, null);
						}
						else{
							Date toDt = new Date(sdf.parse(bean.getEffectiveTo()).getTime());
							cstmt.setDate(11, toDt);
						}
						if(bean.getPackagePrice()  == "R"){
							cstmt.setString(12, null);
						}else{
							cstmt.setString(12, "R");
						}
						cstmt.setString(13, bean.getPkgPriceDiscType());						
						cstmt.setString(14, bean.getMarkUpDown());
						cstmt.setString(15, bean.getRoundOff());
						cstmt.setString(16, bean.getPkgPriceDiscValue());
						cstmt.setString(17, bean.getRndMarkUpDown());
						//MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020 start
						cstmt.setString(18, null);
						cstmt.setString(19, null);
						cstmt.setString(20, priceRevisionRequest.getPolicyCode());
						//MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020 end
						//MMS-DM-CRF-118.9 starts
						cstmt.setString(21, bean.getPackagePrice());
						cstmt.setString(22, bean.getVAT());
						cstmt.setString(23, bean.getVatApplicable());
						cstmt.setString(24, bean.getVatRule());
						cstmt.setString(25, bean.getRuleCoverage());
						//MMS-DM-CRF-118.9 ends.
						cstmt.execute();
					}					
					/* MMS-DM-CRF-118.9 starts, If PkgPriceDiscType value is NULL  */
					else{
						System.err.println("inside PkgPriceDiscType");
						cstmt = con.prepareCall(BlRepository.getBlKeyValue("INSERT_PKG_UPD_REQ"));
						System.err.println("The Params to Insert -> ");
						System.err.println(priceRevisionRequest.getFacilityId());
						System.err.println(priceRevisionRequest.getSessionId());
						System.err.println(priceRevisionRequest.getPgmDate());
						System.err.println( priceRevisionRequest.getUserId());
						System.err.println(priceRevisionRequest.getPkgCode());
						System.err.println(priceRevisionRequest.getCustGroupCode());
						System.err.println(priceRevisionRequest.getCustCode());
						System.err.println(priceRevisionRequest.getBlngClassCode());
						System.err.println(priceRevisionRequest.getBlngGroupCode());
						System.err.println(bean.getEffectiveFrom());
						System.err.println(bean.getEffectiveTo());
						System.err.println("R");
						System.err.println(bean.getPkgPriceDiscType());						
						System.err.println(bean.getMarkUpDown());
						System.err.println( bean.getRoundOff());
						System.err.println(bean.getPkgPriceDiscValue());
						System.err.println(bean.getRndMarkUpDown());
						//MMS-DM-CRF-118.9 starts
						System.err.println("pkgprice-->"+bean.getPackagePrice());
						System.err.println("VAT-->"+bean.getVAT());
						System.err.println("VATapp-->"+bean.getVatApplicable());
						System.err.println("VATrule-->"+bean.getVatRule());
						System.err.println("rulecov-->"+bean.getRuleCoverage());
						//MMS-DM-CRF-118.9 ends
						rowsInserted++;
						cstmt.setString(1, priceRevisionRequest.getFacilityId());
						cstmt.setString(2, priceRevisionRequest.getSessionId());
						cstmt.setString(3, priceRevisionRequest.getPgmDate());
						cstmt.setString(4, priceRevisionRequest.getUserId());
						cstmt.setString(5, priceRevisionRequest.getPkgCode());
						cstmt.setString(6, priceRevisionRequest.getCustGroupCode());
						cstmt.setString(7, priceRevisionRequest.getCustCode());
						cstmt.setString(8, priceRevisionRequest.getBlngClassCode());
						cstmt.setString(9, priceRevisionRequest.getBlngGroupCode());
						if((bean.getEffectiveFrom() == null) || ("".equals(bean.getEffectiveFrom()))){
							cstmt.setString(10, null);
						}
						else{
							Date fromDt = new Date(sdf.parse(bean.getEffectiveFrom()).getTime());
							cstmt.setDate(10, fromDt);
						}						
						if((bean.getEffectiveTo() == null) || ("".equals(bean.getEffectiveTo()))){
							cstmt.setString(11, null);
						}
						else{
							Date toDt = new Date(sdf.parse(bean.getEffectiveTo()).getTime());
							cstmt.setDate(11, toDt);
						}
						if(bean.getPackagePrice()  == "R"){
							cstmt.setString(12, null);
						}else{
							cstmt.setString(12, "R");
						}
						cstmt.setString(13, bean.getPkgPriceDiscType());						
						cstmt.setString(14, bean.getMarkUpDown());
						cstmt.setString(15, bean.getRoundOff());
						cstmt.setString(16, bean.getPkgPriceDiscValue());
						cstmt.setString(17, bean.getRndMarkUpDown());
						//MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020 start
						cstmt.setString(18, null);
						cstmt.setString(19, null);
						cstmt.setString(20, priceRevisionRequest.getPolicyCode());
						//MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020 end
						//MMS-DM-CRF-118.9 starts						
						cstmt.setString(21, bean.getPackagePrice());
						cstmt.setString(22, bean.getVAT());
						cstmt.setString(23, bean.getVatApplicable());
						cstmt.setString(24, bean.getVatRule());
						cstmt.setString(25, bean.getRuleCoverage());
						//MMS-DM-CRF-118.9 ends.
						cstmt.execute();			
						
					}//MMS-DM-CRF-118.9 ends.
				}
			//}
			
			//Inserting Bulk Data for Discount
			//if("Y".equals(priceRevisionRequest.getPriceBulkUpdateFlag())){
				for(BulkUpdateBean bean:bulkUpdateDiscount){
					if(!"".equals(bean.getPkgPriceDiscType())){
						cstmt = con.prepareCall(BlRepository.getBlKeyValue("INSERT_PKG_UPD_REQ"));
						System.err.println("The Params to Insert -> ");
						System.err.println(priceRevisionRequest.getFacilityId());
						System.err.println(priceRevisionRequest.getSessionId());
						System.err.println(priceRevisionRequest.getPgmDate());
						System.err.println( priceRevisionRequest.getUserId());
						System.err.println(priceRevisionRequest.getPkgCode());
						System.err.println(priceRevisionRequest.getCustGroupCode());
						System.err.println(priceRevisionRequest.getCustCode());
						System.err.println(priceRevisionRequest.getBlngClassCode());
						System.err.println(priceRevisionRequest.getBlngGroupCode());
						System.err.println(bean.getEffectiveFrom());
						System.err.println(bean.getEffectiveTo());
						System.err.println("D");
						System.err.println(bean.getPkgPriceDiscType());						
						System.err.println(bean.getMarkUpDown());
						System.err.println( bean.getRoundOff());
						System.err.println(bean.getPkgPriceDiscValue());
						System.err.println(bean.getRndMarkUpDown());
						//MMS-DM-CRF-118.9 starts
						System.err.println(bean.getPackagePrice());
						System.err.println(bean.getVAT());
						System.err.println(bean.getVatApplicable());
						System.err.println(bean.getVatRule());
						System.err.println(bean.getRuleCoverage());
						//MMS-DM-CRF-118.9 ends
						rowsInserted++;
						cstmt.setString(1, priceRevisionRequest.getFacilityId());
						cstmt.setString(2, priceRevisionRequest.getSessionId());
						cstmt.setString(3, priceRevisionRequest.getPgmDate());
						cstmt.setString(4, priceRevisionRequest.getUserId());
						cstmt.setString(5, priceRevisionRequest.getPkgCode());
						cstmt.setString(6, priceRevisionRequest.getCustGroupCode());
						cstmt.setString(7, priceRevisionRequest.getCustCode());
						cstmt.setString(8, priceRevisionRequest.getBlngClassCode());
						cstmt.setString(9, priceRevisionRequest.getBlngGroupCode());
						if((bean.getEffectiveFrom() == null) || ("".equals(bean.getEffectiveFrom()))){
							cstmt.setString(10, null);
						}
						else{
							Date fromDt = new Date(sdf.parse(bean.getEffectiveFrom()).getTime());
							cstmt.setDate(10, fromDt);
						}
						if((bean.getEffectiveTo() == null) || ("".equals(bean.getEffectiveTo()))){
							cstmt.setString(11, null);
						}
						else{
							Date toDt = new Date(sdf.parse(bean.getEffectiveTo()).getTime());
							cstmt.setDate(11, toDt);
						}
						cstmt.setString(12, "D");
						cstmt.setString(13, bean.getPkgPriceDiscType());						
						cstmt.setString(14, bean.getMarkUpDown());
						cstmt.setString(15, bean.getRoundOff());
						cstmt.setString(16, bean.getPkgPriceDiscValue());
						cstmt.setString(17, bean.getRndMarkUpDown());
						//MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020 start
						cstmt.setString(18, null);
						cstmt.setString(19, null);
						cstmt.setString(20, priceRevisionRequest.getPolicyCode());
						//MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020 end
						//MMS-DM-CRF-118.9 starts
						cstmt.setString(21, bean.getPackagePrice());
						cstmt.setString(22, bean.getVAT());
						cstmt.setString(23, bean.getVatApplicable());
						cstmt.setString(24, bean.getVatRule());
						cstmt.setString(25, bean.getRuleCoverage());
						//MMS-DM-CRF-118.9 ends.
						cstmt.execute();
					}
					//MMS-DM-CRF-118.9 starts
					else{
						System.err.println("inside 2");
						cstmt = con.prepareCall(BlRepository.getBlKeyValue("INSERT_PKG_UPD_REQ"));
						System.err.println("The Params to Insert -> ");
						System.err.println(priceRevisionRequest.getFacilityId());
						System.err.println(priceRevisionRequest.getSessionId());
						System.err.println(priceRevisionRequest.getPgmDate());
						System.err.println( priceRevisionRequest.getUserId());
						System.err.println(priceRevisionRequest.getPkgCode());
						System.err.println(priceRevisionRequest.getCustGroupCode());
						System.err.println(priceRevisionRequest.getCustCode());
						System.err.println(priceRevisionRequest.getBlngClassCode());
						System.err.println(priceRevisionRequest.getBlngGroupCode());
						System.err.println(bean.getEffectiveFrom());
						System.err.println(bean.getEffectiveTo());
						System.err.println("D");
						System.err.println(bean.getPkgPriceDiscType());						
						System.err.println(bean.getMarkUpDown());
						System.err.println( bean.getRoundOff());
						System.err.println(bean.getPkgPriceDiscValue());
						System.err.println(bean.getRndMarkUpDown());
						//MMS-DM-CRF-118.9 starts
						System.err.println(bean.getPackagePrice());
						System.err.println(bean.getVAT());
						System.err.println(bean.getVatApplicable());
						System.err.println(bean.getVatRule());
						System.err.println(bean.getRuleCoverage());
						//MMS-DM-CRF-118.9 ends
						rowsInserted++;
						cstmt.setString(1, priceRevisionRequest.getFacilityId());
						cstmt.setString(2, priceRevisionRequest.getSessionId());
						cstmt.setString(3, priceRevisionRequest.getPgmDate());
						cstmt.setString(4, priceRevisionRequest.getUserId());
						cstmt.setString(5, priceRevisionRequest.getPkgCode());
						cstmt.setString(6, priceRevisionRequest.getCustGroupCode());
						cstmt.setString(7, priceRevisionRequest.getCustCode());
						cstmt.setString(8, priceRevisionRequest.getBlngClassCode());
						cstmt.setString(9, priceRevisionRequest.getBlngGroupCode());
						if((bean.getEffectiveFrom() == null) || ("".equals(bean.getEffectiveFrom()))){
							cstmt.setString(10, null);
						}
						else{
							Date fromDt = new Date(sdf.parse(bean.getEffectiveFrom()).getTime());
							cstmt.setDate(10, fromDt);
						}
						if((bean.getEffectiveTo() == null) || ("".equals(bean.getEffectiveTo()))){
							cstmt.setString(11, null);
						}
						else{
							Date toDt = new Date(sdf.parse(bean.getEffectiveTo()).getTime());
							cstmt.setDate(11, toDt);
						}
						cstmt.setString(12, "D");
						cstmt.setString(13, bean.getPkgPriceDiscType());						
						cstmt.setString(14, bean.getMarkUpDown());
						cstmt.setString(15, bean.getRoundOff());
						cstmt.setString(16, bean.getPkgPriceDiscValue());
						cstmt.setString(17, bean.getRndMarkUpDown());
						//MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020 start
						cstmt.setString(18, null);
						cstmt.setString(19, null);
						cstmt.setString(20, priceRevisionRequest.getPolicyCode());
						//MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020 end
						//MMS-DM-CRF-118.9 starts
						cstmt.setString(21, bean.getPackagePrice());
						cstmt.setString(22, bean.getVAT());
						cstmt.setString(23, bean.getVatApplicable());
						cstmt.setString(24, bean.getVatRule());
						cstmt.setString(25, bean.getRuleCoverage());
						//MMS-DM-CRF-118.9 ends.
						cstmt.execute();
					
					}//MMS-DM-CRF-118.9 ends.
					}
				//}
			//}
			int count = checkOverlapFlag(priceRevisionRequest, con);
			pkgResponse.setTotalCount(count);
			pkgResponse.setRowsInserted(rowsInserted);
			pkgResponse.setError(error);
			pkgResponse.setStatus(true);
			con.commit();
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in insertPkgDiscountBulk ->"+e);
			pkgResponse.setStatus(false);
			error.add(e.toString());
			pkgResponse.setError(error);
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				System.err.println("Exception in insertPkgDiscountBulk ->"+e1);
			}
		}
		finally{
			ConnectionManager.returnConnection(con);
		}
		return pkgResponse;
	}
	
	
	public HashMap<String,String> generateSessionId(){
		HashMap<String,String> sessionidMap = new HashMap<String, String>();
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(BlRepository.getBlKeyValue("GET_SESSION_ID"));
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					sessionidMap.put("session_id", rst.getString("session_id"));
					sessionidMap.put("pgm_date", rst.getString("pgm_date"));
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in generateSessionId ->"+e);
		}
		finally{
			ConnectionManager.returnConnection(con);
			//pstmt = null;
			//rst = null;
			//added against checkstyle
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println("Exception in checkOverlapFlag ->"+e);
			}
		//added against checkstyle
		return sessionidMap;
	}
	}
	
	public int checkOverlapFlag(PkgPriceRevisionRequest priceRevisionRequest,Connection conn){
		int count = 0;
		try{
			pstmt = conn.prepareStatement(BlRepository.getBlKeyValue("CHECK_OVERLAP_FLAG"));
			pstmt.setString(1, priceRevisionRequest.getFacilityId());
			pstmt.setString(2, priceRevisionRequest.getSessionId());
			pstmt.setString(3, priceRevisionRequest.getPgmDate());
			rst = pstmt.executeQuery();
			if(rst != null && rst.next()){
				count = rst.getInt("total_count");
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in checkOverlapFlag ->"+e);
			count = 0;
		}
		finally{
			//pstmt = null;
			//rst = null;
			//added against checkstyle starts
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception in checkOverlapFlag:"+e);
			}
			//added against checkstyle ends.
		return count;
	}
	}
	
	
	public PkgPriceRevisionResponse populatePkgUpdateRequest(PkgPriceRevisionRequest priceRevisionRequest){
		PkgPriceRevisionResponse pkgResponse = new PkgPriceRevisionResponse();
		List<String> error = new ArrayList<String>();
		String str_error_level = "", str_sysmesage_id="", str_error_text="";
		String locale = "";
		Locale loc = null;
		ResourceBundle rb = null;
		try{
			locale = "en";
			loc = new Locale(locale);
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			con = ConnectionManager.getConnection();
			cstmt = con.prepareCall(BlRepository.getBlKeyValue("POPULATE_PKG_UPD_REQ"));
			System.err.println("The Params to Update -> ");
			System.err.println(priceRevisionRequest.getFacilityId());
			System.err.println(priceRevisionRequest.getSessionId());
			System.err.println(priceRevisionRequest.getPgmDate());
			System.err.println( priceRevisionRequest.getUserId());
			cstmt.setString(1, priceRevisionRequest.getFacilityId());
			cstmt.setString(2, priceRevisionRequest.getSessionId());
			cstmt.setString(3, priceRevisionRequest.getPgmDate());
			cstmt.setString(4, priceRevisionRequest.getUserId());
			cstmt.registerOutParameter(5, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
			cstmt.execute();
			str_error_level = cstmt.getString(5);
			str_sysmesage_id = cstmt.getString(6);
			str_error_text = cstmt.getString(7);
			if(str_error_level != null || str_error_text != null){
				error.add(str_error_text);
			}
			if(str_sysmesage_id!=null){
				try{
					String msg = rb.getString(str_sysmesage_id);
				}
				catch(Exception e){
					e.printStackTrace();
					error.add(str_sysmesage_id);
				}
			}
			if(error.size()>0){
				pkgResponse.setStatus(false);
				con.rollback();
			}
			else{
				pkgResponse.setStatus(true);
				con.commit();
			}
			pkgResponse.setError(error);
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in populatePkgUpdateRequest ->"+e);
			pkgResponse.setStatus(false);
			error.add("Internal Error "+e.toString());
			pkgResponse.setError(error);
			try{
				con.rollback();
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
			
		}
		finally{
			ConnectionManager.returnConnection(con);
			//pstmt = null;
			//rst = null;
			//added against checkstyle starts
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception in populatePkgUpdateRequest2:"+e);
			}
			//added against checkstyle ends
		return pkgResponse;
	}
	}
	
	public String getJobNumber(String sessionId, String pgmDate){
		String jobNumber = "";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("select distinct job_no from BL_PACKAGE_PRICE_UPDTN_REQ where session_id = ? and pgm_date = ? and job_no is not null");
			ps.setString(1, sessionId);
			ps.setString(2, pgmDate);
			rs = ps.executeQuery();
			if(rs != null && rs.next()){
				jobNumber = checkForNull(rs.getString("oracle_job_no"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in getJobNumber -> "+e);
		}
		finally{
			ConnectionManager.returnConnection(con);
			ps = null;
			rs = null;
		}
		return jobNumber;
	}
	
	public PkgPriceRevisionResponse getOverlapRecords(PkgPriceRevisionRequest priceRevisionRequest){
		PkgPriceRevisionResponse pkgresResponse = new PkgPriceRevisionResponse();
		List<PackagePriceBean> overlapList = new ArrayList<PackagePriceBean>();
		PackagePriceBean bean = null;
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(BlRepository.getBlKeyValue("GET_OVERLAP_RECORD"));
			pstmt.setString(1, priceRevisionRequest.getFacilityId());
			pstmt.setString(2, priceRevisionRequest.getSessionId());
			pstmt.setString(3, priceRevisionRequest.getPgmDate());
			
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					bean = new PackagePriceBean();
					bean.setPkgCode(rst.getString("package_code"));
					bean.setPkgDesc(rst.getString("package_code"));
					bean.setCustGroupCode(rst.getString("CUST_GROUP_CODE"));
					bean.setCustCode(rst.getString("CUST_CODE"));
					bean.setBlngClassCode(rst.getString("BLNG_CLASS_CODE"));
					bean.setBlngGroupCode(rst.getString("BLNG_GRP_ID"));
					bean.setEffectiveFrom(rst.getString("eff_from_date"));
					bean.setEffectiveTo(rst.getString("eff_to_date"));
					overlapList.add(bean);
				}
			}
			pkgresResponse.setPriceList(overlapList);
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Error in getOverlapRecords -> "+e);
		}
		finally{
			ConnectionManager.returnConnection(con);
			//pstmt = null;
			//rst = null;
			//added against checkstyle starts
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception in getOverlapRecords:"+e);
			}
			//added against checkstyle ends
		}
		return pkgresResponse;
	}
	
	
	public String checkBulkUpdateAccess(String userId, String facilityId){
		String access = "N";
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(BlRepository.getBlKeyValue("CHECK_BULK_UPD_ACCESS"));
			pstmt.setString(1, facilityId);
			pstmt.setString(2, userId);
			rst = pstmt.executeQuery();
			if(rst != null && rst.next()){
				access = "Y";
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in checkBulkUpdateAccess ->"+e);
			access = "N";
		}
		finally{
			ConnectionManager.returnConnection(con);
			//pstmt = null;
			//rst = null;
			try{//added against checkstyle starts
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception in checkBulkUpdateAccess:"+e);
			}
			//added against checkstyle ends
		return access;
	}
	}


	public String getPkgBackDate(String facilityId) {
		String backDays = "";
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(BlRepository.getBlKeyValue("GET_PKG_BACK_DATE"));
			pstmt.setString(1, facilityId);
			rst = pstmt.executeQuery();
			if(rst != null && rst.next()){
				backDays = rst.getString("PKG_EFF_FRM_BACKDATE_DAYS");
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in getPkgBackDate ->"+e);
			backDays = "0";
		}
		finally{
			ConnectionManager.returnConnection(con);
			//pstmt = null;
			//rst = null;
			try{//added against checkstyle starts
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception in getPkgBackDate:"+e);
			}//added against checkstyle ends
		return backDays;
	}
	}
	
	public String getPkgEffectiveDates(String pkgCode,String facilityId) {
		String retVal = "";
		try{
			con = ConnectionManager.getConnection();
			String sql = "Select to_char(eff_from_date,'dd/mm/yyyy') eff_from_date,TO_CHAR (eff_to_date, 'dd/mm/yyyy') eff_to_date,op_yn,em_yn,ip_yn,dc_yn  from bl_package where package_code = ? and operating_facility_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pkgCode);
			pstmt.setString(2, facilityId);
			rst = pstmt.executeQuery();
			if(rst != null && rst.next()){
				retVal = checkForNull(rst.getString("eff_from_date"))+":::"+checkForNull(rst.getString("eff_to_date"))+":::"+checkForNull(rst.getString("op_yn"))+":::"+checkForNull(rst.getString("em_yn"))+":::"+checkForNull(rst.getString("ip_yn"))+":::"+checkForNull(rst.getString("dc_yn"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in getPkgBackDate ->"+e);
			retVal = "";
		}
		finally{
			ConnectionManager.returnConnection(con);
			//pstmt = null;
			//rst = null;
			//added against checkstyle starts
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception in getPkgEffectiveDates:"+e);			
			}
			return retVal;
		//added against checkstyle ends
		}
	}
	
	public int getNoOfDecimal(){
		int noOfDec = 0;
		try{
			con = ConnectionManager.getConnection();
			String sql = "select nvl(no_of_decimal,2) no_of_decimal from sm_acc_entity_param";
			pstmt = con.prepareStatement(sql);
			rst = pstmt.executeQuery();
			if(rst != null ){
				while(rst.next()){
					noOfDec = rst.getInt("no_of_decimal");
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in getNoOfDecimal ->"+e);
			noOfDec = 0;
		}
		finally{
			ConnectionManager.returnConnection(con);
			//pstmt = null;
			//rst = null;
			//added against checkstyle starts
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception in getNoOfDecimal:"+e);
			}
		//added against checkstyle ends
		return noOfDec;
	}
	}		
}
