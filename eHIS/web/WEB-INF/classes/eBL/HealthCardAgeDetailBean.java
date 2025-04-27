/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.io.Serializable;



public class HealthCardAgeDetailBean implements
		Serializable {
	
	private static final long serialVersionUID = 1L;
	int minAgeInYrs=0;  
	int minAgeInMths=0;          
	int minAgeInDays=0;
	int maxAgeInYrs=0;  
	int maxAgeInMths=0;          
	int maxAgeInDays=0;       
	String priceClassCode=new String();            
	String membershipFeesCode=new String();
	String priceClassCodeDescription=new String();
	String membershipFeesCodeDescription=new String();

	      
	public int getMinAgeInYrs() {
		return minAgeInYrs;
	}

	public void setMinAgeInYrs(int minAgeInYrs) {
		this.minAgeInYrs = minAgeInYrs;
	}

	public int getMinAgeInMths() {
		return minAgeInMths;
	}

	public void setMinAgeInMths(int minAgeInMths) {
		this.minAgeInMths = minAgeInMths;
	}

	public int getMinAgeInDays() {
		return minAgeInDays;
	}

	public void setMinAgeInDays(int minAgeInDays) {
		this.minAgeInDays = minAgeInDays;
	}

	public int getMaxAgeInYrs() {
		return maxAgeInYrs;
	}

	public void setMaxAgeInYrs(int maxAgeInYrs) {
		this.maxAgeInYrs = maxAgeInYrs;
	}

	public int getMaxAgeInMths() {
		return maxAgeInMths;
	}

	public void setMaxAgeInMths(int maxAgeInMths) {
		this.maxAgeInMths = maxAgeInMths;
	}

	public int getMaxAgeInDays() {
		return maxAgeInDays;
	}

	public void setMaxAgeInDays(int maxAgeInDays) {
		this.maxAgeInDays = maxAgeInDays;
	}

	public String getPriceClassCode() {
		return priceClassCode;
	}

	public void setPriceClassCode(String priceClassCode) {
		this.priceClassCode = priceClassCode;
	}

	public String getMembershipFeesCode() {
		return membershipFeesCode;
	}

	public void setMembershipFeesCode(String membershipFeesCode) {
		this.membershipFeesCode = membershipFeesCode;
	}
	public String getPriceClassCodeDescription() {
		return priceClassCodeDescription;
	}

	public void setPriceClassCodeDescription(String priceClassCodeDescription) {
		this.priceClassCodeDescription = priceClassCodeDescription;
	}

	public String getMembershipFeesCodeDescription() {
		return membershipFeesCodeDescription;
	}

	public void setMembershipFeesCodeDescription(
			String membershipFeesCodeDescription) {
		this.membershipFeesCodeDescription = membershipFeesCodeDescription;
	}


	public String toString(){
		return    "{minAgeInYrs="		+ minAgeInYrs 
				+ ",minAgeInMths=" 		+ minAgeInMths
				+ ",minAgeInDays=" 		+ minAgeInDays
				+ ",maxAgeInYrs=" 		+ maxAgeInYrs 
				+ ",maxAgeInMths=" 		+ maxAgeInMths 
				+ ",maxAgeInDays=" 		+ maxAgeInDays 
				+ ",priceClassCode=" 	+ priceClassCode
				+ ",membershipFeesCode="+ membershipFeesCode 
				+ ",priceClassCodeDescription=" 	+ priceClassCodeDescription 
				+ ",membershipFeesCodeDescription=" + membershipFeesCodeDescription 
				+ "}";
	}
	
	public boolean equals(HealthCardAgeDetailBean paramBean) {
		if (this.getMaxAgeInDays()==paramBean.getMaxAgeInDays()
			&& this.getMaxAgeInMths()==paramBean.getMaxAgeInMths()
			&& this.getMaxAgeInYrs()==paramBean.getMaxAgeInYrs()			
			&& this.getMinAgeInDays()==paramBean.getMinAgeInDays()
			&& this.getMinAgeInMths()==paramBean.getMinAgeInMths()			
			&& this.getMinAgeInYrs()==paramBean.getMinAgeInYrs()			
			&& this.getMembershipFeesCode().equals(paramBean.getMembershipFeesCode())			
			&& this.getPriceClassCode().equals(paramBean.getPriceClassCode())) {
				return true;
			}
		return false;
	}

	public int hashCode() {
		return this.priceClassCode.hashCode() + this.membershipFeesCode.hashCode() +minAgeInYrs+minAgeInMths+minAgeInDays+maxAgeInYrs+maxAgeInMths+maxAgeInDays ;
	}

}
