/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
*Module			:	eSS
*Function		:	Service Location
  */
package eSS ;

import java.util.Hashtable;
import java.util.HashMap;
import java.util.ArrayList;
import eCommon.SingleTableHandler.*;
import eCommon.Common.CommonRepository;


public class ServiceLocationBean  extends SsMultipleInsertMasterBean implements java.io.Serializable{

	public ServiceLocationBean() 	{
		super.InsertSQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_SERVICE_LOCATION_INSERT");
		super.ModifySQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_SERVICE_LOCATION_SELECT_SINGLE");
		super.UpdateSQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_SERVICE_LOCATION_UPDATE");
		super.SelectSQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_SERVICE_LOCATION_COUNT");
		super.codeFieldName = "service_location_code";
	}

	public HashMap insert() {
		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		ArrayList	alWhereData	=	new ArrayList()	;

		hmResult.put( "result", new Boolean( false ) ) ;
		int RECORD_SIZE = Integer.parseInt((String)CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
		for (int index=0;index<RECORD_SIZE ;index++ ) {
			if((getCode(index) == null) || (getCode(index).equals("")) ) 
				continue;

			ArrayList alInsertRecord	=	new ArrayList();

			alInsertRecord.add(getCode(index)	);
			alInsertRecord.add(getLong_desc(index)		);
			alInsertRecord.add(getShort_desc(index)		);
			alInsertRecord.add(login_facility_id		);
			alInsertRecord.add(getEff_status(index)		);
			alInsertRecord.add(login_by_id				);
			alInsertRecord.add(login_at_ws_no			);
			alInsertRecord.add(login_facility_id		);
			alInsertRecord.add(login_by_id				);
			alInsertRecord.add(login_at_ws_no			);
			alInsertRecord.add(login_facility_id		);
			
			alInsertData.add(alInsertRecord);
			//For duplicate check
			ArrayList duplicateValue = new ArrayList();
			duplicateValue.add(getCode(index));
			alWhereData.add(duplicateValue);
		}
		
		hmSQLMap.put( "InsertSQL", InsertSQL); 
		hmSQLMap.put( "SelectSQL", SelectSQL); 

		hmTableData.put( "properties",getProperties());
		hmTableData.put( "WhereData",alWhereData);
		hmTableData.put( "InsertData",alInsertData);


		try {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(eCommon.Common.CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());

			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) hmResult.get( "result" )).booleanValue() )
				hmResult.put( "message", getMessage(getLanguageId(),(String)hmResult.get( "msgid" ),"SS") ) ;
			else{
				if(((String) hmResult.get( "msgid" )).equals("CODE_ALREADY_EXISTS"))
					hmResult.put( "message", getMessage(getLanguageId(),(String)hmResult.get( "msgid" ),"Common") ) ;
				else
					hmResult.put( "message", (hmResult.get("msgid"))) ;
			}

		} 
		catch(Exception e) {
			hmResult.put( "message", e.toString()+"= Here is the error :"+hmResult.get( "result" )) ;
			e.printStackTrace() ;
		} 
		return hmResult;
	}

}
