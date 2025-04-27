package eBL.billreceipt.response;

import java.util.List;

import eBL.billreceipt.common.response.BaseResponse;
import eBL.billreceipt.model.BillReceiptCustomerDetails;
import eBL.billreceipt.model.BillReceiptServiceDetails;
import eBL.billreceipt.model.BillReceiptSummaryBean;

public class BillReceiptResponse extends BaseResponse {

	private String getPackageCount = "";
	private String serviceTypeCode = "";
	private String pkgCheck = "";
	
	public String getPkgCheck() {
		return pkgCheck;
	}
	public void setPkgCheck(String pkgCheck) {
		this.pkgCheck = pkgCheck;
	}
	public String getServiceTypeCode() {
		return serviceTypeCode;
	}
	public void setServiceTypeCode(String serviceTypeCode) {
		this.serviceTypeCode = serviceTypeCode;
	}
	public String getGetPackageCount() {
		return getPackageCount;
	}
	public void setGetPackageCount(String getPackageCount) {
		this.getPackageCount = getPackageCount;
	}
	List<BillReceiptCustomerDetails> custList = null;
	List<BillReceiptServiceDetails> serviceList = null;
	List<BillReceiptServiceDetails> refServiceList = null;
	public List<BillReceiptServiceDetails> getRefServiceList() {
		return refServiceList;
	}
	public void setRefServiceList(List<BillReceiptServiceDetails> refServiceList) {
		this.refServiceList = refServiceList;
	}
	BillReceiptSummaryBean summBean = null;
	public BillReceiptSummaryBean getSummBean() {
		return summBean;
	}
	public void setSummBean(BillReceiptSummaryBean summBean) {
		this.summBean = summBean;
	}
	public List<BillReceiptCustomerDetails> getCustList() {
		return custList;
	}
	public void setCustList(List<BillReceiptCustomerDetails> custList) {
		this.custList = custList;
	}
	public List<BillReceiptServiceDetails> getServiceList() {
		return serviceList;
	}
	public void setServiceList(List<BillReceiptServiceDetails> serviceList) {
		this.serviceList = serviceList;
	}
	
	private String errorCheck = "";
	public String getErrorCheck() {
		return errorCheck;
	}
	public void setErrorCheck(String errorCheck) {
		this.errorCheck = errorCheck;
	}
	
	private String error = "";
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	private String splDepYN = "";
	public String getSplDepYN() {
		return splDepYN;
	}
	public void setSplDepYN(String splDepYN) {
		this.splDepYN = splDepYN;
	}
	
	private String warning = "";
	public String getWarning() {
		return warning;
	}
	public void setWarning(String warning) {
		this.warning = warning;
	}
	
	private int totalRecordCount = 0;
	public int getTotalRecordCount() {
		return totalRecordCount;
	}
	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}
}
