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

public class PurchaseOrderCancelDetailBean implements Serializable {
	private int po_srl_no;
	private String po_no;
	private String item_code;
	private String item_desc;
	private String po_qty;
	private String po_uom;
	private String do_qty;
	private String pending_qty;
	private String received_qty;
	private String received_uom;

	public PurchaseOrderCancelDetailBean(java.sql.ResultSet resultSetRecord) {
	//System.out.println("resultSetRecord=====>" +resultSetRecord);
		try {
			setDoc_no(resultSetRecord.getString("po_no"));
			setSrl_no(resultSetRecord.getInt("po_srl_no"));
			setItem_code(resultSetRecord.getString("item_code"));
			setItem_desc(resultSetRecord.getString("item_desc"));
			setPo_qty(resultSetRecord.getString("po_qty"));
			setPo_Uom(resultSetRecord.getString("po_uom"));
			setDo_qty(resultSetRecord.getString("do_qty"));
			setPending_qty(resultSetRecord.getString("pending_qty"));
			setReceived_qty(resultSetRecord.getString("received_qty"));
			setReceived_uom(resultSetRecord.getString("received_uom"));
			 
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void setDoc_no(String po_no) {
		this.po_no = po_no;
	}

	public String getDoc_no() {
		return this.po_no;
	}


	public void setSrl_no(int po_srl_no) {
		this.po_srl_no = po_srl_no;
	}

	public int getSrl_no() {
		return this.po_srl_no;
	}

	public void setItem_code (String item_code) {	
		this.item_code = item_code;
	}

	public String getItem_code () {	
		return this.item_code;
	}


	public void setItem_desc(String item_desc) {	
		this.item_desc = item_desc;
	}

	public String getItem_desc() {	
		return this.item_desc;
	}

 
	public void setPo_qty(String po_qty) {	
		this.po_qty = po_qty;
	}
	
	public String getPo_qty() {
		return this.po_qty;
	}

	public void setPo_Uom(String Po_order_uom) {	
		this.po_uom = Po_order_uom;
	}
	public String getPo_Uom() {
		return this.po_uom;
	}
	public void setDo_qty(String do_qty) {	
		this.do_qty = do_qty;
	}
	
	public String getDo_qty() {
		return this.do_qty;
	}
	public void setPending_qty(String pending_qty) {	
		this.pending_qty = pending_qty;
	}
	
	public String getPending_qty() {
		return this.pending_qty;
	}
	public void setReceived_qty(String received_qty) {	
		this.received_qty = received_qty;
	}
	
	public String getReceived_qty() {
		return this.received_qty;
	}
	public void setReceived_uom(String received_uom) {	
		this.received_uom = received_uom;
	}
	
	public String getReceived_uom() {
		return this.received_uom;
	}
	

	public void setAll(java.util.Hashtable detailRecord) {
	    setDoc_no((String)detailRecord.get("po_no"));
		setItem_code((String)detailRecord.get("item_code"));
		setItem_desc((String)detailRecord.get("item_desc"));
		setPo_qty((String)detailRecord.get("po_qty"));
		setPo_Uom((String)detailRecord.get("po_uom"));
		setDo_qty((String)detailRecord.get("do_qty"));
		setPending_qty((String)detailRecord.get("pending_qty"));
		setReceived_qty((String)detailRecord.get("received_qty"));
		setReceived_uom((String)detailRecord.get("received_uom"));
	}

	public String toString() {
			return po_no+" , "+po_srl_no+" , "+item_code + " , " +item_desc + " , " + po_qty+ " , " +po_uom + " , " +do_qty + " , " +pending_qty+","+received_qty+","+received_uom;
	}
}
