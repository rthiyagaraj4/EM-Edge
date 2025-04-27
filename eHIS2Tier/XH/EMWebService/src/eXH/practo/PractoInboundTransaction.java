package eXH.practo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import org.codehaus.jackson.map.ObjectMapper;
import eXH.util.*;

//Class for Practo Inbound Transaction
//Added for KDAH-CRF-0456 by Kapil on 25/07/2018
public class PractoInboundTransaction {

	public static final String l_standard_code = "HTTPCC";
	public static final String l_segment_id = "PWS";
	public static String added_at_ws_no = "";
	public static String modified_at_ws_no = "";
	public static String modified_by_id = "";
	public static String added_by_id = "";

	public static boolean insertable = false;

	/*
	 * public static void main(String[] args) { String bookApp =
	 * " {\"appointment_id\":\"0de9c617-f425-43a8-b2e7-a6cee44e09d4\"," +
	 * "\"facility_id\":\"KH\"," + "\"location_id\":\"CARD\"," +
	 * "\"doctor_id\":\"DOCTOR1\"," +
	 * "\"appointment_start_time\":\"20/07/2018 18:20:00\"," +
	 * "\"appointment_end_time\":\"20/07/2018 18:30:00\"," +
	 * "\"patient_registration_number\":\"KH00123456\"," +
	 * "\"country_code\":\"515\"," + "\"patient_name\":\"Sachin Tendulkar\"," +
	 * "\"patient_gender\":\"M/F/U\"," + "\"patient_age\":\"45\"," +
	 * "\"patient_mobile\":\"9876512211\"," +
	 * "\"patient_email\":\"test1@gmail.com\"," +
	 * "\"appointment_type\":\"FU\"}"; ProctoInboundTransaction pract = new
	 * ProctoInboundTransaction();
	 * 
	 * System.out.println("Response::::" + pract.processRequest(bookApp, "OA21",
	 * "atfo8z"));
	 * 
	 * }
	 */

	public static String l_debug_YN = "N";

	public String l_errcd = "S", l_field_separator = "$!^";
	public String l_errmsg = "";
	public String l_ack_text = "";
	public String l_update_response_str = "";

	public static String l_conn_msg = "Error - Unable to connect to the Data base, Kindly contact the System Administrator";
	
	public static String l_nationality_code = "";

	public String processRequest(String actionKey, String eventType, String key) {
		String l_app_msg = "", l_errmsg = "";
		String l_message_id = "", l_application_id = "", l_facility_id = "", l_protocol_link_id = "",
				l_patient_gender = "", l_appointment_type = "";
		String l_in_JSON = "", l_err_msg = "", l_wait_time_str = "", l_sleepinterval_str = "", l_fetch_resp_time = "";

		String l_response_str = "", l_response_err_json = "";
		Map<String, String> params = new HashMap<String, String>();

		ArrayList<String> l_external_app_details = null;

		try {

			l_debug_YN = XHUtil.l_debug_YN;

			l_app_msg = " ::: Inside PractoInboundTransactions processRequest ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = " ::: Generating Message ID ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_message_id = GenerateMessageIDMethod("XH_IB_MESSAGE_ID_SEQ");

			if (l_message_id.indexOf("Error") >= 0) {
				l_errmsg = "Message ID Generation - " + l_message_id;
				l_response_err_json = " { " + " \"status\":0, " + " \"message\":\" " + l_errmsg + " \"  "
						+ " } ";

				return "200#" + l_response_err_json + "#";
			}

			l_app_msg = " ::: Generated Message Id ::: " + l_message_id + " ::: Error Code : " + l_errcd
					+ " ::: Error Message : " + l_errmsg;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (l_errcd.equals("S")) {
				l_app_msg = "::: Fetching External Application Details : ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_external_app_details = FetchExternalAppDetails("PRACTOINB");

				if (l_external_app_details.isEmpty()) {
					l_errcd = "E";
					l_errmsg = "Error in Fetching External Application Details No Data Available";
					l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_errmsg + " \"  "
							+ " } ";
					return "200#" + l_response_err_json + "#";
				}

				l_application_id = (String) l_external_app_details.get(0);

				if (l_application_id.indexOf("Error") >= 0) {
					l_errmsg = "Fetching External Application Details - " + l_application_id;
					l_response_err_json = " { " + " \"status\":0, " + " \"message\":\" " + l_errmsg + " \"  "
							+ " } ";

					return "200#" + l_response_err_json + "#";
				}

				l_app_msg = " ::: Message ID : " + l_message_id + " ::: External Application : "
						+ l_external_app_details + " ::: Error Code : " + l_errcd + " ::: Error Message : " + l_errmsg;
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

				l_response_err_json = " { " + " \"status\":0, " + " \"message\":\" " + l_err_msg + " \"  "
						+ " } ";

				l_app_msg = "::: Loading the message when : " + l_err_msg;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
				l_app_msg = l_app_msg + " : " + l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				return "200#" + l_response_err_json + "#";

			}

			l_app_msg = "::: Getting Facility Id from JSON ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_facility_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "facility_id");

			//
			if (l_facility_id.length() > 2) {
				l_errmsg = "Error in Facility ID, Please Check the Facility ID in the request - " + l_facility_id;
				l_response_err_json = " { " + " \"status\":0, " + " \"message\":\" " + l_errmsg + " \"  "
						+ " } ";

				return "200#" + l_response_err_json + "#";
			}

			l_app_msg = "::: Getting Patient Gender from JSON ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_patient_gender = XHJSONUtil.getJsonRequestString(l_in_JSON, "patient_gender");

			if (l_patient_gender.length() > 1) {
				l_errmsg = "Error in Patient Gender,Please Check the Patient Gender in the request - "
						+ l_patient_gender;
				l_response_err_json = " { " + " \"status\":0, " + " \"message\":\" " + l_errmsg + " \"  "
						+ " } ";

				return "200#" + l_response_err_json + "#";
			}

			l_app_msg = "::: Getting Appointment Type from JSON ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_appointment_type = XHJSONUtil.getJsonRequestString(l_in_JSON, "appointment_type");

			if (l_appointment_type.length() > 2) {
				l_errmsg = "Error in Appointment Type, Please Check the Appointment Type in the request - "
						+ l_appointment_type;
				l_response_err_json = " { " + " \"status\":0, " + " \"message\":\" " + l_errmsg + " \"  "
						+ " } ";

				return "200#" + l_response_err_json + "#";
			}

			if (l_facility_id.indexOf("Error") >= 0) {
				l_errcd = "E";
				l_errmsg = l_app_msg + "$!^" + l_facility_id;
				l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_facility_id + " \"  "
						+ " } ";

				l_app_msg = "::: Loading the message when : " + l_err_msg;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
				l_app_msg = l_app_msg + " : " + l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				return "200#" + l_response_err_json + "#";
			}

			l_app_msg = " ::: Facility Id : " + l_facility_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			params.put("FACILITY_ID", l_facility_id);

			l_app_msg = "::: Validating the request with key ::: " + key;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_response_err_json = validateRequest(key);

			if (l_errcd.equals("E")) {

				l_app_msg = "::: Loading the message when : " + l_err_msg;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
				l_app_msg = l_app_msg + " : " + l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				return "401#" + l_response_err_json + "#";
			}

			if (l_errcd.equals("S")) {
				l_app_msg = "::: On successful transaction the message is loaded ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_response_str = MessageLoadMethod(actionKey, params, l_errcd, "");
				l_app_msg = l_app_msg + " : " + l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_app_msg = "Calling Fetch Response WaitTime...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_fetch_resp_time = FetchResponseWaitTime("PRACTO");
				if (l_fetch_resp_time.indexOf("Error") >= 0) {
					l_errcd = "E";
					l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_fetch_resp_time;

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

				/*
				 * final Map<String, String> temp = new HashMap<String,
				 * String>(); temp.putAll(params); class ScheduledTask extends
				 * TimerTask { String l_resp_msg = "";
				 * 
				 * public void run() { l_resp_msg = waitUpdation(temp); } } ;
				 * 
				 * Timer time = new Timer(); ScheduledTask st = new
				 * ScheduledTask(); time.schedule(st, 0, 2000);
				 */

				final Map<String, String> temp = new HashMap<String, String>();
				temp.putAll(params);
				System.out.println("Temp ::: " + temp);

				class RunMyTask extends TimerTask {
					// String l_resp_msg = "";
					// Timer timer = new Timer();

					@Override
					public void run() {
						// System.out.println("Before waitUpdation() :::");
						l_update_response_str = waitUpdation(temp);
						// System.out.println("waitUpdation Response :::"+
						// l_updation_resp);
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

				// TimerTask task = new RunMyTask();
				RunMyTask task = new RunMyTask();

				Timer timer = new Timer();
				// timer.schedule(task, 2000,30000);
				timer.scheduleAtFixedRate(task, l_interval * 1000, l_wait_time * 1000);
				l_update_response_str = waitUpdation(params);

				l_app_msg = " ::: Response Updated : " + l_update_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				// System.out.println("Task Timer response::::"+
				// l_updation_resp);

				return l_update_response_str;

			}

		} catch (Exception e) {
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^ Exception Occurred " + e.getMessage();
			l_response_err_json = " { " + " \"status\":0, " + " \"message\":\"Reference Number :"
					+ l_message_id + " Exception : " + e.getMessage() + " \"  " + " } ";

			l_app_msg = "::: On Exception the message is loaded ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
			l_app_msg = l_app_msg + " : " + l_response_str;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			return "200#" + l_response_err_json + "#";
		}

		return "200#" + l_response_str + "#";
	}

	@SuppressWarnings("static-access")
	public String processVisitRequest(String actionKey) {

		String l_app_msg = "", l_err_msg = "";
		String l_response_err_json = "", l_facility_id = "";
		String l_in_JSON = "", l_response_str = "", l_message_id = "", l_application_id = "", l_protocol_link_id = "";
		String l_status = "", l_status_desc = "";
		String l_request_date_time = "", l_response_txt = "";

		String l_visit_date_time = "", l_visit_type = "", l_location_type = "", l_service_code = "";

		StringBuffer l_error = null;

		String l_patient_id = "", l_location_id = "", l_practitioner_id = "";
		String l_episode_no = "", l_visitno = "", k_visit_type_ind = "", new_op_episode_yn = "", l_element_id = "",
				l_encounter_id = "";

		ObjectMapper objMapper = new ObjectMapper();
		Map<String, String> v_visit_type_validation_map = new LinkedHashMap<String, String>();
		Map<String, String> episodeMap = new HashMap<String, String>();
		Map<String, String> encounterMap = new HashMap<String, String>();
		Map<String, String> clinicMap = new HashMap<String, String>();
		ArrayList<String> l_external_app_details = null;
		Map<String, String> params = new HashMap<String, String>();
		Map<String, Object> l_response_json = new HashMap<String, Object>();
		Map<String, String> l_req_params = new HashMap<String, String>();
		PractoInboundTransaction practoInboundTransaction = new PractoInboundTransaction();

		String l_request_ref_no = "", l_request_type = "", l_responseJsonString = "", l_visitnum = "",
				l_receipt_no = "", l_bill_no = "", l_BLNG_GRP_ID = "", l_REC_TYPE_CODE = "", l_ext_appt_ref_no = "";

		List<Map<String, String>> visitData = new ArrayList<Map<String, String>>();

		String l_calling_function_id = "VISIT_REGISTRATION";

		Connection dbConn = null;
		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String query = "";
		String l_ASSIGN_QUEUE_NUM_BY = "", l_QMS_INTERFACED_YN = "", l_VISIT_TYPE_DERV_RULE = "",
				l_billing_group_code = "", l_settlement_type_code = "", l_appt_id = "";
		String l_appt_time = "", l_appt_status = "", l_request_id = "", l_refferal_id = "", l_p_id = "W",
				l_queueID = "";
		int l_quenum = 0;
		String l_slmt_ind = "", l_adm_rec_flag = "";
		String l_fin_class_flag_YN = "";
		int l_assessmentMonths = 0;
		String l_episode_type = "O", l_calling_module_id = "OP", l_REFERRAL_SOURCE_CODE_MAIN = "",
				l_REFERRAL_SOURCE_CODE_SUB = "", l_employer_code = "", l_slmt_type_code = "";

		String l_cust_group_code = "", l_cust_code = "", l_credit_doc_ref_desc = "", l_credit_doc_ref_start_date = "",
				l_credit_doc_ref_date = "";
		String l_slmt_doc_ref_desc = "", l_slmt_doc_ref_date = "", l_slmt_doc_remarks = "", l_non_ins_blng_grp_id = "",
				l_NON_INS_REF_SOURCE_CODE_MAIN = "";
		String l_NON_INS_REF_SOURCE_CODE_SUB = "", l_non_ins_cust_group_code = "", l_non_ins_cust_code = "",
				l_annual_family_income = "", l_family_assets_value = "";
		String l_num_of_dependents = "", l_resp_for_bill_payment = "", l_pat_reln_with_resp_pers = "",
				l_gl_holder_name = "", l_pat_reln_with_gl_holder = "";
		String l_NO_OF_ENC_GL_VALID = "", l_NO_OF_AE_ENC_GL_VALID = "", l_NO_OF_OP_ENC_GL_VALID = "",
				l_NO_OF_IP_ENC_GL_VALID = "", l_NO_OF_DC_ENC_GL_VALID = "";
		String l_remarks = "", l_PATIENT_INC_ASSET_IND = "", l_PATIENT_INC_ASSET_AMT = "",
				l_PATIENT_INC_ASSET_FREQ = "", l_SPOUSE_INC_ASSET_AMT = "";
		String l_SPOUSE_INC_ASSET_FREQ = "", l_DEPENDENT_INC_ASSET_AMT = "", l_DEPENDENT_INC_ASSET_FREQ = "",
				l_CLASSIFICATION_CODE = "", l_CLASSIFICATION_TYPE = "";
		String l_CLASSIFICATION_START_DATE = "", l_CLASSIFICATION_END_DATE = "", l_financial_remarks = "",
				l_SOCIAL_PENSIONER_ID = "";
		String l_dflt_prv_fin_dtl_acrs_enc_yn = "N", l_build_episode_rule = "";
		String l_ref_src_main_code = "", l_ref_src_sub_code = "", l_priority = "", l_credit_auth_ref = "",
				l_credit_auth_date = "", l_effective_from = "";
		String l_effective_to = "", l_approved_amt = "", l_approved_days = "", l_adj_rule_ind = "",
				l_adj_perc_amt_ind = "", l_adj_perc_amt_value = "";
		String l_pmnt_diff_adj_int = "", l_drg_pmnt_diff_adj_int = "", l_spl_srv_pmnt_diff_adj_int = "";
		String l_str_cust_group_code = "", l_str_cust_code = "", l_str_doc_ref = "", l_str_doc_start_date = "",
				l_str_doc_end_date;
		String l_payer_group_code = "", l_payer_code = "";
		String l_visit_type_ind = "", l_visit_status = "01";
		String l_policy_type_code = "";
		String l_error_level = "", l_sys_message_id = "", l_error_text = "", l_bill_doc_type_code = "",
				l_slmt_doc_type_code = "";

		int bill_no = 0, receipt_no = 0, l_amount = 0;

		String l_assign_pract_yn = "N", l_start_consult_yn = "N", l_end_consult_yn = "N";
		String l_visit_status_set_on_date = "", l_visit_status_set_by_user = "";
		String l_episode_status = "", l_last_visit_fu_reqd_yn = "";
		String l_queue_status = "", l_self_check_in = "", l_arrive_date_time = "",
				l_other_res_class = "*";
		String l_other_resource_id = "*ALL", l_con_srvc_start_date_time = "", l_cons_srvc_end_date_time = "",
				l_prev_visit_status = "";
		String l_srvc_start_date_time = "", l_srvc_end_date_time = "", l_notes = "";
		
		String l_sm_message = "";

		try {

			l_debug_YN = XHUtil.l_debug_YN;

			l_app_msg = " ************ Practo Register Patient Transaction started ************ ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_error = new StringBuffer("Unable to Register the Patient - Information Missing");

			l_app_msg = " ::: Inside Practo Register Patient Details :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = " ::: Generating Message ID ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_message_id = practoInboundTransaction.GenerateMessageIDMethod("XH_IB_MESSAGE_ID_SEQ");

			if (l_message_id.indexOf("Error") >= 0) {
				l_errmsg = "Error in Message ID Generation - " + l_message_id;

				l_response_err_json = " { " + " \"status\":0, " + " \"status_desc\":\" " + l_errmsg + " \"  "
						+ " } ";

				return "200#" + l_response_err_json + "#";

			}

			l_app_msg = " ::: Generated Message Id ::: " + l_message_id + " ::: Error Code : " + l_errcd
					+ " ::: Error Message : " + l_errmsg;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			if (l_errcd.equals("S")) {
				l_app_msg = " ::: Fetching External Application Details : ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_external_app_details = practoInboundTransaction.FetchExternalAppDetails("PRACTOINB");

				if (l_external_app_details.isEmpty()) {
					l_errcd = "E";
					l_errmsg = "Error in Fetching External Application Details No Data Available";
					l_response_err_json = " { " + " \"status\":0, " + " \"status_desc\":\" " + l_errmsg
							+ " \"  " + " } ";
					return "200#" + l_response_err_json + "#";

				}

				l_application_id = (String) l_external_app_details.get(0);

				if (l_application_id.indexOf("Error") >= 0) {
					l_errmsg = "Fetching External Application Details - " + l_application_id;
					l_response_err_json = " { " + " \"status\":0, " + " \"status_desc\":\" " + l_errmsg
							+ " \"  " + " } ";

					return "200#" + l_response_err_json + "#";

				}

				l_app_msg = " ::: Message ID : " + l_message_id + " ::: External Application : "
						+ l_external_app_details + " ::: Error Code : " + l_errcd + " ::: Error Message : " + l_errmsg;
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
			params.put("EVENT_TYPE", "OA33");	
			
			l_in_JSON = XHJSONUtil.createJsonObject(actionKey);

			if (l_in_JSON.indexOf("Error") >= 0) {
				l_errcd = "E";
				l_err_msg = l_in_JSON;

				l_response_err_json = " { " + " \"status\":0, " + " \"message\":\" " + l_err_msg + " \"  "
						+ " } ";
				
				params.put("STATUS", l_errcd);
				params.put("ERR_MSG", l_response_err_json);

				l_app_msg = "::: Error in parsing the request message : " + l_err_msg;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_responseJsonString = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
				l_app_msg = l_app_msg + " : " + l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				return "200#" + l_response_err_json + "#";

			}
			
			l_app_msg = "::: Parsing input message ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);	
			
			l_patient_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "visit_data", "patient_id");
			l_app_msg = " ::: Patient ID : " + l_patient_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (l_patient_id.indexOf("Exception in") >= 0 || "".equals(l_patient_id.trim())) {
				l_errcd = "E";
				if ("".equals(l_patient_id.trim())) {
					l_error.append("- Patient Id cannot be empty ");
				}
			}			
			params.put("PATIENT_ID", l_patient_id);

			if (l_errcd.equals("E")) {
				
				params.put("STATUS", l_errcd);
				params.put("ERR_MSG", l_error.toString());
				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);
				return "200#" + l_responseJsonString + "#";
			}			
			
			l_response_txt = MessageLoadMethod(actionKey, params, l_errcd, "");
			l_app_msg = " ::: Message Load Method  ::: " + l_response_txt;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);					

			l_app_msg = " ::: Fetching Added By Id ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_element_id = "BL_USER_ID";

			added_by_id = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Added By Id ::: " + added_by_id);

			l_app_msg = " ::: Fetching Work Station number ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_element_id = "BL_WS_NO";

			added_at_ws_no = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Work Station number ::: " + added_at_ws_no);

			modified_by_id = added_by_id;

			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Modified By Id ::: " + modified_by_id);

			modified_at_ws_no = added_at_ws_no;
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Modified Work Station number ::: " + modified_at_ws_no);

			l_element_id = "REC_TYPE_CODE";

			l_REC_TYPE_CODE = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Receipt Type Code ::: " + l_REC_TYPE_CODE);

			l_app_msg = " ::: Action Key :::" + actionKey;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = " ::: Parsing input message ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			params.put("ERR_MSG", "");

			l_responseJsonString = "";

			if (l_errcd.equals("E")) {
				l_app_msg = " ::: Inserting Request into Message Table ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				params.put("STATUS", l_errcd);
				params.put("ERR_MSG", l_error.toString());

				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);

				return "200#" + l_responseJsonString + "#";

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
			if (l_request_date_time.indexOf("Error") >= 0 || l_request_date_time.trim().equals("")) {
				l_errcd = "E";
				l_error.append(" - Request Date Time");
			}
			l_app_msg = " ::: Request Date Time : " + l_request_date_time;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("request_date_time", l_request_date_time);

			l_app_msg = " ::: Getting Request Facility ID from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_facility_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "visit_data", "facility_id");
			l_app_msg = " ::: Facility ID : " + l_facility_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = " ::: Getting Request Patient ID from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_patient_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "visit_data", "patient_id");
			l_app_msg = " ::: Patient ID : " + l_patient_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (l_patient_id.indexOf("Exception in") >= 0 || "".equals(l_patient_id.trim())) {
				l_errcd = "E";
				if ("".equals(l_patient_id.trim())) {
					l_error.append("- Patient Id cannot be empty ");
				}
			}

			if (l_errcd.equals("E")) {
				
				params.put("STATUS", l_errcd);
				params.put("ERR_MSG", l_error.toString());
				
				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);
				return "200#" + l_responseJsonString + "#";
			}
			
			l_nationality_code = "";
			
			String v_patient_id = validatePatient(l_patient_id);
			if (!l_patient_id.equals(v_patient_id)) {
				l_errcd = "E";
				l_error.append("- Patient Id - " + l_patient_id + " - Does Not Exists in EM ");
			}
			
			if (l_nationality_code.equalsIgnoreCase("515"))
				l_element_id = "BLNG_GRP_ID";
			else
				l_element_id = "BLNG_GRP_ID_FOR";

			l_BLNG_GRP_ID = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: BLNG_GRP_ID ::: " + l_BLNG_GRP_ID);


			params.put("ERR_MSG", "");

			if (l_errcd.equals("E")) {
				l_app_msg = " ::: Inserting Request into Message Table while Patient ID validation ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				params.put("STATUS", l_errcd);
				params.put("ERR_MSG", l_error.toString());
				
				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);

				return "200#" + l_responseJsonString + "#";
			}

			l_app_msg = " ::: Getting External Appointement ID from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_ext_appt_ref_no = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "visit_data", "appointment_id");
			l_app_msg = " ::: External Appointment Reference ID : " + l_ext_appt_ref_no;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (l_ext_appt_ref_no.indexOf("Exception in") >= 0 || "".equals(l_ext_appt_ref_no.trim())) {
				l_errcd = "E";
				if ("".equals(l_ext_appt_ref_no.trim())) {
					l_error.append("- External Appointment Reference ID cannot be empty ");
				}
			}

			l_app_msg = " ::: Getting Request Visit Date Time from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_visit_date_time = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_date_time");
			l_app_msg = " ::: Visit Date Time : " + l_visit_date_time;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (l_visit_date_time.indexOf("Exception in") >= 0 || "".equals(l_visit_date_time.trim())) {
				l_errcd = "E";
				if ("".equals(l_visit_date_time.trim())) {
					l_error.append("- Visit Date Time cannot be empty");
				}
			}

