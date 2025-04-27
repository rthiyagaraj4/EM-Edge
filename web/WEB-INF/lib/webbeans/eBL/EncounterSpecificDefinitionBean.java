package blPolicy;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eBL.Common.BlAdapter;


public class EncounterSpecificDefinitionBean  extends BlAdapter implements Serializable {
		private String facilityId;
		private String priority;
		private String policyNo;
		private String patientId;
		private String patientName;
		private String episodeType;
		private String episodeId;
		private String visitId;
		private String encounterId;
		private String ageY;
		private String ageM;
		private String ageD;
		private String recalcCharges;
		private String gender;
		private String encounterDate;
		private String payerCode;
		private String payerGroupCode;
		private String policyTypeCode;
		private String startDate;
		private String endDate;
		private String policyApplicability;
		
		private String coverageBasis;
		private String coverageRules;
		private String coveragePer;
		
		private String illDedAmt;
		private String vstDedAmt;
		private String polRefCustCode;
		private String blngGrpid;
		private String effectiveDate;
		private String includeHomeMedication;
		
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
		private String grpServInd;	//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 
		private String inclExclIndChk;
		private String groupRservice="";// ADDED FOR MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020
		private String preAppgroupRservice="";// ADDED FOR MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020   

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
		private String preApprDurCapping; //Added V180725-Gayathri/MMS-DM-CRF-0126
		//Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts
		private String preAcrossEnc;
		private String exlinclAcrossEnc;
		//Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends

		private String servLimit;
		
		private String exclude;
		private String status;
		private String delFlag;
		
		private String amtGrossNet;
		private String rowNumber;
		private String patCopay;
		private String patLimitAmt;
		
		private String acrossGroupId;
		private String coverRefPrice = "";//Added V181008-Aravindh/AAKH-CRF-0107/Getter Setter Pair
		private String policyApproved = "";//Added V190517-Aravindh/NMC-JD-CRF-0010/Getter Setter Pair
		
		
		HashMap<String, List<EncounterSpecificDefinitionBean>> policyMap = null;
		List<EncounterSpecificDefinitionBean> policyList = null;
		
		List<EncounterSpecificDefinitionBean> popupList = null;
		HashMap<String, List<EncounterSpecificDefinitionBean>> popupMap = null;
		
		HashMap<String,EncounterSpecificDefinitionBean> masterMap = null;
		
		HashMap<String,String> restrictionMap = null;
		
		//Added for MOHE-CRF-0114
		private String diagCopayYN = "N";
		private String diagType = "";
		private String diagPatCopay = "";
		private String diagStartDate = "";
		private String diagEndDate = "";
		private String diagDelFlag = "";
		private String diagStatus = "";
		
		// Added for MOHE-CRF-0114 ends	

		List<EncounterSpecificDefinitionBean> diagPopupList = null;//Added for MOHE-CRF-0114
		HashMap<String, List<EncounterSpecificDefinitionBean>> diagPopupMap = null;//Added for MOHE-CRF-0114	
		
		
		public String getFacilityId() {
			return facilityId;
		}
		public void setFacilityId(String facilityId) {
			this.facilityId = facilityId;
		}
		
		public String getPriority() {
			return priority;
		}
		public void setPriority(String priority) {
			this.priority = priority;
		}
		public String getPolicyNo() {
			return policyNo;
		}
		public void setPolicyNo(String policyNo) {
			this.policyNo = policyNo;
		}

