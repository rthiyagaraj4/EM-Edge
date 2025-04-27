/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------
06/04/2017				IN063878				Badmavathi B					        					 Unused variables
-------------------------------------------------------------------------------------------------------------------------------
*/
package ePO ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import ePO.Common.*;
import ePO.Common.PoAdapter;
import eCommon.SingleTableHandler.*;
import eCommon.Common.*;
import java.sql.*;
import javax.sql.*;

public class UserAccessForDOBean extends PoAdapter implements Serializable {

   
	//private String po_unit_code; Commented for unused variables IN063878
	private String user_id;
		
	private String do_order_create_allowed_yn ;
	private String do_order_finalize_allowed_yn ;
	private String do_order_cancel_allowed_yn ;
	private String do_order_delete_allowed_yn ;
	
	private String quot_order_create_allowed_yn ;
	private String quot_order_finalize_allowed_yn ;
	private String quot_order_cancel_allowed_yn ;
	private String quot_order_delete_allowed_yn ;

    


	
	public void setDo_order_create_allowed_yn(String do_order_create_allowed_yn) {
		 this.do_order_create_allowed_yn = checkForNull(do_order_create_allowed_yn,"N");
	}
	public String getDo_order_create_allowed_yn() {
		 return do_order_create_allowed_yn;
	}

	public void setDo_order_finalize_allowed_yn(String do_order_finalize_allowed_yn) {
		 this.do_order_finalize_allowed_yn = checkForNull(do_order_finalize_allowed_yn,"N");
	}
	public String getDo_order_finalize_allowed_yn() {
		 return do_order_finalize_allowed_yn;
	}

	public void setDo_order_cancel_allowed_yn(String do_order_cancel_allowed_yn) {
		 this.do_order_cancel_allowed_yn = checkForNull(do_order_cancel_allowed_yn,"N");
	}
	public String getDo_order_cancel_allowed_yn() {
		 return do_order_cancel_allowed_yn;
	}

	public void setDo_order_delete_allowed_yn(String do_order_delete_allowed_yn) {
		 this.do_order_delete_allowed_yn = checkForNull(do_order_delete_allowed_yn,"N");
	}
	public String getDo_order_delete_allowed_yn() {
		 return do_order_delete_allowed_yn;
	}

	public void setQuot_order_create_allowed_yn(String quot_order_create_allowed_yn) {
		 this.quot_order_create_allowed_yn = checkForNull(quot_order_create_allowed_yn,"N");
	}
	public String getQuot_order_create_allowed_yn() {
		 return quot_order_create_allowed_yn;
	}

	public void setQuot_order_finalize_allowed_yn(String quot_order_finalize_allowed_yn) {
		 this.quot_order_finalize_allowed_yn = checkForNull(quot_order_finalize_allowed_yn,"N");
	}
	public String getQuot_order_finalize_allowed_yn() {
		 return quot_order_finalize_allowed_yn;
	}

	public void setQuot_order_cancel_allowed_yn(String quot_order_cancel_allowed_yn) {
		 this.quot_order_cancel_allowed_yn = checkForNull(quot_order_cancel_allowed_yn,"N");
	}
	public String getQuot_order_cancel_allowed_yn() {
		 return quot_order_cancel_allowed_yn;
	}

	public void setQuot_order_delete_allowed_yn(String quot_order_delete_allowed_yn) {
		 this.quot_order_delete_allowed_yn = checkForNull(quot_order_delete_allowed_yn,"N");
	}
	public String getQuot_order_delete_allowed_yn() {
		 return quot_order_delete_allowed_yn;
	}




   /* setter and getter for User_id and Store_code */

	public void setUser_id(String user_id) {
		 this.user_id = user_id;
	}
    public String getUser_id()
	{
		return user_id;
	}


	public HashMap insert() {
		
		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alWhereData	=	new ArrayList()	;
		
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());

		hmResult.put( "result", new Boolean( false ) ) ;


		alInsertData.add(getUser_id());                        
		alInsertData.add(getDo_order_create_allowed_yn());
		alInsertData.add(getDo_order_finalize_allowed_yn());
		alInsertData.add(getDo_order_cancel_allowed_yn());
		alInsertData.add(getDo_order_delete_allowed_yn());
		alInsertData.add(getQuot_order_create_allowed_yn());
		alInsertData.add(getQuot_order_finalize_allowed_yn());
		alInsertData.add(getQuot_order_cancel_allowed_yn());
		alInsertData.add(getQuot_order_delete_allowed_yn());
		alInsertData.add(getLoginById());      //ADDED_BY_ID            
		alInsertData.add(getLoginAtWsNo());    //ADDED_AT_WS_NO         
		alInsertData.add(getLoginFacilityId());//ADDED_FACILITY_ID      
		alInsertData.add(getLoginById());      //MODIFIED_BY_ID         
		alInsertData.add(getLoginAtWsNo());    //MODIFIED_AT_WS_NO      
        alInsertData.add(getLoginFacilityId());//MODIFIED_FACILITY_ID   
		

