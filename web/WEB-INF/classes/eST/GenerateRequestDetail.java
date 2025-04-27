/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

import eCommon.Common.CommonAdapter;
import java.sql.*;
import java.sql.Connection;
import eST.Common.*;
import eCommon.Common.* ;
import java.util.HashMap;

public class GenerateRequestDetail extends GenerateRequestBean implements java.io.Serializable {
	private String item_code;
	private String item_desc;
	private String max_stock_qty;
	private String reorder_level;
	private String pending_req_qty;
	private String req_qty;
	private String stock_item_yn;
	private String qty_on_hand;
	private String uom_code ;
	private String reorder_qty ;
	private String request_uom ;
	private String stock_uom ;
	private String allow_decimals_yn ;
	private double req_uom_conv ;
	private double by_stock_uom_conv ;
	private double on_stock_uom_conv ;
	private int no_of_decimals ;
	private String from_multiples="1";
	private String to_multiples="1";
	private String batch_multiples="1";
	private String issue_uom_multiples="1";
	private String qoh_onstore ;
	public GenerateRequestDetail() {
	}

	public GenerateRequestDetail(String item_code, String item_desc, String qty_on_hand , String max_stock_qty, String reorder_level, String pending_req_qty, String req_qty,String stock_item_yn,String uom_code,String reorder_qty,String req_uom_conv,String by_stock_uom_conv,String on_stock_uom_conv,String request_uom,String stock_uom,String allow_decimals_yn,String no_of_decimals,String request_by_store,String request_on_store, String qoh_onstore) {
		this.item_code = item_code;
		this.item_desc = item_desc;
		this.qty_on_hand =checkForNull(qty_on_hand); 
		this.max_stock_qty  = checkForNull(max_stock_qty);
		this.reorder_level  = checkForNull(reorder_level);
		this.pending_req_qty  = checkForNull(pending_req_qty);
		this.req_qty = checkForNull(req_qty);
		this.stock_item_yn=stock_item_yn;
        this.uom_code=uom_code ;
        this.reorder_qty=checkForNull(reorder_qty) ;
        this.req_uom_conv=Double.parseDouble(checkForNull(req_uom_conv,"1.0")) ;
        this.by_stock_uom_conv=Double.parseDouble(checkForNull(by_stock_uom_conv,"1.0")) ;
        this.on_stock_uom_conv=Double.parseDouble(checkForNull(on_stock_uom_conv,"1.0")) ;
        this.request_uom=checkForNull(request_uom) ;
        this.stock_uom=checkForNull(stock_uom) ;
        this.allow_decimals_yn=allow_decimals_yn ;
        this.no_of_decimals=Integer.parseInt(checkForNull(no_of_decimals,"0")) ;
        this.qoh_onstore=qoh_onstore ;
		/*Commented by suresh.r on 23-09-2014 against Inc# 52042 query tuning beg
		 HashMap hmTempFactor = new HashMap();
		if(allow_decimals_yn.equals("N")){
			hmTempFactor = (HashMap)getConvFactTemp(item_code,request_by_store,request_on_store,uom_code);
			setFromMultiples((String)hmTempFactor.get("FROM_STORE_MULTIPLES"));
			setToMultiples((String)hmTempFactor.get("TO_STORE_MULTIPLES"));
			setBatchMultiples((String)hmTempFactor.get("BATCH_QTY_MULTIPLES"));
			setIssueUOMMultiples((String)hmTempFactor.get("ISSUE_UOM_MULTIPLES"));
		}Commented by suresh.r on 23-09-2014 against Inc# 52042 query tuning end*/
			
	}



	public void setMax_stock_qty(String max_stock_qty) {
		 this.max_stock_qty = max_stock_qty;
	}

	
	public void setQty_on_hand(String qty_on_hand) {
		 this.qty_on_hand = qty_on_hand;
	}

	public String getQty_on_hand( ) {
		 return qty_on_hand;
	}

	public void setPending_req_qty(String pending_req_qty) {
		 this.pending_req_qty = pending_req_qty;
	}

	public String getPending_req_qty( ) {
		 return pending_req_qty;
	}

	public void setReq_qty(String req_qty) {
		 this.req_qty = req_qty;
	}

	public String getReq_qty( ) {
		 return req_qty;
	}

	
	public void setItem_code(String item_code) {
		 this.item_code = item_code;
	}

	public String getItem_code( ) {

		 return item_code;
	}

	public void setStock_item_yn(String stock_item_yn) {
		 this.stock_item_yn = stock_item_yn;
	}

	public String getStock_item_yn( ) {
		 return stock_item_yn;
	}

	public void setItem_desc(String item_desc) {
		 this.item_desc = item_desc;
	}

	public String getItem_desc( ) {
		 return item_desc;
	}

	public void setReorder_level(String reorder_level) {
		 this.reorder_level = reorder_level;
	}

