/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------------------------------
Date       	 Name        	Description
-----------------------------------------------------------------------------------------------
30/07/2020   G.Niveditha    created

-----------------------------------------------------------------------------------------------
*/
package eXH;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.lang.*;
import eXH.*;
import eXH.resources.*;
import webbeans.eCommon.*;

public class XHCustomerGroup implements java.io.Serializable
{
	
	public XHPatientDetailsBean getPatientDetails(String PatientID) throws Exception {

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		XHPatientDetailsBean patientDetails = new XHPatientDetailsBean();
		
		try {
			connection = ConnectionManager.getConnection() ;
		
			pstmt = connection.prepareStatement("SELECT PATIENT_ID, NATIONAL_ID_NO, ALT_ID1_TYPE, ALT_ID1_NO, ALT_ID2_TYPE, ALT_ID2_NO, ALT_ID3_TYPE, ALT_ID3_NO, ALT_ID4_TYPE, ALT_ID4_NO, OTH_ALT_ID_TYPE, OTH_ALT_ID_NO FROM MP_PATIENT WHERE PATIENT_ID= ?") ;

			pstmt.setString(1,PatientID);
			resultSet = pstmt.executeQuery() ;
			
			while (resultSet != null && resultSet.next() ) {
				
				patientDetails.setPatientId(((resultSet.getString("PATIENT_ID") != null) ? resultSet.getString("PATIENT_ID") : ""));
				patientDetails.setNationalId(((resultSet.getString("NATIONAL_ID_NO") != null) ? resultSet.getString("NATIONAL_ID_NO") : ""));
				patientDetails.setAltId1Type(((resultSet.getString("ALT_ID1_TYPE") != null) ? resultSet.getString("ALT_ID1_TYPE") : ""));
				patientDetails.setAltId1No(((resultSet.getString("ALT_ID1_NO") != null) ? resultSet.getString("ALT_ID1_NO") : ""));
				patientDetails.setAltId2Type(((resultSet.getString("ALT_ID2_TYPE") != null) ? resultSet.getString("ALT_ID2_TYPE") : ""));
				patientDetails.setAltId2No(((resultSet.getString("ALT_ID2_NO") != null) ? resultSet.getString("ALT_ID2_NO") : ""));
				patientDetails.setAltId3Type(((resultSet.getString("ALT_ID3_TYPE") != null) ? resultSet.getString("ALT_ID3_TYPE") : ""));
				patientDetails.setAltId3No(((resultSet.getString("ALT_ID3_NO") != null) ? resultSet.getString("ALT_ID3_NO") : ""));
				patientDetails.setAltId4Type(((resultSet.getString("ALT_ID4_TYPE") != null) ? resultSet.getString("ALT_ID4_TYPE") : ""));
				patientDetails.setAltId4No(((resultSet.getString("ALT_ID4_NO") != null) ? resultSet.getString("ALT_ID4_NO") : ""));
				patientDetails.setOthAltIdType(((resultSet.getString("OTH_ALT_ID_TYPE") != null) ? resultSet.getString("OTH_ALT_ID_TYPE") : ""));
				patientDetails.setOthAltIdNo(((resultSet.getString("OTH_ALT_ID_NO") != null) ? resultSet.getString("OTH_ALT_ID_NO") : ""));
				
			}
		}catch (Exception e){
			e.printStackTrace();
			throw e;
		}finally {
			//pstmt.close();
			//resultSet.close();	
			XHUtil.closeDBResources(resultSet, pstmt, connection);
		}
		return patientDetails;
	}
	
