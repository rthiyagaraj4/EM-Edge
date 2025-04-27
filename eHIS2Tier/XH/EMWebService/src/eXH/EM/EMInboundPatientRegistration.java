package eXH.EM;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import eXH.util.EMDataSource;
import eXH.util.XHDBAdapter;
import eXH.util.XHJSONUtil;
import eXH.util.XHUtil;

public class EMInboundPatientRegistration {
	

	
	public static String l_debug_YN = "N";

	public String l_errcd = "S", l_field_separator = "$!^", l_searchcd = "S";
	public String l_errmsg = "";
	public String l_ack_text = "";
	public String l_update_response_str = "";
	
	public static String l_segment_id="";
	public static String l_standard_code="";
	
	static LinkedHashMap<String, HashMap<String, String>> new_hash_map = new LinkedHashMap<String, HashMap<String,String>>();
	static StringBuffer query3 = new StringBuffer();
	static Map<String, Object> l_response_json = new HashMap<String, Object>();
	public static String l_pat_no_gen_yn="";
	
	static String site_id="";
	static String l_pat_no_ctrl="";
	static String l_site_id ="";
	static String alt_id1_no="";
	static String l_pat_ser_grp = "";
	static boolean transaction_completed	= false;
	static String Patient_id = null;
	static String l_facility_id="";
	static String l_language_id = "";
	static String keyStr = "";
	static String valueStr = "";
	static String regn_facility_id ="N";
	static String added_by_id ="INTERFACE";
	static String added_date ="";
	static String added_at_ws_no ="INTERFACE";
	static String modified_at_ws_no ="INTERFACE";
	static String modified_by_id="INTERFACE";
	static String modified_date ="";
	static String modified_facility_id ="";
	static String citizen_yn ="Y";
	static String l_blng_grp_id ="";
	static String l_biling_group_id ="";
	static String l_biling_class_code="";
	static String l_settlement_ind="";
	static String l_settlement_type="";
	static String l_cur_acct_seq_no="1";
	static String l_app_msg="";
	static String l_status = "", l_status_desc = "", l_responseJsonString = "";
	static String l_patient_nat_id_type ="";
	

	public static String l_conn_msg = "Error - Unable to connect to the Data base, Kindly contact the System Administrator";
	

	public String processInPatRegRequest(String actionKey, String key, String eventType, String method) {
		
		String l_app_msg = "",  l_err_msg = "";
		String l_response_err_json = "", l_facility_id = "";
		String l_in_JSON = "", l_response_str = "", l_message_id = "", l_application_id = "", l_protocol_link_id = "";
		String l_status = "", l_status_desc = "";
		String l_request_date_time ="", l_gender ="", l_date_of_birth = "";
		String  l_mobile_no = "", l_nationality_code = "", l_nationality_desc = "", l_address_line_1 = "", 
				l_address_line_2 = "", l_town_code = "", l_town_desc = "", l_area_code = "", l_area_desc="", 
				l_region_code = "", l_region_desc ="",
				l_postal_code = "", l_country_code = "", l_country_desc = "", l_email_id = "",
			    l_identification_type_code ="",	l_identification_type_desc = "" , l_identification_id="";
		
		String l_first_name = "", l_second_name = "", l_third_name = "", l_patient_id = "";
		String l_country_validate = "", l_postal_code_validate = "", l_element_id = "", l_nationality_id = "";

		List<Map<String,String>> l_searchPatientDetails = new ArrayList<Map<String,String>>();
		List<Map<String,String>> l_patient_resp = new ArrayList<Map<String,String>>();
		Map<String, String> params = new HashMap<String, String>();
		Map<String, Object> l_response_json = new HashMap<String, Object>();
		ObjectMapper objMapper = new ObjectMapper();
		Map<String,String> l_req_params = new HashMap<String, String>();

		String l_request_ref_no = "", l_request_type = "", l_responseJsonString = "";
		
		StringBuffer l_error = null;
		
		ArrayList<String> l_protocol_details = null;

		ArrayList<String> l_segment_details = null;
		
		String query = "", l_debug_yn = "";		
		Connection dbConn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			dbConn = EMDataSource.getConnection();
			query = "select NVL(DEBUG_YN, 'N') DEBUG_YN FROM XH_PARAM ";

			pstmt = dbConn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				l_debug_yn = rs.getString("DEBUG_YN");
			}

