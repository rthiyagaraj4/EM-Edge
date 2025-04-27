/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.Common ;

import webbeans.eCommon.*;
import eCommon.Common.CommonAdapter;
import eCommon.Common.CommonRepository;
import eCommon.SingleTableHandler.SingleTableHandlerHome;
import eCommon.SingleTableHandler.SingleTableHandlerRemote;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.Statement;
import java.sql.Types;
import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Clob;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.StringTokenizer;
//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
//import javax.servlet.http.HttpServletRequest;
import eCommon.Common.OptionValues;

public abstract class StAdapter extends CommonAdapter implements Serializable {
	boolean localEJB = true;
	public String acc_entity_id = "";
	public static int count = 0;
	public static HashMap<String,Double> convFactMap		= new HashMap<String,Double>();
	public static HashMap<String,String> convFactMapDuo	= new HashMap<String,String>();
	private ArrayList	kitDataList =new ArrayList();
	public StAdapter() {
		super(CommonRepository.getCommonKeyValue("ID_ST"));
	}

	public void setLocalEJB(boolean localEJB){
		this.localEJB = localEJB;
	}

	public boolean getLocalEJB(){
		return localEJB;
	}


	/**
	* To call the method of SingleTableHandler EJB
	* functionID to be passed as parameter to call the function
	**/
	public HashMap singleTableHandlerMethodCall(HashMap hmTableData, HashMap hmSQLMap, int functionID ){

		HashMap		hmResult	=	new HashMap()	;
		
		//SingleTableHandlerHome	singleTableHandlerHome		= null ;

		ArrayList languageData		=	(ArrayList)hmTableData.get("LanguageData");
	//	String locale=(String)languageData.get(0);
		SingleTableHandlerRemote	singleTableHandlerRemote		= null ;
		hmResult.put(RESULT, new Boolean( false ) ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {
			/*InitialContext context = new InitialContext() ;

			Object object = context.lookup( eCommon.Common.CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

			singleTableHandlerHome  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
			singleTableHandlerRemote = singleTableHandlerHome.create() ;*/
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(eCommon.Common.CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ,SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();

			
			
		


			switch (functionID)
			{
				case FUNCTION_INSERT:
					hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					//hmResult = singleTableHandlerRemote.insert( hmTableData, hmSQLMap ) ;
					break;
				
				case FUNCTION_UPDATE:
					hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
					//hmResult = singleTableHandlerRemote.modify( hmTableData, hmSQLMap ) ;
					break;
				
				case FUNCTION_INSERT_BATCH:
					hmResult = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
				//	hmResult = singleTableHandlerRemote.singleBatchHandler( hmTableData, hmSQLMap ) ;
					break;
				
				default:
					hmResult.put( MESSAGE, "Invalid Function ID passed to singleTableHandlerMethodCall()") ;
			}
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if( ((Boolean) hmResult.get(RESULT)).booleanValue() ){	
				//getSTMessage((String)languageData.get(0);,(String) hmResult.get( MSGID ),"ST") ) ;
				hmResult.put( MESSAGE, getSTMessage((String)languageData.get(0),(String) hmResult.get( MSGID ),"ST") ) ;
				hmResult.remove(MSGID);
			}
			else if( hmResult.get(MSGID).toString().equals("") )
				hmResult.put( MESSAGE, "No record processed.") ;
			else if( hmResult.get(MSGID)!=null  )
				hmResult.put( MESSAGE, getSTMessage((String)languageData.get(0),(String) hmResult.get( MSGID ),"ST") ) ;
			else
				hmResult.put( MESSAGE, replaceNewLineChar((String)hmResult.get(MESSAGE)) ) ;

			if( checkForNull((String)hmResult.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) ){
				String msgID = getSTMessage((String)languageData.get(0),(String) hmResult.get( MSGID ),"Common")  ;
				if(msgID.contains("<br>")){
					msgID = msgID.substring(0,(msgID.indexOf("<br>")));
				}
				hmResult.put( "message", msgID);

				if((ArrayList)hmResult.get("invalidCode")!=null){
					ArrayList tempInvaliCode = (ArrayList)hmResult.get("invalidCode");
					for (int index=0;index<tempInvaliCode.size();index++) {
						((java.util.ArrayList)tempInvaliCode.get(index)).remove(0);
					}
					hmResult.put( "invalidCode", delimitedString(tempInvaliCode));
				}
			} 


		} 
		catch(Exception exception) {
			hmResult.put( MESSAGE, "Bean 169: "+exception.getMessage()) ;
			exception.printStackTrace() ;
		} 
		finally {
			try {
				if( singleTableHandlerRemote != null )
					singleTableHandlerRemote.remove() ;
			}
			catch( Exception exception) {
				hmResult.put( MESSAGE, "Bean 179: "+exception.toString()) ;
			}
		}
		return hmResult;
	}

	/**
	* To get the record on the basis of primary key.
	* 
	**/
	public HashMap fetchRecord(String sql) throws Exception {
		return fetchRecord( sql, (ArrayList) null);
	}

	public HashMap fetchRecord(String sql, String stParameter) throws Exception {
		ArrayList alParameters	=	new ArrayList(1);
		alParameters.add(stParameter);
		return fetchRecord( sql,  alParameters);
	}
	public HashMap fetchRecord(String sql, String[] stParameters) throws Exception {
		ArrayList alParameters	=	new ArrayList(stParameters.length);
		for (int i=0;i< stParameters.length;i++ ) {
			alParameters.add(stParameters[i]);	
		}
		return fetchRecord( sql,  alParameters);
	}

	public HashMap fetchRecord(String sql, ArrayList alParameters) throws Exception {
		
		HashMap hmRecord					=	new HashMap();
		Connection connection				= null;
		PreparedStatement preparedStatement	= null;
		ResultSet resultSet					= null;
		ResultSetMetaData resultSetMetaData	= null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			if (alParameters!=null) 
				for (int index=0; index<alParameters.size() ;index++ ) 
					if(alParameters.get(index) instanceof String)
						preparedStatement.setString( index+1, ((String)alParameters.get(index)));
					else if(alParameters.get(index) instanceof Long)
						preparedStatement.setLong( index+1, ((Long)alParameters.get(index)).longValue());

			resultSet = preparedStatement.executeQuery();
			resultSetMetaData	=	resultSet.getMetaData();

		if(resultSet!=null && resultSet.next()){
			
			for (int i=1; i<=resultSetMetaData.getColumnCount(); i++ ){
				int iColumnType=	resultSetMetaData.getColumnType(i);
				switch (iColumnType){

				case Types.CLOB:
					Clob clobData= resultSet.getClob(resultSetMetaData.getColumnName(i));
					StringBuffer sbClobData	= new StringBuffer();
					if(clobData!=null)
						sbClobData.append(clobData.getSubString(1,(int)clobData.length()));
					hmRecord.put(resultSetMetaData.getColumnName(i),sbClobData.toString());
					break;
	
				default:
					hmRecord.put(resultSetMetaData.getColumnName(i),resultSet.getString(resultSetMetaData.getColumnName(i)));
				}
			}
		}
		} 
		catch (Exception exception )	{
			System.err.println("Error @ fetch Record..");
			System.err.println("Parameter rcd: SQL:"+sql);
			System.err.println("Bind Values rcd:        "+alParameters);
			exception.printStackTrace();
			throw exception;
		} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}

		}
		return hmRecord;
	}

	public ArrayList fetchRecords(String sql) throws Exception {
		return fetchRecords( sql,  new ArrayList(0));
	}

	public ArrayList fetchRecords(String sql, String stParameter) throws Exception {
		ArrayList alParameters = new ArrayList(1);
		alParameters.add(stParameter);
		return fetchRecords( sql,  alParameters);
	}
	public ArrayList fetchRecords(String sql, String []stParameter) throws Exception {
		ArrayList alParameters = new ArrayList(stParameter.length);
		for (int i=0;i<stParameter.length;i++) {
			alParameters.add(stParameter[i]);
		}
		return fetchRecords( sql,  alParameters);
	}
	public ArrayList fetchRecords(String sql, ArrayList alParameters) throws Exception {
		ArrayList alRecords					=	new ArrayList();
		HashMap hmRecord					=	null;
		Connection connection				= null;
		PreparedStatement preparedStatement	= null;
		ResultSet resultSet					= null;
		ResultSetMetaData resultSetMetaData	= null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);

			if (alParameters!=null) 
				for (int index=0; index<alParameters.size() ;index++ ) {
					if(alParameters.get(index) instanceof String)
						preparedStatement.setString( index+1, ((String)alParameters.get(index)));
					else if(alParameters.get(index) instanceof Long){
						preparedStatement.setLong( index+1, ((Long)alParameters.get(index)).longValue());
					}
			}

			resultSet = preparedStatement.executeQuery();
			resultSetMetaData	=	resultSet.getMetaData();
			int i	=1	;
			while(resultSet!=null && resultSet.next())
			{
				hmRecord=new HashMap();
				for (i=1; i<=resultSetMetaData.getColumnCount(); i++ )
					hmRecord.put(resultSetMetaData.getColumnName(i),resultSet.getString(resultSetMetaData.getColumnName(i)));
				alRecords.add(hmRecord);
			}
		} 
		catch (Exception exception )	{
			System.err.println("Error @ fetchRecords");
			System.err.println("Parameter rcd: SQL:"+sql);
			System.err.println("Bind Values rcd:   "+alParameters);
			exception.printStackTrace();
			throw exception;
		} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}
		}
		return alRecords;
	}

	public String getChecked(String string){
		return (string.equalsIgnoreCase("E")||string.equalsIgnoreCase("Y"))? "checked" : "";
	}

	public String getStRepositoryValue(String key){
		return eST.Common.StRepository.getStKeyValue(key);
	}

	public String getCommonRepositoryValue(String key){
		try { 
			return eCommon.Common.CommonRepository.getCommonKeyValue(key);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}

	public HashMap getMessageHashMap(boolean bFlag){
		HashMap hmReturn	=	new HashMap();
		hmReturn.put(RESULT,bFlag?TRUE:FALSE);
		hmReturn.put(MESSAGE,"[Method body under development]Dummy Message for result: "+bFlag);
		return hmReturn;
	}

	public String getImage(String checkedType) {
		if (checkedType == null) 
			return "";
		else if (checkedType.equalsIgnoreCase("M")) 
			return StRepository.getStKeyValue("MANDATORY_IMAGE");
		else if (checkedType.equalsIgnoreCase("Y") || checkedType.equalsIgnoreCase("E") ) 
			return StRepository.getStKeyValue("YES_IMAGE");
		else if (checkedType.equalsIgnoreCase("N") || checkedType.equalsIgnoreCase("D") ) 
			return StRepository.getStKeyValue("NO_IMAGE");
		else 
			return "";
	}
	public ArrayList getListOptionArrayList(String sql) {
		return getListOptionArrayList(sql,new ArrayList(0));
	}

	public ArrayList getListOptionArrayList(String sql,String parameter) {
		ArrayList alParameter=new ArrayList (1);
		alParameter.add(parameter);
		return getListOptionArrayList(sql, alParameter);
	}

	public HashMap getStParameter() throws Exception{
		String  []stParameter={getLoginFacilityId(),"ALL"};
		return fetchRecord(getStRepositoryValue("SQL_ST_FACILITY_PARAM_SELECT_SINGLE"),stParameter);
	}

	public HashMap getMmParameter() throws Exception{
		return fetchRecord(getStRepositoryValue("SQL_MM_PARAMETER_SELECT_SINGLE"),"MM");
	}

	public ArrayList getListOptionArrayList(String sql,String []stParameters) {
		ArrayList alParameter=new ArrayList (stParameters.length);
		for (int i=0; i<stParameters.length; i++ )
			alParameter.add(stParameters[i]);

		return getListOptionArrayList(sql, alParameter);
	}
/*12/24/2008 Added by mahesh to restrict select when passing string array*/
	public ArrayList getListOptionArrayList(String sql,String []stParameters,boolean isSelectRequired) {
		ArrayList alParameter=new ArrayList (stParameters.length);
		for (int i=0; i<stParameters.length; i++ )
			alParameter.add(stParameters[i]);

		return getListOptionArrayList(sql, alParameter,isSelectRequired);
	}
/*Code added By Mahesh Ends 12/24/2008*/
	public ArrayList getListOptionArrayList(String sql,String parameter,boolean isSelectRequired) {
		ArrayList alParameter=new ArrayList (1);
		alParameter.add(parameter);
		return getListOptionArrayList(sql, alParameter,isSelectRequired);
	}
	/* 
		 This method returns an ArrayList consisting of values (<option values="abc">ABC</option>)
		 for a List based on the query provided by the	user.
		 Parameter :
			String sql - Query 
			ArrayList value - Query Criteria Values
	*/
	public ArrayList getListOptionArrayList(String sql,ArrayList alParameters, boolean isSelectRequired) {
			Connection connection				= null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet					=	null;
			String select_option = "";
			ArrayList alOptionValues = new ArrayList();
			if(getLanguageId()==null){
				String locale_lang=(String)alParameters.get(alParameters.size()-1);
				select_option=getSTMessage(locale_lang,"SELECT_OPTION","ST") ;
			}else
				select_option=getSTMessage(getLanguageId(),"SELECT_OPTION","ST") ;
			String select_option_legend="<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---"+select_option+ "---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
			if(isSelectRequired)
				alOptionValues.add(select_option_legend);
			try {
				connection=getConnection();
				preparedStatement=connection.prepareStatement(sql);
				if (alParameters!=null) {
					for (int index=0;index<alParameters.size();index++) {
						preparedStatement.setString(index+1,alParameters.get(index).toString());
					}
				}
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
//modified by manish on Wednesday, December 31, 2003
					//alOptionValues.add(new Option(REMOVED)Values(resultSet.getString(1),resultSet.getString(2)));
					alOptionValues.add(new String[]{resultSet.getString(1),resultSet.getString(2)});
				}
			}
			catch (java.sql.SQLException exception) {
//modified by manish on Wednesday, December 31, 2003
//				alOptionValues.add(new Option(REMOVED)Values(sql+alParameters+"","SQL Exception :"+exception.getErrorCode()+" : "+ exception.getMessage()));
				alOptionValues.add(new String[]{"",exception.getMessage()});
			}
			catch (Exception exception) {
				alOptionValues.add(new String[]{"",exception.getMessage()});
			//	alOptionValues.add(new Option(REMOVED)Values("","Exception : "+exception.getMessage()));
			}
			finally{
				try { 
					closeResultSet(resultSet);
					closeStatement(preparedStatement);
					closeConnection(connection);
				}
				catch (Exception exception) {
					alOptionValues.add(new String[]{"",exception.getMessage()});
			//		alOptionValues.add(new Option(REMOVED)Values("Error : "+exception.getMessage(),""));
				}
			}
			return alOptionValues;
	}
	public ArrayList getListOptionArrayList(String sql,ArrayList alParameters) {
			Connection connection				= null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet					=	null;
			String select_option= "";
			ArrayList alOptionValues = new ArrayList();
			if(getLanguageId()==null){
				String locale_lang=(String)alParameters.get(alParameters.size()-1);
				select_option=getSTMessage(locale_lang,"SELECT_OPTION","ST") ;
			}else
				select_option=getSTMessage(getLanguageId(),"SELECT_OPTION","ST") ;
			String select_option_legend="<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---"+select_option+ "---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
			alOptionValues.add(select_option_legend);
			try {
				connection=getConnection();
				preparedStatement=connection.prepareStatement(sql);
				if (alParameters!=null) {
					for (int index=0;index<alParameters.size();index++) {
						preparedStatement.setString(index+1,alParameters.get(index).toString());
					}
				}
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
//modified by manish on Wednesday, December 31, 2003
//					alOptionValues.add(new OptionValues(resultSet.getString(1),resultSet.getString(2)));
					alOptionValues.add(new String[]{resultSet.getString(1),resultSet.getString(2)});
					
				}
			}
			catch (java.sql.SQLException exception) {
//modified by manish on Wednesday, December 31, 2003
					
//				alOptionValues.add(new Option(REMOVED)Values(sql+alParameters+"","SQL Exception :"+exception.getErrorCode()+" : "+ exception.getMessage()));
				alOptionValues.add(new String[]{"",exception.getMessage()});
				
			}
			catch (Exception exception) {
				alOptionValues.add(new String[]{"",exception.getMessage()});
				
			//	alOptionValues.add(new Option(REMOVED)Values("","Exception : "+exception.getMessage()));
			}
			finally{
				try { 
					closeResultSet(resultSet);
					closeStatement(preparedStatement);
					closeConnection(connection);
				}
				catch (Exception exception) {
					alOptionValues.add(new String[]{"",exception.getMessage()});
			//		alOptionValues.add(new Option(REMOVED)Values("Error : "+exception.getMessage(),""));
				}
			}
			
			return alOptionValues;
	}

	/* This method is used to convert an array list contents into a string*/
	public String getListOptionTag(ArrayList arrayListValue ) {
		if (arrayListValue == null) {
			return null;
		}
		StringBuffer tagValue = new StringBuffer();
		for (int count=0;count<arrayListValue.size();count++ ) {
			Object obj	=	arrayListValue.get(count);
			if (obj instanceof String[]) {
				tagValue.append("<option value=\"");
				tagValue.append(((String[])obj)[0]);
				tagValue.append("\">");
				tagValue.append(((String[])obj)[1]);
				tagValue.append("</option>\n");
			}
			else{
				tagValue.append(arrayListValue.get(count).toString());
				tagValue.append('\n');
			}
		}
		return tagValue.toString();
	}

	public String getStaticListOptionTag(String stStaticList, String defaultValue) {
		StringBuffer tagValue = new StringBuffer();
		StringTokenizer stListItems=new StringTokenizer(stStaticList,";");
		while (stListItems.hasMoreTokens()) {
			StringTokenizer stListValueText=new StringTokenizer(stListItems.nextToken(),",");
			String value	=	stListValueText.nextToken();
			String selected =    defaultValue.equalsIgnoreCase(value)?"selected":"";
			tagValue.append("<option value=\""+value+"\" "+selected+">"+stListValueText.nextToken()+"</option>\n");
		}
		return tagValue.toString();
	}

	public String getStaticListOptionTag(String stStaticList, String defaultValue, boolean isSelectRequired) {
		StringBuffer tagValue = new StringBuffer();
		StringTokenizer stListItems=new StringTokenizer(stStaticList,";");
		if(isSelectRequired)
			tagValue.append(eST.Common.StRepository.getStKeyValue("DEFAULT_LIST_OPTION").toString());

		while (stListItems.hasMoreTokens()) {
			StringTokenizer stListValueText=new StringTokenizer(stListItems.nextToken(),",");
			String value	=	stListValueText.nextToken();
			String selected =    defaultValue.equalsIgnoreCase(value)?"selected":"";
			tagValue.append("<option value=\""+value+"\" "+selected+">"+stListValueText.nextToken()+"</option>\n");
		}
		return tagValue.toString();
	}
	

	public String getStaticListOptionTag(String stStaticList) {
		return getStaticListOptionTag(stStaticList, "");
	}

	/*  This method is used to convert an array list 
	  *  contents into a string with a default value selected in the List Box 
	  */
	public String getListOptionTag(ArrayList arrayListValue,String defaultValue) {
		if (arrayListValue == null) {
			return null;
		}
		boolean foundDefault = false;
		StringBuffer tagValue = new StringBuffer();
		Object tempObject = null;
		OptionValues tempOptionValues = null;
	
		for (int count=0;count<arrayListValue.size();count++ ) {
			tempObject = arrayListValue.get(count);
			if ((tempObject instanceof String[])) {
				String [] tempStringArray = (String []) tempObject;
				tagValue.append("<option value=\"");
				tagValue.append(tempStringArray[0]);
				tagValue.append("\"");
				if (tempStringArray[0].equals(defaultValue)) {
					tagValue.append(" selected ");
				}
				tagValue.append(">");
				tagValue.append(tempStringArray[1]);
				tagValue.append("</option>\n");
			}
			else if ((!foundDefault) && (tempObject instanceof OptionValues)) {
				tempOptionValues = (OptionValues) tempObject;
				if (tempOptionValues.equals(defaultValue)) {
					foundDefault = true;
					tempOptionValues.setDefault(foundDefault);
				}
				tagValue.append(tempOptionValues.toString());
			}
			else {
				tagValue.append(tempObject.toString());
			}	
			tagValue.append('\n');
		}
//		tagValue.append('\n');
		tempObject = null;
		tempOptionValues = null;
		return tagValue.toString();
	}

	public boolean isModuleInstalled(String moduleID) throws Exception{
		String []stParameters={getLoginFacilityId(),moduleID};
		HashMap hmResult = fetchRecord(getStRepositoryValue("SQL_SM_MODULES_FACILITY_COUNT_VALID"), stParameters);
		return !((String)hmResult.get("TOTAL")).equals("0");
	}

	public String getPeriodEndScope() throws Exception{
/*		HashMap hmResult = fetchRecord(getStRepositoryValue("SQL_(space)MM_(space)INSTALLATION_PARAMETER_SELECT"));*/
		HashMap hmResult = fetchRecord(getStRepositoryValue("SQL_MM_PARAMETER_SELECT_SINGLE"),"MM");
		return checkForNull((String)hmResult.get("ST_PERIOD_END_SCOPE"));
//		return new eMM.MM_license_rights().getSTperiodend();
	}

	public HashMap getMMInstallationParameter() throws Exception{
//		return fetchRecord(getStRepositoryValue("SQL_MM_(space)INSTALLATION_PARAMETER_SELECT"));
		HashMap hmRecord	=	new HashMap();
		HashMap hmParameter	=   fetchRecord(getStRepositoryValue("SQL_MM_PARAMETER_SELECT_SINGLE"),"MM");
		eMM.MM_license_rights lKey = new eMM.MM_license_rights();
		hmRecord.put("INVENTORY_MODULE_SCOPE",	lKey.getSTboundary());
		hmRecord.put("SS_MODULE_SCOPE",			lKey.getSSboundary());
		hmRecord.put("SS_PERIOD_END_SCOPE",		hmParameter.get("SS_PERIOD_END_SCOPE"));//lKey.getSSperiodend());
		hmRecord.put("ST_PERIOD_END_SCOPE",		hmParameter.get("ST_PERIOD_END_SCOPE"));//lKey.getSTperiodend());
		return hmRecord;
	}

	public boolean isDuplicateInArrayList(ArrayList arrayList, String stKeyField, String stValue, int exceptionalIndex){
		String stKeyFields[]={stKeyField};
		String stValues[]={stValue};
		return isDuplicateInArrayList(arrayList, stKeyFields, stValues, exceptionalIndex);
	}	
	
	public boolean isDuplicateInArrayList(ArrayList arrayList, String []stKeyFields, String []stValues, int exceptionalIndex){
		boolean result=false;
		int j=0;
		for (int i=0;i<arrayList.size()&& (!result);i++) {
			if (exceptionalIndex == i) continue;
			result=true;
			for (j=0; j<stKeyFields.length ; j++ ) {
				if (! ((HashMap)arrayList.get(i)).get(stKeyFields[j]).toString().equals(stValues[j])) {
					result=false;
					break;
				}
			}
		//	if (j==stKeyFields.length) {
		//	}
		}
/*		for (int i=0; i<stValues.length; i++) {
		}
*/
		return result;
	}

	public HashMap getDefaultStParameter() throws Exception {
		return getStParameter();
//		String []stParameters={getLoginFacilityId(),"ALL"};
//		return fetchRecord(StRepository.getStKeyValue("SQL_ST_FACILITY_PARAM_SELECT_SINGLE"),stParameters);
    }

	 public String getSystemDate() throws Exception {
        HashMap hashmap = fetchRecord(CommonRepository.getCommonKeyValue("SQL_SYS_DATE_TIME"));
        return (String)hashmap.get("SYS_DATE");
    }

	public String getDecimalPrecision(String acc_entity_id) {
		try {
			HashMap hashmap = fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_SM_ACC_ENTITY_PARAM_DECIMAL_SELECT"),acc_entity_id);
			return (String) hashmap.get("NO_OF_DECIMAL");
		}
		catch (Exception exception) {
//			exception.printStackTrace();
			return "0";
		}
	}

