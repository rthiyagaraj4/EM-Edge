package eXH.EM;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import eXH.util.EMDataSource;
import eXH.util.XHDBAdapter;
import eXH.util.XHJSONUtil;
import eXH.util.XHUtil;

public class EMPaymentTransaction {

	// class variables

	public static String l_debug_YN = "N";
	public static String l_standard_code = "";
	public static String l_segment_id = "";

	public String l_errcd = "S", l_field_separator = "$!^";
	public String l_errmsg = "";
	public String l_ack_text = "";
	public String l_update_response_str = "";

	public static String l_conn_msg = "Error - Unable to connect to the Data base, Kindly contact the System Administrator";

	public String processInboundPaymentRequest(String actionKey, String eventType, String key) {
		String l_app_msg = "", l_errmsg = "";
		String l_message_id = "", l_patient_gender = "", l_patient_name = "", l_element_id = "", l_facility_id = "",
				l_date_of_birth = "", l_application_id = "", l_protocol_link_id = "";
		String l_in_JSON = "", l_err_msg = "";

		String l_NetAmountDebit = "", l_ProductTransactionId = "", l_bankrefNo = "", l_patient_id = "",
				l_appointment_id = "", l_appt_remarks_data = "";

		String l_response_str = "", l_response_err_json = "", l_tranasction_date = "", l_response_str_receipt = "";
		String l_Nature_of_receipt = "", l_trx_type = "", l_practo_doc_type = "", l_vendor_type = "",
				l_UPDATE_PAYMENT_INFO = "";
		Map<String, String> params = new HashMap<String, String>();

		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "", l_debug_yn = "";

		List<Map<String, String>> fetchedPatientDets = null;
		Map<String, String> patDetMap = new HashMap<String, String>();

		ArrayList<String> l_protocol_details = null;

		ArrayList<String> l_segment_details = null;

		String l_enc_appt_id = "", l_episode_type = "", l_stlmnt_type_code = "", l_pay_remarks = "", l_bank_code = "",
				l_user_id = "", l_lang_id = "", l_added_at_ws_no = "", l_message_text = "";
		
		String l_card_category = "", l_card_no = "", l_gateway_trans_id = "", l_payment_mode = "", l_payment_status ="";
		
		String l_receipt_doc_type_code = "", l_receipt_doc_number ="", l_receipt_doc_date = "", l_transaction_status = "";
		
		String l_added_by_id = "";
			
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

			l_app_msg = " ************ Appointment Payment Transaction request started ************ ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = "Action Key:::" + actionKey;
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
					l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_errmsg + " \"  "
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

			l_message_id = GenerateMessageIDMethod("XH_IB_MESSAGE_ID_SEQ", dbConn);

			if (l_message_id.indexOf("Error") >= 0) {
				l_errmsg = "Message ID Generation - " + l_message_id;
				l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_errmsg + " \"  "
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

			if (l_errcd.equals("S")) {
				l_app_msg = "::: Parsing input message ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_in_JSON = XHJSONUtil.createJsonObject(actionKey);

				if (l_in_JSON.indexOf("Error") >= 0) {
					l_errcd = "E";
					l_err_msg = l_in_JSON;

					l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_err_msg + " \"  "
							+ " } ";

					l_app_msg = " ::: Inserting Request into Message Table Error in Parsing Request :::" + actionKey;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());

					l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_err_msg, dbConn);
					l_app_msg = l_app_msg + " : " + l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					return "200#" + l_response_err_json + "#";

				}
			}

			if (l_errcd.equals("S")) {
				l_app_msg = "::: Getting Patient Id from JSON ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				if(l_in_JSON.contains("patient_registration_number")){
					//l_patient_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "patient_registration_number");	
					l_patient_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","patient_registration_number");	
				}				
				else if(l_in_JSON.contains("patient_id")){
					//l_patient_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "patient_id");
					l_patient_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","patient_id");
				}
				
