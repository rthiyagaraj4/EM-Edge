/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import java.sql.Clob.* ;
import javax.servlet.* ;
import javax.servlet.http.*;

import javax.rmi.* ;
import javax.naming.* ;
import eST.Common.* ;
import eCommon.Common.*;
import eCommon.SingleTableHandler.*;

public class ItemBean extends StTransaction implements Serializable {

	protected String item_code                = "" ;
	protected String medical_item_yn       	  = "N" ;
	protected String drug_item_yn          	  = "N" ;
	protected String expiry_yn             	  = "N" ;
	protected String trade_id_applicable_yn	  = "N" ;
//	protected String language_id;
	//protected int	 sale_stk_uom_conv     	  = 0 ;
	protected String mfg_item_yn           	  = "N" ;
	protected String abc_class_code        	  = "" ;
	protected String insurance_item_yn     	  = "N" ;
	protected String autoclaveable_yn      	  = "N" ;
	protected String consignment_item_yn   	  = "N" ;
	protected String refund_allow_yn       	  = "N" ;
	protected String use_after_expiry_yn   	  = "N" ;
	protected String label_reqd_yn         	  = "N" ;
	protected String repacking_group_code  	  = "" ;
	protected String repack_unit_uom	  	  = "" ;
//	protected String result_1	  	  = "" ;
	protected String issue_int_qty_yn      	  = "N" ;
//	protected String tpn_item_yn      	  = "N" ;
	protected String batch_id_applicable_yn	  = "N" ;
	protected int	 min_sale_qty			  = 0 ;
	protected int	 mfg_base_qty			  = 0 ;
	protected String phy_inv_type			  = "" ;
	protected int	 phy_inv_count_per_year	  = 0 ;
	protected int	 curr_pack_size			  = 0 ;
	protected String sterile_type			  = "" ;
	protected String machine_code			  = "" ;
	protected String spare_part_id			  = "" ;
	protected String drug_item_indicator	  = "" ;
	protected String drug_code				  = "" ;
	protected String sale_uom				  = "" ;
	protected int	 reorder_level			  = 0 ;
	protected int	 reorder_qty			  = 0 ;
	protected int	 min_stk_qty			  = 0 ;
	protected int	 max_stk_qty			  = 0 ;
	protected int	 lead_days				  = 0 ;
	protected int	 min_stock_days			  = 0 ;
	protected String buffer_perc			  = "" ;
	protected String re_orderable_yn		  = "N" ;
	protected String special_req_item		  = "N";
//	private Properties mail_Settings;
	protected String return_allowed_yn     	  = "N" ;
	protected String image_file_name     	  = "" ;
	protected String prompt_alert_yn     	  = "" ;
/**
	* @Name - Mahesh
	* @Date - 05/01/2010
	* @Inc# - IN015494
	* @Desc - Variable for Delimal Allowed
	*/
	protected String allow_decimals_yn     	  = "N" ;
	private   String emailid				  = "medicom@medicomsoft.com";
	protected String appl_for_cons 		       = "N" ; 
	protected String item_instruction		= ""; //TH-KW-CRF-0039

	public ItemBean() throws Exception
	{
		try {
			doCommon();
		}catch(Exception e) {
		e.printStackTrace();}
	}

	

	/* Set Methods Start */
	public void setItemCode( String item_code ) {
		this.item_code = item_code  ;
	}

	public void setPromptAlertYn( String prompt_alert_yn ) {
		this.prompt_alert_yn = prompt_alert_yn  ;
	}

	public void setMedicalYn( String medical_item_yn ) {
		this.medical_item_yn = medical_item_yn  ;
	}

	public void setDrugYn( String drug_item_yn ) {
		this.drug_item_yn = drug_item_yn  ;
	}

	public void setExpiryYn( String expiry_yn ) {
		this.expiry_yn = expiry_yn  ;
	}

	//code added for special item request..
	public void setSpecialItemYn(String special_req_item){
		this.special_req_item = special_req_item;
	}

	public void setTradeYn( String trade_id_applicable_yn ) {
		this.trade_id_applicable_yn = trade_id_applicable_yn  ;
	}

	/*public void setSaleConv( int sale_stk_uom_conv ) {
		this.sale_stk_uom_conv = sale_stk_uom_conv  ;
	}*/

	public void setMfgYn( String mfg_item_yn ) {
		this.mfg_item_yn = mfg_item_yn  ;
	}

	public void setAbcCode( String abc_class_code ) {
		this.abc_class_code = abc_class_code  ;
	}

	public void setInsuranceYn( String insurance_item_yn ) {
		this.insurance_item_yn = insurance_item_yn  ;
	}

	public void setAutoclaveableYn( String autoclaveable_yn ) {
		this.autoclaveable_yn = autoclaveable_yn  ;
	}

	public void setConsignmentYn( String consignment_item_yn ) {
		this.consignment_item_yn = consignment_item_yn  ;
	}

	public void setRefundYn( String refund_allow_yn ) {
		this.refund_allow_yn = refund_allow_yn  ;
	}

	public void setUseAfterExpiryYn( String use_after_expiry_yn ) {
		this.use_after_expiry_yn = use_after_expiry_yn  ;
	}

	public void setLabelYn( String label_reqd_yn ) {
		this.label_reqd_yn = label_reqd_yn  ;
	}
	public void setRepackingGroupCode( String repacking_group_code ) {
		this.repacking_group_code = repacking_group_code  ;
	}
	public void setRepackUnitUOM( String repack_unit_uom ) {
		this.repack_unit_uom = repack_unit_uom  ;
	}
	public void setIssueQtyYn( String issue_int_qty_yn ) {
		this.issue_int_qty_yn = issue_int_qty_yn  ;
	}

	public void setBatchIdYn( String batch_id_applicable_yn ) {
		this.batch_id_applicable_yn = batch_id_applicable_yn  ;
	}

	public void setMinSaleQty( int min_sale_qty ) {
		this.min_sale_qty = min_sale_qty  ;
	}

	public void setMfgBaseQty( int mfg_base_qty ) {
		this.mfg_base_qty = mfg_base_qty  ;
	}

	public void setPhyInvType( String phy_inv_type ) {
		this.phy_inv_type = phy_inv_type  ;
	}

	public void setPhyInvYear( int phy_inv_count_per_year ) {
		this.phy_inv_count_per_year = phy_inv_count_per_year  ;
	}

