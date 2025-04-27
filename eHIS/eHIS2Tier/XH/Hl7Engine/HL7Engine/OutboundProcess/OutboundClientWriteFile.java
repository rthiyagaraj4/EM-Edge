/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
*/
package HL7Engine.OutboundProcess ;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import HL7Engine.Common.Common;
import HL7Engine.Common.CommonUtil;
import HL7Engine.Common.EMConstants;
import HL7Engine.Common.InterfaceUtil;
import HL7Engine.exceptions.FatalException;

import com.healthmarketscience.jackcess.Column;
import com.healthmarketscience.jackcess.DataType;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Table;
import com.isoft.interfaceengine.util.BillingConstants;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFWriter;

public class OutboundClientWriteFile
{
	Common common = Common.getInstance();

	String strMessage;
	String strDirName;

	FileOutputStream fileOutputStream;
	
	String strOutFileName = "";
	String strExtension = ".hl7";

	static final String DBF_EXT = ".dbf";
	static final String XLS_EXT = ".xls";
	static final String MDB_EXT = ".mdb";
	static final byte DBF_DATATYPE_CURRENCY = (byte) 'Y';

	ExcelTransactions excelTransactions;

	boolean logToFile;
	boolean isNewMsg = false;
	String strLogFile;
	String strExceptionLogFile;

	String strFileNamingConvention;
	String strFileApi = "";
	String fileHeader;
	String fileFooter;

	String segmentStart;
	String strSegmentEnd;
	String fieldSeparator;
	String lineSeparator = "" + (char)13 + (char)10;

	String strDbfFileType;
	String dbfFileCreationTime = null;
//	String eb1DBFFileFormat = null;
//	String eb4DBFFileFormat = null;
//	String eb8MDBFileFormat = null;
	String ebEventDateFormat = null;
	String ebEventSeqFormat = null;
	HashMap dbfColTypeMap;
	ArrayList<String> mdbColNames;
	ArrayList<String> eventSegmentsList;
	HashMap<String,String> eb2TabNames;
	HashMap<String,String[]> segmentDtlsMap;
	HashMap<String,Database> mdbDBRef;
	HashMap<String,ArrayList<Object[]>> mdbDataRef;
	
	OutboundClientDBInteraction clientDB;

	boolean createNewFile = false;
	boolean replay = false;	
	int maxRetries = 0;
	int retryInterval = 0;	
	
	boolean writeFooterFile = false; //Added by Sethu for ARYU-SCF-0149
 
	public OutboundClientWriteFile()
	{
	}

