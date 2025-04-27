/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date	       	Edit History      	Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
24/11/2014		IN052312			Karthi L						Ramesh			Autoclaving Unit Test Entry
--------------------------------------------------------------------------------------------------------------
*/

package eSS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.io.*;
public class AutoclaveWashingUnitTestListBean extends eSS.Common.SsTransaction implements Serializable { 

/*AUTOCLAVE_WASH_UNIT_CODE       
TEST_CODE                      
BATCH_ID                       
TEST_RESULT                    
RESULT_DATE                    
RESULT_REMARKS                 */

	//private String autoclave_wash_unit_code;
	private String unit_type;
	private String test_code;
	private String test_desc;
	private String batch_id;
	private String test_result;
	private String result_date;
	private String result_remarks;
	//added for AAKH-CRF-0057 - IN052312
	private String room_temp;
	private String relative_humidity;
	private String biologic_indicator;
	private String bms_pass_fail;
	public String getRoom_temp() {
		return room_temp;
	}

	public void setRoom_temp(String room_temp) {
		this.room_temp = room_temp;
	}

	public String getRelative_humidity() {
		return relative_humidity;
	}

	public void setRelative_humidity(String relative_humidity) {
		this.relative_humidity = relative_humidity;
	}

	public String getBiologic_indicator() {
		return biologic_indicator;
	}

	public void setBiologic_indicator(String biologic_indicator) {
		this.biologic_indicator = biologic_indicator;
	}

	public String getBms_pass_fail() {
		return bms_pass_fail;
	}

	public void setBms_pass_fail(String bms_pass_fail) {
		this.bms_pass_fail = bms_pass_fail;
	}
	
	//added for AAKH-CRF-0057 - IN052312 - End
	private HashMap hmSsParameter =null;

	private String mode;

	public String getUnit_type() {
			 return unit_type;
	}

	public String getTest_code() {
		 return test_code;
	}
	
	public String getTest_desc() {
		 return test_desc;
	}

	public String getBatch_id() {
		 return batch_id;
	}
	
	public String getTest_result() {
		 return test_result;
	}

	public String getResult_date() {
		 return result_date;
	}

	public String getResult_remarks() {
		 return result_remarks;
	}


	public void setTest_desc(String test_desc) {
		 this.test_desc =  test_desc;
	}
	public void setTest_code(String test_code) {
		 this.test_code =  test_code;
	}

	public void setUnit_type(String unit_type) {
		//System.out.println("INSIDE SET.."+unit_type);
		 this.unit_type =  unit_type;
	}

	public void setBatch_id(String batch_id) {
		 this.batch_id =  batch_id;
	}

	public void setTest_result(String test_result) {
		 this.test_result =  test_result;
	}

	public void setResult_date(String result_date) {
		 this.result_date=  result_date;
	}

		public void setResult_remarks(String result_remarks) {
		 this.result_remarks =  checkForNull(result_remarks);
	}

	public void setMode(String mode) {
		 this.mode =  mode;
	}
	
	public String getMode() {
		 return mode;
	}

	public void initSsParameter() throws Exception {
		hmSsParameter=getSSParameter();
	}
	public void initResult_date() {
		result_date=hmSsParameter.get("SYS_DATE").toString() ;
	}


	public void clear(){
		test_code	  ="";    
		batch_id	  ="";    
		test_desc   ="";          
		test_result="";       
		result_date="";          
		result_remarks="";
		mode          ="";
		// added for AAKH-CRF-0057 - IN052312 - Start
		room_temp	= "";
		relative_humidity	= "";
		biologic_indicator	= "";
		bms_pass_fail		= "";
		// added for AAKH-CRF-0057 - IN052312 - End
	}

	public String getTest_code_List( String unit_type){
	
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(unit_type);
		alParameters.add(getLanguageId());
		alParameters.add(getLoginFacilityId());  ///Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014
	
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_WASHING_TEST_SELECT_LIST"),alParameters), getTest_code());
	}

	public String getTest_result_List(){
		String locale = getLanguageId();
	     java.util.Locale loc = new java.util.Locale(locale);
	     java.util.ResourceBundle ss_labels = java.util.ResourceBundle.getBundle( "eSS.resources.Labels",loc);
		return getStaticListOptionTag( "P,"+ss_labels.getString("eSS.Pass.label")+";F,"+ss_labels.getString("eSS.Fail.label"), getTest_result());
	//	return getStaticListOptionTag( "P,Pass;F,Fail", getTest_result());

	}

