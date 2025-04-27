/*
	Developed by  : P. Murugavell
	Created on    : 26/03/2003
*/
package HL7Engine.InboundProcess ;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import HL7Engine.Common.*;

import com.isoft.interfaceengine.validations.CustomValidations;

public class InboundServerRead extends Thread
{
    Socket socket;
    InputStream inSocketStream; // to store actual inputstream
    BufferedReader inboundStream; // Encapsulates actual stream, BufferedReader useful in reading characters in UTF8 format

    InboundServerDBInteraction serverDB;
    InboundServerParameters serverParameters;	
    MessageTokenizer messageTokenizer;
    Common common = null;
    CustomValidations customValidations;
    CustomTransactions customTransactions;

    String strMessage;
    String strCommunicationMode;	
    String strFileDirectory;
    String solicited;	
    String strDbfFileType;
    String fileNamingApi;
    String strExtension;
    String strLogFile = "0";
    String strExceptionLogFile = "0";

    boolean ackSent	  = false;
    boolean fileProcessed = false;
    boolean logToFile = false;
    boolean traceLog = false;
    boolean isLAReceived = false;
    boolean isLSSent = false;

    int intTotWidth = 6291456;
    int intRetryInterval = 0;

    //	ArrayList expMessageList = null;

    public InboundServerRead(InputStream istream,InboundServerDBInteraction serverDB)
    {
    	common = Common.getInstance();
    	this.serverDB  = serverDB;
    	inSocketStream = istream;		
    	serverParameters = serverDB.serverParameters;
    	logToFile  = serverParameters.logToFile;
    	strLogFile = serverParameters.strLogFile;
    	strExceptionLogFile = serverParameters.strExceptionLogFile;
    
    	try
    	{			
    	    intRetryInterval = serverParameters.intRetryInterval * 1000;
    	    String encodingType = CommonUtil.getPropertyVal(InterfaceUtil.getiniFilePath("CONFIG"), "OB_TCPIP_ENC");
    	    inboundStream = new BufferedReader(new InputStreamReader(inSocketStream, encodingType));			
    	    common.fileOutput(strLogFile, "(InboundServerRead:run) Encoding Type: "+encodingType+"\n" );
    	}
    	catch(Exception exception)
    	{
    	    common.fileOutput(strExceptionLogFile, "(InboundServerRead) Exception "+CommonUtil.getStringStackTrace(exception)+"\n") ;
    	}
    
    	customTransactions = CustomTransactions.getInstance(serverDB);
    	strCommunicationMode = serverParameters.strCommunicationMode;				
    	strFileDirectory	 = serverParameters.strFileDirectory;
    	strDbfFileType		 = serverParameters.strDbfFileType;
    	solicited = serverParameters.solicitedYN;		
    
    	if(strCommunicationMode.equalsIgnoreCase("F"))
    	{						
    	    customValidations = new CustomValidations(serverParameters, serverDB.connDB);			
    	}		
    
    	if(solicited != null) solicited = solicited.toUpperCase();
    
    	this.start();
    }
    
