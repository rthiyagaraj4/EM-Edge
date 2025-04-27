/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
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

public class UserPurchaseUnitAccessForTransactionsBean extends PoAdapter implements Serializable {

   
	private String po_unit_code;
	private String user_id;
	private String user_store_access_appl;
	private String user_store_access_list;
	
	
	private String pur_req_create_allowed_yn ;
	private String pur_req_finalize_allowed_yn ;
	private String pur_req_amend_allowed_yn ;
	private String pur_req_cancel_allowed_yn ;
	private String pur_req_delete_allowed_yn ;

	private String pur_order_create_allowed_yn ;
	private String pur_order_finalize_allowed_yn ;
	private String pur_order_amend_allowed_yn ;
	private String pur_order_cancel_allowed_yn ;
	private String pur_order_delete_allowed_yn ;
	
	//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 30-MAY-2013
	private String tndr_create_allowed_yn ;
	private String tndr_finalize_allowed_yn ;
	private String tndr_cancel_allowed_yn ;
	private String tndr_delete_allowed_yn ;

    


	public void setPur_req_create_allowed_yn(String pur_req_create_allowed_yn) {
		 this.pur_req_create_allowed_yn = checkForNull(pur_req_create_allowed_yn,"N");
	}
	public String getPur_req_create_allowed_yn() {
		 return pur_req_create_allowed_yn;
	}

	public void setPur_req_finalize_allowed_yn(String pur_req_finalize_allowed_yn) {
		 this.pur_req_finalize_allowed_yn = checkForNull(pur_req_finalize_allowed_yn,"N");
	}
	public String getPur_req_finalize_allowed_yn() {
		 return pur_req_finalize_allowed_yn;
	}

	public void setPur_req_amend_allowed_yn(String pur_req_amend_allowed_yn) {
		 this.pur_req_amend_allowed_yn = checkForNull(pur_req_amend_allowed_yn,"N");
	}
	public String getPur_req_amend_allowed_yn() {
		 return pur_req_amend_allowed_yn;
	}

	public void setPur_req_cancel_allowed_yn(String pur_req_cancel_allowed_yn) {
		 this.pur_req_cancel_allowed_yn = checkForNull(pur_req_cancel_allowed_yn,"N");
	}
	public String getPur_req_cancel_allowed_yn() {
		 return pur_req_cancel_allowed_yn;
	}

	public void setPur_order_create_allowed_yn(String pur_order_create_allowed_yn) {
		 this.pur_order_create_allowed_yn = checkForNull(pur_order_create_allowed_yn,"N");
	}
	public String getPur_order_create_allowed_yn() {
		 return pur_order_create_allowed_yn;
	}

	public void setPur_order_finalize_allowed_yn(String pur_order_finalize_allowed_yn) {
		 this.pur_order_finalize_allowed_yn = checkForNull(pur_order_finalize_allowed_yn,"N");
	}
	public String getPur_order_finalize_allowed_yn() {
		 return pur_order_finalize_allowed_yn;
	}

	public void setPur_order_amend_allowed_yn(String pur_order_amend_allowed_yn) {
		 this.pur_order_amend_allowed_yn = checkForNull(pur_order_amend_allowed_yn,"N");
	}
	public String getPur_order_amend_allowed_yn() {
		 return pur_order_amend_allowed_yn;
	}

	public void setPur_order_cancel_allowed_yn(String pur_order_cancel_allowed_yn) {
		 this.pur_order_cancel_allowed_yn = checkForNull(pur_order_cancel_allowed_yn,"N");
	}
	public String getPur_order_cancel_allowed_yn() {
		 return pur_order_cancel_allowed_yn;
	}

	public void setPur_order_delete_allowed_yn(String pur_order_delete_allowed_yn) {
		 this.pur_order_delete_allowed_yn = checkForNull(pur_order_delete_allowed_yn,"N");
	}
	public String getPur_order_delete_allowed_yn() {
		 return pur_order_delete_allowed_yn;
	}

	public void setPur_req_delete_allowed_yn(String pur_req_delete_allowed_yn) {
		 this.pur_req_delete_allowed_yn = checkForNull(pur_req_delete_allowed_yn,"N");
	}
	public String getPur_req_delete_allowed_yn() {
		 return pur_req_delete_allowed_yn;
	}

