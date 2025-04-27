/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMM;

import java.util.Hashtable;
import java.util.HashMap;
import java.util.ArrayList;
//import javax.naming.InitialContext;
//import javax.rmi.PortableRemoteObject;
import eCommon.Common.CommonRepository;
import eMM.Common.MmRepository;
import eCommon.SingleTableHandler.*;
 
public class MultipleInsertBinLocationBean extends eMM.Common.MmAdapter implements java.io.Serializable{

	private int RECORD_SIZE = Integer.parseInt((String)CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));

	private String store_code ;
	private String []code = new String[RECORD_SIZE];
	private String []long_desc  = new String[RECORD_SIZE];
	private String []short_desc = new String[RECORD_SIZE];
	private String []eff_status = new String[RECORD_SIZE];

	protected String InsertSQL;
	protected String ModifySQL;
	protected String SelectSQL;
	protected String UpdateSQL;
//	protected String language_id;
	protected String codeFieldName;
	
	public MultipleInsertBinLocationBean() {

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
	/*public void setLanguageId (String language_id)
	{
		this.language_id = language_id;
	}*/
	public void setEff_status(int index, String eff_status) {
			this.eff_status[index]		=	eff_status;//checkForNull(eff_status,"D");
	}
	
	public void setStoreCode( String store_code) {
			this.store_code		=	store_code;
	}
	/* Set Methods End */

	/* Get Methods Start */	
	public String getStoreCode() {
		return this.store_code;
	}

/*public String getLanguageId() 
	{
		return this.language_id;
	}*/
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
		store_code=	(String)recordSet.get("store_code");
		setStoreCode(store_code);

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
		ArrayList LanguageData = new ArrayList() ;

		hmResult.put("result", new Boolean(false));

		for (int index=0;index<RECORD_SIZE;index++) {
			if((getCode(index) == null) || (getCode(index).equals(""))) 
					continue;
			ArrayList alInsertRecord        =       new ArrayList();
			alInsertRecord.add(getCode(index));
			alInsertRecord.add(store_code);
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
			duplicateValue.add(store_code);
			alWhereData.add(duplicateValue);
	}
		LanguageData.add(getLanguageId());
		hmSQLMap.put("InsertSQL", InsertSQL); 
		hmSQLMap.put("SelectSQL", SelectSQL); 
		hmTableData.put("properties",getProperties());
		hmTableData.put("WhereData",alWhereData);
		hmTableData.put("InsertData",alInsertData);
		hmTableData.put( "LanguageData",LanguageData);
		//System.err.println("alInsertData"+alInsertData);
		//System.err.println("hmTableData"+hmTableData);
		//System.err.println("hmSQLMap"+hmSQLMap);
//		SingleTableHandlerHome singleTableHandlerHome = null;
		SingleTableHandlerRemote	singleTableHandlerRemote	= null;

		try {
			/*InitialContext context = new InitialContext();

			Object object = context.lookup(eCommon.Common.CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"));
			
			singleTableHandlerHome  = (SingleTableHandlerHome) PortableRemoteObject.narrow(object, SingleTableHandlerHome.class);
			singleTableHandlerRemote = singleTableHandlerHome.create();

			hmResult = singleTableHandlerRemote.singleBatchHandler(hmTableData, hmSQLMap);*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(eCommon.Common.CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();

			 hmResult = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			//System.err.println("hmResult"+hmResult);
			if( ((Boolean) hmResult.get( "result" )).booleanValue() )
			hmResult.put( "message", getMMMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			else{
				if( ((String)hmResult.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) ){
					String msgID = getMMMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"Common") ;
					msgID = msgID.substring(0,(msgID.indexOf("<br>"))) ;
					hmResult.put( "message", msgID  ) ;
					hmResult.put( "invalidCode", delimitedString( (ArrayList)hmResult.get("invalidCode")) ) ;
						//(map.get("invalidCode"))  ) ;
				} else{
					hmResult.put( "message", (hmResult.get("msgid"))) ;
				}
			}
			/*if(((Boolean) hmResult.get("result")).booleanValue())
				hmResult.put("message", getMessage((String) hmResult.get("msgid")));
			else{
				if(((String) hmResult.get("msgid")).equals("CODE_ALREADY_EXISTS"))
					hmResult.put("message", getMessage((String) hmResult.get("msgid")));
				else
					hmResult.put("message", (hmResult.get("msgid")));
			}*/

		} 
		catch(Exception e) {
			System.err.println("Error-Calling EJB - SSM: "+e);
			hmResult.put("message", e.toString());
			e.printStackTrace();
		} 
		finally {
			try {
				if(singleTableHandlerRemote != null)
					singleTableHandlerRemote.remove();
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

		alModifyData.add(long_desc[0]);
		alModifyData.add(short_desc[0]);
		alModifyData.add(eff_status[0]);
		alModifyData.add(login_by_id);
		alModifyData.add(login_at_ws_no);
		alModifyData.add(login_facility_id	);
		alModifyData.add(code[0]);
		alModifyData.add(store_code);
		
		LanguageData.add(getLanguageId());
		hmSQLMap.put("ModifySQL", UpdateSQL); 
		//System.err.println("alModifyData"+alModifyData);
		hmTableData.put("properties",			getProperties());
		hmTableData.put("ModifyData",			alModifyData	);
		hmTableData.put( "LanguageData",LanguageData);

//		SingleTableHandlerHome		singleTableHandlerHome		= null;
		SingleTableHandlerRemote	singleTableHandlerRemote	= null;

		try {
			/*InitialContext context = new InitialContext();
			Object object = context.lookup(eCommon.Common.CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"));

			singleTableHandlerHome  = (SingleTableHandlerHome) PortableRemoteObject.narrow(object, SingleTableHandlerHome.class);
			singleTableHandlerRemote = singleTableHandlerHome.create();
			hmResult = singleTableHandlerRemote.modify(hmTableData, hmSQLMap);*/
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
				hmResult.put("message", getMMMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
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
				if(singleTableHandlerRemote != null)
					singleTableHandlerRemote.remove();
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
			pstmt.setString(1, store_code);
			pstmt.setString(2, code[0]);
			resultSet = pstmt.executeQuery();
			if ((resultSet != null) && (resultSet.next())) {
				setCode(0,resultSet.getString(codeFieldName));
				setLong_desc(0,resultSet.getString("long_desc"));
				setShort_desc(0,resultSet.getString("short_desc"));
				setStoreCode(resultSet.getString("store_code"));
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

	public ArrayList getStoreList() throws Exception
	{
		java.sql.Connection connection = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.ResultSet resultSet = null;

		ArrayList	arrStore		=	new  ArrayList();
		HashMap		hmStore			=	null;	

		try {
				connection = getConnection();
				pstmt = connection.prepareStatement(MmRepository.getMmKeyValue("SQL_MM_BIN_LOCATION_SELECT")); 
				pstmt.setString(1,getLanguageId());
				pstmt.setString(2,getLoginFacilityId());
				resultSet = pstmt.executeQuery();
				//System.err.println("SQL_MM_STORE_SELECT : " +MmRepository.getMmKeyValue("SQL_MM_STORE_SELECT") + " : " +store_code);
				
				while ((resultSet != null) && (resultSet.next()))
				{
					hmStore			=	new HashMap();
					hmStore.put("code",checkForNull(resultSet.getString(1)));
					hmStore.put("desc",checkForNull(resultSet.getString(2)));
					arrStore.add(hmStore);
				}
			} 
			catch (Exception e )
			{
				System.err.println("Error loading values from database");
				e.printStackTrace();
				throw e;
			} 
			finally
			{
				 try{
					closeResultSet(resultSet);
					closeStatement(pstmt);
					closeConnection(connection);
					}
					catch(Exception es) 
					{
					es.printStackTrace();
					}
			}
			return arrStore;
		}
}
