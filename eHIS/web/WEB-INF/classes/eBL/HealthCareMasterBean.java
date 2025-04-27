/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;
import eBL.Common.BlAdapter;
import eBL.Common.BlRepository;

import  blHcard.HealthCardAgeDetailBean;
import  blHcard.HealthCardCashBillingGroupBean;
import  blHcard.HealthCardVisitRuleBean;

public class HealthCareMasterBean extends BlAdapter implements
		Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String cardTypeCode=new String();
	String longDescription=new String();
	String shortDescription=new String();
	String validDays=new String();
	String noOfPat = new String();
	String effectiveFrom=new String();
	String effectiveTo=new String();
	String cardStatus=new String();
	String noOfVisits=new String();
	
	ArrayList<blHcard.HealthCardAgeDetailBean> hcAgeDetailList = new 	ArrayList<blHcard.HealthCardAgeDetailBean>();
	ArrayList<HealthCardVisitRuleBean> hcVisitDetailList = new 	ArrayList<HealthCardVisitRuleBean>();
	ArrayList<HealthCardCashBillingGroupBean> hcBlngGrpList = new 	ArrayList<HealthCardCashBillingGroupBean>();

	String facilityId=new String();
	String locale=new String();

	
	
	public void getHealthCardMasterBean(String cardTypeCode) throws Exception{
		
		this.setCardTypeCode(cardTypeCode);		
		getHealthCardHeader(cardTypeCode);
		getHealthCardAgeDetails(cardTypeCode);
		getHealthCardVisitDetails(cardTypeCode);
		getHealthCardGroupDetails(cardTypeCode);
		System.out.println("HealthCareMasterBean fetch completed");
	}
	

	public void getHealthCardHeader(String cardTypeCode) throws Exception {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql=BlRepository.getBlKeyValue("BL_HEALTHCARD_HEADER");
		
		try {
			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, cardTypeCode);
			rs = pst.executeQuery();

			while (rs.next()) {
				this.setLongDescription(rs.getString(1));
				this.setShortDescription(rs.getString(2));
				this.setValidDays(rs.getString(3));
				this.setEffectiveFrom(formatDate(rs.getString(4)));
				this.setEffectiveTo(formatDate(rs.getString(5)));
				this.setCardStatus(rs.getString(6));
				this.setNoOfVisits(rs.getString(7));
				this.setNoOfPat(rs.getString(8));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void getHealthCardAgeDetails(String cardTypeCode) throws Exception {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql=BlRepository.getBlKeyValue("BL_HEALTHCARD_AGEDETAILS");
		
		try {
			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, cardTypeCode);
			rs = pst.executeQuery();

			while (rs.next()) {
				blHcard.HealthCardAgeDetailBean hb=new blHcard.HealthCardAgeDetailBean();
				hb.setMinAgeInDays(Integer.parseInt(rs.getString(1)));
				hb.setMinAgeInMths(Integer.parseInt(rs.getString(2)));
				hb.setMinAgeInYrs(Integer.parseInt(rs.getString(3)));
				hb.setMaxAgeInDays(Integer.parseInt(rs.getString(4)));
				hb.setMaxAgeInMths(Integer.parseInt(rs.getString(5)));
				hb.setMaxAgeInYrs(Integer.parseInt(rs.getString(6)));
				hb.setMembershipFeesCode(nulltoStr(rs.getString(7)));
				hb.setMembershipFeesCodeDescription(getServiceCodeDescription(rs.getString(7)));
				hb.setPriceClassCode(nulltoStr(rs.getString(8)));
				hb.setPriceClassCodeDescription(getPriceCodeDescription(rs.getString(8)));
				System.out.println(hb);
				hcAgeDetailList.add(hb);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public void getHealthCardVisitDetails(String cardTypeCode) throws Exception {
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql=BlRepository.getBlKeyValue("BL_HEALTHCARD_VISITDETAILS");

		try {
			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, cardTypeCode);
			rs = pst.executeQuery();

			while (rs.next()) {
				HealthCardVisitRuleBean visit=new HealthCardVisitRuleBean();
				visit.setClinicCode(nulltoStr(rs.getString(1)));
				visit.setClinicCodeDescription(getClinicCodeDescription(rs.getString(1)));
				visit.setVisitTypeCode(nulltoStr(rs.getString(2)));
				visit.setVisitTypeDescription(getVisitTypeCodeDescription(rs.getString(2)));
				visit.setNoOfVisitsAllowed(rs.getString(3));
				visit.setClinicSelected("N");
				System.out.println(visit);
				hcVisitDetailList.add(visit);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public void getHealthCardGroupDetails(String cardTypeCode) throws Exception {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		//String sql=BlRepository.getBlKeyValue("BL_HEALTHCARD_GROUPDETAILS");

	//	String sql="select A.BLNG_GRP_ID,B.short_desc from bl_hcard_cash_blnggrp_dtl A,bl_blng_grp_lang_vw B where A.BLNG_GRP_ID=B.BLNG_GRP_ID AND B.language_id=? AND A.CARD_TYPE_CODE=?";

		String sql="select b.blng_grp_id,b.short_desc from (select  blng_grp_id ,short_desc  from bl_blng_grp_lang_vw where language_id =? union SELECT  '**' blng_grp_id, 'All Billing Groups' short_desc from dual) B ,bl_hcard_cash_blnggrp_dtl  A where  A.blng_grp_id =B.blng_grp_id AND A.CARD_TYPE_CODE= ?";
		try {
			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, getLocale());
			pst.setString(2, cardTypeCode);
			rs = pst.executeQuery();

			while (rs.next()) {
				HealthCardCashBillingGroupBean bg=new HealthCardCashBillingGroupBean();
				bg.setBlngGrpId(nulltoStr(rs.getString(1)));		
				bg.setBlngGroupdescription(nulltoStr(rs.getString(2)));
				System.out.println(bg);
				hcBlngGrpList.add(bg);				
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
		public String getPriceCodeDescription(String priceCode) throws Exception{

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		//String sql=BlRepository.getBlKeyValue("BL_HEALTHCARD_PRICE_CODE_DESC");
		String sql="select  short_desc   from bl_price_class_lang_vw where language_id=? and OPERATING_FACILITY_ID = ?  and price_class_code=?";
		String descriptionResult=new String();	
		
		try {
			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, getLocale());
			pst.setString(2, getFacilityId());
			pst.setString(3, priceCode);
			rs = pst.executeQuery();

			if (rs.next()) {
			descriptionResult=rs.getString(1);		
			}		
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return nulltoStr(descriptionResult);
		
	}
		
	public String getServiceCodeDescription(String serviceCode) throws Exception{
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		//String sql=BlRepository.getBlKeyValue("BL_HEALTHCARD_SERVICE_CODE_DESC");

		String sql = "select  short_desc from bl_blng_serv_lang where language_id=? and BLNG_SERV_CODE = ?";

		String descriptionResult=new String();
		try {
			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, getLocale());
			pst.setString(2, serviceCode);
			rs = pst.executeQuery();		
	
			if (rs.next()) {
			descriptionResult=rs.getString(1);						
			}					

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return nulltoStr(descriptionResult);	

	}
	
	public String getClinicCodeDescription(String clinicCode) throws Exception{
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
//		String sql=BlRepository.getBlKeyValue("BL_HEALTHCARD_CLINIC_CODE_DESC");
		String  sql = "select  short_desc   from op_clinic_lang_vw where language_id=? and FACILITY_ID = ? and CLINIC_CODE=?";

		String descriptionResult=new String();	
		try {
			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, getLocale());
			pst.setString(2, getFacilityId());
			pst.setString(3, clinicCode);
			rs = pst.executeQuery();

			if (rs.next()) {
			descriptionResult=rs.getString(1);						
			}			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return nulltoStr(descriptionResult);
	
	}
	
	public String getVisitTypeCodeDescription(String visitTypeCode) throws Exception{

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
//		String sql=BlRepository.getBlKeyValue("BL_HEALTHCARD_VISITTYPE_CODE_DESC");
		String sql = "select  short_desc   from op_visit_type_lang_vw where language_id=? and FACILITY_ID = ? and VISIT_TYPE_CODE=?";

		String descriptionResult=new String();
		
		try {
			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, getLocale());
			pst.setString(2, getFacilityId());
			pst.setString(3, visitTypeCode);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				descriptionResult=rs.getString(1);						
			}			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return nulltoStr(descriptionResult);

	}
	
	private String formatDate(String inputDate){
		if(inputDate==null || inputDate.equals("")){
			return "";
		}
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Timestamp inputTimeStamp = null;
	    String outputDate=inputDate;
	    long longTimeStamp = 0;
	    inputTimeStamp = Timestamp.valueOf(inputDate);
	    longTimeStamp = inputTimeStamp.getTime();
	    outputDate=sdf.format(longTimeStamp);
	    return outputDate;
	}

	
	public void clearHealthCardMasterBean(){		
		cardTypeCode="";
		longDescription="";
		shortDescription="";
		validDays="";
		effectiveFrom="";
		effectiveTo="";
		cardStatus="";
		noOfVisits="";
		if (hcAgeDetailList != null){
			hcAgeDetailList.clear();
		}	
		if (hcVisitDetailList != null){
			hcVisitDetailList.clear();
		}
		if (hcBlngGrpList != null){
			hcBlngGrpList.clear();
		}
	}
	
	public String getCardTypeCode() {
		return cardTypeCode;
	}


	public void setCardTypeCode(String cardTypeCode) {
		this.cardTypeCode = cardTypeCode;
	}


	public String getLongDescription() {
		return longDescription;
	}


	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}


	public String getShortDescription() {
		return shortDescription;
	}


	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}


	public String getValidDays() {
		return validDays;
	}


	public void setValidDays(String validDays) {
		this.validDays = validDays;
	}

	public String getNoOfPat() {
		return noOfPat;
	}


	public void setNoOfPat(String noOfPat) {
		this.noOfPat = noOfPat;
	}


	public String getEffectiveFrom() {
		return effectiveFrom;
	}


	public void setEffectiveFrom(String effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}


	public String getEffectiveTo() {
		return effectiveTo;
	}


	public void setEffectiveTo(String effectiveTo) {
		this.effectiveTo = effectiveTo;
	}


	public String getCardStatus() {
		return cardStatus;
	}


	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}


	public String getNoOfVisits() {
		return noOfVisits;
	}


	public void setNoOfVisits(String noOfVisits) {
		this.noOfVisits = noOfVisits;
	}


	public ArrayList<blHcard.HealthCardAgeDetailBean> getHcAgeDetailList() {
		return hcAgeDetailList;
	}


	public void setHcAgeDetailList(
			ArrayList<blHcard.HealthCardAgeDetailBean> hcAgeDetailList) {
		this.hcAgeDetailList = hcAgeDetailList;
	}


	public ArrayList<HealthCardVisitRuleBean> getHcVisitDetailList() {
		return hcVisitDetailList;
	}


	public void setHcVisitDetailList(
			ArrayList<HealthCardVisitRuleBean> hcVisitDetailList) {
		this.hcVisitDetailList = hcVisitDetailList;
	}


	public ArrayList<HealthCardCashBillingGroupBean> getHcBlngGrpList() {
		return hcBlngGrpList;
	}


	public void setHcBlngGrpList(
			ArrayList<HealthCardCashBillingGroupBean> hcBlngGrpList) {
		this.hcBlngGrpList = hcBlngGrpList;
	}
	
	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	/*
	 * This method returns Empty String("") for null value, otherwise the
	 * original string will be returned
	 */
	private String nulltoStr(String inputString){
		if(inputString==null){
			return "";
		}
		else{
			return inputString;
		}
	}
}
