/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
*/
package HL7Engine.OutboundProcess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import HL7Engine.Common.Common;
import HL7Engine.Common.CommonUtil;
import HL7Engine.Common.InterfaceUtil;
import HL7Engine.Common.EMConstants;
import HL7Engine.exceptions.FatalException;

import com.isoft.interfaceengine.custominterface.OutboundWebservice;
import com.isoft.interfaceengine.validations.OutboundCustomProcess;

public class OutboundClientApplication extends Thread
{ 
	Common common = null;
	CommonUtil commonUtil = new CommonUtil();
	Socket socket;
	Socket simSocket;
	String strIpAddress;
	String simulatorIPAddress;
	String netStatCmdStr;
	int intPort;
	int simulatorPort;
	Thread thread;

	/*****************
	Flag setting for whether to make connection intStart = 0 reconnect 
	intStart<>0 don't connect
	******************/

	int intStart = 0;
	int intIdleTime = 0;
	int arr = 0; // temp

	InputStream inSocketStream;
	OutputStream outSocketStream;
	BufferedWriter outboundStream;

	OutputStream simSocStream; // variable used for simulation purpose
	BufferedWriter simOutboundStream; // variable used for simulation purpose

	boolean isSimulationReq = false;
	boolean isCustomProcess = false;

	long longStartTime = 0;

	// Time used to retry for database connection initially.
	long intiRetryInterval = 60 * 1000;

	GregorianCalendar gc = new GregorianCalendar();
	String strRenamedFile = "";

	String strCommunicationMode = "0";
	String strFileDirectory = "0";

	String strProtocolId = "";
	String strProtocolType = "";
	String strProtocolMode = "";
	String strFileNamingConvention = "";
	String strDbfFileType = "";
	String strCreateFileInterval = "";
	String strCreateDataInterval = "";
	String strCommdataIoApi = "";
	String strCommStatistics = "";
	String strModuleId = "";
	String strTnsName = "";
	String replayFileName = "";

	long strAckType = 0;	
	long previousFileCreateTime = 0;

	int i = 0; // checking for file creation interval in file communication ( checkCreateInterval() )
	boolean fileToBeCreated = false;

	OutboundClientWriteFile writeFile;
	OutboundRs232Communication rs232WriteData;

	int intMaxRetries = 0;
	int intRetryInterval = 10000;
	int intSleepingIndex = 0;
	int intSleepingIndexProtocol = 0;
	int intProcessId = 0;
	int intAckSignal =0;
	int intPollingTime = 1500;
	int intBlockSize = 2048;
	int intNoOfMessages = 0;
	long logCounter = 0;

	long longSleepingTimeProtocol = 0;
	long longSleepingTime = 0;

	boolean boolSocket = true;

	OutboundClientRead clientReadProcess;
	OutboundClientDBInteraction clientDB;
	OutboundClientParameters clientParameters;
	OutboundODBCCommunication odbcCommunication;
	OutboundCustomProcess customProcess;
	OBHelper obHelper;
	OutboundWebservice webserviceObj;
	ICommunication commInterface;

	String strApplicationId = "0";
	String strStartBlock = ""+((char)11);
	String strEndMessage = ""+((char)13)+((char)28)+((char)13);

