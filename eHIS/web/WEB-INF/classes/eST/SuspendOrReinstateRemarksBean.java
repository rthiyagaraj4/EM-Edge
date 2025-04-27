/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

import java.io.Serializable;

public class SuspendOrReinstateRemarksBean implements Serializable {
	private String item_code;
	private String batch_id;
    private String expiry_date;
	private String remarks;
	private String initiated_by;
	private String profile;
	private String product_recall;
//	private String language_id;

	public SuspendOrReinstateRemarksBean() {
	item_code=""; 
	batch_id="";    
	expiry_date="";
	remarks="";    
	initiated_by="";
	profile="";        
	product_recall="";        

	}

	public SuspendOrReinstateRemarksBean(String item_code, String batch_id, String expiry_date, String remarks,String initiated_by,String profile ,String productrecall ) {
		this.item_code = item_code;
		this.batch_id = batch_id;
        this.expiry_date = expiry_date;
		this.remarks = remarks;
		this.initiated_by = initiated_by;
		this.profile = profile;
		this.product_recall = productrecall;

	}

	public void setItem_code(String item_code) {	
		this.item_code = item_code;
	}

	public String getItem_code() {	
		return this.item_code;
	}
	
	/*public void setLanguageId(String language_id) {
		 this.language_id= language_id;
	}

	public String getLanguageId( ) {
		 return language_id;
	}*/
	public void setBatch_id(String batch_id) {	
		this.batch_id = batch_id;
	}

	public String getBatch_id() {	
		return this.batch_id;
	}

    public void setExpiry_date(String expiry_date) {	
		this.expiry_date = expiry_date;
	}

	public String getExpiry_date() {	
		return this.expiry_date;
	}

	public void setRemarks(String remarks) {	
		this.remarks = remarks;
	}
	
	public String getRemarks() {
		return this.remarks;   
	}


	public void setInitiated_by(String initiated_by) {	
		this.initiated_by = initiated_by;
	}
	
	public String getInitiated_by() {
		return this.initiated_by;   
	}

	public void setProfile(String profile) {	
		this.profile = profile;
	}
	
	public String getProfile() {
		return this.profile;   
	}
	public void setProduct_Recall(String product_recall) {	
		this.product_recall = product_recall;
	}
	
	public String getProduct_Recall() {
		return this.product_recall;   
	}

	public String toString() {
		return item_code + " = " +batch_id + " = " + expiry_date +  " = " + remarks + " = " + initiated_by + " = " + profile+ " = " + product_recall ;
	}
}
