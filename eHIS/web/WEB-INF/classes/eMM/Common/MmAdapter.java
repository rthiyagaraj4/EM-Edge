/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMM.Common;

import eCommon.Common.CommonRepository;
import eCommon.Common.CommonAdapter;
import eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;
import java.io.Serializable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.InitialContext;
//import javax.rmi.PortableRemoteObject;
import java.util.HashMap;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.StringTokenizer;
import eCommon.Common.OptionValues;
public abstract class MmAdapter extends CommonAdapter implements Serializable 
{

	boolean localEJB = true;
//	public Connection			connection			=	null;
//	public PreparedStatement	pstmt				=	null;
//	public ResultSet			    resultSet			=	null;
	public HashMap				map					=	null;
//	public HashMap				tabData			=	null;
	public HashMap				sqlMap				=	null;
//	public InitialContext	context				=	null;
//	public Object			  	    object				=	null;
	public String				    SQL_MM_CODE_EXISTS	=	"";
	public int					        MM_FUNCTION_ID		=	0;
	public MmAdapter() 
	{
		super( CommonRepository.getCommonKeyValue( "ID_MM" )  ) ;

		map				=	new HashMap();
	//	tabData			=	new HashMap();
		sqlMap			=	new HashMap();
	}

	public void setLocalEJB(boolean localEJB){
		this.localEJB = localEJB;
	}

	public boolean getLocalEJB(){
		return localEJB;
	}
				
