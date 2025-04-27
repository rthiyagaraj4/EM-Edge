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
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.lang.reflect.Type;

import org.apache.commons.lang.StringUtils;

import webbeans.eCommon.ConnectionManager;

/**
 * Class for all patient queue related transactions for Brunei/Rutnin sites.
 * This class will be used from different modules of EM where ever  
 * patient queue has be to be managed. 
 * 
 * @author      Ravindranath O
 * @version     21-05-2012
 */

public class QueueManager 
{
	public static final String BRUNEI_SITE_ID = "MOHBR";
	public static final String RUTNIN_SITE_ID = "RT";
	/**
	 * 
	 * @param assignedRoom QMS location
	 * @param serviceNo Unique service ID
	 * @param practitionerID practitioner id assigned to the patient
	 * @param additionalParams Map should contain audit info as follows
	 * <ul>
	 * <li>siteID - Refer <a href="#field_summary"><i>CONSTANTS</i></a>
	 * <li>loggedUser - Logged in user
	 * <li>clientMachine - User workstation
	 * <li>facilityID - Facility ID
	 * <li>sessionID - Current session ID
	 * <li>patientID - Patient ID
	 * <li>encounterID - Encounter ID
	 * </ul>
	 * @return string array	<br>array[0] status (0 - success,1 - fail)
	 * 						<br>array[1] ticket no (if status = 0 else null)
	 * 						<br>array[2] errors (if status = 1)
	 * @throws Exception
	 */
	public String[] issueTicket(String assignedRoom,String serviceNo,String practitionerID,Map<String,String> additionalParams) throws Exception
	{
		String[] status = new String[3];

		additionalParams = chkParams(additionalParams);
		
		additionalParams.put("serviceNo", serviceNo);
		additionalParams.put("roomNo", assignedRoom);
		additionalParams.put("practitionerID", practitionerID);
		additionalParams.put("action", "REGISTER");

		status = processRequest(additionalParams);
		
		return status;
	}

	/**
	 * 
	 * @param ticketNo ticket number for the patient obtained from issueTicket method
	 * @param additionalParams Map should contain audit info as follows
	 * <ul>
	 * <li>siteID - Refer <a href="#field_summary"><i>CONSTANTS</i></a>
	 * <li>loggedUser - Logged in user
	 * <li>clientMachine - User workstation
	 * <li>facilityID - Facility ID
	 * <li>sessionID - Current session ID
	 * <li>patientID - Patient ID
	 * <li>encounterID - Encounter ID
	 * </ul>
	 * @return string array	<br>array[0] status (0 - success,1 - fail)
	 * 						<br>array[1] errors (if status = 1)
	 * @throws Exception
	 */
	public String[] cancelTicket(String ticketNo,Map<String,String> additionalParams) throws Exception
	{
		String[] status = new String[3];

		additionalParams = chkParams(additionalParams);
		additionalParams.put("ticketNo", ticketNo);
		additionalParams.put("action", "CANCEL");

		status = processRequest(additionalParams);
		
		return status;
	}
	
	/**
	 *
	 * @param workStation QMS location
	 * @param additionalParams Map should contain audit info as follows
	 * <ul>
	 * <li>siteID - Refer <a href="#field_summary"><i>CONSTANTS</i></a>
	 * <li>loggedUser - Logged in user
	 * <li>clientMachine - User workstation
	 * <li>facilityID - Facility ID
	 * <li>sessionID - Current session ID
	 * <li>patientID - Patient ID
	 * <li>encounterID - Encounter ID
	 * </ul>
	 * <ul>If the siteID is RT (Rutnin) following parameters need to be included in the map
	 * <li>scheduledTime
	 * <li>userName
	 * </ul>
	 * 
	 * @return string array	<br>array[0] status (0 - success,1 - fail)
	 * 						<br>array[1] service information (ticket number, service and issued time)
	 * 						<br>array[2] errors (if status = 1)
	 * @throws Exception
	 */
	public String[] callNextTicket(String workStation,Map<String,String> additionalParams) throws Exception
	{
		String[] status = new String[3];

		additionalParams = chkParams(additionalParams);
		additionalParams.put("roomNo", workStation);
		additionalParams.put("action", "CALLNEXT");

		status = processRequest(additionalParams);
		return status;
	}
	
