/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
* Java Bean for Tray No Search
*/
package eSS;

import java.util.ArrayList;
import eSS.Common.SsRepository;
import eCommon.Common.CommonRepository;
import eSS.Common.SsAdapter;


public class TrayNoSearchBean extends eSS.Common.SsTransaction implements java.io.Serializable {

	// Table Column Variables 
	private String store_code;
	private String store_code_list;

	public void setStore_code(String store_code) {
		 this.store_code = store_code;
	}

	public String getStore_code() {
		 return store_code;
	}

	public void setStore_code_list(String store_code_list) {
		 this.store_code_list = store_code_list;
	}

	public String getStore_code_list() {
		 return store_code_list;
	}

	public void clear(){
		super.clear();
		store_code="";       
		store_code_list="";       
	}

	public String getStore_code_List(){
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(getLanguageId());
		alParameters.add(getLoginFacilityId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_SELECT_LIST"),alParameters), getStore_code_list());
	} 
	
	public String getStore_codes(){
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(getLanguageId());
		alParameters.add(getLoginFacilityId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_SELECT_LIST"),alParameters), getStore_code());
	}

	public String getBinLocations() {
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getStore_code());
		alParam.add(getLanguageId());

		String optionValues = null;
		java.util.ArrayList alOptionValues = getListOptionArrayList(SsRepository.getSsKeyValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),alParam);
		optionValues = getListOptionTag(alOptionValues);
		alOptionValues = null;
		return optionValues;
	}
}
