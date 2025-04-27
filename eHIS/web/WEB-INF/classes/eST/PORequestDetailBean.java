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
//import eST.Common.StAdapter;
import eCommon.Common.*;
import eCommon.Common.CommonAdapter;
import eCommon.Common.CommonRepository;
import java.util.HashMap;

public class PORequestDetailBean extends eST.Common.StTransaction implements java.io.Serializable { 

	private int srl_no;
	private String item_code;
	private String item_desc="";
	private String uom = "";
	private String uom_desc = "";
	private String required_qty="";
//	private String stock_item_yn;
	private String available_stock="";
	private String req_uom_qty="";
	private String	pur_uom_code="";
	private String	conv_fact="";
	private String	qty_on_hand="";
	private String	max_stk_qty="";
	private String	pur_uom_conv_id="";

    private String	check_box_status ;
	
	public PORequestDetailBean() {
	}

	public PORequestDetailBean(java.util.Hashtable detailRecord) {
	/**
	* @Name - krishna
	* @Date - 22/01/2010
	* @Inc# - IN015496
	* @Desc - Making No.of Decimals if item is decimal item . setNumber function called
	*/

		int no_of_decimals					=			getNoOfDecimals();
		if(getAllowDecimalsYN((String)detailRecord.get("item_code")).equals("Y")){
			this.required_qty = setNumber((String)detailRecord.get("required_qty"),no_of_decimals);
			this.available_stock = setNumber((String)detailRecord.get("available_stock"),no_of_decimals);
			this.req_uom_qty =setNumber( (String)detailRecord.get("req_uom_qty"),no_of_decimals);
			this.qty_on_hand = setNumber((String)detailRecord.get("qty_on_hand"),no_of_decimals);
		}else{
			this.required_qty = setNumber((String)detailRecord.get("required_qty"),0);
			this.available_stock = setNumber((String)detailRecord.get("available_stock"),0);
			this.req_uom_qty =setNumber( (String)detailRecord.get("req_uom_qty"),0);
			this.qty_on_hand = setNumber((String)detailRecord.get("qty_on_hand"),0);
		}
		this.item_code = (String)detailRecord.get("item_code");
		this.item_desc = (String)detailRecord.get("item_desc");
		this.uom = (String)detailRecord.get("uom");
		this.uom_desc = (String)detailRecord.get("temp_uom");
		
		this.srl_no = Integer.parseInt((String)detailRecord.get("srl_no"));
		
		
		this.pur_uom_code = (String)detailRecord.get("pur_uom_code");
		this.conv_fact = (String)detailRecord.get("conv_fact");
	
		this.max_stk_qty = (String)detailRecord.get("max_stk_qty");

		//added by Pankaj on 06/08/2004
	    this.check_box_status = (String)detailRecord.get("check_box_status");
	    this.pur_uom_conv_id = (String)detailRecord.get("id_pur_uom_conv1");
	

	}

