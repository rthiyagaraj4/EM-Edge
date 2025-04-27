/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
	Modified By   : Nanda Kumar R.	
	Modified Date : 4/3/2003
*/
package HL7Engine.InboundProcess ;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
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
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import oracle.jdbc.OracleCallableStatement;
import oracle.sql.BLOB;
import oracle.sql.CLOB;
import HL7Engine.Common.Common;
import HL7Engine.Common.CommonUtil;
import HL7Engine.Common.EMConstants;
import HL7Engine.Common.SQLUtil;

import javax.xml.bind.DatatypeConverter;
import sun.misc.*;

public class InboundServerDBInteraction
{
	Common common = null;
	String strPackageName = "call xhcore.";
	String strPackageName2 = "call xhbuilder.";
	String strPackageName3 = "call DBMS_SESSION.";
	String strErrorPackageName = "call xhgenprc.";
	String XHSTANDARD = "xhstandard";
	
	String strPackageName4 = "call XPCORE.";

	String strTnsName = "0";
	String strOrclUserId = "0";
	String strOrclPasswd = "0";

	Connection connDB;
	Connection externalDBConn;
	String strMessage = "0";

	InboundServerParameters serverParameters;
	
	String strApplicationId;
	String strFacilityId;
	int    intProcessId;
	String strProcessType;
	String strClientId="0";

	String strQueryId = "0";	//5
	String strMessageId = "0";   //6	
	String strEventType;		//7
	String strProcessStartTime ="0"; //8
	String strProcessEndTime = "0";
	String strProtocalLinkId = "TCP/IP";
	String strCommunicationMode;

	String strSentMessageId="0";
	String strSentAckType="0";
	String strSentEventType="0";
	String strCommStartTime ="0";	

	String strStandardAckTypeALWAYS = "AL";
	String strStandardAckTypeNEVER = "NE";
	String strStandardAckTypeERROR = "ER";
	String strStandardAckTypeSUCCESS = "SU";		

	String strStopYN = "N";
	int intSentMessageLength = 0;

	boolean boolCanSend = false;
	boolean boolCanStop = false;	
	boolean boolRead = true;
	boolean boolFatalError = false;	;

	int intTotalWidth = 4194304;

	String strTotalParam ="0";

	StackTraceElement stackTrace;	// object used to get the line number when a exception arises.
	StackTraceElement [] stackTraceArray;

	ArrayList ackMessageList = null;	
	ArrayList partialMsgAckList = null;
	boolean ackSent = false;

	int count = 0;

	public synchronized boolean isThereFatalError()
	{
		return(boolFatalError);
	}
	
	public synchronized String canISend()
	{
		if (boolCanSend == true)
		{	
			boolCanSend = false;
			return(strMessage);
		}
		else
		{
			return("");	
		}
	}

