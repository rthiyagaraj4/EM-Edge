package eBL; 

import java.io.Serializable;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import webbeans.eCommon.ConnectionManager;

import eBL.Common.BlAdapter;

public class BLBillDetailsBean extends BlAdapter implements Serializable {
	private String docTypeCode="";
	private String docNum="";
	private String docDate="";
	private String billTotAmt="";
	private String totOutStdAmt="";
	private String patientId="";
	private String episodeType="";
	private String episodeId="";
	private String visitId="";
	private String receiptNature="";
	private String receiptTypeCode="";
	private String extAccCode="";
	private String extAccDept="";
	private String excemptedAmt="";
	private String remSlmtAmt = "";
	private String billPrintYn = "";
	private String custCode = "";
	private String refundAmt= "";
	
	
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public String getRefundAmt() {
		return refundAmt;
	}
	public void setRefundAmt(String refundAmt) {
		this.refundAmt = refundAmt;
	}

	
	public String getBillPrintYn() {
		return billPrintYn;
	}
	public void setBillPrintYn(String billPrintYn) {
		this.billPrintYn = billPrintYn;
	}
	public String getRemSlmtAmt() {
		return remSlmtAmt;
	}
	public void setRemSlmtAmt(String remSlmtAmt) {
		this.remSlmtAmt = remSlmtAmt;
	}
	public String getExcemptedAmt() {
		return excemptedAmt;
	}
	public void setExcemptedAmt(String excemptedAmt) {
		this.excemptedAmt = excemptedAmt;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
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
	public String getReceiptNature() {
		return receiptNature;
	}
	public void setReceiptNature(String receiptNature) {
		this.receiptNature = receiptNature;
	}
	public String getReceiptTypeCode() {
		return receiptTypeCode;
	}
	public void setReceiptTypeCode(String receiptTypeCode) {
		this.receiptTypeCode = receiptTypeCode;
	}
	public String getExtAccCode() {
		return extAccCode;
	}
	public void setExtAccCode(String extAccCode) {
		this.extAccCode = extAccCode;
	}
	public String getExtAccDept() {
		return extAccDept;
	}
	public void setExtAccDept(String extAccDept) {
		this.extAccDept = extAccDept;
	}


	
	
	public String getDocTypeCode() {
		return docTypeCode;
	}
	public void setDocTypeCode(String docTypeCode) {
		this.docTypeCode = docTypeCode;
	}
	public String getDocNum() {
		return docNum;
	}
	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}
	public String getDocDate() {
		return docDate;
	}
	public void setDocDate(String docDate) {
		this.docDate = docDate;
	}
	public String getBillTotAmt() {
		return billTotAmt;
	}
	public void setBillTotAmt(String billTotAmt) {
		this.billTotAmt = billTotAmt;
	}
	public String getTotOutStdAmt() {
		return totOutStdAmt;
	}
	public void setTotOutStdAmt(String totOutStdAmt) {
		this.totOutStdAmt = totOutStdAmt;
	}
	

private HashMap<String, ArrayList<BLBillDetailsBean>> billDtlMap = null;
public HashMap<String, ArrayList<BLBillDetailsBean>> getBillDtlMap() {
	return billDtlMap;
}
public void setBillDtlMap(
		HashMap<String, ArrayList<BLBillDetailsBean>> billDtlMap) {
	this.billDtlMap = billDtlMap;
}


private HashMap<String, String> restrictionMap = null;
public HashMap<String, String> getRestrictionMap() {
	return restrictionMap;
}
public void setRestrictionMap(HashMap<String, String> restrictionMap) {
	this.restrictionMap = restrictionMap;
}
public HashMap<String,String> extAccDetailsFetch(Connection con,String strfacilityid,String strbilldoctypecode,String strbilldocnum ) throws SQLException{
	CallableStatement call = null;
	HashMap<String,String> extAcctMap=new HashMap<String,String> ();
	try {
		call = con.prepareCall("{ call blopin.proc_ext_acc_serv_group_check (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		call.setString(1,strfacilityid);
		call.setString(2,strbilldoctypecode);
		call.setString(3,strbilldocnum);
		call.setString(4,"BI");//P_RECEIPT_NATURE_CODE
		call.registerOutParameter(5,java.sql.Types.VARCHAR);	
		call.registerOutParameter(6,java.sql.Types.VARCHAR);	
		call.registerOutParameter(7,java.sql.Types.VARCHAR);	
		call.registerOutParameter(8,java.sql.Types.VARCHAR);	
		call.registerOutParameter(9,java.sql.Types.VARCHAR);	
		call.registerOutParameter(10,java.sql.Types.VARCHAR);	
		call.registerOutParameter(11,java.sql.Types.VARCHAR);	
		call.registerOutParameter(12,java.sql.Types.VARCHAR);	
		call.registerOutParameter(13,java.sql.Types.VARCHAR);	
		call.registerOutParameter(14,java.sql.Types.VARCHAR);	
		call.registerOutParameter(15,java.sql.Types.VARCHAR);	
		call.registerOutParameter(16,java.sql.Types.VARCHAR);	
		call.registerOutParameter(17,java.sql.Types.VARCHAR);	
		
		call.execute();	
		String str_receipt_type_code	 = call.getString(5);	
		String str_ext_account_code	 = call.getString(7);	
		String str_ext_dept_code     	 = call.getString(9);
		if (str_receipt_type_code == null) str_receipt_type_code = "";
		if (str_ext_account_code == null) str_ext_account_code = "";
		if (str_ext_dept_code == null) str_ext_dept_code = "";
		
		extAcctMap.put("receipt_nature", "BI");
		extAcctMap.put("receipt_type_code", str_receipt_type_code);
		extAcctMap.put("ext_account_code", str_ext_account_code);
		extAcctMap.put("ext_dept_code", str_ext_dept_code);

	} catch (SQLException e) {
		System.out.println("Error in BLBillDetailsBean blopin.proc_ext_acc_serv_group_check");
	}finally{			
		call.close();
	}
	return extAcctMap;	
}

@Override
public String toString() {
	return "BLBillDetailsBean [docTypeCode=" + docTypeCode + ", docNum="
			+ docNum + ", docDate=" + docDate + ", billTotAmt=" + billTotAmt
			+ ", totOutStdAmt=" + totOutStdAmt + ", patientId=" + patientId
			+ ", episodeType=" + episodeType + ", episodeId=" + episodeId
			+ ", visitId=" + visitId + ", receiptNature=" + receiptNature
			+ ", receiptTypeCode=" + receiptTypeCode + ", extAccCode="
			+ extAccCode + ", extAccDept=" + extAccDept + ", billDtlMap="
			+ billDtlMap + ", excemptedAmt"+ excemptedAmt +", restrictionMap=" + restrictionMap + "]";
}
}