		System.out.println("alInsertData==>"+alInsertData);
		
		alWhereData.add(user_id);
			

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "WhereData",			alWhereData		);
		hmTableData.put( "InsertData",			alInsertData	);
		hmTableData.put("LanguageData"			,LanguageData);
		
		hmSQLMap.put( "InsertSQL","INSERT INTO	PO_USER_FOR_DELVORD (USER_ID, DO_ALLOWED_YN, DO_APPROVE_ALLOWED_YN, DO_CANCEL_ALLOWED_YN, DO_DELETE_ALLOWED_YN, QUOT_ALLOWED_YN, QUOT_APPROVE_ALLOWED_YN, QUOT_CANCEL_ALLOWED_YN, QUOT_DELETE_ALLOWED_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)" );

		System.out.println("hmSQLMap==>"+hmSQLMap);

	//	hmSQLMap.put( "SelectSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_USER_ACCESS_FOR_STORE_COUNT"));
			
		return callSingleTableHandler(hmTableData, hmSQLMap, PoRepository.SINGLE_INSERT);
	
	}
  
	public HashMap modify() {
		
		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());

		hmResult.put( "result", new Boolean( false ) ) ;

		
		alModifyData.add(getDo_order_create_allowed_yn());
		alModifyData.add(getDo_order_finalize_allowed_yn());
		alModifyData.add(getDo_order_cancel_allowed_yn());
		alModifyData.add(getDo_order_delete_allowed_yn());
		alModifyData.add(getQuot_order_create_allowed_yn());
		alModifyData.add(getQuot_order_finalize_allowed_yn());
		alModifyData.add(getQuot_order_cancel_allowed_yn());
		alModifyData.add(getQuot_order_delete_allowed_yn());			
		    
		alModifyData.add(getLoginById());      //MODIFIED_BY_ID         
		alModifyData.add(getLoginAtWsNo());    //MODIFIED_AT_WS_NO      
        alModifyData.add(getLoginFacilityId());//MODIFIED_FACILITY_ID   

		alModifyData.add(getUser_id());                        
				
		System.out.println("alModifyData==>"+alModifyData);
		

		hmSQLMap.put("ModifySQL","UPDATE PO_USER_FOR_DELVORD	SET  DO_ALLOWED_YN = ?, DO_APPROVE_ALLOWED_YN = ?, DO_CANCEL_ALLOWED_YN = ?, DO_DELETE_ALLOWED_YN = ?, QUOT_ALLOWED_YN = ? , QUOT_APPROVE_ALLOWED_YN = ? , QUOT_CANCEL_ALLOWED_YN = ?, QUOT_DELETE_ALLOWED_YN = ? , MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?  WHERE USER_ID=?  ");

		System.out.println("hmSQLMap==>"+hmSQLMap);

		hmTableData.put("properties",getProperties());
		hmTableData.put("ModifyData",alModifyData);
		hmTableData.put("LanguageData",LanguageData);

		return callSingleTableHandler(hmTableData, hmSQLMap, PoRepository.SINGLE_UPDATE );
	}

	
	public void clear() {
		
				
		do_order_create_allowed_yn = "N";
		do_order_finalize_allowed_yn = "N";
		do_order_cancel_allowed_yn = "N";
		do_order_delete_allowed_yn = "N";
		quot_order_create_allowed_yn = "N";
		quot_order_finalize_allowed_yn = "N";
		quot_order_cancel_allowed_yn = "N";
		quot_order_delete_allowed_yn = "N";
	}

    /* Over-ridden Adapter methods starts here */

	public void setAll(Hashtable htRecordSet){
		super.setAll(htRecordSet);

		setDo_order_create_allowed_yn((String) htRecordSet.get("do_order_create_allowed_yn"));
		setDo_order_finalize_allowed_yn((String) htRecordSet.get("do_order_finalize_allowed_yn"));
		setDo_order_cancel_allowed_yn((String) htRecordSet.get("do_order_cancel_allowed_yn"));
		setDo_order_delete_allowed_yn((String) htRecordSet.get("do_order_delete_allowed_yn"));
		setQuot_order_create_allowed_yn((String) htRecordSet.get("quot_order_create_allowed_yn"));
		setQuot_order_finalize_allowed_yn((String) htRecordSet.get("quot_order_finalize_allowed_yn"));
		setQuot_order_cancel_allowed_yn((String) htRecordSet.get("quot_order_cancel_allowed_yn"));
		setQuot_order_delete_allowed_yn((String) htRecordSet.get("quot_order_delete_allowed_yn"));

	}
	/* Over-ridden Adapter methods end here */


	/* Function specific methods start */

	public void loadData() {
			
		String []stParameters		=	{getUser_id()};
		HashMap hmRecord	=	null;
		try
		{
		hmRecord	=	fetchRecord("SELECT USER_ID,DO_ALLOWED_YN,DO_APPROVE_ALLOWED_YN,DO_CANCEL_ALLOWED_YN,DO_DELETE_ALLOWED_YN, QUOT_ALLOWED_YN , QUOT_APPROVE_ALLOWED_YN , QUOT_CANCEL_ALLOWED_YN , QUOT_DELETE_ALLOWED_YN  FROM	PO_USER_FOR_DELVORD WHERE USER_ID = ?  ", stParameters);

		System.out.println("stParameters-=-=-=-="+ stParameters);
		System.out.println("hmRecord-=-=-=-="+ hmRecord);

		}
		
		catch (Exception e)
		{
		}
		
		
		setUser_id                 ((String) hmRecord.get("USER_ID"));
		setDo_order_create_allowed_yn          ((String) hmRecord.get("DO_ALLOWED_YN"));       
		setDo_order_finalize_allowed_yn          ((String) hmRecord.get("DO_APPROVE_ALLOWED_YN"));       
		setDo_order_cancel_allowed_yn          ((String) hmRecord.get("DO_CANCEL_ALLOWED_YN")); 
		setDo_order_delete_allowed_yn          ((String) hmRecord.get("DO_DELETE_ALLOWED_YN"));
		setQuot_order_create_allowed_yn          ((String) hmRecord.get("QUOT_ALLOWED_YN"));       
		setQuot_order_finalize_allowed_yn          ((String) hmRecord.get("QUOT_APPROVE_ALLOWED_YN"));       
		setQuot_order_cancel_allowed_yn          ((String) hmRecord.get("QUOT_CANCEL_ALLOWED_YN")); 
		setQuot_order_delete_allowed_yn          ((String) hmRecord.get("QUOT_DELETE_ALLOWED_YN"));
		
	}

    /* To retrive value for check boxes whether checked/unchecked according to the accessibitity
	   given in the st_user_access_for_store table */

	   	public HashMap getUserAccessForDOData() {
		try { 
			  String []stParameters		=	{getUser_id()};

		  return 	fetchRecord("SELECT USER_ID,DO_ALLOWED_YN,DO_APPROVE_ALLOWED_YN,DO_CANCEL_ALLOWED_YN,DO_DELETE_ALLOWED_YN , QUOT_ALLOWED_YN , QUOT_APPROVE_ALLOWED_YN , QUOT_CANCEL_ALLOWED_YN , QUOT_DELETE_ALLOWED_YN    FROM	PO_USER_FOR_DELVORD WHERE USER_ID = ? ", stParameters);
		  
	

		}

	
		catch (Exception exception) {
		
			exception.printStackTrace();
		}
		return null;
	}


   /* To initialize for the checkboxes according to the value retrived */

	public void initialize(HashMap hmRecord){
		

		setDo_order_create_allowed_yn((String) hmRecord.get("DO_ALLOWED_YN"));
		setDo_order_finalize_allowed_yn((String) hmRecord.get("DO_APPROVE_ALLOWED_YN"));
		setDo_order_cancel_allowed_yn((String) hmRecord.get("DO_CANCEL_ALLOWED_YN"));
		setDo_order_delete_allowed_yn          ((String) hmRecord.get("DO_DELETE_ALLOWED_YN"));
		
		setQuot_order_create_allowed_yn((String) hmRecord.get("QUOT_ALLOWED_YN"));
		setQuot_order_finalize_allowed_yn((String) hmRecord.get("QUOT_APPROVE_ALLOWED_YN"));
		setQuot_order_cancel_allowed_yn((String) hmRecord.get("QUOT_CANCEL_ALLOWED_YN"));
		setQuot_order_delete_allowed_yn          ((String) hmRecord.get("QUOT_DELETE_ALLOWED_YN"));
	
	}
   

	
	
}
