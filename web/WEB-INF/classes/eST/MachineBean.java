/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
//import java.sql.Connection ;
//import java.sql.ResultSet;
//import java.sql.PreparedStatement;
//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
//import javax.servlet.http.HttpServletRequest;
import javax.servlet.* ;
import eST.Common.StAdapter;
import eCommon.SingleTableHandler.*;

import eST.Common.* ;

public class MachineBean extends MasterCodeBean implements Serializable {

	protected String machine_code		="";
	protected String machine_name	="";
	protected String model_no  ="";
	protected String manufacturer  ="";
	protected String technical_specification="";
	protected String eff_status="";

	public void setMachine_code(String machine_code) {
		 this.machine_code = machine_code.toUpperCase	();
	}

	public String getMachine_code( ) {
		 return machine_code;
	}

	public void setMachine_name(String machine_name) {
		 this.machine_name = machine_name;
	}

	public String getMachine_name( ) {
		 return machine_name;
	}

	public void setModel_no(String model_no) {
		 this.model_no = model_no;
	}

	public String getModel_no( ) {
		 return model_no;
	}

	public void setManufacturer(String manufacturer) {
		 this.manufacturer = manufacturer;
	}

	public String getManufacturer( ) {
		 return manufacturer;
	}

	public void setTechnical_specification(String technical_specification) {
		 this.technical_specification = technical_specification;
	}

	public String getTechnical_specification( ) {
		 return technical_specification;
	}

	public void setEff_status(String eff_status) {
		 this.eff_status = checkForNull(eff_status,"D");
	}

	public String getEff_status( ) {
		 return eff_status;
	}

	public String getManufacturer_List(){
		return getListOptionTag( getListOptionArrayList(getStRepositoryValue("SQL_AM_MANUFACTURER_LIST"),getLanguageId()),getManufacturer());
	}

	/* Over-ridden Adapter methods start here */
	public HashMap validate() {
		HashMap hmReturn = new HashMap() ;
		hmReturn.put("result", new Boolean( true ) ) ;
		hmReturn.put("message", "success mode="+getMode() ) ;
		return hmReturn ;
	}

	public HashMap modify() {
		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;
		ArrayList	LanguageData	=	new ArrayList()	;

		hmResult.put("result", new Boolean( false ) ) ;
		hmResult.put("message", "Initial Message" ) ;

		alModifyData.add(getMachine_name()				);
		alModifyData.add(getModel_no()			);
		alModifyData.add(getManufacturer()			);
		alModifyData.add(getTechnical_specification()		);
		alModifyData.add(getEff_status()			);

		alModifyData.add(login_by_id				);
		alModifyData.add(login_at_ws_no				);
		alModifyData.add(login_facility_id			);

		alModifyData.add(getMachine_code()			);

		LanguageData.add(getLanguageId());

		hmTableData.put	( "properties",getProperties());
		hmTableData.put	( "ModifyData",alModifyData);
		hmTableData.put( "LanguageData",LanguageData);
		hmSQLMap.put	( "ModifySQL", getStRepositoryValue("SQL_ST_MACHINE_CODE_UPDATE"));


		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE );

	}

	public HashMap insert() {
		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		ArrayList	alWhereData=	new ArrayList()	;
		ArrayList	LanguageData	=	new ArrayList()	;

		hmResult.put("result", new Boolean( false ) ) ;
		hmResult.put("message", "Initial Message" ) ;

		alInsertData.add(getMachine_code()	);
		alInsertData.add(getMachine_name()		);
		alInsertData.add(getModel_no()	);
		alInsertData.add(getManufacturer()	);
		alInsertData.add(getTechnical_specification()	);
		alInsertData.add(getEff_status()	);
		alInsertData.add(login_by_id		);
		alInsertData.add(login_at_ws_no		);
		alInsertData.add(login_facility_id	);
		alInsertData.add(login_by_id		);
		alInsertData.add(login_at_ws_no		);
		alInsertData.add(login_facility_id	);
		
		LanguageData.add(getLanguageId());
		
		alWhereData.add(getMachine_code());
		hmTableData.put	( "properties",getProperties());
		hmTableData.put	( "InsertData",alInsertData);
		hmTableData.put	( "WhereData",alWhereData);
		hmTableData.put( "LanguageData",LanguageData);

		hmSQLMap.put	( "InsertSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_MACHINE_CODE_INSERT"));
		hmSQLMap.put	( "SelectSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_MACHINE_CODE_COUNT"));
		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT);
	}

	public void clear() {
		super.clear() ;
		machine_code	= "";
		machine_name	= "";
		model_no = "" ;
		manufacturer = "" ;
		technical_specification = "" ;
		eff_status = "" ;
	}

	public void setAll( Hashtable htRecordSet ) {
		super.setAll(htRecordSet);

		setMode((String) htRecordSet.get("mode")) ;

		setMachine_code((String) htRecordSet.get("machine_code")) ;
		setMachine_name((String)htRecordSet.get("machine_name"));
		setModel_no((String)htRecordSet.get("model_no"));
		setManufacturer((String)htRecordSet.get("manufacturer_id"));
		setTechnical_specification((String)htRecordSet.get("technical_specification"));
		setEff_status((String)htRecordSet.get("eff_status"));
	}


	/* Over-ridden Adapter methods end here */

	/* Function specific methods start */
	public void loadData() throws Exception {
		HashMap	hmRecord=null;
		String[] alParams = {getMachine_code(),getLanguageId()};
		hmRecord=fetchRecord(getStRepositoryValue("SQL_ST_MACHINE_CODE_SELECT_SINGLE"),alParams);
//		setMachine_code( (String)hmRecord.get("MACHINE_CODE" ) ) ;
		setMachine_name	( (String)hmRecord.get("MACHINE_NAME" )	) ;
		setModel_no( (String)hmRecord.get("MODEL_NO" )	) ;
		setManufacturer( checkForNull((String)hmRecord.get("MANUFACTURER_ID" ) )) ;
		setTechnical_specification((String)hmRecord.get("TECHNICAL_SPECIFICATION" ) ) ;
		setEff_status	( (String)hmRecord.get("EFF_STATUS" )	) ;
	}

	/* Function specific methods end */

	public String toString() {
		return technical_specification + "\t" +machine_code +"\t" + eff_status +"\t" + machine_name+"\t" + model_no+"\t" + manufacturer+"\tmode:" + mode;
	}
}
