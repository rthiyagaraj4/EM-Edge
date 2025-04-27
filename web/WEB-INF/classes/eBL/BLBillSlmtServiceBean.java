package eBL;


public class BLBillSlmtServiceBean implements Comparable<BLBillSlmtServiceBean> {
	


	private String billDocType="";
	private String billNumber="";
	private String serviceDate="";
	private String trxDocRef="";
	private String trxDocRefLineNum="";	
	private String trxDocRefSeqNum="";
	private String billingService="";
	private String updNetChargeAmt="";
	private String chargeAmt="";
	private String settledAmt="";
	private String inclusionExclusionCriteria="";
	
	public String getBillDocType() {
		return billDocType;
	}
	public void setBillDocType(String billDocType) {
		this.billDocType = billDocType;
	}
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public String getServiceDate() {
		return serviceDate;
	}
	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}
	public String getTrxDocRef() {
		return trxDocRef;
	}
	public void setTrxDocRef(String trxDocRef) {
		this.trxDocRef = trxDocRef;
	}
	public String getTrxDocRefLineNum() {
		return trxDocRefLineNum;
	}
	public void setTrxDocRefLineNum(String trxDocRefLineNum) {
		this.trxDocRefLineNum = trxDocRefLineNum;
	}
	public String getTrxDocRefSeqNum() {
		return trxDocRefSeqNum;
	}
	public void setTrxDocRefSeqNum(String trxDocRefSeqNum) {
		this.trxDocRefSeqNum = trxDocRefSeqNum;
	}
	public String getBillingService() {
		return billingService;
	}
	public void setBillingService(String billingService) {
		this.billingService = billingService;
	}
	public String getUpdNetChargeAmt() {
		return updNetChargeAmt;
	}
	public void setUpdNetChargeAmt(String updNetChargeAmt) {
		this.updNetChargeAmt = updNetChargeAmt;
	}
	public String getChargeAmt() {
		return chargeAmt;
	}
	public void setChargeAmt(String chargeAmt) {
		this.chargeAmt = chargeAmt;
	}
	public String getSettledAmt() {
		return settledAmt;
	}
	public void setSettledAmt(String settledAmt) {
		this.settledAmt = settledAmt;
	}
	public String getInclusionExclusionCriteria() {
		return inclusionExclusionCriteria;
	}
	public void setInclusionExclusionCriteria(String inclusionExclusionCriteria) {
		this.inclusionExclusionCriteria = inclusionExclusionCriteria;
	}
	
	@Override
	public String toString() {
		return "BLBillSlmtServiceBean [billDocType=" + billDocType
				+ ", billNumber=" + billNumber + ", serviceDate=" + serviceDate
				+ ", trxDocRef=" + trxDocRef + ", trxDocRefLineNum="
				+ trxDocRefLineNum + ", trxDocRefSeqNum=" + trxDocRefSeqNum
				+ ", billingService=" + billingService + ", updNetChargeAmt="
				+ updNetChargeAmt + ", chargeAmt=" + chargeAmt
				+ ", settledAmt=" + settledAmt
				+ ", inclusion_exclusionCriteria="
				+ inclusionExclusionCriteria + "]";
	}
	

	public int compareTo(BLBillSlmtServiceBean o) {		
        return this.getTrxDocRef().compareTo(o.getTrxDocRef());
	}
	


	
}
