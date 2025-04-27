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

public class STPOCancelRequestDetailBean implements Serializable {
	private int srl_no;
	private String req_no;
	private String item_code;
	private String item_desc;
	private String required_qty;
	private String req_on_store;
	private String req_by_store;
	private String req_uom;
	

	public STPOCancelRequestDetailBean(java.sql.ResultSet resultSetRecord) {
		try {
			setDoc_no(resultSetRecord.getString("req_no"));
			setSrl_no(resultSetRecord.getInt("req_srl_no"));
			setItem_code(resultSetRecord.getString("item_code"));
			setItem_desc(resultSetRecord.getString("item_desc"));
			setRequired_qty(resultSetRecord.getString("req_gen_uom_qty"));
			setReq_Uom(resultSetRecord.getString("req_uom"));
			 
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void setDoc_no(String req_no) {
		this.req_no = req_no;
	}

	public String getDoc_no() {
		return this.req_no;
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


	public void setRequired_qty(String required_qty) {	
		this.required_qty = required_qty;
	}
	
	public String getRequired_qty() {
		return this.required_qty;
	}

	public void setReq_Uom(String request_uom) {	
		this.req_uom = request_uom;
	}
	public String getReq_Uom() {
		return this.req_uom;
	}
	 
	

	public void setAll(java.util.Hashtable detailRecord) {
		setItem_code((String)detailRecord.get("item_code"));
		setItem_desc((String)detailRecord.get("item_desc"));
		setRequired_qty((String)detailRecord.get("required_qty"));
		setReq_Uom((String)detailRecord.get("req_uom"));
	}

	public String toString() {
			return req_no+" , "+srl_no+" , "+item_code + " , " +item_desc + " , " + required_qty+" , "+req_uom;
	}
}