	public void setCurrPackSize( int curr_pack_size ) {
		this.curr_pack_size = curr_pack_size  ;
	}

	public void setSterileType( String sterile_type ) {
		this.sterile_type = sterile_type  ;
	}

	public void setMachineCode( String machine_code ) {
		this.machine_code = machine_code  ;
	}

	public void setSparePartId( String spare_part_id ) {
		this.spare_part_id = spare_part_id  ;
	}

	public void setSaleUom( String sale_uom ) {
		this.sale_uom = sale_uom  ;
	}

	public void setReorderLevel( int reorder_level ) {
		this.reorder_level = reorder_level  ;
	}

	public void setReorderQty( int reorder_qty ) {
		this.reorder_qty = reorder_qty  ;
	}

	public void setMinStkQty( int min_stk_qty ) {
		this.min_stk_qty = min_stk_qty  ;
	}

	public void setMaxStkQty( int max_stk_qty ) {
		this.max_stk_qty = max_stk_qty  ;
	}

	public void setLeadDays( int lead_days ) {
		this.lead_days = lead_days  ;
	}

	public void setMinStockDays( int min_stock_days ) {
		this.min_stock_days = min_stock_days  ;
	}

	public void setBufferPerc( String buffer_perc ) {
		this.buffer_perc = buffer_perc  ;
	}

	public void setReorderableYn( String re_orderable_yn ) {
		this.re_orderable_yn = re_orderable_yn  ;
	}

	public void setDrug_item_indicator(String drug_item_indicator){
		this.drug_item_indicator=drug_item_indicator;
	}
	
	public void setDrug_code(String drug_code){
		this.drug_code=drug_code;
	}
	public void setReturnYn( String return_allowed_yn ) {
		this.return_allowed_yn = return_allowed_yn  ;
	}
	public void setImgFileName(String image_file_name ) {
		this.image_file_name = image_file_name  ;
	}

/**
	* @Name - Mahesh
	* @Date - 05/01/2010
	* @Inc# - IN015494
	* @Desc - Setter Method for Delimal Allowed
	*/
	public void setAllow_decimals_yn( String allow_decimals_yn ) {
		this.allow_decimals_yn = allow_decimals_yn  ;
	}
	//Added by Rabbani, #inc no:30127 on 09/01/12 
	public void setAppforconYn( String appl_for_cons ) {        
		this.appl_for_cons = appl_for_cons  ;
	}
	
	// Added for TH-KW-CRF-0039
	public void setItemInstruction( String item_instruction ) {        
		this.item_instruction = item_instruction  ;
	}

//public void setLanguageId(String language_id){
	//	this.language_id=language_id;
	//}
/*public void setTPNItemYn(String tpn_item_yn){
		this.tpn_item_yn=tpn_item_yn;
	}*/

		/* Set Methods End */


	/* Get Methods Start */

//public String getLanguageId() {
	//	return this.language_id;
	//}

	public String getItemCode() {
		return this.item_code;
	}

	
	public String getPromptAlertYn() {
		return this.prompt_alert_yn;
	}

	public String getMedicalYn() {
		return this.medical_item_yn;
	}

	public String getDrugYn() {
		return this.drug_item_yn;
	}

	public String getExpiryYn() {
		return this.expiry_yn;
	}

	//code added for special request item
	public String getSpecialItemYn(){
		return this.special_req_item;
	}

	public String getTradeYn() {
		return this.trade_id_applicable_yn;
	}

	/*public int getSaleConv() {
		return this.sale_stk_uom_conv;
	}*/

	public String getMfgYn() {
		return this.mfg_item_yn;
	}

	public String getAbcCode() {
		return this.abc_class_code;
	}

	public String getInsuranceYn() {
		return this.insurance_item_yn;
	}

	public String getAutoclaveableYn() {
		return this.autoclaveable_yn;
	}

	public String getConsignmentYn() {
		return this.consignment_item_yn;
	}

	public String getRefundYn() {
		return this.refund_allow_yn;
	}

	public String getUseAfterExpiryYn() {
		return this.use_after_expiry_yn;
	}

	public String getLabelYn() {
		return this.label_reqd_yn;
	}
	public String getRepackingGroupCode() {
		return this.repacking_group_code;
	}

	public String getRepackUnitUOM() {
		return this.repack_unit_uom;
	}
	public String getIssueQtyYn() {
		return this.issue_int_qty_yn;
	}

	public String getBatchIdYn() {
		return this.batch_id_applicable_yn;
	}

	public int getMinSaleQty() {
		return this.min_sale_qty;
	}

	public int getMfgBaseQty() {
		return this.mfg_base_qty;
	}

	public String getPhyInvType() {
		return this.phy_inv_type;
	}

	public int getPhyInvYear() {
		return this.phy_inv_count_per_year;
	}

	public int getCurrPackSize() {
		return this.curr_pack_size;
	}

	public String getSterileType() {
		return this.sterile_type;
	}

	public String getMachineCode() {
		return this.machine_code;
	}
	public String getSparePartId() {
		return this.spare_part_id;
	}
	public String getSaleUom() {
		return this.sale_uom;
	}

	public int getReorderLevel() {
		return this.reorder_level;
	}

	public int getMinStkQty() {
		return this.min_stk_qty;
	}

	public int getMaxStkQty() {
		return this.max_stk_qty;
	}

	public int getLeadDays() {
		return this.lead_days;
	}

	public int getMinStockDays() {
		return this.min_stock_days;
	}

	public String getBufferPerc() {
		return this.buffer_perc;
	}

	public String getReorderableYn() {
		return this.re_orderable_yn;
	}

	public int getReorderQty(){
		return this.reorder_qty;
	}

	public String getDrug_item_indicator(){
		return this.drug_item_indicator;
	}

	public String getDrug_code(){
		return this.drug_code;
	}
	public String getReturnYn() {
		return this.return_allowed_yn;
	}

/**
	* @Name - Mahesh
	* @Date - 05/01/2010
	* @Inc# - IN015494
	* @Desc - getter Method for Delimal Allowed
	*/

	public String getAllow_decimals_yn() {
		return this.allow_decimals_yn;
	}

	public String getImgFileName() throws Exception{
		return checkForNull((String)((HashMap)fetchRecord("SELECT IMAGE_FILE_NAME FROM ST_ITEM WHERE ITEM_CODE = ?",getItemCode())).get("IMAGE_FILE_NAME"));
	}
	//Added by Rabbani, #inc no:30127 on 09/01/12 
	public String getAppforconYn() {  
		return this.appl_for_cons;
	}