    public void run()
    {	
    	try
    	{			
    	    HashMap segmentList = null;		
    	    boolean boolProcessed = false;
    
    	    char[] buf = new char[intTotWidth];
    	    int len = 0;
    	    StringBuffer builder = new StringBuffer();
    	    init();		
    
    	    while(true)
    	    {
        		try
        		{	
        		    builder.delete(0, builder.length());
        		    String tempMsg = "";
        
        		    if(strCommunicationMode.equalsIgnoreCase("F"))
        		    {	
            			if(fileProcessed) 
            			{
            			    Thread.sleep(intRetryInterval);
            			    continue;
            			}
            			getFileStream(); // Getting input stream for the next file that is to be read.
        		    }
        
        		    while (((len = inboundStream.read(buf, 0, buf.length)) != -1)) 
        		    {
            			builder.append(buf, 0, len);
            			if(!inboundStream.ready()) break;
        		    }
        
        		    tempMsg = builder.toString();
        		    if (!"".equals(tempMsg))
        		    {	
            			serverParameters.longStartTime = System.currentTimeMillis();
            			String strMessage = tempMsg;
            
            			if(logToFile && traceLog) common.fileOutput(strLogFile, "(InboundServerRead:run) Received Message:\n"+strMessage+"\n" );
            
            			if(!("PABXF".equals(serverParameters.strProtocolId)))
            			{
            			    int partialMessage = messageTokenizer.getTokenizedMessage(strMessage);
            			    if(partialMessage == 2) continue; // condition to handle if received some partial message
            			    strMessage = messageTokenizer.partialMsgBuffer.toString();
            
            			    if(logToFile && traceLog) common.fileOutput(strLogFile, "(InboundServerRead:run) Tokenized Message:\n"+strMessage+"\n" );
            			}
            
            			messageTokenizer.getTokenizedMessage(strMessage);
            
            			if(logToFile) common.fileOutput(strLogFile, "(InboundServerRead:run) No of messages received now: "+messageTokenizer.intTotMessage +"\n" );
            
            			serverDB.serverParameters.totalMessages += messageTokenizer.intTotMessage;
            
            			if(serverParameters.linkProtocolIDEnabled && !isLAReceived && isLSSent)
            			{
            			    String tempSegStart = CommonUtil.formatAsciiToString(serverDB.serverParameters.messageStart) + "LA" + 
            			    CommonUtil.formatAsciiToString(serverDB.serverParameters.fieldSeperator);
            
            			    for (int i = 0; i < messageTokenizer.intTotMessage; i++)
            			    {							
            				String str = (messageTokenizer.strMessageBox[i]).substring(0,4);
            				if(tempSegStart.equals(str)) 
            				{
            				    isLAReceived = true;							
            				    common.fileOutput(strLogFile, "(OutboundClientRead:run) LA Segment Received...\n" );
            				}
            			    }
            			    messageTokenizer.partialMsgBuffer.delete(0, messageTokenizer.partialMsgBuffer.length());
            			    continue;
            			}
            
            			for(int i = 0; i < messageTokenizer.intTotMessage; i++)
            			{
            			    boolean isValidMessage = customValidations.validateMessage(messageTokenizer.strMessageBox[i]);
            
            			    if(isValidMessage)
            			    {
                				strMessage = customValidations.formattedMsg.toString();				
                
                				if (logToFile) common.fileOutput(strLogFile,"(InboundServerRead:run) Processing Message: "  + strMessage  + "\n");
                				serverDB.processQueryMessage(strMessage);
                
                				if ("T01".equalsIgnoreCase(serverDB.strEventType)) 
                				{
                				    InboundUtil inboundUtil = new InboundUtil(serverParameters);
                				    segmentList = null;
                				    segmentList = (HashMap) CommonUtil .formatMessage(
                                                    					    strMessage,
                                                    					    serverParameters.messageStart,
                                                    					    serverParameters.messageEnd,
                                                    					    serverParameters.messageSegmentStart,
                                                    					    serverParameters.messageSegmentEnd,
                                                    					    serverParameters.fieldSeperator);
                
                				    String orderNo = (String) ((ArrayList) segmentList .get("ORC")).get(2); // ORC[2] - // Order No
                
                				    if (orderNo != null && !orderNo.trim().equals(""))
                				    {
                    					String pdfFileName = (String) ((ArrayList) segmentList.get("TXA")).get(16);
                    					File pdfFile = new File(pdfFileName);
                    					if (pdfFile.exists()) 
                    					{
                    					    HashMap paramList = (HashMap) serverDB .getOrderParamList(orderNo,"1", "");
                    					    paramList = inboundUtil .getOrderEventType(paramList);
                    					    boolean pdfUpdated = serverDB .updatePDFFile( (String) paramList .get("eventType"),
                    						    (String) paramList .get("moduleID"),
                    						    (String) paramList.get("accession_num"),
                    						    (String) paramList .get("contr_sys_event_code"),
                    						    (String) paramList .get("event_title"),
                    						    pdfFileName);
                    					    if (logToFile) 
                    					    {
                    						common.fileOutput(strLogFile,"(InboundServerRead:run) Encountered T01 Event\n");
                    						common.fileOutput(strLogFile,"(InboundServerRead:run) Updating PDF " + pdfFileName + "\n");
                    					    }
                    					    if (pdfUpdated) common.fileOutput(strLogFile,"(InboundServerRead:run) PDF file updated\n");
                    					}
                				    }
                				}
                				else 
                				{
                				    customTransactions.performTransactions(strMessage);
                				}
                
                				boolProcessed = true;
                				serverParameters.longStartTime = System.currentTimeMillis();
                
                				if(strCommunicationMode.equalsIgnoreCase("F"))
                				{
                				    if(inboundStream != null) inboundStream.close();
                				    if(inSocketStream != null) inSocketStream.close();						
                				    moveCurrentFile("Processed");
                				    fileProcessed = true;
                				}
                				messageTokenizer.partialMsgBuffer.delete(0, messageTokenizer.partialMsgBuffer.length());
            			    }
            			    else
            			    {
            				common.fileOutput(strLogFile, "(InboundServerRead:run) !!! Message not valid !!!\n" );
            				common.fileOutput(strLogFile, "(InboundServerRead:run) "+customValidations.errMsg+"\n" ) ;
            				
            
            				if(strCommunicationMode.equalsIgnoreCase("F"))
            				{
            				    if(inboundStream != null) inboundStream.close();
            				    if(inSocketStream != null) inSocketStream.close();						
            				    moveCurrentFile("ERR");
            				    fileProcessed = true;
            				}
            			    }
            
            			    if("Y".equals(solicited))
            			    {
                				if( logToFile ) common.fileOutput( strLogFile, "(InboundServerRead:run)Query Processing Completed\n" ) ;
                				serverDB.ackSent = true; // indicates processing of query has completed.						
            			    }
            			}
            
            			// Adding acknowledgment messages for partial messages
            			for (int i = 0; i <= messageTokenizer.partialMessageCounter; i++)
            			{
            			    serverDB.partialMsgAckList.add(messageTokenizer.partialMsgList[i]);																	
            			}
        		    }
        		    else
        		    {					
        		    	common.fileOutput(strLogFile, "(InboundServerRead:run) Message does not exist..\n" ) ;
        		    }
        		    if(len == -1) break;
        		}
        		catch(Exception exceptionGeneral)
        		{					
        		    if(!serverDB.ackSent && !serverDB.serverParameters.isIdleTimeReached)
        		    {
        			common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionGeneral) + "\n" ) ;
        		    }
        		    if (exceptionGeneral.getClass().isInstance(new ConnectException()) ||
        			    exceptionGeneral.getClass().isInstance(new SocketException()) ||
        			    exceptionGeneral.getClass().isInstance(new IOException()) )
        		    {					
        			common.fileOutput(strExceptionLogFile, "(InboundServerRead:run) Exception: Breaking Read Process\n" );
        		//	serverDB.serverParameters.getNextMessage = true; // used in InboundListener for file communication, indicates to process for next file
        			break;
        		    }
        		}
        		finally
        		{
        		    builder.delete(0, builder.length());
        		}
    	    }
    	}
    	catch (Error error)
    	{
    	    common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(error) + "\n" );
    	}
    }

    void moveCurrentFile(String folderName)
    {
    	String currentFileName = serverParameters.currentFile;
    
    	try
    	{
    	    formatFileDir();			
    	    File currentFile = new File(strFileDirectory + currentFileName);
    	    File fileToMove = new File(strFileDirectory + folderName);
    
    	    if(!fileToMove.isDirectory())
    	    {
    		fileToMove.mkdir();
    	    }
    
    	    String processedFilename = currentFile.getName();
    	    processedFilename = processedFilename.substring(0, processedFilename.indexOf(".")) + "_"
                                                            	    + CommonUtil.getFormattedStringDate("yyyyMMddHHmmss", new Date())
                                                            	    + processedFilename.substring(processedFilename.indexOf("."));
    
    	    fileToMove = new File(fileToMove,processedFilename);			
    
    	    boolean fileMoved = currentFile.renameTo(fileToMove);
    	    if(!fileMoved) common.fileOutput(strLogFile, "(InboundServerRead:moveCurrentFile) Unable to move file...\n" ) ;
    	}
    	catch(Exception exception)
    	{
    	    common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exception) + "\n" );
    	}
    }	

    private void getFileStream()
    {
    	try
    	{
    	    String encodingType = CommonUtil.getPropertyVal(InterfaceUtil.getiniFilePath("CONFIG"), "OB_TCPIP_ENC");
    	    InputStream fileInputStream = new FileInputStream(serverParameters.filePath);
    	    inboundStream = new BufferedReader(new InputStreamReader(fileInputStream, encodingType));			
    	}
    	catch (Exception exp)
    	{	
    	    common.fileOutput(strLogFile, "(InboundServerRead:getFileStream) Exception: "+exp+"\n" ) ;
    	    common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
    	}
    }

    private boolean setMessageTrace()
    {
    	boolean flag = false;
    	try
    	{
    	    common.fileOutput(strLogFile, "(InboundServerRead:run) setMessageTrace...\n" );
    	    File propFile = new File(InterfaceUtil.getiniFilePath("CONFIG"));
    	    Properties properties = new Properties();
    
    	    if(propFile.exists())
    	    {
    		properties.load(new FileInputStream(propFile));
    		String debugYN = properties.getProperty("DEBUG_LOG");
    		if("Y".equalsIgnoreCase(debugYN)) 
    		{					
    		    flag = true;					
    		}
    	    }
    	}
    	catch (Exception exp)
    	{	
    	    common.fileOutput(strLogFile, "(InboundServerRead:setMessageTrace) Exception: "+exp+"\n" ) ;
    	    common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
    	}
    	return flag;
    }

    private void init()
    {
    	common.fileOutput(strLogFile, "(InboundServerRead:run) Init...\n" );
    	traceLog = setMessageTrace(); // Trace flag for logging messages to log file
    
    	if(logToFile) 
    	{
    	    common.fileOutput( strLogFile, "(InboundServerRead:run) Message Start: "+serverDB.serverParameters.messageStart+"\n") ;
    	    common.fileOutput( strLogFile, "(InboundServerRead:run) Message End: "+serverDB.serverParameters.messageEnd+"\n" );
    	    common.fileOutput( strLogFile, "(InboundServerRead:run) Segment Start: "+serverDB.serverParameters.messageSegmentStart+"\n" );
    	    common.fileOutput( strLogFile, "(InboundServerRead:run) Segment End: "+serverDB.serverParameters.messageSegmentEnd+"\n" );
    	    common.fileOutput( strLogFile, "(InboundServerRead:run) Component Separator: "+serverDB.serverParameters.componentSeparator+"\n" );
    	}
    
    	messageTokenizer = new MessageTokenizer(serverDB.serverParameters.messageStart, 
    												serverDB.serverParameters.messageEnd);
    	messageTokenizer.setMessageDelimiters(serverDB.serverParameters.messageSegmentEnd,
                                            		serverDB.serverParameters.componentSeparator,
                                            		serverDB.serverParameters.fieldSeperator);
    	messageTokenizer.strLogFile = strLogFile;
    	messageTokenizer.logToFile  = logToFile;
    
    	if(customValidations == null) customValidations = new CustomValidations(serverParameters, serverDB.connDB);
    }

    String formatFileDir()
    {
    	int tempIndex = strFileDirectory.indexOf(";");
    	if(tempIndex > 0) strFileDirectory = strFileDirectory.substring(0, tempIndex);
    	return strFileDirectory;
    }
}		