/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS.Common ;

import webbeans.eCommon.*;
import eCommon.Common.CommonAdapter;
import eCommon.Common.CommonRepository;
import eCommon.SingleTableHandler.SingleTableHandlerHome;
import eCommon.SingleTableHandler.SingleTableHandlerRemote;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.Types;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.naming.InitialContext ;
import javax.rmi.PortableRemoteObject;
import javax.servlet.http.HttpServletRequest;
import eSS.OptionValues;


public abstract class SsAdapter extends CommonAdapter implements Serializable {
	boolean localEJB = true;
	public SsAdapter() {
		super(CommonRepository.getCommonKeyValue("ID_SS"));
	}

	public void setLocalEJB(boolean localEJB){
		this.localEJB = localEJB;
	}

	public boolean getLocalEJB(){
		return localEJB;
	}

	 //Added by Martin
	 /* 
		 This method returns an ArrayList consisting of values (<option values="abc">ABC</option>)
		 for a List based on the query provided by the	user.
		 Parameter :
			String sql - Query (select code,name from ss_table where eff_status = ?)
			String value - Query Criteria Value (E)
	 */
    public String getMessage( String msgId ) {
        Connection connection = null ;
        PreparedStatement pstmt_msg = null ;
        ResultSet rs_msg = null ;
        String msgtext = "" ;

        try {
            connection = getConnection() ;
            pstmt_msg = connection.prepareStatement( (String) CommonRepository.getCommonKeyValue("SQL_GET_MESSAGE") ) ;
            pstmt_msg.setString(1, msgId) ;
            rs_msg = pstmt_msg.executeQuery() ;
            if(rs_msg != null && rs_msg.next()) {
               msgtext = "APP-" + rs_msg.getString( "MESSAGE_ID" ) + " " + rs_msg.getString("MESSAGE_TEXT_SYSDEF") + "<br>" ;
            } else
               msgtext = "Message Not Avaliable in SM_MESSAGE <br> ID:"+ msgId  ;
        } catch( Exception e) {
                msgtext = "Error in Message: "+e ;
        } finally {
            try{
                closeResultSet( rs_msg ) ;
                closeStatement( pstmt_msg ) ;
                closeConnection( connection ) ;
            } catch(Exception es) {}
        }
        return msgtext ;
    }

    public String getFromToValidateMessage( String stLegend) {
        StringBuffer sbMessage = new StringBuffer() ;
        HashMap hmRecord	=	null;

		try {
			hmRecord	=	fetchRecord(CommonRepository.getCommonKeyValue("SQL_GET_MESSAGE"),"GR_OR_EQ");
            sbMessage.append("APP-");
            sbMessage.append((String)hmRecord.get("MESSAGE_ID"));
            sbMessage.append(" To ");
            sbMessage.append(stLegend);
            sbMessage.append(" ");
            sbMessage.append((String)hmRecord.get("MESSAGE_TEXT_SYSDEF"));
            sbMessage.append(" From ");
            sbMessage.append(stLegend);
            sbMessage.append("<br>");
        } 
		catch( Exception exception) {
            sbMessage.append(exception.toString());
            sbMessage.append("<br>");
        }
        return sbMessage.toString();
    }

	public ArrayList getListOptionArrayList(String sql) {
		return getListOptionArrayList(sql,new ArrayList(0));
	}

	public ArrayList getListOptionArrayList(String sql,String parameter) {
		ArrayList alParameter=new ArrayList (1);
		alParameter.add(parameter);
		return getListOptionArrayList(sql, alParameter);
	}

/*1/16/2009 Added by mahesh to restrict select when passing string array*/
	public ArrayList getListOptionArrayList(String sql,String []stParameters,boolean isSelectRequired) {
		ArrayList alParameter=new ArrayList (stParameters.length);
		for (int i=0; i<stParameters.length; i++ )
			alParameter.add(stParameters[i]);

		return getListOptionArrayList(sql, alParameter,isSelectRequired);
	}
/*Code added By Mahesh Ends 1/16/2009*/
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

