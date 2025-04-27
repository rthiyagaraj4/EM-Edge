/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS;

public class SterlizeWashBean {
	private String sterilizeType;
	private String washType;
	private String packItemCode;
	private String packItemQty;

	public SterlizeWashBean(String sterilizeType, String washType, String packItemCode, String packItemQty) {
		this.sterilizeType = sterilizeType;
		this.washType = washType;    
		this.packItemCode = packItemCode;
		this.packItemQty = packItemQty;   
	}

	public String getSterilizeType() {
		return this.sterilizeType;
	}

	public String getWashType() {
		return this.washType;
	}

	public String getPackItemCode() {
		return this.packItemCode;
	}

	public String getPackItemQty() {
		return this.packItemQty;
	}
}
