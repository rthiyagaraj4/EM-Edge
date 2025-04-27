/*
Developed by  : Balachander R.R.
Created on    : 26/03/2003
*/
package HL7Engine.Common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ArrayList;

import javax.swing.JTextArea;

public class Common
{
    public static int start = 0;
    private static Common myInstance = new Common();
    private boolean logEnabled = false;
    private int logCreatedDay = 0;
    private String logHeader;

    private Common()
    {
    	System.out.println("Common Instance created...");
    }

    public static Common getInstance()
    {
    	return myInstance;
    }

    public void setLogCriteria(boolean isLogEnabled)
    {
    	logEnabled = isLogEnabled;
    }

    public void addServerOutput(JTextArea jtextarea, String msg) {
    	jtextarea.append(msg);
    	jtextarea.setCaretPosition(jtextarea.getText().length());
    }

    private  String trimMilli(int j)
    {
    	if(j < 10)
    	{
    	    return("00" + j);
    	}
    	else if (j < 100)
    	{
    	    return("0" + j);
    	}
    	else
    	{
    	    return("" + j);
    	}
    }

    private  String trim(int j)
    {
    	if(j < 10)
    	{
    	    return("0" + j);
    	}
    	else
    	{
    	    return(j + "");
    	}
    }

    public void fileOutput(String strOutFileName, String strMessage) 
    {
    	GregorianCalendar gc = new GregorianCalendar();
    	String strTimeStamp = "";
    	try
    	{
    	    strTimeStamp = trim(gc.get(gc.DAY_OF_MONTH)) + "/" +
    	    trim((gc.get(gc.MONTH)+1)) + "/" +
    	    trim(gc.get(gc.YEAR)) + " " +
    	    trim(gc.get(gc.HOUR_OF_DAY)) +
    	    ":" +
    	    trim(gc.get(gc.MINUTE)) + ":" +
    	    trim(gc.get(gc.SECOND)) + ":" +
    	    trimMilli(gc.get(gc.MILLISECOND));
    	}
    	catch (Exception exp)
    	{
    	    exp.printStackTrace();
    	}
    
    	int today = gc.get(gc.DAY_OF_MONTH);
    
    	//	System.out.println("logCreatedDay " + logCreatedDay);
    	//	System.out.println("today " + today);
    
    	if(start != 0 && logCreatedDay != today) 
    	{
    	    start = 0;
    	    fileOutput(strOutFileName, (strTimeStamp+strMessage).getBytes(), (strTimeStamp+strMessage).getBytes().length );
    	}
    	else if(start == 0)
    	{
    	    logHeader = strMessage;
    	}
    
    	if (start == 0)
    	{
    	    start = 1;
    	    strTimeStamp = "";
    	    renameOldLog(strOutFileName);
    	    logCreatedDay = today;
    	}
    	fileOutput(strOutFileName, (strTimeStamp+strMessage).getBytes(), (strTimeStamp+strMessage).getBytes().length );
    }	

    public void fileOutput(String strFileName, byte[] byteMsg,int intTotBytes)  
    {
    	FileOutputStream fileOutputStream = null;
    	try
    	{
    	    fileOutputStream = new FileOutputStream(strFileName,true);
    	    fileOutputStream.write(byteMsg,0,intTotBytes);			
    	} 
    	catch(FileNotFoundException exceptionFileNotFound) {
    	    System.out.println(" (fileOutput) FileNotFound Exception "+exceptionFileNotFound);
    	}
    	catch(IOException exceptionFile) {
    	    System.out.println(" (fileOutput) IOException  "+exceptionFile);
    	}
    	catch(Exception exception) {
    	    System.out.println(" (fileOutput) General Exception "+exception);
    	}
    	finally
    	{
    	    CommonUtil.closeStream(fileOutputStream);
    	}
    }

