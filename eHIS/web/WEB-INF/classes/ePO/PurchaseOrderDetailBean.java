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

public class PurchaseOrderDetailBean extends ePO.Common.PoTransaction implements java.io.Serializable { 

	private int 	srl_no;
	private int 	req_srl_no;
	private String 	item_code;
	private String 	item_desc="";
	private String 	uom = "";
	private String 	uom_desc = "";
	private String 	commt_desc = "";
	private String	conv_fact="";
	private String	check_box_status ;
	private String	req_no="";
	private String	facility_code="";
	private String	store_code="";
	private String	req_qty="";
	private String	order_qty="";
	private String	unit_price="";
	private String	tot_value="";
	private String	doc_date="";
	private String	acc_no="";
	private String	acc_desc="";
	private String	dept_no="";
	private String  dis_amt="";
	private String  pur_price="";
	private String  net_amount="";
	private String  commit_code="";
	private String  app_ref="";
	private String 	dis_type="";
	private String 	ref_value="";
	private String 	item_remarks="";
	private String 	del_date = "";
	private String eff_from_dt = "";
	
	
	
	public PurchaseOrderDetailBean() {
	}

	public PurchaseOrderDetailBean(java.util.Hashtable detailRecord) {

		System.out.println("detailRecord in po detail bean = "+detailRecord);
		
				
		this.item_code = (String)detailRecord.get("item_code");
		this.item_desc = (String)detailRecord.get("item_desc");
		this.uom = (String)detailRecord.get("uom");
		this.uom_desc = (String)detailRecord.get("temp_uom");
		this.commt_desc = (String)detailRecord.get("temp_commt");
		
		this.srl_no = Integer.parseInt((String)detailRecord.get("srl_no"));
		this.conv_fact = (String)detailRecord.get("conv_fact");
		this.check_box_status = (String)detailRecord.get("check_box_status");
	    this.req_no = (String)detailRecord.get("req_no");
		this.facility_code = (String)detailRecord.get("facility_code");
		this.store_code = (String)detailRecord.get("store_code");
		this.req_qty = (String)detailRecord.get("req_qty");
		this.order_qty = (String)detailRecord.get("order_qty");
		this.unit_price = (String)detailRecord.get("unit_price");
		this.pur_price = (String)detailRecord.get("pur_price");
		this.tot_value = (String)detailRecord.get("tot_value");
		this.doc_date = (String)detailRecord.get("doc_date");
		this.acc_no = (String)detailRecord.get("acc_no");
		this.acc_desc = (String)detailRecord.get("acc_desc");
		this.dept_no = (String)detailRecord.get("dept_id");
		this.dis_type = (String)detailRecord.get("dis_type");
		this.dis_amt = (String)detailRecord.get("dis_amt");
		this.net_amount = (String)detailRecord.get("net_amount");
		this.commit_code = (String)detailRecord.get("commit_code");
		this.app_ref = (String)detailRecord.get("app_ref");	
		this.ref_value = (String)detailRecord.get("ref_value");	
		this.item_remarks = (String)detailRecord.get("item_remarks");
		this.facility_code = (String)detailRecord.get("facility_id");
		this.store_code = (String)detailRecord.get("req_store");	
		this.del_date = (String)detailRecord.get("del_date");	
		this.req_srl_no = Integer.parseInt((String)detailRecord.get("req_srl_no"));
		this.eff_from_dt = (String)detailRecord.get("eff_from");	
		
		
	}

	public PurchaseOrderDetailBean(java.util.HashMap detailRecord) {

		System.out.println("detailRecord in po detail 94 bean = "+detailRecord);
		
		
		this.item_code = (String)detailRecord.get("ITEM_CODE");
		this.item_desc = (String)detailRecord.get("ITEM_NAME");
		this.uom = (String)detailRecord.get("REQ_UOM");
		this.uom_desc = (String)detailRecord.get("REQ_UOM_DESC");
		this.req_srl_no = Integer.parseInt((String)detailRecord.get("REQ_SRL_NO"));//need to change
		this.req_no = (String)detailRecord.get("REQ_NO");
		this.facility_code = (String)detailRecord.get("FACILITY_ID");
		this.store_code = (String)detailRecord.get("REQ_STORE_CODE");
		this.req_qty = (String)detailRecord.get("REQ_QTY");
		this.order_qty = (String)detailRecord.get("ORDER_QTY");
		
		
	}

