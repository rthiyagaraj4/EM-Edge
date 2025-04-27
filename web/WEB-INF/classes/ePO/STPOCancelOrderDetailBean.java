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

public class STPOCancelOrderDetailBean implements Serializable {
	private int po_srl_no;
	private String po_no;
	private String item_code;
	private String item_desc;
	private String required_qty;
	private String po_uom;

	public STPOCancelOrderDetailBean(java.sql.ResultSet resultSetRecord) {
	System.out.println("resultSetRecord=====>" +resultSetRecord);
		try {
			setDoc_no(resultSetRecord.getString("po_no"));
			setSrl_no(resultSetRecord.getInt("po_srl_no"));
			setItem_code(resultSetRecord.getString("item_code"));
			setItem_desc(resultSetRecord.getString("item_desc"));
			setRequired_qty(resultSetRecord.getString("req_gen_uom_qty"));
			setPo_Uom(resultSetRecord.getString("po_uom"));
			 
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

 
	public void setRequired_qty(String required_qty) {	
		this.required_qty = required_qty;
	}
	
	public String getRequired_qty() {
		return this.required_qty;
	}

	public void setPo_Uom(String Po_order_uom) {	
		this.po_uom = Po_order_uom;
	}
	public String getPo_Uom() {
		return this.po_uom;
	}

	public void setAll(java.util.Hashtable detailRecord) {
	    setDoc_no((String)detailRecord.get("po_no"));
		setItem_code((String)detailRecord.get("item_code"));
		setItem_desc((String)detailRecord.get("item_desc"));
		setRequired_qty((String)detailRecord.get("required_qty"));
		setPo_Uom((String)detailRecord.get("po_uom"));
	}

	public String toString() {
			return po_no+" , "+po_srl_no+" , "+item_code + " , " +item_desc + " , " + required_qty+ " , " +po_uom;
	}
}
