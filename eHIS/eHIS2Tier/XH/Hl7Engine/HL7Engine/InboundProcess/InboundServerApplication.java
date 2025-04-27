/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
*/
package HL7Engine.InboundProcess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import HL7Engine.Common.Common;
import HL7Engine.Common.CommonUtil;

import com.isoft.interfaceengine.validations.InboundCustomProcess;

public class InboundServerApplication extends Thread
{
	Common common = null;
	CommonUtil commonUtil = new CommonUtil();
	Socket socket;
	Thread thread;

	InputStream inSocketStream;
	OutputStream outSocketStream;
	BufferedWriter outboundStream;

	InboundServerRead serverReadProcess;
	InboundServerDBInteraction serverDB;

	InboundServerParameters serverParameters;
	InboundListener inboundListener;	
	
	int intProcessId = 0;
	int intPollingTime = 1000;
	int intIdleTime = 0;	
	int intMaxRetries = 0;
	int intRetryInterval = 0;
	int retries = 0;
	int totalRetries = 0;
	int retryInterval = 1000;
	int intBeforeBreakSleep = 2000;	
	int intQueryResponseTime = 42;

	int intBlockSize = 2048;		
	int intNoOfMessages = 0;		

	long logCounter;
	
	String strApplicationId = "0";
	String strFileDirectory;
	String strExtension;
	String strDbfFileType;
	String strFileNamingConvention;
	String xslFileName;
	String messageStart;
	String messageEnd;
	String logY_N = "N";
	String strCommunicationMode;
	String strRenamedFile = "";	

	File inputFile;
	File fileListDir;

	boolean startThread = false;	// flag used for file communication.
	boolean isInitialized = false;	// flag used for file communication.
	boolean isLSSent = false; // used in PABX
	boolean isLASent = false; // used in PABX
	boolean isCustomProcess = false;

	InboundRs232Communication rs232ReadData;
	ODBCInboundCommunication odbcInboundProcess;

