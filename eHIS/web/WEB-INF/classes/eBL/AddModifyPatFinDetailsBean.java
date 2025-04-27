package eBL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.*;//NMC-JD-CRF-0054

import com.google.gson.JsonObject;

public class AddModifyPatFinDetailsBean {

	public JsonObject getDfltPlcyAndPyrGrpSetup(Connection con,
			String facilityId) {
		JsonObject obj = new JsonObject();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String dfltPolicyDefInVisRegnYn = "";
		String payerGrpBySetup = "";
		String strChargeLogicYN = "";
		try {
			pstmt = con
					.prepareStatement("select NVL(DFLT_POLICY_DEF_IN_VIS_REG_YN,'N'),NVL(ADD_PAYER_CUSTGRP_BY_SETUP,'N'),NVL(CHARGE_LOGIC_YN,'N')  from bl_parameters where OPERATING_FACILITY_ID =?");
			pstmt.setString(1, facilityId);
			rst = pstmt.executeQuery();
			if (rst != null) {
				while (rst.next()) {
					dfltPolicyDefInVisRegnYn = rst.getString(1);
					payerGrpBySetup = rst.getString(2);
					strChargeLogicYN = rst.getString(3);
				}
			}
			obj.addProperty("dfltPolicyDefInVisRegnYn",
					dfltPolicyDefInVisRegnYn);
			obj.addProperty("payerGrpBySetup", payerGrpBySetup);
			obj.addProperty("strChargeLogicYN", strChargeLogicYN);
		} catch (Exception e) {
			System.err.println("Exception in getDfltPlcyAndPyrGrpSetup" + e);
		} finally {
			try {
				if (rst != null)
					rst.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception eInr) {
				System.err.println("Exception in getDfltPlcyAndPyrGrpSetup"
						+ eInr);
				eInr.printStackTrace();
			}

		}
		return obj;
	}

	public JsonObject getRefSourceFlagsForP1(String priority_1_blng_grp_code,
			Connection con) {
		JsonObject obj = new JsonObject();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String referral_source_code_flag = "";
		String referral_source_main_mand_YN = "";
		String referral_source_sub_mand_YN = "";
		String pr_payer_employer_id_mand_YN = "";
		try {
			String ref_src_qry = "select nvl(CAPTURE_REF_SOURCE_DTL_YN,'N'),nvl(REF_SOURCE_MAIN_MAND_YN,'N'),nvl(REF_SOURCE_SUB_MAND_YN,'N'),nvl(PR_PAYER_EMPLOYER_ID_MAND_YN,'N') from bl_blng_grp where BLNG_GRP_ID=?";
			pstmt = con.prepareStatement(ref_src_qry);
			pstmt.setString(1, priority_1_blng_grp_code);
			rst = pstmt.executeQuery();
			if (rst != null) {
				while (rst.next()) {
					referral_source_code_flag = rst.getString(1);
					referral_source_main_mand_YN = rst.getString(2);
					referral_source_sub_mand_YN = rst.getString(3);
					pr_payer_employer_id_mand_YN = rst.getString(4);
				}
			}
			obj.addProperty("referral_source_code_flag",
					referral_source_code_flag);
			obj.addProperty("referral_source_main_mand_YN",
					referral_source_main_mand_YN);
			obj.addProperty("referral_source_sub_mand_YN",
					referral_source_sub_mand_YN);
			obj.addProperty("pr_payer_employer_id_mand_YN",
					pr_payer_employer_id_mand_YN);
		} catch (Exception e) {
			System.err.println("Exception in getRefSourceFlagsForP1" + e);
		} finally {
			try {
				if (rst != null)
					rst.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception eInr) {
				System.err.println("Exception in getRefSourceFlagsForP1" + eInr);
				eInr.printStackTrace();
			}

		}
		return obj;
	}

