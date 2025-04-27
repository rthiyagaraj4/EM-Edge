/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS;

import java.util.*;
import java.io.*;
public class ROFDetailsBean extends eSS.Common.SsTransaction implements Serializable { 
	
	public String getDocTypes() {
		try {
			java.util.HashMap defaultParameter = getSSParameter();
		//	System.err.println("defaultParameter--------->"+defaultParameter);
			String defaultReturnGroup = (String) defaultParameter.get("DEF_ROF_DOC_TYPE_CODE");
			return getDoc_type_code_ListOptions("ROF", defaultReturnGroup);
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	public String getCurrentROFStores() {

		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getLoginFacilityId());
		alParam.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_QUERY_ROF_SELECT_LIST"),alParam));
	}

	public String getSterProcessStage() {
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_STER_PROCESS_STAGE_SELECT_LIST"),getLanguageId()));
	}


public String getDef_service_location_code_List(){
		ArrayList alParameter=new ArrayList();
		alParameter.add(getLoginFacilityId());
		alParameter.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_SERVICE_LOCATION_SELECT_LIST"),alParameter));
	}
}
