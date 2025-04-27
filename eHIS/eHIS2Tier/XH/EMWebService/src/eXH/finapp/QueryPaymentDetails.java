package eXH.finapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.Types;
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


public class QueryPaymentDetails {
	
	public static String l_debug_YN = "N";

	public String l_errcd = "S", l_field_separator = "$!^", l_searchcd = "S";
	public String l_errmsg = "";
	public String l_ack_text = "";
	public String l_update_response_str = "";
	public String l_eventType = "F01";

	public static String l_conn_msg = "Error - Unable to connect to the Data base, Kindly contact the System Administrator";
	

	@SuppressWarnings("static-access")
	public String processRequest(String actionKey, String eventType) {
		
		String l_app_msg = "";
		String l_response_err_json = "", l_facility_id = "";
		String l_in_JSON = "", l_err_msg = "", l_response_str = "", l_message_id = "", l_application_id = "", l_protocol_link_id = "";
		String l_status = "", l_status_desc = "";
		String l_request_date_time ="",   l_patient_id ="", l_appointment_no = "";
		String l_settlement_type="",l_slmt_doc_ref="",l_slmt_doc_ref_date="",l_bank_cc_code="",l_rcpt_rfnd_id_no="";
		String l_online_approvl_yn ="",l_batch_no="",l_sale_draft_no="",l_success_flag="S",l_return_text="",l_visit_type="",l_pay_amount="";
		String l_blng_grp_id ="",l_cust_group_code="",l_cust_code="",l_policy_type_code="", l_policy_number="",l_membership_no="",l_policy_start_date="";
		String l_policy_expiry_date="",l_non_ins_blng_grp_id="";

		l_in_JSON=XHJSONUtil.createJsonObject(actionKey);
		
	

		Map<String,String> l_payment_details = new HashMap<String, String>();
		@SuppressWarnings("rawtypes")
		ArrayList l_external_app_details = null;
		Map<String, String> params = new HashMap<String, String>();
		Map<String, Object> l_response_json = new HashMap<String, Object>();
		ObjectMapper objMapper = new ObjectMapper();
		Map<String,String> l_req_params = new HashMap<String, String>();
		FinAppInboundTransaction finAppInboundTransaction = new FinAppInboundTransaction();

		String l_request_ref_no = "", l_request_type = "", l_responseJsonString = "";
		
		StringBuffer l_error = null;
		
		try
		{

			l_debug_YN = XHUtil.l_debug_YN;
			
			l_app_msg = " ************ FinApp Query Payment Details Traction started ************ ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_error = new StringBuffer("Unable to Fetch Payable Amount - Information Missing");
	
			l_app_msg = " ::: Inside Query Payment Details :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);	
		
			l_app_msg = " ::: Generating Message ID ::: ";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			
			l_message_id = finAppInboundTransaction.GenerateMessageIDMethod("XH_IB_MESSAGE_ID_SEQ");	
			
			if (l_message_id.indexOf("Error") >= 0) {
				l_errmsg = "Error in Message ID Generation - "+l_message_id;
				
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"status_desc\" : \" " + l_errmsg + " \"  "
						+ " } ";
				
				return "200#" + l_response_err_json + "#";
				
			}
			
			l_app_msg = " ::: Generated Message Id ::: "+l_message_id+" ::: Error Code : "+l_errcd+" ::: Error Message : "+l_errmsg;
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			/*if (l_errcd.equals("S"))				
			{			
				l_app_msg = " ::: Fetching External Application Details : ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				l_external_app_details = finAppInboundTransaction.FetchExternalAppDetails("FINAPP");			
				
				if (l_external_app_details.isEmpty()) 
				{ 
					l_errcd = "E";
					l_errmsg = "Error in Fetching External Application Details No Data Available";
					l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"status_desc\" : \" " + l_errmsg + " \"  "
							+ " } ";
					return   "200#"+l_response_err_json+"#";
					
				} 
				
				l_application_id = (String) l_external_app_details.get(0);
				
				if (l_application_id.indexOf("Error") >= 0) {
					l_errmsg = "Fetching External Application Details - "+l_application_id;
					l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"status_desc\" : \" " + l_errmsg + " \"  "
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
			}*/

			
			params.put("MESSAGE_ID", l_message_id);
			params.put("APPLICATION_ID", "FINAPP");
			params.put("PROTOCOL_LINK_ID", "FINAPPIP");
			params.put("EVENT_TYPE", l_eventType);		
			
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);	
			
			l_app_msg = " ::: Parsing input message ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);		
	
			

			l_responseJsonString = "";
			
			
			
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
			
			l_app_msg = " ::: Getting request_date_time from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_facility_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "facility_id"); 
			if (l_facility_id.length()>2 ) {
				l_errcd = "E";
				l_error.append(" - facility id");
			}
			l_app_msg = " ::: Facility Id : " + l_facility_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			l_req_params.put("facility_id", l_facility_id);
			params.put("FACILITY_ID",l_facility_id);
			
			l_app_msg = " ::: Getting facility id from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	

	l_patient_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "patient_id");
	int validUHID = ValidateUHID(l_patient_id);
				
