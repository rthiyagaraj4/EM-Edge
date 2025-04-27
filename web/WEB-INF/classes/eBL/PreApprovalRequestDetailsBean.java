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
2 			V201024             IN73702            NMC-JD-CRF-0042.1         			Shikha Seth
3			V220905\V220919		  33891       		TH-KW-CRF-0093                     Mohanapriya K
4			V221025				 					TH-KW-CRF-0020.7					Mohanapriya
-----------------------------------------------------------------------------------------------
*/
package eBL;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import webbeans.eCommon.ConnectionManager;
import eBL.Common.BlAdapter;
import eBL.Common.BlRepository;

@SuppressWarnings({ "rawtypes", "serial", "unchecked" })
public class PreApprovalRequestDetailsBean extends  BlAdapter implements Serializable{	
	
	protected String 		includedExcluded											= 	"";
	protected String 		billingServiceCode											= 	"";
	protected String 		billingServiceDisplay										= 	"";
	protected String 		billingServiceDesc											=	"";
	protected String 		serviceDate													=	"";
	protected String 		availableServiceAmount										=	"";
	protected String 		approvedData												=	"";
	protected String 		approvalNote												=	"";
	protected String 		status														=	"";
	protected String 		reason														=	"";
	protected String 		remarks														=	"";
	protected String 		patientClass												=	"";
	protected String 		episodeEncounterFlag										=	"";
	protected String 		clinicNursingIndicator										=	"";
	protected String 		clinicNursingCode											=	"";
	protected String 		specialiltyCode												=	"";
	protected String 		sex															=	"";
	protected String 		ageGroupCode												=	"";
	protected String 		effectiveFrom												=	"";
	protected String 		effectiveTo													=	"";
	protected String 		approvalAmountCapping										=	"";
	protected String 		approvalQuantityCapping										=	"";
	protected String 		approvalGrossNetAmount										=	"";
	protected String 		serviceLevelApprovalFlag									=	"";
	protected String 		approvalRequiredDate										=	"";
	protected String 		approvalGivenDate											=	"";
	protected String 		utilizedAmount												=	"";
	protected String 		utilizedQuantity											=	"";
	protected String 		primaryKeyFacilityId										=	"";
	protected String 		primaryKeyModuleId											=	"";
	protected String 		primaryKeyMain												=	"";
	protected String 		primaryKeyLineNo											=	"";
	protected String 		primaryKeyBillingServiceCode								=	"";
	protected String 		primaryKeyBillingServiceItemCode							=	"";
	protected String 		approvalNumber												=	"";
	protected String 		selectAll													=	"";
	protected String 		serviceQty													=	"";
	
	protected String 		approvedQty													=	"";
	protected String 		approvedAmount													=	"";
	protected String 		vEncounterId													=	"";
	protected String 		approvalDurationCapping										=	""; //Added V180725-Gayathri/MMS-DM-CRF-0126
	protected String 		approvedDurationQty										=	""; //Added V180725-Gayathri/MMS-DM-CRF-0126
	protected String 		McnNumber			=	""; //Added V220905
	protected String 		LocationCode			=	""; //Added V221025
	//102.2
	protected String requestID="";
	protected String currSrlno="";
	protected String seqno="";

