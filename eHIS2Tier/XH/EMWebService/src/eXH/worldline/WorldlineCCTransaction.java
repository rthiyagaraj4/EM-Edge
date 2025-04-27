package eXH.worldline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import eXH.util.EMDataSource;
import eXH.util.XHJSONUtil;
import eXH.util.XHUtil;


// created for KDAH-CRF-0535
public class WorldlineCCTransaction implements WorldlineCCTransInterface{
	public static final String l_segment_id = "WLS";//WLS
	public static final String l_standard_code = "WLCRCC";//WLCRCC	

	public static final String l_field_separator= ",";

	public static String l_debug_YN = "N";

	public String l_errcd = "S";
    public String l_errmsg = "";
    public String l_ack_text = "";	

	@Override
	public String TransRequestMethod(String applicationId, String actionKey) {
		String l_app_msg = "";
		String l_trans_value = "";

		String l_request = "", l_patient_id = "", l_encounter_id = "", l_facility_id = "", l_session_id = "", l_user_id = "", l_request_msg = "", l_check_sum = "", l_response_msg = "", l_response_str = "",l_user_wsno = "";

		String l_request_date = "";

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "", l_debug_yn = "", updateStmt = "";

		int updateCount = 0;	
		
		try
		{
			dbConn =  EMDataSource.getConnection();
			query = "select NVL(DEBUG_YN, 'N') DEBUG_YN FROM XH_PARAM " ;

			pstmt = dbConn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_debug_yn = rs.getString("DEBUG_YN");
			}

			l_debug_YN = l_debug_yn;

		}
		catch(Exception e)
		{
		}		
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		
		
		//actionKey = "{PATIENT_ID=DH0000001917, MODULE_ID=XH, WALLET_ID=X, EPISODE_TYPE=null, P_Trn_Status=N, APPLICATION_ID=WLCR, TXN_TYPE_STATUS=X, locale=en, P_Reciept_Date=20200107192602, SESSION_ID=e0098b88cd262ba6ec6d89e03a77fa2b90a7a9c98a2aae1667f44e055493f939, URL=http://182.18.180.27:8080/retail, EXT_ACC_NO=, IP_ADDRESS=127.0.0.1, ACC_NO=null, ENCOUNTER_ID=null, P_Total_Bill_Amount=300.00, P_MODULE_ID=OP, MODIFIED_BY_FACILITY=DH, userPassword=anand, P_FACILITY_ID=DH, P_Card_Roc_No=, P_LANGUAGE_ID=en, sessionID=e0098b88cd262ba6ec6d89e03a77fa2b90a7a9c98a2aae1667f44e055493f939, MODIFIED_BY_ID=ANAND, P_Card_Batch_ID=, PROTOCOL_LINK_ID=KHOWLC, EXTERNAL_FUNCTION=HTTP, P_Bill_Doc_Type=DHOPBL, loginUser=ANAND, ADDED_BY_DATE=07-Jan-2020 14:45:38, LOGIN_USER=ANAND, P_Preapaid_Card_Number=, p_doc_date=20200107192602, MESSAGE_DATE=07-Jan-2020 14:45:38, dbName=ALPHAMRI, facilityID=DH, P_settlement_type=WL, P_Trx_No=, ADDED_BY_ID=ANAND, PGM_ID=WLCRDH, P_USER_ID=ANAND, P_Request_Type=WITHDRAW_MONEY, clientIPAddress=DXCINDAI693704, P_RESP_ID=OP, EXTERNAL_APPLICATION=WLCR, P_Ext_Input_Key=, P_Bill_Doc_Num=10001538, P_PATIENT_NAME=Sameer  Sameer, PORT_NUMBER=, P_Card_Status_YN=Y, TXN_TYPE_SEG=, P_Card_Trn_No=, P_FUNCTION_ID=, EVENT_TYPE=DMS01, P_Ext_Application_ID=, REQUEST_DATE=07-Jan-2020 14:45:38, protocolType=SO, P_doc_amt=300.00, CLIENT_MACHINE=DXCINDAI693704, intExtAppID=WLCR, WAIT_TIME=60, ADDED_BY_FACILITY=DH, P_CCAppletEnabled=0, P_WS_NO=DXCINDAI693704, P_trn_type=, P_episode_ID=10002131, P_patient_id=DH0000001917, MODIFIED_BY_DATE=07-Jan-2020 14:45:38, P_Ext_Function=, P_Reciept_number=, FACILITY_ID=DH}";
		
