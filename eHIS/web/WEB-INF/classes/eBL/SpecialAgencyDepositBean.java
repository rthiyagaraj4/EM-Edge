package eBL;

import java.io.Serializable;

import eBL.Common.BlAdapter;

public class SpecialAgencyDepositBean extends   BlAdapter implements Serializable{

    
    private String depositType = "";
    private String depositAmt = "";
    private String utilizedAmt = "";
    private String balance = "";
    private String effFrom = "";
    private String effTo = "";
    
    
	public String getDepositType() {
		return depositType;
	}
	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}
	public String getDepositAmt() {
		return depositAmt;
	}
	public void setDepositAmt(String depositAmt) {
		this.depositAmt = depositAmt;
	}
	public String getUtilizedAmt() {
		return utilizedAmt;
	}
	public void setUtilizedAmt(String utilizedAmt) {
		this.utilizedAmt = utilizedAmt;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getEffFrom() {
		return effFrom;
	}
	public void setEffFrom(String effFrom) {
		this.effFrom = effFrom;
	}
	public String getEffTo() {
		return effTo;
	}
	public void setEffTo(String effTo) {
		this.effTo = effTo;
	}
    
	
	
	
}