			l_debug_YN = l_debug_yn;

		} catch (Exception e) {
		} finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			//EMDataSource.returnConnection(dbConn);
		}
		
		try
		{
			
			l_app_msg = " ************ EM Inbound Register Patient Transaction started ************ ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_error = new StringBuffer("Unable to Register the Patient - Information Missing");
	
			l_app_msg = " ::: Inside EM Inbound Register Patient Details :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);	
		
			l_app_msg = "::: Validating the request with key ::: " + key;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_response_err_json = validateRequest(key, dbConn);

			if (l_errcd.equals("E")) {

				l_app_msg = "::: Loading the message when : " + l_err_msg;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json, dbConn);
				l_app_msg = l_app_msg + " : " + l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				return "401#" + l_response_err_json + "#";

			}

			if (l_errcd.equals("S")) {
				l_app_msg = "::: Fetching Segment Details : ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_segment_details = FetchSegmentDetails(key, dbConn);

				if (l_segment_id.indexOf("Error") >= 0) {
					l_errmsg = "Fetching Segment Details - " + l_segment_id;
					l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_errmsg + " \"  "+" } ";

					return "200#" + l_response_err_json + "#";
				}

				l_app_msg = " ::: Segment : " + l_segment_details + " ::: Error Code : " + l_errcd
						+ " ::: Error Message : " + l_errmsg;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

			}

			if (l_errcd.equals("S")) {
				l_segment_id = (String) l_segment_details.get(0);
				l_standard_code = (String) l_segment_details.get(1);
			}

			l_app_msg = " ::: Generating Message ID ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_message_id = GenerateMessageIDMethod("XH_IB_MESSAGE_ID_SEQ", dbConn);

			if (l_message_id.indexOf("Error") >= 0) {
				l_errmsg = "Message ID Generation - " + l_message_id;
				l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_errmsg + " \"  "+ " } ";

				return "200#" + l_response_err_json + "#";
			}

			l_app_msg = " ::: Generated Message Id ::: " + l_message_id + " ::: Error Code : " + l_errcd
					+ " ::: Error Message : " + l_errmsg;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (l_errcd.equals("S")) {
				l_app_msg = "::: Fetching Protocol Details : ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_protocol_details = FetchAppDetails(l_standard_code, dbConn);

				if (l_protocol_details.isEmpty()) {
					l_errcd = "E";
					l_errmsg = "Error in Fetching protocol details No Data Available";
					l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_errmsg + " \"  "
							+ " } ";
					return "200#" + l_response_err_json + "#";
				}

				l_application_id = (String) l_protocol_details.get(0);

				if (l_application_id.indexOf("Error") >= 0) {
					l_errmsg = "Fetching protocol Details - " + l_application_id;
					l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_errmsg + " \"  "
							+ " } ";

					return "200#" + l_response_err_json + "#";
				}

				l_app_msg = " ::: Message ID : " + l_message_id + " ::: Protocol : " + l_protocol_details
						+ " ::: Error Code : " + l_errcd + " ::: Error Message : " + l_errmsg;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

			}

			if (l_errcd.equals("S")) {
				l_application_id = (String) l_protocol_details.get(0);
				l_protocol_link_id = (String) l_protocol_details.get(1);
				l_facility_id = (String) l_protocol_details.get(2);
			}

			params.put("MESSAGE_ID", l_message_id);
			params.put("APPLICATION_ID", l_application_id);
			params.put("FACILITY_ID", l_facility_id);
			params.put("PROTOCOL_LINK_ID", l_protocol_link_id);
			params.put("EVENT_TYPE", eventType);

			l_response_str = MessageLoadMethod(actionKey, params, l_errcd, "", dbConn);
			l_app_msg = " ::: Message Load Method  ::: " + l_response_str;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
		
			/*
			l_app_msg = " ::: Action Key :::"+actionKey;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			*/	
			
			l_app_msg = " ::: Parsing input message ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);		
	
			l_in_JSON = XHJSONUtil.createJsonObject(actionKey);
			
			if (l_in_JSON.indexOf("Error") >= 0) {
				l_errcd = "E";
				l_errmsg = l_in_JSON;
				l_error.append(l_errmsg);
			}		
			
			//To check for error and send the response with error message and update XH_INBOUND_MESSAGE Table.
			
			params.put("ERR_MSG", "");

			l_responseJsonString = "";
			
			if (l_errcd.equals("E"))
			{
				l_app_msg = " ::: Inserting Request into Message Table ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);			
				
				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);
				
				return "200#"+ l_responseJsonString +"#";		
				
			}
			
			l_app_msg = " ::: Getting Request Ref Number from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	
			l_request_ref_no = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_ref_no");
			if (l_request_ref_no.indexOf("Error") >= 0 || l_request_ref_no.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Request Reference Number");
			}
			l_app_msg = " ::: Request Ref Number : " + l_request_ref_no;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("request_ref_no", l_request_ref_no);
			
			
			l_app_msg = " ::: Getting Request Type from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	
			l_request_type = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_type");
			if (l_request_type.indexOf("Error") >= 0 || l_request_type.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Request Type");
			}
			l_app_msg = " ::: Request Type : " + l_request_type;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("request_type", l_request_type);
			
			l_app_msg = " ::: Getting Request Date Time from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	
			l_request_date_time = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_date_time");
			if (l_request_date_time.indexOf("Error") >= 0 || l_request_date_time.trim().equals("") ) {
				l_errcd = "E";
				l_error.append(" - Request Date Time");
			}
			l_app_msg = " ::: Request Date Time : " + l_request_date_time;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("request_date_time", l_request_date_time);		
			
			l_app_msg = " ::: Getting Request Patient Id from JSON method... "+method;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_patient_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","patient_id");
			l_patient_id = l_patient_id.trim();
			if (method.equalsIgnoreCase("R")) {
				if (l_patient_id.indexOf("Error") >= 0  || l_patient_id.trim().equals("")) {
					l_patient_id = "";
				}
			}
			if (method.equalsIgnoreCase("P")) {
				if (l_patient_id.indexOf("Error") >= 0  || l_patient_id.trim().equals("")) {
					l_errcd = "E";
					l_error.append(" - Patient Id");
				}
			}
			
			l_app_msg = " ::: Patient Id : " + l_patient_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("patient_id", l_patient_id);		
			
			
			l_app_msg = " ::: Getting Request First name from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_first_name = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","first_name");
			l_first_name = l_first_name.trim();
			/*
			if (l_first_name.indexOf("Error") >= 0 || l_first_name.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Patient First Name");
			}
			*/
			l_app_msg = " ::: First Name : " + l_first_name;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("first_name", l_first_name);
			
			l_app_msg = " ::: Getting Request Second name from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_second_name = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","second_name");
			l_second_name = l_second_name.trim();
			if (l_second_name.indexOf("Error") >= 0  || l_second_name.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Patient Second Name");
			}
			l_app_msg = " ::: Second Name : " + l_second_name;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("second_name", l_second_name);		
			
			l_app_msg = " ::: Getting Request Family name from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_third_name = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","third_name");
			l_third_name = l_third_name.trim();
			/*
			if (l_third_name.indexOf("Error") >= 0  || l_third_name.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Patient third_name");
			}
			*/
			l_app_msg = " ::: third name : " + l_third_name;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("third_name", l_third_name);
			
			l_app_msg = " ::: Getting Request Gender from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_gender = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","gender");
			l_gender = l_gender.trim();
			
			if (l_gender.indexOf("Error") >= 0 || l_gender.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Gender");
			}
			
			if (!l_gender.equals("M") && !l_gender.equals("F") && !l_gender.equals("U")) {
				l_errcd = "E";
				l_error.append(" - Gender"+l_gender);				
			}
			l_app_msg = " ::: Gender : " + l_gender;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("gender", l_gender);
			
			
			l_app_msg = " ::: Getting Request Date of Birth from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_date_of_birth = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","date_of_birth");
			l_date_of_birth = l_date_of_birth.trim();
			if (l_date_of_birth.indexOf("Error") >= 0 || l_date_of_birth.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Date Of Birth");
			}
			l_app_msg = " ::: Date of Birth : " + l_date_of_birth;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("date_of_birth", l_date_of_birth);
			
			l_app_msg = " ::: Getting Request Mobile Number from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_mobile_no = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","mobile_no");
			l_mobile_no = l_mobile_no.trim();
			if (l_mobile_no.indexOf("Error") >= 0 || l_mobile_no.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Mobile Number");
			}
			l_app_msg = " ::: Mobile Number : " + l_mobile_no;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("mobile_no", l_mobile_no);
			
			l_app_msg = " ::: Getting Request Nationality_code from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_nationality_code = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","nationality_code");
			l_nationality_code = l_nationality_code.trim();
			if (l_nationality_code.indexOf("Error") >= 0 || l_nationality_code.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Nationality Code");
			}
			l_app_msg = " ::: Nationality : " + l_nationality_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("nationality_code", l_nationality_code);
			
			l_app_msg = " ::: Getting Request Nationality desc from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_nationality_desc = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","nationality_desc");
			l_nationality_desc = l_nationality_desc.trim();
			/*
			if (l_nationality_desc.indexOf("Error") >= 0 || l_nationality_desc.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Nationality Desc");
			}
			*/
			l_app_msg = " ::: Nationality : " + l_nationality_desc;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("nationality_desc", l_nationality_desc);
			
			l_app_msg = " ::: Getting Request Address Line 1 from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_address_line_1 = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","address_line_1");
			/*
			if (l_address_line_1.indexOf("Error") >= 0 || l_address_line_1.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Address1");
			}
			*/
			l_app_msg = " ::: Address Line 1 : " + l_address_line_1;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("address_line_1", l_address_line_1);
			
			l_app_msg = " ::: Getting Request Address Line 2 from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_address_line_2 = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","address_line_2");			
			l_app_msg = " ::: Address Line 2 : " + l_address_line_2;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("address_line_2", l_address_line_2);
			
			l_app_msg = " ::: Getting Request town_code from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_town_code = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","town_code");		
			l_app_msg = " ::: l_town_code : " + l_town_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_req_params.put("town_code", l_town_code);
			
			l_app_msg = " ::: Getting Request town_desc from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_town_desc = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","town_desc");		
			l_app_msg = " ::: town_desc : " + l_town_desc;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_req_params.put("town_desc", l_town_desc);
			
			l_app_msg = " ::: Getting Request area_code from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_area_code = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","area_code");
			l_area_code = l_area_code.trim();
			l_app_msg = " ::: l_area_code : " + l_area_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_req_params.put("area_code", l_area_code);
			
			l_app_msg = " ::: Getting Request area_desc from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_area_desc = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","area_desc");
			l_area_desc = l_area_desc.trim();
			l_app_msg = " ::: area_desc : " + l_area_desc;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_req_params.put("area_desc", l_area_desc);
			
			l_app_msg = " ::: Getting Request region_code from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_region_code = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","region_code");
			l_region_code = l_region_code.trim();
			l_app_msg = " ::: region_code : " + l_region_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_req_params.put("region_code", l_region_code);
			
			l_app_msg = " ::: Getting Request region_desc from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_region_desc = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","region_desc");
			l_region_desc = l_region_desc.trim();
			l_app_msg = " ::: region_desc : " + l_region_desc;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_req_params.put("region_desc", l_region_desc);
			
			
			l_app_msg = " ::: Getting Request Postal Code from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_postal_code = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","postal_code");
			l_postal_code = l_postal_code.trim();
			/*
			if (l_postal_code.indexOf("Error") >= 0 || l_postal_code.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Postal Code");
			}
			*/
			l_app_msg = " ::: Postal Code : " + l_postal_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			
			l_app_msg = " ::: Getting Request Country Code from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_country_code = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","country_code");
			l_country_code = l_country_code.trim();
			/*
			if (l_country_code.indexOf("Error") >= 0 || l_country_code.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - country_code");
			}
			*/
			l_app_msg = " ::: country_code : " + l_country_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("country_code", l_country_code);
			
			l_app_msg = " ::: Getting Request Country Desc from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_country_desc = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","country_desc");
			l_country_desc = l_country_desc.trim();
			/*
			if (l_country_desc.indexOf("Error") >= 0 || l_country_desc.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - country_desc");
			}
			*/
			l_app_msg = " ::: country_desc : " + l_country_desc;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("country_desc", l_country_desc);
					
			l_app_msg = " ::: Getting Request Email ID from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_email_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","patient_email");
			/*
			if (l_email_id.indexOf("Error") >= 0 || l_email_id.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Email_id");
			}
			*/
			if (l_email_id.indexOf("Error") >= 0 || l_email_id.trim().equals("")) {
				l_email_id = "";
			}
			l_app_msg = " ::: Email Id : " + l_email_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("email_id", l_email_id);
			
			
			l_app_msg = " ::: Getting Request identification_type_code from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_identification_type_code = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","identification_type_code");
			if (l_identification_type_code.indexOf("Error") >= 0 || l_identification_type_code.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - identification_type_code");
			}
			l_app_msg = " ::: identification_type_code Id : " + l_identification_type_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("identification_type_code", l_identification_type_code);
			
			
			l_app_msg = " ::: Getting Request identification_type_desc from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);			
			
			l_identification_type_desc = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","identification_type_desc");
			/*
			if (l_identification_type_desc.indexOf("Error") >= 0 || l_identification_type_desc.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - l_identification_type_desc");
			}
			*/
			l_app_msg = " ::: identification_type_desc : " + l_identification_type_desc;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("identification_type_desc", l_identification_type_desc);
			
			l_app_msg = " ::: Getting Request identification_id from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_identification_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","identification_id");
			/*
			if (l_identification_id.indexOf("Error") >= 0 || l_identification_id.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - identification_id");
			}
			*/
			l_app_msg = " ::: identification_id : " + l_identification_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("identification_id", l_identification_id);
			
			l_app_msg = " ::: Getting Request facility_id from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_facility_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","facility_id");
			if (l_facility_id.indexOf("Error") >= 0 || l_facility_id.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Facility ID");
			}
			l_app_msg = " ::: facility_id : " + l_facility_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("facility_id", l_facility_id);			
			
			l_biling_group_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","blng_grp_id");
			if (l_biling_group_id.indexOf("Error") >= 0 || l_biling_group_id.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Billing Group Id");
			}
			l_app_msg = " ::: Getting Request Billing group Id from JSON ::: "+l_biling_group_id;
			if (l_debug_YN.equals("Y"))				
				System.out.println(l_app_msg);
			
			l_req_params.put("biling_group_id", l_biling_group_id);
			
			params.put("ERR_MSG", "");
			
			if (l_errcd.equals("E"))
			{
				l_app_msg = " ::: Inserting Request into Message Table while message data validation ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);			
				
				return "200#"+ l_responseJsonString +"#";			
			}	
			
			l_error = new StringBuffer("Unable to Register the Patient");
			
			if(l_errcd.equals("S")){
				
				l_app_msg = " ::: Validating Country  ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_country_validate = validateCountry(l_country_code, dbConn);
				
				l_app_msg = " ::: Country  ::: "+l_country_validate;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				if(l_country_validate.equals("")){
					l_errcd = "E";
					l_error.append(" - Country does not match with the EM Country Master Data ");			
				}
				
				l_app_msg = " ::: Validating Postal Code ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_postal_code_validate = validatePostalCode(l_postal_code, dbConn);
				
				l_req_params.put("postal_code", l_postal_code_validate);
				
				l_app_msg = " ::: Postal  ::: "+l_postal_code_validate;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				if(l_postal_code_validate.equals("")){
					l_errcd = "E";
					l_error.append(" - Postal Code does not match with the EM Postal Code Master Data ");				
				}				
				
				l_app_msg = " ::: Validating Nationality  ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				String l_nationality_validate = validatenationalityCode(l_nationality_code, dbConn);
				
				l_app_msg = " ::: Nationality  ::: "+l_nationality_validate;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				if(l_nationality_validate.equals("")){
					l_errcd = "E";
					l_error.append(" - Nationality does not match with the EM Master Data ");			
				}
				
				if (l_errcd.equals("S"))
				{
					l_element_id = "NATIONALITY_CODE";
					l_nationality_id = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Configured Nationality ID ::: "+ l_nationality_id);

					citizen_yn = "N";
					if (l_nationality_id.equalsIgnoreCase(l_nationality_code))
						citizen_yn = "Y";
					
					l_req_params.put("citizen_yn", citizen_yn);
						
				}
			}
			
			params.put("ERR_MSG", "");
			
			if (l_errcd.equals("E"))
			{
				l_app_msg = " ::: Inserting Request into Message Table while Postal & Country data validation ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);					
				
				return "200#"+ l_responseJsonString +"#";			
			}	
			
			l_error = new StringBuffer("Unable to Register the Patient ");
			
			if(l_errcd.equals("S")){
				
				l_app_msg = " ::: Checking Patient Exists or Not ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				//Patient Id condition added.
				
				l_searchPatientDetails = searchPatient(l_first_name, l_second_name, l_third_name, l_gender, l_date_of_birth, l_patient_id, dbConn);
				
				if(l_searchPatientDetails.isEmpty()){
					l_searchcd = "E";
					l_app_msg = " ::: Search patient data not matched ::: "+l_searchPatientDetails;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
				}
				
				params.put("ERR_MSG", "");
				
				//Condition added to check for POST (R) method and to validate if the patient exist				
				if (method.equalsIgnoreCase("R")){				
					if(l_searchcd.equals("S")){			
						
						l_response_json.put("request_data", l_searchPatientDetails);			
						
						l_app_msg = " ::: Inserting Request into Message Table while searching patient data check ::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						
						l_status = "0";
						l_status_desc = "Patient data already exists";
						l_response_json.put("request_ref_no", l_request_ref_no);
						l_response_json.put("status", l_status);
						l_response_json.put("status_desc", l_status_desc);
						l_response_json.put("request_data", l_searchPatientDetails);
						
						l_responseJsonString = objMapper.writeValueAsString(l_response_json);
						
						params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
						params.put("ERR_MSG", l_error.toString());
						
						l_response_str = MessageLoadMethod(actionKey, params, l_errcd, "", dbConn);
						l_app_msg = " ::: Message Load Method  ::: "+ l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);				
					
						return "200#"+ l_responseJsonString +"#";				
					}	
				}
			}
			
			l_app_msg = " ::: After Search  l_errcd ::: "+l_errcd +" ::: l_searchcd ::: "+l_searchcd;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_app_msg = " ::: Calling Patient Registaion mehtod ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_error = new StringBuffer("Unable to Register the Patient ");
			
			if(l_errcd.equals("S")){
				
				l_app_msg = " ::: Registering New Patient ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				l_patient_id = PatientDetails(l_req_params, method, dbConn);
				
				if (l_patient_id.indexOf("Exception in") >= 0)
				{
					l_errcd = "E";
					l_error.append(l_patient_id);
				}
				params.put("ERR_MSG", "");
				if (l_errcd.equals("E"))
				{
					l_app_msg = " ::: Inserting Request into Message Table while message data validation ::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);
					

					params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
					//params.put("ERR_MSG", error);
					l_response_str = MessageLoadMethod(actionKey, params, l_errcd, "", dbConn);
					l_app_msg = " ::: Message Load Method  ::: "+ l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);				
					
					return "200#"+ l_responseJsonString +"#";			
				}	
					
			}	
			
			l_app_msg = " ::: Resgistered Patient Id ::: "+l_patient_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			if(l_errcd.equals("S")){
				
				l_app_msg = " ::: FetchPatient ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
			    l_patient_resp = FetchPatient(l_patient_id, dbConn );
			    
			}
			l_app_msg = " ::: FetchPatient Response ::: "+l_patient_resp;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			if(l_errcd.equals("S")){
				
				l_status = "1";
				if (method.equalsIgnoreCase("R")){
					l_status_desc = "Patient data successfully registered";
				}
				
				if (method.equalsIgnoreCase("P")){
					l_status_desc = "Patient data successfully Updated";
				}
				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				l_response_json.put("request_data", l_patient_resp);
				
				l_responseJsonString = objMapper.writeValueAsString(l_response_json);
				
				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				params.put("ERR_MSG", l_error.toString());
				
				l_response_str = MessageLoadMethod(actionKey, params, l_errcd, "", dbConn);
				l_app_msg = " ::: Message Load Method  ::: "+ l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);		
						
				l_app_msg = " ************ EM Register Patient Traction Ended ************ ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				return "200#"+ l_responseJsonString +"#";
			}				
		}catch(Exception e){
			
			e.printStackTrace();
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^ Exception Occurred " + e.getMessage();
			
			l_app_msg = " ************ EM Register Patient Traction Ended ************ ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
		}
		finally {
			EMDataSource.returnConnection(dbConn);
		}
		
		return "200#"+ l_response_err_json +"#";
	}
	public static List<Map<String, String>> FetchPatient(String patient_id, Connection dbConn)
	{
		//Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Map<String, String> record = new HashMap<String, String>();
		ArrayList<Map<String, String>> searchPatientDtls = new ArrayList<Map<String, String>>();
		String l_app_msg = "", query = "";
		
		l_app_msg = " ::: Inside FetchPatientName ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		
		l_app_msg = " ::: Patinet Id ::: "+patient_id;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		try
		{
			//dbConn = EMDataSource.getConnection();
			query = "select patient_id, first_name, second_name, third_name , patient_name, sex, to_char(date_of_birth,'dd/mm/yyyy') date_of_birth from mp_patient  where patient_id = ? ";
			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, patient_id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				record.put("patient_id", rs.getString("PATIENT_ID"));
				record.put("patient_name", rs.getString("patient_name"));
				record.put("first_name", rs.getString("first_name"));
				record.put("second_name", rs.getString("second_name"));
				record.put("third_name", rs.getString("third_name"));
				record.put("gender", rs.getString("sex"));
				record.put("date_of_birth", rs.getString("date_of_birth"));
				searchPatientDtls.add(record);
			}
			
			l_app_msg = " ::: Search patient Result ::: "+ searchPatientDtls;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
		}catch (Exception e) {
			l_app_msg = "Error in Fetch Patient Exception - "+ e.getMessage();
			record.put("Error", l_app_msg);
			searchPatientDtls.add(record);
		} finally {
			//EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		
		return searchPatientDtls;
		
	}

	public static List<Map<String, String>> searchPatient(String first_name, String second_name, String third_name, String gender, String dob, String patient_id, Connection dbConn) 
	{
		//Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Map<String, String> record = null;
		ArrayList<Map<String, String>> searchPatient = new ArrayList<Map<String, String>>();
		String query = "";
		StringBuffer whereClause = new StringBuffer();
		StringBuffer whereCond = new StringBuffer();
		String l_app_msg = "";
		
		l_app_msg = " ************************** Inside Search Patient ************************** ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		
		l_app_msg = " ::: First Name ::: "+first_name+" ::: Second Name ::: "+second_name+
					" ::: Family Name ::: "+third_name+" ::: Gender ::: "+gender+" ::: Date of Birth ::: "+dob+
					" ::: Patient Id ::: "+patient_id;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {		
			
			
			//dbConn = EMDataSource.getConnection();
			query = "select patient_id, first_name, second_name, third_name , patient_name, sex, to_char(date_of_birth,'dd/mm/yyyy') date_of_birth from mp_patient " ;
			whereClause.append(" where ");
			
			if (first_name.length()>0) 
				whereCond.append(" lower(first_name) = lower(?) ");
			
			if ((second_name.length()>0) && (whereCond.length()>0))
				whereCond.append(" AND lower(SECOND_NAME) = lower(?) ");
			else if (second_name.length()>0)
				whereCond.append(" lower(SECOND_NAME) = lower(?) ");
			
			if ((third_name.length()>0) && (whereCond.length()>0))
				whereCond.append(" AND lower(third_name) = lower(?) ");
			else if (third_name.length()>0)
				whereCond.append(" lower(third_name) = lower(?) ");
			
			if ((gender.length()>0) && (whereCond.length()>0))
				whereCond.append(" AND sex = ? ");
			else if (gender.length()>0)
				whereCond.append(" sex = ? ");
			
			if ((dob.length()>0) && (whereCond.length()>0))
				whereCond.append(" AND to_date(date_of_birth, 'dd/mm/rrrr') = to_date(?,'dd/mm/rrrr') ");
			else if (dob.length()>0)
				whereCond.append(" to_date(date_of_birth, 'dd/mm/rrrr') = to_date(?,'dd/mm/rrrr')");
			
			whereClause.append(whereCond);
			
			query = query + whereClause.toString();			
			
			l_app_msg = " ::: Query for search patient ::: "+ query;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			pstmt = dbConn.prepareStatement(query);
			
			
			if (first_name.length()>0) 
				pstmt.setString(1, first_name);

			if (second_name.length()>0) 
				pstmt.setString(2, second_name);
			else
				pstmt.setString(2, third_name);				

			if (second_name.length()>0 && third_name.length()>0) 
				pstmt.setString(3, third_name);

			if (second_name.length()>0 && gender.length()>0) 
				pstmt.setString(4, gender);
			else if (gender.length()>0)
				pstmt.setString(3, gender);

			if (second_name.length()>0 && dob.length()>0) 
				pstmt.setString(5, dob);
			else if (dob.length()>0)
				pstmt.setString(4, dob);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {	
				record = new HashMap<String, String>();
				record.put("patient_id", rs.getString("PATIENT_ID"));
				record.put("patient_name", rs.getString("patient_name"));
				record.put("first_name", rs.getString("first_name"));
				record.put("second_name", rs.getString("second_name"));
				record.put("third_name", rs.getString("third_name"));
				record.put("gender", rs.getString("sex"));
				record.put("date_of_birth", rs.getString("date_of_birth"));
				searchPatient.add(record);
			}
			l_app_msg = " ::: Search patient Result ::: "+ searchPatient;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
		} catch (Exception e) {
			record = new HashMap<String, String>();
			l_app_msg = "Error in Search Patient Exception - "+ e.getMessage();
			record.put("Error", l_app_msg);
			searchPatient.add(record);
		} finally {
			//EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}

		return searchPatient;
	}
	
	// Validating Mandatory City
	public static String validateCity(String l_area_code, Connection dbConn){
		String l_resp_fields = "";
		
		//Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "";
		
		l_app_msg = " ::: Inside validateCity ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		
		try {
			//dbConn = EMDataSource.getConnection();
			query = "select long_desc from MP_RES_TOWN where (lower(long_desc)) = lower(?)";


			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, l_area_code);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				l_resp_fields = rs.getString("long_desc");

			}
		}catch (Exception e) {
			l_resp_fields = "Error in Validate City Exception - " + e.getMessage();
		} finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			//EMDataSource.returnConnection(dbConn);
		}
		
		return l_resp_fields;
	}
	
	// Validating Mandatory District
		public static String validateDistrict(String l_region_code, Connection dbConn){
			String l_resp_fields = "";
			
			//Connection dbConn = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

			String query = "";
			String l_app_msg = "";
			
			l_app_msg = " ::: Inside validateDistrict ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			try {
				//dbConn = EMDataSource.getConnection();
				query = "select long_desc from MP_RES_AREA where trim(lower(long_desc)) = lower(?)";


				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, l_region_code);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					l_resp_fields = rs.getString("long_desc");

				}
			}catch (Exception e) {
				l_resp_fields = "Error in Validate District Exception - " + e.getMessage();
			} finally {
				XHUtil.closeDBResources(rs, pstmt, null);
				//EMDataSource.returnConnection(dbConn);
			}
			
			return l_resp_fields;
		}
		
		
		// Validate State
		public static String validateState(String l_state, Connection dbConn){
			String l_resp_fields = "";
			
			//Connection dbConn = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

			String query = "";
			String l_app_msg = "";
			
			l_app_msg = " ::: Inside validateState ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			try {
				//dbConn = EMDataSource.getConnection();
				query = "select long_desc from MP_REGION where trim(lower(long_desc)) = lower(?)";


				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, l_state);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					l_resp_fields = rs.getString("long_desc");

				}
			}catch (Exception e) {
				l_resp_fields = "Error in Validate State Exception - " + e.getMessage();
			} finally {
				XHUtil.closeDBResources(rs, pstmt, null);
				//EMDataSource.returnConnection(dbConn);
			}
			
			return l_resp_fields;
		}
		
		// Validate Country
		public static String validateCountry(String l_country_code, Connection dbConn){
			String l_resp_fields = "";
			
			//Connection dbConn = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

			String query = "";
			String l_app_msg = "";
			
			l_app_msg = " ::: Inside validateCountry ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			try {
				//dbConn = EMDataSource.getConnection();
				query = "select long_name from MP_COUNTRY where trim(lower(country_code)) = lower(?)";


				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, l_country_code);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					l_resp_fields = rs.getString("long_name");
				}
			}catch (Exception e) {
				l_resp_fields = "Error in Validate Country Exception - " + e.getMessage();
			} finally {
				XHUtil.closeDBResources(rs, pstmt, null);
				//EMDataSource.returnConnection(dbConn);
			}
			
			return l_resp_fields;
		}
		
		// Validate Postal Code
		public static String validatePostalCode(String postal_code, Connection dbConn){
			String l_resp_fields = "";
			
			//Connection dbConn = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			String query = "";
			String l_app_msg = "";
			
			l_app_msg = " ::: Inside validatePostalCode ::: "+" ::: Postal code ::: "+postal_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			try {
				//dbConn = EMDataSource.getConnection();
				query = "select postal_code from MP_POSTAL_CODE where trim(lower(long_desc)) = lower(?)";
				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, postal_code);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					l_resp_fields = rs.getString("postal_code");
				}
			}catch (Exception e) {
				l_resp_fields = "Error in Validate Postal Exception - " + e.getMessage();
			} finally {
				XHUtil.closeDBResources(rs, pstmt, null);
				//EMDataSource.returnConnection(dbConn);
			}
			
			return l_resp_fields;
			
		}
		
		// Validate Nationality
		public static String validatenationalityCode(String nationality_code, Connection dbConn){
			String l_resp_fields = "";
			
			//Connection dbConn = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			String query = "";
			String l_app_msg = "";
			
			l_app_msg = " ::: Inside validatenationalityCode ::: "+" ::: Nationality code ::: "+nationality_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			try {
				//dbConn = EMDataSource.getConnection();
				query = "Select LONG_DESC from mp_country where trim(lower(COUNTRY_CODE)) =  trim(lower(?))";
				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, nationality_code);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					l_resp_fields = rs.getString("LONG_DESC");
				}
			}catch (Exception e) {
				l_resp_fields = "Error in Validate Nationality Exception - " + e.getMessage();
			} finally {
				XHUtil.closeDBResources(rs, pstmt, null);
				//EMDataSource.returnConnection(dbConn);
			}
			
			return l_resp_fields;
			
		}
		
		public  String sendErrorResponse(String actionKey, String error , String request_ref_no, Map<String, String> params)
		{
			String l_status = "", l_status_desc = "", l_responseJsonString = "",l_app_msg ="";
			Map<String, Object> l_response_json = new HashMap<String, Object>();
			LinkedHashMap<String, String> patient_data = new LinkedHashMap<String, String>();
			//Map<String, String> params = new HashMap<String, String>();
			ObjectMapper objMapper = new ObjectMapper();
			
			try 
			{
				l_app_msg = " ::: Inside sendErrorResponse ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				patient_data.put("patient_id","");
				patient_data.put("patient_name","");
				
				l_status = "0";
				l_status_desc = error;
				l_response_json.put("request_ref_no", request_ref_no);
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				l_response_json.put("request_data", patient_data);		
				
				l_responseJsonString = objMapper.writeValueAsString(l_response_json);
				
				if (l_debug_YN.equals("Y"))
					System.out.println(l_responseJsonString);		
				
				
			}catch(Exception e)
			{
				
			}
			
			return l_responseJsonString;
			
		}

		public String validateRequest(String key, Connection dbConn) {
			String query = "";
			String l_app_msg = "", l_errmsg = "";
			//Connection dbConn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			int rowcount = 0;

			try {

				l_app_msg = " ::: Validating the request ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				//dbConn = EMDataSource.getConnection();
				query = "select segment_id, standard_code from xh_standard_control_seg where element_id = 'KEY' and default_value = ?  ";

				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, key);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					l_segment_id = rs.getString(1);
					l_standard_code = rs.getString(2);
					rowcount = rowcount + 1;
				}
				if (!(rowcount > 0)) {
					l_errcd = "E";
					l_errmsg = "Error in Key validation - key does not match";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_errmsg);
					return "{\"status\":0,\"error_message\":\"Authentication Error! - Key does not match\"} ";
				} else {
					return "true";
				}
			} catch (Exception e) {
				l_errcd = "E";
				l_errmsg = "Authentication Error! - Exception Occurred - " + e.getMessage();
				if (l_debug_YN.equals("Y"))
					System.out.println(l_errmsg);
				return "{\"status\":0,\"error_message\":\"Authentication Error! - Exception Occurred - " + e.getMessage()
						+ "\"}";
			} finally {
				XHUtil.closeDBResources(rs, pstmt, null);
				//EMDataSource.returnConnection(dbConn);
			}

		}

		public static ArrayList<String> FetchSegmentDetails(String key, Connection dbConn) {
			//Connection dbConn = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

			String query = "";
			String l_app_msg = "";
			ArrayList<String> segmentArray = new ArrayList<String>();

			l_app_msg = " ::: Inside FetchAppDetails ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = " ::: key : " + key;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			try {
				//dbConn = EMDataSource.getConnection();
				query = "select SEGMENT_ID,STANDARD_CODE from XH_STANDARD_CONTROL_SEG where ELEMENT_ID = 'KEY' AND DEFAULT_VALUE=?";

				if (dbConn == null) {
					segmentArray.add(l_conn_msg);
					return segmentArray;
				}

				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, key);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					l_segment_id = rs.getString("SEGMENT_ID");
					l_standard_code = rs.getString("STANDARD_CODE");
					segmentArray.add(l_segment_id);
					segmentArray.add(l_standard_code);
				}

				l_app_msg = " ::: l_segment_id ID : " + l_segment_id + " ::: l_standard_code : " + l_standard_code;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_app_msg = " ::: Method FetchSegmentDetails  : " + segmentArray;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

			} catch (Exception e) {
				l_segment_id = "Error in Fetching Segment Details Exception - " + e.getMessage();
				segmentArray.add(l_segment_id);
			} finally {
				XHUtil.closeDBResources(rs, pstmt, null);
				//EMDataSource.returnConnection(dbConn);
			}
			return segmentArray;
		}

		public static ArrayList<String> FetchAppDetails(String l_standard_code, Connection dbConn) {
			//Connection dbConn = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

			String query = "";
			String l_app_msg = "";
			ArrayList<String> externalArray = new ArrayList<String>();

			String l_application_id = "", l_protocol_link_id = "", l_facility_id = "";

			l_app_msg = " ::: Inside FetchAppDetails ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = " ::: l_standard_code : " + l_standard_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			try {
				//dbConn = EMDataSource.getConnection();
				query = "SELECT APPLICATION_ID, PROTOCOL_LINK_ID,FACILITY_ID FROM xh_protocol a, xh_protocol_link b "
						+ "WHERE a.protocol_id = b.protocol_id AND STANDARD_CODE = ? and PROTCOL_MODE = 'I'";

				if (dbConn == null) {
					externalArray.add(l_conn_msg);
					return externalArray;
				}

				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, l_standard_code);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					l_application_id = rs.getString("APPLICATION_ID");
					l_protocol_link_id = rs.getString("PROTOCOL_LINK_ID");
					l_facility_id = rs.getString("FACILITY_ID");
					externalArray.add(l_application_id);
					externalArray.add(l_protocol_link_id);
					externalArray.add(l_facility_id);
				}

				l_app_msg = " ::: Application ID : " + l_application_id + " ::: Protocol Link Id : " + l_protocol_link_id
						+ "::::::::facility_id:::::" + l_facility_id;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_app_msg = " ::: Method FetchExternalAppDetails  : " + externalArray;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

			} catch (Exception e) {
				l_application_id = "Error in Fetching External Application Details Exception - " + e.getMessage();
				externalArray.add(l_application_id);
			} finally {
				XHUtil.closeDBResources(rs, pstmt, null);
				//EMDataSource.returnConnection(dbConn);
			}
			return externalArray;
		}

		public String MessageLoadMethod(String message, Map<String, String> param, String status, String err_message, Connection dbConn) {

			String l_app_msg = "";
			String l_request_date = "", l_status_return = "";
			String l_element_id = "";

			try {				

				l_app_msg = " ::: Inside Message Loading ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				l_element_id = "APPL_USER_ID";
				added_by_id = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: APPL User Id ::: "+ added_by_id);

				l_request_date = getFormattedStringDate("dd-MMM-yyyy HH:mm:ss", new java.util.Date());

				new Timestamp(System.currentTimeMillis());

				l_app_msg = " ::: Requested Date ::: " + l_request_date;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_app_msg = " ::: Message Status ::: " + status;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				Map<String, String> params = new HashMap<String, String>();

				params.put("APPLICATION_ID", param.get("APPLICATION_ID")); // APPLICATION_ID
				params.put("FACILITY_ID", param.get("FACILITY_ID")); // FACILITY_ID
				params.put("MSG_ID", param.get("MESSAGE_ID")); // MSG_ID
				params.put("SRL_NO", "1"); // SRL_NO
				params.put("REQUEST_DATE", l_request_date); // REQUEST_DATE
				params.put("PROCESS_ID", ""); // PROCESS_ID

				params.put("CLIENT_ID", ""); // CLIENT_ID
				params.put("MESSAGE_TEXT", message); // INBOUND_MESSAGE_TEXT
				params.put("MESSAGE_ACK_TEXT", param.get("MESSAGE_ACK_TEXT")); // MESSAGE_ACK_TEXT
				params.put("MESSAGE_STATUS", status); // MESSAGE_STATUS
				params.put("RD_ORDER_YN", ""); // RD_ORDER_YN

				params.put("added_by_id", added_by_id);
				params.put("ADDED_BY_DATE", l_request_date);
				params.put("CLIENT_MACHINE", "INTERFACE");
				params.put("ADDED_BY_FACILITY", param.get("FACILITY_ID"));

				params.put("MODIFIED_BY_ID", added_by_id);
				params.put("MODIFIED_BY_DATE", l_request_date);
				params.put("CLIENT_MACHINE", "INTERFACE");
				params.put("MODIFIED_BY_FACILITY", param.get("FACILITY_ID"));

				params.put("PATIENT_ID", param.get("PATIENT_ID"));
				params.put("MERGED_PATIENT_ID", "");
				params.put("EPISODE_TYPE", "");
				params.put("EPISODE_ID", "");
				params.put("VISIT_ID", "");
				params.put("ACCESSION_NUM", "");
				params.put("ACTION_TYPE", "");

				params.put("LAST_PROC_DATE", "");
				params.put("EVENT_STATUS", "");
				params.put("NOT_REQ_REASON", "");
				params.put("EXT_ACCESSION_NUM", "");
				params.put("EVENT_TYPE", param.get("EVENT_TYPE"));
				params.put("PROTOCOL_LINK_ID", param.get("PROTOCOL_LINK_ID"));
				params.put("ERR_MSG", err_message);

				l_app_msg = "Inserting Inbound Message...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_status_return = insertInboundMessageDetails(params, dbConn);

				l_app_msg = "Inserting Inbound Message Status : " + l_status_return;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

			} catch (Exception e) {
				l_errcd = "E";
				l_errmsg = "Error in Loading the request message Status : " + l_status_return + " Exception : "
						+ e.getMessage();
				l_status_return = l_errmsg;
			}

			return l_status_return;
		}

		public static String getFormattedStringDate(String format, Date date) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
			String dateFormatted = dateFormat.format(date);
			return dateFormatted;
		}
		
		
		public String insertInboundMessageDetails(Map<String, String> params, Connection dbConn) {

			String selectStmt = "select count(*) record_count from XH_INBOUND_MESSAGE where application_id = ? and facility_id = ? and message_id = ?";

			String insertstmt = "INSERT INTO XH_INBOUND_MESSAGE (application_id, facility_id, message_id, srl_no, message_received_date, process_id, "
					+ " client_id, inbound_message_text, message_ack_text, message_status, rd_order_yn, "
					+ " added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, "
					+ " patient_id, merged_patient_id, episode_type, episode_id, visit_id, accession_num, action_type, "
					+ " last_proc_date, event_status, not_req_reason, ext_accession_num, event_type, protocol_link_id,err_msg) "
					+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

			String updateStmt = " UPDATE xh_inbound_message SET	ERR_MSG = ?, MESSAGE_ACK_TEXT = ?, "
					+ " MESSAGE_STATUS = ?, EPISODE_ID = ?, VISIT_ID = ? "
					+ " WHERE APPLICATION_ID = ? and facility_id = ? AND MESSAGE_ID = ? ";

			//Connection dbConn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			int insertCount = 0, updateCount = 0;

			String l_app_msg = "";

			String l_date = "";

			String l_err_msg = "Success";

			int l_record_count = 0;
			String l_appln_id = "", l_facility_id = "", l_message_id = "";

			try {

				l_app_msg = " ::: Inside Inbound Message Details ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				//dbConn = EMDataSource.getConnection();

				if (dbConn == null) {
					return l_conn_msg;
				}

				l_appln_id = params.get("APPLICATION_ID");
				l_facility_id = params.get("FACILITY_ID");
				l_message_id = params.get("MSG_ID");

				l_app_msg = " ::: Application Id... " + l_appln_id + " Facility Id... " + l_facility_id + " Mesage Id... "
						+ l_message_id;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				pstmt = dbConn.prepareStatement(selectStmt);
				pstmt.setString(1, params.get("APPLICATION_ID"));
				pstmt.setString(2, params.get("FACILITY_ID"));
				pstmt.setString(3, params.get("MSG_ID"));
				rs = pstmt.executeQuery();

				while (rs.next()) {
					l_record_count = rs.getInt("record_count");
				}

				l_app_msg = " ::: Application Id... " + l_appln_id + " Facility Id... " + l_facility_id + " Mesage Id... "
						+ l_message_id + " Record Count... " + l_record_count;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				if (l_record_count > 0) {

					pstmt = dbConn.prepareStatement(updateStmt);
					pstmt.setString(1, params.get("ERR_MSG")); // MESSAGE_ACK_TEXT
					pstmt.setString(2, params.get("MESSAGE_ACK_TEXT")); // MESSAGE_ACK_TEXT
					pstmt.setString(3, params.get("MESSAGE_STATUS"));
					pstmt.setString(4, params.get("EPISODE_ID"));
					pstmt.setString(5, params.get("VISIT_ID"));
					pstmt.setString(6, params.get("APPLICATION_ID"));
					pstmt.setString(7, params.get("FACILITY_ID"));
					pstmt.setString(8, params.get("MSG_ID"));

					l_app_msg = " ::: Application Id... " + params.get("APPLICATION_ID") + " Facility Id... "
							+ params.get("FACILITY_ID") + " Mesage Id... " + params.get("MSG_ID");
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					l_app_msg = " ::: Error Message... " + params.get("ERR_MSG") + " Message Ack text... "
							+ params.get("MESSAGE_ACK_TEXT") + " Status... " + params.get("MESSAGE_STATUS");
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					updateCount = pstmt.executeUpdate();

					l_app_msg = " ::: UpdateCount : " + updateCount;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					if (updateCount == 1) {
						dbConn.commit();
					} else {
						dbConn.rollback();
						l_errcd = "E";
						l_errmsg = " Error in updating Audit Table Data Records ";
					}
				} else {
					pstmt = dbConn.prepareStatement(insertstmt);

					l_date = params.get("REQUEST_DATE");

					l_app_msg = " ::: Requested Date : " + l_date;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					pstmt.setString(1, params.get("APPLICATION_ID"));
					pstmt.setString(2, params.get("FACILITY_ID"));
					pstmt.setString(3, params.get("MSG_ID"));
					pstmt.setString(4, params.get("SRL_NO")); // SRL_NO
					pstmt.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));
					pstmt.setString(6, XHDBAdapter.isNullReplace(params.get("PROCESS_ID"), "")); // PROCESS_ID

					pstmt.setString(7, XHDBAdapter.isNullReplace(params.get("CLIENT_ID"), "")); // CLIENT_ID
					pstmt.setString(8, params.get("MESSAGE_TEXT")); // INBOUND_MESSAGE_TEXT
					pstmt.setString(9, XHDBAdapter.isNullReplace(params.get("MESSAGE_ACK_TEXT"), "")); // MESSAGE_ACK_TEXT
					pstmt.setString(10, XHDBAdapter.isNullReplace(params.get("MESSAGE_STATUS"), "")); // MESSAGE_STATUS
					pstmt.setString(11, XHDBAdapter.isNullReplace(params.get("RD_ORDER_YN"), "")); // RD_ORDER_YN

					pstmt.setString(12, XHDBAdapter.isNullReplace(params.get("added_by_id"), params.get("LOGIN_USER")));
					pstmt.setTimestamp(13, new java.sql.Timestamp(System.currentTimeMillis()));
					pstmt.setString(14, params.get("CLIENT_MACHINE"));
					pstmt.setString(15,
							XHDBAdapter.isNullReplace(params.get("ADDED_BY_FACILITY"), params.get("FACILITY_ID")));

					pstmt.setString(16, XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_ID"), params.get("LOGIN_USER")));
					pstmt.setTimestamp(17, new java.sql.Timestamp(System.currentTimeMillis()));
					pstmt.setString(18, params.get("CLIENT_MACHINE"));
					pstmt.setString(19,
							XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_FACILITY"), params.get("FACILITY_ID")));

					pstmt.setString(20, XHDBAdapter.isNullReplace(params.get("PATIENT_ID"), ""));
					pstmt.setString(21, XHDBAdapter.isNullReplace(params.get("MERGED_PATIENT_ID"), ""));
					pstmt.setString(22, XHDBAdapter.isNullReplace(params.get("EPISODE_TYPE"), ""));
					pstmt.setString(23, XHDBAdapter.isNullReplace(params.get("EPISODE_ID"), ""));
					pstmt.setString(24, XHDBAdapter.isNullReplace(params.get("VISIT_ID"), ""));
					pstmt.setString(25, XHDBAdapter.isNullReplace(params.get("ACCESSION_NUM"), ""));
					pstmt.setString(26, XHDBAdapter.isNullReplace(params.get("ACTION_TYPE"), ""));

					pstmt.setString(27, XHDBAdapter.isNullReplace(params.get("LAST_PROC_DATE"), ""));
					pstmt.setString(28, XHDBAdapter.isNullReplace(params.get("EVENT_STATUS"), ""));
					pstmt.setString(29, XHDBAdapter.isNullReplace(params.get("NOT_REQ_REASON"), ""));
					pstmt.setString(30, XHDBAdapter.isNullReplace(params.get("EXT_ACCESSION_NUM"), ""));
					pstmt.setString(31, XHDBAdapter.isNullReplace(params.get("EVENT_TYPE"), ""));
					pstmt.setString(32, XHDBAdapter.isNullReplace(params.get("PROTOCOL_LINK_ID"), ""));
					pstmt.setString(33, XHDBAdapter.isNullReplace(params.get("ERR_MSG"), ""));

					insertCount = pstmt.executeUpdate();

					l_app_msg = " :::  Inbound Message Insert Count : " + insertCount;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					if (insertCount == 1) {

						l_err_msg = "Inbound Message Table Inserted Successfully";

						dbConn.commit();
					} else {
						l_err_msg = "Error in Inserting Inbound Message Table";
						dbConn.rollback();
					}

					if (l_debug_YN.equals("Y"))
						System.out.println(l_err_msg);

				}

				return l_err_msg;

			} catch (Exception exp) {
				l_errcd = "E";
				l_err_msg = "Error in " + exp.getMessage();
				// exp.printStackTrace(System.err);

				if (l_debug_YN.equals("Y"))
					System.out.println(l_err_msg);

				return l_err_msg;
			} finally {
				XHUtil.closeDBResources(null, pstmt, null);
				//EMDataSource.returnConnection(dbConn);
			}
		}

		public static String GenerateMessageIDMethod(String SeqenceName, Connection dbConn) {

			//Connection dbConn = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

			String query = "";
			String l_app_msg = "", l_field_value = "";

			int l_trans_id = 0;

			l_app_msg = " ::: Inside GenerateMessageIDMethod ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			try {
				//dbConn = EMDataSource.getConnection();
				query = "select " + SeqenceName + ".NEXTVAL Message_id FROM DUAL ";

				if (dbConn == null)
					return l_conn_msg;


				pstmt = dbConn.prepareStatement(query);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					l_trans_id = rs.getInt("MESSAGE_ID");
				}

				if (l_trans_id > 0) {
					l_field_value = String.valueOf(l_trans_id);
				}

			} catch (Exception e) {
				l_field_value = "Error in Generating Message ID Exception - " + e.getMessage();
			} finally {
				XHUtil.closeDBResources(rs, pstmt, null);
				//EMDataSource.returnConnection(dbConn);
			}

			return l_field_value; 
		}

		public static String PatientDetails(Map<String, String> l_req_params, String method, Connection dbConn)
				throws JsonGenerationException, JsonMappingException, IOException {

			String l_first_name = "", l_second_name = "", l_third_name = "", l_gender = "", l_date_of_birth = "",
					l_mobile_no = "", l_email_id = "";
			
			String  l_address_line_1 = "", l_address_line_2 = "", l_address_line_3 = "",
					l_address_line_4 = "";
			
			String l_country_code = "", l_postal_code = "";
			
			String l_town_code= "", l_area_code = "", l_region_code = "", l_nationality_code = "" ,
					l_identification_type_code = "",l_identification_id = "";
			
			String l_race_id = "", l_element_id = "", l_citizen_yn = "";
			
			
			//Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;

			try {
			
			l_status_desc = "";
			l_app_msg = " ::: Reading in Patient Series Group ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_element_id = "PAT_SER_GRP_CODE";

			l_pat_ser_grp = FetchStdCntrlSegMethod(l_segment_id, l_element_id,
					l_standard_code, dbConn);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Patient Serice group ::: "
						+ l_pat_ser_grp);

			String query1 = "select gen_pat_id_yn ,pat_no_ctrl from MP_PAT_SER_GRP where PAT_SER_GRP_CODE = ? ";
			// String query2 = "select site_id from sm_site_param ";
			//con = EMDataSource.getConnection();

			l_app_msg = " ::: Reading in Patient Series Group for ::: "
					+ l_pat_ser_grp;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			pstmt = dbConn.prepareStatement(query1);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Query 1 ::: " + query1);
			pstmt.setString(1, l_pat_ser_grp);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				l_pat_no_gen_yn = rset.getString("gen_pat_id_yn");
				l_pat_no_ctrl = rset.getString("pat_no_ctrl");
				if (l_debug_YN.equals("Y"))
					System.out.println("l_pat_no_gen_yn" + l_pat_no_gen_yn);
				if (l_debug_YN.equals("Y"))
					System.out.println("l_pat_no_ctrl" + l_pat_no_ctrl);
				
			}		

			
		} catch (Exception e) {

			l_status_desc = "Exception in " + l_app_msg + " - "
					+ e.getMessage();

			return l_status_desc;

		} finally {
			//EMDataSource.returnConnection(con);
			XHUtil.closeDBResources(rset, pstmt, null);
		}

		try {
			
			l_status_desc = "";

			l_app_msg = " ::: Reading in Site Param ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			String query2 = "select site_id from sm_site_param ";
			//con = EMDataSource.getConnection();

			pstmt = dbConn.prepareStatement(query2);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				l_site_id = rset.getString("site_id");
			}
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Site Id ::: " + l_site_id);

		} catch (Exception e) {

			l_status_desc = "Exception in " + l_app_msg + " - "
					+ e.getMessage();

			return l_status_desc;
		} finally {
			//EMDataSource.returnConnection(con);
			XHUtil.closeDBResources(rset, pstmt, null);
		}


		l_app_msg = " ::: Assigning Language_id and Race_id ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			l_status_desc = "";
			l_element_id = "LANG_ID";
			l_language_id = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Language Id ::: " + l_language_id);

			l_element_id = "RACE_ID";
			l_race_id = FetchStdCntrlSegMethod(l_segment_id, l_element_id,	l_standard_code, dbConn);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Race Id  ::: " + l_race_id);

			l_app_msg = " ::: Reading in Billing Group Id,Settlement Type,Biling Class code,Settlement Ind ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			/*

			l_element_id = "BLNG_GRP_ID";
			l_biling_group_id = FetchStdCntrlSegMethod(l_segment_id,
					l_element_id, l_standard_code);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Billing Group Id ::: "
						+ l_biling_group_id);
						
			*/

			l_element_id = "BLNG_CLASS_CODE";
			l_biling_class_code = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Billing class Code ::: "+ l_biling_class_code);

			l_element_id = "SETTLEMENT_IND";
			l_settlement_ind = FetchStdCntrlSegMethod(l_segment_id,	l_element_id, l_standard_code, dbConn);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: settlement Id ::: " + l_settlement_ind);

			l_element_id = "SLMT_TYPE_CODE";
			l_settlement_type = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Settlement Type ::: "+ l_settlement_type);
			
			l_element_id = "PATIENT_NAT_ID_TYPE";
			l_patient_nat_id_type = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: PATIENT_NAT_ID_TYPE_CODE ::: "+ l_patient_nat_id_type);
			
			l_element_id = "APPL_USER_ID";
			added_by_id = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: APPL User Id ::: "+ added_by_id);

		} catch (Exception e) {

			l_status_desc = "Exception in " + l_app_msg + " - "
					+ e.getMessage();

			return l_status_desc;

		}

		try { 
			
			
			l_first_name = l_req_params.get("first_name");
			l_second_name = l_req_params.get("second_name");
			l_third_name = l_req_params.get("third_name");
			l_gender = l_req_params.get("gender");
			
			l_date_of_birth = l_req_params.get("date_of_birth");
			l_mobile_no = l_req_params.get("mobile_no");
			l_nationality_code = l_req_params.get("nationality_code");
			l_postal_code = l_req_params.get("postal_code");
			
			l_address_line_1 = l_req_params.get("address_line_1");
			l_address_line_2 = l_req_params.get("address_line_2");
			l_town_code = l_req_params.get("town_code");
			l_area_code = l_req_params.get("area_code");
			l_region_code = l_req_params.get("region_code");
			
			l_country_code = l_req_params.get("country_code");
			l_email_id = l_req_params.get("email_id");
			l_identification_type_code = l_req_params.get("identification_type_code");
			l_identification_id = l_req_params.get("identification_id");
			l_facility_id = l_req_params.get("facility_id");
			Patient_id = l_req_params.get("patient_id");
			
			l_biling_group_id = l_req_params.get("biling_group_id");
			l_citizen_yn = l_req_params.get("citizen_yn");			
			
			String Patient_name = "";

			Patient_name = PatientName(l_first_name, l_second_name, l_third_name, dbConn);

			l_app_msg = " ::: Patient Name ::: " + Patient_name;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			LinkedHashMap<String, String> MP_PATIENT = new LinkedHashMap<String, String>();

			l_app_msg = " ::: Assigning Patient Details - Demographic Information ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			MP_PATIENT.put("PATIENT_NAME", Patient_name);
			MP_PATIENT.put("FIRST_NAME", l_first_name);
			MP_PATIENT.put("SECOND_NAME", l_second_name);
			MP_PATIENT.put("THIRD_NAME", l_third_name);
			MP_PATIENT.put("SEX", l_gender);
			MP_PATIENT.put("DATE_OF_BIRTH", "TO_DATE('"+l_date_of_birth+"','DD/MM/YYYY')");
			MP_PATIENT.put("CONTACT2_NO", l_mobile_no);
			MP_PATIENT.put("EMAIL_ID", l_email_id);
			MP_PATIENT.put("NATIONALITY_CODE", l_nationality_code); // l_nationality
			if (method.equalsIgnoreCase("R"))
			{
				MP_PATIENT.put("ADDED_BY_ID", added_by_id);
				MP_PATIENT.put("ADDED_DATE", "SYSDATE");
				MP_PATIENT.put("ADDED_AT_WS_NO", added_at_ws_no);
				MP_PATIENT.put("ADDED_FACILITY_ID", l_facility_id);
			}
			MP_PATIENT.put("MODIFIED_BY_ID", added_by_id);
			MP_PATIENT.put("MODIFIED_DATE", "SYSDATE");
			MP_PATIENT.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
			MP_PATIENT.put("MODIFIED_FACILITY_ID", l_facility_id);
			MP_PATIENT.put("PAT_SER_GRP_CODE", l_pat_ser_grp);
			MP_PATIENT.put("REGN_FACILITY_ID", l_facility_id);
			MP_PATIENT.put("LANGUAGE_ID", l_language_id);
			MP_PATIENT.put("RACE_CODE", l_race_id);
			MP_PATIENT.put("CITIZEN_YN", l_citizen_yn);
			MP_PATIENT.put("PREF_FACILITY_ID", l_facility_id);
			MP_PATIENT.put("REGN_DATE", "trunc(SYSDATE)"); // Registration_Date
			MP_PATIENT.put("GENERAL_ALERT", "Y");			
			
			if (l_patient_nat_id_type.equals(l_identification_type_code)){
				
				MP_PATIENT.put("NATIONAL_ID_NO", l_identification_id);
			}
			else{
				MP_PATIENT.put("OTH_ALT_ID_TYPE", l_identification_type_code);
				MP_PATIENT.put("OTH_ALT_ID_NO", l_identification_id);
			}			

			l_app_msg = " ::: Assigning Patient Details - Address Information ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

		    LinkedHashMap<String, String> MP_PAT_ADDRESSES = new LinkedHashMap<String, String>();

			MP_PAT_ADDRESSES.put("ADDR1_LINE1", l_address_line_1);
			MP_PAT_ADDRESSES.put("ADDR1_LINE2", l_address_line_2);
			MP_PAT_ADDRESSES.put("ADDR1_LINE3", l_address_line_3);
			MP_PAT_ADDRESSES.put("ADDR1_LINE4", l_address_line_4);
			MP_PAT_ADDRESSES.put("POSTAL1_CODE", l_postal_code);
			MP_PAT_ADDRESSES.put("REGION1_CODE", l_region_code); // l_state
			MP_PAT_ADDRESSES.put("RES_AREA1_CODE", l_area_code); // l_district
			MP_PAT_ADDRESSES.put("RES_TOWN1_CODE", l_town_code); // l_city
			MP_PAT_ADDRESSES.put("COUNTRY1_CODE", l_country_code);// l_country
			if (method.equalsIgnoreCase("R"))
			{
				MP_PAT_ADDRESSES.put("ADDED_BY_ID", added_by_id);
				MP_PAT_ADDRESSES.put("ADDED_DATE", "SYSDATE");
				MP_PAT_ADDRESSES.put("ADDED_AT_WS_NO", added_at_ws_no);
				MP_PAT_ADDRESSES.put("ADDED_FACILITY_ID", l_facility_id);
			}
			MP_PAT_ADDRESSES.put("MODIFIED_BY_ID", added_by_id);
			MP_PAT_ADDRESSES.put("MODIFIED_DATE", "SYSDATE");
			MP_PAT_ADDRESSES.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
			MP_PAT_ADDRESSES.put("MODIFIED_FACILITY_ID", l_facility_id);
			MP_PAT_ADDRESSES.put("ADDR1_TYPE", "RES");

			new_hash_map.put("MP_PATIENT", MP_PATIENT);	
			
			l_app_msg = " ::: Method... "+method;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);	
			
			if (method.equalsIgnoreCase("R"))
			{
				if (l_pat_no_gen_yn.equals("Y")) 
				{					
					Patient_id = generatePatientID(dbConn);				
				}
			}			
			else
			{
				Patient_id = l_req_params.get("patient_id");
				transaction_completed = true;
			}
			
			l_app_msg = " ::: Patient Id... "+Patient_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);			

			MP_PATIENT.put("PATIENT_ID", Patient_id);
			MP_PAT_ADDRESSES.put("PATIENT_ID", Patient_id);
			MP_PATIENT.put("REGION_CODE", l_region_code); // l_state
			MP_PATIENT.put("RES_AREA_CODE", l_area_code); // l_district
			MP_PATIENT.put("RES_TOWN_CODE", l_town_code); // l_city

			LinkedHashMap<String, String> MP_PAT_OTH_DTLS = new LinkedHashMap<String, String>();
			MP_PAT_OTH_DTLS.put("PATIENT_ID", Patient_id);
			MP_PAT_OTH_DTLS.put("LIVING_DEPENDENCY", "UN");
			MP_PAT_OTH_DTLS.put("LIVING_ARRANGEMENT", "U");
			if (method.equalsIgnoreCase("R"))
			{
				MP_PAT_OTH_DTLS.put("ADDED_BY_ID", added_by_id);
				MP_PAT_OTH_DTLS.put("ADDED_DATE", "SYSDATE");
				MP_PAT_OTH_DTLS.put("ADDED_AT_WS_NO", added_at_ws_no);
				MP_PAT_OTH_DTLS.put("ADDED_FACILITY_ID", l_facility_id);
			}
			MP_PAT_OTH_DTLS.put("MODIFIED_BY_ID", added_by_id);
			MP_PAT_OTH_DTLS.put("MODIFIED_DATE", "SYSDATE");
			MP_PAT_OTH_DTLS.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
			MP_PAT_OTH_DTLS.put("MODIFIED_FACILITY_ID", l_facility_id);

			LinkedHashMap<String, String> MP_PAT_REL_CONTACTS = new LinkedHashMap<String, String>();
			MP_PAT_REL_CONTACTS.put("PATIENT_ID", Patient_id);
			MP_PAT_REL_CONTACTS.put("CONTACT1_ROLE", "NEXT");
			MP_PAT_REL_CONTACTS.put("CONTACT2_ROLE", "FRST");
			if (method.equalsIgnoreCase("R"))
			{
				MP_PAT_REL_CONTACTS.put("ADDED_BY_ID", added_by_id);
				MP_PAT_REL_CONTACTS.put("ADDED_DATE", "SYSDATE");
				MP_PAT_REL_CONTACTS.put("ADDED_AT_WS_NO", added_at_ws_no);
				MP_PAT_REL_CONTACTS.put("ADDED_FACILITY_ID", l_facility_id);
			}
			MP_PAT_REL_CONTACTS.put("MODIFIED_BY_ID", added_by_id);
			MP_PAT_REL_CONTACTS.put("MODIFIED_DATE", "SYSDATE");
			MP_PAT_REL_CONTACTS.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
			MP_PAT_REL_CONTACTS.put("MODIFIED_FACILITY_ID", l_facility_id);

			LinkedHashMap<String, String> MP_PAT_DOCUMENTS = new LinkedHashMap<String, String>();
			MP_PAT_DOCUMENTS.put("PATIENT_ID", Patient_id);
			if (method.equalsIgnoreCase("R"))
			{
				MP_PAT_DOCUMENTS.put("ADDED_BY_ID", added_by_id);
				MP_PAT_DOCUMENTS.put("ADDED_DATE", "SYSDATE");
				MP_PAT_DOCUMENTS.put("ADDED_AT_WS_NO", added_at_ws_no);
				MP_PAT_DOCUMENTS.put("ADDED_FACILITY_ID", l_facility_id);
			}
			MP_PAT_DOCUMENTS.put("MODIFIED_BY_ID", added_by_id);
			MP_PAT_DOCUMENTS.put("MODIFIED_DATE", "SYSDATE");
			MP_PAT_DOCUMENTS.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
			MP_PAT_DOCUMENTS.put("MODIFIED_FACILITY_ID", l_facility_id);

			LinkedHashMap<String, String> BL_PATIENT_FIN_DTLS = new LinkedHashMap<String, String>();

			BL_PATIENT_FIN_DTLS.put("PATIENT_ID", Patient_id);
			BL_PATIENT_FIN_DTLS.put("CUR_ACCT_SEQ_NO", l_cur_acct_seq_no);
			BL_PATIENT_FIN_DTLS.put("BLNG_GRP_ID", l_biling_group_id);
			BL_PATIENT_FIN_DTLS.put("BLNG_CLASS_CODE", l_biling_class_code);
			BL_PATIENT_FIN_DTLS.put("SETTLEMENT_IND", l_settlement_ind);
			BL_PATIENT_FIN_DTLS.put("SLMT_TYPE_CODE", l_settlement_type);
			if (method.equalsIgnoreCase("R"))
			{
				BL_PATIENT_FIN_DTLS.put("ADDED_BY_ID", added_by_id);
				BL_PATIENT_FIN_DTLS.put("ADDED_DATE", "SYSDATE");
				BL_PATIENT_FIN_DTLS.put("ADDED_AT_WS_NO", added_at_ws_no);
				BL_PATIENT_FIN_DTLS.put("ADDED_FACILITY_ID", l_facility_id);
			}
			BL_PATIENT_FIN_DTLS.put("MODIFIED_BY_ID", added_by_id);
			BL_PATIENT_FIN_DTLS.put("MODIFIED_DATE", "SYSDATE");
			BL_PATIENT_FIN_DTLS.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
			BL_PATIENT_FIN_DTLS.put("MODIFIED_FACILITY_ID", l_facility_id);

			LinkedHashMap<String, String> BL_ENCOUNTER_PAYER_PRIORITY = new LinkedHashMap<String, String>();
			BL_ENCOUNTER_PAYER_PRIORITY.put("PATIENT_ID", Patient_id);
			BL_ENCOUNTER_PAYER_PRIORITY.put("OPERATING_FACILITY_ID", "KH");
			BL_ENCOUNTER_PAYER_PRIORITY.put("EPISODE_TYPE", "R");
			BL_ENCOUNTER_PAYER_PRIORITY.put("ACCT_SEQ_NO", "1");
			BL_ENCOUNTER_PAYER_PRIORITY.put("ACCT_SEQ_EFF_FROM_DATE", "SYSDATE");
			BL_ENCOUNTER_PAYER_PRIORITY.put("ENC_REGN_DATE_TIME", "SYSDATE");
			BL_ENCOUNTER_PAYER_PRIORITY.put("BLNG_GRP_ID", l_biling_group_id);
			BL_ENCOUNTER_PAYER_PRIORITY.put("SETTLEMENT_IND", l_settlement_ind);
			if (method.equalsIgnoreCase("R"))
			{
				BL_ENCOUNTER_PAYER_PRIORITY.put("ADDED_BY_ID", added_by_id);
				BL_ENCOUNTER_PAYER_PRIORITY.put("ADDED_DATE", "SYSDATE");
				BL_ENCOUNTER_PAYER_PRIORITY.put("ADDED_AT_WS_NO", added_at_ws_no);
				BL_ENCOUNTER_PAYER_PRIORITY.put("ADDED_FACILITY_ID", l_facility_id);
			}
			BL_ENCOUNTER_PAYER_PRIORITY.put("MODIFIED_BY_ID", added_by_id);
			BL_ENCOUNTER_PAYER_PRIORITY.put("MODIFIED_DATE", "SYSDATE");
			BL_ENCOUNTER_PAYER_PRIORITY.put("MODIFIED_AT_WS_NO",
					modified_at_ws_no);
			BL_ENCOUNTER_PAYER_PRIORITY.put("MODIFIED_FACILITY_ID",
					l_facility_id);
			BL_ENCOUNTER_PAYER_PRIORITY.put("MAND_ADDL_INFO_RECORDED_YN", "N");
			BL_ENCOUNTER_PAYER_PRIORITY.put("PRE_INV_YN", "N");
			BL_ENCOUNTER_PAYER_PRIORITY.put("PRE_INV_FIN_YN", "N");
			BL_ENCOUNTER_PAYER_PRIORITY.put("INT_RESPONSE_CODE", "0");
			BL_ENCOUNTER_PAYER_PRIORITY.put("INT_VALIDITY_TYPE", "0");

			new_hash_map.put("MP_PAT_ADDRESSES", MP_PAT_ADDRESSES);
			new_hash_map.put("MP_PAT_OTH_DTLS", MP_PAT_OTH_DTLS);
			new_hash_map.put("MP_PAT_REL_CONTACTS", MP_PAT_REL_CONTACTS);
			new_hash_map.put("MP_PAT_DOCUMENTS", MP_PAT_DOCUMENTS);
			new_hash_map.put("BL_PATIENT_FIN_DTLS", BL_PATIENT_FIN_DTLS);
			new_hash_map.put("BL_ENCOUNTER_PAYER_PRIORITY",
					BL_ENCOUNTER_PAYER_PRIORITY);
			if (l_debug_YN.equals("Y"))
				System.out.println("NewHashMap" + new_hash_map);
			
			if (method.equalsIgnoreCase("R"))
			{
				l_status_desc = InserData(new_hash_map, dbConn);
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: Insert data completed ::: ");
				
				if (l_status_desc.length()>0)
					Patient_id = l_status_desc;
			}
			
			if (method.equalsIgnoreCase("P"))
			{
				l_status_desc = UpdateData(new_hash_map, dbConn);
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: Data updation completed ::: ");
				
				if (l_status_desc.length()>0)
					Patient_id = l_status_desc;
			}

			System.out.println(" ::: Patient Id ::: " + Patient_id);

		} catch (Exception e) {

			l_status_desc = "Exception in " + l_app_msg + " - "
					+ e.getMessage();

			return l_status_desc;
		}

		return Patient_id;

	}

	public static String InserData(
			HashMap<String, HashMap<String, String>> new_hash_map, Connection dbConn) {
		//Connection con = null;
		PreparedStatement pstmt = null;
		Set<String> tableKeys = new_hash_map.keySet();
		String insertStr = "";
		int count = 0;
		boolean insertFlag = false;
		String tableName = "";

		try {
			
			l_status_desc = "";
			l_app_msg = " ::: Inside Insert Data ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			//con = EMDataSource.getConnection();
			for(String tableKey: tableKeys){
				
				insertFlag = false;

				LinkedHashMap<String, String> tHashMap = (LinkedHashMap<String, String>) new_hash_map
						.get(tableKey);

				Set<String> columnKeys = tHashMap.keySet();
				
				keyStr = "";
				valueStr = "";
				
				tableName = tableKey;
				
				for(String columnKey: columnKeys){
					keyStr = keyStr + columnKey + ",";    
					
					l_app_msg = " ::: Reading  Columnkey ::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					if (tHashMap.get(columnKey).contains("DATE"))
						valueStr = valueStr + "" + tHashMap.get(columnKey) + ""
								+ ",";
					else
						valueStr = valueStr + "\'" + tHashMap.get(columnKey)
								+ "\'" + ",";

				}

				keyStr = keyStr.substring(0,keyStr.length() -1 );
				valueStr = valueStr.substring(0,valueStr.length() -1 );
				
				l_app_msg = " ::: Inserting the Values ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				insertStr = " Insert into " + tableKey + " (" + keyStr
						+ ") VALUES (" + valueStr + ") ";
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: Insert Query ::: "
							+ insertStr.toString());

				if (pstmt != null)
					pstmt.close();
				pstmt = dbConn.prepareStatement(insertStr.toString());
				count = pstmt.executeUpdate();

				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: Count ::: " + count);
				
				if (count > 0){
					insertFlag = true;
				}
				
				/*

				if (count == 1) {
					con.commit();
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Inserted Success ::: ");
				} else {
					con.rollback();
				}
				
				*/
				keyStr = "";
				valueStr = "";
			}
			
			if (insertFlag) {
				dbConn.commit();
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: Inserted Success ::: ");
			} else {
				dbConn.rollback();
			}
		} catch (Exception e) {
			l_status = "0";
			l_status_desc = "Exception in saving the data in " + tableName + ", "+ l_app_msg + " - " + e.getMessage();
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Status Desc ::: " + l_status_desc);
			
			try{
				dbConn.rollback();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			

		} finally {
			//EMDataSource.returnConnection(con);
			XHUtil.closeDBResources(null, pstmt, null);
		}
		
		return l_status_desc;		
	
	}
	
	public static String UpdateData(
			HashMap<String, HashMap<String, String>> new_hash_map, Connection dbConn) {
		//Connection con = null;
		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;
		Set<String> tableKeys = new_hash_map.keySet();
		String insertStr = "";
		int count = 0;
		boolean insertFlag = false;
		String tableName = "";
		
		String l_Patient_id = "";

		try {
			
			l_status_desc = "";
			l_app_msg = " ::: Inside Insert Data ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			//con = EMDataSource.getConnection();			
						
			cstmt = dbConn.prepareCall("{call MP_AUDIT_FUNCTION.ASSIGN_VALUE('CHG_PAT_DTLS')}");			
			cstmt.execute();			
			cstmt.close();
			
			for(String tableKey: tableKeys){
				
				insertFlag = false;

				LinkedHashMap<String, String> tHashMap = (LinkedHashMap<String, String>) new_hash_map
						.get(tableKey);

				Set<String> columnKeys = tHashMap.keySet();
				
				keyStr = "";
				valueStr = "";
				
				tableName = tableKey;
				
				for(String columnKey: columnKeys){
					//keyStr = keyStr + columnKey + "=" + tHashMap.get(columnKey) +", ";    
					
					l_app_msg = " ::: Reading  Columnkey ::: "+columnKey;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					if (tHashMap.get(columnKey).contains("DATE"))
						keyStr = keyStr + columnKey + "="  + tHashMap.get(columnKey) + "" + ",";
					else
						keyStr = keyStr + columnKey + "="  + "\'" + tHashMap.get(columnKey) + "\'" + ",";
					
					if (columnKey.equalsIgnoreCase("PATIENT_ID"))
						l_Patient_id = tHashMap.get(columnKey);

				}
				
				l_app_msg = " ::: Updating the Values for the patient ::: "+l_Patient_id;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				keyStr = keyStr.substring(0,keyStr.length() -1 );				
				
				l_app_msg = " ::: Updating the Values for the patient ::: "+l_Patient_id;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				insertStr = " Update " + tableKey + " set " + keyStr + " where patient_id = '"+l_Patient_id+"'";
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: Update Query ::: "	+ insertStr.toString());

				if (pstmt != null)
					pstmt.close();
				pstmt = dbConn.prepareStatement(insertStr.toString());
				count = pstmt.executeUpdate();

				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: Count ::: " + count);
				
				if (count > 0){
					insertFlag = true;
				}			

				keyStr = "";
				valueStr = "";
			}
			
			if (insertFlag) {
				dbConn.commit();
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: Successfully Updated ::: ");
			} else {
				dbConn.rollback();
			}
		} catch (Exception e) {
			l_status = "0";
			l_status_desc = "Exception in saving the data in " + tableName + ", "+ l_app_msg + " - " + e.getMessage();
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Status Desc ::: " + l_status_desc);
			
			try{
				dbConn.rollback();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			

		} finally {
			//EMDataSource.returnConnection(con);
			XHUtil.closeDBResources(null, pstmt, null);
			XHUtil.closeDBResources(null, cstmt, null);
		}
		
		return l_status_desc;		
	
	}

	public static String generatePatientID(Connection dbConn) {
		l_app_msg = " ::: Inside GeneratePatientID ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		String gen_patient_id = "";
		String p_err_msg	= "";
		CallableStatement cs = null;

		//Connection con = null;
		try {
			
			l_status_desc = "";

			
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Pat No Ctrl ::: " + l_pat_no_ctrl);
	
			//con = EMDataSource.getConnection();
	
			cs = dbConn.prepareCall("{call generate_patient_id(?,?,?,?,?,?,?) }");
	
			cs.setString(1, l_pat_ser_grp);
			if (l_pat_no_ctrl.equals("U")) 
			{
				cs.setString(2, l_facility_id);
			}
			else
			{
				cs.setString(2, l_site_id);
			}
			cs.setString(3, "1");
			cs.setString(4, "0");
			cs.setString(5, new_hash_map.get("MP_PATIENT").get("SEX"));
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.VARCHAR);			

			cs.execute();
			gen_patient_id = cs.getString(6);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Generated Patient Id ::: "
						+ gen_patient_id);
			p_err_msg = cs.getString(7);

			if (gen_patient_id == null) {
				gen_patient_id = "";
			}
			if (p_err_msg == null) {
				p_err_msg = "";
			}

			if (!p_err_msg.equals("")) {
				transaction_completed = false;
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: Error Message ::: " + p_err_msg);
			} else {
				transaction_completed = true;
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: Error Message ::: " + p_err_msg);
			}
		}

		catch (Exception e) {
			transaction_completed = false;
			l_status = "0";
			l_status_desc = "Exception in " + l_app_msg + " - "
					+ e.getMessage();

			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Status Desc ::: " + l_status_desc);
			
			e.printStackTrace();
		} finally {
			//EMDataSource.returnConnection(con);
			XHUtil.closeDBResources(null, cs, null);
		}

		return gen_patient_id;

	}

	public static String FetchStdCntrlSegMethod(String segmentID,
			String elementId, String standardCode, Connection dbConn) {

		//Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		l_app_msg = " ::: Inside FetchStdCntrlSegMethod ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: Segment ID ::: " + segmentID + " ::: Element ID ::: "
				+ elementId + " ::: Standard Code ::: " + standardCode;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: Retrieving ::: " + elementId + " ::: Value ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			//dbConn = EMDataSource.getConnection();
			if (l_debug_YN.equals("Y"))
				System.out.println(dbConn.toString());
			query = "SELECT NVL(DEFAULT_VALUE,'X') DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG "
					+ " WHERE SEGMENT_ID = ? "
					+ " AND STANDARD_CODE = ? "
					+ " AND ELEMENT_ID = ? ";

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, segmentID);
			pstmt.setString(2, standardCode);
			pstmt.setString(3, elementId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				l_field_value = rs.getString("DEFAULT_VALUE");
			}
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Fetch control l_field_value ::: "
						+ l_field_value);

		} catch (Exception e) {
			l_field_value = "Error in " + l_app_msg + " : " + e.getMessage();
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Field Value ::: " + l_field_value);
			e.printStackTrace();
		} finally {
			//EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		return l_field_value;
	}

	public static String PatientName(String first_name,
			String second_name, String third_name, Connection dbConn) {
		
		//Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String logic = "";

		String query = "";
		l_app_msg = " ::: Inside Patient Name ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = "::: First Name ::: " + first_name + " ::: Second Name ::: "
				+ second_name + " ::: Third Name ::: " + third_name;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		
		
		try {
			
			l_app_msg = ":::::::Fetching derivation logic:::::::::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg); 
			
			//dbConn = EMDataSource.getConnection();
			if (l_debug_YN.equals("Y"))
				System.out.println(dbConn.toString());
			query = "SELECT NAME_DERVN_LOGIC FROM MP_PARAM ";

			pstmt = dbConn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				logic = rs.getString("NAME_DERVN_LOGIC");
			}
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Derivation Logic ::: "
						+ logic);

		} catch (Exception e) {
			logic = "Error in " + l_app_msg + " : " + e.getMessage();
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Field Value ::: " + logic);
			e.printStackTrace();
		} finally {
			//EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}

		// String logic = "2N+< >+3N+<,(>+1N+<)>";
		String derivedName = "";
		derivedName = "";
		int j = 0;
		String[] arr = new String[10];
		arr = logic.split("\\+");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(" ::: Array ::: " + arr[i]);

		}

		for (j = 0; j < arr.length; j++) {

			if (arr[j].equals("1N") && first_name != null) {
				if (first_name != " ") {
					derivedName = derivedName + first_name;
					System.out.println(" ::: first_name derivedName :::"
							+ derivedName);
				}

			} else if (arr[j].equals("2N") && second_name != null) {
				if (second_name != " ")
					derivedName = derivedName + second_name;
				System.out.println(" ::: second_name derivedName ::: "
						+ derivedName);
			} else if (arr[j].equals("3N") && third_name != null) {
				if (third_name != " ") {
					derivedName = derivedName + third_name;
					System.out.println(" ::: third_name derivedName ::: "
							+ derivedName);
				}
			}


			else {
				if (arr[j] != "1N" && arr[j] != "2N" && arr[j] != "3N"
						&& arr[j] != "FN") {
					int arLen = arr[j].length();

					System.out.println("arLen.." + arLen);

					String tempVal = arr[j].substring(1, arLen - 1);

					if (derivedName == "")
						tempVal = "";

					derivedName = derivedName + tempVal;

				}

			}
		}
		return derivedName;
	}


}