	public JsonObject getblngGrpDesc(String blng_grp_code, String locale,
			Connection con) {
		JsonObject obj = new JsonObject();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String blng_grp_desc = "";
		String str_currency_code_for_bg="";
		String str_currency_desc_for_bg="";
		try {
			String billing_grp_qry = "SELECT SHORT_DESC,CURRENCY_CODE,CURRENCY_DESC FROM BL_BLNG_GRP_LANG_VW WHERE BLNG_GRP_ID = ? AND LANGUAGE_ID = ?";
			//pstmt = con.prepareCall(billing_grp_qry);
			pstmt = con.prepareStatement(billing_grp_qry);
			pstmt.setString(1, blng_grp_code);
			pstmt.setString(2, locale);
			rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					blng_grp_desc = rs.getString(1);
					str_currency_code_for_bg=rs.getString(2);
					str_currency_desc_for_bg=rs.getString(3);

				}
			}
			if(str_currency_code_for_bg == null) str_currency_code_for_bg= "";
			if(str_currency_desc_for_bg == null) str_currency_desc_for_bg= "";
			System.out.println("blng_grp_desc " + blng_grp_desc);
			obj.addProperty("blng_grp_desc", blng_grp_desc);
			obj.addProperty("str_currency_code_for_bg", str_currency_code_for_bg);
			obj.addProperty("str_currency_desc_for_bg", str_currency_desc_for_bg);
				
