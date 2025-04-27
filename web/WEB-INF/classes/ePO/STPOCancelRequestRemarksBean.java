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

public class STPOCancelRequestRemarksBean implements Serializable {
	private String req_code;
	private String req_no;
	private String remarks;
	private String remarks_code;

	public STPOCancelRequestRemarksBean() {
	}

	public STPOCancelRequestRemarksBean(String req_code, String req_no, String remarks,String remarks_code) {
		this.req_code = req_code;
		this.req_no = req_no;
		this.remarks = remarks;
		this.remarks_code = remarks_code;  
	}

	public void setDoc_type_code(String req_code) {	
		this.req_code = req_code;
	}

	public String getDoc_type_code() {	
		return this.req_code;
	}

	public void setDoc_no(String req_no) {	
		this.req_no = req_no;
	}

	public String getDoc_no() {	
		return this.req_no;
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
		return req_code + " ~ " +req_no + " ~" + remarks ; //+ " = " +remarks_code;
	}
}
