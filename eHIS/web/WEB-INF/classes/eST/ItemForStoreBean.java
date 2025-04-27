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
24/05/2017		IN063603			Badmavathi B								GHL-CRF-0456
31/10/2019      IN:071344           B Haribabu   15/10/2019      Manickam        GHL-CRF-0609  
31/12/2020		TFS-8224           Prabha      31/12/2020		Manickam	  MMS-DM-CRF-0177
13/10/2021		TFS-24348			Shazana		13/10/2021		Manickam		MO-CRF-20172
---------------------------------------------------------------------------------------------------------
*/ 
 package eST;

import eST.ItemForStore.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import eCommon.SingleTableHandler.*;

//import javax.rmi.PortableRemoteObject;
//import javax.naming.InitialContext;
import eCommon.Common.CommonRepository;
//port eST.ItemForStoreDetail;
import eST.Common.StRepository;
import eST.Common.StAdapter;
//import eST.Common.StTransaction;

public class ItemForStoreBean extends StAdapter implements Serializable {

	private String store_code;
	private String selected_store_code;
	private String selected_bin_location_code;
	private String oldStock_item_yn;
	private String getDefaultRequest = "S";
	private String phy_inv_type;
	private String phy_inv_count_per_year;
	//private String language;
	
	private boolean searched;
	
	private boolean pre_alloc_appl=false; //MMMS-DM-CRF-0177
		
	private ItemForStoreDetail itemForStoreDetail;

	java.util.ArrayList itemStoreKeys;
	java.util.ArrayList duplicateValues;
	java.util.ArrayList checkedItemStore;
	java.util.HashMap hmItemStore;
	//java.util.HashMap phyinvresultMap;

	public ItemForStoreBean() {
		itemStoreKeys = new java.util.ArrayList();
		checkedItemStore = new java.util.ArrayList();
		hmItemStore = new java.util.HashMap();
		
	}

/*	public void setLanguageId(String language)
	{
		this.language=language;
	}

	public String getLanguageId()
	{
		return language;
	}
	*/
	public void setDuplicateValues(java.util.ArrayList duplicateValues) {
		this.duplicateValues = duplicateValues;
	}

	public java.util.ArrayList getDuplicateValues() {
		if (duplicateValues == null) {
			return null;
		}
		java.util.ArrayList existingValues = new java.util.ArrayList (duplicateValues.size());
		java.util.ArrayList tempDuplicate;
		for (int i=0;i<duplicateValues.size();i++) {
			tempDuplicate = (java.util.ArrayList) duplicateValues.get(i);
			if (tempDuplicate != null && tempDuplicate.size()==2) {
				existingValues.add(tempDuplicate.get(0)+"-"+tempDuplicate.get(1));
			}
		}
		duplicateValues = null;
		tempDuplicate = null;
		return existingValues;
	}

	public void setStore_code(String store_code) {
		this.store_code = store_code;
	}

	public String getStore_code() {
		return this.store_code;
	}
	public void setPhyinv_type(String phy_inv_type){
		this.phy_inv_type = phy_inv_type;
	}
	public String getPhyinv_type(){
		
		return phy_inv_type;
	}
	
	public void setPhycountper_year(String phy_inv_count_per_year)
	{
		this.phy_inv_count_per_year=phy_inv_count_per_year;
	}
	public String getPhycountper_year()
	{
		return phy_inv_count_per_year;
	}


	public void setSelected_store_code(String selected_store_code) {
		this.selected_store_code = selected_store_code;
	}

	public String getSelected_store_code() {
		return this.selected_store_code;
	}

	public void setSelected_bin_location_code(String selected_bin_location_code) {
		this.selected_bin_location_code = selected_bin_location_code;
	}

	public String getSelected_bin_location_code() {
		return this.selected_bin_location_code;
	}

	//code added for Request Generate Stage
	public String getRequestGenStgList() {
		
        return getStaticListOptionTag("S,By Stock Level;O,By Order;D,By Dispense;A,By Administration;N,By Manual",getDefaultRequest);
    }

	//code added for Request UOM Display 
	
	public ArrayList getPur_uom_code_List(String parameters,String item_code) throws Exception{
		
		String chkParameters[] = {parameters,getLanguageId(),parameters,getLanguageId(),parameters,getLanguageId(),item_code};
		ArrayList result = new ArrayList();
		result = fetchRecords(getStRepositoryValue("SQL_ST_EQVL_UOM_SELECT1"),chkParameters);
		return result;
	}

	public String getRequest_uom_code_List(String request_uom,String defaultValue,String item_code){
		String bindvariables[] = {request_uom,getLanguageId(),request_uom,getLanguageId(),request_uom,getLanguageId(),item_code};
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_EQVL_UOM_SELECT1"),bindvariables),defaultValue);
	}
	
