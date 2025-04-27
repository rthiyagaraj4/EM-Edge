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
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;

import webbeans.eCommon.ConnectionManager;
import eBL.Common.BlAdapter;
import eBL.Common.BlRepository;


public class BillingPrevilageCardMemberBean extends  BlAdapter implements Serializable{
	
	protected String 		PrimaryPatientId									=	"";
	protected String 		AdditionalPatientId									=	"";
	protected String 		EffectiveFrom										=	"";
	protected String 		AdditionalPatientName								=	"";
	protected String 		AdditionalPatientAge								=	"";
	protected String 		AdditionalPatientPriceClasscode						=	"";
	protected String 		AdditionalPatientPriceClassDesc						=	"";
	protected String 		HcardSeqno											=	"";
	protected String 		CardTypeCode										=	"";
	protected String 		PackageCode											=	"";
	
	
	protected ArrayList 	PrevilageCardAdditionalPatientList					=	null;

	/**
	 * @return the primaryPatientId
	 */
	public String getPrimaryPatientId() {
		return PrimaryPatientId;
	}

	/**
	 * @param primaryPatientId the primaryPatientId to set
	 */
	public void setPrimaryPatientId(String primaryPatientId) {
		PrimaryPatientId = primaryPatientId;
	}

	/**
	 * @return the additionalPatientId
	 */
	public String getAdditionalPatientId() {
		return AdditionalPatientId;
	}

	/**
	 * @param additionalPatientId the additionalPatientId to set
	 */
	public void setAdditionalPatientId(String additionalPatientId) {
		AdditionalPatientId = additionalPatientId;
	}

	/**
	 * @return the effectiveFrom
	 */
	public String getEffectiveFrom() {
		return EffectiveFrom;
	}

	/**
	 * @param effectiveFrom the effectiveFrom to set
	 */
	public void setEffectiveFrom(String effectiveFrom) {
		EffectiveFrom = effectiveFrom;
	}

	/**
	 * @return the additionalPatientName
	 */
	public String getAdditionalPatientName() {
		return AdditionalPatientName;
	}

	/**
	 * @param additionalPatientName the additionalPatientName to set
	 */
	public void setAdditionalPatientName(String additionalPatientName) {
		AdditionalPatientName = additionalPatientName;
	}

	/**
	 * @return the additionalPatientAge
	 */
	public String getAdditionalPatientAge() {
		return AdditionalPatientAge;
	}

	/**
	 * @param additionalPatientAge the additionalPatientAge to set
	 */
	public void setAdditionalPatientAge(String additionalPatientAge) {
		AdditionalPatientAge = additionalPatientAge;
	}

	/**
	 * @return the additionalPatientPriceClasscode
	 */
	public String getAdditionalPatientPriceClasscode() {
		return AdditionalPatientPriceClasscode;
	}

	/**
	 * @param additionalPatientPriceClasscode the additionalPatientPriceClasscode to set
	 */
	public void setAdditionalPatientPriceClasscode(
			String additionalPatientPriceClasscode) {
		AdditionalPatientPriceClasscode = additionalPatientPriceClasscode;
	}

	/**
	 * @return the additionalPatientPriceClassDesc
	 */
	public String getAdditionalPatientPriceClassDesc() {
		return AdditionalPatientPriceClassDesc;
	}

	/**
	 * @param additionalPatientPriceClassDesc the additionalPatientPriceClassDesc to set
	 */
	public void setAdditionalPatientPriceClassDesc(
			String additionalPatientPriceClassDesc) {
		AdditionalPatientPriceClassDesc = additionalPatientPriceClassDesc;
	}

	/**
	 * @return the hcardSeqno
	 */
	public String getHcardSeqno() {
		return HcardSeqno;
	}

	/**
	 * @param hcardSeqno the hcardSeqno to set
	 */
	public void setHcardSeqno(String hcardSeqno) {
		HcardSeqno = hcardSeqno;
	}

	/**
	 * @return the cardTypeCode
	 */
	public String getCardTypeCode() {
		return CardTypeCode;
	}

	/**
	 * @param cardTypeCode the cardTypeCode to set
	 */
	public void setCardTypeCode(String cardTypeCode) {
		CardTypeCode = cardTypeCode;
	}

	/**
	 * @return the previlageCardAdditionalPatientList
	 */
	public ArrayList getPrevilageCardAdditionalPatientList() {
		return PrevilageCardAdditionalPatientList;
	}

