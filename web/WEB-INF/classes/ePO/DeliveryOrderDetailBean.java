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
import eCommon.Common.*;
import eCommon.Common.CommonAdapter;
import eCommon.Common.CommonRepository;
import java.util.HashMap;

public class DeliveryOrderDetailBean extends ePO.Common.PoTransaction implements java.io.Serializable { 

	private int 	srl_no;
	private int 	po_srl_no;
	private int 	delv_srl_no;
	private String 	item_code;
	private String 	item_desc="";
	private String 	uom = "";
	private String 	uom_desc = "";
	private String	conv_fact="";
	private String	check_box_status ;
	private String	po_no="";
	private String	request_no="";
	private String	facility_code="";
	private String	store_code="";
	private String	req_qty="";
	private String	order_qty="";
	
	private String delv_date = "";
	
	private String 	item_remarks="";
	private String 	rejection_remarks="";
	private String 	delivery_uom_desc = "";
	private String 	delivery_uom_code = "";
	private String 	delivery_qty = "";
	private String 	sample_qty = "";
	private String 	free_qty = "";
	private String 	rejected_qty = "";
	private String 	batch_id = "";
	private String 	trade_id = "";
	private String 	expiry_date = "";
	//private String  purchase_price = "";
	private String  delivery_price = "";
	private String	tot_value="";
	private String  dis_amt="";
	private String  net_amount="";
	private String 	dis_type="";
	
	
	public DeliveryOrderDetailBean() {
	}

	public DeliveryOrderDetailBean(java.util.Hashtable detailRecord) {

		System.out.println("detailRecord in po detail bean = "+detailRecord);
		
				
		this.item_code = (String)detailRecord.get("item_code");
		this.item_desc = (String)detailRecord.get("item_desc");
		this.uom = (String)detailRecord.get("uom");
		this.uom_desc = (String)detailRecord.get("temp_uom");
		this.srl_no = Integer.parseInt((String)detailRecord.get("srl_no"));
		this.conv_fact = (String)detailRecord.get("conv_fact");
		this.check_box_status = (String)detailRecord.get("check_box_status");
	    this.po_no = (String)detailRecord.get("po_no");
		this.request_no = (String)detailRecord.get("request_no");
		this.req_qty = (String)detailRecord.get("req_qty");
		this.order_qty = (String)detailRecord.get("order_qty");
		this.facility_code = (String)detailRecord.get("facility_id");
		this.store_code = (String)detailRecord.get("req_store");	
		this.po_srl_no = Integer.parseInt((String)detailRecord.get("po_srl_no"));
		this.delv_srl_no = Integer.parseInt((String)detailRecord.get("delv_srl_no"));
		
		
		this.delv_date = (String)detailRecord.get("delv_date");
		this.item_remarks = (String)detailRecord.get("item_remarks");
		this.rejection_remarks = (String)detailRecord.get("rejection_remarks");
		this.delivery_uom_code = (String)detailRecord.get("temp_delv_uom_code");
		this.delivery_uom_desc = (String)detailRecord.get("temp_delv_uom_desc");
		this.delivery_qty = (String)detailRecord.get("delivery_qty");
		this.sample_qty = (String)detailRecord.get("sample_qty");
		this.free_qty = (String)detailRecord.get("free_qty");
		this.rejected_qty = (String)detailRecord.get("rejected_qty");
		this.batch_id = (String)detailRecord.get("batch_id");
		this.trade_id = (String)detailRecord.get("trade_id");
		this.expiry_date = (String)detailRecord.get("expiry_date");
		this.delivery_price=(String)detailRecord.get("delivery_price");
		this.tot_value = (String)detailRecord.get("tot_value");
		this.dis_type = (String)detailRecord.get("dis_type");
		this.dis_amt = (String)detailRecord.get("dis_amt");
		this.net_amount = (String)detailRecord.get("net_amount");
			
	}