			ArrayList alOptionValues = new ArrayList();
			if(isSelectRequired)
				alOptionValues.add(eSS.Common.SsRepository.getSsKeyValue("DEFAULT_LIST_OPTION").toString());
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
					alOptionValues.add(new eSS.OptionValues(resultSet.getString(1),resultSet.getString(2)));
				}
			}
			catch (java.sql.SQLException exception) {
				alOptionValues.add(new eSS.OptionValues(sql+alParameters+"","SQL Exception :"+exception.getErrorCode()+" : "+ exception.getMessage()));
			}
			catch (Exception exception) {
				alOptionValues.add(new eSS.OptionValues("","Exception : "+exception.getMessage()));
			}
			finally{
				try { 
					closeResultSet(resultSet);
					closeStatement(preparedStatement);
					closeConnection(connection);
				}
				catch (Exception exception) {
					alOptionValues.add(new eSS.OptionValues("Error : "+exception.getMessage(),""));
				}
			}
			return alOptionValues;
	}
	public ArrayList getListOptionArrayList(String sql,ArrayList alParameters) {
			Connection connection				= null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet					=	null;

			ArrayList alOptionValues = new ArrayList();
			alOptionValues.add(eSS.Common.SsRepository.getSsKeyValue("DEFAULT_LIST_OPTION").toString());
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
					alOptionValues.add(new eSS.OptionValues(resultSet.getString(1),resultSet.getString(2)));
				}
			}
			catch (java.sql.SQLException exception) {
				alOptionValues.add(new eSS.OptionValues(sql+alParameters+"","SQL Exception :"+exception.getErrorCode()+" : "+ exception.getMessage()));
			}
			catch (Exception exception) {
				alOptionValues.add(new eSS.OptionValues("","Exception : "+exception.getMessage()));
			}
			finally{
				try { 
					closeResultSet(resultSet);
					closeStatement(preparedStatement);
					closeConnection(connection);
				}
				catch (Exception exception) {
					alOptionValues.add(new eSS.OptionValues("Error : "+exception.getMessage(),""));
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



	/**
	* To call the method of SingleTableHandler EJB
	* functionID to be passed as parameter to call the function
	**/
	public HashMap singleTableHandlerMethodCall(HashMap hmTableData, HashMap hmSQLMap, int functionID ){

		HashMap		hmResult	=	new HashMap()	;
		//ArrayList languageData		=	(ArrayList)hmTableData.get("LanguageData");
//		SingleTableHandlerHome	singleTableHandlerHome		= null ;
//		SingleTableHandlerRemote	singleTableHandlerRemote		= null ;
		hmResult.put(RESULT, new Boolean( false ) ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {
/*			InitialContext context = new InitialContext() ;

			Object object = context.lookup( eCommon.Common.CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

			singleTableHandlerHome  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
			singleTableHandlerRemote = singleTableHandlerHome.create() ;
*/
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(eCommon.Common.CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0]  = hmTableData.getClass(); ;
			paramArray[1]  = hmSQLMap.getClass();
			
			
			switch (functionID)
			{
				case FUNCTION_INSERT:

					hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					break;
				
				case FUNCTION_UPDATE:
					hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
					break;
				
				case FUNCTION_INSERT_BATCH:
					hmResult = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
					break;
				
				default:
					hmResult.put( MESSAGE, "Invalid Function ID passed to singleTableHandlerMethodCall()") ;
			}

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			if( ((Boolean) hmResult.get(RESULT)).booleanValue() ){	
				//hmResult.put( MESSAGE, replaceNewLineChar(getMessage((String) hmResult.get( MSGID )) )) ;
				hmResult.put( MESSAGE, getMessage(getLanguageId(),(String) hmResult.get( MSGID ),"SS") ) ;
				hmResult.remove(MSGID);
			}
			else if( hmResult.get(MSGID).toString().equals("") )
				hmResult.put( MESSAGE, "No record processed.") ;
			else if( hmResult.get(MSGID)!=null  )
				//hmResult.put( MESSAGE, replaceNewLineChar(getMessage((String) hmResult.get( MSGID )) )) ;
			    hmResult.put( MESSAGE, getMessage(getLanguageId(),(String) hmResult.get( MSGID ),"Common") ) ;
			else
				//hmResult.put( MESSAGE, replaceNewLineChar((String)hmResult.get(MESSAGE)) ) ;
			   hmResult.put( MESSAGE, getMessage(getLanguageId(),(String) hmResult.get( MSGID ),"SS") ) ;
		} 
		catch(Exception exception) {
			System.err.println( "Error Calling SingleTableHandler EJB : "+exception) ;
			hmResult.put( MESSAGE, "Bean 169: "+exception.getMessage()) ;
			exception.printStackTrace() ;
		} 
		return hmResult;
	}

	/**
	* To get the record on the basis of primary key.
	* 
	**/
/*
	public  String getSSMessage(String locale, String messageId, String moduleId)
	{
	//System.err.println("moduleId------>"+moduleId);
        java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
        return(mesg) ;
    }
*/

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
			
				while(resultSet.next())
				{
					
				for (int i=1; i<=resultSetMetaData.getColumnCount(); i++ ){
				
					hmRecord.put(resultSetMetaData.getColumnName(i),resultSet.getString(resultSetMetaData.getColumnName(i)));
				}
			} 
		}
		catch (Exception exception )	{
//			System.err.println("Error @ fetch Record..");
//			System.err.println("Parameter rcd: SQL:"+sql);
//			System.err.println("Values rcd:        "+alParameters);
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
//			System.err.println("Error @ fetchRecords");
//			System.err.println("Parameter rcd: SQL:"+sql);
//			System.err.println("Bind Values rcd:   "+alParameters);
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

	public String getMandatoryImageTag(){
		return eSS.Common.SsRepository.getSsKeyValue("MANDATORY_IMAGE").toString();
	}

	public String getChecked(String string){
		return (string.equalsIgnoreCase("E")||string.equalsIgnoreCase("Y"))? "checked" : "";
	}

	//Frequently used transaction functions
	public String getSystemDate() throws Exception {
		HashMap hmResult =	fetchRecord(eCommon.Common.CommonRepository.getCommonKeyValue("SQL_SYS_DATE_TIME"));
		return (String)hmResult.get("SYS_DATE");
	}

	public int getCurrencySize(){
		return Integer.parseInt(getSsRepositoryValue("DECIMAL_PRECISION"))+Integer.parseInt(getSsRepositoryValue("INTEGER_PRECISION"))+1;
	}

	public String getCurrencyFormat(){
		return getSsRepositoryValue("INTEGER_PRECISION")+","+getSsRepositoryValue("DECIMAL_PRECISION");
	}


	public String getSsRepositoryValue(String key){
		return eSS.Common.SsRepository.getSsKeyValue(key);
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

	public HashMap getSSParameter() throws Exception {
		return fetchRecord(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_PARAMETER_SELECT"),getLoginFacilityId());
	}

	public HashMap getSsAccEntityParam(String acc_entity_id) throws Exception {
		return fetchRecord(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_ACC_ENTITY_PARAM_SELECT_SINGLE"),acc_entity_id);
	}

	public boolean hasParameter() throws Exception{
		return !((String)fetchRecord(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_PARAMETER_COUNT"),getLoginFacilityId()).get("TOTAL")).equals("0");
	}


	public HashMap getMessageHashMap(boolean bFlag){
		HashMap hmReturn	=	new HashMap();
		hmReturn.put(RESULT,bFlag?TRUE:FALSE);
		hmReturn.put(MESSAGE,"[Method body under development]Dummy Message for result: "+bFlag);
		return hmReturn;
	}

	public String getLast_modified_date(){
		return last_modified_date;
	}

	public void setLast_modified_date(String last_modified_date){
		this.last_modified_date	=	last_modified_date;
	}

	public String getImage(String checkedType) {
		if (checkedType == null) 
			return "";
		else if (checkedType.equalsIgnoreCase("M")) 
			return SsRepository.getSsKeyValue("MANDATORY_IMAGE");
		else if (checkedType.equalsIgnoreCase("Y") || checkedType.equalsIgnoreCase("E") ) 
			return SsRepository.getSsKeyValue("YES_IMAGE");
		else if (checkedType.equalsIgnoreCase("N") || checkedType.equalsIgnoreCase("D") ) 
			return SsRepository.getSsKeyValue("NO_IMAGE");
		else 
			return "";
	}

	public String getItemDescription(String item_code) throws Exception{
		HashMap hmRecord	=	fetchRecord(getSsRepositoryValue("SQL_SS_ITEM_SELECT_SINGLE"),item_code);
		return hmRecord.get("SHORT_DESC").toString();
	}

	public HashMap getItemDetails(String item_code) throws Exception{
		return	fetchRecord(getSsRepositoryValue("SQL_SS_ITEM_SELECT_SINGLE"),item_code);
	}

	public String getPeriodEndScope() throws Exception{
/*		HashMap hmResult = fetchRecord(getSsRepositoryValue("SQL_MM_INSTALLATION_PARAMETER_SELECT"));
		return (String)hmResult.get("SS_PERIOD_END_SCOPE");*/
		return new eMM.MM_license_rights().getSSperiodend();
	}

	//Added by Sakti #Inc no:48848 on 30/04/2014
   	//Starts
   	public HashMap getDurationforStartDate() throws Exception{
   	 
   			  HashMap DurationforStartDate = new HashMap();
   		try{	 
   			DurationforStartDate =    fetchRecord("SELECT  NVL(DURN_FOR_START_DATE,0)DURN_FOR_START_DATE, TO_CHAR(SYSDATE,'DD/MM/YYYY')SYSTEMDATE ,TO_CHAR(SYSDATE-NVL(DURN_FOR_START_DATE,0), 'DD/MM/YYYY') DURATIONFORSTARTDATE  FROM  SS_FACILITY_PARAM   WHERE FACILITY_ID = ? ",getLoginFacilityId());	  	
   		   }catch(Exception e){
   			e.printStackTrace();
   		  }
   		  return DurationforStartDate;
   		
   	  }
   //ends

	private	String last_modified_date			=	"";
	protected final int FUNCTION_DELETE			=	0;	
	protected final int FUNCTION_INSERT			=	1;	
	protected final int FUNCTION_UPDATE			=	2;
	protected final int FUNCTION_INSERT_BATCH	=	3;
	protected final Boolean TRUE				=	new Boolean(true);
	protected final Boolean FALSE				=	new Boolean(false);
	protected final String RESULT				=	"result";
	protected final String MESSAGE				=	"message";
	protected final String MSGID				=	"msgid"; 
}
