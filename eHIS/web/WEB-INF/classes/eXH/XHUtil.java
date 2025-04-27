package eXH;

import java.io.Closeable;
import java.io.StringReader;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.Properties;
import java.util.StringTokenizer;
import java.text.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import com.ehis.util.DateUtils;
import com.ehis.util.FormatterFactory;

import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONValue;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.io.StringReader;
import java.io.StringWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class contains methods that can be used from different places for easy access
 *
 * @created	27 Jan 2009
 * @author 	Ravindranath
 */
public class XHUtil
{ 
	static Connection dbConn = null;
	static Statement stmt = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	static String queryInboundMsgText = "SELECT INBOUND_MESSAGE_TEXT,message_status FROM ? WHERE APPLICATION_ID=NVL(?,APPLICATION_ID)  AND MESSAGE_ID=NVL(?,MESSAGE_ID) ";
	static String queryOutboundMsgText = "SELECT MESSAGE_TEXT,message_status FROM ? WHERE APPLICATION_ID=NVL(?,APPLICATION_ID) AND MESSAGE_ID=NVL(?,MESSAGE_ID) AND EVENT_TYPE=NVL(?,EVENT_TYPE) AND FACILITY_ID=NVL(?,FACILITY_ID )";

	public static final String[] EMPTY_STR_ARRAY = new String[0];

	public static String l_debug_YN = "N";

	/**
	 * Method return the event name for the eventType passed
	 */
	public static String getEventName(String eventType)
	{
		String eventName = null;
		try
		{
			dbConn = ConnectionManager.getConnection();

			stmt = dbConn.createStatement();
			rs = stmt.executeQuery("SELECT event_name FROM xh_event_type WHERE event_type='"+eventType+"'");
			if(rs.next())
			{
				eventName = XHDBAdapter.checkNull((String)rs.getString("event_name"));
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(dbConn != null) ConnectionManager.returnConnection(dbConn);
			}
			catch(Exception fexp)
			{
				fexp.printStackTrace(System.err);
			}
		}
		return eventName;
	}

	/**
	 * Method return message string.
	 * argCount indicates no of dynamic parameters present in the query and loops that no of times,
	 * by replacing the arguments list values for the query parameters
	 *
	 */
	public static String getMessage(String commMode,int argCount,ArrayList arguments)
	{
		String msgTxt = null;
		String query = "";
		try
		{
			if(commMode != null && commMode.equalsIgnoreCase("O")) query = queryInboundMsgText;
			else query = queryOutboundMsgText;

			dbConn = ConnectionManager.getConnection();

			pstmt = dbConn.prepareStatement(query);
			
			for (int i=0;i<argCount ;i++ )
			{				
				pstmt.setString(i,(String)arguments.get(i));
			}

			rs = pstmt.executeQuery();

			if(rs.next())
			{
				msgTxt = XHDBAdapter.checkNull((String)rs.getString(1));				
				msgTxt = java.net.URLEncoder.encode(msgTxt);
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(stmt != null) stmt.close();
				if(dbConn != null) ConnectionManager.returnConnection(dbConn);
			}
			catch(Exception fexp)
			{
				fexp.printStackTrace(System.err);
			}
		}
		return msgTxt;
	}

	/**
	 * Method formats the "date" argument as per the "format" argument passed.
	 * If the "date" argument is null, by default today's date will be considered.
	 * Formatted date will returned as string
	 */
	public static String getFormattedStringDate(String format,java.util.Date date)
	{	
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		if (date == null)
		{
			date = new java.util.Date();
		}
		String dateFormatted = dateFormat.format(date);
		return dateFormatted;
	}

	/**
	*  Method converts the given date in string to java.util.Date with the specified dateFormat
	*	@param strDate string that has to be converted to date 
	*	@param dateFormat indicates in which format the converted date has to be 
	**/
	public static String convertToDate(String strDate,String dateFormat)
	{
		SimpleDateFormat simpleDateFormat = null;		
		Date date = null;
		String retDate = "";
		try
		{
			simpleDateFormat = new SimpleDateFormat(dateFormat);
			date = simpleDateFormat.parse(strDate);
			retDate = getFormattedStringDate("yyyyMMddhhmmss",date);
		}
		catch(Exception exp)
		{					
			exp.printStackTrace(System.err);
		}
		return retDate;
	}

	public static String convertDateFormat(String strDate, String fromFormat, String toFormat)
	{
		SimpleDateFormat simpleDateFormat = null;		
		Date date = null;
		String retDate = "";
		try
		{
			if(strDate != null && !(strDate.trim().equals("")) && !(strDate.trim().equals("null")))
			{
				simpleDateFormat = new SimpleDateFormat(fromFormat);
				date = simpleDateFormat.parse(strDate);
				retDate = getFormattedStringDate(toFormat, date);
			}
		}
		catch(Exception exp)
		{					
			exp.printStackTrace(System.err);
		}
		return retDate;
	}

	public static boolean isBefore(String chkDate, String compareDate, String format, String locale) throws Exception
	{		
		Date d1 = convertStrToDate(chkDate, format);
		Date d2 = convertStrToDate(compareDate, format);

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(d1);
		c2.setTime(d2);

		return c1.before(c2);
	}

