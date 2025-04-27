/*
Developed by  : Balachander R.R.
Created on    : 26/03/2003
*/
package HL7Engine.Common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FilenameFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ArrayList;

import javax.swing.JTextArea;
import HL7Engine.OutboundProcess.OutboundClientDBInteraction;

public class Common
{
    public static int start = 0;
    private static Common myInstance = new Common();
    private boolean logEnabled = false;
    private int logCreatedDay = 0;
    private String logHeader;
    private double logSizeLimit = 15;

    private Common()
    {
    	System.out.println("Common Instance created...");
    	try {
    		logSizeLimit = Double.parseDouble(CommonUtil.getPropertyVal(InterfaceUtil.getiniFilePath("CONFIG"), "LOG_SIZE_LIMIT"));
    	}
    	catch(Exception exp) {
    		fileOutput(InterfaceUtil.getDefaultLogLoc("LogInstance"), exp.toString().getBytes(), exp.toString().getBytes().length);
    	}
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
    	if(j < 10) {
    	    return("00" + j);
    	}
    	else if (j < 100) {
    	    return("0" + j);
    	}
    	else {
    	    return("" + j);
    	}
    }

    private  String trim(int j)
    {
    	if(j < 10) {
    	    return("0" + j);
    	}
    	else {
    	    return(j + "");
    	}
    }

    public void fileOutput(String strOutFileName, String strMessage) 
    {
    	GregorianCalendar gc = new GregorianCalendar();
    	String strTimeStamp = "";
    	try {
    	    strTimeStamp = trim(gc.get(gc.DAY_OF_MONTH)) + "/" +
				    	    trim((gc.get(gc.MONTH)+1)) + "/" +
				    	    trim(gc.get(gc.YEAR)) + " " +
				    	    trim(gc.get(gc.HOUR_OF_DAY)) +
				    	    ":" +
				    	    trim(gc.get(gc.MINUTE)) + ":" +
				    	    trim(gc.get(gc.SECOND)) + ":" +
				    	    trimMilli(gc.get(gc.MILLISECOND));
    	}
    	catch (Exception exp) {
    	    exp.printStackTrace();
    	}
    
    	int today = gc.get(gc.DAY_OF_MONTH);
    	double logFileLengthInMB = FileUtil.calculateFileSizeInMB(strOutFileName);
    
    	if(start != 0 && (logCreatedDay != today || logFileLengthInMB > logSizeLimit)) {
    	    start = 0;
    	    fileOutput(strOutFileName, (strTimeStamp + strMessage).getBytes(), (strTimeStamp + strMessage).getBytes().length);
    	    
    	    if(logFileLengthInMB > logSizeLimit) {
    	    	String message = " Log size limit " + logSizeLimit + " MB reached !!!\n";
    	    	fileOutput(strOutFileName, (strTimeStamp + message).getBytes(), (strTimeStamp + message).getBytes().length);
    	    }
    	}
    	else if(start == 0) {
    	    logHeader = strMessage;
    	}
    
    	if (start == 0)
    	{
    		String purgeYN = "N";
    	    start = 1;
    	    strTimeStamp = "";
    	    boolean isLogExists = renameOldLog(strOutFileName);
    	    try {
    	    	purgeYN = InterfaceUtil.getPropertyVal(InterfaceUtil.getiniFilePath("CONFIG"), "PURGE_LOG_BACKUP_YN", "N");
	    	} 
	    	catch(Exception exp) {
	    	    System.out.println(exp);
	    	}
    	    if("Y".equals(purgeYN)) purgeLogs(strOutFileName);
    	    logCreatedDay = today;
    	    
    	    if(isLogExists && !logHeader.equals(strMessage)) {
    	    	fileOutput(strOutFileName, (strTimeStamp + logHeader).getBytes(), (strTimeStamp + logHeader).getBytes().length);
    	    }
    	}
    	fileOutput(strOutFileName, (strTimeStamp+strMessage).getBytes(), (strTimeStamp+strMessage).getBytes().length);
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
    	finally {
    	    CommonUtil.closeStream(fileOutputStream);
    	}
    }
    
