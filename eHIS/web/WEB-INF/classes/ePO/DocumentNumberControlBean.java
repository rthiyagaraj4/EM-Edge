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
import java.sql.*;
import javax.sql.*;
import eCommon.Common.*;

public class DocumentNumberControlBean extends PoAdapter implements Serializable { 

	
	private String pr_year_yn;
	private String pr_year;
	private String pr_facility_yn;
	private String pr_purunit_yn;
	private String pr_start_no;
	private String pr_next_no;
	private String pr_auto;

	private String po_year_yn;
	private String po_year;
	private String po_facility_yn;
	private String po_purunit_yn;
	private String po_start_no;
	private String po_next_no;
	private String po_auto;
	
	private String do_year_yn;
	private String do_year;
	private String do_facility_yn;
	private String do_purunit_yn;
	private String do_start_no;
	private String do_next_no;
	private String do_auto;
	
	private String quot_year_yn;
	private String quot_year;
	private String quot_facility_yn;
	private String quot_purunit_yn;
	private String quot_start_no;
	private String quot_next_no;
	private String quot_auto;

	//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 30-MAY-2013
    private String tndr_year_yn;   
	private String tndr_year;
	private String tndr_facility_yn;
	//private String tndr_purunit_yn;
	private String tndr_start_no;
	private String tndr_next_no;
	private String tndr_auto;
	//ends
		
	
	public void setPr_year_yn(String pr_year_yn) {
		 this.pr_year_yn = checkForNull(pr_year_yn,"N"); 
	}

	public String getPr_year_yn( ) {
		 return pr_year_yn;
	}

	public void setPr_year(String pr_year) {
		 this.pr_year = checkForNull(pr_year); 
	}

	public String getPr_year( ) {
		 return pr_year;
	}
	
	public void setPr_facility_yn(String pr_facility_yn) {
		 this.pr_facility_yn = checkForNull(pr_facility_yn,"N"); 
	}

	public String getPr_facility_yn( ) {
		 return pr_facility_yn;
	}
	
	public void setPr_purunit_yn(String pr_purunit_yn) {
		 this.pr_purunit_yn = checkForNull(pr_purunit_yn,"N"); 
	}

	public String getPr_purunit_yn( ) {
		 return pr_purunit_yn;
	}

	public void setPr_start_no(String pr_start_no) {
		 this.pr_start_no = checkForNull(pr_start_no); 
	}

	public String getPr_start_no( ) {
		 return pr_start_no;
	}

		public void setPr_next_no(String pr_next_no) {
		 this.pr_next_no = checkForNull(pr_next_no); 
	}

	public String getPr_next_no( ) {
		 return pr_next_no;
	}

		public void setPr_auto(String pr_auto) {
		 this.pr_auto = checkForNull(pr_auto); 
	}

	public String getPr_auto( ) {
		 return pr_auto;
	}




	public void setPo_year_yn(String po_year_yn) {
		 this.po_year_yn = checkForNull(po_year_yn,"N"); 
	}

	public String getPo_year_yn( ) {
		 return po_year_yn;
	}

	public void setPo_year(String po_year) {
		 this.po_year = checkForNull(po_year); 
	}

	public String getPo_year( ) {
		 return po_year;
	}
	
	public void setPo_facility_yn(String po_facility_yn) {
		 this.po_facility_yn = checkForNull(po_facility_yn,"N"); 
	}

	public String getPo_facility_yn( ) {
		 return po_facility_yn;
	}
	
	public void setPo_purunit_yn(String po_purunit_yn) {
		 this.po_purunit_yn = checkForNull(po_purunit_yn,"N"); 
	}

	public String getPo_purunit_yn( ) {
		 return po_purunit_yn;
	}

	public void setPo_start_no(String po_start_no) {
		 this.po_start_no = checkForNull(po_start_no); 
	}

	public String getPo_start_no( ) {
		 return po_start_no;
	}

	public void setPo_next_no(String po_next_no) {
		 this.po_next_no = checkForNull(po_next_no); 
	}

	public String getPo_next_no( ) {
		 return po_next_no;
	}

	public void setPo_auto(String po_auto) {
		 this.po_auto = checkForNull(po_auto); 
	}

	public String getPo_auto( ) {
		 return po_auto;
	}
	
	
	public void setDo_year_yn(String do_year_yn) {
		 this.do_year_yn = checkForNull(do_year_yn,"N"); 
	}

	public String getDo_year_yn( ) {
		 return do_year_yn;
	}

	public void setDo_year(String do_year) {
		 this.do_year = checkForNull(do_year); 
	}

