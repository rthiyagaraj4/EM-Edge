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
//import java.util.Properties;
//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
import eST.Common.StAdapter;
import eST.Common.StTransaction;
import eCommon.SingleTableHandler.*;

public class DirectSalesPatientBean extends StTransaction implements Serializable { 


	private String patient_id=	"";
	private String eff_status=	"D";
	//private String mode="";

	//private ArrayList update_array=	new ArrayList();

	
	public void setPatientId (String patient_id) {
		this.patient_id = patient_id; 
	}
	/*public void setupdate_array (ArrayList update_array) {
		this.update_array.add(update_array);
		ArrayList UpdateList = (ArrayList)this.update_array.get(0);
	}*/
	public String getPatientId() {
		return this.patient_id;
	}
	public void setEff_status_yn(String eff_status) {
		 this.eff_status= checkForNull(eff_status,"D");
	}
	public String getEff_status_yn()
	{
          return eff_status;
	}


	public HashMap insert() {

		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alWhereData	=	new ArrayList()	;
		ArrayList	LanguageData	=	new ArrayList()	;

		hmResult.put( "result", new Boolean( false ) ) ;

		alInsertData.add(patient_id  		);
		alInsertData.add(eff_status       	);
		alInsertData.add(login_by_id		);
		alInsertData.add(login_at_ws_no		);
		alInsertData.add(login_facility_id	);
		alInsertData.add(login_by_id		);
		alInsertData.add(login_at_ws_no		);
		alInsertData.add(login_facility_id	);
		LanguageData.add(getLanguageId());
		
        hmSQLMap.put( "InsertSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_DIR_SALE_PATIENT_PARAM_INSERT"));  //eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_INSERT")
		/*hmSQLMap.put("InsertSQL","INSERT INTO ST_DIR_SALE_PATIENT_PARAM(patient_id,eff_status,added_by_id,added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no,modified_facility_id) VALUES(?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");*/
		

		alWhereData.add(	patient_id	);

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "WhereData",			alWhereData		);
		hmTableData.put( "InsertData",			alInsertData	);
		hmTableData.put( "LanguageData",			LanguageData	);
		//hmTableData.put( "Update Array List",			this.update_array	);
   
		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT );

	}

	public HashMap modify() {


		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
			ArrayList	LanguageData	=	new ArrayList()	;

		hmResult.put( "result", new Boolean( false ) ) ;

		alModifyData.add(eff_status       	);
		alModifyData.add(login_by_id		);
		alModifyData.add(login_at_ws_no		);
		alModifyData.add(login_facility_id	);
 		alModifyData.add(patient_id			);
       
	
		LanguageData.add(getLanguageId());


		hmSQLMap.put( "ModifySQL", eST.Common.StRepository.getStKeyValue("SQL_ST_DIR_SALE_PATIENT_PARAM_UPDATE"));
		/*hmSQLMap.put("ModifySQL","UPDATE ST_DIR_SALE_PATIENT_PARAM SET EFF_STATUS=?, MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE PATIENT_ID=?");*/
		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "ModifyData",			alModifyData	);
		hmTableData.put( "LanguageData",			LanguageData	);
  
  
		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE );
	}

	  public void setAll(Hashtable htRecordSet){
			try {
				super.setAll(htRecordSet);
			
				setPatientId ((String) htRecordSet.get("patient_id"));
				setEff_status_yn((String) htRecordSet.get("eff_status"));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}


}
