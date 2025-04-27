package eXH;

import java.io.IOException;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.Date;
import java.text.DateFormat;
import java.text.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.io.InputStream;

import java.io.DataOutputStream;


import webbeans.eCommon.ConnectionManager;
import eXH.InterfaceUtil;
import eXH.XHJSONUtil;

class PancardValidation
{

	//Class variables 
	public static final String l_segment_id = "PCG";
	public static final String l_standard_code = "PANCARDSTD";	

	public static final String l_field_separator= "$!^";

	public static String l_debug_YN = "N";

	public String l_errcd = "S";
    public String l_errmsg = "";
    public String l_ack_text = "";	

	public String TransRequestMethod(String profileId, String applicationId, String actionKey){
		String l_app_msg = "", l_app_key = "", l_field_value = "", l_element_id = "";
		String l_trans_value = "", l_action_key = "";

		int l_trans_id = 0;

		String l_request = "", l_patient_id = "", l_facility_id = "", l_session_id = "", l_user_id = "", l_request_msg = "", l_response_msg = "", l_response_str = "";

		String l_request_date = "", l_event_type = "", l_msg_id = "";

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "", l_debug_yn = "", updateStmt = "";

		int updateCount = 0;

		l_app_msg = " ::: Inside TransRequestMethod ::: ";
		System.out.println(l_app_msg);		
		
		try
		{
			

			dbConn =  ConnectionManager.getConnection();
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
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}		

		Map<String,String> reqParams = new HashMap<String,String>();
			
		l_app_msg = "Inside TransRequestMethod...";
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);
		
