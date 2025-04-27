/*
 * iSOFT-eHIS Interface Engine - Custom Validations
 */

package com.isoft.interfaceengine.validations;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.sql.Connection;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;

import HL7Engine.Common.*;
import HL7Engine.InboundProcess.InboundServerParameters;

/**
 * Class contains methods with required custom validations for different profiles/protocols.
 * Method validateMessage will be the common method which will be called from InterfaceEngine,
 * based on the protocol appropriate method will be invoked inside this method.
 *
 * @version		1.0 09 Dec 2009
 * @author		Ravindranath
 */
public class CustomValidations
{
	public String errMsg; // error msg sent back to external interface is msg validation fails.
	public StringBuffer formattedMsg; // message after formatting the received message as per the protocol reqquirements.

	InboundServerParameters serverParameters = null;
	Common common = null;

	private String logFileName;
	private String expLogFileName;
	private String fieldSeperator;
	private String segmentStart;
	private String segmentEnd;
	private String msgStart;
	private String msgEnd;
	private static final String LINE_SEPERATOR = "" + (char)13 + (char)10;

	private boolean isLogEnabled = false;
	private boolean boolInit = false;

	private ArrayList dtlSegmentList = null;
	private ArrayList hdrSegmentList = null;
	private ArrayList ftrSegmentList = null;
	
	Connection dbConn = null;

	DBTransactions dbTransactions;

	public CustomValidations(InboundServerParameters serverParameters, Connection con)
	{
		common = Common.getInstance();
		this.serverParameters = serverParameters;
		this.logFileName = serverParameters.strLogFile;
		this.expLogFileName = serverParameters.strExceptionLogFile;
		isLogEnabled = serverParameters.logToFile;

		fieldSeperator = CommonUtil.formatAsciiToString(serverParameters.fieldSeperator);
		segmentStart = CommonUtil.formatAsciiToString(CommonUtil.checkNull(serverParameters.messageSegmentStart));
		segmentEnd = CommonUtil.formatAsciiToString(CommonUtil.checkNull(serverParameters.messageSegmentEnd));
		msgStart = CommonUtil.formatAsciiToString(serverParameters.messageStart);
		msgEnd = CommonUtil.formatAsciiToString(serverParameters.messageEnd);

		dbConn = con;
		formattedMsg = new StringBuffer();
	}