	private boolean isCrossingTheDay()
	{
		try
		{
			if((System.currentTimeMillis()) > clientParameters.nextSleepCalculationTime)
			{
				return true;
			}
		}
		catch (Exception ex)
		{
			common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(ex) + "\n");
		}
		return false;
	}

	private boolean isReachedSleeping()
	{
		try
		{
			long presentTime = System.currentTimeMillis();
			if (clientParameters.isSleepEnabledToday == true)
			{
				for(int j = 0; j < clientParameters.longSleepFrom.length; j++)
				{
					if ((clientParameters.longSleepFrom[j] <= presentTime) && 
							(clientParameters.longSleepTo[j] >= presentTime))
					{
						this.intSleepingIndex = j;
						this.longSleepingTime = clientParameters.longSleepTo[j] - presentTime;

						if (this.longSleepingTime <= 0)
						{
							this.longSleepingTime = 1;
						}
						return(true);
					}
				}
			}
		}
		catch(Exception exp)
		{
			common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
		return(false);
	}

	private boolean isReachedSleepingProtocol()
	{
		try
		{
			long presentTime = System.currentTimeMillis();
			if (clientParameters.isSleepEnabledTodayProtocol == true)
			{
				for(int j = 0; j < clientParameters.longSleepFromProtocol.length; j++)
				{
					if ((clientParameters.longSleepFromProtocol[j] <= presentTime) &&
							(clientParameters.longSleepToProtocol[j] >= presentTime))
					{
						this.intSleepingIndexProtocol = j;
						this.longSleepingTimeProtocol = clientParameters.longSleepToProtocol[j] - presentTime;
						if(this.longSleepingTimeProtocol <= 0)
						{
							this.longSleepingTimeProtocol = 1;
						}
						return(true);
					}
				}
			}
		}
		catch(Exception exp)
		{
			common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
		return(false);
	}

	private void checkRestartApplicable()
	{
		try
		{
			if ((clientParameters.strRestartType.equalsIgnoreCase("E")) ||
					(clientParameters.strRestartType.equalsIgnoreCase("A")))
			{
				clientParameters.isAutoRestart = true;
			}			
		}
		catch(Exception ex)
		{
			clientParameters.isAutoRestart = false;
		}
	}

	public String getStoppingTimeMessage()
	{
		if (clientParameters.strRestartType.equals("E"))
		{
			return("Interval "+clientParameters.restartTime);
		}
		else
		{
			return("At "+clientParameters.restartTime);
		}
	}

	public long getTimeDifference()
	{
		long ltimeDiff = gc.getTimeInMillis() - System.currentTimeMillis();
		return(ltimeDiff);
	}

	private void setStoppingTime()
	{
		if (clientParameters.isAutoRestart == false) return;
		if (clientParameters.strRestartType.equalsIgnoreCase("E"))
		{
			this.setNextInterval();
		}
		else
		{
			if (getTimeDifference() <= 0)
			{
				this.setNextTime();
			}
		}
	}

	public void setNextInterval()
	{
		String strTim[] = clientParameters.restartTime.split(":");
		setCurrentTime();
		int hour = Integer.parseInt(strTim[0]);
		int min  = Integer.parseInt(strTim[1]);
		try
		{
			hour = gc.get(gc.HOUR_OF_DAY) + hour;
			min  = gc.get(gc.MINUTE) + min;
			gc.set(gc.HOUR_OF_DAY, hour);
			gc.set(gc.MINUTE, min);
		}
		catch(Exception exp)
		{
			if(clientParameters.stackTrace) common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");  
		}
	}

	public void setNextTime()
	{
		int hour = 0;
	//	int min = 0;
		hour = gc.get(gc.HOUR_OF_DAY);
		gc.set(gc.HOUR_OF_DAY, hour + 24);
	}

	public void setCurrentTime()
	{
		String strTim[] = null;
		try
		{
			if (clientParameters.isAutoRestart == false) return;

			try
			{
				strTim = clientParameters.restartTime.split(":");
			}
			catch(Exception exp)
			{
				return;
			}
			if (clientParameters.strRestartType.equals("A"))
			{
				gc = new GregorianCalendar();
				gc.set(gc.HOUR_OF_DAY,Integer.parseInt(strTim[0]));
				gc.set(gc.MINUTE,Integer.parseInt(strTim[1]));
			}
			else
			{
				gc = new GregorianCalendar();
			}
		}
		catch(Exception exp)
		{
			if(clientParameters.stackTrace) common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");  
		}
	}

	private boolean restartTheInstance()
	{
		if (clientParameters.isAutoRestart == true)
		{
			if (this.getTimeDifference() <= 0) return(true); 
		}
		else
		{
			return false;
		}
		return(false);
	}	
	
public void runProcess(String prc)
{
	try
	{
		common.fileOutput(clientParameters.strLogFile,"(OutboundClientApplication:runProcess) Creating New Instance[Process Id:"+clientParameters.strCommandParam[2]+"]\n");
	//	this.rename(clientParameters.strLogFile);
		Runtime runtime = Runtime.getRuntime();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception exp)
		{
			if(clientParameters.stackTrace) common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");  
		}
		runtime.exec(prc);
		common.fileOutput(this.strRenamedFile,"(OutboundClientApplication:runProcess) New Instance Created\n");
	}
	catch(Exception exception)
	{
		common.fileOutput(this.strRenamedFile,"Instance Creation Failed\n");
	}
}

public void rename(String log)
{
	File fFrom = null,fTo = null;
	String strFileName[] = new String[2];
	try
	{
		strFileName = log.split(".log");
	}
	catch (Exception ex)
	{
		strFileName[0] = log;
	}
	try
	{
		fFrom = new File(log);
		strRenamedFile = strFileName[0] + "_" + (OutboundUtil.getTimeStamp()) + ".log";
		fTo = new File(strRenamedFile);

		if (fFrom.exists())
		{				
			boolean flag = fFrom.renameTo(fTo);
			if(flag)
				common.fileOutput(strRenamedFile,"(OutboundClientApplication:rename) New log created...\n");
			else
				common.fileOutput(strRenamedFile,"(OutboundClientApplication:rename) Unable to create new log...\n");
		}
	}
	catch(Exception exp)
	{
		if(clientParameters.stackTrace) common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");  				
	}
}

public OutboundClientApplication()
{
}

public OutboundClientApplication(OutboundClientParameters client)
{	
	try
	{
		setInitParam(client);
		common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication) Connecting to Database["+clientParameters.strTnsName+"]�\n" );
		boolean boolIsConnected = false;

		while(true)
		{
			try
			{
				boolIsConnected = clientDB.makeDBConnection();
				if(boolIsConnected)
				{
					try {
						clientDB.getXHParameters(); // Retrieving Idle Time
						intIdleTime = clientParameters.intIdleTime*1000*60;
					}
					catch(Exception exp) {
						common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication) Exception: "+exp+"\n" );							  
					}

					clientParameters = clientDB.getAllParameters();
					clientDB.getMessageDelimiters(clientParameters);

					if (clientParameters.boolError) {
						clientDB.closeDBconn();
						common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication) Closing Current Instance\n" );
						common.fileOutput( clientParameters.strLogFile, "\n_______________________________________________________________________________\n\n***********End of Log File****** \n" );
						return;
					}		

					strProtocolId = clientParameters.strProtocolId ;
					strProtocolType = clientParameters.strProtocolType; 
					strProtocolMode = clientParameters.strProtocolMode ; 	
					strFileNamingConvention = clientParameters.strFileNamingConvention ; 	
					
					if(strFileNamingConvention == null) {
						strFileNamingConvention = "XH_TEST1";
					}

					strDbfFileType = clientParameters.strDbfFileType ;
					strCreateFileInterval = clientParameters.strCreateFileInterval ;  
					strCreateDataInterval = clientParameters.strCreateDataInterval ; 
					strCommdataIoApi = clientParameters.strCommdataIoApi ;
					strCommStatistics = clientParameters.strCommStatistics ; 	
					strModuleId = clientParameters.strModuleId;
					strAckType = clientParameters.strAckType;			
					strCommunicationMode = clientParameters.strCommunicationMode;
					strFileDirectory = clientParameters.strFileDirectory;
					strIpAddress = clientParameters.strIpAddress;
					intPort = clientParameters.intPortNumber;
					intRetryInterval = clientParameters.intRetryInterval * 1000;// This will be in Secs, hence multiplied by 1000-> Millisecs
					intMaxRetries = clientParameters.intMaxRetries;	

					if (strCommunicationMode.equals("F")) {
						String endChar = (strFileDirectory).substring( (strFileDirectory).length()-1, (strFileDirectory).length() );
						if(!endChar.equals("/")) {
							strFileDirectory = strFileDirectory + "/";
						}
					}
					
					initConfig();
					break;				
				}
				else
				{				
					common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication)Database Connection Failed \n" );	
					Thread.sleep(intiRetryInterval);
				}
			}
			catch(Exception exp) {
				common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:Constructor)Exception: "+exp+"\n" );
			}
		}

		thread = this;
		clientDB.updateProcessStatus("A", clientParameters.intConnectionCount);

		this.start();
	}
	catch (Exception exp)
	{
		try {
			String defaultLoc = InterfaceUtil.getDefaultLogLoc(Integer.toString(clientParameters.intProcessId));
			FileOutputStream fileOutputStream = new FileOutputStream(defaultLoc, true);
			fileOutputStream.write(CommonUtil.getStringStackTrace(exp).getBytes(), 0, CommonUtil.getStringStackTrace(exp).getBytes().length);
			fileOutputStream.close();
		}
		catch (Exception e) {
		}
	}
}
				
