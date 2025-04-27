package eBL.billreceipt.request;

import java.util.List;

import eBL.billreceipt.common.request.BaseRequest;
import eBL.billreceipt.model.BillReceiptPackageInfo;

public class BillReceiptRequest extends BaseRequest{

	private String functionId = "";
	private String uptoCalDate = "";
	private String admDateTime = "";
	private String dischDateTime = "";
	private String ipChkOutBasisInd = "";
	private String suppressDischarge = "";
	private String trxDocRef = "";
	private String trxDocRefLine = "";
	private String excludeInBill = "";
	private String blngServSeparate = "";	
	private String trxDocRefSeq = "";
	private String servCode = "";
	private String pkgSeqNo = "";
	
	
	public String getPkgSeqNo() {
		return pkgSeqNo;
	}

	public void setPkgSeqNo(String pkgSeqNo) {
		this.pkgSeqNo = pkgSeqNo;
	}

	public String getServCode() {
		return servCode;
	}

	public void setServCode(String servCode) {
		this.servCode = servCode;
	}

	public String getTrxDocRefSeq() {
		return trxDocRefSeq;
	}

	public void setTrxDocRefSeq(String trxDocRefSeq) {
		this.trxDocRefSeq = trxDocRefSeq;
	}

	public String getTrxDocRef() {
		return trxDocRef;
	}

	public void setTrxDocRef(String trxDocRef) {
		this.trxDocRef = trxDocRef;
	}

	public String getTrxDocRefLine() {
		return trxDocRefLine;
	}

	public void setTrxDocRefLine(String trxDocRefLine) {
		this.trxDocRefLine = trxDocRefLine;
	}

	public String getExcludeInBill() {
		return excludeInBill;
	}

	public void setExcludeInBill(String excludeInBill) {
		this.excludeInBill = excludeInBill;
	}

	public String getBlngServSeparate() {
		return blngServSeparate;
	}

	public void setBlngServSeparate(String blngServSeparate) {
		this.blngServSeparate = blngServSeparate;
	}

	public String getSuppressDischarge() {
		return suppressDischarge;
	}

	public void setSuppressDischarge(String suppressDischarge) {
		this.suppressDischarge = suppressDischarge;
	}

	public String getIpChkOutBasisInd() {
		return ipChkOutBasisInd;
	}

	public void setIpChkOutBasisInd(String ipChkOutBasisInd) {
		this.ipChkOutBasisInd = ipChkOutBasisInd;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public String getUptoCalDate() {
		return uptoCalDate;
	}

	public void setUptoCalDate(String uptoCalDate) {
		this.uptoCalDate = uptoCalDate;
	}

	public String getAdmDateTime() {
		return admDateTime;
	}

	public void setAdmDateTime(String admDateTime) {
		this.admDateTime = admDateTime;
	}

	public String getDischDateTime() {
		return dischDateTime;
	}

	public void setDischDateTime(String dischDateTime) {
		this.dischDateTime = dischDateTime;
	}

	private List<BillReceiptPackageInfo> pkgList = null;

	public List<BillReceiptPackageInfo> getPkgList() {
		return pkgList;
	}

	public void setPkgList(List<BillReceiptPackageInfo> pkgList) {
		this.pkgList = pkgList;
	}
	
	
}