	/**
	 * 
	 * @param ticketNo ticket number for the patient obtained from issueTicket method
	 * @param additionalParams Map should contain audit info as follows
	 * <ul>
	 * <li>siteID - Refer <a href="#field_summary"><i>CONSTANTS</i></a>
	 * <li>loggedUser - Logged in user
	 * <li>clientMachine - User workstation
	 * <li>facilityID - Facility ID
	 * <li>sessionID - Current session ID
	 * <li>patientID - Patient ID
	 * <li>encounterID - Encounter ID
	 * </ul>
	 * <ul>If the siteID is RT (Rutnin) following parameters need to be included in the map
	 * <li>scheduledTime
	 * <li>userName
	 * <li>workStation
	 * </ul>
	 * @return string array	<br>array[0] status (0 - success,1 - fail)
	 * 						<br>array[1] service information (ticket number, service and issued time)
	 * 						<br>array[2] errors (if status = 1)
	 * @throws Exception
	 */
	public String[] callTicket(String ticketNo,Map<String,String> additionalParams) throws Exception
	{
		String[] status = new String[3];
		additionalParams = chkParams(additionalParams);
		additionalParams.put("ticketNo", ticketNo);
		additionalParams.put("action", "CALL");

		status = processRequest(additionalParams);
		return status;
	}
	
	/**
	 * 
	 * @param roomNo QMS Location
	 * @param additionalParams Map should contain audit info as follows
	 * <ul>
	 * <li>siteID - Refer <a href="#field_summary"><i>CONSTANTS</i></a>
	 * <li>loggedUser - Logged in user
	 * <li>clientMachine - User workstation
	 * <li>facilityID - Facility ID
	 * <li>patientID - Patient ID
	 * <li>encounterID - Encounter ID
	 * </ul>
	 * @return string array	<br>array[0] status (0 - success,1 - fail)
	 * 						<br>array[1] ticket number
	 * 						<br>array[2] errors (if status = 1)
	 * @throws Exception
	 */
	public String[] finishConsultation(String roomNo,Map<String,String> additionalParams) throws Exception
	{
		String[] status = new String[3];

		additionalParams = chkParams(additionalParams);
		additionalParams.put("roomNo", roomNo);
		additionalParams.put("action", "FINISH");

		status = processRequest(additionalParams);
		return status;
	}

	/**
	 * 
	 * @param ticketNo Queue number
	 * @param workStation Workstation
	 * @param userName User who did the transaction
	 * @param additionalParams Map should contain audit info as follows
	 * <ul>
	 * <li>siteID - Refer <a href="#field_summary"><i>CONSTANTS</i></a>
	 * <li>loggedUser - Logged in user
	 * <li>clientMachine - User workstation
	 * <li>facilityID - Facility ID
	 * <li>patientID - Patient ID
	 * <li>encounterID - Encounter ID
	 * </ul>
	 * @return string array	<br>array[0] status (0 - success,1 - fail)
	 * 						<br>array[1] ticket number
	 * 						<br>array[2] errors (if status = 1)
	 * @throws Exception
	 */
	public String[] sendToWaitList(String ticketNo, String workStation, String userName, Map<String,String> additionalParams) throws Exception
	{
		String[] status = new String[3];

		additionalParams = chkParams(additionalParams);
		additionalParams.put("ticketNo", ticketNo);
		additionalParams.put("workStation", workStation);
		additionalParams.put("userName", userName);
		additionalParams.put("action", "PENDING");

		status = processRequest(additionalParams);
		return status;
	}