	public OutboundClientWriteFile(boolean logToFile, String strLogFile, String strExceptionLogFile,String strFileNamingConvention,String strDbfFileType,OutboundClientDBInteraction clientDB)
	{
		this.logToFile = logToFile;
		this.strLogFile = strLogFile;
		this.strExceptionLogFile = strExceptionLogFile;
		this.strFileNamingConvention = strFileNamingConvention;
		this.strDbfFileType = strDbfFileType;
		this.clientDB = clientDB;
		this.maxRetries = clientDB.clientParameters.intMaxRetries;
		this.retryInterval = clientDB.clientParameters.intRetryInterval;		
		
		try
		{
			strSegmentEnd = CommonUtil.formatAsciiToString(clientDB.clientParameters.messageSegmentEnd);
			fieldSeparator = CommonUtil.formatAsciiToString(clientDB.clientParameters.fieldSeparator);

			if(strDbfFileType.equalsIgnoreCase("H")) strExtension = ".hl7";
			if(strDbfFileType.equalsIgnoreCase("T")) strExtension = ".txt";
			if(strDbfFileType.equalsIgnoreCase("X")) strExtension = ".xml";
			if(strDbfFileType.equalsIgnoreCase("F")) strExtension = MDB_EXT;

		}
		catch(Exception exception)
		{
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:Constructor) Exception: "+exception+"\n" );
			common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exception)+"\n" ) ;
		}
	}

	public boolean checkExist(String strD)
	{
		boolean dirExists = false;
		try
		{
			strDirName = strD;
			dirExists = CommonUtil.makeDirectory(strDirName);
			CommonUtil.makeDirectory(strDirName + "/Processing");
		}	
		catch(Exception exception)
		{
			common.fileOutput( strLogFile, "(OutboundClientWriteFile:checkExist) Exception:"+exception+"\n" );			
			dirExists = false;
		}
		return dirExists;
	}

	public  void writeMessage(String strMessage,String strMessageId)
	{						
		// Checking whether message has to written to a new file or not. This flag will be set in OutboundClientApplication - checkCreateInterval().
		if(createNewFile)
		{		
			createNewFile(strMessage);
		}

		try
		{			
			if (!replay)
			{			
				if(strDirName.equals("0"))
				{
					strOutFileName = "/eHIS/";
					CommonUtil.makeDirectory(strOutFileName); // if the directory does not exists create new one.
					strOutFileName = "/eHIS/" + strFileApi + strExtension;
				}
				else
				{
					strOutFileName = strDirName + "/eHIS/";
					CommonUtil.makeDirectory(strOutFileName); // if the directory does not exists create new one.
					strOutFileName = strDirName + "/eHIS/" + strFileApi + strExtension;
				}
			}
			else
			{  
				strOutFileName = strOutFileName + strExtension;
			}
				
	//		common.fileOutput( strOutFileName, strMessage );  // writing to file with appending date,time to the file
			if(createNewFile)
			{
				// Writing header information to the file
				fileHeader = clientDB.getFileControlSrtucture("H");
				if(logToFile) common.fileOutput(strLogFile, "(OutboundClientWriteFile:writeMessage) File: " + strOutFileName + "\n" );
				if(logToFile) common.fileOutput(strLogFile, "(OutboundClientWriteFile:writeMessage) Header: "+ fileHeader + "\n" );

				if(fileHeader != null && !fileHeader.equalsIgnoreCase(""))
				{
					//common.writeToFile(strOutFileName, fileHeader);
					writeToFile(strOutFileName, fileHeader);
				}
			}
			
			//Commented by Sethu for ARYU-SCF-0128
			//common.writeToFile(strOutFileName, "\n");
			//common.writeToFile(strOutFileName, strMessage); // writing to file without appending date,time to the file			
			
			//Added by Sethu for ARYU-SCF-0128			
			writeToFile(strOutFileName, "\n");
			writeToFile(strOutFileName, strMessage); 
			
			String fileCreationInterval = clientDB.clientParameters.strCreateFileInterval;

			if(fileCreationInterval == null || fileCreationInterval.equals("0000"))
			{
				writeFooter();			
			}			
			
			if( logToFile ) common.fileOutput( strLogFile, "(OutboundClientWriteFile:writeMessage) Writing to file:"+strOutFileName+"\n" );
	/*		fileOutputStream = new FileOutputStream(strOutFileName,true);
			fileOutputStream.write(strMessage.getBytes());
			fileOutputStream.close();	
	*/	}
		catch(Exception exception)
		{
			common.fileOutput( strLogFile, "(OutboundClientWriteFile:writeMessage)Exception:"+exception+"\n" );
			common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exception) + "\n");
		}
	}

	/**
	 * Method moves current file to the parent folder after appending footer info to EOF
	 */
	public void writeFooter()
	{
		if(strOutFileName != null && !strOutFileName.equalsIgnoreCase(""))
		{
			fileFooter = clientDB.getFileControlSrtucture("F");
			if( logToFile ) common.fileOutput( strLogFile, "(OutboundClientWriteFile:writeMessage) File:"+strOutFileName+"\n" );
			if( logToFile ) common.fileOutput( strLogFile, "(OutboundClientWriteFile:writeMessage) Footer:"+fileFooter+"\n" );

			if(fileFooter != null && !fileFooter.equalsIgnoreCase(""))
			{
				//common.writeToFile( strOutFileName, fileFooter);
				writeToFile(strOutFileName, fileFooter);
			}
			
			//Moving old file to interface directory (parent directory of eHIS) before writing to new File.
			File tempOutFile = new File(strOutFileName);
			tempOutFile.renameTo(new File(new File(tempOutFile.getParent()).getParent(), tempOutFile.getName()));
			
			writeFooterFile = true; // Added by Sethu for ARYU-SCF-0149
		}
	}

	/**
	 * Method moves the current file to the parent directory by appending the footer info to the EOF.
	 * New file name will be generated based on fileCreationInterval.
	 * fileCreationInterval - 0000, indicates new file to be created for each message,
	 * other wise new file will be created based on the interval.
	 */
	private void createNewFile(String strMessage)
	{
		int retries = 0;									

		common.fileOutput( strLogFile, "(OutboundClientWriteFile:createNewFile) Creating new file....\n" );

		while(true)
		{
			String fileCreationInterval = clientDB.clientParameters.strCreateFileInterval;
			
			/*	
		  	if("SRREBLP2".equalsIgnoreCase(clientDB.clientParameters.strProtocolId))
			{
				
			}
			else 
		 	*/	
			if(fileCreationInterval != null && !fileCreationInterval.equals("0000"))
			{
				//writeFooter(); // Commented by Sethu 04/09
				strFileApi = clientDB.fileNamingConvention(strFileNamingConvention, strMessage);	
			}
			else
			{
				strFileApi = clientDB.strSentEventType + "-" + clientDB.strSentMessageId;
			}
			
			if(strFileApi != null && !strFileApi.equals(""))
			{
				break;
			}
			if(retries >= maxRetries)
			{
				common.fileOutput( strLogFile, "(OutboundClientWriteFile:writeMessage) Maximum retires reached "+ retries +"\n");
				System.exit(0);
			}
			try
			{
			//	common.fileOutput( strLogFile, "(OutboundClientWriteFile:writeMessage) FileNamingAPI NULL \n"); 
				retries++;
				Thread.sleep(retryInterval);
			}
			catch(Exception exception)
			{
				common.fileOutput( strLogFile, "(OutboundClientWriteFile:writeMessage-Sleep)Exception:"+exception+"\n" );
			}
		}
	}

	/**
	 * Method writes the message passed in to the given file name.
	 * If the file does not exist, new file will be created.
	 */
	public void writeBillingMessage(String message)
	{
		String fileExt = ".txt";
		try
		{
			StringTokenizer segmentTokens = new StringTokenizer(message, lineSeparator);
			if(eb2TabNames == null || eb2TabNames.size() <= 0)
			{
				eb2TabNames = clientDB.dbfGenParamTabDtls("EB2");
			}
			
			if(eb2TabNames == null || eb2TabNames.size() <= 0)
			{
				common.fileOutput(strLogFile, "(OutboundClientWriteFile:writeBillingMessage) Filenames not defined !!!\n" );
			}
			else
			{
				while(segmentTokens.hasMoreTokens())
				{
					String currSegment = segmentTokens.nextToken();
					String segmentName = null;
					if(currSegment.length() > 3) 
					{
						segmentName = currSegment.substring(0,3);						
	
						FileOutputStream outStream = null;
						Writer outWriter = null;
		
					//	common.fileOutput(strLogFile, "(OutboundClientWriteFile:writeBillingMessage) currSegment: "+currSegment+"\n" );
					//	common.fileOutput(strLogFile, "(OutboundClientWriteFile:writeBillingMessage) segmentName: "+segmentName+"\n" );

						String fileName = eb2TabNames.get(segmentName);
						
						if(fileName != null && !fileName.equals(""))
						{
							fileName += fileExt;
							File eb2File = new File(strDirName + fileName);
							writeBillingHeader(eb2File, eb2TabNames.get(segmentName + "_Header"));
							outStream = new FileOutputStream(strDirName + fileName, true);
							
							if(outStream != null)
							{
								outWriter = new OutputStreamWriter(outStream, "UTF8");
								outWriter.write(currSegment.substring(currSegment.indexOf(fieldSeparator) + 1) + "\n");
								if(outWriter != null) outWriter.close();
								if(outStream != null) outStream.close();
							}
						}
						else
						{
							common.fileOutput(strLogFile, "(OutboundClientWriteFile:writeBillingMessage) Filename not found for "+segmentName+" !!!\n" );
						}
					}
				}
			}
		}
		catch(Exception exp)
		{
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:writeBillingMessage) "+exp+"\n" );
			common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
		finally
		{			
		}
	}
	
	private void writeBillingHeader(File eb2File, String header) throws Exception
	{
		FileOutputStream outStream = null;
		Writer outWriter = null;
		
		try
		{
			if(!eb2File.exists())
			{
				outStream = new FileOutputStream(eb2File, true);
				
				if(outStream != null)
				{
					outWriter = new OutputStreamWriter(outStream, "UTF8");
					outWriter.write(header + "\n");					
				}
			}
		}
		catch(Exception exp)
		{
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:writeBillingHeader) "+exp+"\n" );
			common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
		finally
		{
			if(outWriter != null) outWriter.close();
			if(outStream != null) outStream.close();
		}
	}

	/**
	 * Method formats the message and writes to respective dbf file
	 */
	public void processMessage(String message, String eventType) throws Exception
	{
		try
		{	
			String fileName = null;
			String tempExt = ".dbf";
			isNewMsg = true;
			boolean isFileExists = false;

			StringTokenizer segmentTokens = new StringTokenizer(message, lineSeparator);

			if(!"EB4".equals(eventType))
			{
				ebEventDateFormat = 
					((Integer.parseInt(CommonUtil.getFormattedStringDate("yyyy", new java.util.Date())) + 543) 
						+ "").substring(2,4) 
						+ CommonUtil.getFormattedStringDate("MM", new java.util.Date());
			}

			if(eventType == null || eventType.equals("")) eventType = BillingConstants.getBillingEvent(clientDB.clientParameters.strProtocolId);

			if(!"E11".equals(eventType)) checkFileExists(eventType);			

			while(segmentTokens.hasMoreTokens())
			{
				String currSegment = segmentTokens.nextToken();
				int fieldSepIndex = currSegment.indexOf(fieldSeparator);

				if(fieldSepIndex <= 2) 
				{
					continue; // Indicates null segment
				}

				String segmentName = currSegment.substring(0, fieldSepIndex);
			//	String [] segmentDtls = clientDB.getDBFSegmentDtls(segmentName, eventType);
				String [] segmentDtls = getSegmentDtls(segmentName, eventType);

				if(clientDB.clientParameters.boolDBDown)
				{
					common.fileOutput(strLogFile, 
						"(OutboundClientWriteFile:processMessage) Problem in accessing database !!!\n" ) ;
					break;
				}

				if(segmentDtls == null || segmentDtls[0] == null || segmentDtls[0].equals(""))
				{
					common.fileOutput(strLogFile, 
						"(OutboundClientWriteFile:processMessage) Filename not found for "+ segmentName +" segment in "+ eventType +" event\n" ) ;
					continue;
				}
				else if(segmentDtls[1] == null || segmentDtls[1].equals(""))
				{
					common.fileOutput(strLogFile, 
						"(OutboundClientWriteFile:processMessage) Column name delimiter does not exist for "+ segmentName +" segment in "+ eventType +" event\n " ) ;
					continue;
				}

				if("INV".equals(segmentName)) tempExt = XLS_EXT;
				else if("EB8".equals(eventType) || "E11".equals(eventType)) tempExt = MDB_EXT;
				else tempExt = DBF_EXT;

				if("EB8".equals(eventType) || "E11".equals(eventType))
				{
					fileName = segmentDtls[0] + ebEventDateFormat + tempExt;
					int separatorIndex = fileName.indexOf("/");					
					String tempFilename = fileName.substring(separatorIndex + 1);
					File file = new File(strDirName + "/Processing/" + tempFilename);

					if(!file.exists())
					{
						fileName = segmentDtls[0] + ebEventDateFormat + tempExt;
						createHeader(segmentName, fileName, segmentDtls[1], eventType, tempExt);
					}
					else isFileExists = true;
				}
				else if("EB4".equals(eventType))
				{
					File file = new File(strDirName);
					File [] fileList = file.listFiles();

					int len = fileList.length;
					boolean fileExists = false;

					for (int i = 0; i < len; i++)
					{
						String fName = fileList[i].getName();
						if(fName.startsWith(segmentDtls[0]))
						{
							common.fileOutput(strLogFile, "(OutboundClientWriteFile:processDBFMessage) File Exists...\n " ) ;
							fileExists = true;
							fileName = fName;
							break;
						}
					}
				}
				else if("EB6".equals(eventType))
				{					
					fileName = segmentDtls[0] + tempExt;
				}				
				else
				{					
					fileName = segmentDtls[0] + ebEventDateFormat + tempExt;
				}
				
				if((mdbColNames == null || dbfColTypeMap == null))
				{					
					getColHdrList(eventType, segmentName, segmentDtls[1]);
				}
		
				if("INV".equals(segmentName)) {
					ArrayList record = (ArrayList) CommonUtil.eHISStringTokenizer(currSegment, fieldSeparator);
					ArrayList records = new ArrayList();
					records.add(record);
					if(excelTransactions == null) excelTransactions = new ExcelTransactions(clientDB);
					excelTransactions.appendRows(strDirName + "/" + fileName, records);
				}
				else if("F".equals(strDbfFileType)) {
					write2DBF(currSegment, fileName, eventType);
				}
				else if("M".equals(strDbfFileType)) {
					write2MDB(currSegment, fileName, eventType);
				}

			/*	if("EB4".equals(eventType))
				{
					clientDB.updateBillingTab(eventType, ebEventSeqFormat);
				}
				else
				{
					clientDB.updateBillingTab(eventType, "");
				}*/
			}
			
			if("M".equals(strDbfFileType)) {
				flushMDBData();
			}			
		}
		catch(FatalException exp)
		{
			throw new FatalException(exp.getMessage());
		}
		catch(Exception exp)
		{
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:processMessage) Exception: "+exp.getMessage()+"\n" );
			common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
	}	

	private void flushMDBData() throws Exception
	{
		for(String key:mdbDataRef.keySet())
		{
			ArrayList<Object[]> dataList = null;
			try
			{
				dataList = mdbDataRef.get(key);
				Database db = mdbDBRef.get(key);
				for(String tableName : db.getTableNames())
				{
					db.getTable(tableName).addRows(dataList);
				//	db.flush();					
				}				
			}
			catch(Exception exp)
			{
				common.fileOutput(strLogFile, "(OutboundClientWriteFile:flushMDBData) Exception : "+ exp +"\n" );
				common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
				common.fileOutput(strLogFile, "(OutboundClientWriteFile:flushMDBData) Deleting files from processing folder !!!\n" );
				closeResources();
				CommonUtil.deleteFiles(new File(strDirName + "/Processing/"));
				throw new FatalException(exp.getMessage());
			}
			finally
			{
				dataList.clear();
			}
		}
	}

	/**
	 * Method creates MDB column settings by fetching the delimited mdb field structure from XB_DBF_GEN_PARAM
	 */
	void createMDBHeader(String segmentName, String fileName, String delimitMDBStruct, String eventType) throws Exception
	{
		try
		{
			int separatorIndex = fileName.indexOf("/");
			String tableName = fileName.substring(0, separatorIndex);
			fileName = fileName.substring(separatorIndex + 1);
			
			Database db = Database.create(new File(strDirName + "/Processing/" + fileName));
			Column mdbCol = null;
			List<Column> mdbColList = new ArrayList<Column>();
			mdbColNames = new ArrayList<String>();

			StringTokenizer fields = new StringTokenizer(delimitMDBStruct, "|");
			int totFields = fields.countTokens();
			
			if(dbfColTypeMap == null) dbfColTypeMap = new HashMap();
			if(mdbDBRef == null) mdbDBRef = new HashMap<String,Database>();
			ArrayList dataTypeList = new ArrayList(totFields);

			for (int i = 0; i < totFields; i++)
			{
				/** 
				 * Individual field token should in the following format
				 * MDBColumnName DataType ColumnLength
				 */				
				StringTokenizer fieldDtls = new StringTokenizer(fields.nextToken(), " ");

				String colName = fieldDtls.nextToken(); // First token = Column name
				String dataType = fieldDtls.nextToken(); // Second token = data type 
				int len = Integer.parseInt(fieldDtls.nextToken()); // Third token = length				

				mdbCol = new Column();

				mdbColNames.add(colName);
				mdbCol.setName(colName);				

				dataTypeList.add(dataType);
				mdbCol.setType(getMDBDataType(dataType));
				if(dataType.equals("C")) 
				{
					len += len;
					mdbCol.setLength((short)len);
				}
				else if(dataType.equals("A")) 
				{
					mdbCol.setAutoNumber(true);
				}
				
				mdbColList.add(mdbCol);
			}

			db.createTable(tableName, mdbColList);
			db.flush();
			db.close();
			Database dbase = Database.open(new File(strDirName + "/Processing/" + fileName));
			mdbDBRef.put(fileName, dbase);
		//	mdbDBRef.put(fileName+tableName, dbase.getTable(tableName));
			if(mdbDataRef == null)
			{
				mdbDataRef = new HashMap<String,ArrayList<Object[]>>();
			}
			mdbDataRef.put(fileName, new ArrayList<Object[]>());
			
			dbfColTypeMap.put((eventType + segmentName), dataTypeList);			
			dbfColTypeMap.put((eventType + segmentName) + "_Colnames", mdbColNames);			
		}
		catch(Exception exp)
		{
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:createMDBHeader) " + exp.getMessage() + "\n " ) ;
			common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
			throw new FatalException(exp.getMessage());
		}
	}

	private byte getDBFDataType(String dataType)
	{
		byte dataTypeVal = DBFField.FIELD_TYPE_C;

		if("C".equalsIgnoreCase(dataType)) dataTypeVal = DBFField.FIELD_TYPE_C;
		else if("D".equalsIgnoreCase(dataType)) dataTypeVal = DBFField.FIELD_TYPE_D;
		else if("N".equalsIgnoreCase(dataType)) dataTypeVal = DBFField.FIELD_TYPE_N;
		else if("M".equalsIgnoreCase(dataType)) dataTypeVal = DBFField.FIELD_TYPE_M;
		else if("F".equalsIgnoreCase(dataType)) dataTypeVal = DBFField.FIELD_TYPE_F;
		else if("Y".equalsIgnoreCase(dataType)) dataTypeVal = DBF_DATATYPE_CURRENCY;

		return dataTypeVal;
	}
	
	private DataType getMDBDataType(String strDataType)
	{
		DataType dataType = DataType.TEXT;
		
		if("C".equalsIgnoreCase(strDataType)) dataType = DataType.TEXT;
		else if("D".equalsIgnoreCase(strDataType)) dataType = DataType.SHORT_DATE_TIME;
		else if("N".equalsIgnoreCase(strDataType)) dataType = DataType.NUMERIC;				
		else if("B".equalsIgnoreCase(strDataType)) dataType = DataType.BOOLEAN;
		else if("W".equalsIgnoreCase(strDataType) || "A".equalsIgnoreCase(strDataType)) dataType = DataType.LONG;
		else if("X".equalsIgnoreCase(strDataType)) dataType = DataType.BYTE;
		else if("Y".equalsIgnoreCase(strDataType)) dataType = DataType.MONEY;
		
		return dataType;
	}

	/**
	 * Method formats the segment based on field separator and writes the data in to individual MDB fields
	 */
	void write2MDB(String segment, String fileName, String eventType) throws Exception
	{
		try
		{
			int separatorIndex = fileName.indexOf("/");
			String tableName = fileName.substring(0, separatorIndex);
			fileName = fileName.substring(separatorIndex + 1);
			
			ArrayList<String> record = (ArrayList<String>) CommonUtil.eHISStringTokenizer(segment, fieldSeparator);			
			ArrayList temp = (ArrayList) dbfColTypeMap.get((eventType + record.get(0)));
			mdbColNames = (ArrayList) dbfColTypeMap.get((eventType + record.get(0) + "_Colnames"));			
		//	ArrayList fieldList = (ArrayList) dbfColTypeMap.get((eventType + (String)record.get(0)));

			int totFields = record.size();
		//	Database db = Database.open(new File(strDirName + "/Processing/" + fileName));
			Database db = mdbDBRef.get(fileName);
			Map<String,Object> map = new HashMap<String,Object>();
			
			// one less than total fields as first element will be segment name
			for (int i = 1; i < totFields; i++)
			{
				if("D".equals(temp.get(i-1))) map.put(mdbColNames.get(i-1), CommonUtil.convertToDate(record.get(i), EMConstants.EBILLING_EB8_DATE_FORMAT));
				else if("B".equals(temp.get(i-1))) map.put(mdbColNames.get(i-1), Boolean.valueOf(record.get(i)));
				else if(!"A".equals(temp.get(i-1))) map.put(mdbColNames.get(i-1), CommonUtil.checkEmptyStr(record.get(i)));
			}
			
			Table table = db.getTable(tableName);
			Object[] obj = table.asRow(map);
			((ArrayList<Object[]>)mdbDataRef.get(fileName)).add(obj);
		//	db.flush();
		//	db.close();
		}
		catch(Exception exp)
		{
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:write2MDB) " + exp + "\n");
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:write2MDB) Processing Segment: " + segment + "\n");
			common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
	}
	
	private void createHeader(String segmentName, String fileName, String delimitStruct, String eventType, String fileExt) throws Exception
	{
	//	clientDB.insertProcessedFilename(fileName);		

		if(DBF_EXT.equalsIgnoreCase(fileExt)) 
		{
			createDBFHeader(segmentName, fileName, delimitStruct, eventType);
		}
		else if(MDB_EXT.equalsIgnoreCase(fileExt)) 
		{
			createMDBHeader(segmentName, fileName, delimitStruct, eventType);
		}
		else if(XLS_EXT.equalsIgnoreCase(fileExt)) 
		{
			ArrayList hdrList = (ArrayList) CommonUtil.eHISStringTokenizer(delimitStruct, "|");

			excelTransactions = new ExcelTransactions(clientDB);
			excelTransactions.createHeader(strDirName + "/" + fileName, hdrList);
		}

		storeBillingFilename(eventType, fileName);
	}

	void getColHdrList(String eventType, String segmentName, String delimitMDBStruct)
	{
		String currentField = "";
		try
		{
			StringTokenizer fields = new StringTokenizer(delimitMDBStruct, "|");
			int totFields = fields.countTokens();
			
			if(dbfColTypeMap == null) dbfColTypeMap = new HashMap();
			if(mdbColNames == null) mdbColNames = new ArrayList<String>();

			ArrayList dataTypeList = new ArrayList(totFields);
			
			for (int i = 0; i < totFields; i++)
			{
				currentField = fields.nextToken();
				StringTokenizer fieldDtls = new StringTokenizer(currentField, " ");

				String colName = fieldDtls.nextToken(); // First token = Column name
				String dataType = fieldDtls.nextToken(); // Second token = data type
				
				if("Z".equals(dataType)) dataType = "C";

				mdbColNames.add(colName);
				dataTypeList.add(dataType);
			}

			dbfColTypeMap.put((eventType + segmentName), dataTypeList);
		}
		catch (Exception exp)
		{
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:getColHdrList) Error processing "+currentField+" for " + segmentName + " Segment!!!\n");
			common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
	}

	private void storeBillingFilename(String eventType, String fileName)
	{
		try
		{
			File dirFile = new File(strDirName);
			File [] dirFileList = dirFile.listFiles();
			Date temp = null;

			Date today = new Date();

			int fileCount = dirFileList.length;
			boolean incrementFileCount = false;
			
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:storeBillingFilename) Filename " + fileName + "\n");
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:storeBillingFilename) isNewMsg " + isNewMsg + "\n");
			
			for (int i = 0; i < fileCount; i++)
			{
			    temp = new Date(dirFileList[i].lastModified());
			    if(CommonUtil.getFormattedStringDate("ddMMyyyy", today).equals(CommonUtil.getFormattedStringDate("ddMMyyyy", temp)))
			    { 	
					if(!dirFileList[i].getName().equalsIgnoreCase(fileName)) continue;
					isNewMsg = false;
					break;
			    }
			}

		//	if(fileCount == 0) incrementFileCount = true;			
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:storeBillingFilename) incrementFileCount " + incrementFileCount + "\n");

			if(isNewMsg && !incrementFileCount) 
			{
				if(ebEventSeqFormat != null && !ebEventSeqFormat.equals(""))
				{
				    clientDB.storeBillingFilename(eventType, ebEventSeqFormat);
				}

				/*String protocolID = clientDB.clientParameters.strProtocolId;

				if("SRREBLP4".equalsIgnoreCase(protocolID))
				{					
					clientDB.updateBillingTab(eventType, ebEventSeqFormat);
				}*/

				isNewMsg = false;
			}
		}
		catch (Exception exp)
		{
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:storeBillingFilename) " + exp + "\n");
			common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
	}

	private void checkFileExists(String eventType)
	{
		String tempSegment = null;
		try
		{
			int segmentListSize = 0;

			if(eventSegmentsList == null || eventSegmentsList.size() == 0)
			{
				eventSegmentsList = clientDB.getEventSegmentList(eventType);
			}						

			segmentListSize = eventSegmentsList.size();

			if(segmentListSize < 1) common.fileOutput(strLogFile, "(OutboundClientWriteFile:checkFileExists) No segments defined for "+eventType+" event !!!\n");

			for (int i = 0; i < segmentListSize; i++)
			{
				tempSegment = eventSegmentsList.get(i);
				getEBillingFileName(eventType, tempSegment);	
			}
		}
		catch (Exception exp)
		{
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:checkFileExists) " + exp + " Segment " + tempSegment +"\n");
			common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
	}

	private void getEBillingFileName(String eventType, String segmentName)
	{
		String fileName = null;
		String fileExt = ".dbf";
		boolean isFileExists = false;

		try
		{			
			if("INV".equals(segmentName)) fileExt = ".xls";

			if(!"EB4".equalsIgnoreCase(eventType))
			{
				ebEventDateFormat = 
					((Integer.parseInt(CommonUtil.getFormattedStringDate("yyyy", new java.util.Date())) + 543) 
						+ "").substring(2,4) 
						+ CommonUtil.getFormattedStringDate("MM", new java.util.Date());
			}

			String [] segmentDtls = clientDB.getDBFSegmentDtls(segmentName, eventType);

			if(segmentDtls == null || segmentDtls[0] == null || segmentDtls[0].equals(""))
			{
				common.fileOutput(strLogFile, 
					"(OutboundClientWriteFile:getEBillingFileName) Filename not found for "+ segmentName +" segment in "+ eventType +" event\n" ) ;
			}
			else if(segmentDtls[1] == null || segmentDtls[1].equals(""))
			{
				common.fileOutput(strLogFile, 
					"(OutboundClientWriteFile:getEBillingFileName) Column name delimiter does not exist for "+ segmentName +" segment in "+ eventType +" event\n " ) ;
			}
			else
			{
				if ("EB1".equalsIgnoreCase(eventType)
						|| "E15".equalsIgnoreCase(eventType)
						|| "E15O".equalsIgnoreCase(eventType)
						|| "E16".equalsIgnoreCase(eventType)
						|| "E17".equalsIgnoreCase(eventType)
						|| "E18".equalsIgnoreCase(eventType)
						|| "E19".equalsIgnoreCase(eventType)
						|| "E20".equalsIgnoreCase(eventType))
				{					
					fileName = segmentDtls[0] + ebEventDateFormat + fileExt;					

					File file = new File(strDirName + "/" + fileName);

					if(!file.exists())
					{						
						createHeader(segmentName, fileName, segmentDtls[1], eventType, fileExt);
					}
					else isFileExists = true;
				}
				else if("EB5".equalsIgnoreCase(eventType) || "EB9".equalsIgnoreCase(eventType)
						|| "E12".equalsIgnoreCase(eventType) || "E13".equalsIgnoreCase(eventType) || "E14".equalsIgnoreCase(eventType))
				{
					fileName = segmentDtls[0] + ebEventDateFormat + fileExt;
					File file = new File(strDirName + "/" + fileName);

					if(!file.exists())
					{
						createHeader(segmentName, fileName, segmentDtls[1], eventType, fileExt);
					}
					else isFileExists = true;
				}
				else if("EB4".equalsIgnoreCase(eventType))
				{
				//	fileName = segmentDtls[0] + ebEventSeqFormat + tempExt;
					File file = new File(strDirName);
					File [] fileList = file.listFiles();

					int len = fileList.length;
					boolean fileExists = false;

					for (int i = 0; i < len; i++)
					{
						String fName = fileList[i].getName();
						if(fName.startsWith(segmentDtls[0]))
						{
							common.fileOutput(strLogFile, "(OutboundClientWriteFile:getEBillingFileName) File Exists...\n " ) ;
							fileExists = true;
							fileName = fName;
							break;
						}
					}

					if(!fileExists)
					{
						if(ebEventSeqFormat == null) 
						{
							ebEventSeqFormat = clientDB.executeSeq("XB_UC_IP_SEQ");
							int tempLen = ebEventSeqFormat.length();
							if(tempLen < 4)
							{
								for (int i = 4; i != tempLen; i--)
								{
									ebEventSeqFormat = "0" + ebEventSeqFormat;
								}
							}
						}

						fileName = segmentDtls[0] + ebEventSeqFormat + fileExt;
						createHeader(segmentName, fileName, segmentDtls[1], eventType, fileExt);
					}
					else isFileExists = true;
				}
				else if("EB6".equalsIgnoreCase(eventType))
				{					
					fileName = segmentDtls[0] + fileExt;

					File file = new File(strDirName + "/" + fileName);

					if(!file.exists())
					{						
						createHeader(segmentName, fileName, segmentDtls[1], eventType, fileExt);
					}
					else isFileExists = true;
				}
			}

			if((dbfColTypeMap == null) || isFileExists)	getColHdrList(eventType, segmentName, segmentDtls[1]);
		}
		catch (Exception exp)
		{
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:getEBillingFileName) " + exp + "\n");
			common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
	}

	void createDBFHeader(String segmentName, String fileName, String delimitDBFStruct, String eventType)
	{
		try
		{
			String columnDtls = "";
			StringTokenizer fields = new StringTokenizer(delimitDBFStruct, "|");
			int totFields = fields.countTokens();

			if(dbfColTypeMap == null) dbfColTypeMap = new HashMap();
			ArrayList dataTypeList = new ArrayList(totFields);

			for (int i = 0; i < totFields; i++)
			{
				/** 
				 * Individual field token should in the following format
				 * DBFColumnName DataType ColumnLength
				 */				
				StringTokenizer fieldDtls = new StringTokenizer(fields.nextToken(), " ");

				if(i != 0) columnDtls += ",";

				columnDtls += "\"" + fieldDtls.nextToken().trim() + "\"" + "@@"; // First token = Column name
				String dataType = fieldDtls.nextToken().trim(); // Second token = data type
				if("Z".equals(dataType)) 
				{
					dataType = "C";
					columnDtls += dataType + "@@(" + fieldDtls.nextToken().trim() + ")"; // Third token = Field length
					columnDtls += "@@NOCPTRANS"; // indicates character(binary) data type
				}
				else
				{
					columnDtls += dataType + "@@(" + fieldDtls.nextToken().trim() + ")"; // Third token = Field length
				}

				dataTypeList.add(dataType);				
			}
			
			dbfColTypeMap.put((eventType + segmentName), dataTypeList);

			String exeParam = getDBFExeFile() + " C " + strDirName.trim() + " " + fileName.trim() + " " + columnDtls + " Y Y";

			callExe(exeParam);
		//	Thread.sleep(1000);
		}
		catch(Exception exp)
		{
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:createDBFHeader) " + exp.getMessage() + "\n " ) ;
			common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");  
		}
	}

	void write2DBF(String segment, String fileName, String eventType)
	{
		String fieldType = null;
		try
		{
			ArrayList record = (ArrayList) CommonUtil.eHISStringTokenizer(segment, fieldSeparator);
			ArrayList fieldList = (ArrayList) dbfColTypeMap.get((eventType + (String)record.get(0)));

			int totFields = record.size();
			String dataFields = "";

			for (int i = 1; i < totFields; i++)
			{				
				fieldType = (String)fieldList.get(i-1);							

				if(i != 1) dataFields += ",";

				String tempData = (String)record.get(i);

				if("C".equals(fieldType))
				{
					tempData = tempData.replaceAll(" ", "@@");
					dataFields += "'" + CommonUtil.checkNull(tempData) + "'";
				}
				else if("D".equals(fieldType))
				{					
					if(tempData != null && !(tempData.trim().equals("")))
					{						
						dataFields += "{" 
								+ CommonUtil.convertDateFormat(tempData, "dd/MM/yyyy", "yyyy/MM/dd")
								+ "}";
					}
					else
					{
						dataFields += "{}";
					}
				}
				else if("T".equals(fieldType))
				{					
					if(tempData != null && !(tempData.trim().equals("")))
					{
						if(tempData.length() == 10) tempData += " 00:00:00";
						dataFields += "{" 
								+ CommonUtil.convertDateFormat(tempData, "dd/MM/yyyy HH:mm:ss", "yyyy/MM/dd@@HH:mm:ss")
								+ "}";
					}
					else
					{
						dataFields += "{}";
					}
				}
				else dataFields += CommonUtil.checkNumber((String)record.get(i));
			}

			String dbfLog = CommonUtil.getPropertyVal(InterfaceUtil.getiniFilePath("CONFIG"), "DBF_LOG");
			String exeParam = getDBFExeFile() + " W " + strDirName.trim() + " " + fileName.trim() + " Y " + dataFields + " " + dbfLog;
			callExe(exeParam);

		//	if("Y".equals(dbfLog)) Thread.sleep(500);
		//	else  Thread.sleep(50);
		}
		catch(Exception exp)
		{
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:write2DBF) Processing filename: " + fileName + "\n" ) ;
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:write2DBF) " + exp + "\n" ) ;
			common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");  
		}
	}

	void write2DBFJava(String segment, String fileName, String eventType)
	{
		String fieldType = null;
		String tempData = null;
		try
		{
			ArrayList record = (ArrayList) CommonUtil.eHISStringTokenizer(segment, fieldSeparator);
			ArrayList fieldList = (ArrayList) dbfColTypeMap.get((eventType + (String)record.get(0)));

			int totFields = record.size();
			Object dbfRecord[] = new Object[totFields]; // one lessthan total fields as first element will be segment name

			for (int i = 1; i < totFields; i++)
			{
				fieldType = (String)fieldList.get(i-1);
				tempData = (String)record.get(i);

				if("C".equals(fieldType) || "Y".equals(fieldType))
				{
					dbfRecord[i-1] = tempData;
				}
				else if("N".equals(fieldType))
				{
					dbfRecord[i-1] = CommonUtil.checkDouble(tempData) ;
				}
				else if("D".equals(fieldType))
				{
					if(tempData != null && !(tempData.trim().equals("")))
					{
						dbfRecord[i-1] = CommonUtil.convertToDate(tempData, "dd/MM/yyyy");
					}
					else
					{
						dbfRecord[i-1] = "";
					}
				}
				else dbfRecord[i-1] = tempData;

			}
		//	dbfRecord[totFields - 1] = "";
			
			DBFWriter dbfWriter = new DBFWriter(new File(strDirName + "/" + fileName));

			dbfWriter.setCharactersetName("MS874");
			dbfWriter.addRecord(dbfRecord);

			dbfWriter.write();
		}
		catch(Exception exp)
		{
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:write2DBF) Processing filename: " + fileName + "\n" ) ;
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:write2DBF) " + exp + "\n" ) ;
			common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");  
		}
	}

	/**
	 * Method formats the segment based on field separator and writes the data in to individual DBF fields
	 */
