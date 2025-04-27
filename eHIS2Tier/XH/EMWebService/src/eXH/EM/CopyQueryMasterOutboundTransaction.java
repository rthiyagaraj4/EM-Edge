package eXH.EM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.CallableStatement;
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
import java.util.StringTokenizer;
import java.util.TimeZone;
import org.codehaus.jackson.map.ObjectMapper;

import eXH.util.EMDataSource;
import eXH.util.XHDBAdapter;
import eXH.util.XHUtil;

public class CopyQueryMasterOutboundTransaction {

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

	public String processOutboundRequest(String actionKey, String key, String eventType, String method) {

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

		Map<String, Object> l_response_json = new HashMap<String, Object>();

		Map<String, Object> l_response_error_json = new HashMap<String, Object>();
		ObjectMapper objMapper = new ObjectMapper();

		String l_status = "0", l_status_desc = "";
		
		String l_return_data = "";

		String msgGenFlag = "E";
		
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
			EMDataSource.returnConnection(dbConn);
		}

		try {

			l_error = new StringBuffer("Unable to Fetch the details - Information Missing");

			l_app_msg = " ::: Inside Query Master details Transactions ::: " + actionKey;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = "::: Validating the request with key ::: " + key;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_response_err_json = validateRequest(key);

			if (l_errcd.equals("E")) {

				l_app_msg = "::: Loading the message when : " + l_err_msg;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				if (method.equals("G")) {
					l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
					l_app_msg = l_app_msg + " : " + l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					return "401#" + l_response_err_json + "#";
				} else {
					return l_errcd + "$!^" + l_response_err_json + "$!^" + l_responseJsonString + "$!^" + l_response_str
							+ "#";
				}

			}

			if (l_errcd.equals("S")) {
				l_app_msg = "::: Fetching Segment Details : ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_segment_details = FetchSegmentDetails(key);

				if (l_segment_id.indexOf("Error") >= 0) {
					l_errmsg = "Fetching Segment Details - " + l_segment_id;
					l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_errmsg + " \"  "
							+ " } ";

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

			l_message_id = GenerateMessageIDMethod("XH_IB_MESSAGE_ID_SEQ");

			if (l_message_id.indexOf("Error") >= 0) {
				l_errmsg = "Message ID Generation - " + l_message_id;
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_errmsg + " \"  "
						+ " } ";

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

				l_protocol_details = FetchAppDetails(l_standard_code);

				if (l_protocol_details.isEmpty()) {
					l_errcd = "E";
					l_errmsg = "Error in Fetching protocol details No Data Available";
					l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_errmsg + " \"  "
							+ " } ";
					return "200#" + l_response_err_json + "#";
				}

				l_application_id = (String) l_protocol_details.get(0);

				if (l_application_id.indexOf("Error") >= 0) {
					l_errmsg = "Fetching protocol Details - " + l_application_id;
					l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_errmsg + " \"  "
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

			if (method.equals("G")) {
				l_response_str = MessageLoadMethod(actionKey, params, l_errcd, "");
				l_app_msg = " ::: Message Load Method  ::: " + l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
			}

			// Request ends here

			l_app_msg = "::: Parsing input message ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_request_ref_no = FieldValueFetchMethod(actionKey, "request_ref_no=", null, l_field_separator,
					"processRequest");
			l_request_ref_no = l_request_ref_no.trim();

			if (l_request_ref_no.indexOf("Error") >= 0 || l_request_ref_no.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - request ref_no ");
			}

			l_app_msg = " ::: l_request_ref_no ::: " + l_request_ref_no;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (l_errcd.equals("E")) {
				l_app_msg = " ::: Inserting Request into Message Table Information Missing ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_error.toString()
						+ " \"  " + " } ";
				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());

				if (method.equals("G")) {
					l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
					l_app_msg = l_app_msg + " : " + l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					return "401#" + l_response_err_json + "#";
				} else {
					return l_errcd + "$!^" + l_response_err_json + "$!^" + l_responseJsonString + "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";
				}
			}

			l_request_type = FieldValueFetchMethod(actionKey, "request_type=", null, l_field_separator,
					"processRequest");
			l_request_type = l_request_type.trim();
			if (l_request_type.indexOf("Error") >= 0 || l_request_type.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - request type ");
			}

			l_app_msg = " ::: l_request_type ::: " + l_request_type;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (l_errcd.equals("E")) {
				l_app_msg = " ::: Inserting Request into Message Table Information Missing ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_error.toString()
						+ " \"  " + " } ";
				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
				if (method.equals("G")) {
					l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
					l_app_msg = l_app_msg + " : " + l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					return "401#" + l_response_err_json + "#";
				} else {
					return l_errcd + "$!^" + l_response_err_json + "$!^" + l_responseJsonString + "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";
				}
			}

			l_request_date_time = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date());
			l_app_msg = " ::: l_request_date_time ::: " + l_request_date_time;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_facility_id = FieldValueFetchMethod(actionKey, "facility_id=", null, l_field_separator, "processRequest");
			l_facility_id = l_facility_id.trim();
			if (l_facility_id.indexOf("Error") >= 0 || l_facility_id.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - facility id");
			}

			l_app_msg = " ::: l_facility_id ::: " + l_facility_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (l_errcd.equals("E")) {
				l_app_msg = " ::: Inserting Request into Message Table Information Missing ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_error.toString()
						+ " \"  " + " } ";
				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
				if (method.equals("G")) {
					l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
					l_app_msg = l_app_msg + " : " + l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					return "401#" + l_response_err_json + "#";
				} else {
					return l_errcd + "$!^" + l_response_err_json + "$!^" + l_responseJsonString + "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";
				}
			}

			l_all_flag = FieldValueFetchMethod(actionKey, "all_flag=", null, l_field_separator, "processRequest");
			l_all_flag = l_all_flag.trim();

			if (l_all_flag.indexOf("Error") >= 0 || l_all_flag.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - all flag");
			}

			l_app_msg = " ::: l_all_flag ::: " + l_all_flag;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (l_errcd.equals("E")) {
				l_app_msg = " ::: Inserting Request into Message Table Information Missing ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_error.toString()
						+ " \"  " + " } ";
				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
				if (method.equals("G")) {
					l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
					l_app_msg = l_app_msg + " : " + l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					return "401#" + l_response_err_json + "#";
				} else {
					return l_errcd + "$!^" + l_response_err_json + "$!^" + l_responseJsonString + "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";
				}
			}

			if (l_request_type.indexOf("Error") >= 0) {
				return "200#" + l_request_type + "#";
			}
			if (l_request_type.equals("CLINICMAST")) {
				
				l_return_data = FetchClinicMast(actionKey, key, eventType, method);
				
				return l_return_data;
				
				/*
				
				
				l_action_type = FieldValueFetchMethod(actionKey, "action_type=", null, l_field_separator,
						"processRequest");
				l_action_type = l_action_type.trim();
				if (l_action_type.indexOf("Error") >= 0 || l_action_type.trim().equals("")) {
					l_action_type = "";
				}

				l_app_msg = " ::: Action Type ::: " + l_action_type;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				if (l_all_flag.equals("I")) {
					l_clinic_code = FieldValueFetchMethod(actionKey, "clinic_code=", null, l_field_separator,
							"processRequest");
					l_clinic_code = l_clinic_code.trim();
					if (l_clinic_code.indexOf("Error") >= 0 || l_clinic_code.trim().equals("")) {
						l_errcd = "E";
						l_error.append(" - clinic code");
					}

					l_app_msg = " ::: l_clinic_code ::: " + l_clinic_code;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					if (l_errcd.equals("E")) {
						l_app_msg = " ::: Inserting Request into Message Table Information Missing ::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" "
								+ l_error.toString() + " \"  " + " } ";
						params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
						if (method.equals("G")) {
							l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
							l_app_msg = l_app_msg + " : " + l_response_str;
							if (l_debug_YN.equals("Y"))
								System.out.println(l_app_msg);
							return "401#" + l_response_err_json + "#";
						} else {
							return l_errcd + "$!^" + l_response_err_json + "$!^" + l_responseJsonString + "$!^"
									+ l_response_str + "$!^" + msgGenFlag + "#";
						}
					}

					l_facility_id = FieldValueFetchMethod(actionKey, "facility_id=", null, l_field_separator,
							"processRequest");
					l_facility_id = l_facility_id.trim();
					if (l_facility_id.indexOf("Error") >= 0 || l_facility_id.trim().equals("")) {
						l_errcd = "E";
						l_error.append(" - Facility Id");
					}
					
					l_app_msg = " ::: l_facility_id ::: " + l_facility_id;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);					

					if (l_errcd.equals("E")) {
						l_app_msg = " ::: Inserting Request into Message Table Information Missing ::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" "
								+ l_error.toString() + " \"  " + " } ";
						params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
						if (method.equals("G")) {
							l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
							l_app_msg = l_app_msg + " : " + l_response_str;
							if (l_debug_YN.equals("Y"))
								System.out.println(l_app_msg);
							return "401#" + l_response_err_json + "#";
						} else {
							return l_errcd + "$!^" + l_response_err_json + "$!^" + l_responseJsonString + "$!^"
									+ l_response_str + "$!^" + msgGenFlag + "#";
						}
					}

				} else {
					l_clinic_code = "";
					l_facility_id = "";
				}

				fetchedClinicDetls = FetchClinicDetails(l_facility_id, l_clinic_code, l_all_flag);

				if (fetchedClinicDetls.isEmpty()) {
					l_errcd = "E";
					l_status = "0";
					l_status_desc = "Clinic record does not exists";
					msgGenFlag = "E";

					Map<String, String> emptyParam = new LinkedHashMap<String, String>();
					emptyParam.put("facility_id", "");
					emptyParam.put("clinic_code", "");
					emptyParam.put("long_desc", "");
					emptyParam.put("short_desc", "");
					emptyParam.put("specialist_clinic_yn", "");
					emptyParam.put("speciality_code", "");
					emptyParam.put("speciality_desc", "");
					emptyParam.put("eff_status", "");

					ArrayList<Map<String, String>> emptyClinicDtls = new ArrayList<Map<String, String>>();
					emptyClinicDtls.add(emptyParam);

					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("request_type", l_request_type);
					l_response_json.put("request_date_time", l_request_date_time);
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);
					l_response_json.put("clinic_data", emptyClinicDtls);

					l_responseJsonString = objMapper.writeValueAsString(l_response_json);

					l_app_msg = " ::: Inserting Request into Message Table Master Clinic record does not exists ::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
					if (method.equals("G")) {
						l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
						l_app_msg = l_app_msg + " : " + l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);

						return "200#" + l_responseJsonString + "#";
					}

					else if (method.equals("P")) {

						return l_errcd + "$!^" + l_status_desc + "$!^" + l_responseJsonString + "$!^" + l_response_str + "$!^" + msgGenFlag + "#";

					}

				}

				if (l_errcd.equals("S")) {
					l_status = "1";
					l_status_desc = "Data successfully retrieved";
					msgGenFlag = "S";
					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("request_type", l_request_type);
					l_response_json.put("request_date_time", l_request_date_time);
					if (method.equals("G")) { 
						l_response_json.put("status", l_status);
						l_response_json.put("status_desc", l_status_desc);
					}
					l_response_json.put("clinic_data", fetchedClinicDetls);

					l_responseJsonString = objMapper.writeValueAsString(l_response_json);

					l_app_msg = " ::: Inserting Request into Message Table Master Clinic Data successfully retrieved::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					l_app_msg = " ::: Response Master Clinic Data successfully retrieved ::: \n "
							+ l_responseJsonString.toString();
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
					if (method.equals("G")) {
						l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
						l_app_msg = l_app_msg + " : " + l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						return "200#" + l_responseJsonString + "#";
					}

					if (method.equals("P")) {
						
						l_app_msg = " ::: Inside Post clinical details::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						
						l_response_str = TransCommunicationMethod(l_protocol_link_id, eventType, l_responseJsonString, l_action_type);
						
						l_app_msg = " ::: After TransCommunication for clinical details... Response Received... "+l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);

						l_response_str = l_response_str.replace("$!^", "^!^");
						
						l_app_msg = " ::: After TransCommunication for clinical details... Response Received After replacement... "+l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);

						st = new StringTokenizer(l_response_str, delims);

						tokenD = new ArrayList<String>();

						while (st.hasMoreElements()) {
							tokenD.add(st.nextToken());
						}
						
						l_app_msg = " ::: After TransCommunication for clinical details..."+tokenD.size();
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);

						if (tokenD.size() > 0) {
							l_errcd = tokenD.get(0);
							l_status_desc = tokenD.get(1);
							l_response_str = tokenD.get(2);
						}

						return l_errcd + "$!^" + l_status_desc + "$!^" + l_responseJsonString + "$!^" + l_response_str + "$!^" + msgGenFlag;

					}

				}

				else {
					l_errcd = "E";
					l_status = "0";
					l_status_desc = "Clinic record does not exists ";
					msgGenFlag = "E";

					Map<String, String> emptyParam = new LinkedHashMap<String, String>();
					emptyParam.put("facility_id", "");
					emptyParam.put("clinic_code", "");
					emptyParam.put("long_desc", "");
					emptyParam.put("short_desc", "");
					emptyParam.put("specialist_clinic_yn", "");
					emptyParam.put("speciality_code", "");
					emptyParam.put("speciality_desc", "");
					emptyParam.put("eff_status", "");

					ArrayList<Map<String, String>> emptyClinicDtls = new ArrayList<Map<String, String>>();
					emptyClinicDtls.add(emptyParam);

					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("request_type", l_request_type);
					l_response_json.put("request_date_time", l_request_date_time);
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);
					l_response_json.put("clinic_data", emptyClinicDtls);

					l_responseJsonString = objMapper.writeValueAsString(l_response_json);

					l_app_msg = " ::: Inserting Request into Message Table Master Clinic record does not exists::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
					if (method.equals("G")) {
						l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
						l_app_msg = l_app_msg + " : " + l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);

						return "200#" + l_responseJsonString + "#";
					}

					else if (method.equals("P")) {

						return l_errcd + "$!^" + l_status_desc + "$!^" + l_responseJsonString + "$!^" + l_response_str + "$!^" + msgGenFlag	+ "#";

					}

				}
				
				*/

			} else if (l_request_type.equals("SPLTYMAST")) {
				
				l_return_data = FetchSpecialityMast(actionKey, key, eventType, method);
				
				return l_return_data;
				
				/*

				l_action_type = FieldValueFetchMethod(actionKey, "action_type=", null, l_field_separator,
						"processRequest");
				l_action_type = l_action_type.trim();
				if (l_action_type.indexOf("Error") >= 0 || l_action_type.trim().equals("")) {
					l_action_type = "";
				}
				
				l_app_msg = " ::: Action Type ::: " + l_action_type;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				if (l_all_flag.equals("I")) {
					l_speciality_code = FieldValueFetchMethod(actionKey, "speciality_code=", null, l_field_separator,
							"processRequest");
					l_speciality_code = l_speciality_code.trim();
					if (l_speciality_code.indexOf("Error") >= 0 || l_speciality_code.trim().equals("")) {
						l_errcd = "E";
						l_error.append(" - Speciality code");
					}

					l_app_msg = " ::: l_speciality_code ::: " + l_speciality_code;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					
					if (l_errcd.equals("E")) {
						l_app_msg = " ::: Inserting Request into Message Table Information Missing ::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" "
								+ l_error.toString() + " \"  " + " } ";
						params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
						if (method.equals("G")) {
							l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
							l_app_msg = l_app_msg + " : " + l_response_str;
							if (l_debug_YN.equals("Y"))
								System.out.println(l_app_msg);
							return "401#" + l_response_err_json + "#";
						} else {
							return l_errcd + "$!^" + l_response_err_json + "$!^" + l_responseJsonString + "$!^"
									+ l_response_str + "$!^" + msgGenFlag + "#";
						}
					}

				} else {
					l_speciality_code = "";
				}

				fetchedSpecialityDetls = FetchSpecDetails(l_speciality_code, l_all_flag);

				if (fetchedSpecialityDetls.isEmpty()) {
					l_errcd = "E";
					l_status = "0";
					l_status_desc = "Speciality record does not exists ";
					msgGenFlag = "E";

					Map<String, String> emptyParam = new LinkedHashMap<String, String>();
					emptyParam.put("speciality_code", "");
					emptyParam.put("long_desc", "");
					emptyParam.put("short_desc", "");
					emptyParam.put("eff_status", "");

					ArrayList<Map<String, String>> emptySpecDtls = new ArrayList<Map<String, String>>();
					emptySpecDtls.add(emptyParam);

					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("request_type", l_request_type);
					l_response_json.put("request_date_time", l_request_date_time);
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);
					l_response_json.put("request_data", emptySpecDtls);

					l_responseJsonString = objMapper.writeValueAsString(l_response_json);

					l_app_msg = " ::: Inserting Request into Message Table Master Speciality record does not exists ::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
					if (method.equals("G")) {
						l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
						l_app_msg = l_app_msg + " : " + l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);

						return "200#" + l_responseJsonString + "#";
					}

					else if (method.equals("P")) {

						return l_errcd + "$!^" + l_status_desc + "$!^" + l_responseJsonString + "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";

					}

				}

				if (l_errcd.equals("S")) {
					l_status = "1";
					l_status_desc = "Data successfully retrieved";
					msgGenFlag = "S";
					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("request_type", l_request_type);
					l_response_json.put("request_date_time", l_request_date_time);
					if (method.equals("G")) {
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);
					}
					l_response_json.put("request_data", fetchedSpecialityDetls);

					l_responseJsonString = objMapper.writeValueAsString(l_response_json);

					l_app_msg = " ::: Inserting Request into Message Table Master Speciality Data successfully retrieved::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					l_app_msg = " ::: Response Master Speciality Data successfully retrieved ::: \n "
							+ l_responseJsonString.toString();
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
					if (method.equals("G")) {
						l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
						l_app_msg = l_app_msg + " : " + l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						return "200#" + l_responseJsonString + "#";
					}

					if (method.equals("P")) {
						
						l_app_msg = " ::: Inside Post Speciality details::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						
						l_response_str = TransCommunicationMethod(l_protocol_link_id, eventType, l_responseJsonString, l_action_type);

						l_response_str = l_response_str.replace("$!^", "^!^");

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

						return l_errcd + "$!^" + l_status_desc + "$!^" + l_responseJsonString + "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";

					}

				}

				else {
					l_errcd = "E";
					l_status = "0";
					l_status_desc = "Speciality record does not exists";
					msgGenFlag = "E";

					Map<String, String> emptyParam = new LinkedHashMap<String, String>();
					emptyParam.put("speciality_code", "");
					emptyParam.put("long_desc", "");
					emptyParam.put("short_desc", "");
					emptyParam.put("eff_status", "");

					ArrayList<Map<String, String>> emptySpecDtls = new ArrayList<Map<String, String>>();
					emptySpecDtls.add(emptyParam);

					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("request_type", l_request_type);
					l_response_json.put("request_date_time", l_request_date_time);
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);
					l_response_json.put("clinic_data", emptySpecDtls);

					l_responseJsonString = objMapper.writeValueAsString(l_response_json);

					l_app_msg = " ::: Inserting Request into Message Table Master Speciality record does not exists::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
					if (method.equals("G")) {
						l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
						l_app_msg = l_app_msg + " : " + l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);

						return "200#" + l_responseJsonString + "#";
					}

					else if (method.equals("P")) {

						return l_errcd + "$!^" + l_status_desc + "$!^" + l_responseJsonString + "$!^" + l_response_str + "$!^" + msgGenFlag + "#";

					}

				}
				*/

			} else if (l_request_type.equals("PRACTMAST")) {
				
				l_return_data = FetchPractionerMast(actionKey, key, eventType, method);
				
				return l_return_data;
				
				/*
				
				l_action_type = FieldValueFetchMethod(actionKey, "action_type=", null, l_field_separator,
						"processRequest");
				l_action_type = l_action_type.trim();
				if (l_action_type.indexOf("Error") >= 0 || l_action_type.trim().equals("")) {
					l_action_type = "";
				}
				
				l_app_msg = " ::: Action Type ::: " + l_action_type;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				if (l_all_flag.equals("I")) {
					l_prac_code = FieldValueFetchMethod(actionKey, "practitioner_id=", null, l_field_separator,
							"processRequest");
					l_prac_code = l_prac_code.trim();
					if (l_prac_code.indexOf("Error") >= 0 || l_prac_code.trim().equals("")) {
						l_errcd = "E";
						l_error.append(" - clinic code");
					}

					l_app_msg = " ::: l_prac_code ::: " + l_prac_code;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					if (l_errcd.equals("E")) {
						l_app_msg = " ::: Inserting Request into Message Table Information Missing ::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" "
								+ l_error.toString() + " \"  " + " } ";
						params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
						if (method.equals("G")) {
							l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
							l_app_msg = l_app_msg + " : " + l_response_str;
							if (l_debug_YN.equals("Y"))
								System.out.println(l_app_msg);
							return "401#" + l_response_err_json + "#";
						} else {
							return l_errcd + "$!^" + l_response_err_json + "$!^" + l_responseJsonString + "$!^"
									+ l_response_str + "$!^" + msgGenFlag + "#";
						}
					}

				} else {
					l_prac_code = "";
				}

				fetchedPractDetls = FetchPracDetails(l_prac_code, l_all_flag);

				if (fetchedPractDetls.isEmpty()) {
					l_errcd = "E";
					l_status = "0";
					l_status_desc = "Practitioner record does not exists ";
					msgGenFlag = "E";

					Map<String, String> emptyParam = new LinkedHashMap<String, String>();
					emptyParam.put("pract_type", "");
					emptyParam.put("practitioner_id", "");
					emptyParam.put("practitioner_name", "");
					emptyParam.put("short_name", "");
					emptyParam.put("national_id_num", "");
					emptyParam.put("primary_speciality_code", "");
					emptyParam.put("gender", "");
					emptyParam.put("date_of_birth", "");
					emptyParam.put("off_tel_num", "");
					emptyParam.put("email_id", "");
					emptyParam.put("apc_no", "");
					emptyParam.put("eff_status", "");

					ArrayList<Map<String, String>> emptyPractDtls = new ArrayList<Map<String, String>>();
					emptyPractDtls.add(emptyParam);

					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("request_type", l_request_type);
					l_response_json.put("request_date_time", l_request_date_time);
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);
					l_response_json.put("request_data", emptyPractDtls);

					l_responseJsonString = objMapper.writeValueAsString(l_response_json);

					l_app_msg = " ::: Inserting Request into Message Table Master Practitioner record does not exists ::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
					if (method.equals("G")) {
						l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
						l_app_msg = l_app_msg + " : " + l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);

						return "200#" + l_responseJsonString + "#";
					}

					else if (method.equals("P")) {

						return l_errcd + "$!^" + l_status_desc + "$!^" + l_responseJsonString + "$!^" + l_response_str + "$!^" + msgGenFlag + "#";

					}

				}

				if (l_errcd.equals("S")) {
					l_status = "1";
					l_status_desc = "Data successfully retrieved";
					msgGenFlag = "S";
					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("request_type", l_request_type);
					l_response_json.put("request_date_time", l_request_date_time);
					if (method.equals("G")) {
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);
					}
					l_response_json.put("request_data", fetchedPractDetls);

					l_responseJsonString = objMapper.writeValueAsString(l_response_json);

					l_app_msg = " ::: Inserting Request into Message Table Master Practitioner Data successfully retrieved::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					l_app_msg = " ::: Response Master Practitioner Data successfully retrieved ::: \n "
							+ l_responseJsonString.toString();
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
					if (method.equals("G")) {
						l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
						l_app_msg = l_app_msg + " : " + l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						return "200#" + l_responseJsonString + "#";
					}

					if (method.equals("P")) {
						
						l_app_msg = " ::: Inside Post Practitioner details::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						
						
						l_response_str = TransCommunicationMethod(l_protocol_link_id, eventType, l_responseJsonString, l_action_type);

						l_response_str = l_response_str.replace("$!^", "^!^");

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

				}

				else {
					l_errcd = "E";
					l_status = "0";
					l_status_desc = "Practitioner record does not exists";
					msgGenFlag = "E";

					Map<String, String> emptyParam = new LinkedHashMap<String, String>();
					emptyParam.put("pract_type", "");
					emptyParam.put("practitioner_id", "");
					emptyParam.put("practitioner_name", "");
					emptyParam.put("short_name", "");
					emptyParam.put("national_id_num", "");
					emptyParam.put("primary_speciality_code", "");
					emptyParam.put("gender", "");
					emptyParam.put("date_of_birth", "");
					emptyParam.put("off_tel_num", "");
					emptyParam.put("email_id", "");
					emptyParam.put("apc_no", "");
					emptyParam.put("eff_status", "");
					ArrayList<Map<String, String>> emptyPractDtls = new ArrayList<Map<String, String>>();
					emptyPractDtls.add(emptyParam);

					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("request_type", l_request_type);
					l_response_json.put("request_date_time", l_request_date_time);
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);
					l_response_json.put("request_data", emptyPractDtls);

					l_responseJsonString = objMapper.writeValueAsString(l_response_json);

					l_app_msg = " ::: Inserting Request into Message Table Master Practitioner record does not exists::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
					if (method.equals("G")) {
						l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
						l_app_msg = l_app_msg + " : " + l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);

						return "200#" + l_responseJsonString + "#";
					}

					else if (method.equals("P")) {

						return l_errcd + "$!^" + l_status_desc + "$!^" + l_responseJsonString + "$!^" + l_response_str + "$!^" + msgGenFlag + "#";

					}
				}
				
				*/
			} else if (l_request_type.equals("REASONMAST")) {
				
				l_return_data = FetchReasonMast(actionKey, key, eventType, method);
				
				return l_return_data;
				
				/*				
				
				l_action_type = FieldValueFetchMethod(actionKey, "action_type=", null, l_field_separator,
						"processRequest");
				l_action_type = l_action_type.trim();
				if (l_action_type.indexOf("Error") >= 0 || l_action_type.trim().equals("")) {
					l_action_type = "";
				}
				
				l_app_msg = " ::: Action Type ::: " + l_action_type;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				if (l_all_flag.equals("I")) {
					l_reason_code = FieldValueFetchMethod(actionKey, "contact_reason_code=", null, l_field_separator,
							"processRequest");
					l_reason_code = l_reason_code.trim();
					if (l_reason_code.indexOf("Error") >= 0 || l_reason_code.trim().equals("")) {
						l_errcd = "E";
						l_error.append(" - Reason code");
					}

					l_app_msg = " ::: l_reason_code ::: " + l_reason_code;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);					
					
					if (l_errcd.equals("E")) {
						l_app_msg = " ::: Inserting Request into Message Table Information Missing ::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" "
								+ l_error.toString() + " \"  " + " } ";
						params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
						if (method.equals("G")) {
							l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
							l_app_msg = l_app_msg + " : " + l_response_str;
							if (l_debug_YN.equals("Y"))
								System.out.println(l_app_msg);
							return "401#" + l_response_err_json + "#";
						} else {
							return l_errcd + "$!^" + l_response_err_json + "$!^" + l_responseJsonString + "$!^" 
									+ l_response_str + "$!^" + msgGenFlag + "#";
						}
					}

				} else {
					l_reason_code = "";
				}

				fetchedReasonDetls = FetchReasonDetails(l_reason_code, l_all_flag);

				if (fetchedReasonDetls.isEmpty()) {
					l_errcd = "E";
					l_status = "0";
					l_status_desc = "Reason record does not exist";
					msgGenFlag = "E";

					Map<String, String> emptyParam = new LinkedHashMap<String, String>();
					emptyParam.put("reason_code", "");
					emptyParam.put("reason_desc", "");
					emptyParam.put("book_appointment_yn", "");
					emptyParam.put("transfer_appointment_yn", "");
					emptyParam.put("cancel_appointment_yn", "");
					emptyParam.put("eff_status", "");

					ArrayList<Map<String, String>> emptyReasonDtls = new ArrayList<Map<String, String>>();
					emptyReasonDtls.add(emptyParam);

					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("request_type", l_request_type);
					l_response_json.put("request_date_time", l_request_date_time);
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);
					l_response_json.put("request_data", emptyReasonDtls);

					l_responseJsonString = objMapper.writeValueAsString(l_response_json);

					l_app_msg = " ::: Inserting Request into Message Table Master Reason record does not exists ::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
					if (method.equals("G")) {
						l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
						l_app_msg = l_app_msg + " : " + l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);

						return "200#" + l_responseJsonString + "#";
					}

					else if (method.equals("P")) {

						return l_errcd + "$!^" + l_status_desc + "$!^" + l_responseJsonString + "$!^" + l_response_str + "$!^" + msgGenFlag + "#";

					}

				}
				if (l_errcd.equals("S")) {
					l_status = "1";
					l_status_desc = "Data successfully retrieved";
					msgGenFlag = "S";
					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("request_type", l_request_type);
					l_response_json.put("request_date_time", l_request_date_time);
					if (method.equals("G")) {
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);
					}
					l_response_json.put("request_data", fetchedReasonDetls);

					l_responseJsonString = objMapper.writeValueAsString(l_response_json);

					l_app_msg = " ::: Inserting Request into Message Table Master Reason Data successfully retrieved::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					l_app_msg = " ::: Response Master Reason Data successfully retrieved ::: \n "
							+ l_responseJsonString.toString();
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
					if (method.equals("G")) {
						l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
						l_app_msg = l_app_msg + " : " + l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						return "200#" + l_responseJsonString + "#";
					}

					if (method.equals("P")) {
						
						l_app_msg = " ::: Inside Post Reason details::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						
						
						l_response_str = TransCommunicationMethod(l_protocol_link_id, eventType, l_responseJsonString, l_action_type);

						l_response_str = l_response_str.replace("$!^", "^!^");

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

				} else {
					l_errcd = "E";
					l_status = "0";
					l_status_desc = "Reason record does not exists";
					msgGenFlag = "E";

					Map<String, String> emptyParam = new LinkedHashMap<String, String>();
					emptyParam.put("reason_code", "");
					emptyParam.put("reason_desc", "");
					emptyParam.put("book_appointment_yn", "");
					emptyParam.put("transfer_appointment_yn", "");
					emptyParam.put("cancel_appointment_yn", "");
					emptyParam.put("eff_status", "");

					ArrayList<Map<String, String>> emptyPatientDtls = new ArrayList<Map<String, String>>();
					emptyPatientDtls.add(emptyParam);

					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("request_type", l_request_type);
					l_response_json.put("request_date_time", l_request_date_time);
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);
					l_response_json.put("request_data", emptyPatientDtls);

					l_responseJsonString = objMapper.writeValueAsString(l_response_json);

					l_app_msg = " ::: Inserting Request into Message Table Master Reason record does not exists::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
					if (method.equals("G")) {
						l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
						l_app_msg = l_app_msg + " : " + l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);

						return "200#" + l_responseJsonString + "#";
					}

					else if (method.equals("P")) {

						return l_errcd + "$!^" + l_status_desc + "$!^" + l_responseJsonString + "$!^" + l_response_str + "$!^" + msgGenFlag + "#";

					}

				}
				
				*/
			} else if (l_request_type.equals("GENSCH")) {
				
				l_return_data = FetchScheduleMast(actionKey, key, eventType, method);
				
				return l_return_data;
				
				/*
				
				l_action_type = FieldValueFetchMethod(actionKey, "action_type=", null, l_field_separator,
						"processRequest");
				l_action_type = l_action_type.trim();
				if (l_action_type.indexOf("Error") >= 0 || l_action_type.trim().equals("")) {
					l_action_type = "";
				}
				
				l_app_msg = " ::: Action Type ::: " + l_action_type;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_facility_id = FieldValueFetchMethod(actionKey, "facility_id=", null, l_field_separator,
						"processRequest");
				l_facility_id = l_facility_id.trim();
				if (l_facility_id.indexOf("Error") >= 0 || l_facility_id.trim().equals("")) {
					l_errcd = "E";
					l_error.append(" - Facility Id");
				}
				l_app_msg = " ::: Facility Id ::: " + l_facility_id;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_clinic_code = FieldValueFetchMethod(actionKey, "clinic_code=", null, l_field_separator,
						"processRequest");
				l_clinic_code = l_clinic_code.trim();
				if (l_clinic_code.indexOf("Error") >= 0 || l_clinic_code.trim().equals("")) {
					l_errcd = "E";
					l_error.append(" - Clinic Code");
				}
				l_app_msg = " ::: Clinic Code ::: " + l_clinic_code;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_practitioner_id = FieldValueFetchMethod(actionKey, "practitioner_id=", null, l_field_separator,
						"processRequest");
				l_practitioner_id = l_practitioner_id.trim();
				if (l_practitioner_id.indexOf("Error") >= 0 || l_practitioner_id.trim().equals("")) {
					l_errcd = "E";
					l_error.append(" - Practitioner Id");
				}
				l_app_msg = " ::: Practitioner Id ::: " + l_practitioner_id;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				

				if (l_errcd.equals("E")) {
					l_app_msg = " ::: Inserting Request into Message Table Information Missing ::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_error.toString()
							+ " \"  " + " } ";
					params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
					if (method.equals("G")) {
						l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
						l_app_msg = l_app_msg + " : " + l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						return "401#" + l_response_err_json + "#";
					} else {
						return l_errcd + "$!^" + l_response_err_json + "$!^" + l_responseJsonString + "$!^"	+ l_response_str + "$!^" + msgGenFlag + "#";
					}
				}

				if (l_all_flag.equals("I")) {
					l_clinic_from_date = FieldValueFetchMethod(actionKey, "clinic_from_date=", null, l_field_separator,
							"processRequest");
					l_clinic_from_date = l_clinic_from_date.trim();
					if (l_clinic_from_date.indexOf("Error") >= 0 || l_clinic_from_date.trim().equals("")) {
						l_errcd = "E";
						l_error.append(" - Clinic From Date");
					}
					l_app_msg = " ::: Clinic From Date ::: " + l_clinic_from_date;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					l_clinic_to_date = FieldValueFetchMethod(actionKey, "clinic_to_date=", null, l_field_separator,
							"processRequest");
					l_clinic_to_date = l_clinic_to_date.trim();
					if (l_clinic_to_date.indexOf("Error") >= 0 || l_clinic_to_date.trim().equals("")) {
						l_errcd = "E";
						l_error.append(" - Clinic To Date");
					}
					l_app_msg = " ::: Clinic To Date ::: " + l_clinic_to_date;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);					
					
					if (l_errcd.equals("E")) {
						l_app_msg = " ::: Inserting Request into Message Table Information Missing ::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" "
								+ l_error.toString() + " \"  " + " } ";
						params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
						if (method.equals("G")) {
							l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
							l_app_msg = l_app_msg + " : " + l_response_str;
							if (l_debug_YN.equals("Y"))
								System.out.println(l_app_msg);
						}

						return "200#" + l_response_err_json + "#";
					}

				} else {
					l_clinic_from_date = "";
					l_clinic_to_date = "";
				}

				fetchedSchDetls = FetchScheduleDetails(l_facility_id, l_clinic_code, l_practitioner_id,
						l_clinic_from_date, l_clinic_to_date, l_all_flag);

				if (fetchedSchDetls.isEmpty()) {
					l_errcd = "E";
					l_status = "0";
					l_status_desc = "Schedule Details does not exist";
					msgGenFlag = "E";

					Map<String, String> emptyParam = new LinkedHashMap<String, String>();
					emptyParam.put("facility_id", "");
					emptyParam.put("clinic_code", "");
					emptyParam.put("resource_flag", "");
					emptyParam.put("practitioner_id", "");
					ArrayList<Map<String, String>> emptySchDtls = new ArrayList<Map<String, String>>();
					emptySchDtls.add(emptyParam);

					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("request_type", l_request_type);
					l_response_json.put("request_date_time", l_request_date_time);
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);
					l_response_json.put("schedule_data", emptySchDtls);

					l_responseJsonString = objMapper.writeValueAsString(l_response_json);

					l_app_msg = " ::: Inserting Request into Message Table Master Reason record does not exists ::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
					if (method.equals("G")) {
						l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
						l_app_msg = l_app_msg + " : " + l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);

						return "200#" + l_responseJsonString + "#";
					}

					else if (method.equals("P")) {

						return l_errcd + "$!^" + l_status_desc + "$!^" + l_responseJsonString + "$!^" + l_response_str + "$!^" + msgGenFlag + "#";

					}

				}
				if (l_errcd.equals("S")) {
					

					l_app_msg = " ::: Calling Clinic Schedule Build Method ::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					String SchSlotsQuery = " {call XHAPPOB.CLINIC_SCHEDULE_BUILD(?,?,?,?,?,?,?,?,?,?)}";

					dbConn = EMDataSource.getConnection();
					cs = dbConn.prepareCall(SchSlotsQuery);

					cs.setString(1, l_request_ref_no);
					cs.setString(2, l_facility_id);
					cs.setString(3, l_clinic_code);
					cs.setString(4, l_practitioner_id);
					cs.setString(5, l_clinic_from_date);
					cs.setString(6, l_clinic_to_date);
					cs.setString(7, l_all_flag);
					cs.registerOutParameter(8, Types.CLOB);
					cs.registerOutParameter(9, Types.VARCHAR);
					cs.registerOutParameter(10, Types.VARCHAR);

					cs.execute();
					
					l_errcd = cs.getString(9);
					l_status_desc = cs.getString(10);
					
					l_app_msg = " ::: Clinic Schedule Build Method - Error Code... "+l_errcd+" Error Message... "+l_status_desc;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					
					l_responseJsonString = cs.getString(8);					
					
					if (l_errcd.equals("S")) {

						l_app_msg = " ::: Response Schedule Data successfully retrieved ::: \n "
								+ l_responseJsonString.toString().length();
						
						msgGenFlag = "S";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);

						params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
						if (method.equals("G")) {
							l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
							l_app_msg = l_app_msg + " : " + l_response_str;
							if (l_debug_YN.equals("Y"))
								System.out.println(l_app_msg);
							return "200#" + l_responseJsonString + "#";
						}

						if (method.equals("P")) {
							
							l_app_msg = " ::: Inside Post Schedule details::: ";
							if (l_debug_YN.equals("Y"))
								System.out.println(l_app_msg);
							
							
							l_response_str = TransCommunicationMethod(l_protocol_link_id, eventType, l_responseJsonString, l_action_type);
							l_response_str = l_response_str.replace("$!^", "^!^");

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

					} else {
						l_errcd = "E";
						l_status = "0";
						msgGenFlag = "E";
						Map<String, String> emptyParam = new LinkedHashMap<String, String>();
						emptyParam.put("facility_id", "");
						emptyParam.put("clinic_code", "");
						emptyParam.put("resource_flag", "");
						emptyParam.put("practitioner_id", "");
						ArrayList<Map<String, String>> emptySchDtls = new ArrayList<Map<String, String>>();
						emptySchDtls.add(emptyParam);

						l_response_json.put("request_ref_no", l_request_ref_no);
						l_response_json.put("request_type", l_request_type);
						l_response_json.put("request_date_time", l_request_date_time);
						l_response_json.put("status", l_status);
						l_response_json.put("status_desc", l_status_desc);
						l_response_json.put("schedule_data", emptySchDtls);

						l_responseJsonString = objMapper.writeValueAsString(l_response_json);

						l_app_msg = " ::: Inserting Request into Message Table Schedule Details does not exists::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);

						params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
						if (method.equals("G")) {
							l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
							l_app_msg = l_app_msg + " : " + l_response_str;
							if (l_debug_YN.equals("Y"))
								System.out.println(l_app_msg);

							return "200#" + l_responseJsonString + "#";
						}

						else if (method.equals("P")) {

							return l_errcd + "$!^" + l_status_desc + "$!^" + l_responseJsonString + "$!^" + l_response_str + "$!^" + msgGenFlag + "#";

						}

					}
				}
				
				*/

			} else {
				l_status = "0";
				l_status_desc = "Request type is invalid";

				l_response_error_json.put("request_ref_no", l_request_ref_no);
				l_response_error_json.put("request_type", l_request_type);
				l_response_error_json.put("request_date_time", l_request_date_time);
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);

				l_response_err_json = objMapper.writeValueAsString(l_response_error_json);

				return "200#" + l_response_err_json + "#";
			}

		} catch (Exception e) {
			e.printStackTrace();
			l_errcd = "E";
			l_errmsg = l_errcd + "# Exception Occurred " + e.getMessage();
		}
		return "200#" + l_responseJsonString + "#";
	}
	
	public String FetchClinicMast(String actionKey, String key, String eventType, String method) {

		String l_response_str = "", l_response_err_json = "", l_responseJsonString = "";
		String l_protocol_link_id = "";

		String l_facility_id = "";

		Map<String, String> params = new HashMap<String, String>();

		StringBuffer l_error = null;

		String l_request_ref_no = "", l_request_type = "", l_request_date_time = "", l_all_flag = "",
				l_clinic_code = "";

		List<Map<String, String>> fetchedClinicDetls = new ArrayList<Map<String, String>>();		

		Map<String, Object> l_response_json = new HashMap<String, Object>();

		ObjectMapper objMapper = new ObjectMapper();

		String l_status = "0", l_status_desc = "";		

		String delims = "^!^";
		StringTokenizer st = null;

		ArrayList<String> tokenD = null;
		
		String msgGenFlag = "E";
		
		String l_action_type = "";		

		try 
		{				
			l_action_type = FieldValueFetchMethod(actionKey, "action_type=", null, l_field_separator,
					"processRequest");
			l_action_type = l_action_type.trim();
			if (l_action_type.indexOf("Error") >= 0 || l_action_type.trim().equals("")) {
				l_action_type = "";
			}

			l_app_msg = " ::: Action Type... " + l_action_type;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			if (l_all_flag.equals("I")) 
			{
				l_clinic_code = FieldValueFetchMethod(actionKey, "clinic_code=", null, l_field_separator,
						"processRequest");
				l_clinic_code = l_clinic_code.trim();
				if (l_clinic_code.indexOf("Error") >= 0 || l_clinic_code.trim().equals("")) {
					l_errcd = "E";
					l_error.append(" - Clinic Code");
				}

				l_app_msg = " ::: Clinic Code... " + l_clinic_code;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);					

				l_facility_id = FieldValueFetchMethod(actionKey, "facility_id=", null, l_field_separator,
						"processRequest");
				l_facility_id = l_facility_id.trim();
				if (l_facility_id.indexOf("Error") >= 0 || l_facility_id.trim().equals("")) {
					l_errcd = "E";
					l_error.append(" - Facility Id");
				}
				
				l_app_msg = " ::: l_facility_id ::: " + l_facility_id;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);					

				if (l_errcd.equals("E")) 
				{
					l_app_msg = " ::: Inserting Request into Message Table Information Missing ::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" "
							+ l_error.toString() + " \"  " + " } ";
					params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
					if (method.equals("G")) {
						l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
						l_app_msg = l_app_msg + " : " + l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						return "401#" + l_response_err_json + "#";
					} else {
						return l_errcd + "$!^" + l_response_err_json + "$!^" + l_responseJsonString + "$!^"
								+ l_response_str + "$!^" + msgGenFlag + "#";
					}
				}

			} 
			else 
			{
				l_clinic_code = "";
				l_facility_id = "";
			}

			// Request ends here

			fetchedClinicDetls = FetchClinicDetails(l_facility_id, l_clinic_code, l_all_flag);

			if (fetchedClinicDetls.isEmpty()) 
			{
				l_errcd = "E";
				l_status = "0";
				l_status_desc = "Clinic record does not exists";
				msgGenFlag = "E";

				Map<String, String> emptyParam = new LinkedHashMap<String, String>();
				emptyParam.put("facility_id", "");
				emptyParam.put("clinic_code", "");
				emptyParam.put("long_desc", "");
				emptyParam.put("short_desc", "");
				emptyParam.put("specialist_clinic_yn", "");
				emptyParam.put("speciality_code", "");
				emptyParam.put("speciality_desc", "");
				emptyParam.put("eff_status", "");

				ArrayList<Map<String, String>> emptyClinicDtls = new ArrayList<Map<String, String>>();
				emptyClinicDtls.add(emptyParam);

				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("request_type", l_request_type);
				l_response_json.put("request_date_time", l_request_date_time);
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				l_response_json.put("clinic_data", emptyClinicDtls);

				l_responseJsonString = objMapper.writeValueAsString(l_response_json);

				l_app_msg = " ::: Inserting Request into Message Table Master Clinic record does not exists ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				if (method.equals("G")) {
					l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
					l_app_msg = l_app_msg + " : " + l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					return "200#" + l_responseJsonString + "#";
				}

				else if (method.equals("P")) {
					return l_errcd + "$!^" + l_status_desc + "$!^" + l_responseJsonString + "$!^" + l_response_str + "$!^" + msgGenFlag + "#";
				}
			}

			if (l_errcd.equals("S")) 
			{
				l_status = "1";
				l_status_desc = "Data successfully retrieved";
				msgGenFlag = "S";
				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("request_type", l_request_type);
				l_response_json.put("request_date_time", l_request_date_time);
				if (method.equals("G")) { 
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);
				}
				l_response_json.put("clinic_data", fetchedClinicDetls);

				l_responseJsonString = objMapper.writeValueAsString(l_response_json);

				l_app_msg = " ::: Inserting Request into Message Table Master Clinic Data successfully retrieved::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_app_msg = " ::: Response Master Clinic Data successfully retrieved ::: \n "
						+ l_responseJsonString.toString();
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				if (method.equals("G")) {
					l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
					l_app_msg = l_app_msg + " : " + l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					return "200#" + l_responseJsonString + "#";
				}

				if (method.equals("P")) 
				{						
					l_app_msg = " ::: Inside Post clinical details::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					
					l_response_str = TransCommunicationMethod(l_protocol_link_id, eventType, l_responseJsonString, l_action_type);
					
					l_app_msg = " ::: After TransCommunication for clinical details... Response Received... "+l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					l_response_str = l_response_str.replace("$!^", "^!^");
					
					l_app_msg = " ::: After TransCommunication for clinical details... Response Received After replacement... "+l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					st = new StringTokenizer(l_response_str, delims);

					tokenD = new ArrayList<String>();

					while (st.hasMoreElements()) {
						tokenD.add(st.nextToken());
					}
					
					l_app_msg = " ::: After TransCommunication for clinical details..."+tokenD.size();
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					if (tokenD.size() > 0) {
						l_errcd = tokenD.get(0);
						l_status_desc = tokenD.get(1);
						l_response_str = tokenD.get(2);
					}

					return l_errcd + "$!^" + l_status_desc + "$!^" + l_responseJsonString + "$!^" + l_response_str + "$!^" + msgGenFlag;
				}

			}			

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			l_errcd = "E";
			l_errmsg = l_errcd + "# Exception Occurred " + e.getMessage();
		}
		return "200#" + l_responseJsonString + "#";
	}

	public List<Map<String, String>> FetchClinicDetails(String l_facility_id, String l_clinic_code, String l_all_flag) {
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Map<String, String>> masterClinicDetls = new ArrayList<Map<String, String>>();
		Map<String, String> params = null;

		String query = "";
		String l_app_msg = "";

		l_app_msg = " Inside FetchClinicDetails ::: l_clinic_code::" + l_clinic_code + "::l_all_flag:::" + l_all_flag;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			dbConn = EMDataSource.getConnection();

			if (l_all_flag.equals("A")) {
				query = "select a.facility_id , a.clinic_code, a.long_desc clinic_long_desc, a.short_desc clinic_short_desc, a.specialist_clinic_yn,"
						+ " a.speciality_code, b.long_desc speciality_long_desc, a.eff_status from op_clinic a, am_speciality b "
						+ "where a.SPECIALITY_CODE = b.SPECIALITY_CODE ";

				pstmt = dbConn.prepareStatement(query);
				rs = pstmt.executeQuery();
			}

			else if (l_all_flag.equals("I")) {

				l_app_msg = "::: Fetch Clinic Details - inside record retrieval ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				query = "select a.facility_id , a.clinic_code, a.long_desc clinic_long_desc, a.short_desc clinic_short_desc, a.specialist_clinic_yn,"
						+ " a.speciality_code, b.long_desc speciality_long_desc, a.eff_status from op_clinic a, am_speciality b "
						+ "where a.SPECIALITY_CODE = b.SPECIALITY_CODE and a.facility_id = ? and a.clinic_code = ?";

				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, l_facility_id);
				pstmt.setString(2, l_clinic_code);
				rs = pstmt.executeQuery();
			}

			l_app_msg = "::: rs ::: " + rs;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			while (rs.next()) {
				params = new LinkedHashMap<String, String>();
				params.put("facility_id", rs.getString("facility_id"));
				params.put("clinic_code", rs.getString("clinic_code"));
				params.put("long_desc", rs.getString("clinic_long_desc") == null ? "" : rs.getString("clinic_long_desc"));
				params.put("short_desc", rs.getString("clinic_short_desc") == null ? "" : rs.getString("clinic_short_desc"));
				params.put("specialist_clinic_yn",
						rs.getString("specialist_clinic_yn") == null ? "" : rs.getString("specialist_clinic_yn"));
				params.put("speciality_code",
						rs.getString("speciality_code") == null ? "" : rs.getString("speciality_code"));
				params.put("speciality_desc", rs.getString("speciality_long_desc") == null ? "" : rs.getString("speciality_long_desc"));
				params.put("eff_status", rs.getString("eff_status") == null ? "" : rs.getString("eff_status"));

				masterClinicDetls.add(params);
			}
			l_app_msg = "::: Fetched Clinic Details ::: " + masterClinicDetls;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

		} catch (Exception e) {
			params = new LinkedHashMap<String, String>();
			l_app_msg = "Error in Fetching Clinic Details - " + e.getMessage();
			params.put("Error", l_app_msg);

			e.printStackTrace();
			masterClinicDetls.add(params);
		} finally {
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		return masterClinicDetls;

	}
	
	public String FetchSpecialityMast(String actionKey, String key, String eventType, String method) {

		String l_response_str = "", l_response_err_json = "", l_responseJsonString = "";
		String l_protocol_link_id = "";

		Map<String, String> params = new HashMap<String, String>();

		StringBuffer l_error = null;

		String l_request_ref_no = "", l_request_type = "", l_request_date_time = "", l_all_flag = "",
				l_speciality_code = "";

		List<Map<String, String>> fetchedSpecialityDetls = new ArrayList<Map<String, String>>();		

		Map<String, Object> l_response_json = new HashMap<String, Object>();

		ObjectMapper objMapper = new ObjectMapper();

		String l_status = "0", l_status_desc = "";		

		String delims = "^!^";
		StringTokenizer st = null;

		ArrayList<String> tokenD = null;
		
		String msgGenFlag = "E";
		
		String l_action_type = "";		

		try 
		{				
			l_action_type = FieldValueFetchMethod(actionKey, "action_type=", null, l_field_separator,
					"processRequest");
			l_action_type = l_action_type.trim();
			if (l_action_type.indexOf("Error") >= 0 || l_action_type.trim().equals("")) {
				l_action_type = "";
			}
			
			l_app_msg = " ::: Action Type ::: " + l_action_type;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (l_all_flag.equals("I")) {
				l_speciality_code = FieldValueFetchMethod(actionKey, "speciality_code=", null, l_field_separator,
						"processRequest");
				l_speciality_code = l_speciality_code.trim();
				if (l_speciality_code.indexOf("Error") >= 0 || l_speciality_code.trim().equals("")) {
					l_errcd = "E";
					l_error.append(" - Speciality code");
				}

				l_app_msg = " ::: l_speciality_code ::: " + l_speciality_code;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				if (l_errcd.equals("E")) {
					l_app_msg = " ::: Inserting Request into Message Table Information Missing ::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" "
							+ l_error.toString() + " \"  " + " } ";
					params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
					if (method.equals("G")) {
						l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
						l_app_msg = l_app_msg + " : " + l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						return "401#" + l_response_err_json + "#";
					} else {
						return l_errcd + "$!^" + l_response_err_json + "$!^" + l_responseJsonString + "$!^"
								+ l_response_str + "$!^" + msgGenFlag + "#";
					}
				}

			} else {
				l_speciality_code = "";
			}

			fetchedSpecialityDetls = FetchSpecDetails(l_speciality_code, l_all_flag);

			if (fetchedSpecialityDetls.isEmpty()) {
				l_errcd = "E";
				l_status = "0";
				l_status_desc = "Speciality record does not exists ";
				msgGenFlag = "E";

				Map<String, String> emptyParam = new LinkedHashMap<String, String>();
				emptyParam.put("speciality_code", "");
				emptyParam.put("long_desc", "");
				emptyParam.put("short_desc", "");
				emptyParam.put("eff_status", "");

				ArrayList<Map<String, String>> emptySpecDtls = new ArrayList<Map<String, String>>();
				emptySpecDtls.add(emptyParam);

				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("request_type", l_request_type);
				l_response_json.put("request_date_time", l_request_date_time);
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				l_response_json.put("request_data", emptySpecDtls);

				l_responseJsonString = objMapper.writeValueAsString(l_response_json);

				l_app_msg = " ::: Inserting Request into Message Table Master Speciality record does not exists ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				if (method.equals("G")) {
					l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
					l_app_msg = l_app_msg + " : " + l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					return "200#" + l_responseJsonString + "#";
				}

				else if (method.equals("P")) {

					return l_errcd + "$!^" + l_status_desc + "$!^" + l_responseJsonString + "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";

				}

			}

			if (l_errcd.equals("S")) {
				l_status = "1";
				l_status_desc = "Data successfully retrieved";
				msgGenFlag = "S";
				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("request_type", l_request_type);
				l_response_json.put("request_date_time", l_request_date_time);
				if (method.equals("G")) {
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				}
				l_response_json.put("request_data", fetchedSpecialityDetls);

				l_responseJsonString = objMapper.writeValueAsString(l_response_json);

				l_app_msg = " ::: Inserting Request into Message Table Master Speciality Data successfully retrieved::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_app_msg = " ::: Response Master Speciality Data successfully retrieved ::: \n "
						+ l_responseJsonString.toString();
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				if (method.equals("G")) {
					l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
					l_app_msg = l_app_msg + " : " + l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					return "200#" + l_responseJsonString + "#";
				}

				if (method.equals("P")) {
					
					l_app_msg = " ::: Inside Post Speciality details::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					
					l_response_str = TransCommunicationMethod(l_protocol_link_id, eventType, l_responseJsonString, l_action_type);

					l_response_str = l_response_str.replace("$!^", "^!^");

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

					return l_errcd + "$!^" + l_status_desc + "$!^" + l_responseJsonString + "$!^" + l_response_str+ "$!^" + msgGenFlag + "#";

				}

			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			l_errcd = "E";
			l_errmsg = l_errcd + "# Exception Occurred " + e.getMessage();
		}
		return "200#" + l_responseJsonString + "#";
	}

	public List<Map<String, String>> FetchSpecDetails(String l_speciality_code, String l_all_flag) {
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Map<String, String>> masterSpecialityDetls = new ArrayList<Map<String, String>>();
		Map<String, String> params = null;

		String query = "";
		String l_app_msg = "";

		l_app_msg = " Inside FetchSpecDetails ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			dbConn = EMDataSource.getConnection();

			if (l_all_flag.equals("A")) {
				query = "select SPECIALITY_CODE, LONG_DESC, SHORT_DESC, EFF_STATUS from am_speciality ";

				pstmt = dbConn.prepareStatement(query);
			}

			else if (l_all_flag.equals("I")) {
				query = "select SPECIALITY_CODE, LONG_DESC, SHORT_DESC, EFF_STATUS from am_speciality where SPECIALITY_CODE = ? ";

				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, l_speciality_code);
			}

			rs = pstmt.executeQuery();
			while (rs.next()) {
				params = new LinkedHashMap<String, String>();
				params.put("speciality_code", rs.getString("SPECIALITY_CODE"));
				params.put("long_desc", rs.getString("long_desc") == null ? "" : rs.getString("long_desc"));
				params.put("short_desc", rs.getString("short_desc") == null ? "" : rs.getString("short_desc"));
				params.put("eff_status", rs.getString("eff_status") == null ? "" : rs.getString("eff_status"));

				masterSpecialityDetls.add(params);
			}
			l_app_msg = "::: Fetched Speciality Details ::: " + masterSpecialityDetls;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

		} catch (Exception e) {
			params = new LinkedHashMap<String, String>();
			l_app_msg = "Error in Fetching Speciality Details - " + e.getMessage();
			params.put("Error", l_app_msg);

			e.printStackTrace();
			masterSpecialityDetls.add(params);
		} finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		return masterSpecialityDetls;

	}
	
	public String FetchPractionerMast(String actionKey, String key, String eventType, String method) {

		String l_response_str = "", l_response_err_json = "", l_responseJsonString = "";
		String l_protocol_link_id = "";

		Map<String, String> params = new HashMap<String, String>();

		StringBuffer l_error = null;

		String l_request_ref_no = "", l_request_type = "", l_request_date_time = "", l_all_flag = "",
				l_prac_code = "";

		List<Map<String, String>> fetchedPractDetls = new ArrayList<Map<String, String>>();		

		Map<String, Object> l_response_json = new HashMap<String, Object>();

		ObjectMapper objMapper = new ObjectMapper();

		String l_status = "0", l_status_desc = "";		

		String delims = "^!^";
		StringTokenizer st = null;

		ArrayList<String> tokenD = null;
		
		String msgGenFlag = "E";
		
		String l_action_type = "";		

		try 
		{
			l_action_type = FieldValueFetchMethod(actionKey, "action_type=", null, l_field_separator,
					"processRequest");
			l_action_type = l_action_type.trim();
			if (l_action_type.indexOf("Error") >= 0 || l_action_type.trim().equals("")) {
				l_action_type = "";
			}
			
			l_app_msg = " ::: Action Type ::: " + l_action_type;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			if (l_all_flag.equals("I")) {
				l_prac_code = FieldValueFetchMethod(actionKey, "practitioner_id=", null, l_field_separator,
						"processRequest");
				l_prac_code = l_prac_code.trim();
				if (l_prac_code.indexOf("Error") >= 0 || l_prac_code.trim().equals("")) {
					l_errcd = "E";
					l_error.append(" - clinic code");
				}

				l_app_msg = " ::: l_prac_code ::: " + l_prac_code;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				if (l_errcd.equals("E")) {
					l_app_msg = " ::: Inserting Request into Message Table Information Missing ::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" "
							+ l_error.toString() + " \"  " + " } ";
					params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
					if (method.equals("G")) {
						l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
						l_app_msg = l_app_msg + " : " + l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						return "401#" + l_response_err_json + "#";
					} else {
						return l_errcd + "$!^" + l_response_err_json + "$!^" + l_responseJsonString + "$!^"
								+ l_response_str + "$!^" + msgGenFlag + "#";
					}
				}

			} else {
				l_prac_code = "";
			}

			fetchedPractDetls = FetchPracDetails(l_prac_code, l_all_flag);

			if (fetchedPractDetls.isEmpty()) {
				l_errcd = "E";
				l_status = "0";
				l_status_desc = "Practitioner record does not exists ";
				msgGenFlag = "E";

				Map<String, String> emptyParam = new LinkedHashMap<String, String>();
				emptyParam.put("pract_type", "");
				emptyParam.put("practitioner_id", "");
				emptyParam.put("practitioner_name", "");
				emptyParam.put("short_name", "");
				emptyParam.put("national_id_num", "");
				emptyParam.put("primary_speciality_code", "");
				emptyParam.put("gender", "");
				emptyParam.put("date_of_birth", "");
				emptyParam.put("off_tel_num", "");
				emptyParam.put("email_id", "");
				emptyParam.put("apc_no", "");
				emptyParam.put("eff_status", "");

				ArrayList<Map<String, String>> emptyPractDtls = new ArrayList<Map<String, String>>();
				emptyPractDtls.add(emptyParam);

				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("request_type", l_request_type);
				l_response_json.put("request_date_time", l_request_date_time);
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				l_response_json.put("request_data", emptyPractDtls);

				l_responseJsonString = objMapper.writeValueAsString(l_response_json);

				l_app_msg = " ::: Inserting Request into Message Table Master Practitioner record does not exists ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				if (method.equals("G")) {
					l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
					l_app_msg = l_app_msg + " : " + l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					return "200#" + l_responseJsonString + "#";
				}

				else if (method.equals("P")) {

					return l_errcd + "$!^" + l_status_desc + "$!^" + l_responseJsonString + "$!^" + l_response_str + "$!^" + msgGenFlag + "#";

				}

			}

			if (l_errcd.equals("S")) {
				l_status = "1";
				l_status_desc = "Data successfully retrieved";
				msgGenFlag = "S";
				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("request_type", l_request_type);
				l_response_json.put("request_date_time", l_request_date_time);
				if (method.equals("G")) 
				{					
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);
				}
				l_response_json.put("request_data", fetchedPractDetls);

				l_responseJsonString = objMapper.writeValueAsString(l_response_json);

				l_app_msg = " ::: Inserting Request into Message Table Master Practitioner Data successfully retrieved::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_app_msg = " ::: Response Master Practitioner Data successfully retrieved ::: \n "
						+ l_responseJsonString.toString();
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				if (method.equals("G")) {
					l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
					l_app_msg = l_app_msg + " : " + l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					return "200#" + l_responseJsonString + "#";
				}

				if (method.equals("P")) {
					
					l_app_msg = " ::: Inside Post Practitioner details::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);					
					
					l_response_str = TransCommunicationMethod(l_protocol_link_id, eventType, l_responseJsonString, l_action_type);

					l_response_str = l_response_str.replace("$!^", "^!^");

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
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			l_errcd = "E";
			l_errmsg = l_errcd + "# Exception Occurred " + e.getMessage();
		}
		return "200#" + l_responseJsonString + "#";
	}

	public List<Map<String, String>> FetchPracDetails(String l_prac_code, String l_all_flag) {
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Map<String, String>> masterPractitionerDetls = new ArrayList<Map<String, String>>();
		Map<String, String> params = null;

		String query = "";
		String l_app_msg = "";
		
		String l_element_id = "", l_pract_nat_id_type = "", l_pract_nat_id_desc = "", l_national_id="";

		l_app_msg = " Inside FetchPracDetails ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			l_element_id = "PRACT_NAT_ID_TYPE";
			
			l_pract_nat_id_type = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: Pract National Type Id: "+l_pract_nat_id_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_element_id = "PRACT_NAT_ID_DESC";
			
			l_pract_nat_id_desc = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: Pract National Type Desc: "+l_pract_nat_id_desc;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			dbConn = EMDataSource.getConnection();

			if (l_all_flag.equals("A")) {
				query = "select a.pract_type, a.practitioner_id, a.practitioner_name, a.short_name, nvl(a.national_id_num,'') national_id_num, "
						+ "a.primary_speciality_code, a.gender, to_char(a.date_of_birth, 'dd/mm/yyyy') date_of_birth, a.off_tel_num, a.email_id, a.apc_no, a.mobile_num, "
						+ "a.eff_status, nvl(a.oth_alt_id_type,'') identification_type_code, nvl(a.oth_alt_id_no,'') identification_id, i.long_desc identification_type_desc" 
						+ "from am_practitioner a, mp_alternate_id_type i where nvl(a.oth_alt_id_type,'**') = i.alt_id_type(+)";

				pstmt = dbConn.prepareStatement(query);
			}

			else if (l_all_flag.equals("I")) {
				query = "select a.pract_type, a.practitioner_id, a.practitioner_name, a.short_name, nvl(a.national_id_num,'') national_id_num, "
						+ "a.primary_speciality_code, a.gender, to_char(a.date_of_birth, 'dd/mm/yyyy') date_of_birth, a.off_tel_num, a.email_id, a.apc_no, a.mobile_num, " 
						+ "a.eff_status, nvl(a.oth_alt_id_type,'') identification_type_code, nvl(a.oth_alt_id_no,'') identification_id, i.long_desc identification_type_desc "
						+ "from am_practitioner a, mp_alternate_id_type i where nvl(a.oth_alt_id_type,'**') = i.alt_id_type(+) and a.practitioner_id =?  ";

				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, l_prac_code);
			}

			rs = pstmt.executeQuery();
			while (rs.next()) {
				params = new LinkedHashMap<String, String>();
				params.put("pract_type", rs.getString("pract_type"));
				params.put("practitioner_id", rs.getString("practitioner_id"));
				params.put("practitioner_name",
						rs.getString("practitioner_name") == null ? "" : rs.getString("practitioner_name"));
				params.put("short_name", rs.getString("short_name") == null ? "" : rs.getString("short_name"));
				
				l_national_id=rs.getString("national_id_num") == null ? "" : rs.getString("national_id_num");		
				if (l_national_id.length()>0)
				{
					params.put("identification_type_code", l_pract_nat_id_type);
					params.put("identification_type_desc", l_pract_nat_id_desc);
					params.put("identification_id", l_national_id);
				}
				else
				{
					params.put("identification_type_code", rs.getString("identification_type_code")== null?"":rs.getString("identification_type_code"));
					params.put("identification_type_desc", rs.getString("identification_type_desc")== null?"":rs.getString("identification_type_desc"));
					params.put("identification_id", rs.getString("identification_id")== null?"":rs.getString("identification_id"));
				}		
				
				params.put("primary_speciality_code",
						rs.getString("primary_speciality_code") == null ? "" : rs.getString("primary_speciality_code"));
				params.put("gender", rs.getString("gender") == null ? "" : rs.getString("gender"));
				params.put("date_of_birth", rs.getString("date_of_birth") == null ? "" : rs.getString("date_of_birth"));
				params.put("off_tel_num", rs.getString("off_tel_num") == null ? "" : rs.getString("off_tel_num"));
				params.put("mobile_num", rs.getString("mobile_num") == null ? "" : rs.getString("mobile_num"));
				params.put("email_id", rs.getString("email_id") == null ? "" : rs.getString("email_id"));
				params.put("apc_no", rs.getString("apc_no") == null ? "" : rs.getString("apc_no"));
				params.put("eff_status", rs.getString("eff_status") == null ? "" : rs.getString("eff_status"));

				masterPractitionerDetls.add(params);
			}
			l_app_msg = "::: Fetched Practitioner Details ::: " + masterPractitionerDetls;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

		} catch (Exception e) {
			params = new LinkedHashMap<String, String>();
			l_app_msg = "Error in Fetching Practitioner Details - " + e.getMessage();
			params.put("Error", l_app_msg);

			e.printStackTrace();
			masterPractitionerDetls.add(params);
		} finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		return masterPractitionerDetls;

	}
	
	public String FetchReasonMast(String actionKey, String key, String eventType, String method) {

		String l_response_str = "", l_response_err_json = "", l_responseJsonString = "";
		String l_protocol_link_id = "";

		Map<String, String> params = new HashMap<String, String>();

		StringBuffer l_error = null;

		String l_request_ref_no = "", l_request_type = "", l_request_date_time = "", l_all_flag = "", l_reason_code = "";

		List<Map<String, String>> fetchedReasonDetls = new ArrayList<Map<String, String>>();		

		Map<String, Object> l_response_json = new HashMap<String, Object>();

		ObjectMapper objMapper = new ObjectMapper();

		String l_status = "0", l_status_desc = "";		

		String delims = "^!^";
		StringTokenizer st = null;

		ArrayList<String> tokenD = null;
		
		String msgGenFlag = "E";
		
		String l_action_type = "";		

		try 
		{
			l_action_type = FieldValueFetchMethod(actionKey, "action_type=", null, l_field_separator,
					"processRequest");
			l_action_type = l_action_type.trim();
			if (l_action_type.indexOf("Error") >= 0 || l_action_type.trim().equals("")) {
				l_action_type = "";
			}
			
			l_app_msg = " ::: Action Type ::: " + l_action_type;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			if (l_all_flag.equals("I")) {
				l_reason_code = FieldValueFetchMethod(actionKey, "contact_reason_code=", null, l_field_separator,
						"processRequest");
				l_reason_code = l_reason_code.trim();
				if (l_reason_code.indexOf("Error") >= 0 || l_reason_code.trim().equals("")) {
					l_errcd = "E";
					l_error.append(" - Reason code");
				}

				l_app_msg = " ::: l_reason_code ::: " + l_reason_code;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);					
				
				if (l_errcd.equals("E")) {
					l_app_msg = " ::: Inserting Request into Message Table Information Missing ::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" "
							+ l_error.toString() + " \"  " + " } ";
					params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
					if (method.equals("G")) {
						l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
						l_app_msg = l_app_msg + " : " + l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						return "401#" + l_response_err_json + "#";
					} else {
						return l_errcd + "$!^" + l_response_err_json + "$!^" + l_responseJsonString + "$!^" 
								+ l_response_str + "$!^" + msgGenFlag + "#";
					}
				}

			} else {
				l_reason_code = "";
			}

			fetchedReasonDetls = FetchReasonDetails(l_reason_code, l_all_flag);

			if (fetchedReasonDetls.isEmpty()) 
			{
				l_errcd = "E";
				l_status = "0";
				l_status_desc = "Reason record does not exist";
				msgGenFlag = "E";

				Map<String, String> emptyParam = new LinkedHashMap<String, String>();
				emptyParam.put("reason_code", "");
				emptyParam.put("reason_desc", "");
				emptyParam.put("book_appointment_yn", "");
				emptyParam.put("transfer_appointment_yn", "");
				emptyParam.put("cancel_appointment_yn", "");
				emptyParam.put("eff_status", "");

				ArrayList<Map<String, String>> emptyReasonDtls = new ArrayList<Map<String, String>>();
				emptyReasonDtls.add(emptyParam);

				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("request_type", l_request_type);
				l_response_json.put("request_date_time", l_request_date_time);
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				l_response_json.put("request_data", emptyReasonDtls);

				l_responseJsonString = objMapper.writeValueAsString(l_response_json);

				l_app_msg = " ::: Inserting Request into Message Table Master Reason record does not exists ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				if (method.equals("G")) {
					l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
					l_app_msg = l_app_msg + " : " + l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					return "200#" + l_responseJsonString + "#";
				}

				else if (method.equals("P")) {

					return l_errcd + "$!^" + l_status_desc + "$!^" + l_responseJsonString + "$!^" + l_response_str + "$!^" + msgGenFlag + "#";

				}

			}
			if (l_errcd.equals("S")) 
			{
				l_status = "1";
				l_status_desc = "Data successfully retrieved";
				msgGenFlag = "S";
				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("request_type", l_request_type);
				l_response_json.put("request_date_time", l_request_date_time);
				if (method.equals("G")) {
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				}
				l_response_json.put("request_data", fetchedReasonDetls);

				l_responseJsonString = objMapper.writeValueAsString(l_response_json);

				l_app_msg = " ::: Inserting Request into Message Table Master Reason Data successfully retrieved::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_app_msg = " ::: Response Master Reason Data successfully retrieved ::: \n "
						+ l_responseJsonString.toString();
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				if (method.equals("G")) {
					l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
					l_app_msg = l_app_msg + " : " + l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					return "200#" + l_responseJsonString + "#";
				}

				if (method.equals("P")) {
					
					l_app_msg = " ::: Inside Post Reason details::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);					
					
					l_response_str = TransCommunicationMethod(l_protocol_link_id, eventType, l_responseJsonString, l_action_type);

					l_response_str = l_response_str.replace("$!^", "^!^");

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
			} 
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			l_errcd = "E";
			l_errmsg = l_errcd + "# Exception Occurred " + e.getMessage();
		}
		return "200#" + l_responseJsonString + "#";
	}

	public List<Map<String, String>> FetchReasonDetails(String l_reason_code, String l_all_flag) {
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Map<String, String>> masterReasonDetls = new ArrayList<Map<String, String>>();
		Map<String, String> params = null;

		String query = "";
		String l_app_msg = "";

		l_app_msg = " Inside FetchReasonDetails ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			dbConn = EMDataSource.getConnection();

			if (l_all_flag.equals("A")) {
				query = "select CONTACT_REASON_CODE, CONTACT_REASON, book_appointment_yn, transfer_appointment_yn, "
						+ "cancel_appointment_yn, eff_status from am_contact_reason ";

				pstmt = dbConn.prepareStatement(query);
			}

			else if (l_all_flag.equals("I")) {
				query = "select CONTACT_REASON_CODE, CONTACT_REASON, book_appointment_yn, transfer_appointment_yn, "
						+ "cancel_appointment_yn, eff_status "
						+ "from am_contact_reason where CONTACT_REASON_CODE =?  ";

				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, l_reason_code);
			}

			rs = pstmt.executeQuery();
			while (rs.next()) {
				params = new LinkedHashMap<String, String>();
				params.put("reason_code", rs.getString("CONTACT_REASON_CODE"));
				params.put("reason_desc", rs.getString("CONTACT_REASON") == null ? "" : rs.getString("CONTACT_REASON"));
				params.put("book_appointment_yn",
						rs.getString("book_appointment_yn") == null ? "" : rs.getString("book_appointment_yn"));
				params.put("transfer_appointment_yn",
						rs.getString("transfer_appointment_yn") == null ? "" : rs.getString("transfer_appointment_yn"));
				params.put("cancel_appointment_yn",
						rs.getString("cancel_appointment_yn") == null ? "" : rs.getString("cancel_appointment_yn"));
				params.put("eff_status", rs.getString("eff_status") == null ? "" : rs.getString("eff_status"));

				masterReasonDetls.add(params);
			}
			l_app_msg = "::: Fetched Reason Details ::: " + masterReasonDetls;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

		} catch (Exception e) {
			params = new LinkedHashMap<String, String>();
			l_app_msg = "Error in Fetching Reason Details - " + e.getMessage();
			params.put("Error", l_app_msg);

			e.printStackTrace();
			masterReasonDetls.add(params);
		} finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		return masterReasonDetls;

	}

	public String FieldValueFetchMethod(String message, String identifier, String standardCode, String fieldSep,
			String procID) {

		String l_app_msg = "", l_field_value = "";

		try {

			l_app_msg = " ::: Inside FieldValueFetchMethod ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = " ::: Message : " + message + " ::: Identifier : " + identifier + " ::: Standard Code : "
					+ standardCode;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = " ::: Deriving Field Value..." + identifier;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (standardCode != null && !(standardCode.length() > 0)) {

			} else {
				if (message.indexOf(identifier) >= 0) {
					if (message.indexOf(fieldSep) >= 0) {
						l_field_value = message.substring(message.indexOf(identifier) + identifier.length());
						if (l_field_value.indexOf(fieldSep) >= 0) {
							l_field_value = l_field_value.substring(0, l_field_value.indexOf(fieldSep));
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

	public String FetchStdCntrlSegMethod(String segmentID, String elementId, String standardCode) {

		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		l_app_msg = " ::: Inside FetchStdCntrlSegMethod ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: Segment ID : " + segmentID + " ::: Element ID : " + elementId + " ::: Standard Code : "
				+ standardCode;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: Retrieving " + elementId + " Value...";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			dbConn = EMDataSource.getConnection();
			query = "SELECT NVL(DEFAULT_VALUE,'X') DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG "
					+ " WHERE SEGMENT_ID = ? " + " AND STANDARD_CODE = ? " + " AND ELEMENT_ID = ? ";

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
			EMDataSource.returnConnection(dbConn);
		}
		return l_field_value;
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

	public static ArrayList<String> FetchAppDetails(String l_standard_code) {
		Connection dbConn = null;
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
			dbConn = EMDataSource.getConnection();
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
			EMDataSource.returnConnection(dbConn);
		}
		return externalArray;
	}

	public String MessageLoadMethod(String message, Map<String, String> param, String status, String err_message) {

		String l_app_msg = "";
		String l_request_date = "", l_status_return = "";

		try {

			l_app_msg = " ::: Inside Message Loading ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

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

			params.put("added_by_id", "INTERFACE");
			params.put("ADDED_BY_DATE", l_request_date);
			params.put("CLIENT_MACHINE", "INTERFACE");
			params.put("ADDED_BY_FACILITY", param.get("FACILITY_ID"));

			params.put("MODIFIED_BY_ID", "INTERFACE");
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

			l_status_return = insertInboundMessageDetails(params);

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

	public String insertInboundMessageDetails(Map<String, String> params) {

		String selectStmt = "select count(*) record_count from XH_INBOUND_MESSAGE where application_id = ? and facility_id = ? and message_id = ?";

		String insertstmt = "INSERT INTO XH_INBOUND_MESSAGE (application_id, facility_id, message_id, srl_no, message_received_date, process_id, "
				+ " client_id, inbound_message_text, message_ack_text, message_status, rd_order_yn, "
				+ " added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, "
				+ " patient_id, merged_patient_id, episode_type, episode_id, visit_id, accession_num, action_type, "
				+ " last_proc_date, event_status, not_req_reason, ext_accession_num, event_type, protocol_link_id,err_msg) "
				+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

		String updateStmt = " UPDATE xh_inbound_message SET	ERR_MSG = ?, MESSAGE_ACK_TEXT = ?, "
				+ " MESSAGE_STATUS = ?, EPISODE_ID = ?, VISIT_ID = ?,  modified_by_id = ?, modified_date = ? "
				+ " WHERE APPLICATION_ID = ? and facility_id = ? AND MESSAGE_ID = ? ";

		Connection dbConn = null;
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

			dbConn = EMDataSource.getConnection();
			// dbConn = EMDBConnectionPool.getConnection();

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
				pstmt.setString(6, XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_ID"), params.get("LOGIN_USER")));
				pstmt.setTimestamp(7,new java.sql.Timestamp(System.currentTimeMillis()));			
				pstmt.setString(8, params.get("APPLICATION_ID"));
				pstmt.setString(9, params.get("FACILITY_ID"));
				pstmt.setString(10, params.get("MSG_ID"));

				l_app_msg = " ::: Application Id... "
						+ params.get("APPLICATION_ID") + " Facility Id... "
						+ params.get("FACILITY_ID") + " Mesage Id... "
						+ params.get("MSG_ID");
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_app_msg = " ::: Error Message... " + params.get("ERR_MSG")
						+ " Message Ack text Length... "
						+ params.get("MESSAGE_ACK_TEXT").length() + " Status... "
						+ params.get("MESSAGE_STATUS");
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
			EMDataSource.returnConnection(dbConn);
		}
	}

	public static String getFormattedStringDate(String format, Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
		String dateFormatted = dateFormat.format(date);
		return dateFormatted;
	}

	public String validateRequest(String key) {
		String query = "";
		String l_app_msg = "", l_errmsg = "";
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int rowcount = 0;

		try {

			l_app_msg = " ::: Validating the request ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			dbConn = EMDataSource.getConnection();
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
			EMDataSource.returnConnection(dbConn);
		}

	}

	public static ArrayList<String> FetchSegmentDetails(String key) {
		Connection dbConn = null;
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
			dbConn = EMDataSource.getConnection();
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
			EMDataSource.returnConnection(dbConn);
		}
		return segmentArray;
	}
	
	public String FetchScheduleMast(String actionKey, String key, String eventType, String method) {

		String l_response_str = "", l_response_err_json = "", l_responseJsonString = "";
		String l_protocol_link_id = "";

		Map<String, String> params = new HashMap<String, String>();

		StringBuffer l_error = null;

		String l_request_ref_no = "", l_request_type = "", l_request_date_time = "", l_all_flag = "";
		
		String l_facility_id = "", l_clinic_code = "", l_prac_code = "", l_clinic_from_date = "",
				l_clinic_to_date = "", l_practitioner_id = "";

		List<Map<String, String>> fetchedSchDetls = new ArrayList<Map<String, String>>();		

		Map<String, Object> l_response_json = new HashMap<String, Object>();

		ObjectMapper objMapper = new ObjectMapper();

		String l_status = "0", l_status_desc = "";		

		String delims = "^!^";
		StringTokenizer st = null;

		ArrayList<String> tokenD = null;
		
		String msgGenFlag = "E";
		
		String l_action_type = "";		
		
		CallableStatement cs = null;

		try 
		{
			l_action_type = FieldValueFetchMethod(actionKey, "action_type=", null, l_field_separator,
					"processRequest");
			l_action_type = l_action_type.trim();
			if (l_action_type.indexOf("Error") >= 0 || l_action_type.trim().equals("")) {
				l_action_type = "";
			}
			
			l_app_msg = " ::: Action Type ::: " + l_action_type;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_facility_id = FieldValueFetchMethod(actionKey, "facility_id=", null, l_field_separator,
					"processRequest");
			l_facility_id = l_facility_id.trim();
			if (l_facility_id.indexOf("Error") >= 0 || l_facility_id.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Facility Id");
			}
			l_app_msg = " ::: Facility Id ::: " + l_facility_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_clinic_code = FieldValueFetchMethod(actionKey, "clinic_code=", null, l_field_separator,
					"processRequest");
			l_clinic_code = l_clinic_code.trim();
			if (l_clinic_code.indexOf("Error") >= 0 || l_clinic_code.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Clinic Code");
			}
			l_app_msg = " ::: Clinic Code ::: " + l_clinic_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_practitioner_id = FieldValueFetchMethod(actionKey, "practitioner_id=", null, l_field_separator,
					"processRequest");
			l_practitioner_id = l_practitioner_id.trim();
			if (l_practitioner_id.indexOf("Error") >= 0 || l_practitioner_id.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Practitioner Id");
			}
			l_app_msg = " ::: Practitioner Id ::: " + l_practitioner_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			

			if (l_errcd.equals("E")) {
				l_app_msg = " ::: Inserting Request into Message Table Information Missing ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_error.toString()
						+ " \"  " + " } ";
				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
				if (method.equals("G")) {
					l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
					l_app_msg = l_app_msg + " : " + l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					return "401#" + l_response_err_json + "#";
				} else {
					return l_errcd + "$!^" + l_response_err_json + "$!^" + l_responseJsonString + "$!^"	+ l_response_str + "$!^" + msgGenFlag + "#";
				}
			}

			if (l_all_flag.equals("I")) {
				l_clinic_from_date = FieldValueFetchMethod(actionKey, "clinic_from_date=", null, l_field_separator,
						"processRequest");
				l_clinic_from_date = l_clinic_from_date.trim();
				if (l_clinic_from_date.indexOf("Error") >= 0 || l_clinic_from_date.trim().equals("")) {
					l_errcd = "E";
					l_error.append(" - Clinic From Date");
				}
				l_app_msg = " ::: Clinic From Date ::: " + l_clinic_from_date;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_clinic_to_date = FieldValueFetchMethod(actionKey, "clinic_to_date=", null, l_field_separator,
						"processRequest");
				l_clinic_to_date = l_clinic_to_date.trim();
				if (l_clinic_to_date.indexOf("Error") >= 0 || l_clinic_to_date.trim().equals("")) {
					l_errcd = "E";
					l_error.append(" - Clinic To Date");
				}
				l_app_msg = " ::: Clinic To Date ::: " + l_clinic_to_date;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);					
				
				if (l_errcd.equals("E")) {
					l_app_msg = " ::: Inserting Request into Message Table Information Missing ::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" "
							+ l_error.toString() + " \"  " + " } ";
					params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
					if (method.equals("G")) {
						l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
						l_app_msg = l_app_msg + " : " + l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
					}

					return "200#" + l_response_err_json + "#";
				}

			} else {
				l_clinic_from_date = "";
				l_clinic_to_date = "";
			}

			fetchedSchDetls = FetchScheduleDetails(l_facility_id, l_clinic_code, l_practitioner_id,
					l_clinic_from_date, l_clinic_to_date, l_all_flag);

			if (fetchedSchDetls.isEmpty()) {
				l_errcd = "E";
				l_status = "0";
				l_status_desc = "Schedule Details does not exist";
				msgGenFlag = "E";

				Map<String, String> emptyParam = new LinkedHashMap<String, String>();
				emptyParam.put("facility_id", "");
				emptyParam.put("clinic_code", "");
				emptyParam.put("resource_flag", "");
				emptyParam.put("practitioner_id", "");
				ArrayList<Map<String, String>> emptySchDtls = new ArrayList<Map<String, String>>();
				emptySchDtls.add(emptyParam);

				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("request_type", l_request_type);
				l_response_json.put("request_date_time", l_request_date_time);
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				l_response_json.put("schedule_data", emptySchDtls);

				l_responseJsonString = objMapper.writeValueAsString(l_response_json);

				l_app_msg = " ::: Inserting Request into Message Table Master Reason record does not exists ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				if (method.equals("G")) 
				{
					l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
					l_app_msg = l_app_msg + " : " + l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					return "200#" + l_responseJsonString + "#";
				}
				else if (method.equals("P")) 
				{
					return l_errcd + "$!^" + l_status_desc + "$!^" + l_responseJsonString + "$!^" + l_response_str + "$!^" + msgGenFlag + "#";
				}
			}
			if (l_errcd.equals("S")) 
			{
				l_app_msg = " ::: Calling Clinic Schedule Build Method ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				String SchSlotsQuery = " {call XHAPPOB.CLINIC_SCHEDULE_BUILD(?,?,?,?,?,?,?,?,?,?)}";

				dbConn = EMDataSource.getConnection();
				cs = dbConn.prepareCall(SchSlotsQuery);

				cs.setString(1, l_request_ref_no);
				cs.setString(2, l_facility_id);
				cs.setString(3, l_clinic_code);
				cs.setString(4, l_practitioner_id);
				cs.setString(5, l_clinic_from_date);
				cs.setString(6, l_clinic_to_date);
				cs.setString(7, l_all_flag);
				cs.registerOutParameter(8, Types.CLOB);
				cs.registerOutParameter(9, Types.VARCHAR);
				cs.registerOutParameter(10, Types.VARCHAR);

				cs.execute();
				
				l_errcd = cs.getString(9);
				l_status_desc = cs.getString(10);
				
				l_app_msg = " ::: Clinic Schedule Build Method - Error Code... "+l_errcd+" Error Message... "+l_status_desc;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				l_responseJsonString = cs.getString(8);					
				
				if (l_errcd.equals("S")) 
				{
					l_app_msg = " ::: Response Schedule Data successfully retrieved ::: \n "
							+ l_responseJsonString.toString().length();
					
					msgGenFlag = "S";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
					if (method.equals("G")) {
						l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
						l_app_msg = l_app_msg + " : " + l_response_str;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						return "200#" + l_responseJsonString + "#";
					}

					if (method.equals("P")) 
					{						
						l_app_msg = " ::: Inside Post Schedule details::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);						
						
						l_response_str = TransCommunicationMethod(l_protocol_link_id, eventType, l_responseJsonString, l_action_type);
						l_response_str = l_response_str.replace("$!^", "^!^");

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
				} 
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			l_errcd = "E";
			l_errmsg = l_errcd + "# Exception Occurred " + e.getMessage();
		}
		return "200#" + l_responseJsonString + "#";
	}

	public List<Map<String, String>> FetchScheduleDetails(String facility_id, String clinic_code,
			String practitioner_id, String clinic_from_date, String clinic_to_date, String l_all_flag) {
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Map<String, String>> scheduleDetls = new ArrayList<Map<String, String>>();
		Map<String, String> params = null;

		String query = "";
		String l_app_msg = "";

		l_app_msg = " Inside FetchScheduleDetails ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			dbConn = EMDataSource.getConnection();

			if (l_all_flag.equals("A")) {
				query = "select distinct a.facility_id facility_id, a.clinic_code clinic_code, a.resource_class resource_flag, "
						+ "a.practitioner_id practitioner_id from oa_clinic_schedule a "
						+ "where a.facility_id = ? and a.clinic_code = ? and a.practitioner_id = ? and clinic_date > trunc(sysdate) - 1";

				pstmt = dbConn.prepareStatement(query);
			}

			else if (l_all_flag.equals("I")) {
				query = "select distinct a.facility_id facility_id, a.clinic_code clinic_code, a.resource_class resource_flag, "
						+ "a.practitioner_id practitioner_id from oa_clinic_schedule a "
						+ "where a.facility_id = ? and a.clinic_code = ? and a.practitioner_id = ? ";

				if (l_all_flag.equals("I") && clinic_from_date.length() > 0 && clinic_to_date.length() > 0)
					query = query + " and a.clinic_date between to_date(?, 'dd/mm/yyyy') and to_date(?, 'dd/mm/yyyy')";

				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, facility_id);
				pstmt.setString(2, clinic_code);
				pstmt.setString(3, practitioner_id);

				if (l_all_flag.equals("I") && clinic_from_date.length() > 0 && clinic_to_date.length() > 0) {
					pstmt.setString(4, clinic_from_date);
					pstmt.setString(5, clinic_to_date);
				}
			}

			rs = pstmt.executeQuery();
			while (rs.next()) {
				params = new LinkedHashMap<String, String>();
				params.put("facility_id", rs.getString("facility_id"));
				params.put("clinic_code", rs.getString("clinic_code"));
				params.put("resource_flag", rs.getString("resource_flag"));
				params.put("practitioner_id",
						rs.getString("practitioner_id") == null ? "" : rs.getString("practitioner_id"));

				scheduleDetls.add(params);
			}
			l_app_msg = "::: Fetched Schedule Details ::: " + scheduleDetls;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

		} catch (Exception e) {
			params = new LinkedHashMap<String, String>();
			l_app_msg = "Error in Fetching Practitioner Details - " + e.getMessage();
			params.put("Error", l_app_msg);

			e.printStackTrace();
			scheduleDetls.add(params);
		} finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		return scheduleDetls;

	}

	public String TransCommunicationMethod(String protocolLinkID, String actionKey, String message, String action_type) {
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_element_id = "";

		String l_profile_id = "";
		String l_http_user_agent = "", l_http_content_type = "", l_http_transfer_encoding = "", l_http_soapaction = "",
				l_url = "";
		int l_http_content_length_flag = 0;

		String l_request_url = "";

		String l_proxy_server = "", l_proxy_port = "";

		HttpURLConnection conn = null;

		String l_response_msg = "", l_return_resp = "";

		l_app_msg = " ::: Inside TransCommunicationMethod ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: Protocol Link ID : " + protocolLinkID + " ::: Action Key : " + actionKey + " ::: Message : "
				+ message;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Communication Standards ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			dbConn = EMDataSource.getConnection();
			// dbConn = EMDBConnectionPool.getConnection();
			query = "SELECT    nvl(profile_id,'') profile_id, nvl(xml_style_sheet_url, '') xml_style_sheet_url, nvl(standard_code,'') standard_code, "
					+ " nvl(http_user_agent,'XXX') http_user_agent, nvl(http_content_type, 'XXX') http_content_type, nvl(http_transfer_encoding, 'XXX') http_transfer_encoding, "
					+ " nvl(http_soapaction,'XXX') http_soapaction, nvl(http_content_length_flag,0)  http_content_length_flag "
					+ " FROM    xh_protocol a, xh_protocol_link b "
					+ " WHERE    a.protocol_id = b.protocol_id AND b.protocol_link_id = ? ";

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, protocolLinkID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				l_profile_id = rs.getString("PROFILE_ID");
				l_url = rs.getString("XML_STYLE_SHEET_URL");
				l_standard_code = rs.getString("STANDARD_CODE");
				l_http_user_agent = rs.getString("HTTP_USER_AGENT");
				l_http_content_type = rs.getString("HTTP_CONTENT_TYPE");
				l_http_transfer_encoding = rs.getString("HTTP_TRANSFER_ENCODING");
				l_http_soapaction = rs.getString("HTTP_SOAPACTION");
				l_http_content_length_flag = rs.getInt("HTTP_CONTENT_LENGTH_FLAG");
			}

			l_app_msg = " ::: Profile ID : " + l_profile_id + " ::: API URL : " + l_url + " ::: Standard Code : "
					+ l_standard_code + " ::: HTTP User Agent : " + l_http_user_agent;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = " ::: HTTP Content Type : " + l_http_content_type + " ::: HTTP Transfer Encoding : "
					+ l_http_transfer_encoding + " ::: HTTP Soap Action : " + l_http_soapaction
					+ " ::: HTTP Content Length Flag : " + l_http_content_length_flag;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = "Retrieving Request URL...";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_element_id = actionKey;

			l_request_url = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_request_url : " + l_request_url;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			if (l_request_url.indexOf("Error") >= 0) {
				return l_request_url;
			}

			l_element_id = "PROXY_SERVER";

			l_proxy_server = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_proxy_server : " + l_proxy_server;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			if (l_proxy_server.indexOf("Error") >= 0) {
				return l_proxy_server;
			}

			l_element_id = "PROXY_PORT";

			l_proxy_port = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_proxy_port : " + l_proxy_port;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			if (l_proxy_port.indexOf("Error") >= 0) {
				return l_proxy_port;
			}

			l_url = l_url.trim();
			l_request_url = l_request_url.trim();

			l_url = l_url + "/" + l_request_url;

			l_url = l_url.trim();

			l_app_msg = " ::: BruHealthApp Url :" + l_url;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			URL url = new URL(l_url);

			if (l_proxy_server.length() > 0 && !l_proxy_server.equals("X")) {
				l_app_msg = " ::: Setting http Proxy...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				System.setProperty("http.proxyHost", l_proxy_server);
				System.setProperty("https.proxyHost", l_proxy_server);
			}

			if (l_proxy_port.length() > 0 && !l_proxy_server.equals("X")) {
				l_app_msg = " ::: Setting http port...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				System.setProperty("http.proxyPort", l_proxy_port);
				System.setProperty("https.proxyPort", l_proxy_port);

			}

			l_app_msg = " ::: URL Open Connection...";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			conn = (HttpURLConnection) url.openConnection();

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
			

			// Common Headers for BruHealth Transactions

			if (!(l_http_content_type.equals("XXX"))) {
				l_app_msg = " ::: Set Property Content-Type...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				conn.setRequestProperty("Content-Type", l_http_content_type);
			}

			if (!(l_http_user_agent.equals("XXX"))) {
				l_app_msg = " ::: Set Property User-Agent...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				conn.setRequestProperty("User-Agent", l_http_user_agent);
			}

			if (l_http_content_length_flag > 0) {
				l_app_msg = " ::: Set Property Content-Length...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				conn.setRequestProperty("Content-Length", Integer.toString(message.length()));
			}

			if (!(l_http_transfer_encoding.equals("XXX"))) {
				l_app_msg = " ::: Set Property Transfer-Encoding...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				conn.setRequestProperty("Transfer-Encoding", l_http_transfer_encoding);
			}

			if (!(l_http_soapaction.equals("XXX"))) {
				l_app_msg = " ::: Set Property SOAPAction...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				conn.setRequestProperty("SOAPAction", l_http_soapaction);
			}

			l_app_msg = " ::: conn.setUseCaches(false)...";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			conn.setUseCaches(false);

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

			l_app_msg = " ::: Reading the response from the OutputStream...";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			InputStream is;
			try {
				is = conn.getInputStream();
			} catch (Exception e) {
				is = conn.getErrorStream();
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((is)));

			l_app_msg = " ::: Output from Server .... \n";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			while ((l_response_msg = br.readLine()) != null) {
				l_return_resp = l_return_resp + l_response_msg;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_return_resp);
			}

			conn.disconnect();			
			
			if (conn.getResponseCode() != 200) {
				l_return_resp = "E" + "$!^" + conn.getResponseMessage() + "$!^" + l_return_resp;
				return l_return_resp;
			}
			
			
			
			
			

		} catch (MalformedURLException e) {
			e.printStackTrace();
			l_return_resp = " ";
			l_response_msg = "E" + "$!^" + "Error while " + l_app_msg + " : " + e.getMessage() + "$!^" + l_return_resp;
			System.out.println(" ::: MalformedURLException ::: " + l_response_msg);
			return l_response_msg;
		} catch (IOException e) {
			e.printStackTrace();
			l_return_resp = " ";
			l_response_msg = "E" + "$!^" + "Error while " + l_app_msg + " : " + e.getMessage() + "$!^" + l_return_resp;
			System.out.println(" ::: IOException ::: " + l_response_msg);
			return l_response_msg;
		} catch (Exception e) {
			e.printStackTrace();
			l_return_resp = " ";
			l_response_msg = "E" + "$!^" + "Error while " + l_app_msg + " : " + e.getMessage() + "$!^" + l_return_resp;
			System.out.println(" ::: Exception ::: " + l_response_msg);
			return l_response_msg;
		} finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		l_return_resp = "S" + "$!^" + " " + "$!^" + l_return_resp;
		l_app_msg = " ::: l_return_resp : " + l_return_resp;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		return l_return_resp;
	}

}