	/**
	 * 
	 * @param ticketNo Queue number
	 * @param workStation Workstation
	 * @param userName User who did the transaction
	 * @param nextStation Workstation
	 * @param additionalParams Map should contain audit info as follows
	 * <ul>
	 * <li>siteID - Refer <a href="#field_summary"><i>CONSTANTS</i></a>
	 * <li>loggedUser - Logged in user
	 * <li>clientMachine - User workstation
	 * <li>facilityID - Facility ID
	 * <li>patientID - Patient ID
	 * <li>encounterID - Encounter ID
	 * </ul>
	 * @return string array	<br>array[0] status (0 - success,1 - fail)
	 * 						<br>array[1] ticket number
	 * 						<br>array[2] errors (if status = 1)
	 * @throws Exception
	 */
	public String[] transferPatient(String ticketNo, String workStation, String userName, String nextStation, Map<String,String> additionalParams) throws Exception
	{
		String[] status = new String[3];

		additionalParams = chkParams(additionalParams);
		additionalParams.put("ticketNo", ticketNo);
		additionalParams.put("workStation", workStation);
		additionalParams.put("userName", userName);
		additionalParams.put("nextStation", nextStation);
		additionalParams.put("action", "TRANSFER");

		status = processRequest(additionalParams);
		return status;
	}
	
	private String[] processRequest(Map<String, String> additionalParams) throws Exception
	{
		String[] status = null;
		String siteID = additionalParams.get("siteID");
		String url = getURL(siteID, additionalParams);
		String requestMsg = buildRequestMsg(additionalParams);
		System.out.println("(QueueManager:processRequest) Site ["+siteID+"] URL ["+url+"]");
		System.out.println("(QueueManager:processRequest) Request "+requestMsg);
		try
		{
			String response = sendRequest(url, requestMsg);
			System.out.println("(QueueManager:processRequest) Response "+response);
			status = processResponse(additionalParams, response);
		}
		catch (Exception exp)
		{
			System.out.println("(QueueManager:processRequest) Exception: " + exp.getMessage());
			exp.printStackTrace(System.err);
			status = new String[3];
			status[0] = "1";
			status[1] = null;

			if(exp instanceof IOException)
			{
				status[2] = XHUtil.getLocaleMessage("en", "XH0116", "XH");
			}
			else
			{
				status[2] = XHUtil.getLocaleMessage("en", "XH1000", "XH");
			}
			additionalParams.put("errorText", exp.getMessage());
			updateAuditTab(additionalParams);
		}
		
		return status;
	}