    public void errorLog(String strErrorMsg)  
    {
    	FileOutputStream fileOutputStream = null;
    	try
    	{
    		String defErrLog = InterfaceUtil.getDefaultLogLoc("error");
    	    fileOutputStream = new FileOutputStream(defErrLog, true);
    	    fileOutputStream.write(strErrorMsg.getBytes());				
    	} 
    	catch(FileNotFoundException exceptionFileNotFound) {
    	    System.out.println(" (errorLog) errorLogFileNotFound Exception "+exceptionFileNotFound);
    	}
    	catch(IOException exceptionFile) {
    	    System.out.println(" (errorLog) IOException  "+exceptionFile);
    	}
    	catch(Exception exception) {
    	    System.out.println(" (errorLog) General Exception "+exception);
    	}
    	finally
    	{
    	    CommonUtil.closeStream(fileOutputStream);
    	}
    }

    /**
     *  Method used in file communication, msg to push to the file without date and time
     */
    public void writeToFile(String strOutFileName, String strMessage ) 
    {
    	fileOutput( strOutFileName, (strMessage).getBytes(), (strMessage).getBytes().length );
    }

    /**
     * Method renames the log file name by appending with date time if it already exists.
     */
    private void renameOldLog(String logFileName)
    {
    	try
    	{
    	    String logMsg = "New Log Created...";
    	    StringBuilder tempStrBuilder = new StringBuilder();
    	    ArrayList<String> fileList = new ArrayList<String>();
    	    String curentdateTime = CommonUtil.getFormattedStringDate("HHmmss", new Date());
    	    String curentdate = CommonUtil.getFormattedStringDate("ddMMyy", new Date());
    	    File file = new File(logFileName);
    	    String srcFolder = file.getParent();
    	    String destFolder = tempStrBuilder.
                                	    append(srcFolder).
                                	    append("/logbackup/").
                                	    append(curentdate).
                                	    append("/").toString();
    	    tempStrBuilder.setLength(0);
    
    	    String logName = file.getName().substring(0, file.getName().indexOf("."));
    	    fileList.add(logName); // Process log
    	    fileList.add(tempStrBuilder.
    		    append(logName).
    		    append("Exception").toString()); // exception log
    	    tempStrBuilder.setLength(0);
    	    fileList.add(tempStrBuilder.
    		    append("ack_").
    		    append(logName).toString()); // ack log
    	    tempStrBuilder.setLength(0);
    	    fileList.add(tempStrBuilder.									
    		    append("Inbound").
    		    append(logName).toString()); // inbound message log
    	    tempStrBuilder.setLength(0);
    	    fileList.add(tempStrBuilder.																		
    		    append(logName).
    		    append("_serviceMonitor").toString()); // Service monitor log
    	    tempStrBuilder.setLength(0);
    	    CommonUtil.makeDirectory(destFolder);
    	    for (String fileName: fileList)
    	    {				
        		File srcFile = new File(srcFolder + "/" + fileName + ".log");
        		if(srcFile.exists())
        		{
        		    String destFilename = destFolder + fileName + "_" + curentdateTime + ".log";					
        		    File destFile = new File(destFilename);
        		    boolean fileRenamed = srcFile.renameTo(destFile);
        		    if(fileRenamed) fileOutput(destFilename, logMsg.getBytes(), logMsg.getBytes().length);
        		}
    	    }
    	}
    	catch (Exception exp)
    	{			
    	    fileOutput(logFileName + ".log", exp.getMessage());
    	}
    }

    private String getNewFilePath(File file)
    {
    	String filePath = file.getParent() + "\\" + CommonUtil.getFormattedStringDate("ddMMyy", new Date());
    
    	File tempFilePath = new File(filePath);
    	if(!tempFilePath.exists()) tempFilePath.mkdir();		
    
    	return filePath;
    }

    public void logProcessStop(String logFile)
    {
    	fileOutput(logFile, "(OutboundClientApplication:exitProcess) Closing Current Instance\n");
    	fileOutput(logFile, "\n_______________________________________________________________________________\n\n************End of Log File*********");
    }
}