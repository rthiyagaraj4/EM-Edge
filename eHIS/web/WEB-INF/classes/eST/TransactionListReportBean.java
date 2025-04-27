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
import eST.Common.StTransaction;
import eST.Common.StRepository;
import java.io.Serializable;
import java.sql.*;
import java.util.*;


public class TransactionListReportBean extends StTransaction implements Serializable{

	private String store_code;
	
	public void setStore_code(String store_code) {
		 this.store_code = store_code;
	}

	public String getStore_code() {
		 return store_code;
	}
	
	public void clear()
	{
	this.store_code="";
	}
	
    public String getFacilitynames(){
	
	  String optionValues = null;
	  ArrayList alOptionValues = new ArrayList();
	  ArrayList arr_language=new ArrayList();
	  arr_language.add(getLanguageId());
	  arr_language.add(getLoginById());
	  alOptionValues = getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_FACILITY_NAME_QUERY"), arr_language);
	  alOptionValues.remove(0);
	  optionValues = getListOptionTag(alOptionValues,getLoginFacilityId());
	   return optionValues;
	   }

    public String getStores() {
	
		 String optionValues = null;
		 ArrayList alOptionValues = new ArrayList();
		 ArrayList alParam = new ArrayList();
		 alParam.add(getLoginFacilityId());
		 alParam.add(getLanguageId());
		 alOptionValues = getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_SELECT_LIST"), alParam);
		//alOptionValues = getListOptionArrayList("SELECT	a.store_code, b.short_desc FROM	st_store a,	mm_store_lang_vw b,st_acc_entity_param WHERE a.store_code =	b.store_code AND b.eff_status='E' AND b.facility_id	LIKE ? 	AND b.language_id= ? ORDER BY b.short_desc", alParam);
		alOptionValues.remove(0);
		 optionValues = getListOptionTag(alOptionValues, "");
		return optionValues;
	}
	
	public ArrayList getStoreArrayList(String facility_id){ 
		ArrayList arraylist = new ArrayList();
		ArrayList alList = null;
        arraylist.add(facility_id); 
        arraylist.add(getLanguageId());
         try{
			alList =  fetchRecords("SELECT	a.store_code, b.short_desc FROM	st_store a,	mm_store_lang_vw b,st_acc_entity_param WHERE a.store_code =	b.store_code AND b.eff_status='E' AND b.facility_id	LIKE ? 	AND b.language_id= ? ORDER BY b.short_desc",arraylist);
			}catch(Exception e){
			e.printStackTrace();
		    } 
			return alList;
	  }
}