	private String getURL(String siteID,Map<String,String> requestParams)
	{
		String protocolID = null;
		String url = "";
		StringBuilder tempURL = new StringBuilder();

		if(RUTNIN_SITE_ID.equals(siteID))
		{
			protocolID = "QMATICQUEP";
			requestParams.put("profile","");
			String action = requestParams.get("action");
			String ticketNo = requestParams.get("ticketNo");
			if("REGISTER".equals(action))
			{
				// FORMAT - /opoq/{HN no.}/register?workStation={workstationname}&workflowDetails={workflow step and details }&username={username of staff}&password={password of user}
				tempURL.append("/opoq/");
				tempURL.append(requestParams.get("patientID"));
				tempURL.append("/request?workStation=");
				tempURL.append(requestParams.get("workStation"));
				tempURL.append("&workflowDetails=");
				tempURL.append(requestParams.get("workflow"));
				tempURL.append("&username=");
				tempURL.append(requestParams.get("userName"));
			}
			else if("CANCEL".equals(action))
			{
				// FORMAT - /workStation/{workStation }/{queue number}/return?staffName={name of staff}
				tempURL.append("workStation/");
				tempURL.append("OCT");
				tempURL.append(ticketNo);
				tempURL.append("/");
			}
			else if("CALL".equals(action))
			{
				// FORMAT - /opoq/workStation/{workStation}/{queue number}/call?schedule={scheduled time}&username={name of staff}&password={password}
				tempURL.append("/opoq/workStation/");
				tempURL.append(requestParams.get("workStation"));
				tempURL.append("/");
				tempURL.append(ticketNo);
				tempURL.append("/call?schedule=");
				tempURL.append(requestParams.get("scheduledTime"));
				tempURL.append("&username=");
				tempURL.append(requestParams.get("userName"));
			}
			else if("RECALL".equals(action))
			{
				// FORMAT - /workStation/{workStation }/{queue number}/return?staffName={name of staff}
				tempURL.append("workStation/");
				tempURL.append("OCT");
				tempURL.append(ticketNo);
				tempURL.append("/");
			}
			else if("FINISH".equals(action))
			{
				// FORMAT - /workStation/{workStation }/{queue number}/finish?nextStation={nextStation}?staffName={name of staff}
				tempURL.append("workStation/");
				tempURL.append("OCT");
				tempURL.append(ticketNo);
				tempURL.append("/finish");
			}
			else if("CALLNEXT".equals(action))
			{
				// FORMAT - workStation/{workStation}/nextQueue/start?schedule={scheduled time}&username={name of staff}&password={password}
				tempURL.append("/workStation/");
				tempURL.append(requestParams.get("workStation"));
				tempURL.append("/nextQueue");
				tempURL.append("/start?schedule=");
				tempURL.append(requestParams.get("scheduledTime"));
				tempURL.append("&username=");
				tempURL.append(requestParams.get("userName"));
			}
			else if("PENDING".equals(action))
			{
				// FORMAT - /opoq/workStation/{workStation}/{queue no}/pending?userName={name of staff}
				tempURL.append("/opoq/workStation/");
				tempURL.append(requestParams.get("workStation"));
				tempURL.append("/");
				tempURL.append(ticketNo);
				tempURL.append("/pending?userName=");
				tempURL.append(requestParams.get("userName"));
			}
			else if("TRANSFER".equals(action))
			{
				// FORMAT - opoq/workStation/{workStation}/{queue no}/transfer?nextStation={nextStation}?username={name of staff}
				tempURL.append("/opoq/workStation/");
				tempURL.append(requestParams.get("workStation"));
				tempURL.append("/");
				tempURL.append(ticketNo);
				tempURL.append("/transfer?nextStation=");
				tempURL.append(requestParams.get("nextStation"));
				tempURL.append("&username=");
				tempURL.append(requestParams.get("userName"));
			}
		}
		else if(BRUNEI_SITE_ID.equals(siteID))
		{
			protocolID = "QMATICQUEP";
			requestParams.put("profile","BRUQMS");
		}

		String qry = "SELECT xml_style_sheet_url FROM xh_protocol WHERE protocol_id='"+ protocolID +"'";
		url = XHUtil.singleParamExeQry(qry) + tempURL.toString();

		return url;
	}
	
	private String buildRequestMsg(Map<String, String> additionalParams) 
	{
		String requestMsg = "";
		String requestFormat = "";
		String siteID = additionalParams.get("siteID");
		requestFormat = getRequestFormat(siteID, additionalParams);
		requestMsg = getRequestMsg(requestFormat, additionalParams);

		additionalParams.put("requestMsg", requestMsg);
		return requestMsg;
	}
	