				l_app_msg = " Patient ID : " + l_patient_id;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("PATIENT_ID", l_patient_id);

			}

			// Getting from JSON Object
			if (l_errcd.equals("S")) {
				l_app_msg = "::: Getting Facility Id from JSON ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				//l_facility_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "facility_id");
				l_facility_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","facility_id");
				

				l_app_msg = " Facility ID : " + l_facility_id;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("FACILITY_ID", l_facility_id);
			}

			if (l_errcd.equals("S")) {
				l_app_msg = "::: Getting Patient Gender from JSON ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				//l_patient_gender = XHJSONUtil.getJsonRequestString(l_in_JSON, "patient_gender");// patient_gender
				l_patient_gender = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","patient_gender");

				l_app_msg = " Patient Gender : " + l_patient_gender;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("GENDER", l_patient_gender);
			}

			if (l_errcd.equals("S")) {
				l_app_msg = "::: Getting Patient Name from JSON ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				//l_patient_name = XHJSONUtil.getJsonRequestString(l_in_JSON, "patient_name");
				l_patient_name = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","patient_name");

				l_app_msg = " Patient Name : " + l_patient_name;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("PATIENT_NAME", l_patient_name);
			}

			if (l_errcd.equals("S")) {
				l_app_msg = "::: Getting Date of Birth from JSON ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				//l_date_of_birth = XHJSONUtil.getJsonRequestString(l_in_JSON, "patient_dob");
				l_date_of_birth = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","patient_dob");

				l_app_msg = " Date of Birth : " + l_date_of_birth;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				if (!(l_date_of_birth.length() > 0)) {
					if (l_patient_id.length() > 0) {
						l_app_msg = " Fetching Date of Birth details from Master patient: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);

						fetchedPatientDets = FetchPatDetailsByUHID(l_patient_id, dbConn);

						if (!(fetchedPatientDets.isEmpty())) {
							patDetMap = (HashMap<String, String>) fetchedPatientDets.get(0);

							if (patDetMap.size() > 0) {
								l_patient_gender = patDetMap.get("patient_gender");
								l_date_of_birth = patDetMap.get("patient_dob");

							}

							l_app_msg = " Date of Birth details from Master patient: " + l_date_of_birth
									+ " :: Gender :: " + l_patient_gender;
							if (l_debug_YN.equals("Y"))
								System.out.println(l_app_msg);
						}
					}
				}
				params.put("GENDER", l_patient_gender);
				params.put("DATE_OF_BIRTH", l_date_of_birth);
			}

			if ((l_patient_name.indexOf("Error") >= 0) || (l_patient_gender.length() > 1)
					|| (l_date_of_birth.indexOf("Error") >= 0) || (l_facility_id.length() > 2)) {
				l_errcd = "E";
				l_errmsg = "Error in Request Parameters,Please Check Request Patient Name - " + l_patient_name
						+ ", Patient Gender - " + l_patient_gender + ", Date of Birth - " + l_date_of_birth
						+ ", Facility ID - " + l_facility_id;
				l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_errmsg + " \"  "
						+ " } ";

				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());

				l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_errmsg, dbConn);
				l_app_msg = l_app_msg + " : " + l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				return "200#" + l_response_err_json + "#";
			}

			

			if (l_errcd.equals("S")) {
				l_app_msg = "::: Getting appointment ID from JSON ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				//l_appointment_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "appointment_id");
				l_appointment_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","original_appointment_id");

				l_app_msg = " appointment id : " + l_appointment_id;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("APPOINTMENT_ID", l_appointment_id);

			}
			
			if (l_errcd.equals("S")) {
				l_app_msg = "::: Getting Net Amount Debit from JSON ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				//l_NetAmountDebit = XHJSONUtil.getJsonRequestString(l_in_JSON, "net_amount_debit");
				l_NetAmountDebit = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","net_amount_debit");

				l_app_msg = " Net Amount Debit : " + l_NetAmountDebit;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("NET_AMOUNT_DEBIT", l_NetAmountDebit);
			}
			
			if (l_errcd.equals("S")) {
				l_app_msg = "::: Getting Payment Status from JSON ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				//l_payment_status = XHJSONUtil.getJsonRequestString(l_in_JSON, "payment_status");
				l_payment_status = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","payment_status");
				
				if (l_payment_status.indexOf("Error") >= 0)
					l_payment_status = "";

				l_app_msg = " Payment Status : " + l_payment_status;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("PAYMENT_STATUS", l_payment_status);
			}
			
			if (l_errcd.equals("S")) {
				l_app_msg = "::: Getting Transaction Date from JSON ::: ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				//l_tranasction_date = XHJSONUtil.getJsonRequestString(l_in_JSON, "transaction_date");
				l_tranasction_date = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","transaction_date");
				
				if (l_tranasction_date.indexOf("Error") >= 0)
					l_tranasction_date = "";

				l_app_msg = " Transaction Date : " + l_tranasction_date;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				params.put("TRANSACTION_DATE", l_tranasction_date);
				
			}
			
			if (l_errcd.equals("S")) {
				l_app_msg = "::: Getting Gateway Transaction Id from JSON ::: ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				//l_gateway_trans_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "gateway_trans_id");
				l_gateway_trans_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","gateway_trans_id");
				if (l_gateway_trans_id.indexOf("Error") >= 0)
					l_gateway_trans_id = "";

				l_app_msg = " Gateway Transaction ID : " + l_gateway_trans_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				params.put("GATEWAY_TRANSACTION_ID", l_gateway_trans_id);
			}
			
			if (l_errcd.equals("S")) {
				l_app_msg = "::: Getting Bank Reference No from JSON ::: ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				//l_bankrefNo = XHJSONUtil.getJsonRequestString(l_in_JSON, "bank_ref_no");
				l_bankrefNo = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","bank_ref_no");
				if (l_bankrefNo.indexOf("Error") >= 0)
					l_bankrefNo = "";

				l_app_msg = " Bank Ref No : " + l_bankrefNo;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				params.put("BANK_REF_NO", l_bankrefNo);
			}
			
			if (l_errcd.equals("S")) {
				l_app_msg = "::: Getting Payment Mode from JSON ::: ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				//l_payment_mode = XHJSONUtil.getJsonRequestString(l_in_JSON, "payment_mode");
				l_payment_mode = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","payment_mode");
				if (l_payment_mode.indexOf("Error") >= 0)
					l_payment_mode = "";

				l_app_msg = " Payment Mode : " + l_payment_mode;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				params.put("PAYMENT_MODE", l_payment_mode);
			}		
			
			if (l_errcd.equals("S")) {
				l_app_msg = "::: Getting card Category from JSON ::: ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				//l_card_category = XHJSONUtil.getJsonRequestString(l_in_JSON, "card_category");
				l_card_category = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","card_category");
				if (l_card_category.indexOf("Error") >= 0)
					l_card_category = "";

				l_app_msg = " Card category : " + l_card_category;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				params.put("CARD_CATEGORY", l_card_category);
			}		
			
			if (l_errcd.equals("S")) {
				l_app_msg = "::: Getting Card Number from JSON ::: ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				//l_card_no = XHJSONUtil.getJsonRequestString(l_in_JSON, "card_number");
				l_card_no = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","card_number");
				if (l_card_no.indexOf("Error") >= 0)
					l_card_no = "";

				l_app_msg = " Card Number : " + l_card_no;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				params.put("CARD_NUMBER", l_card_no);
			}		
			
			if (l_errcd.equals("S")) {
				l_app_msg = "::: Getting Bank Code from JSON ::: ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				//l_bank_code = XHJSONUtil.getJsonRequestString(l_in_JSON, "bank_code");
				l_bank_code = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","bank_code");
				if (l_bank_code.indexOf("Error") >= 0)
					l_bank_code = "";

				l_app_msg = " Bank Code : " + l_bank_code;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				params.put("BANK_CODE", l_bank_code);
			}			
			
			if (l_errcd.equals("S")) {
				l_app_msg = "::: Getting Product Transaction Id from JSON ::: ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				//l_ProductTransactionId = XHJSONUtil.getJsonRequestString(l_in_JSON, "product_transaction_id");
				l_ProductTransactionId = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "request_data","product_transaction_id");
				
				if (l_ProductTransactionId.indexOf("Error") >= 0)
					l_ProductTransactionId = "";
				
				if (!(l_ProductTransactionId.length()>0)) 
					l_ProductTransactionId = l_gateway_trans_id.substring(1, 8);

				l_app_msg = " Product Transaction ID : " + l_ProductTransactionId;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				params.put("PRODUCT_TRANSACTION_ID", l_ProductTransactionId);
			}

			l_app_msg = " Request Error checking : ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if ((l_NetAmountDebit.length() <= 0 && l_NetAmountDebit.indexOf("Error") >= 0)
					|| (l_ProductTransactionId.indexOf("Error") >= 0)
					|| (l_bankrefNo.length() <= 0 && l_bankrefNo.indexOf("Error") >= 0)
					|| (l_tranasction_date.indexOf("Error") >= 0)
					|| (l_gateway_trans_id.indexOf("Error") >= 0)) {
				l_errcd = "E";
				l_errmsg = "Error in Request Parameters, Please Check Request Patient Name - " + l_patient_name
						+ ", Net Amount - " + l_NetAmountDebit + ", Product Transaction ID - " + l_ProductTransactionId
						+ ", Bank Refenece No - " + l_bankrefNo + ", Transaction Date - " + l_tranasction_date
						+", Gateway Transaction Date - " + l_gateway_trans_id;
				l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_errmsg + " \"  "
						+ " } ";

				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());

				l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_errmsg, dbConn);
				l_app_msg = l_app_msg + " : " + l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				return "200#" + l_response_err_json + "#";
			}
			
			l_element_id = "APPL_USER_ID";
			l_added_by_id = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: APPL User Id ::: "+ l_added_by_id);
			
			params.put("ADDED_BY_ID", l_added_by_id);


			if (l_errcd.equals("S")) {
				l_app_msg = " Retrieving Vendor Type...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_element_id = "VENDOR_TYPE";

				l_vendor_type = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);

				if (l_vendor_type.indexOf("Error") >= 0) {
					l_errcd = "E";
					l_errmsg = "Error in Vendet Type - " + l_vendor_type;
					l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_errmsg + " \"  "
							+ " } ";

					params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());

					l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_errmsg, dbConn);
					l_app_msg = l_app_msg + " : " + l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					return "200#" + l_response_err_json + "#";
				}
				l_app_msg = " Vender Type : " + l_vendor_type;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("VENDOR_TYPE", l_vendor_type);
			}

			if (l_errcd.equals("S")) {
				l_app_msg = " Retrieving Practo Doc Type...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_element_id = "DOC_TYPE_CODE";

				l_practo_doc_type = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);

				if (l_practo_doc_type.indexOf("Error") >= 0) {
					l_errcd = "E";
					l_errmsg = "Error in Practo Doc Type - " + l_practo_doc_type;
					l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_errmsg + " \"  "
							+ " } ";

					params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());

					l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_errmsg, dbConn);
					l_app_msg = l_app_msg + " : " + l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					return "200#" + l_response_err_json + "#";
				}
				l_app_msg = " Practo Doc Type : " + l_practo_doc_type;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("PRACTO_DOC_TYPE_CODE", l_practo_doc_type);
			}

			if (l_errcd.equals("S")) {

				l_app_msg = " Retrieving Receipt Nature...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_element_id = "RECPT_NATURE_CODE";

				l_Nature_of_receipt = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);

				if (l_Nature_of_receipt.indexOf("Error") >= 0) {
					l_errcd = "E";
					l_errmsg = "Error in Receipt Nature - " + l_Nature_of_receipt;
					l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_errmsg + " \"  "
							+ " } ";

					params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());

					l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_errmsg, dbConn);
					l_app_msg = l_app_msg + " : " + l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					return "200#" + l_response_err_json + "#";
				}
				l_app_msg = " Recpt Nature : " + l_Nature_of_receipt;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("RECPT_NATURE_CODE", l_Nature_of_receipt);
			}

			if (l_errcd.equals("S")) {
				l_app_msg = " Retrieving Transaction Type...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_element_id = "TRX_TYPE_CODE";

				l_trx_type = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);

				if (l_trx_type.indexOf("Error") >= 0) {
					l_errcd = "E";
					l_errmsg = "Error in Transaction Type - " + l_trx_type;
					l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_errmsg + " \"  "
							+ " } ";

					params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());

					l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_errmsg, dbConn);
					l_app_msg = l_app_msg + " : " + l_response_str;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					return "200#" + l_response_err_json + "#";
				}
				l_app_msg = " Transaction Type : " + l_trx_type;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("TRX_TYPE_CODE", l_trx_type);
			}

			if (l_errcd.equals("E")) {
				l_app_msg = "::: Loading the message when : " + l_err_msg;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());

				l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json, dbConn);
				l_app_msg = l_app_msg + " : " + l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				return "401#" + l_response_err_json + "#";
			}

			if (l_errcd.equals("S")) {

				l_app_msg = "::: Getting appointment remarks data ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				l_appt_remarks_data = l_NetAmountDebit + "\t" + l_ProductTransactionId + "\t" + l_bankrefNo + "\t"
						+ l_tranasction_date;
				l_app_msg = " l_appt_remarks_data : " + l_appt_remarks_data;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				params.put("APPOINTMENT_REMARKS_DATA", l_appt_remarks_data);

			}

			l_app_msg = " Retrieving Payment Information...";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_element_id = "UPDATE_PAYMENT_INFO";

			l_UPDATE_PAYMENT_INFO = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);

			if (l_UPDATE_PAYMENT_INFO.indexOf("Error") >= 0) {
				l_errcd = "E";
				l_errmsg = "Error in Retrieving Vendor Type - " + l_UPDATE_PAYMENT_INFO;
				l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \" " + l_errmsg + " \"  "
						+ " } ";

				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());

				l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_errmsg, dbConn);
				l_app_msg = l_app_msg + " : " + l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				return "200#" + l_response_err_json + "#";
			}
			l_app_msg = " l_UPDATE_PAYMENT_INFO : " + l_UPDATE_PAYMENT_INFO;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			params.put("UPDATE_PAYMENT_INFO", l_UPDATE_PAYMENT_INFO);

			if (l_errcd.equals("S")) {
				l_app_msg = " Retrieving Episode Type...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_element_id = "EPISODE_TYPE";

				l_episode_type = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);

				l_app_msg = " Episode Type : " + l_episode_type;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_app_msg = "::: Getting Payment remarks from JSON ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_pay_remarks = XHJSONUtil.getJsonRequestString(l_in_JSON, "remarks");
				l_app_msg = " l_pay_remarks : " + l_pay_remarks;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_app_msg = " Retrieving Settlement Type...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_element_id = "SLMT_TYPE_CODE";

				l_stlmnt_type_code = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);

				l_app_msg = " Settlement Type : " + l_stlmnt_type_code;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("SETTLEMENT_TYPE_CODE", l_stlmnt_type_code);

				l_app_msg = " ::: Fetching User Id ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_element_id = "BL_USER_ID";

				l_user_id = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: User Id ::: " + l_user_id);

				l_app_msg = " ::: Fetching Language Id ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_element_id = "LANG_ID";

				l_lang_id = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: Lang Id ::: " + l_lang_id);

				l_app_msg = " ::: Fetching Work Station number ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				l_element_id = "BL_WS_NO";

				l_added_at_ws_no = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code, dbConn);
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: Work Station number ::: " + l_added_at_ws_no);

			}
			
			if (l_errcd.equals("S")) {
				
				l_app_msg = " ::: Inside deposit procedure ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				CallableStatement cs = null;
				//Connection con = null;
				
				try {

					//con = EMDataSource.getConnection();

					query = "SELECT APPT_REF_NO from OA_APPT where FACILITY_ID =? and EXT_APPT_REF_NO = ? ";

					pstmt = dbConn.prepareStatement(query);
					pstmt.setString(1, l_facility_id);
					pstmt.setString(2, l_appointment_id);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						l_enc_appt_id = rs.getString("APPT_REF_NO");
					}

					l_app_msg = " l_enc_appt_id ::: " + l_enc_appt_id;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
					
					l_app_msg = " XB_API_RECEIPT_REFUND.pat_enc_appt_id_ext_dep_gen('"+l_enc_appt_id+"','"+l_facility_id+"','"+l_patient_id+"'," +
							"'"+l_Nature_of_receipt+"','"+l_practo_doc_type+"','"+l_episode_type+"','"+l_pay_remarks+"','"+l_NetAmountDebit+"'," +
							"'"+l_stlmnt_type_code+"','"+l_card_no+"','TO_DATE('"+l_tranasction_date+"','DD/MM/YYYY HH24:MI:SS'),'"+l_bank_code+"'," +
							"'N','"+l_bank_code+"','"+l_bankrefNo+"','"+l_gateway_trans_id+"','"+l_ProductTransactionId+"'," +
							"'','"+l_user_id+"','"+l_lang_id+"','"+l_added_at_ws_no+"','"+l_receipt_doc_type_code+"'," +
							"'"+l_receipt_doc_number+"','"+l_receipt_doc_date+"','"+l_message_text+"','"+l_transaction_status+"')";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					cs = dbConn.prepareCall(
							"{call XB_API_RECEIPT_REFUND.pat_enc_appt_id_ext_dep_gen(?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");

					cs.setString(1, l_enc_appt_id);
					cs.setString(2, l_facility_id);
					cs.setString(3, l_patient_id);
					cs.setString(4, l_Nature_of_receipt);
					cs.setString(5, l_practo_doc_type);
					cs.setString(6, l_episode_type);
					cs.setString(7, l_pay_remarks);
					cs.setString(8, l_NetAmountDebit);
					cs.setString(9, l_stlmnt_type_code);
					cs.setString(10, l_card_no);
					cs.setString(11, l_tranasction_date);
					cs.setString(12, l_bank_code);
					cs.setString(13, "N");
					cs.setString(14, l_bank_code);
					cs.setString(15, l_bankrefNo);
					cs.setString(16, l_gateway_trans_id);
					cs.setString(17, l_ProductTransactionId);
					cs.setString(18, "");
					cs.setString(19, l_user_id);
					cs.setString(20, l_lang_id);
					cs.setString(21, l_added_at_ws_no);
					cs.registerOutParameter(22, Types.VARCHAR);
					cs.registerOutParameter(23, Types.VARCHAR);
					cs.registerOutParameter(24, Types.DATE);
					cs.registerOutParameter(25, Types.VARCHAR);
					cs.registerOutParameter(26, Types.VARCHAR);

					cs.execute();
					l_receipt_doc_type_code = cs.getString(22);
					l_receipt_doc_number = cs.getString(23);
					l_receipt_doc_date = cs.getString(24);
					l_message_text = cs.getString(25);
					l_transaction_status = cs.getString(26);
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Receipt Doc Type Code... " + l_receipt_doc_type_code+
								" ::: Receipt Doc Number... " + l_receipt_doc_number+" ::: Receipt Doc Date... " + l_receipt_doc_date+
								" ::: Message Text... " + l_message_text+" ::: Transaction status... " + l_transaction_status);
					
					if ("S".equalsIgnoreCase(l_transaction_status))
						dbConn.commit();
					else
						dbConn.rollback();
					
					
				}

				catch (Exception e) {
					dbConn.rollback();
					l_errcd = "E";
					l_errmsg = "Exception in " + l_app_msg + " - " + e.getMessage();

					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Status Desc ::: " + l_errmsg);

					e.printStackTrace();
				}
				finally {
					//EMDataSource.returnConnection(con);
					XHUtil.closeDBResources(null, cs, null);
				}
				

			}

			if (l_UPDATE_PAYMENT_INFO.equals("B")) {

				if (l_errcd.equals("S")) {

					l_app_msg = "::: On successful transaction the message is loaded WP Receipt ::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					l_response_str = insertWPReceiptMessageDetails(params, l_errcd, "", dbConn);

					l_app_msg = " ************ Appointment Payment Transaction request Ended ************ ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					l_response_err_json = " { " + " \"status\":1, " + " \"message\" : \" " + l_response_str
							+ " \"  " + " } ";

					return "200#" + l_response_err_json + "#";
				}

			}

			else {

				if (l_errcd.equals("S")) {

					l_app_msg = "::: On successful transaction the message is loaded Appointment Remarks in OA Appointment ::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					l_response_str = UpadteApptRemarksMessageDetails(params, l_errcd, "", dbConn);
					l_response_str_receipt = insertWPReceiptMessageDetails(params, l_errcd, "", dbConn);

					l_app_msg = " ***l_response_str_receipt*** " + l_response_str_receipt;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					l_app_msg = " ************ Appointment Payment Transaction request Ended ************ ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					l_response_err_json = " { " + " \"status\":1, " + " \"message\" : \" " + l_response_str
							+ " \"  " + " } ";

					return "200#" + l_response_err_json + "#";
				}

			}

			
		} catch (Exception e) {
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^ Exception Occurred " + e.getMessage();
			l_response_err_json = " { " + " \"status\":0, " + " \"message\" : \"Reference Number :"
					+ l_message_id + " Exception : " + e.getMessage() + " \"  " + " } ";

			l_app_msg = "::: On Exception the message is loaded ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());

			l_response_str = MessageLoadMethod(actionKey, params, l_errcd, l_errmsg, dbConn);
			l_app_msg = l_app_msg + " : " + l_response_str;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = " ************ Appointment Payment Transaction request Ended ************ ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			return "200#" + l_response_err_json + "#";
		}
		finally {
			EMDataSource.returnConnection(dbConn);
		}

		return "200#" + l_response_str + "#";
	}

	public String MessageLoadMethod(String message, Map<String, String> param, String status, String err_message, Connection dbConn) {

		String l_app_msg = "";
		String l_request_date = "", l_status_return = "";
		String l_added_by_id = "";

		try {
			
			
			l_app_msg = " ::: Inside Message Loading ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = " ::: Message Status ::: " + status;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			Map<String, String> params = new HashMap<String, String>();

			params.put("APPLICATION_ID", param.get("APPLICATION_ID"));
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

			params.put("ADDED_BY_ID", l_added_by_id);
			params.put("ADDED_BY_DATE", l_request_date);
			params.put("CLIENT_MACHINE", "INTERFACE");
			params.put("ADDED_BY_FACILITY", param.get("FACILITY_ID"));

			params.put("MODIFIED_BY_ID", l_added_by_id);
			params.put("MODIFIED_BY_DATE", l_request_date);
			params.put("CLIENT_MACHINE", "INTERFACE");
			params.put("MODIFIED_BY_FACILITY", param.get("FACILITY_ID"));

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

	public static String FetchResponseWaitTime(String pluginType, Connection dbConn) {

		//Connection dbConn = null;
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
			//dbConn = EMDataSource.getConnection();
			query = "SELECT NVL(COMM_PROCESS_IDLE_TIME, 0) COMM_PROCESS_IDLE_TIME,NVL(SLEEPINTERVAL, 0) SLEEPINTERVAL FROM XH_INTERACTIVE_CONNECT_PARAM "
					+ " WHERE PLUGIN_TYPE = ? ";

			pstmt = dbConn.prepareStatement(query);
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
			XHUtil.closeDBResources(rs, pstmt, null);
			//EMDataSource.returnConnection(dbConn);
		}

		return l_field_value;
	}
	
	/*

	public String insertWPReceiptMessageDetails(Map<String, String> params, String status, String err_message) {
		String insertstmt = "INSERT INTO XH_WP_RECEIPT (OPERATING_FACILITY_ID, VENDOR_TYPE, PATIENT_ID, SHORT_NAME, DATE_OF_BIRTH, GENDER,  PRACTO_DOC_TYPE_CODE,"
				+ " PRACTO_DOC_NUMBER, PRACTO_DOC_DATE, RECPT_NATURE_CODE, TRX_TYPE_CODE,  DOC_AMT, SLMT_DOC_REF_DESC, SLMT_DOC_REF_DATE, SLMT_DOC_REMARKS, ERROR_TEXT,"
				+ " RECEIPT_REMARKS, EM_DOC_TYPE_CODE, EM_DOC_NUMBER,  EM_DOC_DATE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE,"
				+ " MODIFIED_AT_WS_NO,  STATUS, PROCESS_FLAG, PRACTO_TRANS_ID,EXT_APPT_REF_NO,INTERFACE_FLAG)  VALUES ( ?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		Connection dbConn = null;
		PreparedStatement pstmt = null;

		int insertCount = 0;

		String l_app_msg = "", l_date;

		String l_err_msg = "Success";

		try {

			l_app_msg = " ::: Inside WP Receipt Details ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			dbConn = EMDataSource.getConnection();

			if (dbConn == null) {
				return l_conn_msg;
			}

			pstmt = dbConn.prepareStatement(insertstmt);

			l_date = params.get("TRANSACTION_DATE");

			l_app_msg = " ::: Requested Date : " + l_date;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			pstmt.setString(1, params.get("FACILITY_ID"));
			pstmt.setString(2, params.get("VENDOR_TYPE"));// VENDOR_TYPE
			pstmt.setString(3, params.get("PATIENT_ID"));
			pstmt.setString(4, params.get("PATIENT_NAME"));
			// pstmt.setTimestamp(5, new java.sql.Timestamp(l_dob.getTime()));
			pstmt.setString(5, params.get("DATE_OF_BIRTH"));
			pstmt.setString(6, params.get("GENDER"));
			pstmt.setString(7, params.get("PRACTO_DOC_TYPE_CODE"));
			pstmt.setString(8, params.get("BANK_REF_NO"));

			pstmt.setString(9, params.get("TRANSACTION_DATE"));
			pstmt.setString(10, params.get("RECPT_NATURE_CODE"));
			pstmt.setString(11, params.get("TRX_TYPE_CODE"));
			pstmt.setString(12, params.get("NET_AMOUNT_DEBIT"));
			pstmt.setString(13, params.get("PRODUCT_TRANSACTION_ID"));
			pstmt.setString(14, params.get("TRANSACTION_DATE"));
			pstmt.setString(15, XHDBAdapter.isNullReplace(params.get("SLMT_DOC_REMARKS"), ""));// SLMT_DOC_REMARKS
			pstmt.setString(16, err_message);
			pstmt.setString(17, XHDBAdapter.isNullReplace(params.get("SLMT_DOC_REMARKS"), ""));// RECEIPT_REMARKS

			pstmt.setString(18, params.get("EM_DOC_TYPE_CODE"));
			pstmt.setString(19, params.get("EM_DOC_NUMBER"));
			pstmt.setString(20, XHDBAdapter.isNullReplace(params.get("EM_DOC_DATE"), ""));

			pstmt.setString(21, "HS");
			pstmt.setTimestamp(22, new java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(23, System.getenv("computername"));
			pstmt.setString(24, "HS");
			pstmt.setTimestamp(25, new java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(26, System.getenv("computername"));
			pstmt.setString(27, status);
			pstmt.setString(28, params.get("PROCESS_FLAG"));
			pstmt.setString(29, params.get("PRODUCT_TRANSACTION_ID"));
			pstmt.setString(30, params.get("APPOINTMENT_ID"));
			pstmt.setString(31, "Y");

			insertCount = pstmt.executeUpdate();

			l_app_msg = " :::  Appointment Payment Transaction Insert Count : " + insertCount;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (insertCount == 1) {

				l_err_msg = "Appointment Payment Transaction Successfull";

				dbConn.commit();
			} else {
				l_err_msg = "Error in Appointment Payment Transaction Details";
				dbConn.rollback();
			}

			if (l_debug_YN.equals("Y"))
				System.out.println(l_err_msg);

			return l_err_msg;

		} catch (Exception exp) {
			l_errcd = "E";
			exp.printStackTrace();
			l_err_msg = "Error in " + exp.getMessage();

			if (l_debug_YN.equals("Y"))
				System.out.println(l_err_msg);

			return l_err_msg;
		} finally {
			XHUtil.closeDBResources(null, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
	}
	*/
	
	public String insertWPReceiptMessageDetails(Map<String, String> params, String status, String err_message, Connection dbConn) {
		String insertstmt = "INSERT INTO XH_WP_RECEIPT (OPERATING_FACILITY_ID, VENDOR_TYPE, PATIENT_ID, SHORT_NAME, DATE_OF_BIRTH, GENDER,  PRACTO_DOC_TYPE_CODE,"
				+ " PRACTO_DOC_NUMBER, PRACTO_DOC_DATE, RECPT_NATURE_CODE, TRX_TYPE_CODE,  DOC_AMT, SLMT_DOC_REF_DESC, SLMT_DOC_REF_DATE, SLMT_DOC_REMARKS, ERROR_TEXT,"
				+ " RECEIPT_REMARKS, EM_DOC_TYPE_CODE, EM_DOC_NUMBER,  EM_DOC_DATE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE,"
				+ " MODIFIED_AT_WS_NO,  STATUS, PROCESS_FLAG, PRACTO_TRANS_ID, EXT_APPT_REF_NO, INTERFACE_FLAG)  " +
				" VALUES ( ?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'),?,?," +
				"?,TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'),?,?," +
				"?,?,?,?,?,?,?,?,?," +
				"?,?,?,?,?,?)";

		//Connection dbConn = null;
		PreparedStatement pstmt = null;

		int insertCount = 0;

		String l_app_msg = "", l_date;

		String l_err_msg = "Success";

		try {

			l_app_msg = " ::: Inside WP Receipt Details ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			//dbConn = EMDataSource.getConnection();

			if (dbConn == null) {
				return l_conn_msg;
			}

			pstmt = dbConn.prepareStatement(insertstmt);

			l_date = params.get("TRANSACTION_DATE");

			l_app_msg = " ::: Requested Date : " + l_date;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			pstmt.setString(1, params.get("FACILITY_ID"));
			pstmt.setString(2, params.get("VENDOR_TYPE"));// VENDOR_TYPE
			pstmt.setString(3, params.get("PATIENT_ID"));
			pstmt.setString(4, params.get("PATIENT_NAME"));
			// pstmt.setTimestamp(5, new java.sql.Timestamp(l_dob.getTime()));
			pstmt.setString(5, params.get("DATE_OF_BIRTH"));
			pstmt.setString(6, params.get("GENDER"));
			pstmt.setString(7, params.get("PRACTO_DOC_TYPE_CODE"));
			pstmt.setString(8, params.get("BANK_REF_NO"));

			pstmt.setString(9, params.get("TRANSACTION_DATE"));
			pstmt.setString(10, params.get("RECPT_NATURE_CODE"));
			pstmt.setString(11, params.get("TRX_TYPE_CODE"));
			pstmt.setString(12, params.get("NET_AMOUNT_DEBIT"));
			pstmt.setString(13, params.get("PRODUCT_TRANSACTION_ID"));
			pstmt.setString(14, params.get("TRANSACTION_DATE"));
			pstmt.setString(15, XHDBAdapter.isNullReplace(params.get("SLMT_DOC_REMARKS"), ""));// SLMT_DOC_REMARKS
			pstmt.setString(16, err_message);
			pstmt.setString(17, XHDBAdapter.isNullReplace(params.get("SLMT_DOC_REMARKS"), ""));// RECEIPT_REMARKS

			pstmt.setString(18, params.get("EM_DOC_TYPE_CODE"));
			pstmt.setString(19, params.get("EM_DOC_NUMBER"));
			pstmt.setString(20, XHDBAdapter.isNullReplace(params.get("EM_DOC_DATE"), ""));
			pstmt.setString(21, params.get("ADDED_BY_ID")); 
			pstmt.setTimestamp(22, new java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(23, System.getenv("computername"));
			pstmt.setString(24, params.get("ADDED_BY_ID"));
			pstmt.setTimestamp(25, new java.sql.Timestamp(System.currentTimeMillis()));
			
			pstmt.setString(26, System.getenv("computername"));
			pstmt.setString(27, status);
			pstmt.setString(28, params.get("PROCESS_FLAG"));
			pstmt.setString(29, params.get("GATEWAY_TRANSACTION_ID")); //PRACTO_TRANS_ID
			pstmt.setString(30, params.get("APPOINTMENT_ID"));
			pstmt.setString(31, "Y");

			insertCount = pstmt.executeUpdate();

			l_app_msg = " :::  Appointment Payment Transaction Insert Count : " + insertCount;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (insertCount == 1) {

				l_err_msg = "Appointment Payment Transaction Successfull";

				dbConn.commit();
			} else {
				l_err_msg = "Error in saving Appointment Payment Transaction Details";
				dbConn.rollback();
			}

			if (l_debug_YN.equals("Y"))
				System.out.println(l_err_msg);

			return l_err_msg;

		} catch (Exception exp) {
			l_errcd = "E";
			exp.printStackTrace();
			
			try {				
			
				dbConn.rollback();
			}
			catch(Exception e){
				if (l_debug_YN.equals("Y"))	System.out.println("Error in DB Connection Rollback " + e.getMessage());
			}

			if (l_debug_YN.equals("Y"))	System.out.println("Error in " + exp.getMessage());

			return l_err_msg;
		} finally {
			XHUtil.closeDBResources(null, pstmt, null);
			//EMDataSource.returnConnection(dbConn);
		}
	}

	public static String getFormattedStringDate(String format, Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
		String dateFormatted = dateFormat.format(date);
		return dateFormatted;
	}

	public String waitUpdation(Map<String, String> params, Connection dbConn) {

		String l_response_str = "", l_app_msg = "", l_errmsg = "";
		String l_message_status = "", l_message_ack_text = "";

		//Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";

		try {

			l_app_msg = "::: Inside  Wait Updation ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			//dbConn = EMDataSource.getConnection();
			query = "SELECT MESSAGE_STATUS,ERR_MSG,MESSAGE_ACK_TEXT FROM XH_INBOUND_MESSAGE WHERE APPLICATION_ID = ? and FACILITY_ID = ? and MESSAGE_ID = ? and EVENT_TYPE = ?";

			pstmt = dbConn.prepareStatement(query);
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
			} else {
				l_response_str = " { " + " \"status\":0, " + " \"message\" : \"Reference Number :"
						+ params.get("MESSAGE_ID") + ", Transaction Failed \"  " + " } ";

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
			XHUtil.closeDBResources(rs, pstmt, null);
			//EMDataSource.returnConnection(dbConn);
		}
	}

	public String FetchStdCntrlSegMethod(String segmentID, String elementId, String standardCode, Connection dbConn) {

		//Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		l_app_msg = " Inside FetchStdCntrlSegMethod ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " Segment ID : " + segmentID + " ::: Element ID : " + elementId + " ::: Standard Code : "
				+ standardCode;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " Retrieving " + elementId + " Value...";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			//dbConn = EMDataSource.getConnection();
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
			//EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		return l_field_value;
	}

	public String insertInboundMessageDetails(Map<String, String> params, Connection dbConn) {
		String insertstmt = "INSERT INTO XH_INBOUND_MESSAGE (application_id, facility_id, message_id, srl_no, message_received_date, process_id, "
				+ " client_id, inbound_message_text, message_ack_text, message_status, rd_order_yn, "
				+ " added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, "
				+ " patient_id, merged_patient_id, episode_type, episode_id, visit_id, accession_num, action_type, "
				+ " last_proc_date, event_status, not_req_reason, ext_accession_num, event_type, protocol_link_id,err_msg) "
				+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

		//Connection dbConn = null;
		PreparedStatement pstmt = null;

		int insertCount = 0;

		String l_app_msg = "";

		String l_date = "";

		String l_err_msg = "Success";

		try {

			l_app_msg = " ::: Inside Inbound Message Details ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			//dbConn = EMDataSource.getConnection();
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
			pstmt.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(6, XHDBAdapter.isNullReplace(params.get("PROCESS_ID"), "")); // PROCESS_ID

			pstmt.setString(7, XHDBAdapter.isNullReplace(params.get("CLIENT_ID"), "")); // CLIENT_ID
			pstmt.setString(8, params.get("MESSAGE_TEXT")); // INBOUND_MESSAGE_TEXT
			pstmt.setString(9, XHDBAdapter.isNullReplace(params.get("MESSAGE_ACK_TEXT"), "")); // MESSAGE_ACK_TEXT
			pstmt.setString(10, XHDBAdapter.isNullReplace(params.get("MESSAGE_STATUS"), "")); // MESSAGE_STATUS
			pstmt.setString(11, XHDBAdapter.isNullReplace(params.get("RD_ORDER_YN"), "")); // RD_ORDER_YN

			pstmt.setString(12, XHDBAdapter.isNullReplace(params.get("ADDED_BY_ID"), params.get("LOGIN_USER")));
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

	public static ArrayList<String> FetchExternalAppDetails(String ExternalApplication, Connection dbConn) {
		//Connection dbConn = null;
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
			//dbConn = EMDataSource.getConnection();
			query = "SELECT APPLICATION_ID,PROTOCOL_LINK_ID,FACILITY_ID FROM xh_filter_dms_vw WHERE EXTERNAL_APPLICATION = ?";

			if (dbConn == null) {
				externalArray.add(l_conn_msg);
				return externalArray;
			}

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, ExternalApplication);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				l_application_id = rs.getString("APPLICATION_ID");
				l_protocol_link_id = rs.getString("PROTOCOL_LINK_ID");
				l_facility_id = rs.getString("FACILITY_ID");
				externalArray.add(l_application_id);
				externalArray.add(l_protocol_link_id);
				externalArray.add(l_facility_id);
			}

			l_app_msg = " ::: Application ID : " + l_application_id + " ::: Protocol Link Id : " + l_protocol_link_id;
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

	public List<Map<String, String>> FetchPatDetailsByUHID(String patientId, Connection dbConn) {
		//Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Map<String, String>> patientDetByUHID = new ArrayList<Map<String, String>>();
		Map<String, String> params = null;

		String query = "";
		String l_app_msg = "";

		l_app_msg = " Inside FetchPatDetailtsByUHID ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			//dbConn = EMDataSource.getConnection();
			query = "select patient_name, patient_id, contact2_no, sex, TO_CHAR(TRUNC(SYSDATE),'YYYY')-TO_CHAR(DATE_OF_BIRTH,'YYYY'), email_id, TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH from mp_patient where patient_id = ?";

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, patientId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				params = new LinkedHashMap<String, String>();
				params.put("patient_name", rs.getString("PATIENT_NAME"));
				params.put("patient_id", rs.getString("PATIENT_ID"));
				params.put("mobile_no", rs.getString("CONTACT2_NO"));
				params.put("patient_gender", rs.getString("SEX"));
				params.put("patient_age", rs.getString("TO_CHAR(TRUNC(SYSDATE),'YYYY')-TO_CHAR(DATE_OF_BIRTH,'YYYY')"));
				params.put("patient_email", rs.getString("EMAIL_ID"));
				params.put("patient_dob", rs.getString("DATE_OF_BIRTH"));
				patientDetByUHID.add(params);
			}
			l_app_msg = ":::patientDetByUHID :::" + patientDetByUHID;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

		} catch (Exception e) {
			params = new LinkedHashMap<String, String>();
			l_app_msg = "Error in Fetching Patient Details By UHID Exception - " + e.getMessage();
			params.put("Error", l_app_msg);
			patientDetByUHID.add(params);
		} finally {
			//EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		return patientDetByUHID;
	}

	public String UpadteApptRemarksMessageDetails(Map<String, String> params, String status, String err_message, Connection dbConn) {

		String updateStmt = "UPDATE OA_APPT SET APPT_REMARKS = ? WHERE FACILITY_ID=? AND EXT_APPT_REF_NO= ?";
		//Connection dbConn = null;
		PreparedStatement pstmt = null;

		int updateCount = 0;

		String l_app_msg = "";

		String l_err_msg = "Success";

		try {

			l_app_msg = " ::: Inside Update Appt Remarks in OA_APPT Details ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			//dbConn = EMDataSource.getConnection();

			if (dbConn == null) {
				return l_conn_msg;
			}

			pstmt = dbConn.prepareStatement(updateStmt);

			pstmt.setString(1, params.get("APPOINTMENT_REMARKS_DATA"));

			pstmt.setString(2, params.get("FACILITY_ID"));

			pstmt.setString(3, params.get("APPOINTMENT_ID"));

			updateCount = pstmt.executeUpdate();

			l_app_msg = " :::  Appointment Payment Transaction update Count : " + updateCount;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (updateCount == 1) {

				l_err_msg = "Appointment Payment Transaction Successfull";

				dbConn.commit();
			} else {
				l_err_msg = "Error in Appointment Payment Transaction Details";
				dbConn.rollback();
			}

			if (l_debug_YN.equals("Y"))
				System.out.println(l_err_msg);

			return l_err_msg;

		} catch (Exception exp) {
			l_errcd = "E";
			exp.printStackTrace();
			l_err_msg = "Error in " + exp.getMessage();

			if (l_debug_YN.equals("Y"))
				System.out.println(l_err_msg);

			return l_err_msg;
		} finally {
			XHUtil.closeDBResources(null, pstmt, null);
			//EMDataSource.returnConnection(dbConn);
		}
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

}
