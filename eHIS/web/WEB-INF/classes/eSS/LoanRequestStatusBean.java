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
public class LoanRequestStatusBean extends eSS.Common.SsTransaction implements Serializable {  
	
	public String getEntered_List(){
		return getStaticListOptionTag( "%,All;Y,Entry Completed;N,Entry not Completed;");
	}
	public String getAuthorized_List(){
		return getStaticListOptionTag( "%,All;Y,Authorized;N,Unauthorized;");
	}
	public String getIssued_List(){
		return getStaticListOptionTag( "%,All;1,Not Issued;3,Partially Issued;2,Fully Issued;");
	}
	public String getCancelled_List(){
		return getStaticListOptionTag( "%,All;Y,Cancelled;N,Not cancelled;");
	}
	

	public String getRequest_Type_List(){
		return getStaticListOptionTag( "N,Normal;U,Urgent;E,Elective;%,All;");
	}

	

	public String getReqOnStores() {

java.util.ArrayList alParam = new java.util.ArrayList();
alParam.add(getLoginFacilityId());
alParam.add(getLanguageId());
return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_QUERY_ISL_SELECT_LIST"),alParam));
}

	public String getReqByStores() {
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getLoginFacilityId());
		alParam.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_QUERY_RQL_SELECT_LIST"),alParam));

	}

	public Boolean getAckReqd(){
		String ack_reqd = "N";
		try{
			ack_reqd = (String)fetchRecord("SELECT ISL_ACK_REQ_YN FROM SS_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId()).get("ISL_ACK_REQ_YN");
		}catch(Exception e){
			e.printStackTrace();
		}
		return checkForNull(ack_reqd,"N").equals("Y");
	}

}
