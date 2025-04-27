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

public class TransAnalysisBean extends StAdapter
    implements Serializable
{
//private String language_id;
    public TransAnalysisBean()
    {
        module_id = "ST";
    }
	
    public String getNature()
    {
        return getStaticListOptionTag("B,Both;E,Enabled;D,Disabled;");
    }
	/*public void setLanguageId(String language_id) {
		 this.language_id= language_id;
	}

	public String getLanguageId() {
		 return language_id;
	}*/
	public String getReportList()
    {
        return getStaticListOptionTag("A,Request Statistics Report;B,GRN Statistics Report;C,Report Unfinalized Transactions;");
    }

	public String getStore_code_List(){
		ArrayList alParameters=new  ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_SELECT_LIST"),alParameters));
	}

	/*public String getItemAnal_code_List(){
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_ANAL_CODE_SELECT_SINGLE")));
	}*/

//  public String module_id;

	public String getTrn_code_list(){
		//return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_TYPE_SELECT_LIST"),alParameters));
		return getListOptionTag(getListOptionArrayList("SELECT TRN_TYPE, LONG_DESC FROM ST_TRN_TYPE_LANG_VW  ST_TRN_TYPE WHERE TRN_TYPE NOT IN ('REQ','SPB','CBL','PRQ','CEB') AND LANGUAGE_ID = ? ORDER BY 2",getLanguageId()));
	}
	public String getItem_analList(){
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_ANAL_CODE_SELECT_SINGLE"),getLanguageId()));
	}


}
