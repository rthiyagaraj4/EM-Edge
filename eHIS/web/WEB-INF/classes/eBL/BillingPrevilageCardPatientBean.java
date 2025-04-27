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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import webbeans.eCommon.ConnectionManager;
import eBL.Common.BlAdapter;
import eBL.Common.BlRepository;



public class BillingPrevilageCardPatientBean extends  BlAdapter implements Serializable{
	
	protected String 		PatientId											= 	"";
	protected String 		PatientName											= 	"";
	protected String 		PatientNameSex										=	"";
	protected String 		PatientAge											=	"";
	protected String 		PrevilageCardType									=	"";
	protected String 		PrevilageCardTypeCode								=	"";
	protected String 		PrevilageCardFromDate								=	"";
	protected String 		PrevilageCardToDate									=	"";
	protected String 		PrevilageCardMemberFees								=	"";
	protected String 		OpVistsAllowed										=	"";
	protected String 		OpVistsAvailed										=	"";
	protected String 		PrevilageCardPriceClassCode							=	"";
	protected String 		PrevilageCardPriceClassDesc							=	"";
	protected String 		HcardSeqNo											=	"";
	protected String 		AdditionalPatientId									=	"";
	protected String 		AdditionalPatientName								=	"";
	protected String 		AdditionalPatientAge								=	"";
	protected String 		PackageCode											=	"";
	protected String 		BillingServiceCode									=	"";
	protected String 		PrimaryPatientId									=	"";
	
	
	protected ArrayList 	PrevilageCardPatientList							=	null;
	protected HashMap 		PrevilageCardPriceCodeMap							=	null;
	protected HashMap 		PrevilageCardClassMap								=	null;
	protected ArrayList 	PriceClassCodeAndDescList							=	null;
	
	
	/*
	 * All the Column name and table name used in the query is referred as constants
	 */
	 /*
	public static final	String 	  BL_HCARD_SUB_HDR_TABLE						=  "BL_HCARD_SUB_HDR";  
	public static final	String 	  HCARD_SEQ_NO									=  "HCARD_SEQ_NO";  
	public static final String    PRIMARY_PATIENT_ID							=  "PRIMARY_PATIENT_ID";     
	public static final String    CARD_TYPE_CODE 								=  "CARD_TYPE_CODE";   
	public static final	String 	  EFFECTIVE_FROM								=  "EFFECTIVE_FROM";  
	public static final String    EFFECTIVE_TO									=  "PRICE_CLASS_CODE";     
	public static final String    PRICE_CLASS_CODE 								=  "CARD_TYPE_CODE";   
	public static final	String 	  PACKAGE_CODE									=  "PACKAGE_CODE";  
	public static final String    BLNG_SERV_CODE								=  "BLNG_SERV_CODE";     
	public static final String    HCARD_PRICE 									=  "HCARD_PRICE";   
	public static final String    NO_OF_OP_VISITS_ALLOWED						=  "NO_OF_OP_VISITS_ALLOWED";     
	public static final String    NO_OF_OP_VISITS_UTILIZED 						=  "NO_OF_OP_VISITS_UTILIZED";   
	public static final String    ADDED_FACILITY_ID								=  "ADDED_FACILITY_ID";     
*/ //commented checkstyle		

