/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name                 	Rev.Date 		Rev.by 					Description
--------------------------------------------------------------------------------------------------------------
 21/03/2023  42761         krishna Pranay      21/03/2023     Ramesh Goli        COMMON-ICN-0125
--------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.*;
import eCommon.SingleTableHandler.*;

public class HealthRiskFactorsBean implements java.io.Serializable{
	
	public HealthRiskFactorsBean() {}
	
	private String riskFactorId;
	private String riskFactorDesc;
	private String factorType;
	private String effStatus;
	private String patientSex;
	private String riskFactorInd;
	private String riskFactorSetId;
	private String riskFactorCode;
	
	private String agrfi;
	private String ageGroupId;	
	private String agRemarks;
	
	private String allergenId;
	private String allergenRFIId;
	private String allergenRemarks;
	private String allergenStaus;
	
	private String chiefComplaintId;
	private String chiefComplaintRFIId;
	private String chiefComplaintRemarks;
	
	private String drugId;
	private String pharmacyRFIId;
	private String pharmacyRemarks;
	private String pharmacyOperator;
	
	private String diagnosisSetId;
	private String termSetCode;
	private String termSetOperator;
	private String termSetRFIId;
	private String termSetRemarks;
	
	private ArrayList<HashMap<String,String>> gridDtls;
	private String discreateMeaserType;
	private String discreateMeaserId;
	
    public String getRiskFactorId() {
       return riskFactorId;
    }
	public void setRiskFactorId(String riskFactorId) {
       this.riskFactorId = riskFactorId;
    }
    public String getRiskFactorDesc() {
       return riskFactorDesc;
    }
	public void setRiskFactorDesc(String riskFactorDesc) {
       this.riskFactorDesc = riskFactorDesc;
    }
    public String getFactorType() {
       return factorType;
    }
	public void setFactorType(String factorType) {
       this.factorType = factorType;
    }
    public String getEffStatus() {
       return effStatus;
    }
	public void setEffStatus(String effStatus) {
       this.effStatus = effStatus;
    }
	public String getPatientSex() {
		return patientSex;
	}
	
