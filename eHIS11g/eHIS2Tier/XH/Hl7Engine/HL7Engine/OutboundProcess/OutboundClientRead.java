/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
*/
package HL7Engine.OutboundProcess ;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;

import HL7Engine.Common.*;

/**
 * Class acts as acknowledgment listener.
 * When ever a message is received validates the message for proper message delimiters and 
 * process_ack_message proc if the message is as per standard.
 * Received message will also be written to file under C:/eHIS/REPORTS folder with 'ackFile' as file prefix.
 */
public class OutboundClientRead extends Thread
{
    Common common = null;
    int intTotalReceived = 0;
    Socket socket;
    InputStream inSocketStream ;
    File currentFile = null;

    //ClientSignal clientSignal;
    OutboundClientDBInteraction clientDB;
    String strMessage;
    MessageTokenizer messageTokenizer = null;

    // Not necessary Object;
    String strOutFileName = "SimulatedResponse.txt";

    String ackLogFileName = "C:/eHIS/REPORTS/ackFile";
    boolean createAckFile = false;

    String strAckFileDirectory;
    //FileOutputStream fileOutputStream;
    int intTotWidth = 6291456;//6mb

    boolean logToFile ;
    String strLogFile ;
    String strExceptionLogFile ;

    //	PrintStream out;

    public OutboundClientRead()
    {
    }

