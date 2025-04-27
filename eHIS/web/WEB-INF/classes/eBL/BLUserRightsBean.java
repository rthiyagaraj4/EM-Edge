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
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import webbeans.eCommon.ConnectionManager;
import eBL.Common.BlAdapter;
import eBL.Common.BlRepository;

public class BLUserRightsBean extends  BlAdapter implements Serializable{


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
	protected String 		policyNumber										=	"";
	protected String 		policyEffectiveFrom									=	"";
	protected String 		priority											=	"";
	protected String 		accountSequenceNO									=	"";

	protected ArrayList		EpisodeTypeList										=	null;
	protected ArrayList		FunctionTypeList									=	null;
	protected ArrayList		FunctionTypeDescList									=	null;
	protected ArrayList		PrevilegeTypeDescList									=	null;
	protected ArrayList		PrevilegeTypeList									=	null;
	protected String userType													="";
	protected String userCode													="";
	protected String functionID													="";
	protected String functionDesc													="";
	protected String previlegeID													="";
	
	//Added By Rajesh V
	protected String allowedYn = "";
	public String getAllowedYn() {
		return allowedYn;
	}
	public void setAllowedYn(String allowedYn) {
		this.allowedYn = allowedYn;
	}

	
	protected String previlegeDesc													="";
	SimpleDateFormat sdf 														= new SimpleDateFormat("dd/MM/yyyy");
	public static final	String 	   OPERATING_FACILITY_ID						=  "OPERATING_FACILITY_ID";
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
	public static final	String     ROWID										=  "ROWID";




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
	 * @return the episodeTypeList
	 */
	public ArrayList getEpisodeTypeList() {
		return EpisodeTypeList;
	}
	/**
	 * @param episodeTypeList the episodeTypeList to set
	 */
	public void setFunctionTypeList(ArrayList functionTypeList) {
		FunctionTypeList = functionTypeList;
	}

	public ArrayList getFunctionTypeList() {
		return FunctionTypeList;
	}
	public void setFunctionTypeDescList(ArrayList functionTypeDescList) {
		FunctionTypeDescList = functionTypeDescList;
	}

	public ArrayList getFunctionTypeDescList() {
		return FunctionTypeDescList;
	}
	public void setPrevilegeTypeList(ArrayList previlegeTypeList) {
		PrevilegeTypeList = previlegeTypeList;
	}

	public ArrayList getPrevilegeTypeList() {
		return PrevilegeTypeList;
	}
	public void setPrevilegeTypeDescList(ArrayList previlegeTypeDescList) {
		PrevilegeTypeDescList = previlegeTypeDescList;
	}