	/**
	 * @param previlageCardAdditionalPatientList the previlageCardAdditionalPatientList to set
	 */
	public void setPrevilageCardAdditionalPatientList(
			ArrayList previlageCardAdditionalPatientList) {
		PrevilageCardAdditionalPatientList = previlageCardAdditionalPatientList;
	}
	
	/**
	 * @return the packageCode
	 */
	public String getPackageCode() {
		return PackageCode;
	}

	/**
	 * @param packageCode the packageCode to set
	 */
	public void setPackageCode(String packageCode) {
		PackageCode = packageCode;
	}

	/**
	 * clears the bean value
	 */
	public void clearBean()
	{
		PrimaryPatientId									=	"";                                                          
		AdditionalPatientId									=	"";                                                          
		EffectiveFrom										=	"";                                                          
		AdditionalPatientName								=	"";                                                                  
		AdditionalPatientAge								=	"";                                                                  
		AdditionalPatientPriceClasscode						=	"";                                                                          
		AdditionalPatientPriceClassDesc						=	"";                                                                          
		HcardSeqno											=	"";                                                  
		CardTypeCode										=	"";     
		PackageCode											=	"";
		
		PrevilageCardAdditionalPatientList					=	null;
		                                                                                                                                                             
         
   }
	
	
	public ArrayList getAdditionalPatientId(String hCardSeqNo,String added_facility_id) throws Exception 
	{
		Connection 			connection 										= 	null;		
		PreparedStatement 	preparedstatement 								= 	null;
		ResultSet 			additionalPatientIdResultSet					= 	null;		
		StringBuffer 		additionalPatientIdSql							=	new StringBuffer();	 
		//String 				languageId										=	"en";
		//String			sql											=	""; //commented checkstyle
		String				blRepositoryKey									=	"Billing_Previlage_AdditionalPatient_SQL";
		HashMap 			additionalPatientIdMap							=	null;
		ArrayList 			PatientDetailsList								=	null;
		String[] 			strAr											= 	null;
		try
		{
			PatientDetailsList = new ArrayList();
			connection = getConnection();
			additionalPatientIdMap	= new HashMap(); 
			additionalPatientIdSql.append( BlRepository.getBlKeyValue(blRepositoryKey));
			additionalPatientIdSql.append(" '"+hCardSeqNo+"'  and  ADDED_FACILITY_ID = '"+added_facility_id+"' ");
			
			System.out.println("getAdditionalPatientDetails SELECT QUERY:::"+additionalPatientIdSql);
			
			preparedstatement=connection.prepareStatement(additionalPatientIdSql.toString());	
			additionalPatientIdResultSet = preparedstatement.executeQuery();
			while (additionalPatientIdResultSet.next())
			{
				strAr 		= 	new String[6];
				//strAr[0]	=	hCardSeqNo;
				strAr[0] 	=	additionalPatientIdResultSet.getString(1);
				strAr[1] 	=	getPrevilageCardPatientDetails(additionalPatientIdResultSet.getString(1));
				strAr[2]	=	getPrevilageCardPatientAge(additionalPatientIdResultSet.getString(1));
				strAr[3]	=	getAdditionalPatientPriceClassCode(hCardSeqNo,additionalPatientIdResultSet.getString(1));
				strAr[4]	=   strAr[3];
				strAr[5]	=   "Modify";
				PatientDetailsList.add(strAr); 
			}
			//additionalPatientIdMap.put(hCardSeqNo, PatientDetailsList); 
	
		}
		catch(Exception e)
		{
			System.out.println("Exception in getAdditionalPatientId in BillingPrevilageCardMemberBean= "+e);
			e.printStackTrace();
			}
		finally
		{
			if(additionalPatientIdResultSet!=null) additionalPatientIdResultSet.close();
			if(preparedstatement!=null) preparedstatement.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
			
		}
		
		return PatientDetailsList;
	}	
	
	
	public String getPrevilageCardPatientDetails(String PatientId) throws Exception 
	{
		Connection 			connection 										= 	null;		
		PreparedStatement 	preparedstatement 								= 	null;
		ResultSet 			PatientDetailsResultSet							= 	null;		
		StringBuffer 		PatientDetailsSql								=	new StringBuffer();	
		//String 				languageId										=	"en";
		//String 				patientId									= 	""; //commented checkstyle
		//String				sql											=	""; //commented checkstyle
		String				blRepositoryKey									=	"Billing_Previlage_Patient_Detail_SQL";
		String				patientName										=	"";
		ArrayList 			PatientDetailsList								=	null;
		try
		{
			connection = getConnection();
			PatientDetailsList	= new ArrayList();
			PatientDetailsSql.append( BlRepository.getBlKeyValue(blRepositoryKey));
			PatientDetailsSql.append(" '"+PatientId+"'  ");	
			

			System.out.println("getPatientDetails SELECT QUERY:::"+PatientDetailsSql);
			
			preparedstatement=connection.prepareStatement(PatientDetailsSql.toString());	
			PatientDetailsResultSet = preparedstatement.executeQuery();
			while (PatientDetailsResultSet.next())
			{
				patientName = PatientDetailsResultSet.getString(1);
			}

	
		}
		catch(Exception e)
		{
			System.out.println("Exception in getPatientDetails in BillingPrevilageCardMemberBean= "+e);
			e.printStackTrace();
			}
		finally
		{
			if(PatientDetailsResultSet!=null) PatientDetailsResultSet.close();
			if(preparedstatement!=null) preparedstatement.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
			
		}
		
		return patientName;
	}	
	
