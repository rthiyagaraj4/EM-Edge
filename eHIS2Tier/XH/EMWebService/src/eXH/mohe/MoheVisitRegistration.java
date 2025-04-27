package eXH.mohe;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import eXH.util.EMDataSource;
import eXH.util.XHJSONUtil;
import eXH.util.XHUtil;

public class MoheVisitRegistration {
	
	public static String l_debug_YN = "N";
	public static boolean insertable = false;
	public String l_errcd = "S", l_field_separator = "$!^", l_searchcd = "S";
	public String l_errmsg = "";
	public String l_eventType = "PV1";
	static String added_at_ws_no ="INTERFACE";
	static String modified_at_ws_no ="INTERFACE";
	static String modified_by_id="INTERFACE";
	static String added_by_id ="INTERFACE";
	public static final String l_standard_code = "HTTPCC";
	//public static final String l_standard_code = "HL72.3.1";
	public static final String l_segment_id = "MOHE";
	
	public String processRequest(String actionKey) {
		Map<String, Object> l_response_json = new HashMap<String, Object>();
		ArrayList<Map<String, String>> visitDtls = new ArrayList<Map<String, String>>();
		Map<String, String> visitMapDtls = new HashMap<String, String>();
		
		ObjectMapper objMapper = new ObjectMapper();
		String l_status = "", l_status_desc = "";
		
		String l_app_msg = "";
		String l_message_id = "", l_application_id = "", l_protocol_link_id = "", l_facility_id = "", l_patient_id = "", l_visit_status = "01";
		Map<String, String> v_visit_type_validation_map = new LinkedHashMap<String, String>();
		String k_visit_type_ind = "";
		String new_op_episode_yn = "";
		String l_visit_date_time = "", l_location_type = "", l_location_code = "", l_service_code = "", l_visit_type = "", l_practitioner_id;
		String l_financial_details = "", l_billing_group_code = "", l_settlement_type_code = "",  l_locale = "en", l_appt_id = "";
		String strAddlServAvailYN = "", strAddlServPanelInd = "", strAddlServPanelCode = "", strAddlChargeType = "", dflt_excl_overide_code = "";
		String l_payer_group_code = "", l_payer_code = "";
		String l_visit_type_ind = "";
		int noofdecimal = 0;
		String service_date = "";
		String l_appt_time = "", l_appt_status = "", l_request_id = "", l_refferal_id = "";
		String l_policy_type_code = "", l_policy_number = "", l_policy_start_date = "", l_policy_end_date = "";
		String l_visitno = "", l_episode_no = "", l_calling_function_id = "VISIT_REGISTRATION", l_recordMode = "U";
		String l_str_fin_auth_user_id = "", l_credit_authorisation_by = "", l_claim_code = "";
		String str_acct_seq_eff_from_date = "", str_acct_seq_eff_to_date = "", l_str_upd_patient_fin_dtls_yn = "Y";
		String strBLInterfaceYN = "N";
		String l_proc_success = "Y";
		
		Map<String, String> episodeMap = new HashMap<String, String>();
		Map<String, String> encounterMap = new HashMap<String, String>();
		Map<String, String> clinicMap = new HashMap<String, String>();
		String l_in_JSON = "", l_responseJsonString = "", l_request_ref_no = "", l_request_type = "";
		String l_encounter_id = "", l_visitnum = "", l_p_id = "W",  l_queueID = "";
		String l_slmt_ind = "", l_adm_rec_flag = "";
		String l_fin_class_flag_YN = "";
		int l_assessmentMonths = 0;
		String l_dflt_prv_fin_dtl_acrs_enc_yn = "N", l_build_episode_rule = "";
		int l_acc_seq_no=1;
		
		/*LinkedHashMap<String, HashMap<String, String>> new_hash_map = new LinkedHashMap<String, HashMap<String,String>>();
		LinkedHashMap<String, String> PR_ENCOUNTER = null;
		LinkedHashMap<String, String> OP_PATIENT_QUEUE = null;
		LinkedHashMap<String, String> OP_LAST_VISIT_FOR_SERVICE = null;
		LinkedHashMap<String, String> OP_EPISODE_FOR_SERVICE = null;*/
		
		String l_episode_type = "O", l_calling_module_id = "OP", l_REFERRAL_SOURCE_CODE_MAIN = "", l_REFERRAL_SOURCE_CODE_SUB = "", l_employer_code = "", l_slmt_type_code = "";;
		String strStartValid = "Y";
		String str_epi_type_clinic_code = "";
		String l_cust_group_code = "", l_cust_code = "", l_credit_doc_ref_desc = "", l_credit_doc_ref_start_date = "", l_credit_doc_ref_date = "";
		String l_CLASSIFICATION_START_DATE = "", l_CLASSIFICATION_END_DATE = "", l_financial_remarks = "", l_SOCIAL_PENSIONER_ID = "";
		String l_slmt_doc_ref_desc = "", l_slmt_doc_ref_date = "", l_slmt_doc_remarks = "", l_non_ins_blng_grp_id = "", l_NON_INS_REF_SOURCE_CODE_MAIN ="";
		String l_NON_INS_REF_SOURCE_CODE_SUB = "", l_non_ins_cust_group_code = "", l_non_ins_cust_code = "", l_annual_family_income = "", l_family_assets_value = "";
		String l_num_of_dependents = "", l_resp_for_bill_payment = "", l_pat_reln_with_resp_pers = "", l_gl_holder_name = "", l_pat_reln_with_gl_holder = "";
		String l_NO_OF_ENC_GL_VALID = "", l_NO_OF_AE_ENC_GL_VALID = "", l_NO_OF_OP_ENC_GL_VALID = "", l_NO_OF_IP_ENC_GL_VALID = "", l_NO_OF_DC_ENC_GL_VALID = "";
		String l_remarks = "", l_PATIENT_INC_ASSET_IND = "", l_PATIENT_INC_ASSET_AMT = "", l_PATIENT_INC_ASSET_FREQ = "", l_SPOUSE_INC_ASSET_AMT = "";
		String l_SPOUSE_INC_ASSET_FREQ = "", l_DEPENDENT_INC_ASSET_AMT = "", l_DEPENDENT_INC_ASSET_FREQ = "", l_CLASSIFICATION_CODE = "", l_CLASSIFICATION_TYPE = "";
		String l_ref_src_main_code = "", l_ref_src_sub_code = "", l_priority = "", l_credit_auth_ref = "", l_credit_auth_date = "", l_effective_from = "";
		String l_effective_to = "", l_approved_amt = "", l_approved_days = "", l_adj_rule_ind = "", l_adj_perc_amt_ind = "", l_adj_perc_amt_value = "";
		String l_pmnt_diff_adj_int = "", l_drg_pmnt_diff_adj_int = "", l_spl_srv_pmnt_diff_adj_int = "";
		String l_str_cust_group_code = "", l_str_cust_code = "", l_str_doc_ref = "", l_str_doc_start_date = "", l_str_doc_end_date;
		
		String strHospServPanelStr = "", strMedServPanelStr = "", strAddlServPanelStr = "";
		
		// proc_main('D') variables
		String d_hosp_charge_YN = "", d_med_charge_YN = "", d_addl_charge_YN = "", d_exempt_date = "", d_str_hosp_chrg_amt = "", d_str_hosp_chrg_pat_amt = "";
		double d_hosp_chrg_amt = 0.0, d_hosp_chrg_pat_amt = 0.0, d_med_chrg_amt = 0.0, d_med_chrg_pat_amt = 0.0, d_addl_chrg_amt = 0.0, d_addl_chrg_pat_amt = 0.0;
		String d_str_med_chrg_pat_amt = "", d_str_addl_chrg_amt = "", d_str_addl_chrg_pat_amt = "", d_bill_gen_yn = "", d_bill_doc_type = "", d_bill_doc_number = "";
		String d_str_med_chrg_amt = "", d_str_bill_gen_later = "", d_str_total_bill_amt = "", d_str_bill_prt_format_YN = "", d_str_bill_prt_format_vals = "";
		String c_str_hosp_chrg_pat_amt = "";
		
		// proc_main('C') variables
		/*String c_hosp_charge_YN = "", c_med_charge_YN = "", c_addl_charge_YN = "", c_exempt_date = "", c_str_hosp_chrg_amt = "", c_str_hosp_chrg_pat_amt = "";
		double c_hosp_chrg_amt = 0.0, c_hosp_chrg_pat_amt = 0.0, c_med_chrg_amt = 0.0, c_med_chrg_pat_amt = 0.0, c_addl_chrg_amt = 0.0, c_addl_chrg_pat_amt = 0.0;
		String c_str_med_chrg_pat_amt = "", c_str_addl_chrg_amt = "", c_str_addl_chrg_pat_amt = "", c_bill_gen_yn = "", c_bill_doc_type = "", c_bill_doc_number = "";
		String c_str_med_chrg_amt = "", c_str_bill_gen_later = "", c_str_total_bill_amt = "", c_str_bill_prt_format_YN = "", c_str_bill_prt_format_vals = "";*/
		
		String charge_basis_by_physician_yn = "", strHospChargeStage = "", strMedChargeStage = "", strHospServPanelInd = "";
		String strHospServPanelCode = "", strMedServPanelInd = "", strMedServPanelCode = "";
		
		String l_membership_number = "";
		String l_element_id = "";
		String str_bill_gen_yn = "", str_bill_doc_type = "", str_bill_doc_number = "";
		
		int l_quenum = 0;
		StringBuffer l_error = null;
		StringBuffer l_error2 = null;
		ArrayList l_external_app_details = null;
		String l_episode_id = "";
		Map<String, String> params = new HashMap<String, String>();
		MoheInboundTransaction practoInboundTransaction = new MoheInboundTransaction();
		String l_ASSIGN_QUEUE_NUM_BY = "", l_QMS_INTERFACED_YN = "", l_VISIT_TYPE_DERV_RULE = "";
		
		Connection con				= null;
		PreparedStatement pstmt		= null;
		ResultSet rset				= null;
		CallableStatement cstmt     = null;
		
		String query = "", l_debug_yn = "";
		
		try
		{
			con =  EMDataSource.getConnection();

			query = "select NVL(DEBUG_YN, 'N') DEBUG_YN FROM XH_PARAM " ;

			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next())
			{
			   l_debug_yn = rset.getString("DEBUG_YN");
			}

			l_debug_YN = l_debug_yn;

		}
		catch(Exception e)
		{
			l_app_msg = "Eception in DEBUG YN : "+e.getMessage();
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			e.printStackTrace();
		}		
		finally {
			XHUtil.closeDBResources(rset, pstmt, null);
			EMDataSource.returnConnection(con);
		}
		
		try{
			
            l_debug_YN = XHUtil.l_debug_YN;
			
			l_app_msg = " ************ Mohe Register Patient Transaction started ************ ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_error = new StringBuffer("Unable to Register Visit - Information Missing ");
			l_error2 = new StringBuffer("Unable to Register Visit - Invalid Data ");
			
	
			l_app_msg = " ::: Inside Mohe Visit Registration Details :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);	
			
			l_app_msg = " ::: Fetching Added By Id ::: ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_element_id = "BL_USER_ID";

			added_by_id = FetchStdCntrlSegMethod(l_segment_id, l_element_id,	l_standard_code);
			if (l_debug_YN.equals("Y"))	System.out.println(" ::: Added By Id ::: "+ added_by_id);
		
			l_app_msg = " ::: Generating Message ID ::: ";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			
			l_message_id = practoInboundTransaction.GenerateMessageIDMethod("XH_IB_MESSAGE_ID_SEQ");	
			
			if (l_message_id.indexOf("Error") >= 0) {
				l_errmsg = "Error in Message ID Generation - "+l_message_id;
				l_error.append(l_errmsg);
			}
			
			l_app_msg = " ::: Generated Message Id ::: "+l_message_id+" ::: Error Code : "+l_errcd+" ::: Error Message : "+l_errmsg;
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			
			if (l_errcd.equals("S"))				
			{			
				l_app_msg = " ::: Fetching External Application Details : ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				l_external_app_details = practoInboundTransaction.FetchExternalAppDetails("MOHEINB");			
				
				if (l_external_app_details.isEmpty()) 
				{
					l_errcd = "E";
					l_errmsg = "Error in Fetching External Application Details No Data Available";
					l_error.append(l_errmsg);
				}
				
				l_application_id = (String) l_external_app_details.get(0);
				
				if (l_application_id.indexOf("Error") >= 0) {
					l_errmsg = "Fetching External Application Details - "+l_application_id;
					l_error.append(l_errmsg);
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
			
			/*if (l_errcd.equals("S"))
			{
				String l_response_str =new MoheInboundTransaction().MessageLoadMethod(actionKey, params, l_errcd, "");
				l_app_msg = l_app_msg +" : " + l_response_str;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
			}*/
			
			/*l_app_msg = " ::: Action Key :::"+actionKey;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);*/
			
			l_app_msg = " ::: Parsing input message ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);		
	
			l_in_JSON = XHJSONUtil.createJsonObject(actionKey);
			
			if (l_in_JSON.indexOf("Error") >= 0) {
				l_errcd = "E";
				l_errmsg = l_in_JSON;
				l_error.append(l_errmsg);
			}
			
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
			
			l_app_msg = " ::: Getting Request Facility ID from JSON :::";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_facility_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","facility_id");
			
			l_app_msg = " ::: Facility ID : " + l_facility_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_app_msg = " ::: Getting Request Patient ID from JSON :::";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_patient_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","patient_id");			
			l_app_msg = " ::: Patient ID : " + l_patient_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			if (l_patient_id.indexOf("Exception in") >= 0  || "".equals(l_patient_id.trim())  )
			{
				l_errcd = "E";
				if("".equals(l_patient_id.trim()) )
				{
					l_error.append("- Patient Id cannot be empty ");
				}
			}
			
			if (l_errcd.equals("E"))
			{			
				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);				
				return "200#"+ l_responseJsonString +"#";			
			}
			
			String v_patient_id = validatePatient(l_patient_id);
			if(!l_patient_id.equals(v_patient_id)){
				l_errcd = "E";
				l_error2.append("- Patient Id - "+l_patient_id+" - Does Not Exists in EM ");				
			}
			
			params.put("ERR_MSG", "");
			
			if (l_errcd.equals("E"))
			{
				l_app_msg = " ::: Inserting Request into Message Table while Patient ID validation ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				l_responseJsonString = sendErrorResponse(actionKey, l_error2.toString(), l_request_ref_no, params);			
				
				return "200#"+ l_responseJsonString +"#";			
			}
			
			l_app_msg = " ::: Getting Request Visit Date Time from JSON :::";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_visit_date_time = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","visit_date_time");
			l_app_msg = " ::: Visit Date Time : " + l_visit_date_time;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			if (l_visit_date_time.indexOf("Exception in") >= 0  || "".equals(l_visit_date_time.trim())  )
			{
				l_errcd = "E";
				if("".equals(l_visit_date_time.trim()) )
				{
					l_error.append("- Visit Date Time cannot be empty");
				}
			}
			
			if (!l_visit_date_time.equals("")) {

				String l_validate_appt_date_time = validateDateTime(l_visit_date_time);

				if (l_validate_appt_date_time.indexOf("Error") >= 0	|| l_validate_appt_date_time.equals("1")) {
					l_errcd = "E";
					String l_err_msg = "- Visit Date Time can't less than and greater than Current Date Time";
					l_error2.append(l_err_msg);
					
					l_responseJsonString = sendErrorResponse(actionKey, l_error2.toString(), l_request_ref_no, params);					
					return "200#"+ l_responseJsonString +"#";
				}
			}
			
			if (l_errcd.equals("E"))
			{				
				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);				
				return "200#"+ l_responseJsonString +"#";			
			}
			
			if (l_errcd.equals("E"))
			{
				l_app_msg = " ::: Inserting Request into Message Table while Visit Date Time validation ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				l_responseJsonString = sendErrorResponse(actionKey, l_error2.toString(), l_request_ref_no, params);			
				
				return "200#"+ l_responseJsonString +"#";			
			}
			
			l_app_msg = " ::: Getting Request Location Type from JSON :::";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_location_type = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","location_type");
			l_app_msg = " ::: Location Type : " + l_location_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			if (l_location_type.indexOf("Exception in") >= 0  || "".equals(l_location_type.trim())  )
			{
				l_errcd = "E";
				if("".equals(l_location_type.trim()) )
				{
					l_error.append("- Location Type cannot be empty ");
				}
			}
			
			if (l_errcd.equals("E"))
			{			
				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);				
				return "200#"+ l_responseJsonString +"#";			
			}
			
			
			String v_locn_type = validateLocnType(l_location_type);
			if(!v_locn_type.equals(l_location_type)){
				l_errcd = "E";
				l_error2.append("- Location - "+l_location_type+" - Does Not Exists in EM ");				
			}
			
			if (l_errcd.equals("E"))
			{
				l_app_msg = " ::: Inserting Request into Message Table while Location Type validation ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				l_responseJsonString = sendErrorResponse(actionKey, l_error2.toString(), l_request_ref_no, params);			
				
				return "200#"+ l_responseJsonString +"#";			
			}
			
			l_app_msg = " ::: Getting Request Location Code from JSON :::";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_location_code = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","location_code");
			l_app_msg = " ::: Location Code : " + l_location_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			if (l_location_code.indexOf("Error in") >= 0  || "".equals(l_location_code.trim())  )
			{
				l_errcd = "E";
				l_error.append("- Location Code cannot be empty ");
			}
			
