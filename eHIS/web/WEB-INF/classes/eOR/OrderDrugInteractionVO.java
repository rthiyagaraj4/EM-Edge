package eOR;

import java.io.*; 

public class OrderDrugInteractionVO implements Serializable {
	
	
	String drugCode ="";
	String drugDesc ="";
	String drugRemarks ="";
	String drugRestrictYN ="";
	String overrideRemarks="";
	String drugStartDate="";
	String drugEndDate="";
	public String getDrugCode() {
		return drugCode;
	}
	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}
	public String getDrugDesc() {
		return drugDesc;
	}
	public void setDrugDesc(String drugDesc) {
		this.drugDesc = drugDesc;
	}
	public String getDrugRemarks() {
		return drugRemarks;
	}
	public void setDrugRemarks(String drugRemarks) {
		this.drugRemarks = drugRemarks;
	}
	public String getDrugRestrictYN() {
		return drugRestrictYN;
	}
	public void setDrugRestrictYN(String drugRestrictYN) {
		this.drugRestrictYN = drugRestrictYN;
	}
	public String getOverrideRemarks() {
		return overrideRemarks;
	}
	public void setOverrideRemarks(String overrideRemarks) {
		this.overrideRemarks = overrideRemarks;
	}
	public String getDrugStartDate() {
		return drugStartDate;
	}
	public void setDrugStartDate(String drugStartDate) {
		this.drugStartDate = drugStartDate;
	}
	public String getDrugEndDate() {
		return drugEndDate;
	}
	public void setDrugEndDate(String drugEndDate) {
		this.drugEndDate = drugEndDate;
	}
	
	

}