	public PurchaseOrderDetailBean(java.sql.ResultSet resultSetRecord) {
		try {
			
			System.out.println("resultSetRecord in po detail bean = "+resultSetRecord);
			
			setSrl_no(resultSetRecord.getInt("po_srl_no"));//doc_srl_no
			setItem_code(resultSetRecord.getString("item_code"));//item_code
			setItem_desc(resultSetRecord.getString("item_desc"));//item_desc
			setUom(resultSetRecord.getString("po_uom"));//uom
			setUomDesc(resultSetRecord.getString("uom_desc"));//uom_desc
			setCommt_Desc(resultSetRecord.getString("COMMT_DESC"));//commt_desc
			setConvFact(resultSetRecord.getString("PO_GEN_UOM_CONV_FACTOR"));//PO_GEN_UOM_CONV_FACTOR
			setCheck_box_status("Y") ;
			setOrder_qty(resultSetRecord.getString("po_qty"));//po_qty
			setPur_price(resultSetRecord.getString("ITEM_UNIT_COST"));//ITEM_UNIT_COST
			setUnit_price(resultSetRecord.getString("LIST_PRICE"));//LIST_PRICE
			setTot_value(resultSetRecord.getString("ITEM_GROSS_VALUE"));//ITEM_GROSS_VALUE
			setAcc_no(resultSetRecord.getString("ACCOUNT_NO"));//ACCOUNT_NO
			setAcc_desc(resultSetRecord.getString("ACCOUNT_NAME"));//ACCOUNT_NAME
			setDept_no(resultSetRecord.getString("DEPT_NO"));//DEPT_NO
			setDis_type(resultSetRecord.getString("DISC_INDICATOR"));//DISC_INDICATOR
			setDis_amt(resultSetRecord.getString("DISC_AMOUNT"));//DISC_AMOUNT
			setNet_amount(resultSetRecord.getString("ITEM_NET_VALUE"));//ITEM_NET_VALUE
			setCommit_code(resultSetRecord.getString("COMMNT_CODE"));//COMMNT_CODE
			setApp_ref(resultSetRecord.getString("APPROVED_YN"));//APPROVED_YN
			setRef_value(checkForNull(resultSetRecord.getString("APPROVAL_REMARKS")," "));//APPROVAL_REMARKS
			setItem_remarks(checkForNull(resultSetRecord.getString("PO_LINE_REMARKS")," "));//item_remarks
			setReq_srl_no(resultSetRecord.getInt("REQ_SRL_NO"));//REQ_SRL_NO
			setReq_no(resultSetRecord.getString("REQ_NO"));//REQ_NO
			setFacility_code(resultSetRecord.getString("REQ_FACILITY_ID"));//FACILITY_ID
			setStore_code(resultSetRecord.getString("REQ_STORE_CODE"));//REQ_STORE_CODE
			setEff_from_dt(resultSetRecord.getString("COMMNT_EFF_DATE_FROM"));//COMMNT_EFF_DATE_FROM
			
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
	
	public void setReq_srl_no(int req_srl_no) {
		this.req_srl_no = req_srl_no;
	}

	public int getReq_srl_no() {
		return this.req_srl_no;
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
	public void setUomDesc(String uom_desc) {
		this.uom_desc = uom_desc;
	}

	public String getUomDesc() {
		return this.uom_desc;
	}
	
	public void setCommt_Desc(String commt_desc) {
		this.commt_desc = commt_desc;
	}

	public String getCommt_Desc() {
		return this.commt_desc;
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

	public void setReq_no(String req_no ){
		this.req_no =req_no ;
	}

	public String getReq_no() {
		return this.req_no ;
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
	public void setUnit_price(String unit_price ){
		this.unit_price =unit_price ;
	}

	public String getUnit_price() {
		return this.unit_price ;
	}
	
	public void setPur_price(String pur_price ){
		this.pur_price =pur_price ;
	}

	public String getPur_price() {
		return this.pur_price ;
	}
	
	public void setTot_value(String tot_value ){
		this.tot_value =tot_value ;
	}

	public String getTot_value() {
		return this.tot_value ;
	}
	public void setDoc_date(String doc_date ){
		this.doc_date =doc_date ;
	}

	public String getDoc_date() {
		return this.doc_date ;
	}
	public void setAcc_no(String acc_no ){
		this.acc_no =acc_no ;
	}

	public String getAcc_no() {
		return this.acc_no ;
	}
	public void setAcc_desc(String acc_desc ){
		this.acc_desc =acc_desc ;
	}

	public String getAcc_desc() {
		return this.acc_desc ;
	}
	public void setDept_no(String dept_no ){
		this.dept_no =dept_no ;
	}

	public String getDept_no() {
		return this.dept_no ;
	}
	
	public void setApp_ref(String app_ref ){
		this.app_ref =app_ref ;
	}

	public String getApp_ref() {
		return this.app_ref ;
	}

	public void setCommit_code(String commit_code ){
		this.commit_code =commit_code ;
	}

	public String getCommit_code() {
		return this.commit_code ;
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
	public void setRef_value(String ref_value ){
		this.ref_value =ref_value ;
	}

	public String getRef_value() {
		return this.ref_value ;
	}
	public void setItem_remarks(String item_remarks ){
		this.item_remarks =item_remarks ;
	}

	public String getItem_remarks() {
		return this.item_remarks ;
	}
	
	public void setDel_date(String del_date ){
		this.del_date =del_date ;
	}

	public String getDel_date() {
		return this.del_date ;
	}
	public void setEff_from_dt(String eff_from_dt ){
		this.eff_from_dt =eff_from_dt ;
	}

	public String getEff_from_dt() {
		return this.eff_from_dt ;
	}
	
	public void setAll(java.util.Hashtable detailRecord) {
	

		setItem_code((String)detailRecord.get("item_code"));
		setItem_desc((String)detailRecord.get("item_desc"));
		setUom((String)detailRecord.get("uom"));
		setConvFact((String)detailRecord.get("conv_fact"));
		setCheck_box_status((String)detailRecord.get("check_box_status"));
		setReq_no((String)detailRecord.get("req_no"));
		setFacility_code((String)detailRecord.get("facility_code"));
		setStore_code((String)detailRecord.get("store_code"));
		setReq_qty((String)detailRecord.get("req_qty"));
		setOrder_qty((String)detailRecord.get("order_qty"));
		setUnit_price((String)detailRecord.get("unit_price"));
		setTot_value((String)detailRecord.get("tot_value"));
		setDoc_date((String)detailRecord.get("doc_date"));
		setAcc_no((String)detailRecord.get("acc_no"));
		setAcc_desc((String)detailRecord.get("acc_desc"));
		setDept_no((String)detailRecord.get("dept_no"));
		setDis_amt((String)detailRecord.get("dis_amt"));
		setDis_type((String)detailRecord.get("dis_type"));
		setNet_amount((String)detailRecord.get("net_amount"));
		setCommit_code((String)detailRecord.get("commit_code"));
		setApp_ref((String)detailRecord.get("app_ref"));
		setRef_value((String)detailRecord.get("ref_value"));
		setItem_remarks((String)detailRecord.get("item_remarks"));
		setDel_date((String)detailRecord.get("del_date"));
		setEff_from_dt((String)detailRecord.get("eff_from_dt"));
		
	
	}

	public String toString() {
		return srl_no+" = "+item_code + " = " +item_desc + " = " + uom + " = " + req_no+ " = " +facility_code+" = "+store_code+" = "+req_qty+" = "+order_qty+" = "+unit_price+" = " +" = "+tot_value+" = "+doc_date+" = "+acc_no+" = "+acc_desc+" = "+dept_no+" = "+ check_box_status+"="+dis_amt+"="+dis_type+"="+net_amount+"="+commit_code+"="+app_ref+"="+ref_value+"="+conv_fact+"="+item_remarks+"="+del_date+"="+req_srl_no+"="+commt_desc+"="+pur_price+"="+eff_from_dt;
	}
}	