public ArrayList getWithoutLangIdListOptionArrayList(String sql) {
		return getWithoutLangIdListOptionArrayList(sql,new ArrayList(0));
	}

	public ArrayList getWithoutLangIdListOptionArrayList(String sql,ArrayList alParameters) {
			Connection connection				= null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet					=	null;

			ArrayList alOptionValues = new ArrayList();
			//String locale_lang=(String)alParameters.get(alParameters.size()-1);
			//String select_option=getSTMessage(locale_lang,"SELECT_OPTION","ST") ;
			//String select_option_legend="<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---"+select_option+ "---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
			alOptionValues.add(StRepository.getStKeyValue("DEFAULT_LIST_OPTION"));
			try {
				connection=getConnection();
				preparedStatement=connection.prepareStatement(sql);
				if (alParameters!=null) {
					for (int index=0;index<alParameters.size();index++) {
						preparedStatement.setString(index+1,alParameters.get(index).toString());
					}
				}
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
//modified by manish on Wednesday, December 31, 2003
//					alOptionValues.add(new OptionValues(resultSet.getString(1),resultSet.getString(2)));
					alOptionValues.add(new String[]{resultSet.getString(1),resultSet.getString(2)});
					
				}
			}
			catch (java.sql.SQLException exception) {
//modified by manish on Wednesday, December 31, 2003
					
//				alOptionValues.add(new Option(REMOVED)Values(sql+alParameters+"","SQL Exception :"+exception.getErrorCode()+" : "+ exception.getMessage()));
				alOptionValues.add(new String[]{"",exception.getMessage()});
				
			}
			catch (Exception exception) {
				alOptionValues.add(new String[]{"",exception.getMessage()});
				
			//	alOptionValues.add(new Option(REMOVED)Values("","Exception : "+exception.getMessage()));
			}
			finally{
				try { 
					closeResultSet(resultSet);
					closeStatement(preparedStatement);
					closeConnection(connection);
				}
				catch (Exception exception) {
					alOptionValues.add(new String[]{"",exception.getMessage()});
			//		alOptionValues.add(new Option(REMOVED)Values("Error : "+exception.getMessage(),""));
				}
			}
			
			return alOptionValues;
	}