	// Added for TH-KW-CRF-0039
	public String getItemInstruction( ) {        
		return this.item_instruction;
	}
 
	/*public String getTPNItemYn(){
		return this.tpn_item_yn;
	}*/


	/* Get Methods End */

	/* Over-ridden Adapter methods start here */

		public HashMap validate() {
		boolean result = true;
		HashMap resultMap = new HashMap();
		resultMap.put("result", new Boolean(result));
		resultMap.put("message", "success");
		if (!((sterile_type != null) && (sterile_type.equals("")))) {
			Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet resultSet = null;
			String message = "success";
			try {
				connection = getConnection();
				pstmt = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_STERILE_VALIDATE_SELECT"));
				pstmt.setString(1, sterile_type);
				resultSet = pstmt.executeQuery();
				if(resultSet != null && resultSet.next()) {
					result = true;
				}
				else
					result = false;
				if (!result) {
					message = "INVALID_STERILE_TYPE";
					resultMap.put("result", new Boolean(result));
					//resultMap.put("message", message);
					resultMap.put( "message", getMessage(message) );
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try{
					closeResultSet(resultSet);
					closeStatement(pstmt);
					closeConnection(connection);
				}
				catch(Exception es){
					es.printStackTrace();
				}
			}
		}
		return resultMap;
	}



	public HashMap modify()
	{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
	  	HashMap tabData = new HashMap() ;

		ArrayList ModifyData = new ArrayList();
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());

		ModifyData.add(medical_item_yn);
		ModifyData.add(drug_item_yn);
		ModifyData.add(expiry_yn);
		ModifyData.add(trade_id_applicable_yn);
	//	ModifyData.add(new Integer(sale_stk_uom_conv));
		ModifyData.add(mfg_item_yn);
		ModifyData.add(abc_class_code);
		ModifyData.add(insurance_item_yn);
		ModifyData.add(autoclaveable_yn);
		ModifyData.add(consignment_item_yn);
		ModifyData.add(refund_allow_yn);
		ModifyData.add(use_after_expiry_yn);
		ModifyData.add(label_reqd_yn);
		ModifyData.add(issue_int_qty_yn);
		ModifyData.add(batch_id_applicable_yn);
		ModifyData.add(new Integer(min_sale_qty));
	//	ModifyData.add(new Integer(mfg_base_qty));
		ModifyData.add(phy_inv_type);
		ModifyData.add(new Integer(phy_inv_count_per_year));
		ModifyData.add(new Integer(curr_pack_size));
		ModifyData.add(sterile_type);
		ModifyData.add(machine_code);
		ModifyData.add(spare_part_id);
		ModifyData.add(sale_uom);
		ModifyData.add(new Integer(reorder_level));
		ModifyData.add(new Integer(reorder_qty));
		ModifyData.add(new Integer(min_stk_qty));
		ModifyData.add(new Integer(max_stk_qty));
		ModifyData.add(new Integer(lead_days));
		ModifyData.add(new Integer(min_stock_days));
		ModifyData.add(buffer_perc);
		ModifyData.add(re_orderable_yn);

		ModifyData.add(login_by_id);
		ModifyData.add(login_at_ws_no);
		ModifyData.add(login_facility_id);
		//code added for special request item...
		ModifyData.add(special_req_item);
		ModifyData.add(repacking_group_code);
		ModifyData.add(repack_unit_uom);
		ModifyData.add(getReturnYn());
		ModifyData.add(this.image_file_name);
		ModifyData.add(prompt_alert_yn);
/**
	* @Name - Mahesh
	* @Date - 05/01/2010
	* @Inc# - IN015494
	* @Desc - Passing value to update Table
	*/

		ModifyData.add(allow_decimals_yn);
	//	ModifyData.add(tpn_item_yn);
	    ModifyData.add(appl_for_cons); //Added by Rabbani, #inc no:30127 on 09/01/12
		 
		ModifyData.add(item_instruction); //TH-KW-CRF-0039
		ModifyData.add(item_code);
		
		tabData.put( "ModifyData",	ModifyData ) ;
		tabData.put( "properties",	getProperties() ) ;
		tabData.put("LanguageData",LanguageData);


		HashMap sqlMap = new HashMap() ;

//		SingleTableHandlerHome home = null ;
		SingleTableHandlerRemote remote = null ;

		try
			{

				sqlMap.put("ModifySQL", eST.Common.StRepository.getStKeyValue( "SQL_ST_ITEM_UPDATE" ));
				sqlMap.put("ModifySQL", "UPDATE	st_item	SET	medical_item_yn	= ?	, drug_item_yn = ? , expiry_yn = ? , trade_id_applicable_yn	= ?	, mfg_item_yn =	? ,	abc_class_code = ? , insurance_item_yn = ? , autoclaveable_yn =	? ,	consignment_item_yn	= ?	, refund_allow_yn =	? ,	use_after_expiry_yn	= ?	, label_reqd_yn	= ?	, issue_int_qty_yn = ? , batch_id_applicable_yn	= ?	 , min_sale_qty	= ?	, phy_inv_type= ?,  phy_inv_count_per_year = ? , curr_pack_size =	?  , sterile_type =	? ,	machine_code = ? , spare_part_id = ?  ,	sale_uom_code =	? ,	reorder_level =	? ,	reorder_qty	= ?	 , min_stk_qty = ? , max_stk_qty = ? , lead_days = ?  ,	min_stock_days = ? , buffer_perc = ? , re_orderable_yn = ?	, modified_by_id = ? , modified_date = SYSDATE , modified_at_ws_no = ? , modified_facility_id =	? ,special_req_item_yn = ?,repacking_group_code = ? ,repack_unit_uom = ?,RETURN_ALLOWED_YN = ?,IMAGE_FILE_NAME = ?,PROMPT_ALERT_PREFERRED_DRUG=?,allow_decimals_yn= ?,appl_for_cons =?, ITEM_INSTRUCTION = ?  WHERE	item_code = ?");
				/*	InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER") ) ;

				home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.modify( tabData, sqlMap ) ;*/
				Object home1 = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj = (home1.getClass().getMethod("create",null)).invoke(home1,null);
	
				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); 
				paramArray[1] = sqlMap.getClass();

			map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				if( ((Boolean) map.get( "result" )).booleanValue() )
					map.put("message", getSTMessage(getLanguageId(),(String) map.get("msgid" ),"ST") ) ;
				//map.put("msgid", (String) map.get("message"));
				else
					map.put("message",map.get("msgid"));

			}
			catch(Exception e)
			{
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			}
			finally
			{
			try {
					if( remote != null )
						remote.remove() ;
				}
				catch( Exception ee )
				{
					map.put( "message", ee.getMessage() ) ;
				}
			}

