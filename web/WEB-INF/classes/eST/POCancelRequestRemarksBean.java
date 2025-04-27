/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST;

import java.io.Serializable;

public class POCancelRequestRemarksBean implements Serializable {
	private String doc_type_code;
	private String doc_no;
	private String remarks;

	public POCancelRequestRemarksBean() {
	}

	public POCancelRequestRemarksBean(String doc_type_code, String doc_no, String remarks) {
		this.doc_type_code = doc_type_code;
		this.doc_no = doc_no;
		this.remarks = remarks;
	}

	public void setDoc_type_code(String doc_type_code) {	
		this.doc_type_code = doc_type_code;
	}

	public String getDoc_type_code() {	
		return this.doc_type_code;
	}

	public void setDoc_no(String doc_no) {	
		this.doc_no = doc_no;
	}

	public String getDoc_no() {	
		return this.doc_no;
	}

	public void setRemarks(String remarks) {	
		this.remarks = remarks;
	}
	
	public String getRemarks() {
		return this.remarks;   
	}

	public String toString() {
		return doc_type_code + " = " +doc_no + " = " + remarks;
	}
}
