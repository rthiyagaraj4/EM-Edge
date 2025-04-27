package HL7Engine.Common; 

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import oracle.jdbc.OracleCallableStatement;
import oracle.sql.CLOB;

/**
 * Class contains utility methods that can be used by any class.
 *
 * @author 	Ravindranath
 */

public class CommonUtil
{
    /**
     * Method returns java.util.Date in the specified string format
     */
    public static String getFormattedStringDate(String format,Date date)
    {	
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		String dateFormatted = dateFormat.format(date);
		return dateFormatted;
    }

    /**
     * Method converts the given date in string to java.util.Date with the specified dateFormat
     * @param strDate string that has to be converted to date 
     * @param dateFormat indicates in which format the converted date has to be 
     */
    public static Date convertToDate(String strDate,String dateFormat)
    {
		SimpleDateFormat simpleDateFormat = null;
		Date date = null;
		try
		{
		    simpleDateFormat = new SimpleDateFormat(dateFormat);
		    date = simpleDateFormat.parse(strDate);
		}
		catch(Exception exp)
		{
		    //	common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:convertToDate) Exception:"+exp+"\n " ) ;
		}
		return date;
    }

    /**
     * Converts the given string in to milliseconds
     */
    public long getTimeInMillis(String strDate,String dateFormat)
    {
	long timeInMillis = 0;
	try
	{
	    GregorianCalendar calendar = new GregorianCalendar();
	    calendar.setTime(convertToDate(strDate,dateFormat));
	    timeInMillis = calendar.getTimeInMillis();
	}
	catch(Exception exp) { 
	}
	return timeInMillis;
    }

    /**
     * Converts the given string in to Calendar instance
     */
    public static Calendar convertStr2Calendar(String strDate,String strDateFormat) throws ParseException
    {
	SimpleDateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	Calendar calendar = Calendar.getInstance();
	Date date = dateFormat.parse(strDate);
	calendar.setTime(date);
	return calendar;
    }

    /**
     * Creates a new directory if one does not exists.
     */
    static public boolean makeDirectory(String path)
    {
		boolean dirCreated = false;
		File tempDir = new File(path);
		if(!tempDir.isDirectory())
		{
		    dirCreated = tempDir.mkdirs();
		}
		else
		{
		    dirCreated = true;
		}
		return dirCreated;
    }

    static public String getConsoleMessage(Process processrefvar) throws Exception
    {
	String string = "";
	byte byteMsg[] = new byte[500];
	InputStream io = null;

	io = processrefvar.getInputStream();
	int intTotBytes = io.read(byteMsg);
	if(intTotBytes > 0)  string = new String(byteMsg,0,intTotBytes);

	return string;                      
    }

    static public boolean isSubstringExists(String str, String substr)
    {
	boolean status = false; 
	Pattern pattern = Pattern.compile(substr);
	Matcher matcher = pattern.matcher(str); 
	status = matcher.find();
	return status; 
    }

    // Method sends the stack trace of passed exception in string format.
    static public String getStringStackTrace(Exception exp)
    {
	String expStr = exp.getMessage();
	try
	{
	    StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    exp.printStackTrace(pw);
	    expStr = sw.toString();
	}
	catch(Exception cexp)
	{}
	return expStr;
    }

    // Method sends the stack trace of passed error in string format.
    static public String getStringStackTrace(Error exp)
    {
	String expStr = exp.getMessage();
	try
	{
	    StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    exp.printStackTrace(pw);
	    expStr = sw.toString();
	}
	catch(Exception cexp)
	{}
	return expStr;
    }

    /**
     * asciiNumber argument is ascii number of the message delimiters seperated by pipe character.
     * Method converts the asciiNumber in to appropriate ascii value.
     */
    static public String formatAsciiToString(String asciiNumber)
    {
	int tempAsciiNo;
	StringBuffer delimiter = new StringBuffer();
	String retValue = null;

	if(asciiNumber != null)
	{
	    StringTokenizer tokenizer = new StringTokenizer(asciiNumber,"|");

	    while(tokenizer.hasMoreTokens())
	    {
		tempAsciiNo = Integer.parseInt(tokenizer.nextToken());
		delimiter.append(((char)tempAsciiNo));
	    }
	    retValue = delimiter.toString();
	}

	return retValue;
    }

