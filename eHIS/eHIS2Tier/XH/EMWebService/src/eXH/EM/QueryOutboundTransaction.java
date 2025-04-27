package eXH.EM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;
import org.codehaus.jackson.map.ObjectMapper;

import eXH.util.EMDataSource;
import eXH.util.XHSecurity;
import eXH.util.XHUtil;


public class QueryOutboundTransaction {

	public static String l_segment_id = "";
	public static String l_standard_code = "";
	public String l_app_msg = "";
	public static final String l_field_separator = "&";

	public static String l_debug_YN = "N";

	public String l_errcd = "S";
	public String l_errmsg = "";
	public String l_ack_text = "";

	Connection dbConn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	public static String l_conn_msg = "Error - Unable to connect to the Data base, Kindly contact the System Administrator";

	public String processOutboundRequest(String actionKey, String key,
			String eventType, String method) {

		String l_response_str = "", l_response_err_json = "", l_err_msg = "", l_responseJsonString = "";
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "", l_debug_yn = "";

		String l_protocol_link_id = "";

		String l_message_id = "", l_application_id = "", l_facility_id = "";

		Map<String, String> params = new HashMap<String, String>();

		ArrayList<String> l_protocol_details = null;

		ArrayList<String> l_segment_details = null;

		StringBuffer l_error = null;

		String l_request_ref_no = "", l_request_type = "", l_request_date_time = "", l_all_flag = "";

		List<Map<String, String>> fetchedPatientDetls = new ArrayList<Map<String, String>>();
		
		List<Map<String, String>> fetchedApptDetls = new ArrayList<Map<String, String>>(); 
		
		List<Map<String, String>> fetchedMrgPatDetls = new ArrayList<Map<String, String>>(); 

		Map<String, Object> l_response_json = new HashMap<String, Object>();

		ObjectMapper objMapper = new ObjectMapper();

		String l_status = "0", l_status_desc = "";

		String l_patient_id="";
		
		String delims = "^!^";
		StringTokenizer st = null;
		
		ArrayList<String> tokenD = null;
		String msgGenFlag = "E";
		
		String l_action_type = "";
		
		List<Map<String, String>> fetchedVisitDetls = new ArrayList<Map<String, String>>();
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

		try {

			l_error = new StringBuffer(
					"Unable to Fetch the details - Information Missing");

			l_app_msg = " ::: Inside Query Transaction Details ::: "
					+ actionKey;
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
					
				return l_errcd + "$!^" +l_response_err_json +  "$!^" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";
			}

			if (l_errcd.equals("S")) {
				l_app_msg = "::: Fetching Segment Details : ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_segment_details = FetchSegmentDetails(key, dbConn);

				if (l_segment_id.indexOf("Error") >= 0) {
					l_errmsg = "Fetching Segment Details - " + l_segment_id;
					l_response_err_json = l_errmsg;
					return l_errcd + "$!^" +l_response_err_json +  "$!^" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";
				}

				l_app_msg = " ::: Segment : " + l_segment_details
						+ " ::: Error Code : " + l_errcd
						+ " ::: Error Message : " + l_errmsg;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

			}

			if (l_errcd.equals("S")) {
				l_segment_id = (String) l_segment_details.get(0);
				l_standard_code = (String) l_segment_details.get(1);
			}

			if (l_errcd.equals("S")) {
				l_app_msg = "::: Fetching Protocol Details : ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_protocol_details = FetchAppDetails(l_standard_code, dbConn);

				if (l_protocol_details.isEmpty()) {
					l_errcd = "E";
					l_errmsg = "Error in Fetching protocol details No Data Available";
					l_response_err_json = l_errmsg;
					return l_errcd + "$!^" +l_response_err_json +  "$!^" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";
				}

				l_application_id = (String) l_protocol_details.get(0);

				if (l_application_id.indexOf("Error") >= 0) {
					l_errmsg = "Fetching protocol Details - "
							+ l_application_id;
					l_response_err_json = l_errmsg;

					return l_errcd + "$!^" +l_response_err_json +  "$!^" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";
				}

				l_app_msg = " ::: Message ID : " + l_message_id
						+ " ::: Protocol : " + l_protocol_details
						+ " ::: Error Code : " + l_errcd
						+ " ::: Error Message : " + l_errmsg;
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

			// Request ends here

			l_app_msg = "::: Parsing input message ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_request_ref_no = FieldValueFetchMethod(actionKey,
					"request_ref_no=", null, l_field_separator,
					"processRequest");
			l_request_ref_no = l_request_ref_no.trim();

			if (l_request_ref_no.indexOf("Error") >= 0
					|| l_request_ref_no.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - request ref_no ");
			}

			l_app_msg = " ::: Request Reference No ::: " + l_request_ref_no;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (l_errcd.equals("E")) {
				return l_errcd + "$!^" +l_error +  "$!^" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";
			}

			l_request_type = FieldValueFetchMethod(actionKey, "request_type=",
					null, l_field_separator, "processRequest");
			l_request_type = l_request_type.trim();
			if (l_request_type.indexOf("Error") >= 0
					|| l_request_type.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - request type ");
			}

			l_app_msg = " ::: Request Type ::: " + l_request_type;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (l_errcd.equals("E")) {
				l_app_msg = " ::: Inserting Request into Message Table Information Missing ::: ";
				return l_errcd + "$!^" +l_error.toString() +  "$!^" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";
			}

			l_request_date_time = new java.text.SimpleDateFormat(
					"dd/MM/yyyy HH:mm:ss").format(new java.util.Date());
			l_app_msg = " ::: Request Date Time ::: " + l_request_date_time;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_facility_id = FieldValueFetchMethod(actionKey, "facility_id=",
					null, l_field_separator, "processRequest");
			l_facility_id = l_facility_id.trim();
			if (l_facility_id.indexOf("Error") >= 0
					|| l_facility_id.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - facility id");
			}

			l_app_msg = " ::: Facility Id ::: " + l_facility_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (l_errcd.equals("E")) {
				
				return l_errcd + "$!^" +l_error.toString() +  "$!^" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";
			}

			l_all_flag = FieldValueFetchMethod(actionKey, "all_flag=", null,
					l_field_separator, "processRequest");
			l_all_flag = l_all_flag.trim();
			
			l_action_type = FieldValueFetchMethod(actionKey, "action_type=", null, l_field_separator,
					"processRequest");
			l_action_type = l_action_type.trim();
			if (l_action_type.indexOf("Error") >= 0 || l_action_type.trim().equals("")) {
				l_action_type = "";
			}

			l_app_msg = " ::: Action Type ::: " + l_action_type;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (l_request_type.equals("REGPAT")) {				
				
				if (l_all_flag.equals("I")) {
					l_patient_id = FieldValueFetchMethod(actionKey,
							"patient_id=", null, l_field_separator,
							"processRequest");
					l_patient_id = l_patient_id.trim();
					if (l_patient_id.indexOf("Error") >= 0
							|| l_patient_id.trim().equals("")) {
						l_errcd = "E";
						l_error.append(" - Patient Id");
					}

					l_app_msg = " ::: Patient Id ::: " + l_patient_id;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					if (l_errcd.equals("E")) {
						return l_errcd + "$!^" +l_error.toString() +  "$!^" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";
					}

					l_facility_id = FieldValueFetchMethod(actionKey,
							"facility_id=", null, l_field_separator,
							"processRequest");
					l_facility_id = l_facility_id.trim();
					if (l_facility_id.indexOf("Error") >= 0
							|| l_facility_id.trim().equals("")) {
						l_errcd = "E";
						l_error.append(" - Facility Id");
					}

					l_app_msg = " ::: Facility Id ::: " + l_facility_id;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					if (l_errcd.equals("E")) {
						return l_errcd + "$!^" +l_error.toString() +  "$!^" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";
					}

				} else {
					l_patient_id = "";
					l_facility_id = "";
				}

				// Request ends here

				fetchedPatientDetls = FetchPatientDetails(l_facility_id,l_patient_id, l_all_flag, dbConn);

				if (fetchedPatientDetls.isEmpty()) {
					l_errcd = "E";
					l_status = "0";
					l_status_desc = "Patient record does not exists";
					msgGenFlag = "E";

					Map<String, String> emptyParam = new LinkedHashMap<String, String>();
					emptyParam.put("first_name", "");
					emptyParam.put("second_name", "");
					emptyParam.put("third_name", "");
					emptyParam.put("gender", "");
					emptyParam.put("date_of_birth", "");
					emptyParam.put("mobile_no", "");
					emptyParam.put("nationality_code", "");
					emptyParam.put("nationality_desc", "");
					emptyParam.put("address_line_1", "");
					emptyParam.put("address_line_2", "");
					emptyParam.put("town_code", "");
					emptyParam.put("town_desc", "");
					emptyParam.put("area_code", "");
					emptyParam.put("area_desc", "");
					emptyParam.put("region_code", "");
					emptyParam.put("region_desc", "");
					emptyParam.put("postal_code", "");
					emptyParam.put("country_code", "");
					emptyParam.put("country_desc", "");
					emptyParam.put("email_id", "");
					emptyParam.put("identification_type_code", "");
					emptyParam.put("identification_type_desc", "");
					emptyParam.put("identification_id", "");
					emptyParam.put("facility_id", "");
					emptyParam.put("patient_id", "");
					emptyParam.put("active_yn", "");
					emptyParam.put("suspend_yn", "");
					emptyParam.put("deceased_yn", "");
					emptyParam.put("deceased_date", "");
					emptyParam.put("blng_grp_id", "");

					ArrayList<Map<String, String>> emptyPatientDtls = new ArrayList<Map<String, String>>();
					emptyPatientDtls.add(emptyParam);

					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("request_type", l_request_type);
					l_response_json.put("request_date_time", l_request_date_time);
					l_response_json.put("request_data", emptyPatientDtls);

					l_responseJsonString = objMapper.writeValueAsString(l_response_json);

					l_app_msg = " ::: Inserting Request into Message Table Master Patient record does not exists ::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					
					l_errcd = "E";

					params.put("MESSAGE_ACK_TEXT",
							l_responseJsonString.toString());

					return l_errcd + "$!^" +l_status_desc +  "$!^" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";

				}

				if (l_errcd.equals("S")) {
					l_status = "1";
					msgGenFlag = "S";
					l_status_desc = "Data successfully retrieved";
					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("request_type", l_request_type);
					l_response_json.put("request_date_time", l_request_date_time);
					l_response_json.put("request_data", fetchedPatientDetls);

					l_responseJsonString = objMapper
							.writeValueAsString(l_response_json);

					l_app_msg = " ::: Inserting Request into Message Table Master Clinic Data successfully retrieved::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					l_app_msg = " ::: Response Master Clinic Data successfully retrieved ::: \n "
							+ l_responseJsonString.toString();
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					
					l_response_str = TransCommunicationMethod(l_protocol_link_id, eventType, l_responseJsonString, l_action_type, l_application_id, dbConn);
					
					l_response_str = l_response_str.replace("$!^","^!^");
					l_app_msg = " ::: Response String after replacement ::: \n "
							+ l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					

					st = new StringTokenizer(l_response_str, delims );

					tokenD = new ArrayList<String>();

					while (st.hasMoreElements()) 
					{
						tokenD.add(st.nextToken());	
					}	

					if (tokenD.size()>0)
					{
						l_errcd = tokenD.get(0);
						l_status_desc = tokenD.get(1);
						l_response_str = tokenD.get(2);
					} 
					
					return l_errcd + "$!^" +l_status_desc +  "$!^" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";
				}
				else {
					l_errcd = "E";
					l_status = "0";
					l_status_desc = "Patient record does not exists ";
					
					msgGenFlag = "E";

					Map<String, String> emptyParam = new LinkedHashMap<String, String>();
					emptyParam.put("first_name", "");
					emptyParam.put("second_name", "");
					emptyParam.put("third_name", "");
					emptyParam.put("gender", "");
					emptyParam.put("date_of_birth", "");
					emptyParam.put("mobile_no", "");
					emptyParam.put("nationality_code", "");
					emptyParam.put("nationality_desc", "");
					emptyParam.put("address_line_1", "");
					emptyParam.put("address_line_2", "");
					emptyParam.put("town_code", "");
					emptyParam.put("town_desc", "");
					emptyParam.put("area_code", "");
					emptyParam.put("area_desc", "");
					emptyParam.put("region_code", "");
					emptyParam.put("region_desc", "");
					emptyParam.put("postal_code", "");
					emptyParam.put("country_code", "");
					emptyParam.put("country_desc", "");
					emptyParam.put("patient_email", "");
					emptyParam.put("identification_type_code", "");
					emptyParam.put("identification_type_desc", "");
					emptyParam.put("identification_id", "");
					emptyParam.put("facility_id", "");
					emptyParam.put("patient_id", "");
					emptyParam.put("active_yn", "");
					emptyParam.put("suspend_yn", "");
					emptyParam.put("deceased_yn", "");
					emptyParam.put("deceased_date", "");
					emptyParam.put("blng_grp_id", "");

					ArrayList<Map<String, String>> emptyClinicDtls = new ArrayList<Map<String, String>>();
					emptyClinicDtls.add(emptyParam);

					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("request_type", l_request_type);
					l_response_json.put("request_date_time",
							l_request_date_time);
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);
					l_response_json.put("request_data", emptyClinicDtls);

					l_responseJsonString = objMapper
							.writeValueAsString(l_response_json);

					l_app_msg = " ::: Inserting Request into Message Table Master Clinic record does not exists::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					l_errcd = "E";

					params.put("MESSAGE_ACK_TEXT",
							l_responseJsonString.toString());

					return l_errcd + "$!^" +l_status_desc +  "$!^" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";

				}

			} 
			String l_appt_ref_no = "";
			if (l_request_type.equals("SCHAPPT")||l_request_type.equals("RSHAPPT")||l_request_type.equals("CANAPPT")) {
				if (l_all_flag.equals("I")) {
					l_appt_ref_no = FieldValueFetchMethod(actionKey,
							"appt_ref_no=", null, l_field_separator,
							"processRequest");
					l_appt_ref_no = l_appt_ref_no.trim();
					if (l_appt_ref_no.indexOf("Error") >= 0
							|| l_appt_ref_no.trim().equals("")) {
						l_errcd = "E";
						l_error.append(" - Appointment Reference Number");
					}

					l_app_msg = " ::: Appointment Ref Id ::: " + l_appt_ref_no;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					if (l_errcd.equals("E")) {
						return l_errcd + "$!^" +l_error.toString() +  "$!^" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";
					}

					l_facility_id = FieldValueFetchMethod(actionKey,
							"facility_id=", null, l_field_separator,
							"processRequest");
					l_facility_id = l_facility_id.trim();
					if (l_facility_id.indexOf("Error") >= 0
							|| l_facility_id.trim().equals("")) {
						l_errcd = "E";
						l_error.append(" - Facility Id");
					}

					l_app_msg = " ::: Facility Id ::: " + l_facility_id;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					if (l_errcd.equals("E")) {
						return l_errcd + "$!^" +l_error.toString() +  "$!^" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";
					}
					
					l_patient_id = FieldValueFetchMethod(actionKey,
							"patient_id=", null, l_field_separator,
							"processRequest");
					l_patient_id = l_patient_id.trim();
					
					l_app_msg = " ::: Patient Id ::: " + l_patient_id;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

				} else {
					l_appt_ref_no = "";
					l_facility_id = "";
				}

				// Request ends here
				
				l_app_msg = " Inside Fetch Appointment Details... Facility Id... " + l_facility_id+ " Appointment Id... "	+ l_appt_ref_no + " Patient Id... "+ l_patient_id+ "::l_all_flag:::" + l_all_flag+ "::Event_Type:::" + eventType;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				fetchedApptDetls = FetchAppointmentDetails(l_facility_id, l_appt_ref_no, l_patient_id, l_all_flag, eventType, dbConn);

				if (fetchedApptDetls.isEmpty()) {
					l_errcd = "E";
					l_status = "0";
					l_status_desc = "Appointment record does not exists";
					msgGenFlag = "E";

					Map<String, String> emptyParam = new LinkedHashMap<String, String>();
					
					emptyParam.put("appointment_id", "");
					emptyParam.put("facility_id", "");
					if (eventType.equals("OA21")){						
						emptyParam.put("speciality_id", "");
						emptyParam.put("location_id", "");
						emptyParam.put("resource_class", "");
						emptyParam.put("resource_id", "");
					}
					if (eventType.equals("OA21") || eventType.equals("OA23")){
						emptyParam.put("appointment_start_time", "");
						emptyParam.put("appointment_end_time", "");
					}
					if (eventType.equals("OA22")){
						emptyParam.put("cancel_reason_code", "");
						emptyParam.put("cancel_reason_desc", "");
					}
					if (eventType.equals("OA23")){
						emptyParam.put("transfer_start_date_time", "");
						emptyParam.put("transfer_end_date_time", "");
						emptyParam.put("transfer_reason_code", "");
						emptyParam.put("transfer_reason_desc", "");
					}
					if (eventType.equals("OA21")){	
						emptyParam.put("patient_id", "");
						emptyParam.put("country_code", "");
						emptyParam.put("patient_name", "");
						emptyParam.put("patient_gender", "");
						emptyParam.put("patient_mobile", "");						
						emptyParam.put("patient_dob", "");
						emptyParam.put("appointment_type", "");
					}					
					emptyParam.put("original_appointment_id", "");
					emptyParam.put("patient_email", "");
					

					ArrayList<Map<String, String>> emptyApptDtls = new ArrayList<Map<String, String>>();
					emptyApptDtls.add(emptyParam);

					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("request_type", l_request_type);
					l_response_json.put("request_date_time", l_request_date_time);
					l_response_json.put("request_data", emptyApptDtls);

					l_responseJsonString = objMapper.writeValueAsString(l_response_json);

					l_app_msg = " ::: Inserting Request into Message Table - Appointment record does not exists ::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					
					l_errcd = "E";

					params.put("MESSAGE_ACK_TEXT",
							l_responseJsonString.toString());

					return l_errcd + "$!^" +l_status_desc +  "$!^" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";

				}

				if (l_errcd.equals("S")) {
					l_status = "1";
					msgGenFlag = "S";
					l_status_desc = "Data successfully retrieved";
					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("request_type", l_request_type);
					l_response_json.put("request_date_time", l_request_date_time);
					l_response_json.put("request_data", fetchedApptDetls);

					l_responseJsonString = objMapper
							.writeValueAsString(l_response_json);

					l_app_msg = " ::: Inserting Request into Message Table - Appointment Data successfully retrieved::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					l_app_msg = " ::: Response Appointment successfully retrieved ::: \n "
							+ l_responseJsonString.toString();
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					
					l_response_str = TransCommunicationMethod(l_protocol_link_id, eventType, l_responseJsonString, l_action_type, l_application_id, dbConn);
					
					l_response_str = l_response_str.replace("$!^","^!^");
					l_app_msg = " ::: Response String after replacement ::: \n "
							+ l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					

					st = new StringTokenizer(l_response_str, delims );

					tokenD = new ArrayList<String>();

					while (st.hasMoreElements()) 
					{
						tokenD.add(st.nextToken());	
					}	

					if (tokenD.size()>0)
					{
						l_errcd = tokenD.get(0);
						l_status_desc = tokenD.get(1);
						l_response_str = tokenD.get(2);
					} 
					
					return l_errcd + "$!^" +l_status_desc +  "$!^" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";
				}
				else {
					l_errcd = "E";
					l_status = "0";
					l_status_desc = "Appointment record does not exists ";
					
					msgGenFlag = "E";

					Map<String, String> emptyParam = new LinkedHashMap<String, String>();
					emptyParam.put("appointment_id", "");
					emptyParam.put("facility_id", "");
					emptyParam.put("speciality_id", "");
					emptyParam.put("location_id", "");
					emptyParam.put("doctor_id", "");
					emptyParam.put("appointment_start_time", "");
					emptyParam.put("appointment_end_time", "");
					if (eventType.equals("OA23")){
						emptyParam.put("transfer_start_date_time", "");
						emptyParam.put("transfer_end_date_time", "");
					}
					emptyParam.put("patient_id", "");
					emptyParam.put("country_code", "");
					emptyParam.put("patient_name", "");
					emptyParam.put("patient_gender", "");
					emptyParam.put("patient_mobile", "");
					emptyParam.put("patient_email", "");
					emptyParam.put("patient_dob", "");
					emptyParam.put("appointment_type", "");
					emptyParam.put("original_appointment_id", "");	

					ArrayList<Map<String, String>> emptyApptDtls = new ArrayList<Map<String, String>>();
					emptyApptDtls.add(emptyParam);

					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("request_type", l_request_type);
					l_response_json.put("request_date_time",
							l_request_date_time);
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);
					l_response_json.put("request_data", emptyApptDtls);

					l_responseJsonString = objMapper
							.writeValueAsString(l_response_json);

					l_app_msg = " ::: Inserting Request into Message Table Master Clinic record does not exists::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					l_errcd = "E";

					params.put("MESSAGE_ACK_TEXT",
							l_responseJsonString.toString());

					return l_errcd + "$!^" +l_status_desc +  "$!^" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";

				}

			} 
			String l_merge_trn_id = "";
			if (l_request_type.equals("MRGPAT")) {
				if (l_all_flag.equals("I")) {
					l_merge_trn_id = FieldValueFetchMethod(actionKey,
							"merge_trn_id=", null, l_field_separator,
							"processRequest");
					l_merge_trn_id = l_merge_trn_id.trim();
					if (l_merge_trn_id.indexOf("Error") >= 0
							|| l_merge_trn_id.trim().equals("")) {
						l_errcd = "E";
						l_error.append(" - Merge Transaction Id");
					}

					l_app_msg = " ::: Merge Transcation Id ::: " + l_merge_trn_id;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					if (l_errcd.equals("E")) {
						return l_errcd + "$!^" +l_error.toString() +  "$!^" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";
					}

					l_facility_id = FieldValueFetchMethod(actionKey,
							"facility_id=", null, l_field_separator,
							"processRequest");
					l_facility_id = l_facility_id.trim();
					if (l_facility_id.indexOf("Error") >= 0
							|| l_facility_id.trim().equals("")) {
						l_errcd = "E";
						l_error.append(" - Facility Id");
					}

					l_app_msg = " ::: Facility Id ::: " + l_facility_id;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					if (l_errcd.equals("E")) {
						return l_errcd + "$!^" +l_error.toString() +  "$!^" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";
					}

				} else {
					l_merge_trn_id = "";
					l_facility_id = "";
				}

				// Request ends here

				fetchedMrgPatDetls = FetchMrgPatDetails(l_facility_id, l_merge_trn_id, l_all_flag, dbConn);

				if (fetchedMrgPatDetls.isEmpty()) {
					l_errcd = "E";
					l_status = "0";
					l_status_desc = "Merged Patient record does not exists";
					msgGenFlag = "E";

					Map<String, String> emptyParam = new LinkedHashMap<String, String>();
					emptyParam.put("first_name", "");
					emptyParam.put("second_name", "");
					emptyParam.put("third_name", "");
					emptyParam.put("gender", "");
					emptyParam.put("date_of_birth", "");
					emptyParam.put("mobile_no", "");
					emptyParam.put("nationality_code", "");
					emptyParam.put("nationality_desc", "");
					emptyParam.put("address_line_1", "");
					emptyParam.put("address_line_2", "");
					emptyParam.put("town_code", "");
					emptyParam.put("town_desc", "");
					emptyParam.put("area_code", "");
					emptyParam.put("area_desc", "");
					emptyParam.put("region_code", "");
					emptyParam.put("region_desc", "");
					emptyParam.put("postal_code", "");
					emptyParam.put("country_code", "");
					emptyParam.put("country_desc", "");
					emptyParam.put("email_id", "");
					emptyParam.put("identification_type_code", "");
					emptyParam.put("identification_type_desc", "");
					emptyParam.put("identification_id", "");
					emptyParam.put("facility_id", "");
					emptyParam.put("patient_id", "");
					emptyParam.put("active_yn", "");
					emptyParam.put("suspend_yn", "");
					emptyParam.put("deceased_yn", "");
					emptyParam.put("deceased_date", "");
					emptyParam.put("blng_grp_id", "");

					ArrayList<Map<String, String>> emptyPatientDtls = new ArrayList<Map<String, String>>();
					emptyPatientDtls.add(emptyParam);

					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("request_type", l_request_type);
					l_response_json.put("request_date_time", l_request_date_time);
					l_response_json.put("request_data", emptyPatientDtls);

					l_responseJsonString = objMapper.writeValueAsString(l_response_json);

					l_app_msg = " ::: Inserting Request into Message Table Master Patient record does not exists ::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					
					l_errcd = "E";

					params.put("MESSAGE_ACK_TEXT",
							l_responseJsonString.toString());

					return l_errcd + "$!^" +l_status_desc +  "$!^" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";

				}

				if (l_errcd.equals("S")) {
					l_status = "1";
					msgGenFlag = "S";
					l_status_desc = "Data successfully retrieved";
					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("request_type", l_request_type);
					l_response_json.put("request_date_time", l_request_date_time);
					l_response_json.put("request_data", fetchedMrgPatDetls);

					l_responseJsonString = objMapper
							.writeValueAsString(l_response_json);

					l_app_msg = " ::: Inserting Request into Message Table Merge Patient Data successfully retrieved::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					l_app_msg = " ::: Response Merge Patient Data successfully retrieved ::: \n "
							+ l_responseJsonString.toString();
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					
					l_response_str = TransCommunicationMethod(l_protocol_link_id, eventType, l_responseJsonString, l_action_type, l_application_id, dbConn);
					
					l_response_str = l_response_str.replace("$!^","^!^");
					l_app_msg = " ::: Response String after replacement ::: \n "
							+ l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					

					st = new StringTokenizer(l_response_str, delims );

					tokenD = new ArrayList<String>();

					while (st.hasMoreElements()) 
					{
						tokenD.add(st.nextToken());	
					}	

					if (tokenD.size()>0)
					{
						l_errcd = tokenD.get(0);
						l_status_desc = tokenD.get(1);
						l_response_str = tokenD.get(2);
					} 
					
					return l_errcd + "$!^" +l_status_desc +  "$!^" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";
				}
				else {
					l_errcd = "E";
					l_status = "0";
					l_status_desc = "Merge patient record does not exists ";
					
					msgGenFlag = "E";

					Map<String, String> emptyParam = new LinkedHashMap<String, String>();
					emptyParam.put("first_name", "");
					emptyParam.put("second_name", "");
					emptyParam.put("third_name", "");
					emptyParam.put("gender", "");
					emptyParam.put("date_of_birth", "");
					emptyParam.put("mobile_no", "");
					emptyParam.put("nationality_code", "");
					emptyParam.put("nationality_desc", "");
					emptyParam.put("address_line_1", "");
					emptyParam.put("address_line_2", "");
					emptyParam.put("town_code", "");
					emptyParam.put("town_desc", "");
					emptyParam.put("area_code", "");
					emptyParam.put("area_desc", "");
					emptyParam.put("region_code", "");
					emptyParam.put("region_desc", "");
					emptyParam.put("postal_code", "");
					emptyParam.put("country_code", "");
					emptyParam.put("country_desc", "");
					emptyParam.put("patient_email", "");
					emptyParam.put("identification_type_code", "");
					emptyParam.put("identification_type_desc", "");
					emptyParam.put("identification_id", "");
					emptyParam.put("facility_id", "");
					emptyParam.put("patient_id", "");
					emptyParam.put("active_yn", "");
					emptyParam.put("suspend_yn", "");
					emptyParam.put("deceased_yn", "");
					emptyParam.put("deceased_date", "");
					emptyParam.put("blng_grp_id", "");

					ArrayList<Map<String, String>> emptyPatientDtls = new ArrayList<Map<String, String>>();
					emptyPatientDtls.add(emptyParam);

					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("request_type", l_request_type);
					l_response_json.put("request_date_time",
							l_request_date_time);
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);
					l_response_json.put("request_data", emptyPatientDtls);

					l_responseJsonString = objMapper
							.writeValueAsString(l_response_json);

					l_app_msg = " ::: Inserting Request into Message Table Merge Patient record does not exists::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					l_errcd = "E";

					params.put("MESSAGE_ACK_TEXT",
							l_responseJsonString.toString());

					return l_errcd + "$!^" +l_status_desc +  "$!^" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";

				}

			}
			
			String l_encounter_id = "";
            if (l_request_type.equals("REGVISIT")) {
                if (l_all_flag.equals("I")) {
                    l_encounter_id = FieldValueFetchMethod(actionKey, "encounter_id=", null, "&", "processRequest");
                    l_encounter_id = l_encounter_id.trim();
                    
                    if (l_encounter_id.indexOf("Error") >= 0 || l_encounter_id.trim().equals("")) {
                        l_errcd = "E";
                        l_error.append(" encounter Id");
                    }
                    l_app_msg = " :::Encounter ID ::: " + l_encounter_id;
                    
                    if (l_debug_YN.equals("Y"))
                        System.out.println(l_app_msg);
                    
                    if (l_errcd.equals("E")) {
                        
                    	return l_errcd + "$!^" + l_error.toString() + "$!^" + l_responseJsonString + "$!^" + l_response_str + "$!^" + msgGenFlag + "#";
                    }
                    l_facility_id = FieldValueFetchMethod(actionKey, "facility_id=", null, "&", "processRequest");
                    l_facility_id = l_facility_id.trim();
                    if (l_facility_id.indexOf("Error") >= 0 || l_facility_id.trim().equals("")) {
                        l_errcd = "E";
                        l_error.append(" - Facility Id");
                    }
                    l_app_msg = " ::: Facility Id ::: " + l_facility_id;
                    if (l_debug_YN.equals("Y"))
                        System.out.println(l_app_msg);
                    
                    if (l_errcd.equals("E")) {
                        return l_errcd + "$!^" + l_error.toString() + "$!^" + l_responseJsonString + "$!^" + l_response_str + "$!^" + msgGenFlag + "#";
                    }
                }
                else {
                    l_encounter_id = "";
                    l_facility_id = "";
                }
                fetchedVisitDetls = FetchVisitDetails(l_facility_id, l_encounter_id, l_all_flag, dbConn);
                if (fetchedVisitDetls.isEmpty()) {
                    l_errcd = "E";
                    l_status = "0";
                    l_status_desc = "Visit record does not exists";
                    msgGenFlag = "E";
                    Map<String, String> emptyParam = new LinkedHashMap<String, String>();
                    emptyParam.put("facility_id", "");
                    emptyParam.put("patient_id", "");
                    emptyParam.put("original_appointment_id", "");
                    emptyParam.put("appointment_id", "");
                    emptyParam.put("encounter_id", "");   
                    emptyParam.put("speciality_id", "");                    
                    emptyParam.put("location_id", "");
                    emptyParam.put("resource_class", "");
                    emptyParam.put("resource_id", "");
                    emptyParam.put("consult_start_time", "");
                    emptyParam.put("consult_end_time", "");
                    emptyParam.put("patient_name", "");
                    emptyParam.put("patient_gender", "");
                    emptyParam.put("patient_age", "");
                    emptyParam.put("patient_mobile", "");
                    emptyParam.put("patient_email", "");
                    emptyParam.put("appointment_type", "");
                    emptyParam.put("visit_status", "");
                    emptyParam.put("notes", "");
                    emptyParam.put("blng_grp_id", "");
                    emptyParam.put("visit_type", "");
                    ArrayList<Map<String, String>> emptyVisitDtls = new ArrayList<Map<String, String>>();
                    emptyVisitDtls.add(emptyParam);
                    l_response_json.put("request_ref_no", l_request_ref_no);
                    l_response_json.put("request_type", l_request_type);
                    l_response_json.put("request_date_time", l_request_date_time);
                    l_response_json.put("request_data", emptyVisitDtls);
                    l_responseJsonString = objMapper.writeValueAsString((Object)l_response_json);
                    l_app_msg = " ::: Inserting Request into Message Table Visit record does not exists ::: ";
                    if (l_debug_YN.equals("Y")) {
                        System.out.println(l_app_msg);
                    }
                    l_errcd = "E";
                    params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
                    return l_errcd + "$!^" + l_status_desc + "$!^" + l_responseJsonString + "$!^" + l_response_str + "$!^" + msgGenFlag + "#";
                }
                if (l_errcd.equals("S")) {
                    l_status = "1";
                    msgGenFlag = "S";
                    l_status_desc = "Data successfully retrieved";
                    l_response_json.put("request_ref_no", l_request_ref_no);
                    l_response_json.put("request_type", l_request_type);
                    l_response_json.put("request_date_time", l_request_date_time);
                    l_response_json.put("request_data", fetchedVisitDetls);
                    l_responseJsonString = objMapper.writeValueAsString((Object)l_response_json);
                    
                    l_app_msg = " ::: Response Visit Data successfully retrieved ::: \n " + l_responseJsonString.toString();
                    if (l_debug_YN.equals("Y")) {
                        System.out.println(l_app_msg);
                    }
                    l_response_str = TransCommunicationMethod(l_protocol_link_id, eventType, l_responseJsonString, l_action_type, l_application_id, dbConn);
                    l_response_str = l_response_str.replace("$!^", "^!^");
                    l_app_msg = " ::: Response String after replacement ::: \n " + l_response_str;
                    if (l_debug_YN.equals("Y")) {
                        System.out.println(l_app_msg);
                    }
                    st = new StringTokenizer(l_response_str, delims);
                    tokenD = new ArrayList<String>();
                    while (st.hasMoreElements()) {
                        tokenD.add(st.nextToken());
                    }
                    if (tokenD.size() > 0) {
                        l_errcd = tokenD.get(0);
                        l_status_desc = tokenD.get(1);
                        l_response_str = tokenD.get(2);
                    }
                    return l_errcd + "$!^" + l_status_desc + "$!^" + l_responseJsonString + "$!^" + l_response_str + "$!^" + msgGenFlag + "#";
                }
                else {
                l_errcd = "E";
                l_status = "0";
                l_status_desc = "Visit record does not exists ";
                msgGenFlag = "E";
                Map<String, String> emptyParam = new LinkedHashMap<String, String>();
                emptyParam.put("facility_id", "");
                emptyParam.put("patient_id", "");
                emptyParam.put("original_appointment_id", "");
                emptyParam.put("appointment_id", "");
                emptyParam.put("location_id", "");
                emptyParam.put("resource_class", "");
                emptyParam.put("resource_id", "");
                emptyParam.put("consult_start_time", "");
                emptyParam.put("consult_end_time", "");
                emptyParam.put("patient_name", "");
                emptyParam.put("patient_gender", "");
                emptyParam.put("patient_age", "");
                emptyParam.put("patient_mobile", "");
                emptyParam.put("patient_email", "");
                emptyParam.put("appointment_type", "");
                emptyParam.put("visit_status", "");
                emptyParam.put("notes", "");
                emptyParam.put("blng_grp_id", "");
                ArrayList<Map<String, String>> emptyVisitDtls = new ArrayList<Map<String, String>>();
                emptyVisitDtls.add(emptyParam);
                l_response_json.put("request_ref_no", l_request_ref_no);
                l_response_json.put("request_type", l_request_type);
                l_response_json.put("request_date_time", l_request_date_time);
                l_response_json.put("request_data", emptyVisitDtls);
                l_responseJsonString = objMapper.writeValueAsString((Object)l_response_json);
                
                l_app_msg = " ::: Inserting Request into Message Table Visit record does not exists::: ";
                if (l_debug_YN.equals("Y")) 
                    System.out.println(l_app_msg);
          
                l_errcd = "E";
                params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
                return l_errcd + "$!^" + l_status_desc + "$!^" + l_responseJsonString + "$!^" + l_response_str + "$!^" + msgGenFlag + "#";
            }
          }

		} catch (Exception e) {
			e.printStackTrace();
			l_errcd = "E";
			l_errmsg = l_errcd + "# Exception Occurred " + e.getMessage();
		}
		finally {
			EMDataSource.returnConnection(dbConn);
		}
		return "200#" + l_responseJsonString +  "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";
	}

	public List<Map<String, String>> FetchPatientDetails(String facility_id, String patient_id, String all_flag, Connection dbConn) {
		//Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Map<String, String>> masterPatientDetls = new ArrayList<Map<String, String>>();
		Map<String, String> params = null;

		String query = "";
		String l_app_msg = "";
		
		String l_element_id = "", l_patient_nat_id_type = "", l_patient_nat_id_desc = "", l_national_id="";

		l_app_msg = " Inside Fetch Patient Details... "	+ patient_id + "::l_all_flag:::" + all_flag;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			
			l_element_id = "PATIENT_NAT_ID_TYPE";
			
			l_patient_nat_id_type = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);
			l_app_msg = " ::: Patient National Type Id: "+l_patient_nat_id_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_element_id = "PATIENT_NAT_ID_DESC";
			
			l_patient_nat_id_desc = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);
			l_app_msg = " ::: Patient National Type Desc: "+l_patient_nat_id_desc;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			//dbConn = EMDataSource.getConnection();

			if (all_flag.equals("A")) {
				query = "select a.patient_id, nvl(first_name,'') first_name, nvl(second_name,'') second_name, nvl(third_name,'') third_name , " +
						"nvl(sex,'') gender, to_char(date_of_birth, 'dd/mm/yyyy') date_of_birth, nvl(replace(contact2_no,'#','$$'),'') mobile_no, " +
						"nvl(nationality_code,'') nationality_code, nvl(b.long_desc,'') nationality_desc, nvl(replace(addr1_line1,'#','$$'),'') address_line_1, " +
						"nvl(replace(addr1_line2,'#','$$'),'') address_line_2, nvl(res_town1_code,'') town_code, nvl(d.short_desc,'') town_desc, " +
						"nvl(res_area1_code,'') area_code, nvl(e.short_desc,'') area_desc, nvl(region1_code,'') region_code, nvl(f.short_desc,'') region_desc, " +
						"nvl(g.short_desc,'') postal_code, nvl(country1_code,'') country_code, nvl(h.short_name,'') country_desc, nvl(replace(email_id,'#','$$'),'') email_id, " +
						"nvl(regn_facility_id,'') regn_facility_id, nvl(active_yn,'') active_yn, nvl(suspend_yn,'') suspend_yn, " +
						"nvl(deceased_yn,'') deceased_yn, to_char(deceased_date, 'dd/mm/yyyy') deceased_date, " +
						"nvl(oth_alt_id_type,'') identification_type_code , nvl(i.long_desc,'') identification_type_desc,  nvl(oth_alt_id_no,'') identification_id, nvl(national_id_no,'') national_id_no,  "+
						"nvl(blng_grp_id,'') blng_grp_id "+
						"from mp_patient a, mp_country b, mp_pat_addresses c, mp_res_town d, mp_res_area e, mp_region f, mp_postal_code g, mp_country h, mp_alternate_id_type i, "+
						" bl_patient_fin_dtls j "+
						"where a.nationality_code = b.country_code(+) and a.patient_id = c.patient_id(+) and c.addr1_type = 'RES' " +
						"and res_town1_code = d.res_town_code(+) and res_area1_code = d.res_area_code(+) and res_area1_code = e.res_area_code(+) " +
						"and region1_code = f.region_code(+) and postal1_code = g.postal_code(+) and country1_code = h.country_code(+)" +
						"and a.oth_alt_id_type = i.alt_id_type(+) and a.patient_id = j.patient_id(+)";

				pstmt = dbConn.prepareStatement(query);
				rs = pstmt.executeQuery();
			}
			else if (all_flag.equals("I")) {

				l_app_msg = "::: Fetch Patient Details - inside record retrieval ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				query = "select a.patient_id, nvl(first_name,'') first_name, nvl(second_name,'') second_name, nvl(third_name,'') third_name , " +
						"nvl(sex,'') gender, to_char(date_of_birth, 'dd/mm/yyyy') date_of_birth, nvl(replace(contact2_no,'#','$$'),'') mobile_no, " +
						"nvl(nationality_code,'') nationality_code, nvl(b.long_desc,'') nationality_desc, nvl(replace(addr1_line1,'#','$$'),'') address_line_1, " +
						"nvl(replace(addr1_line2,'#','$$'),'') address_line_2, nvl(res_town1_code,'') town_code, nvl(d.short_desc,'') town_desc, " +
						"nvl(res_area1_code,'') area_code, nvl(e.short_desc,'') area_desc, nvl(region1_code,'') region_code, nvl(f.short_desc,'') region_desc, " +
						"nvl(g.short_desc,'') postal_code, nvl(country1_code,'') country_code, nvl(h.short_name,'') country_desc, nvl(replace(email_id,'#','$$'),'') email_id, " +
						"nvl(regn_facility_id,'') regn_facility_id, nvl(active_yn,'') active_yn, nvl(suspend_yn,'') suspend_yn, " +
						"nvl(deceased_yn,'') deceased_yn, to_char(deceased_date, 'dd/mm/yyyy') deceased_date, " +
						"nvl(oth_alt_id_type,'') identification_type_code , nvl(i.long_desc,'') identification_type_desc,  nvl(oth_alt_id_no,'') identification_id, nvl(national_id_no,'') national_id_no,  "+
						"nvl(blng_grp_id,'') blng_grp_id "+
						"from mp_patient a, mp_country b, mp_pat_addresses c, mp_res_town d, mp_res_area e, mp_region f, mp_postal_code g, mp_country h, mp_alternate_id_type i, "+
						" bl_patient_fin_dtls j "+
						"where a.nationality_code = b.country_code(+) and a.patient_id = c.patient_id(+) and c.addr1_type = 'RES' " +
						"and res_town1_code = d.res_town_code(+) and res_area1_code = d.res_area_code(+) and res_area1_code = e.res_area_code(+) " +
						"and region1_code = f.region_code(+) and postal1_code = g.postal_code(+) and country1_code = h.country_code(+)" +
						"and a.oth_alt_id_type = i.alt_id_type(+) and a.patient_id = j.patient_id(+) and a.patient_id = ?";

				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, patient_id);
				rs = pstmt.executeQuery();
			}

			l_app_msg = "::: rs ::: " + rs;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);			

			while (rs.next()) {			
				params = new LinkedHashMap<String, String>();
				params.put("first_name", rs.getString("first_name")== null?"":rs.getString("first_name"));
				params.put("second_name", rs.getString("second_name")== null?"":rs.getString("second_name"));
				params.put("third_name", rs.getString("third_name")== null?"":rs.getString("third_name"));
				params.put("gender", rs.getString("gender")== null?"":rs.getString("gender"));
				params.put("date_of_birth", rs.getString("date_of_birth")== null?"":rs.getString("date_of_birth"));	
				params.put("mobile_no", rs.getString("mobile_no")== null?"":rs.getString("mobile_no"));
				params.put("nationality_code", rs.getString("nationality_code")== null?"":rs.getString("nationality_code"));
				params.put("nationality_desc", rs.getString("nationality_desc")== null?"":rs.getString("nationality_desc"));;
				params.put("address_line_1", rs.getString("address_line_1")== null?"":rs.getString("address_line_1"));
				params.put("address_line_2", rs.getString("address_line_2")== null?"":rs.getString("address_line_2"));
				params.put("town_code", rs.getString("town_code")== null?"":rs.getString("town_code"));
				params.put("town_desc", rs.getString("town_desc")== null?"":rs.getString("town_desc"));
				params.put("area_code", rs.getString("area_code")== null?"":rs.getString("area_code"));
				params.put("area_desc", rs.getString("area_desc")== null?"":rs.getString("area_desc"));
				params.put("region_code", rs.getString("region_code")== null?"":rs.getString("region_code"));
				params.put("region_desc", rs.getString("region_desc")== null?"":rs.getString("region_desc"));
				params.put("postal_code", rs.getString("postal_code")== null?"":rs.getString("postal_code"));
				params.put("country_code", rs.getString("country_code")== null?"":rs.getString("country_code"));
				params.put("country_desc", rs.getString("country_desc")== null?"":rs.getString("country_desc"));
				params.put("patient_email", rs.getString("email_id")== null?"":rs.getString("email_id"));
				params.put("blng_grp_id", rs.getString("blng_grp_id")== null?"":rs.getString("blng_grp_id"));
				l_national_id = rs.getString("national_id_no")== null?"":rs.getString("national_id_no");				
				if (l_national_id.length()>0)
				{
					params.put("identification_type_code", l_patient_nat_id_type);
					params.put("identification_type_desc", l_patient_nat_id_desc);
					params.put("identification_id", l_national_id);
				}
				else
				{
					params.put("identification_type_code", rs.getString("identification_type_code")== null?"":rs.getString("identification_type_code"));
					params.put("identification_type_desc", rs.getString("identification_type_desc")== null?"":rs.getString("identification_type_desc"));
					params.put("identification_id", rs.getString("identification_id")== null?"":rs.getString("identification_id"));
				}				
				
				params.put("facility_id", rs.getString("regn_facility_id"));
				params.put("patient_id", rs.getString("patient_id")== null?"":rs.getString("patient_id"));
				params.put("active_yn", rs.getString("active_yn")== null?"":rs.getString("active_yn"));
				params.put("suspend_yn", rs.getString("suspend_yn")== null?"":rs.getString("suspend_yn"));
				params.put("deceased_yn", rs.getString("deceased_yn")== null?"":rs.getString("deceased_yn"));
				params.put("deceased_date", rs.getString("deceased_date")== null?"":rs.getString("deceased_date"));
				masterPatientDetls.add(params);
			}
			
			l_app_msg = "::: Patient National Id ::: " + l_national_id + " National Id Type : "+l_patient_nat_id_type+ " National Id Type Desc: "+l_patient_nat_id_desc;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_app_msg = "::: Fetched Patient Details ::: " + masterPatientDetls;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

		} catch (Exception e) {
			params = new LinkedHashMap<String, String>();
			l_app_msg = "Error in Fetching Patient Details - " + e.getMessage();
			params.put("Error", l_app_msg);

			e.printStackTrace();
			masterPatientDetls.add(params);
		} finally {
			
			XHUtil.closeDBResources(rs, pstmt, null);
			//EMDataSource.returnConnection(dbConn);
		}
		return masterPatientDetls;
	}	
	
	public List<Map<String, String>> FetchAppointmentDetails(String facility_id, String appt_id, String patient_id, String all_flag, String event_type, Connection dbConn) {
		//Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Map<String, String>> apptDetails = new ArrayList<Map<String, String>>();
		Map<String, String> params = null;

		String query = "";
		String l_app_msg = "";

		l_app_msg = " Inside Fetch Appointment Details... Facility Id... " + facility_id+ " Appointment Id... "	+ appt_id + " Patient Id... "+ patient_id+ "::l_all_flag:::" + all_flag+ "::Event_Type:::" + event_type;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			//dbConn = EMDataSource.getConnection();

			if (all_flag.equals("A")) {
				if (event_type.equals("OA21")){
					query = "select facility_id, appt_ref_no appointment_id, nvl(clinic_code,'') location_id, " +
							"a.resource_class, decode(a.resource_class,'R','Room','P','Practitioner') resource_desc, nvl(a.practitioner_id,'') resource_id, " +
							"to_char(appt_date,'dd/mm/yyyy')|| ' '||to_char(appt_slab_from_time, 'HH24:MI:SS') appointment_start_time, " +
							"to_char(appt_date,'dd/mm/yyyy')|| ' '||to_char(appt_slab_to_time, 'HH24:MI:SS') appointment_end_time, " +
							"nvl(patient_id,'') patient_id, nvl(country_code,'')  country_code, nvl(patient_name,'') patient_name, " +
							"nvl(gender,'')  patient_gender, to_char(trunc(sysdate),'yyyy')-to_char(date_of_birth,'yyyy') patient_age, nvl(to_char(date_of_birth,'dd/mm/yyyy'),'')  patient_dob, " +
							"nvl(oth_contact_no,'')  patient_mobile,  nvl(email_id,'')  patient_email, nvl(ext_appt_ref_no,'')  ext_appointment_id, " +
							"nvl(speciality_code,'')  speciality_id, nvl(appt_type_code,'') appointment_type, a.contact_reason_code reason_code , d.contact_reason reason_desc " +
							"From oa_appt a, am_contact_reason d " +
							"Where a.contact_reason_code = d.contact_reason_code(+) and a.facility_id = ? " ;
				}
				if (event_type.equals("OA23")){
					query = "select facility_id, appointment_id, location_id, " +
							"a.resource_class, decode(a.resource_class,'R','Room','P','Practitioner') resource_desc, nvl(a.practitioner_id,'') resource_id, " +
							"appointment_start_time, appointment_end_time, " +
							"tr_appointment_start_time, tr_appointment_end_time, patient_id, country_code, patient_name, patient_gender, " +
							"patient_age, patient_dob, patient_mobile,  patient_email, ext_appointment_id, speciality_id, appointment_type, " +
							"reason_code, reason_desc " +
							"from (select a.facility_id, a.appt_ref_no appointment_id, nvl(a.clinic_code,'') location_id, " +
							"nvl(a.practitioner_id,'')  doctor_id, " +
							"to_char(b.appt_date, 'dd/mm/yyyy') || ' ' ||substr(to_char(b.appt_slab_from_time, 'dd/mm/yyyy hh24:mi:ss'),12) appointment_start_time, " +
							"to_char(b.appt_date, 'dd/mm/yyyy') || ' ' ||substr(to_char(b.appt_slab_to_time, 'dd/mm/yyyy hh24:mi:ss'),12) appointment_end_time, " +
							"to_char(b.appt_tr_date, 'dd/mm/yyyy') || ' ' ||substr(to_char(b.tr_appt_slab_from_time, 'dd/mm/yyyy hh24:mi:ss'),12) tr_appointment_start_time, " +
							"to_char(b.appt_tr_date, 'dd/mm/yyyy') || ' ' ||substr(to_char(b.tr_appt_slab_to_time, 'dd/mm/yyyy hh24:mi:ss'),12) tr_appointment_end_time, " +
							"nvl(a.patient_id,'') patient_id, nvl(a.country_code,'') country_code, nvl(a.patient_name,'') patient_name, nvl(a.gender,'') patient_gender, " +
							"to_char(trunc(sysdate),'yyyy')-to_char(a.date_of_birth,'yyyy') patient_age, nvl(to_char(a.date_of_birth,'dd/mm/yyyy'),'') patient_dob, " +
							"nvl(a.oth_contact_no,'') patient_mobile, nvl(a.email_id,'') patient_email, nvl(a.ext_appt_ref_no,'') ext_appointment_id, " +
							"nvl(a.speciality_code,'')  speciality_id, nvl(a.appt_type_code,'') appointment_type, a.reason_for_transfer reason_code , d.contact_reason reason_desc, " +
							"row_number() over(partition by a.appt_ref_no order by b.appt_slab_from_time desc) rank_event_dt " +
							"from oa_appt a, oa_appt_del_tr b, mp_country c, am_contact_reason d where appt_tr_date is not null " +
							"and a.appt_ref_no = b.appt_ref_no and a.country_code = c.country_code(+) and b.reason_for_transfer = d.contact_reason_code(+)) " +
							"where rank_event_dt = 1 and facility_id = ? ";
				}	
				if (event_type.equals("OA22")){
					query = "select a.facility_id, a.appt_ref_no appointment_id, nvl(a.clinic_code,'') location_id, " +
							"a.resource_class, decode(a.resource_class,'R','Room','P','Practitioner') resource_desc, nvl(a.practitioner_id,'') resource_id, " +
							"to_char(appt_date, 'dd/mm/yyyy') || ' ' ||substr(to_char(appt_slab_from_time, 'dd/mm/yyyy hh24:mi:ss'),12) appointment_start_time, " +
							"to_char(appt_date, 'dd/mm/yyyy') || ' ' ||substr(to_char(appt_slab_to_time, 'dd/mm/yyyy hh24:mi:ss'),12) appointment_end_time, " +
							"to_char(appt_tr_date, 'dd/mm/yyyy') || ' ' ||substr(to_char(tr_appt_slab_from_time, 'dd/mm/yyyy hh24:mi:ss'),12) tr_appointment_start_time, " +
							"to_char(appt_tr_date, 'dd/mm/yyyy') || ' ' ||substr(to_char(tr_appt_slab_to_time, 'dd/mm/yyyy hh24:mi:ss'),12) tr_appointment_end_time, " +
							"nvl(a.patient_id,'') patient_id, nvl(a.country_code,'')  country_code, nvl(a.patient_name,'') patient_name, " +
							"nvl(a.gender,'')  patient_gender, to_char(trunc(sysdate),'yyyy')-to_char(a.date_of_birth,'yyyy') patient_age, " +
							"nvl(to_char(a.date_of_birth,'dd/mm/yyyy'),'')  patient_dob, nvl(a.oth_contact_no,'')  patient_mobile,  " +
							"nvl(a.email_id,'')  patient_email, nvl(a.ext_appt_ref_no,'')  ext_appointment_id, nvl(a.speciality_code,'')  speciality_id, " +
							"nvl(a.appt_type_code,'') appointment_type, a.reason_for_cancel reason_code , d.contact_reason reason_desc " +
							"from oa_appt_del_tr a, mp_country c, am_contact_reason d " +
							"where a.country_code = c.country_code(+) and a.reason_for_cancel = d.contact_reason_code(+) " +
							"and a.facility_id = ? and a.appt_status = 'C' ";				
				}
				
				if (patient_id.length()>0)
					query = query + " and patient_id = ? ";		
				
				query = query + " order by appointment_start_time asc";
				
				l_app_msg = "::: Fetch appointment Details - Query ::: "+query;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, facility_id);	
				
				if (patient_id.length()>0)
					pstmt.setString(2, patient_id);			
				
				rs = pstmt.executeQuery();
			}
			else if (all_flag.equals("I")) {

				l_app_msg = "::: Fetch appointment Details - inside record retrieval ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				if (event_type.equals("OA21")){

					query = "select facility_id, appt_ref_no appointment_id, nvl(clinic_code,'') location_id, " +
							"a.resource_class, decode(a.resource_class,'R','Room','P','Practitioner') resource_desc, nvl(a.practitioner_id,'') resource_id, " +
							"to_char(appt_date,'dd/mm/yyyy')|| ' '||to_char(appt_slab_from_time, 'HH24:MI:SS') appointment_start_time, " +
							"to_char(appt_date,'dd/mm/yyyy')|| ' '||to_char(appt_slab_to_time, 'HH24:MI:SS') appointment_end_time, " +
							"nvl(patient_id,'') patient_id, nvl(country_code,'')  country_code, nvl(patient_name,'') patient_name, " +
							"nvl(gender,'')  patient_gender, to_char(trunc(sysdate),'yyyy')-to_char(date_of_birth,'yyyy') patient_age, " +
							"nvl(to_char(date_of_birth,'dd/mm/yyyy'),'')  patient_dob, " +
							"nvl(oth_contact_no,'')  patient_mobile,  nvl(email_id,'')  patient_email, nvl(ext_appt_ref_no,'')  ext_appointment_id, " +
							"nvl(speciality_code,'')  speciality_id, nvl(appt_type_code,'') appointment_type, a.contact_reason_code reason_code , d.contact_reason reason_desc " +
							"From oa_appt a, am_contact_reason d " +
							"Where a.contact_reason_code = d.contact_reason_code(+) and a.facility_id = ? and a.appt_ref_no = ? ";
				}
				if (event_type.equals("OA23")){
					query = "select facility_id, appointment_id, location_id, " +
							"resource_class, resource_desc, resource_id, " +
							"appointment_start_time, appointment_end_time, " +
							"tr_appointment_start_time, tr_appointment_end_time, patient_id, country_code, patient_name, patient_gender, " +
							"patient_age, patient_dob, patient_mobile,  patient_email, ext_appointment_id, speciality_id, appointment_type, " +
							"reason_code, reason_desc " +
							"from (select a.facility_id, a.appt_ref_no appointment_id, nvl(a.clinic_code,'') location_id, " +
							"a.resource_class, decode(a.resource_class,'R','Room','P','Practitioner','E','Equipment','Other','Equipment') resource_desc, nvl(a.practitioner_id,'') resource_id, " +
							"to_char(b.appt_date, 'dd/mm/yyyy') || ' ' ||substr(to_char(b.appt_slab_from_time, 'dd/mm/yyyy hh24:mi:ss'),12) appointment_start_time, " +
							"to_char(b.appt_date, 'dd/mm/yyyy') || ' ' ||substr(to_char(b.appt_slab_to_time, 'dd/mm/yyyy hh24:mi:ss'),12) appointment_end_time, " +
							"to_char(b.appt_tr_date, 'dd/mm/yyyy') || ' ' ||substr(to_char(b.tr_appt_slab_from_time, 'dd/mm/yyyy hh24:mi:ss'),12) tr_appointment_start_time, " +
							"to_char(b.appt_tr_date, 'dd/mm/yyyy') || ' ' ||substr(to_char(b.tr_appt_slab_to_time, 'dd/mm/yyyy hh24:mi:ss'),12) tr_appointment_end_time, " +
							"nvl(a.patient_id,'') patient_id, nvl(a.country_code,'') country_code, nvl(a.patient_name,'') patient_name, nvl(a.gender,'') patient_gender, " +
							"to_char(trunc(sysdate),'yyyy')-to_char(a.date_of_birth,'yyyy') patient_age, nvl(to_char(a.date_of_birth,'dd/mm/yyyy'),'') patient_dob, " +
							"nvl(a.oth_contact_no,'') patient_mobile, nvl(a.email_id,'') patient_email, nvl(a.ext_appt_ref_no,'') ext_appointment_id, " +
							"nvl(a.speciality_code,'')  speciality_id, nvl(a.appt_type_code,'') appointment_type, b.reason_for_transfer reason_code, d.contact_reason reason_desc, " +
							"row_number() over(partition by a.appt_ref_no order by b.appt_slab_from_time desc) rank_event_dt " +
							"from oa_appt a, oa_appt_del_tr b, mp_country c, am_contact_reason d where appt_tr_date is not null " +
							"and a.appt_ref_no = b.appt_ref_no and a.country_code = c.country_code(+) and b.reason_for_transfer = d.contact_reason_code(+)) " +
							"where rank_event_dt = 1 and facility_id = ? and appointment_id = ? ";				
				}	
				if (event_type.equals("OA22")){
					query = "select a.facility_id, a.appt_ref_no appointment_id, nvl(a.clinic_code,'') location_id, " +
							"a.resource_class, decode(a.resource_class,'R','Room','P','Practitioner') resource_desc, nvl(a.practitioner_id,'') resource_id, " +
							"to_char(appt_date, 'dd/mm/yyyy') || ' ' ||substr(to_char(appt_slab_from_time, 'dd/mm/yyyy hh24:mi:ss'),12) appointment_start_time, " +
							"to_char(appt_date, 'dd/mm/yyyy') || ' ' ||substr(to_char(appt_slab_to_time, 'dd/mm/yyyy hh24:mi:ss'),12) appointment_end_time, " +
							"to_char(appt_tr_date, 'dd/mm/yyyy') || ' ' ||substr(to_char(tr_appt_slab_from_time, 'dd/mm/yyyy hh24:mi:ss'),12) tr_appointment_start_time, " +
							"to_char(appt_tr_date, 'dd/mm/yyyy') || ' ' ||substr(to_char(tr_appt_slab_to_time, 'dd/mm/yyyy hh24:mi:ss'),12) tr_appointment_end_time, " +
							"nvl(a.patient_id,'') patient_id, nvl(a.country_code,'')  country_code, nvl(a.patient_name,'') patient_name, " +
							"nvl(a.gender,'')  patient_gender, to_char(trunc(sysdate),'yyyy')-to_char(a.date_of_birth,'yyyy') patient_age, " +
							"nvl(to_char(a.date_of_birth,'dd/mm/yyyy'),'')  patient_dob, nvl(a.oth_contact_no,'')  patient_mobile,  " +
							"nvl(a.email_id,'')  patient_email, nvl(a.ext_appt_ref_no,'')  ext_appointment_id, nvl(a.speciality_code,'')  speciality_id, " +
							"nvl(a.appt_type_code,'') appointment_type, a.reason_for_cancel reason_code , d.contact_reason reason_desc " +
							"from oa_appt_del_tr a, mp_country c, am_contact_reason d " +
							"where a.country_code = c.country_code(+) and a.reason_for_cancel = d.contact_reason_code(+) " +
							"and a.facility_id = ? and a.appt_ref_no = ? and a.appt_status = 'C' ";				
				}					
				
				if (patient_id.length()>0)
					query = query + " and patient_id = ? ";	
				
				query = query + " order by appointment_start_time asc";
				
				l_app_msg = "::: Fetch appointment Details - Query ::: "+query;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, facility_id);
				pstmt.setString(2, appt_id);

				if (patient_id.length()>0)
					pstmt.setString(3, patient_id);
				
				rs = pstmt.executeQuery();
			}
	
			while (rs.next()) {			
				params = new LinkedHashMap<String, String>();
				params.put("appointment_id", rs.getString("appointment_id")== null?"":rs.getString("appointment_id"));
				params.put("facility_id", rs.getString("facility_id")== null?"":rs.getString("facility_id"));
				if (event_type.equals("OA21"))
				{
					params.put("speciality_id", rs.getString("speciality_id")== null?"":rs.getString("speciality_id"));
					params.put("location_id", rs.getString("location_id")== null?"":rs.getString("location_id"));
					params.put("resource_class", rs.getString("resource_class")== null?"":rs.getString("resource_class"));	
					params.put("resource_id", rs.getString("resource_id")== null?"":rs.getString("resource_id"));					
					
				}				
				if (event_type.equals("OA21") || event_type.equals("OA23"))
				{
					params.put("appointment_start_time", rs.getString("appointment_start_time")== null?"":rs.getString("appointment_start_time"));
					params.put("appointment_end_time", rs.getString("appointment_end_time")== null?"":rs.getString("appointment_end_time"));
				}
				if (event_type.equals("OA23")){
					params.put("transfer_start_date_time", rs.getString("tr_appointment_start_time")== null?"":rs.getString("tr_appointment_start_time"));
					params.put("transfer_end_date_time", rs.getString("tr_appointment_end_time")== null?"":rs.getString("tr_appointment_end_time"));
				}
				if (event_type.equals("OA21"))
				{
					params.put("patient_id", rs.getString("patient_id")== null?"":rs.getString("patient_id"));;
					params.put("country_code", rs.getString("country_code")== null?"":rs.getString("country_code"));
					params.put("patient_name", rs.getString("patient_name")== null?"":rs.getString("patient_name"));
					params.put("patient_gender", rs.getString("patient_gender")== null?"":rs.getString("patient_gender"));
					params.put("patient_age", rs.getString("patient_age")== null?"":rs.getString("patient_age"));
					params.put("patient_mobile", rs.getString("patient_mobile")== null?"":rs.getString("patient_mobile"));
					params.put("patient_dob", rs.getString("patient_dob")== null?"":rs.getString("patient_dob"));
					params.put("appointment_type", rs.getString("appointment_type")== null?"":rs.getString("appointment_type"));
					params.put("original_appointment_id", rs.getString("ext_appointment_id")== null?"":rs.getString("ext_appointment_id"));
				}				
				if (event_type.equals("OA23"))
				{
					params.put("transfer_reason_code", rs.getString("reason_code")== null?"":rs.getString("reason_code"));
					params.put("transfer_reason_desc", rs.getString("reason_desc")== null?"":rs.getString("reason_desc"));
				}
				if (event_type.equals("OA22"))
				{
					params.put("cancel_reason_code", rs.getString("reason_code")== null?"":rs.getString("reason_code"));
					params.put("cancel_reason_desc", rs.getString("reason_desc")== null?"":rs.getString("reason_desc"));
				}
				if (event_type.equals("OA22") || event_type.equals("OA23"))
				{
					params.put("original_appointment_id", rs.getString("ext_appointment_id")== null?"":rs.getString("ext_appointment_id"));
				}
				params.put("patient_email", rs.getString("patient_email")== null?"":rs.getString("patient_email"));
				apptDetails.add(params);
			}
			l_app_msg = "::: Fetched Appointment Details ::: " + apptDetails;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

		} catch (Exception e) {
			params = new LinkedHashMap<String, String>();
			l_app_msg = "Error in Fetching Patient Details - " + e.getMessage();
			params.put("Error", l_app_msg);

			e.printStackTrace();
			apptDetails.add(params);
		} finally {
			
			XHUtil.closeDBResources(rs, pstmt, null);
			//EMDataSource.returnConnection(dbConn);
		}
		return apptDetails;
	}	
	
	public List<Map<String, String>> FetchMrgPatDetails(String facility_id, String merge_trn_id, String all_flag, Connection dbConn) {
		//Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Map<String, String>> mergePatientDetls = new ArrayList<Map<String, String>>();
		Map<String, String> params = null;

		String query = "";
		String l_app_msg = "";
		
		String l_element_id = "", l_patient_nat_id_type = "", l_patient_nat_id_desc = "", l_national_id="";
		String l_merged_pat_id = "";
				
		l_app_msg = " Inside Fetch Merge Patient Details... "	+ merge_trn_id + "::l_all_flag:::" + all_flag;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			
			l_element_id = "PATIENT_NAT_ID_TYPE";
			
			l_patient_nat_id_type = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);
			l_app_msg = " ::: Patient National Type Id: "+l_patient_nat_id_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_element_id = "PATIENT_NAT_ID_DESC";
			
			l_patient_nat_id_desc = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);
			l_app_msg = " ::: Patient National Type Desc: "+l_patient_nat_id_desc;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			//dbConn = EMDataSource.getConnection();

			if (all_flag.equals("I")) {

				l_app_msg = "::: Fetch Merge Patient Details - inside record retrieval ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				query = "select patient_id from dr_merged_patient_dtls where dup_indicator = 'D' and merge_trn_id = ?";

				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, merge_trn_id);
				rs = pstmt.executeQuery();
				while (rs.next()) {	
					l_merged_pat_id = rs.getString("patient_id")== null?"":rs.getString("patient_id");
				}
				
				l_app_msg = "::: Merged Patient Id... "+l_merged_pat_id;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				query = "select a.patient_id, nvl(first_name,'') first_name, nvl(second_name,'') second_name, nvl(third_name,'') third_name , " +
						"nvl(sex,'') gender, to_char(date_of_birth, 'dd/mm/yyyy') date_of_birth, nvl(replace(contact2_no,'#','$$'),'') mobile_no, " +
						"nvl(nationality_code,'') nationality_code, nvl(b.long_desc,'') nationality_desc, nvl(replace(addr1_line1,'#','$$'),'') address_line_1, " +
						"nvl(replace(addr1_line2,'#','$$'),'') address_line_2, nvl(res_town1_code,'') town_code, nvl(d.short_desc,'') town_desc, " +
						"nvl(res_area1_code,'') area_code, nvl(e.short_desc,'') area_desc, nvl(region1_code,'') region_code, nvl(f.short_desc,'') region_desc, " +
						"nvl(g.short_desc,'') postal_code, nvl(country1_code,'') country_code, nvl(h.short_name,'') country_desc, nvl(replace(email_id,'#','$$'),'') email_id, " +
						"nvl(regn_facility_id,'') regn_facility_id, nvl(active_yn,'') active_yn, nvl(suspend_yn,'') suspend_yn, " +
						"nvl(deceased_yn,'') deceased_yn, to_char(deceased_date, 'dd/mm/yyyy') deceased_date, " +
						"nvl(oth_alt_id_type,'') identification_type_code , nvl(i.long_desc,'') identification_type_desc,  nvl(oth_alt_id_no,'') identification_id, nvl(national_id_no,'') national_id_no  "+
						"from mp_patient a, mp_country b, mp_pat_addresses c, mp_res_town d, mp_res_area e, mp_region f, mp_postal_code g, mp_country h, mp_alternate_id_type i "+
						"where a.nationality_code = b.country_code(+) and a.patient_id = c.patient_id(+) and c.addr1_type = 'RES' " +
						"and res_town1_code = d.res_town_code(+) and res_area1_code = d.res_area_code(+) and res_area1_code = e.res_area_code(+) " +
						"and region1_code = f.region_code(+) and postal1_code = g.postal_code(+) and country1_code = h.country_code(+)" +
						"and a.oth_alt_id_type = i.alt_id_type(+) and a.patient_id in (select patient_id from dr_merged_patient_dtls " +
						"where dup_indicator = 'V' and merge_trn_id = ?)";

				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, merge_trn_id);
				rs = pstmt.executeQuery();
			}

			l_app_msg = "::: rs ::: " + rs;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);			

			while (rs.next()) {			
				params = new LinkedHashMap<String, String>();
				params.put("first_name", rs.getString("first_name")== null?"":rs.getString("first_name"));
				params.put("second_name", rs.getString("second_name")== null?"":rs.getString("second_name"));
				params.put("third_name", rs.getString("third_name")== null?"":rs.getString("third_name"));
				params.put("gender", rs.getString("gender")== null?"":rs.getString("gender"));
				params.put("date_of_birth", rs.getString("date_of_birth")== null?"":rs.getString("date_of_birth"));	
				params.put("mobile_no", rs.getString("mobile_no")== null?"":rs.getString("mobile_no"));
				params.put("nationality_code", rs.getString("nationality_code")== null?"":rs.getString("nationality_code"));
				params.put("nationality_desc", rs.getString("nationality_desc")== null?"":rs.getString("nationality_desc"));;
				params.put("address_line_1", rs.getString("address_line_1")== null?"":rs.getString("address_line_1"));
				params.put("address_line_2", rs.getString("address_line_2")== null?"":rs.getString("address_line_2"));
				params.put("town_code", rs.getString("town_code")== null?"":rs.getString("town_code"));
				params.put("town_desc", rs.getString("town_desc")== null?"":rs.getString("town_desc"));
				params.put("area_code", rs.getString("area_code")== null?"":rs.getString("area_code"));
				params.put("area_desc", rs.getString("area_desc")== null?"":rs.getString("area_desc"));
				params.put("region_code", rs.getString("region_code")== null?"":rs.getString("region_code"));
				params.put("region_desc", rs.getString("region_desc")== null?"":rs.getString("region_desc"));
				params.put("postal_code", rs.getString("postal_code")== null?"":rs.getString("postal_code"));
				params.put("country_code", rs.getString("country_code")== null?"":rs.getString("country_code"));
				params.put("country_desc", rs.getString("country_desc")== null?"":rs.getString("country_desc"));
				params.put("patient_email", rs.getString("email_id")== null?"":rs.getString("email_id"));
				l_national_id = rs.getString("national_id_no")== null?"":rs.getString("national_id_no");				
				if (l_national_id.length()>0)
				{
					params.put("identification_type_code", l_patient_nat_id_type);
					params.put("identification_type_desc", l_patient_nat_id_desc);
					params.put("identification_id", l_national_id);
				}
				else
				{
					params.put("identification_type_code", rs.getString("identification_type_code")== null?"":rs.getString("identification_type_code"));
					params.put("identification_type_desc", rs.getString("identification_type_desc")== null?"":rs.getString("identification_type_desc"));
					params.put("identification_id", rs.getString("identification_id")== null?"":rs.getString("identification_id"));
				}				
				
				params.put("facility_id", rs.getString("regn_facility_id"));
				params.put("patient_id", rs.getString("patient_id")== null?"":rs.getString("patient_id"));
				params.put("active_yn", rs.getString("active_yn")== null?"":rs.getString("active_yn"));
				params.put("suspend_yn", rs.getString("suspend_yn")== null?"":rs.getString("suspend_yn"));
				params.put("deceased_yn", rs.getString("deceased_yn")== null?"":rs.getString("deceased_yn"));
				params.put("deceased_date", rs.getString("deceased_date")== null?"":rs.getString("deceased_date"));
				params.put("merge_patient_id", l_merged_pat_id);
				mergePatientDetls.add(params);
			}
			
			l_app_msg = "::: Patient National Id ::: " + l_national_id + " National Id Type : "+l_patient_nat_id_type+ " National Id Type Desc: "+l_patient_nat_id_desc;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_app_msg = "::: Fetched Merged Patient Details ::: " + mergePatientDetls;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

		} catch (Exception e) {
			params = new LinkedHashMap<String, String>();
			l_app_msg = "Error in Fetching Patient Details - " + e.getMessage();
			params.put("Error", l_app_msg);

			e.printStackTrace();
			mergePatientDetls.add(params);
		} finally {
			
			XHUtil.closeDBResources(rs, pstmt, null);
			//EMDataSource.returnConnection(dbConn);
		}
		return mergePatientDetls;
	}

	public String FieldValueFetchMethod(String message, String identifier,
			String standardCode, String fieldSep, String procID) {

		String l_app_msg = "", l_field_value = "";

		try {

			l_app_msg = " ::: Inside FieldValueFetchMethod ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = " ::: Message : " + message + " ::: Identifier : "
					+ identifier + " ::: Standard Code : " + standardCode;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = " ::: Deriving Field Value..." + identifier;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

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

		if (l_field_value.contains("'")) {
			l_field_value = l_field_value.replaceAll("'", "");
		}

		l_app_msg = " ::: l_field_value ::: " + l_field_value;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		return l_field_value;
	}

	public String FetchStdCntrlSegMethod(String segmentID, String elementId,
			String standardCode, Connection dbConn) {

		//Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		l_app_msg = " ::: Inside FetchStdCntrlSegMethod ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: Segment ID : " + segmentID + " ::: Element ID : "
				+ elementId + " ::: Standard Code : " + standardCode;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: Retrieving " + elementId + " Value...";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			//dbConn = EMDataSource.getConnection();
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

		} catch (Exception e) {
			l_field_value = "Error in " + l_app_msg + " : " + e.getMessage();
		} finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			//EMDataSource.returnConnection(dbConn);
		}
		return l_field_value;
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
					+ "WHERE a.protocol_id = b.protocol_id AND STANDARD_CODE = ? and PROTCOL_MODE = 'O'";

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

			l_app_msg = " ::: Application ID : " + l_application_id
					+ " ::: Protocol Link Id : " + l_protocol_link_id
					+ "::::::::facility_id:::::" + l_facility_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = " ::: Method FetchExternalAppDetails  : "
					+ externalArray;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

		} catch (Exception e) {
			l_application_id = "Error in Fetching External Application Details Exception - "
					+ e.getMessage();
			externalArray.add(l_application_id);
		} finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			//EMDataSource.returnConnection(dbConn);
		}
		return externalArray;
	}
	
	public static String getFormattedStringDate(String format, Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
		String dateFormatted = dateFormat.format(date);
		return dateFormatted;
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
				return l_errmsg;
			} else {
				return "true";
			}
		} catch (Exception e) {
			l_errcd = "E";
			l_errmsg = "Authentication Error! - Exception Occurred - "
					+ e.getMessage();
			if (l_debug_YN.equals("Y"))
				System.out.println(l_errmsg);
			return l_errmsg;
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

			l_app_msg = " ::: l_segment_id ID : " + l_segment_id
					+ " ::: l_standard_code : " + l_standard_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = " ::: Method FetchSegmentDetails  : " + segmentArray;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

		} catch (Exception e) {
			l_segment_id = "Error in Fetching Segment Details Exception - "
					+ e.getMessage();
			segmentArray.add(l_segment_id);
		} finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			//EMDataSource.returnConnection(dbConn);
		}
		return segmentArray;
	}
	
	public String TransCommunicationMethod(String protocolLinkID, String actionKey, String message, String action_type, String application_id, Connection dbConn){
		//Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_element_id = "";


		String l_profile_id = "";
		String l_http_user_agent = "", l_http_content_type = "", l_http_transfer_encoding = "", l_http_soapaction = "", l_url = "";
		int l_http_content_length_flag  = 0;

		String l_request_url = "";

		String l_proxy_server="", l_proxy_port="";

		HttpURLConnection conn = null;

		String l_response_msg = "", l_return_resp = " ", l_security_resp = "";
		
		XHSecurity xhSecurity = null;
		
		StringTokenizer st = null;
		ArrayList<String> tokenD = null;
		String l_errcd = "S";
		
		String l_set_token = "N", l_token_id = "";

		l_app_msg = " ::: Inside TransCommunicationMethod ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Protocol Link ID : "+ protocolLinkID + " ::: Action Key : " + actionKey +" ::: Message : "+message;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = " ::: Fetching Communication Standards ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{
			xhSecurity = new XHSecurity(l_debug_YN, l_segment_id, l_standard_code, application_id);
			
			l_security_resp = xhSecurity.SecurityValidation(protocolLinkID, dbConn);
			l_app_msg = " ::: Security Validation Response : "+l_security_resp;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_security_resp = l_security_resp.replace("$!^", "^!^");

			st = new StringTokenizer(l_security_resp, "^!^");

			tokenD = new ArrayList<String>();

			while (st.hasMoreElements()) {
				tokenD.add(st.nextToken());
			}

			if (tokenD.size() > 0) {
				l_errcd = tokenD.get(0);
				l_set_token = tokenD.get(1);
				l_token_id = tokenD.get(4);
				l_return_resp = tokenD.get(5);
			}	
			
			l_app_msg = " ::: Security token Response : "+l_errcd+ " Set Token : "+l_set_token+ " Token Id: "+l_token_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			if (l_set_token.equalsIgnoreCase("Y"))
			{
				if (l_errcd.equalsIgnoreCase("E"))
				{
					l_return_resp = "E" + "$!^" + "Unable to proceed with the request " +actionKey+" - "+ l_return_resp + "$!^" + l_return_resp;
					return l_return_resp;
				}
			}
			
			//dbConn =  EMDataSource.getConnection();
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

			l_app_msg = "Retrieving Request URL...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = actionKey;

			l_request_url = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);
			l_app_msg = " ::: l_request_url : "+l_request_url;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_request_url.indexOf("Error")>=0)
			{
				return l_request_url;
			}

			l_element_id = "PROXY_SERVER";

			l_proxy_server = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);
			l_app_msg = " ::: l_proxy_server : "+l_proxy_server;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_proxy_server.indexOf("Error")>=0)
			{
				return l_proxy_server;
			}

			l_element_id = "PROXY_PORT";

			l_proxy_port = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);
			l_app_msg = " ::: l_proxy_port : "+l_proxy_port;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_proxy_port.indexOf("Error")>=0)
			{
				return l_proxy_port;
			}

			l_url = l_url.trim();
			l_request_url = l_request_url.trim();			

			l_url = l_url + "/" + l_request_url;

			l_url = l_url.trim();

			if (action_type.equalsIgnoreCase("G"))
				l_url = l_url +"?"+ message;			

			l_app_msg = " ::: BruHealthApp Url :" + l_url;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			URL url = new URL(l_url);

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

			l_app_msg = " ::: Error Code... "+l_errcd+ " Set Token: "+l_set_token;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			if (l_errcd.equalsIgnoreCase("S"))
			{
				if (l_set_token.equalsIgnoreCase("Y"))
				{
					l_app_msg = " ::: Token Set Method...";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					conn.setRequestProperty("Token", l_token_id);
				}					
			}			

			l_app_msg = " ::: Connection Set Method...";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);	
			
			l_app_msg = " ::: Action Type... "+action_type;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (!(action_type.length()>0))
				action_type = "I";
			
			if (action_type.equalsIgnoreCase("I"))
				conn.setRequestMethod("POST");
			
			if (action_type.equalsIgnoreCase("U"))
				conn.setRequestMethod("PUT");
			
			if (action_type.equalsIgnoreCase("D"))
				conn.setRequestMethod("PUT");			

			if (action_type.equalsIgnoreCase("G"))
				conn.setRequestMethod("GET");	
			
			l_app_msg = " ::: Method Set... "+conn.getRequestMethod();
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			// Common Headers for BruHealth Transactions

			if (!(l_http_content_type.equals("XXX")))
			{
				l_app_msg = " ::: Set Property Content-Type...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("Content-Type", l_http_content_type);
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

			if (!(action_type.equalsIgnoreCase("G")))
			{
				l_app_msg = " ::: conn.setDoOutput(true)...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				conn.setDoOutput(true);
	
				l_app_msg = " ::: Writing the request to the OutputStream...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
	
				OutputStream os = conn.getOutputStream();
				os.write(message.getBytes());
				os.flush();			
			}

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
			l_response_msg = "E" +"$!^"+"Error while "+ l_app_msg + " : " +  e.getMessage()+"$!^"+l_return_resp;
			System.out.println(" ::: MalformedURLException ::: " +l_response_msg);			
			return l_response_msg;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			l_response_msg = "E" +"$!^"+"Error while "+ l_app_msg + " : " +  e.getMessage()+"$!^"+l_return_resp;
			System.out.println(" ::: IOException ::: " +l_response_msg);			
			return l_response_msg;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			l_response_msg = "E" +"$!^"+"Error while "+ l_app_msg + " : " +  e.getMessage()+"$!^"+l_return_resp;
			System.out.println(" ::: Exception ::: " +l_response_msg);
			return l_response_msg;
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			//EMDataSource.returnConnection(dbConn);
		}
		l_return_resp = "S"+"$!^"+" "+"$!^"+l_return_resp;
		l_app_msg = " ::: l_return_resp : "+l_return_resp;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		return l_return_resp;
	}
	
	public List<Map<String, String>> FetchVisitDetails(String facility_id, String encounter_id, String all_flag, Connection dbConn) {
        //Connection dbConn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        ArrayList<Map<String, String>> visitRegDetls = new ArrayList<Map<String, String>>();
        Map<String, String> params = null;
        String query = "", l_blng_grp_id = "", l_element_id = "", l_patient_age = "";
        
        l_app_msg = " Inside Fetch Visit Registration Details... " + encounter_id + "::l_all_flag:::" + all_flag;
        if (l_debug_YN.equals("Y")) {
            System.out.println(l_app_msg);
        }
        try {
            l_element_id = "BLNG_GRP_ID";
            l_blng_grp_id = this.FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);
            if (l_debug_YN.equals("Y")) {
                System.out.println(" ::: BLNG_GRP_ID ::: " + l_blng_grp_id);
            }
            //dbConn = EMDataSource.getConnection();
            if (all_flag.equals("I")) {
                l_app_msg = "::: Fetch Visit Registration Details - inside record retrieval ::: ";
                if (l_debug_YN.equals("Y")) {
                    System.out.println(l_app_msg);
                }
                query = "SELECT NVL(a.patient_id,'') patient_id, NVL(a.patient_name,'') patient_name, TO_CHAR (a.date_of_birth, 'dd/mm/yyyy') date_of_birth, nvl(to_char(trunc(sysdate),'yyyy')-to_char(a.date_of_birth,'yyyy'),0) age, "
                		+ "NVL(a.sex,'') sex, NVL(a.email_id, d.email_id) email_id, NVL (a.contact2_no, d.oth_contact_no) contact2_no, "
                		+ "b.facility_id, NVL (b.assign_care_locn_code,'') assign_care_locn_code, nvl(b.encounter_id,'') encounter_id, NVL (b.visit_status,'') visit_status, NVL (b.attend_practitioner_id,'') attend_practitioner_id, "
                		+ "TO_CHAR (c.cons_srvc_start_date_time, 'DD/MM/YYYY HH24:MI:SS') cons_srvc_start_date_time, "
                		+ "TO_CHAR (c.cons_srvc_end_date_time, 'DD/MM/YYYY HH24:MI:SS') cons_srvc_end_date_time, "
                		+ "NVL (d.ext_appt_ref_no,'') ext_appt_ref_no, NVL (d.appt_type_code,'') appt_type_code, NVL (d.resource_class,'') resource_class, "
                		+ "nvl(blng_grp_id,'') blng_grp_id, NVL (d.appt_ref_no,'') appt_ref_no, nvl(specialty_code,'') specialty_code, nvl(appt_case_yn,'') appt_case_yn "
                		+ "FROM mp_patient a, pr_encounter b, op_patient_queue c, oa_appt d, bl_visit_fin_dtls e "
                		+ "WHERE a.patient_id = b.patient_id "
                		+ "and a.patient_id = c.patient_id and b.facility_id = c.facility_id and b.encounter_id = c.encounter_id "
                		+ "and b.patient_id = d.patient_id(+) and b.facility_id = d.facility_id(+) and b.encounter_id = d.encounter_id(+) "
                		+ "and b.facility_id = e.operating_facility_id and b.encounter_id = e.encounter_id "
                		+ "and b.facility_id = ? and b.encounter_id = ? ";
                pstmt = dbConn.prepareStatement(query);
                pstmt.setString(1, facility_id);
                pstmt.setString(2, encounter_id);
                rs = pstmt.executeQuery();
            }
            else {
                l_app_msg = "::: Fetch All Visit Registration Details - inside record retrieval ::: ";
                if (l_debug_YN.equals("Y")) {
                    System.out.println(l_app_msg);
                }
                query = "SELECT NVL(a.patient_id,'') patient_id, NVL(a.patient_name,'') patient_name, TO_CHAR (a.date_of_birth, 'dd/mm/yyyy') date_of_birth, nvl(to_char(trunc(sysdate),'yyyy')-to_char(a.date_of_birth,'yyyy'),0) age, "
                		+ "NVL(a.sex,'') sex, NVL(a.email_id, d.email_id) email_id, NVL (a.contact2_no, d.oth_contact_no) contact2_no, "
                		+ "b.facility_id, NVL (b.assign_care_locn_code,'') assign_care_locn_code, nvl(b.encounter_id,'') encounter_id, NVL (b.visit_status,'') visit_status, NVL (b.attend_practitioner_id,'') attend_practitioner_id, "
                		+ "TO_CHAR (c.cons_srvc_start_date_time, 'DD/MM/YYYY HH24:MI:SS') cons_srvc_start_date_time, "
                		+ "TO_CHAR (c.cons_srvc_end_date_time, 'DD/MM/YYYY HH24:MI:SS') cons_srvc_end_date_time, "
                		+ "NVL (d.ext_appt_ref_no,'') ext_appt_ref_no, NVL (d.appt_type_code,'') appt_type_code, NVL (d.resource_class,'') resource_class, "
                		+ "nvl(blng_grp_id,'') blng_grp_id, NVL (d.appt_ref_no,'') appt_ref_no, nvl(specialty_code,'') specialty_code, nvl(appt_case_yn,'') appt_case_yn "
                		+ "FROM mp_patient a, pr_encounter b, op_patient_queue c, oa_appt d, bl_visit_fin_dtls e "
                		+ "WHERE a.patient_id = b.patient_id "
                		+ "and a.patient_id = c.patient_id and b.facility_id = c.facility_id and b.encounter_id = c.encounter_id "
                		+ "and b.patient_id = d.patient_id(+) and b.facility_id = d.facility_id(+) and b.encounter_id = d.encounter_id(+) ";
                pstmt = dbConn.prepareStatement(query);
                rs = pstmt.executeQuery();
            }
            l_app_msg = "::: rs ::: " + rs;
            if (l_debug_YN.equals("Y")) {
                System.out.println(l_app_msg);
            }
            while (rs.next()) {
                params = new LinkedHashMap<String, String>();
                params.put("facility_id", rs.getString("facility_id"));
                params.put("patient_id", (rs.getString("patient_id") == null) ? "" : rs.getString("patient_id"));
                params.put("original_appointment_id", (rs.getString("ext_appt_ref_no") == null) ? "" : rs.getString("ext_appt_ref_no"));
                params.put("appointment_id", (rs.getString("appt_ref_no") == null) ? "" : rs.getString("appt_ref_no"));
                params.put("encounter_id", (rs.getString("encounter_id") == null) ? "" : rs.getString("encounter_id"));
                params.put("speciality_id", (rs.getString("specialty_code") == null) ? "" : rs.getString("specialty_code"));
                params.put("location_id", (rs.getString("assign_care_locn_code") == null) ? "" : rs.getString("assign_care_locn_code"));
                params.put("resource_class", (rs.getString("resource_class") == null) ? "" : rs.getString("resource_class"));
                params.put("resource_id", (rs.getString("attend_practitioner_id") == null) ? "" : rs.getString("attend_practitioner_id"));
                params.put("consult_start_time", (rs.getString("cons_srvc_start_date_time") == null) ? "" : rs.getString("cons_srvc_start_date_time"));
                params.put("consult_end_time", (rs.getString("cons_srvc_end_date_time") == null) ? "" : rs.getString("cons_srvc_end_date_time"));
                params.put("patient_name", (rs.getString("patient_name") == null) ? "" : rs.getString("patient_name"));
                params.put("patient_gender", (rs.getString("sex") == null) ? "" : rs.getString("sex"));
                l_patient_age = (rs.getString("age") == null) ? "": rs.getString("age");                
                params.put("patient_age", l_patient_age);
                params.put("patient_mobile", (rs.getString("contact2_no") == null) ? "" : rs.getString("contact2_no"));
                params.put("patient_email", (rs.getString("email_id") == null) ? "" : rs.getString("email_id"));
                params.put("appointment_type", (rs.getString("appt_type_code") == null) ? "" : rs.getString("appt_type_code"));
                params.put("visit_status", (rs.getString("visit_status") == null) ? "" : rs.getString("visit_status"));
                params.put("notes","");
                params.put("blng_grp_id", (rs.getString("blng_grp_id") == null) ? "" : rs.getString("blng_grp_id"));
                params.put("visit_type", (rs.getString("appt_case_yn") == null) ? "" : rs.getString("appt_case_yn"));
                visitRegDetls.add(params);
                l_app_msg = "::: Fetched Visit Details ::: " + visitRegDetls;
                if (l_debug_YN.equals("Y")) {
                    System.out.println(l_app_msg);
                }
            }
        }
        catch (Exception e) {
            params = new LinkedHashMap<String, String>();
            l_app_msg = "Error in Fetching Visit Details - " + e.getMessage();
            params.put("Error", l_app_msg);
            e.printStackTrace();
            visitRegDetls.add(params);
            return visitRegDetls;
        }
        finally {
            XHUtil.closeDBResources(rs,pstmt,null);
            //EMDataSource.returnConnection(dbConn);
        }
        return visitRegDetls;
    }
	
	
	
	
}