	public void setUser_id(String user_id) {
		 this.user_id = user_id;
	}
    public String getUser_id()
	{
		return user_id;
	}

	public void setPo_unit_code(String po_unit_code) {
		 this.po_unit_code = po_unit_code;
	}
	public String getPo_unit_code( ) {
		 return po_unit_code;
	}

	public void setUser_store_access_appl(String user_store_access_appl) {
		 this.user_store_access_appl = checkForNull(user_store_access_appl,"N");
	}
	public String getUser_store_access_appl( ) {
		 return user_store_access_appl;
	}

	public void setUser_store_access_list(String user_store_access_list) {
		 this.user_store_access_list = user_store_access_list;
	}
	public String getUser_store_access_list( ) {
		 return user_store_access_list;
	}

	//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 30-MAY-2013
	public void setTndr_finalize_allowed_yn(String tndr_finalize_allowed_yn) {
		 this.tndr_finalize_allowed_yn = checkForNull(tndr_finalize_allowed_yn,"N");
	}
	public String getTndr_finalize_allowed_yn() {
		 return tndr_finalize_allowed_yn;
	}
	
	public void setTndr_create_allowed_yn(String tndr_create_allowed_yn) {
		 this.tndr_create_allowed_yn = checkForNull(tndr_create_allowed_yn,"N");
	}
	public String getTndr_create_allowed_yn() {
		 return tndr_create_allowed_yn;
	}
	
	public void setTndr_cancel_allowed_yn(String tndr_cancel_allowed_yn) {
		 this.tndr_cancel_allowed_yn = checkForNull(tndr_cancel_allowed_yn,"N");
	}
	public String getTndr_cancel_allowed_yn() {
		 return tndr_cancel_allowed_yn;
	}

	public void setTndr_delete_allowed_yn(String tndr_delete_allowed_yn) {
		 this.tndr_delete_allowed_yn = checkForNull(tndr_delete_allowed_yn,"N");
	}
	public String getTndr_delete_allowed_yn() {
		 return tndr_delete_allowed_yn;
	}
	 
	//ends


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
		alInsertData.add(getPo_unit_code());
		alInsertData.add(getUser_store_access_appl());
		alInsertData.add(getUser_store_access_list());

		alInsertData.add(getPur_req_create_allowed_yn());
		alInsertData.add(getPur_req_finalize_allowed_yn());
		alInsertData.add(getPur_req_cancel_allowed_yn());
		alInsertData.add(getPur_order_create_allowed_yn());
		alInsertData.add(getPur_order_finalize_allowed_yn());
		alInsertData.add(getPur_order_amend_allowed_yn());
		alInsertData.add(getPur_order_cancel_allowed_yn());

		alInsertData.add(getPur_req_delete_allowed_yn());
		alInsertData.add(getPur_order_delete_allowed_yn());
		//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 30-MAY-2013
		alInsertData.add(getTndr_create_allowed_yn());
		alInsertData.add(getTndr_finalize_allowed_yn());
		alInsertData.add(getTndr_cancel_allowed_yn());
		alInsertData.add(getTndr_delete_allowed_yn());	
	   //ends
				
		alInsertData.add(getLoginById());      //ADDED_BY_ID            
		alInsertData.add(getLoginAtWsNo());    //ADDED_AT_WS_NO         
		alInsertData.add(getLoginFacilityId());//ADDED_FACILITY_ID      
		alInsertData.add(getLoginById());      //MODIFIED_BY_ID         
		alInsertData.add(getLoginAtWsNo());    //MODIFIED_AT_WS_NO      
        alInsertData.add(getLoginFacilityId());//MODIFIED_FACILITY_ID   
		
