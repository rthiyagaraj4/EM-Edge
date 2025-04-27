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

public class RequestDetailBean extends eST.Common.StTransaction implements java.io.Serializable { 

	private int srl_no;
	private String item_code;
	private String item_desc="";
	private String uom = "";
	private String uom_desc = "";
	private String required_qty="";
	private String stock_item_yn;
	private String available_stock="";
	private String req_uom_qty="";
	private String	pur_uom_code="";
	private String	conv_fact="";
	private String	qty_on_hand="";
	private String	max_stk_qty="";
	private String	kit_template_uom="";
	private String	kit_item_yn="";
	private String	kit_uom_code="";
	private String	def_issue_uom="";
	private String	uom_conv_text="";
	private String from_multiples="1";
	private String to_multiples="1";
	private String batch_multiples="1";
	private String issue_uom_multiples="1";
	private String dec_allowed_yn="N";
	private String kit_temp_code=""; //01/08/12
	private String usage_type =""; //18/09/12
	private int no_of_decimals=0;

    private String	check_box_status ;
	
	public RequestDetailBean() {
	}

	public RequestDetailBean(java.util.Hashtable detailRecord) {

		this.item_code = (String)detailRecord.get("item_code");
		this.item_desc = (String)detailRecord.get("item_desc");		
		this.uom = (String)detailRecord.get("uom");
		this.uom_desc = (String)detailRecord.get("temp_uom");
		this.required_qty = (String)detailRecord.get("required_qty");
		this.stock_item_yn = (String)detailRecord.get("stock_item_yn");
		this.srl_no = Integer.parseInt((String)detailRecord.get("srl_no"));
		this.available_stock = (String)detailRecord.get("available_stock");
		this.req_uom_qty = (String)detailRecord.get("req_uom_qty");
		this.pur_uom_code = (String)detailRecord.get("pur_uom_code");
		this.conv_fact = (String)detailRecord.get("conv_fact");
		this.qty_on_hand = (String)detailRecord.get("qty_on_hand");
		this.max_stk_qty = (String)detailRecord.get("max_stk_qty");
		this.uom_conv_text = (String)detailRecord.get("uom_conv_text");
	    this.check_box_status = (String)detailRecord.get("check_box_status");
		this.kit_template_uom=(String)detailRecord.get("kit_template_uom");
		this.kit_item_yn=(String)detailRecord.get("kit_item_yn");
		this.kit_uom_code=(String)detailRecord.get("kit_uom_code");
		this.def_issue_uom=(String)detailRecord.get("def_issue_uom");
		this.from_multiples=(String)detailRecord.get("from_multiples");
		this.to_multiples=(String)detailRecord.get("to_multiples");
		this.batch_multiples=(String)detailRecord.get("batch_multiples");
		this.issue_uom_multiples=(String)detailRecord.get("issue_uom_multiples");
		this.dec_allowed_yn=(String)detailRecord.get("dec_allowed_yn");
		this.no_of_decimals=Integer.parseInt(checkForNull((String)detailRecord.get("no_of_decimals"),"0"));
		this.kit_temp_code= (String)detailRecord.get("kit_temp_code");
		this.usage_type= (String)detailRecord.get("usage_type");
	

	}

