/*
 * iSOFT-eHIS Interface Engine - Custom Processes
 */

package com.isoft.interfaceengine.validations;

import java.io.*;
import java.util.*;
import java.sql.Connection;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;

import com.blandware.atleap.common.parsers.rtf.*;

import HL7Engine.Common.*;
import HL7Engine.InboundProcess.InboundServerParameters;
import HL7Engine.InboundProcess.InboundServerDBInteraction;
import com.isoft.interfaceengine.util.InterfaceUtil;
import com.isoft.interfaceengine.util.BillingConstants;

/**
 * Class contains methods with required custom processes for different profiles/protocols.
 * Method runProcess will be the common method which will be called from InterfaceEngine,
 * based on the protocol appropriate method will be invoked.
 *
 * @version		1.0 28 Jan 2010
 * @author		Ravindranath
 */
public class InboundCustomProcess
{
	public String errMsg; // error msg sent back to external interface is msg validation fails.
	public String ackMsg;
	public StringBuffer formattedMsg; // message after formatting the received message as per the protocol reqquirements.

	InboundServerParameters serverParameters = null;
	InboundServerDBInteraction serverDB;
	Common common = null;

	private String logFileName;
	private String expLogFileName;
	private String fieldSeparator;
	private String segmentStart;
	private String segmentEnd;
	private String msgStart;
	private String msgEnd;

//	private static final String LINE_SEPERATOR = "" + (char)13 + (char)10;
	static final String RTF_ENCODE_FORMAT = "MS874";

	private static final String REP_HCODE_STR = "รหัส ร.พ.";
	private static final String REP_ACKNO_STR = "เลขตอบรับที่";
	private static final String REP_CGIP_ACKNO_STR = "เอกสารตอบรับ";
	private static final String REP_CGIP_NOACK_STR = "เลขที่เอกสารตอบรับ";
	private static final String REP_ACK_DATETIME_STR = "วันที่ออกเลขตอบรับ";
	private static final String REP_DEL_PRID_STR = "งวดที่ส่งไป";
	private static final String REP_DEL_ITEMS_STR = "รายการที่ส่งไป";
	private static final String REP_ACC_ITEMS_STR = "รายการที่ตรวจผ่าน";
	private static final String REP_UNACC_ITEMS_STR = "รายการที่ตรวจไม่ผ่าน";
	private static final String REP_CGIP_ACD_2 = "**   ตอนที่";
	private static final String BIL_HCODE_STR = "รหัส ร.พ.";
	private static final String BIL_DELIVERY_CODE_STR = "งวดส่งของ ร.พ.";
	private static final String BIL_REP_DATE_STR = "วันที่ออกเลขตอบรับ";
	private static final String BIL_REP_FILENO_STR = "เลขที่ตอบรับ";
	private static final String BIL_INV_SNT_STR = "รายการที่ส่งไปทั้งสิ้น";
	private static final String BIL_INV_PRCSD_STR = "รายการที่ตรวจผ่านทั้งสิ้น";
	private static final String BIL_INV_UNPRCSD_STR = "รายการที่ตรวจไม่ผ่านทั้งสิ้น";
	private static final String BIL_CSH_SEG_STR = "สถานี";
	private static final String BIL_DTL_SEG_START = "*|";
	private static final String BIL_PART1_STR = "ตอนที่ 1"; // Used for differentiating between different COH segments in the doc
	private static final String BIL_PART2_STR = "ตอนที่ 2";
	static String BIL_PART3_STR = "ผู้ป่วยโรคไตที่มีการฟอกเลือด"; // CD2 Seg Start
//	private static final String ACC_HDR_STR = "ใบสรุปค่ารักษาพยาบาล";
	private static final String ACC_REP_FILE_DATE = "ลงวันที่";
	private static final String ACC_ENC_ID = "ของ";
	private static final String ACC_START_DATE = "ตั้งแต่";
	private static final String ACC_DRG_VAL = "DRGs";
	private static final String ACC_SEG_ID = "REP";	

	static final String REP_DTL_SEG_START = "*|";

	static final String SSIP_MSG_HDR_SEGID = "SIH";	
	static final String SSIP_MSG_DTL_SEGID = "SID";
	static final String UCIP_MSG_HDR_SEGID = "UIH";
	static final String UCIP_MSG_DTL_SEGID = "UID";
	static final String CGIP_MSG_HDR_SEGID = "ACH";
	static final String CGIP_MSG_DTL_SEGID = "ACD";

	static final String ACC_RES_CODE = "ACCEPTANCERESULTCODE";

	String hdrSegID;
	String dtlSegID;

//	String fieldSeparator = "|";	
	StringBuilder hdrSegBuilder = null;

	int segmentCount = 0; // Used in ACC file processing

	private boolean isLogEnabled = false;
//	private boolean boolInit = false;

	DBTransactions dbTransactions;