		alWhereData.add(user_id);
		alWhereData.add(po_unit_code);
	

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "WhereData",			alWhereData		);
		hmTableData.put( "InsertData",			alInsertData	);
		hmTableData.put("LanguageData"			,LanguageData);
		
		//hmSQLMap.put( "InsertSQL","INSERT INTO	PO_USER_FOR_PUNIT (USER_ID,PUR_UNIT_CODE,USER_STORE_ACCESS_YN,DFLT_STORE_CODE,REQ_ALLOWED_YN,REQ_APPROVE_ALLOWED_YN, REQ_CANCEL_ALLOWED_YN,PO_ALLOWED_YN,PO_APPROVE_ALLOWED_YN,PO_AMEND_ALLOWED_YN,PO_CANCEL_ALLOWED_YN,REQ_DELETE_ALLOWED_YN,PO_DELETE_ALLOWED_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?, ?,?,?,?, ?, ?, ?, ?, ?, ?, ?,?,?,SYSDATE, ?, ?, ?, SYSDATE, ?, ?)" );
		//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 30-MAY-2013
		hmSQLMap.put( "InsertSQL","INSERT INTO	PO_USER_FOR_PUNIT (USER_ID,PUR_UNIT_CODE,USER_STORE_ACCESS_YN,DFLT_STORE_CODE,REQ_ALLOWED_YN,REQ_APPROVE_ALLOWED_YN, REQ_CANCEL_ALLOWED_YN,PO_ALLOWED_YN,PO_APPROVE_ALLOWED_YN,PO_AMEND_ALLOWED_YN,PO_CANCEL_ALLOWED_YN,REQ_DELETE_ALLOWED_YN,PO_DELETE_ALLOWED_YN,TNDR_ALLOWED_YN,TNDR_APPROVE_ALLOWED_YN,TNDR_CANCEL_ALLOWED_YN,TNDR_DELETE_ALLOWED_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?, ?,?,?,?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,SYSDATE, ?, ?, ?, SYSDATE, ?, ?)" );

		hmSQLMap.put( "SelectSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_USER_ACCESS_FOR_STORE_COUNT"));
			
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
	
		alModifyData.add(getUser_store_access_appl());
		alModifyData.add(getUser_store_access_list());
		alModifyData.add(getPur_req_create_allowed_yn());
		alModifyData.add(getPur_req_finalize_allowed_yn());
		alModifyData.add(getPur_req_cancel_allowed_yn());
		alModifyData.add(getPur_order_create_allowed_yn());
		alModifyData.add(getPur_order_finalize_allowed_yn());
		alModifyData.add(getPur_order_amend_allowed_yn());
		alModifyData.add(getPur_order_cancel_allowed_yn());
		alModifyData.add(getPur_req_delete_allowed_yn());
		alModifyData.add(getPur_order_delete_allowed_yn());	
        //Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 30-MAY-2013
        alModifyData.add(getTndr_create_allowed_yn());
	    alModifyData.add(getTndr_finalize_allowed_yn());
		alModifyData.add(getTndr_cancel_allowed_yn());
		alModifyData.add(getTndr_delete_allowed_yn());			
		    
		alModifyData.add(getLoginById());      //MODIFIED_BY_ID         
		alModifyData.add(getLoginAtWsNo());    //MODIFIED_AT_WS_NO      
        alModifyData.add(getLoginFacilityId());//MODIFIED_FACILITY_ID   

		alModifyData.add(getUser_id());                        
		alModifyData.add(getPo_unit_code());

		//hmSQLMap.put("ModifySQL","UPDATE PO_USER_FOR_PUNIT	SET  USER_STORE_ACCESS_YN=?, DFLT_STORE_CODE=?, REQ_ALLOWED_YN=?,REQ_APPROVE_ALLOWED_YN=?,REQ_CANCEL_ALLOWED_YN=?, PO_ALLOWED_YN=?,PO_APPROVE_ALLOWED_YN=?,PO_AMEND_ALLOWED_YN=?,PO_CANCEL_ALLOWED_YN=?,REQ_DELETE_ALLOWED_YN=?,PO_DELETE_ALLOWED_YN=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?  WHERE USER_ID=? AND PUR_UNIT_CODE=?  ");
		//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 27-MAY-2013
		hmSQLMap.put("ModifySQL","UPDATE PO_USER_FOR_PUNIT	SET  USER_STORE_ACCESS_YN=?, DFLT_STORE_CODE=?, REQ_ALLOWED_YN=?,REQ_APPROVE_ALLOWED_YN=?,REQ_CANCEL_ALLOWED_YN=?, PO_ALLOWED_YN=?,PO_APPROVE_ALLOWED_YN=?,PO_AMEND_ALLOWED_YN=?,PO_CANCEL_ALLOWED_YN=?,REQ_DELETE_ALLOWED_YN=?,PO_DELETE_ALLOWED_YN=?,TNDR_ALLOWED_YN = ?,TNDR_APPROVE_ALLOWED_YN = ?,TNDR_CANCEL_ALLOWED_YN = ?,TNDR_DELETE_ALLOWED_YN = ?, MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?  WHERE USER_ID=? AND PUR_UNIT_CODE=?  ");

		hmTableData.put("properties",getProperties());
		hmTableData.put("ModifyData",alModifyData);
		hmTableData.put("LanguageData",LanguageData);

		return callSingleTableHandler(hmTableData, hmSQLMap, PoRepository.SINGLE_UPDATE );
	}

	
	public void clear() {
		
		pur_req_create_allowed_yn = "N";
		pur_req_finalize_allowed_yn = "N";
		pur_req_amend_allowed_yn = "N";
		pur_req_cancel_allowed_yn = "N";
		pur_req_delete_allowed_yn = "N";
		pur_order_create_allowed_yn = "N";
		pur_order_finalize_allowed_yn = "N";
		pur_order_amend_allowed_yn = "N";
		pur_order_cancel_allowed_yn = "N";
		user_store_access_appl		= "N";
		user_store_access_list	= "";
		pur_order_delete_allowed_yn = "N";
		//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 30-MAY-2013
		tndr_create_allowed_yn = "N";
        tndr_finalize_allowed_yn = "N";
        tndr_cancel_allowed_yn = "N";
        tndr_delete_allowed_yn = "N";
	}

    /* Over-ridden Adapter methods starts here */

	public void setAll(Hashtable htRecordSet){
		super.setAll(htRecordSet);

		setUser_store_access_appl((String) htRecordSet.get("user_store_access_appl"));
		setUser_store_access_list((String) htRecordSet.get("user_store_access_list"));
		setPur_req_create_allowed_yn((String) htRecordSet.get("pur_req_create_allowed_yn"));
		setPur_req_finalize_allowed_yn((String) htRecordSet.get("pur_req_finalize_allowed_yn"));
		setPur_req_cancel_allowed_yn((String) htRecordSet.get("pur_req_cancel_allowed_yn"));
		setPur_order_create_allowed_yn((String) htRecordSet.get("pur_order_create_allowed_yn"));
		setPur_order_finalize_allowed_yn((String) htRecordSet.get("pur_order_finalize_allowed_yn"));
		setPur_order_amend_allowed_yn((String) htRecordSet.get("pur_order_amend_allowed_yn"));
		setPur_order_cancel_allowed_yn((String) htRecordSet.get("pur_order_cancel_allowed_yn"));
		setPur_req_delete_allowed_yn((String) htRecordSet.get("pur_req_delete_allowed_yn"));
		setPur_order_delete_allowed_yn((String) htRecordSet.get("pur_order_delete_allowed_yn"));
		//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 30-MAY-2013
		setTndr_create_allowed_yn((String) htRecordSet.get("tndr_create_allowed_yn"));
		setTndr_finalize_allowed_yn((String) htRecordSet.get("tndr_finalize_allowed_yn"));
		setTndr_cancel_allowed_yn((String) htRecordSet.get("tndr_cancel_allowed_yn"));
		setTndr_delete_allowed_yn((String) htRecordSet.get("tndr_delete_allowed_yn"));


	}
	/* Over-ridden Adapter methods end here */


	/* Function specific methods start */

	public void loadData() {
			
		String []stParameters		=	{getUser_id(), getPo_unit_code()};
		HashMap hmRecord	=	null;
		try
		{
			//hmRecord	=	fetchRecord("SELECT USER_ID,PUR_UNIT_CODE,USER_STORE_ACCESS_YN,DFLT_STORE_CODE,REQ_ALLOWED_YN,REQ_APPROVE_ALLOWED_YN,REQ_CANCEL_ALLOWED_YN, PO_ALLOWED_YN,PO_APPROVE_ALLOWED_YN,PO_AMEND_ALLOWED_YN,PO_CANCEL_ALLOWED_YN,REQ_DELETE_ALLOWED_YN,PO_DELETE_ALLOWED_YN,TNDR_ALLOWED_YN,TNDR_APPROVE_ALLOWED_YN,TNDR_CANCEL_ALLOWED_YN,TNDR_DELETE_ALLOWED_YN   FROM	PO_USER_FOR_PUNIT WHERE USER_ID = ? AND PUR_UNIT_CODE =? ", stParameters);
			//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 27-MAY-2013
			hmRecord	=	fetchRecord("SELECT USER_ID,PUR_UNIT_CODE,USER_STORE_ACCESS_YN,DFLT_STORE_CODE,REQ_ALLOWED_YN,REQ_APPROVE_ALLOWED_YN,REQ_CANCEL_ALLOWED_YN, PO_ALLOWED_YN,PO_APPROVE_ALLOWED_YN,PO_AMEND_ALLOWED_YN,PO_CANCEL_ALLOWED_YN,REQ_DELETE_ALLOWED_YN,PO_DELETE_ALLOWED_YN,TNDR_ALLOWED_YN,TNDR_APPROVE_ALLOWED_YN,TNDR_CANCEL_ALLOWED_YN,TNDR_DELETE_ALLOWED_YN  FROM	PO_USER_FOR_PUNIT WHERE USER_ID = ? AND PUR_UNIT_CODE =? ", stParameters);
		}		
		catch (Exception e)
		{		
		e.printStackTrace();	
		//System.err.println("stParameters-=-=-=-="+ stParameters);
		}
		
		
		setPo_unit_code              ((String) hmRecord.get("PUR_UNIT_CODE"));           
		setUser_id                 ((String) hmRecord.get("USER_ID"));
		setUser_store_access_appl                 ((String) hmRecord.get("USER_STORE_ACCESS_YN"));
		setUser_store_access_list                 ((String) hmRecord.get("DFLT_STORE_CODE"));
		
		setPur_req_create_allowed_yn          ((String) hmRecord.get("REQ_ALLOWED_YN"));       
		setPur_req_finalize_allowed_yn          ((String) hmRecord.get("REQ_APPROVE_ALLOWED_YN"));       
		setPur_req_cancel_allowed_yn          ((String) hmRecord.get("REQ_CANCEL_ALLOWED_YN"));       
		setPur_order_create_allowed_yn          ((String) hmRecord.get("PO_ALLOWED_YN"));       
		setPur_order_finalize_allowed_yn          ((String) hmRecord.get("PO_APPROVE_ALLOWED_YN"));       
		setPur_order_amend_allowed_yn          ((String) hmRecord.get("PO_AMEND_ALLOWED_YN"));       
		setPur_order_cancel_allowed_yn          ((String) hmRecord.get("PO_CANCEL_ALLOWED_YN")); 
		
		setPur_req_delete_allowed_yn          ((String) hmRecord.get("REQ_DELETE_ALLOWED_YN"));
		setPur_order_delete_allowed_yn          ((String) hmRecord.get("PO_DELETE_ALLOWED_YN"));
		//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 27-MAY-2013
		setTndr_create_allowed_yn          ((String) hmRecord.get("TNDR_ALLOWED_YN"));
		setTndr_finalize_allowed_yn          ((String) hmRecord.get("TNDR_APPROVE_ALLOWED_YN"));
		setTndr_cancel_allowed_yn          ((String) hmRecord.get("TNDR_CANCEL_ALLOWED_YN"));
		setTndr_delete_allowed_yn          ((String) hmRecord.get("TNDR_DELETE_ALLOWED_YN"));
		
	}

    /* To retrive value for check boxes whether checked/unchecked according to the accessibitity
	   given in the st_user_access_for_store table */

	public HashMap getUserAccessForPounitData() {
		try { 
		  
		  String []stParameters		=	{getUser_id(), getPo_unit_code()};

		  return 	fetchRecord("SELECT USER_ID,PUR_UNIT_CODE,USER_STORE_ACCESS_YN,DFLT_STORE_CODE,REQ_ALLOWED_YN,REQ_APPROVE_ALLOWED_YN,REQ_CANCEL_ALLOWED_YN, PO_ALLOWED_YN,PO_APPROVE_ALLOWED_YN,PO_AMEND_ALLOWED_YN,PO_CANCEL_ALLOWED_YN,REQ_DELETE_ALLOWED_YN,PO_DELETE_ALLOWED_YN,TNDR_ALLOWED_YN,TNDR_APPROVE_ALLOWED_YN,TNDR_CANCEL_ALLOWED_YN,TNDR_DELETE_ALLOWED_YN   FROM	PO_USER_FOR_PUNIT WHERE USER_ID = ? AND PUR_UNIT_CODE =? ", stParameters);
		  
		}

	
		catch (Exception exception) {
		
			exception.printStackTrace();
		}
		return null;
	}


   /* To initialize for the checkboxes according to the value retrived */

	public void initialize(HashMap hmRecord){	

		setUser_store_access_appl((String) hmRecord.get("USER_STORE_ACCESS_YN"));
		setUser_store_access_list((String) hmRecord.get("DFLT_STORE_CODE"));
		setPur_req_create_allowed_yn((String) hmRecord.get("REQ_ALLOWED_YN"));
		setPur_req_finalize_allowed_yn((String) hmRecord.get("REQ_APPROVE_ALLOWED_YN"));
		setPur_req_cancel_allowed_yn((String) hmRecord.get("REQ_CANCEL_ALLOWED_YN"));
		setPur_order_create_allowed_yn((String) hmRecord.get("PO_ALLOWED_YN"));
		setPur_order_finalize_allowed_yn((String) hmRecord.get("PO_APPROVE_ALLOWED_YN"));
		setPur_order_amend_allowed_yn((String) hmRecord.get("PO_AMEND_ALLOWED_YN"));
		setPur_order_cancel_allowed_yn((String) hmRecord.get("PO_CANCEL_ALLOWED_YN"));
		setPur_req_delete_allowed_yn((String) hmRecord.get("REQ_DELETE_ALLOWED_YN"));
		setPur_order_delete_allowed_yn((String) hmRecord.get("PO_DELETE_ALLOWED_YN"));
		//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 30-MAY-2013
		setTndr_create_allowed_yn((String) hmRecord.get("TNDR_ALLOWED_YN"));
		setTndr_finalize_allowed_yn((String) hmRecord.get("TNDR_APPROVE_ALLOWED_YN"));
		setTndr_cancel_allowed_yn((String) hmRecord.get("TNDR_CANCEL_ALLOWED_YN"));
		setTndr_delete_allowed_yn((String) hmRecord.get("TNDR_DELETE_ALLOWED_YN"));
	
	}
   

public ArrayList getPounitList() throws Exception{

		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;

		ArrayList	arrPOUNIT		=	new  ArrayList();
		HashMap		hmPOUNIT		=	null;	

		try {
				connection = getConnection();
				pstmt = connection.prepareStatement(PoRepository.getPoKeyValue( "SQL_PO_STORE_SELECT_LIST_ACROSS_FCY"));
				pstmt.setString(1,getLanguageId());
				pstmt.setString(2,getLoginFacilityId());
				
				resultSet = pstmt.executeQuery();
				
				while ((resultSet != null) && (resultSet.next()))
				{
					hmPOUNIT	=	new HashMap();
					hmPOUNIT.put("code",checkForNull(resultSet.getString(1)));
					hmPOUNIT.put("desc",checkForNull(resultSet.getString(2)));
					arrPOUNIT.add(hmPOUNIT);
				}
			}
		catch (Exception e )
		{
				e.printStackTrace();
				throw e;
		} 
		finally
		{
		 try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) 
			{
			es.printStackTrace();
			}
		}
			return arrPOUNIT;
}

	public String getUserAccessForStoreList(String defaultValue) {
		
		return  getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_USER_ACCESS_FOR_STORE_YN"),getUser_id()), getUser_store_access_list());
	}
	
}