	private static String sendRequest(String url,String message) throws Exception
	{
		String response = "";
		OutputStreamWriter outputStream = null;
		BufferedReader inputStreamReader = null;
		URL urlConn = new URL(url);
		HttpURLConnection httpConn = (HttpURLConnection) urlConn.openConnection();
		httpConn.setRequestMethod("POST");
		httpConn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
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
	
	/**
	 * Processes and returns the response message as a string array with fields in the same position as expected for the invoking method.
	 * @param additionalParams
	 * @param response
	 * @return
	 * @throws Exception
	 */
	private String[] processResponse(Map<String,String> additionalParams,String response) throws Exception
	{
		String siteID = additionalParams.get("siteID");
		String action = additionalParams.get("action");
		String[] status = null;

		if(RUTNIN_SITE_ID.equals(siteID)) // Rutnin
		{
			Map<String,String> result = XMLUtil.getNodeElementAsMap(new ByteArrayInputStream(response.getBytes()),"//response/*");
			status = new String[3];
			status[0] = result.get("code").equals("0000")?"0":"1";
			status[1] = result.get("result");
			status[2] = result.get("message");
		}
		else if(BRUNEI_SITE_ID.equals(siteID)) // Brunei
		{
			Map<String,String> result = null;
			Map<String,String> errorList = null;
			status = new String[3];
			String rootElement = "";

			if("REGISTER".equals(action))
			{
				rootElement = "IssueTicketResp";
			}
			else if("CANCEL".equals(action))
			{
				rootElement = "CancelTicketResp";
			}
			else if("CALL".equals(action) || "RECALL".equals(action))
			{
				rootElement = "CTCallResp";
			}
			else if("FINISH".equals(action))
			{
				rootElement = "CTDoneResp";
			}
			else if("CALLNEXT".equals(action))
			{
				rootElement = "CTNextResp";
			}

			result = XMLUtil.getNodeElementAsMap(new ByteArrayInputStream(response.getBytes()), "//" + rootElement + "/*");
			if(result.get("Status").equals("-1"))
			{
				errorList = XMLUtil.getNodeElementAsMap(new ByteArrayInputStream(response.getBytes()), "//" + rootElement + "/ErrorList/Error/*");
				status[0] = "1";
				status[2] = errorList.get("Reason");
				System.out.println(errorList);
			}
			else
			{
				if("CALL".equals(action) || "CALLNEXT".equals(action))
				{
					errorList = XMLUtil.getNodeElementAsMap(new ByteArrayInputStream(response.getBytes()), "//" + rootElement + "/TicketServedInfo/*");
					status[1] = StringUtils.defaultString(errorList.get("TicketNo"));
				}
				else if("FINISH".equals(action) || "REGISTER".equals(action))
				{
					status[1] = StringUtils.defaultString(result.get("TicketNo"));
				}
				status[0] = "0";
			}						
		}
		
		additionalParams.put("responseMsg", response);
		updateAuditTab(additionalParams);

		return status;
	}

	private Map<String,String> chkParams(Map<String,String> additionalParams)
	{
		if(additionalParams == null)
		{
			additionalParams = new HashMap<String,String>();
		}
		if(additionalParams.isEmpty()) additionalParams.put("siteID", BRUNEI_SITE_ID);
		return additionalParams;
	}

	private void updateAuditTab(Map<String,String> additionalParams)
	{
		String calculateDRGProc = "{call XHINTERACTIVE.INTERACTIVE_INTERFAC_AUDIT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		Connection dbConn = null;
		CallableStatement auditStmt = null;

		try
		{
			dbConn = ConnectionManager.getConnection();
			auditStmt = dbConn.prepareCall(calculateDRGProc);

			String strDate = XHUtil.getFormattedStringDate("dd-MMM-yyyy HH:mm:ss", null);
			String msgID = XHUtil.singleParamExeQry("SELECT xh_interactive_integration_seq.nextval FROM dual");

			auditStmt.setString(1,"I");
			auditStmt.registerOutParameter(2,java.sql.Types.VARCHAR);
			auditStmt.registerOutParameter(3,java.sql.Types.VARCHAR);
			auditStmt.setString(4,additionalParams.get("loggedInUser"));
			auditStmt.setString(5,additionalParams.get("clientMachine"));
			auditStmt.setString(6,additionalParams.get("clientMachine"));
			auditStmt.setString(7,"BRUQMS");
			auditStmt.setString(8,"XH");
			auditStmt.setString(9,additionalParams.get("sessionID"));
			auditStmt.setString(10,strDate);
			auditStmt.setString(11,additionalParams.get("requestMsg"));
			auditStmt.setString(12,"BRUQMS");
			auditStmt.setString(13,msgID);
			auditStmt.setString(14,additionalParams.get("facilityID"));
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
			auditStmt.setString(26,additionalParams.get("loggedUser"));
			auditStmt.setString(27,strDate);
			auditStmt.setString(28,additionalParams.get("loggedUser"));
			auditStmt.setString(29,strDate);
			auditStmt.setString(30,additionalParams.get("clientMachine"));
			auditStmt.setString(31,additionalParams.get("facilityID"));
			auditStmt.setString(32,additionalParams.get("clientMachine"));
			auditStmt.setString(33,additionalParams.get("facilityID"));
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
				System.out.println("(QueueManager:updateAuditTab)Error "+ errorMsg);
			}
		}
		catch (Exception exp)
		{
			exp.printStackTrace(System.err);
			System.out.println("(QueueManager:updateAuditTab)Exception "+exp);
		}
		finally
		{
			XHUtil.closeDBResources(null, auditStmt, dbConn);
		}
	}