	public String getRequestID() {
		return requestID;
	}
	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}
	public String getCurrSrlno() {
		return currSrlno;
	}
	public void setCurrSrlno(String currSrlno) {
		this.currSrlno = currSrlno;
	}
	public String getSeqno() {
		return seqno;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	//102.2 ends
	//V201024 start
		protected String		colorStatus					="";
		public String getColorStatus() {
			return colorStatus;
		}
		public void setColorStatus(String colorStatus) {
			this.colorStatus = colorStatus;
		}
		//V201024 end
	//V220905 starts
	public String getMcnNumber(){
		return McnNumber;
	}
	
	public void setMcnNumber(String McnNumber) {
		this.McnNumber = McnNumber;
	}//V220905 end
		
	//V221025 starts
	public String getLocationCode(){
		return LocationCode;
	}
	
	public void setLocationCode(String LocationCode) {
		this.LocationCode = LocationCode;
	}//V221025 end
		
	//Added V180725-Gayathri/MMS-DM-CRF-0126/Starts
	public String getApprovedDurationQty() {
		return approvedDurationQty;
	}

	public void setApprovedDurationQty(String approvedDurationQty) {
		this.approvedDurationQty = approvedDurationQty;
	}

	public String getApprovalDurationCapping() {
		return approvalDurationCapping;
	}

	public void setApprovalDurationCapping(String approvalDurationCapping) {
		this.approvalDurationCapping = approvalDurationCapping;
	}
//Added V180725-Gayathri/MMS-DM-CRF-0126/Ends
	public String getvEncounterId() {
		return vEncounterId;
	}

	public void setvEncounterId(String vEncounterId) {
		this.vEncounterId = vEncounterId;
	}

	public BigDecimal getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(BigDecimal encounterId) {
		this.encounterId = encounterId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	protected BigDecimal 		encounterId													=	new BigDecimal(0);
	protected String 		orderStatus													=	"";
	
  
	
	
	protected ArrayList		preApprovalRequestDetailsList								=	null;
	protected ArrayList		preApprovalRequestModalDetailsList							=	null;
	
	protected String billApprovedYN = "";
	private boolean extnIntEnable;
	
	
	public String getBillApprovedYN() {
		return billApprovedYN;
	}

	public void setBillApprovedYN(String billApprovedYN) {
		this.billApprovedYN = billApprovedYN;
	}

	/*public static final	String 	   OPERATING_FACILITY_ID								=  "OPERATING_FACILITY_ID";                   
	public static final	String 	   PATIENT_ID											=  "PATIENT_ID";                              
	public static final	String 	   EPISODE_TYPE											=  "EPISODE_TYPE";                            
	public static final	String 	   EPISODE_ID											=  "EPISODE_ID";                              
	public static final	String 	   VISIT_ID												=  "VISIT_ID";                                
	public static final	String 	   ENCOUNTER_ID											=  "ENCOUNTER_ID";                            
	public static final	String 	   POLICY_TYPE_CODE										=  "POLICY_TYPE_CODE";*/                        
	public static final	String 	   BLNG_SERV_CODE										=  "BLNG_SERV_CODE";                          
	/*public static final	String 	   PRE_APP_NUM											=  "PRE_APP_NUM";                             
	public static final	String 	   APP_REQ_DATE											=  "APP_REQ_DATE";                            
	public static final	String 	   APP_GIVEN_DATE										=  "APP_GIVEN_DATE";                          
	public static final	String 	   PRE_APP_STATUS										=  "PRE_APP_STATUS";                          
	public static final	String 	   PRE_APP_REMARK										=  "PRE_APP_REMARK";                          
	public static final	String 	   STATUS												=  "STATUS";                                  
	public static final	String 	   ACCT_SEQ_NO											=  "ACCT_SEQ_NO";                             
	public static final	String 	   CUST_CODE											=  "CUST_CODE";                               
	public static final	String 	   PRIORITY												=  "PRIORITY";                                
	public static final	String 	   SERV_EXCL_INCL_CRIT									=  "SERV_EXCL_INCL_CRIT";                     
	public static final	String 	   CUST_GROUP_CODE										=  "CUST_GROUP_CODE";                         
	public static final	String 	   BLNG_GRP_ID											=  "BLNG_GRP_ID";                             
	public static final	String 	   POLICY_NUMBER										=  "POLICY_NUMBER";                           
	public static final	String 	   EFFECTIVE_FROM										=  "EFFECTIVE_FROM";    
	public static final	String 	   AVAIL_SERV_AMT										=	"AVAIL_SERV_AMT";
	public static final	String 	   REASON_CODE											=	"REASON_CODE";
*/


	/**
	 * @return the includedExcluded
	 */
	public String getIncludedExcluded() {
		return includedExcluded;
	}

	/**
	 * @param includedExcluded the includedExcluded to set
	 */
	public void setIncludedExcluded(String includedExcluded) {
		this.includedExcluded = includedExcluded;
	}

	/**
	 * @return the billingServiceCode
	 */
	public String getBillingServiceCode() {
		return billingServiceCode;
	}

	/**
	 * @param billingServiceCode the billingServiceCode to set
	 */
	public void setBillingServiceCode(String billingServiceCode) {
		this.billingServiceCode = billingServiceCode;
	}

	
	/**
	 * @return the billingServiceDisplay
	 */
	public String getBillingServiceDisplay() {
		return billingServiceDisplay;
	}

	/**
	 * @param billingServiceDisplay the billingServiceDisplay to set
	 */
	public void setBillingServiceDisplay(String billingServiceDisplay) {
		this.billingServiceDisplay = billingServiceDisplay;
	}

	
	/**
	 * @return the billingServiceDesc
	 */
	public String getBillingServiceDesc() {
		return billingServiceDesc;
	}

	/**
	 * @param billingServiceDesc the billingServiceDesc to set
	 */
	public void setBillingServiceDesc(String billingServiceDesc) {
		this.billingServiceDesc = billingServiceDesc;
	}

	/**
	 * @return the serviceDate
	 */
	public String getServiceDate() {
		return serviceDate;
	}

	/**
	 * @param serviceDate the serviceDate to set
	 */
	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}

	/**
	 * @return the availableServiceAmount
	 */
	public String getAvailableServiceAmount() {
		return availableServiceAmount;
	}

	/**
	 * @param availableServiceAmount the availableServiceAmount to set
	 */
	public void setAvailableServiceAmount(String availableServiceAmount) {
		this.availableServiceAmount = availableServiceAmount;
	}

	/**
	 * @return the approvedData
	 */
	public String getApprovedData() {
		return approvedData;
	}

	/**
	 * @param approvedData the approvedData to set
	 */
	public void setApprovedData(String approvedData) {
		this.approvedData = approvedData;
	}

	
	
	/**
	 * @return the serviceQty
	 */
	public String getServiceQty() {
		return serviceQty;
	}

	/**
	 * @param serviceQty the serviceQty to set
	 */
	public void setServiceQty(String serviceQty) {
		this.serviceQty = serviceQty;
	}
	
	
	
	
	/**
	 * @return the approvalNote
	 */
	public String getApprovalNote() {
		return approvalNote;
	}

	/**
	 * @param approvalNote the approvalNote to set
	 */
	public void setApprovalNote(String approvalNote) {
		this.approvalNote = approvalNote;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the selectAll
	 */
	public String getSelectAll() {
		return selectAll;
	}

	/**
	 * @param selectAll the selectAll to set
	 */
	public void setSelectAll(String selectAll) {
		this.selectAll = selectAll;
	}

	/**
	 * @return the patientClass
	 */
	public String getPatientClass() {
		return patientClass;
	}

	/**
	 * @param patientClass the patientClass to set
	 */
	public void setPatientClass(String patientClass) {
		this.patientClass = patientClass;
	}

	/**
	 * @return the episodeEncounterFlag
	 */
	public String getEpisodeEncounterFlag() {
		return episodeEncounterFlag;
	}

	/**
	 * @param episodeEncounterFlag the episodeEncounterFlag to set
	 */
	public void setEpisodeEncounterFlag(String episodeEncounterFlag) {
		this.episodeEncounterFlag = episodeEncounterFlag;
	}

	/**
	 * @return the clinicNursingIndicator
	 */
	public String getClinicNursingIndicator() {
		return clinicNursingIndicator;
	}

	/**
	 * @param clinicNursingIndicator the clinicNursingIndicator to set
	 */
	public void setClinicNursingIndicator(String clinicNursingIndicator) {
		this.clinicNursingIndicator = clinicNursingIndicator;
	}

	/**
	 * @return the clinicNursingCode
	 */
	public String getClinicNursingCode() {
		return clinicNursingCode;
	}

	/**
	 * @param clinicNursingCode the clinicNursingCode to set
	 */
	public void setClinicNursingCode(String clinicNursingCode) {
		this.clinicNursingCode = clinicNursingCode;
	}

	/**
	 * @return the specialiltyCode
	 */
	public String getSpecialiltyCode() {
		return specialiltyCode;
	}

	/**
	 * @param specialiltyCode the specialiltyCode to set
	 */
	public void setSpecialiltyCode(String specialiltyCode) {
		this.specialiltyCode = specialiltyCode;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the ageGroupCode
	 */
	public String getAgeGroupCode() {
		return ageGroupCode;
	}

	/**
	 * @param ageGroupCode the ageGroupCode to set
	 */
	public void setAgeGroupCode(String ageGroupCode) {
		this.ageGroupCode = ageGroupCode;
	}

	/**
	 * @return the effectiveFrom
	 */
	public String getEffectiveFrom() {
		return effectiveFrom;
	}

	/**
	 * @param effectiveFrom the effectiveFrom to set
	 */
	public void setEffectiveFrom(String effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
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
	 * @return the approvalAmountCapping
	 */
	public String getApprovalAmountCapping() {
		return approvalAmountCapping;
	}

	/**
	 * @param approvalAmountCapping the approvalAmountCapping to set
	 */
	public void setApprovalAmountCapping(String approvalAmountCapping) {
		this.approvalAmountCapping = approvalAmountCapping;
	}

	/**
	 * @return the approvalQuantityCapping
	 */
	public String getApprovalQuantityCapping() {
		return approvalQuantityCapping;
	}

	/**
	 * @param approvalQuantityCapping the approvalQuantityCapping to set
	 */
	public void setApprovalQuantityCapping(String approvalQuantityCapping) {
		this.approvalQuantityCapping = approvalQuantityCapping;
	}

	/**
	 * @return the approvalGrossNetAmount
	 */
	public String getApprovalGrossNetAmount() {
		return approvalGrossNetAmount;
	}

	/**
	 * @param approvalGrossNetAmount the approvalGrossNetAmount to set
	 */
	public void setApprovalGrossNetAmount(String approvalGrossNetAmount) {
		this.approvalGrossNetAmount = approvalGrossNetAmount;
	}

	/**
	 * @return the serviceLevelApprovalFlag
	 */
	public String getServiceLevelApprovalFlag() {
		return serviceLevelApprovalFlag;
	}

	/**
	 * @param serviceLevelApprovalFlag the serviceLevelApprovalFlag to set
	 */
	public void setServiceLevelApprovalFlag(String serviceLevelApprovalFlag) {
		this.serviceLevelApprovalFlag = serviceLevelApprovalFlag;
	}

	/**
	 * @return the approvalRequiredDate
	 */
	public String getApprovalRequiredDate() {
		return approvalRequiredDate;
	}

	/**
	 * @param approvalRequiredDate the approvalRequiredDate to set
	 */
	public void setApprovalRequiredDate(String approvalRequiredDate) {
		this.approvalRequiredDate = approvalRequiredDate;
	}

	/**
	 * @return the approvalGivenDate
	 */
	public String getApprovalGivenDate() {
		
		return (approvalGivenDate != null?approvalGivenDate:"");
	}

	/**
	 * @param approvalGivenDate the approvalGivenDate to set
	 */
	public void setApprovalGivenDate(String approvalGivenDate) {
		this.approvalGivenDate = approvalGivenDate;
	}

	/**
	 * @return the utilizedAmount
	 */
	public String getUtilizedAmount() {
		return utilizedAmount;
	}

	/**
	 * @param utilizedAmount the utilizedAmount to set
	 */
	public void setUtilizedAmount(String utilizedAmount) {
		this.utilizedAmount = utilizedAmount;
	}

	/**
	 * @return the utilizedQuantity
	 */
	public String getUtilizedQuantity() {
		return utilizedQuantity;
	}

	/**
	 * @param utilizedQuantity the utilizedQuantity to set
	 */
	public void setUtilizedQuantity(String utilizedQuantity) {
		this.utilizedQuantity = utilizedQuantity;
	}

	/**
	 * @return the primaryKeyFacilityId
	 */
	public String getPrimaryKeyFacilityId() {
		return primaryKeyFacilityId;
	}

	/**
	 * @param primaryKeyFacilityId the primaryKeyFacilityId to set
	 */
	public void setPrimaryKeyFacilityId(String primaryKeyFacilityId) {
		this.primaryKeyFacilityId = primaryKeyFacilityId;
	}

	/**
	 * @return the primaryKeyModuleId
	 */
	public String getPrimaryKeyModuleId() {
		return primaryKeyModuleId;
	}

	/**
	 * @param primaryKeyModuleId the primaryKeyModuleId to set
	 */
	public void setPrimaryKeyModuleId(String primaryKeyModuleId) {
		this.primaryKeyModuleId = primaryKeyModuleId;
	}

	/**
	 * @return the primaryKeyMain
	 */
	public String getPrimaryKeyMain() {
		return primaryKeyMain;
	}

	/**
	 * @param primaryKeyMain the primaryKeyMain to set
	 */
	public void setPrimaryKeyMain(String primaryKeyMain) {
		this.primaryKeyMain = primaryKeyMain;
	}

	/**
	 * @return the primaryKeyLineNo
	 */
	public String getPrimaryKeyLineNo() {
		return primaryKeyLineNo;
	}

	/**
	 * @param primaryKeyLineNo the primaryKeyLineNo to set
	 */
	public void setPrimaryKeyLineNo(String primaryKeyLineNo) {
		this.primaryKeyLineNo = primaryKeyLineNo;
	}

	/**
	 * @return the primaryKeyBillingServiceCode
	 */
	public String getPrimaryKeyBillingServiceCode() {
		return primaryKeyBillingServiceCode;
	}

	/**
	 * @param primaryKeyBillingServiceCode the primaryKeyBillingServiceCode to set
	 */
	public void setPrimaryKeyBillingServiceCode(String primaryKeyBillingServiceCode) {
		this.primaryKeyBillingServiceCode = primaryKeyBillingServiceCode;
	}

	/**
	 * @return the primaryKeyBillingServiceItemCode
	 */
	public String getPrimaryKeyBillingServiceItemCode() {
		return primaryKeyBillingServiceItemCode;
	}

	/**
	 * @param primaryKeyBillingServiceItemCode the primaryKeyBillingServiceItemCode to set
	 */
	public void setPrimaryKeyBillingServiceItemCode(
			String primaryKeyBillingServiceItemCode) {
		this.primaryKeyBillingServiceItemCode = primaryKeyBillingServiceItemCode;
	}

	/**
	 * @return the approvalNumber
	 */
	public String getApprovalNumber() {
		return approvalNumber;
	}

	/**
	 * @param approvalNumber the approvalNumber to set
	 */
	public void setApprovalNumber(String approvalNumber) {
		this.approvalNumber = approvalNumber;
	}

	
	/**
	 * @return the approvedQuantity
	 */
	public String getApprovedQty() {
		return approvedQty;
	}

	/**
	 * @param approvaedQuantity the approvaedQuantity to set
	 */
	public void setApprovedQty(String approvedQty) {
		this.approvedQty = approvedQty;
	}
	
	
	/**
	 * @return the approvedAmount
	 */
	public String getApprovedAmount() {
		return approvedAmount;
	}

	/**
	 * @param approvaedQuantity the approvaedQuantity to set
	 */
	public void setApprovedAmount(String approvedAmount) {
		this.approvedAmount = approvedAmount;
	}
	
	
	
	
	
	/**
	 * @return the preApprovalRequestDetailsList
	 */
	public ArrayList getPreApprovalRequestDetailsList() {
		return preApprovalRequestDetailsList;
	}

	/**
	 * @param preApprovalRequestDetailsList the preApprovalRequestDetailsList to set
	 */
	public void setPreApprovalRequestDetailsList(
			ArrayList preApprovalRequestDetailsList) {
		this.preApprovalRequestDetailsList = preApprovalRequestDetailsList;
	}
	
	/**
	 * @return the preApprovalRequestModalDetailsList
	 */
	public ArrayList getPreApprovalRequestModalDetailsList() {
		return preApprovalRequestModalDetailsList;
	}

	/**
	 * @param preApprovalRequestModalDetailsList the preApprovalRequestModalDetailsList to set
	 */
	public void setPreApprovalRequestModalDetailsList(
			ArrayList preApprovalRequestModalDetailsList) {
		this.preApprovalRequestModalDetailsList = preApprovalRequestModalDetailsList;
	}
	
	


	
	
	
	
	
	
	/**
	 * clears the bean value
	 */
	public void clearBean()
	{
		includedExcluded											= 	"";                                                                     
		billingServiceCode											= 	"";                                                                     
		billingServiceDesc											=	"";                                                                     
		serviceDate													=	"";                                                             
		availableServiceAmount										=	"";                                                                             
		approvedData												=	"";                                                                     
		approvalNote												=	"";                                                                     
		status														=	"";                                                             
		reason														=	"";                                                             
		remarks														=	"";                                                             
		selectAll													=	"";  
		requestID="";
		currSrlno="";
		seqno="";
		                                                                                                                                                                                        
		preApprovalRequestDetailsList								=	null;                                                                                   
		preApprovalRequestModalDetailsList							=	null;                                                                                   
		                                                                                                                                                                                        


	}

	/*public ArrayList getPreApprovalRequestDetailsData(String patinetId,String EpisodeType,String episodeId,String visitId,String priority,String requestStatus,String acctSeqNo,String facilityId, String locale)throws Exception 
	{
		Connection 			connection 									= 	null;		
		PreparedStatement 	preparedstatement 							= 	null;
		ResultSet 			resultSet									= 	null;	
		StringBuffer 		sql											=	null;
		PreparedStatement 	preparedstatement1 							= 	null;
		ResultSet 			resultSet1									= 	null;	
		ArrayList			preApprovalRequestDetailsList				=   null;
		String[]			arr											= 	null;
		String				blRepositoryKey								=	"";
		String				pId											=	"@patientId";
		String				fId											=	"@facilityId";
		String				eId											=	"@episodeId";
		String				vId											=	"@visitId";
		String				etId										=	"@episodeType";
		String				pId1										=	"@patientId1";
		String				prId										=	"@priority";
		String				aId											=	"@acctSeqNo";
		String 				rSt											=	"@requestStatus";
	
		
		
		try
		{
			System.out.println("In getPreApprovalRequestDetailsData.:::: ");
			connection = getConnection();
			sql	=	new StringBuffer();	
			preApprovalRequestDetailsList = new ArrayList();
			blRepositoryKey = "PRE_APPROVAL_REQUEST_DETAILS";
			sql.append(BlRepository.getBlKeyValue(blRepositoryKey));
			
			sql.replace(sql.indexOf(pId),sql.indexOf(pId)+pId.length(),  patinetId);
			sql.replace(sql.indexOf(fId),sql.indexOf(fId)+fId.length(),  facilityId);
			sql.replace(sql.indexOf(etId),sql.indexOf(etId)+etId.length(),  EpisodeType);
			sql.replace(sql.indexOf(eId),sql.indexOf(eId)+eId.length(),  episodeId);
			sql.replace(sql.indexOf(vId),sql.indexOf(vId)+vId.length(),  visitId);
			sql.replace(sql.indexOf(prId),sql.indexOf(prId)+prId.length(),  priority);
			sql.replace(sql.indexOf(pId1),sql.indexOf(pId1)+pId1.length(),  patinetId);
			sql.replace(sql.indexOf(aId),sql.indexOf(aId)+aId.length(),  acctSeqNo);
			sql.replace(sql.indexOf(rSt),sql.indexOf(rSt)+rSt.length(),  requestStatus);
			System.out.println("SQL in getPreApprovalRequestDetailsData::::blRepositoryKey:::::: "+sql);
			preparedstatement=connection.prepareStatement(sql.toString());	
			resultSet = preparedstatement.executeQuery();
			java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd") ;
			while (resultSet.next())
			{
				arr 		= 	new String[15];
				arr[0]		=	resultSet.getString(SERV_EXCL_INCL_CRIT);
				arr[1]		=	resultSet.getString(BLNG_SERV_CODE);
				arr[2]		=	getBillingServiceDesc(resultSet.getString(BLNG_SERV_CODE),facilityId,locale);
				arr[3]		=	dateFormat.format(new java.util.Date());
				arr[4]		=	resultSet.getString(AVAIL_SERV_AMT);
				arr[5]		=	formatDate(resultSet.getString(APP_GIVEN_DATE));
				arr[6]		=	resultSet.getString(PRE_APP_NUM);
				arr[7]		=	resultSet.getString(PRE_APP_STATUS);
				arr[8]		=	resultSet.getString(REASON_CODE);
				arr[9]		=	resultSet.getString(PRE_APP_REMARK);
				arr[10]		=	formatDate(resultSet.getString(EFFECTIVE_FROM));
				arr[11]		=	formatDate(resultSet.getString(APP_REQ_DATE));
				arr[12]		=	resultSet.getString(BLNG_GRP_ID);
				arr[13]		=	resultSet.getString(STATUS);
				arr[14]		=	"modify";
				System.out.println("In getPreApprovalRequestDetailsData.:APP_GIVEN_DATE::: "+arr[5]	);
				System.out.println("In getPreApprovalRequestDetailsData.:EFFECTIVE_FROM::: "+arr[10]); 
				System.out.println("In getPreApprovalRequestDetailsData.:APP_REQ_DATE::::: "+arr[11]);
				
				preApprovalRequestDetailsList.add(arr);
			}
				System.out.println("recordApprovalPatientdataList SIZE:::::: "+preApprovalRequestDetailsList.size());
			
		}catch(Exception e){
			System.out.println("Exception in getPreApprovalRequestDetailsData in PreApprovalRequestDetailsBean= "+e); 
			e.printStackTrace();
			}
			finally
			{
				if(resultSet!=null) resultSet.close();
				if(preparedstatement!=null) preparedstatement.close();
				if(connection!=null) ConnectionManager.returnConnection(connection);
				
			}
		
		return preApprovalRequestDetailsList;
		
	}	*/

	/* Added 3 more parameters 'String servGrpCode, String servClsfctnCode, String orderStatus'/Added by Aravindh/11-04-2018/MMS-DM-CRF-0125 */
	public LinkedHashMap getPreApprovalRequestDetailsData(String patientId,String episodeType,String episodeId,String visitId,String priority,String requestStatus,String acctSeqNo,String facilityId, String locale,String payerGroupCode,String payerCode,String policyTypeCode,
														String criteriaFilter,String bg_code_filter,String serviceDate_filter,String serviceAmount_filter,String serviceQuantity_filter,String apprReqDate_filter,
														String apprGvnDate_filter,String apprNo_filter,String approval_status_filter,String apprQty_filter,String apprAmt_filter,String reason_hdn_filter,String remarks_filter, String encounterId,String encounterIdFilter,String orderStatusFilter, String servGrpCode, String servClsfctnCode, String orderStatus)throws Exception 
	{
		
		System.out.println("encounterId in bean ::: "+encounterId);
		
		Connection 								connection 							= 	null;		
		CallableStatement   					callableStatement					= 	null;
		PreApprovalRequestDetailsBean			preApprovalRequestDetailsBean		=	null;
		LinkedHashMap							preApprovalRequestDetailsDataMap	=	null;
		String									sql									=	null;
		Array									listArray							=	null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try
		{
			
		
			/*System.err.println("########  Record Approval  "+visitId);
			System.err.println("########  Record Approval  "+acctSeqNo);
			System.err.println("########  Record Approval  "+priority);
			*/

			System.out.println("In getRecordPreApprovalData:::: ");
			connection 							=	getConnection();
			try{
				this.extnIntEnable = eCommon.Common.CommonBean.isSiteSpecific(connection, "BL","REC_APPR_EXT_INT_ENABLED");
			 	System.out.println("extnIntEnable preapprovalrequestdeatilsbean>> "+extnIntEnable);//NMC-JD_CRF_102.2
			}catch (Exception e) {
				e.printStackTrace();
			}
			//102.2
			
			preApprovalRequestDetailsDataMap	=	new LinkedHashMap();
			sql									=	"{call  IBAEHIS.blinstransactions.get_enc_policy_serv_dtls_loc(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //V201013 modified //V220919-1param //V221025 //added 2 params for 102.2
			
			System.out.println("In get_enc_policy_serv_dtls_loc:::: ");
			callableStatement 					= 	connection.prepareCall(sql);
			callableStatement.setString(1,facilityId);
			callableStatement.setString(2,patientId);
			callableStatement.setString(3,episodeType);
			callableStatement.setString(4,episodeId);

			if (visitId.equals("null"))
			callableStatement.setString(5,null);
			else 
			callableStatement.setString(5,visitId);

//			callableStatement.setString(5,);
			//callableStatement.setInt(5,null);

			if(acctSeqNo.equals("null"))
			callableStatement.setString(6,null);
			else 
			callableStatement.setString(6,acctSeqNo);


			if (priority.equals("null"))
			callableStatement.setString(7,null);
			else 
			callableStatement.setString(7,priority);

		//	callableStatement.setString(6,acctSeqNo); 		
		//	callableStatement.setString(7,priority);   		
			callableStatement.setString(8,payerGroupCode); 
			callableStatement.setString(9,policyTypeCode);
			callableStatement.setString(10,payerCode);	      
			callableStatement.setString(11,requestStatus);	

			callableStatement.registerOutParameter(12, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10");  
			callableStatement.registerOutParameter(13, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR1"); 
			callableStatement.registerOutParameter(14, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR1"); 
			callableStatement.registerOutParameter(15, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			callableStatement.registerOutParameter(16, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			callableStatement.registerOutParameter(17, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR1"); 
			callableStatement.registerOutParameter(18, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			callableStatement.registerOutParameter(19, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			callableStatement.registerOutParameter(20, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); // YOUR ARRAY TYPE (TO MATCH THE API OUTPUT), NOT OBJECT 
			callableStatement.registerOutParameter(21, java.sql.Types.ARRAY, "BL_CMN_TYPE_DATE"); 
			callableStatement.registerOutParameter(22, java.sql.Types.ARRAY, "BL_CMN_TYPE_DATE"); 
			callableStatement.registerOutParameter(23, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER"); 
			callableStatement.registerOutParameter(24, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER"); 
			callableStatement.registerOutParameter(25, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR1"); 
			callableStatement.registerOutParameter(26, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR1"); 
		//	callableStatement.registerOutParameter(27, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER"); 
			callableStatement.registerOutParameter(27, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 		
			callableStatement.registerOutParameter(28, java.sql.Types.ARRAY, "BL_CMN_TYPE_DATE"); 
			callableStatement.registerOutParameter(29, java.sql.Types.ARRAY, "BL_CMN_TYPE_DATE"); 
			callableStatement.registerOutParameter(30, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR1");  
			callableStatement.registerOutParameter(31, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR4000"); 
			callableStatement.registerOutParameter(32, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			callableStatement.registerOutParameter(33, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER"); 
			callableStatement.registerOutParameter(34, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER"); 
			callableStatement.registerOutParameter(35, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			callableStatement.registerOutParameter(36, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			callableStatement.registerOutParameter(37, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			callableStatement.registerOutParameter(38, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER"); // YOUR ARRAY TYPE (TO MATCH THE API OUTPUT), NOT OBJECT 
			callableStatement.registerOutParameter(39, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			callableStatement.registerOutParameter(40, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			callableStatement.registerOutParameter(41, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			callableStatement.registerOutParameter(42, java.sql.Types.ARRAY, "BL_CMN_TYPE_DATE"); 
			callableStatement.registerOutParameter(43, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");
			callableStatement.registerOutParameter(44, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER"); 
			callableStatement.registerOutParameter(45, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER");
			callableStatement.registerOutParameter(46, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER");
			callableStatement.registerOutParameter(47, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR1");
			
			//New Params Add by Rajesh V
			callableStatement.setString(48,criteriaFilter);	
			callableStatement.setString(49,bg_code_filter);	
			
			if((serviceDate_filter == null) || ("".equals(serviceDate_filter)) ){
				callableStatement.setString(50,null);	
			}
			else{
				Date toDate = new Date(sdf.parse(serviceDate_filter).getTime());
				callableStatement.setDate(50, toDate);
			}
			
			callableStatement.setString(51,serviceAmount_filter);	
			callableStatement.setString(52,serviceQuantity_filter);	

			if((apprReqDate_filter == null) || ("".equals(apprReqDate_filter)) ){
				callableStatement.setString(53,null);	
			}
			else{
				Date toDate = new Date(sdf.parse(apprReqDate_filter).getTime());
				callableStatement.setDate(53, toDate);
			}

			if((apprGvnDate_filter == null) || ("".equals(apprGvnDate_filter)) ){
				callableStatement.setString(54,null);	
			}
			else{
				Date toDate = new Date(sdf.parse(apprGvnDate_filter).getTime());
				callableStatement.setDate(54, toDate);
			}
			callableStatement.setString(55,apprNo_filter);	
			callableStatement.setString(56,approval_status_filter);	
			callableStatement.setString(57,apprQty_filter);	
			callableStatement.setString(58,apprAmt_filter);	
			callableStatement.setString(59,reason_hdn_filter);	
			callableStatement.setString(60,remarks_filter);	
			 
//			/New Params Add by Rajesh V

			//New Params Add by Vijay A.P. for MMS CRF 0077
			
			callableStatement.setString(61,encounterId);	
			
			callableStatement.setString(62,encounterIdFilter);	
			callableStatement.setString(63,orderStatusFilter);	
			
			
			callableStatement.registerOutParameter(64, java.sql.Types.ARRAY, "BL_ENCOUNTER_ID");
			callableStatement.registerOutParameter(65, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10");
			
			/* Added V180521-Aravindh/MMS-DM-CRF-0125 */
			if(null != servGrpCode && "**".equals(servGrpCode)) {
				servGrpCode = ""; 
			}
			if(null != servClsfctnCode && "**".equals(servClsfctnCode)) {
				servClsfctnCode = "";
			}
			callableStatement.setString(66, servGrpCode);
			callableStatement.setString(67, servClsfctnCode);
			callableStatement.setString(68, orderStatus);
			
			callableStatement.registerOutParameter(69, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER");
			callableStatement.registerOutParameter(70, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER");
			//V201013 start
			callableStatement.setInt(71,0);
			callableStatement.setInt(72,0);
			callableStatement.setString(73,null);
			callableStatement.setString(74,null);
			callableStatement.setString(75,null);			
			callableStatement.registerOutParameter(76, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR1");//shikha
			//V201013 end
			System.out.println("In get_enc_policy_serv_dtls,1072:::: ");
			callableStatement.registerOutParameter(77, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");//V220919
			callableStatement.registerOutParameter(78, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10");//V221025
			System.out.println("before get_enc_policy_serv_dtls exec ");
			//102.2
			System.out.println("In get_enc_policy_serv_dtls,1100");
			callableStatement.registerOutParameter(79, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER");
			callableStatement.registerOutParameter(80, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER");
			System.out.println("before get_enc_policy_serv_dtls exec 1104");
			callableStatement.registerOutParameter(81, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER");
			//102.2
			callableStatement.execute(); 
			System.out.println("after get_enc_policy_serv_dtls:::: ");
			
			//for(int k=12;k<71;k++)
			//for(int k=12;k<77;k++) // V201013 modified
			//for(int k=12;k<78;k++) // V220919
			//for(int k=12;k<=78;k++)	//V221025
			for(int k=12;k<=81;k++)	//102.2
			{
			
			//	if (k>=71 && k<=76) continue; // V201013 added
				if (k>=71 && k<76) continue; // V201024 added
				//if (k>=71 && k<=76) continue;// V220919
				//if (k>=71 && k<=76) continue;// V221025
				if(k<48 || (k>63 && k<66)|| k>68)
				{
					System.out.println(" inside if k value "+ k);
				listArray = callableStatement.getArray (k); 
				System.out.println("listArray in getPreApprovalRequestDetailsData listArray :::"+listArray); 
	            Object[] values = (Object[]) listArray.getArray(); 
	            System.out.println("Values[] in getPreApprovalRequestDetailsData values Length:::::"+values.length+" ::: "+values); 
	            if(values!=null)
	            {
	            	for (int i=0; i < values.length; i++)                 
		            {
		            	System.out.println("Values in getPreApprovalRequestDetailsData for :::"+k+" :::: "+values[i]); 
		           
			            if(preApprovalRequestDetailsDataMap.containsKey(i))
		            	{
			            	preApprovalRequestDetailsBean = (PreApprovalRequestDetailsBean) preApprovalRequestDetailsDataMap.get(i);
			            	switch(k)
		            		{
			            		case 12: 	preApprovalRequestDetailsBean.setPatientClass(((String)values[i]));
	    									break;
				    			case 13: 	preApprovalRequestDetailsBean.setEpisodeEncounterFlag((String)values[i]);
											break;
				    			case 14: 	preApprovalRequestDetailsBean.setClinicNursingIndicator((String)values[i]);
											break;
				    			case 15: 	preApprovalRequestDetailsBean.setClinicNursingCode((String)values[i]);
											break;
				    			case 16: 	preApprovalRequestDetailsBean.setSpecialiltyCode((String)values[i]);
											break;
				    			case 17: 	preApprovalRequestDetailsBean.setSex(((String)values[i]));
											break;
				    			case 18: 	preApprovalRequestDetailsBean.setAgeGroupCode(((String)values[i]));
											break;
				    			case 19: 	preApprovalRequestDetailsBean.setBillingServiceCode(((String)values[i]));
											break;
				    			case 20: 	preApprovalRequestDetailsBean.setIncludedExcluded((String)values[i]);
											break;
				    			case 21: 	preApprovalRequestDetailsBean.setEffectiveFrom(formatDate(values[i]!=null ? String.valueOf(values[i]) : ""));
											break;
				    			case 22: 	preApprovalRequestDetailsBean.setEffectiveTo(formatDate(values[i]!=null ? String.valueOf(values[i]) : ""));
											break;
				    			case 23: 	preApprovalRequestDetailsBean.setApprovalAmountCapping(values[i]!=null ? String.valueOf(values[i]) : "");
											break;
				    			case 24: 	preApprovalRequestDetailsBean.setApprovalQuantityCapping(values[i]!=null ? String.valueOf(values[i]) : "");
											break;
				    			case 25: 	preApprovalRequestDetailsBean.setApprovalGrossNetAmount((String)values[i]);
											break;
				    			case 26: 	preApprovalRequestDetailsBean.setServiceLevelApprovalFlag((String)values[i]);
											break;
				    			case 27: 	preApprovalRequestDetailsBean.setApprovalNumber(values[i]!=null ? String.valueOf(values[i]) : "");
											break;
				    			case 28: 	preApprovalRequestDetailsBean.setApprovalRequiredDate(formatDate(values[i]!=null ? String.valueOf(values[i]) : ""));
											break;
				    			case 29: 	preApprovalRequestDetailsBean.setApprovalGivenDate(formatDate(values[i]!=null ? String.valueOf(values[i]) : ""));
											break;
				    			case 30: 	
											if(values[i]==null)  
											preApprovalRequestDetailsBean.setStatus("P");
											else 
											preApprovalRequestDetailsBean.setStatus((String)values[i]);

											break;
				    			case 31: 	preApprovalRequestDetailsBean.setRemarks((String)values[i]);
											break;
				    			case 32: 	preApprovalRequestDetailsBean.setReason((String)values[i]);
											break;
				    			case 33: 	preApprovalRequestDetailsBean.setUtilizedAmount(values[i]!=null ? String.valueOf(values[i]) : "");
											break;
				    			case 34: 	preApprovalRequestDetailsBean.setUtilizedQuantity(values[i]!=null ? String.valueOf(values[i]) : "");
											break;
				    			case 35: 	preApprovalRequestDetailsBean.setPrimaryKeyFacilityId((String)values[i]);
											break;
				    			case 36: 	preApprovalRequestDetailsBean.setPrimaryKeyModuleId((String)values[i]);
											break;
				    			case 37: 	preApprovalRequestDetailsBean.setPrimaryKeyMain((String)values[i]);
											break;
				    			case 38: 	preApprovalRequestDetailsBean.setPrimaryKeyLineNo(values[i]!=null ? String.valueOf(values[i]) : "");
											break;
				    			case 39: 	preApprovalRequestDetailsBean.setPrimaryKeyBillingServiceCode((String)values[i]);
											break;
				    			case 40: 	preApprovalRequestDetailsBean.setPrimaryKeyBillingServiceItemCode((String)values[i]);
											break;
				    			case 41: 	preApprovalRequestDetailsBean.setBillingServiceDesc((String)values[i]);
											break;
				    			case 42: 	preApprovalRequestDetailsBean.setServiceDate(formatDate(values[i]!=null ? String.valueOf(values[i]) : ""));
											break;
				    			case 43: 	preApprovalRequestDetailsBean.setBillingServiceDisplay(((String)values[i]));				    			
								break;				
				    			case 44: 	preApprovalRequestDetailsBean.setServiceQty(values[i]!=null ? String.valueOf(values[i]) : "");				    			
								break;
				    			case 45: 	preApprovalRequestDetailsBean.setApprovedQty(values[i]!=null ? String.valueOf(values[i]) : "");				    			
								break;
				    			case 46: 	preApprovalRequestDetailsBean.setApprovedAmount(values[i]!=null ? String.valueOf(values[i]) : "");				    			
								break;
				    			case 47: 	preApprovalRequestDetailsBean.setBillApprovedYN(values[i]!=null ? String.valueOf(values[i]) : "");				    			
											break;
				    			case 64:	preApprovalRequestDetailsBean.setEncounterId(((BigDecimal)values[i]));
											break;
				    			case 65:	preApprovalRequestDetailsBean.setOrderStatus(((String)values[i]));
				    						break;
											//Added V180725-Gayathri/MMS-DM-CRF-0126/Starts
				    			case 69:	preApprovalRequestDetailsBean.setApprovalDurationCapping(values[i]!=null ? String.valueOf(values[i]) : "");
	    						break;
	    						
				    			case 70:	preApprovalRequestDetailsBean.setApprovedDurationQty(values[i]!=null ? String.valueOf(values[i]) : "");
	    						break;
	    						//Added V180725-Gayathri/MMS-DM-CRF-0126/Ends
								// V201024 start
								case 76:	preApprovalRequestDetailsBean.setColorStatus(values[i]!=null ? String.valueOf(values[i]) : "");//shikha
									break;
								case 77:	preApprovalRequestDetailsBean.setMcnNumber(values[i]!=null ? String.valueOf(values[i]) : "");//V220919
									break;
								case 78:	preApprovalRequestDetailsBean.setLocationCode(values[i]!=null ? String.valueOf(values[i]) : "");//V221025
									break;
									//102.2
								case 79:	preApprovalRequestDetailsBean.setRequestID(values[i]!=null ? String.valueOf(values[i]) : "");
									break;
								case 80:	preApprovalRequestDetailsBean.setCurrSrlno(values[i]!=null ? String.valueOf(values[i]) : "");
									break;
								case 81:	preApprovalRequestDetailsBean.setSeqno(values[i]!=null ? String.valueOf(values[i]) : "");
								break;
							default:	
									
		    				}
		            	}
		            	else
		            	{	
		            		preApprovalRequestDetailsBean = new PreApprovalRequestDetailsBean();
		            		switch(k)
		            		{
			            		case 12: 	preApprovalRequestDetailsBean.setPatientClass(((String)values[i]));
	    									break;
				    			case 13: 	preApprovalRequestDetailsBean.setEpisodeEncounterFlag((String)values[i]);
											break;
				    			case 14: 	preApprovalRequestDetailsBean.setClinicNursingIndicator((String)values[i]);
											break;
				    			case 15: 	preApprovalRequestDetailsBean.setClinicNursingCode((String)values[i]);
											break;
				    			case 16: 	preApprovalRequestDetailsBean.setSpecialiltyCode((String)values[i]);
											break;
				    			case 17: 	preApprovalRequestDetailsBean.setSex(((String)values[i]));
											break;
				    			case 18: 	preApprovalRequestDetailsBean.setAgeGroupCode(((String)values[i]));
											break;
				    			case 19: 	preApprovalRequestDetailsBean.setBillingServiceCode(((String)values[i]));
											break;
				    			case 20: 	preApprovalRequestDetailsBean.setIncludedExcluded((String)values[i]);
											break;
				    			case 21: 	preApprovalRequestDetailsBean.setEffectiveFrom(formatDate(values[i]!=null ? String.valueOf(values[i]) : ""));
											break;
				    			case 22: 	preApprovalRequestDetailsBean.setEffectiveTo(formatDate(values[i]!=null ? String.valueOf(values[i]) : ""));
											break;
				    			case 23: 	preApprovalRequestDetailsBean.setApprovalAmountCapping(values[i]!=null ? String.valueOf(values[i]) : "");
											break;
				    			case 24: 	preApprovalRequestDetailsBean.setApprovalQuantityCapping(values[i]!=null ? String.valueOf(values[i]) : "");
											break;
				    			case 25: 	preApprovalRequestDetailsBean.setApprovalGrossNetAmount((String)values[i]); 
											break;
				    			case 26: 	preApprovalRequestDetailsBean.setServiceLevelApprovalFlag((String)values[i]);
											break;
				    			case 27: 	preApprovalRequestDetailsBean.setApprovalNumber(values[i]!=null ? String.valueOf(values[i]) : "");
											break;
				    			case 28: 	preApprovalRequestDetailsBean.setApprovalRequiredDate(formatDate(values[i]!=null ? String.valueOf(values[i]) : ""));
											break;
				    			case 29: 	preApprovalRequestDetailsBean.setApprovalGivenDate(formatDate(values[i]!=null ? String.valueOf(values[i]) : ""));
											break;
				    			case 30: 	preApprovalRequestDetailsBean.setStatus((String)values[i]);
											break;
				    			case 31: 	preApprovalRequestDetailsBean.setRemarks((String)values[i]);
											break;
				    			case 32: 	preApprovalRequestDetailsBean.setReason((String)values[i]);
											break;
				    			case 33: 	preApprovalRequestDetailsBean.setUtilizedAmount(values[i]!=null ? String.valueOf(values[i]) : "");
											break;
				    			case 34: 	preApprovalRequestDetailsBean.setUtilizedQuantity(values[i]!=null ? String.valueOf(values[i]) : "");
											break;
				    			case 35: 	preApprovalRequestDetailsBean.setPrimaryKeyFacilityId((String)values[i]);
											break;
				    			case 36: 	preApprovalRequestDetailsBean.setPrimaryKeyModuleId((String)values[i]);
											break;
				    			case 37: 	preApprovalRequestDetailsBean.setPrimaryKeyMain((String)values[i]);
											break;
				    			case 38: 	preApprovalRequestDetailsBean.setPrimaryKeyLineNo(values[i]!=null ? String.valueOf(values[i]) : "");
											break;
				    			case 39: 	preApprovalRequestDetailsBean.setPrimaryKeyBillingServiceCode((String)values[i]);
											break;
				    			case 40: 	preApprovalRequestDetailsBean.setPrimaryKeyBillingServiceItemCode((String)values[i]);
											break;
				    			case 41: 	preApprovalRequestDetailsBean.setBillingServiceDesc((String)values[i]);
											break;
				    			case 42: 	preApprovalRequestDetailsBean.setServiceDate(formatDate(values[i]!=null ? String.valueOf(values[i]) : ""));
											break;
				    			case 43: 	preApprovalRequestDetailsBean.setBillingServiceDisplay(((String)values[i]));
				    						break;		
				    			case 44: 	preApprovalRequestDetailsBean.setServiceQty(values[i]!=null ? String.valueOf(values[i]) : "");				    			
								break;
				    			case 45: 	preApprovalRequestDetailsBean.setApprovedQty(values[i]!=null ? String.valueOf(values[i]) : "");				    			
								break;
				    			case 46: 	preApprovalRequestDetailsBean.setApprovedAmount(values[i]!=null ? String.valueOf(values[i]) : "");				    			
								break;
				    			case 47: 	preApprovalRequestDetailsBean.setBillApprovedYN(values[i]!=null ? String.valueOf(values[i]) : "");				    			
											break;
				    			case 64:	preApprovalRequestDetailsBean.setEncounterId(((BigDecimal)values[i]));
											break;
				    			case 65:	preApprovalRequestDetailsBean.setOrderStatus(((String)values[i]));
				    						break;
				    						//Added V180725-Gayathri/MMS-DM-CRF-0126/Starts
				    			case 69:	preApprovalRequestDetailsBean.setApprovalDurationCapping(values[i]!=null ? String.valueOf(values[i]) : "");
	    						break;
	    						
				    			case 70:	preApprovalRequestDetailsBean.setApprovedDurationQty(values[i]!=null ? String.valueOf(values[i]) : "");
	    						break;
								//Added V180725-Gayathri/MMS-DM-CRF-0126/Ends			
								// V201024 start				    			
								case 76:	preApprovalRequestDetailsBean.setColorStatus(values[i]!=null ? String.valueOf(values[i]) : "");
									break;
								case 77:	preApprovalRequestDetailsBean.setMcnNumber(values[i]!=null ? String.valueOf(values[i]) : "");//V220919
									break;
	    						case 78:	preApprovalRequestDetailsBean.setLocationCode(values[i]!=null ? String.valueOf(values[i]) : "");//V221025
									break;
									//102.2
								case 79:	preApprovalRequestDetailsBean.setRequestID(values[i]!=null ? String.valueOf(values[i]) : "");
									break;
								case 80:	preApprovalRequestDetailsBean.setCurrSrlno(values[i]!=null ? String.valueOf(values[i]) : "");
									break;
								case 81:	preApprovalRequestDetailsBean.setSeqno(values[i]!=null ? String.valueOf(values[i]) : "");
								break;
	    						default:	
		    				}
		            		preApprovalRequestDetailsDataMap.put(i, preApprovalRequestDetailsBean);
		            	}
		            }    
				}     
	         }
			
			
				
			}
		}catch(Exception e){
			System.out.println("Exception in getPreApprovalRequestDetailsData in PreApprovalRequestDetailsBean= "+e); 
			e.printStackTrace();
			}
			finally
			{
				
				if(callableStatement!=null) callableStatement.close();
				if(connection!=null) ConnectionManager.returnConnection(connection);
				
			}
		
		return preApprovalRequestDetailsDataMap;
		
	}	
	
	public ArrayList getBillingServiceCodeForBillingGroupModal(String patinetId,String EpisodeType,String episodeId,String visitId,String priority,String acctSeqNo,String customerGroupCode,String customerCode,String policyTypeCode,String billingServiceCode,String facilityId, String locale)throws Exception 
	{
		Connection 			connection 									= 	null;		
		PreparedStatement 	preparedstatement 							= 	null;
		ResultSet 			resultSet									= 	null;	
		StringBuffer 		sql											=	null;
		/*PreparedStatement 	preparedstatement1 							= 	null;
		ResultSet 			resultSet1									= 	null;*/	
		ArrayList			billingServiceCodeList						=   null;
		String[]			arr											= 	null;
		String				blRepositoryKey								=	"";
		String				pId											=	"@patientId";
		String				fId											=	"@facilityId";
		String				eId											=	"@episodeId";
		/*String				vId											=	"@visitId";*/
		String				etId										=	"@episodeType";
		String				prId										=	"@priority";
		String				aId											=	"@acctSeqNo";
		String 				cGd											=	"@customerGroupCode";
		String 				cD											=	"@customerCode";
		String 				pTcd										=	"@policyTypeCode";
		String 				bScd										=	"@billingServiceCode";
	
		
		
		try
		{
			System.out.println("In getBillingServiceCodeForBillingGroupModal.:::: ");
			connection = getConnection();
			sql	=	new StringBuffer();	
			billingServiceCodeList = new ArrayList();
			blRepositoryKey = "RECORD_PREAPPROVAL_MODAL_WINDOW_QUERY";
			sql.append(BlRepository.getBlKeyValue(blRepositoryKey));
			
			sql.replace(sql.indexOf(pId),sql.indexOf(pId)+pId.length(),  patinetId);
			sql.replace(sql.indexOf(fId),sql.indexOf(fId)+fId.length(),  facilityId);
			sql.replace(sql.indexOf(etId),sql.indexOf(etId)+etId.length(),  EpisodeType);
			sql.replace(sql.indexOf(eId),sql.indexOf(eId)+eId.length(),  episodeId);
			sql.replace(sql.indexOf(prId),sql.indexOf(prId)+prId.length(),  priority);
			sql.replace(sql.indexOf(aId),sql.indexOf(aId)+aId.length(),  acctSeqNo);
			sql.replace(sql.indexOf(cGd),sql.indexOf(cGd)+cGd.length(),  customerGroupCode);
			sql.replace(sql.indexOf(cD),sql.indexOf(cD)+cD.length(),  customerCode);
			sql.replace(sql.indexOf(pTcd),sql.indexOf(pTcd)+pTcd.length(),  policyTypeCode);
			sql.replace(sql.indexOf(bScd),sql.indexOf(bScd)+bScd.length(),  billingServiceCode);
			System.out.println("SQL in getBillingServiceCodeForBillingGroupModal::::blRepositoryKey:::::: "+sql);
			preparedstatement=connection.prepareStatement(sql.toString());	
			resultSet = preparedstatement.executeQuery();
			/*java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd") ;*/
			while (resultSet.next())
			{
				arr 		= 	new String[3];
				arr[0]		=	resultSet.getString(1);
				arr[1]		=	getBillingServiceDesc(resultSet.getString(BLNG_SERV_CODE),facilityId,locale);
				arr[2]		=	"modify";
				System.out.println("In getBillingServiceCodeForBillingGroupModal.:BillingServiceCodeForBillingGroupModal::: "+arr[0]	);
				
				
				billingServiceCodeList.add(arr);
			}
				System.out.println("getBillingServiceCodeForBillingGroupModal SIZE:::::: "+billingServiceCodeList.size());
			
		}catch(Exception e){
			System.out.println("Exception in getBillingServiceCodeForBillingGroupModal in PreApprovalRequestDetailsBean= "+e); 
			e.printStackTrace();
			}
			finally
			{
				if(resultSet!=null) resultSet.close();
				if(preparedstatement!=null) preparedstatement.close();
				if(connection!=null) ConnectionManager.returnConnection(connection);
				
			}
		
		return billingServiceCodeList;
		
	}	
	
	
	
	public String getBillingServiceDesc(String billingServiceCode,String facilityId, String locale)throws Exception 
	{
		Connection 			connection 									= 	null;		
		PreparedStatement 	preparedstatement 							= 	null;
		ResultSet 			resultSet									= 	null;	
		StringBuffer 		sql											=	null;
		/*ArrayList			recordApprovalPatientdataList				=   null;*/
		String				billingServiceDescription					= 	null;
		String				blRepositoryKey								=	"";
		
		
		try
		{
			System.out.println("In getPatientAge:::: ");
			connection = getConnection();
			sql	=	new StringBuffer();	
			billingServiceDescription="";
			blRepositoryKey = "PRE_APPROVAL_REQUEST_BILLINGSERVICEDESC";
			sql.append(BlRepository.getBlKeyValue(blRepositoryKey));
			sql.append(" '"+locale+"' ");	
			sql.append(" AND BLNG_SERV_CODE =  '"+billingServiceCode+"' ");	
			System.out.println("SQL in getBillingServiceDesc::::blRepositoryKey:::::: "+sql);
			preparedstatement=connection.prepareStatement(sql.toString());	
			resultSet = preparedstatement.executeQuery();
			
			while (resultSet.next())
			{
				billingServiceDescription = resultSet.getString("SHORT_DESC");
				
			}
		}catch(Exception e){
			System.out.println("Exception in getBillingServiceDesc in RecordApprovalPatientDataBean= "+e); 
			e.printStackTrace();
			}
			finally
			{
				if(resultSet!=null) resultSet.close();
				if(preparedstatement!=null) preparedstatement.close();
				if(connection!=null) ConnectionManager.returnConnection(connection);
				
			}
		return billingServiceDescription;
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
