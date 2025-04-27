/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
*/
package HL7Engine.InboundProcess ;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import HL7Engine.Common.Common;
import HL7Engine.Common.CommonUtil;
import HL7Engine.Common.InterfaceUtil;
public class InboundListener extends Thread
{	
	String strCommunicationMode = "T";
	String strFileDirectory = "0";		

	FileInputStream fileInputStream;

	Common common = null;
	ServerSocket serverSocket;
	InboundServerParameters serverParameters;
	InboundServerMonitor serverMonitor;
	InboundServerDBInteraction serverDB;
	
	long initRetryInterval = 60 * 1000;
	boolean chkForIdleTime = false; 
	boolean initialConnection = true; 

	public InboundListener(InboundServerParameters serv)
	{
		common = Common.getInstance();
		serverParameters = serv ;
		try
		{	
			serverDB = new InboundServerDBInteraction(serv);
			boolean boolIsConnected = false;
			while(true)
			{
				boolIsConnected = serverDB.makeDBConnection();
				if (boolIsConnected)
				{
					serverDB.getXHParameters();
					serverParameters = initFunc();
					serverDB.getMessageDelimiters(serverParameters);
				//	formatMessageDelimiters();				
					if ( serverParameters.boolError ) 
					{
						System.out.println(" Error ");
						System.exit(1);
					}
					strCommunicationMode = serverParameters.strCommunicationMode;			
					serverDB.updateProcessStatus("A");
					serverMonitor = new InboundServerMonitor(serverDB);
					break;
				//	this.start();
				}
				else
				{
					common.fileOutput(serverParameters.strLogFile, "(InboundListener) Database Connection Failed \n" );	
					Thread.sleep(initRetryInterval);
				}
			}
		}
		catch(Exception exception)
		{
			common.fileOutput( serverParameters.strExceptionLogFile, "(InboundListener:Constructor) Constructor Exception:"+exception+"\n" ) ;	
			common.fileOutput(serverParameters.strLogFile, "(InboundListener) From Constructor Exception *********************** Database Connection Closed *********************** \n" );	
			serverDB.closeDBconn();
		}
	}
	private InboundServerParameters initFunc() throws Exception {	
		return serverDB.getAllParameters();
	}
	public void startProcess()
	{
		try
		{
			serverDB.setMsgDerivationRules();
			setRetryParam();
		}
		catch (Exception exp)
		{
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}		

		if(strCommunicationMode.equalsIgnoreCase("T"))
		{
			try
			{
				int intPortNo = serverParameters.intPortNo;
				serverSocket = new ServerSocket(intPortNo);				
			}
			catch(Exception exceptionSocket)
			{
				common.fileOutput(serverParameters.strExceptionLogFile, "(InboundListener:run) Start Process Exception:"+exceptionSocket+"\n" ) ;		
				common.fileOutput(serverParameters.strLogFile, "(InboundListener) From Start Process Exception *********************** Database Connection Closed *********************** \n" );
				serverDB.closeDBconn();
				System.exit(1);					
			}

			tcpCommunication();
		}
		else if(strCommunicationMode.equalsIgnoreCase("F"))
		{						
			String endChar = serverParameters.strFileDirectory.substring( serverParameters.strFileDirectory.length()-1, serverParameters.strFileDirectory.length() );
			if(!endChar.equals("/"))
			{
				serverParameters.strFileDirectory = serverParameters.strFileDirectory + "/";
			}
			strFileDirectory = serverParameters.strFileDirectory;
			fileCommunication();
		}
		else if(strCommunicationMode.equalsIgnoreCase("R"))
		{			
			rs232Communication();
		}
		else if(strCommunicationMode.equalsIgnoreCase("D"))
		{			
			try
			{
				new InboundServerApplication(serverParameters,this);
			}
			catch (Exception exp)
			{

			}
		}
	}

