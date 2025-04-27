/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
*/
package HL7Simulator.OutboundSimulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.SocketException;

import javax.swing.JTextArea;

import HL7Simulator.Common.Common;
import HL7Simulator.Common.MessageTokenizer;

public class ListenerWrite
{
	Common common = new Common() ;
	MessageTokenizer messageTokenizer = new MessageTokenizer() ;

	OutputStream outSocketStream;
	byte byteMsg[] = new byte[999999];
	String strLine = "", strMsg = "";
	public ListenerWrite(OutputStream outs )
	{
		outSocketStream = outs;
	}

	public boolean acknowledge( String strAckFileName, JTextArea txtaAckOutput )
	{
		try
		{
			System.out.println( " entered to acknowledge("+strAckFileName+") " ) ;
			FileInputStream fileInputStream = new FileInputStream( strAckFileName );
			BufferedReader buffer = new BufferedReader( new InputStreamReader( fileInputStream ) );

			strMsg = ""+((char)11);
			while(true)
			{
				strLine = buffer.readLine();
				if (strLine == null || strLine.equals(""))
					break;
				System.out.println( strLine );
				common.addServerOutput( txtaAckOutput, strLine+"\n" );
				strMsg += strLine+(char)13;
			}
			strMsg = strMsg+((char)28)+ ((char)13);
			outSocketStream.write(strMsg.getBytes());
			fileInputStream.close();
			File file = new File ( strAckFileName );
			String parent = file.getParent() ;
			File newfile = new File( parent+"/"+"ListenerAck.txt" );
			file.renameTo( newfile ) ;

		}
		catch(FileNotFoundException exceptionFileNotFound)
		{
			System.out.println(" (ListenerWrite)FileNotFound Exception "+exceptionFileNotFound);
		}
		catch(SocketException exceptionSocket)
		{
			System.out.println(" (ListenerWrite)SocketException  "+exceptionSocket);
			return false ;
		}
		catch(Exception exception)
		{
			System.out.println(" (ListenerWrite)General Exception "+exception);
			return false ;
		}
		return true ;
	}
}
