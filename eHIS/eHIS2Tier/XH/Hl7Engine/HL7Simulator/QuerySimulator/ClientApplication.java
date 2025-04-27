/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
	Modified on	  : 05/12/2009 - Added feature to use either existing connection or to establish new connection
*/
package HL7Simulator.QuerySimulator ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.JTextArea;

import HL7Simulator.Common.Common;

public class ClientApplication extends Thread
{
	Common common = new Common();
	Socket socket;
	String strIpAddress;
	int intPort;
	Thread thread;
	int intStart = 0;
	InputStream inSocketStream ;
	OutputStream outSocketStream;
	int intConnectionCount = 0;
	int maxRetry = 10 ;
	int intTimeGap = 5000;
	int intPollingTime = 1000;

	ClientRead clientReadProcess;

	String strQueryFile="0";
	String strResponseFile ="0";
	String strLine = "0";
	String strFileName  = "0";

	String displayString = "Trying to establishing the connection...\n" ;
	String redisplayString = "Retrying to establishing the connection...\n" ;
	boolean retry = false ;

	JTextArea txtaQryOutput = null ;
	JTextArea txtaRespOutput = null ;

	public ClientApplication(String strIpAddress, int intPort, String strQueryFile, String strResponseFile, JTextArea txtaQryOutput, JTextArea txtaRespOutput)
	{
		this.strIpAddress = strIpAddress;
		this.intPort = intPort;
		this.strQueryFile = strQueryFile;
		this.strResponseFile = strResponseFile;
		this.txtaQryOutput = txtaQryOutput;
		this.txtaRespOutput = txtaRespOutput;
		thread = this;
		this.start();
	}

	public void run()
	{
	//	intStart = 0 ;
		intConnectionCount++ ;
		System.out.println("Start");

		char[] buf = new char[999999];
	//	byte byteMsg[] = new byte[999999];
		StringBuffer builder = new StringBuffer();
		int len = 0;

		/************** Connnection to the Database has to be done *****
				All the intial task also has to be done here
				Acknowledgement Type , Acknowldgement Message,
				has to be taken care here for the implementation
		***/

		while(true)
		{
			try
			{
				if (intStart == 0)
				{
					intStart++;
					System.out.println(" Establishing the Connection ");
					if( retry )
						common.addServerOutput( txtaQryOutput, redisplayString ) ;
					else
						common.addServerOutput( txtaQryOutput, displayString ) ;
					socket = null;
					outSocketStream = null;
					inSocketStream = null;
					clientReadProcess = null;
					System.out.println(intPort + " IPADDRESS " + strIpAddress);
					socket = new Socket( strIpAddress, intPort );
					common.addServerOutput( txtaQryOutput, "Connection established successfully \n" ) ;
					inSocketStream = socket.getInputStream();
					outSocketStream = socket.getOutputStream();
				}
				
				String strMsg = "";
				if( strQueryFile != "" )
				{
					FileInputStream fileInputStream = new FileInputStream( strQueryFile );
					BufferedReader buffer = new BufferedReader(new InputStreamReader(fileInputStream));
					common.addServerOutput( txtaQryOutput, "Query sent\n" ) ;
				//	strMsg = ""+((char)11);
				/*	while(true)
					{
						strLine = buffer.readLine();
						if (strLine == null || strLine.equals(""))
							break;
						common.addServerOutput( txtaQryOutput, strLine+"\n" );
						strMsg += strLine+(char)13;
					}
				
					while(true)
					{
						int c = buffer.read();
						System.out.println((char)c);
						if(c == -1) break;
						else
						{
							strMsg += (char)c;
						}
					}
				*/	
					while (((len = buffer.read(buf, 0, buf.length)) != -1)) 
					{
						builder.append(buf, 0, len);
					//	if(!buffer.ready()) break;
						break;
					}

					strMsg = builder.toString();

					common.addServerOutput( txtaQryOutput, strMsg+"\n" );

				//	strMsg =  strMsg+((char)28)+ ((char)13);
					fileInputStream.close();
					buffer.close();
//					File file = new File (strQueryFile+"/"+strFileName);
//					file.delete();
				}
				if (!(strMsg.equals("")))
				{
					System.out.println(" Entered");
					System.out.println(strMsg);
					outSocketStream.write(strMsg.getBytes());
					common.addServerOutput( txtaQryOutput, "\n" ) ;
					clientReadProcess = new ClientRead(inSocketStream, strResponseFile, txtaRespOutput);
					break ;
				}
				try
				{
					thread.sleep(intPollingTime);
				}
				catch(Exception exceptionSleep)
				{
					System.out.println(" Sleep Exception ");
				}
			}
			catch(Exception exceptionGeneral)
			{

				System.out.println(" Exception in Client Application "+exceptionGeneral);
				if (exceptionGeneral.getClass().isInstance(new ConnectException()) ||
					exceptionGeneral.getClass().isInstance(new SocketException()) ||
					exceptionGeneral.getClass().isInstance(new IOException()) )
				{
					intConnectionCount++;
					intStart = 0;
					if( intConnectionCount > maxRetry ) {
						common.addServerOutput( txtaQryOutput, "Connection failed. Try to resend the query again\n" ) ;
						break;
					} else {
						retry = true ;
					}
					try
					{
						thread.sleep(intTimeGap);
					}
					catch(Exception exceptionSleep)
					{
						System.out.println(" Sleep Exception ");
					}
				}
			}
		}
	}

