/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
-------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------
06/04/2017				IN063878				Badmavathi B					        					 Unused variables
-------------------------------------------------------------------------------------------------------------------------------
*/
 package ePO;

import java.io.Serializable;
import eCommon.Common.*;
import eCommon.Common.CommonAdapter;
import eCommon.Common.CommonRepository;
import java.util.HashMap;

public class QuotationDetailBean extends ePO.Common.PoTransaction implements java.io.Serializable { 

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
	
	
	private String 	rejection_remarks="";
	private String 	quotation_uom_desc = "";
	private String 	quotation_uom_code = "";
	private String 	quotation_qty = "";
	private String 	sample_qty = "";
	private String 	free_qty = "";
	private String 	rejected_qty = "";
	private String 	batch_id = "";
	private String 	trade_id = "";
	private String 	expiry_date = "";
	//private String  purchase_price = ""; Commented for unused variables IN063878
	private String  quotation_price = "";
	private String	tot_value="";
	private String  dis_amt="";
	private String  net_amount="";
	private String 	dis_type="";
	
	private String 	replace_type="";
	private String 	sample_type="";
	private String 	item_status="";
	private String 	manufactur_id="";
	
	private String 	first_delv_date="";
	private String 	delv_freq_type="";
	private String 	catalogue_no="";
	private String 	eq_shipment="";
	private String 	no_of_delv="";
	private String 	origin_country="";
	private String 	item_remarks="";
	private String  item_specification = "";
	
	
	public QuotationDetailBean() {
	}

	public QuotationDetailBean(java.util.Hashtable detailRecord) {

		System.out.println("detailRecord in quot detail bean = "+detailRecord);
		
				
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
		this.quotation_uom_code = (String)detailRecord.get("temp_delv_uom_code");
		this.quotation_uom_desc = (String)detailRecord.get("temp_delv_uom_desc");
		this.quotation_qty = (String)detailRecord.get("quotation_qty");
		this.sample_qty = (String)detailRecord.get("sample_qty");
		this.free_qty = (String)detailRecord.get("free_qty");
		this.rejected_qty = (String)detailRecord.get("rejected_qty");
		this.batch_id = (String)detailRecord.get("batch_id");
		this.expiry_date = (String)detailRecord.get("expiry_date");
		this.quotation_price=(String)detailRecord.get("quotation_price");
		this.tot_value = (String)detailRecord.get("tot_value");
		this.dis_type = (String)detailRecord.get("dis_type");
		this.dis_amt = (String)detailRecord.get("dis_amt");
		this.net_amount = (String)detailRecord.get("net_amount");
		
		this.replace_type = (String)detailRecord.get("replace_type");
		this.sample_type = (String)detailRecord.get("sample_type");
		this.item_status = (String)detailRecord.get("item_status");
		this.manufactur_id = (String)detailRecord.get("manufactur_id");
		this.trade_id = (String)detailRecord.get("trade_id");
		this.item_specification = (String)detailRecord.get("item_specification");
		
			
	}

	public QuotationDetailBean(java.util.HashMap detailRecord) {

		System.out.println("detailRecord in quot detail 94 bean = "+detailRecord);
		
		this.item_code = (String)detailRecord.get("ITEM_CODE");
		this.first_delv_date = (String)detailRecord.get("first_delv_date");
		this.delv_freq_type = (String)detailRecord.get("delv_freq_type");
		this.catalogue_no = (String)detailRecord.get("catalogue_no");
		this.eq_shipment = (String)detailRecord.get("eq_shipment");
		this.no_of_delv = (String)detailRecord.get("no_of_delv");
		this.origin_country = (String)detailRecord.get("origin_country");
		this.item_remarks = (String)detailRecord.get("item_remarks");
	
		
	}

