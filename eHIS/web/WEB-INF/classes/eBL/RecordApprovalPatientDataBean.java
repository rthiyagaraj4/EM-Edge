/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
Sr No       Version             Incident              SCF/CRF                        Developer Name
-----------------------------------------------------------------------------------------------
1 			V201013             IN73702            NMC-JD-CRF-0042.1         			Shikha Seth
2          V201218                		           MMS-DM-CRF-0100.1         			Palani Narayan
-----------------------------------------------------------------------------------------------
*/
package eBL;

import java.io.Serializable;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import webbeans.eCommon.ConnectionManager;
import eBL.Common.BlAdapter;
import eBL.Common.BlRepository;

@SuppressWarnings({"serial","rawtypes","unchecked"})
public class RecordApprovalPatientDataBean extends  BlAdapter implements Serializable{
	
	
	protected String 		patientId											= 	"";
	protected String 		patientName											= 	"";
	protected String 		episodeId											=	"";
	protected String 		episodeType											=	"";
	protected String 		encounterId											=	"";
	protected String 		age													=	"";
	protected String 		mobileNumber										=	"";
	protected String 		payerGroup											=	"";
	protected String 		payer												=	"";
	protected String 		policy												=	"";
	protected String 		policyEffectiveTo									=	"";
	protected String 		effectiveTo											=	"";
	protected String 		approvedAmount										=	"";
	protected String 		visitId												=	"";
	protected String 		accountSeqNo										=	"";
	protected String 		payerGroupShortName									=	"";
	protected String 		payerShortName										=	"";
	protected String		policyShortName										=	"";
	protected String 		policyNumber										=	"";
	protected String 		policyEffectiveFrom									=	"";
	protected String 		priority											=	"";
	protected String 		accountSequenceNO									=	"";
	protected String 		policyExpDate										=	"";
	protected String 		unBuiledAmount										=	"";
	protected String 		billNumber											=	"";
	protected String 		billDate											=	"";
	protected String 		AdmissionDate										=	"";
	protected String 		MembershipNo										=   "";//V231107
	
	public LinkedHashMap hasPatSearchValues		= new LinkedHashMap();	
	
	public LinkedHashMap getrPatSearchValues()
	{
		return hasPatSearchValues;		
	}
	
	public String getMembershipNo() {
		return MembershipNo;
	}//V231107

	public void setMembershipNo(String membershipNo) {
		MembershipNo = membershipNo;
	}

	public void setrPatSearchValue(LinkedHashMap hasPatSearchValues) {
		this.hasPatSearchValues = hasPatSearchValues;
	}	
	
	
//V201013 start
	protected String		colorStatus					="";
	public String getColorStatus() {
		return colorStatus;
	}
	public void setColorStatus(String colorStatus) {
		this.colorStatus = colorStatus;
	}
	//V201013 end
	public String getPolicyExpDate() {
		return policyExpDate;
	}
	public void setPolicyExpDate(String policyExpDate) {
		this.policyExpDate = policyExpDate;
	}

	protected ArrayList		EpisodeTypeList										=	null;
	
