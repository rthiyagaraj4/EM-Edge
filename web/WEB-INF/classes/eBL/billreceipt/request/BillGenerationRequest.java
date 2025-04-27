/*
Sr No        Version           TFS/Incident        SCF/CRF            		 			Developer Name
--------------------------------------------------------------------------------------------------------
1            V210129            13523         MOHE-CRF-0060       						Shikha Seth
--------------------------------------------------------------------------------------------------------
 */
package eBL.billreceipt.request;

import eBL.billreceipt.common.request.BaseRequest;

public class BillGenerationRequest extends BaseRequest{

	private String cashCntrCode = "";
	private String shiftId = "";
	private String prevUnBilled = "";
	private String sessionId = "";
	private String servLocn = "";
	private String depAdjYn = "";
	private String prePayAdjYn = "";
	private String minDepAdjYn = "";
	private String pkgSeqNo = "";
	
	private String docAmt = "";
	private String vstTypeCode = "";
	private String pkgClosedYn = "";
	
	private String approxPatAmt = "";
	private String slmtAmt = "";
	private String deposits = "";
	private String patAmt = "";
	
	private String exemptAmt = "";
	private String payerAmt = "";
	
	private String billGenOpt = "";
	private String billGenType = "";
	private String refDepAdj = "";
	private String refDepBal = "";
	private String refprePayAdj = "";
	private String refprePaybal = "";
	private String depAjustedYn  = "";
	private String preAjustedYn = "";
	private String altIdType="";
	private String altIdNo="";
	private String patientName="";
	private String remarks="";
	private String prevDepAdjAmt = "";
	private String prevPreAdjAmt = "";
	private String exemptType="";
	private String locale="";
	private String assignTo="";
	private String ipBillType = "";
	private String totalCount = "";
	//V210129 start
	private String encounterFacilityId ="";
	public String getEncounterFacilityId() {
		return encounterFacilityId;
	}
	public void setEncounterFacilityId(String encounterFacilityId) {
		this.encounterFacilityId = encounterFacilityId;
	}
	//V210129 end
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	public String getPackageCode() {
		return packageCode;
	}
	public void setPackageCode(String packageCode) {
		this.packageCode = packageCode;
	}
	private String packageCode = "";
	
	
	
