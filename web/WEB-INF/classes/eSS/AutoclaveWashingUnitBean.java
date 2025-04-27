/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name			INC Number       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------------------------

12/11/2014				AAKH_CRF_0057			Sakti Sankar		52312											Autoclaving function, option to select
																													Biological indicator , BMS Pass / Fail 
																													Both in Master as wel as Transaction function.
--------------------------------------------------------------------------------------------------------------------------------------------------------------
*/


package eSS ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import java.sql.Connection ;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import eSS.Common.* ;

public class AutoclaveWashingUnitBean extends MasterCodeBean implements Serializable { 

	private String autoclave_wash_unit_code;
	private String sterile_type;
	private String service_location_code;
	private String temperature;
	private String unit_status;
	private String unit_type;
	private String b_indicator_test; //Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN  inc#52312
	private String bms_pass_fail; //Added by Sakti against  AAKH_CRF_0057 added   BMS_APPL_YN inc#52312

	public void setAutoclave_wash_unit_code(String autoclave_wash_unit_code) {
		 this.autoclave_wash_unit_code = autoclave_wash_unit_code.toUpperCase();
	}

	public String getAutoclave_wash_unit_code( ) {
		 return autoclave_wash_unit_code;
	}

	public void setSterile_type(String sterile_type) {
		 this.sterile_type = checkForNull(sterile_type);
	}

	public String getSterile_type( ) {
		 return sterile_type;
	}

	public void initService_location_code() {
		try { 
			service_location_code=checkForNull((String)getSSParameter().get("DEF_SERVICE_LOCATION_CODE")) ;
		}
		catch (Exception exception) {
		}
	}

	public void setService_location_code(String service_location_code) {
		 this.service_location_code = service_location_code;
	}

	public String getService_location_code( ) {
		 return service_location_code;
	}

	public void setTemperature(String temperature) {
		 this.temperature = checkForNull(temperature);
	}

	public String getTemperature( ) {
		 return temperature;
	}

	public void setUnit_status(String unit_status) {
		 this.unit_status = unit_status;
	}

	public String getUnit_status( ) {
		 return unit_status;
	}

	public void setUnit_type(String unit_type) {
		 this.unit_type = unit_type;
	}

	public String getUnit_type( ) {
		 return unit_type;
	}

	//Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312
	public void setBIndicatorTest(String b_indicator_test) {
		 this.b_indicator_test = b_indicator_test;
	}

	public String getBIndicatorTest( ) {
		 return b_indicator_test;
	}

	public void setBMSPassFail(String bms_pass_fail) {
		 this.bms_pass_fail = bms_pass_fail;
	}

	public String getBMSPassFail( ) {
		 return bms_pass_fail;
	}
	//Added ends


	public String getService_location_code_List(){
		ArrayList alparams=new ArrayList();
		alparams.add(getLoginFacilityId());
		alparams.add(getLanguageId());
		
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_SERVICE_LOCATION_SELECT_LIST"),alparams), getService_location_code());
	}

	public String getUnit_type_List(){
		 String locale = getLanguageId();
	     java.util.Locale loc = new java.util.Locale(locale);
	     java.util.ResourceBundle ss_labels = java.util.ResourceBundle.getBundle( "eSS.resources.Labels",loc);
		return getStaticListOptionTag( "A,"+ss_labels.getString("eSS.Autoclave.label")+";W,"+ss_labels.getString("eSS.Washing.label"), getUnit_type());
	}

	public String getSterile_type_List(){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STERILIZATION_TYPE_SELECT_LIST"),getLanguageId()), getSterile_type());
	}

	public String getUnit_status_List(){
		String locale = getLanguageId();
	     java.util.Locale loc = new java.util.Locale(locale);
	     java.util.ResourceBundle ss_labels = java.util.ResourceBundle.getBundle( "eSS.resources.Labels",loc);
		return getStaticListOptionTag( "A,"+ss_labels.getString("eSS.Readytouse.label")+";I,"+ss_labels.getString("eSS.Notreadytouse.label"), getUnit_status());
	}

	//Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312
	public String getBIndicator_Test_List(){
		String locale = getLanguageId();
	     java.util.Locale loc = new java.util.Locale(locale);
	     java.util.ResourceBundle ss_labels = java.util.ResourceBundle.getBundle( "eSS.resources.Labels",loc);
		return getStaticListOptionTag("X,"+ss_labels.getString("eSS.NotApplicable.label")+ ";Y,"+ss_labels.getString("eSS.testdone.label")+";N,"+ss_labels.getString("eSS.testnotdone.label"), getBIndicatorTest());
	}

	public String getBMS_PassFail_List(){
		String locale = getLanguageId();
	     java.util.Locale loc = new java.util.Locale(locale);
	     java.util.ResourceBundle ss_labels = java.util.ResourceBundle.getBundle( "eSS.resources.Labels",loc);
		return getStaticListOptionTag("X,"+ss_labels.getString("eSS.NotApplicable.label")+ ";Y,"+ss_labels.getString("eSS.Pass.label")+";N,"+ss_labels.getString("eSS.Fail.label"), getBMSPassFail());
	}
	//Added ends

	/* Over-ridden Adapter methods start here */