	/**
	 * Common method which will be called from InterfaceEngine.
	 * Based on the protocolID appropriate validation methods will be called.
	 */
	public boolean validateMessage(String message)
	{
		boolean isValidationSuccess = false;
		if(formattedMsg != null)
		{
			formattedMsg.delete(0, formattedMsg.length());
			formattedMsg.append(message);
		}

		try
		{										
			if("CNTRSERVP1".equals(serverParameters.strProtocolId))
			{	
				if(!boolInit) initMethod();
				isValidationSuccess = counterService(message);
			}
			else if("CNTRSERVP2".equals(serverParameters.strProtocolId))
			{							
				if(!boolInit) initMethod();				
				isValidationSuccess = bankProtocol(message);
			}
			else if("PABXF".equals(serverParameters.strProtocolId))
			{							
			//	if(!boolInit) initMethod();				
				isValidationSuccess = pabxReconciliation(message);
			}
			else
			{
				isValidationSuccess = true;
			}
		}
		catch(Exception exp)
		{			
			common.fileOutput(logFileName, "(CustomValidations:validateMessage) Exception: "+exp+"\n");
			common.fileOutput(expLogFileName, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
		return isValidationSuccess;
	}

	/**
	 * Method validates counter service messages.
	 */
	private boolean counterService(String message)
	{		
		boolean isSuccess = false;

		//validations
		boolean isValidClientNo = false;
		boolean isDtlRecCountValid = false;
		boolean isValidTotAmt = false;

		int dtlRecCount = 0;
		String msgClientNo = null;		
		long amtReceived = 0;

	//	FileInputStream fileInputStream = null;
	//	BufferedReader buffer = null;
		String segment = null;

		final String HEADER_START = "H";
		final String DETAIL_START = "D";
		final String FOOTER_START = "T";

		try
		{			
			StringTokenizer msgSegments = new StringTokenizer(message, LINE_SEPERATOR);			

			while(msgSegments.hasMoreTokens())
			{
				segment = msgSegments.nextToken();				
				
				if(DETAIL_START.equals(segment.charAt(0)+""))
				{
					dtlRecCount++;					
					amtReceived += Long.parseLong(segment.substring(60,69));

					formattedMsg.append("DCS" + fieldSeperator);
					formatSegment(segment, "detail");
				}
				else if(HEADER_START.equals(segment.charAt(0)+""))
				{
					msgClientNo = segment.substring(9,12);
					String dbClientNo = dbTransactions.getDBClientID();	
					
					if(!msgClientNo.equals(dbClientNo)) 
					{
						isSuccess = false;
						errMsg = "Invalid Client Number";
						break;
					}
					else
					{
						isValidClientNo = true;						
						formattedMsg.append(msgStart + "HCS" + fieldSeperator);
						formatSegment(segment, "header");
					}
				}
				else if(FOOTER_START.equals(segment.charAt(0)+""))
				{
					long totAmount = Long.parseLong(segment.substring(10,22));
					long recCount = Long.parseLong(segment.substring(1,9));

					if((amtReceived == totAmount) && (dtlRecCount == recCount))
					{
						isValidTotAmt = true;
						isDtlRecCountValid = true;

						formattedMsg.append("TCS" + fieldSeperator);
						formatSegment(segment, "footer");						
						formattedMsg.append(msgEnd);						
					}
					else if(!isValidTotAmt)
					{
						errMsg = "Invalid total amount received...";
					}
					else
					{
						errMsg = "Invalid record count...";
					}
					common.fileOutput(logFileName, "(CustomValidations:CounterService) totAmount: "+totAmount+"\n");
					common.fileOutput(logFileName, "(CustomValidations:CounterService) amtReceived: "+amtReceived+"\n");
					common.fileOutput(logFileName, "(CustomValidations:CounterService) recCount: "+recCount+"\n");
					common.fileOutput(logFileName, "(CustomValidations:CounterService) dtlRecCount: "+dtlRecCount+"\n");					
				}
			}
		}
		catch(Exception exp)
		{			
			common.fileOutput(logFileName, "(CustomValidations:counterService) Exception: "+exp+"\n");
			common.fileOutput(expLogFileName, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
		finally
		{
			if(isValidClientNo && isDtlRecCountValid && isValidTotAmt) isSuccess = true;
		}

		return isSuccess;
	}

	/**
	 * Method validates counter service messages.
	 */
	private boolean bankProtocol(String message)
	{		
		boolean isSuccess = false;

		//validations
		boolean isValidCreditAmt = false;		
		boolean isValidDebitAmt = false;
		boolean isValidBankCode = false;
				
		long debitAmtReceived = 0;
		long creditAmtReceived = 0;

	//	FileInputStream fileInputStream = null;
	//	BufferedReader buffer = null;
		String segment = null;		
		
		final String HEADER_START = "H";
		final String DETAIL_START = "D";
		final String FOOTER_START = "T";
		final String CREDIT_START = "C";

		try
		{			
			StringTokenizer msgSegments = new StringTokenizer(message, LINE_SEPERATOR);			

			while(msgSegments.hasMoreTokens())
			{
				segment = msgSegments.nextToken();										
				
				if(DETAIL_START.equals(segment.charAt(0)+""))
				{					
					formattedMsg.append("DBK" + fieldSeperator);
					formatSegment(segment, "detail");

					if(DETAIL_START.equals(segment.charAt(152)+""))	debitAmtReceived += Long.parseLong(segment.substring(164,176));
					if(CREDIT_START.equals(segment.charAt(152)+""))	
					{						
						creditAmtReceived += Long.parseLong(segment.substring(164,176));
					}
				}
				else if(HEADER_START.equals(segment.charAt(0)+""))
				{	
					String siteBankCode = segment.substring(7,10);
					String ehisBankCode = dbTransactions.getBankCode(siteBankCode);					

					common.fileOutput(logFileName, "(CustomValidations:bankProtocol) ehisBankCode: "+ehisBankCode+"\n");
					common.fileOutput(logFileName, "(CustomValidations:bankProtocol) siteBankCode: "+siteBankCode+"\n");
					
					if(ehisBankCode == null) 
					{
						isSuccess = false;
						errMsg = "Translation not available for this bank code " + siteBankCode;
						common.fileOutput(logFileName, "(CustomValidations:bankProtocol) errMsg: "+errMsg+"\n");
						break;
					}
					else
					{
						isValidBankCode = true;	
						formattedMsg.append(msgStart + "HBK" + fieldSeperator);
						formatSegment(segment, "header");
					}
				}
				else if(FOOTER_START.equals(segment.charAt(0)+""))
				{
					long totDebAmt = Long.parseLong(segment.substring(21,33));
					long totCreditTAmt = Long.parseLong(segment.substring(40,52));					

					if(debitAmtReceived == totDebAmt)
					{
						isValidDebitAmt = true;						
					}
					else
					{
						errMsg = "Invalid Debit Amount...";
						common.fileOutput(logFileName, "(CustomValidations:bankProtocol) "+errMsg+"\n");
					}

					if(creditAmtReceived == totCreditTAmt)
					{
						isValidCreditAmt = true;						
					}
					else
					{						
						errMsg = "Invalid Credit Amount...";
						common.fileOutput(logFileName, "(CustomValidations:bankProtocol) "+errMsg+"\n");
					}

					formattedMsg.append("TBK" + fieldSeperator);
					formatSegment(segment, "footer");						
					formattedMsg.append(msgEnd);

					common.fileOutput(logFileName, "(CustomValidations:bankProtocol) totDebAmt: "+totDebAmt+"\n");
					common.fileOutput(logFileName, "(CustomValidations:bankProtocol) debitAmtReceived: "+debitAmtReceived+"\n");
					common.fileOutput(logFileName, "(CustomValidations:bankProtocol) totCreditTAmt: "+totCreditTAmt+"\n");
					common.fileOutput(logFileName, "(CustomValidations:bankProtocol) creditAmtReceived: "+creditAmtReceived+"\n");
				}
			}
		}
		catch(Exception exp)
		{			
			common.fileOutput(logFileName, "(CustomValidations:bankProtocol) Exception: "+exp+"\n");
			common.fileOutput(expLogFileName, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
		finally
		{
			if(isValidDebitAmt && isValidCreditAmt && isValidBankCode) isSuccess = true;
		}

		return isSuccess;
	}

	private void initMethod()
	{
		try
		{									
			if(dbTransactions == null) dbTransactions = new DBTransactions(serverParameters, dbConn);
					
			int tempCount = 1;
			
			if(serverParameters.msgLayout != null && !serverParameters.msgLayout.equals(""))
			{
				ArrayList layoutList = (ArrayList)tokenList(serverParameters.msgLayout, LINE_SEPERATOR);
				while(tempCount < 4)
				{					
					if(tempCount == 1) hdrSegmentList = (ArrayList)tokenList((String)layoutList.get(0), fieldSeperator);
					else if(tempCount == 2) dtlSegmentList = (ArrayList)tokenList((String)layoutList.get(1), fieldSeperator);
					else if(tempCount == 3) ftrSegmentList = (ArrayList)tokenList((String)layoutList.get(2), fieldSeperator);
					tempCount++;
				}
			}
			else
			{
				common.fileOutput(logFileName, "(CustomValidations:initMethod) Message Layout not defined...\n");
			}
			
			formattedMsg.delete(0, formattedMsg.length());
			
			boolInit = true;
		}
		catch(Exception exp)
		{
			common.fileOutput(logFileName, "(CustomValidations:initMethod) Exception: "+exp+"\n");
			common.fileOutput(expLogFileName, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
	}

	private void formatSegment(String currSegment, String segmentType)
	{
		ArrayList tempList = null;
		try
		{
			if("detail".equals(segmentType)) tempList = dtlSegmentList;
			else if("header".equals(segmentType)) tempList = hdrSegmentList;
			else if("footer".equals(segmentType)) tempList = ftrSegmentList;

			int fieldSize = tempList.size();

			for (int i = 1; i < fieldSize; i++)
			{
				String tempField = (String)tempList.get(i);
				
				int index = tempField.indexOf(".");
				int start = Integer.parseInt(tempField.substring(0, index)) - 1;
				int end = start + Integer.parseInt((tempField.substring(index+1, tempField.length())).trim());				
								
				formattedMsg.append(currSegment.substring(start, end));
				formattedMsg.append(fieldSeperator);
			}
			formattedMsg.append(segmentEnd);						
		}
		catch(Exception exp)
		{
			common.fileOutput(logFileName, "(CustomValidations:formatSegment) Exception: "+exp+"\n");
			common.fileOutput(expLogFileName, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
	}

	List tokenList(String replaceStr, String delimiter)
	{
		StringTokenizer tokens = new StringTokenizer(replaceStr, delimiter);
		ArrayList list = new ArrayList();		

		while (tokens.hasMoreTokens())
		{	
			String test = tokens.nextToken();			
			list.add(test);				
		}		
		return list;
	}

	/**
	 * Method for building PABX Reconciliation message from the report
	 */
	public boolean pabxReconciliation(String message)
	{
		String roomNo = null;
		try
		{
			StringTokenizer reportTokens = new StringTokenizer(message, LINE_SEPERATOR);
			boolean init = false;

			formattedMsg.delete(0, formattedMsg.length());			

			while (reportTokens.hasMoreTokens())
			{
				String currentMsg = reportTokens.nextToken();				

			//	common.fileOutput(logFileName, "(CustomValidations:pabxReconciliation) ----- Tokens -----\n");
			//	common.fileOutput(logFileName, currentMsg + "\n");

				ArrayList msgList = (ArrayList)CommonUtil.getTokenList(currentMsg, " ");

			//	common.fileOutput(logFileName, "(CustomValidations:pabxReconciliation) Test: "+msgList.get(0)+"\n");

				if( CommonUtil.isSubstringExists(currentMsg, "ROOM NO:") ) 
				{
					roomNo = (String)msgList.get(2);
			//		common.fileOutput(logFileName, "(CustomValidations:pabxReconciliation) roomNo: "+roomNo+"\n");
					init = true;
				}
				else if( ((String)msgList.get(0)).equals("EXTN.NO") ) 
				{
			//		common.fileOutput(logFileName, "(CustomValidations:pabxReconciliation) DIALLED: \n");
					continue; // Header line, not req for processing
				}
				else if( ((String)msgList.get(0)).equals("TOTAL") ) 
				{
					init = false;
			//		common.fileOutput(logFileName, "(CustomValidations:pabxReconciliation) TOTAL: \n");
					continue; // Header line, not req for processing
				}
				else if(init)
				{
				//	common.fileOutput(logFileName, "(CustomValidations:pabxReconciliation) MessageTemp1: "+formattedMsg.toString()+"\n");
					formattedMsg.append(msgStart);
					formattedMsg.append(segmentStart);					
					formattedMsg.append("PS");
					formattedMsg.append(fieldSeperator);
					formattedMsg.append("RN");
					formattedMsg.append(roomNo);
					formattedMsg.append(fieldSeperator);
					formattedMsg.append("PTC");
					formattedMsg.append(fieldSeperator);
					formattedMsg.append("DA");
					formattedMsg.append(CommonUtil.convertDateFormat((String)msgList.get(2), "ddMMMyyyy", "yyMMdd"));
					formattedMsg.append(fieldSeperator);
					formattedMsg.append("TI");
					formattedMsg.append(CommonUtil.convertDateFormat((String)msgList.get(3), "HH:mm:ss", "HHmmss"));
					formattedMsg.append(fieldSeperator);
					formattedMsg.append("DD" + (String)msgList.get(1));
					formattedMsg.append(fieldSeperator);
					formattedMsg.append("DU000000");
					formattedMsg.append(fieldSeperator);
					formattedMsg.append("P#");
					formattedMsg.append(fieldSeperator);
					formattedMsg.append("S1");
					formattedMsg.append((String)msgList.get(6));
					formattedMsg.append(fieldSeperator);
					formattedMsg.append("T1");
					formattedMsg.append((String)msgList.get(7));
					formattedMsg.append(fieldSeperator);
					formattedMsg.append("TA");
					formattedMsg.append((String)msgList.get(8));
					formattedMsg.append(segmentEnd);
					formattedMsg.append(msgEnd);

				//	common.fileOutput(logFileName, "(CustomValidations:pabxReconciliation) MessageTemp: "+formattedMsg.toString()+"\n");
				}
			}		
		}
		catch (Exception exp)
		{
			common.fileOutput(logFileName, "(CustomValidations:pabxReconciliation) Exception: "+exp.getMessage()+"\n");
			common.fileOutput(expLogFileName, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
		return true;
	}

}