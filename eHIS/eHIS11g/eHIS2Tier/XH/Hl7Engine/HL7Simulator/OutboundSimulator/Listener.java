/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
*/
package HL7Simulator.OutboundSimulator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.JTextArea;

import HL7Simulator.Common.Common;

public class Listener extends Thread
{
	ServerSocket serverSocket;
	String strReceive ="";
	String strAck ="";
	JTextArea txtaSvrOutput = null;
	JTextArea txtaAckOutput = null;
	Common common = new Common() ;
	boolean isAckReq = true;

	public Listener() {}
	public void activate( int intPortNo, String recvDir, String ackFile, JTextArea txtasvroutput, JTextArea txtaackoutput,boolean isAckReq)
	{
		try
		{	
			serverSocket = new ServerSocket(intPortNo);	
			strReceive = recvDir ;
			strAck = ackFile ;
			txtaSvrOutput = txtasvroutput ;
			txtaAckOutput = txtaackoutput ;
			this.isAckReq = isAckReq;
			this.start();
		}
		catch(Exception exceptionSocket)
		{
			System.out.println(" (Listener) activate : "+exceptionSocket);
		}
	}

	public void deactivate()
	{
		try
		{
			if( serverSocket != null )
				serverSocket.close() ;
		}
		catch ( Exception e )
		{
			System.out.println( "(Listener) deactivate :"+e ) ;
		}
	}

	public void run()
	{
		common.addServerOutput( txtaSvrOutput, " Listening in the Port No. "+serverSocket.getLocalPort()+"\n" );
		while(true)
		{
			try
			{
				Socket socket = serverSocket.accept();
				System.out.println( "serverSocket:"+serverSocket );
				ListenerThread listenerThread= new ListenerThread( socket, strReceive, strAck, txtaSvrOutput, txtaAckOutput, isAckReq);
				System.out.println( "listenerThread:"+listenerThread );
			}
			catch(SocketException socketexception )
			{
				System.out.println( " Socket Closed "+ socketexception );
				break ;
			}
			catch(IOException exceptionFile)
			{
				System.out.println(" IOException "+exceptionFile);
				break ;
			}
			catch(Exception exceptionSocket)
			{
				System.out.println(" (Listener)Exception "+exceptionSocket);
				break ;
			}
		}
	}
}