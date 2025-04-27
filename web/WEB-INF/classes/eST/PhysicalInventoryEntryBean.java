/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
20/02/2017		IN0063027			Badmavathi B							GHL-CRF-0413.7 - US005 - Barcode search
---------------------------------------------------------------------------------------------------------
*/
 package eST;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
//import javax.servlet.http.HttpServletRequest;
import eST.PhysicalInventoryEntry.*;
import eST.Common.StTransaction;

import java.io.*;
import java.util.*;
import java.util.Date;

public class PhysicalInventoryEntryBean extends StTransaction implements Serializable{

	private HashMap add_values;
	private int flag = 0;
	private String phy_inv_id;
	private String file_name;
	private String client_file_name;
	
	// pmd 19/02/05
//	private String count_sheet_date;
	private String store_code;
	private String item_code;
	private String entry_completed_yn;
	//private String language_id;
	private String bin_code_desc;
	private int flag_to_delete=0;
	private ArrayList alDtlRecords = new ArrayList();
	private ArrayList alModRecords = new ArrayList();
	private ArrayList arDummy	   = new ArrayList();
	private ArrayList DataList	   = new ArrayList();
	ArrayList alModifyHDR = new ArrayList(); // Added by Padmapriya for INC # 29976 on 31/08/2012
	private boolean site=false;   									//Added for TH-KW-CRF-0083
	private ArrayList FileDataList	   = new ArrayList();  //Added for TH-KW-CRF-0083
	private int remarks_count	   = 0;  //Added for TH-KW-CRF-0083
	
	
	private String order =""  ;
	private String obj ="" ;
	private String to_store_code ="" ;
	private String from_store_code ="" ;

	private String batch_id="";
	private String Trade_code="";
	private String cut_off_date_for_grn="";
	private String searchby="";
	private String period_of_expiry="";
	private String includeExpiredBatches="N";
	//Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 beg
	private String conv_fact;
	private String allow_eqvl_uom;
	//Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 end
	//Added for GHL-CRF-0413.7 US005 starts
	private String barcode;
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	//Added for GHL-CRF-0413.7 US005 ends
	HashMap batch_lookup;
	 public HashMap getBatch_lookup()
	{
	return this.batch_lookup;
	}
    public void setBatch_lookup(HashMap batch_lookup)
	{
	  this.batch_lookup=batch_lookup;
	}
	 public String getFromstoreCode()
	{
	return this.from_store_code;
	}
    public void setFromstoreCode(String from_store_code)
	{
	  this.from_store_code=from_store_code;
	}
	
	public String getTostoreCode()
	{
	return this.to_store_code;
	}
    public void setTostoreCode(String to_store_code)
	{
	  this.to_store_code=to_store_code;
	}
	public String getOrder()
	{
		return this.order;
	}
	public void setOrder(String exp_order)
	{
		this.order=exp_order;
	}
	public String getObj()
	{
		return this.obj;
	}
	public void setObj(String obj)
	{
		this.obj=obj;
	}
	//Added against Inc#35134 by Sakti Sankar
	public String getBatch_id( ) {
		 return batch_id;
	}
	public void setBatch_id(String batch_id) {
		 this.batch_id = checkForNull(batch_id,"");
	}

	public String getTrade_Code( ) {
		 return Trade_code;
	}
	public void setTrade_Code(String Trade_code) {
		 this.Trade_code = checkForNull(Trade_code,"");
	}
	//Added ends
//Added By Sakti against CRF# - RUT-CRF-0081 icn#34757
	public String getCut_off_date_for_grn( ) {
		 return cut_off_date_for_grn;
	}
	public void setCut_off_date_for_grn(String cut_off_date_for_grn) {
		 this.cut_off_date_for_grn = checkForNull(cut_off_date_for_grn);
	}

	public String getSearchby( ) {
		 return searchby;
	}
	public void setSearchby(String searchby) {
		 this.searchby = checkForNull(searchby);
	}

	public String getPeriod_Of_Expiry( ) {
		 return period_of_expiry;
	}
	public void setPeriod_Of_Expiry(String period_of_expiry) {
		 this.period_of_expiry = checkForNull(period_of_expiry);
	}

	public void setIncludeExpiredBatches(String includeExpiredBatches) {
		 this.includeExpiredBatches= checkForNull(includeExpiredBatches,"N");
	}

	public String getIncludeExpiredBatches( ) {
		 return includeExpiredBatches;
	}
//Added ends
	//Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 beg
	public String getConv_fact() {
		return conv_fact;
	}
	public void setConv_fact(String conv_fact) {
		this.conv_fact = conv_fact;
	}
	public String getAllow_eqvl_uom() {
		return allow_eqvl_uom;
	}
	public void setAllow_eqvl_uom(String allow_eqvl_uom) {
		this.allow_eqvl_uom = allow_eqvl_uom;
	}
	//Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 end
	public String getFile_name() {
		return file_name;
	}
	public String getClient_file_name() {
		return client_file_name;
	}
	public void clear_values()
	{
		if (flag == 0)
		{
			add_values = new HashMap();
			loadData_toHash();
			flag = 1;
		}
	}
    public HashMap display_batch_lookup()
	{
	try
		{

	HashMap grn_batch_display= fetchRecord("SELECT NVL (PHY_INV_BATCH_LOOKUP_ENTRY_YN, 'N') PHY_INV_BATCH_LOOKUP_ENTRY_YN, NVL(APPL_BATCHES_IN_PHY_INV_ENTRY,'ALL') APPL_BATCHES_IN_PHY_INV_ENTRY FROM ST_FACILITY_PARAM WHERE FACILITY_ID = ? AND MATERIAL_GROUP_CODE = ?",new String[]{getLoginFacilityId(),"ALL"});
		
	 return grn_batch_display;
		
		}catch(Exception e)
		{
				
		e.printStackTrace();
		
		}
	 return new HashMap(); 
	}
	public void clear_data_added()
	{
		add_values = new HashMap();
		flag = 0;
		flag_to_delete=0;
	}
	public void setModRecords(int index,ArrayList alModRecords){
		/*if(index==-1)
			this.alModRecords.add(alModRecords);
		else*/
			this.alModRecords.set(index,alModRecords);
	}
	public ArrayList getModResult(int index){
		try{
			return (ArrayList)(this.alModRecords).get(index);
		}catch(Exception e){
			return arDummy;
		}
	}
	
	// Added by Padmapriya for INC # 29976 on 31/08/2012
	
	public void updateModRecords(String item_code, ArrayList alModRecords){
	
		System.out.println("alModRecords in updateModRecords = "+alModRecords);
		System.out.println("item_code in updateModRecords = "+item_code);
		ArrayList alDBValues = new ArrayList();
				
		try{
			ArrayList alParameters = new ArrayList();
			alParameters.add(getLoginFacilityId());			
			alParameters.add(this.phy_inv_id);
			alParameters.add(this.store_code);
			alParameters.add(item_code);
		
			String sql = getStRepositoryValue("SQL_ST_ITEM_BATCH_FOR_PHY_INV_HDR_UPDATE");

			alDBValues	= fetchRecords(sql, alParameters);
			
		
		

		System.out.println("alDBValues in bean  = "+alDBValues);
		
			for(int i=0;i<alModRecords.size();i++){
				HashMap hmModRecord = (HashMap)alModRecords.get(i);
				ArrayList alModifyHDRData;

					if(alDBValues.size() != 0){

					HashMap hmDBRecord = (HashMap)alDBValues.get(i);
					String modValue = checkForNull((String)hmModRecord.get("ITEM_QTY"),"0");
					String dbValue = checkForNull((String)hmDBRecord.get("ITEM_QTY"),"0");

						if(Double.parseDouble(modValue) != Double.parseDouble(dbValue)) {
							alModifyHDRData = new ArrayList();

							alModifyHDRData.add(getLoginById());
							alModifyHDRData.add(getLoginAtWsNo());
							alModifyHDRData.add(getLoginFacilityId());
							alModifyHDRData.add(getLoginFacilityId());
							alModifyHDRData.add(this.phy_inv_id);
							alModifyHDRData.add(this.store_code);
							alModifyHDRData.add(item_code);
							alModifyHDR.add(alModifyHDRData);
							break;	
						}
					}else{
							alModifyHDRData = new ArrayList();

							alModifyHDRData.add(getLoginById());
							alModifyHDRData.add(getLoginAtWsNo());
							alModifyHDRData.add(getLoginFacilityId());
							alModifyHDRData.add(getLoginFacilityId());
							alModifyHDRData.add(this.phy_inv_id);
							alModifyHDRData.add(this.store_code);
							alModifyHDRData.add(item_code);
							alModifyHDR.add(alModifyHDRData);
							break;						
					}
			}
		
		}
		catch(Exception ex){
			ex.printStackTrace(); 
		}
		System.out.println("alModifyHDR in updateModRecords = "+alModifyHDR);
				
	
	}
	
	// End by Padmapriya for INC # 29976 on 31/08/2012
	
	public HashMap getData_map()
	{
		return this.add_values;
	}
	public ArrayList getDataList(){
		
		return DataList ;
	}
 public void setDataList(ArrayList DataList){
		
		this.DataList = DataList ;
	}
	public ArrayList getDtlRecords(){
		return this.alDtlRecords;
	}
	public void setAll(Hashtable hashtable)
    {
	    this.phy_inv_id = (String)hashtable.get("phy_inv_id");
	    this.store_code = (String)hashtable.get("store_code");
	    this.item_code = (String)hashtable.get("item_code");
	    this.entry_completed_yn = checkForNull((String)hashtable.get("entry_completed_yn"),"N");
	    System.out.println("hashtable"+hashtable);
	    
	}

	public HashMap insert()
    {
		if(isSite())
		{
			return   insertByFile();
		}
			
        HashMap hashmap = new HashMap();
        ArrayList arraylist = new ArrayList();
		ArrayList alModifyData = new ArrayList();
        HashMap hashmap1 = new HashMap();
				
		hashmap.put("properties", getProperties());

        hashmap.put("DeleteData", getDelList());
		hashmap1.put("DeleteDtlSQL", getStRepositoryValue("SQL_ST_PHYSICAL_INVENTORY_ENTRY_DELETE_PHY_INV_DTL"));
		
		alModifyData.add(this.entry_completed_yn);
		alModifyData.add(getLoginById());    // Added by Padmapriya 
		alModifyData.add(getLoginAtWsNo());  // Added by Padmapriya 
		alModifyData.add(getLoginFacilityId());  // Added by Padmapriya 
		alModifyData.add(getLoginFacilityId());
		alModifyData.add(this.phy_inv_id);
		alModifyData.add(this.store_code);
		hashmap.put("ModifyData", alModifyData);
		//hashmap1.put("ModifyDtlSQL", "UPDATE ST_PHY_INV_PARAM SET ENTRY_COMPLETED_YN = ? WHERE FACILITY_ID = ? AND PHY_INV_ID = ? AND FM_STORE_CODE = ?");  
		hashmap1.put("ModifyDtlSQL", "UPDATE ST_PHY_INV_PARAM SET ENTRY_COMPLETED_YN = ?, MODIFIED_BY_ID = ? , MODIFIED_DATE = SYSDATE , MODIFIED_AT_WS_NO = ? , MODIFIED_FACILITY_ID = ? WHERE FACILITY_ID = ? AND PHY_INV_ID = ? AND FM_STORE_CODE = ? ");  // Added by Padmapriya 
		
			arraylist = getArrayList();
		//hashmap.put("properties", getProperties());
        hashmap.put("InsertData", arraylist);
        if(getAllow_eqvl_uom().equals("Y")){
        	hashmap1.put("InsertDtlSQL", getStRepositoryValue("SQL_ST_PHYSICAL_INV_INSERT_DTL_ALLOW_EQL_UOM"));
        }else{
        	hashmap1.put("InsertDtlSQL", getStRepositoryValue("SQL_ST_PHYSICAL_INVENTORY_ENTRY_COUNT_SHEET_INSERT_DTL"));
        }
		
		// Added by Padmapriya for INC # 29976 on 31/08/2012
		
			hashmap.put("ModifyHDRData", alModifyHDR);
			hashmap1.put("ModifyHDRSQL", getStRepositoryValue("SQL_ST_PHYSICAL_INVENTORY_HDR_UPDATE"));
			
						
		// End by Padmapriya for INC # 29976 on 31/08/2012
		
		
		return dipatchingMethodCall(hashmap, hashmap1);
    }
	
/*	public ArrayList getArrayList()  
		{
		ArrayList alRecordsList = new ArrayList();
		ArrayList alRecords_List = new ArrayList();
		ArrayList allRecords_arr = new ArrayList();
		try{
			for(int j=0;j<alModRecords.size();j++){
				allRecords_arr	=	new ArrayList();
				allRecords_arr	=	(ArrayList)alModRecords.get(j);
				for(int i=0;i<allRecords_arr.size();i++){
						HashMap one_rec = (HashMap)allRecords_arr.get(i);
							ArrayList alParameters_CodeList = new ArrayList();
							alParameters_CodeList.add(getLoginFacilityId());
							alParameters_CodeList.add(this.phy_inv_id);
							alParameters_CodeList.add(this.store_code);
							alParameters_CodeList.add(one_rec.get("ITEM_CODE"));
							alParameters_CodeList.add(one_rec.get("BATCH_ID"));
							alParameters_CodeList.add(one_rec.get("ITEM_QTY"));
							alParameters_CodeList.add(one_rec.get("EXPIRY_DATE"));
							alParameters_CodeList.add(one_rec.get("BIN_LOC_CODE"));
							alParameters_CodeList.add(one_rec.get("TRADE_ID"));
							alParameters_CodeList.add(one_rec.get("NEW_BATCH_YN"));
							
							//setNumber(""+item_cost_value,3)
							if(one_rec.get("NEW_BATCH_YN").equals("Y")){
								double item_cost_value = Integer.parseInt((String)one_rec.get("ITEM_QTY")) * getItemvalue((String)one_rec.get("ITEM_CODE"));
								alParameters_CodeList.add(setNumber(""+item_cost_value,3));
							}
							else
								alParameters_CodeList.add("");
							alParameters_CodeList.add(getLoginById());
							alParameters_CodeList.add(getLoginAtWsNo());
							alParameters_CodeList.add(getLoginFacilityId());
							alParameters_CodeList.add(getLoginById());
							alParameters_CodeList.add(getLoginAtWsNo());
							alParameters_CodeList.add(getLoginFacilityId());
							alRecords_List.add(alParameters_CodeList);
					}
			}
		}catch(Exception exception){
		   exception.printStackTrace();
		}
       return alRecords_List;
    }*/
	public ArrayList getArrayList()  
		{
		
		ArrayList alRecords_List = new ArrayList();
		ArrayList allRecords_arr = new ArrayList();
		try{
			/**
			 * @Name - Priya
			 * @Date - 07/06/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost and round up item_cost_value with noOfDecimalsForCost 
			 */
				int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost());
			for(int j=0;j<alModRecords.size();j++){
				allRecords_arr	=	new ArrayList();
				allRecords_arr	=	(ArrayList)alModRecords.get(j);
				for(int i=0;i<allRecords_arr.size();i++){
						HashMap one_rec = (HashMap)allRecords_arr.get(i);
						if(checkForNull((String)one_rec.get("ITEM_QTY")).equals("")){
							one_rec.put("ITEM_QTY","0");
							//	continue;
							}
						
							ArrayList alParameters_CodeList = new ArrayList();
							alParameters_CodeList.add(getLoginFacilityId());
							alParameters_CodeList.add(this.phy_inv_id);
							alParameters_CodeList.add(this.store_code);
							alParameters_CodeList.add(one_rec.get("ITEM_CODE"));
							alParameters_CodeList.add(one_rec.get("BATCH_ID"));
							if(!getAllow_eqvl_uom().equals("Y")){
							alParameters_CodeList.add(one_rec.get("ITEM_QTY")); 
							}else{
							//Modified by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 beg
								//double item_qty=Double.parseDouble((String)one_rec.get("ITEM_QTY"))*Double.parseDouble((String)one_rec.get("CONV_FACT"));
							//Modified against MMS-DM-SCF-0364 03-12-2016 by Badmavathi B
							double item_qty=Double.parseDouble((String)one_rec.get("ITEM_QTY"))*Double.parseDouble(checkForNull((String)one_rec.get("CONV_FACT"),getUOMConvfact((String)one_rec.get("ITEM_CODE"),(String)one_rec.get("PHY_UOM_CODE"))));
							alParameters_CodeList.add(""+item_qty);
							}
							alParameters_CodeList.add(one_rec.get("EXPIRY_DATE"));
							alParameters_CodeList.add(one_rec.get("BIN_LOC_CODE"));
							alParameters_CodeList.add(one_rec.get("TRADE_ID"));
							alParameters_CodeList.add(one_rec.get("NEW_BATCH_YN"));
							
							//setNumber(""+item_cost_value,3)
							if(one_rec.get("NEW_BATCH_YN").equals("Y")){
								//double item_cost_value = Double.parseDouble((String)one_rec.get("ITEM_QTY")) * getItemvalue((String)one_rec.get("ITEM_CODE"));
								//Modified by suresh.r on 29-07-2014 against MMS-SCF-0390 
								double item_cost_value = Double.parseDouble((String)one_rec.get("ITEM_QTY")) * getBaseUnitCost((String)one_rec.get("ITEM_CODE"));
								alParameters_CodeList.add(setNumber(""+item_cost_value,noOfDecimalsForCost));
							}
							else
								alParameters_CodeList.add("");
							alParameters_CodeList.add(one_rec.get("ENTRY_COMPLETED_YN"));
							alParameters_CodeList.add(getLoginById());
							alParameters_CodeList.add(getLoginAtWsNo());
							alParameters_CodeList.add(getLoginFacilityId());
							alParameters_CodeList.add(getLoginById());
							alParameters_CodeList.add(getLoginAtWsNo());
							alParameters_CodeList.add(getLoginFacilityId());
							//Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 beg
							if(getAllow_eqvl_uom().equals("Y")){
							alParameters_CodeList.add(one_rec.get("PHY_UOM_CODE"));
							alParameters_CodeList.add(one_rec.get("ITEM_QTY"));
							}
							//Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 end
							alRecords_List.add(alParameters_CodeList);
					}
			}
		}catch(Exception exception){
		   exception.printStackTrace();
		}
       return alRecords_List;
    }
	public ArrayList getDelList()  
		{
		this.item_code = "";
		ArrayList alRecords_List = new ArrayList();
		ArrayList allRecords_arr = new ArrayList();
		try{
			for(int j=0;j<alModRecords.size();j++){
				allRecords_arr	=	new ArrayList();
				allRecords_arr	=	(ArrayList)alModRecords.get(j);
				for(int i=0;i<allRecords_arr.size();i++){
						HashMap one_rec = (HashMap)allRecords_arr.get(i);
							ArrayList alParameters_CodeList = new ArrayList();
							alParameters_CodeList.add(getLoginFacilityId());
							alParameters_CodeList.add(this.phy_inv_id);
							alParameters_CodeList.add(this.store_code);
							if((this.item_code).equals((String)one_rec.get("ITEM_CODE")))
								continue;
							else
								alParameters_CodeList.add(one_rec.get("ITEM_CODE"));
							this.item_code = (String)one_rec.get("ITEM_CODE");
							alRecords_List.add(alParameters_CodeList);
					}
			}
		}catch(Exception exception){
		   exception.printStackTrace();
		}
       return alRecords_List;
    }

	public HashMap dipatchingMethodCall(HashMap hashmap, HashMap hashmap1)
    {
        HashMap hashmap2 = new HashMap();
        try
        {
         //   PhysicalInventoryEntryHome home = null;
       /*     eST.PhysicalInventoryEntry.PhysicalInventoryEntryRemote remote = null;
            InitialContext initialcontext = new InitialContext();
            Object obj = initialcontext.lookup(getStRepositoryValue("JNDI_PHYSICAL_INVENTORY_ENTRY"));
            home = (PhysicalInventoryEntryHome)PortableRemoteObject.narrow(obj, eST.PhysicalInventoryEntry.PhysicalInventoryEntryHome.class);
            remote = home.create();*/

			Object home1 = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_PHYSICAL_INVENTORY_ENTRY"),eST.PhysicalInventoryEntry.PhysicalInventoryEntryHome.class,getLocalEJB());
			Object busObj = (home1.getClass().getMethod("create",null)).invoke(home1,null);

			Object argArray[] = new Object[2];
			argArray[0] = hashmap;
			argArray[1] = hashmap1;

			Class [] paramArray = new Class[2];
			paramArray[0] = hashmap.getClass(); ;
			paramArray[1] = hashmap1.getClass();
			hashmap2 = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
        }
        catch(Exception exception) {
		exception.printStackTrace();}
        
		if(((Boolean)hashmap2.get("result")).booleanValue())
            hashmap2.put("message", getSTMessage(getLanguageId(),(String) hashmap2.get( "msgid" ),"ST") ) ;
        else
        if(hashmap2.get("msgid") != null)
            hashmap2.put("message", getSTMessage(getLanguageId(),(String) hashmap2.get( "msgid" ),"ST") ) ;
        else
            hashmap2.put("message", replaceNewLineChar((String)hashmap2.get("message")));
		alModifyHDR.clear();	// Added by Padmapriya for INC # 29976 on 31/08/2012
        return hashmap2;
    }

	public void add_To_values(String val)
	{
		StringTokenizer stringtokenizer = new StringTokenizer(val, "~");
		String batch_id = stringtokenizer.nextToken();
		String item_qty = stringtokenizer.nextToken();
		String bin_loc_code = stringtokenizer.nextToken();
		String expiry_date = stringtokenizer.nextToken();
		String trade_id = stringtokenizer.nextToken();
		String new_batch_YN = stringtokenizer.nextToken();
		String key_val = batch_id+item_qty+bin_loc_code+expiry_date+trade_id+new_batch_YN;
		HashMap val_map = new HashMap();
		val_map.put("BATCH_ID",batch_id);
		val_map.put("ITEM_QTY",item_qty);
		val_map.put("BIN_LOC_CODE",bin_loc_code);
		val_map.put("EXPIRY_DATE",expiry_date);
		val_map.put("TRADE_ID",trade_id);
		val_map.put("NEW_BATCH_YN",new_batch_YN);
			
		add_values.put(key_val,val_map);
	}
	public void modify_To_values(String key,String val)
	{
		String key_val = key;
		StringTokenizer stringtokenizer = new StringTokenizer(val, "~");
		String batch_id = stringtokenizer.nextToken();
		String item_qty = stringtokenizer.nextToken();
		String bin_loc_code = stringtokenizer.nextToken();
		String expiry_date = stringtokenizer.nextToken();
		String trade_id = stringtokenizer.nextToken();
		String new_batch_YN = stringtokenizer.nextToken();
		String key_val_new = batch_id+item_qty+bin_loc_code+expiry_date+trade_id+new_batch_YN;
		HashMap val_map = new HashMap();
		val_map.put("BATCH_ID",batch_id);
		val_map.put("ITEM_QTY",item_qty);
		val_map.put("BIN_LOC_CODE",bin_loc_code);
		val_map.put("EXPIRY_DATE",expiry_date);
		val_map.put("TRADE_ID",trade_id);
		val_map.put("NEW_BATCH_YN",new_batch_YN);
		add_values.put(key_val_new,val_map);
		add_values.remove(key_val);
		//add_values.put(key_val_new,val_map);
	}
	public ArrayList loadData()	{
			try{
					ArrayList data_arr = new ArrayList();
					Collection c = add_values.values();
					Object[] o = c.toArray();
					for (int j=0; j<o.length;j++)
					{
						data_arr.add(o[j]);
					}
				return data_arr;
			}
		catch(Exception e)
		{
		e.printStackTrace(); 
		}
	return null;
	}

	public void clear()
	{
	this.phy_inv_id = "";
//	this.count_sheet_date = "";
	this.store_code = "";
	this.alModRecords	=	new ArrayList();
	this.alDtlRecords	=	new ArrayList();
	batch_lookup=new HashMap();
	}
	
	public void setItem_code(String s)
	{
	this.item_code = s;
	}

	public void setStore_code(String s)
	{
	this.store_code = s;
	}

	public void setPhy_inv_id(String s)
	{
	this.phy_inv_id = s;
	}
	