public void run()
{	
	init();	
	if(!strCommunicationMode.equals("R")
			&& !strCommunicationMode.equals("M") && !strCommunicationMode.equals("S"))
	{		
		while (true)
		{
			try
			{
				checkParams();				
				
				if(intStart == 0)
				{
					String communicationStatusMsg = "";
					boolean canStartComm = obHelper.commStartCheck();
					if(!canStartComm) {
						common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:run) Waiting for startup process to finish...\n");
						Thread.sleep(intRetryInterval);
						continue;
					}
					intStart++;
					System.gc();

					if("D".equals(strCommunicationMode)) {
						odbcCommunication = new OutboundODBCCommunication(clientDB, clientParameters);

						if(clientParameters.intConnectionCount == 0) {
							common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:run) Connecting to External Database...\n" ) ;
						}
						else {
							common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:run) Retrying external database connection...\n" ) ;
						}

						odbcCommunication.externalDBConn = clientDB.getExternalDBConnection();

						if(odbcCommunication.externalDBConn == null) {
							throw new SQLException();
						}
					}
					else if("T".equals(strCommunicationMode)) {
						if (clientParameters.intConnectionCount == 0) {
							common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:run) Connecting to Remote Client...\n" );
						}
						else {
							common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:run) Retrying Remote Client Connection...\n" ) ;
						}

						socket = null;
						simSocket = null;
						outSocketStream = null;
						simSocStream = null;
						inSocketStream = null;
						clientReadProcess = null;	
						
						String encodingType = CommonUtil.getPropertyVal(InterfaceUtil.getiniFilePath("CONFIG"), "OB_TCPIP_ENC");

						if(encodingType == null || encodingType.trim().equals("")) encodingType = "UTF8";
						common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:run) Encoding Type: "+encodingType+"\n" ) ;

						socket = new Socket(strIpAddress,intPort);						
						common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:run) Remote Client Connection Successful...\n" ) ;
						resetParams();

						inSocketStream = socket.getInputStream();
						outSocketStream = socket.getOutputStream();
						outboundStream = new BufferedWriter(new OutputStreamWriter(outSocketStream, encodingType));

						clientReadProcess = new OutboundClientRead(inSocketStream, clientDB, clientParameters.logToFile, clientParameters.strLogFile, clientParameters.strExceptionLogFile);
						longStartTime = System.currentTimeMillis(); 

						if(simulatorIPAddress != null && !"".equals(simulatorIPAddress.trim())) {
							common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:run) Simulator IP Address: "+simulatorIPAddress+"\n" ) ;
							common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:run) Simulator Port: "+simulatorPort+"\n" ) ;

							simSocket = new Socket(simulatorIPAddress,simulatorPort);

							common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:run) Simulator Connection Successful...\n" ) ;

							simSocStream = simSocket.getOutputStream();
							simOutboundStream = new BufferedWriter(new OutputStreamWriter(simSocStream, encodingType));
						}
					}
					else if (strCommunicationMode.equals("F")) {	
						writeFile = new OutboundClientWriteFile(clientParameters.logToFile, clientParameters.strLogFile, clientParameters.strExceptionLogFile, strFileNamingConvention, strDbfFileType, clientDB);
						i = 0;			
						boolean boolCheckDir = writeFile.checkExist(strFileDirectory);
						boolean isWritable = false;
						boolean isFileOpen = false;
						
						if(boolCheckDir) {
							isWritable = CommonUtil.canWrite(strFileDirectory + "/test.txt", true);
							CommonUtil.deleteFiles(strFileDirectory + "/test.txt");
							if(isWritable) {
								isFileOpen = CommonUtil.isFileOpen(new File(strFileDirectory));
							}
						}
						if(!boolCheckDir || !isWritable || isFileOpen) 
						{
							if(!boolCheckDir) communicationStatusMsg = "The specified folder does not exist !!!";
							else if(!isWritable) communicationStatusMsg = "The specified folder does not have write permission !!!";
							else if(isFileOpen) communicationStatusMsg = "Make sure that all files in the output folder are closed !!!";
							
							clientDB.registerError("WriteFile.checkExist", communicationStatusMsg);
							common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:WriteFile) " + communicationStatusMsg + "\n" );
							clientDB.updateProcessStatus("S",clientParameters.intConnectionCount);
							exitProcess(communicationStatusMsg);
						}
						clientReadProcess = new OutboundClientRead(null, clientDB, clientParameters.logToFile, clientParameters.strLogFile, clientParameters.strExceptionLogFile);
						
						if ("SRREBLP2".equalsIgnoreCase(strProtocolId)) {
							common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:WriteFile) Creating files...\n" );
							writeFile.createBillingFiles();
						}
					}
					else if ("N".equals(strDbfFileType)) {
						if(commInterface == null) commInterface = new NotificationProcessor(clientDB, clientParameters);
					}
					else if (strCommunicationMode.equals("W")) {							
						webserviceObj = new OutboundWebservice(clientParameters, clientDB);
					}
					else if (strCommunicationMode.equals("H")) {						
						if(commInterface == null) commInterface = new HTTPTransactions(clientDB, clientParameters);						
						commInterface.initFunc();
					}
					else if (strCommunicationMode.equals("SL")) {
						if(commInterface == null) commInterface = new LotusNotesTrans(clientDB, clientParameters);
						commInterface.initFunc();
					}
					else if (strCommunicationMode.equals("CM")) {
						if(commInterface == null) commInterface = new CMDMessageProcessor(clientDB, clientParameters);
					}
					else if (strCommunicationMode.equals("WC")) {
						if(commInterface == null) commInterface = new WebserviceTransactions(clientDB, clientParameters);
					}
					else if (strCommunicationMode.equals("SO")) {// Added by Sethu for ML-MMOH-CRF-0473
						clientDB.getWebServiceParams(); // to get the required parameters for soap transaction 
						if(commInterface == null) commInterface = new SoapTransactions(clientDB, clientParameters);
					}
					
					if (!strCommunicationMode.equals("W")
							|| !strCommunicationMode.equals("H")) clientDB.updateProcessComStatus("Y");
				}
				
				String [] fetchNextMsgProtocol = {"H", "SL", "N", "CM", "WC", "SO"}; // CMMOCA1 // "SO" // Added by Sethu for ML-MMOH-CRF-0473
				
				if("D".equals(strCommunicationMode))
				{				
					odbcCommunication();
				}
				else if("T".equals(strCommunicationMode))
				{
					if (!clientDB.canISend())
					{
						if((System.currentTimeMillis() - logCounter) >= 10000)
						{
							common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:run) Waiting for Acknowledgment\n");
							logCounter = System.currentTimeMillis();
						}
							continue;
						}
					tcpCommunication();
				}
				else if (strCommunicationMode.equals("F"))
				{
					if(strDbfFileType.equalsIgnoreCase("F")) foxproCommunication();
					else fileCommunication();
				}
				else if (strCommunicationMode.equals("W"))
				{					
					webserviceComm();
				}
				else if (CommonUtil.equalsAny(strCommunicationMode, fetchNextMsgProtocol) || "N".equals(strDbfFileType))
				{
					fetchNextMessage();
				}
			}
			catch(FatalException fatalException)
			{
				common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:run) Exception: "+fatalException+"\n");
				common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(fatalException) + "\n");
				exitProcess();
			}
			catch(Exception exceptionGeneral)
			{			
				common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionGeneral) + "\n"); 

				if (exceptionGeneral.getClass().isInstance(new ConnectException())
						|| exceptionGeneral.getClass().isInstance(new SocketException())
						|| exceptionGeneral.getClass().isInstance(new IOException()))
				{
					common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:run) Remote Client Connection Failed\n");
					if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:run) Exception: "+exceptionGeneral+"\n");					
				}
				else if(exceptionGeneral.getClass().isInstance(new SQLException()))
				{					
					if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:run) Exception: "+exceptionGeneral+"\n");	
				}
				updateRetryAttempts();
			}
			catch(NoClassDefFoundError classNotFound)
			{
				common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:run) !!! Unable to locate API for " + classNotFound.getMessage() + " !!!\n");
				common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(classNotFound) + "\n");
				exitProcess();
			}
			catch(Error error)
			{
				common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:run) " + error.getMessage() + "\n");
				common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(error) + "\n");
				exitProcess();
			}
		}		
	}
	else
	{	
		if (strCommunicationMode.equals("R")) //communication mode ---RS-232
		{	
			rs232WriteData = new OutboundRs232Communication(clientParameters.logToFile, clientParameters.strLogFile, clientParameters.strExceptionLogFile,clientDB);
			boolean boolCheckDir = rs232WriteData.checkRsCommunicationStatus();
			if ( boolCheckDir == false)
			{
				clientDB.registerError("rs232WriteData.checkRsCommunicationStatus","The RS-232 connection  does not exist");
				if( clientParameters.logToFile ) common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:run)rs232WriteData.checkRsCommunicationStatus:The RS-232 connection  does not exist\n" );
				clientDB.updateProcessStatus("S",clientParameters.intConnectionCount);
				clientDB.closeDBconn();
				return;					
			}
			rs232Communication();
		}
		else if (strCommunicationMode.equals("M")) //communication mode ---MAIL
		{	
			mailCommunication();
		}		
		else if (strCommunicationMode.equals("S")) //communication mode ---SMS
		{	
			smsCommunication();
		}
	}

}

