/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
7/6/2021				TFS-19789				Shazana													MOHE-CRF-0084.1 
15/7/2021				TFS-21515				Shazana													MOHE-CRF-0084.1 - US013
--------------------------------------------------------------------------------------------------------------------------------------------
*/
 package eST;

import eST.Common.StTransaction;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class BlockedBatchesBean extends StTransaction implements Serializable{
 	
	/*private String language_id;
	public void setLanguageId(String language_id) {
		 this.language_id= language_id;
	}

	public String getLanguageId( ) {
		 return language_id;
	}*/
    public String getTrn_type_List()throws Exception{
		ArrayList arr_lang=new ArrayList();
		arr_lang.add(getLanguageId());
		arr_lang.add(getAcc_entity_id());
		//return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_TYPE_SELECT_LIST"),arr_lang));
		return getListOptionTag(getListOptionArrayList("SELECT TRN_TYPE, LONG_DESC FROM ST_TRN_TYPE_LANG_VW  ST_TRN_TYPE WHERE TRN_TYPE NOT IN ('REQ','SPB','CBL','PRQ','CEB') AND LANGUAGE_ID = ? ORDER BY 2",getLanguageId()));

	}
    public String getRestrictUserAccessStore(){
    	String []stParameters=	{getLoginFacilityId()};
		HashMap hmRecord	=	null;
		try{
			hmRecord	=	(HashMap)fetchRecord("SELECT	RESTRICT_USER_ACCESS_STORE_YN FROM	st_facility_param WHERE facility_id=?", stParameters);
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
		return (String)hmRecord.get("RESTRICT_USER_ACCESS_STORE_YN"); 
    	
    }

}