	public ArrayList getPrevilegeTypeDescList() {
		return PrevilegeTypeDescList;
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
	public void setAccountSequenceNO(String accountSequenceNO) {
		this.accountSequenceNO = accountSequenceNO;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getFunctionID() {
		return functionID;
	}
	public void setFunctionID(String functionID) {
		this.functionID = functionID;
	}
	public String getFunctionDesc() {
		return functionDesc;
	}
	public void setFunctionDesc(String functionDesc) {
		this.functionDesc = functionDesc;
	}
	public String getPrevilegeID() {
		return previlegeID;
	}
	public void setPrevilegeID(String previlegeID) {
		this.previlegeID = previlegeID;
	}
	public String getPrevilegeDesc() {
		return previlegeDesc;
	}
	public void setPrevilegeDesc(String previlegeDesc) {
		this.previlegeDesc = previlegeDesc;
	}
	public LinkedHashMap populatePrevilegeTypeList(String facilityId, String userType,String userCode, String functionID, String todaysDate)throws Exception
	{		
		Connection 						connection 									= 	null;		
		CallableStatement   			callableStatement							= 	null;
		ResultSet 						resultSet									= 	null;	
		String		 					sql											=	null;
		Array							listArray									=	null;		
		LinkedHashMap					recordPrivilegeDetailsDataMap				=	null;
		BLUserRightsBean 				BLUserRightsBean							=	null; 
		
		
		try
		{
			connection 					=	getConnection();
			recordPrivilegeDetailsDataMap	=	new LinkedHashMap();
			//Added Extra Out Param - Rajesh V
			sql							=	"{ call   IBAEHIS.BLUSERACCESSDTLS.get_bl_privileges_by_user(?,?,?,?,?,?,?,?,?,?)}";
			callableStatement 			= connection.prepareCall(sql);
			System.out.println("facilityId======="+facilityId);
			System.out.println("userType======="+userType);
			System.out.println("userCode======="+userCode);
			System.out.println("functionID======="+functionID);
			System.out.println("todaysDate======="+todaysDate);
			callableStatement.setString(1,facilityId);
			callableStatement.setString(2,userType);
			callableStatement.setString(3,userCode);
			callableStatement.setString(4,functionID);
			//callableStatement.setDate(5,new Date(sdf.parse(todaysDate).getTime()));
			callableStatement.setString(5,todaysDate);
			callableStatement.registerOutParameter(6, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			callableStatement.registerOutParameter(7, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");
			callableStatement.registerOutParameter(8, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10");
			callableStatement.registerOutParameter(9, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");
			callableStatement.registerOutParameter(10, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");
			callableStatement.execute(); 
			
			for(int k=6;k<11;k++)
			{
				listArray = callableStatement.getArray (k); 
				System.out.println("listArray in populatePrevilegeTypeList listArray :::<<<BEANNN>>>>>>>>"+listArray); 
	            Object[] values = (Object[]) listArray.getArray(); 
	            System.out.println("Values[] in populatePrevilegeTypeList values Length:::<<<BEANNN>>>>>>>>"+values.length+" ::: "+values); 
	            if(values!=null)
	            {
	            	for (int i=0; i < values.length; i++)                 
		            {
		            	System.out.println("Values in populatePrevilegeTypeList for <BEANNN>>>>>>>>"+k+" :::BEANNN>>>>>>>>"+values[i]); 
		           
			            if(recordPrivilegeDetailsDataMap.containsKey(i))
		            	{
			            	BLUserRightsBean = (BLUserRightsBean) recordPrivilegeDetailsDataMap.get(i);
		            		switch(k)
		            		{
			            		case 6: 	BLUserRightsBean.setPrevilegeID(((String)values[i]));
	    									break;
				    			case 7: 	BLUserRightsBean.setPrevilegeDesc((String)values[i]);
											break;
				    			case 8: 	BLUserRightsBean.setAllowedYn((String)values[i]);
											break;
				    			case 9: 	BLUserRightsBean.setPolicyEffectiveFrom((String)values[i]);
											break;
				    			case 10: 	BLUserRightsBean.setEffectiveTo((String)values[i]);
											break;								
								default:	
		    				}
		            	}
		            	else
		            	{	
		            		BLUserRightsBean = new BLUserRightsBean();
		            		switch(k)
		            		{
			            		case 6: 	BLUserRightsBean.setPrevilegeID(((String)values[i]));
	    									break;
				    			case 7: 	BLUserRightsBean.setPrevilegeDesc((String)values[i]);
											break;
				    			case 8: 	BLUserRightsBean.setAllowedYn((String)values[i]);
											break;
				    			case 9: 	BLUserRightsBean.setPolicyEffectiveFrom((String)values[i]);
											break;
				    			case 10: 	BLUserRightsBean.setEffectiveTo((String)values[i]);
											break;		
								default:		
		    				}
		            		recordPrivilegeDetailsDataMap.put(i, BLUserRightsBean);
		            	}
		            }    
				}     
	        }
	}
		catch(Exception e){
			System.out.println("Exception in getPriceDetailsData in BLUserRightsBean=>>>>>>>><<<<<BEANNN>>>>> "+e); 
			e.printStackTrace();
			}
			finally
			{
				if(callableStatement!=null) callableStatement.close();
				if(connection!=null) ConnectionManager.returnConnection(connection);
				
			}

			return recordPrivilegeDetailsDataMap;
	}

		
	public HashMap populateFunctionTypeList(String facilityId, String locale)throws Exception
	{
		Connection 			connection 									= 	null;
		PreparedStatement 	preparedstatement 							= 	null;
		ResultSet 			resultSet									= 	null;
		StringBuffer 		sql											=	null;
		HashMap 			funcmap										=   new HashMap();
		ArrayList			functionTypeList							=   null;
		ArrayList			functionTypeDescList						=   null;
		String[]			arr											= 	null;
		String				blRepositoryKey								=	"FUNCTION_TYPE_DROPDOWN";

		try
		{
			System.out.println("In populateFunctionTypeList:::: ");
			connection = getConnection();
			functionTypeList = new ArrayList();
			functionTypeDescList = new ArrayList();
			sql	=	new StringBuffer();
			sql.append(BlRepository.getBlKeyValue(blRepositoryKey));
			System.out.println("SQL in populateFunctionTypeList:::: "+sql);
			preparedstatement=connection.prepareStatement(sql.toString());
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next())
			{
				functionTypeDescList.add(resultSet.getString(2));
				functionTypeList.add(resultSet.getString(1));
				funcmap.put("Desc", functionTypeDescList);
				funcmap.put("Id", functionTypeList);
			}
			setFunctionTypeList(functionTypeList);
			setFunctionTypeDescList(functionTypeDescList);
		}catch(Exception e){
			System.out.println("Exception in populateFunctionTypeList in BLUserRightsBean= "+e);
			e.printStackTrace();
			}
			finally
			{
				if(resultSet!=null) resultSet.close();
				if(preparedstatement!=null) preparedstatement.close();
				if(connection!=null) ConnectionManager.returnConnection(connection);

			}

			return funcmap;
	}
	public String populatePrevilegeList(String previlageID)throws Exception
	{
		Connection 			connection 									= 	null;
		PreparedStatement 	preparedstatement 							= 	null;
		ResultSet 			resultSet									= 	null;
		StringBuffer 		sql											=	null;
		HashMap 			presmap										=   new HashMap();
		ArrayList			previlegeTypeList							=   null;
		ArrayList			previlegeTypeDescList							=   null;
		String[]			arr											= 	null;
		String				blRepositoryKey								=	"PREVILEGE_TYPES_CHKBOX";
		String privilegeListDesc = null;

		try
		{
			System.out.println("In populatePrevilegeList:::: ");
			connection = getConnection();
			previlegeTypeList = new ArrayList();
			previlegeTypeDescList = new ArrayList();
			sql	=	new StringBuffer();
			sql.append(BlRepository.getBlKeyValue(blRepositoryKey));
			sql.append("where PRIVILEGE_CODE = '"+previlageID+"' ");
			System.out.println("SQL in populatePrevilegeTypeList:::: "+sql);
			preparedstatement=connection.prepareStatement(sql.toString());
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next())
			{
				privilegeListDesc = resultSet.getString(1);
			}
			
		}catch(Exception e){
			System.out.println("Exception in populatePrevilegeTypeList in BLUserRightsBean= "+e);
			e.printStackTrace();
			}
			finally
			{
				if(resultSet!=null) resultSet.close();
				if(preparedstatement!=null) preparedstatement.close();
				if(connection!=null) ConnectionManager.returnConnection(connection);

			}

			return privilegeListDesc;
	}
/*	public void getEpisodeAndVisitId(String patinetId,String EpisodeType,String facilityId, String locale)throws Exception
	{
		Connection 			connection 									= 	null;
		PreparedStatement 	preparedstatement 							= 	null;
		ResultSet 			resultSet									= 	null;
		StringBuffer 		sql											=	null;
		ArrayList			recordApprovalPatientdataList				=   null;
		String[]			arr											= 	null;
		String				blRepositoryKey								=	"";
		String 				visitId										=	"";
		String				episodeId									=	"";
		String				pId											=	"@patientId";
		String				fId											=	"@facilityId";
		String				eId											=	"@episodeId";
		String				vId											=	"@visitId";
		String				etId										=	"@episodeType";

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
			System.out.println("Exception in getEpisodeAndVisitId in BLUserRightsBean= "+e);
			e.printStackTrace();
			}
			finally
			{
				if(resultSet!=null) resultSet.close();
				if(preparedstatement!=null) preparedstatement.close();
				if(connection!=null) ConnectionManager.returnConnection(connection);

			}
	}*/

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
				System.out.println("Exception inSIDE BLOCK getRecordPreApprovalData in BLUserRightsBean= "+e);
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
			System.out.println("Exception in getRecordPreApprovalData in BLUserRightsBean= "+e);
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



	/*	public String[] getPatientNameAndMobile(String patinetId,String facilityId, String locale)throws Exception
	{
		Connection 			connection 									= 	null;
		PreparedStatement 	preparedstatement 							= 	null;
		ResultSet 			resultSet									= 	null;
		StringBuffer 		sql											=	null;
		ArrayList			recordApprovalPatientdataList				=   null;
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
			System.out.println("Exception in getPatientNameAndMobile in BLUserRightsBean= "+e);
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
		ArrayList			recordApprovalPatientdataList				=   null;
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
			System.out.println("Exception in getPatientAge in BLUserRightsBean= "+e);
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
		CallableStatement 	callableStatement 								= 	null;
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
			System.out.println("Exception in getPatientAge in BLUserRightsBean= "+e);
			e.printStackTrace();
			}
			finally
			{
				if(resultSet!=null) resultSet.close();
				if(preparedstatement!=null) preparedstatement.close();
				if(connection!=null) ConnectionManager.returnConnection(connection);

			}
		return patientName;
	}*/


	private String getDate(long timeStamp)
	{

	    try{
	        DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	        Date netDate = (new Date(timeStamp));
	        return sdf.format(netDate);
	    }
	    catch(Exception ex){
	    	System.out.println("Exception in getDate in BLUserRightsBean= "+ex);
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