	public HashMap toHashMap(){
		HashMap hmReturn	 =	new HashMap();
		hmReturn.put("test_code",		getTest_code());
		hmReturn.put("test_desc",		getTest_desc());
		hmReturn.put("batch_id",		getBatch_id());
		hmReturn.put("test_result",	getTest_result());
		hmReturn.put("result_date",	getResult_date());
		hmReturn.put("result_remarks",		getResult_remarks());
		hmReturn.put("mode", getMode());
		// added for AAKH-CRF-0057 - IN052312 - Start
		hmReturn.put("room_temp", getRoom_temp());
		hmReturn.put("relative_humidity", getRelative_humidity());
		hmReturn.put("biologic_indicator", getBiologic_indicator());
		hmReturn.put("bms_pass_fail", getBms_pass_fail());
		// added for AAKH-CRF-0057 - IN052312 - End
		return hmReturn;
	}

	
		public boolean isTestCodeInArrayList(ArrayList alGroupList, String stTest_code, String stAutoclave_wash_unit_code, int exceptionalIndex){
		boolean result=false;
		for (int i=0;i<alGroupList.size();i++) {
			if (exceptionalIndex == i) continue;
			if ( ((HashMap)alGroupList.get(i)).get("test_code").toString().equals(stTest_code) ) 
			{
				//if ( ((HashMap)alGroupList.get(i)).get("autoclave_wash_unit_code").toString().equals(stAutoclave_wash_unit_code) ) 
				//{
					result=true;
					break;
				//}
			}
		}
		return result;
	}

	public boolean isEntryCompleted(String autoclave_wash_unit_code,String test_date) throws Exception{
		HashMap hmResult		=	new HashMap();
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(autoclave_wash_unit_code);
		alParameters.add(test_date);
		hmResult	=	fetchRecord(getSsRepositoryValue("SQL_SS_AUTOCLAVE_WASH_HDR_SELECT_SINGLE"),alParameters);
		return hmResult.get("ENTRY_COMPLETED_YN").toString().equals("Y");
	}

	public void initialize(HashMap hmRequestGroupItem){

        System.err.println("result_date========>"+(String)hmRequestGroupItem.get("result_date").toString()	);
        
		//setAutoclave_wash_unit_code(hmRequestGroupItem.get("autoclave_wash_unit_code").toString()	);
		
		//setTest_desc   (hmRequestGroupItem.get("test_desc").toString()	);
		setUnit_type((String)hmRequestGroupItem.get("unit_type").toString()	);
		setTest_code ((String)hmRequestGroupItem.get("test_code").toString()	);
		setBatch_id((String)hmRequestGroupItem.get("batch_id").toString()		);
		setTest_result((String)hmRequestGroupItem.get("test_result").toString()		);
		setResult_date((String)hmRequestGroupItem.get("result_date").toString()		);
		setResult_remarks(checkForNull((String)hmRequestGroupItem.get("result_remarks")).toString()			);
		setMode((String)hmRequestGroupItem.get("mode").toString());
		// added for AAKH-CRF-0057 - IN052312 - Start
		setRoom_temp((String)hmRequestGroupItem.get("room_temp"));
		setRelative_humidity((String)hmRequestGroupItem.get("relative_humidity"));
		setBiologic_indicator((String)hmRequestGroupItem.get("biologic_indicator"));
		setBms_pass_fail((String)hmRequestGroupItem.get("bms_pass_fail"));
		// added for AAKH-CRF-0057 - IN052312 - End
	}
	public String getTestDescription() 
	{
				ArrayList alParameters1	=	new ArrayList(2);
				HashMap hmResult	=	new HashMap();
				String result="";
			try{
				
				
				
				alParameters1.add(getTest_code());
				alParameters1.add(getLanguageId());
				
				 hmResult	=	fetchRecord(" SELECT TEST_CODE,SHORT_DESC FROM SS_AUTOCLAVE_WASH_TEST_LANG_VW  WHERE TEST_CODE= ? AND LANGUAGE_ID =? ",alParameters1);
				
				 result=hmResult.get("SHORT_DESC").toString();
			}
			catch(Exception e)
		{e.printStackTrace();
		}
				
				return result;

	}
	//added for AAKH-CRF-0057 - IN052312 - Start
	public String getBioBmsApplicableCodes(String testCode) throws Exception {
		Connection connection 		= null;	
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		
		String testCodeQry = null;
		
		String bioBMSApplicable = null;

		try {
			testCodeQry = "SELECT BIOLOGICAL_INDICATOR , BMS_APPLICABLE FROM SS_AUTOCLAVE_WASH_TEST WHERE TEST_CODE = ?";
			connection =  getConnection();
			pstmt = connection.prepareStatement(testCodeQry);
			pstmt.setString(1, testCode);
			
			
			resultSet = pstmt.executeQuery();
			
			while( resultSet != null && resultSet.next()){
				bioBMSApplicable = resultSet.getString(1)+"/"+resultSet.getString(2);
			}
			
		}
		catch(Exception ex){
			System.err.println( "Error loading values from database" ) ;
			ex.getMessage();
			throw ex;
		}
		finally {
			if( resultSet != null) resultSet.close();
			if(pstmt !=null) pstmt.close();
			if(connection != null) connection.close();
		}
		return bioBMSApplicable;
	}
	// End
}