	public String getReorder_level( ) {
		 return reorder_level;
	}


    public void setUom_code(String uom_code) {
		 this.uom_code = uom_code;
	}

	public String getUom_code() {
		 return uom_code;
	}

    
	public void setReqUOMConv(double req_uom_conv) {
		 this.req_uom_conv = req_uom_conv;
	}

	public double getReqUOMConv() {
		 return req_uom_conv;
	}
    
	public void setByStockUOMConv(double by_stock_uom_conv) {
		 this.by_stock_uom_conv = by_stock_uom_conv;
	}

	public double getByStockUOMConv() {
		 return by_stock_uom_conv;
	}
    
	public void setOnStockUOMConv(double on_stock_uom_conv) {
		 this.on_stock_uom_conv = on_stock_uom_conv;
	}

	public double getOnStockUOMConv() {
		 return on_stock_uom_conv;
	}

	public void setRequestUOM(String request_uom) {
		 this.request_uom = request_uom;
	}

	public String getRequestUOM() {
		 return request_uom;
	}

	public void setStockUOM(String stock_uom) {
		 this.stock_uom = stock_uom;
	}

	public String getStockUOM() {
		 return stock_uom;
	}
	public void setAllow_decimals_yn(String allow_decimals_yn) {
		 this.allow_decimals_yn = allow_decimals_yn;
	}

	public String getAllow_decimals_yn() {
		 return allow_decimals_yn;
	}
	public void setNo_of_decimals(int no_of_decimals) {
		 this.no_of_decimals = no_of_decimals;
	}
	
	public int getNo_of_decimals() {
		 return no_of_decimals;
	}
	public String getQoh_onstore() {
		 return qoh_onstore;
	}
	public void setQoh_onstore(String qoh_onstore) {
		 this.qoh_onstore = qoh_onstore;
	}


	public void setMutiple(java.util.Hashtable htResult) {		
		setItem_code((String) htResult.get("item_code"));
		setItem_desc((String) htResult.get("item_desc"));
		setMax_stock_qty((String)htResult.get("max_stock_qty"));
		setReorder_level((String) htResult.get("reorder_level"));
		setPending_req_qty((String) htResult.get("pending_req_qty"));
		setReq_qty((String) htResult.get("req_qty"));
        setUom_code((String) htResult.get("uom_code"));
	
	}

	public void setAll(java.sql.ResultSet  resultSet) {
		try 
			{
			
			setItem_code(CommonAdapter.checkForNull(resultSet.getString("item_code")));
			setItem_desc(CommonAdapter.checkForNull(resultSet.getString("item_desc")));
			setQty_on_hand(CommonAdapter.checkForNull(resultSet.getString("qty_on_hand")));
			setMax_stock_qty(CommonAdapter.checkForNull(resultSet.getString("max_stock_qty")));
			setReorder_level(CommonAdapter.checkForNull(resultSet.getString("reorder_level")));
			setPending_req_qty(CommonAdapter.checkForNull(resultSet.getString("pending_req_qty")));
			setReq_qty(CommonAdapter.checkForNull(resultSet.getString("req_qty")));
			setStock_item_yn(CommonAdapter.checkForNull(resultSet.getString("stock_item_yn")));
            setUom_code(CommonAdapter.checkForNull(resultSet.getString("uom_code")));

			}
		catch (Exception exception ) {
			exception.printStackTrace();
		}
	}

	public String toString() {
		return item_code+ " - " +  item_desc+ " - " + max_stock_qty+ " - " + reorder_level+ " - " + pending_req_qty+ " - " + req_qty + " - " +stock_item_yn + " - " + uom_code ;
	}

	public void setValues(java.util.Hashtable dataValues) {
	}

	public void clear() {

	item_code="";      
	item_desc="";      		
	max_stock_qty="";
	reorder_level="";  
	pending_req_qty="";
	req_qty="";      
	qty_on_hand = "";
	uom_code = "" ;
	reorder_qty = "" ;

	}
	
public String getMax_stock_qty( ) {
		
		 return max_stock_qty;
	}
	
public String getReorder_qty( ) {
		
		 return this.reorder_qty;
	}
	public void setFromMultiples(String from_multiples){
		this.from_multiples=from_multiples;
	}

	public String getFromMultiples() {
		return this.from_multiples;
	} 
	public void setToMultiples(String to_multiples){
		this.to_multiples=to_multiples;
	}

	public String getToMultiples() {
		return this.to_multiples;
	} 
	public void setBatchMultiples(String batch_multiples){
		this.batch_multiples=batch_multiples;
	}

	public String getBatchMultiples() {
		return this.batch_multiples;
	} 
	public void setIssueUOMMultiples(String issue_uom_multiples){
		this.issue_uom_multiples=issue_uom_multiples;
	}

	public String getIssueUOMMultiples() {
		return this.issue_uom_multiples;
	} 

}