	public String getPrevilageCardPatientAge(String patientId) throws Exception 
	{ 
		System.out.println("IN getPrevilageCardPatientAge@@");
		Connection 			connection 										= 	null;		
		CallableStatement 	callableStatement 								= 	null;
		//ResultSet 			patientageResultSet							= 	null;	 //commented checkstyle	
		//StringBuffer 		patientAgeSql							=	new StringBuffer();	//commented checkstyle	
		//String 				languageId										=	"en";
		String				patientName										=	"";
		//ArrayList 			PatientDetailsList								=	null;//commented checkstyle	
		//java.sql.Date		date											=	new java.sql.Date(17012013L);  //commented checkstyle	
		try
		{
			connection = getConnection();
			
			/*callableStatement = connection.prepareCall("{ ? = call  get_patient_line(?,?)}");	
			callableStatement.registerOutParameter(1,java.sql.Types.VARCHAR);
			callableStatement.setString(2,PatientId);
			callableStatement.setString(3,locale);
			callableStatement.execute();							
			patientDetails = callableStatement.getString(1);*/
			
			callableStatement = connection.prepareCall("{ ? = call  IBAEHIS.BLHEALTHCARD.GET_DOB(?)}");	
			callableStatement.registerOutParameter(1,java.sql.Types.VARCHAR);
			callableStatement.setString(2,patientId);
			//callableStatement.setDate(3,date);
			callableStatement.execute();							
			patientName = callableStatement.getString(1);
			System.out.println("Additional PatientName "+ patientName);
					
			if ( patientName == null ) patientName = "";
			

	
		}
		catch(Exception e)
		{
			System.out.println("Exception in getPatientDetails in getPrevilageCardPatientAge= "+e);
			e.printStackTrace();
			}
		finally
		{
			if(callableStatement!=null) callableStatement.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
			
		}
		
		return patientName;
	}	
	
	
	public String getAdditionalPatientPriceClassCode(String hCardSeqNo,String additionalPatientId) throws Exception 
	{ 
		System.out.println("IN getAdditionalPatientPriceClassCode@@");
		Connection 			connection 										= 	null;		
		PreparedStatement 	preparedstatement 								= 	null;
		ResultSet 			resultSet										= 	null;		
		String				blRepositoryKey									=	"Billing_Previlage_Additional_Patient_Price_Class_SQL";
		StringBuffer 		priceclassCodeSql								=	new StringBuffer();	
		String				priceClassCode									=	null;
		try
		{
			connection = getConnection();
		
			priceclassCodeSql.append( BlRepository.getBlKeyValue(blRepositoryKey));
			priceclassCodeSql.append(" '"+hCardSeqNo+"'    AND B.ADDITIONAL_PATIENT_ID = '"+additionalPatientId+"' ");
			

			System.out.println("getAdditionalPatientPriceClassCode SELECT QUERY:::"+priceclassCodeSql);
			
			preparedstatement=connection.prepareStatement(priceclassCodeSql.toString());	
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next())
			{
				priceClassCode = resultSet.getString(1);
			}
			
		

	
		}
		catch(Exception e)
		{
			System.out.println("Exception in getAdditionalPatientPriceClassCode in getPrevilageCardPatientAge= "+e);
			e.printStackTrace();
			}
		finally
		{
			if(resultSet!=null) resultSet.close();
			if(preparedstatement!=null) preparedstatement.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
			
		}
		
		return priceClassCode;
	}	
	

}