    /**
     * Predefined java StirngTokenizer will not consider the empty tokens.
     * This method processes the string without omitting empty tokens.
     */
    public static List eHISStringTokenizer(String replaceStr, String delimiter)
    {
	StringTokenizer tokens = new StringTokenizer(replaceStr, delimiter, true);
	ArrayList list = new ArrayList();
	String previuosToken = "";

	while (tokens.hasMoreTokens())
	{
	    String currentToken = tokens.nextToken();			
	    if(delimiter.equals(currentToken))
	    {
		if(previuosToken.equals(delimiter)) list.add("");
	    }
	    else
	    {
		list.add(currentToken);				
	    }
	    previuosToken = currentToken;			
	}	
	if(previuosToken.equals(delimiter)) list.add("");
	return list;
    }

    /**
     * Predefined java split will include delimiter in the output array.
     * This method processes the string omitting delimiter.
     */
    public static List<String> eHISStringSplit(String replaceStr, String delimiter)
    {		
	String tokens[] = replaceStr.split(delimiter);
	ArrayList<String> list = new ArrayList<String>();
	String previuosToken = "";

	for(String token:tokens)
	{
	    System.out.println("token "+token);
	    if(delimiter.equals(token))
	    {
		if(previuosToken.equals(delimiter)) list.add("");
	    }
	    else
	    {
		list.add(token);				
	    }
	    previuosToken = token;			
	}	
	if(previuosToken.equals(delimiter)) list.add("");
	return list;
    }

    /**
     * Method formats the clob in to a string.
     */
    public static String formatClob(Clob clob) throws Exception
    {
	StringBuffer sbClobData	= new StringBuffer();

	if(clob != null)
	{
	    sbClobData.append(clob.getSubString(1,(int)clob.length()));
	}

	return sbClobData.toString();
    }

    /**
     * Method parses the interface message and tokenizes it's segments.
     * Returns a hashmap which contains segments as keys and list of segment fields as key values.
     */
    public static HashMap formatMessage(String message, String msgStart, String msgEnd, String segStart, String segEnd, String fieldSeparator)
    {
	StringTokenizer segmentTokens = new StringTokenizer(message,formatAsciiToString(segEnd));
	String tempCurrSegment = null;
	String segmentName = null;

	ArrayList segmentFieldList = null;
	HashMap msgSegmentMap = new HashMap();

	while (segmentTokens.hasMoreTokens())
	{			
	    tempCurrSegment = segmentTokens.nextToken();
	    int segmentIndex = tempCurrSegment.indexOf(formatAsciiToString(fieldSeparator));
	    if(segmentIndex == -1) break; // indicates end of message
	    segmentFieldList = (ArrayList) eHISStringTokenizer(tempCurrSegment, formatAsciiToString(fieldSeparator));			
	    segmentName = tempCurrSegment.substring(segmentIndex - 3, segmentIndex);			
	    msgSegmentMap.put(segmentName,segmentFieldList);
	    //	if("TXA".equals(segmentName)) break;
	}
	return msgSegmentMap;
    }

    /**
     * Method parses the interface message and tokenizes it's segments.
     * Returns a hashmap which contains segments as keys and list of segment fields as key values.
     */
    public static HashMap<String,List<String>> splitMessage(String message, String msgStart, String msgEnd, String segStart, String segEnd, String fieldSeparator)
    {
	String segmentTokens[] = message.split(formatAsciiToString(segEnd));
	String segmentName = null;

	ArrayList<String> segmentFieldList = null;
	HashMap<String,List<String>> msgSegmentMap = new HashMap<String,List<String>>();

	for(String tempCurrSegment: segmentTokens)
	{
	    int segmentIndex = tempCurrSegment.indexOf(formatAsciiToString(fieldSeparator));
	    if(segmentIndex == -1) break; // indicates end of message
	    segmentFieldList = (ArrayList<String>) eHISStringTokenizer(tempCurrSegment, formatAsciiToString(fieldSeparator));			
	    segmentName = tempCurrSegment.substring(segmentIndex - 3, segmentIndex);			
	    msgSegmentMap.put(segmentName,segmentFieldList);
	}
	return msgSegmentMap;
    }

    /**
     * Method fetches contents from the specified filename and returns as string
     */
    public static String fetchFileContents(String fileName) throws Exception
    {
	String buffer = "";
	int msgChar;
	BufferedReader inStream = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF8")); 

	while((msgChar = inStream.read()) != -1)
	{
	    buffer += (char)msgChar;					
	}

	inStream.close();
	return buffer;
    }

    /**
     * Method replaces with zero for null or empty string
     */
    public static Double checkDouble(String val)
    {
	if(val == null || (val.trim()).equals("")) val = "0";
	return ( new Double(val) );
    }

