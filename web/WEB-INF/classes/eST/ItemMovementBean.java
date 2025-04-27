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

public class ItemMovementBean extends StTransaction implements Serializable{

	private String facility_id;
	/*  private String language_id;

	public void setLanguageId (String language_id)
	{
		this.language_id = language_id;
	}
	public String getLanguageId() 
	{
		return this.language_id;
	}*/
	public void setFacility_id(String facility_id)
	{
		this.facility_id = facility_id;
	}

	public String getStore() throws Exception {	
	try	{
		ArrayList arr_lang=new ArrayList();
		arr_lang.add(this.facility_id);
		arr_lang.add(getLanguageId());
	return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_STORE_SELECT_LIST"),arr_lang));


	}
	catch(Exception e) {
	e.printStackTrace();
		}
	return null;
	}
	
	public String getTrn_type() throws Exception {	
	try	{
		ArrayList arr_lang=new ArrayList();
		//arr_lang.add(this.facility_id);
		arr_lang.add(getLanguageId());
		arr_lang.add(getAcc_entity_id());
	return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_TYPE_SELECT_LIST"),arr_lang));
	}
	catch(Exception e) {
	e.printStackTrace();
		}
	return null;
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
