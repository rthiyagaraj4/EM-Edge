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

import eXH.util.EMDataSource;
import eXH.util.XHJSONBuild;
import eXH.util.XHJSONUtil;
import eXH.util.XHUtil;


public class MoheQueryVisitTypeTransaction {
	public static String l_debug_YN = "N";

	public String l_errcd = "S", l_field_separator = "$!^";
	public String l_errmsg = "";
	public String l_ack_text = "";
	public String l_update_response_str = "";
	
	public static String l_conn_msg = "Error - Unable to connect to the Data base, Kindly contact the System Administrator";

	
	public String l_eventType = "OA29";
	
	public String processRequest(String actionKey) {
		
		String l_app_msg = "";
		String l_response_err_json = "", l_facility_id = "";
		String l_in_JSON = "", l_err_msg = "", l_response_str = "", l_message_id = "", l_application_id = "", l_protocol_link_id = "";
		String l_status = "", l_status_desc = "";
		
		String l_patient_id = "", l_clinic_code = "", l_practitioner_id = "";
		String l_op_validation_for_visit_rule = "", l_service_code = "", l_adm_date_time = "", l_validate_appt_date_time = "";

		ArrayList l_external_app_details = null;
		Map<String, String> params = new HashMap<String, String>();
		List<Map<String,String>> l_visit_rule = new ArrayList<Map<String,String>>();
		Map<String, Object> l_response_json = new HashMap<String, Object>();
		ObjectMapper objMapper = new ObjectMapper();
		
		MoheInboundTransaction practoInboundTransaction = new MoheInboundTransaction();

		String l_request_ref_no = "", l_request_type = "", l_responseJsonString = "";
		StringBuffer l_error = null;
		
		try{
			l_debug_YN = XHUtil.l_debug_YN;
			
			l_app_msg = " ************ Mohe Query Patient Visit Type Traction started ************ ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Inside Mohe Query Visit Type :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_app_msg = " ::: Generating Message ID ::: ";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);

			l_message_id = GenerateMessageIDMethod("XH_IB_MESSAGE_ID_SEQ");	
			
			if (l_message_id.indexOf("Error") >= 0) {
				l_errmsg = "Message ID Generation - "+l_message_id;
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_errmsg + " \"  "
						+ " } ";
				
				return "500#" + l_response_err_json + "#";
			}
			
			l_app_msg = " ::: Generated Message Id ::: "+l_message_id+" ::: Error Code : "+l_errcd+" ::: Error Message : "+l_errmsg;
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			
			
			if (l_errcd.equals("S"))				
			{			
				l_app_msg = "::: Fetching External Application Details : ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
	
				l_external_app_details = FetchExternalAppDetails("MOHEINB");			
				
				if (l_external_app_details.isEmpty()) 
				{
					l_errcd = "E";
					l_errmsg = "Error in Fetching External Application Details No Data Available";		
					l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_errmsg + " \"  "
							+ " } ";
					return   "200#"+l_response_err_json+"#";
				}
				
				l_application_id = (String) l_external_app_details.get(0);
				
				if (l_application_id.indexOf("Error") >= 0) {
					l_errcd = "E";
					l_errmsg = "Fetching External Application Details - "+l_application_id;
					l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_errmsg + " \"  "
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
			
			l_error = new StringBuffer();
			
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

				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_err_msg + " \"  "+ " } ";	
				
				l_app_msg = " ::: Inserting Request into Message Table Error in Parsing Request :::"+actionKey;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
				practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
				
				return "200#"+ l_response_err_json +"#";

			}
			
			l_error = new StringBuffer(" Unable to Query Patient Visit Type - Information Missing");
			
			l_app_msg = " ::: Getting Request Reference Number from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	
			l_request_ref_no = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_ref_no");
			if (l_request_ref_no.indexOf("Error") >= 0 || l_request_ref_no.trim().equals("")) {
				l_errcd = "E";
				l_err_msg = " - Request Reference Number";
				l_error.append(l_err_msg);
				
			}
			
			l_app_msg = " ::: Request Ref Number : " + l_request_ref_no;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_app_msg = " ::: Getting Request Type from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	
			l_request_type = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_type");
			if (l_request_type.indexOf("Error") >= 0 || l_request_type.trim().equals("")) {
				l_errcd = "E";
				l_err_msg = " - Request Type";
				l_error.append(l_err_msg);
				
			}
			l_app_msg = " ::: Request Type : " + l_request_type;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_app_msg = " ::: Getting Patient Id from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	
			l_patient_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "patient_id");
			if (l_patient_id.indexOf("Error") >= 0 || l_patient_id.trim().equals("")) {
				l_errcd = "E";
				l_err_msg = " - Patient Id";
				l_error.append(l_err_msg);
				
			}
			l_app_msg = " ::: Patient Id : " + l_patient_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_app_msg = " ::: Getting Clinic Code from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	
			l_clinic_code = XHJSONUtil.getJsonRequestString(l_in_JSON, "clinic_code");
			if (l_clinic_code.indexOf("Error") >= 0 || l_clinic_code.trim().equals("")) {
				l_errcd = "E";
				l_err_msg = " - Clinic Code";
				l_error.append(l_err_msg);
				
			}
			l_app_msg = " ::: Clinic Code : " + l_clinic_code;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_app_msg = " ::: Getting Practitioner Id from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	
			l_practitioner_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "practitioner_id");
			if (l_practitioner_id.indexOf("Error") >= 0 || l_practitioner_id.trim().equals("")) {
				l_errcd = "E";
				l_err_msg = " - Practitioner Id";
				l_error.append(l_err_msg);
				
			}
			l_app_msg = " ::: Practitioner ID : " + l_practitioner_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_app_msg = " ::: Getting Appointment Date Time from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	
			l_adm_date_time = XHJSONUtil.getJsonRequestString(l_in_JSON, "appt_date_time");
			l_adm_date_time = l_adm_date_time.trim();
			if (l_adm_date_time.indexOf("Error") >= 0 ) {
				l_errcd = "E";
				l_err_msg = " - Appointment Date Time";
				l_error.append(l_err_msg);
				
			}
			l_app_msg = " ::: Appointment Date Time : " + l_adm_date_time;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);			
			
			
			if(l_errcd.equals("E")){
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_error.toString() + " \"  "+ " } ";				
				
				l_app_msg = " ::: Inserting Request into Message Table Request Information Missing :::"+actionKey;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
				practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
				
				return "200#"+ l_response_err_json +"#";
			}	
			
			
			//appt_date_time
			//l_adm_date_time 
			