	public static Date convertStrToDate(String strDate, String format) throws Exception
	{  
		java.util.Date date = null;
		if(strDate != null && !strDate.equals("")) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			date = dateFormat.parse(strDate);
		}
		return date;
	} 

	public static String xhLocaleDateDisplay(String date, String currentFormat, String destFormat, String locale, boolean isFormatChangeReq) throws Exception
	{
		if(destFormat == null || destFormat.equals("")) destFormat = "DMY";
		if(isFormatChangeReq)
		{			
			date = convertDateFormat(date, currentFormat, FormatterFactory.getFormat(destFormat));			
		}
		if("th".equalsIgnoreCase(locale))
		{
			date = DateUtils.convertDate(date, destFormat, "en", "th");
		}
		return date;
	}

	/**																				  
	 * Utility method used for closing the database resources
	 */
	public static String closeSQLObj(Object object, String objectType)
	{
		if(object != null)
		{
			try
			{
				if("ResultSet".equalsIgnoreCase(objectType))
				{
					ResultSet rs = (ResultSet)object;
					rs.close();
				}
				else if("PreparedStatement".equalsIgnoreCase(objectType))
				{
					Statement pst = (PreparedStatement)object;
					pst.close();
				}
				else if("Connection".equalsIgnoreCase(objectType))
				{
					Connection con = (Connection) object;
					con.close();	
					//ConnectionManager.returnConnection(con);
				}
				else if("CallableStatement".equalsIgnoreCase(objectType))
				{
					CallableStatement cstmt = (CallableStatement) object;
					cstmt.close();
				}
			}
			catch(Exception se)
			{
				return se.toString();
			}
		}
		return "Object Closed.";
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
			exp.printStackTrace();
		}
		finally  {
			try {
				if(stmt != null) stmt.close();
			}
			catch(Exception exp) {
				exp.printStackTrace();
			}
			finally  {
				try {
					if(conn != null) {
						conn.close();		
					}
				}
				catch (Exception exp) { 
					exp.printStackTrace();
				}				
			}
		}
	}

	public static void closeDBResources(ResultSet rs, PreparedStatement pstmt, Connection conn)
	{


		try {
			if(rs != null) rs.close();
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
		finally  {
			try {
				if(pstmt != null) pstmt.close();
			}
			catch(Exception exp) {
				exp.printStackTrace();
			}
			finally  {
				try {
					if(conn != null) {
						conn.close();		
					}
				}
				catch (Exception exp) { 
					exp.printStackTrace();
				}				
			}
		}
	}

	public static void closeDBResources(ResultSet rs, CallableStatement cstmt, Connection conn)
	{
		try {
			if(rs != null) rs.close();
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
		finally  {
			try {
				if(cstmt != null) cstmt.close();
			}
			catch(Exception exp) {
			}
			finally  {
				try {
					if(conn != null) {
						conn.close();		
					}
				}
				catch (Exception exp) { }				
			}
		}
	}

	/**
	 * Method to submit the procedure as job.
	 */
	public static String[] submitJob(String jobWhatStr, java.util.Date jobStartTime, String interval)
	{
		Connection dbConn = null;
		CallableStatement cstmt = null;
		String jobSubmitProc = "{ call xhjob.process_job(?,?,?,?,?,?,?,?,?,?) }";
		String actionParam = "S"; // S - Submitting job
		String procID = ""; // Submitting job
		String jobID = "0";		
		String internalJob = "";

		String [] status = new String[2];

		try
		{
			dbConn = ConnectionManager.getConnection();
			cstmt = dbConn.prepareCall(jobSubmitProc);
			cstmt.setString(1, actionParam);
			cstmt.setString(2, procID);
			cstmt.setString(3, jobID);
			cstmt.setString(4, jobID);
			cstmt.setString(5, jobWhatStr);
			cstmt.setString(6, internalJob);
			cstmt.setTimestamp(7, new java.sql.Timestamp(jobStartTime.getTime()));
			cstmt.setString(8, interval);
			cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
			cstmt.execute();
			status[0] = cstmt.getString(9); // Msg Code
			status[1] = cstmt.getString(10); // Error msg
		}
		catch (Exception exp)
		{
			exp.printStackTrace();
			status[0] = "1";
			status[1] = "";
		}
		finally
		{
			
			try
			{
				if(cstmt != null) cstmt.close();
				if(dbConn != null) ConnectionManager.returnConnection(dbConn);
			}
			catch (Exception exp)
			{
			}
		}
		return status;
	}

	public static String getMessage(String statusCode, String locale)
	{
		String statusMsg = "";
		String messageID = "";

		if("0".equals(statusCode) || "S".equals(statusCode)) { // Successful
			messageID = "XH1001";
		}
		else if("1".equals(statusCode) || "E".equals(statusCode)) { // Fail 
			messageID = "XH1000";
		}
		statusMsg = getLocaleMessage(locale, messageID, "XH");

		return statusMsg;
	}

	public static String getLocaleMessage(String locale, String messageID, String moduleID)
	{
		java.util.Hashtable<String,String> msgMap = MessageManager.getMessage(locale, messageID, moduleID);
		String message = (String) msgMap.get("message");
		msgMap.clear();
		return message;
	}

	/**
	 * JDBC Utility Method executes the query and returns the result. As of now handles query that return only one param
	 */
	public static String singleParamExeQry(String qry)
	{
		Connection dbConn = null;
		Statement stmt = null;
		ResultSet rs = null;
		StringBuilder retValue = new StringBuilder();
		try
		{
			dbConn = ConnectionManager.getConnection();
			stmt = dbConn.createStatement();
			rs = stmt.executeQuery(qry);

			if(rs.next()) {
				retValue.append(rs.getString(1));
			}
		}
		catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		finally {
			try {
				if(rs != null) rs.close();
			}
			catch (Exception exp){
			}
			finally {
				try {
					if(stmt != null) stmt.close();
				}
				catch (Exception exp){
				}
				finally {
					try {


						if(dbConn != null) {
							//ConnectionManager.returnConnection(dbConn);
							dbConn.close();
						}
					}
					catch (Exception exp){
					}
				}
			}
		}
		return retValue.toString();
	}

	static public boolean isSubstringExists(String str, String substr)
	{
		boolean status = false; 
		Pattern pattern = Pattern.compile(substr);
		Matcher matcher = pattern.matcher(str); 
		status = matcher.find();
		return status; 
	}
	static public boolean isStrEmpty(String str)
	{
		boolean isStrEmpty = false;
		if(str == null || str.trim().equals("")) isStrEmpty = true;
		return isStrEmpty;
	}

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

	/**
	 * Converts all the request parameters in to hashmap
	 */
	public static Map<String,String> getRequestParams(HttpServletRequest request)
	{
		Map<String,String> requestParams = new HashMap<String,String>();
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()) 
		{
			String paramName = parameterNames.nextElement();
			String paramValue = XHDBAdapter.checkNull(request.getParameter(paramName));
			requestParams.put(paramName,paramValue);
		}
		return requestParams;
	}

	/**
	 * Converts all the request parameters in to JSON format
	 */
	public static String getRequestParamsJSON(HttpServletRequest request)
	{
		return JSONValue.toJSONString(getRequestParams(request));
	}

	/**
	 * JDBC Utility Method executes the update query and returns success/fail flag
	 */
	public static boolean executeUpdate(String qry, Connection dbConn)
	{		
		Statement stmt = null;
		boolean isUpdated = false;
		boolean isNewDBConn = false;
		try
		{
			if(dbConn == null)
			{
				dbConn = ConnectionManager.getConnection();
				isNewDBConn = true;
			}
			stmt = dbConn.createStatement();
			int i = stmt.executeUpdate(qry);

			if(i > 0)
			{
				dbConn.commit();
				isUpdated = true;
			}
			else
			{
				dbConn.rollback();				
			}
		}
		catch (Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			if(isNewDBConn)	closeDBResources(null, stmt, dbConn);
			else closeDBResources(null, stmt, null);
		}
		return isUpdated;
	}

	public static String decodeBase64String(String base64EncodedStr, String charSet) throws Exception
	{
		byte[] decodedBytes = Base64.decodeBase64(base64EncodedStr.getBytes());
		return (new String(decodedBytes, charSet));
	}

	public static String emPasswordEncrypt(String password)
	{
		String qry = "SELECT app_password.encrypt ('"+ password +"') FROM DUAL";
		String encryptedPwd = XHUtil.singleParamExeQry(qry);
		return encryptedPwd;
	}
	
	public static String getEMPassword(String userID)
	{
		String qry = "SELECT APP_PASSWORD.DECRYPT(APPL_USER_PASSWORD) FROM SM_APPL_USER WHERE APPL_USER_ID = ' " + userID + " ';";
		String decryptedPwd = XHUtil.singleParamExeQry(qry);
		return decryptedPwd;
	}

	public static void addGUIRowClassName(List<List<String>> list)
	{
		boolean flag = true;
		String guiClassName = "";
		for(List<String> rowList : list)
		{
			if(flag) {
				guiClassName = "QRYEVEN";
				flag = false;
			}
			else {
				guiClassName = "QRYODD";
				flag = true;
			}
			rowList.add(guiClassName);
		}
	}

	public static void addGUIRowClassMap(List<Map<String, String>> list)
	{
		boolean flag = true;
		String guiClassName = "";
		for(Map<String, String> rowList : list)
		{
			if(flag) {
				guiClassName = "QRYEVEN";
				flag = false;
			}
			else {
				guiClassName = "QRYODD";
				flag = true;
			}
			rowList.put("TD_CLASS_NAME", guiClassName);
		}
	}

	public static Map<String, String> getCookies(HttpServletRequest request)
	{
		Cookie cookiesArray [] = request.getCookies();
		Map<String, String> cookies = Collections.emptyMap();
		
		if(cookiesArray != null)
		{
			for(Cookie cookie : cookiesArray) 
			{
				cookies.put(cookie.getName(), cookie.getValue());
			}
		}
		return cookies;
	}
	
	public static String convertDateToStr(Date date, String format) {
		return new SimpleDateFormat(format).format(new Date());
	}
	
	/**
	 * Method builds the condition for date when building the query as every time null condition has to be checked for both fromdate and todate
	 * Eg:- message_date BETWEEN TO_DATE(NVL('12/12/2013',TO_CHAR(message_date,'dd/mm/yyyy')),'dd/mm/yyyy') AND 
	 * TO_DATE(NVL('25/12/2013',TO_CHAR(message_date,'dd/mm/yyyy')),'dd/mm/yyyy')
	 * @param dbCol name of the data column for which condition is being built (eg:- message_date)
	 * @param var1 from date variable name used in the method from where this util is being called (eg:- 12/12/2013)
	 * @param var2 to date variable name used in the method from where this util is being called (eg:- 25/12/2013)
	 * @return condition after checking the null conditions for both the variables
	 */
	public static String getBetweenQryCriteriaDate(String dbCol, String var1, String var2, String addBeforeCondition)
	{
		StringBuilder condition = new StringBuilder();
		String retVal = "";
		boolean flag = false;

		if(var1 != null && !var1.equals("")) {
			flag = true;
		}
		if(var2 != null && !var2.equals("")) {
			if(flag) {
				condition.append(" BETWEEN TO_DATE(NVL('");
				condition.append(var1);
				condition.append("',TO_CHAR(");
				condition.append(dbCol);
				condition.append(",'dd/mm/yyyy')),'dd/mm/yyyy') AND TO_DATE(NVL('");
				condition.append(var2);
				condition.append("',TO_CHAR(");
				condition.append(dbCol);
				condition.append(",'dd/mm/yyyy')),'dd/mm/yyyy')");
			}
			else {
				condition.append(" <= TO_DATE(NVL('");
				condition.append(var2);
				condition.append("',TO_CHAR(");
				condition.append(dbCol);
				condition.append(",'dd/mm/yyyy')),'dd/mm/yyyy')");
			}
		}
		else if(flag) {
			condition.append(" >= TO_DATE(NVL('");
			condition.append(var1);
			condition.append("',TO_CHAR(");
			condition.append(dbCol);
			condition.append(",'dd/mm/yyyy')),'dd/mm/yyyy')");
		}
		retVal = condition.toString();
		if(retVal != null && !retVal.equals("")) {
			retVal = addBeforeCondition + dbCol + retVal;
		}
		return retVal;
	}
	
	public static String getBetweenQryCriteriaNumeric(String dbCol, String var1, String var2, String addBeforeCondition)
	{
		StringBuilder condition = new StringBuilder();
		String retVal = "";
		boolean flag = false;

		if(var1 != null && !var1.equals("")) {
			flag = true;
		}
		if(var2 != null && !var2.equals("")) {
			if(flag) {
				condition.append(" BETWEEN ");
				condition.append(var1);
				condition.append(" AND ");
				condition.append(var2);
			}
			else {
				condition.append(" < ");
				condition.append(var2);
			} 
		}
		else if(flag) {
			condition.append(" > ");
			condition.append(var1);
		}
		retVal = condition.toString();
		if(retVal != null && !retVal.equals("")) {
			retVal = addBeforeCondition + dbCol + retVal;
		}
		return retVal;
	}
	
	/**
	 * Constructs the condition for where clause for the db column and the var value passed by checking for null condition for var
	 * Util method while building query with the parameters entered by user from GUI
	 * @param dbColumn (Eg:- recipient_id)
	 * @param var (Eg:- 123)
	 * @param addAnd (Eg:- true)
	 * @return String (Eg:-  AND recipient_id = '123')
	 */
	public static String buildWhrConditionWithNullCheck(String dbColumn, String var, boolean addAnd)
	{
		String condition = "";
		if(var != null && !var.equals("")) {
			if(addAnd) {
				condition = " AND ";
			}
			condition += dbColumn + " = '" + var + "'"; 
		}
		return condition;
	}
	
	public static String processInboundMessage(Map<String, String> params) throws Exception
	{
		Connection dbConn = null;
		CallableStatement cstmt = null;

		String statusMessage = null;
		String procCall = "{ CALL XHBUILDER.PROCESS_QUERY_MESSAGE(?,?,?,?,?,?,?,?,?,?,?,?) }";

		try
		{
			String message = params.get("message");
			dbConn = ConnectionManager.getConnection();
			cstmt = dbConn.prepareCall(procCall);
			cstmt.setString(1, params.get("APPLICATION_ID"));
			cstmt.setString(2, params.get("facilityID"));
			cstmt.setString(3, params.get("clientID"));					
			cstmt.setString(4, params.get("processID"));
			cstmt.setCharacterStream(5, new StringReader(message), message.length());		
			cstmt.setString(9, params.get("protocolLinkID"));

			cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(11,java.sql.Types.CLOB);
			cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
			cstmt.execute();
			
			statusMessage = cstmt.getString(12);
			if(statusMessage != null && !statusMessage.equals("")) {
				System.out.println("(XHUtil:processInboundMessage) Error - " + statusMessage);
			}
			else {
				statusMessage = "Success";
			}
		}
		catch(Exception exp) {
			throw exp;
		}
		finally {
			closeDBResources(null, cstmt, dbConn);
		}

		return statusMessage;
	}
	
	public static void updateInteractiveDetails(Map<String,String> params)
	{
		String procQuery = "{call XHINTERACTIVE.INTERACTIVE_INTERFAC_AUDIT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		Connection dbConn = null;
		CallableStatement cstmt = null;

		String message_id = "";

		try
		{
			dbConn = ConnectionManager.getConnection();
			cstmt = dbConn.prepareCall(procQuery);

			String msgID = XHUtil.singleParamExeQry("SELECT xh_interactive_integration_seq.nextval FROM dual");
			params.put("INTERACTIVE_TRX_NO",msgID);

			message_id = params.get("MSG_ID");

			cstmt.setString(1, "I");
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.setString(4, params.get("LOGIN_USER"));
			cstmt.setString(5, params.get("CLIENT_MACHINE"));
			cstmt.setString(6, params.get("CLIENT_MACHINE"));
			cstmt.setString(7, params.get("PGM_ID"));
			cstmt.setString(8, params.get("MODULE_ID"));
			cstmt.setString(9, params.get("SESSION_ID"));
			cstmt.setString(10, params.get("REQUEST_DATE"));
			cstmt.setString(11, params.get("REQUEST_TEXT"));
			cstmt.setString(12, params.get("APPLICATION_ID"));
			cstmt.setString(13, XHDBAdapter.isNullReplace(params.get("MSG_ID"), msgID));
			cstmt.setString(14, params.get("FACILITY_ID"));
			cstmt.setString(15, params.get("MESSAGE_DATE"));
			cstmt.setString(16, params.get("EVENT_TYPE"));
			cstmt.setString(17, params.get("PATIENT_ID"));
			cstmt.setString(18, "");
			cstmt.setString(19, params.get("EPISODE_TYPE"));
			cstmt.setString(20, params.get("ENCOUNTER_ID"));
			cstmt.setString(21, params.get("ACC_NO"));
			cstmt.setString(22, params.get("EXT_ACC_NO"));
			cstmt.setString(23, params.get("REQUEST_SYNTAX"));
			cstmt.setString(24, params.get("ACK_MSG_ID"));
			cstmt.setString(25, params.get("PROTOCOL_LINK_ID"));				
			cstmt.setString(26, XHDBAdapter.isNullReplace(params.get("ADDED_BY_ID"), params.get("LOGIN_USER")));
			cstmt.setString(27, XHDBAdapter.isNullReplace(params.get("ADDED_BY_DATE"), params.get("MESSAGE_DATE")));
			cstmt.setString(28, XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_ID"), params.get("LOGIN_USER")));
			cstmt.setString(29, XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_DATE"), params.get("MESSAGE_DATE")));
			cstmt.setString(30, params.get("CLIENT_MACHINE"));
			cstmt.setString(31, XHDBAdapter.isNullReplace(params.get("ADDED_BY_FACILITY"), params.get("FACILITY_ID")));
			cstmt.setString(32, params.get("CLIENT_MACHINE"));
			cstmt.setString(33, XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_FACILITY"), params.get("FACILITY_ID")));
			cstmt.setString(34, msgID);
			cstmt.setString(35, params.get("RESPONSE_TEXT"));
			cstmt.setString(36, params.get("RESPONSE_SYNTAX"));
			cstmt.setString(37, params.get("PROFILE"));
			cstmt.setString(38, params.get("ERROR_TEXT"));
			cstmt.setString(39, params.get("ACK_TEXT"));
			cstmt.setString(40, params.get("ACK_SYNTAX"));
			
			cstmt.execute();

			String errorCode = cstmt.getString(2);
			String errorMsg = cstmt.getString(3);
			
			if("S".equals(errorCode)) {
				dbConn.commit();
			}
			else {
				System.out.println("(XHUtil:updateInteractiveDetails) Error " + errorMsg);
			}
		}
		catch (Exception exp) {
			exp.printStackTrace(System.err);
			System.out.println("(XHUtil:updateInteractiveDetails) Exception " + exp);
		}
		finally {
			closeDBResources(null, cstmt, dbConn);
		}
	}
	
	public static void updateInteractiveDetails(String mode, Map<String, String> params) {
		
		String procQuery = "";
		Connection dbConn = null;
		CallableStatement cstmt = null;
		System.out.println("***Inside XHUtil - updateInteractiveDetails... ");

		try {
			
			String msgID ="";
			String errorCode = "";
			String errorMsg = "";
			
			if(mode != null && mode.equalsIgnoreCase("I"))	
			{
				msgID = XHUtil.singleParamExeQry("SELECT xh_interactive_integration_seq.nextval FROM dual");
				
				System.out.println("***Inside XHUtil - updateInteractiveDetails - msgID... " + msgID);
				
				params.put("INTERACTIVE_TRX_NO", msgID);
				
				procQuery = "{call XHINTERACTIVE.INTERACTIVE_INTERFAC_AUDIT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				dbConn = ConnectionManager.getConnection();
				cstmt = dbConn.prepareCall(procQuery);
				
				cstmt.setString(1, XHDBAdapter.isNullReplace(mode, "I"));
				cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
				cstmt.setString(4, params.get("LOGIN_USER"));
				cstmt.setString(5, params.get("CLIENT_MACHINE"));
				cstmt.setString(6, params.get("CLIENT_MACHINE"));
				cstmt.setString(7, params.get("PGM_ID"));
				cstmt.setString(8, params.get("MODULE_ID"));
				cstmt.setString(9, params.get("SESSION_ID"));
				cstmt.setString(10, params.get("REQUEST_DATE"));
				cstmt.setString(11, params.get("REQUEST_TEXT"));
				cstmt.setString(12, params.get("APPLICATION_ID"));
				cstmt.setString(13, XHDBAdapter.isNullReplace(params.get("MSG_ID"), msgID));
				cstmt.setString(14, params.get("FACILITY_ID"));
				cstmt.setString(15, params.get("MESSAGE_DATE"));
				cstmt.setString(16, params.get("EVENT_TYPE"));
				cstmt.setString(17, params.get("PATIENT_ID"));
				cstmt.setString(18, "");
				cstmt.setString(19, params.get("EPISODE_TYPE"));
				cstmt.setString(20, params.get("ENCOUNTER_ID"));
				cstmt.setString(21, params.get("ACC_NO"));
				cstmt.setString(22, params.get("EXT_ACC_NO"));
				cstmt.setString(23, params.get("REQUEST_SYNTAX"));
				cstmt.setString(24, params.get("ACK_MSG_ID"));
				cstmt.setString(25, params.get("PROTOCOL_LINK_ID"));
				cstmt.setString(26, XHDBAdapter.isNullReplace(params.get("ADDED_BY_ID"), params.get("LOGIN_USER")));
				cstmt.setString(27, XHDBAdapter.isNullReplace(params.get("ADDED_BY_DATE"), params.get("MESSAGE_DATE")));
				cstmt.setString(28, XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_ID"), params.get("LOGIN_USER")));
				cstmt.setString(29, XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_DATE"), params.get("MESSAGE_DATE")));
				cstmt.setString(30, params.get("CLIENT_MACHINE"));
				cstmt.setString(31, XHDBAdapter.isNullReplace(params.get("ADDED_BY_FACILITY"), params.get("FACILITY_ID")));
				cstmt.setString(32, params.get("CLIENT_MACHINE"));
				cstmt.setString(33, XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_FACILITY"), params.get("FACILITY_ID")));
				cstmt.setString(34, msgID);
				cstmt.setString(35, params.get("RESPONSE_TEXT"));
				cstmt.setString(36, params.get("RESPONSE_SYNTAX"));
				cstmt.setString(37, params.get("PROFILE"));
				cstmt.setString(38, params.get("ERROR_TEXT"));
				cstmt.setString(39, params.get("ACK_TEXT"));
				cstmt.setString(40, params.get("ACK_SYNTAX"));

				cstmt.execute();
				errorCode = cstmt.getString(2);
				errorMsg = cstmt.getString(3);
			}
			else if(mode != null && mode.equalsIgnoreCase("U"))
			{
				msgID = params.get("INTERACTIVE_TRX_NO");
				
				procQuery = "{call XHINTERACTIVE.XHINTERACTIVEUPD(?,?,?,?,?,?,?,?)}";
				dbConn = ConnectionManager.getConnection();
				cstmt = dbConn.prepareCall(procQuery);
				
				String status = "N";
				String response = params.get("RESPONSE_TEXT");
				
				cstmt.setString(1, params.get("PROFILE"));
				cstmt.setString(2, params.get("INTERACTIVE_TRX_NO"));
				cstmt.setString(3, params.get("PGM_ID"));

				if (response.contains("$|#")) {
					
					String[] arrRes = response.trim().split("\\$\\|\\#");
					
					status = arrRes[0];
					
					if (status.equals("F") || status.equals("E")) {
						status = "E";
						params.put("ERROR_TEXT", "Transaction declined, "+arrRes[1]);
					}
					
				} else {					
					params.put("ERROR_TEXT", response);
					response = "";
					status = "E";
				}

				System.out.println("***Inside XHUtil - updateInteractiveDetails - status... " + status);
				
				cstmt.setString(4, response);
				cstmt.setString(5, status);
				cstmt.setString(6, params.get("ERROR_TEXT"));
				cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(8, java.sql.Types.VARCHAR);
				
				cstmt.execute();
				errorCode = cstmt.getString(7);
				errorMsg = cstmt.getString(8);
			}
			
			if ("S".equals(errorCode)) {
				dbConn.commit();
			} else {
				System.out.println("(XHUtil:updateInteractiveDetails) Error " + errorMsg);
			}
		} catch (Exception exp) {
			exp.printStackTrace(System.err);
			System.out.println("(XHUtil:updateInteractiveDetails) Exception " + exp);
		} finally {
			closeDBResources(null, cstmt, dbConn);
		}
	}
	
	/**
	 * @return Input map param 'reqParams' will be added with audit params - LOGIN_USER, FACILITY_ID, CLIENT_MACHINE, SESSION_ID
	 */
	public static void addAuditParams(Map<String, String> reqParams, HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);

		if(session != null) {
			reqParams.put("LOGIN_USER", (String)session.getAttribute("login_user"));
			reqParams.put("FACILITY_ID", (String)session.getAttribute("facility_id"));
			reqParams.put("CLIENT_MACHINE", ((Properties) session.getAttribute("jdbc")).getProperty("client_ip_address"));
			reqParams.put("SESSION_ID", session.getId());
		}
	}
	
	public static void getMessageDelimiters(Map<String, String> messageDelimiters, String protocolLinkID, Connection dbConn)
	{
		String sqlProcedure = "call xhstandard.XH_STANDARD_SPECIAL_CHAR(?,?,?,?,?,?,?)";
		try {
			if(dbConn == null) dbConn = ConnectionManager.getConnection();
			CallableStatement callableStatement = dbConn.prepareCall(sqlProcedure);
				
			callableStatement.setString(1, protocolLinkID);
			callableStatement.registerOutParameter(2,java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3,java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(4,java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(5,java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(6,java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(7,java.sql.Types.VARCHAR);
			callableStatement.execute();

			messageDelimiters.put("messageStart", formatAsciiToString(callableStatement.getString(2)));
			messageDelimiters.put("messageEnd", formatAsciiToString(callableStatement.getString(3)));
			messageDelimiters.put("segmentStart", formatAsciiToString(callableStatement.getString(4)));
			messageDelimiters.put("segmentEnd", formatAsciiToString(callableStatement.getString(5)));
			messageDelimiters.put("fieldSeperator", formatAsciiToString(callableStatement.getString(6)));
			messageDelimiters.put("standardCode", callableStatement.getString(7));
		}
		catch(Exception exception) {
			System.out.println("(XHUtil:getMessageDelimiters) Exception - " + exception);
			exception.printStackTrace(System.err);
		}
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
	
		if(asciiNumber != null) {
		    StringTokenizer tokenizer = new StringTokenizer(asciiNumber,"|");
	
		    while(tokenizer.hasMoreTokens()) {
				tempAsciiNo = Integer.parseInt(tokenizer.nextToken());
				delimiter.append(((char)tempAsciiNo));
		    }
		    retValue = delimiter.toString();
		}
		return retValue;
    }

	public static void addAuditInfo(Map<String,String> requestParams, HttpServletRequest request)
	{
		List<String> auditInfo = ArrayAuditInfo.getArrayAuditInfo(request.getSession(false));
		if(auditInfo != null && !auditInfo.isEmpty())
		{
			requestParams.put("LOGIN_USER", auditInfo.get(0));
			requestParams.put("CLIENT_MACHINE", requestParams.get("roomNo"));
			requestParams.put("FACILITY_ID", auditInfo.get(2));
		}
		requestParams.put("sessionID", request.getSession(false).getId());
	}
	
	/**
	 * @return userDtls - Includes keys LOGIN_USER, USER_PASSWORD
	 */
	public static HashMap<String, String> getEMUserIDPwd(HttpServletRequest request)
	{
		HashMap<String, String> userDtls = new HashMap<String, String>();
		HttpSession session = request.getSession(false);

		if(session != null) {
			Properties sessionProperties = (Properties) session.getAttribute("jdbc");
			userDtls.put("LOGIN_USER", sessionProperties.getProperty("login_user"));
			userDtls.put("USER_PASSWORD", sessionProperties.getProperty("login_password"));
		}
		return userDtls;
	}
	
	public static void closeResourse(Closeable stream) {
		if(stream != null) {
			try {
				stream.close();
			}
			catch(Exception exp) {
			}
		}
	}
	
	public static String bytesToHex(byte[] bytes) {
		char[] hexArray = "0123456789ABCDEF".toCharArray();
		char[] hexChars = new char[bytes.length * 2];
		for ( int j = 0; j < bytes.length; j++ ) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}
	
	public static String hexToASCII(String hexValue)
	{
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < hexValue.length(); i += 2) {
			String str = hexValue.substring(i, i + 2);
			output.append((char) Integer.parseInt(str, 16));
		}
		return output.toString();
	}
	
	public static String getIPByHostname(String hostName) throws Exception {
		InetAddress inetAddr = InetAddress.getByName(hostName);
		byte[] addr = inetAddr.getAddress();
		// Convert to dot representation
		String ipAddr = "";
		for (int i = 0; i < addr.length; i++) {
			if (i > 0) {
				ipAddr += ".";
			}
			ipAddr += addr[i] & 0xFF;
		}
		return ipAddr;
	}

	public static String insertInboundMessageDetails(Map<String,String> params)
	{
		String insertstmt = "INSERT INTO XI_INBOUND_MESSAGE (application_id, facility_id, message_id, srl_no, message_received_date, process_id, "
									+" client_id, inbound_message_text, message_ack_text, message_status, rd_order_yn, "
									+" added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, "
									+" patient_id, merged_patient_id, episode_type, episode_id, visit_id, accession_num, action_type, "
									+" last_proc_date, event_status, not_req_reason, ext_accession_num, event_type, protocol_link_id) "
							+" VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";                       
                        
		Connection dbConn = null;
		PreparedStatement pstmt = null;

		int insertCount = 0;

		String msgID = "";

		String l_date = "", l_sys_date = "";

		String l_err_code = "S", l_err_msg = "Success";


		try
		{
			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(insertstmt);

			/*

			msgID = XHUtil.singleParamExeQry("SELECT XI_INBOUND_MESSAGE_SEQ.nextval FROM dual");
			params.put("MSG_ID",msgID);

			*/

			l_date =  params.get("REQUEST_DATE");

				
			pstmt.setString(1, params.get("APPLICATION_ID"));
			pstmt.setString(2, params.get("FACILITY_ID"));
			pstmt.setString(3, params.get("MSG_ID"));
			pstmt.setString(4, params.get("SRL_NO")); //SRL_NO
			pstmt.setTimestamp(5, new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(6, XHDBAdapter.isNullReplace(params.get("PROCESS_ID"),"")); // PROCESS_ID

			pstmt.setString(7, XHDBAdapter.isNullReplace(params.get("CLIENT_ID"),"")); // CLIENT_ID
			pstmt.setString(8, params.get("MESSAGE_TEXT")); //INBOUND_MESSAGE_TEXT
			pstmt.setString(9, XHDBAdapter.isNullReplace(params.get("MESSAGE_ACK_TEXT"),"")); // MESSAGE_ACK_TEXT
			pstmt.setString(10, XHDBAdapter.isNullReplace(params.get("MESSAGE_STATUS"),"")); // MESSAGE_STATUS
			pstmt.setString(11, XHDBAdapter.isNullReplace(params.get("RD_ORDER_YN"),"")); // RD_ORDER_YN

			pstmt.setString(12, XHDBAdapter.isNullReplace(params.get("ADDED_BY_ID"), params.get("LOGIN_USER")));
			pstmt.setTimestamp(13, new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(14, params.get("CLIENT_MACHINE"));
			pstmt.setString(15, XHDBAdapter.isNullReplace(params.get("ADDED_BY_FACILITY"), params.get("FACILITY_ID")));

			pstmt.setString(16, XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_ID"), params.get("LOGIN_USER")));
			pstmt.setTimestamp(17, new  java.sql.Timestamp(System.currentTimeMillis()));		
			pstmt.setString(18, params.get("CLIENT_MACHINE"));
			pstmt.setString(19, XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_FACILITY"), params.get("FACILITY_ID")));
			
			pstmt.setString(20, XHDBAdapter.isNullReplace(params.get("PATIENT_ID"),""));
			pstmt.setString(21, XHDBAdapter.isNullReplace(params.get("MERGED_PATIENT_ID"),""));
			pstmt.setString(22, XHDBAdapter.isNullReplace(params.get("EPISODE_TYPE"),""));
			pstmt.setString(23, XHDBAdapter.isNullReplace(params.get("EPISODE_ID"),""));
			pstmt.setString(24, XHDBAdapter.isNullReplace(params.get("VISIT_ID"),""));
			pstmt.setString(25, XHDBAdapter.isNullReplace(params.get("ACCESSION_NUM"),""));
			pstmt.setString(26, XHDBAdapter.isNullReplace(params.get("ACTION_TYPE"),""));

			pstmt.setString(27, XHDBAdapter.isNullReplace(params.get("LAST_PROC_DATE"),""));
			pstmt.setString(28, XHDBAdapter.isNullReplace(params.get("EVENT_STATUS"),""));
			pstmt.setString(29, XHDBAdapter.isNullReplace(params.get("NOT_REQ_REASON"),""));
			pstmt.setString(30, XHDBAdapter.isNullReplace(params.get("EXT_ACCESSION_NUM"),""));
			pstmt.setString(31, XHDBAdapter.isNullReplace(params.get("EVENT_TYPE"),""));
			pstmt.setString(32, XHDBAdapter.isNullReplace(params.get("PROTOCOL_LINK_ID"),""));			
			
			insertCount = pstmt.executeUpdate();

			if (insertCount == 1)
			{
				dbConn.commit();				
			}
			else
			{
				dbConn.rollback();	
			}

			return l_err_code + "$!^"+ l_err_msg;

		}
		catch (Exception exp) {
			l_err_code = "E";
			l_err_msg = "Error in "+exp.getMessage();
			exp.printStackTrace(System.err);
			System.out.println("(XHUtil:insertInboundMessageDetails) Exception " + exp);
			return l_err_code + "$!^"+ l_err_msg;
		}
		finally {
			closeDBResources(null, pstmt, dbConn);
		}
	}

	public static String getHospitalNo(String l_facility_id)
	{
		String l_hospital_no = "";
		Connection dbConn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		try
		{
			dbConn = ConnectionManager.getConnection();

			stmt = dbConn.createStatement();
			rs = stmt.executeQuery("Select LICENSE_NO,FACILITY_NAME from sm_facility_param where facility_id ='"+l_facility_id+"'");
			if(rs.next())
			{
				l_hospital_no = XHDBAdapter.checkNull((String)rs.getString("LICENSE_NO"));
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(dbConn != null) ConnectionManager.returnConnection(dbConn);
			}
			catch(Exception fexp)
			{
				fexp.printStackTrace(System.err);
			}
		}
		return l_hospital_no;
	}

	public String transformData(String xmlIn, String xsl)
            throws TransformerConfigurationException,
            TransformerException
	{
		String outputHTML = "";
		try
		{
			StreamSource xslSource = new StreamSource(new StringReader(xsl));
			StreamSource xmlInSource = new StreamSource(new StringReader(xmlIn));
			Transformer tf = TransformerFactory.newInstance().newTransformer(xslSource);
			StringWriter xmlOutWriter = new StringWriter();
			tf.transform(xmlInSource, new StreamResult(xmlOutWriter));
			outputHTML = xmlOutWriter.toString();
		}
		catch(Exception e){
		  return e.getMessage();
		}
		return outputHTML;
	}

	public static String readFile(String filename) {

		String content = "";
		try {

			File file = new File(filename);
			FileInputStream fis = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fis.read(data);
			fis.close();
			String strData=new String(data, "UTF-8"); // converting byte array to string
			content = strData;

		}
		catch (FileNotFoundException fne) {
			System.err.println("Unable to find the file: fileName");
			System.out.println("XHUtil::::fieldValueFetchMethod exception..."+fne.getMessage());
		} catch (IOException ioe) {
			System.err.println("Unable to read the file: fileName");
			System.out.println("XHUtil::::fieldValueFetchMethod exception..."+ioe.getMessage());
		}
		catch (Exception e) {
			System.err.println("Unable to read the file: fileName");
			System.out.println("XHUtil::::fieldValueFetchMethod exception..."+e.getMessage());
		}

		return content;
	}

	public static String getNationalID(String patient_id)
	{
		String l_natinal_id = "",l_status = "",l_trans_id = "";
		Connection dbConn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";

		boolean isAADHAAREnabledYN =false;
		boolean chkAadhaarValidate = false;

		try
		{
			dbConn = ConnectionManager.getConnection();
			chkAadhaarValidate = eCommon.Common.CommonBean.isSiteSpecific(dbConn, "MP","AADHAAR_PROFILE");
			query = "select PATIENT_ID, NATIONAL_ID_NO";
			if (chkAadhaarValidate){
				query += ", AADHAAR_CARD_STATUS, AADHAAR_TRANS_ID";
			}
			query += " from mp_patient where PATIENT_ID ='"+patient_id+"'";
			//System.out.println("::XHUtil query ::"+query);
			stmt = dbConn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) 
			{
				l_natinal_id = XHDBAdapter.checkNull((String)rs.getString("NATIONAL_ID_NO"));
				if (chkAadhaarValidate)
				{
					l_status = XHDBAdapter.checkNull((String)rs.getString("AADHAAR_CARD_STATUS"));
					l_trans_id = XHDBAdapter.checkNull((String)rs.getString("AADHAAR_TRANS_ID"));
				}
			}

			if (chkAadhaarValidate && l_status.equals("Y"))
			{
				l_natinal_id = getTransId(dbConn,l_trans_id);
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(dbConn != null) ConnectionManager.returnConnection(dbConn);
			}
			catch(Exception fexp)
			{
				fexp.printStackTrace(System.err);
			}
		}

		return l_natinal_id;
	}
		
	public static String getTransId(Connection con, String request_id){
		PreparedStatement pstmt		= null;
		ResultSet rs				= null;
		String query = "";
		String trans_id = "";
		try{

			query ="select app_password.decrypt (TRANS_NO) TRANS_NO from XH_TRANS_REQUEST where REQUEST_ID=?";
			pstmt	= con.prepareStatement(query);
			pstmt.setString(1,request_id);
			rs		= pstmt.executeQuery();

			while(rs != null && rs.next())
			{
				trans_id = rs.getString("TRANS_NO");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			try
			{
				if(pstmt!=null) pstmt.close();					
				if(rs !=null) rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		return trans_id;
	}

	public static String FetchStdCntrlSegMethod(String segmentID, String elementId, String standardCode){

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		boolean isDebugYN = false; 

		isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

		l_app_msg = " ::: Inside FetchStdCntrlSegMethod ::: ";
		if (isDebugYN) System.out.println(l_app_msg);	

		l_app_msg = " ::: Segment ID : "+ segmentID + " ::: Element ID : " + elementId + " ::: Standard Code : "+ standardCode;
		if (isDebugYN) System.out.println(l_app_msg);	
		
		try
		{
			dbConn =  ConnectionManager.getConnection();
			query = "SELECT NVL(DEFAULT_VALUE,'X') DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG " 
						+ " WHERE SEGMENT_ID = ? "
						+ " AND STANDARD_CODE = ? "
						+ " AND ELEMENT_ID = ? ";

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, segmentID);
			pstmt.setString(2, standardCode);
			pstmt.setString(3, elementId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_field_value = rs.getString("DEFAULT_VALUE");
			}

			l_app_msg = " ::: Retrieving "+ elementId + " Value..."+l_field_value;
			if (isDebugYN) System.out.println(l_app_msg);	

			
		}
		catch(Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}
		finally
		{			
			closeDBResources(rs, pstmt, dbConn);
		}		

		return l_field_value;
	}
	
//Added By Niveditha for taking DEBUG(Y/N) from XH_PROTOCOL_LINK table on 14/08/2020
	public static String FetchProtocollinkMethod(String protocollinkId) throws Exception{

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		String p_field_value ="";
		String sqlquery = "";
		
		try
		{
			connection =  ConnectionManager.getConnection();
			pstmt = connection.prepareStatement("SELECT DEBUG_YN FROM XH_PROTOCOL_LINK WHERE PROTOCOL_LINK_ID=?");

			pstmt.setString(1,protocollinkId);
			resultSet = pstmt.executeQuery() ;

			while(resultSet.next())
			{
			   p_field_value = resultSet.getString("DEBUG_YN");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally {
			//pstmt.close(); 
			//resultSet.close();	
			closeDBResources(resultSet, pstmt, connection);		
		}
		return p_field_value;
	}	
	
}