			System.out.println("obj " + obj);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception in getblngGrpDesc " + e);
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				System.err.println("Exception in getblngGrpDesc " + e);
				e.printStackTrace();
			}

		}
		return obj;
	}

	public HashMap<String, String> claimCreditMap(String rtn_ins_cust_priority,
			String rtn_ins_cust_group_code, String rtn_ins_cust_code,
			String rtn_ins_policy_start_date,
			String rtn_ins_policy_expiry_date,
			String rtn_ins_policy_eff_from_date, String rtn_ins_policy_no,
			String patient_id, Connection con) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HashMap<String, String> claimCreditMap = new HashMap<String, String>();
		try {
				//Boolean Site_spec_Pno=false;//NMC-JD-CRF-0054 --commented V210419
			StringTokenizer tok_rtn_ins_cust_priority = new StringTokenizer(
					rtn_ins_cust_priority, "|");
			StringTokenizer tok_rtn_ins_cust_group_code = new StringTokenizer(
					rtn_ins_cust_group_code, "|");
			StringTokenizer tok_rtn_ins_cust_code = new StringTokenizer(
					rtn_ins_cust_code, "|");
			StringTokenizer tok_rtn_ins_policy_start_date = new StringTokenizer(
					rtn_ins_policy_start_date, "|");
			StringTokenizer tok_rtn_ins_policy_expiry_date = new StringTokenizer(
					rtn_ins_policy_expiry_date, "|");
			StringTokenizer tok_rtn_ins_policy_eff_from_date = new StringTokenizer(
					rtn_ins_policy_eff_from_date, "|");
			StringTokenizer tok_rtn_rtn_ins_policy_no = new StringTokenizer(
					rtn_ins_policy_no, "|");
			//Added against NMC-JD-CRF-0054
			String claim_code_sql = " SELECT claim_code, credit_auth_by, membership_no,POLICY_NUMBER "
						+ " FROM bl_encounter_payer_priority "
						+ " WHERE patient_id = ? "
						+ " AND cust_group_code = ? "
						+ " AND cust_code = ? "
						+ " AND priority = ? and POLICY_START_DATE=to_date(?,'dd/mm/yyyy')  and POLICY_EXPIRY_DATE=to_date(?,'dd/mm/yyyy')  and EFFECTIVE_FROM=to_date(?,'dd/mm/yyyy') and policy_number=? order by ACCT_SEQ_EFF_FROM_DATE desc";
			
				
			while (tok_rtn_ins_cust_priority.hasMoreTokens()) {

				String tmpPriority = tok_rtn_ins_cust_priority.nextToken();
				String tmpCustGrp = tok_rtn_ins_cust_group_code.nextToken();
				String tmpCustCode = tok_rtn_ins_cust_code.nextToken();
				String tmpPolStrtDate = tok_rtn_ins_policy_start_date
						.nextToken();
				String tmpPolExpDate = tok_rtn_ins_policy_expiry_date
						.nextToken();
				String tmpPolEffFrom = tok_rtn_ins_policy_eff_from_date
						.nextToken();
				//NMC-JD-CRF-0054
				String tmpPolNum ="";
				try{
						tmpPolNum= tok_rtn_rtn_ins_policy_no.nextToken();
					} catch (NoSuchElementException exception) {
						tmpPolNum="";
						exception.printStackTrace();
					}
				//NMC-JD-CRF-0054
				System.out.println("tmpPriority / tmpCustGrp / tmpCustCode "
						+ tmpPriority + "/ " + tmpCustGrp + "/ " + tmpCustCode);
				System.out
						.println("tmpPolStrtDate / tmpPolExpDate / tmpPolEffFrom / tmpPolNum "
								+ tmpPolStrtDate
								+ "/ "
								+ tmpPolExpDate
								+ "/ "
								+ tmpPolEffFrom + "/ " + tmpPolNum);
				pstmt = con.prepareStatement(claim_code_sql);
				
				pstmt.setString(1, patient_id);
				pstmt.setString(2, tmpCustGrp);
				pstmt.setString(3, tmpCustCode);
				pstmt.setString(4, tmpPriority);
				pstmt.setString(5, tmpPolStrtDate);
				pstmt.setString(6, tmpPolExpDate);
				pstmt.setString(7, tmpPolEffFrom);
				pstmt.setString(8, tmpPolNum);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					String claim_code = rs.getString(1);
					if (claim_code == null)
						claim_code = "";
					String credit_authorisation_by = rs.getString(2);
					if (credit_authorisation_by == null)
						credit_authorisation_by = "";
					String membershipId = rs.getString(3);
					if (membershipId == null)
						membershipId = "";
					//Added against NMC-JD-CRF-0054
					String policyNumber = rs.getString(4);
					if (policyNumber == null)
						policyNumber = "";					
					//Added against NMC-JD-CRF-0054
					System.out
							.println("claim_code / credit_authorisation_by / membershipId / policy Number "
									+ claim_code
									+ "/ "
									+ credit_authorisation_by
									+ "/ "
									+ membershipId
									+ "/ "
									+ policyNumber);
					claimCreditMap.put(tmpPriority, claim_code + "~"
							+ credit_authorisation_by + "~" + membershipId + "~" + policyNumber);

				}

			}
		} catch (Exception e) {
			System.err.println("Exceptuion in claimCreditMap " + e);
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				System.err.println("Exception in getblngGrpDesc " + e);
				e.printStackTrace();
			}
		}
		System.out.println("claimCreditMap Bean " + claimCreditMap);//returning empty value.
		return claimCreditMap;
	}

	
	
	public String getPackageBlngGrpYn(String facility_id,String patient_id,String episode_type,String calling_function_id,String blng_grp_code_for_pkg_use,String encounter_date_aft_trunc,Connection con)
	{
		String outPut="";
		CallableStatement call_pkg=null;
		
		try{
			
			
			call_pkg = con.prepareCall("{ ? = call  blcore.package_blng_grp_yn(?,?,?,?,?,to_date(?,'DD/MM/YYYY'),?,?)}");
			call_pkg.registerOutParameter(1,java.sql.Types.VARCHAR);

			call_pkg.setString(2,facility_id);
			call_pkg.setString(3,patient_id);
			call_pkg.setString(4,episode_type);
			call_pkg.setString(5,calling_function_id);
			call_pkg.setString(6,blng_grp_code_for_pkg_use);
			call_pkg.setString(7,encounter_date_aft_trunc);
			call_pkg.setString(8,"B");
			call_pkg.setString(9,"");

			call_pkg.execute();							
			outPut = call_pkg.getString(1);				
			call_pkg.close();
			if ( outPut == null ) outPut = "N";

		}catch(Exception e)
		{
			System.err.println("Exception in packageBlngGrpYn "+e);
			e.printStackTrace();
		}
		
		return outPut;
	}
	
	
	
	
	
	
	
	
	
	
	public JsonObject getSettlementIndAdmRec(String operation,
			String billing_mode, String billing_group, Connection con) {
		JsonObject obj = new JsonObject();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		String nd_settlement_ind = "";
		String nd_adm_rec_flag = "";
		String strCreditDoc_YN = "";
		try {
			if ((billing_mode.equals("Modify")) || (operation.equals("Update"))) {
				sql = "select settlement_ind, adm_rec_flag,nvl(credit_doc_ref_reqd_yn,'N') from bl_blng_grp where blng_grp_id = ?";
			} else {
				sql = "select settlement_ind, adm_rec_flag,nvl(credit_doc_ref_reqd_yn,'N') from bl_blng_grp where blng_grp_id = ?";
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, billing_group);
			rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					nd_settlement_ind = rs.getString("settlement_ind");
					nd_adm_rec_flag = rs.getString("adm_rec_flag");
					strCreditDoc_YN = rs.getString(3);

				}
			}

			obj.addProperty("nd_settlement_ind", nd_settlement_ind);
			obj.addProperty("nd_adm_rec_flag", nd_adm_rec_flag);
			obj.addProperty("strCreditDoc_YN", strCreditDoc_YN);
			System.out.println("obj " + obj);

		} catch (Exception e) {
			System.err.println("Exception in getSettlementIndAdmRec " + e);
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				System.err.println("Exception in getblngGrpDesc " + e);
				e.printStackTrace();
			}
		}
		return obj;
	}
	
	public String getrefSrcMainLngName(String refInsSrcMainCode,String locale,String intValue,Connection con)
	{
	
		String outPut="";
		CallableStatement cstmt=null;
		try{
			cstmt = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
			cstmt.registerOutParameter(1,java.sql.Types.VARCHAR);
			cstmt.setString(2,refInsSrcMainCode);
			cstmt.setString(3,locale);
			cstmt.setString(4,intValue);
			cstmt.execute();							
			outPut = cstmt.getString(1);				
			System.out.println("refSrcMainLngName "+outPut);
			if ( outPut == null ) outPut = "";
		}catch(Exception e)
		{
			System.err.println("Exception in getrefSrcMainLngName "+e);
		}
		finally{
			try{
				cstmt.close();
			}catch(Exception e)
			{
				System.err.println("Exception in getrefSrcMainLngName "+e);
				e.printStackTrace();
			}
		}
	return outPut;
	}


	public JsonObject validPayerYN(String strModuleId,String custCode,String custGrpCode,Connection con)
	{
		
		JsonObject obj=new JsonObject();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
		String empty_sql_check="N";	
		String cust_valid_to_date="";
		String payer_suspended_YN="";
		String cust_valid_from_date="";
		String validPayerYNSql="select DISTINCT 'Y',to_char(a.VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(a.VALID_TO,'dd/mm/yyyy') VALID_TO,a.status status from ar_customer a, ar_cust_group b,sy_acc_entity c,bl_cust_by_cust_group e where a.acc_entity_code= b.acc_entity_code and a.acc_entity_code = c.acc_entity_code and a.patient_flag = 'Y' and NVL(a.pat_com_flag,'N') = 'N' and nvl(a.insurance_yn,'Y') = 'Y' /*and a.status is null*/ and ((? in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or (? in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or (? = 'MP' and nvl(ref_yn,'N') = 'Y')) and a.cust_code = e.cust_code and b.cust_group_code = e.cust_group_code AND a.CUST_CODE =? and b.cust_group_code=?";
		pstmt = con.prepareStatement(validPayerYNSql);
		pstmt.setString(1, strModuleId);
		pstmt.setString(2, strModuleId);
		pstmt.setString(3, strModuleId);
		pstmt.setString(4, custCode);
		pstmt.setString(5, custGrpCode);
		rs=pstmt.executeQuery();
		if( rs != null ) 
		{	
			empty_sql_check="Y";
			String valid_payer_YN="";
			while(rs.next())
			{
				empty_sql_check="N";
				valid_payer_YN=rs.getString(1);
				cust_valid_from_date = rs.getString(2);
				cust_valid_to_date = rs.getString(3);
				payer_suspended_YN = rs.getString(4);
			}
			if(valid_payer_YN.equals("")) valid_payer_YN="N";
			obj.addProperty("valid_payer_YN", valid_payer_YN);
			
		}
		if(payer_suspended_YN == null) payer_suspended_YN="";	
		if(cust_valid_from_date == null) cust_valid_from_date= "";
		if(cust_valid_to_date == null) cust_valid_to_date= "";
		obj.addProperty("empty_sql_check", empty_sql_check);
		obj.addProperty("cust_valid_from_date", cust_valid_from_date);
		obj.addProperty("payer_suspended_YN", payer_suspended_YN);
		obj.addProperty("cust_valid_to_date", cust_valid_to_date);
		
		
		}catch(Exception e)
		{
			System.err.println("Exception in validPayerYN "+e);
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public JsonObject getvalidPolicyTypeCodeYN(String empty_sql_check,String strModuleId,String custCode,String custGrpCode, String policyTypeCode,String locale,String facility_id ,Connection con)
	{
		JsonObject obj=new JsonObject();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String policy_suspended_YN="";
		String valid_policy_type_code_YN = "";
			
			String valid_policy_type_code_YN_sql="Select DISTINCT 'Y',a.status from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b, bl_cust_by_cust_group c where a.language_id=?  and a.operating_facility_id=? /*and nvl(a.status,'N') <> 'S'*/ and a.operating_facility_id = b.operating_facility_id and a.policy_type_code = b.policy_type_code and b.cust_code=? and b.cust_group_code=? and b.cust_group_code = c.cust_group_code and b.cust_code=c.cust_code and ((? in ('OP','AE') and nvl(b.outpatient_cover,'N') = 'Y') or (? in ('IP','DC') and nvl(b.inpatient_covered,'N') = 'Y') or (? = 'MP' and nvl(b.external_covered,'N') = 'Y')) AND b.policy_type_code =?";
		
			try{
				
				pstmt = con.prepareStatement(valid_policy_type_code_YN_sql);
				pstmt.setString(1, locale);
				pstmt.setString(2, facility_id);
				pstmt.setString(3, custCode);
				pstmt.setString(4, custGrpCode);
				pstmt.setString(5, strModuleId);
				pstmt.setString(6, strModuleId);
				pstmt.setString(7, strModuleId);
				pstmt.setString(8, policyTypeCode);
				rs=pstmt.executeQuery();
			if( rs != null ) 
			{	
				empty_sql_check="Y";
				valid_policy_type_code_YN="";
				while(rs.next())
				{
					empty_sql_check="N";
					valid_policy_type_code_YN=rs.getString(1);
					policy_suspended_YN = rs.getString(2);
				}
			}
			if(empty_sql_check.equals("Y"))
			{ 
					valid_policy_type_code_YN_sql="Select DISTINCT 'Y',a.status from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b, bl_cust_by_cust_group c where a.language_id=? and a.operating_facility_id=? /*and nvl(a.status,'N') <> 'S'*/ and a.operating_facility_id = b.operating_facility_id and a.policy_type_code = b.policy_type_code  and b.cust_group_code=? and b.cust_group_code = c.cust_group_code and b.cust_code = '**' and ((? in ('OP','AE') and nvl(b.outpatient_cover,'N') = 'Y') or (? in ('IP','DC') and nvl(b.inpatient_covered,'N') = 'Y') or (? = 'MP' and nvl(b.external_covered,'N') = 'Y')) AND b.policy_type_code =?";
					pstmt = con.prepareStatement(valid_policy_type_code_YN_sql);
					pstmt.setString(1, locale);
					pstmt.setString(2, facility_id);
					pstmt.setString(3, custGrpCode);
					pstmt.setString(4, strModuleId);
					pstmt.setString(5, strModuleId);
					pstmt.setString(6, strModuleId);
					pstmt.setString(7, policyTypeCode);
					rs=pstmt.executeQuery();
					if( rs != null ) 
					{	
						empty_sql_check="Y";
						valid_policy_type_code_YN="";
						while(rs.next())
						{
							empty_sql_check="N";
							valid_policy_type_code_YN=rs.getString(1);
							policy_suspended_YN = rs.getString(2);
						}
					}
				}
					if(valid_policy_type_code_YN.equals("")) valid_policy_type_code_YN="N";
					if(policy_suspended_YN == null) policy_suspended_YN="";
	
					obj.addProperty("empty_sql_check", empty_sql_check);
					obj.addProperty("valid_policy_type_code_YN", valid_policy_type_code_YN);
					obj.addProperty("policy_suspended_YN", policy_suspended_YN);
			}catch(Exception e)
			{
				System.err.println("Exception in  getvalidPolicyTypeCodeYN2" + e);
				e.printStackTrace();
			}
			
	
	finally
	{
		
		try {
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			System.err.println("Exception in  getvalidPolicyTypeCodeYN" + e);
			e.printStackTrace();
		}
	}

	
		return obj;
	}
	
	public JsonObject getCustValidDates(String custCode,Connection con){
		JsonObject obj=new JsonObject();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String cust_valid_from_date = "";
		String cust_valid_to_date = "";
		try{
			String cust_valid_dates_qry = "select to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO from ar_customer where patient_flag = 'Y' and NVL(pat_com_flag,'N') = 'N'  and nvl(insurance_yn,'Y') = 'Y'   and status is null and cust_code=?";
			pstmt = con.prepareStatement(cust_valid_dates_qry);
			pstmt.setString(1, custCode);
			rs = pstmt.executeQuery() ;
			if( rs != null ) 
			{	
				while( rs.next() )
				{  
					cust_valid_from_date = rs.getString(1);
					cust_valid_to_date = rs.getString(2);
				}
			}
			if(cust_valid_from_date == null) cust_valid_from_date= "";
			if(cust_valid_to_date == null) cust_valid_to_date= "";
			
			obj.addProperty("cust_valid_from_date", cust_valid_from_date);
			obj.addProperty("cust_valid_to_date", cust_valid_to_date);

		}
		catch(Exception e){
			System.err.println("Exception in  getCustValidDates" + e);
			e.printStackTrace();
		}
		finally{
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception eInr) {
				System.err.println("Exception in  getvalidPolicyTypeCodeYN" + eInr);
				eInr.printStackTrace();
			}
		}
		return obj;
		
	}
	
	public JsonObject getCurrencyCode(String blngGrpId,String locale,Connection con){
		JsonObject obj=new JsonObject();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String str_currency_code_for_bg = "";
		String str_currency_desc_for_bg = "";
		try{
			String curr_code_qry = "select CURRENCY_CODE,CURRENCY_DESC from bl_blng_grp_lang_vw where blng_grp_id=? and language_id=?";
			pstmt = con.prepareStatement(curr_code_qry);
			pstmt.setString(1, blngGrpId);
			pstmt.setString(2, locale);
			rs = pstmt.executeQuery() ;
			if( rs != null ) 
			{	
				while( rs.next() )
				{  
					str_currency_code_for_bg=rs.getString(1);
					str_currency_desc_for_bg=rs.getString(2);
				}
			}
			if(str_currency_code_for_bg == null) str_currency_code_for_bg= "";
			if(str_currency_desc_for_bg == null) str_currency_desc_for_bg= "";
			
			obj.addProperty("str_currency_code_for_bg", str_currency_code_for_bg);
			obj.addProperty("str_currency_desc_for_bg", str_currency_desc_for_bg);

		}
		catch(Exception e){
			System.err.println("Exception in  getCustValidDates" + e);
			e.printStackTrace();
		}
		finally{
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception eInr) {
				System.err.println("Exception in  getvalidPolicyTypeCodeYN" + eInr);
				eInr.printStackTrace();
			}
		}
		return obj;
	}
	
	public String payerSuspendedYn(String strModuleId,String custCode, String custGroupCode, Connection con){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String payer_suspended_YN = "";
		try{
			String payer_suspended_YN_sql="select a.status status from ar_customer a, ar_cust_group b,sy_acc_entity c,bl_cust_by_cust_group e where a.acc_entity_code= b.acc_entity_code and a.acc_entity_code = c.acc_entity_code and a.patient_flag = 'Y' and NVL(a.pat_com_flag,'N') = 'N' and nvl(a.insurance_yn,'Y') = 'Y' /* and a.status is null */ and (? in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or (? in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or (? = 'MP' and nvl(ref_yn,'N') = 'Y')) and a.cust_code = e.cust_code and b.cust_group_code = e.cust_group_code AND a.CUST_CODE =? and b.cust_group_code=?";

			pstmt = con.prepareStatement(payer_suspended_YN_sql);
			pstmt.setString(1, strModuleId);
			pstmt.setString(2, strModuleId);
			pstmt.setString(3, strModuleId);
			pstmt.setString(4, custCode);
			pstmt.setString(5, custGroupCode);
			rs=pstmt.executeQuery();
			if( rs != null ) 
			{	
				payer_suspended_YN="";
				while(rs.next())
				{
					payer_suspended_YN = rs.getString(1);
				}
			}
			if(payer_suspended_YN == null) payer_suspended_YN="";			
		}
		catch(Exception e){
			System.err.println("Exception in  getCustValidDates" + e);
			e.printStackTrace();
		}
		finally{
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception eInr) {
				System.err.println("Exception in  getvalidPolicyTypeCodeYN" + eInr);
				eInr.printStackTrace();
			}
		}
		return payer_suspended_YN;
	}
	
	public JsonObject getpolicySuspendedYN(String empty_sql_check,String strModuleId,String custCode,String custGrpCode, String policyTypeCode,String locale,String facility_id ,Connection con)
	{
		
		JsonObject obj=new JsonObject();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String policy_suspended_YN="";
		String policy_suspended_YN_sql="Select a.status from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b, bl_cust_by_cust_group c where a.language_id=?  and a.operating_facility_id=? and a.operating_facility_id = b.operating_facility_id and a.policy_type_code = b.policy_type_code and b.cust_code=? and b.cust_group_code=? and b.cust_group_code = c.cust_group_code and b.cust_code=c.cust_code and ((? in ('OP','AE') and nvl(b.outpatient_cover,'N') = 'Y') or (? in ('IP','DC') and nvl(b.inpatient_covered,'N') = 'Y') or (? = 'MP' and nvl(b.external_covered,'N') = 'Y')) AND b.policy_type_code =?";

		
		try{
				
				pstmt = con.prepareStatement(policy_suspended_YN_sql);
				pstmt.setString(1, locale);
				pstmt.setString(2, facility_id);
				pstmt.setString(3, custCode);
				pstmt.setString(4, custGrpCode);
				pstmt.setString(5, strModuleId);
				pstmt.setString(6, strModuleId);
				pstmt.setString(7, strModuleId);
				pstmt.setString(8, policyTypeCode);
				rs=pstmt.executeQuery();
			if( rs != null ) 
			{	
				empty_sql_check="Y";
				policy_suspended_YN="";
				while(rs.next())
	
				{
					empty_sql_check="N";
					policy_suspended_YN = rs.getString(1);
				}
			}
		
			if(empty_sql_check.equals("Y"))
			{
				policy_suspended_YN_sql="Select DISTINCT a.status from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b, bl_cust_by_cust_group c where a.language_id=?  and a.operating_facility_id=? and a.operating_facility_id = b.operating_facility_id and a.policy_type_code = b.policy_type_code and b.cust_group_code=? and b.cust_group_code = c.cust_group_code and b.cust_code = '**' and ((? in ('OP','AE') and nvl(b.outpatient_cover,'N') = 'Y') or (? in ('IP','DC') and nvl(b.inpatient_covered,'N') = 'Y') or (? = 'MP' and nvl(b.external_covered,'N') = 'Y')) AND b.policy_type_code =?";


				pstmt = con.prepareStatement(policy_suspended_YN_sql);
				pstmt.setString(1, locale);
				pstmt.setString(2, facility_id);
				pstmt.setString(3, custGrpCode);
				pstmt.setString(4, strModuleId);
				pstmt.setString(5, strModuleId);
				pstmt.setString(6, strModuleId);
				pstmt.setString(7, policyTypeCode);
				rs=pstmt.executeQuery();
				if( rs != null ) 
				{	
					empty_sql_check="Y";

					policy_suspended_YN="";
					while(rs.next())
					{
						policy_suspended_YN = rs.getString(1);
					}
				}
			}
			if(policy_suspended_YN == null) policy_suspended_YN=""; 

			obj.addProperty("policy_suspended_YN", policy_suspended_YN);
			obj.addProperty("empty_sql_check",empty_sql_check);


		}
			catch(Exception e)
			{
				System.out.println("Exception in policy_suspended_YN_sql:"+e);
			}
		finally
		{
			try {
				if (rs!= null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception eInr) {
				System.err.println("Exception in policy_suspended_YN_sql_eInr"
						+ eInr);
				eInr.printStackTrace();
			}
		}
		
		return obj;
	}
public JsonObject payerSuspendedYN(String strModuleId,String custCode,String custGrpCode,Connection con)
{
		
		JsonObject obj=new JsonObject();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
	try{
		String payer_suspended_YN_sql="select a.status status from ar_customer a, ar_cust_group b,sy_acc_entity c,bl_cust_by_cust_group e where a.acc_entity_code= b.acc_entity_code and a.acc_entity_code = c.acc_entity_code and a.patient_flag = 'Y' and NVL(a.pat_com_flag,'N') = 'N' and nvl(a.insurance_yn,'Y') = 'Y' /* and a.status is null */ and ((? in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or (? in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or (? = 'MP' and nvl(ref_yn,'N') = 'Y')) and a.cust_code = e.cust_code and b.cust_group_code = e.cust_group_code AND a.CUST_CODE =? and b.cust_group_code=?";
		String empty_sql_check="N";
		String payer_suspended_YN="";
		pstmt = con.prepareStatement(payer_suspended_YN_sql);
		pstmt.setString(1, strModuleId);
		pstmt.setString(2, strModuleId);
		pstmt.setString(3, strModuleId);
		pstmt.setString(4, custCode);
		pstmt.setString(5, custGrpCode);
		rs=pstmt.executeQuery();
		if( rs != null ) 
		{	
			empty_sql_check="Y";
			payer_suspended_YN="";
			while(rs.next())
			{
				empty_sql_check="N";
				payer_suspended_YN = rs.getString(1);
			}
		}
		
		if(payer_suspended_YN == null) payer_suspended_YN="";
		obj.addProperty("empty_sql_check", empty_sql_check);
		obj.addProperty("payer_suspended_YN", payer_suspended_YN);
		
		
		}
		catch(Exception e)
		{
			System.out.println("Exception in payer_suspended_YN_sql:"+e);
		}
		finally{
	
			try {
				if (rs!= null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				} catch (Exception eInr) {
					System.err.println("Exception in payerSuspendedYN"
							+ eInr);
					eInr.printStackTrace();
					}	
				}
		return obj;
	}
	
public JsonObject getCustDtls(String cust_group_code,String cust_code,String locale,String policy_type_code,Connection con )
{
	JsonObject obj=new JsonObject();
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	
	try
	{
		String cust_grp_desc_qry = "select short_desc SHORT_NAME from ar_cust_group_lang_vw  where  language_id=? and cust_group_code = ?";
		String cust_desc_qry = "select DECODE(?,'**',NULL, short_name) cust_short_name from ar_customer_lang_vw  where language_id=? and cust_code = ?";		
		String policy_type_desc_qry = "select short_desc policy_short_desc from bl_ins_policy_types_lang_vw  where language_id=? and policy_type_code = ?";
		String cust_group_name="";
		String cust_short_name="";
		String policy_short_desc="";
		pstmt = con.prepareStatement(cust_grp_desc_qry);
		pstmt.setString(1, locale);
		pstmt.setString(2, cust_group_code);
		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{	
			while( rs.next() )
			{  
				cust_group_name = rs.getString(1);
			}
		}
		if(cust_group_name == null) cust_group_name="";

	pstmt=con.prepareStatement(cust_desc_qry);
	pstmt = con.prepareStatement(cust_desc_qry);
	pstmt.setString(1, cust_code);
	pstmt.setString(2, locale);
	pstmt.setString(3, cust_code);
	rs = pstmt.executeQuery() ;
	if( rs != null ) 
	{	
		while( rs.next() )
		{  
			cust_short_name = rs.getString(1);
		}
	}	
	if(cust_short_name == null) cust_short_name="";
	pstmt = con.prepareStatement(policy_type_desc_qry);
	pstmt.setString(1, locale);
	pstmt.setString(2, policy_type_code);
	rs = pstmt.executeQuery() ;
	if( rs != null ) 
	{	
		while( rs.next() )
		{  
			policy_short_desc = rs.getString(1);
		}
	}

	if(policy_short_desc == null) policy_short_desc="";
	
	obj.addProperty("cust_group_name", cust_group_name);
	obj.addProperty("cust_short_name", cust_short_name);
	obj.addProperty("policy_short_desc", policy_short_desc);
	
	
	
	}
	catch(Exception e)
	{
		System.out.println("Exception in getCustDtls:"+e);
	}

	finally
	{

		try {
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			System.err.println("Exception in  getCustDtls" + e);
			e.printStackTrace();
		}
	}
	
	return obj;
	}


	public static ArrayList getListWithEmptyValues(int listSize)
	{
		ArrayList sessionValList=null;
		try{
			sessionValList=new ArrayList();
            for(int i=0; i<listSize; i++)
			{
               sessionValList.add("");
			}
		}
		catch(RuntimeException e)
		{
           e.printStackTrace();
		}
		System.out.println("AddModifyPatFinDetailsBean.java...sessionValList size...."+sessionValList.size());
		return sessionValList;
	}
}
