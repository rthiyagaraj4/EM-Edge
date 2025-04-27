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
import java.util.Properties;
import eSS.Common.SsAdapter;
import eCommon.SingleTableHandler.*;

public class StoreBean extends SsAdapter implements Serializable { 

	private String store_code		=	"";
    private String store_desc 		=	"";

	private String owner_yn			=	"N";
	private String req_allowed_yn	=	"N";
	private String iss_allowed_yn	=	"N";
	private String rti_allowed_yn	=	"N";
	private String rof_allowed_yn	=	"N";
	private String trd_allowed_yn	=	"N";
	private String rtg_allowed_yn	=	"N";
	private String pre_allowed_yn	=	"N";
	private String var_allowed_yn	=	"N";
	private String adj_allowed_yn	=	"N";

	private String rql_allowed_yn	=	"N";
	private String isl_allowed_yn	=	"N";
	private String rtl_allowed_yn	=	"N";
	private String rqv_allowed_yn	=	"N";
	private String rtv_allowed_yn	=	"N";

	public void setReq_allowed_yn(String req_allowed_yn) {
		 this.req_allowed_yn = checkForNull(req_allowed_yn,"N");
	}

	public String getReq_allowed_yn( ) {
		 return req_allowed_yn;
	}

	public void setStore_code(String store_code) {
		 this.store_code = store_code;
	}

	public String getStore_code( ) {
		 return store_code;
	}

	public void setStore_desc(String store_desc) {
		 this.store_desc = store_desc;
	}

	public String getStore_desc( ) {
		 return store_desc;
	}



	public void setIss_allowed_yn(String iss_allowed_yn) {
		 this.iss_allowed_yn = checkForNull(iss_allowed_yn,"N");
	}

	public String getIss_allowed_yn( ) {
		 return iss_allowed_yn;
	}

	public void setRti_allowed_yn(String rti_allowed_yn) {
		 this.rti_allowed_yn = checkForNull(rti_allowed_yn,"N");
	}

	public String getRti_allowed_yn( ) {
		 return rti_allowed_yn;
	}

	public void setOwner_yn(String owner_yn) {
		 this.owner_yn =checkForNull( owner_yn,"N");
	}

	public String getOwner_yn( ) {
		 return owner_yn;
	}

	public void setRof_allowed_yn(String rof_allowed_yn) {
		 this.rof_allowed_yn = checkForNull(rof_allowed_yn,"N");
	}

	public String getRof_allowed_yn( ) {
		 return rof_allowed_yn;
	}

	public void setTrd_allowed_yn(String trd_allowed_yn) {
		 this.trd_allowed_yn = checkForNull(trd_allowed_yn,"N");
	}

	public String getTrd_allowed_yn( ) {
		 return trd_allowed_yn;
	}

	public void setRtg_allowed_yn(String rtg_allowed_yn) {
		 this.rtg_allowed_yn = checkForNull(rtg_allowed_yn,"N");
	}

	public String getRtg_allowed_yn( ) {
		 return rtg_allowed_yn;
	}

	public void setPre_allowed_yn(String pre_allowed_yn) {
		 this.pre_allowed_yn = checkForNull(pre_allowed_yn,"N");
	}

	public String getPre_allowed_yn( ) {
		 return pre_allowed_yn;
	}

	public void setVar_allowed_yn(String var_allowed_yn) {
		 this.var_allowed_yn = checkForNull(var_allowed_yn,"N");
	}

	public String getVar_allowed_yn( ) {
		 return var_allowed_yn;
	}

	public void setAdj_allowed_yn(String adj_allowed_yn) {
		 this.adj_allowed_yn = checkForNull(adj_allowed_yn,"N");
	}

	public String getAdj_allowed_yn( ) {
		 return adj_allowed_yn;
	}

//Added By Sakti Sankar on CRF#Bru-HIMS-CRF-225 and inc#32071
	public void setRql_allowed_yn(String rql_allowed_yn) {
		 this.rql_allowed_yn = checkForNull(rql_allowed_yn,"N");
	}

	public String getRql_allowed_yn( ) {
		 return rql_allowed_yn;
	}

	public void setIsl_allowed_yn(String isl_allowed_yn) {
		 this.isl_allowed_yn = checkForNull(isl_allowed_yn,"N");
	}

	public String getIsl_allowed_yn( ) {
		 return isl_allowed_yn;
	}

	public void setRtl_allowed_yn(String rtl_allowed_yn) {
		 this.rtl_allowed_yn = checkForNull(rtl_allowed_yn,"N");
	}

