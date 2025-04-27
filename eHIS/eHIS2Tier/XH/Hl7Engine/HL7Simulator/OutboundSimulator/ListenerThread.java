/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
*/
package HL7Simulator.OutboundSimulator;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextArea;

import HL7Simulator.Common.Common;

public class ListenerThread extends Thread
{
	Socket socket;
	byte byteMsg[] = new byte[999999];
	int intTotBytes = 0;
	int noOfRetry = 3 ;
	Common common = new Common() ;
	JTextArea txtaSvrOutput = null;
	JTextArea txtaAckOutput = null;
	Thread thread ;
	boolean isAckReq = true;

	InputStream inSocketStream ;
	OutputStream outSocketStream;
	ListenerWrite listenerWriteProcess;
	String strFileName = "c:/bala/receive/ListenerReceive.txt";
	String strAckFileName = "c:/bala/receive/ListenerAck.txt";

	public ListenerThread(Socket sock, String strRecvDir, String strAckFile, JTextArea txtasvroutput, JTextArea txtaackoutput, boolean isAckReq)
	{
		GregorianCalendar gregorianCal = new GregorianCalendar();
		String strDateTime =	gregorianCal.get(Calendar.YEAR)+"_"+(gregorianCal.get(Calendar.MONTH)+1)+"_"+
			gregorianCal.get(Calendar.DAY_OF_MONTH)+"_"+
			gregorianCal.get(Calendar.HOUR_OF_DAY)+"_"+
			gregorianCal.get(Calendar.MINUTE)+"_"+
			gregorianCal.get(Calendar.SECOND);
		strFileName = strRecvDir+"/"+strDateTime+".txt";
		socket = sock;
		strAckFileName = strAckFile ;
		txtaSvrOutput = txtasvroutput ;
		txtaAckOutput = txtaackoutput ;

		thread = this ;
		this.isAckReq = isAckReq;
		this.start();
	}
	
	public boolean continueAck()
	{
		try{
			thread.sleep(1500) ;	
		} catch (Exception e) {
			System.out.println( "Exception in continueAck() ") ;
		}
		
		noOfRetry-- ;
		System.out.println( "noOfRetry:"+noOfRetry ) ;
		if( noOfRetry == 0)
			return false ;
		else
			return true ;
	}

	public void run()
	{
		try
		{
			inSocketStream = null;
			outSocketStream = null;				
			listenerWriteProcess = null;
			inSocketStream = socket.getInputStream();
			outSocketStream = socket.getOutputStream();				
			listenerWriteProcess = new ListenerWrite( outSocketStream );
			common.addServerOutput( txtaSvrOutput, "\nSpooling to file : "+strFileName+"\n" );

		//	BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
			
			while(true)
			{
				intTotBytes = inSocketStream.read(byteMsg);
				if (intTotBytes>0)
				{
					common.fileOutput( strFileName, byteMsg, intTotBytes );
					System.out.println("Message:"+new String ( byteMsg, 0, intTotBytes ));
					common.addServerOutput( txtaSvrOutput, "New Message received...\n" );
					common.addServerOutput( txtaSvrOutput, new String ( byteMsg, 0, intTotBytes )+"\n" );

				/*	System.out.println("Press 1 to send the acknowledgement...");

					String input = read.readLine();

					if(input != null && input.equals("1"))
					{
						listenerWriteProcess.acknowledge( strAckFileName, txtaAckOutput ) ;
					}
				*/
					
					if(isAckReq) listenerWriteProcess.acknowledge( strAckFileName, txtaAckOutput ) ;
				}
				try
				{
					this.sleep(100);
								
				}
				catch(Exception exceptionSleep)
				{
					System.out.println( "Exception in Sleep : "+exceptionSleep );
				}
			}
		}
		catch(FileNotFoundException exceptionFileNotFound)
		{
			System.out.println(" FileNotFound Exception "+exceptionFileNotFound);
		}
		catch(SocketException exceptionSocket)
		{
			System.out.println(" SocketException  "+exceptionSocket);
		}
		catch(Exception exception)
		{
			System.out.println(" General Exception "+exception);				
		}
	}
}
