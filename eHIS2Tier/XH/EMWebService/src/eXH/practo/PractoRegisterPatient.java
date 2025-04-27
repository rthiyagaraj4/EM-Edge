package eXH.practo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

import eXH.util.EMDataSource;
import eXH.util.XHJSONUtil;
import eXH.util.XHUtil;

public class PractoRegisterPatient {
	
	public static String l_debug_YN = "N";

	public String l_errcd = "S", l_field_separator = "$!^", l_searchcd = "S";
	public String l_errmsg = "";
	public String l_ack_text = "";
	public String l_update_response_str = "";
	public String l_eventType = "OA30";

	public static String l_conn_msg = "Error - Unable to connect to the Data base, Kindly contact the System Administrator";
	

	@SuppressWarnings("static-access")
	public String processRequest(String actionKey) {
		
		String l_app_msg = "";
		String l_response_err_json = "", l_facility_id = "";
		String l_in_JSON = "", l_response_str = "", l_message_id = "", l_application_id = "", l_protocol_link_id = "";
		String l_status = "", l_status_desc = "";
		String l_request_date_time ="", l_patient_prefix = "",  l_gender ="", l_date_of_birth = "";
		String  l_mobile_no = "", l_nationality = "", l_address_line_1 = "", l_address_line_2 = "", l_address_line_3 = "", l_address_line_4 = "", l_city = "", l_district = "", l_state = "", l_postal_code = "", l_country = "", l_email_id = "";
		
		String l_city_code = "", l_district_code = "", l_state_code = "", l_country_code = "", l_nationality_code = "";
		
		String l_first_name = "", l_second_name = "", l_surname = "", l_patient_id = "";
		String l_country_validate = "", l_postal_code_validate = "";

		List<Map<String,String>> l_searchPatientDetails = new ArrayList<Map<String,String>>();
		List<Map<String,String>> l_patient_resp = new ArrayList<Map<String,String>>();
		@SuppressWarnings("rawtypes")
		ArrayList l_external_app_details = null;
		Map<String, String> params = new HashMap<String, String>();
		Map<String, Object> l_response_json = new HashMap<String, Object>();
		ObjectMapper objMapper = new ObjectMapper();
		Map<String,String> l_req_params = new HashMap<String, String>();
		PractoInboundTransaction practoInboundTransaction = new PractoInboundTransaction();

		String l_request_ref_no = "", l_request_type = "", l_responseJsonString = "";
		
		StringBuffer l_error = null;
		
		try
		{

			l_debug_YN = XHUtil.l_debug_YN;
			
			l_app_msg = " ************ Practo Register Patient Traction started ************ ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_error = new StringBuffer("Unable to Register the Patient - Information Missing");
	
			l_app_msg = " ::: Inside Practo Register Patient Details :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);	
		
			l_app_msg = " ::: Generating Message ID ::: ";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			
			l_message_id = practoInboundTransaction.GenerateMessageIDMethod("XH_IB_MESSAGE_ID_SEQ");	
			
			if (l_message_id.indexOf("Error") >= 0) {
				l_errmsg = "Error in Message ID Generation - "+l_message_id;
				
				l_response_err_json = " { " + " \"status\":0, " + " \"status_desc\" : \" " + l_errmsg + " \"  "
						+ " } ";
				
				return "200#" + l_response_err_json + "#";
				
			}
			
			l_app_msg = " ::: Generated Message Id ::: "+l_message_id+" ::: Error Code : "+l_errcd+" ::: Error Message : "+l_errmsg;
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			if (l_errcd.equals("S"))				
			{			
				l_app_msg = " ::: Fetching External Application Details : ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				l_external_app_details = practoInboundTransaction.FetchExternalAppDetails("PRACTOINB");			
				
				if (l_external_app_details.isEmpty()) 
				{
					l_errcd = "E";
					l_errmsg = "Error in Fetching External Application Details No Data Available";
					l_response_err_json = " { " + " \"status\":0, " + " \"status_desc\" : \" " + l_errmsg + " \"  "
							+ " } ";
					return   "200#"+l_response_err_json+"#";
					
				}
				
				l_application_id = (String) l_external_app_details.get(0);
				
				if (l_application_id.indexOf("Error") >= 0) {
					l_errmsg = "Fetching External Application Details - "+l_application_id;
					l_response_err_json = " { " + " \"status\":0, " + " \"status_desc\" : \" " + l_errmsg + " \"  "
							+ " } ";
	
					return "200#" + l_response_err_json + "#";
					
				}
				
				l_app_msg = " ::: Message ID : "+l_message_id+" ::: External Application : " + l_external_app_details+" ::: Error Code : "+l_errcd+" ::: Error Message : "+l_errmsg;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
			
			}
			
			if (l_errcd.equals("S"))
			{
				l_application_id = (String) l_external_app_details.get(0);
				l_protocol_link_id = (String) l_external_app_details.get(1);
				l_facility_id = (String) l_external_app_details.get(2);			
			}
			
			params.put("MESSAGE_ID", l_message_id);
			params.put("APPLICATION_ID", l_application_id);
			params.put("FACILITY_ID", l_facility_id);
			params.put("PROTOCOL_LINK_ID", l_protocol_link_id);
			params.put("EVENT_TYPE", l_eventType);		
			
			l_app_msg = " ::: Action Key :::"+actionKey;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);	
			
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
			
			l_app_msg = " ::: Getting Patient Prefix from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	
			l_patient_prefix = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "patient_prefix");
			if (l_patient_prefix.indexOf("Error") >= 0 || l_patient_prefix.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Patient Prefix");
			}
			l_app_msg = " ::: Patient Prefix : " + l_patient_prefix;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("patient_prefix", l_patient_prefix);
			
