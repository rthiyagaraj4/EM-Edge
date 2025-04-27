/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePO;

import java.util.Hashtable;
import java.util.HashMap;
import java.util.ArrayList;
import eCommon.Common.CommonRepository;
import ePO.Common.PoRepository;
import eCommon.SingleTableHandler.*;
 
public class MultipleInsertFacilityForPurchaseUnitBean extends ePO.Common.PoAdapter implements java.io.Serializable{

	private int RECORD_SIZE = Integer.parseInt((String)CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));

	private String pur_unit_id ;
	
	private String []facility_id = new String[RECORD_SIZE];
	private String []eff_status = new String[RECORD_SIZE];

	protected String InsertSQL;
	protected String ModifySQL;
	protected String SelectSQL;
	protected String UpdateSQL;
	protected String codeFieldName;
	
	public MultipleInsertFacilityForPurchaseUnitBean() {

	}

	/* Set Methods Start */
	
	public void setEff_status(int index, String eff_status) {
			this.eff_status[index]	= checkForNull(eff_status,"N");
	}
	
	public void setFacility_id(int index, String facility_id) {
			this.facility_id[index]	= facility_id ;//checkForNull(facility_id,"");
	}
	
	public void setPur_unit_id( String pur_unit_id) {
			this.pur_unit_id		=	pur_unit_id;
	}
	/* Set Methods End */

	/* Get Methods Start */	
	public String getPur_unit_id() {
		return this.pur_unit_id;
	}

	public String getEff_status(int index) {
		return this.eff_status[index];
	}
	
	public String getFacility_id(int index) {
		return this.facility_id[index];
	}
	/* Get Methods End */

	/* Over-ridden Adapter methods start here */

	public void clear() {
		super.clear();
		for (int index=0;index<RECORD_SIZE;index++)
		{
			pur_unit_id = "";
			eff_status[index] = "N";	
		}
	}

	public void setAll(Hashtable recordSet) {
		pur_unit_id=	(String)recordSet.get("pur_unit_id");
		setPur_unit_id(pur_unit_id);

		for (int index=0;index<RECORD_SIZE;index++) {
			String tempEff_status	=	(String)recordSet.get("eff_status_"+index);
			String tempFacility_id	=	(String)recordSet.get("facility_id_"+index);
			
			if(tempEff_status==null || tempEff_status.trim().equals(""))
				setEff_status	(index, "N");
			else
				setEff_status	(index, tempEff_status);
				
			setFacility_id(index, tempFacility_id);
		}
	}

	public HashMap insert() {
	System.out.println("Multiple insert Facility for Purchase Unit ");
		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		ArrayList	alWhereData	=	new ArrayList()	;
		ArrayList LanguageData = new ArrayList() ;

		hmResult.put("result", new Boolean(false));

		for (int index=0;index<RECORD_SIZE;index++) {
		if((getEff_status(index) == null) || (getEff_status(index).equals(""))) 
					continue;
		if((getFacility_id(index) == null) || (getFacility_id(index).equals(""))) 
					continue;			
			
			ArrayList alInsertRecord        =       new ArrayList();
			alInsertRecord.add(pur_unit_id);
			alInsertRecord.add(getFacility_id(index));
			alInsertRecord.add(getEff_status(index));
			alInsertRecord.add(login_by_id);
			alInsertRecord.add(login_at_ws_no);
			alInsertRecord.add(login_facility_id);
			alInsertRecord.add(login_by_id);
			alInsertRecord.add(login_at_ws_no);
			alInsertRecord.add(login_facility_id);
			
			alInsertData.add(alInsertRecord);
			//For duplicate check
			ArrayList duplicateValue = new ArrayList();
			duplicateValue.add(pur_unit_id);
			alWhereData.add(duplicateValue);
	}
		LanguageData.add(getLanguageId());
		hmSQLMap.put("InsertSQL", InsertSQL); 
		hmSQLMap.put("SelectSQL", SelectSQL); 
		hmTableData.put("properties",getProperties());
		hmTableData.put("WhereData",alWhereData);
		hmTableData.put("InsertData",alInsertData);
		hmTableData.put( "LanguageData",LanguageData);
		
		System.out.println("hmTableData in Multiple Facility for Purchase Unit= "+hmTableData);
		System.out.println("hmSQLMap in Multiple Facility for Purchase Unit = "+hmSQLMap);
		
		SingleTableHandlerRemote	singleTableHandlerRemote	= null;

		try {
			
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(eCommon.Common.CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();

			 hmResult = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
			
			System.out.println("hmResult in Multiple Facility for Purchase Unit = "+hmResult);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if( ((Boolean) hmResult.get( "result" )).booleanValue() )
			hmResult.put( "message", getPOMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"PO") ) ;
			else{
				if( ((String)hmResult.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) ){
					String msgID = getPOMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"PO") ;
					System.out.println("msgID = "+msgID);
					//msgID = msgID.substring(0,(msgID.indexOf("<br>"))) ;
					msgID = msgID.substring(0,(msgID.indexOf("."))) ;
					System.out.println("msgID = "+msgID);
					hmResult.put( "message", msgID  ) ;
					hmResult.put( "invalidCode", delimitedString( (ArrayList)hmResult.get("invalidCode")) ) ;
				} else{
					hmResult.put( "message", (hmResult.get("msgid"))) ;
				}
			}
			
		} 
		catch(Exception e) {
			System.err.println("Error-Calling EJB - SSM: "+e);
			hmResult.put("message", e.toString());
			e.printStackTrace();
		} 
		finally {
			try {
				if(singleTableHandlerRemote != null){}
					//singleTableHandlerRemote.remove();
			}
			catch(Exception ee) {
				System.err.println("Exceptions : SSM" +ee.getMessage());
				hmResult.put("message", ee.toString());
			}
		}
		return hmResult;
	}


	public HashMap modify() {

		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
				ArrayList LanguageData = new ArrayList() ;
		
		hmResult.put("result", new Boolean(false));

		alModifyData.add(facility_id[0]);
		alModifyData.add(eff_status[0]);
		alModifyData.add(login_by_id);
		alModifyData.add(login_at_ws_no);
		alModifyData.add(login_facility_id	);
		alModifyData.add(pur_unit_id);
		
		LanguageData.add(getLanguageId());
		hmSQLMap.put("ModifySQL", UpdateSQL); 
		//System.err.println("alModifyData"+alModifyData);
		hmTableData.put("properties",			getProperties());
		hmTableData.put("ModifyData",			alModifyData	);
		hmTableData.put( "LanguageData",LanguageData);

		SingleTableHandlerRemote	singleTableHandlerRemote	= null;

		try {
			
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(eCommon.Common.CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();

			 hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			if(((Boolean) hmResult.get("result")).booleanValue())		
				hmResult.put("message", getPOMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"PO") ) ;
			else
				hmResult.put("message", hmResult.get("msgid"));
		} 
		catch(Exception e) {
			System.err.println("Error Calling EJB : SSM"+e);
			hmResult.put("message", e.getMessage());
			e.printStackTrace();
		} 
		finally {
			try {
				if(singleTableHandlerRemote != null){}
				//	singleTableHandlerRemote.remove();
			}
			catch(Exception ee) {
				System.err.println("Exceptions : SSM "+ee.getMessage());
				hmResult.put("message", ee.getMessage());
			}
		}
		return hmResult;
	}

	public String toString() {
		StringBuffer arrayContent = new StringBuffer();
		for (int index=0;index<RECORD_SIZE;index++) {
			arrayContent.append("Record :"+ (index + 1) +" :: ");
			arrayContent.append(eff_status[index]+"=");	
			arrayContent.append("<BR>");
		}	
		return arrayContent.toString();
	}

	public void loadData() throws Exception {
		java.sql.Connection connection = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.ResultSet resultSet = null;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(ModifySQL); 
			pstmt.setString(1, pur_unit_id);
			resultSet = pstmt.executeQuery();
			if ((resultSet != null) && (resultSet.next())) {
				setPur_unit_id(resultSet.getString("pur_unit_id"));
				setFacility_id(0,resultSet.getString("facility_id"));
				setEff_status(0,resultSet.getString("eff_status"));
				
				
				
			}
		} 
		catch (Exception e)	{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				System.err.println("Exceptions : SSM "+ es.toString());
				es.printStackTrace();
			}
		}
	}

	public HashMap validate() throws Exception {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "" ) ;
        return map ;
    }

	
		
	public ArrayList getFacilityData() throws Exception {
		
		String []stParameters		=	{getLanguageId()};
		ArrayList result = null;
		try{
			//result = fetchRecords("SELECT sfp.facility_id,sfp.facility_name FROM sm_facility_param sfp, sm_facility_for_resp sfr ,sm_facility_for_user sfu WHERE sfp.facility_id = sfr.facility_id AND sfr.resp_id='PO'  AND sfu.APPL_USER_ID = ? AND sfu.facility_id = sfp.facility_id",stParameters);
			result = fetchRecords("SELECT FACILITY_ID, FACILITY_NAME FROM SM_FACILITY_PARAM  WHERE LANGUAGE_ID=?",stParameters);
			System.out.println("result in facility pu bean= "+result);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
		return result;
		
		
	}	
}
