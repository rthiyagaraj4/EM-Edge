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

public class UpdateApprovalServices {
	
	public static String l_debug_YN = "N";

	public String l_errcd = "S", l_field_separator = "$!^", l_searchcd = "S";
	public String l_errmsg = "";
	public String l_ack_text = "";
	public String l_update_response_str = "";
	public String l_eventType = "F08";

	public static String l_conn_msg = "Error - Unable to connect to the Data base, Kindly contact the System Administrator";
	

	@SuppressWarnings("static-access")
	public String processRequest(String actionKey) {
		
		String l_app_msg = "";
		String l_response_err_json = "", l_facility_id = "";
		String l_in_JSON = "", l_err_msg = "", l_response_str = "", l_message_id = "", l_application_id = "", l_protocol_link_id = "";
		String l_status = "", l_status_desc = "";
		String l_request_date_time ="",   l_patient_id ="",l_encounter_id="",l_approved_services="";
		String l_success_flag="",l_return_text="",l_app_status="";
		
	
        l_in_JSON=XHJSONUtil.createJsonObject(actionKey);
		Map<String,String> l_approval_status = new HashMap<String, String>();
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
			
			l_app_msg = " ************ FinApp Update Approval Stauts  Traction started ************ ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_error = new StringBuffer("Unable to Fetch Update Approval Status- Information Missing");
	
			l_app_msg = " ::: Inside Update Approval Stauts :::";
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
			
			params.put("PROTOCOL_LINK_ID", l_protocol_link_id);
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
			params.put("FACILITY_ID", l_facility_id);
			
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
					
					l_responseJsonString = objMapper.writeValueAsString(l_response_json);
					
					l_app_msg = " :::  Patient record does not exists with the UHID ::: ";
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
					
					params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
					params.put("REQUEST_REF_NO", l_request_ref_no);
				    
					finAppInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_error.toString());
					