private void resetParams() 
{
	clientDB.checkAcknowledgement();
}

public void tcpCommunication()
{
	try
	{
	//	Thread.sleep(intPollingTime);

		String strTotalMessage = clientDB.getNextMessage(strCommdataIoApi);

		if (strTotalMessage != null && !(strTotalMessage.equals("")))
		{
			if(simulatorIPAddress != null && !"".equals(simulatorIPAddress.trim())) 
			{
				try
				{
					common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:tcpCommunication) Sending Message to simulator !!!\n" ) ;
					simOutboundStream.write(strTotalMessage);
					simOutboundStream.flush();
				}
				catch(Exception exp)
				{
					common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:tcpCommunication) Error in sending message to simulator...\n");
				}
			}
			if (!clientReadProcess.isAlive())
			{
				throw new SocketException("Read Process dead");
			}
			if(!(obHelper.checkRemoteConnStatus()))
			{
				if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:tcpCommunication) Sending Message\n" ) ; 
				
			//	outSocketStream.write(strTotalMessage.getBytes());
				outboundStream.write(strTotalMessage);
				outboundStream.flush();				
				
				if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "\n======\n" + strTotalMessage + "\n======\n\n");

					++intNoOfMessages;
			//	++intLogMessages;

					if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:tcpCommunication) Total Messages Sent="+intNoOfMessages+", Total Messages Received="+clientReadProcess.intTotalReceived+"\n");
				longStartTime = System.currentTimeMillis(); 
					clientDB.updateApplicationMessageStatus(clientParameters.intConnectionCount,intNoOfMessages,"S","S","");
				}
			else
			{
				clientDB.boolCanSend = true;
				throw new SocketException();
			}
		}
		else
		{			
			if((System.currentTimeMillis() - logCounter) >= 30000)
			{
				if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:tcpCommunication) No messages to process...\n" ) ;
				logCounter = System.currentTimeMillis();				
			}
			Thread.sleep(intRetryInterval);
		}
	}
	catch(Exception exceptionGeneral)
	{
		common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exceptionGeneral) + "\n"); 

		if (exceptionGeneral.getClass().isInstance(new ConnectException())
				|| exceptionGeneral.getClass().isInstance(new SocketException())
				|| exceptionGeneral.getClass().isInstance(new IOException()) )
		{
			common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:tcpCommunication) Remote Client Connection Failed\n");
	        try	
			{
				if(socket != null) socket.close();				
				if(simSocket != null) simSocket.close();
			}
			catch (Exception exp){}	
			updateRetryAttempts();
			clientDB.updateProcessComStatus("N");
		}
	}	
}

	public void fileCommunication() 
	{
		clientParameters.intConnectionCount = 0;
		intNoOfMessages = 0;
		int intStart = 0;
		String sMsgId = "0";

		try 
		{
			while (true) 
			{
				try 
				{
					if (intStart == 0) 
					{
						common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:fileCommunication) Starting Acknowledgement Process \n");
						intStart++;
						clientReadProcess = new OutboundClientRead(null, clientDB, 
												clientParameters.logToFile,
												clientParameters.strLogFile,
												clientParameters.strExceptionLogFile);
					}

					String strTotalMessage = clientDB.getNextMessage(strCommdataIoApi);
					replayFileName = clientDB.replayFileName;

					boolean checkOfflineTime = checkOfflineStatus();

					if (strTotalMessage != null && !(strTotalMessage.equals("")) && checkOfflineTime) 
					{
						++intNoOfMessages;
						longStartTime = System.currentTimeMillis();

						if (clientParameters.logToFile && clientParameters.debugYN) common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:fileCommunication) Processing Message: " + strTotalMessage + "\n");

						if (isCustomProcess) 
						{
							if ("SRREBLP2".equalsIgnoreCase(strProtocolId)) 
							{
								writeFile.writeBillingMessage(strTotalMessage);
								clientDB.updateApplicationMessageStatus(clientParameters.intConnectionCount,
																	intNoOfMessages, "S", "S", "");
							} 
							else if ("SRREBLP13".equalsIgnoreCase(strProtocolId)
									|| "SKREBLP1".equalsIgnoreCase(strProtocolId)) 
							{
								writeFile.processMessage(strTotalMessage, clientDB.strSentEventType);
								clientDB.updateApplicationMessageStatus(clientParameters.intConnectionCount,
																	intNoOfMessages, "S", "S", "");
							} 
							else if ("SRREBLP7".equalsIgnoreCase(strProtocolId)) 
							{
								try 
								{
									String error = customProcess.runProcess(strTotalMessage);
									common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:run) Inside Custom Process\n");

									if (error != null) 
									{
										clientDB.updateApplicationMessageStatus(clientParameters.intConnectionCount,
																	intNoOfMessages, "E", "S", "");
										common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:fileCommunication) Error in bill transaction: " + error + "\n");
									} 
									else 
									{
										clientDB.updateApplicationMessageStatus(clientParameters.intConnectionCount,
																	intNoOfMessages, "S", "S", "");
									}
								} 
								catch (Exception exp) 
								{									
									common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
									exitProcess();
								}
							}
						} 
						else 
						{
							sMsgId = clientDB.getSentMessageId();

							fileToBeCreated = false;
							writeFile.createNewFile = false;
							checkCreateInterval();

							if (replayFileName != null) 
							{
								writeFile.createNewFile = false;
								writeFile.writeFooter();

								/**
								 * replayFilename format filename + three
								 * underscores + today's date in yyyyMMdd_HHmm
								 * (date & time) format
								 **/
								replayFileName = replayFileName
													+ "___"
													+ CommonUtil.getFormattedStringDate("yyyyMMdd_HHmm", new Date());
								writeFile.strOutFileName = replayFileName;
								writeFile.replay = true;
							}

							/*
							 * if(strDbfFileType.equalsIgnoreCase("X")) {
							 * //deleting start and end char strTotalMessage =
							 * strTotalMessage
							 * .substring(1,strTotalMessage.length()-3);
							 * strTotalMessage =
							 * strTotalMessage.replaceAll(">\\|<","><"); }
							 */

							writeFile.writeMessage(strTotalMessage, sMsgId);
							writeFile.replay = false;
							String tempFileName = OBHelper.getTokenizedFileName(writeFile.strOutFileName);

							if (clientParameters.logToFile) 
							{
								common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:fileCommunication) Total Messages: " + intNoOfMessages + "\n");
								common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:fileCommunication) Message written: " + writeFile.strOutFileName	+ "\n");
							}
							clientDB.updateApplicationMessageStatus(clientParameters.intConnectionCount,
															intNoOfMessages, "S", "S", tempFileName);
						}
					} 
					else 
					{
						if ((System.currentTimeMillis() - logCounter) >= 30000) 
						{
							if (clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:fileCommunication) No messages to process...\n");
							logCounter = System.currentTimeMillis();
						}
						if (isCustomProcess && (intNoOfMessages > 0 || "SRREBLP13".equalsIgnoreCase(strProtocolId))) 
						{
							common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:fileCommunication) No messages to process...\n");
							
							
								writeFile.closeResources();
	
								if ("SRREBLP7".equalsIgnoreCase(strProtocolId)) 
								{
									customProcess.addCheckSum();
								//	clientDB.storeBillingFilename(clientDB.strSentEventType, zipFilename);
								}
								else if ("SRREBLP2".equalsIgnoreCase(strProtocolId)) 
								{
									writeFile.writeBillingMessage(strTotalMessage);
									clientDB.updateApplicationMessageStatus(clientParameters.intConnectionCount,
																		intNoOfMessages, "S", "S", "");
								}
								if ("SKREBLP1".equalsIgnoreCase(strProtocolId) || "SRREBLP13".equalsIgnoreCase(strProtocolId)) 
								{
									common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:fileCommunication) Moving files...\n");
									CommonUtil.moveFiles(strFileDirectory + "/Processing/", strFileDirectory);
								}
								
								clientDB.updateProcessStatus("P", clientParameters.intConnectionCount);
								exitProcess();
							
						}
						Thread.sleep(intPollingTime);
					}
				}
				catch(FatalException fatalException)
				{
					common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:fileCommunication) Exception: "+fatalException+"\n");
					common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(fatalException) + "\n");
					clientDB.updateProcessStatus("S", clientParameters.intConnectionCount);
					exitProcess();
				}
				catch (Exception exception) 
				{
					common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:fileCommunication) Exception:" + exception + "\n ");
					if (clientParameters.stackTrace) common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exception) + "\n");
					clientDB.updateApplicationMessageStatus(clientParameters.intConnectionCount, intNoOfMessages, "F", "E", "");
				}
			}
		} 
		catch (Error error) 
		{
			common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:fileCommunication) Error):" + error + "\n ");
			common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(error) + "\n");
		}
	}

	//code inserted by srinivasa.N
	public void rs232Communication()
	{
		clientParameters.intConnectionCount = 0;
		intNoOfMessages = 0;
		String sMsgId = "0";

		while (true) 
		{
			try 
			{
				String strTotalMessage = "";
				strTotalMessage = clientDB.getNextMessage(strCommdataIoApi);

				if (!(strTotalMessage.equals(""))) 
				{
				//	strTotalMessage = strTotalMessage.substring(1,strTotalMessage.length()-2);
					++intNoOfMessages;
					longStartTime = System.currentTimeMillis();
					sMsgId = clientDB.getSentMessageId();
					rs232WriteData.writeMessage(strTotalMessage);
					if (clientParameters.logToFile)
					common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:rs232Communication)Message written to RS-232 port\n");
					clientDB.updateApplicationMessageStatus(clientParameters.intConnectionCount, intNoOfMessages, "S", "S", "");
				}
				thread.sleep(intPollingTime);
			} 
			catch (Exception exception) 
			{
				common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:rs232Communication) Exception: " + exception + "\n ");
				if (clientParameters.stackTrace) common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exception) + "\n");
			}
		}
	}