    public OutboundClientRead(InputStream istream, OutboundClientDBInteraction cdb, boolean logToFile, String strLogFile, String strExceptionLogFile) throws Exception
    {
    	common = Common.getInstance();
    	inSocketStream = istream;		
    	clientDB = cdb;
    	this.logToFile = logToFile;
    	this.strLogFile = strLogFile;
    	this.strExceptionLogFile = strExceptionLogFile;
    	this.strAckFileDirectory = clientDB.clientParameters.strAckFileDirectory;
    
    	try
    	{
    	    //	out = new PrintStream(new FileOutputStream(this.strExceptionLogFile,true));
    	}
    	catch(Exception exception)
    	{
    	    common.fileOutput( strLogFile, "(OutboundClientRead:Constructor) Exception: "+exception+"\n" );
    	}
    
    	if((clientDB.clientParameters.strCommunicationMode).equalsIgnoreCase("F"))
    	{			
    	    if(strAckFileDirectory == null || strAckFileDirectory.equals(""))
    	    {
    	    	strAckFileDirectory = InterfaceUtil.getIntSetupDir() + "/ack";
    	    }			
    	}
    	createAckFile = true; // indicates new communication process (start/restart) and new ack file has to be generated.
    	this.start();		
    }
    public void run()
    {
	if((clientDB.clientParameters.strCommunicationMode).equalsIgnoreCase("F"))
	{
	    fileCommunication();
	}

	File f = null;
	byte byteMsg[] = new byte[intTotWidth];
	int intTotBytes=0;

	// MessageTokenizer Object creation by passing message start & end characters.
	messageTokenizer = new MessageTokenizer(clientDB.clientParameters.messageStart, clientDB.clientParameters.messageEnd);
	messageTokenizer.setMessageDelimiters(clientDB.clientParameters.messageSegmentEnd, null, clientDB.clientParameters.fieldSeparator);
	messageTokenizer.strLogFile = strLogFile;

	while(true)
	{	
	    intTotBytes=0;
	    try
	    {
    		if(inSocketStream != null)
    		{
    		    intTotBytes = inSocketStream.read(byteMsg);
    		}				
    
    		if(createAckFile)
    		{
    		    ackLogFileName = clientDB.clientParameters.logDirectory + "/ack_" 
    		    			+ clientDB.clientParameters.intProcessId + ".log";
    		    if(logToFile) common.fileOutput( strLogFile, "(OutboundClientRead:run)ackLogFileName "+ackLogFileName+"\n");
    		    createAckFile = false;
    		}
    
    		if (intTotBytes > 0)
    		{
    		    String strMessage = new String(byteMsg,0,intTotBytes);
    		    ++intTotalReceived;				
    
    		    common.fileOutput( strLogFile, "(OutboundClientRead:run)Receiving Acknowledgement :\n======\n"+strMessage+"\n=======\n" );
    		    common.fileOutput( ackLogFileName, "\n======\n"+strMessage+"\n=======\n" );
    
    		    messageTokenizer.getTokenizedMessage(strMessage);					
    		    common.fileOutput(strLogFile, "(OutboundClientDBInteraction:read) 2 ");
    		    for (int i = 0; i < messageTokenizer.intTotMessage; i++)
    		    {
    		    	common.fileOutput(strLogFile, "(OutboundClientDBInteraction:read) 1 ");
    		    	clientDB.processAcknowledgement(messageTokenizer.strMessageBox[i]);
    		    }
    		}
    		else
    		{
    		    if(clientDB.clientParameters.strCommunicationMode.equalsIgnoreCase("F"))
    		    {
        			if(currentFile != null)
        			{
        			    f = new File(currentFile.getParent() + "/Processed");
        			    if(!f.exists())
        			    {
        				f.mkdir();
        			    }	
        			    f = new File(f,currentFile.getName());
        			    if(inSocketStream != null) inSocketStream.close();
        			    if( logToFile ) common.fileOutput( strLogFile, "(OutboundClientRead:run) Acknowledgement file being moved to "+ f.getPath() +"\n" );						
        			    currentFile.renameTo(f);  //After reading, file will be moved to Processed folder
        			}
        			fileCommunication();
    		    }
    		    if(intTotBytes == -1)
    		    {
    		    	common.fileOutput(strLogFile, "(OutboundClientRead:run) !!! End of the inputstream detected... exiting read process !!!\n" );
    		    	break;
    		    }
    		}								
	    }
	    catch(Exception exceptionGeneral)
	    {								
    		common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionGeneral) + "\n" ) ;
    
    		if (exceptionGeneral.getClass().isInstance(new ConnectException()) ||
    			exceptionGeneral.getClass().isInstance(new SocketException()) ||
    			exceptionGeneral.getClass().isInstance(new IOException()) )
    		{
    		    System.out.println(" Breaking Read Process ");
    		    break;
    		}
	    }
	}
    }

    /**
     *  Reads the files from specified ack folder.
     **/
    public void fileCommunication()
    {
	File ackFileDirectory = null;
	currentFile = null;
	String[] fileNames = null;
	inSocketStream = null;

	//if( logToFile ) common.fileOutput( strLogFile, "(OutboundClientRead:fileCommunication)\n" );

	try
	{
	    if((strAckFileDirectory != null) && (!strAckFileDirectory.equals("")) ) 
	    {
		String endChar = (strAckFileDirectory).substring( (strAckFileDirectory).length()-1, (strAckFileDirectory).length() );
		if( !endChar.equals("/") )
		{
		    strAckFileDirectory = strAckFileDirectory + "/";
		}
	    }
	    else
	    {
		strAckFileDirectory = "/";
	    }			
	    ackFileDirectory = new File(strAckFileDirectory);				

	    //	if( logToFile ) common.fileOutput( strLogFile, "(OutboundClientRead:fileCommunication) Ack file directory "+ackFileDirectory+"\n" );

	    fileNames = ackFileDirectory.list();
	    int i = 0;
	    while(true)
	    {									
		if(fileNames != null && fileNames.length > 0)
		{
		    currentFile = new File(strAckFileDirectory + fileNames[i]);

		    if(currentFile.isFile())
		    {
			if( logToFile ) common.fileOutput( strLogFile, "(OutboundClientRead:fileCommunication) Reading Ack from "+ strAckFileDirectory + fileNames[i] +"\n" );
			inSocketStream = new FileInputStream(strAckFileDirectory + fileNames[i]);
			break;
		    }
		    else
		    {					
			i++;
			if(i >= fileNames.length)
			{
			    i = 0;
			    fileNames = ackFileDirectory.list();
			}
			currentFile = null;					
		    }
		}
		else
		{
		    fileNames = ackFileDirectory.list();
		}
		Thread.sleep(500);
	    }					
	}
	catch(Exception exp)
	{			
	    common.fileOutput(strLogFile, "(OutboundClientRead:fileCommunication) Exception "+ exp +"\n" );
	    common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
	}
    }		
}		