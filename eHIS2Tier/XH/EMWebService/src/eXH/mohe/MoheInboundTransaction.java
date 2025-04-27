package eXH.mohe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

import eXH.util.EMDataSource;
import eXH.util.XHDBAdapter;
import eXH.util.XHJSONUtil;
import eXH.util.XHUtil;

//Class for Mohe Inbound Transaction
public class MoheInboundTransaction {

	/*
	 * public static void main(String[] args) { String bookApp =
	 * " {\"appointment_id\":\"0de9c617-f425-43a8-b2e7-a6cee44e09d4\"," +
	 * "\"facility_id\":\"QF\"," + "\"location_id\":\"CARD\"," +
	 * "\"doctor_id\":\"DOCTOR1\"," +
	 * "\"appointment_start_time\":\"20/07/2018 18:20:00\"," +
	 * "\"appointment_end_time\":\"20/07/2018 18:30:00\"," +
	 * "\"patient_registration_number\":\"123456\"," +
	 * "\"country_code\":\"515\"," + "\"patient_name\":\"Sachin Tendulkar\"," +
	 * "\"patient_gender\":\"M/F/U\"," + "\"patient_age\":\"45\"," +
	 * "\"patient_mobile\":\"9876512211\"," +
	 * "\"patient_email\":\"test1@gmail.com\"," +
	 * "\"appointment_type\":\"FU\"}"; moheInboundTransaction Mohe = new
	 * moheInboundTransaction();
	 * 
	 * System.out.println("Response::::" + mohe.processRequest(bookApp, "OA21"));
	 * 
	 * }
	 */

	public static String l_debug_YN = "N";

	public String l_errcd = "S", l_field_separator = "$!^";
	public String l_errmsg = "";
	public String l_ack_text = "";
	public String l_update_response_str = "";

	public static String l_conn_msg = "Error - Unable to connect to the Data base, Kindly contact the System Administrator";

	public String processRequest(String actionKey, String eventType) {
		String l_app_msg = "", l_errmsg = "";
		String l_message_id = "", l_application_id = "", l_facility_id = "", l_protocol_link_id = "", l_patient_gender = "", l_appointment_type = "";
		String l_in_JSON = "", l_err_msg = "", l_wait_time_str = "", l_sleepinterval_str = "", l_fetch_resp_time = "";

		String l_response_str = "", l_response_err_json = "";
		Map<String, String> params = new HashMap<String, String>();

		ArrayList l_external_app_details = null;

		try {

			l_debug_YN = XHUtil.l_debug_YN;

			l_app_msg = " ::: Inside MoheInboundTransactions processRequest ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = " ::: Generating Message ID ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_message_id = GenerateMessageIDMethod("XH_IB_MESSAGE_ID_SEQ");

			if (l_message_id.indexOf("Error") >= 0) {
				l_errmsg = "Message ID Generation - " + l_message_id;
				l_response_err_json = " { " + " \"status\" : \"0\" , "
						+ " \"message\" : \" " + l_errmsg + " \"  " + " } ";

				return "500#" + l_response_err_json + "#";
			}

			l_app_msg = " ::: Generated Message Id ::: " + l_message_id
					+ " ::: Error Code : " + l_errcd + " ::: Error Message : "
					+ l_errmsg;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (l_errcd.equals("S")) {
				l_app_msg = "::: Fetching External Application Details : ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_external_app_details = FetchExternalAppDetails("MOHEINB");

				if (l_external_app_details.isEmpty()) {
					l_errcd = "E";
					l_errmsg = "Error in Fetching External Application Details No Data Available";
					l_response_err_json = " { " + " \"status\" : \"0\" , "
							+ " \"message\" : \" " + l_errmsg + " \"  " + " } ";
					return "200#" + l_response_err_json + "#";
				}

				l_application_id = (String) l_external_app_details.get(0);

				if (l_application_id.indexOf("Error") >= 0) {
					l_errmsg = "Fetching External Application Details - "
							+ l_application_id;
					l_response_err_json = " { " + " \"status\" : \"0\" , "
							+ " \"message\" : \" " + l_errmsg + " \"  " + " } ";

					return "200#" + l_response_err_json + "#";
				}

				l_app_msg = " ::: Message ID : " + l_message_id
						+ " ::: External Application : "
						+ l_external_app_details + " ::: Error Code : "
						+ l_errcd + " ::: Error Message : " + l_errmsg;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

			}

			if (l_errcd.equals("S")) {
				l_application_id = (String) l_external_app_details.get(0);
				l_protocol_link_id = (String) l_external_app_details.get(1);
				l_facility_id = (String) l_external_app_details.get(2);
			}

			params.put("MESSAGE_ID", l_message_id);
			params.put("APPLICATION_ID", l_application_id);
			params.put("FACILITY_ID", l_facility_id);
			params.put("PROTOCOL_LINK_ID", l_protocol_link_id);
			params.put("EVENT_TYPE", eventType);

			l_app_msg = "::: Parsing input message ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_in_JSON = XHJSONUtil.createJsonObject(actionKey);

			if (l_in_JSON.indexOf("Error") >= 0) {
				l_errcd = "E";
				l_err_msg = l_in_JSON;

				l_response_err_json = " { " + " \"status\" : \"0\" , "
						+ " \"message\" : \" " + l_err_msg + " \"  " + " } ";

				l_app_msg = "::: Loading the message when : " + l_err_msg;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_response_str = MessageLoadMethod(actionKey, params, l_errcd,
						l_response_err_json);
				l_app_msg = l_app_msg + " : " + l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				return "200#" + l_response_err_json + "#";

			}

			l_app_msg = "::: Getting Facility Id from JSON ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_facility_id = XHJSONUtil.getJsonRequestString(l_in_JSON,
					"facility_id");

			if (l_facility_id.length() > 2) {
				l_errmsg = "Error in Facility ID,Please Check Request Facility ID - "
						+ l_facility_id;
				l_response_err_json = " { " + " \"status\" : \"0\" , "
						+ " \"message\" : \" " + l_errmsg + " \"  " + " } ";

				return "200#" + l_response_err_json + "#";
			}

			l_app_msg = "::: Getting Patient Gender from JSON ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_patient_gender = XHJSONUtil.getJsonRequestString(l_in_JSON,
					"patient_gender");

