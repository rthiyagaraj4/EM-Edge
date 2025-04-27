package eXH.pancard;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Date;


import java.text.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.io.InputStream;

import eXH.util.*;


//Class for Pancard Transaction
//Added for KDAH-SCF-0552 by Kapil on 28/01/2019
public class PanCardTransaction  
{
	

	
	//Class variables 
	public static final String l_segment_id = "PCG";
	public static final String l_standard_code = "PANCARDSTD";	
	public static final String l_application_id = "PANCARD";
	//public static final String l_event_type = "PC1";
	

	public static final String l_field_separator= "$!^";

	public static String l_debug_YN = "N";

	public String l_errcd = "S";
    public String l_errmsg = "";
    public String l_ack_text = "";	
    public String l_event_type = "PC1";

	public String TransRequestMethod(String profileId, String applicationId, String actionKey){
		String l_app_msg = "";
		String l_trans_value = "";

		String l_patient_id = "", l_facility_id = "", l_session_id = "", l_user_id = "", l_request_msg = "", l_response_msg = "", l_response_str = "",l_user_wsno = "";

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
		
		//
		String  l_pancard_no ="", l_hidden_pancard;

		l_pancard_no = FieldValueFetchMethod(actionKey,"<PANCARDNO>",null,l_field_separator, "TransRequestMethod",applicationId," ");
		
		l_hidden_pancard = l_pancard_no.substring(0,2)+"******"+l_pancard_no.substring(l_pancard_no.length() - 2);
					
		
		l_app_msg = " ************ Pancard Validation request started for ************ "+l_hidden_pancard;
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);
		