public void xmlCommunication()
{	  		 
	try
	{
	//	Element tag = null;
		try
		{
			// Creation of a new DOM
			Properties prop = new Properties();
			prop.load(new FileInputStream("C:/me/core/xml/buildXML.ini"));

			byte byteMsg[] = new byte[999999];
			InputStream inputStream = new FileInputStream("C:/me/core/xml/address1.txt");
			InputStream templateStream = new FileInputStream("C:/me/core/xml/address.txt");
			int bytes = inputStream.read(byteMsg);
			String message = new String(byteMsg,0,bytes);
			bytes = templateStream.read(byteMsg);
			String template = new String(byteMsg,0,bytes);

			System.out.println("Message "+message);
			System.out.println("Template "+template);

			DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance();
			DocumentBuilder constructeur = fabrique.newDocumentBuilder();
			Document document = constructeur.newDocument();
			Element racine = document.createElement("START");
		//	racine.appendChild(document.createComment("This is a XML document for a model"));
			document.appendChild(racine);			

			// Properties of the DOM
			//	document.setXmlVersion("1.0");
			//	document.setXmlStandalone(true);

			// Creation of the tree of the DOM

			/*		
			for (int i = 1; i < 4; i++) 
			{

			if((txt!=null) && (txt2!=null))
			{
				ArrayList messageList = (ArrayList)getList("#GEPACS~ADT$A08%PID|SD001|Mr.asdXYZ | M | Aryan | Indian");
				ArrayList templateList = (ArrayList)getList("#GEPACS~ADT$A08%PID|pid|name|sex|race|nationality");
			*/
			
			ArrayList messageList = (ArrayList)getList(message);
		//	String message = clientDB.getNextMessage(strCommdataIoApi);
			ArrayList templateList = (ArrayList)getList(template);
			Element [] elements = new Element[arr];			
			int lastElement = 0;

			for(int j=0;j<arr;j++)
			{
				int symbol = (int)((String)messageList.get(j)).charAt(0);

				if(symbol == 35 || symbol == 126 || symbol == 36 || symbol == 37)
				{					
					elements[j] = (Element) document.createElement((String)messageList.get(j+1)); 					
					if(j == 0) racine.appendChild(elements[j]);
					else elements[lastElement].appendChild(elements[j]);
					lastElement = j;
				}
				else if(symbol == 124)
				{
					elements[j] = (Element) document.createElement((String)templateList.get(j+1));
					elements[j].appendChild(document.createTextNode((String)messageList.get(j+1)));
					elements[lastElement].appendChild(elements[j]);										
				}
			}

			/*		
			Element modele = (Element) document.createElement(prop.getProperty("segment1"));					
			modele.appendChild(document.createTextNode(prop.getProperty("segment2")));
			racine.appendChild(modele);							
			Element nom = document.createElement("SEG");
			txt3 += txt + "," + txt2 + ",";
			nom.setTextContent("SEG");
			racine.appendChild(nom);
			}
			}
			*/		

			//Save the DOM in the following XML File
			transformerXml(document, "C:/MSG/ABD/Project.xml");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	} 
	catch(Exception exception)
	{
		common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:xmlCommunication) Exception:"+exception+"\n " ) ;
	}
}

public void mailCommunication()
{
	try{ }
	catch(Exception exception){ }
}

public void smsCommunication()
{
	try{ }
	catch(Exception exception){ }
}

public void webserviceComm()
{
	try
	{
		int serviceResult = 0;
		if(webserviceObj != null) 
		{
			serviceResult = webserviceObj.executeService();
			longStartTime = clientParameters.longStartTime;
		}
		else intStart = 0;

		try
		{
			if(serviceResult == 0) Thread.sleep(intRetryInterval);
			if(clientParameters.isExtConnDown) 
			{
				clientDB.updateProcessComStatus("N");
				updateRetryAttempts();				
			}
		}
		catch (Exception exp)
		{
		}		
	}
	catch (Exception exp)
	{
		common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:webserviceComm) Exception:" + exp.getMessage() + "\n " ) ;
		if(clientParameters.stackTrace) common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n"); 
	}
}

/**
 * Method to check for fileCreationInterval in file communication
 */
public void checkCreateInterval()
{  
	try
	{		
		if(strCreateFileInterval != null && !strCreateFileInterval.equals("0000"))
		{			
			int hours =	Integer.parseInt(strCreateFileInterval.substring(0,2));
			int min = Integer.parseInt(strCreateFileInterval.substring(2,4));
			long intervalInMillis = (hours*3600000)+(min*60000); //converting hours & minutes to milliseconds
			long currTime = System.currentTimeMillis();			

			if(i != 0 && (currTime - previousFileCreateTime >= intervalInMillis))
			{
				common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:checkFileInterval): File Creation Interval reached "+new Date()+"\n " ) ;		
				i++;
				writeFile.createNewFile = true;
				previousFileCreateTime = System.currentTimeMillis();
				fileToBeCreated = true;
			}

			if(i == 0)
			{				
				writeFile.createNewFile = true;
				previousFileCreateTime = System.currentTimeMillis();
				fileToBeCreated = true;
				i++;
			}
		}
		else
		{
			writeFile.createNewFile = true;
		}
	}
	catch(Exception exception)
	{			
		common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:checkCreateInterval) Exception:" + exception + "\n " ) ;
		if(clientParameters.stackTrace) common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exception) + "\n"); 
	}
}

