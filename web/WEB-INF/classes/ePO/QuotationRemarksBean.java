/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePO;


import java.io.Serializable;

public class QuotationRemarksBean implements Serializable {
	private String item_code;
	private String master_code;
	private String remarks;
	private String remarks_code;

	public QuotationRemarksBean() {
	}
	
	    

	public QuotationRemarksBean(String item_code, String master_code, String remarks,String remarks_code) {
		this.item_code = item_code;
		this.master_code = master_code;
		this.remarks = remarks;
		this.remarks_code = remarks_code;  
	}

	public void setItem_code(String item_code) {	
		this.item_code = item_code;
	}

	public String getItem_code() {	
		return this.item_code;
	}

	public void setMaster_code(String master_code) {	
		this.master_code = master_code;
	}

	public String getMaster_code() {	
		return this.master_code;
	}

	public void setRemarks(String remarks) {	
		this.remarks = remarks;
	}
	
	public String getRemarks() {
		return this.remarks;   
	}
	
	public void setRemarks_code(String remarks_code) {	
		this.remarks_code = remarks_code;
	}
	
	public String getRemarks_code() {
		return this.remarks_code;   
	}

	public String toString() {
		return item_code + " = " +master_code + " = " + remarks ; //+  " = " +remarks_code;
	}
}