	public String getListOptionTag(ArrayList arrayListValue ) {
		if (arrayListValue == null) {
			return null;
		}
		StringBuffer tagValue = new StringBuffer();
		for (int count=0;count<arrayListValue.size();count++ ) {
			tagValue.append(arrayListValue.get(count).toString());
			tagValue.append('\n');
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
			tagValue.append('\n');
			tempObject = arrayListValue.get(count);
			if ((!foundDefault) && (tempObject instanceof OptionValues)) {
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
		}
		tagValue.append('\n');
		tempObject = null;
		tempOptionValues = null;
		return tagValue.toString();
	}

	public ArrayList getListOptionArrayList(String sql,ArrayList alParameters, boolean isSelectRequired) {
			Connection connection				= null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet					=	null;

			ArrayList alOptionValues = new ArrayList();
			String locale_lang=(String)alParameters.get(alParameters.size()-1);
		//	System.err.println("locale_lang--------------in stada->"+locale_lang);
			String select_option=getMMMessage(locale_lang,"SELECT_OPTION","ST") ;
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
					alOptionValues.add(new OptionValues(resultSet.getString(1),resultSet.getString(2)));
				} 
			}
			catch (java.sql.SQLException exception) {
				alOptionValues.add(new OptionValues(sql+alParameters+"","SQL Exception :"+exception.getErrorCode()+" : "+ exception.getMessage()));
			}
			catch (Exception exception) {
				alOptionValues.add(new OptionValues("","Exception : "+exception.getMessage()));
			}
			finally{
				try { 
					closeResultSet(resultSet);
					closeStatement(preparedStatement);
					closeConnection(connection);
				}
				catch (Exception exception) {
					alOptionValues.add(new OptionValues("Error : "+exception.getMessage(),""));
				}
			}
			return alOptionValues;
	}
		public ArrayList getListOptionArrayList(String sql) {
		return getListOptionArrayList(sql,new ArrayList(0));
	}

	public ArrayList getListOptionArrayList(String sql,ArrayList alParameters) {
			Connection connection				= null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet					=	null;

			ArrayList alOptionValues = new ArrayList();
			String locale_lang=(String)alParameters.get(alParameters.size()-1);
			//System.err.println("locale_lang--------------in stada->"+locale_lang);
			String select_option=getMMMessage(locale_lang,"SELECT_OPTION","ST") ;
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
					alOptionValues.add(new OptionValues(resultSet.getString(1),resultSet.getString(2)));
				}
			}
			catch (java.sql.SQLException exception) {
				alOptionValues.add(new OptionValues(sql+alParameters+"","SQL Exception :"+exception.getErrorCode()+" : "+ exception.getMessage()));
			}
			catch (Exception exception) {
				alOptionValues.add(new OptionValues("","Exception : "+exception.getMessage()));
			}
			finally{
				try { 
					closeResultSet(resultSet);
					closeStatement(preparedStatement);
					closeConnection(connection);
				}
				catch (Exception exception) {
					alOptionValues.add(new OptionValues("Error : "+exception.getMessage(),""));
				}
			}
			return alOptionValues;
	}


	public void setMmFunctionId(int MM_FUNCTION_ID)
	{
		this.MM_FUNCTION_ID		=	MM_FUNCTION_ID;
	}

	public int getMmFunctionId()
	{
		return this.MM_FUNCTION_ID;
	}

	public void setSqlMmCodeExists(String SQL_MM_CODE_EXISTS)
	{
		this.SQL_MM_CODE_EXISTS	=	SQL_MM_CODE_EXISTS;
	}

	public String getSqlMmCodeExists(int MM_FUNCTION_ID)
	{
		switch(MM_FUNCTION_ID)
		{
			case  MmInterface.MM_MATERIAL_GROUP :
					setSqlMmCodeExists(	MmInterface.SQL_MM_MTRL_GRP_CODE_EXISTS );
					break;
			case  MmInterface.MM_ITEM_CLASS :
					setSqlMmCodeExists(	MmInterface.SQL_MM_ITEM_CLASS_CODE_EXISTS );
					break;
			case  MmInterface.MM_ITEM_ANALYSIS :
					setSqlMmCodeExists(	MmInterface.SQL_MM_ITEM_ANAL_CODE_EXISTS );
					break;
			case  MmInterface.MM_ITEM_MASTER :
					setSqlMmCodeExists(	MmInterface.SQL_MM_ITEMMASTER_EXISTS );
					break;
			case  MmInterface.MM_MANUFACTURER :
					setSqlMmCodeExists(	MmInterface.SQL_MM_MANUFACTURER_CODE_EXISTS );
					break;
			case  MmInterface.MM_STORE :
					setSqlMmCodeExists(	MmInterface.SQL_MM_STORE_CODE_EXISTS );
					break;
			case  MmInterface.MM_BRAND_NAME :
					setSqlMmCodeExists(	MmInterface.SQL_MM_BRANDNAME_EXISTS );
					break;
			case  MmInterface.MM_BIN_LOCATION :
					setSqlMmCodeExists(	MmInterface.SQL_MM_BINLOCATION_EXISTS );
					break;
		}
		return SQL_MM_CODE_EXISTS;
	}

	public void intializeSQLPStatement ( String SQL_QUERY ) throws java.sql.SQLException, Exception
	{
		
		 PreparedStatement	pstmt				=	null;
		  Connection			connection			=	null;
		try{
			if(connection==null || connection.isClosed() )	
				connection	=	getConnection();
			pstmt		=	connection.prepareStatement( SQL_QUERY );
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				closeConnection(connection);
				closeStatement(pstmt);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public void intializeSQLPStatement ( String SQL_QUERY, boolean SCROLL_INSENSITIVE ) throws java.sql.SQLException, Exception
	{

			 PreparedStatement	pstmt				=	null;
			Connection			connection			=	null;
		try{
			if(connection==null || connection.isClosed() )	
				connection		=	getConnection();

			if(SCROLL_INSENSITIVE)
			{
				pstmt	=	connection.prepareStatement( SQL_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY  );
			}
			else
			{
				pstmt	=	connection.prepareStatement( SQL_QUERY, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY  );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				closeConnection(connection);
				closeStatement(pstmt);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

/*	public void returnJDBCResources() 
	{
		try
		{
			closeResultSet( resultSet );
			closeStatement( pstmt );
			closeConnection( connection );
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}*/
	
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

			resultSet.next();
			for (int i=1; i<=resultSetMetaData.getColumnCount(); i++ )
				hmRecord.put(resultSetMetaData.getColumnName(i),resultSet.getString(resultSetMetaData.getColumnName(i)));
		} 
		catch (Exception exception )	{
			System.err.println("Error @ fetch Record..");
			System.err.println("Parameter rcd: SQL:"+sql);
			System.err.println("Values rcd:        "+alParameters);
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
				for (int index=0; index<alParameters.size();index++ ) 
					preparedStatement.setString( index+1, alParameters.get(index).toString());

			resultSet = preparedStatement.executeQuery();
//			System.err.println("executed..");
			resultSetMetaData	=	resultSet.getMetaData();

			while(resultSet.next())
			{
				hmRecord=new HashMap();
				for (int i=1; i<=resultSetMetaData.getColumnCount(); i++ )
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

	public String getMmRepositoryValue(String key){
		return eMM.Common.MmRepository.getMmKeyValue(key);
	}
	public void logErrorMessage(Exception e)
	{
		e.printStackTrace();
		map.put( "result", new Boolean( false ) );
		map.put( "message", e.toString() );
	}

	public void logErrorMessage(Exception e, String error_msg)
	{
		e.printStackTrace();
		map.put( "result", new Boolean( false ) );
		map.put( "message", (error_msg+e.toString()) );
	}

	public void setSQLOperation(String operation_mode, String SQL_STMT)
	{
		if(operation_mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))
			sqlMap.put( "SQL_INSERT", SQL_STMT );
		else if(operation_mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))
			sqlMap.put( "SQL_UPDATE", SQL_STMT );
		else if(operation_mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE")))
			sqlMap.put( "SQL_DELETE", SQL_STMT );
	}

	public String getImage(String checkedType) {
		if (checkedType == null) 
			return "";
		else if (checkedType.equalsIgnoreCase("M")) 
			return MmRepository.getMmKeyValue("MANDATORY_IMAGE");
		else if (checkedType.equalsIgnoreCase("Y") || checkedType.equalsIgnoreCase("E") ) 
			return MmRepository.getMmKeyValue("YES_IMAGE");
		else if (checkedType.equalsIgnoreCase("N") || checkedType.equalsIgnoreCase("D") ) 
			return MmRepository.getMmKeyValue("NO_IMAGE");
		else 
			return "";
	}


	public HashMap callSingleTableHandler( HashMap hmTabData, HashMap hmSQLMap, int handlerMode )
	{
		
		HashMap						hmResult					=	new HashMap();
		//SingleTableHandlerHome		singleTableHandlerHome		=	null;
		SingleTableHandlerRemote	singleTableHandlerRemote	=	null;
		ArrayList languageData		=	(ArrayList)hmTabData.get("LanguageData");
		//System.err.println("languageData in mmAdapter----------->"+languageData);

		hmResult.put("result", new Boolean( false ) );
		hmResult.put("message", "Initial Message" );

		try 
		{
			/*context =	new InitialContext();

			object	=	context.lookup( eCommon.Common.CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"));

			singleTableHandlerHome		=	(SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class );
			singleTableHandlerRemote	=	singleTableHandlerHome.create();*/
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome( eCommon.Common.CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class ,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTabData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTabData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();

			
			switch (handlerMode)
			{
				case MmRepository.SINGLE_INSERT:
					hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				//	hmResult = singleTableHandlerRemote.insert( hmTabData, hmSQLMap );
					break;
				
				case MmRepository.SINGLE_UPDATE:
					
					hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
					//hmResult = singleTableHandlerRemote.modify( hmTabData, hmSQLMap );
					break;
				
				case MmRepository.MULTIPLE_INSERT:
					
					hmResult = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
					//System.err.println("hmResult--------"+hmResult);
					//hmResult = singleTableHandlerRemote.singleBatchHandler( hmTabData, hmSQLMap );
					break;
				
				default:
					hmResult.put( "message", "Invalid handlerMode passed to callSingleTableHandler()");
			}
//System.err.println("mm-Message in adapter--->"+getMMMessage((String)languageData.get(0),(String) hmResult.get( "msgid" ),"ST") );
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if( ((Boolean) hmResult.get("result")).booleanValue() )	
				hmResult.put( "message", getMMMessage((String)languageData.get(0),(String) hmResult.get( "msgid" ),"ST") ) ;
			else
				hmResult.put( "message", getMMMessage((String)languageData.get(0),(String) hmResult.get( "msgid" ),"ST") ) ;
		} 
		catch(Exception exception) 
		{
			System.err.println( "Error Calling SingleTableHandler EJB : "+exception);
			hmResult.put( "message", "Exception@01-callSingleTableHandler : "+exception.toString());
			exception.printStackTrace();
		} 
		finally 
		{
			try 
			{
				if( singleTableHandlerRemote != null )
					singleTableHandlerRemote.remove();
			}
			catch( Exception exception) 
			{
				System.err.println( exception.toString() );
				hmResult.put( "message", "Exception@02-callSingleTableHandler : "+exception.toString());
			}
		}
		return hmResult;
	}

	public  String getMMMessage(String locale, String messageId, String moduleId)
	{
	
        java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
        return(mesg) ;
    }


	public String setNumber(String stNumber, int decimalPlaces){
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
	}
}
