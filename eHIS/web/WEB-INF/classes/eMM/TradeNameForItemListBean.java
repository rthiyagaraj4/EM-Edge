/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMM;

import java.util.*;
import java.io.*;

/**
  * Class to hold only the values which are going to be entered/selected by the user.
  * In this function, it will hold the values of trade_id, trade_name,mode.
  * It will have setter, getter methods for these values along with the following
  * common utility functions:
  *		* toHashMap()
  *		* isTradeIdInArrayList()
  *		* initialize()
  *		* clear() 
  */

public class TradeNameForItemListBean extends eMM.Common.MmAdapter implements Serializable { 


	private String trade_id;
	private String trade_name;
	private String mode;

	/**
	* Getter and Setter methods for all the values.
	*/

	public String getTrade_id() {
		 return trade_id;
	}

	public void setTrade_id(String trade_id) {
		 this.trade_id =  trade_id.toUpperCase();
	}

	public String getTrade_name() {
		 return trade_name;
	}

	public void setTrade_name(String trade_name) {
		 this.trade_name = trade_name;
	}


	public void setMode(String mode) {
		 this.mode =  mode;
	}

	public String getMode() {
		 return mode;
	}

	/**
	* Method used to clear all the values.
	*/

	public void clear(){
		trade_id	="";
		trade_name	="";
		mode		="";          
	}

/*	public boolean isDisabledItemCode(String item_code) throws Exception{
		return false;
		//return fetchRecord(getMmRepositoryValue("SQL_SS_GROUP_SELECT_STATUS"),group_code).get("EFF_STATUS").toString().equals("D");
	}

	public boolean trayExists(String item_code) throws Exception{
		return true;
		//return !fetchRecord(getMmRepositoryValue("SQL_SS_TRAY_DTLS_COUNT"),_code).get("TOTAL").toString().equals("0");
	}

	public boolean isValidTradeID(String trade_id) throws Exception {
		return true;
		//return !fetchRecord(getMmRepositoryValue("SQL_SS_ITEM_COUNT_VALID"),item_code).get("TOTAL").toString().equals("0");
	}
*/
/*	public String getItemDescription(String item_code) throws Exception{
		return fetchRecord(getSsRepositoryValue("SQL_MM_ITEM_SELECT_DESCRIPTION"),item_code).get("SHORT_DESC").toString();
	}*/


	/**
	* Method used to return all the values together in a hashmap as a key value 
	* pair.
	*/

	public HashMap toHashMap() {
		HashMap hmReturn	 =	new HashMap();
		hmReturn.put("trade_id",getTrade_id());
		hmReturn.put("trade_name",getTrade_name());
		hmReturn.put("mode",getMode());
		return hmReturn;
	}

	/**
	* Method used to check, whether the newly enetered trade_id is already there
	* in the alTradeNameForItemList. This is an arrayList which holds all the values
	* related to this particular function.
	*/

	public boolean isTradeIdInArrayList(ArrayList alTradeNameForItemList, String amTrade_id, int exceptionalIndex) {
		boolean result=false;
		for (int i=0;i<alTradeNameForItemList.size();i++) {
			if (exceptionalIndex == i) {
				continue;
			}
			if ( ((HashMap)(alTradeNameForItemList.get(i))).get("trade_id").toString().equals(amTrade_id) ) {
				result=true;
				break;
			}
		}
		return result;
	}

	/**
	* Method used to initialize all the vlaues using the given hashmap. The values
	* will be passed as key-value pair.
	*/

	public void initialize(HashMap hmTradeNameForItem) {
		setTrade_id		(hmTradeNameForItem.get("trade_id").toString()	);
		setTrade_name	(hmTradeNameForItem.get("trade_name").toString() );
		setMode			(hmTradeNameForItem.get("mode").toString()			);
	}
}
