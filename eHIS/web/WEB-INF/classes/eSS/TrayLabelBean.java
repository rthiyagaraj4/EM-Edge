/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;

import eSS.Common.* ;

public class TrayLabelBean extends SsAdapter implements Serializable {

	private String to_group_code;
	private String to_tray_no;
	private String to_curr_store_code;
	private String from_curr_store_code;
	private String to_owner_store_code;
	private String from_owner_store_code;
	private String from_tray_no;
	private String from_group_code;

	public void setTo_group_code(String to_group_code) {
		 this.to_group_code = to_group_code.toUpperCase();
	}

	public String getTo_group_code( ) {
		 return to_group_code;
	}

	public void setTo_tray_no(String to_tray_no) {
		 this.to_tray_no = to_tray_no;
	}

	public String getTo_tray_no( ) {
		 return to_tray_no;
	}

	public void setTo_curr_store_code(String to_curr_store_code) {
		 this.to_curr_store_code = to_curr_store_code.toUpperCase();
	}

	public String getTo_curr_store_code( ) {
		 return to_curr_store_code;
	}

	public void setFrom_curr_store_code(String from_curr_store_code) {
		 this.from_curr_store_code = from_curr_store_code.toUpperCase();
	}

	public String getFrom_curr_store_code( ) {
		 return from_curr_store_code;
	}

	public void setTo_owner_store_code(String to_owner_store_code) {
		 this.to_owner_store_code = to_owner_store_code.toUpperCase();
	}

	public String getTo_owner_store_code( ) {
		 return to_owner_store_code;
	}

	public void setFrom_owner_store_code(String from_owner_store_code) {
		 this.from_owner_store_code = from_owner_store_code.toUpperCase();
	}

	public String getFrom_owner_store_code( ) {
		 return from_owner_store_code;
	}

	public void setFrom_tray_no(String from_tray_no) {
		 this.from_tray_no = from_tray_no;
	}

	public String getFrom_tray_no( ) {
		 return from_tray_no;
	}

	public void setFrom_group_code(String from_group_code) {
		 this.from_group_code = from_group_code.toUpperCase();
	}

	public String getFrom_group_code( ) {
		 return from_group_code;
	}

	public void setAll(Hashtable htRecordSet){
		super.setAll(htRecordSet);
		setTo_group_code((String) htRecordSet.get("to_group_code"));
		setTo_tray_no((String) htRecordSet.get("to_tray_no"));
		setTo_curr_store_code((String) htRecordSet.get("to_curr_store_code"));
		setFrom_curr_store_code((String) htRecordSet.get("from_curr_store_code"));
		setTo_owner_store_code((String) htRecordSet.get("to_owner_store_code"));
		setFrom_owner_store_code((String) htRecordSet.get("from_owner_store_code"));
		setFrom_tray_no((String) htRecordSet.get("from_tray_no"));
		setFrom_group_code((String) htRecordSet.get("from_group_code"));
	}

	public void clear(){
		super.clear();
		to_group_code="";
		to_tray_no="";
		to_curr_store_code="";
		from_curr_store_code="";
		to_owner_store_code="";
		from_owner_store_code="";
		from_tray_no="";
		from_group_code="";
	}

	/* Over-ridden Adapter methods start here */
	public HashMap validate() {
		HashMap hmReturn	=	getMessageHashMap(true);
		try { 
			if (!(getFrom_owner_store_code().equals("")||getTo_owner_store_code().equals(""))) 
				if (getFrom_owner_store_code().compareTo(getTo_owner_store_code())>0) {
					throw new Exception(getFromToValidateMessage("Owner Store"));
				}
			if (!(getFrom_curr_store_code().equals("")||getTo_curr_store_code().equals(""))) 
				if (getFrom_curr_store_code().compareTo(getTo_curr_store_code())>0) {
					throw new Exception(getFromToValidateMessage("Current Store"));
				}
			if (!(getFrom_group_code().equals("")||getTo_group_code().equals(""))) 
				if (getFrom_group_code().compareTo(getTo_group_code())>0) {
					throw new Exception(getFromToValidateMessage("Group"));
				}
			if (!(getFrom_tray_no().equals("")||getTo_tray_no().equals(""))) 
				if (Long.parseLong(getFrom_tray_no())>Long.parseLong(getTo_tray_no()) ) {
					throw new Exception(getFromToValidateMessage("Tray No"));
				}
		}
		catch (Exception exception) {
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MESSAGE,exception.getMessage());
//			hmReturn.put(MESSAGE,exception.toString());
			exception.printStackTrace();
		}
		return hmReturn;
	}

	public HashMap modify() {
		HashMap		hmReturn	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;

		alModifyData.add(getLoginById()				);
		alModifyData.add(getLoginAtWsNo()			);
		alModifyData.add(getLoginFacilityId()		);

		alModifyData.add( checkForNull(getFrom_owner_store_code(), " ")	);
		alModifyData.add( checkForNull(getTo_owner_store_code(), "~~~~~~")	);
		alModifyData.add( checkForNull(getFrom_curr_store_code(), " ")	);
		alModifyData.add( checkForNull(getTo_curr_store_code(), "~~~~~~")	);
		alModifyData.add( checkForNull(getFrom_group_code(), " ")	);
		alModifyData.add( checkForNull(getTo_group_code(), "~~~~~~~~~~")	);
		alModifyData.add( new Long(checkForNull(getFrom_tray_no(), "0"))	);
		alModifyData.add( new Long(checkForNull(getTo_tray_no(), "999999999999"))	);

		hmTableData.put	( "properties",getProperties());
		hmTableData.put	( "ModifyData",alModifyData);
		hmSQLMap.put	( "ModifySQL", getSsRepositoryValue("SQL_SS_TRAY_DTLS_UPDATE_FOR_EXP_MGMT"));

		hmReturn	=	singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE );
//		//System.err.println("hmReturn"+hmReturn);
		if(hmReturn.get(MSGID).toString().equals("")){
			hmReturn.put(MSGID,"NO_RECORD_UPDATED");
		}
		return hmReturn;
	}
} 
