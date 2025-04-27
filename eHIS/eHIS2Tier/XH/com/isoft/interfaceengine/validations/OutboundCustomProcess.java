/**
 * iSOFT-eHIS Interface Engine - Custom Processes for Outbound
 */

package com.isoft.interfaceengine.validations;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.Writer;

import HL7Engine.Common.*;
import HL7Engine.OutboundProcess.*;

/**
 * Class contains methods with required custom processes for different profiles/protocols.
 * Method runProcess will be the common method which will be called from InterfaceEngine,
 * based on the protocol appropriate method will be invoked.
 *
 * @version		1.0 24 Feb 2010
 * @author		Ravindranath
 */
public class OutboundCustomProcess
{
	Common common = null;
	OutboundClientDBInteraction clientDB;
	OutboundClientParameters clientParameters;

	static String BT_FILENAME = "BILLTRAN";
	static String BT_FILENAME_DATE_FRMT = "yyyyMMdd";
	static String OBT_SEGMENT = "OBT";
	static String OSB_SEGMENT = "OSB";
	String encodingFormat = "UTF8";
	public static final String NEW_LINE = "\n";

	private String logFileName;
	private String expLogFileName;
//	private static final String LINE_SEPERATOR = "" + (char)13 + (char)10;

	private boolean isLogEnabled = false;

	public OutboundCustomProcess(OutboundClientParameters clientParameters, OutboundClientDBInteraction clientDB)
	{
		common = Common.getInstance();
		this.clientParameters = clientParameters;
		this.logFileName = clientParameters.strLogFile;
		this.expLogFileName = clientParameters.strExceptionLogFile;
		isLogEnabled = clientParameters.logToFile;

		this.clientDB = clientDB;
	}

