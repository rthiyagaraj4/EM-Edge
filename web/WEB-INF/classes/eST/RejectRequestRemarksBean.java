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

public class RejectRequestRemarksBean implements Serializable {
	private String doc_type_code;
	private String doc_no;
	private String remarks;
	private String remarks_code; //17/08/12

	public RejectRequestRemarksBean() {
	}

	public RejectRequestRemarksBean(String doc_type_code, String doc_no, String remarks,String remarks_code) {
		this.doc_type_code = doc_type_code;
		this.doc_no = doc_no;
		this.remarks = remarks;
		this.remarks_code = remarks_code;  
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
	
	public void setRemarks_code(String remarks_code) {	
		this.remarks_code = remarks_code;
	}
	
	public String getRemarks_code() {
		return this.remarks_code;   
	}
	//Added by Rabbani # Bru-HIMS-CRF-118[INC NO:30077] on 19-JULY-2013 
	public void setDtlRemarks(String remarks) {	
		this.remarks = remarks;
	}
	public String getDtlRemarks() {
		return this.remarks;   
	}
	public void setDtl_Remarks_code(String remarks_code) {	
		this.remarks_code = remarks_code;
	}
	public String getDtl_Remarks_code() {
		return this.remarks_code;   
	}
	//ends

	public String toString() {
		return doc_type_code + " = " +doc_no + " = " +remarks+ " = " +remarks_code;
	}
}
