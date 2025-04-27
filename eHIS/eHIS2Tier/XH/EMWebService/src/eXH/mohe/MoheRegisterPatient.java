package eXH.mohe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import eXH.util.EMDataSource;
import eXH.util.XHJSONUtil;
import eXH.util.XHUtil;

public class MoheRegisterPatient {
	
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
		String l_in_JSON = "", l_err_msg = "", l_response_str = "", l_message_id = "", l_application_id = "", l_protocol_link_id = "";
		String l_status = "", l_status_desc = "";
		String l_request_date_time ="", l_patient_prefix = "",  l_gender ="", l_date_of_birth = "";
		String  l_mobile_no = "", l_nationality = "", l_address_line_1 = "", l_address_line_2 = "", l_address_line_3 = "", l_city = "", l_district = "", l_state = "", l_postal_code = "", l_country = "", l_email_id = "";
		
		String l_first_name = "", l_second_name = "", l_surname = "", l_patient_id = "";
		String l_country_validate = "", l_postal_code_validate = "";
		String l_financial_details = "" , l_billing_group_code = "" , l_payer_group_code ="" , l_payer_code = "";
		String l_policy_type_code = "",  l_policy_number ="" , l_policy_start_date = "" , policy_end_date = "" , l_non_ins_blng_grp_id = "" ;
		String l_third_name = "";
		String l_national_id = "";
		String l_alternate_id_2 = "";
		List<Map<String,String>> l_searchPatientDetails = new ArrayList<Map<String,String>>();
		List<Map<String,String>> l_patient_resp = new ArrayList<Map<String,String>>();
		@SuppressWarnings("rawtypes")
		ArrayList l_external_app_details = null;
		Map<String, String> params = new HashMap<String, String>();
		Map<String, Object> l_response_json = new HashMap<String, Object>();
		ObjectMapper objMapper = new ObjectMapper();
		Map<String,String> l_req_params = new HashMap<String, String>();
		MoheInboundTransaction practoInboundTransaction = new MoheInboundTransaction();
		
		String l_address_line1 = "";

		String l_request_ref_no = "", l_request_type = "", l_responseJsonString = "";
		
		StringBuffer l_error = null;
		
		String l_patient_id_3 = "";
		