    /**
     * Method replaces with empty string for null object 
     */
    public static String checkNull(String val)
    {
		return checkNullReplace(val, "");
    }
    
    public static String checkNullReplace(String val, String replaceWith)
    {
		if(val == null || (val.trim()).equals("null") || (val.trim()).equals("")) {
			val = replaceWith;
		}
		return val;
    }

    /**
     * Method replaces with empty string for null object 
     */
    public static String checkNumber(String val)
    {
	if(val == null || (val.trim()).equals("null")) val = "";
	else if(val.trim().equals("")) val = "0";
	return val;
    }

    /**
     * Method tokenizes the string and a list of all the tokens
     */
    public static List getTokenList(String str, String delimiter)
    {
	StringTokenizer tokens = new StringTokenizer(str, delimiter);
	ArrayList list = new ArrayList();

	while (tokens.hasMoreTokens())
	{
	    list.add(tokens.nextToken());				
	}

	return list;
    }

    /**
     * Method replaces with null for empty string object
     */
    public static String checkEmptyStr(String val)
    {		
	if(val != null && (val.trim()).equals("")) val = null;		
	return val;
    }

    /**
     * Method converts string date in one format to the specified string format
     */
    public static String convertDateFormat(String strDate, String oldFormat, String newFormat) throws Exception
    {
	SimpleDateFormat dateFormat = new SimpleDateFormat(oldFormat);
	Date date = dateFormat.parse(strDate);
	dateFormat = new SimpleDateFormat(newFormat);
	return dateFormat.format(date);
    }