	public String getDo_year( ) {
		 return do_year;
	}
	
	public void setDo_facility_yn(String do_facility_yn) {
		 this.do_facility_yn = checkForNull(do_facility_yn,"N"); 
	}

	public String getDo_facility_yn( ) {
		 return do_facility_yn;
	}
	
	public void setDo_purunit_yn(String do_purunit_yn) {
		 this.do_purunit_yn = checkForNull(do_purunit_yn,"N"); 
	}

	public String getDo_purunit_yn( ) {
		 return do_purunit_yn;
	}

	public void setDo_start_no(String do_start_no) {
		 this.do_start_no = checkForNull(do_start_no); 
	}

	public String getDo_start_no( ) {
		 return do_start_no;
	}

	public void setDo_next_no(String do_next_no) {
		 this.do_next_no = checkForNull(do_next_no); 
	}

	public String getDo_next_no( ) {
		 return do_next_no;
	}

	public void setDo_auto(String do_auto) {
		 this.do_auto = checkForNull(do_auto); 
	}

	public String getDo_auto( ) {
		 return do_auto;
	}
	
	
	public void setQuot_year_yn(String quot_year_yn) {
		 this.quot_year_yn = checkForNull(quot_year_yn,"N"); 
	}

	public String getQuot_year_yn( ) {
		 return quot_year_yn;
	}

	public void setQuot_year(String quot_year) {
		 this.quot_year = checkForNull(quot_year); 
	}

	public String getQuot_year( ) {
		 return quot_year;
	}
	
	public void setQuot_facility_yn(String quot_facility_yn) {
		 this.quot_facility_yn = checkForNull(quot_facility_yn,"N"); 
	}

	public String getQuot_facility_yn( ) {
		 return quot_facility_yn;
	}
	
	public void setQuot_purunit_yn(String quot_purunit_yn) {
		 this.quot_purunit_yn = checkForNull(quot_purunit_yn,"N"); 
	}

	public String getQuot_purunit_yn( ) {
		 return quot_purunit_yn;
	}

	public void setQuot_start_no(String quot_start_no) {
		 this.quot_start_no = checkForNull(quot_start_no); 
	}

	public String getQuot_start_no( ) {
		 return quot_start_no;
	}

	public void setQuot_next_no(String quot_next_no) {
		 this.quot_next_no = checkForNull(quot_next_no); 
	}

	public String getQuot_next_no( ) {
		 return quot_next_no;
	}

	public void setQuot_auto(String quot_auto) {
		 this.quot_auto = checkForNull(quot_auto); 
	}

	public String getQuot_auto( ) {
		 return quot_auto;
	}
	
	//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 30-MAY-2013 Starts
	public void setTndr_year_yn(String tndr_year_yn) {
		 this.tndr_year_yn = checkForNull(tndr_year_yn,"N"); 
	}

	public String getTndr_year_yn( ) {
		 return tndr_year_yn;
	}

	public void setTndr_year(String tndr_year) {
		 this.tndr_year = checkForNull(tndr_year); 
	}

	public String getTndr_year( ) {
		 return tndr_year;
	}
	
	public void setTndr_facility_yn(String tndr_facility_yn) {
		 this.tndr_facility_yn = checkForNull(tndr_facility_yn,"N"); 
	}

	public String getTndr_facility_yn( ) {
		 return tndr_facility_yn;
	}
	
/*	public void setTndr_purunit_yn(String tndr_purunit_yn) {
		 this.tndr_purunit_yn = checkForNull(tndr_purunit_yn,"N"); 
	}

	public String getTndr_purunit_yn( ) {
		 return tndr_purunit_yn;
	}*/

	public void setTndr_start_no(String tndr_start_no) {
		 this.tndr_start_no = checkForNull(tndr_start_no); 
	}

	public String getTndr_start_no( ) {
		 return tndr_start_no;
	}

	public void setTndr_next_no(String tndr_next_no) {
		 this.tndr_next_no = checkForNull(tndr_next_no); 
	}

	public String getTndr_next_no( ) {
		 return tndr_next_no;
	}

	public void setTndr_auto(String tndr_auto) {
		 this.tndr_auto = checkForNull(tndr_auto); 
	}

	public String getTndr_auto( ) {
		 return tndr_auto;
	}
	
	
	//ends
	
	
	
