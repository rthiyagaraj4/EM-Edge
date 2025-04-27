/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMP;

import java.sql.*;
import java.util.*;
import java.io.*;
import java.text.*;

import webbeans.eCommon.*;

/**
 * Class contains all the utlity methods necessary for DLA Interface.
 * Contains methods for getting SQL Server Connection and closing the connection
 */

public class DLAInterfaceUtil
{
	private static String dbURL = "jdbc:sqlserver://localhost:1433;databasename=DLATest1;";
//	private static String serverName= "localhost";
//	private static String portNumber = "1433";
//	private static String databaseName= "DLATest";
	//private static String dbUsername = "sa";
	//private static String dbPassword = "ibaehis";
	private static String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String dbUsername = "";
	private static String dbPassword = "";


	/*
		SQL Server useful queries

		select * from req_patient - Table in which new DLA request will be inserted
		delete req_patient
		select * from patient - Table in which data will be placed from DLA for a new reuqest
		delete patient where title='MR'
		update req_patient set req_status='Y'
		UPDATE req_patient SET req_purge='Y' WHERE req_comp_name='indbgl-w00169' AND req_search='3330301012573' AND req_date='2008-08-13 09:28:39.777'
		select serverproperty('ProductLevel')
		select serverproperty('Productversion')
		INSERT INTO patient(pid,title,dob,fname,lname,dead_status,dead_discharge) VALUES ('2234234234234','MR','25180416','Mathew','H','','');
	*/

	private static Properties prop;

	private static final String sqlDBSearchByNationalID		= "SELECT pid,fname,lname,dob,si_nat,nat,si_father_name,si_mother_name,NULL,si_sex,dead_status,dead_discharge,title,si_prov_code,si_present_address,si_present_address1,si_present_address2,si_present_address3,si_present_address4,sex,mname FROM patient WHERE req_comp_name = ? AND pid = ?"; 
	private static final String sqlDBSearchByName			= "SELECT pid,fname,lname,dob,si_nat,nat,si_father_name,si_mother_name,NULL,si_sex,dead_status,dead_discharge,title,si_prov_code,si_present_address,si_present_address1,si_present_address2,si_present_address3,si_present_address4,sex,mname FROM patient WHERE req_comp_name = ?"; 
//	private static final String oracleDBSearchByNationalID	= "SELECT distinct mp.national_id_no,mp.FIRST_NAME_LOC_LANG,mp.FAMILY_NAME_LOC_LANG,TO_CHAR(mp.date_of_birth,'DD/MM/YYYY'),mc.country_code,NULL,mo.ADDL_FIELD3,mo.ADDL_FIELD4,null,mp.sex,mp.deceased_yn,mp.deceased_date,mp.name_prefix,mr.RES_AREA_CODE,mr.SHORT_DESC,ma.ADDR1_LINE1,ma.ADDR1_LINE2,ma.ADDR1_LINE3,ma.ADDR1_LINE4,mp.patient_id,mp.NAME_PREFIX_LOC_LANG FROM mp_patient mp,mp_country_lang_vw mc,mp_res_area_lang_vw mr,MP_PAT_OTH_DTLS mo,MP_PAT_ADDRESSES ma WHERE NATIONAL_ID_NO = ?  AND mp.NATIONALITY_CODE=mc.COUNTRY_CODE AND mp.patient_id=mo.patient_id(+) AND mp.RES_AREA_CODE=mr.RES_AREA_CODE(+) AND mp.PATIENT_ID=ma.patient_id(+)"; 
//	private static final String oracleDBSearchByName		= "SELECT distinct mp.national_id_no,mp.FIRST_NAME_LOC_LANG,mp.FAMILY_NAME_LOC_LANG,TO_CHAR(mp.date_of_birth,'DD/MM/YYYY'),mc.country_code,NULL,mo.ADDL_FIELD3,mo.ADDL_FIELD4,null,mp.sex,mp.deceased_yn,mp.deceased_date,mp.name_prefix,mr.RES_AREA_CODE,mr.SHORT_DESC,ma.ADDR1_LINE1,ma.ADDR1_LINE2,ma.ADDR1_LINE3,ma.ADDR1_LINE4,mp.patient_id,mp.NAME_PREFIX_LOC_LANG FROM mp_patient mp,mp_country_lang_vw mc,mp_res_area_lang_vw mr,MP_PAT_OTH_DTLS mo,MP_PAT_ADDRESSES ma WHERE mp.FIRST_NAME_LOC_LANG LIKE ? AND mp.FAMILY_NAME_LOC_LANG LIKE ?  AND mp.NATIONALITY_CODE=mc.COUNTRY_CODE AND mp.patient_id=mo.patient_id(+) AND mp.RES_AREA_CODE=mr.RES_AREA_CODE(+) AND mp.PATIENT_ID=ma.patient_id(+)";
	
