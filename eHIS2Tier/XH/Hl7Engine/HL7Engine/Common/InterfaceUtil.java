package HL7Engine.Common; 

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Clob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

/**
 * Class contains utility methods that can be used by any class.
 *
 * @author 	Ravindranath
 */

public class InterfaceUtil
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
		try {
			simpleDateFormat = new SimpleDateFormat(dateFormat);
			date = simpleDateFormat.parse(strDate);
		}
		catch(Exception exp) {
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
		try {
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(convertToDate(strDate,dateFormat));
			timeInMillis = calendar.getTimeInMillis();
		}
		catch(Exception exp) { 
		}
		return timeInMillis;
	}

	/**
	 * Creates a new directory if one does not exists.
	 */
	static public void makeDirectory(String path)
	{
		File tempDir = new File(path);
		if(!tempDir.isDirectory()) {
			tempDir.mkdir();
		}
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

			while(tokenizer.hasMoreTokens()) {
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
			if(delimiter.equals(currentToken)) {
				if(previuosToken.equals(delimiter)) list.add("");
			}
			else {
				list.add(currentToken);				
			}
			previuosToken = currentToken;			
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
		
		if(clob != null) {
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
	 * Method fetches contents from the specified filename and returns as string
	 */
	public static String fetchFileContents(String fileName) throws Exception
	{
		return fetchFileContents(new FileInputStream(fileName));
	}
	
	public static String fetchFileContents(InputStream fileStream) throws Exception
	{
		String buffer = "";
		int msgChar;
		BufferedReader inStream = new BufferedReader(new InputStreamReader(fileStream, "UTF8")); 

		while((msgChar = inStream.read()) != -1) {
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
		if(val == null || (val.trim()).equals("null")) val = "";
		return val;
	}

	/**
	 * Method tokenizes the string and a list of all the tokens
	 */
	public static List getTokenList(String str, String delimiter)
	{
		StringTokenizer tokens = new StringTokenizer(str, delimiter);
		ArrayList list = new ArrayList();

		while (tokens.hasMoreTokens()) {
			list.add(tokens.nextToken());				
		}
		
		return list;
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
	 * Method retreives the specified property value from the specified property file.
	 */
	public static String getPropertyVal(String fileName, String property) throws Exception
	{
		return getPropertyVal(fileName, property, "");
	}
	
	public static String getPropertyVal(String fileName, String property, String defaultValue) throws Exception
	{
		Properties configProperties = new Properties();
		FileInputStream fis = new FileInputStream(fileName);
		String propVal = null;

		configProperties.load(fis);
		propVal = configProperties.getProperty(property, defaultValue);

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
	
	/**
	 * Methods to get the database sid from the db connection string set in xh_param.
	 * Used to build the windows service name
	 * @param strTnsName
	 * @return database sid
	 */
	public static String getDBName(String strTnsName)
    {
    	String dbName = null;		
		int dbNameIndex = strTnsName.lastIndexOf(":") + 1;
		
		if(dbNameIndex == 0) {
			int serviceNameStart = strTnsName.lastIndexOf("SERVICE_NAME=") + 13;
			int serviceNameEnd = strTnsName.indexOf(")", serviceNameStart);			
			dbName = strTnsName.substring(serviceNameStart, serviceNameEnd);
		}
		else {
			dbName = strTnsName.substring(strTnsName.lastIndexOf(":") + 1);
		}
    	return dbName;
    }
	
	/**
	 * Method to get the setup directory of EM Interface from environment variables. 
	 * Directory contains all the configuration folders like Config, Executables etc...
	 */
	public static String getIntSetupDir()
	{
		String setupDir = null;
		try {
			setupDir = System.getenv(EMConstants.EM_SETUP_ENV_NAME);
			if(setupDir == null) setupDir = EMConstants.EM_SETUP_DIR_OLD;
		}		
		catch(Exception exp) {	
		}
		return setupDir;
	}
	
	/**
	 * For getting default location for log files in case any exceptions while starting the process
	 */
	public static String getDefaultLogLoc(String logName)
	{
		String logFile = null;
		try {
			logFile = getIntSetupDir() + "/logs/" + logName + EMConstants.LOG_EXT;
		}
		catch(Exception exp) {	
		}
		return logFile;
	}

	public static String getiniFilePath(String fileType) throws Exception
	{
		String path = null;
		if("CONFIG".equals(fileType))
		{
			path = getIntSetupDir() + EMConstants.CONFIG_FILE;
		}
		else if("DB_QRY".equals(fileType))
		{
			path = getIntSetupDir() + EMConstants.DBCONN_CHK_QRY_FILE;
		}
		return path;
	}
}