	public void setAll(Hashtable htRecordSet){
	
		super.setAll(htRecordSet);
		
		setPr_year_yn((String) htRecordSet.get("pr_year_yn"));
		setPr_year((String) htRecordSet.get("pr_year"));
		setPr_facility_yn((String) htRecordSet.get("pr_facility_yn"));
		setPr_purunit_yn((String) htRecordSet.get("pr_purunit_yn"));
		setPr_start_no((String) htRecordSet.get("pr_start_no"));
		setPr_next_no((String) htRecordSet.get("pr_next_no"));
		setPr_auto((String) htRecordSet.get("pr_auto"));

		setPo_year_yn((String) htRecordSet.get("po_year_yn"));
		setPo_year((String) htRecordSet.get("po_year"));
		setPo_facility_yn((String) htRecordSet.get("po_facility_yn"));
		setPo_purunit_yn((String) htRecordSet.get("po_purunit_yn"));
		setPo_start_no((String) htRecordSet.get("po_start_no"));
		setPo_next_no((String) htRecordSet.get("po_next_no"));
		setPo_auto((String) htRecordSet.get("po_auto"));
		
		setDo_year_yn((String) htRecordSet.get("do_year_yn"));
		setDo_year((String) htRecordSet.get("do_year"));
		setDo_facility_yn((String) htRecordSet.get("do_facility_yn"));
		setDo_purunit_yn((String) htRecordSet.get("do_purunit_yn"));
		setDo_start_no((String) htRecordSet.get("do_start_no"));
		setDo_next_no((String) htRecordSet.get("do_next_no"));
		setDo_auto((String) htRecordSet.get("do_auto"));
		
		setQuot_year_yn((String) htRecordSet.get("quot_year_yn"));
		setQuot_year((String) htRecordSet.get("quot_year"));
		setQuot_facility_yn((String) htRecordSet.get("quot_facility_yn"));
		setQuot_purunit_yn((String) htRecordSet.get("quot_purunit_yn"));
		setQuot_start_no((String) htRecordSet.get("quot_start_no"));
		setQuot_next_no((String) htRecordSet.get("quot_next_no"));
		setQuot_auto((String) htRecordSet.get("quot_auto"));
		
		//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 30-MAY-2013
		setTndr_year_yn((String) htRecordSet.get("tndr_year_yn"));  
		setTndr_year((String) htRecordSet.get("tndr_year"));
		setTndr_facility_yn((String) htRecordSet.get("tndr_facility_yn"));
		//setTndr_purunit_yn((String) htRecordSet.get("quot_purunit_yn"));
		setTndr_start_no((String) htRecordSet.get("tndr_start_no"));
		setTndr_next_no((String) htRecordSet.get("tndr_next_no"));
		setTndr_auto((String) htRecordSet.get("tndr_auto"));
		//ends
	}

	

	public void clear(){
		super.clear();
		
		pr_year_yn = "";
		pr_year = "";
		pr_facility_yn = "";
		pr_purunit_yn = "";
		pr_start_no = "";
		pr_next_no = "";
		pr_auto = "";

		po_year_yn = "";
		po_year = "";
		po_facility_yn = "";
		po_purunit_yn = "";
		po_start_no = "";
		po_next_no = "";
		po_auto = "";
		
		do_year_yn = "";
		do_year = "";
		do_facility_yn = "";
		do_purunit_yn = "";
		do_start_no = "";
		do_next_no = "";
		do_auto = "";
		
		quot_year_yn = "";
		quot_year = "";
		quot_facility_yn = "";
		quot_purunit_yn = "";
		quot_start_no = "";
		quot_next_no = "";
		quot_auto = "";
		
		//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 30-MAY-2013
		tndr_year_yn = "";  
		tndr_year = "";
		tndr_facility_yn = "";
		//tndr_purunit_yn = "";
		tndr_start_no = "";
		tndr_next_no = "";
		tndr_auto = "";
		//ends
	}

	public HashMap insert() {
		 
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alWhereData	=	new ArrayList()	;
		
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());
				
		alInsertData.add(getPr_auto());
		alInsertData.add(getPr_year_yn());
		alInsertData.add(getPr_facility_yn());
		alInsertData.add(getPr_purunit_yn());
		alInsertData.add(getPr_start_no());
		alInsertData.add(getPr_next_no());

		alInsertData.add(getPo_auto());
		alInsertData.add(getPo_year_yn()); 
		alInsertData.add(getPo_facility_yn());
		alInsertData.add(getPo_purunit_yn());
		alInsertData.add(getPo_start_no());
		alInsertData.add(getPo_next_no());
		
		alInsertData.add(getLoginFacilityId());
		alInsertData.add(getLoginById());      
		alInsertData.add(getLoginAtWsNo());    
		alInsertData.add(getLoginFacilityId());
		alInsertData.add(getLoginById());      
		alInsertData.add(getLoginAtWsNo());    
		alInsertData.add(getLoginFacilityId());
		
