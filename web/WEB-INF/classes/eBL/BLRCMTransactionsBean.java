package eBL;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import eCommon.Common.CommonAdapter;
import webbeans.eCommon.ConnectionManager;
import java.io.*;
import java.util.*;
import java.sql.*;
import eBL.Common.*;
import webbeans.eCommon.*;
import java.text.*;

import eBL.Common.BlAdapter;
import eBL.Common.BlRepository;

public class BLRCMTransactionsBean extends BlAdapter implements Serializable {

	private String facilityId;
	private String payerCode;
	private String payerGroupCode;
	private String policyTypeCode;
	private String apprDocRefNum;
	private String claimID;
	private String episodeType;
	private String encounterId;
	private String visitAdmitDt;
	private String checkoutDiscDt;
	private String patientId;
	private String patientName;
	private String billDocTypeCode;
	private String billNum;
	private String netBillAmt;
	private String apprBillAmt;
	private String receiptDocRefNum;
	private String billRemarks;
	private String claimStatus;
	private String checkedStatus;
	private String claims_services_level;
	private String StateDurFrom;
	private String StateDurTo;
	private String apprTotalRec;
	private String billTotalRec;
	private String membershipNo;
	private String fileName;
	
	
	HashMap<String, List<BLRCMTransactionsBean>> policyMap = null;
	List<BLRCMTransactionsBean> policyList = null;
	
	public HashMap<String, List<BLRCMTransactionsBean>> getPolicyMap() {
		return policyMap;
	}
	public void setPolicyMap(HashMap<String, List<BLRCMTransactionsBean>> policyMap) {
		this.policyMap = policyMap;
	}
		
	public String getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}
	
	public String getPayerGroupCode() {
		return payerGroupCode;
	}
	public void setPayerGroupCode(String payerGroupCode) {
		this.payerGroupCode = payerGroupCode;
	}
	
	public String getPayerCode() {
		return payerCode;
	}
	public void setPayerCode(String payerCode) {
		this.payerCode = payerCode;
	}
	
	public String getPolicyTypeCode() {
		return policyTypeCode;
	}
	public void setPolicyTypeCode(String policyTypeCode) {
		this.policyTypeCode = policyTypeCode;
	}
	
	public String getApprDocRefNum() {
		return apprDocRefNum;
	}
	public void setApprDocRefNum(String apprDocRefNum) {
		this.apprDocRefNum = apprDocRefNum;
	}
	
	public String getClaimID() {
		return claimID;
	}
	public void setClaimID(String claimID) {
		this.claimID = claimID;
	}
	
	public String getEpisodeType() {
		return episodeType;
	}
	public void setEpisodeType(String episodeType) {
		this.episodeType = episodeType;
	}
	
	public String getEncounterId() {
		return encounterId;
	}
	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
	}
	
	public String getVisitAdmitDt() {
		return visitAdmitDt;
	}
	public void setVisitAdmitDt(String visitAdmitDt) {
		this.visitAdmitDt = visitAdmitDt;
	}
	
	public String getCheckoutDiscDt() {
		return checkoutDiscDt;
	}
	public void setCheckoutDiscDt(String checkoutDiscDt) {
		this.checkoutDiscDt = checkoutDiscDt;
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
	
	public String getBillDocTypeCode() {
		return billDocTypeCode;
	}
	public void setBillDocTypeCode(String billDocTypeCode) {
		this.billDocTypeCode = billDocTypeCode;
	}
	
	public String getBillNum() {
		return billNum;
	}
	public void setBillNum(String billNum) {
		this.billNum = billNum;
	}
	
	public String getNetBillAmt() {
		return netBillAmt;
	}
	public void setNetBillAmt(String netBillAmt) {
		this.netBillAmt = netBillAmt;
	}
	
	public String getApprBillAmt() {
		return apprBillAmt;
	}
	public void setApprBillAmt(String apprBillAmt) {
		this.apprBillAmt = apprBillAmt;
	}
	public String getReceiptDocRefNum() {
		return receiptDocRefNum;
	}
	public void setReceiptDocRefNum(String receiptDocRefNum) {
		this.receiptDocRefNum = receiptDocRefNum;
	}
	public String getBillRemarks() {
		return billRemarks;
	}
	public void setBillRemarks(String billRemarks) {
		this.billRemarks = billRemarks;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public String getCheckedStatus() {
		return checkedStatus;
	}
	public void setCheckedStatus(String checkedStatus) {
		this.checkedStatus = checkedStatus;
	}
	
	public String getClaimsServicesLevel() {
		return claims_services_level;
	}
	public void setClaimsServicesLevel(String claims_services_level) {
		this.claims_services_level = claims_services_level;
	}
	
	public String getStateDurFrom() {
		return StateDurFrom;
	}
	public void setStateDurFrom(String StateDurFrom) {
		this.StateDurFrom = StateDurFrom;
	}
	
	public String getStateDurTo() {
		return StateDurTo;
	}
	public void setStateDurTo(String StateDurTo) {
		this.StateDurTo = StateDurTo;
	}
	
	public String getApprTotalRec() {
		return apprTotalRec;
	}
	public void setApprTotalRec(String apprTotalRec) {
		this.apprTotalRec = apprTotalRec;
	}
	
	public String getBillTotalRec() {
		return billTotalRec;
	}
	public void setBillTotalRec(String billTotalRec) {
		this.billTotalRec = billTotalRec;
	}
	
	public String getMembershipNo() {
		return membershipNo;
	}
	public void setMembershipNo(String membershipNo) {
		this.membershipNo = membershipNo;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
		
	// Added for MOHE-CRF-0114 Ends
	public void clearAll(){
		
		policyMap = null;
		policyList = null;
		facilityId = null;
		payerCode = null;
		payerGroupCode = null;
		policyTypeCode = null;
		apprDocRefNum = null;
		claimID = null;
		episodeType = null;
		encounterId = null;
		visitAdmitDt = null;
		checkoutDiscDt = null;
		patientId = null;
		patientName = null;
		billDocTypeCode = null;
		billNum = null; 
		netBillAmt = null;
		apprBillAmt = null;
		receiptDocRefNum = null;
		billRemarks = null;
		claimStatus = null;
		checkedStatus = null;
		claims_services_level = null;
		StateDurFrom = null;
		StateDurTo = null;
		apprTotalRec = null;
		billTotalRec = null;	
		membershipNo = null;
		fileName = null;
		
	}
	
}
