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

public class CancelRequestDetailBean implements Serializable {
	private int srl_no;
	private int doc_no;
	private String item_code;
	private String item_desc;
	private String required_qty;
	private String issued_qty;
	private String pending_item_qty;
	private String req_on_store;
	private String req_by_store;

/*	public CancelRequestDetailBean() {
	}*/

	public CancelRequestDetailBean(java.sql.ResultSet resultSetRecord) {
		try {
			setDoc_no(resultSetRecord.getInt("doc_no"));
			setSrl_no(resultSetRecord.getInt("doc_srl_no"));
			setItem_code(resultSetRecord.getString("item_code"));
			setItem_desc(resultSetRecord.getString("item_desc"));
			setRequired_qty(resultSetRecord.getString("req_item_qty"));
			setIssued_qty(resultSetRecord.getString("iss_item_qty"));
			setPending_item_qty(resultSetRecord.getString("pending_item_qty"));	
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void setDoc_no(int doc_no) {
		this.doc_no = doc_no;
	}

	public int getDoc_no() {
		return this.doc_no;
	}


	public void setSrl_no(int srl_no) {
		this.srl_no = srl_no;
	}

	public int getSrl_no() {
		return this.srl_no;
	}

	public void setItem_code (String item_code) {	
		this.item_code = item_code;
	}

	public String getItem_code () {	
		return this.item_code;
	}

	public void setReq_on_store (String req_on_store) {	
		this.req_on_store = req_on_store;
	}

	public String getReq_on_store () {	
		return this.req_on_store;
	}

	public void setReq_by_store (String req_by_store) {	
		this.req_by_store = req_by_store;
	}

	public String getReq_by_store () {	
		return this.req_by_store;
	}


	public void setItem_desc(String item_desc) {	
		this.item_desc = item_desc;
	}

	public String getItem_desc() {	
		return this.item_desc;
	}

	public void setIssued_qty(String issued_qty) {	
		this.issued_qty = issued_qty;
	}
	
	public String getIssued_qty() {
		return this.issued_qty;
	}

	public void setRequired_qty(String required_qty) {	
		this.required_qty = required_qty;
	}
	
	public String getRequired_qty() {
		return this.required_qty;
	}

	public void setPending_item_qty(String pend_item_qty) {	
		this.pending_item_qty = pend_item_qty;
	}
	
	public String getPending_item_qty() {
		return this.pending_item_qty;
	}

	public void setAll(java.util.Hashtable detailRecord) {
		setItem_code((String)detailRecord.get("item_code"));
		setItem_desc((String)detailRecord.get("item_desc"));
		setRequired_qty((String)detailRecord.get("required_qty"));
		setIssued_qty((String)detailRecord.get("issued_qty"));
		setPending_item_qty((String)detailRecord.get("pending_item_qty"));
	}

	public String toString() {
			return doc_no+" , "+srl_no+" , "+item_code + " , " +item_desc + " , " + required_qty+ " , " + issued_qty+" , "+pending_item_qty;
	}
}
