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

public class STPOCancelOrderRemarksBean implements Serializable {
	private String po_order_mode;
	private String po_no;
	private String remarks;

	public STPOCancelOrderRemarksBean() {
	}
	
	    

	public STPOCancelOrderRemarksBean(String po_order_mode, String po_no, String remarks) {
		this.po_order_mode = po_order_mode;
		this.po_no = po_no;
		this.remarks = remarks;
	}

	public void setDoc_type_code(String po_order_mode) {	
		this.po_order_mode = po_order_mode;
	}

	public String getDoc_type_code() {	
		return this.po_order_mode;
	}

	public void setDoc_no(String po_no) {	
		this.po_no = po_no;
	}

	public String getDoc_no() {	
		return this.po_no;
	}

	public void setRemarks(String remarks) {	
		this.remarks = remarks;
	}
	
	public String getRemarks() {
		return this.remarks;   
	}

	public String toString() {
		return po_order_mode + " = " +po_no + " = " + remarks;
	}
}