					return "200#"+l_responseJsonString+"#";
					
				}
			
			l_req_params.put("patient_id", l_patient_id);
			
			l_app_msg = " ::: Getting patient id from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	
	
	l_encounter_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "encounter_id");
			l_req_params.put("encounter_id", l_encounter_id);	

			l_app_msg = " ::: encounter_id : " + l_encounter_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_approved_services = XHJSONUtil.getJsonRequestString(l_in_JSON, "approved_services");
			l_req_params.put("approved_services", l_approved_services);	

			l_app_msg = " ::: approved_services : " + l_approved_services;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			
						
			l_approval_status = UpdateApprovalStatus(l_facility_id,l_application_id,l_eventType,l_patient_id,l_encounter_id,l_approved_services);

			l_app_msg = " ::: Getting Appointment id from JSON :::"+l_approval_status;

         if(l_approval_status.isEmpty()){
					l_success_flag = "E";
					l_errcd="E";
					l_app_msg = " ::: Search Approval Status ::: "+l_approval_status;
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
				}else{

				l_success_flag =l_approval_status.get("success_flag");
				l_app_status =l_approval_status.get("app_service_list");
				
				}
			
             l_app_msg = " ::: Getting PaymentDetails  :::";								
				params.put("ERR_MSG", "");

				if(l_success_flag.equals("E")){
				
				l_status = "0";
				l_status_desc = "Approval Services are not found";
				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				l_response_json.put("facility_id", l_facility_id);
				l_response_json.put("patient_id", l_patient_id);
				l_response_json.put("encounter_id", l_encounter_id);
				l_response_json.put("approved_services", l_approved_services);
				l_response_json.put("approval_status", l_app_status);
				
				
				l_responseJsonString = objMapper.writeValueAsString(l_response_json);

				
				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				params.put("ERR_MSG", l_error.toString());
				params.put("REQUEST_REF_NO", l_request_ref_no);
				params.put("PATIENT_ID", l_patient_id);
				params.put("ENCOUNTER_ID", l_encounter_id);
				params.put("FACILITY_ID", l_facility_id);
				params.put("APPROVED_SERVICES", l_approved_services);
				
				l_response_str = finAppInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, "");
				l_app_msg = " ::: Message Load Method  ::: "+ l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);		
						
				l_app_msg = " ************ FinApp Update Approval Status  From exception ************ ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				return "200#"+ l_responseJsonString +"#";
			}
				
			if(l_success_flag.equals("S")){
				
				l_status = "1";
				l_status_desc = "Patient Approval Status updated Successfully";
				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				l_response_json.put("facility_id", l_facility_id);
				l_response_json.put("patient_id", l_patient_id);
				l_response_json.put("encounter_id", l_encounter_id);
				l_response_json.put("approved_services", l_approved_services);
				l_response_json.put("approval_status", l_app_status);
				
				l_responseJsonString = objMapper.writeValueAsString(l_response_json);

				
				l_response_str = finAppInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, "");
				l_app_msg = " ::: Message Load Method  ::: "+ l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);		
						
				l_app_msg = " ************ FinApp Update Approval Status Traction Ended ************ ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				return "200#"+ l_responseJsonString +"#";
			}				
		}catch(Exception e){
			 
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^ Exception Occurred " + e.getMessage();
			l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \"Reference Number-validateAppt :" + l_app_msg + " Exception l_payment_details: " + l_approval_status + " \"  " + " } ";
			
			l_app_msg = "::: On Exception the message is loaded ::: ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());

			l_response_str = finAppInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, "");
			l_app_msg = l_app_msg + " : " + l_response_str;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_app_msg = " ************ FINAPP Update Approval Status Traction request` Ended from Catch Block************ ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			return "200#" + l_response_err_json + "#";
			
			
		}	
		
		return "200#"+ l_response_err_json +"#";
	}
	public static Map<String, String> UpdateApprovalStatus(String facility_id,String application_id,String event_type,String patient_id,String encounter_id,String approved_services)
	{
		Connection dbConn = null;
		ResultSet rs = null;
		CallableStatement cstmt = null ;
		Map<String, String> ApprovalStatus = new HashMap<String, String>();
		String success_flag="",return_text="";
		
		String l_app_msg = "", query = "";
		
		l_app_msg = " ::: Inside getApprovalServices ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		
		
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		try
		{
			dbConn = EMDataSource.getConnection();
			cstmt=dbConn.prepareCall("{call XH_TRX_API.FETCH_PAT_AVAILED_SERVICES (?,?,?,?,?,?,?,?)}");

			cstmt.setString( 1, facility_id); 
			cstmt.setString( 2, application_id); 
			cstmt.setString( 3, event_type); 
			cstmt.setString( 4, patient_id); 
			cstmt.setString( 5, encounter_id); 
			cstmt.setString( 6, approved_services); 
			cstmt.registerOutParameter(7, java.sql.Types.VARCHAR ); 
			cstmt.registerOutParameter(8, java.sql.Types.VARCHAR ); 
			
			cstmt.execute();
			 success_flag = cstmt.getString(7)==null?"E":cstmt.getString(7);
			 return_text  = cstmt.getString(8)==null?"":cstmt.getString(8);

			System.out.println(" Query Approval Services in params facility_id==="+facility_id+"event_type=="+event_type+"patient_id=="+patient_id+"application_id=="+application_id+"encounter_id=="+encounter_id+"approved_services=="+approved_services);
			System.out.println("success_flag@@481 QueryApprovalServices==="+success_flag+"return_text=="+return_text);
				
			 ApprovalStatus.put("success_flag",success_flag);
			 ApprovalStatus.put("approval_status",return_text);
			 
			
			l_app_msg = " ::: Approval List Details Fetch ::: "+ ApprovalStatus; 
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			 
		}catch (Exception e) {
			l_app_msg = "Error in getApprovalServices  Exception - "+ e.getMessage();
			ApprovalStatus.put("Error", l_app_msg);
		} finally {
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, cstmt, null);
		}
		
		return ApprovalStatus;
		
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
				l_app_msg = " ::: Message Load Method  ::: "+ l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);				
				
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

	
}