	public XHCustomerGroupBean getCustGroupDetails(String CustGroupCode) throws Exception {

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		XHCustomerGroupBean custGroupDetails = new XHCustomerGroupBean();
		
		try {
			connection = ConnectionManager.getConnection() ;
		
			pstmt = connection.prepareStatement("SELECT CUST_GROUP_CODE, OP_INTERFACE_YN, EM_INTERFACE_YN, IP_INTERFACE_YN, DC_INTERFACE_YN, " +
					"NATID_MAND_FLAG, MAND_ALTID1, MAND_ALTID2, MAND_ALTID3, MAND_ALTID4, MAND_ALTID5, MEMBSHPID_MAND_FLAG, VISIT_REG_PROC_FLAG, " +
					"POLICYNO_MAND_FLAG, CITIZEN_MAND_ALTID1, CITIZEN_MAND_ALTID2, CITIZEN_MAND_ALTID3, CITIZEN_MAND_ALTID4, CITIZEN_MAND_ALTID5 " +
					"FROM AR_CUST_GROUP WHERE CUST_GROUP_CODE= ?") ;

			pstmt.setString(1,CustGroupCode);
			resultSet = pstmt.executeQuery() ;

			while (resultSet != null && resultSet.next() ) {
				
				custGroupDetails.setCustGroupCode(((resultSet.getString("CUST_GROUP_CODE") != null) ? resultSet.getString("CUST_GROUP_CODE") : ""));
				custGroupDetails.setOpInterface(((resultSet.getString("OP_INTERFACE_YN") != null) ? resultSet.getString("OP_INTERFACE_YN") : ""));
				custGroupDetails.setEmInterface(((resultSet.getString("EM_INTERFACE_YN") != null) ? resultSet.getString("EM_INTERFACE_YN") : ""));
				custGroupDetails.setIpInterface(((resultSet.getString("IP_INTERFACE_YN") != null) ? resultSet.getString("IP_INTERFACE_YN") : ""));
				custGroupDetails.setDcInterface(((resultSet.getString("DC_INTERFACE_YN") != null) ? resultSet.getString("DC_INTERFACE_YN") : ""));
				custGroupDetails.setNationalIdFlag(((resultSet.getString("NATID_MAND_FLAG") != null) ? resultSet.getString("NATID_MAND_FLAG") : ""));
				custGroupDetails.setAltId1(((resultSet.getString("MAND_ALTID1") != null) ? resultSet.getString("MAND_ALTID1") : ""));
				custGroupDetails.setAltId2(((resultSet.getString("MAND_ALTID2") != null) ? resultSet.getString("MAND_ALTID2") : ""));
				custGroupDetails.setAltId3(((resultSet.getString("MAND_ALTID3") != null) ? resultSet.getString("MAND_ALTID3") : ""));
				custGroupDetails.setAltId4(((resultSet.getString("MAND_ALTID4") != null) ? resultSet.getString("MAND_ALTID4") : ""));
				custGroupDetails.setAltId5(((resultSet.getString("MAND_ALTID5") != null) ? resultSet.getString("MAND_ALTID5") : ""));
				custGroupDetails.setMembshpIdFlag(((resultSet.getString("MEMBSHPID_MAND_FLAG") != null) ? resultSet.getString("MEMBSHPID_MAND_FLAG") : ""));
				custGroupDetails.setVisitRegFlag(((resultSet.getString("VISIT_REG_PROC_FLAG") != null) ? resultSet.getString("VISIT_REG_PROC_FLAG") : ""));
				custGroupDetails.setPolicyNoFlag(((resultSet.getString("POLICYNO_MAND_FLAG") != null) ? resultSet.getString("POLICYNO_MAND_FLAG") : ""));
				custGroupDetails.setCitizenAltId1(((resultSet.getString("CITIZEN_MAND_ALTID1") != null) ? resultSet.getString("CITIZEN_MAND_ALTID1") : ""));
				custGroupDetails.setCitizenAltId2(((resultSet.getString("CITIZEN_MAND_ALTID2") != null) ? resultSet.getString("CITIZEN_MAND_ALTID2") : ""));
				custGroupDetails.setCitizenAltId3(((resultSet.getString("CITIZEN_MAND_ALTID3") != null) ? resultSet.getString("CITIZEN_MAND_ALTID3") : ""));
				custGroupDetails.setCitizenAltId4(((resultSet.getString("CITIZEN_MAND_ALTID4") != null) ? resultSet.getString("CITIZEN_MAND_ALTID4") : ""));
				custGroupDetails.setCitizenAltId5(((resultSet.getString("CITIZEN_MAND_ALTID5") != null) ? resultSet.getString("CITIZEN_MAND_ALTID5") : ""));
			}
		}catch (Exception e){
			e.printStackTrace();
			throw e;
		}finally {
			//pstmt.close();
			//resultSet.close();	
			XHUtil.closeDBResources(resultSet, pstmt, connection);
		}
		return custGroupDetails;
	}