	public QuotationDetailBean(java.sql.ResultSet resultSetRecord) {
		try {
			
			System.out.println("resultSetRecord in quotquotquotquot detail bean = "+resultSetRecord);
				
			setSrl_no(resultSetRecord.getInt("QUOT_SRL_NO"));//doc_srl_no
			setItem_code(resultSetRecord.getString("item_code"));//item_code
			setItem_desc(resultSetRecord.getString("item_desc"));//item_desc
			setQuotation_uom_code(resultSetRecord.getString("QUOT_UOM"));//uom
			setQuotation_uom_desc(resultSetRecord.getString("uom_desc"));//uom_desc
			setQuotation_qty((String)resultSetRecord.getString("QUOT_QTY"));
			setQuotation_price((String)resultSetRecord.getString("QUOT_PRICE"));
			setTot_value(resultSetRecord.getString("GROSS_AMOUNT"));//GROSS_AMOUNT
			setDis_amt((String)resultSetRecord.getString("DISCOUNT_AMOUNT"));
			setDis_type((String)resultSetRecord.getString("DISC_INDICATOR"));
			setNet_amount((String)resultSetRecord.getString("NET_AMOUNT"));
		//	setConvFact(resultSetRecord.getString("DO_CONV_FACTOR"));//DO_CONV_FACTOR
			setCheck_box_status("Y") ;
			setItem_remarks(checkForNull(resultSetRecord.getString("ITEM_REMARKS")," "));//item_remarks
			setItem_status(checkForNull(resultSetRecord.getString("ITEM_STATUS")," "));//	ITEM_STATUS			
			
			setItem_specification(checkForNull(resultSetRecord.getString("ITEM_SPECIFICATION")," "));//	ITEM_SPECIFICATION			
			setReplace_type(checkForNull(resultSetRecord.getString("REPLACEABLE_YN")," "));//	REPLACEABLE_YN			
			setSample_type(checkForNull(resultSetRecord.getString("SAMPLE_PROVIDED_YN")," "));//	SAMPLE_PROVIDED_YN			
			setManufactur_id(checkForNull(resultSetRecord.getString("MANUFACTURER_ID")," "));//	MANUFACTURER_ID			
			setTrade_id(checkForNull(resultSetRecord.getString("TRADE_ID")," "));//	TRADE_ID			
			setSample_qty(checkForNull(resultSetRecord.getString("SAMPLE_QTY")," "));//	SAMPLE_QTY			
			setDelv_freq_type(checkForNull(resultSetRecord.getString("DELV_FREQN_TYPE")," "));//	DELV_FREQN_TYPE			
			setNo_of_delv(checkForNull(resultSetRecord.getString("NO_OF_DELV")," "));//	NO_OF_DELV			
			setFirst_delv_date(resultSetRecord.getString("FIRST_DELV_DT"));//	FIRST_DELV_DT			
			setEq_shipment(checkForNull(resultSetRecord.getString("EQUL_SHIPMENT_YN")," "));//	EQUL_SHIPMENT_YN			
			setCatalogue_no(checkForNull(resultSetRecord.getString("CATL_MODEL_NO")," "));//	CATL_MODEL_NO			
			setOrigin_country(checkForNull(resultSetRecord.getString("COUNTRY_OF_ORIGIN")," "));//	COUNTRY_OF_ORIGIN			
			
			
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
	
	public void setQuotation_uom_code(String quotation_uom_code) {
		this.quotation_uom_code = quotation_uom_code;
	}

	public String getQuotation_uom_code() {
		return this.quotation_uom_code;
	}
	
	public void setQuotation_uom_desc(String quotation_uom_desc) {
		this.quotation_uom_desc = quotation_uom_desc;
	}

	public String getQuotation_uom_desc() {
		return this.quotation_uom_desc;
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
	
	public void setQuotation_qty(String quotation_qty ){
		this.quotation_qty =quotation_qty ;
	}

	public String getQuotation_qty() {
		return this.quotation_qty ;
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
	public void setQuotation_price(String quotation_price ){
		this.quotation_price =quotation_price ;
	}

	public String getQuotation_price() {
		return this.quotation_price ;
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
	
	public void setReplace_type(String replace_type ){
		this.replace_type =replace_type ;
	}

	public String getReplace_type() {
		return this.replace_type;
	}
	
	public void setSample_type(String sample_type ){
		this.sample_type =sample_type ;
	}

	public String getSample_type() {
		return this.sample_type ;
	}
	
	public void setItem_status(String item_status ){
		this.item_status =item_status ;
	}

	public String getItem_status() {
		return this.item_status ;
	}
	public void setManufactur_id(String manufactur_id ){
		this.manufactur_id =manufactur_id ;
	}

	public String getManufactur_id() {
		return this.manufactur_id ;
	}
	
	public void setFirst_delv_date(String first_delv_date ){
		this.first_delv_date =first_delv_date ;
	}

	public String getFirst_delv_date() {
		return this.first_delv_date ;
	}
	public void setDelv_freq_type(String delv_freq_type ){
		this.delv_freq_type =delv_freq_type ;
	}

	public String getDelv_freq_type() {
		return this.delv_freq_type ;
	}
	public void setCatalogue_no(String catalogue_no ){
		this.catalogue_no =catalogue_no ;
	}

	public String getCatalogue_no() {
		return this.catalogue_no ;
	}
	public void setEq_shipment(String eq_shipment ){
		this.eq_shipment =eq_shipment ;
	}

	public String getEq_shipment() {
		return this.eq_shipment ;
	}
	public void setNo_of_delv(String no_of_delv ){
		this.no_of_delv =no_of_delv ;
	}

	public String getNo_of_delv() {
		return this.no_of_delv ;
	}
	public void setOrigin_country(String origin_country ){
		this.origin_country =origin_country ;
	}

	public String getOrigin_country() {
		return this.origin_country ;
	}
	
	public void setItem_specification(String item_specification ){
		this.item_specification =item_specification ;
	}

	public String getItem_specification() {
		return this.item_specification ;
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
		
		setRejection_remarks((String)detailRecord.get("rejection_remarks"));
		setQuotation_uom_code((String)detailRecord.get("quotation_uom_code"));
		setQuotation_uom_desc((String)detailRecord.get("quotation_uom_desc"));
		setQuotation_qty((String)detailRecord.get("quotation_qty"));
		setSample_qty((String)detailRecord.get("sample_qty"));
		setFree_qty((String)detailRecord.get("free_qty"));
		setRejected_qty((String)detailRecord.get("rejected_qty"));
		setBatch_id((String)detailRecord.get("batch_id"));
		setTrade_id((String)detailRecord.get("trade_id"));
		setExpiry_date((String)detailRecord.get("expiry_date"));
		setQuotation_price((String)detailRecord.get("quotation_price"));
		setDis_amt((String)detailRecord.get("dis_amt"));
		setDis_type((String)detailRecord.get("dis_type"));
		setNet_amount((String)detailRecord.get("net_amount"));
		setTot_value((String)detailRecord.get("tot_value"));
		
		setReplace_type((String)detailRecord.get("replace_type"));
		setSample_type((String)detailRecord.get("sample_type"));
		setItem_status((String)detailRecord.get("item_status"));
		setManufactur_id((String)detailRecord.get("manufactur_id"));
		
		setFirst_delv_date((String)detailRecord.get("first_delv_date"));
		setDelv_freq_type((String)detailRecord.get("delv_freq_type"));
		setCatalogue_no((String)detailRecord.get("catalogue_no"));
		setEq_shipment((String)detailRecord.get("eq_shipment"));
		setNo_of_delv((String)detailRecord.get("no_of_delv"));
		setOrigin_country((String)detailRecord.get("origin_country"));
		setItem_remarks((String)detailRecord.get("item_remarks"));
		setItem_specification((String)detailRecord.get("item_specification"));
		
	}

	public String toString() {
		return srl_no+" = "+item_code + " = " +item_desc + " = " + uom + " = " + po_no+ " = " +facility_code+" = "+store_code+" = "+req_qty+" = "+order_qty+" = "+check_box_status+"="+conv_fact+"="+item_remarks+"="+po_srl_no+"="+rejection_remarks+"="+quotation_uom_code+"="+quotation_uom_desc+"="+quotation_qty+"="+sample_qty+"="+free_qty+"="+rejected_qty+"="+batch_id+"="+trade_id+"="+expiry_date+"="+delv_date+"="+quotation_price+"="+dis_amt+"="+dis_type+"="+net_amount+"="+tot_value+"="+delv_srl_no+"="+request_no +"=" +replace_type +"="+ sample_type +"=" + item_status + "=" + manufactur_id +"="+ first_delv_date + "="+ delv_freq_type + "="+ catalogue_no + "="+eq_shipment + "="+ no_of_delv + "=" + origin_country + "="+ item_remarks + "=" + item_specification;
	}
}	