	public InboundServerDBInteraction(InboundServerParameters  serverP)
	{
		common = Common.getInstance();
		serverParameters = serverP;	
	//	serverParameters.ackMessageList = new ArrayList();
		strApplicationId = serverP.strApplicationId;
		strFacilityId = serverP.strFacilityId;
		intProcessId = serverP.intProcessId;
		strTnsName = serverP.strTnsName;
		strOrclUserId = serverP.strOrclUserId;
		strOrclPasswd = serverP.strOrclPasswd;
		strProcessType = serverP.strProcessType;
		strClientId = serverP.strClientId;
		strProtocalLinkId = serverP.strProtocalLinkId;						
	}
	private void setMedUserRole()
	{	
		try
		{			
		//	if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:setMedUserRole)Setting meduser...\n" ) ;	
			String strParamRole = "";
			String strProcedureName = "{"+ strPackageName3+"SET_ROLE(?)"+"}";
			Statement stmt = null; 
			String strQry = "SELECT APP_PASSWORD.DECRYPT(ORA_ROLE_PASSWORD) FROM SM_ORA_ROLE  Where ORA_ROLE_ID = 'MEDUSERS'";
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

				//System.out.println(" Stop YN"+strStopYN);
			}
			catch(Exception expSql)
			{
				common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:setMedUserRole):"+expSql ) ;	
				
				try
				{
					stmt.close();
				}
				catch(Exception e)
				{
				}
			}
			strParamRole = "MEDUSERS";
			call =(OracleCallableStatement) connDB.prepareCall(strProcedureName);
			call.setString(1,strParamRole);
			call.execute();
			call.close();

		}
		catch(Exception expCal)
		{
			common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:setMedUserRole):"+expCal+"\n" ) ;	
			common.fileOutput( serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(expCal) + "\n" ) ;
		}		
	}

	public boolean makeDBConnection()
	{
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());			
			connDB = DriverManager.getConnection("jdbc:oracle:thin:@"+strTnsName,strOrclUserId, strOrclPasswd);			
			common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:makeDBConnection) jdbc:oracle:thin:@"+strTnsName+"\n" ) ;				
			connDB.setAutoCommit(false);			
			setMedUserRole();
			common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:makeDBConnection) Database connection successful\n" ) ;

			serverParameters.isDBDown = false;

			return true;
		}
		catch(SQLException exceptionSQL)
		{	
			serverParameters.isDBDown = true;
			common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:makeDBConnection) SQLException:"+exceptionSQL.getMessage()+"\n") ;
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionSQL) + "\n") ;
		}
		catch(Exception exceptionConnection)
		{				
			common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:makeDBConnection) Exception:"+exceptionConnection.getMessage()+"\n") ;
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionConnection) + "\n") ;
		}
		catch(Error error)
		{
			common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:makeDBConnection) error: "+error.getMessage()+"\n") ;
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(error) + "\n") ;
		}
		return false;
	}


	public void getXHParameters()
    {
		Statement stmt = null;
		ResultSet rset = null;

	//	String strInboundLogYN = "N";

		try
		{
			stmt = connDB.createStatement();

			//	String strQry="SELECT NVL(OUTBOUND_LOG_YN,'N'), NVL(INBOUND_LOG_YN,'N'), COMM_PROCESS_IDLE_TIME FROM XH_PARAM_FOR_FACILITY,XH_PARAM WHERE FACILITY_ID='"+serverParameters.strFacilityId+"'";
			String strQry = "SELECT COMM_PROCESS_IDLE_TIME FROM XH_PARAM";
			rset = stmt.executeQuery(strQry);
			if (rset.next())
			{
			//	strInboundLogYN = rset.getString(2);
				serverParameters.intIdleTime = rset.getInt(1);
				if(serverParameters.intIdleTime <= 0)
				{
					serverParameters.intIdleTime = 9999;
				}
				common.fileOutput(serverParameters.strLogFile,"(InboundServerDBInteraction:getXHParameters)  Idle Time: "+serverParameters.intIdleTime+" Min.\n");
			}
		/*	common.fileOutput(serverParameters.strLogFile,"(InboundServerDBInteraction:getXHParameters)strInboundLogYN : "+strInboundLogYN);			
			try
			{
			//	serverParameters.intWrite = (strInboundLogYN.equalsIgnoreCase("Y"))? 1:0;
			//	serverParameters.logToFile = (strInboundLogYN.equalsIgnoreCase("Y"))? true:false;
				serverParameters.intWrite = 1;
				serverParameters.logToFile = true;
			}
			catch(Exception exp)
			{

			}
		*/				
		}
		catch(SQLException exceptionSQL)
		{			
			common.fileOutput(serverParameters.strLogFile,"(InboundServerDBInteraction:getXHParameters) Exception: "+exceptionSQL+"\n");			
		}
		catch(Exception exceptionQry)
		{			
			common.fileOutput(serverParameters.strLogFile,"(InboundServerDBInteraction:getXHParameters) Exception: "+exceptionQry+"\n");			
		}
		finally
		{
			try
			{
				if(rset != null) rset.close();
				if(stmt != null) stmt.close();
			}
			catch(Exception exp)
			{
				common.fileOutput(serverParameters.strLogFile,"(InboundServerDBInteraction:getXHParameters): "+exp);
			}
		}
    }

	public synchronized InboundServerParameters getAllParameters()
	{
		String strInboundLogYN = "N";
		try
		{
			String strProcedureName = "{"+ strPackageName+"Get_application_info(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"+"}";
			String strErrorText = "0";
			OracleCallableStatement  call = (OracleCallableStatement) connDB.prepareCall(strProcedureName);
						
			call.setString(1,strApplicationId);
			call.setString(2,strFacilityId);
			call.setString(3,strProcessType);						
			call.setString(4,strProtocalLinkId);

			call.registerOutParameter(5,java.sql.Types.VARCHAR);
			call.registerOutParameter(6,java.sql.Types.VARCHAR);
			call.registerOutParameter(7,java.sql.Types.VARCHAR);
			call.registerOutParameter(8,java.sql.Types.VARCHAR);
			call.registerOutParameter(9,java.sql.Types.VARCHAR);
			call.registerOutParameter(10,java.sql.Types.VARCHAR);
	        call.registerOutParameter(11,java.sql.Types.VARCHAR);
		    call.registerOutParameter(12,java.sql.Types.VARCHAR);
			call.registerOutParameter(13,java.sql.Types.VARCHAR);
			call.registerOutParameter(14,java.sql.Types.VARCHAR);
			call.registerOutParameter(15,java.sql.Types.VARCHAR);			
			call.registerOutParameter(16,java.sql.Types.VARCHAR);
			call.registerOutParameter(17,java.sql.Types.VARCHAR);
			call.registerOutParameter(18,java.sql.Types.VARCHAR);
			call.registerOutParameter(19,java.sql.Types.VARCHAR);
			call.registerOutParameter(20,java.sql.Types.VARCHAR);
			call.registerOutParameter(21,java.sql.Types.VARCHAR);
			call.registerOutParameter(22,java.sql.Types.VARCHAR);
	        call.registerOutParameter(23,java.sql.Types.VARCHAR);
		    call.registerOutParameter(24,java.sql.Types.VARCHAR);
			call.registerOutParameter(25,java.sql.Types.VARCHAR);
		    call.registerOutParameter(26,java.sql.Types.VARCHAR);
			call.registerOutParameter(27,java.sql.Types.VARCHAR);
			call.registerOutParameter(28,java.sql.Types.VARCHAR);
			call.registerOutParameter(29,java.sql.Types.VARCHAR);
			call.registerOutParameter(30,java.sql.Types.VARCHAR);
			call.registerOutParameter(31,java.sql.Types.VARCHAR);
			call.registerOutParameter(32,java.sql.Types.VARCHAR);
			call.registerOutParameter(33,java.sql.Types.VARCHAR);
			call.registerOutParameter(34,java.sql.Types.VARCHAR);
			call.registerOutParameter(35,java.sql.Types.VARCHAR);
			call.registerOutParameter(36,java.sql.Types.VARCHAR);
			call.registerOutParameter(37,java.sql.Types.VARCHAR);
			call.registerOutParameter(38,java.sql.Types.VARCHAR);
		//	call.registerOutParameter(39,java.sql.Types.VARCHAR);
			call.execute();

			strErrorText = call.getString(31);
			if(serverParameters.logToFile && strErrorText != null) common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) strErrorText: " + strErrorText + "\n" ) ;	
			if (strErrorText == null || strErrorText.equals(""))
			{	
				serverParameters.strCommunicationMode = call.getString(16);
				serverParameters.strFileDirectory = call.getString(17);
				serverParameters.intPortNo = call.getInt(19);								
				serverParameters.intMaxRetries   = call.getInt(21);
				serverParameters.strDbfFileType  = call.getString(9);
				serverParameters.strProtocolId   = call.getString(5);
				serverParameters.profileID   = call.getString(37);
				serverParameters.strProtocolType = call.getString(6); 
				serverParameters.strProtocolMode = call.getString(7); 	
				serverParameters.strFileNamingConvention = call.getString(8); 	
				serverParameters.strCommdataIoApi  = call.getString(12);
				serverParameters.strCommStatistics = call.getString(13);
				serverParameters.intRetryInterval  = call.getInt(20);
				serverParameters.offline = false;
			//	serverParameters.msgLayout = call.getString(39);

				serverParameters.msgLayout = getMsgLayout();

		//		serverParameters.readBeforeDateTime = "28122007 10:11";				
				serverParameters.solicitedYN = call.getString(24);
				serverParameters.strAckFileDirectory = call.getString(25);
				serverParameters.xslFileName = call.getString(26);
				serverParameters.strRestartType = call.getString(22);
				serverParameters.restartTime    = call.getString(23);
				serverParameters.boolError      = false;
				strInboundLogYN = call.getString(30);
				serverParameters.strModuleId = call.getString(14); 
				serverParameters.intWrite = (strInboundLogYN.equalsIgnoreCase("Y"))? 1:0;
				serverParameters.logToFile = (strInboundLogYN.equalsIgnoreCase("Y"))? true:false;

				common.setLogCriteria(serverParameters.logToFile);

				if("D".equalsIgnoreCase(serverParameters.strCommunicationMode))
				{
					serverParameters.odbcDBUserID	= call.getString(34);
					serverParameters.odbcDBPwd		= call.getString(35);
					serverParameters.odbcDBDriver	= call.getString(33);
					serverParameters.odbcDBURL		= call.getString(32);
					serverParameters.odbcQryNxtMsg	= call.getString(38);					
					serverParameters.odbcDBSID	= call.getString(36);					
				}
				
				if(serverParameters.logToFile) {
					common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) Log Enabled\n");
				}
				else {
					common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) Log Disabled !!!\n");
				}
				
				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) CommunicationMode["+serverParameters.strCommunicationMode+"]\n" ) ;
				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) ModuleId["+serverParameters.strModuleId+"]\n" ) ;
				if("D".equalsIgnoreCase(serverParameters.strCommunicationMode))
				{
					common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) odbcDBURL["+ serverParameters.odbcDBURL +"]\n" );
					common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) odbcDBUserID["+	serverParameters.odbcDBUserID +"]\n" );
					common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) odbcDBDriver["+ serverParameters.odbcDBDriver +"]\n" );
					common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) odbcQryNxtMsg["+ serverParameters.odbcQryNxtMsg +"]\n" );
					common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) odbcDBSID["+ serverParameters.odbcDBSID +"]\n" );
				}
				else if("F".equalsIgnoreCase(serverParameters.strCommunicationMode))
				{						
					common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) FileDirectory: "+serverParameters.strFileDirectory+"\n" ) ;	
					common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) AckFileDirectory: "+serverParameters.strAckFileDirectory+"\n" ) ;					
					common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) DbfFileType: "+serverParameters.strDbfFileType+"\n" ) ;

					if(serverParameters.strDbfFileType.equalsIgnoreCase("X"))
					{
						common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) xslFilename["+serverParameters.xslFileName+"]\n" ) ;
					}
				}
				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) intMaxRetries:["+serverParameters.intMaxRetries+"]\n");
				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) intRetryInterval["+serverParameters.intRetryInterval+"]\n");
				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) ProtocolId["+serverParameters.strProtocolId+"]\n");
				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) profileID["+serverParameters.profileID+"]\n");
				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) RestartType["+serverParameters.strRestartType+"]\n");
			
				if(!serverParameters.strRestartType.equalsIgnoreCase("N"))
					common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) restartTime["+serverParameters.restartTime+"]\n" ) ;						
			//	common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters)strAckFileDirectory: "+serverParameters.strAckFileDirectory+"\n" ) ;
				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) SolicitedYN["+serverParameters.solicitedYN+"]\n" ) ;
				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) CommdataIoApi["+serverParameters.strCommdataIoApi+"]\n" ) ;	
				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) CommStatistics["+serverParameters.strCommStatistics+"]\n" ) ;
				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) isWindowsService["+serverParameters.isWindowsService+"]\n" ) ;
				
				connDB.commit();
			}
			else
			{
				serverParameters.boolError = true;				
				connDB.rollback();
				registerError("ServerDBInterraction.getAllParameters()",strErrorText);
			}
			call.close();
		}
		catch(SQLException exceptionSQL)
		{
			serverParameters.boolError = true;	
			common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) SQLException: "+exceptionSQL+"\n" ) ;			
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionSQL) + "\n" ) ;						
			registerError("ServerDBInterraction.getAllParameters()",exceptionSQL+"");
			checkEHISDBConn();
		}
		catch(Exception exceptionQry)
		{
			commit();
			serverParameters.boolError = true;						
			common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) Exception: "+exceptionQry+"\n" ) ;			
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionQry) + "\n" ) ;						
			registerError("ServerDBInterraction.getAllParameters()",exceptionQry+"");
		}
		return serverParameters;
	}

	public void getProtocolSleepingInterval()
	{
		OracleCallableStatement  call = null;
		try
		{
			setNextSleepCalculationTime();
			String strProcedureName = "{ CALL " + EMConstants.GENERIC_PACKAGE + "GET_APPL_COMM_PROC_SLEEP_TIME(?,?,?,?,?)"+"}";
	
			call =(OracleCallableStatement) connDB.prepareCall(strProcedureName);
  			
			call.setString(1,strProtocalLinkId);			
			call.registerOutParameter(2,java.sql.Types.VARCHAR);
			call.registerOutParameter(3,java.sql.Types.VARCHAR);
			call.registerOutParameter(4,java.sql.Types.VARCHAR);
			call.registerOutParameter(5,java.sql.Types.VARCHAR);
			call.execute();
			String delimiterOfDate = ";";
			String strTodaySleepYN = call.getString(2)	;
			String strFromArrayDate = call.getString(3)	;
			String strToArrayDate = call.getString(4)	;
		
			if ((strTodaySleepYN == null) || (strTodaySleepYN.equalsIgnoreCase("null")))
			{				
				serverParameters.isSleepEnabledTodayProtocol = false;
				strTodaySleepYN = "N";
			}

			try 
			{
			  if(strTodaySleepYN.equalsIgnoreCase("Y")) 
			  {
				  serverParameters.isSleepEnabledTodayProtocol = true;
				  serverParameters.strSleepFromProtocol = strFromArrayDate.split(delimiterOfDate);
				  serverParameters.strSleepToProtocol = strToArrayDate.split(delimiterOfDate);
				  convertToJavaLongTimeProtocol();
			  }
			  else
			  {
				  serverParameters.isSleepEnabledTodayProtocol = false;
			  }
			} 
			catch(Exception ex) 
			{
				common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(ex) + "\n");
			} 
			finally 
			{
			}

			call.close();
		}
		catch(SQLException exceptionSQL)
		{		
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionSQL) + "\n");
			try
			{
				call.close();
			}
			catch(Exception e)
			{
				System.out.println("ECEPT(OJ");
			}		
			checkEHISDBConn();
			//registerError("DBInterraction.getAllParameters()",exceptionSQL+"");
		}
		catch(Exception exceptionQry)
		{		
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionQry) + "\n");
			try
			{
				call.close();							
			}
			catch(Exception e)
			{
				System.out.println("ECEPT(OJ");
			}		
			checkEHISDBConn();
			//registerError("DBInterraction.getAllParameters()",exceptionQry+"");				
		}
	}
	
	public void convertToJavaLongTimeProtocol()
	{
		GregorianCalendar gcTemp = new GregorianCalendar();
		String strTimePortion[] = new String[2];
		try
		{
			gcTemp.set(GregorianCalendar.MILLISECOND,0);
			gcTemp.set(GregorianCalendar.SECOND,0);
			for (int j = 0; j < serverParameters.strSleepFrom.length; j++)
			{
				strTimePortion = serverParameters.strSleepFromProtocol[j].split(":");
				gcTemp.set(GregorianCalendar.HOUR_OF_DAY, Integer.parseInt(strTimePortion[0]));
				gcTemp.set(GregorianCalendar.MINUTE, Integer.parseInt(strTimePortion[1]));
				serverParameters.longSleepFromProtocol[j] = gcTemp.getTimeInMillis();

				strTimePortion = serverParameters.strSleepToProtocol[j].split(":");
				gcTemp.set(GregorianCalendar.HOUR_OF_DAY, Integer.parseInt(strTimePortion[0]));
				gcTemp.set(GregorianCalendar.MINUTE, Integer.parseInt(strTimePortion[1]));
				serverParameters.longSleepToProtocol[j] = gcTemp.getTimeInMillis();
			}
		}
		catch(Exception exp)
		{
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
	}

	public void getSleepingTimeInterval()
	{
		OracleCallableStatement  call = null;
		try
		{
			this.setNextSleepCalculationTime();
			String strProcedureName = "{"+ strPackageName+"get_comm_process_sleep_time(?,?,?,?)"+"}";		

			call = (OracleCallableStatement) connDB.prepareCall(strProcedureName);

			call.registerOutParameter(1,java.sql.Types.VARCHAR);
			call.registerOutParameter(2,java.sql.Types.VARCHAR);
			call.registerOutParameter(3,java.sql.Types.VARCHAR);
			call.registerOutParameter(4,java.sql.Types.VARCHAR);
			call.execute();

			String delimiterOfDate = ";";
			String strTodaySleepYN = call.getString(1)	;
			String strFromArrayDate = call.getString(2)	;
			String strToArrayDate = call.getString(3)	;

			if ((strTodaySleepYN == null) || (strTodaySleepYN.equalsIgnoreCase("null")))
			{
				serverParameters.isSleepEnabledToday = false;
				strTodaySleepYN = "N";
			}

			try 
			{				  
				if (strTodaySleepYN.equalsIgnoreCase("Y")) 
				{
					serverParameters.isSleepEnabledToday = true;
					serverParameters.strSleepFrom = strFromArrayDate.split(delimiterOfDate);
					serverParameters.strSleepTo = strToArrayDate.split(delimiterOfDate);
					convertToJavaLongTime();
				}
				else
				{
					serverParameters.isSleepEnabledToday = false;
				}
				// common.fileOutput( serverParameters.strLogFile, "(OutboundClientDBInteraction:getSleepingTimeInterval) Sleep Enabled/Disabled "+strTodaySleepYN+" strFromArrayDate "+strFromArrayDate+" strToArrayDate "+strToArrayDate+"\n" ) ;

			} 
			catch (Exception ex) 
			{ 				  
			} 
			finally 
			{				
			}				
		}
		catch(SQLException exceptionSQL)
		{			
			common.fileOutput( serverParameters.strLogFile, "(OutboundClientDBInteraction:getSleepingInterval) "+exceptionSQL );
			checkEHISDBConn();
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionSQL) + "\n");
		//	registerError("DBInterraction.getAllParameters()",exceptionSQL+"");
		}
		catch(Exception exceptionQry)
		{		
			common.fileOutput(serverParameters.strLogFile, "(OutboundClientDBInteraction:getSleepingInterval) "+exceptionQry );
			checkEHISDBConn();
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionQry) + "\n");
		//	registerError("DBInterraction.getAllParameters()",exceptionQry+"");			
		}
		finally
		{
			closeResource(null, call);					
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
			for (int j = 0; j < serverParameters.strSleepFrom.length; j++)
			{
				strTimePortion = serverParameters.strSleepFrom[j].split(":");
				gcTemp.set(GregorianCalendar.HOUR_OF_DAY,Integer.parseInt(strTimePortion[0]));
				gcTemp.set(GregorianCalendar.MINUTE,Integer.parseInt(strTimePortion[1]));
				serverParameters.longSleepFrom[j] = gcTemp.getTimeInMillis();

				strTimePortion = serverParameters.strSleepTo[j].split(":");
				gcTemp.set(GregorianCalendar.HOUR_OF_DAY,Integer.parseInt(strTimePortion[0]));
				gcTemp.set(GregorianCalendar.MINUTE,Integer.parseInt(strTimePortion[1]));
				serverParameters.longSleepTo[j] = gcTemp.getTimeInMillis();
			}
		}
		catch(Exception exp) { }
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
			serverParameters.nextSleepCalculationTimeProtocol = gcTemp.getTimeInMillis();
			serverParameters.nextSleepCalculationTime = gcTemp.getTimeInMillis();
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		} 
	}

	public synchronized boolean canIStop()
	{
		try
		{		
			if(!serverParameters.isDBDown)
			{
				String strQry = "SELECT process_status FROM xh_comm_process WHERE process_id = " + intProcessId;
				Statement stmt = connDB.createStatement();
				ResultSet rset = stmt.executeQuery(strQry);

				while (rset.next())
				{
					strStopYN = rset.getString(1);
				}

				stmt.close();

				if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:canIStop) Process Status:" + strStopYN + "\n" );				
			}

			if (strStopYN.equals("C")) return (true);
			else return (false);

		}
		catch(SQLException exceptionSQL)
		{			
			common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:canIStop) SQLException: "+exceptionSQL+"\n" ) ;
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionSQL) + "\n" ) ;			
			checkEHISDBConn();
		}
		catch(Exception exceptionQry)
		{			
			registerError("DBInterraction.canIStop",exceptionQry+"");
			common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:canIStop) Exception:"+exceptionQry+"\n" ) ;	
			common.fileOutput( serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionQry) + "\n" ) ;
		}
		return(false);
		
	}		
	public void closeDBconn()
	{	
		try
		{
			if(connDB != null)
			{
				connDB.commit();
				connDB.close();
				connDB = null;
				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:closeDBconn) DB Conn Closed\n" ) ;
			}
		}
		catch(Exception exceptionCloseDB)
		{
			common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:closeDBconn) Exception:"+exceptionCloseDB.getMessage()+"\n" ) ;			
		}
	}	
	public void closeExtDBconn()
	{	
		try
		{
			if(externalDBConn != null)
			{
				externalDBConn.commit();
				externalDBConn.close();
			}
		}
		catch(Exception exceptionCloseDB)
		{
			common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:closeExtDBconn) Exception:"+exceptionCloseDB.getMessage()+"\n" ) ;
		}
	}

	public synchronized void processQueryMessage(String msg)
	{	
		String strErrorText = "0";
		
		String strProcedureName = "{"+ strPackageName +"create_lob(?,?)"+"}";
		strMessage = "";
		
		boolean boolRead = true;
		boolFatalError = false;
		
		if(serverParameters.logToFile) common.fileOutput(serverParameters.strInboundLog, "(InboundServerDBInteraction:processQueryMessage) Received Message :"+msg+"\n" ) ;
		
		try
		{
			OracleCallableStatement call1 =(OracleCallableStatement) connDB.prepareCall(strProcedureName);
			call1.registerOutParameter(1,java.sql.Types.CLOB);
			call1.registerOutParameter(2,java.sql.Types.VARCHAR);
			call1.execute ();
			strErrorText = call1.getString(2);
			CLOB clobMessage = null;

			if (strErrorText == null) 
			{
				clobMessage = (oracle.sql.CLOB) call1.getClob(1) ;
				connDB.commit();	
			}
			else
			{
				call1.close();
				connDB.rollback();
				throw new Exception("Create Lob failed : "+strErrorText);	
			}

			Writer outstream = clobMessage.getCharacterOutputStream();
			outstream.write(msg.toCharArray());
			outstream.close();
			call1.close();
			strErrorText = null;	
			Clob clobSentMessage = null;		
			
		//	strProcedureName = "{"+ strPackageName2+"process_Query_message(?,?,?,?,?,?,?,?,?,?,?)"+"}";
			strProcedureName = "{ call "+ serverParameters.strCommdataIoApi +"(?,?,?,?,?,?,?,?,?,?,?,?)"+"}";

			OracleCallableStatement call2 = (OracleCallableStatement) connDB.prepareCall(strProcedureName);

			call2.setString(1,strApplicationId);
			call2.setString(2,strFacilityId);
			call2.setString(3,strClientId);					
			call2.setInt(4,intProcessId);
			call2.setClob(5,clobMessage); // Setting the clob Variable			
			call2.setString(9,strProtocalLinkId);

			call2.registerOutParameter(6,java.sql.Types.VARCHAR);
			call2.registerOutParameter(7,java.sql.Types.VARCHAR);
			call2.registerOutParameter(8,java.sql.Types.VARCHAR);
			call2.registerOutParameter(10,java.sql.Types.VARCHAR);
			call2.registerOutParameter(11,java.sql.Types.CLOB);
			call2.registerOutParameter(12,java.sql.Types.VARCHAR);
			
			//if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:processQueryMessage) process_Query_message: calling procedure : "+strProcedureName+"\n" ) ;
			call2.execute();

			strErrorText = call2.getString(12);			
						
			if (strErrorText == null)
			{
				strErrorText = call2.getString(12);
				strQueryId = call2.getString(6);
				strMessageId = call2.getString(7);
				strEventType = call2.getString(8);			
				strProcessStartTime = call2.getString(10);
				clobSentMessage = (oracle.sql.CLOB)call2.getClob(11);

				intSentMessageLength = msg.length();
				serverParameters.totalMessages = serverParameters.totalMessages + 1;
				
				//if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:processQueryMessage) strQueryId :"+strQueryId+" strMessageId :"+strMessageId+" strEventType :"+strEventType+" strProcessStartTime :"+strProcessStartTime+"\n" ) ;
				
				if(clobSentMessage != null)
				{
					if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:processQueryMessage) Acknowledgement Generated for MessageID :"+ strMessageId +"\n");				
					Reader readerMsg = clobSentMessage.getCharacterStream(); 
					while(boolRead == true)
					{
						char charMsg[] = new char[intTotalWidth];
						int intData = readerMsg.read(charMsg);
						if (intData > 0)
						{							
							strMessage += String.valueOf(charMsg,0,intData);							
						}
						else
						{
							boolRead = false;
							this.ackMessageList.add(strMessage);													
							break;
						}						
					}
					readerMsg.close();
					this.ackSent = false;
				}
				else
				{
					if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:processQueryMessage) Acknowledgement not generated...\n" );
				}
													
				boolCanSend = true;
				connDB.commit();				
			}
			else
			{
				if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:processQueryMessage) strErrorText:"+strErrorText+"\n" ) ;
				strQueryId = call2.getString(6);	//5
				strMessageId = call2.getString(7);   //6	
				strEventType = call2.getString(8);		//7
				registerError("PROCESS_QUERY_MESSAGE",strErrorText);			
			}
			call2.close();
		}
		catch(SQLException exceptionSQL)
		{						
			common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:processQueryMessage) SQLException: "+exceptionSQL+"\n" ) ;
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionSQL) + "\n" ) ;			
			registerError("DBInteraction.processQueryMessage()",exceptionSQL+"");
			checkEHISDBConn();
		}		
		catch(Exception exceptionQry)
		{
			
		//	System.out.println(" Exception serverDB.processQueryMessage"+exceptionQry);
			registerError("serverDB.processQueryMessage()",exceptionQry+"");
			boolFatalError = true;
			common.fileOutput( serverParameters.strExceptionLogFile, "(InboundServerDBInteraction:processQueryMessage "+stackTrace.getLineNumber()+" )Exception:"+exceptionQry+"\n" ) ;
			common.fileOutput( serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionQry) + "\n" ) ;
		}
	}
	
	public synchronized void updateQueryMessageStatus(String strCommStatistics, String status)
	{
		String strErrorText = "0";
		
		try
		{	
		//	if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:updateQueryMessageStatus)...\n" ) ;
			/**********  Parameters **************************************/
			String strProcedureName = "{ call " + strCommStatistics + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" + "}";
			OracleCallableStatement  call =(OracleCallableStatement) connDB.prepareCall(strProcedureName);
			call.setString(1,strApplicationId);
			call.setString(2,strFacilityId);
			call.setString(3,strMessageId);
			call.setString(4,strEventType);
			call.setInt(5,intProcessId);
			call.setString(6,serverParameters.strModuleId);
			call.setInt(7,intSentMessageLength);
			call.setString(8,strProcessStartTime);
			call.setString(9,strProcessEndTime);
			call.setString(10,"");
			call.setInt(11,serverParameters.totalMessages);
			call.setString(12,status);
			call.setString(13,"S");
			call.setString(14,"");
			call.setString(15,strProtocalLinkId);
			call.setString(16,strQueryId);			
			call.registerOutParameter(17,java.sql.Types.VARCHAR);

			call.execute ();
			strErrorText = call.getString(17);
			
			if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:updateQueryMessageStatus)strErrorText:"+strErrorText+"\n" ) ;			
			
			if (strErrorText == null || strErrorText.equals("") )
			{
				connDB.commit();		
			}
			else
			{
				// Write Error log
				connDB.rollback();
				registerError("DBInterraction.updateQueryMessage()",strErrorText);
			}
			call.close();
		}
		catch(SQLException exceptionSQL)
		{			
			common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:updateQueryMessageStatus) SQLException: "+exceptionSQL+"\n" ) ;
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionSQL) + "\n" ) ;			
			checkEHISDBConn();
		}
		catch(Exception exceptionQry)
		{
			commit();
			common.fileOutput( serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionQry) + "\n" ) ;
			registerError("DBInterraction.updateApplicationMessageStatus()",exceptionQry+"");
			common.fileOutput( serverParameters.strExceptionLogFile, "(InboundServerDBInteraction:updateQueryMessageStatus)Exception:"+exceptionQry+"\n" ) ;			
		}
	}

	public synchronized void registerError(String caller,String error)
	{
		String strProcedureName = "{"+ strErrorPackageName+"register_error(?,?,?,?,?,?)"+"}";
		try
		{
			connDB.rollback();
			strTotalParam = " strApplicationId ="+ strApplicationId+
					" strFacilityId ="+ strFacilityId+
					" intProcessId = "+intProcessId+
					" strProcessType = "+strProcessType+
					" strProcessEndTime ="+strProcessEndTime+
					" strQueryId = "+strQueryId +
					" strMessageId = "+strMessageId+
					" strEventType = "+strEventType;

		//	System.out.println("strTotalParam "+strTotalParam);

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
			commit();
		}
	}

	public void updateProcessStatus(String sts)
	{
		Statement stmt = null;
		try
		{
			if (connDB == null || serverParameters.isDBDown){
				makeDBConnection();
				if (serverParameters.isDBDown) return;
			}
			stmt = connDB.createStatement();
			String strUpdQry = "UPDATE  XH_COMM_PROCESS SET "+
						"  PROCESS_STATUS = '"+sts+ "'"+
						"  WHERE PROCESS_ID="+intProcessId;
									
			int i = stmt.executeUpdate(strUpdQry);

			if(i > 0)  {
				common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:updateProcessStatus) Process Status: " + sts + "\n" );
				connDB.commit();
			}
		}
		catch(SQLException exceptionSQL) {			
			common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:updateProcessStatus) SQLException: "+exceptionSQL+"\n" ) ;
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionSQL) + "\n" ) ;			
			checkEHISDBConn();
		}
		catch(Exception exceptionQry) {			
			registerError("DBInterraction.updateProcessStatus",exceptionQry+"");
			common.fileOutput( serverParameters.strExceptionLogFile, "(InboundServerDBInteraction:updateProcessStatus)Exception:"+exceptionQry+"\n" ) ;
		}
		finally {
			SQLUtil.closeStatement(stmt);
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
			System.out.println(" Database connection  DBInteraction.commit) "+exceptionCommitDB);
		}
	}

	public void rollback()
	{
		try
		{
			connDB.rollback();
		}
		catch(Exception exceptionCommitDB)
		{
			System.out.println(" Database connection  DBInteraction.rollback "+exceptionCommitDB);
		}
	}

	/**
	* Method retrieves file name dynamically for file communication
	**/
	public synchronized String fileNamingConvention(String procedurename)
	{	
	//	String strProcedureName = "{"+ strErrorPackageName+" "+procedurename+"(?)}";
	//	String strProcedureName = "{? = call "+ strErrorPackageName+"XH_TEST1}";
		String query = "select "+procedurename+" from dual";		
		String fileformat = "";
		try
		{
	//		OracleCallableStatement call =(OracleCallableStatement) connDB.prepareCall(strProcedureName);
	//		call.registerOutParameter(1,OracleTypes.CURSOR);
	//		call.executeUpdate();
			Statement stmt = connDB.createStatement();
			ResultSet rset = null;
			rset = stmt.executeQuery(query);
			if(rset.next())
			{
				fileformat = rset.getString(1);			
			}
			connDB.commit();
	//		call.close();
			stmt.close();
		}
		catch(SQLException exceptionSQL)
		{			
			common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:fileNamingConvention) SQLException: "+exceptionSQL+"\n" ) ;
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionSQL) + "\n" ) ;			
			checkEHISDBConn();
		}
		catch (Exception exception)
		{
			common.fileOutput( serverParameters.strExceptionLogFile, "(InboundServerDBInteraction:fileNamingConvention)Exception:- "+exception+"\n" ) ;
			System.out.println("Exception in fileNamingConvention "+exception);
			common.fileOutput( serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exception) + "\n" ) ;
		}
	//	System.out.println("FILE NAME "+fileformat);
		return 	fileformat;

	}// fileNamingConvention(String procedurename)
	 
	/**
	 * Method to retrieve the Message delimiters
	 */
	public void getMessageDelimiters(InboundServerParameters serverParameters)
	{
		String sqlProcedure = "call "+XHSTANDARD+".XH_STANDARD_SPECIAL_CHAR(?,?,?,?,?,?,?)";
		try
		{
			OracleCallableStatement callableStatement =(OracleCallableStatement) connDB.prepareCall(sqlProcedure);
				
			callableStatement.setString(1,serverParameters.strProtocalLinkId);
			callableStatement.registerOutParameter(2,java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3,java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(4,java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(5,java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(6,java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(7,java.sql.Types.VARCHAR);
			callableStatement.execute();

			serverParameters.messageStart = callableStatement.getString(2);
			serverParameters.messageEnd = callableStatement.getString(3);
			serverParameters.messageSegmentStart = callableStatement.getString(4);
			serverParameters.messageSegmentEnd = callableStatement.getString(5);
			serverParameters.fieldSeperator = callableStatement.getString(6);
			serverParameters.standardCode = callableStatement.getString(7);
		}
		catch(SQLException exceptionSQL)
		{			
			common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:getMessageDelimiters) SQLException: "+exceptionSQL+"\n" ) ;
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionSQL) + "\n" ) ;			
			checkEHISDBConn();
		}
		catch(Exception exception)
		{
			registerError("DBInterraction.getMessageDelimiters",exception+"");
			common.fileOutput(serverParameters.strExceptionLogFile, "(InboundServerDBInteraction:getMessageDelimiters)Exception:- "+exception+"\n" ) ;
			common.fileOutput( serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exception) + "\n" ) ;
		}
	}
	
	/**
	 * Method to get any external database connection. Used mainly for ODBC Communication
	 */
	public boolean getExternalDBConnection()
	{
		boolean dbStatus = false;
		try
		{
			Class.forName(serverParameters.odbcDBDriver);
			externalDBConn = DriverManager.getConnection(serverParameters.odbcDBURL, serverParameters.odbcDBUserID, serverParameters.odbcDBPwd);
			common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:getExternalDBConnection) External DB Conn Successful...\n" );
			externalDBConn.setAutoCommit(false);		
			dbStatus = true;			
		}
		catch (Exception exp)
		{
			common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getExternalDBConnection) External DB Conn failed...\n" );
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp)+"\n" ) ;
		}
		return dbStatus;
	}
	private void setExtMedUserRole()
	{	
		CallableStatement  call = null;
		Statement stmt = null; 
		ResultSet rset = null;
		try
		{
			String strParamRole = "";
			String strPasswd = "";
			String strProcedureName = "{ call DBMS_SESSION.SET_ROLE(?) }";
			String strQry = "SELECT APP_PASSWORD.DECRYPT(ORA_ROLE_PASSWORD) FROM SM_ORA_ROLE Where ORA_ROLE_ID = 'MEDUSERS'";			
			
			try
			{
				stmt = externalDBConn.createStatement();
				rset = stmt.executeQuery(strQry);

				while (rset.next())
				{
					strPasswd = rset.getString(1);
				}						
			}
			catch(Exception expSql)
			{
				common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:setExtMedUserRole) Exception "+expSql+"\n" );
				common.fileOutput( serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(expSql)+"\n" ) ;				
			}

			strParamRole = "MEDUSERS IDENTIFIED BY "+strPasswd;
			call =(CallableStatement) externalDBConn.prepareCall(strProcedureName);
			call.setString(1,strParamRole);
			call.execute();			
		}
		catch(Exception expCal)
		{
			common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:setExtMedUserRole) Exception"+expCal+"\n" );
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(expCal)+"\n" ) ;
		}
		finally
		{
			try
			{
				if(call != null) call.close();
				if(stmt != null) stmt.close();
				if(rset != null) rset.close();
			}
			catch(Exception fexp){}
		}
	}

	public void checkEHISDBConn()
	{
		Statement stmt = null;
		ResultSet rset = null;
		try
		{
			stmt = connDB.createStatement();
			String strQry = "SELECT 1 FROM DUAL";
			rset = stmt.executeQuery(strQry);
			if (rset.next()) { }			
			serverParameters.isDBDown = false;
		}
		catch(Exception exceptionQry)
		{
			common.fileOutput(serverParameters.strLogFile, "(serverParameters.strLogFile:checkEHISDBConn) "+exceptionQry+"\n" );
			serverParameters.isDBDown = true;
		}
		finally
		{
			try
			{
				if(rset != null) rset.close();
				if(stmt != null) stmt.close();
			}
			catch (Exception exp)
			{
			}			
		}
	}

	public void checkExeDBConnection(String database)
	{
		Statement stmt = null;
		ResultSet rset = null;
		
		try
		{
			stmt = externalDBConn.createStatement();
			String strQry = CommonUtil.getPropertyVal(EMConstants.DBCONN_CHK_QRY_FILE, database);
			rset = stmt.executeQuery(strQry);
			serverParameters.isExternalDBDown = false;
		}
		catch(Exception exceptionQry)
		{
			common.fileOutput(serverParameters.strLogFile, "(serverParameters.strLogFile:checkExeDBConnection) "+exceptionQry.getMessage()+"\n" );
			serverParameters.isExternalDBDown = true;
		}
		finally
		{
			closeResource(rset, stmt);			
		}
	}

	public boolean updatePDFFile(String histRecType,String contrSysID,String accessionNo,String contrSysEventCode,String eventTitle,String pdfFileName)
	{
		PreparedStatement pstmt = null;
		PreparedStatement queryPDFStmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		FileInputStream pdfInputStream = null;
		File pdfFile = null;

		String insertPDF = "INSERT INTO CR_ENCOUNTER_DETAIL_OBJ(HIST_REC_TYPE, CONTR_SYS_ID, ACCESSION_NUM, CONTR_SYS_EVENT_CODE, EVENT_TITLE, HIST_DATA, OBJTYPE, FILE_NAME) VALUES (?,?,?,?,?,?,?,?)";
		String updatePDF = "UPDATE CR_ENCOUNTER_DETAIL_OBJ SET HIST_DATA = ? WHERE HIST_REC_TYPE = ?"+
							" AND CONTR_SYS_ID = ?" +
							" AND ACCESSION_NUM = ?" +
							" AND CONTR_SYS_EVENT_CODE = ?";
		String queryPDF = "SELECT 1 FROM CR_ENCOUNTER_DETAIL_OBJ WHERE HIST_REC_TYPE = ?"+
							" AND CONTR_SYS_ID = ?" +
							" AND ACCESSION_NUM = ?" +
							" AND CONTR_SYS_EVENT_CODE = ?";
		String updateCREncounterTab = "UPDATE cr_encounter_detail SET ext_image_appl_id = 'LABC' " +
									"WHERE hist_rec_type = '"+histRecType+"' AND contr_sys_id  = '"+contrSysID+"' " +
									"AND accession_num = '"+accessionNo+"' AND contr_sys_event_code = '"+contrSysEventCode+"' " +
									"AND ext_image_appl_id IS NOT NULL";

		boolean recInserted = false;
		try
		{
			if("OT".equals(contrSysID))
			{
				updateCREncounterTab = "UPDATE cr_encounter_detail SET ext_image_appl_id = 'DOCUL' " +
						"WHERE hist_rec_type = '"+histRecType+"' AND contr_sys_id  = '"+contrSysID+"' " +
						"AND accession_num = '"+accessionNo+"' AND contr_sys_event_code = '"+contrSysEventCode+"' " +
						"AND ext_image_appl_id IS NOT NULL";
			}
			
			if("CCISPI".equals(serverParameters.strProtocolId)) // COMMENT1204131542
			{
				updatePDF = "UPDATE CR_ENCOUNTER_DETAIL_OBJ SET HIST_DATA = ? WHERE FILE_NAME = ?";
				queryPDF = "SELECT 1 FROM CR_ENCOUNTER_DETAIL_OBJ WHERE file_name = ?";
			}
			
			int bufferSize;
		    byte[]  byteBuffer;
		    int bytesRead = 0;
		    int totBytesRead = 0;
		    int totBytesWritten = 0;
		    
			BLOB blob = createEmptyBlob();			
			OutputStream blobOutputStream = blob.getBinaryOutputStream();
			bufferSize = blob.getBufferSize();
		    byteBuffer = new byte[bufferSize];
		    
			pdfFile = new File(pdfFileName);
			pdfInputStream = new FileInputStream(pdfFile);
			String pdfFilename = pdfFile.getName();
			pdfFilename = CommonUtil.emSubstring(pdfFilename, 0, pdfFilename.lastIndexOf("."));
			
			while ((bytesRead = pdfInputStream.read(byteBuffer)) != -1) 
			{
				// After reading a buffer from the binary file, write the contents
				// of the buffer to the output stream using the write()
				// method.
				blobOutputStream.write(byteBuffer, 0, bytesRead);
				totBytesRead += bytesRead;
				totBytesWritten += bytesRead;
			}			  
			blobOutputStream.close();

			queryPDFStmt = connDB.prepareStatement(queryPDF);
			
			if(!"CCISPI".equals(serverParameters.strProtocolId))
			{
				queryPDFStmt.setString(1,histRecType);
				queryPDFStmt.setString(2,contrSysID);
				queryPDFStmt.setString(3,accessionNo);
				queryPDFStmt.setString(4,contrSysEventCode);
			}
			else
			{
				queryPDFStmt.setString(1,pdfFilename);
			}

			rs = queryPDFStmt.executeQuery();

			if(rs.next())
			{
				pstmt = connDB.prepareStatement(updatePDF);
				pstmt.setBlob(1, blob);
				if(!"CCISPI".equals(serverParameters.strProtocolId))
				{
					pstmt.setString(2,histRecType);
					pstmt.setString(3,contrSysID);
					pstmt.setString(4,accessionNo);
					pstmt.setString(5,contrSysEventCode);
				}
				else
				{
					pstmt.setString(2,pdfFilename);
				}
			}
			else
			{
				pstmt = connDB.prepareStatement(insertPDF);
				pstmt.setString(1,histRecType);
				pstmt.setString(2,contrSysID);
				pstmt.setString(3,accessionNo);
				pstmt.setString(4,contrSysEventCode);
				pstmt.setString(5,eventTitle);
			//	pstmt.setBinaryStream(6,pdfInputStream,(int)pdfFile.length());
				pstmt.setBlob(6, blob);
				pstmt.setString(7,"application/pdf");
				pstmt.setString(8,pdfFilename);
			}

			int recCount = pstmt.executeUpdate();

			if(recCount > 0)
			{
				recInserted = true;
				stmt = connDB.createStatement();
				stmt.executeUpdate(updateCREncounterTab);				
			}
			
			connDB.commit();
		}
		catch(Exception exp)
		{			
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;		
		}
		finally
		{
			try
			{	
				if(rs != null) rs.close();
				if(queryPDFStmt != null) queryPDFStmt.close();				
				if(pstmt != null) pstmt.close();
				if(stmt != null) stmt.close();
				if(pdfInputStream != null) pdfInputStream.close();
			}
			catch(Exception exp){}
		}
		return recInserted;
	}
	
	public boolean updateT02PDFFile(String patientId, String encounterId, String pdfEncData, String contrSysEventCode)
	{
		PreparedStatement pstmt = null;
		PreparedStatement queryPDFStmt = null;
		Statement stmt = null;
		ResultSet rs = null;	
		
		FileInputStream pdfInputStream = null;
		File pdfFile = null;
		
		String accessionNum = "", pdfData = ""; // contrSysEventCode = "DS03",
		String facilityID = "", patientClass = "",  eventCode = "", eventGroup = "RENA";
		String histRecType = "CLNT", contrSysID = "CA",  eventTitle = "TDMS - PDF";
		
		//Added by Sethu for ML-MMOH-CRF-1885 on 03/02/2024
		String performedById = "TDMS", addedById = "APPLUSER", resultStr = "", eventClass = "CLI$";
		
		int insertRecDetCount = 0, insertRecObjCount = 0, updRecObjCount = 0;
		
		/*
		 * Commented by Sethu for ML-MMOH-CRF-1885 on 03/02/2024
		
		String insertCrDetailPDF = " Insert into CR_ENCOUNTER_DETAIL " +
									"(HIST_REC_TYPE, CONTR_SYS_ID, ACCESSION_NUM, CONTR_SYS_EVENT_CODE, PATIENT_ID, FACILITY_ID, " +
									"PATIENT_CLASS, ENCOUNTER_ID, EVENT_CLASS, EVENT_CODE, EVENT_GROUP, EVENT_DATE, " +
									"HIST_DATA_TYPE, NUM_DATA_YN, HIST_STORAGE_IND, EXT_IMAGE_APPL_ID, PERFORMED_BY_ID, AUTHORIZED_BY_ID, " +
									"ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, " +
									"EVENT_CODE_TYPE, EVENT_GROUP_TYPE) " +
							" Values ('CLNT', 'CA', ?, ?, ?, ?, " +
									" ?, ?, 'CLI$', ?, ?, SYSDATE, " +
									"'HTM', 'N', 'E', 'DOCUL', 'TDMS', 'TDMS', " +
									"'APPLUSER', SYSDATE, ?, 'APPLUSER', SYSDATE, ?, " +
									"'CA', 'CA')";
									
		*/
		
		//Added by Sethu for ML-MMOH-CRF-1885 on 03/02/2024
		
		String insertCrDetailPDF = " Insert into CR_ENCOUNTER_DETAIL " +
				"(HIST_REC_TYPE, CONTR_SYS_ID, ACCESSION_NUM, CONTR_SYS_EVENT_CODE, PATIENT_ID, FACILITY_ID, " +
				"PATIENT_CLASS, ENCOUNTER_ID, EVENT_CLASS, EVENT_CODE, EVENT_GROUP, EVENT_DATE, " +
				"HIST_DATA_TYPE, NUM_DATA_YN, HIST_STORAGE_IND, EXT_IMAGE_APPL_ID, PERFORMED_BY_ID, AUTHORIZED_BY_ID, " +
				"ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, " +
				"EVENT_CODE_TYPE, EVENT_GROUP_TYPE, RESULT_STR) " +
		" Values ('CLNT', 'CA', ?, ?, ?, ?, " +
				" ?, ?, ?, ?, ?, SYSDATE, " +
				"'HTM', 'N', 'E', 'DOCUL', ?, ?, " +
				"?, SYSDATE, ?, ?, SYSDATE, ?, " +
				"'CA', 'CA', ?)";
		
		String insertCrDetailObjPDF = "INSERT INTO CR_ENCOUNTER_DETAIL_OBJ" +
				"(HIST_REC_TYPE, CONTR_SYS_ID, ACCESSION_NUM, CONTR_SYS_EVENT_CODE, EVENT_TITLE, HIST_DATA, OBJTYPE, FILE_NAME) " +
				"VALUES (?,?,?,?,?,?,?,?)";
		
		String getAccessionNumQry = "select 'CN'||to_char(sysdate,'YY')||'$'||lpad(ca_note_type_seq.nextval,16,'0') accession_num from dual ";
		
		
		String updateObjPDF = "UPDATE CR_ENCOUNTER_DETAIL_OBJ SET HIST_DATA = ? WHERE HIST_REC_TYPE = ?"+
							" AND CONTR_SYS_ID = ?" +
							" AND ACCESSION_NUM = ?" +
							" AND CONTR_SYS_EVENT_CODE = ?";
		
		String queryEncDetail = "SELECT FACILITY_ID, PATIENT_CLASS FROM PR_ENCOUNTER a WHERE PATIENT_ID = ? and  encounter_id = ?";
		
		//Added by Sethu for ML-MMOH-CRF-1885 on 03/02/2024
		String queryNoteType = "select nvl(event_class,'') event_class, nvl(note_group_id,'') note_group_id  from ca_note_type where note_type = ? ";
		PreparedStatement queryNoteTypeStmt = null;
		ResultSet rsNoteType = null;
		

		boolean recInserted = false;
		try
		{
			
			int bufferSize;
		    byte[]  byteBuffer;
		    int bytesRead = 0;
		    int totBytesRead = 0;
		    int totBytesWritten = 0;
		    
			BLOB blob = createEmptyBlob();	
			OutputStream blobOutputStream = blob.getBinaryOutputStream();
			bufferSize = blob.getBufferSize();
		    byteBuffer = new byte[bufferSize];		   
			
			common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:updateT02PDFFile)PDF Encoded Data "+pdfEncData+"\n" ) ;
			
			pdfFile = new File(pdfEncData);
			pdfInputStream = new FileInputStream(pdfFile);
			String pdfFilename = pdfFile.getName();
			pdfFilename = CommonUtil.emSubstring(pdfFilename, 0, pdfFilename.lastIndexOf("."));
			
			common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:updateT02PDFFile)PDF File Name "+pdfFilename+"\n" ) ;
			
			while ((bytesRead = pdfInputStream.read(byteBuffer)) != -1) 
			{
				// After reading a buffer from the binary file, write the contents
				// of the buffer to the output stream using the write()
				// method.
				blobOutputStream.write(byteBuffer, 0, bytesRead);
				totBytesRead += bytesRead;
				totBytesWritten += bytesRead;
			}			  
			blobOutputStream.close();
			
			//pdfData = new String(DatatypeConverter.parseBase64Binary(pdfEncData));
			
			/*
			
			byte[] decodeResult = new BASE64Decoder().decodeBuffer(pdfEncData);
			
			blobOutputStream.write(decodeResult);					  
			blobOutputStream.close();
			
			*/
			
			common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:updateT02PDFFile) PDF Data "+pdfData+"\n" ) ;		
			
			try
			{
			    pstmt = connDB.prepareStatement(queryEncDetail);
			    pstmt.setString(1, patientId);	
			    pstmt.setString(2, encounterId);
			    
			    rs = pstmt.executeQuery();		    
			    	
			    while(rs.next()) 
			    {
			    	facilityID = rs.getString("FACILITY_ID");
			    	patientClass = rs.getString("PATIENT_CLASS");			    	
			    }
			}
			catch (Exception exp)
			{
				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:updateT02PDFFile) Exception "+exp+"\n" ) ;
				common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;		    
			}			
			
			try
			{			
				queryPDFStmt = connDB.prepareStatement(getAccessionNumQry);
				rs = queryPDFStmt.executeQuery();
	
				if(rs.next())
				{
					accessionNum = rs.getString("accession_num");
				}
				
				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:updateT02PDFFile) Accession Number "+accessionNum+"\n" ) ;
			}
			catch (Exception exp)
			{
				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:updateT02PDFFile) Exception "+exp+"\n" ) ;
				common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;		    
			}			

			try {
			
				pstmt = connDB.prepareStatement(insertCrDetailPDF);
				pstmt.setString(1,accessionNum);
				pstmt.setString(2,contrSysEventCode);
				pstmt.setString(3,patientId);
				pstmt.setString(4,facilityID);
				pstmt.setString(5,patientClass);
				pstmt.setString(6,encounterId);
				/*
				 * Commented by Sethu for ML-MMOH-CRF-1885 on 03/02/2024
				pstmt.setString(7,contrSysEventCode);
				pstmt.setString(8,eventGroup);
				*/
				
				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:updateT02PDFFile) serverParameters.strProtocolId "+serverParameters.strProtocolId+"\n" ) ;
				
				//Added by Sethu for ML-MMOH-CRF-1885 on 03/02/2024				
				if (serverParameters.strProtocolId.equalsIgnoreCase("CCISNIBP"))
				{
					eventClass = "";
					eventGroup = "";
					
					common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:updateT02PDFFile) contrSysEventCode "+contrSysEventCode+"\n" ) ;
					
					try
					{
						queryNoteTypeStmt = connDB.prepareStatement(queryNoteType);
						queryNoteTypeStmt.setString(1, contrSysEventCode);	
					    
						rsNoteType = queryNoteTypeStmt.executeQuery();		    
					    	
					    while(rsNoteType.next()) 
					    {
					    	eventClass = rsNoteType.getString("event_class");
					    	eventGroup = rsNoteType.getString("note_group_id");			    	
					    }
					    
						common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:updateT02PDFFile) contrSysEventCode "+contrSysEventCode+" Event Class "+eventClass+" Event Group "+eventGroup+"\n" ) ;
					}
					catch (Exception exp)
					{
						common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:updateT02PDFFile) Exception "+exp+"\n" ) ;
						common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;		    
					}	
				}
				
				pstmt.setString(7,eventClass);
				pstmt.setString(8,contrSysEventCode);
				pstmt.setString(9,eventGroup);
				
				//Added by Sethu for ML-MMOH-CRF-1885 on 03/02/2024	
				//If condition added by Sethu for ML-MMOH-CRF-1885 on 03/02/2024
				if (serverParameters.strProtocolId.equalsIgnoreCase("CCISNIBP"))
				{
					performedById = "CCIS";
					addedById = "CCIS";
					resultStr = "Please click on attachment link";
				}
				
				/*
				 * Commented by Sethu for ML-MMOH-CRF-1885 on 03/02/2024
				pstmt.setString(9,facilityID);
				pstmt.setString(10,facilityID);
				*/
				
				pstmt.setString(10,performedById);
				pstmt.setString(11,performedById);
				pstmt.setString(12,addedById);
				pstmt.setString(13,facilityID);
				pstmt.setString(14,addedById);
				pstmt.setString(15,facilityID);	
				pstmt.setString(16,resultStr);	
				
				insertRecDetCount = pstmt.executeUpdate();	
				
				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:updateT02PDFFile) Encounter Detail Insert Count "+insertRecDetCount+"\n" ) ;
				
			}
			catch (Exception exp)
			{
				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:updateT02PDFFile) Exception "+exp+"\n" ) ;
				common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;		    
			}
			
			pstmt = null;		
			
			if(insertRecDetCount > 0)
			{	
				//If condition added by Sethu for ML-MMOH-CRF-1885 on 03/02/2024
				if (serverParameters.strProtocolId.equalsIgnoreCase("CCISNIBP"))
					eventTitle = "";
				
				pstmt = connDB.prepareStatement(insertCrDetailObjPDF);
				pstmt.setString(1,histRecType);
				pstmt.setString(2,contrSysID);
				pstmt.setString(3,accessionNum);
				pstmt.setString(4,contrSysEventCode);
				pstmt.setString(5,eventTitle);
			//	pstmt.setBinaryStream(6,pdfInputStream,(int)pdfFile.length());
				pstmt.setBlob(6, blob);
				pstmt.setString(7,"application/pdf");
				pstmt.setString(8,pdfFilename);
				
				insertRecObjCount = pstmt.executeUpdate();	
				
				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:updateT02PDFFile) Encounter Detail OBJ Insert Count "+insertRecObjCount+"\n" ) ;
			}
			
			pstmt = null;	
			
			//common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:updateT02PDFFile) Encounter Detail pdf data Length "+blob.toString()+"\n" ) ;

			if(insertRecObjCount > 0)
			{
				recInserted = true;				
				pstmt = connDB.prepareStatement(updateObjPDF);			
				
				pstmt.setBlob(1, blob);				
				pstmt.setString(2,histRecType);
				pstmt.setString(3,contrSysID);
				pstmt.setString(4,accessionNum);
				pstmt.setString(5,contrSysEventCode);
				
				updRecObjCount = pstmt.executeUpdate();		
				
				//common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:updateT02PDFFile) Encounter Detail OBJ Update Count "+updRecObjCount+"\n" ) ;
			}
			
			connDB.commit();
		}
		catch(Exception exp)
		{			
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;		
		}
		finally
		{
			try
			{	
				if(rs != null) rs.close();
				if(queryPDFStmt != null) queryPDFStmt.close();				
				if(pstmt != null) pstmt.close();
				if(stmt != null) stmt.close();
				
				//Added by Sethu for ML-MMOH-CRF-1885 on 03/02/2024
				if(rsNoteType != null) rsNoteType.close();
				if(queryNoteTypeStmt != null) queryNoteTypeStmt.close();
				
			}
			catch(Exception exp){}
		}
		return recInserted;
	}

	/**
	 * Method to get the order parameter list required for inserting PDF in CR_ENCOUNTER_DETAIL_OBJ.
	 */
	public synchronized HashMap<String,String> getOrderParamList(String orderNo, String orderLine, String fillerOrderNo)
	{		
		Statement stmt = null;
		ResultSet rs = null;

		HashMap<String,String> paramList = null;
		String query = "SELECT order_category,order_type_code||'!'||order_id||'!'||'1!1!1' accession_num," +
						"order_catalog_code contr_sys_event_code,'PDF' event_title " +
						"FROM or_order_line WHERE order_id = '" +orderNo+ "' AND order_line_num = '" +orderLine+ "'";
		try
		{
			String customProtocols [] = {EMConstants.SRR_RIS_IB_PROTOCOL, EMConstants.MOHBR_CCIS_IB_PROTOCOL, EMConstants.MOHBR_PACS_IB_PROTOCOL,EMConstants.MOHBR_CPAC_IB_PROTOCOL};
			if(CommonUtil.equalsAny(serverParameters.strProtocolId, customProtocols))
			{
				query = "SELECT order_category,order_type_code||'!'||order_id||'!" + fillerOrderNo + "'||'!1!1' accession_num," +
						"order_catalog_code contr_sys_event_code,'PDF' event_title " +
						"FROM or_order_line WHERE order_id = '" +orderNo+ "' AND order_line_num = '" +orderLine+ "'";
			}
			
			if(serverParameters.strProtocolId.equalsIgnoreCase(EMConstants.MOHBR_LIS_IB_PROTOCOL))
			{
				query = "SELECT 'CN'||'"+ fillerOrderNo+ "'||to_char(sysdate,'YY')||'$'||lpad(ca_note_type_seq.nextval,14,'0') accession_num FROM DUAL";
			}
			
			stmt = connDB.createStatement();
			rs = stmt.executeQuery(query);

			if(rs.next())
			{
				paramList = new HashMap<String,String>();
				if(serverParameters.strProtocolId.equalsIgnoreCase(EMConstants.MOHBR_LIS_IB_PROTOCOL))
				{
					paramList.put("accession_num",rs.getString("accession_num"));
					paramList.put("eventType","CLNT");
					paramList.put("moduleID","CA");
					paramList.put("event_title","PDF");
				}
				else
				{
					paramList.put("order_category",rs.getString("order_category"));
					paramList.put("accession_num",rs.getString("accession_num"));
					paramList.put("contr_sys_event_code",rs.getString("contr_sys_event_code"));
					paramList.put("event_title",rs.getString("event_title"));
				}
			}
		}
		catch (Exception exp)
		{			
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			}
			catch (Exception exp) { }
		}
		return paramList;
	}

	/**
	 * Method checks for records in INBOUND_MESSAGE which are having the app_ack_YN as NULL and 
	 * returns MESSAGE_ACK_TEXT value.
	 */
	public List getAppAckMsg()
	{
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList list = null;
		String query = "SELECT MESSAGE_ACK_TEXT,INBOUND_FILE_NAME,MESSAGE_ID,SRL_NO FROM "+serverParameters.strModuleId+"_INBOUND_MESSAGE "+
						"WHERE APPLICATION_ID = '" + strApplicationId +
					//	"' AND FACILITY_ID = '" + strFacilityId +
						"' AND PROTOCOL_LINK_ID = '" + strProtocalLinkId +
						"' AND MESSAGE_ACK_TEXT IS NOT NULL AND APP_ACK_YN = 'N'";
		try
		{
			stmt = connDB.createStatement();
			rs = stmt.executeQuery(query);

			if(rs.next())
			{
				list = new ArrayList();
				list.add(rs.getString("MESSAGE_ACK_TEXT"));
				list.add(rs.getString("INBOUND_FILE_NAME"));
				list.add(rs.getString("MESSAGE_ID"));
				list.add(rs.getString("SRL_NO"));
			}
		}
		catch (Exception exp)
		{			
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			}
			catch (Exception exp) { }
		}
		return list;
	}

	/**
	 * Method checks for records in INBOUND_MESSAGE which are having the app_ack_YN as NULL and 
	 * returns MESSAGE_ACK_TEXT value.
	 */
	public boolean updateApplicationAckStatus(String msgID,String srlNo)
	{
		Statement stmt = null;	
		boolean flag = false;
		String query = "UPDATE "+serverParameters.strModuleId+"_INBOUND_MESSAGE "+
						"SET APP_ACK_YN = 'Y' WHERE APPLICATION_ID = '" + strApplicationId +
					//	"' AND FACILITY_ID = '" + strFacilityId +
						"' AND PROTOCOL_LINK_ID = '" + strProtocalLinkId +			
						"' AND MESSAGE_ID = '" + msgID +			
						"' AND SRL_NO = '" + srlNo +"'";
		common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:updateApplicationAckStatus) UpdateQuery "+query+"\n" );
		try
		{
			stmt = connDB.createStatement();
			int i = stmt.executeUpdate(query);
			if (i > 0)
			{
				flag = true;
				connDB.commit();
			}
			else
			{
				connDB.rollback();
			}
		}
		catch (Exception exp)
		{			
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
		finally
		{
			try
			{				
				if(stmt != null) stmt.close();
			}
			catch (Exception exp) { }
		}
		return flag;
	}

	public synchronized String getNextMessage()
	{
		strMessage = "";		
		String strErrorText = "0";	
		CallableStatement  call = null;

		try
		{
		//	if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(OutboundClientDBInteraction:getNextMessage)strCommdataIoApi "+strCommdataIoApi+" \n" ) ;			
			String strProcedureName = "{ call "+ serverParameters.linkCommIOApi + "(?,?,?,?,?,?,?,?,?,?,?,?)"+"}";			
			
			call = (CallableStatement) connDB.prepareCall(strProcedureName);			
			call.setString(1,strApplicationId);
			call.setString(2,strFacilityId);
			call.setInt(3,intProcessId);
			call.setString(4,serverParameters.strModuleId);
			call.registerOutParameter(5,java.sql.Types.VARCHAR);
			call.registerOutParameter(6,java.sql.Types.VARCHAR);
			call.setString(7,serverParameters.linkProtocolLinkID);
			call.registerOutParameter(8,java.sql.Types.VARCHAR);
			call.registerOutParameter(9,java.sql.Types.CLOB);
			call.registerOutParameter(10,java.sql.Types.VARCHAR);
			call.registerOutParameter(11,java.sql.Types.VARCHAR);
			call.registerOutParameter(12,java.sql.Types.VARCHAR);
			
			call.execute();			

			strErrorText = call.getString(12);
		
			if (strErrorText == null || strErrorText.equals("")) 
			{
				Clob clobMessage = call.getClob(9);  
				if(clobMessage != null)
				{
					if(serverParameters.logToFile) common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getNextMessage) strErrorText "+strErrorText+" \n" ) ;
					Reader readerMsg = clobMessage.getCharacterStream(); 
				
					while(true)
					{			
						char charMsg[] = new char[intTotalWidth];					
						int intData = readerMsg.read(charMsg);
						if ( intData > 0 )
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
				//	replayFileName = call.getString(10);
					intSentMessageLength = strMessage.length();
				//	msgBuildTime = "13122007 10:10";					

					if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:getNextMessage) MessageId["+strSentMessageId+"], EventType["+strSentEventType+"], Communication Start Time["+strCommStartTime+"], Acknowledgement Type["+strSentAckType+"], Message Length["+intSentMessageLength+"]\n" ) ;

					if (strStandardAckTypeALWAYS.equals(strSentAckType) 
							|| strStandardAckTypeSUCCESS.equals(strSentAckType)
							|| strStandardAckTypeERROR.equals(strSentAckType))
					{						
						if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:getNextMessage) Acknowledgement Expected\n" ) ;
						boolCanSend = false;
					}	
					else
					{
						boolCanSend =	true;
					}					
				}
			/*	else
				{
					if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(OutboundClientDBInteraction:getNextMessage)Message not exists\n" ) ;				
				}*/
			}			
			call.close();			
		}
		catch(SQLException exceptionSQL)
		{			
			common.fileOutput( serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionSQL) + "\n" ) ;
			common.fileOutput( serverParameters.strExceptionLogFile, "(InboundServerDBInteraction:getNextMessage: ) "+exceptionSQL+"\n" );			
			checkEHISDBConn();			
		}
		catch(Exception exceptionQry)
		{	
			rollback();	
			common.fileOutput( serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionQry) + "\n" ) ;
			common.fileOutput(serverParameters.strExceptionLogFile, "(InboundServerDBInteraction:getNextMessage)Exception "+exceptionQry+"\n" ) ;
			checkEHISDBConn();			
		}
		finally
		{
			try
			{
				if(call != null) call.close();
			}catch(Exception fexp){}
		}

		return(strMessage);				
	}
	
	public synchronized void updateApplicationMessageStatus(int commRetries,int totalMessages,String msgSts,String whoSts,String fileName)
	{
		String strErrorText = "0";
		CallableStatement call = null;

		try
		{						
			String strProcedureName = "{ call "+ serverParameters.linkCommStatApi +"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
									
			if(serverParameters.logToFile)
			{
				common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:updateApplicationMessageStatus) SentEventType: "+strSentEventType+"\n" ) ;
				common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:updateApplicationMessageStatus) ModuleID: "+serverParameters.strModuleId+"\n" ) ;
				common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:updateApplicationMessageStatus) SentMessageLength: "+intSentMessageLength+"\n" ) ;
			//	common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:updateApplicationMessageStatus) whoSts "+whoSts+"\n" ) ;
				common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:updateApplicationMessageStatus) MsgStatus: "+msgSts+"\n" ) ;
				common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:updateApplicationMessageStatus) CommStartTime: "+strCommStartTime+"\n" ) ;
			}
			common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:updateApplicationMessageStatus) Updating Message Status for MSG ID: "+strSentMessageId+"\n" ) ;

			call = connDB.prepareCall(strProcedureName);

			call.setString(1,strApplicationId);
			call.setString(2,strFacilityId);
			call.setString(3,strSentMessageId);
			call.setString(4,strSentEventType);
			call.setInt(5,intProcessId);   			
			call.setString(6,serverParameters.strModuleId); 
			call.setInt(7,intSentMessageLength);
			call.setString(8,strCommStartTime); // Communication Starttime				
			call.setInt(10,commRetries);
			call.setInt(11,totalMessages);
			call.setString(12,msgSts);	// Status
			call.setString(13,whoSts);	// Who initated -- sender
			call.registerOutParameter(16,java.sql.Types.VARCHAR);
			call.registerOutParameter(9,java.sql.Types.VARCHAR); // Communication End Time			
			call.setString(14,fileName);
			call.setString(15,serverParameters.linkProtocolLinkID);
			
			call.execute();
			strErrorText = call.getString(16);
						
			common.fileOutput( serverParameters.strLogFile, "(InboundServerDBInteraction:updateApplicationMessageStatus) strErrorText "+strErrorText+"\n" ) ;
			if (strErrorText == null || strErrorText.equals("") )
			{						
				connDB.commit();		
			}
			else
			{				
				connDB.rollback();
			}
			strProcessEndTime = call.getString(9);
			if(call != null) call.close();
		}
		catch(SQLException exceptionSQL)
		{				        
			common.fileOutput( serverParameters.strExceptionLogFile, "(OutboundClientDBInteraction:updateApplicationMessageStatus) SQLException: "+exceptionSQL+"\n" ) ;			
			checkEHISDBConn();
		}
		catch(Exception exceptionQry)
		{
			rollback();				
			common.fileOutput( serverParameters.strExceptionLogFile, "(OutboundClientDBInteraction:updateApplicationMessageStatus) Exception: "+exceptionQry+"\n" ) ;			
		    checkEHISDBConn();
		}
		finally
		{
			try
			{
				if(call != null) call.close();
			}catch(Exception fexp){}
		}
	}

	public synchronized boolean getLinkProtocolStatus()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String qryLinkProtocol = "SELECT x.comm_data_input_output_api, x.comm_statistics_api, y.PROTOCOL_LINK_ID "+
						"FROM XH_PROTOCOL x, XH_PROTOCOL_LINK y "+
						"WHERE x.protocol_id = (SELECT link_protocol FROM XH_PROTOCOL WHERE protocol_id = ?) "+
						"AND x.protocol_id=y.protocol_id";

		try
		{
			pstmt = connDB.prepareStatement(qryLinkProtocol);
			pstmt.setString(1, serverParameters.strProtocolId);				
			
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				serverParameters.linkProtocolIDEnabled = true;
				serverParameters.linkCommIOApi = rs.getString(1);
				serverParameters.linkCommStatApi = rs.getString(2);
				serverParameters.linkProtocolLinkID = rs.getString(3);

				if(serverParameters.logToFile)
				{
					common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getLinkProtocolStatus) linkCommIOApi "+serverParameters.linkCommIOApi+"\n" ) ;
					common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getLinkProtocolStatus) linkCommStatApi "+serverParameters.linkCommStatApi+"\n" ) ;
					common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getLinkProtocolStatus) linkProtocolLinkID "+serverParameters.linkProtocolLinkID+"\n" ) ;
				}
				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getLinkProtocolStatus) Link Protocol Enabled...\n" ) ;
			}
		}
		catch (Exception exp)
		{
			common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getLinkProtocolStatus) Exception "+exp+"\n" ) ;
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}catch(Exception fexp){}
		}
		return serverParameters.linkProtocolIDEnabled;
	}

	public String getMsgLayout()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuffer sbClobData	= new StringBuffer();
		String qryMsgLayout = "SELECT message_layout FROM xh_protocol WHERE protocol_id = ?";

		try
		{
			pstmt = connDB.prepareStatement(qryMsgLayout);
			pstmt.setString(1, serverParameters.strProtocolId);

			rs = pstmt.executeQuery();
			if(rs.next())
			{				
				Clob clob = rs.getClob("message_layout");
				if(clob != null) sbClobData.append(clob.getSubString(1,(int)clob.length()));
			}
		}
		catch (Exception exp)
		{
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
		finally
		{
			closeResource(rs, pstmt);
		}
		return sbClobData.toString();
	}

	/**
	 * Method updates communication status. 
	 * Flag will be updated whenever any new communication will be started or existing one is stopped.
	 */
	public void updateProcessComStatus(String flag)
	{
		PreparedStatement pstmt = null;
		String qry = "UPDATE xh_comm_process SET comm_status = ? WHERE process_id = ?";

		try
		{
			pstmt = connDB.prepareStatement(qry);
			pstmt.setString(1, flag);
			pstmt.setInt(2, intProcessId);

			int i = pstmt.executeUpdate();

			if(i <= 0) common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:updateProcessComStatus) Failed to update Communication Status...\n");
			else connDB.commit();
		}
		catch (Exception exp)
		{
			common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:updateProcessComStatus) "+exp+"\n");			
		}
		finally
		{
			closeResource(null, pstmt);
		}
	}

	/**
	 * Static method used to close any database resource.
	 * Used in most of the inbound database transactions.
	 */
	public static void closeResource(ResultSet rs, Statement ps)
	{
		try
		{
			if(rs != null) rs.close();
			if(ps != null) ps.close();			
		}
		catch(Exception exp) {}										
	}

	/**
	 * Method queries the derivations rules set for the current application
	 */
	public void setMsgDerivationRules()
	{
		String qry = "SELECT element_id, expected_value2 FROM xh_appl_derivation_rules WHERE application_id = ? AND derivation_type = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{
			pstmt = connDB.prepareStatement(qry);
			pstmt.setString(1, strApplicationId);
			pstmt.setString(2, "ENCOD_DECOD_ALGORITH");

			rs = pstmt.executeQuery();

			if(rs.next())
			{
				serverParameters.decodingEnabled = true;
				serverParameters.decodeField = rs.getString("element_id");
				serverParameters.decodeType = rs.getString("expected_value2");

				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) Decoding Enabled\n");
				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) decodeField["+serverParameters.decodeField+"]\n");
				common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getAllParameters) decodeType["+serverParameters.decodeType+"]\n");
			}
		}
		catch (Exception exp)
		{
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
		finally
		{
			closeResource(rs, pstmt);
		}
	}	

	public void updateCommRetries(int cnt)
	{
		try
		{
			Statement stmt = connDB.createStatement();
			String strUpdQry = "UPDATE xh_comm_process SET "+
								" last_outbound_retries = " + cnt +
								" WHERE process_id = " + intProcessId;
			stmt.executeUpdate(strUpdQry );
			connDB.commit();
			stmt.close();
		}
		catch(Exception exceptionQry)
		{
			rollback();
			common.fileOutput(serverParameters.strLogFile, "(OutboundClientDBInteraction:updateCommRetries)Exception:"+exceptionQry+"\n" );
			checkEHISDBConn();
		}
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
	
	public synchronized String getPatientId(String nationalID)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String qry = "select patient_id from mp_patient where national_id_no = ? ";
		
		String patientId = "";

		try
		{
			pstmt = connDB.prepareStatement(qry);
			pstmt.setString(1, nationalID);				
			
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				
				patientId = rs.getString(1);				
			}
		}
		catch (Exception exp)
		{
			common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getPatientId) Exception "+exp+"\n" ) ;
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}catch(Exception fexp){}
		}
		return patientId;
	}
	public String getEncounterID(String patientID )
    {	

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String encounterId = "";
		Clob clob = null;
	
		String qry = "SELECT encounter_id FROM PR_ENCOUNTER a WHERE PATIENT_ID = ? "    
						+" and VISIT_ADM_DATE_TIME in (select max(VISIT_ADM_DATE_TIME) from pr_encounter b where a.PATIENT_ID = B.PATIENT_ID )";
	
		try
		{
		    pstmt = connDB.prepareStatement(qry);
		    pstmt.setString(1, patientID);	
		    
		    rs = pstmt.executeQuery();		    
		    	
		    while(rs.next()) 
		    {
		    	encounterId = rs.getString("encounter_id");		    	
		    }
		}
		catch (Exception exp)
		{
			common.fileOutput(serverParameters.strLogFile, "(InboundServerDBInteraction:getPatientId) Exception "+exp+"\n" ) ;
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;		    
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}catch(Exception fexp){}
		}
		return encounterId;
    }
}