			if (!l_visit_date_time.equals("")) {

				String l_validate_appt_date_time = validateDateTime(l_visit_date_time);

				l_app_msg = " ::: Validate Appt Date & time : " + l_validate_appt_date_time;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				if (l_validate_appt_date_time.indexOf("Error") >= 0 || l_validate_appt_date_time.equals("1")) {

					l_errcd = "E";

					l_app_msg = " ::: Error Code for Validate Appointment Date and Time : " + l_errcd;

					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					l_err_msg = "- Visit Date Time can't less than and greater than Current Date Time";
					l_error.append(l_err_msg);
					
					params.put("STATUS", l_errcd);
					params.put("ERR_MSG", l_error.toString());

					l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);

					l_app_msg = " ::: Response String under validate appt date time: " + l_responseJsonString;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					return "200#" + l_responseJsonString + "#";
				}
			}

			if (l_errcd.equals("E")) {

				l_app_msg = " ::: next loop: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				params.put("STATUS", l_errcd);
				params.put("ERR_MSG", l_error.toString());

				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);

				l_app_msg = " ::: Response String under validate appt date time: " + l_responseJsonString;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				return "200#" + l_responseJsonString + "#";
			}

			l_app_msg = " ::: Getting Request Location Code from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_location_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "visit_data", "location_id");
			l_app_msg = " ::: Location id : " + l_location_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (l_location_id.indexOf("Error in") >= 0 || "".equals(l_location_id.trim())) {
				l_errcd = "E";
				l_error.append("- Location Code cannot be empty ");
			}

			if (l_errcd.equals("E")) {
				params.put("STATUS", l_errcd);
				params.put("ERR_MSG", l_error.toString());
				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);
				return "200#" + l_responseJsonString + "#";
			}

			try {

				l_app_msg = " ::: Getting Location type and service code ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				dbConn = EMDataSource.getConnection();
				// dbConn = EMDBConnectionPool.getConnection();
				query = "SELECT CLINIC_TYPE, SERVICE_CODE FROM op_clinic WHERE CLINIC_CODE = ? and FACILITY_ID = ?";

				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, l_location_id);
				pstmt.setString(2, l_facility_id);

				rs = pstmt.executeQuery();
				while (rs.next()) {
					l_location_type = rs.getString("CLINIC_TYPE");
					l_service_code = rs.getString("SERVICE_CODE");
				}
				l_app_msg = " ::: Location type : " + l_location_type;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_app_msg = " ::: Service Code : " + l_service_code;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

			} catch (Exception e) {
				l_app_msg = "Exception in Fetching l_location_type and l_service_code : " + e.getMessage();
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				e.printStackTrace();
			} finally {
				XHUtil.closeDBResources(rs, pstmt, null);
				EMDataSource.returnConnection(dbConn);
			}

			if (l_location_type.indexOf("Exception in") >= 0 || "".equals(l_location_type.trim())) {
				l_errcd = "E";
				if ("".equals(l_location_type.trim())) {
					l_error.append("- Location Type cannot be empty ");
				}
			}

			if (l_errcd.equals("E")) {
				params.put("STATUS", l_errcd);
				params.put("ERR_MSG", l_error.toString());
				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);
				return "200#" + l_responseJsonString + "#";
			}

			String v_locn_type = validateLocnType(l_location_type);
			if (!v_locn_type.equals(l_location_type)) {
				l_errcd = "E";
				l_error.append("- Location - " + l_location_type + " - Does Not Exists in EM ");
			}

			if (l_errcd.equals("E")) {
				l_app_msg = " ::: Inserting Request into Message Table while Location Type validation ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				params.put("STATUS", l_errcd);
				params.put("ERR_MSG", l_error.toString());

				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);

				return "200#" + l_responseJsonString + "#";
			}

			String v_locn_code = validateLocnCode(l_location_id, l_facility_id, l_location_type);
			if (!v_locn_code.equals(l_location_id)) {
				l_errcd = "E";
				l_error.append("- Location Code - " + l_location_id + " - Does Not Exists in EM ");
			}

			if (l_errcd.equals("E")) {
				l_app_msg = " ::: Inserting Request into Message Table while Location Code validation ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				params.put("STATUS", l_errcd);
				params.put("ERR_MSG", l_error.toString());
				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);
				return "200#" + l_responseJsonString + "#";
			}

			if (l_service_code.indexOf("Error in") >= 0 || "".equals(l_service_code.trim())) {
				l_errcd = "E";
				l_error.append("- Service Code cannot be empty");
			}

			if (l_errcd.equals("E")) {
				params.put("STATUS", l_errcd);
				params.put("ERR_MSG", l_error.toString());
				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);
				return "200#" + l_responseJsonString + "#";
			}

			String v_service_code = validateService(l_location_id, l_facility_id, l_service_code);
			if (!v_service_code.equals(l_service_code)) {
				l_errcd = "E";
				l_error.append("- Service Code - " + l_service_code + " - Does Not Exists in EM ");
			}

			l_app_msg = " ::: Getting Request Practitioner ID from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_practitioner_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "visit_data", "doctor_id");
			l_app_msg = " ::: Practitioner ID : " + l_practitioner_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (l_practitioner_id.indexOf("Error in") >= 0 || "".equals(l_practitioner_id.trim())) {
				l_errcd = "E";
				l_error.append("- Practitioner Id cannot be empty ");
			}

			if (l_errcd.equals("E")) {
				params.put("STATUS", l_errcd);
				params.put("ERR_MSG", l_error.toString());
				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);
				return "200#" + l_responseJsonString + "#";
			}

			String v_practitioner_id = validatePratitioner(l_practitioner_id);
			if (!v_practitioner_id.equals(l_practitioner_id)) {
				l_errcd = "E";
				l_error.append("- Practitioner Id - " + l_practitioner_id + " - Does Not Exists in EM ");
			}

			if (l_errcd.equals("E")) {
				l_app_msg = " ::: Inserting Request into Message Table while Practitioner validation ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				params.put("STATUS", l_errcd);
				params.put("ERR_MSG", l_error.toString());
				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);
				return "200#" + l_responseJsonString + "#";
			}

			l_con_srvc_start_date_time = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "visit_data",
					"consult_start_time");
			l_app_msg = " ::: Consultation Start Time : " + l_con_srvc_start_date_time;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (l_con_srvc_start_date_time.indexOf("Exception in") >= 0
					|| "".equals(l_con_srvc_start_date_time.trim())) {
				l_errcd = "E";
				if ("".equals(l_con_srvc_start_date_time.trim())) {
					l_error.append("- Consultation Start Time cannot be empty ");
				}
			}

			l_cons_srvc_end_date_time = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "visit_data", "consult_end_time");
			l_app_msg = " ::: Consultation Start Time : " + l_cons_srvc_end_date_time;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (l_cons_srvc_end_date_time.indexOf("Exception in") >= 0 || "".equals(l_cons_srvc_end_date_time.trim())) {
				l_errcd = "E";
				if ("".equals(l_cons_srvc_end_date_time.trim())) {
					l_error.append("- Consultation End Time cannot be empty ");
				}
			}

			boolean v_visti = validateVisit(l_facility_id, l_patient_id, l_service_code);
			l_app_msg = " ::: v_visti ::: " + v_visti;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (v_visti) {
				l_errcd = "E";
				insertable = false;
				l_error.append("- Patient already has a open visit for this clinic and service ");
			}

			if (l_errcd.equals("E")) {
				l_app_msg = " ::: Inserting Request into Message Table while Service validation ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				params.put("STATUS", l_errcd);
				params.put("ERR_MSG", l_error.toString());
				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);
				return "200#" + l_responseJsonString + "#";
			}

			l_app_msg = " ::: Getting Request Visit Type from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_visit_type = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "visit_data", "appointment_type");
			l_app_msg = " ::: Visit Type : " + l_visit_type;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (l_visit_type.indexOf("Error in") >= 0 || "".equals(l_visit_type.trim())) {
				l_errcd = "E";
				l_error.append("- Visit Type cannot be empty ");
			}

			if (l_errcd.equals("E")) {
				l_app_msg = " ::: Inserting Request into Message Table while Visit Type validation ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				params.put("STATUS", l_errcd);
				params.put("ERR_MSG", l_error.toString());
				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);
				return "200#" + l_responseJsonString + "#";
			}

			String v_visit_type = validateVisitType(l_facility_id, l_location_id, l_location_type, l_visit_type);
			if (!v_visit_type.equals(l_visit_type)) {
				l_errcd = "E";
				l_error.append("- Visit Type - " + l_visit_type + " - Does Not Exists in EM ");
			}

			if (l_errcd.equals("E")) {
				l_app_msg = " ::: Inserting Request into Message Table while Visit Type validation ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				params.put("STATUS", l_errcd);
				params.put("ERR_MSG", l_error.toString());
				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);
				return "200#" + l_responseJsonString + "#";
			}
			
			l_notes = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "visit_data", "notes");
			if (l_notes.indexOf("Error in") >= 0) {
				l_notes = "";
			}
			l_app_msg = " ::: Notes : " + l_notes;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);


			/*
			 * l_app_msg = " ::: Fetching Added By Id ::: "; if
			 * (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			 * 
			 * l_element_id = "BL_USER_ID";
			 * 
			 * added_by_id = FetchStdCntrlSegMethod("PWS", l_element_id,
			 * l_standard_code); if (l_debug_YN.equals("Y"))
			 * System.out.println(" ::: Added By Id ::: " + added_by_id);
			 */

			v_visit_type_validation_map = validateVisitTypeFirstORFollowup(l_facility_id, l_patient_id, l_location_id,
					l_request_date_time);

			l_episode_no = v_visit_type_validation_map.get("f_episode_id");
			l_app_msg = " ::: Episode No : " + l_episode_no;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching Episode ID and Visit Number :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			episodeMap = fetchEpisodeIDVisitNum(l_facility_id, l_patient_id, l_episode_no, l_location_id);

			l_visitno = episodeMap.get("visit_num");
			if (l_visitno == null)
				l_visitno = "0001";
			if (l_visitno.length() >= 4)
				l_visitno = l_visitno.substring(l_visitno.length() - 1);

			l_app_msg = " ::: Visit Number :" + l_visitno;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			k_visit_type_ind = v_visit_type_validation_map.get("f_visit_type_ind");
			new_op_episode_yn = "";

			if (k_visit_type_ind.equals("F")) {
				new_op_episode_yn = "Y";
				l_visitno = "1";
			} else {
				new_op_episode_yn = "N";
			}
			// l_episode_id = fetchEpisodeID(l_facility_id);

			encounterMap = generateEncounterID(l_episode_no, l_visitno, l_facility_id, added_by_id, added_at_ws_no);

			l_encounter_id = encounterMap.get("encounterid");

			l_app_msg = " ::: Encounter ID : " + l_encounter_id + "::::::insertable:::::::" + insertable;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_visitnum = encounterMap.get("visitnum");
			if (l_visitnum == null)
				l_visitnum = "";

			l_app_msg = " ::: Visit Number from GenerateEncounterID : " + l_visitnum + "::::::insertable:::::::"
					+ insertable;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_episode_no = encounterMap.get("episodeno");
			if (l_episode_no == null)
				l_episode_no = "";

			l_app_msg = " ::: Episode No from GenerateEncounterID : " + l_episode_no + "::::::insertable:::::::"
					+ insertable;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			clinicMap = fetchClinicDetails(l_facility_id, l_location_id);
			
			if (l_debug_YN.equals("Y"))
				System.out.println(":::::::::::clinic Map :::::" + clinicMap);

			l_app_msg = " ::: Fetching Assign Queue Number BY From OP Param : ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			try {
				String queueNumByQuery = "select action_on_pract_schedule,ASSIGN_QUEUE_NUM_BY,use_template_in_vis_regn_yn, to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sys,"
						+ "to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_new, OVERRIDE_PRACT_FOR_APPT_YN, OVERRIDE_VTYPE_ON_EPSD_YN,VISIT_BACKDATE_DAYS,"
						+ " to_char((sysdate - NVL(VISIT_BACKDATE_DAYS,0)),'dd/mm/yyyy hh24:mi:ss') sys1,VISIT_TYPE_DERV_RULE from op_param where "
						+ "operating_facility_id='" + l_facility_id + "'";

				l_app_msg = " ::: queueNumByQuery : " + queueNumByQuery;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				dbConn = EMDataSource.getConnection();
				pstmt = dbConn.prepareStatement(queueNumByQuery);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					l_ASSIGN_QUEUE_NUM_BY = rs.getString("ASSIGN_QUEUE_NUM_BY");
					l_VISIT_TYPE_DERV_RULE = rs.getString("VISIT_TYPE_DERV_RULE");
				}

				l_app_msg = " ::: ASSIGN QUEUE NUM BY : " + l_ASSIGN_QUEUE_NUM_BY;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_app_msg = " ::: Visit Type Derv Rule : " + l_VISIT_TYPE_DERV_RULE + "::::::insertable:::::::"
						+ insertable;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

			} catch (Exception e) {
				l_app_msg = "Exception in Fetching Assign Queue Number BY : " + e.getMessage();
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				e.printStackTrace();
			} finally {
				XHUtil.closeDBResources(rs, pstmt, null);
				EMDataSource.returnConnection(dbConn);
			}

			l_app_msg = " ::: Fetching Appointment ID ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			try {
				String apptIdQuery = "select appt_ref_no, to_char(appt_time,'dd/mm/yyyy hh24:mi') appt_time, appt_status, mr_request_id, referral_id from oa_appt " +
						" where facility_id = ? and ext_appt_ref_no = ? ";

				l_app_msg = " ::: Appointment ID Query... : " + apptIdQuery;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				dbConn = EMDataSource.getConnection();
				pstmt = dbConn.prepareStatement(apptIdQuery);
				pstmt.setString(1, l_facility_id);
				pstmt.setString(2, l_ext_appt_ref_no);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					l_appt_id = rs.getString("appt_ref_no")== null ? "" : rs.getString("appt_ref_no");
					l_appt_time = rs.getString("appt_time")== null ? "" : rs.getString("appt_time");
					l_appt_status = rs.getString("appt_status")== null ? "" : rs.getString("appt_status");
					l_request_id = rs.getString("mr_request_id")== null ? "" : rs.getString("mr_request_id");
					l_refferal_id = rs.getString("REFERRAL_ID") == null ? "" : rs.getString("REFERRAL_ID");
				}

				l_app_msg = " ::: EM Appointment ID : " + l_appt_id + " Appt Time... " + l_appt_time
						+ " Appt Status... " + l_appt_status + " MR Request ID... " + l_request_id + " Referral Id... "
						+ l_refferal_id;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

			} catch (Exception e) {
				l_app_msg = "Exception in Fetching Appointment ID : " + e.getMessage();
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				e.printStackTrace();
			} finally {
				XHUtil.closeDBResources(rs, pstmt, null);
				EMDataSource.returnConnection(dbConn);
			}
			
			/*

			try {
				String apptQuery = "SELECT (select action_on_pract_schedule from op_param where OPERATING_FACILITY_ID='"
						+ l_facility_id + "' ) action_on_pract_schedule,"
						+ "TO_CHAR(SYSDATE,'dd/mm/yyyy') Sys_date,A.patient_id patient_id ,TO_CHAR(A.QUEUE_DATE,'dd/mm/yyyy hh24:mi') visit_adm_date_time, "
						+ "decode(A.APPT_OR_WALK_IN_IND, 'A', 'Y', 'N') appt_case_yn , A.APPT_OR_WALK_IN_IND APPT_OR_WALK_IN_IND , A.appt_id appt_id ,"
						+ "A.SPECIALITY_CODE specialty_code ,null patient_type ,A.referral_id referral_id, A.episode_id episode_id ,A.OP_EPISODE_VISIT_NUM OP_EPISODE_VISIT_NUM ,"
						+ "B.SEX gender ,TO_CHAR(b.DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH, d.long_desc LOCN_DESC , A.locn_type ASSIGN_CARE_LOCN_TYPE  ,"
						+ "AM_GET_DESC.AM_CARE_LOCN_TYPE(A.LOCN_TYPE,'" + l_locale
						+ "','2') LOCN_TYPE_DESC   ,am_get_desc.AM_SERVICE(A.SERVICE_CODE,'" + l_locale
						+ "',2) service_desc ,"
						+ "DECODE (A.LOCN_TYPE,'N', NULL, d.open_to_all_pract_yn) cur_open_to_all_pract_yn ,op_get_desc.op_visit_type(a.facility_id,a.VISIT_TYPE_CODE,'"
						+ l_locale + "',2) "
						+ "visit_type_desc  ,NULL  RESCLASS , c.pract_type  RESTYPE ,A.LOCN_CODE CUR_LOCN_CODE ,A.LOCN_TYPE CUR_LOCN_TYPE ,A.SERVICE_CODE CUR_SERVICE_CODE , "
						+ "A.PRACTITIONER_ID CUR_PRACTITIONER_ID, c.practitioner_name pract_name ,c.pract_type CUR_PRACT_TYPE , am_get_desc.am_pract_type(c.pract_type,'"
						+ l_locale + "',2)  "
						+ "PRACT_TYPE_DESC , d.level_of_care_ind CUR_LEVEL_OF_CARE_IND, A.VISIT_TYPE_CODE VISIT_TYPE_CODE ,decode(A.APPT_OR_WALK_IN_IND, 'A', 'Y', 'N') VISIT_CASE  ,"
						+ "A.VISIT_TYPE_IND CUR_VISIT_TYPE_IND ,op_get_desc.op_visit_type(a.facility_id,a.visit_type_code,'"
						+ l_locale + "',2) VISIT_DESC  ,A.VISIT_TYPE_code P_CUR_VISIT_TYPE_CODE, "
						+ "A.SUBSERVICE_CODE SUBSERVICE_CODE  ,am_get_desc.am_subService(a.service_code,a.subservice_code,'"
						+ l_locale + "',2) SUBSERVICE_DESC, A.ROOM_NUM ROOM_NUM ,"
						+ "A.REVISE_REASON_CODE REVISE_REASON_CODE , A.CONTACT_REASON_CODE CONTACT_REASON_CODE  , am_get_desc.am_contact_reason(a.contact_reason_code,'"
						+ l_locale + "',1) "
						+ "REASON_FOR_CONTACT  ,A.OTHER_RES_CLASS OTHER_RES_CLASS , A.OTHER_RESOURCE_ID OTHER_RESOURCE_ID , am_get_desc.AM_RESOURCE(a.facility_id,a.other_resource_id,'"
						+ l_locale + "',2)  "
						+ "other_resource_desc, A.QUEUE_ID QUEUE_ID, d.primary_resource_class, d.ident_at_checkin, d.allow_referral_yn, (select entitlement_by_pat_cat_yn from mp_param where module_id = 'MP') "
						+ "entitlement_by_pat_cat_yn FROM OP_PATIENT_QUEUE A, MP_PATIENT B, am_practitioner_lang_vw C, op_clinic d WHERE A.FACILITY_ID = '"
						+ l_facility_id + "'  AND A.ENCOUNTER_ID = '" + l_encounter_id + "' "
						+ "AND A.PATIENT_CLASS = 'OP' AND a.patient_id = b.patient_id AND d.clinic_code = a.locn_code and d.facility_id = a.facility_id and  C.practitioner_id(+)=A.practitioner_id and c.language_id (+)= '"
						+ l_locale + "'";

				l_app_msg = " ::: apptQuery : " + apptQuery;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				dbConn = EMDataSource.getConnection();
				pstmt = dbConn.prepareStatement(apptQuery);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					l_appt_id = rs.getString("appt_id");
					if (l_appt_id == null)
						l_appt_id = "";
				}

				l_app_msg = " ::: Appointment ID : " + l_appt_id + "::::::insertable:::::::" + insertable;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

			} catch (Exception e) {
				l_app_msg = "Exception in Fetching Appointment ID : " + e.getMessage();
				dbConn.rollback();
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				e.printStackTrace();
			} finally {
				XHUtil.closeDBResources(rs, pstmt, null);
				EMDataSource.returnConnection(dbConn);
			}
			
			*/
			
			/*

			if (!l_appt_id.equals("")) {

				l_app_msg = " ::: Fetching Appointment Time ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				try {
					String apptTimeQuery = "SELECT to_char(appt_time,'dd/mm/yyyy hh24:mi'), appt_status, mr_request_id, REFERRAL_ID FROM oa_appt WHERE APPT_REF_NO = ? and FACILITY_ID =?";

					l_app_msg = " ::: apptTimeQuery : " + apptTimeQuery;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					dbConn = EMDataSource.getConnection();
					pstmt = dbConn.prepareStatement(apptTimeQuery);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						l_appt_time = rs.getString(1);
						l_appt_status = rs.getString(2);
						l_request_id = rs.getString(3);
						l_refferal_id = rs.getString("REFERRAL_ID") == null ? "" : rs.getString("REFERRAL_ID");
					}

					l_app_msg = " ::: Appointment Time : " + l_appt_time + " ::: Appt Status : " + l_appt_status
							+ " ::: Appt Req Id : " + l_request_id + " ::: Refferal Id :" + l_refferal_id
							+ "::::::insertable:::::::" + insertable;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

				} catch (Exception e) {
					l_app_msg = "Exception in Fetching Appointment ID : " + e.getMessage();
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					e.printStackTrace();
				} finally {
					XHUtil.closeDBResources(rs, pstmt, null);
					EMDataSource.returnConnection(dbConn);
				}
			}

			l_app_msg = " ::: Fetching Appointment Status ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
				
			*/

			l_app_msg = " ::: Fetching QMS INTERFACED YN From OP Clinic : ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			try {
				String QMSInterfacedYNQuery = "select QMS_INTERFACED_YN from op_clinic where FACILITY_ID=? and clinic_code =?";

				dbConn = EMDataSource.getConnection();
				pstmt = dbConn.prepareStatement(QMSInterfacedYNQuery);
				pstmt.setString(1, l_facility_id);
				pstmt.setString(2, l_location_id);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					l_QMS_INTERFACED_YN = rs.getString("QMS_INTERFACED_YN");
				}

				l_app_msg = " ::: QMS INTERFACED YN : " + l_ASSIGN_QUEUE_NUM_BY;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

			} catch (Exception e) {
				l_app_msg = "Exception in Fetching QMS INTERFACED YN : " + e.getMessage();
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				e.printStackTrace();
			} finally {
				XHUtil.closeDBResources(rs, pstmt, null);
				EMDataSource.returnConnection(dbConn);
			}

			l_app_msg = " ::: Fetching values from OP Clinic : " + insertable + " ::: Error Code : " + l_errcd;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			String ct_date = "";
			try {
				String OPClinicQuery = "select clinic_type,speciality_code, dept_code,to_char(sysdate,'dd/mm/yyyy') ct_date,online_mr_notfn_yn,mr_location_code from op_clinic where clinic_code = '"
						+ l_location_id + "' and facility_id='" + l_facility_id + "'";

				dbConn = EMDataSource.getConnection();
				pstmt = dbConn.prepareStatement(OPClinicQuery.toString());
				rs = pstmt.executeQuery();

				while (rs.next()) {
					ct_date = rs.getString("ct_date");
				}

			} catch (Exception e) {
				l_app_msg = "Exception in Fetching QMS INTERFACED YN : " + e.getMessage();
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				e.printStackTrace();
			} finally {
				XHUtil.closeDBResources(rs, pstmt, null);
				EMDataSource.returnConnection(dbConn);
			}

			l_app_msg = " ::: insertable while OP_QUEUE_NUM_FOR_LOCN_PRC : " + insertable + " ::: Error Code : "
					+ l_errcd;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (insertable) {

				l_app_msg = " ::: Calling Queue Number for Location Processing : ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				try {
					if (l_ASSIGN_QUEUE_NUM_BY.equals("S")) {

						if (l_QMS_INTERFACED_YN.equals("N")) {

							dbConn = EMDataSource.getConnection();
							cstmt = dbConn.prepareCall(
									"{call OP_QUEUE_NUM_FOR_LOCN_PRC(?,?,?,?,?,?,?,?,?,?,?,null,null,?,?)}");
							
							if (l_debug_YN.equals("Y"))
								System.out.println(" ::: OP_QUEUE_NUM_FOR_LOCN_PRC : facilityid : " + l_facility_id
									+ " : ct_date : " + ct_date + " : l_location_type : " + l_location_type
									+ " : l_location_id : " + l_location_id + " : l_practitioner_id : "
									+ l_practitioner_id + " : l_p_id : " + l_p_id);
							
							cstmt.setString(1, l_facility_id);
							cstmt.setString(2, ct_date);
							cstmt.setString(3, l_location_type);
							cstmt.setString(4, l_location_id);
							cstmt.setString(5, l_practitioner_id);
							cstmt.setString(6, "*ALL");
							cstmt.setString(7, "*");
							cstmt.setString(8, "*ALL");
							cstmt.setString(9, l_p_id);
							cstmt.setString(10, added_by_id);
							cstmt.setString(11, added_at_ws_no);
							cstmt.registerOutParameter(12, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(13, java.sql.Types.INTEGER);

							cstmt.execute();

							l_queueID = cstmt.getString(12);
							l_quenum = cstmt.getInt(13);

							if (l_queueID == null || l_queueID.equals("") || l_queueID.equals("null"))
								l_queueID = "";

							if (l_quenum >= 0) {
								insertable = true;
								//l_quenum = l_quenum;
							} else if (l_quenum == -1) {
								insertable = false;
							}

							l_app_msg = " ::: QuenID : " + l_queueID + "  ::: Quenum : " + l_quenum;
							if (l_debug_YN.equals("Y"))
								System.out.println(l_app_msg);
						}
					}

				} catch (Exception e) {
					l_app_msg = " ::: Exception in Queue Number for Location Processing : " + e.getMessage();
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					e.printStackTrace();
				} finally {
					
					XHUtil.closeDBResources(null, cstmt, null);
					EMDataSource.returnConnection(dbConn);
				}
			}

			l_app_msg = " ::: Fetching Settlement ind & Adm rec flag ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			try {

				dbConn = EMDataSource.getConnection();
				String stlmtIndQurey = "select settlement_ind, adm_rec_flag from bl_blng_grp where blng_grp_id = ? ";

				pstmt = dbConn.prepareStatement(stlmtIndQurey);
				pstmt.setString(1, l_billing_group_code);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					l_slmt_ind = rs.getString("settlement_ind");
					l_adm_rec_flag = rs.getString("adm_rec_flag");
				}

				l_app_msg = " ::: Settlement Ind : " + l_slmt_ind + " ::: ADM Rec Flag : " + l_adm_rec_flag;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

			} catch (Exception e) {
				l_app_msg = " Exception in Fetching Settlement Ind, ADM Reg Flag : " + e.getMessage();
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				e.printStackTrace();
			} finally {
				
				XHUtil.closeDBResources(rs, pstmt, null);
				EMDataSource.returnConnection(dbConn);
			}

			l_app_msg = " ::: Fetching ASSESSMENT_MONTHS ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			try {

				dbConn = EMDataSource.getConnection();

				String blParamQuery = "Select AUTO_FIN_CLASSFCTN_IN_USE_YN,ASSESSMENT_MONTHS from BL_PARAMETERS Where OPERATING_FACILITY_ID = '"
						+ l_facility_id + "'";
				pstmt = dbConn.prepareStatement(blParamQuery);
				rs = pstmt.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						l_fin_class_flag_YN = rs.getString("AUTO_FIN_CLASSFCTN_IN_USE_YN");
						l_assessmentMonths = rs.getInt("ASSESSMENT_MONTHS");
					}

					l_app_msg = " ::: AUTO FIN CLASSFCTN IN_USE YN : " + l_fin_class_flag_YN
							+ " ::: ASSESSMENT MONTHS : " + l_assessmentMonths;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
				}

			} catch (Exception e) {
				l_app_msg = "Exception call ASSESSMENT_MONTHS in  : " + e.getMessage();
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				e.printStackTrace();

			} finally {
				
				XHUtil.closeDBResources(rs, pstmt, null);
				EMDataSource.returnConnection(dbConn);
			}

			l_app_msg = " ::: Fetching Financial Required Values ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			try {


				String finQuery = "select blng_grp_id,settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc , "
						+ "slmt_doc_ref_date,slmt_doc_remarks,cust_group_code,cust_code,credit_doc_ref_desc,credit_doc_ref_start_date, credit_doc_ref_date,"
						+ "non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,"
						+ "resp_for_bill_payment,pat_reln_with_resp_pers,remarks,financial_remarks,gl_holder_name,pat_reln_with_gl_holder, REFERRAL_SOURCE_CODE_MAIN,"
						+ "REFERRAL_SOURCE_CODE_SUB,NON_INS_REF_SOURCE_CODE_MAIN,NON_INS_REF_SOURCE_CODE_SUB,episode_id,visit_id,IS_SPECIAL_CLINIC_RELATED,"
						+ "NO_OF_ENC_GL_VALID,NO_OF_OP_ENC_GL_VALID,NO_OF_AE_ENC_GL_VALID,NO_OF_IP_ENC_GL_VALID,NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND,"
						+ "PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,"
						+ "CLASSIFICATION_CODE,CLASSIFICATION_TYPE,CLASSIFICATION_START_DATE,CLASSIFICATION_END_DATE,SOCIAL_PENSIONER_ID,LAST_DATE from (select b.blng_grp_id,"
						+ "b.settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc ,to_char(slmt_doc_ref_date,'dd/mm/yyyy') slmt_doc_ref_date,"
						+ "slmt_doc_remarks,b.cust_group_code,b.cust_code,credit_doc_ref_desc,to_char(credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date,"
						+ "to_char(credit_doc_ref_date,'dd/mm/yyyy') credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,"
						+ "family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,financial_remarks,gl_holder_name,pat_reln_with_gl_holder"
						+ ",blcommon.BL_VALID_REF_SOURCE_CODE(b.REFERRAL_SOURCE_CODE_MAIN,?) REFERRAL_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(b.REFERRAL_SOURCE_CODE_SUB,?) "
						+ "REFERRAL_SOURCE_CODE_SUB,blcommon.BL_VALID_REF_SOURCE_CODE(NON_INS_REF_SOURCE_CODE_MAIN,?) NON_INS_REF_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE"
						+ "(NON_INS_REF_SOURCE_CODE_SUB,?) NON_INS_REF_SOURCE_CODE_SUB,null episode_id,null visit_id,null IS_SPECIAL_CLINIC_RELATED,null NO_OF_ENC_GL_VALID,"
						+ "null NO_OF_OP_ENC_GL_VALID,null NO_OF_AE_ENC_GL_VALID,null NO_OF_IP_ENC_GL_VALID,null NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND,"
						+ "PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,"
						+ "CLASSIFICATION_CODE,CLASSIFICATION_TYPE,to_char(CLASSIFICATION_START_DATE,'DD/MM/YYYY') CLASSIFICATION_START_DATE,"
						+ "to_char(CLASSIFICATION_END_DATE,'DD/MM/YYYY') CLASSIFICATION_END_DATE,SOCIAL_PENSIONER_ID, to_char(add_months(CLASSIFICATION_START_DATE,?),'dd/mm/yyyy')"
						+ " LAST_DATE from bl_patient_fin_dtls a, BL_ENCOUNTER_PAYER_PRIORITY b where a.patient_id =? and a.patient_id = b.patient_id and b.episode_type='R' "
						+ "and  b.ACCT_SEQ_NO=a.CUR_ACCT_SEQ_NO and (a.non_ins_blng_grp_id is null or (a.non_ins_blng_grp_id is not null and b.PRIORITY is not null)) "
						+ "and exists (Select 'X' from bl_blng_grp c where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR"
						+ " (?='DC' AND DY_YN='Y')) and b.blng_grp_id=c.blng_grp_id) order by b.added_date  desc /*order by B.PRIORITY*/) where rownum=1";

				l_app_msg = " ::: finQuery : " + finQuery;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				dbConn = EMDataSource.getConnection();
				pstmt = dbConn.prepareStatement(finQuery, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

				pstmt.setString(1, l_episode_type);
				pstmt.setString(2, l_episode_type);
				pstmt.setString(3, l_episode_type);
				pstmt.setString(4, l_episode_type);
				pstmt.setInt(5, l_assessmentMonths);
				pstmt.setString(6, l_patient_id);
				pstmt.setString(7, l_calling_module_id);
				pstmt.setString(8, l_calling_module_id);
				pstmt.setString(9, l_calling_module_id);
				pstmt.setString(10, l_calling_module_id);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					l_slmt_type_code = rs.getString("slmt_type_code");
					if (l_slmt_type_code == null)
						l_slmt_type_code = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Settlement Type Code : " + l_slmt_type_code);

					l_REFERRAL_SOURCE_CODE_MAIN = rs.getString("REFERRAL_SOURCE_CODE_MAIN");
					if (l_REFERRAL_SOURCE_CODE_MAIN == null)
						l_REFERRAL_SOURCE_CODE_MAIN = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Referral Source Code Main : " + l_REFERRAL_SOURCE_CODE_MAIN);

					l_REFERRAL_SOURCE_CODE_SUB = rs.getString("REFERRAL_SOURCE_CODE_SUB");
					if (l_REFERRAL_SOURCE_CODE_SUB == null)
						l_REFERRAL_SOURCE_CODE_SUB = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Referral Source Code Sub : " + l_REFERRAL_SOURCE_CODE_SUB);

					l_employer_code = rs.getString("employer_code");
					if (l_employer_code == null)
						l_employer_code = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Employee Code : " + l_employer_code);

					l_cust_group_code = rs.getString("cust_group_code");
					if (l_cust_group_code == null)
						l_cust_group_code = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Customer Group Code : " + l_cust_group_code);

					l_cust_code = rs.getString("cust_code");
					if (l_cust_code == null)
						l_cust_code = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Customer Code : " + l_cust_code);

					l_credit_doc_ref_desc = rs.getString("credit_doc_ref_desc");
					if (l_credit_doc_ref_desc == null)
						l_credit_doc_ref_desc = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Credit Doc Ref Desc : " + l_credit_doc_ref_desc);

					l_credit_doc_ref_start_date = rs.getString("credit_doc_ref_start_date");
					if (l_credit_doc_ref_start_date == null)
						l_credit_doc_ref_start_date = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Credit Doc Ref Start Date : " + l_credit_doc_ref_start_date);

					l_credit_doc_ref_date = rs.getString("credit_doc_ref_date");
					if (l_credit_doc_ref_date == null)
						l_credit_doc_ref_date = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Credit Doc Ref Date : " + l_credit_doc_ref_date);

					l_slmt_doc_ref_desc = rs.getString("slmt_doc_ref_desc");
					if (l_slmt_doc_ref_desc == null)
						l_slmt_doc_ref_desc = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Settlement Doc Ref Desc: " + l_slmt_doc_ref_desc);

					l_slmt_doc_ref_date = rs.getString("slmt_doc_ref_date");
					if (l_slmt_doc_ref_date == null)
						l_slmt_doc_ref_date = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Settlement Doc Ref Date : " + l_slmt_doc_ref_date);

					l_slmt_doc_remarks = rs.getString("slmt_doc_remarks");
					if (l_slmt_doc_remarks == null)
						l_slmt_doc_remarks = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Settlement Doc Remarks  : " + l_slmt_doc_remarks);

					l_non_ins_blng_grp_id = rs.getString("non_ins_blng_grp_id");
					if (l_non_ins_blng_grp_id == null)
						l_non_ins_blng_grp_id = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Non Insurance Billing Group : " + l_non_ins_blng_grp_id);

					l_NON_INS_REF_SOURCE_CODE_MAIN = rs.getString("NON_INS_REF_SOURCE_CODE_MAIN");
					if (l_NON_INS_REF_SOURCE_CODE_MAIN == null)
						l_NON_INS_REF_SOURCE_CODE_MAIN = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Non Insurance Reference Source Code Main : " + l_NON_INS_REF_SOURCE_CODE_MAIN);

					l_NON_INS_REF_SOURCE_CODE_SUB = rs.getString("NON_INS_REF_SOURCE_CODE_SUB");
					if (l_NON_INS_REF_SOURCE_CODE_SUB == null)
						l_NON_INS_REF_SOURCE_CODE_SUB = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Non Insurance Reference Source Code Sub : " + l_NON_INS_REF_SOURCE_CODE_SUB);

					l_non_ins_cust_group_code = rs.getString("non_ins_cust_group_code");
					if (l_non_ins_cust_group_code == null)
						l_non_ins_cust_group_code = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Non Insurance Customer Group Code  : " + l_non_ins_cust_group_code);

					l_non_ins_cust_code = rs.getString("non_ins_cust_code");
					if (l_non_ins_cust_code == null)
						l_non_ins_cust_code = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Non Insurance Customer Code  : " + l_non_ins_cust_code);

					l_annual_family_income = rs.getString("annual_family_income");
					if (l_annual_family_income == null)
						l_annual_family_income = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Annual Family Income : " + l_annual_family_income);

					l_family_assets_value = rs.getString("family_assets_value");
					if (l_family_assets_value == null)
						l_family_assets_value = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Family Assets Value : " + l_family_assets_value);

					l_num_of_dependents = rs.getString("num_of_dependents");
					if (l_num_of_dependents == null)
						l_num_of_dependents = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Number of dependents : " + l_num_of_dependents);

					l_resp_for_bill_payment = rs.getString("resp_for_bill_payment");
					if (l_resp_for_bill_payment == null)
						l_resp_for_bill_payment = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Responsible for Bill Payment : " + l_resp_for_bill_payment);

					l_pat_reln_with_resp_pers = rs.getString("pat_reln_with_resp_pers");
					if (l_pat_reln_with_resp_pers == null)
						l_pat_reln_with_resp_pers = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Patient Relation with responsible person : " + l_pat_reln_with_resp_pers);

					l_gl_holder_name = rs.getString("gl_holder_name");
					if (l_gl_holder_name == null)
						l_gl_holder_name = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: GL Holder Name : " + l_gl_holder_name);

					l_pat_reln_with_gl_holder = rs.getString("pat_reln_with_gl_holder");
					if (l_pat_reln_with_gl_holder == null)
						l_pat_reln_with_gl_holder = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Patient relation with GL Holder : " + l_pat_reln_with_gl_holder);

					l_NO_OF_ENC_GL_VALID = rs.getString("NO_OF_ENC_GL_VALID");
					if (l_NO_OF_ENC_GL_VALID == null)
						l_NO_OF_ENC_GL_VALID = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Number of Enc GL Valid : " + l_NO_OF_ENC_GL_VALID);

					l_NO_OF_AE_ENC_GL_VALID = rs.getString("NO_OF_AE_ENC_GL_VALID");
					if (l_NO_OF_AE_ENC_GL_VALID == null)
						l_NO_OF_AE_ENC_GL_VALID = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Number of AE Enc GL Valid : " + l_NO_OF_AE_ENC_GL_VALID);

					l_NO_OF_OP_ENC_GL_VALID = rs.getString("NO_OF_OP_ENC_GL_VALID");
					if (l_NO_OF_OP_ENC_GL_VALID == null)
						l_NO_OF_OP_ENC_GL_VALID = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Number of OP Enc GL Valid : " + l_NO_OF_OP_ENC_GL_VALID);

					l_NO_OF_IP_ENC_GL_VALID = rs.getString("NO_OF_IP_ENC_GL_VALID");
					if (l_NO_OF_IP_ENC_GL_VALID == null)
						l_NO_OF_IP_ENC_GL_VALID = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Number of IP Enc GL Valid : " + l_NO_OF_IP_ENC_GL_VALID);

					l_NO_OF_DC_ENC_GL_VALID = rs.getString("NO_OF_DC_ENC_GL_VALID");
					if (l_NO_OF_DC_ENC_GL_VALID == null)
						l_NO_OF_DC_ENC_GL_VALID = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Number of DC Enc GL Valid : " + l_NO_OF_DC_ENC_GL_VALID);

					l_remarks = rs.getString("remarks");
					if (l_remarks == null)
						l_remarks = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Remarks : " + l_remarks);

					l_PATIENT_INC_ASSET_IND = rs.getString("PATIENT_INC_ASSET_IND");
					if (l_PATIENT_INC_ASSET_IND == null)
						l_PATIENT_INC_ASSET_IND = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Patient Inc Asset IND : " + l_PATIENT_INC_ASSET_IND);

					l_PATIENT_INC_ASSET_AMT = rs.getString("PATIENT_INC_ASSET_AMT");
					if (l_PATIENT_INC_ASSET_AMT == null)
						l_PATIENT_INC_ASSET_AMT = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Patient Inc Asset Amount : " + l_PATIENT_INC_ASSET_AMT);

					l_PATIENT_INC_ASSET_FREQ = rs.getString("PATIENT_INC_ASSET_FREQ");
					if (l_PATIENT_INC_ASSET_FREQ == null)
						l_PATIENT_INC_ASSET_FREQ = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Patient Inc Asset freq : " + l_PATIENT_INC_ASSET_FREQ);

					l_SPOUSE_INC_ASSET_AMT = rs.getString("SPOUSE_INC_ASSET_AMT");
					if (l_SPOUSE_INC_ASSET_AMT == null)
						l_SPOUSE_INC_ASSET_AMT = "";
					if (l_debug_YN.equals("Y"))	
						System.out.println(" ::: Spouse Asset Amount : " + l_SPOUSE_INC_ASSET_AMT);

					l_SPOUSE_INC_ASSET_FREQ = rs.getString("SPOUSE_INC_ASSET_FREQ");
					if (l_SPOUSE_INC_ASSET_FREQ == null)
						l_SPOUSE_INC_ASSET_FREQ = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Spouse Asset Freq : " + l_SPOUSE_INC_ASSET_FREQ);

					l_DEPENDENT_INC_ASSET_AMT = rs.getString("DEPENDENT_INC_ASSET_AMT");
					if (l_DEPENDENT_INC_ASSET_AMT == null)
						l_DEPENDENT_INC_ASSET_AMT = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Dependent Asset Amount : " + l_DEPENDENT_INC_ASSET_AMT);

					l_DEPENDENT_INC_ASSET_FREQ = rs.getString("DEPENDENT_INC_ASSET_FREQ");
					if (l_DEPENDENT_INC_ASSET_FREQ == null)
						l_DEPENDENT_INC_ASSET_FREQ = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Dependent Asset Freq : " + l_DEPENDENT_INC_ASSET_FREQ);

					l_CLASSIFICATION_CODE = rs.getString("CLASSIFICATION_CODE");
					if (l_CLASSIFICATION_CODE == null)
						l_CLASSIFICATION_CODE = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Classification Code : " + l_CLASSIFICATION_CODE);

					l_CLASSIFICATION_TYPE = rs.getString("CLASSIFICATION_TYPE");
					if (l_CLASSIFICATION_TYPE == null)
						l_CLASSIFICATION_TYPE = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Classification Type : " + l_CLASSIFICATION_TYPE);

					l_CLASSIFICATION_START_DATE = rs.getString("CLASSIFICATION_START_DATE");
					if (l_CLASSIFICATION_START_DATE == null)
						l_CLASSIFICATION_START_DATE = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Classification End Date : " + l_CLASSIFICATION_START_DATE);

					l_CLASSIFICATION_END_DATE = rs.getString("CLASSIFICATION_END_DATE");
					if (l_CLASSIFICATION_END_DATE == null)
						l_CLASSIFICATION_END_DATE = "";					
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Classification End Date : " + l_CLASSIFICATION_END_DATE);

					l_financial_remarks = rs.getString("financial_remarks");
					if (l_financial_remarks == null)
						l_financial_remarks = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Financial Remarks : " + l_financial_remarks);

					l_SOCIAL_PENSIONER_ID = rs.getString("SOCIAL_PENSIONER_ID");
					if (l_SOCIAL_PENSIONER_ID == null)
						l_SOCIAL_PENSIONER_ID = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Pensioner Id : " + l_SOCIAL_PENSIONER_ID);
				}

			} catch (Exception e) {
				l_app_msg = "Exception Fetching Financial Required Values in  : " + e.getMessage();
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				e.printStackTrace();

			} finally {
				
				XHUtil.closeDBResources(rs, pstmt, null);
				EMDataSource.returnConnection(dbConn);
			}

			l_app_msg = " ::: Fetching Other financial Details ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			try {

				String otherQuery = "SELECT operating_facility_id,episode_type,patient_id,episode_id,visit_id,regn_date_time,acct_seq_no,cust_group_code,cust_code,"
						+ "priority,policy_type_code,policy_number,policy_start_date,policy_expiry_date,credit_auth_ref,credit_auth_date,effective_from effective_from,"
						+ "effective_to,approved_amt,approved_days,adj_rule_ind,adj_perc_amt_ind,adj_perc_amt_value,pmnt_diff_adj_int,drg_pmnt_diff_adj_int,"
						+ "spl_srv_pmnt_diff_adj_int,a.blng_grp_id,ref_src_main_code,ref_src_sub_code FROM BL_PRV_ENC_SELECT_INS_BG_VW a where operating_facility_id=?"
						+ " and patient_id=? AND episode_type=Decode(?,'Y',episode_type,?) AND nvl(episode_id,99999999) = decode(episode_type,'R',nvl(episode_id,99999999),?)"
						+ " AND nvl(visit_id,99999999) = decode(episode_type,'R',nvl(visit_id,99999999),'I',nvl(visit_id,99999999),'D',nvl(visit_id,99999999),?) "
						+ "and exists (Select 'X' from bl_blng_grp b where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR"
						+ " (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and a.blng_grp_id=b.blng_grp_id) order by priority";

				l_app_msg = " ::: otherQuery : " + otherQuery;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				dbConn = EMDataSource.getConnection();
				pstmt = dbConn.prepareStatement(otherQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: otherQuery parameters : Facility Id : " + l_facility_id
							+ " : Patient Id : " + l_patient_id + " : l_dflt_prv_fin_dtl_acrs_enc_yn : "
							+ l_dflt_prv_fin_dtl_acrs_enc_yn);

				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: otherQuery parameters : Episode Type :" + l_episode_type
						+ " : Episode No : " + l_episode_no + " : Visit No : " + l_visitno
						+ " : Calling Module Id : " + l_calling_module_id);
				pstmt.setString(1, l_facility_id);
				pstmt.setString(2, l_patient_id);
				pstmt.setString(3, l_dflt_prv_fin_dtl_acrs_enc_yn);
				pstmt.setString(4, l_episode_type);
				pstmt.setString(5, l_episode_no);
				pstmt.setString(6, l_visitno);
				pstmt.setString(7, l_calling_module_id);
				pstmt.setString(8, l_calling_module_id);
				pstmt.setString(9, l_calling_module_id);
				pstmt.setString(10, l_calling_module_id);
				pstmt.setString(11, l_calling_module_id);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					l_ref_src_main_code = rs.getString("ref_src_main_code");
					if (l_ref_src_main_code == null)
						l_ref_src_main_code = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: l_ref_src_main_code : " + l_ref_src_main_code);

					l_ref_src_sub_code = rs.getString("ref_src_sub_code");
					if (l_ref_src_sub_code == null)
						l_ref_src_sub_code = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: l_ref_src_sub_code : " + l_ref_src_sub_code);

					l_priority = rs.getString("priority");
					if (l_priority == null)
						l_priority = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: l_priority : " + l_priority);

					l_credit_auth_ref = rs.getString("credit_auth_ref");
					if (l_credit_auth_ref == null)
						l_credit_auth_ref = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: l_credit_auth_ref : " + l_credit_auth_ref);

					l_credit_auth_date = rs.getString("credit_auth_date");
					if (l_credit_auth_date == null)
						l_credit_auth_date = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: l_credit_auth_date : " + l_credit_auth_date);

					l_effective_from = rs.getString("effective_from");
					if (l_effective_from == null)
						l_effective_from = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: l_effective_from : " + l_effective_from);

					l_effective_to = rs.getString("effective_to");
					if (l_effective_to == null)
						l_effective_to = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: l_effective_to : " + l_effective_to);

					l_approved_amt = rs.getString("approved_amt");
					if (l_approved_amt == null)
						l_approved_amt = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: l_approved_amt " + l_approved_amt);

					l_approved_days = rs.getString("approved_days");
					if (l_approved_days == null)
						l_approved_days = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: l_approved_days : " + l_approved_days);

					l_adj_rule_ind = rs.getString("adj_rule_ind");
					if (l_adj_rule_ind == null)
						l_adj_rule_ind = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: l_adj_rule_ind : " + l_adj_rule_ind);

					l_adj_perc_amt_ind = rs.getString("adj_perc_amt_ind");
					if (l_adj_perc_amt_ind == null)
						l_adj_perc_amt_ind = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: l_adj_perc_amt_ind : " + l_adj_perc_amt_ind);

					l_adj_perc_amt_value = rs.getString("adj_perc_amt_value");
					if (l_adj_perc_amt_value == null)
						l_adj_perc_amt_value = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: l_adj_perc_amt_value : " + l_adj_perc_amt_value);

					l_pmnt_diff_adj_int = rs.getString("pmnt_diff_adj_int");
					if (l_pmnt_diff_adj_int == null)
						l_pmnt_diff_adj_int = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: l_pmnt_diff_adj_int : " + l_pmnt_diff_adj_int);

					l_drg_pmnt_diff_adj_int = rs.getString("drg_pmnt_diff_adj_int");
					if (l_drg_pmnt_diff_adj_int == null)
						l_drg_pmnt_diff_adj_int = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: l_drg_pmnt_diff_adj_int : " + l_drg_pmnt_diff_adj_int);

					l_spl_srv_pmnt_diff_adj_int = rs.getString("spl_srv_pmnt_diff_adj_int");
					if (l_spl_srv_pmnt_diff_adj_int == null)
						l_spl_srv_pmnt_diff_adj_int = "";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: l_spl_srv_pmnt_diff_adj_int : " + l_spl_srv_pmnt_diff_adj_int);
				}

			} catch (Exception e) {
				System.out.println("Exception Fetching other fin Details in  : " + e.getMessage());
				e.printStackTrace();

			} finally {
				
				XHUtil.closeDBResources(rs, pstmt, null);
				EMDataSource.returnConnection(dbConn);
			}

			if (l_slmt_ind.equals("R")) {
				l_str_cust_group_code = l_cust_group_code;
				l_str_cust_code = l_cust_code;
				l_str_doc_ref = l_credit_doc_ref_desc;
				l_str_doc_start_date = l_credit_doc_ref_start_date;
				l_str_doc_end_date = l_credit_doc_ref_date;
				l_settlement_type_code = l_slmt_type_code;
			} else if (l_slmt_ind.equals("X") && l_adm_rec_flag.equals("")) {
				l_str_cust_group_code = l_cust_group_code;
				l_str_cust_code = l_cust_code;
				l_str_doc_ref = l_credit_doc_ref_desc;
				l_str_doc_start_date = l_credit_doc_ref_start_date;
				l_str_doc_end_date = l_credit_doc_ref_date;
				l_settlement_type_code = l_slmt_type_code;
			} else if (l_slmt_ind.equals("X") && !l_adm_rec_flag.equals("")) {
				l_str_cust_group_code = l_cust_group_code;
				l_str_cust_code = l_cust_code;
				l_str_doc_ref = l_credit_doc_ref_desc;
				l_str_doc_start_date = l_credit_doc_ref_start_date;
				l_str_doc_end_date = l_credit_doc_ref_date;
				l_settlement_type_code = l_slmt_type_code;
			} else {
				l_str_doc_ref = l_credit_doc_ref_desc;
				l_str_doc_start_date = l_credit_doc_ref_start_date;
				l_str_doc_end_date = l_credit_doc_ref_date;
				l_settlement_type_code = l_slmt_type_code;
			}
			if (l_debug_YN.equals("Y")){				
				System.out.println(" ::: l_str_cust_group_code : " + l_str_cust_group_code);
				System.out.println(" ::: l_str_cust_code : " + l_str_cust_code);
				System.out.println(" ::: l_str_doc_ref : " + l_str_doc_ref);
				System.out.println(" ::: l_str_doc_start_date : " + l_str_doc_start_date);
				System.out.println(" ::: l_str_doc_end_date : " + l_str_doc_end_date);
				System.out.println(" ::: l_settlement_type_code : " + l_settlement_type_code);			
			}

			l_app_msg = " ::: Fetching Visit Type Ind ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			try {

				String visitTypeIndQuery = "select visit_type_ind from op_visit_type where visit_type_code='"
						+ l_visit_type + "' and facility_id='" + l_facility_id + "'";

				dbConn = EMDataSource.getConnection();
				pstmt = dbConn.prepareStatement(visitTypeIndQuery.toString());
				rs = pstmt.executeQuery();

				while (rs.next()) {
					l_visit_type_ind = rs.getString(1);
				}

				l_app_msg = " ::: l_visit_type_ind : " + l_visit_type_ind;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
			} catch (Exception e) {
				System.out.println("Exception Fetching Visit Type Ind : " + e.getMessage());
				e.printStackTrace();

			} finally {
				
				XHUtil.closeDBResources(rs, pstmt, null);
				EMDataSource.returnConnection(dbConn);
			}
			
			//
			
			//Added by Sethu for different status
			
			l_element_id = "PATIENT_ARRIVED";
			
			l_assign_pract_yn = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Patient Arrived Flag... " + l_assign_pract_yn);
			
			l_element_id = "START_CONSULTATION";
			
			l_start_consult_yn = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Start Consultation Flag... " + l_start_consult_yn);
			
			l_element_id = "END_CONSULTATION";
			
			l_end_consult_yn = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: End Consultation Flag... " + l_end_consult_yn);

			l_episode_status = "";
			l_last_visit_fu_reqd_yn = "";
			String pr_visitnum = "";
			if (l_visitnum.length() >= 4) {
				pr_visitnum = l_visitnum.substring(l_visitnum.length() - 1);
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: Visit NO 1 : " + pr_visitnum);
			} else {
				pr_visitnum = l_visitnum;
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: Visit NO 2 : " + pr_visitnum);
			}
			
			l_visit_status = "01";
			l_visit_status_set_on_date = "";
			l_visit_status_set_by_user = "";
			
			l_episode_status = "01";
			l_last_visit_fu_reqd_yn = "N";
			l_queue_status = "01"; 
			l_self_check_in = "N"; 
			l_arrive_date_time = ""; 
			l_other_res_class = "*"; 
			l_other_resource_id = "*ALL"; 
			l_srvc_start_date_time = ""; 
			l_srvc_end_date_time = ""; 
			l_prev_visit_status = "";
			
			if (l_assign_pract_yn.equals("Y"))
			{
				l_visit_status = "02";
				l_visit_status_set_on_date = l_visit_date_time;
				l_visit_status_set_by_user = added_by_id;
				
				l_episode_status = "01";
				l_last_visit_fu_reqd_yn = "N";
				l_queue_status = "02"; 
				l_self_check_in = "N"; 
				l_arrive_date_time = l_visit_date_time; 
				l_other_res_class = "*"; 
				l_other_resource_id = "*ALL"; 
				l_srvc_start_date_time = ""; 
				l_srvc_end_date_time = ""; 
				l_prev_visit_status = "";
			}
			
			if (l_start_consult_yn.equals("Y"))
			{
				l_visit_status = "04";
				l_visit_status_set_on_date = l_visit_date_time;
				l_visit_status_set_by_user = added_by_id;
				
				l_episode_status = "01";
				l_last_visit_fu_reqd_yn = "N";
				l_queue_status = "04"; 
				l_self_check_in = "N"; 
				l_arrive_date_time = l_con_srvc_start_date_time; 
				l_other_res_class = "*"; 
				l_other_resource_id = "*ALL"; 
				l_srvc_start_date_time = l_con_srvc_start_date_time; 
				l_srvc_end_date_time = ""; 
				l_prev_visit_status = "";
			}
			
			if (l_end_consult_yn.equals("Y"))
			{
				l_visit_status = "07";
				l_visit_status_set_on_date = l_visit_date_time;
				l_visit_status_set_by_user = added_by_id;
				
				l_episode_status = "08";
				l_last_visit_fu_reqd_yn = "N";
				l_queue_status = "07";
				l_self_check_in = "N";
				l_arrive_date_time = l_con_srvc_start_date_time;
				l_other_res_class = "*";
				l_other_resource_id = "*ALL";
				l_srvc_start_date_time = l_con_srvc_start_date_time;
				l_srvc_end_date_time = l_cons_srvc_end_date_time;
				l_prev_visit_status = "";
			}


			l_app_msg = " ::: insertable while PR_ENCOUNTER : " + insertable + " ::: Error Code : " + l_errcd;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			//Connection opened for Insert into PR_ENCOUNTER
			if (insertable) {
				try {
					dbConn = EMDataSource.getConnection();
					StringBuffer prEncounterSQL = new StringBuffer();
					int count = 0;
					String referral_toid = "", form60_YN = "", other_remarks = "";
					prEncounterSQL.append("insert into pr_encounter(facility_id, patient_id, appt_id, visit_adm_type, visit_adm_type_facility_id, " + //5
						"visit_adm_type_ind, assign_care_locn_type, assign_care_locn_code, attend_practitioner_id, referral_id, specialty_code, " + //6
						"contact_reason_code, appt_case_yn, ancillary_yn, ambulatory_status, op_episode_visit_num, recall_yn, mds_complete_yn, backdated_yn, " + //8
						"visit_status, added_by_id, added_facility_id, added_at_ws_no, modified_by_id, modified_facility_id, modified_at_ws_no, encounter_id, " + //8
						"patient_class, hosp_main, hosp_sub, card_id, expiry_date, privl_type_code, visit_adm_date_time, episode_id, service_code, subservice_code, " + //10
						"new_op_episode_yn, assign_room_num, assign_room_type, pat_trn_time, pat_curr_locn_code, pat_curr_locn_type, invitation_no, " + //7
						"prev_assign_care_locn_code, prev_assign_room_num, prev_subservice_code, prev_attend_practitioner_id, prev_visit_adm_type, " + //5
						"prev_visit_adm_type_ind, other_res_class, other_resource_id, queue_id, referred_locn_code, form60_yn, other_reason_remarks, " + //7
						"visit_status_set_on_date, visit_status_set_by_user)"); //2
					prEncounterSQL.append(" values(?, ?, ?, ?, ?, " + //5
						"?, ?, ?, ?, ?, ?, " + //6
						"?, ?, ?, ?, ?, ?, ?, ?, " +  //8
						"?, ?, ?, ?, ?, ?, ?, ?, " + //8
						"?, ?, ?, ?, To_Date(?,'dd/mm/yyyy'), ?, To_Date(?,'dd/mm/yyyy hh24:mi:ss'), ?, ?, ?, " + //10
						"?, ?, ?, To_Date(?,'dd/mm/yyyy hh24:mi:ss'), ?, ?, ?, " + //7
						"?, ?, ?, ?, ?, " + //5
						"?, ?, ?, ?, ?, ?, ?, " + //7
						"To_Date(?,'dd/mm/yyyy hh24:mi:ss'), ?)"); //2
					
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Encounter SQL " + prEncounterSQL.toString());
					
					pstmt = dbConn.prepareStatement(prEncounterSQL.toString());
					Object[] obj;
					obj = new Object[58];

					obj[0] = l_facility_id;
					obj[1] = l_patient_id;
					obj[2] = l_appt_id;
					obj[3] = l_visit_type;
					obj[4] = l_facility_id;
					
					obj[5] = l_visit_type_ind;					
					obj[6] = clinicMap.get("assign_care_locn_type");
					obj[7] = l_location_id;
					obj[8] = l_practitioner_id;
					obj[9] = "";
					obj[10] = clinicMap.get("speciality_code");
					
					obj[11] = "";					
					obj[12] = "A";
					obj[13] = "N";
					obj[14] = "";					
					obj[15] = pr_visitnum;
					obj[16] = "N";
					obj[17] = "N";
					obj[18] = "N";
					
					obj[19] = l_visit_status;					
					obj[20] = added_by_id;
					obj[21] = l_facility_id;
					obj[22] = added_at_ws_no;
					obj[23] = added_by_id;
					obj[24] = l_facility_id;
					obj[25] = added_at_ws_no;
					obj[26] = Long.parseLong(l_encounter_id);
					
					obj[27] = "OP";
					obj[28] = "";
					obj[29] = "";
					obj[30] = "";					
					obj[31] = "";
					obj[32] = "";
					obj[33] = l_visit_date_time;
					obj[34] = Integer.parseInt(l_episode_no);
					obj[35] = l_service_code;
					obj[36] = "";	
					
					obj[37] = new_op_episode_yn;					
					obj[38] = l_practitioner_id;
					obj[39] = "R";
					obj[40] = l_visit_date_time; //pat_trn_time - sysdate
					obj[41] = l_location_id;
					obj[42] = l_location_type;
					obj[43] = "";
					
					obj[44] = l_location_id;					
					obj[45] = "";					
					obj[46] = "";
					obj[47] = l_practitioner_id;
					obj[48] = l_visit_type;
					
					obj[49] = l_visit_type_ind;					
					obj[50] = "*";
					obj[51] = "*ALL";
					obj[52] = l_queueID;
					obj[53] = referral_toid;
					obj[54] = form60_YN;
					obj[55] = other_remarks;
					
					obj[56] = l_visit_status_set_on_date;
					obj[57] = l_visit_status_set_by_user;
					
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Encounter parameters : " + Arrays.toString(obj));

					pstmt = setData(pstmt, obj);

					count = pstmt.executeUpdate();

					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Count ::: " + count);

					if (count == 1) {
						insertable = true;
						if (l_debug_YN.equals("Y"))
							System.out.println(" ::: Inserted into Encounter table Successfully ::: ");
					} else {
						insertable = false;
						l_app_msg = " Unable to insert into Encounter ";
						if (l_debug_YN.equals("Y"))
							System.out.println(" ::: Cannot insert into Encounter Table ::: ");
					}
				} catch (Exception e) {
					l_app_msg = " Exception in Inserting Encounter " + e.getMessage();
					insertable = false;
					dbConn.rollback();
					XHUtil.closeDBResources(null, pstmt, null);
					EMDataSource.returnConnection(dbConn);
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					e.printStackTrace();
				}
			}
			
			if (!(insertable))
			{
				/// Control to be returned
				params.put("STATUS", "E");
				params.put("ERR_MSG", l_app_msg.toString());
				l_responseJsonString = sendErrorResponse(actionKey, l_app_msg.toString(), l_request_ref_no, params);
				return "200#" + l_responseJsonString + "#";
			}

			l_app_msg = " ::: Fetching Build Episode Rule ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			try {

				pstmt = dbConn.prepareStatement(
						"select oper_stn_access_rule, build_episode_rule, bl_interfaced_yn, ALLOW_WL_INV_WO_APPT_YN, ALLOW_EMER_REGN_YN,"
								+ " REG_VISIT_FOR_INPAT_YN, accept_display_inv_no,visit_type_derv_rule from op_param where operating_facility_id='"
								+ l_facility_id + "'");

				rs = pstmt.executeQuery();

				while (rs.next()) {
					l_build_episode_rule = rs.getString("build_episode_rule") == null ? ""
							: rs.getString("build_episode_rule");
				}

				l_app_msg = " ::: Build Episode Rule : " + l_build_episode_rule;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

			} catch (Exception e) {
				l_app_msg = " Excpetion while fetching Build Episode Rule " + e.getMessage();
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
			}

			l_app_msg = " ::: Insert/Update on OP EPISODE FOR SERVICE ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = " ::: insertable while OP EPISODE FOR SERVICE : " + insertable + " ::: Error Code : " + l_errcd;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (insertable) {
				if (l_build_episode_rule.equals("S")) {

					if (l_visitnum.equals("0001")) {
						try {

							String opEpisodeForServiceQuery = "insert into op_episode_for_service(patient_id, operating_facility_id, episode_id, clinic_code, service_code, " +
									"start_date_time, episode_status, last_encounter_id, last_visit_date, last_visit_num, " +
									"added_by_id, added_date, added_facility_id, added_at_ws_no, modified_by_id, modified_date, modified_facility_id, modified_at_ws_no, " +
									"subservice_code, last_visit_fu_reqd_yn, blng_grp_id, cust_code, cust_grp_code, policy_type_code, end_date_time, episode_notes)" +
									" values(?, ?, ?, ?, ?, " +
									" SYSDATE, ?, ?, SYSDATE, 1," +
									"?, sysdate, ?, ?, ?, sysdate, ?, ?, " +
									"?, ?, ?, ?, ?, ?, To_Date('"+l_srvc_end_date_time+"','dd/mm/yyyy hh24:mi:ss'), ?)";
							
							if (l_debug_YN.equals("Y"))
								System.out.println(" ::: Episode of Service Query : " + opEpisodeForServiceQuery);
							if (l_debug_YN.equals("Y"))
							System.out.println(" ::: Episode of Service parameters : patid : " + l_patient_id
									+ " : facilityid : " + l_facility_id + " : episodeno : " + l_episode_no);
							if (l_debug_YN.equals("Y"))
							System.out.println(" ::: Episode of Service parameters : l_location_id : "
									+ l_location_id + " : l_service_code : " + l_service_code + " : l_encounter_id : "
									+ l_encounter_id);
							
							if (l_debug_YN.equals("Y"))
								System.out.println(" ::: Episode of Service parameters : l_srvc_start_date_time : "
										+ l_srvc_start_date_time + " : l_con_srvc_start_date_time : " + l_con_srvc_start_date_time + " : l_encounter_id : "
										+ l_encounter_id);
							
							pstmt = dbConn.prepareStatement(opEpisodeForServiceQuery.toString());

							pstmt.setString(1, l_patient_id);
							pstmt.setString(2, l_facility_id);
							pstmt.setString(3, l_episode_no);
							pstmt.setString(4, l_location_id);
							pstmt.setString(5, l_service_code);
							pstmt.setString(6, l_episode_status);							
							pstmt.setString(7, l_encounter_id);
							pstmt.setString(8, added_by_id);
							pstmt.setString(9, l_facility_id);
							pstmt.setString(10, added_at_ws_no);
							pstmt.setString(11, added_by_id);
							pstmt.setString(12, l_facility_id);
							pstmt.setString(13, added_at_ws_no);
							pstmt.setString(14, "");
							pstmt.setString(15, l_last_visit_fu_reqd_yn);							
							pstmt.setString(16, l_billing_group_code);
							pstmt.setString(17, l_payer_code);
							pstmt.setString(18, l_payer_group_code);
							pstmt.setString(19, "");
							pstmt.setString(20, l_notes);
							
							int count = pstmt.executeUpdate();

							if (l_debug_YN.equals("Y"))
								System.out.println(" ::: Count Insert into Episode of Service ::: " + count);

							if (count == 1) {
								insertable = true;
								if (l_debug_YN.equals("Y"))
									System.out.println(" :::Inserted into Episode of Service Successfully ::: ");
							} else {
								insertable = false;
								dbConn.rollback();
								XHUtil.closeDBResources(null, pstmt, null);
								EMDataSource.returnConnection(dbConn);
								if (l_debug_YN.equals("Y"))
									System.out.println(" :::Cannot insert into Episode of Service ::: ");
							}
						} catch (Exception e) {
							l_app_msg = " Exception while Inserting Episode of Service " + e.getMessage();
							insertable = false;
							dbConn.rollback();
							XHUtil.closeDBResources(null, pstmt, null);
							EMDataSource.returnConnection(dbConn);
							if (l_debug_YN.equals("Y"))
								System.out.println(l_app_msg);
							e.printStackTrace();
						}

					} else {
						try {
							int count = 0;
							StringBuffer updateOPEpisodeForServiceQuery = new StringBuffer();

							updateOPEpisodeForServiceQuery
									.append("update op_episode_for_service set last_encounter_id = ?, 	last_visit_date = To_Date('"
											+ l_visit_date_time
											+ "','dd/mm/yyyy hh24:mi:ss'), last_visit_num = last_visit_num +1,BLNG_GRP_ID=?,CUST_CODE=?,CUST_GRP_CODE=?,POLICY_TYPE_CODE=?, MODIFIED_BY_ID =?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID	= ? where operating_facility_id = ? ");
							if (!l_VISIT_TYPE_DERV_RULE.equals("B")) {
								updateOPEpisodeForServiceQuery.append(" and service_code = ? ");
							}
							updateOPEpisodeForServiceQuery.append(" and episode_id =? and patient_id = ?");

							l_app_msg = " ::: Episode of Service Query : " + updateOPEpisodeForServiceQuery;
							if (l_debug_YN.equals("Y"))
								System.out.println(l_app_msg);

							pstmt = dbConn.prepareStatement(updateOPEpisodeForServiceQuery.toString());
							pstmt.setString(1, l_encounter_id);
							pstmt.setString(2, l_billing_group_code);
							pstmt.setString(3, l_payer_code);
							pstmt.setString(4, l_payer_group_code);
							pstmt.setString(5, l_policy_type_code);
							pstmt.setString(6, modified_by_id);
							pstmt.setString(7, added_at_ws_no);
							pstmt.setString(8, l_facility_id);
							pstmt.setString(9, l_facility_id);

							if (!l_VISIT_TYPE_DERV_RULE.equals("B")) {
								pstmt.setString(10, l_service_code);
								pstmt.setString(11, l_episode_no);
								pstmt.setString(12, l_patient_id);
							} else {
								pstmt.setString(10, l_episode_no);
								pstmt.setString(11, l_patient_id);
							}

							count = pstmt.executeUpdate();

							l_app_msg = " Count at Updating Episode of Service " + count;
							if (l_debug_YN.equals("Y"))
								System.out.println(l_app_msg);

							if (count > 0) {
								insertable = true;
								if (l_debug_YN.equals("Y"))
									System.out.println(" ::: Updated Episode of Service Successfully ::: ");
							} else {
								insertable = false;
								l_app_msg = " Unable to update Episode of Service ";
								dbConn.rollback();
								XHUtil.closeDBResources(null, pstmt, null);
								EMDataSource.returnConnection(dbConn);
								
								if (l_debug_YN.equals("Y"))
									System.out.println(" ::: Cannot update Episode of Service ::: ");
							}

						} catch (Exception e) {
							l_app_msg = " Exception while Updating Episode of Service " + e.getMessage();
							insertable = false;
							dbConn.rollback();
							XHUtil.closeDBResources(null, pstmt, null);
							EMDataSource.returnConnection(dbConn);
							if (l_debug_YN.equals("Y"))
								System.out.println(l_app_msg);
							e.printStackTrace();
						}
					}

				}
			}

			l_app_msg = " ::: After insert while Episode of Service : " + insertable + " ::: Error Code : "	+ l_errcd;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			if (!(insertable))
			{
				/// Control to be returned
				params.put("STATUS", "E");
				params.put("ERR_MSG", l_app_msg.toString());
				l_responseJsonString = sendErrorResponse(actionKey, l_app_msg.toString(), l_request_ref_no, params);
				return "200#" + l_responseJsonString + "#";
			}

			if (insertable) {
				try {
					String sql = "select '1' from op_last_visit_for_service"
							+ " where operating_facility_id=? and service_code=?" + " and patient_id=?";

					pstmt = dbConn.prepareStatement(sql);
					pstmt.setString(1, l_facility_id);
					pstmt.setString(2, l_service_code);
					pstmt.setString(3, l_patient_id);

					rs = pstmt.executeQuery();

					if (!rs.next()) {

						try {
							int opLastVisitForServiceCount = 0;

							String opLastVisitForServiceQuery = "insert into op_last_visit_for_service " +
									"(operating_facility_id, Encounter_id, service_code, patient_id, " +
									"added_by_id, added_date, added_facility_id, added_at_ws_no, " +
									"modified_by_id, modified_date, modified_facility_id, modified_at_ws_no, " +
									"VISIT_ADM_DATE_TIME, ASSIGN_CARE_LOCN_CODE, ATTEND_PRACTITIONER_ID, PATIENT_CLASS, REFERRAL_ID, SUBSERVICE_CODE) "
									+ " values(?,?,?,?," +
									"?,sysdate,?,?," +
									"?,sysdate,?,?," +
									"To_Date('" + l_visit_date_time+ "','dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?)";

							System.out.println(
									" ::: opLastVisitForServiceQuery : " + opLastVisitForServiceQuery.toString());
							System.out.println(" ::: Last Visit for Service parameters : facility_id : "
									+ l_facility_id + " : l_encounter_id : " + l_encounter_id + " : l_service_code : "
									+ l_service_code);
							System.out.println(" ::: Last Visit for Service parameters : l_patient_id : "
									+ l_patient_id + " : added_by_id : " + added_by_id + " : l_facility_id : "
									+ l_facility_id);
							System.out.println(" ::: Last Visit for Service parameters : added_at_ws_no : "
									+ added_at_ws_no + " : added_by_id : " + added_by_id + " : l_facility_id : "
									+ l_facility_id);
							System.out.println(" ::: Last Visit for Service parameters : added_at_ws_no : "
									+ added_at_ws_no + " : l_location_id : " + l_location_id + " : l_practitioner_id : "
									+ l_practitioner_id);
							System.out.println(" ::: Last Visit for Service parameters : l_calling_module_id : "
									+ l_calling_module_id);
							pstmt = dbConn.prepareStatement(opLastVisitForServiceQuery.toString());

							pstmt.setString(1, l_facility_id);
							pstmt.setString(2, l_encounter_id);
							pstmt.setString(3, l_service_code);
							pstmt.setString(4, l_patient_id);
							pstmt.setString(5, added_by_id);
							pstmt.setString(6, l_facility_id);
							pstmt.setString(7, added_at_ws_no);
							pstmt.setString(8, added_by_id);
							pstmt.setString(9, l_facility_id);
							pstmt.setString(10, added_at_ws_no);
							pstmt.setString(11, l_location_id);
							pstmt.setString(12, l_practitioner_id);
							pstmt.setString(13, l_calling_module_id);
							pstmt.setString(14, "");
							pstmt.setString(15, "");

							opLastVisitForServiceCount = pstmt.executeUpdate();

							l_app_msg = " ::: Count at Inserting Last Visit for Service : "
									+ opLastVisitForServiceCount;
							if (l_debug_YN.equals("Y"))
								System.out.println(l_app_msg);

							if (opLastVisitForServiceCount > 0) {
								insertable = true;
								if (l_debug_YN.equals("Y"))
									System.out
											.println(" ::: Inserted into Last Visit for Service Successfully ::: ");
							} else {
								insertable = false;
								dbConn.rollback();
								XHUtil.closeDBResources(rs, pstmt, null);
								EMDataSource.returnConnection(dbConn);
								
								if (l_debug_YN.equals("Y"))
									System.out.println(" :::Cannot inserted into Last Visit for Service ::: ");
							}

						} catch (Exception e) {
							l_app_msg = " Exception while Inserting Last Visit for Service " + e.getMessage();
							insertable = false;
							
							dbConn.rollback();
							XHUtil.closeDBResources(rs, pstmt, null);
							EMDataSource.returnConnection(dbConn);
							if (l_debug_YN.equals("Y"))
								System.out.println(l_app_msg);
							e.printStackTrace();
						}
					} else {
						int opLastCount = 0;
						String updateOpLastVisitForServiceQuery = " update op_last_visit_for_service set encounter_id=?,recall_date=null," 
								+ "recall_reason=null, VISIT_ADM_DATE_TIME = To_Date('" + l_visit_date_time+ "','dd/mm/yyyy hh24:mi:ss'), " 
								+ "ASSIGN_CARE_LOCN_CODE = ?, ATTEND_PRACTITIONER_ID = ?, "
								+ "PATIENT_CLASS = ?, REFERRAL_ID = ?, SUBSERVICE_CODE = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, "
								+ "MODIFIED_FACILITY_ID = ? where operating_facility_id=? and service_code=? and patient_id=? ";
						try {

							l_app_msg = " ::: Last Visit for Service Query : " + updateOpLastVisitForServiceQuery;
							if (l_debug_YN.equals("Y"))
								System.out.println(l_app_msg);

							pstmt = dbConn.prepareStatement(updateOpLastVisitForServiceQuery.toString());
							pstmt.setString(1, l_encounter_id);
							pstmt.setString(2, l_location_id);
							pstmt.setString(3, l_practitioner_id);
							pstmt.setString(4, l_calling_module_id);
							pstmt.setString(5, "");
							pstmt.setString(6, "");
							pstmt.setString(7, modified_by_id);
							pstmt.setString(8, modified_at_ws_no);
							pstmt.setString(9, l_facility_id);
							pstmt.setString(10, l_facility_id);
							pstmt.setString(11, l_service_code);
							pstmt.setString(12, l_patient_id);

							opLastCount = pstmt.executeUpdate();

							l_app_msg = " ::: Count at Updating Last Visit for Service : " + opLastCount;
							if (l_debug_YN.equals("Y"))
								System.out.println(l_app_msg);

							if (opLastCount > 0) {
								insertable = true;
								if (l_debug_YN.equals("Y"))
									System.out.println(" ::: Updated Last Visit for Service Successfully ::: ");
							} else {
								insertable = false;
								l_app_msg = " Unable to update Last Visit for Service : ";
								dbConn.rollback();
								XHUtil.closeDBResources(rs, pstmt, null);
								//EMDataSource.returnConnection(dbConn);
								if (l_debug_YN.equals("Y"))
									System.out.println(" :::Cannot Update Last Visit for Service ::: ");
							}

						} catch (Exception e) {
							l_app_msg = " Exception while Updating Last Visit for Service " + e.getMessage();
							insertable = false;
							dbConn.rollback();
							XHUtil.closeDBResources(rs, pstmt, null);
							EMDataSource.returnConnection(dbConn);
							if (l_debug_YN.equals("Y"))
								System.out.println(l_app_msg);
							e.printStackTrace();
						}
					}
				} catch (Exception exc11) {

					exc11.printStackTrace();

				}
			}

			l_app_msg = " ::: After insert into Last Visit for Service : " + insertable + " ::: Error Code : " + l_errcd;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			if (!(insertable))
			{
				/// Control to be returned
				params.put("STATUS", "E");
				params.put("ERR_MSG", l_app_msg.toString());
				l_responseJsonString = sendErrorResponse(actionKey, l_app_msg.toString(), l_request_ref_no, params);
				return "200#" + l_responseJsonString + "#";
			}

			if (insertable) {
				try {
					String opPatientQueueQuery = "insert into op_patient_queue (facility_id, queue_date, queue_shift, locn_type, locn_code,"
							+ " queue_num, patient_id, practitioner_id, room_num, appt_or_walk_in_ind, appt_id, appt_time, encounter_id, check_in_date_time,"
							+ " queue_status, added_by_id, added_date, added_facility_id, added_at_ws_no, "
							+ " modified_by_id, modified_date, modified_facility_id, modified_at_ws_no, " 
							+ " queue_id, other_res_class, other_resource_id, visit_type_ind, visit_type_code, service_code, " 
							+ " subservice_code, pat_curr_locn_code, pat_curr_locn_type, speciality_code, referral_id, " 
							+ " episode_id, op_episode_visit_num, invitation_no, contact_reason_code," 
							+ " self_chkin_yn, arrive_date_time, " 
							+ " cons_srvc_start_date_time, cons_srvc_end_date_time, prev_visit_status )"
							+ " values(?, SYSDATE, '*ALL', ?, ?,"
							+ l_quenum + ", ?, ?, ?, ?, ?, null,'" + l_encounter_id + "',To_Date('"+l_srvc_start_date_time+ "','dd/mm/yyyy hh24:mi:ss')," 
							+ " ?, ?, sysdate, ?, ?, " 
							+ " ?, sysdate, ?, ?, " 
							+ "'" + l_queueID + "', ?, ?, ?, ?, ?, " 
							+ "?, ?, ?, ?, ?, " 
							+ "?, ?, ?, ?, " 
							+ "?, To_Date('" + l_arrive_date_time + "','dd/mm/yyyy hh24:mi:ss'), " 
							+ " To_Date('" + l_srvc_start_date_time + "','dd/mm/yyyy hh24:mi:ss'), To_Date('" + l_srvc_end_date_time + "','dd/mm/yyyy hh24:mi:ss'), ?)";
					
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Patient Queue Query : " + opPatientQueueQuery.toString());
					
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Patient Queue Query parameters : Facility Id : " + l_facility_id
							+ " : l_location_type : " + l_location_type + " : l_location_id : " + l_location_id);
					
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Patient Queue Query parameters : Patient Id : " + l_patient_id
							+ " : l_practitioner_id : " + l_practitioner_id + " : *ALL : W ");
					
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Patient Queue Query parameters : Appointment Id : " + l_appt_id
							+ " : added_by_id : " + added_by_id + " : l_facility_id : " + l_facility_id);
					
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Patient Queue Query parameters : Workstation No. : " + added_at_ws_no
							+ " : modified_by_id : " + modified_by_id);
					
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Patient Queue Query parameters : Modified By Id : " + modified_by_id
							+ " : modified_at_ws_no : " + modified_at_ws_no + " : l_visit_type_ind : "
							+ l_visit_type_ind);
					
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Patient Queue Query parameters : Visit Type : " + l_visit_type
							+ " : l_service_code : " + l_service_code + " : l_location_id : " + l_location_id);
					
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Patient Queue Query parameters : Location Type : " + l_location_type
							+ " : speciality_code : " + clinicMap.get("speciality_code"));
					
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Patient Queue Query parameters : Episode No : " + l_episode_no
							+ " : l_visitnum : " + l_visitnum);
					
					pstmt = dbConn.prepareStatement(opPatientQueueQuery.toString());
					
					pstmt.setString(1, l_facility_id);
					pstmt.setString(2, l_location_type);
					pstmt.setString(3, l_location_id);
					pstmt.setString(4, l_patient_id);
					pstmt.setString(5, l_practitioner_id);
					pstmt.setString(6, "*ALL");
					pstmt.setString(7, "A");
					pstmt.setString(8, l_appt_id);
					pstmt.setString(9, l_queue_status);
					pstmt.setString(10, added_by_id);
					pstmt.setString(11, l_facility_id);
					pstmt.setString(12, added_at_ws_no);
					pstmt.setString(13, modified_by_id);
					pstmt.setString(14, l_facility_id);
					pstmt.setString(15, modified_at_ws_no);
					pstmt.setString(16, l_other_res_class);
					pstmt.setString(17, l_other_resource_id);
					pstmt.setString(18, l_visit_type_ind);
					pstmt.setString(19, l_visit_type);
					pstmt.setString(20, l_service_code);
					pstmt.setString(21, "");
					pstmt.setString(22, l_location_id);
					pstmt.setString(23, l_location_type);
					pstmt.setString(24, clinicMap.get("speciality_code"));
					pstmt.setString(25, "");
					pstmt.setString(26, l_episode_no);
					pstmt.setString(27, l_visitnum);
					pstmt.setString(28, "");
					pstmt.setString(29, "");
					pstmt.setString(30, l_self_check_in);
					pstmt.setString(31, l_prev_visit_status);

					int opPatientQueueCount = 0;

					opPatientQueueCount = pstmt.executeUpdate();

					l_app_msg = " ::: count at Updating Patient Queue Query : " + opPatientQueueCount;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					if (opPatientQueueCount > 0) {
						insertable = true;
						if (l_debug_YN.equals("Y"))
							System.out.println(" ::: Inserted into Patient Queue Successfully ::: ");
					} else {
						insertable = false;
						l_app_msg = " Unable to insert into op_patient_queue ";
						dbConn.rollback();
						XHUtil.closeDBResources(null, pstmt, null);
						EMDataSource.returnConnection(dbConn);
						if (l_debug_YN.equals("Y"))
							System.out.println(" ::: Cannot insert into Patient Queue ::: ");
					}

				} catch (Exception e) {
					l_app_msg = " Exception while Inserting into Patient Queue " + e.getMessage();
					insertable = false;
					dbConn.rollback();
					XHUtil.closeDBResources(null, pstmt, null);
					EMDataSource.returnConnection(dbConn);
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					e.printStackTrace();
				}
			}
			
			if (l_debug_YN.equals("Y"))
				System.out.println(":::::::::::insertable value after insertion and updation of tables :::::" + insertable);
			
			if (!(insertable))
			{
				/// Control to be returned
				params.put("STATUS", "E");
				params.put("ERR_MSG", l_app_msg.toString());
				l_responseJsonString = sendErrorResponse(actionKey, l_app_msg.toString(), l_request_ref_no, params);
				return "200#" + l_responseJsonString + "#";
			}
			
			if (insertable) {	
				
				try {
				
					String updateAppt = "update oa_appt set appt_status = 'A', encounter_id = ? " +
							" where facility_id = ? and appt_ref_no = ?";
					
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Update Appointment : " + updateAppt.toString());
					
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Update Appointment parameters : Facility Id : " + l_facility_id
							+ " : Appointment Reference : " + l_appt_id + " : Encouter Id : " + l_encounter_id);					
					
					pstmt = dbConn.prepareStatement(updateAppt);
					
					pstmt.setString(1, l_encounter_id);
					pstmt.setString(2, l_facility_id);
					pstmt.setString(3, l_appt_id);
	
					int updateApptCount = 0;
	
					updateApptCount = pstmt.executeUpdate();
	
					l_app_msg = " ::: Count at Update Appointment : " + updateApptCount;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
	
					if (updateApptCount > 0) {
						insertable = true;
						if (l_debug_YN.equals("Y"))
							System.out.println(" ::: Update Appointment Successfully ::: ");
					} else {
						insertable = false;
						l_app_msg = " Unable to update Appointment Table ";
						dbConn.rollback();
						XHUtil.closeDBResources(null, pstmt, null);
						//EMDataSource.returnConnection(dbConn);
						if (l_debug_YN.equals("Y"))
							System.out.println(" ::: Could not update Appointment Table ::: ");
					}
				} catch (Exception e) {
					l_app_msg = " Exception while updating in Appointment table " + e.getMessage();
					insertable = false;
					dbConn.rollback();
					XHUtil.closeDBResources(null, pstmt, null);
					//EMDataSource.returnConnection(dbConn);
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					e.printStackTrace();
				}
				
			}
			
			if (!(insertable))
			{
				/// Control to be returned
				params.put("STATUS", "E");
				params.put("ERR_MSG", l_app_msg.toString());
				l_responseJsonString = sendErrorResponse(actionKey, l_app_msg.toString(), l_request_ref_no, params);
				return "200#" + l_responseJsonString + "#";
			}
			
			if (l_debug_YN.equals("Y"))
				System.out.println(" Insertable value after insert into Appointment ::: " + insertable);
			
			String l_practo_trans_id = "", l_practo_doc_number = "",  l_receipt_remarks = "";
			String l_practo_doc_date = "", l_bank_code = "";

			if (insertable) {

				try {

					query = "SELECT DOC_AMT, nvl(slmt_doc_remarks,'') slmt_doc_remarks, nvl(practo_trans_id,'') practo_trans_id, " +
							" nvl(practo_doc_number,'') practo_doc_number,  nvl(slmt_doc_ref_desc,'') slmt_doc_ref_desc, " +
							" nvl(receipt_remarks,'') receipt_remarks,  to_char(practo_doc_date,'dd/mm/yyyy hh24:mi:ss') practo_doc_date" +
							" FROM XH_WP_RECEIPT WHERE OPERATING_FACILITY_ID = ? and EXT_APPT_REF_NO = ?";

					pstmt = dbConn.prepareStatement(query);
					pstmt.setString(1, l_facility_id);
					pstmt.setString(2, l_ext_appt_ref_no);

					rs = pstmt.executeQuery();
					while (rs.next()) {
						l_amount = rs.getInt("DOC_AMT");
						l_slmt_doc_remarks = rs.getString("slmt_doc_remarks"); //Credit Card Issue Bank
						l_practo_trans_id = rs.getString("practo_trans_id"); // Approval reference Number
						l_practo_doc_number = rs.getString("practo_doc_number"); //Receipt Refund Number
						l_slmt_doc_ref_desc = rs.getString("slmt_doc_ref_desc"); // CC Batch Number
						l_receipt_remarks = rs.getString("receipt_remarks"); // Credit card Number
						l_practo_doc_date = rs.getString("practo_doc_date"); // Credit Card Transaction Date
					}
					
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Credit Card Issue Bank : "
							+ l_slmt_doc_remarks + " : Approval reference Number : " + l_practo_trans_id + " : Receipt Refund Number : "
							+ l_practo_doc_number + " : CC Batch Number : " + l_slmt_doc_ref_desc + " : Credit card Number : "
							+ l_receipt_remarks + " : Credit Card Transaction Date : " + l_practo_doc_date);
					
					
					if (l_slmt_doc_remarks.length()>0)
					{
						if (l_slmt_doc_remarks.indexOf("#")>0)
						{
							l_bank_code = l_slmt_doc_remarks.substring(l_slmt_doc_remarks.indexOf("#")+1);
						}
					}
					
					l_element_id = "ONLINE_TYPE_CODE";

					l_slmt_type_code = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
					if (l_slmt_type_code.indexOf("Error in") >= 0 || "".equals(l_slmt_type_code.trim())) {
						l_slmt_type_code = "OG";
					}
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Settlement Type Code ::: " + l_slmt_type_code);
					
					/*
					cstmt = dbConn.prepareCall("call bl_visit_gen_3rd_party(?,?,?,?,?,?,?,?,?,?,?,?,?,?," + "to_date('"
							+ l_visit_date_time + "','DD/MM/YYYY HH24:MI:SS'),?,?,?,?,?,?,?,?,?)");
					*/
					
					cstmt = dbConn.prepareCall("call bl_visit_gen_3rd_party(?,?,?,?,?,?,?,?,?,?,?,?,?,?," + "to_date('"
							+ l_visit_date_time + "','DD/MM/YYYY HH24:MI:SS'),?,?,?,?,?,?, ?,?,?,?,?,?,"+"to_date('"+l_practo_doc_date+"','DD/MM/YYYY HH24:MI:SS'), sysdate, ?,?,?)");
					
					//if (l_debug_YN.equals("Y"))
					
					System.out.println(" ************************ Visit Registertration for the External Appointment Reference "+l_ext_appt_ref_no+ "************************");
					System.out.println(" Calling bl_visit_gen_3rd_party ('"+l_facility_id+"','"+l_patient_id+"',"+Integer.parseInt(l_episode_no)+","+Integer.parseInt(l_visitno)+ ",'" +
						l_BLNG_GRP_ID +"','"+added_by_id+"','"+l_slmt_type_code+"','"+l_slmt_doc_remarks+"','"+added_at_ws_no+"','"+l_calling_function_id+"','"+l_location_id+"','"+
						l_visit_type+"','"+"P"+"','"+l_practitioner_id+"',"+l_amount+",'"+l_REC_TYPE_CODE+"',l_bill_doc_type_code, bill_no, l_slmt_doc_type_code, receipt_no,'"+""+
						l_practo_trans_id+"','"+l_practo_doc_number+"','"+l_slmt_doc_ref_desc+"','"+l_receipt_remarks+"','"+l_bank_code+"',l_error_level, l_sys_message_id, l_error_text)");
							

					cstmt.setString(1, l_facility_id);
					cstmt.setString(2, l_patient_id);
					cstmt.setInt(3, Integer.parseInt(l_episode_no));
					cstmt.setInt(4, Integer.parseInt(l_visitno));
					cstmt.setString(5, l_BLNG_GRP_ID);
					cstmt.setString(6, added_by_id);
					cstmt.setString(7, l_slmt_type_code);
					cstmt.setString(8, l_slmt_doc_remarks);
					cstmt.setString(9, added_at_ws_no);
					cstmt.setString(10, l_calling_function_id);
					cstmt.setString(11, l_location_id);
					cstmt.setString(12, l_visit_type);
					cstmt.setString(13, "P");
					cstmt.setString(14, l_practitioner_id);
					cstmt.setInt(15, l_amount);
					cstmt.setString(16, l_REC_TYPE_CODE);
					cstmt.registerOutParameter(17, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(18, java.sql.Types.NUMERIC);
					cstmt.registerOutParameter(19, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(20, java.sql.Types.NUMERIC);
					cstmt.setString(21, ""); // p_bank_cc_code - RECEIPT_REMARKS
					cstmt.setString(22, l_practo_trans_id); // p_appr_ref_no - PRACTO_TRANS_ID
					cstmt.setString(23, l_practo_doc_number); //p_rcpt_rfnd_id_no - PRACTO_DOC_NUMBER
					cstmt.setString(24, l_slmt_doc_ref_desc); // p_batch_no - SLMT_DOC_REF_DESC
					cstmt.setString(25, l_receipt_remarks); // p_slmt_doc_ref - RECEIPT_REMARKS
					cstmt.setString(26, l_bank_code);  // Issuing Bank - Blank
										
					cstmt.registerOutParameter(27, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(28, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(29, java.sql.Types.VARCHAR);					

					cstmt.execute();

					l_bill_doc_type_code = cstmt.getString(17);
					bill_no = cstmt.getInt(18);
					l_slmt_doc_type_code = cstmt.getString(19);
					receipt_no = cstmt.getInt(20);
					
					l_error_level = cstmt.getString(27);
					l_sys_message_id = cstmt.getString(28);
					l_error_text = cstmt.getString(29);
					
					//if (l_debug_YN.equals("Y"))
					System.out.println(" ::: bl_visit_gen_3rd_party Response : Bill Document type Code : "
							+ l_bill_doc_type_code + " : Bill Number : " + bill_no + " : Settlement Doc Type Code : "
							+ l_slmt_doc_type_code + " : Receipt Number : " + receipt_no + " : Error Level : "
							+ l_error_level + " : System message Id : " + l_sys_message_id + " : Error Text : "
							+ l_error_text);
					
					
					
					if (0!=bill_no){							
						l_bill_no = Integer.toString(bill_no);					
					}
					else{
						l_bill_no = "";
					}
					
					if (0!=receipt_no){						
						l_receipt_no = Integer.toString(receipt_no);					
					}
					else{
						l_receipt_no = "";
					}				
					
					l_error = new StringBuffer("");

					if ((l_bill_no == null || l_bill_no.equals(""))
							|| (l_receipt_no == null || l_receipt_no.equals(""))) {
						
						l_error = new StringBuffer("Unable to register the patient visit ");

						l_app_msg = " ::: Error in Fetching Bill num and Receipt num ::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						l_errcd = "E";
						insertable = false;
						
						query = "select MESSAGE_TEXT_SYSDEF from sm_message where MESSAGE_ID = ?";

						pstmt = dbConn.prepareStatement(query);
						pstmt.setString(1, l_sys_message_id);
						rs = pstmt.executeQuery();
						while (rs.next()) {
							l_sm_message = rs.getString("MESSAGE_TEXT_SYSDEF");

						}						
						l_error.append("- Error in Fetching Bill number and Receipt number , "+l_sys_message_id+ "-"+l_sm_message);	
						
						//if (l_debug_YN.equals("Y"))
							System.out.println(l_error.toString());
						
						System.out.println(" ************************ External Appointment Reference "+l_ext_appt_ref_no+ "************************");
						
						l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);
						return "200#" + l_responseJsonString + "#";
					}

					if (l_errcd.equals("E")) {
						l_app_msg = " ::: Inserting Request into Message Table while Service validation ::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);
						return "200#" + l_responseJsonString + "#";
					}

				} catch (Exception e) {
					l_app_msg = "Exception in Fetching Bill_no and Receipt_num : " + e.getMessage();
					insertable = false;
					dbConn.rollback();
					XHUtil.closeDBResources(rs, cstmt, null);
					EMDataSource.returnConnection(dbConn);
					
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					e.printStackTrace();
				}
				
				finally {
					
					if (insertable) {
						dbConn.commit();
					} else {
						dbConn.rollback();
					}
					
					XHUtil.closeDBResources(rs, pstmt, null);
					EMDataSource.returnConnection(dbConn);
				}

				Map<String, String> map = new HashMap<String, String>();
				map.put("facility_id", l_facility_id);
				map.put("patient_id", l_patient_id);
				map.put("encounter_id", l_encounter_id);
				map.put("bill_no", l_bill_no);
				map.put("receipt_no", l_receipt_no);
				visitData.add(map);

				l_status = "1";
				l_status_desc = "Visit registered successfully";
				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				l_response_json.put("visit_data", visitData);

				l_responseJsonString = objMapper.writeValueAsString(l_response_json);

				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				params.put("ERR_MSG", l_error.toString());
				l_response_str = updateInboundMessageTable(actionKey, params, l_errcd,l_episode_no, l_visitno);
				l_app_msg = " ::: update Inbound Message Table ::: " + l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_app_msg = " ************ Practo Register Patient Transaction Ended ************ ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

			}
		} catch (Exception e) {

			e.printStackTrace();
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^ Exception Occurred " + e.getMessage();
			l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \"Reference Number :" + l_message_id + " Exception : " + e.getMessage() + " \"  " + " } ";
			
			l_app_msg = "::: On Exception the message is loaded ::: ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());

			l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_errmsg);
			l_app_msg = l_app_msg + " : " + l_response_str;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_app_msg = " ************ Patient Visit Registration request Ended ************ ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			return "200#" + l_response_err_json + "#";

		}

		return "200#" + l_responseJsonString + "#";
	}

	public String MessageLoadMethod(String message, Map<String, String> param, String status, String err_message) {

		String l_app_msg = "";
		String l_request_date = "", l_status_return = "";

		try {

			l_app_msg = " ::: Inside Message Loading ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_request_date = getFormattedStringDate("dd-MMM-yyyy HH:mm:ss", new java.util.Date());

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

	public String waitUpdation(Map<String, String> params) {

		String l_response_str = "", l_app_msg = "", l_errmsg = "";
		String l_message_status = "", l_message_ack_text = "";

		Connection Conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";

		try {

			l_app_msg = " ::: Inside  Wait Updation ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			Conn = EMDataSource.getConnection();
			// dbConn = EMDBConnectionPool.getConnection();
			query = "SELECT MESSAGE_STATUS,ERR_MSG,MESSAGE_ACK_TEXT FROM XH_INBOUND_MESSAGE WHERE APPLICATION_ID = ? and FACILITY_ID = ? and MESSAGE_ID = ? and EVENT_TYPE = ?";

			pstmt = Conn.prepareStatement(query);
			pstmt.setString(1, params.get("APPLICATION_ID"));
			pstmt.setString(2, params.get("FACILITY_ID"));
			pstmt.setString(3, params.get("MESSAGE_ID"));
			pstmt.setString(4, params.get("EVENT_TYPE"));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				l_message_status = rs.getString("MESSAGE_STATUS");
				l_message_ack_text = rs.getString("MESSAGE_ACK_TEXT");
			}
			if ((l_message_status.equals("L") || l_message_status.equals("E")) && l_message_ack_text.length() > 0) {
				return "200#" + l_message_ack_text + "#";
			} /*
				 * else if (l_message_status.equals("E") || ) { return
				 * "403#"+l_error_message + "#"; }
				 */else {
				l_response_str = " { " + " \"status\":0, " + " \"message\":\"Reference Number :"
						+ params.get("MESSAGE_ID") + ", Transaction Failed \"  " + " } ";
				// return "200#" + l_response_str + "#";

				return "false";
			}

		} catch (Exception e) {
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^ Exception Occurred " + e.getMessage();

			if (l_debug_YN.equals("Y"))
				System.out.println(l_errmsg);

			l_response_str = " { " + " \"status\":0, " + " \"message\" : \"Reference Number :"
					+ params.get("MESSAGE_ID") + ", Exception Occurred " + e.getMessage() + " \"  " + " } ";

			return "200#" + l_response_str + "#";
		} finally {
			// XHUtil.closeDBResources(rs, pstmt, dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(Conn);
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
			// dbConn = EMDBConnectionPool.getConnection();
			query = "select " + SeqenceName + ".NEXTVAL Message_id FROM DUAL ";

			if (dbConn == null)
				return l_conn_msg;

			// return ConnectionManager.l_errmsg;

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
			// XHUtil.closeDBResources(rs, pstmt, dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}

		return l_field_value;
	}

	public static ArrayList<String> FetchExternalAppDetails(String ExternalApplication) {
		Connection Conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "";
		ArrayList<String> externalArray = new ArrayList<String>();

		String l_application_id = "", l_protocol_link_id = "", l_facility_id = "";

		l_app_msg = " ::: Inside FetchExternalAppDetails ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: ExternalApplication : " + ExternalApplication;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			Conn = EMDataSource.getConnection();
			// dbConn = EMDBConnectionPool.getConnection();
			query = "SELECT APPLICATION_ID,PROTOCOL_LINK_ID,FACILITY_ID FROM xh_filter_dms_vw WHERE EXTERNAL_APPLICATION = 'PRACTOINB'";

			if (Conn == null) {
				externalArray.add(l_conn_msg);
				return externalArray;
			}

			pstmt = Conn.prepareStatement(query);
			// pstmt.setString(1, ExternalApplication);
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
			// XHUtil.closeDBResources(rs, pstmt, dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(Conn);
		}
		return externalArray;
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
				+ " MESSAGE_STATUS = ?, EPISODE_ID = ?, VISIT_ID = ? "
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
			
			l_appln_id =  params.get("APPLICATION_ID");
			l_facility_id =  params.get("FACILITY_ID");
			l_message_id = params.get("MSG_ID");
			
			l_app_msg = " ::: Application Id... "+l_appln_id+" Facility Id... "+l_facility_id+" Mesage Id... "+l_message_id;
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
			
			l_app_msg = " ::: Application Id... "+l_appln_id+" Facility Id... "+l_facility_id+" Mesage Id... "+l_message_id+" Record Count... "+l_record_count;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			if (l_record_count > 0){
				
				pstmt = dbConn.prepareStatement(updateStmt);
				pstmt.setString(1, params.get("ERR_MSG")); // MESSAGE_ACK_TEXT
				pstmt.setString(2, params.get("MESSAGE_ACK_TEXT")); // MESSAGE_ACK_TEXT
				pstmt.setString(3, params.get("MESSAGE_STATUS"));
				pstmt.setString(4, params.get("EPISODE_ID"));
				pstmt.setString(5, params.get("VISIT_ID"));				
				pstmt.setString(6, params.get("APPLICATION_ID"));				
				pstmt.setString(7, params.get("FACILITY_ID"));	
				pstmt.setString(8, params.get("MSG_ID"));
				
				l_app_msg = " ::: Application Id... "+params.get("APPLICATION_ID")+" Facility Id... "+params.get("FACILITY_ID")+" Mesage Id... "+params.get("MSG_ID");
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Error Message... "+params.get("ERR_MSG")+" Message Ack text... "+params.get("MESSAGE_ACK_TEXT")+" Status... "+params.get("MESSAGE_STATUS");
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
			}
			else
			{
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
				pstmt.setString(15, XHDBAdapter.isNullReplace(params.get("ADDED_BY_FACILITY"), params.get("FACILITY_ID")));
	
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

	public String validateRequest(String key) {
		String query = "";
		String l_app_msg = "", l_errmsg = "";
		String l_key = "";
		String l_segment_id = "PWS", l_standard_code = "HTTPCC";

		Connection Conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			l_app_msg = " ::: Validating the request ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			Conn = EMDataSource.getConnection();
			// dbConn = EMDBConnectionPool.getConnection();
			query = "SELECT ELEMENT_ID,NVL(DEFAULT_VALUE,'X') DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG "
					+ " WHERE SEGMENT_ID = ? " + " AND STANDARD_CODE = ? ";

			pstmt = Conn.prepareStatement(query);
			pstmt.setString(1, l_segment_id);
			pstmt.setString(2, l_standard_code);
			rs = pstmt.executeQuery();
			Map<String, String> params = new HashMap<String, String>();
			while (rs.next()) {
				params.put(rs.getString("ELEMENT_ID"),
						rs.getString("DEFAULT_VALUE") == null ? "" : rs.getString("DEFAULT_VALUE"));
			}

			l_key = params.get("KEY");
			l_app_msg = " ::: Data Key : " + l_key + " ::: Request Key : " + key;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (!l_key.equals(key)) {
				l_errcd = "E";
				l_errmsg = "Error in Key validation - key does not match";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_errmsg);
				return "{\"status\":0,\"error_message\":\"Authentication Error! - Key does not match\"} ";
			}
			/*
			 * l_app_msg = " ::: Fetching Siganture... "; if
			 * (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			 * 
			 * l_signature = XHUtil.getSHA512(l_key+"|"+l_pkey+"|"+l_salt);
			 * l_app_msg = " ::: l_signature : "+l_signature; if
			 * (l_debug_YN.equals("Y")) System.out.println(l_app_msg); if
			 * (l_signature.indexOf("Error")>=0) { l_errmsg = "Error in "+
			 * l_app_msg + " : " + l_signature; l_app_msg = " ::: l_errmsg : "
			 * +l_errmsg; if (l_debug_YN.equals("Y"))
			 * System.out.println(l_app_msg); return
			 * "{\"status\":0,\"error_message\":\"Authentication Error!\"}"; }
			 * if(!(l_signature.equals("signature"))){ return
			 * "{\"status\":{\"response_code\":401,\"message\":\"signature mismatch\"},\"body\":{\"message\":\"signature mismatch\"}"
			 * ; }
			 */
			else {
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
			// XHUtil.closeDBResources(rs, pstmt, dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(Conn);
		}

	}

	public static String FetchResponseWaitTime(String pluginType) {

		Connection Conn = null;
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
			Conn = EMDataSource.getConnection();
			// dbConn = EMDBConnectionPool.getConnection();
			query = "SELECT NVL(COMM_PROCESS_IDLE_TIME, 0) COMM_PROCESS_IDLE_TIME,NVL(SLEEPINTERVAL, 0) SLEEPINTERVAL FROM XH_INTERACTIVE_CONNECT_PARAM "
					+ " WHERE PLUGIN_TYPE = ? ";

			pstmt = Conn.prepareStatement(query);
			pstmt.setString(1, pluginType);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				l_wait_time = rs.getInt("COMM_PROCESS_IDLE_TIME");
				l_sleep_interval = rs.getInt("SLEEPINTERVAL");
			}

			l_field_value = String.valueOf(l_wait_time) + "#" + String.valueOf(l_sleep_interval);

			l_app_msg = " Response Time ::: " + l_field_value;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

		} catch (Exception e) {
			l_field_value = "Error in fetching the response wait time : " + e.getMessage();
		} finally {
			// XHUtil.closeDBResources(rs, pstmt, dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(Conn);
		}

		return l_field_value;
	}

	public String sendErrorResponse(String actionKey, String error, String request_ref_no, Map<String, String> params) {
		String l_status = "", l_status_desc = "", l_responseJsonString = "", l_app_msg = "", l_response_str = "";
		Map<String, Object> l_response_json = new HashMap<String, Object>();
		LinkedHashMap<String, String> visit_data = new LinkedHashMap<String, String>();
//		MoheInboundTransaction practoInboundTransaction = new MoheInboundTransaction();
		ObjectMapper objMapper = new ObjectMapper();

		try {
			l_app_msg = " ::: Inside sendErrorResponse ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			visit_data.put("facility_id", "");
			visit_data.put("patient_id", "");
			visit_data.put("encounter_id", "");
			visit_data.put("bill_no", "");
			visit_data.put("receipt_no", "");
			l_status = "0";
			l_status_desc = error;
			l_response_json.put("request_ref_no", request_ref_no);
			l_response_json.put("status", l_status);
			l_response_json.put("status_desc", l_status_desc);
			l_response_json.put("visit_data", visit_data);

			l_responseJsonString = objMapper.writeValueAsString(l_response_json);

			params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
			// params.put("ERR_MSG", error);
			//l_response_str = practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, error);
			l_response_str = MessageLoadMethod(actionKey, params, l_errcd, error);
			l_app_msg = " ::: Message Load Method  ::: " + l_response_str;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

		} catch (Exception e) {

		}

		return l_responseJsonString;

	}

	public static Map<String, String> validateVisitTypeFirstORFollowup(String facility_id, String patient_id,
			String location_code, String visit_date_time) throws SQLException {
		Connection Conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;
		String l_app_msg = "";
		Map<String, String> FirstORFollowupMap = new LinkedHashMap<String, String>();
		String blng_grp_id = "", cust_grp_code = "", cust_code = "", policy_type_code = "", visit_type_ind = "",
				f_episode_id = "";
		String f_visit_type_code = "", f_strDesc = "";
		l_app_msg = " ::: Inside validateVisitTypeFirstORFollowup ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			String validateVisitTypeQuery = "{call bl_interface_proc.proc_first_or_followup_visit(?,?,?,?,to_date('"
					+ visit_date_time + "','DD/MM/YYYY HH24:MI:SS'),'','','','',?,?,?,?,?,?)}";
			Conn = EMDataSource.getConnection();
			cstmt = Conn.prepareCall(validateVisitTypeQuery);

			cstmt.setString(1, facility_id);
			cstmt.setString(2, patient_id);
			cstmt.setString(3, "O");
			cstmt.setString(4, location_code);
			cstmt.registerOutParameter(5, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(8, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(9, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);

			// rs = cstmt.executeQuery();
			cstmt.executeQuery();

			f_episode_id = cstmt.getString(5) == null ? "" : cstmt.getString(5);
			FirstORFollowupMap.put("f_episode_id", f_episode_id);
			visit_type_ind = cstmt.getString(6);
			if (visit_type_ind == null)
				visit_type_ind = "F";
			FirstORFollowupMap.put("f_visit_type_ind", visit_type_ind);
			blng_grp_id = cstmt.getString(7) == null ? "" : cstmt.getString(7);
			FirstORFollowupMap.put("blng_grp_id", blng_grp_id);
			cust_grp_code = cstmt.getString(8) == null ? "" : cstmt.getString(8);
			FirstORFollowupMap.put("cust_grp_code", cust_grp_code);
			cust_code = cstmt.getString(9) == null ? "" : cstmt.getString(9);
			FirstORFollowupMap.put("cust_code", cust_code);
			policy_type_code = cstmt.getString(10) == null ? "" : cstmt.getString(10);
			FirstORFollowupMap.put("policy_type_code", policy_type_code);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: FirstORFollowupMap : " + FirstORFollowupMap.toString());
		} catch (Exception e) {
			l_app_msg = "Error in Validate FirstORFollowupMap 1 Exception - " + e.getMessage();
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
		} finally {
			
			XHUtil.closeDBResources(null, cstmt, null);
			EMDataSource.returnConnection(Conn);
		}

		try {
			String visitTypeQuery = "SELECT visit_type_code,op_get_desc.op_visit_type (facility_id,visit_type_code,'en','2') short_desc FROM op_visit_type_for_clinic WHERE facility_id = '"
					+ facility_id + "' AND clinic_code = '" + location_code
					+ "' AND eff_status = 'E' and visit_type_ind in('" + visit_type_ind + "') order by 2";
			Conn = EMDataSource.getConnection();
			pstmt = Conn.prepareCall(visitTypeQuery);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				f_strDesc = rs.getString("short_desc");
				f_visit_type_code = rs.getString("visit_type_code");
				FirstORFollowupMap.put("f_strDesc", f_strDesc);
				FirstORFollowupMap.put("f_visit_type_code", f_visit_type_code);
			}
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: FirstORFollowupMap After fetching Visit Type : " + FirstORFollowupMap.toString());

		} catch (Exception e) {
			l_app_msg = "Error in Validate FirstORFollowupMap Exception - " + e.getMessage();
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
		} finally {
			EMDataSource.returnConnection(Conn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}

		return FirstORFollowupMap;
	}

	public static Map<String, String> generateEncounterID(String episodeno, String visitnum, String facility_id,
			String added_by_id, String ws_no) throws SQLException {
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;
		String errmsg = "", msgEncounter = "", encounterid = "";
		Map<String, String> returnsData = new HashMap<String, String>();
		if (l_debug_YN.equals("Y"))
			System.out.println(" ::: Inside generateEncounterID ::: ");

		try {
			dbConn = EMDataSource.getConnection();
			cstmt = dbConn.prepareCall("{call PR_GENERATE_ENCOUNTER_ID(?,?,?,?,?,?,?,?,?,?)}");
			
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: PR_GENERATE_ENCOUNTER_ID parameters : episodeno : " + episodeno + " : visitnum : "
					+ visitnum + " : facility_id : " + facility_id + " : added_by_id : " + added_by_id + " : ws_no : "
					+ ws_no);

			cstmt.setString(1, episodeno);
			cstmt.setString(2, visitnum);
			cstmt.setString(3, facility_id);
			cstmt.setString(4, added_by_id);
			cstmt.setString(5, ws_no);
			cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(8, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(9, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);

			cstmt.execute();

			errmsg = cstmt.getString(9);
			returnsData.put("errmsg", errmsg);
			if (errmsg == null)
				errmsg = "";
			msgEncounter = cstmt.getString(10);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: msgEncounter : " + msgEncounter);
			
			returnsData.put("msgEncounter", msgEncounter);
			if (msgEncounter == null)
				msgEncounter = "N";

			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: errmsg : " + errmsg + " ::: msgEncounter : " + msgEncounter + " ::: insertable : "
					+ insertable);

			if (errmsg.equals("")) {
				if (msgEncounter.equals("Y")) {
					insertable = false;
				} else {
					encounterid = cstmt.getString(8);
					returnsData.put("encounterid", encounterid);
					if (encounterid == null)
						encounterid = "";
					episodeno = cstmt.getString(6);
					returnsData.put("episodeno", episodeno);
					if (episodeno == null)
						episodeno = "";
					visitnum = cstmt.getString(7);
					returnsData.put("visitnum", visitnum);
					if (visitnum == null)
						visitnum = "";
					insertable = true;

				}
			} else {
				insertable = false;
			}
			
			if (l_debug_YN.equals("Y"))
				System.out.println(
					" ::: encounterid ::: " + encounterid + " ::: visitnum ::: " + visitnum + " ::: episodeno ::: "
							+ episodeno + " ::: returnsData :::" + returnsData + ":::insertable ::::" + insertable);

		} catch (Exception e) {
			insertable = false;
			System.out.println(":::generate encounter id catch block insertable ::::" + insertable);
			//dbConn.rollback();

			e.printStackTrace();
		} finally {
			
			XHUtil.closeDBResources(null, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		return returnsData;
	}

	public static Map<String, String> fetchClinicDetails(String facility_id, String assign_care_locn_code)
			throws SQLException {
		Connection Conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, String> clinicData = new HashMap<String, String>();
		if (l_debug_YN.equals("Y"))
			System.out.println(" ::: Inside fetchClinicDetails ::: ");
		try {
			String clinic_query = "select clinic_type,speciality_code, dept_code,to_char(sysdate,'dd/mm/yyyy') ct_date,online_mr_notfn_yn,mr_location_code from op_clinic where clinic_code = '"
					+ assign_care_locn_code + "' and facility_id='" + facility_id + "'";
			Conn = EMDataSource.getConnection();

			pstmt = Conn.prepareStatement(clinic_query);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				clinicData.put("assign_care_locn_type", rs.getString(1));
				clinicData.put("speciality_code", rs.getString(2));
				clinicData.put("dept_code", rs.getString(3));
				clinicData.put("ct_date", rs.getString("ct_date"));
				clinicData.put("online_mr_notfn_yn", rs.getString("online_mr_notfn_yn"));
				clinicData.put("mr_location_code", rs.getString("mr_location_code"));

				if (clinicData.get("speciality_code") == null)
					clinicData.put("speciality_code", "");
				if (clinicData.get("dept_code") == null)
					clinicData.put("dept_code", "");
			}
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: clinicData ::: " + clinicData + "::::::insertable:::::" + insertable);

		} catch (Exception e) {
			System.out.println(" Exception in FetchEpisodeNo : " + e.getMessage());
			e.printStackTrace();
		} finally {
			
			XHUtil.closeDBResources(null, pstmt, null);
			EMDataSource.returnConnection(Conn);
		}
		return clinicData;
	}

	public static String FetchStdCntrlSegMethod(String segmentID, String elementId, String standardCode) {

		Connection Conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		l_app_msg = " ::: Inside FetchStdCntrlSegMethod ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: Segment ID ::: " + segmentID + " ::: Element ID ::: " + elementId + " ::: Standard Code ::: "
				+ standardCode;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: Retrieving ::: " + elementId + " ::: Value ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			Conn = EMDataSource.getConnection();
			query = "SELECT NVL(DEFAULT_VALUE,'X') DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG "
					+ " WHERE SEGMENT_ID = ? AND STANDARD_CODE = ? AND ELEMENT_ID = ? ";

			pstmt = Conn.prepareStatement(query);
			pstmt.setString(1, segmentID);
			pstmt.setString(2, standardCode);
			pstmt.setString(3, elementId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				l_field_value = rs.getString("DEFAULT_VALUE");
			}
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Fetch control l_field_value ::: " + l_field_value);

		} catch (Exception e) {
			l_field_value = "Error in " + l_app_msg + " : " + e.getMessage();
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Field Value ::: " + l_field_value);
			e.printStackTrace();
		} finally {			
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(Conn);
		}
		return l_field_value;
	}

	public static Map<String, String> fetchEpisodeIDVisitNum(String facility_id, String patient_id, String episode_id,
			String locantion_code) throws SQLException {
		String l_app_msg = "";
		Connection Conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, String> VisitEpisodeData = new HashMap<String, String>();
		String sql = "";

		l_app_msg = " ::: Inside fetchEpisodeIDVisitNum ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			sql = "select  last_visit_fu_reqd_yn , to_char(last_visit_date,'yyyy-mm-dd') last_visit_date, nvl(last_visit_num,0)+1 last_visit_num from op_episode_for_service where operating_facility_id='"
					+ facility_id + "' and episode_status='01' and patient_id='" + patient_id + "' ";
			if (!episode_id.equals(""))
				sql = sql + " and episode_id='" + episode_id + "'";
			else {
				sql = sql + " and clinic_code='" + locantion_code + "'";
			}
			sql = sql + " order by added_date desc";

			l_app_msg = " ::: fetchEpisodeIDVisitNum Query ::: " + sql.toString();
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			Conn = EMDataSource.getConnection();

			pstmt = Conn.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// VisitEpisodeData.put("episode_id",
				// rs.getString("episode_id"));
				VisitEpisodeData.put("visit_num", rs.getString("last_visit_num"));

			}
			l_app_msg = " ::: fetchEpisodeIDVisitNum ::: " + VisitEpisodeData;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

		} catch (Exception e) {
			System.out.println(" Exception in fetchEpisodeIDVisitNum : " + e.getMessage());
			e.printStackTrace();
		} finally {
			
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(Conn);
			
		}
		return VisitEpisodeData;
	}

	public static String validatePatient(String patient_id) throws SQLException {
		Connection Conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String l_app_msg = "";
		String l_patient_id = "";
		l_app_msg = " ::: Inside searchPatient ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			String validatePatientQuery = " select patient_id, nationality_code from mp_patient where patient_id = ? ";
			Conn = EMDataSource.getConnection();
			pstmt = Conn.prepareStatement(validatePatientQuery);
			pstmt.setString(1, patient_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				l_patient_id = rs.getString(1);
				l_nationality_code = rs.getString(2);
			}
		} catch (Exception e) {
			l_app_msg = "Error in Validate Patient Exception - " + e.getMessage();
			Conn.rollback();
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
		} finally {
			
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(Conn);
		}
		return l_patient_id;
	}

	public static String validateLocnType(String locn_type) throws SQLException {
		Connection Conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String l_app_msg = "";
		String v_locn_type = "";
		l_app_msg = " ::: Inside validateLocnType ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			String validateLocnTypeQuery = "select locn_type,short_desc from am_care_locn_type_lang_vw where care_locn_type_ind in ('C','E') and locn_type in ('C','E') and SYS_USER_DEF_IND='S' and language_id='en' and locn_type = ? order by short_desc ";
			Conn = EMDataSource.getConnection();
			pstmt = Conn.prepareStatement(validateLocnTypeQuery);
			pstmt.setString(1, locn_type);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				v_locn_type = rs.getString(1);
			}
		} catch (Exception e) {
			l_app_msg = "Error in Validate Location Type Exception - " + e.getMessage();
			
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
		} finally {
			
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(Conn);
		}
		return v_locn_type;
	}

	public static String validateLocnCode(String locn_code, String facility_id, String locn_type) throws SQLException {
		Connection Conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String l_app_msg = "";
		String v_locn_code = "";
		l_app_msg = " ::: Inside validateLocnCode ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			String validateLocnCodeQuery = "select clinic_code from op_clinic_lang_vw where clinic_code=? and language_id='en' and facility_id=? and clinic_type = ?";
			Conn = EMDataSource.getConnection();
			pstmt = Conn.prepareStatement(validateLocnCodeQuery);
			pstmt.setString(1, locn_code);
			pstmt.setString(2, facility_id);
			pstmt.setString(3, locn_type);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				v_locn_code = rs.getString(1);
			}
		} catch (Exception e) {
			l_app_msg = "Error in Validate Location Code Exception - " + e.getMessage();
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
		} finally {
			EMDataSource.returnConnection(Conn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		return v_locn_code;
	}

	public static String validateService(String locn_code, String facility_id, String service_code)
			throws SQLException {
		Connection Conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String l_app_msg = "";
		String v_service = "";
		l_app_msg = " ::: Inside validateService ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			String validateServiceQuery = "select service_code from am_service_lang_vw where language_id='en' and eff_status = 'E' and service_code in (select service_code from op_clinic where clinic_code = ? and facility_id= ? union SELECT b.service_code FROM OP_CLINIC_FOR_SERVICE b WHERE b.clinic_code = ? AND b.facility_id= ? and b.care_locn_type_ind = 'C') and service_code = ?";
			Conn = EMDataSource.getConnection();
			pstmt = Conn.prepareStatement(validateServiceQuery);
			pstmt.setString(1, locn_code);
			pstmt.setString(2, facility_id);
			pstmt.setString(3, locn_code);
			pstmt.setString(4, facility_id);
			pstmt.setString(5, service_code);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				v_service = rs.getString(1);
			}
		} catch (Exception e) {
			l_app_msg = "Error in Validate Service Exception - " + e.getMessage();
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
		} finally {

			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(Conn);
		}
		return v_service;
	}

	public static String validatePratitioner(String practitioner_id) throws SQLException {
		Connection Conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String l_app_msg = "";
		String v_practitioner_id = "";
		l_app_msg = " ::: Inside validatePratitioner ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			String validatePractitionerQuery = "select practitioner_id from am_practitioner_lang_vw where practitioner_id = ? and language_id='en'";
			Conn = EMDataSource.getConnection();
			pstmt = Conn.prepareStatement(validatePractitionerQuery);
			pstmt.setString(1, practitioner_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				v_practitioner_id = rs.getString(1);
			}
		} catch (Exception e) {
			l_app_msg = "Error in Validate Practitioner Exception - " + e.getMessage();
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
		} finally {
			
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(Conn);
		}
		return v_practitioner_id;
	}

	public static String validateVisitType(String facility_id, String clinic_code, String care_locn_type_ind,
			String visit_type_code) throws SQLException {
		Connection Conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String l_app_msg = "";
		String v_visit_type = "";
		l_app_msg = " ::: Inside validateVisitType ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			String validateVisitTypeQuery = "SELECT visit_type_code FROM op_visit_type_for_clinic_vw WHERE care_locn_type_ind IN ('C', 'E', 'D') AND facility_id = ? AND clinic_code = ? AND care_locn_type_ind = ? AND  visit_type_code =  ? ORDER BY clinic_code";
			Conn = EMDataSource.getConnection();
			pstmt = Conn.prepareStatement(validateVisitTypeQuery);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, clinic_code);
			pstmt.setString(3, care_locn_type_ind);
			pstmt.setString(4, visit_type_code);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				v_visit_type = rs.getString(1);
			}
		} catch (Exception e) {
			l_app_msg = "Error in Validate Visit Type Exception - " + e.getMessage();
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
		} finally {
			
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(Conn);
		}
		return v_visit_type;
	}

	public static String validateDateTime(String l_appt_date_time) throws SQLException {
		Connection Conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "";
		String l_resp_value = "";

		l_app_msg = " ::: Inside validateDateTime ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: Appointment Date Time ::: " + l_appt_date_time;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			// query = "select 1 from dual where to_date(?, 'DD/MM/YYYY
			// HH24:MI:SS') >= trunc(sysdate)";
			query = "select 1 from dual where trunc(to_date(?, 'DD/MM/YYYY HH24:MI:SS')) <> trunc(sysdate)";
			Conn = EMDataSource.getConnection();

			pstmt = Conn.prepareStatement(query);
			pstmt.setString(1, l_appt_date_time);
			rs = pstmt.executeQuery();

			l_app_msg = " ::: rs ::: " + rs;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			while (rs.next()) {
				l_resp_value = rs.getString(1);
			}

			l_app_msg = " ::: l_resp_value ::: " + l_appt_date_time;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

		} catch (Exception e) {
			l_resp_value = "Error in validateDateTime Exception - " + e.getMessage();
		} finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(Conn);
		}

		return l_resp_value;
	}

	public static boolean validateVisit(String facility_id, String patient_id, String service_code)
			throws SQLException {
		Connection Conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String l_app_msg = "";
		boolean visitExistFlag = false;
		l_app_msg = " ::: Inside validateVisit ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			String validateServiceQuery = "select '1' from op_patient_queue " +
					"where facility_id = ? and patient_id = ? and service_code = ? and queue_status NOT IN ('07','09','99')";
			Conn = EMDataSource.getConnection();
			pstmt = Conn.prepareStatement(validateServiceQuery);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, patient_id);
			pstmt.setString(3, service_code);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				visitExistFlag = true;
			}

			l_app_msg = " ::: visitExistFlag : " + visitExistFlag;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

		} catch (Exception e) {
			l_app_msg = "Error in Validate Visit Exception - " + e.getMessage();
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
		} finally {
			
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(Conn);
		}
		return visitExistFlag;
	}

	private PreparedStatement setData(PreparedStatement stmt, Object[] obj) {
		try {
			for (int i = 0; i < obj.length; i++) {
				if (obj[i] instanceof java.sql.Date) {

					if (obj[i] instanceof java.sql.Date)
						stmt.setDate((i + 1), (java.sql.Date) obj[i]);
				}

				if (obj[i] instanceof String) {
					if (((String) obj[i]).equalsIgnoreCase("null"))
						stmt.setString((i + 1), null);
					else if ((String) obj[i] == null)
						stmt.setString((i + 1), null);
					else
						stmt.setString((i + 1), (String) obj[i]);
				}

				if (obj[i] instanceof Integer) {
					stmt.setInt((i + 1), (((Integer) obj[i]).intValue()));
				}

				if (obj[i] instanceof Long) {
					stmt.setLong((i + 1), (((Long) obj[i]).longValue()));
				}

				if (obj[i] instanceof Double) {
					stmt.setDouble((i + 1), (((Double) obj[i]).doubleValue()));
				}

				if (obj[i] instanceof Float) {
					stmt.setFloat((i + 1), (((Float) obj[i]).floatValue()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (stmt);
	}
	public String updateInboundMessageTable(String actionKey, Map<String, String> params, String l_errcd, String episode_id, String visit_id ) {
		Connection Conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String updateStmt = "", l_app_msg = "";
		Conn = null;
		pstmt = null;
		int updateCount = 0;
		try {
			Conn = EMDataSource.getConnection();
			updateStmt = " UPDATE xh_inbound_message " + " SET	ERR_MSG = ?, MESSAGE_ACK_TEXT        = ?, "
					+ " MESSAGE_STATUS    = ?, " + " EPISODE_ID            = ?, " + " VISIT_ID        = ? "
					+ " WHERE MESSAGE_ID          = ? " + " AND APPLICATION_ID = ? ";

			pstmt = Conn.prepareStatement(updateStmt);
			pstmt.setString(1, params.get("ERR_MSG")); // MESSAGE_ACK_TEXT
			pstmt.setString(2, params.get("MESSAGE_ACK_TEXT")); // MESSAGE_ACK_TEXT
			pstmt.setString(3, l_errcd);
			pstmt.setInt(4, Integer.parseInt(episode_id));
			pstmt.setInt(5, Integer.parseInt(visit_id));
			pstmt.setString(6, params.get("MESSAGE_ID"));
			pstmt.setString(7, params.get("APPLICATION_ID"));
			
			
			updateCount = pstmt.executeUpdate();

			l_app_msg = " ::: UpdateCount : " + updateCount;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (updateCount == 1) {
				Conn.commit();
			} else {
				Conn.rollback();
				l_errcd = "E";
				l_errmsg = " Error in updating Audit Table Data Records ";
			}

		} catch (Exception e) {
			l_errcd = "E";
			l_errmsg = "Error in " + l_app_msg + " : " + e.getMessage();
		} finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(Conn);

		}
		return l_errcd;

	}
	
}