	public String getIssue_uom_code_List(String issue_uom,String defaultValue,String item_code){
		String bindvariables[] = {issue_uom,getLanguageId(),issue_uom,getLanguageId(),issue_uom,getLanguageId(),item_code};
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_EQVL_UOM_SELECT1"),bindvariables),defaultValue);
	}


	
	

	
	public String getStores() {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(getLanguageId());
		alOptionValues = getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_SELECT_LIST"), alParam);
		optionValues = getListOptionTag(alOptionValues, getSelected_store_code());
		alOptionValues = null;
		return optionValues;
	}	

// Added on 11/10/2005
		public String getDfltBinLocation(String store_code) {

		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(store_code);
		alParam.add(getLanguageId());
		alOptionValues = getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_MM_BIN_LOCATION_SELECT_LIST"), alParam);
		optionValues = getListOptionTag(alOptionValues, getSelected_bin_location_code());
		alOptionValues = null;
		return optionValues;
	}	

	public void setSearched(boolean  searched) {
		this.searched = searched;
	}

	public boolean isSearched() {
		return searched;
	}
 
	//Added for MMS-DM-CRF-0177
	
	public boolean getPreAllocAppl() {
	      return pre_alloc_appl;
	}
	public void setPreAllocAppl(boolean pre_alloc_appl) {
	      this.pre_alloc_appl = pre_alloc_appl;
	}
	  
	//Added for MMS-DM-CRF-0177
	  
	public String getSelectedBinLocations(String store_code,String item_code) {

		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(store_code);
		alParam.add(item_code);
		alParam.add(getLanguageId());
		alParam.add(store_code);
		alParam.add(getLanguageId());
		alOptionValues = getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_STORE_BIN_LOCN_SELECT_MODIFY_LIST"), alParam);
		optionValues = getListOptionTag(alOptionValues, getSelected_bin_location_code());
		alOptionValues = null;

		
		return optionValues;
	}	

	public java.util.ArrayList getItemStoreKeys() {
		return this.itemStoreKeys;
	}

	public java.util.HashMap getHmItemStore() {
		return this.hmItemStore;
	}

	public void clear() {
		if (checkedItemStore!= null) {
			checkedItemStore.clear();
		}
		if (itemStoreKeys!= null) {
			itemStoreKeys.clear();
		}
		if (hmItemStore != null) {
			hmItemStore.clear();
		}
		itemForStoreDetail = null;
		searched=false;
		getDefaultRequest  = "S";
	}

	public ArrayList selectInvType(String item_code) throws Exception{
		String chkParameters[] = {item_code};
		ArrayList result = new ArrayList();
		result = fetchRecords(getStRepositoryValue("SQL_ST_ITEM_STORE_AND_ST_ITEM_SELECT"),chkParameters);
		return result;
	}

public ArrayList selectUOMCode(String item_code) throws Exception{
		String chkParameters[] = {item_code};
		ArrayList result = new ArrayList();
		result = fetchRecords(getStRepositoryValue("SQL_ST_ITEM_STORE_UOM_CODE_SELECT"),chkParameters);
		return result;
	}


