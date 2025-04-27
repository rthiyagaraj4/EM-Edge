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

public class PurchaseOrderCancelRemarksBean implements Serializable {
	private String po_order_mode;
	private String po_no;
	private String remarks;
	private String remarks_code;

	public PurchaseOrderCancelRemarksBean() {
	}
	
	    

	public PurchaseOrderCancelRemarksBean(String po_order_mode, String po_no, String remarks,String remarks_code) {
		this.po_order_mode = po_order_mode;
		this.po_no = po_no;
		this.remarks = remarks;
		this.remarks_code = remarks_code;  
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
	
	public void setRemarks_code(String remarks_code) {	
		this.remarks_code = remarks_code;
	}
	
	public String getRemarks_code() {
		return this.remarks_code;   
	}

	public String toString() {
		return po_order_mode + " ~ " +po_no + "~" + remarks ; //+  " = " +remarks_code;
	}
}