		l_app_msg = " ::: Inside WorldLine Credit Card TransRequestMethod Action Key ::: "+actionKey;
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);		

		l_request = FieldValueFetchMethod(actionKey, "P_Request_Type=", null, l_field_separator, "TransRequestMethod");

		l_app_msg = " ::: Request Type : "+l_request;
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);

		if (l_request.indexOf("Error")>=0)
		{
			return l_request;
		}
		
		l_app_msg = "Generating Transaction id...";
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);

		l_trans_value = GenerateTransIDMethod();
		l_app_msg = "::: Sequence Number : "+l_trans_value;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_trans_value.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_trans_value;
		}
		
		l_app_msg = " ::: Fetching Patient ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_patient_id = FieldValueFetchMethod(actionKey,"PATIENT_ID=",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: Patient ID : "+l_patient_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_patient_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_patient_id;
		}
		
		l_app_msg = " ::: Fetching Facility ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_facility_id = FieldValueFetchMethod(actionKey,"FACILITY_ID=",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: Facility ID : "+l_facility_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_facility_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_facility_id;
		}
		
		l_app_msg = " ::: Fetching Session ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_session_id = FieldValueFetchMethod(actionKey,"SESSION_ID=",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: Session ID : "+l_session_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_session_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_session_id;
		}
		
		l_app_msg = " ::: Fetching User ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_user_id = FieldValueFetchMethod(actionKey,"LOGIN_USER=",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: User ID : "+l_user_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_user_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_user_id;
		}
		
		l_app_msg = " ::: Fetching User WSNO ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_user_wsno = FieldValueFetchMethod(actionKey,"IP_ADDRESS=",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: IP Address : "+l_user_wsno;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_user_wsno.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_user_wsno;
		}
		
		if (l_request.equals("WITHDRAW_MONEY"))
        {   
            l_request_msg  = MessageBuildMethod(l_trans_value, actionKey);
			l_app_msg = " ::: Withdraw Money Request Message : "+l_request_msg;
            if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		}  

		if (l_request_msg.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_request_msg;
		}
		
		l_app_msg = "Getting Formatted l_request_date value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_request_date = getFormattedStringDate("dd-MMM-yyyy HH:mm:ss", new java.util.Date());

		l_app_msg = "::: Request Date : "+l_request_date;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Setting  reqParams value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		try
		{		

			Map<String,String> reqParams = new HashMap<String,String>();
			reqParams.put("LOGIN_USER", l_user_id);
			reqParams.put("CLIENT_MACHINE", l_user_wsno); 
			//reqParams.put("PGM_ID", "PAYTM");
			reqParams.put("PGM_ID", "WORLDLINE");
			reqParams.put("MODULE_ID", "XB");
			reqParams.put("SESSION_ID", l_session_id);

			reqParams.put("MSG_ID", l_trans_value);
			reqParams.put("REQUEST_DATE", l_request_date); 
			reqParams.put("REQUEST_TEXT", l_request_msg); 
			reqParams.put("APPLICATION_ID", applicationId);
			reqParams.put("FACILITY_ID", l_facility_id);
			reqParams.put("MESSAGE_DATE", l_request_date); 
			reqParams.put("EVENT_TYPE", "WL01");//WL01, PT01
			reqParams.put("PATIENT_ID", l_patient_id);
			reqParams.put("EPISODE_TYPE", "");
			reqParams.put("ENCOUNTER_ID", l_encounter_id);
			reqParams.put("ACC_NO", actionKey);
			reqParams.put("EXT_ACC_NO", "");
			reqParams.put("REQUEST_SYNTAX", actionKey);
			reqParams.put("ACK_MSG_ID", "");
			reqParams.put("PROTOCOL_LINK_ID", "KHOWLC"); //KHOWLC, MCOPTM
			reqParams.put("ADDED_BY_ID", l_user_id); 
			reqParams.put("ADDED_BY_DATE", l_request_date); 
			reqParams.put("MODIFIED_BY_ID", l_user_id); 
			reqParams.put("MODIFIED_BY_DATE", l_request_date); 
			reqParams.put("ADDED_BY_FACILITY", l_facility_id);
			reqParams.put("MODIFIED_BY_FACILITY", l_facility_id);
			reqParams.put("RESPONSE_TEXT", ""); 
			reqParams.put("RESPONSE_SYNTAX", "");
			reqParams.put("PROFILE", ""); 
			reqParams.put("ERROR_TEXT", ""); 
			reqParams.put("ACK_TEXT", "");
			reqParams.put("ACK_SYNTAX", "");

			l_app_msg = "Inserting Interface Audit data...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			XHUtil.updateInteractiveDetails(reqParams);
		
		}
		catch (Exception e)
		{
			l_errcd = "E";
			l_errmsg = "Error in setting request params : "+l_app_msg+ " - "+ e.getMessage();;
		}
		
		l_app_msg = "Calling HTTPGateway Method...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		if (l_errcd.equals("S"))
		{
			l_response_msg = TransCommunicationMethod("KHOWLC", actionKey, l_check_sum, l_request_msg);
			l_app_msg = " ::: TransCommunicationMethod Response Message : "+l_response_msg;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_response_msg.indexOf("Error in ")>=0 || l_response_msg.indexOf("Connection ")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_response_msg;
			}

		}
		
		if (l_errcd.equals("S"))
		{
			l_response_str  = MessageLoadMethod(l_trans_value, l_response_msg);
			l_app_msg = " ::: MessageLoadMethod Response : "+l_response_str+" : l_errcd : "+l_errcd;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_response_str.indexOf("Error")>=0)
			{
				System.out.println(" ::: Inside 262 : ");
				l_errcd = "E";
				l_errmsg = l_response_str;
			}
		}
		
		try
		{
			dbConn =  EMDataSource.getConnection();
			updateStmt = " UPDATE XH_INTERACTIVE_INTEGRATION "
							+" SET	response_text        = ?, "
							+" acknowledgment_text    = ?, "
							+" status            = ?, "
							+" error_text        = ? "
							+" WHERE MESSAGE_ID          = ? " 
								+" AND pgm_id = ? " ;

			pstmt = dbConn.prepareStatement(updateStmt);
			System.out.println(" ::279 l_response_msg : "+l_response_msg+" : l_response_str : "+l_response_str+" :  l_errcd : "+l_errcd+ " :l_errmsg : "+l_errmsg);
			pstmt.setString(1, l_response_msg);
			pstmt.setString(2, l_response_str);
			pstmt.setString(3, l_errcd);
			pstmt.setString(4, l_errmsg);
			//pstmt.setString(5, "XB");
			pstmt.setString(5, l_trans_value);
			//pstmt.setString(6, "PAYTM");
			pstmt.setString(6, "WORLDLINE");
			updateCount = pstmt.executeUpdate();

			l_app_msg = " ::: UpdateCount : "+updateCount;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			
			if (updateCount == 1)
			{
				dbConn.commit();				
			}
			else
			{
				dbConn.rollback();	
				l_errcd = "E";
				l_errmsg = " Error in updating Interactive Integration Records ";				
			}

		}
		catch(Exception e)
		{
			l_errcd = "E";
			l_errmsg = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		
		System.out.println(" ::: l_response_str : "+l_response_str+" : l_errcd : "+l_errcd);
		
		if (l_errcd.equals("S"))
		{
			return l_response_str;
		}
		else
		{
			/*if(l_errmsg.contains("Connection")){
				l_errmsg = "Error "+l_errmsg.substring(0, l_errmsg.length()-9);
				System.out.println("l_errmsg before return : "+l_errmsg);
			}*/
			
			String l_ResponseCode = "1", l_Card_Num = "", l_Card_Type = "", l_urn = "", l_Terminal_Id = "", l_Merchant_Id = "", l_RRN_No = "", l_amount = "", l_txn_date = "", l_txn_time = "";
			/*l_errmsg = "\""+l_trans_value+"\","+"\""+l_ResponseCode+"\","+"\""+l_errmsg+"\","+"\""+l_Card_Num+"\","+"\"XXXX\","+"\"\","+"\""+l_Card_Type
					+"\","+"\""+l_urn+"\","+"\"\","+"\""+l_Terminal_Id+"\","+"\"\","+"\""+l_errmsg+"\","+"\"\","+"\""+l_Merchant_Id+"\","+"\""+l_RRN_No+"\","
					+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\""+l_amount+"\","+"\"\","+"\"\","+
					"\""+l_txn_date+"\","+"\""+l_txn_time+"\"";*/
			l_errmsg = "\""+l_trans_value+"\","+"\""+l_ResponseCode+"\","+"\""+l_errmsg+"\","+"\""+l_Card_Num+"\","+"\"XXXX\","+"\"\","+"\""+l_Card_Type
					+"\","+"\""+"\"\","+"\"\","+"\""+l_Terminal_Id+"\","+"\"\","+"\""+l_errmsg+"\","+"\"\","+"\""+l_Merchant_Id+"\","+"\""+l_RRN_No+"\","
					+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\""+l_amount+"\","+"\"\","+"\"\","+
					"\""+l_txn_date+"\","+"\""+l_txn_time+"\","+"\""+l_urn+"\"";
			return l_errmsg;
		}
	}

	@Override
	public String MessageBuildMethod(String trans_value, String actionKey) {
		String l_wlcr_mid = "";
		String l_app_msg = "", l_element_id = "";

		String l_patient_id="", l_request="", l_amount = "", l_tid = "", l_patient_name = "";
		String createJsonString = "";
		
		l_app_msg = "Inside MessageBuildMethod...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	       

		l_app_msg = " ::: Fetching Request Type... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_request = FieldValueFetchMethod(actionKey,"P_Request_Type=",null,l_field_separator, "MessageBuildMethod");
		l_app_msg = " ::: Request Type : "+l_request;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		if (l_request.indexOf("Error")>=0)
		{
			return l_request;
		}
		
		l_app_msg = " ::: Fetching Amount... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_amount = FieldValueFetchMethod(actionKey,"P_Total_Bill_Amount=",null,l_field_separator, "MessageBuildMethod");
		l_app_msg = " ::: Amount : "+l_amount;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_amount.indexOf("Error")>=0)
		{
			return l_amount;
		}
		
		l_app_msg = " ::: Fetching Patient ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_patient_id = FieldValueFetchMethod(actionKey,"PATIENT_ID=",null,l_field_separator, "MessageBuildMethod");
		l_app_msg = " ::: Patient ID : "+l_patient_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_patient_id.indexOf("Error")>=0)
		{
			return l_patient_id;
		}
		
		l_app_msg = " ::: Fetching Patient Name ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_patient_name = FieldValueFetchMethod(actionKey,"P_PATIENT_NAME=",null,l_field_separator, "MessageBuildMethod");
		l_app_msg = " ::: Patient Name : "+l_patient_name;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_patient_name.indexOf("Error")>=0)
		{
			return l_patient_name;
		}
		
		l_app_msg = "Retrieving Merchant Id...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

        l_element_id = "WLCR_MID";

        l_wlcr_mid = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
		l_app_msg = " ::: WLCR MID : "+l_wlcr_mid;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_wlcr_mid.indexOf("Error")>=0)
		{
			return l_wlcr_mid;
		}
		
		String l_clientIPAddress = FieldValueFetchMethod(actionKey,"IP_ADDRESS=",null,l_field_separator, "MessageBuildMethod");
		l_app_msg = " ::: Client IP Address : "+l_clientIPAddress;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_clientIPAddress.indexOf("Error")>=0)
		{
			return l_clientIPAddress;
		}
		
		String l_LOGIN_USER = FieldValueFetchMethod(actionKey,"LOGIN_USER=",null,l_field_separator, "MessageBuildMethod");
		l_app_msg = " ::: Login User : "+l_LOGIN_USER;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_LOGIN_USER.indexOf("Error")>=0)
		{
			return l_LOGIN_USER;
		}
		
		String l_facility_id = FieldValueFetchMethod(actionKey,"FACILITY_ID=",null,l_field_separator, "MessageBuildMethod");
		l_app_msg = " ::: Facility ID : "+l_facility_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_facility_id.indexOf("Error")>=0)
		{
			return l_facility_id;
		}
		
		String l_settlement_type_code = FieldValueFetchMethod(actionKey,"P_settlement_type=",null,l_field_separator, "MessageBuildMethod");
		l_app_msg = " ::: Settlement Type Code : "+l_settlement_type_code;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_settlement_type_code.indexOf("Error")>=0)
		{
			return l_settlement_type_code;
		}
		
		String l_cash_counter_code = FetchCashCounter(l_facility_id, l_LOGIN_USER, l_clientIPAddress);
		l_app_msg = " ::: Cash Counter Code : "+l_cash_counter_code;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_tid = FetchTID(l_facility_id, l_cash_counter_code, l_settlement_type_code);
		
		XHJSONUtil.ClearJsonObjString("clear");
		
		createJsonString = XHJSONUtil.createJsonRequestString("tid", l_tid);
		createJsonString = XHJSONUtil.createJsonRequestString("amount", l_amount);			
		createJsonString = XHJSONUtil.createJsonRequestString("organization_code", l_wlcr_mid);
		createJsonString = XHJSONUtil.createJsonRequestString("additional_attribute1", trans_value);
		createJsonString = XHJSONUtil.createJsonRequestString("additional_attribute2", l_patient_id);
		createJsonString = XHJSONUtil.createJsonRequestString("additional_attribute3", l_patient_name);
		
		l_app_msg = " ::: Generated JSON Request Object : "+createJsonString;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		return createJsonString;
	}

	@Override
	public String MessageLoadMethod(String sequence_No, String message) {
		
		String l_app_msg = "";
		String l_in_JSON = ""; 
		String l_status_return ="";

		String l_merchant_id = "", l_txn_date = "", f_txn_date = "";
		String l_ResponseCode = "", l_ResponseMessage = "", l_Card_Num = "", l_Card_Type = "", l_RRN_No = "", l_status = ""; 
		String l_Txn_Type = "", l_Terminal_Id = "", l_Merchant_Id = "",l_amount="";
		String l_txn_time = "", l_urn = "";

		l_app_msg = " ::: Inside MessageLoadMethod...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		/*message = "{\"tid\":\"0035565U\","
				  +"\"amount\":\"300.00\","
				  +"\"billing_number\":\"\","
				  +"\"response_code\":\"0\","
				  +"\"response_message\":\"Success\","
				  +"\"additional_attribute1\":\"\","
				  +"\"additional_attribute2\":\"\","
				  +"\"additional_attribute3\":\"\","
				  +"\"rrn\":\"\","
				  +"\"card_scheme\":\"\","
				  +"\"txn_date\":\"\","
				  +"\"txn_time\":\"\","
				  +"\"mid\":\"\","
				  +"\"masked_card_number\":\"\","
				  +"\"txn_type\":\"\","
				  +"\"status\":\"EXPIRED\","
				  +"\"urn\":\"1444\","
				  +"\"fetch_count\":\"0\"}";*/
		
		l_app_msg = " :::  message : "+message;
		if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		try
		{
			l_in_JSON = XHJSONUtil.createJsonObject(message);
			l_app_msg = " ::: Input Json : "+l_in_JSON;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (l_in_JSON.indexOf("Error")==0)
			{
				return l_in_JSON;
			}
			
			l_ResponseCode = XHJSONUtil.getJsonRequestString(l_in_JSON, "response_code");
			l_ResponseCode = l_ResponseCode.trim();
			l_app_msg = " ::: Response Code : "+l_ResponseCode;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_ResponseMessage = XHJSONUtil.getJsonRequestString(l_in_JSON, "response_message");
			l_ResponseMessage = l_ResponseMessage.trim();
			l_app_msg = " ::: Response Message : "+l_ResponseMessage;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_status = XHJSONUtil.getJsonRequestString(l_in_JSON, "status");
			l_status = l_status.trim();
			l_app_msg = " ::: Status : "+l_status;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_Card_Num = XHJSONUtil.getJsonRequestString(l_in_JSON, "masked_card_number");
			l_Card_Num = l_Card_Num.trim();
			l_app_msg = " ::: Card Number : "+l_Card_Num;
			if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_Card_Type = XHJSONUtil.getJsonRequestString(l_in_JSON, "card_scheme");
			l_Card_Type = l_Card_Type.trim();
			l_app_msg = " ::: Card Type : "+l_Card_Type;
			if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_RRN_No = XHJSONUtil.getJsonRequestString(l_in_JSON, "rrn");
			l_RRN_No = l_RRN_No.trim();
			l_app_msg = " ::: RRN No : "+ l_RRN_No;
			if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_merchant_id = XHJSONUtil.getJsonRequestString(message, "mid");
			l_merchant_id = l_merchant_id.trim();
			l_app_msg = " ::: Merchant Id : "+l_merchant_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_Txn_Type = XHJSONUtil.getJsonRequestString(message, "txn_type");
			l_Txn_Type = l_Txn_Type.trim();
			l_app_msg = " ::: Txn Type : "+ l_Txn_Type;
			if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_amount = XHJSONUtil.getJsonRequestString(message, "amount");
			l_amount = l_amount.trim();
			l_app_msg = " ::: Amount : "+l_amount;
			if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_Terminal_Id = XHJSONUtil.getJsonRequestString(message, "tid");
			l_Terminal_Id = l_Terminal_Id.trim();
			l_app_msg = " ::: Terminal ID : "+l_Terminal_Id;
			if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_txn_date = XHJSONUtil.getJsonRequestString(message, "txn_date");
			l_txn_date = l_txn_date.trim();
			l_app_msg = " ::: Txn Date : "+l_txn_date;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			
			SimpleDateFormat inSDF = new SimpleDateFormat("yyyy-mm-dd");
			SimpleDateFormat outSDF = new SimpleDateFormat("mm/dd/yyyy");
			
			if(l_txn_date.length()>0){
				Date date = inSDF.parse(l_txn_date);
		        f_txn_date = outSDF.format(date);
		        
		        f_txn_date = f_txn_date.replaceAll("/", "");
		        l_app_msg = " ::: Final Txn Date : "+f_txn_date;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			}
			
			
			l_txn_time = XHJSONUtil.getJsonRequestString(message, "txn_time");
			l_txn_time = l_txn_time.trim();
			l_app_msg = " ::: Txn Time : "+l_txn_time;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_txn_time = l_txn_time.replaceAll(":", "");
			
			l_app_msg = " ::: final Txn Time : "+l_txn_time;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			
			l_urn = XHJSONUtil.getJsonRequestString(message, "urn");
			l_urn = l_urn.trim();
			l_app_msg = " ::: URN : "+l_urn;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_app_msg = " ::: Before l_status_return... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			/*l_status_return = "\""+sequence_No+"\","+"\""+l_ResponseCode+"\","+"\""+l_ResponseMessage+"\","+"\""+l_Card_Num+"\","+"\"XXXX\","+"\"\","+"\""+l_Card_Type
					+"\","+"\""+l_urn+"\","+"\"\","+"\""+l_Terminal_Id+"\","+"\"\","+"\""+l_ResponseMessage+"\","+"\"\","+"\""+l_Merchant_Id+"\","+"\""+l_RRN_No+"\","
					+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\""+l_amount+"\","+"\"\","+"\"\","+
					"\""+f_txn_date+"\","+"\""+l_txn_time+"\"";*/
			
			l_status_return = "\""+sequence_No+"\","+"\""+l_ResponseCode+"\","+"\""+l_status+"\","+"\""+l_Card_Num+"\","+"\"XXXX\","+"\"\","+"\""+l_Card_Type
					+"\","+"\""+"\"\","+"\"\","+"\""+l_Terminal_Id+"\","+"\"\","+"\""+l_ResponseMessage+"\","+"\"\","+"\""+l_Merchant_Id+"\","+"\""+l_RRN_No+"\","
					+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\""+l_amount+"\","+"\"\","+"\"\","+
					"\""+f_txn_date+"\","+"\""+l_txn_time+"\","+"\""+l_urn+"\"";
							
				
	        l_app_msg = " ::: MessageLoadMethod response : "+ l_status_return;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			
		}catch (Exception e) {
			e.printStackTrace();
			l_status_return = "Error in "+ l_app_msg + " : " +  e.getMessage();
			System.out.println(" ::: MessageLoadMethod Exception ::: " +l_status_return);			
			return l_status_return;
		}

			return l_status_return;
	}

	public String CheckStatus(String protocolLinkID,String actionKey, String urn){
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		
		String query = "";
		String l_app_msg = "", l_element_id = "", l_request = "";

		String l_profile_id = "", l_standard_code = "WLCRCC";
		String l_http_user_agent = "", l_http_content_type = "", l_http_transfer_encoding = "", l_http_soapaction = "", l_url = "";
		int l_http_content_length_flag  = 0;

		String  l_request_url = "";
		
		int l_http_timeout = 0;

		HttpURLConnection conn = null;

		String l_response_msg = "", l_return_resp = "";


		l_app_msg = " ::: Inside CheckStatus ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Protocol Link ID : "+ protocolLinkID + " ::: URN : "+urn;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		
		l_app_msg = " ::: Fetching Communication Standards CheckStatus ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{
			dbConn =  EMDataSource.getConnection();
			query = "SELECT    nvl(profile_id,'') profile_id, nvl(xml_style_sheet_url, '') xml_style_sheet_url, nvl(standard_code,'') standard_code, "
						+ " nvl(http_user_agent,'XXX') http_user_agent, nvl(http_content_type, 'XXX') http_content_type, nvl(http_transfer_encoding, 'XXX') http_transfer_encoding, "
						+ " nvl(http_soapaction,'XXX') http_soapaction, nvl(http_content_length_flag,0)  http_content_length_flag "
			            + " FROM    xh_protocol a, xh_protocol_link b "
						+ " WHERE    a.protocol_id = b.protocol_id AND b.protocol_link_id = ? ";

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, protocolLinkID);			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_profile_id = rs.getString("PROFILE_ID");
			   l_url = rs.getString("XML_STYLE_SHEET_URL");
			   l_standard_code = rs.getString("STANDARD_CODE");
			   l_http_user_agent = rs.getString("HTTP_USER_AGENT");
			   l_http_content_type = rs.getString("HTTP_CONTENT_TYPE");
			   l_http_transfer_encoding = rs.getString("HTTP_TRANSFER_ENCODING");
			   l_http_soapaction = rs.getString("HTTP_SOAPACTION");
			   l_http_content_length_flag = rs.getInt("HTTP_CONTENT_LENGTH_FLAG");
			}

			l_app_msg = " ::: Profile ID : "+ l_profile_id + " ::: API URL : " + l_url + " ::: Standard Code : "+ l_standard_code + " ::: HTTP User Agent : "+l_http_user_agent;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = " ::: HTTP Content Type : "+ l_http_content_type + " ::: HTTP Transfer Encoding : " + l_http_transfer_encoding + " ::: HTTP Soap Action : "+ l_http_soapaction + " ::: HTTP Content Length Flag : "+l_http_content_length_flag;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_app_msg = " ::: Fetching Time out... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			/*pstmt = null;
			rs = null;
			
			query = "SELECT COMM_PROCESS_IDLE_TIME FROM XH_INTERACTIVE_CONNECT_PARAM WHERE PLUGIN_TYPE = 'CTR' ";

			pstmt = dbConn.prepareStatement(query);					
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				l_http_timeout = rs.getInt("COMM_PROCESS_IDLE_TIME");			   
			}*/
			
			String l_WAIT_TIME = FieldValueFetchMethod(actionKey, "WAIT_TIME=", null, l_field_separator, "TransCommunicationMethod");
			l_app_msg = " ::: Wait Time : "+l_WAIT_TIME;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_WAIT_TIME.indexOf("Error")>=0)
			{
				return l_WAIT_TIME;
			}
			
			l_http_timeout = Integer.parseInt(l_WAIT_TIME);
			
			if (l_http_timeout == 0)
				l_http_timeout = 60;
			
			l_http_timeout = l_http_timeout * 1000;
			
			l_app_msg = " ::: HTTP Time Out : "+ l_http_timeout;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_app_msg = " ::: Fetching Request Type... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_request = FieldValueFetchMethod(actionKey, "P_Request_Type=", null, l_field_separator, "TransCommunicationMethod");
			l_app_msg = " ::: Request Type : "+l_request;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_request.indexOf("Error")>=0)
			{
				return l_request;
			}
			
			l_app_msg = "Retrieving Request URL...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "CHECK_STATUS_URL";

			l_request_url = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: CHECK STATUS URL : "+l_request_url;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_request_url.indexOf("Error")>=0)
			{
				return l_request_url;
			}			
			
			l_app_msg = " :::  Url : "+l_url;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_url = l_url.trim();
			
			String l_check_status_url = l_url + "/" + l_request_url;
			
			l_check_status_url = l_check_status_url.trim();
			
			l_check_status_url = l_check_status_url + urn;
			
			
			l_app_msg = " ::: Check Status final Url : "+l_check_status_url;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			URL url = new URL(l_check_status_url);		 

			l_app_msg = " ::: URL Open Connection...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			conn = (HttpURLConnection) url.openConnection();
			
			l_app_msg = " ::: Connection Set Method...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			conn.setRequestMethod("GET");
			
			l_app_msg = " ::: Connection Set Timeout...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			conn.setConnectTimeout(l_http_timeout);

			conn.setReadTimeout(l_http_timeout);
			
			l_app_msg = " ::: Writing the CHECK STATUS request to the OutputStream...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_app_msg = " ::: Reading the response from the OutputStream...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			InputStream is;
			try{
				is = conn.getInputStream();
			}catch(Exception e){
				is = conn.getErrorStream();
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((is)));

			l_app_msg = " ::: Output from Server .... \n";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			while ((l_response_msg = br.readLine()) != null) {
				l_return_resp = l_return_resp + l_response_msg;
				l_app_msg = " ::: Check Status Server Response : "+l_return_resp;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			}
			
			conn.disconnect();
			
			
			
		}catch (MalformedURLException e) 
		{
			e.printStackTrace();
			l_response_msg = e.getMessage();
			System.out.println(" ::: MalformedURLException while checkstatus::: " +l_response_msg);			
			return l_response_msg;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			l_response_msg = e.getMessage();
			System.out.println(" ::: IOException while checkstatus ::: " +l_response_msg);			
			return l_response_msg;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			l_response_msg = e.getMessage();
			System.out.println(" ::: Exception while checkstatus ::: " +l_response_msg);
			return l_response_msg;
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		l_app_msg = " ::: Check Status return_resp : "+l_return_resp;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		return l_return_resp;
		
	}
	
	public String WithDrawMoney(String protocolLinkID, String actionKey, String message){
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		
		String query = "";
		String l_app_msg = "", l_element_id = "";

		String l_profile_id = "", l_standard_code = "WLCRCC";
		String l_http_user_agent = "", l_http_content_type = "", l_http_transfer_encoding = "", l_http_soapaction = "", l_url = "";
		int l_http_content_length_flag  = 0;

		String l_merchant_guid="", l_request="", l_request_url = "";
		int l_http_timeout  = 0;

		String l_proxy_server="", l_proxy_port="";

		HttpURLConnection conn = null;

		String l_response_msg = "", l_return_resp = "";


		l_app_msg = " ::: Inside WithDrawMoney  ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Protocol Link ID : "+ protocolLinkID + " ::: Message : "+message;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = " ::: Fetching Communication Standards in WITHDRAW_MONEY ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		try
		{
			dbConn =  EMDataSource.getConnection();
			query = "SELECT    nvl(profile_id,'') profile_id, nvl(xml_style_sheet_url, '') xml_style_sheet_url, nvl(standard_code,'') standard_code, "
						+ " nvl(http_user_agent,'XXX') http_user_agent, nvl(http_content_type, 'XXX') http_content_type, nvl(http_transfer_encoding, 'XXX') http_transfer_encoding, "
						+ " nvl(http_soapaction,'XXX') http_soapaction, nvl(http_content_length_flag,0)  http_content_length_flag "
			            + " FROM    xh_protocol a, xh_protocol_link b "
						+ " WHERE    a.protocol_id = b.protocol_id AND b.protocol_link_id = ? ";

			pstmt = dbConn.prepareStatement(query);
			l_app_msg = " ::: query : "+query;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			System.out.println(" ::: protocolLinkID length : "+protocolLinkID.length()+" : protocolLinkID :"+protocolLinkID+":::");
			pstmt.setString(1, protocolLinkID);			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				l_app_msg = " ::: Inside r.next() ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
			   l_profile_id = rs.getString("PROFILE_ID");
			   l_url = rs.getString("XML_STYLE_SHEET_URL");
			   l_standard_code = rs.getString("STANDARD_CODE");
			   l_http_user_agent = rs.getString("HTTP_USER_AGENT");
			   l_http_content_type = rs.getString("HTTP_CONTENT_TYPE");
			   l_http_transfer_encoding = rs.getString("HTTP_TRANSFER_ENCODING");
			   l_http_soapaction = rs.getString("HTTP_SOAPACTION");
			   l_http_content_length_flag = rs.getInt("HTTP_CONTENT_LENGTH_FLAG");
			}

			l_app_msg = " ::: Profile ID : "+ l_profile_id + " ::: API URL : " + l_url + " ::: Standard Code : "+ l_standard_code + " ::: HTTP User Agent : "+l_http_user_agent;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = " ::: HTTP Content Type : "+ l_http_content_type + " ::: HTTP Transfer Encoding : " + l_http_transfer_encoding + " ::: HTTP Soap Action : "+ l_http_soapaction + " ::: HTTP Content Length Flag : "+l_http_content_length_flag;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			String l_WAIT_TIME = FieldValueFetchMethod(actionKey, "WAIT_TIME=", null, l_field_separator, "TransCommunicationMethod");
			l_app_msg = " ::: Wait Time : "+l_WAIT_TIME;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_WAIT_TIME.indexOf("Error")>=0)
			{
				return l_WAIT_TIME;
			}
			
			l_http_timeout = Integer.parseInt(l_WAIT_TIME);
			/*pstmt = null;
			rs = null;
			
			query = "SELECT COMM_PROCESS_IDLE_TIME FROM XH_INTERACTIVE_CONNECT_PARAM WHERE PLUGIN_TYPE = 'CTR' ";

			pstmt = dbConn.prepareStatement(query);					
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				l_http_timeout = rs.getInt("COMM_PROCESS_IDLE_TIME");			   
			}*/
			
			if (l_http_timeout == 0)
				l_http_timeout = 60;
			
			l_http_timeout = l_http_timeout * 1000;// To convert to milliseconds
			
			l_app_msg = " ::: HTTP Time Out : "+ l_http_timeout;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			
			l_app_msg = " ::: Fetching Request... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_request = FieldValueFetchMethod(actionKey, "P_Request_Type=", null, l_field_separator, "TransCommunicationMethod");
			l_app_msg = " ::: l_request : "+l_request;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_request.indexOf("Error")>=0)
			{
				return l_request;
			}
			
			l_app_msg = "Retrieving Request URL...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "WITHDRAW_MONEY_URL";

			l_request_url = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_request_url : "+l_request_url;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_request_url.indexOf("Error")>=0)
			{
				return l_request_url;
			}
			
			l_element_id = "PROXY_SERVER";

			l_proxy_server = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_proxy_server : "+l_proxy_server;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_proxy_server.indexOf("Error")>=0)
			{
				return l_proxy_server;
			}


			l_element_id = "PROXY_PORT";

			l_proxy_port = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_proxy_port : "+l_proxy_port;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_proxy_port.indexOf("Error")>=0)
			{
				return l_proxy_port;
			}

			l_url = l_url.trim();
			l_request_url = l_request_url.trim();
			
			String l_withdraw_url = l_url + "/" + l_request_url;

			l_withdraw_url = l_withdraw_url.trim();

			l_app_msg = " ::: l_withdraw_url : "+l_withdraw_url+":::";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			URL url = new URL(l_withdraw_url);
			
			if (l_proxy_server.length()>0 && !l_proxy_server.equals("X"))
			{
				l_app_msg = " ::: Setting http Proxy...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				System.setProperty("http.proxyHost", l_proxy_server);
				System.setProperty("https.proxyHost", l_proxy_server);
			}

			if (l_proxy_port.length()>0  && !l_proxy_server.equals("X"))
			{
				l_app_msg = " ::: Setting http port...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				System.setProperty("http.proxyPort", l_proxy_port);       
				System.setProperty("https.proxyPort", l_proxy_port);

			}			 

			l_app_msg = " ::: URL Open Connection...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			conn = (HttpURLConnection) url.openConnection();
			
			l_app_msg = " ::: Connection Set Method...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			conn.setRequestMethod("POST");
			
			l_app_msg = " ::: Connection Set Timeout...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			conn.setConnectTimeout(l_http_timeout);

			conn.setReadTimeout(l_http_timeout);
			
			if (!(l_http_content_type.equals("XXX")))
			{
				l_app_msg = " ::: Set Property Content-Type...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("Content-Type", l_http_content_type);
			}	
			
			if (l_merchant_guid.length() > 0)
			{
				l_app_msg = " ::: Set Property mid...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("mid", l_merchant_guid);
			}

			if (!(l_http_user_agent.equals("XXX")))
			{
				l_app_msg = " ::: Set Property User-Agent...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("User-Agent", l_http_user_agent);
			}

			if (l_http_content_length_flag>0)
			{
				l_app_msg = " ::: Set Property Content-Length...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("Content-Length", Integer.toString(message.length()));
			}

			if (!(l_http_transfer_encoding.equals("XXX")))
			{
				l_app_msg = " ::: Set Property Transfer-Encoding...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("Transfer-Encoding", l_http_transfer_encoding);
			}

			if (!(l_http_soapaction.equals("XXX")))
			{
				l_app_msg = " ::: Set Property SOAPAction...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("SOAPAction", l_http_soapaction);
			}
			
			l_app_msg = " ::: conn.setUseCaches(false)...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			conn.setUseCaches(false);

			l_app_msg = " ::: conn.setDoOutput(true)...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			conn.setDoOutput(true);

			l_app_msg = " ::: Writing the WITHDRAW MONEY request to the OutputStream...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			OutputStream os = conn.getOutputStream();
			os.write(message.getBytes());
			os.flush();

			l_app_msg = " ::: Reading the response from the OutputStream...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			
			InputStream is;
			try{
				is = conn.getInputStream();
			}catch(Exception e){
				is = conn.getErrorStream();
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((is)));

			l_app_msg = " ::: Output from Server .... \n";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			while ((l_response_msg = br.readLine()) != null) {
				l_return_resp = l_return_resp + l_response_msg;
				l_app_msg = " ::: WITHDRAW_MONEY response : "+l_return_resp;
				if (l_debug_YN.equals("Y")) System.out.println(l_return_resp);
			}
			
			conn.disconnect();
			
		}catch (MalformedURLException e) 
		{
			e.printStackTrace();
			l_response_msg = e.getMessage();
			System.out.println(" ::: MalformedURLException ::: " +l_response_msg);			
			return l_response_msg;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			l_response_msg = e.getMessage();
			System.out.println(" ::: IOException ::: " +l_response_msg);			
			return l_response_msg;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			l_response_msg = e.getMessage();
			System.out.println(" ::: Exception ::: " +l_response_msg);
			return l_response_msg;
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		l_app_msg = " ::: With Draw Money return_resp : "+l_return_resp;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		return l_return_resp;
		
	}

	@Override
	public String TransCommunicationMethod(String protocolLinkID, String actionKey, String checkSum, String message) {
		String l_standard_code = "WLCRCC";
		String l_response_msg = "", l_app_msg = "", l_withdraw_resp = "", l_checkStatus_resp = "";
		String l_request = "", l_auto_check_status = "", l_element_id = "", l_sleep_time = "";
		String l_in_JSON = "", l_withdraw_urn = "", l_checkstatus_urn = "";
		Date date = new Date();
		int check_status_wait_time, retry_count, i;
		String l_status = "";

		l_app_msg = " ::: Inside TransCommunicationMethod ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: TransCommunicationMethod Protocol Link ID : "+ protocolLinkID + " ::: Message : "+message;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{
			
			l_app_msg = " ::: Fetching Request... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_request = FieldValueFetchMethod(actionKey, "P_Request_Type=", null, l_field_separator, "TransCommunicationMethod");
			l_app_msg = " ::: Request Type : "+l_request;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_request.indexOf("Error")>=0)
			{
				return l_request;
			}
						
			if(l_request.equals("WITHDRAW_MONEY")){
				
				l_element_id = "AUTO_CHECK_STATUS";
				
				l_auto_check_status = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
				l_app_msg = " ::: AUTO_CHECK_STATUS : "+l_auto_check_status;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				if (l_auto_check_status.indexOf("Error")>=0)
				{
					return l_auto_check_status;
				}
				
				l_element_id = "SLEEP_TIME";
				
				l_sleep_time = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
				l_app_msg = " ::: SLEEP_TIME : "+l_sleep_time;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				if (l_sleep_time.indexOf("Error")>=0)
				{
					return l_sleep_time;
				}
				date = null;
				date = new Date();
				l_app_msg = " ::: Before call With Draw Money time : "+date.getHours()+" : "+date.getMinutes()+" : "+date.getSeconds();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_withdraw_resp = WithDrawMoney(protocolLinkID, actionKey, message);
				
				date = null;
				date = new Date();
				l_app_msg = " ::: After call With Draw Money time : "+date.getHours()+" : "+date.getMinutes()+" : "+date.getSeconds();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				if (l_withdraw_resp.indexOf("Error")==0 || l_withdraw_resp.indexOf("Connection")==0)
				{
					return l_withdraw_resp;
				}
				
				l_app_msg = " ::: With Draw Money Response in TransCommunicationMethod : "+l_withdraw_resp;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_in_JSON = XHJSONUtil.createJsonObject(l_withdraw_resp);
				l_app_msg = " ::: l_in_JSON : "+l_in_JSON;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (l_in_JSON.indexOf("Error")==0)
				{
					return l_in_JSON;
				}
				
				l_app_msg = "Retrieving AUTO_CHECK_STATUS...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);					
				
				l_withdraw_urn = XHJSONUtil.getJsonRequestString(l_in_JSON, "urn");
				l_withdraw_urn = l_withdraw_urn.trim();
				l_app_msg = " ::: With Draw URN : "+l_withdraw_urn;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_checkStatus_resp = l_withdraw_resp;
				
				/*String l_WAIT_TIME = FieldValueFetchMethod(actionKey, "WAIT_TIME=", null, l_field_separator, "TransCommunicationMethod");
				l_app_msg = " ::: Wait Time : "+l_WAIT_TIME;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				if (l_WAIT_TIME.indexOf("Error")>=0)
				{
					return l_WAIT_TIME;
				}*/
				//String l_WAIT_TIME = "40";
				date = null;
				date = new Date();
				l_app_msg = " ::: Before call CheckStatus in with draw money time : "+date.getHours()+" : "+date.getMinutes()+" : "+date.getSeconds();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				if(l_auto_check_status.equals("Y") && l_withdraw_urn.length() > 0){					
					
					/*if(check_status_wait_time == 0)
						check_status_wait_time = 60;
					
					check_status_wait_time = check_status_wait_time * 1000;
					l_app_msg = " ::: wait time before call check status at withdraw money : "+check_status_wait_time;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					Thread.sleep(check_status_wait_time);*/
					
				//	l_checkStatus_resp = CheckStatus(protocolLinkID, actionKey, l_withdraw_urn);				
					
					check_status_wait_time = Integer.parseInt(l_sleep_time);
					retry_count = check_status_wait_time/15;
					i = 1;
					
					while(i < retry_count)
					{		
						System.out.println(" *************** inside While loop *********** i= " +i);	
						
						l_checkStatus_resp = CheckStatus(protocolLinkID, actionKey, l_withdraw_urn);
						
						l_in_JSON = XHJSONUtil.createJsonObject(l_checkStatus_resp);
						l_app_msg = " ::: l_in_JSON : "+l_in_JSON;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

						if (l_in_JSON.indexOf("Error")==0)
						{
							return l_in_JSON;
						}
						
						l_app_msg = "Retrieving CHECK STATUS...";
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);					
						
						l_status = XHJSONUtil.getJsonRequestString(l_in_JSON, "status");
						l_status = l_status.trim();
						l_app_msg = " ::: Status : "+l_status;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						
						if(l_status.equals("INITIATE"))
						{	
							System.out.println(" ********* inside if as l_status =  " +l_status);	
							Thread.sleep(15*1000);
							i++;
							continue;
						}
						else 
						{	
							System.out.println(" ********** inside else as l_status =  " +l_status);
							break;
						}
					}
					
					date = null;
					date = new Date();
					l_app_msg = " ::: After call CheckStatus in with draw money time : "+date.getHours()+" : "+date.getMinutes()+" : "+date.getSeconds();
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_app_msg = " ::: With Draw Money Check Status Response in TransCommunicationMethod : "+l_checkStatus_resp;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				}
			}
			
			
			if(l_request.equals("CHECK_STATUS")){
				
				l_app_msg = " ::: Fetching Check status request urn... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_checkstatus_urn = FieldValueFetchMethod(actionKey, "P_Card_Urn_No=", null, l_field_separator, "TransCommunicationMethod");
				l_app_msg = " ::: Check status URN : "+l_checkstatus_urn;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				if (l_checkstatus_urn.indexOf("Error")>=0)
				{
					return l_checkstatus_urn;
				}
				
				date = null;
				date = new Date();
				l_app_msg = " ::: Before call CheckStatus in with draw money 2 time : "+date.getHours()+" : "+date.getMinutes()+" : "+date.getSeconds();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_checkStatus_resp = CheckStatus(protocolLinkID, actionKey, l_checkstatus_urn);
				
				date = null;
				date = new Date();
				l_app_msg = " ::: After call CheckStatus in with draw money 2 time : "+date.getHours()+" : "+date.getMinutes()+" : "+date.getSeconds();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_app_msg = " ::: Check Status Response in TransCommunicationMethod : "+l_checkStatus_resp;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			l_response_msg = "Error in "+ l_app_msg + " : " +  e.getMessage();
			System.out.println(" ::: Exception ::: " +l_response_msg);
			return l_response_msg;
		}
		
		l_app_msg = " ::: l_checkStatus_resp : "+l_checkStatus_resp;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		return l_checkStatus_resp;
	
	}
	
	public String FetchCashCounter(String facility_id, String login_user, String clintIpAddress){
		Connection dbConn = null;
		CallableStatement cstmt = null;
		String l_app_msg = "";
		String cash_counter_code = "";
		
		l_app_msg = " ::: Inside FetchCashCounter ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		try
		{
			String cashCounterQuery = "{ call bl_user_check_for_cash_counter (?,?,?,?,?,?,?)}";
			dbConn = EMDataSource.getConnection();
			cstmt = dbConn.prepareCall(cashCounterQuery);
			
			cstmt.setString(1, facility_id);
			cstmt.setString(2, "O");
			cstmt.setString(3, login_user);
			cstmt.setString(4, clintIpAddress);

			cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);	
			cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);	
			cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);	

			cstmt.execute();
			
			cash_counter_code = cstmt.getString(5);
			
			l_app_msg = " ::: Cash Counter : "+cash_counter_code;
		    if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
		}catch(Exception e)
		{
			e.printStackTrace();
			l_app_msg = " ::: Exception while calling bl_user_check_for_cash_counter - "+ e.getMessage();
		    if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		}
		finally {
			XHUtil.closeDBResources(null, cstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		return cash_counter_code;
	}
	
	public String FetchTID(String facility_id, String cashCounterCode, String SlmtType){
		Connection dbConn = null;
		CallableStatement cstmt = null;
		String l_app_msg = "";
		String l_tid = "";

		l_app_msg = " ::: Inside FetchTID ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		try
		{
			String cashCounterQuery = "{ call BLCOMMON.GET_CREDIT_CARD_INT_DTL (?,?,?,?,?,?,?,?)}";
			dbConn = EMDataSource.getConnection();
			cstmt = dbConn.prepareCall(cashCounterQuery);
			
			cstmt.setString(1, facility_id);
			cstmt.setString(2, cashCounterCode);
			cstmt.setString(3, SlmtType);
			
			cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);				
			cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				

			cstmt.execute();
			
			l_tid = cstmt.getString(5);
			
			l_app_msg = " ::: TID : "+l_tid;
		    if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
		}catch(Exception e)
		{
			e.printStackTrace();
			l_app_msg = " ::: Exception while calling bl_user_check_for_cash_counter - "+ e.getMessage();
		    if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		}
		finally {
			XHUtil.closeDBResources(null, cstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		return l_tid;
	}

	@Override
	public String FieldValueFetchMethod(String message, String identifier, String standardCode, String fieldSep, String procID) {
		String l_app_msg = "", l_field_value = "";	

		try
		{
			
			/*l_app_msg = " ::: Inside FieldValueFetchMethod ::: ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = " ::: Message : "+ message + " ::: Identifier : " + identifier + " ::: Standard Code : "+ standardCode;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_app_msg = " ::: Deriving Field Value..."+identifier;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);*/	
			
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
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		return l_field_value;
	}

	@Override
	public String FetchStdCntrlSegMethod(String segmentID, String elementId, String standardCode) {
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		l_app_msg = " ::: Inside FetchStdCntrlSegMethod ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Segment ID : "+ segmentID + " ::: Element ID : " + elementId + " ::: Standard Code : "+ standardCode;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = " ::: Retrieving "+ elementId + " Value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{
			dbConn =  EMDataSource.getConnection();
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
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		return l_field_value;
	}
	
	public String GenerateTransIDMethod(){

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		int l_trans_id = 0;

		l_app_msg = " ::: Inside GenerateTransIDMethod ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);			
		
		try
		{
			dbConn =  EMDataSource.getConnection();
			query = "select XH_INTERACTIVE_TRX_NO_SEQ.NEXTVAL TRANSID FROM DUAL " ;

			pstmt = dbConn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_trans_id = rs.getInt("TRANSID");
			}

			if (l_trans_id > 0 )
			{
				l_field_value = String.valueOf(l_trans_id);
			}
			
		}
		catch(Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}	

		return l_field_value;
	}
	
	public static String getFormattedStringDate(String format,Date date)
    {	
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
		String dateFormatted = dateFormat.format(date);
		return dateFormatted;
    }

}