/*	void write2DBF(String segment, String fileName)
	{
		try
		{
			ArrayList fields = (ArrayList) CommonUtil.eHISStringTokenizer(segment, fieldSeparator);
			int totFields = fields.size();
			String s[] = new String[totFields - 1]; // one lessthan total fields as first element will be segment name

			for (int i = 1; i < totFields; i++)
			{
				s[i-1] = (String)fields.get(i);
			}

			DBFWriter dbfWriter = new DBFWriter(new File(strDirName + "/" + fileName));

			dbfWriter.setCharactersetName("UTF8");
			dbfWriter.addRecord(s);

			dbfWriter.write();
		}
		catch(Exception exp)
		{
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:write2DBF) " + exp + "\n " ) ;
			common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");  
		}
	}
*/
	/**
	 * Method formats the segment based on field separator and writes the data in to individual DBF fields
	 */
/*	void write2DBF(String segment, String fileName, String eventType)
	{
		String fieldType = null;
		try
		{
			ArrayList record = (ArrayList) CommonUtil.eHISStringTokenizer(segment, fieldSeparator);
			ArrayList fieldList = (ArrayList) dbfColTypeMap.get((eventType + (String)record.get(0)));

			int totFields = record.size();
			Object dbfRecord[] = new Object[totFields - 1]; // one lessthan total fields as first element will be segment name

			for (int i = 1; i < totFields; i++)
			{
				fieldType = (String)fieldList.get(i-1);

				if("C".equals(fieldType) || "Y".equals(fieldType))
				{
					dbfRecord[i-1] = (String)record.get(i);
				}
				else if("N".equals(fieldType))
				{
					dbfRecord[i-1] = CommonUtil.checkDouble((String)record.get(i)) ;
				}
				else if("D".equals(fieldType))
				{
					dbfRecord[i-1] = CommonUtil.convertToDate((String)record.get(i), "dd/MM/yyyy");
				}
			}
			
			DBFWriter dbfWriter = new DBFWriter(new File(strDirName + "/" + fileName));

			dbfWriter.setCharactersetName("MS874");
			dbfWriter.addRecord(dbfRecord);

			dbfWriter.write();
		}
		catch(Exception exp)
		{
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:write2DBF) Processing filename: " + fileName + "\n" ) ;
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:write2DBF) " + exp + "\n" ) ;
			common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");  
		}
	}
*/
	/**
	 * Method creates DBF field settings by fetching the delimited dbf field structure from XB_DBF_GEN_PARAM
	 */