	public HashMap validate() {
		boolean result = true;
		HashMap resultMap = new HashMap();
		resultMap.put("result", new Boolean(result));
		resultMap.put("message", "success");
		if (getMode().equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			return resultMap;
		}
		if ((oldStock_item_yn.equals("Y")) && (itemForStoreDetail.getStock_item_yn().equals("N"))) {
			Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet resultSet = null;
			String qty_on_hand = "";
			String phy_inv_id = "";
			String message = "success";
			try {
				connection = getConnection();
				pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_ITEM_BATCH_VALIDATE_SELECT"));
				pstmt.setString(1, itemForStoreDetail.getStore_code());
				pstmt.setString(2, itemForStoreDetail.getItem_code());
				resultSet = pstmt.executeQuery();
				if(resultSet != null && resultSet.next()) {
					qty_on_hand = resultSet.getString("qty_on_hand");
					phy_inv_id = resultSet.getString("phy_inv_id");
					result = true;
				}
				if (result) {
					if ((qty_on_hand != null) && (Integer.parseInt(qty_on_hand.trim())) >0) {
						result = false;
						message = "QOH_CANNOT_CHANGE_STOCK_ITEM";
					}
					if ((phy_inv_id != null )&& (phy_inv_id.trim().length())>0) {
						result = false;
						message = "PHY_INV_CANT_CHANGE_STK_ITEM";
					}
					resultMap.put("result", new Boolean(result));
					resultMap.put("message", getSTMessage(getLanguageId(),message,"ST") ) ;
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
	

	public java.util.HashMap insert() {
		HashMap hmResult = new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap = new HashMap();
		//ArrayList alInsertData = new ArrayList();
		ArrayList alWhereData = new ArrayList();
		//ArrayList duplicateCodes;

		ItemForStoreDetail itemStoreDetail;
		HashMap alData			= new HashMap();
		
		hmResult.put("result", new Boolean(false));
		
		for (int index=0;index<checkedItemStore.size();index++) {
			if((checkedItemStore.get(index) == null) || (checkedItemStore.get(index).equals(""))) 
					continue;
			itemStoreDetail = (ItemForStoreDetail) hmItemStore.get(checkedItemStore.get(index));
			
			HashMap datas			 = new HashMap();
			
			datas.put("store_code" , itemStoreDetail.getStore_code());
			datas.put("item_code" ,itemStoreDetail.getItem_code());
			datas.put("bin_location_code" ,checkForNull(itemStoreDetail.getBin_location_code(),""));
			datas.put("stock_yn" , checkForNull(itemStoreDetail.getStock_item_yn(),""));
			datas.put("min_stock_qty",checkForNull(itemStoreDetail.getMin_stock_qty(),""));
			datas.put("max_stock_qty" ,checkForNull(itemStoreDetail.getMax_stock_qty(),""));
			datas.put("reorder_level",checkForNull(itemStoreDetail.getReorder_level(),""));
			datas.put("reorder_freq_days",checkForNull(itemStoreDetail.getReorder_freq_days(),""));
			datas.put("getlead_days" ,checkForNull(itemStoreDetail.getLead_days(),""));
			datas.put("min_stock_days",checkForNull(itemStoreDetail.getMin_stock_days(),""));
			datas.put("min_percentage" , checkForNull(itemStoreDetail.getMin_stock_percentage(),""));
			datas.put("log_in_id",login_by_id);
			datas.put("login_at_ws_no",login_at_ws_no);
			datas.put("login_facility_id",login_facility_id);
			//code for request generate stage
			datas.put("req_gen_stage",itemStoreDetail.getRequestGenStage());
			datas.put("req_uom" ,itemStoreDetail.getRequestUOM());
			datas.put("get_issue_uom",itemStoreDetail.getIssueUOM());
			datas.put("reorder_qty",itemStoreDetail.getReorderqty());
			//added by jagadeesh on 20/10/2004 

			datas.put("phy_inv_type", itemStoreDetail.getPhyinv_type());
			datas.put("phy_inv_count_per_year", itemStoreDetail.getPhycountper_year());

			datas.put("sales_allowed_yn",checkForNull(itemStoreDetail.getSales_allowed_yn(),""));//Added for GHL-CRF-0456
			datas.put("consumption_allowed_yn",checkForNull(itemStoreDetail.getConsumption_allowed_yn(),""));//Added for GHL-CRF-0456
			datas.put("near_expiry_appl",checkForNull(itemStoreDetail.getNearExpiryAppl(),""));
			datas.put("durn_value",checkForNull(itemStoreDetail.getDurnValue(),""));
			datas.put("durn_type",checkForNull(itemStoreDetail.getDurnType(),""));
			datas.put("durn_value_in_days",checkForNull(itemStoreDetail.getDurnValueInDays(),""));
			datas.put("no_of_days" , checkForNull(itemStoreDetail.getNo_of_days(),""));//MO-CRF-20172   
			  
			alData.put(index+"",datas);	

			

			ArrayList duplicateValue = new ArrayList();
			duplicateValue.add(itemStoreDetail.getStore_code());
			duplicateValue.add(itemStoreDetail.getItem_code());
			alWhereData.add(duplicateValue);
		}

		hmSQLMap.put("SQL_ST_ITEM_STORE_INSERT", StRepository.getStKeyValue("SQL_ST_ITEM_STORE_INSERT")); 
		hmSQLMap.put("SQL_ST_ITEM_STORE_COUNT", StRepository.getStKeyValue("SQL_ST_ITEM_STORE_COUNT")); 
		hmSQLMap.put("SQL_ST_ITEM_STORE_BIN_LOCN_COUNT" , StRepository.getStKeyValue("SQL_ST_ITEM_STORE_BIN_LOCN_COUNT")); 
		hmSQLMap.put("SQL_ST_ITEM_STORE_BIN_LOCN_INSERT" , StRepository.getStKeyValue("SQL_ST_ITEM_STORE_BIN_LOCN_INSERT")); 
		hmTableData.put("properties",getProperties());
		hmTableData.put("InsertData",alData);
		hmTableData.put("WhereData",alWhereData);
		
		//code added for new EJB(ItemStoreBeanManager) on 30/7/2004
		
//ItemForStoreHome	itemForStoreHome		= null ;
		ItemForStoreRemote	itemForStoreRemote		= null ;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {
			/*InitialContext context = new InitialContext() ;

			Object object = context.lookup( getStRepositoryValue("JNDI_ST_ITEM_FOR_STORE") ) ;

			itemForStoreHome		  = (ItemForStoreHome) PortableRemoteObject.narrow( object, ItemForStoreHome.class ) ;
			itemForStoreRemote		  = itemForStoreHome.create() ;
				hmResult = itemForStoreRemote.insert( hmTableData, hmSQLMap ) ;*/

				
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_ITEM_FOR_STORE"),ItemForStoreHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = hmTableData;
				argArray[1] = hmSQLMap;

				
				Class [] paramArray = new Class[2];
				paramArray[0] = hmTableData.getClass(); 
				paramArray[1] = hmSQLMap.getClass();

				 hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			
			if( ((Boolean) hmResult.get("result")).booleanValue() )	
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get("msgid" ),"ST") ) ;
			else if( hmResult.get("msgid")!=null  )
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get("msgid" ),"ST") ) ;
			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
		} 
		catch(Exception exception) {
			hmResult.put( "message", exception.getMessage()) ;
			exception.printStackTrace() ;
		} 
		finally {
			try {
				if( itemForStoreRemote != null )
					itemForStoreRemote.remove() ;
			}
			catch( Exception exception) {
				hmResult.put( "message", exception.toString()) ;
			}
		}

		//code ended....
		
		return hmResult;
	}