	private static final String oracleDBSearchByNationalID	= "SELECT mp.national_id_no,PATIENT_ID FROM mp_patient mp WHERE NATIONAL_ID_NO = ?" ; 
	private static final String oracleDBSearchByName		= "SELECT distinct mp.national_id_no,mp.FIRST_NAME_LOC_LANG,mp.FAMILY_NAME_LOC_LANG,TO_CHAR(mp.date_of_birth,'DD/MM/YYYY'),mc.country_code,NULL,mo.ADDL_FIELD3,mo.ADDL_FIELD4,null,mp.sex,mp.deceased_yn,mp.deceased_date,mp.name_prefix,mr.RES_AREA_CODE,mr.SHORT_DESC,ma.ADDR1_LINE1,ma.ADDR1_LINE2,ma.ADDR1_LINE3,ma.ADDR1_LINE4,mp.patient_id,mp.NAME_PREFIX_LOC_LANG FROM mp_patient mp,mp_country_lang_vw mc,mp_res_area_lang_vw mr,MP_PAT_OTH_DTLS mo,MP_PAT_ADDRESSES ma WHERE mp.FIRST_NAME_LOC_LANG LIKE ? AND mp.FAMILY_NAME_LOC_LANG LIKE ?  AND mp.NATIONALITY_CODE=mc.COUNTRY_CODE AND mp.patient_id=mo.patient_id(+) AND mp.RES_AREA_CODE=mr.RES_AREA_CODE(+) AND mp.PATIENT_ID=ma.patient_id(+)";

	static Connection oracleConnection;

	public DLAInterfaceUtil()
	{
		
	}
	/**
     * Returns SQLServer data base connection.
	 * Methods takes Oracle DB Connection as input argument and 
	 * gets the SQLServer setting details from the oracle table.
     */
	public static Connection getConnection(String path)
	{
		
		java.sql.Connection  dbConnection = null;

		getSQLServerDBDetails(path);		
		

		try
		{
			
			Class.forName(driverClass); 
			
			dbConnection = java.sql.DriverManager.getConnection(dbURL,dbUsername,dbPassword);			
		}																			    
		catch(Exception connectionException)
		{
			connectionException.printStackTrace(System.err);
		}
		return dbConnection;
	}

