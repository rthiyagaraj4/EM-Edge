/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* --------------------------------------------------------------------------------------------------------
Date			Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
21/10/2021	  	TFS-24350	   Shazana     										MO-CRF-20173
-------------------------------------------------------------------------------------------------------*/  
 package eST;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
//public class AuthorizeAtIssueStoreDetailBean extends eST.Common.StTransaction implements Serializable { 
public class AuthorizeAtIssueStoreDetailBean extends AuthorizeAtIssueStoreBean implements Serializable { 
	private String store_code;
	private String item_desc;
	private String doc_srl_no;
	private String stock_item_yn;
	private String curr_pack_size;
	private String pending_item_qty = "0";
	private String committed_item_qty = "0";
	private String issued_item_qty = "0";
	private String issuing_item_qty = "0";
	private String req_item_qty = "0";
	private String item_code;
	private String uom_desc;
	private String unit_cost;
	private String to_bin_location_code;
	private boolean canAcceptDecimal;
	private String severity_color = "NORMAL";
	//code added for Request and Issue UOM
	private String pur_uom_code = "";
	private String req_conv_fact = "";
	private String req_uom_qty = "";
	private String iss_uom_code = "";
	private String iss_conv_fact = "";
	private String iss_uom_qty = "";
	private String uom_code = "";

	private String req_by_qty_on_hand = "0";
	private String req_by_max_stk_level = "";
	private String req_by_min_stk_level = "";
	private String req_by_reorder_level = "";

	private String req_on_qty_on_hand = "0";
	private String req_on_max_stk_level = "";
	private String req_on_min_stk_level = "";
	private String req_on_reorder_level = "";
	private String remarks_code			= "";
	private String remarks_desc			= "";
	private String	kit_template_uom="";
	private String	kit_item_yn="";
	private String	iss_conv_text="";
	private String	req_conv_text="";
	private String from_multiples="1";
	private String to_multiples="1";
	private String batch_multiples="1";
	private String issue_uom_multiples="1";
	private String req_batch_multiples="1";
	private String req_uom_multiples="1";
	private String usage_type =""; //20/09/12
	private String close_item_yn = "";//MO-CRF-20173 START
	private String closeRemarksDesc = ""; 
	private ArrayList closeItemList = null;
	
	
	public ArrayList getCloseItemList() {
		return closeItemList;
	}

	public void setCloseItemList(ArrayList closeItemList) {
		this.closeItemList = closeItemList;
	}

	public String getCloseRemarksDesc() {
		return closeRemarksDesc;
	}

	public void setCloseRemarksDesc(String closeRemarksDesc) {
		this.closeRemarksDesc = closeRemarksDesc;
	}//end 

	public String getClose_item_yn() {
		return close_item_yn;
	}

	public void setClose_item_yn(String close_item_yn) {
		this.close_item_yn = close_item_yn;
	}//end 

	public void setIssConvText(String iss_conv_text){
		this.iss_conv_text = iss_conv_text;
	}

   public String getIssConvText(){
		return this.iss_conv_text;
	}

	public void setReqConvText(String req_conv_text){
		this.req_conv_text = req_conv_text;
	}

   public String getReqConvText(){
		return this.req_conv_text;
	}

	public void setPurUomCode(String pur_uom_code){
		this.pur_uom_code = pur_uom_code;
	}
	public String getPurUomCode(){
		return pur_uom_code;
	}

	public void setReqConvFact(String req_conv_fact){
		this.req_conv_fact = req_conv_fact;
	}
	public String getReqConvFact(){
		return req_conv_fact;
	}

	public void setReqUomQty(String req_uom_qty){
		this.req_uom_qty = req_uom_qty;
	}
	public String getReqUomQty(){
		return req_uom_qty;
	}

	
	public void setIssUomCode(String iss_uom_code){
		this.iss_uom_code = iss_uom_code;
	}
	public String getIssUomCode(){
		return iss_uom_code;
	}

	public void setIssConvFact(String iss_conv_fact){
		this.iss_conv_fact = iss_conv_fact;
	}
	public String getIssConvFact(){
		return iss_conv_fact;
	}

	public void setIssUomQty(String iss_uom_qty){
		this.iss_uom_qty = iss_uom_qty;
	}
	public String getIssUomQty(){
		return iss_uom_qty;
	}

