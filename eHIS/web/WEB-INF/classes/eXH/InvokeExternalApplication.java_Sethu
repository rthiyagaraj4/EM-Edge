/***************************************************************************************************************
 * Author   :   Ravindranath.O
 * Desc     :	
 ***************************************************************************************************************/
package eXH;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.io.*;

import webbeans.eCommon.ConnectionManager;

import java.sql.Clob;
import java.sql.SQLException;

public class InvokeExternalApplication extends HttpServlet
{
	boolean isDebugYN = false; // temporary variable for debug logging check, should be removed once final testing is done 

	public static final String l_field_separator= "$!^";
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		doPost(request, response);
	}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    { 
		String l_app_msg = "";
		String l_segment_id = "", l_element_id = "", l_std_code = "";

		try
		{
			Map<String, String> reqParams = XHUtil.getRequestParams(request);
			String callType = reqParams.get("callType");
			String isMultiAppEnabledStr = checkMultiApplication(request);
			isDebugYN = (XHUtil.singleParamExeQry("SELECT NVL(DEBUG_YN,'N') DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;
			
			System.out.println("***Inside Invoke External Application - isDebugYN... " +isDebugYN);
            
			if(isDebugYN) {
				System.out.println("***Inside Invoke External Application - Call Type... " +callType);
				System.out.println("***Inside Invoke External Application - REQ_PARAM " + XHUtil.getRequestParams(request));
			}
			
			if("IS_MULTIPLE_APP_ENABLED".equals(callType)) {
				PrintWriter resp = response.getWriter();
				resp.write(isMultiAppEnabledStr);
				resp.flush();
				resp.close();
			}
			else if("SPANePos".equals(callType)) {
                    System.out.println("***Inside Invoke External Application - Call Type.... " +callType);
				    String responseTxt="";
				    responseTxt=callInterfaceExteralApp(request,response, reqParams);
					PrintWriter resp = response.getWriter();
					resp.flush();
					resp.write(responseTxt);
					resp.close(); 
			}
			else if ("PAYSYS".equals(callType)) {
				/*
				 * Added by Gopinath on 06/04/2023 for MMOH-CRF-1928 This method is
				 * used for Paysys Transactions
				 */
				String responseTxt = "";
				responseTxt = callInterfaceExteralPaysysApp(request, response, reqParams);
				PrintWriter resp = response.getWriter();
				resp.flush();
				resp.write(responseTxt);
				resp.close();
			} 
			else if ("SPECTRAWEB".equals(callType)) {
				/*
				 * Added by Gopinath on 24/05/2023 for NMC-JD-CRF-0202 This method is
				 * used for Spectra Web Socket Transactions
				 */
				String responseTxt = "";
				responseTxt = getSpectraWebTransactionInfo(request, response, reqParams);
				PrintWriter resp = response.getWriter();
				resp.flush();
				resp.write(responseTxt);
				resp.close();
			}			
			else if(!"INTERFACE_CALL".equals(callType) && "TRUE".equals(isMultiAppEnabledStr)) {
				request.getRequestDispatcher("/eXH/jsp/ShowMultiExternalApplications.jsp").forward(request, response);
			}
			else if("payTM".equals(callType)) {
				/*
				* Added by Sethu on 19/04/2017 for GHL-CRF-0415 
				* This method is used for PayTM Transactions
				*/
				    String responseTxt="";
				    responseTxt=PayTMTransactions(reqParams);
					System.out.println("***Inside Invoke External Application - Paytm Response... " +responseTxt);
					PrintWriter resp = response.getWriter();
					resp.flush();
					resp.write(responseTxt);
					resp.close(); 
			}
			else if("PHIS".equals(callType)) {
				/*
				* Added by Sethu on 19/04/2017 for GHL-CRF-0415 
				* This method is used for PayTM Transactions
				*/
				    String responseTxt="";
				    responseTxt=PHISTransactions(reqParams);
					System.out.println("***Inside Invoke External Application - PHIS Transactions response... " +responseTxt);
					PrintWriter resp = response.getWriter();
					resp.flush();
					resp.write(responseTxt);
					resp.close(); 
			}
			else if("DCS".equals(callType)) {
				/*
				* Added by Sethu on 19/04/2017 for GHL-CRF-0415 
				* This method is used for PayTM Transactions
				*/
				    String responseTxt="";
					String paramString=reqParams.get("paramString");

					l_segment_id = FieldValueFetchMethod(paramString,"<SEGMENT_ID>",null,l_field_separator, "TransRequestMethod");
					l_app_msg = "***Inside Invoke External Application - Segment ID : "+l_segment_id;
					if (isDebugYN) System.out.println(l_app_msg);
					
					l_element_id = FieldValueFetchMethod(paramString,"<ELEMENT_ID>",null,l_field_separator, "TransRequestMethod");
					l_app_msg = "***Inside Invoke External Application - Element ID : "+l_element_id;
					if (isDebugYN) System.out.println(l_app_msg);

					l_std_code = FieldValueFetchMethod(paramString,"<STD_CODE>",null,l_field_separator, "TransRequestMethod");
					l_app_msg = "***Inside Invoke External Application - Standard Code : "+l_std_code;
					if (isDebugYN) System.out.println(l_app_msg);

				    responseTxt=FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_std_code);
				    if (isDebugYN) System.out.println("***Inside Invoke External Application - Control Segment Method Response... " +responseTxt);
					PrintWriter resp = response.getWriter();
					resp.flush();
					resp.write(responseTxt);
					resp.close(); 
			}
			else if("CCRESPONSE".equals(callType)) {
				/*
				* Added by Sethu on 04/06/2019 for GHL-CRF-0373 
				* This method is used for Credit Card response Transactions
				*/
					if(isDebugYN) 
						System.out.println("***Inside Invoke External Application - CC Response Processing... ");

				    CCResponse(reqParams);
					sendResponse(request, response, reqParams);					
			}
			else if("OTP".equals(callType)) {
				/*
				* Added by Apoorva on 23/01/2020 for NMC-JD-CRF-0038.1 
				* This method is used for OTP Transactions
				*/
				    String responseTxt="";
				    responseTxt=OTPTransactions(reqParams);
					System.out.println("***Inside Invoke External Application - OTP Response... " +responseTxt);
					PrintWriter resp = response.getWriter();
					resp.flush();
					resp.write(responseTxt);
					resp.close(); 
			}
			else if("MALAFFI".equals(callType)) {
				/*
				* Added by Apoorva on 23/01/2020 for NMC-JD-CRF-0038.1 
				* This method is used for OTP Transactions
				*/
				    String responseTxt="";
				    responseTxt=EMWebServiceTrans(reqParams);
					System.out.println("***Inside Invoke External Application - Malaffi Response... " +responseTxt);
					PrintWriter resp = response.getWriter();
					resp.flush();
					resp.write(responseTxt);
					resp.close(); 
			}
			else if("SNOMED".equals(callType)) {
				/*
				* Added by Ravisankar on 23/01/2021 for PMG2019-TECH-CRF-0015.1 -SNOMED
				* This method is used To Fetch Snomed Data
				*/
				    String responseTxt="";
				    responseTxt=EMWebServiceSnomedTrans(reqParams);
					System.out.println("***Inside Invoke External Application - Snomed Response... " +responseTxt);
					PrintWriter resp = response.getWriter();
					resp.flush();
					resp.write(responseTxt);
					resp.close(); 
			}
			else if("SegmentData".equals(callType)) {
				/*
				* Added by Sethu on 31/08/2020 for MOHE-CRF-0016
				* This method is used TO Fetch Standard Control Segments Data
				*/
				    String responseTxt="", segmentID = "", elementId = "", standardCode = "";

					segmentID = reqParams.get("segmentid");
					elementId = reqParams.get("elementid");
					standardCode = reqParams.get("standardcode");

				    responseTxt=FetchStdCntrlSegMethod(segmentID, elementId, standardCode);
					System.out.println("***Inside Invoke External Application - Segment Data... " +responseTxt);
					PrintWriter resp = response.getWriter();
					resp.flush();
					resp.write(responseTxt);
					resp.close(); 
			}
			else if("NUHDEEK".equals(callType)) {
				/*
				* Added by Apoorva on 23/01/2020 for NMC-JD-CRF-0038.1 
				* This method is used for OTP Transactions
				*/
				    String responseTxt="";
				    responseTxt=NuhdeekTransactions(request, reqParams);
					System.out.println("***Inside Invoke External Application - Nuhdeek Response... " +responseTxt);
					PrintWriter resp = response.getWriter();
					resp.flush();
					resp.write(responseTxt);
					resp.close(); 
			}
			else if("XHPAYER".equals(callType)) {
				/* Added by Niveditha for MOHE-CRF-0026.38*/
				System.out.println("***Inside Invoke External Application - PayerTransactions XHPAYER..." );
				    String responseTxt="";
				    responseTxt=PayerTransactions(request, reqParams);
				System.out.println("***Inside Invoke External Application - PayerTransactions Response text... " +responseTxt);
					PrintWriter resp = response.getWriter();
					resp.flush();
					resp.write(responseTxt);
					resp.close(); 
			}
			else if("GetWaitTime".equals(callType)) {
				/*
				* Added by Sethu on 31/08/20210 for MOHE-CRF-0076
				* This method is used TO Fetch Standard Control Segments Data
				*/
				
				String strPluginType = "";
				String responseTxt="";

				strPluginType = reqParams.get("segmentid");
				
				responseTxt = FetchResponseWaitTime(strPluginType);
			    
				System.out.println("***Inside Invoke External Application - Get Wait Time... " +responseTxt);
				PrintWriter resp = response.getWriter();
				resp.flush();
				resp.write(responseTxt);
				resp.close(); 
			}
			else if("AuditInfo".equals(callType)) {
				/*
				* Added by Sethu on 31/08/2021 for MOHE-CRF-0076
				* This method is used to Audit the transactions
				*/				
				
				String responseTxt = "";
				
				responseTxt = AuditInfo(request, reqParams);
				
				
				System.out.println("***Inside Invoke External Application - Audit Info... " +responseTxt);
				PrintWriter resp = response.getWriter();
				resp.flush();
				resp.write(responseTxt);
				resp.close(); 
			}
			else if("AuditInfoIU".equals(callType)) {
				/*
				* Added by Gopinath on 28/07/2023 for ML-MMOH-SCF-2469
				* This method is used to Audit the transactions
				*/
				if (isDebugYN)
					System.out.println("***Inside Invoke External Application - AuditInfoIU - reqParams...." + reqParams.toString());
				
				String responseTxt = "";
				
				String AuditMode = reqParams.get("AuditMode");
				
				if (isDebugYN)
					System.out.println("***Inside Invoke External Application - AuditInfoIU - AuditMode...." + AuditMode);
				
				if(AuditMode.equals("I")){
					String requestMessage = reqParams.get("REQUEST_TEXT") == null ? "" : reqParams.get("REQUEST_TEXT");
					reqParams.put("REQUEST_TEXT", requestMessage);
					responseTxt = AuditInfo(request, reqParams, "I");
				}
				
				if(AuditMode.equals("U")){
					String responseMessage = reqParams.get("RESPONSE_TEXT") == null ? "" : reqParams.get("RESPONSE_TEXT");
					reqParams.put("RESPONSE_TEXT", responseMessage);
					responseTxt = AuditInfo(request, reqParams, "U");
				}
				
				if (isDebugYN)
					System.out.println("***Inside Invoke External Application - Audit Info... " + responseTxt);
				
				PrintWriter resp = response.getWriter();
				resp.flush();
				resp.write(responseTxt);
				resp.close(); 
			}
			else {
			//	response.sendRedirect(getExternalApplicationURL(request));

				if(isDebugYN) System.out.println("***Inside Invoke External Application - Inside else request... ");
				processRequest(request, response, reqParams);
				sendResponse(request, response, reqParams);
			}
		}
		catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
    }
    
    private void sendResponse(HttpServletRequest request, HttpServletResponse response, 
    							Map<String, String> reqParams) throws Exception {
		
		if(isDebugYN) System.out.println("***Inside Invoke External Application - Inside send Response ::: ");
    	
		String responseType = reqParams.get("responseType");

		if(isDebugYN) System.out.println("***Inside Invoke External Application - Inside send Response responseType ::: "+responseType);

    	if("toInterface".equals(responseType)) {
    		request.getRequestDispatcher("responseURL").forward(request, response);
    	}
    	else if("toModule".equals(responseType)) {
    		String requestGUIType = reqParams.get("requestGUIType");
    		String responseTxt = reqParams.get("response");

			if(isDebugYN) System.out.println("***Inside Invoke External Application - Inside send Response requestGUIType ::: "+requestGUIType);

			if(isDebugYN) System.out.println("***Inside Invoke External Application - Inside send Response responseTxt ::: "+responseTxt);
    		
    		if(!"AJAX".equals(requestGUIType)) {
				if(isDebugYN) System.out.println("***Inside Invoke External Application - Inside if requestGUIType ::: ");
    			responseTxt = "<script>window.returnValue = '" + responseTxt + "';window.close();</script>";
    		}
    		
    		PrintWriter resp = response.getWriter();
    		resp.write(responseTxt);
    		resp.flush();
    		resp.close();
    	}	
    	else if(!"responseCommitted".equals(responseType)) {
    		response.sendRedirect(reqParams.get("response"));
    	}
    }

	private void processRequest(HttpServletRequest request, HttpServletResponse response,
			Map<String, String> reqParams) throws Exception {
		Map<String, String> auditInfo = ArrayAuditInfo.getMapAuditInfo(request.getSession(false));
		String locale = "en";
		String ipAddress = "";
		try {
			HttpSession session = request.getSession(false);
			Properties p = (Properties) session.getValue("jdbc");
			locale = p.getProperty("LOCALE");
			reqParams.put("locale", locale);			
			fetchDMSFilterDtls(reqParams);			
			reqParams.putAll(auditInfo);
			updateInteractiveParams(reqParams, auditInfo);
			fetchSettlementType(reqParams);	//Code added by Sethu for KDAH-CRF-0504 on 13/03/2019

			if("HP".equals(reqParams.get("protocolType")) // HP for HTTP POST
					|| "T".equals(reqParams.get("protocolType"))) {
					ipAddress = getIpAddress(request); // Added by Sethu to get the IP address 
					if(isDebugYN) System.out.println("***Inside Invoke External Application - TCP/HTTP IP Address of the client machine From function getIpAddress ::: "+ipAddress); // Added by Sethu to display the IP address 
					reqParams.put("IP_ADDRESS", ipAddress); // Added by Sethu to put the IP address in the reqParams
			}

			//System.out.println("protocolType... " + reqParams.get("protocolType"));
			if("HP".equals(reqParams.get("protocolType")) // HP for HTTP POST
					|| "T".equals(reqParams.get("protocolType"))) {
				ExternalApplicationHelper externalApplicationHelper = new ExternalApplicationHelper();
				externalApplicationHelper.processRequest(request, response, reqParams);
			}
			else if ("SO".equals(reqParams.get("protocolType")))
			{
				ipAddress = getIpAddress(request); // Added by Sethu to get the IP address 
				if(isDebugYN) System.out.println("***Inside Invoke External Application - SO IP Address of the client machine From function getIpAddress ::: "+ipAddress); // Added by Sethu to display the IP address 
				reqParams.put("IP_ADDRESS", ipAddress); // Added by Sethu to put the IP address in the reqParams
				CCWebTransactions(reqParams);
			}
			else { // DMS logic
				
				buildURL(reqParams);
			}
		}
		catch(java.net.ConnectException connectionExp) {
			System.out.println("***Inside Invoke External Application - Exception in Process Request Connection... " + connectionExp);
			connectionExp.printStackTrace(System.err);
			
			String resMessage = XHUtil.getLocaleMessage(locale, "XH0120", "XH");
			resMessage = "E" + "$|#" + resMessage + "$|#" + resMessage; // EM modules expect the response in delimited("$|#") format
			reqParams.put("response", resMessage);
			reqParams.put("responseType", "toModule");
		}
		catch(Exception exp) {
			System.out.println("***Inside Invoke External Application - Exception in Process Request... "+exp);
			exp.printStackTrace(System.err);
		}
		
	}

	private void fetchDMSFilterDtls(Map<String, String> reqParams) {

		if(isDebugYN) System.out.println("***Inside Invoke External Application - External Application ID... "+reqParams.get("intExtAppID"));

		String query = "SELECT application_id ||'$!^'|| protocol_link_id ||'$!^'|| facility_id ||'$!^'|| external_application ||'$!^'|| external_function ||'$!^'|| event_type FROM xh_filter_dms_vw WHERE "
						+ " login_user = '*' "
						+ " AND responsibility = '*' "
						+ " AND login_function = '*' "
						+ " AND external_application = NVL('" + reqParams.get("intExtAppID") + "', external_application)";
		String protocolQry = "SELECT protocol_type ||'$!^'|| xml_style_sheet_url ||'$!^'|| ip_address ||'$!^'|| port_number FROM xh_protocol WHERE protocol_id = '"+ reqParams.get("intExtAppID") + reqParams.get("P_FACILITY_ID") +"'";

		String[] queryResult = XHUtil.singleParamExeQry(query).split(Pattern.quote("$!^"), -1);
		String[] protocolQueryResult = XHUtil.singleParamExeQry(protocolQry).split(Pattern.quote("$!^"), -1);

		if(isDebugYN) System.out.println("***Inside Invoke External Application - QueryResult.length  ::: "+queryResult.length);

		if(queryResult.length == 6) {
			reqParams.put("APPLICATION_ID", queryResult[0]);
			reqParams.put("PROTOCOL_LINK_ID", queryResult[1]);
			reqParams.put("FACILITY_ID", queryResult[2]);
			reqParams.put("EXTERNAL_APPLICATION", queryResult[3]);
			reqParams.put("EXTERNAL_FUNCTION", queryResult[4]);
			reqParams.put("EVENT_TYPE", queryResult[5]);
		}
		
		if(isDebugYN) System.out.println("***Inside Invoke External Application - ProtocolQueryResult.length  ::: "+protocolQueryResult.length);

		if(protocolQueryResult.length == 4) {
			reqParams.put("protocolType", protocolQueryResult[0]);
			reqParams.put("URL", protocolQueryResult[1]);
			reqParams.put("IP_ADDRESS", protocolQueryResult[2]);
			reqParams.put("PORT_NUMBER", protocolQueryResult[3]);
		}
	}

	private void updateInteractiveParams(Map<String, String> reqParams, Map<String, String> auditInfo) {

		String strDate = XHUtil.getFormattedStringDate("dd-MMM-yyyy HH:mm:ss", null);

		reqParams.put("LOGIN_USER", auditInfo.get("loginUser"));

		reqParams.put("CLIENT_MACHINE", auditInfo.get("clientIPAddress"));
		if(isDebugYN) System.out.println("***Inside Invoke External Application - Audit Info Client IP Address ::: "+auditInfo.get("clientIPAddress"));
		reqParams.put("FACILITY_ID", auditInfo.get("facilityID"));
		
		//Modified By Gopinath for ML-MMOH-SCF-2469 on 13/07/2023
//		reqParams.put("PGM_ID",reqParams.get("intExtAppID") + reqParams.get("P_FACILITY_ID"));
		reqParams.put("PGM_ID",reqParams.get("intExtAppID"));
		
		reqParams.put("MODULE_ID", "XH");
		reqParams.put("SESSION_ID", auditInfo.get("sessionID"));
		reqParams.put("REQUEST_DATE", strDate);
		reqParams.put("FACILITY_ID", auditInfo.get("facilityID"));
		reqParams.put("MESSAGE_DATE", strDate);
		reqParams.put("PATIENT_ID", reqParams.get("P_patient_id"));
		reqParams.put("EPISODE_TYPE", reqParams.get("P_EPISODE_TYPE"));
		reqParams.put("ENCOUNTER_ID", reqParams.get("P_ENCOUNTER_ID"));
		reqParams.put("ACC_NO", reqParams.get("P_ACCESSION_NUM"));
		reqParams.put("EXT_ACC_NO", "");			
		reqParams.put("ADDED_BY_ID", auditInfo.get("loginUser"));
		reqParams.put("ADDED_BY_DATE", strDate);
		reqParams.put("MODIFIED_BY_ID", auditInfo.get("loginUser"));
		reqParams.put("MODIFIED_BY_DATE", strDate);
		reqParams.put("ADDED_BY_FACILITY", auditInfo.get("facilityID"));
		reqParams.put("MODIFIED_BY_FACILITY", auditInfo.get("facilityID"));
	}

	public String checkMultiApplication(HttpServletRequest request) 
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, String> applications = new LinkedHashMap<String, String>();
		String retStr = "FALSE";
		
		String key_2="N";
		//Query is changed by prithivi on 28/07/2016 for medicity walletree key_1 and key_2-- External applications common check
		String qry = "SELECT external_application,key_2 FROM xh_filter_dms_vw WHERE "
						+ " login_user = (decode(login_user, '*', login_user, ?)) "
						+ " AND responsibility = (decode(responsibility, '*', responsibility, ?)) "
						+ " AND login_function = (decode(login_function, '*', login_function, ?)) "
						+ " AND key_1 = (decode(key_1, '*', key_1, ?)) ";
		
		try {
			String respID = XHDBAdapter.isNullReplace(request.getParameter("P_RESP_ID"), "*");
			String funcID = XHDBAdapter.isNullReplace(request.getParameter("P_FUNCTION_ID"), "*");
			String loggedInUser = XHDBAdapter.isNullReplace(request.getParameter("P_USE_ID"), (String)request.getSession(false).getValue("login_user"));
			String settlementType = XHDBAdapter.isNullReplace(request.getParameter("P_settlement_type"), "DMS");

			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareCall(qry);
			pstmt.setString(1, loggedInUser);
			pstmt.setString(2, respID);
			pstmt.setString(3, funcID);
			pstmt.setString(4, settlementType);
			rs = pstmt.executeQuery();
			if(isDebugYN) 
				System.out.println("***Inside Invoke External Application - checkMultiApplication - Logged in User ID::: "+loggedInUser+ " *** Responsibility ID... "+respID+" ***Function ID... "+funcID+" ***Settlement Type... "+settlementType);

			applications.put("", "Select");

				/*while(rs.next()) {
				applications.put(rs.getString("external_application"), rs.getString("external_application"));
				}
				
				if(applications.size() > 2) {
					retStr = "TRUE";
				}
				else if(applications.size() == 2) {
					retStr = "FALSE|" + (new ArrayList<String>(applications.values())).get(1);
				} */

				while(rs.next()) {
				applications.put(rs.getString("external_application"), rs.getString("external_application"));
				if(isDebugYN) 
					System.out.println("***Inside Invoke External Application - checkMultiApplication - Application ID... "+rs.getString("external_application") + "   ***Key_2... "+rs.getString("key_2"));

					if("Y".equals(rs.getString("key_2")))
					{
						key_2 = "Y";
					}
			     }
            if(applications.size() == 2)
			{
              retStr = "FALSE|" + (new ArrayList<String>(applications.values())).get(1) +"|"+ key_2 ;
			}
			else if(applications.size() > 2)
			{
              retStr = "TRUE";
			}
			
			if(isDebugYN) 
				System.out.println("***Inside Invoke External Application - checkMultiApplication :: retStr.."+retStr);

			request.setAttribute("applications", applications);
		}
		catch(Exception exp){
			System.out.println("***Inside Invoke External Application - Exception in checkMultiApplication - " + exp);
			exp.printStackTrace(System.err);
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}
		return retStr;
	}


	public String getExternalApplicationURL(HttpServletRequest request) throws Exception
	{
		String url = "";
		Map<String, String> reqParams = XHUtil.getRequestParams(request);
		
		url = buildURL(reqParams);
		return url;
	}
	
	public String buildURL(Map<String, String> reqParams) throws Exception
	{
		String externalAppURL = "";
		String requestParams = "";
		String query = "SELECT xml_style_sheet_url || '$!^' || odbc_user_id || '$!^' || odbc_pwd || '$!^' || protocol_type FROM xh_protocol WHERE protocol_id = '"+ reqParams.get("intExtAppID") + reqParams.get("P_FACILITY_ID") +"'";

		if(isDebugYN) 
				System.out.println("***Inside Invoke External Application - BuildURL - Query... "+query);

		String[] queryResult = XHUtil.singleParamExeQry(query).split(Pattern.quote("$!^"), -1);
		

		Map<String, String> emRequestParams = processEMRequestParams(reqParams, queryResult); // params that are received in the request from the requested module
		Map<String, String> extRequestParams = getExpectedRequestParams(reqParams, queryResult, emRequestParams); // params that are to be included in request when calling external app

		for(Map.Entry<String, String> param : extRequestParams.entrySet())
		{
			String interfaceKey = param.getKey();
			String interfaceValue = param.getValue();			
			String requestValue = XHDBAdapter.checkNull(emRequestParams.get(interfaceValue));
			if(isDebugYN) {
				System.out.println("***Inside Invoke External Application - buildURL - interfaceKey "+interfaceKey);
				System.out.println("***Inside Invoke External Application - buildURL - interfaceValue "+interfaceValue);
				System.out.println("***Inside Invoke External Application - buildURL - requestValue "+requestValue);
			}

			if("EXT_APPL_URL".equals(interfaceKey)) {
				externalAppURL = interfaceValue;
			}
			else if(!"exePath".equals(interfaceKey)){
				if(interfaceKey.equals("scanDocId") && "".equals(emRequestParams.get(interfaceValue))){
					
				}
				else {
					String tempValue = "";
					if("P_DOC_TYPE_TRANSLATION".equals(interfaceValue)) {
						tempValue = XHUtil.singleParamExeQry("SELECT ext_pk_id FROM xh_oth_appl_data_skey WHERE table_id = 'SM_FUNCTION' AND application_id = 'DMS' AND pk_value = '" + XHDBAdapter.isNullReplace(emRequestParams.get("P_FUNCTION_ID"), "*") + "'");
					}
					else {
						tempValue = XHDBAdapter.isNullReplace(emRequestParams.get(interfaceValue), interfaceValue);
					}
					
					if(emRequestParams.containsKey(interfaceValue)) {
						tempValue = XHDBAdapter.isNullReplace(emRequestParams.get(interfaceValue), "");
					}
					requestParams += interfaceKey + "=" + URLEncoder.encode(tempValue, "UTF8").replace("+", "%20") + "&";
					
				}
			}
			if(isDebugYN) {
				System.out.println("***Inside Invoke External Application - buildURL - requestParams - "+requestParams);
			}
		}

		externalAppURL = extRequestParams.get("EXT_APPL_URL");
		int testLen = requestParams.length();
		if(requestParams.charAt(testLen - 1) == '&') {
			requestParams = requestParams.substring(0, testLen - 1);
		}
		
		if("C".equals(queryResult[3])) {
			externalAppURL += "exePath=" +  URLEncoder.encode(extRequestParams.get("exePath")) 
								+ "&exeParams=" + URLEncoder.encode(requestParams);
		}
		else {
			externalAppURL += requestParams;
		}
				
		if(isDebugYN) {
			System.out.println("***Inside Invoke External Application - buildURL - externalAppURL - "+externalAppURL);
		}
		
		reqParams.put("response", externalAppURL);
		return externalAppURL;
	}