		return map ;
	}

	public HashMap insert()
	{
                

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		HashMap tabData = new HashMap() ;
		ArrayList WhereData = new ArrayList();
		ArrayList InsertData = new ArrayList();
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());


		InsertData.add(item_code);
		InsertData.add(medical_item_yn);
		InsertData.add(drug_item_yn);
		InsertData.add(expiry_yn);
		InsertData.add(trade_id_applicable_yn);
		//InsertData.add(new Integer(sale_stk_uom_conv));
		InsertData.add(mfg_item_yn);
		InsertData.add(abc_class_code);
		InsertData.add(insurance_item_yn);
		InsertData.add(autoclaveable_yn);
		InsertData.add(consignment_item_yn);
		InsertData.add(refund_allow_yn);
		InsertData.add(use_after_expiry_yn);
		InsertData.add(label_reqd_yn);
		InsertData.add(issue_int_qty_yn);
		InsertData.add(batch_id_applicable_yn);
		InsertData.add(new Integer(min_sale_qty));
		InsertData.add(new Integer(mfg_base_qty));
		InsertData.add(phy_inv_type);
		InsertData.add(new Integer(phy_inv_count_per_year));
		InsertData.add(new Integer(curr_pack_size));
		InsertData.add(sterile_type);
		InsertData.add(machine_code);
		InsertData.add(spare_part_id);
		InsertData.add(sale_uom);
		InsertData.add(new Integer(reorder_level));
		InsertData.add(new Integer(reorder_qty));
		InsertData.add(new Integer(min_stk_qty));
		InsertData.add(new Integer(max_stk_qty));
		InsertData.add(new Integer(lead_days));
		InsertData.add(new Integer(min_stock_days));
		InsertData.add(buffer_perc);
		InsertData.add(re_orderable_yn);


		InsertData.add(login_by_id);
		InsertData.add(login_at_ws_no);
		InsertData.add(login_facility_id);
		InsertData.add(login_by_id);
		InsertData.add(login_at_ws_no);
		InsertData.add(login_facility_id);

		//code added to insert special request item
		InsertData.add(getSpecialItemYn());
		InsertData.add(repacking_group_code);
		InsertData.add(repack_unit_uom);
		InsertData.add(getReturnYn());
		InsertData.add(this.image_file_name);
		InsertData.add(prompt_alert_yn);
/**
	* @Name - Mahesh
	* @Date - 05/01/2010
	* @Inc# - IN015494
	* @Desc - Passing Value to insert.
	*/
		InsertData.add(allow_decimals_yn);
	//	InsertData.add(tpn_item_yn);
	    InsertData.add(appl_for_cons);  //Added by Rabbani, #inc no:30127 on 09/01/12
	// Added for TH-KW-CRF-0039
		InsertData.add(item_instruction);   
		
		WhereData.add(item_code);
		tabData.put( "InsertData",	InsertData ) ;
		tabData.put( "WhereData",	WhereData ) ;
		tabData.put( "properties",	getProperties() ) ;
		tabData.put("LanguageData",LanguageData);

		HashMap sqlMap = new HashMap() ;

