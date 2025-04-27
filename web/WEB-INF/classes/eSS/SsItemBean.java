/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Properties;
import eSS.Common.SsAdapter;
import eCommon.SingleTableHandler.*;

public class SsItemBean extends SsAdapter implements Serializable { 

	private String item_code			=	"";
	private String short_desc			=	"";
	private String consumable_yn       	=	"";
	private String item_image_file_name	=	"";
	private String chargeable_yn       	=	"";
	private String acc_entity_id       	=	"";


	public void setItem_code(String item_code) {
		 this.item_code = item_code.toUpperCase();
	}

	public String getItem_code( ) {
		 return item_code;
	}

	public void setAcc_entity_id(String acc_entity_id) {
		 this.acc_entity_id = acc_entity_id;
	}

	public String getAcc_entity_id( ) {
		 return acc_entity_id;
	}

	public void setShort_desc(String short_desc) {
		 this.short_desc = short_desc.trim();
	}

	public String getShort_desc( ) {
		 return short_desc;
	}

	public void setConsumable_yn(String consumable_yn) {
		 this.consumable_yn = checkForNull(consumable_yn,"N");
	}

	public String getConsumable_yn( ) {
		 return consumable_yn;
	}

	public void setItem_image_file_name(String item_image_file_name) {
		 this.item_image_file_name = checkForNull(item_image_file_name);
	}

	public String getItem_image_file_name( ) {
		 return item_image_file_name;
	}

	public void setChargeable_yn(String chargeable_yn) {
		 this.chargeable_yn = checkForNull(chargeable_yn,"N");
	}

	public String getChargeable_yn( ) {
		 return chargeable_yn;
	}

	public String getItem_image_path(){
		try { 
			return getSsAccEntityParam(getAcc_entity_id()).get("ITEM_IMAGE_PATH").toString();
		}
		catch (Exception exception) {
		}
		return "";	
	}

	public HashMap validate() {
		HashMap hmReturn = new HashMap();
		HashMap hmResult = new HashMap();

		hmReturn.put("result",TRUE);

		try { 
			hmResult	=	fetchRecord(getSsRepositoryValue("SQL_MM_ITEM_COUNT"),getItem_code());
			if(((String)hmResult.get("TOTAL")).equals("0")){
				hmReturn.put("msgid","DISABLED_MM_ITEM_CODE");
				throw new Exception("DISABLED_MM_ITEM_CODE");//INVALID_SS_ITEM_CODE
			}
		}
		catch (Exception exception) {
			hmReturn.put("result",FALSE);
			hmReturn.put("message","Exception while validating: Message:"+exception.toString());
			exception.printStackTrace();
		}
		return hmReturn;
	}


	public HashMap insert() {

		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alWhereData	=	new ArrayList()	;

		alInsertData.add(getItem_code());
		alInsertData.add(getConsumable_yn());
		alInsertData.add(getItem_image_file_name());
		alInsertData.add(getChargeable_yn());
						  
		alInsertData.add(getLoginById());      
		alInsertData.add(getLoginAtWsNo());    
		alInsertData.add(getLoginFacilityId());
		alInsertData.add(getLoginById());      
		alInsertData.add(getLoginAtWsNo());    
		alInsertData.add(getLoginFacilityId());

		hmSQLMap.put( "InsertSQL", getSsRepositoryValue("SQL_SS_ITEM_INSERT")	);
		hmSQLMap.put( "SelectSQL", getSsRepositoryValue("SQL_SS_ITEM_COUNT")		);

		alWhereData.add(	getItem_code()	);

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "WhereData",			alWhereData		);
		hmTableData.put( "InsertData",			alInsertData	);

		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT);

	}

	public HashMap modify() {

		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;

		alModifyData.add(getConsumable_yn());
		alModifyData.add(getItem_image_file_name());
		alModifyData.add(getChargeable_yn());

		alModifyData.add(getLoginById());      
		alModifyData.add(getLoginAtWsNo());    
		alModifyData.add(getLoginFacilityId());

		alModifyData.add(getItem_code());

		hmSQLMap.put( "ModifySQL", getSsRepositoryValue("SQL_SS_ITEM_UPDATE"));

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "ModifyData",			alModifyData	);

		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE );
	}

	public void clear() {
		super.clear();
		item_code				=	""; 
		short_desc				=	""; 
		consumable_yn       	=	"N";
		item_image_file_name	=	"";	
		chargeable_yn       	=	"N";	
	}

	public void setAll(Hashtable htRecordSet){
		super.setAll(htRecordSet);
		setItem_code			((String) htRecordSet.get("item_code"));
		setConsumable_yn       	((String) htRecordSet.get("consumable_yn"));
		setItem_image_file_name	((String) htRecordSet.get("item_image_file_name"));
		setChargeable_yn     	((String) htRecordSet.get("chargeable_yn"));
	}

	/* Over-ridden Adapter methods end here */

	/* Function specific methods start */
	public void loadData() throws Exception {
		HashMap hmRecord	=	null;
		hmRecord	=	fetchRecord(getSsRepositoryValue("SQL_SS_ITEM_SELECT_SINGLE"), getItem_code());
		setItem_code			 ( (String)hmRecord.get("ITEM_CODE" )			) ;    
		setShort_desc			 ( (String)hmRecord.get("SHORT_DESC"));
		setConsumable_yn       	 ( (String)hmRecord.get("CONSUMABLE_YN" )		) ;
		setItem_image_file_name	 ( (String)hmRecord.get("ITEM_IMAGE_FILE_NAME")	) ;
		setChargeable_yn     	 ( (String)hmRecord.get("CHARGEABLE_YN" )		) ;
	}

	public String getItemDescription(String item_code) throws Exception{
		HashMap hmRecord	=	fetchRecord(getSsRepositoryValue("SQL_MM_ITEM_SELECT_DESCRIPTION"),item_code);
		return hmRecord.get("SHORT_DESC").toString();
	}
    /* added by pankaj */

    public String getItemEffStatus(String item_code) throws Exception{
		HashMap hmRecord	=	fetchRecord(getSsRepositoryValue("SQL_MM_ITEM_EFF_STATUS_SELECT"),item_code);
		
		return hmRecord.get("EFF_STATUS").toString();
	}

	public String toString(){
		return "|item_code:"+item_code + "||consumable_yn:"+consumable_yn+"||item_image_file_name:"+item_image_file_name+"||chargeable_yn:"+chargeable_yn +"|";
	}
} 