/**
 * Foxpro DBF file generation using JDBF API
 */
public void foxproCommunication()
{
	logCounter = System.currentTimeMillis();
	while(true)
	{
		try
		{			
			String strTotalMessage = clientDB.getNextMessage(strCommdataIoApi);
			
			if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:foxproCommunication) Processing Message: "+strTotalMessage+"\n" );

			String eBillingProtocols[] = {"SRREBLP1", "SRREBLP4",
						"SRREBLP18", "SRREBLP5", "SRREBLP6", "SRREBLP24",
						"SRREBLP25", "SRREBLP26", "SRREBLP31", "SRREBLP32", "SRREBLP33", "SRREBLP34", "SRREBLP35", "SRREBLP36"};

			/************************************************ 
				Calling processMessage even if message not exists
				to create empty DBF file with column names --- as per client requirement
			************************************************/
			if(CommonUtil.equalsAny(clientParameters.strProtocolId, eBillingProtocols))
			{
				writeFile.processMessage(strTotalMessage, clientDB.strSentEventType);				
			}

			if(strTotalMessage.equals(""))
			{
				common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:fileCommunication) intNoOfMessages "+ intNoOfMessages + "\n" ) ;
				if(intNoOfMessages > 0)
				{
					common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:fileCommunication) No messages to process, exiting process...\n" ) ;
				//	cleanupResources();
					clientDB.updateProcessStatus("P", clientParameters.intConnectionCount);
					exitProcess();
				}
				else 
				{
					common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:fileCommunication) No messages to process...\n" ) ;
					Thread.sleep(intRetryInterval);
				}
			}
			else
			{
				updateMessageStatus(clientParameters.intConnectionCount, ++intNoOfMessages, "S", "S", "");
			}
		}
		catch(Exception exp)
		{
			common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:foxproCommunication) Exception:"+exp+"\n " ) ;
			if(clientParameters.stackTrace) common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");  
		}
	}
}	

public boolean checkOfflineStatus()
{
	boolean flag = false;
	
	if(clientParameters.offline)
	{
		if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:checkOfflineStatus) Offline Communication Enabled\n" ) ;
		try
		{
			String msgBuidTime = clientDB.msgBuildTime;
			String strMsgsBeforeDate = clientParameters.readBeforeDate;
			Date msgDate = CommonUtil.convertToDate(msgBuidTime,"ddMMyyyy HH:mm");
			Date beforeDate = CommonUtil.convertToDate(strMsgsBeforeDate,"ddMMyyyy HH:mm");
			if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:checkOfflineStatus)Message build time: "+ msgDate +" Target Time: "+ beforeDate +"\n" ) ;
			if(msgDate.before(beforeDate) || msgDate.equals(beforeDate))
			{
				if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:checkOfflineStatus)Message is with in specified time \n" ) ;
				flag = true;
			}
		}
		catch(Exception exp)
		{
			common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:checkOfflineStatus) Exception:"+exp+"\n " ) ;
			if(clientParameters.stackTrace) common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");  
		}
	}
	else
	{
		flag = true;
	}
	return flag;
}

public List getList(String message)
{
	int i = 0;
	arr = 0;		
	String temp = "";
	ArrayList messageArr = new ArrayList(); 
	while(i<message.length())
	{
		if((message.charAt(i) == (char)35) || (message.charAt(i) == (char)126)
						|| (message.charAt(i) == (char)36) || (message.charAt(i) == (char)124)
						|| (message.charAt(i) == (char)37))
		{	
			if(arr != 0)
			 arr++;
			 messageArr.add(arr,String.valueOf(message.charAt(i)));
			 arr++;
			 temp = "";
		}
		else
		{
			temp = temp + String.valueOf(message.charAt(i));

			messageArr.add(arr,temp);
		}
		i++;
	}
	return messageArr;
}   

public void transformerXml(Document document, String fichier) 
{
	try {
		// Creation of the DOM source
		Source source = new DOMSource(document);

		// Creation of the XML file
	//	File file = new File(fichier);
		Result resultat = new StreamResult(fichier);

		// Configuration of the transformer
		TransformerFactory fabrique = TransformerFactory.newInstance();
		Transformer transformer = fabrique.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
		transformer.transform(source, resultat);
	}catch(Exception e){
		e.printStackTrace();	
	}
}

/**
 * Method closes all the required resources like DB,socket connection etc.
 */
private void cleanupResources()
{
	try
	{
		common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:cleanupResources) Closing Remote Client Connection\n" );

		if(!clientParameters.boolDBDown)
		{
			clientDB.closeDBconn();
		}
		clientDB.closeExtDBConn(); // required for ODBC Communication

		if(socket != null) socket.close();		
		boolSocket = false;

		common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:cleanupResources) Remote Connection Closed...\n" );

		if(simSocket != null) 
		{	
			simSocket.close();
			common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:cleanupResources) Simulator Connection Closed...\n" );
		}
		if(commInterface != null) commInterface.closeResources();
	}
	catch (Exception exp)
	{
		common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:cleanupResources) Exception: " + exp + "\n" );
		common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp) + "\n");
	}
}

/**
 * Method to handle ODBC Communication
 */