//		SingleTableHandlerHome home = null ;
		SingleTableHandlerRemote remote = null ;

		try {

				//sqlMap.put( "InsertSQL", eST.Common.StRepository.getStKeyValue( "SQL_ST_ITEM_INSERT" ));
				sqlMap.put( "InsertSQL", "INSERT	INTO st_item (item_code, medical_item_yn,drug_item_yn,expiry_yn,trade_id_applicable_yn,mfg_item_yn,abc_class_code,insurance_item_yn,autoclaveable_yn,consignment_item_yn,refund_allow_yn,use_after_expiry_yn,label_reqd_yn,issue_int_qty_yn,batch_id_applicable_yn,min_sale_qty,mfg_base_qty,phy_inv_type,phy_inv_count_per_year,curr_pack_size,sterile_type,machine_code,spare_part_id,sale_uom_code,reorder_level,reorder_qty,min_stk_qty,max_stk_qty,lead_days,min_stock_days,buffer_perc,re_orderable_yn,added_by_id,added_date, added_at_ws_no, added_facility_id,modified_by_id,modified_date ,	modified_at_ws_no,modified_facility_id,special_req_item_yn ,repacking_group_code,repack_unit_uom,RETURN_ALLOWED_YN,IMAGE_FILE_NAME,PROMPT_ALERT_PREFERRED_DRUG,allow_decimals_yn,appl_for_cons, ITEM_INSTRUCTION) VALUES	 ( ? , ? , ? , ? , ? , ? , ? , ?, ?	, ?	, ?	, ?	, ? , ?	, ?, ? , ? , ? , ? , ? , ? , ? ,? ,	? ,	? ,	? ,	? ,	? ,	? ,	?, ?, ?	, ?, SYSDATE , ? , ? ,?	,SYSDATE , ? , ?, ?, ?, ?, ?,?,?,?,?,?)"); //added ITEM_INSTRUCTION TH-KW_-CRF-0039
				sqlMap.put( "SelectSQL", eST.Common.StRepository.getStKeyValue( "SQL_ST_ITEM_EXISTS"));
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER") ) ;
				home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.insert( tabData, sqlMap ) ;*/
				Object home1 = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj = (home1.getClass().getMethod("create",null)).invoke(home1,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); 
				paramArray[1] = sqlMap.getClass();

				 map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


				if( ((Boolean) map.get( "result" )).booleanValue() ){
				
					if(! emailid.equals("")){
					try{
					//	String user;
					//	String from = "Administrator";
						java.util.Locale currentLocale = java.util.Locale.getDefault() ;
						java.util.ResourceBundle mailRsrc =null;
						mailRsrc = java.util.ResourceBundle.getBundle( "MailServer", currentLocale ) ;
						String mail_server_ip_address=mailRsrc.getString("MAIL_SERVER_IP");
						Properties props = new Properties();
						props.put("mail.smtp.host",mail_server_ip_address);
						props.put("mail.smtp.from","MEDICOM");
						props.put("mail.smtp.user","MEDICOM");
//						String sentTo [] = {emailid};
						//MailDemoModified.postMail(sentTo,"Item Created Successfully"," Item Code :"+item_code,props);
						}catch(Exception ex){
						}
						}

					String errorMessage	=	"";
  				    /*if((getDrug_code()!=null) || (getDrug_code()!=""))
					{

                        String err_message="";
					 	String [] params={getItemCode(),getDrug_code(),getSaleUom(),login_by_id,login_facility_id,login_at_ws_no,getDrug_item_indicator(),err_message};
						java.util.HashMap hashDrug = new java.util.HashMap();
						hashDrug=UpdateDrug(params);
						errorMessage=(String)hashDrug.get("p_err_mesg");
						if (errorMessage==null || errorMessage.equals("null")) {
							errorMessage="";
						}
					}*/
					map.put( "message", getSTMessage(getLanguageId(),(String) map.get("msgid" ),"ST") +"<br>"+errorMessage) ;
					map.put( "flag", errorMessage) ;
				}
				else
					map.put( "message", map.get("msgid") ) ;
				
			}
			catch(Exception e)
			{
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
			}
			finally
			{
				try {
						if( remote != null )
							remote.remove() ;
					} catch( Exception ee )
					{
						map.put( "message", ee.getMessage() ) ;
					}
			}
					return map ;
	}

	public void clear()
	{

		item_code              ="";
		medical_item_yn        ="N";
		drug_item_yn           ="N";
		expiry_yn              ="N";
		trade_id_applicable_yn ="N";
		//sale_stk_uom_conv      =0;
		mfg_item_yn            ="N";
		abc_class_code         ="";
		insurance_item_yn      ="N";
		autoclaveable_yn       ="N";
		consignment_item_yn    ="N";
		refund_allow_yn        ="N";
		use_after_expiry_yn    ="N";
		label_reqd_yn          ="N";
		issue_int_qty_yn       ="N";
		batch_id_applicable_yn ="N";
		min_sale_qty		   = 0 ;
		mfg_base_qty		   = 0 ;
		phy_inv_type		   = "" ;
		phy_inv_count_per_year = 0 ;
		curr_pack_size		   = 0 ;
		sterile_type		   = "" ;
		machine_code		   = "" ;
		spare_part_id		   = "" ;
		sale_uom			   = "" ;
		repacking_group_code   = "" ;
		repack_unit_uom		   = "" ;
		reorder_level		   = 0 ;
		reorder_qty			   = 0 ;
		min_stk_qty			   = 0 ;
		max_stk_qty			   = 0 ;
		lead_days			   = 0 ;
		min_stock_days		   = 0 ;
		buffer_perc			   ="" ;
		re_orderable_yn		   = "N" ;
		special_req_item	   = "N";
	//	tpn_item_yn	   = "N";
		prompt_alert_yn        ="N";
		allow_decimals_yn        ="N";
		appl_for_cons         = "N";  //Added by Rabbani, #inc no:30127 on 09/01/12
		item_instruction	  = ""; //TH-KW-CRF-0039

		super.clear() ;
	}