public  String getSTMessage(String locale, String messageId, String moduleId)
	{
        java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
        return(mesg) ;
    }
	public String getDecimalPattern(String number) {
		if (number != null && number.trim() != "") {
			java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("###########.###");
			return decimalFormat.format(new Double(number));
		}
		return number;
	}

	public String getSTITBin_location_code_List(String store_code, String item_code, String bin_location_code,String language) {
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_ITEM_STORE_BIN_LOCN_SELECT_LIST"),new String[]{store_code,item_code,language}),bin_location_code);
	}	

	public ArrayList getSTITBin_location_code_ArrayList(String store_code, String item_code,String language)throws Exception {
		return fetchRecords(getStRepositoryValue("SQL_ST_ITEM_STORE_BIN_LOCN_SELECT_LIST"),new String[]{store_code,item_code,language});
	}	
//Added By Mahesh	
	public Boolean getAckReqd(){
		String ack_reqd = "N";
		try{
			ack_reqd = (String)fetchRecord("SELECT ACKNOWLEDGE_REQD_YN FROM ST_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId()).get("ACKNOWLEDGE_REQD_YN");
		}catch(Exception e){
			e.printStackTrace();
		}
		return checkForNull(ack_reqd,"N").equals("Y");
	}
	public double getConvFactTemp(String item_code,String store_code){
		double conv_fac_temp=1;
		ArrayList alParameters = new ArrayList();
		if(convFactMap.containsKey(item_code+store_code)){
			return convFactMap.get(item_code+store_code);
		}
		try {
			
		    alParameters.add(item_code);
			alParameters.add(store_code);

		   conv_fac_temp=Double.parseDouble((String)fetchRecord("SELECT ST_GET_UOM_CONV_FAC_SING_STR(?,?) CONV_FACTOR FROM DUAL",	alParameters).get("CONV_FACTOR"));
		   convFactMap.put(item_code+store_code,conv_fac_temp);
		}	catch(Exception e){
			e.printStackTrace();
		}
		return conv_fac_temp;
	}
	public String getGenItemUOM(String item_code) throws Exception {
		String chkdefaultParameters[] = {item_code,getLanguageId()};
		String gen_uom_code			  = "";	
		HashMap base_uom			  = new HashMap();
		try{
			base_uom = fetchRecord(getStRepositoryValue("SQL_ST_GEN_UOM_CODE_SELECT"),chkdefaultParameters);
		}catch(Exception e){
			gen_uom_code = "";
		}
		
		if(base_uom.size() > 0)
			gen_uom_code = (String)base_uom.get("GEN_UOM_CODE");

		return gen_uom_code;

	}
//Added by Mahesh on 11/6/2008 to access acc_entity_id from any JSP.
	public void setAcc_entity_id(String acc_entity_id) {
		 this.acc_entity_id= acc_entity_id;
	}

	public String getAcc_entity_id( ) {
		 return acc_entity_id;
	}

/*Method added for Kit Template*/
	public void kitTemplateValues(String kit_template_code,String store_code,String store_code_to){
		count = 0;
		ArrayList alParams = new ArrayList();
		alParams.add(getLanguageId());
		alParams.add(kit_template_code);
		alParams.add(store_code);
		alParams.add(store_code_to);
		alParams.add(getLanguageId());
		alParams.add(getLanguageId());
		alParams.add(getLanguageId());
		alParams.add(store_code);
		alParams.add(store_code);
		alParams.add(kit_template_code);
		alParams.add(getLanguageId());
		
		
		
		ArrayList result = new ArrayList();
		try{
			//result = fetchRecords("SELECT 'Y' KIT_ITEM_YN, KIT_UOM_CODE, KIT_UOM_DESC, ITEM_CODE,SUM (QUANTITY) QUANTITY, SHORT_DESC, UOM_CODE, EXPIRY_YN,GEN_UOM_DESC, SUM (UNIT_COST) ITEM_UNIT_COST, SUM (ITEM_VALUE) TOT_ITEM_VALUE,(SUM (UNIT_COST) * (SUM (QUANTITY))) ITEM_VALUE, STOCK_UOM_DESC,DEF_ISSUE_UOM, SEQ_NO FROM (SELECT KIT.UOM_CODE KIT_UOM_CODE,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = KIT.UOM_CODE AND LANGUAGE_ID = ?) KIT_UOM_DESC, KIT.ITEM_CODE,(CASE WHEN STI.DEF_ISSUE_UOM = KIT.UOM_CODE AND STS.DEF_ISSUE_UOM = KIT.UOM_CODE AND STI.EFF_STATUS = 'E' AND STS.EFF_STATUS = 'E' THEN KIT.QUANTITY ELSE 0 END ) QUANTITY, MM.SHORT_DESC, MM.GEN_UOM_CODE UOM_CODE, ST.EXPIRY_YN,AM1.SHORT_DESC GEN_UOM_DESC,ROUND (  NVL (STI.ITEM_VALUE, 0)/ (DECODE (STI.QTY_ON_HAND, 0, 1, STI.QTY_ON_HAND)),3) UNIT_COST,STI.ITEM_VALUE, AM.SHORT_DESC STOCK_UOM_DESC,STI.DEF_ISSUE_UOM, SEQ_NO FROM ST_KIT_TEMPLATE_DTL KIT,MM_ITEM_LANG_VW MM,ST_ITEM ST,AM_UOM_LANG_VW AM1,AM_UOM_LANG_VW AM,ST_ITEM_STORE STI,ST_ITEM_STORE STS WHERE KIT_TEMPLATE_CODE = ? AND MM.ITEM_CODE = KIT.ITEM_CODE AND KIT.ITEM_CODE = STI.ITEM_CODE(+) AND KIT.ITEM_CODE = STS.ITEM_CODE AND STI.DEF_ISSUE_UOM = AM.UOM_CODE AND STI.STORE_CODE = ? AND STS.STORE_CODE = ? AND MM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = ? AND KIT.EFF_STATUS = 'E' AND ST.ITEM_CODE = KIT.ITEM_CODE AND MM.LANGUAGE_ID = AM1.LANGUAGE_ID AND MM.GEN_UOM_CODE = AM1.UOM_CODE AND MM.LANGUAGE_ID = AM1.LANGUAGE_ID UNION SELECT KIT.UOM_CODE KIT_UOM_CODE, (SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = KIT.UOM_CODE AND LANGUAGE_ID = ?) KIT_UOM_DESC, KIT.ITEM_CODE, 0 QUANTITY, MM.SHORT_DESC, MM.GEN_UOM_CODE UOM_CODE, ST.EXPIRY_YN,AM1.SHORT_DESC GEN_UOM_DESC, 0 UNIT_COST, 0 ITEM_VALUE,(SELECT SHORT_DESC FROM ST_ITEM_STORE A,ST_KIT_TEMPLATE_DTL B,AM_UOM C WHERE A.ITEM_CODE = B.ITEM_CODE AND KIT_TEMPLATE_CODE = KIT.KIT_TEMPLATE_CODE AND A.ITEM_CODE = KIT.ITEM_CODE AND STORE_CODE = ? AND C.UOM_CODE = A.DEF_ISSUE_UOM) STOCK_UOM_DESC,(SELECT DEF_ISSUE_UOM FROM ST_ITEM_STORE A, ST_KIT_TEMPLATE_DTL B WHERE A.ITEM_CODE = B.ITEM_CODE AND KIT_TEMPLATE_CODE = KIT.KIT_TEMPLATE_CODE AND A.ITEM_CODE = KIT.ITEM_CODE AND STORE_CODE = ?) DEF_ISSUE_UOM, SEQ_NO FROM ST_KIT_TEMPLATE_DTL KIT,MM_ITEM_LANG_VW MM,ST_ITEM ST,AM_UOM_LANG_VW AM1 WHERE KIT_TEMPLATE_CODE = ? AND MM.ITEM_CODE = KIT.ITEM_CODE AND MM.LANGUAGE_ID = ? AND KIT.EFF_STATUS = 'E' AND ST.ITEM_CODE = KIT.ITEM_CODE AND MM.LANGUAGE_ID = AM1.LANGUAGE_ID AND MM.GEN_UOM_CODE = AM1.UOM_CODE AND MM.LANGUAGE_ID = AM1.LANGUAGE_ID) GROUP BY ITEM_CODE,SHORT_DESC,UOM_CODE, EXPIRY_YN,GEN_UOM_DESC, STOCK_UOM_DESC,DEF_ISSUE_UOM,SEQ_NO, KIT_UOM_CODE,KIT_UOM_DESC ORDER BY SEQ_NO, SHORT_DESC",alParams);
			
		/**
		 * @Name - Priya
		 * @Date - 08/06/2010
		 * @Inc# - 
		 * @Desc -    To get the Unit Cost from the function 'ST_DISPLAY_COST_DECIMALS' the above query is modified 
		 */
			result = fetchRecords("SELECT 'Y' KIT_ITEM_YN, KIT_UOM_CODE, KIT_UOM_DESC, ITEM_CODE,SUM (QUANTITY) QUANTITY, SHORT_DESC, UOM_CODE, EXPIRY_YN,GEN_UOM_DESC, SUM (UNIT_COST) ITEM_UNIT_COST, SUM (ITEM_VALUE) TOT_ITEM_VALUE,(SUM (UNIT_COST) * (SUM (QUANTITY))) ITEM_VALUE, STOCK_UOM_DESC,DEF_ISSUE_UOM, SEQ_NO, KIT_TEMPLATE_CODE ,USAGE_TYPE FROM (SELECT KIT.UOM_CODE KIT_UOM_CODE,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = KIT.UOM_CODE AND LANGUAGE_ID = ?) KIT_UOM_DESC, KIT.ITEM_CODE,(CASE WHEN STI.DEF_ISSUE_UOM = KIT.UOM_CODE AND STS.DEF_ISSUE_UOM = KIT.UOM_CODE AND STI.EFF_STATUS = 'E' AND STS.EFF_STATUS = 'E' THEN KIT.QUANTITY ELSE 0 END ) QUANTITY, MM.SHORT_DESC, MM.GEN_UOM_CODE UOM_CODE, ST.EXPIRY_YN,AM1.SHORT_DESC GEN_UOM_DESC,TRIM(ST_DISPLAY_COST_DECIMALS (STI.ITEM_CODE, STI.STORE_CODE )) UNIT_COST,STI.ITEM_VALUE, AM.SHORT_DESC STOCK_UOM_DESC,STI.DEF_ISSUE_UOM, SEQ_NO, KIT.KIT_TEMPLATE_CODE,KIT.USAGE_TYPE  FROM ST_KIT_TEMPLATE_DTL KIT,MM_ITEM_LANG_VW MM,ST_ITEM ST,AM_UOM_LANG_VW AM1,AM_UOM_LANG_VW AM,ST_ITEM_STORE STI,ST_ITEM_STORE STS WHERE KIT_TEMPLATE_CODE = ? AND MM.ITEM_CODE = KIT.ITEM_CODE AND KIT.ITEM_CODE = STI.ITEM_CODE(+) AND KIT.ITEM_CODE = STS.ITEM_CODE AND STI.DEF_ISSUE_UOM = AM.UOM_CODE AND STI.STORE_CODE = ? AND STS.STORE_CODE = ? AND MM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = ? AND KIT.EFF_STATUS = 'E' AND ST.ITEM_CODE = KIT.ITEM_CODE AND MM.LANGUAGE_ID = AM1.LANGUAGE_ID AND MM.GEN_UOM_CODE = AM1.UOM_CODE AND MM.LANGUAGE_ID = AM1.LANGUAGE_ID UNION SELECT KIT.UOM_CODE KIT_UOM_CODE, (SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = KIT.UOM_CODE AND LANGUAGE_ID = ?) KIT_UOM_DESC, KIT.ITEM_CODE, 0 QUANTITY, MM.SHORT_DESC, MM.GEN_UOM_CODE UOM_CODE, ST.EXPIRY_YN,AM1.SHORT_DESC GEN_UOM_DESC, '0' UNIT_COST, 0 ITEM_VALUE,(SELECT SHORT_DESC FROM ST_ITEM_STORE A,ST_KIT_TEMPLATE_DTL B,AM_UOM C WHERE A.ITEM_CODE = B.ITEM_CODE AND KIT_TEMPLATE_CODE = KIT.KIT_TEMPLATE_CODE AND A.ITEM_CODE = KIT.ITEM_CODE AND STORE_CODE = ? AND C.UOM_CODE = A.DEF_ISSUE_UOM) STOCK_UOM_DESC,(SELECT DEF_ISSUE_UOM FROM ST_ITEM_STORE A, ST_KIT_TEMPLATE_DTL B WHERE A.ITEM_CODE = B.ITEM_CODE AND KIT_TEMPLATE_CODE = KIT.KIT_TEMPLATE_CODE AND A.ITEM_CODE = KIT.ITEM_CODE AND STORE_CODE = ?) DEF_ISSUE_UOM, SEQ_NO,KIT_TEMPLATE_CODE,USAGE_TYPE FROM ST_KIT_TEMPLATE_DTL KIT,MM_ITEM_LANG_VW MM,ST_ITEM ST,AM_UOM_LANG_VW AM1 WHERE KIT_TEMPLATE_CODE = ? AND MM.ITEM_CODE = KIT.ITEM_CODE AND MM.LANGUAGE_ID = ? AND KIT.EFF_STATUS = 'E' AND ST.ITEM_CODE = KIT.ITEM_CODE AND MM.LANGUAGE_ID = AM1.LANGUAGE_ID AND MM.GEN_UOM_CODE = AM1.UOM_CODE AND MM.LANGUAGE_ID = AM1.LANGUAGE_ID) GROUP BY ITEM_CODE,SHORT_DESC,UOM_CODE, EXPIRY_YN,GEN_UOM_DESC, STOCK_UOM_DESC,DEF_ISSUE_UOM,SEQ_NO, KIT_UOM_CODE,KIT_UOM_DESC,KIT_TEMPLATE_CODE,USAGE_TYPE ORDER BY SEQ_NO, SHORT_DESC",alParams);
			//result = fetchRecords("SELECT   'Y' KIT_ITEM_YN, KIT_UOM_CODE, KIT_UOM_DESC, ITEM_CODE,SUM (QUANTITY) QUANTITY, SHORT_DESC, UOM_CODE, EXPIRY_YN,GEN_UOM_DESC, UNIT_COST, STOCK_UOM_DESC, DEF_ISSUE_UOM, SEQ_NO    FROM (SELECT KIT.UOM_CODE KIT_UOM_CODE, (SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = KIT.UOM_CODE AND LANGUAGE_ID = ?) KIT_UOM_DESC, KIT.ITEM_CODE, (CASE WHEN STI.DEF_ISSUE_UOM = KIT.UOM_CODE AND STS.DEF_ISSUE_UOM = KIT.UOM_CODE THEN KIT.QUANTITY ELSE 0 END ) QUANTITY, MM.SHORT_DESC, MM.GEN_UOM_CODE UOM_CODE, ST.EXPIRY_YN, AM1.SHORT_DESC GEN_UOM_DESC, MM.UNIT_COST, AM.SHORT_DESC STOCK_UOM_DESC, STI.DEF_ISSUE_UOM, SEQ_NO FROM ST_KIT_TEMPLATE_DTL KIT, MM_ITEM_LANG_VW MM, ST_ITEM ST, AM_UOM_LANG_VW AM1, AM_UOM_LANG_VW AM, ST_ITEM_STORE STI, ST_ITEM_STORE STS WHERE KIT_TEMPLATE_CODE = ? AND MM.ITEM_CODE = KIT.ITEM_CODE AND KIT.ITEM_CODE = STI.ITEM_CODE(+) AND KIT.ITEM_CODE = STS.ITEM_CODE AND STI.DEF_ISSUE_UOM = AM.UOM_CODE AND STI.STORE_CODE = ? AND STS.STORE_CODE = ? AND MM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = ? AND KIT.EFF_STATUS = 'E' AND ST.ITEM_CODE = KIT.ITEM_CODE AND MM.LANGUAGE_ID = AM1.LANGUAGE_ID AND MM.GEN_UOM_CODE = AM1.UOM_CODE AND MM.LANGUAGE_ID = AM1.LANGUAGE_ID UNION SELECT KIT.UOM_CODE KIT_UOM_CODE, (SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = KIT.UOM_CODE AND LANGUAGE_ID = ?) KIT_UOM_DESC, KIT.ITEM_CODE, 0 QUANTITY, MM.SHORT_DESC, MM.GEN_UOM_CODE UOM_CODE, ST.EXPIRY_YN, AM1.SHORT_DESC GEN_UOM_DESC, MM.UNIT_COST, (SELECT SHORT_DESC FROM ST_ITEM_STORE A, ST_KIT_TEMPLATE_DTL B,AM_UOM C WHERE A.ITEM_CODE = B.ITEM_CODE AND KIT_TEMPLATE_CODE = KIT.KIT_TEMPLATE_CODE AND A.ITEM_CODE = KIT.ITEM_CODE AND STORE_CODE = ? AND C.UOM_CODE = A.DEF_ISSUE_UOM) STOCK_UOM_DESC, (SELECT DEF_ISSUE_UOM FROM ST_ITEM_STORE A, ST_KIT_TEMPLATE_DTL B WHERE A.ITEM_CODE = B.ITEM_CODE AND KIT_TEMPLATE_CODE = KIT.KIT_TEMPLATE_CODE AND A.ITEM_CODE = KIT.ITEM_CODE AND STORE_CODE = ?) DEF_ISSUE_UOM, SEQ_NO FROM ST_KIT_TEMPLATE_DTL KIT, MM_ITEM_LANG_VW MM, ST_ITEM ST, AM_UOM_LANG_VW AM1  WHERE KIT_TEMPLATE_CODE = ? AND MM.ITEM_CODE = KIT.ITEM_CODE AND MM.LANGUAGE_ID = ? AND KIT.EFF_STATUS = 'E' AND ST.ITEM_CODE = KIT.ITEM_CODE AND MM.LANGUAGE_ID = AM1.LANGUAGE_ID AND MM.GEN_UOM_CODE = AM1.UOM_CODE AND MM.LANGUAGE_ID = AM1.LANGUAGE_ID) GROUP BY ITEM_CODE, SHORT_DESC, UOM_CODE, EXPIRY_YN, GEN_UOM_DESC, UNIT_COST, STOCK_UOM_DESC, DEF_ISSUE_UOM, SEQ_NO, KIT_UOM_CODE, KIT_UOM_DESC ORDER BY SEQ_NO,SHORT_DESC",alParams);
		}catch(Exception e){
			e.printStackTrace();
		}
		kitDataList = result;
	}
	public int getCount(){
		return count++;
	}

	public ArrayList getKitDtlData(){
		return kitDataList;
	}/*Method ends*/
/*Method moved to Adapter class as this is used commonly in more than 8 function Mahesh 14/12/2009*/
	public String getAccessCostDetails(){
		String cost_yn			  = "N";	
		HashMap view_cost_yn	  = new HashMap();
		try{
			view_cost_yn = fetchRecord(getStRepositoryValue("ST_SQL_VIEW_COST_YN_SELECT"),getLoginById());
		}catch(Exception e){
			cost_yn = "";
		}
		if(view_cost_yn.size() > 0){
			//Check For Null is added on 14/12/2009 By Mahesh
			cost_yn = checkForNull((String)view_cost_yn.get("VIEW_COST_YN"),"N");
		}
		return cost_yn;
	}
/*	public String setNumber(String stNumber, int decimalPlaces){
		if((checkForNull(stNumber)).equals("")){
			return "";
		}
		if(Double.parseDouble(stNumber)== 0){
			return "0";
		}
		if(Double.parseDouble(stNumber) < 1 && Double.parseDouble(stNumber) > 0){
			stNumber = "0"+stNumber;
		}
		String returnNumber	=	"0";
		try { 
		String fmt = "0";
		for(int i=0;i<decimalPlaces;i++){
			if(i==0){
				fmt= fmt + ".";
			}
			fmt= fmt+ "0";
		}


		java.text.DecimalFormat df = new java.text.DecimalFormat(fmt);
		returnNumber = df.format(Double.parseDouble(stNumber));
				}
		catch (Exception exception) {
		//	exception.printStackTrace();
		}
		return returnNumber;
	}*/
	
	public String setNumber(String stNumber, int decimalPlaces) {
	    // Check for null or empty string
	    stNumber = checkForNull(stNumber);
	    if (stNumber.isEmpty()) {
	        return "";
	    }

	    // Remove non-breaking spaces and trim leading/trailing whitespace
	    stNumber = stNumber.replace("\u00A0", "").trim();

	    try {
	        double number = Double.parseDouble(stNumber);

	        if (number == 0) {
	            return "0";
	        }

	        // Check if number is between 0 and 1 (exclusive) and prepend "0" if true
	        if (number < 1 && number > 0) {
	            stNumber = "0" + stNumber;
	        }

			if (decimalPlaces == 0) {
				return String.valueOf((int) number); // Return as an integer if no decimals
			}
		
	        // Format the number to specified decimal places
	        String fmt = "0.";
	        for (int i = 0; i < decimalPlaces; i++) {
	            fmt += "0";
	        }

	        java.text.DecimalFormat df = new java.text.DecimalFormat(fmt);
	        return df.format(Double.parseDouble(stNumber));
	    } catch (NumberFormatException e) {
	        // Handle the case where parsing fails
	        e.printStackTrace();  // Log the exception for debugging
	        // Return an appropriate error message or handle the exception accordingly
	        return "0"; // Default return value or handle as needed
	    }
	}
	
	public String setNumberFormat(String stNumber, int decimalPlaces){
		if(stNumber.equals("")){
			return "";
		}
		if(Double.parseDouble(stNumber)== 0){
			return "0";
		}
		if(Double.parseDouble(stNumber) < 1 && Double.parseDouble(stNumber) > 0){
			stNumber = "0"+stNumber;
		}
		String returnNumber	=	"0";
		try { 
		String fmt = "";
		int length = 0;
		if(stNumber.indexOf(".")!=-1){
			length = stNumber.indexOf(".");
		}else{
			length = stNumber.length();
		}
		for(int i=1;i<length;i++){
			fmt = "0"+fmt;
			if(i%3==0){
				fmt = ","+fmt;
			}
		}
		if(fmt.length()==0){
			fmt = "0";
		}
		for(int i=0;i<decimalPlaces;i++){
			if(i==0){
				fmt= fmt + ".";
			}
			fmt= fmt+ "0";
		}

		java.text.DecimalFormat df = new java.text.DecimalFormat(fmt);
		returnNumber = df.format(Double.parseDouble(stNumber));
				}
		catch (Exception exception) {
		//	exception.printStackTrace();
		}
		return returnNumber;
	}
/**
	* @Name - Mahesh
	* @Date - 05/01/2010
	* @Inc# - IN015494
	* @Desc - The Follwing Three methods are used accros the module...so created in StAdapter.
	*/

	public int getNoOfDecimals(){
		int no_of_decimals			  = 0;	
		HashMap hm_no_of_decimals	  = new HashMap();
		try{
			hm_no_of_decimals = fetchRecord("SELECT NO_OF_DECIMALS FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID = 'ZZ'");
		}catch(Exception e){
			no_of_decimals = 0;
		}
		if(hm_no_of_decimals.size() > 0){
			no_of_decimals = Integer.parseInt(checkForNull((String)hm_no_of_decimals.get("NO_OF_DECIMALS"),"0"));
		}
		return no_of_decimals;
	}

	public String getDispDecimalDtlsYN(){
		String disp_decimal_dtls_yn			  = "N";	
		HashMap hm_disp_decimal_dtls_yn	  = new HashMap();
		try{
			hm_disp_decimal_dtls_yn = fetchRecord("SELECT DISP_DECIMAL_DTLS_YN FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID = 'ZZ'");
		}catch(Exception e){
			disp_decimal_dtls_yn = "";
		}
		if(hm_disp_decimal_dtls_yn.size() > 0){
			disp_decimal_dtls_yn = checkForNull((String)hm_disp_decimal_dtls_yn.get("DISP_DECIMAL_DTLS_YN"),"N");
		}
		return disp_decimal_dtls_yn;
	}

	public String getAllowDecimalsYN(String item_code){
		if((checkForNull(item_code)).equals("")){
			return "N";
		}
		if(getDispDecimalDtlsYN().equals("N")){
			return "N";
		}
		String allow_decimals_yn			  = "N";	
		HashMap hm_allow_decimals_yn	  = new HashMap();
		try{
			hm_allow_decimals_yn = fetchRecord("SELECT ALLOW_DECIMALS_YN FROM ST_ITEM WHERE ITEM_CODE = ?",item_code);
		}catch(Exception e){
			allow_decimals_yn = "N";
		}
		if(hm_allow_decimals_yn.size() > 0){
			allow_decimals_yn = checkForNull((String)hm_allow_decimals_yn.get("ALLOW_DECIMALS_YN"),"N");
		}
		return allow_decimals_yn;
	}

	public String getItemClassBased(String trn_type){
		String item_class_based = "N";
		try{
			item_class_based = checkForNull((String)fetchRecord("SELECT ITEM_CLASS_WISE_DOCUMENTS_YN ITEM_CLASS_BASED FROM ST_TRN_TYPE WHERE TRN_TYPE = ?",trn_type).get("ITEM_CLASS_BASED"),"N");
		}catch(Exception e){
			e.printStackTrace();
		}
		return item_class_based;
	}
	public int getRecordsPerTrn(String trn_type){
		int records_per_trn = 999999;
		try{
			records_per_trn = Integer.parseInt(checkForNull((String)fetchRecord("SELECT RECORDS_PER_TRN FROM ST_TRN_TYPE WHERE TRN_TYPE=?",trn_type).get("RECORDS_PER_TRN"),"999999"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return records_per_trn;
	}
	public String getAutoDocGen(String doc_type_code){
		String doc_num_gen_flag = "N";
		try{
			doc_num_gen_flag = checkForNull((String)fetchRecord(StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"),doc_type_code).get("DOC_NUM_GEN_FLAG"),"N");
		}catch(Exception e){
			e.printStackTrace();
		}
		return doc_num_gen_flag;
	}

/**/
	public HashMap<String,String> getConvFactTemp(String item_code,String fm_store_code,String to_store_code){
		HashMap<String,String> conv_factors = new HashMap<String,String>();
		String conv_fac_fm_temp = "";
		String conv_fac_to_temp = "";
		int fm_str_eqvl = 1;
		int fm_str_eqvl_qty = 1;
		int to_str_eqvl = 1;
		int to_str_eqvl_qty = 1;
		
		int fm_str_eqvl_temp = 1;
		int fm_str_eqvl_qty_temp = 1;
		int to_str_eqvl_temp = 1;
		int to_str_eqvl_qty_temp = 1;
		try {
			if(convFactMapDuo.containsKey(item_code+fm_store_code)){
				conv_fac_fm_temp = convFactMapDuo.get(item_code+fm_store_code);
			}else{
				conv_fac_fm_temp=(String)fetchRecord("SELECT ST_GET_UOM_CONV_FACTOR_DUO_STR(?,?) CONV_FACTOR FROM DUAL",	new String[]{item_code,fm_store_code}).get("CONV_FACTOR");
				convFactMapDuo.put(item_code+fm_store_code,conv_fac_fm_temp);
			}
			if(convFactMapDuo.containsKey(item_code+to_store_code)){
				conv_fac_to_temp = convFactMapDuo.get(item_code+to_store_code);
			}else{
				conv_fac_to_temp=(String)fetchRecord("SELECT ST_GET_UOM_CONV_FACTOR_DUO_STR(?,?) CONV_FACTOR FROM DUAL",	new String[]{item_code,to_store_code}).get("CONV_FACTOR");
				convFactMapDuo.put(item_code+to_store_code,conv_fac_to_temp);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		if(conv_fac_fm_temp.indexOf("~")!=-1){
			fm_str_eqvl_temp = Integer.parseInt(conv_fac_fm_temp.substring(0,conv_fac_fm_temp.indexOf("~")));
			fm_str_eqvl_qty_temp = Integer.parseInt(conv_fac_fm_temp.substring(conv_fac_fm_temp.indexOf("~")+1,conv_fac_fm_temp.length()));
		}
		if(conv_fac_to_temp.indexOf("~")!=-1){
			to_str_eqvl_temp = Integer.parseInt(conv_fac_to_temp.substring(0,conv_fac_to_temp.indexOf("~")));
			to_str_eqvl_qty_temp = Integer.parseInt(conv_fac_to_temp.substring(conv_fac_to_temp.indexOf("~")+1,conv_fac_to_temp.length()));
		}
/**/
		fm_str_eqvl_qty = fm_str_eqvl_qty_temp / gcd(fm_str_eqvl_temp,fm_str_eqvl_qty_temp);
		fm_str_eqvl = fm_str_eqvl_temp / gcd(fm_str_eqvl_temp,fm_str_eqvl_qty_temp);
		to_str_eqvl_qty = to_str_eqvl_qty_temp / gcd(to_str_eqvl_temp,to_str_eqvl_qty_temp);
		to_str_eqvl = to_str_eqvl_temp / gcd(to_str_eqvl_temp,to_str_eqvl_qty_temp);
		if(fm_str_eqvl_temp%fm_str_eqvl_qty_temp == 0){
			conv_factors.put("FROM_STORE_MULTIPLES",""+getLcm(fm_str_eqvl,to_str_eqvl)/fm_str_eqvl);
			conv_factors.put("TO_STORE_MULTIPLES",""+getLcm(fm_str_eqvl,to_str_eqvl)/to_str_eqvl);
			conv_factors.put("BATCH_QTY_MULTIPLES",""+getLcm(fm_str_eqvl,to_str_eqvl));
		}else{
			conv_factors.put("FROM_STORE_MULTIPLES",""+(fm_str_eqvl_qty*to_str_eqvl));
			conv_factors.put("TO_STORE_MULTIPLES",""+(to_str_eqvl_qty*fm_str_eqvl));
			conv_factors.put("BATCH_QTY_MULTIPLES",""+(fm_str_eqvl*to_str_eqvl));
		}
/**/
		return conv_factors;
	}
	public int gcd(int first,int second){
		int lowest = (first < second) ? first:second;
		for (int i = lowest; i > 1; i--) {
			if (first % i == 0 && second % i == 0) {
				return i;
				//hcd = i;
			}
		}
		return 1;
	}
	public int getLcm(int from,int to){
		return (from*to)/gcd(from,to);
	}		
/**/
	public HashMap<String,String> getConvFactTemp(String item_code,String fm_store_code,String to_store_code,String issue_uom){
		HashMap<String,String> conv_factors = new HashMap<String,String>();
		String conv_fac_fm_temp = "";
		String conv_fac_to_temp = "";
		String conv_fac_issue_uom = "";
		int fm_str_eqvl = 1;
		int fm_str_eqvl_qty = 1;
		int to_str_eqvl = 1;
		int to_str_eqvl_qty = 1;
		int issue_uom_eqvl = 1;
		int issue_uom_eqvl_qty = 1;
		
		int fm_str_eqvl_temp = 1;
		int fm_str_eqvl_qty_temp = 1;
		int to_str_eqvl_temp = 1;
		int to_str_eqvl_qty_temp = 1;
		int issue_uom_eqvl_temp = 1;
		int issue_uom_eqvl_qty_temp = 1;
		try {
			if(convFactMapDuo.containsKey(item_code+fm_store_code)){
				conv_fac_fm_temp = convFactMapDuo.get(item_code+fm_store_code);
			}else{
				conv_fac_fm_temp=(String)fetchRecord("SELECT ST_GET_UOM_CONV_FACTOR_DUO_STR(?,?) CONV_FACTOR FROM DUAL",	new String[]{item_code,fm_store_code}).get("CONV_FACTOR");
				convFactMapDuo.put(item_code+fm_store_code,conv_fac_fm_temp);
			}
			if(convFactMapDuo.containsKey(item_code+to_store_code)){
				conv_fac_to_temp = convFactMapDuo.get(item_code+to_store_code);
			}else{
				conv_fac_to_temp=(String)fetchRecord("SELECT ST_GET_UOM_CONV_FACTOR_DUO_STR(?,?) CONV_FACTOR FROM DUAL",	new String[]{item_code,to_store_code}).get("CONV_FACTOR");
				convFactMapDuo.put(item_code+to_store_code,conv_fac_to_temp);
			}
			//conv_fac_to_temp=(String)fetchRecord("SELECT ST_GET_UOM_CONV_FACTOR_DUO_STR(?,?) CONV_FACTOR FROM DUAL",	new String[]{item_code,to_store_code}).get("CONV_FACTOR");
			if(convFactMapDuo.containsKey(item_code+issue_uom)){
			}else{
				conv_fac_issue_uom=(String)fetchRecord("SELECT ST_GET_UOM_CONV_FACTOR_UOM(?,?) CONV_FACTOR FROM DUAL",	new String[]{item_code,issue_uom}).get("CONV_FACTOR");
				convFactMapDuo.put(item_code+issue_uom,conv_fac_issue_uom);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		if(conv_fac_fm_temp.indexOf("~")!=-1){
			fm_str_eqvl_temp = Integer.parseInt(conv_fac_fm_temp.substring(0,conv_fac_fm_temp.indexOf("~")));
			fm_str_eqvl_qty_temp = Integer.parseInt(conv_fac_fm_temp.substring(conv_fac_fm_temp.indexOf("~")+1,conv_fac_fm_temp.length()));
		}
		if(conv_fac_to_temp.indexOf("~")!=-1){
			to_str_eqvl_temp = Integer.parseInt(conv_fac_to_temp.substring(0,conv_fac_to_temp.indexOf("~")));
			to_str_eqvl_qty_temp = Integer.parseInt(conv_fac_to_temp.substring(conv_fac_to_temp.indexOf("~")+1,conv_fac_to_temp.length()));
		}
		if(conv_fac_issue_uom.indexOf("~")!=-1){
			issue_uom_eqvl_temp = Integer.parseInt(conv_fac_issue_uom.substring(0,conv_fac_issue_uom.indexOf("~")));
			issue_uom_eqvl_qty_temp = Integer.parseInt(conv_fac_issue_uom.substring(conv_fac_issue_uom.indexOf("~")+1,conv_fac_issue_uom.length()));
		}
/**/
		fm_str_eqvl_qty = fm_str_eqvl_qty_temp / gcd(fm_str_eqvl_temp,fm_str_eqvl_qty_temp);
		fm_str_eqvl = fm_str_eqvl_temp / gcd(fm_str_eqvl_temp,fm_str_eqvl_qty_temp);
		to_str_eqvl_qty = to_str_eqvl_qty_temp / gcd(to_str_eqvl_temp,to_str_eqvl_qty_temp);
		to_str_eqvl = to_str_eqvl_temp / gcd(to_str_eqvl_temp,to_str_eqvl_qty_temp);
		issue_uom_eqvl_qty = issue_uom_eqvl_qty_temp / gcd(issue_uom_eqvl_temp,issue_uom_eqvl_qty_temp);
		issue_uom_eqvl = issue_uom_eqvl_temp / gcd(issue_uom_eqvl_temp,issue_uom_eqvl_qty_temp);
		int common_lcm = (getLcm(getLcm(fm_str_eqvl,to_str_eqvl),issue_uom_eqvl));
		int issue_uom_multiple = (getLcm(getLcm(fm_str_eqvl,to_str_eqvl),issue_uom_eqvl)*issue_uom_eqvl_qty)/issue_uom_eqvl;
		conv_factors.put("FROM_STORE_MULTIPLES",""+(common_lcm*fm_str_eqvl_qty)/fm_str_eqvl);
		conv_factors.put("TO_STORE_MULTIPLES",""+(common_lcm*to_str_eqvl_qty)/to_str_eqvl);
		conv_factors.put("BATCH_QTY_MULTIPLES",""+common_lcm);
		conv_factors.put("ISSUE_UOM_MULTIPLES",""+issue_uom_multiple);
		return conv_factors;
	}
	public void clearConvMap(){
		convFactMap.clear();
		convFactMapDuo.clear();
	}

	public String getNoOfDecimalsCost(){
		String no_of_decimals			  = "0";	
		try{
			no_of_decimals = checkForNull((String)((HashMap)fetchRecord("SELECT NVL(NO_OF_DECIMALS_FOR_COST,0) NO_OF_DECIMALS_FOR_COST FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID = 'ZZ'")).get("NO_OF_DECIMALS_FOR_COST"),"0");
		}catch(Exception e){
			no_of_decimals = "0";
			e.printStackTrace();
		}
		return no_of_decimals;
	}

	public String getUnitCost(String item_code,String store_code){
		ArrayList alParameters = new ArrayList(); 		
		alParameters.add(item_code);
		alParameters.add(store_code);

		String unit_cost  = "0";	
		try{
			unit_cost = checkForNull((String)((HashMap)fetchRecord("SELECT TRIM(ST_DISPLAY_COST_DECIMALS(?,?)) UNIT_COST FROM DUAL",alParameters)).get("UNIT_COST"),"0");
		}catch(Exception e){
			unit_cost = "0";
			e.printStackTrace();
		}
		return unit_cost;
	}
	public String getCustomerID(){

		String customer_id  = "";	
		try{
			customer_id = checkForNull((String)((HashMap)fetchRecord("SELECT CUSTOMER_ID FROM SM_SITE_PARAM")).get("CUSTOMER_ID"),"");
		}catch(Exception e){
			customer_id = "";
			e.printStackTrace();
		}
		return customer_id;
		//return "MC";
	}
	
	//for kit template common 
	public String getUsageType(String kit_code,String item_code){
		ArrayList alParam = new ArrayList(); 		
		alParam.add(kit_code);
		alParam.add(item_code);

		String usage_type  = "";	
		try{
			usage_type = checkForNull((String)((HashMap)fetchRecord("SELECT  USAGE_TYPE  FROM ST_KIT_TEMPLATE_DTL WHERE  kit_template_code =? AND ITEM_CODE = ? ",alParam)).get("USAGE_TYPE"),"");
			System.out.println("usage_type====1200======>" +usage_type);
		}catch(Exception e){
			usage_type = "";
			e.printStackTrace();
		}
		return usage_type;
	}
	
	//Added by Sakti sankar against AAKH-CRF-0022-Inc#38258	
	public HashMap getItemSpecfnRemarks(String item_code,String language_id) throws Exception {
        try{
			String stParameters[]={item_code, language_id};
            HashMap hashmap = fetchRecord("SELECT ITEM_SPECIFICATION, ITEM_REMARKS FROM MM_ITEM_LANG_VW WHERE ITEM_CODE=? AND LANGUAGE_ID=?", stParameters);
            return hashmap;
        }
        catch(Exception exception){
            exception.printStackTrace();
			throw exception;
        }
    }
	//Added ends

	//Added by Sakti against TTM-SCF-0106 to get base uom unit_cost
	public double getBaseUnitCost(String item_code){
		double unit_cost  = 0;	
		try{
			//unit_cost = Double.parseDouble(checkForNull((String)fetchRecord("SELECT TRIM(ST_DISPLAY_UNIT_COST(?)) BASE_UNIT_COST FROM DUAL",item_code).get("BASE_UNIT_COST"),"0"));
			//Modified by suresh.r on 12-11-2014 against Inc 52256
			unit_cost = Double.parseDouble(checkForNull((String)fetchRecord("SELECT TRIM(ST_DISPLAY_UNIT_COST(?,SYSDATE,'CURRENT_STOCK')) BASE_UNIT_COST FROM DUAL",item_code).get("BASE_UNIT_COST"),"0"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return unit_cost;
	}//Added ends
	 public HashMap getBarcodedetails(String barcodeData)throws Exception{//Adding start for MOHE-CRF-0167 and MMS-DM-CRF-0174

				int    index =0;
				String GTIN ="";
				String batchData ="";
				String batch_id ="";
				String exp_date ="";
				String srl_no ="";
				String srlNo="";
				String otherdata ="";
				HashMap batchDetails = new HashMap();
				if(barcodeData.contains("[GS]")){
                     barcodeData =barcodeData.replace("[GS]","_");
				}else if(barcodeData.contains("<GS>")){
					  barcodeData =barcodeData.replace("<GS>","_");
				}
				System.out.println("barcodeData@@ after Replace===: "+barcodeData);
		try{
				if (index + 2 < barcodeData.length() && barcodeData.substring(index, index + 2).equals("01")) {
							 GTIN = barcodeData.substring(index+2,16);
							 otherdata = barcodeData.substring(GTIN.length()+2,barcodeData.length());
							 System.out.println("GTIN@1910==="+GTIN+"other_data=="+otherdata);
				}if(otherdata.length()>0){
					if (index + 2 < otherdata.length() && otherdata.substring(index, index + 2).equals("10")) {
                       if (index + 2 < otherdata.length() && otherdata.substring(index, index + 2).equals("10")) {
								if(otherdata.length()>22)
									 batchData = otherdata.substring(index+2,22);
								else
									 batchData = otherdata.substring(index+2,otherdata.length());
								int gsIndex = batchData.indexOf("_");
								   if(gsIndex == -1){
									  gsIndex = batchData.length();
								     }
							     batch_id = otherdata.substring(index + 2,gsIndex+2);
							     otherdata = otherdata.substring(gsIndex+3,otherdata.length());
							     System.out.println("otherdata1921@@==="+otherdata+"batch_id=="+batch_id+"gsIndex=="+gsIndex);

					  }if (index + 2 < otherdata.length() && otherdata.substring(index, index + 2).equals("17")) {
								  exp_date = otherdata.substring(index+2,8);
								  otherdata = otherdata.substring(exp_date.length()+2,otherdata.length());
								  System.out.println("otherdata1921@@==="+otherdata+"exp_date==="+exp_date);
								  if (index + 2 < otherdata.length() && otherdata.substring(index, index + 2).equals("21")) {
									if(otherdata.length()>22)
										 srl_no = otherdata.substring(index+2,22);
									else
										 srl_no = otherdata.substring(index+2,otherdata.length());
									int gsIndex = srl_no.indexOf("_");
									   if(gsIndex == -1){
										  gsIndex = srl_no.length();
									   }
									 srlNo = otherdata.substring(index + 2,gsIndex+2);
								  }

					       }else if (index + 2 < otherdata.length() && otherdata.substring(index, index + 2).equals("21")) {
									if(otherdata.length()>22)
										 srl_no = otherdata.substring(index+2,22);
									else
										 srl_no = otherdata.substring(index+2,otherdata.length());
									int gsIndex = srl_no.indexOf("_");
									   if(gsIndex == -1){
										  gsIndex = srl_no.length();
									   }
									 srlNo = otherdata.substring(index + 2,gsIndex+2);
									 otherdata = otherdata.substring(gsIndex+3,otherdata.length());
										System.out.println("otherdata1921@@==="+otherdata+"srlNo==="+srlNo);
                              if (index + 2 < otherdata.length() && otherdata.substring(index, index + 2).equals("17")) {
									  exp_date = otherdata.substring(index+2,8);
									 // otherdata = otherdata.substring(exp_date.length()+2,otherdata.length());
									  System.out.println("otherdata1921@@==="+otherdata+"exp_date==="+exp_date);
					    }
					 }
				 }else if(index + 2 < otherdata.length() && otherdata.substring(index, index + 2).equals("17")){
								 exp_date = otherdata.substring(index+2,8);
								 otherdata = otherdata.substring(exp_date.length()+2,otherdata.length());
								 System.out.println("otherdata1946@@==="+otherdata+"exp_date==="+exp_date);
						  if (index + 2 < otherdata.length() && otherdata.substring(index, index + 2).equals("10")) {
									if(otherdata.length()>22)
										    batchData = otherdata.substring(index+2,22);
										else
											batchData = otherdata.substring(index+2,otherdata.length());
									int gsIndex = batchData.indexOf("_");
										   if(gsIndex == -1){
											  gsIndex = batchData.length();
										   }
									 batch_id = otherdata.substring(index + 2,gsIndex+2);
									 otherdata = otherdata.substring(gsIndex+3,otherdata.length());
										   System.out.println("otherdata@@1946==="+otherdata+"batch_id=="+batch_id+"gsIndex=="+gsIndex);
                           if (index + 2 < otherdata.length() && otherdata.substring(index, index + 2).equals("21")) {
								        if(otherdata.length()>22)
										     srl_no = otherdata.substring(index+2,22);
									    else
										     srl_no = otherdata.substring(index+2,otherdata.length());
										int gs_Index = srl_no.indexOf("_");
										   if(gs_Index == -1){
											  gs_Index = srl_no.length();
										   }
										 srlNo = otherdata.substring(index + 2,gs_Index+2);
										 //otherdata = otherdata.substring(gs_Index+3,otherdata.length());
										   System.out.println("otherdata1926@@==="+otherdata+"srlNo=="+srlNo+"gsIndex==="+gs_Index);
								 }
					          }else if (index + 2 < otherdata.length() && otherdata.substring(index, index + 2).equals("21")) {
										if(otherdata.length()>22)
										      srl_no = otherdata.substring(index+2,22);
									    else
										      srl_no = otherdata.substring(index+2,otherdata.length());
										int gsIndex = srl_no.indexOf("_");
										   if(gsIndex == -1){
											  gsIndex = srl_no.length();
										   }
									     srlNo = otherdata.substring(index + 2,gsIndex+2);
								         otherdata = otherdata.substring(gsIndex+3,otherdata.length());
									   System.out.println("otherdata1946@@==="+otherdata+"srlNo=="+srlNo+"gsIndex==="+gsIndex);
								if (index + 2 < otherdata.length() && otherdata.substring(index, index + 2).equals("10")) {
									      if(otherdata.length()>22)
										    batchData = otherdata.substring(index+2,22);
										else
											batchData = otherdata.substring(index+2,otherdata.length());
										   int gs_Index = batchData.indexOf("_");
											   if(gs_Index == -1){
												  gs_Index = batchData.length();
											   }
										   batch_id = otherdata.substring(index + 2,gs_Index+2);
 										   //otherdata = otherdata.substring(gs_Index+3,otherdata.length());
										   System.out.println("otherdata@@1950==="+otherdata+"batch_id=="+batch_id+"gsIndex=="+gs_Index);
									  }
					           }

				 }else if(index + 2 < otherdata.length() && otherdata.substring(index, index + 2).equals("21")){
					                 if(otherdata.length()>22)
										    srl_no = otherdata.substring(index+2,22);
									 else
										    srl_no = otherdata.substring(index+2,otherdata.length());
										int gsIndex = srl_no.indexOf("_");
										   if(gsIndex == -1){
											  gsIndex = srl_no.length();
										   }
									 srlNo = otherdata.substring(index + 2,gsIndex+2);
								     otherdata = otherdata.substring(gsIndex+3,otherdata.length());
							System.out.println("1950@@srlNo==="+srlNo);
                          if (index + 2 < otherdata.length() && otherdata.substring(index, index + 2).equals("10")) {
									   if(otherdata.length()>22)
										    batchData = otherdata.substring(index+2,22);
										else
											batchData = otherdata.substring(index+2,otherdata.length());
								       int gs_Index = batchData.indexOf("_");
									      if(gs_Index == -1){
										    gs_Index = batchData.length();
									       }
									    batch_id = otherdata.substring(index + 2,gs_Index+2);
								        otherdata = otherdata.substring(gs_Index+3,otherdata.length());
									   System.out.println("1996otherdata@@==="+otherdata+"batch_id=="+batch_id);
						             if (index + 2 < otherdata.length() && otherdata.substring(index, index + 2).equals("17")) {
										   exp_date = otherdata.substring(index+2,8);
										   //otherdata = otherdata.substring(exp_date.length()+2,otherdata.length());
										   System.out.println("@@@1966exp_date==="+exp_date);
									   }

					      }else if (index + 2 < otherdata.length() && otherdata.substring(index, index + 2).equals("17")) {
									   exp_date = otherdata.substring(index+2,8);
									   otherdata = otherdata.substring(exp_date.length()+2,otherdata.length());
									   System.out.println("otherdata1996@@==="+otherdata+"exp_date==="+exp_date);
								   if (index + 2 < otherdata.length() && otherdata.substring(index, index + 2).equals("10")) {
									    if(otherdata.length()>22)
										    batchData = otherdata.substring(index+2,22);
										else
											batchData = otherdata.substring(index+2,otherdata.length());
										int gs_Index = batchData.indexOf("_");
										   if(gs_Index == -1){
											  gs_Index = batchData.length();
										   }
										   System.err.println("otherdata@@==="+otherdata+"index=="+index+"gs_Index=="+gs_Index+"otherdata.length()=="+otherdata.length());
										 batch_id = otherdata.substring(index + 2,gs_Index+2);
										 //otherdata = otherdata.substring(gs_Index+3,otherdata.length());
										   System.out.println("1996@@batch_id=="+batch_id);
								   }

					      }
				    }
				
               }
			   System.out.println("GTIN   :  "+GTIN);
			   System.out.println("BATCH  :  "+batch_id);
			   System.out.println("EXPIRY :  "+exp_date);
			   System.out.println("SRLNO  :  "+srlNo);

			   batchDetails.put("GTIN",GTIN);
			   batchDetails.put("BATCH_ID",batch_id);
			   batchDetails.put("EXPIRY_DATE",exp_date);
			   batchDetails.put("SRLNO",srlNo);
     }
		catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		 }

		 return batchDetails;
   }
	

/**/
protected final int FUNCTION_DELETE =	0;	
	protected final int FUNCTION_INSERT	=	1;	
	protected final int FUNCTION_UPDATE	 =	2;
	protected final int FUNCTION_INSERT_BATCH	=	3;
	protected final Boolean TRUE =	new Boolean(true);
	protected final Boolean FALSE = new Boolean(false);
	protected final String RESULT = "result";
	protected final String MESSAGE = "message";
	protected final String MSGID = "msgid"; 
}
