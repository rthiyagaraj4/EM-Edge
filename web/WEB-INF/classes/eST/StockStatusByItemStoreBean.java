/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

import eST.Common.StTransaction;
//import eST.Common.StHeaderBean;
import java.io.Serializable;
import java.util.*;

public class StockStatusByItemStoreBean extends StTransaction implements Serializable{

	private String item_code;
	private String store_code;
	private String store_desc;//Store

	private String qty_on_hand;
	private String item_value;//Stock Value
	private String stock_item_yn;//stock item
	private String reorder_level;
	private String bin_desc;//master_bin_location


	public void setItem_code(String item_code) {
		 this.item_code = item_code;  
	}

	public String getItem_code( ) {
		 return item_code;
	}

	public String getStore_code( ) {
		 return store_code;
	}

	public String getStore_desc( ) {
		 return store_desc;
	}

	public String getQty_on_hand( ) {
		 return qty_on_hand;
	}

	public String getItem_value( ) {
			 return item_value;
	}

	public String getStock_item_yn( ) {
		 return stock_item_yn;
	}

	public String getReorder_level( ) {
		 return reorder_level;
	}

	public String getBin_desc( ) {
		 return bin_desc;
	}

	public ArrayList loadDataStoreLevel() throws Exception {	
	try	{
	ArrayList alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_STOCK_STATUS_BY_ITEM_STORE_LEVEL"), this.item_code);
	return alRecords;
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return null;
	}

	public void clear()
	{
	this.store_code="";
	this.item_code="";
	this.store_desc="";
	this.qty_on_hand="";
	this.item_value="";
	this.stock_item_yn="";
	this.reorder_level="";
	this.bin_desc="";
	}
}