public void setAll( Hashtable recordSet ) {

if(recordSet.containsKey("item_code"))
			setItemCode((String)recordSet.get("item_code")) ;

if(recordSet.containsKey("drug_code"))
			setDrug_code((String)recordSet.get("drug_code")) ;


if(recordSet.containsKey("medical_item_yn")&& (!((String)recordSet.get("medical_item_yn")).equals("")))
			setMedicalYn((String)recordSet.get("medical_item_yn")) ;
		else
			setMedicalYn("N") ;

if(recordSet.containsKey("drug_item_yn")&& (!((String)recordSet.get("drug_item_yn")).equals("")))
			setDrugYn((String)recordSet.get("drug_item_yn")) ;
		else
			setDrugYn("N") ;

if(recordSet.containsKey("expiry_yn")&& (!((String)recordSet.get("expiry_yn")).equals("")))
			setExpiryYn((String)recordSet.get("expiry_yn")) ;
		else
			setExpiryYn("N") ;

if(recordSet.containsKey("trade_id_applicable_yn")&& (!((String)recordSet.get("trade_id_applicable_yn")).equals("")))
			setTradeYn((String)recordSet.get("trade_id_applicable_yn")) ;
		else
			setTradeYn("N") ;

/*if(recordSet.containsKey("sale_stk_uom_conv"))
			setSaleConv((Integer.parseInt(checkForNull((String)recordSet.get("sale_stk_uom_conv"),"0")))) ;
 */
if(recordSet.containsKey("mfg_item_yn")&& (!((String)recordSet.get("mfg_item_yn")).equals("")))
			setMfgYn((String)recordSet.get("mfg_item_yn")) ;
		else
			setMfgYn("N") ;

if(recordSet.containsKey("abc_class_code"))
			setAbcCode((String)recordSet.get("abc_class_code")) ;

if(recordSet.containsKey("drug_item_indicator"))
			setDrug_item_indicator((String)recordSet.get("drug_item_indicator")) ;

if(recordSet.containsKey("insurance_item_yn")&& (!((String)recordSet.get("insurance_item_yn")).equals("")))
			setInsuranceYn((String)recordSet.get("insurance_item_yn")) ;
		else
			setInsuranceYn("N") ;

if(recordSet.containsKey("autoclaveable_yn")&& (!((String)recordSet.get("autoclaveable_yn")).equals("")))
			setAutoclaveableYn((String)recordSet.get("autoclaveable_yn")) ;
		else
			setAutoclaveableYn("N") ;

if(recordSet.containsKey("consignment_item_yn")&& (!((String)recordSet.get("consignment_item_yn")).equals("")))
			setConsignmentYn((String)recordSet.get("consignment_item_yn")) ;
		else
			setConsignmentYn("N") ;

if(recordSet.containsKey("refund_allow_yn")&& (!((String)recordSet.get("refund_allow_yn")).equals("")))
			setRefundYn((String)recordSet.get("refund_allow_yn")) ;
		else
			setRefundYn("N") ;

if(recordSet.containsKey("use_after_expiry_yn")&& (!((String)recordSet.get("use_after_expiry_yn")).equals("")))
			setUseAfterExpiryYn((String)recordSet.get("use_after_expiry_yn")) ;
		else
			setUseAfterExpiryYn("N") ;

if(recordSet.containsKey("batch_id_applicable_yn")&& (!((String)recordSet.get("batch_id_applicable_yn")).equals("")))
			setBatchIdYn((String)recordSet.get("batch_id_applicable_yn")) ;
		else
			setBatchIdYn("N") ;

if(recordSet.containsKey("issue_int_qty_yn")&& (!((String)recordSet.get("issue_int_qty_yn")).equals("")))
			setIssueQtyYn((String)recordSet.get("issue_int_qty_yn")) ;
		else
			setIssueQtyYn("N") ;

	/*	if(recordSet.containsKey("tpn_item_yn")&& (!((String)recordSet.get("tpn_item_yn")).equals("")))
			setTPNItemYn((String)recordSet.get("tpn_item_yn")) ;
		else
			setTPNItemYn("N") ;*/


if(recordSet.containsKey("label_reqd_yn")&& (!((String)recordSet.get("label_reqd_yn")).equals("")))
			setLabelYn((String)recordSet.get("label_reqd_yn")) ;
		else
			setLabelYn("N") ;

if(recordSet.containsKey("min_sale_qty"))
			setMinSaleQty((Integer.parseInt(checkForNull((String)recordSet.get("min_sale_qty"),"0")))) ;

if(recordSet.containsKey("mfg_base_qty"))
			setMfgBaseQty((Integer.parseInt(checkForNull((String)recordSet.get("mfg_base_qty"),"0")))) ;


if(recordSet.containsKey("phy_inv_type"))
			setPhyInvType((String)recordSet.get("phy_inv_type")) ;

if(recordSet.containsKey("phy_inv_count_per_year"))
			setPhyInvYear((Integer.parseInt(checkForNull((String)recordSet.get("phy_inv_count_per_year"),"0")))) ;

 if(recordSet.containsKey("curr_pack_size"))
			setCurrPackSize((Integer.parseInt(checkForNull((String)recordSet.get("curr_pack_size"),"0")))) ;

 if(recordSet.containsKey("sterile_type"))
			setSterileType((String)recordSet.get("sterile_type")) ;

 if(recordSet.containsKey("machine_code"))
			setMachineCode((String)recordSet.get("machine_code")) ;

 if(recordSet.containsKey("spare_part_id"))
			setSparePartId((String)recordSet.get("spare_part_id")) ;

 if(recordSet.containsKey("repacking_unit"))
			setRepackingGroupCode((String)recordSet.get("repacking_unit")) ;

 if(recordSet.containsKey("repacking_uom"))
			setRepackUnitUOM((String)recordSet.get("repacking_uom")) ;

 if(recordSet.containsKey("sale_uom"))
			setSaleUom((String)recordSet.get("sale_uom")) ;
 
 if(recordSet.containsKey("reorder_level"))
			setReorderLevel((Integer.parseInt(checkForNull((String)recordSet.get("reorder_level"),"0")))) ;


if(recordSet.containsKey("reorder_qty"))
			setReorderQty((Integer.parseInt(checkForNull((String)recordSet.get("reorder_qty"),"0")))) ;

if(recordSet.containsKey("min_stk_qty"))
			setMinStkQty((Integer.parseInt(checkForNull((String)recordSet.get("min_stk_qty"),"0")))) ;

if(recordSet.containsKey("max_stk_qty"))
			setMaxStkQty((Integer.parseInt(checkForNull((String)recordSet.get("max_stk_qty"),"0")))) ;

if(recordSet.containsKey("lead_days"))
			setLeadDays((Integer.parseInt(checkForNull((String)recordSet.get("lead_days"),"0")))) ;

if(recordSet.containsKey("min_stock_days"))
			setMinStockDays((Integer.parseInt(checkForNull((String)recordSet.get("min_stock_days"),"0")))) ;

if(recordSet.containsKey("buffer_perc"))
			setBufferPerc((String)recordSet.get("buffer_perc")) ;

if(recordSet.containsKey("re_orderable_yn")&& (!((String)recordSet.get("re_orderable_yn")).equals("")))
			setReorderableYn((String)recordSet.get("re_orderable_yn")) ;
		else
			setReorderableYn("N") ;

		//code added to include special item request...

		if(recordSet.containsKey("special_req_item")&& (!((String)recordSet.get("special_req_item")).equals("")))
			setSpecialItemYn((String)recordSet.get("special_req_item")) ;
		else
			setSpecialItemYn("N") ;
		setReturnYn(checkForNull((String)recordSet.get("return_allowed_yn"),"N")) ;
/**
	* @Name - Mahesh
	* @Date - 05/01/2010
	* @Inc# - IN015494
	* @Desc - Setting Value for Apply
	*/

		setAllow_decimals_yn(checkForNull((String)recordSet.get("allow_decimals_yn"),"N")) ;

		setImgFileName(checkForNull((String)recordSet.get("image_file_name"),"")) ;


		if(recordSet.containsKey("prompt_alert_yn")&& (!((String)recordSet.get("prompt_alert_yn")).equals("")))
			setPromptAlertYn((String)recordSet.get("prompt_alert_yn")) ;
		else
			setPromptAlertYn("N") ;
			
			//Added by Rabbani, #inc no:30127 on09/01/12
			if(recordSet.containsKey("appl_for_cons")&& (!((String)recordSet.get("appl_for_cons")).equals("")))
			setAppforconYn((String)recordSet.get("appl_for_cons")) ;
		else
			setAppforconYn("N") ;
	
		
		setItemInstruction(checkForNull((String)recordSet.get("item_instruction"),"")) ;//TH-KW-CRF-0039


		
}
private void doCommon() throws Exception {

}
/* Over-ridden Adapter methods end here */
/* Function specific methods start */
public String getBatchID()
{
	return getStaticListOptionTag("N,Not-Applicable;Y,User Enterable",getBatchIdYn());
}

public String getBatchIDList()
{
	return getStaticListOptionTag("N,Not-Applicable;Y,User Enterable;E,Same As Expiry Date",getBatchIdYn());
}

