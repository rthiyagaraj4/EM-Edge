package eXH.mohe;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

import eXH.util.EMDataSource;
import eXH.util.XHJSONUtil;
import eXH.util.XHUtil;

public class MohePatientVisitBillTransaction {
	
	public static String l_debug_YN = "N";

	public String l_errcd = "S";
	public String l_errmsg = "";
	public String l_segment_id = "MOHE";
	public String l_standard_code = "HTTPCC";
	public String l_eventType = "BL12";

	public static String l_conn_msg = "Error - Unable to connect to the Data base, Kindly contact the System Administrator";
	
	public String TransRequestMethod(String actionKey) {

		String l_facility_id = "", l_user_id = "";
		String l_episode_id = "", l_visit_id = "", l_workstation_id = "", l_cash_counter_code = "", l_episode_type = "", l_patient_id = "";
		String l_from_bill_doc_type = "", l_from_bill_doc_num = "", l_to_bill_doc_type = "", l_to_bill_doc_num = "", p_msg = "", p_status = "";
		String l_app_msg = "", l_message_id = "", l_response_err_json = "", l_application_id = "", l_protocol_link_id = "", l_in_JSON = "";
		String l_request_ref_no = "", l_request_type = "";
		ArrayList<String> l_external_app_details = null;
		Map<String, String> params = new HashMap<String, String>();		
		String l_status = "", l_status_desc = "", l_responseJsonString = "";
		Map<String, Object> l_response_json = new LinkedHashMap<String, Object>();
		ObjectMapper objMapper = new ObjectMapper();		
		Connection dbConn = null;
		CallableStatement cstmt = null;		
		MoheInboundTransaction moheInboundTransaction = new MoheInboundTransaction();
		try{
			
			l_debug_YN = XHUtil.l_debug_YN;

			l_app_msg = " ::: Inside MohePatientVisitBillTransaction TransRequestMethod ::: ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			
			l_app_msg = " ::: Generating Message ID ::: ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_message_id = GenerateMessageIDMethod("XH_IB_MESSAGE_ID_SEQ");

			if (l_message_id.indexOf("Error") >= 0) {
				l_errmsg = "Message ID Generation - " + l_message_id;
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_errmsg + " \"  " + " } ";

				return "200#" + l_response_err_json + "#";
			}
			
			l_app_msg = " ::: Generated Message Id ::: " + l_message_id	+ " ::: Error Code : " + l_errcd + " ::: Error Message : " + l_errmsg;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			if (l_errcd.equals("S")) {
				l_app_msg = "::: Fetching External Application Details : ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

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
					l_errmsg = "Fetching External Application Details - "+ l_application_id;
					l_response_err_json = " { " + " \"status\" : \"0\" , "	+ " \"message\" : \" " + l_errmsg + " \"  " + " } ";

					return "200#" + l_response_err_json + "#";
				}

				l_app_msg = " ::: Message ID : " + l_message_id	+ " ::: External Application : " + l_external_app_details + " ::: Error Code : " + l_errcd + " ::: Error Message : " + l_errmsg;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

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
			params.put("EVENT_TYPE", l_eventType);
			
			l_app_msg = " ::: Action Key :::"+actionKey;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = "::: Parsing input message ::: ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_in_JSON = XHJSONUtil.createJsonObject(actionKey);
			
			if (l_in_JSON.indexOf("Error") >= 0) {
				l_errcd = "E";
				l_errmsg = l_in_JSON;

				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_errmsg + " \"  "+ " } ";				

				return "200#" + l_response_err_json + "#";

			}
			
			l_app_msg = " ::: Getting Request Ref Number from JSON :::";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
	
			l_request_ref_no = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_ref_no");
			if (l_request_ref_no.indexOf("Error") >= 0) {
				l_errcd = "E";
				l_errmsg = "request_ref_no cannot be empty - "+l_request_ref_no;
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_errmsg + " \"  "+ " } ";				

				return "200#" + l_response_err_json + "#";
			}
			
			l_app_msg = " ::: Request Ref Number : " + l_request_ref_no;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
	
			l_app_msg = " ::: Getting Request Type from JSON :::";
			if (l_debug_YN.equals("Y"))		System.out.println(l_app_msg);
	
			l_request_type = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_type");
			if (l_request_type.indexOf("Error") >= 0) {
				l_errcd = "E";
				l_errmsg = "request_type cannot be empty - "+l_request_type;
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_errmsg + " \"  "+ " } ";
				
				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
				moheInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_errmsg);

				return "200#" + l_response_err_json + "#";
			}
			
			l_app_msg = " ::: Getting Facility ID from JSON :::";
			if (l_debug_YN.equals("Y"))		System.out.println(l_app_msg);
					
			l_facility_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "facility_id");
			if (l_facility_id.indexOf("Error") >= 0) {
				l_errcd = "E";
				l_errmsg = "facility_id cannot be empty - "+l_facility_id;
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_errmsg + " \"  "+ " } ";	
				
				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
				moheInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_errmsg);

