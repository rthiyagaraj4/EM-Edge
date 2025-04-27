/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
*/
package HL7Simulator.Common ;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JTextArea;

public class Common
{
    public void addServerOutput(JTextArea jtextarea, String msg) {
	jtextarea.append( msg );
	jtextarea.setCaretPosition( jtextarea.getText().length() );
    }
    //End of addServerOutput()

    public void fileOutput(String strOutFileName, String strMessage ) 
    {
	fileOutput( strOutFileName, strMessage.getBytes(), strMessage.getBytes().length );
    }
    //End of fileOutput(?)

    public void fileOutput(String strFileName, byte[] byteMsg,int intTotBytes)  {
	try
	{
	    FileOutputStream fileOutputStream = new FileOutputStream(strFileName,true);
	    fileOutputStream.write(byteMsg,0,intTotBytes);
	    fileOutputStream.close();	
	} 
	catch(FileNotFoundException exceptionFileNotFound)
	{
	    System.out.println(" (fileOutput) FileNotFound Exception "+exceptionFileNotFound);
	}
	catch(IOException exceptionFile)
	{
	    System.out.println(" (fileOutput) IOException  "+exceptionFile);
	}
	catch(Exception exception)
	{
	    System.out.println(" (fileOutput) General Exception "+exception);
	}
    }
    //End of fileOutput(?,?,?)

    public void errorLog( String strErrorMsg )  {
	try
	{
	    FileOutputStream fileOutputStream = new FileOutputStream( "c:/bala/error/error.log",true );
	    fileOutputStream.write( strErrorMsg.getBytes() );
	    fileOutputStream.close();	
	} 
	catch(FileNotFoundException exceptionFileNotFound)
	{
	    System.out.println(" (errorLog) errorLogFileNotFound Exception "+exceptionFileNotFound);
	}
	catch(IOException exceptionFile)
	{
	    System.out.println(" (errorLog) IOException  "+exceptionFile);
	}
	catch(Exception exception)
	{
	    System.out.println(" (errorLog) General Exception "+exception);
	}
    }

}