	public InboundCustomProcess(InboundServerParameters serverParameters, InboundServerDBInteraction serverDB)
	{
		common = Common.getInstance();
		this.serverParameters = serverParameters;
		this.logFileName = serverParameters.strLogFile;
		this.expLogFileName = serverParameters.strExceptionLogFile;
		isLogEnabled = serverParameters.logToFile;

		this.serverDB = serverDB;

		fieldSeparator = CommonUtil.formatAsciiToString(serverParameters.fieldSeperator);
		segmentStart = CommonUtil.formatAsciiToString(CommonUtil.checkNull(serverParameters.messageSegmentStart));
		segmentEnd = CommonUtil.formatAsciiToString(CommonUtil.checkNull(serverParameters.messageSegmentEnd));
		msgStart = CommonUtil.formatAsciiToString(CommonUtil.checkNull(serverParameters.messageStart));
		msgEnd = CommonUtil.formatAsciiToString(CommonUtil.checkNull(serverParameters.messageEnd));

		formattedMsg = new StringBuffer();
	}

	/**
	 * Common method which will be called from InterfaceEngine.
	 * Based on the protocolID appropriate process will be executed.
	 */
	public void runProcess()
	{
		try
		{			
		//	String xslFileName = null;
			String xmlFileRepository = serverParameters.strFileDirectory;			

			if("SRREBLP9".equals(serverParameters.strProtocolId)
				|| ("SRREBLP10".equals(serverParameters.strProtocolId)))
			{	
				String xmlTempPath = xmlFileRepository + "/Bangkok/";
				processXMLFiles(xmlTempPath, "/txtfiles/" + serverParameters.strProtocolId + "_Bangkok.txt");

				xmlTempPath = xmlFileRepository + "/CGIP/";
				processXMLFiles(xmlTempPath, "/txtfiles/" + serverParameters.strProtocolId + "_CGIP.txt");
			}			
			else if("SRREBLP12".equals(serverParameters.strProtocolId))
			{							
				String xmlTempPath = xmlFileRepository + "/Bangkok/";
				processXMLFiles(xmlTempPath, "/txtfiles/" + serverParameters.strProtocolId + "_Bangkok.txt");

				xmlTempPath = xmlFileRepository + "/CGOP/";
				processXMLFiles(xmlTempPath, "/txtfiles/" + serverParameters.strProtocolId + "_CGOP.txt");
			}
			else if("SRREBLP19".equals(serverParameters.strProtocolId))
			{							
			//	String xmlTempPath = xmlFileRepository + "/Bangkok/";
				processXMLFiles(xmlFileRepository, "/txtfiles/" + serverParameters.strProtocolId + "_SSIP.txt");
			}
			else if("SRREBLP17".equals(serverParameters.strProtocolId)
					|| "SRREBLP14".equals(serverParameters.strProtocolId)
					|| "SRREBLP8".equals(serverParameters.strProtocolId))
			{	
				processREPFiles();
			}
			else if("SRREBLP11".equals(serverParameters.strProtocolId))
			{							
				processBILFiles();
			}			
		}
		catch (Exception exp)
		{			
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

	private void transformXMLToTxt(File xmlFile, String xslFileName, String txtFileName) throws Exception
	{
		FileOutputStream fos = null;
		FileOutputStream outputstream = null;

		try
		{			
			File xsltFile = new File(xslFileName);
			File txtFile = new File(txtFileName);

			Source xmlSource = new StreamSource(xmlFile);
			Source xsltSource = new StreamSource(xsltFile);			

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer(xsltSource);

			CommonUtil.makeDirectory(txtFile.getParent());
			outputstream = new FileOutputStream(txtFileName, true) ;			

			transformer.transform(xmlSource, new StreamResult(outputstream));
			moveProcessedFile(xmlFile);
						
			if(isLogEnabled) common.fileOutput( serverParameters.strLogFile, "(InboundCustomProcess:transformXMLToTxt) XML file transfomred to " + txtFileName + " \n" ) ;
		}
		catch(Exception exception)
		{
			common.fileOutput(logFileName, "(InboundCustomProcess:transformXMLToTxt) Exception:"+exception.getMessage()+"\n" ) ;
			common.fileOutput(expLogFileName, CommonUtil.getStringStackTrace(exception) + "\n" ) ;
		}
		finally
		{
			if(outputstream != null) outputstream.close();
			if(fos != null) fos.close();
		}		
	}

	private void processXMLFiles(String xmlFilePath, String txtFileName) throws Exception
	{
		String xmlFileRepository = serverParameters.strFileDirectory;
		String xslFileName = null;
		String fileType = null;
		common.fileOutput(logFileName, "(InboundCustomProcess:processXMLFiles) Processing Folder : "+xmlFilePath+"\n" ) ;
		File xmlFile = new File(xmlFilePath);
		File [] fileList = xmlFile.listFiles();

		int i = 0;
		boolean initFlag = false; // used to identify reading SUM files, only after STM files

		if(fileList != null && fileList.length > 0)
		{
			while(fileList != null && i < fileList.length)
			{
				File currentXMLFile = fileList[i];
				String tempFileName = currentXMLFile.getName();
				common.fileOutput(logFileName, "(InboundCustomProcess:processXMLFiles) Current File: "+tempFileName+"\n" ) ;
				int tempIndex = tempFileName.lastIndexOf("_");
				if(tempIndex > 0) 
				{
					if("SRREBLP19".equals(serverParameters.strProtocolId))
						fileType = tempFileName.substring(tempIndex - 4, tempIndex - 1);
					else
						fileType = tempFileName.substring(tempIndex - 3, tempIndex);
				}
				else fileType = "";

				if(!initFlag && "STM".equalsIgnoreCase(fileType))
				{
					common.fileOutput(logFileName, "(InboundCustomProcess:processXMLFiles) Processing STM File\n" ) ;
					i = 0;				
					initFlag = true;
				}
				else if(initFlag && "SUM".equalsIgnoreCase(fileType))
				{
					common.fileOutput(logFileName, "(InboundCustomProcess:processXMLFiles) Init...\n" ) ;
				}
				else 
				{
					if("ADJ".equalsIgnoreCase(fileType))
					{
						moveProcessedFile(currentXMLFile);
					}
					common.fileOutput(logFileName, "(InboundCustomProcess:processXMLFiles) Next File...\n" ) ;
					i++;
					continue;
				}

				xslFileName = serverParameters.strProtocolId + "_" + fileType + ".xsl";
				common.fileOutput(logFileName, "(InboundCustomProcess:processXMLFiles) xslFileName: "+xslFileName+"\n" ) ;

				transformXMLToTxt(currentXMLFile, serverParameters.xslFileName + xslFileName, xmlFileRepository + txtFileName);			

				xmlFile = new File(xmlFilePath);
				fileList = xmlFile.listFiles();

				i = 0;
			}
			common.fileOutput(logFileName, "(InboundCustomProcess:processXMLFiles) Calling: processFile \n" ) ;
			processFile(xmlFileRepository + txtFileName);
		}
		else
		{
			common.fileOutput(logFileName, "(InboundCustomProcess:processXMLFiles) No files to process in "+xmlFilePath+"\n" ) ;
		}		
	}

	private void processFile(String fileName) throws Exception
	{
		int intTotWidth = 6291456;// 6mb
		char[] buf = new char[intTotWidth];
		int len = 0;
		common.fileOutput(logFileName, "(InboundCustomProcess:processFile) 1 \n" ) ;
		
		File currentFile = new File(fileName);
		InputStream fileInputStream = new FileInputStream(currentFile);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF8"));	
		common.fileOutput(logFileName, "(InboundCustomProcess:processFile) 2 \n" ) ;

		StringBuffer strBuffer = new StringBuffer();
	//	String line = null;
	common.fileOutput(logFileName, "(InboundCustomProcess:processFile) 3 \n" ) ;

		while (((len = bufferedReader.read(buf, 0, buf.length)) != -1)) 
		{
			common.fileOutput(logFileName, "(InboundCustomProcess:processFile) 34 \n" ) ;
			strBuffer.append(buf, 0, len);
		}

		String message = strBuffer.toString();

		common.fileOutput(logFileName, "(InboundCustomProcess:processXMLFiles) Before:\n "+message+"\n" ) ;

		message = message.replaceFirst(BillingConstants.XML_MSG_START, msgStart);
		message = message.replaceFirst(BillingConstants.XML_MSG_END, msgEnd);
		message = message.replaceAll(BillingConstants.XML_SEG_START, segmentStart);
		message = message.replaceAll(BillingConstants.XML_SEG_END, segmentEnd);
		message = message.replaceAll(BillingConstants.XML_FIELD_SEP, fieldSeparator);

		common.fileOutput(logFileName, "(InboundCustomProcess:processXMLFiles) After:\n "+message+"\n" ) ;

		serverDB.processQueryMessage(message);

		if(bufferedReader != null) bufferedReader.close();
		if(fileInputStream != null) fileInputStream.close();
		moveProcessedFile(currentFile);
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

			String processedFilename = currentFile.getName();
			processedFilename = processedFilename.substring(0, processedFilename.indexOf(".")) + "_"
								+ CommonUtil.getFormattedStringDate("yyyyMMddHHmmss", new Date())
								+ processedFilename.substring(processedFilename.indexOf("."));

			fileToMove = new File(fileToMove, processedFilename);			

			boolean fileMoved = currentFile.renameTo(fileToMove);

			if(!fileMoved) common.fileOutput(logFileName, "(InboundCustomProcess:moveProcessedFile) Unable to move file...\n" ) ;
		}
		catch(Exception exception)
		{
			common.fileOutput(expLogFileName, CommonUtil.getStringStackTrace(exception) + "\n" );
		}
	}

	private void processREPFiles()
	{
		try
		{		
			String fileName = null;
			hdrSegBuilder = null;
		//	String segmentEnd = "\n";
			String acd3 = "";
			String acd2 = "";

			if("SRREBLP17".equals(serverParameters.strProtocolId))
			{
				hdrSegID = SSIP_MSG_HDR_SEGID;
				dtlSegID = SSIP_MSG_DTL_SEGID;
			}
			else if("SRREBLP14".equals(serverParameters.strProtocolId))
			{
				hdrSegID = UCIP_MSG_HDR_SEGID;
				dtlSegID = UCIP_MSG_DTL_SEGID;
			}
			else if("SRREBLP8".equals(serverParameters.strProtocolId))
			{
				hdrSegID = CGIP_MSG_HDR_SEGID;
				dtlSegID = CGIP_MSG_DTL_SEGID;
			}

			while(true)
			{				
				fileName = InterfaceUtil.getOldFileInFolder(serverParameters.strFileDirectory, "REP");				

				if(fileName == null)
				{
					common.fileOutput(logFileName, "(InboundCustomProcess:processREPFiles) No more files to process...\n");
					break;
				}

				common.fileOutput(logFileName, "(InboundCustomProcess:processREPFiles) fileName: "+fileName+"\n");

				Scanner sc = new Scanner(new File(fileName), RTF_ENCODE_FORMAT);
				String currentLine = null;
			//	hdrSegBuilder = new StringBuilder();
				StringTokenizer curLineTokens = null;				

				while(sc.hasNextLine())
				{
					currentLine = sc.nextLine().replaceAll("\\t", " ");

					if("SRREBLP8".equals(serverParameters.strProtocolId))
					{
						if(currentLine.contains("(FFS)")) acd2 = "FFS";
						else if(currentLine.contains("(DRG)")) acd2 = "DRG";
						if(currentLine.contains("(PD)")) acd2 = "PD";
					}

					if(currentLine.startsWith(REP_DTL_SEG_START))
					{
						addFieldToBuffer(segmentEnd);
						addFieldToBuffer(dtlSegID + fieldSeparator);

					/*	if("C".equals(currentLine.charAt(5)+"")) 
						{
							int tempIndex = currentLine.indexOf(":");
							String temp = currentLine.substring(tempIndex + 1);					
							currentLine = currentLine.substring(0, tempIndex).trim() + "|" + temp.replaceAll(",", "^").trim();
						}
						else currentLine = currentLine.replaceAll(":",",");
					*/
						int tempIndex = currentLine.indexOf(":");
						if(tempIndex > 0)
						{
							String temp = currentLine.substring(tempIndex + 1);					
							currentLine = currentLine.substring(0, tempIndex).trim() + "|" + temp.replaceAll(",", "^").trim();
						}

						currentLine = currentLine.replaceAll("-.-","");
						currentLine = currentLine.replaceAll("-","");
						currentLine = currentLine.replaceAll("\\("," ");
						currentLine = currentLine.replaceAll("\\)",",");

						curLineTokens = new StringTokenizer(currentLine, ",");

						int totTokens = curLineTokens.countTokens();
						int i = 1;

						String segStart[] = curLineTokens.nextToken().split(" ");
						int segStartLen = segStart.length;
						
						if("SRREBLP8".equals(serverParameters.strProtocolId))
						{
							addFieldToBuffer(acd2 + fieldSeparator);

							if(!"E".equals(segStart[2])) addFieldToBuffer(acd3 + fieldSeparator);
							else addFieldToBuffer(fieldSeparator);
						}

						for (int k = 1; k < segStartLen; k++)
						{
							addFieldToBuffer(segStart[k] + fieldSeparator);
						}

					//	if("C".equals(segStart[2]) || "E".equals(segStart[2])) 
						if("FFS".equals(acd2) || "PD".equals(acd2))
						{
							addFieldToBuffer(fieldSeparator + fieldSeparator + fieldSeparator);
						}
						
					/*	addFieldToBuffer(segStart[1] + fieldSeparator
											+ segStart[2] + fieldSeparator
											+ segStart[3] + fieldSeparator
											+ segStart[4] + fieldSeparator);
					*/
						while(i < totTokens) 
						{
							if((i == totTokens-1))
							{
								if("C".equals(segStart[2])) 
								{
									addFieldToBuffer(curLineTokens.nextToken().trim());
								}
								else if("E".equals(segStart[2]))
								{
									curLineTokens.nextToken();
								}
							}
							else
							{
								if((i == totTokens-2))
								{
									addFieldToBuffer(curLineTokens.nextToken().trim());
								}
								else
								{
									addFieldToBuffer(curLineTokens.nextToken().trim() + fieldSeparator);
								}
							}
						//	System.out.println(curLineTokens.nextToken());
							i++;					
						}				
					}
					else if(currentLine.startsWith(REP_HCODE_STR) || currentLine.startsWith(REP_ACKNO_STR))
					{
						curLineTokens = new StringTokenizer(currentLine, " ");
						int totTokens = curLineTokens.countTokens();
						int i = 1;
						while(i < totTokens) 
						{ 
							curLineTokens.nextToken();
							i++;
						}

						if(currentLine.startsWith(REP_HCODE_STR) && !"SRREBLP8".equals(serverParameters.strProtocolId)) 
						{
							addFieldToBuffer(hdrSegID + fieldSeparator);
						}

						addFieldToBuffer(curLineTokens.nextToken() + fieldSeparator);
					}
					else if(currentLine.startsWith(REP_ACK_DATETIME_STR))
					{
						curLineTokens = new StringTokenizer(currentLine, " ");
						int totTokens = curLineTokens.countTokens();
						int i = 0;
						while(i < totTokens) 
						{	
							if(i == 2 || i == 5)
								addFieldToBuffer(curLineTokens.nextToken() + fieldSeparator);
							else
								curLineTokens.nextToken();
							i++;
						}			
					}
					else if(currentLine.startsWith(REP_DEL_PRID_STR))
					{
						currentLine = currentLine.replaceFirst(", ", "^");
						curLineTokens = new StringTokenizer(currentLine, " ");
						int totTokens = curLineTokens.countTokens();
						int i = 0;
						while(i < totTokens) 
						{	
							if(i == 2 || i == 5)
								addFieldToBuffer(curLineTokens.nextToken() + fieldSeparator);
							else
								curLineTokens.nextToken();
							i++;
						}			
					}
					else if(currentLine.startsWith(REP_DEL_ITEMS_STR)
							|| currentLine.startsWith(REP_ACC_ITEMS_STR)
							|| currentLine.startsWith(REP_UNACC_ITEMS_STR)
							|| currentLine.startsWith(REP_CGIP_ACKNO_STR))
					{		
						if(currentLine.startsWith(REP_CGIP_ACKNO_STR) && "SRREBLP8".equals(serverParameters.strProtocolId))
						{
							addFieldToBuffer(hdrSegID + fieldSeparator);
						}

						curLineTokens = new StringTokenizer(currentLine, " ");
						int totTokens = curLineTokens.countTokens();
						int i = 0;
						while(i < totTokens) 
						{	
							if(i == 2)
								addFieldToBuffer(curLineTokens.nextToken() + fieldSeparator);
							else
								curLineTokens.nextToken();
							i++;
						}
						if(currentLine.startsWith(REP_UNACC_ITEMS_STR)) addFieldToBuffer(ACC_RES_CODE);
					}
					else if(currentLine.startsWith(REP_CGIP_NOACK_STR))
					{
						curLineTokens = new StringTokenizer(currentLine, " ");
						int totTokens = curLineTokens.countTokens();
						int i = 1;
						while(i < totTokens) 
						{ 
							curLineTokens.nextToken();
							i++;
						}							

						addFieldToBuffer(curLineTokens.nextToken() + fieldSeparator);

						for (int k = 0; k <= 5; k++) // reading the next six lines consecutively
						{
							currentLine = sc.nextLine().replaceAll("\\t", " ");
							curLineTokens = new StringTokenizer(currentLine, " ");
							totTokens = curLineTokens.countTokens();
							i = 1;
							while(i <= totTokens) 
							{ 
								if(k == 1 && (i == 3 || i == 5)) 
								{							
									addFieldToBuffer(curLineTokens.nextToken().replaceAll(",","") + fieldSeparator);
								}
								else if(k == 3 && i == 3) 
								{
									addFieldToBuffer(curLineTokens.nextToken().replaceAll(",","") + fieldSeparator);
								}
								else if(k == 4 && i == 5) 
								{
									addFieldToBuffer(curLineTokens.nextToken().replaceAll(",","") + fieldSeparator);
								}
								else if(k == 5 && i == 4) 
								{
									addFieldToBuffer(curLineTokens.nextToken().replaceAll(",","") + fieldSeparator);
								}
								else if(k == 2 && i == 3) 
								{
									addFieldToBuffer(curLineTokens.nextToken().replaceAll(",","") + fieldSeparator);
								}
								else 
								{							
									curLineTokens.nextToken();
								}
								i++;
							}							
						}
					}
					else if(currentLine.startsWith(REP_CGIP_ACD_2))
					{
						acd3 = "";
						curLineTokens = new StringTokenizer(currentLine, " ");
						int totTokens = curLineTokens.countTokens();
						int i = 1;
						while(i <= totTokens) 
						{ 
							if(i == 5 || i == 6) 
							{						
								acd3 += curLineTokens.nextToken();
							}
							else curLineTokens.nextToken();
							i++;
						}	
					}
				}
				
				String derivedMsg = "";

				if(sc != null) sc.close();

				if("SRREBLP8".equals(serverParameters.strProtocolId))
				{
					derivedMsg = (hdrSegBuilder.toString()).replaceFirst(ACC_RES_CODE, "");
					hdrSegBuilder = new StringBuilder(derivedMsg);
					processACCFiles(fileName);
				}
				else
				{
					derivedMsg = (hdrSegBuilder.toString()).replaceFirst(ACC_RES_CODE, currentLine.substring(5));
				//	serverDB.processQueryMessage(derivedMsg);
					processDerivedMsg(derivedMsg);
				}

				moveProcessedFile(new File(fileName));
			}
		}
		catch (Exception exp)
		{
			common.fileOutput(logFileName, "(InboundCustomProcess:processREPFiles) Exception:"+exp.getMessage()+"\n");
			common.fileOutput(expLogFileName, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
	}

	private void processBILFiles()
	{
		hdrSegBuilder = null;
		boolean isDtlProc = false;

		try
		{		
			String fileName = null;
		//	String segmentEnd = "\n";

			while(true)
			{
				common.fileOutput(logFileName, "(InboundCustomProcess:processREPFiles) Test\n");
				fileName = InterfaceUtil.getOldFileInFolder(serverParameters.strFileDirectory, "BIL");				

				if(fileName == null)
				{
					common.fileOutput(logFileName, "(InboundCustomProcess:processREPFiles) No more files to process...\n");
					break;
				}

				common.fileOutput(logFileName, "(InboundCustomProcess:processREPFiles) fileName: "+fileName+"\n");
				Scanner sc = new Scanner(new File(fileName), RTF_ENCODE_FORMAT);
				String currentLine = null;
			//	hdrSegBuilder = new StringBuilder();
				StringTokenizer curLineTokens = null;

				String replyFileNo = "";
				String replyDate = "";
				String replyTime = "";
				String hCode = "";
				String dtlSegStart = null;

				int currentPart = 0;

				while(sc.hasNextLine())
				{
					currentLine = sc.nextLine().replaceAll("\\t", " ");

					if(currentLine.startsWith(BIL_DTL_SEG_START))
					{
					/*	if(currentPart == 1) addFieldToBuffer("C");
						else if(currentPart == 2) addFieldToBuffer("B");
						else if(currentPart == 3) addFieldToBuffer("Y");
					*/
						isDtlProc = true;
						addFieldToBuffer(segmentEnd);
						currentLine = currentLine.replaceAll("_","");
						
						if(currentLine.endsWith("|")) 
						{					
							int temp = currentLine.length();
							currentLine = currentLine.substring(0, temp - 1);					
						}
						else if("C".equals(currentLine.charAt(3)+""))
						{
							int lastPipeIndex = currentLine.lastIndexOf("|");					
							currentLine = currentLine.substring(0, lastPipeIndex) + "," + currentLine.substring(lastPipeIndex + 1);					
						}

						curLineTokens = new StringTokenizer(currentLine, ",");

						int totTokens = curLineTokens.countTokens();
						int i = 1;

						String segStart[] = curLineTokens.nextToken().split(" ");
						addFieldToBuffer(dtlSegStart + fieldSeparator
											+ replyFileNo + fieldSeparator
											+ segStart[1] + fieldSeparator
											+ segStart[2] + fieldSeparator);

						while(i < totTokens) 
						{					
							addFieldToBuffer(curLineTokens.nextToken().trim() + fieldSeparator);
							i++;					
						}

						if(currentLine.endsWith("|")) 
						{					
							int builderLen = hdrSegBuilder.length();
							hdrSegBuilder = hdrSegBuilder.delete(builderLen - 2, builderLen - 1);
						}
						else if("C".equals(currentLine.charAt(3)+""))
						{
							int builderLen = hdrSegBuilder.length();
							hdrSegBuilder = hdrSegBuilder.delete(builderLen - 1, builderLen);
						}
					}
					else if(currentLine.startsWith(BIL_HCODE_STR) || currentLine.startsWith(BIL_REP_FILENO_STR))
					{
						isDtlProc = false;
						curLineTokens = new StringTokenizer(currentLine, " ");
						int totTokens = curLineTokens.countTokens();
						int i = 1;
						while(i < totTokens) 
						{ 
							curLineTokens.nextToken();
							i++;
						}
					//	addFieldToBuffer(curLineTokens.nextToken() + fieldSeparator);
						if(currentLine.startsWith(BIL_HCODE_STR)) hCode = curLineTokens.nextToken();
						else if(currentLine.startsWith(BIL_REP_FILENO_STR)) replyFileNo = curLineTokens.nextToken();				
					}
					else if(currentLine.startsWith(BIL_REP_DATE_STR))
					{
						isDtlProc = false;
						curLineTokens = new StringTokenizer(currentLine, " ");
						int totTokens = curLineTokens.countTokens();
						int i = 0;
						while(i < totTokens) 
						{	
							if(i == 2) replyDate = curLineTokens.nextToken();
							else if(i == 4) replyTime = curLineTokens.nextToken();					
							else curLineTokens.nextToken();
							i++;
						}			
					}
					else if(currentLine.startsWith(BIL_PART1_STR))
					{
						isDtlProc = false;
						currentPart = 1;
						addFieldToBuffer("COH" + fieldSeparator + hCode + fieldSeparator);
						dtlSegStart = "CD1";
					}
					else if(currentLine.startsWith(BIL_PART2_STR))
					{
						isDtlProc = false;
						currentPart = 2;
						addFieldToBuffer(segmentEnd + "COH" + fieldSeparator + hCode + fieldSeparator);
						dtlSegStart = "CD1";
					}
					else if(currentLine.endsWith(BIL_PART3_STR))
					{
						isDtlProc = false;
						currentPart = 3;
						addFieldToBuffer(segmentEnd + "COH" + fieldSeparator + hCode + fieldSeparator);
						dtlSegStart = "CD2";
					}
					else if(currentLine.startsWith(BIL_DELIVERY_CODE_STR) && currentPart != 0)
					{
						isDtlProc = false;
						String temp = currentLine.replaceAll(", ", "^");
						curLineTokens = new StringTokenizer(temp, " ");
						int totTokens = curLineTokens.countTokens();
						int i = 1;
						while(i < totTokens) 
						{ 
							curLineTokens.nextToken();
							i++;
						}
						temp = curLineTokens.nextToken() + fieldSeparator
										+ replyDate + fieldSeparator
										+ replyTime + fieldSeparator
										+ replyFileNo + fieldSeparator;
						
						addFieldToBuffer(temp);				
					}
					else if(currentLine.startsWith(BIL_INV_SNT_STR) 
								|| currentLine.startsWith(BIL_INV_PRCSD_STR)
								|| currentLine.startsWith(BIL_INV_UNPRCSD_STR))
					{
						isDtlProc = false;
						curLineTokens = new StringTokenizer(currentLine, " ");
						int totTokens = curLineTokens.countTokens();
						int i = 1;
						while(i < totTokens) 
						{ 
							curLineTokens.nextToken();
							i++;
						}

					//	addFieldToBuffer(curLineTokens.nextToken() + fieldSeparator);
						addFieldToBuffer(curLineTokens.nextToken() + fieldSeparator);

					/*	if(currentLine.startsWith(BIL_INV_UNPRCSD_STR) && currentPart == 1)
							addFieldToBuffer("C");
						else if(currentLine.startsWith(BIL_INV_UNPRCSD_STR) && currentPart == 2)
							addFieldToBuffer("B");
						else if(currentLine.startsWith(BIL_INV_UNPRCSD_STR) && currentPart == 3)
							addFieldToBuffer("Y");
					*/
					}
					else if(currentLine.startsWith(BIL_CSH_SEG_STR))
					{
						curLineTokens = new StringTokenizer(currentLine, " ");
						int totTokens = curLineTokens.countTokens();
						int i = 1;
						while(i < totTokens) 
						{ 
							curLineTokens.nextToken();
							i++;
						}

						if(!isDtlProc && currentPart == 1) addFieldToBuffer("C");
						else if(!isDtlProc && currentPart == 2) addFieldToBuffer("B");
						else if(!isDtlProc && currentPart == 3) addFieldToBuffer("Y");

						isDtlProc = false;

						String temp = segmentEnd + "CSH" + fieldSeparator 
										+ curLineTokens.nextToken() + fieldSeparator 
										+ replyFileNo + fieldSeparator;
						addFieldToBuffer(temp);

						for (int j = 0; j < 3; j++)
						{
							currentLine = sc.nextLine().replaceAll("\\t", " ");
							curLineTokens = new StringTokenizer(currentLine, " ");
							totTokens = curLineTokens.countTokens();
							i = 1;
							while(i < totTokens) 
							{ 
								curLineTokens.nextToken();
								i++;
							}
							addFieldToBuffer(curLineTokens.nextToken() + fieldSeparator);
						}

						if(currentPart == 1)
							addFieldToBuffer("C");
						else if(currentPart == 2)
							addFieldToBuffer("B");
						else if(currentPart == 3)
							addFieldToBuffer("Y");
					
					}

				/*	else if(currentLine.startsWith(DEL_PRID_STR))
					{
						currentLine = currentLine.replaceFirst(", ", "^");
						curLineTokens = new StringTokenizer(currentLine, " ");
						int totTokens = curLineTokens.countTokens();
						int i = 0;
						while(i < totTokens) 
						{	
							if(i == 2 || i == 5)
								addFieldToBuffer(curLineTokens.nextToken() + fieldSeparator);
							else
								curLineTokens.nextToken();
							i++;
						}			
					}
					else if(currentLine.startsWith(DEL_ITEMS_STR)
							|| currentLine.startsWith(ACC_ITEMS_STR)
							|| currentLine.startsWith(UNACC_ITEMS_STR))
					{				
						curLineTokens = new StringTokenizer(currentLine, " ");
						int totTokens = curLineTokens.countTokens();
						int i = 0;
						while(i < totTokens) 
						{	
							if(i == 2)
								addFieldToBuffer(curLineTokens.nextToken() + fieldSeparator);
							else
								curLineTokens.nextToken();
							i++;
						}				
					}
			*/	}
			//	System.out.println(hdrSegBuilder.toString());
				
				common.fileOutput(logFileName, "(InboundCustomProcess:processBILFiles) Built Message:\n "+hdrSegBuilder.toString()+"\n");

				if(sc != null) sc.close();				
			//	serverDB.processQueryMessage(hdrSegBuilder.toString());
				processDerivedMsg(hdrSegBuilder.toString());
				moveProcessedFile(new File(fileName));
			}
		}
		catch(Exception exp)
		{
			common.fileOutput(logFileName, "(InboundCustomProcess:processBILFiles) Exception:"+exp.getMessage()+"\n");
			common.fileOutput(expLogFileName, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
	}

	public void processACCFiles(String repFileName) throws Exception
	{
		String currentLine = null;		
		String fileName = null;
	//	String segmentEnd = "\n";

	//	hdrSegBuilder = new StringBuilder();
		StringTokenizer curLineTokens = null;
		RTFPlainTextExtractor rtfTextExtractor = null;

		try
		{
			rtfTextExtractor = new RTFPlainTextExtractor();
		}
		catch (Error error)
		{
			common.fileOutput(logFileName, "(InboundCustomProcess:processACCFiles) Unable to find RTFParser API !!!\n");
		}
		
		FileInputStream fis = null;

		while(true)
		{
			String reqFileExt = repFileName.substring(
				repFileName.lastIndexOf("_"), repFileName.lastIndexOf("."));
				
			fileName = InterfaceUtil.getOldFileInFolder(serverParameters.strFileDirectory, reqFileExt + ".ACC");				

			if(fileName == null)
			{
				common.fileOutput(logFileName, "(InboundCustomProcess:processACCFiles) No more files to process...\n");
				break;
			}

			common.fileOutput(logFileName, "(InboundCustomProcess:processACCFiles) fileName: "+fileName+"\n");
			fis = new FileInputStream(fileName);
			String accFileContents = rtfTextExtractor.extract(fis, "MS874");
			Scanner sc = new Scanner(accFileContents);		

			while(sc.hasNextLine())
			{
				currentLine = sc.nextLine().replaceAll("\\t", " ");
				curLineTokens = new StringTokenizer(currentLine, " ");

				int totTokens = curLineTokens.countTokens();
				int i = 1;
				
				if(currentLine.startsWith(ACC_REP_FILE_DATE))
				{					
					segmentCount++;
					addFieldToBuffer(segmentEnd + ACC_SEG_ID + fieldSeparator);
					while(i < totTokens)
					{
						if(i == 2) addFieldToBuffer((curLineTokens.nextToken().trim()) + "/");
						else if(i == 3) addFieldToBuffer(InterfaceUtil.getThaiMonthNo(curLineTokens.nextToken().trim()) + "/");
						else if(i == 4) addFieldToBuffer((Integer.parseInt(curLineTokens.nextToken().trim()) - 543) + fieldSeparator);
						else curLineTokens.nextToken();
						i++;					
					}
				}
				else if(currentLine.startsWith(ACC_ENC_ID))
				{
					int tempIndex = currentLine.indexOf("AN - ");
					
					addFieldToBuffer(currentLine.substring(tempIndex + 5, currentLine.indexOf(")", tempIndex)) + fieldSeparator);				
				}
				else if(currentLine.startsWith(ACC_START_DATE))
				{
					while(i < totTokens)
					{
						if(i == 2) addFieldToBuffer((curLineTokens.nextToken().trim()) + "/");
						else if(i == 3) addFieldToBuffer(InterfaceUtil.getThaiMonthNo(curLineTokens.nextToken().trim()) + "/");
						else if(i == 4) addFieldToBuffer((Integer.parseInt(curLineTokens.nextToken().trim()) - 543) + " ");
						else if(i == 5) addFieldToBuffer(curLineTokens.nextToken().trim().replace(".", ":") + fieldSeparator);
						else if(i == 8) addFieldToBuffer((curLineTokens.nextToken().trim()) + "/");
						else if(i == 9) addFieldToBuffer(InterfaceUtil.getThaiMonthNo(curLineTokens.nextToken().trim()) + "/");
						else if(i == 10) addFieldToBuffer((Integer.parseInt(curLineTokens.nextToken().trim()) - 543) + " ");
						else if(i == 11) addFieldToBuffer(curLineTokens.nextToken().trim().replace(".", ":") + fieldSeparator);
						else if(i == 14) addFieldToBuffer(curLineTokens.nextToken().trim() + fieldSeparator);
						else curLineTokens.nextToken();
						i++;					
					}
				}
				else if(currentLine.startsWith(ACC_DRG_VAL))
				{
					while(i < totTokens)
					{
						if(i == 2) addFieldToBuffer((curLineTokens.nextToken().trim()) + fieldSeparator);					
						else if(i == 4) addFieldToBuffer(curLineTokens.nextToken().trim() + fieldSeparator);
						else if(i == 6) addFieldToBuffer(curLineTokens.nextToken().trim() + fieldSeparator);
						else if(i == 8) addFieldToBuffer(curLineTokens.nextToken().trim().replace(",","") + fieldSeparator);
						else curLineTokens.nextToken();
						i++;					
					}

					for (int j = 0; j < 22; j++)
					{					
						currentLine = sc.nextLine();				

						if(j > 2)
						{
							if(j < 19) addFieldToBuffer((j - 2) + "");
							
							curLineTokens = new StringTokenizer(currentLine, "\t");
							totTokens = curLineTokens.countTokens();
							i = 1;

							while(curLineTokens.hasMoreTokens())
							{									
								if(j < 19 && i > 2)
								{
									String temp = curLineTokens.nextToken().trim().replace(",", "");
									if(!"".equals(temp)) addFieldToBuffer("^" + temp);
								}
								else if(j == 19 && i == 2)
								{
									addFieldToBuffer(curLineTokens.nextToken().trim().replace(",", ""));
								}
								else if(j == 21 && i > 1)
								{
									if(i == 2 || i == 3) addFieldToBuffer(fieldSeparator);								
									addFieldToBuffer(curLineTokens.nextToken().trim().replace(",", ""));
								}
								else curLineTokens.nextToken();
								i++;
							}	
							if(j != 20 && j != 19 && j!= 21) addFieldToBuffer(fieldSeparator);
						}
					}
				}
			}					

			common.fileOutput(logFileName, "(InboundCustomProcess:processACCFiles) Built Message:\n "+hdrSegBuilder.toString()+"\n");

			if(fis != null) fis.close();
			if(sc != null) sc.close();	
			
		//	serverDB.processQueryMessage(hdrSegBuilder.toString());
			processDerivedMsg(hdrSegBuilder.toString());

			moveProcessedFile(new File(fileName));
			fileName = InterfaceUtil.getOldFileInFolder(serverParameters.strFileDirectory, reqFileExt + ".INV");

			if(fileName != null && !fileName.trim().equals("")) moveProcessedFile(new File(fileName));
		}
		if(fis != null) fis.close();
	}

	private void addFieldToBuffer(String fieldValue)
	{
		if(hdrSegBuilder == null) 
		{
			hdrSegBuilder = new StringBuilder();
			hdrSegBuilder.append(msgStart);
		}
		hdrSegBuilder.append(fieldValue);		
	}

	private void processDerivedMsg(String message) throws Exception
	{
		addFieldToBuffer(segmentEnd + msgEnd);
		serverDB.processQueryMessage(message);
	}
}