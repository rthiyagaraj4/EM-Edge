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

public class MFDRServicesAndItemsBean extends BlAdapter implements Serializable {

	private String facilityId;
	private String payer;
	private String payerCode;
	private String payerGroup;
	private String payerGroupCode;
	private String startDate;
	private String endDate;
	private String policyType;
	private String policyTypeCode;
	private String limitAmt;
	private String oldEndDate;
	private String patClass;

	private String episodeEncounter;
	private String Calledfrom; 
	private String status;
	
	private String amtGrossNet;
	private String rowNumber;
	private String patCopay;
	private String patLimitAmt;
	private String diagCat = "";
	private String incl_excl_criteria = "";
	private String service_dtls_desc = "";
	private String service_dtls_code = "";
	private String referral = "";
	private String clinic_category = "";
	private String clinic_proc_unit = "";
	private String clinic_proc_code = "";
	private String clinic_proc_desc = "";
	private String across_enc_YN = "";  //V230801
	

	public String getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}
	
	public String getPayer() {
		return payer;
	}
	public void setPayer(String payer) {
		this.payer = payer;
	}
	
	public String getOldEndDate() {
		return oldEndDate;
	}
	public void setOldEndDate(String oldEndDate) {
		this.oldEndDate = oldEndDate;
	}
	
	public String getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(String rowNumber) {
		this.rowNumber = rowNumber;
	}
	
	public String getAmtGrossNet() {
		return amtGrossNet;
	}
	public void setAmtGrossNet(String amtGrossNet) {
		this.amtGrossNet = amtGrossNet;
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
	
	public String getInclExclCriteria() {
		return incl_excl_criteria;
	}
	public void setInclExclCriteria(String incl_excl_criteria) {
		this.incl_excl_criteria = incl_excl_criteria;
	}
	public String getServiceDetailsDesc() {
		return service_dtls_desc;
	}
	public void setServiceDetailsDesc(String service_dtls_desc) {
		this.service_dtls_desc = service_dtls_desc;
	}
	public String getServiceDetailsCode() {
		return service_dtls_code;
	}
	public void setServiceDetailsCode(String service_dtls_code) {
		this.service_dtls_code = service_dtls_code;
	}
	public String getReferral() {
		return referral;
	}
	public void setReferral(String referral) {
		this.referral = referral;
	}
	public String getClinicCat() {
		return clinic_category;
	}
	public void setClinicCat(String clinic_category) {
		this.clinic_category = clinic_category;
	}
	public String getClinicProc() {
		return clinic_proc_unit;
	}	
	public void setClinicProc(String clinic_proc_unit) {
		this.clinic_proc_unit = clinic_proc_unit;
	}
	public String getClinicProcCode() {
		return clinic_proc_code;
	}
	public void setClinicProcCode(String clinic_proc_code) {
		this.clinic_proc_code = clinic_proc_code;
	}
	public String getClinicProcDesc() {
		return clinic_proc_desc;
	}
	public void setClinicProcDesc(String clinic_proc_desc) {
		this.clinic_proc_desc = clinic_proc_desc;
	}
	
	//V230801 start
	public String getAcrossEncYN() {
		return across_enc_YN;
	}
	public void setAcrossEncYN(String across_enc_YN) {
		this.across_enc_YN = across_enc_YN;
	}
	//V230801 end
	
	HashMap<String, List<MFDRServicesAndItemsBean>> policyMap = null;
	List<MFDRServicesAndItemsBean> policyList = null;
	
	List<MFDRServicesAndItemsBean> popupList = null;
	HashMap<String, List<MFDRServicesAndItemsBean>> popupMap = null;
	
	List<MFDRServicesAndItemsBean> diagPopupList = null;
	HashMap<String, List<MFDRServicesAndItemsBean>> diagPopupMap = null;	
	
	HashMap<String,MFDRServicesAndItemsBean> masterMap = null;
	
	HashMap<String,String> restrictionMap = null;
	
	public HashMap<String, String> getRestrictionMap() {
		return restrictionMap;
	}
	public void setRestrictionMap(HashMap<String, String> restrictionMap) {
		this.restrictionMap = restrictionMap;
	}
	public HashMap<String, MFDRServicesAndItemsBean> getMasterMap() {
		return masterMap;
	}
	public void setMasterMap(HashMap<String, MFDRServicesAndItemsBean> masterMap) {
		this.masterMap = masterMap;
	}
	
	
	
	public List<MFDRServicesAndItemsBean> getPopupList() {
		return popupList;
	}
	public void setPopupList(List<MFDRServicesAndItemsBean> popupList) {
		this.popupList = popupList;
	}
	
	public HashMap<String, List<MFDRServicesAndItemsBean>> getPopupMap() {
		return popupMap;
	}
	public void setPopupMap(
			HashMap<String, List<MFDRServicesAndItemsBean>> popupMap) {
		this.popupMap = popupMap;
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
	
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	
	public String getLimitAmt() {
		return limitAmt;
	}
	public void setLimitAmt(String limitAmt) {
		this.limitAmt = limitAmt;
	}
	
	public String getPatClass() {
		return patClass;
	}
	public void setPatClass(String patClass) {
		this.patClass = patClass;
	}
	
	public String getEpisodeEncounter() {
		return episodeEncounter;
	}
	public void setEpisodeEncounter(String episodeEncounter) {
		this.episodeEncounter = episodeEncounter;
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

	public HashMap<String, List<MFDRServicesAndItemsBean>> getPolicyMap() {
		return policyMap;
	}
	public void setPolicyMap(HashMap<String, List<MFDRServicesAndItemsBean>> policyMap) {
		this.policyMap = policyMap;
	}
	public List<MFDRServicesAndItemsBean> getPolicyList() {
		return policyList;
	}
	public void setPolicyList(List<MFDRServicesAndItemsBean> policyList) {
		this.policyList = policyList;
	}

	public String getCalledfrom() {
		return Calledfrom;
	}
	public void setCalledfrom(String Calledfrom) {
		this.Calledfrom = Calledfrom;
	}
		
	public List<MFDRServicesAndItemsBean> getDiagPopupList() {
		return diagPopupList;
	}
	public void setDiagPopupList(List<MFDRServicesAndItemsBean> diagPopupList) {
		this.diagPopupList = diagPopupList;
	}
	
	public HashMap<String, List<MFDRServicesAndItemsBean>> getDiagPopupMap() {
		return diagPopupMap;
	}
	public void setDiagPopupMap(
			HashMap<String, List<MFDRServicesAndItemsBean>> diagPopupMap) {
		this.diagPopupMap = diagPopupMap;
	}
	
	public void clearAll(){
		policyMap = null;
		popupMap = null;
		policyList = null;
		popupList = null;
		masterMap = null;
		restrictionMap = null;
		facilityId = null; 
		payer = null;
		payerCode = null;
		payerGroup = null;
		payerGroupCode = null;
		
		startDate = null;
		endDate = null;
		policyType = null;
		policyTypeCode= null;
		limitAmt = null;
		
		patClass = null;
		episodeEncounter = null;

		status = null;
		amtGrossNet = null;
		rowNumber = null;
		patCopay = null;
		patLimitAmt = null;
		oldEndDate = null;
		
		
		diagPopupList = null;
		diagPopupMap = null;
		
		
	}
	
}