	/**
	 * Constructor for other than TCP/IP communication
	 */
	public InboundServerApplication(InboundServerParameters parameters,InboundListener inboundListener)
	{
		common = Common.getInstance();
		serverParameters = parameters;
		strApplicationId = parameters.strApplicationId;
		intProcessId = parameters.intProcessId;
		intIdleTime = parameters.intIdleTime*1000*60;// in minutes --> milli secs
		strFileDirectory = parameters.strFileDirectory;
		strDbfFileType = parameters.strDbfFileType;
		intMaxRetries = parameters.intMaxRetries;
		intRetryInterval = parameters.intRetryInterval * 1000;
		strFileNamingConvention = parameters.strFileNamingConvention;		
		xslFileName = parameters.xslFileName;
		messageStart = parameters.messageStart;
		messageEnd = parameters.messageEnd;
		strCommunicationMode = parameters.strCommunicationMode;
		this.inboundListener = inboundListener;

		setName(strApplicationId);
		thread = this;

		serverDB = inboundListener.serverDB;
		serverDB.checkEHISDBConn();
		if (serverParameters.isDBDown) 
		{
			serverDB.makeDBConnection();
			if (serverParameters.isDBDown) 
			{
				common.fileOutput( serverParameters.strLogFile, "(InboundServerApplication) Database Connection failed... \n" ) ;
				return;
			}
		}		
				
		try
		{
			if(serverParameters.logToFile) logY_N = "Y";
			serverDB.updateProcessStatus("A");			//Needs to be checked, same already called in InboundListener
			serverDB.partialMsgAckList = new ArrayList();					
			serverDB.ackMessageList = new ArrayList();
			serverParameters.longStartTime = System.currentTimeMillis();

			if(strCommunicationMode.equalsIgnoreCase("F"))
			{	
				serverParameters.getNextMessage = true;
				common.fileOutput( serverParameters.strLogFile, "(InboundServerApplication) fileCommunication()... \n" ) ;
				fileCommunication();
			}			
			else if(strCommunicationMode.equalsIgnoreCase("R"))
			{
				rs232Communication();
			}
			else if(strCommunicationMode.equalsIgnoreCase("D"))
			{			
				odbcCommunication();
			}
		}
		catch(Exception exceptionSocket)
		{								
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionSocket) + "\n" ) ;
		}
		serverParameters.isConnected = true;
	}

	public InboundServerApplication(Socket sock, InboundServerParameters server,InboundListener inboundListener)
	{	
		common = Common.getInstance();
		//socket = sock; // Commented by Sethu for MOHE-SCF-0233 on 20/04/2023
		serverParameters = server;
		strApplicationId = server.strApplicationId;
		intProcessId = server.intProcessId;
		intIdleTime  = server.intIdleTime * 1000 * 60;// in minutes --> milli secs
		setName(strApplicationId);
		thread = this;
		this.inboundListener = inboundListener;

		serverDB = inboundListener.serverDB;
		serverDB.checkEHISDBConn();
		if (serverParameters.isDBDown) 
		{
			serverDB.makeDBConnection();
			if (serverParameters.isDBDown) return;
		}		
		
		try
		{	
			// Added by Sethu for MOHE-SCF-0233 on 20/04/2023  - STARTS HERE
    		if (socket != null)
    			socket.close();
    		
			// Moved by Sethu for MOHE-SCF-0233 on 20/04/2023
			socket = sock;
			
    		if (inSocketStream != null)
        		inSocketStream.close();
    		
    		if (outSocketStream != null)
    			outSocketStream.close();
    		
    		if (outboundStream != null)
    			outboundStream.close();
    		
    		if (serverReadProcess != null)
    			serverReadProcess = null;
    		
    		// Code changes Added by Sethu for MOHE-SCF-0233 on 20/04/2023 - ENDS HERE
    		
			strCommunicationMode = serverParameters.strCommunicationMode;			
		
			inSocketStream = socket.getInputStream();
			outSocketStream = socket.getOutputStream();	
			outboundStream = new BufferedWriter(new OutputStreamWriter(outSocketStream,"UTF8"));
			
			serverDB.partialMsgAckList = new ArrayList();					
			serverDB.ackMessageList = new ArrayList();
			
			serverParameters.linkProtocolIDEnabled = serverDB.getLinkProtocolStatus();
			
			common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication) InboundServerRead...\n" ) ;
			serverReadProcess = new InboundServerRead(inSocketStream,serverDB);
			serverParameters.longStartTime = System.currentTimeMillis();
		}
		catch(Exception exceptionSocket)
		{						
			common.fileOutput( serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionSocket) + "\n" ) ;
		}

		serverParameters.isConnected = true;
		this.start();
	}

	public void run()
	{
		serverParameters.longStartTime = System.currentTimeMillis();

		try
		{		
			retryInterval = serverParameters.intRetryInterval * 1000;

			if("SRREBLP8".equals(serverParameters.strProtocolId) // Monthly
				|| "SRREBLP9".equals(serverParameters.strProtocolId) // Quaterly
				|| "SRREBLP12".equals(serverParameters.strProtocolId) // CGOP - Fortnight
				|| "SRREBLP17".equals(serverParameters.strProtocolId)
				|| "SRREBLP11".equals(serverParameters.strProtocolId)
				|| "SRREBLP14".equals(serverParameters.strProtocolId)
				|| "SRREBLP19".equals(serverParameters.strProtocolId)
				|| "SRREBLP10".equals(serverParameters.strProtocolId)
				|| "SRREBLP20".equals(serverParameters.strProtocolId))
			{
				isCustomProcess = true;
				InboundCustomProcess customProcess = new InboundCustomProcess(serverParameters, serverDB);
				customProcess.runProcess();
				serverDB.updateProcessStatus("P"); //No impact on MOH Egypt
				exitProcess();
			}
		}
		catch(Exception exp)
		{
			common.fileOutput( serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ; 
		}

		while(true)
		{			
			try
			{
				checkParams();

				if(serverParameters.linkProtocolIDEnabled)
				{
					if(!serverReadProcess.isAlive())
					{
						serverDB.updateProcessComStatus("N");
						common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:run) Client connection down...\n" ) ;
						serverReadProcess.isLAReceived = false;
						isLSSent = false;
						throw new SocketException("Client connection down");
					}

					sendPABXMessage();
				}
				else
				{	
					if (strCommunicationMode.equalsIgnoreCase("T") || strCommunicationMode.equalsIgnoreCase("R"))
					{
						if(!serverReadProcess.isAlive())
						{
							serverDB.updateProcessComStatus("N");
							common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:run) EM Listener Service connection down...\n" ) ;
							throw new SocketException("EM Listener Service connection down");
						}
					}
					else if(strCommunicationMode.equalsIgnoreCase("F") && serverParameters.getNextMessage)
					{
						serverParameters.getNextMessage = false;
						serverParameters.filePath = getNextFileName();
						common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:run) File Path:"+serverParameters.filePath+"\n" ) ;
						serverReadProcess.fileProcessed = false;
					}
					processAcknowledgements();
				}
				
				//Closing DB Conn & socket, once query is processed and all acknowledgements are transmitted. Used in Solicited approach.
				if(serverDB.ackMessageList.isEmpty() && serverDB.ackSent && serverDB.partialMsgAckList.isEmpty())
				{
					if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerApplication:run)Sent Query Response for "+serverDB.strQueryId+", closing instance...\n" );				
					cleanupResources();	
					break;
				}
				
				try
				{
					thread.sleep(intPollingTime);
				}
				catch(Exception exceptionSleep)
				{	
					common.fileOutput( serverParameters.strExceptionLogFile, "(InboundServerApplication:run)Exception(insleep):"+exceptionSleep+"\n" ) ;					
				}									
			}
			catch(SocketException readProcessExp)
			{
				common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:run) "+readProcessExp.getMessage()+"\n" ) ;
				common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(readProcessExp) + "\n" ) ;
				common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:run) From Socket Exception *********************** Database Connection Closed *********************** \n" );
				serverDB.closeDBconn(); //Added by Sethu on 27/03/2023 for MOHE-SCF-0233
				serverParameters.isConnected = false;
				break;
			}
			catch(Exception exceptionGeneral)
			{	
				common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:run) Exception: "+exceptionGeneral+"\n" ) ;
				common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionGeneral) + "\n" ) ;

				if (exceptionGeneral.getClass().isInstance(new ConnectException()) ||
					exceptionGeneral.getClass().isInstance(new IOException()) )
				{
					serverDB.closeDBconn(); //Uncommented by Sethu on 27/03/2023 for MOHE-SCF-0233
					serverParameters.isConnected = false;
					break;	
				}
			//	cleanupResources();
			//	break;		
			}
		}// End of While		
	}

	private void processAcknowledgements()
	{
		intNoOfMessages = 0;
		int logMsgCount = 0;

		String strTotalMessage = "";
		boolean isPartialMsg = false;

		try
		{
			if(serverDB.ackMessageList != null && !serverDB.ackMessageList.isEmpty())
			{
				strTotalMessage = (String)serverDB.ackMessageList.get(0);
			}
			else if(strCommunicationMode.equalsIgnoreCase("F") && serverReadProcess.fileProcessed)
			{
				serverParameters.getNextMessage = true;
			}
			if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerApplication:processAcknowledgements) processAcknowledgements Message "+strTotalMessage+"\n" ) ;

			if ((strTotalMessage == null || strTotalMessage.equals("")) 
					&& (serverDB.partialMsgAckList != null && !serverDB.partialMsgAckList.isEmpty()))
			{
				strTotalMessage = (String)serverDB.partialMsgAckList.get(0);							

				if(strTotalMessage == null || strTotalMessage.trim().equals(""))
				{
					serverDB.partialMsgAckList.remove(0);
				}
				else
				{
					isPartialMsg = true;
					if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerApplication:processAcknowledgements)Symbol missing "+strTotalMessage+"\n" ) ;
				}						
			}						

			if (strTotalMessage != null && !strTotalMessage.equals(""))
			{
				if(strCommunicationMode.equalsIgnoreCase("F"))
				{					
					String tempFileName = serverParameters.currentFile.substring(0,serverParameters.currentFile.lastIndexOf("."));
					CommonUtil.makeDirectory(serverParameters.strAckFileDirectory);
					String filePath = serverParameters.strAckFileDirectory + tempFileName + "_ack" + strExtension;
					if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerApplication:processAcknowledgements) Ack File "+filePath+"\n" ) ;
					outSocketStream = new FileOutputStream(filePath,true);
				}

				if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerApplication:processAcknowledgements) Sending Acknowledgement: "+strTotalMessage+"\n" ) ;
				
				if(!strCommunicationMode.equalsIgnoreCase("R"))
				{						
					try
					{
						serverParameters.longStartTime = System.currentTimeMillis();
						outSocketStream.write(strTotalMessage.getBytes());
						
						++intNoOfMessages;
						
						if(!isPartialMsg) // not updating status while sending ack for partial msgs
						{
							isPartialMsg = false;
						//	serverDB.updateQueryMessageStatus(serverParameters.strCommStatistics, "S");
						}
						else common.fileOutput( serverParameters.strLogFile, "(InboundServerApplication:processAcknowledgements) Partial Message\n" ) ;

						if(strCommunicationMode.equalsIgnoreCase("F") && outSocketStream != null) outSocketStream.close();
					}
					catch(Exception exp)
					{
						serverDB.updateQueryMessageStatus(serverParameters.strCommStatistics,"E");
						common.fileOutput( serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
					}
				}
				else
				{
					try
					{
						rs232ReadData.writeMessage(strTotalMessage);

						serverParameters.longStartTime = System.currentTimeMillis();
						++intNoOfMessages;

						if(!isPartialMsg) // not updating status while sending ack for partial msgs
						{
							serverDB.updateQueryMessageStatus(serverParameters.strCommStatistics,"S");
						}
					}
					catch(Exception exp)
					{
						serverDB.updateQueryMessageStatus(serverParameters.strCommStatistics,"E");
						common.fileOutput( serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
					}
				}

				if(!serverDB.ackMessageList.isEmpty()) serverDB.ackMessageList.remove(0); // removing the transmitted ack msg from the list.
				if(!serverDB.partialMsgAckList.isEmpty()) serverDB.partialMsgAckList.remove(0); // removing the transmitted ack msg from the list.
				
				try
				{					
					isPartialMsg = false;
					Thread.sleep(intBeforeBreakSleep);
				}
				catch(Exception exceptionSleep)
				{							
					if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerApplication:processAcknowledgements)Exception in Sleep\n" ) ;				
				}								
			}		

			if(logMsgCount++ == 20)
			{
				if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerApplication:processAcknowledgements) No Acknowledgements to process...)\n" ) ;
				logMsgCount = 0;
			}
		}
		catch(Exception exp)
		{
			if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerApplication:processAcknowledgements) Exception:"+exp+"\n" ) ;
			common.fileOutput( serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
	}

	/**
	*  Method gets the next file name for file communication.
	*  If the file is not available, process retries for the file till it reaches maxRetries and tries to fetch next file
	**/
	public void fileCommunication()
	{
		strDbfFileType = "T";
		if(strDbfFileType.equalsIgnoreCase("H")) strExtension = ".hl7";
		if(strDbfFileType.equalsIgnoreCase("T")) strExtension = ".txt";
		if(strDbfFileType.equalsIgnoreCase("X")) strExtension = ".xml";
		if(strDbfFileType.equalsIgnoreCase("F")) strExtension = ".txt";		
		
		String filePath = "";
		String fileNamingApi = null;
		inputFile = null;
		
		try
		{		
			if(strDbfFileType.equalsIgnoreCase("X")) // indicates XML Communication
			{
				filePath = transformXMLToText(strFileDirectory + fileNamingApi);			
			}
			else if(!strDbfFileType.equalsIgnoreCase("F")) // indicates non-foxpro file communication
			{		
			//	filePath = strFileDirectory + fileNamingApi ;			
			}
			else // foxpro file communication
			{		
				try
				{
					if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerApplication:fileCommunication) Foxpro Communication\n" ) ;

					Runtime runtime = Runtime.getRuntime();								
					String execDirectory = serverParameters.logDirectory;
					String endChar = execDirectory.substring( execDirectory.length()-1, execDirectory.length() );

					if( !endChar.equals("/") ) 
					{
						execDirectory = execDirectory + "/";
					}

					if(serverParameters.messageStart == null)
					{						
						messageStart = ""+((char)11);
						serverParameters.messageStart = "11"; // default message start character for foxpro file communication				
					}
					else
					{
						messageStart = serverParameters.messageStart; 
						messageStart = splitMessageDelimiters(messageStart);
					}
					if(serverParameters.messageEnd == null)
					{
						messageEnd = "" + ((char)28)+((char)28)+((char)28);
						serverParameters.messageEnd = "28|28|28"; // default message end character for foxpro file communication				
					}
					else
					{
						messageEnd = serverParameters.messageEnd;
						messageEnd = splitMessageDelimiters(messageEnd);
					}

					String messageSegmentStart = splitMessageDelimiters(serverParameters.messageSegmentStart);
					String messageSegmentEnd = splitMessageDelimiters(serverParameters.messageSegmentEnd);

					String dbfExecutable = execDirectory + "INBOUND_INTERFACE.exe "+  // .net exe file path
												strFileDirectory + "," + // directory where the .dbf file is kept
												strFileNamingConvention + "," + // .dbf file name
												messageStart + "," +  // indicates what should be the starting char of the generated message
												messageEnd +  // end char of each message
												messageSegmentStart + "," +
												messageSegmentEnd + "," +
												splitMessageDelimiters(serverParameters.fieldSeperator) + "," + // field seperator											
												strFileDirectory + "," + // directory where the generated .txt will be stored
												fileNamingApi + "," +// .net exe will generate .txt file with this name
												logY_N; // indicates .net trace enable/disable
					if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerApplication:fileCommunication)DotNet exec Command: " + dbfExecutable + "\n" ) ;
					runtime.exec(dbfExecutable);
				}
				catch(Exception exception)
				{
					common.fileOutput( serverParameters.strExceptionLogFile, "(InboundServerApplication:DBF fileCommunication:Exception) "+exception.toString()+"\n" ) ;
					common.fileOutput( serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exception) + "\n" ) ;
				}
				filePath = strFileDirectory + fileNamingApi ;	
			}						

			this.start();
		//	serverParameters.filePath = fileNamingApi;
		}
		catch(Exception exp)
		{
			common.fileOutput( serverParameters.strLogFile, "(InboundServerApplication:fileCommunication) Exception: " + exp.toString() + "\n" ) ;
			common.fileOutput( serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}		
	}

	public void rs232Communication()
	{
		if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "------ (InboundServerApplication:rs232Communication) ------ \n" ) ;
		rs232ReadData = new InboundRs232Communication(serverParameters.logToFile, serverParameters.strLogFile, serverParameters.strExceptionLogFile,serverDB);
		boolean boolCheckDir = rs232ReadData.checkRsCommunicationStatus();

		if (boolCheckDir == false)
		{
			serverDB.registerError("rs232WriteData.checkRsCommunicationStatus","The RS-232 connection  does not exist");
			if( serverParameters.logToFile ) common.fileOutput( serverParameters.strLogFile, "(InboundServerApplication:rs232Communication)rs232ReadData.checkRsCommunicationStatus: RS-232 connection  does not exist\n" );
			serverDB.updateProcessStatus("C");
		//	serverDB.closeDBconn();
			return;					
		}

		try
		{
			serverDB.updateProcessStatus("A");
		//	inSocketStream = rs232ReadData.readMesssge();
		//	outSocketStream = socket.getOutputStream();		
			if( serverParameters.logToFile ) common.fileOutput( serverParameters.strLogFile, "(InboundServerApplication:rs232Communication) InputSocketStream\n" );		
		//	serverReadProcess = new InboundServerRead(inSocketStream,serverDB);
			rs232ReadData.startReadProcess();
			serverParameters.longStartTime = System.currentTimeMillis();
		}
		catch(Exception exceptionSocket)
		{
			System.out.println(" Error Exception "+exceptionSocket);
			common.fileOutput( serverParameters.strExceptionLogFile, "(InboundServerApplication) Exception:"+exceptionSocket+"\n" ) ;		
		}

		this.start();
	}

	public void odbcCommunication()
	{	
		boolean dbConnExists = false;
		try
		{			
			dbConnExists = serverDB.getExternalDBConnection();

			if(dbConnExists)
			{
				odbcInboundProcess = new ODBCInboundCommunication(serverParameters,serverDB);
				serverParameters.longStartTime = System.currentTimeMillis();			
			}
			else
			{
				IBHelper.getInstance(serverDB).checkExeDBConnection();
			}
		}
		catch(Exception exceptionSocket)
		{
			common.fileOutput( serverParameters.strExceptionLogFile, "(InboundServerApplication:odbcCommunication) Exception:"+exceptionSocket+"\n" );
		}

		if(dbConnExists) this.start();
		else
		{
			exitProcess();
		}
	}

	/**
	 * Utility method used to get the msg start and end chars from the ascii numbers
	 * @PARAM format string that has to be tokenized and converted to special char.
	 */
	public String splitMessageDelimiters(String format)
	{
		StringBuffer temp = new StringBuffer();
		int nextToken = 0;
		StringTokenizer tokenizer = null;
		
		tokenizer = new StringTokenizer(format,"|");		
		while(tokenizer.hasMoreTokens())
		{
			nextToken = Integer.parseInt(tokenizer.nextToken());
			temp.append(((char)nextToken));
		}
		return (temp.toString());
	}

	/**
	*  Method to check whether offline communication is enabled and to check whether file can be read by getting the file modified date.
	**/
	public boolean checkOfflineStatus()
	{
		boolean flag = false;
		if(serverParameters.offline)
		{
			if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerApplication:checkOfflineStatus) Offline Communication Enabled\n" ) ;
			try
			{
				long fileBuidTime = inputFile.lastModified();
				long readBeforeDateTime = commonUtil.getTimeInMillis(serverParameters.readBeforeDateTime,"ddMMyyyy HH:mm");
			//	Date msgDate = commonUtil.convertToDate(fileBuidTime,"ddMMyyyy HH:mm");
			//	Date beforeDate = commonUtil.convertToDate(readBeforeDateTime,"ddMMyyyy HH:mm");
			//	if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(InboundServerApplication:checkOfflineStatus)Message build time: "+ msgDate +" Target Time: "+ beforeDate +"\n" ) ;
				if(fileBuidTime <= readBeforeDateTime)
				{
					if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerApplication:checkOfflineStatus)File is with in the specified time \n" ) ;
					flag = true;
				}
				else
				{
					if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerApplication:checkOfflineStatus)File is not with in the specified time \n" ) ;
					flag = false;
				}
			}
			catch(Exception exp)
			{
				if(serverParameters.logToFile) common.fileOutput( serverParameters.strExceptionLogFile, "(InboundServerApplication:checkOfflineStatus) Exception:"+exp+"\n " ) ;
			}
		}
		else
		{
			flag = true;
		}
		return flag;
	}

	// Method returns oldest of all the  files in the directory based on the last modified time of the file.
	String getNextFileName()
	{		
		File tempFile = null;
		File [] oFileList;
		String fileNamingApi = null;

		try
		{
		//	long currTime = System.currentTimeMillis();
			if(!isInitialized)
			{
				if(strDbfFileType.equalsIgnoreCase("H")) strExtension = ".hl7";
				if(strDbfFileType.equalsIgnoreCase("T")) strExtension = ".txt";
				if(strDbfFileType.equalsIgnoreCase("X")) strExtension = ".xml";
				if(strDbfFileType.equalsIgnoreCase("F")) strExtension = ".txt";
				fileListDir = new File(strFileDirectory);
				while(true)
				{
					if(!fileListDir.exists()) 
					{
						if(serverParameters.logToFile) {
							common.fileOutput(serverParameters.strLogFile, 
								"(InboundServerApplication:getNextFileName) Folder does not exist...\n");
						}
						updateRetryCount();
					}
					else 
					{
						serverDB.updateProcessComStatus("Y");
						break;
					}
				}
			}

			oFileList = fileListDir.listFiles();
			tempFile = oFileList[0];
			int totFiles = oFileList.length;

			for (int i = 0; i < totFiles; i++)
			{				
				if (tempFile.isFile()) break;
				else tempFile = oFileList[i];
			}

			while(!tempFile.isFile())
			{
				if(serverParameters.logToFile) common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:getNextFileName) No files to read...\n");
				updateRetryCount();
				
				oFileList = fileListDir.listFiles();
				tempFile = oFileList[0];
				totFiles = oFileList.length;

				for (int i = 0; i < totFiles; i++)
				{
					if (tempFile.isFile()) 
					{
						String fileExt = tempFile.getName();
						fileExt = fileExt.substring(fileExt.lastIndexOf("."));
						if(fileExt.equalsIgnoreCase(strExtension)) break;
						else tempFile = oFileList[i];
					}
					else tempFile = oFileList[i];
				}			
			}

			retries = 0;

			for (int i = 0; i < totFiles; i++)
			{				
				if (tempFile != null && ((tempFile.lastModified() - oFileList[i].lastModified()) > 0) && (oFileList[i].isFile()) && (oFileList[i].length()>0))
				{					
					tempFile = oFileList[i];
				}				
			}
			
			/*
			// Added for GHL-SCF-1398 by Kapil
			for (int i = 0; i < totFiles; i++)
			{				
				if ((oFileList[i].length()>0))
				{					
					tempFile = oFileList[i];
				}				
			}
			*/

			common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:getNextFileName) before isInitialized: \n");
			
			if(!isInitialized)
			{
				isInitialized = true;	
				common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:getNextFileName) inSocketStream: "+inSocketStream+"\n");
				serverReadProcess = new InboundServerRead(inSocketStream,serverDB);
				common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:getNextFileName) InboundServerRead... \n");
				serverParameters.longStartTime = System.currentTimeMillis();
			}
			
			serverParameters.currentFile = tempFile.getName();
			fileNamingApi = strFileDirectory + serverParameters.currentFile;
		}
		catch(Exception exception)
		{
			common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:getNextFileName) Exception:"+exception+"\n" ) ;		
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exception) + "\n" ) ;
		}
		return fileNamingApi;
	}

	String transformXMLToText(String fileNamingApi) throws Exception
	{
		FileOutputStream fos = null;
		FileOutputStream outputstream = null;

		try
		{
			File xmlFile = new File(fileNamingApi);
			File xsltFile = new File(xslFileName);

			Source xmlSource = new StreamSource(xmlFile);
			Source xsltSource = new StreamSource(xsltFile);

			String tempFileName = fileNamingApi.substring(0, fileNamingApi.lastIndexOf("."));

			TransformerFactory transFact = TransformerFactory.newInstance();
			Transformer transformer = transFact.newTransformer(xsltSource);
			outputstream = new FileOutputStream(tempFileName + ".txt", false) ;		

			fileNamingApi = null;
			transformer.transform(xmlSource, new StreamResult(outputstream));
			fileNamingApi = tempFileName + ".txt";			

			if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerApplication:transformXMLToText) XML file transfomred to " + fileNamingApi + " \n" ) ;			
		}
		catch(Exception exception)
		{
			common.fileOutput(serverParameters.strExceptionLogFile, "(InboundServerApplication:transformXMLToText) Exception:"+exception.getMessage()+"\n" ) ;
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exception) + "\n" ) ;
		}
		finally
		{
			if(outputstream != null) outputstream.close();
			if(fos != null) fos.close();
		}
		return fileNamingApi;
	}		

	private void cleanupResources()
	{
		try
		{						
			if(outSocketStream != null) outSocketStream.close();
			if(inSocketStream != null) inSocketStream.close();
			if(socket != null) socket.close();
			serverParameters.isConnected = false;
			common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:cleanupResources) From cleanupResources *********************** Database Connection Closed *********************** \n" );
			serverDB.closeDBconn(); //Uncommented by Sethu on 27/03/2023 for MOHE-SCF-0233
			serverDB.closeExtDBconn();
		}
		catch (Exception exp)
		{			
			common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:cleanupResources) Exception "+exp+"\n" ) ;
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
	}

	public synchronized void restartProcess()
	{
		serverParameters.isRestartTimeReached = false;
		try
		{
			cleanupResources();
			common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:restartProcess) From restartProcess *********************** Database Connection Closed *********************** \n" );
			serverDB.closeDBconn();
			serverDB.closeExtDBconn();

			if (serverParameters.isWindowsService)
			{
				inboundListener.serverMonitor.stopService(false); // No need to start the service,ServiceRestart class will take care of restarting the service.
			}
			else
			{
				inboundListener.serverMonitor.runProcess(InboundServerParameters.strExec);
				System.exit(0);
			}						
		}
		catch (Exception exp)
		{
			common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:restartProcess) Exception "+exp+"\n" ) ;
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
	}
	
	public synchronized void exitProcess()
	{
	//	serverParameters.isIdleTimeReached = false;
		common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:exitProcess) Closing Current Instance\n" ) ;
		try
		{
			if(!isCustomProcess) serverDB.updateProcessStatus("S");
			serverDB.updateProcessComStatus("N");
			cleanupResources();
			common.fileOutput(serverParameters.strLogFile, "\n_______________________________________________________________________________\n\n************End of Log File*********\n" ) ;
			
			if(serverParameters.isWindowsService)
			{
				inboundListener.serverMonitor.stopService(true);
			}
			
			System.exit(0);
		}
		catch(Exception exp)
		{
			common.fileOutput( serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
		finally
		{
		}		
	}

	public void checkAppAckMsgs()
	{
		try
		{
			ArrayList list = (ArrayList)serverDB.getAppAckMsg();
			if(list != null)
			{
				String fileName = (String)list.get(1);
				if(fileName == null || fileName.equals(""))
				{
					fileName = serverParameters.strAckFileDirectory + "APP_ACK.txt";
				}
				else
				{
					fileName = fileName.substring(0,(fileName.lastIndexOf(".") - 1)) + "_APP_ACK.txt";
				}
				common.fileOutput( serverParameters.strLogFile, "(InboundServerApplication:checkAppAckMsgs) FileName "+fileName+"\n" );

				FileOutputStream fOutStream = new FileOutputStream(fileName);
				fOutStream.write( ((String)list.get(0)).getBytes() );
				fOutStream.close();

				boolean flag = serverDB.updateApplicationAckStatus((String)list.get(2),(String)list.get(3));
				if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(InboundServerApplication:checkAppAckMsgs) Status Updated "+flag+"\n" );
			}
		}
		catch (Exception exp)
		{			
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
	}

	private void sendPABXMessage()
	{
		try
		{
		//	String strTotalMessage = getNextMessage();
			String strTotalMessage = null;
			
			if(!serverParameters.sendPABXLEMsg && (serverDB.ackMessageList != null && !serverDB.ackMessageList.isEmpty()))
			{
				strTotalMessage = (String)serverDB.ackMessageList.get(0);
				serverDB.ackMessageList.remove(0);
			}

			if (strTotalMessage != null && !(strTotalMessage.equals("")))
			{
				if(serverParameters.logToFile) common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:sendPABXMessage) Sending Message...\n" ) ; 
									
				outboundStream.write(strTotalMessage);
				outboundStream.flush();					
				
				if(serverParameters.logToFile) common.fileOutput(serverParameters.strLogFile, "\n======\n" + strTotalMessage + "\n======\n\n" ) ;
			}
			else 
			{
				strTotalMessage = getNextMessage();
				if (strTotalMessage != null && !(strTotalMessage.equals("")))
				{				
					if(serverParameters.logToFile) common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:sendPABXMessage) Sending Message...\n" ) ; 
									
					outboundStream.write(strTotalMessage);
					outboundStream.flush();					
					
					if(serverParameters.logToFile) common.fileOutput(serverParameters.strLogFile, "\n======\n" + strTotalMessage + "\n======\n\n" ) ;

					++intNoOfMessages;
				//	++intLogMessages;

					if(serverParameters.logToFile) common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:sendPABXMessage) Total Messages Sent="+intNoOfMessages+", Total Messages Received="+serverParameters.totalMessages+"\n" ) ;
					serverParameters.longStartTime = System.currentTimeMillis();
					serverDB.updateApplicationMessageStatus(0,intNoOfMessages,"S","S","");					
				}
				else
				{			
					if((System.currentTimeMillis() - logCounter) >= 30000)
					{
						if(serverParameters.logToFile && isLASent) common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:sendPABXMessage) Message not exists...\n" ) ;
						logCounter = System.currentTimeMillis();				
					}
				}
			}
		}
		catch(Exception exp)
		{
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
	}

	/**
	 * Method used for PABX Protocol. Checks and returns the type of message that has to be transmitted.
	 * Initially message with LS segment will be sent. 
	 * Once external interface replies with LA message, builds and sends reply LA message with updated datetime,
	 * after which all the pending PABX messages will be sent from repository.
	 */
	private synchronized String getNextMessage()
	{
		String message = null;
		try
		{
			if(serverParameters.sendPABXLEMsg)
			{
				message = buildPABXMessage("LE");

				common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:getNextMessage) Sending LE Message...\n" ) ; 
				outboundStream.write(message);
				outboundStream.flush();			
				serverParameters.isLESent = true;				
				common.fileOutput(serverParameters.strLogFile, "\n======\n" + message + "\n======\n" ) ;
				message = null;
			}
			else if(isLASent)
			{
				message = serverDB.getNextMessage();
			}
			else if(!isLSSent)
			{
				message = buildPABXMessage("LS");

				common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:getNextMessage) Sending LS Message...\n" ) ; 
				outboundStream.write(message);
				outboundStream.flush();	
				isLSSent = true;
				serverReadProcess.isLSSent = true;				
				common.fileOutput(serverParameters.strLogFile, "\n======\n" + message + "\n======\n" ) ;
				message = null;
			}
			else if(serverReadProcess.isLAReceived)
			{
				message = buildPABXMessage("LA");

				common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:getNextMessage) Sending LA Message...\n" ) ; 
				outboundStream.write(message);
				outboundStream.flush();	
				isLASent = true;				
				common.fileOutput(serverParameters.strLogFile, "\n======\n" + message + "\n======\n" ) ;
				message = null;
			}			
		}
		catch(Exception exp)
		{
			common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:getNextMessage) Exception "+exp+"\n" ) ;
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
		return message;
	}

	/**
	 * Method used for PABX protocol to build appropriate message to send.
	 */
	private synchronized String buildPABXMessage(String segmentType)
	{
		StringBuffer msgBuffer = new StringBuffer();
		String fieldSeperator = "|";
		try
		{
			msgBuffer.append((char)2);
			msgBuffer.append(segmentType);
			msgBuffer.append(fieldSeperator);
			msgBuffer.append("DA");
			msgBuffer.append(CommonUtil.getFormattedStringDate("yyMMdd",new java.util.Date()));
			msgBuffer.append(fieldSeperator);
			msgBuffer.append("TI");
			msgBuffer.append(CommonUtil.getFormattedStringDate("HHmmss",new java.util.Date()));
			msgBuffer.append(fieldSeperator);
			msgBuffer.append((char)3);						
		}
		catch(Exception exp)
		{
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
		return msgBuffer.toString();
	}

	/**
	 * Method updates the retry count, if the count exceeds max number process will terminated
	 */
	public void updateRetryCount() throws Exception
	{
		if(intMaxRetries == 0)
		{
			if(serverParameters.logToFile) common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:updateRetryCount) Max retries Empty \n" );
			exitProcess();
		}
		else if(retries >= intMaxRetries && serverParameters.isRetryParamEnabled)
		{					
			if(serverParameters.logToFile) common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:updateRetryCount) Max retries reached [" + retries + "]\n");
			exitProcess();
		}
		else
		{					
			Thread.sleep(intRetryInterval);
			retries++;				
		}
	}

	private void checkParams()
	{
		try
		{
			while(serverParameters.isDBDown)
			{
				common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:run) Retrying database connection...\n" );
				if(serverDB.makeDBConnection())
				{
					common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:run) Database connection successfull...\n" );
					restartProcess();
				}
				else updateRetryAttempts();
			}

			if (serverParameters.isRestartTimeReached)
			{					
				restartProcess();
			}				
			else if (serverParameters.isIdleTimeReached || serverParameters.isMaxRetriesReached)
			{						
				exitProcess();
			}
		/*	else if(serverParameters.isSleepTimeReached)
			{
				Thread.sleep(serverParameters.);
			}*/
		}
		catch (Exception exp)
		{
			common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:checkParams) Exception "+exp+"\n" ) ;
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
	}

	private void updateRetryAttempts()
	{
		try
		{
			totalRetries++;

		//	serverDB.updateCommRetries(totalRetries);

			common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:updateRetryAttempts) Database connection failed...\n" );						

			if(totalRetries >= serverParameters.intMaxRetries)
			{
				common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:updateRetryAttempts) Max Retires Reached ["+totalRetries+"]\n" );
				exitProcess();
			}			

			thread.sleep(retryInterval);
		}
		catch(Exception exp)
		{				
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
	}
}
