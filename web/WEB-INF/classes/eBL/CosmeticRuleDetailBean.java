/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

public class CosmeticRuleDetailBean {
	
	private String servType = "";
	private String servCode = "";
	private String inclExclYN = "";
	private String status = "";
	private String isDelFlagYN = "";
	private String servDesc = "";
	
	public String getServDesc() {
		return servDesc;
	}
	public void setServDesc(String servDesc) {
		this.servDesc = servDesc;
	}
	public String getServType() {
		return servType;
	}
	public void setServType(String servType) {
		this.servType = servType;
	}
	public String getServCode() {
		return servCode;
	}
	public void setServCode(String servCode) {
		this.servCode = servCode;
	}
	public String getInclExclYN() {
		return inclExclYN;
	}
	public void setInclExclYN(String inclExclYN) {
		this.inclExclYN = inclExclYN;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIsDelFlagYN() {
		return isDelFlagYN;
	}
	public void setIsDelFlagYN(String isDelFlagYN) {
		this.isDelFlagYN = isDelFlagYN;
	}
	
	
}