		public String getIncludeHomeMedication() {
			return includeHomeMedication;
		}
		public void setIncludeHomeMedication(String includeHomeMedication) {
			this.includeHomeMedication = includeHomeMedication;
		}
		public String getEffectiveDate() {
			return effectiveDate;
		}
		public void setEffectiveDate(String effectiveDate) {
			this.effectiveDate = effectiveDate;
		}
		public String getBlngGrpid() {
			return blngGrpid;
		}
		public void setBlngGrpid(String blngGrpid) {
			this.blngGrpid = blngGrpid;
		}
		public String getPolRefCustCode() {
			return polRefCustCode;
		}
		public void setPolRefCustCode(String polRefCustCode) {
			this.polRefCustCode = polRefCustCode;
		}
		public String getIllDedAmt() {
			return illDedAmt;
		}
		public void setIllDedAmt(String illDedAmt) {
			this.illDedAmt = illDedAmt;
		}
		public String getVstDedAmt() {
			return vstDedAmt;
		}
		public void setVstDedAmt(String vstDedAmt) {
			this.vstDedAmt = vstDedAmt;
		}
		public String getPolicyApplicability() {
			return policyApplicability;
		}
		public void setPolicyApplicability(String policyApplicability) {
			this.policyApplicability = policyApplicability;
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
		public String getPolicyTypeCode() {
			return policyTypeCode;
		}
		public void setPolicyTypeCode(String policyTypeCode) {
			this.policyTypeCode = policyTypeCode;
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
		
		//Added V190523 MuthuN/NMC-JD-CRF-0002.1
		private String claimsAgrmtExts ="";
		
		public String getclaimsAgrmtExts() {
				return claimsAgrmtExts;
		}
		public void setclaimsAgrmtExts(
			String claimsAgrmtExts) {
				this.claimsAgrmtExts = claimsAgrmtExts;
		}
		//Added V190523 MuthuN/NMC-JD-CRF-0002.1
		
		//Added V180725-Gayathri/MMS-DM-CRF-0126/Starts
		public String getPreApprDurCapping() {
			return preApprDurCapping;
		}
		public void setPreApprDurCapping(String preApprDurCapping) {
			this.preApprDurCapping = preApprDurCapping;
		}
		//Added V180725-Gayathri/MMS-DM-CRF-0126/Ends
		//Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts
		public String getPreacrossenc() {
			return preAcrossEnc;
		}
	  
		public void setPreacrossenc(String preAcrossEnc) {
			this.preAcrossEnc = preAcrossEnc;
		}
		public String getExlinclacrossenc() {
			return exlinclAcrossEnc;
			}
		public void setExlinclacrossenc(String exlinclAcrossEnc) {
			this.exlinclAcrossEnc = exlinclAcrossEnc;
			}
		//Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends	
		public String getRowNumber() {
			return rowNumber;
		}
		public String getAcrossGroupId() {
			return acrossGroupId;
		}
		public void setAcrossGroupId(String acrossGroupId) {
			this.acrossGroupId = acrossGroupId;
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

		
		public HashMap<String, String> getRestrictionMap() {
			return restrictionMap;
		}
		public void setRestrictionMap(HashMap<String, String> restrictionMap) {
			this.restrictionMap = restrictionMap;
		}
		
		public HashMap<String, EncounterSpecificDefinitionBean> getMasterMap() {
			return masterMap;
		}
		public void setMasterMap(
				HashMap<String, EncounterSpecificDefinitionBean> masterMap) {
			this.masterMap = masterMap;
		}
		public List<EncounterSpecificDefinitionBean> getPopupList() {
			return popupList;
		}
		public void setPopupList(List<EncounterSpecificDefinitionBean> popupList) {
			this.popupList = popupList;
		}
		
		public HashMap<String, List<EncounterSpecificDefinitionBean>> getPopupMap() {
			return popupMap;
		}
		public void setPopupMap(
				HashMap<String, List<EncounterSpecificDefinitionBean>> popupMap) {
			this.popupMap = popupMap;
		}
		
	
		public String getPatientId() {
			return patientId;
		}
		public void setPatientId(String patientId) {
			this.patientId = patientId;
		}
		public String getPatientName() {
			return patientName;
		}
		public void setPatientName(String patientName) {
			this.patientName = patientName;
		}
		public String getEpisodeType() {
			return episodeType;
		}
		public void setEpisodeType(String episodeType) {
			this.episodeType = episodeType;
		}
		public String getEpisodeId() {
			return episodeId;
		}
		public void setEpisodeId(String episodeId) {
			this.episodeId = episodeId;
		}
		public String getVisitId() {
			return visitId;
		}
		public void setVisitId(String visitId) {
			this.visitId = visitId;
		}
		public String getEncounterId() {
			return encounterId;
		}
		public void setEncounterId(String encounterId) {
			this.encounterId = encounterId;
		}
		public String getAgeY() {
			return ageY;
		}
		public void setAgeY(String ageY) {
			this.ageY = ageY;
		}
		public String getAgeM() {
			return ageM;
		}
		public void setAgeM(String ageM) {
			this.ageM = ageM;
		}
		public String getAgeD() {
			return ageD;
		}
		public void setAgeD(String ageD) {
			this.ageD = ageD;
		}
		public String getRecalcCharges() {
			return recalcCharges;
		}
		public void setRecalcCharges(String recalcCharges) {
			this.recalcCharges = recalcCharges;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getEncounterDate() {
			return encounterDate;
		}
		public void setEncounterDate(String encounterDate) {
			this.encounterDate = encounterDate;
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
		
		//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 STARTS-->
		public String getGroupServInd() {
			return grpServInd;
		}
		
		public void setGroupServInd(String grpServInd) {
		this.grpServInd = grpServInd;
		}
		
		//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 Ends-->
		
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
		

		public HashMap<String, List<EncounterSpecificDefinitionBean>> getPolicyMap() {
			return policyMap;
		}
		public void setPolicyMap(HashMap<String, List<EncounterSpecificDefinitionBean>> policyMap) {
			this.policyMap = policyMap;
		}
		public List<EncounterSpecificDefinitionBean> getPolicyList() {
			return policyList;
		}
		public void setPolicyList(List<EncounterSpecificDefinitionBean> policyList) {
			this.policyList = policyList;
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

		public List<EncounterSpecificDefinitionBean> getDiagPopupList() {
			return diagPopupList;
		}
		public void setDiagPopupList(List<EncounterSpecificDefinitionBean> diagPopupList) {
			this.diagPopupList = diagPopupList;
		}
		
		public HashMap<String, List<EncounterSpecificDefinitionBean>> getDiagPopupMap() {
			return diagPopupMap;
		}
		public void setDiagPopupMap(
				HashMap<String, List<EncounterSpecificDefinitionBean>> diagPopupMap) {
			this.diagPopupMap = diagPopupMap;
		}
		// Added for MOHE-CRF-0114 Ends		

		// Added for V230228 starts
		String encSpecMFDR_YN = "";
		public String getEncSpecMFDRYN() {
			return encSpecMFDR_YN;
		}
		
		public void setEncSpecMFDRYN(String encSpecMFDR_YN) {
			this.encSpecMFDR_YN = encSpecMFDR_YN;
		}
		
		// Added for V230228 ends
		
		public void clearAll(){
			policyMap = null;
			popupMap = null;
			policyList = null;
			popupList = null;
			masterMap = null;
			restrictionMap = null;
			
			patientId = null;
			patientName = null;
			priority = null;
			policyNo = null;
			
			episodeType = null;
			episodeId = null;
			visitId = null;
			encounterId = null;
			ageY = null;
			ageM = null;
			ageD = null;
			recalcCharges = null;
			gender = null;
			encounterDate = null;
			payerCode = null;
			payerGroupCode = null;
			policyTypeCode = null;
			startDate = null;
			endDate = null;
			policyApplicability = null;
			
			illDedAmt = null;
			vstDedAmt = null;
			polRefCustCode = null;
			blngGrpid = null;
			
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
			grpServInd = null;//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 
			inclExclIndChk = null;
			groupRservice=null;// ADDED FOR MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020
			preAppgroupRservice=null;  //26-8-2020
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
			preApprDurCapping = null; //Added V180725-Gayathri/MMS-DM-CRF-0126
			servLimit = null;
			//Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts
			preAcrossEnc = null;
			exlinclAcrossEnc = null;
			//Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends
			exclude = null;
			status = null;
			delFlag = null;
			amtGrossNet = null;
			rowNumber = null;

			patCopay = null;
			patLimitAmt = null;
			acrossGroupId = null;
			effectiveDate = null;
			includeHomeMedication=null;
			
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
		}
		
		@Override
		public String toString() {
			return "EncounterSpecificDefinitionBean [facilityId=" + facilityId
					+ ", priority=" + priority + ", policyNo=" + policyNo
					+ ", patientId=" + patientId + ", patientName="
					+ patientName + ", episodeType=" + episodeType
					+ ", episodeId=" + episodeId + ", visitId=" + visitId
					+ ", encounterId=" + encounterId + ", ageY=" + ageY
					+ ", ageM=" + ageM + ", ageD=" + ageD + ", recalcCharges="
					+ recalcCharges + ", gender=" + gender + ", encounterDate="
					+ encounterDate + ", payerCode=" + payerCode
					+ ", payerGroupCode=" + payerGroupCode
					+ ", policyTypeCode=" + policyTypeCode + ", startDate="
					+ startDate + ", endDate=" + endDate
					+ ", policyApplicability=" + policyApplicability
					+ ", coverageBasis=" + coverageBasis + ", coverageRules="
					+ coverageRules + ", coveragePer=" + coveragePer
					+ ", illDedAmt=" + illDedAmt + ", vstDedAmt=" + vstDedAmt
					+ ", polRefCustCode=" + polRefCustCode + ", blngGrpid="
					+ blngGrpid + ", effectiveDate=" + effectiveDate
					+ ", defInclExclCriteria=" + defInclExclCriteria
					+ ", servInclExclCriteria=" + servInclExclCriteria
					+ ", servCoverageLimitCriteria="
					+ servCoverageLimitCriteria + ", overRideInclExcl="
					+ overRideInclExcl + ", covInclOthPayers="
					+ covInclOthPayers + ", lastPayer=" + lastPayer
					+ ", creditAuthReq=" + creditAuthReq + ", creditAuthMand="
					+ creditAuthMand + ", creditAuthRef=" + creditAuthRef
					+ ", covered=" + covered + ", approvedDays=" + approvedDays
					+ ", noOfDays=" + noOfDays + ", approvedAmt=" + approvedAmt
					+ ", limitAmt=" + limitAmt + ", coverageLimitType="
					+ coverageLimitType + ", mandChkBillGen=" + mandChkBillGen
					+ ", mandChkInvoiceGen=" + mandChkInvoiceGen
					+ ", patClass=" + patClass + ", ageGroup=" + ageGroup
					+ ", ageGroupDesc=" + ageGroupDesc + ", episodeEncounter="
					+ episodeEncounter + ", clinicNurs=" + clinicNurs
					+ ", clinicNursCode=" + clinicNursCode
					+ ", clinicNursDesc=" + clinicNursDesc + ", specCode="
					+ specCode + ", specDesc=" + specDesc
					+ ", inclExclCriteria=" + inclExclCriteria
					+ ", billServCode=" + billServCode + ", billServDesc="
					+ billServDesc + ", billServChk=" + billServChk
					+ ", inclExclInd=" + inclExclInd + ", grpServInd=" + grpServInd+  ", inclExclIndChk="
					+ inclExclIndChk + ", inclusionBasis=" + inclusionBasis
					+ ", value=" + value + ", valueChk1=" + valueChk1
					+ ", valueChk2=" + valueChk2 + ", valueChk3=" + valueChk3
					+ ", valueChk4=" + valueChk4 + ", servItemQty="
					+ servItemQty + ", amtPerVisit=" + amtPerVisit
					+ ", amtPerAdmn=" + amtPerAdmn + ", amtPerIPDay="
					+ amtPerIPDay + ", type=" + type + ", preApprAmtCapping="
					+ preApprAmtCapping + ", preApprQtyCapping="
					+ preApprQtyCapping + ", preApprDurCapping="
					+ preApprDurCapping + ", preAcrossEnc=" + preAcrossEnc
					+ ", exlinclAcrossEnc=" + exlinclAcrossEnc+ ", servLimit=" 
					+ servLimit+ ", exclude=" + exclude + ", status=" + status
					+ ", delFlag=" + delFlag + ", amtGrossNet=" + amtGrossNet
					+ ", rowNumber=" + rowNumber + ", patCopay=" + patCopay
					+ ", patLimitAmt=" + patLimitAmt + ", acrossGroupId="
					+ acrossGroupId + ", policyMap=" + policyMap
					+ ", policyList=" + policyList + ", popupList=" + popupList
					+ ", popupMap=" + popupMap + ", masterMap=" + masterMap
					+ ", restrictionMap=" + restrictionMap 
					+ ", diagCopayYN=" + diagCopayYN +"]";					
		}		
}