	public PORequestDetailBean(java.sql.ResultSet resultSetRecord) {
		try {
			setSrl_no(resultSetRecord.getInt("doc_srl_no"));//doc_srl_no
			setItem_code(resultSetRecord.getString("item_code"));//item_code
			setItem_desc(resultSetRecord.getString("item_desc"));//item_desc
			setUom(resultSetRecord.getString("gen_uom_code"));//uom
			setUomDesc(resultSetRecord.getString("uom_desc"));//uom_desc
	/**
	* @Name - krishna
	* @Date - 22/01/2010
	* @Inc# - IN015496
	* @Desc - Making No.of Decimals if item is decimal item . setNumber function called. 
	*/

			setRequired_qty(setNumber((String)resultSetRecord.getString("req_qty"),Integer.parseInt((String)resultSetRecord.getString("no_of_decimals"))));//REQ_QTY
			setReqUomQty(setNumber((String)resultSetRecord.getString("REQ_GEN_UOM_QTY"),Integer.parseInt((String)resultSetRecord.getString("no_of_decimals")))); //REQ_GEN_UOM_QTY
			setQty_on_hand(setNumber(checkForNull((String) resultSetRecord.getString("qty_on_hand")),Integer.parseInt((String)resultSetRecord.getString("no_of_decimals"))));//qty_on_hand
			//setAvailable_stock(resultSetRecord.getString("available_stock"));
			setAvailable_stock("");
			
			setPurUomCode(resultSetRecord.getString("req_uom"));//req_uom
			setConvFact(resultSetRecord.getString("req_gen_uom_conv_factor"));//REQ_GEN_UOM_CONV_FACTOR
			setMax_stk_qty(checkForNull((String) resultSetRecord.getString("max_stk_qty")));//max_stk_qty
			setCheck_box_status("Y") ;
			setPur_uom_conv_id( resultSetRecord.getString("req_gen_uom_conv_factor"));
			int am_count=Integer.parseInt((String)fetchRecord("SELECT  count(*) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{resultSetRecord.getString("gen_uom_code"), resultSetRecord.getString("req_uom")}).get("COUNT"));
			int item_uom_count=Integer.parseInt((String)fetchRecord("SELECT count(*) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{resultSetRecord.getString("gen_uom_code"), resultSetRecord.getString("req_uom"),resultSetRecord.getString("item_code")}).get("COUNT"));
			if(item_uom_count >0){
			HashMap  stEqvl_value1=fetchRecord("SELECT eqvl_value,eqvl_uom_qty ,(eqvl_value / eqvl_uom_qty)  conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{resultSetRecord.getString("gen_uom_code"), resultSetRecord.getString("req_uom"),resultSetRecord.getString("item_code")});
			String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+resultSetRecord.getString("gen_uom_code")+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+resultSetRecord.getString("req_uom");
			setPur_uom_conv_id( conver);
			}else if(am_count >0){
			
			String stEqvl_value=(String)fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{resultSetRecord.getString("gen_uom_code"), resultSetRecord.getString("req_uom")}).get("EQVL_VALUE");
			
			String conver=stEqvl_value+" "+resultSetRecord.getString("gen_uom_code")+" = 1 "+resultSetRecord.getString("req_uom");
			//hmTemp.put("pur_uom_conv_id",conver); 
			 
			 
			 setPur_uom_conv_id( conver);
			}else{
			String conver="1 "+resultSetRecord.getString("gen_uom_code")+" = 1 "+resultSetRecord.getString("req_uom");
			setPur_uom_conv_id( conver);
			}

			

	
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

//	public void setStock_item_yn(String stock_item_yn) {	
//		this.stock_item_yn = stock_item_yn;
//	}
	
//	public String getStock_item_yn() {
//		return this.stock_item_yn;
//	}

	public void setRequired_qty(String required_qty) {	
		this.required_qty = required_qty;
	}
	
	public String getRequired_qty() {
		return this.required_qty;
	} 	

	public void setAvailable_stock(String available_stock) {	
		this.available_stock = available_stock;
	}
	
	public String getAvailable_stock() {
		return this.available_stock;
	} 	

	public void setReqUomQty(String req_uom_qty){
		this.req_uom_qty=req_uom_qty;
	}

	public String getReqUomQty() {
		return this.req_uom_qty;
	} 	

	public void setPurUomCode(String pur_uom_code){
		this.pur_uom_code=pur_uom_code;
	}

	public String getPurUomCode() {
		return this.pur_uom_code;
	} 	

	public void setConvFact(String conv_fact){
		this.conv_fact=conv_fact;
	}

	public String getConvFact() {
		return this.conv_fact;
	} 	

	public void setQty_on_hand(String qty_on_hand){
		this.qty_on_hand=qty_on_hand;
	}

	public String getQty_on_hand() {
		return this.qty_on_hand;
	} 	
	public void setMax_stk_qty(String max_stk_qty){
		this.max_stk_qty=max_stk_qty;
	}

	public String getMax_stk_qty() {
		return this.max_stk_qty;
	} 	

    //added by Pankaj on 06/08/2004 

  
 public void setCheck_box_status(String check_box_status ){
		this.check_box_status =check_box_status ;
	}

	public String getCheck_box_status() {
		return this.check_box_status ;
	} 	

	 public void setPur_uom_conv_id(String pur_uom_conv_id ){
		this.pur_uom_conv_id =pur_uom_conv_id ;
	}

	public String getPur_uom_conv_id() {
		return this.pur_uom_conv_id ;
	} 	


	public void setAll(java.util.Hashtable detailRecord) {
		/**
	* @Name - krishna
	* @Date - 22/01/2010
	* @Inc# - IN015496
	* @Desc - Making No.of Decimals if item is decimal item . setNumber function for item level 
	*/

		int no_of_decimals					=			getNoOfDecimals();
		if(getAllowDecimalsYN((String)detailRecord.get("item_code")).equals("Y")){
			setRequired_qty(setNumber((String)detailRecord.get("required_qty"),no_of_decimals));
			setAvailable_stock(setNumber((String)detailRecord.get("available_stock"),no_of_decimals));
			setReqUomQty(setNumber((String)detailRecord.get("req_uom_qty"),no_of_decimals));
			setQty_on_hand(setNumber(checkForNull((String) detailRecord.get("qty_on_hand")),no_of_decimals));
		}else{
			setRequired_qty(setNumber((String)detailRecord.get("required_qty"),0));
			setAvailable_stock(setNumber((String)detailRecord.get("available_stock"),0));
			setReqUomQty(setNumber((String)detailRecord.get("req_uom_qty"),0));
			setQty_on_hand(setNumber(checkForNull((String) detailRecord.get("qty_on_hand")),0));
		}
		setItem_code((String)detailRecord.get("item_code"));
		setItem_desc((String)detailRecord.get("item_desc"));
		setUom((String)detailRecord.get("uom"));
		
		
		setPurUomCode((String)detailRecord.get("pur_uom_code"));
		setConvFact((String)detailRecord.get("conv_fact"));
		
		setMax_stk_qty(checkForNull((String) detailRecord.get("max_stk_qty")));
        setCheck_box_status((String)detailRecord.get("check_box_status"));
	}

	public String toString() {
		return srl_no+" = "+item_code + " = " +item_desc + " = " + uom + " = " + required_qty+ " = " +available_stock+" = "+req_uom_qty+" = "+pur_uom_code+" = "+conv_fact+" = "+qty_on_hand+" = " +" = "+max_stk_qty+" = "+ check_box_status;
	}
}	
