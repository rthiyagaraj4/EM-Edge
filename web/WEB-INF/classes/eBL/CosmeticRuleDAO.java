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
 */
package eBL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import eBL.Common.BlRepository;

import webbeans.eCommon.ConnectionManager;

public class CosmeticRuleDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	CallableStatement cstmt = null;
	ResultSet rst = null;
	
	public HashMap<String,String> getPatientClass(String locale){
		HashMap<String,String> patientClass = new HashMap<String, String>();
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(BlRepository.getBlKeyValue("GET_PATIENT_CLASS"));
			pstmt.setString(1, locale);
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					patientClass.put(rst.getString("patient_class"), rst.getString("short_desc"));
				}
			}
					
		}
		catch(Exception e){
			System.err.println("Exception in getPatientClass -> "+e);
		}
		finally{
			rst = null;
			pstmt = null;
			try{//Added against V210416
				if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e)
			{
				System.err.println("exception "+e);
			}//Added against V210416
		}
		return patientClass;
	}
	
	public String getEffDatesForRuleCode(String ruleCode, String facilityId){
		String effDate = "";
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(BlRepository.getBlKeyValue("GET_EFF_DATE_FOR_RULE_CODE"));
			pstmt.setString(1, facilityId);
			pstmt.setString(2, ruleCode);
			rst = pstmt.executeQuery();
			if(rst != null && rst.next()){				
				effDate = checkForNull(rst.getString("eff_date_from"))+":::"+ checkForNull(rst.getString("eff_date_to"));
			}
					
		}
		catch(Exception e){
			System.err.println("Exception in getPatientClass -> "+e);
		}
		finally{
			rst = null;
			pstmt = null;
			try{//Added against V210416
				if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e)
			{
				System.err.println("exception in getEffDatesForRuleCode"+e);
			}//Added against V210416			
		}
		return effDate;
	}
	
	public int getLastSeqNum(Connection conn){
		int lastSeqNum = 0;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try{
			psmt = conn.prepareStatement(BlRepository.getBlKeyValue("GET_LAST_SEQ_NUM"));
			rs = psmt.executeQuery();
			if(rs != null && rs.next()){
				lastSeqNum = rs.getInt("seq_no");
			}
			
		}
		catch(Exception e){
			System.err.println("Exception in getLastSeqNum ->"+e);
		}
		finally{
			psmt = null;
			rs = null;
			try{//Added against V210416
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e)
			{
				System.err.println("exception in getLastSeqNum"+e);
			}//Added against V210416
		}
		return lastSeqNum;
	}

	public List<String> insertCosmeticRuleSetup(CosmeticRuleHeaderBean cosmeticBean) {
		List<String> error = new ArrayList<String>();
		CosmeticRuleDetailBean dtlBean = null;
		int totalHdrCount = 0;
		try{
			con = ConnectionManager.getConnection();
			
			pstmt = con.prepareStatement(BlRepository.getBlKeyValue("COSMETIC_HDR_COUNT"));
			pstmt.setString(1, cosmeticBean.getLoginFacilityId());
			pstmt.setString(2, cosmeticBean.getBlngGroupCode());
			pstmt.setString(3, cosmeticBean.getPatientClass());
			pstmt.setString(4, cosmeticBean.getCustGroupCode());
			pstmt.setString(5, cosmeticBean.getCustCode());
			pstmt.setString(6, cosmeticBean.getPolicyTypeCode());
			pstmt.setString(7, cosmeticBean.getRuleCode());
			rst = pstmt.executeQuery();
			
			if(rst != null && rst.next()){
				totalHdrCount = rst.getInt("total_cnt");				
			}
			
			if(totalHdrCount < 1){
				int lastSeqNum = getLastSeqNum(con);
				cosmeticBean.setSeqNo(lastSeqNum+1);
				
				pstmt = con.prepareStatement(BlRepository.getBlKeyValue("INSERT_TO_COSMETIC_RULE_HDR"));
				pstmt.setString(1,cosmeticBean.getLoginFacilityId());
				pstmt.setInt(2, cosmeticBean.getSeqNo());
				pstmt.setString(3, cosmeticBean.getBlngGroupCode());
				pstmt.setString(4, cosmeticBean.getPatientClass());
				pstmt.setString(5, cosmeticBean.getCustGroupCode());
				pstmt.setString(6, cosmeticBean.getCustCode());
				pstmt.setString(7, cosmeticBean.getPolicyTypeCode());
				pstmt.setString(8, cosmeticBean.getRuleCode());
				if("Y".equals(cosmeticBean.getStatus())){
					pstmt.setString(9, "E");
				}
				else{
					pstmt.setString(9, "D");
				}
				
				pstmt.setString(10, cosmeticBean.getLoginFacilityId());
				pstmt.setString(11, cosmeticBean.getLoginById());
				pstmt.setString(12, cosmeticBean.getLoginAtWsNo());
				pstmt.setString(13, cosmeticBean.getLoginFacilityId());
				pstmt.setString(14, cosmeticBean.getLoginById());
				pstmt.setString(15, cosmeticBean.getLoginAtWsNo());
				
				pstmt.execute();
				
				for (Iterator<CosmeticRuleDetailBean> iterator = cosmeticBean.getCriteriaList().iterator(); iterator.hasNext();) {				
					dtlBean = (CosmeticRuleDetailBean) iterator.next();
					if(!"Y".equals(dtlBean.getIsDelFlagYN())){
						pstmt = null;
						pstmt = con.prepareStatement(BlRepository.getBlKeyValue("INSERT_TO_COSMETIC_RULE_CRITERIA"));
						pstmt.setInt(1, cosmeticBean.getSeqNo());
						pstmt.setString(2, dtlBean.getServType());
						pstmt.setString(3, dtlBean.getServCode());
						pstmt.setString(4, cosmeticBean.getLoginFacilityId());
						pstmt.setString(5, cosmeticBean.getLoginById());
						pstmt.setString(6, cosmeticBean.getLoginAtWsNo());
						pstmt.setString(7, cosmeticBean.getLoginFacilityId());
						pstmt.setString(8, cosmeticBean.getLoginById());
						pstmt.setString(9, cosmeticBean.getLoginAtWsNo());
						pstmt.execute();
					}				
				}
				
				for (Iterator<CosmeticRuleDetailBean> iterator = cosmeticBean.getExclList().iterator(); iterator.hasNext();) {				
					dtlBean = (CosmeticRuleDetailBean) iterator.next();
					if(!"Y".equals(dtlBean.getIsDelFlagYN())){
						pstmt = null;
						pstmt = con.prepareStatement(BlRepository.getBlKeyValue("INSERT_TO_COSMETIC_RULE_EXCLUSION"));
						pstmt.setInt(1, cosmeticBean.getSeqNo());
						pstmt.setString(2, dtlBean.getServType());
						pstmt.setString(3, dtlBean.getServCode());
						pstmt.setString(4, dtlBean.getInclExclYN());
						pstmt.setString(5, cosmeticBean.getLoginFacilityId());
						pstmt.setString(6, cosmeticBean.getLoginById());
						pstmt.setString(7, cosmeticBean.getLoginAtWsNo());
						pstmt.setString(8, cosmeticBean.getLoginFacilityId());
						pstmt.setString(9, cosmeticBean.getLoginById());
						pstmt.setString(10, cosmeticBean.getLoginAtWsNo());
						pstmt.execute();
					}				
				}
				
				con.commit();
			}
			else{
				error.add("Cannot Save the Record, Since Same Header Combination is Already Present");
			}
			
		}
		catch(Exception e){
			System.err.println("Exception in getPatientClass -> "+e);
			try{
				con.rollback();
			}
			catch(Exception e1){
				
			}
			error.add(e.getMessage());
		}
		finally{
			rst = null;
			pstmt = null;
			try{//Added against V210416
				if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e)
			{
				System.err.println("exception in insertCosmeticRuleSetup"+e);
			}//Added against V210416			
		}		
		return error;
	}
	
	public CosmeticRuleHeaderBean getCosmeticBean(int seqNo,String facilityId, String locale){
		CosmeticRuleHeaderBean cosmeticBean = new CosmeticRuleHeaderBean();
		List<CosmeticRuleDetailBean> criteriaList = new ArrayList<CosmeticRuleDetailBean>();
		List<CosmeticRuleDetailBean> exclusionList = new ArrayList<CosmeticRuleDetailBean>();
		CosmeticRuleDetailBean detailBean = null;
		
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(BlRepository.getBlKeyValue("QUERY_COSMETIC_HDR"));
			pstmt.setString(1, facilityId);
			pstmt.setString(2, locale);
			pstmt.setString(3, locale);
			pstmt.setString(4, locale);
			pstmt.setString(5, facilityId);
			pstmt.setString(6, locale);
			pstmt.setInt(7, seqNo);
			rst = pstmt.executeQuery();
			if(rst != null && rst.next()){				
				cosmeticBean.setRuleCode(checkForNull(rst.getString("RULE_CODE")));
				cosmeticBean.setRuleDesc(checkForNull(rst.getString("Rule_desc")));
				cosmeticBean.setPatientClass(checkForNull(rst.getString("PATIENT_CLASS")));
				cosmeticBean.setBlngGroupCode(checkForNull(rst.getString("BILLING_GROUP_CODE")));
				cosmeticBean.setBlngGroupDesc(checkForNull(rst.getString("BILLING_GROUP_DESC")));
				cosmeticBean.setCustGroupCode(checkForNull(rst.getString("CUSTOMER_GROUP_CODE")));
				cosmeticBean.setCustGroupDesc(checkForNull(rst.getString("Customer_grp_desc")));
				cosmeticBean.setCustCode(checkForNull(rst.getString("CUSTOMER_CODE")));
				cosmeticBean.setCustDesc(checkForNull(rst.getString("Customer_desc")));
				cosmeticBean.setPolicyTypeCode(checkForNull(rst.getString("POLICY_TYPE_CODE")));
				cosmeticBean.setPolicyTypeDesc(checkForNull(rst.getString("policy_desc")));
				cosmeticBean.setStatus(checkForNull(rst.getString("STATUS")));
			}
			
			pstmt = null;
			rst = null;
			pstmt = con.prepareStatement(BlRepository.getBlKeyValue("GET_EFF_DATE_FOR_RULE_CODE"));
			pstmt.setString(1, facilityId);
			pstmt.setString(2, cosmeticBean.getRuleCode());
			rst = pstmt.executeQuery();
			if(rst != null && rst.next()){
				cosmeticBean.setStartDate(checkForNull(rst.getString("eff_date_from")));
				cosmeticBean.setEndDate(checkForNull(rst.getString("eff_date_to")));
			}
			
			pstmt = null;
			rst = null;
			pstmt = con.prepareStatement(BlRepository.getBlKeyValue("QUERY_COSMETIC_CRITERIA"));
			pstmt.setString(1, locale);
			pstmt.setInt(2, seqNo);
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					detailBean = new CosmeticRuleDetailBean();
					detailBean.setServType(checkForNull(rst.getString("CRITERIA_TYPE")));
					detailBean.setServCode(checkForNull(rst.getString("CRITERIA_CODE")));
					detailBean.setServDesc(checkForNull(rst.getString("criteria_desc")));
					criteriaList.add(detailBean);
				}
			}
			
			pstmt = null;
			rst = null;
			pstmt = con.prepareStatement(BlRepository.getBlKeyValue("QUERY_COSMETIC_EXCLUSION"));
			pstmt.setString(1, locale);
			pstmt.setInt(2, seqNo);
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					detailBean = new CosmeticRuleDetailBean();
					detailBean.setServType(checkForNull(rst.getString("EXCLUSION_TYPE")));
					detailBean.setServCode(checkForNull(rst.getString("EXCLUSION_CODE")));
					detailBean.setServDesc(checkForNull(rst.getString("exclusion_desc")));
					detailBean.setInclExclYN(checkForNull(rst.getString("INCLUDE_YN")));
					exclusionList.add(detailBean);
				}
			}
			
			cosmeticBean.setCriteriaList(criteriaList);
			cosmeticBean.setExclList(exclusionList);
		}
		catch(Exception e){
			System.err.println("Exception in getting getCosmeticBean ->"+e);
		}
		finally{
			rst = null;
			pstmt = null;
			try{//Added against V210416
				if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e)
			{
				System.err.println("exception in insertCosmeticRuleSetup"+e);
			}//Added against V210416			
		}
		return cosmeticBean;
	}
	
	public List<String> updateCosmeticRuleSetup(CosmeticRuleHeaderBean cosmeticBean){
		List<String> error = new ArrayList<String>();
		CosmeticRuleDetailBean dtlBean = null;
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(BlRepository.getBlKeyValue("UPDATE_COSMETIC_HDR"));
			if("Y".equals(cosmeticBean.getStatus())){
				pstmt.setString(1, "E");
			}
			else{
				pstmt.setString(1, "D");
			}
			pstmt.setString(2, cosmeticBean.getLoginFacilityId());
			pstmt.setString(3, cosmeticBean.getLoginById());
			pstmt.setString(4, cosmeticBean.getLoginAtWsNo());
			pstmt.setInt(5, cosmeticBean.getSeqNo());
			pstmt.execute();
			
			for (Iterator<CosmeticRuleDetailBean> iterator = cosmeticBean.getCriteriaList().iterator(); iterator.hasNext();) {				
				dtlBean = (CosmeticRuleDetailBean) iterator.next();
				pstmt = null;
				if("Y".equals(dtlBean.getIsDelFlagYN())){
					pstmt = con.prepareStatement(BlRepository.getBlKeyValue("DELETE_COSMETIC_CRITERIA"));
					pstmt.setInt(1, cosmeticBean.getSeqNo());
					pstmt.setString(2, dtlBean.getServType());
					pstmt.setString(3, dtlBean.getServCode());
					pstmt.execute();
				}
				else{
					if("I".equals(dtlBean.getStatus())){
						pstmt = con.prepareStatement(BlRepository.getBlKeyValue("INSERT_TO_COSMETIC_RULE_CRITERIA"));
						pstmt.setInt(1, cosmeticBean.getSeqNo());
						pstmt.setString(2, dtlBean.getServType());
						pstmt.setString(3, dtlBean.getServCode());
						pstmt.setString(4, cosmeticBean.getLoginFacilityId());
						pstmt.setString(5, cosmeticBean.getLoginById());
						pstmt.setString(6, cosmeticBean.getLoginAtWsNo());
						pstmt.setString(7, cosmeticBean.getLoginFacilityId());
						pstmt.setString(8, cosmeticBean.getLoginById());
						pstmt.setString(9, cosmeticBean.getLoginAtWsNo());
						pstmt.execute();
					}
				}
			}
			
			for (Iterator<CosmeticRuleDetailBean> iterator = cosmeticBean.getExclList().iterator(); iterator.hasNext();) {				
				dtlBean = (CosmeticRuleDetailBean) iterator.next();
				pstmt = null;
				if("Y".equals(dtlBean.getIsDelFlagYN())){
					pstmt = con.prepareStatement(BlRepository.getBlKeyValue("DELETE_COSMETIC_EXCLUSION"));
					pstmt.setInt(1, cosmeticBean.getSeqNo());
					pstmt.setString(2, dtlBean.getServType());
					pstmt.setString(3, dtlBean.getServCode());
					pstmt.execute();
				}
				else{
					if("I".equals(dtlBean.getStatus())){
						pstmt = con.prepareStatement(BlRepository.getBlKeyValue("INSERT_TO_COSMETIC_RULE_EXCLUSION"));
						pstmt.setInt(1, cosmeticBean.getSeqNo());
						pstmt.setString(2, dtlBean.getServType());
						pstmt.setString(3, dtlBean.getServCode());
						pstmt.setString(4, dtlBean.getInclExclYN());
						pstmt.setString(5, cosmeticBean.getLoginFacilityId());
						pstmt.setString(6, cosmeticBean.getLoginById());
						pstmt.setString(7, cosmeticBean.getLoginAtWsNo());
						pstmt.setString(8, cosmeticBean.getLoginFacilityId());
						pstmt.setString(9, cosmeticBean.getLoginById());
						pstmt.setString(10, cosmeticBean.getLoginAtWsNo());
						pstmt.execute();
					}
					else{
						pstmt = con.prepareStatement(BlRepository.getBlKeyValue("UPDATE_COSMETIC_EXCLUSION"));
						pstmt.setString(1, dtlBean.getInclExclYN());
						pstmt.setString(2, cosmeticBean.getLoginFacilityId());
						pstmt.setString(3, cosmeticBean.getLoginById());
						pstmt.setString(4, cosmeticBean.getLoginAtWsNo());
						pstmt.setInt(5, cosmeticBean.getSeqNo());
						pstmt.setString(6, dtlBean.getServType());
						pstmt.setString(7, dtlBean.getServCode());
						pstmt.execute();
					}
				}

			}
			
			con.commit();
			
		}
		catch(Exception e){
			System.err.println("Exception in updateCosmeticRuleSetup -> "+e);
			try{
				con.rollback();
			}
			catch(Exception e1){
				
			}
			error.add(e.getMessage());
		}
		//Added against V210416
		finally{
			rst = null;
			pstmt = null;
			try{
				if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
			ConnectionManager.returnConnection(con);
		}
		catch(Exception e)
		{
			System.err.println("exception in updateCosmeticRuleSetup"+e);
		}
			ConnectionManager.returnConnection(con);
		}//Added against V210416		
		return error;
	}
	
	private String checkForNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}
}
