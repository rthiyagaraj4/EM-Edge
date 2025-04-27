/*<!--
Sr No        Version           TFS/Incident        SCF/CRF            		Developer Name
----------------------------------------------------------------------------------------------
1			 V210824			21883			MMS-ME-SCF-0031-TF			Mohana/MuthuN
2			 V211027			18595	      MMS-DM-CRF-0185			      Mohana Priya K
3			V211112							PMG2021-MMS-CRF-0004-TF-US001        Mohana Priya K
4			 V221017 						MMS-DM-CRF-0209 				Namrata C
----------------------------------------------------------------------------------------------
-->*/
package eBL;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import webbeans.eCommon.ConnectionManager;

import eBL.Common.BlAdapter;
import eBL.Common.BlRepository;

public class PolicyInsuranceMasterBean extends BlAdapter implements Serializable {

	private String facilityId;
	private String policyApplicability;
	private String payer;
	private String payerCode;
	private String policySettlementApplicability;
	private String payerGroup;
	private String payerGroupCode;
	private String screeningPolicy;
	private String GroupPolicy;	//Added against NMC-JD-CRF-0045
	private String referenceCode;//V211027
	private String startDate;
	private String endDate;
	private String policyType;
	private String policyTypeCode;
	

	private String coverageBasis;
	private String coverageRules;
	private String coveragePer;
	private String startDateChk;
	private String expiryDays;
	
	private String defInclExclCriteria;
	private String servInclExclCriteria;
	private String servCoverageLimitCriteria;
	private String overRideInclExcl;
	private String covInclOthPayers;
	private String lastPayer;
	
	private String creditAuthReq;
	private String creditAuthMand;
	private String creditAuthRef;
	private String covered;
	private String approvedDays;
	private String noOfDays;
	private String approvedAmt;
	private String limitAmt;
	private String coverageLimitType;
	private String mandChkBillGen;
	private String mandChkInvoiceGen;
	
	private String patClass;
	private String ageGroup;
	private String ageGroupDesc;


	private String gender;
	

	private String episodeEncounter;
	private String clinicNurs;
	private String clinicNursCode;
	private String clinicNursDesc;
	private String specCode;
	private String specDesc;
	private String inclExclCriteria;
	private String billServCode;
	private String billServDesc;
	private String billServChk;
	private String inclExclInd;
	private String grpServInd;
	private String inclExclIndChk;
	

	private String inclusionBasis;
	private String value;
	private String valueChk1;
	private String valueChk2;
	private String valueChk3;
	private String valueChk4;
	
	

	private String servItemQty;
	private String amtPerVisit;
	private String amtPerAdmn;
	private String amtPerIPDay;
	
	private String type;
	private String preApprAmtCapping;
	private String preApprQtyCapping;
	private String preApprDurCapping;//Added V180725-Gayathri/MMS-DM-CRF-0126
	//Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts
	private String preAcrossEnc;
	private String exlinclAcrossEnc;
	//Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends
	private String servLimit;
	private String Calledfrom; //004 changes
	
	private String exclude;
	private String status;
	private String delFlag;
	
	private String amtGrossNet;
	private String rowNumber;
	private String patCopay;
	private String patLimitAmt;
	
	private String acrossGroupId;
	
	private String splitReqd;
	private String encGrpIdSameEpsd;
	private String policyOrEncounter;
	private String oldEndDate;

	private String timeLimitValue;
	private String timeLimitType;
	private String effectiveDate = "";
	private String inclhomeMedi="";
	private String includeHomeMedication = "";
	
	private String coverRefPrice = "";//Added V181003-Aravindh/AAKH-CRF-0107/Getter Setter Pair
	private String policyApproved = "";//Added V190517-Aravindh/NMC-JD-CRF-0010/Getter Setter Pair
	private String authenticatedUser = "";//Added V190517-Aravindh/NMC-JD-CRF-0010/Getter Setter Pair
	private String claimsAgrmtExts ="";//Added V190701 MuthuN/NMC-JD-CRF-0002.1
	private String remarks="";//Added V200517 palaniNarayanan/NMC-JD-CRF-0010.1
	private String groupRservice="";// ADDED FOR MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020
	private String preAppgroupRservice="";// ADDED FOR MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020   //26-8-2020
	
	//Added for MOHE-CRF-0114
	private String diagCopayYN = "N";
	private String diagType = "";
	private String diagPatCopay = "";
	private String diagStartDate = "";
	private String diagEndDate = "";
	private String diagDelFlag = "";
	private String diagStatus = "";
	private String multiFactorDeductRuleYN = "N"; //V221017
	private String patLimitAmtMFDR = ""; //V221017
	private String multiFactorDeductRuleIPYN = "N"; //V230105
	
	public String getAuthenticatedUser() {
		return authenticatedUser;
	}
	public void setAuthenticatedUser(String authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}
	public String getPolicyApproved() {
		return policyApproved;
	}
	public void setPolicyApproved(String policyApproved) {
		this.policyApproved = policyApproved;
	}
	public String getCoverRefPrice() {
		return coverRefPrice;
	}
	public void setCoverRefPrice(String coverRefPrice) {
		this.coverRefPrice = coverRefPrice;
	}
	
	//Added V180725-Gayathri/MMS-DM-CRF-0126/Starts
	public String getPreApprDurCapping() {
		return preApprDurCapping;
	}
	public void setPreApprDurCapping(String preApprDurCapping) {
		this.preApprDurCapping = preApprDurCapping;
	}
	//Added V180725-Gayathri/MMS-DM-CRF-0126/Ends
	//Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts
	public String getPreacrossenc()
	{
		return preAcrossEnc;
	}
	public void setPreacrossenc(String preAcrossEnc) 
	{
		this.preAcrossEnc = preAcrossEnc;
	}
	public String getExlinclacrossenc()
	{
		return exlinclAcrossEnc;
	}
	public void setExlinclacrossenc(String exlinclAcrossEnc) 
	{
		this.exlinclAcrossEnc = exlinclAcrossEnc;
	}
	//Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends
	public String getIncludeHomeMedication() {
		return includeHomeMedication;
	}
	public void setIncludeHomeMedication(String includeHomeMedication) {
		this.includeHomeMedication = includeHomeMedication;
	}
	public String getInclhomeMedi() {
		return inclhomeMedi;
	}
	public void setInclhomeMedi(String inclhomeMedi) {
		this.inclhomeMedi = inclhomeMedi;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getTimeLimitValue() {
		return timeLimitValue;
	}
	public void setTimeLimitValue(String timeLimitValue) {
		this.timeLimitValue = timeLimitValue;
	}
	public String getTimeLimitType() {
		return timeLimitType;
	}
	public void setTimeLimitType(String timeLimitType) {
		this.timeLimitType = timeLimitType;
	}
	public String getOldEndDate() {
		return oldEndDate;
	}
	public void setOldEndDate(String oldEndDate) {
		this.oldEndDate = oldEndDate;
	}
	public String getEncGrpIdSameEpsd() {
		return encGrpIdSameEpsd;
	}
	public void setEncGrpIdSameEpsd(String encGrpIdSameEpsd) {
		this.encGrpIdSameEpsd = encGrpIdSameEpsd;
	}
	
	public String getSplitReqd() {
		return splitReqd;
	}
	public String getPolicyOrEncounter() {
		return policyOrEncounter;
	}
	public void setPolicyOrEncounter(String policyOrEncounter) {
		this.policyOrEncounter = policyOrEncounter;
	}
	public void setSplitReqd(String splitReqd) {
		this.splitReqd = splitReqd;
	}
	public String getAcrossGroupId() {
		return acrossGroupId;
	}
	public void setAcrossGroupId(String acrossGroupId) {
		this.acrossGroupId = acrossGroupId;
	}
	public String getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(String rowNumber) {
		this.rowNumber = rowNumber;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public String getAmtGrossNet() {
		return amtGrossNet;
	}
	public void setAmtGrossNet(String amtGrossNet) {
		this.amtGrossNet = amtGrossNet;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getPatCopay() {
		return patCopay;
	}
	public void setPatCopay(String patCopay) {
		this.patCopay = patCopay;
	}
	public String getPatLimitAmt() {
		return patLimitAmt;
	}
	public void setPatLimitAmt(String patLimitAmt) {
		this.patLimitAmt = patLimitAmt;
	}

	HashMap<String, List<PolicyInsuranceMasterBean>> policyMap = null;
	List<PolicyInsuranceMasterBean> policyList = null;
	
	List<PolicyInsuranceMasterBean> popupList = null;
	HashMap<String, List<PolicyInsuranceMasterBean>> popupMap = null;
	
	List<PolicyInsuranceMasterBean> diagPopupList = null;//Added for MOHE-CRF-0114
	HashMap<String, List<PolicyInsuranceMasterBean>> diagPopupMap = null;//Added for MOHE-CRF-0114	
	
	HashMap<String,PolicyInsuranceMasterBean> masterMap = null;
	
	HashMap<String,String> restrictionMap = null;
	
	public HashMap<String, String> getRestrictionMap() {
		return restrictionMap;
	}
	public void setRestrictionMap(HashMap<String, String> restrictionMap) {
		this.restrictionMap = restrictionMap;
	}
	public HashMap<String, PolicyInsuranceMasterBean> getMasterMap() {
		return masterMap;
	}
	public void setMasterMap(HashMap<String, PolicyInsuranceMasterBean> masterMap) {
		this.masterMap = masterMap;
	}
	
	public String getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}
	
	public List<PolicyInsuranceMasterBean> getPopupList() {
		return popupList;
	}
	public void setPopupList(List<PolicyInsuranceMasterBean> popupList) {
		this.popupList = popupList;
	}
	
	public HashMap<String, List<PolicyInsuranceMasterBean>> getPopupMap() {
		return popupMap;
	}
	public void setPopupMap(
			HashMap<String, List<PolicyInsuranceMasterBean>> popupMap) {
		this.popupMap = popupMap;
	}
	
	public String getPolicyApplicability() {
		return policyApplicability;
	}
	public void setPolicyApplicability(String policyApplicability) {
		this.policyApplicability = policyApplicability;
	}
	public String getPayer() {
		return payer;
	}
	public void setPayer(String payer) {
		this.payer = payer;
	}
	public String getPolicySettlementApplicability() {
		return policySettlementApplicability;
	}
	public void setPolicySettlementApplicability(
			String policySettlementApplicability) {
		this.policySettlementApplicability = policySettlementApplicability;
	}
	public String getPayerGroup() {
		return payerGroup;
	}
	public void setPayerGroup(String payerGroup) {
		this.payerGroup = payerGroup;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public String getScreeningPolicy() {
		return screeningPolicy;
	}
	public void setScreeningPolicy(String screeningPolicy) {
		this.screeningPolicy = screeningPolicy;
	}
	// Added against NMC-JD-CRF-0045
	public String getGroupPolicy() {
		return GroupPolicy;
	}
	public void setGroupPolicy(String GroupPolicy) {
		this.GroupPolicy = GroupPolicy;
	}  
	// Added against NMC-JD-CRF-0045
	// Added against V211027
	public String getPayerReferenceCode() {
		return referenceCode;
	}
	public void setPayerReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}  
	// Added against V211027
	
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public String getCoverageBasis() {
		return coverageBasis;
	}
	public void setCoverageBasis(String coverageBasis) {
		this.coverageBasis = coverageBasis;
	}
	public String getCoverageRules() {
		return coverageRules;
	}
	public void setCoverageRules(String coverageRules) {
		this.coverageRules = coverageRules;
	}
	public String getCoveragePer() {
		return coveragePer;
	}
	public void setCoveragePer(String coveragePer) {
		this.coveragePer = coveragePer;
	}
	public String getStartDateChk() {
		return startDateChk;
	}
	public void setStartDateChk(String startDateChk) {
		this.startDateChk = startDateChk;
	}
	public String getExpiryDays() {
		return expiryDays;
	}
	public void setExpiryDays(String expiryDays) {
		this.expiryDays = expiryDays;
	}
	public String getDefInclExclCriteria() {
		return defInclExclCriteria;
	}
	public void setDefInclExclCriteria(String defInclExclCriteria) {
		this.defInclExclCriteria = defInclExclCriteria;
	}
	public String getServInclExclCriteria() {
		return servInclExclCriteria;
	}
	public void setServInclExclCriteria(String servInclExclCriteria) {
		this.servInclExclCriteria = servInclExclCriteria;
	}
	public String getServCoverageLimitCriteria() {
		return servCoverageLimitCriteria;
	}
	public void setServCoverageLimitCriteria(String servCoverageLimitCriteria) {
		this.servCoverageLimitCriteria = servCoverageLimitCriteria;
	}
	public String getOverRideInclExcl() {
		return overRideInclExcl;
	}
	public void setOverRideInclExcl(String overRideInclExcl) {
		this.overRideInclExcl = overRideInclExcl;
	}
	public String getCovInclOthPayers() {
		return covInclOthPayers;
	}
	public void setCovInclOthPayers(String covInclOthPayers) {
		this.covInclOthPayers = covInclOthPayers;
	}
	public String getLastPayer() {
		return lastPayer;
	}
	public void setLastPayer(String lastPayer) {
		this.lastPayer = lastPayer;
	}
	public String getCreditAuthReq() {
		return creditAuthReq;
	}
	public void setCreditAuthReq(String creditAuthReq) {
		this.creditAuthReq = creditAuthReq;
	}
	public String getCreditAuthMand() {
		return creditAuthMand;
	}
	public void setCreditAuthMand(String creditAuthMand) {
		this.creditAuthMand = creditAuthMand;
	}
	public String getCreditAuthRef() {
		return creditAuthRef;
	}
	public void setCreditAuthRef(String creditAuthRef) {
		this.creditAuthRef = creditAuthRef;
	}
	public String getCovered() {
		return covered;
	}
	public void setCovered(String covered) {
		this.covered = covered;
	}
	public String getApprovedDays() {
		return approvedDays;
	}
	public void setApprovedDays(String approvedDays) {
		this.approvedDays = approvedDays;
	}
	public String getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}
	public String getApprovedAmt() {
		return approvedAmt;
	}
	public void setApprovedAmt(String approvedAmt) {
		this.approvedAmt = approvedAmt;
	}
	public String getLimitAmt() {
		return limitAmt;
	}
	public void setLimitAmt(String limitAmt) {
		this.limitAmt = limitAmt;
	}
	public String getCoverageLimitType() {
		return coverageLimitType;
	}
	public void setCoverageLimitType(String coverageLimitType) {
		this.coverageLimitType = coverageLimitType;
	}
	public String getMandChkBillGen() {
		return mandChkBillGen;
	}
	public void setMandChkBillGen(String mandChkBillGen) {
		this.mandChkBillGen = mandChkBillGen;
	}
	public String getMandChkInvoiceGen() {
		return mandChkInvoiceGen;
	}
	public void setMandChkInvoiceGen(String mandChkInvoiceGen) {
		this.mandChkInvoiceGen = mandChkInvoiceGen;
	}
	public String getPatClass() {
		return patClass;
	}
	public void setPatClass(String patClass) {
		this.patClass = patClass;
	}
	
	public String getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}
	
