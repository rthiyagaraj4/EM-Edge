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

public class DeliveryOrderCancelRemarksBean implements Serializable {
	private String do_date;
	private String do_no;
	private String remarks;
	private String remarks_code;

	public DeliveryOrderCancelRemarksBean() {
	}
	
	    

	public DeliveryOrderCancelRemarksBean(String do_date, String do_no, String remarks,String remarks_code) {
		this.do_date = do_date;
		this.do_no = do_no;
		this.remarks = remarks;
		this.remarks_code = remarks_code;  
	}

	public void setDo_date(String do_date) {	
		this.do_date = do_date;
	}

	public String getDo_date() {	
		return this.do_date;
	}

	public void setDoc_no(String do_no) {	
		this.do_no = do_no;
	}

	public String getDoc_no() {	
		return this.do_no;
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
		return do_date + " = " +do_no + " = " + remarks ; //+  " = " +remarks_code;
	}
}