    /**
     * Method zips all the files from src dir and copies the zip in dest dir.
     *
     * @param zipFileName Name of the zip file, should be passed with full path
     * @param fileType Type of the files that are to be zipped
     */
    public static void zipFiles(String srcDir, String zipFileName, String fileType) throws Exception
    {
	ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipFileName)));
	byte[] data = new byte[1024];

	File filesToZip [] = (new File(srcDir)).listFiles();			

	int count;
	int fileCount = filesToZip.length;

	for (int i = 0; i < fileCount; i++)
	{
	    String fileName = filesToZip[i].getName();

	    if(fileName.endsWith(fileType))
	    {
		FileInputStream in = new FileInputStream(filesToZip[i]);
		out.putNextEntry(new ZipEntry(fileName));

		while((count = in.read(data,0,1024)) != -1)
		{      
		    out.write(data, 0, count);
		}

		in.close();
		out.flush();
	    }
	}

	out.close();
    }

    /**
     * Method tries to uninstall the specified service
     * 
     * @param stopService Flag indicates whether to stop the service or not before uninstalling the service
     */
    public static String uninstallWindowsService(String serviceName, boolean stopService) throws Exception
    {
	Runtime runtime = Runtime.getRuntime();		
	String uninstallCmd = "javaservice -uninstall " + serviceName;

	if(stopService) stopWindowsService(serviceName);
	Process process = runtime.exec(uninstallCmd);

	return(getConsoleMessage(process));
    }

    public static String stopWindowsService(String serviceName) throws Exception
    {
	Runtime runtime = Runtime.getRuntime();		
	String cmd = "sc stop " + serviceName;

	Process process = runtime.exec(cmd);
	return(getConsoleMessage(process));
    }

    /**
     * Method checks whether any windows service exists or not and 
     * installs the service if it does not exist based on installService flag
     * 
     * @param installService Flag specified whether to install the service or not if it does not exist
     */
    public static String checkWindowsService(String serviceName, boolean installService) throws Exception
    {
	String statusCmd = "sc query " + serviceName;

	Runtime runtime = Runtime.getRuntime();
	Process process = runtime.exec(statusCmd);
	String status = CommonUtil.getConsoleMessage(process);
	boolean isServiceNotExists = CommonUtil.isSubstringExists(status, EMConstants.SERVICE_NOT_EXISTS);
	return null;

	//	if(isServiceNotExists && installService) installWindowsService(serviceName);
	//	else if(!isServiceNotExists && installService) startWindowsService(serviceName);
    }

    /**
     * Method retreives the specified property value from the specified property file.
     */
    public static String getPropertyVal(String fileName, String property) throws Exception
    {
	Properties configProperties = new Properties();
	FileInputStream fis = new FileInputStream(fileName);
	String propVal = null;

	configProperties.load(fis);
	propVal = configProperties.getProperty(property);

	if(fis != null) fis.close();

	return propVal;
    }

    public static boolean moveFile(String srcDir, String destDir, String fileName)
    {
	File srcFile = new File(srcDir + "/" + fileName);
	File destFile = new File(destDir);

	if(!destFile.isDirectory()) destFile.mkdir();

	destFile = new File(destDir + "/" + fileName);

	boolean fileMoved = srcFile.renameTo(destFile);

	return fileMoved;
    }

    public static String getDBError(String exceptionMessage)
    {
	String errorStr = "Database Connection Failed...";

	if(isSubstringExists(exceptionMessage, EMConstants.ORA_INVALID_USER)) {
	    errorStr = errorStr + "Verify username and password !!";
	}
	else if(isSubstringExists(exceptionMessage, EMConstants.ORA_ACCOUNT_LOCK)) {
	    errorStr = errorStr + "User account locked !!!";
	}

	return errorStr;
    }

    /**
     * Method fetches the oldest modified file with the specified extension type 
     */
    public static String getOldFileInFolder(String folder, String strExtension) throws Exception
    {				
	File [] fileList;
	String fileNamingApi = null;

	String errorMsg = null;

	File fileListDir = new File(folder);

	if(!fileListDir.exists())
	{
	    errorMsg = "Folder does not exist...";
	}

	fileList = fileListDir.listFiles(new InterfaceFileFilter(strExtension));

	Arrays.sort(fileList, new Comparator<File>() {
	    public int compare(File f1, File f2) {
		return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
	    } 
	});

	if(fileList.length > 0) fileNamingApi = fileList[0].toString();

	return fileNamingApi;
    }	

    /**
     * Method can be used to close any output stream 
     */
    public static void closeStream(OutputStream outputStream)
    {
		try
		{
		    if(outputStream != null) outputStream.close();
		}
		catch (Exception exp)
		{
		}
    }

    /**																				  
     * Utility method used for closing the database resources
     */
    public static void closeDBResources(ResultSet rs, Statement stmt, Connection conn)
    {
		try {
		    if(rs != null) rs.close();
		}
		catch(Exception exp) {
		}
		finally  {
		    try {
			if(stmt != null) stmt.close();
		    }
		    catch(Exception exp) {
		    }
		    finally  {
			try {
			    if(conn != null) conn.close();					
			}
			catch (Exception exp) { }				
		    }
		}
    }

    public static CLOB createEmptyClob(Connection connDB) throws Exception
    {
	String strProcedureName = "{call XHCORE.create_lob(?,?) }";
	OracleCallableStatement call1 = null;
	CLOB clob = null;

	try
	{
	    call1 = (OracleCallableStatement) connDB.prepareCall(strProcedureName);
	    call1.registerOutParameter(1,java.sql.Types.CLOB);
	    call1.registerOutParameter(2,java.sql.Types.VARCHAR);
	    call1.execute();
	    clob = (oracle.sql.CLOB) call1.getClob(1);
	}
	catch(Exception exp)
	{
	    throw exp;
	}
	finally
	{
	    closeDBResources(null, call1, null);
	}

	return clob;
    }

    public static CLOB convertStrToClob(String str, Connection connDB) throws Exception
    {
	CLOB clobMessage = createEmptyClob(connDB);
	Writer outstream = clobMessage.getCharacterOutputStream();
	outstream.write(str.toCharArray());
	outstream.close();
	return clobMessage;
    }

    public static void moveFiles(String srcDir, String destDir) throws Exception
    {
	File [] flist = new File(srcDir).listFiles();
	int len = flist.length;
	int i = 0;
	while(i < len)
	{
	    if(flist[i].isFile()) moveFile(flist[i], destDir);
	    i++;
	}
    }

    public static boolean moveFile(File srcFile, String destDir) throws Exception
    {
    	File destFile = new File(destDir);
    	if(!destFile.exists()) destFile.mkdir();
    	destFile = new File(destDir + "/" + srcFile.getName());
    	boolean fileMoved = srcFile.renameTo(destFile);
    	return fileMoved;
    }

    public static boolean deleteFiles(File file)
    {
    	boolean isDeleted = false;
    
    	if(file.exists())
    	{
    	    if(file.isDirectory())
    	    {
        		File [] flist = file.listFiles();
        		int len = flist.length;
        		int i = 0;
        		while(i < len)
        		{
        		    deleteFiles(flist[i]);
        		    i++;
        		}
        		isDeleted = file.delete();
    	    }
    	    else
    	    {
    	    	isDeleted = file.delete();
    	    }
    	}
    	else isDeleted = true;
    	return isDeleted;
    }
    
    public static boolean deleteFiles(String fileName)
    {
    	return deleteFiles(new File(fileName));
    }
    
    /**
     * Method checks if actualStr is equals to any of the strings in the string array passed
     * 
     * @param compareStrSet String array with which actualStr will be checked
     */
    public static boolean equalsAny(String actualStr,String[] compareStrSet)
	{		
		boolean isEquals = false;
		if(actualStr != null)
		{
			for(String currentStr: compareStrSet)
			{
				if(actualStr.equals(currentStr)) 
				{
					isEquals = true;
					break;
				}
			}
		}
		return isEquals;
	}
    
    /*
     * Method to avoid check for index -1 every time in the regular code
     */
    public static String emSubstring(String string, int startIndex, int endIndex)
	{
		String substring = "";

		if(endIndex == -1) substring = string.substring(startIndex);
		else substring = string.substring(startIndex, endIndex);

		return substring;
	}
    
    public static String processAsciiToString(String currentDelimiter)
	{
		StringBuilder delimiterBuilder = new StringBuilder();
		
		if(currentDelimiter != null)
		{
			for(String tempDelimiter: currentDelimiter.split("\\|"))
			{
				delimiterBuilder.append((char)Integer.parseInt(tempDelimiter));
			}
		}

		return delimiterBuilder.toString();
	}
    
    /**
     * Checks whether "file" is writable or not from the current process.
     * If "file" is a folder, method checks all the existing files in the folder for write access,
     *  if no files are there it will try to create new file
     * If "createIfNotExists" is passed as false and "file" does not exist, method will not check anything and returns false
     * @param file file or folder for which write access to be checked
     * @param createIfNotExists true - checks write access by creating new file if not exists, false - will return false if file does not exist
     * @return
     * @throws Exception
     */
    static public boolean canWrite(File file, boolean createIfNotExists) throws Exception
    {
    	boolean isWritable = false;
        
    	if(file.exists())
    	{
    	    if(file.isDirectory())
    	    {
        		File [] flist = file.listFiles();
        		for(File currentFile : flist) {
        			isWritable = canWrite(currentFile, false);
        			if(!isWritable) break;
        		}
    	    }
    	    else {
    	    	isWritable = !fileOperations(file, "IS_ACCESS_DENIED");
    	    }
    	}
    	else {
    		isWritable = !fileOperations(file, "IS_ACCESS_DENIED");
    	}
    	return isWritable;
    }