	public String getAgeGroupDesc() {
		return ageGroupDesc;
	}
	public void setAgeGroupDesc(String ageGroupDesc) {
		this.ageGroupDesc = ageGroupDesc;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEpisodeEncounter() {
		return episodeEncounter;
	}
	public void setEpisodeEncounter(String episodeEncounter) {
		this.episodeEncounter = episodeEncounter;
	}
	public String getClinicNurs() {
		return clinicNurs;
	}
	public void setClinicNurs(String clinicNurs) {
		this.clinicNurs = clinicNurs;
	}
	public String getClinicNursCode() {
		return clinicNursCode;
	}
	public void setClinicNursCode(String clinicNursCode) {
		this.clinicNursCode = clinicNursCode;
	}
	public String getClinicNursDesc() {
		return clinicNursDesc;
	}
	public void setClinicNursDesc(String clinicNursDesc) {
		this.clinicNursDesc = clinicNursDesc;
	}
	public String getSpecCode() {
		return specCode;
	}
	public void setSpecCode(String specCode) {
		this.specCode = specCode;
	}
	public String getSpecDesc() {
		return specDesc;
	}
	public void setSpecDesc(String specDesc) {
		this.specDesc = specDesc;
	}
	public String getInclExclCriteria() {
		return inclExclCriteria;
	}
	public void setInclExclCriteria(String inclExclCriteria) {
		this.inclExclCriteria = inclExclCriteria;
	}
	public String getBillServCode() {
		return billServCode;
	}
	public void setBillServCode(String billServCode) {
		this.billServCode = billServCode;
	}
	public String getBillServDesc() {
		return billServDesc;
	}
	public void setBillServDesc(String billServDesc) {
		this.billServDesc = billServDesc;
	}
	public String getBillServChk() {
		return billServChk;
	}
	public void setBillServChk(String billServChk) {
		this.billServChk = billServChk;
	}
	public String getInclExclInd() {
		return inclExclInd;
	}
	public void setInclExclInd(String inclExclInd) {
		this.inclExclInd = inclExclInd;
	}
	public String getGroupServInd() {
		return grpServInd;
	}
	public void setGroupServInd(String grpServInd) {
		this.grpServInd = grpServInd;
	}
	
	public String getInclExclIndChk() {
		return inclExclIndChk;
	}
	public void setInclExclIndChk(String inclExclIndChk) {
		this.inclExclIndChk = inclExclIndChk;
	}
	public String getInclusionBasis() {
		return inclusionBasis;
	}
	public void setInclusionBasis(String inclusionBasis) {
		this.inclusionBasis = inclusionBasis;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getValueChk1() {
		return valueChk1;
	}
	public void setValueChk1(String valueChk1) {
		this.valueChk1 = valueChk1;
	}
	public String getValueChk2() {
		return valueChk2;
	}
	public void setValueChk2(String valueChk2) {
		this.valueChk2 = valueChk2;
	}
	public String getValueChk3() {
		return valueChk3;
	}
	public void setValueChk3(String valueChk3) {
		this.valueChk3 = valueChk3;
	}
	public String getValueChk4() {
		return valueChk4;
	}
	public void setValueChk4(String valueChk4) {
		this.valueChk4 = valueChk4;
	}
	public String getServItemQty() {
		return servItemQty;
	}
	public void setServItemQty(String servItemQty) {
		this.servItemQty = servItemQty;
	}
	public String getAmtPerVisit() {
		return amtPerVisit;
	}
	public void setAmtPerVisit(String amtPerVisit) {
		this.amtPerVisit = amtPerVisit;
	}
	public String getAmtPerAdmn() {
		return amtPerAdmn;
	}
	public void setAmtPerAdmn(String amtPerAdmn) {
		this.amtPerAdmn = amtPerAdmn;
	}
	public String getAmtPerIPDay() {
		return amtPerIPDay;
	}
	public void setAmtPerIPDay(String amtPerIPDay) {
		this.amtPerIPDay = amtPerIPDay;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPreApprAmtCapping() {
		return preApprAmtCapping;
	}
	public void setPreApprAmtCapping(String preApprAmtCapping) {
		this.preApprAmtCapping = preApprAmtCapping;
	}
	public String getPreApprQtyCapping() {
		return preApprQtyCapping;
	}
	public void setPreApprQtyCapping(String preApprQtyCapping) {
		this.preApprQtyCapping = preApprQtyCapping;
	}
	public String getServLimit() {
		return servLimit;
	}
	public void setServLimit(String servLimit) {
		this.servLimit = servLimit;
	}
	public String getExclude() {
		return exclude;
	}
	public void setExclude(String exclude) {
		this.exclude = exclude;
	}
	
	public String getPolicyTypeCode() {
		return policyTypeCode;
	}
	public void setPolicyTypeCode(String policyTypeCode) {
		this.policyTypeCode = policyTypeCode;
	}
	public String getPayerCode() {
		return payerCode;
	}
	public void setPayerCode(String payerCode) {
		this.payerCode = payerCode;
	}
	public String getPayerGroupCode() {
		return payerGroupCode;
	}
	public void setPayerGroupCode(String payerGroupCode) {
		this.payerGroupCode = payerGroupCode;
	}

	public HashMap<String, List<PolicyInsuranceMasterBean>> getPolicyMap() {
		return policyMap;
	}
	public void setPolicyMap(HashMap<String, List<PolicyInsuranceMasterBean>> policyMap) {
		this.policyMap = policyMap;
	}
	public List<PolicyInsuranceMasterBean> getPolicyList() {
		return policyList;
	}
	public void setPolicyList(List<PolicyInsuranceMasterBean> policyList) {
		this.policyList = policyList;
	}

	//Added V190701 MuthuN/NMC-JD-CRF-0002.1
	public String getclaimsAgrmtExts() {
			return claimsAgrmtExts;
	}
	public void setclaimsAgrmtExts(
		String claimsAgrmtExts) {
		
			this.claimsAgrmtExts = claimsAgrmtExts;
	}
	
	//Added V190701 MuthuN/NMC-JD-CRF-0002.1
	// Added V200517 palaniNarayanan/NMC-JD-CRF-0010.1
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
		
	}
	// ADDED FOR MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 STRATS-->
	public String getGroupRservice() {
		return groupRservice;
	}
	public void setGroupRservice(String groupRservice) {
		this.groupRservice = groupRservice;
	}
	//26-8-2020 START
	public String getpreAppGroupRservice() {
		return preAppgroupRservice;
	}
	public void setpreAppGroupRservice(String preAppgroupRservice) {
		this.preAppgroupRservice = preAppgroupRservice;
	}
	//26-8-2020 END
	// ADDED FOR MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 ENDS-->
	
	//V211103
	public String getCalledfrom() {
		return Calledfrom;
	}
	public void setCalledfrom(String Calledfrom) {
		this.Calledfrom = Calledfrom;
	}
	//V211112
	public String getpayerfrom() {
		return payer;
	}
	public void setpayerfrom(String payer) {
		this.payer = payer;
	}
	
	// Added for MOHE-CRF-0114 Starts
	public String getDiagCopaySetup() {
		return diagCopayYN;
	}
	
	public void setDiagCopaySetup(String diagCopayYN) {
		this.diagCopayYN = diagCopayYN;
	}
	
	public void setDiagType(String diagType) {
		this.diagType = diagType;
	}

	public String getDiagType() {
		return diagType;
	}	
	
	public String getDiagPatCopay() {
		return diagPatCopay;
	}
	
	public void setDiagPatCopay(String diagPatCopay) {
		this.diagPatCopay = diagPatCopay;
	}	
	
	public String getDiagStartDate() {
		return diagStartDate;
	}
	
	public void setDiagStartDate(String diagStartDate) {
		this.diagStartDate = diagStartDate;
	}
	
	public String getDiagEndDate() {
		return diagEndDate;
	}
	
	public void setDiagEndDate(String diagEndDate) {
		this.diagEndDate = diagEndDate;
	}

	public String getDiagDelFlag() {
		return diagDelFlag;
	}
	
	public void setDiagDelFlag(String diagDelFlag) {
		this.diagDelFlag = diagDelFlag;
	}	
	
	public String getDiagStatus() {
		return diagStatus;
	}
	
	public void setDiagStatus(String diagStatus) {
		this.diagStatus = diagStatus;
	}

	public List<PolicyInsuranceMasterBean> getDiagPopupList() {
		return diagPopupList;
	}
	public void setDiagPopupList(List<PolicyInsuranceMasterBean> diagPopupList) {
		this.diagPopupList = diagPopupList;
	}
	
	public HashMap<String, List<PolicyInsuranceMasterBean>> getDiagPopupMap() {
		return diagPopupMap;
	}
	public void setDiagPopupMap(
			HashMap<String, List<PolicyInsuranceMasterBean>> diagPopupMap) {
		this.diagPopupMap = diagPopupMap;
	}
	// Added for MOHE-CRF-0114 Ends
	
	//V221017 starts
	public String getMultiFactorDeductRuleYN() {
		return multiFactorDeductRuleYN ;
	}
	public void setMultiFactorDeductRuleYN(String multiFactorDeductRuleYN ) {
		this.multiFactorDeductRuleYN  = multiFactorDeductRuleYN ;
	}
	
	public String getMFDRPatLimitAmt() {
		return patLimitAmtMFDR  ;
	}
	public void setMFDRPatLimitAmt(String patLimitAmtMFDR  ) {
		this.patLimitAmtMFDR   = patLimitAmtMFDR  ;
	}
	//V221017 ends
	
	//V230105 starts
	public String getMultiFactorDeductRuleIPYN() {
		return multiFactorDeductRuleIPYN ;
	}
	public void setMultiFactorDeductRuleIPYN(String multiFactorDeductRuleIPYN ) {
		this.multiFactorDeductRuleIPYN  = multiFactorDeductRuleIPYN ;
	}	
	
	public void clearAll(){
		policyMap = null;
		popupMap = null;
		policyList = null;
		popupList = null;
		masterMap = null;
		restrictionMap = null;
		facilityId = null;
		policyApplicability = null;
		payer = null;
		payerCode = null;
		policySettlementApplicability = null;
		payerGroup = null;
		payerGroupCode = null;
		
		startDate = null;
		endDate = null;
		policyType = null;
		policyTypeCode= null;
		
		coverageBasis = null;
		coverageRules = null;
		coveragePer = null;
		startDateChk = null;
		expiryDays = null;
		
		defInclExclCriteria = null;
		servInclExclCriteria = null;
		servCoverageLimitCriteria = null;
		overRideInclExcl = null;
		covInclOthPayers = null;
		lastPayer = null;
		
		creditAuthReq = null;
		creditAuthMand = null;
		creditAuthRef = null;
		covered = null;
		approvedDays = null;
		noOfDays = null;
		approvedAmt = null;
		limitAmt = null;
		coverageLimitType = null;
		mandChkBillGen = null;
		mandChkInvoiceGen = null;
		
		patClass = null;
		episodeEncounter = null;
		clinicNurs = null;
		clinicNursCode = null;
		clinicNursDesc = null;
		specCode = null;
		specDesc = null;
		inclExclCriteria = null;
		billServCode = null;
		billServDesc = null;
		billServChk = null;
		inclExclInd = null;
		grpServInd = null;
		inclExclIndChk = null;
		
		inclusionBasis = null;
		value = null;
		valueChk1 = null;
		valueChk2 = null;
		valueChk3 = null;
		valueChk4 = null;
		
		servItemQty = null;
		amtPerVisit = null;
		amtPerAdmn = null;
		amtPerIPDay = null;
		
		type = null;
		preApprAmtCapping = null;
		preApprQtyCapping = null;
		preApprDurCapping = null;
		preAcrossEnc = null;//Added V190326-Dhananjay/MMS-DM-CRF-0158
		exlinclAcrossEnc   = null;//Added V190326-Dhananjay/MMS-DM-CRF-0158
		servLimit = null;
		
		exclude = null;
		status = null;
		delFlag = null;
		amtGrossNet = null;
		rowNumber = null;
		patCopay = null;
		patLimitAmt = null;
		
		acrossGroupId = null;
		splitReqd = null;
		encGrpIdSameEpsd = null;
		policyOrEncounter = null;
		oldEndDate = null;
		
		timeLimitValue = null;
		timeLimitType = null;
		effectiveDate = "";
		coverRefPrice = null;//Added V181003-Aravindh/AAKH-CRF-0107
		policyApproved = null;//Added V190517-Aravindh/NMC-JD-CRF-0010
		claimsAgrmtExts= null;//Added V190701 MuthuN/NMC-JD-CRF-0002.1
		groupRservice=null;// ADDED FOR MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020
		preAppgroupRservice=null;  //26-8-2020
		
		// Added for MOHE-CRF-0114 starts
		diagCopayYN = null;
		diagPopupList = null;
		diagPopupMap = null;
		diagType = null;
		diagPatCopay = null;
		diagStartDate = null;
		diagEndDate = null;
		diagDelFlag = null;
		diagStatus = null;
		
		// Added for MOHE-CRF-0114 ends
		
		multiFactorDeductRuleYN = null;  //V221017
		patLimitAmtMFDR  = null;  //V221017
		multiFactorDeductRuleIPYN = null; 
		
	}
	
	public  PolicyInsuranceMasterBean getPolicyDefinitionDetials(String facility_id,String payerGroup,String payer, String policy,String locale){
		//System.err.println("Getting the Bean from PolicyDefinitionMasterBean - PDMB");
		PolicyInsuranceMasterBean bean = new PolicyInsuranceMasterBean();
		PolicyInsuranceMasterBean fmtDtlsBean = new PolicyInsuranceMasterBean();
		//PolicyInsuranceMasterBean fmtDtlsBean1 = new PolicyInsuranceMasterBean(); -->commented against checkstyle
		HashMap<String, List<PolicyInsuranceMasterBean>> polMap = null;
		List<PolicyInsuranceMasterBean> polList = null;	
		//List<PolicyInsuranceMasterBean> popList = null; -->commented against checkstyle
		HashMap<String, List<PolicyInsuranceMasterBean>> popMap = null;
		int cnt = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		PreparedStatement pstmt2 = null;
		ResultSet rst2 = null;
		
		
		try{
			String sqlInfoPage = "";
			System.err.println("Getting Header " +bean.getCalledfrom());
			if(bean.getCalledfrom()!=null && bean.getCalledfrom()=="infoframe"){
				System.err.println("Getting infoframe Header ");
				sqlInfoPage =  BlRepository.getBlKeyValue("POLICY_DEF_HDR_INFO");
			}
			else{
				System.err.println("Getting else Header ");
				sqlInfoPage =  BlRepository.getBlKeyValue("POLICY_DEFN_HDR_INFO");
			}//V211103
			//String sqlInfoPage =  BlRepository.getBlKeyValue("POLICY_DEF_HDR_INFO"); //V211103
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(sqlInfoPage);
			//V210824
			pstmt.setString(1,payer);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,payerGroup);
			pstmt.setString(4,payer);
			pstmt.setString(5,policy);
			//V210824
			rst = pstmt.executeQuery();
			System.err.println(" Getting Header POLICY_DEF_HDR_INFO aftr,913");
			//System.err.println("PolicyInsuranceMaseterBean#########1"+facility_id+"   "+payerGroup+"  "+payer+"  "+policy);
			
			//Header
			System.err.println("PDMB - Getting Header " +bean.getCalledfrom());
			//System.err.println("PDMB - HDR sql->"+sqlInfoPage);
			//System.err.println("PDMB - params->"+facility_id+"-"+payerGroup+"-"+payer+"-"+policy);
			if(rst != null){
				while(rst.next()){
					//System.err.println ("PolicyInsuranceMaseterBean#########POLICY_DEF_HDR_INFO");
					//System.err.println("PDMB - Going in RST");
					bean.setPayerGroup(rst.getString("payer_group"));
					bean.setPayerGroupCode(rst.getString("CUST_GROUP_CODE"));
					bean.setPayer(rst.getString("payer"));
					bean.setPayerCode(rst.getString("CUST_CODE"));
					bean.setPolicyType(rst.getString("policy_type"));
					//V211123
					bean.setpayerfrom(payer);
					System.err.println("PDMB - Getting Header getpayerfrom::" +bean.getpayerfrom()); //V211112
					//V211123
					bean.setPolicyTypeCode(rst.getString("POLICY_TYPE_CODE"));
					bean.setCoverageBasis(rst.getString("policy_coverage_basis"));
					bean.setCoverageRules(rst.getString("payer_cov_rule"));
					bean.setCoveragePer(rst.getString("copay_perc"));
					bean.setStartDateChk(rst.getString("def_req_policy_dates"));
					bean.setExpiryDays(rst.getString("addl_days_policy_expdt"));
					bean.setFacilityId(rst.getString("operating_facility_id"));
					bean.setPolicySettlementApplicability(rst.getString("slmt_appl_yn"));
					bean.setStartDate(rst.getString("effective_from"));
					bean.setEndDate(rst.getString("effective_to"));
					bean.setScreeningPolicy(rst.getString("screening_policy_yn"));
					bean.setFacilityId(facility_id);
					bean.setCoverRefPrice(rst.getString("cover_ref_price"));//Added V181003-Aravindh/AAKh-CRF-0107
					bean.setPolicyApproved(rst.getString("policy_approved_yn"));//Added V190517-Aravindh/NMC-JD-CRF-0010
					bean.setclaimsAgrmtExts(rst.getString("clms_agrmt_exts"));//Added V190701 MuthuN/NMC-JD-CRF-0002.1
					//Added against NMC-JD-CRF-0045
					bean.setGroupPolicy(rst.getString("group_policy_yn"));
					bean.setPayerReferenceCode(rst.getString("payer_ref_code"));//V211027
				}
			}

			pstmt = null;
			rst = null;
			//Header
			//Service Coverage		
		//	System.err.println("PDMB - Getting Service Coverage"+bean.getCalledfrom());
			if(bean.getCalledfrom()!=null && bean.getCalledfrom()=="infoframe"){
				System.err.println("inforframess");
				sqlInfoPage = BlRepository.getBlKeyValue("POLICY_DEF_SERVICE_INFO");
			}else{
				System.err.println("POLICY_DEFN_SERVICE_INFO");
				sqlInfoPage = BlRepository.getBlKeyValue("POLICY_DEFN_SERVICE_INFO");
			}
		//	sqlInfoPage = BlRepository.getBlKeyValue("POLICY_DEF_SERVICE_INFO");
			pstmt = con.prepareStatement(sqlInfoPage);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			System.err.println(" POLICY_DEF_SERVICE_INFO,965");
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					bean.setDefInclExclCriteria(rst.getString("excl_incl_ind"));
					bean.setOverRideInclExcl(rst.getString("ovride_incl_excl_unsp_serv_yn"));
					bean.setCovInclOthPayers(rst.getString("cumm_cvrg_with_oth_payers_yn"));
					bean.setLastPayer(rst.getString("last_payer_coverage_yn"));
					
				}
			}
			pstmt = null;
			rst = null;
			//Service Coverage	
			polList = new ArrayList<PolicyInsuranceMasterBean>();
			polMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
			//Service Coverage	Tab - Outpatient
			String sqlCoverage ="";
			if(bean.getCalledfrom()!=null && bean.getCalledfrom()=="infoframe"){
				System.err.println("inforframes 1005");
				sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_OUTPAT_INFO");
			}else{
				System.err.println("POLICY_DEFN_OUTPAT_INFO 1005");
				sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEFN_OUTPAT_INFO");
			}
			pstmt = con.prepareStatement(sqlCoverage);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			rst = pstmt.executeQuery();

			cnt = 0;
			if(rst!=null){
				while (rst.next()) {
					fmtDtlsBean = new PolicyInsuranceMasterBean();
					fmtDtlsBean.setCreditAuthReq(rst.getString("credit_req"));
					fmtDtlsBean.setCreditAuthMand(rst.getString("credit_mand"));
					fmtDtlsBean.setCreditAuthRef(rst.getString("credit_ref"));
					fmtDtlsBean.setCovered(rst.getString("covered"));
					fmtDtlsBean.setCoverageLimitType(rst.getString("limit_type"));
					fmtDtlsBean.setApprovedDays(rst.getString("day_limit_type"));
					fmtDtlsBean.setNoOfDays(rst.getString("np_of_days"));
					fmtDtlsBean.setApprovedAmt(rst.getString("amt_limit_type"));
					fmtDtlsBean.setLimitAmt(rst.getString("amt_limit"));
					fmtDtlsBean.setMandChkBillGen(rst.getString("mand_bill"));
					fmtDtlsBean.setMandChkInvoiceGen(rst.getString("mand_inv"));
					fmtDtlsBean.setAmtGrossNet(rst.getString("amt_gross_net"));
					fmtDtlsBean.setPolicyApplicability(rst.getString("across_encounter"));
					fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
					fmtDtlsBean.setPatLimitAmt(rst.getString("patient_limit_amount"));
					polList.add(fmtDtlsBean);
					cnt++;
				}
				if(cnt>0){
					polMap.put("Outpatient", polList);
				}
				else{
					PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
					polList.add(titleBean);
					polMap.put("Outpatient", polList); 
				}
			}
			else{
				PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
				polList.add(titleBean);
				polMap.put("Outpatient", polList);
			}	
			//Service Coverage	Tab	- Outpatient	
			pstmt = null;
			rst = null;			
			polList = new ArrayList<PolicyInsuranceMasterBean>();
			//Service Coverage	Tab	- Inpatient	
			if(bean.getCalledfrom()!=null && bean.getCalledfrom()=="infoframe"){
				System.err.println("inforframess ip");
				sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_INPAT_INFO");
			}else{
				System.err.println("bean ip");
				sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEFN_INPAT_INFO");
			}
			//sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_INPAT_INFO");
			pstmt = con.prepareStatement(sqlCoverage);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			rst = pstmt.executeQuery();
			cnt = 0;
			if(rst!=null){
				while (rst.next()) {
					fmtDtlsBean = new PolicyInsuranceMasterBean();
					fmtDtlsBean.setCreditAuthReq(rst.getString("credit_req"));
					fmtDtlsBean.setCreditAuthMand(rst.getString("credit_mand"));
					fmtDtlsBean.setCreditAuthRef(rst.getString("credit_ref"));
					fmtDtlsBean.setCovered(rst.getString("covered"));
					fmtDtlsBean.setCoverageLimitType(rst.getString("limit_type"));
					fmtDtlsBean.setApprovedDays(rst.getString("day_limit_type"));
					fmtDtlsBean.setNoOfDays(rst.getString("np_of_days"));
					fmtDtlsBean.setApprovedAmt(rst.getString("amt_limit_type"));
					fmtDtlsBean.setLimitAmt(rst.getString("amt_limit"));
					fmtDtlsBean.setMandChkBillGen(rst.getString("mand_bill"));
					fmtDtlsBean.setMandChkInvoiceGen(rst.getString("mand_inv"));
					fmtDtlsBean.setAmtGrossNet(rst.getString("amt_gross_net"));
					fmtDtlsBean.setPolicyApplicability(rst.getString("across_encounter"));
					fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
					fmtDtlsBean.setPatLimitAmt(rst.getString("patient_limit_amount"));
					polList.add(fmtDtlsBean);
					cnt++;
				}
				if(cnt>0){
					polMap.put("Inpatient", polList);
				}
				else{
					PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
					polList.add(titleBean);
					polMap.put("Inpatient", polList); 
				}
			}
			else{
				PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
				polList.add(titleBean);
				polMap.put("Inpatient", polList);
			}	
			//Service Coverage	Tab	- Inpatient	
			pstmt = null;
			rst = null;			
			polList = new ArrayList<PolicyInsuranceMasterBean>();
			//Service Coverage	Tab	- External	
			if(bean.getCalledfrom()!=null && bean.getCalledfrom()=="infoframe"){
				System.err.println("inforframess ex");
				sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_EXTERNAL_INFO");
			}else{
				System.err.println("info ex");
				sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEFN_EXTERNAL_INFO");
			}
			//sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_EXTERNAL_INFO");
			pstmt = con.prepareStatement(sqlCoverage);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			rst = pstmt.executeQuery();
			cnt = 0;
			if(rst!=null){
				while (rst.next()) {
					//System.err.println("PDMB - Going in RST");
					fmtDtlsBean = new PolicyInsuranceMasterBean();
					fmtDtlsBean.setCreditAuthReq(rst.getString("credit_req"));
					fmtDtlsBean.setCreditAuthMand(rst.getString("credit_mand"));
					fmtDtlsBean.setCreditAuthRef(rst.getString("credit_ref"));
					fmtDtlsBean.setCovered(rst.getString("covered"));
					fmtDtlsBean.setCoverageLimitType(rst.getString("limit_type"));
					fmtDtlsBean.setApprovedDays(rst.getString("day_limit_type"));
					fmtDtlsBean.setNoOfDays(rst.getString("np_of_days"));
					fmtDtlsBean.setApprovedAmt(rst.getString("amt_limit_type"));
					fmtDtlsBean.setLimitAmt(rst.getString("amt_limit"));
					fmtDtlsBean.setMandChkBillGen(rst.getString("mand_bill"));
					fmtDtlsBean.setMandChkInvoiceGen(rst.getString("mand_inv"));
					fmtDtlsBean.setAmtGrossNet(rst.getString("amt_gross_net"));
					fmtDtlsBean.setPolicyApplicability(rst.getString("across_encounter"));
					fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
					fmtDtlsBean.setPatLimitAmt(rst.getString("patient_limit_amount"));
					polList.add(fmtDtlsBean);
					cnt++;
				}
				if(cnt>0){
					polMap.put("External", polList);
				}
				else{
					PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
					polList.add(titleBean);
					polMap.put("External", polList); 
				}
			}
			else{
				PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
				polList.add(titleBean);
				polMap.put("External", polList);
			}	
			//System.err.println("PDMB - Processed External Pat");
			//Service Coverage	Tab	- External	
			pstmt = null;
			rst = null;			
			/*polList = new ArrayList<PolicyInsuranceMasterBean>();
			popMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
			// Incl/Excl Coverage Detials
			sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_INCL_EXCL_DTL");


			pstmt = con.prepareStatement(sqlCoverage);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,facility_id);
			pstmt.setString(6,payerGroup);
			pstmt.setString(7,payer);
			pstmt.setString(8,policy);
			pstmt.setString(9,facility_id);
			pstmt.setString(10,payerGroup);
			pstmt.setString(11,payer);
			pstmt.setString(12,policy);
			rst = pstmt.executeQuery();
			//System.err.println("PDMB - Getting Incl Excl Coverage");
			//System.err.println("PDMB - Incl Excl Coverage sql->"+sqlCoverage);
			//System.err.println("PDMB - params->"+locale+"-"+locale+"-"+locale+"-"+locale+"-"+facility_id+"-"+payerGroup+"-"+payer+"-"+policy+"-"+facility_id+"-"+payerGroup+"-"+payer+"-"+policy);
			if(rst!=null){
				int rsCnt = 0;
				while (rst.next()) {
					fmtDtlsBean = new PolicyInsuranceMasterBean();
					rsCnt++;
					//System.err.println("PDMB - Going in RST for Incl Excl Coverage ->"+rsCnt);
					fmtDtlsBean.setPatClass(rst.getString("patient_class"));
					fmtDtlsBean.setAgeGroup(rst.getString("AGE_GROUP_CODE"));
					fmtDtlsBean.setAgeGroupDesc(rst.getString("age_group_desc"));
					fmtDtlsBean.setGender(rst.getString("SEX"));
					fmtDtlsBean.setEpisodeEncounter(rst.getString("episode_or_encounter_flag"));
					fmtDtlsBean.setClinicNurs(rst.getString("clinic_nursing_ind"));
					fmtDtlsBean.setClinicNursCode(rst.getString("clinic_nursing_code"));
					fmtDtlsBean.setClinicNursDesc(rst.getString("clinic_nursing_desc"));
					fmtDtlsBean.setSpecCode(rst.getString("splty_code"));
					fmtDtlsBean.setSpecDesc(rst.getString("spec_desc"));
					fmtDtlsBean.setInclExclCriteria(rst.getString("serv_excl_incl_crit"));
					fmtDtlsBean.setBillServCode(rst.getString("blng_serv_code"));
					fmtDtlsBean.setBillServDesc(rst.getString("blng_serv_desc"));
					fmtDtlsBean.setBillServChk(rst.getString("special_service_yn"));
					fmtDtlsBean.setInclExclInd(rst.getString("excl_incl_ind"));
					fmtDtlsBean.setInclExclIndChk(rst.getString("ovride_incl_excl_yn"));
					fmtDtlsBean.setInclusionBasis(rst.getString("copay_ind"));
					fmtDtlsBean.setAmtGrossNet(rst.getString("per_day_amt_limit_gross_net"));
					fmtDtlsBean.setDelFlag("N");
					fmtDtlsBean.setRowNumber(new Integer(rsCnt).toString());
					if(Integer.parseInt(rst.getString("total"))>0){
						fmtDtlsBean.setServLimit("Y");
						pstmt2 = null;
						rst2 = null;
						// Exclusion Popup
						popList = new ArrayList<PolicyInsuranceMasterBean>();
						String sqlCoveragePop = BlRepository.getBlKeyValue("POLICY_DEF_EXCLUSION_POPUP");


						pstmt2 = con.prepareStatement(sqlCoveragePop);
						pstmt2.setString(1,locale);
						pstmt2.setString(2,facility_id);
						pstmt2.setString(3,payerGroup);
						pstmt2.setString(4,payer);
						pstmt2.setString(5,policy);
						pstmt2.setString(6,fmtDtlsBean.getInclExclCriteria());
						pstmt2.setString(7,fmtDtlsBean.getBillServCode());
						pstmt2.setString(8,fmtDtlsBean.getPatClass());
						
						pstmt2.setString(9,fmtDtlsBean.getEpisodeEncounter());
						pstmt2.setString(10,fmtDtlsBean.getGender());
						pstmt2.setString(11,fmtDtlsBean.getAgeGroup());
						pstmt2.setString(12,fmtDtlsBean.getClinicNurs());
						pstmt2.setString(13,fmtDtlsBean.getClinicNursCode());
						pstmt2.setString(14,fmtDtlsBean.getSpecCode());
						pstmt2.setString(15,fmtDtlsBean.getStartDate());
						rst2 = pstmt2.executeQuery();
						//System.err.println("PDMB - Getting Exclusion");
						//System.err.println("PDMB - Exclusion sql->"+sqlCoveragePop);
						//System.err.println("PDMB - params->"+locale+"-"+facility_id+"-"+payerGroup+"-"+payer+"-"+policy+"-"+fmtDtlsBean.getInclExclCriteria()+"-"+fmtDtlsBean.getBillServCode()+"-"+fmtDtlsBean.getPatClass());
						if(rst2!=null){
							int rsCntP = 0;
							while (rst2.next()) {
								fmtDtlsBean1 = new PolicyInsuranceMasterBean();

								fmtDtlsBean1.setInclExclCriteria(rst2.getString("excl_serv_excl_incl_crit"));
								fmtDtlsBean1.setBillServCode(rst2.getString("excl_blng_serv_code"));
								fmtDtlsBean1.setBillServDesc(rst2.getString("blng_serv_desc"));
								fmtDtlsBean1.setInclExclInd(rst2.getString("excl_incl_ind"));
								fmtDtlsBean1.setInclusionBasis(rst2.getString("copay_ind"));
								fmtDtlsBean1.setValue(rst2.getString("copay_val"));
								fmtDtlsBean1.setServItemQty(rst2.getString("qty_capping"));
								fmtDtlsBean1.setAmtPerVisit(rst2.getString("amount_capping"));
								fmtDtlsBean1.setAmtPerIPDay(rst2.getString("per_day_amount_limit"));
								fmtDtlsBean1.setNoOfDays(rst2.getString("no_of_days_limit"));
								fmtDtlsBean1.setStartDate(rst2.getString("effective_from"));
								fmtDtlsBean1.setEndDate(rst2.getString("effective_to"));
								fmtDtlsBean1.setAmtGrossNet(rst2.getString("per_day_amt_limit_gross_net"));
								fmtDtlsBean1.setPatCopay(rst2.getString("patient_copay"));
								fmtDtlsBean1.setPatLimitAmt(rst2.getString("patient_amount_limit"));
								fmtDtlsBean1.setStatus("I");
								fmtDtlsBean1.setDelFlag("N");
								popList.add(fmtDtlsBean1);
								rsCntP++;
								//System.err.println("PDMB - Going in RST for Exclusion ->"+rsCntP);
							}
							
							if(rsCntP>0){
								popMap.put(fmtDtlsBean.getRowNumber(), popList);
							}
							else{
								PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
								titleBean.setStartDate(fmtDtlsBean.getStartDate());
								titleBean.setEndDate(fmtDtlsBean.getEndDate());
								popList.add(titleBean);
								popMap.put(fmtDtlsBean.getRowNumber(), popList);
							}
						}
						else{
							PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
							titleBean.setStartDate(fmtDtlsBean.getStartDate());
							titleBean.setEndDate(fmtDtlsBean.getEndDate());
							popList.add(titleBean);
							popMap.put(fmtDtlsBean.getRowNumber(), popList);
						}		
						// Exclusion Popup
						//System.err.println("PDMB - Processed Exclusion");
					}
					else{
						fmtDtlsBean.setServLimit("N");
					}
					fmtDtlsBean.setValue(rst.getString("copay_val"));
					fmtDtlsBean.setValueChk1(rst.getString("include_policy_level_copay_yn"));
					fmtDtlsBean.setValueChk2(rst.getString("pre_approval_yn"));
					fmtDtlsBean.setValueChk3(rst.getString("cumm_cvrg_with_oth_payers_yn"));
					fmtDtlsBean.setValueChk4(rst.getString("last_payer_coverage_yn"));
					fmtDtlsBean.setServItemQty(rst.getString("qty_capping"));
					fmtDtlsBean.setAmtPerVisit(rst.getString("amount_capping"));
					fmtDtlsBean.setAmtPerIPDay(rst.getString("per_day_amount_limit"));
					fmtDtlsBean.setNoOfDays(rst.getString("no_of_days_limit"));
					fmtDtlsBean.setStartDate(rst.getString("effective_from"));
					fmtDtlsBean.setEndDate(rst.getString("effective_to"));
					fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
					fmtDtlsBean.setPatLimitAmt(rst.getString("patient_amount_limit"));
					fmtDtlsBean.setStatus("I");
					polList.add(fmtDtlsBean);
					
				}
				
				if(rsCnt>0){
					polMap.put("inclExclCoverage", polList);
				}
				else{
					PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
					polList.add(titleBean);
					polMap.put("inclExclCoverage", polList);
				}
			}
			else{
				PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
				polList.add(titleBean);
				polMap.put("inclExclCoverage", polList);
			}	
			// Incl/Excl Coverage Detials
			//System.err.println("PDMB - Processed Incl Excl Coverage");
			pstmt = null;
			rst = null;			
			polList = new ArrayList<PolicyInsuranceMasterBean>();
			// Pre Approval Detials
			sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_PREAPPROVAL_DTL");


			pstmt = con.prepareStatement(sqlCoverage);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,facility_id);
			pstmt.setString(6,payerGroup);
			pstmt.setString(7,payer);
			pstmt.setString(8,policy);
			rst = pstmt.executeQuery();
			//System.err.println("PDMB - Getting PreApproval");
			//System.err.println("PDMB - Exclusion sql->"+sqlCoverage);
			//System.err.println("PDMB - params->"+locale+"-"+locale+"-"+locale+"-"+locale+"-"+facility_id+"-"+payerGroup+"-"+payer+"-"+policy);
			if(rst!=null){
				int rsCnt = 0;
				while (rst.next()) {
					fmtDtlsBean = new PolicyInsuranceMasterBean();
					fmtDtlsBean.setPatClass(rst.getString("patient_class"));
					fmtDtlsBean.setAgeGroup(rst.getString("AGE_GROUP_CODE"));
					fmtDtlsBean.setAgeGroupDesc(rst.getString("age_group_desc"));
					fmtDtlsBean.setGender(rst.getString("SEX"));
					fmtDtlsBean.setEpisodeEncounter(rst.getString("episode_or_encounter_flag"));
					fmtDtlsBean.setClinicNurs(rst.getString("clinic_nursing_ind"));
					fmtDtlsBean.setClinicNursCode(rst.getString("clinic_nursing_code"));
					fmtDtlsBean.setClinicNursDesc(rst.getString("clinic_nursing_desc"));
					fmtDtlsBean.setSpecCode(rst.getString("splty_code"));
					fmtDtlsBean.setSpecDesc(rst.getString("spec_desc"));
					fmtDtlsBean.setType(rst.getString("serv_excl_incl_crit"));
					fmtDtlsBean.setBillServCode(rst.getString("blng_serv_code"));
					fmtDtlsBean.setBillServDesc(rst.getString("blng_serv_desc"));
					fmtDtlsBean.setPreApprAmtCapping(rst.getString("preapproval_amt_capping"));
					fmtDtlsBean.setPreApprQtyCapping(rst.getString("preapproval_qty_capping"));
					fmtDtlsBean.setServLimit(rst.getString("service_level_approval_yn"));
					fmtDtlsBean.setStartDate(rst.getString("effective_from"));
					fmtDtlsBean.setEndDate(rst.getString("effective_to"));
					fmtDtlsBean.setAmtGrossNet(rst.getString("preapproval_amt_gross_net"));
					fmtDtlsBean.setStatus("I");
					fmtDtlsBean.setDelFlag("N");
					polList.add(fmtDtlsBean);
					rsCnt++;	
					//System.err.println("PDMB - Going in RST for Exclusion ->"+rsCnt);
				}
				if(rsCnt>0){
					polMap.put("preApproval", polList);
				}
				else{
					PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
					titleBean.setStartDate(bean.getStartDate());
					titleBean.setEndDate(bean.getEndDate());
					polList.add(titleBean);
					polMap.put("preApproval", polList);
				}
			}
			else{
				PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
				titleBean.setStartDate(bean.getStartDate());
				titleBean.setEndDate(bean.getEndDate());
				polList.add(titleBean);
				polMap.put("preApproval", polList);
			}		
			// Pre Approval Detials
			//System.err.println("PDMB - Processed PreApproval");
			 */
			bean.setPolicyOrEncounter("");
			bean.setPolicyMap(polMap);
			bean.setPopupMap(popMap);
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception In get Policy Bean Details 1365 :::"+e);
		}
		finally{
			ConnectionManager.returnConnection(con);
			rst = null;
			rst2 = null;
			pstmt = null;
			pstmt2 = null;
		}
		return bean;
	}
	
	public  PolicyInsuranceMasterBean getEncounterSpecificDetials(String facility_id,String payerGroup,
			String payer, String policy,String patientId,String episodeType,String episodeId,String visitId,
			String acctSeq,String priority,String policyNo,String locale){
		
		PolicyInsuranceMasterBean bean = new PolicyInsuranceMasterBean();
		PolicyInsuranceMasterBean fmtDtlsBean = new PolicyInsuranceMasterBean();
		PolicyInsuranceMasterBean fmtDtlsBean1 = new PolicyInsuranceMasterBean();
		HashMap<String, List<PolicyInsuranceMasterBean>> polMap = null;
		List<PolicyInsuranceMasterBean> polList = null;	
		List<PolicyInsuranceMasterBean> popList = null;
		HashMap<String, List<PolicyInsuranceMasterBean>> popMap = null;
		//int cnt = 0; --> commented against checkstyle
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		PreparedStatement pstmt2 = null;
		ResultSet rst2 = null;
		
		try{
			String sqlInfoPage =  "";
			String partSql = "";
			//String partExclSql = ""; --> commented against checkstyle. 
			String sqlCoverage = "";
			con = ConnectionManager.getConnection();
			
			//Service Coverage			
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_ID");
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_OE");
			}
			else if("R".equals(episodeType)){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_R");
			}
			sqlInfoPage = BlRepository.getBlKeyValue("COMMON_ENCOUNTER_SERVICE_COVERAGE")+
									partSql;
							
			pstmt = con.prepareStatement(sqlInfoPage);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			pstmt.setString(5,patientId);
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,episodeId);
				pstmt.setString(8,acctSeq);
				pstmt.setString(9,priority);
				pstmt.setString(10,policyNo);
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,episodeId);
				pstmt.setString(8,visitId);
				pstmt.setString(9,acctSeq);
				pstmt.setString(10,priority);
				pstmt.setString(11,policyNo);
			}
			else if("R".equals(episodeType)){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,acctSeq);
				pstmt.setString(8,priority);
				pstmt.setString(9,policyNo);
			}

			rst = pstmt.executeQuery();
			
			if(rst != null){
				while(rst.next()){
					bean.setDefInclExclCriteria(rst.getString("excl_incl_ind"));
					bean.setOverRideInclExcl(rst.getString("ovride_incl_excl_unsp_serv_yn"));
					bean.setCovInclOthPayers(rst.getString("cumm_cvrg_with_oth_payers_yn"));
					bean.setLastPayer(rst.getString("last_payer_coverage_yn"));
					bean.setCoveragePer(rst.getString("COPAY_PERC"));
					bean.setCoverageBasis(rst.getString("POLICY_COVERAGE_BASIS"));
					bean.setCoverageRules(rst.getString("PAYER_COV_RULE"));
					bean.setStartDate(rst.getString("POLICY_EFF_FROM"));
					bean.setPayerCode(payer);
					bean.setPayerGroupCode(payerGroup);
					bean.setPolicyTypeCode(policy);
					bean.setFacilityId(facility_id);
					bean.setCoverRefPrice(rst.getString("cover_ref_price"));//Added V181012-Aravindh/AAKH-CRF-0107
					bean.setPolicyApproved(rst.getString("policy_approved_yn"));//Added V190517-Aravindh/NMC-JD-CRF-0010
				}
			}
			
			pstmt = null;
			rst = null;
			//Service Coverage	
			partSql = "";
			sqlCoverage = "";
			polList = new ArrayList<PolicyInsuranceMasterBean>();
			polMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
			//Service Coverage	Tab - Outpatient
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_ID");
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_OE");
			}
			else if("R".equals(episodeType)){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_R");
			}
			
			sqlCoverage = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_OUTPAT_INFO")+partSql;
			pstmt = con.prepareStatement(sqlCoverage);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			pstmt.setString(5,patientId);
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,episodeId);
				pstmt.setString(8,acctSeq);
				pstmt.setString(9,priority);
				pstmt.setString(10,policyNo);
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,episodeId);
				pstmt.setString(8,visitId);
				pstmt.setString(9,acctSeq);
				pstmt.setString(10,priority);
				pstmt.setString(11,policyNo);
			}
			else if("R".equals(episodeType)){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,acctSeq);
				pstmt.setString(8,priority);
				pstmt.setString(9,policyNo);
			}
			rst = pstmt.executeQuery();
			
			if(rst!=null){
				int indCnt = 0;
				while (rst.next()) {
					fmtDtlsBean = new PolicyInsuranceMasterBean();
					fmtDtlsBean.setCreditAuthReq(rst.getString("credit_req"));
					fmtDtlsBean.setCreditAuthMand(rst.getString("credit_mand"));
					fmtDtlsBean.setCreditAuthRef(rst.getString("credit_ref"));
					fmtDtlsBean.setCovered(rst.getString("covered"));
					fmtDtlsBean.setCoverageLimitType(rst.getString("limit_type"));
					fmtDtlsBean.setApprovedDays(rst.getString("day_limit_type"));
					fmtDtlsBean.setNoOfDays(rst.getString("np_of_days"));
					fmtDtlsBean.setApprovedAmt(rst.getString("amt_limit_type"));
					fmtDtlsBean.setLimitAmt(rst.getString("amt_limit"));
					fmtDtlsBean.setMandChkBillGen(rst.getString("mand_bill"));
					fmtDtlsBean.setMandChkInvoiceGen(rst.getString("mand_inv"));
					fmtDtlsBean.setAmtGrossNet(rst.getString("amt_gross_net"));
					fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
					fmtDtlsBean.setPatLimitAmt(rst.getString("patient_limit_amount"));
					polList.add(fmtDtlsBean);
					indCnt++;
					
				}
				
				if(indCnt>0){
						polMap.put("Outpatient", polList);
				}
				else{
					PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
					polList.add(titleBean);
					polMap.put("Outpatient", polList); 
				}
			}
			else{
				PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
				polList.add(titleBean);
				polMap.put("Outpatient", polList); 
			}	
			//Service Coverage	Tab	- Outpatient	
			pstmt = null;
			rst = null;			
			partSql = "";
			sqlCoverage = "";
			polList = new ArrayList<PolicyInsuranceMasterBean>();
			//Service Coverage	Tab	- Inpatient	
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_ID");
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_OE");
			}
			else if("R".equals(episodeType)){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_R");
			}
			
			sqlCoverage = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INPAT_INFO")+partSql;
			pstmt = con.prepareStatement(sqlCoverage);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			pstmt.setString(5,patientId);
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,episodeId);
				pstmt.setString(8,acctSeq);
				pstmt.setString(9,priority);
				pstmt.setString(10,policyNo);
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,episodeId);
				pstmt.setString(8,visitId);
				pstmt.setString(9,acctSeq);
				pstmt.setString(10,priority);
				pstmt.setString(11,policyNo);
			}
			else if("R".equals(episodeType)){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,acctSeq);
				pstmt.setString(8,priority);
				pstmt.setString(9,policyNo);
			}
			rst = pstmt.executeQuery();
			
			if(rst!=null){
				int indCnt = 0;
				while (rst.next()) {
					fmtDtlsBean = new PolicyInsuranceMasterBean();
					fmtDtlsBean.setCreditAuthReq(rst.getString("credit_req"));
					fmtDtlsBean.setCreditAuthMand(rst.getString("credit_mand"));
					fmtDtlsBean.setCreditAuthRef(rst.getString("credit_ref"));
					fmtDtlsBean.setCovered(rst.getString("covered"));
					fmtDtlsBean.setCoverageLimitType(rst.getString("limit_type"));
					fmtDtlsBean.setApprovedDays(rst.getString("day_limit_type"));
					fmtDtlsBean.setNoOfDays(rst.getString("np_of_days"));
					fmtDtlsBean.setApprovedAmt(rst.getString("amt_limit_type"));
					fmtDtlsBean.setLimitAmt(rst.getString("amt_limit"));
					fmtDtlsBean.setMandChkBillGen(rst.getString("mand_bill"));
					fmtDtlsBean.setMandChkInvoiceGen(rst.getString("mand_inv"));
					fmtDtlsBean.setAmtGrossNet(rst.getString("amt_gross_net"));
					fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
					fmtDtlsBean.setPatLimitAmt(rst.getString("patient_limit_amount"));
					polList.add(fmtDtlsBean);
					indCnt++;
					
				}
				
				if(indCnt>0){
					polMap.put("Inpatient", polList);
				}
				else{
					PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
					polList.add(titleBean);
					polMap.put("Inpatient", polList); 
				}
			}
			else{
				PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
				polList.add(titleBean);
				polMap.put("Inpatient", polList); 
			}	
			//Service Coverage	Tab	- Inpatient	
			pstmt = null;
			rst = null;			
			polList = new ArrayList<PolicyInsuranceMasterBean>();
			//Service Coverage	Tab	- External	
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_ID");
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_OE");
			}
			else if("R".equals(episodeType)){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_R");
			}
			
			sqlCoverage = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_EXTERNAL_INFO")+partSql;
			pstmt = con.prepareStatement(sqlCoverage);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			pstmt.setString(5,patientId);
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,episodeId);
				pstmt.setString(8,acctSeq);
				pstmt.setString(9,priority);
				pstmt.setString(10,policyNo);
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,episodeId);
				pstmt.setString(8,visitId);
				pstmt.setString(9,acctSeq);
				pstmt.setString(10,priority);
				pstmt.setString(11,policyNo);
			}
			else if("R".equals(episodeType)){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,acctSeq);
				pstmt.setString(8,priority);
				pstmt.setString(9,policyNo);
			}
			rst = pstmt.executeQuery();
			
			if(rst!=null){
				int indCnt = 0;
				while (rst.next()) {
					fmtDtlsBean = new PolicyInsuranceMasterBean();
					fmtDtlsBean.setCreditAuthReq(rst.getString("credit_req"));
					fmtDtlsBean.setCreditAuthMand(rst.getString("credit_mand"));
					fmtDtlsBean.setCreditAuthRef(rst.getString("credit_ref"));
					fmtDtlsBean.setCovered(rst.getString("covered"));
					fmtDtlsBean.setCoverageLimitType(rst.getString("limit_type"));
					fmtDtlsBean.setApprovedDays(rst.getString("day_limit_type"));
					fmtDtlsBean.setNoOfDays(rst.getString("np_of_days"));
					fmtDtlsBean.setApprovedAmt(rst.getString("amt_limit_type"));
					fmtDtlsBean.setLimitAmt(rst.getString("amt_limit"));
					fmtDtlsBean.setMandChkBillGen(rst.getString("mand_bill"));
					fmtDtlsBean.setMandChkInvoiceGen(rst.getString("mand_inv"));
					fmtDtlsBean.setAmtGrossNet(rst.getString("amt_gross_net"));
					fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
					fmtDtlsBean.setPatLimitAmt(rst.getString("patient_limit_amount"));
					polList.add(fmtDtlsBean);
					indCnt++;
					
				}
				
				if(indCnt>0){
					polMap.put("External", polList);
				}
				else{
					PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
					polList.add(titleBean);
					polMap.put("External", polList); 
				}
			}
			else{
				PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
				polList.add(titleBean);
				polMap.put("External", polList); 
			}	
			//Service Coverage	Tab	- External	
			pstmt = null;
			rst = null;			
			/*polList = new ArrayList<PolicyInsuranceMasterBean>();
			popMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
			sqlCoverage = "";
			partSql = "";
			
			// Incl/Excl Coverage Detials
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_ID");
				partExclSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_EXCL_ID");
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_OE");
				partExclSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_EXCL_OE");
			}
			else if("R".equals(episodeType)){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_R");
				partExclSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_EXCL_R");
			}
			
			
			sqlCoverage = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_FIRST_PART")+partExclSql+BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_SECOND_PART")+partSql;

			pstmt = con.prepareStatement(sqlCoverage);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,facility_id);
			pstmt.setString(6,payerGroup);
			pstmt.setString(7,payer);
			pstmt.setString(8,policy);
			pstmt.setString(9,patientId);
			
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				pstmt.setString(10,episodeType);
				pstmt.setString(11,episodeId);
				pstmt.setString(12,acctSeq);
				pstmt.setString(13,priority);
				
				pstmt.setString(14,facility_id);
				pstmt.setString(15,payerGroup);
				pstmt.setString(16,payer);
				pstmt.setString(17,policy);
				pstmt.setString(18,patientId);
				
				pstmt.setString(19,episodeType);
				pstmt.setString(20,episodeId);
				pstmt.setString(21,acctSeq);
				pstmt.setString(22,priority);

			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				pstmt.setString(10,episodeType);
				pstmt.setString(11,episodeId);
				pstmt.setString(12,visitId);
				pstmt.setString(13,acctSeq);
				pstmt.setString(14,priority);
				
				pstmt.setString(15,facility_id);
				pstmt.setString(16,payerGroup);
				pstmt.setString(17,payer);
				pstmt.setString(18,policy);
				pstmt.setString(19,patientId);
				
				pstmt.setString(20,episodeType);
				pstmt.setString(21,episodeId);
				pstmt.setString(22,visitId);
				pstmt.setString(23,acctSeq);
				pstmt.setString(24,priority);
			}
			else if("R".equals(episodeType)){
				
				pstmt.setString(10,episodeType);
				pstmt.setString(11,acctSeq);
				pstmt.setString(12,priority);
				
				pstmt.setString(13,facility_id);
				pstmt.setString(14,payerGroup);
				pstmt.setString(15,payer);
				pstmt.setString(16,policy);
				pstmt.setString(17,patientId);
				
				pstmt.setString(18,episodeType);
				pstmt.setString(19,acctSeq);
				pstmt.setString(20,priority);
			}
			

			rst = pstmt.executeQuery();
			
			if(rst!=null){
				int rsCnt = 0;
				while (rst.next()) {
					fmtDtlsBean = new PolicyInsuranceMasterBean();
					fmtDtlsBean.setPatClass(rst.getString("patient_class"));
					fmtDtlsBean.setAgeGroup(rst.getString("AGE_GROUP_CODE"));
					fmtDtlsBean.setAgeGroupDesc(rst.getString("age_group_desc"));
					fmtDtlsBean.setGender(rst.getString("SEX"));
					fmtDtlsBean.setEpisodeEncounter(rst.getString("episode_or_encounter_flag"));
					fmtDtlsBean.setClinicNurs(rst.getString("clinic_nursing_ind"));
					fmtDtlsBean.setClinicNursCode(rst.getString("clinic_nursing_code"));
					fmtDtlsBean.setClinicNursDesc(rst.getString("clinic_nursing_desc"));
					fmtDtlsBean.setSpecCode(rst.getString("splty_code"));
					fmtDtlsBean.setSpecDesc(rst.getString("spec_desc"));
					fmtDtlsBean.setInclExclCriteria(rst.getString("serv_excl_incl_crit"));
					fmtDtlsBean.setBillServCode(rst.getString("blng_serv_code"));
					fmtDtlsBean.setBillServDesc(rst.getString("blng_serv_desc"));
					fmtDtlsBean.setBillServChk(rst.getString("special_service_yn"));
					fmtDtlsBean.setInclExclInd(rst.getString("excl_incl_ind"));
					fmtDtlsBean.setInclExclIndChk(rst.getString("ovride_incl_excl_yn"));
					fmtDtlsBean.setInclusionBasis(rst.getString("copay_ind"));
					fmtDtlsBean.setAmtGrossNet(rst.getString("per_day_amt_limit_gross_net"));
					fmtDtlsBean.setRowNumber(new Integer(rsCnt).toString());
					if(Integer.parseInt(rst.getString("total"))>0){
						fmtDtlsBean.setServLimit("Y");
						pstmt2 = null;
						rst2 = null;
						//Exclusion Popup
						popList = new ArrayList<PolicyInsuranceMasterBean>();
						if(("I".equals(episodeType)) || ("D".equals(episodeType))){
							partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_ID");
						}
						else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
							partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_OE");
						}
						else if("R".equals(episodeType)){
							partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_R");
						}
						
						String sqlCoveragePop =  BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_PRE_APPROVAL_POPUP")+partSql;

						pstmt2 = con.prepareStatement(sqlCoveragePop);
						pstmt2.setString(1,locale);
						pstmt2.setString(2,facility_id);
						pstmt2.setString(3,payerGroup);
						pstmt2.setString(4,payer);
						pstmt2.setString(5,policy);
						pstmt2.setString(6,fmtDtlsBean.getInclExclCriteria());
						pstmt2.setString(7,fmtDtlsBean.getBillServCode());
						pstmt2.setString(8,fmtDtlsBean.getPatClass());
						pstmt2.setString(9,patientId);						
						
						pstmt2.setString(10,fmtDtlsBean.getEpisodeEncounter());
						pstmt2.setString(11,fmtDtlsBean.getGender());
						pstmt2.setString(12,fmtDtlsBean.getAgeGroup());
						pstmt2.setString(13,fmtDtlsBean.getClinicNurs());
						pstmt2.setString(14,fmtDtlsBean.getClinicNursCode());
						pstmt2.setString(15,fmtDtlsBean.getSpecCode());
						pstmt2.setString(16,fmtDtlsBean.getStartDate());
						
						if(("I".equals(episodeType)) || ("D".equals(episodeType))){
							pstmt2.setString(17,episodeType);
							pstmt2.setString(18,episodeId);
							pstmt2.setString(19,acctSeq);
							pstmt2.setString(20,priority);

						}
						else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
							pstmt2.setString(17,episodeType);
							pstmt2.setString(18,episodeId);
							pstmt2.setString(19,visitId);
							pstmt2.setString(20,acctSeq);
							pstmt2.setString(21,priority);
							
						}
						else if("R".equals(episodeType)){
							
							pstmt2.setString(17,episodeType);
							pstmt2.setString(18,acctSeq);
							pstmt2.setString(19,priority);
							
						}
						
						rst2 = pstmt2.executeQuery();
						
						if(rst2!=null){
							int rsCntP = 0;
							while (rst2.next()) {
								fmtDtlsBean1 = new PolicyInsuranceMasterBean();


								fmtDtlsBean1.setInclExclCriteria(rst2.getString("excl_serv_excl_incl_crit"));
								fmtDtlsBean1.setBillServCode(rst2.getString("excl_blng_serv_code"));
								fmtDtlsBean1.setBillServDesc(rst2.getString("blng_serv_desc"));
								fmtDtlsBean1.setInclExclInd(rst2.getString("excl_incl_ind"));
								fmtDtlsBean1.setInclusionBasis(rst2.getString("copay_ind"));
								fmtDtlsBean1.setValue(rst2.getString("copay_val"));
								fmtDtlsBean1.setServItemQty(rst2.getString("qty_capping"));
								fmtDtlsBean1.setAmtPerVisit(rst2.getString("amount_capping"));
								fmtDtlsBean1.setAmtPerIPDay(rst2.getString("per_day_amount_limit"));
								fmtDtlsBean1.setNoOfDays(rst2.getString("no_of_days_limit"));
								fmtDtlsBean1.setStartDate(rst2.getString("effective_from"));
								fmtDtlsBean1.setEndDate(rst2.getString("effective_to"));
								fmtDtlsBean1.setAmtGrossNet(rst2.getString("per_day_amt_limit_gross_net"));
								fmtDtlsBean1.setPatCopay(rst2.getString("patient_copay"));
								fmtDtlsBean1.setPatLimitAmt(rst2.getString("patient_amount_limit"));
								fmtDtlsBean1.setStatus("I");
								fmtDtlsBean1.setDelFlag("N");
								popList.add(fmtDtlsBean1);
								rsCntP++;
							}
							
							if(rsCntP>0){
								popMap.put(fmtDtlsBean.getRowNumber(), popList);
							}
							else{
								PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
								titleBean.setStartDate(fmtDtlsBean.getStartDate());
								titleBean.setEndDate(fmtDtlsBean.getEndDate());
								popList.add(titleBean);
								popMap.put(fmtDtlsBean.getRowNumber(), popList);
							}
						}
						else{
							PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
							titleBean.setStartDate(fmtDtlsBean.getStartDate());
							titleBean.setEndDate(fmtDtlsBean.getEndDate());
							popList.add(titleBean);
							popMap.put(fmtDtlsBean.getRowNumber(), popList);
						}		
						//Exclusion Popup						
						
					}
					else{
						fmtDtlsBean.setServLimit("N");
					}
					fmtDtlsBean.setValue(rst.getString("copay_val"));
					fmtDtlsBean.setValueChk1(rst.getString("include_policy_level_copay_yn"));
					fmtDtlsBean.setValueChk2(rst.getString("pre_approval_yn"));
					fmtDtlsBean.setValueChk3(rst.getString("cumm_cvrg_with_oth_payers_yn"));
					fmtDtlsBean.setValueChk4(rst.getString("last_payer_coverage_yn"));
					fmtDtlsBean.setServItemQty(rst.getString("qty_capping"));
					fmtDtlsBean.setAmtPerVisit(rst.getString("amount_capping"));
					fmtDtlsBean.setAmtPerIPDay(rst.getString("per_day_amount_limit"));
					fmtDtlsBean.setNoOfDays(rst.getString("no_of_days_limit"));
					fmtDtlsBean.setStartDate(rst.getString("effective_from"));
					fmtDtlsBean.setEndDate(rst.getString("effective_to"));
					fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
					fmtDtlsBean.setPatLimitAmt(rst.getString("patient_amount_limit"));
					fmtDtlsBean.setStatus("I");
					fmtDtlsBean.setDelFlag("N");
					polList.add(fmtDtlsBean);
					rsCnt++;
				}
				
				if(rsCnt>0){
					polMap.put("inclExclCoverage", polList); 
				}
				else{
					PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
					polList.add(titleBean);
					polMap.put("inclExclCoverage", polList); 
				}
			}
			else{
				PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
				polList.add(titleBean);
				polMap.put("inclExclCoverage", polList); 
			}		
			
			
			// Incl/Excl Coverage Detials
			pstmt = null;
			rst = null;			
			polList = new ArrayList<PolicyInsuranceMasterBean>();
			// Pre Approval Detials
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_ID");
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_OE");
			}
			else if("R".equals(episodeType)){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_R");
			}
			
			sqlCoverage = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_PRE_APPROVAL")+partSql;

			pstmt = con.prepareStatement(sqlCoverage);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,facility_id);
			pstmt.setString(6,payerGroup);
			pstmt.setString(7,payer);
			pstmt.setString(8,policy);
			pstmt.setString(9,patientId);
			
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				pstmt.setString(10,episodeType);
				pstmt.setString(11,episodeId);
				pstmt.setString(12,acctSeq);
				pstmt.setString(13,priority);

			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				pstmt.setString(10,episodeType);
				pstmt.setString(11,episodeId);
				pstmt.setString(12,visitId);
				pstmt.setString(13,acctSeq);
				pstmt.setString(14,priority);
				
			}
			else if("R".equals(episodeType)){
				
				pstmt.setString(10,episodeType);
				pstmt.setString(11,acctSeq);
				pstmt.setString(12,priority);
				
			}
			rst = pstmt.executeQuery();
			
			if(rst!=null){
				int rsCnt = 0;
				while (rst.next()) {
					fmtDtlsBean = new PolicyInsuranceMasterBean();
					fmtDtlsBean.setPatClass(rst.getString("patient_class"));
					fmtDtlsBean.setAgeGroup(rst.getString("AGE_GROUP_CODE"));
					fmtDtlsBean.setAgeGroupDesc(rst.getString("age_group_desc"));
					fmtDtlsBean.setGender(rst.getString("SEX"));
					fmtDtlsBean.setEpisodeEncounter(rst.getString("episode_or_encounter_flag"));
					fmtDtlsBean.setClinicNurs(rst.getString("clinic_nursing_ind"));
					fmtDtlsBean.setClinicNursCode(rst.getString("clinic_nursing_code"));
					fmtDtlsBean.setClinicNursDesc(rst.getString("clinic_nursing_desc"));
					fmtDtlsBean.setSpecCode(rst.getString("splty_code"));
					fmtDtlsBean.setSpecDesc(rst.getString("spec_desc"));
					fmtDtlsBean.setType(rst.getString("serv_excl_incl_crit"));
					fmtDtlsBean.setBillServCode(rst.getString("blng_serv_code"));
					fmtDtlsBean.setBillServDesc(rst.getString("blng_serv_desc"));
					fmtDtlsBean.setPreApprAmtCapping(rst.getString("preapproval_amt_capping"));
					fmtDtlsBean.setPreApprQtyCapping(rst.getString("preapproval_qty_capping"));
					fmtDtlsBean.setServLimit(rst.getString("service_level_approval_yn"));
					fmtDtlsBean.setStartDate(rst.getString("effective_from"));
					fmtDtlsBean.setEndDate(rst.getString("effective_to"));
					fmtDtlsBean.setAmtGrossNet(rst.getString("preapproval_amt_gross_net"));
					fmtDtlsBean.setStatus("I");
					fmtDtlsBean.setDelFlag("N");
					polList.add(fmtDtlsBean);
					rsCnt++;					
				}
				if(rsCnt>0){
					polMap.put("preApproval", polList);
				}
				else{
					PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
					titleBean.setStartDate(bean.getStartDate());
					titleBean.setEndDate(bean.getEndDate());
					polList.add(titleBean);
					polMap.put("preApproval", polList);
				}
			}
			else{
				PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
				titleBean.setStartDate(bean.getStartDate());
				titleBean.setEndDate(bean.getEndDate());
				polList.add(titleBean);
				polMap.put("preApproval", polList);
			}		
			// Pre Approval Detials
			 */
			bean.setPolicyMap(polMap);
			bean.setPopupMap(popMap);
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception In get Policy Bean Details 2084:::"+e);
		}
		finally{
			ConnectionManager.returnConnection(con);
			rst = null;
			rst2 = null;
			pstmt = null;
			pstmt2 = null;
		}
		return bean;
	}

	public  PolicyInsuranceMasterBean getPreviousEncounterDetials(String facility_id,String patientId,String episodeType,String episodeId,String visitId,
																 String locale,String encounterDate){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		PolicyInsuranceMasterBean bean = new PolicyInsuranceMasterBean();
		PolicyInsuranceMasterBean fmtDtlsBean = new PolicyInsuranceMasterBean();
		HashMap<String,PolicyInsuranceMasterBean> masterMap = new HashMap<String, PolicyInsuranceMasterBean>();
		try{
			
			con = ConnectionManager.getConnection();
			
			String strDeflPolicyDefn = "Select DFLT_POLICY_DEF_IN_VIS_REG_YN from bl_parameters";
			String deflPolicyDefYn = "";
			pstmt = con.prepareCall(strDeflPolicyDefn);
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					deflPolicyDefYn = rst.getString("DFLT_POLICY_DEF_IN_VIS_REG_YN");
				}
			}
			rst = null;
			pstmt = null;
			
			String patientList =  "";
			
			if(("O".equals(episodeType)) ||  ("E".equals(episodeType))){
				patientList = 	BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_DATA_DETAILS_OE");
			}
			else if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				patientList = 	BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_DATA_DETAILS_ID");
			}
			else if(("R".equals(episodeType))){
				patientList = 	BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_DATA_DETAILS_R_PREV");
			}

			if(!("R").equals(episodeType)){
				if(!(("".equals(patientId)) || ("".equals(episodeType)) || ("".equals(episodeId)))){
					pstmt = con.prepareStatement(patientList);
					pstmt.setString(1, patientId);
					pstmt.setString(2, episodeType);
					pstmt.setString(3, facility_id);
					pstmt.setString(4, patientId);
					pstmt.setInt(5, Integer.parseInt(episodeId));
					pstmt.setInt(6, Integer.parseInt(episodeId));
					pstmt.setString(7, facility_id);			
					pstmt.setInt(8, Integer.parseInt(episodeId));
					pstmt.setString(9, patientId);
					pstmt.setString(10, encounterDate);
					
					rst = pstmt.executeQuery();
				}
			}
			else{
				if(!(("".equals(patientId)) || ("".equals(episodeType)))){
					pstmt = con.prepareStatement(patientList);
					pstmt.setString(1, patientId);
					pstmt.setString(2, episodeType);
					pstmt.setString(3, facility_id);
					pstmt.setString(4, patientId);
					rst = pstmt.executeQuery();
					}
			}
			
			if(rst != null){
				while(rst.next()){
					fmtDtlsBean = new PolicyInsuranceMasterBean();
					if("Y".equals(deflPolicyDefYn)){
						fmtDtlsBean = getPolicyDefinitionDetials(facility_id, rst.getString("CUST_GROUP_CODE"), rst.getString("CUST_CODE"), rst.getString("POLICY_TYPE_CODE"), locale);
					}
					else{
						fmtDtlsBean = getEncounterSpecificDetials(facility_id, rst.getString("CUST_GROUP_CODE"), rst.getString("CUST_CODE"), 
								rst.getString("POLICY_TYPE_CODE"), patientId, episodeType, episodeId, rst.getString("VISIT_ID"), 
								rst.getString("ACCT_SEQ_NO"), rst.getString("PRIORITY"), rst.getString("POLICY_NUMBER"), locale);
						
						fmtDtlsBean.setPolicyOrEncounter(facility_id+":::"+patientId+":::"+episodeType+"::: "+episodeId+"::: "+visitId+":::"+
																 locale+":::"+encounterDate);
					}
					
					masterMap.put(rst.getString("PRIORITY")+"~"+rst.getString("CUST_GROUP_CODE")+"~"+rst.getString("CUST_CODE")+"~"+rst.getString("POLICY_TYPE_CODE")+"~"+rst.getString("POLICY_NUMBER"), fmtDtlsBean);
					
				}
			}
			
			bean.setMasterMap(masterMap);
		}
		
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception In get Policy Bean Details 2194:::"+e);
		}
		finally{
			ConnectionManager.returnConnection(con);
			rst = null;
			pstmt = null;
		}
		return bean;
	}

}
