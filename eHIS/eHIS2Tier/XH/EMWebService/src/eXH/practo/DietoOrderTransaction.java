package eXH.practo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.*;


import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import eXH.util.EMDataSource;
import eXH.util.XHJSONUtil;
import eXH.util.XHUtil;

public class DietoOrderTransaction {
	
	public static String l_debug_YN = "N";
	public String l_errcd = "S", l_field_separator = "$!^";
	public String l_errmsg = "";
	public String l_ack_text = "";
	public String l_update_response_str = "";	
	public static String l_conn_msg = "Error - Unable to connect to the Data base, Kindly contact the System Administrator";
	
	public String processDietoRequest(String actionKey){
		
		String l_app_msg = "", l_errmsg = "", l_responseJsonString = "";
		String l_message_id = "", l_facility_id = "";
		String l_patient_id = "", l_encounter_id = "", l_practitioner_id = "", l_order_id = "";
		String l_in_JSON = "", l_err_msg = "";
		HashMap<String, String> ordermap = new HashMap<String, String>();
		String l_request_ref_no = "", l_request_type = "", l_request_date_time = "";
		String order_line_number = "", serv_code = "", serv_date = "", qty = "", l_folio_remarks = "";
		StringBuffer l_error = new StringBuffer();
		String l_response_str = "", l_response_err_json = "";
		Map<String, String> params = new HashMap<String, String>();
		PractoInboundTransaction practoInboundTransaction = new PractoInboundTransaction();
		int l_order_data_length = 0;
		
		String l_status = "", l_status_desc = "";
		Map<String, Object> l_response_json = new HashMap<String, Object>();
		ObjectMapper objMapper = new ObjectMapper();
		String err_status = "", err_text = "";
		
		CallableStatement cs = null;
		Connection con		 = null;
		try{
		
		l_debug_YN = XHUtil.l_debug_YN;
		
		
		l_app_msg = " ::: Inside DiettoOrder processRequest ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = " ::: Generating Message ID ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_message_id = PractoInboundTransaction.GenerateMessageIDMethod("XH_IB_MESSAGE_ID_SEQ");	
		
		if (l_message_id.indexOf("Error") >= 0) {
			l_errmsg = "Message ID Generation - "+l_message_id;
			l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_errmsg + " \" "+ " } ";
			
			return "200#" + l_response_err_json + "#";
		}
		
		l_app_msg = " ::: Generated Message Id ::: "+l_message_id+" ::: Error Code : "+l_errcd+" ::: Error Message : "+l_errmsg;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		
		
		/*if (l_errcd.equals("S"))				
		{			
			l_app_msg = "::: Fetching External Application Details : ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_external_app_details = practoInboundTransaction.FetchExternalAppDetails("PRACTOINB");			
			
			if (l_external_app_details.isEmpty()) 
			{
				l_errcd = "E";
				l_errmsg = "Error in Fetching External Application Details No Data Available";					
				l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_errmsg + " \" "+ " } ";
				return   "200#"+l_response_err_json+"#";
			}
			
			l_application_id = (String) l_external_app_details.get(0);
			
			if (l_application_id.indexOf("Error") >= 0) {
				l_errcd = "E";
				l_errmsg = "Fetching External Application Details - "+l_application_id;
				l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_errmsg + " \" "+ " } ";

				return "200#" + l_response_err_json + "#";
			}
			
			l_app_msg = " ::: Message ID : "+l_message_id+" ::: External Application : " + l_external_app_details+" ::: Error Code : "+l_errcd+" ::: Error Message : "+l_errmsg;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		}
		
		if (l_errcd.equals("S"))
		{
			l_application_id = (String) l_external_app_details.get(0);
			l_protocol_link_id = (String) l_external_app_details.get(1);
			//l_facility_id = (String) l_external_app_details.get(2);			
		}*/			

		params.put("MESSAGE_ID", l_message_id);
		//params.put("APPLICATION_ID", l_application_id);
		//params.put("FACILITY_ID", l_facility_id);
		params.put("PROTOCOL_LINK_ID", "KHDIETOPL1");
		params.put("APPLICATION_ID", "DIETO");
		params.put("EVENT_TYPE", "DOR");
		l_app_msg = " ::: params : "+params;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		
		
		l_app_msg = "::: Parsing input message ::: ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_in_JSON = XHJSONUtil.createJsonObject(actionKey);
		
		if (l_in_JSON.indexOf("Error") >= 0) {
			l_errcd = "E";
			l_err_msg = l_in_JSON;

			l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_err_msg + " \"  "	+ " } ";				
			
			l_app_msg = "::: Loading the message when : "+l_err_msg;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_response_str = practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
			l_app_msg = l_app_msg+" : " + l_response_str;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			return "200#" + l_response_err_json + "#";

		}
		
		l_app_msg = " ::: Getting Request Ref Number from JSON :::";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_request_ref_no = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_ref_no");
		if (l_request_ref_no.indexOf("Error") >= 0 || l_request_ref_no.length() <= 1 || l_request_ref_no.equals("")) {
			l_errcd = "E";
			l_error.append(" - Request Reference Number");	
		}
		l_app_msg = " ::: Request Ref Number : " + l_request_ref_no;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = " ::: Getting Request Type from JSON :::";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_request_type = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_type");
		if (l_request_type.indexOf("Error") >= 0 || l_request_type.length() <= 1 || l_request_type.equals("")) {
			l_errcd = "E";
			l_error.append(" - Request Type");
		}
		l_app_msg = " ::: Request Type : " + l_request_type;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = " ::: Getting Request Date Time from JSON ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_request_date_time = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_date_time");	
		l_app_msg = " ::: Request Date Time : " + l_request_date_time;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		
		l_app_msg = " ::: Getting Patient ID from JSON ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_patient_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "patient_id");
		
		l_app_msg = " ::: Patient ID : " + l_patient_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = " ::: Getting Facility ID from JSON ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_facility_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "facility_id");
		params.put("FACILITY_ID", l_facility_id);
		
		l_app_msg = " ::: Facility ID : " + l_facility_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = " ::: Getting Encounter ID from JSON ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_encounter_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "encounter_id");
		l_app_msg = " ::: Encounter ID : " + l_encounter_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = " ::: Getting Request Practitioner ID from JSON :::";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_practitioner_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "practitioner_id");
		l_app_msg = " ::: Practitioner ID : " + l_practitioner_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = " ::: Getting Request Order ID from JSON :::";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_order_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "order_id");
		l_app_msg = " ::: Order ID : " + l_order_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		if(l_in_JSON.contains("order_data"))
		{
			l_app_msg = " ::: Reading in Order Data  ::: ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			try {
				
				String l_order_data_str = XHJSONUtil.getJsonRequestString(l_in_JSON, "order_data");
				if (l_order_data_str.indexOf("Error in") >= 0  || "".equals(l_order_data_str.trim())  )
				{
					l_errcd = "E";
					l_error.append("- Order Data cannot be empty ");
				}
				
				if (l_errcd.equals("E"))
				{			
					l_response_err_json = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);				
					return "200#"+ l_response_err_json +"#";			
				}
				
				
				JSONArray jArray = new JSONArray(l_order_data_str);
				l_order_data_length = jArray.length();
				for(int i = 0; i < l_order_data_length ; i++ ){
					
					JSONObject jObect = jArray.getJSONObject(i);
					order_line_number = jObect.getString("order_line_number");
					serv_code = jObect.getString("serv_code");
					serv_date = jObect.getString("serv_date");
					qty = jObect.getString("qty");
					 
					 ordermap.put("serv_code"+i, serv_code);
					 ordermap.put("order_line_number"+i, order_line_number);
					 ordermap.put("serv_date"+i, serv_date);
					 ordermap.put("qty"+i, qty);
				}
				
				l_app_msg = " ::: OrderMap : " + ordermap;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				for( int i = 0; i < l_order_data_length; i++){
				
					try{
							
							Long k_encounter_id = Long.parseLong(l_encounter_id);
							String DiettoServiceQuery = " {call BL_DIETTO_SERVICES(?,?,?,?,?,?,?,?,?,?,?,?)}";
							
							con = EMDataSource.getConnection();
							cs = con.prepareCall(DiettoServiceQuery);
							
							 cs.setString(1, l_facility_id);
							 cs.setString(2, l_patient_id);
							 cs.setLong(3, k_encounter_id);
							 cs.setString(4, ordermap.get("serv_code"+i).toString());
							 
							 /*							 
							 java.util.Date date1=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(ordermap.get("serv_date"+i).toString());
							 l_app_msg = " ::: Service Date Before formatting... "+ordermap.get("serv_date"+i).toString();
							 if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
							 
							 l_serv_date = getFormattedStringDate("dd-MMM-yyyy HH:mm:ss",date1);
							 
							 l_app_msg = " ::: Service Date after formatting... "+l_serv_date;
							 if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
							 cs.setDate(5, l_serv_date);
							 */
							 //cs.setDate(5, fromDt);
							 cs.setString(5, ordermap.get("serv_date"+i).toString());
							 cs.setInt(6, Integer.parseInt(ordermap.get("qty"+i).toString()));
							 cs.setString(7, l_practitioner_id);
							 cs.setString(8 , l_order_id);
							 cs.setInt(9 , Integer.parseInt(ordermap.get("order_line_number"+i).toString()));
							 cs.setString(10, l_folio_remarks);
							 cs.registerOutParameter(11,Types.VARCHAR);
							 cs.registerOutParameter(12,Types.VARCHAR);
							
							 cs.execute();
							 err_text = cs.getString(11);
							 err_status = cs.getString(12);
							 
							 ordermap.put("err_status"+i, err_status);
							 ordermap.put("err_text"+i, err_text);
							 
							 l_errcd = err_status;
							 
							 l_app_msg = " ::: BL_DIETTO_SERVICES : err_text : "+err_text+" ::: errcd : "+l_errcd;
							 if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
							
							 if(l_errcd.equals("E")){
								 break;
							 }
						} catch (Exception e) {
							l_errcd = "E";
							e.printStackTrace();
							l_app_msg = " ::: Exception while calling BL_DIETTO_SERVICES - "+ e.getMessage();
						    if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						} finally {
							EMDataSource.returnConnection(con);
							XHUtil.closeDBResources(null, cs, null);
					}
				
				}
			
			}catch (Exception e){
				e.printStackTrace();
				l_app_msg = " ::: Exception while reading order data - "+e.getMessage();
			    if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			}
			
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Order : "+ordermap);
			if(l_errcd.equals("S") ){
				l_status = "1";
				l_status_desc = "Dieto Order Successfully Created";
				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				
				l_responseJsonString = objMapper.writeValueAsString(l_response_json);
				
				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				l_response_str = practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, "");
				l_app_msg = " ::: Message Load Method  ::: "+ l_response_str;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				return "200#"+ l_responseJsonString +"#";
				
			}else {
				
				l_status = "0";
				l_status_desc = "Dieto Order Failed - "+err_text;
				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				
				
				l_responseJsonString = objMapper.writeValueAsString(l_response_json);
				
				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				l_response_str = practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, err_text);
				l_app_msg = " ::: Message Load Method  ::: "+ l_response_str;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				return "200#"+ l_responseJsonString +"#";
				
			}
		}
		}catch (Exception e) {
			e.printStackTrace();
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^ Exception Occurred " + e.getMessage();
			l_responseJsonString = l_errmsg;
			
			params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
			l_response_str = practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_errmsg);
			l_app_msg = " ::: Message Load Method  ::: "+ l_response_str;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);			
	
		}
		
		l_app_msg = " ************ Dieto Order Transaction Ended ************ ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);		
		
		return "200#"+ l_responseJsonString +"#";
	}
	