	public RequestDetailBean(java.sql.ResultSet resultSetRecord) {

		try {
				System.out.println("gen_uom_desc"+(String)resultSetRecord.getString("gen_uom_desc"));
				System.out.println("request_uom_desc"+(String)resultSetRecord.getString("request_uom_desc"));

			String conver = "";
			int am_count=Integer.parseInt((String)fetchRecord("SELECT  count(*) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{(String)resultSetRecord.getString("gen_uom_code"), (String)resultSetRecord.getString("request_uom")}).get("COUNT"));
				int item_uom_count=Integer.parseInt((String)fetchRecord("SELECT count(*) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{(String)resultSetRecord.getString("gen_uom_code"), (String)resultSetRecord.getString("request_uom"),(String)resultSetRecord.getString("item_code")}).get("COUNT"));
				if(item_uom_count!=0){
				
				HashMap  stEqvl_value1=fetchRecord("SELECT eqvl_value,eqvl_uom_qty ,(eqvl_value / eqvl_uom_qty) conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{(String)resultSetRecord.getString("gen_uom_code"), (String)resultSetRecord.getString("request_uom"),(String)resultSetRecord.getString("item_code")});
				//Commented to pass UOM_DESC By Sakti Sankar against Inc#32347 on 22/10/2012
				//conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+(String)resultSetRecord.getString("gen_uom_code")+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+(String)resultSetRecord.getString("request_uom");

				conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+(String)resultSetRecord.getString("gen_uom_desc")+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+(String)resultSetRecord.getString("request_uom_desc");
				

							
			}else if(am_count!=0){
			String stEqvl_value=(String)fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{(String)resultSetRecord.getString("gen_uom_code"), (String)resultSetRecord.getString("request_uom")}).get("EQVL_VALUE");
				
				//Commented to pass UOM_DESC By Sakti Sankar against Inc#32347 on 22/10/2012
				//conver=stEqvl_value+" "+(String)resultSetRecord.getString("gen_uom_code")+" = 1 "+(String)resultSetRecord.getString("request_uom");
				conver=stEqvl_value+" "+(String)resultSetRecord.getString("gen_uom_desc")+" = 1 "+(String)resultSetRecord.getString("request_uom_desc");
			}else{
				//Commented to pass UOM_DESC By Sakti Sankar against Inc#32347 on 22/10/2012
				//conver="1"+" "+(String)resultSetRecord.getString("gen_uom_code")+" = 1 "+(String)resultSetRecord.getString("request_uom");
				conver="1"+" "+(String)resultSetRecord.getString("gen_uom_desc")+" = 1 "+(String)resultSetRecord.getString("request_uom_desc");
			}
		
			setSrl_no(resultSetRecord.getInt("doc_srl_no"));
			setItem_code(resultSetRecord.getString("item_code"));
			//setItem_desc(resultSetRecord.getString("item_desc"));commented and added below by ganga for  ML-BRU-SCF-0963 [IN:042099]

			String item_desc = resultSetRecord.getString("item_desc");
			/*item_desc = item_desc.replaceAll(" ","%20"); --commented for [IN:055189]
			item_desc = java.net.URLEncoder.encode(item_desc,"UTF-8");
			item_desc = item_desc.replaceAll("%2520","%20");*/
			setItem_desc(item_desc);

			//setUom(resultSetRecord.getString("uom"));
			setUom(resultSetRecord.getString("gen_uom_code"));
			setUomDesc(resultSetRecord.getString("uom_desc"));
			setRequired_qty(resultSetRecord.getString("req_item_qty"));
			setStock_item_yn(resultSetRecord.getString("stock_item_yn"));
			setAvailable_stock(resultSetRecord.getString("available_stock"));
			setReqUomQty(resultSetRecord.getString("request_uom_qty"));
			setPurUomCode(resultSetRecord.getString("request_uom"));
			setConvFact(resultSetRecord.getString("request_uom_conv"));
//			setQty_on_hand((resultSetRecord.getString("qty_on_hand")));
//			setMax_stk_qty((resultSetRecord.getString("max_stk_qty")));
			setQty_on_hand(checkForNull((String) resultSetRecord.getString("qty_on_hand")));
			setMax_stk_qty(checkForNull((String) resultSetRecord.getString("max_stk_qty")));
			setDec_allowed_yn(checkForNull((String) resultSetRecord.getString("dec_allowed_yn"),"N"));
			setNo_of_decimals(Integer.parseInt((String) resultSetRecord.getString("no_of_decimals")));
			setUomconvtext(conver);
			setUsagetype(checkForNull((String) resultSetRecord.getString("usage_type"))); //18/09/12
			

			//added by Pankaj on 06/08/2004 
			setCheck_box_status("Y") ;
			HashMap hmTempFactor = new HashMap();
			//if(getAllowDecimalsYN(resultSetRecord.getString("item_code")).equals("N")){
			if((getDec_allowed_yn()).equals("N")){
				hmTempFactor = (HashMap)getConvFactTemp(resultSetRecord.getString("item_code"),(String) resultSetRecord.getString("req_by_store_code"),(String) resultSetRecord.getString("req_on_store_code"),resultSetRecord.getString("request_uom"));
				setFromMultiples((String)hmTempFactor.get("FROM_STORE_MULTIPLES"));
				setToMultiples((String)hmTempFactor.get("TO_STORE_MULTIPLES"));
				setBatchMultiples((String)hmTempFactor.get("BATCH_QTY_MULTIPLES"));
				setIssueUOMMultiples((String)hmTempFactor.get("ISSUE_UOM_MULTIPLES"));
			}


	
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void setUomconvtext(String uomconvtext)
	{
	this.uom_conv_text = uomconvtext;
	}

	public String getUomconvtext()
	{
	return this.uom_conv_text;
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

	public void setStock_item_yn(String stock_item_yn) {	
		this.stock_item_yn = stock_item_yn;
	}
	
	public String getStock_item_yn() {
		return this.stock_item_yn;
	}

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
	public void setKit_template_uom(String kit_template_uom){
		this.kit_template_uom=kit_template_uom;
	}

	public String getKit_template_uom() {
		return this.kit_template_uom;
	} 
	public void setKit_item_yn(String kit_item_yn){
		this.kit_item_yn=kit_item_yn;
	}

	public String getKit_item_yn() {
		return this.kit_item_yn;
	} 
	public void setKit_uom_code(String kit_uom_code){
		this.kit_uom_code=kit_uom_code;
	}

	public String getKit_uom_code() {
		return this.kit_uom_code;
	} 
	public void setDef_issue_uom(String def_issue_uom){
		this.def_issue_uom=def_issue_uom;
	}

	public String getDef_issue_uom() {
		return this.def_issue_uom;
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
	
	public void setNo_of_decimals(int no_of_decimals){
		this.no_of_decimals=no_of_decimals;
	}

	public int getNo_of_decimals() {
		return this.no_of_decimals;
	} 
	public void setDec_allowed_yn(String dec_allowed_yn){
		this.dec_allowed_yn=dec_allowed_yn;
	}

	public String getDec_allowed_yn() {
		return this.dec_allowed_yn;
	} 
	
	//01/08/12
	public void setKitTemp_code(String kit_temp_code){
		this.kit_temp_code=kit_temp_code;
	}

	public String getKitTemp_code() {
		return this.kit_temp_code;
	} 
	
	//18/09/12
	public void setUsagetype(String usage_type){
		this.usage_type=usage_type;
	}

	public String getUsagetype() {
		return this.usage_type;
	} 

	public void setAll(java.util.Hashtable detailRecord) {
		setItem_code((String)detailRecord.get("item_code"));
		setItem_desc((String)detailRecord.get("item_desc"));
		setUom((String)detailRecord.get("uom"));
		setRequired_qty((String)detailRecord.get("required_qty"));
		setStock_item_yn((String)detailRecord.get("stock_item_yn"));
		setAvailable_stock((String)detailRecord.get("available_stock"));
		setReqUomQty((String)detailRecord.get("req_uom_qty"));
		setPurUomCode((String)detailRecord.get("pur_uom_code"));
		setConvFact((String)detailRecord.get("conv_fact"));
		setQty_on_hand(checkForNull((String) detailRecord.get("qty_on_hand")));
		setMax_stk_qty(checkForNull((String) detailRecord.get("max_stk_qty")));

        setCheck_box_status((String)detailRecord.get("check_box_status"));
	}

	public String toString() {
		return srl_no+" = "+item_code + " = " +item_desc + " = " + uom + " = " + required_qty+ " = " + stock_item_yn+" = "+available_stock+" = "+req_uom_qty+" = "+pur_uom_code+" = "+conv_fact+" = "+qty_on_hand+" = "+max_stk_qty+" = " + check_box_status+" = "+kit_template_uom+" = "+kit_item_yn+" = "+kit_uom_code+" = "+def_issue_uom+" = "+kit_temp_code+" = "+usage_type;
	}
}	