		try
		{

			l_debug_YN = XHUtil.l_debug_YN;
			
			l_app_msg = " ************ Mohe Register Patient Transaction started ************ ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_error = new StringBuffer("Unable to Register the Patient - Information Missing");
	
			l_app_msg = " ::: Inside Mohe Register Patient Details :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);	
		
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
			
			
			l_app_msg = " ::: Getting Request Date Time from JSON :::";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
	
			l_request_date_time = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_date_time");
			if (l_request_date_time.indexOf("Error") >= 0 || l_request_date_time.length() <= 1 || l_request_date_time.equals("") ) {
				l_errcd = "E";
				l_error.append(" - Request Date Time");
			}
			l_app_msg = " ::: Request Date Time : " + l_request_date_time;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			if(l_in_JSON.contains("first_name"))
			{
				l_app_msg = " ::: Getting Request First name from JSON :::";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_first_name = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","first_name");
				if (l_first_name.indexOf("Error") >= 0 || l_first_name.length() <= 1 || l_first_name.equals("")) {
					l_errcd = "E";
					l_error.append(" - first_name");	
				}
				l_app_msg = " ::: First Name : " + l_first_name;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				if(l_first_name.length()>0)
				{
				
					l_app_msg = " ::: Getting Request Family name from JSON :::";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_surname = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","surname");
					if (l_surname.indexOf("Error") >= 0 || l_surname.length() <= 1 || l_surname.equals("")) {
						l_errcd = "E";
						l_error.append(" - surname");
					}
					l_app_msg = " ::: Family Name : " + l_surname;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_app_msg = " ::: Getting Request Gender from JSON :::";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_gender = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","gender");
					if (!l_gender.equals("M") && !l_gender.equals("F") && !l_gender.equals("U")) {
						l_errcd = "E";
						l_error.append(" - gender"+l_gender);
					}
					l_app_msg = " ::: Gender : " + l_gender;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_app_msg = " ::: Getting Request Date of Birth from JSON :::";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_date_of_birth = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","date_of_birth");
					if (l_date_of_birth.indexOf("Error") >= 0 || l_date_of_birth.length() <= 1 || l_date_of_birth.equals("")) {
						l_errcd = "E";
						l_error.append(" - date_of_birth");
					}
					l_app_msg = " ::: Date of Birth : " + l_date_of_birth;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_app_msg = " ::: Getting National_id from JSON :::";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
					l_national_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","national_id");
					if (l_national_id.indexOf("Error") >= 0 || l_national_id.length() <= 1 || l_national_id.equals("") ) {
						l_errcd = "E";
						l_error.append(" - national_id "+ l_national_id);
					}
					if(l_national_id.length()>=20)
					{
						l_error = new StringBuffer();
						l_errcd = "E";
						l_error.append(" Unable to Register - national_id length cannot be more than 20 -"+l_national_id);
					}
					
					l_app_msg = " ::: Request National_id : " + l_national_id;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_alternate_id_2 = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","alternate_id_2");
					if(l_alternate_id_2.length() >=20)
					{
						l_error = new StringBuffer();
						l_errcd = "E";
						l_error.append(" Unable to Register - alternate_id_2 length cannot be more than 20 -"+ l_alternate_id_2);
					}
					
				}
			}
			
			if(l_in_JSON.contains("address_line_1"))
			{
				l_app_msg = " ::: Getting Request Address Line_1 from JSON :::";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_address_line1 = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data","address_line_1");
				if (l_address_line1.indexOf("Error") >= 0 || l_address_line1.length() <= 1 || l_address_line1.equals("")) {
					l_errcd = "E";
					l_error.append(" - address_line_1");
				}
				l_app_msg = " ::: AddressLine1 : " + l_address_line1;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			}
				
			
			if(l_in_JSON.contains("financial_details"))
			{
				l_app_msg = " ::: Reading in Patient Data - Financial Details ::: ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				Map<String, Object> patDocument = new HashMap<String, Object>(); 
				List<Integer> financial = null;
				
				try {
				
					patDocument = new ObjectMapper()
		        		.readValue(l_in_JSON, new TypeReference<Map<String, Object>>() {});
	
					List<Object> patList = (List<Object>) patDocument.get("patient_data");
					Map<String, Object> patMap = (Map<String, Object>) patList.get(0);
					
					if (l_debug_YN.equals("Y")) System.out.println(" ::: patMap ::: "+patMap.toString());
					
					financial = (List<Integer>) patMap.get("financial_details");
					
					if (l_debug_YN.equals("Y")) System.out.println(" ::: financial.size() ::: "+financial.size());
					
					if (financial.size()>0)
					{		
						List<Object> finList = (List<Object>) patMap.get("financial_details");
						Map<String, Object> finMap = (Map<String, Object>) finList.get(0);
						
						if (l_debug_YN.equals("Y")) System.out.println(" ::: finMap ::: "+finMap.toString());			
						
					}
				
				}catch (Exception e){
					System.out.println(e.getMessage());
				}
				
				if (financial.size()>0)
				{
					l_app_msg = " ::: Getting Request Financial Details from JSON :::";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_financial_details =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "financial_details");
					if (l_debug_YN.equals("Y")) System.out.println(" ::: Financial Details ::: "+l_billing_group_code);
					
					l_financial_details = l_financial_details.replace("[", "");
					l_financial_details = l_financial_details.replace("]", "");
					
					if (l_debug_YN.equals("Y")) System.out.println(" ::: Financial Details After remove [::: "+l_financial_details);
					l_app_msg = " ::: Reading in Financial Details ::: ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					
					l_billing_group_code =XHJSONUtil.getJsonRequestString( l_financial_details , "billing_group_code");
					if (l_debug_YN.equals("Y")) System.out.println(" ::: Billing Group Code ::: "+l_billing_group_code);
					if (l_billing_group_code.indexOf("Error") >= 0 || l_billing_group_code.length() <= 1 || l_billing_group_code.equals("")) 
					 {
						l_errcd = "E";
						l_error.append(" - Billing Group Code ");
					}
					l_app_msg = " ::: Billing Group Code : " + l_billing_group_code;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					l_req_params.put("l_billing_group_code", l_billing_group_code);
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
			
			
			l_app_msg = " ::: After Search  l_errcd ::: "+l_errcd +" ::: l_searchcd ::: "+l_searchcd;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_app_msg = " ::: Calling Patient Registration mehtod ::: ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			if(l_errcd.equals("S")){
				l_app_msg = " ::: Registering New Patient ::: ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					l_patient_id = MohePatient.PatientDetails(actionKey);
					
					if (l_debug_YN.equals("Y")) System.out.println("l_patient_id is..."+l_patient_id);
					
				if (l_patient_id.indexOf("Exception in") >= 0  || "".equals(l_patient_id.trim())  )
				{
					l_errcd = "E";
					if("".equals(l_patient_id.trim()) )
					{
						l_error = new StringBuffer();
						l_error.append("Patient Id does not match ");
					}
					l_error.append(l_patient_id);
				}
				
				
				if (l_patient_id.equals("Patient Already Exists"))
				{
					l_errcd = "E";
					l_error.append(l_patient_id);
				}
				if (l_patient_id.equals("Patient ID does not match"))
				{
					l_errcd = "E";
					l_error.append(l_patient_id);
				}
				if(l_patient_id.equals("Patient Series Group not Configured for this Facility ID to Generate the new Patient ID")){
					l_error = new StringBuffer("Unable to Register the Patient - ");
					l_errcd = "E";
					l_error.append(l_patient_id);
				}
				
				params.put("ERR_MSG", "");
				l_app_msg = " ::: MohePatient.PatientDetails  l_errcd ::: "+l_errcd +" ::: l_searchcd ::: "+l_searchcd;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				if (l_errcd.equals("E"))
				{
					l_app_msg = " ::: Inserting Request into Message Table while message data validation ::: ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					l_responseJsonString = sendErrorResponse(actionKey, l_error.toString(), l_request_ref_no, params);					
					
					return "200#"+ l_responseJsonString +"#";			
				}	
					
			}	
				
			l_app_msg = " ::: Resgistered Patient Id ::: "+l_patient_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			if(l_errcd.equals("S")){
				if(l_patient_id.contains("Patient Data Updated Successfully"))
				{
					l_patient_id_3 = l_patient_id;
					l_patient_id = l_patient_id.substring(33);
				}
				
				l_app_msg = " ::: FetchPatient ::: ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			    	l_patient_resp = FetchPatient(l_patient_id);
			    	
			    
			}
			l_app_msg = " ::: FetchPatient Response ::: "+l_patient_resp;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			if (l_searchcd.equals("S") && (l_errcd.equals("S")) &&(l_patient_id_3.contains("Patient Data Updated Successfully")) ){	
				
				l_status = "2";
				l_status_desc = "Patient Data Updated successfully";
				l_searchcd = "E";
						
			}
			
			if (l_searchcd.equals("S") && (l_errcd.equals("S")) && (l_request_type.equals("REGPAT"))){	
				
				l_status = "1";
				l_status_desc = "Patient data registered successfully ";
				
			}		
			if (l_errcd.equals("S")){	
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
						
				l_app_msg = " ************ Mohe Register Patient Traction Ended ************ ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				return "200#"+ l_responseJsonString +"#";
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^ Exception Occurred " + e.getMessage();
			
			l_app_msg = " ************ Mohe Register Patient Traction Ended ************ ";
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
			
			l_app_msg = " ::: FetchPatient Result ::: "+ searchPatientDtls;
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
				whereCond.append(" first_name = ? ");
			
			if ((second_name.length()>0) && (whereCond.length()>0))
				whereCond.append(" AND SECOND_NAME = ? ");
			else if (second_name.length()>0)
				whereCond.append(" SECOND_NAME = ? ");
			
			if ((family_name.length()>0) && (whereCond.length()>0))
				whereCond.append(" AND family_name = ? ");
			else if (family_name.length()>0)
				whereCond.append(" family_name = ? ");
			
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

	
	public  String sendErrorResponse(String actionKey, String error , String request_ref_no, Map<String, String> params)
	{
		String l_status = "", l_status_desc = "", l_responseJsonString = "",l_app_msg ="",  l_response_str = "";
		Map<String, Object> l_response_json = new HashMap<String, Object>();
		LinkedHashMap<String, String> patient_data = new LinkedHashMap<String, String>();
		//Map<String, String> params = new HashMap<String, String>();
		MoheInboundTransaction practoInboundTransaction = new MoheInboundTransaction();
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