		alInsertData.add(getDo_auto());
		alInsertData.add(getDo_year_yn()); 
		alInsertData.add(getDo_facility_yn());
		alInsertData.add(getDo_start_no());
		alInsertData.add(getDo_next_no());
		
		alInsertData.add(getPr_year());
		
		alInsertData.add(getQuot_auto());
		alInsertData.add(getQuot_year_yn()); 
		alInsertData.add(getQuot_facility_yn());
		alInsertData.add(getQuot_start_no());
		alInsertData.add(getQuot_next_no());
		
		//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 30-MAY-2013
		alInsertData.add(getTndr_auto()); 
		alInsertData.add(getTndr_year_yn()); 
		alInsertData.add(getTndr_facility_yn());
		alInsertData.add(getTndr_start_no());
		alInsertData.add(getTndr_next_no());
		//ends
		
		//System.out.println("alInsertData===434==>" +alInsertData);
		
		alWhereData.add(getLoginFacilityId());
				
		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "WhereData",			alWhereData		);
		hmTableData.put( "InsertData",			alInsertData	);
		hmTableData.put("LanguageData",LanguageData);

		hmSQLMap.put( "InsertSQL", getPoRepositoryValue("SQL_PO_DOCNO_CONTROL_INSERT")	);

		hmSQLMap.put( "SelectSQL", getPoRepositoryValue("SQL_PO_DOCNO_COUNT")	);
		
		//System.out.println("hmTableData = "+hmTableData);
		//System.out.println("hmSQLMap = "+hmSQLMap);
		
		return callSingleTableHandler(hmTableData, hmSQLMap, PoRepository.SINGLE_INSERT);
	}

	public HashMap modify() {
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());


		alModifyData.add(getPr_auto());
		alModifyData.add(getPr_year_yn());
		alModifyData.add(getPr_facility_yn());
		alModifyData.add(getPr_purunit_yn());
		alModifyData.add(getPr_start_no());
		alModifyData.add(getPr_next_no());

		alModifyData.add(getPo_auto());
		alModifyData.add(getPo_year_yn()); 
		alModifyData.add(getPo_facility_yn());
		alModifyData.add(getPo_purunit_yn());
		alModifyData.add(getPo_start_no());
		alModifyData.add(getPo_next_no());
		
		alModifyData.add(getLoginById());      
		alModifyData.add(getLoginAtWsNo());    
		alModifyData.add(getLoginFacilityId());
		
		alModifyData.add(getDo_auto());
		alModifyData.add(getDo_year_yn()); 
		alModifyData.add(getDo_facility_yn());
		alModifyData.add(getDo_start_no());
		alModifyData.add(getDo_next_no());
		
		alModifyData.add(getPr_year());
		
		alModifyData.add(getQuot_auto());
		alModifyData.add(getQuot_year_yn()); 
		alModifyData.add(getQuot_facility_yn());
		alModifyData.add(getQuot_start_no());
		alModifyData.add(getQuot_next_no());
		
		//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 30-MAY-2013
		alModifyData.add(getTndr_auto());  
		alModifyData.add(getTndr_year_yn()); 
		alModifyData.add(getTndr_facility_yn());
		alModifyData.add(getTndr_start_no());
		alModifyData.add(getTndr_next_no());
		//ends
		
		alModifyData.add(getLoginFacilityId());
		//System.out.println("alModifyData===492==>" +alModifyData);
		
		hmSQLMap.put( "ModifySQL", getPoRepositoryValue("SQL_PO_DOCNO_CONTROL_UPDATE")	);
		
		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "ModifyData",			alModifyData	);
		hmTableData.put("LanguageData",LanguageData);

		return callSingleTableHandler(hmTableData, hmSQLMap, PoRepository.SINGLE_UPDATE );
	}

	public boolean recordExists() throws Exception{
		HashMap hmResult = fetchRecord(getPoRepositoryValue("SQL_PO_DOCNO_COUNT"),getLoginFacilityId());
		return !((String)hmResult.get("TOTAL")).equals("0");
	}

	/* Function specific methods start */
	public void loadData() throws Exception {
		
		HashMap hmRecord	=	null;
		
		try{
		hmRecord	=	fetchRecord("SELECT REQ_DOC_NO_GEN_METHOD, REQ_YEAR_PREFIX_YN, REQ_FACILITY_PREFIX_YN,REQ_PURUNIT_PREFIX_YN,REQ_START_SRLNO, REQ_NEXT_SRLNO, PO_DOC_NO_GEN_METHOD, PO_YEAR_PREFIX_YN,PO_FACILITY_PREFIX_YN,PO_PURUNIT_PREFIX_YN,PO_START_SRLNO,PO_NEXT_SRLNO,DO_DOC_NO_GEN_METHOD,DO_YEAR_PREFIX_YN,DO_FACILITY_PREFIX_YN,DO_START_SRLNO,DO_NEXT_SRLNO,QUOT_DOC_NO_GEN_METHOD,QUOT_YEAR_PREFIX_YN,QUOT_FACILITY_PREFIX_YN,QUOT_START_SRLNO,QUOT_NEXT_SRLNO,TNDR_DOC_NO_GEN_METHOD,TNDR_YEAR_PREFIX_YN,TNDR_FACILITY_PREFIX_YN,TNDR_START_SRLNO,TNDR_NEXT_SRLNO FROM PO_DOCNO_CONTROL WHERE  FACILITY_ID=? ",getLoginFacilityId());
		
		//System.out.println("hmRecord===291==>" +hmRecord);
				
		}
		catch (Exception e)
		{
		}

		setPr_auto(checkForNull((String) hmRecord.get("REQ_DOC_NO_GEN_METHOD")));
		setPr_year_yn(checkForNull((String) hmRecord.get("REQ_YEAR_PREFIX_YN")));
		setPr_facility_yn(checkForNull((String) hmRecord.get("REQ_FACILITY_PREFIX_YN")));
		setPr_purunit_yn(checkForNull((String) hmRecord.get("REQ_PURUNIT_PREFIX_YN")));
		setPr_start_no(checkForNull((String) hmRecord.get("REQ_START_SRLNO")));
		setPr_next_no(checkForNull((String) hmRecord.get("REQ_NEXT_SRLNO")));
		
		setPo_auto(checkForNull((String) hmRecord.get("PO_DOC_NO_GEN_METHOD")));
		setPo_year_yn(checkForNull((String) hmRecord.get("PO_YEAR_PREFIX_YN")));
		setPo_facility_yn(checkForNull((String) hmRecord.get("PO_FACILITY_PREFIX_YN")));
		setPo_purunit_yn(checkForNull((String) hmRecord.get("PO_PURUNIT_PREFIX_YN")));
		setPo_start_no(checkForNull((String) hmRecord.get("PO_START_SRLNO")));
		setPo_next_no(checkForNull((String) hmRecord.get("PO_NEXT_SRLNO")));
		
		setDo_auto(checkForNull((String) hmRecord.get("DO_DOC_NO_GEN_METHOD")));
		setDo_year_yn(checkForNull((String) hmRecord.get("DO_YEAR_PREFIX_YN")));
		setDo_facility_yn(checkForNull((String) hmRecord.get("DO_FACILITY_PREFIX_YN")));
		setDo_start_no(checkForNull((String) hmRecord.get("DO_START_SRLNO")));
		setDo_next_no(checkForNull((String) hmRecord.get("DO_NEXT_SRLNO")));
		
		setQuot_auto(checkForNull((String) hmRecord.get("QUOT_DOC_NO_GEN_METHOD")));
		setQuot_year_yn(checkForNull((String) hmRecord.get("QUOT_YEAR_PREFIX_YN")));
		setQuot_facility_yn(checkForNull((String) hmRecord.get("QUOT_FACILITY_PREFIX_YN")));
		setQuot_start_no(checkForNull((String) hmRecord.get("QUOT_START_SRLNO")));
		setQuot_next_no(checkForNull((String) hmRecord.get("QUOT_NEXT_SRLNO")));
		//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 30-MAY-2013
		setTndr_auto(checkForNull((String) hmRecord.get("TNDR_DOC_NO_GEN_METHOD")));  
		setTndr_year_yn(checkForNull((String) hmRecord.get("TNDR_YEAR_PREFIX_YN")));
		setTndr_facility_yn(checkForNull((String) hmRecord.get("TNDR_FACILITY_PREFIX_YN")));
		setTndr_start_no(checkForNull((String) hmRecord.get("TNDR_START_SRLNO")));
		setTndr_next_no(checkForNull((String) hmRecord.get("TNDR_NEXT_SRLNO")));
		//ends
		
	}

	
	public String toString(){
		return "DocumentNumberControlBean";
	}

	
	
	public HashMap validate() {
		System.out.println("validate");
		HashMap hmReturn = new HashMap() ;
		hmReturn.put("result", new Boolean( true ) ) ;
		hmReturn.put("message", "success, mode="+getMode() ) ;
		System.out.println("hmReturn validate = "+hmReturn);
		return hmReturn ;
	}
}