	public String getRtl_allowed_yn( ) {
		 return rtl_allowed_yn;
	}
//Added ends
//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015 
	public void setRqv_allowed_yn(String rqv_allowed_yn) {
		 this.rqv_allowed_yn = checkForNull(rqv_allowed_yn,"N");
	}

	public String getRqv_allowed_yn( ) {
		 return rqv_allowed_yn;
	}
	public void setRtv_allowed_yn(String rtv_allowed_yn) {
		 this.rtv_allowed_yn = checkForNull(rtv_allowed_yn,"N");
	}

	public String getRtv_allowed_yn( ) {
		 return rtv_allowed_yn;
	}
//Added ends
	public String getStore_code_List(){
		ArrayList alparams=new ArrayList();
		alparams.add(getLoginFacilityId());
		alparams.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_MM_STORE_SELECT_LIST"),alparams), getStore_code());
	}

	public HashMap insert() {

		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alWhereData	=	new ArrayList()	;

		hmResult.put( "result", new Boolean( false ) ) ;

		alInsertData.add(store_code  		);
		alInsertData.add(owner_yn       	);
		alInsertData.add(pre_allowed_yn 	);
		alInsertData.add(req_allowed_yn 	);
		alInsertData.add(iss_allowed_yn 	);
		alInsertData.add(rtg_allowed_yn 	);
		alInsertData.add(rti_allowed_yn 	);
		alInsertData.add(trd_allowed_yn 	);
		alInsertData.add(adj_allowed_yn 	);
		alInsertData.add(var_allowed_yn 	);
		alInsertData.add(rof_allowed_yn 	);
	
		alInsertData.add(login_by_id		);
		alInsertData.add(login_at_ws_no		);
		alInsertData.add(login_facility_id	);
		alInsertData.add(login_by_id		);
		alInsertData.add(login_at_ws_no		);
		alInsertData.add(login_facility_id	);

//Added By Sakti Sankar CRF#Bru-HIMS-CRF-225 and inc#32071
		alInsertData.add(rql_allowed_yn 	);
		alInsertData.add(isl_allowed_yn 	);
		alInsertData.add(rtl_allowed_yn 	);
//Added ends
//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015 on 06-07-2015
		alInsertData.add(rqv_allowed_yn 	);
		alInsertData.add(rtv_allowed_yn 	);
//Added ends
		hmSQLMap.put( "InsertSQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_INSERT")	);
		hmSQLMap.put( "SelectSQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_COUNT")	);

		alWhereData.add(	store_code	);

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "WhereData",			alWhereData		);
		hmTableData.put( "InsertData",			alInsertData	);

		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT );
	}

	public HashMap modify() {

		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;

		hmResult.put( "result", new Boolean( false ) ) ;

		alModifyData.add(owner_yn			);
		alModifyData.add(pre_allowed_yn		);
		alModifyData.add(req_allowed_yn		);
		alModifyData.add(iss_allowed_yn		);
		alModifyData.add(rtg_allowed_yn		);
		alModifyData.add(rti_allowed_yn		);
		alModifyData.add(trd_allowed_yn		);
		alModifyData.add(adj_allowed_yn		);
		alModifyData.add(var_allowed_yn		);
		alModifyData.add(rof_allowed_yn		);
		
		alModifyData.add(login_by_id		);
		alModifyData.add(login_at_ws_no		);
		alModifyData.add(login_facility_id	);
//Added By Sakti Sankar on 11/04/2013 CRF#Bru-HIMS-CRF-225 and inc#32071
		alModifyData.add(rql_allowed_yn		);
		alModifyData.add(isl_allowed_yn		);
		alModifyData.add(rtl_allowed_yn		); 
//Added ends
//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015 on 06-07-2015
		alModifyData.add(rqv_allowed_yn		);
		alModifyData.add(rtv_allowed_yn		);
//Added ends
		alModifyData.add(store_code			);

		hmSQLMap.put( "ModifySQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_UPDATE"));

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "ModifyData",			alModifyData	);

		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE );
	}

	public void clear() {
		store_code		=	""; 
		owner_yn		=	"N";
		req_allowed_yn	=	"N";	
		iss_allowed_yn	=	"N";	
		rti_allowed_yn	=	"N";	
		rof_allowed_yn	=	"N";	
		trd_allowed_yn	=	"N";	
		rtg_allowed_yn	=	"N";	
		pre_allowed_yn	=	"N";	
		var_allowed_yn	=	"N";	
		adj_allowed_yn	=	"N";
		
		rql_allowed_yn	=	"N";
		isl_allowed_yn	=	"N";
		rtl_allowed_yn	=	"N";
		rqv_allowed_yn	=	"N";
		rtv_allowed_yn	=	"N";
	}

	public void setAll(Hashtable htRecordSet){
		try {
			super.setAll(htRecordSet);
	
			setStore_code((String) htRecordSet.get("store_code"));
			setOwner_yn((String) htRecordSet.get("owner_yn"));
			setReq_allowed_yn((String) htRecordSet.get("req_allowed_yn"));
			setIss_allowed_yn((String) htRecordSet.get("iss_allowed_yn"));
			setRti_allowed_yn((String) htRecordSet.get("rti_allowed_yn"));
			setRof_allowed_yn((String) htRecordSet.get("rof_allowed_yn"));
			setTrd_allowed_yn((String) htRecordSet.get("trd_allowed_yn"));
			setRtg_allowed_yn((String) htRecordSet.get("rtg_allowed_yn"));
			setPre_allowed_yn((String) htRecordSet.get("pre_allowed_yn"));
			setVar_allowed_yn((String) htRecordSet.get("var_allowed_yn"));
			setAdj_allowed_yn((String) htRecordSet.get("adj_allowed_yn"));
//Added By Sakti Sankar on 11/04/2013 CRF#Bru-HIMS-CRF-225 and inc#32071
			setRql_allowed_yn((String) htRecordSet.get("rql_allowed_yn"));
			setIsl_allowed_yn((String) htRecordSet.get("isl_allowed_yn"));
			setRtl_allowed_yn((String) htRecordSet.get("rtl_allowed_yn"));
//Added ends
//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015 on 06-07-2015
			setRqv_allowed_yn((String) htRecordSet.get("rqv_allowed_yn"));
			setRtv_allowed_yn((String) htRecordSet.get("rtv_allowed_yn"));
//Added ends
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Over-ridden Adapter methods end here */

	/* Function specific methods start */
	public void loadData() throws Exception {
		try {
			String []stParameters		=	{getStore_code()};
			HashMap hmRecord	=	null;
			hmRecord	=	fetchRecord(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_SELECT_SINGLE"), stParameters);
            
            setStore_desc     ( (String)hmRecord.get("SHORT_DESC" )		) ;
			setOwner_yn		  ( (String)hmRecord.get("OWNER_YN" )		) ;
			setReq_allowed_yn ( (String)hmRecord.get("REQ_ALLOWED_YN" )	) ;
			setIss_allowed_yn ( (String)hmRecord.get("ISS_ALLOWED_YN" )	) ;
			setRti_allowed_yn ( (String)hmRecord.get("RTI_ALLOWED_YN" )	) ;
			setRof_allowed_yn ( (String)hmRecord.get("ROF_ALLOWED_YN" )	) ;
			setTrd_allowed_yn ( (String)hmRecord.get("TRD_ALLOWED_YN" )	) ;
			setRtg_allowed_yn ( (String)hmRecord.get("RTG_ALLOWED_YN" )	) ;
			setPre_allowed_yn ( (String)hmRecord.get("PRE_ALLOWED_YN" )	) ;
			setVar_allowed_yn ( (String)hmRecord.get("VAR_ALLOWED_YN" )	) ;
			setAdj_allowed_yn ( (String)hmRecord.get("ADJ_ALLOWED_YN" )	) ;
//Added By Sakti Sankar on 11/04/2013 CRF#Bru-HIMS-CRF-225 and inc#32071
			setRql_allowed_yn ( (String)hmRecord.get("RQL_ALLOWED_YN" )	) ;
			setIsl_allowed_yn ( (String)hmRecord.get("ISL_ALLOWED_YN" )	) ;
			setRtl_allowed_yn ( (String)hmRecord.get("RTL_ALLOWED_YN" )	) ;
			
//Added ends
//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015 on 06-07-2015
			setRqv_allowed_yn ( (String)hmRecord.get("RQV_ALLOWED_YN" )	) ;
			setRtv_allowed_yn ( (String)hmRecord.get("RTV_ALLOWED_YN" )	) ;
//Added ends
		} 
		catch ( Exception exception )	{
			exception.printStackTrace() ;
			throw exception ;
		} 
	}

	public boolean isStoreDisabled() throws Exception{
		HashMap hmResult	=	null;
		hmResult = fetchRecord(eSS.Common.SsRepository.getSsKeyValue("SQL_MM_STORE_SELECT_STATUS"),getStore_code());
		return ((String)hmResult.get("EFF_STATUS")).equals("D");
	}

	public String paramsInBean(){
	return "mode:"+mode;
	}
}