/*	public void setLanguageId(String language_id)
	{
	this.language_id = language_id;
	}
	public String getLanguageId()
	{
	return language_id;
	}
*/

	public String getStore() throws Exception {	
	try	{
		ArrayList arr_language=new ArrayList();
		arr_language.add(getLoginFacilityId());
		arr_language.add(getLanguageId());
	return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_STORE_SELECT_LIST"),arr_language));
	}
	catch(Exception e) {
	e.printStackTrace();
		}
	return null;
	}

	public String getCountsheetDate() throws Exception {	
	try	{
		ArrayList arr_count = new ArrayList();
		arr_count.add(getLoginFacilityId());
		arr_count.add(this.phy_inv_id);

	String s1 = fetchRecord(getStRepositoryValue("SQL_ST_PHYSICAL_INVENTORY_ENTRY_COUNT_SHEET_DATE"),arr_count).get("COUNT_SHEET_DATE").toString();
	return s1;
	}
	catch(Exception e) {
	e.printStackTrace();
		}
	return null;
	}

	public String getTempphyid() throws Exception {	
	try	{
	return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_PHYSICAL_INVENTORY_ENTRY_PHY_ID_HDR"),getLoginFacilityId()));
	}
	catch(Exception e) {
	e.printStackTrace();
		}
	return null;
	}

	public String getBinlocation() throws Exception {	
	try	{
		ArrayList arr_count = new ArrayList();
		arr_count.add(this.store_code);
		arr_count.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),arr_count));
	}
	catch(Exception e) {
	e.printStackTrace();
		}
	return null;
	}

	public String getTradeId() throws Exception {	
	try	{
		ArrayList arr_count = new ArrayList();
		arr_count.add(this.item_code);
		arr_count.add(getLanguageId());
		arr_count.add(this.item_code);
		//return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_PHYSICAL_INVENTORY_ENTRY_COUNT_SHEET_TRADE_ID_BY_ITEM"),arr_count));
		//Added by Rabbani #inc no:39735(RUT-SCF-0269) on 27-MAY-2013
		     String optionValues = null;
			 ArrayList alOptionValues = new ArrayList();
			alOptionValues = getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_PHYSICAL_INVENTORY_ENTRY_COUNT_SHEET_TRADE_ID_BY_ITEM"), arr_count);
			alOptionValues.remove(0);
			optionValues = getListOptionTag(alOptionValues);
			return optionValues;
			//ends
	}
	catch(Exception e) {
	e.printStackTrace();
		}
	return null;
	}
	public String getTradeIdList(String trade_id) throws Exception {	
	try	{
		ArrayList arr_count = new ArrayList();
		arr_count.add(this.item_code);
		arr_count.add(getLanguageId());
		arr_count.add(this.item_code);
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_PHYSICAL_INVENTORY_ENTRY_COUNT_SHEET_TRADE_ID_BY_ITEM"),arr_count),trade_id);
	}
	catch(Exception e) {
	e.printStackTrace();
		}
	return null;
	}
	// Added  By Mahesh to get trade description on 5-10-07
	public String getTradeDesc(String trade_id) throws Exception {	
	try	{
		ArrayList arr_count = new ArrayList();
		arr_count.add(trade_id);
		arr_count.add(this.item_code);
		arr_count.add(getLanguageId());
		arr_count.add(this.item_code);
		return (String)fetchRecord(getStRepositoryValue("ST_SQL_PHY_INV_ID_TRADE_SELECT"),arr_count).get("TRADE_NAME");
	}
	catch(Exception e) {
	e.printStackTrace();
		}
	return null;
	}

	public void setBin_code_desc(String s)
	{
		this.bin_code_desc = s;
	}

	public String getBinlocation_desc() throws Exception {	
	try	{
		ArrayList arr_lang=new ArrayList();
		arr_lang.add(this.bin_code_desc);
		arr_lang.add(getLanguageId());
	String s1 = fetchRecord(getStRepositoryValue("SQL_ST_PHYSICAL_INVENTORY_ENTRY_BIN_BY_BIN_CODE"),arr_lang).get("SHORT_DESC").toString();
	return s1;
	}
	catch(Exception e) {
	e.printStackTrace();
		}
	return null;
	}

	private void loadData_toHash() {
		try{
			ArrayList alParameters = new ArrayList();
			alParameters.add(getLoginFacilityId());				
			alParameters.add(this.phy_inv_id);
			alParameters.add(this.store_code);
			alParameters.add(this.item_code);
			HashMap alRec_m = new HashMap();
			ArrayList alRecords	= fetchRecords(getStRepositoryValue("SQL_ST_PHYSICAL_INVENTORY_ENTRY_SELECT_PHY_INV_DTL"), alParameters);
			if (alRecords.size()>0)
			{
				this.flag_to_delete = 1;
				for(int i=0;i<alRecords.size();i++)
				{
					alRec_m = (HashMap)alRecords.get(i);
					String batch_id = (String)alRec_m.get("BATCH_ID");
					String item_qty = (String)alRec_m.get("ITEM_QTY");
					String bin_loc_code = (String)alRec_m.get("BIN_LOC_CODE");
					String expiry_date = (String)alRec_m.get("EXPIRY_DATE");
					String trade_id = (String)alRec_m.get("TRADE_ID");
					String new_batch_YN = (String)alRec_m.get("NEW_BATCH_YN");
					String key_val = batch_id+item_qty+bin_loc_code+expiry_date+trade_id+new_batch_YN;
					//String key_val = batch_id+item_qty+bin_loc_code+expiry_date+trade_id+new_batch_YN;
					add_values.put(key_val,(HashMap)alRecords.get(i));
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace(); 
		}	
	}
	public Double getItemvalue(String item_code){
		ArrayList alParameters = new ArrayList();
		alParameters.add(item_code);
		alParameters.add(getLanguageId());
		try{
			String s1 = fetchRecord(getStRepositoryValue("SQL_ST_PHY_INV_UNIT_COST"),alParameters).get("UNIT_COST").toString();
		return Double.parseDouble(s1);
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0.0;
	}
	public void loadDetailPage(String phy_inv_id,String store_code,String item_code){
		ArrayList alParameters	=	new ArrayList();
		HashMap		hmTemp		=	new HashMap();
		String sql ="";
			//getStRepositoryValue("SQL_ST_PHYSICAL_INVENTORY_ENTRY_PHY_ID_SELECT_HDR");
		alDtlRecords	=	new ArrayList();
		alParameters.add(phy_inv_id);
		alParameters.add(store_code);
		alParameters.add(item_code);
		alParameters.add(getLoginFacilityId());
		alParameters.add(getLanguageId());
        
			if(batch_lookup.size()==0){
			     batch_lookup = display_batch_lookup();
				}
		 // batch_lookup = display_batch_lookup();
		 String display_batch_lookup = checkForNull((String)batch_lookup.get("PHY_INV_BATCH_LOOKUP_ENTRY_YN"),"N");
		 String display_batch_lookup_all = checkForNull((String)batch_lookup.get("APPL_BATCHES_IN_PHY_INV_ENTRY"),"ALL");
            //sql = " SELECT DISTINCT A.PHY_INV_ID PHY_INV_ID, B.SHORT_DESC STORE_DESC,C.SHORT_DESC ITEM_DESC, A.STORE_CODE STORE_CODE, A.ITEM_CODE ITEM_CODE, NVL (D.ENTRY_COMPLETED_YN, 'NU') STA_CHK,COUNT(E.ITEM_CODE) COUNT  FROM ST_PHY_INV_HDR A, MM_STORE_LANG_VW B,  MM_ITEM_LANG_VW C, ST_PHY_INV_DTL D,  ST_ITEM_BATCH E  WHERE A.PHY_INV_ID = NVL (?, A.PHY_INV_ID)  AND A.STORE_CODE = NVL (?, A.STORE_CODE)  AND A.ITEM_CODE = NVL (?, A.ITEM_CODE)  AND A.FACILITY_ID = ?  AND A.PHY_INV_ID = D.PHY_INV_ID(+)  AND A.STORE_CODE = D.STORE_CODE(+)  AND A.ITEM_CODE = D.ITEM_CODE(+)  AND A.ITEM_CODE = E.ITEM_CODE(+)  AND A.STORE_CODE = E.STORE_CODE(+)  AND A.ITEM_CODE = C.ITEM_CODE  AND A.STORE_CODE = B.STORE_CODE  AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = ?  GROUP BY A.PHY_INV_ID, B.SHORT_DESC,  C.SHORT_DESC, A.STORE_CODE,A.ITEM_CODE, NVL (D.ENTRY_COMPLETED_YN, 'NU')  ORDER BY 3 ";
		 	//Modified by suresh.r on 29-07-2014 against MMS-SCF-0390
			//sql = " SELECT DISTINCT A.PHY_INV_ID PHY_INV_ID, B.SHORT_DESC STORE_DESC,C.SHORT_DESC ITEM_DESC, A.STORE_CODE STORE_CODE, A.ITEM_CODE ITEM_CODE, NVL (D.ENTRY_COMPLETED_YN, 'NU') STA_CHK,COUNT(E.ITEM_CODE) COUNT, AM.SHORT_DESC GEN_UOM_DESC  FROM ST_PHY_INV_HDR A, MM_STORE_LANG_VW B,  MM_ITEM_LANG_VW C, ST_PHY_INV_DTL D,  ST_ITEM_BATCH E, AM_UOM_LANG_VW AM  WHERE A.PHY_INV_ID = NVL (?, A.PHY_INV_ID)  AND A.STORE_CODE = NVL (?, A.STORE_CODE)  AND A.ITEM_CODE = NVL (?, A.ITEM_CODE)  AND A.FACILITY_ID = ?  AND A.PHY_INV_ID = D.PHY_INV_ID(+)  AND A.STORE_CODE = D.STORE_CODE(+)  AND A.ITEM_CODE = D.ITEM_CODE(+)  AND A.ITEM_CODE = E.ITEM_CODE(+)  AND A.STORE_CODE = E.STORE_CODE(+)  AND A.ITEM_CODE = C.ITEM_CODE  AND A.STORE_CODE = B.STORE_CODE  AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND C.GEN_UOM_CODE = AM.UOM_CODE AND C.LANGUAGE_ID = AM.LANGUAGE_ID GROUP BY A.PHY_INV_ID, B.SHORT_DESC,  C.SHORT_DESC, A.STORE_CODE,A.ITEM_CODE, NVL (D.ENTRY_COMPLETED_YN, 'NU'),AM.SHORT_DESC  ORDER BY 3 ";
 		 	//Added SUM_QTY against MMS-DM-SCF-0364 by Badmavathi B
			sql = " SELECT DISTINCT A.PHY_INV_ID PHY_INV_ID, B.SHORT_DESC STORE_DESC,C.SHORT_DESC ITEM_DESC, A.STORE_CODE STORE_CODE, A.ITEM_CODE ITEM_CODE, NVL (D.ENTRY_COMPLETED_YN, 'NU') STA_CHK,COUNT(E.ITEM_CODE) COUNT, SUM(D.ITEM_QTY)SUM_QTY, AM.SHORT_DESC GEN_UOM_DESC  FROM ST_PHY_INV_HDR A, MM_STORE_LANG_VW B,  MM_ITEM_LANG_VW C, ST_PHY_INV_DTL D,  ST_ITEM_BATCH E, AM_UOM_LANG_VW AM  WHERE A.PHY_INV_ID = NVL (?, A.PHY_INV_ID)  AND A.STORE_CODE = NVL (?, A.STORE_CODE)  AND A.ITEM_CODE = NVL (?, A.ITEM_CODE)  AND A.FACILITY_ID = ?  AND A.PHY_INV_ID = D.PHY_INV_ID(+)  AND A.STORE_CODE = D.STORE_CODE(+)  AND A.ITEM_CODE = D.ITEM_CODE(+)  AND A.ITEM_CODE = E.ITEM_CODE(+)  AND A.STORE_CODE = E.STORE_CODE(+)  AND A.ITEM_CODE = C.ITEM_CODE  AND A.STORE_CODE = B.STORE_CODE  AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND C.GEN_UOM_CODE = AM.UOM_CODE AND C.LANGUAGE_ID = AM.LANGUAGE_ID GROUP BY A.PHY_INV_ID, B.SHORT_DESC,  C.SHORT_DESC, A.STORE_CODE,A.ITEM_CODE, NVL (D.ENTRY_COMPLETED_YN, 'NU'),AM.SHORT_DESC  ORDER BY 3 ";
		  if((display_batch_lookup.equalsIgnoreCase("Y")) && display_batch_lookup_all.equalsIgnoreCase("GRN")){
             //sql = " SELECT DISTINCT A.PHY_INV_ID PHY_INV_ID, B.SHORT_DESC STORE_DESC, C.SHORT_DESC ITEM_DESC, A.STORE_CODE STORE_CODE, A.ITEM_CODE ITEM_CODE, NVL (D.ENTRY_COMPLETED_YN,  'NU') STA_CHK,COUNT(E.ITEM_CODE) COUNT FROM ST_PHY_INV_HDR A,  MM_STORE_LANG_VW B,  MM_ITEM_LANG_VW C, ST_PHY_INV_DTL D,  ST_GRN_DTL_EXP E  WHERE A.PHY_INV_ID = NVL (?, A.PHY_INV_ID) AND A.STORE_CODE = NVL (?, A.STORE_CODE)  AND A.ITEM_CODE = NVL (?, A.ITEM_CODE)  AND A.FACILITY_ID = ?  AND A.PHY_INV_ID = D.PHY_INV_ID(+) AND A.STORE_CODE = D.STORE_CODE(+)  AND A.ITEM_CODE = D.ITEM_CODE(+)  AND A.ITEM_CODE = E.ITEM_CODE(+)  AND A.STORE_CODE = E.STORE_CODE(+)  AND A.FACILITY_ID = E.FACILITY_ID(+)  AND A.ITEM_CODE = C.ITEM_CODE  AND A.STORE_CODE = B.STORE_CODE  AND B.LANGUAGE_ID = C.LANGUAGE_ID  AND B.LANGUAGE_ID = ? GROUP BY A.PHY_INV_ID, B.SHORT_DESC, C.SHORT_DESC, A.STORE_CODE, A.ITEM_CODE, NVL (D.ENTRY_COMPLETED_YN,  'NU') ORDER BY 3 ";
			//Modified by suresh.r on 29-07-2014 against MMS-SCF-0390
			  //sql = " SELECT DISTINCT A.PHY_INV_ID PHY_INV_ID, B.SHORT_DESC STORE_DESC, C.SHORT_DESC ITEM_DESC, A.STORE_CODE STORE_CODE, A.ITEM_CODE ITEM_CODE, NVL (D.ENTRY_COMPLETED_YN,  'NU') STA_CHK,COUNT(E.ITEM_CODE) COUNT, AM.SHORT_DESC GEN_UOM_DESC  FROM ST_PHY_INV_HDR A,  MM_STORE_LANG_VW B,  MM_ITEM_LANG_VW C, ST_PHY_INV_DTL D,  ST_GRN_DTL_EXP E, AM_UOM_LANG_VW AM  WHERE A.PHY_INV_ID = NVL (?, A.PHY_INV_ID) AND A.STORE_CODE = NVL (?, A.STORE_CODE)  AND A.ITEM_CODE = NVL (?, A.ITEM_CODE)  AND A.FACILITY_ID = ?  AND A.PHY_INV_ID = D.PHY_INV_ID(+) AND A.STORE_CODE = D.STORE_CODE(+)  AND A.ITEM_CODE = D.ITEM_CODE(+)  AND A.ITEM_CODE = E.ITEM_CODE(+)  AND A.STORE_CODE = E.STORE_CODE(+)  AND A.FACILITY_ID = E.FACILITY_ID(+)  AND A.ITEM_CODE = C.ITEM_CODE  AND A.STORE_CODE = B.STORE_CODE  AND B.LANGUAGE_ID = C.LANGUAGE_ID  AND B.LANGUAGE_ID = ? AND C.GEN_UOM_CODE = AM.UOM_CODE AND C.LANGUAGE_ID = AM.LANGUAGE_ID GROUP BY A.PHY_INV_ID, B.SHORT_DESC, C.SHORT_DESC, A.STORE_CODE, A.ITEM_CODE, NVL (D.ENTRY_COMPLETED_YN,  'NU'),AM.SHORT_DESC ORDER BY 3 ";
			  //Added SUM_QTY against MMS-DM-SCF-0364 by Badmavathi B
			  sql = " SELECT DISTINCT A.PHY_INV_ID PHY_INV_ID, B.SHORT_DESC STORE_DESC, C.SHORT_DESC ITEM_DESC, A.STORE_CODE STORE_CODE, A.ITEM_CODE ITEM_CODE, NVL (D.ENTRY_COMPLETED_YN,  'NU') STA_CHK,COUNT(E.ITEM_CODE) COUNT,SUM(D.ITEM_QTY)SUM_QTY, AM.SHORT_DESC GEN_UOM_DESC  FROM ST_PHY_INV_HDR A,  MM_STORE_LANG_VW B,  MM_ITEM_LANG_VW C, ST_PHY_INV_DTL D,  ST_GRN_DTL_EXP E, AM_UOM_LANG_VW AM  WHERE A.PHY_INV_ID = NVL (?, A.PHY_INV_ID) AND A.STORE_CODE = NVL (?, A.STORE_CODE)  AND A.ITEM_CODE = NVL (?, A.ITEM_CODE)  AND A.FACILITY_ID = ?  AND A.PHY_INV_ID = D.PHY_INV_ID(+) AND A.STORE_CODE = D.STORE_CODE(+)  AND A.ITEM_CODE = D.ITEM_CODE(+)  AND A.ITEM_CODE = E.ITEM_CODE(+)  AND A.STORE_CODE = E.STORE_CODE(+)  AND A.FACILITY_ID = E.FACILITY_ID(+)  AND A.ITEM_CODE = C.ITEM_CODE  AND A.STORE_CODE = B.STORE_CODE  AND B.LANGUAGE_ID = C.LANGUAGE_ID  AND B.LANGUAGE_ID = ? AND C.GEN_UOM_CODE = AM.UOM_CODE AND C.LANGUAGE_ID = AM.LANGUAGE_ID GROUP BY A.PHY_INV_ID, B.SHORT_DESC, C.SHORT_DESC, A.STORE_CODE, A.ITEM_CODE, NVL (D.ENTRY_COMPLETED_YN,  'NU'),AM.SHORT_DESC ORDER BY 3 ";
		  }
       
            
        
		try{
			
			ArrayList alRecords = fetchRecords(sql,alParameters);
			for(int i=0;i<alRecords.size();i++){
				hmTemp	= new HashMap();
				hmTemp	=	(HashMap)alRecords.get(i);
				alDtlRecords.add(hmTemp);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public ArrayList loadData1(int index) {
		ArrayList alRecords	= new ArrayList();
		try{
				ArrayList alParameters = new ArrayList();
				//alParameters.add(getLoginFacilityId());				
				alParameters.add(this.store_code);
				alParameters.add(this.item_code);
				alParameters.add(this.phy_inv_id);
				alParameters.add(this.language_id);//Added by suresh.r on 29-07-2014 against MMS-SCF-0390
				alParameters.add(this.store_code);
				alParameters.add(this.item_code);
				alParameters.add(this.language_id);//Added by suresh.r on 29-07-2014 against MMS-SCF-0390
				//alParameters.add(this.phy_inv_id);
				alParameters.add(this.store_code);
				alParameters.add(this.item_code);
				alParameters.add(this.phy_inv_id);
				alParameters.add(this.language_id);//Added by suresh.r on 29-07-2014 against MMS-SCF-0390
				//String sql = getStRepositoryValue("ST_SQL_PHY_INV_BATCH_DETAIL_SELECT");
				//String sql = "SELECT   * FROM (SELECT   DTL.ITEM_CODE ITEM_CODE, ITM.ALLOW_DECIMALS_YN ALLOW_DECIMALS_YN, BATCH_ID, TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_DATE, BIN_LOCATION_CODE BIN_LOC_CODE, TRADE_ID, ITEM_QTY, NEW_BATCH_YN, 'Y' CHECK_YN, ENTRY_COMPLETED_YN FROM ST_PHY_INV_DTL DTL, ST_ITEM ITM WHERE STORE_CODE = ? AND DTL.ITEM_CODE = ? AND PHY_INV_ID = ? AND DTL.ITEM_CODE = ITM.ITEM_CODE UNION (SELECT BATCH.ITEM_CODE ITEM_CODE, ITM.ALLOW_DECIMALS_YN ALLOW_DECIMALS_YN, BATCH_ID, TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_DATE, BIN_LOCATION_CODE BIN_LOC_CODE, TRADE_ID, TO_NUMBER ('') ITEM_QTY, 'N' NEW_BATCH_YN, 'N' CHECK_YN, 'N' ENTRY_COMPLETED_YN FROM ST_ITEM_BATCH BATCH, ST_ITEM ITM WHERE STORE_CODE = ? AND BATCH.ITEM_CODE = ? AND BATCH.ITEM_CODE = ITM.ITEM_CODE MINUS SELECT DTL.ITEM_CODE ITEM_CODE, ITM.ALLOW_DECIMALS_YN ALLOW_DECIMALS_YN, BATCH_ID, TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_DATE, BIN_LOCATION_CODE BIN_LOC_CODE, TRADE_ID, TO_NUMBER ('') ITEM_QTY, 'N' NEW_BATCH_YN, 'N' CHECK_YN, 'N' ENTRY_COMPLETED_YN FROM ST_PHY_INV_DTL DTL, ST_ITEM ITM WHERE STORE_CODE = ? AND DTL.ITEM_CODE = ? AND PHY_INV_ID = ? AND DTL.ITEM_CODE = ITM.ITEM_CODE)) ORDER BY TO_DATE (EXPIRY_DATE, 'DD/MM/YYYY' ),BATCH_ID ";
				//Modified by suresh.r on 29-07-2014 against MMS-SCF-0390
				//Modified by suresh.r added PHY_UOM_CODE,PHY_UOM_ITEM_QTY column on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253
				getAllow_eqvl_uom_YN();
				String sql="";
				if(getAllow_eqvl_uom().equals("Y")){
					sql = "SELECT   * FROM (SELECT   DTL.ITEM_CODE ITEM_CODE, ITM.ALLOW_DECIMALS_YN ALLOW_DECIMALS_YN, BATCH_ID, TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_DATE, BIN_LOCATION_CODE BIN_LOC_CODE, TRADE_ID, PHY_UOM_ITEM_QTY ITEM_QTY, NEW_BATCH_YN, 'Y' CHECK_YN, ENTRY_COMPLETED_YN, AM.SHORT_DESC GEN_UOM_DESC,DTL.PHY_UOM_CODE PHY_UOM_CODE FROM ST_PHY_INV_DTL DTL, ST_ITEM ITM, MM_ITEM_LANG_VW MM, AM_UOM_LANG_VW AM WHERE STORE_CODE = ? AND DTL.ITEM_CODE = ? AND PHY_INV_ID = ? AND DTL.ITEM_CODE = ITM.ITEM_CODE AND MM.ITEM_CODE=ITM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND MM.LANGUAGE_ID = ? AND MM.LANGUAGE_ID = AM.LANGUAGE_ID UNION (SELECT BATCH.ITEM_CODE ITEM_CODE, ITM.ALLOW_DECIMALS_YN ALLOW_DECIMALS_YN, BATCH_ID, TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_DATE, BIN_LOCATION_CODE BIN_LOC_CODE, TRADE_ID, TO_NUMBER ('') ITEM_QTY, 'N' NEW_BATCH_YN, 'N' CHECK_YN, 'N' ENTRY_COMPLETED_YN, AM.SHORT_DESC GEN_UOM_DESC,'' PHY_UOM_CODE FROM ST_ITEM_BATCH BATCH, ST_ITEM ITM, MM_ITEM_LANG_VW MM, AM_UOM_LANG_VW AM WHERE STORE_CODE = ? AND BATCH.ITEM_CODE = ? AND BATCH.ITEM_CODE = ITM.ITEM_CODE AND MM.ITEM_CODE=ITM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND MM.LANGUAGE_ID = ? AND MM.LANGUAGE_ID = AM.LANGUAGE_ID MINUS SELECT DTL.ITEM_CODE ITEM_CODE, ITM.ALLOW_DECIMALS_YN ALLOW_DECIMALS_YN, BATCH_ID, TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_DATE, BIN_LOCATION_CODE BIN_LOC_CODE, TRADE_ID, TO_NUMBER ('') ITEM_QTY, 'N' NEW_BATCH_YN, 'N' CHECK_YN, 'N' ENTRY_COMPLETED_YN, AM.SHORT_DESC GEN_UOM_DESC,'' PHY_UOM_CODE FROM ST_PHY_INV_DTL DTL, ST_ITEM ITM, MM_ITEM_LANG_VW MM, AM_UOM_LANG_VW AM WHERE STORE_CODE = ? AND DTL.ITEM_CODE = ? AND PHY_INV_ID = ? AND DTL.ITEM_CODE = ITM.ITEM_CODE AND MM.ITEM_CODE=ITM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND MM.LANGUAGE_ID = ? AND MM.LANGUAGE_ID = AM.LANGUAGE_ID)) ORDER BY TO_DATE (EXPIRY_DATE, 'DD/MM/YYYY' ),BATCH_ID ";
				}else{
					sql = "SELECT   * FROM (SELECT   DTL.ITEM_CODE ITEM_CODE, ITM.ALLOW_DECIMALS_YN ALLOW_DECIMALS_YN, BATCH_ID, TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_DATE, BIN_LOCATION_CODE BIN_LOC_CODE, TRADE_ID, ITEM_QTY, NEW_BATCH_YN, 'Y' CHECK_YN, ENTRY_COMPLETED_YN, AM.SHORT_DESC GEN_UOM_DESC FROM ST_PHY_INV_DTL DTL, ST_ITEM ITM, MM_ITEM_LANG_VW MM, AM_UOM_LANG_VW AM WHERE STORE_CODE = ? AND DTL.ITEM_CODE = ? AND PHY_INV_ID = ? AND DTL.ITEM_CODE = ITM.ITEM_CODE AND MM.ITEM_CODE=ITM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND MM.LANGUAGE_ID = ? AND MM.LANGUAGE_ID = AM.LANGUAGE_ID UNION (SELECT BATCH.ITEM_CODE ITEM_CODE, ITM.ALLOW_DECIMALS_YN ALLOW_DECIMALS_YN, BATCH_ID, TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_DATE, BIN_LOCATION_CODE BIN_LOC_CODE, TRADE_ID, TO_NUMBER ('') ITEM_QTY, 'N' NEW_BATCH_YN, 'N' CHECK_YN, 'N' ENTRY_COMPLETED_YN, AM.SHORT_DESC GEN_UOM_DESC FROM ST_ITEM_BATCH BATCH, ST_ITEM ITM, MM_ITEM_LANG_VW MM, AM_UOM_LANG_VW AM WHERE STORE_CODE = ? AND BATCH.ITEM_CODE = ? AND BATCH.ITEM_CODE = ITM.ITEM_CODE AND MM.ITEM_CODE=ITM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND MM.LANGUAGE_ID = ? AND MM.LANGUAGE_ID = AM.LANGUAGE_ID MINUS SELECT DTL.ITEM_CODE ITEM_CODE, ITM.ALLOW_DECIMALS_YN ALLOW_DECIMALS_YN, BATCH_ID, TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_DATE, BIN_LOCATION_CODE BIN_LOC_CODE, TRADE_ID, TO_NUMBER ('') ITEM_QTY, 'N' NEW_BATCH_YN, 'N' CHECK_YN, 'N' ENTRY_COMPLETED_YN, AM.SHORT_DESC GEN_UOM_DESC FROM ST_PHY_INV_DTL DTL, ST_ITEM ITM, MM_ITEM_LANG_VW MM, AM_UOM_LANG_VW AM WHERE STORE_CODE = ? AND DTL.ITEM_CODE = ? AND PHY_INV_ID = ? AND DTL.ITEM_CODE = ITM.ITEM_CODE AND MM.ITEM_CODE=ITM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND MM.LANGUAGE_ID = ? AND MM.LANGUAGE_ID = AM.LANGUAGE_ID)) ORDER BY TO_DATE (EXPIRY_DATE, 'DD/MM/YYYY' ),BATCH_ID ";
				}
			
				if(batch_lookup.size()==0){
			     batch_lookup = display_batch_lookup();
				}
		        String display_batch_lookup = checkForNull((String)batch_lookup.get("PHY_INV_BATCH_LOOKUP_ENTRY_YN"),"N");
		        String display_batch_lookup_all = checkForNull((String)batch_lookup.get("APPL_BATCHES_IN_PHY_INV_ENTRY"),"ALL");
          
//to_char(doc_date,'dd/mm/yyyy')
				if((display_batch_lookup.equalsIgnoreCase("Y")) && display_batch_lookup_all.equalsIgnoreCase("GRN")){
				
                 //sql =" SELECT   * FROM (SELECT   DTL.ITEM_CODE ITEM_CODE, ITM.ALLOW_DECIMALS_YN ALLOW_DECIMALS_YN, BATCH_ID, TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_DATE, BIN_LOCATION_CODE BIN_LOC_CODE, TRADE_ID, ITEM_QTY, NEW_BATCH_YN, 'Y' CHECK_YN, ENTRY_COMPLETED_YN FROM ST_PHY_INV_DTL DTL, ST_ITEM ITM WHERE STORE_CODE = ? AND DTL.ITEM_CODE = ? AND PHY_INV_ID = ? AND DTL.ITEM_CODE = ITM.ITEM_CODE UNION (SELECT EXP.ITEM_CODE ITEM_CODE, ITM.ALLOW_DECIMALS_YN ALLOW_DECIMALS_YN, BATCH_ID, TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_DATE, BIN_LOCATION_CODE BIN_LOC_CODE, TRADE_ID, TO_NUMBER ('') ITEM_QTY, 'N' NEW_BATCH_YN, 'N' CHECK_YN, 'N' ENTRY_COMPLETED_YN FROM ST_GRN_DTL_EXP EXP, ST_ITEM ITM WHERE STORE_CODE = ? AND EXP.ITEM_CODE = ? AND EXP.ITEM_CODE = ITM.ITEM_CODE MINUS SELECT DTL.ITEM_CODE ITEM_CODE, ITM.ALLOW_DECIMALS_YN ALLOW_DECIMALS_YN, BATCH_ID,TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_DATE, BIN_LOCATION_CODE BIN_LOC_CODE, TRADE_ID, TO_NUMBER ('') ITEM_QTY, 'N' NEW_BATCH_YN, 'N' CHECK_YN, 'N' ENTRY_COMPLETED_YN FROM ST_PHY_INV_DTL DTL, ST_ITEM ITM WHERE STORE_CODE = ? AND DTL.ITEM_CODE = ? AND PHY_INV_ID = ? AND DTL.ITEM_CODE = ITM.ITEM_CODE) ORDER BY BATCH_ID) ORDER BY NEW_BATCH_YN ";
				//Modified by suresh.r on 29-07-2014 against MMS-SCF-0390
				//Modified by suresh.r added PHY_UOM_CODE,PHY_UOM_ITEM_QTY column on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253
				if(getAllow_eqvl_uom().equals("Y")){
					sql =" SELECT   * FROM (SELECT   DTL.ITEM_CODE ITEM_CODE, ITM.ALLOW_DECIMALS_YN ALLOW_DECIMALS_YN, BATCH_ID, TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_DATE, BIN_LOCATION_CODE BIN_LOC_CODE, TRADE_ID, PHY_UOM_ITEM_QTY ITEM_QTY, NEW_BATCH_YN, 'Y' CHECK_YN, ENTRY_COMPLETED_YN, AM.SHORT_DESC GEN_UOM_DESC,DTL.PHY_UOM_CODE PHY_UOM_CODE FROM ST_PHY_INV_DTL DTL, ST_ITEM ITM, MM_ITEM_LANG_VW MM, AM_UOM_LANG_VW AM WHERE STORE_CODE = ? AND DTL.ITEM_CODE = ? AND PHY_INV_ID = ? AND DTL.ITEM_CODE = ITM.ITEM_CODE AND MM.ITEM_CODE=ITM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND MM.LANGUAGE_ID = ? AND MM.LANGUAGE_ID = AM.LANGUAGE_ID UNION (SELECT EXP.ITEM_CODE ITEM_CODE, ITM.ALLOW_DECIMALS_YN ALLOW_DECIMALS_YN, BATCH_ID, TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_DATE, BIN_LOCATION_CODE BIN_LOC_CODE, TRADE_ID, TO_NUMBER ('') ITEM_QTY, 'N' NEW_BATCH_YN, 'N' CHECK_YN, 'N' ENTRY_COMPLETED_YN, AM.SHORT_DESC GEN_UOM_DESC,'' PHY_UOM_CODE FROM ST_GRN_DTL_EXP EXP, ST_ITEM ITM, MM_ITEM_LANG_VW MM, AM_UOM_LANG_VW AM WHERE STORE_CODE = ? AND EXP.ITEM_CODE = ? AND EXP.ITEM_CODE = ITM.ITEM_CODE AND MM.ITEM_CODE=ITM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND MM.LANGUAGE_ID = ? AND MM.LANGUAGE_ID = AM.LANGUAGE_ID MINUS SELECT DTL.ITEM_CODE ITEM_CODE, ITM.ALLOW_DECIMALS_YN ALLOW_DECIMALS_YN, BATCH_ID,TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_DATE, BIN_LOCATION_CODE BIN_LOC_CODE, TRADE_ID, TO_NUMBER ('') ITEM_QTY, 'N' NEW_BATCH_YN, 'N' CHECK_YN, 'N' ENTRY_COMPLETED_YN, AM.SHORT_DESC GEN_UOM_DESC,'' PHY_UOM_CODE FROM ST_PHY_INV_DTL DTL, ST_ITEM ITM, MM_ITEM_LANG_VW MM, AM_UOM_LANG_VW AM WHERE STORE_CODE = ? AND DTL.ITEM_CODE = ? AND PHY_INV_ID = ? AND DTL.ITEM_CODE = ITM.ITEM_CODE AND MM.ITEM_CODE=ITM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND MM.LANGUAGE_ID = ? AND MM.LANGUAGE_ID = AM.LANGUAGE_ID) ORDER BY BATCH_ID) ORDER BY NEW_BATCH_YN ";
				}else{
					sql =" SELECT   * FROM (SELECT   DTL.ITEM_CODE ITEM_CODE, ITM.ALLOW_DECIMALS_YN ALLOW_DECIMALS_YN, BATCH_ID, TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_DATE, BIN_LOCATION_CODE BIN_LOC_CODE, TRADE_ID, ITEM_QTY, NEW_BATCH_YN, 'Y' CHECK_YN, ENTRY_COMPLETED_YN, AM.SHORT_DESC GEN_UOM_DESC FROM ST_PHY_INV_DTL DTL, ST_ITEM ITM, MM_ITEM_LANG_VW MM, AM_UOM_LANG_VW AM WHERE STORE_CODE = ? AND DTL.ITEM_CODE = ? AND PHY_INV_ID = ? AND DTL.ITEM_CODE = ITM.ITEM_CODE AND MM.ITEM_CODE=ITM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND MM.LANGUAGE_ID = ? AND MM.LANGUAGE_ID = AM.LANGUAGE_ID UNION (SELECT EXP.ITEM_CODE ITEM_CODE, ITM.ALLOW_DECIMALS_YN ALLOW_DECIMALS_YN, BATCH_ID, TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_DATE, BIN_LOCATION_CODE BIN_LOC_CODE, TRADE_ID, TO_NUMBER ('') ITEM_QTY, 'N' NEW_BATCH_YN, 'N' CHECK_YN, 'N' ENTRY_COMPLETED_YN, AM.SHORT_DESC GEN_UOM_DESC FROM ST_GRN_DTL_EXP EXP, ST_ITEM ITM, MM_ITEM_LANG_VW MM, AM_UOM_LANG_VW AM WHERE STORE_CODE = ? AND EXP.ITEM_CODE = ? AND EXP.ITEM_CODE = ITM.ITEM_CODE AND MM.ITEM_CODE=ITM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND MM.LANGUAGE_ID = ? AND MM.LANGUAGE_ID = AM.LANGUAGE_ID MINUS SELECT DTL.ITEM_CODE ITEM_CODE, ITM.ALLOW_DECIMALS_YN ALLOW_DECIMALS_YN, BATCH_ID,TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_DATE, BIN_LOCATION_CODE BIN_LOC_CODE, TRADE_ID, TO_NUMBER ('') ITEM_QTY, 'N' NEW_BATCH_YN, 'N' CHECK_YN, 'N' ENTRY_COMPLETED_YN, AM.SHORT_DESC GEN_UOM_DESC FROM ST_PHY_INV_DTL DTL, ST_ITEM ITM, MM_ITEM_LANG_VW MM, AM_UOM_LANG_VW AM WHERE STORE_CODE = ? AND DTL.ITEM_CODE = ? AND PHY_INV_ID = ? AND DTL.ITEM_CODE = ITM.ITEM_CODE AND MM.ITEM_CODE=ITM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND MM.LANGUAGE_ID = ? AND MM.LANGUAGE_ID = AM.LANGUAGE_ID) ORDER BY BATCH_ID) ORDER BY NEW_BATCH_YN ";
				}
				}
				alRecords	= fetchRecords(sql, alParameters);
		}
		catch(Exception ex){
			ex.printStackTrace(); 
		}
		try{
			alModRecords.set(index,alRecords);
		}catch(Exception e){
			alModRecords.add(index,alRecords);
		}
		return alRecords;
	}
	public HashMap getStore(String phy_inv_id) throws Exception {	
		HashMap hmRecord		= new HashMap();
		try	{
			ArrayList alParameters	= new ArrayList();
			alParameters.add(phy_inv_id);
			alParameters.add(getLoginFacilityId());
			alParameters.add(getLanguageId());
			hmRecord = fetchRecord(getStRepositoryValue("ST_SQL_PHY_INV_ID_STORE_SELECT"),alParameters);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return hmRecord;
	}
	public void loadResultPage() throws Exception {
          ArrayList alRecords = new ArrayList();
			ArrayList alparameters	= new ArrayList();
			String sql = "";
			String sql1 = "";
			if(batch_lookup.size()==0){
			     batch_lookup = display_batch_lookup();
				}
		//	HashMap batch_lookup = display_batch_lookup();
		 String display_batch_lookup = checkForNull((String)batch_lookup.get("PHY_INV_BATCH_LOOKUP_ENTRY_YN"),"N");
		 String display_batch_lookup_all = checkForNull((String)batch_lookup.get("APPL_BATCHES_IN_PHY_INV_ENTRY"),"ALL");
          
//to_char(doc_date,'dd/mm/yyyy')
				//if((display_batch_lookup.equalsIgnoreCase("Y")) && display_batch_lookup_all.equalsIgnoreCase("ALL")){
				if((display_batch_lookup.equalsIgnoreCase("Y") || display_batch_lookup.equalsIgnoreCase("B")) && display_batch_lookup_all.equalsIgnoreCase("ALL")){ //Added By Sakti against CRF# - RUT-CRF-0081 icn#34757

					/* Commented against Inc#35134 by Sakti Sankar to add batch_id and trade_id parameter

				 sql = " SELECT * FROM ((SELECT DISTINCT TO_CHAR(EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE ,BATCH_ID,NVL(C.SHORT_NAME,DFLT_TRADE_ID) SHORT_NAME,B.MANUFACTURER_ID MANUFACTURER_ID,BIN_LOCATION_CODE,D.SHORT_DESC,A.TRADE_ID TRADE_ID,E.SHORT_DESC STORE_DESC,A.STORE_CODE STORE_CODE FROM ST_ISSUE_DTL_EXP A,MM_ITEM_LANG_VW B,AM_TRADE_NAME_LANG_VW C, AM_UOM_LANG_VW D,MM_STORE_LANG_VW E,MM_PARAMETER F WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.TRADE_ID = C.TRADE_ID(+) AND A.STORE_CODE = E.STORE_CODE AND B.GEN_UOM_CODE = D.UOM_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND E.LANGUAGE_ID = B.LANGUAGE_ID AND C.LANGUAGE_ID(+) = ? AND A.FACILITY_ID = ? AND B.LANGUAGE_ID= ? AND  (A.STORE_CODE BETWEEN NVL(?,'!') AND NVL(?,'~')) AND A.ITEM_CODE = ? UNION SELECT DISTINCT TO_CHAR(EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE,BATCH_ID,NVL(C.SHORT_NAME,DFLT_TRADE_ID) SHORT_NAME,B.MANUFACTURER_ID MANUFACTURER_ID,BIN_LOCATION_CODE,D.SHORT_DESC,A.TRADE_ID TRADE_ID,E.SHORT_DESC STORE_DESC,A.STORE_CODE STORE_CODE FROM ST_ADJ_DTL_EXP A,MM_ITEM_LANG_VW B,AM_TRADE_NAME_LANG_VW C, AM_UOM_LANG_VW D,MM_STORE_LANG_VW E,MM_PARAMETER F WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.TRADE_ID = C.TRADE_ID(+) AND A.STORE_CODE = E.STORE_CODE AND B.GEN_UOM_CODE = D.UOM_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND E.LANGUAGE_ID = B.LANGUAGE_ID AND C.LANGUAGE_ID(+) = ? AND A.FACILITY_ID = ? AND B.LANGUAGE_ID= ? AND  (A.STORE_CODE BETWEEN NVL(?,'!') AND NVL(?,'~')) AND A.ITEM_CODE = ? UNION SELECT DISTINCT TO_CHAR(EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE ,BATCH_ID,NVL(C.SHORT_NAME,DFLT_TRADE_ID) SHORT_NAME,B.MANUFACTURER_ID MANUFACTURER_ID,BIN_LOCATION_CODE,D.SHORT_DESC,A.TRADE_ID TRADE_ID,E.SHORT_DESC STORE_DESC,A.STORE_CODE STORE_CODE FROM ST_GRN_DTL_EXP A,MM_ITEM_LANG_VW B,AM_TRADE_NAME_LANG_VW C, AM_UOM_LANG_VW D,MM_STORE_LANG_VW E,MM_PARAMETER F WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.TRADE_ID = C.TRADE_ID(+) AND A.STORE_CODE = E.STORE_CODE AND B.GEN_UOM_CODE = D.UOM_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND E.LANGUAGE_ID = B.LANGUAGE_ID AND C.LANGUAGE_ID(+) = ? AND A.FACILITY_ID = ? AND B.LANGUAGE_ID= ? AND  (A.STORE_CODE BETWEEN NVL(?,'!') AND NVL(?,'~')) AND A.ITEM_CODE = ? UNION SELECT DISTINCT TO_CHAR(EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE ,BATCH_ID,NVL(C.SHORT_NAME,DFLT_TRADE_ID) SHORT_NAME,B.MANUFACTURER_ID MANUFACTURER_ID,BIN_LOCATION_CODE,D.SHORT_DESC,A.TRADE_ID TRADE_ID,E.SHORT_DESC STORE_DESC,A.STORE_CODE STORE_CODE FROM ST_TRANSFER_DTL_EXP A,MM_ITEM_LANG_VW B,AM_TRADE_NAME_LANG_VW C, AM_UOM_LANG_VW D,MM_STORE_LANG_VW E,MM_PARAMETER F WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.TRADE_ID = C.TRADE_ID(+) AND A.STORE_CODE = E.STORE_CODE AND B.GEN_UOM_CODE = D.UOM_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND E.LANGUAGE_ID = B.LANGUAGE_ID AND C.LANGUAGE_ID(+) =?   AND A.FACILITY_ID = ? AND B.LANGUAGE_ID= ? AND  (A.STORE_CODE BETWEEN NVL(?,'!') AND NVL(?,'~')) AND A.ITEM_CODE = ? UNION SELECT DISTINCT TO_CHAR(EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE,BATCH_ID,NVL(C.SHORT_NAME,DFLT_TRADE_ID) SHORT_NAME,B.MANUFACTURER_ID MANUFACTURER_ID,BIN_LOCATION_CODE,D.SHORT_DESC,A.TRADE_ID TRADE_ID,E.SHORT_DESC STORE_DESC,A.STORE_CODE STORE_CODE FROM ST_ISSUE_RET_DTL_EXP A,MM_ITEM_LANG_VW B,AM_TRADE_NAME_LANG_VW C, AM_UOM_LANG_VW D,MM_STORE_LANG_VW E,MM_PARAMETER F WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.TRADE_ID = C.TRADE_ID(+) AND A.STORE_CODE = E.STORE_CODE AND B.GEN_UOM_CODE = D.UOM_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND E.LANGUAGE_ID = B.LANGUAGE_ID AND C.LANGUAGE_ID(+) = ? AND A.FACILITY_ID = ? AND B.LANGUAGE_ID= ? AND  (A.STORE_CODE BETWEEN NVL(?,'!') AND NVL(?,'~')) AND A.ITEM_CODE = ?) ";
		 sql1 =  " MINUS (SELECT TO_CHAR(EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY')	EXPIRY_DATE_OR_RECEIPT_DATE,BATCH_ID,NVL(C.SHORT_NAME,DFLT_TRADE_ID) SHORT_NAME,B.MANUFACTURER_ID MANUFACTURER_ID,BIN_LOCATION_CODE,D.SHORT_DESC,A.TRADE_ID TRADE_ID,E.SHORT_DESC STORE_DESC,A.STORE_CODE STORE_CODE  FROM ST_ITEM_BATCH A,MM_ITEM_LANG_VW B,AM_TRADE_NAME_LANG_VW C, AM_UOM_LANG_VW D,MM_STORE_LANG_VW E,MM_PARAMETER F WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.TRADE_ID = C.TRADE_ID AND A.STORE_CODE = E.STORE_CODE AND B.GEN_UOM_CODE = D.UOM_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND E.LANGUAGE_ID = B.LANGUAGE_ID AND C.LANGUAGE_ID = ? AND B.LANGUAGE_ID= ? AND  A.STORE_CODE = ? AND A.ITEM_CODE = ?)) ORDER BY 8 ";	  */

//Commented By Sakti against CRF# - RUT-CRF-0081 icn#34757

				/* sql = " SELECT * FROM ((SELECT DISTINCT TO_CHAR(EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE ,BATCH_ID,NVL(C.SHORT_NAME,DFLT_TRADE_ID) SHORT_NAME,B.MANUFACTURER_ID MANUFACTURER_ID,BIN_LOCATION_CODE,D.SHORT_DESC,A.TRADE_ID TRADE_ID,E.SHORT_DESC STORE_DESC,A.STORE_CODE STORE_CODE FROM ST_ISSUE_DTL_EXP A,MM_ITEM_LANG_VW B,AM_TRADE_NAME_LANG_VW C, AM_UOM_LANG_VW D,MM_STORE_LANG_VW E,MM_PARAMETER F WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.TRADE_ID = C.TRADE_ID(+) AND A.STORE_CODE = E.STORE_CODE AND B.GEN_UOM_CODE = D.UOM_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND E.LANGUAGE_ID = B.LANGUAGE_ID AND C.LANGUAGE_ID(+) = ? AND A.FACILITY_ID = ? AND B.LANGUAGE_ID= ? AND  (A.STORE_CODE BETWEEN NVL(?,'!') AND NVL(?,'~')) AND A.ITEM_CODE = ? AND UPPER(a.batch_id) LIKE UPPER(?) and c.trade_id like nvl(?,'%') UNION SELECT DISTINCT TO_CHAR(EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE,BATCH_ID,NVL(C.SHORT_NAME,DFLT_TRADE_ID) SHORT_NAME,B.MANUFACTURER_ID MANUFACTURER_ID,BIN_LOCATION_CODE,D.SHORT_DESC,A.TRADE_ID TRADE_ID,E.SHORT_DESC STORE_DESC,A.STORE_CODE STORE_CODE FROM ST_ADJ_DTL_EXP A,MM_ITEM_LANG_VW B,AM_TRADE_NAME_LANG_VW C, AM_UOM_LANG_VW D,MM_STORE_LANG_VW E,MM_PARAMETER F WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.TRADE_ID = C.TRADE_ID(+) AND A.STORE_CODE = E.STORE_CODE AND B.GEN_UOM_CODE = D.UOM_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND E.LANGUAGE_ID = B.LANGUAGE_ID AND C.LANGUAGE_ID(+) = ? AND A.FACILITY_ID = ? AND B.LANGUAGE_ID= ? AND  (A.STORE_CODE BETWEEN NVL(?,'!') AND NVL(?,'~')) AND A.ITEM_CODE = ? AND UPPER(a.batch_id) LIKE UPPER(?) and c.trade_id like nvl(?,'%') UNION SELECT DISTINCT TO_CHAR(EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE ,BATCH_ID,NVL(C.SHORT_NAME,DFLT_TRADE_ID) SHORT_NAME,B.MANUFACTURER_ID MANUFACTURER_ID,BIN_LOCATION_CODE,D.SHORT_DESC,A.TRADE_ID TRADE_ID,E.SHORT_DESC STORE_DESC,A.STORE_CODE STORE_CODE FROM ST_GRN_DTL_EXP A,MM_ITEM_LANG_VW B,AM_TRADE_NAME_LANG_VW C, AM_UOM_LANG_VW D,MM_STORE_LANG_VW E,MM_PARAMETER F WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.TRADE_ID = C.TRADE_ID(+) AND A.STORE_CODE = E.STORE_CODE AND B.GEN_UOM_CODE = D.UOM_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND E.LANGUAGE_ID = B.LANGUAGE_ID AND C.LANGUAGE_ID(+) = ? AND A.FACILITY_ID = ? AND B.LANGUAGE_ID= ? AND  (A.STORE_CODE BETWEEN NVL(?,'!') AND NVL(?,'~')) AND A.ITEM_CODE = ? AND UPPER(a.batch_id) LIKE UPPER(?) and c.trade_id like nvl(?,'%')  UNION SELECT DISTINCT TO_CHAR(EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE ,BATCH_ID,NVL(C.SHORT_NAME,DFLT_TRADE_ID) SHORT_NAME,B.MANUFACTURER_ID MANUFACTURER_ID,BIN_LOCATION_CODE,D.SHORT_DESC,A.TRADE_ID TRADE_ID,E.SHORT_DESC STORE_DESC,A.STORE_CODE STORE_CODE FROM ST_TRANSFER_DTL_EXP A,MM_ITEM_LANG_VW B,AM_TRADE_NAME_LANG_VW C, AM_UOM_LANG_VW D,MM_STORE_LANG_VW E,MM_PARAMETER F WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.TRADE_ID = C.TRADE_ID(+) AND A.STORE_CODE = E.STORE_CODE AND B.GEN_UOM_CODE = D.UOM_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND E.LANGUAGE_ID = B.LANGUAGE_ID AND C.LANGUAGE_ID(+) =?   AND A.FACILITY_ID = ? AND B.LANGUAGE_ID= ? AND  (A.STORE_CODE BETWEEN NVL(?,'!') AND NVL(?,'~')) AND A.ITEM_CODE = ? AND UPPER(a.batch_id) LIKE UPPER(?) and c.trade_id like nvl(?,'%')  UNION SELECT DISTINCT TO_CHAR(EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE,BATCH_ID,NVL(C.SHORT_NAME,DFLT_TRADE_ID) SHORT_NAME,B.MANUFACTURER_ID MANUFACTURER_ID,BIN_LOCATION_CODE,D.SHORT_DESC,A.TRADE_ID TRADE_ID,E.SHORT_DESC STORE_DESC,A.STORE_CODE STORE_CODE FROM ST_ISSUE_RET_DTL_EXP A,MM_ITEM_LANG_VW B,AM_TRADE_NAME_LANG_VW C, AM_UOM_LANG_VW D,MM_STORE_LANG_VW E,MM_PARAMETER F WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.TRADE_ID = C.TRADE_ID(+) AND A.STORE_CODE = E.STORE_CODE AND B.GEN_UOM_CODE = D.UOM_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND E.LANGUAGE_ID = B.LANGUAGE_ID AND C.LANGUAGE_ID(+) = ? AND A.FACILITY_ID = ? AND B.LANGUAGE_ID= ? AND  (A.STORE_CODE BETWEEN NVL(?,'!') AND NVL(?,'~')) AND A.ITEM_CODE = ? AND UPPER(a.batch_id) LIKE UPPER(?) and c.trade_id like nvl(?,'%')) ";
		 sql1 =  " MINUS (SELECT DISTINCT TO_CHAR(EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY')	EXPIRY_DATE_OR_RECEIPT_DATE,BATCH_ID,NVL(C.SHORT_NAME,DFLT_TRADE_ID) SHORT_NAME,B.MANUFACTURER_ID MANUFACTURER_ID,BIN_LOCATION_CODE,D.SHORT_DESC,A.TRADE_ID TRADE_ID,E.SHORT_DESC STORE_DESC,A.STORE_CODE STORE_CODE  FROM ST_ITEM_BATCH A,MM_ITEM_LANG_VW B,AM_TRADE_NAME_LANG_VW C, AM_UOM_LANG_VW D,MM_STORE_LANG_VW E,MM_PARAMETER F WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.TRADE_ID = C.TRADE_ID AND A.STORE_CODE = E.STORE_CODE AND B.GEN_UOM_CODE = D.UOM_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND E.LANGUAGE_ID = B.LANGUAGE_ID AND C.LANGUAGE_ID = ? AND B.LANGUAGE_ID= ? AND  A.STORE_CODE = ? AND A.ITEM_CODE = ? AND UPPER(a.batch_id) LIKE UPPER(?) and c.trade_id like nvl(?,'%'))) ORDER BY 8 ";	 
		 
		 alparameters.add(getLanguageId());  
				    alparameters.add(getLoginFacilityId());
					alparameters.add(getLanguageId());  
					alparameters.add(getFromstoreCode());
					alparameters.add(getTostoreCode());
					alparameters.add(item_code);
					alparameters.add(getBatch_id());
					alparameters.add(getTrade_Code());
					
					alparameters.add(getLanguageId());  
					alparameters.add(getLoginFacilityId());
					alparameters.add(getLanguageId());  
					alparameters.add(getFromstoreCode());
					alparameters.add(getTostoreCode());
					alparameters.add(item_code);
					alparameters.add(getBatch_id());
					alparameters.add(getTrade_Code());

					alparameters.add(getLanguageId());  
					alparameters.add(getLoginFacilityId());
					alparameters.add(getLanguageId());  
					alparameters.add(getFromstoreCode());
					alparameters.add(getTostoreCode());
					alparameters.add(item_code);
					alparameters.add(getBatch_id());
					alparameters.add(getTrade_Code());

					alparameters.add(getLanguageId());  
					alparameters.add(getLoginFacilityId());
					alparameters.add(getLanguageId());  
					alparameters.add(getFromstoreCode());
					alparameters.add(getTostoreCode());
					alparameters.add(item_code);
					alparameters.add(getBatch_id());
					alparameters.add(getTrade_Code());
					
					alparameters.add(getLanguageId());  
					alparameters.add(getLoginFacilityId());
					alparameters.add(getLanguageId());  
					alparameters.add(getFromstoreCode());
					alparameters.add(getTostoreCode());
					alparameters.add(item_code);
					alparameters.add(getBatch_id());
					alparameters.add(getTrade_Code());
					
					alparameters.add(getLanguageId());  
					alparameters.add(getLanguageId());  
					alparameters.add(store_code);
					alparameters.add(item_code);
					alparameters.add(getBatch_id());
					alparameters.add(getTrade_Code()); */
System.out.println("getIncludeExpiredBatches()"+getIncludeExpiredBatches());
		//Added By Sakti against CRF# - RUT-CRF-0081 icn#34757	 
			if(getSearchby().equals("D")) {
		 	sql = 
				"SELECT * FROM ((SELECT DISTINCT TO_CHAR(A.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE,A.BATCH_ID,NVL(C.SHORT_NAME,DFLT_TRADE_ID) SHORT_NAME,B.MANUFACTURER_ID MANUFACTURER_ID,BIN_LOCATION_CODE,D.SHORT_DESC,A.TRADE_ID TRADE_ID,E.SHORT_DESC STORE_DESC,A.STORE_CODE STORE_CODE,a.item_code,b.short_desc item_desc FROM ST_ADJ_DTL_EXP A,MM_ITEM_LANG_VW B,AM_TRADE_NAME_LANG_VW C, AM_UOM_LANG_VW D,MM_STORE_LANG_VW E,MM_PARAMETER F WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.TRADE_ID = C.TRADE_ID(+) AND A.STORE_CODE = E.STORE_CODE AND B.GEN_UOM_CODE = D.UOM_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND E.LANGUAGE_ID = B.LANGUAGE_ID  AND C.LANGUAGE_ID(+) = ? AND A.FACILITY_ID = ? AND B.LANGUAGE_ID= ? AND  (A.STORE_CODE BETWEEN NVL(?,'!') AND NVL(?,'~')) AND A.ITEM_CODE = ? AND UPPER(a.batch_id) LIKE UPPER(?) and c.trade_id like nvl(?,'%') AND a.expiry_date_or_receipt_date  BETWEEN DECODE (?, NULL, TO_DATE ('01/01/1900','dd/mm/yyyy' ), TRUNC (SYSDATE) ) AND DECODE (?, NULL, TO_DATE ('01/01/2900', 'dd/mm/yyyy'), TRUNC (SYSDATE) + ?) and TRUNC(A.ADDED_DATE) BETWEEN trunc(sysdate)- NVL(?,99999)  and trunc(sysdate) and (((?='Y')) OR A.expiry_date_or_receipt_date >= SYSDATE ) 	UNION			SELECT DISTINCT TO_CHAR(A.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE ,A.BATCH_ID,NVL(C.SHORT_NAME,DFLT_TRADE_ID) SHORT_NAME,B.MANUFACTURER_ID MANUFACTURER_ID,BIN_LOCATION_CODE,D.SHORT_DESC,A.TRADE_ID TRADE_ID,E.SHORT_DESC STORE_DESC,A.STORE_CODE STORE_CODE,a.item_code,b.short_desc item_desc FROM ST_GRN_DTL_EXP A,MM_ITEM_LANG_VW B,AM_TRADE_NAME_LANG_VW C, AM_UOM_LANG_VW D,MM_STORE_LANG_VW E,MM_PARAMETER F WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.TRADE_ID = C.TRADE_ID(+) AND A.STORE_CODE = E.STORE_CODE AND B.GEN_UOM_CODE = D.UOM_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND E.LANGUAGE_ID = B.LANGUAGE_ID  AND C.LANGUAGE_ID(+) = ? AND A.FACILITY_ID = ? AND B.LANGUAGE_ID= ? AND  (A.STORE_CODE BETWEEN NVL(?,'!') AND NVL(?,'~')) AND A.ITEM_CODE = ? AND UPPER(a.batch_id) LIKE UPPER(?) and c.trade_id like nvl(?,'%') AND a.expiry_date_or_receipt_date  BETWEEN DECODE (?, NULL, TO_DATE ('01/01/1900','dd/mm/yyyy' ), TRUNC (SYSDATE) ) AND DECODE (?, NULL, TO_DATE ('01/01/2900', 'dd/mm/yyyy'), TRUNC (SYSDATE) + ?) and TRUNC(A.ADDED_DATE) BETWEEN trunc(sysdate)- NVL(?,99999)  and trunc(sysdate) and (((?='Y')) OR A.expiry_date_or_receipt_date >= SYSDATE )  UNION		SELECT DISTINCT TO_CHAR(A.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE,A.BATCH_ID,NVL(C.SHORT_NAME,DFLT_TRADE_ID) SHORT_NAME,B.MANUFACTURER_ID MANUFACTURER_ID,BIN_LOCATION_CODE,D.SHORT_DESC,A.TRADE_ID TRADE_ID,E.SHORT_DESC STORE_DESC,A.STORE_CODE STORE_CODE,a.item_code,b.short_desc item_desc FROM ST_SPLIT_BATCH_DTL_EXP A,MM_ITEM_LANG_VW B,AM_TRADE_NAME_LANG_VW C, AM_UOM_LANG_VW D,MM_STORE_LANG_VW E,MM_PARAMETER F WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.TRADE_ID = C.TRADE_ID(+) AND A.STORE_CODE = E.STORE_CODE AND B.GEN_UOM_CODE = D.UOM_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND E.LANGUAGE_ID = B.LANGUAGE_ID  AND C.LANGUAGE_ID(+) = ? AND A.FACILITY_ID = ? AND B.LANGUAGE_ID= ? AND  (A.STORE_CODE BETWEEN NVL(?,'!') AND NVL(?,'~')) AND A.ITEM_CODE = ? AND UPPER(a.batch_id) LIKE UPPER(?) and c.trade_id like nvl(?,'%') AND a.expiry_date_or_receipt_date  BETWEEN DECODE (?, NULL, TO_DATE ('01/01/1900','dd/mm/yyyy' ), TRUNC (SYSDATE) ) AND DECODE (?, NULL, TO_DATE ('01/01/2900', 'dd/mm/yyyy'), TRUNC (SYSDATE) + ?) and TRUNC(A.ADDED_DATE) BETWEEN trunc(sysdate)- NVL(?,99999)  and trunc(sysdate) and (((?='Y')) OR A.expiry_date_or_receipt_date >= SYSDATE ) ) ";

				 sql1 =  " MINUS (SELECT DISTINCT TO_CHAR(A.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY')	EXPIRY_DATE_OR_RECEIPT_DATE,A.BATCH_ID,NVL(C.SHORT_NAME,DFLT_TRADE_ID) SHORT_NAME,B.MANUFACTURER_ID MANUFACTURER_ID,BIN_LOCATION_CODE,D.SHORT_DESC,A.TRADE_ID TRADE_ID,E.SHORT_DESC STORE_DESC,A.STORE_CODE STORE_CODE,a.item_code,b.short_desc item_desc  FROM ST_ITEM_BATCH A,MM_ITEM_LANG_VW B,AM_TRADE_NAME_LANG_VW C, AM_UOM_LANG_VW D,MM_STORE_LANG_VW E,MM_PARAMETER F WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.TRADE_ID = C.TRADE_ID AND A.STORE_CODE = E.STORE_CODE AND B.GEN_UOM_CODE = D.UOM_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND E.LANGUAGE_ID = B.LANGUAGE_ID  AND C.LANGUAGE_ID = ? AND B.LANGUAGE_ID= ? AND  A.STORE_CODE = ? AND A.ITEM_CODE = ? AND UPPER(a.batch_id) LIKE UPPER(?) and c.trade_id like nvl(?,'%') AND a.expiry_date_or_receipt_date  BETWEEN DECODE (?, NULL, TO_DATE ('01/01/1900','dd/mm/yyyy' ), TRUNC (SYSDATE) ) AND DECODE (?, NULL, TO_DATE ('01/01/2900', 'dd/mm/yyyy'), TRUNC (SYSDATE) + ?) /*and TRUNC(A.ADDED_DATE) BETWEEN trunc(sysdate)- NVL(?,99999)  and trunc(sysdate)*/ and (((?='Y')) OR A.expiry_date_or_receipt_date >= SYSDATE ) )) ORDER BY 8 ";


		}else{
			
				sql = "SELECT * FROM ((SELECT DISTINCT TO_CHAR(A.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE,A.BATCH_ID,/*NVL(C.SHORT_NAME,DFLT_TRADE_ID) SHORT_NAME,*/B.MANUFACTURER_ID MANUFACTURER_ID,/*BIN_LOCATION_CODE,*/D.SHORT_DESC,/*A.TRADE_ID TRADE_ID,E.SHORT_DESC STORE_DESC,A.STORE_CODE STORE_CODE,*/a.item_code,b.short_desc item_desc FROM ST_ADJ_DTL_EXP A,MM_ITEM_LANG_VW B,AM_TRADE_NAME_LANG_VW C, AM_UOM_LANG_VW D,MM_STORE_LANG_VW E,MM_PARAMETER F WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.TRADE_ID = C.TRADE_ID(+) AND A.STORE_CODE = E.STORE_CODE AND B.GEN_UOM_CODE = D.UOM_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND E.LANGUAGE_ID = B.LANGUAGE_ID  AND C.LANGUAGE_ID(+) = ? AND A.FACILITY_ID = ? AND B.LANGUAGE_ID= ? AND  (A.STORE_CODE BETWEEN NVL(?,'!') AND NVL(?,'~')) AND A.ITEM_CODE = ? AND UPPER(a.batch_id) LIKE UPPER(?) and c.trade_id like nvl(?,'%') AND a.expiry_date_or_receipt_date  BETWEEN DECODE (?, NULL, TO_DATE ('01/01/1900','dd/mm/yyyy' ), TRUNC (SYSDATE) ) AND DECODE (?, NULL, TO_DATE ('01/01/2900', 'dd/mm/yyyy'), TRUNC (SYSDATE) + ?) and TRUNC(A.ADDED_DATE) BETWEEN trunc(sysdate)- NVL(?,99999)  and trunc(sysdate) and (((?='Y')) OR A.expiry_date_or_receipt_date >= SYSDATE )	UNION		SELECT DISTINCT TO_CHAR(A.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE ,A.BATCH_ID,/*NVL(C.SHORT_NAME,DFLT_TRADE_ID) SHORT_NAME,*/B.MANUFACTURER_ID MANUFACTURER_ID,/*BIN_LOCATION_CODE,*/D.SHORT_DESC,/*A.TRADE_ID TRADE_ID,E.SHORT_DESC STORE_DESC,A.STORE_CODE STORE_CODE,*/a.item_code,b.short_desc item_desc FROM ST_GRN_DTL_EXP A,MM_ITEM_LANG_VW B,AM_TRADE_NAME_LANG_VW C, AM_UOM_LANG_VW D,MM_STORE_LANG_VW E,MM_PARAMETER F WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.TRADE_ID = C.TRADE_ID(+) AND A.STORE_CODE = E.STORE_CODE AND B.GEN_UOM_CODE = D.UOM_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND E.LANGUAGE_ID = B.LANGUAGE_ID  AND C.LANGUAGE_ID(+) = ? AND A.FACILITY_ID = ? AND B.LANGUAGE_ID= ? AND  (A.STORE_CODE BETWEEN NVL(?,'!') AND NVL(?,'~')) AND A.ITEM_CODE = ? AND UPPER(a.batch_id) LIKE UPPER(?) and c.trade_id like nvl(?,'%') AND a.expiry_date_or_receipt_date  BETWEEN DECODE (?, NULL, TO_DATE ('01/01/1900','dd/mm/yyyy' ), TRUNC (SYSDATE) ) AND DECODE (?, NULL, TO_DATE ('01/01/2900', 'dd/mm/yyyy'), TRUNC (SYSDATE) + ?) and TRUNC(A.ADDED_DATE) BETWEEN trunc(sysdate)- NVL(?,99999)  and trunc(sysdate) and (((?='Y')) OR A.expiry_date_or_receipt_date >= SYSDATE )	 UNION	 SELECT DISTINCT TO_CHAR(A.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE,A.BATCH_ID,/*NVL(C.SHORT_NAME,DFLT_TRADE_ID) SHORT_NAME,*/B.MANUFACTURER_ID MANUFACTURER_ID,/*BIN_LOCATION_CODE,*/D.SHORT_DESC,/*A.TRADE_ID TRADE_ID,E.SHORT_DESC STORE_DESC,A.STORE_CODE STORE_CODE,*/a.item_code,b.short_desc item_desc FROM ST_SPLIT_BATCH_DTL_EXP A,MM_ITEM_LANG_VW B,AM_TRADE_NAME_LANG_VW C, AM_UOM_LANG_VW D,MM_STORE_LANG_VW E,MM_PARAMETER F WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.TRADE_ID = C.TRADE_ID(+) AND A.STORE_CODE = E.STORE_CODE AND B.GEN_UOM_CODE = D.UOM_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND E.LANGUAGE_ID = B.LANGUAGE_ID  AND C.LANGUAGE_ID(+) = ? AND A.FACILITY_ID = ? AND B.LANGUAGE_ID= ? AND  (A.STORE_CODE BETWEEN NVL(?,'!') AND NVL(?,'~')) AND A.ITEM_CODE = ? AND UPPER(a.batch_id) LIKE UPPER(?)  and c.trade_id like nvl(?,'%') AND a.expiry_date_or_receipt_date  BETWEEN DECODE (?, NULL, TO_DATE ('01/01/1900','dd/mm/yyyy' ), TRUNC (SYSDATE) ) AND DECODE (?, NULL, TO_DATE ('01/01/2900', 'dd/mm/yyyy'), TRUNC (SYSDATE) + ?) and TRUNC(A.ADDED_DATE) BETWEEN trunc(sysdate)- NVL(?,99999)  and trunc(sysdate) and (((?='Y')) OR A.expiry_date_or_receipt_date >= SYSDATE ) ) ";

		 sql1 =  " MINUS (SELECT DISTINCT TO_CHAR(A.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY')	EXPIRY_DATE_OR_RECEIPT_DATE,A.BATCH_ID,/*NVL(C.SHORT_NAME,DFLT_TRADE_ID) SHORT_NAME,*/B.MANUFACTURER_ID MANUFACTURER_ID,/*BIN_LOCATION_CODE,*/D.SHORT_DESC,/*A.TRADE_ID TRADE_ID,E.SHORT_DESC STORE_DESC,A.STORE_CODE STORE_CODE,*/a.item_code,b.short_desc item_desc  FROM ST_ITEM_BATCH A,MM_ITEM_LANG_VW B,AM_TRADE_NAME_LANG_VW C, AM_UOM_LANG_VW D,MM_STORE_LANG_VW E,MM_PARAMETER F WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.TRADE_ID = C.TRADE_ID AND A.STORE_CODE = E.STORE_CODE AND B.GEN_UOM_CODE = D.UOM_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND E.LANGUAGE_ID = B.LANGUAGE_ID  AND C.LANGUAGE_ID = ? AND B.LANGUAGE_ID= ? AND  A.STORE_CODE = ? AND A.ITEM_CODE = ? AND UPPER(a.batch_id) LIKE UPPER(?) and c.trade_id like nvl(?,'%') AND a.expiry_date_or_receipt_date  BETWEEN DECODE (?, NULL, TO_DATE ('01/01/1900','dd/mm/yyyy' ), TRUNC (SYSDATE) ) AND DECODE (?, NULL, TO_DATE ('01/01/2900', 'dd/mm/yyyy'), TRUNC (SYSDATE) + ?) /*and TRUNC(A.ADDED_DATE) BETWEEN trunc(sysdate)- NVL(?,99999)  and trunc(sysdate)*/ and (((?='Y')) OR A.expiry_date_or_receipt_date >= SYSDATE ) )) ORDER BY 6 ";
		
		}
				

					alparameters.add(getLanguageId());  
					alparameters.add(getLoginFacilityId());
					alparameters.add(getLanguageId());  
					alparameters.add(getFromstoreCode());
					alparameters.add(getTostoreCode());
					alparameters.add(item_code);
					alparameters.add(getBatch_id());
					alparameters.add(getTrade_Code());
					alparameters.add(getPeriod_Of_Expiry());
					alparameters.add(getPeriod_Of_Expiry());
					alparameters.add(getPeriod_Of_Expiry());
					alparameters.add(getCut_off_date_for_grn());
					alparameters.add(getIncludeExpiredBatches());
					
					alparameters.add(getLanguageId());  
					alparameters.add(getLoginFacilityId());
					alparameters.add(getLanguageId());  
					alparameters.add(getFromstoreCode());
					alparameters.add(getTostoreCode());
					alparameters.add(item_code);
					alparameters.add(getBatch_id());
					alparameters.add(getTrade_Code());
					alparameters.add(getPeriod_Of_Expiry());
					alparameters.add(getPeriod_Of_Expiry());
					alparameters.add(getPeriod_Of_Expiry());
					alparameters.add(getCut_off_date_for_grn());
					alparameters.add(getIncludeExpiredBatches());

					alparameters.add(getLanguageId());  
					alparameters.add(getLoginFacilityId());
					alparameters.add(getLanguageId());  
					alparameters.add(getFromstoreCode());
					alparameters.add(getTostoreCode());
					alparameters.add(item_code);
					alparameters.add(getBatch_id());
					alparameters.add(getTrade_Code());
					alparameters.add(getPeriod_Of_Expiry());
					alparameters.add(getPeriod_Of_Expiry());
					alparameters.add(getPeriod_Of_Expiry());
					alparameters.add(getCut_off_date_for_grn());
					alparameters.add(getIncludeExpiredBatches());
					
					alparameters.add(getLanguageId());  
					alparameters.add(getLanguageId());  
					alparameters.add(store_code);
					alparameters.add(item_code);
					alparameters.add(getBatch_id());
					alparameters.add(getTrade_Code());
					alparameters.add(getPeriod_Of_Expiry());
					alparameters.add(getPeriod_Of_Expiry());
					alparameters.add(getPeriod_Of_Expiry());
					//alparameters.add(getCut_off_date_for_grn());
					alparameters.add(getIncludeExpiredBatches());
					
					//System.out.println("getCut_off_date() FOR ALL BATCHES"+getCut_off_date_for_grn());
				}
				//if((display_batch_lookup.equalsIgnoreCase("Y")) && display_batch_lookup_all.equalsIgnoreCase("GRN"))
				if((display_batch_lookup.equalsIgnoreCase("Y") || display_batch_lookup.equalsIgnoreCase("B")) && display_batch_lookup_all.equalsIgnoreCase("GRN")) //Added By Sakti against CRF# - RUT-CRF-0081 icn#34757

		         {
		     alparameters.clear();
		  /*sql= " select * from ((select distinct to_char(expiry_date_or_receipt_date,'dd/mm/yyyy') expiry_date_or_receipt_date ,batch_id,nvl(c.short_name,DFLT_TRADE_ID) short_name,b.manufacturer_id manufacturer_id,bin_location_code,d.short_desc,a.trade_id trade_id,e.short_desc store_desc,a.store_code store_code from st_grn_dtl_exp a,mm_item_lang_vw b,am_trade_name_lang_vw c, am_uom_lang_vw d,mm_store_lang_vw e,mm_parameter f  where  a.item_code=b.item_code and a.trade_id = c.trade_id(+)  and a.store_code = e.store_code and b.gen_uom_code = d.uom_code  and b.language_id = d.language_id  and c.language_id(+) =? and  e.language_id = b.language_id and a.facility_id = ?  and b.language_id= ? and (a.store_code BETWEEN NVL(?,'!') AND NVL(?,'~')) and a.item_code = ?) ";
		  sql1 =  " minus "+
					  " (select to_char(expiry_date_or_receipt_date,'dd/mm/yyyy') expiry_date_or_receipt_date,batch_id,nvl(c.short_name,DFLT_TRADE_ID) short_name,b.manufacturer_id manufacturer_id,bin_location_code,d.short_desc,a.trade_id trade_id,e.short_desc store_desc,a.store_code store_code "+
						" from st_grn_dtl_exp a,mm_item_lang_vw b,am_trade_name_lang_vw c, am_uom_lang_vw d,mm_store_lang_vw e,mm_parameter f "+
					   " where  a.item_code=b.item_code "+
					   " and a.trade_id = c.trade_id(+) "+
					   " and a.store_code = e.store_code "+
					   " and b.gen_uom_code = d.uom_code "+
					   " and b.language_id = d.language_id "+
					   " and e.language_id = b.language_id "+
                       " and c.language_id(+) = ? "+
					   " and b.language_id= ? "+
					   " and  a.store_code = ? and a.item_code = ?)) order by 8";
					   
				alparameters.add(getLanguageId());  
				alparameters.add(getLoginFacilityId());
			    alparameters.add(getLanguageId());  
			    alparameters.add(getFromstoreCode());
			    alparameters.add(getTostoreCode());
			    alparameters.add(item_code);
				
				alparameters.add(getLanguageId());  
		        alparameters.add(getLanguageId());  
				alparameters.add(store_code);
				alparameters.add(item_code);*/
				if(getSearchby().equals("D")) {
					sql= " select * from ( (select distinct to_char(A.expiry_date_or_receipt_date,'dd/mm/yyyy') expiry_date_or_receipt_date ,A.batch_id,nvl(c.short_name,DFLT_TRADE_ID) short_name,b.manufacturer_id manufacturer_id,bin_location_code,d.short_desc,a.trade_id trade_id,e.short_desc store_desc,a.store_code store_code,a.item_code,b.short_desc item_desc from st_grn_dtl_exp a,mm_item_lang_vw b,am_trade_name_lang_vw c, am_uom_lang_vw d,mm_store_lang_vw e,mm_parameter f where  a.item_code=b.item_code and a.trade_id = c.trade_id(+)  and a.store_code = e.store_code and b.gen_uom_code = d.uom_code  and b.language_id = d.language_id  and c.language_id(+) =? and  e.language_id = b.language_id and a.facility_id = ?  and b.language_id= ? and (a.store_code BETWEEN NVL(?,'!') AND NVL(?,'~')) and a.item_code = ? and UPPER(a.batch_id) LIKE UPPER(?) and c.trade_id like nvl(?,'%')  AND a.expiry_date_or_receipt_date  BETWEEN DECODE (?, NULL, TO_DATE ('01/01/1900','dd/mm/yyyy' ), TRUNC (SYSDATE) ) AND DECODE (?, NULL, TO_DATE ('01/01/2900', 'dd/mm/yyyy'), TRUNC (SYSDATE) + ?) and TRUNC(A.ADDED_DATE) BETWEEN trunc(sysdate)- NVL(?,99999)  and trunc(sysdate) and (((?='Y')) OR A.expiry_date_or_receipt_date >= SYSDATE ) ) ";
		  sql1 =  " minus "+
					  " (SELECT DISTINCT TO_CHAR(A.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY')	EXPIRY_DATE_OR_RECEIPT_DATE,A.BATCH_ID,NVL(C.SHORT_NAME,DFLT_TRADE_ID) SHORT_NAME,B.MANUFACTURER_ID MANUFACTURER_ID,BIN_LOCATION_CODE,D.SHORT_DESC,A.TRADE_ID TRADE_ID,E.SHORT_DESC STORE_DESC,A.STORE_CODE STORE_CODE,a.item_code,b.short_desc item_desc  FROM ST_ITEM_BATCH A,MM_ITEM_LANG_VW B,AM_TRADE_NAME_LANG_VW C, AM_UOM_LANG_VW D,MM_STORE_LANG_VW E,MM_PARAMETER F WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.TRADE_ID = C.TRADE_ID AND A.STORE_CODE = E.STORE_CODE AND B.GEN_UOM_CODE = D.UOM_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND E.LANGUAGE_ID = B.LANGUAGE_ID  AND C.LANGUAGE_ID = ? AND B.LANGUAGE_ID= ? AND  A.STORE_CODE = ? AND A.ITEM_CODE = ? AND UPPER(a.batch_id) LIKE UPPER(?) and c.trade_id like nvl(?,'%') AND a.expiry_date_or_receipt_date  BETWEEN DECODE (?, NULL, TO_DATE ('01/01/1900','dd/mm/yyyy' ), TRUNC (SYSDATE) ) AND DECODE (?, NULL, TO_DATE ('01/01/2900', 'dd/mm/yyyy'), TRUNC (SYSDATE) + ?) /*and TRUNC(A.ADDED_DATE) BETWEEN trunc(sysdate)- NVL(?,99999)  and trunc(sysdate)*/ and (((?='Y')) OR A.expiry_date_or_receipt_date >= SYSDATE ) )) order by 8";
				}else{

		  sql= " select * from ( (select distinct to_char(A.expiry_date_or_receipt_date,'dd/mm/yyyy') expiry_date_or_receipt_date ,A.batch_id,/*nvl(c.short_name,DFLT_TRADE_ID) short_name,*/b.manufacturer_id manufacturer_id,/*bin_location_code,*/d.short_desc,/*a.trade_id trade_id,e.short_desc store_desc,a.store_code store_code,*/a.item_code,b.short_desc item_desc from st_grn_dtl_exp a,mm_item_lang_vw b,am_trade_name_lang_vw c, am_uom_lang_vw d,mm_store_lang_vw e,mm_parameter f  where  a.item_code=b.item_code and a.trade_id = c.trade_id(+)  and a.store_code = e.store_code and b.gen_uom_code = d.uom_code  and b.language_id = d.language_id  and c.language_id(+) =? and  e.language_id = b.language_id and  a.facility_id = ?  and b.language_id= ? and (a.store_code BETWEEN NVL(?,'!') AND NVL(?,'~')) and a.item_code = ? and UPPER(a.batch_id) LIKE UPPER(?) and c.trade_id like nvl(?,'%')  AND a.expiry_date_or_receipt_date  BETWEEN DECODE (?, NULL, TO_DATE ('01/01/1900','dd/mm/yyyy' ), TRUNC (SYSDATE) ) AND DECODE (?, NULL, TO_DATE ('01/01/2900', 'dd/mm/yyyy'), TRUNC (SYSDATE) + ?) and TRUNC(A.ADDED_DATE) BETWEEN trunc(sysdate)- NVL(?,99999)  and trunc(sysdate) and (((?='Y')) OR A.expiry_date_or_receipt_date >= SYSDATE ) ) ";
		  sql1 =  " minus "+
					  " (SELECT DISTINCT TO_CHAR(A.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY')	EXPIRY_DATE_OR_RECEIPT_DATE,A.BATCH_ID,/*NVL(C.SHORT_NAME,DFLT_TRADE_ID) SHORT_NAME,*/B.MANUFACTURER_ID MANUFACTURER_ID,/*BIN_LOCATION_CODE,*/D.SHORT_DESC,/*A.TRADE_ID TRADE_ID,E.SHORT_DESC STORE_DESC,A.STORE_CODE STORE_CODE,*/a.item_code,b.short_desc item_desc  FROM ST_ITEM_BATCH A,MM_ITEM_LANG_VW B,AM_TRADE_NAME_LANG_VW C, AM_UOM_LANG_VW D,MM_STORE_LANG_VW E,MM_PARAMETER F WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.TRADE_ID = C.TRADE_ID AND A.STORE_CODE = E.STORE_CODE AND B.GEN_UOM_CODE = D.UOM_CODE AND B.LANGUAGE_ID = D.LANGUAGE_ID AND E.LANGUAGE_ID = B.LANGUAGE_ID  AND C.LANGUAGE_ID = ? AND B.LANGUAGE_ID= ? AND  A.STORE_CODE = ? AND A.ITEM_CODE = ? AND UPPER(a.batch_id) LIKE UPPER(?) and c.trade_id like nvl(?,'%') AND a.expiry_date_or_receipt_date  BETWEEN DECODE (?, NULL, TO_DATE ('01/01/1900','dd/mm/yyyy' ), TRUNC (SYSDATE) ) AND DECODE (?, NULL, TO_DATE ('01/01/2900', 'dd/mm/yyyy'), TRUNC (SYSDATE) + ?) /*and TRUNC(A.ADDED_DATE) BETWEEN trunc(sysdate)- NVL(?,99999)  and trunc(sysdate)*/ and (((?='Y')) OR A.expiry_date_or_receipt_date >= SYSDATE ))) order by 6";
				}
				alparameters.add(getLanguageId());  
				alparameters.add(getLoginFacilityId());
			    alparameters.add(getLanguageId());  
			    alparameters.add(getFromstoreCode());
			    alparameters.add(getTostoreCode());
			    alparameters.add(item_code);
				alparameters.add(getBatch_id());
				alparameters.add(getTrade_Code());
				alparameters.add(getPeriod_Of_Expiry());
				alparameters.add(getPeriod_Of_Expiry());
				alparameters.add(getPeriod_Of_Expiry());
				alparameters.add(getCut_off_date_for_grn());
				alparameters.add(getIncludeExpiredBatches());
			
				
				alparameters.add(getLanguageId());  
				alparameters.add(getLanguageId());  
				alparameters.add(store_code);
				alparameters.add(item_code);
				alparameters.add(getBatch_id());
				alparameters.add(getTrade_Code());
				alparameters.add(getPeriod_Of_Expiry());
				alparameters.add(getPeriod_Of_Expiry());
				alparameters.add(getPeriod_Of_Expiry());
				//alparameters.add(getCut_off_date_for_grn());
				alparameters.add(getIncludeExpiredBatches());
				
		 }
		
		String order_by = getOrder_status(); 
	
	try
		{

		alRecords	= fetchRecords(sql+sql1+order_by, alparameters);
		
		}catch (Exception ex)
		{
		ex.printStackTrace();
		}
	  setDataList(alRecords);
	}
public String getOrder_status()
	{
	   String order_by = "";
		
		if(getObj().equalsIgnoreCase("EXPDT"))
		{
			if(getOrder().equalsIgnoreCase("desc"))
			 order_by = " , To_Date(expiry_date_or_receipt_date,'DD/MM/YY') DESC ";
				else
			order_by = " , To_Date(expiry_date_or_receipt_date,'DD/MM/YY') ASC";  
		}
		if(getObj().equalsIgnoreCase("BATCHID"))
		{
			if(getOrder().equalsIgnoreCase("desc"))
			order_by = " , 2 DESC ";
			else
		    order_by = " , 2 ASC";  
		}
		if(getObj().equalsIgnoreCase("TRADENAME"))
		{
			if(getOrder().equalsIgnoreCase("desc"))
			order_by = " , 3 DESC ";
			else
			order_by = " , 3 ASC";  
		}
	if(getObj().equalsIgnoreCase("MANUF"))
		{
			if(getOrder().equalsIgnoreCase("desc"))
			order_by = " , 4 DESC ";
			else
			order_by = " , 4 ASC";  
		}
	if(getObj().equalsIgnoreCase("BINC"))
		{
			if(getOrder().equalsIgnoreCase("desc"))
	    order_by = " , 5 DESC ";
			else
         order_by = " , 5 ASC";  
		}
	if(getObj().equalsIgnoreCase("UOM"))
		{
			if(getOrder().equalsIgnoreCase("desc"))
	    order_by = " , 6 DESC ";
			else
         order_by = " , 6 ASC";  
		}
	
	return order_by;
	}
/*public boolean isDuplicateExists(String key_add_batch,ArrayList alRecords)
	{
     Boolean duplicate=new Boolean(false);
	 HashMap alRec_m = new HashMap();
	for(int i=0;i<alRecords.size();i++)
	{
	alRec_m = (HashMap)alRecords.get(i);
	String batch_id = (String)alRec_m.get("BATCH_ID");
	String bin_loc_code = (String)alRec_m.get("BIN_LOC_CODE");
	String expiry_date = (String)alRec_m.get("EXPIRY_DATE");
	String trade_id = (String)alRec_m.get("TRADE_ID");
	String key_val = batch_id+bin_loc_code+expiry_date+trade_id;
	if(key_val.equalsIgnoreCase(key_add_batch))
		return new Boolean(true);
	}
	return duplicate;
	}*/
//Added By Sakti Sankar against Inc#34757
public HashMap isDuplicateExists(String key_add_batch,ArrayList alRecords)
	{
     //Boolean duplicate=new Boolean(false);
	 HashMap alRec_m = new HashMap();
	 HashMap hmResult = new HashMap();
     boolean exists = false;

	for(int i=0;i<alRecords.size();i++){

		alRec_m = (HashMap)alRecords.get(i);
		String batch_id = (String)alRec_m.get("BATCH_ID");
		//String bin_loc_code = (String)alRec_m.get("BIN_LOC_CODE");
		//String expiry_date = (String)alRec_m.get("EXPIRY_DATE");
		//String trade_id = (String)alRec_m.get("TRADE_ID");

		//String key_val = batch_id+bin_loc_code+expiry_date+trade_id; 
		String key_val = batch_id;

		if(key_val.equals(key_add_batch)) {
			hmResult.put("flag",batch_id);
			hmResult.put("result1",new Boolean(true));
			hmResult.put("message","duplicate exists with out case sensitive");
			break;
		}
		else if(key_val.equalsIgnoreCase(key_add_batch)) {	
			hmResult.put("flag",batch_id);
			hmResult.put("result1",new Boolean(false));
			hmResult.put("message","duplicate exists with case sensitive");
			exists = true;
		}else{
			if(!exists) {
				hmResult.put("result1",new Boolean(false));
				hmResult.put("message","new batch");
			}
		}
	}
	return hmResult;
}
//Added ends


public HashMap getBatchCommittedQty(String _item_code, String _store_code,String _batch_id,String _bin_loc_code, String _expiry_date) throws Exception{ 
		
		String alParameters[] = {_store_code,_item_code,_batch_id ,_bin_loc_code,_expiry_date,getLanguageId()};	
		//String committed_qty			  = "";	commented for unused variables by Ganga Thursday, June 27, 2013

		HashMap Committed	  = new HashMap();

		try{
		Committed = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_BATCH_FOR_COMMITED_QTY"),alParameters);			
		}
		catch(Exception e){
			 e.printStackTrace();
		}
		return Committed;
}
//Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 Beg
public String get_uom_code_List(String item_code,String uom_code){
	String gen_uom_code ="";
	try{
		HashMap res = fetchRecord(getStRepositoryValue("SQL_ST_STOCK_BASE_UOM_SELECT"),new String[]{item_code,this.store_code});
		gen_uom_code=(String)res.get("BASE_UOM");
		if(checkForNull(uom_code).equals("")){
			uom_code=(String)res.get("STOCK_UOM");
		}
	}catch(Exception e){
		e.printStackTrace();
		
	}
	getUOMConvfact(item_code,uom_code);
	String chkParameters[] = {getLanguageId(),item_code,this.store_code,gen_uom_code,getLanguageId(),gen_uom_code,getLanguageId(),item_code};
	return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_PHY_UOM_SELECT"),chkParameters,false),uom_code);


	}
public String getUOMConvfact(String item_code,String uom_code){
	ArrayList alParameters = new ArrayList();
	try {
		
	    alParameters.add(item_code);
		alParameters.add(uom_code);

		conv_fact=(String)fetchRecord("SELECT ST_GET_UOM_CONV_FACTOR_UOM(?,?) CONV_FACTOR FROM DUAL",	alParameters).get("CONV_FACTOR");
		conv_fact = conv_fact.substring(0,conv_fact.indexOf("~"));
	}	catch(Exception e){
		e.printStackTrace();
	}
	return conv_fact;
}
public void getAllow_eqvl_uom_YN(){
	try {
		this.allow_eqvl_uom=checkForNull((String)((HashMap)fetchRecord(getStRepositoryValue("SQL_ALLOW_EQVL_UOMS_PHY_INV_ENTRY_YN"),getLoginFacilityId())).get("ALLOW_EQVL_UOMS_PHY_INV_ENTRY"),"N");
	}	catch(Exception e){
		e.printStackTrace();
	}
}
//Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 end
//Added for TH-KW-CRF-0083 start
	public boolean processFileData(String file_name, String store_code ,String phy_inv_id,String entry_complete_yn,String filePath) {
		//System.out.println("Inside processFileData");
		this.entry_completed_yn=entry_complete_yn;
		this.client_file_name=file_name;
	    file_name=  file_name.substring( file_name.lastIndexOf('\\')+1);
	   //file_name="C:\\temp\\"+ file_name;
	    file_name=filePath+ file_name;
	    System.out.println("file name"+file_name);
		FileDataList.clear();
		this.file_name=file_name;
		this.store_code=store_code;
		this.phy_inv_id=phy_inv_id;
		remarks_count=0;
		setSite(true);
		//System.out.println("***************************File Starts********************" + file_name);
		ArrayList alParameters = new ArrayList();
		File file = new File(file_name);
		try {
			Scanner sc = new Scanner(file);
			int i=0;
			FileLine line;
		
				while (sc.hasNextLine()) {
					 line = processLine(sc.nextLine(), store_code);
				if (line == null) {
					line= new FileLine();
					line.setRemarks("Data in wrong format");
					remarks_count++;
					FileDataList.add(line);
					break;
				}
				FileDataList.add(line);
				//System.out.println(line.batchId+line.binLocation+line.expiryDate+line.itemCode+line.itemName+line.itemQuantity+line.remarks+line.storeCode+line.tradeId);
				
			}

			//System.out.println("***************************File Ends******************** ");
			return true;
		} catch (FileNotFoundException e) {
			return false;
		}
	}
	

	public ArrayList getFileDataList() {
		System.out.println("File"+ FileDataList);
		return FileDataList;
	}

	public void setFileDataList(ArrayList fileDataList) {
		FileDataList = fileDataList;
	}
	
	public boolean isSite() {
		return site;
	}
	public void setSite(boolean site) {
		this.site = site;
	}
	
	public int getRemarks_count() {
		return remarks_count;
	}
	public void setRemarks_count(int remarks_count) {
		this.remarks_count = remarks_count;
	}
	private FileLine processLine(String line, String store_code) {

		String itemCode = "";
		String itemName = "";
		String batchId = "";
		String itemQuantity = "";
		String binLocation = "";
		String expiryDate = "";
		String tradeId = "";
		String dateFormat = "dd/mm/yyyy";

		String arr[] = line.split(",");
		FileLine processedLine = new FileLine();
		if (arr.length == 4) {
			batchId = arr[0];
			itemQuantity = arr[1];
			int i = Integer.parseInt(itemQuantity);
			if (i < 1) {
				processedLine.setRemarks("Error in batch quantity.");
				remarks_count++;
			}
			binLocation = arr[3];
			expiryDate = arr[0].substring(1, 9);
			expiryDate = expiryDate.substring(6) + "/" + expiryDate.substring(4, 6) + "/" + expiryDate.substring(0, 4);
			DateFormat sdf = new SimpleDateFormat(dateFormat);
			sdf.setLenient(false);
			try {
				sdf.parse(expiryDate);
			} catch (ParseException e) {
				processedLine.setRemarks("Error in expiry date.");
				remarks_count++;
			}
			if(!(isValidDate(expiryDate)))
			{
				processedLine.setRemarks("Error in expiry date.");
				remarks_count++;
			}
			if(processedLine.getRemarks()==null || processedLine.getRemarks()==""){
			ArrayList alParameters = new ArrayList();
			alParameters.add(batchId);
			alParameters.add(store_code);
			alParameters.add(binLocation);
			alParameters.add(expiryDate);
			alParameters.add(itemQuantity);
			ArrayList alParameter = new ArrayList();
			String result = getItemCodeforBatch(alParameters);
			if (result.equals("Batch ID not found.")
					|| result.equals("Batch ID and Expiry date not matched for an Item")
					|| result.equals("Bin Location not found") || result.equals("Incorrect Data")  ) {
				processedLine.setRemarks(result);
				remarks_count++;
			} 
			else 	if(result.startsWith("Phy Qty(") )
			{
				int k=result.indexOf("ITEM=");
				int l=result.indexOf("=")+1;
				processedLine.setRemarks(result.substring(0, k));
				result=result.substring(l);
				itemCode=result;
				alParameter.clear();
				alParameter.add(itemCode);
				alParameter.add(getLanguageId());
				itemName = getItemName(alParameter);
				alParameter.add(itemCode);
				//tradeId = getTradeId(alParameter);
//				int j =checkIfItemFoundInSelectedPhyInventoryID(itemCode,store_code);
//				if (j == 0) {
//					processedLine.setRemarks("Item not found in selected Physical Inventory ID");
					remarks_count++;
//				}
			}
			else {
				itemCode = result;
				alParameter.clear();
				alParameter.add(itemCode);
				alParameter.add(getLanguageId());
				itemName = getItemName(alParameter);
				alParameter.clear();
				alParameter.add(store_code);
				alParameter.add(itemCode);
				alParameter.add(batchId);
				alParameter.add(binLocation);
				alParameter.add(expiryDate);
				tradeId = getTradeId(alParameter);
				int j =checkIfItemFoundInSelectedPhyInventoryID(itemCode,store_code);
				if (j == 0) {
					processedLine.setRemarks("Item not found in selected Physical Inventory ID");
					remarks_count++;
				}
			}

			processedLine.setItemCode(itemCode);
			processedLine.setItemName(itemName);
			processedLine.setBatchId(batchId);
			processedLine.setItemQuantity(itemQuantity);
			processedLine.setBinLocation(binLocation);
			processedLine.setExpiryDate(expiryDate);
			processedLine.setStoreCode(store_code);
			processedLine.setTradeId(tradeId);
			return processedLine;
		}
			else
			{
				processedLine.setBatchId(batchId);
				processedLine.setItemQuantity(itemQuantity);
				processedLine.setBinLocation(binLocation);
				processedLine.setExpiryDate(expiryDate);
				processedLine.setStoreCode(store_code);
				return processedLine;
			}
		}
		return null;
	}

	private String getItemName(ArrayList alParameter) {
		try {
			String itemName = null;
			if (alParameter.get(0) != null) {
				String sql = "select long_desc from MM_ITEM_LANG_VW where item_code=?  and language_id=?";
				itemName = (String) fetchRecord(sql, alParameter).get("LONG_DESC");
			}
			if (itemName == null) {
				itemName = " ";
			}
			return itemName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	private String getItemCodeforBatch(ArrayList alParameters) {
		String result = "";
		ArrayList <HashMap> queryResult;
		String batch_id = alParameters.get(0).toString();
		String store_code = alParameters.get(1).toString();
		String bin_location = alParameters.get(2).toString();
		String expiry_date = alParameters.get(3).toString();
		String item_quantity =alParameters.get(4).toString();
		alParameters.remove(4);
		alParameters.remove(3);
		alParameters.remove(2);
		String sql = "select item_code,expiry_date_or_receipt_date,bin_location_code,committed_qty,qty_on_hand from ST_ITEM_BATCH where batch_id=? AND store_code=? ";
		try {
			queryResult = fetchRecords(sql, alParameters);
			if (queryResult == null || queryResult.size() == 0) {
				return "Batch ID not found.";
			} else {
				int bin = 0;
				for (HashMap k : queryResult) {
					String result_bin_location = (String) k.get("BIN_LOCATION_CODE");
					String result_expiry_date = ((String) k.get("EXPIRY_DATE_OR_RECEIPT_DATE")).substring(0, 10);
					result_expiry_date = result_expiry_date.substring(8) + "/" + result_expiry_date.substring(5, 7)+ "/" + result_expiry_date.substring(0, 4);
					if (result_bin_location.equals(bin_location)) {
						bin++;
						if (result_expiry_date.equals(expiry_date)) {
							if((String) k.get("COMMITTED_QTY")!=null )
							{
								String s=(String) k.get("COMMITTED_QTY");
								int com_qty=Integer.parseInt(s);
								int item_qty=Integer.parseInt(item_quantity);
								if(item_qty<com_qty)
								{
									String remark="Phy Qty("+item_quantity+") can't be less than Commit Qty("+s+") QOH: "+(String) k.get("QTY_ON_HAND")+"ITEM=";
									String item_code=(String) k.get("ITEM_CODE");
									return remark+item_code;
								}
							}
							return (String) k.get("ITEM_CODE");
						}

					}
				}
				if (bin == 0) {
					return "Bin Location not found";
				} else {
					return "Batch ID and Expiry date not matched for an Item";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	private String getTradeId(ArrayList alParameters) {
		String result = "";
		try {
			String Sql="SELECT trade_id FROM st_item_batch WHERE store_code = ? AND item_code = ? AND batch_id = ? AND bin_location_code = ? AND expiry_date_or_receipt_date = TO_DATE (?, 'dd/mm/yyyy')";
			result = (String) fetchRecord(Sql, alParameters).get("TRADE_ID");
			if (result == null)
				result = "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private HashMap insertByFile() {
		HashMap hashmap = new HashMap();
		ArrayList arraylist = new ArrayList();
		ArrayList alModifyData = new ArrayList();
		ArrayList alModifyHdr = new ArrayList();
		HashMap hashmap1 = new HashMap();

		hashmap.put("properties", getProperties());

		hashmap.put("DeleteData", getDelListForFile());
		hashmap1.put("DeleteDtlSQL", getStRepositoryValue("SQL_ST_PHYSICAL_INVENTORY_ENTRY_DELETE_PHY_INV_DTL"));
        System.out.print("(this.entry_completed_yn"+this.entry_completed_yn);
		alModifyData.add(this.entry_completed_yn);
		alModifyData.add(getLoginById());
		alModifyData.add(getLoginAtWsNo()); 
		alModifyData.add(getLoginFacilityId());
		alModifyData.add(getLoginFacilityId());
		alModifyData.add(this.phy_inv_id);
		alModifyData.add(this.store_code);
		hashmap.put("ModifyData", alModifyData);
		hashmap1.put("ModifyDtlSQL","UPDATE ST_PHY_INV_PARAM SET ENTRY_COMPLETED_YN = ?, MODIFIED_BY_ID = ? , MODIFIED_DATE = SYSDATE , MODIFIED_AT_WS_NO = ? , MODIFIED_FACILITY_ID = ? WHERE FACILITY_ID = ? AND PHY_INV_ID = ? AND FM_STORE_CODE = ? "); 

		arraylist = getArrayListForFile();
		hashmap.put("InsertData", arraylist);
		hashmap1.put("InsertDtlSQL","INSERT INTO ST_PHY_INV_DTL(FACILITY_ID,PHY_INV_ID,STORE_CODE,ITEM_CODE,BATCH_ID,STOCK_ITEM_YN,ITEM_QTY,EXPIRY_DATE_OR_RECEIPT_DATE,BIN_LOCATION_CODE,TRADE_ID,ENTRY_COMPLETED_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,?,?,?,'Y',?,TO_DATE(?,'dd/mm/yyyy'),?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
		
		alModifyHdr=getHeaderData();
		hashmap.put("ModifyHDRData", alModifyHdr);
		hashmap1.put("ModifyHDRSQL", getStRepositoryValue("SQL_ST_PHYSICAL_INVENTORY_HDR_UPDATE"));

		return dipatchingMethodCall(hashmap, hashmap1);

	}
	
	public ArrayList getDelListForFile()  
	{
	ArrayList alRecords_List = new ArrayList();
	ArrayList fileData = getFileDataList();
	try{
		for (int i = 0; i < fileData.size(); i++) {
			FileLine Line = (FileLine) fileData.get(i);
			ArrayList alParameters_CodeList = new ArrayList();
			alParameters_CodeList.add(getLoginFacilityId());
			alParameters_CodeList.add(this.phy_inv_id);
			alParameters_CodeList.add(this.store_code);
			alParameters_CodeList.add(Line.getItemCode());
			alRecords_List.add(alParameters_CodeList);
		}
	}catch(Exception exception){
	   exception.printStackTrace();
	}
   return alRecords_List;
}

	public ArrayList getArrayListForFile() {
		ArrayList insert = new ArrayList();

		ArrayList fileData = getFileDataList();
		ArrayList batchId  =  new ArrayList<String>();
		try {
			for (int i = 0; i < fileData.size(); i++) {
				FileLine Line = (FileLine) fileData.get(i);
				ArrayList insertData = new ArrayList();
				if (Line.getRemarks().equals("")) {
					insertData.add(login_facility_id);
					insertData.add(this.phy_inv_id);
					insertData.add(this.store_code);
					insertData.add(Line.getItemCode());
					insertData.add(Line.getBatchId());
					insertData.add(Line.getItemQuantity());
					insertData.add(Line.getExpiryDate());
					insertData.add(Line.getBinLocation());
					insertData.add(Line.getTradeId());
					insertData.add(this.entry_completed_yn);
					insertData.add(getLoginById());
					insertData.add(getLoginAtWsNo());
					insertData.add(getLoginFacilityId());
					insertData.add(getLoginById());
					insertData.add(getLoginAtWsNo());
					insertData.add(getLoginFacilityId());
					insert.add(insertData);
					batchId.add(Line.getBatchId());
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		if(entry_completed_yn.equals("Y"))
		{
			ArrayList all=getArrayListAllBatches();
			insert=merge(all,insert);
		}
		return insert;
	}
	
	public ArrayList getHeaderData()
	{
	ArrayList alRecords_List = new ArrayList();
	ArrayList fileData = getFileDataList();
	try{
		for (int i = 0; i < fileData.size(); i++) {
			FileLine Line = (FileLine) fileData.get(i);
			ArrayList alParameters_CodeList = new ArrayList();
			alParameters_CodeList.add(getLoginById());
			alParameters_CodeList.add(getLoginAtWsNo());
			alParameters_CodeList.add(getLoginFacilityId());
			alParameters_CodeList.add(getLoginFacilityId());
			alParameters_CodeList.add(this.phy_inv_id);
			alParameters_CodeList.add(this.store_code);
			alParameters_CodeList.add(Line.getItemCode());
			alRecords_List.add(alParameters_CodeList);
		}
	}catch(Exception exception){
	   exception.printStackTrace();
	}
   return alRecords_List;
}

	public String getPhy_inv_id() {
		return phy_inv_id;
	}
	public String getStore_code() {
		return store_code;
	}
	public String getEntry_completed_yn() {
		return entry_completed_yn;
	}
	private int  checkIfItemFoundInSelectedPhyInventoryID(String itemCode, String store_code2) {
		try{
			ArrayList alParameters = new ArrayList();
			alParameters.add(this.phy_inv_id);
			alParameters.add(itemCode);
			alParameters.add(store_code2);
                        String sql = "select count(*) COUNT from ST_ITEM_BATCH  where phy_inv_id=? and item_code=? and store_code=?";
			String str=(String)fetchRecord(sql, alParameters).get("COUNT");
			int i=-1;
			if(str!=null)
			 i =Integer.parseInt(str);
			return i;
		}
		 catch (Exception e) {
				e.printStackTrace();
				return -1;
			}
	}

	static boolean isValidDate(String date) {
		int d, m, y;
		d = Integer.parseInt(date.substring(0, 2));
		m = Integer.parseInt(date.substring(3, 5));
		y = Integer.parseInt(date.substring(6));
		int MAX_VALID_YR = 9999;
		int MIN_VALID_YR = 1800;
		if (y > MAX_VALID_YR || y < MIN_VALID_YR)
			return false;
		if (m < 1 || m > 12)
			return false;
		if (d < 1 || d > 31)
			return false;

		if (m == 2) {
			if (isLeap(y))
				return (d <= 29);
			else
				return (d <= 28);
		}

		if (m == 4 || m == 6 || m == 9 || m == 11)
			return (d <= 30);

		return true;
	}

	static boolean isLeap(int year) {
		return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
	}
	
	private ArrayList merge(ArrayList all, ArrayList insert) {
		 for (int i=0;i<insert.size();i++) {
			 ArrayList insertList = (ArrayList) insert.get(i);
	            boolean found = false;
	            for (int j=0;j<all.size();j++) {
	            	 ArrayList allList = (ArrayList) all.get(j);
	                if (insertList.get(3).equals(allList.get(3)) &&
	                    insertList.get(4).equals(allList.get(4)) &&
	                    insertList.get(6).equals(allList.get(6)) &&
	                    insertList.get(7).equals(allList.get(7))) {
	                	
	                    allList.set(5, insertList.get(5));
	                    found = true;
	                    break;
	                }
	            }
	        }
	        return all;
	}
	private ArrayList getArrayListAllBatches() {
		ArrayList all=new ArrayList();
		ArrayList alRecords=new ArrayList();
		loadDetailPageFile();
		System.out.println(alDtlRecords);
		for(int i=0;i<alDtlRecords.size();i++)
		{	
			ArrayList temp =  (ArrayList) alDtlRecords.get(i);
			ArrayList  alParameters=new ArrayList();
			alParameters.add(temp.get(4));
			alParameters.add(temp.get(3));
			String sql="SELECT ITEM_CODE,BATCH_ID,BIN_LOCATION_CODE,to_char(expiry_date_or_receipt_date,'dd/mm/yyyy') EXPIRY_DATE_OR_RECEIPT_DATE,TRADE_ID  FROM ST_ITEM_BATCH  WHERE STORE_CODE=? AND ITEM_CODE=?";
			
			try {
				alRecords = fetchRecords(sql,alParameters);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int j=0;j<alRecords.size();j++){
				
				ArrayList insertData=new ArrayList();
				HashMap record=(HashMap)alRecords.get(j);
				insertData.add(login_facility_id);
				insertData.add(this.phy_inv_id);
				insertData.add(this.store_code);
				insertData.add(record.get( "ITEM_CODE"));
				insertData.add(record.get( "BATCH_ID"));
				insertData.add(0);
				insertData.add(record.get( "EXPIRY_DATE_OR_RECEIPT_DATE"));
				insertData.add(record.get( "BIN_LOCATION_CODE"));
				insertData.add( record.get( "TRADE_ID"));
				insertData.add(this.entry_completed_yn);
				insertData.add(getLoginById());
				insertData.add(getLoginAtWsNo());
				insertData.add(getLoginFacilityId());
				insertData.add(getLoginById());
				insertData.add(getLoginAtWsNo());
				insertData.add(getLoginFacilityId());
				all.add(insertData);
			}
		}
		return all;
	}
	public void loadDetailPageFile(){
		ArrayList alParameters	=	new ArrayList();
		HashMap		hmTemp		=	new HashMap();
		String sql ="";
		alDtlRecords	=	new ArrayList();
		
		alParameters.add(this.phy_inv_id);
		alParameters.add(this.store_code);
		alParameters.add("");
		alParameters.add(getLoginFacilityId());
		alParameters.add(getLanguageId());
        
		sql = " SELECT DISTINCT A.PHY_INV_ID PHY_INV_ID, B.SHORT_DESC STORE_DESC,C.SHORT_DESC ITEM_DESC, A.STORE_CODE STORE_CODE, A.ITEM_CODE ITEM_CODE, NVL (D.ENTRY_COMPLETED_YN, 'NU') STA_CHK,COUNT(E.ITEM_CODE) COUNT, SUM(D.ITEM_QTY)SUM_QTY, AM.SHORT_DESC GEN_UOM_DESC  FROM ST_PHY_INV_HDR A, MM_STORE_LANG_VW B,  MM_ITEM_LANG_VW C, ST_PHY_INV_DTL D,  ST_ITEM_BATCH E, AM_UOM_LANG_VW AM  WHERE A.PHY_INV_ID = NVL (?, A.PHY_INV_ID)  AND A.STORE_CODE = NVL (?, A.STORE_CODE)  AND A.ITEM_CODE = NVL (?, A.ITEM_CODE)  AND A.FACILITY_ID = ?  AND A.PHY_INV_ID = D.PHY_INV_ID(+)  AND A.STORE_CODE = D.STORE_CODE(+)  AND A.ITEM_CODE = D.ITEM_CODE(+)  AND A.ITEM_CODE = E.ITEM_CODE(+)  AND A.STORE_CODE = E.STORE_CODE(+)  AND A.ITEM_CODE = C.ITEM_CODE  AND A.STORE_CODE = B.STORE_CODE  AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND C.GEN_UOM_CODE = AM.UOM_CODE AND C.LANGUAGE_ID = AM.LANGUAGE_ID GROUP BY A.PHY_INV_ID, B.SHORT_DESC,  C.SHORT_DESC, A.STORE_CODE,A.ITEM_CODE, NVL (D.ENTRY_COMPLETED_YN, 'NU'),AM.SHORT_DESC  ORDER BY 3 ";
    
		try{
			ArrayList alRecords = fetchRecords(sql,alParameters);
			for(int i=0;i<alRecords.size();i++){
				hmTemp	= new HashMap();
				hmTemp	=	(HashMap)alRecords.get(i);
				ArrayList record=new ArrayList();
		        record.add(hmTemp.get("ITEM_DESC"));
		        record.add(hmTemp.get("STORE_DESC"));
		        record.add(hmTemp.get("PHY_INV_ID"));
		        record.add(hmTemp.get("ITEM_CODE"));
		        record.add(hmTemp.get("STORE_CODE"));
		        alDtlRecords.add(record);
		        
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//Added for TH-KW-CRF-0083 end
} 
