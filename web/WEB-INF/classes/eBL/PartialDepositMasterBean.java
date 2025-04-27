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
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
18-Mar-2013   100           	Karthikeyan.K       created for MMS-CRF-0023
---------------------------------------------------------------------------------------------------------------
*/
package eBL;

import java.io.Serializable;
import java.sql.CallableStatement;
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


public class PartialDepositMasterBean extends BlAdapter implements
		Serializable {	
	
	public boolean checkValidPartialDepositCase(String facility_id,String patient_id,String package_code,String package_seq_no,String billingClass,Connection con) throws SQLException{
		boolean isValidCase=false;
		int totalRecCount=0;
		int encounterSequenceNo= getEncounterSequenceNo(patient_id,package_seq_no,con);
		//HashMap<String,String> hashMapCode= getCodesForPackage(patient_id,package_code,package_seq_no);
		//String blngClassCode = hashMapCode.get("blngClassCode");
		
		//Connection con	=	ConnectionManager.getConnection();
		PreparedStatement pstmtChrg = null;
		ResultSet rsChrg = null;
		//Added below logics for IN 55781
		String isAcrossEncYN = "N";
		String isPartDepositAllowed = "N";
		
		try{
			pstmtChrg = con.prepareStatement(BlRepository.getBlKeyValue("BL_PKG_ACROSS_ENC_YN"));
			pstmtChrg.setString(1,facility_id );
			pstmtChrg.setString(2, package_code);
			rsChrg = pstmtChrg.executeQuery() ;
			if(rsChrg != null && rsChrg.next()){
				isAcrossEncYN = rsChrg.getString("across_encounter_yn");
			}
			
			if("Y".equals(isAcrossEncYN)){
				pstmtChrg = null;
				rsChrg = null;
				pstmtChrg = con.prepareStatement(BlRepository.getBlKeyValue("BL_PKG_PART_DEP_ALLOWED_YN"));
				pstmtChrg.setString(1, facility_id);
				pstmtChrg.setString(2, package_code);
				pstmtChrg.setString(3, billingClass);
				pstmtChrg.setString(4, facility_id);
				pstmtChrg.setString(5, package_code);
				pstmtChrg.setString(6, billingClass);
				rsChrg = pstmtChrg.executeQuery() ;
				if(rsChrg != null && rsChrg.next()){
					isPartDepositAllowed = rsChrg.getString("allow_partial_deposit_yn");
				}
			}
			
			if("Y".equals(isAcrossEncYN) && "Y".equals(isPartDepositAllowed)){
				pstmtChrg = null;
				rsChrg = null;
				pstmtChrg = con.prepareStatement("select count(*) from bl_package_deposit_dtls where OPERATING_FACILITY_ID=? and PACKAGE_CODE=? and ENCOUNTER_SEQ_NO=? and ( BLNG_CLASS_CODE=? OR blng_class_code = '**')");
				pstmtChrg.setString(1,facility_id);
				pstmtChrg.setString(2,package_code);
				pstmtChrg.setInt(3,encounterSequenceNo);
				pstmtChrg.setString(4,billingClass);
				
				rsChrg = pstmtChrg.executeQuery() ;
				if( rsChrg != null ) 
				{	
					while( rsChrg.next() )
					{  
						String strRecordCount = rsChrg.getString(1);
						totalRecCount=Integer.parseInt(strRecordCount);
					}
				}
				if (rsChrg != null){
					rsChrg.close();
				}
				if (pstmtChrg!=null){
					pstmtChrg.close();
				}
				/*if (con != null) {
					con.close();
				}*/
				if(totalRecCount>0) isValidCase=true;		
			}
		}
		catch(Exception e){
			System.err.println("Exception in method checkValidPartialDepositCase ->"+e);
			isPartDepositAllowed= "N";
			e.printStackTrace();
		}		
		pstmtChrg = null;
		rsChrg = null;
		
		System.out.println("PartialDepositMasterBean isValidCase:"+isValidCase);	
		return isValidCase;
	}	
	
	public float getPartialDepositAmount(String facility_id,String patient_id,String package_code,String package_seq_no,Connection con) throws SQLException{
		float partialDepositAmount=0;
		float totalDepositAmount=0;
		
		/*Getting Package Codes to find out Price*/
		HashMap<String,String> hashMapCode= getCodesForPackage(patient_id,package_code,package_seq_no,con);
		String blngClassCode = hashMapCode.get("blngClassCode");
		String custGrpCode = hashMapCode.get("custGrpCode");
		String custCode = hashMapCode.get("custCode");
		
		totalDepositAmount=GetPackagePrice(facility_id, package_code,blngClassCode, custGrpCode,  custCode,con);
		int encounterSequenceNo= getEncounterSequenceNo(patient_id,package_seq_no,con);
		partialDepositAmount=calculatePartialDepositAmountFromDB(facility_id,package_code,encounterSequenceNo,totalDepositAmount,blngClassCode,con);		
		
		return partialDepositAmount;
	}
	
	public float getMinimumDepositAmount(String facility_id,String patient_id,String package_code,String package_seq_no,Connection con) throws SQLException{
		float partialDepositAmount=0;//minDepositAmount
		float totalDepositAmount=0;
		
		/*Getting Package Codes to find out Price*/
		HashMap<String,String> hashMapCode= getCodesForPackage(patient_id,package_code,package_seq_no,con);
		String blngClassCode = hashMapCode.get("blngClassCode");
		String custGrpCode = hashMapCode.get("custGrpCode");
		String custCode = hashMapCode.get("custCode");
		
		totalDepositAmount=GetPackagePrice(facility_id, package_code,blngClassCode, custGrpCode,  custCode,con);
		int encounterSequenceNo= getEncounterSequenceNo(patient_id,package_seq_no,con);
		partialDepositAmount=calculateMinimumDepositAmountFromDB(facility_id,package_code,encounterSequenceNo,totalDepositAmount,blngClassCode,con);		
		
		return partialDepositAmount;
	}
	
	public float calculateMinimumDepositAmountFromDB(String facilityId,String package_code,int encounterSequenceNo,float totalDepositAmount,String blngClassCode,Connection con) throws SQLException{		
		//Connection con	=	ConnectionManager.getConnection();
		float partialDepositAmount=0;//Minimum Deposit Amount

		PreparedStatement pstmtChrg = con.prepareStatement("select MIN_PARTIAL_DEPOSIT_TYPE,MIN_PARTIAL_DEPOSIT from bl_package_deposit_dtls where OPERATING_FACILITY_ID=? and PACKAGE_CODE=? and ENCOUNTER_SEQ_NO=? and ( BLNG_CLASS_CODE=? OR blng_class_code = '**') and NVL(Deposit_mandatory_yn,'N') = 'Y' order by  decode(BLNG_CLASS_CODE ,'**',999,1) ");
		pstmtChrg.setString(1,facilityId);
		pstmtChrg.setString(2,package_code);
		pstmtChrg.setInt(3,encounterSequenceNo);
		pstmtChrg.setString(4,blngClassCode);
		
		ResultSet rsChrg = pstmtChrg.executeQuery() ;
		
		String strPartialDepositType = null;
		String strPartialDeposit = null;
		if( rsChrg != null ) 
		{	
			if( rsChrg.next() )
			{  
				strPartialDepositType = rsChrg.getString(1);
				strPartialDeposit = rsChrg.getString(2);
				if(strPartialDepositType.equals("P")){
					float partialFactor=Float.parseFloat(strPartialDeposit)/100;
					partialDepositAmount=partialFactor*totalDepositAmount;
				}else{
					partialDepositAmount=Float.parseFloat(strPartialDeposit);
				}
				
			}
		}	
		if (rsChrg != null) rsChrg.close();
		if (pstmtChrg!=null) pstmtChrg.close(); 
		//if (con != null) con.close();
		
		return partialDepositAmount;			
	}
	
	public HashMap<String,String> getCodesForPackage(String patient_id,String package_code,String package_seq_no,Connection con) throws SQLException{	
		
	//Connection con	=	ConnectionManager.getConnection();
	HashMap<String,String> hashMapCode=new HashMap<String,String>();	
	PreparedStatement pstmtChrg = con.prepareStatement("select BLNG_CLASS_CODE,CUST_GROUP_CODE,CUST_CODE from bl_package_sub_hdr where PATIENT_ID=? and package_code =? and PACKAGE_SEQ_NO=?");
	pstmtChrg.setString(1,patient_id);
	pstmtChrg.setString(2,package_code);
	pstmtChrg.setString(3,package_seq_no);
	ResultSet rsChrg = pstmtChrg.executeQuery() ;
	if( rsChrg != null ) 
	{	
		while( rsChrg.next() )
		{  
			String blngClassCode = rsChrg.getString(1);
			String custGrpCode = rsChrg.getString(2);
			String custCode = rsChrg.getString(3);
			hashMapCode.put("blngClassCode",blngClassCode);
			hashMapCode.put("custGrpCode",custGrpCode);
			hashMapCode.put("custCode",custCode);
		}
	}
	if (rsChrg != null){
		rsChrg.close();
	}
	if (pstmtChrg!=null){
		pstmtChrg.close();
	}
	/*if (con != null) {
		con.close();
	}*/	

	System.out.println("PartialDepositMasterBean hashMapCode:"+hashMapCode);
	return hashMapCode;		
	}
	
	public float GetPackagePrice(String facilityId, String package_code,String blngClassCode, String custGrpCode, String custCode,Connection con)	throws SQLException {		
		//Connection con = ConnectionManager.getConnection();
		CallableStatement callstmt = con.prepareCall("{ call blpackage.GetPackagePrice(?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?)}"); //Added new parameter V171221-Gayathri/MMS-DM-CRF-0118
		callstmt.setString(1, facilityId);
		callstmt.setString(2, package_code);
		callstmt.setString(3, blngClassCode); // blng_class_code
		callstmt.setString(4, custGrpCode); // payerGrpCode
		callstmt.setString(5, custCode); // payerCode
		callstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
		callstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
		callstmt.registerOutParameter(8, java.sql.Types.VARCHAR);
		callstmt.registerOutParameter(9, java.sql.Types.VARCHAR);
		callstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
		callstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
		callstmt.registerOutParameter(12, java.sql.Types.VARCHAR);
		callstmt.registerOutParameter(13, java.sql.Types.VARCHAR);
		callstmt.registerOutParameter(14, java.sql.Types.VARCHAR); //Added new parameter V171221-Gayathri/MMS-DM-CRF-0118
		
		callstmt.execute();
		String pkgPrice = callstmt.getString(6);
		float totalDepositAmount = Float.parseFloat(pkgPrice);
		
		if (callstmt!=null){
			callstmt.close();
		}
		/*if (con != null) {
			con.close();
		}*/

		System.out.println("totalDepositAmount:" + totalDepositAmount);
		return totalDepositAmount;
	}
	
	public int getEncounterSequenceNo(String patient_id,String package_seq_no,Connection con) throws SQLException{		
		//Connection con	=	ConnectionManager.getConnection();
		int encounterSequenceNo=0;
		
		PreparedStatement pstmtChrg = con.prepareStatement("select  count(*) from BL_RECEIPT_REFUND_HDR where patient_id =? and  PACKAGE_SEQ_NO =?");
		pstmtChrg.setString(1,patient_id);
		pstmtChrg.setString(2,package_seq_no);
		ResultSet rsChrg = pstmtChrg.executeQuery() ;
		if( rsChrg != null ) 
		{	
			while( rsChrg.next() )
			{  
				String strTotalVisit = rsChrg.getString(1);
				encounterSequenceNo=Integer.parseInt(strTotalVisit) + 1;
			}
		}
		if (rsChrg != null) rsChrg.close();
		if (pstmtChrg!=null) pstmtChrg.close();
		//if (con != null) con.close();
		System.out.println("PartialDepositMasterBean encounterSequenceNo:"+encounterSequenceNo);
		return encounterSequenceNo;
	}
		
	public float calculatePartialDepositAmountFromDB(String facilityId,String package_code,int encounterSequenceNo,float totalDepositAmount,String blngClassCode,Connection con) throws SQLException{	
		
		//Connection con	=	ConnectionManager.getConnection();
		float partialDepositAmount=0;

		PreparedStatement pstmtChrg = con.prepareStatement("select MIN_PARTIAL_DEPOSIT_TYPE,MIN_PARTIAL_DEPOSIT from bl_package_deposit_dtls where OPERATING_FACILITY_ID=? and PACKAGE_CODE=? and ENCOUNTER_SEQ_NO=? and ( BLNG_CLASS_CODE=? OR blng_class_code = '**') order by  decode(BLNG_CLASS_CODE ,'**',999,1) ");
		pstmtChrg.setString(1,facilityId);
		pstmtChrg.setString(2,package_code);
		pstmtChrg.setInt(3,encounterSequenceNo);
		pstmtChrg.setString(4,blngClassCode);
		
		ResultSet rsChrg = pstmtChrg.executeQuery();
		
		String strPartialDepositType = null;
		String strPartialDeposit = null;
		if( rsChrg != null ) 
		{	
			if( rsChrg.next() )
			{  
				strPartialDepositType = rsChrg.getString(1);
				strPartialDeposit = rsChrg.getString(2);
				if(strPartialDepositType.equals("P")){
					float partialFactor=Float.parseFloat(strPartialDeposit)/100;
					partialDepositAmount=partialFactor*totalDepositAmount;
				}else{
					partialDepositAmount=Float.parseFloat(strPartialDeposit);
				}
				
			}
		}	
		if (rsChrg != null) rsChrg.close();
		if (pstmtChrg!=null) pstmtChrg.close(); 
		//if (con != null) con.close();
		
		System.out.println("MIN_PARTIAL_DEPOSIT partialDepositAmount:"+partialDepositAmount);
		return partialDepositAmount;		
	}
	
	public String getChargeLogic(String facilityId) throws SQLException{
		String strChargeLogic="N";
		Connection con= ConnectionManager.getConnection();
		PreparedStatement pstmtChrg = con.prepareStatement("select NVL(CHARGE_LOGIC_YN,'N')  from bl_parameters where OPERATING_FACILITY_ID =?");
		pstmtChrg.setString(1,facilityId);
		ResultSet rsChrg = pstmtChrg.executeQuery() ;
		if( rsChrg != null ) 
		{	
			while( rsChrg.next() )
			{  
				strChargeLogic = rsChrg.getString(1);
				if(strChargeLogic==null){
				strChargeLogic="N";
				}
			}
		}
		if (rsChrg != null) rsChrg.close();
		if (pstmtChrg!=null) pstmtChrg.close();
		if (con != null) con.close();
		return strChargeLogic;
	}
}