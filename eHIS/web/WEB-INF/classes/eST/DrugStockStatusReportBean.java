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
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DrugStockStatusReportBean extends StTransaction implements Serializable{


	
	private String item_code;
	private String store_code;
	private String searchFunction="N";

	public void setItem_code(String item_code) {
		 this.item_code = item_code;
	}

	public String getItem_code( ) {
		 return item_code;
	}

	public void setStore_code(String store_code) {
		 this.store_code = store_code;
	}

	public String getStore_code( ) {
		 return store_code;
	}
	public String getStockStatus()
	{
		return getStaticListOptionTag("A,All;S,Stock on Hand ;Z,Zero Stock;B,Below Reorder Level;");
	}

	public String getStockItem()
	{
		return getStaticListOptionTag(" ,Both;Y,Yes;N,No;");
	}


	public ArrayList loadData(String item_code, String store_code, String stock_level) throws Exception{
		ArrayList listRecord =new ArrayList();
		String store_cod=store_code;
		String item_cod=item_code;
		if(!(store_code.equals("") || store_code==null))
		store_cod=store_code+"%";
		if(!(item_code.equals("") || item_code==null))
		item_cod=item_code+"%";
		String params[]={store_cod,item_cod};
		try {
			String stSQL=getStRepositoryValue("SQL_ST_STOCK_STATUS_BY_STORE");
			listRecord = fetchRecords(stSQL.toString(),params);

			return listRecord;
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
	}

	public String getSearchFunction( ) {
		 return searchFunction;
	}

	public void clear()
	{
	this.item_code="";
	this.store_code="";
	}
    public String getItemAnal_code_List(){
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_ITEM_ANAL_CODE_SELECT_SINGLE"),getLanguageId()));
	}

}
