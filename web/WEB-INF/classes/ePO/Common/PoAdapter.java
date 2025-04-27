/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePO.Common;

import eCommon.Common.CommonRepository;
import eCommon.Common.CommonAdapter;
import eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;
import java.io.Serializable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.InitialContext;
import java.util.HashMap;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.StringTokenizer;
import eCommon.Common.OptionValues;


public abstract class PoAdapter extends CommonAdapter implements Serializable 
{

	boolean localEJB = true;
	public HashMap				map					=	null;
	public HashMap				sqlMap				=	null;
	public String				    SQL_PO_CODE_EXISTS	=	"";
	public int					        PO_FUNCTION_ID		=	0;
	public PoAdapter() 
	{
		super( CommonRepository.getCommonKeyValue( "ID_PO" )  ) ;

		map				=	new HashMap();
		sqlMap			=	new HashMap();
	}

	public void setLocalEJB(boolean localEJB){
		this.localEJB = localEJB;
	}

	public boolean getLocalEJB(){
		return localEJB;
	}
	

	
/*	public String getListOptionTag(ArrayList arrayListValue ) {
		if (arrayListValue == null) {
			return null;
		}
		StringBuffer tagValue = new StringBuffer();
		for (int count=0;count<arrayListValue.size();count++ ) {
			tagValue.append(arrayListValue.get(count).toString());
			tagValue.append('\n');
		}
		System.out.println("tagValue.toString() in po adapter = "+tagValue.toString());
		return tagValue.toString();
	}
*/

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