	public XHMasterParamBean getMasterParamDetails(String StrModuleId) throws Exception {

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		XHMasterParamBean masterParam = new XHMasterParamBean();
		
		try {
			connection = ConnectionManager.getConnection() ;
		
			pstmt = connection.prepareStatement("SELECT ALT_ID1_TYPE, ALT_ID2_TYPE, ALT_ID3_TYPE,ALT_ID4_TYPE FROM MP_PARAM WHERE MODULE_ID =?");
			
			pstmt.setString(1,StrModuleId);
			resultSet = pstmt.executeQuery() ;
			
			while (resultSet != null && resultSet.next() ) {
				
				masterParam.setAltId1TypeName(((resultSet.getString("ALT_ID1_TYPE") != null) ? resultSet.getString("ALT_ID1_TYPE") : ""));
				masterParam.setAltId2TypeName(((resultSet.getString("ALT_ID2_TYPE") != null) ? resultSet.getString("ALT_ID2_TYPE") : ""));
				masterParam.setAltId3TypeName(((resultSet.getString("ALT_ID3_TYPE") != null) ? resultSet.getString("ALT_ID3_TYPE") : ""));
				masterParam.setAltId4TypeName(((resultSet.getString("ALT_ID4_TYPE") != null) ? resultSet.getString("ALT_ID4_TYPE") : ""));
			
			}
		}catch (Exception e){
			e.printStackTrace();
			throw e;
		}finally {
			//pstmt.close();
			//resultSet.close();	
			XHUtil.closeDBResources(resultSet, pstmt, connection);
		}
		return masterParam;
	}



	public static List<String> getDescriptionForKey(List<String> types) throws Exception {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		List<String> short_desc_type = new ArrayList<String>();
	
		try{

			connection = ConnectionManager.getConnection() ;

			pstmt = connection.prepareStatement("SELECT SHORT_DESC FROM MP_ALTERNATE_ID_TYPE WHERE ALT_ID_TYPE = ?");
			for(String type :types){		
			pstmt.setString(1,type);

			resultSet = pstmt.executeQuery() ;
			
			while (resultSet.next()) {
				String description = resultSet.getString("SHORT_DESC");
				if(description =="" || description==null){
				short_desc_type.add(null);
				}else{
				short_desc_type.add(description);
				}
			}
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally {
			//pstmt.close(); 
			//resultSet.close();	
			XHUtil.closeDBResources(resultSet, pstmt, connection);

		}
		return short_desc_type;
	}	
	
	public String getCitizen(String CitizenPatientID) throws Exception {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String citizen_flag_yn  = null;
		try{
				
			connection = ConnectionManager.getConnection() ;

			pstmt = connection.prepareStatement("SELECT CITIZEN_YN FROM MP_PATIENT WHERE PATIENT_ID = ?");
			pstmt.setString(1,CitizenPatientID);

			resultSet = pstmt.executeQuery() ;
			
			while (resultSet.next()) {
				citizen_flag_yn = resultSet.getString("CITIZEN_YN");
			}
	
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally {
			//pstmt.close(); 
			//resultSet.close();	
			XHUtil.closeDBResources(resultSet, pstmt, connection);

		}
		return citizen_flag_yn;
	}
	
}