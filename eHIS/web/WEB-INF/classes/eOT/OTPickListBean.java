/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT ;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.sql.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.io.Serializable;
import eOT.Common.OTAdapter;
import java.util.Properties;
import com.ehis.util.DateUtils;
import eCommon.Common.CommonBean;

public class OTPickListBean extends OTAdapter implements Serializable {
	String locale	= "";
	//General Fields
	String doc_type_code	= "";
	String doc_no	= "";
	String doc_date="";
	String req_by_store_code="";
	String req_on_store_code="";
	String entry_completed_yn="";
	String request_type="";
	//For HashMap
	String group_type="";
	String req_group_code="";
	String auth_group_code="";
	String request_qty="";
	String description="";
	String available_qty="";
	String auth_group_desc="";
	String mode="";

//Setter & Getter for specified fields
	ArrayList pickList = new ArrayList();

	public ArrayList getPickList() {
		return pickList;
	}

	public void setPickList(ArrayList pickList) {
		this.pickList = pickList;
	}

	public String getDoc_type_code() {
		return doc_type_code;
	}

	public void setDoc_type_code(String doc_type_code) {
		this.doc_type_code = doc_type_code;
	}

	public String getDoc_no() {
		return doc_no;
	}

	public void setDoc_no(String doc_no) {
		this.doc_no = doc_no;
	}

	public String getDoc_date() {
		return doc_date;
	}

	public void setDoc_date(String doc_date) {
		this.doc_date = doc_date;
	}

	public String getEntry_completed_yn() {
		return entry_completed_yn;
	}

	public void setEntry_completed_yn(String entry_completed_yn) {
		this.entry_completed_yn = entry_completed_yn;
	}

	public String getGroup_type() {
		return group_type;
	}

	public void setGroup_type(String group_type) {
		this.group_type = group_type;
	}

	public String getAuth_group_code() {
		return auth_group_code;
	}

	public void setAuth_group_code(String auth_group_code) {
		this.auth_group_code = auth_group_code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAvailable_qty() {
		return available_qty;
	}

	public void setAvailable_qty(String available_qty) {
		this.available_qty = available_qty;
	}

	public String getAuth_group_desc() {
		return auth_group_desc;
	}

	public void setAuth_group_desc(String auth_group_desc) {
		this.auth_group_desc = auth_group_desc;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getReq_by_store_code() {
		return req_by_store_code;
	}

	public void setReq_by_store_code(String req_by_store_code) {
		this.req_by_store_code = req_by_store_code;
	}

	public String getReq_on_store_code() {
		return req_on_store_code;
	}

	public void setReq_on_store_code(String req_on_store_code) {
		this.req_on_store_code = req_on_store_code;
	}

	public String getRequest_type() {
		return request_type;
	}

	public void setRequest_type(String request_type) {
		this.request_type = request_type;
	}

	public String getRequest_qty() {
		return request_qty;
	}

	public void setRequest_qty(String request_qty) {
		this.request_qty = request_qty;
	}

	public String getReq_group_code() {
		return req_group_code;
	}

	public void setReq_group_code(String req_group_code) {
		this.req_group_code = req_group_code;
	}

//Setter & Getter for specified fields

	public OTPickListBean() {
		try {
			doCommon();
		}catch(Exception e) {}
	}

	public void doCommon() throws Exception {}

	public void clear(){}

//Method for get the Picklist values for CSSD
	public HashMap getPickListInfo(HashMap pick_list_reqd_dtls){
		ArrayList displayFields = new ArrayList();

		String group_type =(String) pick_list_reqd_dtls.get("group_type");		
		String req_group_code =(String) pick_list_reqd_dtls.get("req_group_code");
		String auth_group_code =(String) pick_list_reqd_dtls.get("auth_group_code");
		String noofunits =(String) pick_list_reqd_dtls.get("noofunits");
		String description =(String) pick_list_reqd_dtls.get("description");
		String available_qty =(String) pick_list_reqd_dtls.get("available_qty");
		String auth_group_desc =(String) pick_list_reqd_dtls.get("auth_group_desc");
		String mode =(String) pick_list_reqd_dtls.get("mode");
	
		HashMap map = new HashMap();
		map.put("group_type",group_type);
		map.put("req_group_code",req_group_code);
		map.put("auth_group_code",auth_group_code);
		map.put("noofunits",noofunits);
		map.put("description",description);
		map.put("available_qty",available_qty);
		map.put("auth_group_desc",auth_group_desc);
		map.put("mode",mode);
		displayFields.add(map);		
		return  map;
	}
}