	private String getRequestFormat(String siteID, Map<String,String> additionalParams)
	{
		String action = additionalParams.get("action");
		String format = "";
		if(BRUNEI_SITE_ID.equals(siteID))
		{
			if("REGISTER".equals(action))
			{
				format = "<IssueTicketReq>   <TicketNo>#REQ_ticketNo_END</TicketNo>   <IndUser>     <UserID>#REQ_practitionerID_END</UserID>     <Username>#REQ_userName_END</Username>   </IndUser>   <ServiceNo>#REQ_serviceNo_END</ServiceNo>   <CounterName>#REQ_clientMachine_END</CounterName> </IssueTicketReq>";
			}
			else if("CANCEL".equals(action))
			{
				format = "<CancelTicketReq>   <TicketNo>#REQ_ticketNo_END</TicketNo> </CancelTicketReq>";
			}
			else if("CALL".equals(action))
			{
				format = "<CTCallReq>   <CounterName>#REQ_clientMachine_END</CounterName>   <TicketNo>#REQ_ticketNo_END</TicketNo> </CTCallReq>";
			}
			else if("RECALL".equals(action))
			{
				format = "";
			}
			else if("FINISH".equals(action))
			{
				format = "<CTDoneReq>   <CounterName>#REQ_clientMachine_END</CounterName> </CTDoneReq>";
			}
			else if("CALLNEXT".equals(action))
			{
				format = "<CTNextReq>   <CounterName>#REQ_clientMachine_END</CounterName> </CTNextReq>";
			}
		}
		return format;
	}
/*
	// Above commented was the actual code, this method is for testing purpose in dev as per the simulator software
	private String getRequestFormat(String siteID, Map<String,String> additionalParams)
	{
		String action = additionalParams.get("action");
		String format = "";
		if(BRUNEI_SITE_ID.equals(siteID))
		{
			if("REGISTER".equals(action))
			{
				format = "<IssueTicketReq>   <TicketNo>#REQ_ticketNo_END</TicketNo>   <IndUser>     <UserID>#REQ_practitionerID_END</UserID>     <Username>#REQ_userName_END</Username>   </IndUser>   <ServiceNo>#REQ_serviceNo_END</ServiceNo>   <CTNo>#REQ_roomNo_END</CTNo> </IssueTicketReq>";
			}
			else if("CANCEL".equals(action))
			{
				format = "<CancelTicketReq>   <TicketNo>#REQ_ticketNo_END</TicketNo> </CancelTicketReq>";
			}
			else if("CALL".equals(action))
			{
				format = "<CTCallReq>   <CTNo>#REQ_roomNo_END</CTNo>   <TicketNo>#REQ_ticketNo_END</TicketNo> </CTCallReq>";
			}
			else if("RECALL".equals(action))
			{
				format = "";
			}
			else if("FINISH".equals(action))
			{
				format = "<CTDoneReq>   <CTNo>#REQ_roomNo_END</CTNo> </CTDoneReq>";
			}
			else if("CALLNEXT".equals(action))
			{
				format = "<CTNextReq>   <CTNo>#REQ_roomNo_END</CTNo> </CTNextReq>";
			}
		}
		return format;
	}
*/
	private String getRequestMsg(String requestFormat, Map<String,String> additionalParams)
	{
		Pattern pattern = Pattern.compile("#REQ_(.*?)_END");
		Matcher matcher = pattern.matcher(requestFormat);
		while(matcher.find())
		{
			String param = matcher.group(1);
			String currentMatch = matcher.group();
			String paramValue = StringUtils.defaultString(additionalParams.get(param));
			requestFormat = requestFormat.replace(currentMatch, paramValue);
		}

		return requestFormat;
	}
}
