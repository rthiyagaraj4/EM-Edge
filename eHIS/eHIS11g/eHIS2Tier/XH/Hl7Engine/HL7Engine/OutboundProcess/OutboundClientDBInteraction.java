/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
	Modified By   : Nanda Kumar R.
	Modified Date : 4/3/2003
*/
package HL7Engine.OutboundProcess;

import java.io.Reader;
import java.io.Writer;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import oracle.jdbc.OracleCallableStatement;
import oracle.sql.BLOB;
import oracle.sql.CLOB;
import HL7Engine.Common.Common;
import HL7Engine.Common.CommonUtil;
import HL7Engine.Common.InterfaceUtil;
import HL7Engine.Common.SQLUtil;

public class OutboundClientDBInteraction
{
    Common common = null;

    String strPackageName = "call XHCORE.";
    String strPackageNameTemp = "call XPCORE.";
    String strPackageName3 = "call DBMS_SESSION.";
    String strErrorPackageName = "call xhgenprc.";
    String strGenericPackage = " XHGENERIC.";
    String strStandardPackage = " XHSTANDARD.";
    String strTnsName = "";
    String strOrclUserId = "";
    String strOrclPasswd = "";
    String strFileName = "outbound";
    String strMessage="";

    public Connection connDB;
    Connection externalDBConn;

    OutboundClientApplication client ;
    public OutboundClientParameters clientParameters;

    String strApplicationId;
    String strFacilityId;
    int    intProcessId;
    String strProcessType;

    String strSentMessageId = "0";
    String strSentAckType = "0";
    public String strSentEventType = "";
    String qAckType = "NE";

    String strCommStartTime = "";
    String strProcessEndTime = "";

    String strStandardAckTypeALWAYS = "AL";
    String strStandardAckTypeNEVER = "NE";
    String strStandardAckTypeERROR = "ER";
    String strStandardAckTypeSUCCESS = "SU";

    String strStopYN = "N";
    int intSentMessageLength = 0;

    String strReceiveAckMessageId = "0";
    String strReceiveAckCode = "0";

    boolean boolCanSend = true;
    boolean boolCanStop = false;
    boolean	boolRead = true;

    int intTotalWidth = 9999;
    int intNewProcessNo = 0;
    String strTotalParam ="0";

    //Code Inserted By srinivasa.N
    String strProtocalLinkId;
    //String strProtocalId
    String strModuleId;
    String replayFileName;
    String readBeforeDate;
    String msgBuildTime;

    char temp = ' ';
    Timestamp billingSentFileDate;

    LinkedHashMap messageBufferMap;
    Iterator messageBufferIterator;	

