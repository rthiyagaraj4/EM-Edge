package HL7Engine.OutboundProcess ;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;

import oracle.jdbc.driver.OracleCallableStatement;
import HL7Engine.Common.Common;
import HL7Engine.Common.CommonUtil;

/**
 * Class handles ODBC related functionality
 *
 * Author: Ravindranath
 * Date  : 4/8/2009
 */

public class OutboundODBCCommunication
{
	Common common = Common.getInstance();
	CommonUtil commonUtil = new CommonUtil();
	OutboundClientParameters clientParameters;
	OutboundClientDBInteraction clientDB;

	Connection externalDBConn = null;

	public OutboundODBCCommunication()
	{
	}

	/**
	 * 
	 */
	OutboundODBCCommunication(OutboundClientDBInteraction clientDB, OutboundClientParameters clientParameters)
	{
		this.clientDB = clientDB;
		this.clientParameters = clientParameters;		
	}

	public String processMessage(String message)
	{
		String loadLevel = null;
	//	String staticSegments = "";
		String repeatBlockStartSeg = null;
		String errorTxt = null;

		try
		{
			loadLevel = clientDB.getLoadLevel();
			if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundODBCCommunication:processMessage) loadLevel:"+loadLevel+"\n" );

			if("E".equalsIgnoreCase(loadLevel))
			{
				String repeatSegment = clientDB.getRepeatSegment();

				// Checking for the repeat segment in the message
				StringTokenizer segmentTokens = new StringTokenizer(message,CommonUtil.formatAsciiToString(clientParameters.messageSegmentEnd));
				boolean tempRepeatSegmentChk = false; // temporary variable used for finding the repeat block
				while (segmentTokens.hasMoreTokens())
				{
					String tempCurrSegment = segmentTokens.nextToken();
					String segmentName = tempCurrSegment.substring(0,tempCurrSegment.indexOf("|"));					

					if(tempRepeatSegmentChk)
					{
						repeatBlockStartSeg = segmentName;
					}
					if(repeatSegment != null && repeatSegment.equalsIgnoreCase(segmentName))
					{
						tempRepeatSegmentChk = true;
					}
				}
			}
			else if("S".equalsIgnoreCase(loadLevel))
			{
				String tempCurrSegment = null;
				String segmentName = null;
				String sysDefString = null;
				String postingAPI = null;
				ArrayList segmentFieldList = new ArrayList();

				StringTokenizer segmentTokens = new StringTokenizer(message,CommonUtil.formatAsciiToString(clientParameters.messageSegmentEnd));
				
				while (segmentTokens.hasMoreTokens())
				{
					segmentFieldList.clear();
					tempCurrSegment	 = segmentTokens.nextToken();
					if(tempCurrSegment != null && !tempCurrSegment.equals(""))
					{
						int segmentIndex = tempCurrSegment.indexOf(CommonUtil.formatAsciiToString(clientParameters.fieldSeparator));
						if(segmentIndex != -1)
						{
							String fieldSeparatorTemp	= CommonUtil.formatAsciiToString(clientParameters.fieldSeparator);
						//	StringTokenizer fieldTokens = new StringTokenizer(tempCurrSegment, fieldSeparatorTemp,true);

							segmentFieldList = (ArrayList) CommonUtil.eHISStringTokenizer(tempCurrSegment, fieldSeparatorTemp);					
							segmentName = tempCurrSegment.substring(segmentIndex - 3, segmentIndex);									

							ArrayList list = (ArrayList)clientDB.getSysDefString(segmentName);

							if(list != null)
							{
								sysDefString = (String)list.get(0);
								postingAPI   = (String)list.get(1);						

								sysDefString = sysDefString.replaceAll("NULL","");
								sysDefString = sysDefString.replaceAll("''","");
								sysDefString = sysDefString.replaceFirst("#",",'");
								sysDefString = sysDefString.replaceAll("#","','");
								sysDefString = "?,?," + sysDefString;
								int sysDefStrLen = sysDefString.length();

								if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundODBCCommunication:processMessage) sysDefString:"+sysDefString+"\n" );
								if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundODBCCommunication:processMessage) Segment Field Len:"+segmentFieldList.size()+"\n" );
								
								for (int i = 0; i < sysDefStrLen ; i++)
								{
									int fieldToBeReplaced = sysDefString.indexOf(":" + segmentName + "[");
									
									if(fieldToBeReplaced > 0)
									{
										String strFieldToBeReplaced = sysDefString.substring(fieldToBeReplaced + 5, sysDefString.indexOf("]", fieldToBeReplaced));						
										String temp = ":" + segmentName + "\\[" + strFieldToBeReplaced + "\\]";							
										String temp1 = (String)segmentFieldList.get(Integer.parseInt(strFieldToBeReplaced)-1);							
										sysDefString = sysDefString.replaceAll(temp, temp1);
									}
								}
								sysDefString = sysDefString + "'";						
								errorTxt = exeExternalDBApi(postingAPI,sysDefString);

								if(errorTxt != null && !errorTxt.equals(""))
								{
									if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(OutboundODBCCommunication:processMessage) errorTxt " + errorTxt + "\n" );
								}
							}
							else
							{
								if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(OutboundODBCCommunication:processMessage) API not set for " + segmentName + "\n" );
								errorTxt = "API not set for " + segmentName;
							}
						}
					}
				}
			}
		}
		catch (Exception exp)
		{
			common.fileOutput(clientParameters.strExceptionLogFile, "(OutboundODBCCommunication:processMessage)Exception:- "+exp+"\n" ) ;
			common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp)+"\n" ) ;
			errorTxt = "Failed to execute API";
		}
		return errorTxt;
	}

	/**
	 * Executing API in external DB with the derived system defined string.
	 */
	private String exeExternalDBApi(String postingAPI, String derivedSysDefString)
	{	
		CallableStatement apiCallableStmt = null;
		String errorTxt = null;
		String procedureCall = "{ CALL "+ postingAPI + "("+derivedSysDefString+")}";

		try
		{
			if(externalDBConn == null)
			{				
				externalDBConn = clientDB.getExternalDBConnection();				
			}
		}
		catch (Exception exp)
		{
			common.fileOutput( clientParameters.strLogFile, "(OutboundODBCCommunication:exeExternalDBApi) External DB Conn failed...\n" );
			common.fileOutput( clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp)+"\n" ) ;
		}				

		try
		{			
			common.fileOutput(clientParameters.strLogFile, "(OutboundODBCCommunication:exeExternalDBApi) procedureCall "+procedureCall+"\n" );

			apiCallableStmt = externalDBConn.prepareCall(procedureCall);
			apiCallableStmt.registerOutParameter(1,java.sql.Types.VARCHAR);
			apiCallableStmt.registerOutParameter(2,java.sql.Types.VARCHAR);		
			apiCallableStmt.execute();

			errorTxt = apiCallableStmt.getString(2);

			if(errorTxt == null)
			{
				externalDBConn.commit();
			}			
		}
		catch(SQLException exceptionSQL)
		{
			common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionSQL) + "\n");			
			clientDB.checkExeDBConnection(clientParameters.odbcDBSID);
			if(clientParameters.isExternalDBDown) errorTxt = "External DB Conn Down !!!";
		}
		catch (Exception exp)
		{			
			common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp)+"\n");			
		}
		finally
		{
			try
			{
				if(apiCallableStmt != null) apiCallableStmt.close();
			}
			catch (Exception exp) { }			
		}
		return errorTxt;
	}

	private void setMedUserRole()
	{	
		try
		{
			String strParamRole = "";
			String strProcedureName = "{ call DBMS_SESSION.SET_ROLE(?)"+"}"; 
			String strQry = "SELECT APP_PASSWORD.DECRYPT(ORA_ROLE_PASSWORD) FROM SM_ORA_ROLE  Where ORA_ROLE_ID = 'MEDUSERS'";			
			String strPasswd = "";

			ResultSet rset = null;
			Statement stmt = null;
			OracleCallableStatement call = null;

			try
			{
				stmt = externalDBConn.createStatement();
				rset = stmt.executeQuery(strQry );

				while (rset.next())
				{
					strPasswd = rset.getString(1);
				}
				stmt.close();
			}
			catch(Exception expSql)
			{
				common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:setMedUserRole) "+expSql+"\n" );				
			}
			finally
			{
				try
				{
					if(rset != null) rset.close();
					if(stmt != null) stmt.close();
				}
				catch(Exception e) { }
			}
			strParamRole = "MEDUSERS IDENTIFIED BY "+strPasswd;
			call =(OracleCallableStatement) externalDBConn.prepareCall(strProcedureName);
			call.setString(1,strParamRole);
			call.execute();
			call.close();
		}
		catch(Exception expCal)
		{
			common.fileOutput( clientParameters.strLogFile, "(OutboundClientDBInteraction:setMedUserRole) "+expCal+"\n" );			
		}
	}
}