			l_app_msg = " ::: Getting Request First name from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_first_name = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","first_name");
			l_first_name = l_first_name.trim();
			if (l_first_name.indexOf("Error") >= 0 || l_first_name.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Patient First Name");
			}
			l_app_msg = " ::: First Name : " + l_first_name;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("first_name", l_first_name);
			
			l_app_msg = " ::: Getting Request Second name from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_second_name = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","second_name");
			l_second_name = l_second_name.trim();
			l_app_msg = " ::: Second Name : " + l_second_name;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("second_name", l_second_name);		
			
			l_app_msg = " ::: Getting Request Family name from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_surname = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","surname");
			l_surname = l_surname.trim();
			if (l_surname.indexOf("Error") >= 0  || l_surname.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Patient Surname");
			}
			l_app_msg = " ::: Family Name : " + l_surname;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("surname", l_surname);
			
			l_app_msg = " ::: Getting Request Gender from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_gender = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","gender");
			l_gender = l_gender.trim();
			
			if (l_gender.indexOf("Error") >= 0 || l_gender.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Gender");
			}
			
			if (!l_gender.equals("M") && !l_gender.equals("F") && !l_gender.equals("U")) {
				l_errcd = "E";
				l_error.append(" - Gender "+l_gender);				
			}
			l_app_msg = " ::: Gender : " + l_gender;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("gender", l_gender);
			
			
			l_app_msg = " ::: Getting Request Date of Birth from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_date_of_birth = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","date_of_birth");
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
			
			l_mobile_no = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","mobile_no");
			l_mobile_no = l_mobile_no.trim();
			if (l_mobile_no.indexOf("Error") >= 0 || l_mobile_no.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Mobile Number");
			}
			l_app_msg = " ::: Mobile Number : " + l_mobile_no;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("mobile_no", l_mobile_no);
			
			l_app_msg = " ::: Getting Request Nationality from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_nationality_code = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","nationality_code");
			l_nationality_code = l_nationality_code.trim();
			l_app_msg = " ::: Nationality Code as read from JSON... "+l_nationality_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			if (l_nationality_code.indexOf("Error") >= 0 || l_nationality_code.trim().equals("")) {
				l_nationality_code = "";
			}
			l_app_msg = " ::: Nationality Code: " + l_nationality_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_nationality = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","nationality");
			l_nationality = l_nationality.trim();
			if (l_nationality.indexOf("Error") >= 0 || l_nationality.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Nationality");
			}
			l_app_msg = " ::: Nationality : " + l_nationality;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("nationality", l_nationality);
			
			l_app_msg = " ::: Getting Request Address Line 1 from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_address_line_1 = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","address_line_1");
			/*
			if (l_address_line_1.indexOf("Error") >= 0 || l_address_line_1.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Address Line 1");
			}
			*/
			l_app_msg = " ::: Address Line 1 : " + l_address_line_1;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("address_line_1", l_address_line_1);
			
			l_app_msg = " ::: Getting Request Address Line 2 from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_address_line_2 = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","address_line_2");
			/*
			if (l_address_line_2.indexOf("Error") >= 0 || l_address_line_2.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Address Line 2");
			}
			*/
			l_app_msg = " ::: Address Line 2 : " + l_address_line_2;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("address_line_2", l_address_line_2);
			
			l_app_msg = " ::: Getting Request Address Line 3 from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_address_line_3 = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","address_line_3");		
			l_app_msg = " ::: Address Line 3 : " + l_address_line_3;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_req_params.put("address_line_3", l_address_line_3);
			
			l_app_msg = " ::: Getting Request Address Line 4 from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_address_line_4 = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","address_line_4");		
			l_app_msg = " ::: Address Line 4 : " + l_address_line_4;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_req_params.put("address_line_4", l_address_line_4);
			
			l_app_msg = " ::: Getting Request City from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_city_code = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","city_code");
			l_city_code = l_city_code.trim();
			if (l_city_code.indexOf("Error") >= 0 || l_city_code.trim().equals("")) {
				l_city_code = "";
			}
			l_app_msg = " ::: City Code: " + l_city_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_city = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","city");
			l_city = l_city.trim();
			l_app_msg = " ::: City : " + l_city;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			if (l_city_code.length()>0)
			{
				l_req_params.put("city_code", l_city_code);
				l_req_params.put("city", "");
			}
			else
			{
				l_req_params.put("city_code", "");
				l_req_params.put("city", l_city);
			}
			
			l_app_msg = " ::: City Code : " + l_city_code + " ::: City : "+l_city;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
						
			l_app_msg = " ::: Getting Request District from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_district_code = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","district_code");
			l_district_code = l_district_code.trim();
			if (l_district_code.indexOf("Error") >= 0 || l_district_code.trim().equals("")) {
				l_district_code = "";
			}
			l_app_msg = " ::: District Code: " + l_district_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_district = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","district");
			l_district = l_district.trim();
			l_app_msg = " ::: District : " + l_district;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			if (l_district_code.length()>0)
			{
				l_req_params.put("district_code", l_district_code);
				l_req_params.put("district", "");
			}
			else
			{
				l_req_params.put("district_code", "");
				l_req_params.put("district", l_district);
			}
			
			l_app_msg = " ::: District Code : " + l_district_code + " ::: District : "+l_district;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_app_msg = " ::: Getting Request State from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_state_code = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","state_code");
			l_state_code = l_state_code.trim();
			if (l_state_code.indexOf("Error") >= 0 || l_state_code.trim().equals("")) {
				l_state_code = "";
			}
			
			l_app_msg = " ::: State Code: " + l_state_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_state = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","state");	
			l_state = l_state.trim();
			l_app_msg = " ::: State : " + l_state;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			if (l_state_code.length()>0)
			{
				l_req_params.put("state_code", l_state_code);
				l_req_params.put("state", "");
			}
			else
			{
				l_req_params.put("state_code", "");
				l_req_params.put("state", l_state);
			}
			
			l_app_msg = " ::: State Code : " + l_state_code + " ::: State : "+l_state;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_app_msg = " ::: Getting Request Postal Code from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_postal_code = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","postal_code");
			l_postal_code = l_postal_code.trim();
			if (l_postal_code.indexOf("Error") >= 0 || l_postal_code.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Postal Code");
			}
			l_app_msg = " ::: Postal Code : " + l_postal_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("postal_code", l_postal_code);
			
			l_app_msg = " ::: Getting Request Country from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_country_code = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","country_code");
			l_country_code = l_country_code.trim();
			if (l_country_code.indexOf("Error") >= 0 || l_country_code.trim().equals("")) {
				l_country_code = "";
			}
			l_app_msg = " ::: Country Code: " + l_country_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_country = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","country");
			l_country = l_country.trim();
			if (l_country.indexOf("Error") >= 0 || l_country.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Country");
			}
			l_app_msg = " ::: Country : " + l_country;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			if (l_country_code.length()>0)
			{
				l_req_params.put("country_code", l_country_code);
				l_req_params.put("country", "");
			}
			else
			{
				l_req_params.put("country_code", "");
				l_req_params.put("country", l_country);
			}
			
			l_app_msg = " ::: Country Code : " + l_country_code + " ::: Country : "+l_country;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			
			l_app_msg = " ::: Getting Request Email ID from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_email_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","email_id");
			if (l_email_id.indexOf("Error") >= 0 || l_email_id.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Email_id");
			}
			l_app_msg = " ::: Email Id : " + l_email_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("email_id", l_email_id);
			
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
			
			String l_code_desc_flag = "0";
			
			if(l_errcd.equals("S")){
				
				l_app_msg = " ::: Validating Country  ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				if (l_country_code.length()>0)
				{
					l_code_desc_flag = "0";
					l_country_validate = validateCountry(l_country_code, l_code_desc_flag);
				}
				else
				{
					l_code_desc_flag = "1";
					l_country_validate = validateCountry(l_country, l_code_desc_flag);
				}				
				
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
				
				l_postal_code_validate = validatePostalCode(l_postal_code);
				
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
				
				String l_nationality_validate = validatenationalityCode(l_nationality);
				
				l_app_msg = " ::: Nationality  ::: "+l_nationality_validate;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				if(l_nationality_validate.equals("")){
					l_errcd = "E";
					l_error.append(" - Nationality does not match with the EM Master Data ");			
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
				
				l_searchPatientDetails = searchPatient(l_first_name, l_second_name, l_surname, l_gender, l_date_of_birth);
				
				if(l_searchPatientDetails.isEmpty()){
					l_searchcd = "E";
					l_app_msg = " ::: Search patient data not matched ::: "+l_searchPatientDetails;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
				}
				
				params.put("ERR_MSG", "");
				
				if(l_searchcd.equals("S")){			
					
					l_response_json.put("patient_data", l_searchPatientDetails);			
					
					l_app_msg = " ::: Inserting Request into Message Table while searching patient data check ::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					
					l_status = "1";
					l_status_desc = "Patient data already exists";
					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);
					l_response_json.put("patient_data", l_searchPatientDetails);
					
					l_responseJsonString = objMapper.writeValueAsString(l_response_json);
					
					params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
					params.put("ERR_MSG", l_error.toString());
					
					l_response_str = practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, "");
					l_app_msg = " ::: Message Load Method  ::: "+ l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);				
				
					return "200#"+ l_responseJsonString +"#";				
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
				
				l_patient_id = PractoPatient.PatientDetails(actionKey);
				
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
				
			    l_patient_resp = FetchPatient(l_patient_id);
			    
			}
			l_app_msg = " ::: FetchPatient Response ::: "+l_patient_resp;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			if(l_errcd.equals("S")){
				
				l_status = "1";
				l_status_desc = "Patient data successfully registered";
				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				l_response_json.put("patient_data", l_patient_resp);
				
				l_responseJsonString = objMapper.writeValueAsString(l_response_json);
				
				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				params.put("ERR_MSG", l_error.toString());
				
				l_response_str = practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, "");
				l_app_msg = " ::: Message Load Method  ::: "+ l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);		
						
				l_app_msg = " ************ Practo Register Patient Traction Ended ************ ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				return "200#"+ l_responseJsonString +"#";
			}				
		}catch(Exception e){
			
			e.printStackTrace();
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^ Exception Occurred " + e.getMessage();
			
			l_app_msg = " ************ Practo Register Patient Traction Ended ************ ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
		}	
		
		return "200#"+ l_response_err_json +"#";
	}
	public static List<Map<String, String>> FetchPatient(String patient_id)
	{
		Connection dbConn = null;
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
			dbConn = EMDataSource.getConnection();
			query = "select patient_name from mp_patient where patient_id = ? ";
			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, patient_id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				record.put("patient_id", patient_id);
				record.put("patient_name", rs.getString("PATIENT_NAME"));
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
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		
		return searchPatientDtls;
		
	}

	public static List<Map<String, String>> searchPatient(String first_name, String second_name, String family_name, String gender, String dob) 
	{
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Map<String, String> record = null;
		ArrayList<Map<String, String>> searchPatient = new ArrayList<Map<String, String>>();
		String query = "";
		StringBuffer whereClause = new StringBuffer();
		StringBuffer whereCond = new StringBuffer();
		String l_app_msg = "";
		
		l_app_msg = " ::: Inside searchPatient ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		
		l_app_msg = " ::: First Name ::: "+first_name+" ::: Second Name ::: "+second_name+" ::: Family Name ::: "+family_name+" ::: Gender ::: "+gender+" ::: Date of Birth ::: "+dob;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {		
			
			
			dbConn = EMDataSource.getConnection();
			query = "select patient_id, patient_name from mp_patient " ;
			whereClause.append(" where ");
			
			if (first_name.length()>0) 
				whereCond.append(" lower(first_name) = lower(?) ");
			
			if ((second_name.length()>0) && (whereCond.length()>0))
				whereCond.append(" AND lower(SECOND_NAME) = lower(?) ");
			else if (second_name.length()>0)
				whereCond.append(" lower(SECOND_NAME) = lower(?) ");
			
			if ((family_name.length()>0) && (whereCond.length()>0))
				whereCond.append(" AND lower(family_name) = lower(?) ");
			else if (family_name.length()>0)
				whereCond.append(" lower(family_name) = lower(?) ");
			
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
				pstmt.setString(2, family_name);				

			if (second_name.length()>0 && family_name.length()>0) 
				pstmt.setString(3, family_name);

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
				record.put("patient_name", rs.getString("PATIENT_NAME"));
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
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}

		return searchPatient;
	}
	
	// Validating Mandatory City
	public static String validateCity(String l_city, String code_desc_flag){
		String l_resp_fields = "";
		
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "";
		
		l_app_msg = " ::: Inside validateCity ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		
		try {
			dbConn = EMDataSource.getConnection();
			query = "select long_desc from MP_RES_TOWN ";
			
			if ("1".equalsIgnoreCase(code_desc_flag))
				query = query + "where trim(lower(LONG_DESC)) = lower(?)";
			
			if ("0".equalsIgnoreCase(code_desc_flag))
				query = query + "where RES_TOWN_CODE = ?";


			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, l_city);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				l_resp_fields = rs.getString("long_desc");

			}
		}catch (Exception e) {
			l_resp_fields = "Error in Validate City Exception - " + e.getMessage();
		} finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		
		return l_resp_fields;
	}
	
	// Validating Mandatory District
		public static String validateDistrict(String l_district, String code_desc_flag){
			String l_resp_fields = "";
			
			Connection dbConn = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

			String query = "";
			String l_app_msg = "";
			
			l_app_msg = " ::: Inside validateDistrict ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			try {
				dbConn = EMDataSource.getConnection();
				query = "select long_desc from MP_RES_AREA ";
				
				if ("1".equalsIgnoreCase(code_desc_flag))
					query = query + "where trim(lower(LONG_DESC)) = lower(?)";
				
				if ("0".equalsIgnoreCase(code_desc_flag))
					query = query + "where RES_AREA_CODE = ?";


				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, l_district);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					l_resp_fields = rs.getString("long_desc");

				}
			}catch (Exception e) {
				l_resp_fields = "Error in Validate District Exception - " + e.getMessage();
			} finally {
				XHUtil.closeDBResources(rs, pstmt, null);
				EMDataSource.returnConnection(dbConn);
			}
			
			return l_resp_fields;
		}
		
		
		// Validate State
		public static String validateState(String l_state, String code_desc_flag){
			String l_resp_fields = "";
			
			Connection dbConn = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

			String query = "";
			String l_app_msg = "";
			
			l_app_msg = " ::: Inside validateState ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			try {
				dbConn = EMDataSource.getConnection();
				query = "select long_desc from MP_REGION ";
				
				if ("1".equalsIgnoreCase(code_desc_flag))
					query = query + "where trim(lower(LONG_DESC)) = lower(?)";
				
				if ("0".equalsIgnoreCase(code_desc_flag))
					query = query + "where REGION_CODE = ?";

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
				EMDataSource.returnConnection(dbConn);
			}
			
			return l_resp_fields;
		}
		
		// Validate Country
		public static String validateCountry(String l_country, String code_desc_flag){
			String l_resp_fields = "";
			
			Connection dbConn = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

			String query = "";
			String l_app_msg = "";
			
			l_app_msg = " ::: Inside validateCountry ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			try {
				dbConn = EMDataSource.getConnection();
				query = "select long_name from MP_COUNTRY ";
				
				l_app_msg = " ::: Code_Desc_Flag : "+code_desc_flag+" ::: Country : "+l_country;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				if ("1".equalsIgnoreCase(code_desc_flag))
					query = query + "where trim(lower(long_name)) = lower(?)";
				
				if ("0".equalsIgnoreCase(code_desc_flag))
					query = query + "where country_code = ?";


				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, l_country);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					l_resp_fields = rs.getString("long_name");
				}
			}catch (Exception e) {
				l_resp_fields = "Error in Validate Country Exception - " + e.getMessage();
			} finally {
				XHUtil.closeDBResources(rs, pstmt, null);
				EMDataSource.returnConnection(dbConn);
			}
			
			return l_resp_fields;
		}
		
		// Validate Postal Code
		public static String validatePostalCode(String postal_code){
			String l_resp_fields = "";
			
			Connection dbConn = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			String query = "";
			String l_app_msg = "";
			
			l_app_msg = " ::: Inside validatePostalCode ::: "+" ::: Postal code ::: "+postal_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			try {
				dbConn = EMDataSource.getConnection();
				query = "select long_desc from MP_POSTAL_CODE where trim(lower(long_desc)) = lower(?)";
				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, postal_code);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					l_resp_fields = rs.getString("long_desc");
				}
			}catch (Exception e) {
				l_resp_fields = "Error in Validate Postal Exception - " + e.getMessage();
			} finally {
				XHUtil.closeDBResources(rs, pstmt, null);
				EMDataSource.returnConnection(dbConn);
			}
			
			return l_resp_fields;
			
		}
		
		// Validate Nationality
		public static String validatenationalityCode(String nationality_code){
			String l_resp_fields = "";
			
			Connection dbConn = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			String query = "";
			String l_app_msg = "";
			
			l_app_msg = " ::: Inside validatenationalityCode ::: "+" ::: Nationality code ::: "+nationality_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			try {
				dbConn = EMDataSource.getConnection();
				query = "Select LONG_DESC from mp_country where trim(lower(LONG_DESC)) =  trim(lower(?))";
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
				EMDataSource.returnConnection(dbConn);
			}
			
			return l_resp_fields;
			
		}
		
		public  String sendErrorResponse(String actionKey, String error , String request_ref_no, Map<String, String> params)
		{
			String l_status = "", l_status_desc = "", l_responseJsonString = "",l_app_msg ="",  l_response_str = "";
			Map<String, Object> l_response_json = new HashMap<String, Object>();
			LinkedHashMap<String, String> patient_data = new LinkedHashMap<String, String>();
			//Map<String, String> params = new HashMap<String, String>();
			PractoInboundTransaction practoInboundTransaction = new PractoInboundTransaction();
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
				l_response_json.put("patient_data", patient_data);		
				
				l_responseJsonString = objMapper.writeValueAsString(l_response_json);
				
				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				//params.put("ERR_MSG", error);
				l_response_str = practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, error);
				l_app_msg = " ::: Message Load Method  ::: "+ l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);				
				
			}catch(Exception e)
			{
				
			}
			
			return l_responseJsonString;
			
		}

}