			if (l_patient_gender.length() > 1) {
				l_errmsg = "Error in Patient Gender,Please Check Resuest Patient Gender - "
						+ l_patient_gender;
				l_response_err_json = " { " + " \"status\" : \"0\" , "
						+ " \"message\" : \" " + l_errmsg + " \"  " + " } ";

				return "200#" + l_response_err_json + "#";
			}

			l_app_msg = "::: Getting Appointment Type from JSON ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_appointment_type = XHJSONUtil.getJsonRequestString(l_in_JSON,
					"appointment_type");

			if (l_appointment_type.length() > 2) {
				l_errmsg = "Error in Appointment Type,Please Check Request Appointment Type - "
						+ l_appointment_type;
				l_response_err_json = " { " + " \"status\" : \"0\" , "
						+ " \"message\" : \" " + l_errmsg + " \"  " + " } ";

				return "200#" + l_response_err_json + "#";
			}

			if (l_facility_id.indexOf("Error") >= 0) {
				l_errcd = "E";
				l_errmsg = l_app_msg + "$!^" + l_facility_id;
				l_response_err_json = " { " + " \"status\" : \"0\" , "
						+ " \"message\" : \" " + l_facility_id + " \"  "
						+ " } ";

				l_app_msg = "::: Loading the message when : " + l_err_msg;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_response_str = MessageLoadMethod(actionKey, params, l_errcd,
						l_response_err_json);
				l_app_msg = l_app_msg + " : " + l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				return "200#" + l_response_err_json + "#";
			}

			l_app_msg = " ::: l_facility_id : " + l_facility_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			params.put("FACILITY_ID", l_facility_id);

			/*l_app_msg = "::: Validating the request with key ::: " + key;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_response_err_json = validateRequest(key);

			if (l_errcd.equals("E")) {

				l_app_msg = "::: Loading the message when : " + l_err_msg;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_response_str = MessageLoadMethod(actionKey, params, l_errcd,
						l_response_err_json);
				l_app_msg = l_app_msg + " : " + l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				return "401#" + l_response_err_json + "#";
			}*/

			if (l_errcd.equals("S")) {
				l_app_msg = "::: On successful transaction the message is loaded ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				if (l_debug_YN.equals("Y"))
					System.out.println("l_errcd.."+l_errcd);

				l_response_str = MessageLoadMethod(actionKey, params, l_errcd,
						"");
				l_app_msg = l_app_msg + " : " + l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_app_msg = "Calling Fetch Response WaitTime...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_fetch_resp_time = FetchResponseWaitTime("MOHE");
				if (l_fetch_resp_time.indexOf("Error") >= 0) {
					l_errcd = "E";
					l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^"
							+ l_fetch_resp_time;

					if (l_debug_YN.equals("Y"))
						System.out.println(l_errmsg);

					l_fetch_resp_time = "10#5";

				}

				l_app_msg = " ::: Fetch Response Time : " + l_fetch_resp_time;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				String[] l_fetch_time_str = l_fetch_resp_time.split("#");

				l_wait_time_str = l_fetch_time_str[0];
				l_app_msg = " ::: Wait Response Time : " + l_wait_time_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_sleepinterval_str = l_fetch_time_str[1];
				l_app_msg = " ::: Sleep Interval Time : " + l_sleepinterval_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);


				final Map<String, String> temp = new HashMap<String, String>();
				temp.putAll(params);
				System.out.println("Temp ::: " + temp);

				class RunMyTask extends TimerTask {

					@Override
					public void run() {
						
						l_update_response_str = waitUpdation(temp);
						if (!l_update_response_str.equals("false")) {
							cancel();
						}
					}
				}
				;
				int l_interval = Integer.parseInt(l_sleepinterval_str);
				l_app_msg = " ::: Sleep Interval Calculated : " + l_interval;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				int l_wait_time = Integer.parseInt(l_wait_time_str);
				l_app_msg = " ::: Wait Time Calculated : " + l_wait_time;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				RunMyTask task = new RunMyTask();

				Timer timer = new Timer();
				timer.scheduleAtFixedRate(task, l_interval * 1000,
						l_wait_time * 1000);
				l_update_response_str = waitUpdation(params);

				l_app_msg = " ::: Response Updated : " + l_update_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				return l_update_response_str;

			}

		} catch (Exception e) {
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^ Exception Occurred "
					+ e.getMessage();
			l_response_err_json = " { " + " \"status\" : \"0\" , "
					+ " \"message\" : \"Reference Number :" + l_message_id
					+ " Exception : " + e.getMessage() + " \"  " + " } ";

			l_app_msg = "::: On Exception the message is loaded ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_response_str = MessageLoadMethod(actionKey, params, l_errcd,
					l_response_err_json);
			l_app_msg = l_app_msg + " : " + l_response_str;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			return "200#" + l_response_err_json + "#";
		}

		return "200#" + l_response_str + "#";
	}

	public String MessageLoadMethod(String message, Map<String, String> param,
			String status, String err_message) {

		String l_app_msg = "";
		String l_request_date = "", l_status_return = "";

		Timestamp timestamp = null;

		try {

			l_app_msg = " ::: Inside Message Loading ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_request_date = getFormattedStringDate("dd-MMM-yyyy HH:mm:ss",
					new java.util.Date());

			timestamp = new Timestamp(System.currentTimeMillis());

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

			params.put("ADDED_BY_ID", "INTERFACE");
			params.put("ADDED_BY_DATE", l_request_date);
			params.put("CLIENT_MACHINE", "INTERFACE");
			params.put("ADDED_BY_FACILITY", "HS");

			params.put("MODIFIED_BY_ID", "INTERFACE");
			params.put("MODIFIED_BY_DATE", l_request_date);
			params.put("CLIENT_MACHINE", "INTERFACE");
			params.put("MODIFIED_BY_FACILITY", "HS");

			params.put("PATIENT_ID", "");
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
			params.put("ERR_MSG", param.get("ERR_MSG"));

			l_app_msg = "Inserting Inbound Message...";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_status_return = insertInboundMessageDetails(params);

			l_app_msg = "Inserting Inbound Message Status : " + l_status_return;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

		} catch (Exception e) {
			l_errcd = "E";
			l_errmsg = "Error in Loading the request message Status : "
					+ l_status_return + " Exception : " + e.getMessage();
			l_status_return = l_errmsg;
		}

		return l_status_return;
	}

	public String waitUpdation(Map<String, String> params) {

		String l_response_str = "", l_app_msg = "", l_errmsg = "";
		String l_message_status = "", l_message_ack_text = "";

		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";

		try {

			l_app_msg = " ::: Inside  Wait Updation ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			dbConn = EMDataSource.getConnection();
			query = "SELECT MESSAGE_STATUS,ERR_MSG,MESSAGE_ACK_TEXT FROM XH_INBOUND_MESSAGE WHERE APPLICATION_ID = ? and FACILITY_ID = ? and MESSAGE_ID = ? and EVENT_TYPE = ?";

			System.out.println("Inside  Wait Updation-Params:"+params.get("APPLICATION_ID")+","+params.get("FACILITY_ID")+","+params.get("MESSAGE_ID")+","+params.get("EVENT_TYPE"));

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, params.get("APPLICATION_ID"));
			pstmt.setString(2, params.get("FACILITY_ID"));
			pstmt.setString(3, params.get("MESSAGE_ID"));
			pstmt.setString(4, params.get("EVENT_TYPE"));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				l_message_status = rs.getString("MESSAGE_STATUS");
				System.out.println("l_message_status...."+l_message_status);
				l_message_ack_text = rs.getString("MESSAGE_ACK_TEXT");	
				System.out.println("l_message_ack_text...."+l_message_ack_text);
			}
			if ((l_message_status.equals("L") || l_message_status.equals("E"))
					&& l_message_ack_text.length() > 0) {
				return "200#" + l_message_ack_text + "#";
			} else {
				l_response_str = " { " + " \"status\" : \"0\" , "
						+ " \"message\" : \"Reference Number :"
						+ params.get("MESSAGE_ID")
						+ ", Transaction Failed \"  " + " } ";

				return "false";
			}

		} catch (Exception e) {
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^ Exception Occurred "
					+ e.getMessage();

			if (l_debug_YN.equals("Y"))
				System.out.println(l_errmsg);

			l_response_str = " { " + " \"status\" : \"0\" , "
					+ " \"message\" : \"Reference Number :"
					+ params.get("MESSAGE_ID") + ", Exception Occurred "
					+ e.getMessage() + " \"  " + " } ";

			return "200#" + l_response_str + "#";
		} finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
	}

	public static String getFormattedStringDate(String format, Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
		String dateFormatted = dateFormat.format(date);
		return dateFormatted;
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
			l_field_value = "Error in Generating Message ID Exception - "
					+ e.getMessage();
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
			query = "SELECT APPLICATION_ID,PROTOCOL_LINK_ID,FACILITY_ID FROM xh_filter_dms_vw WHERE EXTERNAL_APPLICATION = 'MOHEINB'";

			if (dbConn == null) {
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

			l_app_msg = " ::: Application ID : " + l_application_id
					+ " ::: Protocol Link Id : " + l_protocol_link_id
					+ " ::: Facility Id : " + l_facility_id;
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
			EMDataSource.returnConnection(dbConn);
		}
		return externalArray;
	}

	public String insertInboundMessageDetails(Map<String, String> params) {
		String insertstmt = "INSERT INTO XH_INBOUND_MESSAGE (application_id, facility_id, message_id, srl_no, message_received_date, process_id, "
				+ " client_id, inbound_message_text, message_ack_text, message_status, rd_order_yn, "
				+ " added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, "
				+ " patient_id, merged_patient_id, episode_type, episode_id, visit_id, accession_num, action_type, "
				+ " last_proc_date, event_status, not_req_reason, ext_accession_num, event_type, protocol_link_id,err_msg) "
				+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

		Connection dbConn = null;
		PreparedStatement pstmt = null;

		int insertCount = 0;

		String l_app_msg = "";

		String l_date = "";

		String l_err_msg = "Success";

		try {

			l_app_msg = " ::: Inside Inbound Message Details ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			dbConn = EMDataSource.getConnection();


			if (dbConn == null) {
				return l_conn_msg;
			}

			pstmt = dbConn.prepareStatement(insertstmt);

			l_date = params.get("REQUEST_DATE");

			l_app_msg = " ::: Requested Date : " + l_date;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			pstmt.setString(1, params.get("APPLICATION_ID"));
			pstmt.setString(2, params.get("FACILITY_ID"));
			pstmt.setString(3, params.get("MSG_ID"));
			pstmt.setString(4, params.get("SRL_NO")); // SRL_NO
			pstmt.setTimestamp(5,
					new java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(6,
					XHDBAdapter.isNullReplace(params.get("PROCESS_ID"), "")); // PROCESS_ID

			pstmt.setString(7,
					XHDBAdapter.isNullReplace(params.get("CLIENT_ID"), "")); // CLIENT_ID
			pstmt.setString(8, params.get("MESSAGE_TEXT")); // INBOUND_MESSAGE_TEXT
			pstmt.setString(9, XHDBAdapter.isNullReplace(
					params.get("MESSAGE_ACK_TEXT"), "")); // MESSAGE_ACK_TEXT
			pstmt.setString(10,
					XHDBAdapter.isNullReplace(params.get("MESSAGE_STATUS"), "")); // MESSAGE_STATUS
			pstmt.setString(11,
					XHDBAdapter.isNullReplace(params.get("RD_ORDER_YN"), "")); // RD_ORDER_YN

			pstmt.setString(
					12,
					XHDBAdapter.isNullReplace(params.get("ADDED_BY_ID"),
							params.get("LOGIN_USER")));
			pstmt.setTimestamp(13,
					new java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(14, params.get("CLIENT_MACHINE"));
			pstmt.setString(15, XHDBAdapter.isNullReplace(
					params.get("ADDED_BY_FACILITY"), params.get("FACILITY_ID")));

			pstmt.setString(16, XHDBAdapter.isNullReplace(
					params.get("MODIFIED_BY_ID"), params.get("LOGIN_USER")));
			pstmt.setTimestamp(17,
					new java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(18, params.get("CLIENT_MACHINE"));
			pstmt.setString(
					19,
					XHDBAdapter.isNullReplace(
							params.get("MODIFIED_BY_FACILITY"),
							params.get("FACILITY_ID")));

			pstmt.setString(20,
					XHDBAdapter.isNullReplace(params.get("PATIENT_ID"), ""));
			pstmt.setString(21, XHDBAdapter.isNullReplace(
					params.get("MERGED_PATIENT_ID"), ""));
			pstmt.setString(22,
					XHDBAdapter.isNullReplace(params.get("EPISODE_TYPE"), ""));
			pstmt.setString(23,
					XHDBAdapter.isNullReplace(params.get("EPISODE_ID"), ""));
			pstmt.setString(24,
					XHDBAdapter.isNullReplace(params.get("VISIT_ID"), ""));
			pstmt.setString(25,
					XHDBAdapter.isNullReplace(params.get("ACCESSION_NUM"), ""));
			pstmt.setString(26,
					XHDBAdapter.isNullReplace(params.get("ACTION_TYPE"), ""));

			pstmt.setString(27,
					XHDBAdapter.isNullReplace(params.get("LAST_PROC_DATE"), ""));
			pstmt.setString(28,
					XHDBAdapter.isNullReplace(params.get("EVENT_STATUS"), ""));
			pstmt.setString(29,
					XHDBAdapter.isNullReplace(params.get("NOT_REQ_REASON"), ""));
			pstmt.setString(30, XHDBAdapter.isNullReplace(
					params.get("EXT_ACCESSION_NUM"), ""));
			pstmt.setString(31,
					XHDBAdapter.isNullReplace(params.get("EVENT_TYPE"), ""));
			pstmt.setString(32, XHDBAdapter.isNullReplace(
					params.get("PROTOCOL_LINK_ID"), ""));
			pstmt.setString(33,
					XHDBAdapter.isNullReplace(params.get("ERR_MSG"), ""));

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

			return l_err_msg;

		} catch (Exception exp) {
			l_errcd = "E";
			l_err_msg = "Error in " + exp.getMessage();

			if (l_debug_YN.equals("Y"))
				System.out.println(l_err_msg);

			return l_err_msg;
		} finally {
			XHUtil.closeDBResources(null, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
	}

	public static String FetchResponseWaitTime(String pluginType) {

		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		int l_wait_time = 10;
		int l_sleep_interval = 5;

		l_app_msg = " ::: Inside FetchResponseWaitTime ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: Plugin Type : " + pluginType;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			dbConn = EMDataSource.getConnection();
			// dbConn = EMDBConnectionPool.getConnection();
			query = "SELECT NVL(COMM_PROCESS_IDLE_TIME, 0) COMM_PROCESS_IDLE_TIME,NVL(SLEEPINTERVAL, 0) SLEEPINTERVAL FROM XH_INTERACTIVE_CONNECT_PARAM "
					+ " WHERE PLUGIN_TYPE = ? ";

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, pluginType);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				l_wait_time = rs.getInt("COMM_PROCESS_IDLE_TIME");
				l_sleep_interval = rs.getInt("SLEEPINTERVAL");
			}

			l_field_value = String.valueOf(l_wait_time) + "#"
					+ String.valueOf(l_sleep_interval);

			l_app_msg = " Response Time ::: " + l_field_value;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

		} catch (Exception e) {
			l_field_value = "Error in fetching the response wait time : "
					+ e.getMessage();
		} finally {
			// XHUtil.closeDBResources(rs, pstmt, dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}

		return l_field_value;
	}

}