	/**
	 * @return the patientId
	 */
	public String getPatientId() {
		return PatientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(String patientId) {
		PatientId = patientId;
	}

	/**
	 * @return the patientName
	 */
	public String getPatientName() {
		return PatientName;
	}

	/**
	 * @param patientName the patientName to set
	 */
	public void setPatientName(String patientName) {
		PatientName = patientName;
	}

	/**
	 * @return the patientNameSex
	 */
	public String getPatientNameSex() {
		return PatientNameSex;
	}

	/**
	 * @param patientNameSex the patientNameSex to set
	 */
	public void setPatientNameSex(String patientNameSex) {
		PatientNameSex = patientNameSex;
	}

	/**
	 * @return the patientAge
	 */
	public String getPatientAge() {
		return PatientAge;
	}

	/**
	 * @param patientAge the patientAge to set
	 */
	public void setPatientAge(String patientAge) {
		PatientAge = patientAge;
	}

	/**
	 * @return the previlageCardType
	 */
	public String getPrevilageCardType() {
		return PrevilageCardType;
	}

	/**
	 * @param previlageCardType the previlageCardType to set
	 */
	public void setPrevilageCardType(String previlageCardType) {
		PrevilageCardType = previlageCardType;
	}

	/**
	 * @return the previlageCardTypeCode
	 */
	public String getPrevilageCardTypeCode() {
		return PrevilageCardTypeCode;
	}

	/**
	 * @param previlageCardTypeCode the previlageCardTypeCode to set
	 */
	public void setPrevilageCardTypeCode(String previlageCardTypeCode) {
		PrevilageCardTypeCode = previlageCardTypeCode;
	}

	/**
	 * @return the previlageCardFromDate
	 */
	public String getPrevilageCardFromDate() {
		return PrevilageCardFromDate;
	}

	/**
	 * @param previlageCardFromDate the previlageCardFromDate to set
	 */
	public void setPrevilageCardFromDate(String previlageCardFromDate) {
		PrevilageCardFromDate = previlageCardFromDate;
	}

	/**
	 * @return the previlageCardToDate
	 */
	public String getPrevilageCardToDate() {
		return PrevilageCardToDate;
	}

	/**
	 * @param previlageCardToDate the previlageCardToDate to set
	 */
	public void setPrevilageCardToDate(String previlageCardToDate) {
		PrevilageCardToDate = previlageCardToDate;
	}

	/**
	 * @return the previlageCardMemberFees
	 */
	public String getPrevilageCardMemberFees() {
		return PrevilageCardMemberFees;
	}

	/**
	 * @param previlageCardMemberFees the previlageCardMemberFees to set
	 */
	public void setPrevilageCardMemberFees(String previlageCardMemberFees) {
		PrevilageCardMemberFees = previlageCardMemberFees;
	}

	/**
	 * @return the previlageCardPatientList
	 */
	public ArrayList getPrevilageCardPatientList() {
		return PrevilageCardPatientList;
	}

	/**
	 * @param previlageCardPatientList the previlageCardPatientList to set
	 */
	public void setPrevilageCardPatientList(ArrayList previlageCardPatientList) {
		PrevilageCardPatientList = previlageCardPatientList;
	}
	
	
	/**
	 * @return the opVistsAllowed
	 */
	public String getOpVistsAllowed() {
		return OpVistsAllowed;
	}

	/**
	 * @param opVistsAllowed the opVistsAllowed to set
	 */
	public void setOpVistsAllowed(String opVistsAllowed) {
		OpVistsAllowed = opVistsAllowed;
	}

	/**
	 * @return the opVistsAvailed
	 */
	public String getOpVistsAvailed() {
		return OpVistsAvailed;
	}

	/**
	 * @param opVistsAvailed the opVistsAvailed to set
	 */
	public void setOpVistsAvailed(String opVistsAvailed) {
		OpVistsAvailed = opVistsAvailed;
	}

	/**
	 * @return the hcardSeqNo
	 */
	public String getHcardSeqNo() {
		return HcardSeqNo;
	}

	/**
	 * @param hcardSeqNo the hcardSeqNo to set
	 */
	public void setHcardSeqNo(String hcardSeqNo) {
		HcardSeqNo = hcardSeqNo;
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
	 * @return the previlageCardPriceCodeMap
	 */
	public HashMap getPrevilageCardPriceCodeMap() {
		return PrevilageCardPriceCodeMap;
	}

	/**
	 * @param previlageCardPriceCodeMap the previlageCardPriceCodeMap to set
	 */
	public void setPrevilageCardPriceCodeMap(HashMap previlageCardPriceCodeMap) {
		PrevilageCardPriceCodeMap = previlageCardPriceCodeMap;
	}

	/**
	 * @return the previlageCardPriceClassCode
	 */
	public String getPrevilageCardPriceClassCode() {
		return PrevilageCardPriceClassCode;
	}

	/**
	 * @param previlageCardPriceClassCode the previlageCardPriceClassCode to set
	 */
	public void setPrevilageCardPriceClassCode(String previlageCardPriceClassCode) {
		PrevilageCardPriceClassCode = previlageCardPriceClassCode;
	}

	/**
	 * @return the previlageCardPriceClassDesc
	 */
	public String getPrevilageCardPriceClassDesc() {
		return PrevilageCardPriceClassDesc;
	}

	/**
	 * @param previlageCardPriceClassDesc the previlageCardPriceClassDesc to set
	 */
	public void setPrevilageCardPriceClassDesc(String previlageCardPriceClassDesc) {
		PrevilageCardPriceClassDesc = previlageCardPriceClassDesc;
	}
	
	
	/**
	 * @return the priceClassCodeAndDescList
	 */
	public ArrayList getPriceClassCodeAndDescList() {
		return PriceClassCodeAndDescList;
	}

	/**
	 * @param priceClassCodeAndDescList the priceClassCodeAndDescList to set
	 */
	public void setPriceClassCodeAndDescList(ArrayList priceClassCodeAndDescList) {
		PriceClassCodeAndDescList = priceClassCodeAndDescList;
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
	 * @return the billingServiceCode
	 */
	public String getBillingServiceCode() {
		return BillingServiceCode;
	}

	/**
	 * @param billingServiceCode the billingServiceCode to set
	 */
	public void setBillingServiceCode(String billingServiceCode) {
		BillingServiceCode = billingServiceCode;
	}

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
	 * clears the bean value
	 */
	public void clearBean()
	{
		PatientId											= 	"";      
		PatientName											= 	"";      
		PatientNameSex										=	"";              
		PatientAge											=	"";      
		PrevilageCardType									=	"";              
		PrevilageCardTypeCode								=	"";                      
		PrevilageCardFromDate								=	"";                      
		PrevilageCardToDate									=	"";              
		PrevilageCardMemberFees								=	"";                      
		OpVistsAllowed										=	"";              
		OpVistsAvailed										=	"";              
		PrevilageCardPriceClassCode							=	"";                      
		PrevilageCardPriceClassDesc							=	"";                      
		HcardSeqNo											=	"";      
		AdditionalPatientId									=	"";              
		AdditionalPatientName								=	"";                      
		AdditionalPatientAge								=	"";  
		PackageCode											=	"";
		BillingServiceCode									=	"";
		                                                                                                                 
		                                                                                                                 
		PrevilageCardPatientList							=	null;                    
		PrevilageCardPriceCodeMap							=	null;                    
		PrevilageCardClassMap								=	null;       
		PriceClassCodeAndDescList							=	null;
		                                                                                                                 

		                                                                                                                                                             
         
   }

	/**
	 * @param language_id
	 * @param operating_facility_id
	 * @param PatientId
	 * @throws Exception
	 * 
	 */
	public ArrayList getBillingPrevilageCardPatient(String PatientId,String added_facility_id,String locale) throws Exception 
	{
		Connection 			connection 										= 	null;		
		PreparedStatement 	preparedstatement 								= 	null;
		ResultSet 			resultSet										= 	null;	
		StringBuffer 		BillingPrevilageCardPatientSql					=	new StringBuffer();	
		//String 				languageId										=	"en";//commented checkstyle	
		String 				patientId										= 	"";
		//String				sql												=	"";//commented checkstyle	
		String				blRepositoryKey									=	"Billing_Previlage_Card_Patient_SQL";
		ArrayList 			PrevilageCardList								=	null;
		//SimpleDateFormat 	dateFormat 										=	new SimpleDateFormat("yyyy/mm/dd");   //commented checkstyle	
		String				str1											=	"VALUE1";
		String				str2											=	"VALUE2";
		BillingPrevilageCardPatientBean billingPrevilageCardPatientBean		=   null;


		
		try
		{
			connection = getConnection();
			PrevilageCardList=new ArrayList();
			BillingPrevilageCardPatientSql.append( BlRepository.getBlKeyValue(blRepositoryKey));
			BillingPrevilageCardPatientSql.replace(BillingPrevilageCardPatientSql.indexOf(str1),BillingPrevilageCardPatientSql.indexOf(str1)+str1.length(),  PatientId);
			BillingPrevilageCardPatientSql.replace(BillingPrevilageCardPatientSql.indexOf(str2),BillingPrevilageCardPatientSql.indexOf(str2)+str2.length(), PatientId);
			//BillingPrevilageCardPatientSql.append(" '"+PatientId+"'  and  ADDED_FACILITY_ID = '"+added_facility_id+"' ");		 		 

			System.out.println("getBillingPrevilageCardPatient SELECT QUERY:::"+BillingPrevilageCardPatientSql);
			
			preparedstatement=connection.prepareStatement(BillingPrevilageCardPatientSql.toString());	
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next())
			{
				billingPrevilageCardPatientBean = new BillingPrevilageCardPatientBean();
				billingPrevilageCardPatientBean.setPatientId(patientId);
				billingPrevilageCardPatientBean.setPrevilageCardTypeCode(resultSet.getString(1));
				billingPrevilageCardPatientBean.setPrimaryPatientId(resultSet.getString(2));
				billingPrevilageCardPatientBean.setPrevilageCardType(getPrevilageCardClassDetails(resultSet.getString(1),added_facility_id));
				billingPrevilageCardPatientBean.setPrevilageCardPriceClassCode(resultSet.getString(3));
				billingPrevilageCardPatientBean.setPrevilageCardPriceClassDesc(getPriceCodeDetails(resultSet.getString(3),added_facility_id,locale));
				billingPrevilageCardPatientBean.setPrevilageCardFromDate(formatDate(resultSet.getString(4)));
				billingPrevilageCardPatientBean.setPrevilageCardToDate(formatDate(resultSet.getString(5)));
				billingPrevilageCardPatientBean.setPrevilageCardMemberFees(resultSet.getString(6));
				billingPrevilageCardPatientBean.setOpVistsAllowed(resultSet.getString(7));
				billingPrevilageCardPatientBean.setOpVistsAvailed(resultSet.getString(8));
				billingPrevilageCardPatientBean.setHcardSeqNo(resultSet.getString(9));
				billingPrevilageCardPatientBean.setPriceClassCodeAndDescList(LoadPriceClassCodeAndDesc(resultSet.getString(1),locale));
				billingPrevilageCardPatientBean.setPackageCode(resultSet.getString(10));
				billingPrevilageCardPatientBean.setBillingServiceCode(resultSet.getString(11));
				PrevilageCardList.add(billingPrevilageCardPatientBean);   
				 
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in getBillingPrevilageCardPatient in BillingPrevilageCardPatientBean= "+e);
			e.printStackTrace();
		}
		finally
		{
			if(resultSet!=null) resultSet.close();
			if(preparedstatement!=null) preparedstatement.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
			
		}
		
		return PrevilageCardList;
		
	}	
	
	public ArrayList LoadPriceClassCodeAndDesc(String cardTypeCode,String locale) throws Exception 
	{
		Connection 			connection 										= 	null;		
		PreparedStatement 	preparedstatement 								= 	null;
		ResultSet 			resultSet										= 	null;	
		StringBuffer 		LoadPriceClassCodeAndDescSql					=	new StringBuffer();	
		//String				sql												=	"";//commented checkstyle	
		String				blRepositoryKey									=	"Billing_Previlage_Price_Class_DROPDOWN_SQL";
		ArrayList 			priceClassCodeAndDescList						=	null;
		String				str1											=	"@CARDTYPECODE";
		String[]			strAr											=	null;
		
		try
		{
			connection = getConnection();
			priceClassCodeAndDescList=new ArrayList();
			LoadPriceClassCodeAndDescSql.append( BlRepository.getBlKeyValue(blRepositoryKey));
			LoadPriceClassCodeAndDescSql.replace(LoadPriceClassCodeAndDescSql.indexOf(str1),LoadPriceClassCodeAndDescSql.indexOf(str1)+str1.length(),  cardTypeCode);
			LoadPriceClassCodeAndDescSql.append(" '"+locale+"' ");		 		 

			System.out.println("LoadPriceClassCodeAndDesc SELECT QUERY:::"+LoadPriceClassCodeAndDescSql);
			
			preparedstatement=connection.prepareStatement(LoadPriceClassCodeAndDescSql.toString());	
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next())
			{
				strAr 		= 	new String[2];
				strAr[0]	=	resultSet.getString(1);
				strAr[1]	=	resultSet.getString(2);
				priceClassCodeAndDescList.add(strAr); 
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in LoadPriceClassCodeAndDesc in BillingPrevilageCardPatientBean= "+e);
			e.printStackTrace();
		}
		finally
		{
			if(resultSet!=null) resultSet.close();
			if(preparedstatement!=null) preparedstatement.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
			
		}
		
		return priceClassCodeAndDescList;
		
	}	
	
	public String getPatientDetails(String PatientId,String added_facility_id,String locale) throws Exception 
	{
		Connection 			connection 										= 	null;		
		CallableStatement 	callableStatement 								= 	null;
		//ResultSet 			PatientDetailsResultSet							= 	null;		//commented checkstyle	
		//StringBuffer 		PatientDetailsSql								=	new StringBuffer();	//commented checkstyle	
		//String 				languageId										=	"en";
		//String 				patientId										= 	"";//commented checkstyle	
		String				patientDetails									=	"";
		try 
		{
			System.out.println("PatientId "+ PatientId);
			System.out.println("added_facility_id "+ added_facility_id);
			System.out.println("locale "+ locale);
			connection = getConnection();
			callableStatement = connection.prepareCall("{ ? = call  get_patient_line(?,?)}");	
			callableStatement.registerOutParameter(1,java.sql.Types.VARCHAR);
			callableStatement.setString(2,PatientId);
			callableStatement.setString(3,locale);
			callableStatement.execute();							
			patientDetails = callableStatement.getString(1);
			System.out.println("welcme to the file PKG Subscription Dtls "+ patientDetails);
			
			callableStatement.close();
			if ( patientDetails == null ) patientDetails = "";
			int ind=patientDetails.indexOf("#");
			patientDetails=patientDetails.substring(0,ind);
			if ( patientDetails == null ) patientDetails = "";

	
		}
		catch(Exception e)
		{
			System.out.println("Exception in getPatientDetails in BillingPrevilageCardPatientBean= "+e);
			e.printStackTrace();
			}
		finally
		{
			if(callableStatement!=null) callableStatement.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
			
		}
		
		return patientDetails;
		
	}	
	
	
	
	 
	public String getPriceCodeDetails(String priceCode,String added_facility_id,String locale) throws Exception 
	{
		Connection 			connection 										= 	null;		
		PreparedStatement 	preparedstatement 								= 	null;
		ResultSet 			PriceCodeDetailsResultSet						= 	null;		
		StringBuffer 		PriceCodeDetailsSql								=	new StringBuffer();	
		//String 				languageId										=	"en";
		//String				sql												=	"";//commented checkstyle	
		String				blRepositoryKey									=	"Billing_Previlage_Price_Class_Detail_SQL";
		HashMap 			PrevilageCardPriceCodeMap						=	null;
		String				priceClassDesc									=	"";
		try
		{
			connection = getConnection();  
			PrevilageCardPriceCodeMap	= new HashMap();
			PriceCodeDetailsSql.append( BlRepository.getBlKeyValue(blRepositoryKey));
			PriceCodeDetailsSql.append(" '"+priceCode+"'  and  ADDED_FACILITY_ID = '"+added_facility_id+"' ");
			PriceCodeDetailsSql.append("  and  LANGUAGE_ID = '"+locale+"' ");	

			System.out.println("getPriceCodeDetails SELECT QUERY:::"+PriceCodeDetailsSql);
			
			preparedstatement=connection.prepareStatement(PriceCodeDetailsSql.toString());	
			PriceCodeDetailsResultSet = preparedstatement.executeQuery();
			while (PriceCodeDetailsResultSet.next())
			{
				priceClassDesc = PriceCodeDetailsResultSet.getString(1);
				PrevilageCardPriceCodeMap.put(priceCode, PriceCodeDetailsResultSet.getString(1)); 
			}

	
		}
		catch(Exception e)
		{
			System.out.println("Exception in getPriceCodeDetails in BillingPrevilageCardPatientBean= "+e);
			e.printStackTrace();
			}
		finally
		{
			if(PriceCodeDetailsResultSet!=null) PriceCodeDetailsResultSet.close();
			if(preparedstatement!=null) preparedstatement.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
			
		}
		
		return priceClassDesc;
	}	
	
	public String getPrevilageCardClassDetails(String CardClassCode,String added_facility_id) throws Exception 
	{
		Connection 			connection 										= 	null;		
		PreparedStatement 	preparedstatement 								= 	null;
		ResultSet 			PrevilageCardClassResultSet						= 	null;		
		StringBuffer 		PrevilageCardClassSql							=	new StringBuffer();	
		//String 				languageId										=	"en";//commented checkstyle	
		//String				sql												=	"";//commented checkstyle	
		String				blRepositoryKey									=	"Billing_Previlage_Card_Detail_SQL";
		HashMap 			PrevilageCardClassMap							=	null;
		String				cardClassDesc									=	"";
		try
		{
			connection = getConnection();
			PrevilageCardClassMap	= new HashMap();
			PrevilageCardClassSql.append( BlRepository.getBlKeyValue(blRepositoryKey));
			PrevilageCardClassSql.append(" '"+CardClassCode+"'  and  ADDED_FACILITY_ID = '"+added_facility_id+"' ");				 

			System.out.println("getPrevilageCardClassDetails SELECT QUERY:::"+PrevilageCardClassSql);
			
			preparedstatement=connection.prepareStatement(PrevilageCardClassSql.toString());	
			PrevilageCardClassResultSet = preparedstatement.executeQuery();
			while (PrevilageCardClassResultSet.next())
			{
				cardClassDesc	=	PrevilageCardClassResultSet.getString(1);
				PrevilageCardClassMap.put(CardClassCode, PrevilageCardClassResultSet.getString(1));
			}

	
		}
		catch(Exception e)
		{
			System.out.println("Exception in getPrevilageCardClassDetails in BillingPrevilageCardPatientBean= "+e);
			e.printStackTrace();
			}
		finally
		{
			if(PrevilageCardClassResultSet!=null) PrevilageCardClassResultSet.close();
			if(preparedstatement!=null) preparedstatement.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
			
		}
		
		return cardClassDesc;
	}	
	
	public String getDefaultPriceClassCodeForAdditionalPatient(String PatientId,String added_facility_id,String cardTypeCode) throws Exception 
	{
		Connection 			connection 										= 	null;		
		CallableStatement 	callableStatement 								= 	null;
		//ResultSet 			PatientDetailsResultSet							= 	null;		//commented checkstyle	
		//StringBuffer 		PatientDetailsSql								=	new StringBuffer();	//commented checkstyle	
		//String 				patientId										= 	"";//commented checkstyle	
		String				defaultPriceClassCode							=	"";
		try 
		{
			System.out.println("PatientId "+ PatientId);
			System.out.println("added_facility_id "+ added_facility_id);
			System.out.println("cardTypeCode "+ cardTypeCode);
			connection = getConnection();
			callableStatement = connection.prepareCall("{ ? = call  IBAEHIS.blhealthcard.get_price_class_code(?,?,?)}");	
			callableStatement.registerOutParameter(1,java.sql.Types.VARCHAR);
			callableStatement.setString(2,added_facility_id);
			callableStatement.setString(3,cardTypeCode);
			callableStatement.setString(4,PatientId);
			callableStatement.execute();							
			defaultPriceClassCode = callableStatement.getString(1);
			
			
			callableStatement.close();
		

	
		}
		catch(Exception e)
		{
			System.out.println("Exception in getDefaultPriceClassCodeForAdditionalPatient in BillingPrevilageCardPatientBean= "+e);
			e.printStackTrace();
			}
		finally
		{
			if(callableStatement!=null) callableStatement.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
			
		}
		
		return defaultPriceClassCode;
		
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
	
	
	
	
	
}