static public boolean canWrite(String fileName, boolean createIfNotExists) throws Exception
    {
    	return canWrite(new File(fileName), createIfNotExists);
    }
    
    static public boolean isFileOpen(File file)
    {
    	boolean isFileOpen = false;
        
    	if(file.exists())
    	{
    	    if(file.isDirectory()) {
        		File [] flist = file.listFiles();
        		if(flist != null) {
	        		for(File currentFile : flist) {
	        			isFileOpen = isFileOpen(currentFile);
	        			if(isFileOpen) break;
	        		}
	    	    }
    	    }
    	    else {
    	    	isFileOpen = fileOperations(file, "IS_FILE_OPEN");
    	    }
    	}
    	
    	return isFileOpen;
    }
    
    /**
     * Method should be used care fully, will create the specified file if does not exist for checking the required operation and will not delete
     * @param file
     * @param operation
     * @return returns true if the operation is true
     */
    private static boolean fileOperations(File file, String fileOperation)
    {
    	FileOutputStream fos = null;
    	boolean isSuccess = false;
    	String fileOperationExpectedError = "";
    	
    	try {
    		if("IS_ACCESS_DENIED".equals(fileOperation)) {
    			fileOperationExpectedError = "Access is denied";
    		}
    		else if("IS_FILE_OPEN".equals(fileOperation)) {
    			fileOperationExpectedError = "The process cannot access the file because it is being used by another process";
    		}
    		fos = new FileOutputStream(file, true);
    	}
    	catch(IOException exp) {
    		if(isSubstringExists(exp.getMessage(), fileOperationExpectedError)) {
    			isSuccess = true;
    		}
    	}
    	finally {
    		closeStream(fos);
    	}
    	return isSuccess;
    }

    static public String executeCMD(String exeCMD, boolean sleepAfterExe, boolean waitTillComplete, int sleepTime) throws Exception
    {
    	String processStatus = "";
    	Runtime runtime = Runtime.getRuntime();
    	Process process = runtime.exec(exeCMD);
    	processStatus = CommonUtil.getConsoleMessage(process);
    	return processStatus;
    }  
}