				return "200#" + l_response_err_json + "#";
			}
			l_app_msg = " ::: Facility ID : " + l_facility_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Getting Patient ID from JSON :::";
			if (l_debug_YN.equals("Y"))		System.out.println(l_app_msg);			
			
			l_patient_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "patient_id");
			if (l_patient_id.indexOf("Error") >= 0) {
				l_errcd = "E";
				l_errmsg = "patient_id cannot be empty - "+l_patient_id;
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_errmsg + " \"  "+ " } ";	
				
				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
				moheInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_errmsg);

				return "200#" + l_response_err_json + "#";
			}
			l_app_msg = " ::: Patient ID : " + l_patient_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Getting Episode Type from JSON :::";
			if (l_debug_YN.equals("Y"))		System.out.println(l_app_msg);
			
			l_episode_type = XHJSONUtil.getJsonRequestString(l_in_JSON, "episode_type");
			if (l_episode_type.indexOf("Error") >= 0) {
				l_errcd = "E";
				l_errmsg = "episode_type cannot be empty - "+l_episode_type;
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_errmsg + " \"  "+ " } ";	
				
				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
				moheInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_errmsg);

				return "200#" + l_response_err_json + "#";
			}
			l_app_msg = " ::: Episode Type : " + l_episode_type;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Getting Episode ID from JSON :::";
			if (l_debug_YN.equals("Y"))		System.out.println(l_app_msg);
			
			l_episode_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "episode_id");
			if (l_episode_id.indexOf("Error") >= 0) {
				l_errcd = "E";
				l_errmsg = "episode_id cannot be empty - "+l_episode_id;
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_errmsg + " \"  "+ " } ";	
				
				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
				moheInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_errmsg);

				return "200#" + l_response_err_json + "#";
			}
			l_app_msg = " ::: Episode ID : " + l_episode_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Getting Visit ID from JSON :::";
			if (l_debug_YN.equals("Y"))		System.out.println(l_app_msg);
			
			l_visit_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "visit_id");
			if (l_visit_id.indexOf("Error") >= 0) {
				l_errcd = "E";
				l_errmsg = "visit_id cannot be empty - "+l_visit_id;
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_errmsg + " \"  "+ " } ";	
				
				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
				moheInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_errmsg);

				return "200#" + l_response_err_json + "#";
			}
			l_app_msg = " ::: Visit ID : " + l_visit_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Getting Cash Counter Code from JSON :::";
			if (l_debug_YN.equals("Y"))		System.out.println(l_app_msg);
			
			l_cash_counter_code = XHJSONUtil.getJsonRequestString(l_in_JSON, "cash_counter_code");
			
			if (l_cash_counter_code.indexOf("Error") >= 0) {
				l_errcd = "E";
				l_errmsg = "cash_counter_code cannot be empty - "+l_cash_counter_code;
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_errmsg + " \"  "+ " } ";	
				
				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
				moheInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_errmsg);

				return "200#" + l_response_err_json + "#";
			}
			
			l_app_msg = " ::: Cash Counter Code : " + l_cash_counter_code;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			
			l_app_msg = " ::: Getting User ID from JSON :::";
			if (l_debug_YN.equals("Y"))		System.out.println(l_app_msg);
			
			l_user_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "user_id");			
			if (l_user_id.indexOf("Error") >= 0) {
				l_errcd = "E";
				l_errmsg = "user_id cannot be empty - "+l_user_id;
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_errmsg + " \"  "+ " } ";	
				
				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
				moheInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_errmsg);

				return "200#" + l_response_err_json + "#";
			}
			
			l_app_msg = " ::: User ID : " + l_user_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Getting WorkStation ID from JSON :::";
			if (l_debug_YN.equals("Y"))		System.out.println(l_app_msg);
			
			l_workstation_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "workstation_id");			
			if (l_workstation_id.indexOf("Error") >= 0) {
				l_errcd = "E";
				l_errmsg = "workstation_id cannot be empty - "+l_workstation_id;
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_errmsg + " \"  "+ " } ";	
				
				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
				moheInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_errmsg);

				return "200#" + l_response_err_json + "#";
			}
			
			l_app_msg = " ::: WorkStation ID : " + l_workstation_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			
			try{
				l_app_msg = " ::: Calling Deposit Refund Check ::: ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				//String CahsCounterLoginCheckQuery = "{ call XBAPI.CASH_COUNTER_LOGIN_CHECK(?,?,?,?,?)}";
				String PatientVisitBillQuery = "{call XBAPI.PATIENT_VISIT_BILL_XBAPI(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				dbConn = EMDataSource.getConnection();
				cstmt = dbConn.prepareCall(PatientVisitBillQuery);
				
				cstmt.setString(1, l_facility_id);
				cstmt.setString(2, l_episode_type);
				cstmt.setInt(3, Integer.parseInt(l_episode_id));
				cstmt.setString(4, l_visit_id);
				cstmt.setString(5, l_patient_id);
				cstmt.setString(6, l_cash_counter_code);
				cstmt.setString(7, l_workstation_id);
				
				cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
				
				cstmt.execute();
				
				l_from_bill_doc_type = cstmt.getString(8);
				l_from_bill_doc_num = cstmt.getString(9);
				l_to_bill_doc_type = cstmt.getString(10);
				l_to_bill_doc_num = cstmt.getString(11);
				p_msg = cstmt.getString(12);
				p_status = cstmt.getString(13);
				
				if(p_status.equals("E")){
					l_errcd = "E";
					l_errmsg = p_msg;
				}
				
				l_app_msg = " ::: User ID  : "+l_user_id+" : msg : "+p_msg+" : status : "+p_status;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				
			}catch (Exception e) {
				e.printStackTrace();
				l_app_msg = " ::: Exception while calling Patient Visit Bill - "+ e.getMessage();
			    if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			    
			    l_errcd = "E";
				l_errmsg = l_app_msg;
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_errmsg + " \"  "+ " } ";
				
				params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
				moheInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_errmsg);

				return "200#" + l_response_err_json + "#";
			}finally{
				XHUtil.closeDBResources(null, cstmt, null);
				EMDataSource.returnConnection(dbConn);
			}
			
			if(l_errcd.equals("S") && !l_user_id.equals("") && l_user_id != null)
			{
				l_status = "1";
				l_status_desc = "Patient Visit Bill details successfully retrieved";
				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				l_response_json.put("from_bill_doc_type", l_from_bill_doc_type);
				l_response_json.put("from_bill_doc_num", l_from_bill_doc_num);
				l_response_json.put("to_bill_doc_type", l_to_bill_doc_type);
				l_response_json.put("to_bill_doc_num", l_to_bill_doc_num);
				
				l_responseJsonString = objMapper.writeValueAsString(l_response_json);
				
				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				moheInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, "");
				
				return "200#"+ l_responseJsonString +"#";
				
			}
			
			if(l_errcd.equals("E")){
				l_status = "0";
				//l_status_desc = "Cash Counter Login Check details retrieved failed";
				l_status_desc = l_errmsg;
				l_response_json.put("request_ref_no", l_request_ref_no);
				l_response_json.put("status", l_status);
				l_response_json.put("status_desc", l_status_desc);
				l_response_json.put("from_bill_doc_type", "");
				l_response_json.put("from_bill_doc_num", "");
				l_response_json.put("to_bill_doc_type", "");
				l_response_json.put("to_bill_doc_num", "");
				
				l_responseJsonString = objMapper.writeValueAsString(l_response_json);
				
				params.put("MESSAGE_ACK_TEXT", l_responseJsonString.toString());
				moheInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, "");
				
				return "200#"+ l_responseJsonString +"#";
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			l_app_msg = " Exception Occurred - "+ e.getMessage();
		    if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		    
		    l_errcd = "E";
			l_errmsg = l_app_msg;
			l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_errmsg + " \"  "+ " } ";
			
			params.put("MESSAGE_ACK_TEXT", l_response_err_json.toString());
			moheInboundTransaction.MessageLoadMethod(actionKey, params, l_errcd, l_errmsg);

			return "200#" + l_response_err_json + "#";
		}
		return l_responseJsonString;
	
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
	
	public static ArrayList<String> FetchExternalAppDetails(String ExternalApplication) {
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "";
		ArrayList<String> externalArray = new ArrayList<String>();

		String l_application_id = "", l_protocol_link_id = "", l_facility_id = "";

		l_app_msg = " ::: Inside FetchExternalAppDetails ::: ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: ExternalApplication : " + ExternalApplication;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

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

			l_app_msg = " ::: Application ID : " + l_application_id	+ " ::: Protocol Link Id : " + l_protocol_link_id + " ::: Facility Id : " + l_facility_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = " ::: Method FetchExternalAppDetails  : " + externalArray;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		} catch (Exception e) {
			l_application_id = "Error in Fetching External Application Details Exception - "+ e.getMessage();
			externalArray.add(l_application_id);
		} finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		return externalArray;
	}

}