	public void setStore_code(String store_code) {
		this.store_code = store_code;
	}
	public String getStore_code() {
		return this.store_code;
	}
	public void setItem_desc(String item_desc) {
		 this.item_desc = item_desc;
	}
	public String getItem_desc( ) {
		 return item_desc;
	}
	public void setTo_bin_location_code(String to_bin_location_code) {
		 this.to_bin_location_code = to_bin_location_code;
	}
	public String getTo_bin_location_code( ) {
		 return to_bin_location_code==null?"":to_bin_location_code;
	}

	public void setDoc_srl_no(String doc_srl_no) {
		 this.doc_srl_no = doc_srl_no;
	}
	public String getDoc_srl_no( ) {
		 return doc_srl_no;
	}
	public void setStock_item_yn(String stock_item_yn) {
		 this.stock_item_yn = stock_item_yn;
	}
	public String getStock_item_yn( ) {
		 return stock_item_yn;
	}
	public void setCurr_pack_size(String curr_pack_size) {
		 this.curr_pack_size = curr_pack_size;
	}
	public String getCurr_pack_size( ) {
		 return curr_pack_size;
	}
	public void setPending_item_qty(String pending_item_qty) {
		 this.pending_item_qty = pending_item_qty;
	}
	public String getPending_item_qty( ) {
		 return pending_item_qty;
	}
	public void setCommitted_item_qty(String committed_item_qty) {
		 this.committed_item_qty = committed_item_qty;
	}
	public String getCommitted_item_qty( ) {
		 return committed_item_qty;
	}
	public void setIssued_item_qty(String issued_item_qty) {
		 this.issued_item_qty = issued_item_qty;
	}
	public String getIssued_item_qty ( ) {
		 return issued_item_qty;
	}
	public void setIssuing_item_qty (String issuing_item_qty) {
		 this.issuing_item_qty = issuing_item_qty;
	}
	public String getIssuing_item_qty ( ) {
		 return issuing_item_qty;
	}
	public void setReq_item_qty(String req_item_qty) {
		 this.req_item_qty = req_item_qty;
	}
	public String getReq_item_qty( ) {
		 return (this.req_item_qty==null)?"0":this.req_item_qty;
	}
	public void setItem_code(String item_code) {
		 this.item_code = item_code;
	}
	public String getItem_code( ) {
		 return item_code;
	}
	public void setUom_desc(String uom_desc) {
		 this.uom_desc = uom_desc;
	}
	public String getUom_desc( ) {
		 return uom_desc;
	}
	public void setUnit_cost(String unit_cost) {
		 this.unit_cost = unit_cost;
	}
	public String getUnit_cost( ) {
		 return unit_cost;
	}
	public void setSeverity_color(String severity_color) { 
		this.severity_color = severity_color;
	}
	public String getSeverity_color() {
		return severity_color;
	}
	public void setCanAcceptDecimal(boolean canAcceptDecimal) {
		this.canAcceptDecimal = canAcceptDecimal;
	}
	public boolean getCanAcceptDecimal() {
		return this.canAcceptDecimal;
	}

	public void setUomCode(String uom_code)
	{
		this.uom_code = uom_code;
	}

	public String getUomCode(){
		return uom_code;
	}
	
	public void setReq_by_qty_on_hand(String req_by_qty_on_hand) {
		this.req_by_qty_on_hand = req_by_qty_on_hand;
	}
	public String getReq_by_qty_on_hand( ) {
		 return req_by_qty_on_hand;
	}
	public void setReq_by_max_stk_level(String req_by_max_stk_level ) {
		this.req_by_max_stk_level  = req_by_max_stk_level ;
	}
	public String getReq_by_max_stk_level( ) {
		 return req_by_max_stk_level ;
	}
	public void setReq_by_min_stk_level(String req_by_min_stk_level ) {
		this.req_by_min_stk_level  = req_by_min_stk_level ;
	}
	public String getReq_by_min_stk_level( ) {
		 return req_by_min_stk_level ;
	}
	public void setReq_by_reorder_level(String req_by_reorder_level  ) {
		this.req_by_reorder_level   = req_by_reorder_level  ;
	}
	public String getReq_by_reorder_level( ) {
		 return req_by_reorder_level  ;
	}


