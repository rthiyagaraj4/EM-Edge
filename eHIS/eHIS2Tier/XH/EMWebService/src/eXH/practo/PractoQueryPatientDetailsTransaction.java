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

public class PractoQueryPatientDetailsTransaction {
	
	
	public static String l_debug_YN = "N";

	public String l_errcd = "S", l_field_separator = "$!^";
	public String l_errmsg = "";
	public String l_ack_text = "";
	public String l_update_response_str = "";
	public String l_eventType = "OA28";
	
	public static String l_conn_msg = "Error - Unable to connect to the Data base, Kindly contact the System Administrator";

	
	public String processRequest(String actionKey) {
		String l_app_msg = "";
		String l_response_err_json = "", l_facility_id = "";
		String l_in_JSON = "", l_err_msg = "", l_message_id = "", l_application_id = "", l_protocol_link_id = "";
		String l_status = "", l_status_desc = "";
		
		List<Map<String,String>> fetchedPatientDets = new ArrayList<Map<String,String>>();
		ArrayList l_external_app_details = null;
		Map<String, String> params = new HashMap<String, String>();
		Map<String, Object> l_response_json = new HashMap<String, Object>();
		ObjectMapper objMapper = new ObjectMapper();
		PractoInboundTransaction practoInboundTransaction = new PractoInboundTransaction();

		String l_request_ref_no = "", l_request_code = "", l_request_type = "", l_responseJsonString = "";
		
		StringBuffer l_error = null;
		
		Map<String, String> patientData = new HashMap<String, String>();
		
		try
			{
	
			l_debug_YN = XHUtil.l_debug_YN;
			
			l_app_msg = " ************ Practo Query Patient Details Transaction started ************ ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_error = new StringBuffer();
	
			l_app_msg = " ::: Inside Practo Query Patient Details :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_app_msg = " ::: Generating Message ID ::: ";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);

			l_message_id = GenerateMessageIDMethod("XH_IB_MESSAGE_ID_SEQ");	
			
			if (l_message_id.indexOf("Error") >= 0) {
				l_errmsg = "Error in Message ID Generation - "+l_message_id;
				l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_errmsg + " \"  "	+ " } ";
				
				return "200#" + l_response_err_json + "#";
			}
			
			l_app_msg = " ::: Generated Message Id ::: "+l_message_id+" ::: Error Code : "+l_errcd+" ::: Error Message : "+l_errmsg;
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			
			if (l_errcd.equals("S"))				
			{			
				l_app_msg = "::: Fetching External Application Details : ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
	
				l_external_app_details = FetchExternalAppDetails("PRACTOINB");			
				
				if (l_external_app_details.isEmpty()) 
				{
					l_errcd = "E";
					l_errmsg = "Error in Fetching External Application Details No Data Available";		
					l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_errmsg + " \"  "
							+ " } ";
					return   "200#"+l_response_err_json+"#";
				}
				
				l_application_id = (String) l_external_app_details.get(0);
				
				if (l_application_id.indexOf("Error") >= 0) {
					l_errcd = "E";
					l_errmsg = "Fetching External Application Details - "+l_application_id;
					l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_errmsg + " \"  "
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
			
			l_app_msg = "::: Parsing input message ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_in_JSON = XHJSONUtil.createJsonObject(actionKey);
			
			if (l_in_JSON.indexOf("Error") >= 0) {
				l_errcd = "E";
				l_err_msg = l_in_JSON;
				l_error.append(l_err_msg);
			}
			
			if (l_errcd.equals("E"))
			{
				l_app_msg = " ::: Inserting Request into Message Table ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);			
				l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_error.toString() + " \"  "+ " } ";
				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
				practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
				
				return "200#"+ l_response_err_json +"#";		
				
			}
			
			l_error = new StringBuffer(" Unable to Query Patient Details - Information Missing");
			
			l_app_msg = " ::: Getting Request Reference Number from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	
			l_request_ref_no = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_ref_no");
			if (l_request_ref_no.indexOf("Error") >= 0 || l_request_ref_no.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Request Reference Number ");
			}
			
			l_app_msg = " ::: Request Reference Number : " + l_request_ref_no;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	
			l_app_msg = " ::: Getting Request Type from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	
			l_request_type = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_type");
			l_request_type = l_request_type.trim();
			if (l_request_type.indexOf("Error") >= 0 || l_request_type.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Request Type");
			}
			
			l_app_msg = " ::: Request Type : " + l_request_type;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_app_msg = " ::: Getting Request Request Code from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	
			l_request_code = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_code");
			l_request_code = l_request_code.trim();
			if (l_request_code.indexOf("Error") >= 0 || l_request_code.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Request Code ");
			}
			
			l_app_msg = " ::: Request Code : " + l_request_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			if (l_errcd.equals("E"))
			{
				l_app_msg = " ::: Inserting Request into Message Table Information Missing ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);			
				l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_error.toString() + " \"  "+ " } ";
				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
				practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
				
				return "200#"+ l_response_err_json +"#";			
			}
			
			l_error = new StringBuffer(" Unable to Query Patient Details ");
			if (!l_request_type.equals("PHONE") && !l_request_type.equals("UHID")) {
				l_errcd = "E";
				l_error.append(" - Request Type should be PHONE/UHID, cannot be others - "+l_request_type);
				
				l_app_msg = " ::: Inserting Request into Message Table Validating Request ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);			
				l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_error.toString() + " \"  "+ " } ";
				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
				practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
				
				return "200#"+ l_response_err_json +"#";
			}	
	
			if (l_request_type.equals("PHONE")) {
	
				l_app_msg = " ::: Getting Request Code from JSON :::";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Validate Request by using PHONE :::";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				int valid_count = ValidatePhone(l_request_code);
				
				l_app_msg = " ::: Validated count : " + valid_count;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				if(valid_count >= 1){
					l_status = "1";
					l_status_desc = "Patient data successfully retrieved";
					
					l_app_msg = " ::: Fetching Patient Details by using Phone :::";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					
					fetchedPatientDets = FetchPatDetailsByPhone(l_request_code);
					
					if (fetchedPatientDets.isEmpty()) {
						l_errcd = "E";
						l_status = "0";
						l_status_desc = "Patient record does not exists with the Phone "+l_request_code;
						
						Map<String, String> emptyParam = new LinkedHashMap<String, String>();
						emptyParam.put("patient_id", "");
						emptyParam.put("patient_prefix", "");
						emptyParam.put("first_name", "");
						emptyParam.put("second_name", "");
						emptyParam.put("surname", "");
						emptyParam.put("patient_gender", "");
						emptyParam.put("patient_age", "");
						emptyParam.put("mobile_no", "");
						emptyParam.put("nationality_code", "");
						emptyParam.put("nationality_desc", "");
						emptyParam.put("address_line_1", "");
						emptyParam.put("address_line_2", "");
						emptyParam.put("address_line_3", "");
						emptyParam.put("address_line_4", "");
						emptyParam.put("city", "");
						emptyParam.put("district", "");
						emptyParam.put("state", "");		
						emptyParam.put("postal_code", "");
						emptyParam.put("country", "");
						emptyParam.put("patient_email", "");
						emptyParam.put("facility_id", "");
						
						ArrayList<Map<String,String>> emptyPatientDtls = new ArrayList<Map<String, String>>();
						emptyPatientDtls.add(emptyParam);
						
						l_response_json.put("status", l_status);
						l_response_json.put("status_desc", l_status_desc);
						l_response_json.put("request_ref_no", l_request_ref_no);
						l_response_json.put("patient_data", emptyPatientDtls);
						
						l_responseJsonString = objMapper.writeValueAsString(l_response_json);
						
						l_app_msg = " ::: Inserting Request into Message Table Patient record does not exists with the Phone ::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						
						params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
						practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
						
						return "200#"+l_responseJsonString+"#";
						
					}
					
					if(l_errcd.equals("S")){
					
						l_response_json.put("status", l_status);
						l_response_json.put("status_desc", l_status_desc);
						l_response_json.put("request_ref_no", l_request_ref_no);
						l_response_json.put("patient_data", fetchedPatientDets);
						
						l_responseJsonString = objMapper.writeValueAsString(l_response_json);
						
						l_app_msg = " ::: Inserting Request into Message Table Patient data successfully retrieved with PHONE ::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						
						l_app_msg = " ::: Response Patient data successfully retrieved with PHONE ::: \n "+l_responseJsonString.toString();
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						
						params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
						practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, "");
						
						return "200#"+l_responseJsonString+"#";
					}
					
				}else {
					l_errcd = "E";
					l_status = "0";
					l_status_desc = "Patient record does not exists with the Phone "+l_request_code;
					
					Map<String, String> emptyParam = new LinkedHashMap<String, String>();
					emptyParam.put("patient_id", "");
					emptyParam.put("patient_prefix", "");
					emptyParam.put("first_name", "");
					emptyParam.put("second_name", "");
					emptyParam.put("surname", "");
					emptyParam.put("patient_gender", "");
					emptyParam.put("patient_age", "");
					emptyParam.put("mobile_no", "");
					emptyParam.put("nationality_code", "");
					emptyParam.put("nationality_desc", "");
					emptyParam.put("address_line_1", "");
					emptyParam.put("address_line_2", "");
					emptyParam.put("address_line_3", "");
					emptyParam.put("address_line_4", "");
					emptyParam.put("city", "");
					emptyParam.put("district", "");
					emptyParam.put("state", "");		
					emptyParam.put("postal_code", "");
					emptyParam.put("country", "");
					emptyParam.put("patient_email", "");
					emptyParam.put("facility_id", "");
					
					ArrayList<Map<String,String>> emptyPatientDtls = new ArrayList<Map<String, String>>();
					emptyPatientDtls.add(emptyParam);
					
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);
					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("patient_data", emptyPatientDtls);
					
					l_responseJsonString = objMapper.writeValueAsString(l_response_json);
					
					l_app_msg = " ::: Inserting Request into Message Table Patient record does not exists with the PHONE ::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					
					params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
					practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
					
					return "200#"+l_responseJsonString+"#";
					
				}
	
			} else if (l_request_type.equals("UHID")) {
	
				l_app_msg = " ::: Getting Request Code from JSON :::";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Validate Request by using UHID :::";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				int validUHID = ValidateUHID(l_request_code);
				
				l_app_msg = " ::: Validated count : " + validUHID;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				if(validUHID >= 1){
					l_status = "1";
					l_status_desc = "Patient data successfully retrieved";
					
					l_app_msg = " ::: Fetching Patient Details by using UHID :::";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					
					fetchedPatientDets = FetchPatDetailsByUHID(l_request_code);
					
					if (fetchedPatientDets.isEmpty()) {
						l_errcd = "E";
						l_error.append(fetchedPatientDets);
						l_status = "0";
						l_status_desc = "Patient record does not exists with the UHID "+l_request_code;
						
						Map<String, String> emptyParam = new LinkedHashMap<String, String>();					
						
						emptyParam.put("patient_id", "");
						emptyParam.put("patient_prefix", "");
						emptyParam.put("first_name", "");
						emptyParam.put("second_name", "");
						emptyParam.put("surname", "");
						emptyParam.put("patient_gender", "");
						emptyParam.put("patient_age", "");
						emptyParam.put("mobile_no", "");
						emptyParam.put("nationality_code", "");
						emptyParam.put("nationality_desc", "");
						emptyParam.put("address_line_1", "");
						emptyParam.put("address_line_2", "");
						emptyParam.put("address_line_3", "");
						emptyParam.put("address_line_4", "");
						emptyParam.put("city", "");
						emptyParam.put("district", "");
						emptyParam.put("state", "");		
						emptyParam.put("postal_code", "");
						emptyParam.put("country", "");
						emptyParam.put("patient_email", "");
						emptyParam.put("facility_id", "");
						
						ArrayList<Map<String,String>> emptyPatientDtls = new ArrayList<Map<String, String>>();
						emptyPatientDtls.add(emptyParam);
						
						l_response_json.put("status", l_status);
						l_response_json.put("status_desc", l_status_desc);
						l_response_json.put("request_ref_no", l_request_ref_no);
						l_response_json.put("patient_data", emptyPatientDtls);
						
						l_responseJsonString = objMapper.writeValueAsString(l_response_json);
						
						l_app_msg = " ::: Inserting Request into Message Table Patient record does not exists with the UHID ::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						
						params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
						practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
						
						return "200#"+l_responseJsonString+"#";
						
					}
					
					if(l_errcd.equals("S")) {
						l_response_json.put("status", l_status);
						l_response_json.put("status_desc", l_status_desc);
						l_response_json.put("request_ref_no", l_request_ref_no);
						l_response_json.put("patient_data", fetchedPatientDets);
						
						patientData = fetchedPatientDets.get(0);
						
						for(String key:patientData.keySet()){
							if (l_debug_YN.equals("Y"))
								System.out.println(key+ " : "+patientData.get(key));				        
					    } 
						
						l_responseJsonString = objMapper.writeValueAsString(l_response_json);
						
						l_app_msg = " ::: Inserting Request into Message Table Patient data successfully retrieved with UHID ::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						
						params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
						practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, "");
						
						return "200#"+l_responseJsonString+"#";
					}
					
				}else {
					l_errcd = "E";
					l_status = "0";
					l_status_desc = "Patient record does not exists with the UHID "+l_request_code;
					
					Map<String, String> emptyParam = new LinkedHashMap<String, String>();
					
					emptyParam.put("patient_id", "");
					emptyParam.put("patient_prefix", "");
					emptyParam.put("first_name", "");
					emptyParam.put("second_name", "");
					emptyParam.put("surname", "");
					emptyParam.put("patient_gender", "");
					emptyParam.put("patient_age", "");
					emptyParam.put("mobile_no", "");
					emptyParam.put("nationality_code", "");
					emptyParam.put("nationality_desc", "");
					emptyParam.put("address_line_1", "");
					emptyParam.put("address_line_2", "");
					emptyParam.put("address_line_3", "");
					emptyParam.put("address_line_4", "");
					emptyParam.put("city", "");
					emptyParam.put("district", "");
					emptyParam.put("state", "");		
					emptyParam.put("postal_code", "");
					emptyParam.put("country", "");
					emptyParam.put("patient_email", "");
					emptyParam.put("facility_id", "");
					
					ArrayList<Map<String,String>> emptyPatientDtls = new ArrayList<Map<String, String>>();
					emptyPatientDtls.add(emptyParam);
					
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);
					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("patient_data", emptyPatientDtls);
					
					l_responseJsonString = objMapper.writeValueAsString(l_response_json);
					
					l_app_msg = " ::: Inserting Request into Message Table Patient record does not exists with the UHID ::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
					
					params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
					practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
					
					return "200#"+l_responseJsonString+"#";
					
				}
	
			}
		}catch(Exception e){
			e.printStackTrace();
			l_errcd = "E";
			l_errmsg = l_errcd + "# Exception Occurred " + e.getMessage();
		}

		return "200#"+l_responseJsonString+"#";
	}

	public String FetchFieldValue(String message, String identifier,
			String standardCode, String fieldSep, String procID) {

		String l_app_msg = "", l_field_value = "";

		l_app_msg = " ::: Inside FetchFieldValue ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: Message : " + message + " ::: Identifier : "
				+ identifier + " ::: Standard Code : " + standardCode;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: Deriving Field Value..." + identifier;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			if (standardCode != null && !(standardCode.length() > 0)) {

			} else {
				if (message.indexOf(identifier) >= 0) {
					if (message.indexOf(fieldSep) >= 0) {
						l_field_value = message.substring(message
								.indexOf(identifier) + identifier.length());
						if (l_field_value.indexOf(fieldSep) >= 0) {
							l_field_value = l_field_value.substring(0,
									l_field_value.indexOf(fieldSep));
						}
					}
				}
			}
		} catch (Exception e) {
			l_field_value = "Error in " + l_app_msg + " : " + e.getMessage();
		}

		l_app_msg = " ::: l_field_value ::: " + l_field_value;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		return l_field_value;
	}

	public List<Map<String, String>> FetchPatDetailsByPhone(String phoneNo) {
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Map<String,String>> patientDetByPhone = new ArrayList<Map<String,String>>();
		Map<String, String> params =  null;

		String query = "";
		String l_app_msg = "";

		l_app_msg = " Inside FetchPatDetailtsByPhone ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			dbConn = EMDataSource.getConnection();
			query = "select A.PATIENT_ID, NVL(NAME_PREFIX,'') NAME_PREFIX, NVL(FIRST_NAME,'') FIRST_NAME, NVL(SECOND_NAME,'') SECOND_NAME, NVL(FAMILY_NAME,'') FAMILY_NAME , NVL(SEX,'') SEX, TO_CHAR(TRUNC(SYSDATE),'YYYY')-TO_CHAR(DATE_OF_BIRTH,'YYYY') AGE, NVL(REPLACE(CONTACT2_NO,'#','$$'),'') CONTACT2_NO, NVL(NATIONALITY_CODE,'') NATIONALITY_CODE, NVL(B.LONG_DESC,'') NATIONALITY_DESC, " +
					" NVL(REPLACE(ADDR1_LINE1,'#','$$'),'') ADDR1_LINE1, NVL(REPLACE(ADDR1_LINE2,'#','$$'),'') ADDR1_LINE2, NVL(REPLACE(ADDR1_LINE3,'#','$$'),'') ADDR1_LINE3, NVL(REPLACE(ADDR1_LINE4,'#','$$'),'') ADDR1_LINE4,  NVL(D.SHORT_DESC,'') CITY, NVL(E.SHORT_DESC,'') REGION, NVL(F.SHORT_DESC,'') STATE, NVL(G.SHORT_DESC,'') POSTAL_CODE, NVL(H.SHORT_NAME,'') COUNTRY, NVL(REPLACE(EMAIL_ID,'#','$$'),'') EMAIL_ID,  NVL(REGN_FACILITY_ID,'') REGN_FACILITY_ID " +
					" from mp_patient a, MP_COUNTRY b, mp_pat_addresses c, MP_RES_TOWN d, MP_RES_AREA e, MP_REGION f, MP_POSTAL_CODE g, mp_country h " +
					" where a.NATIONALITY_CODE = b.COUNTRY_CODE(+) and a.patient_id = C.PATIENT_ID(+) and c.ADDR1_TYPE = 'RES' " +
					" and RES_TOWN1_CODE = D.RES_TOWN_CODE(+) and RES_AREA1_CODE = d.RES_AREA_CODE(+) and RES_AREA1_CODE = e.RES_AREA_CODE(+) " +
					" and REGION1_CODE = f.REGION_CODE(+) and POSTAL1_CODE = g.POSTAL_CODE(+) and COUNTRY1_CODE = H.COUNTRY_CODE(+) " +
					" and contact2_no like ?";
			
			phoneNo = "%"+phoneNo;
			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, phoneNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				params = new LinkedHashMap<String, String>();
				params.put("patient_id", rs.getString("PATIENT_ID"));				
				params.put("patient_prefix", rs.getString("NAME_PREFIX")== null?"":rs.getString("NAME_PREFIX"));
				params.put("first_name", rs.getString("FIRST_NAME")== null?"":rs.getString("FIRST_NAME"));
				params.put("second_name", rs.getString("SECOND_NAME")== null?"":rs.getString("SECOND_NAME"));
				params.put("surname", rs.getString("FAMILY_NAME")== null?"":rs.getString("FAMILY_NAME"));
				params.put("patient_gender", rs.getString("SEX")== null?"":rs.getString("SEX"));
				params.put("patient_age", rs.getString("AGE"));
				params.put("mobile_no", rs.getString("CONTACT2_NO")== null?"":rs.getString("CONTACT2_NO"));
				params.put("nationality_code", rs.getString("NATIONALITY_CODE")== null?"":rs.getString("NATIONALITY_CODE"));
				params.put("nationality_desc", rs.getString("NATIONALITY_DESC")== null?"":rs.getString("NATIONALITY_DESC"));;
				params.put("address_line_1", rs.getString("ADDR1_LINE1")== null?"":rs.getString("ADDR1_LINE1"));
				params.put("address_line_2", rs.getString("ADDR1_LINE2")== null?"":rs.getString("ADDR1_LINE2"));
				params.put("address_line_3", rs.getString("ADDR1_LINE3")== null?"":rs.getString("ADDR1_LINE3"));
				params.put("address_line_4", rs.getString("ADDR1_LINE4")== null?"":rs.getString("ADDR1_LINE4"));
				params.put("city", rs.getString("CITY")== null?"":rs.getString("CITY"));
				params.put("district", rs.getString("REGION")== null?"":rs.getString("REGION"));
				params.put("state", rs.getString("STATE")== null?"":rs.getString("STATE"));		
				params.put("postal_code", rs.getString("POSTAL_CODE")== null?"":rs.getString("POSTAL_CODE"));
				params.put("country", rs.getString("COUNTRY")== null?"":rs.getString("COUNTRY"));
				params.put("patient_email", rs.getString("EMAIL_ID")== null?"":rs.getString("EMAIL_ID"));
				params.put("facility_id", rs.getString("REGN_FACILITY_ID"));

				patientDetByPhone.add(params);
			}
			l_app_msg = "::: Fetched Patient Details ::: "+patientDetByPhone;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

		} catch (Exception e) {
			params = new LinkedHashMap<String, String>();
			l_app_msg = "Error in Fetching Patient Details By Phone Exception - "
					+ e.getMessage();
			params.put("Error", l_app_msg);
			
			e.printStackTrace();
			patientDetByPhone.add(params);
		} finally {
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		return patientDetByPhone;

	}

	public List<Map<String, String>> FetchPatDetailsByUHID(String patientId) {
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Map<String,String>> patientDetByUHID = new ArrayList<Map<String,String>>();
		Map<String, String> params = null;

		String query = "";
		String l_app_msg = "";
		l_app_msg = " Inside FetchPatDetailtsByUHID ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			dbConn = EMDataSource.getConnection();
			query = "select A.PATIENT_ID, NVL(NAME_PREFIX,'') NAME_PREFIX, NVL(FIRST_NAME,'') FIRST_NAME, NVL(SECOND_NAME,'') SECOND_NAME, NVL(FAMILY_NAME,'') FAMILY_NAME , NVL(SEX,'') SEX, TO_CHAR(TRUNC(SYSDATE),'YYYY')-TO_CHAR(DATE_OF_BIRTH,'YYYY') AGE, NVL(REPLACE(CONTACT2_NO,'#','$$'),'') CONTACT2_NO, NVL(NATIONALITY_CODE,'') NATIONALITY_CODE, NVL(B.LONG_DESC,'') NATIONALITY_DESC, " +
					" NVL(REPLACE(ADDR1_LINE1,'#','$$'),'') ADDR1_LINE1, NVL(REPLACE(ADDR1_LINE2,'#','$$'),'') ADDR1_LINE2, NVL(REPLACE(ADDR1_LINE3,'#','$$'),'') ADDR1_LINE3, NVL(REPLACE(ADDR1_LINE4,'#','$$'),'') ADDR1_LINE4,  NVL(D.SHORT_DESC,'') CITY, NVL(E.SHORT_DESC,'') REGION, NVL(F.SHORT_DESC,'') STATE, NVL(G.SHORT_DESC,'') POSTAL_CODE, NVL(H.SHORT_NAME,'') COUNTRY, NVL(REPLACE(EMAIL_ID,'#','$$'),'') EMAIL_ID,  NVL(REGN_FACILITY_ID,'') REGN_FACILITY_ID " +
					" from mp_patient a, MP_COUNTRY b, mp_pat_addresses c, MP_RES_TOWN d, MP_RES_AREA e, MP_REGION f, MP_POSTAL_CODE g, mp_country h " +
					" where a.NATIONALITY_CODE = b.COUNTRY_CODE(+) and a.patient_id = C.PATIENT_ID(+) and c.ADDR1_TYPE = 'RES' " +
					" and RES_TOWN1_CODE = D.RES_TOWN_CODE(+) and RES_AREA1_CODE = d.RES_AREA_CODE(+) and RES_AREA1_CODE = e.RES_AREA_CODE(+) " +
					" and REGION1_CODE = f.REGION_CODE(+) and POSTAL1_CODE = g.POSTAL_CODE(+) and COUNTRY1_CODE = H.COUNTRY_CODE(+) " +
					" and A.patient_id = ?";
			
			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, patientId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				params = new LinkedHashMap<String, String>();
				params.put("patient_id", rs.getString("PATIENT_ID"));
				params.put("patient_prefix", rs.getString("NAME_PREFIX")== null?"":rs.getString("NAME_PREFIX"));
				params.put("first_name", rs.getString("FIRST_NAME")== null?"":rs.getString("FIRST_NAME"));
				params.put("second_name", rs.getString("SECOND_NAME")== null?"":rs.getString("SECOND_NAME"));
				params.put("surname", rs.getString("FAMILY_NAME")== null?"":rs.getString("FAMILY_NAME"));
				params.put("patient_gender", rs.getString("SEX")== null?"":rs.getString("SEX"));
				params.put("patient_age", rs.getString("AGE"));
				params.put("mobile_no", rs.getString("CONTACT2_NO")== null?"":rs.getString("CONTACT2_NO"));
				params.put("nationality_code", rs.getString("NATIONALITY_CODE")== null?"":rs.getString("NATIONALITY_CODE"));
				params.put("nationality_desc", rs.getString("NATIONALITY_DESC")== null?"":rs.getString("NATIONALITY_DESC"));;
				params.put("address_line_1", rs.getString("ADDR1_LINE1")== null?"":rs.getString("ADDR1_LINE1"));
				params.put("address_line_2", rs.getString("ADDR1_LINE2")== null?"":rs.getString("ADDR1_LINE2"));
				params.put("address_line_3", rs.getString("ADDR1_LINE3")== null?"":rs.getString("ADDR1_LINE3"));
				params.put("address_line_4", rs.getString("ADDR1_LINE4")== null?"":rs.getString("ADDR1_LINE4"));
				params.put("city", rs.getString("CITY")== null?"":rs.getString("CITY"));
				params.put("district", rs.getString("REGION")== null?"":rs.getString("REGION"));
				params.put("state", rs.getString("STATE")== null?"":rs.getString("STATE"));		
				params.put("postal_code", rs.getString("POSTAL_CODE")== null?"":rs.getString("POSTAL_CODE"));
				params.put("country", rs.getString("COUNTRY")== null?"":rs.getString("COUNTRY"));
				params.put("patient_email", rs.getString("EMAIL_ID")== null?"":rs.getString("EMAIL_ID"));
				params.put("facility_id", rs.getString("REGN_FACILITY_ID"));
				patientDetByUHID.add(params);
			}
			l_app_msg = ":::patientDetByUHID :::" + patientDetByUHID;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

		} catch (Exception e) {
			params = new LinkedHashMap<String, String>();
			l_app_msg = "Error in Fetching Patient Details By UHID Exception - "
					+ e.getMessage();
			params.put("Error", l_app_msg);
			patientDetByUHID.add(params);
		} finally {
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		return patientDetByUHID;
	}
	
	public static int ValidateUHID(String UHID){
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query;
		int count = 0;
		try
		{
			dbConn =  EMDataSource.getConnection();
			query = "SELECT PATIENT_ID,COUNT( * ) FROM MP_PATIENT where PATIENT_ID = ? GROUP BY PATIENT_ID";

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, UHID);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				count = rs.getInt(2);
			}
			
		}
		catch(Exception e)
		{
			 e.getMessage();			
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
	
		
		return count;
	}
	
	public static int ValidatePhone(String l_phone_no){
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query;
		int count = 0;
		l_phone_no = "%"+l_phone_no;
		try
		{
			dbConn =  EMDataSource.getConnection();
			query = "SELECT CONTACT2_NO,COUNT( * ) FROM MP_PATIENT where CONTACT2_NO like ? GROUP BY CONTACT2_NO ";

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, l_phone_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				count = rs.getInt(2);
			}			
		}
		catch(Exception e)
		{
			 e.getMessage();			
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}	
		return count;
	}
	
	public static String GenerateMessageIDMethod(String SeqenceName) {

		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		int l_trans_id = 0;

		l_app_msg = " ::: Inside GenerateMessageIDMethod ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			dbConn = EMDataSource.getConnection();
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
			EMDataSource.returnConnection(dbConn);
		}

		return l_field_value;
	}
	
	public static ArrayList FetchExternalAppDetails(String ExternalApplication) {
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "";
		ArrayList externalArray = new ArrayList();

		String l_application_id = "", l_protocol_link_id = "", l_facility_id = "";

		l_app_msg = " ::: Inside FetchExternalAppDetails ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: ExternalApplication : " + ExternalApplication;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
				dbConn = EMDataSource.getConnection();
				query = "SELECT APPLICATION_ID,PROTOCOL_LINK_ID,FACILITY_ID FROM xh_filter_dms_vw WHERE EXTERNAL_APPLICATION = 'PRACTOINB'";
				
				if (dbConn == null)	
				{
					externalArray.add(l_conn_msg);
					return externalArray;
				}
	
				pstmt = dbConn.prepareStatement(query);
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
						+ " ::: Facility Id : " + l_facility_id;
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
				EMDataSource.returnConnection(dbConn);
			}
		return externalArray;
	}	

}