	public HashMap validate() {
		HashMap hmReturn = new HashMap() ;
		hmReturn.put("result", new Boolean( true ) ) ;
		hmReturn.put("message", "success" ) ;
		return hmReturn ;
	}

	public HashMap modify() {
		HashMap		hmTableData	=	new HashMap()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;

		alModifyData.add(getLong_desc()				);
		alModifyData.add(getShort_desc()			);
		alModifyData.add(getService_location_code()	);
		alModifyData.add(getUnit_type()				);
		alModifyData.add(getTemperature()			);
		alModifyData.add(getSterile_type()			);
		alModifyData.add(getUnit_status()			);
		alModifyData.add(getEff_status()			);

		alModifyData.add(login_by_id				);
		alModifyData.add(login_at_ws_no				);
		alModifyData.add(login_facility_id			);

		//Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312
		alModifyData.add(getBIndicatorTest());
		alModifyData.add(getBMSPassFail());
		//Added ends


		alModifyData.add(getAutoclave_wash_unit_code()			);
		
		hmTableData.put	( "properties",getProperties());
		hmTableData.put	( "ModifyData",alModifyData);
		hmSQLMap.put	( "ModifySQL", getSsRepositoryValue("SQL_SS_AUTOCLAVE_WASH_UNIT_UPDATE"));
		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE );
	}

	public HashMap insert() {
		HashMap		hmTableData	=	new HashMap()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		ArrayList	alWhereData=	new ArrayList()	;

		alInsertData.add(getAutoclave_wash_unit_code()	);
		alInsertData.add(getLong_desc()		);
		alInsertData.add(getShort_desc()	);
		alInsertData.add(getService_location_code()	);
		alInsertData.add(getUnit_type()	);
		alInsertData.add(getTemperature()	);
		alInsertData.add(getSterile_type()	);
		alInsertData.add(getUnit_status()	);
		alInsertData.add(getEff_status()	);
		alInsertData.add(login_by_id		);
		alInsertData.add(login_at_ws_no		);
		alInsertData.add(login_facility_id	);
		alInsertData.add(login_by_id		);
		alInsertData.add(login_at_ws_no		);
		alInsertData.add(login_facility_id	);
		alInsertData.add(login_facility_id);  //Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-APr-2014
		
		//Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312
		alInsertData.add(getBIndicatorTest());
		alInsertData.add(getBMSPassFail());
		//Added ends

		alWhereData.add(getAutoclave_wash_unit_code()	);

		hmTableData.put	( "properties",getProperties());
		hmTableData.put	( "InsertData",alInsertData);
		hmTableData.put	( "WhereData",alWhereData);

		hmSQLMap.put	( "InsertSQL", getSsRepositoryValue("SQL_SS_AUTOCLAVE_WASH_UNIT_INSERT"));
		hmSQLMap.put	( "SelectSQL", getSsRepositoryValue("SQL_SS_AUTOCLAVE_WASH_UNIT_COUNT"));

		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT );
	}

	public void clear() {
		super.clear();
		setAutoclave_wash_unit_code("");
		setService_location_code("");
		setUnit_type("");
		setTemperature("");
		setSterile_type("");
		setUnit_status("");
		
		setBIndicatorTest("");
		setBMSPassFail("");
	}

	public void setAll(Hashtable recordSet ) {
		super.setAll(recordSet);
		setAutoclave_wash_unit_code((String) recordSet.get("autoclave_wash_unit_code"));
		setService_location_code((String) recordSet.get("service_location_code"));
		setUnit_status((String) recordSet.get("unit_status"));
		setUnit_type((String) recordSet.get("unit_type"));
		setTemperature((String) recordSet.get("temperature"));
		setSterile_type((String) recordSet.get("sterile_type"));
		
		//Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312
		setBIndicatorTest((String) recordSet.get("b_indicator_test"));
		setBMSPassFail((String) recordSet.get("bms_pass_fail"));
		//Added ends
	}


	public void loadData() throws Exception {

		HashMap hmRecord		=	null;
		hmRecord				=	fetchRecord(getSsRepositoryValue("SQL_SS_AUTOCLAVE_WASH_UNIT_SELECT_SINGLE"), getAutoclave_wash_unit_code());
		
		setLong_desc				((String)hmRecord.get("LONG_DESC"));        
		setShort_desc				((String)hmRecord.get("SHORT_DESC"));       
		setEff_status				((String)hmRecord.get("EFF_STATUS"));       
		setService_location_code	((String)hmRecord.get("SERVICE_LOCATION_CODE"));
		setTemperature (checkForNull((String)hmRecord.get("TEMPERATURE")));     
		setUnit_status				((String)hmRecord.get("UNIT_STATUS"));      
		setUnit_type				((String)hmRecord.get("UNIT_TYPE"));        
		setSterile_type(checkForNull((String)hmRecord.get("STERILE_TYPE")));
		
		//Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312
		setBIndicatorTest			((String)hmRecord.get("BIOLOGICAL_INDICATOR")); 
		setBMSPassFail				((String)hmRecord.get("BMS_APPLICABLE")); 
		//Added ends
	}

	public String paramsInBean(){
		return autoclave_wash_unit_code+ " - " +  long_desc+ " - " +
			eff_status+ " - " + 
			sterile_type+ " - " + service_location_code+ " - " +
			short_desc+ " - " + temperature+ " - " + unit_status+ " - " + unit_type;
	}
}