	public String getIpBillType() {
		return ipBillType;
	}
	public void setIpBillType(String ipBillType) {
		this.ipBillType = ipBillType;
	}
	public String getExemptType() {
		return exemptType;
	}
	public void setExemptType(String exemptType) {
		this.exemptType = exemptType;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getAssignTo() {
		return assignTo;
	}
	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}
	public String getPrevDepAdjAmt() {
		return prevDepAdjAmt;
	}
	public void setPrevDepAdjAmt(String prevDepAdjAmt) {
		this.prevDepAdjAmt = prevDepAdjAmt;
	}
	public String getPrevPreAdjAmt() {
		return prevPreAdjAmt;
	}
	public void setPrevPreAdjAmt(String prevPreAdjAmt) {
		this.prevPreAdjAmt = prevPreAdjAmt;
	}
	public String getAltIdType() {
		return altIdType;
	}
	public void setAltIdType(String altIdType) {
		this.altIdType = altIdType;
	}
	public String getAltIdNo() {
		return altIdNo;
	}
	public void setAltIdNo(String altIdNo) {
		this.altIdNo = altIdNo;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getDepAjustedYn() {
		return depAjustedYn;
	}
	public void setDepAjustedYn(String depAjustedYn) {
		this.depAjustedYn = depAjustedYn;
	}
	public String getPreAjustedYn() {
		return preAjustedYn;
	}
	public void setPreAjustedYn(String preAjustedYn) {
		this.preAjustedYn = preAjustedYn;
	}

	
	public String getRefDepAdj() {
		return refDepAdj;
	}
	public void setRefDepAdj(String refDepAdj) {
		this.refDepAdj = refDepAdj;
	}
	public String getRefDepBal() {
		return refDepBal;
	}
	public void setRefDepBal(String refDepBal) {
		this.refDepBal = refDepBal;
	}
	public String getRefprePayAdj() {
		return refprePayAdj;
	}
	public void setRefprePayAdj(String refprePayAdj) {
		this.refprePayAdj = refprePayAdj;
	}
	public String getRefprePaybal() {
		return refprePaybal;
	}
	public void setRefprePaybal(String refprePaybal) {
		this.refprePaybal = refprePaybal;
	}
	
	
	public String getBillGenOpt() {
		return billGenOpt;
	}
	public void setBillGenOpt(String billGenOpt) {
		this.billGenOpt = billGenOpt;
	}
	public String getBillGenType() {
		return billGenType;
	}
	public void setBillGenType(String billGenType) {
		this.billGenType = billGenType;
	}
	public String getExemptAmt() {
		return exemptAmt;
	}
	public void setExemptAmt(String exemptAmt) {
		this.exemptAmt = exemptAmt;
	}
	public String getPayerAmt() {
		return payerAmt;
	}
	public void setPayerAmt(String payerAmt) {
		this.payerAmt = payerAmt;
	}
	public String getPkgClosedYn() {
		return pkgClosedYn;
	}
	public void setPkgClosedYn(String pkgClosedYn) {
		this.pkgClosedYn = pkgClosedYn;
	}
	public String getCashCntrCode() {
		return cashCntrCode;
	}
	public void setCashCntrCode(String cashCntrCode) {
		this.cashCntrCode = cashCntrCode;
	}
	public String getShiftId() {
		return shiftId;
	}
	public void setShiftId(String shiftId) {
		this.shiftId = shiftId;
	}
	public String getPrevUnBilled() {
		return prevUnBilled;
	}
	public void setPrevUnBilled(String prevUnBilled) {
		this.prevUnBilled = prevUnBilled;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getServLocn() {
		return servLocn;
	}
	public void setServLocn(String servLocn) {
		this.servLocn = servLocn;
	}
	public String getDepAdjYn() {
		return depAdjYn;
	}
	public void setDepAdjYn(String depAdjYn) {
		this.depAdjYn = depAdjYn;
	}
	public String getPrePayAdjYn() {
		return prePayAdjYn;
	}
	public void setPrePayAdjYn(String prePayAdjYn) {
		this.prePayAdjYn = prePayAdjYn;
	}
	public String getMinDepAdjYn() {
		return minDepAdjYn;
	}
	public void setMinDepAdjYn(String minDepAdjYn) {
		this.minDepAdjYn = minDepAdjYn;
	}
	public String getPkgSeqNo() {
		return pkgSeqNo;
	}
	public void setPkgSeqNo(String pkgSeqNo) {
		this.pkgSeqNo = pkgSeqNo;
	}
	public String getDocAmt() {
		return docAmt;
	}
	public void setDocAmt(String docAmt) {
		this.docAmt = docAmt;
	}
	public String getVstTypeCode() {
		return vstTypeCode;
	}
	public void setVstTypeCode(String vstTypeCode) {
		this.vstTypeCode = vstTypeCode;
	}

	
	public String getApproxPatAmt() {
		return approxPatAmt;
	}
	public void setApproxPatAmt(String approxPatAmt) {
		this.approxPatAmt = approxPatAmt;
	}
	public String getSlmtAmt() {
		return slmtAmt;
	}
	public void setSlmtAmt(String slmtAmt) {
		this.slmtAmt = slmtAmt;
	}
	public String getDeposits() {
		return deposits;
	}
	public void setDeposits(String deposits) {
		this.deposits = deposits;
	}
	
	
	public String getPatAmt() {
		return patAmt;
	}
	public void setPatAmt(String patAmt) {
		this.patAmt = patAmt;
	}
	
	
	
}