			l_error = new StringBuffer(" Unable to Query Patient Visit Type -");
			
			l_app_msg = " ::: Validate Appointment Date Time :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			if (!l_adm_date_time.equals("")) {

				l_validate_appt_date_time = validateDateTime(l_adm_date_time);

				if (l_validate_appt_date_time.indexOf("Error") >= 0
						|| !l_validate_appt_date_time.equals("1")) {
					l_errcd = "E";
					l_err_msg = " Appointment Date Time can't less than Current Date Time";
					l_error.append(l_err_msg);
				}
			}
			
			if(l_errcd.equals("E")){
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_error.toString() + " \"  "+ " } ";				
				
				l_app_msg = " ::: Inserting Request into Message Table Request Information Missing :::"+actionKey;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
				practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
				
				return "200#"+ l_response_err_json +"#";
			}
			
			//
			
			if (l_errcd.equals("S"))
			{
				l_app_msg = "::: Fetching Service Code : ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				l_service_code = FetchServiceCode(l_clinic_code);
				
				if (l_service_code.indexOf("Error") >= 0 ) {
					l_errcd = "E";
					l_errmsg = "::: Fetching Service Code - "+l_service_code;
					l_error.append(l_errmsg);
					
				}
				
				l_app_msg = "::: Service Code : "+l_service_code;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				l_error = new StringBuffer(" Unable to Query Patient Visit Type - ");
				
				l_app_msg = "::: Fetching OP Validation for Visit Type : ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				if(l_errcd.equals("S")){
				
					l_op_validation_for_visit_rule = FetchOPValidVisitType(l_facility_id, l_practitioner_id, l_patient_id, l_service_code, l_adm_date_time);
					
					if (l_op_validation_for_visit_rule.isEmpty()) {
						l_errcd = "E";
						l_errmsg = " Fetching OP Validation Visit Rule - "+l_op_validation_for_visit_rule;
						l_error.append(l_errmsg);
						
					}
					
					l_app_msg = "::: OP Validation for Visit Rule : "+l_op_validation_for_visit_rule;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
				}
				
				l_app_msg = "::: Fetching Visit Type Code : ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
					
						
						l_visit_rule = FetchVisitTypeCode(l_facility_id, l_clinic_code, l_op_validation_for_visit_rule, l_practitioner_id, l_patient_id);
						
						if ( l_visit_rule.isEmpty()) 
						{
							l_errcd = "E";	
							l_errmsg = " Fetching Visit Rule - "+l_visit_rule;
							l_error.append(l_errmsg);
						}
						
						l_app_msg = "::: Fetching Visit Rule : "+l_visit_rule;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						
						
						if(l_errcd.equals("S") && !l_visit_rule.equals("") && l_visit_rule != null)
						{
							l_status = "1";
							l_status_desc = "Visit Type details successfully retrieved";							
							l_response_json.put("request_ref_no", l_request_ref_no);
							l_response_json.put("status", l_status);
							l_response_json.put("status_desc", l_status_desc);
							l_response_json.put("patient_data", l_visit_rule);
							
							l_responseJsonString = objMapper.writeValueAsString(l_response_json);
							
							params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
							practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, "");
							
							return "200#"+ l_responseJsonString +"#";
							
						}
				
				if(l_errcd.equals("E")) {
					l_status = "0";
					l_status_desc = " Visit Type details not found";		
					l_error.append(l_status_desc);
					Map<String, String> emptyParam = new LinkedHashMap<String, String>();
					emptyParam.put("patient_id", "");
					emptyParam.put("clinic_code", "");
					emptyParam.put("practitioner_id", "");
					emptyParam.put("visit_type_code", "");
					emptyParam.put("visit_type_desc", "");
					
					ArrayList<Map<String,String>> emptyPatientDtls = new ArrayList<Map<String, String>>();
					emptyPatientDtls.add(emptyParam);
					
					l_response_json.put("request_ref_no", l_request_ref_no);
					l_response_json.put("status", l_status);
					l_response_json.put("status_desc", l_status_desc);					
					l_response_json.put("patient_data", emptyPatientDtls);
					
					l_responseJsonString = objMapper.writeValueAsString(l_response_json);
					
					params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
					practoInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
					
					return "200#"+ l_responseJsonString +"#";
				}
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^ Exception Occurred " + e.getMessage();
			l_responseJsonString = l_errmsg;
		}
		
		return "200#"+l_responseJsonString+"#";
	}
	
	// Validate Appointment Date Time
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
			query = "select 1 from dual where to_date(?, 'DD/MM/YYYY HH24:MI:SS') >= trunc(sysdate)";
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
	
	// Method for Fetch Visit Type Code
	public static List<Map<String, String>> FetchVisitTypeCode(String facility_id, String clinic_code, String visit_rule, String practitioner_id, String patient_id){
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		ArrayList<Map<String,String>> l_visitCodeDesc = new ArrayList<Map<String,String>>();
		Map<String, String> record = null;
		String query = "";
		String l_app_msg = "";
		
		l_app_msg = " ::: Inside FetchVisitTypeCode ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		
		l_app_msg = " ::: facility_id ::: "+facility_id+" ::: clinic_code ::: "+clinic_code+" ::: visit_rule :::"+visit_rule ;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		
		try{
			dbConn = EMDataSource.getConnection();
			query = "SELECT visit_type_code,op_get_desc.op_visit_type (facility_id,visit_type_code,'en','2') short_desc FROM op_visit_type_for_clinic"+
			           " WHERE facility_id = '"+facility_id+"' AND clinic_code = '"+clinic_code+"' AND eff_status = 'E' and visit_type_ind in('"+visit_rule+"','E') AND visit_type_code IN (SELECT VISIT_TYPE_CODE FROM OP_VISIT_TYPE WHERE FACILITY_ID = 'QF'  AND EFF_STATUS = 'E') order by 2";
			
			l_app_msg = " ::: Query for search patient ::: "+query;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			pstmt = dbConn.prepareStatement(query);				
		    rs = pstmt.executeQuery();
		    
		    while(rs.next()){
		    	record = new LinkedHashMap<String, String>();
		    	record.put("patient_id", patient_id);
		    	record.put("clinic_code", clinic_code);
		    	record.put("practitioner_id", practitioner_id);
		    	record.put("visit_type_code", rs.getString("visit_type_code"));
		        record.put("visit_type_desc", rs.getString("short_desc"));
		        l_visitCodeDesc.add(record);
		    }
		    
		    
		    l_app_msg = " ::: Fetched Visit Type Code ::: "+l_visitCodeDesc;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			if(l_visitCodeDesc.equals("") && l_visitCodeDesc.isEmpty()){
				record = new LinkedHashMap<String, String>();
				l_app_msg = "Error No record does not exists";
				record.put("Error", l_app_msg);
				l_visitCodeDesc.add(record);
			}
		    
		}catch (Exception e) {
			l_app_msg = "Error in FetchVisitTypeCode Exception - " + e.getMessage();	
			record.put("Error", l_app_msg);
			l_visitCodeDesc.add(record);
		} finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		
		return l_visitCodeDesc;
	}
	
	// Method for Fetch Validation Visit Type
	public static String FetchOPValidVisitType(String facility_id, String practitioner_id, String patient_id, String service_code, String appt_date_time){
		String l_op_validation_visit_type = "";
		
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "";
		
		l_app_msg = " ::: Inside FetchOPValidVisitType ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		
		try{
			dbConn = EMDataSource.getConnection();
			//query = "Select op_validation_for_visit_type(?,?,?,?) from Dual";
			query = "Select xh_validation_for_visit_type(?,?,?,?,?) from Dual";
			
			pstmt = dbConn.prepareStatement(query);		 
		    pstmt.setString( 1, facility_id);
		    pstmt.setString( 2, patient_id);
		    pstmt.setString( 3, practitioner_id);
		    pstmt.setString( 4, service_code);	
		    pstmt.setString(5, appt_date_time);
		    rs = pstmt.executeQuery();
		    
		    if(rs.next()){
			   l_op_validation_visit_type = rs.getString(1);				
		    }
		}catch (Exception e) {
			l_op_validation_visit_type = "Error in FetchOPValidVisitType Exception - " + e.getMessage();	
			if (l_debug_YN.equals("Y"))
				System.out.println(l_op_validation_visit_type);
			return l_op_validation_visit_type;
		} finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
			   
		
		return l_op_validation_visit_type;
	}
	
	// Method for Fetching Service Code
	public static String FetchServiceCode(String clinic_code){
		String l_service_code = "";
		
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "";
		
		l_app_msg = " ::: Inside FetchServiceCode ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		
		try {
			dbConn = EMDataSource.getConnection();
			query = "SELECT SERVICE_CODE FROM OP_CLINIC WHERE CLINIC_CODE = ? ";
			
			if (dbConn == null)
				return l_conn_msg;
			

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, clinic_code);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				l_service_code = rs.getString("SERVICE_CODE");
			}
			
		}catch (Exception e) {
			l_service_code = "Error in FetchServiceCode Exception - " + e.getMessage();	
			if (l_debug_YN.equals("Y"))
				System.out.println(l_service_code);
			return l_service_code;
		} finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		
		return l_service_code;
	}
	
	// Method for Generating Message ID
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
	
	// Method for Getting External Application Details
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
				//dbConn =  EMDBConnectionPool.getConnection();
				query = "SELECT APPLICATION_ID,PROTOCOL_LINK_ID,FACILITY_ID FROM xh_filter_dms_vw WHERE EXTERNAL_APPLICATION = 'MOHEINB'";
				
				if (dbConn == null)	
				{
					externalArray.add(l_conn_msg);
					return externalArray;
				}
	
				pstmt = dbConn.prepareStatement(query);
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
				//XHUtil.closeDBResources(rs, pstmt, dbConn);		
				XHUtil.closeDBResources(rs, pstmt, null);
				EMDataSource.returnConnection(dbConn);
			}
		return externalArray;
	}

}