public void odbcCommunication()
{		
	try
	{
		String strTotalMessage = clientDB.getNextMessage(strCommdataIoApi);

		if (strTotalMessage != null && !(strTotalMessage.equals("")))
		{
			if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:odbcCommunication) Sending Message\n" ) ; 
			
			String sentMsgSts = "S";
			String errorTxt = odbcCommunication.processMessage(strTotalMessage);

			if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "\n======\n" + strTotalMessage + "\n======\n\n" ) ;

			if(errorTxt != null && !errorTxt.equals(""))
			{
				sentMsgSts = "E";
				if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, errorTxt + "\n" ) ;
				if(clientParameters.isExternalDBDown) intStart = 0;
			}
			else
			{
				errorTxt = "Record processed successfully"; // Adding some text to errorTxt even for success message otherwise record is not getting moved to offline tables from proc
			}
			
			++intNoOfMessages;
			if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:odbcCommunication) Total Messages Processed = " + intNoOfMessages + "\n" ) ;
			longStartTime = System.currentTimeMillis(); 
			clientDB.updateMessageStatus(clientParameters.intConnectionCount,intNoOfMessages,sentMsgSts,"S",errorTxt);						
		}
		else
		{
			if((System.currentTimeMillis() - logCounter) >= 30000)
			{
				if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:odbcCommunication) No messages to process...\n" ) ;
				logCounter = System.currentTimeMillis();
			}
			Thread.sleep(intRetryInterval);
		}
	}
	catch (Exception exp)
	{
		common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:odbcCommunication) Exception: "+exp+"\n" ) ;
		common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp) + "\n");			
	}	  	
}	

	private void updateRetryAttempts()
	{								
		intStart = 0;		

		try
		{
			clientDB.updateCommRetries(++clientParameters.intConnectionCount);
			if (clientParameters.intConnectionCount >= intMaxRetries) 
			{						
				common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:updateRetryAttempts) !!! Maximum Retries Reached["+intMaxRetries+"] !!!\n");
				clientDB.updateProcessStatus("S",clientParameters.intConnectionCount);
			//	clientDB.updateApplicationMessageStatus(clientParameters.intConnectionCount,intNoOfMessages,"F","E","");

				try
				{					
					cleanupResources();
					common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:updateRetryAttempts) Closing Current Instance\n");
					common.fileOutput(clientParameters.strLogFile, "\n_______________________________________________________________________________\n\n************End of Log File*********");
					obHelper.stopServices();					
				}
				catch(Exception exp)
				{
				}

				System.exit(0);
			}

			Thread.sleep(intRetryInterval);
		}
		catch(Exception exceptionSleep)
		{				
			if(clientParameters.stackTrace) common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionSleep) + "\n");
		}
	}
	
	public void exitProcess()
	{
		exitProcess("");
	}
	
	/**
	 * To stop the process and exit. 
	 * Clears all the system resources same as cleaupRecources method, in addition to that exits the process.
	 */
	public void exitProcess(String communicationStatusMsg)
	{
		try
		{			
			common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:exitProcess) Closing Current Instance\n");			

			if(boolSocket && (socket != null)) socket.close();		
			boolSocket = false;
			
			if(simSocket != null)
			{
				simSocket.close();
				common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:cleanupResources) Simulator Connection Closed...\n" );
			}
			if(commInterface != null) commInterface.closeResources();

			if(!isCustomProcess) clientDB.updateProcessStatus("S", clientParameters.intConnectionCount);

			if(!clientParameters.boolDBDown)
			{
				clientDB.updateProcessComStatus("N", communicationStatusMsg);
				clientDB.closeDBconn();
			}
			clientDB.closeExtDBConn(); // required for ODBC Communication
			
			common.fileOutput(clientParameters.strLogFile, "\n_______________________________________________________________________________\n\n************End of Log File*********");
			if(clientParameters.isWindowsService)
			{
				obHelper.stopServices();
			}
			System.exit(0);	
		}
		catch(Exception exp)
		{
			common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
	}

	private void initConfig() throws Exception
	{
		Properties configProperties = new Properties();
		File configFile = new File(InterfaceUtil.getiniFilePath("CONFIG"));

		if(!configFile.exists())
		{
			configFile = new File("C:/eHIS/reports/properties.ini");
		}
		configProperties.load(new FileInputStream(configFile));

		clientParameters.maxQueueMessages = configProperties.getProperty("QUEUE_RECORDS");
		simulatorIPAddress = configProperties.getProperty("simluatorip");
		if(simulatorIPAddress != null && !"".equals(simulatorIPAddress.trim()))
		{
			simulatorPort = Integer.parseInt(configProperties.getProperty("simulatorport"));
		}
	}

	private void updateMessageStatus(int commRetries,int totalMessages,String msgSts,String whoSts,String fileName)
	{
		if(!clientParameters.boolDBDown)
		{
			clientDB.updateApplicationMessageStatus(commRetries, totalMessages, msgSts, whoSts, fileName);
		}
		else
		{
			common.fileOutput(clientParameters.strLogFile, 
				"(OutboundClientApplication:updateMessageStatus) DB Connection down. Unable to update message status for "+clientDB.strSentMessageId+"\n" ) ;
		}
	}

	private void init()
	{
		longStartTime = System.currentTimeMillis();
		intNoOfMessages = 0;
		intStart = 0;

		try
		{
			checkRestartApplicable();
			setCurrentTime();
			intNoOfMessages = clientDB.getMessageCountForTheProcess();
			setStoppingTime();
			clientDB.getSleepingTimeInterval();
			clientDB.getProtocolSleepingInterval();
			setCustomProcess();
			obHelper = new OBHelper(clientDB);
		}
		catch (Exception exp)
		{
			common.fileOutput(clientParameters.strLogFile, 
				"(OutboundClientApplication:init) " + exp.getMessage() + "\n" ) ;
			common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp) + "\n");			
		}
	}
	
	private void setInitParam(OutboundClientParameters client) throws Exception
	{
		common = Common.getInstance();
		clientParameters = client;				
		strApplicationId = clientParameters.strApplicationId;
		intProcessId = clientParameters.intProcessId;
		intIdleTime = clientParameters.intIdleTime*1000*60;
		strTnsName = clientParameters.strTnsName;
		setName(strApplicationId + "_" + intProcessId);		
		clientDB = new OutboundClientDBInteraction(this, clientParameters);
		String tempDebugVar = CommonUtil.getPropertyVal(InterfaceUtil.getiniFilePath("CONFIG"), "DEBUG_LOG");
		if("Y".equalsIgnoreCase(tempDebugVar)) clientParameters.debugYN = true;
	}
	
	private void checkParams()
	{
		while(clientParameters.boolDBDown)
		{
			if (clientDB.makeDBConnection())
			{
				cleanupResources();
				
				if(!clientParameters.isWindowsService)
				{
					this.runProcess(OutboundClientParameters.strExec);
				}
				common.fileOutput( this.strRenamedFile, "(OutboundClientApplication:run) Closing Current Instance\n" ) ;
				common.fileOutput( this.strRenamedFile, "\n_______________________________________________________________________________\n\n************End of Log File*********\n" ) ;
				System.exit(0);					
			}
			else
			{
				clientParameters.intConnectionCount++;						
				if (clientParameters.intConnectionCount > 0)
				{
					common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:run) Retrying Database Connection�\n" ) ;
				}
				else
				{
					common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:run) Connecting to Database�\n" ) ;
				}

				try
				{
					if (boolSocket)
					{
						cleanupResources();
					}
					thread.sleep(intRetryInterval);
				}
				catch (Exception exp)
				{
					common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp) + "\n");						
				}

				updateRetryAttempts();
			}
		}

		if (this.isReachedSleeping()) // Checking for global sleeping parameter
		{
			try
			{
				if(!clientDB.canISend())
				{
					common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:run) Waiting for Acknowledgment[Message Id:"+clientDB.strSentMessageId+"]\n" );
					clientDB.updateResendMessageStatus();
					clientDB.updateResendProcessStatus();
				}

				common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:run) !!! Sleeping Time Reached[From "+clientParameters.strSleepFrom[this.intSleepingIndex]+" To "+clientParameters.strSleepTo[this.intSleepingIndex]+"] !!!\n" );	

				cleanupResources();					
				this.sleep(this.longSleepingTime);

				common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:run) Waking up from Sleep...\n" );
			}
			catch(Exception exp)
			{
				common.fileOutput(clientParameters.strExceptionLogFile, "(OutboundClientApplication:run)" + exp + "\n" );
				common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp) + "\n");
			}
		}

		if (this.isReachedSleepingProtocol()) // Checking for protocol link level sleeping parameter
		{
			try
			{
				if(!clientDB.canISend())
				{
					common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:run) Waiting for Acknowledgment[Message Id:"+clientDB.strSentMessageId+"]\n" );
					clientDB.updateResendMessageStatus();
					clientDB.updateResendProcessStatus();
				}

				common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:run) !!! Sleeping Time Reached[From "+clientParameters.strSleepFromProtocol[this.intSleepingIndexProtocol]+" To "+clientParameters.strSleepToProtocol[this.intSleepingIndexProtocol]+"] !!!\n" );	

				cleanupResources();
				this.sleep(this.longSleepingTimeProtocol);

				common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:run) Waking up from Sleep...\n" );
			}
			catch(Exception exp)
			{
				common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:run) Protocol Exception(isReachedSleeping): "+ exp.toString() +"\n " ) ;					  
			}
		}

		if (clientDB.canIStop()) // Check for stopping the engine
		{
			try
			{
				common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:run) Received Instruction for Closing Current Instance\n" ) ;
				if(strCommunicationMode.equals("F") && strDbfFileType.equalsIgnoreCase("T")) writeFile.writeFooter();
			//	clientDB.updateProcessStatus("S",clientParameters.intConnectionCount);
				exitProcess();
/*				cleanupResources();						

				common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:run) Closing Current Instance\n" ) ;
				common.fileOutput( clientParameters.strLogFile, "\n_______________________________________________________________________________\n\n***********End of Log File****** ");
												
				obHelper.stopServices();						
			
				System.exit(0);
*/		}
			catch (Exception exp)
			{
				common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp) + "\n");					
			}
		}		

		if(this.restartTheInstance()) // Check for restart
		{
			try
			{
				common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:run) !!! Restart Time Reached["+this.getStoppingTimeMessage()+"] !!!\n" ) ;
				clientDB.updateProcessStatus("S",clientParameters.intConnectionCount);

				if(!clientDB.canISend())
				{
					common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:run) Waiting for Acknowledgment[Message Id:"+clientDB.strSentMessageId+"]\n" );
					clientDB.updateResendMessageStatus();
					clientDB.updateResendProcessStatus();
				}

				cleanupResources();

				if(clientParameters.isWindowsService)
				{
				//	String serviceName = "Hl7_" + clientDB.strApplicationId + "_" + clientDB.strFacilityId + "_" + clientDB.intProcessId;
					String serviceName = clientParameters.getServiceName();
					String stopCmd  = "sc stop " + serviceName;					

					common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:run)stopCmd"+stopCmd+"\n" );

					this.runProcess(stopCmd);

					common.fileOutput(this.strRenamedFile, "(OutboundClientApplication:run) Closing Current Instance\n" ) ;
					common.fileOutput(this.strRenamedFile, "\n_______________________________________________________________________________\n\n************End of Log File*********\n" ) ;
				}
				else
				{						
					this.runProcess(OutboundClientParameters.strExec);
					common.fileOutput(this.strRenamedFile, "(OutboundClientApplication:run) Closing Current Instance\n" ) ;
					common.fileOutput(this.strRenamedFile, "\n_______________________________________________________________________________\n\n************End of Log File*********\n" ) ;
					System.exit(0);
				}				
			}
			catch(Exception exp)
			{
				common.fileOutput( clientParameters.strExceptionLogFile, "(OutboundClientApplication:Restart)Exception "+exp+"\n" );
				common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp) + "\n"); 
			}
		}

		if ((System.currentTimeMillis() - longStartTime) > intIdleTime)
		{
			String strStoppingReason = "";
			if (!clientDB.canISend())
			{
				strStoppingReason = "Waiting for Ackowledgment";
				common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:run) !!! IdleTime Reached["+clientParameters.intIdleTime+" Min] !!!,"+strStoppingReason+"[Message Id:"+clientDB.strSentMessageId+"]\n" ) ;
				clientDB.updateResendMessageStatus();
				clientDB.updateResendProcessStatus();
			}
			else
			{
				strStoppingReason = "No Messages in Queue";
				common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:run) !!! IdleTime Reached["+clientParameters.intIdleTime+" Min] !!!,"+strStoppingReason+"\n" ) ;
			}

			clientDB.updateProcessStatus("S",clientParameters.intConnectionCount);
			cleanupResources();
			common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:run) Closing Current Instance\n" ) ;
			common.fileOutput( clientParameters.strLogFile, "\n_______________________________________________________________________________\n\n************End of Log File*********\n" ) ;

			//Before exiting the current process, stopping & uninstalling the windows services.
			obHelper.stopServices();						
			
			System.exit(0);
		}
	}

	private void setCustomProcess()
	{
		String eBillingProtocols [] = {"SRREBLP1", "SRREBLP2", "SRREBLP13", "SKREBLP1", "SRREBLP7", "SRREBLP4", "SRREBLP18", "SRREBLP5", "SRREBLP6", "SRREBLP24", "SRREBLP25", "SRREBLP26"};

		if(CommonUtil.equalsAny(strProtocolId, eBillingProtocols))
		{
			isCustomProcess = true;
			common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:setCustomProcess) Custom Process...\n" );

			try
			{
				if("SKREBLP1".equalsIgnoreCase(strProtocolId)) // Sikarin
				{
					CommonUtil.moveFiles(clientParameters.strFileDirectory, clientParameters.strFileDirectory + CommonUtil.getFormattedStringDate("ddMMyyyyHHmmss", new java.util.Date()));
					boolean isDeleted = CommonUtil.deleteFiles(new File(clientParameters.strFileDirectory + "/Processing/"));
					if(!isDeleted)
					{
						common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:setCustomProcess) Unable to delete processing("+clientParameters.strFileDirectory + "/Processing/"+") folder !!! \n" );
						exitProcess();
					}
				}
				if(customProcess == null) 
				{
					customProcess = new OutboundCustomProcess(clientParameters, clientDB);
				}
			}
			catch(Exception exp)
			{
				common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:setCustomProcess) Exception : "+exp.getMessage()+"\n" );
			}
			catch (Error error)
			{
				common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:setCustomProcess) Unable to find Custom Process API !!! \n" );
				exitProcess();
			}
		}
	}
	
	public void fetchNextMessage()
	{
		try
		{
			String strTotalMessage = clientDB.getNextMessage(strCommdataIoApi);

			if (strTotalMessage != null && !(strTotalMessage.equals("")))
			{								
				if(clientParameters.logToFile)  {
					common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:fetchNextMessage) Sending Message\n======\n" + strTotalMessage + "\n======\n");						
				}					

				String msgStatus = commInterface.sendMessage(strTotalMessage);
				++intNoOfMessages;

				if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:fetchNextMessage) Total Messages Sent="+intNoOfMessages+"\n");
				longStartTime = System.currentTimeMillis(); 
				clientDB.updateApplicationMessageStatus(clientParameters.intConnectionCount, intNoOfMessages, msgStatus, "S", "");
			}
			else
			{			
				if((System.currentTimeMillis() - logCounter) >= 30000) {
					if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:fetchNextMessage) No messages to process...\n" ) ;
					logCounter = System.currentTimeMillis();				
				}
				Thread.sleep(intRetryInterval);
			}
		}
		catch(Exception exceptionGeneral)
		{
			common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:fetchNextMessage) Exception: "+exceptionGeneral.getMessage()+"\n");
			common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exceptionGeneral) + "\n"); 

			if (exceptionGeneral.getClass().isInstance(new ConnectException())
					|| exceptionGeneral.getClass().isInstance(new SocketException())
					|| exceptionGeneral.getClass().isInstance(new IOException()) )
			{
				common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:fetchNextMessage) Remote Client Connection Failed\n");
		        try	{
					if(socket != null) socket.close();				
					if(simSocket != null) simSocket.close();
				}
				catch (Exception exp){}	
				updateRetryAttempts();
				clientDB.updateProcessComStatus("N");
			}
			clientDB.updateApplicationMessageStatus(clientParameters.intConnectionCount,intNoOfMessages,"E","S","");
		}
	}
	
}