public String processSafeTransRequest(String actionKey){
		
		String l_app_msg = "", l_errmsg = "", l_responseJsonString = "";
		String l_message_id = "", l_facility_id = "";
		String l_patient_id = "", l_encounter_id = "", l_practitioner_id = "", l_order_id = "";
		String l_in_JSON = "", l_err_msg = "";
		HashMap<String, String> ordermap = new HashMap<String, String>();
		String l_request_ref_no = "", l_request_type = "", l_request_date_time = "";
		String order_line_number = "", serv_code = "", serv_date = "", qty = "", l_folio_remarks = "";
		StringBuffer l_error = new StringBuffer();
		String l_response_str = "", l_response_err_json = "";
		Map<String, String> params = new HashMap<String, String>();
		PractoInboundTransaction practoInboundTransaction = new PractoInboundTransaction();
		int l_order_data_length = 0;
		
		String l_status = "", l_status_desc = "";
		Map<String, Object> l_response_json = new HashMap<String, Object>();
		ObjectMapper objMapper = new ObjectMapper();
		String err_status = "", err_text = "";
		
		CallableStatement cs = null;
		Connection con		 = null;
		try{
		
		l_debug_YN = XHUtil.l_debug_YN;
		
		
		l_app_msg = " ::: Inside DiettoOrder processRequest ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = " ::: Generating Message ID ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_message_id = PractoInboundTransaction.GenerateMessageIDMethod("XH_IB_MESSAGE_ID_SEQ");	
		
		if (l_message_id.indexOf("Error") >= 0) {
			l_errmsg = "Message ID Generation - "+l_message_id;
			l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_errmsg + " \" "+ " } ";
			
			return "200#" + l_response_err_json + "#";
		}
		
		l_app_msg = " ::: Generated Message Id ::: "+l_message_id+" ::: Error Code : "+l_errcd+" ::: Error Message : "+l_errmsg;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);			

		params.put("MESSAGE_ID", l_message_id);
		//params.put("APPLICATION_ID", l_application_id);
		//params.put("FACILITY_ID", l_facility_id);
		params.put("PROTOCOL_LINK_ID", "KHSAFETPL1");
		params.put("APPLICATION_ID", "SAFETRANS");
		params.put("EVENT_TYPE", "SOR");
		l_app_msg = " ::: params : "+params;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		
		
		l_app_msg = "::: Parsing input message ::: ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_in_JSON = XHJSONUtil.createJsonObject(actionKey);
		
		if (l_in_JSON.indexOf("Error") >= 0) {
			l_errcd = "E";
			l_err_msg = l_in_JSON;

			l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_err_msg + " \"  "	+ " } ";				
			
			l_app_msg = "::: Loading the message when : "+l_err_msg;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_response_str = practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
			l_app_msg = l_app_msg+" : " + l_response_str;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			return "200#" + l_response_err_json + "#";

		}
		
		l_app_msg = " ::: Getting Request Ref Number from JSON :::";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_request_ref_no = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_ref_no");
		if (l_request_ref_no.indexOf("Error") >= 0 || l_request_ref_no.length() <= 1 || l_request_ref_no.equals("")) {
			l_errcd = "E";
			l_error.append(" - Request Reference Number");	
		}
		l_app_msg = " ::: Request Ref Number : " + l_request_ref_no;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = " ::: Getting Request Type from JSON :::";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_request_type = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_type");
		if (l_request_type.indexOf("Error") >= 0 || l_request_type.length() <= 1 || l_request_type.equals("")) {
			l_errcd = "E";
			l_error.append(" - Request Type");
		}
		l_app_msg = " ::: Request Type : " + l_request_type;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = " ::: Getting Request Date Time from JSON ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_request_date_time = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_date_time");	
		l_app_msg = " ::: Request Date Time : " + l_request_date_time;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		
		l_app_msg = " ::: Getting Patient ID from JSON ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_patient_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "patient_id");
		
		l_app_msg = " ::: Patient ID : " + l_patient_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = " ::: Getting Facility ID from JSON ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_facility_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "facility_id");
		params.put("FACILITY_ID", l_facility_id);
		
		l_app_msg = " ::: Facility ID : " + l_facility_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = " ::: Getting Encounter ID from JSON ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_encounter_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "encounter_id");
		l_app_msg = " ::: Encounter ID : " + l_encounter_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = " ::: Getting Request Practitioner ID from JSON :::";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_practitioner_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "practitioner_id");
		l_app_msg = " ::: Practitioner ID : " + l_practitioner_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = " ::: Getting Request Order ID from JSON :::";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_order_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "order_id");
		l_app_msg = " ::: Order ID : " + l_order_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		if(l_in_JSON.contains("order_data"))
		{
			l_app_msg = " ::: Reading in Order Data  ::: ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			try {
				
				String l_order_data_str = XHJSONUtil.getJsonRequestString(l_in_JSON, "order_data");
				if (l_order_data_str.indexOf("Error in") >= 0  || "".equals(l_order_data_str.trim())  )
				{
					l_errcd = "E";
					l_error.append("- Order Data cannot be empty ");
				}
				
				if (l_errcd.equals("E"))
				{			
					l_response_err_json = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);				
					return "200#"+ l_response_err_json +"#";			
				}
				
				
				JSONArray jArray = new JSONArray(l_order_data_str);
				l_order_data_length = jArray.length();
				for(int i = 0; i < l_order_data_length ; i++ ){
					
					JSONObject jObect = jArray.getJSONObject(i);
					order_line_number = jObect.getString("order_line_number");
					serv_code = jObect.getString("serv_code");
					serv_date = jObect.getString("serv_date");
					qty = jObect.getString("qty");
					 
					 ordermap.put("serv_code"+i, serv_code);
					 ordermap.put("order_line_number"+i, order_line_number);
					 ordermap.put("serv_date"+i, serv_date);
					 ordermap.put("qty"+i, qty);
				}
				
				l_app_msg = " ::: OrderMap : " + ordermap;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				for( int i = 0; i < l_order_data_length; i++){
				
					try{
							
							Long k_encounter_id = Long.parseLong(l_encounter_id);
							String DiettoServiceQuery = " {call BL_DIETTO_SERVICES(?,?,?,?,?,?,?,?,?,?,?,?)}";
							
							con = EMDataSource.getConnection();
							cs = con.prepareCall(DiettoServiceQuery);
							
							 cs.setString(1, l_facility_id);
							 cs.setString(2, l_patient_id);
							 cs.setLong(3, k_encounter_id);
							 cs.setString(4, ordermap.get("serv_code"+i).toString());							
							 cs.setString(5, ordermap.get("serv_date"+i).toString());
							 cs.setInt(6, Integer.parseInt(ordermap.get("qty"+i).toString()));
							 cs.setString(7, l_practitioner_id);
							 cs.setString(8 , l_order_id);
							 cs.setInt(9 , Integer.parseInt(ordermap.get("order_line_number"+i).toString()));
							 cs.setString(10, l_folio_remarks);
							 cs.registerOutParameter(11,Types.VARCHAR);
							 cs.registerOutParameter(12,Types.VARCHAR);
							
							 cs.execute();
							 err_text = cs.getString(11);
							 err_status = cs.getString(12);
							 
							 ordermap.put("err_status"+i, err_status);
							 ordermap.put("err_text"+i, err_text);
							 
							 l_errcd = err_status;
							 
							 l_app_msg = " ::: BL_DIETTO_SERVICES : err_text : "+err_text+" ::: errcd : "+l_errcd;
							 if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
							
							 if(l_errcd.equals("E")){
								 break;
							 }
						} catch (Exception e) {
							l_errcd = "E";
							e.printStackTrace();
							l_app_msg = " ::: Exception while calling BL_DIETTO_SERVICES - "+ e.getMessage();
						    if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						} finally {
							EMDataSource.returnConnection(con);
							XHUtil.closeDBResources(null, cs, null);
					}
				
				}
			
			}catch (Exception e){
				e.printStackTrace();
				l_errcd = "E";
				l_app_msg = " ::: Exception while reading order data - "+e.getMessage();
			    if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			}
			
			if (l_debug_YN.equals("Y"))	System.out.println(" ::: Order Map: "+ordermap);
			if(l_errcd.equals("S") ){
				l_status = "1";
				l_status_desc = "Safetrans Order Successfully Created";
				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				
				l_responseJsonString = objMapper.writeValueAsString(l_response_json);
				
				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				l_response_str = practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, "");
				l_app_msg = " ::: Message Load Method  ::: "+ l_response_str;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				return "200#"+ l_responseJsonString +"#";
				
			}else {
				
				l_status = "0";
				l_status_desc = "Safetrans Order Failed - "+err_text;
				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				
				
				l_responseJsonString = objMapper.writeValueAsString(l_response_json);
				
				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				l_response_str = practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, err_text);
				l_app_msg = " ::: Message Load Method  ::: "+ l_response_str;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				return "200#"+ l_responseJsonString +"#";
				
			}
		}
		}catch (Exception e) {
			e.printStackTrace();
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^ Exception Occurred " + e.getMessage();
			l_responseJsonString = l_errmsg;
			
			params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
			l_response_str = practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_errmsg);
			l_app_msg = " ::: Message Load Method  ::: "+ l_response_str;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);			
			
		}
		
		l_app_msg = " ************ SafeTrans Transaction Ended ************ ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		
		
		return "200#"+ l_responseJsonString +"#";
	}
	
	public  String sendErrorResponse(String actionKey, String error , String request_ref_no, Map<String, String> params)
	{
		String l_status = "", l_status_desc = "", l_responseJsonString = "",l_app_msg ="",  l_response_str = "";
		Map<String, Object> l_response_json = new HashMap<String, Object>();
		PractoInboundTransaction practoInboundTransaction = new PractoInboundTransaction();
		ObjectMapper objMapper = new ObjectMapper();
		
		try 
		{
			l_app_msg = " ::: Inside sendErrorResponse ::: ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_status = "0";
			l_status_desc = error;
			l_response_json.put("request_ref_no", request_ref_no);
			l_response_json.put("status", l_status);
			l_response_json.put("status_desc", l_status_desc);
			
			l_responseJsonString = objMapper.writeValueAsString(l_response_json);
			
			params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
			l_response_str = practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, error);
			l_app_msg = " ::: Message Load Method  ::: "+ l_response_str;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);				
			
		}catch(Exception e)
		{
			
		}
		
		return l_responseJsonString;
		
	}
	
	public static String getFormattedStringDate(String format, java.util.Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
		String dateFormatted = dateFormat.format(date);
		return dateFormatted;
	}

}
