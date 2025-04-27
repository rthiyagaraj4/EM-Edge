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
public class RequestGroupListBean extends eSS.Common.SsTransaction implements Serializable { 

	private String group_type;
	private String req_group_code;
	private String auth_group_code;
	private String auth_group_desc;
	private String description;
	private String request_qty;
	private String available_qty;
	private String mode;
	private String surg_description;
	private String ot_surg_description;

	public String getGroup_type() {
		 return group_type;
	}

	public void setGroup_type(String group_type) {
		 this.group_type =  group_type.toUpperCase();
	}

	public String getReq_group_code() {
		 return req_group_code;
	}

	public void setReq_group_code(String req_group_code) {
		 this.req_group_code =  req_group_code.toUpperCase();
	}

	public String getAuth_group_code() {
		 return auth_group_code;
	}

	public void setAuth_group_code(String auth_group_code) {
		 this.auth_group_code =  auth_group_code.toUpperCase();
	}

	public String getAuth_group_desc() {
		 return auth_group_desc;
	}

	public void setAuth_group_desc(String auth_group_desc) {
		 this.auth_group_desc=  auth_group_desc;
	}

	public String getDescription() {
		 return description;
	}

	public void setDescription(String description) {
		 this.description =  description;
	}

	public void setRequest_qty(String request_qty) {
		 this.request_qty =  request_qty;
	}

	public String getRequest_qty() {
		 return request_qty;
	}

	public void setAvailable_qty(String available_qty) {
		 this.available_qty =  available_qty;
	}

	public String getAvailable_qty() {
		 return available_qty;
	}

	public void setMode(String mode) {
		 this.mode =  mode;
	}

	public String getMode() {
		 return mode;
	}

	public String getGroup_type_Text(String group_type){
		return group_type.equals("E")?"Set":group_type.equals("T")?"Tray":group_type.equals("P")?"Soft Pack":"Single";
	}

	public String getGroup_type_List(){
		return getStaticListOptionTag( "E,Set;T,Tray;P,Soft Pack;S,Single", getGroup_type());
	}

	//Added By Sakti against KDAH-CRF-0247 
	public String getSurg_Description() {
		 return surg_description;
	}

	public void setSurg_Description(String surg_description) {
		 this.surg_description =  checkForNull(surg_description,"");
	}
	
	public String getOTSurg_Description() {
		 return ot_surg_description;
	}

	public void setOTSurg_Description(String ot_surg_description) {
		 this.ot_surg_description =  checkForNull(ot_surg_description);
	}
//Added ends

	public void clear(){
		group_type	  ="";    
		req_group_code="";     
		auth_group_code="";
		auth_group_desc="";
		description   ="";          
		request_qty   ="";          
		available_qty ="";          
		mode          =""; 
		surg_description = "";
		ot_surg_description = "";
	}

	public String getAuth_group_code_List(){
		ArrayList alParameters	=	new ArrayList(2);
		alParameters.add(getReq_group_code());
		alParameters.add(getReq_group_code());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_ALTERNATE_GROUP_SELECT_LIST"),alParameters), getAuth_group_code());
	}


	public HashMap toHashMap(){
		HashMap hmReturn	 =	new HashMap();
		hmReturn.put("group_type",		getGroup_type	 ());
		hmReturn.put("req_group_code",	getReq_group_code());
		hmReturn.put("description",		getDescription   ());
		hmReturn.put("request_qty",		getRequest_qty   ());
		hmReturn.put("mode",			getMode          ());
		// Added By Sakti against KDAH-CRF-0247
		hmReturn.put("surg_description",		getSurg_Description   ());
		hmReturn.put("ot_surg_description",			getOTSurg_Description   ());
		//Added ends
		return hmReturn;
	}

	public boolean isGroupInArrayList(ArrayList alRequestGroupList, String stReq_group_code, int exceptionalIndex){
		boolean result=false;
		for (int i=0;i<alRequestGroupList.size();i++) {
			if (exceptionalIndex == i) continue;
			if ( ((HashMap)alRequestGroupList.get(i)).get("req_group_code").toString().equals(stReq_group_code) ) {
				result=true;
				break;
			}
		}
		return result;
	}

	public boolean isEntryCompleted(String doc_type_code, String doc_no) throws Exception{
		HashMap hmResult		=	new HashMap();
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(doc_type_code);
		alParameters.add(new Long(doc_no));
		hmResult	=	fetchRecord(getSsRepositoryValue("SQL_SS_REQUEST_HDR_SELECT_SINGLE"),alParameters);
		return hmResult.get("ENTRY_COMPLETED_YN").toString().equals("Y");
	}

	public void initialize(HashMap hmRequestGroupItem){
		setGroup_type	 (hmRequestGroupItem.get("group_type").toString()	);
		setReq_group_code(hmRequestGroupItem.get("req_group_code").toString()		);
		setAuth_group_code(hmRequestGroupItem.get("auth_group_code").toString()		);
		setAuth_group_desc(hmRequestGroupItem.get("auth_group_desc").toString()		);
		setDescription   (hmRequestGroupItem.get("description").toString()	);
		setRequest_qty   (hmRequestGroupItem.get("request_qty").toString()			);
		setAvailable_qty (hmRequestGroupItem.get("available_qty").toString()			);
		setMode          (hmRequestGroupItem.get("mode").toString()			);
		// Added By Sakti against KDAH-CRF-0247
		setSurg_Description   (hmRequestGroupItem.get("surg_description").toString()	);
		setOTSurg_Description   (hmRequestGroupItem.get("ot_surg_description").toString()	); 
		//Added ends
	}
}