/*
	private Map<String, String> getExpectedRequestParams()
	{
		Map<String, String> extRequestParams = new HashMap<String, String>();
		extRequestParams.put("P_userID", "TESTING");
		extRequestParams.put("P_PWD", "TESTING");

		return extRequestParams;
	}
*/
	/**
	 * Converts all the request variables in to HashMap and adds additional params which are to be replaced 
	 * in the URL values as per the forms variable naming convention.
	 * Ex:- Patient ID variable in request will be as P_PATIENT_ID where as in URL(URL from XH_PROTOCOL) it will be as u_patient_id. 
	 *		In this case additional param u_patient_id will be added to HashMap which will be helpful in replacing the URL values easily in getExternalApplicationURL method
	 */
	public Map<String, String> processEMRequestParams(Map<String, String> reqParams, String[] queryResult)
	{
		Map<String, String> emRequestParams = reqParams;
		
		String encounterID = reqParams.get("P_ENCOUNTER_ID");
		
		if(encounterID == null || encounterID.equals("")) {
			encounterID = reqParams.get("P_EPISODE_ID");
			String visitID = reqParams.get("P_VISIT_ID");
			if(visitID != null && !visitID.equals("")) {
				if(visitID.length() == 1) encounterID = "000" + visitID;
				else if(visitID.length() == 2) encounterID = "00" + visitID;
				else if(visitID.length() == 3) encounterID = "0" + visitID;
			}
			
			emRequestParams.put("u_encounter_id", encounterID);
		}

		if(reqParams.containsKey("P_USE_ID")) emRequestParams.put("u_login_user", reqParams.get("P_USE_ID"));
		if(reqParams.containsKey("P_PATIENT_ID")) emRequestParams.put("u_patient_id", reqParams.get("P_PATIENT_ID"));
		if(reqParams.containsKey("P_ENCNTR_DATE")) emRequestParams.put("u_encntr_date", XHUtil.convertDateFormat(reqParams.get("P_ENCNTR_DATE"),"dd/MM/yyyy hh:mm", "yyyyMMddhhmmss"));
		if(reqParams.containsKey("P_VISIT_ID")) emRequestParams.put("u_visit_id", reqParams.get("P_VISIT_ID"));
		if(reqParams.containsKey("P_EPISODE_ID")) emRequestParams.put("u_episode_id", reqParams.get("P_EPISODE_ID"));
		if(reqParams.containsKey("P_ENCOUNTER_ID")) emRequestParams.put("u_encounter_id", reqParams.get("P_ENCOUNTER_ID"));
		if(reqParams.containsKey("P_EPISODE_TYPE")) emRequestParams.put("u_episode_type", reqParams.get("P_EPISODE_TYPE"));
		if(reqParams.containsKey("P_PHYSICIAN_ID")) emRequestParams.put("u_physician_id", reqParams.get("P_PHYSICIAN_ID"));
		if(reqParams.containsKey("P_ACCESSION_NUM")) emRequestParams.put("u_acc_no", reqParams.get("P_ACCESSION_NUM"));
		if(reqParams.containsKey("P_ORDER_ID")) emRequestParams.put("u_order_id", reqParams.get("P_ORDER_ID"));
		if(reqParams.containsKey("P_ORDER_TYPE_CODE")) emRequestParams.put("u_order_type_code", reqParams.get("P_ORDER_TYPE_CODE"));
		if(reqParams.containsKey("P_LOCN_TYPE")) emRequestParams.put("u_locn_type", reqParams.get("P_LOCN_TYPE"));
		if(reqParams.containsKey("P_LOCN_CODE")) emRequestParams.put("u_locn_code", reqParams.get("P_LOCN_CODE"));
		if(reqParams.containsKey("P_CUST_CODE")) emRequestParams.put("u_cust_code", reqParams.get("P_CUST_CODE"));
		if(reqParams.containsKey("P_ITEM_CODE")) emRequestParams.put("u_item_code", reqParams.get("P_ITEM_CODE"));
		if(reqParams.containsKey("P_RESP_ID")) emRequestParams.put("u_resp_id", reqParams.get("P_RESP_ID"));
		if(reqParams.containsKey("P_FACILITY_ID")) emRequestParams.put("u_facility_id", reqParams.get("P_FACILITY_ID"));
		if(reqParams.containsKey("P_INV_ORG_ID")) emRequestParams.put("u_inv_org_id", reqParams.get("P_INV_ORG_ID"));
		if(reqParams.containsKey("P_MODULE_ID")) emRequestParams.put("u_module_id", reqParams.get("P_MODULE_ID"));
		if(reqParams.containsKey("P_FUNCTION_ID")) emRequestParams.put("u_function_id", reqParams.get("P_FUNCTION_ID"));
		if(reqParams.containsKey("P_ACCESS_RIGHTS")) emRequestParams.put("u_access_rights", reqParams.get("P_ACCESS_RIGHTS"));
		if(reqParams.containsKey("P_LANGUAGE_ID")) emRequestParams.put("u_language_id", reqParams.get("P_LANGUAGE_ID"));
		if(reqParams.containsKey("P_MULTI_SITE_YN")) emRequestParams.put("u_multi_site_yn", reqParams.get("P_MULTI_SITE_YN"));
		if(reqParams.containsKey("P_MULTI_LANG_YN")) emRequestParams.put("u_multi_lang_yn", reqParams.get("P_MULTI_LANG_YN"));
		if(reqParams.containsKey("P_ENC_STATUS")) emRequestParams.put("u_enc_status", reqParams.get("P_ENC_STATUS"));
		if(reqParams.containsKey("P_LOCN_DESC")) emRequestParams.put("u_locn_desc", reqParams.get("P_LOCN_DESC"));
		if(reqParams.containsKey("P_WS_NO")) emRequestParams.put("u_ws_no", reqParams.get("P_WS_NO"));
		if(reqParams.containsKey("P_Ext_Input_Key")) emRequestParams.put("u_ext_input_key", reqParams.get("P_Ext_Input_Key"));
		if(reqParams.containsKey("P_Ext_Application_ID")) emRequestParams.put("u_ext_application_id", reqParams.get("P_Ext_Application_ID"));
		if(reqParams.containsKey("P_Ext_Function")) emRequestParams.put("u_ext_function", reqParams.get("P_Ext_Function"));
		if(reqParams.containsKey("P_pwd")) emRequestParams.put("u_user_password", reqParams.get("P_pwd"));
		if(reqParams.containsKey("P_Connect_string")) emRequestParams.put("u_connect_string", reqParams.get("P_Connect_string"));
		emRequestParams.put("u_interface_user_id", queryResult[1]);
		emRequestParams.put("u_interface_pwd", queryResult[2]);

		//Changes added by Sethu for TBMC-CRF-0005 for DCS on 15/10/2018
		if(reqParams.containsKey("P_END_DATE")) emRequestParams.put("u_end_date", reqParams.get("P_END_DATE"));	
		if(reqParams.containsKey("P_START_DATE")) emRequestParams.put("u_start_date", reqParams.get("P_START_DATE"));

		//Changes added by Sethu for NMC-JD-CRF-0038.1 for ALNADHI on 01/02/2020
		if(reqParams.containsKey("P_NUHDEEK_ID")) emRequestParams.put("u_loyalty_no", reqParams.get("P_NUHDEEK_ID"));

	
		return emRequestParams;
	}

	/**
	 * xml_style_sheet_url should contain the value as follows
	 * '//cscappche608:8899/eHIS/eCA/jsp/InvokePatientHistoryWrapper.jsp?p_login_user='||@u_login_user||'+p_user_password='||@u_user_password||'+p_resp_id='||@u_resp_id||'+p_patient_id='||@u_patient_id||'+p_facility_id='||@u_facility_id||'+p_encounter_id='||@u_encounter_id||'+mode=R+accession_type=RD+accession_number='||@u_acc_no||'+locale='||@u_language_id
	 * @param emRequestParams 
	 */
	public Map<String, String> getExpectedRequestParams(Map<String, String> reqParams, String[] queryResult, Map<String, String> emRequestParams)
	{
		Map<String, String> extRequestParams = new HashMap<String, String>();
		String protocolType = queryResult[3];
		String url = "";
		
		if("C".equals(protocolType)) {
			url = replaceDynamicParams(queryResult[0], emRequestParams);
		}
		else {
			url = queryResult[0];
		}
		
		if(isDebugYN) {
			System.out.println("***Inside Invoke External Application - getExpectedRequestParams - url "+url);
			System.out.println("***Inside Invoke External Application - getExpectedRequestParams - url.substring(url.indexOf(?) + 1) "+url.substring(url.indexOf("?") + 1));
		}
		
		url = url.replaceAll(Pattern.quote("'||@"), "").replaceAll(Pattern.quote("||'+"), "&");	
		
		if(isDebugYN) {
			System.out.println("***Inside Invoke External Application - getExpectedRequestParams - url "+url);
			System.out.println("***Inside Invoke External Application - getExpectedRequestParams - url.substring(url.indexOf(?) + 1) "+url.substring(url.indexOf("?") + 1));
		}
		
		List<String> requestParams = Arrays.asList(url.substring(url.indexOf("?") + 1).split("\\&"));
		if("C".equals(protocolType)) {
			extRequestParams.put("EXT_APPL_URL", "../eXH/jsp/InvokeExternalLink.jsp?");
			extRequestParams.put("exePath", url.substring(0, url.indexOf("?")));
		}
		else {
			extRequestParams.put("EXT_APPL_URL", url.substring(0, url.indexOf("?") + 1));
		}

		for(String currentParam : requestParams)
		{
			String [] currentParamAttributes = currentParam.split("=", -1);
			if("C".equals(protocolType)) {
				extRequestParams.put(currentParamAttributes[0], currentParam.substring(currentParam.indexOf("=") + 1));
			}
			else {
				if(isDebugYN) {
					System.out.println("***Inside Invoke External Application - getExpectedRequestParams - currentParamAttributes[0]::: "+currentParamAttributes[0]+" ::: "+currentParamAttributes[1]);					
				}
				extRequestParams.put(currentParamAttributes[0], currentParamAttributes[1]);
			}
		}
		return extRequestParams;
	}

	public String replaceDynamicParams(String url, Map<String, String> emRequestParams)
	{
		Pattern pattern = Pattern.compile("'\\|\\|@(.*?)\\|\\|'");
		Matcher matcher = pattern.matcher(url);
		while(matcher.find())
		{
			String param = matcher.group(1);
			String currentMatch = matcher.group();
			String paramValue = StringUtils.defaultString(emRequestParams.get(param));
			url = url.replace(currentMatch, paramValue);
		}
		if(isDebugYN) {
			System.out.println("***Inside Invoke External Application - replaceDynamicParams - URL - " + url);
		}
		// Param which is at the last of the URL that have to be replaced. 
		// Eg:- u_language_id in this url - '//cscappche608:8899/eHIS/eCA/jsp/InvokePatientHistoryWrapper.jsp?p_login_user='||@u_login_user||'+p_user_password='||@u_user_password||'+p_resp_id='||@u_resp_id||'+p_patient_id='||@u_patient_id||'+p_facility_id='||@u_facility_id||'+p_encounter_id='||@u_encounter_id||'+mode=R+accession_type=RD+accession_number='||@u_acc_no||'+locale='||@u_language_id
		if(url.indexOf("'||@") != -1) {
			String lastParam = url.substring(url.indexOf("'||@") + 4);
			url = url.replace(lastParam, emRequestParams.get(lastParam));
		}
		return url;
	}
	
	// Function added by Sethu 06/08/2015 to get the IP address of the client machine. 
	// Parameter HTTP Request object.
	// Returns the IP Address.
	// This function is called from the processRequest.
	public String getIpAddress(HttpServletRequest request) {      
	   String ip = request.getHeader("x-forwarded-for");      
	   if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
		   ip = request.getHeader("Proxy-Client-IP");      
	   }      
	   if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
		   ip = request.getHeader("WL-Proxy-Client-IP");      
	   }      
	   if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
		   ip = request.getRemoteAddr();      
	   }      
	   return ip;      
	}

	 /*
	* We can use this method for all plugin process
	* This method is used communicate with plugin for epos transaction
	* created by prithivi on 18/10/2016 for MMS-QH-CRF-0020
	*/
	private String callInterfaceExteralApp(HttpServletRequest request, HttpServletResponse response, Map<String, String> reqParams)throws ServletException, IOException 
	{

        Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String responseMessage="";
		String pluginPort="";

		String amount="";

		String machinePort="";
		String baudRate="";
		String ecrCounter="";

		//Aadded by sethu for MMS-SCF-DM-0600 on 24/07/2019
		int ccAppletEnabled = 0; 
		String strApplicationID = "";
		String strWaitTime = "";

		try{
			String requestMessage="";
			String clientIpAddress ="";

			clientIpAddress = getIpAddress(request);
			amount=request.getParameter("P_Total_Bill_Amount");
			pluginPort=request.getParameter("PluginPort");

			if(isDebugYN) 
			{
			   System.out.println("***Inside Invoke External Application - CreditcardInterfaceExternalApp - amount...."+amount);
			   System.out.println("***Inside Invoke External Application - CreditcardInterfaceExternalApp - pluginPort...."+pluginPort);
			}
			
			String qry = "select ELEMENT_ID,DEFAULT_VALUE from xh_standard_control_seg where segment_id='CC' and standard_code='SPECTRACC1'";

		    dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(qry);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				
				if("MACPORT".equals(rs.getString("ELEMENT_ID")))
				{
					machinePort=rs.getString("DEFAULT_VALUE");
				}
				else if("BAUDRATE".equals(rs.getString("ELEMENT_ID")))
				{
					baudRate=rs.getString("DEFAULT_VALUE");
				}
				else if("ECRCTR".equals(rs.getString("ELEMENT_ID")))
				{
					ecrCounter=rs.getString("DEFAULT_VALUE");
				}

			}
           
			if(isDebugYN) {
			   System.out.println("***Inside Invoke External Application - CreditcardInterfaceExternalApp - machinePort...."+machinePort);
			   System.out.println("***Inside Invoke External Application - CreditcardInterfaceExternalApp - baudRate...."+baudRate);
			   System.out.println("***Inside Invoke External Application - CreditcardInterfaceExternalApp - ecrCounter...."+ecrCounter);
			}
			requestMessage="Transaction_type=debit$!^Amount="+amount+"$!^ECR_counter="+ecrCounter+"$!^Application_id=11$!^Refund_rrn=null$!^Menu=null$!^Printer=null$!^Printer_speed=null$!^Machine_port="+machinePort+"$!^BoudRate="+baudRate;

			if(isDebugYN) 
				System.out.println("***Inside Invoke External Application - CreditcardInterfaceExternalApp - requestMessage...."+requestMessage);

			//Aadded by sethu for MMS-SCF-DM-0600 on 24/07/2019

			strApplicationID = reqParams.get("intExtAppID");
			requestMessage+= "$!^intExtAppID="+strApplicationID;

			ccAppletEnabled = Integer.parseInt(reqParams.get("P_CCAppletEnabled"));

			strWaitTime = FetchResponseWaitTime("CC");

			requestMessage+= "$!^WaitTime="+strWaitTime;

			if(isDebugYN) 
				System.out.println("***Inside Invoke External Application - CreditcardInterfaceExternalApp - ccAppletEnabled...."+ccAppletEnabled);
			
			if (ccAppletEnabled>0)
			{
				return requestMessage;
			}

			responseMessage=sendRequest(clientIpAddress,pluginPort,requestMessage);
         
			if(isDebugYN)
			   System.out.println("***Inside Invoke External Application - CreditcardInterfaceExternalApp - responseMessage...."+responseMessage);

		}
		catch(InterruptedException e)
		{
	       	e.printStackTrace();
		}
		catch(Exception ex)
		{
	       	ex.printStackTrace();
		}
		finally
		{			
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}
		return responseMessage;
	}
	
	private String callInterfaceExteralPaysysApp(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> reqParams)
			throws ServletException, IOException {
		
		if (isDebugYN) 
			System.out.println("***Inside Invoke External Application - CreditcardInterfaceExternalPaysysApp - Method Inside....");

		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String responseMessage = "";
		String pluginPort = "";

		String amount = "";

		String machinePort = "";
		String baudRate = "";
		String ecrCounter = "";

		// Aadded by sethu for MMS-SCF-DM-0600 on 24/07/2019
		int ccAppletEnabled = 0;
		String strApplicationID = "";
		String strWaitTime = "";

		try {
			String requestMessage = "";
			String clientIpAddress = "";

			// Modified by Gopinath for MMOH-CRF-1928 on 06/04/2023
			clientIpAddress = request.getParameter("P_WS_NO");
			
			if (isDebugYN) 
				System.out.println("***Inside Invoke External Application - CreditcardInterfaceExternalPaysysApp - clientIpAddress Name...." + clientIpAddress);
				
			try {
				InetAddress host = InetAddress.getByName(clientIpAddress);				
				clientIpAddress = host.getHostAddress();
				
				if (isDebugYN) 
					System.out.println("***Inside Invoke External Application - CreditcardInterfaceExternalPaysysApp - clientIpAddress...." + clientIpAddress);
					
			} catch (UnknownHostException ex) {
				if (isDebugYN) 
					System.out.println("***Inside Invoke External Application - CreditcardInterfaceExternalPaysysApp - UnknownHostException...." + ex.getMessage());
				
				ex.printStackTrace();
			} finally {
				
			}
			
			amount = request.getParameter("P_Total_Bill_Amount");
			pluginPort = request.getParameter("PluginPort");

			if (isDebugYN) {
				System.out.println("***Inside Invoke External Application - CreditcardInterfaceExternalPaysysApp - clientIpAddress...." + clientIpAddress);
				System.out.println("***Inside Invoke External Application - CreditcardInterfaceExternalPaysysApp - amount...." + amount);
				System.out.println("***Inside Invoke External Application - CreditcardInterfaceExternalPaysysApp - pluginPort...." + pluginPort);
			}

			// segment_id='PYS' and standard_code='PAYSYSCC1' are standard for Paysys Payment Gateway
			String qry = "select ELEMENT_ID,DEFAULT_VALUE from xh_standard_control_seg where segment_id='PYS' and standard_code='PAYSYSCC1'";

			if (isDebugYN) 
				System.out.println("***Inside Invoke External Application - CreditcardInterfaceExternalPaysysApp - Query...." + qry);
				
			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(qry);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				if ("MACPORT".equals(rs.getString("ELEMENT_ID"))) {
					machinePort = rs.getString("DEFAULT_VALUE");
				} else if ("BAUDRATE".equals(rs.getString("ELEMENT_ID"))) {
					baudRate = rs.getString("DEFAULT_VALUE");
				} else if ("ECRCTR".equals(rs.getString("ELEMENT_ID"))) {
					ecrCounter = rs.getString("DEFAULT_VALUE");
				}

			}

			if (isDebugYN) {
				System.out
						.println("***Inside Invoke External Application - CreditcardInterfaceExternalPaysysApp - machinePort...."
								+ machinePort);
				System.out
						.println("***Inside Invoke External Application - CreditcardInterfaceExternalPaysysApp - baudRate...."
								+ baudRate);
				System.out
						.println("***Inside Invoke External Application - CreditcardInterfaceExternalPaysysApp - ecrCounter...."
								+ ecrCounter);
			}

			// sample request message
			// requestMessage =
			// "Transaction_type=debit$!Amount=500.00$!ECR_counter=1$!Application_id=PAYSYS$!Machine_port=COM6$!BoudRate=9600$!WaitTime=60";

			requestMessage = "Transaction_type=debit$!^Amount=" + amount
					+ "$!^ECR_counter=" + ecrCounter
					+ "$!^Application_id=PAYSYS$!^Machine_port=" + machinePort
					+ "$!^BoudRate=" + baudRate;

			if (isDebugYN)
				System.out
						.println("***Inside Invoke External Application - CreditcardInterfaceExternalPaysysApp - requestMessage...."
								+ requestMessage);

			ccAppletEnabled = Integer.parseInt(reqParams
					.get("P_CCAppletEnabled"));

			strWaitTime = FetchResponseWaitTime("CP");

			requestMessage += "$!^WaitTime=" + strWaitTime;

			if (isDebugYN)
				System.out.println("***Inside Invoke External Application - CreditcardInterfaceExternalPaysysApp - ccAppletEnabled...."
								+ ccAppletEnabled);

			if (ccAppletEnabled > 0) {
				return requestMessage;
			}

			// Inserting Audit Interactive Details Start
			// Added by Gopinath for ML-MMOH-SCF-2469 on 11/07/2023
			reqParams.put("REQUEST_TEXT", requestMessage);
			reqParams.put("RESPONSE_TEXT", "");
			if (isDebugYN)
				System.out.println("***Inside Invoke External Application - Insert AuditInfo - reqParams...." + reqParams.toString());
			String auditResponse = "";
			auditResponse = AuditInfo(request, reqParams, "I");
			if (isDebugYN)
			System.out.println("***Inside Invoke External Application - Insert Audit Info... " + auditResponse);
			// Inserting Audit Interactive Details Stop
			
			responseMessage = sendRequest(clientIpAddress, pluginPort, requestMessage);
			
			if (isDebugYN)
				System.out.println("***Inside Invoke External Application - CreditcardInterfaceExternalPaysysApp - responseMessage...." + responseMessage);			
			
			// Update Audit Interactive Details Start
			// Added by Gopinath for MMOH-CRF-1928.2 on 15/06/2023
			reqParams.put("REQUEST_TEXT", requestMessage);
			reqParams.put("RESPONSE_TEXT", responseMessage);
			if (isDebugYN)
				System.out.println("***Inside Invoke External Application - Update AuditInfo - reqParams...." + reqParams.toString());			
			auditResponse = AuditInfo(request, reqParams, "U");
			if (isDebugYN)
			System.out.println("***Inside Invoke External Application - Update Audit Info... " + auditResponse);
			// Update Audit Interactive Details Stop

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}
		return responseMessage;
	}
	
   /* 
	* This method is uesd to process the tcp transactions.
   */
	private static String sendRequest(String ipAddress, String PluginPort, String message) throws Exception
	{
		String response = "";
		OutputStreamWriter outputStream = null;
		BufferedInputStream inputStream = null;
		Socket socket = null;
		byte [] responseBytes = new byte[1000000]; // 1 MB of bytes
		try
		{
			socket = new Socket(ipAddress, Integer.parseInt(PluginPort));
			outputStream = new OutputStreamWriter(socket.getOutputStream());		
			outputStream.write(message);
			outputStream.flush();

			inputStream = new BufferedInputStream((socket.getInputStream()));
			int responseLength = inputStream.read(responseBytes);
			response = new String(responseBytes, 0, responseLength);
			
			System.out.println("***Inside Invoke External Application - sendRequest - Response " + response);
		}
		catch (Exception exp) {
			System.out.println("***Inside Invoke External Application - Exception in sendRequest: " + exp);
			throw exp;
		}
		finally {
			XHUtil.closeResourse(outputStream);
			XHUtil.closeResourse(inputStream);
		}
		return response;
	}

	/*
	* Added by Sethu on 19/04/2017 for GHL-CRF-0415 
	* This method is used for PayTM Transactions
	*/


	private String PayTMTransactions(Map<String, String> reqParams) throws Exception 
	{
		String responseTxt="";
		Connection dbConn = null;
		ResultSet rs=null;
		CallableStatement ostmt = null;
		String p_response="", errorCode = "", errorMsg = "";

		String paramString=reqParams.get("paramString");
		if(isDebugYN) 
			System.out.println("***Inside Invoke External Application - PayTMTransactions - paramString...."+paramString);
		try
		{   
				
			dbConn = ConnectionManager.getConnection();

			ostmt = dbConn.prepareCall("{ CALL BL_CREDIT_CARD.POST_PAYTM_REQUEST('PAYTMPROF1','PAYTM',?,?,?,?) }" );
			ostmt.setString(1,paramString);
			ostmt.registerOutParameter(2,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);
			ostmt.execute();
			p_response = ostmt.getString(2);
			errorCode = ostmt.getString(3);
			errorMsg = ostmt.getString(4);
			if(isDebugYN) 
				System.out.println("***Inside Invoke External Application - PayTMTransactions - p_response ::: "+p_response);

			if((errorMsg != null) && (errorMsg.trim().length()>0)) 
			{
				responseTxt=errorMsg;	
			}
			else
			{
				if(errorCode=="S" || "S".equalsIgnoreCase(errorCode))
				{
					 responseTxt=p_response;
				}
				else
				{
					 responseTxt=p_response;
				}
			}
			
			if(isDebugYN) 		
				System.out.println("***Inside Invoke External Application - PayTMTransactions - responseTxt "+responseTxt);
		}
		catch(Exception exp)
		{
			System.out.println("***Inside Invoke External Application - PayTMTransactions - Exception at executing procedure "+exp);
			exp.printStackTrace(System.err);
		}
		finally
		{			
			XHUtil.closeDBResources(rs, ostmt, dbConn);
		}
		if(isDebugYN) 
			System.out.println("***Inside Invoke External Application - PayTMTransactions - responseTxt...."+responseTxt);

		return responseTxt;	
	}

	// Added for AMRI-CRF-0399
	private void CCWebTransactions(Map<String, String> reqParams) throws Exception 
	{
		String responseTxt="";
		Connection dbConn = null;
		ResultSet rs=null;
		CallableStatement ostmt = null;
		String protocol_link_id = "";
		String p_response="", errorCode = "", errorMsg = "";

		//String paramString=reqParams.get("paramString");
		String paramString=reqParams.toString();

		if(isDebugYN) 
			System.out.println("***Inside Invoke External Application - CCWebTransactions - paramString...."+paramString);
		    System.out.println(" Req Params : "+reqParams);
		try
		{   
			fetchDMSFilterDtls(reqParams);
			protocol_link_id = reqParams.get("PROTOCOL_LINK_ID");
				
			dbConn = ConnectionManager.getConnection();

			ostmt = dbConn.prepareCall("{ CALL BL_CREDIT_CARD.CC_WEB_REQUEST(?,?,?,?,?) }" );
			ostmt.setString(1,protocol_link_id);
			ostmt.setString(2,paramString);
			ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(5,java.sql.Types.VARCHAR);
			ostmt.execute();
			p_response = ostmt.getString(3);
			errorCode = ostmt.getString(4);
			errorMsg = ostmt.getString(5);
			if(isDebugYN) 
				System.out.println(" ::: p_response ::: "+p_response);

			if((errorMsg != null) && (errorMsg.trim().length()>0)) 
			{
				responseTxt=errorMsg;	
			}
			else
			{
				if(errorCode=="S" || "S".equalsIgnoreCase(errorCode))
				{
					 responseTxt=p_response;
				}
				else
				{
					 responseTxt=p_response;
				}
			}

			//responseTxt = TX12345678,“7261A9”,”APPROVED”,”940115******2409”,”XXXX”,”RamSingh”,””,101,9001,”3000 0001”,0,”PROCESSED”, ”PAYBACK”, ”000100090015607”,” 624615343002”,1, 1,” HPCL Area 18”,” Kamla Mills”,” Noida”,”v.01.00.00”,91,"","40000","","50000","90000","9401150099532409","","","","02012011","210403"


			reqParams.put("RESPONSE_TEXT", responseTxt);
			
			if(isDebugYN) 		
				System.out.println("***Inside Invoke External Application - CCWebTransactions - responseTxt "+responseTxt);

			CreditCardDAO creditCardDAO = new CreditCardDAO();

			reqParams.put("responseType", "toModule");
			
			String responseMsg = creditCardDAO.getSettleBillResponsePlutus(reqParams);

			if(isDebugYN)
				System.out.println("***Inside Invoke External Application - CCWebTransactions - Response " + responseMsg);

			reqParams.put("response", responseMsg);
		}
		catch(Exception exp)
		{
			System.out.println("***Inside Invoke External Application - CCWebTransactions - Exception at executing procedure..."+exp);
			exp.printStackTrace(System.err);
		}
		finally
		{			
			XHUtil.closeDBResources(rs, ostmt, dbConn);
		}
		if(isDebugYN) 
			System.out.println("***Inside Invoke External Application - CCWebTransactions - responseTxt...."+responseTxt);

	}
	

	private String PHISTransactions(Map<String, String> reqParams) throws Exception 
	{
		String responseTxt="";
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String p_response_msg="";

		String paramString=reqParams.get("paramString");
		if(isDebugYN) 
			System.out.println("***Inside Invoke External Application - PHISTransactions - paramString...."+paramString);
		try
		{   
				
			dbConn = ConnectionManager.getConnection();

			pstmt = dbConn.prepareStatement(" Select XML_FORMAT from XH_XML_FORMAT where XML_ID = ?" );
			pstmt.setString(1,"PHIS");
			
			rs = pstmt.executeQuery();

			while(rs.next())
			{
			   p_response_msg = rs.getString("XML_FORMAT");
			}
			
			if(isDebugYN) 
				System.out.println("***Inside Invoke External Application - PHISTransactions - p_response_msg ::: "+p_response_msg);

			PHISTransaction PhisTrans = new PHISTransaction();

			responseTxt = PhisTrans.TransRequestMethod(p_response_msg);

			if(isDebugYN) 
				System.out.println("***Inside Invoke External Application - PHISTransactions - responseTxt "+responseTxt);

			if (responseTxt.indexOf("Error")==0)
			{
				return responseTxt;
			}			
				
		}
		catch(Exception exp)
		{
			System.out.println("***Inside Invoke External Application - PHISTransactions - Exception at executing procedure... "+exp);
			exp.printStackTrace(System.err);
		}
		finally
		{			
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}
		
		if(isDebugYN) 
			System.out.println("***Inside Invoke External Application - PHISTransactions - responseTxt...."+responseTxt);

		return responseTxt;	
	}

	/*

	private String PayTMTransactions(Map<String, String> reqParams) throws Exception 
	{
		String responseTxt="";
		Connection dbConn = null;
		ResultSet rs=null;
		CallableStatement ostmt = null;
		String p_response="", errorCode = "", errorMsg = "";

		String paramString=reqParams.get("paramString");
		System.out.println("InvokeExternalApplication.java:::PayTMTransactions...paramString...."+paramString);
		try
		{   

			PayTMWithdrawTransaction PayTMTrans = new PayTMWithdrawTransaction();
				
			responseTxt = PayTMTrans.TransRequestMethod("PAYTMPROF1","PAYTM", paramString);
			System.out.println("(InvokeExternalApplication:PayTMTransactions) responseTxt "+responseTxt);

			if (responseTxt.indexOf("Error")==0)
			{
				return responseTxt;
			}				
			
		}
		catch(Exception exp)
		{
			System.out.println("(InvokeExternalApplication:PayTMTransactions) Exception at executing procedure");
			exp.printStackTrace(System.err);
		}
		finally
		{			
			XHUtil.closeDBResources(rs, ostmt, dbConn);
		}
		System.out.println("InvokeExternalApplication.java PayTMTransactions:::responseTxt...."+responseTxt);
		return responseTxt;	
	}

	*/

	public String FetchStdCntrlSegMethod(String segmentID, String elementId, String standardCode){

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		l_app_msg = "***Inside Invoke External Application - FetchStdCntrlSegMethod... ";
		if (isDebugYN) System.out.println(l_app_msg);	

		l_app_msg = "***Inside Invoke External Application - FetchStdCntrlSegMethod - Segment ID : "+ segmentID + " ::: Element ID : " + elementId + " ::: Standard Code : "+ standardCode;
		if (isDebugYN) System.out.println(l_app_msg);	
		
		l_app_msg = "***Inside Invoke External Application - FetchStdCntrlSegMethod - Retrieving "+ elementId + " Value...";
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
			
		}
		catch(Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}
		finally
		{			
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}		

		return l_field_value;
	}

	public String FieldValueFetchMethod(String message, String identifier, String standardCode, String fieldSep, String procID){

		String l_app_msg = "", l_field_value = "";

		l_app_msg = "***Inside Invoke External Application - FieldValueFetchMethod... ";
		if (isDebugYN) System.out.println(l_app_msg);	

		l_app_msg = "***Inside Invoke External Application - FieldValueFetchMethod - Message : "+ message + " ::: Identifier : " + identifier + " ::: Standard Code : "+ standardCode;
		if (isDebugYN) System.out.println(l_app_msg);	
		
		l_app_msg = "***Inside Invoke External Application - FieldValueFetchMethod - Deriving Field Value..."+identifier;
		if (isDebugYN) System.out.println(l_app_msg);	

		try
		{
			if(standardCode != null && !(standardCode.length()>0))
			{

			}
			else
			{
				if (message.indexOf(identifier) >= 0 )
				{
					if (message.indexOf(fieldSep) >= 0)
					{
						l_field_value = message.substring(message.indexOf(identifier)+identifier.length());
						if (l_field_value.indexOf(fieldSep) >= 0)
						{						
							l_field_value = l_field_value.substring(0, l_field_value.indexOf(fieldSep));
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}		

		l_app_msg = " ::: l_field_value ::: "+l_field_value;
		if (isDebugYN) System.out.println(l_app_msg);

		return l_field_value;
	}

	/* Added for KDAH-CRF-0504 PhonePe Integration */
	private void fetchSettlementType(Map<String, String> reqParams) {

		String strTrnType = "", strApplicationID = "", protocolLinkID = "", strWalletID = "", strWaitTime = "";
		String strTypeStatus = "";
		String l_app_msg = "";

		String l_segment_id = "", l_element_id = "", l_std_code = "";

		String strStdQuery = "", strSegQuery = "";

		try
		{			

			strApplicationID = reqParams.get("intExtAppID");

			l_app_msg = "***Inside Invoke External Application - FetchSettlementType - strApplicationID ::: "+strApplicationID;
			if(isDebugYN) System.out.println(l_app_msg);

			protocolLinkID = reqParams.get("PROTOCOL_LINK_ID");

			l_app_msg = "***Inside Invoke External Application - FetchSettlementType - protocolLinkID ::: "+protocolLinkID;
			if(isDebugYN) System.out.println(l_app_msg);

			strStdQuery = "Select standard_code||'$!^' from XH_PROTOCOL_LINK where PROTOCOL_LINK_ID = '"+protocolLinkID+"'";
			String[] stdQueryResult = XHUtil.singleParamExeQry(strStdQuery).split(Pattern.quote("$!^"), -1);		
			l_std_code = stdQueryResult[0];
			l_app_msg = "***Inside Invoke External Application - FetchSettlementType - l_std_code ::: "+l_std_code;
			if(isDebugYN) System.out.println(l_app_msg);

			strSegQuery = "Select segment_type||'$!^' from XH_SEGMENT where STANDARD_CODE = '"+l_std_code+"' and CONTROL_YN = 'Y'";			
			String[] segQueryResult = XHUtil.singleParamExeQry(strSegQuery).split(Pattern.quote("$!^"), -1);
			l_segment_id = segQueryResult[0];
			l_app_msg = "***Inside Invoke External Application - FetchSettlementType - l_segment_id ::: "+l_segment_id;
			if(isDebugYN) System.out.println(l_app_msg);			

			l_element_id = "TXN_TYPE";
			strTrnType = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_std_code);
			l_app_msg = "***Inside Invoke External Application - FetchSettlementType - strTrnType ::: "+strTrnType;
			if (isDebugYN) System.out.println(l_app_msg);

			l_element_id = "WALLET_ID";
			strWalletID = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_std_code);
			l_app_msg = "***Inside Invoke External Application - FetchSettlementType - strWalletID ::: "+strWalletID;
			if (isDebugYN) System.out.println(l_app_msg);

			if (strWalletID == null || strWalletID.length() == 0)
				strWalletID = "X";
			
			reqParams.put("TXN_TYPE_SEG", strTrnType);
			reqParams.put("WALLET_ID", strWalletID);
			
			strWaitTime = FetchResponseWaitTime(l_segment_id);
			
			l_app_msg = "***Inside Invoke External Application - FetchSettlementType - strWaitTime ::: "+strWaitTime;
			if (isDebugYN) System.out.println(l_app_msg);

			reqParams.put("WAIT_TIME", strWaitTime);

			l_element_id = "TXN_TYPE_STATUS";
			strTypeStatus = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_std_code);
			l_app_msg = " TXN_TYPE_STATUS ::: "+strTypeStatus;
			if (isDebugYN) System.out.println(l_app_msg);

			if (strTypeStatus == null || strTypeStatus.length() == 0)
				strTypeStatus = "X";

			reqParams.put("TXN_TYPE_STATUS", strTypeStatus);

			/*

			l_element_id = "CHECK_TRN_STATUS";
			chkTrnStatus = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_std_code);
			l_app_msg = " CHECK_TRN_STATUS ::: "+chkTrnStatus;
			if (isDebugYN) System.out.println(l_app_msg);

			if (chkTrnStatus == null || chkTrnStatus.length() == 0)
				chkTrnStatus = "N";

			reqParams.put("CHECK_TRN_STATUS", chkTrnStatus);

			l_element_id = "CHECK_NO_TIMES";
			strRetryCount = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_std_code);
			l_app_msg = " CHECK_NO_TIMES ::: "+strRetryCount;
			if (isDebugYN) System.out.println(l_app_msg);

			if (strRetryCount == null || strRetryCount.length() == 0)
				strRetryCount = "0";

			reqParams.put("CHECK_NO_TIMES", strRetryCount);

			l_element_id = "TXN_TYPE_STATUS";
			strTypeStatus = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_std_code);
			l_app_msg = " TXN_TYPE_STATUS ::: "+strTypeStatus;
			if (isDebugYN) System.out.println(l_app_msg);

			if (strTypeStatus == null || strTypeStatus.length() == 0)
				strTypeStatus = "X";

			reqParams.put("TXN_TYPE_STATUS", strTypeStatus);

			reqParams.put("CHECK_STATUS", "N");
			reqParams.put("ROC_NO", "X");
			reqParams.put("BATCH_ID", "X");

			*/

			l_app_msg = "***Inside Invoke External Application - FetchSettlementType - Completed... ";
			if (isDebugYN) System.out.println(l_app_msg);
		}
		catch (Exception e)
		{
			System.out.println("***Inside Invoke External Application - Exception in fetchSettlementType "+l_app_msg+" - "+e.getMessage());
			e.printStackTrace(System.err);
		}
		
	}

	public String FetchResponseWaitTime(String pluginType){

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		int l_wait_time_sec = 60;
		int l_wait_time = 60;

		l_app_msg = "***Inside Invoke External Application - FetchResponseWaitTime... ";
		if (isDebugYN) System.out.println(l_app_msg);	

		l_app_msg = "***Inside Invoke External Application - FetchResponseWaitTime - Plugin Type : "+ pluginType;
		if (isDebugYN) System.out.println(l_app_msg);	
		
		try
		{
			dbConn =  ConnectionManager.getConnection();
			query = "SELECT NVL(COMM_PROCESS_IDLE_TIME, 0) COMM_PROCESS_IDLE_TIME FROM XH_INTERACTIVE_CONNECT_PARAM " 
						+ " WHERE PLUGIN_TYPE = ? ";

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, pluginType);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_wait_time_sec = rs.getInt("COMM_PROCESS_IDLE_TIME");
			   
			   //l_wait_time = l_wait_time_sec * 1000;

			}
			
			l_app_msg = "***Inside Invoke External Application - FetchResponseWaitTime - l_wait_time : "+ l_wait_time;
			if (isDebugYN) System.out.println(l_app_msg);	

			l_field_value = String.valueOf(l_wait_time_sec);
			
		}
		catch(Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}
		finally
		{			
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}		

		return l_field_value;
	}

	public void CCResponse(Map<String, String> reqParams) throws Exception {
		
		try
		{
			
			reqParams.put("responseType", "toModule");
	
			if(isDebugYN)
				System.out.println("***Inside Invoke External Application - CCResponse - PARAMS " + reqParams);			

			CreditCardDAO creditCardDAO = new CreditCardDAO();
			
			String responseMsg = creditCardDAO.getSettleBillResponsePlutus(reqParams);

			if(isDebugYN)
				System.out.println("***Inside Invoke External Application - CCResponse - Response " + responseMsg);

			reqParams.put("response", responseMsg);
		}
		catch (Exception e)
		{
			System.out.println("***Inside Invoke External Application - CCResponse - Exception in CCResponse... "+e);
			e.printStackTrace();
		}
		
	}
	
	/*
	* Added by Apoorva on 23/01/2020 for NMC-JD-CRF-0038.1 
	* This method is used for OTP Transactions
	*/
	private String OTPTransactions(Map<String, String> reqParams) throws Exception 
	{
		String responseTxt="";
		Connection dbConn = null;
		ResultSet rs=null;
		CallableStatement ostmt = null;
		String p_response="", errorCode = "", errorMsg = "";

		String paramString=reqParams.get("paramString");
		if(isDebugYN) 
			System.out.println("***Inside Invoke External Application - OTPTransactions - paramString...."+paramString);
		try
		{   
				
			dbConn = ConnectionManager.getConnection();

			ostmt = dbConn.prepareCall("{ CALL XHOTP.VALIDATE_REQUEST(?,?,?,?) }" );
			ostmt.setString(1,paramString);
			ostmt.registerOutParameter(2,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);
			ostmt.execute();
			p_response = ostmt.getString(2);
			errorCode = ostmt.getString(3);
			errorMsg = ostmt.getString(4);
			if(isDebugYN) 
				System.out.println("***Inside Invoke External Application - OTPTransactions - p_response ::: "+p_response);

			if((errorMsg != null) && (errorMsg.trim().length()>0)) 
			{
				responseTxt=errorCode+"$!^"+errorMsg;	
			}
			else
			{
				if(errorCode=="S" || "S".equalsIgnoreCase(errorCode))
				{
					 responseTxt=errorCode+"$!^"+p_response;
				}
				else
				{
					 responseTxt=errorCode+"$!^"+p_response;
				}
			}
			
			if(isDebugYN) 		
				System.out.println("***Inside Invoke External Application - OTPTransactions - responseTxt "+responseTxt);
		}
		catch(Exception exp)
		{
			System.out.println("***Inside Invoke External Application - OTPTransactions - Exception at executing procedure "+exp);
			exp.printStackTrace(System.err);
		}
		finally
		{			
			XHUtil.closeDBResources(rs, ostmt, dbConn);
		}
		if(isDebugYN) 
			System.out.println("***Inside Invoke External Application - PayTMTransactions - responseTxt...."+responseTxt);

		return responseTxt;	
	}

	// Added for AAKH-CRF-0119 - MALAFFI
	private String EMWebServiceTrans(Map<String, String> reqParams) throws Exception 
	{
		String responseTxt="";
		Connection dbConn = null;
		ResultSet rs=null;
		CallableStatement ostmt = null;
		String protocol_link_id = "";
		String p_response="", errorCode = "", errorMsg = "";
		String l_app_msg = "";

		String paramString=reqParams.get("paramString");

		if(isDebugYN) 
			System.out.println("***Inside Invoke External Application - EMWebServiceTrans - paramString...."+paramString);
		try
		{   

			dbConn = ConnectionManager.getConnection();

			protocol_link_id = FieldValueFetchMethod(paramString,"<PROTOCOL_LINK_ID>",null,l_field_separator, "EMWebServiceTrans");
			l_app_msg = "***Inside Invoke External Application - Protocol Link ID : "+protocol_link_id;
			if (isDebugYN) System.out.println(l_app_msg);

			ostmt = dbConn.prepareCall("{ CALL XHEMWEBSERVICE.EM_WEB_REQUEST(?,?,?,?,?) }" );
			ostmt.setString(1,protocol_link_id);
			ostmt.setString(2,paramString);
			ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(5,java.sql.Types.VARCHAR);
			ostmt.execute();
			p_response = ostmt.getString(3);
			errorCode = ostmt.getString(4);
			errorMsg = ostmt.getString(5);
			if(isDebugYN) 
				System.out.println(" ::: p_response ::: "+p_response);

			if((errorMsg != null) && (errorMsg.trim().length()>0)) 
			{
				responseTxt=errorMsg;	
			}
			else
			{
				if(errorCode=="S" || "S".equalsIgnoreCase(errorCode))
				{
					 responseTxt=p_response;
				}
				else
				{
					 responseTxt=p_response;
				}
			}

			
		}
		catch(Exception exp)
		{
			System.out.println("***Inside Invoke External Application - EMWebServiceTrans - Exception at executing procedure..."+exp);
			exp.printStackTrace(System.err);
		}
		finally
		{			
			XHUtil.closeDBResources(rs, ostmt, dbConn);
		}
		if(isDebugYN) 
			System.out.println("***Inside Invoke External Application - EMWebServiceTrans - responseTxt...."+responseTxt);

		return responseTxt;	

	}

	/*
	* Added by Sethu on 30/12/2020 for NMC-JD-CRF-0072.1 
	* This method is used for Nuhdeek Transactions
	*/


	private String NuhdeekTransactions(HttpServletRequest request, Map<String, String> reqParams) throws Exception 
	{
		String responseTxt="";
		Connection dbConn = null;
		ResultSet rs=null;
		CallableStatement ostmt = null;
		String p_response  = "", errorCode = "", errorMsg = "";

		String requestType = "", patientId = "", couponNos = "", transactionId = "", loginuserid = "", workstationno = "";

		String paramString = "";

		Clob myClob = null;

		if(isDebugYN) 
			System.out.println("***Inside Invoke External Application - NuhdeekTransactions - paramString...."+paramString);
		try
		{  
			requestType = reqParams.get("request_type");
			patientId = reqParams.get("patient_id");
			couponNos = reqParams.get("coupon_no");
			transactionId = reqParams.get("transaction_id");
			loginuserid = reqParams.get("login_user_id");
			workstationno = reqParams.get("workstation_no");

			dbConn = ConnectionManager.getConnection();


			/*

			if ("COUPON".equals(requestType))
			{
				couponNos = "";
			}
			
			//paramString to be constructed here.
			//"<REQUEST_TYPE>COUPON$!^<PATIENT_ID>0966865$!^<MOBILE_NO>0545530032$!^<MEMBERSHIP_NO>13022804$!^<COUPON_NO>NMC100000011240000000000007538$!^<FACILITY_ID>02$!^<LOGGED_IN_USER_ID>IBAEHIS$!^<LOGGED_IN_WSNO>172.18.10.93$!^<SESSION>EMWEB$!^";

			qryStr = "SELECT NVL(ALT_ID3_NO,'') ALT_ID3_NO, NVL(ALT_ID4_NO,'') ALT_ID4_NO FROM MP_PATIENT WHERE PATIENT_ID = ? ";

			pstmt = dbConn.prepareStatement(qryStr);
			pstmt.setString(1, patientId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   mobileNo = rs.getString("ALT_ID3_NO");
			   nuhdeekId = rs.getString("ALT_ID4_NO");
			}			
			HttpSession session = request.getSession(false);
			facility_id = (String)session.getAttribute( "facility_id" ) ;
			prop = (java.util.Properties) session.getAttribute( "jdbc" ) ;
			client_ip_address = prop.getProperty( "client_ip_address" );
			login_user = prop.getProperty( "login_user" );

			paramString = "<REQUEST_TYPE>"+requestType+"$!^<PATIENT_ID>"+patientId+"$!^<MOBILE_NO>"+mobileNo+"$!^<MEMBERSHIP_NO>"+nuhdeekId+"$!^<COUPON_NO>"+couponNos+"$!^<FACILITY_ID>"+facility_id+"$!^<LOGGED_IN_USER_ID>"+login_user+"$!^<LOGGED_IN_WSNO>"+client_ip_address+"$!^<SESSION>EMWEB$!^";

			if(isDebugYN) 
				System.out.println("***Inside Invoke External Application - NuhdeekTransactions - paramString...."+paramString);

			*/		

			
			
			ostmt = dbConn.prepareCall("{ CALL XBNUHDEEK.NUHDEEK_REQUEST(?,?,?,?,?,?,?,?,?) }" );
			ostmt.setString(1,requestType);
			ostmt.setString(2,patientId);		
			ostmt.setString(3,couponNos);
			ostmt.setString(4,transactionId);	
			ostmt.setString(5,loginuserid);
			ostmt.setString(6,workstationno);	
			ostmt.registerOutParameter(7,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(8,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(9,java.sql.Types.VARCHAR);
			ostmt.execute();		

			p_response = ostmt.getString(7);
			
			errorCode = ostmt.getString(8);
			errorMsg = ostmt.getString(9);

			if(isDebugYN) 
				System.out.println("***Inside Invoke External Application - NuhdeekTransactions - Response ::: "+ responseTxt + " Error Code ::: "+ errorCode + " Error Message ::: "+ errorMsg);

			

			//p_response = clobToString(myClob);

			responseTxt = p_response;		
			
			
		}
		catch(Exception exp)
		{
			System.out.println("***Inside Invoke External Application - NuhdeekTransactions - Exception at executing procedure "+exp);
			exp.printStackTrace(System.err);
		}
		finally
		{			
			XHUtil.closeDBResources(rs, ostmt, dbConn);
		}

		return responseTxt;	
	}
	
	
	// added by Ravisankar for PMG2019-TECH-CRF-0015.1 - SNOMED
	private String EMWebServiceSnomedTrans(Map<String, String> reqParams) throws Exception 
	{
		String responseTxt="";
		Connection dbConn = null;
		ResultSet rs=null;
		CallableStatement ostmt = null;
		String protocol_link_id = "";
		String p_response="", errorCode = "", errorMsg = "";
		String l_app_msg = "", l_field_value = "";

		String paramString=reqParams.get("paramString");

		if(isDebugYN) 
			System.out.println("***Inside Invoke External Application - EMWebServiceSnomedTrans - paramString...."+paramString);
		try
		{   

			dbConn = ConnectionManager.getConnection();

			protocol_link_id = FieldValueFetchMethod(paramString,"<PROTOCOL_LINK_ID>",null,l_field_separator, "EMWebServiceSnomedTrans");
			l_app_msg = "***Inside Invoke External Application - Protocol Link ID : "+protocol_link_id;
			if (isDebugYN) System.out.println(l_app_msg);
			System.out.println("At line 1574");
			ostmt = dbConn.prepareCall("{ CALL XHEMWEBSERVICE.EM_WEB_REQUEST(?,?,?,?,?) }" );
			System.out.println("At line 1576 after call");
			ostmt.setString(1,protocol_link_id);
			ostmt.setString(2,paramString);
			ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(5,java.sql.Types.VARCHAR);
			ostmt.execute();
			p_response = ostmt.getString(3);
			errorCode = ostmt.getString(4);
			errorMsg = ostmt.getString(5);
			if(isDebugYN) 
				System.out.println(" ::: p_response ::: "+p_response);

			if((errorMsg != null) && (errorMsg.trim().length()>0)) 
			{
				responseTxt=errorMsg;	
			}
			else
			{
				if(errorCode=="S" || "S".equalsIgnoreCase(errorCode))
				{
					 responseTxt=p_response;
				}
				else
				{
					 responseTxt=p_response;
				}
			}

			
		}
		catch(Exception exp)
		{
			System.out.println("***Inside Invoke External Application - EMWebServiceSnomedTrans - Exception at executing procedure..."+exp);
			exp.printStackTrace(System.err);
		}
		finally
		{			
			XHUtil.closeDBResources(rs, ostmt, dbConn);
		}
		if(isDebugYN) 
			System.out.println("***Inside Invoke External Application - EMWebServiceSnomedTrans - responseTxt...."+responseTxt);

		return responseTxt;	

	}
		/*
	* Added on 21/06/2021 for MOHE-CRF-0026 
	* This method is used for XHPAYER - Authorization Status.
	*/
	//This method is used for XHPAYER

	private String PayerTransactions(HttpServletRequest request, Map<String, String> reqParams) throws Exception 
	{
		String responseTxt="";
		Connection dbConn = null;
		ResultSet rs=null;
		CallableStatement ostmt = null;
		String p_response="", errorCode = "", errorMsg = "";

		String requestType = "", facilityId = "", dispData = "", loginuserid = "", workstationno = "";

		String paramString = "";
		
		try
		{   

			requestType = reqParams.get("request_type");
			facilityId = reqParams.get("facility_id");
			dispData = reqParams.get("disp_data");
			loginuserid = reqParams.get("login_user_id");
			workstationno = reqParams.get("workstation_no");

			if(isDebugYN) 
				System.out.println("***Inside Invoke External Application - PayerTransactions - Data... "+requestType + " - " + facilityId + " - " + dispData + " - " + loginuserid + " - " + workstationno);

			dbConn = ConnectionManager.getConnection();

			ostmt = dbConn.prepareCall("{ CALL XHPAYER.CHECK_AUTHORIZATION_STATUS(?,?,?,?,?,?,?,?) }" );
			ostmt.setString(1,requestType);
			ostmt.setString(2,facilityId);		
			ostmt.setString(3,dispData);
			ostmt.setString(4,loginuserid);
			ostmt.setString(5,workstationno);	
			ostmt.registerOutParameter(6,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(7,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(8,java.sql.Types.VARCHAR);
			ostmt.execute();
			p_response = ostmt.getString(6);
			errorCode = ostmt.getString(7);
			errorMsg = ostmt.getString(8);

			responseTxt = p_response;		
			
			if(isDebugYN) 
				System.out.println("***Inside Invoke External Application - PayerTransactions - Response ::: "+ responseTxt + " Error Code ::: "+ errorCode + " Error Message ::: "+ errorMsg);
			
		}
		catch(Exception exp)
		{
			System.out.println("***Inside Invoke External Application - PayerTransactions - Exception at executing procedure "+exp);
			exp.printStackTrace(System.err);
		}
		finally
		{			
			XHUtil.closeDBResources(rs, ostmt, dbConn);
		}

		return responseTxt;	
	}

	private String clobToString(java.sql.Clob data)
	{
		final StringBuffer sb = new StringBuffer();

		try
		{
			final Reader         reader = data.getCharacterStream();
			final BufferedReader br     = new BufferedReader(reader);

			int b;
			while(-1 != (b = br.read()))
			{
				sb.append((char)b);
			}

			br.close();
		}	
		catch (SQLException e){
			System.out.println("SQL Exception Could not convert CLOB to string ::: "+e.toString());
			return e.toString();
		}
		catch (IOException e)
		{
			System.out.println("IO. Could not convert CLOB to string ::: "+e.toString());
			return e.toString();
		}

		return sb.toString();
	}
	
	private String AuditInfo(HttpServletRequest request, Map<String, String> reqParams) throws Exception {
		Map<String, String> auditInfo = ArrayAuditInfo.getMapAuditInfo(request.getSession(false));
		String locale = "en";
		try {
			HttpSession session = request.getSession(false);
			Properties p = (Properties) session.getValue("jdbc");
			locale = p.getProperty("LOCALE");
			reqParams.put("locale", locale);			
			fetchDMSFilterDtls(reqParams);			
			reqParams.putAll(auditInfo);
			updateInteractiveParams(reqParams, auditInfo);
			XHUtil.updateInteractiveDetails(reqParams);
			
			return "S";
		}		
		catch(Exception exp) {
			System.out.println("***Inside Invoke External Application - Exception in Process Request... "+exp);
			exp.printStackTrace(System.err);
			return "E";
		}

	}
	
	private String AuditInfo(HttpServletRequest request,
			Map<String, String> reqParams, String mode) throws Exception {
		Map<String, String> auditInfo = ArrayAuditInfo.getMapAuditInfo(request
				.getSession(false));
		String locale = "en";
		try {
			HttpSession session = request.getSession(false);
			Properties p = (Properties) session.getValue("jdbc");
			locale = p.getProperty("LOCALE");
			reqParams.put("locale", locale);
			fetchDMSFilterDtls(reqParams);
			reqParams.putAll(auditInfo);
			updateInteractiveParams(reqParams, auditInfo);
			if (isDebugYN)
				System.out.println("***Inside Invoke External Application - AuditInfo - reqParams... "+reqParams.toString());
			XHUtil.updateInteractiveDetails(mode, reqParams);

			return "S";
		} catch (Exception exp) {
			System.out
					.println("***Inside Invoke External Application - Exception in Process Request... "
							+ exp);
			exp.printStackTrace(System.err);
			return "E";
		}

	}
	
	private String getSpectraWebTransactionInfo(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> reqParams)
			throws ServletException, IOException {
		
		if (isDebugYN) 
			System.out.println("***Inside Invoke External Application - getSpectraWebTransactionInfo - Method Inside....");

		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String requestMessage = "";

		String amount = "";
		String patientId = "";

		String machinePort = "";
		String baudRate = "";
		String ecrCounter = "";		
		
		String ws_url = "";
		String strWaitTime = "";
		
		String printSettings = "";

		try {
			amount = request.getParameter("P_Total_Bill_Amount");
			patientId = request.getParameter("P_patient_id");
			
			if (isDebugYN) {
				System.out.println("***Inside Invoke External Application - getSpectraWebTransactionInfo - amount...." + amount);
				System.out.println("***Inside Invoke External Application - getSpectraWebTransactionInfo - patientId...." + patientId);
			}

			// segment_id='SWEB' and standard_code='SPECWEBCC1' are standard for Spectra Websocket Payment Gateway
			String qry = "select ELEMENT_ID,DEFAULT_VALUE from xh_standard_control_seg where segment_id='SWEB' and standard_code='SPECWEBCC1'";

			if (isDebugYN) 
				System.out.println("***Inside Invoke External Application - getSpectraWebTransactionInfo - Query...." + qry);
				
			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(qry);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				if ("MACPORT".equals(rs.getString("ELEMENT_ID"))) {
					machinePort = rs.getString("DEFAULT_VALUE");
				} else if ("BAUDRATE".equals(rs.getString("ELEMENT_ID"))) {
					baudRate = rs.getString("DEFAULT_VALUE");
				} else if ("ECRCTR".equals(rs.getString("ELEMENT_ID"))) {
					ecrCounter = rs.getString("DEFAULT_VALUE");
				} else if ("WEBSOCKET_URL".equals(rs.getString("ELEMENT_ID"))) {
					ws_url = rs.getString("DEFAULT_VALUE");
				} else if ("PRINT_SETTINGS".equals(rs.getString("ELEMENT_ID"))) {
					printSettings = rs.getString("DEFAULT_VALUE");
				}

			}

			if (isDebugYN) {
				System.out.println("***Inside Invoke External Application - getSpectraWebTransactionInfo - machinePort...." + machinePort);
				System.out.println("***Inside Invoke External Application - getSpectraWebTransactionInfo - baudRate...." + baudRate);
				System.out.println("***Inside Invoke External Application - getSpectraWebTransactionInfo - ecrCounter...." + ecrCounter);
				System.out.println("***Inside Invoke External Application - getSpectraWebTransactionInfo - ws_url...." + ws_url);
				System.out.println("***Inside Invoke External Application - getSpectraWebTransactionInfo - printSettings...." + printSettings);
			}

			// sample request message
			// requestMessage =
			// "Request_type=RequestPayment$!^Amount=100.00$!^Patient_id=SAFD65236$!^ECR_counter=1$!^Machine_port=COM3$!^BoudRate=38400$!^Ws_url=ws://localhost:5000/messages$!^Print_settings=1$!^WaitTime=10";

			requestMessage = "Request_type=RequestPayment"
					+ "&Amount=" + amount
					+ "&Patient_id=" + patientId
					+ "&ECR_counter=" + ecrCounter
					+ "&Machine_port=" + machinePort
					+ "&BoudRate=" + baudRate
					+ "&Ws_url=" + ws_url
					+ "&Print_settings=" + printSettings;
			

			strWaitTime = FetchResponseWaitTime("WS");

			requestMessage += "&WaitTime=" + strWaitTime;
			
			if (isDebugYN)
				System.out.println("***Inside Invoke External Application - getSpectraWebTransactionInfo - requestMessage...." + requestMessage);

			// Inserting Audit Interactive Details Start
			/*
			* Added by Gopinath on 28/07/2023
			*/
			reqParams.put("REQUEST_TEXT", requestMessage);
			reqParams.put("RESPONSE_TEXT", "");
			if (isDebugYN)
				System.out.println("***Inside Invoke External Application - Insert AuditInfo - reqParams...." + reqParams.toString());
			String auditResponse = "";
			auditResponse = AuditInfo(request, reqParams, "I");
			if (isDebugYN)
				System.out.println("***Inside Invoke External Application - Insert Audit Info... " + auditResponse);
			// Inserting Audit Interactive Details Stop
			
			return requestMessage;
			

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}
		return requestMessage;
	}
}