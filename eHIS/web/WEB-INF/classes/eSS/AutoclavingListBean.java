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
public class AutoclavingListBean extends eSS.Common.SsTransaction implements Serializable { 

	private String group_code;
	private String tray_no;
	private String doc_type_code;
	private String doc_no;
	private String mode;


	public String getGroup_code() {
		 return group_code;
	}
	
	public String getTray_no() {
		 return tray_no;
	}
	
	public String getDoc_type_code() {
		 return doc_type_code;
	}

	public String getDoc_no() {
		 return doc_no;
	}


//SET METHODS FROM HERE
	public void setGroup_code(String group_code) {
		 this.group_code =  group_code.toUpperCase();
	}

	public void setTray_no(String tray_no) {
		 this.tray_no =  tray_no;
	}

	public void setDoc_type_code(String doc_type_code) {
		 this.doc_type_code =  doc_type_code.toUpperCase();
	}

	public void setDoc_no(String doc_no) {
		 this.doc_no =  doc_no.toUpperCase();
	}


	public void setMode(String mode) {
		 this.mode =  mode;
	}
	
	public String getMode() {
		 return mode;
	}


	public void clear(){
		group_code	  ="";    
		tray_no="";       
		doc_type_code   ="";  		
		mode          ="";          
	}


	public HashMap toHashMap(){
		HashMap hmReturn	 =	new HashMap();
		hmReturn.put("group_code",		getGroup_code());
		hmReturn.put("tray_no",		new Long(getTray_no()));
		hmReturn.put("doc_type_code",		getDoc_type_code());
		hmReturn.put("doc_no",	getDoc_no());
		hmReturn.put("mode",			getMode          ());
		return hmReturn;
	}

	public boolean isEntryCompleted(String autoclave_wash_unit_code, String load_no) throws Exception{
		HashMap hmResult		=	new HashMap();
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(autoclave_wash_unit_code);
		alParameters.add(load_no);
		hmResult	=	fetchRecord(getSsRepositoryValue("SQL_SS_AUTOCLAVE_HDR_SELECT_SINGLE"),alParameters);
		return hmResult.get("ENTRY_COMPLETED_YN").toString().equals("Y");
	}
	public void initialize(HashMap hmRequestGroupItem){
	
		setGroup_code(hmRequestGroupItem.get("group_code").toString()	);
		setTray_no(hmRequestGroupItem.get("tray_no").toString()		);	
		setDoc_type_code	 (hmRequestGroupItem.get("doc_type_code").toString()	);
		setDoc_no   (hmRequestGroupItem.get("doc_no").toString()	);
		setMode          (hmRequestGroupItem.get("mode").toString()			);

	}
}
