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

public class ReceiptListBean extends eSS.Common.SsTransaction implements java.io.Serializable { 

	private String rof_doc_type_code	=	"";
	private String rof_doc_no	=	"";
	private String doc_date	=	"";
//	private String washing_yn	=	"";
	private String store_code	=	"";
//	private String packing_yn	=	"";
//	private String sterilize_yn	=	"";
	//private String doc_ref	=	"";
	private String location	=	"";
	private String group_code    =	"";
	private String group_desc ="";
	private String tray_no =	"";
	private String wash_load_no =	"";
	private String autoclave_load_no =	"";
	private String packing_date=	"";
	private String dispatch_date=	"";
	//private HttpSession session;

	public void setRof_doc_type_code(String rof_doc_type_code) {
		 this.rof_doc_type_code = rof_doc_type_code.toUpperCase();
	}

	public String getRof_doc_type_code( ) {
		 return rof_doc_type_code;
	}

	public void setRof_doc_no(String rof_doc_no) {
		 this.rof_doc_no = rof_doc_no;
	}

	public String getRof_doc_no( ) {
		 return rof_doc_no;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation( ) {
		 return location;
	}

	
	public void setDoc_date(String doc_date) {
		 this.doc_date = doc_date;
	}

	public String getDoc_date( ) {
		 return doc_date;
	}

	public void setStore_code(String store_code) {
		 this.store_code = store_code.toUpperCase();
	}

	public String getStore_code( ) {
		 return store_code;
	}
	
	public void setGroup_code(String group_code) {
		 this.group_code = group_code.toUpperCase();
	}

	public String getGroup_code( ) {
		 return group_code;
	}

	public void setGroup_desc(String group_desc)
	{
			 this.group_desc = group_desc;
	}

	public String getGroup_desc( )
	{
		return group_desc;
	}

	public void setTray_no(String tray_no) {
		 this.tray_no = tray_no.toUpperCase();
	}

	public String getTray_no( ) {
		 return tray_no;
	}

	public void setWash_load_no(String wash_load_no) {
		 this.wash_load_no = checkForNull(wash_load_no).toUpperCase();
	}

	public String getWash_load_no( ) {
		 return wash_load_no;
	}

	public void setAutoclave_load_no(String autoclave_load_no) {
		 this.autoclave_load_no = checkForNull(autoclave_load_no).toUpperCase();
	}

	public String getAutoclave_load_no( ) {
		 return autoclave_load_no;
	}
	public void setPacking_date(String packing_date) {
		 this.packing_date = packing_date.toUpperCase();
	}

	public String getPacking_date( ) {
		 return packing_date;
	}

	public void setDispatch_date(String dispatch_date) {
		 this.dispatch_date = dispatch_date.toUpperCase();
	}

	public String getDispatch_date( ) {
		 return dispatch_date;
	}


	public void initialize(HashMap hmPackingListItem){
		
		setGroup_code((String) hmPackingListItem.get("GROUP_CODE"));
		setGroup_desc((String) hmPackingListItem.get("DESCRIPTION"));
		setTray_no((String) hmPackingListItem.get("TRAY_NO"));
		setWash_load_no((String) hmPackingListItem.get("WASH_LOAD_NO"));
		setAutoclave_load_no((String) hmPackingListItem.get("AUTOCLAVE_LOAD_NO"));
		setDispatch_date((String) hmPackingListItem.get("RECEIPT_DATE"));
		
	}

	

	public void clear(){
		dispatch_date="";
		group_code="";
		group_desc="";
		tray_no="";
	}

}
