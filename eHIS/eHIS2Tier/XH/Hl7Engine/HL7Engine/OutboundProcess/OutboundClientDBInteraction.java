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

import java.util.*;
import java.io.*;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.SAXException;
import com.lowagie.text.DocumentException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.bind.DatatypeConverter;

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
    //Added by Sethu for NMC-JD-SCF-0194
    boolean connResetFlag = false;
    String lastSentMessageId = "0";

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
	{	//Added by Apoorva for KAUH-SCF-0366 starts here
		if(connDB != null && !connDB.isClosed()) {
            // Connection already exists
            return true;
        }
		//Added by Apoorva for KAUH-SCF-0366 ends
		
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
				common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getAllParameters) File Naming Convention["+clientParameters.strFileNamingConvention        +"]\n" );
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
		
		String accessionNumStr = "", accessionNum = "", clinicalNoteStr = "", encodedData = "";
		String encounterId = "", facilityId = "";
		
	
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
		
		if (strMessage != null && !(strMessage.equals(""))) {
			common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getNextMessage) MessageId["+strSentMessageId+"], EventType["+strSentEventType+"], Communication Start Time["+strCommStartTime+"], Acknowledgement Type["+strSentAckType+"], Message Length["+intSentMessageLength+"], Client Protocol id ["+clientParameters.strProtocolId+"]\n" ) ;
			
			if ((strSentEventType.equalsIgnoreCase("T02") 
					&& clientParameters.strProtocolId.equalsIgnoreCase("MLYAPPLP1")) || 
				(strSentEventType.equalsIgnoreCase("R01") 
						&& clientParameters.strProtocolId.equalsIgnoreCase("MALAFFIP2"))){
				
				try {
					
					common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getNextMessage) MessageId["+strSentMessageId+"], EventType["+strSentEventType+"], ENCODEDATA Position ["+strMessage.indexOf("ENCODEDATA")+"]\n" ) ;
					
					if (strMessage.indexOf("ENCODEDATA")>0)
					{
					
						clinicalNoteStr = "";
						encodedData = "";
						accessionNum = "";
						accessionNumStr = "";
						encounterId = "";
						
						accessionNumStr = getEventAccessionNum(strSentMessageId, strSentEventType);
						
						accessionNumStr = accessionNumStr.replace("$!^","^!^");
	
						String delims = "^!^";
						StringTokenizer st = new StringTokenizer(accessionNumStr,delims);
	
						ArrayList<String> tokenD = new ArrayList<String>();
	
						while (st.hasMoreElements()) {
							tokenD.add(st.nextToken());						
						}
						System.out.println("tokenD.size() ::: "+tokenD.size());
						if (tokenD.size()>0)
						{						
							facilityId = tokenD.get(1);
							encounterId = tokenD.get(2);
							accessionNum = tokenD.get(5);
						}					
						
						common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getNextMessage) MessageId["+strSentMessageId+"], EventType["+strSentEventType+"], Accession_Num["+accessionNum+"], Encounter_ID["+encounterId+"]\n" ) ;
						
						if (strSentEventType.equalsIgnoreCase("T02") 
								&& clientParameters.strProtocolId.equalsIgnoreCase("MLYAPPLP1"))
						{
							clinicalNoteStr = getHTMLData(accessionNum);
						}		
						
						if (strSentEventType.equalsIgnoreCase("R01") 
								&& clientParameters.strProtocolId.equalsIgnoreCase("MALAFFIP2"))
						{
							clinicalNoteStr = getResultHTMLData(accessionNum, encounterId, facilityId);
						}
						
						common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getNextMessage) MessageId["+strSentMessageId+"], EventType["+strSentEventType+"], Accession_Num["+accessionNum+"], Clinical Notes Length ["+clinicalNoteStr.length()+"]\n" ) ;
						
						//common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getNextMessage) MessageId["+strSentMessageId+"], ********** \n"+clinicalNoteStr+"]\n" ) ;
						
						byte[] pdfData = null;
						
						/*
								
						try {
							ITextRenderer renderer = new ITextRenderer();
							//renderer.getSharedContext().setReplacedElementFactory(new ProfileImageReplacedElementFactory(renderer.getSharedContext().getReplacedElementFactory()));
							renderer.setDocumentFromString(clinicalNoteStr.toString());
							renderer.layout();
							final ByteArrayOutputStream baos = new ByteArrayOutputStream();
							renderer.createPDF(baos);
							baos.flush();
							pdfData = baos.toByteArray();
						}
						catch(Exception e){
							common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getNextMessage) MessageId["+strSentMessageId+"], Exception ["+e.getMessage()+"]\n" ) ;
							e.printStackTrace();	
						}
						
						
						common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getNextMessage) MessageId["+strSentMessageId+"], EventType["+strSentEventType+"], Accession_Num["+accessionNum+"], Clinical Notes Length ["+clinicalNoteStr.length()+"]\n" ) ;
						*/
						InputStream is = new ByteArrayInputStream(clinicalNoteStr.getBytes());
						
						//common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getNextMessage) MessageId["+strSentMessageId+"], EventType["+strSentEventType+"], Accession_Num["+accessionNum+"], Clinical Notes Length ["+clinicalNoteStr.length()+"], InputStream is Length ["+is.toString().length()+"]\n" ) ;
						
						pdfData = convertHTMLtoPDF(is, true);	
						
						//common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getNextMessage) MessageId["+strSentMessageId+"], EventType["+strSentEventType+"], Accession_Num["+accessionNum+"], Clinical Notes Length ["+clinicalNoteStr.length()+"], PDF Data Length ["+pdfData.toString().length()+"]\n" ) ;
						
						encodedData = DatatypeConverter.printBase64Binary(pdfData);
						
						//common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getNextMessage) MessageId["+strSentMessageId+"], EventType["+strSentEventType+"], Accession_Num["+accessionNum+"], Clinical Notes Length ["+clinicalNoteStr.length()+"], Encoded Data Length ["+encodedData.toString().length()+"]\n" ) ;
						
						strMessage = strMessage.replaceAll("ENCODEDATA", encodedData);
						
						int updateCount = updateT02MesgData(strSentMessageId, strSentEventType, strMessage);
						
						common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getNextMessage) MessageId["+strSentMessageId+"], EventType["+strSentEventType+"], Update Count["+updateCount+"]\n" ) ;
					}
					
				}
				catch(Exception e){
					e.printStackTrace();					
				}				
			}
		}
	
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
			
			//common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getMessageFromProc) strCommdataIoApi..."+strCommdataIoApi+"\n");
	
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
		    
		    strSentMessageId = "0"; 
			strSentEventType = "";
			strCommStartTime = "";
	
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
				    
				    lastSentMessageId = strSentMessageId;
				    if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getMessageFromProc) Acknowledge Type : "+strSentAckType+" \n" ) ;

				    if ( (strSentAckType != null) 
					    && ( strSentAckType.equals(strStandardAckTypeALWAYS) 
						    || strSentAckType.equals(strStandardAckTypeSUCCESS) 
						    || strSentAckType.equals(strStandardAckTypeERROR)))
				    {
						if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getMessageFromProc) Acknowledgement Expected\n" ) ;
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
					if (call.getString(5) != null && !(call.getString(5).equals("")))
					{
						strSentMessageId = call.getString(5); 
						strSentEventType = call.getString(6);
						strCommStartTime = call.getString(8);
					}
					
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
	    
	    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getNextMessage) Inside loadMessagesToBuffer...\n"); 

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
    	    
    	    //Added by Sethu for MyHix K23 Response issue on 02/07/2018
    	    if (strSentEventType.equals("Q23"))
    	    {
    	    	strProcedureName = "{ call "+ clientParameters.strCommStatistics +"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    	    }
    
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

    	    //Added by Sethu for MyHix K23 Response issue on 02/07/2018
    	    if (strSentEventType.equals("Q23"))
    	    {
    	    	 call.setString(17,"");	
    	    }
    
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
    		msg = msg.replaceAll("\\^ACK", "");
    		
    		if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:processAcknowledgement) Acknowledge Message "+msg+"\n");
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
    	    
    	    //if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:processAcknowledgement) strApplicationId ::: "+ strApplicationId + " strFacilityId ::: "+ strFacilityId +" intProcessId ::: "+ intProcessId +"\n");
    	    //if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:processAcknowledgement) clobMessage ::: "+ clobMessage + " strModuleId ::: "+ strModuleId +" strProtocalLinkId ::: "+ strProtocalLinkId +"\n");
    
    	    
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
    	    
    	    //if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:processAcknowledgement) strErrorText ::: "+ strErrorText + " strReceiveAckCode ::: "+ strReceiveAckCode +" strReceiveAckMessageId ::: "+ strReceiveAckMessageId +"\n");
    
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
			/* If Condition added by Sethu for MOHE-SCF-0041 */
			/*
			if (clientParameters.strAckType == 0)
			{			
				if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:checkAcknowledgement) Message ID Sent - "+lastSentMessageId+", Message ID Received - "+strReceiveAckMessageId+", Acknowledge Code - "+strReceiveAckCode+"\n");
				
				if (lastSentMessageId.equals(strReceiveAckMessageId) && 
					(strReceiveAckCode.equals("A") || strReceiveAckCode.equals("AA") || strReceiveAckCode.equals("CA")))
				{
					boolCanSend = true;
				}
				else
				{
					boolCanSend = false;	
					if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:checkAcknowledgement) Message ID Sent - "+lastSentMessageId+", Message ID Received - "+strReceiveAckMessageId+", Bool Can Send - "+boolCanSend+"\n");						
				}
			}
			else
				boolCanSend = true;
				
				*/
			
			
			boolCanSend = true;

		}
		catch (Exception exceptionGeneral)
		{
	
		    //common.fileOutput( clientParameters.strExceptionLogFile, "(OutboundClientDBInteraction:checkAcknowledgement) Exception:"+exceptionGeneral+"\n " ) ;
		    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:checkAcknowledgement) Exception:"+exceptionGeneral+"\n " ) ;
		    checkDBConnection();
		}
    }// End checkAcknowledgement()

    public synchronized String fileNamingConvention(String procedurename, String strMessage)
    {	
	//	String strProcedureName = "{"+ strErrorPackageName+" "+procedurename+"(?)}";
	//	String strProcedureName = "{? = call "+ strErrorPackageName+"XH_TEST1}";
    	
    boolean l_proc_flag = false;
    
	String query = "select "+procedurename+" from dual";		
	String fileformat="";

	ResultSet rset = null;
	Statement stmt = null;
	
	String l_procedure_str = "";

	try
	{
		common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:fileNamingConvention)\n " ) ;	
		
		//common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:fileNamingConvention) procedurename ::: "+procedurename+" \n " ) ;	
		
		l_proc_flag = checkProcedureParam(procedurename);
		
		if (l_proc_flag)
		{			
			
			if (strMessage.length()>4000){
				strMessage = strMessage.substring(0, 4000);
			}
			
			l_procedure_str = procedurename.substring(0, procedurename.indexOf("(")+1);			

			CallableStatement cstmt = connDB.prepareCall("{?=call "+l_procedure_str+"?)}"); 
			cstmt.registerOutParameter(1,  java.sql.Types.VARCHAR);
			cstmt.setString(2, strMessage);
			cstmt.execute();
			fileformat = cstmt.getString(1);
			
			cstmt.close();
		}		
		else
		{
		
		    //		OracleCallableStatement call =(OracleCallableStatement) connDB.prepareCall(strProcedureName);
		    //		call.registerOutParameter(1,OracleTypes.CURSOR);
		    //		call.executeUpdate();
		    
		    stmt = connDB.createStatement();			
		    rset = stmt.executeQuery(query);
		    if(rset.next())
		    {
			fileformat = rset.getString(1);			
		    }
		    stmt.close();
		}
	    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:fileNamingConvention)File Name "+fileformat+"\n " ) ;
	    connDB.commit();
	    //		call.close();
	    
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
    
    public boolean checkProcedureParam(String procedure){
    	
    	String l_procedure = procedure;
    	String l_param = "";
    	
    	if (l_procedure.length()>0)
    	{
    		if (l_procedure.indexOf("(")>0)
    		{    			
    			l_param = l_procedure.substring(l_procedure.indexOf("(")+1, l_procedure.indexOf(")"));
    			
    			if (l_param.length()>0)
    				return true;
    			else
    				return false;
    			
    		}
    		
    	}

    	return false;        
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
	    if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getFileControlSrtucture) ErrorText : "+errorText+"\n" ) ;
	    if(errorText == null)
	    {
		controlMessage = callableStatement.getString(3);
		if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getFileControlSrtucture) controlMessage : "+controlMessage+"\n" ) ;
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
	    clientParameters.isExternalDBDown = false;
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
		clientParameters.isExternalDBDown = true;
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
		String sqlProcedure = "{ call " + "XHGATEWAY." + "GET_WEBSERVICE_CONFIG(?,?,?,?,?,?,?,?,?) }";
		//String sqlProcedure = "{ call " + "XHGATEWAY." + "GET_WEBSERVICE_CONFIG(?,?,?,?,?,?,?,?) }";
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
		    callableStatement.registerOutParameter(9,java.sql.Types.VARCHAR);
		    callableStatement.execute();
				
		    clientParameters.httpUserAgent = callableStatement.getString(3);
		    //if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getWebServiceParams) httpUserAgent "+clientParameters.httpUserAgent+"\n" ) ;	
		    
		    
		    clientParameters.httpContentType = callableStatement.getString(4);
		    //if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getWebServiceParams) httpContentType "+clientParameters.httpContentType+"\n" ) ;	
		    
		    clientParameters.httpTransferEncoding = callableStatement.getString(5);
		    //if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getWebServiceParams) httpTransferEncoding "+clientParameters.httpTransferEncoding+"\n" ) ;	
		    
		    clientParameters.httpSoapaction = callableStatement.getString(6);
		    //if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getWebServiceParams) httpSoapaction "+clientParameters.httpSoapaction+"\n" ) ;	
			   
		    clientParameters.httpContentLengthFlag = callableStatement.getInt(7);
		    //if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getWebServiceParams) httpContentLengthFlag "+clientParameters.httpContentLengthFlag+"\n" ) ;	
			   
		    clientParameters.httpSoapResponseXSL = callableStatement.getClob(8);
		    //if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getWebServiceParams) httpSoapResponseXSL "+clientParameters.httpSoapResponseXSL+"\n" ) ;
			   
		    clientParameters.httpFileUploadType = callableStatement.getString(9);
		    //if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getWebServiceParams) httpFileUploadType "+clientParameters.httpFileUploadType+"\n" ) ;
		    
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
    
    public void insertXHTrace(String strMessage)
    {
	PreparedStatement pstmt = null;

	String qry = "INSERT INTO XH_TRACE ("
	    + "PGM_ID, TEXT, RX_DATE, MACHINEID) "
	    + "VALUES (?,?,sysdate,?)";
	try
	{
		common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:insertXHTrace) Inside insertXHTrace...\n");
		
	    pstmt = connDB.prepareStatement(qry);
	    pstmt.setString(1, "ARY01");
	    pstmt.setString(2, strMessage);	    
	    pstmt.setString(3, "ARY01");
	   

	    int i = pstmt.executeUpdate();
	    
	    connDB.commit();
	    
	    common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:insertXHTrace) Successfully inserted insertXHTrace...\n"); 

	    if(i <= 0) common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:insertXHTrace) Failed to insert insertXHTrace...\n"); 
	}
	catch (Exception exp) {
	    common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp) + "\n");
	    checkDBConnection();
	}
	finally {
	    closeResource(null, pstmt);
	}
    }
    
    public String getEventAccessionNum(String messageId, String eventType)
    {	

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String accessionNum = "";
		String encounter_id = "";
	
		String qry = "SELECT nvl(ACCESSION_NUM,'') ACCESSION_NUM " +
				"FROM xh_event WHERE MESSAGE_ID = ? and EVENT_TYPE = ?";
	
		try
		{
		    pstmt = connDB.prepareStatement(qry);
		    pstmt.setString(1, messageId);
		    pstmt.setString(2, eventType);
	
		    rs = pstmt.executeQuery();		    
	
		    while(rs.next()) 
		    {
		    	accessionNum = rs.getString("ACCESSION_NUM");
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
		return accessionNum;
    }
    
    public String getHTMLData(String accessionNum)
    {	

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String htmlData = "";
		Clob clob = null;
	
		String qry = "SELECT NOTE_CONTENT FROM CA_ENCNTR_NOTE WHERE ACCESSION_NUM = ? ";
	
		try
		{
		    pstmt = connDB.prepareStatement(qry);
		    pstmt.setString(1, accessionNum);	
		    
		    rs = pstmt.executeQuery();
		    
		    htmlData = "";
	
		    while(rs.next()) 
		    {
		    	clob = rs.getClob("NOTE_CONTENT");
		    	htmlData = clob.getSubString(1, (int) clob.length());
		    }
		}
		catch (Exception exp)
		{
		    common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp) + "\n");
		    checkDBConnection();
		}
		finally {
		    closeResource(rs, pstmt);
		    clob = null;
		}
		return htmlData;
    }
    
    public String getResultHTMLData(String accessionNum, String encounterId, String facilityId)
    {	

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String htmlData = "";
		Clob clob = null;
	
		String qry = "SELECT NOTE_CONTENT FROM CA_ENCNTR_NOTE WHERE ACCESSION_NUM = ?";
		
		String headerData = ""; 
		String  v_facility_id = "", v_patient_id = "", v_patient_name = "", v_locn_desc = "", v_encounter_id = "", v_date_of_birth = "",
        v_event_date_time = "", v_gender = "", v_age = "", v_patient_class = "", v_visit_adm_date_time = "",
        v_speciality = "", v_attend_pract_id = "", v_auth_pract_id = "", v_system_date_time = "";
		
		String headerQry = "select sample_notes_xml_header from xh_param";
		
		String patientQry = "select b.patient_id, b.patient_name, " +
				" CASE WHEN a.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit (a.facility_id, a.encounter_id, 'en', '1')" +
				" ELSE op_get_desc.op_clinic (a.facility_id, a.encounter_id, 'en', '1') END locn_desc," +
				" a.encounter_id, to_char(b.date_of_birth,'dd/mm/yyyy') date_of_birth, to_char(sysdate,'DD/MM/YYYY HH24:MI') event_date, b.sex, " +
				" mp_get_age_ymdh(b.date_of_birth) age, a.patient_class patient_class," +
				" to_char(a.visit_adm_date_time,'DD/MM/YYYY HH24:MI') visit_adm_date_time, a.specialty_code specialty_code, " +
				" a.attend_practitioner_id attend_practitioner_id, a.admit_practitioner_id admit_practitioner_id, to_char(sysdate,'DD/MM/YYYY HH24:MI') system_date" +
				" from pr_encounter a, mp_patient b " +
				" where a.patient_id = b.patient_id and a.facility_id = ? and a.encounter_id = ?";		
		
		try
		{
			//common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getResultHTMLData) To query for Header Information...\n"); 
			
			pstmt = connDB.prepareStatement(headerQry);		    
		    rs = pstmt.executeQuery();
		    
		    headerData = "";
	
		    while(rs.next()) 
		    {
		    	clob = rs.getClob("SAMPLE_NOTES_XML_HEADER");
		    	headerData = clob.getSubString(1, (int) clob.length());
		    }
		    
		    //common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getResultHTMLData) Header Information Data Length... "+headerData.length()+"\n");
		    		    
		    //common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getResultHTMLData) To query for Patient Information... "+facilityId+" .... "+encounterId+"\n");
		    
		    if (rs != null) rs.close();
		    if (pstmt != null) pstmt.close();
		    
		    pstmt = connDB.prepareStatement(patientQry);	
		    pstmt.setString(1, facilityId);
		    pstmt.setString(2, encounterId);
		    rs = pstmt.executeQuery();
	
		    while(rs.next()) 
		    {
		    	v_patient_id 	= rs.getString("patient_id")==null?"":rs.getString("patient_id");
		    	v_patient_name 	= rs.getString("patient_name")==null?"":rs.getString("patient_name");
		    	v_locn_desc 	= rs.getString("locn_desc")==null?"":rs.getString("locn_desc");
		    	v_encounter_id 	= rs.getString("encounter_id")==null?"":rs.getString("encounter_id");
		    	v_date_of_birth = rs.getString("date_of_birth")==null?"":rs.getString("date_of_birth");
		    	v_event_date_time = rs.getString("event_date")==null?"":rs.getString("event_date");
		    	v_gender 		= rs.getString("sex")==null?"":rs.getString("sex");
		    	v_age 			= rs.getString("age")==null?"":rs.getString("age");
		    	v_patient_class = rs.getString("patient_class")==null?"":rs.getString("patient_class");
		    	v_visit_adm_date_time = rs.getString("visit_adm_date_time")==null?"":rs.getString("visit_adm_date_time");
		    	v_speciality 	= rs.getString("specialty_code")==null?"":rs.getString("specialty_code");
		    	v_attend_pract_id = rs.getString("attend_practitioner_id")==null?"":rs.getString("attend_practitioner_id");
		    	v_auth_pract_id = rs.getString("admit_practitioner_id")==null?"":rs.getString("admit_practitioner_id");
		    	v_system_date_time = rs.getString("system_date")==null?"":rs.getString("system_date");		
		    	
		    	//common.fileOutput(clientParameters.strLogFile, "(OutboundClientDBInteraction:getResultHTMLData) Patient Information retrieved successfully..."+v_patient_class+"\n");
		    }
		    
		  //Replacing the Header and footer data with the patient/visit information
		    
		    if (headerData.length()>0)
		    {
		    	headerData = headerData.replaceAll("#P_PATIENT_ID#", v_patient_id);
		        headerData =  headerData.replaceAll("#P_PATIENT_NAME#", v_patient_name);
		        headerData =  headerData.replaceAll("#P_LOCN_DESC#", v_locn_desc);
		        headerData =  headerData.replaceAll("#P_ENCOUNTER_ID#", v_encounter_id);
		        headerData =  headerData.replaceAll("#P_BIRTH_DATE#", v_date_of_birth);
		        headerData =  headerData.replaceAll("#P_EVENT_DATE_TIME#", v_event_date_time);
		        headerData =  headerData.replaceAll("#P_GENDER#", v_gender);
		        headerData =  headerData.replaceAll("#P_AGE#", v_age);
		        headerData =  headerData.replaceAll("#P_PATIENT_CLASS#", v_patient_class);
		        headerData =  headerData.replaceAll("#P_VISIT_ADM_DATE_TIME#", v_visit_adm_date_time);
		        headerData =  headerData.replaceAll("#P_SPECIALITY#", v_speciality);
		        headerData =  headerData.replaceAll("#P_ATTEND_PRACT_ID#", v_attend_pract_id);
		        headerData =  headerData.replaceAll("#P_AUTH_PRACT_ID#", v_auth_pract_id);
		        headerData =  headerData.replaceAll("#P_SYSTEM_DATE_TIME#", v_system_date_time);
		    }
		    
			
		    pstmt = connDB.prepareStatement(qry);
		    pstmt.setString(1, accessionNum);	
		    
		    rs = pstmt.executeQuery();
		    
		    htmlData = "";
	
		    while(rs.next()) 
		    {
		    	clob = rs.getClob("NOTE_CONTENT");
		    	htmlData = clob.getSubString(1, (int) clob.length());
		    }
		    
		    //Replacing the final data with the body information
		    htmlData = headerData.replaceAll("#body#", htmlData);
		}
		catch (Exception exp)
		{
		    common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp) + "\n");
		    checkDBConnection();
		}
		finally {
		    closeResource(rs, pstmt);
		    clob = null;
		}
		return htmlData;
    }
    
    public static byte[] convertHTMLtoPDF(InputStream bais, boolean isFitWidth) throws ParserConfigurationException, SAXException, IOException, DocumentException {
		
		ByteArrayOutputStream out = null;

		try
		{
			
			String oldValue = System.getProperty("java.protocol.handler.pkgs");
			if (oldValue == null)
			{
				System.setProperty("java.protocol.handler.pkgs", "org.xhtmlrenderer.protocols");
			}
			else if (!oldValue.contains("org.xhtmlrenderer.protocols"))
			{
				System.setProperty("java.protocol.handler.pkgs", oldValue + "|org.xhtmlrenderer.protocols");
			}
			
			ITextRenderer renderer = new ITextRenderer();
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			Tidy tidy = new Tidy(); 
			tidy.setShowWarnings(false);
			tidy.setXmlTags(false);
			tidy.setInputEncoding("UTF-8");
			tidy.setOutputEncoding("UTF-8");
			tidy.setXHTML(true); 
			tidy.setMakeClean(true);
			
			Document xmlDoc = tidy.parseDOM(bais, null);
			renderer.setDocument(xmlDoc, null);

			renderer.layout();

			out = new ByteArrayOutputStream();
			renderer.createPDF(out);
			out.flush();
			//out.close();
			//System.out.println(" ******************** PDF Byte Array **************** ");
			//System.out.println(Arrays.toString(out.toByteArray()));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}        

        return out.toByteArray();
    }
    
    public int updateT02MesgData(String message_id, String event_type, String message)
    {	

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String htmlData = "";
		Clob clob = null;
		int updateCount = 0;
	
		String qry = "update xh_application_message set MESSAGE_TEXT = ? where message_id = ? and event_type = ? ";
	
		try
		{
		    pstmt = connDB.prepareStatement(qry);
		    pstmt.setString(1, message);	
		    pstmt.setString(2, message_id);
		    pstmt.setString(3, event_type);
		    
		    updateCount = pstmt.executeUpdate();
		    
		    connDB.commit();	    
		   
		}
		catch (Exception exp)
		{
		    common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp) + "\n");
		    checkDBConnection();
		}
		finally {
		    closeResource(rs, pstmt);
		    clob = null;
		}
		return updateCount;
    }
    
    /**
     * Method to retrieve the JavaMail Params // Added by Niveditha for AAKH-CRF-0113
    */
	
    public void getJavaMailParams() //Modifed XHGATEWAY by Niveditha for Mail attachment
    {	
     	
    	String sqlProcedure = "{ call " + "XHGATEWAY." + "GET_JAVAMAIL_CONFIG(?,?,?,?,?,?,?,?) }";
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
		    callableStatement.registerOutParameter(8,java.sql.Types.VARCHAR);
		    callableStatement.execute();

		    clientParameters.mail_host = callableStatement.getString(3);		    
		    common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:getJavamailParams) MailHost["+ clientParameters.mail_host +"]\n" );		    
		    
		    clientParameters.mail_port = callableStatement.getString(4);
		    common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getJavamailParams) MailPort["+ clientParameters.mail_port +"]\n" );				   
		    
		    clientParameters.mail_config = callableStatement.getString(5);
		    common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getJavamailParams) MailConfig["+ clientParameters.mail_config +"]\n" );			    
		    
		    clientParameters.mail_smtp_auth_flag = callableStatement.getString(6);
		    common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getJavamailParams) MailSMTPAuthFlag["+ clientParameters.mail_smtp_auth_flag +"]\n" );			    
		    
		    clientParameters.mail_smtp_starttls_flag = callableStatement.getString(7);
		    common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getJavamailParams) MailSMTPStarttlsFlag["+ clientParameters.mail_smtp_starttls_flag +"]\n" );		    
		    
		    
		    clientParameters.mail_attachment_flag = callableStatement.getString(8);  //Added by Niveditha for Mail attachment
		    common.fileOutput( clientParameters.strLogFile, "(OutboundServerDBInteraction:getJavamailParams) MailAttachmentFlag["+ clientParameters.mail_attachment_flag +"]\n" );	 //Added by Niveditha for Mail attachment
			   
		}
		catch(Exception exception)
		{
		    common.fileOutput( clientParameters.strExceptionLogFile, "(OutboundServerDBInteraction:getJavaMailParams)Exception:- "+exception+"\n" ) ;
		    checkDBConnection();
		}
		finally {
			SQLUtil.closeStatement(callableStatement);
		}
    }
    
    public String getShortURL(String functionID,String emWebURLLink,String paramString)
    {
    	String shortID="";
    	String sqlProcedure = "{ call " + "XHEXTERNALCALL." + "generate_short_url(?,?,?,?,?,?) }";
		OracleCallableStatement callableStatement = null;
		try
		{
			callableStatement = (OracleCallableStatement) connDB.prepareCall(sqlProcedure);
			callableStatement.setString(1,functionID);
			callableStatement.setString(2,emWebURLLink);
			callableStatement.setString(3,paramString);
		    callableStatement.registerOutParameter(4,java.sql.Types.VARCHAR);
		    callableStatement.registerOutParameter(5,java.sql.Types.VARCHAR);
		    callableStatement.registerOutParameter(6,java.sql.Types.VARCHAR);
		    callableStatement.execute();
		    shortID=callableStatement.getString(4); 
		}
		catch(Exception exception)
		{
		    common.fileOutput( clientParameters.strExceptionLogFile, "(OutboundServerDBInteraction:getShortURL)Exception 112:- "+exception+"\n" ) ;
		    checkDBConnection();
		}
		finally {
			SQLUtil.closeStatement(callableStatement);
		}
		return shortID;
    }

	//Added By Niveditha 
	public String getstandardprofile(String profileID){
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String standardcode = "";
	
			String qry = "SELECT STANDARD_CODE FROM XH_STANDARD_PROFILE WHERE PROFILE_ID = ? ";
	
			try
			{
			    pstmt = connDB.prepareStatement(qry);
			    pstmt.setString(1, profileID);			    
			    rs = pstmt.executeQuery();
			  while(rs.next()) 
			    {
				  standardcode = rs.getString("STANDARD_CODE"); 	
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
			return standardcode;
	}

	//Added By Niveditha
	public String getstandardsegsubject(String controlsegmentID, String standardCODE){
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String mailelementsubject = "";
	
			String qry = "SELECT DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG WHERE SEGMENT_ID = ? AND STANDARD_CODE = ? AND ELEMENT_ID='MAIL_SUBJECT' ";
			
			try
			{
			    pstmt = connDB.prepareStatement(qry);
			    pstmt.setString(1, controlsegmentID);	
			    pstmt.setString(2, standardCODE);		    
			    rs = pstmt.executeQuery();
			  while(rs.next()) 
			    {
				  mailelementsubject = rs.getString("DEFAULT_VALUE");
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
			return mailelementsubject;
	}

	//Added By Niveditha
	public String getstandardsegcc(String controlsegmentID, String standardCODE){
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String mailelementcc = "";
	
			String qry = "SELECT DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG WHERE SEGMENT_ID = ? AND STANDARD_CODE = ? AND ELEMENT_ID='CC_EMAIL_ID' ";
			
			try
			{
			    pstmt = connDB.prepareStatement(qry);
			    pstmt.setString(1, controlsegmentID);	
			    pstmt.setString(2, standardCODE);		    
			    rs = pstmt.executeQuery();
			  while(rs.next()) 
			    {
				  mailelementcc = rs.getString("DEFAULT_VALUE");
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
			return mailelementcc;
	}

	//Added by Apoorva on 6/07/2022 for JD_CRF_0212
	
	public boolean bloodSugarInterfaceMethod(Connection externalDBConn)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String msgClobData = "";
		
		String msgFetchQry ="";
		String vtd_patientid="", vtd_id = "", vtd_syncdatetime = "", l_errcd="S", vtd_ex_flag = "", vtd_ex_datetime = "";
		boolean check_message = false;
	
		try
		{
		    /*
			msgFetchQry = "Select 'VTD'||'|'||VTD_ID||'|'||VTD_Unit||'|'||VTD_Operator||'|'||To_Char(VTD_MeasureDateTime,'YYYYMMDDHH24MISS')" +
		    			"||'|'||VTD_MeterID||'|'||VTD_PatientID||'|'||VTD_VisitNumber||'|'||VTD_Value||'|'||VTD_Value_RangeL||'|'" +
		    			"||VTD_Value_RangeU||'|'||VTD_ShowLot||'|'||VTD_Code||'|'||To_Char(VTD_SyncDateTime,'YYYYMMDDHH24MISS')||'|'||" +
		    			"VTD_MeterCommentCode||'|'||VTD_Ex_Flag||'|'||To_Char(VTD_Ex_DateTime,'YYYYMMDDHH24MISS')||'|'||VTD_ACPC||'|'||" +
		    			"VTD_UploadIP as message_text , VTD_ID , VTD_PatientID, VTD_Ex_Flag,To_Char(VTD_Ex_DateTime,'YYYYMMDDHH24MISS')," +
		    			" To_Char(VTD_SyncDateTime,'YYYYMMDDHH24MISS') " +
		    			"From   View_ExData_TestData Where  VTD_Ex_Flag is Null Order By  VTD_SyncDateTime";
			*/
			
			msgFetchQry = "Select CONCAT('VTD','|',VTD_ID,'|',VTD_Unit,'|',VTD_Operator,'|', FORMAT(VTD_MeasureDateTime, 'yyyyMMddHHmmss'), '|', " +
	    			"VTD_MeterID,'|',VTD_PatientID,'|',VTD_VisitNumber,'|',VTD_Value,'|',VTD_Value_RangeL,'|', " +
	    			"VTD_Value_RangeU,'|',VTD_ShowLot,'|',VTD_Code,'|', FORMAT(VTD_SyncDateTime, 'yyyyMMddHHmmss'), '|', " +
	    			"VTD_MeterCommentCode,'|',VTD_Ex_Flag,'|', FORMAT(VTD_Ex_DateTime, 'yyyyMMddHHmmss'),'|',VTD_ACPC,'|', " +
	    			"VTD_UploadIP) as message_text , VTD_ID , VTD_PatientID, VTD_Ex_Flag, FORMAT(VTD_Ex_DateTime, 'yyyyMMddHHmmss') as VTD_Ex_DateTime, " +
	    			" FORMAT (VTD_SyncDateTime, 'dd/MM/yyyy, HH:mm:ss ') as VTD_SyncDateTime " +
	    			"From View_ExData_TestData Where VTD_Ex_Flag is Null and trim(VTD_PatientID) <> '' " +
	    			"Order By VTD_SyncDateTime";
			
			//common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:bloodSugarInterfaceMethod) msgFetchQry["+ msgFetchQry +"]\n" );
			
		    pstmt = externalDBConn.prepareStatement(msgFetchQry);
	
		    rs = pstmt.executeQuery();	
		    
		    while(rs.next())
		    {				
	
		    	check_message = true;
				msgClobData = rs.getString("message_text");
				vtd_patientid = rs.getString("VTD_PatientID");
				vtd_id = rs.getString("VTD_ID");
				vtd_syncdatetime = rs.getString("VTD_SyncDateTime");
				vtd_ex_flag = rs.getString("VTD_Ex_Flag");
				vtd_ex_datetime = rs.getString("VTD_Ex_DateTime");
				
				//common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:bloodSugarInterfaceMethod) vtd_patientid["+ vtd_patientid +"], vtd_id["+ vtd_id +"], vtd_syncdatetime["+ vtd_syncdatetime +"], vtd_ex_flag["+ vtd_ex_flag +"]\n" );
				
				l_errcd = insertIntoInboundTable(msgClobData,vtd_patientid,vtd_id,vtd_syncdatetime);
				
				//common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:bloodSugarInterfaceMethod) l_errcd["+ l_errcd +"]\n" );
				
				if(l_errcd.equals("S")){
					
					Statement stmt = externalDBConn.createStatement();
				    
					/*
					String strUpdQry = "UPDATE View_ExData_TestData SET "+
				    " VTD_Ex_Flag = "+vtd_ex_flag+", VTD_Ex_DateTime = to_date('"+vtd_ex_datetime+"','dd/mm/yyy HH:mi:ss')" +
				    		"  WHERE VTD_PatientID="+vtd_patientid+
				    " AND VTD_SyncDateTime = '"+vtd_syncdatetime+"'";
				    */
					
					String strUpdQry = "UPDATE View_ExData_TestData SET "+
						    " VTD_Ex_Flag = 'Y', VTD_Ex_DateTime = getdate()" +
						    		"  WHERE VTD_PatientID ='"+vtd_patientid+"' "+
						    			" AND VTD_ID = '"+vtd_id+"'";
				    
					common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:bloodSugarInterfaceMethod) strUpdQry["+ strUpdQry +"]\n" );
					
					stmt.executeUpdate(strUpdQry );
				    externalDBConn.commit();
				    stmt.close();
					
				}
			
		    }	
		    
		}
		catch (Exception exp)
		{
			check_message = false;
		    common.fileOutput(clientParameters.strExceptionLogFile, "(OutboundClientDBInteraction:bloodSugarInterfaceMethod)Exception "+exp+"\n" );
		    exp.printStackTrace();
		}
		return check_message;
	}

	public String insertIntoInboundTable(String msgClobData, String vtd_patientid, String vtd_id, String vtd_syncdatetime) {
	
		ResultSet rs = null;
		
		PreparedStatement pstmt = null;
	
		int insertCount = 0;
	
		String l_err_cd = "S", insertstmt = "", query ="", encounter_id = "" ,episode_type = "" ,episode_id = "" ,visit_no = "";
	
		try {
			
				query = "select encounter_id, decode(patient_class,'OP','O', 'IP','I', 'DC', 'I', 'EM', 'O') episode_type, " +
						"SUBSTR(encounter_id,1,8) episode_id, SUBSTR(encounter_id,9,4) visit_no from pr_encounter " +
						"where patient_id = ? and " +
						"visit_adm_date_time = (select max(visit_adm_date_time) from pr_encounter where patient_id = ? " +
						"and discharge_date_time is null) and discharge_date_time is null and rownum = 1";
				
				//common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:insertIntoInboundTable) query["+ query +"]\n" );
		
				pstmt = connDB.prepareStatement(query);
				
				pstmt.setString(1, vtd_patientid);
				pstmt.setString(2, vtd_patientid);
				
				rs = pstmt.executeQuery();
				while (rs.next()) {
					encounter_id = rs.getString("encounter_id");
					episode_type = rs.getString("episode_type");
					episode_id = rs.getString("episode_id");
					visit_no = rs.getString("visit_no");
					
					//common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:insertIntoInboundTable) encounter_id["+ encounter_id +"], episode_type["+ episode_type +"], episode_id["+ episode_id +"], visit_no["+ visit_no +"]\n" );
				}
			
			 	insertstmt = "INSERT INTO XH_INBOUND_MESSAGE (application_id, facility_id, message_id, srl_no, message_received_date, process_id, "
					+ " client_id, inbound_message_text, message_ack_text, message_status, rd_order_yn, "
					+ " added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, "
					+ " patient_id, merged_patient_id, episode_type, episode_id, visit_id, accession_num, action_type, "
					+ " last_proc_date, event_status, not_req_reason, ext_accession_num, event_type, protocol_link_id,err_msg) "
					+ " VALUES ( ?, ?, ?, ?, To_Date('"+vtd_syncdatetime+"','dd/mm/yyyy hh24:mi:ss'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
	
			 	common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:insertIntoInboundTable) insertstmt["+ insertstmt +"]\n" );
	
				pstmt = connDB.prepareStatement(insertstmt);
	
				pstmt.setString(1, strApplicationId);
				pstmt.setString(2, strFacilityId);
				pstmt.setString(3, vtd_id);
				pstmt.setString(4, "1"); // SRL_NO
				pstmt.setInt(5, intProcessId); // PROCESS_ID
	
				pstmt.setString(6, OutboundClientParameters.machineName); // CLIENT_ID
				pstmt.setString(7, msgClobData); // INBOUND_MESSAGE_TEXT
				pstmt.setString(8, ""); // MESSAGE_ACK_TEXT
				pstmt.setString(9, "S"); // MESSAGE_STATUS
				pstmt.setString(10, ""); // RD_ORDER_YN
	
				pstmt.setString(11, "INTERFACE"); //added_by
				pstmt.setTimestamp(12, new java.sql.Timestamp(System.currentTimeMillis()));// added_date
				pstmt.setString(13, OutboundClientParameters.machineName);//added_at_ws_no
				pstmt.setString(14,strFacilityId); //added_facility_id
	
				pstmt.setString(15, "INTERFACE");//modified by
				pstmt.setTimestamp(16, new java.sql.Timestamp(System.currentTimeMillis()));//modified_date
				pstmt.setString(17, OutboundClientParameters.machineName);//modified_at_ws_no
				pstmt.setString(18,strFacilityId);//modified_facility_id
	
				pstmt.setString(19, vtd_patientid);
				pstmt.setString(20, "");//merged_patient_id
				pstmt.setString(21, episode_type);//episode_type
				pstmt.setString(22, episode_id);//episode_id
				pstmt.setString(23, visit_no);//visit_id
				pstmt.setString(24, "");// accession_num
				pstmt.setString(25, "");//action_type
	
				pstmt.setString(26, "");//last_proc_date
				pstmt.setString(27, "");//event_status
				pstmt.setString(28, "");//not_req_reason
				pstmt.setString(29, "");//ext_accession_num
				pstmt.setString(30, "GM1");//event_type
				pstmt.setString(31, "");//protocol_link_id
				pstmt.setString(32, "");//err_msg
	
				insertCount = pstmt.executeUpdate();
				
				if (insertCount == 1) {	
					l_err_cd = "S";	
					connDB.commit();
				} else {
					l_err_cd = "E";
					connDB.rollback();
				}
				
				common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:insertIntoInboundTable) insertCount["+ insertCount +"], l_err_cd["+ l_err_cd +"]\n" );
				
		}
		catch (Exception exp)
		{
		    common.fileOutput(clientParameters.strExceptionLogFile, "(OutboundClientDBInteraction:insertIntoInboundTable)Exception "+exp+"\n" ) ;
		    exp.printStackTrace();
		    l_err_cd ="E";
		    
		}
		finally
		{
		    closeResource(rs, pstmt);			
		}
		return l_err_cd; 
		
	}

}