	public HashMap getMessageHashMap(boolean bFlag){
		HashMap hmReturn	=	new HashMap();
		hmReturn.put(RESULT,bFlag?TRUE:FALSE);
		hmReturn.put(MESSAGE,"[Method body under development]Dummy Message for result: "+bFlag);
		return hmReturn;
	}
	/*  This method is used to convert an array list 
	  *  contents into a string with a default value selected in the List Box 
	  */
	/*public String getListOptionTag(ArrayList arrayListValue,String defaultValue) {
	//System.out.println("getListOptionTag in Po Adapter");
	//System.out.println("arrayListValue in Po Adapter = "+arrayListValue);
	//System.out.println("defaultValue in Po Adapter = "+defaultValue);
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
		//System.out.println("tagValue in PO Adaptor = "+tagValue.toString());
		return tagValue.toString();
	}
	
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

	
	public ArrayList getListOptionArrayList(String sql,String []stParameters,boolean isSelectRequired) {
		ArrayList alParameter=new ArrayList (stParameters.length);
		for (int i=0; i<stParameters.length; i++ )
			alParameter.add(stParameters[i]);

		return getListOptionArrayList(sql, alParameter,isSelectRequired);
	}

	public ArrayList getListOptionArrayList(String sql,ArrayList alParameters, boolean isSelectRequired) {
			Connection connection				= null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet					=	null;

			ArrayList alOptionValues = new ArrayList();
			String locale_lang=(String)alParameters.get(alParameters.size()-1);
			String select_option=getPOMessage(locale_lang,"SELECT_OPTION","PO") ;
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

	public ArrayList getListOptionArrayList(String sql,String parameter) {
		ArrayList alParameter=new ArrayList (1);
		alParameter.add(parameter);
		return getListOptionArrayList(sql, alParameter);
	}
	
	
	/*	public ArrayList getListOptionArrayList(String sql,ArrayList alParameters) {
			Connection connection				= null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet					=	null;
			String select_option= "";
			ArrayList alOptionValues = new ArrayList();
			if(getLanguageId()==null){
			System.out.println("getLanguageId - if ");
				String locale_lang=(String)alParameters.get(alParameters.size()-1);
				select_option=getPOMessage(locale_lang,"SELECT_OPTION","PO") ;
			}else{
			System.out.println("getLanguageId - else ");
				select_option=getPOMessage(getLanguageId(),"SELECT_OPTION","PO") ;
				}
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
			
			System.out.println("alOptionValues in po adapter= "+alOptionValues);
			return alOptionValues;
	}
*/

public ArrayList getListOptionArrayList(String sql,ArrayList alParameters) {
//System.out.println("sql in poadapter = "+sql);
//System.out.println("alParameters in poadapter = "+alParameters);
			Connection connection				= null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet					=	null;
				String select_option= "";
			ArrayList alOptionValues = new ArrayList();
			if(getLanguageId()==null){
	//		System.out.println("getLanguageId - if ");
				String locale_lang=(String)alParameters.get(alParameters.size()-1);
				select_option=getPOMessage(locale_lang,"SELECT_OPTION","PO") ;
			}else{
	//		System.out.println("getLanguageId - else ");
				select_option=getPOMessage(getLanguageId(),"SELECT_OPTION","PO") ;
				}
			//String locale_lang=(String)alParameters.get(alParameters.size()-1);
			//System.err.println("locale_lang--------------in stada->"+locale_lang);
			//String select_option=getPOMessage(locale_lang,"SELECT_OPTION","PO") ;
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
	

	public void setPoFunctionId(int PO_FUNCTION_ID)
	{
		this.PO_FUNCTION_ID		=	PO_FUNCTION_ID;
	}

	public int getPoFunctionId()
	{
		return this.PO_FUNCTION_ID;
	}

	public void setSqlPoCodeExists(String SQL_PO_CODE_EXISTS)
	{
		this.SQL_PO_CODE_EXISTS	=	SQL_PO_CODE_EXISTS;
	}

	/*public String getSqlPoCodeExists(int PO_FUNCTION_ID)
	{
		switch(PO_FUNCTION_ID)
		{
			case  PoInterface.PO_MATERIAL_GROUP :
					setSqlPoCodeExists(	PoInterface.SQL_PO_MTRL_GRP_CODE_EXISTS );
					break;
			case  PoInterface.PO_ITEM_CLASS :
					setSqlPoCodeExists(	PoInterface.SQL_PO_ITEM_CLASS_CODE_EXISTS );
					break;
			case  PoInterface.PO_ITEM_ANALYSIS :
					setSqlPoCodeExists(	PoInterface.SQL_PO_ITEM_ANAL_CODE_EXISTS );
					break;
			case  PoInterface.PO_ITEM_MASTER :
					setSqlPoCodeExists(	PoInterface.SQL_PO_ITEMMASTER_EXISTS );
					break;
			case  PoInterface.PO_MANUFACTURER :
					setSqlPoCodeExists(	PoInterface.SQL_PO_MANUFACTURER_CODE_EXISTS );
					break;
			case  PoInterface.PO_STORE :
					setSqlPoCodeExists(	PoInterface.SQL_PO_STORE_CODE_EXISTS );
					break;
			case  PoInterface.PO_BRAND_NAME :
					setSqlPoCodeExists(	PoInterface.SQL_PO_BRANDNAME_EXISTS );
					break;
			case  PoInterface.PO_BIN_LOCATION :
					setSqlPoCodeExists(	PoInterface.SQL_PO_BINLOCATION_EXISTS );
					break;
		}
		return SQL_PO_CODE_EXISTS;
	}
*/
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
	//System.out.println("sql = "+sql);
	//System.out.println("alParameters = "+alParameters);
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
		//	System.out.println("resultSet = "+resultSet);
			resultSetMetaData	=	resultSet.getMetaData();

			//resultSet.next();
			
			while(resultSet.next())
			{
			for (int i=1; i<=resultSetMetaData.getColumnCount(); i++ )
				hmRecord.put(resultSetMetaData.getColumnName(i),resultSet.getString(resultSetMetaData.getColumnName(i)));
				
			}
			
			
			
			
			
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
				for (int index=0; index<alParameters.size();index++ ) 
					preparedStatement.setString( index+1, alParameters.get(index).toString());

			resultSet = preparedStatement.executeQuery();
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

	public String getPoRepositoryValue(String key){
		return ePO.Common.PoRepository.getPoKeyValue(key);
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
			return PoRepository.getPoKeyValue("MANDATORY_IMAGE");
		else if (checkedType.equalsIgnoreCase("Y") || checkedType.equalsIgnoreCase("E") ) 
			return PoRepository.getPoKeyValue("YES_IMAGE");
		else if (checkedType.equalsIgnoreCase("N") || checkedType.equalsIgnoreCase("D") ) 
			return PoRepository.getPoKeyValue("NO_IMAGE");
		else 
			return "";
	}


	public HashMap callSingleTableHandler( HashMap hmTabData, HashMap hmSQLMap, int handlerMode )
	{
		
		HashMap						hmResult					=	new HashMap();
	//	SingleTableHandlerRemote	singleTableHandlerRemote	=	null;
		ArrayList languageData		=	(ArrayList)hmTabData.get("LanguageData");
		hmResult.put("result", new Boolean( false ) );
		hmResult.put("message", "Initial Message" );

		try 
		{
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
				case PoRepository.SINGLE_INSERT:
					hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					break;
				
				case PoRepository.SINGLE_UPDATE:
					
					hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
					break;
				
				case PoRepository.MULTIPLE_INSERT:
					
					hmResult = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
					break;
				
				default:
					hmResult.put( "message", "Invalid handlerMode passed to callSingleTableHandler()");
			}
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if( ((Boolean) hmResult.get("result")).booleanValue() )	
				hmResult.put( "message", getPOMessage((String)languageData.get(0),(String) hmResult.get( "msgid" ),"PO") ) ;
			else
				hmResult.put( "message", getPOMessage((String)languageData.get(0),(String) hmResult.get( "msgid" ),"PO") ) ;
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
				//if( singleTableHandlerRemote != null )
				//	singleTableHandlerRemote.remove();
			}
			catch( Exception exception) 
			{
				System.err.println( exception.toString() );
				hmResult.put( "message", "Exception@02-callSingleTableHandler : "+exception.toString());
			}
		}
		return hmResult;
	}

	public  String getPOMessage(String locale, String messageId, String moduleId)
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
		}
		return returnNumber;
	}
	
	public String getChecked(String string){
		return (string.equalsIgnoreCase("E")||string.equalsIgnoreCase("Y"))? "checked" : "";
	}
	
	
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

	public HashMap getStParameter() throws Exception{
		String  []stParameter={getLoginFacilityId(),"ALL"};
		return fetchRecord(getPoRepositoryValue("SQL_ST_FACILITY_PARAM_SELECT_SINGLE"),stParameter);
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
			alOptionValues.add(PoRepository.getPoKeyValue("DEFAULT_LIST_OPTION"));
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

	protected final Boolean TRUE =	new Boolean(true);
	protected final Boolean FALSE = new Boolean(false);
	protected final String RESULT = "result";
	protected final String MESSAGE = "message";
}
