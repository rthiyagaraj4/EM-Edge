/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------------------
15/07/2021	TFS:21516		Shazana										MOHE-CRF-0084.1-US014
--------------------------------------------------------------------------------------------------------------------
*/
 package eST;

//import eCommon.Common.CommonAdapter;
import eST.Common.StTransaction;
import eST.Common.StRepository;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Hashtable;

public class ConsumptionReportBean extends StTransaction implements Serializable{

	private String item_code;
	private String store_code;
	private String searchFunction="N";
	//private String language;
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

	public String getSearchFunction( ) {
		 return searchFunction;
	}


	public String getReportSubType()
	{
		return getStaticListOptionTag("STBCONS1,Item Consolidated;STBCONS2,By Store ;STBCONS3,By Store-Item Class;STBCONS4,By Item Class;STBCONS5,By Item;");
	}

	public String getReportType()
	{
		return getStaticListOptionTag("C,Consumption;CD,Consumption Deviation;ATC,Consumption By ATC Classification;");
	}

/*public void setLanguageId(String language) {
		this.language = language;
	}
public String getLanguageId() {
		return this.language;
	}*/


	public String getReportOption()
	{
		return getStaticListOptionTag("B,Both;Q,Quantity;V,Value;");
	}
	public String getItemStore()
	{
		return getStaticListOptionTag("S,Store Level;I,Item Level;");
	}
	public String getItem_analList(){
		return getListOptionTag(getListOptionArrayList(StRepository.getStKeyValue("SQL_ST_ITEM_ANAL_CODE_SELECT_SINGLE"),getLanguageId()));
	}


	public void clear()
	{
	this.item_code="";
	this.store_code="";
	}
	
	 //MOHE-CRF-0084.1 
    public String getRestrictUserAccessStore(){
     	String []stParameters=	{getLoginFacilityId()};
    		HashMap hmRecord	=	null;
    		try{
    			hmRecord	=	(HashMap)fetchRecord("SELECT RESTRICT_USER_ACCESS_STORE_YN FROM	st_facility_param WHERE facility_id=?", stParameters);
    		}catch(Exception e){
    			e.printStackTrace();
    			return "";
    		}
    		return (String)hmRecord.get("RESTRICT_USER_ACCESS_STORE_YN"); 
     	
     } 
/*Method moved to Adapter class as this is used commonly in more than 8 functions Mahesh 14/12/2009*/
/*	public String getAccessCostDetails(){
		String cost_yn			  = "N";	
		HashMap view_cost_yn	  = new HashMap();
		try{
			view_cost_yn = fetchRecord(getStRepositoryValue("ST_SQL_VIEW_COST_YN_SELECT"),getLoginById());
		}catch(Exception e){
			cost_yn = "";
		}
		if(view_cost_yn.size() > 0){
			//Check For Null is added on 14/12/2009 By Mahesh
			cost_yn = checkForNull((String)view_cost_yn.get("VIEW_COST_YN"),"N");
		}
		return cost_yn;
	}
*/
}