/*	void createDBFHeader(String segmentName, String fileName, String delimitDBFStruct, String eventType)
	{
		try
		{			
		//	String delimitDBFStruct = clientDB.getDBFStruct(segmentName);			
			
			StringTokenizer fields = new StringTokenizer(delimitDBFStruct, "|");
			int totFields = fields.countTokens();

			DBFField[] dbfField = new DBFField[totFields];
			if(dbfColTypeMap == null) dbfColTypeMap = new HashMap();
			ArrayList dataTypeList = new ArrayList(totFields);

			for (int i = 0; i < totFields; i++)
			{
				/** 
				 * Individual field token should in the following format
				 * DBFColumnName DataType ColumnLength
				 *
				StringTokenizer fieldDtls = new StringTokenizer(fields.nextToken(), " ");
				dbfField[i] = new DBFField();

				dbfField[i].setName(fieldDtls.nextToken()); // First token = Column name
				String dataType = fieldDtls.nextToken(); // Second token = data type 				

				dataTypeList.add(dataType);
				dbfField[i].setDataType(getDBFDataType(dataType));				

				if(!"D".equals(dataType)) dbfField[i].setFieldLength(Integer.parseInt(fieldDtls.nextToken()));
			}

			DBFWriter dbfWriter = new DBFWriter(new File(strDirName + "/" + fileName));
			
			dbfWriter.setFields(dbfField);
			dbfWriter.write();
			dbfColTypeMap.put((eventType + segmentName), dataTypeList);
		}
		catch(Exception exp)
		{
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:createDBFHeader) " + exp.getMessage() + "\n " ) ;
			common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");  
		}
	}
*/

	private String callExe(String exeParam)
	{
		try
		{
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:callExe) Executing " + exeParam + "\n " ) ;
			Runtime runtime = Runtime.getRuntime();		
			runtime.exec(exeParam).waitFor();			
			//String CommonUtil.getConsoleMessage(process);
		}
		catch (Exception exp)
		{
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:callExe) " + exp.getMessage() + "\n " ) ;
			common.fileOutput(strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n"); 
		}
		return null;
	}
	
	public void createBillingFiles() throws Exception
	{
		if(eb2TabNames == null || eb2TabNames.size() <= 0)
		{
			eb2TabNames = clientDB.dbfGenParamTabDtls("EB2");
		}			
		
		if(eb2TabNames == null || eb2TabNames.size() <= 0)
		{
			common.fileOutput(strLogFile, "(OutboundClientWriteFile:writeBillingMessage) Filenames not defined !!!\n" );
		}
		else
		{			
			Iterator<String> segmentFilenameIterator = eb2TabNames.keySet().iterator();
			while(segmentFilenameIterator != null && segmentFilenameIterator.hasNext())
			{
				String key = segmentFilenameIterator.next();				
				if(!key.endsWith("_Header"))
				{					
					File eb2File = new File(strDirName + eb2TabNames.get(key) + ".txt");
					writeBillingHeader(eb2File, eb2TabNames.get(key + "_Header"));
				}
			}
		}
	}
	
	public String[] getSegmentDtls(String segmentName, String eventType) throws Exception
	{
		if(segmentDtlsMap == null) segmentDtlsMap = new HashMap<String,String[]>();
		String [] segmentDtls = segmentDtlsMap.get(segmentName);
		if(segmentDtls == null)
		{
			segmentDtls = clientDB.getDBFSegmentDtls(segmentName, eventType);
			segmentDtlsMap.put(segmentName, segmentDtls);
		}
		
		return segmentDtls;
	}
	
	public void closeResources()
	{
		if(mdbDBRef != null)
		{
			for(Database db:mdbDBRef.values())
			{
				try
				{
					db.flush();
					db.close();	
				}
				catch(Exception exp)
				{
					common.fileOutput(strLogFile, "(OutboundClientWriteFile:closeResources) Exception : "+ exp +"\n" );
				}			
			}
			mdbDBRef.clear();
		}
	}
	
	private String getDBFExeFile() throws Exception
	{
		String exeFile = InterfaceUtil.getIntSetupDir()
							+ EMConstants.EXE_FOLDER
							+ "dbfwrite1.exe";
		return exeFile;
	}
	
	//Added by Sethu for ARYU-SCF-0128	
	public void writeToFile(String strOutFileName, String strMessage ) 
    {    	    	
    	
    	try
    	{   		
    		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(strOutFileName), "UTF8"));
    		    
    		out.write(strMessage);
    		out.close();      	    
    	} 
    	catch(FileNotFoundException exceptionFileNotFound) {
    		common.fileOutput(strLogFile, "(OutboundClientWriteFile:writeToFile) Exception : "+ exceptionFileNotFound +"\n" );    	    
    	}
    	catch(IOException exceptionFile) {
    		common.fileOutput(strLogFile, "(OutboundClientWriteFile:writeToFile) Exception : "+ exceptionFile +"\n" );  
    	}
    	catch(Exception exception) {
    		common.fileOutput(strLogFile, "(OutboundClientWriteFile:writeToFile) Exception : "+ exception +"\n" );  
    	}
    	
    }
    

}
