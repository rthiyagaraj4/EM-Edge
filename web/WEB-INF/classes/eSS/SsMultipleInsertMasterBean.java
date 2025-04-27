/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS;

import java.util.Hashtable;
import java.util.HashMap;
import java.util.ArrayList;
import eCommon.Common.CommonRepository;
import eCommon.SingleTableHandler.*;

public class SsMultipleInsertMasterBean extends eSS.Common.SsAdapter implements java.io.Serializable{

	protected int RECORD_SIZE = Integer.parseInt((String)CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));

	private String []code = new String[RECORD_SIZE];
	private String []long_desc  = new String[RECORD_SIZE];
	private String []short_desc = new String[RECORD_SIZE];
	private String []eff_status = new String[RECORD_SIZE];

	protected String InsertSQL;
	protected String ModifySQL;
	protected String SelectSQL;
	protected String UpdateSQL;
	protected String codeFieldName;
	
	public SsMultipleInsertMasterBean() {

	}

	/* Set Methods Start */
	public void setCode(int index, String code) {
			this.code[index]		=	(code != null)?code.toUpperCase():null; 
	}

	public void setLong_desc(int index, String long_desc) {
			this.long_desc[index]		=	long_desc; 
	}

	public void setShort_desc(int index, String short_desc) {
			this.short_desc[index]		=	short_desc; 
	}

	public void setEff_status(int index, String eff_status) {
			this.eff_status[index]		=	eff_status;
	}

	/* Set Methods End */

	/* Get Methods Start */
	public String getCode(int index) {
		return this.code[index];
	}

	public String getLong_desc(int index) {
		return this.long_desc[index];
	}

	public String getShort_desc(int index) {
		return this.short_desc[index];
	}

	public String getEff_status(int index) {
		return this.eff_status[index];
	}
	/* Get Methods End */

	/* Over-ridden Adapter methods start here */

	public void clear() {
		super.clear();
		for (int index=0;index<RECORD_SIZE;index++)
		{
			code[index]	 = "";
			long_desc[index] = "";
			short_desc[index] = "";
			eff_status[index] = "D";	
		}
	}

	public void setAll(Hashtable recordSet) {
		for (int index=0;index<RECORD_SIZE;index++) {
			String tempCode	=	(String)recordSet.get("code_"+index);
			String tempLong_desc	=	(String)recordSet.get("long_desc_"+index);
			String tempShort_desc	=	(String)recordSet.get("short_desc_"+index);
			String tempEff_status	=	(String)recordSet.get("eff_status_"+index);
			
			if((tempCode== null) || (tempCode.equals(""))) {
				setCode	(index, null);
				setLong_desc	(index, null);
				setShort_desc	(index, null);
				setEff_status(index, null);
				continue; 
			}

			setCode	(index, tempCode);
			setLong_desc	(index, tempLong_desc	);
			setShort_desc	(index, tempShort_desc	);
			if(tempEff_status==null || tempEff_status.trim().equals(""))
				setEff_status	(index, "D");
			else
				setEff_status	(index, tempEff_status);
		}
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
			duplicateValue.add(getCode(index));
			alWhereData.add(duplicateValue);
	}

		hmSQLMap.put("InsertSQL", InsertSQL); 
		hmSQLMap.put("SelectSQL", SelectSQL); 
		hmTableData.put("properties",getProperties());
		hmTableData.put("WhereData",alWhereData);
		hmTableData.put("InsertData",alInsertData);

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
				hmResult.put( "message", getMessage(getLanguageId(),(String)hmResult.get( "msgid" ),"SS"));
			else{
				if( ((String)hmResult.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) ){
					hmResult.put( "message", getMessage(getLanguageId(),(String)hmResult.get( "msgid" ),"Common"));
					hmResult.put( "invalidCode", delimitedString( (ArrayList)hmResult.get("invalidCode")) ) ;
				} else{
					hmResult.put( "message", (hmResult.get("msgid"))) ;
				}
			}
		} 
		catch(Exception e) {
			hmResult.put("message", e.toString());
			e.printStackTrace();
		} 
		return hmResult;
	}


	public HashMap modify() {

		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		
		hmResult.put("result", new Boolean(false));

		alModifyData.add(long_desc[0]);
		alModifyData.add(short_desc[0]);
		alModifyData.add(eff_status[0]);
		alModifyData.add(login_by_id);
		alModifyData.add(login_at_ws_no);
		alModifyData.add(login_facility_id	);
		alModifyData.add(code[0]);

		hmSQLMap.put("ModifySQL", UpdateSQL); 

		hmTableData.put("properties",			getProperties());
		hmTableData.put("ModifyData",			alModifyData	);
		SingleTableHandlerRemote	singleTableHandlerRemote	= null;

		try {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(eCommon.Common.CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());

			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if(((Boolean) hmResult.get("result")).booleanValue())	
			{
				hmResult.put( "message", getMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"SS"));
			}
			else
			{
			    hmResult.put( "message", (String)hmResult.get( "msgid" ) ) ;
				
			}
			
		} 
		catch(Exception e) {
			hmResult.put("message", e.getMessage());
			e.printStackTrace();
		} 
		finally {
			try {
				if(singleTableHandlerRemote != null)
					singleTableHandlerRemote.remove();
			}
			catch(Exception ee) {
				hmResult.put("message", ee.getMessage());
			}
		}
		return hmResult;
	}

	public String paramsInBean() {
		StringBuffer arrayContent = new StringBuffer();
		for (int index=0;index<RECORD_SIZE;index++) {
			arrayContent.append("Record :"+ (index + 1) +" :: ");
			arrayContent.append(code [index]	+"=	");
			arrayContent.append(long_desc[index]+"=");
			arrayContent.append(short_desc[index]+"=");
			arrayContent.append(eff_status[index]+"=");	
			arrayContent.append("<BR>");
		}	
		return arrayContent.toString();
	}

	/* Added by Martin */
	public void loadData() throws Exception {
		java.sql.Connection connection = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.ResultSet resultSet = null;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(ModifySQL); 
			pstmt.setString(1, code[0]);
			resultSet = pstmt.executeQuery();
			if ((resultSet != null) && (resultSet.next())) {
				setCode(0,resultSet.getString(codeFieldName));
				setLong_desc(0,resultSet.getString("long_desc"));
				setShort_desc(0,resultSet.getString("short_desc"));
				setEff_status(0,resultSet.getString("eff_status"));
			}
		} 
		catch (Exception e)	{
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
}