	// Retrieves SQL Server DB details from ini file
	public static int getSQLServerDBDetails(String path)
	{
		
		prop = new Properties();
		Connection oraConn = null;
		Statement stmt = null;
		ResultSet rs = null;

		int sleepParam = 5;

		String query = "SELECT * FROM XH_INTERACTIVE_CONNECT_PARAM WHERE plugin_type='DLA'";

		try
		{	
			oraConn = ConnectionManager.getConnection();
			stmt = oraConn.createStatement();
			rs = stmt.executeQuery(query);

			if(rs.next())
			{
			/*	serverName = rs.getString("server");
				portNumber = rs.getString("port");
				databaseName = rs.getString("database");
				dbUsername = rs.getString("username");
				dbPassword = rs.getString("password");
			*/	
				dbURL = rs.getString("DB_CONNECT_STRING");
				dbUsername = rs.getString("User_name");
				dbPassword = rs.getString("Password");
				driverClass = rs.getString("Database_Driver");
				String sleepInterval = rs.getString("sleepinterval");
				if(sleepInterval != null)	sleepParam = Integer.parseInt(sleepInterval);
				else sleepParam = 5;
			}		

		//	dbURL = "jdbc:sqlserver://"+serverName+":"+portNumber+";databasename="+databaseName+";CodePageOverride=Cp1256";
			
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
				if(oraConn != null) ConnectionManager.returnConnection(oraConn);
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}

		}
		return sleepParam;
	}

	/**
	* Closes DB Connection.
	**/
	public static void closeConnection(Connection sqlServerCon)
	{
		try
		{
			
			if(sqlServerCon != null)
			{				
				sqlServerCon.close();
				
			}
		}
		catch(Exception sqlException)
		{
			sqlException.printStackTrace(System.err);
		}
	}

	public static String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}

	public static String getOracleDBQueryByNationalID()
	{
		return oracleDBSearchByNationalID;
	}
	public static String getOracleDBQueryByName()
	{
		return oracleDBSearchByName;
	}
	public static String getSqlDBQueryByNationalID()
	{
		return sqlDBSearchByNationalID;
	}
	public static String getSqlDBSearchByName()
	{
		return sqlDBSearchByName;
	}

	public static int getAge(java.util.Date dateOfBirth)
	{		
		Calendar dob = Calendar.getInstance();	
		dob.setTime(dateOfBirth);	
		Calendar today = Calendar.getInstance();	
		int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);	
		if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))		
			age--;	
		
		return age;
	}

	/**
	*  Method converts the given date in string to java.util.Date with the specified dateFormat
	*	@param strDate string that has to be converted to date 
	*	@param dateFormat indicates in which format the converted date has to be 
	**/
	public static java.util.Date convertToDate(String strDate,String dateFormat)
	{
		SimpleDateFormat simpleDateFormat = null;
		java.util.Date date = null;
		try
		{			
			simpleDateFormat = new SimpleDateFormat(dateFormat);			
			date = simpleDateFormat.parse(strDate);
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		return date;
	}
	/**
	*  Method returns java.util.Date in the specified string format
	**/
	public static String getFormattedStringDate(String format,java.util.Date date)
	{	
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		String dateFormatted = dateFormat.format(date);
		return dateFormatted;
	}

	public static String getLocaleBasedDOB(java.util.Date date,String locale)
	{
		ResultSet rs = null;
		Connection conn = null;
		String retDate = "";
		String callableStmt = "{call get_locale_date.convert_to_locale_date(?,?,?) }";
		CallableStatement callableStatement = null;

		try
		{
			conn = ConnectionManager.getConnection();

			callableStatement = conn.prepareCall(callableStmt);

			callableStatement.setDate(1,new java.sql.Date(date.getTime()));
			callableStatement.setString(2,locale);
			callableStatement.registerOutParameter(3,java.sql.Types.VARCHAR);
			callableStatement.execute();

		//	String query = "SELECT Convert_To_Greg_Date_F("+date+",'"+locale+"') FROM dual";			

			retDate = callableStatement.getString(3);
			
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
				if(callableStatement != null) callableStatement.close();
				if(conn != null) ConnectionManager.returnConnection(conn);
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}
		return retDate;
	}

	public static String convertDateToString(java.util.Date strDate,String dateFormat)
	{
		SimpleDateFormat simpleDateFormat = null;
		String date = null;
		try
		{			
			simpleDateFormat = new SimpleDateFormat(dateFormat);			
			date = simpleDateFormat.format(strDate);
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		return date;
	}
	public static List getMessageDelimiters()
	{
		Connection oraConnection = null;
		CallableStatement callableStatement = null;

		StringTokenizer tokens = null;
		String symbolString = "";
		String tok = "";

		ArrayList list = null;

		try
		{
			if(oraConnection == null) oraConnection = ConnectionManager.getConnection();

			callableStatement = oraConnection.prepareCall("{ call XHSTANDARD.Fetch_standard_Control_Char(?,?,?) }");
			callableStatement.setString(1,"DLAP");
			callableStatement.registerOutParameter(2,java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3,java.sql.Types.VARCHAR);
			callableStatement.execute();

			symbolString = callableStatement.getString(3);			

			if(symbolString != null)
			{
				tokens = new StringTokenizer(symbolString,"{{{");
				list = new ArrayList();
				while(tokens.hasMoreTokens())
				{	
					tok = formatDelimiters(String.valueOf(tokens.nextToken()));
					
					list.add(tok);
				}
				
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
			if(callableStatement != null) callableStatement.close();
			if(oraConnection != null) ConnectionManager.returnConnection(oraConnection);
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}
		return list;
	}
	public static String formatDelimiters(String message)
	{
		StringBuffer temp = null;
		StringTokenizer	tokenizer = null;
		int temp1 = 0;

		try
		{
			temp = new StringBuffer();
			tokenizer = new StringTokenizer(message,"|");
			while(tokenizer.hasMoreTokens())
			{
				temp1 = Integer.parseInt(tokenizer.nextToken());
				temp.append(((char)temp1));
			}
			message = temp.toString();
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		return message;
	}
	public static String getDescFromCode(String query)
	{
		Connection oraConn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String result = "";

		try
		{
			oraConn = ConnectionManager.getConnection();
			stmt = oraConn.createStatement();
			rs = stmt.executeQuery(query);

			if(rs.next())
			{
				result = rs.getString(1);
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
				if(oraConn != null) ConnectionManager.returnConnection(oraConn);
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}
		return result;
	}

	public static String convert_to_greg_date(java.sql.Date sqlDate,String locale)
	{
		Connection oraConn = null;
		CallableStatement  call_1 = null;

		String strDate = null;
		String convertToGregorian = "{call get_locale_date.CONVERT_TO_GREG_DATE(?,?,?) }";
		try
		{
			oraConn = ConnectionManager.getConnection();
			call_1 = oraConn.prepareCall(convertToGregorian);		
			call_1.registerOutParameter(3,java.sql.Types.DATE);
			call_1.setDate(1,sqlDate);
			call_1.setString(2,locale);
			call_1.execute();

			strDate = call_1.getDate(3).toString();
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			try
			{
				if(call_1 != null) call_1.close();
				if(oraConn != null) ConnectionManager.returnConnection(oraConn);
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}
		return strDate;
	}

	public static String convert_to_locale_date(java.sql.Date sqlDate,String locale)
	{
		Connection oraConn = null;
		CallableStatement  call_1 = null;

		String strDate = null;
		String convertToLocaleDate = "{call get_locale_date.CONVERT_TO_LOCALE_DATE(?,?,?) }";
		try
		{
			oraConn = ConnectionManager.getConnection();
			call_1 = oraConn.prepareCall(convertToLocaleDate);		
			call_1.registerOutParameter(3,java.sql.Types.DATE);
			call_1.setDate(1,sqlDate);
			call_1.setString(2,locale);
			call_1.execute();

			strDate = call_1.getDate(3).toString();
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			try
			{
				if(call_1 != null) call_1.close();
				if(oraConn != null) ConnectionManager.returnConnection(oraConn);
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}
		return strDate;
	}

	/**
	*  Method Calculates age.
	**/
	public static int calculate_age(String ageCal)
	{
		Connection oraConn = null;
		CallableStatement  call_1 = null;
		
		String calculateAgeProc = "{ ? = call calculate_age(?,?) }";

		int age = 0;

		try
		{
			
			oraConn = ConnectionManager.getConnection();
			call_1 = oraConn.prepareCall(calculateAgeProc);		
			call_1.registerOutParameter(1,java.sql.Types.INTEGER);		
			call_1.setString(2,ageCal);
			call_1.setInt(3,1);
			call_1.execute();
			age = call_1.getInt(1);
			
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			try
			{
				if(call_1 != null) call_1.close();
				if(oraConn != null) ConnectionManager.returnConnection(oraConn);
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}
		return age;
	}

	/**
	*  Utility Method converts string date in one format to string date in other specified format
	**/
	public static String convertStringDateFormats(String strDate,String srcDateFormat,String destDateFormat)
	{
		String returnDate = "";
		try
		{
			SimpleDateFormat srcSimpleDateFormat = new SimpleDateFormat(srcDateFormat);
			java.util.Date date = srcSimpleDateFormat.parse(strDate);
			SimpleDateFormat destSimpleDateFormat = new SimpleDateFormat(destDateFormat);
			returnDate = destSimpleDateFormat.format(date);
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		return returnDate;
	}
	/**
	*  Method updates the purge status for record in req_patient in SQL Server.
	**/
	public static void updatePurgeStatus(String today_datetime,String machineName,String req_search)
	{		
		PreparedStatement stmt = null;
		Connection sqlServerConn = null;
		
		try
		{
			sqlServerConn = DLAInterfaceUtil.getConnection("string");				
			machineName = machineName+"/"+today_datetime;
			
			String query = "UPDATE req_patient SET req_purge='Y' WHERE req_comp_name='"+machineName+"' AND req_search LIKE ?";
			stmt = sqlServerConn.prepareStatement(query);
			stmt.setString(1,req_search+"%");
			
			stmt.executeUpdate();			
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			try
			{
				if(stmt != null) stmt.close();
				if(sqlServerConn != null) sqlServerConn.close();
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}
	}

	/**
	*  Method retrieves image from oracle/SQL Server based on isFromOracleDB parameter 
	*  and copies the image in classes folder.
	**/
	public static String retImage(String nationalID,boolean isFromOracle,String imgpath)
	{
		String sqlserver_query = "SELECT img_autodisp FROM patient WHERE pid='"+nationalID+"'";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		InputStream imgStream = null;
		FileOutputStream outFile = null;

		byte[] buff	  = null;

		try
		{
			con = DLAInterfaceUtil.getConnection("path");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlserver_query);

			if(rs.next())
			{
				imgStream = rs.getBinaryStream("photo");
			}
			
			if(imgStream != null)
			{
				outFile = new FileOutputStream(imgpath+nationalID+".jpg");
				buff = new byte[32*1024]; 
				int len = 0 ;
				while ((len=imgStream.read( buff ))!=-1 )
				{					
					outFile.write(buff,0,len); 
				}
				outFile.close();
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
				if(con != null) con.close();
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}

		return imgpath;
	}

	/**
	 * Method to convert the sqlDate to thai date for leap year.
	 */
	public static String convert_to_greg_date_2t(String sqlDate,String locale,String dateFormat)
	{
		Connection oraConn = null;
		CallableStatement  call_1 = null;

		String strDate = null;
		String convertToGregorian = "{call get_locale_date_2t.CONVERT_TO_GREG_DATE(?,?,?,?) }";
		try
		{			
			oraConn = ConnectionManager.getConnection();
			call_1 = oraConn.prepareCall(convertToGregorian);		
			call_1.registerOutParameter(3,java.sql.Types.DATE);
			call_1.setString(1,sqlDate);
			call_1.setString(2,locale);
			call_1.setString(4,dateFormat);
			call_1.execute();
			
			strDate = call_1.getDate(3).toString();
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			try
			{
				if(call_1 != null) call_1.close();
				if(oraConn != null) ConnectionManager.returnConnection(oraConn);
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}
		return strDate;
	}
	
	/**
	 * Method retrieves middle name prompt from MP_PARAM_LANG_VW
	 */
	public static String getMiddleNamePrompt(String locale)
	{
		String query = "SELECT SECOND_NAME_PROMPT,SECOND_NAME_LOC_LANG_PROMPT FROM MP_PARAM_LANG_VW WHERE MODULE_ID='MP' AND LANGUAGE_ID='"+locale+"'";
		String retVal = "Middle Name"; // By default sending it as middle name
		
		Connection oraConn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try
		{
			oraConn = ConnectionManager.getConnection();
			stmt = oraConn.createStatement();
			rs = stmt.executeQuery(query);

			if(rs.next())
			{
				if(locale != null && locale.equalsIgnoreCase("th")) retVal = rs.getString(2);
				else if(locale != null && locale.equalsIgnoreCase("en")) retVal = rs.getString(1);
			}
			
			if(retVal == null || retVal.equals("null"))
			{
				java.util.Locale loc = new java.util.Locale(locale);
				java.util.ResourceBundle labels = java.util.ResourceBundle.getBundle( "eMP.resources.Labels",loc);
				retVal = labels.getString("eMP.MiddleName.label");				
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
				if(oraConn != null) ConnectionManager.returnConnection(oraConn);
			}
			catch(Exception fexp)
			{
				fexp.printStackTrace(System.err);
			}
		}
		return retVal;
	}

	/**
	 * Method retrieves name prompt from MP_PARAM_LANG_VW
	 */
	public static String getLabelPrompt(String locale, String reqLabel)
	{
		String query = "SELECT FAMILY_NAME_PROMPT,FAMILY_NAME_LOC_LANG_PROMPT,FIRST_NAME_PROMPT,FIRST_NAME_LOC_LANG_PROMPT FROM MP_PARAM_LANG_VW WHERE MODULE_ID='MP' AND LANGUAGE_ID='"+locale+"'";
		String retVal = null; // By default sending it as middle name
		
		Connection oraConn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try
		{
			oraConn = ConnectionManager.getConnection();
			stmt = oraConn.createStatement();
			rs = stmt.executeQuery(query);

			if(rs.next())
			{
				if(locale != null && locale.equalsIgnoreCase("th")) 
				{
					if("FamilyName".equalsIgnoreCase(reqLabel)) retVal = rs.getString("FAMILY_NAME_LOC_LANG_PROMPT");
					else retVal = rs.getString("FIRST_NAME_LOC_LANG_PROMPT");
				}
				else if(locale != null && locale.equalsIgnoreCase("en")) 
				{
					if("FamilyName".equalsIgnoreCase(reqLabel)) retVal = rs.getString("FAMILY_NAME_PROMPT");
					else retVal = rs.getString("FIRST_NAME_PROMPT");
				}
			}
			
			if(retVal == null || retVal.equals("null"))
			{
				java.util.Locale loc = new java.util.Locale(locale);
				java.util.ResourceBundle labels = java.util.ResourceBundle.getBundle( "eMP.resources.Labels",loc);
				java.util.ResourceBundle commonLabels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
				
				if("FamilyName".equalsIgnoreCase(reqLabel)) retVal = labels.getString("eMP.LastName.label");
				else retVal = commonLabels.getString("Common.FirstName.label");
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
				if(oraConn != null) ConnectionManager.returnConnection(oraConn);
			}
			catch(Exception fexp)
			{
				fexp.printStackTrace(System.err);
			}
		}
		return retVal;
	}
}