public String getCountPerYear()
{
	return getStaticListOptionTag("1,1;2,2;3,3;4,4;6,6;12,12",""+getPhyInvYear());
}
public String getRepackingGroup()
{
	ArrayList arr_lang=new ArrayList();
	//arr_lang.add(getLoginFacilityId());
	arr_lang.add(getLanguageId());
	//ring chkParameters[] = {getLoginFacilityId()};
	//return getListOptionTag( getListOptionArrayList(getStRepositoryValue("SQL_ST_ITEM_REPACKING_UNIT_SELECT_LIST"),arr_lang),getRepackingGroupCode());
	//Added by Rabbani #43360  on 13-SEP-2013 
	return getListOptionTag( getListOptionArrayList(getStRepositoryValue("SQL_ST_ITEM_REPACKING_GROUP_SELECT_LIST"),arr_lang),getRepackingGroupCode());
	
}

public String getRepackingUOM(String eqvl_uom_code)
{
	String chkParameters[] = {eqvl_uom_code,getLanguageId(),eqvl_uom_code,getLanguageId()};
	return getListOptionTag( getListOptionArrayList(getStRepositoryValue("SQL_ST_ITEM_UOM_SELECT_LIST"),chkParameters),getRepackUnitUOM());
}
public ArrayList getPur_uom_code_List(String parameters) throws Exception{
		String chkParameters[] = {parameters,getLanguageId()};
		ArrayList result = new ArrayList();
		result = fetchRecords(getStRepositoryValue("SQL_ST_ITEM_EQVL_UOM_SELECT_LIST"),chkParameters);
		return result;
	}


public String getABCAnalysis()
{
	return getStaticListOptionTag("A,A;B,B;C,C",getAbcCode());
}

public String getAM_Uom_List()
{
		ArrayList arr_lang=new ArrayList();
	//arr_lang.add(getLoginFacilityId());
	arr_lang.add(getLanguageId());
	String sql_AM=getStRepositoryValue("SQL_ST_AM_UOM_SELECT");
	//String chkParameters[] = {getLoginFacilityId()};
	return getListOptionTag( getListOptionArrayList(sql_AM,arr_lang),getSaleUom());
}

public String getMachine()
{
	//ArrayList arr_lang=new ArrayList();
	//arr_lang.add(getLanguageId());
	//String sql_machine="SELECT	machine_code,machine_name FROM st_machine where	eff_status='E' and  added_facility_id  = ?";
	String chkParameters[] = {getLoginFacilityId(),getLanguageId()};
	return getListOptionTag( getListOptionArrayList(getStRepositoryValue("SQL_ST_MACHINE_SELECT1"),chkParameters),getMachineCode());
}

public boolean isCSSDModuleInstalled() throws Exception{
	return !fetchRecord(getStRepositoryValue( "SQL_ST_SS_MODULE_SEARCH"),getLoginFacilityId()).get("TOTAL").toString().equals("0");
}


public java.util.HashMap DrugCheck(java.util.Hashtable itemRecord) {
		java.util.HashMap hashDrug = new java.util.HashMap();
		
		String item_code = (String) itemRecord.get("item_code");
		
		String [] params={item_code};
		try {
			hashDrug=getDrugStatus(params);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

	return hashDrug;

}



public java.util.HashMap getValidDrug(java.util.Hashtable itemRecord) {
		java.util.HashMap hashDrug = new java.util.HashMap();
		
		String drug_code = (String) itemRecord.get("drug_code");
		
		String [] params={drug_code};
		try {
			hashDrug=getDrugStatus(params);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

	return hashDrug;

}


public void loadData() throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {

			connection = getConnection();
			if (isCSSDModuleInstalled())
			{

				//pstmt = connection.prepareStatement(getStRepositoryValue( "SQL_ST_LOAD_QUERY"));
				pstmt = connection.prepareStatement("SELECT	item_code,medical_item_yn,drug_item_yn,expiry_yn,batch_id_applicable_yn,trade_id_applicable_yn,sale_uom_code,min_sale_qty,mfg_item_yn,mfg_base_qty,phy_inv_type,phy_inv_count_per_year,last_phy_inv_date,abc_class_code,last_issue_date,last_transfer_date,last_mfg_date,curr_pack_size,insurance_item_yn,autoclaveable_yn,sterile_type,consignment_item_yn,refund_allow_yn,use_after_expiry_yn,label_reqd_yn,machine_code,issue_int_qty_yn,spare_part_id,reorder_level,reorder_qty,min_stk_qty,max_stk_qty,lead_days,min_stock_days,buffer_perc,re_orderable_yn,special_req_item_yn,repacking_group_code,repack_unit_uom,return_allowed_yn,image_file_name,prompt_alert_preferred_drug,allow_decimals_yn,appl_for_cons,item_instruction FROM	st_item	WHERE item_code=?");//added item_instruction /TH-KW-CRF-0039
				pstmt.setString( 1, item_code);
				resultSet = pstmt.executeQuery();

			}
			else
			{
				//pstmt = connection.prepareStatement(getStRepositoryValue( "SQL_ST_LOAD_QUERY"));
				pstmt = connection.prepareStatement("SELECT	item_code,medical_item_yn,drug_item_yn,expiry_yn,batch_id_applicable_yn,trade_id_applicable_yn,sale_uom_code,min_sale_qty,mfg_item_yn,mfg_base_qty,phy_inv_type,phy_inv_count_per_year,last_phy_inv_date,abc_class_code,last_issue_date,last_transfer_date,last_mfg_date,curr_pack_size,insurance_item_yn,autoclaveable_yn,sterile_type,consignment_item_yn,refund_allow_yn,use_after_expiry_yn,label_reqd_yn,machine_code,issue_int_qty_yn,spare_part_id,reorder_level,reorder_qty,min_stk_qty,max_stk_qty,lead_days,min_stock_days,buffer_perc,re_orderable_yn,special_req_item_yn,repacking_group_code,repack_unit_uom,return_allowed_yn,image_file_name,prompt_alert_preferred_drug,allow_decimals_yn,appl_for_cons,item_instruction FROM	st_item	WHERE item_code=?"); //added item_instruction /TH-KW-CRF-0039
						

				pstmt.setString( 1, item_code);
				resultSet = pstmt.executeQuery();
			}
				if (resultSet.next()) {
					setItemCode(resultSet.getString		("item_code"));
					setMedicalYn(resultSet.getString	("medical_item_yn"));
					setDrugYn(resultSet.getString		("drug_item_yn"));
					setExpiryYn(resultSet.getString		("expiry_yn"));
					//setSaleConv(resultSet.getInt		("sale_stk_uom_conv"));
					setMfgYn(resultSet.getString		("mfg_item_yn"));
					setAbcCode(resultSet.getString		("abc_class_code"));
					setInsuranceYn(resultSet.getString	("insurance_item_yn"));
					setAutoclaveableYn(resultSet.getString	("autoclaveable_yn"));
					setConsignmentYn(resultSet.getString	("consignment_item_yn"));
					setRefundYn(resultSet.getString	("refund_allow_yn"));
					setUseAfterExpiryYn(resultSet.getString	("use_after_expiry_yn"));
					setLabelYn(resultSet.getString	("label_reqd_yn"));
					setIssueQtyYn(resultSet.getString("issue_int_qty_yn"));
					setBatchIdYn(resultSet.getString	("batch_id_applicable_yn"));
					setMinSaleQty(resultSet.getInt("min_sale_qty"));
					setMfgBaseQty(resultSet.getInt("mfg_base_qty"));
					setPhyInvType(resultSet.getString("phy_inv_type"));
					setPhyInvYear(resultSet.getInt("phy_inv_count_per_year"));
					setCurrPackSize(resultSet.getInt	("curr_pack_size"));
					setSterileType(resultSet.getString	("sterile_type"));
					setMachineCode(resultSet.getString	("machine_code"));
					setSparePartId(resultSet.getString	("spare_part_id"));
					setSaleUom(resultSet.getString	("sale_uom_code"));
					setReorderLevel(resultSet.getInt	("reorder_level"));
					setReorderQty(resultSet.getInt	("reorder_qty"));
					setMinStkQty(resultSet.getInt	("min_stk_qty"));
					setMaxStkQty(resultSet.getInt	("max_stk_qty"));
					setLeadDays(resultSet.getInt	("lead_days"));
					setMinStockDays(resultSet.getInt	("min_stock_days"));
					setBufferPerc(resultSet.getString	("buffer_perc"));
					setReorderableYn(resultSet.getString	("re_orderable_yn"));
					setSpecialItemYn(resultSet.getString	("special_req_item_yn"));
					setRepackingGroupCode(resultSet.getString	("repacking_group_code"));
					setRepackUnitUOM(resultSet.getString	("repack_unit_uom"));
					setReturnYn(checkForNull(resultSet.getString("return_allowed_yn"),"N")) ;
					setImgFileName(checkForNull(resultSet.getString("image_file_name"))) ;
					//setTPNItemYn(resultSet.getString	("tpn_item_yn"));
					setPromptAlertYn(checkForNull(resultSet.getString	("prompt_alert_preferred_drug"),"N"));
/**
	* @Name - Mahesh
	* @Date - 05/01/2010
	* @Inc# - IN015494
	* @Desc - Setting Value for Display @loaddata
	*/

					setAllow_decimals_yn(checkForNull(resultSet.getString("allow_decimals_yn"),"N"));
					setAppforconYn(resultSet.getString("appl_for_cons"));	//Added by Rabbani, #inc no:30127 on 09/01/12
					setItemInstruction(resultSet.getString("item_instruction"));//TH-KW-CRF-0039
				

				}
				

		}
		catch (Exception e )	{
			e.printStackTrace();
			throw e;
		}
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}

		}
	}