	private void setRetryParam() throws Exception
	{
		String checkRetryParam = InterfaceUtil.getPropertyVal(InterfaceUtil.getIntSetupDir() + "/CONFIG/properties.ini", "ENABLE_RETRY_PARAM", "Y");
		if("N".equals(checkRetryParam)) {
			serverParameters.isRetryParamEnabled = false;
		}
		common.fileOutput(serverParameters.strLogFile, "(InboundListener:setRetryParam) Retry Param Enabled ["+serverParameters.isRetryParamEnabled + "]\n") ;
		
	}
	public void tcpCommunication()
	{
		while(true)
		{			
			try
			{				
			/*	int restartTimeInMillis = serverMonitor.getRestartTimeInMillis();
				int intIdleTime = serverParameters.intIdleTime * 1000 * 60;			
				 
				if(setInitIdleTime(intIdleTime, restartTimeInMillis, initialConnection))
				{					
					chkForIdleTime = true;
					serverSocket.setSoTimeout(intIdleTime);
				}
				else if(initialConnection && serverParameters.isAutoRestart)
				{				
					serverSocket.setSoTimeout(restartTimeInMillis);
				}
				
				if(!initialConnection)
				{				
					serverSocket.setSoTimeout(0);
				}
			*/

				if(serverParameters.logToFile) 
				{
					common.fileOutput( serverParameters.strLogFile, "(InboundListener:tcpCommunication) Listener Started @ "+serverSocket.getLocalPort()+"\n" ) ;	
				}
				Socket socket = serverSocket.accept();
				initialConnection = false;

				serverDB.updateProcessComStatus("Y");
				
				InetAddress remoteAddress = socket.getInetAddress();
				common.fileOutput( serverParameters.strLogFile, 
					"(InboundListener:tcpCommunication) New Connection received from "+remoteAddress.getHostName()+" through "+socket.getPort()+" port\n" ) ;				
			
				new InboundServerApplication(socket, serverParameters, this);
			}
			catch(SocketTimeoutException timeOutException)
			{				
				try
				{
					common.fileOutput( serverParameters.strLogFile, "(InboundListener:tcpCommunication) Socket Timedout Exception \n" ) ;
				//	if(socket != null) socket.close();
					serverDB.updateProcessStatus("S");
					common.fileOutput(serverParameters.strLogFile, "(InboundListener:tcpCommunication) From Socket Timedout Exception *********************** Database Connection Closed *********************** \n" );
					serverDB.closeDBconn();	
					
					if(!chkForIdleTime)
					{
					//	common.fileOutput( serverParameters.strLogFile, "(InboundListener:run) Restart Time Reached["+serverMonitor.getStoppingTimeMessage()+"]\n" ) ;
						if (serverParameters.isWindowsService)
						{
							serverMonitor.stopService(false); // No need to start the service,ServiceRestart class will take care of restarting the service.
						}
						else
						{
							serverMonitor.runProcess(InboundServerParameters.strExec);
						}							
					}
					else
					{
						if(serverParameters.isWindowsService)
						{
							serverMonitor.stopService(true);
						}					
						common.fileOutput( serverParameters.strLogFile, "(InboundListener:run) Closing Current Instance\n" ) ;
						common.fileOutput( serverParameters.strLogFile, "\n_______________________________________________________________________________\n\n************End of Log File*********\n" ) ;
					}
										
					System.exit(0);					
				}
				catch(Exception exp)
				{
					exp.printStackTrace();
				}
			}
			catch(IOException exceptionFile)
			{
				common.fileOutput( serverParameters.strLogFile, "(InboundListener:tcpCommunication) IOException:"+exceptionFile+"\n" ) ;
				common.fileOutput( serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionFile) + "\n" ) ;
			}
			catch(Exception exceptionSocket)
			{
				common.fileOutput( serverParameters.strLogFile, "(InboundListener:run) Exception:"+exceptionSocket+"\n" ) ;
				common.fileOutput( serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionSocket) + "\n" ) ;
				System.exit(1);				
			}
		}
	}

	/**
	*  Method to handle file communication
	**/
	public void fileCommunication()
	{		
		try
		{				
			if(serverParameters.getNextMessage)
			{					
				serverParameters.getNextMessage = false;			 
				new InboundServerApplication(serverParameters,this);				
			}
		}
		catch(Exception exception)
		{				
			common.fileOutput( serverParameters.strExceptionLogFile, "(InboundListener:fileCommunication) Exception: "+exception+"\n" ) ;
		}		
	}

	/**
	 * Method to handle RS232 communication
	 **/
	public void rs232Communication()
	{		
		while(true)
		{
			try
			{				
				if(serverParameters.getNextMessage)
				{					
					serverParameters.getNextMessage = false;
				//	InboundServerApplication serverThread = 
						new InboundServerApplication(serverParameters,this);
				}
			}
			catch(Exception exception)
			{				
				common.fileOutput( serverParameters.strExceptionLogFile, "(InboundListener:rs232Communication) Exception: "+exception+"\n" ) ;
			}
		}// End of while
	}
	
	/**
	 * Method checks whether to set idle time or restart time to server socket.
	 * Method used to set the maximum time to listen for any initial connection request, 
	 * application will exit once the time is reached. This is required in TCP/IP before any initial 
	 * connection is made.
	 */
	boolean setInitIdleTime(int intIdleTime, int restartTimeInMillis, boolean initialConnection)
	{
		boolean setIdleTime = false;
		
		try
		{
			if(initialConnection)
			{
				if(!serverParameters.isAutoRestart)
				{
					setIdleTime = true;
				}
				else if(restartTimeInMillis <= 0)
				{
					setIdleTime = true;
				}
				else if(intIdleTime < restartTimeInMillis)
				{
					setIdleTime = true;
				}
			}			
		}
		catch (Exception exp)
		{			
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
		return setIdleTime;
	}	
}
