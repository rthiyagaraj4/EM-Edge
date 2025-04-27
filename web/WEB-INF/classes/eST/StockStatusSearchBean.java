/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

//port eCommon.Common.CommonAdapter;
import eST.Common.StTransaction;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
//port java.util.ArrayList;
//port java.util.HashMap;
//import java.util.Hashtable;


// Referenced classes of package eST.Common:
//		StAdapter, StRepository

/**
* Class to hold the exp detail records. All the records has been kept in the
* form of HashMaps in an arraylist. 
*/

public class StockStatusSearchBean extends StTransaction implements Serializable {
	private ArrayList DataList=new ArrayList();
	private ArrayList selectedList;

	private String item_code_from="";
	private String item_code_to="";
	private String store_code_from="";
	private String store_code_to="";
	private String manufacturer_code="";
	private String period_of_expiry="";
	private String includeZeroStockBatches="N";
	private String includeExpiredBatches="N";
	private String includeSuspendedBatches="N";
	private String searchFunction="N";
	private String multipleSelect="N";
	private String maxAllowed="1";
	//private String language_id;
//	private boolean search=true;
	private boolean bSortDesc =false;

	public String getManufacturerList() {
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_AM_MANUFACTURER_LIST")));
	}

	public void toggleSort(){
		bSortDesc =!bSortDesc ;
	}


	public boolean getSortDesc(){
		return bSortDesc ;
	}

	public void setIncludeZeroStockBatches(String includeZeroStockBatches) {
		 this.includeZeroStockBatches = checkForNull(includeZeroStockBatches,"N");
	}

	public String getIncludeZeroStockBatches( ) {
		 return includeZeroStockBatches;
	}

	public void setMaxAllowed(String maxAllowed) {
		 this.maxAllowed = checkForNull(maxAllowed,"1");
	}

	public String getMaxAllowed( ) {
		 return maxAllowed;
	}
/*	public void setLanguageId (String language_id)
	{
		this.language_id = language_id;
	}
	public String getLanguageId() 
	{
		return this.language_id;
	}*/
	public void setSearchFunction(String searchFunction) {
		 this.searchFunction = checkForNull(searchFunction,"N");
	}

	public String getSearchFunction( ) {
		 return searchFunction;
	}

	public void setMultipleSelect(String multipleSelect) {
		 this.multipleSelect = checkForNull(multipleSelect,"N");
	}

	public String getMultipleSelect( ) {
		 return multipleSelect;
	}

	public void setIncludeExpiredBatches(String includeExpiredBatches) {
		 this.includeExpiredBatches= checkForNull(includeExpiredBatches,"N");
	}

	public String getIncludeExpiredBatches( ) {
		 return includeExpiredBatches;
	}

	public void setIncludeSuspendedBatches(String includeSuspendedBatches) {
		 this.includeSuspendedBatches= checkForNull(includeSuspendedBatches,"N");
	}

	public String getIncludeSuspendedBatches( ) {
		 return includeSuspendedBatches;
	}

	public void setItem_code_from(String item_code_from) {
		 this.item_code_from = checkForNull(item_code_from);
	}

	public String getItem_code_from( ) {
		 return item_code_from;
	}

	public void setItem_code_to(String item_code_to) {
		 this.item_code_to = checkForNull(item_code_to);
	}

	public String getItem_code_to( ) {
		 return item_code_to;
	}

	public void setStore_code_from(String store_code_from) {
		 this.store_code_from = checkForNull(store_code_from);
	}

	public String getStore_code_from( ) {
		 return store_code_from;
	}

	public void setStore_code_to(String store_code_to) {
		 this.store_code_to = checkForNull(store_code_to);
	}

	public void setManufacturer_code(String manufacturer_code) {
		 this.manufacturer_code = checkForNull(manufacturer_code);
	}

	public String getManufacturer_code( ) {
		 return manufacturer_code;
	}

	public void setPeriod_of_expiry(String period_of_expiry) {
		this.period_of_expiry = checkForNull(period_of_expiry);
	}

	public void loadResultPage() throws Exception {
	
		ArrayList alParameters=new ArrayList();
//SELECT item_code,item_desc, store_code, store_desc, trade_id_applicable_yn, batch_id, to_char(expiry_date,'dd/mm/yyyy') expiry_date, bin_location_code, bin_desc, trade_id, trade_name, qty_on_hand, nod, manufacturer_id, manufacturer_name, avail_qty FROM st_batch_search_view where item_code between nvl('','!') and nvl('','~') and   store_code between nvl('','!') and nvl('','~') and      manufacturer_id like nvl('','%') and       ('Y'='Y' or avail_qty > 0) and       (expiry_yn = 'N' or (expiry_yn='Y' and (('Y'='Y') or expiry_date > trunc(sysdate)))  and expiry_date <= trunc(sysdate)+ nvl('',0)		and suspended_yn like nvl('',N)

		alParameters.add(item_code_from);
		alParameters.add(item_code_to);
		alParameters.add(store_code_from);
		alParameters.add(store_code_to);
		alParameters.add(manufacturer_code);
		alParameters.add(includeZeroStockBatches);
		alParameters.add(includeExpiredBatches);
		alParameters.add(period_of_expiry);
		alParameters.add(includeSuspendedBatches);
		
		ArrayList listRecord =new ArrayList();
		try {
			String stSQL=getStRepositoryValue("SQL_ST_BATCH_SEARCH_QUERY");
			listRecord = fetchRecords(stSQL.toString(),alParameters);
			DataList=listRecord;
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
	}
	public ArrayList getDataList(){
		return DataList ;
	}
	public String getTotalAvailableQty(){
		long lQty	=	0;
		for (int i=0; i<DataList.size(); i++) {
			lQty	=lQty+Long.parseLong((String)((HashMap)DataList.get(i)).get("AVAIL_QTY"));
		}
		return ""+lQty;
	}
	public void selectedBatches(String index,String noOfCheckedRecords)
	{
		selectedList=new ArrayList();
		int i=0;
		if(noOfCheckedRecords.equals("1"))
		{
				selectedList.add((HashMap)DataList.get(Integer.parseInt(index)));
		}
		else
		{
			StringTokenizer st=new StringTokenizer (index,"!");
			while(st.hasMoreTokens())
			{
				i=Integer.parseInt(st.nextToken());
				selectedList.add((HashMap)DataList.get(i));
			}
		}
	}
		public ArrayList getSelectedList(){
		return selectedList ;
	}

}
