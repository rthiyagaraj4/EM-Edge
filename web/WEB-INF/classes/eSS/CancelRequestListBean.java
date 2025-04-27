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
public class CancelRequestListBean extends eSS.Common.SsTransaction implements Serializable { 

	private String group_type;
	private String req_group_code;
	private String description;
	private String request_qty;
	private String issue_qty;
	private String mode;
	private String blocked_qty;

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

	public void setIssue_qty(String issue_qty) {
		 this.issue_qty =  checkForNull(issue_qty);
	}

	public String getIssue_qty() {
		return issue_qty;
	}

	public void setMode(String mode) {
		 this.mode =  mode;
	}

	public String getMode() {
		 return mode;
	}
//Added by Sakti against BRU-HIMS-CRF#274
	public void setBlocked_qty(String blocked_qty) {
		 this.blocked_qty =  checkForNull(blocked_qty);
	}

	public String getBlocked_qty() {
		return blocked_qty;
	}
//Added ends
	public String getGroup_type_List(){
		return getStaticListOptionTag( "E,Set;T,Tray;P,Soft Pack;S,Single;", getGroup_type());
	}

	public void clear(){
		group_type	  ="";    
		req_group_code="";          
		description   ="";          
		request_qty   ="";          
		mode          ="";          
	}



	public HashMap toHashMap(){
		HashMap hmReturn	 =	new HashMap();
		hmReturn.put("group_type",		getGroup_type	 ());
		hmReturn.put("req_group_code",	getReq_group_code());
		hmReturn.put("description",		getDescription   ());
		hmReturn.put("request_qty",		getRequest_qty   ());
		hmReturn.put("issue_qty",		getIssue_qty   ());
		hmReturn.put("mode",			getMode          ());
		hmReturn.put("blocked_qty",		getBlocked_qty   ());//Added by Sakti against BRU-HIMS-CRF#274
		return hmReturn;
	}

	public void initialize(HashMap hmRequestGroupItem){
		setGroup_type	 (hmRequestGroupItem.get("group_type").toString()	);
		setReq_group_code(hmRequestGroupItem.get("req_group_code").toString());
		setDescription   (hmRequestGroupItem.get("description").toString()	);
		setRequest_qty   (checkForNull(hmRequestGroupItem.get("request_qty").toString()	));
		setIssue_qty	 (checkForNull(hmRequestGroupItem.get("issue_qty").toString())	);
		setMode          (hmRequestGroupItem.get("mode").toString()			);
		setBlocked_qty	 (checkForNull(hmRequestGroupItem.get("blocked_qty").toString())	);//Added by Sakti against BRU-HIMS-CRF#274

		
	} 
}
 