	public java.util.HashMap modify() {
		HashMap hmResult = new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap	  alModifyData	= new HashMap();
		HashMap hmSQLMap = new HashMap();
		
		hmResult.put("result", new Boolean(false));
		
			HashMap datas			 = new HashMap();
			
			datas.put("store_code" , itemForStoreDetail.getStore_code());
			datas.put("item_code" ,itemForStoreDetail.getItem_code());
			datas.put("bin_location_code" ,checkForNull(itemForStoreDetail.getBin_location_code(),""));
			datas.put("stock_yn" , checkForNull(itemForStoreDetail.getStock_item_yn(),""));
			datas.put("min_stock_qty",checkForNull(itemForStoreDetail.getMin_stock_qty(),""));
			datas.put("max_stock_qty" ,checkForNull(itemForStoreDetail.getMax_stock_qty(),""));
			datas.put("reorder_level",checkForNull(itemForStoreDetail.getReorder_level(),""));
			datas.put("reorder_freq_days",checkForNull(itemForStoreDetail.getReorder_freq_days(),""));
			datas.put("getlead_days" ,checkForNull(itemForStoreDetail.getLead_days(),""));
			datas.put("min_stock_days",checkForNull(itemForStoreDetail.getMin_stock_days(),""));
			datas.put("min_percentage" , checkForNull(itemForStoreDetail.getMin_stock_percentage(),""));
			datas.put("log_in_id",login_by_id);
			datas.put("login_at_ws_no",login_at_ws_no);
			datas.put("login_facility_id",login_facility_id);
			//code for request generate stage
			datas.put("req_gen_stage",itemForStoreDetail.getRequestGenStage());
			datas.put("req_uom" ,itemForStoreDetail.getRequestUOM());
			datas.put("get_issue_uom",itemForStoreDetail.getIssueUOM());
            
			// added on 16/10/2004 
			datas.put("get_phy_inv_type",itemForStoreDetail.getPhyinv_type());
			datas.put("get_phy_inv_count_per_year",itemForStoreDetail.getPhycountper_year());
			datas.put("reorder_qty",itemForStoreDetail.getReorderqty());
			
			if (itemForStoreDetail.getEff_status()==null || (itemForStoreDetail.getEff_status()!=null && (itemForStoreDetail.getEff_status().equals("")))) {
				datas.put("eff_status","D");
			}
			else
			{
				datas.put("eff_status","E");
			}
	//Added for GHL-CRF-0456 starts
			if (itemForStoreDetail.getSales_allowed_yn()==null || (itemForStoreDetail.getSales_allowed_yn()!=null && (itemForStoreDetail.getSales_allowed_yn().equals("")))) {
				datas.put("sales_allowed_yn","N");
			}else{
				datas.put("sales_allowed_yn",itemForStoreDetail.getSales_allowed_yn());
			}
			if (itemForStoreDetail.getConsumption_allowed_yn()==null || (itemForStoreDetail.getConsumption_allowed_yn()!=null && (itemForStoreDetail.getConsumption_allowed_yn().equals("")))) {
				datas.put("consumption_allowed_yn","N");
			}else{
				datas.put("consumption_allowed_yn",itemForStoreDetail.getConsumption_allowed_yn());
			}
	//Added for GHL-CRF-0456 ends
			
			//Added for MMS-DM-CRF-0177 - Start
			if (itemForStoreDetail.getNearExpiryAppl()==null || (itemForStoreDetail.getNearExpiryAppl()!=null && (itemForStoreDetail.getNearExpiryAppl().equals("")))) {
				datas.put("near_expiry_appl","");
			}else{
				datas.put("near_expiry_appl",itemForStoreDetail.getNearExpiryAppl());
			}
			
			if (itemForStoreDetail.getDurnValue()==null) {
				datas.put("durn_value","");
			}else{
				datas.put("durn_value",itemForStoreDetail.getDurnValue());
			}
			
			if (itemForStoreDetail.getDurnType()==null || (itemForStoreDetail.getDurnType()!=null && (itemForStoreDetail.getDurnType().equals("")))) {
				datas.put("durn_type","N");
			}else{
				datas.put("durn_type",itemForStoreDetail.getDurnType());
			}
			
			if (itemForStoreDetail.getDurnValueInDays()==null) {
				datas.put("durn_value_in_days","");
			}else{
				datas.put("durn_value_in_days",itemForStoreDetail.getDurnValueInDays());
			}
			//Added for MMS-DM-CRF-0177 - End
			//Added for MO-CRF-20172
			if(itemForStoreDetail.getNo_of_days()== null){
				datas.put("no_of_days", ""); 
			}else{
				datas.put("no_of_days" , checkForNull(itemForStoreDetail.getNo_of_days(),""));  
			}
			
			alModifyData.put("1",datas);	
			System.out.println("alModifyData: "+alModifyData);  
		

		hmSQLMap.put("SQL_ST_ITEM_STORE_UPDATE", StRepository.getStKeyValue("SQL_ST_ITEM_STORE_UPDATE")); 
		hmSQLMap.put("SQL_ST_ITEM_STORE_MODIFY_BIN_LOCN_COUNT", StRepository.getStKeyValue("SQL_ST_ITEM_STORE_MODIFY_BIN_LOCN_COUNT")); 
		hmSQLMap.put("SQL_ST_ITEM_STORE_BIN_LOCN_INSERT", StRepository.getStKeyValue("SQL_ST_ITEM_STORE_BIN_LOCN_INSERT")); 

		hmTableData.put("properties", getProperties());
		hmTableData.put("ModifyData", alModifyData	);

		
		//code added for new EJB(ItemStoreBeanManager) on 30/7/2004
		
		//ItemForStoreHome	itemForStoreHome		= null ;
		ItemForStoreRemote	itemForStoreRemote		= null ;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {
		/*	InitialContext context = new InitialContext() ;

			Object object = context.lookup( getStRepositoryValue("JNDI_ST_ITEM_FOR_STORE") ) ;

			itemForStoreHome		  = (ItemForStoreHome) PortableRemoteObject.narrow( object, ItemForStoreHome.class ) ;
			itemForStoreRemote		  = itemForStoreHome.create() ;
				hmResult = itemForStoreRemote.modify( hmTableData, hmSQLMap ) ;*/
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_ITEM_FOR_STORE"),ItemForStoreHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = hmTableData;
				argArray[1] = hmSQLMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = hmTableData.getClass(); 
				paramArray[1] = hmSQLMap.getClass();

				hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			if( ((Boolean) hmResult.get("result")).booleanValue() )	
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get("msgid" ),"ST") ) ;
			else if( hmResult.get("msgid")!=null  )
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get("msgid" ),"ST") ) ;
			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
		} 
		catch(Exception exception) {
			hmResult.put( "message", exception.getMessage()) ;
			exception.printStackTrace() ;
		} 
		finally {
			try {
				if( itemForStoreRemote != null )
					itemForStoreRemote.remove() ;
			}
			catch( Exception exception) {
				hmResult.put( "message", exception.toString()) ;
			}
		}

		//code ended....
	
		
		return hmResult;
	}

	public boolean isNonStockStore(String store_code) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		boolean result = false;
        String store_type_flag = "";
		String external_yn = "";
		try {
            connection = getConnection();
            pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_ITEM_STORE_TYPE_SELECT"));
            pstmt.setString(1, store_code);
            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
				store_type_flag = resultSet.getString("store_type_flag");
				external_yn = resultSet.getString("external_yn");
            }
			result = (store_type_flag.equals("N") || external_yn.equals("Y"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
        return result;
	}

	public boolean recordAlreadyExists(String store_code,String item_code) {
		boolean result = false;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		int count = -1;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_ITEM_STORE_COUNT"));
            pstmt.setString(1, store_code);
            pstmt.setString(2, item_code);
            resultSet = pstmt.executeQuery();
            if(resultSet != null && resultSet.next()) {
				count = resultSet.getInt("count");
            }
			if (count>0) {
				result = true;
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
            }catch(Exception es){
				es.printStackTrace();
            }
        }
		return result;
	}

	public void addSingleRecord(Hashtable dataTable) {
		String editing = (String) dataTable.get("editing");
		StringBuffer key = new StringBuffer();
		ItemForStoreDetail itemStoreDetail;
		key.append(dataTable.get("store_code"));
		key.append("-");
		key.append(dataTable.get("item_code"));
		if (editing.equals("2")) {
			itemStoreDetail = (ItemForStoreDetail) hmItemStore.get(key.toString());
		}
		else {
			itemStoreDetail = new ItemForStoreDetail();
			itemStoreKeys.add(key.toString());
		}
		itemStoreDetail.setAll(dataTable);
		hmItemStore.put(key.toString(), itemStoreDetail);
	}

	public void addMultipleRecord(Hashtable dataTable) {
		searched = true;
		java.sql.Connection connection = null;
		java.sql.PreparedStatement preparedStatement = null;
		java.sql.ResultSet resultSet = null;
		ItemForStoreDetail itemStoreDetail;

		String from_store_code = (String) dataTable.get("from_store_code");
		String to_store_code =(String) dataTable.get("to_store_code");
		String from_item_code = (String) dataTable.get("from_item_code");
		String to_item_code = (String) dataTable.get("to_item_code");
		String item_analysis_from_1 = (String) dataTable.get("m_item_analysis_from_1");
		String item_analysis_to_1 = (String) dataTable.get("m_item_analysis_to_1");
		String item_analysis_from_2 = (String) dataTable.get("m_item_analysis_from_2");
		String item_analysis_to_2 = (String) dataTable.get("m_item_analysis_to_2");
		String item_analysis_from_3 = (String) dataTable.get("m_item_analysis_from_3");
		String item_analysis_to_3 = (String) dataTable.get("m_item_analysis_to_3");
		String m_store_type_flag = (String) dataTable.get("m_stock_item_yn");

		String store_code, store_desc;
		String item_code, item_desc;
		String store_type_flag;
		String request_uom = "";
		String key = "";
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_MULTIPLE_SELECT")); 
			preparedStatement.setString(1, from_store_code.trim());
			preparedStatement.setString(2, to_store_code.trim());
			preparedStatement.setString(3, from_item_code.trim());
			preparedStatement.setString(4, to_item_code.trim());
			preparedStatement.setString(5, item_analysis_from_1.trim());
			preparedStatement.setString(6, item_analysis_to_1.trim());
			preparedStatement.setString(7, item_analysis_from_2.trim());
			preparedStatement.setString(8, item_analysis_to_2.trim());
			preparedStatement.setString(9, item_analysis_from_3.trim());
			preparedStatement.setString(10, item_analysis_to_3.trim());
			preparedStatement.setString(11, getLanguageId());

			resultSet = preparedStatement.executeQuery();

			HashMap hmRecord	=	null;


			while (resultSet.next()) {
				store_code = resultSet.getString("store_code");
				store_desc = resultSet.getString("store_desc");
				item_code = resultSet.getString("item_code");
				item_desc = resultSet.getString("item_desc");
				store_type_flag = resultSet.getString("store_type_flag");
				//code added on 20/10/2004 for phyinvtype and phy inv count per year by jagadeesh
				ArrayList alphyInvType =new ArrayList();
				alphyInvType = selectInvType(item_code);
				HashMap hmTemp = (HashMap)alphyInvType.get(0) ;
				String stPhyInvType = checkForNull((String)hmTemp.get("PHY_INV_TYPE"),"");
                String stPhyInvCount = checkForNull((String)hmTemp.get("PHY_INV_COUNT_PER_YEAR"),"");

			   //code added for Request UOM
				ArrayList UOMCode=new ArrayList();
				UOMCode=selectUOMCode(item_code);
				HashMap hmTemp1=(HashMap)UOMCode.get(0);
				request_uom =checkForNull((String)hmTemp1.get("GEN_UOM_CODE"),"");
				String issue_uom = checkForNull((String)hmTemp1.get("GEN_UOM_CODE"),"");
				String stock_it_yn="";
				//request_uom = resultSet.getString("stock_uom");
				key = store_code+"-"+item_code;

				if (!itemStoreKeys.contains(key)) {
					itemStoreDetail = new ItemForStoreDetail(store_code, store_desc, item_code, item_desc , request_uom);
					if (m_store_type_flag.equals("Y") && store_type_flag.equals("N")) {
						itemStoreDetail.setStock_item_yn("N");
						stock_it_yn="N";
					}
					else {
						itemStoreDetail.setStock_item_yn(m_store_type_flag);
						stock_it_yn=m_store_type_flag;
					}

                    dataTable.put("phy_inv_type",stPhyInvType);
                    dataTable.put("phy_inv_count_per_year",stPhyInvCount);
					 dataTable.put("request_uom",request_uom);
	                  dataTable.put("issue_uom",issue_uom);
						  if(stock_it_yn.equals("Y")){
			String [] alParameter	=	{getLanguageId(),store_code};
			hmRecord=fetchRecord("select a.BIN_LOCATION_CODE m_bin_location_code,a.short_desc m_bin_location_desc from MM_BIN_LOCATION_lang_vw a,  St_store b where a.BIN_LOCATION_CODE =b.DFLT_BIN_LOCATION_CODE and a.language_id=? and a.store_code=b.STORE_CODE and b.store_code=? ", alParameter);
			dataTable.put("m_bin_location_code",checkForNull((String)hmRecord.get("M_BIN_LOCATION_CODE"),""));
			dataTable.put("m_bin_location_desc",checkForNull((String)hmRecord.get("M_BIN_LOCATION_DESC"),""));
					  }else{
				dataTable.put("m_bin_location_code","");
				dataTable.put("m_bin_location_desc","");
					  }
					itemStoreDetail.setMutiple(dataTable);
					itemStoreKeys.add(key.toString());
					hmItemStore.put(key.toString(), itemStoreDetail);
				}
			}
		} 
		catch (Exception e )	{
			e.printStackTrace();
			} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		//itemStoreDetail.setAll(dataTable);
	}

	public int getQtyOnHand (String store_code, String item_code) throws Exception{
		String []stParameters		=	{store_code, item_code};
		HashMap hmRecord	=	null;		
		int QTY = 0;
		hmRecord	=	fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_STORE_QTY_ON_HAND"), stParameters);
		if(hmRecord.get("QTY_ON_HAND") != null) {
			try {
				QTY = Integer.parseInt((String)hmRecord.get("QTY_ON_HAND"));
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return QTY; 
	}

	public void loadData(String store_code, String item_code) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		itemForStoreDetail = new ItemForStoreDetail(store_code,item_code);
        try {
            connection = getConnection();
          //pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_ITEM_STORE_SELECT1"));
          //pstmt = connection.prepareStatement("SELECT B.short_desc	item_desc, A.bin_location_code bin_location_code, A.stock_item_yn, A.min_stk_qty, A.max_stk_qty, A.reorder_level, A.reorder_freq_days, A.lead_days,	A.min_stock_days, A.percent_min_stock,A.request_gen_stage,A.def_request_uom,A.def_issue_uom , a.eff_status,b.gen_uom_code,A.phy_inv_type phy_inv_type,A.phy_inv_count_per_year phy_inv_count_per_year,A.reorder_qty reorder_qty   FROM st_item_store A,	mm_item_lang_vw	B  WHERE store_code	= ?	AND	B.item_code	= ?	AND	B.item_code	= A.item_code AND B.language_id = ?");
            pstmt = connection.prepareStatement("SELECT b.short_desc item_desc, a.bin_location_code bin_location_code, a.stock_item_yn, a.min_stk_qty, a.max_stk_qty, a.reorder_level, a.reorder_freq_days, a.lead_days, a.min_stock_days, a.percent_min_stock, a.request_gen_stage, a.def_request_uom, a.def_issue_uom, a.eff_status, b.gen_uom_code, a.phy_inv_type phy_inv_type, a.phy_inv_count_per_year phy_inv_count_per_year, a.reorder_qty reorder_qty, a.sales_allowed_yn sales_allowed_yn, a.consumption_allowed_yn consumption_allowed_yn, C.AUTO_ROL_CALC_FLAG, a.near_expiry_appl near_expiry_appl , a.durn_value durn_value, a.durn_type durn_type, a.durn_value_in_days durn_value_in_days,NO_OF_DAYS FROM st_item_store a, mm_item_lang_vw b, st_store c WHERE a.store_code = ? AND b.item_code = ? AND b.item_code = a.item_code AND a.store_code = c.store_code AND b.language_id = ?"); //Modified for GHL-CRF-0456, modified for IN:071344 , near_expiry_appl, durn_type ,durn_value , durn_value_in_days added For MMS-DM-CRF-0177,Modified for MO-CRF-20172 
//		    pstmt = connection.prepareStatement("SELECT B.short_desc	item_desc, A.bin_location_code bin_location_code, A.stock_item_yn, A.min_stk_qty, A.max_stk_qty, A.reorder_level, A.reorder_freq_days, A.lead_days,	A.min_stock_days, A.percent_min_stock,A.request_gen_stage,A.def_request_uom,A.def_issue_uom , a.eff_status,b.gen_uom_code,A.phy_inv_type phy_inv_type,A.phy_inv_count_per_year phy_inv_count_per_year   FROM st_item_store A,	mm_item_lang_vw	B  WHERE store_code	= ?	AND	B.item_code	= ?	AND	B.item_code	= A.item_code");//
            pstmt.setString(1, store_code);
            pstmt.setString(2, item_code);
            pstmt.setString(3, getLanguageId());
            resultSet = pstmt.executeQuery();
            if (resultSet != null && resultSet.next()) {
				itemForStoreDetail.setAll(resultSet);
            }
			oldStock_item_yn = itemForStoreDetail.getStock_item_yn();
			getDefaultRequest = itemForStoreDetail.getRequestGenStage();
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

    public ArrayList getBinLocations (String store_code) throws Exception {
        ArrayList binLocationData = new ArrayList();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_MM_BIN_LOCATION_SELECT_LIST"));
            pstmt.setString(1, store_code);
            pstmt.setString(2, getLanguageId());
            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
                String[] record = new String[2];
                record[0] = resultSet.getString(1);
                record[1] = resultSet.getString(2);
                binLocationData.add(record);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
        return binLocationData;
    }

	public void setAll(Hashtable hashValues) {
		String keyCode = "";
		String selectedKey ="";
		if (getMode().equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			if (hashValues.get("stock_item_yn") == null || (((String)hashValues.get("stock_item_yn")).trim().length()<=0)) {
				hashValues.put("stock_item_yn","N");
			}
			if (hashValues.get("eff_status") == null || (hashValues.get("eff_status")!=null && (hashValues.get("eff_status").equals("")))) {
				hashValues.put("eff_status","D");
			}
			else
			{hashValues.put("eff_status","E");
			}
			

			itemForStoreDetail.setAll(hashValues);
			return;
		}
		java.util.Enumeration hashKeys = hashValues.keys();
		while (hashKeys.hasMoreElements()) {
			keyCode = (String) hashKeys.nextElement();
			if (keyCode.startsWith("remove_")) {
				selectedKey = (String) hashValues.get(keyCode);
				if (selectedKey != null && selectedKey.trim().length()>0) {
					checkedItemStore.add(selectedKey);
					/*
					itemStoreKeys.remove(selectedKey);
					hmItemStore.remove(selectedKey);
					*/
				}
			}
		}
	}

	public ItemForStoreDetail getItemForStoreDetail() {
		return this.itemForStoreDetail;
	}

	public void setItemForStoreDetail(ItemForStoreDetail itemForStoreDetail ) {
		this.itemForStoreDetail = itemForStoreDetail;
	}

	public ItemForStoreDetail getItemForStoreDetail(String store_code,String item_code) {
		StringBuffer key = new StringBuffer();
		key.append(store_code);
		key.append("-");
		key.append(item_code);
		if (hmItemStore.containsKey(key.toString())) {
			return (ItemForStoreDetail) hmItemStore.get(key.toString());
		}
		return null;
	}

	public boolean recordsExists(String store_code, String item_code) {
		StringBuffer key = new StringBuffer();
		key.append(store_code);
		key.append("-");
		key.append(item_code);
		return hmItemStore.containsKey(key.toString());
	}

	public String getItemAnalysis() {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		ArrayList arr_lang=new ArrayList();
		//arr_lang.add(getLoginFacilityId());
		arr_lang.add(getLanguageId());

			alOptionValues = getListOptionArrayList(eMM.Common.MmRepository.getMmKeyValue("SQL_MM_ITEM_MASTER_ANALYSIS"),arr_lang);
		optionValues = getListOptionTag(alOptionValues);
		alOptionValues = null;
		return optionValues;
	}

	public String getMedicalItem(String store_code) {
		String medical_item_yn = "N";
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_STORE_MEDICAL_ITEM_SELECT"));
            pstmt.setString(1, store_code);
            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
                medical_item_yn = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
        return medical_item_yn;
	}
	//Added for GHL-CRF-0456 starts
	public boolean isSalesAllowed (String item_code) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		boolean result = false;
        String sales_allowed_flag = "";
		try {
            connection = getConnection();
            pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_ITEMMASTER"));
            pstmt.setString(1, item_code);
            pstmt.setString(2, getLanguageId());
            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
            	sales_allowed_flag = resultSet.getString("direct_sale_allowed_yn");
            }
            System.out.println("sales_allowed_flag"+sales_allowed_flag);
			result = (sales_allowed_flag.equals("N") );
		} catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
        return result;
	}
//Added for GHL-CRF-0456 ends
//Added for  IN:071344 start
public String getAutoRolYN(String store_code) {
	String auto_rol_yn = "N";
    Connection connection = null;
    PreparedStatement pstmt = null;
    ResultSet resultSet = null;
    try {
        connection = getConnection();
        pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_STORE_AUTO_ROL_SELECT"));
        pstmt.setString(1, store_code);
        resultSet = pstmt.executeQuery();
        while (resultSet != null && resultSet.next()) {
        	auto_rol_yn = resultSet.getString(1);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try{
            closeResultSet(resultSet);
            closeStatement(pstmt);
            closeConnection(connection);
        }catch(Exception es){
			es.printStackTrace();
        }
    }
    return auto_rol_yn;
}
//Added for  IN:071344 end

//Added for MMS-DM-CRF-0177 - Start
  
public String getDrugSearchYN(String item_code){
	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultSet		= null;
	String drug_check_yn="";
	try {
		connection			= getConnection();
		pstmt = connection.prepareStatement("SELECT DRUG_ITEM_YN FROM ST_ITEM WHERE ITEM_CODE = ?");
		pstmt.setString(1,item_code);
		resultSet = pstmt.executeQuery() ;
		
		if(resultSet!=null && resultSet.next()){					
			drug_check_yn = resultSet.getString("DRUG_ITEM_YN");	
			if(drug_check_yn==null)
				drug_check_yn="N";
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
	    finally {
		try { 
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		catch(Exception es){ 
			es.printStackTrace();
		}
	}	
return 	drug_check_yn;
}

public ArrayList getPreAllocCheck(){
	Connection connection = null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet = null ;
	ArrayList pre_alloc_appl = new ArrayList();
	String qryString =	"SELECT PRE_ALLOC_APPL, NEAR_EXPIRY_APPL, DURN_VALUE, DURN_TYPE,DURN_VALUE_IN_DAYS FROM PH_FACILITY_PARAM WHERE FACILITY_ID=?";
	
	try {
		connection = getConnection() ;
		pstmt = connection.prepareStatement(qryString);
		pstmt.setString(1,login_facility_id);
		resultSet = pstmt.executeQuery() ;
		if(resultSet != null && resultSet.next()){
			pre_alloc_appl.add(resultSet.getString("PRE_ALLOC_APPL"));
			pre_alloc_appl.add(resultSet.getString("NEAR_EXPIRY_APPL"));
			pre_alloc_appl.add(resultSet.getString("DURN_VALUE"));
			pre_alloc_appl.add(resultSet.getString("DURN_TYPE"));
			pre_alloc_appl.add(resultSet.getString("DURN_VALUE_IN_DAYS"));
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}catch(Exception es){
			es.printStackTrace();
		}
	}
	return pre_alloc_appl;
}


public ArrayList getPreAllocItemStore(String item_code, String store_code){
	Connection connection = null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet = null ;
	ArrayList pre_alloc_item_store = new ArrayList();
	String qryString =	"SELECT NEAR_EXPIRY_APPL, DURN_VALUE, DURN_TYPE,DURN_VALUE_IN_DAYS FROM ST_ITEM_STORE WHERE ITEM_CODE = ? AND STORE_CODE = ?";
	
	try {
		connection = getConnection() ;
		pstmt = connection.prepareStatement(qryString);
		pstmt.setString(1,item_code);
		pstmt.setString(2,store_code);
		resultSet = pstmt.executeQuery() ;
		if(resultSet != null && resultSet.next()){
			pre_alloc_item_store.add(resultSet.getString("NEAR_EXPIRY_APPL"));
			pre_alloc_item_store.add(resultSet.getString("DURN_VALUE"));
			pre_alloc_item_store.add(resultSet.getString("DURN_TYPE"));
			pre_alloc_item_store.add(resultSet.getString("DURN_VALUE_IN_DAYS"));
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}catch(Exception es){
			es.printStackTrace();
		}
	}
	return pre_alloc_item_store;
}
//Added for MMS-DM-CRF-0177 - End
}
