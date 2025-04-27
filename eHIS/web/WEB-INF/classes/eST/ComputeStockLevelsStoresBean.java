/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

//import eCommon.Common.CommonAdapter;
import eST.Common.StAdapter;
//import eST.Common.StRepository;
import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class ComputeStockLevelsStoresBean extends StAdapter  implements Serializable{

/*private String language_id;

public void setLanguageId(String language_id) {
		 this.language_id= language_id;
	}

	public String getLanguageId( ) {
		 return language_id;
	}*/

	public HashMap modify() {
		HashMap		hmTableData	=	new HashMap()	;
		HashMap		hmSQLMap	=	new HashMap()	;
	//	ArrayList	alModifyData=	new ArrayList()	;

		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());

		Iterator iterator =hsItemSelected.iterator();

		String stItem_code;
		ArrayList alUpdateData=new ArrayList();
		HashMap hmItemDetailforUpdate	=	new HashMap();

		for (;iterator.hasNext();) {
			stItem_code=(String)iterator.next();
			hmItemDetailforUpdate	=	(HashMap)hmItemDetails.get(stItem_code);
			ArrayList alUpdateRecord = new ArrayList();
			alUpdateRecord.add(hmItemDetailforUpdate.get("reorder_level"));
			alUpdateRecord.add(hmItemDetailforUpdate.get("reorder_qty"));
			alUpdateRecord.add(hmItemDetailforUpdate.get("min_stk_qty"));
			alUpdateRecord.add(hmItemDetailforUpdate.get("max_stk_qty"));
			alUpdateRecord.add(lead_days);
			alUpdateRecord.add(min_stock_days);
			alUpdateRecord.add(buffer_perc);
			alUpdateRecord.add(login_by_id);
			alUpdateRecord.add(login_at_ws_no);
			alUpdateRecord.add(login_facility_id);
			alUpdateRecord.add(store_code);
			alUpdateRecord.add(stItem_code);
			alUpdateData.add(alUpdateRecord);
		}



		hmTableData.put	( "properties",getProperties());
		hmTableData.put	( "ModifyData",alUpdateData);
		hmTableData.put("LanguageData",LanguageData);
		hmSQLMap.put	( "ModifySQL", getStRepositoryValue("SQL_ST_ITEM_UPDATE_FOR_CALCULATE_STOCK_LEVELS_STORES"));
		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT_BATCH );
	}


	public void loadData(Hashtable hashtable){
		try {
			String consumption_period = checkForNull((String)hashtable.get("consumption_period"));
			String fm_item_class_code = checkForNull((String)hashtable.get("fm_item_class_code"),"!");
			String to_item_class_code = checkForNull((String)hashtable.get("to_item_class_code"),"~");
			String fm_item_code = checkForNull((String)hashtable.get("fm_item_code"),"!");
			String to_item_code = checkForNull((String)hashtable.get("to_item_code"),"~");
			String store_code = checkForNull((String)hashtable.get("store_code"));
			String p_stk_issue = checkForNull((String)hashtable.get("p_stk_issue"));

			String stParameters[]= {p_stk_issue,consumption_period,store_code,fm_item_code,to_item_code,fm_item_class_code,to_item_class_code,consumption_period,getLanguageId()};
			alItem	=	fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_FOR_CALCULATE_STOCK_LEVELS_STORES"), stParameters);
			HashMap hmRecord;
			HashMap hmNewItemDetail;

			for (int i=0; i<alItem.size(); i++) {
				hmRecord	=	(HashMap)alItem.get(i);
				
				double dAvg_cons_day	=	Double.parseDouble((String)hmRecord.get("AVG_CONS_DAY"));
				double dMinimum			=	dAvg_cons_day*Double.parseDouble(checkForNull((String)hashtable.get("min_stock_days"),(String)hmRecord.get("MIN_STOCK_DAYS")));
				double dROL				=	dMinimum + (dAvg_cons_day*Double.parseDouble(checkForNull((String)hashtable.get("lead_days"),(String)hmRecord.get("LEAD_DAYS"))));
				//Added for AMS-CRF-0116 Starts
				double dROQ;
				if(getCustomerID().equals("AMS"))
				{
					 double temp =  Double.parseDouble(checkForNull((String)hashtable.get("lead_days"),(String)hmRecord.get("LEAD_DAYS"))) *dAvg_cons_day ;
					 dROQ	 = dROL - Double.parseDouble((String)hmRecord.get("QTY_ON_HAND"))+ temp;
				}	
				else
				{
				     dROQ				=	dROL + Double.parseDouble(checkForNull((String)hashtable.get("buffer_percentage"),(String)hmRecord.get("PERCENT_MIN_STOCK")))*Double.parseDouble((String)hmRecord.get("MIN_STK_QTY"))*dMinimum/100;
			    }
				//Added for AMS-CRF-0116 Ends
				double dMaximum			=	dROQ + dMinimum;

//				double dMaximum			=	dROL + Double.parseDouble(checkForNull((String)hashtable.get("buffer_percentage"),(String)hmRecord.get("PERCENT_MIN_STOCK")))*dMinimum/100;

				hmNewItemDetail	=	new HashMap();
				hmNewItemDetail.put("min_stk_qty", ""+(long)Math.ceil(dMinimum));
				hmNewItemDetail.put("max_stk_qty", ""+(long)Math.ceil(dMaximum));
				hmNewItemDetail.put("reorder_level", ""+(long)Math.ceil(dROL));
				hmNewItemDetail.put("reorder_qty", ""+(long)Math.ceil(dROQ));
				hmNewItemDetail.put("selected", "Y");
				

				hmItemDetails.put(hmRecord.get("ITEM_CODE"),hmNewItemDetail);
				hsItemSelected.add(hmRecord.get("ITEM_CODE"));

			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void updateData(Hashtable htFormData) {
		
	try{
		String stKey;//,selectedKey;
		HashMap hmNewItemDetail;
		java.util.Enumeration hashKeys = htFormData.keys();
		while (hashKeys.hasMoreElements()) {
			stKey = (String) hashKeys.nextElement();
			if (stKey.startsWith("add_item_")) {
				String stItem_code	=	stKey.substring(9);
				hsItemSelected.add(stItem_code);

				String min_stk_qty	=((String)	htFormData.get("min_stk_qty_"+stItem_code)==null?"":(String)	htFormData.get("min_stk_qty_"+stItem_code));
				String max_stk_qty	=((String)	htFormData.get("max_stk_qty_"+stItem_code)==null?"":(String)	htFormData.get("max_stk_qty_"+stItem_code));
				String reorder_level=((String)	htFormData.get("reorder_level_"+stItem_code)==null?"":(String)	htFormData.get("reorder_level_"+stItem_code));
				String reorder_qty	=(String)	htFormData.get("reorder_qty_"+stItem_code);
				String selected	=	"Y";

				if (! ((String)htFormData.get("remove_item_"+stItem_code)).equals("") ){
					selected="N";
					hsItemSelected.remove(stItem_code);
				}

				hmNewItemDetail	=	(HashMap)hmItemDetails.get(stItem_code);
				hmNewItemDetail.put("min_stk_qty", min_stk_qty);
				hmNewItemDetail.put("max_stk_qty", max_stk_qty);
				hmNewItemDetail.put("reorder_level", reorder_level);
				hmNewItemDetail.put("reorder_qty", reorder_qty);
				hmNewItemDetail.put("selected", selected);
				
				hmItemDetails.put(stItem_code,hmNewItemDetail);
				
			}
		
		}
	}
	catch(Exception e)
		{
			//e.printStackTrace();
		}

	}
	
	public void setAll(Hashtable htFormData){
		lead_days=(String)htFormData.get("lead_days");     
		min_stock_days=(String)htFormData.get("min_stock_days");
		buffer_perc=(String)htFormData.get("buffer_percentage");   
		store_code=(String)htFormData.get("store_code");
	}

	public void clear(){
		super.clear();
		alItem=null;
		hsItemSelected=null;
		hmItemDetails=null;
		lead_days=null;     
		min_stock_days=null;
		buffer_perc=null; 
		store_code = null;
	}

	public void initialize(){
		alItem=new ArrayList();
		hsItemSelected=new HashSet();
		hmItemDetails=new HashMap();
		lead_days="";     
		min_stock_days="";
		buffer_perc="";   
		store_code = "";
	}

	public ArrayList getAllItem(){
		return alItem;
	}

	public HashSet getSelectedItem(){
		return hsItemSelected;
	}

	public HashMap getCalculatedItemDetails(){
		return hmItemDetails;
	}

	private ArrayList alItem;
	private HashSet hsItemSelected;
	private HashMap hmItemDetails;
	private	String lead_days;
	private	String min_stock_days;
	private	String buffer_perc;
	private	String store_code;
}