				l_app_msg = " ::: Validated count : " + validUHID;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				if(validUHID >= 1){
					l_errcd = "S";
				   l_error.append(" - patient id");
					l_app_msg = " ::: Validate Patient Id:::";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
				}else {
					l_errcd = "E";
					l_status = "0";
					l_status_desc = "Patient record does not exists with the UHID "+l_patient_id;
					
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);
					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("patient_id", l_patient_id);
					l_response_json.put("appointment_no", l_appointment_no);
					
					l_responseJsonString = objMapper.writeValueAsString(l_response_json);
					
					l_app_msg = " :::  Patient record does not exists with the UHID ::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
					params.put("REQUEST_REF_NO", l_request_ref_no);
					params.put("PATIENT_ID", l_patient_id);
					params.put("APPOINTMENT_NO", l_appointment_no);
					params.put("FACILITY_ID", l_facility_id);
					params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
					finAppInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
					
					return "200#"+l_responseJsonString+"#";
					
				}
			
			l_req_params.put("patient_id", l_patient_id);
			
			l_app_msg = " ::: Getting patient id from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	
	l_appointment_no = XHJSONUtil.getJsonRequestString(l_in_JSON, "appointment_no");
	int validateAppt =ValidateAppointmentNo(l_appointment_no,l_facility_id,l_patient_id);
			l_app_msg = " ::: Validated validateAppt count : " + validateAppt;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				if(validateAppt >= 1){
					l_errcd = "S";
				    l_error.append(" - Appointment id");
					
					l_app_msg = " ::: Validate Appointment:::";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
				}else {
					l_errcd = "E";
					l_status = "0";
					l_status_desc = "Appointment No does not exists with the given no "+l_appointment_no;
					
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);
					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("patient_id", l_patient_id);
					l_response_json.put("appointment_no", l_appointment_no);
					l_response_json.put("l_req_params", l_req_params);
					l_response_json.put("validateAppt", validateAppt);
					
					l_responseJsonString = objMapper.writeValueAsString(l_response_json);
					
					l_app_msg = " :::  Appointment No does not exists with the given no ::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);

					params.put("REQUEST_REF_NO", l_request_ref_no);
					params.put("PATIENT_ID", l_patient_id);
					params.put("APPOINTMENT_NO", l_appointment_no);
					params.put("FACILITY_ID", l_facility_id);
					params.put("SETTLEMENT_TYPE", "");
					params.put("SLMT_DOC_REF", "");
					params.put("SLMT_DOC_REF_DATE", "");
					params.put("BANK_CC_CODE", "");
					params.put("RCPT_RFND_ID_NO", "");
					params.put("ONLINE_APPROVL_YN", "");
					params.put("BATCH_NO", "");
					params.put("SALE_DRAFT_NO", "");

					params.put("RETURN_TEXT", "");
					params.put("ENCOUNTER_ID", "");
					params.put("VISIT_TYPE", "");
					params.put("BILL_DOC_TYPE", "");
					params.put("BILL_DOC_NO", "");
					params.put("REC_DOC_TYPE", "");
					params.put("REC_DOC_NO", "");
					params.put("PAY_AMOUNT", "");

					params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
					finAppInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
					
					return "200#"+l_responseJsonString+"#";
					
				}
			
			l_app_msg = " ::: Getting Appointment id from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	        l_req_params.put("appointment_no", l_appointment_no);

			l_blng_grp_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "blng_grp_id");
			l_req_params.put("blng_grp_id", l_blng_grp_id);	

			l_app_msg = " ::: blng_grp_id : " + l_blng_grp_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_cust_group_code = XHJSONUtil.getJsonRequestString(l_in_JSON, "cust_group_code");
			l_req_params.put("cust_group_code", l_cust_group_code);	

			l_app_msg = " ::: cust_group_code : " + l_cust_group_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_cust_code = XHJSONUtil.getJsonRequestString(l_in_JSON, "cust_code");
			l_req_params.put("cust_code", l_cust_code);	

			l_app_msg = " ::: cust_code : " + l_cust_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_policy_type_code = XHJSONUtil.getJsonRequestString(l_in_JSON, "policy_type_code");
			l_req_params.put("policy_type_code", l_policy_type_code);	

			l_app_msg = " ::: policy_type_code : " + l_policy_type_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_policy_number = XHJSONUtil.getJsonRequestString(l_in_JSON, "policy_number");
			l_req_params.put("policy_number", l_policy_number);	

			l_app_msg = " ::: policy_number : " + l_policy_number;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_membership_no = XHJSONUtil.getJsonRequestString(l_in_JSON, "membership_no");
			l_req_params.put("membership_no", l_membership_no);	

			l_app_msg = " ::: membership_no : " + l_membership_no;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_policy_start_date = XHJSONUtil.getJsonRequestString(l_in_JSON, "policy_start_date");
			l_req_params.put("policy_start_date", l_policy_start_date);	

			l_app_msg = " ::: policy_start_date : " + l_policy_start_date;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_policy_expiry_date = XHJSONUtil.getJsonRequestString(l_in_JSON, "policy_expiry_date");
			l_req_params.put("policy_expiry_date", l_policy_expiry_date);	

			l_app_msg = " ::: policy_expiry_date : " + l_policy_expiry_date;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_non_ins_blng_grp_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "non_ins_blng_grp_id");
			l_req_params.put("non_ins_blng_grp_id", l_non_ins_blng_grp_id);	

			l_app_msg = " ::: non_ins_blng_grp_id : " + l_non_ins_blng_grp_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_settlement_type = XHJSONUtil.getJsonRequestString(l_in_JSON, "settlement_type");
			l_req_params.put("settlement_type", l_settlement_type);

			l_app_msg = " ::: settlement_type : " + l_settlement_type;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_slmt_doc_ref = XHJSONUtil.getJsonRequestString(l_in_JSON, "slmt_doc_ref");
			l_req_params.put("slmt_doc_ref", l_slmt_doc_ref);

			l_app_msg = " ::: slmt_doc_ref : " + l_slmt_doc_ref;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_slmt_doc_ref_date = XHJSONUtil.getJsonRequestString(l_in_JSON, "slmt_doc_ref_date");
			l_req_params.put("slmt_doc_ref_date", l_slmt_doc_ref_date);

			l_app_msg = " ::: slmt_doc_ref_date : " + l_slmt_doc_ref_date;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_bank_cc_code = XHJSONUtil.getJsonRequestString(l_in_JSON, "bank_cc_code");
			l_req_params.put("bank_cc_code", l_bank_cc_code);

			l_app_msg = " ::: bank_cc_code : " + l_bank_cc_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_rcpt_rfnd_id_no = XHJSONUtil.getJsonRequestString(l_in_JSON, "rcpt_rfnd_id_no");
			l_req_params.put("rcpt_rfnd_id_no", l_rcpt_rfnd_id_no);

			l_app_msg = " ::: rcpt_rfnd_id_no : " + l_rcpt_rfnd_id_no;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_online_approvl_yn = XHJSONUtil.getJsonRequestString(l_in_JSON, "online_approvl_yn");
			l_req_params.put("online_approvl_yn", l_online_approvl_yn);	

			l_app_msg = " ::: online_approvl_yn : " + l_online_approvl_yn;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_batch_no = XHJSONUtil.getJsonRequestString(l_in_JSON, "batch_no");
			l_req_params.put("batch_no", l_batch_no);

			l_app_msg = " ::: batch_no : " + l_batch_no;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_sale_draft_no = XHJSONUtil.getJsonRequestString(l_in_JSON, "sale_draft_no");
			l_req_params.put("sale_draft_no", l_sale_draft_no);	

			l_app_msg = " ::: sale_draft_no : " + l_sale_draft_no;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			
			
						
	l_payment_details= getPaymentDetails(l_facility_id,l_patient_id,l_appointment_no,l_eventType,l_application_id,l_blng_grp_id,l_cust_group_code,l_cust_code,l_policy_type_code,l_policy_number
    ,l_membership_no,l_policy_start_date,l_policy_expiry_date,l_non_ins_blng_grp_id,l_settlement_type,l_slmt_doc_ref,l_slmt_doc_ref_date,l_bank_cc_code
    ,l_rcpt_rfnd_id_no,l_online_approvl_yn,l_batch_no,l_sale_draft_no);

			if(l_payment_details.isEmpty()){
					l_success_flag = "E";
					l_errcd ="E";
					l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^ Exception Occurred " + "Payment Details Are Empty";
			        l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \"Reference Number :"+ l_message_id+" Exception : " + l_errmsg + " \"  "
					+ " } ";
			
					l_app_msg = " ::: Search l_payment_details data not matched ::: "+l_payment_details;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
				}else{
                     
				l_success_flag =l_payment_details.get("success_flag");
				l_visit_type =l_payment_details.get("visit_type");
				l_pay_amount =l_payment_details.get("pay_amount");
				}
				
							
				params.put("ERR_MSG", "");

			if(l_success_flag.equals("E")){
				l_status = "0";
				l_status_desc = "Payment Details not found";
				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				l_response_json.put("facility_id", l_facility_id);
				l_response_json.put("patient_id", l_patient_id);
				l_response_json.put("appointment_no", l_appointment_no);
				l_response_json.put("success_flag", "E");
				l_response_json.put("return_text", "No Data Found");
				
				l_responseJsonString = objMapper.writeValueAsString(l_response_json);
				
				params.put("REQUEST_REF_NO", l_request_ref_no);
				params.put("PATIENT_ID", l_patient_id);
				params.put("APPOINTMENT_NO", l_appointment_no);
				params.put("FACILITY_ID", l_facility_id);
				params.put("SETTLEMENT_TYPE", "");
				params.put("SLMT_DOC_REF", "");
				params.put("SLMT_DOC_REF_DATE", "");
				params.put("BANK_CC_CODE", "");
				params.put("RCPT_RFND_ID_NO", "");
				params.put("ONLINE_APPROVL_YN", "");
				params.put("BATCH_NO", "");
				params.put("SALE_DRAFT_NO", "");

				params.put("RETURN_TEXT", "");
				params.put("ENCOUNTER_ID", "");
				params.put("VISIT_TYPE", "");
				params.put("BILL_DOC_TYPE", "");
				params.put("BILL_DOC_NO", "");
				params.put("REC_DOC_TYPE", "");
				params.put("REC_DOC_NO", "");
				params.put("PAY_AMOUNT", "");

				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				params.put("ERR_MSG", l_error.toString());
				
				l_response_str = finAppInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_response_err_json);
				l_app_msg = " ::: Message Load Method  ::: "+ l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);		
						
				l_app_msg = " ************ FinApp get Payment Details Traction Ended ************ ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				return "200#"+ l_responseJsonString +"#";
			}
				
			if(l_success_flag.equals("S")){
				l_status = "1";
				l_status_desc = "Payment Details successfully fetched";
				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				l_response_json.put("facility_id", l_facility_id);
				l_response_json.put("patient_id", l_patient_id);
				l_response_json.put("appointment_no", l_appointment_no);
				l_response_json.put("success_flag", l_success_flag);
				l_response_json.put("visit_type", l_visit_type);
				l_response_json.put("pay_amount", l_pay_amount);
				
				
				l_responseJsonString = objMapper.writeValueAsString(l_response_json);
				
				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				params.put("ERR_MSG", l_error.toString());

				params.put("REQUEST_REF_NO", l_request_ref_no);
				params.put("PATIENT_ID", l_patient_id);
				params.put("APPOINTMENT_NO", l_appointment_no);
				params.put("FACILITY_ID", l_facility_id);
				params.put("SETTLEMENT_TYPE", "");
				params.put("SLMT_DOC_REF", "");
				params.put("SLMT_DOC_REF_DATE", "");
				params.put("BANK_CC_CODE", "");
				params.put("RCPT_RFND_ID_NO", "");
				params.put("ONLINE_APPROVL_YN", "");
				params.put("BATCH_NO", "");
				params.put("SALE_DRAFT_NO", "");

				params.put("RETURN_TEXT", "");
				params.put("ENCOUNTER_ID", "");
				params.put("VISIT_TYPE", l_visit_type);
				params.put("BILL_DOC_TYPE", "");
				params.put("BILL_DOC_NO", "");
				params.put("REC_DOC_TYPE", "");
				params.put("REC_DOC_NO", "");
				params.put("PAY_AMOUNT", l_pay_amount);

				l_response_str = finAppInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, "");
				l_app_msg = " ::: Message Load Method  ::: "+ l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println("params383==="+params);		
						
				l_app_msg = " ************ FinApp get Payment Details Traction Ended ************ ";
				if (l_debug_YN.equals("Y"))	System.out.println(params);
				
				return "200#"+ l_responseJsonString +"#";
			}
			       
			
		}catch(Exception e){
			
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^ Exception Occurred " + e.getMessage();
			l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \"Reference Number-validateAppt :" + l_app_msg + " Exception l_payment_details: " + l_payment_details + " \"  " + " } ";
			
			l_app_msg = "::: On Exception the message is loaded ::: ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());

			l_response_str = finAppInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, "");
			l_app_msg = l_app_msg + " : " + l_response_str;
			if (l_debug_YN.equals("Y")) System.out.println("params@@405=="+params);

			return "200#" + l_response_err_json + "#";
			
		}	
		
		return "200#"+ l_response_str +"#";
	}
	public static Map<String, String> getPaymentDetails(String facility_id,String patient_id,String appointment_no,String event_type,String application_id,String blng_grp_id,String cust_group_code,String cust_code,String policy_type_code, String policy_number,String membership_no,String policy_start_date,String policy_expiry_date,String non_ins_blng_grp_id,String settlement_type,String slmt_doc_ref,String slmt_doc_ref_date,String bank_cc_code,String rcpt_rfnd_id_no,String online_approvl_yn,String batch_no,String sale_draft_no)
	{
		Connection dbConn = null;
		ResultSet rs = null;
		CallableStatement cstmt = null ;
		Map<String, String> paymentDetails = new HashMap<String, String>();
		FinAppInboundTransaction finAppInboundTransaction = new FinAppInboundTransaction();
		ObjectMapper objMapper = new ObjectMapper();
		
		String l_app_msg = "", query = "",l_response_str="",l_response_err_json="",l_errcd="E";
		
		l_app_msg = " ::: Inside getPaymentDetails ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		try
		{
			dbConn = EMDataSource.getConnection();
			cstmt=dbConn.prepareCall("{call XH_TRX_API.API_OP_VISIT_GENERATION (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			cstmt.setString( 1, facility_id); 
			cstmt.setString( 2, "FINAPP"); 
			cstmt.setString( 3, event_type); 
			cstmt.setString( 4, patient_id); 
			cstmt.setString( 5, appointment_no); 
			cstmt.setString( 6, blng_grp_id); 
			cstmt.setString( 7, cust_group_code); 
			cstmt.setString( 8, cust_code); 
			cstmt.setString( 9, policy_type_code); 
			cstmt.setString( 10, policy_number); 
			cstmt.setString( 11, membership_no); 
			cstmt.setString( 12, policy_start_date); 
			cstmt.setString( 13, policy_expiry_date);
			cstmt.setString( 14, non_ins_blng_grp_id);
			cstmt.setString( 15, settlement_type);
			cstmt.setString( 16, slmt_doc_ref);
			cstmt.setString( 17, slmt_doc_ref_date);
			cstmt.setString( 18, bank_cc_code);
			cstmt.setString( 19, rcpt_rfnd_id_no);
			cstmt.setString( 20, online_approvl_yn);
			cstmt.setString( 21, batch_no);
			cstmt.setString( 22, sale_draft_no);
			cstmt.registerOutParameter(23, java.sql.Types.VARCHAR ); 
			cstmt.registerOutParameter(24, java.sql.Types.VARCHAR ); 
			
			cstmt.execute();
			System.out.println(" Query Payment in params facility_id==="+facility_id+"event_type=="+event_type+"patient_id=="+patient_id+"appointment_no=="+appointment_no+"blng_grp_id=="+blng_grp_id+"cust_group_code=="+cust_group_code+"cust_code=="+cust_code+"policy_type_code=="+policy_type_code+"policy_number=="+policy_number+"membership_no=="+membership_no+"policy_start_date=="+policy_start_date+"policy_expiry_date=="+policy_expiry_date+"non_ins_blng_grp_id=="+non_ins_blng_grp_id+"settlement_type=="+settlement_type+"slmt_doc_ref=="+slmt_doc_ref+"slmt_doc_ref_date="+slmt_doc_ref_date+"bank_cc_code=="+bank_cc_code+"rcpt_rfnd_id_no=="+rcpt_rfnd_id_no+"online_approvl_yn=="+online_approvl_yn+"batch_no=="+batch_no+"sale_draft_no=="+sale_draft_no);
			String  success_flag = cstmt.getString(23)==null?"E":cstmt.getString(23);
			String return_text  = cstmt.getString(24)==null?"":cstmt.getString(24);
			System.out.println("success_flag==="+success_flag+"return_text=="+return_text);
			String[] l_split_text = return_text.split("#");
			String visit_type =l_split_text[0];
			String pay_amount =l_split_text[1]; 
			System.out.println("visit_type==="+visit_type+"pay_amount=="+pay_amount);
			 paymentDetails.put("success_flag",success_flag);
			 paymentDetails.put("visit_type",visit_type);
			 paymentDetails.put("pay_amount",pay_amount); 
			
			l_app_msg = " ::: Payment Details Fetch ::: "+ paymentDetails;


			if (l_debug_YN.equals("Y"))
				System.out.println("l_app_msg@@@@495==="+l_app_msg);
			
		}catch (Exception e) {
			
		    System.out.println("Execption in PaymentDetails Method : "+e.getMessage());
				e.printStackTrace();
		} finally {
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, cstmt, null);
		}
		
		return paymentDetails;
		
	}

		 
		public  String sendErrorResponse(String actionKey, String error , String request_ref_no, Map<String, String> params)
		{
			String l_status = "", l_status_desc = "", l_responseJsonString = "",l_app_msg ="",  l_response_str = "";
			Map<String, Object> l_response_json = new HashMap<String, Object>();
			LinkedHashMap<String, String> patient_data = new LinkedHashMap<String, String>();
			FinAppInboundTransaction finAppInboundTransaction = new FinAppInboundTransaction();
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
				l_response_str = finAppInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, error);
				l_app_msg = " ::: Message Load Method  params::: "+ l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println("params@@@=="+params);				
				
			}catch(Exception e)
			{
				
			}
			
			return l_responseJsonString;
			
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

	public static int ValidateAppointmentNo(String appointment_no,String facility_id,String patient_id ){
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query;
		int count = 0;
		try 
		{
			dbConn =  EMDataSource.getConnection();
			query = "SELECT PATIENT_ID,COUNT( * ) FROM OA_APPT WHERE APPT_REF_NO = ? AND FACILITY_ID =? AND PATIENT_ID=? GROUP BY PATIENT_ID";

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, appointment_no);
			pstmt.setString(2, facility_id);
			pstmt.setString(3, patient_id);
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


}