	public void setReq_on_qty_on_hand(String req_on_qty_on_hand) {
		this.req_on_qty_on_hand = req_on_qty_on_hand;
	}
	public String getReq_on_qty_on_hand( ) {
		 return req_on_qty_on_hand;
	}
	public void setReq_on_max_stk_level(String req_on_max_stk_level ) {
		this.req_on_max_stk_level  = req_on_max_stk_level ;
	}
	public String getReq_on_max_stk_level( ) {
		 return req_on_max_stk_level ;
	}
	public void setReq_on_min_stk_level(String req_on_min_stk_level ) {
		this.req_on_min_stk_level  = req_on_min_stk_level ;
	}
	public String getReq_on_min_stk_level( ) {
		 return req_on_min_stk_level ;
	}
	public void setReq_on_reorder_level(String req_on_reorder_level  ) {
		this.req_on_reorder_level   = req_on_reorder_level  ;
	}
	public String getReq_on_reorder_level( ) {
		 return req_on_reorder_level  ;
	}
	public void setRemarksCode(String remarks_code  ) {
		this.remarks_code   = remarks_code  ;
	}
	public String getRemarksCode( ) {
		 return remarks_code  ;
	}
	public void setRemarksDesc(String remarks_desc  ) {
		this.remarks_desc   = remarks_desc  ;
	}
	public String getRemarksDesc( ) {
		 return remarks_desc  ;
	}
	public void setRemarksDesc1(String remarks_desc  ) {
		this.remarks_desc   = remarks_desc  ;
	}
	public String getRemarksDesc1( ) {
		 return remarks_desc  ;
	}
	

     public String getKit_template_uom() {
            return kit_template_uom;
      }

      public void setKit_template_uom(String kit_template_uom) {

            this.kit_template_uom = kit_template_uom;

      }

	  public void setRemarksDescNew(String remarksNew){
		  //this.remarksNew 
	  }
	  
	  //20/09/12
	public void setUsagetype(String usage_type){
		this.usage_type=usage_type;
	}
	public String getUsagetype() {
		return this.usage_type;
	} 