    public void getXHParameters()
    {
	Statement stmt = null;
	ResultSet rset = null;

	try
	{			
	    stmt = connDB.createStatement();

	    String strQry = "SELECT comm_process_idle_time, que_yn, offline_purge_yn FROM xh_param";
	    rset = stmt.executeQuery(strQry);

	    if (rset.next())
	    {
		clientParameters.intIdleTime = rset.getInt("comm_process_idle_time");
		clientParameters.isQueueEnabled = rset.getString("que_yn");
		String offlinePurgeYN = rset.getString("offline_purge_yn");

		if (clientParameters.intIdleTime <= 0)
		{
		    clientParameters.intIdleTime = 9999;
		}
		common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getXHParameters) Idle Time: "+clientParameters.intIdleTime+" Min.\n");

		if("Y".equalsIgnoreCase(clientParameters.isQueueEnabled))
		{
		    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getXHParameters) Queue enabled...\n" );
		    if(!"Y".equalsIgnoreCase(offlinePurgeYN)) common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getXHParameters) !!! Offline purge is not enabled !!!\n" );
		    else clientParameters.isPurgeEnabled = true;
		}
	    }
	}
	catch(Exception exceptionQry)
	{			
	    common.fileOutput(clientParameters.strLogFile,"getXHParameters():"+exceptionQry);
	    checkDBConnection();
	}
	finally
	{
	    closeResource(rset, stmt);			
	}
    }

    public void setNextSleepCalculationTime()
    {
	GregorianCalendar gcTemp = new GregorianCalendar();

	int day = 0;
	try 
	{
	    day = gcTemp.get(GregorianCalendar.DAY_OF_YEAR);
	    day += 1;
	    gcTemp.set(GregorianCalendar.DAY_OF_YEAR,day);
	    gcTemp.set(GregorianCalendar.HOUR_OF_DAY,0);
	    gcTemp.set(GregorianCalendar.MINUTE,5);
	    clientParameters.nextSleepCalculationTimeProtocol = gcTemp.getTimeInMillis();
	    clientParameters.nextSleepCalculationTime = gcTemp.getTimeInMillis();
	} 
	catch (Exception ex) 
	{
	    ex.printStackTrace();
	} 
    }

    public void convertToJavaLongTime()
    {
	GregorianCalendar gcTemp = new GregorianCalendar();
	String strTimePortion[] = new String[2];
	try
	{
	    gcTemp.set(GregorianCalendar.MILLISECOND,0);
	    gcTemp.set(GregorianCalendar.SECOND,0);
	    for (int j = 0; j < clientParameters.strSleepFrom.length; j++)
	    {
		strTimePortion = clientParameters.strSleepFrom[j].split(":");
		gcTemp.set(GregorianCalendar.HOUR_OF_DAY,Integer.parseInt(strTimePortion[0]));
		gcTemp.set(GregorianCalendar.MINUTE,Integer.parseInt(strTimePortion[1]));
		clientParameters.longSleepFrom[j] = gcTemp.getTimeInMillis();

		strTimePortion = clientParameters.strSleepTo[j].split(":");
		gcTemp.set(GregorianCalendar.HOUR_OF_DAY,Integer.parseInt(strTimePortion[0]));
		gcTemp.set(GregorianCalendar.MINUTE,Integer.parseInt(strTimePortion[1]));
		clientParameters.longSleepTo[j] = gcTemp.getTimeInMillis();
	    }
	}
	catch(Exception exp) { }
    }

    public void convertToJavaLongTimeProtocol()
    {
	GregorianCalendar gcTemp = new GregorianCalendar();
	String strTimePortion[] = new String[2];
	try
	{
	    gcTemp.set(GregorianCalendar.MILLISECOND,0);
	    gcTemp.set(GregorianCalendar.SECOND,0);
	    for (int j = 0; j < clientParameters.strSleepFrom.length; j++)
	    {
		strTimePortion = clientParameters.strSleepFromProtocol[j].split(":");
		gcTemp.set(GregorianCalendar.HOUR_OF_DAY, Integer.parseInt(strTimePortion[0]));
		gcTemp.set(GregorianCalendar.MINUTE, Integer.parseInt(strTimePortion[1]));
		clientParameters.longSleepFromProtocol[j] = gcTemp.getTimeInMillis();

		strTimePortion = clientParameters.strSleepToProtocol[j].split(":");
		gcTemp.set(GregorianCalendar.HOUR_OF_DAY, Integer.parseInt(strTimePortion[0]));
		gcTemp.set(GregorianCalendar.MINUTE, Integer.parseInt(strTimePortion[1]));
		clientParameters.longSleepToProtocol[j] = gcTemp.getTimeInMillis();
	    }
	}
	catch(Exception exp)
	{
	    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
	}
    }

    private void getNewProcessId()
    {
	Statement stmt = null;
	ResultSet rset = null;
	try
	{
	    stmt = connDB.createStatement();
	    String strQry  = "SELECT XH_PROCESS_ID_SEQ.NEXTVAL FROM DUAL ";
	    rset = stmt.executeQuery(strQry );
	    if (rset.next())
	    {
		intNewProcessNo = rset.getInt(1);
	    }			
	    clientParameters.boolDBDown = false;
	}
	catch(Exception exceptionQry)
	{
	    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getNewProcessId()) "+exceptionQry+"\n" );
	    checkDBConnection();
	}
	finally
	{
	    closeResource(rset, stmt);			
	}
    }
    public void createNewProcessId()
    {
	String strErrorText = "0";
	getNewProcessId();

	try
	{
	    String strProcedureName = "{" + strPackageName + "INSERT_COMM_PROCESS(?,?,?,?,?,?)" + "}";
	    OracleCallableStatement call =(OracleCallableStatement) connDB.prepareCall(strProcedureName);
	    call.setInt(1,this.intNewProcessNo);
	    call.setString(2,clientParameters.strFacilityId);
	    call.setString(3,OutboundClientParameters.machineName);
	    call.setString(4,clientParameters.strApplicationId);
	    call.setString(5,"O");
	    call.registerOutParameter(6,java.sql.Types.VARCHAR);
	    call.execute();
	    strErrorText = call.getString(6);

	    if (strErrorText == null || strErrorText.equals("")||strErrorText.equalsIgnoreCase("null") )
	    {
		this.commit();

	    }
	    else
	    {
		this.rollback();
	    }
	    call.close();
	    OutboundClientParameters.strCommandParam[2] = this.intNewProcessNo + "";
	}
	catch(SQLException exceptionSQL)
	{				
	    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:createNewProcessId) "+exceptionSQL+"\n" );
	    checkDBConnection();
	}
	catch(Exception exceptionQry)
	{
	    rollback();			    
	    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:createNewProcessId) "+exceptionQry+"\n" );
	    checkDBConnection();
	}

    }

    public void checkDBConnection()
    {
	Statement stmt = null;
	ResultSet rset = null;
	try
	{
	    stmt = connDB.createStatement();
	    String strQry = "SELECT 1 FROM DUAL";
	    rset = stmt.executeQuery(strQry);
	    clientParameters.boolDBDown = false;
	}
	catch(Exception exceptionQry)
	{
	    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:checkDBConnection) "+exceptionQry.getMessage()+"\n" );
	    clientParameters.boolDBDown = true;
	}
	finally
	{
	    closeResource(rset, stmt);			
	}
    }

    public void checkExeDBConnection(String database)
    {
	Statement stmt = null;
	ResultSet rset = null;

	try
	{
	    stmt = externalDBConn.createStatement();
	    String strQry = CommonUtil.getPropertyVal(InterfaceUtil.getiniFilePath("DB_QRY"), database);
	    rset = stmt.executeQuery(strQry);
	    clientParameters.isExternalDBDown = false;
	}
	catch(Exception exceptionQry)
	{
	    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:checkExeDBConnection) "+exceptionQry.getMessage()+"\n" );
	    clientParameters.isExternalDBDown = true;
	}
	finally
	{
	    closeResource(rset, stmt);			
	}
    }

    public boolean canISend()
    {
	return(boolCanSend);
    }

    public synchronized String getSentMessageId()
    {
	return(strSentMessageId);
    }

    public OutboundClientDBInteraction()
    {
    }

    public OutboundClientDBInteraction(OutboundClientApplication c, OutboundClientParameters clientP)
    {
    	common = Common.getInstance();
    	client = c;
    	clientParameters = clientP;	
    	strApplicationId = clientP.strApplicationId;
    	strFacilityId = clientP.strFacilityId;
    	intProcessId = clientP.intProcessId;
    	strTnsName = clientP.strTnsName;
    	strOrclUserId = clientP.strOrclUserId;
    	strOrclPasswd = clientP.strOrclPassword;
    	strProcessType = clientP.strProcessType;
    	strProtocalLinkId = clientP.strProtocalLinkId;
    	strModuleId = clientP.strModuleId;	
    }

    private void setMedUserRole()
       {	
    	try
    	{
    	    String strParamRole = "";
    	    String strProcedureName = "{" + strPackageName3 + "SET_ROLE(?)" + "}";
    	    Statement stmt = null; 
    	    String strQry = "SELECT APP_PASSWORD.DECRYPT(ORA_ROLE_PASSWORD) FROM SM_ORA_ROLE Where ORA_ROLE_ID = 'MEDUSERS'";
    	    OracleCallableStatement  call = null;
    	    ResultSet rset = null;
    	    String strPasswd = "";
    	    try
    	    {
        		stmt = connDB.createStatement();
        		rset = stmt.executeQuery(strQry );
        
        		while (rset.next())
        		{
        		    strPasswd = rset.getString(1);
        		}
        		stmt.close();
    	    }
    	    catch(Exception expSql)
    	    {
        		common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:setMedUserRole) "+expSql+"\n" );
        		closeResource(null, stmt);
    	    }
    
    	    strParamRole = "MEDUSERS";
    	    call = (OracleCallableStatement) connDB.prepareCall(strProcedureName);
    	    call.setString(1,strParamRole);
    	    call.execute();
    	    call.close();
    	}
    	catch(Exception expCal)
    	{
    	    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:setMedUserRole) "+expCal+"\n" );
    	    checkDBConnection();
    	}
    }

    public boolean makeDBConnection()
    {
	try
	{			
	    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());			
	    connDB = DriverManager.getConnection("jdbc:oracle:thin:@"+strTnsName,strOrclUserId, strOrclPasswd);			
	    connDB.setAutoCommit(false);			
	    setMedUserRole();			
	    clientParameters.boolDBDown = false;
	    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:makeDBConnection) Database Connection Successful\n" );          

	    return(true);
	}
	catch(SQLException exceptionSQL)
	{
	    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionSQL) + "\n");
	    clientParameters.boolDBDown = true;
	    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:makeDBConnection) Exception: "+exceptionSQL.getMessage()+"\n" );
	}
	catch(Exception exceptionConnection)
	{	
	    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionConnection) + "\n");
	    clientParameters.boolDBDown = true;
	    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:makeDBConnection) Exception: "+exceptionConnection.getMessage()+"\n" );
	}
	catch(Error error)
	{
	    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(error) + "\n");
	    clientParameters.boolDBDown = true;
	    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:makeDBConnection) Exception: "+error.getMessage()+"\n" );
	}
	return(false);
    }

    public void getProtocolSleepingInterval()
    {
		OracleCallableStatement  call = null;
		try
		{
		    this.setNextSleepCalculationTime();
		    String strProcedureName = "{ CALL " + strGenericPackage + "GET_APPL_COMM_PROC_SLEEP_TIME(?,?,?,?,?)"+"}";
	
		    call =(OracleCallableStatement) connDB.prepareCall(strProcedureName);
	
		    call.setString(1,strProtocalLinkId);			
		    call.registerOutParameter(2,java.sql.Types.VARCHAR);
		    call.registerOutParameter(3,java.sql.Types.VARCHAR);
		    call.registerOutParameter(4,java.sql.Types.VARCHAR);
		    call.registerOutParameter(5,java.sql.Types.VARCHAR);
		    call.execute ();
		    String delimiterOfDate = ";";
		    String strTodaySleepYN = call.getString(2)	;
		    String strFromArrayDate = call.getString(3)	;
		    String strToArrayDate = call.getString(4)	;
	
		    if ((strTodaySleepYN == null) || (strTodaySleepYN.equalsIgnoreCase("null")))
		    {				
				clientParameters.isSleepEnabledTodayProtocol = false;
				strTodaySleepYN = "N";
		    }
	
		    try 
		    {
				if(strTodaySleepYN.equalsIgnoreCase("Y")) 
				{
				    clientParameters.isSleepEnabledTodayProtocol = true;
				    clientParameters.strSleepFromProtocol = strFromArrayDate.split(delimiterOfDate);
				    clientParameters.strSleepToProtocol = strToArrayDate.split(delimiterOfDate);
				    convertToJavaLongTimeProtocol();
				}
				else
				{
				    clientParameters.isSleepEnabledTodayProtocol = false;
				}
		    } 
		    catch(Exception ex) 
		    {
		    	common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(ex) + "\n");
		    }
	
		    call.close();
		}
		catch(SQLException exceptionSQL)
		{		
		    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionSQL) + "\n");
		    try
		    {
		    	call.close();
		    }
		    catch(Exception e)
		    {
		    	System.out.println("ECEPT(OJ");
		    }		
		    checkDBConnection();
		}
		catch(Exception exceptionQry)
		{		
		    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionQry) + "\n");
		    try {
		    	call.close();							
		    }
		    catch(Exception e) {
		    	System.out.println("ECEPT(OJ");
		    }		
		    checkDBConnection();
		}
    }

    public void getSleepingTimeInterval()
	 {
			OracleCallableStatement call = null;
			try {
				this.setNextSleepCalculationTime();
				String strProcedureName = "{" + strPackageName
						+ "get_comm_process_sleep_time(?,?,?,?)" + "}";
	
				call = (OracleCallableStatement) connDB
						.prepareCall(strProcedureName);
	
				call.registerOutParameter(1, java.sql.Types.VARCHAR);
				call.registerOutParameter(2, java.sql.Types.VARCHAR);
				call.registerOutParameter(3, java.sql.Types.VARCHAR);
				call.registerOutParameter(4, java.sql.Types.VARCHAR);
				call.execute();
	
				String delimiterOfDate = ";";
				String strTodaySleepYN = call.getString(1);
				String strFromArrayDate = call.getString(2);
				String strToArrayDate = call.getString(3);
	
				if ((strTodaySleepYN == null)
						|| (strTodaySleepYN.equalsIgnoreCase("null"))) {
					clientParameters.isSleepEnabledToday = false;
					strTodaySleepYN = "N";
				}
	
				try {
					if (strTodaySleepYN.equalsIgnoreCase("Y")) {
						clientParameters.isSleepEnabledToday = true;
						clientParameters.strSleepFrom = strFromArrayDate
								.split(delimiterOfDate);
						clientParameters.strSleepTo = strToArrayDate
								.split(delimiterOfDate);
						convertToJavaLongTime();
					} else {
						clientParameters.isSleepEnabledToday = false;
					}
	
				} catch (Exception ex) {
				} finally {
				}
			} catch (SQLException exceptionSQL) {
				common.fileOutput(clientParameters.strLogFile,
						"(OutboundClientDBInteraction:getSleepingInterval) "
								+ exceptionSQL);
				checkDBConnection();
				common.fileOutput(clientParameters.strExceptionLogFile,
						CommonUtil.getStringStackTrace(exceptionSQL) + "\n");
			} catch (Exception exceptionQry) {
				common.fileOutput(clientParameters.strLogFile,
						"(OutboundClientDBInteraction:getSleepingInterval) "
								+ exceptionQry);
				common.fileOutput(clientParameters.strExceptionLogFile,
						CommonUtil.getStringStackTrace(exceptionQry) + "\n");
			} finally {
				closeResource(null, call);
			}
		}// End of getSleepingInterval

    public synchronized OutboundClientParameters getAllParameters()
	{
		OracleCallableStatement call = null;
		String strOutboundLogYN = "N";
		String strErrorText = "0";
		try
		{					
		    String strProcedureName = "{" + strPackageName 
		    							+ "Get_application_info(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";

		    call = (OracleCallableStatement) connDB.prepareCall(strProcedureName);
	
		    call.setString(1, strApplicationId);
		    call.setString(2, strFacilityId);
		    call.setString(3, strProcessType);
		    call.setString(4, strProtocalLinkId);
		    call.registerOutParameter(5, java.sql.Types.VARCHAR);
		    call.registerOutParameter(6, java.sql.Types.VARCHAR);
		    call.registerOutParameter(7, java.sql.Types.VARCHAR);
		    call.registerOutParameter(8, java.sql.Types.VARCHAR);
		    call.registerOutParameter(9, java.sql.Types.VARCHAR);
		    call.registerOutParameter(10, java.sql.Types.VARCHAR);
		    call.registerOutParameter(11, java.sql.Types.VARCHAR);
		    call.registerOutParameter(12, java.sql.Types.VARCHAR);
		    call.registerOutParameter(13, java.sql.Types.VARCHAR);
		    call.registerOutParameter(14, java.sql.Types.VARCHAR);
		    call.registerOutParameter(15, java.sql.Types.VARCHAR);			
		    call.registerOutParameter(16, java.sql.Types.VARCHAR);
		    call.registerOutParameter(17, java.sql.Types.VARCHAR);
		    call.registerOutParameter(18, java.sql.Types.VARCHAR);
		    call.registerOutParameter(19, java.sql.Types.VARCHAR);
		    call.registerOutParameter(20, java.sql.Types.VARCHAR);
		    call.registerOutParameter(21, java.sql.Types.VARCHAR);
		    call.registerOutParameter(22, java.sql.Types.VARCHAR);
		    call.registerOutParameter(23, java.sql.Types.VARCHAR);
		    call.registerOutParameter(24, java.sql.Types.VARCHAR);
		    call.registerOutParameter(25, java.sql.Types.VARCHAR);
		    call.registerOutParameter(26, java.sql.Types.VARCHAR);
		    call.registerOutParameter(27, java.sql.Types.VARCHAR);
		    call.registerOutParameter(28, java.sql.Types.VARCHAR);
		    call.registerOutParameter(29, java.sql.Types.VARCHAR);
		    call.registerOutParameter(30, java.sql.Types.VARCHAR);
		    call.registerOutParameter(31, java.sql.Types.VARCHAR);
		    call.registerOutParameter(32, java.sql.Types.VARCHAR);
		    call.registerOutParameter(33, java.sql.Types.VARCHAR);
		    call.registerOutParameter(34, java.sql.Types.VARCHAR);
		    call.registerOutParameter(35, java.sql.Types.VARCHAR);
		    call.registerOutParameter(36, java.sql.Types.VARCHAR);
		    call.registerOutParameter(37, java.sql.Types.VARCHAR);
		    call.registerOutParameter(38, java.sql.Types.VARCHAR);
	
		    call.execute ();
	
		    strErrorText = call.getString(31);			
	
		    if (strErrorText == null) {	
		    	clientParameters.boolError = false;
		    }
		    else {
				common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) strErrorText: "+strErrorText+"\n" ); 
				clientParameters.boolError = true;				
		    }
	
		    clientParameters.strProtocolId = call.getString(5);
		    clientParameters.strProtocolType = call.getString(6); 
		    clientParameters.strProtocolMode = call.getString(7); 	
		    clientParameters.strFileNamingConvention = call.getString(8); 	
		    clientParameters.strDbfFileType = call.getString(9);
		    clientParameters.strCreateFileInterval = call.getString(10);  
		    clientParameters.strCreateDataInterval = call.getString(11); 
		    clientParameters.strCommdataIoApi = call.getString(12);
		    clientParameters.strCommStatistics = call.getString(13); 				
		    clientParameters.strModuleId = call.getString(14); 
		    strModuleId = clientParameters.strModuleId;			
		    clientParameters.strAckType = call.getInt(15);
		    clientParameters.strCommunicationMode = call.getString(16);
		    clientParameters.strFileDirectory = call.getString(17); 
		    clientParameters.strIpAddress  = call.getString(18); 	
		    clientParameters.intPortNumber = call.getInt(19); 	
		    clientParameters.intRetryInterval = call.getInt(20);
		    clientParameters.intMaxRetries  = call.getInt(21);  
		    clientParameters.strRestartType = call.getString(22); 
		    clientParameters.restartTime	= call.getString(23);
		    clientParameters.offline = false;
		    clientParameters.strAckFileDirectory = call.getString(25);
		    strOutboundLogYN = call.getString(29);
		    clientParameters.profileID = call.getString(37);
		    clientParameters.url = call.getString(26);
		    clientParameters.odbcDBUserID = call.getString(34);
		    clientParameters.odbcDBPwd = call.getString(35);
	
		    if("D".equalsIgnoreCase(clientParameters.strCommunicationMode)) {				
				clientParameters.odbcDBDriver = call.getString(33);
				clientParameters.odbcDBURL = call.getString(32);
				clientParameters.odbcDBSID = call.getString(36);
		    }
		    else if("W".equalsIgnoreCase(clientParameters.strCommunicationMode)
		    		|| "WC".equalsIgnoreCase(clientParameters.strCommunicationMode)) {
				clientParameters.webserviceURL = call.getString(26);
				clientParameters.webserviceUID = call.getString(34);
				clientParameters.webservicePwd = call.getString(35); 
		    }
		    else if("SO".equalsIgnoreCase(clientParameters.strCommunicationMode)) {
				clientParameters.webserviceURL = call.getString(26);
		    }
		    if(strOutboundLogYN != null && !strOutboundLogYN.equals("")) {
				clientParameters.intWrite = (strOutboundLogYN.equalsIgnoreCase("Y"))? 1:0;
				clientParameters.logToFile = (strOutboundLogYN.equalsIgnoreCase("Y"))? true:false;
		    }
	
		    if("0".equals(clientParameters.strAckType)) qAckType = "AL";
		    else if("1".equals(clientParameters.strAckType)) qAckType = "NE";
		    else if("2".equals(clientParameters.strAckType)) qAckType = "ER";
	
		    common.setLogCriteria(clientParameters.logToFile);
	
		    if(clientParameters.logToFile) {
		    	common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) Log Enabled\n" );
		    }
		    else {
		    	common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) Log Disabled !!!\n" );
		    }
	
		    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) Communication Mode["+ clientParameters.strCommunicationMode +"]\n" );
		    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) Module["+ strModuleId +"]\n" );
		    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) Profile["+ clientParameters.profileID +"]\n" );
		    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) ProtocolID["+ clientParameters.strProtocolId +"]\n" );
		    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) File Type["+	clientParameters.strDbfFileType +"]\n" );
	
		    if(clientParameters.strCommunicationMode.equalsIgnoreCase("F")) {
				common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) Output File["+	clientParameters.strFileDirectory    +"]\n" );
				common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) Acknowledgement Directory["+	clientParameters.strAckFileDirectory    +"]\n" );
				common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) File Creation Interval["+clientParameters.strCreateFileInterval        +"]\n" );
		    }
		    else if("D".equalsIgnoreCase(clientParameters.strCommunicationMode))  {
				common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) odbcDBURL["+ clientParameters.odbcDBURL +"]\n" );
				common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) odbcDBUserID["+	clientParameters.odbcDBUserID +"]\n" );
				common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) odbcDBDriver["+ clientParameters.odbcDBDriver +"]\n" );
				common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) odbcDBSID["+ clientParameters.odbcDBSID +"]\n" );
		    }
		    else if("T".equalsIgnoreCase(clientParameters.strCommunicationMode)) {
				common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) Client IP Address[" + clientParameters.strIpAddress + "]\n" );
				common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) Client Port Number[" + clientParameters.intPortNumber + "]\n" );
		    }
		    else if("W".equalsIgnoreCase(clientParameters.strCommunicationMode)
		    		|| "WC".equalsIgnoreCase(clientParameters.strCommunicationMode)) {
				common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) Webservice URL[" + clientParameters.webserviceURL + "]\n" );
				common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) Username[" + clientParameters.webserviceUID + "]\n" );				
		    }
		    else if("H".equalsIgnoreCase(clientParameters.strCommunicationMode) || "CM".equalsIgnoreCase(clientParameters.strCommunicationMode)) {
		    	common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) URL[" + clientParameters.url + "]\n" );
		    }
		    else if("SO".equalsIgnoreCase(clientParameters.strCommunicationMode)){
				common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) Webservice URL[" + clientParameters.webserviceURL + "]\n" );
		    }
	
		    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) Retry Interval["+	clientParameters.intRetryInterval    +" Secs]\n" );
		    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) Max. Retries["+	clientParameters.intMaxRetries       +"]\n" );
		    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) Restart Type["+	clientParameters.strRestartType      +"]\n" );
	
		    if(!clientParameters.strRestartType.equalsIgnoreCase("N")) {
		    	common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) Restart Time["+	clientParameters.restartTime         +"]\n" );				
		    }
	
		    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) Log File["+clientParameters.strLogFile+"]\n" );
		    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) strCommdataIoApi["+clientParameters.strCommdataIoApi+"]\n" );
		    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) strCommStatistics["+clientParameters.strCommStatistics+"]\n" );
		    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) isWindowsService["+clientParameters.isWindowsService+"]\n" );		
		}
		catch(SQLException exceptionSQL)
		{			
		    clientParameters.boolError = true;				
		    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) "+exceptionSQL+"\n" );
		    if(clientParameters.stackTrace) common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionSQL) + "\n");
		    checkDBConnection();
		}
		catch(Exception exceptionQry)
		{
		    clientParameters.boolError = true;					        
		    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) "+exceptionQry+"\n" );
		    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionQry) + "\n");
		    checkDBConnection();
		}
		finally {
			SQLUtil.closeDBResources(null, call);
		}
		return clientParameters;
    }

    /**
     * Method for fetching the next message to be delivered.
     * If queue is enabled, messages will be fetched directly from the repository in bulk based on 'queuerecords' parameter in properties file.
     * else messages will be fetched using the SQL API.
     */
    public synchronized String getNextMessage(String strCommdataIoApi)
    {
		strMessage = "";
		ArrayList<String> currentMsgDtlsList = null;	
	
		if("Y".equals(clientParameters.isQueueEnabled))
		{			
		    if(messageBufferMap == null || messageBufferMap.isEmpty()) 
		    {
				loadMessagesToBuffer();
				if(clientParameters.logToFile && clientParameters.debugYN) common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getNextMessage) Messages loaded to buffer... \n" ) ;
		    }
	
		    messageBufferIterator = messageBufferMap.keySet().iterator();			
	
		    if (messageBufferIterator.hasNext())
		    {
				strSentMessageId = (String) messageBufferIterator.next();
				currentMsgDtlsList = (ArrayList) messageBufferMap.get(strSentMessageId);
		
				strMessage = currentMsgDtlsList.get(0);
				strSentMessageId = currentMsgDtlsList.get(1);
				strSentEventType = currentMsgDtlsList.get(2);
				strCommStartTime = currentMsgDtlsList.get(3);
				strSentAckType = qAckType;
				replayFileName = currentMsgDtlsList.get(5);
				intSentMessageLength = Integer.parseInt(currentMsgDtlsList.get(6));
				clientParameters.accessionNo = currentMsgDtlsList.get(7);
		    }			
		}
		else
		{			
		    strMessage = getMessageFromProc(strCommdataIoApi);
		}
		
		if (strMessage != null && !(strMessage.equals(""))) common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getNextMessage) MessageId["+strSentMessageId+"], EventType["+strSentEventType+"], Communication Start Time["+strCommStartTime+"], Acknowledgement Type["+strSentAckType+"], Message Length["+intSentMessageLength+"]\n" ) ;
	
		return strMessage;				
    }

    /**
     * Method fetches the next message from repository that is to be delivered.
     * SQL API (strCommdataIoApi) will be used to retrieve the message.
     */
    public synchronized String getMessageFromProc(String strCommdataIoApi)
    {
		strMessage="";		
		String strErrorText = "0";	
		OracleCallableStatement  call = null;
		try
		{
		    /********** 12 Parameters **************************************/
	
		    //	if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getNextMessage)strCommdataIoApi "+strCommdataIoApi+" \n" ) ;			
		    String strProcedureName = "{ call "+ strCommdataIoApi + "(?,?,?,?,?,?,?,?,?,?,?,?)"+"}";			
		    //code inserted By srinivasa.N 
		    //	if(strApplicationId.equals("EPABXO")) strProcedureName = "{"+ strPackageNameTemp+"get_application_message(?,?,?,?,?,?,?,?,?)"+"}";
		    if(strApplicationId.equals("EPABXO")) strProcedureName = "{ call "+ strCommdataIoApi +"(?,?,?,?,?,?,?,?,?,?,?,?)"+"}";
	
		    call =(OracleCallableStatement) connDB.prepareCall(strProcedureName);			
		    call.setString(1,strApplicationId);
		    call.setString(2,strFacilityId);
		    call.setInt(3,intProcessId);
		    call.setString(4,strModuleId);
		    call.registerOutParameter(5,java.sql.Types.VARCHAR);
		    call.registerOutParameter(6,java.sql.Types.VARCHAR);
		    call.setString(7,strProtocalLinkId);
		    call.registerOutParameter(8,java.sql.Types.VARCHAR);
		    call.registerOutParameter(9,java.sql.Types.CLOB);
		    call.registerOutParameter(10,java.sql.Types.VARCHAR);
		    call.registerOutParameter(11,java.sql.Types.VARCHAR);
		    call.registerOutParameter(12,java.sql.Types.VARCHAR);
	
		    call.execute ();			
	
		    strErrorText = call.getString(12);
	
		    if (strErrorText == null || strErrorText.equals("")) 
		    {
				Clob clobMessage = call.getClob(9);  
				if(clobMessage != null)
				{					
				    Reader readerMsg = clobMessage.getCharacterStream();
		
				    while(true)
				    {
						char charMsg[] = new char[intTotalWidth];					
						int intData = readerMsg.read(charMsg);
						if (intData > 0)
						{						
						    strMessage += String.valueOf(charMsg,0,intData);
						}
						else break;					
				    }
				    readerMsg.close();
				    strSentMessageId = call.getString(5);					
				    strSentEventType = call.getString(6);
				    strCommStartTime = call.getString(8);
				    strSentAckType = call.getString(11);
				    replayFileName = call.getString(10);
				    intSentMessageLength = strMessage.length();
				    msgBuildTime = "13122007 10:10";

				    if ( (strSentAckType != null) 
					    && ( strSentAckType.equals(strStandardAckTypeALWAYS) 
						    || strSentAckType.equals(strStandardAckTypeSUCCESS) 
						    || strSentAckType.equals(strStandardAckTypeERROR)))
				    {
						if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getNextMessage) Acknowledgement Expected\n" ) ;
						boolCanSend = false;
				    }	
				    else
				    {
				    	boolCanSend =	true;
				    }					
				}
				else
				{
				    //	if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getNextMessage)Message not exists\n" ) ;
				    //	throw new NullPointerException();
				}
		    }
		    call.close();			
		}
		catch(SQLException exceptionSQL)
		{
		    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionSQL) + "\n");
		    common.fileOutput( clientParameters.strExceptionLogFile, "(OutboundClientDBInteraction:getNextMessage: ) "+exceptionSQL+"\n" );			
		    checkDBConnection();
		}
		catch(Exception exceptionQry)
		{	
		    rollback();	
		    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionQry) + "\n");
		    common.fileOutput( clientParameters.strExceptionLogFile, "(OutboundClientDBInteraction:getNextMessage)Exception "+exceptionQry+"\n" ) ;
		    checkDBConnection();
		}
		return(strMessage);				
    }	

    /**
     * Method retrives pending messages in bulk using a sql query and stores them in buffer.
     */
    private void loadMessagesToBuffer()
    {
	String msgFetchQry = "SELECT message_id, message_date, message_text, event_type,"+
						" outbound_file_name, accession_num"+
						" FROM (SELECT a.message_id, a.message_date, a.MESSAGE_TEXT, a.event_type,"+
						" a.outbound_file_name, e.accession_num"+
						" FROM "+strModuleId+"_application_message a, "+strModuleId+"_event e"+
						" WHERE a.application_id = ? AND a.protocol_link_id = ?"+
						" AND   a.message_status IS NULL"+
						" AND   a.application_id = e.application_id"+
						" AND   a.facility_id = e.facility_id"+
						" AND   a.message_id = e.message_id"+
						" ORDER BY message_date ASC)"+
						" WHERE   ROWNUM <= ?";			
	String tempMessage = null;

	ArrayList<String> msgDtlsList = null;

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Clob msgClobData = null;

	try
	{
	    if("SRREBLG13".equals(clientParameters.strProtocalLinkId))
	    {
	    	msgFetchQry = "SELECT message_id, message_date, message_text, event_type,"+
					" outbound_file_name, accession_num"+
					" FROM (SELECT a.message_id, a.message_date, a.MESSAGE_TEXT, a.event_type,"+
					" a.outbound_file_name, '' accession_num"+
					" FROM "+strModuleId+"_application_message a"+
					" WHERE a.application_id = ? AND a.protocol_link_id = ?"+
					" AND   a.message_status IS NULL"+
					" ORDER BY message_date ASC)"+
					" WHERE   ROWNUM <= ?";
	    }
	    if(messageBufferMap == null) messageBufferMap = new LinkedHashMap();

	    pstmt = connDB.prepareStatement(msgFetchQry);
	    pstmt.setString(1, strApplicationId);
	    pstmt.setString(2, clientParameters.strProtocalLinkId);
	    pstmt.setString(3, clientParameters.maxQueueMessages);

	    rs = pstmt.executeQuery();			

	    while(rs.next())
	    {				
		msgDtlsList = new ArrayList<String>();				

		msgClobData = rs.getClob("message_text");
		tempMessage = msgClobData.getSubString(1, (int)msgClobData.length());
		msgDtlsList.add(tempMessage);
		msgDtlsList.add(rs.getString("message_id"));
		msgDtlsList.add(rs.getString("event_type"));
		msgDtlsList.add(CommonUtil.getFormattedStringDate("dd/MM/yyyy hh:mm:ss:SS", new java.util.Date()));
		msgDtlsList.add(qAckType);
		msgDtlsList.add(rs.getString("outbound_file_name"));
		msgDtlsList.add(tempMessage.length() + "");
		msgDtlsList.add(rs.getString("accession_num"));

		messageBufferMap.put(rs.getString("message_id"), msgDtlsList);
	    }			
	}
	catch (Exception exp)
	{
	    common.fileOutput(clientParameters.strExceptionLogFile, "(OutboundClientDBInteraction:loadMessagesToBuffer)Exception "+exp+"\n" ) ;
	    checkDBConnection();
	}
	finally
	{
	    closeResource(rs, pstmt);
	}
    }

    public synchronized void updateApplicationMessageStatus(int commRetries,int totalMessages,String msgSts,String whoSts,String fileName)
    {
    	String strErrorText = "0";
    	OracleCallableStatement call = null;
    
    	try
    	{
    	    String strProcedureName = "{ call "+ clientParameters.strCommStatistics +"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    
    	    //	if(strApplicationId.equals("EPABXO")) strProcedureName = "{"+ strPackageNameTemp+"UPDATE_APPL_MESSAGE_INFO(?,?,?,?,?,?,?,?,?,?,?,?,?)"+"}";
    	    if(clientParameters.logToFile)
    	    {				
    	    	common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:updateApplicationMessageStatus) EventType ["+strSentEventType+"], MessageLength ["+intSentMessageLength+"], MsgStatus ["+msgSts+"], CommStartTime ["+strCommStartTime+"]\n") ;				
    	    }			
    
    	    call = (OracleCallableStatement) connDB.prepareCall(strProcedureName);
    
    	    call.setString(1, strApplicationId);
    	    call.setString(2, strFacilityId);
    	    call.setString(3, strSentMessageId);
    	    call.setString(4, strSentEventType);
    	    call.setInt(5, intProcessId);
    	    call.setString(6, strModuleId);
    	    call.setInt(7, intSentMessageLength);
    	    call.setString(8, strCommStartTime); // Communication Starttime
    	    call.setInt(10, commRetries);
    	    call.setInt(11, totalMessages);
    	    call.setString(12, msgSts);	// Status
    	    call.setString(13, whoSts);	// Who initated -- sender
    	    call.registerOutParameter(16, java.sql.Types.VARCHAR);
    	    call.registerOutParameter(9, java.sql.Types.VARCHAR); // Communication End Time
    	    call.setString(14, fileName);
    	    call.setString(15, strProtocalLinkId);
    
    	    call.execute();
    	    strErrorText = call.getString(16);
    
    	    if (strErrorText == null || strErrorText.equals("") )
    	    {						
        		connDB.commit();	
        		common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:updateApplicationMessageStatus) Message Status updated for : "+strSentMessageId+"\n" ) ;
    	    }
    	    else
    	    {			
        		common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:updateApplicationMessageStatus) strErrorText "+strErrorText+"\n" ) ;
        		connDB.rollback();
    	    }
    
    	    if("Y".equals(clientParameters.isQueueEnabled))
    	    {
        		messageBufferMap.remove(strSentMessageId);
        		common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:updateApplicationMessageStatus) Removing "+strSentMessageId+" from buffer\n" ) ;
    	    }
    
    	    strProcessEndTime = call.getString(9);			
    	}		
    	catch(Exception exceptionQry)
    	{
    	    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionQry) + "\n");
    	    rollback();							
    	    checkDBConnection();
    	}
    	finally
    	{
    	    closeResource(null, call);
    	}
    }

    public synchronized boolean canIStop()
    {
	ResultSet rset = null;
	Statement stmt = null;
	try
	{
	    stmt = connDB.createStatement();
	    String strQry = "SELECT PROCESS_STATUS FROM XH_COMM_PROCESS WHERE PROCESS_ID = "+intProcessId;
	    rset = stmt.executeQuery(strQry);
	    while(rset.next())
	    {
		strStopYN = rset.getString(1);			
	    }

	    if(strStopYN.equals("C")) 
	    {
		return(true);
	    }
	    else
	    {
		return(false);
	    }
	}
	catch(Exception exceptionQry)
	{							
	    checkDBConnection();
	    if(!clientParameters.boolDBDown)
		common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:canIStop) Exception:"+exceptionQry+"\n" ) ;
	}
	finally
	{
	    closeResource(rset, stmt);			
	}
	return(false);
    }

    public void closeDBconn()
    {	
	try
	{
	    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:closeDBconn) Closing Database Connection�"+"\n" ) ;
	    connDB.close();
	    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:closeDBconn) Database Connection Closed"+"\n" ) ;
	    clientParameters.boolDBDown = true;
	}
	catch(Exception exceptionCloseDB)
	{
	    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:closeDBconn) Exception:"+exceptionCloseDB+"\n" ) ;
	    //	common.fileOutput( clientParameters.strExceptionLogFile, "(OutboundClientDBInteraction:closeDBconn) Exception:"+exceptionCloseDB+"\n" ) ;
	    checkDBConnection();
	}
    }

    public void updateCommRetries(int cnt)
    {
	try
	{
	    Statement stmt = connDB.createStatement();
	    String strUpdQry = "UPDATE XH_COMM_PROCESS SET "+
	    " LAST_OUTBOUND_RETRIES = "+cnt+
	    " WHERE PROCESS_ID="+intProcessId+
	    " AND APPLICATION_ID = '"+strApplicationId+"'";
	    stmt.executeUpdate(strUpdQry );
	    connDB.commit();
	    stmt.close();
	}
	catch(Exception exceptionQry)
	{
	    rollback();
	    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:updateCommRetries)Exception:"+exceptionQry+"\n" );
	    checkDBConnection();
	}
    }

    public void updateResendProcessStatus()
    {
	try
	{
	    Statement stmt = connDB.createStatement();
	    String strUpdQry = "UPDATE  XH_COMM_PROCESS SET "+
	    " TOTAL_MESSAGES =  TOTAL_MESSAGES-1 " +
	    " WHERE PROCESS_ID="+intProcessId+
	    " AND APPLICATION_ID = '"+strApplicationId+"'";
	    stmt.executeUpdate(strUpdQry );
	    connDB.commit();
	    stmt.close();
	}
	catch(Exception exceptionQry)
	{

	    rollback();
	    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:updateResendProcessStatus) "+exceptionQry+"\n" );
	    checkDBConnection();
	}
    }

    /**
     * Method to make the message status null, method used for gateway parameter monitor check
     */
    public void updateResendMessageStatus()
    {
	try
	{
	    Statement stmt = connDB.createStatement();
	    String strUpdQry = "UPDATE  XH_APPLICATION_MESSAGE SET "+
	    " MESSAGE_STATUS = NULL "+
	    " WHERE APPLICATION_ID = '"+strApplicationId+"'" +
	    " AND MESSAGE_ID = '"+strSentMessageId+"'";
	    stmt.executeUpdate(strUpdQry);
	    connDB.commit();
	    stmt.close();

	}
	catch(Exception exceptionQry)
	{
	    rollback();
	    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:updateResendMessageStatus) "+exceptionQry+"\n" );
	    checkDBConnection();
	    //	registerError("DBInterraction.updateCommRetries()",exceptionQry+"");
	}
    }

    public int getMessageCountForTheProcess()
    {
	int msg = 0;
	ResultSet rset = null;
	Statement stmt = null;
	try
	{
	    stmt = connDB.createStatement();
	    String strQry = " SELECT TOTAL_MESSAGES FROM XH_COMM_PROCESS "+
	    "  WHERE PROCESS_ID="+intProcessId+
	    "  AND APPLICATION_ID = '"+strApplicationId+"'";
	    rset = stmt.executeQuery(strQry );
	    if(rset.next())
	    {
		msg = rset.getInt(1);  
	    }
	    else
	    {
		msg  = 0;
	    }
	    stmt.close();
	    return(msg);
	}
	catch(Exception exceptionQry)
	{
	    rollback();
	    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getMessageCountForTheProcess) "+exceptionQry+"\n" );
	    checkDBConnection();
	    //registerError("DBInterraction.updateProcessStatus",exceptionQry+"");
	}
	finally
	{
	    closeResource(rset, stmt);		
	}
	return(0);
    }

    /**
     * Procedure used to update process status directly from java using update statement.
     * Generally "updateProcessStatusProc" will be used for updating the status. This method is just for temporary backup.
     * @param sts
     * @param cnt
     */
	public void updateProcessStatusDirect(String sts,int cnt)
    {
	try
	{
	    Statement stmt = connDB.createStatement();
	    String strUpdQry = "UPDATE  XH_COMM_PROCESS SET " +
	    "	PROCESS_STATUS = '"+sts+"', COMM_STATUS = 'N',"+
	    "	LAST_OUTBOUND_RETRIES = " + cnt +
	    ", STOP_DATE_TIME = SYSDATE, STOPPED_BY_ID = USER " +
	    "  WHERE PROCESS_ID=" + intProcessId + " AND APPLICATION_ID = '"+strApplicationId+"'";

	    if("A".equalsIgnoreCase(sts))
	    {
		strUpdQry = "UPDATE  XH_COMM_PROCESS SET " +
		"  PROCESS_STATUS = '"+sts+"', LAST_OUTBOUND_RETRIES = "+cnt+								
		"  WHERE PROCESS_ID="+intProcessId+" AND APPLICATION_ID = '"+strApplicationId+"'";
	    }

	    stmt.executeUpdate(strUpdQry);

	    connDB.commit();
	    stmt.close();
	}
		catch(Exception exceptionQry) {
			rollback();
			common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:updateProcessStatus) "+exceptionQry+"\n" );
			checkDBConnection();
		}
	}

	public void updateProcessStatus(String sts,int cnt)
	{
		try {
			String directUpdate = CommonUtil.getPropertyVal(InterfaceUtil.getiniFilePath("CONFIG"), "PROC_STATUS_DIRECT_UPDATE");
			if(directUpdate == null || directUpdate.equals("") || directUpdate.equals("N")) {
				updateProcessStatusProc(sts, cnt);
			}
			else {
				updateProcessStatusDirect(sts, cnt);
			}
		}
		catch(Exception exp) {
			common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:updateProcessStatus) " + exp + "\n");
		}
		
	}
    
    private void updateProcessStatusProc(String sts, int cnt) 
    {
    	String strErrorText = "";
    	CallableStatement cstmt = null;
    	try
	{
			cstmt = connDB.prepareCall("{ CALL xhcore.UPDATE_COMM_PROCESS(?,?,?,?,?,?,?,?) }");
			cstmt.setInt(1, intProcessId);
			cstmt.setString(2, strFacilityId);
			cstmt.setInt(3, cnt);
			cstmt.setString(4, getSentMessageId());
			cstmt.setInt(5, 0);
			cstmt.setInt(6, 0);
			cstmt.setString(7, sts);
			cstmt.registerOutParameter(8, java.sql.Types.VARCHAR);
			cstmt.execute();
	    	strErrorText = cstmt.getString(8);
	    	
	    	if(strErrorText == null || strErrorText.equals("")) {
	    		commit();
	    	}
	    	else {
	    		common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:updateProcessStatusProc) strErrorText " + strErrorText + "\n");
	    rollback();
	    	}
		}
		catch(Exception exceptionQry) {
			rollback();
			common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:updateProcessStatusProc) "+exceptionQry+"\n" );
			common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionQry) + "\n");
	    checkDBConnection();
	}
    }
    public void s()
    {
	System.out.println(" strApplicationId = "+strApplicationId );
	System.out.println(" strFacilityId = "+strFacilityId );
	System.out.println(" intProcessId = "+intProcessId);
	System.out.println(" strProcessType = "+strProcessType);
	System.out.println(" strSentMessageId = "+strSentMessageId);
	System.out.println(" strSentAckType = "+strSentAckType);
	System.out.println(" strSentEventType ="+strSentEventType);
	System.out.println(" strCommStartTime = "+strCommStartTime);
	System.out.println(" SentMessageLength = "+intSentMessageLength );
    }

    public synchronized void processAcknowledgement(String msg)
    {
    	strReceiveAckMessageId = "0";
    	strReceiveAckCode = "0";
    	String strErrorText = "0";
    	String strProcedureName = "{"+ strPackageName+"create_lob(?,?)"+"}";
    
    	OracleCallableStatement call1 = null;
    	OracleCallableStatement  call2 = null;
    
    	try
    	{
    		if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:processAcknowledgement) \n");
    	    //new MessageLogFile(msg , clientParameters.strOutboundLog,clientParameters.intWrite);
    	    boolCanSend = true;
    	    call1 =(OracleCallableStatement) connDB.prepareCall(strProcedureName);
    	    call1.registerOutParameter(1,java.sql.Types.CLOB);
    	    call1.registerOutParameter(2,java.sql.Types.VARCHAR);
    	    call1.execute ();
    	    strErrorText = call1.getString(2);
    	    CLOB clobMessage = null;
    
    	    if (strErrorText == null) 
    	    {
    	    	clobMessage = (oracle.sql.CLOB) call1.getClob(1) ;
    	    }
    	    else
    	    {
        		call1.close();        		
        		common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:processAcknowledgement) thrown Exception(procesAcknowledge call failed\n " ) ;
        		throw new Exception(" processAcknowledge call failed  : "+strErrorText);	
    	    }
    	    Writer outstream = clobMessage.getCharacterOutputStream();
    	    outstream.write(msg.toCharArray());
    	    outstream.close();
    	    call1.close();
    	    strErrorText = null;	
    
    	    /********** 11 Parameters **************************************/
    	    
    	    if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:processAcknowledgement) strApplicationId ::: "+ strApplicationId + " strFacilityId ::: "+ strFacilityId +" intProcessId ::: "+ intProcessId +"\n");
    	    if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:processAcknowledgement) clobMessage ::: "+ clobMessage + " strModuleId ::: "+ strModuleId +" strProtocalLinkId ::: "+ strProtocalLinkId +"\n");
    
    	    if(clientParameters.logToFile)
    	    {
    	    	common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:processAcknowledgement) Application ID ["
    														+strApplicationId+"] Facility ID ["
    														+strFacilityId+"] Module ID ["
    														+strModuleId+"] Protocol Link ID ["
    														+strProtocalLinkId+"]\n" ) ;		
    	    }
    
    	    strProcedureName = "{"+ strPackageName+"process_ack_message(?,?,?,?,?,?,?,?,?)"+"}";
    	    call2 =(OracleCallableStatement) connDB.prepareCall(strProcedureName);
    	    call2.setString(1,strApplicationId);
    	    call2.setString(2,strFacilityId);
    	    call2.setInt(3,intProcessId);
    	    call2.setClob(4,clobMessage);	;	// Setting the clob Variable		
    	    call2.setString(5,strModuleId);
    	    call2.setString(6,strProtocalLinkId);
    
    	    call2.registerOutParameter(7,java.sql.Types.VARCHAR);
    	    call2.registerOutParameter(8,java.sql.Types.VARCHAR);
    	    call2.registerOutParameter(9,java.sql.Types.VARCHAR);
    	    
    	    
    
    	    call2.execute();
    	    strErrorText = call2.getString(9);

    //	    if(clientParameters.logToFile && (strErrorText != null)) common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:processAcknowledgement) process_ack_message(strErrorText):"+strErrorText+"\n" ) ;
    	    if(strErrorText != null) common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:processAcknowledgement) process_ack_message(strErrorText):"+strErrorText+"\n" ) ;
    
    	    if (strErrorText == null) connDB.commit();
    	    else connDB.rollback();		
    
    	    strReceiveAckCode = call2.getString(8);
    	    strReceiveAckMessageId = call2.getString(7);
    	    
    	    if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:processAcknowledgement) strErrorText ::: "+ strErrorText + " strReceiveAckCode ::: "+ strReceiveAckCode +" strReceiveAckMessageId ::: "+ strReceiveAckMessageId +"\n");
    
    	    call2.close();
    	    if ((strSentAckType != null) && (strSentAckType.equals(strStandardAckTypeALWAYS) ||
            		    strSentAckType.equals(strStandardAckTypeSUCCESS) ||
            		    strSentAckType.equals(strStandardAckTypeERROR)))
    	    {
    	    	checkAcknowledgement();
    	    }
    	}
    	catch(SQLException exceptionSQL)
    	{
    	    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:processAcknowledgement) "+exceptionSQL+"\n" );
    	    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionSQL) + "\n");
    	    checkDBConnection();
    	}
    	catch(Exception exceptionQry)
    	{
    	    rollback();
    
    	    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:processAcknowledgement) "+exceptionQry+"\n" );
    	    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionQry) + "\n");
    	    checkDBConnection();
    	}
    	finally
    	{
    	    try
    	    {
        		if(call1 != null) call1.close();
        		if(call2 != null) call2.close();
    	    }
    	    catch(Exception exception)
    	    {
    	    	common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:processAcknowledgement-closing instance) "+exception+"\n" );
    	    }
    	}

    }

    public void commit()
    {
	try
	{
	    connDB.commit();
	}
	catch(Exception exceptionCommitDB)
	{
	    checkDBConnection();
	    //System.out.println(" Database connection  OutboundClientDBInteraction.closeDBconn() "+exceptionCommitDB);
	}
    }

    public void rollback()
    {
	try
	{
	    if(!clientParameters.boolDBDown) connDB.rollback();
	}
	catch(Exception exceptionCommitDB)
	{
	    checkDBConnection();
	}
    }
    public synchronized void registerError(String caller,String error)
    {
	String strProcedureName = "{"+ strErrorPackageName+"register_error(?,?,?,?,?,?)"+"}";
	try
	{
	    connDB.rollback();
	    strTotalParam = " strApplicationId ="+ strApplicationId+
	    " intProcessId = "+intProcessId+
	    " strProcessType = "+strProcessType+
	    " strSentMessageId ="+ strSentMessageId+
	    " strSentAckType ="+ strSentAckType+
	    " strSentEventType ="+ strSentEventType+
	    " strCommStartTime ="+strCommStartTime+
	    " strProcessEndTime ="+strProcessEndTime+
	    " boolCanSend = "+boolCanSend+
	    " boolCanStop = "+boolCanStop;

	    OracleCallableStatement call =(OracleCallableStatement) connDB.prepareCall(strProcedureName);
	    call.setString(1,strFacilityId);
	    call.setString(2,"XHTQUERY");
	    call.setString(3,caller);
	    call.setString(4,error);
	    call.setString(5,error);
	    call.setString(6,strTotalParam);
	    call.execute();
	    connDB.commit();
	    call.close();	
	}
	catch (Exception exception)
	{
	    checkDBConnection();
	}
    }

    public synchronized void checkAcknowledgement()
    {
	try
	{
	    /********************************************************
			if (strSentMessageId.equals(strReceiveAckMessageId) && strReceiveAckCode.equals("A"))
			{
				boolCanSend = true;
			}
			else
			{
				boolCanSend = false;		
			}
	     **********************************************************/
	    boolCanSend = true;

	    //boolCanSend = false ;
	}
	catch (Exception exceptionGeneral)
	{

	    //common.fileOutput( clientParameters.strExceptionLogFile, "(OutboundClientDBInteraction:checkAcknowledgement) Exception:"+exceptionGeneral+"\n " ) ;
	    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:checkAcknowledgement) Exception:"+exceptionGeneral+"\n " ) ;
	    checkDBConnection();
	}
    }// End checkAcknowledgement()

    public synchronized String fileNamingConvention(String procedurename)
    {	
	//	String strProcedureName = "{"+ strErrorPackageName+" "+procedurename+"(?)}";
	//	String strProcedureName = "{? = call "+ strErrorPackageName+"XH_TEST1}";
	String query = "select "+procedurename+" from dual";		
	String fileformat="";

	ResultSet rset = null;
	Statement stmt = null;

	try
	{
	    //		OracleCallableStatement call =(OracleCallableStatement) connDB.prepareCall(strProcedureName);
	    //		call.registerOutParameter(1,OracleTypes.CURSOR);
	    //		call.executeUpdate();
	    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:fileNamingConvention)\n " ) ;
	    stmt = connDB.createStatement();			
	    rset = stmt.executeQuery(query);
	    if(rset.next())
	    {
		fileformat = rset.getString(1);			
	    }
	    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:fileNamingConvention)File Name "+fileformat+"\n " ) ;
	    connDB.commit();
	    //		call.close();
	    stmt.close();
	}
	catch (Exception exception)
	{
	    checkDBConnection();
	    common.fileOutput( clientParameters.strExceptionLogFile, "(OutboundClientDBInteraction:fileNamingConvention) Exception:"+exception+"\n " ) ;
	    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exception) + "\n");
	    System.out.println("Exception in fileNamingConvention "+exception);
	}
	finally
	{
	    closeResource(rset, stmt);			
	}	
	return 	fileformat;

    }

    //	public synchronized String fileNamingConvention(String procedurename)
    //	{
    //		String strProcedureName = "{"+ strErrorPackageName+" "+procedurename+"(?)"+"}";
    //		String filenaming="";
    //		try
    //		{
    //		OracleCallableStatement call =(OracleCallableStatement) connDB.prepareCall(strProcedureName);
    //		call.registerOutParameter(1,java.sql.Types.VARCHAR);
    //		call.execute();
    //		filenaming = call.getString(1);
    //		connDB.commit();
    //		call.close();	
    //	}
    //	catch (Exception exception)
    //	{
    //        checkDBConnection();
    //	} 
    //		return filenaming;
    //	}// fileNamingConvention(String procedurename)

    /**
     * Method to retrieve the Message delimiters
     */
    public void getMessageDelimiters(OutboundClientParameters clientParameters)
    {		
		String sqlProcedure = "{ call " + strStandardPackage + "XH_STANDARD_SPECIAL_CHAR(?,?,?,?,?,?,?) }";
		OracleCallableStatement callableStatement = null;
		try
		{
			callableStatement = (OracleCallableStatement) connDB.prepareCall(sqlProcedure);
	
		    callableStatement.setString(1,clientParameters.strProtocalLinkId);
		    callableStatement.registerOutParameter(2,java.sql.Types.VARCHAR);
		    callableStatement.registerOutParameter(3,java.sql.Types.VARCHAR);
		    callableStatement.registerOutParameter(4,java.sql.Types.VARCHAR);
		    callableStatement.registerOutParameter(5,java.sql.Types.VARCHAR);
		    callableStatement.registerOutParameter(6,java.sql.Types.VARCHAR);
		    callableStatement.registerOutParameter(7,java.sql.Types.VARCHAR);
		    callableStatement.execute();
				
		    clientParameters.messageStart = callableStatement.getString(2);
		    clientParameters.messageEnd = callableStatement.getString(3);
		    clientParameters.messageSegmentStart = callableStatement.getString(4);
		    clientParameters.messageSegmentEnd = callableStatement.getString(5);
		    clientParameters.standardCode = callableStatement.getString(7);
		    clientParameters.fieldSeparator = callableStatement.getString(6);
	
		    if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getMessageDelimiters) Start "+clientParameters.messageStart+"\n" ) ;	
		    if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getMessageDelimiters) End "+clientParameters.messageEnd+"\n" ) ;	
		    if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getMessageDelimiters) Segment Start "+clientParameters.messageSegmentStart+"\n" ) ;	
		    if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getMessageDelimiters) Segment End "+clientParameters.messageSegmentEnd+"\n" ) ;	
		    if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getMessageDelimiters) Field Separator "+clientParameters.fieldSeparator+"\n" ) ;	
		}
		catch(Exception exception)
		{
		    common.fileOutput( clientParameters.strExceptionLogFile, "(OutboundServerDBInteraction:getMessageDelimiters)Exception:- "+exception+"\n" ) ;
		    checkDBConnection();
		}
		finally {
			SQLUtil.closeStatement(callableStatement);
		}
    }

    //method to retrieve file control structures
    public String getFileControlSrtucture(String control)
    {
	if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getFileControlSrtucture)\n" ) ;

	String controlMessage = null;
	String sqlProcedure = "{ call "+strGenericPackage+"GET_FILE_HEADER_FOOTER_TEXT(?,?,?,?,?) }";

	OracleCallableStatement callableStatement = null;
	try
	{
	    callableStatement = (OracleCallableStatement)connDB.prepareCall(sqlProcedure);			
	    callableStatement.setString(1,clientParameters.strProtocalLinkId);	
	    callableStatement.setString(2,control);
	    callableStatement.registerOutParameter(3,java.sql.Types.VARCHAR);
	    callableStatement.registerOutParameter(4,java.sql.Types.NUMERIC);
	    callableStatement.registerOutParameter(5,java.sql.Types.VARCHAR);

	    callableStatement.execute();

	    String errorText = callableStatement.getString(5);
	    if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getFileControlSrtucture)ErrorText"+errorText+"\n" ) ;
	    if(errorText == null)
	    {
		controlMessage = callableStatement.getString(3);
		if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getFileControlSrtucture)"+controlMessage+"\n" ) ;
	    }			
	}
	catch(Exception exception)
	{
	    common.fileOutput( clientParameters.strExceptionLogFile, "(OutboundServerDBInteraction:getFileControlSrtucture)Exception:- "+exception+"\n" ) ;			
	    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exception) + "\n");
	    checkDBConnection();
	}
	finally
	{
	    try{
		callableStatement.close();
	    }
	    catch(Exception exception)
	    {

	    }
	}
	return controlMessage;
    }

    /**
     * Method fetches load level, used in processing message for ODBC Communication
     */
    public String getLoadLevel()
    {
	Statement stmt = null;
	ResultSet rs = null;

	String loalLevel = null;
	String query = "SELECT load_level FROM xh_application_event_type "+
	"WHERE application_id = '"+ strApplicationId +"' AND event_type = '"+ strSentEventType +"'";

	try
	{
	    stmt = connDB.createStatement();
	    rs = stmt.executeQuery(query);
	    if(rs.next())
	    {
		loalLevel = rs.getString("load_level");
	    }
	}
	catch (Exception exp) {
	    common.fileOutput( clientParameters.strExceptionLogFile, "(OutboundServerDBInteraction:getLoadLevel) Exception:- "+exp+"\n" ) ;			
	    common.fileOutput( clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp)+"\n" ) ;
	    checkDBConnection();
	}
	finally
	{
	    closeResource(rs, stmt);					
	}

	return loalLevel;
    }

    /**
     * Method fetches repeat segment, used in processing message for ODBC Communication
     */
    public String getRepeatSegment()
    {
	Statement stmt = null;
	ResultSet rs = null;

	String repeatSegment = null;
	String query = "SELECT repeat_segment FROM xh_inbound_header "+
	"WHERE application_id = '"+ strApplicationId +"' AND event_type = '"+ strSentEventType +
	"' AND segment_id = 'ALL'";

	try
	{
	    stmt = connDB.createStatement();
	    rs = stmt.executeQuery(query);
	    if(rs.next())
	    {
		repeatSegment = rs.getString("repeat_segment");
	    }
	}
	catch (Exception exp) {
	    common.fileOutput( clientParameters.strExceptionLogFile, "(OutboundServerDBInteraction:getRepeatSegment) Exception:- "+exp+"\n" ) ;			
	    common.fileOutput( clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp)+"\n" ) ;
	    checkDBConnection();
	}
	finally
	{
	    closeResource(rs, stmt);			
	}

	return repeatSegment;
    }

    /**
     * Method fetches system defined string for the segment, used in ODBC Communication
     */
    public ArrayList getSysDefString(String segmentID)
    {
	Statement stmt = null;
	ResultSet rs = null;
	ArrayList list = null;

	String query = "SELECT posting_api_signature, posting_api_code FROM xh_event_segment_config WHERE "+					
	"config_name = '"+segmentID+"' AND PROFILE_ID = '"+clientParameters.profileID+"'";

	try
	{				
	    stmt = connDB.createStatement();
	    rs = stmt.executeQuery(query);
	    if(rs.next())
	    {	
		String apiSignature = rs.getString("posting_api_signature");
		String apiCode = rs.getString("posting_api_code");

		if(apiSignature != null && !apiSignature.equals("") 
			&& apiCode != null && !apiCode.equals(""))
		{
		    list = new ArrayList();

		    list.add(apiSignature);				
		    list.add(apiCode);				
		}
	    }
	}
	catch (Exception exp) {
	    common.fileOutput( clientParameters.strExceptionLogFile, "(OutboundServerDBInteraction:getRepeatSegment) Exception:- "+exp+"\n" ) ;			
	    common.fileOutput( clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp)+"\n" );
	    checkDBConnection();
	}
	finally
	{
	    closeResource(rs, stmt);				
	}

	return list;
    }

    /**
     * Method used in ODBC communication to update the status and the status text after executing the API in external DB.
     */
    public synchronized void updateMessageStatus(int commRetries,int totalMessages,String msgSts,String initBy,String statusText)
    {
		String strErrorText = "0";
	
		try
		{
		    String strProcedureName = "{ call "+ clientParameters.strCommStatistics +"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		    
		    if(strApplicationId.equals("EPABXO")) strProcedureName = "{ call "+ clientParameters.strCommStatistics +"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"+"}";
	
		    if(clientParameters.logToFile)
		    {
		    	String tempLogStmt = "Application ID[" + strApplicationId + "]" +
		    							"FacilityID[" + strFacilityId + "]" +
		    							"SentEventType[" + strSentEventType + "]" +
		    							"ProcessID[" + intProcessId + "]" +
		    							"ModuleID[" + strModuleId + "]" +
		    							"SentMessageLength[" + intSentMessageLength + "]" +
		    							"MsgStatus[" + msgSts + "]" +
		    							"ProtocalLinkID[" + strProtocalLinkId + "]" +
		    							"CommStartTime[" + strCommStartTime + "]";
	
				common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:updateMessageStatus) " + tempLogStmt + "\n");
		    }
		    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:updateMessageStatus) Updating Status for MSG ID: "+strSentMessageId+"\n" ) ;
		    OracleCallableStatement  call = (OracleCallableStatement) connDB.prepareCall(strProcedureName);
		    call.setString(1,strApplicationId);
		    call.setString(2,strFacilityId);
		    call.setString(3,strSentMessageId);
		    call.setString(4,strSentEventType);
		    call.setInt(5,intProcessId);
		    call.setString(6,strModuleId); 
		    call.setInt(7,intSentMessageLength);
		    call.setString(8,strCommStartTime);
		    call.setInt(10,commRetries);
		    call.setInt(11,totalMessages);
		    call.setString(12,msgSts);	// Status
		    call.setString(13,initBy);	// Who initated -- sender
		    call.registerOutParameter(16,java.sql.Types.VARCHAR);
		    call.registerOutParameter(9,java.sql.Types.VARCHAR);// Communication End Time			
		    call.setString(14,"");
		    call.setString(15,strProtocalLinkId);
		    
		    call.setString(17,statusText);			
	
		    call.execute ();
		    strErrorText = call.getString(16);
	
		    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:updateMessageStatus) strErrorText "+strErrorText+"\n" ) ;
		    if (strErrorText == null || strErrorText.equals("") ) {					
		    	connDB.commit();
		    }
		    else {			
		    	connDB.rollback();
		    }
	
		    if("Y".equals(clientParameters.isQueueEnabled))
		    {
				messageBufferMap.remove(strSentMessageId);
				if(clientParameters.logToFile && clientParameters.debugYN) common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:updateApplicationMessageStatus) Removing "+strSentMessageId+" from buffer\n" ) ;
		    }
	
		    strProcessEndTime = call.getString(9);
		    call.close();
		}
		catch(SQLException exceptionSQL) {			
		    common.fileOutput( clientParameters.strExceptionLogFile, "(OutboundClientDBInteraction:updateMessageStatus)SQLException:"+exceptionSQL+"\n" ) ;	
		    checkDBConnection();
		}
		catch(Exception exceptionQry) {
		    rollback();
		    common.fileOutput( clientParameters.strExceptionLogFile, "(OutboundClientDBInteraction:updateMessageStatus)Exception:"+exceptionQry+"\n" ) ;	
		    checkDBConnection();
		}
    }

    /**
     * Method to get any external database connection. Used mainly for ODBC Communication
     */
    public Connection getExternalDBConnection()
    {
	boolean dbStatus = false;
	externalDBConn = null;

	try
	{
	    Class.forName(clientParameters.odbcDBDriver);
	    externalDBConn = DriverManager.getConnection(clientParameters.odbcDBURL, clientParameters.odbcDBUserID, clientParameters.odbcDBPwd);
	    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getExternalDBConnection) External DB Conn Successful...\n" );
	    externalDBConn.setAutoCommit(false);
	    //	setExtMedUserRole(); // Temporary Code. Has to be removed.
	    dbStatus = true;			
	}
	catch(Exception exp) {
	    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getExternalDBConnection) External DB Conn failed...\n" );
	    common.fileOutput( clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp)+"\n" ) ;
	}
	return externalDBConn;
    }

    public void closeExtDBConn()
    {
	try
	{
	    if(externalDBConn != null)
	    {
		externalDBConn.commit();
		externalDBConn.close();
	    }
	}
	catch(Exception exceptionCloseDB) {
	    System.out.println("(InboundServerDBInteraction:closeExtDBconn)Exception "+exceptionCloseDB);
	}
    }

    public void updateProcessComStatus(String flag)
    {
    	updateProcessComStatus(flag, "");
    }

    /**
     * Method updates communication status. 
     * Flag will be updated whenever any new communication will be started or existing one is stopped.
     */
    public void updateProcessComStatus(String flag, String statusMessage)
    {
	PreparedStatement pstmt = null;
		String qryWithComStsMsg = "UPDATE xh_comm_process SET comm_status = ?, comm_status_message = ? WHERE process_id = ?";
		String qryWithoutComStsMsg = "UPDATE xh_comm_process SET comm_status = ? WHERE process_id = ?";

	try
	{
			if(statusMessage == null || statusMessage.equals("")) {
				pstmt = connDB.prepareStatement(qryWithoutComStsMsg);
	    pstmt.setString(1, flag);
	    pstmt.setInt(2, intProcessId);
			}
			else {
				pstmt = connDB.prepareStatement(qryWithComStsMsg);
			    pstmt.setString(1, flag);
			    pstmt.setString(2, statusMessage);
			    pstmt.setInt(3, intProcessId);
			}

	    int i = pstmt.executeUpdate();

	    if(i <= 0) common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:updateProcessComStatus) Failed to update Communication Status...\n");
	    else 
	    {
		common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:updateProcessComStatus) Updated Communication Status...\n");
		connDB.commit();
	    }
	}
	catch (Exception exp) {
	    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
	    checkDBConnection();
	}
	finally {
	    closeResource(null, pstmt);
	}
    }

    /**
     * Static method used to close any database resource.
     * Used in most of the outbound database transactions.
     */
    public static void closeResource(ResultSet rs, Statement ps)
    {
	try {
	    if(rs != null) rs.close();
	    if(ps != null) 
	    {
		ps.close();				
	    }
	}
	catch(Exception exp) {
	    System.out.println("Close Resources "+exp);
	}										
    }

    /**
     * Method fetches the field delimited format based on the segment name from xb_dbf_gen_param
     */
    public String[] getDBFSegmentDtls(String segName, String eventType)
    {
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String qry = "SELECT dbf_table_name,delimit_field_spec FROM xb_dbf_gen_param WHERE segment = ? AND event_type = ? AND profile_id = ? AND application_id = ? AND segment IN (SELECT segment_type FROM xh_event_type_segment WHERE event_type = ? AND in_use_yn = 'Y')";
	String [] dtlsArray = null;

	try
	{
	    pstmt = connDB.prepareStatement(qry);
	    pstmt.setString(1, segName);
	    pstmt.setString(2, eventType);
	    pstmt.setString(3, clientParameters.profileID);
	    pstmt.setString(4, strApplicationId);
	    pstmt.setString(5, eventType);

	    rs = pstmt.executeQuery();

	    if(rs.next()) 
	    {
		dtlsArray = new String[2];
		dtlsArray[0] = rs.getString("dbf_table_name");
		dtlsArray[1] = rs.getString("delimit_field_spec");
	    }			
	}
	catch (Exception exp) {
	    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
	    checkDBConnection();
	}
	finally {
	    closeResource(rs, pstmt);
	}

	return dtlsArray;
    }

    /**
     * Method fetches the table/file details based on the segment/event name from xb_dbf_gen_param
     */
    public HashMap<String,String> dbfGenParamTabDtls(String eventType)
    {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	HashMap<String,String> tabDtls = null;

	String qry = "SELECT dbf_table_name,segment,delimit_field_spec FROM xb_dbf_gen_param WHERE event_type = ? AND profile_id = ? AND application_id = ? AND segment IN (SELECT segment_type FROM xh_event_type_segment WHERE event_type = ? AND in_use_yn = 'Y')";		

	try
	{
	    pstmt = connDB.prepareStatement(qry);			
	    pstmt.setString(1, eventType);
	    pstmt.setString(2, clientParameters.profileID);
	    pstmt.setString(3, strApplicationId);
	    pstmt.setString(4, eventType);

	    rs = pstmt.executeQuery();

	    if(rs.next()) 
	    {
		tabDtls = new HashMap<String,String>();
		tabDtls.put(rs.getString("segment"), rs.getString("dbf_table_name"));
		tabDtls.put(rs.getString("segment") + "_Header", rs.getString("delimit_field_spec"));
	    }

	    while(rs.next())
	    {
		tabDtls.put(rs.getString("segment"), rs.getString("dbf_table_name"));
		tabDtls.put(rs.getString("segment") + "_Header", rs.getString("delimit_field_spec"));
	    }
	}
	catch (Exception exp) {
	    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
	    checkDBConnection();
	}
	finally {
	    closeResource(rs, pstmt);
	}

	return tabDtls;
    }

    /**
     * Executes the given sequnce and returns the retrieved value.
     */
    public String executeSeq(String seqName)
    {
	Statement stmt = null;
	ResultSet rs = null;

	String retVal = null;

	try {
	    String qry = "SELECT " + seqName + ".nextval FROM dual";
	    stmt = connDB.createStatement();
	    rs = stmt.executeQuery(qry);

	    if(rs.next()) retVal = rs.getString(1);
	}
	catch (Exception exp) {
	    common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp) + "\n");
	    checkDBConnection();
	}
	finally {
	    closeResource(rs, stmt);			
	}
	return retVal;
    }

    /**
     * Method used in billing related transactions.
     * Every time a new file is created, this method will be called for updating the appropriate filename.
     */
    public void insertProcessedFilename(String fileName)
    {
	PreparedStatement pstmt = null;

	String qry = "INSERT INTO xb_sent_reply_file_dtl ("
	    + "EVENT_TYPE, SENT_FILE_ID, SENT_DATE, CSMBS, REPLY_FILE_ID, REPLY_DATE, "
	    + "ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) "
	    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	try
	{
	    java.util.Date comStartTime = CommonUtil.convertToDate(strCommStartTime, "dd/MM/yy-hh:mm:ss");
	    java.sql.Date sqlComStartTime = new java.sql.Date(comStartTime.getTime());
	    pstmt = connDB.prepareStatement(qry);
	    pstmt.setString(1, strSentEventType);
	    pstmt.setString(2, fileName);
	    pstmt.setDate(3, sqlComStartTime);
	    pstmt.setString(4, "");
	    pstmt.setString(5, "");
	    pstmt.setString(6, "");
	    pstmt.setString(7, strOrclUserId);
	    pstmt.setDate(8, sqlComStartTime);
	    pstmt.setString(9, clientParameters.machineName);
	    pstmt.setString(10, "XX");
	    pstmt.setString(11, strOrclUserId);
	    pstmt.setDate(12, sqlComStartTime);
	    pstmt.setString(13, clientParameters.machineName);
	    pstmt.setString(14, "XX");

	    int i = pstmt.executeUpdate();

	    if(i <= 0) common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:insertProcessedFilename) Failed to insert filename...\n"); 
	}
	catch (Exception exp) {
	    common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp) + "\n");
	    checkDBConnection();
	}
	finally {
	    closeResource(null, pstmt);
	}
    }

    /**
     * Method used in billing related transactions.
     * Every time a new file is created, this method will be called for updating the appropriate filename.
     */
    public void storeBillingFilename(String eventType, String fileID)
    {
	PreparedStatement pstmt = null;
	String qry = "UPDATE xb_sent_file_dtls SET sent_file_id = ? WHERE operating_facility_id = ? AND doc_ref_num = ?";

	try
	{
	    String accessionNoParams [] = clientParameters.accessionNo.split("\\$\\!\\^");
	    pstmt = connDB.prepareStatement(qry);
	    pstmt.setString(1, fileID);
	    pstmt.setString(2, accessionNoParams[0]);
	    pstmt.setString(3, accessionNoParams[1]);

	    int i = pstmt.executeUpdate();			

	    if(i <= 0) common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:storeBillingFilename) Failed to update filename...\n"); 
	    else connDB.commit();
	}
	catch (Exception exp) {
	    common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp) + "\n");
	    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:storeBillingFilename) Exception: "+ exp +"\n");
	    checkDBConnection();
	}
	finally {
	    closeResource(null, pstmt);			
	}
    }

    /**
     * Method used in billing related transactions.
     * Every time a new file is created, this method will be called for updating billing table with the appropriate filename.
     */
    public void updateBillingTab(String eventType, String fileID)
    {
	PreparedStatement updStmt = null;
	String updBLTab = "UPDATE bl_cust_dispatch_let_header SET sent_file_event_type = ?, sent_file_id = ?, sent_file_date = ? WHERE operating_facility_id = ? AND doc_ref_num = ?";

	try
	{
	    if("Y".equalsIgnoreCase(clientParameters.isQueueEnabled))
	    {
		String accessionNoParams [] = clientParameters.accessionNo.split("\\$\\!\\^");			
		if(eventType == null || eventType.trim().equals("")) eventType = strSentEventType;

		updStmt = connDB.prepareStatement(updBLTab);

		updStmt.setString(1, eventType);
		updStmt.setString(2, fileID);
		updStmt.setTimestamp(3, billingSentFileDate);
		updStmt.setString(4, accessionNoParams[0]);
		updStmt.setString(5, accessionNoParams[1]);

		int i = updStmt.executeUpdate();

		if(i <= 0 && !"SKREBLP1".equals(clientParameters.strProtocolId)) 
		{
		    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:updateBillingTab) Failed to insert filename...\n"); 
		    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:updateBillingTab) Accession Number: "+ clientParameters.accessionNo +"\n"); 
		}
		else connDB.commit();
	    }
	}
	catch (Exception exp) {
	    common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp) + "\n");
	    checkDBConnection();
	}
	finally {
	    closeResource(null, updStmt);
	}
    }

    public ArrayList getEventSegmentList(String eventType)
    {
	ArrayList<String> segmentList = null;

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String qry = "SELECT segment_type FROM xh_event_type_segment WHERE event_type = ?";

	try
	{
	    pstmt = connDB.prepareStatement(qry);
	    pstmt.setString(1, eventType);

	    rs = pstmt.executeQuery();

	    segmentList = new ArrayList<String>();

	    while(rs.next()) 
	    {
		segmentList.add(rs.getString("segment_type"));
	    }
	}
	catch (Exception exp)
	{
	    common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp) + "\n");
	    checkDBConnection();
	}
	finally {
	    closeResource(rs, pstmt);
	}
	return segmentList;
    }

    public BLOB createEmptyBlob() throws Exception
    {
	String strProcedureName = "{"+ strPackageName+"create_blob(?,?)"+"}";
	OracleCallableStatement call1 = null;

	call1 = (OracleCallableStatement) connDB.prepareCall(strProcedureName);

	call1.registerOutParameter(1,java.sql.Types.BLOB);
	call1.registerOutParameter(2,java.sql.Types.VARCHAR);
	call1.execute ();		
	BLOB blob = null;


	blob = (oracle.sql.BLOB) call1.getBlob(1) ;

	return blob;
    }

    public String[] getHTTPDtls(String message) 
    {
	String [] httpDtls = new String[1];
	CallableStatement  cstmt = null;		
	String strProcedureName = "{ call xhnotify.Get_HTTP_Attributes(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	try
	{
	    cstmt = (OracleCallableStatement) connDB.prepareCall(strProcedureName);
	    cstmt.setClob(1,CommonUtil.convertStrToClob(message, connDB));
	    cstmt.setString(2,clientParameters.strProtocalLinkId);
	    cstmt.setString(3,strSentEventType);
	    cstmt.registerOutParameter(4,java.sql.Types.CLOB);
	    cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
	    cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
	    cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
	    cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
	    cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
	    cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
	    cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
	    cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
	    cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
	    cstmt.registerOutParameter(14,java.sql.Types.CLOB);

	    cstmt.execute();
	    httpDtls[0] = cstmt.getString(4);
	    clientParameters.url = cstmt.getString(14);
	}
	catch(Exception exp)
	{
	    common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp) + "\n");
	}
	finally
	{
	    CommonUtil.closeDBResources(null, cstmt, null);
	}

	return httpDtls;
    }

    public String[] getSMTPDtls(String message) 
    {
	String [] smtpDtls = new String[10];
	CallableStatement  cstmt = null;		
	String strProcedureName = "{ call xhnotify.GET_SMTP_ATTRIBUTES(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	try
	{
	    cstmt = (OracleCallableStatement) connDB.prepareCall(strProcedureName);
	    cstmt.setClob(1,CommonUtil.convertStrToClob(message, connDB));
	    cstmt.setString(2,clientParameters.strProtocalLinkId);
	    cstmt.setString(3,strSentEventType);			
	    cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
	    cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
	    cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
	    cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
	    cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
	    cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
	    cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
	    cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
	    cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
	    cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);	

	    cstmt.execute();
	    smtpDtls[0] = cstmt.getString(4);
	    smtpDtls[1] = cstmt.getString(5);
	    smtpDtls[2] = cstmt.getString(6);
	    smtpDtls[3] = cstmt.getString(7);
	    smtpDtls[4] = cstmt.getString(8);
	    smtpDtls[5] = cstmt.getString(9);
	    smtpDtls[6] = cstmt.getString(10);
	    smtpDtls[7] = cstmt.getString(11);
	    smtpDtls[8] = cstmt.getString(12);
	    smtpDtls[9] = cstmt.getString(13);
	}
	catch(Exception exp)
	{
	    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getSMTPDtls) Exception: "+exp.getMessage()+"\n" );
	    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
	}
	finally
	{
	    CommonUtil.closeDBResources(null, cstmt, null);
	}

	return smtpDtls;
    }

    /**
     * Executes the given query which queries only one column and returns the retrieved values as list.
     */
    public List<String> exeSingleColQry(String qry)
    {
    	Statement stmt = null;
    	ResultSet rs = null;
    
    	List<String> retList = new ArrayList<String>();
    
    	try 
    	{
    	    stmt = connDB.createStatement();
    	    rs = stmt.executeQuery(qry);
    
    	    while(rs.next()) retList.add(rs.getString(1));
    	}
    	catch (Exception exp) {
    	    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
    	    checkDBConnection();
    	}
    	finally {
    	    closeResource(rs, stmt);			
    	}
    	return retList;
    }
    
    /**
     * Executes the given query.
     */
    public boolean executeQuery(String qry)
    {
    	Statement stmt = null;
    	boolean isSuccess = false;
    	try
    	{
    		common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getSMTPDtls) qry: "+qry+"\n" );
    	    stmt = connDB.createStatement();
    	    int i = stmt.executeUpdate(qry);
    	    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getSMTPDtls) i: "+i+"\n" );
    	    if(i > 0)
    	    {
    	    	isSuccess = true;
    	    	connDB.commit();
    	    }
    	    else connDB.rollback();
    	}
    	catch (Exception exp) 
    	{
    	    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
    	    checkDBConnection();
    	}
    	finally {
    		common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getSMTPDtls) qryewr "+isSuccess+"\n" );
    	    closeResource(null, stmt);			
    	}
    	return isSuccess;
    }
    
    public void exceptionUtil(Exception exp)
    {
    	common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
	    checkDBConnection();
    }
    
	/**
	 * Utility method used for closing the database resources
	 */
	public static void closeDBResources(ResultSet rs, Statement stmt) 
	{
		try {
			if (rs != null) rs.close();
		} 
		catch (Exception exp) {
		} finally {
			try {
				if (stmt != null) stmt.close();
			} 
			catch (Exception exp) {
			}
		}
	}
	
	public String getEventType() {
		return strSentEventType;
	}
	
	
	/**
     * Method to retrieve the soap web service params // Added by Sethu for ML-MMOH-CRF-0473
    */
	
    public void getWebServiceParams()
    {		
		String sqlProcedure = "{ call " + "XHGATEWAY." + "GET_WEBSERVICE_CONFIG(?,?,?,?,?,?,?,?) }";
		OracleCallableStatement callableStatement = null;
		try
		{
			callableStatement = (OracleCallableStatement) connDB.prepareCall(sqlProcedure);
	
		    callableStatement.setString(1,clientParameters.strProtocalLinkId);
		    callableStatement.registerOutParameter(2,java.sql.Types.VARCHAR);
		    callableStatement.registerOutParameter(3,java.sql.Types.VARCHAR);
		    callableStatement.registerOutParameter(4,java.sql.Types.VARCHAR);
		    callableStatement.registerOutParameter(5,java.sql.Types.VARCHAR);
		    callableStatement.registerOutParameter(6,java.sql.Types.VARCHAR);
		    callableStatement.registerOutParameter(7,java.sql.Types.VARCHAR);
		    callableStatement.registerOutParameter(8,java.sql.Types.CLOB);
		    callableStatement.execute();
				
		    clientParameters.httpUserAgent = callableStatement.getString(3);
		    clientParameters.httpContentType = callableStatement.getString(4);
		    clientParameters.httpTransferEncoding = callableStatement.getString(5);
		    clientParameters.httpSoapaction = callableStatement.getString(6);
		    clientParameters.httpContentLengthFlag = callableStatement.getInt(7);
		    clientParameters.httpSoapResponseXSL = callableStatement.getClob(8);
		    
	
		    if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getWebServiceParams) httpUserAgent "+clientParameters.httpUserAgent+"\n" ) ;	
		    if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getWebServiceParams) httpContentType "+clientParameters.httpContentType+"\n" ) ;	
		    if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getWebServiceParams) httpTransferEncoding "+clientParameters.httpTransferEncoding+"\n" ) ;	
		    if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getWebServiceParams) httpSoapaction "+clientParameters.httpSoapaction+"\n" ) ;	
		    if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getWebServiceParams) httpContentLengthFlag "+clientParameters.httpContentLengthFlag+"\n" ) ;	
		    if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getWebServiceParams) httpSoapResponseXSL "+clientParameters.httpSoapResponseXSL+"\n" ) ;
		}
		catch(Exception exception)
		{
		    common.fileOutput( clientParameters.strExceptionLogFile, "(OutboundServerDBInteraction:getWebServiceParams)Exception:- "+exception+"\n" ) ;
		    checkDBConnection();
		}
		finally {
			SQLUtil.closeStatement(callableStatement);
		}
    }
    
    
    /**
     * Method to store the whole response to SYS_DEF_MESSAGE_TEXT in xh_event or xb_event table // Added by Sethu for ML-MMOH-CRF-0473
    */
    /* PROCEDURE  UPDATE_EVENT_MESSAGE_TEXT( p_application_id        IN  VARCHAR2,
    p_message_id                    IN  VARCHAR2,                    
    p_facility_id                IN  VARCHAR2,
    p_module_id            IN  VARCHAR2,
    p_message_text            IN  CLOB,
    p_error_msg            OUT VARCHAR2); */
    public void updateEventMessageText(java.sql.Clob responseClob)
    {		

    	String sqlProcedure = "{ call " + "XHGATEWAY." + "UPDATE_EVENT_MESSAGE_TEXT(?, ?, ?, ?, ?, ?, ?) }";
		OracleCallableStatement callableStatement = null;
		String error_text = "";
		try
		{
	    	if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:updateEventMessageText) responseClob " + responseClob + " ::: responseClob.length "+responseClob.length()+"\n") ;
	    	
			callableStatement = (OracleCallableStatement) connDB.prepareCall(sqlProcedure);
	
		    callableStatement.setString(1,strApplicationId);
		    callableStatement.setString(2,strSentMessageId);
		    callableStatement.setString(3,strFacilityId);
		    callableStatement.setString(4,strModuleId);
		    callableStatement.setString(5,strProtocalLinkId);
		    callableStatement.setClob(6, responseClob);
		    callableStatement.registerOutParameter(7,java.sql.Types.VARCHAR);
		
		    callableStatement.execute();
		    
		    error_text = callableStatement.getString(7);
			if(error_text!="" && error_text!=null)	
			{
		     if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:updateEventMessageText) error_text "+error_text+"\n" ) ;
			}
		}
		catch(Exception exception)
		{
		    common.fileOutput( clientParameters.strExceptionLogFile, "(OutboundServerDBInteraction:updateEventMessageText)Exception:- "+exception+"\n" ) ;
		    checkDBConnection();
		}
		finally {
			SQLUtil.closeStatement(callableStatement);
		}
    }
    
    /**
     * Method to store the whole response to STATUS_TEXT in xh_application_message table // Added by Sethu for ML-MMOH-CRF-0473
    */   
    public void updateApplicationMessageText(java.sql.Clob responseClob)
    {		

    	String sqlProcedure = "{ call " + "XHGATEWAY." + "UPDATE_APPL_STATUS_TEXT(?, ?, ?, ?, ?, ?, ?) }";
		OracleCallableStatement callableStatement = null;
		String error_text = "";
		try
		{
	    	if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:updateApplicationMessageText) responseClob " + responseClob + " ::: responseClob.length "+responseClob.length()+"\n") ;
	    	
			callableStatement = (OracleCallableStatement) connDB.prepareCall(sqlProcedure);
	
		    callableStatement.setString(1,strApplicationId);
		    callableStatement.setString(2,strSentMessageId);
		    callableStatement.setString(3,strFacilityId);
		    callableStatement.setString(4,strModuleId);
		    callableStatement.setString(5,strProtocalLinkId);
		    callableStatement.setClob(6, responseClob);
		    callableStatement.registerOutParameter(7,java.sql.Types.VARCHAR);
		
		    callableStatement.execute();
		    
		    error_text = callableStatement.getString(7);
			if(error_text!="" && error_text!=null)	
			{
		     if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:updateApplicationMessageText) error_text "+error_text+"\n" ) ;
			}
		}
		catch(Exception exception)
		{
		    common.fileOutput( clientParameters.strExceptionLogFile, "(OutboundServerDBInteraction:updateApplicationMessageText)Exception:- "+exception+"\n" ) ;
		    checkDBConnection();
		}
		finally {
			SQLUtil.closeStatement(callableStatement);
		}
    }
    
    public java.sql.Clob stringToClob(String stringData) 
	{
    	
    	 if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:stringToClob) stringData.length "+stringData.length()+"\n" ) ;
	        
		java.sql.Clob clob = null;
	        try {
	        	
	            clob = CLOB.createTemporary(connDB, false, CLOB.DURATION_SESSION);
	            clob.setString(1, stringData);
	            
	            if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:stringToClob) clob.length "+clob.length()+"\n" ) ;
	        } catch (SQLException sqlException) {
	        	common.fileOutput( clientParameters.strExceptionLogFile, "(stringToClob) Exception:- "+sqlException+"\n" ) ;	            
	        }
	        
	        return clob;
	}
	
}