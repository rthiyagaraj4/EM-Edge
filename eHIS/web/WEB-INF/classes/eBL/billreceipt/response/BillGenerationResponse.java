package eBL.billreceipt.response;

import java.util.List;

import eBL.billreceipt.common.response.BaseResponse;

public class BillGenerationResponse extends BaseResponse{
	
	private String unProcessedExists = "";
	private String billDocTypeCode = "";
	private String receiptDocTypeCode = "";
	private String refundDocTypeCode = "";
	private String billPrintYn = "";
	private String session_id ="";
	private String pgm_id ="";
	private String pgm_date ="";
	private String exemptWarning="";
	private String exemptConsWarning="";
	private String slmtValidationMsg="";
	
	public String getSlmtValidationMsg() {
		return slmtValidationMsg;
	}

	public void setSlmtValidationMsg(String slmtValidationMsg) {
		this.slmtValidationMsg = slmtValidationMsg;
	}

	public String getExemptWarning() {
		return exemptWarning;
	}

	public void setExemptWarning(String exemptWarning) {
		this.exemptWarning = exemptWarning;
	}

	public String getExemptConsWarning() {
		return exemptConsWarning;
	}

	public void setExemptConsWarning(String exemptConsWarning) {
		this.exemptConsWarning = exemptConsWarning;
	}

	public String getBillPrintYn() {
		return billPrintYn;
	}

	public void setBillPrintYn(String billPrintYn) {
		this.billPrintYn = billPrintYn;
	}

	private List<String> errorList = null;	

	public String getUnProcessedExists() {
		return unProcessedExists;
	}

	public void setUnProcessedExists(String unProcessedExists) {
		this.unProcessedExists = unProcessedExists;
	}

	public String getBillDocTypeCode() {
		return billDocTypeCode;
	}

	public void setBillDocTypeCode(String billDocTypeCode) {
		this.billDocTypeCode = billDocTypeCode;
	}

	public String getReceiptDocTypeCode() {
		return receiptDocTypeCode;
	}

	public void setReceiptDocTypeCode(String receiptDocTypeCode) {
		this.receiptDocTypeCode = receiptDocTypeCode;
	}

	public String getRefundDocTypeCode() {
		return refundDocTypeCode;
	}

	public void setRefundDocTypeCode(String refundDocTypeCode) {
		this.refundDocTypeCode = refundDocTypeCode;
	}

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}
	
	private String patDocType = "";
	private String patDocNum = "";
	private String generatedBillS = "";
	private String invokeSlmt = "";

	public String getInvokeSlmt() {
		return invokeSlmt;
	}

	public void setInvokeSlmt(String invokeSlmt) {
		this.invokeSlmt = invokeSlmt;
	}

	public String getPatDocType() {
		return patDocType;
	}

	public void setPatDocType(String patDocType) {
		this.patDocType = patDocType;
	}

	public String getPatDocNum() {
		return patDocNum;
	}

	public void setPatDocNum(String patDocNum) {
		this.patDocNum = patDocNum;
	}

	public String getGeneratedBillS() {
		return generatedBillS;
	}

	public void setGeneratedBillS(String generatedBillS) {
		this.generatedBillS = generatedBillS;
	}
	public String getSession_id() {
		return session_id;
	}
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}
	public String getPgm_id() {
		return pgm_id;
	}
	public void setPgm_id(String pgm_id) {
		this.pgm_id = pgm_id;
	}
	public String getPgm_date() {
		return pgm_date;
	}
	public void setPgm_date(String pgm_date) {
		this.pgm_date = pgm_date;
	}
	
	
}
