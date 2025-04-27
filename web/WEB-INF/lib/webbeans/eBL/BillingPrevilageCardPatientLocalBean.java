/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package blHcard;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import webbeans.eCommon.ConnectionManager;

public class BillingPrevilageCardPatientLocalBean {
	
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
	
	
	
	
}
