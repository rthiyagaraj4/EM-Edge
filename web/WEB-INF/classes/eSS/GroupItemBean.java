/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS;

import java.util.*;
import java.io.*;
public class GroupItemBean extends eSS.Common.SsAdapter implements Serializable { 

	private String item_code;
	private String description;
	private String consumable_yn;
	private String chargeable_yn;
	private String item_qty;
	private String item_qty1;
	private String mode;
	private String madatory_item_yn;

	public String getMadatory_Item_Yn() {
		 return madatory_item_yn;
	}

	public void setMadatory_Item_Yn(String madatory_item_yn) {
		 this.madatory_item_yn =  madatory_item_yn;
	}
	public String getItem_code() {
		 return item_code;
	}

	public void setItem_code(String item_code) {
		 this.item_code =  item_code.toUpperCase();
	}

	public String getConsumable_yn() {
		 return consumable_yn;
	}

	public void setConsumable_yn(String consumable_yn) {
		 this.consumable_yn =  consumable_yn;
	}

	public String getChargeable_yn() {
		 return chargeable_yn;
	}


	public void setChargeable_yn(String chargeable_yn) {
		 this.chargeable_yn =  chargeable_yn;
	}

	public String getDescription() {
		 return description;
	}

	public void setDescription(String description) {
		 this.description =  description;
	}

	public void setItem_qty(String item_qty) {
		 this.item_qty =  item_qty;
	}

	public String getItem_qty() {
		 return item_qty;
	}
	public void setItem_qty1(String item_qty1) {
		 this.item_qty1 =  item_qty1;
	}

	public String getItem_qty1() {
		 return item_qty1;
	}

	public void setMode(String mode) {
		 this.mode =  mode;
	}

	public String getMode() {
		 return mode;
	}

	public void clear(){
		item_code	="";          
		item_qty	="";          
		description	="";          
		mode		="";          
	}

	public boolean isDisabledGroupCode(String group_code) throws Exception{
		return fetchRecord(getSsRepositoryValue("SQL_SS_GROUP_SELECT_STATUS"),group_code).get("EFF_STATUS").toString().equals("D");
	}

	public boolean trayExists(String group_code) throws Exception{
		return !fetchRecord(getSsRepositoryValue("SQL_SS_TRAY_DTLS_COUNT"),group_code).get("TOTAL").toString().equals("0");
	}

	public boolean isValidItemCode(String item_code) throws Exception{
		return !fetchRecord(getSsRepositoryValue("SQL_SS_ITEM_COUNT_VALID"),item_code).get("TOTAL").toString().equals("0");
	}

	public String getItemDescription(String item_code) throws Exception{
		return fetchRecord(getSsRepositoryValue("SQL_MM_ITEM_SELECT_DESCRIPTION"),item_code).get("SHORT_DESC").toString();
	}

	public HashMap toHashMap(){
		HashMap hmReturn	 =	new HashMap();
		hmReturn.put("item_code",getItem_code());
		hmReturn.put("item_qty",getItem_qty());
		hmReturn.put("description",getDescription());
		hmReturn.put("mode",getMode());
		return hmReturn;
	}

	public boolean isItemInArrayList(ArrayList alGroupList, String stItem_code, int exceptionalIndex){
		boolean result=false;
		for (int i=0;i<alGroupList.size();i++) {
			if (exceptionalIndex == i) continue;
			if ( ((HashMap)alGroupList.get(i)).get("ITEM_CODE").toString().equals(stItem_code) ) {
				result=true;
				break;
			}
		}
		return result;
	}
	public void initialize(HashMap hmGroupItem){
		setItem_code	(hmGroupItem.get("ITEM_CODE").toString()	);
		setItem_qty		(hmGroupItem.get("ITEM_QTY").toString()		);
		setDescription	(hmGroupItem.get("DESCRIPTION").toString()	);
		setConsumable_yn(hmGroupItem.get("CONSUMABLE_YN").toString()	);
		setChargeable_yn(hmGroupItem.get("CHARGEABLE_YN").toString()	);
		setMode			(hmGroupItem.get("MODE").toString()			);
		if(hmGroupItem.containsKey("MADATORY_ITEM_YN"))
		setMadatory_Item_Yn(hmGroupItem.get("MADATORY_ITEM_YN").toString()			);
	   if(hmGroupItem.containsKey("ITEM_QTY1"))
           setItem_qty1(hmGroupItem.get("ITEM_QTY1").toString()			);
	}
}
