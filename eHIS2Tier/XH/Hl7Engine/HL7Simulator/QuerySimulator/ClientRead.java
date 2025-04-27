/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
*/
package HL7Simulator.QuerySimulator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;

import javax.swing.JTextArea;

import HL7Simulator.Common.Common;

public class ClientRead extends Thread
{

	Common common = new Common() ;
	Socket socket;
	InputStream inSocketStream ;
	String strMessage;
	String strResponseFile ="0";
	FileOutputStream fileOutputStream=null;
	JTextArea txtaRespOutput = null;

	public ClientRead(InputStream inSocketStream,String strResponseFile, JTextArea txtaRespOutput) {
		this.inSocketStream = inSocketStream;
		this.strResponseFile  = strResponseFile;
		this.txtaRespOutput = txtaRespOutput ;
		this.start();
	}

	public void run()
	{
		byte byteMsg[] = new byte[999999];
		int intTotBytes=0;
		common.addServerOutput( txtaRespOutput, "Tyring for the Response..." );
		Date date1 = new Date() ;
		long datetime1 = date1.getTime() ;
		while(true)
		{
			try
			{
				intTotBytes = inSocketStream.read(byteMsg);
				if(intTotBytes < 0)	
				{					
					break;
				}
				Date date2 = new Date() ;
				long datetime2 = date2.getTime() ;				
				String strMessage = new String( byteMsg, 0, intTotBytes );				
				common.fileOutput( strResponseFile, byteMsg, intTotBytes );
				common.addServerOutput( txtaRespOutput, "Response received in "+((datetime2-datetime1)/1000.00)+" seconds\n");
				common.addServerOutput( txtaRespOutput, strMessage+"\n");
				common.addServerOutput( txtaRespOutput, "Response spooled to file : "+strResponseFile+"\n\n");
								
			}
			catch(Exception exceptionGeneral)
			{
				System.out.println(" Exception in Client Read"+exceptionGeneral);
				if (exceptionGeneral.getClass().isInstance(new ConnectException()) ||
					exceptionGeneral.getClass().isInstance(new SocketException()) ||
					exceptionGeneral.getClass().isInstance(new IOException()) )
				{
					common.addServerOutput( txtaRespOutput, "Error while reading the Response\n" );
				}
				break;
			}
		}
	}
}