	/*public static final	String 	   OPERATING_FACILITY_ID						=  "OPERATING_FACILITY_ID";            
	public static final	String 	   EPISODE_TYPE									=  "EPISODE_TYPE";            
	public static final	String 	   EPISODE_ID									=  "EPISODE_ID";            
	public static final	String 	   VISIT_ID										=  "VISIT_ID";            
	public static final	String 	   ACCT_SEQ_NO									=  "ACCT_SEQ_NO";            
	public static final	String 	   ACCT_SEQ_EFF_FROM_DATE						=  "ACCT_SEQ_EFF_FROM_DATE";            
	public static final	String 	   ACCT_SEQ_EFF_TO_DATE							=  "ACCT_SEQ_EFF_TO_DATE";            
	public static final	String 	   ENC_REGN_DATE_TIME							=  "ENC_REGN_DATE_TIME";            
	public static final	String 	   INH_BILL_GEN_DATE							=  "INH_BILL_GEN_DATE";            
	public static final	String 	   PATIENT_ID									=  "PATIENT_ID";            
	public static final	String 	   ENCOUNTER_ID									=  "ENCOUNTER_ID";            
	public static final	String 	   BLNG_GRP_ID									=  "BLNG_GRP_ID";            
	public static final	String 	   SETTLEMENT_IND								=  "SETTLEMENT_IND";            
	public static final	String 	   CUST_CODE									=  "CUST_CODE";            
	public static final	String 	   PRIORITY										=  "PRIORITY";            
	public static final	String 	   POLICY_TYPE_CODE								=  "POLICY_TYPE_CODE";            
	public static final	String 	   POLICY_NUMBER								=  "POLICY_NUMBER";            
	public static final	String 	   POLICY_START_DATE							=  "POLICY_START_DATE";            
	public static final	String 	   POLICY_EXPIRY_DATE							=  "POLICY_EXPIRY_DATE";            
	public static final	String 	   CREDIT_AUTH_REF								=  "CREDIT_AUTH_REF";            
	public static final	String 	   CREDIT_AUTH_DATE								=  "CREDIT_AUTH_DATE";            
	public static final	String 	   EFFECTIVE_FROM								=  "EFFECTIVE_FROM";            
	public static final	String 	   EFFECTIVE_TO									=  "EFFECTIVE_TO";            
	public static final	String 	   APPROVED_AMT									=  "APPROVED_AMT";            
	public static final	String 	   APPROVED_DAYS								=  "APPROVED_DAYS";            
	public static final	String 	   ADJ_RULE_IND									=  "ADJ_RULE_IND";            
	public static final	String 	   ADJ_PERC_AMT_IND								=  "ADJ_PERC_AMT_IND";            
	public static final	String 	   ADJ_PERC_AMT_VALUE							=  "ADJ_PERC_AMT_VALUE";            
	public static final	String 	   PMNT_DIFF_ADJ_INT							=  "PMNT_DIFF_ADJ_INT";            
	public static final	String 	   DRG_PMNT_DIFF_ADJ_INT						=  "DRG_PMNT_DIFF_ADJ_INT";            
	public static final	String 	   SPL_SRV_PMNT_DIFF_ADJ_INT					=  "SPL_SRV_PMNT_DIFF_ADJ_INT";            
	public static final	String 	   ADDED_BY_ID									=  "ADDED_BY_ID";            
	public static final	String 	   ADDED_DATE									=  "ADDED_DATE";            
	public static final	String 	   MODIFIED_BY_ID								=  "MODIFIED_BY_ID";            
	public static final	String 	   MODIFIED_DATE								=  "MODIFIED_DATE";            
	public static final	String 	   ADDED_AT_WS_NO								=  "ADDED_AT_WS_NO";            
	public static final	String 	   ADDED_FACILITY_ID							=  "ADDED_FACILITY_ID";            
	public static final	String 	   MODIFIED_AT_WS_NO							=  "MODIFIED_AT_WS_NO";            
	public static final	String 	   MODIFIED_FACILITY_ID							=  "MODIFIED_FACILITY_ID";            
	public static final	String 	   ORG_BILL_DOC_TYPE_CODE						=  "ORG_BILL_DOC_TYPE_CODE";            
	public static final	String 	   ORG_BILL_DOC_NUM								=  "ORG_BILL_DOC_NUM";            
	public static final	String 	   PACKAGE_BILL_DOC_TYPE						=  "PACKAGE_BILL_DOC_TYPE";            
	public static final	String 	   PACKAGE_BILL_DOC_NUM							=  "PACKAGE_BILL_DOC_NUM";            
	public static final	String 	   REFERRAL_SOURCE_CODE_MAIN					=  "REFERRAL_SOURCE_CODE_MAIN";            
	public static final	String 	   REFERRAL_SOURCE_CODE_SUB						=  "REFERRAL_SOURCE_CODE_SUB";            
	public static final	String 	   APPT_BOOK_REF_NUM							=  "APPT_BOOK_REF_NUM";            
	public static final	String 	   CLAIM_CODE									=  "CLAIM_CODE";            
	public static final	String 	   MAND_ADDL_INFO_RECORDED_YN					=  "MAND_ADDL_INFO_RECORDED_YN";            
	public static final	String 	   CUST_GROUP_CODE								=  "CUST_GROUP_CODE";            
	public static final	String     PRE_INV_YN									=  "PRE_INV_YN";            
	public static final	String     PRE_INV_FIN_YN								=  "PRE_INV_FIN_YN";            
	public static final	String     PRE_INV_FIN_DATE								=  "PRE_INV_FIN_DATE";            
	public static final	String     UTILIZED_AMOUNT								=  "UTILIZED_AMOUNT";            
	public static final	String     ROWID										=  "ROWID";*/            

	
	
	
	/**
	 * @return the patientId
	 */
	public String getPatientId() {
		return patientId;
	}
	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	/**
	 * @return the patientName
	 */
	public String getPatientName() {
		return patientName;
	}
	/**
	 * @param patientName the patientName to set
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	/**
	 * @return the episodeId
	 */
	public String getEpisodeId() {
		return episodeId;
	}
	/**
	 * @param episodeId the episodeId to set
	 */
	public void setEpisodeId(String episodeId) {
		this.episodeId = episodeId;
	}
	/**
	 * @return the episodeType
	 */
	public String getEpisodeType() {
		return episodeType;
	}
	/**
	 * @param episodeType the episodeType to set
	 */
	public void setEpisodeType(String episodeType) {
		this.episodeType = episodeType;
	}
	/**
	 * @return the encounterId
	 */
	public String getEncounterId() {
		return encounterId;
	}
	/**
	 * @param encounterId the encounterId to set
	 */
	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
	}
	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}
	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	/**
	 * @return the payerGroup
	 */
	public String getPayerGroup() {
		return payerGroup;
	}
	/**
	 * @param payerGroup the payerGroup to set
	 */
	public void setPayerGroup(String payerGroup) {
		this.payerGroup = payerGroup;
	}
	/**
	 * @return the payer
	 */
	public String getPayer() {
		return payer;
	}
	/**
	 * @param payer the payer to set
	 */
	public void setPayer(String payer) {
		this.payer = payer;
	}
	/**
	 * @return the policy
	 */
	public String getPolicy() {
		return policy;
	}
	/**
	 * @param policy the policy to set
	 */
	public void setPolicy(String policy) {
		this.policy = policy;
	}
	/**
	 * @return the policyEffectiveTo
	 */
	public String getPolicyEffectiveTo() {
		return policyEffectiveTo;
	}
	/**
	 * @param policyEffectiveTo the policyEffectiveTo to set
	 */
	public void setPolicyEffectiveTo(String policyEffectiveTo) {
		this.policyEffectiveTo = policyEffectiveTo;
	}
	/**
	 * @return the effectiveTo
	 */
	public String getEffectiveTo() {
		return effectiveTo;
	}
	/**
	 * @param effectiveTo the effectiveTo to set
	 */
	public void setEffectiveTo(String effectiveTo) {
		this.effectiveTo = effectiveTo;
	}
	/**
	 * @return the approvedAmount
	 */
	public String getApprovedAmount() {
		return approvedAmount;
	}
	/**
	 * @param approvedAmount the approvedAmount to set
	 */
	public void setApprovedAmount(String approvedAmount) {
		this.approvedAmount = approvedAmount;
	}
	/**
	 * @return the visitId
	 */
	public String getVisitId() {
		return visitId;
	}
	/**
	 * @param visitId the visitId to set
	 */
	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}
	/**
	 * @return the accountSeqNo
	 */
	public String getAccountSeqNo() {
		return accountSeqNo;
	}
	/**
	 * @param accountSeqNo the accountSeqNo to set
	 */
	public void setAccountSeqNo(String accountSeqNo) {
		this.accountSeqNo = accountSeqNo;
	}
	/**
	 * @return the payerGroupShortName
	 */
	public String getPayerGroupShortName() {
		return payerGroupShortName;
	}
	/**
	 * @param payerGroupShortName the payerGroupShortName to set
	 */
	public void setPayerGroupShortName(String payerGroupShortName) {
		this.payerGroupShortName = payerGroupShortName;
	}
	/**
	 * @return the payerShortName
	 */
	public String getPayerShortName() {
		return payerShortName;
	}
	/**
	 * @param payerShortName the payerShortName to set
	 */
	public void setPayerShortName(String payerShortName) {
		this.payerShortName = payerShortName;
	}
	/**
	 * @param payerShortName the payerShortName to set
	 */
	public void setPolicyShortName(String policyShortName) {
		this.policyShortName = policyShortName;
	}
	
	public String getPolicyShortName() {
		return policyShortName;
	}
	/**
	 * @return the episodeTypeList
	 */
	public ArrayList getEpisodeTypeList() {
		return EpisodeTypeList;
	}
	/**
	 * @param episodeTypeList the episodeTypeList to set
	 */
	public void setEpisodeTypeList(ArrayList episodeTypeList) {
		EpisodeTypeList = episodeTypeList;
	}
	
	
	/**
	 * @return the policyNumber
	 */
	public String getPolicyNumber() {
		return policyNumber;
	}
	/**
	 * @param policyNumber the policyNumber to set
	 */
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	/**
	 * @return the policyEffectiveFrom
	 */
	public String getPolicyEffectiveFrom() {
		return policyEffectiveFrom;
	}
	/**
	 * @param policyEffectiveFrom the policyEffectiveFrom to set
	 */
	public void setPolicyEffectiveFrom(String policyEffectiveFrom) {
		this.policyEffectiveFrom = policyEffectiveFrom;
	}
	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}
	/**
	 * @return the accountSequenceNO
	 */
	public String getAccountSequenceNO() {
		return accountSequenceNO;
	}
	/**
	 * @param accountSequenceNO the accountSequenceNO to set
	 */
	 /* ADDED  ON V201218    FOR MMS-DM-CRF-0100.1   BY Palani Narayanan starts */
	public void setAccountSequenceNO(String accountSequenceNO) {
		this.accountSequenceNO = accountSequenceNO;
	}
	
	
		public String getUnBuiledAmount() {
		return unBuiledAmount;
	}
	public void setUnBuiledAmount(String unBuiledAmount) {
		this.unBuiledAmount = unBuiledAmount;
	}
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		
		this.billNumber = billNumber;
	}
	public String getBillDate() {
		
		return billDate;
	}
	public void setBillDate(String billDate) {
	if(billDate.equals("null"))
		{
		this.billDate = "";	
		}
		else
		{	 billDate  = billDate.split(" ")[0];
				this.billDate = billDate;
		}
	}
	public String getAdmissionDate() {
		return AdmissionDate;
	}
	public void setAdmissionDate(String AdmissionDate) {
		AdmissionDate  = AdmissionDate.split(" ")[0];
				this.AdmissionDate = AdmissionDate;
				
	}
	 /* ADDED  ON V201218    FOR MMS-DM-CRF-0100.1   BY Palani Narayanan ends */
	 
	public ArrayList populateEpisodeTypeList(String facilityId, String locale)throws Exception 
	{
		Connection 			connection 									= 	null;		
		PreparedStatement 	preparedstatement 							= 	null;
		ResultSet 			resultSet									= 	null;	
		StringBuffer 		sql											=	null;
		ArrayList			episodeTypeList								=   null;
		/*String[]			arr											= 	null;*/
		String				blRepositoryKey								=	"EPISODE_TYPE_DROPDOWN";
		
		try
		{
			System.out.println("In populatePayerGroupList:::: ");
			connection = getConnection();
			episodeTypeList = new ArrayList();
			sql	=	new StringBuffer();	
			sql.append(BlRepository.getBlKeyValue(blRepositoryKey));
			System.out.println("SQL in populateEpisodeTypeList:::: "+sql);
			preparedstatement=connection.prepareStatement(sql.toString());	
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next())
			{
				
				episodeTypeList.add(resultSet.getString(1));
			}
			setEpisodeTypeList(episodeTypeList);
			
		}catch(Exception e){
			System.out.println("Exception in populateEpisodeTypeList in RecordApprovalPatientDataBean= "+e); 
			e.printStackTrace();
			}
			finally
			{
				if(resultSet!=null) resultSet.close();
				if(preparedstatement!=null) preparedstatement.close();
				if(connection!=null) ConnectionManager.returnConnection(connection);
				
			}

			return episodeTypeList;
		

		
	}
	 
	
	public void getEpisodeAndVisitId(String patinetId,String EpisodeType,String facilityId, String locale)throws Exception 
	{
		Connection 			connection 									= 	null;		
		PreparedStatement 	preparedstatement 							= 	null;
		ResultSet 			resultSet									= 	null;	
		StringBuffer 		sql											=	null;
		/*ArrayList			recordApprovalPatientdataList				=   null;
		String[]			arr											= 	null;*/
		String				blRepositoryKey								=	"";
		/*String 				visitId										=	"";
		String				episodeId									=	"";
		String				pId											=	"@patientId";
		String				fId											=	"@facilityId";
		String				eId											=	"@episodeId";
		String				vId											=	"@visitId";
		String				etId										=	"@episodeType";*/
		
		try
		{
			System.out.println("In getEpisodeAndVisitId:::: ");
			connection = getConnection();
			sql	=	new StringBuffer();	
			blRepositoryKey = "EPISODE_TYPE_RECORD_PREAPPROVAL";
			sql.append(BlRepository.getBlKeyValue(blRepositoryKey));
			sql.append(" '"+facilityId+"' ");
			sql.append("  and  EPISODE_TYPE = '"+EpisodeType+"' ");	
			//sql.append("  and  PATIENT_ID = '"+patinetId+"' ");	
			System.out.println("SQL in getEpisodeAndVisitId::::blRepositoryKey:::::: "+sql);
			preparedstatement=connection.prepareStatement(sql.toString());	
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next())
			{
				episodeId	= resultSet.getString("EPISODE_ID");
				visitId 	= resultSet.getString("VISIT_ID");
			}
		}catch(Exception e){
			System.out.println("Exception in getEpisodeAndVisitId in RecordApprovalPatientDataBean= "+e); 
			e.printStackTrace();
			}
			finally
			{
				if(resultSet!=null) resultSet.close();
				if(preparedstatement!=null) preparedstatement.close();
				if(connection!=null) ConnectionManager.returnConnection(connection);
				
			}
	}

	/*public ArrayList getRecordPreApprovalData(StringBuffer patientDataSql, String patinetId,String EpisodeType,String facilityId, String locale)throws Exception 
	{
		Connection 			connection 									= 	null;		
		PreparedStatement 	preparedstatement 							= 	null;
		ResultSet 			resultSet									= 	null;	
		StringBuffer 		sql											=	null;
		PreparedStatement 	preparedstatement1 							= 	null;
		ResultSet 			resultSet1									= 	null;	
		//StringBuffer 		sql1										=	null;
		ArrayList			recordApprovalPatientdataList				=   null;
		String[]			arr											= 	null;
		String[]			patinetNameAndMobile						=	null;				
		String				blRepositoryKey								=	"";
		String				blRepositoryKey1								=	"";
		String 				visitId										=	"";
		String				episodeId									=	"";
		String				pId											=	"@patientId";
		String				fId											=	"@facilityId";
		String				eId											=	"@episodeId";
		String				vId											=	"@visitId";
		String				etId										=	"@episodeType";
		String				pId1										=	"@patientId1";
		String				fId1										=	"@facilityId1";
		String				eId1										=	"@episodeId1";
		String				vId1										=	"@visitId1";
		String				etId1										=	"@episodeType1";
		
		try
		{
			System.out.println("In getRecordPreApprovalData:::: ");
			connection = getConnection();
			sql	=	new StringBuffer();	
			patinetNameAndMobile = new String[2];
			blRepositoryKey = "EPISODE_TYPE_RECORD_PREAPPROVAL";
			sql.append(BlRepository.getBlKeyValue(blRepositoryKey));
			sql.append(" '"+facilityId+"' ");
			sql.append("  and  EPISODE_TYPE = '"+EpisodeType+"' ");	
			sql.append("  and  PATIENT_ID = '"+patinetId+"' ");	
			System.out.println("SQL in populateEpisodeTypeList::::blRepositoryKey:::::: "+sql);
			preparedstatement=connection.prepareStatement(sql.toString());	
			resultSet = preparedstatement.executeQuery();
			recordApprovalPatientdataList = new ArrayList();
			//patinetNameAndMobile = getPatientNameAndMobile(patinetId,facilityId,locale);
			while (resultSet.next())
			{
				episodeId	= resultSet.getString("EPISODE_ID");
				visitId 	= resultSet.getString("VISIT_ID");

				try
				{
					sql1	=	new StringBuffer();	
					blRepositoryKey1 = "RECORD_PREAPPROVAL_PATIENT_DATA";
					sql1.append(BlRepository.getBlKeyValue(blRepositoryKey1));
					sql1.replace(sql1.indexOf(pId),sql1.indexOf(pId)+pId.length(),  patinetId);
					sql1.replace(sql1.indexOf(fId),sql1.indexOf(fId)+fId.length(),  facilityId);
					sql1.replace(sql1.indexOf(eId),sql1.indexOf(eId)+eId.length(),  episodeId);
					sql1.replace(sql1.indexOf(vId),sql1.indexOf(vId)+vId.length(),  visitId);
					sql1.replace(sql1.indexOf(etId),sql1.indexOf(etId)+etId.length(),  EpisodeType);
					sql1.replace(sql1.indexOf(pId1),sql1.indexOf(pId1)+pId1.length(),  patinetId);
					sql1.replace(sql1.indexOf(fId1),sql1.indexOf(fId1)+fId1.length(),  facilityId);
					sql1.replace(sql1.indexOf(eId1),sql1.indexOf(eId1)+eId1.length(),  episodeId);
					sql1.replace(sql1.indexOf(vId1),sql1.indexOf(vId1)+vId1.length(),  visitId);
					sql1.replace(sql1.indexOf(etId1),sql1.indexOf(etId1)+etId1.length(),  EpisodeType);
					System.out.println("SQL in populateEpisodeTypeList::::blRepositoryKey1:::::: "+sql1); 
					
						
					//blRepositoryKey1 = "RECORD_PREAPPROVAL_PATIENT_DATA";
					//patientDataSql.append(BlRepository.getBlKeyValue(blRepositoryKey1));
					System.out.println("SQL BEFORE in populateEpisodeTypeList::::blRepositoryKey1:::::: "+patientDataSql);
					//patientDataSql.replace(patientDataSql.indexOf(pId),patientDataSql.indexOf(pId)+pId.length(),  patinetId);
					patientDataSql.replace(patientDataSql.indexOf(fId),patientDataSql.indexOf(fId)+fId.length(),  facilityId);
					patientDataSql.replace(patientDataSql.indexOf(eId),patientDataSql.indexOf(eId)+eId.length(),  episodeId);
					patientDataSql.replace(patientDataSql.indexOf(vId),patientDataSql.indexOf(vId)+vId.length(),  visitId);
					patientDataSql.replace(patientDataSql.indexOf(etId),patientDataSql.indexOf(etId)+etId.length(),  EpisodeType);
					//patientDataSql.replace(patientDataSql.indexOf(pId1),patientDataSql.indexOf(pId1)+pId1.length(),  patinetId);
					patientDataSql.replace(patientDataSql.indexOf(fId1),patientDataSql.indexOf(fId1)+fId1.length(),  facilityId);
					patientDataSql.replace(patientDataSql.indexOf(eId1),patientDataSql.indexOf(eId1)+eId1.length(),  episodeId);
					patientDataSql.replace(patientDataSql.indexOf(vId1),patientDataSql.indexOf(vId1)+vId1.length(),  visitId);
					patientDataSql.replace(patientDataSql.indexOf(etId1),patientDataSql.indexOf(etId1)+etId1.length(),  EpisodeType);
					System.out.println("SQL in populateEpisodeTypeList::::blRepositoryKey1:::::: "+patientDataSql);
					preparedstatement1=connection.prepareStatement(patientDataSql.toString());	
					resultSet1 = preparedstatement1.executeQuery();
					int i = 0;
					
					while (resultSet1.next())
					{
						arr 		= 	new String[22];
						arr[0]		=   resultSet1.getString(ROWID);
						arr[1]		=   resultSet1.getString(BLNG_GRP_ID);
						arr[2]		=   resultSet1.getString(CUST_GROUP_CODE);
						arr[3]		=   resultSet1.getString(CUST_CODE);
						arr[4]		=   resultSet1.getString(POLICY_TYPE_CODE);
						arr[5]		=   resultSet1.getString(PRIORITY);
						arr[6]		=   resultSet1.getString(POLICY_NUMBER);
						arr[7]		=   formatDate(resultSet1.getString(EFFECTIVE_FROM));
						arr[8]		=   formatDate(resultSet1.getString(POLICY_EXPIRY_DATE));
						arr[10]		=   resultSet1.getString(CREDIT_AUTH_REF);
						arr[11]		=   resultSet1.getString(PATIENT_ID);
						arr[12]		=   resultSet1.getString(EPISODE_ID);
						arr[13]		=   resultSet1.getString(VISIT_ID);
						arr[14]		=   resultSet1.getString(APPROVED_AMT);
						arr[15]		=	EpisodeType;
						arr[16]		=	getPatientNameAndMobile(resultSet1.getString(PATIENT_ID),facilityId,locale)[0];//patinetNameAndMobile[0];
						arr[17]		=	getPatientAge(resultSet1.getString(PATIENT_ID),facilityId,locale);
						arr[18]		=	getPatientNameAndMobile(resultSet1.getString(PATIENT_ID),facilityId,locale)[1];//patinetNameAndMobile[1];
						arr[19]		=	resultSet1.getString(ENCOUNTER_ID);
						arr[20]		=   formatDate(resultSet1.getString(EFFECTIVE_TO));
						arr[21]		=   resultSet1.getString(ACCT_SEQ_NO);
						recordApprovalPatientdataList.add(arr);
						
					}
				}	
			catch(Exception e){
				System.out.println("Exception inSIDE BLOCK getRecordPreApprovalData in RecordApprovalPatientDataBean= "+e); 
				e.printStackTrace();
				}
				finally
				{
					if(resultSet1!=null) resultSet1.close();
					if(preparedstatement1!=null) preparedstatement1.close();
					//if(connection!=null) ConnectionManager.returnConnection(connection);
					
				}
				
			}
			
		System.out.println("recordApprovalPatientdataList SIZE:::::: "+recordApprovalPatientdataList.size());
			
		}catch(Exception e){
			System.out.println("Exception in getRecordPreApprovalData in RecordApprovalPatientDataBean= "+e); 
			e.printStackTrace();
			}
			finally
			{
				if(resultSet!=null) resultSet.close();
				if(preparedstatement!=null) preparedstatement.close();
				if(connection!=null) ConnectionManager.returnConnection(connection);
				
			}

			return recordApprovalPatientdataList;
		

		
	}*/
	
	/* Added 3 more parameters 'String servGrpCode, String servClsfctnCode, String orderStatus'/Added by Aravindh/11-04-2018/MMS-DM-CRF-0125 */
	/* Modified V190103-Aravindh/MMS-DM-CRF-0125/Added 5 more parameters for performance */
	public LinkedHashMap getRecordPreApprovalData(String patientId,String patientName,String speciality,String policyCode,String encounterToDate,String encounterFromDate,String customerCode,String customerGroupCode,String encounterId,String  episodeType,String requestStatus,String  facilityId,String  locale, String servGrpCode, String servClsfctnCode, String orderStatus, String calledForm, String operationMode, String localSessionId, int startRcrd, int endRcrd)throws Exception 
	{
		Connection 						connection 									= 	null;		
		CallableStatement   			callableStatement							= 	null;
		/*ResultSet 						resultSet									= 	null;*/	
		String		 					sql											=	null;
		/*ArrayList						recordApprovalPatientdataList				=   null;
		String[]						arr											= 	null;*/
		Array							listArray									=	null;
		/*String[]						patinetNameAndMobile						=	null;*/	
		LinkedHashMap					recordPreApprovalDataMap					=	null;
		RecordApprovalPatientDataBean 	recordApprovalPatientDataBean				=	null; 
		
		
		try
		{
			
			System.out.println("In getRecordPreApprovalData:::: ");
			connection 					=	getConnection();
			recordPreApprovalDataMap	=	new LinkedHashMap();
			/* Added V190103-Aravindh/MMS-DM-CRF-0125/Starts */
			if("serviceApprStatus".equals(calledForm) && "search".equals(operationMode)) {
				sql = "{ call IBAEHIS.bl_record_appr_enc_policy_per(?,?,?,?,?,?,?,?,?,?,?,?,?,null,?,?,?,?,?,?,?,?,?,?,?,?) }";
				callableStatement 			= connection.prepareCall(sql);
				callableStatement.setString(1,facilityId);
				callableStatement.setString(2,patientId);
				callableStatement.setString(3,patientName);
				callableStatement.setString(4,episodeType);
				callableStatement.setString(5,encounterId);       
				callableStatement.setString(6,speciality); 
				callableStatement.setString(7,customerGroupCode);   
				callableStatement.setString(8,customerCode); 
				callableStatement.setString(9,policyCode);
				callableStatement.setDate(10,new Date(getDateInLong(encounterFromDate)));	      
				callableStatement.setDate(11,new Date(getDateInLong(encounterToDate)));	 
				callableStatement.setString(12,requestStatus);
				callableStatement.setString(13,localSessionId);
				callableStatement.setString(14,servGrpCode);
				callableStatement.setString(15,servClsfctnCode);
				callableStatement.setString(16,orderStatus);
				
				callableStatement.setString(17,login_by_id);
				callableStatement.setString(18,login_at_ws_no);
				callableStatement.setString(19,facilityId);
				callableStatement.setString(20,login_by_id);
				callableStatement.setString(21,login_at_ws_no);
				callableStatement.setString(22,facilityId);
				callableStatement.registerOutParameter(23, java.sql.Types.VARCHAR);
				callableStatement.registerOutParameter(24, java.sql.Types.VARCHAR);
				callableStatement.registerOutParameter(25, java.sql.Types.VARCHAR);
				
				callableStatement.execute(); 
				
				String errorLevel = callableStatement.getString(23);
				String sysMsgId = callableStatement.getString(24);
				String errorText = callableStatement.getString(25);
				
				if(null != errorLevel && "" != errorLevel) {
					System.err.println(errorText+", "+sysMsgId);
				}
				
				callableStatement.close();
				/*sql = "select count(*) from bl_service_status_screen_tmp";
				PreparedStatement preparedstatement = connection.prepareStatement(sql);
				ResultSet rst = preparedstatement.executeQuery();
				if(rst.next()) {
					System.out.println("Total Query Count: "+rst.getString(1));
				}*/
				System.out.println("After ResultSet Execution");
			}
			/* Added V190103-Aravindh/MMS-DM-CRF-0125/Ends */
			
			/* Added 3 in paramaters in the below procedure/Added by Aravindh/11-04-2018/MMS-DM-CRF-0125 */
			/* Added V190103-Aravindh/MMS-DM-CRF-0125/Added 3 in paramaters in the below procedure */
			sql							=	"{ call   IBAEHIS.blinstransactions.bl_record_appr_enc_policy_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //V201013 modified
			callableStatement 			= connection.prepareCall(sql);
			callableStatement.setString(1,facilityId);
			callableStatement.setString(2,patientId);
			callableStatement.setString(3,patientName);
			callableStatement.setString(4,episodeType);
			callableStatement.setString(5,encounterId);       
			callableStatement.setString(6,speciality); 
			callableStatement.setString(7,customerGroupCode);   
			callableStatement.setString(8,customerCode); 
			callableStatement.setString(9,policyCode);
			callableStatement.setDate(10,new Date(getDateInLong(encounterFromDate)));	      
			callableStatement.setDate(11,new Date(getDateInLong(encounterToDate)));	 
			callableStatement.setString(12,requestStatus);
			
			callableStatement.registerOutParameter(13, java.sql.Types.ARRAY, "BL_PATIENT_ID");  
			callableStatement.registerOutParameter(14, java.sql.Types.ARRAY, "BL_PATIENT_NAME"); 
			callableStatement.registerOutParameter(15, java.sql.Types.ARRAY, "BL_EPISODE_ID"); 
			callableStatement.registerOutParameter(16, java.sql.Types.ARRAY, "BL_VISIT_ID"); 
			callableStatement.registerOutParameter(17, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); // data type change by vijay for mms crf 0077
			callableStatement.registerOutParameter(18, java.sql.Types.ARRAY, "BL_PATIENT_AGE_IN_WORDS"); 
			callableStatement.registerOutParameter(19, java.sql.Types.ARRAY, "BL_MOBILE_NUM"); 
			callableStatement.registerOutParameter(20, java.sql.Types.ARRAY, "BL_CUST_GRP_CODE"); 
			callableStatement.registerOutParameter(21, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); // YOUR ARRAY TYPE (TO MATCH THE API OUTPUT), NOT OBJECT /* Modified By Aravindh/11-04-2018/MMS-DM-CRF-0125/Changed type from BL_CUST_GRP_SNAME -> BL_CMN_TYPE_VARCHAR100 */
			callableStatement.registerOutParameter(22, java.sql.Types.ARRAY, "BL_CUST_CODE"); 
			callableStatement.registerOutParameter(23, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); /* Modified By Aravindh/11-04-2018/MMS-DM-CRF-0125/Changed type from BL_CUST_SNAME -> BL_CMN_TYPE_VARCHAR100 */
			callableStatement.registerOutParameter(24, java.sql.Types.ARRAY, "BL_POLICY_TYPE_CODE"); 
			callableStatement.registerOutParameter(25, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR1000");  // policy type code description
			callableStatement.registerOutParameter(26, java.sql.Types.ARRAY, "BL_POLICY_NUMBER"); 
			callableStatement.registerOutParameter(27, java.sql.Types.ARRAY, "BL_POLICY_EFF_FROM"); 
			callableStatement.registerOutParameter(28, java.sql.Types.ARRAY, "BL_POLICY_EFF_TO"); 
			callableStatement.registerOutParameter(29, java.sql.Types.ARRAY, "BL_APPROVED_AMOUNT"); 
			callableStatement.registerOutParameter(30, java.sql.Types.ARRAY, "BL_PRIORITY"); 
			callableStatement.registerOutParameter(31, java.sql.Types.ARRAY, "BL_LATEST_ACCT_SEQ_NO"); 
			callableStatement.registerOutParameter(32, java.sql.Types.ARRAY, "BL_POLICY_EXPIRY"); 
			
			/* Added V180521-Aravindh/MMS-DM-CRF-0125 */
			if(null != servGrpCode && "**".equals(servGrpCode)) {
				servGrpCode = ""; 
			}
			if(null != servClsfctnCode && "**".equals(servClsfctnCode)) {
				servClsfctnCode = "";
			}
			callableStatement.setString(33, servGrpCode);
			callableStatement.setString(34, servClsfctnCode);
			callableStatement.setString(35, orderStatus);
			
			/* Added V190103-Aravindh/MMS-DM-CRF-0125/Added if-else */
			if("serviceApprStatus".equals(calledForm)) {
				callableStatement.setString(36, localSessionId);
				callableStatement.setInt(37, startRcrd);
				callableStatement.setInt(38, endRcrd);
			} else {
				callableStatement.setString(36, null);
				callableStatement.setString(37, null);
				callableStatement.setString(38, null);
			}

			callableStatement.registerOutParameter(39,java.sql.Types.ARRAY,"BL_CMN_TYPE_VARCHAR1"); //V201013 added
			callableStatement.registerOutParameter(40,java.sql.Types.ARRAY,"BL_CMN_TYPE_VARCHAR100"); //V231107 added
			
			callableStatement.execute(); 
			
			for(int k=13;k<41;k++) //V201013 modified V231107 (40-41)
			//for(int k=13;k<33;k++)
			{
				if (k>=33 && k<=38) continue; //V201013 added
				listArray = callableStatement.getArray (k); 
				System.out.println("listArray in getRecordPreApprovalData listArray :::"+listArray); 
	            Object[] values = (Object[]) listArray.getArray(); 
	            System.out.println("Values[] in getRecordPreApprovalData values Length:::::"+values.length+" ::: "+values); 
	            if(values!=null)
	            {
	            	for (int i=0; i < values.length; i++)                 
		            {
		            	System.out.println("Values in getRecordPreApprovalData for :::"+k+" :::: "+values[i]); 
		           
			            if(recordPreApprovalDataMap.containsKey(i))
		            	{
			            	recordApprovalPatientDataBean = (RecordApprovalPatientDataBean) recordPreApprovalDataMap.get(i);
		            		switch(k)
		            		{
			            		case 13: 	recordApprovalPatientDataBean.setPatientId(((String)values[i]));
	    									break;
				    			case 14: 	recordApprovalPatientDataBean.setPatientName((String)values[i]);
											break;
				    			case 15: 	recordApprovalPatientDataBean.setEpisodeId((String.valueOf(values[i])));
											break;
				    			case 16: 	recordApprovalPatientDataBean.setVisitId((String.valueOf(values[i])));
											break;
				    			case 17: 	recordApprovalPatientDataBean.setEncounterId((String.valueOf(values[i])));
											break;
				    			case 18: 	recordApprovalPatientDataBean.setAge(((String)values[i]));
											break;
				    			case 19: 	recordApprovalPatientDataBean.setMobileNumber(((String)values[i]));
											break;
				    			case 20: 	recordApprovalPatientDataBean.setPayerGroup(((String)values[i]));
											break;
				    			case 21: 	recordApprovalPatientDataBean.setPayerGroupShortName((String)values[i]);
											break;
				    			case 22: 	recordApprovalPatientDataBean.setPayer(((String)values[i]));
											break;
				    			case 23: 	recordApprovalPatientDataBean.setPayerShortName(((String)values[i]));
											break;
				    			case 24: 	recordApprovalPatientDataBean.setPolicy(((String)values[i]));
											break;
				    			case 25: 	recordApprovalPatientDataBean.setPolicyShortName(((String)values[i]));
											break;	
				    			case 26: 	recordApprovalPatientDataBean.setPolicyNumber(((String)values[i]));
											break;
				    			case 27: 	recordApprovalPatientDataBean.setPolicyEffectiveFrom(formatDate(values[i]!=null ? String.valueOf(values[i]) : ""));
											break;
				    			case 28: 	recordApprovalPatientDataBean.setPolicyEffectiveTo(formatDate(values[i]!=null ? String.valueOf(values[i]) : ""));
											break;
				    			case 29: 	recordApprovalPatientDataBean.setApprovedAmount(values[i]!=null ? String.valueOf(values[i]) : "");
											break;
				    			case 30: 	recordApprovalPatientDataBean.setPriority(String.valueOf(values[i]));
											break;
				    			case 31: 	recordApprovalPatientDataBean.setAccountSequenceNO(String.valueOf(values[i]));
				    						System.out.println("IN getScreenServiceCriteria recordApprovalPatientDataBean.setAccountSequenceNO::::::::"+String.valueOf(values[i]));
											break;
				    			case 32: 	recordApprovalPatientDataBean.setPolicyExpDate(String.valueOf(values[i]));
	    					//	System.out.println("IN getScreenServiceCriteria recordApprovalPatientDataBean.setPolicyExpDate::::::::"+String.valueOf(values[i]));
	    									break;
				    			case 39: 	recordApprovalPatientDataBean.setColorStatus(String.valueOf(values[i]));   //V201013 added
				    						break; 
				    			case 40: 	recordApprovalPatientDataBean.setMembershipNo(String.valueOf(values[i]));   //V201013 added
				    						break; 
				    			default:	
		    				}
		            	}
		            	else
		            	{	
		            		recordApprovalPatientDataBean = new RecordApprovalPatientDataBean();
		            		switch(k)
		            		{
			            		case 13: 	recordApprovalPatientDataBean.setPatientId(((String)values[i]));
	    									break;
				    			case 14: 	recordApprovalPatientDataBean.setPatientName((String)values[i]);
											break;
				    			case 15: 	recordApprovalPatientDataBean.setEpisodeId((String.valueOf(values[i])));
											break;
				    			case 16: 	recordApprovalPatientDataBean.setVisitId((String.valueOf(values[i])));
											break;
				    			case 17: 	recordApprovalPatientDataBean.setEncounterId((String.valueOf(values[i])));
											break;
				    			case 18: 	recordApprovalPatientDataBean.setAge(((String)values[i]));
											break;
				    			case 19: 	recordApprovalPatientDataBean.setMobileNumber(((String)values[i]));
											break;
				    			case 20: 	recordApprovalPatientDataBean.setPayerGroup(((String)values[i]));
											break;
				    			case 21: 	recordApprovalPatientDataBean.setPayerGroupShortName((String)values[i]);
											break;
				    			case 22: 	recordApprovalPatientDataBean.setPayer(((String)values[i]));
											break;
				    			case 23: 	recordApprovalPatientDataBean.setPayerShortName(((String)values[i]));
											break;
				    			case 24: 	recordApprovalPatientDataBean.setPolicy(((String)values[i]));
											break;
				    			case 25: 	recordApprovalPatientDataBean.setPolicyShortName(((String)values[i]));
											break;				
				    			case 26: 	recordApprovalPatientDataBean.setPolicyNumber(((String)values[i]));
											break;
				    			case 27: 	recordApprovalPatientDataBean.setPolicyEffectiveFrom(formatDate(values[i]!=null ? String.valueOf(values[i]) : ""));
											break;
				    			case 28: 	recordApprovalPatientDataBean.setPolicyEffectiveTo(formatDate(values[i]!=null ? String.valueOf(values[i]) : ""));
											break;
				    			case 29: 	recordApprovalPatientDataBean.setApprovedAmount(values[i]!=null ? String.valueOf(values[i]) : "");
											break;
				    			case 30: 	recordApprovalPatientDataBean.setPriority(String.valueOf(values[i]));
											break;
				    			case 31: 	recordApprovalPatientDataBean.setAccountSequenceNO(String.valueOf(values[i]));
				    						System.out.println("IN getScreenServiceCriteria recordApprovalPatientDataBean.setAccountSequenceNO::::::::"+String.valueOf(values[i]));
											break;
				    			case 32: 	recordApprovalPatientDataBean.setPolicyExpDate(String.valueOf(values[i]));
	    					//	System.out.println("IN getScreenServiceCriteria recordApprovalPatientDataBean.setPolicyExpDate::::::::"+String.valueOf(values[i]));
											break;
								case 39: 	recordApprovalPatientDataBean.setColorStatus(String.valueOf(values[i]));   //V201013 added
				    						break; 
								case 40: 	recordApprovalPatientDataBean.setMembershipNo(String.valueOf(values[i]));   //V201013 added
	    									break; 
								default:	
		    				}
		            	recordPreApprovalDataMap.put(i, recordApprovalPatientDataBean);
		            	}
		            }    
				}     
	        }
	            
			   
			System.out.println("IN getScreenServiceCriteria screenServiceCriteriaListMap::::::::"+recordPreApprovalDataMap);
			System.out.println("IN getScreenServiceCriteria screenServiceCriteriaListMap:size:::::::"+recordPreApprovalDataMap.size());
			/*Iterator iterator= recordPreApprovalDataMap.keySet().iterator();
			while(iterator.hasNext())
			{
				
				int key =    (Integer)iterator.next();
				System.out.println("IN getScreenServiceCriteria key:::::::"+key);
				recordApprovalPatientDataBean = (RecordApprovalPatientDataBean) recordPreApprovalDataMap.get(key);  
					System.out.println("INDEX::: "+key+" ::::PatientId::::::::::::::::: "+recordApprovalPatientDataBean.getPatientId());
					System.out.println("INDEX::: "+key+" ::::bl_patient_name::::::::::: "+recordApprovalPatientDataBean.getPatientName());
					System.out.println("INDEX::: "+key+" ::::bl_episode_id::::::::::::: "+recordApprovalPatientDataBean.getEpisodeId());
					System.out.println("INDEX::: "+key+" ::::bl_visit_id::::::::::::::: "+recordApprovalPatientDataBean.getVisitId());
					System.out.println("INDEX::: "+key+" ::::bl_encounter_id::::::::::: "+recordApprovalPatientDataBean.getEncounterId());
					System.out.println("INDEX::: "+key+" ::::bl_patient_age_in_words::: "+recordApprovalPatientDataBean.getAge());
					System.out.println("INDEX::: "+key+" ::::bl_mobile_num::::::::::::: "+recordApprovalPatientDataBean.getMobileNumber());
					System.out.println("INDEX::: "+key+" ::::bl_cust_grp_code:::::::::: "+recordApprovalPatientDataBean.getPayerGroup());
					System.out.println("INDEX::: "+key+" ::::bl_cust_grp_sname::::::::: "+recordApprovalPatientDataBean.getPayerGroupShortName());
					System.out.println("INDEX::: "+key+" ::::bl_cust_code:::::::::::::: "+recordApprovalPatientDataBean.getPayer());
					System.out.println("INDEX::: "+key+" ::::bl_cust_sname::::::::::::: "+recordApprovalPatientDataBean.getPayerShortName());
					System.out.println("INDEX::: "+key+" ::::bl_policy_type_code::::::: "+recordApprovalPatientDataBean.getPolicy());
					System.out.println("INDEX::: "+key+" ::::bl_policy_number:::::::::: "+recordApprovalPatientDataBean.getPolicyNumber());
					System.out.println("INDEX::: "+key+" ::::bl_policy_eff_from:::::::: "+recordApprovalPatientDataBean.getPolicyEffectiveFrom());
					System.out.println("INDEX::: "+key+" ::::bl_policy_eff_to:::::::::: "+recordApprovalPatientDataBean.getPolicyEffectiveTo());
					System.out.println("INDEX::: "+key+" ::::bl_approved_amount:::::::: "+recordApprovalPatientDataBean.getApprovedAmount());
					System.out.println("INDEX::: "+key+" ::::bl_priority::::::::::::::: "+recordApprovalPatientDataBean.getPriority());
					System.out.println("INDEX::: "+key+" ::::bl_latest_acct_seq_no::::: "+recordApprovalPatientDataBean.getAccountSequenceNO());
				
				
			}*/
			
		}catch(Exception e){
			System.out.println("Exception in getRecordPreApprovalData in RecordApprovalPatientDataBean= "+e); 
			e.printStackTrace();
			}
			finally
			{
				if(callableStatement!=null) callableStatement.close();
				if(connection!=null) ConnectionManager.returnConnection(connection);
				
			}

			return recordPreApprovalDataMap;
		

		
	}
	
	
	//	public LinkedHashMap getInterimBillApprovalData(String patientId,String patientName,String speciality,String policyCode,String encounterToDate,String encounterFromDate,String customerCode,String customerGroupCode,String encounterId,String  episodeType,String requestStatus,String  facilityId,String  locale, String servGrpCode, String servClsfctnCode, String orderStatus, String calledForm, String operationMode, String localSessionId, int startRcrd, int endRcrd)throws Exception 
	public LinkedHashMap getInterimBillApprovalData(String  facilityId,String patientId,String patientName,String episodeType,String encounterId ,String speciality,String customerGroupCode,String  customerCode,String  policyTypecode)throws Exception 
	{
		Connection 						connection 									= 	null;		
		CallableStatement   			callableStatement							= 	null;
		/*ResultSet 						resultSet									= 	null;*/	
		String		 					sql											=	null;
		/*ArrayList						recordApprovalPatientdataList				=   null;
		String[]						arr											= 	null;*/
		Array							listArray									=	null;
		/*String[]						patinetNameAndMobile						=	null;*/	
		LinkedHashMap					recordPreApprovalDataMap					=	null;
		RecordApprovalPatientDataBean 	recordApprovalPatientDataBean				=	null; 
	try
		{
			
			System.out.println("In getRecordPreApprovalData:::: ");
			connection 					=	getConnection();
			recordPreApprovalDataMap	=	new LinkedHashMap();
			/* Added V190103-Aravindh/MMS-DM-CRF-0125/Starts */
			if(true) {
				System.out.println("In getRecordPreApprovalData::::1021 ");
				sql = "{ call IBAEHIS.bl_get_int_bill_auth_episodes(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
				callableStatement 			= connection.prepareCall(sql);
				callableStatement.setString(1,facilityId);
				callableStatement.setString(2,patientId);
				callableStatement.setString(3,patientName);
				callableStatement.setString(4,episodeType);       
				callableStatement.setString(5,encounterId); 
				callableStatement.setString(6,speciality); 
				callableStatement.setString(7,customerGroupCode);   
				callableStatement.setString(8,customerCode); 
				callableStatement.setString(9,policyTypecode);
				callableStatement.registerOutParameter(10, java.sql.Types.ARRAY, "BL_PATIENT_ID");  
				callableStatement.registerOutParameter(11, java.sql.Types.ARRAY, "BL_PATIENT_NAME"); 
				callableStatement.registerOutParameter(12, java.sql.Types.ARRAY, "BL_EPISODE_ID"); 
				callableStatement.registerOutParameter(13, java.sql.Types.ARRAY, "BL_CMN_TYPE_DATE"); 
				callableStatement.registerOutParameter(14, java.sql.Types.ARRAY, "BL_CUST_GRP_CODE"); // data type change by vijay for mms crf 0077
				callableStatement.registerOutParameter(15, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
				callableStatement.registerOutParameter(16, java.sql.Types.ARRAY, "BL_CUST_CODE"); 
				callableStatement.registerOutParameter(17, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
				callableStatement.registerOutParameter(18, java.sql.Types.ARRAY, "BL_POLICY_TYPE_CODE"); // YOUR ARRAY TYPE (TO MATCH THE API OUTPUT), NOT OBJECT /* Modified By Aravindh/11-04-2018/MMS-DM-CRF-0125/Changed type from BL_CUST_GRP_SNAME -> BL_CMN_TYPE_VARCHAR100 */
				callableStatement.registerOutParameter(19, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR1000"); 
				callableStatement.registerOutParameter(20, java.sql.Types.ARRAY, "BL_UNBILLED_AMOUNT_TYPE"); /* Modified By Aravindh/11-04-2018/MMS-DM-CRF-0125/Changed type from BL_CUST_SNAME -> BL_CMN_TYPE_VARCHAR100 */
				callableStatement.registerOutParameter(21, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
				callableStatement.registerOutParameter(22, java.sql.Types.ARRAY, "BL_CMN_TYPE_DATE");  // policy type code description
				callableStatement.registerOutParameter(23, java.sql.Types.VARCHAR);
				callableStatement.execute(); 
				String errorText = callableStatement.getString(23);
				System.err.println(errorText+", "+errorText);
				System.out.println("After ResultSet Execution");
			}
		
			
			for(int k=10;k<23;k++) //V201013 modified
			{
				listArray = callableStatement.getArray (k); 
	            Object[] values = (Object[]) listArray.getArray();  
	            if(values!=null)
	            {
	            	for (int i=0; i < values.length; i++)                 
		            {
			            if(recordPreApprovalDataMap.containsKey(i)){
			            	recordApprovalPatientDataBean = (RecordApprovalPatientDataBean) recordPreApprovalDataMap.get(i);
		            		switch(k)
		            		{
			            		case 10: 	recordApprovalPatientDataBean.setPatientId(((String)values[i]));
	    									break;
				    			case 11: 	recordApprovalPatientDataBean.setPatientName((String)values[i]);
											break;
				    			case 12: 	recordApprovalPatientDataBean.setEpisodeId((String.valueOf(values[i])));
											break;
				    			case 13: 	recordApprovalPatientDataBean.setAdmissionDate((String.valueOf(values[i])));
											break;
								case 14: 	recordApprovalPatientDataBean.setPayerGroup(((String)values[i]));
											break;
				    			case 15: 	recordApprovalPatientDataBean.setPayerGroupShortName((String)values[i]);
											break;
											
				    			case 16: 	recordApprovalPatientDataBean.setPayer(((String)values[i]));
											break;
				    			case 17: 	recordApprovalPatientDataBean.setPayerShortName(((String)values[i]));
											break;
											
				    			case 18: 	recordApprovalPatientDataBean.setPolicy(((String)values[i]));
											break;
				    			case 19: 	recordApprovalPatientDataBean.setPolicyShortName(((String)values[i]));
											break;
				    			case 20: 	recordApprovalPatientDataBean.setUnBuiledAmount((String.valueOf(values[i])));
											break;
				    			case 21: 	recordApprovalPatientDataBean.setBillNumber(((String)values[i]));
											break;
				    			case 22: 	recordApprovalPatientDataBean.setBillDate((String.valueOf(values[i])));
											break;

										default:	
		    				}
		            	}
		            	else
		            	{	
		            		recordApprovalPatientDataBean = new RecordApprovalPatientDataBean();
		            		switch(k)
		            		{
			            		case 10: 	recordApprovalPatientDataBean.setPatientId(((String)values[i]));
	    									break;
				    			case 11: 	recordApprovalPatientDataBean.setPatientName((String)values[i]);
											break;
				    			case 12: 	recordApprovalPatientDataBean.setEpisodeId((String.valueOf(values[i])));
											break;
				    			case 13: 	recordApprovalPatientDataBean.setAdmissionDate((String.valueOf(values[i])));
											break;
								case 14: 	recordApprovalPatientDataBean.setPayerGroup(((String)values[i]));
											break;
				    			case 15: 	recordApprovalPatientDataBean.setPayerGroupShortName((String)values[i]);
											break;
											
				    			case 16: 	recordApprovalPatientDataBean.setPayer(((String)values[i]));
											break;
				    			case 17: 	recordApprovalPatientDataBean.setPayerShortName(((String)values[i]));
											break;
											
				    			case 18: 	recordApprovalPatientDataBean.setPolicy(((String)values[i]));
											break;
				    			case 19: 	recordApprovalPatientDataBean.setPolicyShortName(((String)values[i]));
											break;
				    			case 20: 	recordApprovalPatientDataBean.setUnBuiledAmount((String.valueOf(values[i])));
											break;
				    			case 21: 	recordApprovalPatientDataBean.setBillNumber(((String)values[i]));
											break;
				    			case 22: 	recordApprovalPatientDataBean.setBillDate(((String)values[i]));
											break;

									default:	
								
		    				}
		            	recordPreApprovalDataMap.put(i, recordApprovalPatientDataBean);
		            	hasPatSearchValues.put(i, recordApprovalPatientDataBean);
		            	}
		            }    
				}     
	        }			
		}catch(Exception e){
			System.out.println("Exception in getRecordPreApprovalData in RecordApprovalPatientDataBean= "+e); 
			e.printStackTrace();
			}
			finally
			{
				if(callableStatement!=null) callableStatement.close();
				if(connection!=null) ConnectionManager.returnConnection(connection);
				
			}

			return recordPreApprovalDataMap;		
	}
	
	public void clearBean()
	{
		if( hasPatSearchValues != null )
	 	{
			hasPatSearchValues.clear();
	 	}
		else
		{
			hasPatSearchValues	= new java.util.LinkedHashMap();
		}	
	}	
	
	public String[] getPatientNameAndMobile(String patinetId,String facilityId, String locale)throws Exception 
	{
		Connection 			connection 									= 	null;		
		PreparedStatement 	preparedstatement 							= 	null;
		ResultSet 			resultSet									= 	null;	
		StringBuffer 		sql											=	null;
		/*ArrayList			recordApprovalPatientdataList				=   null;*/
		String[]			arr											= 	null;
		String				blRepositoryKey								=	"";
		
		
			try
		{
			System.out.println("In getPatientNameAndMobile:::: ");
			connection = getConnection();
			sql	=	new StringBuffer();	
			blRepositoryKey = "PRE_APPROVAL_REQUEST_PATIENTNAME_AND_MOBILE";
			sql.append(BlRepository.getBlKeyValue(blRepositoryKey));
			sql.append(" '"+patinetId+"' ");	
			System.out.println("SQL in getPatientNameAndMobile::::blRepositoryKey:::::: "+sql);
			preparedstatement=connection.prepareStatement(sql.toString());	
			resultSet = preparedstatement.executeQuery();
			arr = new String[2];
			while (resultSet.next())
			{
				arr[0]	=	resultSet.getString("SHORT_NAME");
				arr[1]	=	resultSet.getString("OTHER_CONTACT_NUM");
				
			}
		}catch(Exception e){
			System.out.println("Exception in getPatientNameAndMobile in RecordApprovalPatientDataBean= "+e); 
			e.printStackTrace();
			}
			finally
			{
				if(resultSet!=null) resultSet.close();
				if(preparedstatement!=null) preparedstatement.close();
				if(connection!=null) ConnectionManager.returnConnection(connection);
				
			}
		return arr;
	}
	
	
	public String getPatientAge(String patinetId,String facilityId, String locale)throws Exception 
	{
		Connection 			connection 									= 	null;		
		PreparedStatement 	preparedstatement 							= 	null;
		ResultSet 			resultSet									= 	null;	
		StringBuffer 		sql											=	null;
		/*ArrayList			recordApprovalPatientdataList				=   null;*/
		String				patientAge									= 	null;
		String				blRepositoryKey								=	"";
		
		
		try
		{
			System.out.println("In getPatientAge:::: ");
			connection = getConnection();
			sql	=	new StringBuffer();	
			patientAge="";
			blRepositoryKey = "PRE_APPROVAL_REQUEST_PATIENT_AGE";
			sql.append(BlRepository.getBlKeyValue(blRepositoryKey));
			sql.append(" '"+patinetId+"' ");	
			System.out.println("SQL in getPatientAge::::blRepositoryKey:::::: "+sql);
			preparedstatement=connection.prepareStatement(sql.toString());	
			resultSet = preparedstatement.executeQuery();
			
			while (resultSet.next())
			{
				patientAge = resultSet.getString(1)+" Y "+resultSet.getString(2)+" M "+resultSet.getString(3)+" M";
				
			}
		}catch(Exception e){
			System.out.println("Exception in getPatientAge in RecordApprovalPatientDataBean= "+e); 
			e.printStackTrace();
			}
			finally
			{
				if(resultSet!=null) resultSet.close();
				if(preparedstatement!=null) preparedstatement.close();
				if(connection!=null) ConnectionManager.returnConnection(connection);
				
			}
		return patientAge;
	}
	
	public String getRecordApprovalPatientName(String patientId) throws Exception 
	{ 
		System.out.println("IN getRecordApprovalPatientName@@");
		Connection 			connection 										= 	null;		
		/*CallableStatement 	callableStatement 								= 	null;*/
		PreparedStatement 	preparedstatement 							= 	null;
		ResultSet 			resultSet									= 	null;	
		StringBuffer 		patientNameSql									=	new StringBuffer();	
		String				patientName										=	"";
		
		
		try
		{
			System.out.println("In getPatientAge:::: ");
			connection = getConnection();
			patientNameSql	=	new StringBuffer();	
			patientNameSql.append("SELECT SHORT_NAME FROM MP_PATIENT_MAST WHERE PATIENT_ID = ");
			patientNameSql.append(" '"+patientId+"' ");	
			System.out.println("SQL in getRecordApprovalPatientName:::::::::: "+patientNameSql);
			preparedstatement=connection.prepareStatement(patientNameSql.toString());	
			resultSet = preparedstatement.executeQuery();
			
			while (resultSet.next())
			{
				patientName = resultSet.getString(1);
				
			}
		}catch(Exception e){
			System.out.println("Exception in getPatientAge in RecordApprovalPatientDataBean= "+e); 
			e.printStackTrace();
			}
			finally
			{
				if(resultSet!=null) resultSet.close();
				if(preparedstatement!=null) preparedstatement.close();
				if(connection!=null) ConnectionManager.returnConnection(connection);
				
			}
		return patientName;
	}	
	
	
	@SuppressWarnings("unused")
	private String getDate(long timeStamp)
	{

	    try{
	        DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	        Date netDate = (new Date(timeStamp));
	        return sdf.format(netDate);
	    }
	    catch(Exception ex){
	    	System.out.println("Exception in getDate in RecordApprovalPatientDataBean= "+ex);
	        return "xx";
	    }
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
	
	/*
	* This method takes input in DD/MM/YYYY format and provides appropriate 
	* long value
	*/ 
	private long getDateInLong(String dateString){ 
		
		System.out.println("dateString in getDateInLong ::: "+dateString);
	if(dateString==null){
	return 0; 
	}
	else{
	try {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Timestamp inputTimestamp = new Timestamp(sdf.parse(dateString).getTime());
	return inputTimestamp.getTime();
	} catch (ParseException e) {
	System.out.println("Error in Input Date Format");
	e.printStackTrace();
	}
	}
	return 0;
	} 
}
