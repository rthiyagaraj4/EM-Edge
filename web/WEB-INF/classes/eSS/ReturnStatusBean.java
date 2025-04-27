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
public class ReturnStatusBean extends eSS.Common.SsTransaction implements Serializable { 
	
	public String getEntered_List(){
		return getStaticListOptionTag( "%,All;Y,Entry Completed;N,Entry not Completed;");
	}
	public String getFinalized_List(){
		return getStaticListOptionTag( "%,All;Y,Finalized;N,Not Finalized;");
	}

	

	public String getRetToStores() {

java.util.ArrayList alParam = new java.util.ArrayList();
alParam.add(getLoginFacilityId());
alParam.add(getLanguageId());
return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_QUERY_ISS_SELECT_LIST"),alParam));
/*		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		java.util.ArrayList alParameters = new java.util.ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getLoginById());
		// Changed from SQL_SS_PREPARE_GROUP_STORE
		alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_PRE_SELECT_LIST"),alParameters,false);
		optionValues = getListOptionTag(alOptionValues);
		alOptionValues = null;
		return optionValues;
*/	}

	public String getRetByStores() {
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getLoginFacilityId());
		alParam.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_QUERY_RET_SELECT_LIST"),alParam));

/*		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		// Changed from SQL_SS_PREPARE_GROUP_STORE
		alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_SELECT_LIST"),getLoginFacilityId());
		optionValues = getListOptionTag(alOptionValues);
		alOptionValues = null;
		return optionValues;
*/	}

	public Boolean getAckReqd(){
		String ack_reqd = "N";
		try{
			ack_reqd = (String)fetchRecord("SELECT RET_ACK_REQ_YN FROM SS_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId()).get("RET_ACK_REQ_YN");
		}catch(Exception e){
			e.printStackTrace();
		}
		return checkForNull(ack_reqd,"N").equals("Y");
	}

}