	public void sendMessage(String qryfile) throws Exception
	{
		strQueryFile = qryfile;
		char[] buf = new char[999999];
	//	byte byteMsg[] = new byte[999999];
		StringBuffer builder = new StringBuffer();
		int len = 0;

		while(true)
		{
			try
			{
				if (intStart == 0)
				{

					intStart++;
					System.out.println("Establishing the Connection");
					if( retry )
						common.addServerOutput( txtaQryOutput, redisplayString ) ;
					else
						common.addServerOutput( txtaQryOutput, displayString ) ;
					socket = null;
					outSocketStream = null;
					inSocketStream = null;
					clientReadProcess = null;
					System.out.println(intPort+" IPADDRESS "+strIpAddress);
					socket = new Socket( strIpAddress, intPort );
					common.addServerOutput( txtaQryOutput, "Connection established successfully \n" ) ;
					inSocketStream = socket.getInputStream();
					outSocketStream = socket.getOutputStream();
				}
				System.out.println("Start "+strQueryFile);
				String strMsg = "";
				if( strQueryFile != "" )
				{					
					FileInputStream fileInputStream = new FileInputStream(strQueryFile);				
					BufferedReader buffer = new BufferedReader(new InputStreamReader(fileInputStream));
					common.addServerOutput( txtaQryOutput, "Query sent\n" ) ;
				//	strMsg = ""+((char)11);
				/*	while(true)
					{
						strLine = buffer.readLine();
						if (strLine == null || strLine.equals(""))
							break;
						common.addServerOutput( txtaQryOutput, strLine+"\n" );
						strMsg += strLine+(char)13;
					}
				
					while(true)
					{
						int c = buffer.read();
						if(c == -1) break;
						else
						{
							strMsg += (char)c;
						}
					}
				*/

					while (((len = buffer.read(buf, 0, buf.length)) != -1)) 
					{
						builder.append(buf, 0, len);
					//	if(!buffer.ready()) break;
						break;
					}

					strMsg = builder.toString();

					common.addServerOutput( txtaQryOutput, strMsg+"\n" );

				//	strMsg =  strMsg+((char)28)+ ((char)13);
					fileInputStream.close();
					buffer.close();
//					File file = new File (strQueryFile+"/"+strFileName);
//					file.delete();
				}
				if (!(strMsg.equals("")))
				{
					System.out.println(" Entered");
					outSocketStream.write(strMsg.getBytes());
					common.addServerOutput( txtaQryOutput, "\n" ) ;
					clientReadProcess = new ClientRead(inSocketStream, strResponseFile, txtaRespOutput);
					break ;
				}
				try
				{
					thread.sleep(intPollingTime);
				}
				catch(Exception exceptionSleep)
				{
					System.out.println(" Sleep Exception ");
				}
			}
			catch(Exception exceptionGeneral)
			{

				System.out.println(" Exception in Client Application "+exceptionGeneral);
				if (exceptionGeneral.getClass().isInstance(new ConnectException()) ||
					exceptionGeneral.getClass().isInstance(new SocketException()) ||
					exceptionGeneral.getClass().isInstance(new IOException()) )
				{
					intConnectionCount++;
					intStart = 0;
					if( intConnectionCount > maxRetry ) {
						common.addServerOutput( txtaQryOutput, "Connection failed. Try to resend the query again\n" ) ;
						break;
					} else {
						retry = true ;
					}
					try
					{
						thread.sleep(intTimeGap);
					}
					catch(Exception exceptionSleep)
					{
						System.out.println(" Sleep Exception ");
					}
				}
			}
		}
	}
}