	public String getRiskFactorInd() {
		return riskFactorInd;
	}
	public void setRiskFactorInd(String riskFactorInd) {
		this.riskFactorInd = riskFactorInd;
	}
	public String getRiskFactorSetId() {
		return riskFactorSetId;
	}
	public void setRiskFactorSetId(String riskFactorSetId) {
		this.riskFactorSetId = riskFactorSetId;
	}
	public String getRiskFactorCode() {
		return riskFactorCode;
	}
	public void setRiskFactorCode(String riskFactorCode) {
		this.riskFactorCode = riskFactorCode;
	}
	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}
	
	public String getAgrfi() {
		return agrfi;
	}
	public void setAgrfi(String agrfi) {
		this.agrfi = agrfi;
	}
	public String getAgeGroupId() {
		return ageGroupId;
	}
	public void setAgeGroupId(String ageGroupId) {
		this.ageGroupId = ageGroupId;
	}	
	public String getAgRemarks() {
		return agRemarks;
	}
	public void setAgRemarks(String agRemarks) {
		this.agRemarks = agRemarks;
	}
	
	
	
	public String getAllergenId() {
		return allergenId;
	}
	public void setAllergenId(String allergenId) {
		this.allergenId = allergenId;
	}
	public String getAllergenRFIId() {
		return allergenRFIId;
	}
	public void setAllergenRFIId(String allergenRFIId) {
		this.allergenRFIId = allergenRFIId;
	}
	public String getAllergenRemarks() {
		return allergenRemarks;
	}
	public void setAllergenRemarks(String allergenRemarks) {
		this.allergenRemarks = allergenRemarks;
	}
	public String getAllergenStaus() {
		return allergenStaus;
	}
	public void setAllergenStaus(String allergenStaus) {
		this.allergenStaus = allergenStaus;
	}
	
	
	
	public String getChiefComplaintId() {
		return chiefComplaintId;
	}
	public void setChiefComplaintId(String chiefComplaintId) {
		this.chiefComplaintId = chiefComplaintId;
	}
	public String getChiefComplaintRFIId() {
		return chiefComplaintRFIId;
	}
	public void setChiefComplaintRFIId(String chiefComplaintRFIId) {
		this.chiefComplaintRFIId = chiefComplaintRFIId;
	}
	public String getChiefComplaintRemarks() {
		return chiefComplaintRemarks;
	}
	public void setChiefComplaintRemarks(String chiefComplaintRemarks) {
		this.chiefComplaintRemarks = chiefComplaintRemarks;
	}
	
	
	public ArrayList<HashMap<String, String>> getGridDtls() {
		return gridDtls;
	}
	public void setGridDtls(ArrayList<HashMap<String, String>> gridDtls) {
		this.gridDtls = gridDtls;
	}
	
	public String getDiscreateMeaserType() {
		return discreateMeaserType;
	}
	public void setDiscreateMeaserType(String discreateMeaserType) {
		this.discreateMeaserType = discreateMeaserType;
	}
	public String getDiscreateMeaserId() {
		return discreateMeaserId;
	}
	public void setDiscreateMeaserId(String discreateMeaserId) {
		this.discreateMeaserId = discreateMeaserId;
	}
	
	
	
	public String getDrugId() {
		return drugId;
	}
	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}
	public String getPharmacyRFIId() {
		return pharmacyRFIId;
	}
	public void setPharmacyRFIId(String pharmacyRFIId) {
		this.pharmacyRFIId = pharmacyRFIId;
	}
	public String getPharmacyRemarks() {
		return pharmacyRemarks;
	}
	public void setPharmacyRemarks(String pharmacyRemarks) {
		this.pharmacyRemarks = pharmacyRemarks;
	}
	public String getPharmacyOperator() {
		return pharmacyOperator;
	}
	public void setPharmacyOperator(String pharmacyOperator) {
		this.pharmacyOperator = pharmacyOperator;
	}
	
	
	
	
	public String getDiagnosisSetId() {
		return diagnosisSetId;
	}
	public void setDiagnosisSetId(String diagnosisSetId) {
		this.diagnosisSetId = diagnosisSetId;
	}
	public String getTermSetCode() {
		return termSetCode;
	}
	public void setTermSetCode(String termSetCode) {
		this.termSetCode = termSetCode;
	}
	public String getTermSetOperator() {
		return termSetOperator;
	}
	public void setTermSetOperator(String termSetOperator) {
		this.termSetOperator = termSetOperator;
	}
	public String getTermSetRFIId() {
		return termSetRFIId;
	}
	public void setTermSetRFIId(String termSetRFIId) {
		this.termSetRFIId = termSetRFIId;
	}
	public String getTermSetRemarks() {
		return termSetRemarks;
	}
	public void setTermSetRemarks(String termSetRemarks) {
		this.termSetRemarks = termSetRemarks;
	}
	
	public void getHealthRiskFactorsDeatils(String riskFactoryId) throws Exception 
	{
		
		PreparedStatement pstmt = null;
		ResultSet resultSet 	= null;
		Connection con 			= null;
		String factorType		= "";
		String factorInd		= "";
		String factorSetId		= "";
		String factorCode		= "";
		try{
			con = ConnectionManager.getConnection();
			pstmt		= con.prepareStatement("SELECT FT.RISK_FACTOR_TYPE RISK_FACTOR_TYPE,FT.RISK_FACTOR_DESC RISK_FACTOR_DESC,FT.EFF_STATUS EFF_STATUS,FTR.RISK_FACTOR_IND RISK_FACTOR_IND,FTR.RISK_FACTOR_SET_ID RISK_FACTOR_SET_ID,FTR.RISK_FACTOR_CODE RISK_FACTOR_CODE FROM CA_RISK_FACTOR_TYPE FT,CA_RISK_FACTOR FTR WHERE FT.RISK_FACTOR_TYPE=FTR.RISK_FACTOR_TYPE AND FT.RISK_FACTOR_TYPE=?");			
			pstmt.setString(1, riskFactoryId);
			resultSet	= pstmt.executeQuery() ;			
			if(resultSet.next())
			{
				factorType 	= (String)resultSet.getString("RISK_FACTOR_TYPE");
				factorInd	= (String)resultSet.getString("RISK_FACTOR_IND");
				factorSetId	= (String)resultSet.getString("RISK_FACTOR_SET_ID");
				factorCode	= (String)resultSet.getString("RISK_FACTOR_CODE");
				
				setRiskFactorId(factorType);
				setRiskFactorDesc((String)resultSet.getString("RISK_FACTOR_DESC"));				
				setEffStatus((String)resultSet.getString("EFF_STATUS"));				
				setFactorType(factorInd);	
				
				setRiskFactorInd(factorInd);
				setRiskFactorSetId(factorSetId);
				setRiskFactorCode(factorCode);
				
			}
			if(resultSet != null)resultSet.close();
			if(pstmt != null)pstmt.close();			
			if(!"".equals(factorType)){
				if("AG".equals(factorInd)){
					pstmt		= con.prepareStatement("SELECT SRL_NO,PATIENT_SEX,RISK_FACTOR_SCORE_IND,RISK_FACTOR_MESG FROM CA_RISK_FACTOR_DTL WHERE RISK_FACTOR_TYPE=? AND RISK_FACTOR_IND=? AND RISK_FACTOR_SET_ID=? AND RISK_FACTOR_CODE=?");			
					pstmt.setString(1, factorType);
					pstmt.setString(2, factorInd);
					pstmt.setString(3, factorSetId);
					pstmt.setString(4, factorCode);
					
					resultSet	= pstmt.executeQuery() ;
					if(resultSet.next()){
						setAgeGroupId(factorCode);
						setPatientSex((String)resultSet.getString("PATIENT_SEX"));
						setAgrfi((String)resultSet.getString("RISK_FACTOR_SCORE_IND"));
						setAgRemarks((String)resultSet.getString("RISK_FACTOR_MESG"));
					}
				}else if("AL".equals(factorInd)){
					pstmt		= con.prepareStatement("SELECT SRL_NO,PATIENT_SEX,RISK_FACTOR_SCORE_IND,RISK_FACTOR_MESG,RISK_FACTOR_OPERATOR FROM CA_RISK_FACTOR_DTL WHERE RISK_FACTOR_TYPE=? AND RISK_FACTOR_IND=? AND RISK_FACTOR_SET_ID=? AND RISK_FACTOR_CODE=?");			
					pstmt.setString(1, factorType);
					pstmt.setString(2, factorInd);
					pstmt.setString(3, factorSetId);
					pstmt.setString(4, factorCode);
					
					resultSet	= pstmt.executeQuery() ;
					if(resultSet.next()){
						setAllergenId(factorCode); 
						setPatientSex((String)resultSet.getString("PATIENT_SEX"));
						setAllergenRFIId((String)resultSet.getString("RISK_FACTOR_SCORE_IND"));
						setAllergenRemarks((String)resultSet.getString("RISK_FACTOR_MESG"));
						setAllergenStaus((String)resultSet.getString("RISK_FACTOR_OPERATOR"));
					}
				}else if("CC".equals(factorInd)){
					pstmt		= con.prepareStatement("SELECT SRL_NO,PATIENT_SEX,RISK_FACTOR_SCORE_IND,RISK_FACTOR_MESG FROM CA_RISK_FACTOR_DTL WHERE RISK_FACTOR_TYPE=? AND RISK_FACTOR_IND=? AND RISK_FACTOR_SET_ID=? AND RISK_FACTOR_CODE=?");			
					pstmt.setString(1, factorType);
					pstmt.setString(2, factorInd);
					pstmt.setString(3, factorSetId);
					pstmt.setString(4, factorCode);
					
					resultSet	= pstmt.executeQuery() ;
					if(resultSet.next()){
						setChiefComplaintId(factorCode);
						setPatientSex((String)resultSet.getString("PATIENT_SEX"));
						setChiefComplaintRFIId((String)resultSet.getString("RISK_FACTOR_SCORE_IND"));
						setChiefComplaintRemarks((String)resultSet.getString("RISK_FACTOR_MESG"));
					}
				}else if("PH".equals(factorInd)){
					pstmt		= con.prepareStatement("SELECT SRL_NO,PATIENT_SEX,RISK_FACTOR_SCORE_IND,RISK_FACTOR_MESG,RISK_FACTOR_OPERATOR FROM CA_RISK_FACTOR_DTL WHERE RISK_FACTOR_TYPE=? AND RISK_FACTOR_IND=? AND RISK_FACTOR_SET_ID=? AND RISK_FACTOR_CODE=?");			
					pstmt.setString(1, factorType);
					pstmt.setString(2, factorInd);
					pstmt.setString(3, factorSetId);
					pstmt.setString(4, factorCode);
					
					resultSet	= pstmt.executeQuery() ;
					if(resultSet.next()){
						setDrugId(factorCode);
						setPatientSex((String)resultSet.getString("PATIENT_SEX"));
						setPharmacyRFIId((String)resultSet.getString("RISK_FACTOR_SCORE_IND"));
						setPharmacyRemarks((String)resultSet.getString("RISK_FACTOR_MESG"));
						setPharmacyOperator((String)resultSet.getString("RISK_FACTOR_OPERATOR"));
					}
				}else if("CA".equals(factorInd)||"LB".equals(factorInd) ||"OR".equals(factorInd)  ||"RD".equals(factorInd) ||"BM".equals(factorInd)){
					pstmt		= con.prepareStatement("SELECT SRL_NO,PATIENT_SEX,ALL_AGE_YN,START_AGE,START_AGE_UNITS,END_AGE,END_AGE_UNITS,START_AGE_DAYS,END_AGE_DAYS," +
							"RISK_FACTOR_OPER_IND,RISK_FACTOR_OPERATOR,RISK_FACTOR_FRM_VAL,RISK_FACTOR_FRM_UNIT,RISK_FACTOR_TO_VAL,RISK_FACTOR_TO_UNIT,RISK_FACTOR_SCORE_IND,RISK_FACTOR_SCORE,RISK_FACTOR_MESG,RISK_FACTOR_OCCUR FROM CA_RISK_FACTOR_DTL WHERE RISK_FACTOR_TYPE=? AND RISK_FACTOR_IND=? AND RISK_FACTOR_SET_ID=? AND RISK_FACTOR_CODE=? ORDER BY SRL_NO");			
					pstmt.setString(1, factorType);
					pstmt.setString(2, factorInd);
					pstmt.setString(3, factorSetId);
					pstmt.setString(4, factorCode);
					
					String discreateMeaserType_ ="";					
					resultSet	= pstmt.executeQuery() ;
					ArrayList<HashMap<String,String>> resultData = new ArrayList<HashMap<String,String>>();
					while(resultSet.next()){
						HashMap<String,String> dataHash= new HashMap<String,String>();
						
						dataHash.put("SRL_NO", (String)resultSet.getString("SRL_NO"));
						dataHash.put("PATIENT_SEX", (String)resultSet.getString("PATIENT_SEX"));
						dataHash.put("ALL_AGE_YN", (String)resultSet.getString("ALL_AGE_YN"));
						dataHash.put("START_AGE", (String)resultSet.getString("START_AGE"));
						dataHash.put("START_AGE_UNITS", (String)resultSet.getString("START_AGE_UNITS"));
						dataHash.put("END_AGE", (String)resultSet.getString("END_AGE"));
						dataHash.put("END_AGE_UNITS", (String)resultSet.getString("END_AGE_UNITS"));
						discreateMeaserType_ = (String)resultSet.getString("RISK_FACTOR_OPER_IND");
						dataHash.put("RISK_FACTOR_OPERATOR", (String)resultSet.getString("RISK_FACTOR_OPERATOR"));
						dataHash.put("RISK_FACTOR_FRM_VAL", (String)resultSet.getString("RISK_FACTOR_FRM_VAL"));
						dataHash.put("RISK_FACTOR_TO_VAL", (String)resultSet.getString("RISK_FACTOR_TO_VAL"));
						dataHash.put("RISK_FACTOR_SCORE_IND", (String)resultSet.getString("RISK_FACTOR_SCORE_IND"));
						dataHash.put("RISK_FACTOR_MESG", (String)resultSet.getString("RISK_FACTOR_MESG"));	
						dataHash.put("RISK_FACTOR_FRM_UNIT", (String)resultSet.getString("RISK_FACTOR_FRM_UNIT"));	
						dataHash.put("RISK_FACTOR_TO_UNIT", (String)resultSet.getString("RISK_FACTOR_TO_UNIT"));	
						dataHash.put("RISK_FACTOR_OCCUR", (String)resultSet.getString("RISK_FACTOR_OCCUR"));							
						resultData.add(dataHash);
					}
					
					setDiscreateMeaserId(factorCode);
					setGridDtls(resultData);
					setDiscreateMeaserType(discreateMeaserType_);
					
				}else if("TS".equals(factorInd)){
					pstmt		= con.prepareStatement("SELECT SRL_NO,PATIENT_SEX,RISK_FACTOR_SCORE_IND,RISK_FACTOR_MESG,RISK_FACTOR_OPERATOR FROM CA_RISK_FACTOR_DTL WHERE RISK_FACTOR_TYPE=? AND RISK_FACTOR_IND=? AND RISK_FACTOR_SET_ID=? AND RISK_FACTOR_CODE=?");			
					pstmt.setString(1, factorType);
					pstmt.setString(2, factorInd);
					pstmt.setString(3, factorSetId);
					pstmt.setString(4, factorCode);
					
					resultSet	= pstmt.executeQuery() ;
					if(resultSet.next()){
						setDiagnosisSetId(factorSetId);
						setTermSetCode(factorCode);						
						setPatientSex((String)resultSet.getString("PATIENT_SEX"));
						setTermSetRFIId((String)resultSet.getString("RISK_FACTOR_SCORE_IND"));
						setTermSetRemarks((String)resultSet.getString("RISK_FACTOR_MESG"));
						setTermSetOperator((String)resultSet.getString("RISK_FACTOR_OPERATOR"));
					}
				}
			}
			
		}catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			if(resultSet != null)resultSet.close();
			if(pstmt != null)pstmt.close();
			if(con != null)	con.close();
		}
		
	}
	public ResultSet getGrpRiskFactorType(String groupCode, Connection con) throws Exception{		
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		String sql = "";
		try{
			sql = "Select RG.RISK_FACTOR_TYPE, RT.RISK_FACTOR_DESC from CA_GROUP_RISK_FACTOR_DTL RG , CA_RISK_FACTOR_TYPE RT where RT.RISK_FACTOR_TYPE = RG.RISK_FACTOR_TYPE and RG.RISK_FACTOR_GROUP = ? ";		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, groupCode);
			rSet	= pstmt.executeQuery() ;
		}
		catch(Exception ex){
			ex.getMessage();
		}
		
		return rSet; 
	}
	public String getDiagnosisSetValues(String locale,Connection con)  throws Exception 
	{	
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String  description	="";
		String  value="";
		
		try
		{
			
			String sql = "select mr_get_desc.mr_term_set(term_set_id,?,1)term_set_desc, term_set_id from MR_TERM_SET where eff_status='E' order by term_set_desc";
			pstmt			= con.prepareStatement(sql);
			pstmt.setString(1,locale);
			resultSet		= pstmt.executeQuery() ;
			StringBuffer sb	= new StringBuffer();
			while (resultSet!=null && resultSet.next())
			{
				  description		= resultSet.getString(1);
				  value			= resultSet.getString(2);
				  sb.append(value+ "," + description + ",");
			}

			String str =   sb.toString() ;
			sb.setLength(0);
			
			return str.substring(0, str.length()-1);			 
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			return null;
		}
		finally
		{
			try
			{	
				if(resultSet!= null) resultSet.close();
				if (pstmt!= null) pstmt.close();				
			}
			catch(Exception e)
			{
				 e.printStackTrace() ;
			}
		}
	}
	
	public ResultSet getRiskFactDiseaseDetails(String termSetID, String termSetCode, String riskGrp_type, Connection con) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		String sql = "";
		try{
			System.out.println(" 476 RISK GROUP TYPE  "+ riskGrp_type);
			
			sql = "select RISK_FACTOR, FACTOR_MAND_YN,RISK_GRP_TYPE risk_group_type ,case when RISK_GRP_TYPE = 'G' then  (select RISK_FACTOR_DESC from CA_GROUP_RISK_FACTOR_TYPE where  RISK_FACTOR_GROUP = RISK_FACTOR) when RISK_GRP_TYPE = 'I' then (select RISK_FACTOR_DESC from CA_RISK_FACTOR_TYPE where  RISK_FACTOR_TYPE = RISK_FACTOR) END risk_factor_desc from CA_DIAG_RISK_FACTOR  where TERM_SET_ID = ? and TERM_SET_CODE = ?";
			
			System.out.println(" SQL QUERY " + sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, termSetID);
			pstmt.setString(2,termSetCode);
			rSet	= pstmt.executeQuery() ;
		}
		catch(Exception ex){
			ex.getMessage();
		}
		return rSet;
	}
}	