	public void setAll(java.util.Hashtable htResult) {

				
		setItem_desc((String) htResult.get("item_desc"));
		setDoc_srl_no((String) htResult.get("doc_srl_no"));
		setStock_item_yn((String) htResult.get("stock_item_yn"));
		setCurr_pack_size((String) htResult.get("curr_pack_size"));
		setPending_item_qty((String) htResult.get("pending_item_qty"));
		setReq_item_qty((String) htResult.get("req_item_qty"));
		setItem_code((String) htResult.get("item_code"));
		setUom_desc((String) htResult.get("uom_desc"));

		setReq_by_qty_on_hand(checkForNull((String) htResult.get("req_by_qty_on_hand"),"0"));
		setReq_by_max_stk_level(checkForNull((String) htResult.get("req_by_max_stk_level ")));
		setReq_by_min_stk_level(checkForNull((String) htResult.get("req_by_min_stk_level ")));
		setReq_by_reorder_level(checkForNull((String) htResult.get("req_by_reorder_level ")));

		setReq_on_qty_on_hand(checkForNull((String) htResult.get("req_on_qty_on_hand"),"0"));
		setReq_on_max_stk_level(checkForNull((String) htResult.get("req_on_max_stk_level ")));
		setReq_on_min_stk_level(checkForNull((String) htResult.get("req_on_min_stk_level ")));
		setReq_on_reorder_level(checkForNull((String) htResult.get("req_on_reorder_level ")));
		setIssConvText(checkForNull((String) htResult.get("iss_conv_text")));
		setReqConvText(checkForNull((String) htResult.get("req_conv_text")));
         
		  
		  

//		setKit_template_uom((String)htResult.get("kit_template_uom"));
//		setKit_item_yn((String)htResult.get("kit_item_yn"));
	

	}
	public void setAll(java.sql.ResultSet resultSet) {
//		int req_on_max_qty = 0;
		int req_on_min_qty = 0;
		int req_on_reorder_level = 0;
		double req_item_qty = 0;
		String iss_int_qty = "";
		try {

			System.out.println("uom_desc"+ (String)resultSet.getString("uom_desc"));
			System.out.println("request_uom_desc"+ (String)resultSet.getString("request_uom_desc"));
			
			String conver = "";
			int am_count=Integer.parseInt((String)fetchRecord("SELECT  count(*) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{(String)resultSet.getString("uom_code"), (String)resultSet.getString("request_uom")}).get("COUNT"));
			int item_uom_count=Integer.parseInt((String)fetchRecord("SELECT count(*) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{(String)resultSet.getString("uom_code"), (String)resultSet.getString("request_uom"),(String)resultSet.getString("item_code")}).get("COUNT"));
			if(item_uom_count!=0){
				HashMap  stEqvl_value1=fetchRecord("SELECT eqvl_value,eqvl_uom_qty ,(eqvl_value / eqvl_uom_qty) conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{(String)resultSet.getString("uom_code"), (String)resultSet.getString("request_uom"),(String)resultSet.getString("item_code")});

				//Commented to pass UOM_DESC By Sakti Sankar against Inc#32347 on 22/10/2012
				//conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+(String)resultSet.getString("uom_code")+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+(String)resultSet.getString("request_uom");
				conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+(String)resultSet.getString("uom_desc")+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+(String)resultSet.getString("request_uom_desc");
			}else if(am_count!=0){
				String stEqvl_value=(String)fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{(String)resultSet.getString("uom_code"), (String)resultSet.getString("request_uom")}).get("EQVL_VALUE");
				
				//Commented to pass UOM_DESC By Sakti Sankar against Inc#32347 on 22/10/2012
				//conver=stEqvl_value+" "+(String)resultSet.getString("uom_code")+" = 1 "+(String)resultSet.getString("request_uom");
				conver=stEqvl_value+" "+(String)resultSet.getString("uom_desc")+" = 1 "+(String)resultSet.getString("request_uom_desc");
			}else{
				//Commented to pass UOM_DESC By Sakti Sankar against Inc#32347 on 22/10/2012
				 //conver="1"+" "+(String)resultSet.getString("uom_code")+" = 1 "+(String)resultSet.getString("request_uom");
				 conver="1"+" "+(String)resultSet.getString("uom_desc")+" = 1 "+(String)resultSet.getString("request_uom_desc");
			}			
             setReqConvText(conver);
			
			String iss_default_uom = getDefaultIssueUOM((String)resultSet.getString("item_code"),(String) resultSet.getString("store_code"));

			String iss_default_uom_desc=(String)fetchRecord("SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=? ",new String[]{iss_default_uom}).get("SHORT_DESC");
			
			String conver1 = "";
			int am_count1=Integer.parseInt((String)fetchRecord("SELECT  count(*) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{(String)resultSet.getString("uom_code"), iss_default_uom}).get("COUNT"));
			int item_uom_count1=Integer.parseInt((String)fetchRecord("SELECT count(*) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{(String)resultSet.getString("uom_code"), iss_default_uom,(String)resultSet.getString("item_code")}).get("COUNT"));
			if(item_uom_count1!=0){
				HashMap  stEqvl_value1=fetchRecord("SELECT eqvl_value,eqvl_uom_qty ,(eqvl_value / eqvl_uom_qty) conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{(String)resultSet.getString("uom_code"), iss_default_uom,(String)resultSet.getString("item_code")});
				//conver1=(String)stEqvl_value1.get("EQVL_VALUE")+" "+(String)resultSet.getString("uom_code")+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+iss_default_uom;
				conver1=(String)stEqvl_value1.get("EQVL_VALUE")+" "+(String)resultSet.getString("uom_desc")+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+iss_default_uom_desc; 

			}else if(am_count1!=0){
				String stEqvl_value1=(String)fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{(String)resultSet.getString("uom_code"), iss_default_uom}).get("EQVL_VALUE");
				
				//conver1=stEqvl_value1+" "+(String)resultSet.getString("uom_code")+" = 1 "+iss_default_uom;
				conver1=stEqvl_value1+" "+(String)resultSet.getString("uom_desc")+" = 1 "+iss_default_uom_desc;
			}else{
                //conver1="1"+" "+(String)resultSet.getString("uom_code")+" = 1 "+iss_default_uom;
				conver1="1"+" "+(String)resultSet.getString("uom_desc")+" = 1 "+iss_default_uom_desc;
			}
			
			
			setIssConvText(conver1); 
			
			setStore_code((String) resultSet.getString("store_code"));
			
			setReq_by_qty_on_hand(checkForNull((String) resultSet.getString("req_by_qty_on_hand"),"0"));
			setReq_by_max_stk_level(checkForNull((String) resultSet.getString("req_by_max_stk_qty")));
			setReq_by_min_stk_level(checkForNull((String) resultSet.getString("req_by_min_stk_qty")));
			setReq_by_reorder_level(checkForNull((String) resultSet.getString("req_by_reorder_level")));
			setReq_on_qty_on_hand(checkForNull((String) resultSet.getString("req_on_qty_on_hand"),"0"));
			setReq_on_max_stk_level(checkForNull((String) resultSet.getString("req_on_max_stk_qty")));
			setReq_on_min_stk_level(checkForNull((String) resultSet.getString("req_on_min_stk_qty")));
			setReq_on_reorder_level(checkForNull((String) resultSet.getString("req_on_reorder_level")));
			//setItem_desc((String) resultSet.getString("item_desc")); commented and added below by Sakti for  MMS-SCF-0400 
			/* commented  for  GHL-SCF-1097
			String item_desc = resultSet.getString("item_desc");
			item_desc = item_desc.replaceAll(" ","%20");
			item_desc = java.net.URLEncoder.encode(item_desc,"UTF-8");
			item_desc = item_desc.replaceAll("%2520","%20");
			setItem_desc(item_desc);
			*/
			setItem_desc((String) resultSet.getString("item_desc")); // Added for GHL-SCF-1097
			setDoc_srl_no((String) resultSet.getString("doc_srl_no"));
			setStock_item_yn((String) resultSet.getString("stock_item_yn"));
			setCurr_pack_size((String) resultSet.getString("curr_pack_size"));
			if(Double.parseDouble((String) resultSet.getString("pending_item_qty"))<=0.0){
				setPending_item_qty("0");
			}else{
				setPending_item_qty((String) resultSet.getString("pending_item_qty"));
			}
			setCommitted_item_qty((String) resultSet.getString("committed_item_qty"));
			setIssued_item_qty((String) resultSet.getString("iss_item_qty"));
			if(Double.parseDouble((String) resultSet.getString("pending_item_qty"))<=0.0){
				setIssuing_item_qty("0");
			}else{
				setIssuing_item_qty((String) resultSet.getString("pending_item_qty"));
			}
			setReq_item_qty((String) resultSet.getString("req_item_qty"));
			setItem_code((String) resultSet.getString("item_code"));
			setUom_desc((String) resultSet.getString("uom_desc"));
			//setUnit_cost((String) resultSet.getString("unit_cost"));
			setUnit_cost((String) resultSet.getString("base_unit_cost"));//Added against to set base unit cost against inc#50521
			setTo_bin_location_code((String) resultSet.getString("to_bin_location_code"));
			setUsagetype(checkForNull((String) resultSet.getString("usage_type"))); //20/09/12
//			req_on_max_qty = resultSet.getInt("req_on_max_stk_qty");
			req_on_min_qty = resultSet.getInt("req_on_min_stk_qty");
			req_on_reorder_level = resultSet.getInt("req_on_reorder_level");
			iss_int_qty = (String) resultSet.getString("issue_int_qty_yn");
			if ((iss_int_qty != null) && (iss_int_qty.trim() != "")) {
				canAcceptDecimal = iss_int_qty.equals("Y");
			}
			setReq_on_reorder_level(""+req_on_reorder_level);
			req_item_qty = Double.parseDouble(getPending_item_qty());
			double avilable_qty_on_req_on_store = Double.parseDouble(getReq_on_qty_on_hand()) - Double.parseDouble(getCommitted_item_qty());
			double issue_qty = Double.parseDouble(getIssuing_item_qty());
			if ((avilable_qty_on_req_on_store - issue_qty) < req_on_min_qty) {
				setSeverity_color("HIGH");
			}
			else if((avilable_qty_on_req_on_store - issue_qty) < req_on_reorder_level) {
				setSeverity_color("LOW");
			}	
			else {
				setSeverity_color("NORMAL");
			}
			/*if (getStock_item_yn().equals("Y")) {
				if (((req_on_reorder_level-req_item_qty) <=0) || ((req_on_min_qty-req_item_qty)<=0)) {
					setSeverity_color("HIGH");
				}
				else {
					setSeverity_color("NORMAL");
				}
			}
			else {
				if (req_item_qty > req_on_max_qty) {
					setSeverity_color("LOW");
				}
				else {
					setSeverity_color("NORMAL");
				}
			}*/
			pur_uom_code  = checkForNull((String) resultSet.getString("request_uom"));
			req_conv_fact = checkForNull((String) resultSet.getString("request_uom_conv"));
			req_uom_qty   = checkForNull((String) resultSet.getString("request_uom_qty"));
			uom_code      = checkForNull((String) resultSet.getString("uom_code"));
			
			HashMap hmTempFactor = new HashMap();
			if(getAllowDecimalsYN(resultSet.getString("item_code")).equals("N")){
				hmTempFactor = (HashMap)getConvFactTemp(resultSet.getString("item_code"),(String) resultSet.getString("store_code"),(String) resultSet.getString("req_by_store_code"),iss_default_uom,"");
				setFromMultiples((String)hmTempFactor.get("FROM_STORE_MULTIPLES"));
				setToMultiples((String)hmTempFactor.get("TO_STORE_MULTIPLES"));
				setBatchMultiples((String)hmTempFactor.get("BATCH_QTY_MULTIPLES"));
				setIssueUOMMultiples((String)hmTempFactor.get("ISSUE_UOM_MULTIPLES"));
				hmTempFactor = (HashMap)getConvFactTemp(resultSet.getString("item_code"),(String) resultSet.getString("store_code"),(String) resultSet.getString("req_by_store_code"),resultSet.getString("request_uom"),"REQ_UOM");
				setReqBatchMultiples((String)hmTempFactor.get("REQ_BATCH_QTY_MULTIPLES"));
				setReqUOMMultiples((String)hmTempFactor.get("REQ_UOM_MULTIPLES"));
			}
		}
		catch (Exception e )	{
			e.printStackTrace();
		} 
	}
	public void clear() {		
		item_desc = "";
		doc_srl_no = "";
		stock_item_yn = "";
		curr_pack_size = "";
		pending_item_qty = "";
		req_item_qty = "";
		item_code = "";
		uom_desc = "";
		req_by_qty_on_hand = "0";
		req_by_max_stk_level  = "";
		req_by_min_stk_level  = "";
		req_by_reorder_level  = "";

		req_on_qty_on_hand = "0";
		req_on_max_stk_level  = "";
		req_on_min_stk_level  = "";
		req_on_reorder_level  = "";
		iss_conv_text= "";
		req_conv_text = "";

		severity_color = "NORMAL";
	}
	public String toString() {
		return doc_srl_no +" - " +item_code +" - " +item_desc +" - " +uom_desc +" - " +curr_pack_size +" - " +stock_item_yn +" - " +req_by_qty_on_hand +" - " +req_on_qty_on_hand +" - " +pending_item_qty +" - " +req_item_qty +" - " +severity_color+" - " +req_by_max_stk_level +" - " +req_by_min_stk_level +" - " +req_by_reorder_level +" - " +req_on_max_stk_level +" - " +req_on_min_stk_level +" - " +req_on_reorder_level  + " -- " +canAcceptDecimal+" - "+kit_template_uom+" - "+kit_item_yn+" - "+usage_type;
		
	}

    
 	public void setKit_item_yn(String kit_item_yn){
		this.kit_item_yn=kit_item_yn;
	}

	public String getKit_item_yn() {
		return this.kit_item_yn;
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
	public void setReqBatchMultiples(String req_batch_multiples){
		this.req_batch_multiples=req_batch_multiples;
	}

	public String getReqBatchMultiples() {
		return this.req_batch_multiples;
	} 
	public void setReqUOMMultiples(String req_uom_multiples){
		this.req_uom_multiples=req_uom_multiples;
	}

	public String getReqUOMMultiples() {
		return this.req_uom_multiples;
	} 

	public String getDefaultIssueUOM(String item_code,String store_code) throws Exception {
		String chkdefaultParameters[] = {item_code,store_code};
		String default_value		  = "";	
		HashMap default_uom			  = new HashMap();
		try{
			default_uom = fetchRecord(getStRepositoryValue("SQL_ST_ISSUE_UOM_DEFAULT"),chkdefaultParameters);
		}catch(Exception e){
			default_value = "";
			e.printStackTrace();
		}
		
		if(default_uom.size() > 0)
			default_value = (String)default_uom.get("DEF_ISSUE_UOM");

		return default_value;

	}
	
 

}