public boolean checkItemExist()
	{
			Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet resultSet = null;
			boolean result		= false;

			try {
				connection = getConnection();
				pstmt = connection.prepareStatement(getStRepositoryValue( "SQL_ST_ITEM_CHECK"));
				pstmt.setString( 1, item_code);
				resultSet = pstmt.executeQuery();
				result=resultSet.next();
			}
			catch (Exception e )	{
				e.printStackTrace();

			}
			finally {
				try{
					closeResultSet(resultSet);
					closeStatement(pstmt);
					closeConnection(connection);
				}
				catch(Exception es) {
					es.printStackTrace();
				}
				
			}
return result;
	}
/*	public String getsuppdesc(item_code)
	{
			Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet resultSet = null;
			boolean result		= false;

			try {
				connection = getConnection();
				pstmt = connection.prepareStatement(getStRepositoryValue( "SQL_ST_GET_SUPPLIER"));
				pstmt.setString( 1, item_code);
				resultSet = pstmt.executeQuery();
				if(resultSet!=null)
				{
				 result_1=resultSet.getString("supp_short_name");
				}
				//if (resultSet != null && resultSet.next()) {
				//result=resultSet.next();
			}
			catch (Exception e )	{
				e.printStackTrace();

			}
			finally {
				try{
					closeResultSet(resultSet);
					closeStatement(pstmt);
					closeConnection(connection);
				}
				catch(Exception es) {
					es.printStackTrace();
				}
				return result_1;
			}

	}*/
	public String getsuppdesc(String item_code) throws Exception{
		return (String)fetchRecord(getStRepositoryValue("SQL_ST_GET_SUPPLIER"),new String[]{item_code,getLanguageId()}).get("SUPP_SHORT_NAME");
	}
	public String getOrderCount(String item_code) throws Exception{
		return (String)fetchRecord("SELECT NVL(COUNT(*),0) ORD_CAT_COUNT FROM OR_ORDER_CATALOG WHERE ORDER_CATALOG_CODE = ?",item_code).get("ORD_CAT_COUNT");
	}
//Copied From DrugMasterBean.java that is the reason the Connections are opened.(Mahesh)
	public boolean getDrugStatusInOR(String drug_code){

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		String	 drug_name		= "";

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( getStRepositoryValue("SQL_OR_ST_COUNT_CHECK") ) ;
			pstmt.setString(1,drug_code.trim());
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
				drug_name		=	resultSet.getString("ORDER_CATALOG_CODE");
			}
	
		}catch(Exception e){
			drug_name=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		if(drug_name.equals(""))
				return false;
		else 
			return true;
	}

	//Added for TH-KW-CRF-0039
	public boolean getItemInstructionSiteSpecific(){

		Connection connection					= null ;
//		PreparedStatement pstmt					= null ; //COMMON-ICN-0118
//		ResultSet resultSet						= null ; //COMMON-ICN-0118        
		boolean item_instruction_site_specific	= false ;

		try{
				connection						= getConnection() ;
        		item_instruction_site_specific	= eCommon.Common.CommonBean.isSiteSpecific(connection, "ST","ST_ITEM_INSTRUCTION");	
			}catch(Exception e){
				e.printStackTrace() ;
			}
 			finally {
						try{
							closeConnection( connection );
						}catch(Exception es){
							es.printStackTrace() ;
						}
			}
			return item_instruction_site_specific;
	}
	//End for TH-KW-CRF-0039

}