		l_app_msg = " ::: Fetching Facility ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_facility_id = FieldValueFetchMethod(actionKey,"<FACILITY_ID>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: l_facility_id : "+l_facility_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_facility_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_facility_id;
		}
        
		l_app_msg = " ::: Fetching Patient ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_patient_id = FieldValueFetchMethod(actionKey,"<PATIENT_ID>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: l_patient_id : "+l_patient_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_patient_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_patient_id;
		}

		l_app_msg = " ::: Fetching Session ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_session_id = FieldValueFetchMethod(actionKey,"<SESSION>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: l_session_id : "+l_session_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_session_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_session_id;
		}

		if(l_session_id != null && l_session_id.length()>0) 
		{
			if (l_session_id.equals("REGPAT"))
			{
				l_event_type = "PC1";
			}

			if (l_session_id.equals("CHGPAT"))
			{
				l_event_type = "PC2";
			}
		}
		else
		{
			l_event_type = "PC1";
		}

		l_app_msg = " ::: Fetching User ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_user_id = FieldValueFetchMethod(actionKey,"<LOGGED_IN_USER_ID>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: l_user_id : "+l_user_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_user_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_user_id;
		}

		l_app_msg = "Generating Transaction id...";
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);

		l_trans_value = GenerateTransIDMethod();
		l_app_msg = "::: l_trans_value : "+l_trans_value;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_trans_value.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_trans_value;
		}

		reqParams.put("MSG_ID", l_trans_value);

		l_app_msg = " ::: Calling Request Mesage Build Method... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_request_msg  = MessageBuildMethod("PANCARD", actionKey, l_trans_value);
		l_app_msg = " ::: l_request_msg : "+l_request_msg;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		if (l_request_msg.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_request_msg;
		}

		l_app_msg = "Getting Formatted l_request_date value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_request_date = getFormattedStringDate("dd-MMM-yyyy HH:mm:ss", new java.util.Date());

		l_app_msg = "::: l_request_date : "+l_request_date;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Setting  reqParams value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_msg_id = l_trans_value;

		l_app_msg = "::: l_msg_id : "+l_msg_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);			

		try
		{		
			
			reqParams.put("LOGIN_USER", l_user_id);
			reqParams.put("CLIENT_MACHINE", "DFLT_WSNO"); 
			reqParams.put("PGM_ID", "PANCARD");
			reqParams.put("MODULE_ID", "XF");
			reqParams.put("SESSION_ID", l_session_id);

			
			reqParams.put("REQUEST_DATE", l_request_date); 
			reqParams.put("REQUEST_TEXT", l_request_msg); 
			reqParams.put("APPLICATION_ID", applicationId);
			reqParams.put("FACILITY_ID", l_facility_id);
			reqParams.put("MESSAGE_DATE", l_request_date); 
			reqParams.put("EVENT_TYPE", l_event_type);
			reqParams.put("PATIENT_ID", l_patient_id);
			reqParams.put("EPISODE_TYPE", "");
			reqParams.put("ENCOUNTER_ID", "");
			reqParams.put("ACC_NO", actionKey);
			reqParams.put("EXT_ACC_NO", "");
			reqParams.put("REQUEST_SYNTAX", actionKey);
			reqParams.put("ACK_MSG_ID", "");
			reqParams.put("PROTOCOL_LINK_ID", "PANCARDPL");
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
			l_response_msg = TransCommunicationMethod("PANCARDPL", actionKey, l_request_msg);
			l_app_msg = " ::: l_response_msg : "+l_response_msg;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_response_msg.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_response_msg;
			}

		}
		
		if (l_errcd.equals("S"))
		{
			l_response_str  = MessageLoadMethod(actionKey, l_response_msg, l_trans_value);
			l_app_msg = " ::: l_response_str : "+l_response_str;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_response_str.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_response_str;
			}
		}

		//dbConn = null;
		pstmt = null;

		try
		{
			//dbConn =  ConnectionManager.getConnection();
			updateStmt = " UPDATE XH_INTERACTIVE_INTEGRATION "
							+" SET	response_text        = ?, "
							+" acknowledgment_text    = ?, "
							+" status            = ?, "
							+" error_text        = ? "
							+" WHERE MESSAGE_ID          = ? " 
								+" AND pgm_id = ? " ;


			l_app_msg = " ::: l_msg_id : "+l_trans_value+ " ::: applicationId : "+applicationId;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			pstmt = dbConn.prepareStatement(updateStmt);
			pstmt.setString(1, l_response_msg);
			pstmt.setString(2, l_response_str);
			pstmt.setString(3, l_errcd);
			pstmt.setString(4, l_errmsg);
			pstmt.setString(5, l_trans_value);
			pstmt.setString(6, applicationId);
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
		finally
		{			
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}	

		if (l_errcd.equals("S"))
		{
			return l_response_str;
		}
		else
		{
			return l_errmsg;
		}
		
	}

	public String MessageBuildMethod(String applicationId, String actionKey, String transValue)
	{
		
		String l_app_msg = "", l_app_key = "", l_field_value = "", l_element_id = "";

		String l_patient_id = "",  l_transaction_id = "",  l_request_datetime = "",  l_pancard_id = "";  

		String l_facility_id = "", l_log_user_id = "", l_log_wsno = "", l_log_session = "", l_inter_errcd = "", l_inter_errmsg = "", l_event_type = "", l_errcd_proc = "";

		String l_tenant_code = "", l_udc = "", l_pip = "", l_lot = "", l_lov = "";

		String createJsonString = "", jsonObject = "";	

		try
		{			
		
			l_app_msg = "Inside MessageBuildMethod...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	       

			l_app_msg = " ::: Fetching Facility ID... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_facility_id = FieldValueFetchMethod(actionKey,"<FACILITY_ID>",null,l_field_separator, "MessageBuildMethod");
			l_app_msg = " ::: l_facility_id : "+l_facility_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_facility_id.indexOf("Error")>=0)
			{
				return l_facility_id;
			}
			
			l_app_msg = " ::: Fetching Patient ID... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_patient_id = FieldValueFetchMethod(actionKey,"<PATIENT_ID>",null,l_field_separator, "MessageBuildMethod");
			l_app_msg = " ::: l_patient_id : "+l_patient_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_patient_id.indexOf("Error")>=0)
			{
				return l_patient_id;
			}

			l_app_msg = " ::: Fetching PANCARDNO... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_pancard_id = FieldValueFetchMethod(actionKey,"<PANCARDNO>",null,l_field_separator, "MessageBuildMethod");
			l_app_msg = " ::: l_pancard_id : "+l_pancard_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_pancard_id.indexOf("Error")>=0)
			{
				return l_pancard_id;
			}

			l_app_msg = " ::: Fetching LOGGED_IN_USER_ID... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_log_user_id = FieldValueFetchMethod(actionKey,"<LOGGED_IN_USER_ID>",null,l_field_separator, "MessageBuildMethod");
			l_app_msg = " ::: l_log_user_id : "+l_log_user_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_log_user_id.indexOf("Error")>=0)
			{
				return l_log_user_id;
			}

			l_app_msg = " ::: Fetching LOGGED_IN_WSNO... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_log_wsno = FieldValueFetchMethod(actionKey,"<LOGGED_IN_WSNO>",null,l_field_separator, "MessageBuildMethod");
			l_app_msg = " ::: l_log_wsno : "+l_log_wsno;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_log_wsno.indexOf("Error")>=0)
			{
				return l_log_wsno;
			}

			l_app_msg = " ::: Fetching SESSION... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_log_session = FieldValueFetchMethod(actionKey,"<SESSION>",null,l_field_separator, "MessageBuildMethod");
			l_app_msg = " ::: l_log_session : "+l_log_session;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_log_session.indexOf("Error")>=0)
			{
				return l_log_session;
			}			

			l_app_msg = "Retrieving TENANT_CODE...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "TENANT_CODE";

			l_tenant_code = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_tenant_code : "+l_tenant_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_tenant_code.indexOf("Error")>=0)
			{
				return l_tenant_code;
			}

			l_app_msg = "Retrieving UDC...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "UDC";

			l_udc = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_udc : "+l_udc;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_udc.indexOf("Error")>=0)
			{
				return l_udc;
			}

			l_app_msg = "Retrieving PIP...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "PIP";

			l_pip = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_pip : "+l_pip;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_pip.indexOf("Error")>=0)
			{
				return l_pip;
			}
			
			l_app_msg = "Retrieving LOT...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "LOT";

			l_lot = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_lot : "+l_lot;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_lot.indexOf("Error")>=0)
			{
				return l_lot;
			}

			l_app_msg = "Retrieving LOV...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "LOV";

			l_lov = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_lov : "+l_lov;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_lov.indexOf("Error")>=0)
			{
				return l_lov;
			}

			l_app_msg = " ::: Generating JSON Request Object... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			XHJSONUtil.ClearJsonObjString("clear");
		
			createJsonString = XHJSONUtil.createJsonRequestString("udc", l_udc);
			createJsonString = XHJSONUtil.createJsonRequestString("pip", l_pip);			
			createJsonString = XHJSONUtil.createJsonRequestString("lot", l_lot);
			createJsonString = XHJSONUtil.createJsonRequestString("lov", l_lov);
					
			XHJSONUtil.ClearJsonObjString("clear");
			
			createJsonString = XHJSONUtil.createJsonRequestObject("metadata", createJsonString);	
			createJsonString = XHJSONUtil.createJsonRequestString("tenantCode", l_tenant_code);
			createJsonString = XHJSONUtil.createJsonRequestString("userName", l_log_user_id);
			createJsonString = XHJSONUtil.createJsonRequestString("pan", l_pancard_id);
			createJsonString = XHJSONUtil.createJsonRequestString("dt", transValue);

			l_app_msg = " ::: Generated JSON Request Object : "+createJsonString;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		}
		catch (Exception e)
		{
			createJsonString = "Error in MessageBuildMethod - "+ l_app_msg + " : " +  e.getMessage();
			e.printStackTrace();
		}

		return createJsonString;

	}

	public String MessageLoadMethod(String actionKey, String message, String transValue)
	{

		String l_app_msg = "", l_app_key = "", l_field_value = "", l_element_id = "";
		String l_in_JSON = ""; 
		String l_status= "", l_status_code= "", l_status_msg= "", l_request="", l_status_message = "";
		String l_response_str = "";

        String l_pancard_id = "", l_first_name = "", l_middle_name= "",  l_last_name = "", l_message = "", l_holder_name = "";
		String l_error_message = "", l_rdt = "", l_rrn = "";

        String l_status_return ="";

		try
		{
			l_app_msg = "Inside MessageLoadMethod...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_in_JSON = XHJSONUtil.createJsonObject(message);
			l_app_msg = " ::: l_in_JSON : "+l_in_JSON;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (l_in_JSON.indexOf("Error")==0)
			{
				return l_in_JSON;
			}

			l_status_code = XHJSONUtil.getJsonRequestString(l_in_JSON, "status");
			
			l_app_msg = " ::: l_status_code : "+l_status_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_status_msg = XHJSONUtil.getJsonRequestString(l_in_JSON, "errorMessage");

			if (l_status_code.equals("00"))
			{
				l_pancard_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "pan");
				l_app_msg = " ::: l_pancard_id : "+l_pancard_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_first_name = XHJSONUtil.getJsonRequestString(l_in_JSON, "firstName");
				l_app_msg = " ::: l_first_name : "+l_first_name;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_last_name = XHJSONUtil.getJsonRequestString(l_in_JSON, "lastName");
				l_app_msg = " ::: l_last_name : "+l_last_name;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_middle_name = XHJSONUtil.getJsonRequestString(l_in_JSON, "middleName");
				l_app_msg = " ::: l_middle_name : "+l_middle_name;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_message = XHJSONUtil.getJsonRequestString(l_in_JSON, "message");
				l_app_msg = " ::: l_message : "+l_message;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			}			

			l_error_message = XHJSONUtil.getJsonRequestString(l_in_JSON, "errorMessage");

			l_app_msg = " ::: l_error_message : " +l_error_message;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_rdt = XHJSONUtil.getJsonRequestString(l_in_JSON, "rdt");

			l_app_msg = " ::: l_rdt : " +l_rdt;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			if (l_status_code.equals("00") || l_status_code.equals("P001"))
			{
				l_rrn = XHJSONUtil.getJsonRequestString(l_in_JSON, "rrn");

				l_app_msg = " ::: l_rrn : " +l_rrn;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			}

			if(!(l_first_name != null) && !(l_first_name.length()>0)) 
				l_first_name = "";

			if(l_middle_name != null && l_middle_name.length()>0 && !(l_middle_name.equals("null"))) 
				l_middle_name = " " + l_middle_name;
			else
				l_middle_name = "";				

			if(l_last_name != null && l_last_name.length()>0 && !(l_last_name.equals("null"))) 
				l_last_name = " " + l_last_name;
			else
				l_last_name = "";

			l_holder_name = l_first_name + l_middle_name + l_last_name;

			if (l_status_code.equals("00"))
			{						
				l_status_code = "S";
				l_status_message = "Active";
			}		
			else if (l_status_code.equals("P001"))
			{			
				l_status_code = "E";
				l_status_message = "In-Active";	
				l_message = l_error_message;
			}
			else
			{			
				l_status_code = "E";
				l_status_message = "Others";	
				l_message = l_status_code + " - " + l_error_message;
			}
			

			l_app_msg = " ::: Before l_status_return... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_status_return = l_status_code + "$!^" + l_pancard_id + "$!^" + l_holder_name + "$!^" + l_status_message + "$!^" + l_message + "$!^" + l_rdt + "$!^" +l_rrn;

			l_app_msg = " ::: l_status_return : "+l_status_return;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		}
		catch (Exception e)
		{
			l_status_return = "E" + "$!^" + l_pancard_id + "$!^" + "" + "$!^" + "Others" + "$!^" + e.getMessage() + "$!^" + transValue + "$!^" +transValue;
		}
		
		return l_status_return;
	}

	public String TransCommunicationMethod(String protocolLinkID, String actionKey, String message)
	{
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_app_key = "", l_field_value = "", l_element_id = "";

		String l_profile_id = "", l_default_value = "";
		String l_http_user_agent = "", l_http_content_type = "", l_http_transfer_encoding = "", l_http_soapaction = "", l_url = "";
		int l_http_content_length_flag  = 0;

		String l_access_token="";

		HttpURLConnection conn = null;

		String l_response_msg = "", l_return_resp = "";

		l_app_msg = " ::: Inside TransCommunicationMethod ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Protocol Link ID : "+ protocolLinkID + " ::: Action Key : " + actionKey + " ::: Message : "+message;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = " ::: Fetching Communication Standards ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{
			dbConn =  ConnectionManager.getConnection();
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

			l_app_msg = "Retrieving ACCESS_TOKEN...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "ACCESS_TOKEN";

			l_access_token = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_access_token : "+l_access_token;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_access_token.indexOf("Error")>=0)
			{
				return l_access_token;
			}

			URL url = new URL(l_url);

			l_app_msg = " ::: URL Open Connection...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			conn = (HttpURLConnection) url.openConnection();

			l_app_msg = " ::: Connection Set Method...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			conn.setRequestMethod("POST");

			if (!(l_http_user_agent.equals("XXX")))
			{
				l_app_msg = " ::: Set Property User-Agent...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("User-Agent", l_http_user_agent);
			}

			if (!(l_http_content_type.equals("XXX")))
			{
				l_app_msg = " ::: Set Property Content-Type...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("content-type", l_http_content_type);
				conn.setRequestProperty("accept", l_http_content_type);
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

			conn.setRequestProperty("Access-Token", l_access_token);
			
			l_app_msg = " ::: conn.setUseCaches(false)...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			conn.setUseCaches(false);

			l_app_msg = " ::: conn.setDoOutput(true)...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			conn.setDoOutput(true);

			l_app_msg = " ::: Writing the request to the OutputStream...";
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
				if (l_debug_YN.equals("Y")) System.out.println(l_return_resp);
			}
			
			conn.disconnect();
			
		}
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
			l_response_msg = "Error in TransCommunicationMethod - "+ l_app_msg + " : " +  e.getMessage();
			return l_return_resp;

		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			l_response_msg = "Error in TransCommunicationMethod - "+ l_app_msg + " : " +  e.getMessage();
			return l_return_resp;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			l_response_msg = "Error in  TransCommunicationMethod - "+ l_app_msg + " : " +  e.getMessage();
			return l_return_resp;
		}
		finally
		{			
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}
		
		l_app_msg = " ::: l_return_resp : "+l_return_resp;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		return l_return_resp;
	}

	public String FieldValueFetchMethod(String message, String identifier, String standardCode, String fieldSep, String procID){

		String l_app_msg = "", l_app_key = "", l_field_value = "";

		l_app_msg = " ::: Inside FieldValueFetchMethod ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Message : "+ message + " ::: Identifier : " + identifier + " ::: Standard Code : "+ standardCode;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = " ::: Deriving Field Value..."+identifier;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

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
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		return l_field_value;
	}

	public String FetchStdCntrlSegMethod(String segmentID, String elementId, String standardCode){

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
			dbConn =  ConnectionManager.getConnection();
			query = "SELECT NVL(DEFAULT_VALUE,'') DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG " 
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
			dbConn =  ConnectionManager.getConnection();
			query = "select XH_PANCARD_TRANSNO_SEQ.NEXTVAL TRANSID FROM DUAL " ;

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
		finally
		{			
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}		

		return l_field_value;
	}
	
	public static Map<String,String> getRequestParams()
	{
		Map<String,String> requestParams = new HashMap<String,String>();		
		return requestParams;
	}

	public static String getFormattedStringDate(String format,Date date)
    {	
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
		String dateFormatted = dateFormat.format(date);
		return dateFormatted;
    }

}