    public void fileOutputUnicode(String strFileName, String msg)  
    {
    	BufferedWriter writer = null;
    	try
    	{
    		writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(strFileName, true), "UTF8"));
    		writer.write(msg);
    		writer.flush();
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
    		try {
    			writer.close();
    		} catch (Exception exp) {
    			
    		}
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
	
    	fileOutput(strOutFileName, (strMessage).getBytes(), (strMessage).getBytes().length);
    }

    /**
     * Method renames the log file name by appending with date time if it already exists.
     */
    private boolean renameOldLog(String logFileName)
    {
    	boolean isLogExists = false;
    	try
    	{    		
    	    String logMsg = "New Log Created...";
    	    StringBuilder tempStrBuilder = new StringBuilder();
    	    String curentdateTime = CommonUtil.getFormattedStringDate("HHmmss", new Date());
    	    String curentdate = CommonUtil.getFormattedStringDate("ddMMyy", new Date());
    	    
    	    ArrayList<String> fileList = new ArrayList<String>();
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
        		    isLogExists = true;
        		}
    	    }
    	}
    	catch (Exception exp)
    	{			
    	    fileOutput(logFileName + ".log", exp.getMessage());
    	}
    	return isLogExists;
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
    
    private static void purgeLogs(String logFileName) 
    {
		File logFile = new File(logFileName);
		String srcFolder = logFile.getParent();
		File logbackupFolder = new File(srcFolder + "/logbackup/");
		String purgeLog = logbackupFolder + "/purge-status.log";
		Common common = Common.getInstance();

		try
		{
			// minus sign added, as to derive purge date we have to give negative
			// value with the number of days to purgeDay Calendar
			int purgeDuration = Integer.parseInt("-"
					+ InterfaceUtil.getPropertyVal(
							InterfaceUtil.getiniFilePath("CONFIG"),
							"PURGE_LOG_BACKUP_AFTER", "30"));
	
			Calendar purgeDay = new GregorianCalendar();
			purgeDay.add(Calendar.DAY_OF_MONTH, purgeDuration);
			final Date purgeDate = purgeDay.getTime();
	
			//getting list of folders to be deleted based on the criteria set in config file
			File[] fileList = logbackupFolder.listFiles(new FilenameFilter() {
				public boolean accept(File parentDir, String currentFilename) {
					boolean isPurgeRequired = false;
					boolean isDir = new File(parentDir.getName() + "/"
							+ currentFilename).isDirectory();
					if (isDir) {
						Date currentFolderDate = CommonUtil.convertToDate(
								currentFilename,
								EMConstants.LOG_BACKUP_FOLDER_DATE_FORMAT);
						isPurgeRequired = currentFolderDate.before(purgeDate);
					}
					return isPurgeRequired;
				}
			});
	
			new File(purgeLog).delete(); // Deleting old purge-status log
			
			common.writeToFile(purgeLog, CommonUtil.getFormattedStringDate("dd/MM/yy HH:mm:ss", new Date()) + " -- Purging backup logs..\n");
			
			//deleting the folder list derived
			if (fileList.length > 0) {
				for (File currentFolder : fileList) {
					String folderName = currentFolder.getName();
					boolean isFolderDeleted = FileUtil.deleteFolder(currentFolder, purgeLog);
					if (!isFolderDeleted) {
						common.writeToFile(purgeLog, "Unable to delete folder "
								+ currentFolder.getName() + "...\n");
					} else {
						common.writeToFile(purgeLog, "Folder " + folderName
								+ " deleted...\n");
					}
				}
			} 
			else {
				common.writeToFile(purgeLog, "No backup logs more than "
						+ -purgeDuration + " days...\n");
			}
		}
		catch(Exception exp) {
			common.writeToFile(purgeLog, CommonUtil.getStringStackTrace(exp) + "\n");
		}

	}
}