	public DeliveryOrderDetailBean(java.util.HashMap detailRecord) {

		System.out.println("detailRecord in po detail 94 bean = "+detailRecord);
		
		
		this.item_code = (String)detailRecord.get("ITEM_CODE");
		this.item_desc = (String)detailRecord.get("ITEM_DESC");
		this.uom = (String)detailRecord.get("PUR_UOM_CODE");
		this.delivery_uom_code = (String)detailRecord.get("PUR_UOM_CODE");
		this.uom_desc = (String)detailRecord.get("PUR_UOM_DESC");
		this.po_srl_no = Integer.parseInt(checkForNull((String)detailRecord.get("PO_SRL_NO"),"0"));//need to change
		this.delv_srl_no = Integer.parseInt(checkForNull((String)detailRecord.get("DELV_SRL_NO"),"0"));//need to change
		this.request_no = (String)detailRecord.get("REQ_NO");
		this.facility_code = (String)detailRecord.get("REQ_FACILITY_ID");
		this.store_code = (String)detailRecord.get("REQ_STORE_CODE");
		this.req_qty = (String)detailRecord.get("REQ_QTY");
		this.order_qty = (String)detailRecord.get("DELV_QTY");
		this.delivery_qty = (String)detailRecord.get("DELV_QTY");
		this.po_no = (String)detailRecord.get("PO_NO");
		this.delv_date = (String)detailRecord.get("DELV_DATE");
		this.delivery_price = (String)detailRecord.get("ITEM_UNIT_COST");
		this.conv_fact = (String)detailRecord.get("PO_GEN_UOM_CONV_FACTOR");
		this.net_amount = (String)detailRecord.get("ITEM_NET_VALUE");
		
	}