	/**
	 * Common method which will be called from InterfaceEngine.
	 * Based on the protocolID appropriate process will be executed.
	 */
	public String runProcess(String message)
	{
		String error = null;
		try
		{			
			if("SRREBLP7".equals(clientParameters.strProtocolId)) // Bill Transactions
			{	
				moveBTFileToEHIS();
				error = processBTMessage(message);			
			}									
		}
		catch (Exception exp)
		{			
			common.fileOutput(expLogFileName, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
		return error;
	}		

	void moveProcessedFile(File currentFile)
	{		
		try
		{						
			File fileToMove = new File(currentFile.getParent() + "/Processed/");

			if(!fileToMove.isDirectory())
			{
				fileToMove.mkdir();
			}

			fileToMove = new File(fileToMove, currentFile.getName());			

			boolean fileMoved = currentFile.renameTo(fileToMove);

			if(!fileMoved) common.fileOutput(logFileName, "(InboundCustomProcess:moveProcessedFile) Unable to move file...\n" ) ;
		}
		catch(Exception exception)
		{
			common.fileOutput(expLogFileName, CommonUtil.getStringStackTrace(exception) + "\n" );
		}
	}

	private void createBillTransFile()
	{
		OutputStreamWriter writer = null;
		FileOutputStream fout = null;

		try
		{
			CommonUtil.makeDirectory(clientParameters.strFileDirectory + "/eHIS/");
			String billTransMsgFormat = "<ClaimRec System=\"OP\" PayPlan=\"CS\" Version=\"0.9\"></ClaimRec>"
								+ NEW_LINE + "<HCODE>13814</HCODE>"
								+ NEW_LINE + "<HNAME>โรงพยาบาลศิริราช</HNAME>"
								+ NEW_LINE + "<DATETIME>" 
								+ CommonUtil.getFormattedStringDate("yyyy-MM-dd HH:mm", new java.util.Date()) 
								+ "</DATETIME>"
								+ NEW_LINE + "<SESSNO>1</SESSNO>"
								+ NEW_LINE + "<RECCOUNT>0</RECCOUNT>"
								+ NEW_LINE + "<BILLTRAN>"
								+ NEW_LINE + "</BILLTRAN>"
								+ NEW_LINE + "<OPBills invcount=\"0\" lines=\"0\">"
								+ NEW_LINE + "</OPBills>"
								+ NEW_LINE + "<END></END>";
		  

		String fileName = BT_FILENAME + 
			CommonUtil.getFormattedStringDate(BT_FILENAME_DATE_FRMT, new java.util.Date()) + ".txt";		

		fout = 
			new FileOutputStream(clientParameters.strFileDirectory + "/eHIS/" + fileName);	
		
		writer = new OutputStreamWriter(fout, encodingFormat);
		writer.write(billTransMsgFormat);
		writer.flush();
		writer.close();			
		}
		catch(Exception exp)
		{
			common.fileOutput(expLogFileName, CommonUtil.getStringStackTrace(exp) + "\n" );
		}
		finally
		{
			closeResource(writer, "Writer");
			try
			{
				if(fout != null) fout.close();
			}
			catch (Exception exp){ }			
		}
	}

	private void moveBTFileToEHIS()
	{
		try
		{
			String fileName = BT_FILENAME + 
				CommonUtil.getFormattedStringDate(BT_FILENAME_DATE_FRMT, new java.util.Date()) + ".txt";			
			
			File currentFile = new File(clientParameters.strFileDirectory + "/" + fileName);

			if(currentFile.exists()) {
				File fileToMove = new File(clientParameters.strFileDirectory + "/eHIS/" + fileName);
				boolean fileMoved = currentFile.renameTo(fileToMove);
				if(!fileMoved) 
					common.fileOutput(logFileName, "(InboundCustomProcess:moveProcessedFile) Unable to move file...\n" ) ;
			}
			else {
				createBillTransFile();
			}			
		}
		catch(Exception exp)
		{
			common.fileOutput(expLogFileName, CommonUtil.getStringStackTrace(exp) + "\n" );
		}		
	}

	private String processBTMessage(String message)
	{
		BufferedWriter writer = null;
		String error = null;

		try
		{	
			ArrayList msgDtls = (ArrayList)formatBTMessage(message);

			String fileName = BT_FILENAME + 
				CommonUtil.getFormattedStringDate(BT_FILENAME_DATE_FRMT, new java.util.Date());

			File tempBTFile = new File(clientParameters.strFileDirectory + "/eHIS/" + fileName + ".txt");
			File btFile = new File(clientParameters.strFileDirectory + fileName + ".txt");
			File tempFile = new File(clientParameters.strFileDirectory + "/eHIS/" + fileName + "_Temp.txt");

			Scanner fileScanner = new Scanner(tempBTFile, encodingFormat);						

			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile), encodingFormat));
			int recCount = 0;

			while(fileScanner.hasNextLine())
			{	
				String currentLine = fileScanner.nextLine();

				if(!currentLine.startsWith("<ClaimRec"))
				{
					common.fileOutput(logFileName, "(InboundCustomProcess:processBTMessage) <ClaimRec\n" ) ;
					writer.write(NEW_LINE);
				}
				
				if(currentLine.endsWith("</RECCOUNT>"))
				{											
					recCount = Integer.parseInt(currentLine.substring(currentLine.indexOf(">") + 1, currentLine.lastIndexOf("<"))) + Integer.parseInt(msgDtls.get(2).toString());					
					currentLine = "<RECCOUNT>" + recCount + "</RECCOUNT>";					
				}
				else if(currentLine.endsWith("</BILLTRAN>"))
				{					
					currentLine = msgDtls.get(0) + currentLine;					
				}
				else if(currentLine.startsWith("<OPBills"))
				{						
					int osbCount = Integer.parseInt(currentLine.substring(currentLine.lastIndexOf("=") + 2, 
														currentLine.lastIndexOf(">") - 1)) + 
									Integer.parseInt(msgDtls.get(3).toString());									
					currentLine = "<OPBills invcount=\"" + recCount + "\" lines=\"" + osbCount + "\">";					
				}
				else if(currentLine.endsWith("</OPBills>"))
				{
					currentLine = msgDtls.get(1) + currentLine;
				}				
				
				writer.write(currentLine);
				writer.flush();
			}
			
			writer.close();
			fileScanner.close();

			boolean isFileMoved = tempFile.renameTo(btFile);			

			if(!isFileMoved)
				common.fileOutput(logFileName, "(InboundCustomProcess:processBTMessage) Renaming file failed...\n");
			tempBTFile.delete();
		}
		catch (Exception exp)
		{
			common.fileOutput(expLogFileName, CommonUtil.getStringStackTrace(exp) + "\n" );
			error = exp.getMessage();
		}
		finally
		{
			closeResource(writer, "Writer");
		}
		return error;
	}

	private List formatBTMessage(String message)
	{
		ArrayList msgDtls = new ArrayList();
		String segEnd = CommonUtil.formatAsciiToString(clientParameters.messageSegmentEnd);

		StringTokenizer msgTokens = new StringTokenizer(message, segEnd);

		String obtSegment = "";
		String osbSegment = "";
		String currSeg = "";

		int obtCount = 0;
		int osbCount = 0;

		while (msgTokens.hasMoreTokens())
		{
			currSeg = msgTokens.nextToken();			

			if(currSeg.length() > 3 && (currSeg.substring(0, 3)).equals(OBT_SEGMENT))
			{				
				obtSegment = obtSegment + currSeg.substring(4) + NEW_LINE;				
				obtCount++;
			}
			else if(currSeg.length() > 3 && (currSeg.substring(0, 3)).equals(OSB_SEGMENT))
			{
				osbSegment = osbSegment + currSeg.substring(4) + NEW_LINE;
				osbCount++;
			}			
		}
		msgDtls.add(obtSegment);
		msgDtls.add(osbSegment);
		msgDtls.add(obtCount);
		msgDtls.add(osbCount);
		
		return msgDtls;
	}

	public void closeResource(Object object, String objectType)
	{
		if(object != null)
		{
			try
			{
				if(objectType.equalsIgnoreCase("Writer"))
				{
					Writer obj = (Writer)object;
					obj.close();
				}				
			}
			catch(Exception exp) { 
				common.fileOutput(expLogFileName, CommonUtil.getStringStackTrace(exp) + "\n" );
			}
		}		
	}
}