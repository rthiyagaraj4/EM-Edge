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

/* 
  *Module			:	eSS
  *Function		:	Surgery Type
  */
package eSS ;
import java.util.*;

public class AutoclaveWashingTestBean  extends SsMultipleInsertMasterBean implements java.io.Serializable{
	private String []unit_type= new String[RECORD_SIZE];
	
	private String []biological_indicator = new String[RECORD_SIZE];
	private String []bms_pass_fail = new String[RECORD_SIZE];

	public void setUnit_type(int index, String unit_type) {
			this.unit_type[index]		=	unit_type;
	}

	public String getUnit_type(int index) {
		return this.unit_type[index];
	}

	//Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312
	public void setBiological_Indicator(int index, String biological_indicator) {
			this.biological_indicator[index]		=	biological_indicator;
	}

	public String getBiological_Indicator(int index) {
		return this.biological_indicator[index];
	}

	public void setBms_Pass_Fail(int index, String bms_pass_fail) {
			this.bms_pass_fail[index]		=	bms_pass_fail;
	}

	public String getBms_Pass_Fail(int index) {
		return this.bms_pass_fail[index];
	}
	//Added ends

	public String getUnit_type_List( String stUnit_type){
		 String locale = getLanguageId();
	     java.util.Locale loc = new java.util.Locale(locale);
	     java.util.ResourceBundle ss_labels = java.util.ResourceBundle.getBundle( "eSS.resources.Labels",loc);
		return getStaticListOptionTag( "A,"+ss_labels.getString("eSS.Autoclave.label")+";W,"+ss_labels.getString("eSS.Washing.label"), stUnit_type);
	}

	//Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312
	public String getBiological_Indicator_List(String stBiological_indicator){
		String locale = getLanguageId();
	     java.util.Locale loc = new java.util.Locale(locale);
	     java.util.ResourceBundle ss_labels = java.util.ResourceBundle.getBundle( "eSS.resources.Labels",loc);
		return getStaticListOptionTag("X,"+ss_labels.getString("eSS.NotApplicable.label")+ ";Y,"+ss_labels.getString("eSS.testdone.label")+";N,"+ss_labels.getString("eSS.testnotdone.label"), stBiological_indicator);
	}

	public String getBMS_PassFail_List(String stBMS_pass_fail) {
		String locale = getLanguageId();
	     java.util.Locale loc = new java.util.Locale(locale);
	     java.util.ResourceBundle ss_labels = java.util.ResourceBundle.getBundle( "eSS.resources.Labels",loc);
		return getStaticListOptionTag("X,"+ss_labels.getString("eSS.NotApplicable.label")+ ";Y,"+ss_labels.getString("eSS.Pass.label")+";N,"+ss_labels.getString("eSS.Fail.label"), stBMS_pass_fail);
	}
	//Added ends

	public void clear() {
		super.clear();
		for (int index=0;index<RECORD_SIZE;index++)
		{
			unit_type[index] = "A";
			biological_indicator[index] = "X";
			bms_pass_fail[index] = "X";
		}
	}
	public void setAll(Hashtable recordSet) {
		super.setAll(recordSet);

		for (int index=0;index<RECORD_SIZE;index++) {
			String tempUnit_type	=	(String)recordSet.get("unit_type_"+index);
			String tempCode			=	(String)recordSet.get("code_"+index);
			
			//Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312
			String tempBiological_Indicator	=	(String)recordSet.get("biological_indicator_"+index);
			String tempBms_Pass_Fail		=	(String)recordSet.get("bms_pass_fail_"+index);
			//Added ends

			if((tempCode== null) || (tempCode.equals(""))) {
				setUnit_type(index, null);
				continue; 
			}
			setUnit_type(index, tempUnit_type);

			//Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312
			setBiological_Indicator(index,tempBiological_Indicator);
			setBms_Pass_Fail(index,tempBms_Pass_Fail);
		}
	}

	public AutoclaveWashingTestBean() 	{
		super.InsertSQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_AUTOCLAVE_WASH_TEST_INSERT");
		super.ModifySQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_AUTOCLAVE_WASH_TEST_SELECT_SINGLE");
		super.UpdateSQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_AUTOCLAVE_WASH_TEST_UPDATE");
		super.SelectSQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_AUTOCLAVE_WASH_TEST_COUNT");
		super.codeFieldName = "test_code";
	}

	public HashMap insert() {
		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		ArrayList	alWhereData	=	new ArrayList()	;

		hmResult.put("result", new Boolean(false));

		for (int index=0;index<RECORD_SIZE;index++) {
			if((getCode(index) == null) || (getCode(index).equals(""))) 
					continue;
			ArrayList alInsertRecord        =       new ArrayList();
			alInsertRecord.add(getCode(index));
			alInsertRecord.add(getLong_desc(index));
			alInsertRecord.add(getShort_desc(index));
			alInsertRecord.add(getUnit_type(index));
			alInsertRecord.add(getEff_status(index));
			alInsertRecord.add(login_by_id);
			alInsertRecord.add(login_at_ws_no);
			alInsertRecord.add(login_facility_id);
			alInsertRecord.add(login_by_id);
			alInsertRecord.add(login_at_ws_no);
			alInsertRecord.add(login_facility_id);
			alInsertRecord.add(login_facility_id); ////Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-APR-2014

			//Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312
			alInsertRecord.add(getBiological_Indicator(index));
			alInsertRecord.add(getBms_Pass_Fail(index));
			//Added ends

			alInsertData.add(alInsertRecord);
			//For duplicate check
			ArrayList duplicateValue = new ArrayList();
			duplicateValue.add(getCode(index));
			alWhereData.add(duplicateValue);
		}

		hmSQLMap.put("InsertSQL", InsertSQL); 
		hmSQLMap.put("SelectSQL", SelectSQL); 
		hmTableData.put("properties",getProperties());
		hmTableData.put("WhereData",alWhereData);
		hmTableData.put("InsertData",alInsertData);

		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT_BATCH );
	}

	public HashMap modify() {

		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		
		hmResult.put("result", new Boolean(false));

		alModifyData.add(getLong_desc(0));
		alModifyData.add(getShort_desc(0));
		alModifyData.add(getUnit_type(0));
		alModifyData.add(getEff_status(0));
		alModifyData.add(login_by_id);
		alModifyData.add(login_at_ws_no);
		alModifyData.add(login_facility_id	);

		//Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312
		alModifyData.add(getBiological_Indicator(0));
		alModifyData.add(getBms_Pass_Fail(0));
		//Added ends

		alModifyData.add(getCode(0));

		hmSQLMap.put("ModifySQL", UpdateSQL); 

		hmTableData.put("properties",			getProperties());
		hmTableData.put("ModifyData",			alModifyData	);
		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE);
	}

	public void loadData() throws Exception {
		try {
			HashMap hmRecord	=	fetchRecord(ModifySQL, getCode(0)); 
			setLong_desc(0,(String)hmRecord.get("LONG_DESC"));
			setShort_desc(0,(String)hmRecord.get("SHORT_DESC"));
			setUnit_type(0,(String)hmRecord.get("UNIT_TYPE"));
			setEff_status(0,(String)hmRecord.get("EFF_STATUS"));

			//Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312
			setBiological_Indicator(0,(String)hmRecord.get("BIOLOGICAL_INDICATOR"));
			setBms_Pass_Fail(0,(String)hmRecord.get("BMS_APPLICABLE"));
			//Added ends
		} 
		catch (Exception e)	{
			e.printStackTrace();
			throw e;
		} 
	}

	public HashMap validate() throws Exception {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "" ) ;
        return map ;
    }
}