	public DeliveryOrderDetailBean(java.sql.ResultSet resultSetRecord) {
		try {
			
			System.out.println("resultSetRecord in po detail bean = "+resultSetRecord);
			
		
			setSrl_no(resultSetRecord.getInt("DO_SRL_NO"));//doc_srl_no
			setItem_code(resultSetRecord.getString("item_code"));//item_code
			setItem_desc(resultSetRecord.getString("item_desc"));//item_desc
			setDelivery_uom_code(resultSetRecord.getString("DO_UOM"));//uom
			setDelivery_uom_desc(resultSetRecord.getString("uom_desc"));//uom_desc
			setDelivery_qty((String)resultSetRecord.getString("DO_QTY"));
			setDelivery_price((String)resultSetRecord.getString("UNIT_COST"));
			setTot_value(resultSetRecord.getString("GROSS_AMOUNT"));//GROSS_AMOUNT
			setDis_amt((String)resultSetRecord.getString("DISC_AMOUNT"));
			setDis_type((String)resultSetRecord.getString("DISC_INDICATOR"));
			setNet_amount((String)resultSetRecord.getString("NET_AMOUNT"));
			setConvFact(resultSetRecord.getString("DO_CONV_FACTOR"));//DO_CONV_FACTOR
			setCheck_box_status("Y") ;
			setItem_remarks(checkForNull(resultSetRecord.getString("ITEM_REMARKS")," "));//item_remarks
			setPo_srl_no(resultSetRecord.getInt("po_srl_no"));//PO_SRL_NO
			setPo_no(resultSetRecord.getString("po_no"));//PO_NO
			setDelv_date(resultSetRecord.getString("SCH_DELV_DATE"));//SCH_DELV_DATE
			setRequest_no(resultSetRecord.getString("req_no"));//REQ_NO
		//	setDelv_srl_no(resultSetRecord.getInt("delv_srl_no"));//SCH_SRL_NO
			setUom(resultSetRecord.getString("PO_UOM")); 
			setUomDesc(resultSetRecord.getString("PO_UOM_DESC")); 
			setOrder_qty(resultSetRecord.getString("DELV_QTY"));  
			setFacility_code(resultSetRecord.getString("REQ_FACILITY_ID"));
			setStore_code(resultSetRecord.getString("REQ_STORE_CODE"));
			
					
			
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void setSrl_no(int srl_no) {
		this.srl_no = srl_no;
	}

	public int getSrl_no() {
		return this.srl_no;
	}
	
	public void setPo_srl_no(int po_srl_no) {
		this.po_srl_no = po_srl_no;
	}

	public int getPo_srl_no() {
		return this.po_srl_no;
	}
	
	public void setDelv_srl_no(int delv_srl_no) {
		this.delv_srl_no = delv_srl_no;
	}

	public int getDelv_srl_no() {
		return this.delv_srl_no;
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

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getUom() {
		return this.uom;
	}
	
	public void setDelivery_uom_code(String delivery_uom_code) {
		this.delivery_uom_code = delivery_uom_code;
	}

	public String getDelivery_uom_code() {
		return this.delivery_uom_code;
	}
	
	public void setDelivery_uom_desc(String delivery_uom_desc) {
		this.delivery_uom_desc = delivery_uom_desc;
	}

	public String getDelivery_uom_desc() {
		return this.delivery_uom_desc;
	}
	
	
	public void setUomDesc(String uom_desc) {
		this.uom_desc = uom_desc;
	}

	public String getUomDesc() {
		return this.uom_desc;
	}
	
	public void setConvFact(String conv_fact){
		this.conv_fact=conv_fact;
	}

	public String getConvFact() {
		return this.conv_fact;
	} 	

  
	public void setCheck_box_status(String check_box_status ){
		this.check_box_status =check_box_status ;
	}

	public String getCheck_box_status() {
		return this.check_box_status ;
	} 	

	public void setPo_no(String po_no ){
		this.po_no =po_no ;
	}

	public String getPo_no() {
		return this.po_no ;
	} 

	public void setRequest_no(String request_no ){
		this.request_no =request_no ;
	}

	public String getRequest_no() {
		return this.request_no ;
	} 	
	public void setFacility_code(String facility_code ){
		this.facility_code =facility_code ;
	}

	public String getFacility_code() {
		return this.facility_code ;
	}
	public void setStore_code(String store_code ){
		this.store_code =store_code ;
	}

	public String getStore_code() {
		return this.store_code ;
	}
	public void setReq_qty(String req_qty ){
		this.req_qty =req_qty ;
	}

	public String getReq_qty() {
		return this.req_qty ;
	}
	public void setOrder_qty(String order_qty ){
		this.order_qty =order_qty ;
	}

	public String getOrder_qty() {
		return this.order_qty ;
	}
	
	public void setDelv_date(String delv_date ){
		this.delv_date =delv_date ;
	}

	public String getDelv_date() {
		return this.delv_date ;
	}
	
	public void setItem_remarks(String item_remarks ){
		this.item_remarks =item_remarks ;
	}

	public String getItem_remarks() {
		return this.item_remarks ;
	}
	
	public void setRejection_remarks(String rejection_remarks ){
		this.rejection_remarks =rejection_remarks ;
	}

	public String getRejection_remarks() {
		return this.rejection_remarks ;
	}
	
	public void setDelivery_qty(String delivery_qty ){
		this.delivery_qty =delivery_qty ;
	}

	public String getDelivery_qty() {
		return this.delivery_qty ;
	}
	public void setSample_qty(String sample_qty ){
		this.sample_qty =sample_qty ;
	}

	public String getSample_qty() {
		return this.sample_qty ;
	}
	public void setFree_qty(String free_qty ){
		this.free_qty =free_qty ;
	}

	public String getFree_qty() {
		return this.free_qty ;
	}
	public void setRejected_qty(String rejected_qty ){
		this.rejected_qty =rejected_qty ;
	}

	public String getRejected_qty() {
		return this.rejected_qty ;
	}
	public void setBatch_id(String batch_id ){
		this.batch_id =batch_id ;
	}

	public String getBatch_id() {
		return this.batch_id ;
	}
	public void setTrade_id(String trade_id ){
		this.trade_id =trade_id ;
	}

	public String getTrade_id() {
		return this.trade_id ;
	}
	public void setExpiry_date(String expiry_date ){
		this.expiry_date =expiry_date ;
	}

	public String getExpiry_date() {
		return this.expiry_date ;
	}
	public void setDelivery_price(String delivery_price ){
		this.delivery_price =delivery_price ;
	}

	public String getDelivery_price() {
		return this.delivery_price ;
	}
	public void setTot_value(String tot_value ){
		this.tot_value =tot_value ;
	}

	public String getTot_value() {
		return this.tot_value ;
	}
	public void setNet_amount(String net_amount ){
		this.net_amount =net_amount ;
	}

	public String getNet_amount() {
		return this.net_amount ;
	}
	
	public void setDis_amt(String dis_amt ){
		this.dis_amt =dis_amt ;
	}

	public String getDis_amt() {
		return this.dis_amt ;
	}
	public void setDis_type(String dis_type ){
		this.dis_type =dis_type ;
	}

	public String getDis_type() {
		return this.dis_type ;
	}
	
	public void setAll(java.util.Hashtable detailRecord) {
	

		setItem_code((String)detailRecord.get("item_code"));
		setItem_desc((String)detailRecord.get("item_desc"));
		setUom((String)detailRecord.get("uom"));
		setConvFact((String)detailRecord.get("conv_fact"));
		setCheck_box_status((String)detailRecord.get("check_box_status"));
		setPo_no((String)detailRecord.get("po_no"));
		setFacility_code((String)detailRecord.get("facility_code"));
		setStore_code((String)detailRecord.get("store_code"));
		setReq_qty((String)detailRecord.get("req_qty"));
		setOrder_qty((String)detailRecord.get("order_qty"));
		
		setDelv_date((String)detailRecord.get("delv_date"));
		setItem_remarks((String)detailRecord.get("item_remarks"));
		setRejection_remarks((String)detailRecord.get("rejection_remarks"));
		setDelivery_uom_code((String)detailRecord.get("delivery_uom_code"));
		setDelivery_uom_desc((String)detailRecord.get("delivery_uom_desc"));
		setDelivery_qty((String)detailRecord.get("delivery_qty"));
		setSample_qty((String)detailRecord.get("sample_qty"));
		setFree_qty((String)detailRecord.get("free_qty"));
		setRejected_qty((String)detailRecord.get("rejected_qty"));
		setBatch_id((String)detailRecord.get("batch_id"));
		setTrade_id((String)detailRecord.get("trade_id"));
		setExpiry_date((String)detailRecord.get("expiry_date"));
		setDelivery_price((String)detailRecord.get("delivery_price"));
		setDis_amt((String)detailRecord.get("dis_amt"));
		setDis_type((String)detailRecord.get("dis_type"));
		setNet_amount((String)detailRecord.get("net_amount"));
		setTot_value((String)detailRecord.get("tot_value"));
		
	}

	public String toString() {
		return srl_no+" = "+item_code + " = " +item_desc + " = " + uom + " = " + po_no+ " = " +facility_code+" = "+store_code+" = "+req_qty+" = "+order_qty+" = "+check_box_status+"="+conv_fact+"="+item_remarks+"="+po_srl_no+"="+rejection_remarks+"="+delivery_uom_code+"="+delivery_uom_desc+"="+delivery_qty+"="+sample_qty+"="+free_qty+"="+rejected_qty+"="+batch_id+"="+trade_id+"="+expiry_date+"="+delv_date+"="+delivery_price+"="+dis_amt+"="+dis_type+"="+net_amount+"="+tot_value+"="+delv_srl_no+"="+request_no;
	}
}	