		l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" Inside PanCard TransRequestMethod Action Key : "+actionKey;
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);	
		
		l_app_msg = applicationId + " Fetching PanCard No ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = applicationId+" Pancard No : "+l_hidden_pancard;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_pancard_no.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_pancard_no;
		}			

		

		l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" Fetching Patient ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_patient_id = FieldValueFetchMethod(actionKey,"<PATIENT_ID>",null,l_field_separator, "TransRequestMethod", applicationId, l_hidden_pancard);
		l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" l_patient_id : "+l_patient_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_patient_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_patient_id;
		}


		l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" Fetching Facility ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_facility_id = FieldValueFetchMethod(actionKey,"<FACILITY_ID>",null,l_field_separator, "TransRequestMethod", applicationId, l_hidden_pancard);
		l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" l_facility_id : "+l_facility_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_facility_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_facility_id;
		}

		l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" Fetching Session  ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_session_id = FieldValueFetchMethod(actionKey,"<SESSION>",null,l_field_separator, "TransRequestMethod", applicationId, l_hidden_pancard);
		l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" l_session_id : "+l_session_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_session_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_session_id;
		}
		
		if(l_session_id.equals("REGPAT")){
			l_event_type = "PC1";
			l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" l_event_type : "+l_event_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
		}

		l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" Fetching LOGGED IN USER ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_user_id = FieldValueFetchMethod(actionKey,"<LOGGED_IN_USER_ID>",null,l_field_separator, "TransRequestMethod", applicationId, l_hidden_pancard);
		l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" l_user_id : "+l_user_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_user_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_user_id;
		}
		
		l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" Fetching User LOGGED IN WSNO ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_user_wsno = FieldValueFetchMethod(actionKey,"<LOGGED_IN_WSNO>",null,l_field_separator, "TransRequestMethod", applicationId, l_hidden_pancard);
		l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" l_user_id : "+l_user_wsno;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_user_wsno.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_user_wsno;
		}
		
		l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" Error status before Generating Transaction ID..."+l_errcd;
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);

		if (l_errcd.equals("S"))
		{
			l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" Generating Transaction id...";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
	
			l_trans_value = GenerateTransIDMethod(applicationId, l_hidden_pancard);
			l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" l_trans_value : "+l_trans_value;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_trans_value.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_trans_value;
			}		
		}
		
		l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" Calling PanCard Request Mesage Build Method Error Status... "+l_errcd;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		if (l_errcd.equals("S"))
		{		
			l_request_msg = MessageBuildMethod("PANCARD", actionKey, l_trans_value, l_hidden_pancard);
			
			l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" l_request_msg : "+l_request_msg;
	        if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
	        
	        if (l_request_msg.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_request_msg;
			}
		}

		l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" Getting Formatted l_request_date value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_request_date = getFormattedStringDate("dd-MMM-yyyy HH:mm:ss", new java.util.Date());

		l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" l_request_date : "+l_request_date;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" Setting  reqParams value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{		

			Map<String,String> reqParams = new HashMap<String,String>();
			reqParams.put("LOGIN_USER", l_user_id);
			reqParams.put("CLIENT_MACHINE", l_user_wsno); 
			reqParams.put("PGM_ID", "PANCARD");
			reqParams.put("MODULE_ID", "XB");
			reqParams.put("SESSION_ID", l_session_id);

			reqParams.put("MSG_ID", l_trans_value);
			reqParams.put("REQUEST_DATE", l_request_date); 
			reqParams.put("REQUEST_TEXT", l_request_msg); 
			reqParams.put("APPLICATION_ID", applicationId);
			reqParams.put("FACILITY_ID", l_facility_id);
			reqParams.put("MESSAGE_DATE", l_request_date); 
			reqParams.put("EVENT_TYPE", l_event_type);
			reqParams.put("PATIENT_ID", l_patient_id);
			reqParams.put("EPISODE_TYPE", "");
			reqParams.put("ENCOUNTER_ID", ""); //l_encounter_id
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

			l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" Inserting Interface Audit data...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			XHUtil.updateInteractiveDetails(reqParams);
		
		}
		catch (Exception e)
		{
			l_errcd = "E";
			l_errmsg = "Error in setting request params : "+l_app_msg+ " - "+ e.getMessage();;
		}

		l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" Calling HTTPGateway Method...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		if (l_errcd.equals("S"))
		{
			l_response_msg = TransCommunicationMethod("PANCARDPL", actionKey, l_request_msg, applicationId, l_hidden_pancard);
			l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" l_response_msg : "+l_response_msg;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_response_msg.indexOf("Error in ")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_response_msg;
			}

		}
		
		if (l_errcd.equals("S"))
		{
			l_response_str  = MessageLoadMethod(actionKey, l_response_msg , l_trans_value, applicationId, l_hidden_pancard);
			l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" l_response_str : "+l_response_str;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_response_str.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_response_str;
			}
		}

		dbConn = null;
		pstmt = null;

		try
		{			
			dbConn =  EMDataSource.getConnection();
			updateStmt = " UPDATE XH_INTERACTIVE_INTEGRATION "
							+" SET	response_text        = ?, "
							+" acknowledgment_text    = ?, "
							+" status            = ?, "
							+" error_text        = ? "
							+" WHERE MESSAGE_ID          = ? " 
								+" AND pgm_id = ? " 
							+"AND EVENT_TYPE = ?";

			pstmt = dbConn.prepareStatement(updateStmt);
			pstmt.setString(1, l_response_msg);
			pstmt.setString(2, l_response_str);
			pstmt.setString(3, l_errcd);
			pstmt.setString(4, l_errmsg);
			pstmt.setString(5, l_trans_value);
			pstmt.setString(6, "PANCARD");
			pstmt.setString(7, l_event_type);
			updateCount = pstmt.executeUpdate();

			l_app_msg = applicationId +" : "+ l_hidden_pancard +" : "+" UpdateCount : "+updateCount;
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
		
		l_app_msg = " ************ Pancard Validation request ended for ************ "+l_hidden_pancard;

		if (l_errcd.equals("S"))
		{
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);

			return l_response_str;
		}
		else
		{
			//l_errmsg = "E" + "$!^" + "Error" + "$!^" + l_errmsg + "$!^" + l_trans_value + "$!^" + "" + "$!^" + "";
			l_errmsg = "E" + "$!^" + l_pancard_no + "$!^" + "" + "$!^" + "Others" + "$!^" + l_errmsg + "$!^" + l_trans_value+ "$!^"+ l_trans_value;
			
			l_app_msg = " ::: Exception/Error encountered during the transaction : "+l_errmsg;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_app_msg = " ************ Pancard Validation request ended for ************ "+l_hidden_pancard;			
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			
			return l_errmsg;
		}
		
	}

	public String MessageBuildMethod(String applicationId, String actionKey, String dtSequence, String pancard_no){

		String l_app_msg = "", l_element_id = "";

		String l_logged_in_user_id = "", l_pancard_no = "", l_facility_id = "";

		String createJsonString = "", l_action_key = "";	

		l_app_msg = applicationId + " : "+ pancard_no +" : "+ " Inside MessageBuildMethod...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = applicationId + " : "+ pancard_no +" : "+" Fetching LOGGED IN USER ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_logged_in_user_id = FieldValueFetchMethod(actionKey,"<LOGGED_IN_USER_ID>",null,l_field_separator, "TransRequestMethod", applicationId, pancard_no);
		l_app_msg = applicationId + " : "+ pancard_no +" : "+" l_user_id : "+l_logged_in_user_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_logged_in_user_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_logged_in_user_id;
		}
		
		l_app_msg = applicationId + " : "+ pancard_no +" : "+" Fetching PanCard No ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_pancard_no = FieldValueFetchMethod(actionKey,"<PANCARDNO>",null,l_field_separator, "TransRequestMethod", applicationId, pancard_no);
		l_app_msg = applicationId + " : "+ pancard_no +" : "+" Pancard No : "+l_pancard_no;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_pancard_no.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_pancard_no;
		}
		
		l_app_msg = applicationId + " : "+ pancard_no +" : "+" Fetching Facility ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_facility_id = FieldValueFetchMethod(actionKey,"<FACILITY_ID>",null,l_field_separator, "TransRequestMethod", applicationId, pancard_no);
		l_app_msg = applicationId + " : "+ pancard_no +" : "+" Facility ID : "+l_facility_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_facility_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_facility_id;
		}

		String l_tenant_code = "", l_access_token = "",l_udc ="",l_pip = "", l_lot = "", l_lov = "";
		
		l_app_msg = applicationId + " : "+ pancard_no +" : "+" Retrieving Tenant Code...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_element_id = "TENANT_CODE";
		
		l_tenant_code = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, applicationId, pancard_no);
		l_app_msg = applicationId + " : "+ pancard_no +" : "+" Tenant Code : "+l_tenant_code;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_tenant_code.indexOf("Error")>=0)
		{
			return l_tenant_code;
		}
		
		l_app_msg = applicationId + " : "+ pancard_no +" : "+" Retrieving Access Token...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_element_id = "ACCESS_TOKEN";
		
		l_access_token = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, applicationId, pancard_no);
		l_app_msg = applicationId + " : "+ pancard_no +" : "+" Access Token : "+l_access_token;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_access_token.indexOf("Error")>=0)
		{
			return l_access_token;
		}
		
		l_app_msg = applicationId + " : "+ pancard_no +" : "+" Retrieving UDC...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_element_id = "UDC";
		
		l_udc = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, applicationId, pancard_no);
		l_app_msg = applicationId + " : "+ pancard_no +" : "+" UDC : "+l_udc;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_udc.indexOf("Error")>=0)
		{
			return l_udc;
		}
		
		l_app_msg = applicationId + " : "+ pancard_no +" : "+" Retrieving PIP...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_element_id = "PIP";
		
		l_pip = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, applicationId, pancard_no);
		l_app_msg = applicationId + " : "+ pancard_no +" : "+" PIP : "+l_pip;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_pip.indexOf("Error")>=0)
		{
			return l_pip;
		}
		
		l_app_msg = applicationId + " : "+ pancard_no +" : "+" Retrieving LOT...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_element_id = "LOT";
		
		l_lot = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, applicationId, pancard_no);
		l_app_msg = applicationId + " : "+ pancard_no +" : "+" LOT : "+l_lot;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_lot.indexOf("Error")>=0)
		{
			return l_lot;
		}
		
		l_app_msg = applicationId + " : "+ pancard_no +" : "+" Retrieving LOV...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_element_id = "LOV";
		
		l_lov = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, applicationId, pancard_no);
		l_app_msg = applicationId + " : "+ pancard_no +" : "+" LOV : "+l_lov;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_lov.indexOf("Error")>=0)
		{
			return l_lov;
		}
		
		l_app_msg = applicationId + " : "+ pancard_no +" : "+" Generating JSON Request Object... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_action_key = "<userName>"+l_logged_in_user_id+"$!^"+"<pan>"+l_pancard_no+"$!^"+"<metaData>"+""+"$!^"+"<lov>"+l_lov+"$!^"+"<udc>"+l_udc+"$!^"+"<pip>"+l_pip+"$!^"+"<lot>"+l_lot+"$!^"+"<tenantCode>"+l_tenant_code+"$!^"+"<dt>"+dtSequence+"$!^";
		
		l_app_msg = applicationId + " : "+ pancard_no +" : "+" Message Action Key ... "+l_action_key;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		XHJSONUtil.ClearJsonObjString("clear");
		
		createJsonString = XHJSONBuild.buildJson(l_application_id, l_event_type, l_facility_id, l_action_key);		
		
		l_app_msg = applicationId + " : "+ pancard_no +" : "+" Generated JSON Request Object : "+createJsonString;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		return createJsonString;

	}

	public String MessageLoadMethod(String actionKey, String message, String dtSequence, String applicationId, String pancardNo){

		String l_app_msg = "";
		String l_in_JSON = ""; 
		String l_status= "", l_status_code= "";

		String l_pancard_no = "";
		
		String l_firstName = "", l_middleName = "", l_lastName = "", l_holder_name = "", l_rdt = "", l_rrn = "";

        String l_status_return ="", l_status_message = "", l_error_message = "", l_message = "";
        
        try {        

			l_app_msg = applicationId +" : "+ pancardNo +":"+" Inside MessageLoadMethod...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);			
			
			l_app_msg = applicationId +" : "+ pancardNo +":"+" Fetching Pancard No... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
	
			l_pancard_no = FieldValueFetchMethod(actionKey, "<PANCARDNO>", null, l_field_separator, "MessageLoadMethod", applicationId, pancardNo);
			l_app_msg = applicationId +" : "+ pancardNo +":"+" Pancard No : "+l_pancard_no;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_pancard_no.indexOf("Error")>=0)
			{
				return l_pancard_no;
			}
			
			l_in_JSON = XHJSONUtil.createJsonObject(message);
			l_app_msg = applicationId +" : "+ pancardNo +":"+" l_in_JSON : "+l_in_JSON;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
	
			if (l_in_JSON.indexOf("Error")==0)
			{
				return l_in_JSON;
			}
			
			if (l_in_JSON.length()>0)
				l_status = XHJSONUtil.getJsonRequestString(l_in_JSON, "status");
	
			l_app_msg = applicationId +" : "+ pancardNo +":"+" l_status code : " +l_status_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
	
			if (l_in_JSON.length()>0)
			{
				l_firstName = XHJSONUtil.getJsonRequestString(l_in_JSON, "firstName");
				l_lastName = XHJSONUtil.getJsonRequestString(l_in_JSON, "lastName");
				l_middleName = XHJSONUtil.getJsonRequestString(l_in_JSON, "middleName");
				l_message = XHJSONUtil.getJsonRequestString(l_in_JSON, "message");
				l_rdt = XHJSONUtil.getJsonRequestString(l_in_JSON, "rdt");
				l_rrn = XHJSONUtil.getJsonRequestString(l_in_JSON, "rrn");
				l_error_message = XHJSONUtil.getJsonRequestString(l_in_JSON, "errorMessage");
				
				if (l_status.equalsIgnoreCase("00")) 
				{			
					l_status_code = "S";
					l_status_message = "Active";
				}			
				else if (l_status.equalsIgnoreCase("P001")) 
				{			
					l_status_code = "E";
					l_status_message = "In-Active";
					l_message = l_error_message;
				}
				else
				{				
					l_status_code = "E";
					l_status_message = "Others";
					l_message = l_status + " - " + l_error_message;
				}			
				
				l_holder_name = l_firstName + " " + l_middleName + " " + l_lastName;                            
				
				l_status_return = l_status_code + "$!^" + l_pancard_no + "$!^" + l_holder_name + "$!^" + l_status_message + "$!^" + l_message + "$!^" + l_rdt + "$!^" + l_rrn ;
	
				l_app_msg = applicationId +" : "+ pancardNo +":"+" l_status_return : "+l_status_return;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			}	
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	l_app_msg = "Exception while parsing the jSON object : "+ l_app_msg + " : " +  e.getMessage();
			System.out.println(l_app_msg);
			l_status_return = "E" + "$!^" + l_pancard_no + "$!^" + "" + "$!^" +  "Others" + "$!^" + l_app_msg + "$!^" + dtSequence + "$!^" + dtSequence ;
        }

        l_app_msg = applicationId +" : "+ pancardNo +":"+" l_status_return from JSON : "+ l_status_return;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		return l_status_return;
	}

	public String TransCommunicationMethod(String protocolLinkID, String actionKey, String message, String applicationId, String pancardNo){
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String selquery = "";
		String l_app_msg = "", l_element_id = "";


		String l_profile_id = "", l_standard_code = "HTTPCC";
		String l_http_user_agent = "", l_http_content_type = "", l_http_transfer_encoding = "", l_http_soapaction = "", l_url = "";
		int l_http_content_length_flag  = 0;

		String l_proxy_server="", l_proxy_port="", l_access_token = "";

		HttpURLConnection conn = null;

		String l_response_msg = "", l_return_resp = "";

		l_app_msg = applicationId +" : "+ pancardNo +" : "+" Inside XHCommunication ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = applicationId +" : "+ pancardNo +" : "+" Protocol Link ID : "+ protocolLinkID + " ::: Action Key : " + actionKey + "  ::: Message : "+message;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = applicationId +" : "+ pancardNo +" : "+" Fetching Communication Standards ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{
			dbConn =  EMDataSource.getConnection();
			selquery = "SELECT    nvl(profile_id,'') profile_id, nvl(xml_style_sheet_url, '') xml_style_sheet_url, nvl(standard_code,'') standard_code, "
						+ " nvl(http_user_agent,'XXX') http_user_agent, nvl(http_content_type, 'XXX') http_content_type, nvl(http_transfer_encoding, 'XXX') http_transfer_encoding, "
						+ " nvl(http_soapaction,'XXX') http_soapaction, nvl(http_content_length_flag,0)  http_content_length_flag "
			            + " FROM    xh_protocol a, xh_protocol_link b "
						+ " WHERE    a.protocol_id = b.protocol_id AND b.protocol_link_id = ? ";

			pstmt = dbConn.prepareStatement(selquery);
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

			l_app_msg = applicationId +" : "+ pancardNo +" : "+" Profile ID : "+ l_profile_id + " ::: API URL : " + l_url + " ::: Standard Code : "+ l_standard_code + " ::: HTTP User Agent : "+l_http_user_agent;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = applicationId +" : "+ pancardNo +" : "+" HTTP Content Type : "+ l_http_content_type + " ::: HTTP Transfer Encoding : " + l_http_transfer_encoding + " ::: HTTP Soap Action : "+ l_http_soapaction + " ::: HTTP Content Length Flag : "+l_http_content_length_flag;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_element_id = "ACCESS_TOKEN";
			l_access_token = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, applicationId, pancardNo);
			l_app_msg = applicationId +" : "+ pancardNo +" : "+" Access Token : "+l_access_token;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_access_token.indexOf("Error")>=0)
			{
				return l_access_token;
			}

			l_element_id = "PROXY_SERVER";
			l_proxy_server = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, applicationId, pancardNo);
			l_app_msg = applicationId +" : "+ pancardNo +" : "+" Proxy Server :"+l_proxy_server;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_proxy_server.indexOf("Error")>=0)
			{
				return l_proxy_server;
			}

			l_element_id = "PROXY_PORT";
			l_proxy_port = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, applicationId, pancardNo);
			l_app_msg = applicationId +" : "+ pancardNo +" : "+" Proxy Port : "+l_proxy_port;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_proxy_port.indexOf("Error")>=0)
			{
				return l_proxy_port;
			}

			l_url = l_url.trim();			

			l_app_msg = applicationId +" : "+ pancardNo +" : "+" URL : "+l_url;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			URL url = new URL(l_url);			

			if (l_proxy_server.length()>0 && !l_proxy_server.equals("X"))
			{
				l_app_msg = applicationId +" : "+ pancardNo +" : "+" Setting http Proxy...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				System.setProperty("http.proxyHost", l_proxy_server);
				System.setProperty("https.proxyHost", l_proxy_server);
			}

			if (l_proxy_port.length()>0  && !l_proxy_server.equals("X"))
			{
				l_app_msg = applicationId +" : "+ pancardNo +" : "+" Setting http port...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				System.setProperty("http.proxyPort", l_proxy_port);       
				System.setProperty("https.proxyPort", l_proxy_port);

			}			 

			l_app_msg = applicationId +" : "+ pancardNo +" : "+" URL Open Connection...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			conn = (HttpURLConnection) url.openConnection();

			l_app_msg = applicationId +" : "+ pancardNo +" : "+" Connection Set Method...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			conn.setRequestMethod("POST");
			
			// Common Headers for Pancard Transactions
			
			if (l_access_token.length()>0  && !l_access_token.equals("X"))
			{
				l_app_msg = applicationId +" : "+ pancardNo +" : "+" Setting Access Token...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				conn.setRequestProperty("Access-Token", l_access_token);
			}	

			if (!(l_http_content_type.equals("XXX")))
			{
				l_app_msg = applicationId +" : "+ pancardNo +" : "+" Set Property Content-Type...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("Content-Type", l_http_content_type);
			}			

			if (!(l_http_user_agent.equals("XXX")))
			{
				l_app_msg = applicationId +" : "+ pancardNo +" : "+" Set Property User-Agent...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("User-Agent", l_http_user_agent);
			}

			if (l_http_content_length_flag>0)
			{
				l_app_msg = applicationId +" : "+ pancardNo +" : "+" Set Property Content-Length...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("Content-Length", Integer.toString(message.length()));
			}

			if (!(l_http_transfer_encoding.equals("XXX")))
			{
				l_app_msg = applicationId +" : "+ pancardNo +" : "+" Set Property Transfer-Encoding...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("Transfer-Encoding", l_http_transfer_encoding);
			}

			if (!(l_http_soapaction.equals("XXX")))
			{
				l_app_msg = applicationId +" : "+ pancardNo +" : "+" Set Property SOAPAction...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("SOAPAction", l_http_soapaction);
			}
			
			l_app_msg = applicationId +" : "+ pancardNo +" : "+" conn.setUseCaches(false)...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			conn.setUseCaches(false);
			
			//java certificate location
			//String certificatesTrustStorePath = "%JAVA_HOME%/jre/lib/security/cacerts";
			//System.setProperty("javax.net.ssl.trustStore", certificatesTrustStorePath);

			l_app_msg = applicationId +" : "+ pancardNo +" : "+" conn.setDoOutput(true)...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			conn.setDoOutput(true);

			l_app_msg = applicationId +" : "+ pancardNo +" : "+" Writing the request to the OutputStream...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			OutputStream os = conn.getOutputStream();
			os.write(message.getBytes());
			os.flush();

			l_app_msg = applicationId +" : "+ pancardNo +" : "+" Reading the response from the OutputStream...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			InputStream is;
			try{
				is = conn.getInputStream();
			}catch(Exception e){
				is = conn.getErrorStream();
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((is)));

			l_app_msg = applicationId +" : "+ pancardNo +" : "+" Output from Server .... \n";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			while ((l_response_msg = br.readLine()) != null) {
				l_return_resp = l_return_resp + l_response_msg;
				l_app_msg = applicationId +" : "+ pancardNo +" : "+" Output Received from Server..."+l_return_resp;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			}
			
			conn.disconnect();
			
		}
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
			l_response_msg = "Error in TransCommunicationMethod MalformedURLException : "+ l_app_msg + " : " +  e.getMessage();
			System.out.println(" ::: MalformedURLException ::: " +l_response_msg);			
			return l_response_msg;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			l_response_msg = "Error in TransCommunicationMethod IOException : "+ l_app_msg + " : " +  e.getMessage();
			System.out.println(" ::: IOException ::: " +l_response_msg);			
			return l_response_msg;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			l_response_msg = "Error in TransCommunicationMethod Exception : "+ l_app_msg + " : " +  e.getMessage();
			System.out.println(" ::: Exception ::: " +l_response_msg);
			return l_response_msg;
		}
		finally
		{			
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}	
		l_app_msg = applicationId +" : "+ pancardNo +" : "+" l_return_resp : "+l_return_resp;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		return l_return_resp;
	}

	public String FieldValueFetchMethod(String message, String identifier, String standardCode, String fieldSep, String procID,String application_id, String pancard_no){

		String l_app_msg = "", l_field_value = "";	

		try
		{
			
			l_app_msg = application_id +" : "+ pancard_no +" : "+" Inside FieldValueFetchMethod ::: ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = application_id +" : "+ pancard_no +" : "+" Message : "+ message + " ::: Identifier : " + identifier + " ::: Standard Code : "+ standardCode;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_app_msg = application_id +" : "+ pancard_no +" : "+" Deriving Field Value..."+identifier;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
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

		l_app_msg = application_id +" : "+ pancard_no +" : "+" l_field_value : "+l_field_value;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		return l_field_value;
	}

	public String FetchStdCntrlSegMethod(String segmentID, String elementId, String standardCode, String applicationId, String pancardNo){

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		l_app_msg = applicationId+" : "+ pancardNo +" : "+" Inside FetchStdCntrlSegMethod ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = applicationId+" : "+ pancardNo +" : "+" Segment ID : "+ segmentID + " ::: Element ID : " + elementId + " ::: Standard Code : "+ standardCode;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = applicationId+" : "+ pancardNo +" : "+" Retrieving "+ elementId + " Value...";
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
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		return l_field_value;
	}
	
	public String GenerateTransIDMethod(String applicationId, String pancardNo){

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		int l_trans_id = 0;

		l_app_msg = applicationId+" : "+ pancardNo +" : "+" Inside GenerateTransIDMethod ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);			
		
		try
		{

			dbConn =  EMDataSource.getConnection();
			//dbConn = EMDBConnectionPool.getConnection();
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
		finally {					
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
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
