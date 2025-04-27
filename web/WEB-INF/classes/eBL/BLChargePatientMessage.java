package eBL;

import java.io.Serializable;
import java.util.List;

import eBL.Common.BlAdapter;

public class BLChargePatientMessage extends BlAdapter implements Serializable {

	private String code = "";
	private String trxDoc = "";
	private String blngServ = "";
	
	List<BLChargePatientMessage>  errorList = null;
	List<BLChargePatientMessage>  warningList = null;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTrxDoc() {
		return trxDoc;
	}
	public void setTrxDoc(String trxDoc) {
		this.trxDoc = trxDoc;
	}
	public String getBlngServ() {
		return blngServ;
	}
	public void setBlngServ(String blngServ) {
		this.blngServ = blngServ;
	}
	public List<BLChargePatientMessage> getErrorList() {
		return errorList;
	}
	public void setErrorList(List<BLChargePatientMessage> errorList) {
		this.errorList = errorList;
	}
	public List<BLChargePatientMessage> getWarningList() {
		return warningList;
	}
	public void setWarningList(List<BLChargePatientMessage> warningList) {
		this.warningList = warningList;
	}
	
	public void clearAll(){
		code = "";
		trxDoc = "";
		blngServ = "";
		
		errorList = null;
		warningList = null;
	}
}