			if (l_errcd.equals("E"))
			{			
				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);				
				return "200#"+ l_responseJsonString +"#";			
			}
			
			String v_locn_code = validateLocnCode(l_location_code, l_facility_id, l_location_type);
			if(!v_locn_code.equals(l_location_code)){
				l_errcd = "E";
				l_error2.append("- Location Code - "+l_location_code+" - Does Not Exists in EM ");				
			}
			
			if (l_errcd.equals("E"))
			{
				l_app_msg = " ::: Inserting Request into Message Table while Location Code validation ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);				
				l_responseJsonString = sendErrorResponse(actionKey, l_error2.toString(), l_request_ref_no, params);					
				return "200#"+ l_responseJsonString +"#";			
			}
			
			l_app_msg = " ::: Getting Request Service Code from JSON :::";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_service_code = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","service_code");
			l_app_msg = " ::: Service Code : " + l_service_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			if (l_service_code.indexOf("Error in") >= 0  || "".equals(l_service_code.trim())  )
			{
				l_errcd = "E";
				l_error.append("- Service Code cannot be empty");
			}
			
			if (l_errcd.equals("E"))
			{			
				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);				
				return "200#"+ l_responseJsonString +"#";			
			}
			
			String v_service_code = validateService(l_location_code, l_facility_id, l_service_code);
			if(!v_service_code.equals(l_service_code)){
				l_errcd = "E";
				l_error2.append("- Service Code - "+l_service_code+" - Does Not Exists in EM ");				
			}
			
			boolean v_visti = validateVisit(l_facility_id, l_patient_id, l_service_code);
			if(v_visti){
				l_errcd = "E";
				insertable = false;
				l_error2.append("- Patient already has a open visit for this clinic and service ");	
			}
			
			if (l_errcd.equals("E"))
			{
				l_app_msg = " ::: Inserting Request into Message Table while Service validation ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);				
				l_responseJsonString = sendErrorResponse(actionKey, l_error2.toString(), l_request_ref_no, params);					
				return "200#"+ l_responseJsonString +"#";			
			}
			
			l_app_msg = " ::: Getting Request Visit Type from JSON :::";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_visit_type = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","visit_type");
			l_app_msg = " ::: Visit Type : " + l_visit_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			if (l_visit_type.indexOf("Error in") >= 0  || "".equals(l_visit_type.trim())  )
			{
				l_errcd = "E";
				l_error.append("- Visit Type cannot be empty ");
			}
			
			if (l_errcd.equals("E"))
			{
				l_app_msg = " ::: Inserting Request into Message Table while Visit Type validation ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);				
				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);				
				return "200#"+ l_responseJsonString +"#";			
			}
			
			String v_visit_type = validateVisitType(l_facility_id, l_location_code, l_location_type, l_visit_type);
			if(!v_visit_type.equals(l_visit_type)){
				l_errcd = "E";
				l_error2.append("- Visit Type - "+l_visit_type+" - Does Not Exists in EM ");				
			}
			
			if (l_errcd.equals("E"))
			{
				l_app_msg = " ::: Inserting Request into Message Table while Visit Type validation ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);				
				l_responseJsonString = sendErrorResponse(actionKey, l_error2.toString(), l_request_ref_no, params);					
				return "200#"+ l_responseJsonString +"#";			
			}
			
			v_visit_type_validation_map = validateVisitTypeFirstORFollowup(l_facility_id, l_patient_id, l_location_code, l_visit_date_time);
	
			/*if(!l_visit_type.equals(v_visit_type_validation_map.get("f_visit_type_code"))){
				l_errcd = "E";
				l_error2.append("- Visit Type - "+l_visit_type+" - Not Allowed for Clinic  "+l_location_code+" Service "+l_service_code);
			}*/
			/*//f_visit_type_ind
			k_visit_type_ind = v_visit_type_validation_map.get("f_visit_type_ind"); 
			new_op_episode_yn = "";
			
			if(k_visit_type_ind.equals("F")){
				new_op_episode_yn = "Y";
			}else{
				new_op_episode_yn = "N";
			}*/
			
			if (l_errcd.equals("E"))
			{
				l_app_msg = " ::: Inserting Request into Message Table while Visit Type validation First or Followup ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);				
				l_responseJsonString = sendErrorResponse(actionKey, l_error2.toString(), l_request_ref_no, params);					
				return "200#"+ l_responseJsonString +"#";			
			}
			
			l_app_msg = " ::: Getting Request Practitioner ID from JSON :::";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_practitioner_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","practitioner_id");
			l_app_msg = " ::: Practitioner ID : " + l_practitioner_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			if (l_practitioner_id.indexOf("Error in") >= 0  || "".equals(l_practitioner_id.trim())  )
			{
				l_errcd = "E";
				l_error.append("- Practitioner Id cannot be empty ");
			}
			
			if (l_errcd.equals("E"))
			{			
				l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);				
				return "200#"+ l_responseJsonString +"#";			
			}
			
			String v_practitioner_id = validatePratitioner(l_practitioner_id);
			if(!v_practitioner_id.equals(l_practitioner_id)){
				l_errcd = "E";
				l_error2.append("- Practitioner Id - "+l_practitioner_id+" - Does Not Exists in EM ");				
			}
			
			if (l_errcd.equals("E"))
			{
				l_app_msg = " ::: Inserting Request into Message Table while Practitioner validation ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);				
				l_responseJsonString = sendErrorResponse(actionKey, l_error2.toString(), l_request_ref_no, params);					
				return "200#"+ l_responseJsonString +"#";			
			}
			
			if(l_in_JSON.contains("financial_details"))
			{
				System.out.println(" ::: Reading in Patient Data - Financial Details ::: ");
				Map<String, Object> patDocument = new HashMap<String, Object>(); 
				List<Integer> financial = null;
				
				try {
				
					patDocument = new ObjectMapper().readValue(l_in_JSON, new TypeReference<Map<String, Object>>() {});

					List<Object> patList = (List<Object>) patDocument.get("patient_data");
					Map<String, Object> patMap = (Map<String, Object>) patList.get(0);
					
					l_app_msg = " ::: patMap : " + patMap.toString();
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					financial = (List<Integer>) patMap.get("financial_details");
					
					l_app_msg = " ::: Financial size : " + financial.size();
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					if (financial.size()>0)
					{		
						List<Object> finList = (List<Object>) patMap.get("financial_details");
						Map<String, Object> finMap = (Map<String, Object>) finList.get(0);
						
						l_app_msg = " ::: Financial Map : " + finMap.toString();
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						
					}
				
				}catch (Exception e){
					System.out.println(e.getMessage());
				}
				
				if (financial.size()>0)
				{
					
					l_app_msg = " ::: Getting Request Financial Details from JSON :::";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_financial_details =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "financial_details");
					l_app_msg = " ::: Financial Details : " + l_financial_details;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_financial_details = l_financial_details.replace("[", "");
					l_financial_details = l_financial_details.replace("]", "");
					
					l_app_msg = " ::: Financial Details After remove [::: " + l_financial_details;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_app_msg = " ::: Getting Request Billing Group Code fron JSON : ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);					
					
					l_billing_group_code =XHJSONUtil.getJsonRequestString( l_financial_details , "billing_group_code");
					l_app_msg = " ::: Billing Group Code : " + l_billing_group_code;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					if (l_billing_group_code.indexOf("Error") >= 0 || l_billing_group_code.length() <= 1 )
					{
						l_errcd = "E";
						l_error2.append("- Billing Group Code cannot be empty ");
					}
					
					if("".equals(l_billing_group_code.trim()))
					{
						l_errcd = "E";
						l_error.append("- Billing Group Code cannot be blank ");
					}
					
					if (l_errcd.equals("E"))
					{			
						l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);				
						return "200#"+ l_responseJsonString +"#";			
					}
					
					params.put("ERR_MSG", "");
					
					Map<String, String> validateBlngMap = validateBlngGrp(l_billing_group_code);
					if(!l_billing_group_code.equals(validateBlngMap.get("BLNG_GRP_ID"))){
						l_errcd = "E";
						l_error2.append("- Billing Group Code : "+l_billing_group_code+" - Does Not Exists in EM ");
					}
					
					if (l_errcd.equals("E"))
					{
						l_app_msg = " ::: Inserting Request into Message Table while Billing Group validation ::: ";
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);						
						l_responseJsonString = sendErrorResponse(actionKey, l_error2.toString(), l_request_ref_no, params);							
						return "200#"+ l_responseJsonString +"#";			
					}
					
					if(!l_billing_group_code.equals("CASH"))
					{
						l_app_msg = " ::: Getting Request Payer Group Code fron JSON : ";
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);					
						
						l_payer_group_code =XHJSONUtil.getJsonRequestString( l_financial_details , "payer_group_code");
						l_app_msg = " ::: Payer Group Code : " + l_payer_group_code;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						
						if(l_payer_group_code.indexOf("Error") >= 0 || l_payer_group_code.length() <= 1 || l_payer_group_code.equals("")){
							l_errcd = "E";
							l_error.append(" - Payer Group cannot be blank ");
						}
						
						if (l_errcd.equals("E"))
						{			
							l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);				
							return "200#"+ l_responseJsonString +"#";			
						}
						
						String v_payer_grp_cd = validatePayerGrpCode(l_payer_group_code);
						
						if(!l_payer_group_code.equals(v_payer_grp_cd)){
							l_errcd = "E";
							l_error2.append(" - Payer Group Code - "+l_payer_group_code+" - Does Not Exists in EM ");
						}
						
						if (l_errcd.equals("E"))
						{
							l_app_msg = " ::: Inserting Request into Message Table while Payer Group Code validation ::: ";
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);							
							l_responseJsonString = sendErrorResponse(actionKey, l_error2.toString(), l_request_ref_no, params);								
							return "200#"+ l_responseJsonString +"#";			
						}
						
						
						l_app_msg = " ::: Getting Request Payer Code fron JSON : ";
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);					
						
						l_payer_code =XHJSONUtil.getJsonRequestString( l_financial_details , "payer_code");
						l_app_msg = " ::: Payer Code : " + l_payer_code;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						
						if(l_payer_code.indexOf("Error") >= 0 || l_payer_code.length() <= 1 || l_payer_code.equals("")){
							l_errcd = "E";
							l_error.append(" - Payer Code cannot be blank ");
						}
						
						if (l_errcd.equals("E"))
						{			
							l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);				
							return "200#"+ l_responseJsonString +"#";			
						}
						
						String v_payer_code = validatePayerCode(l_payer_group_code, l_payer_code);
						
						if(!l_payer_code.equals(v_payer_code)){
							l_errcd = "E";
							l_error2.append(" - Payer Code : "+l_payer_code+" - Does Not Exists in EM ");
						}
						
						if (l_errcd.equals("E"))
						{
							l_app_msg = " ::: Inserting Request into Message Table while Payer Code validation ::: ";
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);							
							l_responseJsonString = sendErrorResponse(actionKey, l_error2.toString(), l_request_ref_no, params);							
							return "200#"+ l_responseJsonString +"#";			
						}
						
						l_app_msg = " ::: Getting Request Policy Type Code fron JSON : ";
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						
						l_policy_type_code = XHJSONUtil.getJsonRequestString( l_financial_details , "policy_type_code");
						l_app_msg = " ::: Policy Type Code : " + l_policy_type_code;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						
						if(l_policy_type_code.equals("")){
							l_errcd = "E";
							l_error.append(" - Policy Type Code cannot be blank ");
						}
						
						if (l_errcd.equals("E"))
						{			
							l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);				
							return "200#"+ l_responseJsonString +"#";			
						}
						
						Map<String, String> v_insDetailsMap = validateInsDetails(l_payer_code, l_policy_type_code);
						
						l_app_msg = " ::: Validate Insurence : " + v_insDetailsMap;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						
						if(!l_policy_type_code.equals(v_insDetailsMap.get("POLICY_TYPE_CODE"))){
							l_errcd = "E";
							l_error2.append(" - Policy Type Code : "+l_policy_type_code+" - Does Not Exists in EM ");
						}
						
						if (l_errcd.equals("E"))
						{
							l_app_msg = " ::: Inserting Request into Message Table while Policy Type Code validation ::: ";
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);							
							l_responseJsonString = sendErrorResponse(actionKey, l_error2.toString(), l_request_ref_no, params);								
							return "200#"+ l_responseJsonString +"#";			
						}
						
						l_app_msg = " ::: Getting Request Policy Number fron JSON : ";
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						
						l_policy_number = XHJSONUtil.getJsonRequestString( l_financial_details , "policy_number");
						l_app_msg = " ::: Policy Number : " + l_policy_number;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						
						if(l_policy_number.equals("")){
							l_errcd = "E";
							l_error.append(" - Policy No cannot be blank ");
						}
						
						if (l_errcd.equals("E"))
						{			
							l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);				
							return "200#"+ l_responseJsonString +"#";			
						}
						
						l_app_msg = " ::: Getting Request Policy Start Date fron JSON : ";
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						
						l_policy_start_date = XHJSONUtil.getJsonRequestString( l_financial_details , "policy_start_date");
						l_app_msg = " ::: Policy Start Date : " + l_policy_start_date;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						
						if(l_policy_start_date.equals("")){
							l_errcd = "E";
							l_error.append(" - Policy Start Date cannot be blank ");
						}
						
						if (l_errcd.equals("E"))
						{			
							l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);				
							return "200#"+ l_responseJsonString +"#";			
						}
						
						String v_start_date = formatDate(v_insDetailsMap.get("POLICY_EFF_FROM"));
						
						if(!l_policy_start_date.equals(v_start_date)){
							l_errcd = "E";
							l_error2.append(" - Policy Start Date : "+l_policy_start_date+" - Does Not Exists in EM ");
						}
						
						if (l_errcd.equals("E"))
						{
							l_app_msg = " ::: Inserting Request into Message Table while Policy Start Date validation ::: ";
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							
							l_responseJsonString = sendErrorResponse(actionKey, l_error2.toString(), l_request_ref_no, params);			
							
							return "200#"+ l_responseJsonString +"#";			
						}
						
						l_app_msg = " ::: Getting Request Policy End Date fron JSON : ";
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						
						l_policy_end_date = XHJSONUtil.getJsonRequestString( l_financial_details , "policy_end_date");
						l_app_msg = " ::: Policy End Date : " + l_policy_end_date;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						
						if(l_policy_end_date.equals("")){
							l_errcd = "E";
							l_error2.append(" - Policy Expiry Date cannot be blank ");
						}
						
						if (l_errcd.equals("E"))
						{			
							l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);				
							return "200#"+ l_responseJsonString +"#";			
						}
						
						String v_end_date = formatDate(v_insDetailsMap.get("POLICY_EFF_TO"));
						
						if(!l_policy_end_date.equals(v_end_date)){
							l_errcd = "E";
							l_error2.append("- Policy Start Date : "+l_policy_end_date+" - Does Not Exists in EM ");
						}
						
						if (l_errcd.equals("E"))
						{
							l_app_msg = " ::: Inserting Request into Message Table while Policy End Date validation ::: ";
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							
							l_responseJsonString = sendErrorResponse(actionKey, l_error2.toString(), l_request_ref_no, params);			
							
							return "200#"+ l_responseJsonString +"#";			
						}
						
						l_app_msg = " ::: Getting Request Priority fron JSON : ";
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						
						l_priority = XHJSONUtil.getJsonRequestString( l_financial_details , "priority");
						l_app_msg = " ::: Priority : " + l_priority;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						
						if("".equals(l_priority.trim())){
							l_errcd = "E";
							l_error2.append(" - Priority cannot be blank ");
						}
						
						if(!"".equals(l_priority.trim()) && Integer.parseInt(l_priority) == 0){
							l_errcd = "E";
							l_error2.append(" - Priority cannot be zero ");
						}
						
						if (l_errcd.equals("E"))
						{
							l_app_msg = " ::: Inserting Request into Message Table while Priority validation ::: ";
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							
							l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);			
							
							return "200#"+ l_responseJsonString +"#";			
						}
						
						l_app_msg = " ::: Getting Request Non Insurence Billing Group ID fron JSON : ";
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						
						l_non_ins_blng_grp_id = XHJSONUtil.getJsonRequestString( l_financial_details , "non_ins_blng_grp_id");
						l_app_msg = " ::: Non Insurence Billing Group ID : " + l_non_ins_blng_grp_id;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						
						if ("".equals(l_non_ins_blng_grp_id.trim()))
						{
							l_errcd = "E";
							l_error2.append("- Non Insurance Billing Group cannot be blank ");
						}
						
						if(!l_non_ins_blng_grp_id.equals(validateBlngMap.get("NON_INS_BLNG_GRP_ID"))){
							l_errcd = "E";
							l_error2.append(" - Invalid Billing Group Code - "+l_non_ins_blng_grp_id+" - Does Not Exists in EM ");			
						}
						if (l_errcd.equals("E"))
						{
							l_app_msg = " ::: Inserting Request into Message Table while Non Insurence Billing Group validation ::: ";
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							
							l_responseJsonString = sendErrorResponse(actionKey, l_error2.toString(), l_request_ref_no, params);			
							
							return "200#"+ l_responseJsonString +"#";			
						}
					}
					
				}
			
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
			
			l_episode_no = v_visit_type_validation_map.get("f_episode_id");
			l_app_msg = " ::: Episode No : "+l_episode_no;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_app_msg = " ::: After Search  l_errcd ::: "+l_errcd +" ::: l_searchcd ::: "+l_searchcd;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_app_msg = " ::: Fetching Episode ID and Visit Number :::";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			episodeMap = fetchEpisodeIDVisitNum(l_facility_id, l_patient_id, l_episode_no, l_location_code);
			//episodeMap = fetchEpisodeIDVisitNum(l_facility_id, l_patient_id, l_location_code);
			
			l_visitno = episodeMap.get("visit_num");
			if (l_visitno == null)
				l_visitno = "0001";
			if (l_visitno.length() >= 4)
				l_visitno = l_visitno.substring(l_visitno.length()-1);
			
			l_app_msg = " ::: Visit Number :"+l_visitno;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			
			k_visit_type_ind = v_visit_type_validation_map.get("f_visit_type_ind"); 
			new_op_episode_yn = "";
			
			if(k_visit_type_ind.equals("F")){
				new_op_episode_yn = "Y";
				l_visitno = "1";
			}else{
				new_op_episode_yn = "N";
			}
			//l_episode_id = fetchEpisodeID(l_facility_id);
			
			encounterMap = generateEncounterID(l_episode_no, l_visitno, l_facility_id, added_by_id, added_at_ws_no);
			
			l_app_msg = " ::: insertable after calling generateEncounterID : "+insertable+" ::: Error Code : "+l_errcd;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_encounter_id = encounterMap.get("encounterid");
			
			l_app_msg = " ::: Encounter ID : "+l_encounter_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_visitnum = encounterMap.get("visitnum");
			if(l_visitnum == null)
				l_visitnum = "";
			
			l_app_msg = " ::: Visit Number from GenerateEncounterID : "+l_visitnum;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_episode_no = encounterMap.get("episodeno");
			if(l_episode_no == null)
				l_episode_no = "";
			
			l_app_msg = " ::: Episode No from GenerateEncounterID : "+l_episode_no;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			clinicMap = fetchClinicDetails(l_facility_id, l_location_code);
			
			l_app_msg = " ::: Fetching Assign Queue Number BY From OP Param : ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			try
			{
				String queueNumByQuery = "select action_on_pract_schedule,ASSIGN_QUEUE_NUM_BY,use_template_in_vis_regn_yn, to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sys," +
						                 "to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_new, OVERRIDE_PRACT_FOR_APPT_YN, OVERRIDE_VTYPE_ON_EPSD_YN,VISIT_BACKDATE_DAYS," +
						                 " to_char((sysdate - NVL(VISIT_BACKDATE_DAYS,0)),'dd/mm/yyyy hh24:mi:ss') sys1,VISIT_TYPE_DERV_RULE from op_param where " +
						                 "operating_facility_id='"+l_facility_id+"'";
				
				l_app_msg = " ::: queueNumByQuery : "+queueNumByQuery;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				con =  EMDataSource.getConnection();
				pstmt= con.prepareStatement(queueNumByQuery);
				rset = pstmt.executeQuery();
				
				while(rset.next()){
					l_ASSIGN_QUEUE_NUM_BY = rset.getString("ASSIGN_QUEUE_NUM_BY");
					l_VISIT_TYPE_DERV_RULE = rset.getString("VISIT_TYPE_DERV_RULE");
				}
				
				l_app_msg = " ::: ASSIGN QUEUE NUM BY : "+l_ASSIGN_QUEUE_NUM_BY;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				l_app_msg = " ::: Visit Type Derv Rule : "+l_VISIT_TYPE_DERV_RULE;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
			}catch(Exception e)
			{
				l_app_msg = "Eception in Fetching Assign Queue Number BY : "+e.getMessage();
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				e.printStackTrace();
			}		
			finally {
				XHUtil.closeDBResources(rset, pstmt, null);
				EMDataSource.returnConnection(con);
			}
			
			l_app_msg = " ::: Fetching Appointment ID ::: ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			try{
				String apptQuery = "SELECT (select action_on_pract_schedule from op_param where OPERATING_FACILITY_ID='"+l_facility_id+"' ) action_on_pract_schedule," +
						"TO_CHAR(SYSDATE,'dd/mm/yyyy') Sys_date,A.patient_id patient_id ,TO_CHAR(A.QUEUE_DATE,'dd/mm/yyyy hh24:mi') visit_adm_date_time, " +
						"decode(A.APPT_OR_WALK_IN_IND, 'A', 'Y', 'N') appt_case_yn , A.APPT_OR_WALK_IN_IND APPT_OR_WALK_IN_IND , A.appt_id appt_id ," +
						"A.SPECIALITY_CODE specialty_code ,null patient_type ,A.referral_id referral_id, A.episode_id episode_id ,A.OP_EPISODE_VISIT_NUM OP_EPISODE_VISIT_NUM ," +
						"B.SEX gender ,TO_CHAR(b.DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH, d.long_desc LOCN_DESC , A.locn_type ASSIGN_CARE_LOCN_TYPE  ," +
						"AM_GET_DESC.AM_CARE_LOCN_TYPE(A.LOCN_TYPE,'"+l_locale+"','2') LOCN_TYPE_DESC   ,am_get_desc.AM_SERVICE(A.SERVICE_CODE,'"+l_locale+"',2) service_desc ," +
						"DECODE (A.LOCN_TYPE,'N', NULL, d.open_to_all_pract_yn) cur_open_to_all_pract_yn ,op_get_desc.op_visit_type(a.facility_id,a.VISIT_TYPE_CODE,'"+l_locale+"',2) " +
						"visit_type_desc  ,NULL  RESCLASS , c.pract_type  RESTYPE ,A.LOCN_CODE CUR_LOCN_CODE ,A.LOCN_TYPE CUR_LOCN_TYPE ,A.SERVICE_CODE CUR_SERVICE_CODE , " +
						"A.PRACTITIONER_ID CUR_PRACTITIONER_ID, c.practitioner_name pract_name ,c.pract_type CUR_PRACT_TYPE , am_get_desc.am_pract_type(c.pract_type,'"+l_locale+"',2)  " +
						"PRACT_TYPE_DESC , d.level_of_care_ind CUR_LEVEL_OF_CARE_IND, A.VISIT_TYPE_CODE VISIT_TYPE_CODE ,decode(A.APPT_OR_WALK_IN_IND, 'A', 'Y', 'N') VISIT_CASE  ," +
						"A.VISIT_TYPE_IND CUR_VISIT_TYPE_IND ,op_get_desc.op_visit_type(a.facility_id,a.visit_type_code,'"+l_locale+"',2) VISIT_DESC  ,A.VISIT_TYPE_code P_CUR_VISIT_TYPE_CODE, " +
						"A.SUBSERVICE_CODE SUBSERVICE_CODE  ,am_get_desc.am_subService(a.service_code,a.subservice_code,'"+l_locale+"',2) SUBSERVICE_DESC, A.ROOM_NUM ROOM_NUM ," +
						"A.REVISE_REASON_CODE REVISE_REASON_CODE , A.CONTACT_REASON_CODE CONTACT_REASON_CODE  , am_get_desc.am_contact_reason(a.contact_reason_code,'"+l_locale+"',1) " +
						"REASON_FOR_CONTACT  ,A.OTHER_RES_CLASS OTHER_RES_CLASS , A.OTHER_RESOURCE_ID OTHER_RESOURCE_ID , am_get_desc.AM_RESOURCE(a.facility_id,a.other_resource_id,'"+l_locale+"',2)  " +
						"other_resource_desc, A.QUEUE_ID QUEUE_ID, d.primary_resource_class, d.ident_at_checkin, d.allow_referral_yn, (select entitlement_by_pat_cat_yn from mp_param where module_id = 'MP') " +
						"entitlement_by_pat_cat_yn FROM OP_PATIENT_QUEUE A, MP_PATIENT B, am_practitioner_lang_vw C, op_clinic d WHERE A.FACILITY_ID = '"+l_facility_id+"'  AND A.ENCOUNTER_ID = '"+l_encounter_id+"' " +
						"AND A.PATIENT_CLASS = 'OP' AND a.patient_id = b.patient_id AND d.clinic_code = a.locn_code and d.facility_id = a.facility_id and  C.practitioner_id(+)=A.practitioner_id and c.language_id (+)= '"+l_locale+"'";
				
				l_app_msg = " ::: apptQuery : "+apptQuery;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				con =  EMDataSource.getConnection();
				pstmt= con.prepareStatement(apptQuery);
				rset = pstmt.executeQuery();
				while(rset.next()){
					l_appt_id = rset.getString("appt_id");
					  if(l_appt_id == null) l_appt_id = "";
				}
				
				l_app_msg = " ::: Appointment ID : "+l_appt_id;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
			}catch(Exception e)
			{
				l_app_msg = "Eception in Fetching Appointment ID : "+e.getMessage();
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				e.printStackTrace();
			}		
			finally {
				XHUtil.closeDBResources(rset, pstmt, null);
				EMDataSource.returnConnection(con);
			}
			
			if(!l_appt_id.equals(""))
			{
			
				l_app_msg = " ::: Fetching Appointment Time ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				try{
					String apptTimeQuery = "SELECT to_char(appt_time,'dd/mm/yyyy hh24:mi'), appt_status, mr_request_id, REFERRAL_ID FROM oa_appt WHERE APPT_REF_NO = ? and FACILITY_ID =?";
					
					l_app_msg = " ::: apptTimeQuery : "+apptTimeQuery;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					con =  EMDataSource.getConnection();
					pstmt= con.prepareStatement(apptTimeQuery);
					rset = pstmt.executeQuery();
					while(rset.next()){
						l_appt_time = rset.getString(1);
						l_appt_status = rset.getString(2);
						l_request_id = rset.getString(3);
						l_refferal_id=rset.getString("REFERRAL_ID")==null?"":rset.getString("REFERRAL_ID");
					}
					
					l_app_msg = " ::: Appointment Time : "+l_appt_time+" ::: Appt Status : "+l_appt_status+" ::: Appt Req Id : "+l_request_id+" ::: Refferal Id :"+l_refferal_id;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					
				}catch(Exception e)
				{
					l_app_msg = "Eception in Fetching Appointment ID : "+e.getMessage();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					e.printStackTrace();
				}		
				finally {
					XHUtil.closeDBResources(rset, pstmt, null);
					EMDataSource.returnConnection(con);
				}
			}
			
			l_app_msg = " ::: Fetching Appointment Status ::: ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Fetching QMS INTERFACED YN From OP Clinic : ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			try
			{
				String QMSInterfacedYNQuery = "select QMS_INTERFACED_YN from op_clinic where FACILITY_ID=? and clinic_code =?";
				
				con =  EMDataSource.getConnection();
				pstmt= con.prepareStatement(QMSInterfacedYNQuery);
				pstmt.setString(1, l_facility_id);
				pstmt.setString(2, l_location_code);
				rset = pstmt.executeQuery();
				
				while(rset.next()){
					l_QMS_INTERFACED_YN = rset.getString("QMS_INTERFACED_YN");
				}
				
				l_app_msg = " ::: QMS INTERFACED YN : "+l_ASSIGN_QUEUE_NUM_BY;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
			}catch(Exception e)
			{
				l_app_msg = "Eception in Fetching QMS INTERFACED YN : "+e.getMessage();
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				e.printStackTrace();
			}		
			finally {
				XHUtil.closeDBResources(rset, pstmt, null);
				EMDataSource.returnConnection(con);
			}
			
			l_app_msg = " ::: Fetching values from OP Clinic : "+insertable+" ::: Error Code : "+l_errcd;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			String ct_date = "";
			
			try{
				String OPClinicQuery = "select clinic_type,speciality_code, dept_code,to_char(sysdate,'dd/mm/yyyy') ct_date,online_mr_notfn_yn,mr_location_code from op_clinic where clinic_code = '"
							+ l_location_code
							+ "' and facility_id='"
							+ l_facility_id + "'";
				
				con =  EMDataSource.getConnection();
				pstmt= con.prepareStatement(OPClinicQuery.toString());
				rset = pstmt.executeQuery();
				
				while(rset.next()){
					String assign_care_locn_type = rset.getString(1);
					String specialty_code = rset.getString(2);
					String dept_code = rset.getString(3);
					ct_date = rset.getString("ct_date");
					String online_mr_notfn_yn = rset.getString("online_mr_notfn_yn");
					String fs_locn_code	   = rset.getString("mr_location_code");
				}
				
				
			}catch(Exception e)
			{
				l_app_msg = "Eception in Fetching QMS INTERFACED YN : "+e.getMessage();
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				e.printStackTrace();
			}		
			finally {
				XHUtil.closeDBResources(rset, pstmt, null);
				EMDataSource.returnConnection(con);
			}
			
			l_app_msg = " ::: insertable while OP_QUEUE_NUM_FOR_LOCN_PRC : "+insertable+" ::: Error Code : "+l_errcd;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			if(insertable){
					
					l_app_msg = " ::: Calling OP_QUEUE_NUM_FOR_LOCN_PRC : ";
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					
					try{
						if(l_ASSIGN_QUEUE_NUM_BY.equals("S")){
							
							if(l_QMS_INTERFACED_YN.equals("N")){
						
								con = EMDataSource.getConnection();
								cstmt = con.prepareCall("{call OP_QUEUE_NUM_FOR_LOCN_PRC(?,?,?,?,?,?,?,?,?,?,?,null,null,?,?)}");
								
								System.out.println(" ::: OP_QUEUE_NUM_FOR_LOCN_PRC : facilityid : "+l_facility_id+" : ct_date : "+ct_date+" : l_location_type : "+l_location_type+" : l_location_code : "+l_location_code+" : l_practitioner_id : "+l_practitioner_id+" : l_p_id : "+l_p_id);
								cstmt.setString(1, l_facility_id);
								cstmt.setString(2, ct_date);
								cstmt.setString(3, l_location_type);
								cstmt.setString(4, l_location_code);
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
		
								if (l_queueID == null || l_queueID.equals("")	|| l_queueID.equals("null"))
									l_queueID = "";
		
								if (l_quenum >= 0) {
									insertable = true;
									l_quenum = l_quenum;
								} else if (l_quenum == -1) {
									insertable = false;
								}
								
								l_app_msg = " ::: QuenID : "+l_queueID+"  ::: Quenum : "+l_quenum;
								if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							}
						}						
						
					}catch (Exception e) {
						l_app_msg = " ::: Exception in OP_QUEUE_NUM_FOR_LOCN_PRC : "+ e.getMessage();
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						e.printStackTrace();
					} finally {
						EMDataSource.returnConnection(con);
						XHUtil.closeDBResources(null, cstmt, null);
					}
		   }
			
			l_app_msg = " ::: Fetching Settlement ind & Adm rec flag ::: ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			try {
				
				con = EMDataSource.getConnection();
				String stlmtIndQurey = "select settlement_ind, adm_rec_flag from bl_blng_grp where blng_grp_id = ? ";

				con = EMDataSource.getConnection();

				pstmt = con.prepareStatement(stlmtIndQurey);
				pstmt.setString(1, l_billing_group_code);

				rset = pstmt.executeQuery();

				while (rset.next()) {
					l_slmt_ind = rset.getString("settlement_ind");
					l_adm_rec_flag = rset.getString("adm_rec_flag");
				}
				
				l_app_msg = " ::: Settlement Ind : "+l_slmt_ind+" ::: ADM Rec Flag : "+l_adm_rec_flag;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			} catch (Exception e) {
				l_app_msg = " Exception in Fetching Settlement Ind, ADM Reg Flag : "+e.getMessage();
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				e.printStackTrace();
			} finally {
				EMDataSource.returnConnection(con);
				XHUtil.closeDBResources(rset, pstmt, null);
			}
			
			l_app_msg = " ::: Fetching ASSESSMENT_MONTHS ::: ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			
			try{
				String blParamQuery = "Select AUTO_FIN_CLASSFCTN_IN_USE_YN,ASSESSMENT_MONTHS from BL_PARAMETERS Where OPERATING_FACILITY_ID = '"+l_facility_id+"'";
				pstmt = con.prepareStatement(blParamQuery);
				rset = pstmt.executeQuery() ;
				if( rset != null ) 
				{
					while( rset.next() )
					{  
						l_fin_class_flag_YN = rset.getString("AUTO_FIN_CLASSFCTN_IN_USE_YN");
						l_assessmentMonths = rset.getInt("ASSESSMENT_MONTHS");
					}
					
					l_app_msg = " ::: AUTO FIN CLASSFCTN IN_USE YN : "+l_fin_class_flag_YN+" ::: ASSESSMENT MONTHS : "+l_assessmentMonths;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				}
				
			}catch(Exception e){
				l_app_msg = "Execption call ASSESSMENT_MONTHS in  : "+e.getMessage();
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				e.printStackTrace();
				
			}finally {
				EMDataSource.returnConnection(con);
				XHUtil.closeDBResources(rset, pstmt, null);
			}
			
			l_app_msg = " ::: Fetching Financial Required Values ::: ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			try{
				
				String finQuery = "select blng_grp_id,settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc , " +
						"slmt_doc_ref_date,slmt_doc_remarks,cust_group_code,cust_code,credit_doc_ref_desc,credit_doc_ref_start_date, credit_doc_ref_date," +
						"non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents," +
						"resp_for_bill_payment,pat_reln_with_resp_pers,remarks,financial_remarks,gl_holder_name,pat_reln_with_gl_holder, REFERRAL_SOURCE_CODE_MAIN," +
						"REFERRAL_SOURCE_CODE_SUB,NON_INS_REF_SOURCE_CODE_MAIN,NON_INS_REF_SOURCE_CODE_SUB,episode_id,visit_id,IS_SPECIAL_CLINIC_RELATED," +
						"NO_OF_ENC_GL_VALID,NO_OF_OP_ENC_GL_VALID,NO_OF_AE_ENC_GL_VALID,NO_OF_IP_ENC_GL_VALID,NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND," +
						"PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ," +
						"CLASSIFICATION_CODE,CLASSIFICATION_TYPE,CLASSIFICATION_START_DATE,CLASSIFICATION_END_DATE,SOCIAL_PENSIONER_ID,LAST_DATE from (select b.blng_grp_id," +
						"b.settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc ,to_char(slmt_doc_ref_date,'dd/mm/yyyy') slmt_doc_ref_date," +
						"slmt_doc_remarks,b.cust_group_code,b.cust_code,credit_doc_ref_desc,to_char(credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date," +
						"to_char(credit_doc_ref_date,'dd/mm/yyyy') credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income," +
						"family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,financial_remarks,gl_holder_name,pat_reln_with_gl_holder" +
						",blcommon.BL_VALID_REF_SOURCE_CODE(b.REFERRAL_SOURCE_CODE_MAIN,?) REFERRAL_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(b.REFERRAL_SOURCE_CODE_SUB,?) " +
						"REFERRAL_SOURCE_CODE_SUB,blcommon.BL_VALID_REF_SOURCE_CODE(NON_INS_REF_SOURCE_CODE_MAIN,?) NON_INS_REF_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE" +
						"(NON_INS_REF_SOURCE_CODE_SUB,?) NON_INS_REF_SOURCE_CODE_SUB,null episode_id,null visit_id,null IS_SPECIAL_CLINIC_RELATED,null NO_OF_ENC_GL_VALID," +
						"null NO_OF_OP_ENC_GL_VALID,null NO_OF_AE_ENC_GL_VALID,null NO_OF_IP_ENC_GL_VALID,null NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND," +
						"PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ," +
						"CLASSIFICATION_CODE,CLASSIFICATION_TYPE,to_char(CLASSIFICATION_START_DATE,'DD/MM/YYYY') CLASSIFICATION_START_DATE," +
						"to_char(CLASSIFICATION_END_DATE,'DD/MM/YYYY') CLASSIFICATION_END_DATE,SOCIAL_PENSIONER_ID, to_char(add_months(CLASSIFICATION_START_DATE,?),'dd/mm/yyyy')" +
						" LAST_DATE from bl_patient_fin_dtls a, BL_ENCOUNTER_PAYER_PRIORITY b where a.patient_id =? and a.patient_id = b.patient_id and b.episode_type='R' " +
						"and  b.ACCT_SEQ_NO=a.CUR_ACCT_SEQ_NO and (a.non_ins_blng_grp_id is null or (a.non_ins_blng_grp_id is not null and b.PRIORITY is not null)) " +
						"and exists (Select 'X' from bl_blng_grp c where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR" +
						" (?='DC' AND DY_YN='Y')) and b.blng_grp_id=c.blng_grp_id) order by b.added_date  desc /*order by B.PRIORITY*/) where rownum=1";
				
				l_app_msg = " ::: finQuery : "+finQuery;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				con = EMDataSource.getConnection();
				pstmt = con.prepareStatement(finQuery, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				
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
				
				rset = pstmt.executeQuery();
				
				while(rset.next()){
					
					l_slmt_type_code = rset.getString("slmt_type_code");
					if(l_slmt_type_code == null) l_slmt_type_code = "";
					System.out.println(" ::: Settlement Type Code : "+l_slmt_type_code);
					
					l_REFERRAL_SOURCE_CODE_MAIN = rset.getString("REFERRAL_SOURCE_CODE_MAIN");
					if(l_REFERRAL_SOURCE_CODE_MAIN == null) l_REFERRAL_SOURCE_CODE_MAIN = "";
					System.out.println(" ::: l_REFERRAL_SOURCE_CODE_MAIN : "+l_REFERRAL_SOURCE_CODE_MAIN);
					
					l_REFERRAL_SOURCE_CODE_SUB = rset.getString("REFERRAL_SOURCE_CODE_SUB");
					if(l_REFERRAL_SOURCE_CODE_SUB == null) l_REFERRAL_SOURCE_CODE_SUB = "";
					System.out.println(" ::: l_REFERRAL_SOURCE_CODE_SUB : "+l_REFERRAL_SOURCE_CODE_SUB);
					
					l_employer_code = rset.getString("employer_code");
					if(l_employer_code == null) l_employer_code = "";
					System.out.println(" ::: l_employer_code : "+l_employer_code);
					
					l_cust_group_code = rset.getString("cust_group_code");
					if(l_cust_group_code == null ) l_cust_group_code = "";
					System.out.println(" ::: l_cust_group_code : "+l_cust_group_code);
					
					l_cust_code = rset.getString("cust_code");
					if(l_cust_code == null) l_cust_code = "";
					System.out.println(" ::: l_cust_code : "+l_cust_code);
					
					l_credit_doc_ref_desc = rset.getString("credit_doc_ref_desc");
					if(l_credit_doc_ref_desc == null) l_credit_doc_ref_desc = "";
					System.out.println(" ::: l_credit_doc_ref_desc : "+l_credit_doc_ref_desc);
					
					l_credit_doc_ref_start_date = rset.getString("credit_doc_ref_start_date");
					if(l_credit_doc_ref_start_date == null) l_credit_doc_ref_start_date = "";
					System.out.println(" ::: l_credit_doc_ref_start_date : "+l_credit_doc_ref_start_date);
					
					l_credit_doc_ref_date = rset.getString("credit_doc_ref_date");
					if(l_credit_doc_ref_date == null) l_credit_doc_ref_date = "";
					System.out.println(" ::: l_credit_doc_ref_date : "+l_credit_doc_ref_date);
					
					l_slmt_doc_ref_desc = rset.getString("slmt_doc_ref_desc");
					if(l_slmt_doc_ref_desc == null) l_slmt_doc_ref_desc ="";
					System.out.println(" ::: slmt_doc_ref_desc : "+l_slmt_doc_ref_desc);
					
					l_slmt_doc_ref_date = rset.getString("slmt_doc_ref_date");
					if(l_slmt_doc_ref_date == null) l_slmt_doc_ref_date = "";
					System.out.println(" ::: l_slmt_doc_ref_date : "+l_slmt_doc_ref_date);
					
					l_slmt_doc_remarks = rset.getString("slmt_doc_remarks");
					if(l_slmt_doc_remarks == null) l_slmt_doc_remarks = "";
					System.out.println(" ::: l_slmt_doc_remarks : "+l_slmt_doc_remarks);
					
					l_non_ins_blng_grp_id = rset.getString("non_ins_blng_grp_id");
					if(l_non_ins_blng_grp_id == null ) l_non_ins_blng_grp_id = "";
					System.out.println(" ::: l_non_ins_blng_grp_id : "+l_non_ins_blng_grp_id);
					
					l_NON_INS_REF_SOURCE_CODE_MAIN = rset.getString("NON_INS_REF_SOURCE_CODE_MAIN");
					if(l_NON_INS_REF_SOURCE_CODE_MAIN == null ) l_NON_INS_REF_SOURCE_CODE_MAIN = "";
					System.out.println(" ::: l_NON_INS_REF_SOURCE_CODE_MAIN : "+l_NON_INS_REF_SOURCE_CODE_MAIN);
					
					l_NON_INS_REF_SOURCE_CODE_SUB = rset.getString("NON_INS_REF_SOURCE_CODE_SUB");
					if(l_NON_INS_REF_SOURCE_CODE_SUB == null ) l_NON_INS_REF_SOURCE_CODE_SUB = "";
					System.out.println(" ::: l_NON_INS_REF_SOURCE_CODE_SUB : "+l_NON_INS_REF_SOURCE_CODE_SUB);
					
					l_non_ins_cust_group_code = rset.getString("non_ins_cust_group_code");
					if(l_non_ins_cust_group_code == null) l_non_ins_cust_group_code = "";
					System.out.println(" ::: l_non_ins_cust_group_code : "+l_non_ins_cust_group_code);
					
					l_non_ins_cust_code = rset.getString("non_ins_cust_code");
					if(l_non_ins_cust_code == null) l_non_ins_cust_code = "";
					System.out.println(" ::: l_non_ins_cust_code : "+l_non_ins_cust_code);
					
					l_annual_family_income = rset.getString("annual_family_income");
					if(l_annual_family_income == null ) l_annual_family_income = "";
					System.out.println(" ::: l_annual_family_income : "+l_annual_family_income);
					
					l_family_assets_value = rset.getString("family_assets_value");
					if(l_family_assets_value == null) l_family_assets_value = "";
					System.out.println(" ::: l_family_assets_value : "+l_family_assets_value);
					
					l_num_of_dependents = rset.getString("num_of_dependents");
					if(l_num_of_dependents == null) l_num_of_dependents = "";
					System.out.println(" ::: l_num_of_dependents : "+l_num_of_dependents);
					
					l_resp_for_bill_payment = rset.getString("resp_for_bill_payment");
					if(l_resp_for_bill_payment == null ) l_resp_for_bill_payment = "";
					System.out.println(" ::: l_resp_for_bill_payment : "+l_resp_for_bill_payment);
					
					l_pat_reln_with_resp_pers = rset.getString("pat_reln_with_resp_pers");
					if(l_pat_reln_with_resp_pers == null) l_pat_reln_with_resp_pers = "";
					System.out.println(" ::: l_pat_reln_with_resp_pers : "+l_pat_reln_with_resp_pers);
					
					l_gl_holder_name =rset.getString("gl_holder_name");
					if(l_gl_holder_name == null ) l_gl_holder_name = "";
					System.out.println(" ::: l_gl_holder_name : "+l_gl_holder_name);
					
					l_pat_reln_with_gl_holder = rset.getString("pat_reln_with_gl_holder");
					if(l_pat_reln_with_gl_holder == null) l_pat_reln_with_gl_holder = "";
					System.out.println(" ::: l_pat_reln_with_gl_holder : "+l_pat_reln_with_gl_holder);
					
					l_NO_OF_ENC_GL_VALID = rset.getString("NO_OF_ENC_GL_VALID");
					if(l_NO_OF_ENC_GL_VALID == null) l_NO_OF_ENC_GL_VALID = "";
					System.out.println(" ::: l_NO_OF_ENC_GL_VALID : "+l_NO_OF_ENC_GL_VALID);
					
					l_NO_OF_AE_ENC_GL_VALID = rset.getString("NO_OF_AE_ENC_GL_VALID");
					if(l_NO_OF_AE_ENC_GL_VALID == null) l_NO_OF_AE_ENC_GL_VALID = "";
					System.out.println(" ::: l_NO_OF_AE_ENC_GL_VALID : "+l_NO_OF_AE_ENC_GL_VALID);
					
					l_NO_OF_OP_ENC_GL_VALID = rset.getString("NO_OF_OP_ENC_GL_VALID");
					if(l_NO_OF_OP_ENC_GL_VALID == null) l_NO_OF_OP_ENC_GL_VALID = "";
					System.out.println(" ::: l_NO_OF_OP_ENC_GL_VALID : "+l_NO_OF_OP_ENC_GL_VALID);
					
					l_NO_OF_IP_ENC_GL_VALID = rset.getString("NO_OF_IP_ENC_GL_VALID");
					if(l_NO_OF_IP_ENC_GL_VALID == null) l_NO_OF_IP_ENC_GL_VALID = "";
					System.out.println(" ::: l_NO_OF_IP_ENC_GL_VALID : "+l_NO_OF_IP_ENC_GL_VALID);
					
					l_NO_OF_DC_ENC_GL_VALID = rset.getString("NO_OF_DC_ENC_GL_VALID");
					if(l_NO_OF_DC_ENC_GL_VALID == null ) l_NO_OF_DC_ENC_GL_VALID = "";
					System.out.println(" ::: l_NO_OF_DC_ENC_GL_VALID : "+l_NO_OF_DC_ENC_GL_VALID);
					
					l_remarks = rset.getString("remarks");
					if(l_remarks == null) l_remarks = "";
					System.out.println(" ::: l_remarks : "+l_remarks);
					
					l_PATIENT_INC_ASSET_IND = rset.getString("PATIENT_INC_ASSET_IND");
					if(l_PATIENT_INC_ASSET_IND == null) l_PATIENT_INC_ASSET_IND = "";
					System.out.println(" ::: l_PATIENT_INC_ASSET_IND : "+l_PATIENT_INC_ASSET_IND);
					
					l_PATIENT_INC_ASSET_AMT = rset.getString("PATIENT_INC_ASSET_AMT");
					if(l_PATIENT_INC_ASSET_AMT == null ) l_PATIENT_INC_ASSET_AMT = "";
					System.out.println(" ::: l_PATIENT_INC_ASSET_AMT : "+l_PATIENT_INC_ASSET_AMT);
					
					l_PATIENT_INC_ASSET_FREQ = rset.getString("PATIENT_INC_ASSET_FREQ");
					if(l_PATIENT_INC_ASSET_FREQ == null) l_PATIENT_INC_ASSET_FREQ = "";
					System.out.println(" ::: l_PATIENT_INC_ASSET_FREQ : "+l_PATIENT_INC_ASSET_FREQ);
					
					l_SPOUSE_INC_ASSET_AMT = rset.getString("SPOUSE_INC_ASSET_AMT");
					if(l_SPOUSE_INC_ASSET_AMT == null ) l_SPOUSE_INC_ASSET_AMT = "";
					System.out.println(" ::: l_SPOUSE_INC_ASSET_AMT : "+l_SPOUSE_INC_ASSET_AMT);
					
					l_SPOUSE_INC_ASSET_FREQ = rset.getString("SPOUSE_INC_ASSET_FREQ");
					if(l_SPOUSE_INC_ASSET_FREQ == null) l_SPOUSE_INC_ASSET_FREQ = "";
					System.out.println(" ::: l_SPOUSE_INC_ASSET_FREQ : "+l_SPOUSE_INC_ASSET_FREQ);
					
					l_DEPENDENT_INC_ASSET_AMT = rset.getString("DEPENDENT_INC_ASSET_AMT");
					if(l_DEPENDENT_INC_ASSET_AMT == null) l_DEPENDENT_INC_ASSET_AMT = "";
					System.out.println(" ::: l_DEPENDENT_INC_ASSET_AMT : "+l_DEPENDENT_INC_ASSET_AMT);
					
					l_DEPENDENT_INC_ASSET_FREQ = rset.getString("DEPENDENT_INC_ASSET_FREQ");
					if(l_DEPENDENT_INC_ASSET_FREQ == null) l_DEPENDENT_INC_ASSET_FREQ = "";
					System.out.println(" ::: l_DEPENDENT_INC_ASSET_FREQ : "+l_DEPENDENT_INC_ASSET_FREQ);
					
					l_CLASSIFICATION_CODE = rset.getString("CLASSIFICATION_CODE");
					if(l_CLASSIFICATION_CODE == null) l_CLASSIFICATION_CODE = "";
					System.out.println(" ::: l_CLASSIFICATION_CODE : "+l_CLASSIFICATION_CODE);
					
					l_CLASSIFICATION_TYPE = rset.getString("CLASSIFICATION_TYPE");
					if(l_CLASSIFICATION_TYPE == null) l_CLASSIFICATION_TYPE = "";
					System.out.println(" ::: l_CLASSIFICATION_TYPE : "+l_CLASSIFICATION_TYPE);
					
					l_CLASSIFICATION_START_DATE = rset.getString("CLASSIFICATION_START_DATE");
					if(l_CLASSIFICATION_START_DATE == null) l_CLASSIFICATION_START_DATE = "";
					System.out.println(" ::: l_CLASSIFICATION_START_DATE : "+l_CLASSIFICATION_START_DATE);
					
					l_CLASSIFICATION_END_DATE = rset.getString("CLASSIFICATION_END_DATE");
					if(l_CLASSIFICATION_END_DATE == null) l_CLASSIFICATION_END_DATE = "";
					System.out.println(" ::: l_CLASSIFICATION_END_DATE : "+l_CLASSIFICATION_END_DATE);
					
					l_financial_remarks = rset.getString("financial_remarks");
					if(l_financial_remarks == null) l_financial_remarks = "";
					System.out.println(" ::: l_financial_remarks : "+l_financial_remarks);
					
					l_SOCIAL_PENSIONER_ID = rset.getString("SOCIAL_PENSIONER_ID");
					if(l_SOCIAL_PENSIONER_ID == null) l_SOCIAL_PENSIONER_ID = "";
					System.out.println(" ::: l_SOCIAL_PENSIONER_ID : "+l_SOCIAL_PENSIONER_ID);
				}
				
			}catch(Exception e){
				l_app_msg = "Execption Fetching Financial Required Values in  : "+e.getMessage();
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				e.printStackTrace();
				
			}finally {
				EMDataSource.returnConnection(con);
				XHUtil.closeDBResources(rset, pstmt, null);
			}
			
			l_app_msg = " ::: Fetching Other financial Details ::: ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			try{
				String otherQuery = "SELECT operating_facility_id,episode_type,patient_id,episode_id,visit_id,regn_date_time,acct_seq_no,cust_group_code,cust_code," +
						"priority,policy_type_code,policy_number,policy_start_date,policy_expiry_date,credit_auth_ref,credit_auth_date,effective_from effective_from," +
						"effective_to,approved_amt,approved_days,adj_rule_ind,adj_perc_amt_ind,adj_perc_amt_value,pmnt_diff_adj_int,drg_pmnt_diff_adj_int," +
						"spl_srv_pmnt_diff_adj_int,a.blng_grp_id,ref_src_main_code,ref_src_sub_code FROM BL_PRV_ENC_SELECT_INS_BG_VW a where operating_facility_id=?" +
						" and patient_id=? AND episode_type=Decode(?,'Y',episode_type,?) AND nvl(episode_id,99999999) = decode(episode_type,'R',nvl(episode_id,99999999),?)" +
						" AND nvl(visit_id,99999999) = decode(episode_type,'R',nvl(visit_id,99999999),'I',nvl(visit_id,99999999),'D',nvl(visit_id,99999999),?) " +
						"and exists (Select 'X' from bl_blng_grp b where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR" +
						" (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and a.blng_grp_id=b.blng_grp_id) order by priority";
				
				l_app_msg = " ::: otherQuery : "+otherQuery;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				con = EMDataSource.getConnection();
				pstmt = con.prepareStatement(otherQuery, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				System.out.println(" ::: otherQuery parameters : l_facility_id : "+l_facility_id+" : patient_id : "+l_patient_id+" : l_dflt_prv_fin_dtl_acrs_enc_yn : "+l_dflt_prv_fin_dtl_acrs_enc_yn);
				System.out.println(" ::: otherQuery parameters : l_episode_type :"+l_episode_type+" : l_episode_no : "+l_episode_no+" : l_visitno : "+l_visitno+" : l_calling_module_id : "+l_calling_module_id);
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
				rset = pstmt.executeQuery();
				
				while(rset.next()){
					l_ref_src_main_code = rset.getString("ref_src_main_code");
					if(l_ref_src_main_code == null) l_ref_src_main_code = "";
					System.out.println(" ::: l_ref_src_main_code : "+l_ref_src_main_code);
					
					l_ref_src_sub_code = rset.getString("ref_src_sub_code");
					if(l_ref_src_sub_code == null) l_ref_src_sub_code = "";
					System.out.println(" ::: l_ref_src_sub_code : "+l_ref_src_sub_code);
					
					l_priority = rset.getString("priority");
					if(l_priority == null) l_priority = "";
					System.out.println(" ::: l_priority : "+l_priority);
					
					l_credit_auth_ref = rset.getString("credit_auth_ref");
					if(l_credit_auth_ref == null) l_credit_auth_ref = "";
					System.out.println(" ::: l_credit_auth_ref : "+l_credit_auth_ref);
					
					l_credit_auth_date = rset.getString("credit_auth_date");
					if(l_credit_auth_date == null) l_credit_auth_date = "";
					System.out.println(" ::: l_credit_auth_date : "+l_credit_auth_date);
					
					l_effective_from = rset.getString("effective_from");
					if(l_effective_from == null) l_effective_from = "";
					System.out.println(" ::: l_effective_from : "+l_effective_from);
					
					l_effective_to = rset.getString("effective_to");
					if(l_effective_to == null) l_effective_to = "";
					System.out.println(" ::: l_effective_to : "+l_effective_to);
					
					l_approved_amt = rset.getString("approved_amt");
					if(l_approved_amt == null) l_approved_amt = "";
					System.out.println(" ::: l_approved_amt "+l_approved_amt);
					
					l_approved_days = rset.getString("approved_days");
					if(l_approved_days == null ) l_approved_days = "";
					System.out.println(" ::: l_approved_days : "+l_approved_days);
					
					l_adj_rule_ind = rset.getString("adj_rule_ind");
					if(l_adj_rule_ind == null) l_adj_rule_ind = "";
					System.out.println(" ::: l_adj_rule_ind : "+l_adj_rule_ind);
					
					l_adj_perc_amt_ind = rset.getString("adj_perc_amt_ind");
					if(l_adj_perc_amt_ind == null) l_adj_perc_amt_ind = "";
					System.out.println(" ::: l_adj_perc_amt_ind : "+l_adj_perc_amt_ind);
					
					l_adj_perc_amt_value = rset.getString("adj_perc_amt_value");
					if(l_adj_perc_amt_value == null) l_adj_perc_amt_value = "";
					System.out.println(" ::: l_adj_perc_amt_value : "+l_adj_perc_amt_value);
					
					l_pmnt_diff_adj_int = rset.getString("pmnt_diff_adj_int");
					if(l_pmnt_diff_adj_int == null) l_pmnt_diff_adj_int = "";
					System.out.println(" ::: l_pmnt_diff_adj_int : "+l_pmnt_diff_adj_int);
					
					l_drg_pmnt_diff_adj_int = rset.getString("drg_pmnt_diff_adj_int");
					if(l_drg_pmnt_diff_adj_int == null) l_drg_pmnt_diff_adj_int = "";
					System.out.println(" ::: l_drg_pmnt_diff_adj_int : "+l_drg_pmnt_diff_adj_int);
					
					l_spl_srv_pmnt_diff_adj_int = rset.getString("spl_srv_pmnt_diff_adj_int");
					if(l_spl_srv_pmnt_diff_adj_int == null) l_spl_srv_pmnt_diff_adj_int = "";
					System.out.println(" ::: l_spl_srv_pmnt_diff_adj_int : "+l_spl_srv_pmnt_diff_adj_int);
				}
				
				
			}catch(Exception e){
				System.out.println("Execption Fetching other fin Details in  : "+e.getMessage());
				e.printStackTrace();
				
			}finally {
				EMDataSource.returnConnection(con);
				XHUtil.closeDBResources(rset, pstmt, null);
			}
			
			if(l_slmt_ind.equals("R"))
			{
				 l_str_cust_group_code = l_cust_group_code;	
				 l_str_cust_code = l_cust_code;
				 l_str_doc_ref= l_credit_doc_ref_desc;
				 l_str_doc_start_date=l_credit_doc_ref_start_date;
				 l_str_doc_end_date=l_credit_doc_ref_date;
				 l_settlement_type_code = l_slmt_type_code;
			}
			else if(l_slmt_ind.equals("X") && l_adm_rec_flag.equals(""))
			{
				 l_str_cust_group_code = l_cust_group_code;
				 l_str_cust_code = l_cust_code;
				 l_str_doc_ref= l_credit_doc_ref_desc;
				 l_str_doc_start_date=l_credit_doc_ref_start_date;
				 l_str_doc_end_date=l_credit_doc_ref_date;
				 l_settlement_type_code = l_slmt_type_code;
			}
			else if(l_slmt_ind.equals("X") && !l_adm_rec_flag.equals(""))
			{	
				 l_str_cust_group_code = l_cust_group_code;
				 l_str_cust_code = l_cust_code;
				 l_str_doc_ref= l_credit_doc_ref_desc;
				 l_str_doc_start_date=l_credit_doc_ref_start_date;
				 l_str_doc_end_date=l_credit_doc_ref_date;
				 l_settlement_type_code = l_slmt_type_code;
			}
			else
			{
				 l_str_doc_ref= l_credit_doc_ref_desc;
				 l_str_doc_start_date = l_credit_doc_ref_start_date;
				 l_str_doc_end_date = l_credit_doc_ref_date;
				 l_settlement_type_code = l_slmt_type_code;
			}
			 
			 System.out.println(" ::: l_str_cust_group_code : "+l_str_cust_group_code);
			 System.out.println(" ::: l_str_cust_code : "+l_str_cust_code);
			 System.out.println(" ::: l_str_doc_ref : "+l_str_doc_ref);
			 System.out.println(" ::: l_str_doc_start_date : "+l_str_doc_start_date);
			 System.out.println(" ::: l_str_doc_end_date : "+l_str_doc_end_date);
			 System.out.println(" ::: l_settlement_type_code : "+l_settlement_type_code);
			 
			 l_app_msg = " ::: Fetching Visit Type Ind ::: ";
			 if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			 try{
				 String visitTypeIndQuery = "select visit_type_ind from op_visit_type where visit_type_code='"+l_visit_type+"' and facility_id='"+l_facility_id+"'";
				 
				 con = EMDataSource.getConnection();
				 pstmt = con.prepareStatement(visitTypeIndQuery.toString());
				 rset = pstmt.executeQuery();					
				
				 while(rset.next()){
					l_visit_type_ind = rset.getString(1); 
				 }
				 
				 l_app_msg = " ::: l_visit_type_ind : "+l_visit_type_ind;
				 if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			 }catch(Exception e){
					System.out.println("Execption Fetching Visit Type Ind : "+e.getMessage());
					e.printStackTrace();
					
				}finally {
					EMDataSource.returnConnection(con);
					XHUtil.closeDBResources(rset, pstmt, null);
				}
		
			l_app_msg = " ::: insertable while PR_ENCOUNTER : "+insertable+" ::: Error Code : "+l_errcd;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			if (insertable) {
				try{
					
					StringBuffer prEncounterSQL = new StringBuffer();
					int count = 0;
					String referral_toid = "", form60_YN = "", other_remarks = "";
					prEncounterSQL.append("insert into pr_encounter(facility_id,patient_id,appt_id,visit_adm_type,visit_adm_type_facility_id,visit_adm_type_ind,assign_care_locn_type,assign_care_locn_code,attend_practitioner_id,referral_id,specialty_code,contact_reason_code,appt_case_yn,ancillary_yn,ambulatory_status,op_episode_visit_num,recall_yn,mds_complete_yn,backdated_yn,visit_status,added_by_id,added_facility_id,added_at_ws_no,modified_by_id,modified_facility_id,modified_at_ws_no,encounter_id,patient_class,HOSP_MAIN,HOSP_SUB,CARD_ID,EXPIRY_DATE,PRIVL_TYPE_CODE,visit_adm_date_time,episode_id,service_code,subservice_code,new_op_episode_yn,assign_room_num,assign_room_type,PAT_TRN_TIME,PAT_CURR_LOCN_CODE,PAT_CURR_LOCN_TYPE,INVITATION_NO,PREV_ASSIGN_CARE_LOCN_CODE,PREV_ASSIGN_ROOM_NUM ,PREV_SUBSERVICE_CODE, PREV_ATTEND_PRACTITIONER_ID,PREV_VISIT_ADM_TYPE , PREV_VISIT_ADM_TYPE_IND,OTHER_RES_CLASS,OTHER_RESOURCE_ID,QUEUE_ID,referred_locn_code,FORM60_YN,other_reason_remarks");
					prEncounterSQL.append(") values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,To_Date(?,'dd/mm/yyyy'),?,To_Date(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					
					System.out.println(" ::: prEncounterSQL "+prEncounterSQL.toString());
					con = EMDataSource.getConnection();
					pstmt = con.prepareStatement(prEncounterSQL.toString());
					Object[] obj;
					obj = new Object[55];
					
					
					obj[0] = l_facility_id;
					obj[1] = l_patient_id;
					obj[2] = "";
					obj[3] = l_visit_type;
					obj[4] = l_facility_id;
					//obj[5] = "F";//l_visit_type_ind
					obj[5] = l_visit_type_ind;
					obj[6] = clinicMap.get("assign_care_locn_type");
					obj[7] = l_location_code;
					obj[8] = l_practitioner_id;
					obj[9] = "";
					obj[10] = clinicMap.get("speciality_code");
					obj[11] = "";
					obj[12] = "W";
					obj[13] = "N";
					obj[14] = "";
					String pr_visitnum = "";
					if (l_visitnum.length() >= 4){
						pr_visitnum = l_visitnum.substring(l_visitnum.length()-1);
						System.out.println(" ::: Visit NO 1 : "+pr_visitnum);
					}else{
						pr_visitnum = l_visitnum;
						System.out.println(" ::: Visit NO 2 : "+pr_visitnum);
					}
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
					//obj[33] = TO_DATE('"+l_visit_date_time+"','dd/MM/yyyy hh:mi:ss');
					obj[33] = l_visit_date_time;
					obj[34] = Integer.parseInt(l_episode_no);
					obj[35] = l_service_code;
					obj[36] = "";
					//obj[37] = "Y";//new_op_episode_yn
					obj[37] = new_op_episode_yn;
					obj[38] = "";
					obj[39] = "R";
					obj[40] = l_location_code;
					obj[41] = l_location_type;
					obj[42] = "";
					obj[43] = l_location_code;
					obj[44] = "";
					obj[45] = "";
					obj[46] = l_practitioner_id;
					obj[47] = l_visit_type;
					//obj[48] = "F";//l_visit_type_ind
					obj[48] = l_visit_type_ind;
					obj[49] = "";
					obj[50] = "";
					obj[51] = l_queueID;
					obj[52] = referral_toid;
					obj[53] = form60_YN; 	
					obj[54] = other_remarks;
					System.out.println(" ::: pr ecounter parameters : "+Arrays.toString(obj));
					
					pstmt = setData(pstmt, obj);
					
					count = pstmt.executeUpdate();
					
					if (l_debug_YN.equals("Y")) System.out.println(" ::: Count ::: "+count);
					
					if (count == 1)
					{
						insertable = true;
						con.commit();
						if (l_debug_YN.equals("Y"))  System.out.println(" ::: Inserted Success ::: ");
					}else{
						insertable = false;
						con.rollback();
						if (l_debug_YN.equals("Y"))  System.out.println(" ::: RollBack Success ::: ");
					}
				}catch (Exception e) {
					l_app_msg = " Excpetion in Insserting PR_ENCOUNTER "+e.getMessage();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					e.printStackTrace();
				}
				finally{
					EMDataSource.returnConnection(con);
					XHUtil.closeDBResources(null, pstmt, null);
				}
			}
			
			l_app_msg = " ::: Fetching Build Episode Rule ::: ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			try{
				
				con = EMDataSource.getConnection();
				pstmt  = con.prepareStatement("select oper_stn_access_rule, build_episode_rule, bl_interfaced_yn, ALLOW_WL_INV_WO_APPT_YN, ALLOW_EMER_REGN_YN," +
						" REG_VISIT_FOR_INPAT_YN, accept_display_inv_no,visit_type_derv_rule from op_param where operating_facility_id='"+l_facility_id+"'");				
				
				rset = pstmt.executeQuery();
				
				while(rset.next()){
					l_build_episode_rule = rset.getString("build_episode_rule")==null?"":rset.getString("build_episode_rule");
				}
				
				l_app_msg = " ::: Build Episode Rule : "+l_build_episode_rule;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							
			}catch (Exception e) {
				l_app_msg = " Excpetion while fetching Build Episode Rule "+e.getMessage();
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			}finally{
				EMDataSource.returnConnection(con);
				XHUtil.closeDBResources(rset, pstmt, null);
			}
			
			l_app_msg = " ::: Insert/Update on OP EPISODE FOR SERVICE ::: ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: insertable while OP_EPISODE_FOR_SERVICE : "+insertable+" ::: Error Code : "+l_errcd;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			
			if (insertable) {
				//if (!(l_build_episode_rule.equals("X"))	&& !(l_service_code.equals(""))) {
				if (l_build_episode_rule.equals("S")) {
					//OP_EPISODE_FOR_SERVICE = new LinkedHashMap<String, String>();
					
					if (l_visitnum.equals("0001")) {
						try{
							
							//String opEpisodeForServiceQuery = "insert into op_episode_for_service(patient_id,operating_facility_id,episode_id, clinic_code,service_code, start_date_time,episode_status, last_encounter_id, last_visit_date,last_visit_num,added_by_id,added_date,added_facility_id,added_at_ws_no,   modified_by_id,modified_date,modified_facility_id,modified_at_ws_no,subservice_code,LAST_VISIT_FU_REQD_YN) values(?,?,?,?,?,sysdate,'01',?,To_Date('"+l_visit_date_time+"','dd/mm/yyyy hh24:mi:ss'),1,?,sysdate,?,?,?,sysdate,?,?,?,'N') ";
							String opEpisodeForServiceQuery = "insert into op_episode_for_service(patient_id,operating_facility_id,episode_id, clinic_code,service_code, start_date_time,episode_status, last_encounter_id, last_visit_date,last_visit_num,added_by_id,added_date,added_facility_id,added_at_ws_no,   modified_by_id,modified_date,modified_facility_id,modified_at_ws_no,subservice_code,LAST_VISIT_FU_REQD_YN,BLNG_GRP_ID,CUST_CODE,CUST_GRP_CODE,POLICY_TYPE_CODE) values(?,?,?,?,?,To_Date('"+l_visit_date_time+"','dd/mm/yyyy hh24:mi:ss'),'01',?,To_Date('"+l_visit_date_time+"','dd/mm/yyyy hh24:mi:ss'),1,?,sysdate,?,?,?,sysdate,?,?,?,'N',?,?,?,?) ";
							System.out.println(" ::: opEpisodeForServiceQuery : "+opEpisodeForServiceQuery);
							System.out.println(" ::: op_episode_for_service parameters : patid : "+l_patient_id+" : facilityid : "+l_facility_id+" : episodeno : "+l_episode_no);
							System.out.println(" ::: op_episode_for_service parameters : l_location_code : "+l_location_code+" : l_service_code : "+l_service_code+" : l_encounter_id : "+l_encounter_id);
							con = EMDataSource.getConnection();
							pstmt = con.prepareStatement(opEpisodeForServiceQuery.toString());
							
							pstmt.setString(1, l_patient_id);
							pstmt.setString(2, l_facility_id);
							pstmt.setString(3, l_episode_no);
							pstmt.setString(4, l_location_code);
							pstmt.setString(5, l_service_code);
							pstmt.setString(6, l_encounter_id);
							pstmt.setString(7, added_by_id);	
							pstmt.setString(8, l_facility_id);
							pstmt.setString(9, added_at_ws_no);
							pstmt.setString(10, added_by_id);
							pstmt.setString(11, l_facility_id);
							pstmt.setString(12, added_at_ws_no);
							pstmt.setString(13, "");
							pstmt.setString(14, l_billing_group_code);
							pstmt.setString(15, l_payer_code);
							pstmt.setString(16, l_payer_group_code);
							pstmt.setString(17, "");
							
							int count = pstmt.executeUpdate();
							
							if (l_debug_YN.equals("Y")) System.out.println(" ::: Count ::: "+count);
							
							if (count == 1)
							{
								insertable = true;
								con.commit();
								if (l_debug_YN.equals("Y"))  System.out.println(" ::: op_episode_for_service Inserted Success ::: ");
							}else{
								insertable = false;
								con.rollback();
								if (l_debug_YN.equals("Y"))  System.out.println(" ::: op_episode_for_service RollBack Success ::: ");
							}
						}catch (Exception e) {
							l_app_msg = " Excpetion while Inserting OP_EPISODE_FOR_SERVICE "+e.getMessage();
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							e.printStackTrace();
						}finally{
							EMDataSource.returnConnection(con);
							XHUtil.closeDBResources(null, pstmt, null);
						}
						
					}else{
						try{
							int count = 0;
							StringBuffer updateOPEpisodeForServiceQuery = new StringBuffer();
							
							updateOPEpisodeForServiceQuery.append("update op_episode_for_service set last_encounter_id = ?, 	last_visit_date = To_Date('"+l_visit_date_time+"','dd/mm/yyyy hh24:mi:ss'), last_visit_num = last_visit_num +1,BLNG_GRP_ID=?,CUST_CODE=?,CUST_GRP_CODE=?,POLICY_TYPE_CODE=?, MODIFIED_BY_ID =?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID	= ? where operating_facility_id = ? ");
							if(!l_VISIT_TYPE_DERV_RULE.equals("B")){
								updateOPEpisodeForServiceQuery.append(" and service_code = ? ");
							}
							updateOPEpisodeForServiceQuery.append(" and episode_id =? and patient_id = ?");
							
							l_app_msg = " ::: updateOPEpisodeForServiceQuery : "+updateOPEpisodeForServiceQuery;
							if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
							
							con = EMDataSource.getConnection();
							pstmt = con.prepareStatement(updateOPEpisodeForServiceQuery.toString());
							pstmt.setString(1, l_encounter_id);
							pstmt.setString(2, l_billing_group_code);
							pstmt.setString(3, l_payer_code);
							pstmt.setString(4, l_payer_group_code);
							pstmt.setString(5, l_policy_type_code);
							pstmt.setString(6, modified_by_id);
							pstmt.setString(7, added_at_ws_no);
							pstmt.setString(8, l_facility_id);
							pstmt.setString(9, l_facility_id);
							
							if(!l_VISIT_TYPE_DERV_RULE.equals("B")){
								pstmt.setString(10, l_service_code);
								pstmt.setString(11, l_episode_no);
								pstmt.setString(12, l_patient_id);
							}else{
								pstmt.setString(10, l_episode_no);
								pstmt.setString(11, l_patient_id);
							}
							
							
							count = pstmt.executeUpdate();
							
							l_app_msg = " count at Updating OP_EPISODE_FOR_SERVICE "+count;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							
							if (count > 0)
							{
								con.commit();
								insertable = true;
								if (l_debug_YN.equals("Y"))  System.out.println(" ::: Updated Success ::: ");
							}else{
								con.rollback();
								insertable = false;
							}
							
						}catch (Exception e) {
							l_app_msg = " Excpetion while Updating OP_EPISODE_FOR_SERVICE "+e.getMessage();
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							e.printStackTrace();
						}finally{
							EMDataSource.returnConnection(con);
							XHUtil.closeDBResources(null, pstmt, null);
						}
					}
					
				}
			}
			
			l_app_msg = " ::: insertable while OP_LAST_VISIT_FOR_SERVICE : "+insertable+" ::: Error Code : "+l_errcd;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			if (insertable) {
				try 
				{
					String sql = "select '1' from op_last_visit_for_service"
							+ " where operating_facility_id=? and service_code=?"
							+ " and patient_id=?";

					con = EMDataSource.getConnection();

					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, l_facility_id);
					pstmt.setString(2, l_service_code);
					pstmt.setString(3, l_patient_id);
					
					rset = pstmt.executeQuery();
					
					if(!rset.next()){
						
						try{
							int opLastVisitForServiceCount = 0;
						
							String opLastVisitForServiceQuery = "insert into op_last_visit_for_service (operating_facility_id, Encounter_id, service_code, patient_id, added_by_id, added_date, added_facility_id, added_at_ws_no, modified_by_id, modified_date, modified_facility_id, modified_at_ws_no, VISIT_ADM_DATE_TIME, ASSIGN_CARE_LOCN_CODE, ATTEND_PRACTITIONER_ID, PATIENT_CLASS, REFERRAL_ID, SUBSERVICE_CODE) " +
									" values(?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,To_Date('"+l_visit_date_time+"','dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?)";
							
							System.out.println(" ::: opLastVisitForServiceQuery : "+opLastVisitForServiceQuery.toString());
							System.out.println(" ::: op_last_visit_for_service parameters : facility_id : "+l_facility_id+" : l_encounter_id : "+l_encounter_id+" : l_service_code : "+l_service_code);
							System.out.println(" ::: op_last_visit_for_service parameters : l_patient_id : "+l_patient_id+" : added_by_id : "+added_by_id+" : l_facility_id : "+l_facility_id);
							System.out.println(" ::: op_last_visit_for_service parameters : added_at_ws_no : "+added_at_ws_no+" : added_by_id : "+added_by_id+" : l_facility_id : "+l_facility_id);
							System.out.println(" ::: op_last_visit_for_service parameters : added_at_ws_no : "+added_at_ws_no+" : l_location_code : "+l_location_code+" : l_practitioner_id : "+l_practitioner_id);
							System.out.println(" ::: op_last_visit_for_service parameters : l_calling_module_id : "+l_calling_module_id);
							con = EMDataSource.getConnection();
							pstmt = con.prepareStatement(opLastVisitForServiceQuery.toString());
							
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
							pstmt.setString(11, l_location_code);
							pstmt.setString(12, l_practitioner_id);
							pstmt.setString(13, l_calling_module_id);
							pstmt.setString(14, "");
							pstmt.setString(15, "");
							
							opLastVisitForServiceCount = pstmt.executeUpdate();
							
							l_app_msg = " ::: count at Inserting op_last_visit_for_service : "+opLastVisitForServiceCount;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							
							if (opLastVisitForServiceCount > 0)
							{
								con.commit();
								insertable = true;
								if (l_debug_YN.equals("Y"))  System.out.println(" ::: Updated Success ::: ");
							}else{
								con.rollback();
								insertable = false;
							}
							
						}catch (Exception e) {
							l_app_msg = " Excpetion while Inserting OP_LAST_VISIT_FOR_SERVICE "+e.getMessage();
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							e.printStackTrace();
						}finally{
							EMDataSource.returnConnection(con);
							XHUtil.closeDBResources(null, pstmt, null);
						}
					}else{
						//sql = " update op_last_visit_for_service  where operating_facility_id=? and service_code=? and patient_id=? ";
						int opLastCount = 0;
						String updateOpLastVisitForServiceQuery = " update op_last_visit_for_service set encounter_id=?,recall_date=null,recall_reason=null,VISIT_ADM_DATE_TIME = " +
								"To_Date('"+l_visit_date_time+"','dd/mm/yyyy hh24:mi:ss'), ASSIGN_CARE_LOCN_CODE = ?, ATTEND_PRACTITIONER_ID = ?, " +
								"PATIENT_CLASS = ?, REFERRAL_ID = ?, SUBSERVICE_CODE = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, " +
								"MODIFIED_FACILITY_ID = ? where operating_facility_id=? and service_code=? and patient_id=? ";
						try{
							
							l_app_msg = " ::: updateOpLastVisitForServiceQuery : "+updateOpLastVisitForServiceQuery;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							
							con = EMDataSource.getConnection();
							pstmt = con.prepareStatement(updateOpLastVisitForServiceQuery.toString());
							pstmt.setString(1, l_encounter_id);
							pstmt.setString(2, l_location_code); 
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
							
							l_app_msg = " ::: count at Updating op_last_visit_for_service : "+opLastCount;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							
							if (opLastCount > 0)
							{
								con.commit();
								insertable = true;
								if (l_debug_YN.equals("Y"))  System.out.println(" ::: Updated Success ::: ");
							}else{
								con.rollback();
								insertable = false;
							}
							
						}catch (Exception e) {
							l_app_msg = " Excpetion while Updating OP_LAST_VISIT_FOR_SERVICE "+e.getMessage();
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							e.printStackTrace();
						}finally{
							EMDataSource.returnConnection(con);
							XHUtil.closeDBResources(null, pstmt, null);
						}
					}
				} catch (Exception exc11) {

					exc11.printStackTrace();

				} finally {
					EMDataSource.returnConnection(con);
					XHUtil.closeDBResources(rset, pstmt, null);
				}
			}
			
			l_app_msg = " ::: insertable while OP_PATIENT_QUEUE : "+insertable+" ::: Error Code : "+l_errcd;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			if (insertable) {
					try{
						String opPatientQueueQuery = "insert into op_patient_queue (facility_id,queue_date,queue_shift,locn_type,locn_code,"
								+ " queue_num,patient_id,practitioner_id,room_num,appt_or_walk_in_ind,appt_id,appt_time,encounter_id,check_in_date_time,"
								+ " queue_status, added_by_id,added_date,added_facility_id,added_at_ws_no, "
								+ " modified_by_id,modified_date,modified_facility_id,modified_at_ws_no,QUEUE_ID,OTHER_RES_CLASS,OTHER_RESOURCE_ID ,VISIT_TYPE_IND,VISIT_TYPE_CODE ,SERVICE_CODE  ,SUBSERVICE_CODE ,PAT_CURR_LOCN_CODE ,PAT_CURR_LOCN_TYPE   ,SPECIALITY_CODE ,REFERRAL_ID,EPISODE_ID ,OP_EPISODE_VISIT_NUM ,INVITATION_NO,CONTACT_REASON_CODE )"
								+ " values(?,To_Date('"+l_visit_date_time+"','dd/mm/yyyy hh24:mi:ss'),'*ALL',?,?,"
								+ l_quenum
								+ ",?,?,?,?,?,null,'"
								+ l_encounter_id
								+ "',To_Date('"+l_visit_date_time+"','dd/mm/yyyy hh24:mi:ss'),'01',?,sysdate,?,?,?,sysdate,?,?,'"
								+ l_queueID + "',?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						
						System.out.println(" ::: opPatientQueueQuery : "+opPatientQueueQuery.toString());
						System.out.println(" ::: op_patient_queue parameters : l_facility_id : "+l_facility_id+" : l_location_type : "+l_location_type+ " : l_location_code : "+l_location_code);
						System.out.println(" ::: op_patient_queue parameters : l_patient_id : "+l_patient_id+" : l_practitioner_id : "+l_practitioner_id+" : *ALL : W ");
						System.out.println(" ::: op_patient_queue parameters : l_appt_id : "+l_appt_id+" : added_by_id : "+added_by_id+" : l_facility_id : "+l_facility_id);
						System.out.println(" ::: op_patient_queue parameters : added_at_ws_no : "+added_at_ws_no+" : modified_by_id : "+modified_by_id);
						System.out.println(" ::: op_patient_queue parameters : modified_by_id : "+modified_by_id+" : modified_at_ws_no : "+modified_at_ws_no+" : l_visit_type_ind : "+l_visit_type_ind);
						System.out.println(" ::: op_patient_queue parameters : l_visit_type : "+l_visit_type+" : l_service_code : "+l_service_code+" : l_location_code : "+l_location_code);
						System.out.println(" ::: op_patient_queue parameters : l_location_type : "+l_location_type+" : speciality_code : "+clinicMap.get("speciality_code"));
						System.out.println(" ::: op_patient_queue parameters : l_episode_no : "+l_episode_no+" : l_visitnum : "+l_visitnum);
						con = EMDataSource.getConnection();
						pstmt = con.prepareStatement(opPatientQueueQuery.toString());
						
						pstmt.setString(1, l_facility_id);
						pstmt.setString(2, l_location_type);
						pstmt.setString(3, l_location_code);
						pstmt.setString(4, l_patient_id);
						pstmt.setString(5, l_practitioner_id);
						pstmt.setString(6, "*ALL");
						pstmt.setString(7, "W");
						pstmt.setString(8, l_appt_id);
						pstmt.setString(9, added_by_id);
						pstmt.setString(10, l_facility_id);
						pstmt.setString(11, added_at_ws_no);
						pstmt.setString(12, modified_by_id);
						pstmt.setString(13, l_facility_id);
						pstmt.setString(14, modified_at_ws_no);
						pstmt.setString(15, "");
						pstmt.setString(16, "");
						//pstmt.setString(17, "F");//l_visit_type_ind
						pstmt.setString(17, l_visit_type_ind);
						pstmt.setString(18, l_visit_type);
						pstmt.setString(19, l_service_code);
						pstmt.setString(20, "");
						pstmt.setString(21, l_location_code);
						pstmt.setString(22, l_location_type);
						pstmt.setString(23, clinicMap.get("speciality_code"));
						pstmt.setString(24, "");
						pstmt.setString(25, l_episode_no);
						pstmt.setString(26, l_visitnum);
						pstmt.setString(27, "");
						pstmt.setString(28, "");
						
						int opPatientQueueCount = 0;
						
						opPatientQueueCount = pstmt.executeUpdate();
						
						l_app_msg = " ::: count at Updating op_patient_queue : "+opPatientQueueCount;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						
						if (opPatientQueueCount > 0)
						{
							con.commit();
							insertable = true;
							if (l_debug_YN.equals("Y"))  System.out.println(" ::: Updated Success ::: ");
						}else{
							con.rollback();
							insertable = false;
						}
						
	
						
					}catch (Exception e) {
						l_app_msg = " Excpetion while Inserting op_patient_queue "+e.getMessage();
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						e.printStackTrace();
					}finally{
						EMDataSource.returnConnection(con);
						XHUtil.closeDBResources(null, pstmt, null);
					}
				}
			
			// Billing Starts here
			l_app_msg = " ::: insertable while blaudit.proc_store_old_values : "+insertable+" ::: Error Code : "+l_errcd;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			try{
				
				String procStoreOldValues = "{call blaudit.proc_store_old_values( ?,?,?,?,?,?,?,?,?,?,?,?)}";
				
				con = EMDataSource.getConnection();
				cstmt = con.prepareCall(procStoreOldValues.toString());
				System.out.println(" ::: blaudit.proc_store_old_values parameters : patient_id : "+l_patient_id+" : facility_id : "+l_facility_id+" : module_id : "+l_calling_module_id);
				System.out.println(" ::: function_id : "+l_calling_function_id+" : episode_type : "+l_episode_type+" : episode_no : "+l_episode_no+" : visit_num : "+l_visitnum+" : l_str_fin_auth_user_id : "+l_str_fin_auth_user_id);
				cstmt.setString( 1, l_patient_id);
				cstmt.setString( 2, l_facility_id);//facility_id
				cstmt.setString( 3, l_calling_module_id);  //module_id
				cstmt.setString( 4, l_calling_function_id );	// Function Id
				cstmt.setString( 5,  l_episode_type); // Episode Type						
				cstmt.setLong( 6,Long.parseLong(l_episode_no)); //episodeno
				cstmt.setInt(7,Integer.parseInt(l_visitnum)); //visit_num
				cstmt.setString(8,"O");	// Trn. Type
				cstmt.setString(9, l_str_fin_auth_user_id);	// Authorized by
				cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
				cstmt.execute();
				
				String strSysMessg = cstmt.getString(11);
				String strErrText = cstmt.getString(12);
				
				System.out.println(" ::: blaudit.proc_store_old_values : SysMessg : "+strSysMessg+" : ErrText : "+strErrText);
				
			}catch(Exception e){
				System.out.println(" ::: Execption call blaudit.proc_store_old_values in  : "+e.getMessage());
				e.printStackTrace();
				
			}finally {
				EMDataSource.returnConnection(con);
				XHUtil.closeDBResources(null, cstmt, null);
			}
			
			l_app_msg = " ::: insertable while BL_INS_UPD_VISIT_FIN_DTLS : "+insertable+" ::: Error Code : "+l_errcd;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			if (insertable) {
				System.out.println(" ::: calling BL_INS_UPD_VISIT_FIN_DTLS ::: ");
				
				try{
					if (l_visitnum.length() >= 4)
						l_visitnum = l_visitnum.substring(l_visitnum.length()-1);
					System.out.println(" ::: BL_INS_UPD_VISIT_FIN_DTLS : Visit Num : "+l_visitnum);
					
					if(!l_billing_group_code.equals("CASH"))
					{
						
						l_str_cust_code = l_payer_code;
						l_str_cust_code = l_str_cust_code+"|";
						l_str_cust_group_code = l_payer_group_code;
						l_str_cust_group_code = l_str_cust_group_code+"|";
						l_ref_src_sub_code = " |";
						l_ref_src_main_code = " |";
						l_credit_auth_ref = " |";
						l_credit_auth_date = " |";
						l_effective_from = l_visit_date_time.substring(0, l_visit_date_time.length()-9)+"|";
						l_effective_to = l_policy_end_date;
						l_effective_to = l_effective_to+"|";
						l_approved_amt = " |";
						l_approved_days = " |";
						l_adj_rule_ind = " |";
						l_adj_perc_amt_ind = " |";
						l_adj_perc_amt_value = " |";
						l_pmnt_diff_adj_int = " |";
						l_drg_pmnt_diff_adj_int = " |";
						l_spl_srv_pmnt_diff_adj_int = " |";
						l_non_ins_blng_grp_id = "CASH";
						l_claim_code = "|";
						l_credit_authorisation_by = "|";
						l_annual_family_income = "0.0";
						l_family_assets_value = "0.0";
						l_num_of_dependents = "0";
						l_membership_number = " |";
						l_billing_group_code = l_billing_group_code+"|";
						l_priority = l_priority+"|";
						l_policy_type_code = l_policy_type_code+"|";
						l_policy_number = l_policy_number+"|";
						l_policy_start_date = l_policy_start_date+"|";
						l_policy_end_date = l_policy_end_date+"|";
					}else{
						l_annual_family_income = "0.0";
						l_family_assets_value = "0.0";
						l_num_of_dependents = "0";
						l_non_ins_blng_grp_id = "";
					}
					
					int intVisitNum = Integer.parseInt(l_visitnum);
					long intEpisodeNum = Long.parseLong(l_episode_no);
					l_visit_status = "1";
					
					
					String BL_INS_UPD_VISIT_FIN_DTLS_QUERY = "{call BL_INS_UPD_VISIT_FIN_DTLS( '"+l_recordMode+"'," +
							"'"+l_episode_type+"'," +
							"'"+l_patient_id+"'," +
							"'"+l_encounter_id+"',"+intEpisodeNum+","+intVisitNum+"," +
							"'"+l_billing_group_code+"'," +
							"'"+l_REFERRAL_SOURCE_CODE_MAIN+"'," +
							"'"+l_REFERRAL_SOURCE_CODE_SUB+"','"+l_employer_code+"'," +
							"'"+l_str_doc_ref+"',to_date('"+l_str_doc_start_date+"','dd/mm/yyyy'),to_date('"+l_str_doc_end_date+"','dd/mm/yyyy'),'"+l_settlement_type_code+"'," +
							"'"+l_slmt_doc_ref_desc+"',to_date('"+l_slmt_doc_ref_date+"','dd/mm/yyyy'),'"+l_slmt_doc_remarks+"','"+l_ref_src_main_code+"','"+l_ref_src_sub_code+"'," +
							"'"+l_str_cust_group_code+"','"+l_str_cust_code+"','"+l_priority+"','"+l_policy_type_code+"','"+l_policy_number+"'," +
							"'"+l_policy_start_date+"','"+l_policy_end_date+"','"+l_credit_auth_ref+"','"+l_credit_auth_date+"'," +
							"'"+l_effective_from+"','"+l_effective_to+"','"+l_approved_amt+"','"+l_approved_days+"'," +
							"'"+l_adj_rule_ind+"','"+l_adj_perc_amt_ind+"','"+l_adj_perc_amt_value+"','"+l_pmnt_diff_adj_int+"'," +
							"'"+l_drg_pmnt_diff_adj_int+"','"+l_spl_srv_pmnt_diff_adj_int+"','"+l_non_ins_blng_grp_id+"','"+l_NON_INS_REF_SOURCE_CODE_MAIN+"'," +
							"'"+l_NON_INS_REF_SOURCE_CODE_SUB+"','"+l_non_ins_cust_group_code+"','"+l_non_ins_cust_code+"','"+l_annual_family_income+"','"+l_family_assets_value+"'," +
							"'"+l_num_of_dependents+"','"+l_resp_for_bill_payment+"','"+l_pat_reln_with_resp_pers+"',?,'"+l_pat_reln_with_gl_holder+"'," +
							"'"+added_by_id+"','"+l_facility_id+"','"+added_at_ws_no+"',?,'"+l_str_fin_auth_user_id+"'," +
							"'"+l_calling_function_id+"','"+l_visit_status+"',to_date('"+str_acct_seq_eff_from_date+"','dd/mm/yyyy'),to_date('"+str_acct_seq_eff_to_date+"','dd/mm/yyyy')," +
							"'"+l_str_upd_patient_fin_dtls_yn+"','"+l_NO_OF_ENC_GL_VALID+"','"+l_NO_OF_AE_ENC_GL_VALID+"','"+l_NO_OF_OP_ENC_GL_VALID+"'," +
							"'"+l_NO_OF_IP_ENC_GL_VALID+"','"+l_NO_OF_DC_ENC_GL_VALID+"','"+l_credit_authorisation_by+"','"+l_claim_code+"',?,?,?,?)}";
					
					 l_app_msg = " ::: BL_INS_UPD_VISIT_FIN_DTLS_QUERY : "+BL_INS_UPD_VISIT_FIN_DTLS_QUERY;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					 con = EMDataSource.getConnection();

					 cstmt = con.prepareCall(BL_INS_UPD_VISIT_FIN_DTLS_QUERY.toString());
					 
					 System.out.println(" ::: BL_INS_UPD_VISIT_FIN_DTLS : str_gl_holder_name : "+l_gl_holder_name);
						System.out.println(" ::: BL_INS_UPD_VISIT_FIN_DTLS : str_fin_remarks : "+l_remarks);
						System.out.println(" ::: BL_INS_UPD_VISIT_FIN_DTLS : membership_number : "+l_membership_number);
					 cstmt.setString(1, l_gl_holder_name);
					 cstmt.setString(2, l_remarks);
					 cstmt.setString(3, l_membership_number); // membership_number
					 cstmt.registerOutParameter( 4,java.sql.Types.VARCHAR);
					 cstmt.registerOutParameter( 5,java.sql.Types.VARCHAR);
					 cstmt.registerOutParameter( 6,java.sql.Types.VARCHAR);
					 
					 cstmt.execute();
					 
					 String l_err_level=cstmt.getString(4)==null?"":cstmt.getString(4);
					 String l_sys_message_id=cstmt.getString(5)==null?"":cstmt.getString(5);
					 String l_err_text=cstmt.getString(6)==null?"":cstmt.getString(6);
					 System.out.println("BL_INS_UPD_VISIT_FIN_DTLS...l_err_level.."+l_err_level+"..l_sys_message_id.."+l_sys_message_id+"..l_err_text.."+l_err_text);
					
					
				}catch(Exception e){
					System.out.println("Execption call BL_INS_UPD_VISIT_FIN_DTLS in  : "+e.getMessage());
					e.printStackTrace();
					
				}finally {
					EMDataSource.returnConnection(con);
					XHUtil.closeDBResources(null, cstmt, null);
				}
				
			}
			
			l_app_msg = " ::: insertable while BL_UPD_PAT_CLASS_DTLS : "+insertable+" ::: Error Code : "+l_errcd;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			if(insertable)
			{
				String fin_class_flag_YN="N";
				String sql_bl_class_flag = "Select NVL(AUTO_FIN_CLASSFCTN_IN_USE_YN,'N') from BL_PARAMETERS Where OPERATING_FACILITY_ID = '"+l_facility_id+"'";
				try
				{
					con = EMDataSource.getConnection();
					pstmt = con.prepareStatement(sql_bl_class_flag);
					rset = pstmt.executeQuery(); 
					if( rset != null ) 
					{
						while( rset.next() )
						{  
							fin_class_flag_YN = rset.getString(1);
						}
					}
					l_app_msg = " ::: AUTO_FIN_CLASSFCTN_IN_USE_YN : "+fin_class_flag_YN;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				}
				catch(Exception e)
				{
					l_app_msg = "Eception in BL_PARAMETERS : "+e.getMessage();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					e.printStackTrace();
				}		
				finally {
					XHUtil.closeDBResources(rset, pstmt, null);
					EMDataSource.returnConnection(con);
				}
				if(fin_class_flag_YN == null) fin_class_flag_YN="N";
				
				try
				{
					if(fin_class_flag_YN.equals("Y"))
					{
						String BL_UPD_PAT_CLASS_DTLS_QUERY = "{call BLCOMMON.BL_UPD_PAT_CLASS_DTLS('"+l_facility_id+"'," +
								 "'"+l_patient_id+"','"+l_episode_type+"','"+l_episode_no+"'," +
								 "'"+l_visitnum+"','"+l_encounter_id+"','"+l_billing_group_code+"','"+l_slmt_ind+"','"+l_annual_family_income+"'," +
								 "'"+l_family_assets_value+"','"+l_PATIENT_INC_ASSET_IND+"','"+l_PATIENT_INC_ASSET_AMT+"','"+l_PATIENT_INC_ASSET_FREQ+"','"+l_SPOUSE_INC_ASSET_AMT+"'," +
								 "'"+l_SPOUSE_INC_ASSET_FREQ+"','"+l_DEPENDENT_INC_ASSET_AMT+"','"+l_DEPENDENT_INC_ASSET_FREQ+"','"+l_CLASSIFICATION_CODE+"'," +
								 "'"+l_CLASSIFICATION_TYPE+"',to_date('"+l_CLASSIFICATION_START_DATE+"','DD/MM/YYYY'),to_date('"+l_CLASSIFICATION_END_DATE+"','DD/MM/YYYY')," +
								 "'"+l_financial_remarks+"','"+l_SOCIAL_PENSIONER_ID+"','"+l_str_upd_patient_fin_dtls_yn+"',?,?,?)}";

						l_app_msg = " ::: BL_UPD_PAT_CLASS_DTLS_QUERY : "+BL_UPD_PAT_CLASS_DTLS_QUERY;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						
						con = EMDataSource.getConnection();
						
						cstmt = con.prepareCall(BL_UPD_PAT_CLASS_DTLS_QUERY);
						
						cstmt.registerOutParameter( 1,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter( 2,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter( 3,java.sql.Types.VARCHAR);
						
						cstmt.execute();
						
						String l_err_level=cstmt.getString(1);
						String l_sys_message_id=cstmt.getString(2);
						String l_err_text=cstmt.getString(3);
						
						l_app_msg = " ::: BLCOMMON.BL_UPD_PAT_CLASS_DTLS : l_err_level : "+l_err_level+" : l_sys_message_id : "+l_sys_message_id+" : l_err_text : "+l_err_text;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						
					}
				}catch(Exception e)
				{
					l_app_msg = "Eception in BLCOMMON.BL_UPD_PAT_CLASS_DTLS : "+e.getMessage();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					e.printStackTrace();
				}	
			}
			
			l_app_msg = " ::: insertable while GET_VISIT_RULE_BY_CLINIC : "+insertable+" ::: Error Code : "+l_errcd;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			if (insertable)
			{
				l_app_msg = " ::: Fetching Customer Id ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				String customer_id = "", hosp_dtls = "";
				
				try{
					
					con =  EMDataSource.getConnection();

					String custIdQuery = "select CUSTOMER_ID from sm_site_param " ;

					pstmt = con.prepareStatement(custIdQuery);
					rset = pstmt.executeQuery();
					while(rset.next())
					{
						customer_id = rset.getString(1);
					}
					l_app_msg = " ::: Customer ID : "+customer_id;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

					
				}catch(Exception e)
				{
					l_app_msg = "Eception in Customer ID : "+e.getMessage();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					e.printStackTrace();
				}		
				finally {
					XHUtil.closeDBResources(rset, pstmt, null);
					EMDataSource.returnConnection(con);
				}
				
				l_app_msg = " ::: Fetching BL Interface YN ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				try{
					
					con =  EMDataSource.getConnection();

					String interfaceYNQuery = "select oper_stn_access_rule, build_episode_rule, bl_interfaced_yn, ALLOW_WL_INV_WO_APPT_YN, ALLOW_EMER_REGN_YN, " +
							             "REG_VISIT_FOR_INPAT_YN, accept_display_inv_no,visit_type_derv_rule from op_param where operating_facility_id='"+l_facility_id+"' " ;
					
					l_app_msg = " ::: interfaceYNQuery : "+interfaceYNQuery;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					pstmt = con.prepareStatement(interfaceYNQuery);
					rset = pstmt.executeQuery();
					while(rset.next())
					{
						strBLInterfaceYN = rset.getString("bl_interfaced_yn");
					}
					l_app_msg = " ::: Interface YN : "+strBLInterfaceYN;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					
				}catch(Exception e)
				{
					l_app_msg = "Eception in Interface YN : "+e.getMessage();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					e.printStackTrace();
				}		
				finally {
					XHUtil.closeDBResources(rset, pstmt, null);
					EMDataSource.returnConnection(con);
				}
				
				
				if(hosp_dtls==null || customer_id.equals("ALMO") == true)
				{
					if (strBLInterfaceYN.equals("Y"))
					{
						l_app_msg = " ::: calling BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC ::: ";
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						
						try{
							String GET_VISIT_RULE_BY_CLINIC_QUERY = "{ call BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
							
							con = EMDataSource.getConnection();				
							cstmt = con.prepareCall(GET_VISIT_RULE_BY_CLINIC_QUERY);
							
							cstmt.setString(1, l_facility_id);
							cstmt.setString(2, l_location_code);
							cstmt.setString(3, l_visit_type); // visit_type
							cstmt.setString(4, l_practitioner_id);
							cstmt.registerOutParameter(5,java.sql.Types.INTEGER);
							cstmt.registerOutParameter(6,java.sql.Types.INTEGER);
							cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);	
							cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(16,java.sql.Types.VARCHAR);
							
							cstmt.execute();
							
							int days_exempt_for_revisit=cstmt.getInt(5);
							l_app_msg = " ::: BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC..days_exempt_for_revisit.."+days_exempt_for_revisit;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							
							int no_of_follow_up_visit_exmp=cstmt.getInt(6);
							l_app_msg = " ::: BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC..no_of_follow_up_visit_exmp.."+no_of_follow_up_visit_exmp;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

							charge_basis_by_physician_yn = cstmt.getString(7);
							if(charge_basis_by_physician_yn==null) charge_basis_by_physician_yn="";
							l_app_msg = " ::: BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC..charge_basis_by_physician_yn.."+charge_basis_by_physician_yn;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

							strHospChargeStage=cstmt.getString(8);
							if(strHospChargeStage==null) strHospChargeStage="";
							l_app_msg = " ::: BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC..strHospChargeStage.."+strHospChargeStage;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

							strMedChargeStage=cstmt.getString(9);
							if(strMedChargeStage==null) strMedChargeStage="";
							l_app_msg = " ::: BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC..strMedChargeStage.."+strMedChargeStage;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

							strHospServPanelInd=cstmt.getString(10);
							if(strHospServPanelInd==null) strHospServPanelInd="";
							l_app_msg = " ::: BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC..strHospServPanelInd.."+strHospServPanelInd;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

							strHospServPanelCode=cstmt.getString(11);
							if(strHospServPanelCode==null) strHospServPanelCode="";
							l_app_msg = " ::: BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC..strHospServPanelCode.."+strHospServPanelCode;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

							strMedServPanelInd=cstmt.getString(12);
							if(strMedServPanelInd==null) strMedServPanelInd="";
							l_app_msg = " ::: BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC..strMedServPanelInd.."+strMedServPanelInd;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

							strMedServPanelCode=cstmt.getString(13);
							if(strMedServPanelCode==null) strMedServPanelCode="";
							l_app_msg = " ::: BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC..strMedServPanelCode.."+strMedServPanelCode;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

							String l_err_level=cstmt.getString(14);
							String l_sys_message_id=cstmt.getString(15);
							String l_err_text=cstmt.getString(16);
							
							l_app_msg = " ::: BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC...l_err_level.."+l_err_level+"..l_sys_message_id.."+l_sys_message_id+"..l_err_text.."+l_err_text;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							
						}catch(Exception e){
							System.out.println("Execption in BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC  : "+e.getMessage());
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							e.printStackTrace();
							
						}finally {
							EMDataSource.returnConnection(con);
							XHUtil.closeDBResources(null, cstmt, null);
						}
						
					}
				}else{

					if (strBLInterfaceYN.equals("Y"))
					{
						l_app_msg = " ::: calling BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC 2 ::: ";
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						
						try{
							String GET_VISIT_RULE_BY_CLINIC_QUERY = "{ call BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
							
							con = EMDataSource.getConnection();				
							cstmt = con.prepareCall(GET_VISIT_RULE_BY_CLINIC_QUERY);
							
							cstmt.setString(1, l_facility_id);
							cstmt.setString(2, l_location_code);
							cstmt.setString(3, l_visit_type); // visit_type
							cstmt.setString(4, l_practitioner_id);
							cstmt.registerOutParameter(5,java.sql.Types.INTEGER);
							cstmt.registerOutParameter(6,java.sql.Types.INTEGER);
							cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);	
							cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(16,java.sql.Types.VARCHAR);
							
							cstmt.execute();
							
							int days_exempt_for_revisit=cstmt.getInt(5);
							l_app_msg = " ::: BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC 2..days_exempt_for_revisit.."+days_exempt_for_revisit;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							
							int no_of_follow_up_visit_exmp=cstmt.getInt(6);
							l_app_msg = " ::: BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC 2..no_of_follow_up_visit_exmp.."+no_of_follow_up_visit_exmp;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

							charge_basis_by_physician_yn = cstmt.getString(7);
							if(charge_basis_by_physician_yn==null) charge_basis_by_physician_yn="";
							l_app_msg = " ::: BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC 2..charge_basis_by_physician_yn.."+charge_basis_by_physician_yn;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

							strHospChargeStage=cstmt.getString(8);
							if(strHospChargeStage==null) strHospChargeStage="";
							l_app_msg = " ::: BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC 2..strHospChargeStage.."+strHospChargeStage;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

							strMedChargeStage=cstmt.getString(9);
							if(strMedChargeStage==null) strMedChargeStage="";
							l_app_msg = " ::: BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC 2..strMedChargeStage.."+strMedChargeStage;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

							strHospServPanelInd=cstmt.getString(10);
							if(strHospServPanelInd==null) strHospServPanelInd="";
							l_app_msg = " ::: BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC 2 ..strHospServPanelInd.."+strHospServPanelInd;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

							strHospServPanelCode=cstmt.getString(11);
							if(strHospServPanelCode==null) strHospServPanelCode="";
							l_app_msg = " ::: BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC 2..strHospServPanelCode.."+strHospServPanelCode;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

							strMedServPanelInd=cstmt.getString(12);
							if(strMedServPanelInd==null) strMedServPanelInd="";
							l_app_msg = " ::: BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC 2..strMedServPanelInd.."+strMedServPanelInd;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

							strMedServPanelCode=cstmt.getString(13);
							if(strMedServPanelCode==null) strMedServPanelCode="";
							l_app_msg = " ::: BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC 2..strMedServPanelCode.."+strMedServPanelCode;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

							String l_err_level=cstmt.getString(14);
							String l_sys_message_id=cstmt.getString(15);
							String l_err_text=cstmt.getString(16);
							
							l_app_msg = " ::: BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC 2...l_err_level.."+l_err_level+"..l_sys_message_id.."+l_sys_message_id+"..l_err_text.."+l_err_text;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							
							if((!l_sys_message_id.equals(""))  || (l_err_level.equals("10") && !l_err_text.equals("")))
							{
								l_proc_success="N";
							}
							else
							{
								l_proc_success="Y";
							}
							
						}catch(Exception e){
							System.out.println("Execption in BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC 2  : "+e.getMessage());
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							e.printStackTrace();
							
						}finally {
							EMDataSource.returnConnection(con);
							XHUtil.closeDBResources(null, cstmt, null);
						}
						
					}
				
				}
						
			}
			
			l_app_msg = " ::: calling BLVISITCHARGE.CHECK_ADDL_SERV_CHARGE_BY_CL ::: l_proc_success : "+l_proc_success;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			if(l_proc_success.equals("Y")){
				
			
				try{
					
					String servChargeByCLQuery = "{ call BLVISITCHARGE.CHECK_ADDL_SERV_CHARGE_BY_CL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
					
					String cl_billing_group_code = l_billing_group_code;
					cl_billing_group_code = cl_billing_group_code.replace("|", "");
					String cl_payer_group_code = l_payer_group_code;
					cl_payer_group_code = cl_payer_group_code.replace("|", "");
					String cl_payer_code = l_payer_code;
					cl_payer_code = cl_payer_code.replace("|", "");
					String cl_policy_type_code = l_policy_type_code;
					cl_policy_type_code = cl_policy_type_code.replace("|", "");
					con =  EMDataSource.getConnection();
					cstmt = con.prepareCall(servChargeByCLQuery.toString());
					System.out.println(" ::: BLVISITCHARGE.CHECK_ADDL_SERV_CHARGE_BY_CL parameters : l_facility_id : "+l_facility_id+" : l_billing_group_code : "+cl_billing_group_code+": l_payer_group_code : "+cl_payer_group_code);
					System.out.println(" ::: BLVISITCHARGE.CHECK_ADDL_SERV_CHARGE_BY_CL parameters : l_payer_code : "+cl_payer_code+" : l_policy_type_code : "+cl_policy_type_code+": l_location_code : "+l_location_code);
					System.out.println(" ::: BLVISITCHARGE.CHECK_ADDL_SERV_CHARGE_BY_CL parameters : l_visit_type : "+l_visit_type+" : l_practitioner_id : "+l_practitioner_id);
					cstmt.setString(1, l_facility_id);
					cstmt.setString(2,"V");
					cstmt.setString(3, cl_billing_group_code);
					cstmt.setString(4, cl_payer_group_code); // payer_group_code
					cstmt.setString(5, cl_payer_code); 
					cstmt.setString(6, cl_policy_type_code); // payer_code
					cstmt.setString(7, l_location_code);
					cstmt.setString(8, l_visit_type);
					cstmt.setString(9, l_practitioner_id);
	
					cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(16,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(17,java.sql.Types.VARCHAR);
	
					cstmt.execute();
					
					
					strAddlServAvailYN = cstmt.getString(10); 
					if(strAddlServAvailYN == null ) strAddlServAvailYN="N";
					System.out.println(" ::: strAddlServAvailYN : "+strAddlServAvailYN);
	
					strAddlServPanelInd=cstmt.getString(11);
					if(strAddlServPanelInd==null) strAddlServPanelInd="";
					System.out.println(" ::: strAddlServPanelInd : "+strAddlServPanelInd);
	
					strAddlServPanelCode=cstmt.getString(12);
					if(strAddlServPanelCode==null) strAddlServPanelCode="";
					System.out.println(" ::: strAddlServPanelCode : "+strAddlServPanelCode);
	
					strAddlChargeType = cstmt.getString(13);
					if(strAddlChargeType == null) strAddlChargeType="";
					System.out.println(" ::: strAddlChargeType : "+strAddlChargeType);
	
					dflt_excl_overide_code = cstmt.getString(14);
					if(dflt_excl_overide_code == null) dflt_excl_overide_code="";
					System.out.println(" ::: dflt_excl_overide_code : "+dflt_excl_overide_code);
	
					String error_level=cstmt.getString(15);
					String sys_message_id=cstmt.getString(16);
					String error_text=cstmt.getString(17);
					
					System.out.println(" ::: BLVISITCHARGE.CHECK_ADDL_SERV_CHARGE_BY_CL ::: error_level : "+error_level+" : sys_message_id : "+sys_message_id+" : error_text : "+error_text);
	
					if (error_level == null) error_level ="";
					if (sys_message_id ==null) sys_message_id ="";
					if (error_text ==null) error_text ="";
					
					if((!error_text.equals("") && error_level.equals("10")) || !sys_message_id.equals(""))
					{
						l_proc_success="N";
					}
					else
					{
						l_proc_success="Y";
					}
					
				}catch(Exception e)
				{
					l_app_msg = "Eception in BLVISITCHARGE.CHECK_ADDL_SERV_CHARGE_BY_CL : "+e.getMessage();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					e.printStackTrace();
				}		
				finally {
					XHUtil.closeDBResources(null, cstmt, null);
					EMDataSource.returnConnection(con);
				}
			}
			
			l_app_msg = " ::: Fetching Service Date ::: ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			try{
				String servDateQuery = "select nvl(no_of_decimal,2),to_char(sysdate,'dd/mm/yyyy HH24:MI') from sm_acc_entity_param where acc_entity_id='ZZ'";
				con =  EMDataSource.getConnection();
				pstmt = con.prepareStatement(servDateQuery.toString());
				rset = pstmt.executeQuery();
				while(rset.next())
				{
					noofdecimal  =  rset.getInt(1);
					service_date = rset.getString(2);
				}
				System.out.println(" ::: service_date : "+service_date+" : noofdecimal : "+noofdecimal);
				
				
			}catch(Exception e)
			{
				l_app_msg = "Eception in sm_acc_entity_param : "+e.getMessage();
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				e.printStackTrace();
			}		
			finally {
				XHUtil.closeDBResources(null, cstmt, null);
				EMDataSource.returnConnection(con);
			}
			
			l_app_msg = " ::: calling BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS for Fetch AddlServPanel ::: proc_success : "+l_proc_success;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			str_epi_type_clinic_code = l_episode_type+"#"+l_location_code;
			System.out.println(" ::: str_epi_type_clinic_code : "+str_epi_type_clinic_code);
			
			if(l_proc_success.equals("Y"))
			{
				if(strAddlServAvailYN.equals("Y") && !strAddlServPanelCode.equals(""))
				{
					try{
						if(l_billing_group_code.equals("CASH")){
							l_non_ins_blng_grp_id = "";
						}
						String incl_excl_overide_flag = "";
						service_date = service_date.substring(0,10);
						String addlServPanelQuery = "{call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS('"+l_facility_id+"','"+l_calling_module_id+"','"+str_epi_type_clinic_code+"','"+l_patient_id+"',"+Long.parseLong(l_episode_id)+","+Integer.parseInt(l_visitnum)+",'"+l_encounter_id+"',"+l_acc_seq_no+",TO_DATE('"+service_date+"','dd/mm/yyyy'),'"+strAddlServPanelInd+"','"+strAddlServPanelCode+"',1,'P','"+l_practitioner_id+"','"+l_billing_group_code+"','"+l_payer_group_code+"','"+l_payer_code+"','"+l_policy_type_code+"','"+l_priority+"','"+l_policy_number+"','"+l_policy_start_date+"','"+l_policy_end_date+"','"+l_credit_auth_ref+"','"+l_credit_auth_date+"','"+l_effective_from+"','"+l_effective_to+"','"+l_approved_amt+"','"+l_approved_days+"','"+l_non_ins_blng_grp_id+"','"+l_non_ins_cust_code+"','"+l_non_ins_cust_group_code+"',?,?,?,?,?,?,'"+incl_excl_overide_flag+"','"+dflt_excl_overide_code+"',?,'"+l_locale+"',?,?,?)}";
						
						System.out.println(" ::: BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS Addl Serv Panel 3051 : "+addlServPanelQuery);
						
						con =  EMDataSource.getConnection();
						cstmt = con.prepareCall(addlServPanelQuery.toString());
						
						cstmt.registerOutParameter(1,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(3,java.sql.Types.DOUBLE);
						cstmt.registerOutParameter(4,java.sql.Types.DOUBLE);
						cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(8,java.sql.Types.DOUBLE);
						cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);	
						cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
						
						cstmt.execute();
						
						
						
						strAddlServPanelStr= cstmt.getString(1);
						if(strAddlServPanelStr==null) strAddlServPanelStr="";
						System.out.println(" ::: strAddlServPanelStr : "+strAddlServPanelStr);
		
						String error_level= cstmt.getString(8);
						String sys_message_id= cstmt.getString(9);
						String error_text= cstmt.getString(10);
		
						if (error_level == null) error_level ="";
						if (sys_message_id ==null) sys_message_id ="";
						if (error_text ==null) error_text ="";
						System.out.println(" ::: Fetch AddlServPanel : error_level : "+error_level+" : sys_message_id : "+sys_message_id+" : error_text : "+error_text);
						
					}catch(Exception e)
					{
						l_app_msg = "Eception in BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS for Fetch AddlServPanel : "+e.getMessage();
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						e.printStackTrace();
					}		
					finally {
						XHUtil.closeDBResources(null, cstmt, null);
						EMDataSource.returnConnection(con);
					}
				}
			}
			
			l_app_msg = " ::: calling BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS for Fetch HospServPanel ::: proc_success : "+l_proc_success;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg); 
			
			str_epi_type_clinic_code = l_episode_type+"#"+l_location_code;
			System.out.println(" ::: str_epi_type_clinic_code : "+str_epi_type_clinic_code);
			
			if(l_proc_success.equals("Y"))
			{
			
				try
				{
					service_date = service_date.substring(0,10);
					System.out.println(" ::: BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS Query 3276 : l_episode_id : "+l_episode_no+" : l_visitnum : "+l_visitnum+" : service_date : "+service_date);
					int intVisitNum = Integer.parseInt(l_visitnum);
					long intEpisodeNum = Long.parseLong(l_episode_no);
					String strNull = "";
					//l_payer_group_code+"','"+l_payer_code
					String h_payer_group_code = l_payer_group_code;					
					String h_payer_code = l_payer_code;
					String h_effective_to = l_effective_to;
					if(!l_billing_group_code.equals("CASH")){
						if(!h_payer_group_code.contains("|")) h_payer_group_code = h_payer_group_code+"|";
						if(!h_payer_code.contains("|")) h_payer_code = h_payer_code+"|";
						if(!h_effective_to.contains("|")) h_effective_to = h_effective_to+"|";
					}
					
					if(l_billing_group_code.equals("CASH")){
						l_non_ins_blng_grp_id = "";
					}
					
					String hospServPanelQuery = "{call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS('"+l_facility_id+"','"+l_calling_module_id+"','"+str_epi_type_clinic_code+"','"+l_patient_id+"',"+intEpisodeNum+","+intVisitNum+",'"+l_encounter_id+"',"+l_acc_seq_no+",TO_DATE('"+service_date+"','dd/mm/yyyy'),'"+strHospServPanelInd+"','"+strHospServPanelCode+"',1,'P','"+l_practitioner_id+"','"+l_billing_group_code+"','"+h_payer_group_code+"','"+h_payer_code+"','"+l_policy_type_code+"','"+l_priority+"','"+l_policy_number+"','"+l_policy_start_date+"','"+l_policy_end_date+"','"+l_credit_auth_ref+"','"+l_credit_auth_date+"','"+l_effective_from+"','"+h_effective_to+"','"+l_approved_amt+"','"+l_approved_days+"','"+l_non_ins_blng_grp_id+"','"+l_non_ins_cust_code+"','"+l_non_ins_cust_group_code+"',?,?,?,?,?,?,'"+strNull+"','"+strNull+"',?,'"+l_locale+"',?,?,?)}";
					System.out.println(" ::: BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS Query 3274 : "+hospServPanelQuery);
					
					con =  EMDataSource.getConnection();
					cstmt = con.prepareCall(hospServPanelQuery.toString());
					
					cstmt.registerOutParameter(1,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(3,java.sql.Types.DOUBLE);
					cstmt.registerOutParameter(4,java.sql.Types.DOUBLE);
					cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(8,java.sql.Types.DOUBLE);
					cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);	
					cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);

					cstmt.execute();	
					
					strHospServPanelStr=cstmt.getString(1);					
					if(strHospServPanelStr==null) strHospServPanelStr="";
					System.out.println(" ::: strHospServPanelStr : "+strHospServPanelStr);
					String error_level=cstmt.getString(8);
					String sys_message_id=cstmt.getString(9);
					String error_text=cstmt.getString(10);	
					if (error_level == null) error_level ="";
					if (sys_message_id ==null) sys_message_id ="";
					if (error_text ==null) error_text ="";
					System.out.println(" ::: Fetch HospServPanel : error_level : "+error_level+" : sys_message_id : "+sys_message_id+" : error_text : "+error_text);
					
				}
				catch(Exception e)
				{
					l_app_msg = "Eception in BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS for Fetch HospServPanel : "+e.getMessage();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					e.printStackTrace();
				}		
				finally {
					XHUtil.closeDBResources(null, cstmt, null);
					EMDataSource.returnConnection(con);
				}
			}
			
			l_app_msg = " ::: calling BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS for Fetch MedlServPanel ::: proc_success : "+l_proc_success;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			str_epi_type_clinic_code = l_episode_type+"#"+l_location_code;
			System.out.println(" ::: str_epi_type_clinic_code : "+str_epi_type_clinic_code);
			
			if(l_proc_success.equals("Y"))
			{
				try{
					
					service_date = service_date.substring(0,10);
					System.out.println(" ::: BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS Query 3164 : l_episode_id : "+l_episode_no+" : l_visitnum : "+l_visitnum+" : service_date : "+service_date);
					int intVisitNum = Integer.parseInt(l_visitnum);
					long intEpisodeNum = Long.parseLong(l_episode_no);
					String strNull = "";					
					String m_payer_group_code = l_payer_group_code;					
					String m_payer_code = l_payer_code;
					String m_effective_to = l_effective_to;
					if(!l_billing_group_code.equals("CASH")){
						if(!m_payer_group_code.contains("|")) m_payer_group_code = m_payer_group_code+"|";
						if(!m_payer_code.contains("|")) m_payer_code = m_payer_code+"|";
						if(!m_effective_to.contains("|")) m_effective_to = m_effective_to+"|";
					}
					
					if(l_billing_group_code.equals("CASH")){
						l_non_ins_blng_grp_id = "";
					}
					
					String medServPanelQuery = "{call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS('"+l_facility_id+"','"+l_calling_module_id+"','"+str_epi_type_clinic_code+"','"+l_patient_id+"',"+intEpisodeNum+","+intVisitNum+",'"+l_encounter_id+"',"+l_acc_seq_no+",TO_DATE('"+service_date+"','dd/mm/yyyy'),'"+strMedServPanelInd+"','"+strMedServPanelCode+"',1,'P','"+l_practitioner_id+"','"+l_billing_group_code+"','"+m_payer_group_code+"','"+m_payer_code+"','"+l_policy_type_code+"','"+l_priority+"','"+l_policy_number+"','"+l_policy_start_date+"','"+l_policy_end_date+"','"+l_credit_auth_ref+"','"+l_credit_auth_date+"','"+l_effective_from+"','"+m_effective_to+"','"+l_approved_amt+"','"+l_approved_days+"','"+l_non_ins_blng_grp_id+"','"+l_non_ins_cust_code+"','"+l_non_ins_cust_group_code+"',?,?,?,?,?,?,'"+strNull+"','"+strNull+"',?,'"+l_locale+"',?,?,?)}";
	                System.out.println(" ::: BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS Query2 3163 : "+medServPanelQuery);
	                
	                con =  EMDataSource.getConnection();
					cstmt = con.prepareCall(medServPanelQuery.toString());
					
					cstmt.registerOutParameter(1,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(3,java.sql.Types.DOUBLE);
					cstmt.registerOutParameter(4,java.sql.Types.DOUBLE);
					cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(8,java.sql.Types.DOUBLE);
					cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);	
					cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);

					cstmt.execute();	
					
					strMedServPanelStr = cstmt.getString(1);					
					if(strMedServPanelStr==null) strMedServPanelStr="";
					System.out.println(" ::: strMedServPanelStr : "+strMedServPanelStr);
					String error_level = cstmt.getString(8);
					String sys_message_id = cstmt.getString(9);
					String error_text = cstmt.getString(10);
	
					if (error_level == null) error_level ="";
					if (sys_message_id ==null) sys_message_id ="";
					if (error_text ==null) error_text ="";
					System.out.println(" ::: Fetch MedServPanel : error_level : "+error_level+" : sys_message_id : "+sys_message_id+" : error_text : "+error_text);
					
				}
				catch(Exception e)
				{
					l_app_msg = "Eception in BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS for Fetch MedServPanel : "+e.getMessage();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					e.printStackTrace();
				}		
				finally {
					XHUtil.closeDBResources(null, cstmt, null);
					EMDataSource.returnConnection(con);
				}
			}
			
			
			l_app_msg = " ::: insertable while proc_update_new_values : "+insertable+" ::: Error Code : "+l_errcd;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			if (insertable)
			{
				l_app_msg = " ::: calling blaudit proc_update_new_values ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				String l_strNull = "";
				
				try{
					String proc_update_new_values_query = "{call blaudit.proc_update_new_values( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
					
					con = EMDataSource.getConnection();				
					cstmt = con.prepareCall(proc_update_new_values_query);
					
					System.out.println(" ::: blaudit.proc_update_new_values parameters : l_patient_id : "+l_patient_id+" : l_facility_id : "+l_facility_id+" : l_calling_module_id : "+l_calling_module_id);
					System.out.println(" ::: blaudit.proc_update_new_values parameters : l_calling_function_id : "+l_calling_function_id+" : l_episode_type : "+l_episode_type+" : l_episode_no : "+l_episode_no);
					System.out.println(" ::: blaudit.proc_update_new_values parameters : l_visitnum : "+l_visitnum+" : l_str_upd_patient_fin_dtls_yn : "+l_str_upd_patient_fin_dtls_yn+" : l_str_fin_auth_user_id : "+l_str_fin_auth_user_id);
					System.out.println(" ::: blaudit.proc_update_new_values parameters : l_financial_remarks : "+l_financial_remarks);
					
					
					cstmt.setString( 1, l_patient_id);        
					cstmt.setString( 2, l_facility_id);      
					cstmt.setString( 3, l_calling_module_id); 
					cstmt.setString( 4, l_calling_function_id);
					cstmt.setString( 5, "" );                                        
					cstmt.setString(6, l_episode_type);  // Episode Type ENH                                 				
					cstmt.setLong(7, Long.parseLong(l_episode_no));              
					cstmt.setInt(8, Integer.parseInt(l_visitnum));
					cstmt.setString(7, l_episode_no);              
					cstmt.setString(8, l_visitnum); 
					cstmt.setString(9, l_str_upd_patient_fin_dtls_yn);
					cstmt.setString(10,"O");                                       
					cstmt.setString(11, l_str_fin_auth_user_id);
					cstmt.setString(12,l_strNull);
					cstmt.setString(13,l_strNull);
					cstmt.setString(14,l_strNull);
					cstmt.setString(15,l_strNull);
					cstmt.setString(16, l_financial_remarks);
					cstmt.setString(17,	added_by_id);  
					cstmt.setString(18,	added_at_ws_no);    
					cstmt.registerOutParameter(19,java.sql.Types.NUMERIC);
					cstmt.registerOutParameter(20,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(21,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(22,java.sql.Types.VARCHAR);
					cstmt.execute();
					
					String strSysMessg = cstmt.getString(21);
					String strErrText = cstmt.getString(22);
					
					l_app_msg = " ::: blaudit.proc_update_new_values...strSysMessg.."+strSysMessg+"..strErrText.."+strErrText;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					
					if ((strSysMessg != null))
					{
						if (!(strSysMessg.equals("")) || !(strSysMessg.equalsIgnoreCase("null") ))
						{
							insertable=false;
						}
						
					}
					if ((strErrText != null))
					{
						if (!(strErrText.equals("")) || !(strErrText.equalsIgnoreCase("null") ) )
						{
							insertable=false;
						}
						
					}
					
				}catch(Exception e){
					l_app_msg =  " ::: Execption in blaudit.proc_update_new_values : "+e.getMessage();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					e.printStackTrace();
					
				}finally {
					EMDataSource.returnConnection(con);
					XHUtil.closeDBResources(null, cstmt, null);
				}
				
			}
			
			Map<String, String> policyHdrMap = null;
			Map<String, String> policyOutpatMap = null;
			Map<String, String> policyInpatMap = null;
			Map<String, String> policyExternalMap = null;
			Map<String, String> policyServiceMap = null;
			String q_visit_no = "";
			String modifiedAtWorkstation = "";
			String h_priority = l_priority;
						
			if(!l_billing_group_code.equals("CASH")){
				q_visit_no = l_encounter_id.substring(l_encounter_id.length()-4);
				modifiedAtWorkstation = "tst";
				
				h_priority = h_priority.replace("|", "");
				
				String p_payer_group_code = l_payer_group_code;
				p_payer_group_code = p_payer_group_code.replace("|", "");
				String p_payer_code = l_payer_code;
				p_payer_code = p_payer_code.replace("|", "");
				String p_policy_type_code = l_policy_type_code;
				p_policy_type_code = p_policy_type_code.replace("|", "");
				System.out.println(" ::: p_payer_group_code : "+p_payer_group_code+" : p_payer_code : "+p_payer_code+" : p_policy_type_code : "+p_policy_type_code);
				policyHdrMap = getPolicyDefHdrInfo(l_facility_id, p_payer_group_code, p_payer_code, p_policy_type_code);
				policyOutpatMap = getPolicyDefOutpatInfo(l_facility_id, p_payer_group_code, p_payer_code, p_policy_type_code);
				policyInpatMap = getPolicyDefInpatInfo(l_facility_id, p_payer_group_code, p_payer_code, p_policy_type_code);
				policyExternalMap = getPolicyDefExternalInfo(l_facility_id, p_payer_group_code, p_payer_code, p_policy_type_code);
				policyServiceMap = getPolicyDefServiceInfo(l_facility_id, p_payer_group_code, p_payer_code, p_policy_type_code);
				System.out.println(" ::: policyHdrMap : "+policyHdrMap);
				System.out.println(" ::: policyOutpatMap : "+policyOutpatMap);
				System.out.println(" ::: policyInpatMap : "+policyInpatMap);
				System.out.println(" ::: policyExternalMap : "+policyExternalMap);
				System.out.println(" ::: policyServiceMap : "+policyServiceMap);				
			}
			
			l_app_msg = " ::: insertable while blinstransactions.insert_enc_spec_policy_hdr : "+insertable+" ::: Error Code : "+l_errcd;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			if(insertable && !l_billing_group_code.equals("CASH"))
			{
				
				try{
					
					String policyStatus = null;
					String illDedAmt = null;
					String vstDedAmt = null;
					String AccEntityID = null;
					String h_policy_number = l_policy_number;
					h_policy_number = h_policy_number.replace("|", "");
					String polRefCustCode = null;
					String blngGrpid = "0";
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String AcrossGroupId = null;
					
					String InsertEncSpecPolicyHdrQuery = "{ call  blinstransactions.insert_enc_spec_policy_hdr (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
					
					con = EMDataSource.getConnection();				
					cstmt = con.prepareCall(InsertEncSpecPolicyHdrQuery.toString());
					
					cstmt.setString(1, l_facility_id);
					System.out.println(" ::: l_facility_id : "+l_facility_id);
					cstmt.setString(2, l_patient_id);
					System.out.println(" ::: l_patient_id : "+l_patient_id);
					cstmt.setString(3, l_episode_type);
					System.out.println(" ::: l_episode_type : "+l_episode_type);
					cstmt.setString(4, l_episode_no);
					System.out.println(" ::: l_episode_no : "+l_episode_no);
					cstmt.setString(5, q_visit_no);
					System.out.println(" ::: q_visit_no : "+q_visit_no);
					cstmt.setString(6, l_encounter_id);
					System.out.println(" ::: l_encounter_id : "+l_encounter_id);
					cstmt.setString(7, policyHdrMap.get("hdr_policy_type_code"));//hdr_policy_type_code	
					System.out.println(" ::: hdr_policy_type_code : "+policyHdrMap.get("hdr_policy_type_code"));
					cstmt.setString(8, added_by_id);
					System.out.println(" ::: added_by_id : "+added_by_id);
					cstmt.setString(9, added_by_id);
					System.out.println(" ::: added_by_id : "+added_by_id);
					cstmt.setString(10, modifiedAtWorkstation);
					System.out.println(" ::: modifiedAtWorkstation : "+modifiedAtWorkstation);
					cstmt.setString(11, l_facility_id);
					System.out.println(" ::: l_facility_id : "+l_facility_id);
					cstmt.setString(12, modifiedAtWorkstation);
					System.out.println(" ::: modifiedAtWorkstation : "+modifiedAtWorkstation);
					cstmt.setString(13, l_facility_id);				
					System.out.println(" ::: l_facility_id : "+l_facility_id);
					cstmt.setString(14, policyStatus);
					System.out.println(" ::: policyStatus : "+policyStatus);
					cstmt.setString(15, illDedAmt);
					System.out.println(" ::: illDedAmt : "+illDedAmt);
					cstmt.setString(16, vstDedAmt);
					System.out.println(" ::: vstDedAmt : "+vstDedAmt);
					cstmt.setString(17, AccEntityID);
					System.out.println(" ::: AccEntityID : "+AccEntityID);
					cstmt.setString(18, policyHdrMap.get("hdr_cust_code"));//hdr_cust_code
					System.out.println(" ::: hdr_cust_code : "+policyHdrMap.get("hdr_cust_code"));
					cstmt.setString(19, h_priority);
					System.out.println(" ::: h_priority : "+h_priority);
					cstmt.setString(20, policyHdrMap.get("hdr_cust_group_code"));//hdr_cust_group_code
					System.out.println(" ::: hdr_cust_group_code : "+policyHdrMap.get("hdr_cust_group_code"));
					cstmt.setString(21, polRefCustCode);
					System.out.println(" ::: polRefCustCode : "+polRefCustCode);
					cstmt.setString(22, blngGrpid);
					System.out.println(" ::: blngGrpid : "+blngGrpid);
					cstmt.setString(23, h_policy_number);
					System.out.println(" ::: h_policy_number : "+h_policy_number);

					if((policyHdrMap.get("hdr_effective_from") == null) || ("".equals(policyHdrMap.get("hdr_effective_from")))){
						cstmt.setString(24, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(policyHdrMap.get("hdr_effective_from")).getTime());
						cstmt.setDate(24, fromDt);
						System.out.println(" ::: fromDt : "+fromDt);
						
					}
					cstmt.setString(25, policyServiceMap.get("service_excl_incl_ind"));//policyServiceMap
					System.out.println(" ::: service_excl_incl_ind : "+policyServiceMap.get("service_excl_incl_ind"));
					cstmt.setString(26, policyServiceMap.get("service_ovride_incl_excl_unsp_serv_yn"));
					System.out.println(" ::: service_ovride_incl_excl_unsp_serv_yn : "+policyServiceMap.get("service_ovride_incl_excl_unsp_serv_yn"));
					cstmt.setString(27, policyServiceMap.get("service_last_payer_coverage_yn"));
					System.out.println(" ::: service_last_payer_coverage_yn : "+policyServiceMap.get("service_last_payer_coverage_yn"));
					cstmt.setString(28, policyServiceMap.get("service_cumm_cvrg_with_oth_payers_yn"));
					System.out.println(" ::: service_cumm_cvrg_with_oth_payers_yn : "+policyServiceMap.get("service_cumm_cvrg_with_oth_payers_yn"));
					
					cstmt.setString(29, policyOutpatMap.get("outpat_credit_req")); //policyOutpatMap
					System.out.println(" ::: outpat_credit_req : "+policyOutpatMap.get("outpat_credit_req"));
					cstmt.setString(30, policyInpatMap.get("inpat_credit_req"));
					System.out.println(" ::: inpat_credit_req : "+policyInpatMap.get("inpat_credit_req"));
					cstmt.setString(31, policyExternalMap.get("external_credit_req"));
					System.out.println(" ::: external_credit_req : "+policyExternalMap.get("external_credit_req"));
					cstmt.setString(32, policyOutpatMap.get("outpat_credit_mand"));
					System.out.println(" ::: outpat_credit_mand : "+policyOutpatMap.get("outpat_credit_mand"));
					cstmt.setString(33, policyInpatMap.get("inpat_credit_mand"));
					System.out.println(" ::: inpat_credit_mand : "+policyInpatMap.get("inpat_credit_mand"));
					cstmt.setString(34, policyExternalMap.get("external_credit_mand"));
					System.out.println(" ::: external_credit_mand : "+policyExternalMap.get("external_credit_mand"));
					cstmt.setString(35, policyOutpatMap.get("outpat_credit_ref"));
					System.out.println(" ::: outpat_credit_ref : "+policyOutpatMap.get("outpat_credit_ref"));
					cstmt.setString(36, policyInpatMap.get("inpat_credit_ref"));
					System.out.println(" ::: inpat_credit_ref : "+policyInpatMap.get("inpat_credit_ref"));
					cstmt.setString(37, policyExternalMap.get("external_credit_ref"));	
					System.out.println(" ::: external_credit_ref : "+policyExternalMap.get("external_credit_ref"));
					cstmt.setString(38, policyOutpatMap.get("outpat_covered"));
					System.out.println(" ::: outpat_covered : "+policyOutpatMap.get("outpat_covered"));
					cstmt.setString(39, returnVal(policyInpatMap.get("inpat_covered"),"N"));//inpat_covered
					System.out.println(" ::: inpat_covered : "+policyInpatMap.get("inpat_covered"));
					cstmt.setString(40, policyExternalMap.get("external_covered"));//external_covered
					System.out.println(" ::: external_covered : "+policyExternalMap.get("external_covered"));
					cstmt.setString(41, policyOutpatMap.get("outpat_limit_type"));
					System.out.println(" ::: outpat_limit_type : "+policyOutpatMap.get("outpat_limit_type"));
					cstmt.setString(42, policyInpatMap.get("inpat_limit_type"));
					System.out.println(" ::: inpat_limit_type : "+policyInpatMap.get("inpat_limit_type"));
					cstmt.setString(43, policyExternalMap.get("external_limit_type"));
					System.out.println(" ::: external_limit_type : "+policyExternalMap.get("external_limit_type"));
					cstmt.setString(44, policyOutpatMap.get("outpat_day_limit_type"));
					System.out.println(" ::: outpat_day_limit_type : "+policyOutpatMap.get("outpat_day_limit_type"));
					cstmt.setString(45, policyInpatMap.get("inpat_day_limit_type"));
					System.out.println(" ::: inpat_day_limit_type : "+policyInpatMap.get("inpat_day_limit_type"));
					cstmt.setString(46, policyExternalMap.get("external_day_limit_type"));
					System.out.println(" ::: external_day_limit_type : "+policyExternalMap.get("external_day_limit_type"));
					cstmt.setString(47, (policyOutpatMap.get("outpat_np_of_days")));
					System.out.println(" ::: outpat_np_of_days : "+policyOutpatMap.get("outpat_np_of_days"));
					cstmt.setString(48, (policyInpatMap.get("inpat_np_of_days")));
					System.out.println(" ::: inpat_np_of_days : "+policyInpatMap.get("inpat_np_of_days"));
					cstmt.setString(49, (policyExternalMap.get("external_np_of_days")));
					System.out.println(" ::: external_np_of_days : "+policyExternalMap.get("external_np_of_days"));
					cstmt.setString(50, (policyOutpatMap.get("outpat_amt_limit")));
					System.out.println(" ::: outpat_amt_limit : "+policyOutpatMap.get("outpat_amt_limit"));
					cstmt.setString(51, (policyInpatMap.get("inpat_amt_limit")));
					System.out.println(" ::: inpat_amt_limit : "+policyInpatMap.get("inpat_amt_limit"));
					cstmt.setString(52, (policyExternalMap.get("external_amt_limit")));		
					System.out.println(" ::: external_amt_limit : "+policyExternalMap.get("external_amt_limit"));
					cstmt.setString(53, (policyOutpatMap.get("outpat_amt_limit_type")));
					System.out.println(" ::: outpat_amt_limit_type : "+policyOutpatMap.get("outpat_amt_limit_type"));
					cstmt.setString(54, (policyInpatMap.get("inpat_amt_limit_type")));
					System.out.println(" ::: inpat_amt_limit_type : "+policyInpatMap.get("inpat_amt_limit_type"));
					cstmt.setString(55, (policyExternalMap.get("external_amt_limit_type")));	
					System.out.println(" ::: external_amt_limit_type : "+policyExternalMap.get("external_amt_limit_type"));
					cstmt.setString(56, policyOutpatMap.get("outpat_mand_bill"));
					System.out.println(" ::: outpat_mand_bill : "+policyOutpatMap.get("outpat_mand_bill"));
					cstmt.setString(57, policyInpatMap.get("inpat_mand_bill"));
					System.out.println(" ::: inpat_mand_bill : "+policyInpatMap.get("inpat_mand_bill"));
					cstmt.setString(58, policyExternalMap.get("external_mand_bill"));
					System.out.println(" ::: external_mand_bill : "+policyExternalMap.get("external_mand_bill"));
					cstmt.setString(59, policyOutpatMap.get("outpat_mand_inv"));
					System.out.println(" ::: outpat_mand_inv : "+policyOutpatMap.get("outpat_mand_inv"));
					cstmt.setString(60, policyInpatMap.get("inpat_mand_inv"));
					System.out.println(" ::: inpat_mand_inv : "+policyInpatMap.get("inpat_mand_inv"));
					cstmt.setString(61, policyExternalMap.get("external_mand_inv"));
					System.out.println(" ::: external_mand_inv : "+policyExternalMap.get("external_mand_inv"));
					cstmt.setString(62, (policyOutpatMap.get("outpat_amt_gross_net")));
					System.out.println(" ::: outpat_amt_gross_net : "+policyOutpatMap.get("outpat_amt_gross_net"));
					cstmt.setString(63, (policyInpatMap.get("inpat_amt_gross_net")));
					System.out.println(" ::: inpat_amt_gross_net : "+policyInpatMap.get("inpat_amt_gross_net"));
					cstmt.setString(64, (policyExternalMap.get("external_amt_gross_net")));
					System.out.println(" ::: external_amt_gross_net : "+policyExternalMap.get("external_amt_gross_net"));
					cstmt.setString(65, (policyHdrMap.get("hdr_copay_perc")));//hdr_copay_perc
					System.out.println(" ::: hdr_copay_perc : "+policyHdrMap.get("hdr_copay_perc"));
					cstmt.setString(66, (policyHdrMap.get("hdr_policy_coverage_basis")));//hdr_policy_coverage_basis
					System.out.println(" ::: hdr_policy_coverage_basis : "+policyHdrMap.get("hdr_policy_coverage_basis"));
					cstmt.setString(67, (policyHdrMap.get("hdr_payer_cov_rule")));//hdr_payer_cov_rule
					System.out.println(" ::: hdr_payer_cov_rule : "+policyHdrMap.get("hdr_payer_cov_rule"));
					
					
					cstmt.setString(68, policyOutpatMap.get("outpat_patient_copay"));
					System.out.println(" ::: outpat_patient_copay : "+policyOutpatMap.get("outpat_patient_copay"));
					cstmt.setString(69, policyInpatMap.get("inpat_patient_copay"));
					System.out.println(" ::: inpat_patient_copay : "+policyInpatMap.get("inpat_patient_copay"));
					cstmt.setString(70, policyExternalMap.get("external_patient_copay"));	
					System.out.println(" ::: external_patient_copay : "+policyExternalMap.get("external_patient_copay"));
					cstmt.setString(71, policyOutpatMap.get("outpat_patient_limit_amount"));
					System.out.println(" ::: outpat_patient_limit_amount : "+policyOutpatMap.get("outpat_patient_limit_amount"));
					cstmt.setString(72, policyInpatMap.get("inpat_patient_limit_amount"));	
					System.out.println(" ::: inpat_patient_limit_amount : "+policyInpatMap.get("inpat_patient_limit_amount"));
					cstmt.setString(73, policyExternalMap.get("external_patient_limit_amount"));
					System.out.println(" ::: external_patient_limit_amount : "+policyExternalMap.get("external_patient_limit_amount"));
					
					cstmt.setString(74, AcrossGroupId);
					System.out.println(" ::: AcrossGroupId : "+AcrossGroupId);
					
					cstmt.registerOutParameter(75, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(76, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(77, java.sql.Types.VARCHAR);
					cstmt.execute();
					
					String str_error_level = cstmt.getString(75);
					String str_sysmesage_id = cstmt.getString(76);
					String str_error_text = cstmt.getString(77);
					System.out.println(" ::: blinstransactions.insert_enc_spec_policy_hdr output : str_error_level : "+str_error_level+" : str_sysmesage_id : "+str_sysmesage_id+" : str_error_text : "+str_error_text);
					
					
				}catch(Exception e){
					l_app_msg =  " ::: Execption in blinstransactions.insert_enc_spec_policy_hdr : "+e.getMessage();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					e.printStackTrace();
					
				}finally {
					EMDataSource.returnConnection(con);
					XHUtil.closeDBResources(null, cstmt, null);
				}
				
			}
			
			l_app_msg = " ::: insertable while blinstransactions.insert_enc_spec_policy_dtl_blk : "+insertable+" ::: Error Code : "+l_errcd;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			if(insertable && !l_billing_group_code.equals("CASH"))
			{
				try{
					
					String h_policy_number = l_policy_number;
					h_policy_number = h_policy_number.replace("|", "");
					String polRefCustCode = null;
					String blngGrpid = "0";
					String p_base_prev_ind  = "B";
					
					String p_pr_episode_type = "", p_pr_patient_id = "", p_pr_episode_id = "", p_pr_visit_id = "";
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					
					String insertEncSpecpolicyDtlBlkQuery = "{ call   blinstransactions.insert_enc_spec_policy_dtl_blk (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
					
					con = EMDataSource.getConnection();				
					cstmt = con.prepareCall(insertEncSpecpolicyDtlBlkQuery.toString());
					
					cstmt.setString(1, l_facility_id);    
					cstmt.setString(2, policyHdrMap.get("hdr_cust_group_code"));
					System.out.println(" ::: hdr_cust_group_code 2 : "+policyHdrMap.get("hdr_cust_group_code"));
					cstmt.setString(3, policyHdrMap.get("hdr_cust_code"));
					System.out.println(" ::: hdr_cust_code 2 : "+policyHdrMap.get("hdr_cust_code"));
					cstmt.setString(4, policyHdrMap.get("hdr_policy_type_code"));  
					System.out.println(" ::: hdr_policy_type_code 2 : "+policyHdrMap.get("hdr_policy_type_code"));
					cstmt.setString(5, l_episode_type);
					System.out.println(" ::: episode_type 2 : "+l_episode_type);
					cstmt.setString(6, l_patient_id);
					System.out.println(" ::: patient_id 2 : "+l_patient_id);					
					cstmt.setString(7, l_episode_no);
					System.out.println(" ::: l_episode_no 2 : "+l_episode_no);
					cstmt.setString(8, q_visit_no);
					System.out.println(" ::: q_visit_no 2 : "+q_visit_no);
					cstmt.setString(9, p_pr_episode_type); 
					System.out.println(" ::: p_pr_episode_type 2 : "+p_pr_episode_type);
					cstmt.setString(10, p_pr_patient_id);
					System.out.println(" ::: p_pr_patient_id 2 : "+p_pr_patient_id);
					cstmt.setString(11, p_pr_episode_id);
					System.out.println(" ::: p_pr_episode_id 2 : "+p_pr_episode_id);
					cstmt.setString(12, p_pr_visit_id);
					System.out.println(" ::: p_pr_visit_id 2 : "+p_pr_visit_id);
					cstmt.setString(13, l_encounter_id);
					System.out.println(" ::: l_encounter_id 2 : "+l_encounter_id);
					cstmt.setString(14,"");                   
					cstmt.setString(15, h_priority);
					System.out.println(" ::: h_priority 2 : "+h_priority);
					
					            
					
					if((policyHdrMap.get("hdr_effective_from") == null) || ("".equals(policyHdrMap.get("hdr_effective_from")))){
						cstmt.setString(16, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(policyHdrMap.get("hdr_effective_from")).getTime());
						cstmt.setDate(16, fromDt);
						System.out.println(" ::: fromDt 2 : "+fromDt);
					}
					
					cstmt.setString(17, h_policy_number);
					System.out.println(" ::: h_policy_number 2 : "+h_policy_number);
					cstmt.setString(18, blngGrpid);
					System.out.println(" ::: blngGrpid 2 : "+blngGrpid);
					cstmt.setString(19, polRefCustCode);
					System.out.println(" ::: polRefCustCode 2 : "+polRefCustCode);
					cstmt.setString(20, added_by_id); 
					System.out.println(" ::: added_by_id 2 : "+added_by_id);
					cstmt.setString(21, modifiedAtWorkstation);
					System.out.println(" ::: modifiedAtWorkstation 2 : "+modifiedAtWorkstation);
					cstmt.setString(22, l_facility_id);
					System.out.println(" ::: facility_id 2 : "+l_facility_id);
					cstmt.setString(23,p_base_prev_ind);                 					
					cstmt.registerOutParameter(24, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(25, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(26, java.sql.Types.VARCHAR);
					cstmt.execute();
					String str_error_level = cstmt.getString(24);
					String str_sysmesage_id = cstmt.getString(25);
					String str_error_text = cstmt.getString(26);
					
					System.out.println(" ::: blinstransactions.insert_enc_spec_policy_dtl_blk results : str_error_level : "+str_error_level+" : str_sysmesage_id : "+str_sysmesage_id+" : str_error_text : "+str_error_text);
					
				}catch(Exception e){
					l_app_msg =  " ::: Execption in blinstransactions.insert_enc_spec_policy_dtl_blk : "+e.getMessage();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					e.printStackTrace();
					
				}finally {
					EMDataSource.returnConnection(con);
					XHUtil.closeDBResources(null, cstmt, null);
				}
				
			}
			
			l_app_msg = " ::: insertable while blcommonproc.bl_upd_pat_fin_with_lat_data : "+insertable+" ::: Error Code : "+l_errcd;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			if(insertable)
			{
				
				try{
					String lat_upd_patient_fin_dtls_yn = "Y";
					String BLUpdPatFinWithLatDataQuery = "{ call blcommonproc.bl_upd_pat_fin_with_lat_data(?,?,?,?,?,?,?,?) }";
					con = EMDataSource.getConnection();				
					cstmt = con.prepareCall(BLUpdPatFinWithLatDataQuery.toString());
					System.out.println(" ::: blcommonproc.bl_upd_pat_fin_with_lat_data parameters : facility_id : "+l_facility_id+" : patient_id : "+l_patient_id+" : lat_upd_patient_fin_dtls_yn : "+lat_upd_patient_fin_dtls_yn);
					cstmt.setString(1, l_facility_id); //facility_id
					cstmt.setString(2, l_patient_id ); // patient_id
					cstmt.setString(3,lat_upd_patient_fin_dtls_yn);	// upd_patient_fin_dtls_yn	
					cstmt.setString(4, added_at_ws_no); // lat_added_at_ws_no
					cstmt.setString(5,	added_by_id); // lat_added_by_id
					cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(8, java.sql.Types.VARCHAR);
					cstmt.executeUpdate();

					String procErrorLevel = cstmt.getString(6);
					String procErrorCode = cstmt.getString(7);
					String procErrorText = cstmt.getString(8);
					
					if(procErrorLevel==null) procErrorLevel="";
					if(procErrorCode==null) procErrorCode="";
					if(procErrorText==null) procErrorText="";
					
					System.out.println(" ::: blcommonproc.bl_upd_pat_fin_with_lat_data : procErrorLevel : "+procErrorLevel+" : procErrorCode : "+procErrorCode+" : procErrorText : "+procErrorText);
					
					if( !procErrorCode.equals("")  ||  !procErrorText.equals("")  )
					{
						insertable=false;
						con.rollback();
					}
					else
					{
						insertable = true;						
					}					
				}catch(Exception e){
					l_app_msg =  " ::: Execption in blcommonproc.bl_upd_pat_fin_with_lat_data : "+e.getMessage();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					e.printStackTrace();
					
				}finally {
					EMDataSource.returnConnection(con);
					XHUtil.closeDBResources(null, cstmt, null);
				}
			}
			
			l_app_msg = " ::: insertable while BLVisitCharge.proc_main : "+insertable+" ::: Error Code : "+l_errcd;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			String str_bill_later_YN = "N";
			
			try{				
				con =  EMDataSource.getConnection();

				String billLatterYNQuery = "select nvl(ADHOC_DISCOUNT_ALLOWED_YN,'N') from  bl_parameters where operating_facility_id='"+l_facility_id+"'" ;

				pstmt = con.prepareStatement(billLatterYNQuery);
				rset = pstmt.executeQuery();
				while(rset.next())
				{
					str_bill_later_YN = rset.getString(1);
				}
				l_app_msg = " ::: Bill Latter YN : "+str_bill_later_YN;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
			}catch(Exception e)
			{
				l_app_msg = "Eception in Bill Latter YN : "+e.getMessage();
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				e.printStackTrace();
			}		
			finally {
				XHUtil.closeDBResources(rset, pstmt, null);
				EMDataSource.returnConnection(con);
			}
			
			l_app_msg = " ::: insertable while bl_proc_check_lmt : "+insertable+" ::: Error Code : "+l_errcd;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			if(insertable)
			{
				l_app_msg = " ::: Fetching HAND WITHOUT COUNTER CHK OUT ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				String l_hand_without_counter_chk_out="";
				
				try{
					
					con =  EMDataSource.getConnection();

					String chkOutQuery = "select HAND_WITHOUT_COUNTER_CHK_OUT from  BL_PARAMETERS where OPERATING_FACILITY_ID='"+l_facility_id+"'" ;

					pstmt = con.prepareStatement(chkOutQuery);
					rset = pstmt.executeQuery();
					while(rset.next())
					{
						l_hand_without_counter_chk_out = rset.getString(1);
					}
					l_app_msg = " ::: HAND WITHOUT COUNTER CHK OUT : "+l_hand_without_counter_chk_out;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					
				}catch(Exception e)
				{
					l_app_msg = "Eception in HAND WITHOUT COUNTER CHK OUT : "+e.getMessage();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					e.printStackTrace();
				}		
				finally {
					XHUtil.closeDBResources(rset, pstmt, null);
					EMDataSource.returnConnection(con);
				}
				
				if(l_hand_without_counter_chk_out.equals("Y"))
				{
					l_app_msg = "Calling bl_proc_check_lmt : ";
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					
					try{
						String bl_proc_check_lmt_query = "{ call bl_proc_check_lmt(?,?,?,?,?,?,?,?)}";
						
						con = EMDataSource.getConnection();				
						cstmt = con.prepareCall(bl_proc_check_lmt_query);
						
						cstmt.setString(1,l_facility_id);
						cstmt.setString(2, added_by_id);
						cstmt.setString(3, l_billing_group_code);//l_billing_group_code,l_cash_counter_code
						cstmt.setString(4, l_settlement_type_code);
						cstmt.setString(5, c_str_hosp_chrg_pat_amt);	// c_str_hosp_chrg_pat_amt
						cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);	
						cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);	
						cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
						
						cstmt.execute();	
						
						String l_str_error_level		 = cstmt.getString(6);		
						String l_str_sysmesage_id	 = cstmt.getString(7);		
						String l_str_error_text     	 = cstmt.getString(8);
						
						l_app_msg = " ::: bl_proc_check_lmt...l_str_error_level.."+l_str_error_level+"..l_str_sysmesage_id.."+l_str_sysmesage_id+"..l_str_error_text.."+l_str_error_text;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);						
					}catch(Exception e){
						l_app_msg = " ::: Execption in bl_proc_check_lmt : "+e.getMessage();
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						e.printStackTrace();						
					}finally {
						EMDataSource.returnConnection(con);
						XHUtil.closeDBResources(null, cstmt, null);
					}	
				}				
			}
			
			System.out.println(" ::: calling BLVisitCharge.proc_main mode as 'D' ::: ");
			
			if(insertable)
			{
				try
				{
					if (strBLInterfaceYN.equals("Y"))
					{
						int intVisitNum = Integer.parseInt(l_visitnum);
						long intEpisodeNum = Long.parseLong(l_episode_no);
						String l_module_id = "OP", strNull = "";
						String strNewHospChrgCreate="";
						String strNewMedChrgCreate="";
						String strNewAddlChrgCreate="";
						String strHospServChargeAmt="";
						String hosp_serv_charge_amt = String.valueOf(strHospServChargeAmt);
						String strMedServChargeAmt="";
						String med_serv_charge_amt=String.valueOf(strMedServChargeAmt);
						int strAcctSeqNo=1;
						String addl_serv_charge_amt = "";
						String addl_serv_panel_qty = "1.0";
						String med_serv_panel_qty = "1.0";
						String hosp_serv_panel_qty = "1.0";												
						String strHospServPanelInd_1 = "", strHospServPanelCode_1 = "";
						String d_payer_group_code = l_payer_group_code;
						String d_payer_code = l_payer_code;
						if(!l_billing_group_code.equals("CASH"))
						{
							l_credit_auth_ref = " |" ; l_credit_auth_date = " |";
							l_effective_from = l_visit_date_time.substring(0, l_visit_date_time.length()-9)+"|";
							l_effective_to = l_policy_end_date;
							l_approved_amt = " |";
							l_approved_days = " |";
							l_non_ins_blng_grp_id = "CASH";
							d_payer_group_code = d_payer_group_code+"|";
							d_payer_code = d_payer_code+"|";
							
						}						
						
						String procMainQuery="{call BLVisitCharge.proc_main('D','VISIT_REGISTRATION','"+l_facility_id+"','"+l_module_id+"','"+l_location_code+"','"+l_visit_type+"'," +
								   "'"+strNull+"','"+l_patient_id+"','"+l_episode_type+"','"+l_encounter_id+"'," +
								   ""+intEpisodeNum+","+intVisitNum+",to_date('"+l_visit_date_time+"','dd/mm/yyyy HH24:MI:SS'),'P','"+l_practitioner_id+"'," +
								   "'"+l_billing_group_code+"','"+d_payer_group_code+"','"+d_payer_code+"','"+l_policy_type_code+"','"+l_priority+"'," +
								   "'"+l_policy_number+"','"+l_policy_start_date+"','"+l_policy_end_date+"','"+l_credit_auth_ref+"'," +
								   "'"+l_credit_auth_date+"','"+l_effective_from+"','"+l_effective_to+"','"+l_approved_amt+"'," +
								   "'"+l_approved_days+"','"+l_non_ins_blng_grp_id+"','"+l_non_ins_cust_group_code+"','"+l_non_ins_cust_code+"'," +
								   "'"+strNewHospChrgCreate+"','"+strNewMedChrgCreate+"','"+strNewAddlChrgCreate+"','"+strHospServPanelInd+"','"+strHospServPanelCode+"'," +
								   "'"+strHospServPanelStr+"','"+hosp_serv_panel_qty+"','"+hosp_serv_charge_amt+"','"+strMedServPanelInd+"','"+strMedServPanelCode+"'," +
								   "'"+strMedServPanelStr+"','"+med_serv_panel_qty+"','"+med_serv_charge_amt+"','"+strHospServPanelInd_1+"','"+strHospServPanelCode_1+"'," +
								   "'"+strAddlServPanelStr+"','"+addl_serv_panel_qty+"','"+addl_serv_charge_amt+"','"+str_bill_later_YN+"','"+added_by_id+"'," +
								   "'"+added_at_ws_no+"','"+added_at_ws_no+"',"+strAcctSeqNo+",'"+strNull+"','"+l_locale+"',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
						
						l_app_msg = " ::: procMainQuery : "+procMainQuery;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						
						con = EMDataSource.getConnection();
						cstmt = con.prepareCall(procMainQuery.toString());
						
						cstmt.registerOutParameter( 1, java.sql.Types.VARCHAR);		
						cstmt.registerOutParameter( 2, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter( 3, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter( 4, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter( 5, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter( 6, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter( 7, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter( 8, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter( 9, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter( 10, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter( 11, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter( 12, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter( 13, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter( 14, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter( 15, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter( 16, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter( 17, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter( 18, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter( 19, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter( 20, java.sql.Types.VARCHAR);
					
						cstmt.execute();
						
						d_hosp_charge_YN= cstmt.getString(1);
						if(d_hosp_charge_YN==null || d_hosp_charge_YN.equals("")) d_hosp_charge_YN="";
						System.out.println(" ::: hosp_charge_YN : "+d_hosp_charge_YN);

						d_med_charge_YN= cstmt.getString(2);
						if(d_med_charge_YN==null || d_med_charge_YN.equals("")) d_med_charge_YN="";
						System.out.println(" ::: med_charge_YN : "+d_med_charge_YN);

						d_addl_charge_YN = cstmt.getString(3);
						if(d_addl_charge_YN==null || d_addl_charge_YN.equals("")) d_addl_charge_YN="";
						System.out.println(" ::: addl_charge_YN : "+d_addl_charge_YN);
		
						d_exempt_date= cstmt.getString(4);
						if(d_exempt_date==null || d_exempt_date.equals("")) d_exempt_date="";
						System.out.println(" ::: exempt_date : "+d_exempt_date);
						
						d_str_hosp_chrg_amt=cstmt.getString(5);
						if(d_str_hosp_chrg_amt==null || d_str_hosp_chrg_amt.equals("")) d_str_hosp_chrg_amt="0.0";
						d_hosp_chrg_amt= Double.parseDouble(d_str_hosp_chrg_amt);
						System.out.println(" ::: hosp_chrg_amt : "+d_hosp_chrg_amt);

						d_str_hosp_chrg_pat_amt=cstmt.getString(6);
						if(d_str_hosp_chrg_pat_amt==null || d_str_hosp_chrg_pat_amt.equals("")) d_str_hosp_chrg_pat_amt="0.0";
						d_hosp_chrg_pat_amt=Double.parseDouble(d_str_hosp_chrg_pat_amt);
						System.out.println(" ::: hosp_chrg_pat_amt : "+d_hosp_chrg_pat_amt);

						d_str_med_chrg_amt=cstmt.getString(7);
						if(d_str_med_chrg_amt==null || d_str_med_chrg_amt.equals("")) d_str_med_chrg_amt="0.0";
						d_med_chrg_amt=Double.parseDouble(d_str_med_chrg_amt);
						System.out.println(" ::: med_chrg_amt : "+d_med_chrg_amt);
						
						d_str_med_chrg_pat_amt=cstmt.getString(8);
						if(d_str_med_chrg_pat_amt==null || d_str_med_chrg_pat_amt.equals("")) d_str_med_chrg_pat_amt="0.0";
						d_med_chrg_pat_amt=Double.parseDouble(d_str_med_chrg_pat_amt);
						System.out.println(" ::: med_chrg_pat_amt : "+d_med_chrg_pat_amt);

						d_str_addl_chrg_amt=cstmt.getString(9);
						if(d_str_addl_chrg_amt==null || d_str_addl_chrg_amt.equals("")) d_str_addl_chrg_amt="0.0";
						d_addl_chrg_amt=Double.parseDouble(d_str_addl_chrg_amt);
						System.out.println(" ::: addl_chrg_amt : "+d_addl_chrg_amt);

						d_str_addl_chrg_pat_amt=cstmt.getString(10);
						if(d_str_addl_chrg_pat_amt==null || d_str_addl_chrg_pat_amt.equals("")) d_str_addl_chrg_pat_amt="0.0";
						d_addl_chrg_pat_amt=Double.parseDouble(d_str_addl_chrg_pat_amt);
						System.out.println(" ::: addl_chrg_pat_amt : "+d_addl_chrg_pat_amt);

						d_bill_gen_yn=cstmt.getString(11);
						if(d_bill_gen_yn==null || d_bill_gen_yn.equals("")) d_bill_gen_yn="";
						System.out.println(" ::: bill_gen_yn : "+d_bill_gen_yn);
						
						d_bill_doc_type=cstmt.getString(12);
						if(d_bill_doc_type==null || d_bill_doc_type.equals("")) d_bill_doc_type="";
						System.out.println(" ::: bill_doc_type : "+d_bill_doc_type);
						
						d_bill_doc_number=cstmt.getString(13);
						if(d_bill_doc_number==null || d_bill_doc_number.equals("")) d_bill_doc_number="";
						System.out.println(" ::: bill_doc_number : "+d_bill_doc_number);
						
						d_str_bill_gen_later=cstmt.getString(14);
						if(d_str_bill_gen_later==null || d_str_bill_gen_later.equals("")) d_str_bill_gen_later="N";
						System.out.println(" ::: str_bill_gen_later : "+d_str_bill_gen_later);
						
						d_str_total_bill_amt=cstmt.getString(15);
						if(d_str_total_bill_amt==null || d_str_total_bill_amt.equals("")) d_str_total_bill_amt="";
						System.out.println(" ::: str_total_bill_amt : "+d_str_total_bill_amt);

						d_str_bill_prt_format_YN = cstmt.getString(16);
						if(d_str_bill_prt_format_YN==null || d_str_bill_prt_format_YN.equals("")) d_str_bill_prt_format_YN="N";
						System.out.println(" ::: str_bill_prt_format_YN : "+d_str_bill_prt_format_YN);

						d_str_bill_prt_format_vals = cstmt.getString(17);
						if(d_str_bill_prt_format_vals==null || d_str_bill_prt_format_vals.equals("")) d_str_bill_prt_format_vals="";
						System.out.println(" ::: str_bill_prt_format_vals : "+d_str_bill_prt_format_vals);
						
						String error_level=cstmt.getString(18);
						String sys_message_id=cstmt.getString(19);
						String error_text=cstmt.getString(20);

						if (error_level == null) error_level ="";
						if (sys_message_id ==null) sys_message_id ="";
						if (error_text ==null) error_text ="";
						System.out.println(" ::: Fetch BLVisitCharge.proc_main : error_level : "+error_level+" : sys_message_id : "+sys_message_id+" : error_text : "+error_text);	
					}					
				}catch(Exception e){
					System.out.println("Execption while BLVisitCharge.proc_main mode as 'D' : "+e.getMessage());
					e.printStackTrace();		
				}finally {
					EMDataSource.returnConnection(con);
					XHUtil.closeDBResources(null, cstmt, null);
				}
			}
			
			if(insertable)
			{
				ArrayList	pkg_seq_no_for_upd_sub_hdr		=	new ArrayList();
				String packageSeqno = "";
				String l_mpi_id = "";
				
				l_app_msg = " ::: Fetching Package Sequence No : ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				try{					
					con =  EMDataSource.getConnection();

					String packSeqNoQuery = "SELECT BL_PACK_SEQNUM.NEXTVAL FROM DUAL";

					pstmt = con.prepareStatement(packSeqNoQuery);
					rset = pstmt.executeQuery();
					while(rset.next())
					{
						packageSeqno = rset.getString(1);
					}
					l_app_msg = " ::: Package Sequence No : "+packageSeqno;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					
				}catch(Exception e)
				{
					l_app_msg = "Eception in Package Sequence No : "+e.getMessage();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					e.printStackTrace();
				}		
				finally {
					XHUtil.closeDBResources(rset, pstmt, null);
					EMDataSource.returnConnection(con);
				}
				
				l_app_msg = " ::: Fetching MPI ID : ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				try{					
					con =  EMDataSource.getConnection();

					String packSeqNoQuery = "select MPI_ID from bl_bill_hdr where OPERATING_FACILITY_ID='"+l_facility_id+"' and DOC_TYPE_CODE='"+str_bill_doc_type+"' and DOC_NUM='"+str_bill_doc_number+"'";

					pstmt = con.prepareStatement(packSeqNoQuery);
					rset = pstmt.executeQuery();
					while(rset.next())
					{
						l_mpi_id  =  rset.getString(1);	
					}
					l_app_msg = " ::: MPI ID : "+l_mpi_id;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					
				}catch(Exception e)
				{
					l_app_msg = "Eception in Fetching MPI ID : "+e.getMessage();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					e.printStackTrace();
				}		
				finally {
					XHUtil.closeDBResources(rset, pstmt, null);
					EMDataSource.returnConnection(con);
				}			
				
				if(!packageSeqno.equals("") && !pkg_seq_no_for_upd_sub_hdr.contains(packageSeqno))
				{
					pkg_seq_no_for_upd_sub_hdr.add(packageSeqno);
				}
				
				l_app_msg = " ::: Updating BL_BILL_HDR : ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);				
			}
			
			l_app_msg = " ::: insertable while calling MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : "+insertable+" ::: Error Code : "+l_errcd;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			try{
				String cs = "0";
				String l_patientClass = "OP";
				String l_res_tel_no = "", l_oth_contact_no = "", l_res_area_code = "", l_res_town_code = "", l_res_region_code = "";
				String l_email_id = "", l_res_addr_line1 = "", l_res_addr_line2 = "", l_res_addr_line3 = "", l_res_addr_line4 = "", l_postal_code = "", l_country_code = "";
				String l_mail_addr_line1 = "", l_mail_addr_line2 = "", l_mail_addr_line3 = "", l_mail_addr_line4 = "", l_mail_area_code = "", l_mail_town_code = "";
				int posCnt = 0;
				String updateAddressEncounterQuery = "{call MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				
				con = EMDataSource.getConnection();
				cstmt = con.prepareCall(updateAddressEncounterQuery.toString());
				
				cstmt.setString( ++posCnt ,l_facility_id); 
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : facility id : "+l_facility_id);
				
				cstmt.setString( ++posCnt , l_encounter_id);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : encounterid : "+l_encounter_id);
				
				cstmt.setString( ++posCnt , l_patientClass);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : patientClass : "+l_patientClass);
				
				cstmt.setString( ++posCnt , l_patient_id);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : patient_id : "+l_patient_id);
				
				cstmt.setString( ++posCnt , l_res_tel_no);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : res_tel_no : "+l_res_tel_no);
				
				cstmt.setString( ++posCnt , l_oth_contact_no);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : oth_contact_no : "+l_oth_contact_no);
				
				cstmt.setString( ++posCnt , l_res_area_code);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : res_area_code : "+l_res_area_code);
				
				cstmt.setString( ++posCnt , l_res_town_code);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : res_town_code : "+l_res_town_code);
				
				cstmt.setString( ++posCnt , l_res_region_code);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : res_region_code : "+l_res_region_code);
								
				cstmt.setString( ++posCnt , l_email_id);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : email_id : "+l_email_id);
				
				cstmt.setString( ++posCnt , l_res_addr_line1);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : res_addr_line1 : "+l_res_addr_line1);
				
				cstmt.setString( ++posCnt , l_res_addr_line2);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : res_addr_line2 : "+l_res_addr_line2);
				
				cstmt.setString( ++posCnt , l_res_addr_line3);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : res_addr_line3 : "+l_res_addr_line3);
				
				cstmt.setString( ++posCnt , l_res_addr_line4);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : res_addr_line4 : "+l_res_addr_line4);
				
				cstmt.setString( ++posCnt , l_postal_code);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : postal_code : "+l_postal_code);
				
				cstmt.setString( ++posCnt , l_country_code);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : country_code : "+l_country_code);
				
				cstmt.setString( ++posCnt , l_mail_addr_line1);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : mail_addr_line1 : "+l_mail_addr_line1);
				
				cstmt.setString( ++posCnt , l_mail_addr_line2);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : mail_addr_line2 : "+l_mail_addr_line2);
				
				cstmt.setString( ++posCnt , l_mail_addr_line3);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : mail_addr_line3 : "+l_mail_addr_line3);
				
				cstmt.setString( ++posCnt , l_mail_addr_line4);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : mail_addr_line4 : "+l_mail_addr_line4);
				
				cstmt.setString( ++posCnt , l_mail_area_code);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : mail_area_code : "+l_mail_area_code);
				
				cstmt.setString( ++posCnt , l_mail_town_code);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : mail_town_code : "+l_mail_town_code);
				
				String l_mail_postal_code = "", l_mail_region_code = "", l_mail_country_code = "", l_altAddrLine1 = "", l_altAddrLine2 = "", l_altAddrLine3 = "", l_altAddrLine4 = "";
				
				cstmt.setString( ++posCnt , l_mail_postal_code);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : mail_postal_code : "+l_mail_postal_code);
				
				cstmt.setString( ++posCnt , l_mail_region_code);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : mail_region_code : "+l_mail_region_code);
				
				cstmt.setString( ++posCnt , l_mail_country_code);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : mail_country_code : "+l_mail_country_code);
				
				cstmt.setString( ++posCnt , l_altAddrLine1);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : altAddrLine1 : "+l_altAddrLine1);
				
				cstmt.setString( ++posCnt , l_altAddrLine2);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : altAddrLine2 : "+l_altAddrLine2);
				
				cstmt.setString( ++posCnt , l_altAddrLine3);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : altAddrLine3 : "+l_altAddrLine3);
				
				cstmt.setString( ++posCnt , l_altAddrLine4);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : altAddrLine4 : "+l_altAddrLine4);
				
				String l_altAreaCode = "", l_altTownCode = "", l_altPostalCode = "", l_altRegionCode = "", l_altCountryCode = "";
				
				cstmt.setString( ++posCnt , l_altAreaCode);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : altAreaCode : "+l_altAreaCode);
				
				cstmt.setString( ++posCnt , l_altTownCode);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : altTownCode : "+l_altTownCode);
				
				cstmt.setString( ++posCnt , l_altPostalCode);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : altPostalCode : "+l_altPostalCode);
				
				cstmt.setString( ++posCnt , l_altRegionCode);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : altRegionCode : "+l_altRegionCode);
				
				cstmt.setString( ++posCnt , l_altCountryCode);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : altCountryCode : "+l_altCountryCode);
				
				cstmt.setString( ++posCnt , added_by_id);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : modified_by_id : "+added_by_id);
				
				cstmt.setString( ++posCnt , modified_at_ws_no);
				System.out.println(" ::: MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : modified_at_ws_no : "+modified_at_ws_no);
				cstmt.registerOutParameter( ++posCnt , java.sql.Types.VARCHAR); 
				
				cstmt.execute();
				cs = cstmt.getString(posCnt); 					

				if (cs.equals("1")) {
					insertable = true;
				} else {
					insertable = false;
					l_app_msg = " ::: Error While UPDATING MP_PAT_ADD ::: ";
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					
				}
				
				
			}catch(Exception e){
				System.out.println("Execption while MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER : "+e.getMessage());
				e.printStackTrace();
				
			}finally {
				EMDataSource.returnConnection(con);
				XHUtil.closeDBResources(null, cstmt, null);
			}
			
			l_app_msg = " ::: calling BL_STORE_BILL_GEN.PROC_GENERATE_BILL_SEPERATELY ::: ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			try{
				String dep_adjust_yn = "N"; // Added for Testing purpose
				
				String p_visit_no = l_encounter_id.substring(l_encounter_id.length()-4);
				//String c_billing_group_code = l_billing_group_code.replace("|", "");
				String c_billing_group_code = l_billing_group_code;
				c_billing_group_code = c_billing_group_code.replace("|", "");
				System.out.println(" ::: BL_STORE_BILL_GEN.PROC_GENERATE_BILL_SEPERATELY : l_calling_function_id : "+l_calling_function_id);
				System.out.println(" ::: BL_STORE_BILL_GEN.PROC_GENERATE_BILL_SEPERATELY : l_facility_id : "+l_facility_id);
				System.out.println(" ::: BL_STORE_BILL_GEN.PROC_GENERATE_BILL_SEPERATELY : l_calling_module_id : "+l_calling_module_id);
				System.out.println(" ::: BL_STORE_BILL_GEN.PROC_GENERATE_BILL_SEPERATELY : l_location_code : "+l_location_code);
				System.out.println(" ::: BL_STORE_BILL_GEN.PROC_GENERATE_BILL_SEPERATELY : l_visit_type : "+l_visit_type);
				System.out.println(" ::: BL_STORE_BILL_GEN.PROC_GENERATE_BILL_SEPERATELY : l_patient_id : "+l_patient_id);
				System.out.println(" ::: BL_STORE_BILL_GEN.PROC_GENERATE_BILL_SEPERATELY : l_episode_type : "+l_episode_type);
				System.out.println(" ::: BL_STORE_BILL_GEN.PROC_GENERATE_BILL_SEPERATELY : l_encounter_id : "+l_encounter_id);
				System.out.println(" ::: BL_STORE_BILL_GEN.PROC_GENERATE_BILL_SEPERATELY : l_episode_id : "+l_episode_no);
				System.out.println(" ::: BL_STORE_BILL_GEN.PROC_GENERATE_BILL_SEPERATELY : l_visitno : "+p_visit_no);
				System.out.println(" ::: BL_STORE_BILL_GEN.PROC_GENERATE_BILL_SEPERATELY : l_billing_group_code : "+c_billing_group_code);
				System.out.println(" ::: BL_STORE_BILL_GEN.PROC_GENERATE_BILL_SEPERATELY : dep_adjust_yn : "+dep_adjust_yn);

				String storeBillGenQuery = "{ call BLVISITCHARGE.PROC_GENERATE_BILL_SEPERATELY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				
				con = EMDataSource.getConnection();
				cstmt = con.prepareCall(storeBillGenQuery.toString());
				
				cstmt.setString(1, l_calling_function_id); // function_id
				cstmt.setString(2, l_facility_id); // facility_id
				cstmt.setString(3, l_calling_module_id); // module_id
				cstmt.setString(4, l_location_code); // clinic_code
				cstmt.setString(5, l_visit_type); // visit_type_code
				cstmt.setString(6, l_patient_id); // patient_id
				cstmt.setString(7, l_episode_type); // episode_type
				cstmt.setString(8, l_encounter_id); // encounter_id
				cstmt.setString(9, l_episode_no); // episode_id
				cstmt.setString(10, p_visit_no); // visit_id
				cstmt.setString(11, c_billing_group_code); // blng_grp_id
				cstmt.setString(12, added_by_id); // loggeduser
				cstmt.setString(13, added_at_ws_no);  // clientip
				cstmt.setString(14, l_locale); // locale			
				cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);	
				cstmt.registerOutParameter(16,java.sql.Types.VARCHAR);	
				cstmt.registerOutParameter(17,java.sql.Types.VARCHAR);	
				cstmt.registerOutParameter(18,java.sql.Types.VARCHAR);	
				cstmt.registerOutParameter(19,java.sql.Types.VARCHAR);	
				cstmt.registerOutParameter(20,java.sql.Types.VARCHAR);	
				cstmt.registerOutParameter(21,java.sql.Types.VARCHAR);	
				cstmt.registerOutParameter(22,java.sql.Types.VARCHAR);	

				cstmt.setString(23,dep_adjust_yn); // dep_adjust_yn						
				cstmt.execute();	
				
				str_bill_gen_yn = cstmt.getString(15);		
				str_bill_doc_type = cstmt.getString(16);		
				str_bill_doc_number = cstmt.getString(17);	
				
				if(str_bill_gen_yn == null) str_bill_gen_yn="";
				if(str_bill_doc_type == null) str_bill_doc_type="";
				if(str_bill_doc_number == null) str_bill_doc_number="";
				System.out.println(" ::: str_bill_gen_yn : "+str_bill_gen_yn+" : str_bill_doc_type : "+str_bill_doc_type+" : str_bill_doc_number : "+str_bill_doc_number);

				
				String str_bill_prt_format_YN = cstmt.getString(18);	
				String str_bill_prt_format_vals = cstmt.getString(19);
				System.out.println(" ::: str_bill_prt_format_YN : "+str_bill_prt_format_YN+" : str_bill_prt_format_vals : "+str_bill_prt_format_vals);
				String str_error_level	= cstmt.getString(20);		
				String str_sysmesage_id	= cstmt.getString(21);		
				String str_error_text	= cstmt.getString(22);		

				if(str_error_level == null) str_error_level="";
				if(str_error_text == null) str_error_text="";
				if(str_sysmesage_id == null) str_sysmesage_id="";
				System.out.println(" ::: str_error_level : "+str_error_level+" : str_error_text : "+str_error_text+" : str_sysmesage_id : "+str_sysmesage_id);
				
			}catch(Exception e){
				System.out.println("Execption while PROC_GENERATE_BILL_SEPERATELY : "+e.getMessage());
				e.printStackTrace();
				
			}finally {
				EMDataSource.returnConnection(con);
				XHUtil.closeDBResources(null, cstmt, null);
			}
			
			l_app_msg = " ::: insertable while final Response : "+insertable+" ::: Error Code : "+l_errcd;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			if(l_errcd.equals("S")){
				l_status = "1";
				l_status_desc = "Visit Registration Successfully";
				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				
				visitMapDtls.put("patient_id", l_patient_id);
				visitMapDtls.put("encounter_id", l_encounter_id);
				visitMapDtls.put("location_type", l_location_type);
				visitMapDtls.put("location_code", l_location_code);
				visitMapDtls.put("service_code", l_service_code);
				visitMapDtls.put("visit_type", l_visit_type);
				visitMapDtls.put("practitioner_id", l_practitioner_id);
				
				visitDtls.add(visitMapDtls);
				
				l_response_json.put("visit_data", visitDtls);
				
				l_responseJsonString = objMapper.writeValueAsString(l_response_json);
				
				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				String l_response_str = practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, "");
				l_app_msg = " ::: Message Load Method  ::: "+ l_response_str;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				return "200#"+ l_responseJsonString +"#";
			}else{
				l_status = "0";
				l_status_desc = "Visit Registration Failed";
				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				
				visitMapDtls.put("patient_id", "");
				visitMapDtls.put("encounter_id", l_encounter_id);
				visitMapDtls.put("location_type", "");
				visitMapDtls.put("location_code", "");
				visitMapDtls.put("service_code", "");
				visitMapDtls.put("visit_type", "");
				visitMapDtls.put("practitioner_id", "");
				visitDtls.add(visitMapDtls);
				
				l_response_json.put("visit_data", visitDtls);
				
				l_responseJsonString = objMapper.writeValueAsString(l_response_json);
				
				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				String l_response_str = practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, "");
				l_app_msg = " ::: Message Load Method  ::: "+ l_response_str;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				return "200#"+ l_responseJsonString +"#";
				
			}
			
			
		}catch(Exception e){
			
			e.printStackTrace();
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^ Exception Occurred " + e.getMessage();
			l_responseJsonString = l_errmsg;
			
			l_app_msg = " ************ Mohe Visit Registration Traction Ended ************ ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);	
		}
		
		return "200#"+ l_responseJsonString +"#";
	}
	
	public static Map<String, String> generateEncounterID(String episodeno, String visitnum, String facility_id, String added_by_id, String ws_no){		 
		Connection con					= null;
		PreparedStatement pstmt			= null;
		CallableStatement cstmt         = null;
		String errmsg = "", msgEncounter = "", encounterid = "";
		Map<String, String> returnsData = new HashMap<String, String>();
		//boolean insertable = true;
		System.out.println(" ::: Inside generateEncounterID ::: ");
		
		try {
			con = EMDataSource.getConnection();
			cstmt = con.prepareCall("{call PR_GENERATE_ENCOUNTER_ID(?,?,?,?,?,?,?,?,?,?)}");
			
			System.out.println(" ::: PR_GENERATE_ENCOUNTER_ID parameters : episodeno : "+episodeno+" : visitnum : "+visitnum+" : facility_id : "+facility_id+" : added_by_id : "+added_by_id+ " : ws_no : "+ws_no);
			
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
			System.out.println(" ::: msgEncounter : "+msgEncounter);
			returnsData.put("msgEncounter", msgEncounter);
			if (msgEncounter == null)
				msgEncounter = "N";
			
			System.out.println(" ::: errmsg : "+errmsg+" ::: msgEncounter : "+msgEncounter+" ::: insertable : "+insertable);

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
			
			System.out.println(" ::: encounterid ::: "+encounterid+" ::: visitnum ::: "+visitnum+" ::: episodeno ::: "+episodeno+" ::: returnsData ::: "+returnsData);

		} catch (Exception e) {
			insertable = false;
			e.printStackTrace();
		}finally{
			EMDataSource.returnConnection(con);
			XHUtil.closeDBResources(null, pstmt, null);
		}
		return returnsData;
	}
	
	public static Map<String, String> fetchEpisodeIDVisitNum(String facility_id, String patient_id, String episode_id, String locantion_code){
		String l_app_msg = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Map<String, String> VisitEpisodeData = new HashMap<String, String>();
		String sql = "";
		
		l_app_msg = " ::: Inside fetchEpisodeIDVisitNum ::: ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		
		try {			 
			sql = "select  last_visit_fu_reqd_yn , to_char(last_visit_date,'yyyy-mm-dd') last_visit_date, nvl(last_visit_num,0)+1 last_visit_num from op_episode_for_service where operating_facility_id='"+facility_id+"' and episode_status='01' and patient_id='"+patient_id+"' " ;
			  if(!episode_id.equals(""))
				  sql=sql+" and episode_id='"+episode_id+"'";                     
				else{
					sql=sql+" and clinic_code='"+locantion_code+"'";
				}
				sql = sql+" order by added_date desc";
			
			 l_app_msg = " ::: fetchEpisodeIDVisitNum Query ::: " + sql.toString();
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
			con = EMDataSource.getConnection();

			pstmt = con.prepareStatement(sql.toString());

			rset = pstmt.executeQuery();

			while(rset.next()) {
				//VisitEpisodeData.put("episode_id", rset.getString("episode_id"));
				VisitEpisodeData.put("visit_num", rset.getString("last_visit_num"));
			}
			
			l_app_msg = " ::: fetchEpisodeIDVisitNum ::: " + VisitEpisodeData;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		} catch (Exception e) {
			System.out.println(" Exception in fetchEpisodeIDVisitNum : "+ e.getMessage());
			e.printStackTrace();
		} finally {
			EMDataSource.returnConnection(con);
			XHUtil.closeDBResources(rset, pstmt, null);
		}
		return VisitEpisodeData;
	}
	
	public String fetchEpisodeID(String facility_id){
		String episodeID = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		System.out.println(" ::: Inside fetchEpisodeID ::: ");
		try {
			con = EMDataSource.getConnection();

			pstmt = con.prepareStatement("select * from pr_enc_id_num_for_fcy where facility_id = ?");
			pstmt.setString(1, facility_id);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				episodeID = String.valueOf(rset.getInt("next_num"));
			}
			System.out.println(" ::: Episode ID ::: " + episodeID);

		} catch (Exception e) {
			System.out.println(" Exception in FetchEpisodeNo : "+ e.getMessage());
			e.printStackTrace();
		} finally {
			EMDataSource.returnConnection(con);
			XHUtil.closeDBResources(null, pstmt, null);
		}
		return episodeID;
	}
	
	public  String sendErrorResponse(String actionKey, String error , String request_ref_no, Map<String, String> params)
	{
		String l_status = "", l_status_desc = "", l_responseJsonString = "",l_app_msg ="",  l_response_str = "";
		Map<String, Object> l_response_json = new HashMap<String, Object>();
		LinkedHashMap<String, String> visit_data = new LinkedHashMap<String, String>();
		MoheInboundTransaction practoInboundTransaction = new MoheInboundTransaction();
		ObjectMapper objMapper = new ObjectMapper();
		
		try 
		{
			l_app_msg = " ::: Inside sendErrorResponse ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			visit_data.put("patient_id", "");
			visit_data.put("location_type", "");
			visit_data.put("location_code", "");
			visit_data.put("service_code", "");
			visit_data.put("visit_type", "");
			visit_data.put("practitioner_id", "");
			
			l_status = "0";
			l_status_desc = error;
			l_response_json.put("request_ref_no", request_ref_no);
			l_response_json.put("status", l_status);
			l_response_json.put("status_desc", l_status_desc);
			l_response_json.put("visit_data", visit_data);		
			
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
	
	public static Map<String, String> fetchClinicDetails(String facility_id, String assign_care_locn_code){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, String> clinicData = new HashMap<String, String>();
		System.out.println(" ::: Inside fetchClinicDetails ::: ");
		try {
			String clinic_query = "select clinic_type,speciality_code, dept_code,to_char(sysdate,'dd/mm/yyyy') ct_date,online_mr_notfn_yn,mr_location_code from op_clinic where clinic_code = '"
					+ assign_care_locn_code
					+ "' and facility_id='"
					+ facility_id + "'";
			con = EMDataSource.getConnection();

			pstmt = con.prepareStatement(clinic_query);

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
			System.out.println(" ::: clinicData ::: " + clinicData);

		} catch (Exception e) {
			System.out.println(" Exception in FetchEpisodeNo : "+ e.getMessage());
			e.printStackTrace();
		} finally {
			EMDataSource.returnConnection(con);
			XHUtil.closeDBResources(null, pstmt, null);
		}
		return clinicData;
	}
	
	public static void InserData(HashMap<String, HashMap<String, String>> new_hash_map) 
	{		
		Connection con	= null;
		PreparedStatement pstmt	= null;
		ResultSet rs =null;
		Set<String> tableKeys = new_hash_map.keySet();
		String insertStr = "";
		int count = 0;
		String l_app_msg = "", keyStr = "", valueStr = "", l_status = "", l_status_desc = "";

		try
		{	
			l_app_msg = " ::: Inside Insert Data ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			con = EMDataSource.getConnection();
			for(String tableKey: tableKeys){
			
				LinkedHashMap<String, String> tHashMap = (LinkedHashMap)new_hash_map.get(tableKey);
				
				Set<String> columnKeys = tHashMap.keySet();
				for(String columnKey: columnKeys){
					keyStr = keyStr + columnKey + ",";    
					
					//System.out.println("Bhuvi111: "+tHashMap.get(columnKey));
					if (tHashMap.get(columnKey).contains("DATE"))
						valueStr = valueStr +""+tHashMap.get(columnKey) +""+",";
					else
						valueStr = valueStr + "\'"+tHashMap.get(columnKey) + "\'"+",";
					
				}	

				keyStr = keyStr.substring(0,keyStr.length() -1 );
				valueStr = valueStr.substring(0,valueStr.length() -1 );
				
				l_app_msg = " ::: Inserting the Values ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				insertStr =  " Insert into "+tableKey+ " ("+keyStr+") VALUES ("+valueStr+") ";
				if (l_debug_YN.equals("Y")) System.out.println(" ::: Insert Query ::: "+insertStr.toString());		
				
				//if(pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement(insertStr.toString());
				count = pstmt.executeUpdate();
				
				if (l_debug_YN.equals("Y")) System.out.println(" ::: Count ::: "+count);
				
				if (count == 1)
				{
					insertable = true;
					con.commit();
					if (l_debug_YN.equals("Y"))  System.out.println(" ::: Inserted Success ::: ");
				}else{
					insertable = false;
					con.rollback();
					if (l_debug_YN.equals("Y"))  System.out.println(" ::: RollBack Success ::: ");
				}
				keyStr = ""; valueStr = "";	
			}
			if(pstmt != null) pstmt.close();
		}
		catch (Exception e)
		{
			insertable = false;
			 l_status = "0";
			 l_status_desc = "Exception in "+l_app_msg+ " - "+e.getMessage();	
			 keyStr = ""; valueStr = "";
			 e.printStackTrace();
			 if (l_debug_YN.equals("Y"))  System.out.println(" ::: Status Desc InserData ::: "+l_status_desc);
			 
		}
		 finally {
				EMDataSource.returnConnection(con);
				XHUtil.closeDBResources(rs, pstmt, null);
			}	
	}
	
	
	public static String FetchStdCntrlSegMethod(String segmentID,
			String elementId, String standardCode) {

		Connection dbConn = null;
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
			dbConn = EMDataSource.getConnection();
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
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		return l_field_value;
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
	
	public static Map<String, String> getPolicyDefHdrInfo(String facility_id, String payerGroup, String payer, String policy){
		Map<String, String> policyDefHdrInfoParam = new LinkedHashMap<String, String>();
		Connection con					= null;
		PreparedStatement pstmt			= null;
		ResultSet rset					= null;
		
		try{
			String policyDefHdrInfoQuery = "select decode(hdr.CUST_GROUP_CODE,'**','All Payer Group',(select grp.long_desc from ar_cust_group grp where grp.cust_group_code =  hdr.cust_group_code  )) payer_group, hdr.CUST_GROUP_CODE, decode(hdr.CUST_CODE,'**','All Payer',(select cust.long_name from ar_customer cust where  cust.cust_code  = hdr.cust_code )) payer, hdr.CUST_CODE, (select pol.long_desc policy_type from bl_ins_policy_types pol where pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id  = hdr.operating_facility_id ) policy_type, hdr.POLICY_TYPE_CODE, hdr.operating_facility_id, hdr.policy_coverage_basis,hdr.payer_cov_rule,hdr.copay_perc,hdr.def_req_policy_dates,hdr.addl_days_policy_expdt, hdr.slmt_appl_yn,to_char(hdr.policy_eff_from,'dd/mm/yyyy') effective_from,to_char(hdr.policy_eff_to,'dd/mm/yyyy') effective_to,hdr.screening_policy_yn from bl_ins_policy_type_hdr hdr where hdr.operating_facility_id = ?  and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ?";

			con = EMDataSource.getConnection();
			pstmt = con.prepareStatement(policyDefHdrInfoQuery.toString());
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			
			rset = pstmt.executeQuery();
			while(rset.next()){
				
				policyDefHdrInfoParam.put("hdr_payer_group", rset.getString("payer_group"));
				policyDefHdrInfoParam.put("hdr_cust_group_code", rset.getString("CUST_GROUP_CODE"));
				policyDefHdrInfoParam.put("hdr_payer", rset.getString("payer"));
				policyDefHdrInfoParam.put("hdr_cust_code", rset.getString("CUST_CODE"));
				policyDefHdrInfoParam.put("hdr_policy_type", rset.getString("policy_type"));
				policyDefHdrInfoParam.put("hdr_policy_type_code", rset.getString("POLICY_TYPE_CODE"));
				policyDefHdrInfoParam.put("hdr_policy_coverage_basis", rset.getString("policy_coverage_basis"));
				policyDefHdrInfoParam.put("hdr_payer_cov_rule", rset.getString("payer_cov_rule"));
				policyDefHdrInfoParam.put("hdr_copay_perc", rset.getString("copay_perc"));
				policyDefHdrInfoParam.put("hdr_def_req_policy_dates", rset.getString("def_req_policy_dates"));
				policyDefHdrInfoParam.put("hdr_addl_days_policy_expdt", rset.getString("addl_days_policy_expdt"));
				policyDefHdrInfoParam.put("hdr_operating_facility_id", rset.getString("operating_facility_id"));
				policyDefHdrInfoParam.put("hdr_slmt_appl_yn", rset.getString("slmt_appl_yn"));
				policyDefHdrInfoParam.put("hdr_effective_from", rset.getString("effective_from"));
				policyDefHdrInfoParam.put("hdr_effective_to", rset.getString("effective_to"));
				policyDefHdrInfoParam.put("hdr_screening_policy_yn", rset.getString("screening_policy_yn"));
				
			}
			
			System.out.println(" ::: policyDefHdrInfoParam : "+policyDefHdrInfoParam);
			
			
		}catch (Exception e) {
			System.out.println(" ::: Exception in getPolicyDefHdrInfo : "+e.getMessage());
			e.printStackTrace();
		}finally{
			EMDataSource.returnConnection(con);
			XHUtil.closeDBResources(rset, pstmt, null);
		}
		
		return policyDefHdrInfoParam;
	}
	
	public static Map<String, String> getPolicyDefOutpatInfo(String facility_id, String payerGroup, String payer, String policy){
		Map<String, String> policyDefOutpatInfoParam = new LinkedHashMap<String, String>();
		Connection con					= null;
		PreparedStatement pstmt			= null;
		ResultSet rset					= null;
		
		try{
			String policyDefOutpatInfoQuery = "select hdr.op_cred_auth_req_yn credit_req,hdr.op_cred_auth_mand_to_capt_yn credit_mand,hdr.op_dflt_auth_ref_as_pol_no_yn credit_ref, hdr.outpatient_cover covered,hdr.outpatient_limit_type limit_type,hdr.op_approved_days_limit_type day_limit_type, hdr.op_approved_no_of_days np_of_days, hdr.op_approved_amt_limit_type amt_limit_type, hdr.op_approved_amt_limit amt_limit ,hdr.mandatory_bill_gen_check_ind mand_bill, hdr.mand_inv_gen_check_ind_op mand_inv,hdr.op_approved_amt_gross_net amt_gross_net,hdr.across_encounters_yn across_encounter,hdr.OP_PATIENT_COPAY patient_copay,hdr.OP_PATIENT_AMOUNT_LIMIT patient_limit_amount,DFLT_ACR_ENC_GRP_FOR_SAME_EPIS,DFLT_ACR_ENC_GRP_DURN_OP duration_value,DFLT_ACR_ENC_GRP_DURN_TYPE_OP duration_type from bl_ins_policy_type_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ?";

			con = EMDataSource.getConnection();
			pstmt = con.prepareStatement(policyDefOutpatInfoQuery.toString());
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			
			rset = pstmt.executeQuery();
			while(rset.next()){
				
				policyDefOutpatInfoParam.put("outpat_credit_req", rset.getString("credit_req"));
				policyDefOutpatInfoParam.put("outpat_credit_mand", rset.getString("credit_mand"));
				policyDefOutpatInfoParam.put("outpat_credit_ref", rset.getString("credit_ref"));
				policyDefOutpatInfoParam.put("outpat_covered", rset.getString("covered"));
				policyDefOutpatInfoParam.put("outpat_limit_type", rset.getString("limit_type"));
				policyDefOutpatInfoParam.put("outpat_day_limit_type", rset.getString("day_limit_type"));
				policyDefOutpatInfoParam.put("outpat_np_of_days", rset.getString("np_of_days"));
				policyDefOutpatInfoParam.put("outpat_amt_limit_type", rset.getString("amt_limit_type"));
				policyDefOutpatInfoParam.put("outpat_amt_limit", rset.getString("amt_limit"));
				policyDefOutpatInfoParam.put("outpat_mand_bill", rset.getString("mand_bill"));
				policyDefOutpatInfoParam.put("outpat_mand_inv", rset.getString("mand_inv"));
				policyDefOutpatInfoParam.put("outpat_amt_gross_net", rset.getString("amt_gross_net"));
				policyDefOutpatInfoParam.put("outpat_across_encounter", rset.getString("across_encounter"));
				policyDefOutpatInfoParam.put("outpat_patient_copay", rset.getString("patient_copay"));
				policyDefOutpatInfoParam.put("outpat_patient_limit_amount", rset.getString("patient_limit_amount"));
				
			}
			
			System.out.println(" ::: policyDefOutpatInfoParam : "+policyDefOutpatInfoParam);
			
			
		}catch (Exception e) {
			System.out.println(" ::: Exception in getPolicyDefOutpatInfo : "+e.getMessage());
			e.printStackTrace();
		}finally{
			EMDataSource.returnConnection(con);
			XHUtil.closeDBResources(rset, pstmt, null);
		}
		
		return policyDefOutpatInfoParam;
	}
	
	public static Map<String, String> getPolicyDefInpatInfo(String facility_id, String payerGroup, String payer, String policy){
		Map<String, String> policyDefInpatInfoParam = new LinkedHashMap<String, String>();
		Connection con					= null;
		PreparedStatement pstmt			= null;
		ResultSet rset					= null;
		
		try{
			String policyDefInpatInfoQuery = "select hdr.ip_cred_auth_req_yn credit_req,hdr.ip_cred_auth_mand_to_capt_yn credit_mand,hdr.ip_dflt_auth_ref_as_pol_no_yn credit_ref, hdr.inpatient_covered covered,hdr.inpatient_limit_type limit_type,hdr.ip_approved_days_limit_type day_limit_type, hdr.ip_approved_no_of_days np_of_days, hdr.ip_approved_amt_limit_type amt_limit_type, hdr.ip_approved_amt_limit amt_limit ,hdr.mand_bill_gen_check_ind_ip mand_bill, hdr.mand_inv_gen_check_ind_ip mand_inv,hdr.ip_approved_amt_gross_net amt_gross_net,hdr.ip_across_encounters_yn across_encounter,hdr.IP_PATIENT_COPAY patient_copay,hdr.IP_PATIENT_AMOUNT_LIMIT patient_limit_amount,DFLT_ACR_ENC_GRP_FOR_SAME_EPIS,DFLT_ACR_ENC_GRP_DURN_IP duration_value,DFLT_ACR_ENC_GRP_DURN_TYPE_IP duration_type from bl_ins_policy_type_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ?";

			con = EMDataSource.getConnection();
			pstmt = con.prepareStatement(policyDefInpatInfoQuery.toString());
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			
			rset = pstmt.executeQuery();
			while(rset.next()){
				
				
				policyDefInpatInfoParam.put("inpat_credit_req", rset.getString("credit_req"));
				policyDefInpatInfoParam.put("inpat_credit_mand", rset.getString("credit_mand"));
				policyDefInpatInfoParam.put("inpat_credit_ref", rset.getString("credit_ref"));
				policyDefInpatInfoParam.put("inpat_covered", rset.getString("covered"));
				policyDefInpatInfoParam.put("inpat_limit_type", rset.getString("limit_type"));
				policyDefInpatInfoParam.put("inpat_day_limit_type", rset.getString("day_limit_type"));
				policyDefInpatInfoParam.put("inpat_np_of_days", rset.getString("np_of_days"));
				policyDefInpatInfoParam.put("inpat_amt_limit_type", rset.getString("amt_limit_type"));
				policyDefInpatInfoParam.put("inpat_amt_limit", rset.getString("amt_limit"));
				policyDefInpatInfoParam.put("inpat_mand_bill", rset.getString("mand_bill"));
				policyDefInpatInfoParam.put("inpat_mand_inv", rset.getString("mand_inv"));
				policyDefInpatInfoParam.put("inpat_amt_gross_net", rset.getString("amt_gross_net"));
				policyDefInpatInfoParam.put("inpat_across_encounter", rset.getString("across_encounter"));
				policyDefInpatInfoParam.put("inpat_patient_copay", rset.getString("patient_copay"));
				policyDefInpatInfoParam.put("inpat_patient_limit_amount", rset.getString("patient_limit_amount"));
				
			}
			
			System.out.println(" ::: policyDefInpatInfoParam : "+policyDefInpatInfoParam);
			
			
		}catch (Exception e) {
			System.out.println(" ::: Exception in getPolicyDefInpatInfo : "+e.getMessage());
			e.printStackTrace();
		}finally{
			EMDataSource.returnConnection(con);
			XHUtil.closeDBResources(rset, pstmt, null);
		}
		
		return policyDefInpatInfoParam;
	}
	
	public static Map<String, String> getPolicyDefExternalInfo(String facility_id, String payerGroup, String payer, String policy){
		Map<String, String> policyDefExternalInfoParam = new LinkedHashMap<String, String>();
		Connection con					= null;
		PreparedStatement pstmt			= null;
		ResultSet rset					= null;
		
		try{
			String policyDefExternalInfoQuery = "select hdr.ex_cred_auth_req_yn credit_req,hdr.ex_cred_auth_mand_to_capt_yn credit_mand,hdr.ex_dflt_auth_ref_as_pol_no_yn credit_ref, hdr.external_covered covered,hdr.external_limit_type limit_type,hdr.ex_approved_days_limit_type day_limit_type, hdr.ex_approved_no_of_days np_of_days, hdr.ex_approved_amt_limit_type amt_limit_type, hdr.ex_approved_amt_limit amt_limit ,hdr.mand_bill_gen_check_ind_ex mand_bill, hdr.mand_inv_gen_check_ind_ex mand_inv,hdr.ex_approved_amt_gross_net amt_gross_net,hdr.ex_across_encounters_yn across_encounter,hdr.EX_PATIENT_COPAY patient_copay,hdr.EX_PATIENT_AMOUNT_LIMIT patient_limit_amount,DFLT_ACR_ENC_GRP_FOR_SAME_EPIS from bl_ins_policy_type_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ?";

			con = EMDataSource.getConnection();
			pstmt = con.prepareStatement(policyDefExternalInfoQuery.toString());
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			
			rset = pstmt.executeQuery();
			while(rset.next()){
				
				policyDefExternalInfoParam.put("external_credit_req", rset.getString("credit_req"));
				policyDefExternalInfoParam.put("external_credit_mand", rset.getString("credit_mand"));
				policyDefExternalInfoParam.put("external_credit_ref", rset.getString("credit_ref"));
				policyDefExternalInfoParam.put("external_covered", rset.getString("covered"));
				policyDefExternalInfoParam.put("external_limit_type", rset.getString("limit_type"));
				policyDefExternalInfoParam.put("external_day_limit_type", rset.getString("day_limit_type"));
				policyDefExternalInfoParam.put("external_np_of_days", rset.getString("np_of_days"));
				policyDefExternalInfoParam.put("external_amt_limit_type", rset.getString("amt_limit_type"));
				policyDefExternalInfoParam.put("external_amt_limit", rset.getString("amt_limit"));
				policyDefExternalInfoParam.put("external_mand_bill", rset.getString("mand_bill"));
				policyDefExternalInfoParam.put("external_mand_inv", rset.getString("mand_inv"));
				policyDefExternalInfoParam.put("external_amt_gross_net", rset.getString("amt_gross_net"));
				policyDefExternalInfoParam.put("external_across_encounter", rset.getString("across_encounter"));
				policyDefExternalInfoParam.put("external_patient_copay", rset.getString("patient_copay"));
				policyDefExternalInfoParam.put("external_patient_limit_amount", rset.getString("patient_limit_amount"));
				
			}
			
			System.out.println(" ::: policyDefExternalInfoParam : "+policyDefExternalInfoParam);
			
			
		}catch (Exception e) {
			System.out.println(" ::: Exception in getPolicyDefExternalInfo : "+e.getMessage());
			e.printStackTrace();
		}finally{
			EMDataSource.returnConnection(con);
			XHUtil.closeDBResources(rset, pstmt, null);
		}
		
		return policyDefExternalInfoParam;
	}
	
	public static Map<String, String> getPolicyDefServiceInfo(String facility_id, String payerGroup, String payer, String policy){
		Map<String, String> policyDefServiceInfoParam = new LinkedHashMap<String, String>();
		Connection con					= null;
		PreparedStatement pstmt			= null;
		ResultSet rset					= null;
		
		try{
			String policyDefServiceInfoQuery = "select hdr.excl_incl_ind, hdr.ovride_incl_excl_unsp_serv_yn, hdr.last_payer_coverage_yn, hdr.cumm_cvrg_with_oth_payers_yn from bl_ins_policy_type_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ?";

			con = EMDataSource.getConnection();
			pstmt = con.prepareStatement(policyDefServiceInfoQuery.toString());
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			
			rset = pstmt.executeQuery();
			while(rset.next()){
				
				policyDefServiceInfoParam.put("service_excl_incl_ind", rset.getString("excl_incl_ind"));
				policyDefServiceInfoParam.put("service_ovride_incl_excl_unsp_serv_yn", rset.getString("ovride_incl_excl_unsp_serv_yn"));
				policyDefServiceInfoParam.put("service_cumm_cvrg_with_oth_payers_yn", rset.getString("cumm_cvrg_with_oth_payers_yn"));
				policyDefServiceInfoParam.put("service_last_payer_coverage_yn", rset.getString("last_payer_coverage_yn"));
				
			}
			
			System.out.println(" ::: policyDefServiceInfoParam : "+policyDefServiceInfoParam);
			
			
		}catch (Exception e) {
			System.out.println(" ::: Exception in getPolicyDefServiceInfo : "+e.getMessage());
			e.printStackTrace();
		}finally{
			EMDataSource.returnConnection(con);
			XHUtil.closeDBResources(rset, pstmt, null);
		}
		
		return policyDefServiceInfoParam;
	}
	
	public static String returnVal(String inputString,String outputString) {
		return (inputString == null) ? outputString : inputString;
	}
	
	public static String validatePatient(String patient_id){
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String l_app_msg = "";
		String v_patient_id = "";
		l_app_msg = " ::: Inside searchPatient ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		
		try{
			String validatePatientQuery = " select patient_id from mp_patient where patient_id = ? ";
			dbConn = EMDataSource.getConnection();
			pstmt = dbConn.prepareStatement(validatePatientQuery);
			pstmt.setString(1, patient_id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				v_patient_id = rs.getString(1);
			}
		}catch (Exception e) {
			l_app_msg = "Error in Validate Patient Exception - "+ e.getMessage();
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
		} finally {
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		return v_patient_id;
	}
	
	public static String validateLocnType(String locn_type){
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String l_app_msg = "";
		String v_locn_type = "";
		l_app_msg = " ::: Inside validateLocnType ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		
		try{
			String validateLocnTypeQuery = "select locn_type,short_desc from am_care_locn_type_lang_vw where care_locn_type_ind in ('C','E') and locn_type in ('C','E') and SYS_USER_DEF_IND='S' and language_id='en' and locn_type = ? order by short_desc ";
			dbConn = EMDataSource.getConnection();
			pstmt = dbConn.prepareStatement(validateLocnTypeQuery);
			pstmt.setString(1, locn_type);
			rs = pstmt.executeQuery();
			while(rs.next()){
				v_locn_type = rs.getString(1);
			}
		}catch (Exception e) {
			l_app_msg = "Error in Validate Location Type Exception - "+ e.getMessage();
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
		} finally {
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		return v_locn_type;
	}
	
	public static String validateLocnCode(String locn_code, String facility_id, String locn_type){
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String l_app_msg = "";
		String v_locn_code = "";
		l_app_msg = " ::: Inside validateLocnCode ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		
		try{
			String validateLocnCodeQuery = "select clinic_code from op_clinic_lang_vw where clinic_code=? and language_id='en' and facility_id=? and clinic_type = ?";
			dbConn = EMDataSource.getConnection();
			pstmt = dbConn.prepareStatement(validateLocnCodeQuery);
			pstmt.setString(1, locn_code);
			pstmt.setString(2, facility_id);
			pstmt.setString(3, locn_type);
			rs = pstmt.executeQuery();
			while(rs.next()){
				v_locn_code = rs.getString(1);
			}
		}catch (Exception e) {
			l_app_msg = "Error in Validate Location Code Exception - "+ e.getMessage();
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
		} finally {
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		return v_locn_code;
	}
	
	public static String validateService(String locn_code, String facility_id, String service_code){
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String l_app_msg = "";
		String v_service = "";
		l_app_msg = " ::: Inside validateService ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		
		try{
			String validateServiceQuery = "select service_code from am_service_lang_vw where language_id='en' and eff_status = 'E' and service_code in (select service_code from op_clinic where clinic_code = ? and facility_id= ? union SELECT b.service_code FROM OP_CLINIC_FOR_SERVICE b WHERE b.clinic_code = ? AND b.facility_id= ? and b.care_locn_type_ind = 'C') and service_code = ?";
			dbConn = EMDataSource.getConnection();
			pstmt = dbConn.prepareStatement(validateServiceQuery);
			pstmt.setString(1, locn_code);
			pstmt.setString(2, facility_id);
			pstmt.setString(3, locn_code);
			pstmt.setString(4, facility_id);
			pstmt.setString(5, service_code);
			rs = pstmt.executeQuery();
			while(rs.next()){
				v_service = rs.getString(1);
			}
		}catch (Exception e) {
			l_app_msg = "Error in Validate Service Exception - "+ e.getMessage();
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
		} finally {
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		return v_service;
	}
	
	public static String validatePratitioner(String practitioner_id){
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String l_app_msg = "";
		String v_practitioner_id = "";
		l_app_msg = " ::: Inside validatePratitioner ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		
		try{
			String validatePractitionerQuery = "select practitioner_id from am_practitioner_lang_vw where practitioner_id = ? and language_id='en'"; 
			dbConn = EMDataSource.getConnection();
			pstmt = dbConn.prepareStatement(validatePractitionerQuery);
			pstmt.setString(1, practitioner_id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				v_practitioner_id = rs.getString(1);
			}
		}catch (Exception e) {
			l_app_msg = "Error in Validate Practitioner Exception - "+ e.getMessage();
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
		} finally {
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		return v_practitioner_id;
	}
	
	public static String validateVisitType(String facility_id, String clinic_code, String care_locn_type_ind, String visit_type_code){
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String l_app_msg = "";
		String v_visit_type = "";
		l_app_msg = " ::: Inside validateVisitType ::: ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		
		try{
			String validateVisitTypeQuery = "SELECT visit_type_code FROM op_visit_type_for_clinic_vw WHERE care_locn_type_ind IN ('C', 'E', 'D') AND facility_id = ? AND clinic_code = UPPER(?) AND care_locn_type_ind = UPPER(?) AND  visit_type_code =  UPPER(?) ORDER BY clinic_code"; 
			dbConn = EMDataSource.getConnection();
			pstmt = dbConn.prepareStatement(validateVisitTypeQuery);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, clinic_code);
			pstmt.setString(3, care_locn_type_ind);
			pstmt.setString(4, visit_type_code);
			rs = pstmt.executeQuery();
			while(rs.next()){
				v_visit_type = rs.getString(1);
			}
		}catch (Exception e) {
			l_app_msg = "Error in Validate Visit Type Exception - "+ e.getMessage();
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		} finally {
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		return v_visit_type;
	}
	
	public static Map<String, String> validateVisitTypeFirstORFollowup(String facility_id, String patient_id, String location_code, String visit_date_time){
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;
		String l_app_msg = "";
		Map<String, String> FirstORFollowupMap = new LinkedHashMap<String, String>();
		String blng_grp_id = "", cust_grp_code = "", cust_code = "", policy_type_code = "", visit_type_ind = "", f_episode_id = "";
		String f_visit_type_code = "", f_strDesc = "";
		l_app_msg = " ::: Inside validateVisitTypeFirstORFollowup ::: ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		
		try{
			String validateVisitTypeQuery = "{call bl_interface_proc.proc_first_or_followup_visit(?,?,?,?,to_date('"+visit_date_time+"','DD/MM/YYYY HH24:MI:SS'),'','','','',?,?,?,?,?,?)}"; 
			dbConn = EMDataSource.getConnection();
			cstmt = dbConn.prepareCall(validateVisitTypeQuery);
			
			cstmt.setString(1, facility_id);
			cstmt.setString(2, patient_id);
			cstmt.setString(3, "O");
			cstmt.setString(4, location_code);
			cstmt.registerOutParameter( 5,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter( 6,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter( 7,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter( 8,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter( 9,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter( 10,java.sql.Types.VARCHAR);
			
			//rs = cstmt.executeQuery();
			cstmt.executeQuery();
			
				f_episode_id = cstmt.getString(5)==null?"":cstmt.getString(5);
				FirstORFollowupMap.put("f_episode_id", f_episode_id);
				visit_type_ind = cstmt.getString(6);
				if(visit_type_ind==null) visit_type_ind="F";
				FirstORFollowupMap.put("f_visit_type_ind", visit_type_ind);
				blng_grp_id = cstmt.getString(7)==null?"":cstmt.getString(7);
				FirstORFollowupMap.put("blng_grp_id", blng_grp_id);
				cust_grp_code = cstmt.getString(8)==null?"":cstmt.getString(8);
				FirstORFollowupMap.put("cust_grp_code", cust_grp_code);
				cust_code = cstmt.getString(9)==null?"":cstmt.getString(9);
				FirstORFollowupMap.put("cust_code", cust_code);
				policy_type_code = cstmt.getString(10)==null?"":cstmt.getString(10);
				FirstORFollowupMap.put("policy_type_code", policy_type_code);
			
			System.out.println(" ::: FirstORFollowupMap : "+FirstORFollowupMap.toString());
		}catch (Exception e) {
			l_app_msg = "Error in Validate FirstORFollowupMap 1 Exception - "+ e.getMessage();
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		} finally {
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(null, cstmt, null);
		}
		
		try{
			String visitTypeQuery = "SELECT visit_type_code,op_get_desc.op_visit_type (facility_id,visit_type_code,'en','2') short_desc FROM op_visit_type_for_clinic WHERE facility_id = '"+facility_id+"' AND clinic_code = '"+location_code+"' AND eff_status = 'E' and visit_type_ind in('"+visit_type_ind+"') order by 2";
			dbConn = EMDataSource.getConnection();
			pstmt = dbConn.prepareCall(visitTypeQuery);
			rs = pstmt.executeQuery();
			while(rs.next()){
				f_strDesc = rs.getString( "short_desc" ) ;
				f_visit_type_code = rs.getString( "visit_type_code" );
				FirstORFollowupMap.put("f_strDesc", f_strDesc);
				FirstORFollowupMap.put("f_visit_type_code", f_visit_type_code);
			}
			System.out.println(" ::: FirstORFollowupMap After fetching Visit Type : "+FirstORFollowupMap.toString());
			
		}catch (Exception e) {
			l_app_msg = "Error in Validate FirstORFollowupMap Exception - "+ e.getMessage();
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		} finally {
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		
		return FirstORFollowupMap;
	}
	
	public static Map<String, String> validateInsDetails(String cust_code, String policy_type_code){
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Map<String, String> insDetailMap = new LinkedHashMap<String, String>();
		String l_app_msg = "";
		l_app_msg = " ::: Inside validateInsDetails ::: ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		
		try{
			String validatePractitionerQuery = "select distinct POLICY_TYPE_CODE, POLICY_EFF_FROM, POLICY_EFF_TO from BL_INS_POLICY_TYPE_HDR where cust_code = ? and policy_type_code = ? "; 
			dbConn = EMDataSource.getConnection();
			pstmt = dbConn.prepareStatement(validatePractitionerQuery);
			pstmt.setString(1, cust_code);
			pstmt.setString(2, policy_type_code);
			rs = pstmt.executeQuery();
			while(rs.next()){
				insDetailMap.put("POLICY_TYPE_CODE", rs.getString("POLICY_TYPE_CODE"));
				insDetailMap.put("POLICY_EFF_FROM", rs.getString("POLICY_EFF_FROM"));
				insDetailMap.put("POLICY_EFF_TO", rs.getString("POLICY_EFF_TO"));
			}
		}catch (Exception e) {
			l_app_msg = "Error in Validate Insurence Details Exception - "+ e.getMessage();
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		} finally {
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		return insDetailMap;
	}
	
	public static boolean validateVisit(String facility_id, String patient_id, String service_code){
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String l_app_msg = "";
		boolean visitExistFlag = false;
		l_app_msg = " ::: Inside validateVisit ::: ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		
		try{
			String validateServiceQuery = "select '1' from op_patient_queue where facility_id = ?  and patient_id = ? and service_code = ? and queue_status < '07'";
			dbConn = EMDataSource.getConnection();
			pstmt = dbConn.prepareStatement(validateServiceQuery);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, patient_id);
			pstmt.setString(3, service_code);
			rs = pstmt.executeQuery();
			while(rs.next()){
				visitExistFlag = true;
			}
			
			l_app_msg = " ::: visitExistFlag : "+visitExistFlag;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
		}catch (Exception e) {
			l_app_msg = "Error in Validate Visit Exception - "+ e.getMessage();
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		} finally {
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		return visitExistFlag;
	}
	
	public static Map<String, String> validateBlngGrp(String blng_grp_id){
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String l_app_msg = "";
		Map<String, String> v_BlngMap = new HashMap<String, String>();
		l_app_msg = " ::: Inside validateBlngGrp ::: ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		
		try{
			String validatePractitionerQuery = "select distinct BLNG_GRP_ID, NON_INS_BLNG_GRP_ID from BL_BLNG_GRP where BLNG_GRP_ID = UPPER(?)"; 
			dbConn = EMDataSource.getConnection();
			pstmt = dbConn.prepareStatement(validatePractitionerQuery);
			pstmt.setString(1, blng_grp_id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				v_BlngMap.put("BLNG_GRP_ID", rs.getString("BLNG_GRP_ID"));
				v_BlngMap.put("NON_INS_BLNG_GRP_ID", rs.getString("NON_INS_BLNG_GRP_ID"));
			}
		}catch (Exception e) {
			l_app_msg = "Error in Validate Billing Group Exception - "+ e.getMessage();
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		} finally {
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		return v_BlngMap;
	}
	
	public static String validatePayerGrpCode(String payer_group_code){
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String l_app_msg = "";
		String v_payer_group_code = "";
		l_app_msg = " ::: Inside validatePayerGrpCode ::: ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		
		try{
			String validatePractitionerQuery = "select distinct CUST_GROUP_CODE from AR_CUST_GROUP where cust_group_code = UPPER(?)"; 
			dbConn = EMDataSource.getConnection();
			pstmt = dbConn.prepareStatement(validatePractitionerQuery);
			pstmt.setString(1, payer_group_code);
			rs = pstmt.executeQuery();
			while(rs.next()){
				v_payer_group_code = rs.getString(1);
			}
		}catch (Exception e) {
			l_app_msg = "Error in Validate Payer Group Code Exception - "+ e.getMessage();
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		} finally {
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		return v_payer_group_code;
	}
	
	public static String validatePayerCode(String payer_group_code, String payer_code){
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String l_app_msg = "";
		String v_payer_code = "";
		l_app_msg = " ::: Inside validatePayerCode ::: ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		
		try{
			String validatePractitionerQuery = "select distinct CUST_CODE from AR_CUSTOMER where cust_group_code = ? and cust_code = ? "; 
			dbConn = EMDataSource.getConnection();
			pstmt = dbConn.prepareStatement(validatePractitionerQuery);
			pstmt.setString(1, payer_group_code);
			pstmt.setString(2, payer_code);
			rs = pstmt.executeQuery();
			while(rs.next()){
				v_payer_code = rs.getString(1);
			}
		}catch (Exception e) {
			l_app_msg = "Error in Validate Payer Code Exception - "+ e.getMessage();
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		} finally {
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		return v_payer_code;
	}
	
	public static String formatDate(String inDate) {
		String outputString = "";
		String l_app_msg = "";
		try{
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		java.util.Date date = inputFormat.parse(inDate);

		DateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
		outputString = outputFormat.format(date);
		}catch (Exception e) {
			l_app_msg = "Error in Format Date Exception - "+ e.getMessage();
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		}
		return outputString;
	}
	
	public static String validateDateTime(String l_appt_date_time){
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		String query = "";
		String l_app_msg = "";
		String l_resp_value = "";
		
		l_app_msg = " ::: Inside validateDateTime ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		
		l_app_msg = " ::: Appointment Date Time ::: "+l_appt_date_time;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		
		try{
			//query = "select 1 from dual where to_date(?, 'DD/MM/YYYY HH24:MI:SS') >= trunc(sysdate)";
			query = "select 1 from dual where trunc(to_date(?, 'DD/MM/YYYY HH24:MI:SS')) <> trunc(sysdate)";
			dbConn = EMDataSource.getConnection();
			
			pstmt = dbConn.prepareStatement(query);	
			pstmt.setString( 1, l_appt_date_time);
		    rs = pstmt.executeQuery();
		    while(rs.next()){
		    	l_resp_value = rs.getString(1);
		    }
			
		}catch (Exception e) {
			l_resp_value = "Error in validateDateTime Exception - " + e.getMessage();	
		}finally{
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		
		return  l_resp_value;
	}

}
