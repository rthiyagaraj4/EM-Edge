/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import webbeans.eCommon.ConnectionManager;

public class HTTPTransactions
{
	private static final long serialVersionUID = 1L;

	public void processRequest(Map<String, String> reqParams) throws Exception
	{
		String[] status = null;
		
		String url = reqParams.get("URL");
		String requestMsg = buildRequestMsg(reqParams);
		System.out.println("(HTTPTransactions:processRequest) URL ["+url+"]");
		System.out.println("(HTTPTransactions:processRequest) Request "+requestMsg);
		try {
			String response = sendRequest(url, requestMsg);
			System.out.println("(HTTPTransactions:processRequest) Response "+response);
			reqParams.put("RESPONSE_TEXT", response);
		}
		catch (Exception exp) {
			System.out.println("(HTTPTransactions:processRequest) Exception: " + exp.getMessage());
			exp.printStackTrace(System.err);
			throw exp;
		}
		finally {
			XHUtil.updateInteractiveDetails(reqParams);
		}
	}

	private static String sendRequest(String url,String message) throws Exception
	{
		String response = "";
		OutputStreamWriter outputStream = null;
		BufferedReader inputStreamReader = null;
		URL urlConn = new URL(url);
		HttpURLConnection httpConn = (HttpURLConnection) urlConn.openConnection();
		httpConn.setRequestMethod("POST");
		httpConn.setRequestProperty("Content-Type","application/xml");
		httpConn.setDoOutput(true);
	//	httpConn.setConnectTimeout(5000);
		
		try
		{			
			outputStream = new OutputStreamWriter(httpConn.getOutputStream());		
			outputStream.write(message);
			outputStream.flush();

			inputStreamReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));			
			String temp;
			while ((temp = inputStreamReader.readLine()) != null) 
			{
				response += temp;
			}			
		}
		catch (Exception exp)
		{
			throw exp;
		}
		finally
		{
			if(outputStream != null) outputStream.close();
			if(inputStreamReader != null) inputStreamReader.close();
		}
		return response;
	}

	private String buildRequestMsg(Map<String, String> reqParams) 
	{
		String requestMsg = "";
		String requestFormat = reqParams.get("REQUEST_SYNTAX");
		requestMsg = getRequestMsg(requestFormat, reqParams);

		reqParams.put("REQUEST_TEXT", requestMsg);
		return requestMsg;
	}

	private String getRequestMsg(String requestFormat, Map<String,String> reqParams)
	{
		Pattern pattern = Pattern.compile("#REQ_(.*?)_END");
		Matcher matcher = pattern.matcher(requestFormat);
		while(matcher.find())
		{
			String param = matcher.group(1);
			String currentMatch = matcher.group();
			String paramValue = StringUtils.defaultString(reqParams.get(param));
			requestFormat = requestFormat.replace(currentMatch, paramValue);
		}

		return requestFormat;
	}

	private void updateAuditTab(Map<String,String> additionalParams)
	{
		String calculateDRGProc = "{call XHINTERACTIVE.INTERACTIVE_INTERFAC_AUDIT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		Connection dbConn = null;
		CallableStatement auditStmt = null;

		try
		{
			System.out.println("updateAuditTab "+additionalParams);
			dbConn = ConnectionManager.getConnection();
			auditStmt = dbConn.prepareCall(calculateDRGProc);

			String strDate = XHUtil.getFormattedStringDate("dd-MMM-yyyy HH:mm:ss", null);
			String msgID = XHUtil.singleParamExeQry("SELECT xh_interactive_integration_seq.nextval FROM dual");

			auditStmt.setString(1,"I");
			auditStmt.registerOutParameter(2,java.sql.Types.VARCHAR);
			auditStmt.registerOutParameter(3,java.sql.Types.VARCHAR);
			auditStmt.setString(4,additionalParams.get("LOGIN_USER"));
			auditStmt.setString(5,additionalParams.get("CLIENT_MACHINE"));
			auditStmt.setString(6,additionalParams.get("CLIENT_MACHINE"));
			auditStmt.setString(7,additionalParams.get("APPLICATION_ID"));
			auditStmt.setString(8,"XH");
			auditStmt.setString(9,additionalParams.get("SESSION_ID"));
			auditStmt.setString(10,strDate);
			auditStmt.setString(11,additionalParams.get("requestMsg"));
			auditStmt.setString(12,"BRUQMS");
			auditStmt.setString(13,msgID);
			auditStmt.setString(14,additionalParams.get("FACILITY_ID"));
			auditStmt.setString(15,strDate);
			auditStmt.setString(16,"Q01");
			auditStmt.setString(17,additionalParams.get("patientID"));
			auditStmt.setString(18,"");
			auditStmt.setString(19,"");
			auditStmt.setString(20,additionalParams.get("encounterID"));
			auditStmt.setString(21,"");
			auditStmt.setString(22,"0");
			auditStmt.setString(23,additionalParams.get("requestSyntax"));
			auditStmt.setString(24,"");
			auditStmt.setString(25,"");				
			auditStmt.setString(26,additionalParams.get("LOGIN_USER"));
			auditStmt.setString(27,strDate);
			auditStmt.setString(28,additionalParams.get("LOGIN_USER"));
			auditStmt.setString(29,strDate);
			auditStmt.setString(30,additionalParams.get("CLIENT_MACHINE"));
			auditStmt.setString(31,additionalParams.get("FACILITY_ID"));
			auditStmt.setString(32,additionalParams.get("CLIENT_MACHINE"));
			auditStmt.setString(33,additionalParams.get("FACILITY_ID"));
			auditStmt.setString(34,msgID);
			auditStmt.setString(35,additionalParams.get("responseMsg"));
			auditStmt.setString(36,additionalParams.get("responseSyntax"));
			auditStmt.setString(37,additionalParams.get("profile"));
			auditStmt.setString(38,additionalParams.get("errorText"));
			auditStmt.setString(39,"");
			auditStmt.setString(40,"");
			
			auditStmt.execute();

			String errorCode = auditStmt.getString(2);
			String errorMsg = auditStmt.getString(3);
			if("S".equals(errorCode))
			{
				dbConn.commit();
			}
			else
			{
				System.out.println("(HTTPTransactions:updateAuditTab)Error "+ errorMsg);
			}
		}
		catch (Exception exp)
		{
			exp.printStackTrace(System.err);
			System.out.println("(HTTPTransactions:updateAuditTab)Exception "+exp);
		}
		finally
		{
			XHUtil.closeDBResources(null, auditStmt, dbConn);
		}
	}

}
